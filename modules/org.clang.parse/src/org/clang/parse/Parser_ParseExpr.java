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

import static org.clank.support.Native.$Deref;
import static org.clank.support.Native.$AddrOf;
import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.java.std.*;
import static org.llvm.support.llvm.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import org.clank.support.NativeCallback.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.ast.*;
import static org.clang.basic.BasicClangGlobals.*;
import org.clang.basic.*;
import org.clang.lex.*;
import org.clang.lex.llvm.*;
import org.clang.sema.*;
import org.clang.parse.*;
import org.clang.parse.impl.*;
import static org.clang.parse.Parser.*;
import static org.clang.sema.SemaClangGlobals.*;
import static org.clang.parse.impl.ParseExprStatics.*;
import org.clang.sema.DeclaratorChunk.ParamInfo;


//<editor-fold defaultstate="collapsed" desc="static type Parser_ParseExpr">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -empty-body -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType -split-class=clang::Parser@this -extends=Parser_ParseDeclCXX ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseExpr.cpp -nm=_ZN5clang6Parser12ParseBlockIdENS_14SourceLocationE;_ZN5clang6Parser15ParseExpressionENS0_13TypeCastStateE;_ZN5clang6Parser19ParseCastExpressionEbbNS0_13TypeCastStateE;_ZN5clang6Parser19ParseCastExpressionEbbRbNS0_13TypeCastStateE;_ZN5clang6Parser19ParseExpressionListERN4llvm15SmallVectorImplIPNS_4ExprEEERNS2_INS_14SourceLocationEEESt8functionIFvvEE;_ZN5clang6Parser19ParseFoldExpressionENS_12ActionResultIPNS_4ExprELb1EEERNS_24BalancedDelimiterTrackerE;_ZN5clang6Parser20ParseObjCBoolLiteralEv;_ZN5clang6Parser20ParseParenExpressionERNS0_16ParenParseOptionEbbRNS_9OpaquePtrINS_8QualTypeEEERNS_14SourceLocationE;_ZN5clang6Parser20isNotExpressionStartEv;_ZN5clang6Parser21ParseAvailabilitySpecEv;_ZN5clang6Parser23ParseConstantExpressionENS0_13TypeCastStateE;_ZN5clang6Parser25ParseAssignmentExpressionENS0_13TypeCastStateE;_ZN5clang6Parser25ParseConstraintExpressionEv;_ZN5clang6Parser25ParseSimpleExpressionListERN4llvm15SmallVectorImplIPNS_4ExprEEERNS2_INS_14SourceLocationEEE;_ZN5clang6Parser26ParseAvailabilityCheckExprENS_14SourceLocationE;_ZN5clang6Parser26ParseRHSOfBinaryExpressionENS_12ActionResultIPNS_4ExprELb1EEENS_4prec5LevelE;_ZN5clang6Parser27ParseBlockLiteralExpressionEv;_ZN5clang6Parser28ParseExpressionWithLeadingAtENS_14SourceLocationE;_ZN5clang6Parser28ParsePostfixExpressionSuffixENS_12ActionResultIPNS_4ExprELb1EEE;_ZN5clang6Parser28ParseStringLiteralExpressionEb;_ZN5clang6Parser29ParseBuiltinPrimaryExpressionEv;_ZN5clang6Parser30ParseCompoundLiteralExpressionENS_9OpaquePtrINS_8QualTypeEEENS_14SourceLocationES4_;_ZN5clang6Parser31ParseGenericSelectionExpressionEv;_ZN5clang6Parser34ParseExprAfterUnaryExprOrTypeTraitERKNS_5TokenERbRNS_9OpaquePtrINS_8QualTypeEEERNS_11SourceRangeE;_ZN5clang6Parser35ParseExpressionWithLeadingExtensionENS_14SourceLocationE;_ZN5clang6Parser35ParseUnaryExprOrTypeTraitExpressionEv;_ZN5clang6Parser43ParseAssignmentExprWithObjCMessageExprStartENS_14SourceLocationES1_NS_9OpaquePtrINS_8QualTypeEEEPNS_4ExprE; -static-type=Parser_ParseExpr -package=org.clang.parse")
//</editor-fold>
public class Parser_ParseExpr extends Parser_ParseDeclCXX {
private final /*split clang::Parser*/ Parser $this() { return (Parser)this; }


/// \brief Simple precedence-based parser for binary/ternary operators.
///
/// Note: we diverge from the C99 grammar when parsing the assignment-expression
/// production.  C99 specifies that the LHS of an assignment operator should be
/// parsed as a unary-expression, but consistency dictates that it be a
/// conditional-expession.  In practice, the important thing here is that the
/// LHS of an assignment has to be an l-value, which productions between
/// unary-expression and conditional-expression don't produce.  Because we want
/// consistency, we parse the LHS as a conditional-expression, then check for
/// l-value-ness in semantic analysis stages.
///
/// \verbatim
///       pm-expression: [C++ 5.5]
///         cast-expression
///         pm-expression '.*' cast-expression
///         pm-expression '->*' cast-expression
///
///       multiplicative-expression: [C99 6.5.5]
///     Note: in C++, apply pm-expression instead of cast-expression
///         cast-expression
///         multiplicative-expression '*' cast-expression
///         multiplicative-expression '/' cast-expression
///         multiplicative-expression '%' cast-expression
///
///       additive-expression: [C99 6.5.6]
///         multiplicative-expression
///         additive-expression '+' multiplicative-expression
///         additive-expression '-' multiplicative-expression
///
///       shift-expression: [C99 6.5.7]
///         additive-expression
///         shift-expression '<<' additive-expression
///         shift-expression '>>' additive-expression
///
///       relational-expression: [C99 6.5.8]
///         shift-expression
///         relational-expression '<' shift-expression
///         relational-expression '>' shift-expression
///         relational-expression '<=' shift-expression
///         relational-expression '>=' shift-expression
///
///       equality-expression: [C99 6.5.9]
///         relational-expression
///         equality-expression '==' relational-expression
///         equality-expression '!=' relational-expression
///
///       AND-expression: [C99 6.5.10]
///         equality-expression
///         AND-expression '&' equality-expression
///
///       exclusive-OR-expression: [C99 6.5.11]
///         AND-expression
///         exclusive-OR-expression '^' AND-expression
///
///       inclusive-OR-expression: [C99 6.5.12]
///         exclusive-OR-expression
///         inclusive-OR-expression '|' exclusive-OR-expression
///
///       logical-AND-expression: [C99 6.5.13]
///         inclusive-OR-expression
///         logical-AND-expression '&&' inclusive-OR-expression
///
///       logical-OR-expression: [C99 6.5.14]
///         logical-AND-expression
///         logical-OR-expression '||' logical-AND-expression
///
///       conditional-expression: [C99 6.5.15]
///         logical-OR-expression
///         logical-OR-expression '?' expression ':' conditional-expression
/// [GNU]   logical-OR-expression '?' ':' conditional-expression
/// [C++] the third operand is an assignment-expression
///
///       assignment-expression: [C99 6.5.16]
///         conditional-expression
///         unary-expression assignment-operator assignment-expression
/// [C++]   throw-expression [C++ 15]
///
///       assignment-operator: one of
///         = *= /= %= += -= <<= >>= &= ^= |=
///
///       expression: [C99 6.5.17]
///         assignment-expression ...[opt]
///         expression ',' assignment-expression ...[opt]
/// \endverbatim
//<editor-fold defaultstate="collapsed" desc="clang::Parser::ParseExpression">
@Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseExpr.cpp", line = 120,
   FQN="clang::Parser::ParseExpression", NM="_ZN5clang6Parser15ParseExpressionENS0_13TypeCastStateE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseExpr.cpp -nm=_ZN5clang6Parser15ParseExpressionENS0_13TypeCastStateE")
  //</editor-fold>
  public ActionResultTTrue<Expr /*P*/ > ParseExpression() {
    return $this().ParseExpression(TypeCastState.NotTypeCast);
  }
  public ActionResultTTrue<Expr /*P*/ > ParseExpression(TypeCastState isTypeCast/*= NotTypeCast*/) {
    ActionResultTTrue<Expr /*P*/ > LHS/*J*/= $this().ParseAssignmentExpression(isTypeCast);
    return $this().ParseRHSOfBinaryExpression(new ActionResultTTrue<Expr /*P*/ >(LHS), prec.Level.Comma);
  }

//<editor-fold defaultstate="collapsed" desc="clang::Parser::ParseConstantExpression">
@Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseExpr.cpp", line = 197,
   FQN="clang::Parser::ParseConstantExpression", NM="_ZN5clang6Parser23ParseConstantExpressionENS0_13TypeCastStateE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseExpr.cpp -nm=_ZN5clang6Parser23ParseConstantExpressionENS0_13TypeCastStateE")
  //</editor-fold>
  public ActionResultTTrue<Expr /*P*/ > ParseConstantExpression() {
    return $this().ParseConstantExpression(TypeCastState.NotTypeCast);
  }
  public ActionResultTTrue<Expr /*P*/ > ParseConstantExpression(TypeCastState isTypeCast/*= NotTypeCast*/) {
    EnterExpressionEvaluationContext Unevaluated = null;
    try {
      // C++03 [basic.def.odr]p2:
      //   An expression is potentially evaluated unless it appears where an
      //   integral constant expression is required (see 5.19) [...].
      // C++98 and C++11 have no such rule, but this is only a defect in C++98.
      Unevaluated/*J*/= new EnterExpressionEvaluationContext($this().Actions, 
          Sema.ExpressionEvaluationContext.ConstantEvaluated);
      
      ActionResultTTrue<Expr /*P*/ > LHS/*J*/= $this().ParseCastExpression(false, false, isTypeCast);
      ActionResultTTrue<Expr /*P*/ > Res/*J*/= $this().ParseRHSOfBinaryExpression(new ActionResultTTrue<Expr /*P*/ >(LHS), prec.Level.Conditional);
      return $this().Actions.ActOnConstantExpression(new ActionResultTTrue<Expr /*P*/ >(Res));
    } finally {
      if (Unevaluated != null) { Unevaluated.$destroy(); }
    }
  }


/// \brief Parse a constraint-expression.
///
/// \verbatim
///       constraint-expression: [Concepts TS temp.constr.decl p1]
///         logical-or-expression
/// \endverbatim
//<editor-fold defaultstate="collapsed" desc="clang::Parser::ParseConstraintExpression">
@Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseExpr.cpp", line = 216,
   FQN="clang::Parser::ParseConstraintExpression", NM="_ZN5clang6Parser25ParseConstraintExpressionEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseExpr.cpp -nm=_ZN5clang6Parser25ParseConstraintExpressionEv")
  //</editor-fold>
  public ActionResultTTrue<Expr /*P*/ > ParseConstraintExpression() {
    // FIXME: this may erroneously consume a function-body as the braced
    // initializer list of a compound literal
    //
    // FIXME: this may erroneously consume a parenthesized rvalue reference
    // declarator as a parenthesized address-of-label expression
    ActionResultTTrue<Expr /*P*/ > LHS/*J*/= $this().ParseCastExpression(/*isUnaryExpression=*/ false);
    ActionResultTTrue<Expr /*P*/ > Res/*J*/= $this().ParseRHSOfBinaryExpression(new ActionResultTTrue<Expr /*P*/ >(LHS), prec.Level.LogicalOr);
    
    return Res;
  }

// Expr that doesn't include commas.

/// \brief Parse an expr that doesn't include (top-level) commas.
//<editor-fold defaultstate="collapsed" desc="clang::Parser::ParseAssignmentExpression">
@Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseExpr.cpp", line = 157,
   FQN="clang::Parser::ParseAssignmentExpression", NM="_ZN5clang6Parser25ParseAssignmentExpressionENS0_13TypeCastStateE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseExpr.cpp -nm=_ZN5clang6Parser25ParseAssignmentExpressionENS0_13TypeCastStateE")
  //</editor-fold>
  public ActionResultTTrue<Expr /*P*/ > ParseAssignmentExpression() {
    return $this().ParseAssignmentExpression(TypeCastState.NotTypeCast);
  }
  public ActionResultTTrue<Expr /*P*/ > ParseAssignmentExpression(TypeCastState isTypeCast/*= NotTypeCast*/) {
    if ($this().Tok.is(tok.TokenKind.code_completion)) {
      $this().Actions.CodeCompleteOrdinaryName($this().getCurScope(), Sema.ParserCompletionContext.PCC_Expression);
      $this().cutOffParsing();
      return ExprError();
    }
    if ($this().Tok.is(tok.TokenKind.kw_throw)) {
      return $this().ParseThrowExpression();
    }
    if ($this().Tok.is(tok.TokenKind.kw_co_yield)) {
      return $this().ParseCoyieldExpression();
    }
    
    ActionResultTTrue<Expr /*P*/ > LHS = $this().ParseCastExpression(/*isUnaryExpression=*/ false, 
        /*isAddressOfOperand=*/ false, 
        isTypeCast);
    return $this().ParseRHSOfBinaryExpression(new ActionResultTTrue<Expr /*P*/ >(LHS), prec.Level.Assignment);
  }


/// This routine is called when the '@' is seen and consumed.
/// Current token is an Identifier and is not a 'try'. This
/// routine is necessary to disambiguate \@try-statement from,
/// for example, \@encode-expression.
///
//<editor-fold defaultstate="collapsed" desc="clang::Parser::ParseExpressionWithLeadingAt">
@Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseExpr.cpp", line = 130,
   FQN="clang::Parser::ParseExpressionWithLeadingAt", NM="_ZN5clang6Parser28ParseExpressionWithLeadingAtENS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseExpr.cpp -nm=_ZN5clang6Parser28ParseExpressionWithLeadingAtENS_14SourceLocationE")
  //</editor-fold>
  protected /*private*/ ActionResultTTrue<Expr /*P*/ > ParseExpressionWithLeadingAt(SourceLocation AtLoc) {
    ActionResultTTrue<Expr /*P*/ > LHS/*J*/= $this().ParseObjCAtExpression(new SourceLocation(AtLoc));
    return $this().ParseRHSOfBinaryExpression(new ActionResultTTrue<Expr /*P*/ >(LHS), prec.Level.Comma);
  }


/// This routine is called when a leading '__extension__' is seen and
/// consumed.  This is necessary because the token gets consumed in the
/// process of disambiguating between an expression and a declaration.
//<editor-fold defaultstate="collapsed" desc="clang::Parser::ParseExpressionWithLeadingExtension">
@Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseExpr.cpp", line = 139,
   FQN="clang::Parser::ParseExpressionWithLeadingExtension", NM="_ZN5clang6Parser35ParseExpressionWithLeadingExtensionENS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseExpr.cpp -nm=_ZN5clang6Parser35ParseExpressionWithLeadingExtensionENS_14SourceLocationE")
  //</editor-fold>
  protected /*private*/ ActionResultTTrue<Expr /*P*/ > ParseExpressionWithLeadingExtension(SourceLocation ExtLoc) {
    ActionResultTTrue<Expr /*P*/ > LHS/*J*/= new ActionResultTTrue<Expr /*P*/ >(true);
    {
      ExtensionRAIIObject O = null;
      try {
        // Silence extension warnings in the sub-expression
        O/*J*/= new ExtensionRAIIObject($this().Diags);
        
        LHS.$assignMove($this().ParseCastExpression(false));
      } finally {
        if (O != null) { O.$destroy(); }
      }
    }
    if (!LHS.isInvalid()) {
      LHS.$assignMove($this().Actions.ActOnUnaryOp($this().getCurScope(), new SourceLocation(ExtLoc), tok.TokenKind.kw___extension__, 
              LHS.get()));
    }
    
    return $this().ParseRHSOfBinaryExpression(new ActionResultTTrue<Expr /*P*/ >(LHS), prec.Level.Comma);
  }


/// \brief Parse a binary expression that starts with \p LHS and has a
/// precedence of at least \p MinPrec.
//<editor-fold defaultstate="collapsed" desc="clang::Parser::ParseRHSOfBinaryExpression">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   optimized = Converted.Optimization.VALUE_TYPE,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseExpr.cpp", line = 248,
   FQN="clang::Parser::ParseRHSOfBinaryExpression", NM="_ZN5clang6Parser26ParseRHSOfBinaryExpressionENS_12ActionResultIPNS_4ExprELb1EEENS_4prec5LevelE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseExpr.cpp -nm=_ZN5clang6Parser26ParseRHSOfBinaryExpressionENS_12ActionResultIPNS_4ExprELb1EEENS_4prec5LevelE")
  //</editor-fold>
  protected /*private*/ ActionResultTTrue<Expr /*P*/ > ParseRHSOfBinaryExpression(ActionResultTTrue<Expr /*P*/ > LHS, prec.Level MinPrec) {
    prec.Level NextTokPrec = getBinOpPrecedence($this().Tok.getKind(), 
        $this().GreaterThanIsOperator, 
        $this().getLangOpts().CPlusPlus11);
    SourceLocation ColonLoc/*J*/= new SourceLocation();
    while (true) {
      // If this token has a lower precedence than we are allowed to parse (e.g.
      // because we are called recursively, or because the token is not a binop),
      // then we are done!
      if (NextTokPrec.getValue() < MinPrec.getValue()) {
        return new ActionResultTTrue<Expr /*P*/ >(JD$Move.INSTANCE, LHS);
      }
      
      // Consume the operator, saving the operator token for error reporting.
      Token OpToken = new Token($this().Tok);
      $this().ConsumeToken();
      if (OpToken.is(tok.TokenKind.caretcaret)) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          return $c$.clean(ExprError($c$.track($this().Diag($this().Tok, diag.err_opencl_logical_exclusive_or))));
        } finally {
          $c$.$destroy();
        }
      }
      // Bail out when encountering a comma followed by a token which can't
      // possibly be the start of an expression. For instance:
      //   int f() { return 1, }
      // We can't do this before consuming the comma, because
      // isNotExpressionStart() looks at the token stream.
      if (OpToken.is(tok.TokenKind.comma) && $this().isNotExpressionStart()) {
        $this().PP.EnterToken($this().Tok);
        $this().Tok.$assign(OpToken);
        return new ActionResultTTrue<Expr /*P*/ >(JD$Move.INSTANCE, LHS);
      }
      
      // If the next token is an ellipsis, then this is a fold-expression. Leave
      // it alone so we can handle it in the paren expression.
      if (isFoldOperator_Level(NextTokPrec) && $this().Tok.is(tok.TokenKind.ellipsis)) {
        // FIXME: We can't check this via lookahead before we consume the token
        // because that tickles a lexer bug.
        $this().PP.EnterToken($this().Tok);
        $this().Tok.$assign(OpToken);
        return new ActionResultTTrue<Expr /*P*/ >(JD$Move.INSTANCE, LHS);
      }
      
      // Special case handling for the ternary operator.
      ActionResultTTrue<Expr /*P*/ > TernaryMiddle/*J*/= new ActionResultTTrue<Expr /*P*/ >(true);
      if (NextTokPrec == prec.Level.Conditional) {
        if ($this().Tok.isNot(tok.TokenKind.colon)) {
          ColonProtectionRAIIObject X = null;
          try {
            // Don't parse FOO:BAR as if it were a typo for FOO::BAR.
            X/*J*/= new ColonProtectionRAIIObject(/*Deref*/$this());
            
            // Handle this production specially:
            //   logical-OR-expression '?' expression ':' conditional-expression
            // In particular, the RHS of the '?' is 'expression', not
            // 'logical-OR-expression' as we might expect.
            TernaryMiddle.$assignMove($this().ParseExpression());
            if (TernaryMiddle.isInvalid()) {
              $this().Actions.CorrectDelayedTyposInExpr(new ActionResultTTrue<Expr /*P*/ >(LHS));
              LHS.$assignMove(ExprError());
              TernaryMiddle.$assign((Expr /*P*/ )null);
            }
          } finally {
            if (X != null) { X.$destroy(); }
          }
        } else {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            // Special case handling of "X ? Y : Z" where Y is empty:
            //   logical-OR-expression '?' ':' conditional-expression   [GNU]
            TernaryMiddle.$assign((Expr /*P*/ )null);
            $c$.clean($c$.track($this().Diag($this().Tok, diag.ext_gnu_conditional_expr)));
          } finally {
            $c$.$destroy();
          }
        }
        if (!$this().TryConsumeToken(tok.TokenKind.colon, ColonLoc)) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            // Otherwise, we're missing a ':'.  Assume that this was a typo that
            // the user forgot. If we're not in a macro expansion, we can suggest
            // a fixit hint. If there were two spaces before the current token,
            // suggest inserting the colon in between them, otherwise insert ": ".
            SourceLocation FILoc = $this().Tok.getLocation();
            /*const*/char$ptr/*char P*/ FIText = $(": ");
            final /*const*/ SourceManager /*&*/ SM = $this().PP.getSourceManager();
            if (FILoc.isFileID() || $this().PP.isAtStartOfMacroExpansion(/*NO_COPY*/FILoc, $AddrOf(FILoc))) {
              assert (FILoc.isFileID());
              bool$ptr IsInvalid = create_bool$ptr(false);
              /*const char$ptr*/byte SourcePtr$star = $tryClone(SM.getCharacterData_FirstChar(SourceLocation.$getLocWithOffset(FILoc.getRawEncoding(), -1), $AddrOf(IsInvalid)));
              if (!IsInvalid.$star() && SourcePtr$star == $$SPACE) {
                SourcePtr$star = $tryClone(SM.getCharacterData_FirstChar(SourceLocation.$getLocWithOffset(FILoc.getRawEncoding(), -2), $AddrOf(IsInvalid)));
                if (!IsInvalid.$star() && SourcePtr$star == $$SPACE) {
                  FILoc.$assignMove(FILoc.getLocWithOffset(-1));
                  FIText = $tryClone($COLON);
                }
              }
            }
            
            $c$.clean($out_DiagnosticBuilder$C_FixItHint$C($out_DiagnosticBuilder$C_TokenKind($c$.track($this().Diag($this().Tok, diag.err_expected)), 
                    tok.TokenKind.colon), FixItHint.CreateInsertion(/*NO_COPY*/FILoc, new StringRef(FIText))));
            $c$.clean($out_DiagnosticBuilder$C_TokenKind($c$.track($this().Diag(OpToken, diag.note_matching)), tok.TokenKind.question));
            ColonLoc.$assignMove($this().Tok.getLocation());
          } finally {
            $c$.$destroy();
          }
        }
      }
      
      // Code completion for the right-hand side of an assignment expression
      // goes through a special hook that takes the left-hand side into account.
      if ($this().Tok.is(tok.TokenKind.code_completion) && NextTokPrec == prec.Level.Assignment) {
        $this().Actions.CodeCompleteAssignmentRHS($this().getCurScope(), LHS.get());
        $this().cutOffParsing();
        return ExprError();
      }
      
      // Parse another leaf here for the RHS of the operator.
      // ParseCastExpression works here because all RHS expressions in C have it
      // as a prefix, at least. However, in C++, an assignment-expression could
      // be a throw-expression, which is not a valid cast-expression.
      // Therefore we need some special-casing here.
      // Also note that the third operand of the conditional operator is
      // an assignment-expression in C++, and in C++11, we can have a
      // braced-init-list on the RHS of an assignment. For better diagnostics,
      // parse as if we were allowed braced-init-lists everywhere, and check that
      // they only appear on the RHS of assignments later.
      ActionResultTTrue<Expr /*P*/ > RHS/*J*/= new ActionResultTTrue<Expr /*P*/ >();
      boolean RHSIsInitList = false;
      if ($this().getLangOpts().CPlusPlus11 && $this().Tok.is(tok.TokenKind.l_brace)) {
        RHS.$assignMove($this().ParseBraceInitializer());
        RHSIsInitList = true;
      } else if ($this().getLangOpts().CPlusPlus && NextTokPrec.getValue() <= prec.Level.Conditional.getValue()) {
        RHS.$assignMove($this().ParseAssignmentExpression());
      } else {
        RHS.$assignMove($this().ParseCastExpression(false));
      }
      if (RHS.isInvalid()) {
        // FIXME: Errors generated by the delayed typo correction should be
        // printed before errors from parsing the RHS, not after.
        $this().Actions.CorrectDelayedTyposInExpr(new ActionResultTTrue<Expr /*P*/ >(LHS));
        if (TernaryMiddle.isUsable()) {
          TernaryMiddle.$assignMove($this().Actions.CorrectDelayedTyposInExpr(new ActionResultTTrue<Expr /*P*/ >(TernaryMiddle)));
        }
        LHS.$assignMove(ExprError());
      }
      
      // Remember the precedence of this operator and get the precedence of the
      // operator immediately to the right of the RHS.
      prec.Level ThisPrec = NextTokPrec;
      NextTokPrec = getBinOpPrecedence($this().Tok.getKind(), $this().GreaterThanIsOperator, 
          $this().getLangOpts().CPlusPlus11);
      
      // Assignment and conditional expressions are right-associative.
      boolean isRightAssoc = ThisPrec == prec.Level.Conditional
         || ThisPrec == prec.Level.Assignment;
      
      // Get the precedence of the operator to the right of the RHS.  If it binds
      // more tightly with RHS than we do, evaluate it completely first.
      if (ThisPrec.getValue() < NextTokPrec.getValue()
         || (ThisPrec == NextTokPrec && isRightAssoc)) {
        if (!RHS.isInvalid() && RHSIsInitList) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            $c$.clean($out_DiagnosticBuilder$C_SourceRange($out_DiagnosticBuilder$C_StringRef($out_DiagnosticBuilder$C_int($c$.track($this().Diag($this().Tok, diag.err_init_list_bin_op)), 
                        /*LHS*/ 0), new StringRef($this().PP.getSpelling($this().Tok))), $this().Actions.getExprRange(RHS.get())));
            RHS.$assignMove(ExprError());
          } finally {
            $c$.$destroy();
          }
        }
        // If this is left-associative, only parse things on the RHS that bind
        // more tightly than the current operator.  If it is left-associative, it
        // is okay, to bind exactly as tightly.  For example, compile A=B=C=D as
        // A=(B=(C=D)), where each paren is a level of recursion here.
        // The function takes ownership of the RHS.
        RHS.$assignMove($this().ParseRHSOfBinaryExpression(new ActionResultTTrue<Expr /*P*/ >(RHS), 
                /*static_cast*/prec.Level.valueOf(ThisPrec.getValue() + ((!isRightAssoc) ? 1 : 0))));
        RHSIsInitList = false;
        if (RHS.isInvalid()) {
          // FIXME: Errors generated by the delayed typo correction should be
          // printed before errors from ParseRHSOfBinaryExpression, not after.
          $this().Actions.CorrectDelayedTyposInExpr(new ActionResultTTrue<Expr /*P*/ >(LHS));
          if (TernaryMiddle.isUsable()) {
            TernaryMiddle.$assignMove($this().Actions.CorrectDelayedTyposInExpr(new ActionResultTTrue<Expr /*P*/ >(TernaryMiddle)));
          }
          LHS.$assignMove(ExprError());
        }
        
        NextTokPrec = getBinOpPrecedence($this().Tok.getKind(), $this().GreaterThanIsOperator, 
            $this().getLangOpts().CPlusPlus11);
      }
      if (!RHS.isInvalid() && RHSIsInitList) {
        if (ThisPrec == prec.Level.Assignment) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            $c$.clean($out_DiagnosticBuilder$C_SourceRange($c$.track($this().Diag(OpToken, diag.warn_cxx98_compat_generalized_initializer_lists)), 
                $this().Actions.getExprRange(RHS.get())));
          } finally {
            $c$.$destroy();
          }
        } else {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            $c$.clean($out_DiagnosticBuilder$C_SourceRange($out_DiagnosticBuilder$C_StringRef($out_DiagnosticBuilder$C_int($c$.track($this().Diag(OpToken, diag.err_init_list_bin_op)), 
                        /*RHS*/ 1), new StringRef($this().PP.getSpelling(OpToken))), 
                $this().Actions.getExprRange(RHS.get())));
            LHS.$assignMove(ExprError());
          } finally {
            $c$.$destroy();
          }
        }
      }
      
      ActionResultTTrue<Expr /*P*/ > OrigLHS = new ActionResultTTrue<Expr /*P*/ >(LHS);
      if (!LHS.isInvalid()) {
        // Combine the LHS and RHS into the LHS (e.g. build AST).
        if (TernaryMiddle.isInvalid()) {
          // If we're using '>>' as an operator within a template
          // argument list (in C++98), suggest the addition of
          // parentheses so that the code remains well-formed in C++0x.
          if (!$this().GreaterThanIsOperator && OpToken.is(tok.TokenKind.greatergreater)) {
            $this().SuggestParentheses(OpToken.getLocation(), 
                diag.warn_cxx11_right_shift_in_template_arg, 
                new SourceRange($this().Actions.getExprRange(LHS.get()).getBegin(), 
                    $this().Actions.getExprRange(RHS.get()).getEnd()));
          }
          
          LHS.$assignMove($this().Actions.ActOnBinOp($this().getCurScope(), OpToken.getLocation(), 
                  OpToken.getKind(), LHS.get(), RHS.get()));
        } else {
          LHS.$assignMove($this().Actions.ActOnConditionalOp(OpToken.getLocation(), new SourceLocation(ColonLoc), 
                  LHS.get(), TernaryMiddle.get(), 
                  RHS.get()));
        }
        // In this case, ActOnBinOp or ActOnConditionalOp performed the
        // CorrectDelayedTyposInExpr check.
        if (!$this().getLangOpts().CPlusPlus) {
          continue;
        }
      }
      // Ensure potential typos aren't left undiagnosed.
      if (LHS.isInvalid()) {
        $this().Actions.CorrectDelayedTyposInExpr(new ActionResultTTrue<Expr /*P*/ >(OrigLHS));
        $this().Actions.CorrectDelayedTyposInExpr(new ActionResultTTrue<Expr /*P*/ >(TernaryMiddle));
        $this().Actions.CorrectDelayedTyposInExpr(new ActionResultTTrue<Expr /*P*/ >(RHS));
      }
    }
  }


/// \brief Parse a cast-expression, or, if \pisUnaryExpression is true, parse
/// a unary-expression.
///
/// \p isAddressOfOperand exists because an id-expression that is the operand
/// of address-of gets special treatment due to member pointers. NotCastExpr
/// is set to true if the token is not the start of a cast-expression, and no
/// diagnostic is emitted in this case and no tokens are consumed.
///
/// \verbatim
///       cast-expression: [C99 6.5.4]
///         unary-expression
///         '(' type-name ')' cast-expression
///
///       unary-expression:  [C99 6.5.3]
///         postfix-expression
///         '++' unary-expression
///         '--' unary-expression
/// [Coro]  'co_await' cast-expression
///         unary-operator cast-expression
///         'sizeof' unary-expression
///         'sizeof' '(' type-name ')'
/// [C++11] 'sizeof' '...' '(' identifier ')'
/// [GNU]   '__alignof' unary-expression
/// [GNU]   '__alignof' '(' type-name ')'
/// [C11]   '_Alignof' '(' type-name ')'
/// [C++11] 'alignof' '(' type-id ')'
/// [GNU]   '&&' identifier
/// [C++11] 'noexcept' '(' expression ')' [C++11 5.3.7]
/// [C++]   new-expression
/// [C++]   delete-expression
///
///       unary-operator: one of
///         '&'  '*'  '+'  '-'  '~'  '!'
/// [GNU]   '__extension__'  '__real'  '__imag'
///
///       primary-expression: [C99 6.5.1]
/// [C99]   identifier
/// [C++]   id-expression
///         constant
///         string-literal
/// [C++]   boolean-literal  [C++ 2.13.5]
/// [C++11] 'nullptr'        [C++11 2.14.7]
/// [C++11] user-defined-literal
///         '(' expression ')'
/// [C11]   generic-selection
///         '__func__'        [C99 6.4.2.2]
/// [GNU]   '__FUNCTION__'
/// [MS]    '__FUNCDNAME__'
/// [MS]    'L__FUNCTION__'
/// [GNU]   '__PRETTY_FUNCTION__'
/// [GNU]   '(' compound-statement ')'
/// [GNU]   '__builtin_va_arg' '(' assignment-expression ',' type-name ')'
/// [GNU]   '__builtin_offsetof' '(' type-name ',' offsetof-member-designator')'
/// [GNU]   '__builtin_choose_expr' '(' assign-expr ',' assign-expr ','
///                                     assign-expr ')'
/// [GNU]   '__builtin_types_compatible_p' '(' type-name ',' type-name ')'
/// [GNU]   '__null'
/// [OBJC]  '[' objc-message-expr ']'
/// [OBJC]  '\@selector' '(' objc-selector-arg ')'
/// [OBJC]  '\@protocol' '(' identifier ')'
/// [OBJC]  '\@encode' '(' type-name ')'
/// [OBJC]  objc-string-literal
/// [C++]   simple-type-specifier '(' expression-list[opt] ')'      [C++ 5.2.3]
/// [C++11] simple-type-specifier braced-init-list                  [C++11 5.2.3]
/// [C++]   typename-specifier '(' expression-list[opt] ')'         [C++ 5.2.3]
/// [C++11] typename-specifier braced-init-list                     [C++11 5.2.3]
/// [C++]   'const_cast' '<' type-name '>' '(' expression ')'       [C++ 5.2p1]
/// [C++]   'dynamic_cast' '<' type-name '>' '(' expression ')'     [C++ 5.2p1]
/// [C++]   'reinterpret_cast' '<' type-name '>' '(' expression ')' [C++ 5.2p1]
/// [C++]   'static_cast' '<' type-name '>' '(' expression ')'      [C++ 5.2p1]
/// [C++]   'typeid' '(' expression ')'                             [C++ 5.2p1]
/// [C++]   'typeid' '(' type-id ')'                                [C++ 5.2p1]
/// [C++]   'this'          [C++ 9.3.2]
/// [G++]   unary-type-trait '(' type-id ')'
/// [G++]   binary-type-trait '(' type-id ',' type-id ')'           [TODO]
/// [EMBT]  array-type-trait '(' type-id ',' integer ')'
/// [clang] '^' block-literal
///
///       constant: [C99 6.4.4]
///         integer-constant
///         floating-constant
///         enumeration-constant -> identifier
///         character-constant
///
///       id-expression: [C++ 5.1]
///                   unqualified-id
///                   qualified-id          
///
///       unqualified-id: [C++ 5.1]
///                   identifier
///                   operator-function-id
///                   conversion-function-id
///                   '~' class-name        
///                   template-id           
///
///       new-expression: [C++ 5.3.4]
///                   '::'[opt] 'new' new-placement[opt] new-type-id
///                                     new-initializer[opt]
///                   '::'[opt] 'new' new-placement[opt] '(' type-id ')'
///                                     new-initializer[opt]
///
///       delete-expression: [C++ 5.3.5]
///                   '::'[opt] 'delete' cast-expression
///                   '::'[opt] 'delete' '[' ']' cast-expression
///
/// [GNU/Embarcadero] unary-type-trait:
///                   '__is_arithmetic'
///                   '__is_floating_point'
///                   '__is_integral'
///                   '__is_lvalue_expr'
///                   '__is_rvalue_expr'
///                   '__is_complete_type'
///                   '__is_void'
///                   '__is_array'
///                   '__is_function'
///                   '__is_reference'
///                   '__is_lvalue_reference'
///                   '__is_rvalue_reference'
///                   '__is_fundamental'
///                   '__is_object'
///                   '__is_scalar'
///                   '__is_compound'
///                   '__is_pointer'
///                   '__is_member_object_pointer'
///                   '__is_member_function_pointer'
///                   '__is_member_pointer'
///                   '__is_const'
///                   '__is_volatile'
///                   '__is_trivial'
///                   '__is_standard_layout'
///                   '__is_signed'
///                   '__is_unsigned'
///
/// [GNU] unary-type-trait:
///                   '__has_nothrow_assign'
///                   '__has_nothrow_copy'
///                   '__has_nothrow_constructor'
///                   '__has_trivial_assign'                  [TODO]
///                   '__has_trivial_copy'                    [TODO]
///                   '__has_trivial_constructor'
///                   '__has_trivial_destructor'
///                   '__has_virtual_destructor'
///                   '__is_abstract'                         [TODO]
///                   '__is_class'
///                   '__is_empty'                            [TODO]
///                   '__is_enum'
///                   '__is_final'
///                   '__is_pod'
///                   '__is_polymorphic'
///                   '__is_sealed'                           [MS]
///                   '__is_trivial'
///                   '__is_union'
///
/// [Clang] unary-type-trait:
///                   '__trivially_copyable'
///
///       binary-type-trait:
/// [GNU]             '__is_base_of'       
/// [MS]              '__is_convertible_to'
///                   '__is_convertible'
///                   '__is_same'
///
/// [Embarcadero] array-type-trait:
///                   '__array_rank'
///                   '__array_extent'
///
/// [Embarcadero] expression-trait:
///                   '__is_lvalue_expr'
///                   '__is_rvalue_expr'
/// \endverbatim
///
//<editor-fold defaultstate="collapsed" desc="clang::Parser::ParseCastExpression">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseExpr.cpp", line = 695,
   FQN="clang::Parser::ParseCastExpression", NM="_ZN5clang6Parser19ParseCastExpressionEbbRbNS0_13TypeCastStateE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseExpr.cpp -nm=_ZN5clang6Parser19ParseCastExpressionEbbRbNS0_13TypeCastStateE")
  //</editor-fold>
  protected /*private*/ ActionResultTTrue<Expr /*P*/ > ParseCastExpression(boolean isUnaryExpression, 
                     boolean isAddressOfOperand, 
                     final bool$ref/*bool &*/ NotCastExpr, 
                     TypeCastState isTypeCast) {
    ActionResultTTrue<Expr /*P*/ > Res/*J*/= new ActionResultTTrue<Expr /*P*/ >();
    /*tok.TokenKind*/char SavedKind = $this().Tok.getKind();
    NotCastExpr.$set(false);
    
    // This handles all of cast-expression, unary-expression, postfix-expression,
    // and primary-expression.  We handle them together like this for efficiency
    // and to simplify handling of an expression starting with a '(' token: which
    // may be one of a parenthesized expression, cast-expression, compound literal
    // expression, or statement expression.
    //
    // If the parsed tokens consist of a primary-expression, the cases below
    // break out of the switch;  at the end we call ParsePostfixExpressionSuffix
    // to handle the postfix expression suffixes.  Cases that cannot be followed
    // by postfix exprs should return without invoking
    // ParsePostfixExpressionSuffix.
    switch (SavedKind) {
     case tok.TokenKind.l_paren:
      {
        // If this expression is limited to being a unary-expression, the parent can
        // not start a cast expression.
        type$ref<ParenParseOption> ParenExprType = create_type$ref((isUnaryExpression && !$this().getLangOpts().CPlusPlus) ? ParenParseOption.CompoundLiteral : ParenParseOption.CastExpr);
        OpaquePtr<QualType> CastTy/*J*/= new OpaquePtr<QualType>();
        SourceLocation RParenLoc/*J*/= new SourceLocation();
        Res.$assignMove($this().ParseParenExpression(ParenExprType, false/*stopIfCastExr*/, 
                isTypeCast == TypeCastState.IsTypeCast, CastTy, RParenLoc));
        switch (ParenExprType.$deref()) {
         case SimpleExpr:
          break; // Nothing else to do.
         case CompoundStmt:
          break; // Nothing else to do.
         case CompoundLiteral:
          // We parsed '(' type-name ')' '{' ... '}'.  If any suffixes of
          // postfix-expression exist, parse them now.
          break;
         case CastExpr:
          // We have parsed the cast-expression and no postfix-expr pieces are
          // following.
          return Res;
        }
        
        break;
      }
     case tok.TokenKind.numeric_constant:
      // constant: integer-constant
      // constant: floating-constant
      Res.$assignMove($this().Actions.ActOnNumericConstant($this().Tok, /*UDLScope*/ $this().getCurScope()));
      $this().ConsumeToken();
      break;
     case tok.TokenKind.kw_true:
     case tok.TokenKind.kw_false:
      return $this().ParseCXXBoolLiteral();
     case tok.TokenKind.kw___objc_yes:
     case tok.TokenKind.kw___objc_no:
      return $this().ParseObjCBoolLiteral();
     case tok.TokenKind.kw_nullptr:
      {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($c$.track($this().Diag($this().Tok, diag.warn_cxx98_compat_nullptr)));
          return $this().Actions.ActOnCXXNullPtrLiteral($this().ConsumeToken());
        } finally {
          $c$.$destroy();
        }
      }
     case tok.TokenKind.annot_primary_expr:
      assert (Res.get() == null) : "Stray primary-expression annotation?";
      Res.$assignMove(getExprAnnotation($this().Tok));
      $this().ConsumeToken();
      break;
     case tok.TokenKind.kw___super:
     case tok.TokenKind.kw_decltype:
      // Annotate the token and tail recurse.
      if ($this().TryAnnotateTypeOrScopeToken()) {
        return ExprError();
      }
      assert ($this().Tok.isNot(tok.TokenKind.kw_decltype) && $this().Tok.isNot(tok.TokenKind.kw___super));
      return $this().ParseCastExpression(isUnaryExpression, isAddressOfOperand);
     case tok.TokenKind.identifier:
      { // primary-expression: identifier
  // unqualified-id: identifier
  // constant: enumeration-constant
  // Turn a potentially qualified name into a annot_typename or
  // annot_cxxscope if it would be valid.  This handles things like x::y, etc.
        CXXScopeSpec ScopeSpec = null;
        unique_ptr<CastExpressionIdValidator> Validator = null;
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          if ($this().getLangOpts().CPlusPlus) {
            // Avoid the unnecessary parse-time lookup in the common case
            // where the syntax forbids a type.
            final /*const*/ Token /*&*/ Next = $this().NextToken();
            
            // If this identifier was reverted from a token ID, and the next token
            // is a parenthesis, this is likely to be a use of a type trait. Check
            // those tokens.
            if (Next.is(tok.TokenKind.l_paren)
               && $this().Tok.is(tok.TokenKind.identifier)
               && $this().Tok.getIdentifierInfo().hasRevertedTokenIDToIdentifier()) {
              IdentifierInfo /*P*/ II = $this().Tok.getIdentifierInfo();
              // Build up the mapping of revertible type traits, for future use.
              if ($this().RevertibleTypeTraits.empty()) {
                // JAVA: replaced by usual string constants
                $this().RevertibleTypeTraits.$set($this().PP.getIdentifierInfo(new StringRef(/*KEEP_STR*/$("__is_abstract"))), tok.TokenKind.kw___is_abstract);
                $this().RevertibleTypeTraits.$set($this().PP.getIdentifierInfo(new StringRef(/*KEEP_STR*/$("__is_arithmetic"))), tok.TokenKind.kw___is_arithmetic);
                $this().RevertibleTypeTraits.$set($this().PP.getIdentifierInfo(new StringRef(/*KEEP_STR*/$("__is_array"))), tok.TokenKind.kw___is_array);
                $this().RevertibleTypeTraits.$set($this().PP.getIdentifierInfo(new StringRef(/*KEEP_STR*/$("__is_assignable"))), tok.TokenKind.kw___is_assignable);
                $this().RevertibleTypeTraits.$set($this().PP.getIdentifierInfo(new StringRef(/*KEEP_STR*/$("__is_base_of"))), tok.TokenKind.kw___is_base_of);
                $this().RevertibleTypeTraits.$set($this().PP.getIdentifierInfo(new StringRef(/*KEEP_STR*/$("__is_class"))), tok.TokenKind.kw___is_class);
                $this().RevertibleTypeTraits.$set($this().PP.getIdentifierInfo(new StringRef(/*KEEP_STR*/$("__is_complete_type"))), tok.TokenKind.kw___is_complete_type);
                $this().RevertibleTypeTraits.$set($this().PP.getIdentifierInfo(new StringRef(/*KEEP_STR*/$("__is_compound"))), tok.TokenKind.kw___is_compound);
                $this().RevertibleTypeTraits.$set($this().PP.getIdentifierInfo(new StringRef(/*KEEP_STR*/$("__is_const"))), tok.TokenKind.kw___is_const);
                $this().RevertibleTypeTraits.$set($this().PP.getIdentifierInfo(new StringRef(/*KEEP_STR*/$("__is_constructible"))), tok.TokenKind.kw___is_constructible);
                $this().RevertibleTypeTraits.$set($this().PP.getIdentifierInfo(new StringRef(/*KEEP_STR*/$("__is_convertible"))), tok.TokenKind.kw___is_convertible);
                $this().RevertibleTypeTraits.$set($this().PP.getIdentifierInfo(new StringRef(/*KEEP_STR*/$("__is_convertible_to"))), tok.TokenKind.kw___is_convertible_to);
                $this().RevertibleTypeTraits.$set($this().PP.getIdentifierInfo(new StringRef(/*KEEP_STR*/$("__is_destructible"))), tok.TokenKind.kw___is_destructible);
                $this().RevertibleTypeTraits.$set($this().PP.getIdentifierInfo(new StringRef(/*KEEP_STR*/$("__is_empty"))), tok.TokenKind.kw___is_empty);
                $this().RevertibleTypeTraits.$set($this().PP.getIdentifierInfo(new StringRef(/*KEEP_STR*/$("__is_enum"))), tok.TokenKind.kw___is_enum);
                $this().RevertibleTypeTraits.$set($this().PP.getIdentifierInfo(new StringRef(/*KEEP_STR*/$("__is_floating_point"))), tok.TokenKind.kw___is_floating_point);
                $this().RevertibleTypeTraits.$set($this().PP.getIdentifierInfo(new StringRef(/*KEEP_STR*/$("__is_final"))), tok.TokenKind.kw___is_final);
                $this().RevertibleTypeTraits.$set($this().PP.getIdentifierInfo(new StringRef(/*KEEP_STR*/$("__is_function"))), tok.TokenKind.kw___is_function);
                $this().RevertibleTypeTraits.$set($this().PP.getIdentifierInfo(new StringRef(/*KEEP_STR*/$("__is_fundamental"))), tok.TokenKind.kw___is_fundamental);
                $this().RevertibleTypeTraits.$set($this().PP.getIdentifierInfo(new StringRef(/*KEEP_STR*/$("__is_integral"))), tok.TokenKind.kw___is_integral);
                $this().RevertibleTypeTraits.$set($this().PP.getIdentifierInfo(new StringRef(/*KEEP_STR*/$("__is_interface_class"))), tok.TokenKind.kw___is_interface_class);
                $this().RevertibleTypeTraits.$set($this().PP.getIdentifierInfo(new StringRef(/*KEEP_STR*/$("__is_literal"))), tok.TokenKind.kw___is_literal);
                $this().RevertibleTypeTraits.$set($this().PP.getIdentifierInfo(new StringRef(/*KEEP_STR*/$("__is_lvalue_expr"))), tok.TokenKind.kw___is_lvalue_expr);
                $this().RevertibleTypeTraits.$set($this().PP.getIdentifierInfo(new StringRef(/*KEEP_STR*/$("__is_lvalue_reference"))), tok.TokenKind.kw___is_lvalue_reference);
                $this().RevertibleTypeTraits.$set($this().PP.getIdentifierInfo(new StringRef(/*KEEP_STR*/$("__is_member_function_pointer"))), tok.TokenKind.kw___is_member_function_pointer);
                $this().RevertibleTypeTraits.$set($this().PP.getIdentifierInfo(new StringRef(/*KEEP_STR*/$("__is_member_object_pointer"))), tok.TokenKind.kw___is_member_object_pointer);
                $this().RevertibleTypeTraits.$set($this().PP.getIdentifierInfo(new StringRef(/*KEEP_STR*/$("__is_member_pointer"))), tok.TokenKind.kw___is_member_pointer);
                $this().RevertibleTypeTraits.$set($this().PP.getIdentifierInfo(new StringRef(/*KEEP_STR*/$("__is_nothrow_assignable"))), tok.TokenKind.kw___is_nothrow_assignable);
                $this().RevertibleTypeTraits.$set($this().PP.getIdentifierInfo(new StringRef(/*KEEP_STR*/$("__is_nothrow_constructible"))), tok.TokenKind.kw___is_nothrow_constructible);
                $this().RevertibleTypeTraits.$set($this().PP.getIdentifierInfo(new StringRef(/*KEEP_STR*/$("__is_nothrow_destructible"))), tok.TokenKind.kw___is_nothrow_destructible);
                $this().RevertibleTypeTraits.$set($this().PP.getIdentifierInfo(new StringRef(/*KEEP_STR*/$("__is_object"))), tok.TokenKind.kw___is_object);
                $this().RevertibleTypeTraits.$set($this().PP.getIdentifierInfo(new StringRef(/*KEEP_STR*/$("__is_pod"))), tok.TokenKind.kw___is_pod);
                $this().RevertibleTypeTraits.$set($this().PP.getIdentifierInfo(new StringRef(/*KEEP_STR*/$("__is_pointer"))), tok.TokenKind.kw___is_pointer);
                $this().RevertibleTypeTraits.$set($this().PP.getIdentifierInfo(new StringRef(/*KEEP_STR*/$("__is_polymorphic"))), tok.TokenKind.kw___is_polymorphic);
                $this().RevertibleTypeTraits.$set($this().PP.getIdentifierInfo(new StringRef(/*KEEP_STR*/$("__is_reference"))), tok.TokenKind.kw___is_reference);
                $this().RevertibleTypeTraits.$set($this().PP.getIdentifierInfo(new StringRef(/*KEEP_STR*/$("__is_rvalue_expr"))), tok.TokenKind.kw___is_rvalue_expr);
                $this().RevertibleTypeTraits.$set($this().PP.getIdentifierInfo(new StringRef(/*KEEP_STR*/$("__is_rvalue_reference"))), tok.TokenKind.kw___is_rvalue_reference);
                $this().RevertibleTypeTraits.$set($this().PP.getIdentifierInfo(new StringRef(/*KEEP_STR*/$("__is_same"))), tok.TokenKind.kw___is_same);
                $this().RevertibleTypeTraits.$set($this().PP.getIdentifierInfo(new StringRef(/*KEEP_STR*/$("__is_scalar"))), tok.TokenKind.kw___is_scalar);
                $this().RevertibleTypeTraits.$set($this().PP.getIdentifierInfo(new StringRef(/*KEEP_STR*/$("__is_sealed"))), tok.TokenKind.kw___is_sealed);
                $this().RevertibleTypeTraits.$set($this().PP.getIdentifierInfo(new StringRef(/*KEEP_STR*/$("__is_signed"))), tok.TokenKind.kw___is_signed);
                $this().RevertibleTypeTraits.$set($this().PP.getIdentifierInfo(new StringRef(/*KEEP_STR*/$("__is_standard_layout"))), tok.TokenKind.kw___is_standard_layout);
                $this().RevertibleTypeTraits.$set($this().PP.getIdentifierInfo(new StringRef(/*KEEP_STR*/$("__is_trivial"))), tok.TokenKind.kw___is_trivial);
                $this().RevertibleTypeTraits.$set($this().PP.getIdentifierInfo(new StringRef(/*KEEP_STR*/$("__is_trivially_assignable"))), tok.TokenKind.kw___is_trivially_assignable);
                $this().RevertibleTypeTraits.$set($this().PP.getIdentifierInfo(new StringRef(/*KEEP_STR*/$("__is_trivially_constructible"))), tok.TokenKind.kw___is_trivially_constructible);
                $this().RevertibleTypeTraits.$set($this().PP.getIdentifierInfo(new StringRef(/*KEEP_STR*/$("__is_trivially_copyable"))), tok.TokenKind.kw___is_trivially_copyable);
                $this().RevertibleTypeTraits.$set($this().PP.getIdentifierInfo(new StringRef(/*KEEP_STR*/$("__is_union"))), tok.TokenKind.kw___is_union);
                $this().RevertibleTypeTraits.$set($this().PP.getIdentifierInfo(new StringRef(/*KEEP_STR*/$("__is_unsigned"))), tok.TokenKind.kw___is_unsigned);
                $this().RevertibleTypeTraits.$set($this().PP.getIdentifierInfo(new StringRef(/*KEEP_STR*/$("__is_void"))), tok.TokenKind.kw___is_void);
                $this().RevertibleTypeTraits.$set($this().PP.getIdentifierInfo(new StringRef(/*KEEP_STR*/$("__is_volatile"))), tok.TokenKind.kw___is_volatile);
              }
              
              // If we find that this is in fact the name of a type trait,
              // update the token kind in place and parse again to treat it as
              // the appropriate kind of type trait.
              DenseMapIteratorTypeUShort<IdentifierInfo /*P*//*, tok.TokenKind*/> Known = $this().RevertibleTypeTraits.find(II);
              if (Known.$noteq(/*NO_ITER_COPY*/$this().RevertibleTypeTraits.end())) {
                $this().Tok.setKind(Known.$arrow().second);
                return $this().ParseCastExpression(isUnaryExpression, isAddressOfOperand, 
                    NotCastExpr, isTypeCast);
              }
            }
            if ((!$this().ColonIsSacred && Next.is(tok.TokenKind.colon))
               || Next.isOneOf$T(tok.TokenKind.coloncolon, tok.TokenKind.less, tok.TokenKind.l_paren, 
                tok.TokenKind.l_brace)) {
              // If TryAnnotateTypeOrScopeToken annotates the token, tail recurse.
              if ($this().TryAnnotateTypeOrScopeToken()) {
                return ExprError();
              }
              if (!$this().Tok.is(tok.TokenKind.identifier)) {
                return $this().ParseCastExpression(isUnaryExpression, isAddressOfOperand);
              }
            }
          }
          
          // Consume the identifier so that we can see if it is followed by a '(' or
          // '.'.
          final IdentifierInfo /*&*/ II = $Deref($this().Tok.getIdentifierInfo());
          SourceLocation ILoc = $this().ConsumeToken();
          
          // Support 'Class.property' and 'super.property' notation.
          if ($this().getLangOpts().ObjC1 && $this().Tok.is(tok.TokenKind.period)
             && ($this().Actions.getTypeName(II, new SourceLocation(ILoc), $this().getCurScope()).$bool()
            // Allow the base to be 'super' if in an objc-method.
             || ($AddrOf(II) == $this().Ident_super && $this().getCurScope().isInObjcMethodScope()))) {
            $this().ConsumeToken();
            
            // Allow either an identifier or the keyword 'class' (in C++).
            if ($this().Tok.isNot(tok.TokenKind.identifier)
               && !($this().getLangOpts().CPlusPlus && $this().Tok.is(tok.TokenKind.kw_class))) {
              $c$.clean($c$.track($this().Diag($this().Tok, diag.err_expected_property_name)));
              return ExprError();
            }
            final IdentifierInfo /*&*/ PropertyName = $Deref($this().Tok.getIdentifierInfo());
            SourceLocation PropertyLoc = $this().ConsumeToken();
            
            Res.$assignMove($this().Actions.ActOnClassPropertyRefExpr(II, PropertyName, 
                    new SourceLocation(ILoc), new SourceLocation(PropertyLoc)));
            break;
          }
          
          // In an Objective-C method, if we have "super" followed by an identifier,
          // the token sequence is ill-formed. However, if there's a ':' or ']' after
          // that identifier, this is probably a message send with a missing open
          // bracket. Treat it as such. 
          if ($this().getLangOpts().ObjC1 && $AddrOf(II) == $this().Ident_super && !$this().InMessageExpression
             && $this().getCurScope().isInObjcMethodScope()
             && (($this().Tok.is(tok.TokenKind.identifier)
             && ($this().NextToken().is(tok.TokenKind.colon) || $this().NextToken().is(tok.TokenKind.r_square)))
             || $this().Tok.is(tok.TokenKind.code_completion))) {
            Res.$assignMove($this().ParseObjCMessageExpressionBody(new SourceLocation(), new SourceLocation(ILoc), new OpaquePtr<QualType>(null), 
                    (Expr /*P*/ )null));
            break;
          }
          
          // If we have an Objective-C class name followed by an identifier
          // and either ':' or ']', this is an Objective-C class message
          // send that's missing the opening '['. Recovery
          // appropriately. Also take this path if we're performing code
          // completion after an Objective-C class name.
          if ($this().getLangOpts().ObjC1
             && (($this().Tok.is(tok.TokenKind.identifier) && !$this().InMessageExpression)
             || $this().Tok.is(tok.TokenKind.code_completion))) {
            final /*const*/ Token /*&*/ Next = $this().NextToken();
            if ($this().Tok.is(tok.TokenKind.code_completion)
               || Next.is(tok.TokenKind.colon) || Next.is(tok.TokenKind.r_square)) {
              {
                OpaquePtr<QualType> Typ = $this().Actions.getTypeName(II, new SourceLocation(ILoc), $this().getCurScope());
                if (Typ.$bool()) {
                  if (Typ.getQualType().$arrow().isObjCObjectOrInterfaceType()) {
                    DeclSpec DS = null;
                    Declarator DeclaratorInfo = null;
                    try {
                      // Fake up a Declarator to use with ActOnTypeName.
                      DS/*J*/= new DeclSpec($this().AttrFactory);
                      DS.SetRangeStart(new SourceLocation(ILoc));
                      DS.SetRangeEnd(new SourceLocation(ILoc));
                      /*const*/char$ptr/*char P*/ PrevSpec = create_char$null$ptr();
                      /*uint*/uint$ref DiagID = create_uint$ref();
                      DS.SetTypeSpecType(TypeSpecifierType.TST_typename, new SourceLocation(ILoc), PrevSpec, DiagID, new OpaquePtr<QualType>(Typ), 
                          $this().Actions.getASTContext().getPrintingPolicy());
                      
                      DeclaratorInfo/*J*/= new Declarator(DS, Declarator.TheContext.TypeNameContext);
                      ActionResult<OpaquePtr<QualType> > Ty = $this().Actions.ActOnTypeName($this().getCurScope(), 
                          DeclaratorInfo);
                      if (Ty.isInvalid()) {
                        break;
                      }
                      
                      Res.$assignMove($this().ParseObjCMessageExpressionBody(new SourceLocation(), 
                              new SourceLocation(), 
                              Ty.get(), (Expr /*P*/ )null));
                      break;
                    } finally {
                      if (DeclaratorInfo != null) { DeclaratorInfo.$destroy(); }
                      if (DS != null) { DS.$destroy(); }
                    }
                  }
                }
              }
            }
          }
          
          // Make sure to pass down the right value for isAddressOfOperand.
          if (isAddressOfOperand && $this().isPostfixExpressionSuffixStart()) {
            isAddressOfOperand = false;
          }
          
          // Function designators are allowed to be undeclared (C99 6.5.1p2), so we
          // need to know whether or not this identifier is a function designator or
          // not.
          UnqualifiedId Name/*J*/= new UnqualifiedId();
          ScopeSpec/*J*/= new CXXScopeSpec();
          SourceLocation TemplateKWLoc/*J*/= new SourceLocation();
          Token Replacement/*J*/= new Token();
          Validator = llvm.make_unique(new CastExpressionIdValidator($this().Tok, isTypeCast != TypeCastState.NotTypeCast, isTypeCast != TypeCastState.IsTypeCast));
          Validator.$arrow().IsAddressOfOperand = isAddressOfOperand;
          if ($this().Tok.isOneOf(tok.TokenKind.periodstar, tok.TokenKind.arrowstar)) {
            Validator.$arrow().WantExpressionKeywords = false;
            Validator.$arrow().WantRemainingKeywords = false;
          } else {
            Validator.$arrow().WantRemainingKeywords = $this().Tok.isNot(tok.TokenKind.r_paren);
          }
          Name.setIdentifier($AddrOf(II), new SourceLocation(ILoc));
          $c$.clean(Res.$assignMove($this().Actions.ActOnIdExpression($this().getCurScope(), ScopeSpec, new SourceLocation(TemplateKWLoc), Name, $this().Tok.is(tok.TokenKind.l_paren), 
                  isAddressOfOperand, $c$.track(new std.unique_ptr<CorrectionCandidateCallback>(JD$Unique_ptr$_Up$_Ep.INSTANCE, std.move(Validator))), 
                  /*IsInlineAsmIdentifier=*/ false, 
                  $this().Tok.is(tok.TokenKind.r_paren) ? (Token /*P*/ )null : $AddrOf(Replacement))));
          if (!Res.isInvalid() && !(Res.get() != null)) {
            $this().UnconsumeToken(Replacement);
            return $this().ParseCastExpression(isUnaryExpression, isAddressOfOperand, 
                NotCastExpr, isTypeCast);
          }
          break;
        } finally {
          if (Validator != null) { Validator.$destroy(); }
          if (ScopeSpec != null) { ScopeSpec.$destroy(); }
          $c$.$destroy();
        }
      }
     case tok.TokenKind.char_constant: // constant: character-constant
     case tok.TokenKind.wide_char_constant:
     case tok.TokenKind.utf8_char_constant:
     case tok.TokenKind.utf16_char_constant:
     case tok.TokenKind.utf32_char_constant:
      // JAVA FIX: satisfy test AllLexerTest.test_eof_char_c
      if ($this().Tok.isIncomplete()) {
        NotCastExpr.$set(true);
        return ExprError();
      }
      Res.$assignMove($this().Actions.ActOnCharacterConstant($this().Tok, /*UDLScope*/ $this().getCurScope()));
      $this().ConsumeToken();
      break;
     case tok.TokenKind.kw___func__: // primary-expression: __func__ [C99 6.4.2.2]
     case tok.TokenKind.kw___FUNCTION__: // primary-expression: __FUNCTION__ [GNU]
     case tok.TokenKind.kw___FUNCDNAME__: // primary-expression: __FUNCDNAME__ [MS]
     case tok.TokenKind.kw___FUNCSIG__: // primary-expression: __FUNCSIG__ [MS]
     case tok.TokenKind.kw_L__FUNCTION__: // primary-expression: L__FUNCTION__ [MS]
     case tok.TokenKind.kw___PRETTY_FUNCTION__: // primary-expression: __P..Y_F..N__ [GNU]
      Res.$assignMove($this().Actions.ActOnPredefinedExpr($this().Tok.getLocation(), SavedKind));
      $this().ConsumeToken();
      break;
     case tok.TokenKind.string_literal: // primary-expression: string-literal
     case tok.TokenKind.wide_string_literal:
     case tok.TokenKind.utf8_string_literal:
     case tok.TokenKind.utf16_string_literal:
     case tok.TokenKind.utf32_string_literal:
      // JAVA FIX: satisfy test AllLexerTest.test_eof_string_c
      if ($this().Tok.isIncomplete()) {
        NotCastExpr.$set(true);
        return ExprError();
      }      
      Res.$assignMove($this().ParseStringLiteralExpression(true));
      break;
     case tok.TokenKind.kw__Generic: // primary-expression: generic-selection [C11 6.5.1]
      Res.$assignMove($this().ParseGenericSelectionExpression());
      break;
     case tok.TokenKind.kw___builtin_available:
      return $this().ParseAvailabilityCheckExpr($this().Tok.getLocation());
     case tok.TokenKind.kw___builtin_va_arg:
     case tok.TokenKind.kw___builtin_offsetof:
     case tok.TokenKind.kw___builtin_choose_expr:
     case tok.TokenKind.kw___builtin_astype: // primary-expression: [OCL] as_type()
     case tok.TokenKind.kw___builtin_convertvector:
      return $this().ParseBuiltinPrimaryExpression();
     case tok.TokenKind.kw___null:
      return $this().Actions.ActOnGNUNullExpr($this().ConsumeToken());
     case tok.TokenKind.plusplus: // unary-expression: '++' unary-expression [C99]
     case tok.TokenKind.minusminus:
      { // unary-expression: '--' unary-expression [C99]
  // C++ [expr.unary] has:
  //   unary-expression:
  //     ++ cast-expression
  //     -- cast-expression
        Token SavedTok = new Token($this().Tok);
        $this().ConsumeToken();
        // One special case is implicitly handled here: if the preceding tokens are
        // an ambiguous cast expression, such as "(T())++", then we recurse to
        // determine whether the '++' is prefix or postfix.
        Res.$assignMove($this().ParseCastExpression(!$this().getLangOpts().CPlusPlus, 
                /*isAddressOfOperand*/ false, NotCastExpr, 
                TypeCastState.NotTypeCast));
        if (NotCastExpr.$deref()) {
          // If we return with NotCastExpr = true, we must not consume any tokens,
          // so put the token back where we found it.
          assert (Res.isInvalid());
          $this().UnconsumeToken(SavedTok);
          return ExprError();
        }
        if (!Res.isInvalid()) {
          Res.$assignMove($this().Actions.ActOnUnaryOp($this().getCurScope(), SavedTok.getLocation(), 
                  SavedKind, Res.get()));
        }
        return Res;
      }
     case tok.TokenKind.amp:
      { // unary-expression: '&' cast-expression
  // Special treatment because of member pointers
        SourceLocation SavedLoc = $this().ConsumeToken();
        Res.$assignMove($this().ParseCastExpression(false, true));
        if (!Res.isInvalid()) {
          Res.$assignMove($this().Actions.ActOnUnaryOp($this().getCurScope(), new SourceLocation(SavedLoc), SavedKind, Res.get()));
        }
        return Res;
      }
     case tok.TokenKind.star: // unary-expression: '*' cast-expression
     case tok.TokenKind.plus: // unary-expression: '+' cast-expression
     case tok.TokenKind.minus: // unary-expression: '-' cast-expression
     case tok.TokenKind.tilde: // unary-expression: '~' cast-expression
     case tok.TokenKind.exclaim: // unary-expression: '!' cast-expression
     case tok.TokenKind.kw___real: // unary-expression: '__real' cast-expression [GNU]
     case tok.TokenKind.kw___imag:
      { // unary-expression: '__imag' cast-expression [GNU]
        SourceLocation SavedLoc = $this().ConsumeToken();
        Res.$assignMove($this().ParseCastExpression(false));
        if (!Res.isInvalid()) {
          Res.$assignMove($this().Actions.ActOnUnaryOp($this().getCurScope(), new SourceLocation(SavedLoc), SavedKind, Res.get()));
        }
        return Res;
      }
     case tok.TokenKind.kw_co_await:
      { // unary-expression: 'co_await' cast-expression
        SourceLocation CoawaitLoc = $this().ConsumeToken();
        Res.$assignMove($this().ParseCastExpression(false));
        if (!Res.isInvalid()) {
          Res.$assignMove($this().Actions.ActOnCoawaitExpr($this().getCurScope(), new SourceLocation(CoawaitLoc), Res.get()));
        }
        return Res;
      }
     case tok.TokenKind.kw___extension__:
      { //unary-expression:'__extension__' cast-expr [GNU]
  // __extension__ silences extension warnings in the subexpression.
        ExtensionRAIIObject O = null;
        try {
          O/*J*/= new ExtensionRAIIObject($this().Diags); // Use RAII to do this.
          SourceLocation SavedLoc = $this().ConsumeToken();
          Res.$assignMove($this().ParseCastExpression(false));
          if (!Res.isInvalid()) {
            Res.$assignMove($this().Actions.ActOnUnaryOp($this().getCurScope(), new SourceLocation(SavedLoc), SavedKind, Res.get()));
          }
          return Res;
        } finally {
          if (O != null) { O.$destroy(); }
        }
      }
     case tok.TokenKind.kw__Alignof: // unary-expression: '_Alignof' '(' type-name ')'
      if (!$this().getLangOpts().C11) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_DiagnosticBuilder$C_char$ptr$C($c$.track($this().Diag($this().Tok, diag.ext_c11_alignment)), $this().Tok.getName()));
        } finally {
          $c$.$destroy();
        }
      }
     case tok.TokenKind.kw_alignof: // unary-expression: 'alignof' '(' type-id ')'
     case tok.TokenKind.kw___alignof: // unary-expression: '__alignof' unary-expression
      // unary-expression: '__alignof' '(' type-name ')'
     case tok.TokenKind.kw_sizeof: // unary-expression: 'sizeof' unary-expression
      // unary-expression: 'sizeof' '(' type-name ')'
     case tok.TokenKind.kw_vec_step: // unary-expression: OpenCL 'vec_step' expression
      // unary-expression: '__builtin_omp_required_simd_align' '(' type-name ')'
     case tok.TokenKind.kw___builtin_omp_required_simd_align:
      return $this().ParseUnaryExprOrTypeTraitExpression();
     case tok.TokenKind.ampamp:
      { // unary-expression: '&&' identifier
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          SourceLocation AmpAmpLoc = $this().ConsumeToken();
          if ($this().Tok.isNot(tok.TokenKind.identifier)) {
            return $c$.clean(ExprError($out_DiagnosticBuilder$C_TokenKind($c$.track($this().Diag($this().Tok, diag.err_expected)), tok.TokenKind.identifier)));
          }
          if ($this().getCurScope().getFnParent() == null) {
            return $c$.clean(ExprError($c$.track($this().Diag($this().Tok, diag.err_address_of_label_outside_fn))));
          }
          
          $c$.clean($c$.track($this().Diag(new SourceLocation(AmpAmpLoc), diag.ext_gnu_address_of_label)));
          LabelDecl /*P*/ LD = $this().Actions.LookupOrCreateLabel($this().Tok.getIdentifierInfo(), 
              $this().Tok.getLocation());
          Res.$assignMove($this().Actions.ActOnAddrLabel(new SourceLocation(AmpAmpLoc), $this().Tok.getLocation(), LD));
          $this().ConsumeToken();
          return Res;
        } finally {
          $c$.$destroy();
        }
      }
     case tok.TokenKind.kw_const_cast:
     case tok.TokenKind.kw_dynamic_cast:
     case tok.TokenKind.kw_reinterpret_cast:
     case tok.TokenKind.kw_static_cast:
      Res.$assignMove($this().ParseCXXCasts());
      break;
     case tok.TokenKind.kw_typeid:
      Res.$assignMove($this().ParseCXXTypeid());
      break;
     case tok.TokenKind.kw___uuidof:
      Res.$assignMove($this().ParseCXXUuidof());
      break;
     case tok.TokenKind.kw_this:
      Res.$assignMove($this().ParseCXXThis());
      break;
     case tok.TokenKind.annot_typename:
      if ($this().isStartOfObjCClassMessageMissingOpenBracket()) {
        DeclSpec DS = null;
        Declarator DeclaratorInfo = null;
        try {
          OpaquePtr<QualType> Type = getTypeAnnotation($this().Tok);
          
          // Fake up a Declarator to use with ActOnTypeName.
          DS/*J*/= new DeclSpec($this().AttrFactory);
          DS.SetRangeStart($this().Tok.getLocation());
          DS.SetRangeEnd($this().Tok.getLastLoc());
          
          /*const*/char$ptr/*char P*/ PrevSpec = create_char$null$ptr();
          /*uint*/uint$ref DiagID = create_uint$ref();
          DS.SetTypeSpecType(TypeSpecifierType.TST_typename, $this().Tok.getAnnotationEndLoc(), 
              PrevSpec, DiagID, new OpaquePtr<QualType>(Type), 
              $this().Actions.getASTContext().getPrintingPolicy());
          
          DeclaratorInfo/*J*/= new Declarator(DS, Declarator.TheContext.TypeNameContext);
          ActionResult<OpaquePtr<QualType> > Ty = $this().Actions.ActOnTypeName($this().getCurScope(), DeclaratorInfo);
          if (Ty.isInvalid()) {
            break;
          }
          
          $this().ConsumeToken();
          Res.$assignMove($this().ParseObjCMessageExpressionBody(new SourceLocation(), new SourceLocation(), 
                  Ty.get(), (Expr /*P*/ )null));
          break;
        } finally {
          if (DeclaratorInfo != null) { DeclaratorInfo.$destroy(); }
          if (DS != null) { DS.$destroy(); }
        }
      }
     case tok.TokenKind.annot_decltype:
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
     case tok.TokenKind.kw_typename:
     case tok.TokenKind.kw_typeof:
     case tok.TokenKind.kw___vector:
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
      {
        DeclSpec DS = null;
        try {
          if (!$this().getLangOpts().CPlusPlus) {
            JavaCleaner $c$ = $createJavaCleaner();
            try {
              $c$.clean($c$.track($this().Diag($this().Tok, diag.err_expected_expression)));
              return ExprError();
            } finally {
              $c$.$destroy();
            }
          }
          if (SavedKind == tok.TokenKind.kw_typename) {
            // postfix-expression: typename-specifier '(' expression-list[opt] ')'
            //                     typename-specifier braced-init-list
            if ($this().TryAnnotateTypeOrScopeToken()) {
              return ExprError();
            }
            if (!$this().Actions.isSimpleTypeSpecifier($this().Tok.getKind())) {
              // We are trying to parse a simple-type-specifier but might not get such
              // a token after error recovery.
              return ExprError();
            }
          }
          
          // postfix-expression: simple-type-specifier '(' expression-list[opt] ')'
          //                     simple-type-specifier braced-init-list
          //
          DS/*J*/= new DeclSpec($this().AttrFactory);
          
          $this().ParseCXXSimpleTypeSpecifier(DS);
          if ($this().Tok.isNot(tok.TokenKind.l_paren)
             && (!$this().getLangOpts().CPlusPlus11 || $this().Tok.isNot(tok.TokenKind.l_brace))) {
            JavaCleaner $c$ = $createJavaCleaner();
            try {
              return $c$.clean(ExprError($out_DiagnosticBuilder$C_SourceRange($c$.track($this().Diag($this().Tok, diag.err_expected_lparen_after_type)), 
                      DS.getSourceRange())));
            } finally {
              $c$.$destroy();
            }
          }
          if ($this().Tok.is(tok.TokenKind.l_brace)) {
            JavaCleaner $c$ = $createJavaCleaner();
            try {
              $c$.clean($c$.track($this().Diag($this().Tok, diag.warn_cxx98_compat_generalized_initializer_lists)));
            } finally {
              $c$.$destroy();
            }
          }
          
          Res.$assignMove($this().ParseCXXTypeConstructExpression(DS));
          break;
        } finally {
          if (DS != null) { DS.$destroy(); }
        }
      }
     case tok.TokenKind.annot_cxxscope:
      { // [C++] id-expression: qualified-id
  // If TryAnnotateTypeOrScopeToken annotates the token, tail recurse.
  // (We can end up in this situation after tentative parsing.)
        if ($this().TryAnnotateTypeOrScopeToken()) {
          return ExprError();
        }
        if (!$this().Tok.is(tok.TokenKind.annot_cxxscope)) {
          return $this().ParseCastExpression(isUnaryExpression, isAddressOfOperand, 
              NotCastExpr, isTypeCast);
        }
        
        Token Next = new Token($this().NextToken());
        if (Next.is(tok.TokenKind.annot_template_id)) {
          TemplateIdAnnotation /*P*/ TemplateId = $this().takeTemplateIdAnnotation(Next);
          if (TemplateId.Kind == TemplateNameKind.TNK_Type_template) {
            CXXScopeSpec SS = null;
            try {
              // We have a qualified template-id that we know refers to a
              // type, translate it into a type and continue parsing as a
              // cast expression.
              SS/*J*/= new CXXScopeSpec();
              $this().ParseOptionalCXXScopeSpecifier(SS, new OpaquePtr<QualType>(null), 
                  /*EnteringContext=*/ false);
              $this().AnnotateTemplateIdTokenAsType();
              return $this().ParseCastExpression(isUnaryExpression, isAddressOfOperand, 
                  NotCastExpr, isTypeCast);
            } finally {
              if (SS != null) { SS.$destroy(); }
            }
          }
        }
        
        // Parse as an id-expression.
        Res.$assignMove($this().ParseCXXIdExpression(isAddressOfOperand));
        break;
      }
     case tok.TokenKind.annot_template_id:
      { // [C++]          template-id
        TemplateIdAnnotation /*P*/ TemplateId = $this().takeTemplateIdAnnotation($this().Tok);
        if (TemplateId.Kind == TemplateNameKind.TNK_Type_template) {
          // We have a template-id that we know refers to a type,
          // translate it into a type and continue parsing as a cast
          // expression.
          $this().AnnotateTemplateIdTokenAsType();
          return $this().ParseCastExpression(isUnaryExpression, isAddressOfOperand, 
              NotCastExpr, isTypeCast);
        }
        // Fall through to treat the template-id as an id-expression.
      }
     case tok.TokenKind.kw_operator: // [C++] id-expression: operator/conversion-function-id
      Res.$assignMove($this().ParseCXXIdExpression(isAddressOfOperand));
      break;
     case tok.TokenKind.coloncolon:
      {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          // ::foo::bar -> global qualified name etc.   If TryAnnotateTypeOrScopeToken
          // annotates the token, tail recurse.
          if ($this().TryAnnotateTypeOrScopeToken()) {
            return ExprError();
          }
          if (!$this().Tok.is(tok.TokenKind.coloncolon)) {
            return $this().ParseCastExpression(isUnaryExpression, isAddressOfOperand);
          }
          
          // ::new -> [C++] new-expression
          // ::delete -> [C++] delete-expression
          SourceLocation CCLoc = $this().ConsumeToken();
          if ($this().Tok.is(tok.TokenKind.kw_new)) {
            return $this().ParseCXXNewExpression(true, new SourceLocation(CCLoc));
          }
          if ($this().Tok.is(tok.TokenKind.kw_delete)) {
            return $this().ParseCXXDeleteExpression(true, new SourceLocation(CCLoc));
          }
          
          // This is not a type name or scope specifier, it is an invalid expression.
          $c$.clean($c$.track($this().Diag(new SourceLocation(CCLoc), diag.err_expected_expression)));
          return ExprError();
        } finally {
          $c$.$destroy();
        }
      }
     case tok.TokenKind.kw_new: // [C++] new-expression
      return $this().ParseCXXNewExpression(false, $this().Tok.getLocation());
     case tok.TokenKind.kw_delete: // [C++] delete-expression
      return $this().ParseCXXDeleteExpression(false, $this().Tok.getLocation());
     case tok.TokenKind.kw_noexcept:
      { // [C++0x] 'noexcept' '(' expression ')'
        BalancedDelimiterTracker T = null;
        EnterExpressionEvaluationContext Unevaluated = null;
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($c$.track($this().Diag($this().Tok, diag.warn_cxx98_compat_noexcept_expr)));
          SourceLocation KeyLoc = $this().ConsumeToken();
          T/*J*/= new BalancedDelimiterTracker(/*Deref*/$this(), tok.TokenKind.l_paren);
          if (T.expectAndConsume(diag.err_expected_lparen_after, $noexcept)) {
            return ExprError();
          }
          // C++11 [expr.unary.noexcept]p1:
          //   The noexcept operator determines whether the evaluation of its operand,
          //   which is an unevaluated operand, can throw an exception.
          Unevaluated/*J*/= new EnterExpressionEvaluationContext($this().Actions, Sema.ExpressionEvaluationContext.Unevaluated);
          ActionResultTTrue<Expr /*P*/ > Result = $this().ParseExpression();
          
          T.consumeClose();
          if (!Result.isInvalid()) {
            Result.$assignMove($this().Actions.ActOnNoexceptExpr(new SourceLocation(KeyLoc), T.getOpenLocation(), 
                    Result.get(), T.getCloseLocation()));
          }
          return Result;
        } finally {
          if (Unevaluated != null) { Unevaluated.$destroy(); }
          if (T != null) { T.$destroy(); }
          $c$.$destroy();
        }
      }
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
      return $this().ParseTypeTrait();
     case tok.TokenKind.kw___array_rank:
     case tok.TokenKind.kw___array_extent:
      return $this().ParseArrayTypeTrait();
     case tok.TokenKind.kw___is_lvalue_expr:
     case tok.TokenKind.kw___is_rvalue_expr:
      return $this().ParseExpressionTrait();
     case tok.TokenKind.at:
      {
        SourceLocation AtLoc = $this().ConsumeToken();
        return $this().ParseObjCAtExpression(new SourceLocation(AtLoc));
      }
     case tok.TokenKind.caret:
      Res.$assignMove($this().ParseBlockLiteralExpression());
      break;
     case tok.TokenKind.code_completion:
      {
        $this().Actions.CodeCompleteOrdinaryName($this().getCurScope(), Sema.ParserCompletionContext.PCC_Expression);
        $this().cutOffParsing();
        return ExprError();
      }
     case tok.TokenKind.l_square:
      if ($this().getLangOpts().CPlusPlus11) {
        if ($this().getLangOpts().ObjC1) {
          // C++11 lambda expressions and Objective-C message sends both start with a
          // square bracket.  There are three possibilities here:
          // we have a valid lambda expression, we have an invalid lambda
          // expression, or we have something that doesn't appear to be a lambda.
          // If we're in the last case, we fall back to ParseObjCMessageExpression.
          Res.$assignMove($this().TryParseLambdaExpression());
          if (!Res.isInvalid() && !(Res.get() != null)) {
            Res.$assignMove($this().ParseObjCMessageExpression());
          }
          break;
        }
        Res.$assignMove($this().ParseLambdaExpression());
        break;
      }
      if ($this().getLangOpts().ObjC1) {
        Res.$assignMove($this().ParseObjCMessageExpression());
        break;
      }
     default:
      // FALL THROUGH.
      NotCastExpr.$set(true);
      return ExprError();
    }
    
    // Check to see whether Res is a function designator only. If it is and we
    // are compiling for OpenCL, we need to return an error as this implies
    // that the address of the function is being taken, which is illegal in CL.
    
    // These can be followed by postfix-expr pieces.
    Res.$assignMove($this().ParsePostfixExpressionSuffix(new ActionResultTTrue<Expr /*P*/ >(Res)));
    if ($this().getLangOpts().OpenCL) {
      {
        Expr /*P*/ PostfixExpr = Res.get();
        if ((PostfixExpr != null)) {
          QualType Ty = PostfixExpr.getType();
          if (!Ty.isNull() && Ty.$arrow().isFunctionType()) {
            JavaCleaner $c$ = $createJavaCleaner();
            try {
              $c$.clean($c$.track($this().Diag(PostfixExpr.getExprLoc(), 
                  diag.err_opencl_taking_function_address_parser)));
              return ExprError();
            } finally {
              $c$.$destroy();
            }
          }
        }
      }
    }
    
    return Res;
  }


/// \brief Parse a cast-expression, or, if \p isUnaryExpression is true,
/// parse a unary-expression.
///
/// \p isAddressOfOperand exists because an id-expression that is the
/// operand of address-of gets special treatment due to member pointers.
///
//<editor-fold defaultstate="collapsed" desc="clang::Parser::ParseCastExpression">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseExpr.cpp", line = 475,
   FQN="clang::Parser::ParseCastExpression", NM="_ZN5clang6Parser19ParseCastExpressionEbbNS0_13TypeCastStateE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseExpr.cpp -nm=_ZN5clang6Parser19ParseCastExpressionEbbNS0_13TypeCastStateE")
  //</editor-fold>
  protected /*private*/ ActionResultTTrue<Expr /*P*/ > ParseCastExpression(boolean isUnaryExpression) {
    return $this().ParseCastExpression(isUnaryExpression, 
                     false, 
                     TypeCastState.NotTypeCast);
  }
  protected /*private*/ ActionResultTTrue<Expr /*P*/ > ParseCastExpression(boolean isUnaryExpression, 
                     boolean isAddressOfOperand/*= false*/) {
    return $this().ParseCastExpression(isUnaryExpression, 
                     isAddressOfOperand, 
                     TypeCastState.NotTypeCast);
  }
  protected /*private*/ ActionResultTTrue<Expr /*P*/ > ParseCastExpression(boolean isUnaryExpression, 
                     boolean isAddressOfOperand/*= false*/, 
                     TypeCastState isTypeCast/*= NotTypeCast*/) {
    bool$ref NotCastExpr = create_bool$ref();
    ActionResultTTrue<Expr /*P*/ > Res = $this().ParseCastExpression(isUnaryExpression, 
        isAddressOfOperand, 
        NotCastExpr, 
        isTypeCast);
    if (NotCastExpr.$deref()) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($c$.track($this().Diag($this().Tok, diag.err_expected_expression)));
      } finally {
        $c$.$destroy();
      }
    }
    return Res;
  }


/// Returns true if the next token cannot start an expression.
//<editor-fold defaultstate="collapsed" desc="clang::Parser::isNotExpressionStart">
@Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseExpr.cpp", line = 228,
   FQN="clang::Parser::isNotExpressionStart", NM="_ZN5clang6Parser20isNotExpressionStartEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseExpr.cpp -nm=_ZN5clang6Parser20isNotExpressionStartEv")
  //</editor-fold>
  protected /*private*/ boolean isNotExpressionStart() {
    /*tok.TokenKind*/char K = $this().Tok.getKind();
    if (K == tok.TokenKind.l_brace || K == tok.TokenKind.r_brace
       || K == tok.TokenKind.kw_for || K == tok.TokenKind.kw_while
       || K == tok.TokenKind.kw_if || K == tok.TokenKind.kw_else
       || K == tok.TokenKind.kw_goto || K == tok.TokenKind.kw_try) {
      return true;
    }
    // If this is a decl-specifier, we can't be at the start of an expression.
    return $this().isKnownToBeDeclarationSpecifier();
  }


/// \brief Once the leading part of a postfix-expression is parsed, this
/// method parses any suffixes that apply.
///
/// \verbatim
///       postfix-expression: [C99 6.5.2]
///         primary-expression
///         postfix-expression '[' expression ']'
///         postfix-expression '[' braced-init-list ']'
///         postfix-expression '(' argument-expression-list[opt] ')'
///         postfix-expression '.' identifier
///         postfix-expression '->' identifier
///         postfix-expression '++'
///         postfix-expression '--'
///         '(' type-name ')' '{' initializer-list '}'
///         '(' type-name ')' '{' initializer-list ',' '}'
///
///       argument-expression-list: [C99 6.5.2]
///         argument-expression ...[opt]
///         argument-expression-list ',' assignment-expression ...[opt]
/// \endverbatim
//<editor-fold defaultstate="collapsed" desc="clang::Parser::ParsePostfixExpressionSuffix">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseExpr.cpp", line = 1406,
   FQN="clang::Parser::ParsePostfixExpressionSuffix", NM="_ZN5clang6Parser28ParsePostfixExpressionSuffixENS_12ActionResultIPNS_4ExprELb1EEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseExpr.cpp -nm=_ZN5clang6Parser28ParsePostfixExpressionSuffixENS_12ActionResultIPNS_4ExprELb1EEE")
  //</editor-fold>
  protected /*private*/ ActionResultTTrue<Expr /*P*/ > ParsePostfixExpressionSuffix(ActionResultTTrue<Expr /*P*/ > LHS) {
    // Now that the primary-expression piece of the postfix-expression has been
    // parsed, see if there are any postfix-expression pieces here.
    SourceLocation Loc/*J*/= new SourceLocation();
    while (true) {
      switch ($this().Tok.getKind()) {
       case tok.TokenKind.code_completion:
        if ($this().InMessageExpression) {
          return new ActionResultTTrue<Expr /*P*/ >(JD$Move.INSTANCE, LHS);
        }
        
        $this().Actions.CodeCompletePostfixExpression($this().getCurScope(), new ActionResultTTrue<Expr /*P*/ >(LHS));
        $this().cutOffParsing();
        return ExprError();
       case tok.TokenKind.identifier:
        // If we see identifier: after an expression, and we're not already in a
        // message send, then this is probably a message send with a missing
        // opening bracket '['.
        if ($this().getLangOpts().ObjC1 && !$this().InMessageExpression
           && ($this().NextToken().is(tok.TokenKind.colon) || $this().NextToken().is(tok.TokenKind.r_square))) {
          LHS.$assignMove($this().ParseObjCMessageExpressionBody(new SourceLocation(), new SourceLocation(), 
                  new OpaquePtr<QualType>(null), LHS.get()));
          break;
        }
       default: // Not a postfix-expression suffix.
        return new ActionResultTTrue<Expr /*P*/ >(JD$Move.INSTANCE, LHS);
       case tok.TokenKind.l_square:
        { // postfix-expression: p-e '[' expression ']'
  // If we have a array postfix expression that starts on a new line and
  // Objective-C is enabled, it is highly likely that the user forgot a
  // semicolon after the base expression and that the array postfix-expr is
  // actually another message send.  In this case, do some look-ahead to see
  // if the contents of the square brackets are obviously not a valid
  // expression and recover by pretending there is no suffix.
          BalancedDelimiterTracker T = null;
          try {
            if ($this().getLangOpts().ObjC1 && $this().Tok.isAtStartOfLine()
               && $this().isSimpleObjCMessageExpression()) {
              return new ActionResultTTrue<Expr /*P*/ >(JD$Move.INSTANCE, LHS);
            }
            
            // Reject array indices starting with a lambda-expression. '[[' is
            // reserved for attributes.
            if ($this().CheckProhibitedCXX11Attribute()) {
              /*(void)*/$this().Actions.CorrectDelayedTyposInExpr(new ActionResultTTrue<Expr /*P*/ >(LHS));
              return ExprError();
            }
            
            T/*J*/= new BalancedDelimiterTracker(/*Deref*/$this(), tok.TokenKind.l_square);
            T.consumeOpen();
            Loc.$assignMove(T.getOpenLocation());
            ActionResultTTrue<Expr /*P*/ > Idx/*J*/= new ActionResultTTrue<Expr /*P*/ >(), Length/*J*/= new ActionResultTTrue<Expr /*P*/ >();
            SourceLocation ColonLoc/*J*/= new SourceLocation();
            if ($this().getLangOpts().CPlusPlus11 && $this().Tok.is(tok.TokenKind.l_brace)) {
              JavaCleaner $c$ = $createJavaCleaner();
              try {
                $c$.clean($c$.track($this().Diag($this().Tok, diag.warn_cxx98_compat_generalized_initializer_lists)));
                Idx.$assignMove($this().ParseBraceInitializer());
              } finally {
                $c$.$destroy();
              }
            } else if (($this().getLangOpts().OpenMP != 0)) {
              ColonProtectionRAIIObject RAII = null;
              try {
                RAII/*J*/= new ColonProtectionRAIIObject(/*Deref*/$this());
                // Parse [: or [ expr or [ expr :
                if (!$this().Tok.is(tok.TokenKind.colon)) {
                  // [ expr
                  Idx.$assignMove($this().ParseExpression());
                }
                if ($this().Tok.is(tok.TokenKind.colon)) {
                  // Consume ':'
                  ColonLoc.$assignMove($this().ConsumeToken());
                  if ($this().Tok.isNot(tok.TokenKind.r_square)) {
                    Length.$assignMove($this().ParseExpression());
                  }
                }
              } finally {
                if (RAII != null) { RAII.$destroy(); }
              }
            } else {
              Idx.$assignMove($this().ParseExpression());
            }
            
            SourceLocation RLoc = $this().Tok.getLocation();
            
            ActionResultTTrue<Expr /*P*/ > OrigLHS = new ActionResultTTrue<Expr /*P*/ >(LHS);
            if (!LHS.isInvalid() && !Idx.isInvalid() && !Length.isInvalid()
               && $this().Tok.is(tok.TokenKind.r_square)) {
              if (ColonLoc.isValid()) {
                LHS.$assignMove($this().Actions.ActOnOMPArraySectionExpr(LHS.get(), new SourceLocation(Loc), Idx.get(), 
                        new SourceLocation(ColonLoc), Length.get(), new SourceLocation(RLoc)));
              } else {
                LHS.$assignMove($this().Actions.ActOnArraySubscriptExpr($this().getCurScope(), LHS.get(), new SourceLocation(Loc), 
                        Idx.get(), new SourceLocation(RLoc)));
              }
            } else {
              LHS.$assignMove(ExprError());
            }
            if (LHS.isInvalid()) {
              /*(void)*/$this().Actions.CorrectDelayedTyposInExpr(new ActionResultTTrue<Expr /*P*/ >(OrigLHS));
              /*(void)*/$this().Actions.CorrectDelayedTyposInExpr(new ActionResultTTrue<Expr /*P*/ >(Idx));
              /*(void)*/$this().Actions.CorrectDelayedTyposInExpr(new ActionResultTTrue<Expr /*P*/ >(Length));
              LHS.$assignMove(ExprError());
              Idx.$assignMove(ExprError());
            }
            
            // Match the ']'.
            T.consumeClose();
            break;
          } finally {
            if (T != null) { T.$destroy(); }
          }
        }
       case tok.TokenKind.l_paren: // p-e: p-e '(' argument-expression-list[opt] ')'
       case tok.TokenKind.lesslessless:
        { // p-e: p-e '<<<' argument-expression-list '>>>'
  //   '(' argument-expression-list[opt] ')'
          InMessageExpressionRAIIObject InMessage = null;
          BalancedDelimiterTracker PT = null;
          try {
            /*tok.TokenKind*/char OpKind = $this().Tok.getKind();
            InMessage/*J*/= new InMessageExpressionRAIIObject(/*Deref*/$this(), false);
            
            Expr /*P*/ ExecConfig = null;
            
            PT/*J*/= new BalancedDelimiterTracker(/*Deref*/$this(), tok.TokenKind.l_paren);
            if (OpKind == tok.TokenKind.lesslessless) {
              SmallVector<Expr /*P*/ > ExecConfigExprs/*J*/= new SmallVector<Expr /*P*/ >(12, (Expr /*P*/ )null);
              SmallVector<SourceLocation> ExecConfigCommaLocs/*J*/= new SmallVector<SourceLocation>(20, new SourceLocation());
              SourceLocation OpenLoc = $this().ConsumeToken();
              if ($this().ParseSimpleExpressionList(ExecConfigExprs, ExecConfigCommaLocs)) {
                /*(void)*/$this().Actions.CorrectDelayedTyposInExpr(new ActionResultTTrue<Expr /*P*/ >(LHS));
                LHS.$assignMove(ExprError());
              }
              
              SourceLocation CloseLoc/*J*/= new SourceLocation();
              if ($this().TryConsumeToken(tok.TokenKind.greatergreatergreater, CloseLoc)) {
              } else if (LHS.isInvalid()) {
                $this().SkipUntil(tok.TokenKind.greatergreatergreater, SkipUntilFlags.StopAtSemi);
              } else {
                JavaCleaner $c$ = $createJavaCleaner();
                try {
                  // There was an error closing the brackets
                  $c$.clean($out_DiagnosticBuilder$C_TokenKind($c$.track($this().Diag($this().Tok, diag.err_expected)), tok.TokenKind.greatergreatergreater));
                  $c$.clean($out_DiagnosticBuilder$C_TokenKind($c$.track($this().Diag(new SourceLocation(OpenLoc), diag.note_matching)), tok.TokenKind.lesslessless));
                  $this().SkipUntil(tok.TokenKind.greatergreatergreater, SkipUntilFlags.StopAtSemi);
                  LHS.$assignMove(ExprError());
                } finally {
                  $c$.$destroy();
                }
              }
              if (!LHS.isInvalid()) {
                if ($this().ExpectAndConsume(tok.TokenKind.l_paren)) {
                  LHS.$assignMove(ExprError());
                } else {
                  Loc.$assign($this().PrevTokLocation);
                }
              }
              if (!LHS.isInvalid()) {
                ActionResultTTrue<Expr /*P*/ > ECResult = $this().Actions.ActOnCUDAExecConfigExpr($this().getCurScope(), 
                    new SourceLocation(OpenLoc), 
                    new MutableArrayRef<Expr /*P*/ >(ExecConfigExprs), 
                    new SourceLocation(CloseLoc));
                if (ECResult.isInvalid()) {
                  LHS.$assignMove(ExprError());
                } else {
                  ExecConfig = ECResult.get();
                }
              }
            } else {
              PT.consumeOpen();
              Loc.$assignMove(PT.getOpenLocation());
            }
            
            SmallVector<Expr /*P*/ > ArgExprs/*J*/= new SmallVector<Expr /*P*/ >(12, (Expr /*P*/ )null);
            SmallVector<SourceLocation> CommaLocs/*J*/= new SmallVector<SourceLocation>(20, new SourceLocation());
            if ($this().Tok.is(tok.TokenKind.code_completion)) {
              $this().Actions.CodeCompleteCall($this().getCurScope(), LHS.get(), new ArrayRef<Expr /*P*/ >(None));
              $this().cutOffParsing();
              return ExprError();
            }
            if (OpKind == tok.TokenKind.l_paren || !LHS.isInvalid()) {
              if ($this().Tok.isNot(tok.TokenKind.r_paren)) {
                if ($this().ParseExpressionList(ArgExprs, CommaLocs, ()-> 
                          {
                            $this().Actions.CodeCompleteCall($this().getCurScope(), LHS.get(), new ArrayRef<Expr /*P*/ >(ArgExprs));
                          }
                    )) {
                  /*(void)*/$this().Actions.CorrectDelayedTyposInExpr(new ActionResultTTrue<Expr /*P*/ >(LHS));
                  LHS.$assignMove(ExprError());
                } else if (LHS.isInvalid()) {
                  for (final Expr /*P*/ /*&*/ E : ArgExprs)  {
                    $this().Actions.CorrectDelayedTyposInExpr(E);
                  }
                }
              }
            }
            
            // Match the ')'.
            if (LHS.isInvalid()) {
              $this().SkipUntil(tok.TokenKind.r_paren, SkipUntilFlags.StopAtSemi);
            } else if ($this().Tok.isNot(tok.TokenKind.r_paren)) {
              boolean HadDelayedTypo = false;
              if ($this().Actions.CorrectDelayedTyposInExpr(new ActionResultTTrue<Expr /*P*/ >(LHS)).get() != LHS.get()) {
                HadDelayedTypo = true;
              }
              for (final Expr /*P*/ /*&*/ E : ArgExprs)  {
                if ($this().Actions.CorrectDelayedTyposInExpr(E).get() != E) {
                  HadDelayedTypo = true;
                }
              }
              // If there were delayed typos in the LHS or ArgExprs, call SkipUntil
              // instead of PT.consumeClose() to avoid emitting extra diagnostics for
              // the unmatched l_paren.
              if (HadDelayedTypo) {
                $this().SkipUntil(tok.TokenKind.r_paren, SkipUntilFlags.StopAtSemi);
              } else {
                PT.consumeClose();
              }
              LHS.$assignMove(ExprError());
            } else {
              assert ((ArgExprs.size() == 0 || ArgExprs.size() - 1 == CommaLocs.size())) : "Unexpected number of commas!";
              LHS.$assignMove($this().Actions.ActOnCallExpr($this().getCurScope(), LHS.get(), new SourceLocation(Loc), 
                      new MutableArrayRef<Expr /*P*/ >(ArgExprs), $this().Tok.getLocation(), 
                      ExecConfig));
              PT.consumeClose();
            }
            
            break;
          } finally {
            if (PT != null) { PT.$destroy(); }
            if (InMessage != null) { InMessage.$destroy(); }
          }
        }
       case tok.TokenKind.arrow:
       case tok.TokenKind.period:
        {
          CXXScopeSpec SS = null;
          try {
            // postfix-expression: p-e '->' template[opt] id-expression
            // postfix-expression: p-e '.' template[opt] id-expression
            /*tok.TokenKind*/char OpKind = $this().Tok.getKind();
            SourceLocation OpLoc = $this().ConsumeToken(); // Eat the "." or "->" token.
            
            SS/*J*/= new CXXScopeSpec();
            OpaquePtr<QualType> ObjectType/*J*/= new OpaquePtr<QualType>();
            final bool$ref MayBePseudoDestructor = create_bool$ref(false);
            if ($this().getLangOpts().CPlusPlus && !LHS.isInvalid()) {
              Expr /*P*/ Base = LHS.get();
              /*const*/ Type /*P*/ BaseType = Base.getType().getTypePtrOrNull();
              if ((BaseType != null) && $this().Tok.is(tok.TokenKind.l_paren)
                 && (BaseType.isFunctionType()
                 || BaseType.isSpecificPlaceholderType(BuiltinType.Kind.BoundMember.getValue()))) {
                JavaCleaner $c$ = $createJavaCleaner();
                try {
                  $c$.clean($out_DiagnosticBuilder$C_FixItHint$C($out_DiagnosticBuilder$C_SourceRange($out_DiagnosticBuilder$C_TokenKind($c$.track($this().Diag(new SourceLocation(OpLoc), diag.err_function_is_not_record)), 
                              OpKind), Base.getSourceRange()), 
                      FixItHint.CreateRemoval(new SourceRange(/*NO_COPY*/OpLoc))));
                  return $this().ParsePostfixExpressionSuffix(new ActionResultTTrue<Expr /*P*/ >(JD$T.INSTANCE, Base));
                } finally {
                  $c$.$destroy();
                }
              }
              
              LHS.$assignMove($this().Actions.ActOnStartCXXMemberReference($this().getCurScope(), Base, 
                      new SourceLocation(OpLoc), OpKind, ObjectType, 
                      MayBePseudoDestructor));
              if (LHS.isInvalid()) {
                break;
              }
              
              $this().ParseOptionalCXXScopeSpecifier(SS, new OpaquePtr<QualType>(ObjectType), 
                  /*EnteringContext=*/ false, 
                  $AddrOf(MayBePseudoDestructor.deref$ptr()));
              if (SS.isNotEmpty()) {
                ObjectType.$assignMove(new OpaquePtr<QualType>(null));
              }
            }
            if ($this().Tok.is(tok.TokenKind.code_completion)) {
              // Code completion for a member access expression.
              $this().Actions.CodeCompleteMemberReferenceExpr($this().getCurScope(), LHS.get(), 
                  new SourceLocation(OpLoc), OpKind == tok.TokenKind.arrow);
              
              $this().cutOffParsing();
              return ExprError();
            }
            if (MayBePseudoDestructor.$deref() && !LHS.isInvalid()) {
              LHS.$assignMove($this().ParseCXXPseudoDestructor(LHS.get(), new SourceLocation(OpLoc), OpKind, SS, 
                      new OpaquePtr<QualType>(ObjectType)));
              break;
            }
            
            // Either the action has told us that this cannot be a
            // pseudo-destructor expression (based on the type of base
            // expression), or we didn't see a '~' in the right place. We
            // can still parse a destructor name here, but in that case it
            // names a real destructor.
            // Allow explicit constructor calls in Microsoft mode.
            // FIXME: Add support for explicit call of template constructor.
            SourceLocation TemplateKWLoc/*J*/= new SourceLocation();
            UnqualifiedId Name/*J*/= new UnqualifiedId();
            if ($this().getLangOpts().ObjC2 && OpKind == tok.TokenKind.period
               && $this().Tok.is(tok.TokenKind.kw_class)) {
              // Objective-C++:
              //   After a '.' in a member access expression, treat the keyword
              //   'class' as if it were an identifier.
              //
              // This hack allows property access to the 'class' method because it is
              // such a common method name. For other C++ keywords that are 
              // Objective-C method names, one must use the message send syntax.
              IdentifierInfo /*P*/ Id = $this().Tok.getIdentifierInfo();
              SourceLocation _Loc = $this().ConsumeToken();
              Name.setIdentifier(Id, new SourceLocation(_Loc));
            } else if ($this().ParseUnqualifiedId(SS, 
                /*EnteringContext=*/ false, 
                /*AllowDestructorName=*/ true, 
                /*AllowConstructorName=*/
                $this().getLangOpts().MicrosoftExt, 
                new OpaquePtr<QualType>(ObjectType), TemplateKWLoc, Name)) {
              /*(void)*/$this().Actions.CorrectDelayedTyposInExpr(new ActionResultTTrue<Expr /*P*/ >(LHS));
              LHS.$assignMove(ExprError());
            }
            if (!LHS.isInvalid()) {
              LHS.$assignMove($this().Actions.ActOnMemberAccessExpr($this().getCurScope(), LHS.get(), new SourceLocation(OpLoc), 
                      OpKind, SS, new SourceLocation(TemplateKWLoc), Name, 
                      ($this().CurParsedObjCImpl != null) ? $this().CurParsedObjCImpl.Dcl : (Decl /*P*/ )null));
            }
            break;
          } finally {
            if (SS != null) { SS.$destroy(); }
          }
        }
       case tok.TokenKind.plusplus: // postfix-expression: postfix-expression '++'
       case tok.TokenKind.minusminus: // postfix-expression: postfix-expression '--'
        if (!LHS.isInvalid()) {
          LHS.$assignMove($this().Actions.ActOnPostfixUnaryOp($this().getCurScope(), $this().Tok.getLocation(), 
                  $this().Tok.getKind(), LHS.get()));
        }
        $this().ConsumeToken();
        break;
      }
    }
  }


/// \brief Parse a sizeof or alignof expression.
///
/// \verbatim
///       unary-expression:  [C99 6.5.3]
///         'sizeof' unary-expression
///         'sizeof' '(' type-name ')'
/// [C++11] 'sizeof' '...' '(' identifier ')'
/// [GNU]   '__alignof' unary-expression
/// [GNU]   '__alignof' '(' type-name ')'
/// [C11]   '_Alignof' '(' type-name ')'
/// [C++11] 'alignof' '(' type-id ')'
/// \endverbatim
//<editor-fold defaultstate="collapsed" desc="clang::Parser::ParseUnaryExprOrTypeTraitExpression">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseExpr.cpp", line = 1827,
   FQN="clang::Parser::ParseUnaryExprOrTypeTraitExpression", NM="_ZN5clang6Parser35ParseUnaryExprOrTypeTraitExpressionEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseExpr.cpp -nm=_ZN5clang6Parser35ParseUnaryExprOrTypeTraitExpressionEv")
  //</editor-fold>
  protected /*private*/ ActionResultTTrue<Expr /*P*/ > ParseUnaryExprOrTypeTraitExpression() {
    EnterExpressionEvaluationContext Unevaluated = null;
    try {
      assert ($this().Tok.isOneOf$T(tok.TokenKind.kw_sizeof, tok.TokenKind.kw___alignof, tok.TokenKind.kw_alignof, tok.TokenKind.kw__Alignof, tok.TokenKind.kw_vec_step, tok.TokenKind.kw___builtin_omp_required_simd_align)) : "Not a sizeof/alignof/vec_step expression!";
      Token OpTok = new Token($this().Tok);
      $this().ConsumeToken();
      
      // [C++11] 'sizeof' '...' '(' identifier ')'
      if ($this().Tok.is(tok.TokenKind.ellipsis) && OpTok.is(tok.TokenKind.kw_sizeof)) {
        EnterExpressionEvaluationContext _Unevaluated = null;
        try {
          SourceLocation EllipsisLoc = $this().ConsumeToken();
          SourceLocation LParenLoc/*J*/= new SourceLocation(), RParenLoc/*J*/= new SourceLocation();
          IdentifierInfo /*P*/ Name = null;
          SourceLocation NameLoc/*J*/= new SourceLocation();
          if ($this().Tok.is(tok.TokenKind.l_paren)) {
            BalancedDelimiterTracker T = null;
            try {
              T/*J*/= new BalancedDelimiterTracker(/*Deref*/$this(), tok.TokenKind.l_paren);
              T.consumeOpen();
              LParenLoc.$assignMove(T.getOpenLocation());
              if ($this().Tok.is(tok.TokenKind.identifier)) {
                Name = $this().Tok.getIdentifierInfo();
                NameLoc.$assignMove($this().ConsumeToken());
                T.consumeClose();
                RParenLoc.$assignMove(T.getCloseLocation());
                if (RParenLoc.isInvalid()) {
                  RParenLoc.$assignMove($this().PP.getLocForEndOfToken(/*NO_COPY*/NameLoc));
                }
              } else {
                JavaCleaner $c$ = $createJavaCleaner();
                try {
                  $c$.clean($c$.track($this().Diag($this().Tok, diag.err_expected_parameter_pack)));
                  $this().SkipUntil(tok.TokenKind.r_paren, SkipUntilFlags.StopAtSemi);
                } finally {
                  $c$.$destroy();
                }
              }
            } finally {
              if (T != null) { T.$destroy(); }
            }
          } else if ($this().Tok.is(tok.TokenKind.identifier)) {
            JavaCleaner $c$ = $createJavaCleaner();
            try {
              Name = $this().Tok.getIdentifierInfo();
              NameLoc.$assignMove($this().ConsumeToken());
              LParenLoc.$assignMove($this().PP.getLocForEndOfToken(/*NO_COPY*/EllipsisLoc));
              RParenLoc.$assignMove($this().PP.getLocForEndOfToken(/*NO_COPY*/NameLoc));
              $c$.clean($out_DiagnosticBuilder$C_FixItHint$C($out_DiagnosticBuilder$C_FixItHint$C($out_DiagnosticBuilder$C_IdentifierInfo$C$P($c$.track($this().Diag(new SourceLocation(LParenLoc), diag.err_paren_sizeof_parameter_pack)), 
                          Name), 
                      FixItHint.CreateInsertion(/*NO_COPY*/LParenLoc, new StringRef(/*KEEP_STR*/$LPAREN))), 
                  FixItHint.CreateInsertion(/*NO_COPY*/RParenLoc, new StringRef(/*KEEP_STR*/$RPAREN))));
            } finally {
              $c$.$destroy();
            }
          } else {
            JavaCleaner $c$ = $createJavaCleaner();
            try {
              $c$.clean($c$.track($this().Diag($this().Tok, diag.err_sizeof_parameter_pack)));
            } finally {
              $c$.$destroy();
            }
          }
          if (!(Name != null)) {
            return ExprError();
          }
          
          _Unevaluated/*J*/= new EnterExpressionEvaluationContext($this().Actions, Sema.ExpressionEvaluationContext.Unevaluated, 
              Sema.ReuseLambdaContextDecl_t.ReuseLambdaContextDecl);
          
          return $this().Actions.ActOnSizeofParameterPackExpr($this().getCurScope(), 
              OpTok.getLocation(), 
              $Deref(Name), new SourceLocation(NameLoc), 
              new SourceLocation(RParenLoc));
        } finally {
          if (_Unevaluated != null) { _Unevaluated.$destroy(); }
        }
      }
      if (OpTok.isOneOf(tok.TokenKind.kw_alignof, tok.TokenKind.kw__Alignof)) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($c$.track($this().Diag(OpTok, diag.warn_cxx98_compat_alignof)));
        } finally {
          $c$.$destroy();
        }
      }
      
      Unevaluated/*J*/= new EnterExpressionEvaluationContext($this().Actions, Sema.ExpressionEvaluationContext.Unevaluated, 
          Sema.ReuseLambdaContextDecl_t.ReuseLambdaContextDecl);
      
      bool$ref isCastExpr = create_bool$ref();
      OpaquePtr<QualType> CastTy/*J*/= new OpaquePtr<QualType>();
      SourceRange CastRange/*J*/= new SourceRange();
      ActionResultTTrue<Expr /*P*/ > Operand = $this().ParseExprAfterUnaryExprOrTypeTrait(OpTok, 
          isCastExpr, 
          CastTy, 
          CastRange);
      
      UnaryExprOrTypeTrait ExprKind = UnaryExprOrTypeTrait.UETT_SizeOf;
      if (OpTok.isOneOf$T(tok.TokenKind.kw_alignof, tok.TokenKind.kw___alignof, tok.TokenKind.kw__Alignof)) {
        ExprKind = UnaryExprOrTypeTrait.UETT_AlignOf;
      } else if (OpTok.is(tok.TokenKind.kw_vec_step)) {
        ExprKind = UnaryExprOrTypeTrait.UETT_VecStep;
      } else if (OpTok.is(tok.TokenKind.kw___builtin_omp_required_simd_align)) {
        ExprKind = UnaryExprOrTypeTrait.UETT_OpenMPRequiredSimdAlign;
      }
      if (isCastExpr.$deref()) {
        return $this().Actions.ActOnUnaryExprOrTypeTraitExpr(OpTok.getLocation(), 
            ExprKind, 
            /*isType=*/ true, 
            CastTy.getAsOpaquePtr(), 
            new SourceRange(CastRange));
      }
      if (OpTok.isOneOf(tok.TokenKind.kw_alignof, tok.TokenKind.kw__Alignof)) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_DiagnosticBuilder$C_IdentifierInfo$C$P($c$.track($this().Diag(OpTok, diag.ext_alignof_expr)), OpTok.getIdentifierInfo()));
        } finally {
          $c$.$destroy();
        }
      }
      
      // If we get here, the operand to the sizeof/alignof was an expresion.
      if (!Operand.isInvalid()) {
        Operand.$assignMove($this().Actions.ActOnUnaryExprOrTypeTraitExpr(OpTok.getLocation(), 
                ExprKind, 
                /*isType=*/ false, 
                Operand.get(), 
                new SourceRange(CastRange)));
      }
      return Operand;
    } finally {
      if (Unevaluated != null) { Unevaluated.$destroy(); }
    }
  }


/// ParseBuiltinPrimaryExpression
///
/// \verbatim
///       primary-expression: [C99 6.5.1]
/// [GNU]   '__builtin_va_arg' '(' assignment-expression ',' type-name ')'
/// [GNU]   '__builtin_offsetof' '(' type-name ',' offsetof-member-designator')'
/// [GNU]   '__builtin_choose_expr' '(' assign-expr ',' assign-expr ','
///                                     assign-expr ')'
/// [GNU]   '__builtin_types_compatible_p' '(' type-name ',' type-name ')'
/// [OCL]   '__builtin_astype' '(' assignment-expression ',' type-name ')'
///
/// [GNU] offsetof-member-designator:
/// [GNU]   identifier
/// [GNU]   offsetof-member-designator '.' identifier
/// [GNU]   offsetof-member-designator '[' expression ']'
/// \endverbatim
//<editor-fold defaultstate="collapsed" desc="clang::Parser::ParseBuiltinPrimaryExpression">
@Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseExpr.cpp", line = 1939,
   FQN="clang::Parser::ParseBuiltinPrimaryExpression", NM="_ZN5clang6Parser29ParseBuiltinPrimaryExpressionEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseExpr.cpp -nm=_ZN5clang6Parser29ParseBuiltinPrimaryExpressionEv")
  //</editor-fold>
  protected /*private*/ ActionResultTTrue<Expr /*P*/ > ParseBuiltinPrimaryExpression() {
    BalancedDelimiterTracker PT = null;
    try {
      ActionResultTTrue<Expr /*P*/ > Res/*J*/= new ActionResultTTrue<Expr /*P*/ >();
      /*const*/ IdentifierInfo /*P*/ BuiltinII = $this().Tok.getIdentifierInfo();
      
      /*tok.TokenKind*/char T = $this().Tok.getKind();
      SourceLocation StartLoc = $this().ConsumeToken(); // Eat the builtin identifier.
      
      // All of these start with an open paren.
      if ($this().Tok.isNot(tok.TokenKind.l_paren)) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          return $c$.clean(ExprError($out_DiagnosticBuilder$C_TokenKind($out_DiagnosticBuilder$C_IdentifierInfo$C$P($c$.track($this().Diag($this().Tok, diag.err_expected_after)), BuiltinII), 
                  tok.TokenKind.l_paren)));
        } finally {
          $c$.$destroy();
        }
      }
      
      PT/*J*/= new BalancedDelimiterTracker(/*Deref*/$this(), tok.TokenKind.l_paren);
      PT.consumeOpen();
      
      // TODO: Build AST.
      switch (T) {
       default:
        throw new llvm_unreachable("Not a builtin primary expression!");
       case tok.TokenKind.kw___builtin_va_arg:
        {
          ActionResultTTrue<Expr /*P*/ > Expr/*J*/= $this().ParseAssignmentExpression();
          if ($this().ExpectAndConsume(tok.TokenKind.comma)) {
            $this().SkipUntil(tok.TokenKind.r_paren, SkipUntilFlags.StopAtSemi);
            Expr.$assignMove(ExprError());
          }
          
          ActionResult<OpaquePtr<QualType> > Ty = $this().ParseTypeName();
          if ($this().Tok.isNot(tok.TokenKind.r_paren)) {
            JavaCleaner $c$ = $createJavaCleaner();
            try {
              $c$.clean($out_DiagnosticBuilder$C_TokenKind($c$.track($this().Diag($this().Tok, diag.err_expected)), tok.TokenKind.r_paren));
              Expr.$assignMove(ExprError());
            } finally {
              $c$.$destroy();
            }
          }
          if (Expr.isInvalid() || Ty.isInvalid()) {
            Res.$assignMove(ExprError());
          } else {
            Res.$assignMove($this().Actions.ActOnVAArg(new SourceLocation(StartLoc), Expr.get(), Ty.get(), $this().ConsumeParen()));
          }
          break;
        }
       case tok.TokenKind.kw___builtin_offsetof:
        {
          SourceLocation TypeLoc = $this().Tok.getLocation();
          ActionResult<OpaquePtr<QualType> > Ty = $this().ParseTypeName();
          if (Ty.isInvalid()) {
            $this().SkipUntil(tok.TokenKind.r_paren, SkipUntilFlags.StopAtSemi);
            return ExprError();
          }
          if ($this().ExpectAndConsume(tok.TokenKind.comma)) {
            $this().SkipUntil(tok.TokenKind.r_paren, SkipUntilFlags.StopAtSemi);
            return ExprError();
          }
          
          // We must have at least one identifier here.
          if ($this().Tok.isNot(tok.TokenKind.identifier)) {
            JavaCleaner $c$ = $createJavaCleaner();
            try {
              $c$.clean($out_DiagnosticBuilder$C_TokenKind($c$.track($this().Diag($this().Tok, diag.err_expected)), tok.TokenKind.identifier));
              $this().SkipUntil(tok.TokenKind.r_paren, SkipUntilFlags.StopAtSemi);
              return ExprError();
            } finally {
              $c$.$destroy();
            }
          }
          
          // Keep track of the various subcomponents we see.
          SmallVector<Sema.OffsetOfComponent> Comps/*J*/= new SmallVector<Sema.OffsetOfComponent>(4, new Sema.OffsetOfComponent());
          
          Comps.push_back(new Sema.OffsetOfComponent());
          Comps.back().isBrackets = false;
          Comps.back().U.IdentInfo = $this().Tok.getIdentifierInfo();
          Comps.back().LocStart.$assign(Comps.back().LocEnd.$assignMove($this().ConsumeToken()));
          
          // FIXME: This loop leaks the index expressions on error.
          while (true) {
            if ($this().Tok.is(tok.TokenKind.period)) {
              // offsetof-member-designator: offsetof-member-designator '.' identifier
              Comps.push_back(new Sema.OffsetOfComponent());
              Comps.back().isBrackets = false;
              Comps.back().LocStart.$assignMove($this().ConsumeToken());
              if ($this().Tok.isNot(tok.TokenKind.identifier)) {
                JavaCleaner $c$ = $createJavaCleaner();
                try {
                  $c$.clean($out_DiagnosticBuilder$C_TokenKind($c$.track($this().Diag($this().Tok, diag.err_expected)), tok.TokenKind.identifier));
                  $this().SkipUntil(tok.TokenKind.r_paren, SkipUntilFlags.StopAtSemi);
                  return ExprError();
                } finally {
                  $c$.$destroy();
                }
              }
              Comps.back().U.IdentInfo = $this().Tok.getIdentifierInfo();
              Comps.back().LocEnd.$assignMove($this().ConsumeToken());
            } else if ($this().Tok.is(tok.TokenKind.l_square)) {
              BalancedDelimiterTracker ST = null;
              try {
                if ($this().CheckProhibitedCXX11Attribute()) {
                  return ExprError();
                }
                
                // offsetof-member-designator: offsetof-member-design '[' expression ']'
                Comps.push_back(new Sema.OffsetOfComponent());
                Comps.back().isBrackets = true;
                ST/*J*/= new BalancedDelimiterTracker(/*Deref*/$this(), tok.TokenKind.l_square);
                ST.consumeOpen();
                Comps.back().LocStart.$assignMove(ST.getOpenLocation());
                Res.$assignMove($this().ParseExpression());
                if (Res.isInvalid()) {
                  $this().SkipUntil(tok.TokenKind.r_paren, SkipUntilFlags.StopAtSemi);
                  return Res;
                }
                Comps.back().U.E = Res.get();
                
                ST.consumeClose();
                Comps.back().LocEnd.$assignMove(ST.getCloseLocation());
              } finally {
                if (ST != null) { ST.$destroy(); }
              }
            } else {
              if ($this().Tok.isNot(tok.TokenKind.r_paren)) {
                PT.consumeClose();
                Res.$assignMove(ExprError());
              } else if (Ty.isInvalid()) {
                Res.$assignMove(ExprError());
              } else {
                PT.consumeClose();
                Res.$assignMove($this().Actions.ActOnBuiltinOffsetOf($this().getCurScope(), new SourceLocation(StartLoc), new SourceLocation(TypeLoc), 
                        Ty.get(), new ArrayRef<Sema.OffsetOfComponent>(Comps), 
                        PT.getCloseLocation()));
              }
              break;
            }
          }
          break;
        }
       case tok.TokenKind.kw___builtin_choose_expr:
        {
          ActionResultTTrue<Expr /*P*/ > Cond/*J*/= $this().ParseAssignmentExpression();
          if (Cond.isInvalid()) {
            $this().SkipUntil(tok.TokenKind.r_paren, SkipUntilFlags.StopAtSemi);
            return Cond;
          }
          if ($this().ExpectAndConsume(tok.TokenKind.comma)) {
            $this().SkipUntil(tok.TokenKind.r_paren, SkipUntilFlags.StopAtSemi);
            return ExprError();
          }
          
          ActionResultTTrue<Expr /*P*/ > Expr1/*J*/= $this().ParseAssignmentExpression();
          if (Expr1.isInvalid()) {
            $this().SkipUntil(tok.TokenKind.r_paren, SkipUntilFlags.StopAtSemi);
            return Expr1;
          }
          if ($this().ExpectAndConsume(tok.TokenKind.comma)) {
            $this().SkipUntil(tok.TokenKind.r_paren, SkipUntilFlags.StopAtSemi);
            return ExprError();
          }
          
          ActionResultTTrue<Expr /*P*/ > Expr2/*J*/= $this().ParseAssignmentExpression();
          if (Expr2.isInvalid()) {
            $this().SkipUntil(tok.TokenKind.r_paren, SkipUntilFlags.StopAtSemi);
            return Expr2;
          }
          if ($this().Tok.isNot(tok.TokenKind.r_paren)) {
            JavaCleaner $c$ = $createJavaCleaner();
            try {
              $c$.clean($out_DiagnosticBuilder$C_TokenKind($c$.track($this().Diag($this().Tok, diag.err_expected)), tok.TokenKind.r_paren));
              return ExprError();
            } finally {
              $c$.$destroy();
            }
          }
          Res.$assignMove($this().Actions.ActOnChooseExpr(new SourceLocation(StartLoc), Cond.get(), Expr1.get(), 
                  Expr2.get(), $this().ConsumeParen()));
          break;
        }
       case tok.TokenKind.kw___builtin_astype:
        {
          // The first argument is an expression to be converted, followed by a comma.
          ActionResultTTrue<Expr /*P*/ > Expr/*J*/= $this().ParseAssignmentExpression();
          if (Expr.isInvalid()) {
            $this().SkipUntil(tok.TokenKind.r_paren, SkipUntilFlags.StopAtSemi);
            return ExprError();
          }
          if ($this().ExpectAndConsume(tok.TokenKind.comma)) {
            $this().SkipUntil(tok.TokenKind.r_paren, SkipUntilFlags.StopAtSemi);
            return ExprError();
          }
          
          // Second argument is the type to bitcast to.
          ActionResult<OpaquePtr<QualType> > DestTy = $this().ParseTypeName();
          if (DestTy.isInvalid()) {
            return ExprError();
          }
          
          // Attempt to consume the r-paren.
          if ($this().Tok.isNot(tok.TokenKind.r_paren)) {
            JavaCleaner $c$ = $createJavaCleaner();
            try {
              $c$.clean($out_DiagnosticBuilder$C_TokenKind($c$.track($this().Diag($this().Tok, diag.err_expected)), tok.TokenKind.r_paren));
              $this().SkipUntil(tok.TokenKind.r_paren, SkipUntilFlags.StopAtSemi);
              return ExprError();
            } finally {
              $c$.$destroy();
            }
          }
          
          Res.$assignMove($this().Actions.ActOnAsTypeExpr(Expr.get(), DestTy.get(), new SourceLocation(StartLoc), 
                  $this().ConsumeParen()));
          break;
        }
       case tok.TokenKind.kw___builtin_convertvector:
        {
          // The first argument is an expression to be converted, followed by a comma.
          ActionResultTTrue<Expr /*P*/ > Expr/*J*/= $this().ParseAssignmentExpression();
          if (Expr.isInvalid()) {
            $this().SkipUntil(tok.TokenKind.r_paren, SkipUntilFlags.StopAtSemi);
            return ExprError();
          }
          if ($this().ExpectAndConsume(tok.TokenKind.comma)) {
            $this().SkipUntil(tok.TokenKind.r_paren, SkipUntilFlags.StopAtSemi);
            return ExprError();
          }
          
          // Second argument is the type to bitcast to.
          ActionResult<OpaquePtr<QualType> > DestTy = $this().ParseTypeName();
          if (DestTy.isInvalid()) {
            return ExprError();
          }
          
          // Attempt to consume the r-paren.
          if ($this().Tok.isNot(tok.TokenKind.r_paren)) {
            JavaCleaner $c$ = $createJavaCleaner();
            try {
              $c$.clean($out_DiagnosticBuilder$C_TokenKind($c$.track($this().Diag($this().Tok, diag.err_expected)), tok.TokenKind.r_paren));
              $this().SkipUntil(tok.TokenKind.r_paren, SkipUntilFlags.StopAtSemi);
              return ExprError();
            } finally {
              $c$.$destroy();
            }
          }
          
          Res.$assignMove($this().Actions.ActOnConvertVectorExpr(Expr.get(), DestTy.get(), new SourceLocation(StartLoc), 
                  $this().ConsumeParen()));
          break;
        }
      }
      if (Res.isInvalid()) {
        return ExprError();
      }
      
      // These can be followed by postfix-expr pieces because they are
      // primary-expressions.
      return $this().ParsePostfixExpressionSuffix(new ActionResultTTrue<Expr /*P*/ >(JD$T.INSTANCE, Res.get()));
    } finally {
      if (PT != null) { PT.$destroy(); }
    }
  }


/// ParseExprAfterUnaryExprOrTypeTrait - We parsed a typeof/sizeof/alignof/
/// vec_step and we are at the start of an expression or a parenthesized
/// type-id. OpTok is the operand token (typeof/sizeof/alignof). Returns the
/// expression (isCastExpr == false) or the type (isCastExpr == true).
///
/// \verbatim
///       unary-expression:  [C99 6.5.3]
///         'sizeof' unary-expression
///         'sizeof' '(' type-name ')'
/// [GNU]   '__alignof' unary-expression
/// [GNU]   '__alignof' '(' type-name ')'
/// [C11]   '_Alignof' '(' type-name ')'
/// [C++0x] 'alignof' '(' type-id ')'
///
/// [GNU]   typeof-specifier:
///           typeof ( expressions )
///           typeof ( type-name )
/// [GNU/C++] typeof unary-expression
///
/// [OpenCL 1.1 6.11.12] vec_step built-in function:
///           vec_step ( expressions )
///           vec_step ( type-name )
/// \endverbatim
//<editor-fold defaultstate="collapsed" desc="clang::Parser::ParseExprAfterUnaryExprOrTypeTrait">
@Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseExpr.cpp", line = 1736,
   FQN="clang::Parser::ParseExprAfterUnaryExprOrTypeTrait", NM="_ZN5clang6Parser34ParseExprAfterUnaryExprOrTypeTraitERKNS_5TokenERbRNS_9OpaquePtrINS_8QualTypeEEERNS_11SourceRangeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseExpr.cpp -nm=_ZN5clang6Parser34ParseExprAfterUnaryExprOrTypeTraitERKNS_5TokenERbRNS_9OpaquePtrINS_8QualTypeEEERNS_11SourceRangeE")
  //</editor-fold>
  protected /*private*/ ActionResultTTrue<Expr /*P*/ > ParseExprAfterUnaryExprOrTypeTrait(final /*const*/ Token /*&*/ OpTok, 
                                    final bool$ref/*bool &*/ isCastExpr, 
                                    final OpaquePtr<QualType> /*&*/ CastTy, 
                                    final SourceRange /*&*/ CastRange) {
    assert (OpTok.isOneOf$T(tok.TokenKind.kw_typeof, tok.TokenKind.kw_sizeof, tok.TokenKind.kw___alignof, tok.TokenKind.kw_alignof, tok.TokenKind.kw__Alignof, tok.TokenKind.kw_vec_step, tok.TokenKind.kw___builtin_omp_required_simd_align)) : "Not a typeof/sizeof/alignof/vec_step expression!";
    
    ActionResultTTrue<Expr /*P*/ > Operand/*J*/= new ActionResultTTrue<Expr /*P*/ >();
    
    // If the operand doesn't start with an '(', it must be an expression.
    if ($this().Tok.isNot(tok.TokenKind.l_paren)) {
      // If construct allows a form without parenthesis, user may forget to put
      // pathenthesis around type name.
      if (OpTok.isOneOf$T(tok.TokenKind.kw_sizeof, tok.TokenKind.kw___alignof, tok.TokenKind.kw_alignof, 
          tok.TokenKind.kw__Alignof)) {
        if ($this().isTypeIdUnambiguously()) {
          DeclSpec DS = null;
          Declarator DeclaratorInfo = null;
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            DS/*J*/= new DeclSpec($this().AttrFactory);
            $this().ParseSpecifierQualifierList(DS);
            DeclaratorInfo/*J*/= new Declarator(DS, Declarator.TheContext.TypeNameContext);
            $this().ParseDeclarator(DeclaratorInfo);
            
            SourceLocation LParenLoc = $this().PP.getLocForEndOfToken(OpTok.getLocation());
            SourceLocation RParenLoc = $this().PP.getLocForEndOfToken(/*NO_COPY*/$this().PrevTokLocation);
            $c$.clean($out_DiagnosticBuilder$C_FixItHint$C($out_DiagnosticBuilder$C_FixItHint$C($out_DiagnosticBuilder$C_char$ptr$C($c$.track($this().Diag(new SourceLocation(LParenLoc), diag.err_expected_parentheses_around_typename)), 
                        OpTok.getName()), 
                    FixItHint.CreateInsertion(/*NO_COPY*/LParenLoc, new StringRef(/*KEEP_STR*/$LPAREN))), 
                FixItHint.CreateInsertion(/*NO_COPY*/RParenLoc, new StringRef(/*KEEP_STR*/$RPAREN))));
            isCastExpr.$set(true);
            return ExprEmpty();
          } finally {
            if (DeclaratorInfo != null) { DeclaratorInfo.$destroy(); }
            if (DS != null) { DS.$destroy(); }
            $c$.$destroy();
          }
        }
      }
      
      isCastExpr.$set(false);
      if (OpTok.is(tok.TokenKind.kw_typeof) && !$this().getLangOpts().CPlusPlus) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_DiagnosticBuilder$C_TokenKind($out_DiagnosticBuilder$C_IdentifierInfo$C$P($c$.track($this().Diag($this().Tok, diag.err_expected_after)), OpTok.getIdentifierInfo()), 
              tok.TokenKind.l_paren));
          return ExprError();
        } finally {
          $c$.$destroy();
        }
      }
      
      Operand.$assignMove($this().ParseCastExpression(true/*isUnaryExpression*/));
    } else {
      // If it starts with a '(', we know that it is either a parenthesized
      // type-name, or it is a unary-expression that starts with a compound
      // literal, or starts with a primary-expression that is a parenthesized
      // expression.
      final type$ref<ParenParseOption> ExprType = create_type$ref(ParenParseOption.CastExpr);
      SourceLocation LParenLoc = $this().Tok.getLocation(), RParenLoc/*J*/= new SourceLocation();
      
      Operand.$assignMove($this().ParseParenExpression(ExprType, true/*stopIfCastExpr*/, 
              false, CastTy, RParenLoc));
      CastRange.$assignMove(new SourceRange(/*NO_COPY*/LParenLoc, /*NO_COPY*/RParenLoc));
      
      // If ParseParenExpression parsed a '(typename)' sequence only, then this is
      // a type.
      if (ExprType.$deref() == ParenParseOption.CastExpr) {
        isCastExpr.$set(true);
        return ExprEmpty();
      }
      if ($this().getLangOpts().CPlusPlus || OpTok.isNot(tok.TokenKind.kw_typeof)) {
        // GNU typeof in C requires the expression to be parenthesized. Not so for
        // sizeof/alignof or in C++. Therefore, the parenthesized expression is
        // the start of a unary-expression, but doesn't include any postfix 
        // pieces. Parse these now if present.
        if (!Operand.isInvalid()) {
          Operand.$assignMove($this().ParsePostfixExpressionSuffix(new ActionResultTTrue<Expr /*P*/ >(JD$T.INSTANCE, Operand.get())));
        }
      }
    }
    
    // If we get here, the operand to the typeof/sizeof/alignof was an expresion.
    isCastExpr.$set(false);
    return Operand;
  }


/// ParseExpressionList - Used for C/C++ (argument-)expression-list.

/// ParseExpressionList - Used for C/C++ (argument-)expression-list.
///
/// \verbatim
///       argument-expression-list:
///         assignment-expression
///         argument-expression-list , assignment-expression
///
/// [C++] expression-list:
/// [C++]   assignment-expression
/// [C++]   expression-list , assignment-expression
///
/// [C++0x] expression-list:
/// [C++0x]   initializer-list
///
/// [C++0x] initializer-list
/// [C++0x]   initializer-clause ...[opt]
/// [C++0x]   initializer-list , initializer-clause ...[opt]
///
/// [C++0x] initializer-clause:
/// [C++0x]   assignment-expression
/// [C++0x]   braced-init-list
/// \endverbatim
//<editor-fold defaultstate="collapsed" desc="clang::Parser::ParseExpressionList">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseExpr.cpp", line = 2658,
   FQN="clang::Parser::ParseExpressionList", NM="_ZN5clang6Parser19ParseExpressionListERN4llvm15SmallVectorImplIPNS_4ExprEEERNS2_INS_14SourceLocationEEESt8functionIFvvEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseExpr.cpp -nm=_ZN5clang6Parser19ParseExpressionListERN4llvm15SmallVectorImplIPNS_4ExprEEERNS2_INS_14SourceLocationEEESt8functionIFvvEE")
  //</editor-fold>
  protected /*private*/ boolean ParseExpressionList(final SmallVectorImpl<Expr /*P*/ > /*&*/ Exprs, 
                     final SmallVectorImpl<SourceLocation> /*&*/ CommaLocs) {
    return $this().ParseExpressionList(Exprs, 
                     CommaLocs, 
                     (Void2Void)null);
  }
  protected /*private*/ boolean ParseExpressionList(final SmallVectorImpl<Expr /*P*/ > /*&*/ Exprs, 
                     final SmallVectorImpl<SourceLocation> /*&*/ CommaLocs, 
                     Void2Void Completer/*= null*/) {
    boolean SawError = false;
    while (true) {
      if ($this().Tok.is(tok.TokenKind.code_completion)) {
        if (Completer != null) {
          Completer.$call();
        } else {
          $this().Actions.CodeCompleteOrdinaryName($this().getCurScope(), Sema.ParserCompletionContext.PCC_Expression);
        }
        $this().cutOffParsing();
        return true;
      }
      
      ActionResultTTrue<Expr /*P*/ > Expr/*J*/= new ActionResultTTrue<Expr /*P*/ >();
      if ($this().getLangOpts().CPlusPlus11 && $this().Tok.is(tok.TokenKind.l_brace)) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($c$.track($this().Diag($this().Tok, diag.warn_cxx98_compat_generalized_initializer_lists)));
          Expr.$assignMove($this().ParseBraceInitializer());
        } finally {
          $c$.$destroy();
        }
      } else {
        Expr.$assignMove($this().ParseAssignmentExpression());
      }
      if ($this().Tok.is(tok.TokenKind.ellipsis)) {
        Expr.$assignMove($this().Actions.ActOnPackExpansion(Expr.get(), $this().ConsumeToken()));
      }
      if (Expr.isInvalid()) {
        $this().SkipUntil(tok.TokenKind.comma, tok.TokenKind.r_paren, SkipUntilFlags.StopBeforeMatch);
        SawError = true;
      } else {
        Exprs.push_back(Expr.get());
      }
      if ($this().Tok.isNot(tok.TokenKind.comma)) {
        break;
      }
      // Move to the next argument, remember where the comma was.
      CommaLocs.push_back($this().ConsumeToken());
    }
    if (SawError) {
      // Ensure typos get diagnosed when errors were encountered while parsing the
      // expression list.
      for (int i = 0; i < Exprs.size(); i++) { // JAVA
        ActionResultTTrue<Expr /*P*/ > Expr = $this().Actions.CorrectDelayedTyposInExpr(Exprs.$at(i));
        if (Expr.isUsable()) {
          Exprs.$set(i, Expr.get());
        }
      }
    }
    return SawError;
  }


/// ParseSimpleExpressionList - A simple comma-separated list of expressions,
/// used for misc language extensions.

/// ParseSimpleExpressionList - A simple comma-separated list of expressions,
/// used for misc language extensions.
///
/// \verbatim
///       simple-expression-list:
///         assignment-expression
///         simple-expression-list , assignment-expression
/// \endverbatim
//<editor-fold defaultstate="collapsed" desc="clang::Parser::ParseSimpleExpressionList">
@Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseExpr.cpp", line = 2712,
   FQN="clang::Parser::ParseSimpleExpressionList", NM="_ZN5clang6Parser25ParseSimpleExpressionListERN4llvm15SmallVectorImplIPNS_4ExprEEERNS2_INS_14SourceLocationEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseExpr.cpp -nm=_ZN5clang6Parser25ParseSimpleExpressionListERN4llvm15SmallVectorImplIPNS_4ExprEEERNS2_INS_14SourceLocationEEE")
  //</editor-fold>
  protected /*private*/ boolean ParseSimpleExpressionList(final SmallVectorImpl<Expr /*P*/ > /*&*/ Exprs, 
                           final SmallVectorImpl<SourceLocation> /*&*/ CommaLocs) {
    while (true) {
      ActionResultTTrue<Expr /*P*/ > Expr = $this().ParseAssignmentExpression();
      if (Expr.isInvalid()) {
        return true;
      }
      
      Exprs.push_back(Expr.get());
      if ($this().Tok.isNot(tok.TokenKind.comma)) {
        return false;
      }
      
      // Move to the next argument, remember where the comma was.
      CommaLocs.push_back($this().ConsumeToken());
    }
  }


/// ParseParenExpression - This parses the unit that starts with a '(' token,
/// based on what is allowed by ExprType.  The actual thing parsed is returned
/// in ExprType. If stopIfCastExpr is true, it will only return the parsed type,
/// not the parsed cast-expression.
///
/// \verbatim
///       primary-expression: [C99 6.5.1]
///         '(' expression ')'
/// [GNU]   '(' compound-statement ')'      (if !ParenExprOnly)
///       postfix-expression: [C99 6.5.2]
///         '(' type-name ')' '{' initializer-list '}'
///         '(' type-name ')' '{' initializer-list ',' '}'
///       cast-expression: [C99 6.5.4]
///         '(' type-name ')' cast-expression
/// [ARC]   bridged-cast-expression
/// [ARC] bridged-cast-expression:
///         (__bridge type-name) cast-expression
///         (__bridge_transfer type-name) cast-expression
///         (__bridge_retained type-name) cast-expression
///       fold-expression: [C++1z]
///         '(' cast-expression fold-operator '...' ')'
///         '(' '...' fold-operator cast-expression ')'
///         '(' cast-expression fold-operator '...'
///                 fold-operator cast-expression ')'
/// \endverbatim
//<editor-fold defaultstate="collapsed" desc="clang::Parser::ParseParenExpression">
@Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseExpr.cpp", line = 2186,
   FQN="clang::Parser::ParseParenExpression", NM="_ZN5clang6Parser20ParseParenExpressionERNS0_16ParenParseOptionEbbRNS_9OpaquePtrINS_8QualTypeEEERNS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseExpr.cpp -nm=_ZN5clang6Parser20ParseParenExpressionERNS0_16ParenParseOptionEbbRNS_9OpaquePtrINS_8QualTypeEEERNS_14SourceLocationE")
  //</editor-fold>
  protected /*private*/ ActionResultTTrue<Expr /*P*/ > ParseParenExpression(final type$ref<ParenParseOption>/*&*/ ExprType, boolean stopIfCastExpr, 
                      boolean isTypeCast, final OpaquePtr<QualType> /*&*/ CastTy, 
                      final SourceLocation /*&*/ RParenLoc) {
    ColonProtectionRAIIObject ColonProtection = null;
    BalancedDelimiterTracker T = null;
    try {
      assert ($this().Tok.is(tok.TokenKind.l_paren)) : "Not a paren expr!";
      ColonProtection/*J*/= new ColonProtectionRAIIObject(/*Deref*/$this(), false);
      T/*J*/= new BalancedDelimiterTracker(/*Deref*/$this(), tok.TokenKind.l_paren);
      if (T.consumeOpen()) {
        return ExprError();
      }
      SourceLocation OpenLoc = T.getOpenLocation();
      
      ActionResultTTrue<Expr /*P*/ > Result/*J*/= new ActionResultTTrue<Expr /*P*/ >(true);
      bool$ref isAmbiguousTypeId = create_bool$ref();
      CastTy.$assignMove(new OpaquePtr<QualType>(null));
      if ($this().Tok.is(tok.TokenKind.code_completion)) {
        $this().Actions.CodeCompleteOrdinaryName($this().getCurScope(), 
            ExprType.$deref().getValue() >= ParenParseOption.CompoundLiteral.getValue() ? Sema.ParserCompletionContext.PCC_ParenthesizedExpression : Sema.ParserCompletionContext.PCC_Expression);
        $this().cutOffParsing();
        return ExprError();
      }
      
      // Diagnose use of bridge casts in non-arc mode.
      boolean BridgeCast = ($this().getLangOpts().ObjC2
         && $this().Tok.isOneOf$T(tok.TokenKind.kw___bridge, 
          tok.TokenKind.kw___bridge_transfer, 
          tok.TokenKind.kw___bridge_retained, 
          tok.TokenKind.kw___bridge_retain));
      if (BridgeCast && !$this().getLangOpts().ObjCAutoRefCount) {
        if (!$this().TryConsumeToken(tok.TokenKind.kw___bridge)) {
          StringRef BridgeCastName = new StringRef($this().Tok.getName());
          SourceLocation BridgeKeywordLoc = $this().ConsumeToken();
          if (!$this().PP.getSourceManager().isInSystemHeader(/*NO_COPY*/BridgeKeywordLoc)) {
            JavaCleaner $c$ = $createJavaCleaner();
            try {
              $c$.clean($out_DiagnosticBuilder$C_FixItHint$C($out_DiagnosticBuilder$C_StringRef($c$.track($this().Diag(/*NO_COPY*/BridgeKeywordLoc, diag.warn_arc_bridge_cast_nonarc)), 
                      /*NO_COPY*/BridgeCastName), 
                  FixItHint.CreateReplacement(new SourceRange(/*NO_COPY*/BridgeKeywordLoc), new StringRef(/*KEEP_STR*/$EMPTY))));
            } finally {
              $c$.$destroy();
            }
          }
        }
        BridgeCast = false;
      }
      
      // None of these cases should fall through with an invalid Result
      // unless they've already reported an error.
      if (ExprType.$deref().getValue() >= ParenParseOption.CompoundStmt.getValue() && $this().Tok.is(tok.TokenKind.l_brace)) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($c$.track($this().Diag($this().Tok, diag.ext_gnu_statement_expr)));
          if (!($this().getCurScope().getFnParent() != null) && !($this().getCurScope().getBlockParent() != null)) {
            $c$.clean(Result.$assignMove(ExprError($c$.track($this().Diag(/*NO_COPY*/OpenLoc, diag.err_stmtexpr_file_scope)))));
          } else {
            Sema.ContextRAII SavedContext = null;
            try {
              // Find the nearest non-record decl context. Variables declared in a
              // statement expression behave as if they were declared in the enclosing
              // function, block, or other code construct.
              DeclContext /*P*/ CodeDC = $this().Actions.CurContext;
              while (CodeDC.isRecord() || isa(EnumDecl.class, CodeDC)) {
                CodeDC = CodeDC.getParent();
                assert ((CodeDC != null) && !CodeDC.isFileContext()) : "statement expr not in code context";
              }
              SavedContext/*J*/= new Sema.ContextRAII($this().Actions, CodeDC, /*NewThisContext=*/ false);
              
              $this().Actions.ActOnStartStmtExpr();
              
              ActionResultTTrue<Stmt /*P*/ > Stmt/*J*/= $this().ParseCompoundStatement(true);
              ExprType.$set(ParenParseOption.CompoundStmt);
              
              // If the substmt parsed correctly, build the AST node.
              if (!Stmt.isInvalid()) {
                Result.$assignMove($this().Actions.ActOnStmtExpr(new SourceLocation(OpenLoc), Stmt.get(), $this().Tok.getLocation()));
              } else {
                $this().Actions.ActOnStmtExprError();
              }
            } finally {
              if (SavedContext != null) { SavedContext.$destroy(); }
            }
          }
        } finally {
          $c$.$destroy();
        }
      } else if (ExprType.$deref().getValue() >= ParenParseOption.CompoundLiteral.getValue() && BridgeCast) {
        /*tok.TokenKind*/char tokenKind = $this().Tok.getKind();
        SourceLocation BridgeKeywordLoc = $this().ConsumeToken();
        
        // Parse an Objective-C ARC ownership cast expression.
        ObjCBridgeCastKind Kind;
        if (tokenKind == tok.TokenKind.kw___bridge) {
          Kind = ObjCBridgeCastKind.OBC_Bridge;
        } else if (tokenKind == tok.TokenKind.kw___bridge_transfer) {
          Kind = ObjCBridgeCastKind.OBC_BridgeTransfer;
        } else if (tokenKind == tok.TokenKind.kw___bridge_retained) {
          Kind = ObjCBridgeCastKind.OBC_BridgeRetained;
        } else {
          // As a hopefully temporary workaround, allow __bridge_retain as
          // a synonym for __bridge_retained, but only in system headers.
          assert (tokenKind == tok.TokenKind.kw___bridge_retain);
          Kind = ObjCBridgeCastKind.OBC_BridgeRetained;
          if (!$this().PP.getSourceManager().isInSystemHeader(/*NO_COPY*/BridgeKeywordLoc)) {
            JavaCleaner $c$ = $createJavaCleaner();
            try {
              $c$.clean($out_DiagnosticBuilder$C_FixItHint$C($c$.track($this().Diag(/*NO_COPY*/BridgeKeywordLoc, diag.err_arc_bridge_retain)), 
                  FixItHint.CreateReplacement(new SourceRange(/*NO_COPY*/BridgeKeywordLoc), 
                      new StringRef(/*KEEP_STR*/$__bridge_retained))));
            } finally {
              $c$.$destroy();
            }
          }
        }
        
        ActionResult<OpaquePtr<QualType> > Ty = $this().ParseTypeName();
        T.consumeClose();
        ColonProtection.restore();
        RParenLoc.$assignMove(T.getCloseLocation());
        ActionResultTTrue<Expr /*P*/ > SubExpr = $this().ParseCastExpression(/*isUnaryExpression=*/ false);
        if (Ty.isInvalid() || SubExpr.isInvalid()) {
          return ExprError();
        }
        
        return $this().Actions.ActOnObjCBridgedCast($this().getCurScope(), new SourceLocation(OpenLoc), Kind, 
            new SourceLocation(BridgeKeywordLoc), Ty.get(), 
            new SourceLocation(RParenLoc), SubExpr.get());
      } else if (ExprType.$deref().getValue() >= ParenParseOption.CompoundLiteral.getValue()
         && $this().isTypeIdInParens(isAmbiguousTypeId)) {
        DeclSpec DS = null;
        Declarator DeclaratorInfo = null;
        try {
          
          // Otherwise, this is a compound literal expression or cast expression.
          
          // In C++, if the type-id is ambiguous we disambiguate based on context.
          // If stopIfCastExpr is true the context is a typeof/sizeof/alignof
          // in which case we should treat it as type-id.
          // if stopIfCastExpr is false, we need to determine the context past the
          // parens, so we defer to ParseCXXAmbiguousParenExpression for that.
          if (isAmbiguousTypeId.$deref() && !stopIfCastExpr) {
            ActionResultTTrue<Expr /*P*/ > res = $this().ParseCXXAmbiguousParenExpression(ExprType, CastTy, T, 
                ColonProtection);
            RParenLoc.$assignMove(T.getCloseLocation());
            return res;
          }
          
          // Parse the type declarator.
          DS/*J*/= new DeclSpec($this().AttrFactory);
          $this().ParseSpecifierQualifierList(DS);
          DeclaratorInfo/*J*/= new Declarator(DS, Declarator.TheContext.TypeNameContext);
          $this().ParseDeclarator(DeclaratorInfo);
          
          // If our type is followed by an identifier and either ':' or ']', then 
          // this is probably an Objective-C message send where the leading '[' is
          // missing. Recover as if that were the case.
          if (!DeclaratorInfo.isInvalidType() && $this().Tok.is(tok.TokenKind.identifier)
             && !$this().InMessageExpression && $this().getLangOpts().ObjC1
             && ($this().NextToken().is(tok.TokenKind.colon) || $this().NextToken().is(tok.TokenKind.r_square))) {
            ActionResult<OpaquePtr<QualType> > Ty/*J*/= new ActionResult<OpaquePtr<QualType> >(JD$T.INSTANCE, new OpaquePtr<>());
            {
              InMessageExpressionRAIIObject InMessage = null;
              try {
                InMessage/*J*/= new InMessageExpressionRAIIObject(/*Deref*/$this(), false);
                Ty.$assignMove($this().Actions.ActOnTypeName($this().getCurScope(), DeclaratorInfo));
              } finally {
                if (InMessage != null) { InMessage.$destroy(); }
              }
            }
            Result.$assignMove($this().ParseObjCMessageExpressionBody(new SourceLocation(), 
                    new SourceLocation(), 
                    Ty.get(), (Expr /*P*/ )null));
          } else {
            JavaCleaner $c$ = $createJavaCleaner();
            try {
              // Match the ')'.
              T.consumeClose();
              ColonProtection.restore();
              RParenLoc.$assignMove(T.getCloseLocation());
              if ($this().Tok.is(tok.TokenKind.l_brace)) {
                ExprType.$set(ParenParseOption.CompoundLiteral);
                ActionResult<OpaquePtr<QualType> > Ty/*J*/= new ActionResult<OpaquePtr<QualType> >(JD$T.INSTANCE, new OpaquePtr<>());
                {
                  InMessageExpressionRAIIObject InMessage = null;
                  try {
                    InMessage/*J*/= new InMessageExpressionRAIIObject(/*Deref*/$this(), false);
                    Ty.$assignMove($this().Actions.ActOnTypeName($this().getCurScope(), DeclaratorInfo));
                  } finally {
                    if (InMessage != null) { InMessage.$destroy(); }
                  }
                }
                return $this().ParseCompoundLiteralExpression(Ty.get(), new SourceLocation(OpenLoc), new SourceLocation(RParenLoc));
              }
              if (ExprType.$deref() == ParenParseOption.CastExpr) {
                // We parsed '(' type-name ')' and the thing after it wasn't a '{'.
                if (DeclaratorInfo.isInvalidType()) {
                  return ExprError();
                }
                
                // Note that this doesn't parse the subsequent cast-expression, it just
                // returns the parsed type to the callee.
                if (stopIfCastExpr) {
                  ActionResult<OpaquePtr<QualType> > Ty/*J*/= new ActionResult<OpaquePtr<QualType> >(JD$T.INSTANCE, new OpaquePtr<>());
                  {
                    InMessageExpressionRAIIObject InMessage = null;
                    try {
                      InMessage/*J*/= new InMessageExpressionRAIIObject(/*Deref*/$this(), false);
                      Ty.$assignMove($this().Actions.ActOnTypeName($this().getCurScope(), DeclaratorInfo));
                    } finally {
                      if (InMessage != null) { InMessage.$destroy(); }
                    }
                  }
                  CastTy.$assignMove(Ty.get());
                  return new ActionResultTTrue<Expr /*P*/ >();
                }
                
                // Reject the cast of super idiom in ObjC.
                if ($this().Tok.is(tok.TokenKind.identifier) && $this().getLangOpts().ObjC1
                   && $this().Tok.getIdentifierInfo() == $this().Ident_super
                   && $this().getCurScope().isInObjcMethodScope()
                   && $this().GetLookAheadToken(1).isNot(tok.TokenKind.period)) {
                  $c$.clean($out_DiagnosticBuilder$C_SourceRange($c$.track($this().Diag($this().Tok.getLocation(), diag.err_illegal_super_cast)), 
                      new SourceRange(/*NO_COPY*/OpenLoc, /*NO_COPY*/RParenLoc)));
                  return ExprError();
                }
                
                // Parse the cast-expression that follows it next.
                // TODO: For cast expression with CastTy.
                Result.$assignMove($this().ParseCastExpression(/*isUnaryExpression=*/ false, 
                        /*isAddressOfOperand=*/ false, 
                        /*isTypeCast=*/ TypeCastState.IsTypeCast));
                if (!Result.isInvalid()) {
                  Result.$assignMove($this().Actions.ActOnCastExpr($this().getCurScope(), new SourceLocation(OpenLoc), 
                          DeclaratorInfo, CastTy, 
                          new SourceLocation(RParenLoc), Result.get()));
                }
                return Result;
              }
              
              $c$.clean($c$.track($this().Diag($this().Tok, diag.err_expected_lbrace_in_compound_literal)));
              return ExprError();
            } finally {
              $c$.$destroy();
            }
          }
        } finally {
          if (DeclaratorInfo != null) { DeclaratorInfo.$destroy(); }
          if (DS != null) { DS.$destroy(); }
        }
      } else if ($this().Tok.is(tok.TokenKind.ellipsis)
         && isFoldOperator_TokenKind($this().NextToken().getKind())) {
        return $this().ParseFoldExpression(new ActionResultTTrue<Expr /*P*/ >(), T);
      } else if (isTypeCast) {
        InMessageExpressionRAIIObject InMessage = null;
        try {
          // Parse the expression-list.
          InMessage/*J*/= new InMessageExpressionRAIIObject(/*Deref*/$this(), false);
          
          SmallVector<Expr /*P*/ > ArgExprs/*J*/= new SmallVector<Expr /*P*/ >(12, (Expr /*P*/ )null);
          SmallVector<SourceLocation> CommaLocs/*J*/= new SmallVector<SourceLocation>(20, new SourceLocation());
          if (!$this().ParseSimpleExpressionList(ArgExprs, CommaLocs)) {
            // FIXME: If we ever support comma expressions as operands to
            // fold-expressions, we'll need to allow multiple ArgExprs here.
            if (ArgExprs.size() == 1 && isFoldOperator_TokenKind($this().Tok.getKind())
               && $this().NextToken().is(tok.TokenKind.ellipsis)) {
              return $this().ParseFoldExpression(new ActionResultTTrue<Expr /*P*/ >(Result), T);
            }
            
            ExprType.$set(ParenParseOption.SimpleExpr);
            Result.$assignMove($this().Actions.ActOnParenListExpr(new SourceLocation(OpenLoc), $this().Tok.getLocation(), 
                    new MutableArrayRef<Expr /*P*/ >(ArgExprs, true)));
          }
        } finally {
          if (InMessage != null) { InMessage.$destroy(); }
        }
      } else {
        InMessageExpressionRAIIObject InMessage = null;
        try {
          InMessage/*J*/= new InMessageExpressionRAIIObject(/*Deref*/$this(), false);
          
          Result.$assignMove($this().ParseExpression(TypeCastState.MaybeTypeCast));
          if (!$this().getLangOpts().CPlusPlus && ((TypeCastState.MaybeTypeCast).getValue() != 0) && Result.isUsable()) {
            // Correct typos in non-C++ code earlier so that implicit-cast-like
            // expressions are parsed correctly.
            Result.$assignMove($this().Actions.CorrectDelayedTyposInExpr(new ActionResultTTrue<Expr /*P*/ >(Result)));
          }
          ExprType.$set(ParenParseOption.SimpleExpr);
          if (isFoldOperator_TokenKind($this().Tok.getKind()) && $this().NextToken().is(tok.TokenKind.ellipsis)) {
            return $this().ParseFoldExpression(new ActionResultTTrue<Expr /*P*/ >(Result), T);
          }
          
          // Don't build a paren expression unless we actually match a ')'.
          if (!Result.isInvalid() && $this().Tok.is(tok.TokenKind.r_paren)) {
            Result.$assignMove(
                $this().Actions.ActOnParenExpr(new SourceLocation(OpenLoc), $this().Tok.getLocation(), Result.get())
            );
          }
        } finally {
          if (InMessage != null) { InMessage.$destroy(); }
        }
      }
      
      // Match the ')'.
      if (Result.isInvalid()) {
        $this().SkipUntil(tok.TokenKind.r_paren, SkipUntilFlags.StopAtSemi);
        return ExprError();
      }
      
      T.consumeClose();
      RParenLoc.$assignMove(T.getCloseLocation());
      return Result;
    } finally {
      if (T != null) { T.$destroy(); }
      if (ColonProtection != null) { ColonProtection.$destroy(); }
    }
  }


/// ParseCompoundLiteralExpression - We have parsed the parenthesized type-name
/// and we are at the left brace.
///
/// \verbatim
///       postfix-expression: [C99 6.5.2]
///         '(' type-name ')' '{' initializer-list '}'
///         '(' type-name ')' '{' initializer-list ',' '}'
/// \endverbatim
//<editor-fold defaultstate="collapsed" desc="clang::Parser::ParseCompoundLiteralExpression">
@Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseExpr.cpp", line = 2449,
   FQN="clang::Parser::ParseCompoundLiteralExpression", NM="_ZN5clang6Parser30ParseCompoundLiteralExpressionENS_9OpaquePtrINS_8QualTypeEEENS_14SourceLocationES4_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseExpr.cpp -nm=_ZN5clang6Parser30ParseCompoundLiteralExpressionENS_9OpaquePtrINS_8QualTypeEEENS_14SourceLocationES4_")
  //</editor-fold>
  protected /*private*/ ActionResultTTrue<Expr /*P*/ > ParseCompoundLiteralExpression(OpaquePtr<QualType> Ty, 
                                SourceLocation LParenLoc, 
                                SourceLocation RParenLoc) {
    assert ($this().Tok.is(tok.TokenKind.l_brace)) : "Not a compound literal!";
    if (!$this().getLangOpts().C99) { // Compound literals don't exist in C90.
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($c$.track($this().Diag(new SourceLocation(LParenLoc), diag.ext_c99_compound_literal)));
      } finally {
        $c$.$destroy();
      }
    }
    ActionResultTTrue<Expr /*P*/ > Result = $this().ParseInitializer();
    if (!Result.isInvalid() && Ty.$bool()) {
      return $this().Actions.ActOnCompoundLiteral(new SourceLocation(LParenLoc), new OpaquePtr<QualType>(Ty), new SourceLocation(RParenLoc), Result.get());
    }
    return Result;
  }


/// ParseStringLiteralExpression - This handles the various token types that
/// form string literals, and also handles string concatenation [C99 5.1.1.2,
/// translation phase #6].
///
/// \verbatim
///       primary-expression: [C99 6.5.1]
///         string-literal
/// \verbatim
//<editor-fold defaultstate="collapsed" desc="clang::Parser::ParseStringLiteralExpression">
@Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseExpr.cpp", line = 2470,
   FQN="clang::Parser::ParseStringLiteralExpression", NM="_ZN5clang6Parser28ParseStringLiteralExpressionEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseExpr.cpp -nm=_ZN5clang6Parser28ParseStringLiteralExpressionEb")
  //</editor-fold>
  protected /*private*/ ActionResultTTrue<Expr /*P*/ > ParseStringLiteralExpression() {
    return $this().ParseStringLiteralExpression(false);
  }
  protected /*private*/ ActionResultTTrue<Expr /*P*/ > ParseStringLiteralExpression(boolean AllowUserDefinedLiteral/*= false*/) {
    assert ($this().isTokenStringLiteral()) : "Not a string literal!";
    
    // String concat.  Note that keywords like __func__ and __FUNCTION__ are not
    // considered to be strings for concatenation purposes.
    SmallVectorToken StringToks/*J*/= new SmallVectorToken(4, /*new Token()*/(Token)null);
    
    do {
      StringToks.push_back($this().Tok);
      $this().ConsumeStringToken();
    } while ($this().isTokenStringLiteral());
    
    // Pass the set of string tokens, ready for concatenation, to the actions.
    return $this().Actions.ActOnStringLiteral(new ArrayRefToken(StringToks), 
        AllowUserDefinedLiteral ? $this().getCurScope() : (Scope /*P*/ )null);
  }


/// ParseGenericSelectionExpression - Parse a C11 generic-selection
/// [C11 6.5.1.1].
///
/// \verbatim
///    generic-selection:
///           _Generic ( assignment-expression , generic-assoc-list )
///    generic-assoc-list:
///           generic-association
///           generic-assoc-list , generic-association
///    generic-association:
///           type-name : assignment-expression
///           default : assignment-expression
/// \endverbatim
//<editor-fold defaultstate="collapsed" desc="clang::Parser::ParseGenericSelectionExpression">
@Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseExpr.cpp", line = 2501,
   FQN="clang::Parser::ParseGenericSelectionExpression", NM="_ZN5clang6Parser31ParseGenericSelectionExpressionEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseExpr.cpp -nm=_ZN5clang6Parser31ParseGenericSelectionExpressionEv")
  //</editor-fold>
  protected /*private*/ ActionResultTTrue<Expr /*P*/ > ParseGenericSelectionExpression() {
    BalancedDelimiterTracker T = null;
    try {
      assert ($this().Tok.is(tok.TokenKind.kw__Generic)) : "_Generic keyword expected";
      SourceLocation KeyLoc = $this().ConsumeToken();
      if (!$this().getLangOpts().C11) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($c$.track($this().Diag(new SourceLocation(KeyLoc), diag.ext_c11_generic_selection)));
        } finally {
          $c$.$destroy();
        }
      }
      
      T/*J*/= new BalancedDelimiterTracker(/*Deref*/$this(), tok.TokenKind.l_paren);
      if (T.expectAndConsume()) {
        return ExprError();
      }
      
      ActionResultTTrue<Expr /*P*/ > ControllingExpr/*J*/= new ActionResultTTrue<Expr /*P*/ >();
      {
        EnterExpressionEvaluationContext Unevaluated = null;
        try {
          // C11 6.5.1.1p3 "The controlling expression of a generic selection is
          // not evaluated."
          Unevaluated/*J*/= new EnterExpressionEvaluationContext($this().Actions, Sema.ExpressionEvaluationContext.Unevaluated);
          ControllingExpr.$assignMove(
              $this().Actions.CorrectDelayedTyposInExpr($this().ParseAssignmentExpression())
          );
          if (ControllingExpr.isInvalid()) {
            $this().SkipUntil(tok.TokenKind.r_paren, SkipUntilFlags.StopAtSemi);
            return ExprError();
          }
        } finally {
          if (Unevaluated != null) { Unevaluated.$destroy(); }
        }
      }
      if ($this().ExpectAndConsume(tok.TokenKind.comma)) {
        $this().SkipUntil(tok.TokenKind.r_paren, SkipUntilFlags.StopAtSemi);
        return ExprError();
      }
      
      SourceLocation DefaultLoc/*J*/= new SourceLocation();
      SmallVector<OpaquePtr<QualType>> Types/*J*/= new SmallVector<OpaquePtr<QualType>>(12, new OpaquePtr<QualType>());
      SmallVector<Expr /*P*/ > Exprs/*J*/= new SmallVector<Expr /*P*/ >(12, (Expr /*P*/ )null);
      do {
        OpaquePtr<QualType> Ty/*J*/= new OpaquePtr<QualType>();
        if ($this().Tok.is(tok.TokenKind.kw_default)) {
          // C11 6.5.1.1p2 "A generic selection shall have no more than one default
          // generic association."
          if (!DefaultLoc.isInvalid()) {
            JavaCleaner $c$ = $createJavaCleaner();
            try {
              $c$.clean($c$.track($this().Diag($this().Tok, diag.err_duplicate_default_assoc)));
              $c$.clean($c$.track($this().Diag(new SourceLocation(DefaultLoc), diag.note_previous_default_assoc)));
              $this().SkipUntil(tok.TokenKind.r_paren, SkipUntilFlags.StopAtSemi);
              return ExprError();
            } finally {
              $c$.$destroy();
            }
          }
          DefaultLoc.$assignMove($this().ConsumeToken());
          Ty.$assignMove(new OpaquePtr<QualType>(null));
        } else {
          ColonProtectionRAIIObject X = null;
          try {
            X/*J*/= new ColonProtectionRAIIObject(/*Deref*/$this());
            ActionResult<OpaquePtr<QualType> > TR = $this().ParseTypeName();
            if (TR.isInvalid()) {
              $this().SkipUntil(tok.TokenKind.r_paren, SkipUntilFlags.StopAtSemi);
              return ExprError();
            }
            Ty.$assignMove(TR.get());
          } finally {
            if (X != null) { X.$destroy(); }
          }
        }
        Types.push_back(Ty);
        if ($this().ExpectAndConsume(tok.TokenKind.colon)) {
          $this().SkipUntil(tok.TokenKind.r_paren, SkipUntilFlags.StopAtSemi);
          return ExprError();
        }
        
        // FIXME: These expressions should be parsed in a potentially potentially
        // evaluated context.
        ActionResultTTrue<Expr /*P*/ > ER/*J*/= $this().Actions.CorrectDelayedTyposInExpr($this().ParseAssignmentExpression());
        if (ER.isInvalid()) {
          $this().SkipUntil(tok.TokenKind.r_paren, SkipUntilFlags.StopAtSemi);
          return ExprError();
        }
        Exprs.push_back(ER.get());
      } while ($this().TryConsumeToken(tok.TokenKind.comma));
      
      T.consumeClose();
      if (T.getCloseLocation().isInvalid()) {
        return ExprError();
      }
      
      return $this().Actions.ActOnGenericSelectionExpr(new SourceLocation(KeyLoc), new SourceLocation(DefaultLoc), 
          T.getCloseLocation(), 
          ControllingExpr.get(), 
          new ArrayRef<OpaquePtr<QualType> >(Types), new ArrayRef<Expr /*P*/ >(Exprs));
    } finally {
      if (T != null) { T.$destroy(); }
    }
  }


/// ParseObjCBoolLiteral - This handles the objective-c Boolean literals.
///
///         '__objc_yes'
///         '__objc_no'
//<editor-fold defaultstate="collapsed" desc="clang::Parser::ParseObjCBoolLiteral">
@Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseExpr.cpp", line = 2871,
   FQN="clang::Parser::ParseObjCBoolLiteral", NM="_ZN5clang6Parser20ParseObjCBoolLiteralEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseExpr.cpp -nm=_ZN5clang6Parser20ParseObjCBoolLiteralEv")
  //</editor-fold>
  protected /*private*/ ActionResultTTrue<Expr /*P*/ > ParseObjCBoolLiteral() {
    /*tok.TokenKind*/char Kind = $this().Tok.getKind();
    return $this().Actions.ActOnObjCBoolLiteral($this().ConsumeToken(), Kind);
  }


/// \brief Parse A C++1z fold-expression after the opening paren and optional
/// left-hand-side expression.
///
/// \verbatim
///   fold-expression:
///       ( cast-expression fold-operator ... )
///       ( ... fold-operator cast-expression )
///       ( cast-expression fold-operator ... fold-operator cast-expression )
//<editor-fold defaultstate="collapsed" desc="clang::Parser::ParseFoldExpression">
@Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseExpr.cpp", line = 2591,
   FQN="clang::Parser::ParseFoldExpression", NM="_ZN5clang6Parser19ParseFoldExpressionENS_12ActionResultIPNS_4ExprELb1EEERNS_24BalancedDelimiterTrackerE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseExpr.cpp -nm=_ZN5clang6Parser19ParseFoldExpressionENS_12ActionResultIPNS_4ExprELb1EEERNS_24BalancedDelimiterTrackerE")
  //</editor-fold>
  protected /*private*/ ActionResultTTrue<Expr /*P*/ > ParseFoldExpression(ActionResultTTrue<Expr /*P*/ > LHS, 
                     final BalancedDelimiterTracker /*&*/ T) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      if (LHS.isInvalid()) {
        T.skipToEnd();
        return new ActionResultTTrue<Expr /*P*/ >(true);
      }
      
      /*tok.TokenKind*/char Kind = tok.TokenKind.unknown;
      SourceLocation FirstOpLoc/*J*/= new SourceLocation();
      if (LHS.isUsable()) {
        Kind = $this().Tok.getKind();
        assert (isFoldOperator_TokenKind(Kind)) : "missing fold-operator";
        FirstOpLoc.$assignMove($this().ConsumeToken());
      }
      assert ($this().Tok.is(tok.TokenKind.ellipsis)) : "not a fold-expression";
      SourceLocation EllipsisLoc = $this().ConsumeToken();
      
      ActionResultTTrue<Expr /*P*/ > RHS/*J*/= new ActionResultTTrue<Expr /*P*/ >();
      if ($this().Tok.isNot(tok.TokenKind.r_paren)) {
        if (!isFoldOperator_TokenKind($this().Tok.getKind())) {
          return $c$.clean(new ActionResultTTrue<Expr /*P*/ >($c$.track($this().Diag($this().Tok.getLocation(), diag.err_expected_fold_operator))));
        }
        if (Kind != tok.TokenKind.unknown && $this().Tok.getKind() != Kind) {
          $c$.clean($out_DiagnosticBuilder$C_SourceRange($c$.track($this().Diag($this().Tok.getLocation(), diag.err_fold_operator_mismatch)), 
              new SourceRange(/*NO_COPY*/FirstOpLoc)));
        }
        Kind = $this().Tok.getKind();
        $this().ConsumeToken();
        
        RHS.$assignMove($this().ParseExpression());
        if (RHS.isInvalid()) {
          T.skipToEnd();
          return new ActionResultTTrue<Expr /*P*/ >(true);
        }
      }
      
      $c$.clean($c$.track($this().Diag(new SourceLocation(EllipsisLoc), $this().getLangOpts().CPlusPlus1z ? diag.warn_cxx14_compat_fold_expression : diag.ext_fold_expression)));
      
      T.consumeClose();
      return $this().Actions.ActOnCXXFoldExpr(T.getOpenLocation(), LHS.get(), Kind, 
          new SourceLocation(EllipsisLoc), RHS.get(), T.getCloseLocation());
    } finally {
      $c$.$destroy();
    }
  }


//===--------------------------------------------------------------------===//
// clang Expressions

/// ParseBlockLiteralExpression - Parse a block literal, which roughly looks
/// like ^(int x){ return x+1; }
///
/// \verbatim
///         block-literal:
/// [clang]   '^' block-args[opt] compound-statement
/// [clang]   '^' block-id compound-statement
/// [clang] block-args:
/// [clang]   '(' parameter-list ')'
/// \endverbatim
//<editor-fold defaultstate="collapsed" desc="clang::Parser::ParseBlockLiteralExpression">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseExpr.cpp", line = 2766,
   FQN="clang::Parser::ParseBlockLiteralExpression", NM="_ZN5clang6Parser27ParseBlockLiteralExpressionEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseExpr.cpp -nm=_ZN5clang6Parser27ParseBlockLiteralExpressionEv")
  //</editor-fold>
  protected /*private*/ ActionResultTTrue<Expr /*P*/ > ParseBlockLiteralExpression() {
    PrettyStackTraceLoc CrashInfo = null;
    ParseScope BlockScope = null;
    DeclSpec DS = null;
    Declarator ParamInfo = null;
    try {
      assert ($this().Tok.is(tok.TokenKind.caret)) : "block literal starts with ^";
      SourceLocation CaretLoc = $this().ConsumeToken();
      
      CrashInfo/*J*/= new PrettyStackTraceLoc($this().PP.getSourceManager(), new SourceLocation(CaretLoc), 
          $("block literal parsing"));
      
      // Enter a scope to hold everything within the block.  This includes the
      // argument decls, decls within the compound expression, etc.  This also
      // allows determining whether a variable reference inside the block is
      // within or outside of the block.
      BlockScope/*J*/= new ParseScope($this(), Scope.ScopeFlags.BlockScope | Scope.ScopeFlags.FnScope
             | Scope.ScopeFlags.DeclScope);
      
      // Inform sema that we are starting a block.
      $this().Actions.ActOnBlockStart(new SourceLocation(CaretLoc), $this().getCurScope());
      
      // Parse the return type if present.
      DS/*J*/= new DeclSpec($this().AttrFactory);
      ParamInfo/*J*/= new Declarator(DS, Declarator.TheContext.BlockLiteralContext);
      // FIXME: Since the return type isn't actually parsed, it can't be used to
      // fill ParamInfo with an initial valid range, so do it manually.
      ParamInfo.SetSourceRange(new SourceRange($this().Tok.getLocation(), $this().Tok.getLocation()));
      
      // If this block has arguments, parse them.  There is no ambiguity here with
      // the expression case, because the expression case requires a parameter list.
      if ($this().Tok.is(tok.TokenKind.l_paren)) {
        $this().ParseParenDeclarator(ParamInfo);
        // Parse the pieces after the identifier as if we had "int(...)".
        // SetIdentifier sets the source range end, but in this case we're past
        // that location.
        SourceLocation Tmp = ParamInfo.getSourceRange().getEnd();
        ParamInfo.SetIdentifier((IdentifierInfo /*P*/ )null, new SourceLocation(CaretLoc));
        ParamInfo.SetRangeEnd(new SourceLocation(Tmp));
        if (ParamInfo.isInvalidType()) {
          // If there was an error parsing the arguments, they may have
          // tried to use ^(x+y) which requires an argument list.  Just
          // skip the whole block literal.
          $this().Actions.ActOnBlockError(new SourceLocation(CaretLoc), $this().getCurScope());
          return ExprError();
        }
        
        $this().MaybeParseGNUAttributes(ParamInfo);
        
        // Inform sema that we are starting a block.
        $this().Actions.ActOnBlockArguments(new SourceLocation(CaretLoc), ParamInfo, $this().getCurScope());
      } else if (!$this().Tok.is(tok.TokenKind.l_brace)) {
        $this().ParseBlockId(new SourceLocation(CaretLoc));
      } else {
        ParsedAttributes attrs = null;
        try {
          // Otherwise, pretend we saw (void).
          attrs/*J*/= new ParsedAttributes($this().AttrFactory);
          SourceLocation NoLoc/*J*/= new SourceLocation();
          ParamInfo.AddTypeInfo(DeclaratorChunk.getFunction(/*HasProto=*/ true, 
                  /*IsAmbiguous=*/ false, 
                  /*RParenLoc=*/ new SourceLocation(NoLoc), 
                  /*ArgInfo=*/ (type$ptr<ParamInfo> /*P*/ )null, 
                  /*NumArgs=*/ 0, 
                  /*EllipsisLoc=*/ new SourceLocation(NoLoc), 
                  /*RParenLoc=*/ new SourceLocation(NoLoc), 
                  /*TypeQuals=*/ 0, 
                  /*RefQualifierIsLvalueRef=*/ true, 
                  /*RefQualifierLoc=*/ new SourceLocation(NoLoc), 
                  /*ConstQualifierLoc=*/ new SourceLocation(NoLoc), 
                  /*VolatileQualifierLoc=*/ new SourceLocation(NoLoc), 
                  /*RestrictQualifierLoc=*/ new SourceLocation(NoLoc), 
                  /*MutableLoc=*/ new SourceLocation(NoLoc), 
                  ExceptionSpecificationType.EST_None, 
                  /*ESpecRange=*/ new SourceRange(), 
                  /*Exceptions=*/ (type$ptr<OpaquePtr<QualType>> /*P*/ )null, 
                  /*ExceptionRanges=*/ (type$ptr<SourceRange> /*P*/ )null, 
                  /*NumExceptions=*/ 0, 
                  /*NoexceptExpr=*/ (Expr /*P*/ )null, 
                  /*ExceptionSpecTokens=*/ (SmallVectorToken /*P*/)null, 
                  new SourceLocation(CaretLoc), new SourceLocation(CaretLoc), 
                  ParamInfo), 
              attrs, new SourceLocation(CaretLoc));
          
          $this().MaybeParseGNUAttributes(ParamInfo);
          
          // Inform sema that we are starting a block.
          $this().Actions.ActOnBlockArguments(new SourceLocation(CaretLoc), ParamInfo, $this().getCurScope());
        } finally {
          if (attrs != null) { attrs.$destroy(); }
        }
      }
      
      ActionResultTTrue<Expr /*P*/ > Result/*J*/= new ActionResultTTrue<Expr /*P*/ >(true);
      if (!$this().Tok.is(tok.TokenKind.l_brace)) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          // Saw something like: ^expr
          $c$.clean($c$.track($this().Diag($this().Tok, diag.err_expected_expression)));
          $this().Actions.ActOnBlockError(new SourceLocation(CaretLoc), $this().getCurScope());
          return ExprError();
        } finally {
          $c$.$destroy();
        }
      }
      
      ActionResultTTrue<Stmt /*P*/ > Stmt/*J*/= $this().ParseCompoundStatementBody();
      BlockScope.Exit();
      if (!Stmt.isInvalid()) {
        Result.$assignMove($this().Actions.ActOnBlockStmtExpr(new SourceLocation(CaretLoc), Stmt.get(), $this().getCurScope()));
      } else {
        $this().Actions.ActOnBlockError(new SourceLocation(CaretLoc), $this().getCurScope());
      }
      return Result;
    } finally {
      if (ParamInfo != null) { ParamInfo.$destroy(); }
      if (DS != null) { DS.$destroy(); }
      if (BlockScope != null) { BlockScope.$destroy(); }
      if (CrashInfo != null) { CrashInfo.$destroy(); }
    }
  }


/// \brief Parse an assignment expression where part of an Objective-C message
/// send has already been parsed.
///
/// In this case \p LBracLoc indicates the location of the '[' of the message
/// send, and either \p ReceiverName or \p ReceiverExpr is non-null indicating
/// the receiver of the message.
///
/// Since this handles full assignment-expression's, it handles postfix
/// expressions and other binary operators for these expressions as well.
//<editor-fold defaultstate="collapsed" desc="clang::Parser::ParseAssignmentExprWithObjCMessageExprStart">
@Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseExpr.cpp", line = 184,
   FQN="clang::Parser::ParseAssignmentExprWithObjCMessageExprStart", NM="_ZN5clang6Parser43ParseAssignmentExprWithObjCMessageExprStartENS_14SourceLocationES1_NS_9OpaquePtrINS_8QualTypeEEEPNS_4ExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseExpr.cpp -nm=_ZN5clang6Parser43ParseAssignmentExprWithObjCMessageExprStartENS_14SourceLocationES1_NS_9OpaquePtrINS_8QualTypeEEEPNS_4ExprE")
  //</editor-fold>
  protected /*private*/ ActionResultTTrue<Expr /*P*/ > ParseAssignmentExprWithObjCMessageExprStart(SourceLocation LBracLoc, 
                                             SourceLocation SuperLoc, 
                                             OpaquePtr<QualType> ReceiverType, 
                                             Expr /*P*/ ReceiverExpr) {
    ActionResultTTrue<Expr /*P*/ > R = $this().ParseObjCMessageExpressionBody(new SourceLocation(LBracLoc), new SourceLocation(SuperLoc), 
        new OpaquePtr<QualType>(ReceiverType), ReceiverExpr);
    R.$assignMove($this().ParsePostfixExpressionSuffix(new ActionResultTTrue<Expr /*P*/ >(R)));
    return $this().ParseRHSOfBinaryExpression(new ActionResultTTrue<Expr /*P*/ >(R), prec.Level.Assignment);
  }


/// ParseBlockId - Parse a block-id, which roughly looks like int (int x).
///
/// \verbatim
/// [clang] block-id:
/// [clang]   specifier-qualifier-list block-declarator
/// \endverbatim
//<editor-fold defaultstate="collapsed" desc="clang::Parser::ParseBlockId">
@Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseExpr.cpp", line = 2736,
   FQN="clang::Parser::ParseBlockId", NM="_ZN5clang6Parser12ParseBlockIdENS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseExpr.cpp -nm=_ZN5clang6Parser12ParseBlockIdENS_14SourceLocationE")
  //</editor-fold>
  protected /*private*/ void ParseBlockId(SourceLocation CaretLoc) {
    DeclSpec DS = null;
    Declarator DeclaratorInfo = null;
    try {
      if ($this().Tok.is(tok.TokenKind.code_completion)) {
        $this().Actions.CodeCompleteOrdinaryName($this().getCurScope(), Sema.ParserCompletionContext.PCC_Type);
        $this().cutOffParsing();
        return;
      }
      
      // Parse the specifier-qualifier-list piece.
      DS/*J*/= new DeclSpec($this().AttrFactory);
      $this().ParseSpecifierQualifierList(DS);
      
      // Parse the block-declarator.
      DeclaratorInfo/*J*/= new Declarator(DS, Declarator.TheContext.BlockLiteralContext);
      $this().ParseDeclarator(DeclaratorInfo);
      
      $this().MaybeParseGNUAttributes(DeclaratorInfo);
      
      // Inform sema that we are starting a block.
      $this().Actions.ActOnBlockArguments(new SourceLocation(CaretLoc), DeclaratorInfo, $this().getCurScope());
    } finally {
      if (DeclaratorInfo != null) { DeclaratorInfo.$destroy(); }
      if (DS != null) { DS.$destroy(); }
    }
  }


/// Parse availability query specification.
///
///  availability-spec:
///     '*'
///     identifier version-tuple
//<editor-fold defaultstate="collapsed" desc="clang::Parser::ParseAvailabilitySpec">
@Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseExpr.cpp", line = 2921,
   FQN="clang::Parser::ParseAvailabilitySpec", NM="_ZN5clang6Parser21ParseAvailabilitySpecEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseExpr.cpp -nm=_ZN5clang6Parser21ParseAvailabilitySpecEv")
  //</editor-fold>
  protected /*private*/ Optional<AvailabilitySpec> ParseAvailabilitySpec() {
    if ($this().Tok.is(tok.TokenKind.star)) {
      return new Optional<AvailabilitySpec>(JD$T$RR.INSTANCE, new AvailabilitySpec($this().ConsumeToken()));
    } else {
      // Parse the platform name.
      if ($this().Tok.isNot(tok.TokenKind.identifier)) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($c$.track($this().Diag($this().Tok, diag.err_avail_query_expected_platform_name)));
          return new Optional<AvailabilitySpec>(None);
        } finally {
          $c$.$destroy();
        }
      }
      
      IdentifierLoc /*P*/ PlatformIdentifier = $this().ParseIdentifierLoc();
      SourceRange VersionRange/*J*/= new SourceRange();
      VersionTuple Version = $this().ParseVersionTuple(VersionRange);
      if (Version.empty()) {
        return new Optional<AvailabilitySpec>(None);
      }
      
      StringRef Platform = PlatformIdentifier.Ident.getName();
      if (AvailabilityAttr.getPrettyPlatformName(new StringRef(Platform)).empty()) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_DiagnosticBuilder$C_StringRef($c$.track($this().Diag(new SourceLocation(PlatformIdentifier.Loc), 
                  diag.err_avail_query_unrecognized_platform_name)), 
              /*NO_COPY*/Platform));
          return new Optional<AvailabilitySpec>(None);
        } finally {
          $c$.$destroy();
        }
      }
      
      return new Optional<AvailabilitySpec>(JD$T$RR.INSTANCE, new AvailabilitySpec(new VersionTuple(Version), new StringRef(Platform), new SourceLocation(PlatformIdentifier.Loc), 
              VersionRange.getEnd()));
    }
  }

//<editor-fold defaultstate="collapsed" desc="clang::Parser::ParseAvailabilityCheckExpr">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseExpr.cpp", line = 2952,
   FQN="clang::Parser::ParseAvailabilityCheckExpr", NM="_ZN5clang6Parser26ParseAvailabilityCheckExprENS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseExpr.cpp -nm=_ZN5clang6Parser26ParseAvailabilityCheckExprENS_14SourceLocationE")
  //</editor-fold>
  protected /*private*/ ActionResultTTrue<Expr /*P*/ > ParseAvailabilityCheckExpr(SourceLocation BeginLoc) {
    BalancedDelimiterTracker Parens = null;
    try {
      assert ($this().Tok.is(tok.TokenKind.kw___builtin_available) || $this().Tok.isObjCAtKeyword(tok.ObjCKeywordKind.objc_available));
      
      // Eat the available or __builtin_available.
      $this().ConsumeToken();
      
      Parens/*J*/= new BalancedDelimiterTracker(/*Deref*/$this(), tok.TokenKind.l_paren);
      if (Parens.expectAndConsume()) {
        return ExprError();
      }
      
      SmallVector<AvailabilitySpec> AvailSpecs/*J*/= new SmallVector<AvailabilitySpec>(4, /*PERFnew AvailabilitySpec()*/null);
      boolean HasError = false;
      while (true) {
        Optional<AvailabilitySpec> Spec = $this().ParseAvailabilitySpec();
        if (!Spec.$bool()) {
          HasError = true;
        } else {
          AvailSpecs.push_back(Spec.$star());
        }
        if (!$this().TryConsumeToken(tok.TokenKind.comma)) {
          break;
        }
      }
      if (HasError) {
        $this().SkipUntil(tok.TokenKind.r_paren, SkipUntilFlags.StopAtSemi);
        return ExprError();
      }
      
      CheckAvailabilitySpecList(/*Deref*/$this(), new ArrayRef<AvailabilitySpec>(AvailSpecs));
      if (Parens.consumeClose()) {
        return ExprError();
      }
      
      return $this().Actions.ActOnObjCAvailabilityCheckExpr(new ArrayRef<AvailabilitySpec>(AvailSpecs), new SourceLocation(BeginLoc), 
          Parens.getCloseLocation());
    } finally {
      if (Parens != null) { Parens.$destroy(); }
    }
  }

} // END OF class Parser_ParseExpr
