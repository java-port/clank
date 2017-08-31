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
import static org.clang.parse.impl.ParseTemplateStatics.*;


//<editor-fold defaultstate="collapsed" desc="static type Parser_ParseTemplate">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -empty-body -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType -split-class=clang::Parser@this -extends=Parser_ParseStmtAsm ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseTemplate.cpp -nm=_ZN5clang6Parser18ParseTypeParameterEjj;_ZN5clang6Parser21ParseTemplateArgumentEv;_ZN5clang6Parser22IsTemplateArgumentListEj;_ZN5clang6Parser22ParseTemplateParameterEjj;_ZN5clang6Parser23AnnotateTemplateIdTokenENS_9OpaquePtrINS_12TemplateNameEEENS_16TemplateNameKindERNS_12CXXScopeSpecENS_14SourceLocationERNS_13UnqualifiedIdEb;_ZN5clang6Parser23ParseTemplateParametersEjRN4llvm15SmallVectorImplIPNS_4DeclEEERNS_14SourceLocationES8_;_ZN5clang6Parser25DiagnoseMisplacedEllipsisENS_14SourceLocationES1_bb;_ZN5clang6Parser25ParseLateTemplatedFuncDefERNS_18LateParsedTemplateE;_ZN5clang6Parser25ParseTemplateArgumentListERN4llvm11SmallVectorINS_22ParsedTemplateArgumentELj16EEE;_ZN5clang6Parser26LateTemplateParserCallbackEPvRNS_18LateParsedTemplateE;_ZN5clang6Parser26ParseExplicitInstantiationEjNS_14SourceLocationES1_RS1_NS_15AccessSpecifierE;_ZN5clang6Parser26ParseTemplateParameterListEjRN4llvm15SmallVectorImplIPNS_4DeclEEE;_ZN5clang6Parser29AnnotateTemplateIdTokenAsTypeEv;_ZN5clang6Parser29ParseNonTypeTemplateParameterEjj;_ZN5clang6Parser29ParseTemplateTemplateArgumentEv;_ZN5clang6Parser30ParseGreaterThanInTemplateListERNS_14SourceLocationEbb;_ZN5clang6Parser30ParseTemplateTemplateParameterEjj;_ZN5clang6Parser30isStartOfTemplateTypeParameterEv;_ZN5clang6Parser32ParseTemplateIdAfterTemplateNameENS_9OpaquePtrINS_12TemplateNameEEENS_14SourceLocationERKNS_12CXXScopeSpecEbRS4_RN4llvm11SmallVectorINS_22ParsedTemplateArgumentELj16EEES8_;_ZN5clang6Parser33LexTemplateFunctionForLateParsingERN4llvm11SmallVectorINS_5TokenELj4EEE;_ZN5clang6Parser35ParseSingleDeclarationAfterTemplateEjRKNS0_18ParsedTemplateInfoERNS_21ParsingDeclRAIIObjectERNS_14SourceLocationENS_15AccessSpecifierEPNS_13AttributeListE;_ZN5clang6Parser36ParseDeclarationStartingWithTemplateEjRNS_14SourceLocationENS_15AccessSpecifierEPNS_13AttributeListE;_ZN5clang6Parser37DiagnoseMisplacedEllipsisInDeclaratorENS_14SourceLocationERNS_10DeclaratorE;_ZN5clang6Parser40ParseTemplateDeclarationOrSpecializationEjRNS_14SourceLocationENS_15AccessSpecifierEPNS_13AttributeListE; -static-type=Parser_ParseTemplate -package=org.clang.parse")
//</editor-fold>
public class Parser_ParseTemplate extends Parser_ParseStmtAsm {
private final /*split clang::Parser*/ Parser $this() { return (Parser)this; }


/// \brief Lex a delayed template function for late parsing.
//<editor-fold defaultstate="collapsed" desc="clang::Parser::LexTemplateFunctionForLateParsing">
@Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseTemplate.cpp", line = 1421,
   FQN="clang::Parser::LexTemplateFunctionForLateParsing", NM="_ZN5clang6Parser33LexTemplateFunctionForLateParsingERN4llvm11SmallVectorINS_5TokenELj4EEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseTemplate.cpp -nm=_ZN5clang6Parser33LexTemplateFunctionForLateParsingERN4llvm11SmallVectorINS_5TokenELj4EEE")
  //</editor-fold>
  protected /*private*/ void LexTemplateFunctionForLateParsing(final SmallVectorToken /*&*/ Toks) {
    /*tok.TokenKind*/char kind = $this().Tok.getKind();
    if (!$this().ConsumeAndStoreFunctionPrologue(Toks)) {
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
  }


/// \brief Late parse a C++ function template in Microsoft mode.
//<editor-fold defaultstate="collapsed" desc="clang::Parser::ParseLateTemplatedFuncDef">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseTemplate.cpp", line = 1331,
   FQN="clang::Parser::ParseLateTemplatedFuncDef", NM="_ZN5clang6Parser25ParseLateTemplatedFuncDefERNS_18LateParsedTemplateE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseTemplate.cpp -nm=_ZN5clang6Parser25ParseLateTemplatedFuncDefERNS_18LateParsedTemplateE")
  //</editor-fold>
  protected /*private*/ void ParseLateTemplatedFuncDef(final LateParsedTemplate /*&*/ LPT) {
    TemplateParameterDepthRAII CurTemplateDepthTracker = null;
    Sema.ContextRAII GlobalSavedContext = null;
    ParseScope FnScope = null;
    Sema.ContextRAII FunctionSavedContext = null;
    try {
      if (!(LPT.D != null)) {
        return;
      }
      
      // Get the FunctionDecl.
      FunctionDecl /*P*/ FunD = LPT.D.getAsFunction();
      // Track template parameter depth.
      CurTemplateDepthTracker/*J*/= new TemplateParameterDepthRAII($this().TemplateParameterDepth$Ref);
      
      // To restore the context after late parsing.
      GlobalSavedContext/*J*/= new Sema.ContextRAII($this().Actions, $this().Actions.Context.getTranslationUnitDecl());
      
      SmallVector<ParseScope /*P*/ > TemplateParamScopeStack/*J*/= new SmallVector<ParseScope /*P*/ >(4, (ParseScope /*P*/ )null);
      
      // Get the list of DeclContexts to reenter.
      SmallVector<DeclContext /*P*/ > DeclContextsToReenter/*J*/= new SmallVector<DeclContext /*P*/ >(4, (DeclContext /*P*/ )null);
      DeclContext /*P*/ DD = FunD;
      while ((DD != null) && !DD.isTranslationUnit()) {
        DeclContextsToReenter.push_back(DD);
        DD = DD.getLexicalParent();
      }
      
      // Reenter template scopes from outermost to innermost.
      std.reverse_iterator<DeclContext /*P*/> II = DeclContextsToReenter.rbegin();
      for (; $noteq_reverse_iterator$C(II, DeclContextsToReenter.rend()); II.$preInc()) {
        TemplateParamScopeStack.push_back(new ParseScope($this(), 
                Scope.ScopeFlags.TemplateParamScope));
        /*uint*/int NumParamLists = $this().Actions.ActOnReenterTemplateScope($this().getCurScope(), cast(Decl.class, II.$star()));
        CurTemplateDepthTracker.addDepth(NumParamLists);
        if (II.$star() != FunD) {
          TemplateParamScopeStack.push_back(new ParseScope($this(), Scope.ScopeFlags.DeclScope));
          $this().Actions.PushDeclContext($this().Actions.getCurScope(), II.$star());
        }
      }
      assert (!LPT.Toks.empty()) : "Empty body!";
      
      // Append the current token at the end of the new token stream so that it
      // doesn't get lost.
      LPT.Toks.push_back($this().Tok);
      $this().PP.EnterTokenStream(new ArrayRefToken(LPT.Toks), true);
      
      // Consume the previously pushed token.
      $this().ConsumeAnyToken(/*ConsumeCodeCompletionTok=*/ true);
      assert ($this().Tok.isOneOf$T(tok.TokenKind.l_brace, tok.TokenKind.colon, tok.TokenKind.kw_try)) : "Inline method not starting with '{', ':' or 'try'";
      
      // Parse the method body. Function body parsing code is similar enough
      // to be re-used for method bodies as well.
      FnScope/*J*/= new ParseScope($this(), Scope.ScopeFlags.FnScope | Scope.ScopeFlags.DeclScope);
      
      // Recreate the containing function DeclContext.
      FunctionSavedContext/*J*/= new Sema.ContextRAII($this().Actions, 
          $this().Actions.getContainingDC(FunD));
      
      $this().Actions.ActOnStartOfFunctionDef($this().getCurScope(), FunD);
      if ($this().Tok.is(tok.TokenKind.kw_try)) {
        $this().ParseFunctionTryBlock(LPT.D, FnScope);
      } else {
        if ($this().Tok.is(tok.TokenKind.colon)) {
          $this().ParseConstructorInitializer(LPT.D);
        } else {
          $this().Actions.ActOnDefaultCtorInitializers(LPT.D);
        }
        if ($this().Tok.is(tok.TokenKind.l_brace)) {
          assert ((!isa(FunctionTemplateDecl.class, LPT.D) || cast(FunctionTemplateDecl.class, LPT.D).getTemplateParameters().getDepth() == $this().TemplateParameterDepth - 1)) : "TemplateParameterDepth should be greater than the depth of current template being instantiated!";
          $this().ParseFunctionStatementBody(LPT.D, FnScope);
          $this().Actions.UnmarkAsLateParsedTemplate(FunD);
        } else {
          $this().Actions.ActOnFinishFunctionBody(LPT.D, (Stmt /*P*/ )null);
        }
      }
      
      // Exit scopes.
      FnScope.Exit();
      std.reverse_iterator<ParseScope /*P*/> I = TemplateParamScopeStack.rbegin();
      for (; $noteq_reverse_iterator$C(I, TemplateParamScopeStack.rend()); I.$preInc())  {
        if (I.$star() != null) { I.$star().$destroy();};
      }
    } finally {
      if (FunctionSavedContext != null) { FunctionSavedContext.$destroy(); }
      if (FnScope != null) { FnScope.$destroy(); }
      if (GlobalSavedContext != null) { GlobalSavedContext.$destroy(); }
      if (CurTemplateDepthTracker != null) { CurTemplateDepthTracker.$destroy(); }
    }
  }

//<editor-fold defaultstate="collapsed" desc="clang::Parser::LateTemplateParserCallback">
@Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseTemplate.cpp", line = 1326,
   FQN="clang::Parser::LateTemplateParserCallback", NM="_ZN5clang6Parser26LateTemplateParserCallbackEPvRNS_18LateParsedTemplateE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseTemplate.cpp -nm=_ZN5clang6Parser26LateTemplateParserCallbackEPvRNS_18LateParsedTemplateE")
  //</editor-fold>
  protected /*private*/ static void LateTemplateParserCallback(Object/*void P*/ P, final LateParsedTemplate /*&*/ LPT) {
    ((Parser /*P*/ )P).ParseLateTemplatedFuncDef(LPT);
  }

//===--------------------------------------------------------------------===//
// C++ 14: Templates [temp]

// C++ 14.1: Template Parameters [temp.param]

/// \brief Parse a template declaration, explicit instantiation, or
/// explicit specialization.
//<editor-fold defaultstate="collapsed" desc="clang::Parser::ParseDeclarationStartingWithTemplate">
@Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseTemplate.cpp", line = 27,
   FQN="clang::Parser::ParseDeclarationStartingWithTemplate", NM="_ZN5clang6Parser36ParseDeclarationStartingWithTemplateEjRNS_14SourceLocationENS_15AccessSpecifierEPNS_13AttributeListE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseTemplate.cpp -nm=_ZN5clang6Parser36ParseDeclarationStartingWithTemplateEjRNS_14SourceLocationENS_15AccessSpecifierEPNS_13AttributeListE")
  //</editor-fold>
  protected /*private*/ Decl /*P*/ ParseDeclarationStartingWithTemplate(/*uint*/int Context, 
                                      final SourceLocation /*&*/ DeclEnd) {
    return $this().ParseDeclarationStartingWithTemplate(Context, 
                                      DeclEnd, 
                                      AccessSpecifier.AS_none, 
                                      (AttributeList /*P*/ )null);
  }
  protected /*private*/ Decl /*P*/ ParseDeclarationStartingWithTemplate(/*uint*/int Context, 
                                      final SourceLocation /*&*/ DeclEnd, 
                                      AccessSpecifier AS/*= AS_none*/) {
    return $this().ParseDeclarationStartingWithTemplate(Context, 
                                      DeclEnd, 
                                      AS, 
                                      (AttributeList /*P*/ )null);
  }
  protected /*private*/ Decl /*P*/ ParseDeclarationStartingWithTemplate(/*uint*/int Context, 
                                      final SourceLocation /*&*/ DeclEnd, 
                                      AccessSpecifier AS/*= AS_none*/, 
                                      AttributeList /*P*/ AccessAttrs/*= null*/) {
    ObjCDeclContextSwitch ObjCDC = null;
    try {
      ObjCDC/*J*/= new ObjCDeclContextSwitch(/*Deref*/$this());
      if ($this().Tok.is(tok.TokenKind.kw_template) && $this().NextToken().isNot(tok.TokenKind.less)) {
        return $this().ParseExplicitInstantiation(Context, 
            new SourceLocation(), $this().ConsumeToken(), 
            DeclEnd, AS);
      }
      return $this().ParseTemplateDeclarationOrSpecialization(Context, DeclEnd, AS, 
          AccessAttrs);
    } finally {
      if (ObjCDC != null) { ObjCDC.$destroy(); }
    }
  }


/// \brief Parse a template declaration or an explicit specialization.
///
/// Template declarations include one or more template parameter lists
/// and either the function or class template declaration. Explicit
/// specializations contain one or more 'template < >' prefixes
/// followed by a (possibly templated) declaration. Since the
/// syntactic form of both features is nearly identical, we parse all
/// of the template headers together and let semantic analysis sort
/// the declarations from the explicit specializations.
///
///       template-declaration: [C++ temp]
///         'export'[opt] 'template' '<' template-parameter-list '>' declaration
///
///       explicit-specialization: [ C++ temp.expl.spec]
///         'template' '<' '>' declaration
//<editor-fold defaultstate="collapsed" desc="clang::Parser::ParseTemplateDeclarationOrSpecialization">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseTemplate.cpp", line = 60,
   FQN="clang::Parser::ParseTemplateDeclarationOrSpecialization", NM="_ZN5clang6Parser40ParseTemplateDeclarationOrSpecializationEjRNS_14SourceLocationENS_15AccessSpecifierEPNS_13AttributeListE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseTemplate.cpp -nm=_ZN5clang6Parser40ParseTemplateDeclarationOrSpecializationEjRNS_14SourceLocationENS_15AccessSpecifierEPNS_13AttributeListE")
  //</editor-fold>
  protected /*private*/ Decl /*P*/ ParseTemplateDeclarationOrSpecialization(/*uint*/int Context, 
                                          final SourceLocation /*&*/ DeclEnd, 
                                          AccessSpecifier AS, 
                                          AttributeList /*P*/ AccessAttrs) {
    ParseScope TemplateParmScope = null;
    ParsingDeclRAIIObject ParsingTemplateParams = null;
    TemplateParameterDepthRAII CurTemplateDepthTracker = null;
    ParseScopeFlags TemplateScopeFlags = null;
    try {
      assert ($this().Tok.isOneOf(tok.TokenKind.kw_export, tok.TokenKind.kw_template)) : "Token does not start a template declaration.";
      
      // Enter template-parameter scope.
      TemplateParmScope/*J*/= new ParseScope($this(), Scope.ScopeFlags.TemplateParamScope);
      
      // Tell the action that names should be checked in the context of
      // the declaration to come.
      ParsingTemplateParams/*J*/= new ParsingDeclRAIIObject(/*Deref*/$this(), ParsingDeclRAIIObject.NoParent_t.NoParent);
      
      // Parse multiple levels of template headers within this template
      // parameter scope, e.g.,
      //
      //   template<typename T>
      //     template<typename U>
      //       class A<T>::B { ... };
      //
      // We parse multiple levels non-recursively so that we can build a
      // single data structure containing all of the template parameter
      // lists to easily differentiate between the case above and:
      //
      //   template<typename T>
      //   class A {
      //     template<typename U> class B;
      //   };
      //
      // In the first case, the action for declaring A<T>::B receives
      // both template parameter lists. In the second case, the action for
      // defining A<T>::B receives just the inner template parameter list
      // (and retrieves the outer template parameter list from its
      // context).
      boolean isSpecialization = true;
      boolean LastParamListWasEmpty = false;
      SmallVector<TemplateParameterList /*P*/> ParamLists/*J*/= new SmallVector<TemplateParameterList /*P*/>(4, null);
      CurTemplateDepthTracker/*J*/= new TemplateParameterDepthRAII($this().TemplateParameterDepth$Ref);
      
      do {
        // Consume the 'export', if any.
        SourceLocation ExportLoc/*J*/= new SourceLocation();
        $this().TryConsumeToken(tok.TokenKind.kw_export, ExportLoc);
        
        // Consume the 'template', which should be here.
        SourceLocation TemplateLoc/*J*/= new SourceLocation();
        if (!$this().TryConsumeToken(tok.TokenKind.kw_template, TemplateLoc)) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            $c$.clean($c$.track($this().Diag($this().Tok.getLocation(), diag.err_expected_template)));
            return null;
          } finally {
            $c$.$destroy();
          }
        }
        
        // Parse the '<' template-parameter-list '>'
        SourceLocation LAngleLoc/*J*/= new SourceLocation(), RAngleLoc/*J*/= new SourceLocation();
        SmallVector<Decl /*P*/> TemplateParams/*J*/= new SmallVector<Decl /*P*/>(4, null);
        if ($this().ParseTemplateParameters(CurTemplateDepthTracker.getDepth(), 
            TemplateParams, LAngleLoc, RAngleLoc)) {
          // Skip until the semi-colon or a '}'.
          $this().SkipUntil(tok.TokenKind.r_brace, $bitor_SkipUntilFlags(/*KEEP_ENUM*/SkipUntilFlags.StopAtSemi, /*KEEP_ENUM*/SkipUntilFlags.StopBeforeMatch));
          $this().TryConsumeToken(tok.TokenKind.semi);
          return null;
        }
        
        ActionResultTTrue<Expr /*P*/ > OptionalRequiresClauseConstraintER/*J*/= new ActionResultTTrue<Expr /*P*/ >();
        if (!TemplateParams.empty()) {
          isSpecialization = false;
          CurTemplateDepthTracker.$preInc();
          if ($this().TryConsumeToken(tok.TokenKind.kw_requires)) {
            OptionalRequiresClauseConstraintER.$assignMove(
                $this().Actions.CorrectDelayedTyposInExpr($this().ParseConstraintExpression())
            );
            if (!OptionalRequiresClauseConstraintER.isUsable()) {
              // Skip until the semi-colon or a '}'.
              $this().SkipUntil(tok.TokenKind.r_brace, $bitor_SkipUntilFlags(/*KEEP_ENUM*/SkipUntilFlags.StopAtSemi, /*KEEP_ENUM*/SkipUntilFlags.StopBeforeMatch));
              $this().TryConsumeToken(tok.TokenKind.semi);
              return null;
            }
          }
        } else {
          LastParamListWasEmpty = true;
        }
        
        ParamLists.push_back($this().Actions.ActOnTemplateParameterList(CurTemplateDepthTracker.getDepth(), new SourceLocation(ExportLoc), new SourceLocation(TemplateLoc), new SourceLocation(LAngleLoc), 
                new ArrayRef<Decl /*P*/ >(TemplateParams), new SourceLocation(RAngleLoc), OptionalRequiresClauseConstraintER.get()));
      } while ($this().Tok.isOneOf(tok.TokenKind.kw_export, tok.TokenKind.kw_template));
      
      /*uint*/int NewFlags = $this().getCurScope().getFlags() & ~Scope.ScopeFlags.TemplateParamScope;
      TemplateScopeFlags/*J*/= new ParseScopeFlags($this(), NewFlags, isSpecialization);
      
      // Parse the actual template declaration.
      return $this().ParseSingleDeclarationAfterTemplate(Context, 
          new ParsedTemplateInfo($AddrOf(ParamLists), 
              isSpecialization, 
              LastParamListWasEmpty), 
          ParsingTemplateParams, 
          DeclEnd, AS, AccessAttrs);
    } finally {
      if (TemplateScopeFlags != null) { TemplateScopeFlags.$destroy(); }
      if (CurTemplateDepthTracker != null) { CurTemplateDepthTracker.$destroy(); }
      if (ParsingTemplateParams != null) { ParsingTemplateParams.$destroy(); }
      if (TemplateParmScope != null) { TemplateParmScope.$destroy(); }
    }
  }


/// \brief Parse a single declaration that declares a template,
/// template specialization, or explicit instantiation of a template.
///
/// \param DeclEnd will receive the source location of the last token
/// within this declaration.
///
/// \param AS the access specifier associated with this
/// declaration. Will be AS_none for namespace-scope declarations.
///
/// \returns the new declaration.
//<editor-fold defaultstate="collapsed" desc="clang::Parser::ParseSingleDeclarationAfterTemplate">
@Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseTemplate.cpp", line = 171,
   FQN="clang::Parser::ParseSingleDeclarationAfterTemplate", NM="_ZN5clang6Parser35ParseSingleDeclarationAfterTemplateEjRKNS0_18ParsedTemplateInfoERNS_21ParsingDeclRAIIObjectERNS_14SourceLocationENS_15AccessSpecifierEPNS_13AttributeListE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseTemplate.cpp -nm=_ZN5clang6Parser35ParseSingleDeclarationAfterTemplateEjRKNS0_18ParsedTemplateInfoERNS_21ParsingDeclRAIIObjectERNS_14SourceLocationENS_15AccessSpecifierEPNS_13AttributeListE")
  //</editor-fold>
  protected /*private*/ Decl /*P*/ ParseSingleDeclarationAfterTemplate(/*uint*/int Context, 
                                     final /*const*/ ParsedTemplateInfo /*&*/ TemplateInfo, 
                                     final ParsingDeclRAIIObject /*&*/ DiagsFromTParams, 
                                     final SourceLocation /*&*/ DeclEnd) {
    return $this().ParseSingleDeclarationAfterTemplate(Context, 
                                     TemplateInfo, 
                                     DiagsFromTParams, 
                                     DeclEnd, 
                                     AccessSpecifier.AS_none, 
                                     (AttributeList /*P*/ )null);
  }
  protected /*private*/ Decl /*P*/ ParseSingleDeclarationAfterTemplate(/*uint*/int Context, 
                                     final /*const*/ ParsedTemplateInfo /*&*/ TemplateInfo, 
                                     final ParsingDeclRAIIObject /*&*/ DiagsFromTParams, 
                                     final SourceLocation /*&*/ DeclEnd, 
                                     AccessSpecifier AS/*= AS_none*/) {
    return $this().ParseSingleDeclarationAfterTemplate(Context, 
                                     TemplateInfo, 
                                     DiagsFromTParams, 
                                     DeclEnd, 
                                     AS, 
                                     (AttributeList /*P*/ )null);
  }
  protected /*private*/ Decl /*P*/ ParseSingleDeclarationAfterTemplate(/*uint*/int Context, 
                                     final /*const*/ ParsedTemplateInfo /*&*/ TemplateInfo, 
                                     final ParsingDeclRAIIObject /*&*/ DiagsFromTParams, 
                                     final SourceLocation /*&*/ DeclEnd, 
                                     AccessSpecifier AS/*= AS_none*/, 
                                     AttributeList /*P*/ AccessAttrs/*= null*/) {
    ParsedAttributesWithRange prefixAttrs = null;
    ParsingDeclSpec DS = null;
    ParsingDeclarator DeclaratorInfo = null;
    try {
      assert (TemplateInfo.Kind != ParsedTemplateInfo.Unnamed_enum.NonTemplate) : "Template information required";
      if ($this().Tok.is(tok.TokenKind.kw_static_assert)) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          // A static_assert declaration may not be templated.
          $c$.clean($out_DiagnosticBuilder$C_SourceRange($c$.track($this().Diag($this().Tok.getLocation(), diag.err_templated_invalid_declaration)), 
              TemplateInfo.getSourceRange()));
          // Parse the static_assert declaration to improve error recovery.
          return $this().ParseStaticAssertDeclaration(DeclEnd);
        } finally {
          $c$.$destroy();
        }
      }
      if (Context == Declarator.TheContext.MemberContext.getValue()) {
        // We are parsing a member template.
        $this().ParseCXXClassMemberDeclaration(AS, AccessAttrs, TemplateInfo, 
            $AddrOf(DiagsFromTParams));
        return null;
      }
      
      prefixAttrs/*J*/= new ParsedAttributesWithRange($this().AttrFactory);
      $this().MaybeParseCXX11Attributes(prefixAttrs);
      if ($this().Tok.is(tok.TokenKind.kw_using)) {
        return $this().ParseUsingDirectiveOrDeclaration(Context, TemplateInfo, DeclEnd, 
            prefixAttrs);
      }
      
      // Parse the declaration specifiers, stealing any diagnostics from
      // the template parameters.
      DS/*J*/= new ParsingDeclSpec(/*Deref*/$this(), $AddrOf(DiagsFromTParams));
      
      $this().ParseDeclarationSpecifiers(DS, TemplateInfo, AS, 
          $this().getDeclSpecContextFromDeclaratorContext(Context));
      if ($this().Tok.is(tok.TokenKind.semi)) {
        $this().ProhibitAttributes(prefixAttrs);
        DeclEnd.$assignMove($this().ConsumeToken());
        type$ref<RecordDecl> /*P*/ AnonRecord = create_type$ref((RecordDecl) null);
        Decl /*P*/ Decl = $this().Actions.ParsedFreeStandingDeclSpec($this().getCurScope(), AS, DS, 
            (TemplateInfo.TemplateParams != null) ? new MutableArrayRef<TemplateParameterList /*P*/ >($Deref(TemplateInfo.TemplateParams), true) : new MutableArrayRef<TemplateParameterList /*P*/ >(true), 
            TemplateInfo.Kind == ParsedTemplateInfo.Unnamed_enum.ExplicitInstantiation, 
            AnonRecord);
        assert (!AnonRecord.$bool()) : "Anonymous unions/structs should not be valid with template";
        DS.complete(Decl);
        return Decl;
      }
      
      // Move the attributes from the prefix into the DS.
      if (TemplateInfo.Kind == ParsedTemplateInfo.Unnamed_enum.ExplicitInstantiation) {
        $this().ProhibitAttributes(prefixAttrs);
      } else {
        DS.takeAttributesFrom(prefixAttrs);
      }
      
      // Parse the declarator.
      DeclaratorInfo/*J*/= new ParsingDeclarator(/*Deref*/$this(), DS, Declarator.TheContext.valueOf(Context));
      $this().ParseDeclarator(DeclaratorInfo);
      // Error parsing the declarator?
      if (!DeclaratorInfo.hasName()) {
        // If so, skip until the semi-colon or a }.
        $this().SkipUntil(tok.TokenKind.r_brace, $bitor_SkipUntilFlags(/*KEEP_ENUM*/SkipUntilFlags.StopAtSemi, /*KEEP_ENUM*/SkipUntilFlags.StopBeforeMatch));
        if ($this().Tok.is(tok.TokenKind.semi)) {
          $this().ConsumeToken();
        }
        return null;
      }
      
      LateParsedAttrList LateParsedAttrs/*J*/= new LateParsedAttrList(true);
      if (DeclaratorInfo.isFunctionDeclarator()) {
        $this().MaybeParseGNUAttributes(DeclaratorInfo, $AddrOf(LateParsedAttrs));
      }
      if (DeclaratorInfo.isFunctionDeclarator()
         && $this().isStartOfFunctionDefinition(DeclaratorInfo)) {
        
        // Function definitions are only allowed at file scope and in C++ classes.
        // The C++ inline method definition case is handled elsewhere, so we only
        // need to handle the file scope definition case.
        if (Context != Declarator.TheContext.FileContext.getValue()) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            $c$.clean($c$.track($this().Diag($this().Tok, diag.err_function_definition_not_allowed)));
            $this().SkipMalformedDecl();
            return null;
          } finally {
            $c$.$destroy();
          }
        }
        if (DS.getStorageClassSpec() == DeclSpec.SCS.SCS_typedef) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            // Recover by ignoring the 'typedef'. This was probably supposed to be
            // the 'typename' keyword, which we should have already suggested adding
            // if it's appropriate.
            $c$.clean($out_DiagnosticBuilder$C_FixItHint$C($c$.track($this().Diag(DS.getStorageClassSpecLoc(), diag.err_function_declared_typedef)), 
                FixItHint.CreateRemoval(new SourceRange(DS.getStorageClassSpecLoc()))));
            DS.ClearStorageClassSpecs();
          } finally {
            $c$.$destroy();
          }
        }
        if (TemplateInfo.Kind == ParsedTemplateInfo.Unnamed_enum.ExplicitInstantiation) {
          if (DeclaratorInfo.getName().getKind() != UnqualifiedId.IdKind.IK_TemplateId) {
            JavaCleaner $c$ = $createJavaCleaner();
            try {
              // If the declarator-id is not a template-id, issue a diagnostic and
              // recover by ignoring the 'template' keyword.
              $c$.clean($out_DiagnosticBuilder$C_int($c$.track($this().Diag($this().Tok, diag.err_template_defn_explicit_instantiation)), 0));
              return $this().ParseFunctionDefinition(DeclaratorInfo, new ParsedTemplateInfo(), 
                  $AddrOf(LateParsedAttrs));
            } finally {
              $c$.$destroy();
            }
          } else {
            JavaCleaner $c$ = $createJavaCleaner();
            try {
              SourceLocation LAngleLoc = $this().PP.getLocForEndOfToken(/*NO_COPY*/TemplateInfo.TemplateLoc);
              $c$.clean($out_DiagnosticBuilder$C_FixItHint$C($out_DiagnosticBuilder$C_SourceRange($c$.track($this().Diag(DeclaratorInfo.getIdentifierLoc(), 
                          diag.err_explicit_instantiation_with_definition)), 
                      new SourceRange(/*NO_COPY*/TemplateInfo.TemplateLoc)), 
                  FixItHint.CreateInsertion(/*NO_COPY*/LAngleLoc, new StringRef(/*KEEP_STR*/"<>"))));
              
              // Recover as if it were an explicit specialization.
              SmallVector<TemplateParameterList /*P*/> FakedParamLists/*J*/= new SmallVector<TemplateParameterList /*P*/>(4, null);
              FakedParamLists.push_back($this().Actions.ActOnTemplateParameterList(0, new SourceLocation(), new SourceLocation(TemplateInfo.TemplateLoc), new SourceLocation(LAngleLoc), new ArrayRef<Decl /*P*/ >(None), 
                      new SourceLocation(LAngleLoc), (Expr /*P*/ )null));
              
              return $this().ParseFunctionDefinition(DeclaratorInfo, new ParsedTemplateInfo($AddrOf(FakedParamLists), 
                      /*isSpecialization=*/ true, 
                      /*LastParamListWasEmpty=*/ true), 
                  $AddrOf(LateParsedAttrs));
            } finally {
              $c$.$destroy();
            }
          }
        }
        return $this().ParseFunctionDefinition(DeclaratorInfo, TemplateInfo, 
            $AddrOf(LateParsedAttrs));
      }
      
      // Parse this declaration.
      Decl /*P*/ ThisDecl = $this().ParseDeclarationAfterDeclarator(DeclaratorInfo, 
          TemplateInfo);
      if ($this().Tok.is(tok.TokenKind.comma)) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_DiagnosticBuilder$C_int($c$.track($this().Diag($this().Tok, diag.err_multiple_template_declarators)), 
              (int)TemplateInfo.Kind.getValue()));
          $this().SkipUntil(tok.TokenKind.semi);
          return ThisDecl;
        } finally {
          $c$.$destroy();
        }
      }
      
      // Eat the semi colon after the declaration.
      $this().ExpectAndConsumeSemi(diag.err_expected_semi_declaration);
      if ($greater_uint(LateParsedAttrs.size(), 0)) {
        $this().ParseLexedAttributeList(LateParsedAttrs, ThisDecl, true, false);
      }
      DeclaratorInfo.complete(ThisDecl);
      return ThisDecl;
    } finally {
      if (DeclaratorInfo != null) { DeclaratorInfo.$destroy(); }
      if (DS != null) { DS.$destroy(); }
      if (prefixAttrs != null) { prefixAttrs.$destroy(); }
    }
  }


/// ParseTemplateParameters - Parses a template-parameter-list enclosed in
/// angle brackets. Depth is the depth of this template-parameter-list, which
/// is the number of template headers directly enclosing this template header.
/// TemplateParams is the current list of template parameters we're building.
/// The template parameter we parse will be added to this list. LAngleLoc and
/// RAngleLoc will receive the positions of the '<' and '>', respectively,
/// that enclose this template parameter list.
///
/// \returns true if an error occurred, false otherwise.
//<editor-fold defaultstate="collapsed" desc="clang::Parser::ParseTemplateParameters">
@Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseTemplate.cpp", line = 330,
   FQN="clang::Parser::ParseTemplateParameters", NM="_ZN5clang6Parser23ParseTemplateParametersEjRN4llvm15SmallVectorImplIPNS_4DeclEEERNS_14SourceLocationES8_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseTemplate.cpp -nm=_ZN5clang6Parser23ParseTemplateParametersEjRN4llvm15SmallVectorImplIPNS_4DeclEEERNS_14SourceLocationES8_")
  //</editor-fold>
  protected /*private*/ boolean ParseTemplateParameters(/*uint*/int Depth, 
                         final SmallVectorImpl<Decl /*P*/ > /*&*/ TemplateParams, 
                         final SourceLocation /*&*/ LAngleLoc, 
                         final SourceLocation /*&*/ RAngleLoc) {
    // Get the template parameter list.
    if (!$this().TryConsumeToken(tok.TokenKind.less, LAngleLoc)) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_DiagnosticBuilder$C_char$ptr$C($c$.track($this().Diag($this().Tok.getLocation(), diag.err_expected_less_after)), /*KEEP_STR*/$template));
        return true;
      } finally {
        $c$.$destroy();
      }
    }
    
    // Try to parse the template parameter list.
    boolean Failed = false;
    if (!$this().Tok.is(tok.TokenKind.greater) && !$this().Tok.is(tok.TokenKind.greatergreater)) {
      Failed = $this().ParseTemplateParameterList(Depth, TemplateParams);
    }
    if ($this().Tok.is(tok.TokenKind.greatergreater)) {
      // No diagnostic required here: a template-parameter-list can only be
      // followed by a declaration or, for a template template parameter, the
      // 'class' keyword. Therefore, the second '>' will be diagnosed later.
      // This matters for elegant diagnosis of:
      //   template<template<typename>> struct S;
      $this().Tok.setKind(tok.TokenKind.greater);
      RAngleLoc.$assignMove($this().Tok.getLocation());
      $this().Tok.setLocation($this().Tok.getLocation().getLocWithOffset(1));
    } else if (!$this().TryConsumeToken(tok.TokenKind.greater, RAngleLoc) && Failed) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_DiagnosticBuilder$C_TokenKind($c$.track($this().Diag($this().Tok.getLocation(), diag.err_expected)), tok.TokenKind.greater));
        return true;
      } finally {
        $c$.$destroy();
      }
    }
    return false;
  }


/// ParseTemplateParameterList - Parse a template parameter list. If
/// the parsing fails badly (i.e., closing bracket was left out), this
/// will try to put the token stream in a reasonable position (closing
/// a statement, etc.) and return false.
///
///       template-parameter-list:    [C++ temp]
///         template-parameter
///         template-parameter-list ',' template-parameter
//<editor-fold defaultstate="collapsed" desc="clang::Parser::ParseTemplateParameterList">
@Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseTemplate.cpp", line = 369,
   FQN="clang::Parser::ParseTemplateParameterList", NM="_ZN5clang6Parser26ParseTemplateParameterListEjRN4llvm15SmallVectorImplIPNS_4DeclEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseTemplate.cpp -nm=_ZN5clang6Parser26ParseTemplateParameterListEjRN4llvm15SmallVectorImplIPNS_4DeclEEE")
  //</editor-fold>
  protected /*private*/ boolean ParseTemplateParameterList(/*uint*/int Depth, 
                            final SmallVectorImpl<Decl /*P*/ > /*&*/ TemplateParams) {
    while (true) {
      {
        Decl /*P*/ TmpParam = $this().ParseTemplateParameter(Depth, TemplateParams.size());
        if ((TmpParam != null)) {
          TemplateParams.push_back(TmpParam);
        } else {
          // If we failed to parse a template parameter, skip until we find
          // a comma or closing brace.
          $this().SkipUntil(tok.TokenKind.comma, tok.TokenKind.greater, tok.TokenKind.greatergreater, 
              $bitor_SkipUntilFlags(/*KEEP_ENUM*/SkipUntilFlags.StopAtSemi, /*KEEP_ENUM*/SkipUntilFlags.StopBeforeMatch));
        }
      }
      
      // Did we find a comma or the end of the template parameter list?
      if ($this().Tok.is(tok.TokenKind.comma)) {
        $this().ConsumeToken();
      } else if ($this().Tok.isOneOf(tok.TokenKind.greater, tok.TokenKind.greatergreater)) {
        // Don't consume this... that's done by template parser.
        break;
      } else {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          // Somebody probably forgot to close the template. Skip ahead and
          // try to get out of the expression. This error is currently
          // subsumed by whatever goes on in ParseTemplateParameter.
          $c$.clean($c$.track($this().Diag($this().Tok.getLocation(), diag.err_expected_comma_greater)));
          $this().SkipUntil(tok.TokenKind.comma, tok.TokenKind.greater, tok.TokenKind.greatergreater, 
              $bitor_SkipUntilFlags(/*KEEP_ENUM*/SkipUntilFlags.StopAtSemi, /*KEEP_ENUM*/SkipUntilFlags.StopBeforeMatch));
          return false;
        } finally {
          $c$.$destroy();
        }
      }
    }
    return true;
  }


/// \brief Determine whether the parser is at the start of a template
/// type parameter.
//<editor-fold defaultstate="collapsed" desc="clang::Parser::isStartOfTemplateTypeParameter">
@Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseTemplate.cpp", line = 404,
   FQN="clang::Parser::isStartOfTemplateTypeParameter", NM="_ZN5clang6Parser30isStartOfTemplateTypeParameterEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseTemplate.cpp -nm=_ZN5clang6Parser30isStartOfTemplateTypeParameterEv")
  //</editor-fold>
  protected /*private*/ boolean isStartOfTemplateTypeParameter() {
    if ($this().Tok.is(tok.TokenKind.kw_class)) {
      // "class" may be the start of an elaborated-type-specifier or a
      // type-parameter. Per C++ [temp.param]p3, we prefer the type-parameter.
      switch ($this().NextToken().getKind()) {
       case tok.TokenKind.equal:
       case tok.TokenKind.comma:
       case tok.TokenKind.greater:
       case tok.TokenKind.greatergreater:
       case tok.TokenKind.ellipsis:
        return true;
       case tok.TokenKind.identifier:
        // This may be either a type-parameter or an elaborated-type-specifier. 
        // We have to look further.
        break;
       default:
        return false;
      }
      switch ($this().GetLookAheadToken(2).getKind()) {
       case tok.TokenKind.equal:
       case tok.TokenKind.comma:
       case tok.TokenKind.greater:
       case tok.TokenKind.greatergreater:
        return true;
       default:
        return false;
      }
    }
    if ($this().Tok.isNot(tok.TokenKind.kw_typename)) {
      return false;
    }
    
    // C++ [temp.param]p2:
    //   There is no semantic difference between class and typename in a
    //   template-parameter. typename followed by an unqualified-id
    //   names a template type parameter. typename followed by a
    //   qualified-id denotes the type in a non-type
    //   parameter-declaration.
    Token Next = new Token($this().NextToken());
    
    // If we have an identifier, skip over it.
    if (Next.getKind() == tok.TokenKind.identifier) {
      Next.$assign($this().GetLookAheadToken(2));
    }
    switch (Next.getKind()) {
     case tok.TokenKind.equal:
     case tok.TokenKind.comma:
     case tok.TokenKind.greater:
     case tok.TokenKind.greatergreater:
     case tok.TokenKind.ellipsis:
      return true;
     default:
      return false;
    }
  }


/// ParseTemplateParameter - Parse a template-parameter (C++ [temp.param]).
///
///       template-parameter: [C++ temp.param]
///         type-parameter
///         parameter-declaration
///
///       type-parameter: (see below)
///         'class' ...[opt] identifier[opt]
///         'class' identifier[opt] '=' type-id
///         'typename' ...[opt] identifier[opt]
///         'typename' identifier[opt] '=' type-id
///         'template' '<' template-parameter-list '>' 
///               'class' ...[opt] identifier[opt]
///         'template' '<' template-parameter-list '>' 'class' identifier[opt]
///               = id-expression
//<editor-fold defaultstate="collapsed" desc="clang::Parser::ParseTemplateParameter">
@Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseTemplate.cpp", line = 480,
   FQN="clang::Parser::ParseTemplateParameter", NM="_ZN5clang6Parser22ParseTemplateParameterEjj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseTemplate.cpp -nm=_ZN5clang6Parser22ParseTemplateParameterEjj")
  //</editor-fold>
  protected /*private*/ Decl /*P*/ ParseTemplateParameter(/*uint*/int Depth, /*uint*/int Position) {
    if ($this().isStartOfTemplateTypeParameter()) {
      return $this().ParseTypeParameter(Depth, Position);
    }
    if ($this().Tok.is(tok.TokenKind.kw_template)) {
      return $this().ParseTemplateTemplateParameter(Depth, Position);
    }
    
    // If it's none of the above, then it must be a parameter declaration.
    // NOTE: This will pick up errors in the closure of the template parameter
    // list (e.g., template < ; Check here to implement >> style closures.
    return $this().ParseNonTypeTemplateParameter(Depth, Position);
  }


/// ParseTypeParameter - Parse a template type parameter (C++ [temp.param]).
/// Other kinds of template parameters are parsed in
/// ParseTemplateTemplateParameter and ParseNonTypeTemplateParameter.
///
///       type-parameter:     [C++ temp.param]
///         'class' ...[opt][C++0x] identifier[opt]
///         'class' identifier[opt] '=' type-id
///         'typename' ...[opt][C++0x] identifier[opt]
///         'typename' identifier[opt] '=' type-id
//<editor-fold defaultstate="collapsed" desc="clang::Parser::ParseTypeParameter">
@Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseTemplate.cpp", line = 502,
   FQN="clang::Parser::ParseTypeParameter", NM="_ZN5clang6Parser18ParseTypeParameterEjj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseTemplate.cpp -nm=_ZN5clang6Parser18ParseTypeParameterEjj")
  //</editor-fold>
  protected /*private*/ Decl /*P*/ ParseTypeParameter(/*uint*/int Depth, /*uint*/int Position) {
    assert ($this().Tok.isOneOf(tok.TokenKind.kw_class, tok.TokenKind.kw_typename)) : "A type-parameter starts with 'class' or 'typename'";
    
    // Consume the 'class' or 'typename' keyword.
    boolean TypenameKeyword = $this().Tok.is(tok.TokenKind.kw_typename);
    SourceLocation KeyLoc = $this().ConsumeToken();
    
    // Grab the ellipsis (if given).
    SourceLocation EllipsisLoc/*J*/= new SourceLocation();
    if ($this().TryConsumeToken(tok.TokenKind.ellipsis, EllipsisLoc)) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($c$.track($this().Diag(new SourceLocation(EllipsisLoc), 
            $this().getLangOpts().CPlusPlus11 ? diag.warn_cxx98_compat_variadic_templates : diag.ext_variadic_templates)));
      } finally {
        $c$.$destroy();
      }
    }
    
    // Grab the template parameter name (if given)
    SourceLocation NameLoc/*J*/= new SourceLocation();
    IdentifierInfo /*P*/ ParamName = null;
    if ($this().Tok.is(tok.TokenKind.identifier)) {
      ParamName = $this().Tok.getIdentifierInfo();
      NameLoc.$assignMove($this().ConsumeToken());
    } else if ($this().Tok.isOneOf$T(tok.TokenKind.equal, tok.TokenKind.comma, tok.TokenKind.greater, 
        tok.TokenKind.greatergreater)) {
      // Unnamed template parameter. Don't have to do anything here, just
      // don't consume this token.
    } else {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_DiagnosticBuilder$C_TokenKind($c$.track($this().Diag($this().Tok.getLocation(), diag.err_expected)), tok.TokenKind.identifier));
        return null;
      } finally {
        $c$.$destroy();
      }
    }
    
    // Recover from misplaced ellipsis.
    boolean AlreadyHasEllipsis = EllipsisLoc.isValid();
    if ($this().TryConsumeToken(tok.TokenKind.ellipsis, EllipsisLoc)) {
      $this().DiagnoseMisplacedEllipsis(new SourceLocation(EllipsisLoc), new SourceLocation(NameLoc), AlreadyHasEllipsis, true);
    }
    
    // Grab a default argument (if available).
    // Per C++0x [basic.scope.pdecl]p9, we parse the default argument before
    // we introduce the type parameter into the local scope.
    SourceLocation EqualLoc/*J*/= new SourceLocation();
    OpaquePtr<QualType> DefaultArg/*J*/= new OpaquePtr<QualType>();
    if ($this().TryConsumeToken(tok.TokenKind.equal, EqualLoc)) {
      DefaultArg.$assignMove($this().ParseTypeName(/*Range=*/ (SourceRange /*P*/ )null, 
              Declarator.TheContext.TemplateTypeArgContext).get());
    }
    
    return $this().Actions.ActOnTypeParameter($this().getCurScope(), TypenameKeyword, new SourceLocation(EllipsisLoc), 
        new SourceLocation(KeyLoc), ParamName, new SourceLocation(NameLoc), Depth, Position, 
        new SourceLocation(EqualLoc), new OpaquePtr<QualType>(DefaultArg));
  }


/// ParseTemplateTemplateParameter - Handle the parsing of template
/// template parameters.
///
///       type-parameter:    [C++ temp.param]
///         'template' '<' template-parameter-list '>' type-parameter-key
///                  ...[opt] identifier[opt]
///         'template' '<' template-parameter-list '>' type-parameter-key
///                  identifier[opt] = id-expression
///       type-parameter-key:
///         'class'
///         'typename'       [C++1z]
//<editor-fold defaultstate="collapsed" desc="clang::Parser::ParseTemplateTemplateParameter">
@Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseTemplate.cpp", line = 564,
   FQN="clang::Parser::ParseTemplateTemplateParameter", NM="_ZN5clang6Parser30ParseTemplateTemplateParameterEjj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseTemplate.cpp -nm=_ZN5clang6Parser30ParseTemplateTemplateParameterEjj")
  //</editor-fold>
  protected /*private*/ Decl /*P*/ ParseTemplateTemplateParameter(/*uint*/int Depth, /*uint*/int Position) {
    ParsedTemplateArgument DefaultArg = null;
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      assert ($this().Tok.is(tok.TokenKind.kw_template)) : "Expected 'template' keyword";
      
      // Handle the template <...> part.
      SourceLocation TemplateLoc = $this().ConsumeToken();
      SmallVector<Decl /*P*/> TemplateParams/*J*/= new SmallVector<Decl /*P*/>(8, null);
      SourceLocation LAngleLoc/*J*/= new SourceLocation(), RAngleLoc/*J*/= new SourceLocation();
      {
        ParseScope TemplateParmScope = null;
        try {
          TemplateParmScope/*J*/= new ParseScope($this(), Scope.ScopeFlags.TemplateParamScope);
          if ($this().ParseTemplateParameters(Depth + 1, TemplateParams, LAngleLoc, 
              RAngleLoc)) {
            return null;
          }
        } finally {
          if (TemplateParmScope != null) { TemplateParmScope.$destroy(); }
        }
      }
      
      // Provide an ExtWarn if the C++1z feature of using 'typename' here is used.
      // Generate a meaningful error if the user forgot to put class before the
      // identifier, comma, or greater. Provide a fixit if the identifier, comma,
      // or greater appear immediately or after 'struct'. In the latter case,
      // replace the keyword with 'class'.
      if (!$this().TryConsumeToken(tok.TokenKind.kw_class)) {
        boolean Replace = $this().Tok.isOneOf(tok.TokenKind.kw_typename, tok.TokenKind.kw_struct);
        final /*const*/ Token /*&*/ Next = $this().Tok.is(tok.TokenKind.kw_struct) ? $this().NextToken() : $this().Tok;
        if ($this().Tok.is(tok.TokenKind.kw_typename)) {
          $c$.clean($out_DiagnosticBuilder$C_FixItHint$C($c$.track($this().Diag($this().Tok.getLocation(), 
                  $this().getLangOpts().CPlusPlus1z ? diag.warn_cxx14_compat_template_template_param_typename : diag.ext_template_template_param_typename)), 
              (!$this().getLangOpts().CPlusPlus1z ? FixItHint.CreateReplacement(new SourceRange($this().Tok.getLocation()), new StringRef(/*KEEP_STR*/$class)) : new FixItHint())));
        } else if (Next.isOneOf$T(tok.TokenKind.identifier, tok.TokenKind.comma, tok.TokenKind.greater, 
            tok.TokenKind.greatergreater, tok.TokenKind.ellipsis)) {
          $c$.clean($out_DiagnosticBuilder$C_FixItHint$C($c$.track($this().Diag($this().Tok.getLocation(), diag.err_class_on_template_template_param)), 
              (Replace ? FixItHint.CreateReplacement(new SourceRange($this().Tok.getLocation()), new StringRef(/*KEEP_STR*/$class)) : FixItHint.CreateInsertion($this().Tok.getLocation(), new StringRef(/*KEEP_STR*/"class ")))));
        } else {
          $c$.clean($c$.track($this().Diag($this().Tok.getLocation(), diag.err_class_on_template_template_param)));
        }
        if (Replace) {
          $this().ConsumeToken();
        }
      }
      
      // Parse the ellipsis, if given.
      SourceLocation EllipsisLoc/*J*/= new SourceLocation();
      if ($this().TryConsumeToken(tok.TokenKind.ellipsis, EllipsisLoc)) {
        $c$.clean($c$.track($this().Diag(new SourceLocation(EllipsisLoc), 
            $this().getLangOpts().CPlusPlus11 ? diag.warn_cxx98_compat_variadic_templates : diag.ext_variadic_templates)));
      }
      
      // Get the identifier, if given.
      SourceLocation NameLoc/*J*/= new SourceLocation();
      IdentifierInfo /*P*/ ParamName = null;
      if ($this().Tok.is(tok.TokenKind.identifier)) {
        ParamName = $this().Tok.getIdentifierInfo();
        NameLoc.$assignMove($this().ConsumeToken());
      } else if ($this().Tok.isOneOf$T(tok.TokenKind.equal, tok.TokenKind.comma, tok.TokenKind.greater, 
          tok.TokenKind.greatergreater)) {
        // Unnamed template parameter. Don't have to do anything here, just
        // don't consume this token.
      } else {
        $c$.clean($out_DiagnosticBuilder$C_TokenKind($c$.track($this().Diag($this().Tok.getLocation(), diag.err_expected)), tok.TokenKind.identifier));
        return null;
      }
      
      // Recover from misplaced ellipsis.
      boolean AlreadyHasEllipsis = EllipsisLoc.isValid();
      if ($this().TryConsumeToken(tok.TokenKind.ellipsis, EllipsisLoc)) {
        $this().DiagnoseMisplacedEllipsis(new SourceLocation(EllipsisLoc), new SourceLocation(NameLoc), AlreadyHasEllipsis, true);
      }
      
      TemplateParameterList /*P*/ ParamList = $this().Actions.ActOnTemplateParameterList(Depth, new SourceLocation(), 
          new SourceLocation(TemplateLoc), new SourceLocation(LAngleLoc), 
          new ArrayRef<Decl /*P*/ >(TemplateParams), 
          new SourceLocation(RAngleLoc), (Expr /*P*/ )null);
      
      // Grab a default argument (if available).
      // Per C++0x [basic.scope.pdecl]p9, we parse the default argument before
      // we introduce the template parameter into the local scope.
      SourceLocation EqualLoc/*J*/= new SourceLocation();
      DefaultArg/*J*/= new ParsedTemplateArgument();
      if ($this().TryConsumeToken(tok.TokenKind.equal, EqualLoc)) {
        $c$.clean(DefaultArg.$assignMove($c$.track($this().ParseTemplateTemplateArgument())));
        if (DefaultArg.isInvalid()) {
          $c$.clean($c$.track($this().Diag($this().Tok.getLocation(), 
              diag.err_default_template_template_parameter_not_template)));
          $this().SkipUntil(tok.TokenKind.comma, tok.TokenKind.greater, tok.TokenKind.greatergreater, 
              $bitor_SkipUntilFlags(/*KEEP_ENUM*/SkipUntilFlags.StopAtSemi, /*KEEP_ENUM*/SkipUntilFlags.StopBeforeMatch));
        }
      }
      
      return $c$.clean($this().Actions.ActOnTemplateTemplateParameter($this().getCurScope(), new SourceLocation(TemplateLoc), 
          ParamList, new SourceLocation(EllipsisLoc), 
          ParamName, new SourceLocation(NameLoc), Depth, 
          Position, new SourceLocation(EqualLoc), $c$.track(new ParsedTemplateArgument(DefaultArg))));
    } finally {
      if (DefaultArg != null) { DefaultArg.$destroy(); }
      $c$.$destroy();
    }
  }


/// ParseNonTypeTemplateParameter - Handle the parsing of non-type
/// template parameters (e.g., in "template<int Size> class array;").
///
///       template-parameter:
///         ...
///         parameter-declaration
//<editor-fold defaultstate="collapsed" desc="clang::Parser::ParseNonTypeTemplateParameter">
@Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseTemplate.cpp", line = 669,
   FQN="clang::Parser::ParseNonTypeTemplateParameter", NM="_ZN5clang6Parser29ParseNonTypeTemplateParameterEjj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseTemplate.cpp -nm=_ZN5clang6Parser29ParseNonTypeTemplateParameterEjj")
  //</editor-fold>
  protected /*private*/ Decl /*P*/ ParseNonTypeTemplateParameter(/*uint*/int Depth, /*uint*/int Position) {
    DeclSpec DS = null;
    Declarator ParamDecl = null;
    try {
      // Parse the declaration-specifiers (i.e., the type).
      // FIXME: The type should probably be restricted in some way... Not all
      // declarators (parts of declarators?) are accepted for parameters.
      DS/*J*/= new DeclSpec($this().AttrFactory);
      $this().ParseDeclarationSpecifiers(DS);
      
      // Parse this as a typename.
      ParamDecl/*J*/= new Declarator(DS, Declarator.TheContext.TemplateParamContext);
      $this().ParseDeclarator(ParamDecl);
      if (DS.getTypeSpecType() == DeclSpec.TST_unspecified) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($c$.track($this().Diag($this().Tok.getLocation(), diag.err_expected_template_parameter)));
          return null;
        } finally {
          $c$.$destroy();
        }
      }
      
      // Recover from misplaced ellipsis.
      SourceLocation EllipsisLoc/*J*/= new SourceLocation();
      if ($this().TryConsumeToken(tok.TokenKind.ellipsis, EllipsisLoc)) {
        $this().DiagnoseMisplacedEllipsisInDeclarator(new SourceLocation(EllipsisLoc), ParamDecl);
      }
      
      // If there is a default value, parse it.
      // Per C++0x [basic.scope.pdecl]p9, we parse the default argument before
      // we introduce the template parameter into the local scope.
      SourceLocation EqualLoc/*J*/= new SourceLocation();
      ActionResultTTrue<Expr /*P*/ > DefaultArg/*J*/= new ActionResultTTrue<Expr /*P*/ >();
      if ($this().TryConsumeToken(tok.TokenKind.equal, EqualLoc)) {
        GreaterThanIsOperatorScope G = null;
        EnterExpressionEvaluationContext ConstantEvaluated = null;
        try {
          // C++ [temp.param]p15:
          //   When parsing a default template-argument for a non-type
          //   template-parameter, the first non-nested > is taken as the
          //   end of the template-parameter-list rather than a greater-than
          //   operator.
          G/*J*/= new GreaterThanIsOperatorScope($this().GreaterThanIsOperator$Ref, false);
          ConstantEvaluated/*J*/= new EnterExpressionEvaluationContext($this().Actions, 
              Sema.ExpressionEvaluationContext.ConstantEvaluated);
          
          DefaultArg.$assignMove($this().Actions.CorrectDelayedTyposInExpr($this().ParseAssignmentExpression()));
          if (DefaultArg.isInvalid()) {
            $this().SkipUntil(tok.TokenKind.comma, tok.TokenKind.greater, $bitor_SkipUntilFlags(/*KEEP_ENUM*/SkipUntilFlags.StopAtSemi, /*KEEP_ENUM*/SkipUntilFlags.StopBeforeMatch));
          }
        } finally {
          if (ConstantEvaluated != null) { ConstantEvaluated.$destroy(); }
          if (G != null) { G.$destroy(); }
        }
      }
      
      // Create the parameter.
      return $this().Actions.ActOnNonTypeTemplateParameter($this().getCurScope(), ParamDecl, 
          Depth, Position, new SourceLocation(EqualLoc), 
          DefaultArg.get());
    } finally {
      if (ParamDecl != null) { ParamDecl.$destroy(); }
      if (DS != null) { DS.$destroy(); }
    }
  }

//<editor-fold defaultstate="collapsed" desc="clang::Parser::DiagnoseMisplacedEllipsis">
@Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseTemplate.cpp", line = 716,
   FQN="clang::Parser::DiagnoseMisplacedEllipsis", NM="_ZN5clang6Parser25DiagnoseMisplacedEllipsisENS_14SourceLocationES1_bb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseTemplate.cpp -nm=_ZN5clang6Parser25DiagnoseMisplacedEllipsisENS_14SourceLocationES1_bb")
  //</editor-fold>
  protected /*private*/ void DiagnoseMisplacedEllipsis(SourceLocation EllipsisLoc, 
                           SourceLocation CorrectLoc, 
                           boolean AlreadyHasEllipsis, 
                           boolean IdentifierHasName) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      FixItHint Insertion/*J*/= new FixItHint();
      if (!AlreadyHasEllipsis) {
        Insertion.$assignMove(FixItHint.CreateInsertion(/*NO_COPY*/CorrectLoc, new StringRef(/*KEEP_STR*/$ELLIPSIS)));
      }
      $c$.clean($out$Same2Bool($out_DiagnosticBuilder$C_FixItHint$C($out_DiagnosticBuilder$C_FixItHint$C($c$.track($this().Diag(new SourceLocation(EllipsisLoc), diag.err_misplaced_ellipsis_in_declaration)), 
                  FixItHint.CreateRemoval(new SourceRange(/*NO_COPY*/EllipsisLoc))), Insertion), 
          !IdentifierHasName));
    } finally {
      $c$.$destroy();
    }
  }

//<editor-fold defaultstate="collapsed" desc="clang::Parser::DiagnoseMisplacedEllipsisInDeclarator">
@Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseTemplate.cpp", line = 728,
   FQN="clang::Parser::DiagnoseMisplacedEllipsisInDeclarator", NM="_ZN5clang6Parser37DiagnoseMisplacedEllipsisInDeclaratorENS_14SourceLocationERNS_10DeclaratorE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseTemplate.cpp -nm=_ZN5clang6Parser37DiagnoseMisplacedEllipsisInDeclaratorENS_14SourceLocationERNS_10DeclaratorE")
  //</editor-fold>
  protected /*private*/ void DiagnoseMisplacedEllipsisInDeclarator(SourceLocation EllipsisLoc, 
                                       final Declarator /*&*/ D) {
    assert (EllipsisLoc.isValid());
    boolean AlreadyHasEllipsis = D.getEllipsisLoc().isValid();
    if (!AlreadyHasEllipsis) {
      D.setEllipsisLoc(new SourceLocation(EllipsisLoc));
    }
    $this().DiagnoseMisplacedEllipsis(new SourceLocation(EllipsisLoc), D.getIdentifierLoc(), 
        AlreadyHasEllipsis, D.hasName());
  }


/// \brief Parses a '>' at the end of a template list.
///
/// If this function encounters '>>', '>>>', '>=', or '>>=', it tries
/// to determine if these tokens were supposed to be a '>' followed by
/// '>', '>>', '>=', or '>='. It emits an appropriate diagnostic if necessary.
///
/// \param RAngleLoc the location of the consumed '>'.
///
/// \param ConsumeLastToken if true, the '>' is consumed.
///
/// \param ObjCGenericList if true, this is the '>' closing an Objective-C
/// type parameter or type argument list, rather than a C++ template parameter
/// or argument list.
///
/// \returns true, if current token does not start with '>', false otherwise.
//<editor-fold defaultstate="collapsed" desc="clang::Parser::ParseGreaterThanInTemplateList">
@Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseTemplate.cpp", line = 753,
   FQN="clang::Parser::ParseGreaterThanInTemplateList", NM="_ZN5clang6Parser30ParseGreaterThanInTemplateListERNS_14SourceLocationEbb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseTemplate.cpp -nm=_ZN5clang6Parser30ParseGreaterThanInTemplateListERNS_14SourceLocationEbb")
  //</editor-fold>
  protected /*private*/ boolean ParseGreaterThanInTemplateList(final SourceLocation /*&*/ RAngleLoc, 
                                boolean ConsumeLastToken, 
                                boolean ObjCGenericList) {
    // What will be left once we've consumed the '>'.
    /*tok.TokenKind*/char RemainingToken;
    /*const*/char$ptr/*char P*/ ReplacementStr = $("> >");
    switch ($this().Tok.getKind()) {
     default:
      {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_DiagnosticBuilder$C_TokenKind($c$.track($this().Diag($this().Tok.getLocation(), diag.err_expected)), tok.TokenKind.greater));
          return true;
        } finally {
          $c$.$destroy();
        }
      }
     case tok.TokenKind.greater:
      // Determine the location of the '>' token. Only consume this token
      // if the caller asked us to.
      RAngleLoc.$assignMove($this().Tok.getLocation());
      if (ConsumeLastToken) {
        $this().ConsumeToken();
      }
      return false;
     case tok.TokenKind.greatergreater:
      RemainingToken = tok.TokenKind.greater;
      break;
     case tok.TokenKind.greatergreatergreater:
      RemainingToken = tok.TokenKind.greatergreater;
      break;
     case tok.TokenKind.greaterequal:
      RemainingToken = tok.TokenKind.equal;
      ReplacementStr = $tryClone($("> ="));
      break;
     case tok.TokenKind.greatergreaterequal:
      RemainingToken = tok.TokenKind.greaterequal;
      break;
    }
    
    // This template-id is terminated by a token which starts with a '>'. Outside
    // C++11, this is now error recovery, and in C++11, this is error recovery if
    // the token isn't '>>' or '>>>'.
    // '>>>' is for CUDA, where this sequence of characters is parsed into
    // tok::greatergreatergreater, rather than two separate tokens.
    //
    // We always allow this for Objective-C type parameter and type argument
    // lists.
    RAngleLoc.$assignMove($this().Tok.getLocation());
    Token Next = new Token($this().NextToken());
    if (!ObjCGenericList) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        // The source range of the '>>' or '>=' at the start of the token.
        CharSourceRange ReplacementRange = CharSourceRange.getCharRange(/*NO_COPY*/RAngleLoc, 
            Lexer.AdvanceToTokenCharacter(/*NO_COPY*/RAngleLoc, 2, $this().PP.getSourceManager(), 
                $this().getLangOpts()));
        
        // A hint to put a space between the '>>'s. In order to make the hint as
        // clear as possible, we include the characters either side of the space in
        // the replacement, rather than just inserting a space at SecondCharLoc.
        FixItHint Hint1 = FixItHint.CreateReplacement(/*NO_COPY*/ReplacementRange, 
            new StringRef(ReplacementStr));
        
        // A hint to put another space after the token, if it would otherwise be
        // lexed differently.
        FixItHint Hint2/*J*/= new FixItHint();
        if ((RemainingToken == tok.TokenKind.greater
           || RemainingToken == tok.TokenKind.greatergreater)
           && (Next.isOneOf$T(tok.TokenKind.greater, tok.TokenKind.greatergreater, 
            tok.TokenKind.greatergreatergreater, tok.TokenKind.equal, 
            tok.TokenKind.greaterequal, tok.TokenKind.greatergreaterequal, 
            tok.TokenKind.equalequal))
           && $this().areTokensAdjacent($this().Tok, Next)) {
          Hint2.$assignMove(FixItHint.CreateInsertion(Next.getLocation(), new StringRef(/*KEEP_STR*/$SPACE)));
        }
        
        /*uint*/int DiagId = diag.err_two_right_angle_brackets_need_space;
        if ($this().getLangOpts().CPlusPlus11
           && ($this().Tok.is(tok.TokenKind.greatergreater) || $this().Tok.is(tok.TokenKind.greatergreatergreater))) {
          DiagId = diag.warn_cxx98_compat_two_right_angle_brackets;
        } else if ($this().Tok.is(tok.TokenKind.greaterequal)) {
          DiagId = diag.err_right_angle_bracket_equal_needs_space;
        }
        $c$.clean($out_DiagnosticBuilder$C_FixItHint$C($out_DiagnosticBuilder$C_FixItHint$C($c$.track($this().Diag($this().Tok.getLocation(), DiagId)), Hint1), Hint2));
      } finally {
        $c$.$destroy();
      }
    }
    
    // Strip the initial '>' from the token.
    Token PrevTok = new Token($this().Tok);
    if (RemainingToken == tok.TokenKind.equal && Next.is(tok.TokenKind.equal)
       && $this().areTokensAdjacent($this().Tok, Next)) {
      // Join two adjacent '=' tokens into one, for cases like:
      //   void (*p)() = f<int>;
      //   return f<int>==p;
      $this().ConsumeToken();
      $this().Tok.setKind(tok.TokenKind.equalequal);
      $this().Tok.setLength($this().Tok.getLength() + 1);
    } else {
      $this().Tok.setKind(RemainingToken);
      $this().Tok.setLength($this().Tok.getLength() - 1);
    }
    $this().Tok.setLocation(Lexer.AdvanceToTokenCharacter(/*NO_COPY*/RAngleLoc, 1, 
            $this().PP.getSourceManager(), 
            $this().getLangOpts()));
    
    // The advance from '>>' to '>' in a ObjectiveC template argument list needs
    // to be properly reflected in the token cache to allow correct interaction
    // between annotation and backtracking.
    if (ObjCGenericList && PrevTok.getKind() == tok.TokenKind.greatergreater
       && RemainingToken == tok.TokenKind.greater && $this().PP.IsPreviousCachedToken(PrevTok)) {
      PrevTok.setKind(RemainingToken);
      PrevTok.setLength(1);
      // Break tok::greatergreater into two tok::greater but only add the second
      // one in case the client asks to consume the last token.
      if (ConsumeLastToken) {
        $this().PP.ReplacePreviousCachedToken(/*{ */new ArrayRefToken(new /*const*/ Token [/*2*/] {PrevTok, $this().Tok})/* }*/);
      } else {
        $this().PP.ReplacePreviousCachedToken(/*{ */new ArrayRefToken(new /*const*/ Token [/*1*/] {PrevTok})/* }*/);
      }
    }
    if (!ConsumeLastToken) {
      // Since we're not supposed to consume the '>' token, we need to push
      // this token and revert the current token back to the '>'.
      $this().PP.EnterToken($this().Tok);
      $this().Tok.setKind(tok.TokenKind.greater);
      $this().Tok.setLength(1);
      $this().Tok.setLocation(/*NO_COPY*/RAngleLoc);
    }
    return false;
  }


/// \brief Parses a template-id that after the template name has
/// already been parsed.
///
/// This routine takes care of parsing the enclosed template argument
/// list ('<' template-parameter-list [opt] '>') and placing the
/// results into a form that can be transferred to semantic analysis.
///
/// \param Template the template declaration produced by isTemplateName
///
/// \param TemplateNameLoc the source location of the template name
///
/// \param SS if non-NULL, the nested-name-specifier preceding the
/// template name.
///
/// \param ConsumeLastToken if true, then we will consume the last
/// token that forms the template-id. Otherwise, we will leave the
/// last token in the stream (e.g., so that it can be replaced with an
/// annotation token).
//<editor-fold defaultstate="collapsed" desc="clang::Parser::ParseTemplateIdAfterTemplateName">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseTemplate.cpp", line = 898,
   FQN="clang::Parser::ParseTemplateIdAfterTemplateName", NM="_ZN5clang6Parser32ParseTemplateIdAfterTemplateNameENS_9OpaquePtrINS_12TemplateNameEEENS_14SourceLocationERKNS_12CXXScopeSpecEbRS4_RN4llvm11SmallVectorINS_22ParsedTemplateArgumentELj16EEES8_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseTemplate.cpp -nm=_ZN5clang6Parser32ParseTemplateIdAfterTemplateNameENS_9OpaquePtrINS_12TemplateNameEEENS_14SourceLocationERKNS_12CXXScopeSpecEbRS4_RN4llvm11SmallVectorINS_22ParsedTemplateArgumentELj16EEES8_")
  //</editor-fold>
  protected /*private*/ boolean ParseTemplateIdAfterTemplateName(OpaquePtr<TemplateName> Template, 
                                  SourceLocation TemplateNameLoc, 
                                  final /*const*/ CXXScopeSpec /*&*/ SS, 
                                  boolean ConsumeLastToken, 
                                  final SourceLocation /*&*/ LAngleLoc, 
                                  final SmallVector<ParsedTemplateArgument> /*&*/ TemplateArgs, 
                                  final SourceLocation /*&*/ RAngleLoc) {
    assert ($this().Tok.is(tok.TokenKind.less)) : "Must have already parsed the template-name";
    
    // Consume the '<'.
    LAngleLoc.$assignMove($this().ConsumeToken());
    
    // Parse the optional template-argument-list.
    boolean Invalid = false;
    {
      GreaterThanIsOperatorScope G = null;
      try {
        G/*J*/= new GreaterThanIsOperatorScope($this().GreaterThanIsOperator$Ref, false);
        if ($this().Tok.isNot(tok.TokenKind.greater) && $this().Tok.isNot(tok.TokenKind.greatergreater)) {
          Invalid = $this().ParseTemplateArgumentList(TemplateArgs);
        }
        if (Invalid) {
          // Try to find the closing '>'.
          if (ConsumeLastToken) {
            $this().SkipUntil(tok.TokenKind.greater, SkipUntilFlags.StopAtSemi);
          } else {
            $this().SkipUntil(tok.TokenKind.greater, $bitor_SkipUntilFlags(/*KEEP_ENUM*/SkipUntilFlags.StopAtSemi, /*KEEP_ENUM*/SkipUntilFlags.StopBeforeMatch));
          }
          return true;
        }
      } finally {
        if (G != null) { G.$destroy(); }
      }
    }
    
    return $this().ParseGreaterThanInTemplateList(RAngleLoc, ConsumeLastToken, 
        /*ObjCGenericList=*/ false);
  }


/// \brief Replace the tokens that form a simple-template-id with an
/// annotation token containing the complete template-id.
///
/// The first token in the stream must be the name of a template that
/// is followed by a '<'. This routine will parse the complete
/// simple-template-id and replace the tokens with a single annotation
/// token with one of two different kinds: if the template-id names a
/// type (and \p AllowTypeAnnotation is true), the annotation token is
/// a type annotation that includes the optional nested-name-specifier
/// (\p SS). Otherwise, the annotation token is a template-id
/// annotation that does not include the optional
/// nested-name-specifier.
///
/// \param Template  the declaration of the template named by the first
/// token (an identifier), as returned from \c Action::isTemplateName().
///
/// \param TNK the kind of template that \p Template
/// refers to, as returned from \c Action::isTemplateName().
///
/// \param SS if non-NULL, the nested-name-specifier that precedes
/// this template name.
///
/// \param TemplateKWLoc if valid, specifies that this template-id
/// annotation was preceded by the 'template' keyword and gives the
/// location of that keyword. If invalid (the default), then this
/// template-id was not preceded by a 'template' keyword.
///
/// \param AllowTypeAnnotation if true (the default), then a
/// simple-template-id that refers to a class template, template
/// template parameter, or other template that produces a type will be
/// replaced with a type annotation token. Otherwise, the
/// simple-template-id is always replaced with a template-id
/// annotation token.
///
/// If an unrecoverable parse error occurs and no annotation token can be
/// formed, this function returns true.
///
//<editor-fold defaultstate="collapsed" desc="clang::Parser::AnnotateTemplateIdToken">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseTemplate.cpp", line = 969,
   FQN="clang::Parser::AnnotateTemplateIdToken", NM="_ZN5clang6Parser23AnnotateTemplateIdTokenENS_9OpaquePtrINS_12TemplateNameEEENS_16TemplateNameKindERNS_12CXXScopeSpecENS_14SourceLocationERNS_13UnqualifiedIdEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseTemplate.cpp -nm=_ZN5clang6Parser23AnnotateTemplateIdTokenENS_9OpaquePtrINS_12TemplateNameEEENS_16TemplateNameKindERNS_12CXXScopeSpecENS_14SourceLocationERNS_13UnqualifiedIdEb")
  //</editor-fold>
  protected /*private*/ boolean AnnotateTemplateIdToken(OpaquePtr<TemplateName> Template, TemplateNameKind TNK, 
                         final CXXScopeSpec /*&*/ SS, 
                         SourceLocation TemplateKWLoc, 
                         final UnqualifiedId /*&*/ TemplateName) {
    return $this().AnnotateTemplateIdToken(Template, TNK, 
                         SS, 
                         TemplateKWLoc, 
                         TemplateName, 
                         true);
  }
  protected /*private*/ boolean AnnotateTemplateIdToken(OpaquePtr<TemplateName> Template, TemplateNameKind TNK, 
                         final CXXScopeSpec /*&*/ SS, 
                         SourceLocation TemplateKWLoc, 
                         final UnqualifiedId /*&*/ TemplateName, 
                         boolean AllowTypeAnnotation/*= true*/) {
    SmallVector<ParsedTemplateArgument> TemplateArgs = null;
    try {
      assert ($this().getLangOpts().CPlusPlus) : "Can only annotate template-ids in C++";
      assert (Template.$bool() && $this().Tok.is(tok.TokenKind.less)) : "Parser isn't at the beginning of a template-id";
      
      // Consume the template-name.
      SourceLocation TemplateNameLoc = TemplateName.getSourceRange().getBegin();
      
      // Parse the enclosed template argument list.
      SourceLocation LAngleLoc/*J*/= new SourceLocation(), RAngleLoc/*J*/= new SourceLocation();
      TemplateArgs/*J*/= new SmallVector<ParsedTemplateArgument>(16, new ParsedTemplateArgument());
      boolean Invalid = $this().ParseTemplateIdAfterTemplateName(new OpaquePtr<TemplateName>(Template), 
          new SourceLocation(TemplateNameLoc), 
          SS, false, LAngleLoc, 
          TemplateArgs, 
          RAngleLoc);
      if (Invalid) {
        // If we failed to parse the template ID but skipped ahead to a >, we're not
        // going to be able to form a token annotation.  Eat the '>' if present.
        $this().TryConsumeToken(tok.TokenKind.greater);
        return true;
      }
      
      MutableArrayRef<ParsedTemplateArgument> TemplateArgsPtr/*J*/= new MutableArrayRef<ParsedTemplateArgument>(TemplateArgs);
      
      // Build the annotation token.
      if (TNK == TemplateNameKind.TNK_Type_template && AllowTypeAnnotation) {
        ActionResult<OpaquePtr<QualType> > Type = $this().Actions.ActOnTemplateIdType(SS, new SourceLocation(TemplateKWLoc), 
            new OpaquePtr<TemplateName>(Template), new SourceLocation(TemplateNameLoc), 
            new SourceLocation(LAngleLoc), new MutableArrayRef<ParsedTemplateArgument>(TemplateArgsPtr), new SourceLocation(RAngleLoc));
        if (Type.isInvalid()) {
          // If we failed to parse the template ID but skipped ahead to a >, we're not
          // going to be able to form a token annotation.  Eat the '>' if present.
          $this().TryConsumeToken(tok.TokenKind.greater);
          return true;
        }
        
        $this().Tok.setKind(tok.TokenKind.annot_typename);
        setTypeAnnotation($this().Tok, Type.get());
        if (SS.isNotEmpty()) {
          $this().Tok.setLocation(SS.getBeginLoc());
        } else if (TemplateKWLoc.isValid()) {
          $this().Tok.setLocation(/*NO_COPY*/TemplateKWLoc);
        } else {
          $this().Tok.setLocation(/*NO_COPY*/TemplateNameLoc);
        }
      } else {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          // Build a template-id annotation token that can be processed
          // later.
          $this().Tok.setKind(tok.TokenKind.annot_template_id);
          TemplateIdAnnotation /*P*/ TemplateId = TemplateIdAnnotation.Allocate(TemplateArgs.size(), $this().TemplateIds);
          TemplateId.TemplateNameLoc.$assign(TemplateNameLoc);
          if (TemplateName.getKind() == UnqualifiedId.IdKind.IK_Identifier) {
            TemplateId.Name = TemplateName.Unnamed_field1.Identifier;
            TemplateId.Operator = OverloadedOperatorKind.OO_None;
          } else {
            TemplateId.Name = null;
            TemplateId.Operator = TemplateName.Unnamed_field1.OperatorFunctionId.Operator;
          }
          TemplateId.SS.$assign(SS);
          TemplateId.TemplateKWLoc.$assign(TemplateKWLoc);
          TemplateId.Template.$assign(Template);
          TemplateId.Kind = TNK;
          TemplateId.LAngleLoc.$assign(LAngleLoc);
          TemplateId.RAngleLoc.$assign(RAngleLoc);
          type$ptr<ParsedTemplateArgument> /*P*/ Args = TemplateId.getTemplateArgs();
          for (/*uint*/int Arg = 0, ArgEnd = TemplateArgs.size(); Arg != ArgEnd; ++Arg)  {
            $c$.clean(Args.$at(Arg).$assignMove($c$.track(new ParsedTemplateArgument(TemplateArgs.$at(Arg)))));
          }
          $this().Tok.setAnnotationValue(TemplateId);
          if (TemplateKWLoc.isValid()) {
            $this().Tok.setLocation(/*NO_COPY*/TemplateKWLoc);
          } else {
            $this().Tok.setLocation(/*NO_COPY*/TemplateNameLoc);
          }
        } finally {
          $c$.$destroy();
        }
      }
      
      // Common fields for the annotation token
      $this().Tok.setAnnotationEndLoc(/*NO_COPY*/RAngleLoc);
      
      // In case the tokens were cached, have Preprocessor replace them with the
      // annotation token.
      $this().PP.AnnotateCachedTokens($this().Tok);
      return false;
    } finally {
      if (TemplateArgs != null) { TemplateArgs.$destroy(); }
    }
  }


/// \brief Replaces a template-id annotation token with a type
/// annotation token.
///
/// If there was a failure when forming the type from the template-id,
/// a type annotation token will still be created, but will have a
/// NULL type pointer to signify an error.
//<editor-fold defaultstate="collapsed" desc="clang::Parser::AnnotateTemplateIdTokenAsType">
@Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseTemplate.cpp", line = 1065,
   FQN="clang::Parser::AnnotateTemplateIdTokenAsType", NM="_ZN5clang6Parser29AnnotateTemplateIdTokenAsTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseTemplate.cpp -nm=_ZN5clang6Parser29AnnotateTemplateIdTokenAsTypeEv")
  //</editor-fold>
  protected /*private*/ void AnnotateTemplateIdTokenAsType() {
    assert ($this().Tok.is(tok.TokenKind.annot_template_id)) : "Requires template-id tokens";
    
    TemplateIdAnnotation /*P*/ TemplateId = $this().takeTemplateIdAnnotation($this().Tok);
    assert ((TemplateId.Kind == TemplateNameKind.TNK_Type_template || TemplateId.Kind == TemplateNameKind.TNK_Dependent_template_name)) : "Only works for type and dependent templates";
    
    MutableArrayRef<ParsedTemplateArgument> TemplateArgsPtr/*J*/= new MutableArrayRef<ParsedTemplateArgument>(TemplateId.getTemplateArgs(), 
        TemplateId.NumArgs, false);
    
    ActionResult<OpaquePtr<QualType> > Type = $this().Actions.ActOnTemplateIdType(TemplateId.SS, 
        new SourceLocation(TemplateId.TemplateKWLoc), 
        new OpaquePtr<TemplateName>(TemplateId.Template), 
        new SourceLocation(TemplateId.TemplateNameLoc), 
        new SourceLocation(TemplateId.LAngleLoc), 
        new MutableArrayRef<ParsedTemplateArgument>(TemplateArgsPtr), 
        new SourceLocation(TemplateId.RAngleLoc));
    // Create the new "type" annotation token.
    $this().Tok.setKind(tok.TokenKind.annot_typename);
    setTypeAnnotation($this().Tok, Type.isInvalid() ? new OpaquePtr<QualType>(null) : Type.get());
    if (TemplateId.SS.isNotEmpty()) { // it was a C++ qualified type name.
      $this().Tok.setLocation(TemplateId.SS.getBeginLoc());
    }
    // End location stays the same
    
    // Replace the template-id annotation token, and possible the scope-specifier
    // that precedes it, with the typename annotation token.
    $this().PP.AnnotateCachedTokens($this().Tok);
  }


/// \brief Determine whether the current tokens can only be parsed as a 
/// template argument list (starting with the '<') and never as a '<' 
/// expression.
//<editor-fold defaultstate="collapsed" desc="clang::Parser::IsTemplateArgumentList">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseTemplate.cpp", line = 1232,
   FQN="clang::Parser::IsTemplateArgumentList", NM="_ZN5clang6Parser22IsTemplateArgumentListEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseTemplate.cpp -nm=_ZN5clang6Parser22IsTemplateArgumentListEj")
  //</editor-fold>
  protected /*private*/ boolean IsTemplateArgumentList() {
    return $this().IsTemplateArgumentList(0);
  }
  protected /*private*/ boolean IsTemplateArgumentList(/*uint*/int Skip/*= 0*/) {
      //<editor-fold defaultstate="collapsed" desc="AlwaysRevertAction">
      @Converted(kind = Converted.Kind.AUTO,
       source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseTemplate.cpp", line = 1233,
       FQN="AlwaysRevertAction", NM="_ZZN5clang6Parser22IsTemplateArgumentListEjE18AlwaysRevertAction",
       cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseTemplate.cpp -nm=_ZZN5clang6Parser22IsTemplateArgumentListEjE18AlwaysRevertAction")
      //</editor-fold>
       class/*struct*/ AlwaysRevertAction extends /**/ TentativeParsingAction implements Destructors.ClassWithDestructor {
        //<editor-fold defaultstate="collapsed" desc="clang::Parser::IsTemplateArgumentList(unsigned int)::AlwaysRevertAction::AlwaysRevertAction">
        @Converted(kind = Converted.Kind.AUTO,
         source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseTemplate.cpp", line = 1234,
         FQN="clang::Parser::IsTemplateArgumentList(unsigned int)::AlwaysRevertAction::AlwaysRevertAction", NM="_ZZN5clang6Parser22IsTemplateArgumentListEjEN18AlwaysRevertActionC1ERS0_",
         cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseTemplate.cpp -nm=_ZZN5clang6Parser22IsTemplateArgumentListEjEN18AlwaysRevertActionC1ERS0_")
        //</editor-fold>
        public AlwaysRevertAction(final Parser /*&*/ P) {
          // : TentativeParsingAction(P) 
          //START JInit
          super(P);
          //END JInit
        }
  
        //<editor-fold defaultstate="collapsed" desc="clang::Parser::IsTemplateArgumentList(unsigned int)::AlwaysRevertAction::~AlwaysRevertAction">
        @Converted(kind = Converted.Kind.AUTO,
         source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseTemplate.cpp", line = 1235,
         FQN="clang::Parser::IsTemplateArgumentList(unsigned int)::AlwaysRevertAction::~AlwaysRevertAction", NM="_ZZN5clang6Parser22IsTemplateArgumentListEjEN18AlwaysRevertActionD0Ev",
         cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseTemplate.cpp -nm=_ZZN5clang6Parser22IsTemplateArgumentListEjEN18AlwaysRevertActionD0Ev")
        //</editor-fold>
        public void $destroy() {
          Revert();
          super.$destroy();
        }
  
        
        @Override public String toString() {
          return "" + super.toString(); // NOI18N
        }
      };
    AlwaysRevertAction Tentative/*J*/= new  AlwaysRevertAction(/*Deref*/$this());
    try {
//      AlwaysRevertAction Tentative/*J*/= new  AlwaysRevertAction(/*Deref*/this);
      while ((Skip != 0)) {
        $this().ConsumeToken();
        --Skip;
      }
      
      // '<'
      if (!$this().TryConsumeToken(tok.TokenKind.less)) {
        return false;
      }
      
      // An empty template argument list.
      if ($this().Tok.is(tok.TokenKind.greater)) {
        return true;
      }
      
      // See whether we have declaration specifiers, which indicate a type.
      while ($this().isCXXDeclarationSpecifier() == TPResult.True) {
        $this().ConsumeToken();
      }
      
      // If we have a '>' or a ',' then this is a template argument list.
      return $this().Tok.isOneOf(tok.TokenKind.greater, tok.TokenKind.comma);
    } finally {
      if (Tentative != null) { Tentative.$destroy(); }
    }
  }


/// ParseTemplateArgumentList - Parse a C++ template-argument-list
/// (C++ [temp.names]). Returns true if there was an error.
///
///       template-argument-list: [C++ 14.2]
///         template-argument
///         template-argument-list ',' template-argument
//<editor-fold defaultstate="collapsed" desc="clang::Parser::ParseTemplateArgumentList">
@Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseTemplate.cpp", line = 1265,
   FQN="clang::Parser::ParseTemplateArgumentList", NM="_ZN5clang6Parser25ParseTemplateArgumentListERN4llvm11SmallVectorINS_22ParsedTemplateArgumentELj16EEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseTemplate.cpp -nm=_ZN5clang6Parser25ParseTemplateArgumentListERN4llvm11SmallVectorINS_22ParsedTemplateArgumentELj16EEE")
  //</editor-fold>
  protected /*private*/ boolean ParseTemplateArgumentList(final SmallVector<ParsedTemplateArgument> /*&*/ TemplateArgs) {
    EnterExpressionEvaluationContext EvalContext = null;
    ColonProtectionRAIIObject ColonProtection = null;
    try {
      // Template argument lists are constant-evaluation contexts.
      EvalContext/*J*/= new EnterExpressionEvaluationContext($this().Actions, Sema.ExpressionEvaluationContext.ConstantEvaluated);
      ColonProtection/*J*/= new ColonProtectionRAIIObject(/*Deref*/$this(), false);
      
      do {
        ParsedTemplateArgument Arg = null;
        try {
          Arg = $this().ParseTemplateArgument();
          SourceLocation EllipsisLoc/*J*/= new SourceLocation();
          if ($this().TryConsumeToken(tok.TokenKind.ellipsis, EllipsisLoc)) {
            JavaCleaner $c$ = $createJavaCleaner();
            try {
              $c$.clean(Arg.$assignMove($c$.track($this().Actions.ActOnPackExpansion(Arg, new SourceLocation(EllipsisLoc)))));
            } finally {
              $c$.$destroy();
            }
          }
          if (Arg.isInvalid()) {
            $this().SkipUntil(tok.TokenKind.comma, tok.TokenKind.greater, $bitor_SkipUntilFlags(/*KEEP_ENUM*/SkipUntilFlags.StopAtSemi, /*KEEP_ENUM*/SkipUntilFlags.StopBeforeMatch));
            return true;
          }
          
          // Save this template argument.
          TemplateArgs.push_back_T$C$R(Arg);
        } finally {
          if (Arg != null) { Arg.$destroy(); }
        }
        // If the next token is a comma, consume it and keep reading
        // arguments.
      } while ($this().TryConsumeToken(tok.TokenKind.comma));
      
      return false;
    } finally {
      if (ColonProtection != null) { ColonProtection.$destroy(); }
      if (EvalContext != null) { EvalContext.$destroy(); }
    }
  }


/// \brief Parse a C++ template template argument.
//<editor-fold defaultstate="collapsed" desc="clang::Parser::ParseTemplateTemplateArgument">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseTemplate.cpp", line = 1102,
   FQN="clang::Parser::ParseTemplateTemplateArgument", NM="_ZN5clang6Parser29ParseTemplateTemplateArgumentEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseTemplate.cpp -nm=_ZN5clang6Parser29ParseTemplateTemplateArgumentEv")
  //</editor-fold>
  protected /*private*/ ParsedTemplateArgument ParseTemplateTemplateArgument() {
    CXXScopeSpec SS = null;
    ParsedTemplateArgument Result = null;
    try {
      if (!$this().Tok.is(tok.TokenKind.identifier) && !$this().Tok.is(tok.TokenKind.coloncolon)
         && !$this().Tok.is(tok.TokenKind.annot_cxxscope)) {
        return new ParsedTemplateArgument();
      }
      
      // C++0x [temp.arg.template]p1:
      //   A template-argument for a template template-parameter shall be the name
      //   of a class template or an alias template, expressed as id-expression.
      //   
      // We parse an id-expression that refers to a class template or alias
      // template. The grammar we parse is:
      //
      //   nested-name-specifier[opt] template[opt] identifier ...[opt]
      //
      // followed by a token that terminates a template argument, such as ',', 
      // '>', or (in some cases) '>>'.
      SS/*J*/= new CXXScopeSpec(); // nested-name-specifier, if present
      $this().ParseOptionalCXXScopeSpecifier(SS, new OpaquePtr<QualType>(null), 
          /*EnteringContext=*/ false);
      
      Result/*J*/= new ParsedTemplateArgument();
      SourceLocation EllipsisLoc/*J*/= new SourceLocation();
      if (SS.isSet() && $this().Tok.is(tok.TokenKind.kw_template)) {
        // Parse the optional 'template' keyword following the 
        // nested-name-specifier.
        SourceLocation TemplateKWLoc = $this().ConsumeToken();
        if ($this().Tok.is(tok.TokenKind.identifier)) {
          // We appear to have a dependent template name.
          UnqualifiedId Name/*J*/= new UnqualifiedId();
          Name.setIdentifier($this().Tok.getIdentifierInfo(), $this().Tok.getLocation());
          $this().ConsumeToken(); // the identifier
          
          $this().TryConsumeToken(tok.TokenKind.ellipsis, EllipsisLoc);
          
          // If the next token signals the end of a template argument,
          // then we have a dependent template name that could be a template
          // template argument.
          OpaquePtr<TemplateName> Template/*J*/= new OpaquePtr<TemplateName>();
          if (isEndOfTemplateArgument(new Token($this().Tok))
             && ($this().Actions.ActOnDependentTemplateName($this().getCurScope(), SS, new SourceLocation(TemplateKWLoc), Name, 
              /*ObjectType=*/ new OpaquePtr<QualType>(null), 
              /*EnteringContext=*/ false, Template).getValue() != 0)) {
            JavaCleaner $c$ = $createJavaCleaner();
            try {
              $c$.clean(Result.$assignMove($c$.track(new ParsedTemplateArgument(SS, new OpaquePtr<TemplateName>(Template), new SourceLocation(Name.StartLocation)))));
            } finally {
              $c$.$destroy();
            }
          }
        }
      } else if ($this().Tok.is(tok.TokenKind.identifier)) {
        // We may have a (non-dependent) template name.
        OpaquePtr<TemplateName> Template/*J*/= new OpaquePtr<TemplateName>();
        UnqualifiedId Name/*J*/= new UnqualifiedId();
        Name.setIdentifier($this().Tok.getIdentifierInfo(), $this().Tok.getLocation());
        $this().ConsumeToken(); // the identifier
        
        $this().TryConsumeToken(tok.TokenKind.ellipsis, EllipsisLoc);
        if (isEndOfTemplateArgument(new Token($this().Tok))) {
          bool$ref MemberOfUnknownSpecialization = create_bool$ref();
          TemplateNameKind TNK = $this().Actions.isTemplateName($this().getCurScope(), SS, 
              /*hasTemplateKeyword=*/ false, Name, 
              /*ObjectType=*/ new OpaquePtr<QualType>(null), 
              /*EnteringContext=*/ false, Template, MemberOfUnknownSpecialization);
          if (TNK == TemplateNameKind.TNK_Dependent_template_name || TNK == TemplateNameKind.TNK_Type_template) {
            JavaCleaner $c$ = $createJavaCleaner();
            try {
              // We have an id-expression that refers to a class template or
              // (C++0x) alias template. 
              $c$.clean(Result.$assignMove($c$.track(new ParsedTemplateArgument(SS, new OpaquePtr<TemplateName>(Template), new SourceLocation(Name.StartLocation)))));
            } finally {
              $c$.$destroy();
            }
          }
        }
      }
      
      // If this is a pack expansion, build it as such.
      if (EllipsisLoc.isValid() && !Result.isInvalid()) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean(Result.$assignMove($c$.track($this().Actions.ActOnPackExpansion(Result, new SourceLocation(EllipsisLoc)))));
        } finally {
          $c$.$destroy();
        }
      }
      
      return new ParsedTemplateArgument(JD$Move.INSTANCE, Result);
    } finally {
      if (Result != null) { Result.$destroy(); }
      if (SS != null) { SS.$destroy(); }
    }
  }


/// ParseTemplateArgument - Parse a C++ template argument (C++ [temp.names]).
///
///       template-argument: [C++ 14.2]
///         constant-expression
///         type-id
///         id-expression
//<editor-fold defaultstate="collapsed" desc="clang::Parser::ParseTemplateArgument">
@Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseTemplate.cpp", line = 1185,
   FQN="clang::Parser::ParseTemplateArgument", NM="_ZN5clang6Parser21ParseTemplateArgumentEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseTemplate.cpp -nm=_ZN5clang6Parser21ParseTemplateArgumentEv")
  //</editor-fold>
  protected /*private*/ ParsedTemplateArgument ParseTemplateArgument() {
    // C++ [temp.arg]p2:
    //   In a template-argument, an ambiguity between a type-id and an
    //   expression is resolved to a type-id, regardless of the form of
    //   the corresponding template-parameter.
    //
    // Therefore, we initially try to parse a type-id.  
    if ($this().isCXXTypeId(TentativeCXXTypeIdContext.TypeIdAsTemplateArgument)) {
      SourceLocation Loc = $this().Tok.getLocation();
      ActionResult<OpaquePtr<QualType> > TypeArg = $this().ParseTypeName(/*Range=*/ (SourceRange /*P*/ )null, 
          Declarator.TheContext.TemplateTypeArgContext);
      if (TypeArg.isInvalid()) {
        return new ParsedTemplateArgument();
      }
      
      return new ParsedTemplateArgument(ParsedTemplateArgument.KindType.Type, 
          TypeArg.get().getAsOpaquePtr(), 
          new SourceLocation(Loc));
    }
    {
      TentativeParsingAction TPA = null;
      ParsedTemplateArgument TemplateTemplateArgument = null;
      try {
        TPA/*J*/= new TentativeParsingAction(/*Deref*/$this());
        
        TemplateTemplateArgument = $this().ParseTemplateTemplateArgument();
        if (!TemplateTemplateArgument.isInvalid()) {
          TPA.Commit();
          return new ParsedTemplateArgument(JD$Move.INSTANCE, TemplateTemplateArgument);
        }
        
        // Revert this tentative parse to parse a non-type template argument.
        TPA.Revert();
      } finally {
        if (TemplateTemplateArgument != null) { TemplateTemplateArgument.$destroy(); }
        if (TPA != null) { TPA.$destroy(); }
      }
    }
    
    // Parse a non-type template argument. 
    SourceLocation Loc = $this().Tok.getLocation();
    ActionResultTTrue<Expr /*P*/ > ExprArg = $this().ParseConstantExpression(TypeCastState.MaybeTypeCast);
    if (ExprArg.isInvalid() || !(ExprArg.get() != null)) {
      return new ParsedTemplateArgument();
    }
    
    return new ParsedTemplateArgument(ParsedTemplateArgument.KindType.NonType, 
        ExprArg.get(), new SourceLocation(Loc));
  }


/// \brief Parse a C++ explicit template instantiation
/// (C++ [temp.explicit]).
///
///       explicit-instantiation:
///         'extern' [opt] 'template' declaration
///
/// Note that the 'extern' is a GNU extension and C++11 feature.
//<editor-fold defaultstate="collapsed" desc="clang::Parser::ParseExplicitInstantiation">
@Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseTemplate.cpp", line = 1299,
   FQN="clang::Parser::ParseExplicitInstantiation", NM="_ZN5clang6Parser26ParseExplicitInstantiationEjNS_14SourceLocationES1_RS1_NS_15AccessSpecifierE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseTemplate.cpp -nm=_ZN5clang6Parser26ParseExplicitInstantiationEjNS_14SourceLocationES1_RS1_NS_15AccessSpecifierE")
  //</editor-fold>
  protected /*private*/ Decl /*P*/ ParseExplicitInstantiation(/*uint*/int Context, 
                            SourceLocation ExternLoc, 
                            SourceLocation TemplateLoc, 
                            final SourceLocation /*&*/ DeclEnd) {
    return $this().ParseExplicitInstantiation(Context, 
                            ExternLoc, 
                            TemplateLoc, 
                            DeclEnd, 
                            AccessSpecifier.AS_none);
  }
  protected /*private*/ Decl /*P*/ ParseExplicitInstantiation(/*uint*/int Context, 
                            SourceLocation ExternLoc, 
                            SourceLocation TemplateLoc, 
                            final SourceLocation /*&*/ DeclEnd, 
                            AccessSpecifier AS/*= AS_none*/) {
    ParsingDeclRAIIObject ParsingTemplateParams = null;
    try {
      // This isn't really required here.
      ParsingTemplateParams/*J*/= new ParsingDeclRAIIObject(/*Deref*/$this(), ParsingDeclRAIIObject.NoParent_t.NoParent);
      
      return $this().ParseSingleDeclarationAfterTemplate(Context, 
          new ParsedTemplateInfo(new SourceLocation(ExternLoc), 
              new SourceLocation(TemplateLoc)), 
          ParsingTemplateParams, 
          DeclEnd, AS);
    } finally {
      if (ParsingTemplateParams != null) { ParsingTemplateParams.$destroy(); }
    }
  }

} // END OF class Parser_ParseTemplate
