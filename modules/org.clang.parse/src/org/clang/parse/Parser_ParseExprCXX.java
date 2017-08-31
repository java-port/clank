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
import static org.llvm.adt.ADTAliases.*;
import static org.llvm.support.llvm.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
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
import org.clang.parse.java.ParseMemberPointers.*;
import static org.clang.parse.Parser.*;
import static org.clang.sema.SemaClangGlobals.*;
import static org.clang.parse.impl.ParseExprCXXStatics.*;
import org.clang.sema.DeclaratorChunk.ParamInfo;


//<editor-fold defaultstate="collapsed" desc="static type Parser_ParseExprCXX">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -empty-body -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType -split-class=clang::Parser@this -extends=Parser_ParseExpr ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseExprCXX.cpp -nm=_ZN5clang6Parser12ParseCXXThisEv;_ZN5clang6Parser13ParseCXXCastsEv;_ZN5clang6Parser14ParseCXXTypeidEv;_ZN5clang6Parser14ParseCXXUuidofEv;_ZN5clang6Parser14ParseTypeTraitEv;_ZN5clang6Parser17ParseCXXConditionEPNS_12ActionResultIPNS_4StmtELb1EEENS_14SourceLocationENS_4Sema13ConditionKindE;_ZN5clang6Parser17areTokensAdjacentERKNS_5TokenES3_;_ZN5clang6Parser18ParseUnqualifiedIdERNS_12CXXScopeSpecEbbbNS_9OpaquePtrINS_8QualTypeEEERNS_14SourceLocationERNS_13UnqualifiedIdE;_ZN5clang6Parser19ParseArrayTypeTraitEv;_ZN5clang6Parser19ParseCXXBoolLiteralEv;_ZN5clang6Parser20ParseCXXIdExpressionEb;_ZN5clang6Parser20ParseExpressionTraitEv;_ZN5clang6Parser20ParseThrowExpressionEv;_ZN5clang6Parser21ParseCXXNewExpressionEbNS_14SourceLocationE;_ZN5clang6Parser21ParseLambdaExpressionEv;_ZN5clang6Parser21ParseLambdaIntroducerERNS_16LambdaIntroducerEPb;_ZN5clang6Parser22ParseCoyieldExpressionEv;_ZN5clang6Parser23tryParseCXXIdExpressionERNS_12CXXScopeSpecEbRNS_5TokenE;_ZN5clang6Parser24ParseCXXDeleteExpressionEbNS_14SourceLocationE;_ZN5clang6Parser24ParseCXXPseudoDestructorEPNS_4ExprENS_14SourceLocationENS_3tok9TokenKindERNS_12CXXScopeSpecENS_9OpaquePtrINS_8QualTypeEEE;_ZN5clang6Parser24ParseCXXTypeSpecifierSeqERNS_8DeclSpecE;_ZN5clang6Parser24ParseDirectNewDeclaratorERNS_10DeclaratorE;_ZN5clang6Parser24TryParseLambdaExpressionEv;_ZN5clang6Parser24TryParseLambdaIntroducerERNS_16LambdaIntroducerE;_ZN5clang6Parser26CheckForTemplateAndDigraphERNS_5TokenENS_9OpaquePtrINS_8QualTypeEEEbRNS_14IdentifierInfoERNS_12CXXScopeSpecE;_ZN5clang6Parser26ParseUnqualifiedIdOperatorERNS_12CXXScopeSpecEbNS_9OpaquePtrINS_8QualTypeEEERNS_13UnqualifiedIdE;_ZN5clang6Parser27ParseCXXSimpleTypeSpecifierERNS_8DeclSpecE;_ZN5clang6Parser27ParseExpressionListOrTypeIdERN4llvm15SmallVectorImplIPNS_4ExprEEERNS_10DeclaratorE;_ZN5clang6Parser28ParseUnqualifiedIdTemplateIdERNS_12CXXScopeSpecENS_14SourceLocationEPNS_14IdentifierInfoES3_bNS_9OpaquePtrINS_8QualTypeEEERNS_13UnqualifiedIdEb;_ZN5clang6Parser29CheckForLParenAfterColonColonEv;_ZN5clang6Parser30ParseOptionalCXXScopeSpecifierERNS_12CXXScopeSpecENS_9OpaquePtrINS_8QualTypeEEEbPbbPPNS_14IdentifierInfoE;_ZN5clang6Parser31ParseCXXTypeConstructExpressionERKNS_8DeclSpecE;_ZN5clang6Parser32ParseCXXAmbiguousParenExpressionERNS0_16ParenParseOptionERNS_9OpaquePtrINS_8QualTypeEEERNS_24BalancedDelimiterTrackerERNS_25ColonProtectionRAIIObjectE;_ZN5clang6Parser36ParseLambdaExpressionAfterIntroducerERNS_16LambdaIntroducerE; -static-type=Parser_ParseExprCXX -package=org.clang.parse")
//</editor-fold>
public class Parser_ParseExprCXX extends Parser_ParseExpr {
private final /*split clang::Parser*/ Parser $this() { return (Parser)this; }


/// ParseCXXAmbiguousParenExpression - We have parsed the left paren of a
/// parenthesized ambiguous type-id. This uses tentative parsing to disambiguate
/// based on the context past the parens.
//<editor-fold defaultstate="collapsed" desc="clang::Parser::ParseCXXAmbiguousParenExpression">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION/*ref ExprType*/,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseExprCXX.cpp", line = 3041,
   FQN="clang::Parser::ParseCXXAmbiguousParenExpression", NM="_ZN5clang6Parser32ParseCXXAmbiguousParenExpressionERNS0_16ParenParseOptionERNS_9OpaquePtrINS_8QualTypeEEERNS_24BalancedDelimiterTrackerERNS_25ColonProtectionRAIIObjectE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseExprCXX.cpp -nm=_ZN5clang6Parser32ParseCXXAmbiguousParenExpressionERNS0_16ParenParseOptionERNS_9OpaquePtrINS_8QualTypeEEERNS_24BalancedDelimiterTrackerERNS_25ColonProtectionRAIIObjectE")
  //</editor-fold>
  protected /*private*/ ActionResultTTrue<Expr /*P*/ > ParseCXXAmbiguousParenExpression(final type$ref<ParenParseOption/*&*/> ExprType, 
                                  final OpaquePtr<QualType> /*&*/ CastTy, 
                                  final BalancedDelimiterTracker /*&*/ Tracker, 
                                  final ColonProtectionRAIIObject /*&*/ ColonProt) {
    assert ($this().getLangOpts().CPlusPlus) : "Should only be called for C++!";
    assert (ExprType.$deref() == ParenParseOption.CastExpr) : "Compound literals are not ambiguous!";
    assert ($this().isTypeIdInParens()) : "Not a type-id!";
    
    ActionResultTTrue<Expr /*P*/ > Result/*J*/= new ActionResultTTrue<Expr /*P*/ >(true);
    CastTy.$assignMove(new OpaquePtr<QualType>(null));
    
    // We need to disambiguate a very ugly part of the C++ syntax:
    //
    // (T())x;  - type-id
    // (T())*x; - type-id
    // (T())/x; - expression
    // (T());   - expression
    //
    // The bad news is that we cannot use the specialized tentative parser, since
    // it can only verify that the thing inside the parens can be parsed as
    // type-id, it is not useful for determining the context past the parens.
    //
    // The good news is that the parser can disambiguate this part without
    // making any unnecessary Action calls.
    //
    // It uses a scheme similar to parsing inline methods. The parenthesized
    // tokens are cached, the context that follows is determined (possibly by
    // parsing a cast-expression), and then we re-introduce the cached tokens
    // into the token stream and parse them appropriately.
    ParenParseOption ParseAs;
    SmallVectorToken Toks/*J*/= new SmallVectorToken(4, /*new Token()*/(Token)null);
    
    // Store the tokens of the parentheses. We will parse them after we determine
    // the context that follows them.
    if (!$this().ConsumeAndStoreUntil(tok.TokenKind.r_paren, Toks)) {
      // We didn't find the ')' we expected.
      Tracker.consumeClose();
      return ExprError();
    }
    if ($this().Tok.is(tok.TokenKind.l_brace)) {
      ParseAs = ParenParseOption.CompoundLiteral;
    } else {
      bool$ref NotCastExpr = create_bool$ref();
      if ($this().Tok.is(tok.TokenKind.l_paren) && $this().NextToken().is(tok.TokenKind.r_paren)) {
        NotCastExpr.$set(true);
      } else {
        // Try parsing the cast-expression that may follow.
        // If it is not a cast-expression, NotCastExpr will be true and no token
        // will be consumed.
        ColonProt.restore();
        Result.$assignMove($this().ParseCastExpression(false/*isUnaryExpression*/, 
                false/*isAddressofOperand*/, 
                NotCastExpr, 
                // type-id has priority.
                TypeCastState.IsTypeCast));
      }
      
      // If we parsed a cast-expression, it's really a type-id, otherwise it's
      // an expression.
      ParseAs = NotCastExpr.$deref() ? ParenParseOption.SimpleExpr : ParenParseOption.CastExpr;
    }
    
    // Create a fake EOF to mark end of Toks buffer.
    Token AttrEnd/*J*/= new Token();
    AttrEnd.startToken();
    AttrEnd.setKind(tok.TokenKind.eof);
    AttrEnd.setLocation($this().Tok.getLocation());
    AttrEnd.setEofData(Toks.data());
    Toks.push_back(AttrEnd);
    
    // The current token should go after the cached tokens.
    Toks.push_back($this().Tok);
    // Re-enter the stored parenthesized tokens into the token stream, so we may
    // parse them now.
    $this().PP.EnterTokenStream(new ArrayRefToken(Toks), true/*DisableMacroExpansion*/);
    // Drop the current token and bring the first cached one. It's the same token
    // as when we entered this function.
    $this().ConsumeAnyToken();
    if (ParseAs.getValue() >= ParenParseOption.CompoundLiteral.getValue()) {
      DeclSpec DS = null;
      Declarator DeclaratorInfo = null;
      try {
        // Parse the type declarator.
        DS/*J*/= new DeclSpec($this().AttrFactory);
        DeclaratorInfo/*J*/= new Declarator(DS, Declarator.TheContext.TypeNameContext);
        {
          ColonProtectionRAIIObject InnerColonProtection = null;
          try {
            InnerColonProtection/*J*/= new ColonProtectionRAIIObject(/*Deref*/$this());
            $this().ParseSpecifierQualifierList(DS);
            $this().ParseDeclarator(DeclaratorInfo);
          } finally {
            if (InnerColonProtection != null) { InnerColonProtection.$destroy(); }
          }
        }
        
        // Match the ')'.
        Tracker.consumeClose();
        ColonProt.restore();
        
        // Consume EOF marker for Toks buffer.
        assert ($this().Tok.is(tok.TokenKind.eof) && $eq_ptr($this().Tok.getEofData(), AttrEnd.getEofData()));
        $this().ConsumeAnyToken();
        if (ParseAs == ParenParseOption.CompoundLiteral) {
          ExprType.$set(ParenParseOption.CompoundLiteral);
          if (DeclaratorInfo.isInvalidType()) {
            return ExprError();
          }
          
          ActionResult<OpaquePtr<QualType> > Ty = $this().Actions.ActOnTypeName($this().getCurScope(), DeclaratorInfo);
          return $this().ParseCompoundLiteralExpression(Ty.get(), 
              Tracker.getOpenLocation(), 
              Tracker.getCloseLocation());
        }
        
        // We parsed '(' type-id ')' and the thing after it wasn't a '{'.
        assert (ParseAs == ParenParseOption.CastExpr);
        if (DeclaratorInfo.isInvalidType()) {
          return ExprError();
        }
        
        // Result is what ParseCastExpression returned earlier.
        if (!Result.isInvalid()) {
          Result.$assignMove($this().Actions.ActOnCastExpr($this().getCurScope(), Tracker.getOpenLocation(), 
                  DeclaratorInfo, CastTy, 
                  Tracker.getCloseLocation(), Result.get()));
        }
        return Result;
      } finally {
        if (DeclaratorInfo != null) { DeclaratorInfo.$destroy(); }
        if (DS != null) { DS.$destroy(); }
      }
    }
    
    // Not a compound literal, and not followed by a cast-expression.
    assert (ParseAs == ParenParseOption.SimpleExpr);
    
    ExprType.$set(ParenParseOption.SimpleExpr);
    Result.$assignMove($this().ParseExpression());
    if (!Result.isInvalid() && $this().Tok.is(tok.TokenKind.r_paren)) {
      Result.$assignMove($this().Actions.ActOnParenExpr(Tracker.getOpenLocation(), 
              $this().Tok.getLocation(), Result.get()));
    }
    
    // Match the ')'.
    if (Result.isInvalid()) {
      while ($this().Tok.isNot(tok.TokenKind.eof)) {
        $this().ConsumeAnyToken();
      }
      assert ($eq_ptr($this().Tok.getEofData(), AttrEnd.getEofData()));
      $this().ConsumeAnyToken();
      return ExprError();
    }
    
    Tracker.consumeClose();
    // Consume EOF marker for Toks buffer.
    assert ($this().Tok.is(tok.TokenKind.eof) && $eq_ptr($this().Tok.getEofData(), AttrEnd.getEofData()));
    $this().ConsumeAnyToken();
    return Result;
  }


//===--------------------------------------------------------------------===//
// C++ Expressions
//<editor-fold defaultstate="collapsed" desc="clang::Parser::tryParseCXXIdExpression">
@Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseExprCXX.cpp", line = 592,
   FQN="clang::Parser::tryParseCXXIdExpression", NM="_ZN5clang6Parser23tryParseCXXIdExpressionERNS_12CXXScopeSpecEbRNS_5TokenE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseExprCXX.cpp -nm=_ZN5clang6Parser23tryParseCXXIdExpressionERNS_12CXXScopeSpecEbRNS_5TokenE")
  //</editor-fold>
  protected /*private*/ ActionResultTTrue<Expr /*P*/ > tryParseCXXIdExpression(final CXXScopeSpec /*&*/ SS, boolean isAddressOfOperand, 
                         final Token /*&*/ Replacement) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      SourceLocation TemplateKWLoc/*J*/= new SourceLocation();
      UnqualifiedId Name/*J*/= new UnqualifiedId();
      if ($this().ParseUnqualifiedId(SS, 
          /*EnteringContext=*/ false, 
          /*AllowDestructorName=*/ false, 
          /*AllowConstructorName=*/ false, 
          /*ObjectType=*/ new OpaquePtr<QualType>(null), TemplateKWLoc, Name)) {
        return ExprError();
      }
      
      // This is only the direct operand of an & operator if it is not
      // followed by a postfix-expression suffix.
      if (isAddressOfOperand && $this().isPostfixExpressionSuffixStart()) {
        isAddressOfOperand = false;
      }
      
      return $c$.clean($this().Actions.ActOnIdExpression($this().getCurScope(), SS, new SourceLocation(TemplateKWLoc), Name, 
          $this().Tok.is(tok.TokenKind.l_paren), isAddressOfOperand, 
          $c$.track(new std.unique_ptr<CorrectionCandidateCallback>(JD$NullPtr.INSTANCE, null)), /*IsInlineAsmIdentifier=*/ false, 
          $AddrOf(Replacement)));
    } finally {
      $c$.$destroy();
    }
  }


/// ParseCXXIdExpression - Handle id-expression.
///
///       id-expression:
///         unqualified-id
///         qualified-id
///
///       qualified-id:
///         '::'[opt] nested-name-specifier 'template'[opt] unqualified-id
///         '::' identifier
///         '::' operator-function-id
///         '::' template-id
///
/// NOTE: The standard specifies that, for qualified-id, the parser does not
/// expect:
///
///   '::' conversion-function-id
///   '::' '~' class-name
///
/// This may cause a slight inconsistency on diagnostics:
///
/// class C {};
/// namespace A {}
/// void f() {
///   :: A :: ~ C(); // Some Sema error about using destructor with a
///                  // namespace.
///   :: ~ C(); // Some Parser error like 'unexpected ~'.
/// }
///
/// We simplify the parser a bit and make it work like:
///
///       qualified-id:
///         '::'[opt] nested-name-specifier 'template'[opt] unqualified-id
///         '::' unqualified-id
///
/// That way Sema can handle and report similar errors for namespaces and the
/// global scope.
///
/// The isAddressOfOperand parameter indicates that this id-expression is a
/// direct operand of the address-of operator. This is, besides member contexts,
/// the only place where a qualified-id naming a non-static class member may
/// appear.
///
//<editor-fold defaultstate="collapsed" desc="clang::Parser::ParseCXXIdExpression">
@Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseExprCXX.cpp", line = 656,
   FQN="clang::Parser::ParseCXXIdExpression", NM="_ZN5clang6Parser20ParseCXXIdExpressionEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseExprCXX.cpp -nm=_ZN5clang6Parser20ParseCXXIdExpressionEb")
  //</editor-fold>
  protected /*private*/ ActionResultTTrue<Expr /*P*/ > ParseCXXIdExpression() {
    return $this().ParseCXXIdExpression(false);
  }
  protected /*private*/ ActionResultTTrue<Expr /*P*/ > ParseCXXIdExpression(boolean isAddressOfOperand/*= false*/) {
    CXXScopeSpec SS = null;
    try {
      // qualified-id:
      //   '::'[opt] nested-name-specifier 'template'[opt] unqualified-id
      //   '::' unqualified-id
      //
      SS/*J*/= new CXXScopeSpec();
      $this().ParseOptionalCXXScopeSpecifier(SS, new OpaquePtr<QualType>(null), /*EnteringContext=*/ false);
      
      Token Replacement/*J*/= new Token();
      ActionResultTTrue<Expr /*P*/ > Result = $this().tryParseCXXIdExpression(SS, isAddressOfOperand, Replacement);
      if (Result.isUnset()) {
        // If the ExprResult is valid but null, then typo correction suggested a
        // keyword replacement that needs to be reparsed.
        $this().UnconsumeToken(Replacement);
        Result.$assignMove($this().tryParseCXXIdExpression(SS, isAddressOfOperand, Replacement));
      }
      assert (!Result.isUnset()) : "Typo correction suggested a keyword replacement for a previous keyword suggestion";
      return Result;
    } finally {
      if (SS != null) { SS.$destroy(); }
    }
  }


// Are the two tokens adjacent in the same source file?
//<editor-fold defaultstate="collapsed" desc="clang::Parser::areTokensAdjacent">
@Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseExprCXX.cpp", line = 43,
   FQN="clang::Parser::areTokensAdjacent", NM="_ZN5clang6Parser17areTokensAdjacentERKNS_5TokenES3_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseExprCXX.cpp -nm=_ZN5clang6Parser17areTokensAdjacentERKNS_5TokenES3_")
  //</editor-fold>
  protected /*private*/ boolean areTokensAdjacent(final /*const*/ Token /*&*/ First, final /*const*/ Token /*&*/ Second) {
    final SourceManager /*&*/ SM = $this().PP.getSourceManager();
    SourceLocation FirstLoc = SM.getSpellingLoc(First.getLocation());
    SourceLocation FirstEnd = FirstLoc.getLocWithOffset(First.getLength());
    return $eq_SourceLocation$C(FirstEnd, SM.getSpellingLoc(Second.getLocation()));
  }


// Check for '<::' which should be '< ::' instead of '[:' when following
// a template name.
//<editor-fold defaultstate="collapsed" desc="clang::Parser::CheckForTemplateAndDigraph">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseExprCXX.cpp", line = 80,
   FQN="clang::Parser::CheckForTemplateAndDigraph", NM="_ZN5clang6Parser26CheckForTemplateAndDigraphERNS_5TokenENS_9OpaquePtrINS_8QualTypeEEEbRNS_14IdentifierInfoERNS_12CXXScopeSpecE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseExprCXX.cpp -nm=_ZN5clang6Parser26CheckForTemplateAndDigraphERNS_5TokenENS_9OpaquePtrINS_8QualTypeEEEbRNS_14IdentifierInfoERNS_12CXXScopeSpecE")
  //</editor-fold>
  protected /*private*/ void CheckForTemplateAndDigraph(final Token /*&*/ Next, OpaquePtr<QualType> ObjectType, 
                            boolean EnteringContext, 
                            final IdentifierInfo /*&*/ II, final CXXScopeSpec /*&*/ SS) {
    if (!Next.is(tok.TokenKind.l_square) || Next.getLength() != 2) {
      return;
    }
    
    Token SecondToken = new Token($this().GetLookAheadToken(2));
    if (!SecondToken.is(tok.TokenKind.colon) || !$this().areTokensAdjacent(Next, SecondToken)) {
      return;
    }
    
    OpaquePtr<TemplateName> Template/*J*/= new OpaquePtr<TemplateName>();
    UnqualifiedId TemplateName/*J*/= new UnqualifiedId();
    TemplateName.setIdentifier($AddrOf(II), $this().Tok.getLocation());
    bool$ref MemberOfUnknownSpecialization = create_bool$ref();
    if (!($this().Actions.isTemplateName($this().getCurScope(), SS, /*hasTemplateKeyword=*/ false, 
        TemplateName, new OpaquePtr<QualType>(ObjectType), EnteringContext, 
        Template, MemberOfUnknownSpecialization).getValue() != 0)) {
      return;
    }
    
    FixDigraph(/*Deref*/$this(), $this().PP, Next, SecondToken, tok.TokenKind.unknown, 
        /*AtDigraph*/ false);
  }


/// \brief Parse global scope or nested-name-specifier if present.
///
/// Parses a C++ global scope specifier ('::') or nested-name-specifier (which
/// may be preceded by '::'). Note that this routine will not parse ::new or
/// ::delete; it will just leave them in the token stream.
///
///       '::'[opt] nested-name-specifier
///       '::'
///
///       nested-name-specifier:
///         type-name '::'
///         namespace-name '::'
///         nested-name-specifier identifier '::'
///         nested-name-specifier 'template'[opt] simple-template-id '::'
///
///
/// \param SS the scope specifier that will be set to the parsed
/// nested-name-specifier (or empty)
///
/// \param ObjectType if this nested-name-specifier is being parsed following
/// the "." or "->" of a member access expression, this parameter provides the
/// type of the object whose members are being accessed.
///
/// \param EnteringContext whether we will be entering into the context of
/// the nested-name-specifier after parsing it.
///
/// \param MayBePseudoDestructor When non-NULL, points to a flag that
/// indicates whether this nested-name-specifier may be part of a
/// pseudo-destructor name. In this case, the flag will be set false
/// if we don't actually end up parsing a destructor name. Moreorover,
/// if we do end up determining that we are parsing a destructor name,
/// the last component of the nested-name-specifier is not parsed as
/// part of the scope specifier.
///
/// \param IsTypename If \c true, this nested-name-specifier is known to be
/// part of a type name. This is used to improve error recovery.
///
/// \param LastII When non-NULL, points to an IdentifierInfo* that will be
/// filled in with the leading identifier in the last component of the
/// nested-name-specifier, if any.
///
/// \returns true if there was an error parsing a scope specifier
//<editor-fold defaultstate="collapsed" desc="clang::Parser::ParseOptionalCXXScopeSpecifier">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseExprCXX.cpp", line = 187,
   FQN="clang::Parser::ParseOptionalCXXScopeSpecifier", NM="_ZN5clang6Parser30ParseOptionalCXXScopeSpecifierERNS_12CXXScopeSpecENS_9OpaquePtrINS_8QualTypeEEEbPbbPPNS_14IdentifierInfoE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseExprCXX.cpp -nm=_ZN5clang6Parser30ParseOptionalCXXScopeSpecifierERNS_12CXXScopeSpecENS_9OpaquePtrINS_8QualTypeEEEbPbbPPNS_14IdentifierInfoE")
  //</editor-fold>
  protected /*private*/ boolean ParseOptionalCXXScopeSpecifier(final CXXScopeSpec /*&*/ SS, 
                                OpaquePtr<QualType> ObjectType, 
                                boolean EnteringContext) {
    return $this().ParseOptionalCXXScopeSpecifier(SS, 
                                ObjectType, 
                                EnteringContext, 
                                (bool$ptr/*bool P*/ )null, 
                                false, 
                                (type$ptr<IdentifierInfo>) null);
  }
  protected /*private*/ boolean ParseOptionalCXXScopeSpecifier(final CXXScopeSpec /*&*/ SS, 
                                OpaquePtr<QualType> ObjectType, 
                                boolean EnteringContext, 
                                bool$ptr/*bool P*/ MayBePseudoDestructor/*= null*/) {
    return $this().ParseOptionalCXXScopeSpecifier(SS, 
                                ObjectType, 
                                EnteringContext, 
                                MayBePseudoDestructor, 
                                false, 
                                (type$ptr<IdentifierInfo>) null);
  }
  protected /*private*/ boolean ParseOptionalCXXScopeSpecifier(final CXXScopeSpec /*&*/ SS, 
                                OpaquePtr<QualType> ObjectType, 
                                boolean EnteringContext, 
                                bool$ptr/*bool P*/ MayBePseudoDestructor/*= null*/, 
                                boolean IsTypename/*= false*/) {
    return $this().ParseOptionalCXXScopeSpecifier(SS, 
                                ObjectType, 
                                EnteringContext, 
                                MayBePseudoDestructor, 
                                IsTypename, 
                                (type$ptr<IdentifierInfo>) null);
  }
  protected /*private*/ boolean ParseOptionalCXXScopeSpecifier(final CXXScopeSpec /*&*/ SS, 
                                OpaquePtr<QualType> ObjectType, 
                                boolean EnteringContext, 
                                bool$ptr/*bool P*/ MayBePseudoDestructor/*= null*/, 
                                boolean IsTypename/*= false*/, 
                                final type$ptr<IdentifierInfo>/*P*/ LastII/*= null*/) {
    assert ($this().getLangOpts().CPlusPlus) : "Call sites of this function should be guarded by checking for C++";
    if ($this().Tok.is(tok.TokenKind.annot_cxxscope)) {
      assert (!(LastII != null)) : "want last identifier but have already annotated scope";
      assert (!(MayBePseudoDestructor != null)) : "unexpected annot_cxxscope";
      $this().Actions.RestoreNestedNameSpecifierAnnotation($this().Tok.getAnnotationValue(), 
          $this().Tok.getAnnotationRange(), 
          SS);
      $this().ConsumeToken();
      return false;
    }
    if ($this().Tok.is(tok.TokenKind.annot_template_id)) {
      // If the current token is an annotated template id, it may already have
      // a scope specifier. Restore it.
      TemplateIdAnnotation /*P*/ TemplateId = $this().takeTemplateIdAnnotation($this().Tok);
      SS.$assign(TemplateId.SS);
    }
    
    // Has to happen before any "return false"s in this function.
    boolean CheckForDestructor = false;
    if ((MayBePseudoDestructor != null) && MayBePseudoDestructor.$star()) {
      CheckForDestructor = true;
      MayBePseudoDestructor.$set(false);
    }
    if ((LastII != null)) {
      LastII.$set(null);
    }
    
    boolean HasScopeSpecifier = false;
    if ($this().Tok.is(tok.TokenKind.coloncolon)) {
      // ::new and ::delete aren't nested-name-specifiers.
      /*tok.TokenKind*/char NextKind = $this().NextToken().getKind();
      if (NextKind == tok.TokenKind.kw_new || NextKind == tok.TokenKind.kw_delete) {
        return false;
      }
      if (NextKind == tok.TokenKind.l_brace) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          // It is invalid to have :: {, consume the scope qualifier and pretend
          // like we never saw it.
          $c$.clean($out_DiagnosticBuilder$C_TokenKind($c$.track($this().Diag($this().ConsumeToken(), diag.err_expected)), tok.TokenKind.identifier));
        } finally {
          $c$.$destroy();
        }
      } else {
        // '::' - Global scope qualifier.
        if ($this().Actions.ActOnCXXGlobalScopeSpecifier($this().ConsumeToken(), SS)) {
          return true;
        }
        
        $this().CheckForLParenAfterColonColon();
        
        HasScopeSpecifier = true;
      }
    }
    if ($this().Tok.is(tok.TokenKind.kw___super)) {
      SourceLocation SuperLoc = $this().ConsumeToken();
      if (!$this().Tok.is(tok.TokenKind.coloncolon)) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($c$.track($this().Diag($this().Tok.getLocation(), diag.err_expected_coloncolon_after_super)));
          return true;
        } finally {
          $c$.$destroy();
        }
      }
      
      return $this().Actions.ActOnSuperScopeSpecifier(new SourceLocation(SuperLoc), $this().ConsumeToken(), SS);
    }
    if (!HasScopeSpecifier
       && $this().Tok.isOneOf(tok.TokenKind.kw_decltype, tok.TokenKind.annot_decltype)) {
      DeclSpec DS = null;
      try {
        DS/*J*/= new DeclSpec($this().AttrFactory);
        SourceLocation DeclLoc = $this().Tok.getLocation();
        SourceLocation EndLoc = $this().ParseDecltypeSpecifier(DS);
        
        SourceLocation CCLoc/*J*/= new SourceLocation();
        if (!$this().TryConsumeToken(tok.TokenKind.coloncolon, CCLoc)) {
          $this().AnnotateExistingDecltypeSpecifier(DS, new SourceLocation(DeclLoc), new SourceLocation(EndLoc));
          return false;
        }
        if ($this().Actions.ActOnCXXNestedNameSpecifierDecltype(SS, DS, new SourceLocation(CCLoc))) {
          SS.SetInvalid(new SourceRange(/*NO_COPY*/DeclLoc, /*NO_COPY*/CCLoc));
        }
        
        HasScopeSpecifier = true;
      } finally {
        if (DS != null) { DS.$destroy(); }
      }
    }
    while (true) {
      if (HasScopeSpecifier) {
        // C++ [basic.lookup.classref]p5:
        //   If the qualified-id has the form
        //
        //       ::class-name-or-namespace-name::...
        //
        //   the class-name-or-namespace-name is looked up in global scope as a
        //   class-name or namespace-name.
        //
        // To implement this, we clear out the object type as soon as we've
        // seen a leading '::' or part of a nested-name-specifier.
        ObjectType.$assignMove(new OpaquePtr<QualType>(null));
        if ($this().Tok.is(tok.TokenKind.code_completion)) {
          // Code completion for a nested-name-specifier, where the code
          // code completion token follows the '::'.
          $this().Actions.CodeCompleteQualifiedId($this().getCurScope(), SS, EnteringContext);
          // Include code completion token into the range of the scope otherwise
          // when we try to annotate the scope tokens the dangling code completion
          // token will cause assertion in
          // Preprocessor::AnnotatePreviousCachedTokens.
          SS.setEndLoc($this().Tok.getLocation());
          $this().cutOffParsing();
          return true;
        }
      }
      
      // nested-name-specifier:
      //   nested-name-specifier 'template'[opt] simple-template-id '::'
      
      // Parse the optional 'template' keyword, then make sure we have
      // 'identifier <' after it.
      if ($this().Tok.is(tok.TokenKind.kw_template)) {
        TentativeParsingAction TPA = null;
        try {
          // If we don't have a scope specifier or an object type, this isn't a
          // nested-name-specifier, since they aren't allowed to start with
          // 'template'.
          if (!HasScopeSpecifier && !ObjectType.$bool()) {
            break;
          }
          
          TPA/*J*/= new TentativeParsingAction(/*Deref*/$this());
          SourceLocation TemplateKWLoc = $this().ConsumeToken();
          
          UnqualifiedId TemplateName/*J*/= new UnqualifiedId();
          if ($this().Tok.is(tok.TokenKind.identifier)) {
            // Consume the identifier.
            TemplateName.setIdentifier($this().Tok.getIdentifierInfo(), $this().Tok.getLocation());
            $this().ConsumeToken();
          } else if ($this().Tok.is(tok.TokenKind.kw_operator)) {
            // We don't need to actually parse the unqualified-id in this case,
            // because a simple-template-id cannot start with 'operator', but
            // go ahead and parse it anyway for consistency with the case where
            // we already annotated the template-id.
            if ($this().ParseUnqualifiedIdOperator(SS, EnteringContext, new OpaquePtr<QualType>(ObjectType), 
                TemplateName)) {
              TPA.Commit();
              break;
            }
            if (TemplateName.getKind() != UnqualifiedId.IdKind.IK_OperatorFunctionId
               && TemplateName.getKind() != UnqualifiedId.IdKind.IK_LiteralOperatorId) {
              JavaCleaner $c$ = $createJavaCleaner();
              try {
                $c$.clean($out_DiagnosticBuilder$C_SourceRange($c$.track($this().Diag(TemplateName.getSourceRange().getBegin(), 
                        diag.err_id_after_template_in_nested_name_spec)), 
                    TemplateName.getSourceRange()));
                TPA.Commit();
                break;
              } finally {
                $c$.$destroy();
              }
            }
          } else {
            TPA.Revert();
            break;
          }
          
          // If the next token is not '<', we have a qualified-id that refers
          // to a template name, such as T::template apply, but is not a 
          // template-id.
          if ($this().Tok.isNot(tok.TokenKind.less)) {
            TPA.Revert();
            break;
          }
          
          // Commit to parsing the template-id.
          TPA.Commit();
          OpaquePtr<TemplateName> Template/*J*/= new OpaquePtr<TemplateName>();
          {
            TemplateNameKind TNK = $this().Actions.ActOnDependentTemplateName($this().getCurScope(), 
                SS, new SourceLocation(TemplateKWLoc), TemplateName, 
                new OpaquePtr<QualType>(ObjectType), EnteringContext, 
                Template);
            if ((TNK.getValue() != 0)) {
              if ($this().AnnotateTemplateIdToken(new OpaquePtr<TemplateName>(Template), TNK, SS, new SourceLocation(TemplateKWLoc), 
                  TemplateName, false)) {
                return true;
              }
            } else {
              return true;
            }
          }
          
          continue;
        } finally {
          if (TPA != null) { TPA.$destroy(); }
        }
      }
      if ($this().Tok.is(tok.TokenKind.annot_template_id) && $this().NextToken().is(tok.TokenKind.coloncolon)) {
        // We have
        //
        //   template-id '::'
        //
        // So we need to check whether the template-id is a simple-template-id of
        // the right kind (it should name a type or be dependent), and then
        // convert it into a type within the nested-name-specifier.
        TemplateIdAnnotation /*P*/ TemplateId = $this().takeTemplateIdAnnotation($this().Tok);
        if (CheckForDestructor && $this().GetLookAheadToken(2).is(tok.TokenKind.tilde)) {
          MayBePseudoDestructor.$set(true);
          return false;
        }
        if ((LastII != null)) {
          LastII.$set(TemplateId.Name);
        }
        
        // Consume the template-id token.
        $this().ConsumeToken();
        assert ($this().Tok.is(tok.TokenKind.coloncolon)) : "NextToken() not working properly!";
        SourceLocation CCLoc = $this().ConsumeToken();
        
        HasScopeSpecifier = true;
        
        MutableArrayRef<ParsedTemplateArgument> TemplateArgsPtr/*J*/= new MutableArrayRef<ParsedTemplateArgument>(TemplateId.getTemplateArgs(), 
            TemplateId.NumArgs, false);
        if ($this().Actions.ActOnCXXNestedNameSpecifier($this().getCurScope(), 
            SS, 
            new SourceLocation(TemplateId.TemplateKWLoc), 
            new OpaquePtr<TemplateName>(TemplateId.Template), 
            new SourceLocation(TemplateId.TemplateNameLoc), 
            new SourceLocation(TemplateId.LAngleLoc), 
            new MutableArrayRef<ParsedTemplateArgument>(TemplateArgsPtr), 
            new SourceLocation(TemplateId.RAngleLoc), 
            new SourceLocation(CCLoc), 
            EnteringContext)) {
          SourceLocation StartLoc = SS.getBeginLoc().isValid() ? SS.getBeginLoc() : new SourceLocation(TemplateId.TemplateNameLoc);
          SS.SetInvalid(new SourceRange(/*NO_COPY*/StartLoc, /*NO_COPY*/CCLoc));
        }
        
        continue;
      }
      
      // The rest of the nested-name-specifier possibilities start with
      // tok::identifier.
      if ($this().Tok.isNot(tok.TokenKind.identifier)) {
        break;
      }
      
      final IdentifierInfo /*&*/ II = $Deref($this().Tok.getIdentifierInfo());
      // JAVA: assertion
      assert II != null : "JAVA: Why getIdentifierInfo() returned null? In C++ it is assigned to a reference, so it cannot be null!";
      
      // nested-name-specifier:
      //   type-name '::'
      //   namespace-name '::'
      //   nested-name-specifier identifier '::'
      Token Next = new Token($this().NextToken());
      
      // If we get foo:bar, this is almost certainly a typo for foo::bar.  Recover
      // and emit a fixit hint for it.
      if (Next.is(tok.TokenKind.colon) && !$this().ColonIsSacred) {
        if ($this().Actions.IsInvalidUnlessNestedName($this().getCurScope(), SS, II, 
            $this().Tok.getLocation(), 
            Next.getLocation(), new OpaquePtr<QualType>(ObjectType), 
            EnteringContext)
          // If the token after the colon isn't an identifier, it's still an
          // error, but they probably meant something else strange so don't
          // recover like this.
           && $this().PP.LookAhead(1).is(tok.TokenKind.identifier)) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            $c$.clean($out_DiagnosticBuilder$C_FixItHint$C($c$.track($this().Diag(Next, diag.err_unexpected_colon_in_nested_name_spec)), 
                FixItHint.CreateReplacement(new SourceRange(Next.getLocation()), new StringRef(/*KEEP_STR*/$COLON_COLON))));
            // Recover as if the user wrote '::'.
            Next.setKind(tok.TokenKind.coloncolon);
          } finally {
            $c$.$destroy();
          }
        }
      }
      if (Next.is(tok.TokenKind.coloncolon) && $this().GetLookAheadToken(2).is(tok.TokenKind.l_brace)) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          // It is invalid to have :: {, consume the scope qualifier and pretend
          // like we never saw it.
          Token Identifier = new Token($this().Tok); // Stash away the identifier.
          $this().ConsumeToken(); // Eat the identifier, current token is now '::'.
          $c$.clean($out_DiagnosticBuilder$C_TokenKind($c$.track($this().Diag($this().PP.getLocForEndOfToken($this().ConsumeToken()), diag.err_expected)), 
              tok.TokenKind.identifier));
          $this().UnconsumeToken(Identifier); // Stick the identifier back.
          Next.$assign($this().NextToken()); // Point Next at the '{' token.
        } finally {
          $c$.$destroy();
        }
      }
      if (Next.is(tok.TokenKind.coloncolon)) {
        if (CheckForDestructor && $this().GetLookAheadToken(2).is(tok.TokenKind.tilde)
           && !$this().Actions.isNonTypeNestedNameSpecifier($this().getCurScope(), SS, $this().Tok.getLocation(), II, new OpaquePtr<QualType>(ObjectType))) {
          MayBePseudoDestructor.$set(true);
          return false;
        }
        if ($this().ColonIsSacred) {
          final /*const*/ Token /*&*/ Next2 = $this().GetLookAheadToken(2);
          if (Next2.is(tok.TokenKind.kw_private) || Next2.is(tok.TokenKind.kw_protected)
             || Next2.is(tok.TokenKind.kw_public) || Next2.is(tok.TokenKind.kw_virtual)) {
            JavaCleaner $c$ = $createJavaCleaner();
            try {
              $c$.clean($out_DiagnosticBuilder$C_FixItHint$C($out_DiagnosticBuilder$C_char$ptr$C($c$.track($this().Diag(Next2, diag.err_unexpected_token_in_nested_name_spec)), 
                      Next2.getName()), 
                  FixItHint.CreateReplacement(new SourceRange(Next.getLocation()), new StringRef(/*KEEP_STR*/$COLON))));
              Token ColonColon/*J*/= new Token();
              $this().PP.Lex(ColonColon);
              ColonColon.setKind(tok.TokenKind.colon);
              $this().PP.EnterToken(ColonColon);
              break;
            } finally {
              $c$.$destroy();
            }
          }
        }
        if ((LastII != null)) {
          LastII.$set($AddrOf(II));
        }
        
        // We have an identifier followed by a '::'. Lookup this name
        // as the name in a nested-name-specifier.
        Token Identifier = new Token($this().Tok);
        SourceLocation IdLoc = $this().ConsumeToken();
        assert ($this().Tok.isOneOf(tok.TokenKind.coloncolon, tok.TokenKind.colon)) : "NextToken() not working properly!";
        Token ColonColon = new Token($this().Tok);
        SourceLocation CCLoc = $this().ConsumeToken();
        
        $this().CheckForLParenAfterColonColon();
        
        bool$ptr IsCorrectedToColon = create_bool$ptr(false);
        final bool$ptr/*bool P*/ CorrectionFlagPtr = $tryClone($this().ColonIsSacred ? $AddrOf(IsCorrectedToColon) : null);
        if ($this().Actions.ActOnCXXNestedNameSpecifier($this().getCurScope(), II, new SourceLocation(IdLoc), new SourceLocation(CCLoc), 
            new OpaquePtr<QualType>(ObjectType), EnteringContext, SS, 
            false, CorrectionFlagPtr)) {
          // Identifier is not recognized as a nested name, but we can have
          // mistyped '::' instead of ':'.
          if ((CorrectionFlagPtr != null) && IsCorrectedToColon.$star()) {
            ColonColon.setKind(tok.TokenKind.colon);
            $this().PP.EnterToken($this().Tok);
            $this().PP.EnterToken(ColonColon);
            $this().Tok.$assign(Identifier);
            break;
          }
          SS.SetInvalid(new SourceRange(/*NO_COPY*/IdLoc, /*NO_COPY*/CCLoc));
        }
        HasScopeSpecifier = true;
        continue;
      }
      
      $this().CheckForTemplateAndDigraph(Next, new OpaquePtr<QualType>(ObjectType), EnteringContext, II, SS);
      
      // nested-name-specifier:
      //   type-name '<'
      if (Next.is(tok.TokenKind.less)) {
        OpaquePtr<TemplateName> Template/*J*/= new OpaquePtr<TemplateName>();
        UnqualifiedId TemplateName/*J*/= new UnqualifiedId();
        TemplateName.setIdentifier($AddrOf(II), $this().Tok.getLocation());
        bool$ref MemberOfUnknownSpecialization = create_bool$ref();
        {
          TemplateNameKind TNK = $this().Actions.isTemplateName($this().getCurScope(), SS, 
              /*hasTemplateKeyword=*/ false, 
              TemplateName, 
              new OpaquePtr<QualType>(ObjectType), 
              EnteringContext, 
              Template, 
              MemberOfUnknownSpecialization);
          if ((TNK.getValue() != 0)) {
            // We have found a template name, so annotate this token
            // with a template-id annotation. We do not permit the
            // template-id to be translated into a type annotation,
            // because some clients (e.g., the parsing of class template
            // specializations) still want to see the original template-id
            // token.
            $this().ConsumeToken();
            if ($this().AnnotateTemplateIdToken(new OpaquePtr<TemplateName>(Template), TNK, SS, new SourceLocation(), 
                TemplateName, false)) {
              return true;
            }
            continue;
          }
        }
        if (MemberOfUnknownSpecialization.$deref() && (ObjectType.$bool() || SS.isSet())
           && (IsTypename || $this().IsTemplateArgumentList(1))) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            // We have something like t::getAs<T>, where getAs is a 
            // member of an unknown specialization. However, this will only
            // parse correctly as a template, so suggest the keyword 'template'
            // before 'getAs' and treat this as a dependent template name.
            /*uint*/int DiagID = diag.err_missing_dependent_template_keyword;
            if ($this().getLangOpts().MicrosoftExt) {
              DiagID = diag.warn_missing_dependent_template_keyword;
            }
            
            $c$.clean($out_DiagnosticBuilder$C_FixItHint$C($out_DiagnosticBuilder$C_StringRef($c$.track($this().Diag($this().Tok.getLocation(), DiagID)), 
                    II.getName()), 
                FixItHint.CreateInsertion($this().Tok.getLocation(), new StringRef(/*KEEP_STR*/"template "))));
            {
              
              TemplateNameKind TNK = $this().Actions.ActOnDependentTemplateName($this().getCurScope(), 
                  SS, new SourceLocation(), 
                  TemplateName, new OpaquePtr<QualType>(ObjectType), 
                  EnteringContext, Template);
              if ((TNK.getValue() != 0)) {
                // Consume the identifier.
                $this().ConsumeToken();
                if ($this().AnnotateTemplateIdToken(new OpaquePtr<TemplateName>(Template), TNK, SS, new SourceLocation(), 
                    TemplateName, false)) {
                  return true;
                }
              } else {
                return true;
              }
            }
            
            continue;
          } finally {
            $c$.$destroy();
          }
        }
      }
      
      // We don't have any tokens that form the beginning of a
      // nested-name-specifier, so we're done.
      break;
    }
    
    // Even if we didn't see any pieces of a nested-name-specifier, we
    // still check whether there is a tilde in this position, which
    // indicates a potential pseudo-destructor.
    if (CheckForDestructor && $this().Tok.is(tok.TokenKind.tilde)) {
      MayBePseudoDestructor.$set(true);
    }
    
    return false;
  }


/// \brief Emits an error for a left parentheses after a double colon.
///
/// When a '(' is found after a '::', emit an error.  Attempt to fix the token
/// stream by removing the '(', and the matching ')' if found.
//<editor-fold defaultstate="collapsed" desc="clang::Parser::CheckForLParenAfterColonColon">
@Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseExprCXX.cpp", line = 107,
   FQN="clang::Parser::CheckForLParenAfterColonColon", NM="_ZN5clang6Parser29CheckForLParenAfterColonColonEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseExprCXX.cpp -nm=_ZN5clang6Parser29CheckForLParenAfterColonColonEv")
  //</editor-fold>
  protected /*private*/ void CheckForLParenAfterColonColon() {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      if (!$this().Tok.is(tok.TokenKind.l_paren)) {
        return;
      }
      
      Token LParen = new Token($this().Tok);
      Token NextTok = new Token($this().GetLookAheadToken(1));
      Token StarTok = new Token(NextTok);
      // Check for (identifier or (*identifier
      Token IdentifierTok = new Token(StarTok.is(tok.TokenKind.star) ? $this().GetLookAheadToken(2) : StarTok);
      if (IdentifierTok.isNot(tok.TokenKind.identifier)) {
        return;
      }
      // Eat the '('.
      $this().ConsumeParen();
      Token RParen/*J*/= new Token();
      RParen.setLocation(new SourceLocation());
      // Do we have a ')' ?
      NextTok.$assign(StarTok.is(tok.TokenKind.star) ? $this().GetLookAheadToken(2) : $this().GetLookAheadToken(1));
      if (NextTok.is(tok.TokenKind.r_paren)) {
        RParen.$assign(NextTok);
        // Eat the '*' if it is present.
        if (StarTok.is(tok.TokenKind.star)) {
          $this().ConsumeToken();
        }
        // Eat the identifier.
        $this().ConsumeToken();
        // Add the identifier token back.
        $this().PP.EnterToken(IdentifierTok);
        // Add the '*' back if it was present.
        if (StarTok.is(tok.TokenKind.star)) {
          $this().PP.EnterToken(StarTok);
        }
        // Eat the ')'.
        $this().ConsumeParen();
      }
      
      $c$.clean($out_DiagnosticBuilder$C_FixItHint$C($out_DiagnosticBuilder$C_FixItHint$C($c$.track($this().Diag(LParen.getLocation(), diag.err_paren_after_colon_colon)), 
              FixItHint.CreateRemoval(new SourceRange(LParen.getLocation()))), 
          FixItHint.CreateRemoval(new SourceRange(RParen.getLocation()))));
    } finally {
      $c$.$destroy();
    }
  }


//===--------------------------------------------------------------------===//
// C++0x 5.1.2: Lambda expressions

// [...] () -> type {...}

/// ParseLambdaExpression - Parse a C++11 lambda expression.
///
///       lambda-expression:
///         lambda-introducer lambda-declarator[opt] compound-statement
///
///       lambda-introducer:
///         '[' lambda-capture[opt] ']'
///
///       lambda-capture:
///         capture-default
///         capture-list
///         capture-default ',' capture-list
///
///       capture-default:
///         '&'
///         '='
///
///       capture-list:
///         capture
///         capture-list ',' capture
///
///       capture:
///         simple-capture
///         init-capture     [C++1y]
///
///       simple-capture:
///         identifier
///         '&' identifier
///         'this'
///
///       init-capture:      [C++1y]
///         identifier initializer
///         '&' identifier initializer
///
///       lambda-declarator:
///         '(' parameter-declaration-clause ')' attribute-specifier[opt]
///           'mutable'[opt] exception-specification[opt]
///           trailing-return-type[opt]
///
//<editor-fold defaultstate="collapsed" desc="clang::Parser::ParseLambdaExpression">
@Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseExprCXX.cpp", line = 717,
   FQN="clang::Parser::ParseLambdaExpression", NM="_ZN5clang6Parser21ParseLambdaExpressionEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseExprCXX.cpp -nm=_ZN5clang6Parser21ParseLambdaExpressionEv")
  //</editor-fold>
  protected /*private*/ ActionResultTTrue<Expr /*P*/ > ParseLambdaExpression() {
    LambdaIntroducer Intro = null;
    try {
      // Parse lambda-introducer.
      Intro/*J*/= new LambdaIntroducer();
      OptionalUInt DiagID = $this().ParseLambdaIntroducer(Intro);
      if (DiagID.$bool()) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($c$.track($this().Diag($this().Tok, DiagID.getValue())));
          $this().SkipUntil(tok.TokenKind.r_square, SkipUntilFlags.StopAtSemi);
          $this().SkipUntil(tok.TokenKind.l_brace, SkipUntilFlags.StopAtSemi);
          $this().SkipUntil(tok.TokenKind.r_brace, SkipUntilFlags.StopAtSemi);
          return ExprError();
        } finally {
          $c$.$destroy();
        }
      }
      
      return $this().ParseLambdaExpressionAfterIntroducer(Intro);
    } finally {
      if (Intro != null) { Intro.$destroy(); }
    }
  }


/// TryParseLambdaExpression - Use lookahead and potentially tentative
/// parsing to determine if we are looking at a C++0x lambda expression, and parse
/// it if we are.
///
/// If we are not looking at a lambda expression, returns ExprError().
//<editor-fold defaultstate="collapsed" desc="clang::Parser::TryParseLambdaExpression">
@Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseExprCXX.cpp", line = 737,
   FQN="clang::Parser::TryParseLambdaExpression", NM="_ZN5clang6Parser24TryParseLambdaExpressionEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseExprCXX.cpp -nm=_ZN5clang6Parser24TryParseLambdaExpressionEv")
  //</editor-fold>
  protected /*private*/ ActionResultTTrue<Expr /*P*/ > TryParseLambdaExpression() {
    LambdaIntroducer Intro = null;
    try {
      assert ($this().getLangOpts().CPlusPlus11 && $this().Tok.is(tok.TokenKind.l_square)) : "Not at the start of a possible lambda expression.";
      
      /*const*/ Token Next = new Token($this().NextToken());
      if (Next.is(tok.TokenKind.eof)) { // Nothing else to lookup here...
        return ExprEmpty();
      }
      
      /*const*/ Token After = new Token($this().GetLookAheadToken(2));
      // If lookahead indicates this is a lambda...
      if (Next.is(tok.TokenKind.r_square) // []
         || Next.is(tok.TokenKind.equal) // [=
         || (Next.is(tok.TokenKind.amp) // [&] or [&,
         && (After.is(tok.TokenKind.r_square)
         || After.is(tok.TokenKind.comma)))
         || (Next.is(tok.TokenKind.identifier) // [identifier]
         && After.is(tok.TokenKind.r_square))) {
        return $this().ParseLambdaExpression();
      }
      
      // If lookahead indicates an ObjC message send...
      // [identifier identifier
      if (Next.is(tok.TokenKind.identifier) && After.is(tok.TokenKind.identifier)) {
        return ExprEmpty();
      }
      
      // Here, we're stuck: lambda introducers and Objective-C message sends are
      // unambiguous, but it requires arbitrary lookhead.  [a,b,c,d,e,f,g] is a
      // lambda, and [a,b,c,d,e,f,g h] is a Objective-C message send.  Instead of
      // writing two routines to parse a lambda introducer, just try to parse
      // a lambda introducer first, and fall back if that fails.
      // (TryParseLambdaIntroducer never produces any diagnostic output.)
      Intro/*J*/= new LambdaIntroducer();
      if ($this().TryParseLambdaIntroducer(Intro)) {
        return ExprEmpty();
      }
      
      return $this().ParseLambdaExpressionAfterIntroducer(Intro);
    } finally {
      if (Intro != null) { Intro.$destroy(); }
    }
  }


/// \brief Parse a lambda introducer.
/// \param Intro A LambdaIntroducer filled in with information about the
///        contents of the lambda-introducer.
/// \param SkippedInits If non-null, we are disambiguating between an Obj-C
///        message send and a lambda expression. In this mode, we will
///        sometimes skip the initializers for init-captures and not fully
///        populate \p Intro. This flag will be set to \c true if we do so.
/// \return A DiagnosticID if it hit something unexpected. The location for
///         for the diagnostic is that of the current token.
//<editor-fold defaultstate="collapsed" desc="clang::Parser::ParseLambdaIntroducer">
@Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseExprCXX.cpp", line = 786,
   FQN="clang::Parser::ParseLambdaIntroducer", NM="_ZN5clang6Parser21ParseLambdaIntroducerERNS_16LambdaIntroducerEPb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseExprCXX.cpp -nm=_ZN5clang6Parser21ParseLambdaIntroducerERNS_16LambdaIntroducerEPb")
  //</editor-fold>
  protected /*private*/ OptionalUInt ParseLambdaIntroducer(final LambdaIntroducer /*&*/ Intro) {
    return $this().ParseLambdaIntroducer(Intro, 
                       (bool$ptr/*bool P*/ )null);
  }
  protected /*private*/ OptionalUInt ParseLambdaIntroducer(final LambdaIntroducer /*&*/ Intro, 
                       bool$ptr/*bool P*/ SkippedInits/*= null*/) {
    BalancedDelimiterTracker T = null;
    try {
      /*typedef Optional<unsigned int> DiagResult*/
  //    final class DiagResult extends OptionalUInt{ };
      assert ($this().Tok.is(tok.TokenKind.l_square)) : "Lambda expressions begin with '['.";
      T/*J*/= new BalancedDelimiterTracker(/*Deref*/$this(), tok.TokenKind.l_square);
      T.consumeOpen();
      
      Intro.Range.setBegin(T.getOpenLocation());
      
      boolean first = true;
      
      // Parse capture-default.
      if ($this().Tok.is(tok.TokenKind.amp)
         && ($this().NextToken().is(tok.TokenKind.comma) || $this().NextToken().is(tok.TokenKind.r_square))) {
        Intro.Default = LambdaCaptureDefault.LCD_ByRef;
        Intro.DefaultLoc.$assignMove($this().ConsumeToken());
        first = false;
      } else if ($this().Tok.is(tok.TokenKind.equal)) {
        Intro.Default = LambdaCaptureDefault.LCD_ByCopy;
        Intro.DefaultLoc.$assignMove($this().ConsumeToken());
        first = false;
      }
      while ($this().Tok.isNot(tok.TokenKind.r_square)) {
        if (!first) {
          if ($this().Tok.isNot(tok.TokenKind.comma)) {
            // Provide a completion for a lambda introducer here. Except
            // in Objective-C, where this is Almost Surely meant to be a message
            // send. In that case, fail here and let the ObjC message
            // expression parser perform the completion.
            if ($this().Tok.is(tok.TokenKind.code_completion)
               && !($this().getLangOpts().ObjC1 && Intro.Default == LambdaCaptureDefault.LCD_None
               && !Intro.Captures.empty())) {
              $this().Actions.CodeCompleteLambdaIntroducer($this().getCurScope(), Intro, 
                  /*AfterAmpersand=*/ false);
              $this().cutOffParsing();
              break;
            }
            
            return new OptionalUInt(JD$T$RR.INSTANCE, diag.err_expected_comma_or_rsquare);
          }
          $this().ConsumeToken();
        }
        if ($this().Tok.is(tok.TokenKind.code_completion)) {
          // If we're in Objective-C++ and we have a bare '[', then this is more
          // likely to be a message receiver.
          if ($this().getLangOpts().ObjC1 && first) {
            $this().Actions.CodeCompleteObjCMessageReceiver($this().getCurScope());
          } else {
            $this().Actions.CodeCompleteLambdaIntroducer($this().getCurScope(), Intro, 
                /*AfterAmpersand=*/ false);
          }
          $this().cutOffParsing();
          break;
        }
        
        first = false;
        
        // Parse capture.
        LambdaCaptureKind Kind = LambdaCaptureKind.LCK_ByCopy;
        LambdaCaptureInitKind InitKind = LambdaCaptureInitKind.NoInit;
        SourceLocation Loc/*J*/= new SourceLocation();
        IdentifierInfo /*P*/ Id = null;
        SourceLocation EllipsisLoc/*J*/= new SourceLocation();
        ActionResultTTrue<Expr /*P*/ > Init/*J*/= new ActionResultTTrue<Expr /*P*/ >();
        if ($this().Tok.is(tok.TokenKind.star)) {
          Loc.$assignMove($this().ConsumeToken());
          if ($this().Tok.is(tok.TokenKind.kw_this)) {
            $this().ConsumeToken();
            Kind = LambdaCaptureKind.LCK_StarThis;
          } else {
            return new OptionalUInt(JD$T$RR.INSTANCE, diag.err_expected_star_this_capture);
          }
        } else if ($this().Tok.is(tok.TokenKind.kw_this)) {
          Kind = LambdaCaptureKind.LCK_This;
          Loc.$assignMove($this().ConsumeToken());
        } else {
          if ($this().Tok.is(tok.TokenKind.amp)) {
            Kind = LambdaCaptureKind.LCK_ByRef;
            $this().ConsumeToken();
            if ($this().Tok.is(tok.TokenKind.code_completion)) {
              $this().Actions.CodeCompleteLambdaIntroducer($this().getCurScope(), Intro, 
                  /*AfterAmpersand=*/ true);
              $this().cutOffParsing();
              break;
            }
          }
          if ($this().Tok.is(tok.TokenKind.identifier)) {
            Id = $this().Tok.getIdentifierInfo();
            Loc.$assignMove($this().ConsumeToken());
          } else if ($this().Tok.is(tok.TokenKind.kw_this)) {
            // FIXME: If we want to suggest a fixit here, will need to return more
            // than just DiagnosticID. Perhaps full DiagnosticBuilder that can be
            // Clear()ed to prevent emission in case of tentative parsing?
            return new OptionalUInt(JD$T$RR.INSTANCE, diag.err_this_captured_by_reference);
          } else {
            return new OptionalUInt(JD$T$RR.INSTANCE, diag.err_expected_capture);
          }
          if ($this().Tok.is(tok.TokenKind.l_paren)) {
            BalancedDelimiterTracker Parens = null;
            try {
              Parens/*J*/= new BalancedDelimiterTracker(/*Deref*/$this(), tok.TokenKind.l_paren);
              Parens.consumeOpen();
              
              InitKind = LambdaCaptureInitKind.DirectInit;
              
              SmallVector<Expr /*P*/ > Exprs/*J*/= new SmallVector<Expr /*P*/ >(12, (Expr /*P*/ )null);
              SmallVector<SourceLocation> Commas/*J*/= new SmallVector<SourceLocation>(20, new SourceLocation());
              if ((SkippedInits != null)) {
                Parens.skipToEnd();
                SkippedInits.$set(true);
              } else if ($this().ParseExpressionList(Exprs, Commas)) {
                Parens.skipToEnd();
                Init.$assignMove(ExprError());
              } else {
                Parens.consumeClose();
                Init.$assignMove($this().Actions.ActOnParenListExpr(Parens.getOpenLocation(), 
                        Parens.getCloseLocation(), 
                        new MutableArrayRef<Expr /*P*/ >(Exprs)));
              }
            } finally {
              if (Parens != null) { Parens.$destroy(); }
            }
          } else if ($this().Tok.isOneOf(tok.TokenKind.l_brace, tok.TokenKind.equal)) {
            EnterExpressionEvaluationContext EC = null;
            try {
              // Each lambda init-capture forms its own full expression, which clears
              // Actions.MaybeODRUseExprs. So create an expression evaluation context
              // to save the necessary state, and restore it later.
              EC/*J*/= new EnterExpressionEvaluationContext($this().Actions, 
                  Sema.ExpressionEvaluationContext.PotentiallyEvaluated);
              if ($this().TryConsumeToken(tok.TokenKind.equal)) {
                InitKind = LambdaCaptureInitKind.CopyInit;
              } else {
                InitKind = LambdaCaptureInitKind.ListInit;
              }
              if (!(SkippedInits != null)) {
                Init.$assignMove($this().ParseInitializer());
              } else if ($this().Tok.is(tok.TokenKind.l_brace)) {
                BalancedDelimiterTracker Braces = null;
                try {
                  Braces/*J*/= new BalancedDelimiterTracker(/*Deref*/$this(), tok.TokenKind.l_brace);
                  Braces.consumeOpen();
                  Braces.skipToEnd();
                  SkippedInits.$set(true);
                } finally {
                  if (Braces != null) { Braces.$destroy(); }
                }
              } else {
                InMessageExpressionRAIIObject MaybeInMessageExpression = null;
                try {
                  // We're disambiguating this:
                  //
                  //   [..., x = expr
                  //
                  // We need to find the end of the following expression in order to
                  // determine whether this is an Obj-C message send's receiver, a
                  // C99 designator, or a lambda init-capture.
                  //
                  // Parse the expression to find where it ends, and annotate it back
                  // onto the tokens. We would have parsed this expression the same way
                  // in either case: both the RHS of an init-capture and the RHS of an
                  // assignment expression are parsed as an initializer-clause, and in
                  // neither case can anything be added to the scope between the '[' and
                  // here.
                  //
                  // FIXME: This is horrible. Adding a mechanism to skip an expression
                  // would be much cleaner.
                  // FIXME: If there is a ',' before the next ']' or ':', we can skip to
                  // that instead. (And if we see a ':' with no matching '?', we can
                  // classify this as an Obj-C message send.)
                  SourceLocation StartLoc = $this().Tok.getLocation();
                  MaybeInMessageExpression/*J*/= new InMessageExpressionRAIIObject(/*Deref*/$this(), true);
                  Init.$assignMove($this().ParseInitializer());
                  if ($noteq_SourceLocation$C($this().Tok.getLocation(), StartLoc)) {
                    // Back out the lexing of the token after the initializer.
                    $this().PP.RevertCachedTokens(1);
                    
                    // Replace the consumed tokens with an appropriate annotation.
                    $this().Tok.setLocation(/*NO_COPY*/StartLoc);
                    $this().Tok.setKind(tok.TokenKind.annot_primary_expr);
                    setExprAnnotation($this().Tok, new ActionResultTTrue<Expr /*P*/ >(Init));
                    $this().Tok.setAnnotationEndLoc($this().PP.getLastCachedTokenLocation());
                    $this().PP.AnnotateCachedTokens($this().Tok);
                    
                    // Consume the annotated initializer.
                    $this().ConsumeToken();
                  }
                } finally {
                  if (MaybeInMessageExpression != null) { MaybeInMessageExpression.$destroy(); }
                }
              }
            } finally {
              if (EC != null) { EC.$destroy(); }
            }
          } else {
            $this().TryConsumeToken(tok.TokenKind.ellipsis, EllipsisLoc);
          }
        }
        // If this is an init capture, process the initialization expression
        // right away.  For lambda init-captures such as the following:
        // const int x = 10;
        //  auto L = [i = x+1](int a) {
        //    return [j = x+2,
        //           &k = x](char b) { };
        //  };
        // keep in mind that each lambda init-capture has to have:
        //  - its initialization expression executed in the context
        //    of the enclosing/parent decl-context.
        //  - but the variable itself has to be 'injected' into the
        //    decl-context of its lambda's call-operator (which has
        //    not yet been created).
        // Each init-expression is a full-expression that has to get
        // Sema-analyzed (for capturing etc.) before its lambda's
        // call-operator's decl-context, scope & scopeinfo are pushed on their
        // respective stacks.  Thus if any variable is odr-used in the init-capture
        // it will correctly get captured in the enclosing lambda, if one exists.
        // The init-variables above are created later once the lambdascope and
        // call-operators decl-context is pushed onto its respective stack.
        
        // Since the lambda init-capture's initializer expression occurs in the
        // context of the enclosing function or lambda, therefore we can not wait
        // till a lambda scope has been pushed on before deciding whether the
        // variable needs to be captured.  We also need to process all
        // lvalue-to-rvalue conversions and discarded-value conversions,
        // so that we can avoid capturing certain constant variables.
        // For e.g.,
        //  void test() {
        //   const int x = 10;
        //   auto L = [&z = x](char a) { <-- don't capture by the current lambda
        //     return [y = x](int i) { <-- don't capture by enclosing lambda
        //          return y;
        //     }
        //   };
        // If x was not const, the second use would require 'L' to capture, and
        // that would be an error.
        OpaquePtr<QualType> InitCaptureType/*J*/= new OpaquePtr<QualType>();
        if (Init.isUsable()) {
          // Get the pointer and store it in an lvalue, so we can use it as an
          // out argument.
          type$ref<Expr> /*P*/ InitExpr = create_type$ref(Init.get());
          // This performs any lvalue-to-rvalue conversions if necessary, which
          // can affect what gets captured in the containing decl-context.
          InitCaptureType.$assignMove($this().Actions.actOnLambdaInitCaptureInitialization(new SourceLocation(Loc), Kind == LambdaCaptureKind.LCK_ByRef, Id, InitKind, InitExpr));
          Init.$assign(InitExpr.$deref());
        }
        Intro.addCapture(Kind, new SourceLocation(Loc), Id, new SourceLocation(EllipsisLoc), InitKind, new ActionResultTTrue<Expr /*P*/ >(Init), 
            new OpaquePtr<QualType>(InitCaptureType));
      }
      
      T.consumeClose();
      Intro.Range.setEnd(T.getCloseLocation());
      return new OptionalUInt();
    } finally {
      if (T != null) { T.$destroy(); }
    }
  }


/// TryParseLambdaIntroducer - Tentatively parse a lambda introducer.
///
/// Returns true if it hit something unexpected.
//<editor-fold defaultstate="collapsed" desc="clang::Parser::TryParseLambdaIntroducer">
@Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseExprCXX.cpp", line = 1032,
   FQN="clang::Parser::TryParseLambdaIntroducer", NM="_ZN5clang6Parser24TryParseLambdaIntroducerERNS_16LambdaIntroducerE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseExprCXX.cpp -nm=_ZN5clang6Parser24TryParseLambdaIntroducerERNS_16LambdaIntroducerE")
  //</editor-fold>
  protected /*private*/ boolean TryParseLambdaIntroducer(final LambdaIntroducer /*&*/ Intro) {
    TentativeParsingAction PA = null;
    try {
      PA/*J*/= new TentativeParsingAction(/*Deref*/$this());
      
      bool$ptr SkippedInits = create_bool$ptr(false);
      OptionalUInt DiagID/*J*/= $this().ParseLambdaIntroducer(Intro, $AddrOf(SkippedInits));
      if (DiagID.$bool()) {
        PA.Revert();
        return true;
      }
      if (SkippedInits.$star()) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          // Parse it again, but this time parse the init-captures too.
          PA.Revert();
          $c$.clean(Intro.$assignMove($c$.track(new LambdaIntroducer())));
          DiagID.$assignMove($this().ParseLambdaIntroducer(Intro));
          assert (!DiagID.$bool()) : "parsing lambda-introducer failed on reparse";
          return false;
        } finally {
          $c$.$destroy();
        }
      }
      
      PA.Commit();
      return false;
    } finally {
      if (PA != null) { PA.$destroy(); }
    }
  }


/// ParseLambdaExpressionAfterIntroducer - Parse the rest of a lambda
/// expression.
//<editor-fold defaultstate="collapsed" desc="clang::Parser::ParseLambdaExpressionAfterIntroducer">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseExprCXX.cpp", line = 1058,
   FQN="clang::Parser::ParseLambdaExpressionAfterIntroducer", NM="_ZN5clang6Parser36ParseLambdaExpressionAfterIntroducerERNS_16LambdaIntroducerE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseExprCXX.cpp -nm=_ZN5clang6Parser36ParseLambdaExpressionAfterIntroducerERNS_16LambdaIntroducerE")
  //</editor-fold>
  protected /*private*/ ActionResultTTrue<Expr /*P*/ > ParseLambdaExpressionAfterIntroducer(final LambdaIntroducer /*&*/ Intro) {
    PrettyStackTraceLoc CrashInfo = null;
    DeclSpec DS = null;
    Declarator D = null;
    TemplateParameterDepthRAII CurTemplateDepthTracker = null;
    ParseScope BodyScope = null;
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      SourceLocation LambdaBeginLoc = Intro.Range.getBegin();
      $c$.clean($c$.track($this().Diag(new SourceLocation(LambdaBeginLoc), diag.warn_cxx98_compat_lambda)));
      
      CrashInfo/*J*/= new PrettyStackTraceLoc($this().PP.getSourceManager(), new SourceLocation(LambdaBeginLoc), 
          $("lambda expression parsing"));
      
      // FIXME: Call into Actions to add any init-capture declarations to the
      // scope while parsing the lambda-declarator and compound-statement.
      
      // Parse lambda-declarator[opt].
      DS/*J*/= new DeclSpec($this().AttrFactory);
      D/*J*/= new Declarator(DS, Declarator.TheContext.LambdaExprContext);
      CurTemplateDepthTracker/*J*/= new TemplateParameterDepthRAII($this().TemplateParameterDepth$Ref);
      $this().Actions.PushLambdaScope();
      
      ActionResult<OpaquePtr<QualType> > TrailingReturnType/*J*/= new ActionResult<OpaquePtr<QualType> >(JD$T.INSTANCE, new OpaquePtr<>());
      if ($this().Tok.is(tok.TokenKind.l_paren)) {
        ParseScope PrototypeScope = null;
        BalancedDelimiterTracker T = null;
        ParsedAttributes Attr = null;
        try {
          PrototypeScope/*J*/= new ParseScope($this(), 
              Scope.ScopeFlags.FunctionPrototypeScope
                 | Scope.ScopeFlags.FunctionDeclarationScope
                 | Scope.ScopeFlags.DeclScope);
          
          SourceLocation DeclEndLoc/*J*/= new SourceLocation();
          T/*J*/= new BalancedDelimiterTracker(/*Deref*/$this(), tok.TokenKind.l_paren);
          T.consumeOpen();
          SourceLocation LParenLoc = T.getOpenLocation();
          
          // Parse parameter-declaration-clause.
          Attr/*J*/= new ParsedAttributes($this().AttrFactory);
          SmallVector<DeclaratorChunk.ParamInfo> ParamInfo/*J*/= new SmallVector<DeclaratorChunk.ParamInfo>(16, new DeclaratorChunk.ParamInfo());
          SourceLocation EllipsisLoc/*J*/= new SourceLocation();
          if ($this().Tok.isNot(tok.TokenKind.r_paren)) {
            $this().Actions.RecordParsingTemplateParameterDepth($this().TemplateParameterDepth);
            $this().ParseParameterDeclarationClause(D, Attr, ParamInfo, EllipsisLoc);
            // For a generic lambda, each 'auto' within the parameter declaration 
            // clause creates a template type parameter, so increment the depth.
            if (($this().Actions.getCurGenericLambda() != null)) {
              CurTemplateDepthTracker.$preInc();
            }
          }
          T.consumeClose();
          SourceLocation RParenLoc = T.getCloseLocation();
          DeclEndLoc.$assign(RParenLoc);
          
          // GNU-style attributes must be parsed before the mutable specifier to be
          // compatible with GCC.
          $this().MaybeParseGNUAttributes(Attr, $AddrOf(DeclEndLoc));
          
          // MSVC-style attributes must be parsed before the mutable specifier to be
          // compatible with MSVC.
          $this().MaybeParseMicrosoftDeclSpecs(Attr, $AddrOf(DeclEndLoc));
          
          // Parse 'mutable'[opt].
          SourceLocation MutableLoc/*J*/= new SourceLocation();
          if ($this().TryConsumeToken(tok.TokenKind.kw_mutable, MutableLoc)) {
            DeclEndLoc.$assign(MutableLoc);
          }
          
          // Parse exception-specification[opt].
          ExceptionSpecificationType ESpecType = ExceptionSpecificationType.EST_None;
          SourceRange ESpecRange/*J*/= new SourceRange();
          SmallVector<OpaquePtr<QualType>> DynamicExceptions/*J*/= new SmallVector<OpaquePtr<QualType>>(2, new OpaquePtr<QualType>());
          SmallVector<SourceRange> DynamicExceptionRanges/*J*/= new SmallVector<SourceRange>(2, SourceRange.EMPTY);
          ActionResultTTrue<Expr /*P*/ > NoexceptExpr/*J*/= new ActionResultTTrue<Expr /*P*/ >();
          type$ref<SmallVectorToken /*P*/> ExceptionSpecTokens = create_type$null$ref(null);
          ESpecType = $this().tryParseExceptionSpecification(/*Delayed=*/ false, 
              ESpecRange, 
              DynamicExceptions, 
              DynamicExceptionRanges, 
              NoexceptExpr, 
              ExceptionSpecTokens);
          if (ESpecType != ExceptionSpecificationType.EST_None) {
            DeclEndLoc.$assignMove(ESpecRange.getEnd());
          }
          
          // Parse attribute-specifier[opt].
          $this().MaybeParseCXX11Attributes(Attr, $AddrOf(DeclEndLoc));
          
          SourceLocation FunLocalRangeEnd = new SourceLocation(DeclEndLoc);
          
          // Parse trailing-return-type[opt].
          if ($this().Tok.is(tok.TokenKind.arrow)) {
            FunLocalRangeEnd.$assignMove($this().Tok.getLocation());
            SourceRange Range/*J*/= new SourceRange();
            TrailingReturnType.$assignMove($this().ParseTrailingReturnType(Range));
            if (Range.getEnd().isValid()) {
              DeclEndLoc.$assignMove(Range.getEnd());
            }
          }
          
          PrototypeScope.Exit();
          
          SourceLocation NoLoc/*J*/= new SourceLocation();
          D.AddTypeInfo(DeclaratorChunk.getFunction(/*hasProto=*/ true, 
                  /*isAmbiguous=*/ false, 
                  new SourceLocation(LParenLoc), 
                  ParamInfo.data(), ParamInfo.size(), 
                  new SourceLocation(EllipsisLoc), new SourceLocation(RParenLoc), 
                  DS.getTypeQualifiers(), 
                  /*RefQualifierIsLValueRef=*/ true, 
                  /*RefQualifierLoc=*/ new SourceLocation(NoLoc), 
                  /*ConstQualifierLoc=*/ new SourceLocation(NoLoc), 
                  /*VolatileQualifierLoc=*/ new SourceLocation(NoLoc), 
                  /*RestrictQualifierLoc=*/ new SourceLocation(NoLoc), 
                  new SourceLocation(MutableLoc), 
                  ESpecType, new SourceRange(ESpecRange), 
                  DynamicExceptions.data(), 
                  DynamicExceptionRanges.data(), 
                  DynamicExceptions.size(), 
                  NoexceptExpr.isUsable() ? NoexceptExpr.get() : (Expr /*P*/ )null, 
                  /*ExceptionSpecTokens*/ (SmallVectorToken /*P*/)null, 
                  new SourceLocation(LParenLoc), new SourceLocation(FunLocalRangeEnd), D, 
                  new ActionResult<OpaquePtr<QualType> >(TrailingReturnType)), 
              Attr, new SourceLocation(DeclEndLoc));
        } finally {
          if (Attr != null) { Attr.$destroy(); }
          if (T != null) { T.$destroy(); }
          if (PrototypeScope != null) { PrototypeScope.$destroy(); }
        }
      } else if ($this().Tok.isOneOf$T(tok.TokenKind.kw_mutable, tok.TokenKind.arrow, tok.TokenKind.kw___attribute)
         || ($this().Tok.is(tok.TokenKind.l_square) && $this().NextToken().is(tok.TokenKind.l_square))) {
        ParsedAttributes Attr = null;
        try {
          // It's common to forget that one needs '()' before 'mutable', an attribute
          // specifier, or the result type. Deal with this.
          /*uint*/int TokKind = 0;
          switch ($this().Tok.getKind()) {
           case tok.TokenKind.kw_mutable:
            TokKind = 0;
            break;
           case tok.TokenKind.arrow:
            TokKind = 1;
            break;
           case tok.TokenKind.kw___attribute:
           case tok.TokenKind.l_square:
            TokKind = 2;
            break;
           default:
            throw new llvm_unreachable("Unknown token kind");
          }
          
          $c$.clean($out_DiagnosticBuilder$C_FixItHint$C($out_DiagnosticBuilder$C_uint($c$.track($this().Diag($this().Tok, diag.err_lambda_missing_parens)), 
                  TokKind), 
              FixItHint.CreateInsertion($this().Tok.getLocation(), new StringRef(/*KEEP_STR*/"() "))));
          SourceLocation DeclLoc = $this().Tok.getLocation();
          SourceLocation DeclEndLoc = new SourceLocation(DeclLoc);
          
          // GNU-style attributes must be parsed before the mutable specifier to be
          // compatible with GCC.
          Attr/*J*/= new ParsedAttributes($this().AttrFactory);
          $this().MaybeParseGNUAttributes(Attr, $AddrOf(DeclEndLoc));
          
          // Parse 'mutable', if it's there.
          SourceLocation MutableLoc/*J*/= new SourceLocation();
          if ($this().Tok.is(tok.TokenKind.kw_mutable)) {
            MutableLoc.$assignMove($this().ConsumeToken());
            DeclEndLoc.$assign(MutableLoc);
          }
          
          // Parse attribute-specifier[opt].
          $this().MaybeParseCXX11Attributes(Attr, $AddrOf(DeclEndLoc));
          
          // Parse the return type, if there is one.
          if ($this().Tok.is(tok.TokenKind.arrow)) {
            SourceRange Range/*J*/= new SourceRange();
            TrailingReturnType.$assignMove($this().ParseTrailingReturnType(Range));
            if (Range.getEnd().isValid()) {
              DeclEndLoc.$assignMove(Range.getEnd());
            }
          }
          
          SourceLocation NoLoc/*J*/= new SourceLocation();
          D.AddTypeInfo(DeclaratorChunk.getFunction(/*hasProto=*/ true, 
                  /*isAmbiguous=*/ false, 
                  /*LParenLoc=*/ new SourceLocation(NoLoc), 
                  /*Params=*/ (type$ptr<ParamInfo> /*P*/ )null, 
                  /*NumParams=*/ 0, 
                  /*EllipsisLoc=*/ new SourceLocation(NoLoc), 
                  /*RParenLoc=*/ new SourceLocation(NoLoc), 
                  /*TypeQuals=*/ 0, 
                  /*RefQualifierIsLValueRef=*/ true, 
                  /*RefQualifierLoc=*/ new SourceLocation(NoLoc), 
                  /*ConstQualifierLoc=*/ new SourceLocation(NoLoc), 
                  /*VolatileQualifierLoc=*/ new SourceLocation(NoLoc), 
                  /*RestrictQualifierLoc=*/ new SourceLocation(NoLoc), 
                  new SourceLocation(MutableLoc), 
                  ExceptionSpecificationType.EST_None, 
                  /*ESpecRange=*/ new SourceRange(), 
                  /*Exceptions=*/ (type$ptr<OpaquePtr<QualType>> /*P*/ )null, 
                  /*ExceptionRanges=*/ (type$ptr<SourceRange> /*P*/ )null, 
                  /*NumExceptions=*/ 0, 
                  /*NoexceptExpr=*/ (Expr /*P*/ )null, 
                  /*ExceptionSpecTokens=*/ (SmallVectorToken /*P*/)null, 
                  new SourceLocation(DeclLoc), new SourceLocation(DeclEndLoc), D, 
                  new ActionResult<OpaquePtr<QualType> >(TrailingReturnType)), 
              Attr, new SourceLocation(DeclEndLoc));
        } finally {
          if (Attr != null) { Attr.$destroy(); }
        }
      }
      
      // FIXME: Rename BlockScope -> ClosureScope if we decide to continue using
      // it.
      /*uint*/int ScopeFlags = Scope.ScopeFlags.BlockScope | Scope.ScopeFlags.FnScope | Scope.ScopeFlags.DeclScope;
      BodyScope/*J*/= new ParseScope($this(), ScopeFlags);
      
      $this().Actions.ActOnStartOfLambdaDefinition(Intro, D, $this().getCurScope());
      
      // Parse compound-statement.
      if (!$this().Tok.is(tok.TokenKind.l_brace)) {
        $c$.clean($c$.track($this().Diag($this().Tok, diag.err_expected_lambda_body)));
        $this().Actions.ActOnLambdaError(new SourceLocation(LambdaBeginLoc), $this().getCurScope());
        return ExprError();
      }
      
      ActionResultTTrue<Stmt /*P*/ > Stmt/*J*/= $this().ParseCompoundStatementBody();
      BodyScope.Exit();
      if (!Stmt.isInvalid() && !TrailingReturnType.isInvalid()) {
        return $this().Actions.ActOnLambdaExpr(new SourceLocation(LambdaBeginLoc), Stmt.get(), $this().getCurScope());
      }
      
      $this().Actions.ActOnLambdaError(new SourceLocation(LambdaBeginLoc), $this().getCurScope());
      return ExprError();
    } finally {
      if (BodyScope != null) { BodyScope.$destroy(); }
      if (CurTemplateDepthTracker != null) { CurTemplateDepthTracker.$destroy(); }
      if (D != null) { D.$destroy(); }
      if (DS != null) { DS.$destroy(); }
      if (CrashInfo != null) { CrashInfo.$destroy(); }
      $c$.$destroy();
    }
  }


//===--------------------------------------------------------------------===//
// C++ 5.2p1: C++ Casts

/// ParseCXXCasts - This handles the various ways to cast expressions to another
/// type.
///
///       postfix-expression: [C++ 5.2p1]
///         'dynamic_cast' '<' type-name '>' '(' expression ')'
///         'static_cast' '<' type-name '>' '(' expression ')'
///         'reinterpret_cast' '<' type-name '>' '(' expression ')'
///         'const_cast' '<' type-name '>' '(' expression ')'
///
//<editor-fold defaultstate="collapsed" desc="clang::Parser::ParseCXXCasts">
@Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseExprCXX.cpp", line = 1278,
   FQN="clang::Parser::ParseCXXCasts", NM="_ZN5clang6Parser13ParseCXXCastsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseExprCXX.cpp -nm=_ZN5clang6Parser13ParseCXXCastsEv")
  //</editor-fold>
  protected /*private*/ ActionResultTTrue<Expr /*P*/ > ParseCXXCasts() {
    DeclSpec DS = null;
    Declarator DeclaratorInfo = null;
    BalancedDelimiterTracker T = null;
    try {
      /*tok.TokenKind*/char Kind = $this().Tok.getKind();
      /*const*/char$ptr/*char P*/ CastName = null; // For error messages
      switch (Kind) {
       default:
        throw new llvm_unreachable("Unknown C++ cast!");
       case tok.TokenKind.kw_const_cast:
        CastName = $tryClone($const_cast);
        break;
       case tok.TokenKind.kw_dynamic_cast:
        CastName = $tryClone($dynamic_cast);
        break;
       case tok.TokenKind.kw_reinterpret_cast:
        CastName = $tryClone($reinterpret_cast);
        break;
       case tok.TokenKind.kw_static_cast:
        CastName = $tryClone($static_cast);
        break;
      }
      
      SourceLocation OpLoc = $this().ConsumeToken();
      SourceLocation LAngleBracketLoc = $this().Tok.getLocation();
      
      // Check for "<::" which is parsed as "[:".  If found, fix token stream,
      // diagnose error, suggest fix, and recover parsing.
      if ($this().Tok.is(tok.TokenKind.l_square) && $this().Tok.getLength() == 2) {
        Token Next = new Token($this().NextToken());
        if (Next.is(tok.TokenKind.colon) && $this().areTokensAdjacent($this().Tok, Next)) {
          FixDigraph(/*Deref*/$this(), $this().PP, $this().Tok, Next, Kind, /*AtDigraph*/ true);
        }
      }
      if ($this().ExpectAndConsume(tok.TokenKind.less, diag.err_expected_less_after, new StringRef(CastName))) {
        return ExprError();
      }
      
      // Parse the common declaration-specifiers piece.
      DS/*J*/= new DeclSpec($this().AttrFactory);
      $this().ParseSpecifierQualifierList(DS);
      
      // Parse the abstract-declarator, if present.
      DeclaratorInfo/*J*/= new Declarator(DS, Declarator.TheContext.TypeNameContext);
      $this().ParseDeclarator(DeclaratorInfo);
      
      SourceLocation RAngleBracketLoc = $this().Tok.getLocation();
      if ($this().ExpectAndConsume(tok.TokenKind.greater)) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          return $c$.clean(ExprError($out_DiagnosticBuilder$C_TokenKind($c$.track($this().Diag(new SourceLocation(LAngleBracketLoc), diag.note_matching)), tok.TokenKind.less)));
        } finally {
          $c$.$destroy();
        }
      }
      
      SourceLocation LParenLoc/*J*/= new SourceLocation(), RParenLoc/*J*/= new SourceLocation();
      T/*J*/= new BalancedDelimiterTracker(/*Deref*/$this(), tok.TokenKind.l_paren);
      if (T.expectAndConsume(diag.err_expected_lparen_after, CastName)) {
        return ExprError();
      }
      
      ActionResultTTrue<Expr /*P*/ > Result = $this().ParseExpression();
      
      // Match the ')'.
      T.consumeClose();
      if (!Result.isInvalid() && !DeclaratorInfo.isInvalidType()) {
        Result.$assignMove($this().Actions.ActOnCXXNamedCast(new SourceLocation(OpLoc), Kind, 
                new SourceLocation(LAngleBracketLoc), DeclaratorInfo, 
                new SourceLocation(RAngleBracketLoc), 
                T.getOpenLocation(), Result.get(), 
                T.getCloseLocation()));
      }
      
      return Result;
    } finally {
      if (T != null) { T.$destroy(); }
      if (DeclaratorInfo != null) { DeclaratorInfo.$destroy(); }
      if (DS != null) { DS.$destroy(); }
    }
  }


//===--------------------------------------------------------------------===//
// C++ 5.2p1: C++ Type Identification

/// ParseCXXTypeid - This handles the C++ typeid expression.
///
///       postfix-expression: [C++ 5.2p1]
///         'typeid' '(' expression ')'
///         'typeid' '(' type-id ')'
///
//<editor-fold defaultstate="collapsed" desc="clang::Parser::ParseCXXTypeid">
@Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseExprCXX.cpp", line = 1344,
   FQN="clang::Parser::ParseCXXTypeid", NM="_ZN5clang6Parser14ParseCXXTypeidEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseExprCXX.cpp -nm=_ZN5clang6Parser14ParseCXXTypeidEv")
  //</editor-fold>
  protected /*private*/ ActionResultTTrue<Expr /*P*/ > ParseCXXTypeid() {
    BalancedDelimiterTracker T = null;
    EnterExpressionEvaluationContext Unevaluated = null;
    try {
      assert ($this().Tok.is(tok.TokenKind.kw_typeid)) : "Not 'typeid'!";
      
      SourceLocation OpLoc = $this().ConsumeToken();
      SourceLocation LParenLoc/*J*/= new SourceLocation(), RParenLoc/*J*/= new SourceLocation();
      T/*J*/= new BalancedDelimiterTracker(/*Deref*/$this(), tok.TokenKind.l_paren);
      
      // typeid expressions are always parenthesized.
      if (T.expectAndConsume(diag.err_expected_lparen_after, $typeid)) {
        return ExprError();
      }
      LParenLoc.$assignMove(T.getOpenLocation());
      
      ActionResultTTrue<Expr /*P*/ > Result/*J*/= new ActionResultTTrue<Expr /*P*/ >();
      
      // C++0x [expr.typeid]p3:
      //   When typeid is applied to an expression other than an lvalue of a
      //   polymorphic class type [...] The expression is an unevaluated
      //   operand (Clause 5).
      //
      // Note that we can't tell whether the expression is an lvalue of a
      // polymorphic class type until after we've parsed the expression; we
      // speculatively assume the subexpression is unevaluated, and fix it up
      // later.
      //
      // We enter the unevaluated context before trying to determine whether we
      // have a type-id, because the tentative parse logic will try to resolve
      // names, and must treat them as unevaluated.
      Unevaluated/*J*/= new EnterExpressionEvaluationContext($this().Actions, Sema.ExpressionEvaluationContext.Unevaluated, 
          Sema.ReuseLambdaContextDecl_t.ReuseLambdaContextDecl);
      if ($this().isTypeIdInParens()) {
        ActionResult<OpaquePtr<QualType> > Ty = $this().ParseTypeName();
        
        // Match the ')'.
        T.consumeClose();
        RParenLoc.$assignMove(T.getCloseLocation());
        if (Ty.isInvalid() || RParenLoc.isInvalid()) {
          return ExprError();
        }
        
        Result.$assignMove($this().Actions.ActOnCXXTypeid(new SourceLocation(OpLoc), new SourceLocation(LParenLoc), /*isType=*/ true, 
                Ty.get().getAsOpaquePtr(), new SourceLocation(RParenLoc)));
      } else {
        Result.$assignMove($this().ParseExpression());
        
        // Match the ')'.
        if (Result.isInvalid()) {
          $this().SkipUntil(tok.TokenKind.r_paren, SkipUntilFlags.StopAtSemi);
        } else {
          T.consumeClose();
          RParenLoc.$assignMove(T.getCloseLocation());
          if (RParenLoc.isInvalid()) {
            return ExprError();
          }
          
          Result.$assignMove($this().Actions.ActOnCXXTypeid(new SourceLocation(OpLoc), new SourceLocation(LParenLoc), /*isType=*/ false, 
                  Result.get(), new SourceLocation(RParenLoc)));
        }
      }
      
      return Result;
    } finally {
      if (Unevaluated != null) { Unevaluated.$destroy(); }
      if (T != null) { T.$destroy(); }
    }
  }


//===--------------------------------------------------------------------===//
//  C++ : Microsoft __uuidof Expression

/// ParseCXXUuidof - This handles the Microsoft C++ __uuidof expression.
///
///         '__uuidof' '(' expression ')'
///         '__uuidof' '(' type-id ')'
///
//<editor-fold defaultstate="collapsed" desc="clang::Parser::ParseCXXUuidof">
@Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseExprCXX.cpp", line = 1410,
   FQN="clang::Parser::ParseCXXUuidof", NM="_ZN5clang6Parser14ParseCXXUuidofEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseExprCXX.cpp -nm=_ZN5clang6Parser14ParseCXXUuidofEv")
  //</editor-fold>
  protected /*private*/ ActionResultTTrue<Expr /*P*/ > ParseCXXUuidof() {
    BalancedDelimiterTracker T = null;
    try {
      assert ($this().Tok.is(tok.TokenKind.kw___uuidof)) : "Not '__uuidof'!";
      
      SourceLocation OpLoc = $this().ConsumeToken();
      T/*J*/= new BalancedDelimiterTracker(/*Deref*/$this(), tok.TokenKind.l_paren);
      
      // __uuidof expressions are always parenthesized.
      if (T.expectAndConsume(diag.err_expected_lparen_after, $__uuidof)) {
        return ExprError();
      }
      
      ActionResultTTrue<Expr /*P*/ > Result/*J*/= new ActionResultTTrue<Expr /*P*/ >();
      if ($this().isTypeIdInParens()) {
        ActionResult<OpaquePtr<QualType> > Ty = $this().ParseTypeName();
        
        // Match the ')'.
        T.consumeClose();
        if (Ty.isInvalid()) {
          return ExprError();
        }
        
        Result.$assignMove($this().Actions.ActOnCXXUuidof(new SourceLocation(OpLoc), T.getOpenLocation(), /*isType=*/ true, 
                Ty.get().getAsOpaquePtr(), 
                T.getCloseLocation()));
      } else {
        EnterExpressionEvaluationContext Unevaluated = null;
        try {
          Unevaluated/*J*/= new EnterExpressionEvaluationContext($this().Actions, Sema.ExpressionEvaluationContext.Unevaluated);
          Result.$assignMove($this().ParseExpression());
          
          // Match the ')'.
          if (Result.isInvalid()) {
            $this().SkipUntil(tok.TokenKind.r_paren, SkipUntilFlags.StopAtSemi);
          } else {
            T.consumeClose();
            
            Result.$assignMove($this().Actions.ActOnCXXUuidof(new SourceLocation(OpLoc), T.getOpenLocation(), 
                    /*isType=*/ false, 
                    Result.get(), T.getCloseLocation()));
          }
        } finally {
          if (Unevaluated != null) { Unevaluated.$destroy(); }
        }
      }
      
      return Result;
    } finally {
      if (T != null) { T.$destroy(); }
    }
  }


//===--------------------------------------------------------------------===//
// C++ 5.2.4: C++ Pseudo-Destructor Expressions

/// \brief Parse a C++ pseudo-destructor expression after the base,
/// . or -> operator, and nested-name-specifier have already been
/// parsed.
///
///       postfix-expression: [C++ 5.2]
///         postfix-expression . pseudo-destructor-name
///         postfix-expression -> pseudo-destructor-name
///
///       pseudo-destructor-name: 
///         ::[opt] nested-name-specifier[opt] type-name :: ~type-name 
///         ::[opt] nested-name-specifier template simple-template-id :: 
///                 ~type-name 
///         ::[opt] nested-name-specifier[opt] ~type-name
///       
//<editor-fold defaultstate="collapsed" desc="clang::Parser::ParseCXXPseudoDestructor">
@Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseExprCXX.cpp", line = 1467,
   FQN="clang::Parser::ParseCXXPseudoDestructor", NM="_ZN5clang6Parser24ParseCXXPseudoDestructorEPNS_4ExprENS_14SourceLocationENS_3tok9TokenKindERNS_12CXXScopeSpecENS_9OpaquePtrINS_8QualTypeEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseExprCXX.cpp -nm=_ZN5clang6Parser24ParseCXXPseudoDestructorEPNS_4ExprENS_14SourceLocationENS_3tok9TokenKindERNS_12CXXScopeSpecENS_9OpaquePtrINS_8QualTypeEEE")
  //</editor-fold>
  protected /*private*/ ActionResultTTrue<Expr /*P*/ > ParseCXXPseudoDestructor(Expr /*P*/ Base, SourceLocation OpLoc, 
                          /*tok.TokenKind*/char OpKind, 
                          final CXXScopeSpec /*&*/ SS, 
                          OpaquePtr<QualType> ObjectType) {
    // We're parsing either a pseudo-destructor-name or a dependent
    // member access that has the same form as a
    // pseudo-destructor-name. We parse both in the same way and let
    // the action model sort them out.
    //
    // Note that the ::[opt] nested-name-specifier[opt] has already
    // been parsed, and if there was a simple-template-id, it has
    // been coalesced into a template-id annotation token.
    UnqualifiedId FirstTypeName/*J*/= new UnqualifiedId();
    SourceLocation CCLoc/*J*/= new SourceLocation();
    if ($this().Tok.is(tok.TokenKind.identifier)) {
      FirstTypeName.setIdentifier($this().Tok.getIdentifierInfo(), $this().Tok.getLocation());
      $this().ConsumeToken();
      assert ($this().Tok.is(tok.TokenKind.coloncolon)) : "ParseOptionalCXXScopeSpecifier fail";
      CCLoc.$assignMove($this().ConsumeToken());
    } else if ($this().Tok.is(tok.TokenKind.annot_template_id)) {
      // FIXME: retrieve TemplateKWLoc from template-id annotation and
      // store it in the pseudo-dtor node (to be used when instantiating it).
      FirstTypeName.setTemplateId((TemplateIdAnnotation /*P*/ )$this().Tok.getAnnotationValue());
      $this().ConsumeToken();
      assert ($this().Tok.is(tok.TokenKind.coloncolon)) : "ParseOptionalCXXScopeSpecifier fail";
      CCLoc.$assignMove($this().ConsumeToken());
    } else {
      FirstTypeName.setIdentifier((/*const*/ IdentifierInfo /*P*/ )null, new SourceLocation());
    }
    
    // Parse the tilde.
    assert ($this().Tok.is(tok.TokenKind.tilde)) : "ParseOptionalCXXScopeSpecifier fail";
    SourceLocation TildeLoc = $this().ConsumeToken();
    if ($this().Tok.is(tok.TokenKind.kw_decltype) && !FirstTypeName.isValid() && SS.isEmpty()) {
      DeclSpec DS = null;
      try {
        DS/*J*/= new DeclSpec($this().AttrFactory);
        $this().ParseDecltypeSpecifier(DS);
        if (DS.getTypeSpecType() == TypeSpecifierType.TST_error) {
          return ExprError();
        }
        return $this().Actions.ActOnPseudoDestructorExpr($this().getCurScope(), Base, new SourceLocation(OpLoc), OpKind, 
            new SourceLocation(TildeLoc), DS);
      } finally {
        if (DS != null) { DS.$destroy(); }
      }
    }
    if (!$this().Tok.is(tok.TokenKind.identifier)) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($c$.track($this().Diag($this().Tok, diag.err_destructor_tilde_identifier)));
        return ExprError();
      } finally {
        $c$.$destroy();
      }
    }
    
    // Parse the second type.
    UnqualifiedId SecondTypeName/*J*/= new UnqualifiedId();
    IdentifierInfo /*P*/ Name = $this().Tok.getIdentifierInfo();
    SourceLocation NameLoc = $this().ConsumeToken();
    SecondTypeName.setIdentifier(Name, new SourceLocation(NameLoc));
    
    // If there is a '<', the second type name is a template-id. Parse
    // it as such.
    if ($this().Tok.is(tok.TokenKind.less)
       && $this().ParseUnqualifiedIdTemplateId(SS, new SourceLocation(), 
        Name, new SourceLocation(NameLoc), 
        false, new OpaquePtr<QualType>(ObjectType), SecondTypeName, 
        /*AssumeTemplateName=*/ true)) {
      return ExprError();
    }
    
    return $this().Actions.ActOnPseudoDestructorExpr($this().getCurScope(), Base, new SourceLocation(OpLoc), OpKind, 
        SS, FirstTypeName, new SourceLocation(CCLoc), new SourceLocation(TildeLoc), 
        SecondTypeName);
  }


//===--------------------------------------------------------------------===//
// C++ 9.3.2: C++ 'this' pointer

/// ParseCXXThis - This handles the C++ 'this' pointer.
///
/// C++ 9.3.2: In the body of a non-static member function, the keyword this is
/// a non-lvalue expression whose value is the address of the object for which
/// the function is called.
//<editor-fold defaultstate="collapsed" desc="clang::Parser::ParseCXXThis">
@Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseExprCXX.cpp", line = 1594,
   FQN="clang::Parser::ParseCXXThis", NM="_ZN5clang6Parser12ParseCXXThisEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseExprCXX.cpp -nm=_ZN5clang6Parser12ParseCXXThisEv")
  //</editor-fold>
  protected /*private*/ ActionResultTTrue<Expr /*P*/ > ParseCXXThis() {
    assert ($this().Tok.is(tok.TokenKind.kw_this)) : "Not 'this'!";
    SourceLocation ThisLoc = $this().ConsumeToken();
    return $this().Actions.ActOnCXXThis(new SourceLocation(ThisLoc));
  }


//===--------------------------------------------------------------------===//
// C++ 15: C++ Throw Expression

/// ParseThrowExpression - This handles the C++ throw expression.
///
///       throw-expression: [C++ 15]
///         'throw' assignment-expression[opt]
//<editor-fold defaultstate="collapsed" desc="clang::Parser::ParseThrowExpression">
@Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseExprCXX.cpp", line = 1551,
   FQN="clang::Parser::ParseThrowExpression", NM="_ZN5clang6Parser20ParseThrowExpressionEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseExprCXX.cpp -nm=_ZN5clang6Parser20ParseThrowExpressionEv")
  //</editor-fold>
  protected /*private*/ ActionResultTTrue<Expr /*P*/ > ParseThrowExpression() {
    assert ($this().Tok.is(tok.TokenKind.kw_throw)) : "Not throw!";
    SourceLocation ThrowLoc = $this().ConsumeToken(); // Eat the throw token.
    
    // If the current token isn't the start of an assignment-expression,
    // then the expression is not present.  This handles things like:
    //   "C ? throw : (void)42", which is crazy but legal.
    switch ($this().Tok.getKind()) { // FIXME: move this predicate somewhere common.
     case tok.TokenKind.semi:
     case tok.TokenKind.r_paren:
     case tok.TokenKind.r_square:
     case tok.TokenKind.r_brace:
     case tok.TokenKind.colon:
     case tok.TokenKind.comma:
      return $this().Actions.ActOnCXXThrow($this().getCurScope(), new SourceLocation(ThrowLoc), (Expr /*P*/ )null);
     default:
      ActionResultTTrue<Expr /*P*/ > Expr/*J*/= $this().ParseAssignmentExpression();
      if (Expr.isInvalid()) {
        return Expr;
      }
      return $this().Actions.ActOnCXXThrow($this().getCurScope(), new SourceLocation(ThrowLoc), Expr.get());
    }
  }


//===--------------------------------------------------------------------===//
// C++ 2.13.5: C++ Boolean Literals

/// ParseCXXBoolLiteral - This handles the C++ Boolean literals.
///
///       boolean-literal: [C++ 2.13.5]
///         'true'
///         'false'
//<editor-fold defaultstate="collapsed" desc="clang::Parser::ParseCXXBoolLiteral">
@Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseExprCXX.cpp", line = 1542,
   FQN="clang::Parser::ParseCXXBoolLiteral", NM="_ZN5clang6Parser19ParseCXXBoolLiteralEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseExprCXX.cpp -nm=_ZN5clang6Parser19ParseCXXBoolLiteralEv")
  //</editor-fold>
  protected /*private*/ ActionResultTTrue<Expr /*P*/ > ParseCXXBoolLiteral() {
    /*tok.TokenKind*/char Kind = $this().Tok.getKind();
    return $this().Actions.ActOnCXXBoolLiteral($this().ConsumeToken(), Kind);
  }


//===--------------------------------------------------------------------===//
// C++ 5.2.3: Explicit type conversion (functional notation)

/// ParseCXXTypeConstructExpression - Parse construction of a specified type.
/// Can be interpreted either as function-style casting ("int(x)")
/// or class type construction ("ClassType(x,y,z)")
/// or creation of a value-initialized type ("int()").
/// See [C++ 5.2.3].
///
///       postfix-expression: [C++ 5.2p1]
///         simple-type-specifier '(' expression-list[opt] ')'
/// [C++0x] simple-type-specifier braced-init-list
///         typename-specifier '(' expression-list[opt] ')'
/// [C++0x] typename-specifier braced-init-list
///
//<editor-fold defaultstate="collapsed" desc="clang::Parser::ParseCXXTypeConstructExpression">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*removed track from lambda*/,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseExprCXX.cpp", line = 1612,
   FQN="clang::Parser::ParseCXXTypeConstructExpression", NM="_ZN5clang6Parser31ParseCXXTypeConstructExpressionERKNS_8DeclSpecE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseExprCXX.cpp -nm=_ZN5clang6Parser31ParseCXXTypeConstructExpressionERKNS_8DeclSpecE")
  //</editor-fold>
  protected /*private*/ ActionResultTTrue<Expr /*P*/ > ParseCXXTypeConstructExpression(final /*const*/ DeclSpec /*&*/ DS) {
    Declarator DeclaratorInfo = null;
    try {
      DeclaratorInfo/*J*/= new Declarator(DS, Declarator.TheContext.TypeNameContext);
      OpaquePtr<QualType> TypeRep = $this().Actions.ActOnTypeName($this().getCurScope(), DeclaratorInfo).get();
      assert (($this().Tok.is(tok.TokenKind.l_paren) || ($this().getLangOpts().CPlusPlus11 && $this().Tok.is(tok.TokenKind.l_brace)))) : "Expected '(' or '{'!";
      if ($this().Tok.is(tok.TokenKind.l_brace)) {
        ActionResultTTrue<Expr /*P*/ > Init = $this().ParseBraceInitializer();
        if (Init.isInvalid()) {
          return Init;
        }
        Expr /*P*/ InitList = Init.get();
        return $this().Actions.ActOnCXXTypeConstructExpr(new OpaquePtr<QualType>(TypeRep), new SourceLocation(), 
            new MutableArrayRef<Expr /*P*/ >($AddrOf(create_type$ptr(InitList)), 1, true), 
            new SourceLocation());
      } else {
        BalancedDelimiterTracker T = null;
        try {
          T/*J*/= new BalancedDelimiterTracker(/*Deref*/$this(), tok.TokenKind.l_paren);
          T.consumeOpen();
          
          SmallVector<Expr /*P*/ > Exprs/*J*/= new SmallVector<Expr /*P*/ >(12, (Expr /*P*/ )null);
          SmallVector<SourceLocation> CommaLocs/*J*/= new SmallVector<SourceLocation>(20, new SourceLocation());
          if ($this().Tok.isNot(tok.TokenKind.r_paren)) {
            if ($this().ParseExpressionList(Exprs, CommaLocs, ()->
                      {
                        $this().Actions.CodeCompleteConstructor($this().getCurScope(), 
                            TypeRep.getQualType().$arrow().getCanonicalTypeInternal(), 
                            DS.getLocEnd(), new ArrayRef<Expr /*P*/ >(Exprs));
                      }
                )) {
              $this().SkipUntil(tok.TokenKind.r_paren, SkipUntilFlags.StopAtSemi);
              return ExprError();
            }
          }
          
          // Match the ')'.
          T.consumeClose();
          
          // TypeRep could be null, if it references an invalid typedef.
          if (!TypeRep.$bool()) {
            return ExprError();
          }
          assert ((Exprs.size() == 0 || Exprs.size() - 1 == CommaLocs.size())) : "Unexpected number of commas!";
          return $this().Actions.ActOnCXXTypeConstructExpr(new OpaquePtr<QualType>(TypeRep), T.getOpenLocation(), 
              new MutableArrayRef<Expr /*P*/ >(Exprs), 
              T.getCloseLocation());
        } finally {
          if (T != null) { T.$destroy(); }
        }
      }
    } finally {
      if (DeclaratorInfo != null) { DeclaratorInfo.$destroy(); }
    }
  }


/// ParseCXXSimpleTypeSpecifier - [C++ 7.1.5.2] Simple type specifiers.
/// This should only be called when the current token is known to be part of
/// simple-type-specifier.

/// ParseCXXSimpleTypeSpecifier - [C++ 7.1.5.2] Simple type specifiers.
/// This should only be called when the current token is known to be part of
/// simple-type-specifier.
///
///       simple-type-specifier:
///         '::'[opt] nested-name-specifier[opt] type-name
///         '::'[opt] nested-name-specifier 'template' simple-template-id [TODO]
///         char
///         wchar_t
///         bool
///         short
///         int
///         long
///         signed
///         unsigned
///         float
///         double
///         void
/// [GNU]   typeof-specifier
/// [C++0x] auto               [TODO]
///
///       type-name:
///         class-name
///         enum-name
///         typedef-name
///
//<editor-fold defaultstate="collapsed" desc="clang::Parser::ParseCXXSimpleTypeSpecifier">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseExprCXX.cpp", line = 1818,
   FQN="clang::Parser::ParseCXXSimpleTypeSpecifier", NM="_ZN5clang6Parser27ParseCXXSimpleTypeSpecifierERNS_8DeclSpecE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseExprCXX.cpp -nm=_ZN5clang6Parser27ParseCXXSimpleTypeSpecifierERNS_8DeclSpecE")
  //</editor-fold>
  protected /*private*/ void ParseCXXSimpleTypeSpecifier(final DeclSpec /*&*/ DS) {
    DS.SetRangeStart($this().Tok.getLocation());
    /*const*/char$ptr/*char P*/ PrevSpec = create_char$null$ptr();
    /*uint*/uint$ref DiagID = create_uint$ref();
    SourceLocation Loc = $this().Tok.getLocation();
    final /*const*/ PrintingPolicy /*&*/ Policy = $this().Actions.getASTContext().getPrintingPolicy();
    switch ($this().Tok.getKind()) {
     case tok.TokenKind.identifier: // foo::bar
     case tok.TokenKind.coloncolon: // ::foo::bar
      throw new llvm_unreachable("Annotation token should already be formed!");
     default:
      throw new llvm_unreachable("Not a simple-type-specifier token!");
     case tok.TokenKind.annot_typename:
      {
        if (getTypeAnnotation($this().Tok).$bool()) {
          DS.SetTypeSpecType(DeclSpec.TST_typename, new SourceLocation(Loc), PrevSpec, DiagID, 
              getTypeAnnotation($this().Tok), Policy);
        } else {
          DS.SetTypeSpecError();
        }
        
        DS.SetRangeEnd($this().Tok.getAnnotationEndLoc());
        $this().ConsumeToken();
        
        DS.Finish($this().Actions, Policy);
        return;
      }
     case tok.TokenKind.kw_short:
      
      // builtin types
      DS.SetTypeSpecWidth(DeclSpec.TSW_short, new SourceLocation(Loc), PrevSpec, DiagID, Policy);
      break;
     case tok.TokenKind.kw_long:
      DS.SetTypeSpecWidth(DeclSpec.TSW_long, new SourceLocation(Loc), PrevSpec, DiagID, Policy);
      break;
     case tok.TokenKind.kw___int64:
      DS.SetTypeSpecWidth(DeclSpec.TSW_longlong, new SourceLocation(Loc), PrevSpec, DiagID, Policy);
      break;
     case tok.TokenKind.kw_signed:
      DS.SetTypeSpecSign(DeclSpec.TSS_signed, new SourceLocation(Loc), PrevSpec, DiagID);
      break;
     case tok.TokenKind.kw_unsigned:
      DS.SetTypeSpecSign(DeclSpec.TSS_unsigned, new SourceLocation(Loc), PrevSpec, DiagID);
      break;
     case tok.TokenKind.kw_void:
      DS.SetTypeSpecType(DeclSpec.TST_void, new SourceLocation(Loc), PrevSpec, DiagID, Policy);
      break;
     case tok.TokenKind.kw_char:
      DS.SetTypeSpecType(DeclSpec.TST_char, new SourceLocation(Loc), PrevSpec, DiagID, Policy);
      break;
     case tok.TokenKind.kw_int:
      DS.SetTypeSpecType(DeclSpec.TST_int, new SourceLocation(Loc), PrevSpec, DiagID, Policy);
      break;
     case tok.TokenKind.kw___int128:
      DS.SetTypeSpecType(DeclSpec.TST_int128, new SourceLocation(Loc), PrevSpec, DiagID, Policy);
      break;
     case tok.TokenKind.kw_half:
      DS.SetTypeSpecType(DeclSpec.TST_half, new SourceLocation(Loc), PrevSpec, DiagID, Policy);
      break;
     case tok.TokenKind.kw_float:
      DS.SetTypeSpecType(DeclSpec.TST_float, new SourceLocation(Loc), PrevSpec, DiagID, Policy);
      break;
     case tok.TokenKind.kw_double:
      DS.SetTypeSpecType(DeclSpec.TST_double, new SourceLocation(Loc), PrevSpec, DiagID, Policy);
      break;
     case tok.TokenKind.kw___float128:
      DS.SetTypeSpecType(DeclSpec.TST_float128, new SourceLocation(Loc), PrevSpec, DiagID, Policy);
      break;
     case tok.TokenKind.kw_wchar_t:
      DS.SetTypeSpecType(DeclSpec.TST_wchar, new SourceLocation(Loc), PrevSpec, DiagID, Policy);
      break;
     case tok.TokenKind.kw_char16_t:
      DS.SetTypeSpecType(DeclSpec.TST_char16, new SourceLocation(Loc), PrevSpec, DiagID, Policy);
      break;
     case tok.TokenKind.kw_char32_t:
      DS.SetTypeSpecType(DeclSpec.TST_char32, new SourceLocation(Loc), PrevSpec, DiagID, Policy);
      break;
     case tok.TokenKind.kw_bool:
      DS.SetTypeSpecType(DeclSpec.TST_bool, new SourceLocation(Loc), PrevSpec, DiagID, Policy);
      break;
     case tok.TokenKind.annot_decltype:
     case tok.TokenKind.kw_decltype:
      DS.SetRangeEnd($this().ParseDecltypeSpecifier(DS));
      DS.Finish($this().Actions, Policy);
      return;
     case tok.TokenKind.kw_typeof:
      
      // GNU typeof support.
      $this().ParseTypeofSpecifier(DS);
      DS.Finish($this().Actions, Policy);
      return;
    }
    if ($this().Tok.is(tok.TokenKind.annot_typename)) {
      DS.SetRangeEnd($this().Tok.getAnnotationEndLoc());
    } else {
      DS.SetRangeEnd($this().Tok.getLocation());
    }
    $this().ConsumeToken();
    DS.Finish($this().Actions, Policy);
  }


/// ParseCXXTypeSpecifierSeq - Parse a C++ type-specifier-seq (C++
/// [dcl.name]), which is a non-empty sequence of type-specifiers,
/// e.g., "const short int". Note that the DeclSpec is *not* finished
/// by parsing the type-specifier-seq, because these sequences are
/// typically followed by some form of declarator. Returns true and
/// emits diagnostics if this is not a type-specifier-seq, false
/// otherwise.
///
///   type-specifier-seq: [C++ 8.1]
///     type-specifier type-specifier-seq[opt]
///
//<editor-fold defaultstate="collapsed" desc="clang::Parser::ParseCXXTypeSpecifierSeq">
@Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseExprCXX.cpp", line = 1930,
   FQN="clang::Parser::ParseCXXTypeSpecifierSeq", NM="_ZN5clang6Parser24ParseCXXTypeSpecifierSeqERNS_8DeclSpecE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseExprCXX.cpp -nm=_ZN5clang6Parser24ParseCXXTypeSpecifierSeqERNS_8DeclSpecE")
  //</editor-fold>
  protected /*private*/ boolean ParseCXXTypeSpecifierSeq(final DeclSpec /*&*/ DS) {
    $this().ParseSpecifierQualifierList(DS, AccessSpecifier.AS_none, DeclSpecContext.DSC_type_specifier);
    DS.Finish($this().Actions, $this().Actions.getASTContext().getPrintingPolicy());
    return false;
  }


//===--------------------------------------------------------------------===//
// C++ 5.3.4 and 5.3.5: C++ new and delete

/// ParseExpressionListOrTypeId - Parse either an expression-list or a type-id.
/// This ambiguity appears in the syntax of the C++ new operator.
///
///        new-expression:
///                   '::'[opt] 'new' new-placement[opt] '(' type-id ')'
///                                     new-initializer[opt]
///
///        new-placement:
///                   '(' expression-list ')'
///
//<editor-fold defaultstate="collapsed" desc="clang::Parser::ParseExpressionListOrTypeId">
@Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseExprCXX.cpp", line = 2810,
   FQN="clang::Parser::ParseExpressionListOrTypeId", NM="_ZN5clang6Parser27ParseExpressionListOrTypeIdERN4llvm15SmallVectorImplIPNS_4ExprEEERNS_10DeclaratorE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseExprCXX.cpp -nm=_ZN5clang6Parser27ParseExpressionListOrTypeIdERN4llvm15SmallVectorImplIPNS_4ExprEEERNS_10DeclaratorE")
  //</editor-fold>
  protected /*private*/ boolean ParseExpressionListOrTypeId(final SmallVectorImpl<Expr /*P*/ > /*&*/ PlacementArgs, 
                             final Declarator /*&*/ D) {
    // The '(' was already consumed.
    if ($this().isTypeIdInParens()) {
      $this().ParseSpecifierQualifierList(D.getMutableDeclSpec());
      D.SetSourceRange(D.getDeclSpec().getSourceRange());
      $this().ParseDeclarator(D);
      return D.isInvalidType();
    }
    
    // It's not a type, it has to be an expression list.
    // Discard the comma locations - ActOnCXXNew has enough parameters.
    SmallVector<SourceLocation> CommaLocs/*J*/= new SmallVector<SourceLocation>(20, new SourceLocation());
    return $this().ParseExpressionList(PlacementArgs, CommaLocs);
  }


/// ParseDirectNewDeclarator - Parses a direct-new-declarator. Intended to be
/// passed to ParseDeclaratorInternal.
///
///        direct-new-declarator:
///                   '[' expression ']'
///                   direct-new-declarator '[' constant-expression ']'
///
//<editor-fold defaultstate="collapsed" desc="clang::Parser::ParseDirectNewDeclarator">
@Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseExprCXX.cpp", line = 2762,
   FQN="clang::Parser::ParseDirectNewDeclarator", NM="_ZN5clang6Parser24ParseDirectNewDeclaratorERNS_10DeclaratorE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseExprCXX.cpp -nm=_ZN5clang6Parser24ParseDirectNewDeclaratorERNS_10DeclaratorE")
  //</editor-fold>
  protected /*private*/ void ParseDirectNewDeclarator(final Declarator /*&*/ D) {
    // Parse the array dimensions.
    boolean first = true;
    while ($this().Tok.is(tok.TokenKind.l_square)) {
      BalancedDelimiterTracker T = null;
      ParsedAttributes Attrs = null;
      try {
        // An array-size expression can't start with a lambda.
        if ($this().CheckProhibitedCXX11Attribute()) {
          continue;
        }
        
        T/*J*/= new BalancedDelimiterTracker(/*Deref*/$this(), tok.TokenKind.l_square);
        T.consumeOpen();
        
        ActionResultTTrue<Expr /*P*/ > Size/*J*/= first ? $this().ParseExpression() : $this().ParseConstantExpression();
        if (Size.isInvalid()) {
          // Recover
          $this().SkipUntil(tok.TokenKind.r_square, SkipUntilFlags.StopAtSemi);
          return;
        }
        first = false;
        
        T.consumeClose();
        
        // Attributes here appertain to the array type. C++11 [expr.new]p5.
        Attrs/*J*/= new ParsedAttributes($this().AttrFactory);
        $this().MaybeParseCXX11Attributes(Attrs);
        
        D.AddTypeInfo(DeclaratorChunk.getArray(0, 
                /*static=*/ false, /*star=*/ false, 
                Size.get(), 
                T.getOpenLocation(), 
                T.getCloseLocation()), 
            Attrs, T.getCloseLocation());
        if (T.getCloseLocation().isInvalid()) {
          return;
        }
      } finally {
        if (Attrs != null) { Attrs.$destroy(); }
        if (T != null) { T.$destroy(); }
      }
    }
  }


/// ParseCXXNewExpression - Parse a C++ new-expression. New is used to allocate
/// memory in a typesafe manner and call constructors.
///
/// This method is called to parse the new expression after the optional :: has
/// been already parsed.  If the :: was present, "UseGlobal" is true and "Start"
/// is its location.  Otherwise, "Start" is the location of the 'new' token.
///
///        new-expression:
///                   '::'[opt] 'new' new-placement[opt] new-type-id
///                                     new-initializer[opt]
///                   '::'[opt] 'new' new-placement[opt] '(' type-id ')'
///                                     new-initializer[opt]
///
///        new-placement:
///                   '(' expression-list ')'
///
///        new-type-id:
///                   type-specifier-seq new-declarator[opt]
/// [GNU]             attributes type-specifier-seq new-declarator[opt]
///
///        new-declarator:
///                   ptr-operator new-declarator[opt]
///                   direct-new-declarator
///
///        new-initializer:
///                   '(' expression-list[opt] ')'
/// [C++0x]           braced-init-list
///
//<editor-fold defaultstate="collapsed" desc="clang::Parser::ParseCXXNewExpression">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*splict DeclaratorInfo on two vars*/,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseExprCXX.cpp", line = 2637,
   FQN="clang::Parser::ParseCXXNewExpression", NM="_ZN5clang6Parser21ParseCXXNewExpressionEbNS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseExprCXX.cpp -nm=_ZN5clang6Parser21ParseCXXNewExpressionEbNS_14SourceLocationE")
  //</editor-fold>
  protected /*private*/ ActionResultTTrue<Expr /*P*/ > ParseCXXNewExpression(boolean UseGlobal, SourceLocation Start) {
    DeclSpec DS = null;
    Declarator $DeclaratorInfo = null; // JAVA: two vars to allow the initialized one to be used from lambda
    try {
      assert ($this().Tok.is(tok.TokenKind.kw_new)) : "expected 'new' token";
      $this().ConsumeToken(); // Consume 'new'
      
      // A '(' now can be a new-placement or the '(' wrapping the type-id in the
      // second form of new-expression. It can't be a new-type-id.
      SmallVector<Expr /*P*/ > PlacementArgs/*J*/= new SmallVector<Expr /*P*/ >(12, (Expr /*P*/ )null);
      SourceLocation PlacementLParen/*J*/= new SourceLocation(), PlacementRParen/*J*/= new SourceLocation();
      
      SourceRange TypeIdParens/*J*/= new SourceRange();
      DS/*J*/= new DeclSpec($this().AttrFactory);
      final Declarator DeclaratorInfo/*J*/= new Declarator(DS, Declarator.TheContext.CXXNewContext);
      /*JAVA: for finallydestroy*/$DeclaratorInfo = DeclaratorInfo;
      if ($this().Tok.is(tok.TokenKind.l_paren)) {
        BalancedDelimiterTracker T = null;
        try {
          // If it turns out to be a placement, we change the type location.
          T/*J*/= new BalancedDelimiterTracker(/*Deref*/$this(), tok.TokenKind.l_paren);
          T.consumeOpen();
          PlacementLParen.$assignMove(T.getOpenLocation());
          if ($this().ParseExpressionListOrTypeId(PlacementArgs, DeclaratorInfo)) {
            $this().SkipUntil(tok.TokenKind.semi, $bitor_SkipUntilFlags(/*KEEP_ENUM*/SkipUntilFlags.StopAtSemi, /*KEEP_ENUM*/SkipUntilFlags.StopBeforeMatch));
            return ExprError();
          }
          
          T.consumeClose();
          PlacementRParen.$assignMove(T.getCloseLocation());
          if (PlacementRParen.isInvalid()) {
            $this().SkipUntil(tok.TokenKind.semi, $bitor_SkipUntilFlags(/*KEEP_ENUM*/SkipUntilFlags.StopAtSemi, /*KEEP_ENUM*/SkipUntilFlags.StopBeforeMatch));
            return ExprError();
          }
          if (PlacementArgs.empty()) {
            // Reset the placement locations. There was no placement.
            TypeIdParens.$assignMove(T.getRange());
            PlacementLParen.$assign(PlacementRParen.$assignMove(new SourceLocation()));
          } else {
            // We still need the type.
            if ($this().Tok.is(tok.TokenKind.l_paren)) {
              BalancedDelimiterTracker _T = null;
              try {
                _T/*J*/= new BalancedDelimiterTracker(/*Deref*/$this(), tok.TokenKind.l_paren);
                _T.consumeOpen();
                $this().MaybeParseGNUAttributes(DeclaratorInfo);
                $this().ParseSpecifierQualifierList(DS);
                DeclaratorInfo.SetSourceRange(DS.getSourceRange());
                $this().ParseDeclarator(DeclaratorInfo);
                _T.consumeClose();
                TypeIdParens.$assignMove(_T.getRange());
              } finally {
                if (_T != null) { _T.$destroy(); }
              }
            } else {
              $this().MaybeParseGNUAttributes(DeclaratorInfo);
              if ($this().ParseCXXTypeSpecifierSeq(DS)) {
                DeclaratorInfo.setInvalidType(true);
              } else {
                DeclaratorInfo.SetSourceRange(DS.getSourceRange());
                $this().ParseDeclaratorInternal(DeclaratorInfo, 
                    /*AddrOf*//*FPtr*/Parser::ParseDirectNewDeclarator);
              }
            }
          }
        } finally {
          if (T != null) { T.$destroy(); }
        }
      } else {
        // A new-type-id is a simplified type-id, where essentially the
        // direct-declarator is replaced by a direct-new-declarator.
        $this().MaybeParseGNUAttributes(DeclaratorInfo);
        if ($this().ParseCXXTypeSpecifierSeq(DS)) {
          DeclaratorInfo.setInvalidType(true);
        } else {
          DeclaratorInfo.SetSourceRange(DS.getSourceRange());
          $this().ParseDeclaratorInternal(DeclaratorInfo, 
              /*AddrOf*//*FPtr*/Parser::ParseDirectNewDeclarator);
        }
      }
      if (DeclaratorInfo.isInvalidType()) {
        $this().SkipUntil(tok.TokenKind.semi, $bitor_SkipUntilFlags(/*KEEP_ENUM*/SkipUntilFlags.StopAtSemi, /*KEEP_ENUM*/SkipUntilFlags.StopBeforeMatch));
        return ExprError();
      }
      
      ActionResultTTrue<Expr /*P*/ > Initializer/*J*/= new ActionResultTTrue<Expr /*P*/ >();
      if ($this().Tok.is(tok.TokenKind.l_paren)) {
        BalancedDelimiterTracker T = null;
        try {
          SourceLocation ConstructorLParen/*J*/= new SourceLocation(), ConstructorRParen/*J*/= new SourceLocation();
          SmallVector<Expr /*P*/ > ConstructorArgs/*J*/= new SmallVector<Expr /*P*/ >(12, (Expr /*P*/ )null);
          T/*J*/= new BalancedDelimiterTracker(/*Deref*/$this(), tok.TokenKind.l_paren);
          T.consumeOpen();
          ConstructorLParen.$assignMove(T.getOpenLocation());
          if ($this().Tok.isNot(tok.TokenKind.r_paren)) {
            SmallVector<SourceLocation> CommaLocs/*J*/= new SmallVector<SourceLocation>(20, new SourceLocation());
            if ($this().ParseExpressionList(ConstructorArgs, CommaLocs, /*[&]*/()-> 
                      {
                        OpaquePtr<QualType> TypeRep = $this().Actions.ActOnTypeName($this().getCurScope(), 
                            DeclaratorInfo).get();
                        $this().Actions.CodeCompleteConstructor($this().getCurScope(), 
                            TypeRep.getQualType().$arrow().getCanonicalTypeInternal(), 
                            DeclaratorInfo.getLocEnd(), 
                            new ArrayRef<Expr /*P*/ >(ConstructorArgs));
                      }
                )) {
              $this().SkipUntil(tok.TokenKind.semi, $bitor_SkipUntilFlags(/*KEEP_ENUM*/SkipUntilFlags.StopAtSemi, /*KEEP_ENUM*/SkipUntilFlags.StopBeforeMatch));
              return ExprError();
            }
          }
          T.consumeClose();
          ConstructorRParen.$assignMove(T.getCloseLocation());
          if (ConstructorRParen.isInvalid()) {
            $this().SkipUntil(tok.TokenKind.semi, $bitor_SkipUntilFlags(/*KEEP_ENUM*/SkipUntilFlags.StopAtSemi, /*KEEP_ENUM*/SkipUntilFlags.StopBeforeMatch));
            return ExprError();
          }
          Initializer.$assignMove($this().Actions.ActOnParenListExpr(new SourceLocation(ConstructorLParen), 
                  new SourceLocation(ConstructorRParen), 
                  new MutableArrayRef<Expr /*P*/ >(ConstructorArgs)));
        } finally {
          if (T != null) { T.$destroy(); }
        }
      } else if ($this().Tok.is(tok.TokenKind.l_brace) && $this().getLangOpts().CPlusPlus11) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($c$.track($this().Diag($this().Tok.getLocation(), 
              diag.warn_cxx98_compat_generalized_initializer_lists)));
          Initializer.$assignMove($this().ParseBraceInitializer());
        } finally {
          $c$.$destroy();
        }
      }
      if (Initializer.isInvalid()) {
        return Initializer;
      }
      
      return $this().Actions.ActOnCXXNew(new SourceLocation(Start), UseGlobal, new SourceLocation(PlacementLParen), 
          new MutableArrayRef<Expr /*P*/ >(PlacementArgs), new SourceLocation(PlacementRParen), 
          new SourceRange(TypeIdParens), DeclaratorInfo, Initializer.get());
    } finally {
      if ($DeclaratorInfo != null) { $DeclaratorInfo.$destroy(); }
      if (DS != null) { DS.$destroy(); }
    }
  }


/// ParseCXXDeleteExpression - Parse a C++ delete-expression. Delete is used
/// to free memory allocated by new.
///
/// This method is called to parse the 'delete' expression after the optional
/// '::' has been already parsed.  If the '::' was present, "UseGlobal" is true
/// and "Start" is its location.  Otherwise, "Start" is the location of the
/// 'delete' token.
///
///        delete-expression:
///                   '::'[opt] 'delete' cast-expression
///                   '::'[opt] 'delete' '[' ']' cast-expression
//<editor-fold defaultstate="collapsed" desc="clang::Parser::ParseCXXDeleteExpression">
@Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseExprCXX.cpp", line = 2838,
   FQN="clang::Parser::ParseCXXDeleteExpression", NM="_ZN5clang6Parser24ParseCXXDeleteExpressionEbNS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseExprCXX.cpp -nm=_ZN5clang6Parser24ParseCXXDeleteExpressionEbNS_14SourceLocationE")
  //</editor-fold>
  protected /*private*/ ActionResultTTrue<Expr /*P*/ > ParseCXXDeleteExpression(boolean UseGlobal, SourceLocation Start) {
    assert ($this().Tok.is(tok.TokenKind.kw_delete)) : "Expected 'delete' keyword";
    $this().ConsumeToken(); // Consume 'delete'
    
    // Array delete?
    boolean ArrayDelete = false;
    if ($this().Tok.is(tok.TokenKind.l_square) && $this().NextToken().is(tok.TokenKind.r_square)) {
      BalancedDelimiterTracker T = null;
      try {
        // C++11 [expr.delete]p1:
        //   Whenever the delete keyword is followed by empty square brackets, it
        //   shall be interpreted as [array delete].
        //   [Footnote: A lambda expression with a lambda-introducer that consists
        //              of empty square brackets can follow the delete keyword if
        //              the lambda expression is enclosed in parentheses.]
        // FIXME: Produce a better diagnostic if the '[]' is unambiguously a
        //        lambda-introducer.
        ArrayDelete = true;
        T/*J*/= new BalancedDelimiterTracker(/*Deref*/$this(), tok.TokenKind.l_square);
        
        T.consumeOpen();
        T.consumeClose();
        if (T.getCloseLocation().isInvalid()) {
          return ExprError();
        }
      } finally {
        if (T != null) { T.$destroy(); }
      }
    }
    
    ActionResultTTrue<Expr /*P*/ > Operand/*J*/= $this().ParseCastExpression(false);
    if (Operand.isInvalid()) {
      return Operand;
    }
    
    return $this().Actions.ActOnCXXDelete(new SourceLocation(Start), UseGlobal, ArrayDelete, Operand.get());
  }


//===--------------------------------------------------------------------===//
// C++ if/switch/while condition expression.

/// ParseCXXCondition - if/switch/while condition expression.
///
///       condition:
///         expression
///         type-specifier-seq declarator '=' assignment-expression
/// [C++11] type-specifier-seq declarator '=' initializer-clause
/// [C++11] type-specifier-seq declarator braced-init-list
/// [GNU]   type-specifier-seq declarator simple-asm-expr[opt] attributes[opt]
///             '=' assignment-expression
///
/// In C++1z, a condition may in some contexts be preceded by an
/// optional init-statement. This function will parse that too.
///
/// \param InitStmt If non-null, an init-statement is permitted, and if present
/// will be parsed and stored here.
///
/// \param Loc The location of the start of the statement that requires this
/// condition, e.g., the "for" in a for loop.
///
/// \returns The parsed condition.
//<editor-fold defaultstate="collapsed" desc="clang::Parser::ParseCXXCondition">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseExprCXX.cpp", line = 1682,
   FQN="clang::Parser::ParseCXXCondition", NM="_ZN5clang6Parser17ParseCXXConditionEPNS_12ActionResultIPNS_4StmtELb1EEENS_14SourceLocationENS_4Sema13ConditionKindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseExprCXX.cpp -nm=_ZN5clang6Parser17ParseCXXConditionEPNS_12ActionResultIPNS_4StmtELb1EEENS_14SourceLocationENS_4Sema13ConditionKindE")
  //</editor-fold>
  protected /*private*/ Sema.ConditionResult ParseCXXCondition(ActionResultTTrue<Stmt /*P*/ > /*P*/ InitStmt, 
                   SourceLocation Loc, 
                   Sema.ConditionKind CK) {
    ParsedAttributesWithRange attrs = null;
    DeclSpec DS = null;
    Declarator DeclaratorInfo = null;
    try {
      if ($this().Tok.is(tok.TokenKind.code_completion)) {
        $this().Actions.CodeCompleteOrdinaryName($this().getCurScope(), Sema.ParserCompletionContext.PCC_Condition);
        $this().cutOffParsing();
        return Sema.ConditionError();
      }
      
      attrs/*J*/= new ParsedAttributesWithRange($this().AttrFactory);
      $this().MaybeParseCXX11Attributes(attrs);
      
      // Determine what kind of thing we have.
      switch ($this().isCXXConditionDeclarationOrInitStatement((InitStmt != null))) {
       case Expression:
        {
          $this().ProhibitAttributes(attrs);
          
          // Parse the expression.
          ActionResultTTrue<Expr /*P*/ > Expr = $this().ParseExpression(); // expression
          if (Expr.isInvalid()) {
            return Sema.ConditionError();
          }
          if ((InitStmt != null) && $this().Tok.is(tok.TokenKind.semi)) {
            /*Deref*/InitStmt.$assignMove($this().Actions.ActOnExprStmt(new ActionResultTTrue<Expr /*P*/ >(JD$T.INSTANCE, Expr.get())));
            $this().ConsumeToken();
            return $this().ParseCXXCondition((ActionResultTTrue<Stmt /*P*/ > /*P*/ )null, new SourceLocation(Loc), CK);
          }
          
          return $this().Actions.ActOnCondition($this().getCurScope(), new SourceLocation(Loc), Expr.get(), CK);
        }
       case InitStmtDecl:
        {
          SourceLocation DeclStart = $this().Tok.getLocation(), DeclEnd/*J*/= new SourceLocation();
          OpaquePtr<DeclGroupRef> DG = $this().ParseSimpleDeclaration(Declarator.TheContext.InitStmtContext.getValue(), DeclEnd, attrs, /*RequireSemi=*/ true);
          /*Deref*/InitStmt.$assignMove($this().Actions.ActOnDeclStmt(new OpaquePtr<DeclGroupRef>(DG), new SourceLocation(DeclStart), new SourceLocation(DeclEnd)));
          return $this().ParseCXXCondition((ActionResultTTrue<Stmt /*P*/ > /*P*/ )null, new SourceLocation(Loc), CK);
        }
       case ConditionDecl:
       case Error:
        break;
      }
      
      // type-specifier-seq
      DS/*J*/= new DeclSpec($this().AttrFactory);
      DS.takeAttributesFrom(attrs);
      $this().ParseSpecifierQualifierList(DS, AccessSpecifier.AS_none, DeclSpecContext.DSC_condition);
      
      // declarator
      DeclaratorInfo/*J*/= new Declarator(DS, Declarator.TheContext.ConditionContext);
      $this().ParseDeclarator(DeclaratorInfo);
      
      // simple-asm-expr[opt]
      if ($this().Tok.is(tok.TokenKind.kw_asm)) {
        SourceLocation _Loc/*J*/= new SourceLocation();
        ActionResultTTrue<Expr /*P*/ > AsmLabel/*J*/= $this().ParseSimpleAsm($AddrOf(_Loc));
        if (AsmLabel.isInvalid()) {
          $this().SkipUntil(tok.TokenKind.semi, SkipUntilFlags.StopAtSemi);
          return Sema.ConditionError();
        }
        DeclaratorInfo.setAsmLabel(AsmLabel.get());
        DeclaratorInfo.SetRangeEnd(new SourceLocation(_Loc));
      }
      
      // If attributes are present, parse them.
      $this().MaybeParseGNUAttributes(DeclaratorInfo);
      
      // Type-check the declaration itself.
      ActionResult<Decl /*P*/ > Dcl = $this().Actions.ActOnCXXConditionDeclaration($this().getCurScope(), 
          DeclaratorInfo);
      if (Dcl.isInvalid()) {
        return Sema.ConditionError();
      }
      Decl /*P*/ DeclOut = Dcl.get();
      
      // '=' assignment-expression
      // If a '==' or '+=' is found, suggest a fixit to '='.
      boolean CopyInitialization = $this().isTokenEqualOrEqualTypo();
      if (CopyInitialization) {
        $this().ConsumeToken();
      }
      
      ActionResultTTrue<Expr /*P*/ > InitExpr = ExprError();
      if ($this().getLangOpts().CPlusPlus11 && $this().Tok.is(tok.TokenKind.l_brace)) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($c$.track($this().Diag($this().Tok.getLocation(), 
              diag.warn_cxx98_compat_generalized_initializer_lists)));
          InitExpr.$assignMove($this().ParseBraceInitializer());
        } finally {
          $c$.$destroy();
        }
      } else if (CopyInitialization) {
        InitExpr.$assignMove($this().ParseAssignmentExpression());
      } else if ($this().Tok.is(tok.TokenKind.l_paren)) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          // This was probably an attempt to initialize the variable.
          SourceLocation LParen = $this().ConsumeParen(), RParen = new SourceLocation(LParen);
          if ($this().SkipUntil(tok.TokenKind.r_paren, $bitor_SkipUntilFlags(/*KEEP_ENUM*/SkipUntilFlags.StopAtSemi, /*KEEP_ENUM*/SkipUntilFlags.StopBeforeMatch))) {
            RParen.$assignMove($this().ConsumeParen());
          }
          $c$.clean($out_DiagnosticBuilder$C_SourceRange($c$.track($this().Diag(DeclOut.getLocation(), 
                  diag.err_expected_init_in_condition_lparen)), 
              new SourceRange(/*NO_COPY*/LParen, /*NO_COPY*/RParen)));
        } finally {
          $c$.$destroy();
        }
      } else {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($c$.track($this().Diag(DeclOut.getLocation(), diag.err_expected_init_in_condition)));
        } finally {
          $c$.$destroy();
        }
      }
      if (!InitExpr.isInvalid()) {
        $this().Actions.AddInitializerToDecl(DeclOut, InitExpr.get(), !CopyInitialization, 
            DS.containsPlaceholderType());
      } else {
        $this().Actions.ActOnInitializerError(DeclOut);
      }
      
      $this().Actions.FinalizeDeclaration(DeclOut);
      return $this().Actions.ActOnConditionVariable(DeclOut, new SourceLocation(Loc), CK);
    } finally {
      if (DeclaratorInfo != null) { DeclaratorInfo.$destroy(); }
      if (DS != null) { DS.$destroy(); }
      if (attrs != null) { attrs.$destroy(); }
    }
  }


//===--------------------------------------------------------------------===//
// C++ Coroutines

/// \brief Parse the C++ Coroutines co_yield expression.
///
///       co_yield-expression:
///         'co_yield' assignment-expression[opt]
//<editor-fold defaultstate="collapsed" desc="clang::Parser::ParseCoyieldExpression">
@Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseExprCXX.cpp", line = 1578,
   FQN="clang::Parser::ParseCoyieldExpression", NM="_ZN5clang6Parser22ParseCoyieldExpressionEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseExprCXX.cpp -nm=_ZN5clang6Parser22ParseCoyieldExpressionEv")
  //</editor-fold>
  protected /*private*/ ActionResultTTrue<Expr /*P*/ > ParseCoyieldExpression() {
    assert ($this().Tok.is(tok.TokenKind.kw_co_yield)) : "Not co_yield!";
    
    SourceLocation Loc = $this().ConsumeToken();
    ActionResultTTrue<Expr /*P*/ > Expr = $this().Tok.is(tok.TokenKind.l_brace) ? $this().ParseBraceInitializer() : $this().ParseAssignmentExpression();
    if (!Expr.isInvalid()) {
      Expr.$assignMove($this().Actions.ActOnCoyieldExpr($this().getCurScope(), new SourceLocation(Loc), Expr.get()));
    }
    return Expr;
  }


/// \brief Finish parsing a C++ unqualified-id that is a template-id of
/// some form. 
///
/// This routine is invoked when a '<' is encountered after an identifier or
/// operator-function-id is parsed by \c ParseUnqualifiedId() to determine
/// whether the unqualified-id is actually a template-id. This routine will
/// then parse the template arguments and form the appropriate template-id to
/// return to the caller.
///
/// \param SS the nested-name-specifier that precedes this template-id, if
/// we're actually parsing a qualified-id.
///
/// \param Name for constructor and destructor names, this is the actual
/// identifier that may be a template-name.
///
/// \param NameLoc the location of the class-name in a constructor or 
/// destructor.
///
/// \param EnteringContext whether we're entering the scope of the 
/// nested-name-specifier.
///
/// \param ObjectType if this unqualified-id occurs within a member access
/// expression, the type of the base object whose member is being accessed.
///
/// \param Id as input, describes the template-name or operator-function-id
/// that precedes the '<'. If template arguments were parsed successfully,
/// will be updated with the template-id.
/// 
/// \param AssumeTemplateId When true, this routine will assume that the name
/// refers to a template without performing name lookup to verify. 
///
/// \returns true if a parse error occurred, false otherwise.
//<editor-fold defaultstate="collapsed" desc="clang::Parser::ParseUnqualifiedIdTemplateId">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseExprCXX.cpp", line = 1968,
   FQN="clang::Parser::ParseUnqualifiedIdTemplateId", NM="_ZN5clang6Parser28ParseUnqualifiedIdTemplateIdERNS_12CXXScopeSpecENS_14SourceLocationEPNS_14IdentifierInfoES3_bNS_9OpaquePtrINS_8QualTypeEEERNS_13UnqualifiedIdEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseExprCXX.cpp -nm=_ZN5clang6Parser28ParseUnqualifiedIdTemplateIdERNS_12CXXScopeSpecENS_14SourceLocationEPNS_14IdentifierInfoES3_bNS_9OpaquePtrINS_8QualTypeEEERNS_13UnqualifiedIdEb")
  //</editor-fold>
  protected /*private*/ boolean ParseUnqualifiedIdTemplateId(final CXXScopeSpec /*&*/ SS, 
                              SourceLocation TemplateKWLoc, 
                              IdentifierInfo /*P*/ Name, 
                              SourceLocation NameLoc, 
                              boolean EnteringContext, 
                              OpaquePtr<QualType> ObjectType, 
                              final UnqualifiedId /*&*/ Id, 
                              boolean AssumeTemplateId) {
    SmallVector<ParsedTemplateArgument> TemplateArgs = null;
    try {
      assert ((AssumeTemplateId || $this().Tok.is(tok.TokenKind.less))) : "Expected '<' to finish parsing a template-id";
      
      OpaquePtr<TemplateName> Template/*J*/= new OpaquePtr<TemplateName>();
      TemplateNameKind TNK = TemplateNameKind.TNK_Non_template;
      switch (Id.getKind()) {
       case IK_Identifier:
       case IK_OperatorFunctionId:
       case IK_LiteralOperatorId:
        if (AssumeTemplateId) {
          TNK = $this().Actions.ActOnDependentTemplateName($this().getCurScope(), SS, new SourceLocation(TemplateKWLoc), 
              Id, new OpaquePtr<QualType>(ObjectType), EnteringContext, 
              Template);
          if (TNK == TemplateNameKind.TNK_Non_template) {
            return true;
          }
        } else {
          bool$ref MemberOfUnknownSpecialization = create_bool$ref();
          TNK = $this().Actions.isTemplateName($this().getCurScope(), SS, 
              TemplateKWLoc.isValid(), Id, 
              new OpaquePtr<QualType>(ObjectType), EnteringContext, Template, 
              MemberOfUnknownSpecialization);
          if (TNK == TemplateNameKind.TNK_Non_template && MemberOfUnknownSpecialization.$deref()
             && ObjectType.$bool() && $this().IsTemplateArgumentList()) {
            JavaCleaner $c$ = $createJavaCleaner();
            try {
              // We have something like t->getAs<T>(), where getAs is a 
              // member of an unknown specialization. However, this will only
              // parse correctly as a template, so suggest the keyword 'template'
              // before 'getAs' and treat this as a dependent template name.
              std.string _Name/*J*/= new std.string();
              if (Id.getKind() == UnqualifiedId.IdKind.IK_Identifier) {
                _Name.$assignMove(Id.Unnamed_field1.Identifier.getName().$string());
              } else {
                _Name.$assign_T$C$P(/*KEEP_STR*/"operator ");
                if (Id.getKind() == UnqualifiedId.IdKind.IK_OperatorFunctionId) {
                  _Name.$addassign_T$C$P(getOperatorSpelling(Id.Unnamed_field1.OperatorFunctionId.Operator));
                } else {
                  $addassign_string_StringRef(_Name, Id.Unnamed_field1.Identifier.getName());
                }
              }
              $c$.clean($out_DiagnosticBuilder$C_FixItHint$C($out_DiagnosticBuilder$C_StringRef($c$.track($this().Diag(new SourceLocation(Id.StartLocation), diag.err_missing_dependent_template_keyword)), 
                      new StringRef(_Name)), 
                  FixItHint.CreateInsertion(/*NO_COPY*/Id.StartLocation, new StringRef(/*KEEP_STR*/"template "))));
              TNK = $this().Actions.ActOnDependentTemplateName($this().getCurScope(), 
                  SS, new SourceLocation(TemplateKWLoc), Id, 
                  new OpaquePtr<QualType>(ObjectType), EnteringContext, 
                  Template);
              if (TNK == TemplateNameKind.TNK_Non_template) {
                return true;
              }
            } finally {
              $c$.$destroy();
            }
          }
        }
        break;
       case IK_ConstructorName:
        {
          UnqualifiedId TemplateName/*J*/= new UnqualifiedId();
          bool$ref MemberOfUnknownSpecialization = create_bool$ref();
          TemplateName.setIdentifier(Name, new SourceLocation(NameLoc));
          TNK = $this().Actions.isTemplateName($this().getCurScope(), SS, TemplateKWLoc.isValid(), 
              TemplateName, new OpaquePtr<QualType>(ObjectType), 
              EnteringContext, Template, 
              MemberOfUnknownSpecialization);
          break;
        }
       case IK_DestructorName:
        {
          UnqualifiedId TemplateName/*J*/= new UnqualifiedId();
          bool$ref MemberOfUnknownSpecialization = create_bool$ref();
          TemplateName.setIdentifier(Name, new SourceLocation(NameLoc));
          if (ObjectType.$bool()) {
            TNK = $this().Actions.ActOnDependentTemplateName($this().getCurScope(), 
                SS, new SourceLocation(TemplateKWLoc), TemplateName, 
                new OpaquePtr<QualType>(ObjectType), EnteringContext, 
                Template);
            if (TNK == TemplateNameKind.TNK_Non_template) {
              return true;
            }
          } else {
            TNK = $this().Actions.isTemplateName($this().getCurScope(), SS, TemplateKWLoc.isValid(), 
                TemplateName, new OpaquePtr<QualType>(ObjectType), 
                EnteringContext, Template, 
                MemberOfUnknownSpecialization);
            if (TNK == TemplateNameKind.TNK_Non_template && !Id.Unnamed_field1.DestructorName.get().$bool()) {
              JavaCleaner $c$ = $createJavaCleaner();
              try {
                $c$.clean($out_DiagnosticBuilder$C_SourceRange($out_DiagnosticBuilder$C_IdentifierInfo$C$P($c$.track($this().Diag(new SourceLocation(NameLoc), diag.err_destructor_template_id)), 
                        Name), SS.getRange()));
                return true;
              } finally {
                $c$.$destroy();
              }
            }
          }
          break;
        }
       default:
        return false;
      }
      if (TNK == TemplateNameKind.TNK_Non_template) {
        return false;
      }
      
      // Parse the enclosed template argument list.
      SourceLocation LAngleLoc/*J*/= new SourceLocation(), RAngleLoc/*J*/= new SourceLocation();
      TemplateArgs/*J*/= new SmallVector<ParsedTemplateArgument>(16, new ParsedTemplateArgument());
      if ($this().Tok.is(tok.TokenKind.less)
         && $this().ParseTemplateIdAfterTemplateName(new OpaquePtr<TemplateName>(Template), new SourceLocation(Id.StartLocation), 
          SS, true, LAngleLoc, 
          TemplateArgs, 
          RAngleLoc)) {
        return true;
      }
      if (Id.getKind() == UnqualifiedId.IdKind.IK_Identifier
         || Id.getKind() == UnqualifiedId.IdKind.IK_OperatorFunctionId
         || Id.getKind() == UnqualifiedId.IdKind.IK_LiteralOperatorId) {
        // Form a parsed representation of the template-id to be stored in the
        // UnqualifiedId.
        TemplateIdAnnotation /*P*/ TemplateId = TemplateIdAnnotation.Allocate(TemplateArgs.size(), $this().TemplateIds);
        
        // FIXME: Store name for literal operator too.
        if (Id.getKind() == UnqualifiedId.IdKind.IK_Identifier) {
          TemplateId.Name = Id.Unnamed_field1.Identifier;
          TemplateId.Operator = OverloadedOperatorKind.OO_None;
          TemplateId.TemplateNameLoc.$assign(Id.StartLocation);
        } else {
          TemplateId.Name = null;
          TemplateId.Operator = Id.Unnamed_field1.OperatorFunctionId.Operator;
          TemplateId.TemplateNameLoc.$assign(Id.StartLocation);
        }
        
        TemplateId.SS.$assign(SS);
        TemplateId.TemplateKWLoc.$assign(TemplateKWLoc);
        TemplateId.Template.$assign(Template);
        TemplateId.Kind = TNK;
        TemplateId.LAngleLoc.$assign(LAngleLoc);
        TemplateId.RAngleLoc.$assign(RAngleLoc);
        type$ptr<ParsedTemplateArgument> /*P*/ Args = TemplateId.getTemplateArgs();
        for (/*uint*/int Arg = 0, ArgEnd = TemplateArgs.size();
             Arg != ArgEnd; ++Arg)  {
          Args.$at(Arg).$assign(TemplateArgs.$at(Arg));
        }
        
        Id.setTemplateId(TemplateId);
        return false;
      }
      
      // Bundle the template arguments together.
      MutableArrayRef<ParsedTemplateArgument> TemplateArgsPtr/*J*/= new MutableArrayRef<ParsedTemplateArgument>(TemplateArgs);
      
      // Constructor and destructor names.
      ActionResult<OpaquePtr<QualType> > Type = $this().Actions.ActOnTemplateIdType(SS, new SourceLocation(TemplateKWLoc), 
          new OpaquePtr<TemplateName>(Template), new SourceLocation(NameLoc), 
          new SourceLocation(LAngleLoc), new MutableArrayRef<ParsedTemplateArgument>(TemplateArgsPtr), new SourceLocation(RAngleLoc), 
          /*IsCtorOrDtorName=*/ true);
      if (Type.isInvalid()) {
        return true;
      }
      if (Id.getKind() == UnqualifiedId.IdKind.IK_ConstructorName) {
        Id.setConstructorName(Type.get(), new SourceLocation(NameLoc), new SourceLocation(RAngleLoc));
      } else {
        Id.setDestructorName(new SourceLocation(Id.StartLocation), Type.get(), new SourceLocation(RAngleLoc));
      }
      
      return false;
    } finally {
      if (TemplateArgs != null) { TemplateArgs.$destroy(); }
    }
  }


/// \brief Parse an operator-function-id or conversion-function-id as part
/// of a C++ unqualified-id.
///
/// This routine is responsible only for parsing the operator-function-id or
/// conversion-function-id; it does not handle template arguments in any way.
///
/// \code
///       operator-function-id: [C++ 13.5]
///         'operator' operator
///
///       operator: one of
///            new   delete  new[]   delete[]
///            +     -    *  /    %  ^    &   |   ~
///            !     =    <  >    += -=   *=  /=  %=
///            ^=    &=   |= <<   >> >>= <<=  ==  !=
///            <=    >=   && ||   ++ --   ,   ->* ->
///            ()    []
///
///       conversion-function-id: [C++ 12.3.2]
///         operator conversion-type-id
///
///       conversion-type-id:
///         type-specifier-seq conversion-declarator[opt]
///
///       conversion-declarator:
///         ptr-operator conversion-declarator[opt]
/// \endcode
///
/// \param SS The nested-name-specifier that preceded this unqualified-id. If
/// non-empty, then we are parsing the unqualified-id of a qualified-id.
///
/// \param EnteringContext whether we are entering the scope of the 
/// nested-name-specifier.
///
/// \param ObjectType if this unqualified-id occurs within a member access
/// expression, the type of the base object whose member is being accessed.
///
/// \param Result on a successful parse, contains the parsed unqualified-id.
///
/// \returns true if parsing fails, false otherwise.
//<editor-fold defaultstate="collapsed" desc="clang::Parser::ParseUnqualifiedIdOperator">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseExprCXX.cpp", line = 2175,
   FQN="clang::Parser::ParseUnqualifiedIdOperator", NM="_ZN5clang6Parser26ParseUnqualifiedIdOperatorERNS_12CXXScopeSpecEbNS_9OpaquePtrINS_8QualTypeEEERNS_13UnqualifiedIdE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseExprCXX.cpp -nm=_ZN5clang6Parser26ParseUnqualifiedIdOperatorERNS_12CXXScopeSpecEbNS_9OpaquePtrINS_8QualTypeEEERNS_13UnqualifiedIdE")
  //</editor-fold>
  protected /*private*/ boolean ParseUnqualifiedIdOperator(final CXXScopeSpec /*&*/ SS, boolean EnteringContext, 
                            OpaquePtr<QualType> ObjectType, 
                            final UnqualifiedId /*&*/ Result) {
    DeclSpec DS = null;
    Declarator D = null;
    try {
      assert ($this().Tok.is(tok.TokenKind.kw_operator)) : "Expected 'operator' keyword";
      
      // Consume the 'operator' keyword.
      SourceLocation KeywordLoc = $this().ConsumeToken();
      
      // Determine what kind of operator name we have.
      /*uint*/int SymbolIdx = 0;
      SourceLocation SymbolLocations[/*3*/]/*J*/= new$T(new SourceLocation [3], ()->new SourceLocation());
      OverloadedOperatorKind Op = OverloadedOperatorKind.OO_None;
      switch ($this().Tok.getKind()) {
       case tok.TokenKind.kw_new:
       case tok.TokenKind.kw_delete:
        {
          boolean isNew = $this().Tok.getKind() == tok.TokenKind.kw_new;
          // Consume the 'new' or 'delete'.
          SymbolLocations[SymbolIdx++].$assignMove($this().ConsumeToken());
          // Check for array new/delete.
          if ($this().Tok.is(tok.TokenKind.l_square)
             && (!$this().getLangOpts().CPlusPlus11 || $this().NextToken().isNot(tok.TokenKind.l_square))) {
            BalancedDelimiterTracker T = null;
            try {
              // Consume the '[' and ']'.
              T/*J*/= new BalancedDelimiterTracker(/*Deref*/$this(), tok.TokenKind.l_square);
              T.consumeOpen();
              T.consumeClose();
              if (T.getCloseLocation().isInvalid()) {
                return true;
              }
              
              SymbolLocations[SymbolIdx++].$assignMove(T.getOpenLocation());
              SymbolLocations[SymbolIdx++].$assignMove(T.getCloseLocation());
              Op = isNew ? OverloadedOperatorKind.OO_Array_New : OverloadedOperatorKind.OO_Array_Delete;
            } finally {
              if (T != null) { T.$destroy(); }
            }
          } else {
            Op = isNew ? OverloadedOperatorKind.OO_New : OverloadedOperatorKind.OO_Delete;
          }
          break;
        }
       case tok.TokenKind.plus:
        SymbolLocations[SymbolIdx++].$assignMove($this().ConsumeToken());
        Op = OverloadedOperatorKind.OO_Plus;
        break;
       case tok.TokenKind.minus:
        SymbolLocations[SymbolIdx++].$assignMove($this().ConsumeToken());
        Op = OverloadedOperatorKind.OO_Minus;
        break;
       case tok.TokenKind.star:
        SymbolLocations[SymbolIdx++].$assignMove($this().ConsumeToken());
        Op = OverloadedOperatorKind.OO_Star;
        break;
       case tok.TokenKind.slash:
        SymbolLocations[SymbolIdx++].$assignMove($this().ConsumeToken());
        Op = OverloadedOperatorKind.OO_Slash;
        break;
       case tok.TokenKind.percent:
        SymbolLocations[SymbolIdx++].$assignMove($this().ConsumeToken());
        Op = OverloadedOperatorKind.OO_Percent;
        break;
       case tok.TokenKind.caret:
        SymbolLocations[SymbolIdx++].$assignMove($this().ConsumeToken());
        Op = OverloadedOperatorKind.OO_Caret;
        break;
       case tok.TokenKind.amp:
        SymbolLocations[SymbolIdx++].$assignMove($this().ConsumeToken());
        Op = OverloadedOperatorKind.OO_Amp;
        break;
       case tok.TokenKind.pipe:
        SymbolLocations[SymbolIdx++].$assignMove($this().ConsumeToken());
        Op = OverloadedOperatorKind.OO_Pipe;
        break;
       case tok.TokenKind.tilde:
        SymbolLocations[SymbolIdx++].$assignMove($this().ConsumeToken());
        Op = OverloadedOperatorKind.OO_Tilde;
        break;
       case tok.TokenKind.exclaim:
        SymbolLocations[SymbolIdx++].$assignMove($this().ConsumeToken());
        Op = OverloadedOperatorKind.OO_Exclaim;
        break;
       case tok.TokenKind.equal:
        SymbolLocations[SymbolIdx++].$assignMove($this().ConsumeToken());
        Op = OverloadedOperatorKind.OO_Equal;
        break;
       case tok.TokenKind.less:
        SymbolLocations[SymbolIdx++].$assignMove($this().ConsumeToken());
        Op = OverloadedOperatorKind.OO_Less;
        break;
       case tok.TokenKind.greater:
        SymbolLocations[SymbolIdx++].$assignMove($this().ConsumeToken());
        Op = OverloadedOperatorKind.OO_Greater;
        break;
       case tok.TokenKind.plusequal:
        SymbolLocations[SymbolIdx++].$assignMove($this().ConsumeToken());
        Op = OverloadedOperatorKind.OO_PlusEqual;
        break;
       case tok.TokenKind.minusequal:
        SymbolLocations[SymbolIdx++].$assignMove($this().ConsumeToken());
        Op = OverloadedOperatorKind.OO_MinusEqual;
        break;
       case tok.TokenKind.starequal:
        SymbolLocations[SymbolIdx++].$assignMove($this().ConsumeToken());
        Op = OverloadedOperatorKind.OO_StarEqual;
        break;
       case tok.TokenKind.slashequal:
        SymbolLocations[SymbolIdx++].$assignMove($this().ConsumeToken());
        Op = OverloadedOperatorKind.OO_SlashEqual;
        break;
       case tok.TokenKind.percentequal:
        SymbolLocations[SymbolIdx++].$assignMove($this().ConsumeToken());
        Op = OverloadedOperatorKind.OO_PercentEqual;
        break;
       case tok.TokenKind.caretequal:
        SymbolLocations[SymbolIdx++].$assignMove($this().ConsumeToken());
        Op = OverloadedOperatorKind.OO_CaretEqual;
        break;
       case tok.TokenKind.ampequal:
        SymbolLocations[SymbolIdx++].$assignMove($this().ConsumeToken());
        Op = OverloadedOperatorKind.OO_AmpEqual;
        break;
       case tok.TokenKind.pipeequal:
        SymbolLocations[SymbolIdx++].$assignMove($this().ConsumeToken());
        Op = OverloadedOperatorKind.OO_PipeEqual;
        break;
       case tok.TokenKind.lessless:
        SymbolLocations[SymbolIdx++].$assignMove($this().ConsumeToken());
        Op = OverloadedOperatorKind.OO_LessLess;
        break;
       case tok.TokenKind.greatergreater:
        SymbolLocations[SymbolIdx++].$assignMove($this().ConsumeToken());
        Op = OverloadedOperatorKind.OO_GreaterGreater;
        break;
       case tok.TokenKind.lesslessequal:
        SymbolLocations[SymbolIdx++].$assignMove($this().ConsumeToken());
        Op = OverloadedOperatorKind.OO_LessLessEqual;
        break;
       case tok.TokenKind.greatergreaterequal:
        SymbolLocations[SymbolIdx++].$assignMove($this().ConsumeToken());
        Op = OverloadedOperatorKind.OO_GreaterGreaterEqual;
        break;
       case tok.TokenKind.equalequal:
        SymbolLocations[SymbolIdx++].$assignMove($this().ConsumeToken());
        Op = OverloadedOperatorKind.OO_EqualEqual;
        break;
       case tok.TokenKind.exclaimequal:
        SymbolLocations[SymbolIdx++].$assignMove($this().ConsumeToken());
        Op = OverloadedOperatorKind.OO_ExclaimEqual;
        break;
       case tok.TokenKind.lessequal:
        SymbolLocations[SymbolIdx++].$assignMove($this().ConsumeToken());
        Op = OverloadedOperatorKind.OO_LessEqual;
        break;
       case tok.TokenKind.greaterequal:
        SymbolLocations[SymbolIdx++].$assignMove($this().ConsumeToken());
        Op = OverloadedOperatorKind.OO_GreaterEqual;
        break;
       case tok.TokenKind.ampamp:
        SymbolLocations[SymbolIdx++].$assignMove($this().ConsumeToken());
        Op = OverloadedOperatorKind.OO_AmpAmp;
        break;
       case tok.TokenKind.pipepipe:
        SymbolLocations[SymbolIdx++].$assignMove($this().ConsumeToken());
        Op = OverloadedOperatorKind.OO_PipePipe;
        break;
       case tok.TokenKind.plusplus:
        SymbolLocations[SymbolIdx++].$assignMove($this().ConsumeToken());
        Op = OverloadedOperatorKind.OO_PlusPlus;
        break;
       case tok.TokenKind.minusminus:
        SymbolLocations[SymbolIdx++].$assignMove($this().ConsumeToken());
        Op = OverloadedOperatorKind.OO_MinusMinus;
        break;
       case tok.TokenKind.comma:
        SymbolLocations[SymbolIdx++].$assignMove($this().ConsumeToken());
        Op = OverloadedOperatorKind.OO_Comma;
        break;
       case tok.TokenKind.arrowstar:
        SymbolLocations[SymbolIdx++].$assignMove($this().ConsumeToken());
        Op = OverloadedOperatorKind.OO_ArrowStar;
        break;
       case tok.TokenKind.arrow:
        SymbolLocations[SymbolIdx++].$assignMove($this().ConsumeToken());
        Op = OverloadedOperatorKind.OO_Arrow;
        break;
       case tok.TokenKind.kw_co_await:
        SymbolLocations[SymbolIdx++].$assignMove($this().ConsumeToken());
        Op = OverloadedOperatorKind.OO_Coawait;
        break;
       case tok.TokenKind.l_paren:
        {
          BalancedDelimiterTracker T = null;
          try {
            // Consume the '(' and ')'.
            T/*J*/= new BalancedDelimiterTracker(/*Deref*/$this(), tok.TokenKind.l_paren);
            T.consumeOpen();
            T.consumeClose();
            if (T.getCloseLocation().isInvalid()) {
              return true;
            }
            
            SymbolLocations[SymbolIdx++].$assignMove(T.getOpenLocation());
            SymbolLocations[SymbolIdx++].$assignMove(T.getCloseLocation());
            Op = OverloadedOperatorKind.OO_Call;
            break;
          } finally {
            if (T != null) { T.$destroy(); }
          }
        }
       case tok.TokenKind.l_square:
        {
          BalancedDelimiterTracker T = null;
          try {
            // Consume the '[' and ']'.
            T/*J*/= new BalancedDelimiterTracker(/*Deref*/$this(), tok.TokenKind.l_square);
            T.consumeOpen();
            T.consumeClose();
            if (T.getCloseLocation().isInvalid()) {
              return true;
            }
            
            SymbolLocations[SymbolIdx++].$assignMove(T.getOpenLocation());
            SymbolLocations[SymbolIdx++].$assignMove(T.getCloseLocation());
            Op = OverloadedOperatorKind.OO_Subscript;
            break;
          } finally {
            if (T != null) { T.$destroy(); }
          }
        }
       case tok.TokenKind.code_completion:
        {
          // Code completion for the operator name.
          $this().Actions.CodeCompleteOperatorName($this().getCurScope());
          $this().cutOffParsing();
          // Don't try to parse any further.
          return true;
        }
       default:
        break;
      }
      if (Op != OverloadedOperatorKind.OO_None) {
        // We have parsed an operator-function-id.
        Result.setOperatorFunctionId(new SourceLocation(KeywordLoc), Op, SymbolLocations);
        return false;
      }
      
      // Parse a literal-operator-id.
      //
      //   literal-operator-id: C++11 [over.literal]
      //     operator string-literal identifier
      //     operator user-defined-string-literal
      if ($this().getLangOpts().CPlusPlus11 && $this().isTokenStringLiteral()) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($c$.track($this().Diag($this().Tok.getLocation(), diag.warn_cxx98_compat_literal_operator)));
          
          SourceLocation DiagLoc/*J*/= new SourceLocation();
          /*uint*/int DiagId = 0;
          
          // We're past translation phase 6, so perform string literal concatenation
          // before checking for "".
          SmallVectorToken Toks/*J*/= new SmallVectorToken(4, /*new Token()*/(Token)null);
          SmallVector<SourceLocation> TokLocs/*J*/= new SmallVector<SourceLocation>(4, new SourceLocation());
          while ($this().isTokenStringLiteral()) {
            if (!$this().Tok.is(tok.TokenKind.string_literal) && !(DiagId != 0)) {
              // C++11 [over.literal]p1:
              //   The string-literal or user-defined-string-literal in a
              //   literal-operator-id shall have no encoding-prefix [...].
              DiagLoc.$assignMove($this().Tok.getLocation());
              DiagId = diag.err_literal_operator_string_prefix;
            }
            Toks.push_back($this().Tok);
            TokLocs.push_back($this().ConsumeStringToken());
          }
          
          StringLiteralParser Literal/*J*/= new StringLiteralParser(new ArrayRefToken(Toks), $this().PP);
          if (Literal.hadError()) {
            return true;
          }
          
          // Grab the literal operator's suffix, which will be either the next token
          // or a ud-suffix from the string literal.
          IdentifierInfo /*P*/ II = null;
          SourceLocation SuffixLoc/*J*/= new SourceLocation();
          if (!Literal.getUDSuffix().empty()) {
            II = $AddrOf($this().PP.getIdentifierTable().get(Literal.$getUDSuffix()));
            SuffixLoc.$assignMove(
                Lexer.AdvanceToTokenCharacter(/*NO_COPY*/TokLocs.$at(Literal.getUDSuffixToken()), 
                    Literal.getUDSuffixOffset(), 
                    $this().PP.getSourceManager(), $this().getLangOpts())
            );
          } else if ($this().Tok.is(tok.TokenKind.identifier)) {
            II = $this().Tok.getIdentifierInfo();
            SuffixLoc.$assignMove($this().ConsumeToken());
            TokLocs.push_back(SuffixLoc);
          } else {
            $c$.clean($out_DiagnosticBuilder$C_TokenKind($c$.track($this().Diag($this().Tok.getLocation(), diag.err_expected)), tok.TokenKind.identifier));
            return true;
          }
          
          // The string literal must be empty.
          if (!Literal.GetString().empty() || Literal.Pascal) {
            // C++11 [over.literal]p1:
            //   The string-literal or user-defined-string-literal in a
            //   literal-operator-id shall [...] contain no characters
            //   other than the implicit terminating '\0'.
            DiagLoc.$assign(TokLocs.front());
            DiagId = diag.err_literal_operator_string_not_empty;
          }
          if ((DiagId != 0)) {
            // This isn't a valid literal-operator-id, but we think we know
            // what the user meant. Tell them what they should have written.
            SmallString/*32*/ Str/*J*/= new SmallString/*32*/(32);
            Str.$addassign(/*STRINGREF_STR*/"\"\"");
            Str.$addassign(II.getName());
            $c$.clean($out_DiagnosticBuilder$C_FixItHint$C($c$.track($this().Diag(new SourceLocation(DiagLoc), DiagId)), FixItHint.CreateReplacement(new SourceRange(/*NO_COPY*/TokLocs.front(), /*NO_COPY*/TokLocs.back()), Str.$StringRef())));
          }
          
          Result.setLiteralOperatorId(II, new SourceLocation(KeywordLoc), new SourceLocation(SuffixLoc));
          
          return $this().Actions.checkLiteralOperatorId(SS, Result);
        } finally {
          $c$.$destroy();
        }
      }
      
      // Parse a conversion-function-id.
      //
      //   conversion-function-id: [C++ 12.3.2]
      //     operator conversion-type-id
      //
      //   conversion-type-id:
      //     type-specifier-seq conversion-declarator[opt]
      //
      //   conversion-declarator:
      //     ptr-operator conversion-declarator[opt]
      
      // Parse the type-specifier-seq.
      DS/*J*/= new DeclSpec($this().AttrFactory);
      if ($this().ParseCXXTypeSpecifierSeq(DS)) { // FIXME: ObjectType?
        return true;
      }
      
      // Parse the conversion-declarator, which is merely a sequence of
      // ptr-operators.
      D/*J*/= new Declarator(DS, Declarator.TheContext.ConversionIdContext);
      $this().ParseDeclaratorInternal(D, /*DirectDeclParser=*/ (Parser$Declarator2Void)null);
      
      // Finish up the type.
      ActionResult<OpaquePtr<QualType> > Ty = $this().Actions.ActOnTypeName($this().getCurScope(), D);
      if (Ty.isInvalid()) {
        return true;
      }
      
      // Note that this is a conversion-function-id.
      Result.setConversionFunctionId(new SourceLocation(KeywordLoc), Ty.get(), 
          D.getSourceRange().getEnd());
      return false;
    } finally {
      if (D != null) { D.$destroy(); }
      if (DS != null) { DS.$destroy(); }
    }
  }


/// \brief Parse a C++ unqualified-id (or a C identifier), which describes the
/// name of an entity.
///
/// \code
///       unqualified-id: [C++ expr.prim.general]
///         identifier
///         operator-function-id
///         conversion-function-id
/// [C++0x] literal-operator-id [TODO]
///         ~ class-name
///         template-id
///
/// \endcode
///
/// \param SS The nested-name-specifier that preceded this unqualified-id. If
/// non-empty, then we are parsing the unqualified-id of a qualified-id.
///
/// \param EnteringContext whether we are entering the scope of the 
/// nested-name-specifier.
///
/// \param AllowDestructorName whether we allow parsing of a destructor name.
///
/// \param AllowConstructorName whether we allow parsing a constructor name.
///
/// \param ObjectType if this unqualified-id occurs within a member access
/// expression, the type of the base object whose member is being accessed.
///
/// \param Result on a successful parse, contains the parsed unqualified-id.
///
/// \returns true if parsing fails, false otherwise.
//<editor-fold defaultstate="collapsed" desc="clang::Parser::ParseUnqualifiedId">
@Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseExprCXX.cpp", line = 2404,
   FQN="clang::Parser::ParseUnqualifiedId", NM="_ZN5clang6Parser18ParseUnqualifiedIdERNS_12CXXScopeSpecEbbbNS_9OpaquePtrINS_8QualTypeEEERNS_14SourceLocationERNS_13UnqualifiedIdE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseExprCXX.cpp -nm=_ZN5clang6Parser18ParseUnqualifiedIdERNS_12CXXScopeSpecEbbbNS_9OpaquePtrINS_8QualTypeEEERNS_14SourceLocationERNS_13UnqualifiedIdE")
  //</editor-fold>
  public boolean ParseUnqualifiedId(final CXXScopeSpec /*&*/ SS, boolean EnteringContext, 
                    boolean AllowDestructorName, 
                    boolean AllowConstructorName, 
                    OpaquePtr<QualType> ObjectType, 
                    final SourceLocation /*&*/ TemplateKWLoc, 
                    final UnqualifiedId /*&*/ Result) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      
      // Handle 'A::template B'. This is for template-ids which have not
      // already been annotated by ParseOptionalCXXScopeSpecifier().
      boolean TemplateSpecified = false;
      if ($this().getLangOpts().CPlusPlus && $this().Tok.is(tok.TokenKind.kw_template)
         && (ObjectType.$bool() || SS.isSet())) {
        TemplateSpecified = true;
        TemplateKWLoc.$assignMove($this().ConsumeToken());
      }
      
      // unqualified-id:
      //   identifier
      //   template-id (when it hasn't already been annotated)
      if ($this().Tok.is(tok.TokenKind.identifier)) {
        // Consume the identifier.
        IdentifierInfo /*P*/ Id = $this().Tok.getIdentifierInfo();
        SourceLocation IdLoc = $this().ConsumeToken();
        if (!$this().getLangOpts().CPlusPlus) {
          // If we're not in C++, only identifiers matter. Record the
          // identifier and return.
          Result.setIdentifier(Id, new SourceLocation(IdLoc));
          return false;
        }
        if (AllowConstructorName
           && $this().Actions.isCurrentClassName($Deref(Id), $this().getCurScope(), $AddrOf(SS))) {
          // We have parsed a constructor name.
          OpaquePtr<QualType> Ty = $this().Actions.getTypeName($Deref(Id), new SourceLocation(IdLoc), $this().getCurScope(), $AddrOf(SS), false, 
              false, new OpaquePtr<QualType>(null), 
              /*IsCtorOrDtorName=*/ true, 
              /*NonTrivialTypeSourceInfo=*/ true);
          Result.setConstructorName(new OpaquePtr<QualType>(Ty), new SourceLocation(IdLoc), new SourceLocation(IdLoc));
        } else {
          // We have parsed an identifier.
          Result.setIdentifier(Id, new SourceLocation(IdLoc));
        }
        
        // If the next token is a '<', we may have a template.
        if (TemplateSpecified || $this().Tok.is(tok.TokenKind.less)) {
          return $this().ParseUnqualifiedIdTemplateId(SS, new SourceLocation(TemplateKWLoc), Id, new SourceLocation(IdLoc), 
              EnteringContext, new OpaquePtr<QualType>(ObjectType), 
              Result, TemplateSpecified);
        }
        
        return false;
      }
      
      // unqualified-id:
      //   template-id (already parsed and annotated)
      if ($this().Tok.is(tok.TokenKind.annot_template_id)) {
        TemplateIdAnnotation /*P*/ TemplateId = $this().takeTemplateIdAnnotation($this().Tok);
        
        // If the template-name names the current class, then this is a constructor 
        if (AllowConstructorName && (TemplateId.Name != null)
           && $this().Actions.isCurrentClassName($Deref(TemplateId.Name), $this().getCurScope(), $AddrOf(SS))) {
          if (SS.isSet()) {
            // C++ [class.qual]p2 specifies that a qualified template-name
            // is taken as the constructor name where a constructor can be
            // declared. Thus, the template arguments are extraneous, so
            // complain about them and remove them entirely.
            $c$.clean($out_DiagnosticBuilder$C_FixItHint$C($out_DiagnosticBuilder$C_IdentifierInfo$C$P($c$.track($this().Diag(new SourceLocation(TemplateId.TemplateNameLoc), 
                        diag.err_out_of_line_constructor_template_id)), 
                    TemplateId.Name), 
                FixItHint.CreateRemoval(new SourceRange(/*NO_COPY*/TemplateId.LAngleLoc, /*NO_COPY*/TemplateId.RAngleLoc))));
            OpaquePtr<QualType> Ty = $this().Actions.getTypeName($Deref(TemplateId.Name), new SourceLocation(TemplateId.TemplateNameLoc), 
                $this().getCurScope(), $AddrOf(SS), false, false, new OpaquePtr<QualType>(null), 
                /*IsCtorOrDtorName=*/ true, 
                /*NontrivialTypeSourceInfo=*/ true);
            Result.setConstructorName(new OpaquePtr<QualType>(Ty), new SourceLocation(TemplateId.TemplateNameLoc), 
                new SourceLocation(TemplateId.RAngleLoc));
            $this().ConsumeToken();
            return false;
          }
          
          Result.setConstructorTemplateId(TemplateId);
          $this().ConsumeToken();
          return false;
        }
        
        // We have already parsed a template-id; consume the annotation token as
        // our unqualified-id.
        Result.setTemplateId(TemplateId);
        TemplateKWLoc.$assign(TemplateId.TemplateKWLoc);
        $this().ConsumeToken();
        return false;
      }
      
      // unqualified-id:
      //   operator-function-id
      //   conversion-function-id
      if ($this().Tok.is(tok.TokenKind.kw_operator)) {
        if ($this().ParseUnqualifiedIdOperator(SS, EnteringContext, new OpaquePtr<QualType>(ObjectType), Result)) {
          return true;
        }
        
        // If we have an operator-function-id or a literal-operator-id and the next
        // token is a '<', we may have a
        // 
        //   template-id:
        //     operator-function-id < template-argument-list[opt] >
        if ((Result.getKind() == UnqualifiedId.IdKind.IK_OperatorFunctionId
           || Result.getKind() == UnqualifiedId.IdKind.IK_LiteralOperatorId)
           && (TemplateSpecified || $this().Tok.is(tok.TokenKind.less))) {
          return $this().ParseUnqualifiedIdTemplateId(SS, new SourceLocation(TemplateKWLoc), 
              (IdentifierInfo /*P*/ )null, new SourceLocation(), 
              EnteringContext, new OpaquePtr<QualType>(ObjectType), 
              Result, TemplateSpecified);
        }
        
        return false;
      }
      if ($this().getLangOpts().CPlusPlus
         && (AllowDestructorName || SS.isSet()) && $this().Tok.is(tok.TokenKind.tilde)) {
        DeclaratorScopeObj DeclScopeObj = null;
        try {
          // C++ [expr.unary.op]p10:
          //   There is an ambiguity in the unary-expression ~X(), where X is a 
          //   class-name. The ambiguity is resolved in favor of treating ~ as a 
          //    unary complement rather than treating ~X as referring to a destructor.
          
          // Parse the '~'.
          SourceLocation TildeLoc = $this().ConsumeToken();
          if (SS.isEmpty() && $this().Tok.is(tok.TokenKind.kw_decltype)) {
            DeclSpec DS = null;
            try {
              DS/*J*/= new DeclSpec($this().AttrFactory);
              SourceLocation EndLoc = $this().ParseDecltypeSpecifier(DS);
              {
                OpaquePtr<QualType> Type = $this().Actions.getDestructorType(DS, new OpaquePtr<QualType>(ObjectType));
                if (Type.$bool()) {
                  Result.setDestructorName(new SourceLocation(TildeLoc), new OpaquePtr<QualType>(Type), new SourceLocation(EndLoc));
                  return false;
                }
              }
              return true;
            } finally {
              if (DS != null) { DS.$destroy(); }
            }
          }
          
          // Parse the class-name.
          if ($this().Tok.isNot(tok.TokenKind.identifier)) {
            $c$.clean($c$.track($this().Diag($this().Tok, diag.err_destructor_tilde_identifier)));
            return true;
          }
          
          // If the user wrote ~T::T, correct it to T::~T.
          DeclScopeObj/*J*/= new DeclaratorScopeObj(/*Deref*/$this(), SS);
          if (!TemplateSpecified && $this().NextToken().is(tok.TokenKind.coloncolon)) {
            ColonProtectionRAIIObject ColonRAII = null;
            try {
              // Don't let ParseOptionalCXXScopeSpecifier() "correct"
              // `int A; struct { ~A::A(); };` to `int A; struct { ~A:A(); };`,
              // it will confuse this recovery logic.
              ColonRAII/*J*/= new ColonProtectionRAIIObject(/*Deref*/$this(), false);
              if (SS.isSet()) {
                $this().AnnotateScopeToken(SS, /*NewAnnotation*/ true);
                SS.clear();
              }
              if ($this().ParseOptionalCXXScopeSpecifier(SS, new OpaquePtr<QualType>(ObjectType), EnteringContext)) {
                return true;
              }
              if (SS.isNotEmpty()) {
                ObjectType.$assignMove(new OpaquePtr<QualType>(null));
              }
              if ($this().Tok.isNot(tok.TokenKind.identifier) || $this().NextToken().is(tok.TokenKind.coloncolon)
                 || !SS.isSet()) {
                $c$.clean($c$.track($this().Diag(new SourceLocation(TildeLoc), diag.err_destructor_tilde_scope)));
                return true;
              }
              
              // Recover as if the tilde had been written before the identifier.
              $c$.clean($out_DiagnosticBuilder$C_FixItHint$C($out_DiagnosticBuilder$C_FixItHint$C($c$.track($this().Diag(new SourceLocation(TildeLoc), diag.err_destructor_tilde_scope)), 
                      FixItHint.CreateRemoval(new SourceRange(/*NO_COPY*/TildeLoc))), 
                  FixItHint.CreateInsertion($this().Tok.getLocation(), new StringRef(/*KEEP_STR*/$TILDE))));
              
              // Temporarily enter the scope for the rest of this function.
              if ($this().Actions.ShouldEnterDeclaratorScope($this().getCurScope(), SS)) {
                DeclScopeObj.EnterDeclaratorScope();
              }
            } finally {
              if (ColonRAII != null) { ColonRAII.$destroy(); }
            }
          }
          
          // Parse the class-name (or template-name in a simple-template-id).
          IdentifierInfo /*P*/ ClassName = $this().Tok.getIdentifierInfo();
          SourceLocation ClassNameLoc = $this().ConsumeToken();
          if (TemplateSpecified || $this().Tok.is(tok.TokenKind.less)) {
            Result.setDestructorName(new SourceLocation(TildeLoc), new OpaquePtr<QualType>(null), new SourceLocation(ClassNameLoc));
            return $this().ParseUnqualifiedIdTemplateId(SS, new SourceLocation(TemplateKWLoc), 
                ClassName, new SourceLocation(ClassNameLoc), 
                EnteringContext, new OpaquePtr<QualType>(ObjectType), 
                Result, TemplateSpecified);
          }
          
          // Note that this is a destructor name.
          OpaquePtr<QualType> Ty = $this().Actions.getDestructorName(new SourceLocation(TildeLoc), $Deref(ClassName), 
              new SourceLocation(ClassNameLoc), $this().getCurScope(), 
              SS, new OpaquePtr<QualType>(ObjectType), 
              EnteringContext);
          if (!Ty.$bool()) {
            return true;
          }
          
          Result.setDestructorName(new SourceLocation(TildeLoc), new OpaquePtr<QualType>(Ty), new SourceLocation(ClassNameLoc));
          return false;
        } finally {
          if (DeclScopeObj != null) { DeclScopeObj.$destroy(); }
        }
      }
      
      $c$.clean($out_DiagnosticBuilder$C_uint($c$.track($this().Diag($this().Tok, diag.err_expected_unqualified_id)), 
          $this().getLangOpts().CPlusPlus));
      return true;
    } finally {
      $c$.$destroy();
    }
  }


//===--------------------------------------------------------------------===//
// C++11/G++: Type Traits [Type-Traits.html in the GCC manual]

/// \brief Parse the built-in type-trait pseudo-functions that allow 
/// implementation of the TR1/C++11 type traits templates.
///
///       primary-expression:
///          unary-type-trait '(' type-id ')'
///          binary-type-trait '(' type-id ',' type-id ')'
///          type-trait '(' type-id-seq ')'
///
///       type-id-seq:
///          type-id ...[opt] type-id-seq[opt]
///
//<editor-fold defaultstate="collapsed" desc="clang::Parser::ParseTypeTrait">
@Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseExprCXX.cpp", line = 2919,
   FQN="clang::Parser::ParseTypeTrait", NM="_ZN5clang6Parser14ParseTypeTraitEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseExprCXX.cpp -nm=_ZN5clang6Parser14ParseTypeTraitEv")
  //</editor-fold>
  protected /*private*/ ActionResultTTrue<Expr /*P*/ > ParseTypeTrait() {
    BalancedDelimiterTracker Parens = null;
    try {
      /*tok.TokenKind*/char Kind = $this().Tok.getKind();
      /*uint*/int Arity = TypeTraitArity(Kind);
      
      SourceLocation Loc = $this().ConsumeToken();
      
      Parens/*J*/= new BalancedDelimiterTracker(/*Deref*/$this(), tok.TokenKind.l_paren);
      if (Parens.expectAndConsume()) {
        return ExprError();
      }
      
      SmallVector<OpaquePtr<QualType>> Args/*J*/= new SmallVector<OpaquePtr<QualType>>(2, new OpaquePtr<QualType>());
      do {
        // Parse the next type.
        ActionResult<OpaquePtr<QualType> > Ty = $this().ParseTypeName();
        if (Ty.isInvalid()) {
          Parens.skipToEnd();
          return ExprError();
        }
        
        // Parse the ellipsis, if present.
        if ($this().Tok.is(tok.TokenKind.ellipsis)) {
          Ty.$assignMove($this().Actions.ActOnPackExpansion(Ty.get(), $this().ConsumeToken()));
          if (Ty.isInvalid()) {
            Parens.skipToEnd();
            return ExprError();
          }
        }
        
        // Add this type to the list of arguments.
        Args.push_back(Ty.get());
      } while ($this().TryConsumeToken(tok.TokenKind.comma));
      if (Parens.consumeClose()) {
        return ExprError();
      }
      
      SourceLocation EndLoc = Parens.getCloseLocation();
      if ((Arity != 0) && Args.size() != Arity) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_DiagnosticBuilder$C_SourceRange($out_DiagnosticBuilder$C_int($out$Same2Bool($out_DiagnosticBuilder$C_int($out_DiagnosticBuilder$C_uint($c$.track($this().Diag(new SourceLocation(EndLoc), diag.err_type_trait_arity)), 
                              Arity), 0), ($greater_uint(Arity, 1))), (int)Args.size()), new SourceRange(/*NO_COPY*/Loc)));
          return ExprError();
        } finally {
          $c$.$destroy();
        }
      }
      if (!(Arity != 0) && Args.empty()) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_DiagnosticBuilder$C_SourceRange($out_DiagnosticBuilder$C_int($out_DiagnosticBuilder$C_int($out_DiagnosticBuilder$C_int($out_DiagnosticBuilder$C_int($c$.track($this().Diag(new SourceLocation(EndLoc), diag.err_type_trait_arity)), 
                              1), 1), 1), (int)Args.size()), new SourceRange(/*NO_COPY*/Loc)));
          return ExprError();
        } finally {
          $c$.$destroy();
        }
      }
      
      return $this().Actions.ActOnTypeTrait(TypeTraitFromTokKind(Kind), new SourceLocation(Loc), new ArrayRef<OpaquePtr<QualType> >(Args), new SourceLocation(EndLoc));
    } finally {
      if (Parens != null) { Parens.$destroy(); }
    }
  }


//===--------------------------------------------------------------------===//
// Embarcadero: Arary and Expression Traits

/// ParseArrayTypeTrait - Parse the built-in array type-trait
/// pseudo-functions.
///
///       primary-expression:
/// [Embarcadero]     '__array_rank' '(' type-id ')'
/// [Embarcadero]     '__array_extent' '(' type-id ',' expression ')'
///
//<editor-fold defaultstate="collapsed" desc="clang::Parser::ParseArrayTypeTrait">
@Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseExprCXX.cpp", line = 2978,
   FQN="clang::Parser::ParseArrayTypeTrait", NM="_ZN5clang6Parser19ParseArrayTypeTraitEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseExprCXX.cpp -nm=_ZN5clang6Parser19ParseArrayTypeTraitEv")
  //</editor-fold>
  protected /*private*/ ActionResultTTrue<Expr /*P*/ > ParseArrayTypeTrait() {
    BalancedDelimiterTracker T = null;
    try {
      ArrayTypeTrait ATT = ArrayTypeTraitFromTokKind($this().Tok.getKind());
      SourceLocation Loc = $this().ConsumeToken();
      
      T/*J*/= new BalancedDelimiterTracker(/*Deref*/$this(), tok.TokenKind.l_paren);
      if (T.expectAndConsume()) {
        return ExprError();
      }
      
      ActionResult<OpaquePtr<QualType> > Ty = $this().ParseTypeName();
      if (Ty.isInvalid()) {
        $this().SkipUntil(tok.TokenKind.comma, SkipUntilFlags.StopAtSemi);
        $this().SkipUntil(tok.TokenKind.r_paren, SkipUntilFlags.StopAtSemi);
        return ExprError();
      }
      switch (ATT) {
       case ATT_ArrayRank:
        {
          T.consumeClose();
          return $this().Actions.ActOnArrayTypeTrait(ATT, new SourceLocation(Loc), Ty.get(), (Expr /*P*/ )null, 
              T.getCloseLocation());
        }
       case ATT_ArrayExtent:
        {
          if ($this().ExpectAndConsume(tok.TokenKind.comma)) {
            $this().SkipUntil(tok.TokenKind.r_paren, SkipUntilFlags.StopAtSemi);
            return ExprError();
          }
          
          ActionResultTTrue<Expr /*P*/ > DimExpr = $this().ParseExpression();
          T.consumeClose();
          
          return $this().Actions.ActOnArrayTypeTrait(ATT, new SourceLocation(Loc), Ty.get(), DimExpr.get(), 
              T.getCloseLocation());
        }
      }
      throw new llvm_unreachable("Invalid ArrayTypeTrait!");
    } finally {
      if (T != null) { T.$destroy(); }
    }
  }


/// ParseExpressionTrait - Parse built-in expression-trait
/// pseudo-functions like __is_lvalue_expr( xxx ).
///
///       primary-expression:
/// [Embarcadero]     expression-trait '(' expression ')'
///
//<editor-fold defaultstate="collapsed" desc="clang::Parser::ParseExpressionTrait">
@Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseExprCXX.cpp", line = 3021,
   FQN="clang::Parser::ParseExpressionTrait", NM="_ZN5clang6Parser20ParseExpressionTraitEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseExprCXX.cpp -nm=_ZN5clang6Parser20ParseExpressionTraitEv")
  //</editor-fold>
  protected /*private*/ ActionResultTTrue<Expr /*P*/ > ParseExpressionTrait() {
    BalancedDelimiterTracker T = null;
    try {
      ExpressionTrait ET = ExpressionTraitFromTokKind($this().Tok.getKind());
      SourceLocation Loc = $this().ConsumeToken();
      
      T/*J*/= new BalancedDelimiterTracker(/*Deref*/$this(), tok.TokenKind.l_paren);
      if (T.expectAndConsume()) {
        return ExprError();
      }
      
      ActionResultTTrue<Expr /*P*/ > Expr = $this().ParseExpression();
      
      T.consumeClose();
      
      return $this().Actions.ActOnExpressionTrait(ET, new SourceLocation(Loc), Expr.get(), 
          T.getCloseLocation());
    } finally {
      if (T != null) { T.$destroy(); }
    }
  }

} // END OF class Parser_ParseExprCXX
