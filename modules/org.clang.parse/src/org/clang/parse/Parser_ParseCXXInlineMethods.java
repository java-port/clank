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
import org.clank.support.*;
import org.clank.support.aliases.*;
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
import static org.clang.parse.Parser.*;


//<editor-fold defaultstate="collapsed" desc="static type Parser_ParseCXXInlineMethods">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -empty-body -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType -split-class=clang::Parser@this -extends=Parser_NotDefined ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseCXXInlineMethods.cpp -nm=_ZN5clang6Parser19ParseLexedMethodDefERNS0_11LexedMethodE;_ZN5clang6Parser20ConsumeAndStoreUntilENS_3tok9TokenKindES2_RN4llvm11SmallVectorINS_5TokenELj4EEEbb;_ZN5clang6Parser20ParseLexedMethodDefsERNS0_12ParsingClassE;_ZN5clang6Parser23ParseCXXInlineMethodDefENS_15AccessSpecifierEPNS_13AttributeListERNS_17ParsingDeclaratorERKNS0_18ParsedTemplateInfoERKNS_14VirtSpecifiersENS_14SourceLocationE;_ZN5clang6Parser26ConsumeAndStoreConditionalERN4llvm11SmallVectorINS_5TokenELj4EEE;_ZN5clang6Parser26ConsumeAndStoreInitializerERN4llvm11SmallVectorINS_5TokenELj4EEENS0_14CachedInitKindE;_ZN5clang6Parser27ParseLexedMemberInitializerERNS0_27LateParsedMemberInitializerE;_ZN5clang6Parser27ParseLexedMethodDeclarationERNS0_27LateParsedMethodDeclarationE;_ZN5clang6Parser28ParseLexedMemberInitializersERNS0_12ParsingClassE;_ZN5clang6Parser28ParseLexedMethodDeclarationsERNS0_12ParsingClassE;_ZN5clang6Parser31ConsumeAndStoreFunctionPrologueERN4llvm11SmallVectorINS_5TokenELj4EEE;_ZN5clang6Parser34ParseCXXNonStaticMemberInitializerEPNS_4DeclE; -static-type=Parser_ParseCXXInlineMethods -package=org.clang.parse")
//</editor-fold>
public class Parser_ParseCXXInlineMethods extends Parser_NotDefined {
private final /*split clang::Parser*/ Parser $this() { return (Parser)this; }


/// ParseCXXInlineMethodDef - We parsed and verified that the specified
/// Declarator is a well formed C++ inline method definition. Now lex its body
/// and store its tokens for parsing after the C++ class is complete.
//<editor-fold defaultstate="collapsed" desc="clang::Parser::ParseCXXInlineMethodDef">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseCXXInlineMethods.cpp", line = 25,
   FQN="clang::Parser::ParseCXXInlineMethodDef", NM="_ZN5clang6Parser23ParseCXXInlineMethodDefENS_15AccessSpecifierEPNS_13AttributeListERNS_17ParsingDeclaratorERKNS0_18ParsedTemplateInfoERKNS_14VirtSpecifiersENS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseCXXInlineMethods.cpp -nm=_ZN5clang6Parser23ParseCXXInlineMethodDefENS_15AccessSpecifierEPNS_13AttributeListERNS_17ParsingDeclaratorERKNS0_18ParsedTemplateInfoERKNS_14VirtSpecifiersENS_14SourceLocationE")
  //</editor-fold>
  protected /*private*/ NamedDecl /*P*/ ParseCXXInlineMethodDef(AccessSpecifier AS, 
                         AttributeList /*P*/ AccessAttrs, 
                         final ParsingDeclarator /*&*/ D, 
                         final /*const*/ ParsedTemplateInfo /*&*/ TemplateInfo, 
                         final /*const*/ VirtSpecifiers /*&*/ VS, 
                         SourceLocation PureSpecLoc) {
    assert (D.isFunctionDeclarator()) : "This isn't a function declarator!";
    assert ($this().Tok.isOneOf$T(tok.TokenKind.l_brace, tok.TokenKind.colon, tok.TokenKind.kw_try, tok.TokenKind.equal)) : "Current token not a '{', ':', '=', or 'try'!";
    
    MutableArrayRef<TemplateParameterList /*P*/ > TemplateParams/*J*/= new MutableArrayRef<TemplateParameterList /*P*/ >((TemplateInfo.TemplateParams != null) ? TemplateInfo.TemplateParams.data() : (type$ptr<TemplateParameterList> /*P*/ )null, 
        (TemplateInfo.TemplateParams != null) ? TemplateInfo.TemplateParams.size() : 0, true);
    
    NamedDecl /*P*/ FnD;
    if (D.getDeclSpec().isFriendSpecified()) {
      FnD = $this().Actions.ActOnFriendFunctionDecl($this().getCurScope(), D, 
          new MutableArrayRef<TemplateParameterList /*P*/ >(TemplateParams));
    } else {
      FnD = $this().Actions.ActOnCXXMemberDeclarator($this().getCurScope(), AS, D, 
          new MutableArrayRef<TemplateParameterList /*P*/ >(TemplateParams), (Expr /*P*/ )null, 
          VS, InClassInitStyle.ICIS_NoInit);
      if ((FnD != null)) {
        $this().Actions.ProcessDeclAttributeList($this().getCurScope(), FnD, AccessAttrs);
        if (PureSpecLoc.isValid()) {
          $this().Actions.ActOnPureSpecifier(FnD, new SourceLocation(PureSpecLoc));
        }
      }
    }
    if ((FnD != null)) {
      $this().HandleMemberFunctionDeclDelays(D, FnD);
    }
    
    D.complete(FnD);
    if ($this().TryConsumeToken(tok.TokenKind.equal)) {
      if (!(FnD != null)) {
        $this().SkipUntil(tok.TokenKind.semi);
        return null;
      }
      
      boolean Delete = false;
      SourceLocation KWLoc/*J*/= new SourceLocation();
      SourceLocation KWEndLoc = $this().Tok.getEndLoc().getLocWithOffset(-1);
      if ($this().TryConsumeToken(tok.TokenKind.kw_delete, KWLoc)) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_DiagnosticBuilder$C_int($c$.track($this().Diag(new SourceLocation(KWLoc), $this().getLangOpts().CPlusPlus11 ? diag.warn_cxx98_compat_defaulted_deleted_function : diag.ext_defaulted_deleted_function)), 
              1/* deleted */));
          $this().Actions.SetDeclDeleted(FnD, new SourceLocation(KWLoc));
          Delete = true;
          {
            FunctionDecl /*P*/ DeclAsFunction = dyn_cast(FunctionDecl.class, FnD);
            if ((DeclAsFunction != null)) {
              DeclAsFunction.setRangeEnd(new SourceLocation(KWEndLoc));
            }
          }
        } finally {
          $c$.$destroy();
        }
      } else if ($this().TryConsumeToken(tok.TokenKind.kw_default, KWLoc)) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_DiagnosticBuilder$C_int($c$.track($this().Diag(new SourceLocation(KWLoc), $this().getLangOpts().CPlusPlus11 ? diag.warn_cxx98_compat_defaulted_deleted_function : diag.ext_defaulted_deleted_function)), 
              0/* defaulted */));
          $this().Actions.SetDeclDefaulted(FnD, new SourceLocation(KWLoc));
          {
            FunctionDecl /*P*/ DeclAsFunction = dyn_cast(FunctionDecl.class, FnD);
            if ((DeclAsFunction != null)) {
              DeclAsFunction.setRangeEnd(new SourceLocation(KWEndLoc));
            }
          }
        } finally {
          $c$.$destroy();
        }
      } else {
        throw new llvm_unreachable("function definition after = not 'delete' or 'default'");
      }
      if ($this().Tok.is(tok.TokenKind.comma)) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out$Same2Bool($c$.track($this().Diag(new SourceLocation(KWLoc), diag.err_default_delete_in_multiple_declaration)), 
              Delete));
          $this().SkipUntil(tok.TokenKind.semi);
        } finally {
          $c$.$destroy();
        }
      } else if ($this().ExpectAndConsume(tok.TokenKind.semi, diag.err_expected_after, 
          new StringRef(Delete ? $delete : $default))) {
        $this().SkipUntil(tok.TokenKind.semi);
      }
      
      return FnD;
    }
    if ($this().SkipFunctionBodies && (!(FnD != null) || $this().Actions.canSkipFunctionBody(FnD))
       && $this().trySkippingFunctionBody()) {
      $this().Actions.ActOnSkippedFunctionBody(FnD);
      return FnD;
    }
    
    // In delayed template parsing mode, if we are within a class template
    // or if we are about to parse function member template then consume
    // the tokens and store them for parsing at the end of the translation unit.
    if ($this().getLangOpts().DelayedTemplateParsing
       && D.getFunctionDefinitionKind() == FunctionDefinitionKind.FDK_Definition
       && !D.getDeclSpec().isConstexprSpecified()
       && !((FnD != null) && (FnD.getAsFunction() != null)
       && (FnD.getAsFunction().getReturnType().$arrow().getContainedAutoType() != null))
       && (($this().Actions.CurContext.isDependentContext()
       || (TemplateInfo.Kind != ParsedTemplateInfo.Unnamed_enum.NonTemplate
       && TemplateInfo.Kind != ParsedTemplateInfo.Unnamed_enum.ExplicitSpecialization))
       && !$this().Actions.IsInsideALocalClassWithinATemplateFunction())) {
      
      SmallVectorToken Toks/*J*/= new SmallVectorToken(4, /*new Token()*/(Token)null);
      $this().LexTemplateFunctionForLateParsing(Toks);
      if ((FnD != null)) {
        FunctionDecl /*P*/ FD = FnD.getAsFunction();
        $this().Actions.CheckForFunctionRedefinition(FD);
        $this().Actions.MarkAsLateParsedTemplate(FD, FnD, Toks);
      }
      
      return FnD;
    }
    
    // Consume the tokens and store them for later parsing.
    LexedMethod /*P*/ LM = new LexedMethod($this(), FnD);
    $this().getCurrentClass().LateParsedDeclarations.push_back(LM);
    LM.TemplateScope = $this().getCurScope().isTemplateParamScope();
    final SmallVectorToken /*&*/ Toks = LM.Toks;
    
    /*tok.TokenKind*/char kind = $this().Tok.getKind();
    // Consume everything up to (and including) the left brace of the
    // function body.
    if ($this().ConsumeAndStoreFunctionPrologue(Toks)) {
      // We didn't find the left-brace we expected after the
      // constructor initializer; we already printed an error, and it's likely
      // impossible to recover, so don't try to parse this method later.
      // Skip over the rest of the decl and back to somewhere that looks
      // reasonable.
      $this().SkipMalformedDecl();
      if ($this().getCurrentClass().LateParsedDeclarations.back() != null) { $this().getCurrentClass().LateParsedDeclarations.back().$destroy();};
      $this().getCurrentClass().LateParsedDeclarations.pop_back();
      return FnD;
    } else {
      // Consume everything up to (and including) the matching right brace.
      $this().ConsumeAndStoreUntil(tok.TokenKind.r_brace, Toks, /*StopAtSemi=*/ false);
    }
    
    // If we're in a function-try-block, we need to store all the catch blocks.
    if (kind == tok.TokenKind.kw_try) {
      while ($this().Tok.is(tok.TokenKind.kw_catch)) {
        $this().ConsumeAndStoreUntil(tok.TokenKind.l_brace, Toks, /*StopAtSemi=*/ false);
        $this().ConsumeAndStoreUntil(tok.TokenKind.r_brace, Toks, /*StopAtSemi=*/ false);
      }
    }
    if ((FnD != null)) {
      // If this is a friend function, mark that it's late-parsed so that
      // it's still known to be a definition even before we attach the
      // parsed body.  Sema needs to treat friend function definitions
      // differently during template instantiation, and it's possible for
      // the containing class to be instantiated before all its member
      // function definitions are parsed.
      //
      // If you remove this, you can remove the code that clears the flag
      // after parsing the member.
      if (D.getDeclSpec().isFriendSpecified()) {
        FunctionDecl /*P*/ FD = FnD.getAsFunction();
        $this().Actions.CheckForFunctionRedefinition(FD);
        FD.setLateTemplateParsed(true);
      }
    } else {
      // If semantic analysis could not build a function declaration,
      // just throw away the late-parsed declaration.
      if ($this().getCurrentClass().LateParsedDeclarations.back() != null) { $this().getCurrentClass().LateParsedDeclarations.back().$destroy();};
      $this().getCurrentClass().LateParsedDeclarations.pop_back();
    }
    
    return FnD;
  }


/// ParseCXXNonStaticMemberInitializer - We parsed and verified that the
/// specified Declarator is a well formed C++ non-static data member
/// declaration. Now lex its initializer and store its tokens for parsing
/// after the class is complete.
//<editor-fold defaultstate="collapsed" desc="clang::Parser::ParseCXXNonStaticMemberInitializer">
@Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseCXXInlineMethods.cpp", line = 197,
   FQN="clang::Parser::ParseCXXNonStaticMemberInitializer", NM="_ZN5clang6Parser34ParseCXXNonStaticMemberInitializerEPNS_4DeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseCXXInlineMethods.cpp -nm=_ZN5clang6Parser34ParseCXXNonStaticMemberInitializerEPNS_4DeclE")
  //</editor-fold>
  protected /*private*/ void ParseCXXNonStaticMemberInitializer(Decl /*P*/ VarD) {
    assert ($this().Tok.isOneOf(tok.TokenKind.l_brace, tok.TokenKind.equal)) : "Current token not a '{' or '='!";
    
    LateParsedMemberInitializer /*P*/ MI = new LateParsedMemberInitializer($this(), VarD);
    $this().getCurrentClass().LateParsedDeclarations.push_back(MI);
    final SmallVectorToken /*&*/ Toks = MI.Toks;
    
    /*tok.TokenKind*/char kind = $this().Tok.getKind();
    if (kind == tok.TokenKind.equal) {
      Toks.push_back($this().Tok);
      $this().ConsumeToken();
    }
    if (kind == tok.TokenKind.l_brace) {
      // Begin by storing the '{' token.
      Toks.push_back($this().Tok);
      $this().ConsumeBrace();
      
      // Consume everything up to (and including) the matching right brace.
      $this().ConsumeAndStoreUntil(tok.TokenKind.r_brace, Toks, /*StopAtSemi=*/ true);
    } else {
      // Consume everything up to (but excluding) the comma or semicolon.
      $this().ConsumeAndStoreInitializer(Toks, CachedInitKind.CIK_DefaultInitializer);
    }
    
    // Store an artificial EOF token to ensure that we don't run off the end of
    // the initializer when we come to parse it.
    Token Eof/*J*/= new Token();
    Eof.startToken();
    Eof.setKind(tok.TokenKind.eof);
    Eof.setLocation($this().Tok.getLocation());
    Eof.setEofData(VarD);
    Toks.push_back(Eof);
  }


/// ParseLexedMethodDeclarations - We finished parsing the member
/// specification of a top (non-nested) C++ class. Now go over the
/// stack of method declarations with some parts for which parsing was
/// delayed (such as default arguments) and parse them.
//<editor-fold defaultstate="collapsed" desc="clang::Parser::ParseLexedMethodDeclarations">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseCXXInlineMethods.cpp", line = 274,
   FQN="clang::Parser::ParseLexedMethodDeclarations", NM="_ZN5clang6Parser28ParseLexedMethodDeclarationsERNS0_12ParsingClassE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseCXXInlineMethods.cpp -nm=_ZN5clang6Parser28ParseLexedMethodDeclarationsERNS0_12ParsingClassE")
  //</editor-fold>
  protected /*private*/ void ParseLexedMethodDeclarations(final ParsingClass /*&*/ Class) {
    ParseScope ClassTemplateScope = null;
    TemplateParameterDepthRAII CurTemplateDepthTracker = null;
    ParseScope ClassScope = null;
    try {
      boolean HasTemplateScope = !Class.TopLevelClass && Class.TemplateScope;
      ClassTemplateScope/*J*/= new ParseScope($this(), Scope.ScopeFlags.TemplateParamScope, 
          HasTemplateScope);
      CurTemplateDepthTracker/*J*/= new TemplateParameterDepthRAII($this().TemplateParameterDepth$Ref);
      if (HasTemplateScope) {
        $this().Actions.ActOnReenterTemplateScope($this().getCurScope(), Class.TagOrTemplate);
        CurTemplateDepthTracker.$preInc();
      }
      
      // The current scope is still active if we're the top-level class.
      // Otherwise we'll need to push and enter a new scope.
      boolean HasClassScope = !Class.TopLevelClass;
      ClassScope/*J*/= new ParseScope($this(), Scope.ScopeFlags.ClassScope | Scope.ScopeFlags.DeclScope, 
          HasClassScope);
      if (HasClassScope) {
        $this().Actions.ActOnStartDelayedMemberDeclarations($this().getCurScope(), 
            Class.TagOrTemplate);
      }
      
      for (/*size_t*/int i = 0; $less_uint(i, Class.LateParsedDeclarations.size()); ++i) {
        Class.LateParsedDeclarations.$at(i).ParseLexedMethodDeclarations();
      }
      if (HasClassScope) {
        $this().Actions.ActOnFinishDelayedMemberDeclarations($this().getCurScope(), 
            Class.TagOrTemplate);
      }
    } finally {
      if (ClassScope != null) { ClassScope.$destroy(); }
      if (CurTemplateDepthTracker != null) { CurTemplateDepthTracker.$destroy(); }
      if (ClassTemplateScope != null) { ClassTemplateScope.$destroy(); }
    }
  }

//<editor-fold defaultstate="collapsed" desc="clang::Parser::ParseLexedMethodDeclaration">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseCXXInlineMethods.cpp", line = 302,
   FQN="clang::Parser::ParseLexedMethodDeclaration", NM="_ZN5clang6Parser27ParseLexedMethodDeclarationERNS0_27LateParsedMethodDeclarationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseCXXInlineMethods.cpp -nm=_ZN5clang6Parser27ParseLexedMethodDeclarationERNS0_27LateParsedMethodDeclarationE")
  //</editor-fold>
  protected /*private*/ void ParseLexedMethodDeclaration(final LateParsedMethodDeclaration /*&*/ LM) {
    ParseScope TemplateScope = null;
    TemplateParameterDepthRAII CurTemplateDepthTracker = null;
    ParseScope PrototypeScope = null;
    try {
      // If this is a member template, introduce the template parameter scope.
      TemplateScope/*J*/= new ParseScope($this(), Scope.ScopeFlags.TemplateParamScope, LM.TemplateScope);
      CurTemplateDepthTracker/*J*/= new TemplateParameterDepthRAII($this().TemplateParameterDepth$Ref);
      if (LM.TemplateScope) {
        $this().Actions.ActOnReenterTemplateScope($this().getCurScope(), LM.Method);
        CurTemplateDepthTracker.$preInc();
      }
      // Start the delayed C++ method declaration
      $this().Actions.ActOnStartDelayedCXXMethodDeclaration($this().getCurScope(), LM.Method);
      
      // Introduce the parameters into scope and parse their default
      // arguments.
      PrototypeScope/*J*/= new ParseScope($this(), Scope.ScopeFlags.FunctionPrototypeScope
             | Scope.ScopeFlags.FunctionDeclarationScope | Scope.ScopeFlags.DeclScope);
      for (/*uint*/int I = 0, N = LM.DefaultArgs.size(); I != N; ++I) {
        ParmVarDecl /*P*/ Param = cast(ParmVarDecl.class, LM.DefaultArgs.$at(I).Param);
        // Introduce the parameter into scope.
        boolean HasUnparsed = Param.hasUnparsedDefaultArg();
        $this().Actions.ActOnDelayedCXXMethodParameter($this().getCurScope(), Param);
        {
          SmallVectorToken /*P*/ Toks = LM.DefaultArgs.$at(I).Toks;
          if ((Toks != null)) {
            EnterExpressionEvaluationContext Eval = null;
            try {
              // Mark the end of the default argument so that we know when to stop when
              // we parse it later on.
              Token LastDefaultArgToken = new Token(Toks.back());
              Token DefArgEnd/*J*/= new Token();
              DefArgEnd.startToken();
              DefArgEnd.setKind(tok.TokenKind.eof);
              DefArgEnd.setLocation(LastDefaultArgToken.getEndLoc());
              DefArgEnd.setEofData(Param);
              Toks.push_back(DefArgEnd);
              
              // Parse the default argument from its saved token stream.
              Toks.push_back($this().Tok); // So that the current token doesn't get lost
              $this().PP.EnterTokenStream(new ArrayRefToken($Deref(Toks)), true);
              
              // Consume the previously-pushed token.
              $this().ConsumeAnyToken();
              
              // Consume the '='.
              assert ($this().Tok.is(tok.TokenKind.equal)) : "Default argument not starting with '='";
              SourceLocation EqualLoc = $this().ConsumeToken();
              
              // The argument isn't actually potentially evaluated unless it is
              // used.
              Eval/*J*/= new EnterExpressionEvaluationContext($this().Actions, 
                  Sema.ExpressionEvaluationContext.PotentiallyEvaluatedIfUsed, 
                  Param);
              
              ActionResultTTrue<Expr /*P*/ > DefArgResult/*J*/= new ActionResultTTrue<Expr /*P*/ >();
              if ($this().getLangOpts().CPlusPlus11 && $this().Tok.is(tok.TokenKind.l_brace)) {
                JavaCleaner $c$ = $createJavaCleaner();
                try {
                  $c$.clean($c$.track($this().Diag($this().Tok, diag.warn_cxx98_compat_generalized_initializer_lists)));
                  DefArgResult.$assignMove($this().ParseBraceInitializer());
                } finally {
                  $c$.$destroy();
                }
              } else {
                DefArgResult.$assignMove($this().ParseAssignmentExpression());
              }
              DefArgResult.$assignMove($this().Actions.CorrectDelayedTyposInExpr(new ActionResultTTrue<Expr /*P*/ >(DefArgResult)));
              if (DefArgResult.isInvalid()) {
                $this().Actions.ActOnParamDefaultArgumentError(Param, new SourceLocation(EqualLoc));
              } else {
                if ($this().Tok.isNot(tok.TokenKind.eof) || $this().Tok.getEofData() != Param) {
                  JavaCleaner $c$ = $createJavaCleaner();
                  try {
                    // The last two tokens are the terminator and the saved value of
                    // Tok; the last token in the default argument is the one before
                    // those.
                    assert ($greatereq_uint(Toks.size(), 3)) : "expected a token in default arg";
                    $c$.clean($out_DiagnosticBuilder$C_SourceRange($c$.track($this().Diag($this().Tok.getLocation(), diag.err_default_arg_unparsed)), 
                        new SourceRange($this().Tok.getLocation(), 
                            (/*Deref*/Toks).$at(Toks.size() - 3).getLocation())));
                  } finally {
                    $c$.$destroy();
                  }
                }
                $this().Actions.ActOnParamDefaultArgument(Param, new SourceLocation(EqualLoc), 
                    DefArgResult.get());
              }
              
              // There could be leftover tokens (e.g. because of an error).
              // Skip through until we reach the 'end of default argument' token.
              while ($this().Tok.isNot(tok.TokenKind.eof)) {
                $this().ConsumeAnyToken();
              }
              if ($this().Tok.is(tok.TokenKind.eof) && $this().Tok.getEofData() == Param) {
                $this().ConsumeAnyToken();
              }
              
              if (Toks != null) { Toks.$destroy();};
              LM.DefaultArgs.$at(I).Toks = null;
            } finally {
              if (Eval != null) { Eval.$destroy(); }
            }
          } else if (HasUnparsed) {
            assert (Param.hasInheritedDefaultArg());
            FunctionDecl /*P*/ Old = cast(FunctionDecl.class, LM.Method).getPreviousDecl();
            ParmVarDecl /*P*/ OldParam = Old.getParamDecl(I);
            assert (!OldParam.hasUnparsedDefaultArg());
            if (OldParam.hasUninstantiatedDefaultArg()) {
              Param.setUninstantiatedDefaultArg(OldParam.getUninstantiatedDefaultArg());
            } else {
              Param.setDefaultArg(OldParam.getInit());
            }
          }
        }
      }
      {
        
        // Parse a delayed exception-specification, if there is one.
        SmallVectorToken /*P*/ Toks = LM.ExceptionSpecTokens;
        if ((Toks != null)) {
          Sema.CXXThisScopeRAII ThisScope = null;
          try {
            // Add the 'stop' token.
            Token LastExceptionSpecToken = new Token(Toks.back());
            Token ExceptionSpecEnd/*J*/= new Token();
            ExceptionSpecEnd.startToken();
            ExceptionSpecEnd.setKind(tok.TokenKind.eof);
            ExceptionSpecEnd.setLocation(LastExceptionSpecToken.getEndLoc());
            ExceptionSpecEnd.setEofData(LM.Method);
            Toks.push_back(ExceptionSpecEnd);
            
            // Parse the default argument from its saved token stream.
            Toks.push_back($this().Tok); // So that the current token doesn't get lost
            $this().PP.EnterTokenStream(new ArrayRefToken($Deref(Toks)), true);
            
            // Consume the previously-pushed token.
            $this().ConsumeAnyToken();
            
            // C++11 [expr.prim.general]p3:
            //   If a declaration declares a member function or member function
            //   template of a class X, the expression this is a prvalue of type
            //   "pointer to cv-qualifier-seq X" between the optional cv-qualifer-seq
            //   and the end of the function-definition, member-declarator, or
            //   declarator.
            CXXMethodDecl /*P*/ Method;
            {
              FunctionTemplateDecl /*P*/ FunTmpl = dyn_cast(FunctionTemplateDecl.class, LM.Method);
              if ((FunTmpl != null)) {
                Method = cast(CXXMethodDecl.class, FunTmpl.getTemplatedDecl());
              } else {
                Method = cast(CXXMethodDecl.class, LM.Method);
              }
            }
            
            ThisScope/*J*/= new Sema.CXXThisScopeRAII($this().Actions, Method.getParent(), 
                Method.getTypeQualifiers(), 
                $this().getLangOpts().CPlusPlus11);
            
            // Parse the exception-specification.
            SourceRange SpecificationRange/*J*/= new SourceRange();
            SmallVector<OpaquePtr<QualType>> DynamicExceptions/*J*/= new SmallVector<OpaquePtr<QualType>>(4, new OpaquePtr<QualType>());
            SmallVector<SourceRange> DynamicExceptionRanges/*J*/= new SmallVector<SourceRange>(4, SourceRange.EMPTY);
            ActionResultTTrue<Expr /*P*/ > NoexceptExpr/*J*/= new ActionResultTTrue<Expr /*P*/ >();
            type$ref<SmallVectorToken /*P*/> ExceptionSpecTokens = create_type$null$ref(null);
            
            ExceptionSpecificationType EST = $this().tryParseExceptionSpecification(/*Delayed=*/ false, SpecificationRange, 
                DynamicExceptions, 
                DynamicExceptionRanges, NoexceptExpr, 
                ExceptionSpecTokens);
            if ($this().Tok.isNot(tok.TokenKind.eof) || $noteq_ptr($this().Tok.getEofData(), LM.Method)) {
              JavaCleaner $c$ = $createJavaCleaner();
              try {
                $c$.clean($c$.track($this().Diag($this().Tok.getLocation(), diag.err_except_spec_unparsed)));
              } finally {
                $c$.$destroy();
              }
            }
            
            // Attach the exception-specification to the method.
            $this().Actions.actOnDelayedExceptionSpecification(LM.Method, EST, 
                new SourceRange(SpecificationRange), 
                new ArrayRef<OpaquePtr<QualType> >(DynamicExceptions), 
                new ArrayRef<SourceRange>(DynamicExceptionRanges), 
                NoexceptExpr.isUsable() ? NoexceptExpr.get() : (Expr /*P*/ )null);
            
            // There could be leftover tokens (e.g. because of an error).
            // Skip through until we reach the original token position.
            while ($this().Tok.isNot(tok.TokenKind.eof)) {
              $this().ConsumeAnyToken();
            }
            
            // Clean up the remaining EOF token.
            if ($this().Tok.is(tok.TokenKind.eof) && $eq_ptr($this().Tok.getEofData(), LM.Method)) {
              $this().ConsumeAnyToken();
            }
            
            if (Toks != null) { Toks.$destroy();};
            LM.ExceptionSpecTokens = null;
          } finally {
            if (ThisScope != null) { ThisScope.$destroy(); }
          }
        }
      }
      
      PrototypeScope.Exit();
      
      // Finish the delayed C++ method declaration.
      $this().Actions.ActOnFinishDelayedCXXMethodDeclaration($this().getCurScope(), LM.Method);
    } finally {
      if (PrototypeScope != null) { PrototypeScope.$destroy(); }
      if (CurTemplateDepthTracker != null) { CurTemplateDepthTracker.$destroy(); }
      if (TemplateScope != null) { TemplateScope.$destroy(); }
    }
  }


/// ParseLexedMethodDefs - We finished parsing the member specification of a top
/// (non-nested) C++ class. Now go over the stack of lexed methods that were
/// collected during its parsing and parse them all.
//<editor-fold defaultstate="collapsed" desc="clang::Parser::ParseLexedMethodDefs">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseCXXInlineMethods.cpp", line = 477,
   FQN="clang::Parser::ParseLexedMethodDefs", NM="_ZN5clang6Parser20ParseLexedMethodDefsERNS0_12ParsingClassE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseCXXInlineMethods.cpp -nm=_ZN5clang6Parser20ParseLexedMethodDefsERNS0_12ParsingClassE")
  //</editor-fold>
  protected /*private*/ void ParseLexedMethodDefs(final ParsingClass /*&*/ Class) {
    ParseScope ClassTemplateScope = null;
    TemplateParameterDepthRAII CurTemplateDepthTracker = null;
    ParseScope ClassScope = null;
    try {
      boolean HasTemplateScope = !Class.TopLevelClass && Class.TemplateScope;
      ClassTemplateScope/*J*/= new ParseScope($this(), Scope.ScopeFlags.TemplateParamScope, HasTemplateScope);
      CurTemplateDepthTracker/*J*/= new TemplateParameterDepthRAII($this().TemplateParameterDepth$Ref);
      if (HasTemplateScope) {
        $this().Actions.ActOnReenterTemplateScope($this().getCurScope(), Class.TagOrTemplate);
        CurTemplateDepthTracker.$preInc();
      }
      boolean HasClassScope = !Class.TopLevelClass;
      ClassScope/*J*/= new ParseScope($this(), Scope.ScopeFlags.ClassScope | Scope.ScopeFlags.DeclScope, 
          HasClassScope);
      
      for (/*size_t*/int i = 0; $less_uint(i, Class.LateParsedDeclarations.size()); ++i) {
        Class.LateParsedDeclarations.$at(i).ParseLexedMethodDefs();
      }
    } finally {
      if (ClassScope != null) { ClassScope.$destroy(); }
      if (CurTemplateDepthTracker != null) { CurTemplateDepthTracker.$destroy(); }
      if (ClassTemplateScope != null) { ClassTemplateScope.$destroy(); }
    }
  }

//<editor-fold defaultstate="collapsed" desc="clang::Parser::ParseLexedMethodDef">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseCXXInlineMethods.cpp", line = 494,
   FQN="clang::Parser::ParseLexedMethodDef", NM="_ZN5clang6Parser19ParseLexedMethodDefERNS0_11LexedMethodE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseCXXInlineMethods.cpp -nm=_ZN5clang6Parser19ParseLexedMethodDefERNS0_11LexedMethodE")
  //</editor-fold>
  protected /*private*/ void ParseLexedMethodDef(final LexedMethod /*&*/ LM) {
    ParseScope TemplateScope = null;
    TemplateParameterDepthRAII CurTemplateDepthTracker = null;
    ParseScope FnScope = null;
    try {
      // If this is a member template, introduce the template parameter scope.
      TemplateScope/*J*/= new ParseScope($this(), Scope.ScopeFlags.TemplateParamScope, LM.TemplateScope);
      CurTemplateDepthTracker/*J*/= new TemplateParameterDepthRAII($this().TemplateParameterDepth$Ref);
      if (LM.TemplateScope) {
        $this().Actions.ActOnReenterTemplateScope($this().getCurScope(), LM.D);
        CurTemplateDepthTracker.$preInc();
      }
      assert (!LM.Toks.empty()) : "Empty body!";
      Token LastBodyToken = new Token(LM.Toks.back());
      Token BodyEnd/*J*/= new Token();
      BodyEnd.startToken();
      BodyEnd.setKind(tok.TokenKind.eof);
      BodyEnd.setLocation(LastBodyToken.getEndLoc());
      BodyEnd.setEofData(LM.D);
      LM.Toks.push_back(BodyEnd);
      // Append the current token at the end of the new token stream so that it
      // doesn't get lost.
      LM.Toks.push_back($this().Tok);
      $this().PP.EnterTokenStream(new ArrayRefToken(LM.Toks), true);
      
      // Consume the previously pushed token.
      $this().ConsumeAnyToken(/*ConsumeCodeCompletionTok=*/ true);
      assert ($this().Tok.isOneOf$T(tok.TokenKind.l_brace, tok.TokenKind.colon, tok.TokenKind.kw_try)) : "Inline method not starting with '{', ':' or 'try'";
      
      // Parse the method body. Function body parsing code is similar enough
      // to be re-used for method bodies as well.
      FnScope/*J*/= new ParseScope($this(), Scope.ScopeFlags.FnScope | Scope.ScopeFlags.DeclScope);
      $this().Actions.ActOnStartOfFunctionDef($this().getCurScope(), LM.D);
      if ($this().Tok.is(tok.TokenKind.kw_try)) {
        $this().ParseFunctionTryBlock(LM.D, FnScope);
        while ($this().Tok.isNot(tok.TokenKind.eof)) {
          $this().ConsumeAnyToken();
        }
        if ($this().Tok.is(tok.TokenKind.eof) && $eq_ptr($this().Tok.getEofData(), LM.D)) {
          $this().ConsumeAnyToken();
        }
        return;
      }
      if ($this().Tok.is(tok.TokenKind.colon)) {
        $this().ParseConstructorInitializer(LM.D);
        
        // Error recovery.
        if (!$this().Tok.is(tok.TokenKind.l_brace)) {
          FnScope.Exit();
          $this().Actions.ActOnFinishFunctionBody(LM.D, (Stmt /*P*/ )null);
          while ($this().Tok.isNot(tok.TokenKind.eof)) {
            $this().ConsumeAnyToken();
          }
          if ($this().Tok.is(tok.TokenKind.eof) && $eq_ptr($this().Tok.getEofData(), LM.D)) {
            $this().ConsumeAnyToken();
          }
          return;
        }
      } else {
        $this().Actions.ActOnDefaultCtorInitializers(LM.D);
      }
      assert (($this().Actions.getDiagnostics().hasErrorOccurred() || !isa(FunctionTemplateDecl.class, LM.D) || $less_uint(cast(FunctionTemplateDecl.class, LM.D).getTemplateParameters().getDepth(), $this().TemplateParameterDepth))) : "TemplateParameterDepth should be greater than the depth of current template being instantiated!";
      
      $this().ParseFunctionStatementBody(LM.D, FnScope);
      
      // Clear the late-template-parsed bit if we set it before.
      if ((LM.D != null)) {
        LM.D.getAsFunction().setLateTemplateParsed(false);
      }
      while ($this().Tok.isNot(tok.TokenKind.eof)) {
        $this().ConsumeAnyToken();
      }
      if ($this().Tok.is(tok.TokenKind.eof) && $eq_ptr($this().Tok.getEofData(), LM.D)) {
        $this().ConsumeAnyToken();
      }
      {
        
        FunctionDecl /*P*/ FD = dyn_cast_or_null(FunctionDecl.class, LM.D);
        if ((FD != null)) {
          if (isa(CXXMethodDecl.class, FD)
             || FD.isInIdentifierNamespace(Decl.IdentifierNamespace.IDNS_OrdinaryFriend)) {
            $this().Actions.ActOnFinishInlineFunctionDef(FD);
          }
        }
      }
    } finally {
      if (FnScope != null) { FnScope.$destroy(); }
      if (CurTemplateDepthTracker != null) { CurTemplateDepthTracker.$destroy(); }
      if (TemplateScope != null) { TemplateScope.$destroy(); }
    }
  }


/// ParseLexedMemberInitializers - We finished parsing the member specification
/// of a top (non-nested) C++ class. Now go over the stack of lexed data member
/// initializers that were collected during its parsing and parse them all.
//<editor-fold defaultstate="collapsed" desc="clang::Parser::ParseLexedMemberInitializers">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseCXXInlineMethods.cpp", line = 582,
   FQN="clang::Parser::ParseLexedMemberInitializers", NM="_ZN5clang6Parser28ParseLexedMemberInitializersERNS0_12ParsingClassE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseCXXInlineMethods.cpp -nm=_ZN5clang6Parser28ParseLexedMemberInitializersERNS0_12ParsingClassE")
  //</editor-fold>
  protected /*private*/ void ParseLexedMemberInitializers(final ParsingClass /*&*/ Class) {
    ParseScope ClassTemplateScope = null;
    TemplateParameterDepthRAII CurTemplateDepthTracker = null;
    ParseScope ClassScope = null;
    ParseScopeFlags ClassScopeFlags = null;
    try {
      boolean HasTemplateScope = !Class.TopLevelClass && Class.TemplateScope;
      ClassTemplateScope/*J*/= new ParseScope($this(), Scope.ScopeFlags.TemplateParamScope, 
          HasTemplateScope);
      CurTemplateDepthTracker/*J*/= new TemplateParameterDepthRAII($this().TemplateParameterDepth$Ref);
      if (HasTemplateScope) {
        $this().Actions.ActOnReenterTemplateScope($this().getCurScope(), Class.TagOrTemplate);
        CurTemplateDepthTracker.$preInc();
      }
      // Set or update the scope flags.
      boolean AlreadyHasClassScope = Class.TopLevelClass;
      /*uint*/int ScopeFlags = Scope.ScopeFlags.ClassScope | Scope.ScopeFlags.DeclScope;
      ClassScope/*J*/= new ParseScope($this(), ScopeFlags, !AlreadyHasClassScope);
      ClassScopeFlags/*J*/= new ParseScopeFlags($this(), ScopeFlags, AlreadyHasClassScope);
      if (!AlreadyHasClassScope) {
        $this().Actions.ActOnStartDelayedMemberDeclarations($this().getCurScope(), 
            Class.TagOrTemplate);
      }
      if (!Class.LateParsedDeclarations.empty()) {
        Sema.CXXThisScopeRAII ThisScope = null;
        try {
          // C++11 [expr.prim.general]p4:
          //   Otherwise, if a member-declarator declares a non-static data member 
          //  (9.2) of a class X, the expression this is a prvalue of type "pointer
          //  to X" within the optional brace-or-equal-initializer. It shall not 
          //  appear elsewhere in the member-declarator.
          ThisScope/*J*/= new Sema.CXXThisScopeRAII($this().Actions, Class.TagOrTemplate, 
              /*TypeQuals=*/ (/*uint*/int)0);
          
          for (/*size_t*/int i = 0; $less_uint(i, Class.LateParsedDeclarations.size()); ++i) {
            Class.LateParsedDeclarations.$at(i).ParseLexedMemberInitializers();
          }
        } finally {
          if (ThisScope != null) { ThisScope.$destroy(); }
        }
      }
      if (!AlreadyHasClassScope) {
        $this().Actions.ActOnFinishDelayedMemberDeclarations($this().getCurScope(), 
            Class.TagOrTemplate);
      }
      
      $this().Actions.ActOnFinishDelayedMemberInitializers(Class.TagOrTemplate);
    } finally {
      if (ClassScopeFlags != null) { ClassScopeFlags.$destroy(); }
      if (ClassScope != null) { ClassScope.$destroy(); }
      if (CurTemplateDepthTracker != null) { CurTemplateDepthTracker.$destroy(); }
      if (ClassTemplateScope != null) { ClassTemplateScope.$destroy(); }
    }
  }

//<editor-fold defaultstate="collapsed" desc="clang::Parser::ParseLexedMemberInitializer">
@Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseCXXInlineMethods.cpp", line = 622,
   FQN="clang::Parser::ParseLexedMemberInitializer", NM="_ZN5clang6Parser27ParseLexedMemberInitializerERNS0_27LateParsedMemberInitializerE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseCXXInlineMethods.cpp -nm=_ZN5clang6Parser27ParseLexedMemberInitializerERNS0_27LateParsedMemberInitializerE")
  //</editor-fold>
  protected /*private*/ void ParseLexedMemberInitializer(final LateParsedMemberInitializer /*&*/ MI) {
    if (!(MI.Field != null) || MI.Field.isInvalidDecl()) {
      return;
    }
    
    // Append the current token at the end of the new token stream so that it
    // doesn't get lost.
    MI.Toks.push_back($this().Tok);
    $this().PP.EnterTokenStream(new ArrayRefToken(MI.Toks), true);
    
    // Consume the previously pushed token.
    $this().ConsumeAnyToken(/*ConsumeCodeCompletionTok=*/ true);
    
    SourceLocation EqualLoc/*J*/= new SourceLocation();
    
    $this().Actions.ActOnStartCXXInClassMemberInitializer();
    
    ActionResultTTrue<Expr /*P*/ > Init = $this().ParseCXXMemberInitializer(MI.Field, /*IsFunction=*/ false, 
        EqualLoc);
    
    $this().Actions.ActOnFinishCXXInClassMemberInitializer(MI.Field, new SourceLocation(EqualLoc), 
        Init.get());
    
    // The next token should be our artificial terminating EOF token.
    if ($this().Tok.isNot(tok.TokenKind.eof)) {
      if (!Init.isInvalid()) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          SourceLocation EndLoc = $this().PP.getLocForEndOfToken(/*NO_COPY*/$this().PrevTokLocation);
          if (!EndLoc.isValid()) {
            EndLoc.$assignMove($this().Tok.getLocation());
          }
          // No fixit; we can't recover as if there were a semicolon here.
          $c$.clean($c$.track($this().Diag(new SourceLocation(EndLoc), diag.err_expected_semi_decl_list)));
        } finally {
          $c$.$destroy();
        }
      }
      
      // Consume tokens until we hit the artificial EOF.
      while ($this().Tok.isNot(tok.TokenKind.eof)) {
        $this().ConsumeAnyToken();
      }
    }
    // Make sure this is *our* artificial EOF token.
    if ($eq_ptr($this().Tok.getEofData(), MI.Field)) {
      $this().ConsumeAnyToken();
    }
  }


/// \brief Consume tokens and store them in the passed token container until
/// we've passed the try keyword and constructor initializers and have consumed
/// the opening brace of the function body. The opening brace will be consumed
/// if and only if there was no error.
///
/// \return True on error.
//<editor-fold defaultstate="collapsed" desc="clang::Parser::ConsumeAndStoreFunctionPrologue">
@Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseCXXInlineMethods.cpp", line = 769,
   FQN="clang::Parser::ConsumeAndStoreFunctionPrologue", NM="_ZN5clang6Parser31ConsumeAndStoreFunctionPrologueERN4llvm11SmallVectorINS_5TokenELj4EEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseCXXInlineMethods.cpp -nm=_ZN5clang6Parser31ConsumeAndStoreFunctionPrologueERN4llvm11SmallVectorINS_5TokenELj4EEE")
  //</editor-fold>
  protected /*private*/ boolean ConsumeAndStoreFunctionPrologue(final SmallVectorToken /*&*/ Toks) {
    if ($this().Tok.is(tok.TokenKind.kw_try)) {
      Toks.push_back($this().Tok);
      $this().ConsumeToken();
    }
    if ($this().Tok.isNot(tok.TokenKind.colon)) {
      // Easy case, just a function body.
      
      // Grab any remaining garbage to be diagnosed later. We stop when we reach a
      // brace: an opening one is the function body, while a closing one probably
      // means we've reached the end of the class.
      $this().ConsumeAndStoreUntil(tok.TokenKind.l_brace, tok.TokenKind.r_brace, Toks, 
          /*StopAtSemi=*/ true, 
          /*ConsumeFinalToken=*/ false);
      if ($this().Tok.isNot(tok.TokenKind.l_brace)) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          return $c$.clean($out_DiagnosticBuilder$C_TokenKind($c$.track($this().Diag($this().Tok.getLocation(), diag.err_expected)), tok.TokenKind.l_brace).$bool());
        } finally {
          $c$.$destroy();
        }
      }
      
      Toks.push_back($this().Tok);
      $this().ConsumeBrace();
      return false;
    }
    
    Toks.push_back($this().Tok);
    $this().ConsumeToken();
    
    // We can't reliably skip over a mem-initializer-id, because it could be
    // a template-id involving not-yet-declared names. Given:
    //
    //   S ( ) : a < b < c > ( e )
    //
    // 'e' might be an initializer or part of a template argument, depending
    // on whether 'b' is a template.
    
    // Track whether we might be inside a template argument. We can give
    // significantly better diagnostics if we know that we're not.
    boolean MightBeTemplateArgument = false;
    while (true) {
      // Skip over the mem-initializer-id, if possible.
      if ($this().Tok.is(tok.TokenKind.kw_decltype)) {
        Toks.push_back($this().Tok);
        SourceLocation OpenLoc = $this().ConsumeToken();
        if ($this().Tok.isNot(tok.TokenKind.l_paren)) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            return $c$.clean($out_DiagnosticBuilder$C_char$ptr$C($c$.track($this().Diag($this().Tok.getLocation(), diag.err_expected_lparen_after)), 
                /*KEEP_STR*/$decltype).$bool());
          } finally {
            $c$.$destroy();
          }
        }
        Toks.push_back($this().Tok);
        $this().ConsumeParen();
        if (!$this().ConsumeAndStoreUntil(tok.TokenKind.r_paren, Toks, /*StopAtSemi=*/ true)) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            $c$.clean($out_DiagnosticBuilder$C_TokenKind($c$.track($this().Diag($this().Tok.getLocation(), diag.err_expected)), tok.TokenKind.r_paren));
            $c$.clean($out_DiagnosticBuilder$C_TokenKind($c$.track($this().Diag(new SourceLocation(OpenLoc), diag.note_matching)), tok.TokenKind.l_paren));
            return true;
          } finally {
            $c$.$destroy();
          }
        }
      }
      do {
        // Walk over a component of a nested-name-specifier.
        if ($this().Tok.is(tok.TokenKind.coloncolon)) {
          Toks.push_back($this().Tok);
          $this().ConsumeToken();
          if ($this().Tok.is(tok.TokenKind.kw_template)) {
            Toks.push_back($this().Tok);
            $this().ConsumeToken();
          }
        }
        if ($this().Tok.isOneOf(tok.TokenKind.identifier, tok.TokenKind.kw_template)) {
          Toks.push_back($this().Tok);
          $this().ConsumeToken();
        } else if ($this().Tok.is(tok.TokenKind.code_completion)) {
          Toks.push_back($this().Tok);
          $this().ConsumeCodeCompletionToken();
          // Consume the rest of the initializers permissively.
          // FIXME: We should be able to perform code-completion here even if
          //        there isn't a subsequent '{' token.
          MightBeTemplateArgument = true;
          break;
        } else {
          break;
        }
      } while ($this().Tok.is(tok.TokenKind.coloncolon));
      if ($this().Tok.is(tok.TokenKind.less)) {
        MightBeTemplateArgument = true;
      }
      if (MightBeTemplateArgument) {
        // We may be inside a template argument list. Grab up to the start of the
        // next parenthesized initializer or braced-init-list. This *might* be the
        // initializer, or it might be a subexpression in the template argument
        // list.
        // FIXME: Count angle brackets, and clear MightBeTemplateArgument
        //        if all angles are closed.
        if (!$this().ConsumeAndStoreUntil(tok.TokenKind.l_paren, tok.TokenKind.l_brace, Toks, 
            /*StopAtSemi=*/ true, 
            /*ConsumeFinalToken=*/ false)) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            // We're not just missing the initializer, we're also missing the
            // function body!
            return $c$.clean($out_DiagnosticBuilder$C_TokenKind($c$.track($this().Diag($this().Tok.getLocation(), diag.err_expected)), tok.TokenKind.l_brace).$bool());
          } finally {
            $c$.$destroy();
          }
        }
      } else if ($this().Tok.isNot(tok.TokenKind.l_paren) && $this().Tok.isNot(tok.TokenKind.l_brace)) {
        // We found something weird in a mem-initializer-id.
        if ($this().getLangOpts().CPlusPlus11) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            return $c$.clean($out_DiagnosticBuilder$C_TokenKind($out_DiagnosticBuilder$C_TokenKind($c$.track($this().Diag($this().Tok.getLocation(), diag.err_expected_either)), 
                    tok.TokenKind.l_paren), tok.TokenKind.l_brace).$bool());
          } finally {
            $c$.$destroy();
          }
        } else {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            return $c$.clean($out_DiagnosticBuilder$C_TokenKind($c$.track($this().Diag($this().Tok.getLocation(), diag.err_expected)), tok.TokenKind.l_paren).$bool());
          } finally {
            $c$.$destroy();
          }
        }
      }
      
      /*tok.TokenKind*/char kind = $this().Tok.getKind();
      Toks.push_back($this().Tok);
      boolean IsLParen = (kind == tok.TokenKind.l_paren);
      SourceLocation OpenLoc = $this().Tok.getLocation();
      if (IsLParen) {
        $this().ConsumeParen();
      } else {
        assert (kind == tok.TokenKind.l_brace) : "Must be left paren or brace here.";
        $this().ConsumeBrace();
        // In C++03, this has to be the start of the function body, which
        // means the initializer is malformed; we'll diagnose it later.
        if (!$this().getLangOpts().CPlusPlus11) {
          return false;
        }
      }
      
      // Grab the initializer (or the subexpression of the template argument).
      // FIXME: If we support lambdas here, we'll need to set StopAtSemi to false
      //        if we might be inside the braces of a lambda-expression.
      /*tok.TokenKind*/char CloseKind = IsLParen ? tok.TokenKind.r_paren : tok.TokenKind.r_brace;
      if (!$this().ConsumeAndStoreUntil(CloseKind, Toks, /*StopAtSemi=*/ true)) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_DiagnosticBuilder$C_TokenKind($c$.track($this().Diag($this().Tok, diag.err_expected)), CloseKind));
          $c$.clean($out_DiagnosticBuilder$C_TokenKind($c$.track($this().Diag(new SourceLocation(OpenLoc), diag.note_matching)), kind));
          return true;
        } finally {
          $c$.$destroy();
        }
      }
      
      // Grab pack ellipsis, if present.
      if ($this().Tok.is(tok.TokenKind.ellipsis)) {
        Toks.push_back($this().Tok);
        $this().ConsumeToken();
      }
      
      // If we know we just consumed a mem-initializer, we must have ',' or '{'
      // next.
      if ($this().Tok.is(tok.TokenKind.comma)) {
        Toks.push_back($this().Tok);
        $this().ConsumeToken();
      } else if ($this().Tok.is(tok.TokenKind.l_brace)) {
        // This is the function body if the ')' or '}' is immediately followed by
        // a '{'. That cannot happen within a template argument, apart from the
        // case where a template argument contains a compound literal:
        //
        //   S ( ) : a < b < c > ( d ) { }
        //   // End of declaration, or still inside the template argument?
        //
        // ... and the case where the template argument contains a lambda:
        //
        //   S ( ) : a < 0 && b < c > ( d ) + [ ] ( ) { return 0; }
        //     ( ) > ( ) { }
        //
        // FIXME: Disambiguate these cases. Note that the latter case is probably
        //        going to be made ill-formed by core issue 1607.
        Toks.push_back($this().Tok);
        $this().ConsumeBrace();
        return false;
      } else if (!MightBeTemplateArgument) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          return $c$.clean($out_DiagnosticBuilder$C_TokenKind($out_DiagnosticBuilder$C_TokenKind($c$.track($this().Diag($this().Tok.getLocation(), diag.err_expected_either)), tok.TokenKind.l_brace), 
              tok.TokenKind.comma).$bool());
        } finally {
          $c$.$destroy();
        }
      }
    }
  }


/// ConsumeAndStoreInitializer - Consume and store the token at the passed token
/// container until the end of the current initializer expression (either a
/// default argument or an in-class initializer for a non-static data member).
///
/// Returns \c true if we reached the end of something initializer-shaped,
/// \c false if we bailed out.
//<editor-fold defaultstate="collapsed" desc="clang::Parser::ConsumeAndStoreInitializer">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*goto*/,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseCXXInlineMethods.cpp", line = 1004,
   FQN="clang::Parser::ConsumeAndStoreInitializer", NM="_ZN5clang6Parser26ConsumeAndStoreInitializerERN4llvm11SmallVectorINS_5TokenELj4EEENS0_14CachedInitKindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseCXXInlineMethods.cpp -nm=_ZN5clang6Parser26ConsumeAndStoreInitializerERN4llvm11SmallVectorINS_5TokenELj4EEENS0_14CachedInitKindE")
  //</editor-fold>
  protected /*private*/ boolean ConsumeAndStoreInitializer(final SmallVectorToken /*&*/ Toks, 
                            CachedInitKind CIK) {
    // We always want this function to consume at least one token if not at EOF.
    boolean IsFirstToken = true;
    
    // Number of possible unclosed <s we've seen so far. These might be templates,
    // and might not, but if there were none of them (or we know for sure that
    // we're within a template), we can avoid a tentative parse.
    /*uint*/int AngleCount = 0;
    /*uint*/int KnownTemplateCount = 0;
    while (true) {
      boolean $consume_token = false;
      switch ($this().Tok.getKind()) {
       case tok.TokenKind.comma:
        // If we might be in a template, perform a tentative parse to check.
        if (!(AngleCount != 0)) {
          // Not a template argument: this is the end of the initializer.
          return true;
        }
        if ((KnownTemplateCount != 0)) {
          $consume_token = true; break/*switch*/;
        }
        {
          UnannotatedTentativeParsingAction PA = null;
          Sema.TentativeAnalysisScope Scope = null;
          try {
            PA/*J*/= new UnannotatedTentativeParsingAction(/*Deref*/$this(), 
                CIK == CachedInitKind.CIK_DefaultInitializer ? tok.TokenKind.semi : tok.TokenKind.r_paren);
            Scope/*J*/= new Sema.TentativeAnalysisScope($this().Actions);
            
            TPResult Result = TPResult.Error;
            $this().ConsumeToken();
            switch (CIK) {
             case CIK_DefaultInitializer:
              Result = $this().TryParseInitDeclaratorList();
              // If we parsed a complete, ambiguous init-declarator-list, this
              // is only syntactically-valid if it's followed by a semicolon.
              if (Result == TPResult.Ambiguous && $this().Tok.isNot(tok.TokenKind.semi)) {
                Result = TPResult.False;
              }
              break;
             case CIK_DefaultArgument:
              bool$ptr InvalidAsDeclaration = create_bool$ptr(false);
              Result = $this().TryParseParameterDeclarationClause($AddrOf(InvalidAsDeclaration), /*VersusTemplateArgument=*/ true);
              // If this is an expression or a declaration with a missing
              // 'typename', assume it's not a declaration.
              if (Result == TPResult.Ambiguous && InvalidAsDeclaration.$star()) {
                Result = TPResult.False;
              }
              break;
            }
            
            // If what follows could be a declaration, it is a declaration.
            if (Result != TPResult.False && Result != TPResult.Error) {
              PA.Revert();
              return true;
            }
            
            // In the uncommon case that we decide the following tokens are part
            // of a template argument, revert any annotations we've performed in
            // those tokens. We're not going to look them up until we've parsed
            // the rest of the class, and that might add more declarations.
            PA.RevertAnnotations();
          } finally {
            if (Scope != null) { Scope.$destroy(); }
            if (PA != null) { PA.$destroy(); }
          }
        }
        
        // Keep going. We know we're inside a template argument list now.
        ++KnownTemplateCount;
        $consume_token = true; break/*switch*/;
       case tok.TokenKind.eof:
       case tok.TokenKind.annot_module_begin:
       case tok.TokenKind.annot_module_end:
       case tok.TokenKind.annot_module_include:
        // Ran out of tokens.
        return false;
       case tok.TokenKind.less:
        // FIXME: A '<' can only start a template-id if it's preceded by an
        // identifier, an operator-function-id, or a literal-operator-id.
        ++AngleCount;
        $consume_token = true; break/*switch*/;
       case tok.TokenKind.question:
        // In 'a ? b : c', 'b' can contain an unparenthesized comma. If it does,
        // that is *never* the end of the initializer. Skip to the ':'.
        if (!$this().ConsumeAndStoreConditional(Toks)) {
          return false;
        }
        break;
       case tok.TokenKind.greatergreatergreater:
        if (!$this().getLangOpts().CPlusPlus11) {
          $consume_token = true; break/*switch*/;
        }
        if ((AngleCount != 0)) {
          --AngleCount;
        }
        if ((KnownTemplateCount != 0)) {
          --KnownTemplateCount;
        }
       case tok.TokenKind.greatergreater:
        // Fall through.
        if (!$this().getLangOpts().CPlusPlus11) {
          $consume_token = true; break/*switch*/;
        }
        if ((AngleCount != 0)) {
          --AngleCount;
        }
        if ((KnownTemplateCount != 0)) {
          --KnownTemplateCount;
        }
       case tok.TokenKind.greater:
        // Fall through.
        if ((AngleCount != 0)) {
          --AngleCount;
        }
        if ((KnownTemplateCount != 0)) {
          --KnownTemplateCount;
        }
        $consume_token = true; break/*switch*/;
       case tok.TokenKind.kw_template:
        // 'template' identifier '<' is known to start a template argument list,
        // and can be used to disambiguate the parse.
        // FIXME: Support all forms of 'template' unqualified-id '<'.
        Toks.push_back($this().Tok);
        $this().ConsumeToken();
        if ($this().Tok.is(tok.TokenKind.identifier)) {
          Toks.push_back($this().Tok);
          $this().ConsumeToken();
          if ($this().Tok.is(tok.TokenKind.less)) {
            ++AngleCount;
            ++KnownTemplateCount;
            Toks.push_back($this().Tok);
            $this().ConsumeToken();
          }
        }
        break;
       case tok.TokenKind.kw_operator:
        // If 'operator' precedes other punctuation, that punctuation loses
        // its special behavior.
        Toks.push_back($this().Tok);
        $this().ConsumeToken();
        switch ($this().Tok.getKind()) {
         case tok.TokenKind.comma:
         case tok.TokenKind.greatergreatergreater:
         case tok.TokenKind.greatergreater:
         case tok.TokenKind.greater:
         case tok.TokenKind.less:
          Toks.push_back($this().Tok);
          $this().ConsumeToken();
          break;
         default:
          break;
        }
        break;
       case tok.TokenKind.l_paren:
        // Recursively consume properly-nested parens.
        Toks.push_back($this().Tok);
        $this().ConsumeParen();
        $this().ConsumeAndStoreUntil(tok.TokenKind.r_paren, Toks, /*StopAtSemi=*/ false);
        break;
       case tok.TokenKind.l_square:
        // Recursively consume properly-nested square brackets.
        Toks.push_back($this().Tok);
        $this().ConsumeBracket();
        $this().ConsumeAndStoreUntil(tok.TokenKind.r_square, Toks, /*StopAtSemi=*/ false);
        break;
       case tok.TokenKind.l_brace:
        // Recursively consume properly-nested braces.
        Toks.push_back($this().Tok);
        $this().ConsumeBrace();
        $this().ConsumeAndStoreUntil(tok.TokenKind.r_brace, Toks, /*StopAtSemi=*/ false);
        break;
       case tok.TokenKind.r_paren:
        
        // Okay, we found a ']' or '}' or ')', which we think should be balanced.
        // Since the user wasn't looking for this token (if they were, it would
        // already be handled), this isn't balanced.  If there is a LHS token at a
        // higher level, we will assume that this matches the unbalanced token
        // and return it.  Otherwise, this is a spurious RHS token, which we
        // consume and pass on to downstream code to diagnose.
        if (CIK == CachedInitKind.CIK_DefaultArgument) {
          return true; // End of the default argument.
        }
        if (($this().ParenCount != 0) && !IsFirstToken) {
          return false;
        }
        Toks.push_back($this().Tok);
        $this().ConsumeParen();
        continue;
       case tok.TokenKind.r_square:
        if (($this().BracketCount != 0) && !IsFirstToken) {
          return false;
        }
        Toks.push_back($this().Tok);
        $this().ConsumeBracket();
        continue;
       case tok.TokenKind.r_brace:
        if (($this().BraceCount != 0) && !IsFirstToken) {
          return false;
        }
        Toks.push_back($this().Tok);
        $this().ConsumeBrace();
        continue;
       case tok.TokenKind.code_completion:
        Toks.push_back($this().Tok);
        $this().ConsumeCodeCompletionToken();
        break;
       case tok.TokenKind.string_literal:
       case tok.TokenKind.wide_string_literal:
       case tok.TokenKind.utf8_string_literal:
       case tok.TokenKind.utf16_string_literal:
       case tok.TokenKind.utf32_string_literal:
        Toks.push_back($this().Tok);
        $this().ConsumeStringToken();
        break;
       case tok.TokenKind.semi:
        if (CIK == CachedInitKind.CIK_DefaultInitializer) {
          return true; // End of the default initializer.
          // FALL THROUGH.
        }
       default:
       $consume_token = true; 
        break;
      }
      if ($consume_token) {
        Toks.push_back($this().Tok);
        $this().ConsumeToken();
      }
      IsFirstToken = false;
    }
  }


/// \brief Consume and store tokens from the '?' to the ':' in a conditional
/// expression.
//<editor-fold defaultstate="collapsed" desc="clang::Parser::ConsumeAndStoreConditional">
@Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseCXXInlineMethods.cpp", line = 941,
   FQN="clang::Parser::ConsumeAndStoreConditional", NM="_ZN5clang6Parser26ConsumeAndStoreConditionalERN4llvm11SmallVectorINS_5TokenELj4EEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseCXXInlineMethods.cpp -nm=_ZN5clang6Parser26ConsumeAndStoreConditionalERN4llvm11SmallVectorINS_5TokenELj4EEE")
  //</editor-fold>
  protected /*private*/ boolean ConsumeAndStoreConditional(final SmallVectorToken /*&*/ Toks) {
    // Consume '?'.
    assert ($this().Tok.is(tok.TokenKind.question));
    Toks.push_back($this().Tok);
    $this().ConsumeToken();
    while ($this().Tok.isNot(tok.TokenKind.colon)) {
      if (!$this().ConsumeAndStoreUntil(tok.TokenKind.question, tok.TokenKind.colon, Toks, 
          /*StopAtSemi=*/ true, 
          /*ConsumeFinalToken=*/ false)) {
        return false;
      }
      
      // If we found a nested conditional, consume it.
      if ($this().Tok.is(tok.TokenKind.question) && !$this().ConsumeAndStoreConditional(Toks)) {
        return false;
      }
    }
    
    // Consume ':'.
    Toks.push_back($this().Tok);
    $this().ConsumeToken();
    return true;
  }


/// ConsumeAndStoreUntil - Consume and store the token at the passed token
/// container until the token 'T' is reached (which gets
/// consumed/stored too, if ConsumeFinalToken).
/// If StopAtSemi is true, then we will stop early at a ';' character.
/// Returns true if token 'T1' or 'T2' was found.
/// NOTE: This is a specialized version of Parser::SkipUntil.
//<editor-fold defaultstate="collapsed" desc="clang::Parser::ConsumeAndStoreUntil">
@Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseCXXInlineMethods.cpp", line = 669,
   FQN="clang::Parser::ConsumeAndStoreUntil", NM="_ZN5clang6Parser20ConsumeAndStoreUntilENS_3tok9TokenKindES2_RN4llvm11SmallVectorINS_5TokenELj4EEEbb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseCXXInlineMethods.cpp -nm=_ZN5clang6Parser20ConsumeAndStoreUntilENS_3tok9TokenKindES2_RN4llvm11SmallVectorINS_5TokenELj4EEEbb")
  //</editor-fold>
  protected /*private*/ boolean ConsumeAndStoreUntil(/*tok.TokenKind*/char T1, /*tok.TokenKind*/char T2, 
                      final SmallVectorToken /*&*/ Toks) {
    return $this().ConsumeAndStoreUntil(T1, T2, 
                      Toks, 
                      true, true);
  }
  protected /*private*/ boolean ConsumeAndStoreUntil(/*tok.TokenKind*/char T1, /*tok.TokenKind*/char T2, 
                      final SmallVectorToken /*&*/ Toks, 
                      boolean StopAtSemi/*= true*/) {
    return $this().ConsumeAndStoreUntil(T1, T2, 
                      Toks, 
                      StopAtSemi, true);
  }
  protected /*private*/ boolean ConsumeAndStoreUntil(/*tok.TokenKind*/char T1, /*tok.TokenKind*/char T2, 
                      final SmallVectorToken /*&*/ Toks, 
                      boolean StopAtSemi/*= true*/, boolean ConsumeFinalToken/*= true*/) {
    // We always want this function to consume at least one token if the first
    // token isn't T and if not at EOF.
    boolean isFirstTokenConsumed = true;
    while (true) {
      // If we found one of the tokens, stop and return true.
      if ($this().Tok.is(T1) || $this().Tok.is(T2)) {
        if (ConsumeFinalToken) {
          Toks.push_back($this().Tok);
          $this().ConsumeAnyToken();
        }
        return true;
      }
      switch ($this().Tok.getKind()) {
       case tok.TokenKind.eof:
       case tok.TokenKind.annot_module_begin:
       case tok.TokenKind.annot_module_end:
       case tok.TokenKind.annot_module_include:
        // Ran out of tokens.
        return false;
       case tok.TokenKind.l_paren:
        // Recursively consume properly-nested parens.
        Toks.push_back($this().Tok);
        $this().ConsumeParen();
        $this().ConsumeAndStoreUntil(tok.TokenKind.r_paren, Toks, /*StopAtSemi=*/ false);
        break;
       case tok.TokenKind.l_square:
        // Recursively consume properly-nested square brackets.
        Toks.push_back($this().Tok);
        $this().ConsumeBracket();
        $this().ConsumeAndStoreUntil(tok.TokenKind.r_square, Toks, /*StopAtSemi=*/ false);
        break;
       case tok.TokenKind.l_brace:
        // Recursively consume properly-nested braces.
        Toks.push_back($this().Tok);
        $this().ConsumeBrace();
        $this().ConsumeAndStoreUntil(tok.TokenKind.r_brace, Toks, /*StopAtSemi=*/ false);
        break;
       case tok.TokenKind.r_paren:
        
        // Okay, we found a ']' or '}' or ')', which we think should be balanced.
        // Since the user wasn't looking for this token (if they were, it would
        // already be handled), this isn't balanced.  If there is a LHS token at a
        // higher level, we will assume that this matches the unbalanced token
        // and return it.  Otherwise, this is a spurious RHS token, which we skip.
        if (($this().ParenCount != 0) && !isFirstTokenConsumed) {
          return false; // Matches something.
        }
        Toks.push_back($this().Tok);
        $this().ConsumeParen();
        break;
       case tok.TokenKind.r_square:
        if (($this().BracketCount != 0) && !isFirstTokenConsumed) {
          return false; // Matches something.
        }
        Toks.push_back($this().Tok);
        $this().ConsumeBracket();
        break;
       case tok.TokenKind.r_brace:
        if (($this().BraceCount != 0) && !isFirstTokenConsumed) {
          return false; // Matches something.
        }
        Toks.push_back($this().Tok);
        $this().ConsumeBrace();
        break;
       case tok.TokenKind.code_completion:
        Toks.push_back($this().Tok);
        $this().ConsumeCodeCompletionToken();
        break;
       case tok.TokenKind.string_literal:
       case tok.TokenKind.wide_string_literal:
       case tok.TokenKind.utf8_string_literal:
       case tok.TokenKind.utf16_string_literal:
       case tok.TokenKind.utf32_string_literal:
        Toks.push_back($this().Tok);
        $this().ConsumeStringToken();
        break;
       case tok.TokenKind.semi:
        if (StopAtSemi) {
          return false;
        }
       default:
        // consume this token.
        Toks.push_back($this().Tok);
        $this().ConsumeToken();
        break;
      }
      isFirstTokenConsumed = false;
    }
  }

} // END OF class Parser_ParseCXXInlineMethods
