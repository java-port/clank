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
import static org.llvm.adt.ADTAliases.*;
import static org.llvm.support.llvm.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
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
import org.clang.parse.java.ParseFunctionPointers.*;
import static org.clang.parse.Parser.*;
import static org.clang.sema.SemaClangGlobals.*;
import static org.clang.parse.impl.ParseObjcStatics.*;


//<editor-fold defaultstate="collapsed" desc="static type Parser_ParseObjc">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -empty-body -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType -split-class=clang::Parser@this -extends=Parser_ParseInit ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseObjc.cpp -nm=_ZN5clang6Parser16ParseObjCTryStmtENS_14SourceLocationE;_ZN5clang6Parser17ParseObjCTypeNameERNS_12ObjCDeclSpecENS_10Declarator10TheContextEPNS_16ParsedAttributesE;_ZN5clang6Parser18ParseObjCBoxedExprENS_14SourceLocationE;_ZN5clang6Parser18ParseObjCThrowStmtENS_14SourceLocationE;_ZN5clang6Parser19MaybeSkipAttributesENS_3tok15ObjCKeywordKindE;_ZN5clang6Parser19ParseObjCMethodDeclENS_14SourceLocationENS_3tok9TokenKindENS2_15ObjCKeywordKindEb;_ZN5clang6Parser20ParseObjCAtStatementENS_14SourceLocationE;_ZN5clang6Parser21ParseObjCArrayLiteralENS_14SourceLocationE;_ZN5clang6Parser21ParseObjCAtDirectivesEv;_ZN5clang6Parser21ParseObjCAtExpressionENS_14SourceLocationE;_ZN5clang6Parser22ParseObjCSelectorPieceERNS_14SourceLocationE;_ZN5clang6Parser22ParseObjCStringLiteralENS_14SourceLocationE;_ZN5clang6Parser22parseObjCTypeParamListEv;_ZN5clang6Parser23CheckNestedObjCContextsENS_14SourceLocationE;_ZN5clang6Parser23ParseObjCBooleanLiteralENS_14SourceLocationEb;_ZN5clang6Parser23ParseObjCNumericLiteralENS_14SourceLocationE;_ZN5clang6Parser24ParseLexedObjCMethodDefsERNS0_11LexedMethodEb;_ZN5clang6Parser24ParseObjCMethodPrototypeENS_3tok15ObjCKeywordKindEb;_ZN5clang6Parser24ParseObjCPropertyDynamicENS_14SourceLocationE;_ZN5clang6Parser25ParseObjCAtEndDeclarationENS_11SourceRangeE;_ZN5clang6Parser25ParseObjCCharacterLiteralENS_14SourceLocationE;_ZN5clang6Parser25ParseObjCEncodeExpressionENS_14SourceLocationE;_ZN5clang6Parser25ParseObjCMethodDefinitionEv;_ZN5clang6Parser25ParseObjCSynchronizedStmtENS_14SourceLocationE;_ZN5clang6Parser26ParseObjCDictionaryLiteralENS_14SourceLocationE;_ZN5clang6Parser26ParseObjCInterfaceDeclListENS_3tok15ObjCKeywordKindEPNS_4DeclE;_ZN5clang6Parser26ParseObjCMessageExpressionEv;_ZN5clang6Parser26ParseObjCPropertyAttributeERNS_12ObjCDeclSpecE;_ZN5clang6Parser26ParseObjCTypeQualifierListERNS_12ObjCDeclSpecENS_10Declarator10TheContextE;_ZN5clang6Parser26ParseObjCXXMessageReceiverERbRPv;_ZN5clang6Parser27ParseObjCAtAliasDeclarationENS_14SourceLocationE;_ZN5clang6Parser27ParseObjCAtClassDeclarationENS_14SourceLocationE;_ZN5clang6Parser27ParseObjCPropertySynthesizeENS_14SourceLocationE;_ZN5clang6Parser27ParseObjCProtocolExpressionENS_14SourceLocationE;_ZN5clang6Parser27ParseObjCProtocolReferencesERN4llvm15SmallVectorImplIPNS_4DeclEEERNS2_INS_14SourceLocationEEEbbRS7_SA_b;_ZN5clang6Parser27ParseObjCSelectorExpressionENS_14SourceLocationE;_ZN5clang6Parser28ParseObjCAutoreleasePoolStmtENS_14SourceLocationE;_ZN5clang6Parser29isSimpleObjCMessageExpressionEv;_ZN5clang6Parser30ParseObjCAtProtocolDeclarationENS_14SourceLocationERNS_16ParsedAttributesE;_ZN5clang6Parser30ParseObjCMessageExpressionBodyENS_14SourceLocationES1_NS_9OpaquePtrINS_8QualTypeEEEPNS_4ExprE;_ZN5clang6Parser30parseObjCProtocolQualifierTypeERNS_14SourceLocationE;_ZN5clang6Parser31ParseObjCAtInterfaceDeclarationENS_14SourceLocationERNS_16ParsedAttributesE;_ZN5clang6Parser31ParseObjCClassInstanceVariablesEPNS_4DeclENS_3tok15ObjCKeywordKindENS_14SourceLocationE;_ZN5clang6Parser32HelperActionsForIvarDeclarationsEPNS_4DeclENS_14SourceLocationERNS_24BalancedDelimiterTrackerERN4llvm15SmallVectorImplIS2_EEb;_ZN5clang6Parser35StashAwayMethodOrFunctionBodyTokensEPNS_4DeclE;_ZN5clang6Parser36ParseObjCAtImplementationDeclarationENS_14SourceLocationE;_ZN5clang6Parser36parseObjCTypeParamListOrProtocolRefsERNS0_22ObjCTypeParamListScopeERNS_14SourceLocationERN4llvm15SmallVectorImplISt4pairIPNS_14IdentifierInfoES3_EEES4_b;_ZN5clang6Parser37parseObjCTypeArgsOrProtocolQualifiersENS_9OpaquePtrINS_8QualTypeEEERNS_14SourceLocationERN4llvm15SmallVectorImplIS3_EES5_S5_RNS7_IPNS_4DeclEEERNS7_IS4_EES5_bb;_ZN5clang6Parser38parseObjCTypeArgsAndProtocolQualifiersENS_14SourceLocationENS_9OpaquePtrINS_8QualTypeEEEbRS1_;_ZN5clang6Parser38parseObjCTypeArgsAndProtocolQualifiersENS_9OpaquePtrINS_8QualTypeEEERNS_14SourceLocationERN4llvm15SmallVectorImplIS3_EES5_S5_RNS7_IPNS_4DeclEEERNS7_IS4_EES5_b;_ZN5clang6Parser43isStartOfObjCClassMessageMissingOpenBracketEv;_ZNK5clang6Parser18isTokIdentifier_inEv; -static-type=Parser_ParseObjc -package=org.clang.parse")
//</editor-fold>
public class Parser_ParseObjc extends Parser_ParseInit {
private final /*split clang::Parser*/ Parser $this() { return (Parser)this; }

//<editor-fold defaultstate="collapsed" desc="clang::Parser::CheckNestedObjCContexts">
@Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseObjc.cpp", line = 168,
   FQN="clang::Parser::CheckNestedObjCContexts", NM="_ZN5clang6Parser23CheckNestedObjCContextsENS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseObjc.cpp -nm=_ZN5clang6Parser23CheckNestedObjCContextsENS_14SourceLocationE")
  //</editor-fold>
  protected /*private*/ void CheckNestedObjCContexts(SourceLocation AtLoc) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      Sema.ObjCContainerKind ock = $this().Actions.getObjCContainerKind();
      if (ock == Sema.ObjCContainerKind.OCK_None) {
        return;
      }
      
      Decl /*P*/ Decl = $this().Actions.getObjCDeclContext();
      if (($this().CurParsedObjCImpl != null)) {
        $this().CurParsedObjCImpl.finish(new SourceRange(/*NO_COPY*/AtLoc));
      } else {
        $this().Actions.ActOnAtEnd($this().getCurScope(), new SourceRange(/*NO_COPY*/AtLoc));
      }
      $c$.clean($out_DiagnosticBuilder$C_FixItHint$C($c$.track($this().Diag(new SourceLocation(AtLoc), diag.err_objc_missing_end)), 
          FixItHint.CreateInsertion(/*NO_COPY*/AtLoc, new StringRef(/*KEEP_STR*/"@end\n"))));
      if ((Decl != null)) {
        $c$.clean($out_DiagnosticBuilder$C_int($c$.track($this().Diag(Decl.getLocStart(), diag.note_objc_container_start)), 
            (int)ock.getValue()));
      }
    } finally {
      $c$.$destroy();
    }
  }

//<editor-fold defaultstate="collapsed" desc="clang::Parser::ParseLexedObjCMethodDefs">
@Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseObjc.cpp", line = 3621,
   FQN="clang::Parser::ParseLexedObjCMethodDefs", NM="_ZN5clang6Parser24ParseLexedObjCMethodDefsERNS0_11LexedMethodEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseObjc.cpp -nm=_ZN5clang6Parser24ParseLexedObjCMethodDefsERNS0_11LexedMethodEb")
  //</editor-fold>
  protected /*private*/ void ParseLexedObjCMethodDefs(final LexedMethod /*&*/ LM, boolean parseMethod) {
    ParseScope BodyScope = null;
    try {
      // MCDecl might be null due to error in method or c-function  prototype, etc.
      Decl /*P*/ MCDecl = LM.D;
      boolean skip = (MCDecl != null)
         && ((parseMethod && !$this().Actions.isObjCMethodDecl(MCDecl))
         || (!parseMethod && $this().Actions.isObjCMethodDecl(MCDecl)));
      if (skip) {
        return;
      }
      
      // Save the current token position.
      SourceLocation OrigLoc = $this().Tok.getLocation();
      assert (!LM.Toks.empty()) : "ParseLexedObjCMethodDef - Empty body!";
      // Append the current token at the end of the new token stream so that it
      // doesn't get lost.
      LM.Toks.push_back($this().Tok);
      $this().PP.EnterTokenStream(new ArrayRefToken(LM.Toks), true);
      
      // Consume the previously pushed token.
      $this().ConsumeAnyToken(/*ConsumeCodeCompletionTok=*/ true);
      assert ($this().Tok.isOneOf$T(tok.TokenKind.l_brace, tok.TokenKind.kw_try, tok.TokenKind.colon)) : "Inline objective-c method not starting with '{' or 'try' or ':'";
      // Enter a scope for the method or c-function body.
      BodyScope/*J*/= new ParseScope($this(), 
          parseMethod ? Scope.ScopeFlags.ObjCMethodScope | Scope.ScopeFlags.FnScope | Scope.ScopeFlags.DeclScope : Scope.ScopeFlags.FnScope | Scope.ScopeFlags.DeclScope);
      
      // Tell the actions module that we have entered a method or c-function definition 
      // with the specified Declarator for the method/function.
      if (parseMethod) {
        $this().Actions.ActOnStartOfObjCMethodDef($this().getCurScope(), MCDecl);
      } else {
        $this().Actions.ActOnStartOfFunctionDef($this().getCurScope(), MCDecl);
      }
      if ($this().Tok.is(tok.TokenKind.kw_try)) {
        $this().ParseFunctionTryBlock(MCDecl, BodyScope);
      } else {
        if ($this().Tok.is(tok.TokenKind.colon)) {
          $this().ParseConstructorInitializer(MCDecl);
        } else {
          $this().Actions.ActOnDefaultCtorInitializers(MCDecl);
        }
        $this().ParseFunctionStatementBody(MCDecl, BodyScope);
      }
      if ($noteq_SourceLocation$C($this().Tok.getLocation(), OrigLoc)) {
        // Due to parsing error, we either went over the cached tokens or
        // there are still cached tokens left. If it's the latter case skip the
        // leftover tokens.
        // Since this is an uncommon situation that should be avoided, use the
        // expensive isBeforeInTranslationUnit call.
        if ($this().PP.getSourceManager().isBeforeInTranslationUnit($this().Tok.getLocation(), 
            /*NO_COPY*/OrigLoc)) {
          while ($noteq_SourceLocation$C($this().Tok.getLocation(), OrigLoc) && $this().Tok.isNot(tok.TokenKind.eof)) {
            $this().ConsumeAnyToken();
          }
        }
      }
    } finally {
      if (BodyScope != null) { BodyScope.$destroy(); }
    }
  }


// Objective-C External Declarations

/// Skips attributes after an Objective-C @ directive. Emits a diagnostic.
//<editor-fold defaultstate="collapsed" desc="clang::Parser::MaybeSkipAttributes">
@Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseObjc.cpp", line = 28,
   FQN="clang::Parser::MaybeSkipAttributes", NM="_ZN5clang6Parser19MaybeSkipAttributesENS_3tok15ObjCKeywordKindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseObjc.cpp -nm=_ZN5clang6Parser19MaybeSkipAttributesENS_3tok15ObjCKeywordKindE")
  //</editor-fold>
  protected /*private*/ void MaybeSkipAttributes(/*tok.ObjCKeywordKind*/char Kind) {
    ParsedAttributes attrs = null;
    try {
      attrs/*J*/= new ParsedAttributes($this().AttrFactory);
      if ($this().Tok.is(tok.TokenKind.kw___attribute)) {
        if (Kind == tok.ObjCKeywordKind.objc_interface || Kind == tok.ObjCKeywordKind.objc_protocol) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            $c$.clean($out$Same2Bool($c$.track($this().Diag($this().Tok, diag.err_objc_postfix_attribute_hint)), 
                (Kind == tok.ObjCKeywordKind.objc_protocol)));
          } finally {
            $c$.$destroy();
          }
        } else {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            $c$.clean($c$.track($this().Diag($this().Tok, diag.err_objc_postfix_attribute)));
          } finally {
            $c$.$destroy();
          }
        }
        $this().ParseGNUAttributes(attrs);
      }
    } finally {
      if (attrs != null) { attrs.$destroy(); }
    }
  }


/// ParseObjCAtDirectives - Handle parts of the external-declaration production:
///       external-declaration: [C99 6.9]
/// [OBJC]  objc-class-definition
/// [OBJC]  objc-class-declaration
/// [OBJC]  objc-alias-declaration
/// [OBJC]  objc-protocol-definition
/// [OBJC]  objc-method-definition
/// [OBJC]  '@' 'end'
//<editor-fold defaultstate="collapsed" desc="clang::Parser::ParseObjCAtDirectives">
@Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseObjc.cpp", line = 48,
   FQN="clang::Parser::ParseObjCAtDirectives", NM="_ZN5clang6Parser21ParseObjCAtDirectivesEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseObjc.cpp -nm=_ZN5clang6Parser21ParseObjCAtDirectivesEv")
  //</editor-fold>
  protected /*private*/ OpaquePtr<DeclGroupRef> ParseObjCAtDirectives() {
    SourceLocation AtLoc = $this().ConsumeToken(); // the "@"
    if ($this().Tok.is(tok.TokenKind.code_completion)) {
      $this().Actions.CodeCompleteObjCAtDirective($this().getCurScope());
      $this().cutOffParsing();
      return new OpaquePtr<DeclGroupRef>(null);
    }
    
    Decl /*P*/ SingleDecl = null;
    switch ($this().Tok.getObjCKeywordID()) {
     case tok.ObjCKeywordKind.objc_class:
      return $this().ParseObjCAtClassDeclaration(new SourceLocation(AtLoc));
     case tok.ObjCKeywordKind.objc_interface:
      {
        ParsedAttributes attrs = null;
        try {
          attrs/*J*/= new ParsedAttributes($this().AttrFactory);
          SingleDecl = $this().ParseObjCAtInterfaceDeclaration(new SourceLocation(AtLoc), attrs);
          break;
        } finally {
          if (attrs != null) { attrs.$destroy(); }
        }
      }
     case tok.ObjCKeywordKind.objc_protocol:
      {
        ParsedAttributes attrs = null;
        try {
          attrs/*J*/= new ParsedAttributes($this().AttrFactory);
          return $this().ParseObjCAtProtocolDeclaration(new SourceLocation(AtLoc), attrs);
        } finally {
          if (attrs != null) { attrs.$destroy(); }
        }
      }
     case tok.ObjCKeywordKind.objc_implementation:
      return $this().ParseObjCAtImplementationDeclaration(new SourceLocation(AtLoc));
     case tok.ObjCKeywordKind.objc_end:
      return $this().ParseObjCAtEndDeclaration(new SourceRange(/*NO_COPY*/AtLoc));
     case tok.ObjCKeywordKind.objc_compatibility_alias:
      SingleDecl = $this().ParseObjCAtAliasDeclaration(new SourceLocation(AtLoc));
      break;
     case tok.ObjCKeywordKind.objc_synthesize:
      SingleDecl = $this().ParseObjCPropertySynthesize(new SourceLocation(AtLoc));
      break;
     case tok.ObjCKeywordKind.objc_dynamic:
      SingleDecl = $this().ParseObjCPropertyDynamic(new SourceLocation(AtLoc));
      break;
     case tok.ObjCKeywordKind.objc_import:
      {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          if ($this().getLangOpts().Modules || $this().getLangOpts().DebuggerSupport) {
            return $this().ParseModuleImport(new SourceLocation(AtLoc));
          }
          $c$.clean($c$.track($this().Diag(new SourceLocation(AtLoc), diag.err_atimport)));
          $this().SkipUntil(tok.TokenKind.semi);
          return $this().Actions.ConvertDeclToDeclGroup((Decl /*P*/ )null);
        } finally {
          $c$.$destroy();
        }
      }
     default:
      {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($c$.track($this().Diag(new SourceLocation(AtLoc), diag.err_unexpected_at)));
          $this().SkipUntil(tok.TokenKind.semi);
          SingleDecl = null;
          break;
        } finally {
          $c$.$destroy();
        }
      }
    }
    return $this().Actions.ConvertDeclToDeclGroup(SingleDecl);
  }


///
/// objc-class-declaration:
///    '@' 'class' objc-class-forward-decl (',' objc-class-forward-decl)* ';'
///
/// objc-class-forward-decl:
///   identifier objc-type-parameter-list[opt]
///
//<editor-fold defaultstate="collapsed" desc="clang::Parser::ParseObjCAtClassDeclaration">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseObjc.cpp", line = 131,
   FQN="clang::Parser::ParseObjCAtClassDeclaration", NM="_ZN5clang6Parser27ParseObjCAtClassDeclarationENS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseObjc.cpp -nm=_ZN5clang6Parser27ParseObjCAtClassDeclarationENS_14SourceLocationE")
  //</editor-fold>
  protected /*private*/ OpaquePtr<DeclGroupRef> ParseObjCAtClassDeclaration(SourceLocation atLoc) {
    $this().ConsumeToken(); // the identifier "class"
    SmallVector<IdentifierInfo /*P*/> ClassNames/*J*/= new SmallVector<IdentifierInfo /*P*/>(8, (IdentifierInfo /*P*/)null);
    SmallVector<SourceLocation> ClassLocs/*J*/= new SmallVector<SourceLocation>(8, new SourceLocation());
    SmallVector<ObjCTypeParamList /*P*/ > ClassTypeParams/*J*/= new SmallVector<ObjCTypeParamList /*P*/ >(8, (ObjCTypeParamList /*P*/ )null);
    while (true) {
      $this().MaybeSkipAttributes(tok.ObjCKeywordKind.objc_class);
      if ($this().Tok.isNot(tok.TokenKind.identifier)) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_DiagnosticBuilder$C_TokenKind($c$.track($this().Diag($this().Tok, diag.err_expected)), tok.TokenKind.identifier));
          $this().SkipUntil(tok.TokenKind.semi);
          return $this().Actions.ConvertDeclToDeclGroup((Decl /*P*/ )null);
        } finally {
          $c$.$destroy();
        }
      }
      ClassNames.push_back($this().Tok.getIdentifierInfo());
      ClassLocs.push_back($this().Tok.getLocation());
      $this().ConsumeToken();
      
      // Parse the optional objc-type-parameter-list.
      ObjCTypeParamList /*P*/ TypeParams = null;
      if ($this().Tok.is(tok.TokenKind.less)) {
        TypeParams = $this().parseObjCTypeParamList();
      }
      ClassTypeParams.push_back(TypeParams);
      if (!$this().TryConsumeToken(tok.TokenKind.comma)) {
        break;
      }
    }
    
    // Consume the ';'.
    if ($this().ExpectAndConsume(tok.TokenKind.semi, diag.err_expected_after, new StringRef(/*KEEP_STR*/"@class"))) {
      return $this().Actions.ConvertDeclToDeclGroup((Decl /*P*/ )null);
    }
    
    return $this().Actions.ActOnForwardClassDeclaration(new SourceLocation(atLoc), ClassNames.data(), 
        ClassLocs.data(), 
        new ArrayRef<ObjCTypeParamList /*P*/ >(ClassTypeParams), 
        ClassNames.size());
  }


///
///   objc-interface:
///     objc-class-interface-attributes[opt] objc-class-interface
///     objc-category-interface
///
///   objc-class-interface:
///     '@' 'interface' identifier objc-type-parameter-list[opt]
///       objc-superclass[opt] objc-protocol-refs[opt]
///       objc-class-instance-variables[opt]
///       objc-interface-decl-list
///     @end
///
///   objc-category-interface:
///     '@' 'interface' identifier objc-type-parameter-list[opt]
///       '(' identifier[opt] ')' objc-protocol-refs[opt]
///       objc-interface-decl-list
///     @end
///
///   objc-superclass:
///     ':' identifier objc-type-arguments[opt]
///
///   objc-class-interface-attributes:
///     __attribute__((visibility("default")))
///     __attribute__((visibility("hidden")))
///     __attribute__((deprecated))
///     __attribute__((unavailable))
///     __attribute__((objc_exception)) - used by NSException on 64-bit
///     __attribute__((objc_root_class))
///
//<editor-fold defaultstate="collapsed" desc="clang::Parser::ParseObjCAtInterfaceDeclaration">
@Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseObjc.cpp", line = 216,
   FQN="clang::Parser::ParseObjCAtInterfaceDeclaration", NM="_ZN5clang6Parser31ParseObjCAtInterfaceDeclarationENS_14SourceLocationERNS_16ParsedAttributesE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseObjc.cpp -nm=_ZN5clang6Parser31ParseObjCAtInterfaceDeclarationENS_14SourceLocationERNS_16ParsedAttributesE")
  //</editor-fold>
  protected /*private*/ Decl /*P*/ ParseObjCAtInterfaceDeclaration(SourceLocation AtLoc, 
                                 final ParsedAttributes /*&*/ attrs) {
    ObjCTypeParamListScope typeParamScope = null;
    try {
      assert ($this().Tok.isObjCAtKeyword(tok.ObjCKeywordKind.objc_interface)) : "ParseObjCAtInterfaceDeclaration(): Expected @interface";
      $this().CheckNestedObjCContexts(new SourceLocation(AtLoc));
      $this().ConsumeToken(); // the "interface" identifier
      
      // Code completion after '@interface'.
      if ($this().Tok.is(tok.TokenKind.code_completion)) {
        $this().Actions.CodeCompleteObjCInterfaceDecl($this().getCurScope());
        $this().cutOffParsing();
        return null;
      }
      
      $this().MaybeSkipAttributes(tok.ObjCKeywordKind.objc_interface);
      if ($this().Tok.isNot(tok.TokenKind.identifier)) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_DiagnosticBuilder$C_TokenKind($c$.track($this().Diag($this().Tok, diag.err_expected)), 
              tok.TokenKind.identifier)); // missing class or category name.
          return null;
        } finally {
          $c$.$destroy();
        }
      }
      
      // We have a class or category name - consume it.
      IdentifierInfo /*P*/ nameId = $this().Tok.getIdentifierInfo();
      SourceLocation nameLoc = $this().ConsumeToken();
      
      // Parse the objc-type-parameter-list or objc-protocol-refs. For the latter
      // case, LAngleLoc will be valid and ProtocolIdents will capture the
      // protocol references (that have not yet been resolved).
      SourceLocation LAngleLoc/*J*/= new SourceLocation(), EndProtoLoc/*J*/= new SourceLocation();
      SmallVector<std.pair<IdentifierInfo /*P*/ , SourceLocation>> ProtocolIdents/*J*/= new SmallVector<std.pair<IdentifierInfo /*P*/ , SourceLocation>>(8, new std.pairPtrType<IdentifierInfo /*P*/ , SourceLocation>(null, new SourceLocation()));
      ObjCTypeParamList /*P*/ typeParameterList = null;
      typeParamScope/*J*/= new ObjCTypeParamListScope($this().Actions, $this().getCurScope());
      if ($this().Tok.is(tok.TokenKind.less)) {
        typeParameterList = $this().parseObjCTypeParamListOrProtocolRefs(typeParamScope, LAngleLoc, ProtocolIdents, EndProtoLoc);
      }
      if ($this().Tok.is(tok.TokenKind.l_paren)
         && !$this().isKnownToBeTypeSpecifier($this().GetLookAheadToken(1))) { // we have a category.
        BalancedDelimiterTracker T = null;
        try {
          
          T/*J*/= new BalancedDelimiterTracker(/*Deref*/$this(), tok.TokenKind.l_paren);
          T.consumeOpen();
          
          SourceLocation categoryLoc/*J*/= new SourceLocation();
          IdentifierInfo /*P*/ categoryId = null;
          if ($this().Tok.is(tok.TokenKind.code_completion)) {
            $this().Actions.CodeCompleteObjCInterfaceCategory($this().getCurScope(), nameId, new SourceLocation(nameLoc));
            $this().cutOffParsing();
            return null;
          }
          
          // For ObjC2, the category name is optional (not an error).
          if ($this().Tok.is(tok.TokenKind.identifier)) {
            categoryId = $this().Tok.getIdentifierInfo();
            categoryLoc.$assignMove($this().ConsumeToken());
          } else if (!$this().getLangOpts().ObjC2) {
            JavaCleaner $c$ = $createJavaCleaner();
            try {
              $c$.clean($out_DiagnosticBuilder$C_TokenKind($c$.track($this().Diag($this().Tok, diag.err_expected)), 
                  tok.TokenKind.identifier)); // missing category name.
              return null;
            } finally {
              $c$.$destroy();
            }
          }
          
          T.consumeClose();
          if (T.getCloseLocation().isInvalid()) {
            return null;
          }
          if (!attrs.empty()) { // categories don't support attributes.
            JavaCleaner $c$ = $createJavaCleaner();
            try {
              $c$.clean($c$.track($this().Diag(new SourceLocation(nameLoc), diag.err_objc_no_attributes_on_category)));
              attrs.clear();
            } finally {
              $c$.$destroy();
            }
          }
          
          // Next, we need to check for any protocol references.
          assert (LAngleLoc.isInvalid()) : "Cannot have already parsed protocols";
          SmallVector<Decl /*P*/> ProtocolRefs/*J*/= new SmallVector<Decl /*P*/>(8, null);
          SmallVector<SourceLocation> ProtocolLocs/*J*/= new SmallVector<SourceLocation>(8, new SourceLocation());
          if ($this().Tok.is(tok.TokenKind.less)
             && $this().ParseObjCProtocolReferences(ProtocolRefs, ProtocolLocs, true, true, 
              LAngleLoc, EndProtoLoc, 
              /*consumeLastToken=*/ true)) {
            return null;
          }
          
          Decl /*P*/ CategoryType = $this().Actions.ActOnStartCategoryInterface(new SourceLocation(AtLoc), 
              nameId, new SourceLocation(nameLoc), 
              typeParameterList, 
              categoryId, new SourceLocation(categoryLoc), 
              ProtocolRefs.data(), 
              ProtocolRefs.size(), 
              ProtocolLocs.data(), 
              new SourceLocation(EndProtoLoc));
          if ($this().Tok.is(tok.TokenKind.l_brace)) {
            $this().ParseObjCClassInstanceVariables(CategoryType, tok.ObjCKeywordKind.objc_private, new SourceLocation(AtLoc));
          }
          
          $this().ParseObjCInterfaceDeclList(tok.ObjCKeywordKind.objc_not_keyword, CategoryType);
          
          return CategoryType;
        } finally {
          if (T != null) { T.$destroy(); }
        }
      }
      // Parse a class interface.
      IdentifierInfo /*P*/ superClassId = null;
      SourceLocation superClassLoc/*J*/= new SourceLocation();
      SourceLocation typeArgsLAngleLoc/*J*/= new SourceLocation();
      SmallVector<OpaquePtr<QualType>> typeArgs/*J*/= new SmallVector<OpaquePtr<QualType>>(4, new OpaquePtr<QualType>());
      SourceLocation typeArgsRAngleLoc/*J*/= new SourceLocation();
      SmallVector<Decl /*P*/> protocols/*J*/= new SmallVector<Decl /*P*/>(4, null);
      SmallVector<SourceLocation> protocolLocs/*J*/= new SmallVector<SourceLocation>(4, new SourceLocation());
      if ($this().Tok.is(tok.TokenKind.colon)) { // a super class is specified.
        $this().ConsumeToken();
        
        // Code completion of superclass names.
        if ($this().Tok.is(tok.TokenKind.code_completion)) {
          $this().Actions.CodeCompleteObjCSuperclass($this().getCurScope(), nameId, new SourceLocation(nameLoc));
          $this().cutOffParsing();
          return null;
        }
        if ($this().Tok.isNot(tok.TokenKind.identifier)) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            $c$.clean($out_DiagnosticBuilder$C_TokenKind($c$.track($this().Diag($this().Tok, diag.err_expected)), 
                tok.TokenKind.identifier)); // missing super class name.
            return null;
          } finally {
            $c$.$destroy();
          }
        }
        superClassId = $this().Tok.getIdentifierInfo();
        superClassLoc.$assignMove($this().ConsumeToken());
        
        // Type arguments for the superclass or protocol conformances.
        if ($this().Tok.is(tok.TokenKind.less)) {
          $this().parseObjCTypeArgsOrProtocolQualifiers(new OpaquePtr<QualType>(null), typeArgsLAngleLoc, typeArgs, typeArgsRAngleLoc, LAngleLoc, 
              protocols, protocolLocs, EndProtoLoc, 
              /*consumeLastToken=*/ true, 
              /*warnOnIncompleteProtocols=*/ true);
        }
      }
      
      // Next, we need to check for any protocol references.
      if (LAngleLoc.isValid()) {
        if (!ProtocolIdents.empty()) {
          // We already parsed the protocols named when we thought we had a
          // type parameter list. Translate them into actual protocol references.
          for (final /*const*/ pair<IdentifierInfo /*P*/ , SourceLocation> /*&*/ pair : ProtocolIdents) {
            protocolLocs.push_back(pair.second);
          }
          $this().Actions.FindProtocolDeclaration(/*WarnOnDeclarations=*/ true, 
              /*ForObjCContainer=*/ true, 
              new ArrayRef<std.pair<IdentifierInfo /*P*/ , SourceLocation> >(ProtocolIdents), protocols);
        }
      } else if (protocols.empty() && $this().Tok.is(tok.TokenKind.less)
         && $this().ParseObjCProtocolReferences(protocols, protocolLocs, true, true, 
          LAngleLoc, EndProtoLoc, 
          /*consumeLastToken=*/ true)) {
        return null;
      }
      if ($this().Tok.isNot(tok.TokenKind.less)) {
        $this().Actions.ActOnTypedefedProtocols(protocols, superClassId, new SourceLocation(superClassLoc));
      }
      
      Decl /*P*/ ClsType = $this().Actions.ActOnStartClassInterface($this().getCurScope(), new SourceLocation(AtLoc), nameId, new SourceLocation(nameLoc), 
          typeParameterList, superClassId, 
          new SourceLocation(superClassLoc), 
          new ArrayRef<OpaquePtr<QualType> >(typeArgs), 
          new SourceRange(/*NO_COPY*/typeArgsLAngleLoc, 
              /*NO_COPY*/typeArgsRAngleLoc), 
          protocols.data(), protocols.size(), 
          protocolLocs.data(), 
          new SourceLocation(EndProtoLoc), attrs.getList());
      if ($this().Tok.is(tok.TokenKind.l_brace)) {
        $this().ParseObjCClassInstanceVariables(ClsType, tok.ObjCKeywordKind.objc_protected, new SourceLocation(AtLoc));
      }
      
      $this().ParseObjCInterfaceDeclList(tok.ObjCKeywordKind.objc_interface, ClsType);
      
      return ClsType;
    } finally {
      if (typeParamScope != null) { typeParamScope.$destroy(); }
    }
  }


/// Parse an objc-type-parameter-list.
//<editor-fold defaultstate="collapsed" desc="clang::Parser::parseObjCTypeParamList">
@Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseObjc.cpp", line = 596,
   FQN="clang::Parser::parseObjCTypeParamList", NM="_ZN5clang6Parser22parseObjCTypeParamListEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseObjc.cpp -nm=_ZN5clang6Parser22parseObjCTypeParamListEv")
  //</editor-fold>
  protected /*private*/ ObjCTypeParamList /*P*/ parseObjCTypeParamList() {
    ObjCTypeParamListScope Scope = null;
    try {
      SourceLocation lAngleLoc/*J*/= new SourceLocation();
      SmallVector<std.pair<IdentifierInfo /*P*/ , SourceLocation>> protocolIdents/*J*/= new SmallVector<std.pair<IdentifierInfo /*P*/ , SourceLocation>>(1, new std.pairPtrType<IdentifierInfo /*P*/ , SourceLocation>(null, new SourceLocation()));
      SourceLocation rAngleLoc/*J*/= new SourceLocation();
      
      Scope/*J*/= new ObjCTypeParamListScope($this().Actions, $this().getCurScope());
      return $this().parseObjCTypeParamListOrProtocolRefs(Scope, lAngleLoc, protocolIdents, 
          rAngleLoc, 
          /*mayBeProtocolList=*/ false);
    } finally {
      if (Scope != null) { Scope.$destroy(); }
    }
  }


/// Parse an Objective-C type parameter list, if present, or capture
/// the locations of the protocol identifiers for a list of protocol
/// references.
///
///   objc-type-parameter-list:
///     '<' objc-type-parameter (',' objc-type-parameter)* '>'
///
///   objc-type-parameter:
///     objc-type-parameter-variance? identifier objc-type-parameter-bound[opt]
///
///   objc-type-parameter-bound:
///     ':' type-name
///
///   objc-type-parameter-variance:
///     '__covariant'
///     '__contravariant'
///
/// \param lAngleLoc The location of the starting '<'.
///
/// \param protocolIdents Will capture the list of identifiers, if the
/// angle brackets contain a list of protocol references rather than a
/// type parameter list.
///
/// \param rAngleLoc The location of the ending '>'.
//<editor-fold defaultstate="collapsed" desc="clang::Parser::parseObjCTypeParamListOrProtocolRefs">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*mayBeProtocolList*/,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseObjc.cpp", line = 446,
   FQN="clang::Parser::parseObjCTypeParamListOrProtocolRefs", NM="_ZN5clang6Parser36parseObjCTypeParamListOrProtocolRefsERNS0_22ObjCTypeParamListScopeERNS_14SourceLocationERN4llvm15SmallVectorImplISt4pairIPNS_14IdentifierInfoES3_EEES4_b",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseObjc.cpp -nm=_ZN5clang6Parser36parseObjCTypeParamListOrProtocolRefsERNS0_22ObjCTypeParamListScopeERNS_14SourceLocationERN4llvm15SmallVectorImplISt4pairIPNS_14IdentifierInfoES3_EEES4_b")
  //</editor-fold>
  protected /*private*/ ObjCTypeParamList /*P*/ parseObjCTypeParamListOrProtocolRefs(final ObjCTypeParamListScope /*&*/ Scope, final SourceLocation /*&*/ lAngleLoc, 
                                      final SmallVectorImpl<std.pair<IdentifierInfo /*P*/ , SourceLocation> > /*&*/ protocolIdents, 
                                      final SourceLocation /*&*/ rAngleLoc) {
    return $this().parseObjCTypeParamListOrProtocolRefs(Scope, lAngleLoc, 
                                      protocolIdents, 
                                      rAngleLoc, true);
  }
  protected /*private*/ ObjCTypeParamList /*P*/ parseObjCTypeParamListOrProtocolRefs(final ObjCTypeParamListScope /*&*/ Scope, final SourceLocation /*&*/ lAngleLoc, 
                                      final SmallVectorImpl<std.pair<IdentifierInfo /*P*/ , SourceLocation> > /*&*/ protocolIdents, 
                                      final SourceLocation /*&*/ rAngleLoc, boolean mayBeProtocolList/*= true*/) {
    GreaterThanIsOperatorScope G = null;
    final bool$ref $mayBeProtocolList = create_bool$ref(mayBeProtocolList);
    try {
      assert ($this().Tok.is(tok.TokenKind.less)) : "Not at the beginning of a type parameter list";
      
      // Within the type parameter list, don't treat '>' as an operator.
      G/*J*/= new GreaterThanIsOperatorScope($this().GreaterThanIsOperator$Ref, false);
      
      // Local function to "flush" the protocol identifiers, turning them into
      // type parameters.
      SmallVector<Decl /*P*/> typeParams/*J*/= new SmallVector<Decl /*P*/>(4, null);
      Void2Void makeProtocolIdentsIntoTypeParameters =  () -> 
        {
          /*uint*/int index = 0;
          for (final /*const*/ pair<IdentifierInfo /*P*/ , SourceLocation> /*&*/ pair : protocolIdents) {
            ActionResult<Decl /*P*/ > typeParam = $this().Actions.actOnObjCTypeParam($this().getCurScope(), ObjCTypeParamVariance.Invariant, new SourceLocation(), 
                index++, pair.first, new SourceLocation(pair.second), new SourceLocation(), new OpaquePtr<QualType>(null));
            if (typeParam.isUsable()) {
              typeParams.push_back(typeParam.get());
            }
          }
          
          protocolIdents.clear();
          $mayBeProtocolList.$set(false);
        }
      ;
      
      boolean invalid = false;
      lAngleLoc.$assignMove($this().ConsumeToken());
      
      do {
        // Parse the variance, if any.
        SourceLocation varianceLoc/*J*/= new SourceLocation();
        ObjCTypeParamVariance variance = ObjCTypeParamVariance.Invariant;
        if ($this().Tok.is(tok.TokenKind.kw___covariant) || $this().Tok.is(tok.TokenKind.kw___contravariant)) {
          variance = $this().Tok.is(tok.TokenKind.kw___covariant) ? ObjCTypeParamVariance.Covariant : ObjCTypeParamVariance.Contravariant;
          varianceLoc.$assignMove($this().ConsumeToken());
          
          // Once we've seen a variance specific , we know this is not a
          // list of protocol references.
          if ($mayBeProtocolList.$deref()) {
            // Up until now, we have been queuing up parameters because they
            // might be protocol references. Turn them into parameters now.
            makeProtocolIdentsIntoTypeParameters.$call();
          }
        }
        
        // Parse the identifier.
        if (!$this().Tok.is(tok.TokenKind.identifier)) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            // Code completion.
            if ($this().Tok.is(tok.TokenKind.code_completion)) {
              // FIXME: If these aren't protocol references, we'll need different
              // completions.
              $this().Actions.CodeCompleteObjCProtocolReferences(new ArrayRef<std.pair<IdentifierInfo /*P*/ , SourceLocation> >(protocolIdents));
              $this().cutOffParsing();
              
              // FIXME: Better recovery here?.
              return null;
            }
            
            $c$.clean($c$.track($this().Diag($this().Tok, diag.err_objc_expected_type_parameter)));
            invalid = true;
            break;
          } finally {
            $c$.$destroy();
          }
        }
        
        IdentifierInfo /*P*/ paramName = $this().Tok.getIdentifierInfo();
        SourceLocation paramLoc = $this().ConsumeToken();
        
        // If there is a bound, parse it.
        SourceLocation colonLoc/*J*/= new SourceLocation();
        ActionResult<OpaquePtr<QualType> > boundType/*J*/= new ActionResult<OpaquePtr<QualType> >(JD$T.INSTANCE, new OpaquePtr<>());
        if ($this().TryConsumeToken(tok.TokenKind.colon, colonLoc)) {
          // Once we've seen a bound, we know this is not a list of protocol
          // references.
          if ($mayBeProtocolList.$deref()) {
            // Up until now, we have been queuing up parameters because they
            // might be protocol references. Turn them into parameters now.
            makeProtocolIdentsIntoTypeParameters.$call();
          }
          
          // type-name
          boundType.$assignMove($this().ParseTypeName());
          if (boundType.isInvalid()) {
            invalid = true;
          }
        } else if ($mayBeProtocolList.$deref()) {
          // If this could still be a protocol list, just capture the identifier.
          // We don't want to turn it into a parameter.
          protocolIdents.push_back(std.make_pair_Ptr_T(paramName, paramLoc));
          continue;
        }
        
        // Create the type parameter.
        ActionResult<Decl /*P*/ > typeParam = $this().Actions.actOnObjCTypeParam($this().getCurScope(), variance, new SourceLocation(varianceLoc), typeParams.size(), paramName, 
            new SourceLocation(paramLoc), new SourceLocation(colonLoc), boundType.isUsable() ? boundType.get() : new OpaquePtr<QualType>(null));
        if (typeParam.isUsable()) {
          typeParams.push_back(typeParam.get());
        }
      } while ($this().TryConsumeToken(tok.TokenKind.comma));
      
      // Parse the '>'.
      if (invalid) {
        $this().SkipUntil(tok.TokenKind.greater, tok.TokenKind.at, SkipUntilFlags.StopBeforeMatch);
        if ($this().Tok.is(tok.TokenKind.greater)) {
          $this().ConsumeToken();
        }
      } else if ($this().ParseGreaterThanInTemplateList(rAngleLoc, 
          /*ConsumeLastToken=*/ true, 
          /*ObjCGenericList=*/ true)) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_DiagnosticBuilder$C_char$ptr$C($c$.track($this().Diag(new SourceLocation(lAngleLoc), diag.note_matching)), /*KEEP_STR*/"'<'"));
          $this().SkipUntil(/*{ */new ArrayRefUShort/*<tok.TokenKind>*/(new /*const*//*TokenKind*/char [/*11*/] {
                    tok.TokenKind.greater, tok.TokenKind.greaterequal, tok.TokenKind.at, tok.TokenKind.minus, 
                    tok.TokenKind.minus, tok.TokenKind.plus, tok.TokenKind.colon, tok.TokenKind.l_paren, tok.TokenKind.l_brace, 
                    tok.TokenKind.comma, tok.TokenKind.semi})/* }*/, 
              SkipUntilFlags.StopBeforeMatch);
          if ($this().Tok.is(tok.TokenKind.greater)) {
            $this().ConsumeToken();
          }
        } finally {
          $c$.$destroy();
        }
      }
      if ($mayBeProtocolList.$deref()) {
        // A type parameter list must be followed by either a ':' (indicating the
        // presence of a superclass) or a '(' (indicating that this is a category
        // or extension). This disambiguates between an objc-type-parameter-list
        // and a objc-protocol-refs.
        if ($this().Tok.isNot(tok.TokenKind.colon) && $this().Tok.isNot(tok.TokenKind.l_paren)) {
          // Returning null indicates that we don't have a type parameter list.
          // The results the caller needs to handle the protocol references are
          // captured in the reference parameters already.
          return null;
        }
        
        // We have a type parameter list that looks like a list of protocol
        // references. Turn that parameter list into type parameters.
        makeProtocolIdentsIntoTypeParameters.$call();
      }
      
      // Form the type parameter list and enter its scope.
      ObjCTypeParamList /*P*/ list = $this().Actions.actOnObjCTypeParamList($this().getCurScope(), 
          new SourceLocation(lAngleLoc), 
          new ArrayRef<Decl /*P*/ >(typeParams), 
          new SourceLocation(rAngleLoc));
      Scope.enter(list);
      
      // Clear out the angle locations; they're used by the caller to indicate
      // whether there are any protocol references.
      lAngleLoc.$assignMove(new SourceLocation());
      rAngleLoc.$assignMove(new SourceLocation());
      return invalid ? null : list;
    } finally {
      if (G != null) { G.$destroy(); }
    }
  }

//<editor-fold defaultstate="collapsed" desc="clang::Parser::HelperActionsForIvarDeclarations">
@Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseObjc.cpp", line = 1884,
   FQN="clang::Parser::HelperActionsForIvarDeclarations", NM="_ZN5clang6Parser32HelperActionsForIvarDeclarationsEPNS_4DeclENS_14SourceLocationERNS_24BalancedDelimiterTrackerERN4llvm15SmallVectorImplIS2_EEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseObjc.cpp -nm=_ZN5clang6Parser32HelperActionsForIvarDeclarationsEPNS_4DeclENS_14SourceLocationERNS_24BalancedDelimiterTrackerERN4llvm15SmallVectorImplIS2_EEb")
  //</editor-fold>
  protected /*private*/ void HelperActionsForIvarDeclarations(Decl /*P*/ interfaceDecl, SourceLocation atLoc, 
                                  final BalancedDelimiterTracker /*&*/ T, 
                                  final SmallVectorImpl<Decl /*P*/ > /*&*/ AllIvarDecls, 
                                  boolean RBraceMissing) {
    if (!RBraceMissing) {
      T.consumeClose();
    }
    
    $this().Actions.ActOnObjCContainerStartDefinition(interfaceDecl);
    $this().Actions.ActOnLastBitfield(T.getCloseLocation(), AllIvarDecls);
    $this().Actions.ActOnObjCContainerFinishDefinition();
    // Call ActOnFields() even if we don't have any decls. This is useful
    // for code rewriting tools that need to be aware of the empty list.
    $this().Actions.ActOnFields($this().getCurScope(), new SourceLocation(atLoc), interfaceDecl, 
        new ArrayRef<Decl /*P*/ >(AllIvarDecls), 
        T.getOpenLocation(), T.getCloseLocation(), (AttributeList /*P*/ )null);
  }


///   objc-class-instance-variables:
///     '{' objc-instance-variable-decl-list[opt] '}'
///
///   objc-instance-variable-decl-list:
///     objc-visibility-spec
///     objc-instance-variable-decl ';'
///     ';'
///     objc-instance-variable-decl-list objc-visibility-spec
///     objc-instance-variable-decl-list objc-instance-variable-decl ';'
///     objc-instance-variable-decl-list ';'
///
///   objc-visibility-spec:
///     @private
///     @protected
///     @public
///     @package [OBJC2]
///
///   objc-instance-variable-decl:
///     struct-declaration
///
//<editor-fold defaultstate="collapsed" desc="clang::Parser::ParseObjCClassInstanceVariables">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*visibility ref for lambda*/,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseObjc.cpp", line = 1921,
   FQN="clang::Parser::ParseObjCClassInstanceVariables", NM="_ZN5clang6Parser31ParseObjCClassInstanceVariablesEPNS_4DeclENS_3tok15ObjCKeywordKindENS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseObjc.cpp -nm=_ZN5clang6Parser31ParseObjCClassInstanceVariablesEPNS_4DeclENS_3tok15ObjCKeywordKindENS_14SourceLocationE")
  //</editor-fold>
  protected /*private*/ void ParseObjCClassInstanceVariables(Decl /*P*/ interfaceDecl, 
                                 /*tok.ObjCKeywordKind*/char visibility, 
                                 SourceLocation atLoc) {
    /*tok.ObjCKeywordKind*/ushort$ref $visibility = create_ushort$ref(visibility);
    ParseScope ClassScope = null;
    ObjCDeclContextSwitch ObjCDC = null;
    BalancedDelimiterTracker T = null;
    try {
      assert ($this().Tok.is(tok.TokenKind.l_brace)) : "expected {";
      SmallVector<Decl /*P*/> AllIvarDecls/*J*/= new SmallVector<Decl /*P*/>(32, null);
      
      ClassScope/*J*/= new ParseScope($this(), Scope.ScopeFlags.DeclScope | Scope.ScopeFlags.ClassScope);
      ObjCDC/*J*/= new ObjCDeclContextSwitch(/*Deref*/$this());
      
      T/*J*/= new BalancedDelimiterTracker(/*Deref*/$this(), tok.TokenKind.l_brace);
      T.consumeOpen();
      // While we still have something to read, read the instance variables.
      while ($this().Tok.isNot(tok.TokenKind.r_brace) && !$this().isEofOrEom()) {
        ParsingDeclSpec DS = null;
        try {
          // Each iteration of this loop reads one objc-instance-variable-decl.
          
          // Check for extraneous top-level semicolon.
          if ($this().Tok.is(tok.TokenKind.semi)) {
            $this().ConsumeExtraSemi(ExtraSemiKind.InstanceVariableList);
            continue;
          }
          
          // Set the default visibility to private.
          if ($this().TryConsumeToken(tok.TokenKind.at)) { // parse objc-visibility-spec
            if ($this().Tok.is(tok.TokenKind.code_completion)) {
              $this().Actions.CodeCompleteObjCAtVisibility($this().getCurScope());
              $this().cutOffParsing();
              return;
            }
            switch ($this().Tok.getObjCKeywordID()) {
             case tok.ObjCKeywordKind.objc_private:
             case tok.ObjCKeywordKind.objc_public:
             case tok.ObjCKeywordKind.objc_protected:
             case tok.ObjCKeywordKind.objc_package:
              $visibility.$set($this().Tok.getObjCKeywordID());
              $this().ConsumeToken();
              continue;
             case tok.ObjCKeywordKind.objc_end:
              {
                JavaCleaner $c$ = $createJavaCleaner();
                try {
                  $c$.clean($c$.track($this().Diag($this().Tok, diag.err_objc_unexpected_atend)));
                  $this().Tok.setLocation($this().Tok.getLocation().getLocWithOffset(-1));
                  $this().Tok.setKind(tok.TokenKind.at);
                  $this().Tok.setLength(1);
                  $this().PP.EnterToken($this().Tok);
                  $this().HelperActionsForIvarDeclarations(interfaceDecl, new SourceLocation(atLoc), 
                      T, AllIvarDecls, true);
                  return;
                } finally {
                  $c$.$destroy();
                }
              }
             default:
              {
                JavaCleaner $c$ = $createJavaCleaner();
                try {
                  $c$.clean($c$.track($this().Diag($this().Tok, diag.err_objc_illegal_visibility_spec)));
                  continue;
                } finally {
                  $c$.$destroy();
                }
              }
            }
          }
          if ($this().Tok.is(tok.TokenKind.code_completion)) {
            $this().Actions.CodeCompleteOrdinaryName($this().getCurScope(), 
                Sema.ParserCompletionContext.PCC_ObjCInstanceVariableList);
            $this().cutOffParsing();
            return;
          }
          
          ParsingFieldDeclarator$Ref2Void ObjCIvarCallback = /*[&]*/ (ParsingFieldDeclarator/*&*/ FD) -> 
            {
              $this().Actions.ActOnObjCContainerStartDefinition(interfaceDecl);
              // Install the declarator into the interface decl.
              FD.D.setObjCIvar(true);
              Decl /*P*/ Field = $this().Actions.ActOnIvar($this().getCurScope(), FD.D.getDeclSpec().getSourceRange().getBegin(), FD.D, 
                  FD.BitfieldSize, $visibility.$deref());
              $this().Actions.ActOnObjCContainerFinishDefinition();
              if ((Field != null)) {
                AllIvarDecls.push_back(Field);
              }
              FD.complete(Field);
            }
          ;
          
          // Parse all the comma separated declarators.
          DS/*J*/= new ParsingDeclSpec(/*Deref*/$this());
          $this().ParseStructDeclaration(DS, ObjCIvarCallback);
          if ($this().Tok.is(tok.TokenKind.semi)) {
            $this().ConsumeToken();
          } else {
            JavaCleaner $c$ = $createJavaCleaner();
            try {
              $c$.clean($c$.track($this().Diag($this().Tok, diag.err_expected_semi_decl_list)));
              // Skip to end of block or statement
              $this().SkipUntil(tok.TokenKind.r_brace, $bitor_SkipUntilFlags(/*KEEP_ENUM*/SkipUntilFlags.StopAtSemi, /*KEEP_ENUM*/SkipUntilFlags.StopBeforeMatch));
            } finally {
              $c$.$destroy();
            }
          }
        } finally {
          if (DS != null) { DS.$destroy(); }
        }
      }
      $this().HelperActionsForIvarDeclarations(interfaceDecl, new SourceLocation(atLoc), 
          T, AllIvarDecls, false);
    } finally {
      if (T != null) { T.$destroy(); }
      if (ObjCDC != null) { ObjCDC.$destroy(); }
      if (ClassScope != null) { ClassScope.$destroy(); }
    }
  }


///   objc-protocol-refs:
///     '<' identifier-list '>'
///
//<editor-fold defaultstate="collapsed" desc="clang::Parser::ParseObjCProtocolReferences">
@Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseObjc.cpp", line = 1543,
   FQN="clang::Parser::ParseObjCProtocolReferences", NM="_ZN5clang6Parser27ParseObjCProtocolReferencesERN4llvm15SmallVectorImplIPNS_4DeclEEERNS2_INS_14SourceLocationEEEbbRS7_SA_b",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseObjc.cpp -nm=_ZN5clang6Parser27ParseObjCProtocolReferencesERN4llvm15SmallVectorImplIPNS_4DeclEEERNS2_INS_14SourceLocationEEEbbRS7_SA_b")
  //</editor-fold>
  protected /*private*/ boolean ParseObjCProtocolReferences(final SmallVectorImpl<Decl /*P*/ > /*&*/ Protocols, 
                             final SmallVectorImpl<SourceLocation> /*&*/ ProtocolLocs, 
                             boolean WarnOnDeclarations, boolean ForObjCContainer, 
                             final SourceLocation /*&*/ LAngleLoc, final SourceLocation /*&*/ EndLoc, 
                             boolean consumeLastToken) {
    assert ($this().Tok.is(tok.TokenKind.less)) : "expected <";
    
    LAngleLoc.$assignMove($this().ConsumeToken()); // the "<"
    
    SmallVector<std.pair<IdentifierInfo /*P*/ , SourceLocation>> ProtocolIdents/*J*/= new SmallVector<std.pair<IdentifierInfo /*P*/ , SourceLocation>>(8, new std.pairPtrType<IdentifierInfo /*P*/ , SourceLocation>(null, new SourceLocation()));
    while (true) {
      if ($this().Tok.is(tok.TokenKind.code_completion)) {
        $this().Actions.CodeCompleteObjCProtocolReferences(new ArrayRef<std.pair<IdentifierInfo /*P*/ , SourceLocation> >(ProtocolIdents));
        $this().cutOffParsing();
        return true;
      }
      if ($this().Tok.isNot(tok.TokenKind.identifier)) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_DiagnosticBuilder$C_TokenKind($c$.track($this().Diag($this().Tok, diag.err_expected)), tok.TokenKind.identifier));
          $this().SkipUntil(tok.TokenKind.greater, SkipUntilFlags.StopAtSemi);
          return true;
        } finally {
          $c$.$destroy();
        }
      }
      ProtocolIdents.push_back(std.make_pair_Ptr_T($this().Tok.getIdentifierInfo(), 
              $this().Tok.getLocation()));
      ProtocolLocs.push_back($this().Tok.getLocation());
      $this().ConsumeToken();
      if (!$this().TryConsumeToken(tok.TokenKind.comma)) {
        break;
      }
    }
    
    // Consume the '>'.
    if ($this().ParseGreaterThanInTemplateList(EndLoc, consumeLastToken, 
        /*ObjCGenericList=*/ false)) {
      return true;
    }
    
    // Convert the list of protocols identifiers into a list of protocol decls.
    $this().Actions.FindProtocolDeclaration(WarnOnDeclarations, ForObjCContainer, 
        new ArrayRef<std.pair<IdentifierInfo /*P*/ , SourceLocation> >(ProtocolIdents), Protocols);
    return false;
  }


/// Parse the first angle-bracket-delimited clause for an
/// Objective-C object or object pointer type, which may be either
/// type arguments or protocol qualifiers.

/// Parse Objective-C type arguments or protocol qualifiers.
///
///   objc-type-arguments:
///     '<' type-name '...'[opt] (',' type-name '...'[opt])* '>'
///
//<editor-fold defaultstate="collapsed" desc="clang::Parser::parseObjCTypeArgsOrProtocolQualifiers">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseObjc.cpp", line = 1615,
   FQN="clang::Parser::parseObjCTypeArgsOrProtocolQualifiers", NM="_ZN5clang6Parser37parseObjCTypeArgsOrProtocolQualifiersENS_9OpaquePtrINS_8QualTypeEEERNS_14SourceLocationERN4llvm15SmallVectorImplIS3_EES5_S5_RNS7_IPNS_4DeclEEERNS7_IS4_EES5_bb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseObjc.cpp -nm=_ZN5clang6Parser37parseObjCTypeArgsOrProtocolQualifiersENS_9OpaquePtrINS_8QualTypeEEERNS_14SourceLocationERN4llvm15SmallVectorImplIS3_EES5_S5_RNS7_IPNS_4DeclEEERNS7_IS4_EES5_bb")
  //</editor-fold>
  protected /*private*/ void parseObjCTypeArgsOrProtocolQualifiers(OpaquePtr<QualType> baseType, 
                                       final SourceLocation /*&*/ typeArgsLAngleLoc, 
                                       final SmallVectorImpl<OpaquePtr<QualType> > /*&*/ typeArgs, 
                                       final SourceLocation /*&*/ typeArgsRAngleLoc, 
                                       final SourceLocation /*&*/ protocolLAngleLoc, 
                                       final SmallVectorImpl<Decl /*P*/ > /*&*/ protocols, 
                                       final SmallVectorImpl<SourceLocation> /*&*/ protocolLocs, 
                                       final SourceLocation /*&*/ protocolRAngleLoc, 
                                       boolean consumeLastToken, 
                                       boolean warnOnIncompleteProtocols) {
    assert ($this().Tok.is(tok.TokenKind.less)) : "Not at the start of type args or protocols";
    SourceLocation lAngleLoc = $this().ConsumeToken();
    
    // Whether all of the elements we've parsed thus far are single
    // identifiers, which might be types or might be protocols.
    boolean allSingleIdentifiers = true;
    SmallVector<IdentifierInfo /*P*/> identifiers/*J*/= new SmallVector<IdentifierInfo /*P*/>(4, (IdentifierInfo /*P*/)null);
    final SmallVectorImpl<SourceLocation> /*&*/ identifierLocs = protocolLocs;
    
    // Parse a list of comma-separated identifiers, bailing out if we
    // see something different.
    do {
      // Parse a single identifier.
      if ($this().Tok.is(tok.TokenKind.identifier)
         && ($this().NextToken().is(tok.TokenKind.comma)
         || $this().NextToken().is(tok.TokenKind.greater)
         || $this().NextToken().is(tok.TokenKind.greatergreater))) {
        identifiers.push_back($this().Tok.getIdentifierInfo());
        identifierLocs.push_back($this().ConsumeToken());
        continue;
      }
      if ($this().Tok.is(tok.TokenKind.code_completion)) {
        // FIXME: Also include types here.
        SmallVector<std.pair<IdentifierInfo /*P*/ , SourceLocation>> identifierLocPairs/*J*/= new SmallVector<std.pair<IdentifierInfo /*P*/ , SourceLocation>>(4, new std.pairPtrType<IdentifierInfo /*P*/ , SourceLocation>(null, new SourceLocation()));
        for (/*uint*/int i = 0, n = identifiers.size(); i != n; ++i) {
          identifierLocPairs.push_back(new std.pairPtrType<IdentifierInfo /*P*/ , SourceLocation>(JD$T$RR_T1$RR.INSTANCE, (IdentifierInfo /*P*/)identifiers.$at(i), 
                  new SourceLocation(identifierLocs.$at(i))));
        }
        
        QualType BaseT = $this().Actions.GetTypeFromParser(new OpaquePtr<QualType>(baseType));
        if (!BaseT.isNull() && BaseT.$arrow().acceptsObjCTypeParams()) {
          $this().Actions.CodeCompleteOrdinaryName($this().getCurScope(), Sema.ParserCompletionContext.PCC_Type);
        } else {
          $this().Actions.CodeCompleteObjCProtocolReferences(new ArrayRef<std.pair<IdentifierInfo /*P*/ , SourceLocation> >(identifierLocPairs));
        }
        $this().cutOffParsing();
        return;
      }
      
      allSingleIdentifiers = false;
      break;
    } while ($this().TryConsumeToken(tok.TokenKind.comma));
    
    // If we parsed an identifier list, semantic analysis sorts out
    // whether it refers to protocols or to type arguments.
    if (allSingleIdentifiers) {
      // Parse the closing '>'.
      SourceLocation rAngleLoc/*J*/= new SourceLocation();
      /*(void)*/$this().ParseGreaterThanInTemplateList(rAngleLoc, consumeLastToken, 
          /*ObjCGenericList=*/ true);
      
      // Let Sema figure out what we parsed.
      $this().Actions.actOnObjCTypeArgsOrProtocolQualifiers($this().getCurScope(), 
          new OpaquePtr<QualType>(baseType), 
          new SourceLocation(lAngleLoc), 
          new ArrayRef<IdentifierInfo /*P*/ >(identifiers), 
          new ArrayRef<SourceLocation>(identifierLocs), 
          new SourceLocation(rAngleLoc), 
          typeArgsLAngleLoc, 
          typeArgs, 
          typeArgsRAngleLoc, 
          protocolLAngleLoc, 
          protocols, 
          protocolRAngleLoc, 
          warnOnIncompleteProtocols);
      return;
    }
    
    // We parsed an identifier list but stumbled into non single identifiers, this
    // means we might (a) check that what we already parsed is a legitimate type
    // (not a protocol or unknown type) and (b) parse the remaining ones, which
    // must all be type args.
    
    // Convert the identifiers into type arguments.
    boolean invalid = false;
    IdentifierInfo /*P*/ foundProtocolId = null, /*P*/ foundValidTypeId = null;
    SourceLocation foundProtocolSrcLoc/*J*/= new SourceLocation(), foundValidTypeSrcLoc/*J*/= new SourceLocation();
    SmallVector<IdentifierInfo /*P*/> unknownTypeArgs/*J*/= new SmallVector<IdentifierInfo /*P*/>(2, (IdentifierInfo /*P*/)null);
    SmallVector<SourceLocation> unknownTypeArgsLoc/*J*/= new SmallVector<SourceLocation>(2, new SourceLocation());
    
    for (/*uint*/int i = 0, n = identifiers.size(); i != n; ++i) {
      OpaquePtr<QualType> typeArg = $this().Actions.getTypeName($Deref(identifiers.$at(i)), new SourceLocation(identifierLocs.$at(i)), $this().getCurScope());
      if (typeArg.$bool()) {
        DeclSpec DS = null;
        Declarator D = null;
        try {
          DS/*J*/= new DeclSpec($this().AttrFactory);
          /*const*/char$ptr/*char P*/ prevSpec = create_char$null$ptr();
          /*uint*/uint$ref diagID = create_uint$ref();
          DS.SetTypeSpecType(TypeSpecifierType.TST_typename, new SourceLocation(identifierLocs.$at(i)), prevSpec, diagID, 
              new OpaquePtr<QualType>(typeArg), $this().Actions.getASTContext().getPrintingPolicy());
          
          // Form a declarator to turn this into a type.
          D/*J*/= new Declarator(DS, Declarator.TheContext.TypeNameContext);
          ActionResult<OpaquePtr<QualType> > fullTypeArg = $this().Actions.ActOnTypeName($this().getCurScope(), D);
          if (fullTypeArg.isUsable()) {
            typeArgs.push_back(fullTypeArg.get());
            if (!(foundValidTypeId != null)) {
              foundValidTypeId = identifiers.$at(i);
              foundValidTypeSrcLoc.$assign(identifierLocs.$at(i));
            }
          } else {
            invalid = true;
            unknownTypeArgs.push_back(identifiers.$at(i));
            unknownTypeArgsLoc.push_back(identifierLocs.$at(i));
          }
        } finally {
          if (D != null) { D.$destroy(); }
          if (DS != null) { DS.$destroy(); }
        }
      } else {
        invalid = true;
        if (!($this().Actions.LookupProtocol(identifiers.$at(i), new SourceLocation(identifierLocs.$at(i))) != null)) {
          unknownTypeArgs.push_back(identifiers.$at(i));
          unknownTypeArgsLoc.push_back(identifierLocs.$at(i));
        } else if (!(foundProtocolId != null)) {
          foundProtocolId = identifiers.$at(i);
          foundProtocolSrcLoc.$assign(identifierLocs.$at(i));
        }
      }
    }
    
    // Continue parsing type-names.
    do {
      Token CurTypeTok = new Token($this().Tok);
      ActionResult<OpaquePtr<QualType> > typeArg = $this().ParseTypeName();
      
      // Consume the '...' for a pack expansion.
      SourceLocation ellipsisLoc/*J*/= new SourceLocation();
      $this().TryConsumeToken(tok.TokenKind.ellipsis, ellipsisLoc);
      if (typeArg.isUsable() && ellipsisLoc.isValid()) {
        typeArg.$assignMove($this().Actions.ActOnPackExpansion(typeArg.get(), new SourceLocation(ellipsisLoc)));
      }
      if (typeArg.isUsable()) {
        typeArgs.push_back(typeArg.get());
        if (!(foundValidTypeId != null)) {
          foundValidTypeId = CurTypeTok.getIdentifierInfo();
          foundValidTypeSrcLoc.$assignMove(CurTypeTok.getLocation());
        }
      } else {
        invalid = true;
      }
    } while ($this().TryConsumeToken(tok.TokenKind.comma));
    
    // Diagnose the mix between type args and protocols.
    if ((foundProtocolId != null) && (foundValidTypeId != null)) {
      $this().Actions.DiagnoseTypeArgsAndProtocols(foundProtocolId, new SourceLocation(foundProtocolSrcLoc), 
          foundValidTypeId, 
          new SourceLocation(foundValidTypeSrcLoc));
    }
    
    // Diagnose unknown arg types.
    OpaquePtr<QualType> T/*J*/= new OpaquePtr<QualType>();
    if ((unknownTypeArgs.size() != 0)) {
      for (/*uint*/int i = 0, e = unknownTypeArgsLoc.size(); $less_uint(i, e); ++i)  {
        $this().Actions.DiagnoseUnknownTypeName(unknownTypeArgs.ref$at(i), new SourceLocation(unknownTypeArgsLoc.$at(i)), 
            $this().getCurScope(), (CXXScopeSpec /*P*/ )null, T);
      }
    }
    
    // Parse the closing '>'.
    SourceLocation rAngleLoc/*J*/= new SourceLocation();
    /*(void)*/$this().ParseGreaterThanInTemplateList(rAngleLoc, consumeLastToken, 
        /*ObjCGenericList=*/ true);
    if (invalid) {
      typeArgs.clear();
      return;
    }
    
    // Record left/right angle locations.
    typeArgsLAngleLoc.$assign(lAngleLoc);
    typeArgsRAngleLoc.$assign(rAngleLoc);
  }


/// Parse either Objective-C type arguments or protocol qualifiers; if the
/// former, also parse protocol qualifiers afterward.
//<editor-fold defaultstate="collapsed" desc="clang::Parser::parseObjCTypeArgsAndProtocolQualifiers">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseObjc.cpp", line = 1794,
   FQN="clang::Parser::parseObjCTypeArgsAndProtocolQualifiers", NM="_ZN5clang6Parser38parseObjCTypeArgsAndProtocolQualifiersENS_9OpaquePtrINS_8QualTypeEEERNS_14SourceLocationERN4llvm15SmallVectorImplIS3_EES5_S5_RNS7_IPNS_4DeclEEERNS7_IS4_EES5_b",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseObjc.cpp -nm=_ZN5clang6Parser38parseObjCTypeArgsAndProtocolQualifiersENS_9OpaquePtrINS_8QualTypeEEERNS_14SourceLocationERN4llvm15SmallVectorImplIS3_EES5_S5_RNS7_IPNS_4DeclEEERNS7_IS4_EES5_b")
  //</editor-fold>
  protected /*private*/ void parseObjCTypeArgsAndProtocolQualifiers(OpaquePtr<QualType> baseType, 
                                        final SourceLocation /*&*/ typeArgsLAngleLoc, 
                                        final SmallVectorImpl<OpaquePtr<QualType> > /*&*/ typeArgs, 
                                        final SourceLocation /*&*/ typeArgsRAngleLoc, 
                                        final SourceLocation /*&*/ protocolLAngleLoc, 
                                        final SmallVectorImpl<Decl /*P*/ > /*&*/ protocols, 
                                        final SmallVectorImpl<SourceLocation> /*&*/ protocolLocs, 
                                        final SourceLocation /*&*/ protocolRAngleLoc, 
                                        boolean consumeLastToken) {
    assert ($this().Tok.is(tok.TokenKind.less));
    
    // Parse the first angle-bracket-delimited clause.
    $this().parseObjCTypeArgsOrProtocolQualifiers(new OpaquePtr<QualType>(baseType), 
        typeArgsLAngleLoc, 
        typeArgs, 
        typeArgsRAngleLoc, 
        protocolLAngleLoc, 
        protocols, 
        protocolLocs, 
        protocolRAngleLoc, 
        consumeLastToken, 
        /*warnOnIncompleteProtocols=*/ false);
    
    // An Objective-C object pointer followed by type arguments
    // can then be followed again by a set of protocol references, e.g.,
    // \c NSArray<NSView><NSTextDelegate>
    if ((consumeLastToken && $this().Tok.is(tok.TokenKind.less))
       || (!consumeLastToken && $this().NextToken().is(tok.TokenKind.less))) {
      // If we aren't consuming the last token, the prior '>' is still hanging
      // there. Consume it before we parse the protocol qualifiers.
      if (!consumeLastToken) {
        $this().ConsumeToken();
      }
      if (!protocols.empty()) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          /*SkipUntilFlags*//*uint*/int skipFlags = SkipUntilFlags.INVALID;
          if (!consumeLastToken) {
            skipFlags = $bitor_SkipUntilFlags(/*KEEP_ENUM*/skipFlags, /*KEEP_ENUM*/SkipUntilFlags.StopBeforeMatch);
          }
          $c$.clean($out_DiagnosticBuilder$C_SourceRange($c$.track($this().Diag($this().Tok, diag.err_objc_type_args_after_protocols)), 
              new SourceRange(/*NO_COPY*/protocolLAngleLoc, /*NO_COPY*/protocolRAngleLoc)));
          $this().SkipUntil(tok.TokenKind.greater, tok.TokenKind.greatergreater, skipFlags);
        } finally {
          $c$.$destroy();
        }
      } else {
        $this().ParseObjCProtocolReferences(protocols, protocolLocs, 
            /*WarnOnDeclarations=*/ false, 
            /*ForObjCContainer=*/ false, 
            protocolLAngleLoc, protocolRAngleLoc, 
            consumeLastToken);
      }
    }
  }


/// Parse a protocol qualifier type such as '<NSCopying>', which is
/// an anachronistic way of writing 'id<NSCopying>'.
//<editor-fold defaultstate="collapsed" desc="clang::Parser::parseObjCProtocolQualifierType">
@Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseObjc.cpp", line = 1587,
   FQN="clang::Parser::parseObjCProtocolQualifierType", NM="_ZN5clang6Parser30parseObjCProtocolQualifierTypeERNS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseObjc.cpp -nm=_ZN5clang6Parser30parseObjCProtocolQualifierTypeERNS_14SourceLocationE")
  //</editor-fold>
  protected /*private*/ ActionResult<OpaquePtr<QualType> > parseObjCProtocolQualifierType(final SourceLocation /*&*/ rAngleLoc) {
    assert ($this().Tok.is(tok.TokenKind.less)) : "Protocol qualifiers start with '<'";
    assert ($this().getLangOpts().ObjC1) : "Protocol qualifiers only exist in Objective-C";
    
    SourceLocation lAngleLoc/*J*/= new SourceLocation();
    SmallVector<Decl /*P*/> protocols/*J*/= new SmallVector<Decl /*P*/>(8, null);
    SmallVector<SourceLocation> protocolLocs/*J*/= new SmallVector<SourceLocation>(8, new SourceLocation());
    /*(void)*/$this().ParseObjCProtocolReferences(protocols, protocolLocs, false, false, 
        lAngleLoc, rAngleLoc, 
        /*consumeLastToken=*/ true);
    ActionResult<OpaquePtr<QualType> > result = $this().Actions.actOnObjCProtocolQualifierType(new SourceLocation(lAngleLoc), 
        new ArrayRef<Decl /*P*/ >(protocols), 
        new ArrayRef<SourceLocation>(protocolLocs), 
        new SourceLocation(rAngleLoc));
    if (result.isUsable()) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_DiagnosticBuilder$C_SourceRange($out_DiagnosticBuilder$C_FixItHint$C($c$.track($this().Diag(new SourceLocation(lAngleLoc), diag.warn_objc_protocol_qualifier_missing_id)), 
                FixItHint.CreateInsertion(/*NO_COPY*/lAngleLoc, new StringRef(/*KEEP_STR*/"id"))), 
            new SourceRange(/*NO_COPY*/lAngleLoc, /*NO_COPY*/rAngleLoc)));
      } finally {
        $c$.$destroy();
      }
    }
    
    return result;
  }


/// Parse Objective-C type arguments and protocol qualifiers, extending the
/// current type with the parsed result.
//<editor-fold defaultstate="collapsed" desc="clang::Parser::parseObjCTypeArgsAndProtocolQualifiers">
@Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseObjc.cpp", line = 1845,
   FQN="clang::Parser::parseObjCTypeArgsAndProtocolQualifiers", NM="_ZN5clang6Parser38parseObjCTypeArgsAndProtocolQualifiersENS_14SourceLocationENS_9OpaquePtrINS_8QualTypeEEEbRS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseObjc.cpp -nm=_ZN5clang6Parser38parseObjCTypeArgsAndProtocolQualifiersENS_14SourceLocationENS_9OpaquePtrINS_8QualTypeEEEbRS1_")
  //</editor-fold>
  protected /*private*/ ActionResult<OpaquePtr<QualType> > parseObjCTypeArgsAndProtocolQualifiers(SourceLocation loc, 
                                        OpaquePtr<QualType> type, 
                                        boolean consumeLastToken, 
                                        final SourceLocation /*&*/ endLoc) {
    assert ($this().Tok.is(tok.TokenKind.less));
    SourceLocation typeArgsLAngleLoc/*J*/= new SourceLocation();
    SmallVector<OpaquePtr<QualType>> typeArgs/*J*/= new SmallVector<OpaquePtr<QualType>>(4, new OpaquePtr<QualType>());
    SourceLocation typeArgsRAngleLoc/*J*/= new SourceLocation();
    SourceLocation protocolLAngleLoc/*J*/= new SourceLocation();
    SmallVector<Decl /*P*/> protocols/*J*/= new SmallVector<Decl /*P*/>(4, null);
    SmallVector<SourceLocation> protocolLocs/*J*/= new SmallVector<SourceLocation>(4, new SourceLocation());
    SourceLocation protocolRAngleLoc/*J*/= new SourceLocation();
    
    // Parse type arguments and protocol qualifiers.
    $this().parseObjCTypeArgsAndProtocolQualifiers(new OpaquePtr<QualType>(type), typeArgsLAngleLoc, typeArgs, 
        typeArgsRAngleLoc, protocolLAngleLoc, 
        protocols, protocolLocs, 
        protocolRAngleLoc, consumeLastToken);
    
    // Compute the location of the last token.
    if (consumeLastToken) {
      endLoc.$assign($this().PrevTokLocation);
    } else {
      endLoc.$assignMove($this().Tok.getLocation());
    }
    
    return $this().Actions.actOnObjCTypeArgsAndProtocolQualifiers($this().getCurScope(), 
        new SourceLocation(loc), 
        new OpaquePtr<QualType>(type), 
        new SourceLocation(typeArgsLAngleLoc), 
        new ArrayRef<OpaquePtr<QualType> >(typeArgs), 
        new SourceLocation(typeArgsRAngleLoc), 
        new SourceLocation(protocolLAngleLoc), 
        new ArrayRef<Decl /*P*/ >(protocols), 
        new ArrayRef<SourceLocation>(protocolLocs), 
        new SourceLocation(protocolRAngleLoc));
  }


///   objc-interface-decl-list:
///     empty
///     objc-interface-decl-list objc-property-decl [OBJC2]
///     objc-interface-decl-list objc-method-requirement [OBJC2]
///     objc-interface-decl-list objc-method-proto ';'
///     objc-interface-decl-list declaration
///     objc-interface-decl-list ';'
///
///   objc-method-requirement: [OBJC2]
///     @required
///     @optional
///
//<editor-fold defaultstate="collapsed" desc="clang::Parser::ParseObjCInterfaceDeclList">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*refs for lambdas*/,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseObjc.cpp", line = 619,
   FQN="clang::Parser::ParseObjCInterfaceDeclList", NM="_ZN5clang6Parser26ParseObjCInterfaceDeclListENS_3tok15ObjCKeywordKindEPNS_4DeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseObjc.cpp -nm=_ZN5clang6Parser26ParseObjCInterfaceDeclListENS_3tok15ObjCKeywordKindEPNS_4DeclE")
  //</editor-fold>
  protected /*private*/ void ParseObjCInterfaceDeclList(/*tok.ObjCKeywordKind*/char contextKey, 
                            Decl /*P*/ CDecl) {
    SmallVector<Decl /*P*/> allMethods/*J*/= new SmallVector<Decl /*P*/>(32, null);
    SmallVector<OpaquePtr<DeclGroupRef>> allTUVariables/*J*/= new SmallVector<OpaquePtr<DeclGroupRef>>(8, new OpaquePtr<DeclGroupRef>());
    final/*tok.ObjCKeywordKind*/ushort$ref MethodImplKind = create_ushort$ref(tok.ObjCKeywordKind.objc_not_keyword);
    
    SourceRange AtEnd/*J*/= new SourceRange();
    while (true) {
      // If this is a method prototype, parse it.
      if ($this().Tok.isOneOf(tok.TokenKind.minus, tok.TokenKind.plus)) {
        {
          Decl /*P*/ methodPrototype = $this().ParseObjCMethodPrototype(MethodImplKind.$deref(), false);
          if ((methodPrototype != null)) {
            allMethods.push_back(methodPrototype);
          }
        }
        // Consume the ';' here, since ParseObjCMethodPrototype() is re-used for
        // method definitions.
        if ($this().ExpectAndConsumeSemi(diag.err_expected_semi_after_method_proto)) {
          // We didn't find a semi and we error'ed out. Skip until a ';' or '@'.
          $this().SkipUntil(tok.TokenKind.at, $bitor_SkipUntilFlags(/*KEEP_ENUM*/SkipUntilFlags.StopAtSemi, /*KEEP_ENUM*/SkipUntilFlags.StopBeforeMatch));
          if ($this().Tok.is(tok.TokenKind.semi)) {
            $this().ConsumeToken();
          }
        }
        continue;
      }
      if ($this().Tok.is(tok.TokenKind.l_paren)) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($c$.track($this().Diag($this().Tok, diag.err_expected_minus_or_plus)));
          $this().ParseObjCMethodDecl($this().Tok.getLocation(), 
              tok.TokenKind.minus, 
              MethodImplKind.$deref(), false);
          continue;
        } finally {
          $c$.$destroy();
        }
      }
      // Ignore excess semicolons.
      if ($this().Tok.is(tok.TokenKind.semi)) {
        $this().ConsumeToken();
        continue;
      }
      
      // If we got to the end of the file, exit the loop.
      if ($this().isEofOrEom()) {
        break;
      }
      
      // Code completion within an Objective-C interface.
      if ($this().Tok.is(tok.TokenKind.code_completion)) {
        $this().Actions.CodeCompleteOrdinaryName($this().getCurScope(), 
            ($this().CurParsedObjCImpl != null) ? Sema.ParserCompletionContext.PCC_ObjCImplementation : Sema.ParserCompletionContext.PCC_ObjCInterface);
        $this().cutOffParsing();
        return;
      }
      
      // If we don't have an @ directive, parse it as a function definition.
      if ($this().Tok.isNot(tok.TokenKind.at)) {
        ParsedAttributesWithRange attrs = null;
        try {
          // The code below does not consume '}'s because it is afraid of eating the
          // end of a namespace.  Because of the way this code is structured, an
          // erroneous r_brace would cause an infinite loop if not handled here.
          if ($this().Tok.is(tok.TokenKind.r_brace)) {
            break;
          }
          attrs/*J*/= new ParsedAttributesWithRange($this().AttrFactory);
          allTUVariables.push_back($this().ParseDeclarationOrFunctionDefinition(attrs));
          continue;
        } finally {
          if (attrs != null) { attrs.$destroy(); }
        }
      }
      
      // Otherwise, we have an @ directive, eat the @.
      SourceLocation AtLoc = $this().ConsumeToken(); // the "@"
      if ($this().Tok.is(tok.TokenKind.code_completion)) {
        $this().Actions.CodeCompleteObjCAtDirective($this().getCurScope());
        $this().cutOffParsing();
        return;
      }
      
      /*tok.ObjCKeywordKind*/char DirectiveKind = $this().Tok.getObjCKeywordID();
      if (DirectiveKind == tok.ObjCKeywordKind.objc_end) { // @end -> terminate list
        AtEnd.setBegin(/*NO_COPY*/AtLoc);
        AtEnd.setEnd($this().Tok.getLocation());
        break;
      } else if (DirectiveKind == tok.ObjCKeywordKind.objc_not_keyword) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($c$.track($this().Diag($this().Tok, diag.err_objc_unknown_at)));
          $this().SkipUntil(tok.TokenKind.semi);
          continue;
        } finally {
          $c$.$destroy();
        }
      }
      
      // Eat the identifier.
      $this().ConsumeToken();
      switch (DirectiveKind) {
       default:
        {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            // FIXME: If someone forgets an @end on a protocol, this loop will
            // continue to eat up tons of stuff and spew lots of nonsense errors.  It
            // would probably be better to bail out if we saw an @class or @interface
            // or something like that.
            $c$.clean($c$.track($this().Diag(new SourceLocation(AtLoc), diag.err_objc_illegal_interface_qual)));
            // Skip until we see an '@' or '}' or ';'.
            $this().SkipUntil(tok.TokenKind.r_brace, tok.TokenKind.at, SkipUntilFlags.StopAtSemi);
            break;
          } finally {
            $c$.$destroy();
          }
        }
       case tok.ObjCKeywordKind.objc_implementation:
       case tok.ObjCKeywordKind.objc_interface:
        {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            $c$.clean($out_DiagnosticBuilder$C_FixItHint$C($c$.track($this().Diag(new SourceLocation(AtLoc), diag.err_objc_missing_end)), 
                FixItHint.CreateInsertion(/*NO_COPY*/AtLoc, new StringRef(/*KEEP_STR*/"@end\n"))));
            $c$.clean($out_DiagnosticBuilder$C_int($c$.track($this().Diag(CDecl.getLocStart(), diag.note_objc_container_start)), 
                (int)$this().Actions.getObjCContainerKind().getValue()));
            $this().ConsumeToken();
            break;
          } finally {
            $c$.$destroy();
          }
        }
       case tok.ObjCKeywordKind.objc_required:
       case tok.ObjCKeywordKind.objc_optional:
        // This is only valid on protocols.
        // FIXME: Should this check for ObjC2 being enabled?
        if (contextKey != tok.ObjCKeywordKind.objc_protocol) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            $c$.clean($c$.track($this().Diag(new SourceLocation(AtLoc), diag.err_objc_directive_only_in_protocol)));
          } finally {
            $c$.$destroy();
          }
        } else {
          MethodImplKind.$set(DirectiveKind);
        }
        break;
       case tok.ObjCKeywordKind.objc_property:
        {
          ParsingDeclSpec DS = null;
          try {
            if (!$this().getLangOpts().ObjC2) {
              JavaCleaner $c$ = $createJavaCleaner();
              try {
                $c$.clean($c$.track($this().Diag(new SourceLocation(AtLoc), diag.err_objc_properties_require_objc2)));
              } finally {
                $c$.$destroy();
              }
            }
            
            ObjCDeclSpec OCDS/*J*/= new ObjCDeclSpec();
            SourceLocation LParenLoc/*J*/= new SourceLocation();
            // Parse property attribute list, if any.
            if ($this().Tok.is(tok.TokenKind.l_paren)) {
              LParenLoc.$assignMove($this().Tok.getLocation());
              $this().ParseObjCPropertyAttribute(OCDS);
            }
            
            final bool$ref addedToDeclSpec = create_bool$ref(false);
            ParsingFieldDeclarator$Ref2Void ObjCPropertyCallback =  /*[&]*/(ParsingFieldDeclarator /*&*/FD) -> 
              {
                if (FD.D.getIdentifier() == null) {
                  JavaCleaner $c$ = $createJavaCleaner();
                  try {
                    $c$.clean($out_DiagnosticBuilder$C_SourceRange($c$.track($this().Diag(new SourceLocation(AtLoc), diag.err_objc_property_requires_field_name)), 
                        FD.D.getSourceRange()));
                    return;
                  } finally {
                    $c$.$destroy();
                  }
                }
                if ((FD.BitfieldSize != null)) {
                  JavaCleaner $c$ = $createJavaCleaner();
                  try {
                    $c$.clean($out_DiagnosticBuilder$C_SourceRange($c$.track($this().Diag(new SourceLocation(AtLoc), diag.err_objc_property_bitfield)), 
                        FD.D.getSourceRange()));
                    return;
                  } finally {
                    $c$.$destroy();
                  }
                }
                
                // Map a nullability property attribute to a context-sensitive keyword
                // attribute.
                if (((OCDS.getPropertyAttributes() & ObjCDeclSpec.ObjCPropertyAttributeKind.DQ_PR_nullability) != 0)) {
                  addContextSensitiveTypeNullability(/*Deref*/$this(), FD.D, OCDS.getNullability(), 
                      OCDS.getNullabilityLoc(), 
                      addedToDeclSpec);
                }
                
                // Install the property declarator into interfaceDecl.
                IdentifierInfo /*P*/ SelName = (OCDS.getGetterName() != null) ? OCDS.getGetterName() : FD.D.getIdentifier();
                
                Selector GetterSel = $this().PP.getSelectorTable().getNullarySelector(SelName);
                IdentifierInfo /*P*/ SetterName = OCDS.getSetterName();
                Selector SetterSel/*J*/= new Selector();
                if ((SetterName != null)) {
                  SetterSel.$assignMove($this().PP.getSelectorTable().getSelector(1, $AddrOf(create_type$ptr(SetterName))));
                } else {
                  SetterSel.$assignMove(SelectorTable.constructSetterSelector($this().PP.getIdentifierTable(), $this().PP.getSelectorTable(), 
                          FD.D.getIdentifier()));
                }
                Decl /*P*/ Property = $this().Actions.ActOnProperty($this().getCurScope(), new SourceLocation(AtLoc), new SourceLocation(LParenLoc), FD, OCDS, new Selector(GetterSel), new Selector(SetterSel), 
                    MethodImplKind.$deref());
                
                FD.complete(Property);
              }
            ;
            
            // Parse all the comma separated declarators.
            DS/*J*/= new ParsingDeclSpec(/*Deref*/$this());
            $this().ParseStructDeclaration(DS, ObjCPropertyCallback);
            
            $this().ExpectAndConsume(tok.TokenKind.semi, diag.err_expected_semi_decl_list);
            break;
          } finally {
            if (DS != null) { DS.$destroy(); }
          }
        }
      }
    }
    
    // We break out of the big loop in two cases: when we see @end or when we see
    // EOF.  In the former case, eat the @end.  In the later case, emit an error.
    if ($this().Tok.is(tok.TokenKind.code_completion)) {
      $this().Actions.CodeCompleteObjCAtDirective($this().getCurScope());
      $this().cutOffParsing();
      return;
    } else if ($this().Tok.isObjCAtKeyword(tok.ObjCKeywordKind.objc_end)) {
      $this().ConsumeToken(); // the "end" identifier
    } else {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_DiagnosticBuilder$C_FixItHint$C($c$.track($this().Diag($this().Tok, diag.err_objc_missing_end)), 
            FixItHint.CreateInsertion($this().Tok.getLocation(), new StringRef(/*KEEP_STR*/"\n@end\n"))));
        $c$.clean($out_DiagnosticBuilder$C_int($c$.track($this().Diag(CDecl.getLocStart(), diag.note_objc_container_start)), 
            (int)$this().Actions.getObjCContainerKind().getValue()));
        AtEnd.setBegin($this().Tok.getLocation());
        AtEnd.setEnd($this().Tok.getLocation());
      } finally {
        $c$.$destroy();
      }
    }
    
    // Insert collected methods declarations into the @interface object.
    // This passes in an invalid SourceLocation for AtEndLoc when EOF is hit.
    $this().Actions.ActOnAtEnd($this().getCurScope(), new SourceRange(AtEnd), new ArrayRef<Decl /*P*/ >(allMethods), new ArrayRef<OpaquePtr<DeclGroupRef> >(allTUVariables));
  }


///   objc-protocol-declaration:
///     objc-protocol-definition
///     objc-protocol-forward-reference
///
///   objc-protocol-definition:
///     \@protocol identifier
///       objc-protocol-refs[opt]
///       objc-interface-decl-list
///     \@end
///
///   objc-protocol-forward-reference:
///     \@protocol identifier-list ';'
///
///   "\@protocol identifier ;" should be resolved as "\@protocol
///   identifier-list ;": objc-interface-decl-list may not start with a
///   semicolon in the first alternative if objc-protocol-refs are omitted.
//<editor-fold defaultstate="collapsed" desc="clang::Parser::ParseObjCAtProtocolDeclaration">
@Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseObjc.cpp", line = 2025,
   FQN="clang::Parser::ParseObjCAtProtocolDeclaration", NM="_ZN5clang6Parser30ParseObjCAtProtocolDeclarationENS_14SourceLocationERNS_16ParsedAttributesE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseObjc.cpp -nm=_ZN5clang6Parser30ParseObjCAtProtocolDeclarationENS_14SourceLocationERNS_16ParsedAttributesE")
  //</editor-fold>
  protected /*private*/ OpaquePtr<DeclGroupRef> ParseObjCAtProtocolDeclaration(SourceLocation AtLoc, 
                                final ParsedAttributes /*&*/ attrs) {
    assert ($this().Tok.isObjCAtKeyword(tok.ObjCKeywordKind.objc_protocol)) : "ParseObjCAtProtocolDeclaration(): Expected @protocol";
    $this().ConsumeToken(); // the "protocol" identifier
    if ($this().Tok.is(tok.TokenKind.code_completion)) {
      $this().Actions.CodeCompleteObjCProtocolDecl($this().getCurScope());
      $this().cutOffParsing();
      return new OpaquePtr<DeclGroupRef>(null);
    }
    
    $this().MaybeSkipAttributes(tok.ObjCKeywordKind.objc_protocol);
    if ($this().Tok.isNot(tok.TokenKind.identifier)) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_DiagnosticBuilder$C_TokenKind($c$.track($this().Diag($this().Tok, diag.err_expected)), tok.TokenKind.identifier)); // missing protocol name.
        return new OpaquePtr<DeclGroupRef>(null);
      } finally {
        $c$.$destroy();
      }
    }
    // Save the protocol name, then consume it.
    IdentifierInfo /*P*/ protocolName = $this().Tok.getIdentifierInfo();
    SourceLocation nameLoc = $this().ConsumeToken();
    if ($this().TryConsumeToken(tok.TokenKind.semi)) { // forward declaration of one protocol.
      std.pair<IdentifierInfo /*P*/ , SourceLocation> ProtoInfo/*J*/= new std.pairPtrType<IdentifierInfo /*P*/ , SourceLocation>(JD$T$RR_T1$RR.INSTANCE, protocolName, nameLoc);
      return $this().Actions.ActOnForwardProtocolDeclaration(new SourceLocation(AtLoc), new ArrayRef<std.pair<IdentifierInfo /*P*/ , SourceLocation> >(ProtoInfo), 
          attrs.getList());
    }
    
    $this().CheckNestedObjCContexts(new SourceLocation(AtLoc));
    if ($this().Tok.is(tok.TokenKind.comma)) { // list of forward declarations.
      SmallVector<std.pair<IdentifierInfo /*P*/ , SourceLocation>> ProtocolRefs/*J*/= new SmallVector<std.pair<IdentifierInfo /*P*/ , SourceLocation>>(8, new std.pairPtrType<IdentifierInfo /*P*/ , SourceLocation>(null, new SourceLocation()));
      ProtocolRefs.push_back(std.make_pair_Ptr_T(protocolName, nameLoc));
      
      // Parse the list of forward declarations.
      while (true) {
        $this().ConsumeToken(); // the ','
        if ($this().Tok.isNot(tok.TokenKind.identifier)) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            $c$.clean($out_DiagnosticBuilder$C_TokenKind($c$.track($this().Diag($this().Tok, diag.err_expected)), tok.TokenKind.identifier));
            $this().SkipUntil(tok.TokenKind.semi);
            return new OpaquePtr<DeclGroupRef>(null);
          } finally {
            $c$.$destroy();
          }
        }
        ProtocolRefs.push_back(new std.pairPtrType<IdentifierInfo /*P*/ , SourceLocation>(JD$T$RR_T1$RR.INSTANCE, $this().Tok.getIdentifierInfo(), 
                $this().Tok.getLocation()));
        $this().ConsumeToken(); // the identifier
        if ($this().Tok.isNot(tok.TokenKind.comma)) {
          break;
        }
      }
      // Consume the ';'.
      if ($this().ExpectAndConsume(tok.TokenKind.semi, diag.err_expected_after, new StringRef(/*KEEP_STR*/"@protocol"))) {
        return new OpaquePtr<DeclGroupRef>(null);
      }
      
      return $this().Actions.ActOnForwardProtocolDeclaration(new SourceLocation(AtLoc), new ArrayRef<std.pair<IdentifierInfo /*P*/ , SourceLocation> >(ProtocolRefs), 
          attrs.getList());
    }
    
    // Last, and definitely not least, parse a protocol declaration.
    SourceLocation LAngleLoc/*J*/= new SourceLocation(), EndProtoLoc/*J*/= new SourceLocation();
    
    SmallVector<Decl /*P*/> ProtocolRefs/*J*/= new SmallVector<Decl /*P*/>(8, null);
    SmallVector<SourceLocation> ProtocolLocs/*J*/= new SmallVector<SourceLocation>(8, new SourceLocation());
    if ($this().Tok.is(tok.TokenKind.less)
       && $this().ParseObjCProtocolReferences(ProtocolRefs, ProtocolLocs, false, true, 
        LAngleLoc, EndProtoLoc, 
        /*consumeLastToken=*/ true)) {
      return new OpaquePtr<DeclGroupRef>(null);
    }
    
    Decl /*P*/ ProtoType = $this().Actions.ActOnStartProtocolInterface(new SourceLocation(AtLoc), protocolName, new SourceLocation(nameLoc), 
        ProtocolRefs.data(), 
        ProtocolRefs.size(), 
        ProtocolLocs.data(), 
        new SourceLocation(EndProtoLoc), attrs.getList());
    
    $this().ParseObjCInterfaceDeclList(tok.ObjCKeywordKind.objc_protocol, ProtoType);
    return $this().Actions.ConvertDeclToDeclGroup(ProtoType);
  }


/// StashAwayMethodOrFunctionBodyTokens -  Consume the tokens and store them 
/// for later parsing.
//<editor-fold defaultstate="collapsed" desc="clang::Parser::StashAwayMethodOrFunctionBodyTokens">
@Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseObjc.cpp", line = 2658,
   FQN="clang::Parser::StashAwayMethodOrFunctionBodyTokens", NM="_ZN5clang6Parser35StashAwayMethodOrFunctionBodyTokensEPNS_4DeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseObjc.cpp -nm=_ZN5clang6Parser35StashAwayMethodOrFunctionBodyTokensEPNS_4DeclE")
  //</editor-fold>
  protected /*private*/ void StashAwayMethodOrFunctionBodyTokens(Decl /*P*/ MDecl) {
    if ($this().SkipFunctionBodies && (!(MDecl != null) || $this().Actions.canSkipFunctionBody(MDecl))
       && $this().trySkippingFunctionBody()) {
      $this().Actions.ActOnSkippedFunctionBody(MDecl);
      return;
    }
    
    LexedMethod /*P*/ LM = new LexedMethod($this(), MDecl);
    $this().CurParsedObjCImpl.LateParsedObjCMethods.push_back(LM);
    final SmallVectorToken /*&*/ Toks = LM.Toks;
    // Begin by storing the '{' or 'try' or ':' token.
    Toks.push_back($this().Tok);
    if ($this().Tok.is(tok.TokenKind.kw_try)) {
      $this().ConsumeToken();
      if ($this().Tok.is(tok.TokenKind.colon)) {
        Toks.push_back($this().Tok);
        $this().ConsumeToken();
        while ($this().Tok.isNot(tok.TokenKind.l_brace)) {
          $this().ConsumeAndStoreUntil(tok.TokenKind.l_paren, Toks, /*StopAtSemi=*/ false);
          $this().ConsumeAndStoreUntil(tok.TokenKind.r_paren, Toks, /*StopAtSemi=*/ false);
        }
      }
      Toks.push_back($this().Tok); // also store '{'
    } else if ($this().Tok.is(tok.TokenKind.colon)) {
      $this().ConsumeToken();
      // FIXME: This is wrong, due to C++11 braced initialization.
      while ($this().Tok.isNot(tok.TokenKind.l_brace)) {
        $this().ConsumeAndStoreUntil(tok.TokenKind.l_paren, Toks, /*StopAtSemi=*/ false);
        $this().ConsumeAndStoreUntil(tok.TokenKind.r_paren, Toks, /*StopAtSemi=*/ false);
      }
      Toks.push_back($this().Tok); // also store '{'
    }
    $this().ConsumeBrace();
    // Consume everything up to (and including) the matching right brace.
    $this().ConsumeAndStoreUntil(tok.TokenKind.r_brace, Toks, /*StopAtSemi=*/ false);
    while ($this().Tok.is(tok.TokenKind.kw_catch)) {
      $this().ConsumeAndStoreUntil(tok.TokenKind.l_brace, Toks, /*StopAtSemi=*/ false);
      $this().ConsumeAndStoreUntil(tok.TokenKind.r_brace, Toks, /*StopAtSemi=*/ false);
    }
  }


///   objc-implementation:
///     objc-class-implementation-prologue
///     objc-category-implementation-prologue
///
///   objc-class-implementation-prologue:
///     @implementation identifier objc-superclass[opt]
///       objc-class-instance-variables[opt]
///
///   objc-category-implementation-prologue:
///     @implementation identifier ( identifier )
//<editor-fold defaultstate="collapsed" desc="clang::Parser::ParseObjCAtImplementationDeclaration">
@Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseObjc.cpp", line = 2115,
   FQN="clang::Parser::ParseObjCAtImplementationDeclaration", NM="_ZN5clang6Parser36ParseObjCAtImplementationDeclarationENS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseObjc.cpp -nm=_ZN5clang6Parser36ParseObjCAtImplementationDeclarationENS_14SourceLocationE")
  //</editor-fold>
  protected /*private*/ OpaquePtr<DeclGroupRef> ParseObjCAtImplementationDeclaration(SourceLocation AtLoc) {
    assert ($this().Tok.isObjCAtKeyword(tok.ObjCKeywordKind.objc_implementation)) : "ParseObjCAtImplementationDeclaration(): Expected @implementation";
    $this().CheckNestedObjCContexts(new SourceLocation(AtLoc));
    $this().ConsumeToken(); // the "implementation" identifier
    
    // Code completion after '@implementation'.
    if ($this().Tok.is(tok.TokenKind.code_completion)) {
      $this().Actions.CodeCompleteObjCImplementationDecl($this().getCurScope());
      $this().cutOffParsing();
      return new OpaquePtr<DeclGroupRef>(null);
    }
    
    $this().MaybeSkipAttributes(tok.ObjCKeywordKind.objc_implementation);
    if ($this().Tok.isNot(tok.TokenKind.identifier)) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_DiagnosticBuilder$C_TokenKind($c$.track($this().Diag($this().Tok, diag.err_expected)), 
            tok.TokenKind.identifier)); // missing class or category name.
        return new OpaquePtr<DeclGroupRef>(null);
      } finally {
        $c$.$destroy();
      }
    }
    // We have a class or category name - consume it.
    IdentifierInfo /*P*/ nameId = $this().Tok.getIdentifierInfo();
    SourceLocation nameLoc = $this().ConsumeToken(); // consume class or category name
    Decl /*P*/ ObjCImpDecl = null;
    
    // Neither a type parameter list nor a list of protocol references is
    // permitted here. Parse and diagnose them.
    if ($this().Tok.is(tok.TokenKind.less)) {
      ObjCTypeParamListScope typeParamScope = null;
      try {
        SourceLocation lAngleLoc/*J*/= new SourceLocation(), rAngleLoc/*J*/= new SourceLocation();
        SmallVector<std.pair<IdentifierInfo /*P*/ , SourceLocation>> protocolIdents/*J*/= new SmallVector<std.pair<IdentifierInfo /*P*/ , SourceLocation>>(8, new std.pairPtrType<IdentifierInfo /*P*/ , SourceLocation>(null, new SourceLocation()));
        SourceLocation diagLoc = $this().Tok.getLocation();
        typeParamScope/*J*/= new ObjCTypeParamListScope($this().Actions, $this().getCurScope());
        if (($this().parseObjCTypeParamListOrProtocolRefs(typeParamScope, lAngleLoc, 
            protocolIdents, rAngleLoc) != null)) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            $c$.clean($out_DiagnosticBuilder$C_SourceRange($c$.track($this().Diag(new SourceLocation(diagLoc), diag.err_objc_parameterized_implementation)), 
                new SourceRange(/*NO_COPY*/diagLoc, /*NO_COPY*/$this().PrevTokLocation)));
          } finally {
            $c$.$destroy();
          }
        } else if (lAngleLoc.isValid()) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            $c$.clean($out_DiagnosticBuilder$C_FixItHint$C($c$.track($this().Diag(new SourceLocation(lAngleLoc), diag.err_unexpected_protocol_qualifier)), 
                FixItHint.CreateRemoval(new SourceRange(/*NO_COPY*/lAngleLoc, /*NO_COPY*/rAngleLoc))));
          } finally {
            $c$.$destroy();
          }
        }
      } finally {
        if (typeParamScope != null) { typeParamScope.$destroy(); }
      }
    }
    if ($this().Tok.is(tok.TokenKind.l_paren)) {
      // we have a category implementation.
      $this().ConsumeParen();
      SourceLocation categoryLoc/*J*/= new SourceLocation(), rparenLoc/*J*/= new SourceLocation();
      IdentifierInfo /*P*/ categoryId = null;
      if ($this().Tok.is(tok.TokenKind.code_completion)) {
        $this().Actions.CodeCompleteObjCImplementationCategory($this().getCurScope(), nameId, new SourceLocation(nameLoc));
        $this().cutOffParsing();
        return new OpaquePtr<DeclGroupRef>(null);
      }
      if ($this().Tok.is(tok.TokenKind.identifier)) {
        categoryId = $this().Tok.getIdentifierInfo();
        categoryLoc.$assignMove($this().ConsumeToken());
      } else {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_DiagnosticBuilder$C_TokenKind($c$.track($this().Diag($this().Tok, diag.err_expected)), 
              tok.TokenKind.identifier)); // missing category name.
          return new OpaquePtr<DeclGroupRef>(null);
        } finally {
          $c$.$destroy();
        }
      }
      if ($this().Tok.isNot(tok.TokenKind.r_paren)) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_DiagnosticBuilder$C_TokenKind($c$.track($this().Diag($this().Tok, diag.err_expected)), tok.TokenKind.r_paren));
          $this().SkipUntil(tok.TokenKind.r_paren); // don't stop at ';'
          return new OpaquePtr<DeclGroupRef>(null);
        } finally {
          $c$.$destroy();
        }
      }
      rparenLoc.$assignMove($this().ConsumeParen());
      if ($this().Tok.is(tok.TokenKind.less)) { // we have illegal '<' try to recover
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($c$.track($this().Diag($this().Tok, diag.err_unexpected_protocol_qualifier)));
          SourceLocation protocolLAngleLoc/*J*/= new SourceLocation(), protocolRAngleLoc/*J*/= new SourceLocation();
          SmallVector<Decl /*P*/> protocols/*J*/= new SmallVector<Decl /*P*/>(4, null);
          SmallVector<SourceLocation> protocolLocs/*J*/= new SmallVector<SourceLocation>(4, new SourceLocation());
          /*(void)*/$this().ParseObjCProtocolReferences(protocols, protocolLocs, 
              /*warnOnIncompleteProtocols=*/ false, 
              /*ForObjCContainer=*/ false, 
              protocolLAngleLoc, protocolRAngleLoc, 
              /*consumeLastToken=*/ true);
        } finally {
          $c$.$destroy();
        }
      }
      ObjCImpDecl = $this().Actions.ActOnStartCategoryImplementation(new SourceLocation(AtLoc), nameId, new SourceLocation(nameLoc), categoryId, 
          new SourceLocation(categoryLoc));
    } else {
      // We have a class implementation
      SourceLocation superClassLoc/*J*/= new SourceLocation();
      IdentifierInfo /*P*/ superClassId = null;
      if ($this().TryConsumeToken(tok.TokenKind.colon)) {
        // We have a super class
        if ($this().Tok.isNot(tok.TokenKind.identifier)) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            $c$.clean($out_DiagnosticBuilder$C_TokenKind($c$.track($this().Diag($this().Tok, diag.err_expected)), 
                tok.TokenKind.identifier)); // missing super class name.
            return new OpaquePtr<DeclGroupRef>(null);
          } finally {
            $c$.$destroy();
          }
        }
        superClassId = $this().Tok.getIdentifierInfo();
        superClassLoc.$assignMove($this().ConsumeToken()); // Consume super class name
      }
      ObjCImpDecl = $this().Actions.ActOnStartClassImplementation(new SourceLocation(AtLoc), nameId, new SourceLocation(nameLoc), 
          superClassId, new SourceLocation(superClassLoc));
      if ($this().Tok.is(tok.TokenKind.l_brace)) { // we have ivars
        $this().ParseObjCClassInstanceVariables(ObjCImpDecl, tok.ObjCKeywordKind.objc_private, new SourceLocation(AtLoc));
      } else if ($this().Tok.is(tok.TokenKind.less)) { // we have illegal '<' try to recover
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($c$.track($this().Diag($this().Tok, diag.err_unexpected_protocol_qualifier)));
          
          SourceLocation protocolLAngleLoc/*J*/= new SourceLocation(), protocolRAngleLoc/*J*/= new SourceLocation();
          SmallVector<Decl /*P*/> protocols/*J*/= new SmallVector<Decl /*P*/>(4, null);
          SmallVector<SourceLocation> protocolLocs/*J*/= new SmallVector<SourceLocation>(4, new SourceLocation());
          /*(void)*/$this().ParseObjCProtocolReferences(protocols, protocolLocs, 
              /*warnOnIncompleteProtocols=*/ false, 
              /*ForObjCContainer=*/ false, 
              protocolLAngleLoc, protocolRAngleLoc, 
              /*consumeLastToken=*/ true);
        } finally {
          $c$.$destroy();
        }
      }
    }
    assert (ObjCImpDecl != null);
    
    SmallVector<Decl /*P*/> DeclsInGroup/*J*/= new SmallVector<Decl /*P*/>(8, null);
    {
      ObjCImplParsingDataRAII ObjCImplParsing = null;
      try {
        ObjCImplParsing/*J*/= new ObjCImplParsingDataRAII(/*Deref*/$this(), ObjCImpDecl);
        while (!ObjCImplParsing.isFinished() && !$this().isEofOrEom()) {
          ParsedAttributesWithRange attrs = null;
          try {
            attrs/*J*/= new ParsedAttributesWithRange($this().AttrFactory);
            $this().MaybeParseCXX11Attributes(attrs);
            $this().MaybeParseMicrosoftAttributes(attrs);
            {
              OpaquePtr<DeclGroupRef> DGP = $this().ParseExternalDeclaration(attrs);
              if (DGP.$bool()) {
                DeclGroupRef DG = DGP.getDeclGroupRef();
                DeclsInGroup.append_T(DG.begin(), DG.end());
              }
            }
          } finally {
            if (attrs != null) { attrs.$destroy(); }
          }
        }
      } finally {
        if (ObjCImplParsing != null) { ObjCImplParsing.$destroy(); }
      }
    }
    
    return $this().Actions.ActOnFinishObjCImplementation(ObjCImpDecl, new ArrayRef<Decl /*P*/ >(DeclsInGroup));
  }

//<editor-fold defaultstate="collapsed" desc="clang::Parser::ParseObjCAtEndDeclaration">
@Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseObjc.cpp", line = 2252,
   FQN="clang::Parser::ParseObjCAtEndDeclaration", NM="_ZN5clang6Parser25ParseObjCAtEndDeclarationENS_11SourceRangeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseObjc.cpp -nm=_ZN5clang6Parser25ParseObjCAtEndDeclarationENS_11SourceRangeE")
  //</editor-fold>
  protected /*private*/ OpaquePtr<DeclGroupRef> ParseObjCAtEndDeclaration(SourceRange atEnd) {
    assert ($this().Tok.isObjCAtKeyword(tok.ObjCKeywordKind.objc_end)) : "ParseObjCAtEndDeclaration(): Expected @end";
    $this().ConsumeToken(); // the "end" identifier
    if (($this().CurParsedObjCImpl != null)) {
      $this().CurParsedObjCImpl.finish(new SourceRange(atEnd));
    } else {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        // missing @implementation
        $c$.clean($c$.track($this().Diag(atEnd.getBegin(), diag.err_expected_objc_container)));
      } finally {
        $c$.$destroy();
      }
    }
    return new OpaquePtr<DeclGroupRef>(null);
  }


///   compatibility-alias-decl:
///     @compatibility_alias alias-name  class-name ';'
///
//<editor-fold defaultstate="collapsed" desc="clang::Parser::ParseObjCAtAliasDeclaration">
@Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseObjc.cpp", line = 2306,
   FQN="clang::Parser::ParseObjCAtAliasDeclaration", NM="_ZN5clang6Parser27ParseObjCAtAliasDeclarationENS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseObjc.cpp -nm=_ZN5clang6Parser27ParseObjCAtAliasDeclarationENS_14SourceLocationE")
  //</editor-fold>
  protected /*private*/ Decl /*P*/ ParseObjCAtAliasDeclaration(SourceLocation atLoc) {
    assert ($this().Tok.isObjCAtKeyword(tok.ObjCKeywordKind.objc_compatibility_alias)) : "ParseObjCAtAliasDeclaration(): Expected @compatibility_alias";
    $this().ConsumeToken(); // consume compatibility_alias
    if ($this().Tok.isNot(tok.TokenKind.identifier)) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_DiagnosticBuilder$C_TokenKind($c$.track($this().Diag($this().Tok, diag.err_expected)), tok.TokenKind.identifier));
        return null;
      } finally {
        $c$.$destroy();
      }
    }
    IdentifierInfo /*P*/ aliasId = $this().Tok.getIdentifierInfo();
    SourceLocation aliasLoc = $this().ConsumeToken(); // consume alias-name
    if ($this().Tok.isNot(tok.TokenKind.identifier)) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_DiagnosticBuilder$C_TokenKind($c$.track($this().Diag($this().Tok, diag.err_expected)), tok.TokenKind.identifier));
        return null;
      } finally {
        $c$.$destroy();
      }
    }
    IdentifierInfo /*P*/ classId = $this().Tok.getIdentifierInfo();
    SourceLocation classLoc = $this().ConsumeToken(); // consume class-name;
    $this().ExpectAndConsume(tok.TokenKind.semi, diag.err_expected_after, new StringRef(/*KEEP_STR*/"@compatibility_alias"));
    return $this().Actions.ActOnCompatibilityAlias(new SourceLocation(atLoc), aliasId, new SourceLocation(aliasLoc), 
        classId, new SourceLocation(classLoc));
  }


///   property-synthesis:
///     @synthesize property-ivar-list ';'
///
///   property-ivar-list:
///     property-ivar
///     property-ivar-list ',' property-ivar
///
///   property-ivar:
///     identifier
///     identifier '=' identifier
///
//<editor-fold defaultstate="collapsed" desc="clang::Parser::ParseObjCPropertySynthesize">
@Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseObjc.cpp", line = 2338,
   FQN="clang::Parser::ParseObjCPropertySynthesize", NM="_ZN5clang6Parser27ParseObjCPropertySynthesizeENS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseObjc.cpp -nm=_ZN5clang6Parser27ParseObjCPropertySynthesizeENS_14SourceLocationE")
  //</editor-fold>
  protected /*private*/ Decl /*P*/ ParseObjCPropertySynthesize(SourceLocation atLoc) {
    assert ($this().Tok.isObjCAtKeyword(tok.ObjCKeywordKind.objc_synthesize)) : "ParseObjCPropertySynthesize(): Expected '@synthesize'";
    $this().ConsumeToken(); // consume synthesize
    while (true) {
      if ($this().Tok.is(tok.TokenKind.code_completion)) {
        $this().Actions.CodeCompleteObjCPropertyDefinition($this().getCurScope());
        $this().cutOffParsing();
        return null;
      }
      if ($this().Tok.isNot(tok.TokenKind.identifier)) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($c$.track($this().Diag($this().Tok, diag.err_synthesized_property_name)));
          $this().SkipUntil(tok.TokenKind.semi);
          return null;
        } finally {
          $c$.$destroy();
        }
      }
      
      IdentifierInfo /*P*/ propertyIvar = null;
      IdentifierInfo /*P*/ propertyId = $this().Tok.getIdentifierInfo();
      SourceLocation propertyLoc = $this().ConsumeToken(); // consume property name
      SourceLocation propertyIvarLoc/*J*/= new SourceLocation();
      if ($this().TryConsumeToken(tok.TokenKind.equal)) {
        // property '=' ivar-name
        if ($this().Tok.is(tok.TokenKind.code_completion)) {
          $this().Actions.CodeCompleteObjCPropertySynthesizeIvar($this().getCurScope(), propertyId);
          $this().cutOffParsing();
          return null;
        }
        if ($this().Tok.isNot(tok.TokenKind.identifier)) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            $c$.clean($out_DiagnosticBuilder$C_TokenKind($c$.track($this().Diag($this().Tok, diag.err_expected)), tok.TokenKind.identifier));
            break;
          } finally {
            $c$.$destroy();
          }
        }
        propertyIvar = $this().Tok.getIdentifierInfo();
        propertyIvarLoc.$assignMove($this().ConsumeToken()); // consume ivar-name
      }
      $this().Actions.ActOnPropertyImplDecl($this().getCurScope(), new SourceLocation(atLoc), new SourceLocation(propertyLoc), true, 
          propertyId, propertyIvar, new SourceLocation(propertyIvarLoc), 
          ObjCPropertyQueryKind.OBJC_PR_query_unknown);
      if ($this().Tok.isNot(tok.TokenKind.comma)) {
        break;
      }
      $this().ConsumeToken(); // consume ','
    }
    $this().ExpectAndConsume(tok.TokenKind.semi, diag.err_expected_after, new StringRef(/*KEEP_STR*/"@synthesize"));
    return null;
  }


///   property-dynamic:
///     @dynamic  property-list
///
///   property-list:
///     identifier
///     property-list ',' identifier
///
//<editor-fold defaultstate="collapsed" desc="clang::Parser::ParseObjCPropertyDynamic">
@Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseObjc.cpp", line = 2394,
   FQN="clang::Parser::ParseObjCPropertyDynamic", NM="_ZN5clang6Parser24ParseObjCPropertyDynamicENS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseObjc.cpp -nm=_ZN5clang6Parser24ParseObjCPropertyDynamicENS_14SourceLocationE")
  //</editor-fold>
  protected /*private*/ Decl /*P*/ ParseObjCPropertyDynamic(SourceLocation atLoc) {
    assert ($this().Tok.isObjCAtKeyword(tok.ObjCKeywordKind.objc_dynamic)) : "ParseObjCPropertyDynamic(): Expected '@dynamic'";
    $this().ConsumeToken(); // consume dynamic
    
    boolean isClassProperty = false;
    if ($this().Tok.is(tok.TokenKind.l_paren)) {
      $this().ConsumeParen();
      /*const*/ IdentifierInfo /*P*/ II = $this().Tok.getIdentifierInfo();
      if (!(II != null)) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_DiagnosticBuilder$C_IdentifierInfo$C$P($c$.track($this().Diag($this().Tok, diag.err_objc_expected_property_attr)), II));
          $this().SkipUntil(tok.TokenKind.r_paren, SkipUntilFlags.StopAtSemi);
        } finally {
          $c$.$destroy();
        }
      } else {
        SourceLocation AttrName = $this().ConsumeToken(); // consume attribute name
        if (II.isStr(/*KEEP_STR*/"class")) {
          isClassProperty = true;
          if ($this().Tok.isNot(tok.TokenKind.r_paren)) {
            JavaCleaner $c$ = $createJavaCleaner();
            try {
              $c$.clean($out_DiagnosticBuilder$C_TokenKind($c$.track($this().Diag($this().Tok, diag.err_expected)), tok.TokenKind.r_paren));
              $this().SkipUntil(tok.TokenKind.r_paren, SkipUntilFlags.StopAtSemi);
            } finally {
              $c$.$destroy();
            }
          } else {
            $this().ConsumeParen();
          }
        } else {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            $c$.clean($out_DiagnosticBuilder$C_IdentifierInfo$C$P($c$.track($this().Diag(new SourceLocation(AttrName), diag.err_objc_expected_property_attr)), II));
            $this().SkipUntil(tok.TokenKind.r_paren, SkipUntilFlags.StopAtSemi);
          } finally {
            $c$.$destroy();
          }
        }
      }
    }
    while (true) {
      if ($this().Tok.is(tok.TokenKind.code_completion)) {
        $this().Actions.CodeCompleteObjCPropertyDefinition($this().getCurScope());
        $this().cutOffParsing();
        return null;
      }
      if ($this().Tok.isNot(tok.TokenKind.identifier)) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_DiagnosticBuilder$C_TokenKind($c$.track($this().Diag($this().Tok, diag.err_expected)), tok.TokenKind.identifier));
          $this().SkipUntil(tok.TokenKind.semi);
          return null;
        } finally {
          $c$.$destroy();
        }
      }
      
      IdentifierInfo /*P*/ propertyId = $this().Tok.getIdentifierInfo();
      SourceLocation propertyLoc = $this().ConsumeToken(); // consume property name
      $this().Actions.ActOnPropertyImplDecl($this().getCurScope(), new SourceLocation(atLoc), new SourceLocation(propertyLoc), false, 
          propertyId, (IdentifierInfo /*P*/ )null, new SourceLocation(), 
          isClassProperty ? ObjCPropertyQueryKind.OBJC_PR_query_class : ObjCPropertyQueryKind.OBJC_PR_query_unknown);
      if ($this().Tok.isNot(tok.TokenKind.comma)) {
        break;
      }
      $this().ConsumeToken(); // consume ','
    }
    $this().ExpectAndConsume(tok.TokenKind.semi, diag.err_expected_after, new StringRef(/*KEEP_STR*/"@dynamic"));
    return null;
  }


///   objc-selector:
///     identifier
///     one of
///       enum struct union if else while do for switch case default
///       break continue return goto asm sizeof typeof __alignof
///       unsigned long const short volatile signed restrict _Complex
///       in out inout bycopy byref oneway int char float double void _Bool
///
//<editor-fold defaultstate="collapsed" desc="clang::Parser::ParseObjCSelectorPiece">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   optimized = Converted.Optimization.VALUE_TYPE,     
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseObjc.cpp", line = 1019,
   FQN="clang::Parser::ParseObjCSelectorPiece", NM="_ZN5clang6Parser22ParseObjCSelectorPieceERNS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseObjc.cpp -nm=_ZN5clang6Parser22ParseObjCSelectorPieceERNS_14SourceLocationE")
  //</editor-fold>
  protected /*private*/ IdentifierInfo /*P*/ ParseObjCSelectorPiece(final SourceLocation /*&*/ SelectorLoc) {
    switch ($this().Tok.getKind()) {
     default:
      return null;
     case tok.TokenKind.ampamp:
     case tok.TokenKind.ampequal:
     case tok.TokenKind.amp:
     case tok.TokenKind.pipe:
     case tok.TokenKind.tilde:
     case tok.TokenKind.exclaim:
     case tok.TokenKind.exclaimequal:
     case tok.TokenKind.pipepipe:
     case tok.TokenKind.pipeequal:
     case tok.TokenKind.caret:
     case tok.TokenKind.caretequal:
      {
        std.string ThisTok/*J*/= $this().PP.getSpelling($this().Tok);
        if (isLetter(ThisTok.$at(0))) {
          IdentifierInfo /*P*/ II = $AddrOf($this().PP.getIdentifierTable().get(/*JAVA:PERF*/ThisTok));
          $this().Tok.setKind(tok.TokenKind.identifier);
          SelectorLoc.$assignMove($this().ConsumeToken());
          return II;
        }
        return null;
      }
     case tok.TokenKind.identifier:
     case tok.TokenKind.kw_asm:
     case tok.TokenKind.kw_auto:
     case tok.TokenKind.kw_bool:
     case tok.TokenKind.kw_break:
     case tok.TokenKind.kw_case:
     case tok.TokenKind.kw_catch:
     case tok.TokenKind.kw_char:
     case tok.TokenKind.kw_class:
     case tok.TokenKind.kw_const:
     case tok.TokenKind.kw_const_cast:
     case tok.TokenKind.kw_continue:
     case tok.TokenKind.kw_default:
     case tok.TokenKind.kw_delete:
     case tok.TokenKind.kw_do:
     case tok.TokenKind.kw_double:
     case tok.TokenKind.kw_dynamic_cast:
     case tok.TokenKind.kw_else:
     case tok.TokenKind.kw_enum:
     case tok.TokenKind.kw_explicit:
     case tok.TokenKind.kw_export:
     case tok.TokenKind.kw_extern:
     case tok.TokenKind.kw_false:
     case tok.TokenKind.kw_float:
     case tok.TokenKind.kw_for:
     case tok.TokenKind.kw_friend:
     case tok.TokenKind.kw_goto:
     case tok.TokenKind.kw_if:
     case tok.TokenKind.kw_inline:
     case tok.TokenKind.kw_int:
     case tok.TokenKind.kw_long:
     case tok.TokenKind.kw_mutable:
     case tok.TokenKind.kw_namespace:
     case tok.TokenKind.kw_new:
     case tok.TokenKind.kw_operator:
     case tok.TokenKind.kw_private:
     case tok.TokenKind.kw_protected:
     case tok.TokenKind.kw_public:
     case tok.TokenKind.kw_register:
     case tok.TokenKind.kw_reinterpret_cast:
     case tok.TokenKind.kw_restrict:
     case tok.TokenKind.kw_return:
     case tok.TokenKind.kw_short:
     case tok.TokenKind.kw_signed:
     case tok.TokenKind.kw_sizeof:
     case tok.TokenKind.kw_static:
     case tok.TokenKind.kw_static_cast:
     case tok.TokenKind.kw_struct:
     case tok.TokenKind.kw_switch:
     case tok.TokenKind.kw_template:
     case tok.TokenKind.kw_this:
     case tok.TokenKind.kw_throw:
     case tok.TokenKind.kw_true:
     case tok.TokenKind.kw_try:
     case tok.TokenKind.kw_typedef:
     case tok.TokenKind.kw_typeid:
     case tok.TokenKind.kw_typename:
     case tok.TokenKind.kw_typeof:
     case tok.TokenKind.kw_union:
     case tok.TokenKind.kw_unsigned:
     case tok.TokenKind.kw_using:
     case tok.TokenKind.kw_virtual:
     case tok.TokenKind.kw_void:
     case tok.TokenKind.kw_volatile:
     case tok.TokenKind.kw_wchar_t:
     case tok.TokenKind.kw_while:
     case tok.TokenKind.kw__Bool:
     case tok.TokenKind.kw__Complex:
     case tok.TokenKind.kw___alignof:
     case tok.TokenKind.kw___auto_type:
      IdentifierInfo /*P*/ II = $this().Tok.getIdentifierInfo();
      SelectorLoc.$assignMove($this().ConsumeToken());
      return II;
    }
  }


///  objc-for-collection-in: 'in'
///
//<editor-fold defaultstate="collapsed" desc="clang::Parser::isTokIdentifier_in">
@Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseObjc.cpp", line = 1123,
   FQN="clang::Parser::isTokIdentifier_in", NM="_ZNK5clang6Parser18isTokIdentifier_inEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseObjc.cpp -nm=_ZNK5clang6Parser18isTokIdentifier_inEv")
  //</editor-fold>
  protected /*private*/ boolean isTokIdentifier_in() /*const*/ {
    // FIXME: May have to do additional look-ahead to only allow for
    // valid tokens following an 'in'; such as an identifier, unary operators,
    // '[' etc.
    return ($this().getLangOpts().ObjC2 && $this().Tok.is(tok.TokenKind.identifier)
       && $this().Tok.getIdentifierInfo() == $this().ObjCTypeQuals[ObjCTypeQual.objc_in.getValue()]);
  }


///   objc-type-name:
///     '(' objc-type-qualifiers[opt] type-name ')'
///     '(' objc-type-qualifiers[opt] ')'
///
//<editor-fold defaultstate="collapsed" desc="clang::Parser::ParseObjCTypeName">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseObjc.cpp", line = 1252,
   FQN="clang::Parser::ParseObjCTypeName", NM="_ZN5clang6Parser17ParseObjCTypeNameERNS_12ObjCDeclSpecENS_10Declarator10TheContextEPNS_16ParsedAttributesE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseObjc.cpp -nm=_ZN5clang6Parser17ParseObjCTypeNameERNS_12ObjCDeclSpecENS_10Declarator10TheContextEPNS_16ParsedAttributesE")
  //</editor-fold>
  protected /*private*/ OpaquePtr<QualType> ParseObjCTypeName(final ObjCDeclSpec /*&*/ DS, 
                   Declarator.TheContext context, 
                   ParsedAttributes /*P*/ paramAttrs) {
    BalancedDelimiterTracker T = null;
    ObjCDeclContextSwitch ObjCDC = null;
    try {
      assert (context == Declarator.TheContext.ObjCParameterContext || context == Declarator.TheContext.ObjCResultContext);
      assert ((paramAttrs != null) == (context == Declarator.TheContext.ObjCParameterContext));
      assert ($this().Tok.is(tok.TokenKind.l_paren)) : "expected (";
      
      T/*J*/= new BalancedDelimiterTracker(/*Deref*/$this(), tok.TokenKind.l_paren);
      T.consumeOpen();
      
      SourceLocation TypeStartLoc = $this().Tok.getLocation();
      ObjCDC/*J*/= new ObjCDeclContextSwitch(/*Deref*/$this());
      
      // Parse type qualifiers, in, inout, etc.
      $this().ParseObjCTypeQualifierList(DS, context);
      
      OpaquePtr<QualType> Ty/*J*/= new OpaquePtr<QualType>();
      if ($this().isTypeSpecifierQualifier() || $this().isObjCInstancetype()) {
        DeclSpec declSpec = null;
        Declarator declarator = null;
        try {
          // Parse an abstract declarator.
          declSpec/*J*/= new DeclSpec($this().AttrFactory);
          declSpec.setObjCQualifiers($AddrOf(DS));
          DeclSpecContext dsContext = DeclSpecContext.DSC_normal;
          if (context == Declarator.TheContext.ObjCResultContext) {
            dsContext = DeclSpecContext.DSC_objc_method_result;
          }
          $this().ParseSpecifierQualifierList(declSpec, AccessSpecifier.AS_none, dsContext);
          declarator/*J*/= new Declarator(declSpec, context);
          $this().ParseDeclarator(declarator);
          
          // If that's not invalid, extract a type.
          if (!declarator.isInvalidType()) {
            // Map a nullability specifier to a context-sensitive keyword attribute.
            bool$ref addedToDeclSpec = create_bool$ref(false);
            if (((DS.getObjCDeclQualifier() & ObjCDeclSpec.ObjCDeclQualifier.DQ_CSNullability) != 0)) {
              addContextSensitiveTypeNullability(/*Deref*/$this(), declarator, 
                  DS.getNullability(), 
                  DS.getNullabilityLoc(), 
                  addedToDeclSpec);
            }
            
            ActionResult<OpaquePtr<QualType> > type = $this().Actions.ActOnTypeName($this().getCurScope(), declarator);
            if (!type.isInvalid()) {
              Ty.$assignMove(type.get());
            }
            
            // If we're parsing a parameter, steal all the decl attributes
            // and add them to the decl spec.
            if (context == Declarator.TheContext.ObjCParameterContext) {
              takeDeclAttributes($Deref(paramAttrs), declarator);
            }
          }
        } finally {
          if (declarator != null) { declarator.$destroy(); }
          if (declSpec != null) { declSpec.$destroy(); }
        }
      }
      if ($this().Tok.is(tok.TokenKind.r_paren)) {
        T.consumeClose();
      } else if ($eq_SourceLocation$C($this().Tok.getLocation(), TypeStartLoc)) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          // If we didn't eat any tokens, then this isn't a type.
          $c$.clean($c$.track($this().Diag($this().Tok, diag.err_expected_type)));
          $this().SkipUntil(tok.TokenKind.r_paren, SkipUntilFlags.StopAtSemi);
        } finally {
          $c$.$destroy();
        }
      } else {
        // Otherwise, we found *something*, but didn't get a ')' in the right
        // place.  Emit an error then return what we have as the type.
        T.consumeClose();
      }
      return Ty;
    } finally {
      if (ObjCDC != null) { ObjCDC.$destroy(); }
      if (T != null) { T.$destroy(); }
    }
  }


///   objc-method-proto:
///     objc-instance-method objc-method-decl objc-method-attributes[opt]
///     objc-class-method objc-method-decl objc-method-attributes[opt]
///
///   objc-instance-method: '-'
///   objc-class-method: '+'
///
///   objc-method-attributes:         [OBJC2]
///     __attribute__((deprecated))
///
//<editor-fold defaultstate="collapsed" desc="clang::Parser::ParseObjCMethodPrototype">
@Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseObjc.cpp", line = 998,
   FQN="clang::Parser::ParseObjCMethodPrototype", NM="_ZN5clang6Parser24ParseObjCMethodPrototypeENS_3tok15ObjCKeywordKindEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseObjc.cpp -nm=_ZN5clang6Parser24ParseObjCMethodPrototypeENS_3tok15ObjCKeywordKindEb")
  //</editor-fold>
  protected /*private*/ Decl /*P*/ ParseObjCMethodPrototype() {
    return $this().ParseObjCMethodPrototype(tok.ObjCKeywordKind.objc_not_keyword, 
                          true);
  }
  protected /*private*/ Decl /*P*/ ParseObjCMethodPrototype(/*tok.ObjCKeywordKind*/char MethodImplKind/*= tok::objc_not_keyword*/) {
    return $this().ParseObjCMethodPrototype(MethodImplKind, 
                          true);
  }
  protected /*private*/ Decl /*P*/ ParseObjCMethodPrototype(/*tok.ObjCKeywordKind*/char MethodImplKind/*= tok::objc_not_keyword*/, 
                          boolean MethodDefinition/*= true*/) {
    assert ($this().Tok.isOneOf(tok.TokenKind.minus, tok.TokenKind.plus)) : "expected +/-";
    
    /*tok.TokenKind*/char methodType = $this().Tok.getKind();
    SourceLocation mLoc = $this().ConsumeToken();
    Decl /*P*/ MDecl = $this().ParseObjCMethodDecl(new SourceLocation(mLoc), methodType, MethodImplKind, 
        MethodDefinition);
    // Since this rule is used for both method declarations and definitions,
    // the caller is (optionally) responsible for consuming the ';'.
    return MDecl;
  }


///   objc-method-decl:
///     objc-selector
///     objc-keyword-selector objc-parmlist[opt]
///     objc-type-name objc-selector
///     objc-type-name objc-keyword-selector objc-parmlist[opt]
///
///   objc-keyword-selector:
///     objc-keyword-decl
///     objc-keyword-selector objc-keyword-decl
///
///   objc-keyword-decl:
///     objc-selector ':' objc-type-name objc-keyword-attributes[opt] identifier
///     objc-selector ':' objc-keyword-attributes[opt] identifier
///     ':' objc-type-name objc-keyword-attributes[opt] identifier
///     ':' objc-keyword-attributes[opt] identifier
///
///   objc-parmlist:
///     objc-parms objc-ellipsis[opt]
///
///   objc-parms:
///     objc-parms , parameter-declaration
///
///   objc-ellipsis:
///     , ...
///
///   objc-keyword-attributes:         [OBJC2]
///     __attribute__((unused))
///
//<editor-fold defaultstate="collapsed" desc="clang::Parser::ParseObjCMethodDecl">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseObjc.cpp", line = 1346,
   FQN="clang::Parser::ParseObjCMethodDecl", NM="_ZN5clang6Parser19ParseObjCMethodDeclENS_14SourceLocationENS_3tok9TokenKindENS2_15ObjCKeywordKindEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseObjc.cpp -nm=_ZN5clang6Parser19ParseObjCMethodDeclENS_14SourceLocationENS_3tok9TokenKindENS2_15ObjCKeywordKindEb")
  //</editor-fold>
  protected /*private*/ Decl /*P*/ ParseObjCMethodDecl(SourceLocation mLoc, 
                     /*tok.TokenKind*/char mType) {
    return $this().ParseObjCMethodDecl(mLoc, 
                     mType, 
                     tok.ObjCKeywordKind.objc_not_keyword, 
                     true);
  }
  protected /*private*/ Decl /*P*/ ParseObjCMethodDecl(SourceLocation mLoc, 
                     /*tok.TokenKind*/char mType, 
                     /*tok.ObjCKeywordKind*/char MethodImplKind/*= tok::objc_not_keyword*/) {
    return $this().ParseObjCMethodDecl(mLoc, 
                     mType, 
                     MethodImplKind, 
                     true);
  }
  protected /*private*/ Decl /*P*/ ParseObjCMethodDecl(SourceLocation mLoc, 
                     /*tok.TokenKind*/char mType, 
                     /*tok.ObjCKeywordKind*/char MethodImplKind/*= tok::objc_not_keyword*/, 
                     boolean MethodDefinition/*= true*/) {
    ParsingDeclRAIIObject PD = null;
    ParsedAttributes methodAttrs = null;
    ParseScope PrototypeScope = null;
    AttributePool allParamAttrs = null;
    try {
      PD/*J*/= new ParsingDeclRAIIObject(/*Deref*/$this(), ParsingDeclRAIIObject.NoParent_t.NoParent);
      if ($this().Tok.is(tok.TokenKind.code_completion)) {
        $this().Actions.CodeCompleteObjCMethodDecl($this().getCurScope(), mType == tok.TokenKind.minus, 
            /*ReturnType=*/ new OpaquePtr<QualType>(null));
        $this().cutOffParsing();
        return null;
      }
      
      // Parse the return type if present.
      OpaquePtr<QualType> ReturnType/*J*/= new OpaquePtr<QualType>();
      ObjCDeclSpec DSRet/*J*/= new ObjCDeclSpec();
      if ($this().Tok.is(tok.TokenKind.l_paren)) {
        ReturnType.$assignMove($this().ParseObjCTypeName(DSRet, Declarator.TheContext.ObjCResultContext, 
                (ParsedAttributes /*P*/ )null));
      }
      
      // If attributes exist before the method, parse them.
      methodAttrs/*J*/= new ParsedAttributes($this().AttrFactory);
      if ($this().getLangOpts().ObjC2) {
        $this().MaybeParseGNUAttributes(methodAttrs);
      }
      if ($this().Tok.is(tok.TokenKind.code_completion)) {
        $this().Actions.CodeCompleteObjCMethodDecl($this().getCurScope(), mType == tok.TokenKind.minus, 
            new OpaquePtr<QualType>(ReturnType));
        $this().cutOffParsing();
        return null;
      }
      
      // Now parse the selector.
      SourceLocation selLoc/*J*/= new SourceLocation();
      IdentifierInfo /*P*/ SelIdent = $this().ParseObjCSelectorPiece(selLoc);
      
      // An unnamed colon is valid.
      if (!(SelIdent != null) && $this().Tok.isNot(tok.TokenKind.colon)) { // missing selector name.
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_DiagnosticBuilder$C_SourceRange($c$.track($this().Diag($this().Tok, diag.err_expected_selector_for_method)), 
              new SourceRange(/*NO_COPY*/mLoc, $this().Tok.getLocation())));
          // Skip until we get a ; or @.
          $this().SkipUntil(tok.TokenKind.at, $bitor_SkipUntilFlags(/*KEEP_ENUM*/SkipUntilFlags.StopAtSemi, /*KEEP_ENUM*/SkipUntilFlags.StopBeforeMatch));
          return null;
        } finally {
          $c$.$destroy();
        }
      }
      
      SmallVector<DeclaratorChunk.ParamInfo> CParamInfo/*J*/= new SmallVector<DeclaratorChunk.ParamInfo>(8, new DeclaratorChunk.ParamInfo());
      if ($this().Tok.isNot(tok.TokenKind.colon)) {
        // If attributes exist after the method, parse them.
        if ($this().getLangOpts().ObjC2) {
          $this().MaybeParseGNUAttributes(methodAttrs);
        }
        
        Selector Sel = $this().PP.getSelectorTable().getNullarySelector(SelIdent);
        Decl /*P*/ Result = $this().Actions.ActOnMethodDeclaration($this().getCurScope(), new SourceLocation(mLoc), $this().Tok.getLocation(), 
            mType, DSRet, new OpaquePtr<QualType>(ReturnType), 
            new ArrayRef<SourceLocation>(selLoc), new Selector(Sel), create_type$ptr(), 
            CParamInfo.data(), CParamInfo.size(), 
            methodAttrs.getList(), MethodImplKind, 
            false, MethodDefinition);
        PD.complete(Result);
        return Result;
      }
      
      SmallVector<IdentifierInfo /*P*/> KeyIdents/*J*/= new SmallVector<IdentifierInfo /*P*/>(12, (IdentifierInfo /*P*/)null);
      SmallVector<SourceLocation> KeyLocs/*J*/= new SmallVector<SourceLocation>(12, new SourceLocation());
      SmallVector<Sema.ObjCArgInfo> ArgInfos/*J*/= new SmallVector<Sema.ObjCArgInfo>(12, /*new Sema.ObjCArgInfo() PERF:*/(Sema.ObjCArgInfo)null);
      PrototypeScope/*J*/= new ParseScope($this(), Scope.ScopeFlags.FunctionPrototypeScope
             | Scope.ScopeFlags.FunctionDeclarationScope | Scope.ScopeFlags.DeclScope);
      
      allParamAttrs/*J*/= new AttributePool($this().AttrFactory);
      while (true) {
        ParsedAttributes paramAttrs = null;
        try {
          paramAttrs/*J*/= new ParsedAttributes($this().AttrFactory);
          Sema.ObjCArgInfo ArgInfo/*J*/= new Sema.ObjCArgInfo();
          
          // Each iteration parses a single keyword argument.
          if ($this().ExpectAndConsume(tok.TokenKind.colon)) {
            break;
          }
          
          ArgInfo.Type.$assignMove(new OpaquePtr<QualType>(null));
          if ($this().Tok.is(tok.TokenKind.l_paren)) { // Parse the argument type if present.
            ArgInfo.Type.$assignMove($this().ParseObjCTypeName(ArgInfo.DeclSpec, 
                    Declarator.TheContext.ObjCParameterContext, 
                    $AddrOf(paramAttrs)));
          }
          
          // If attributes exist before the argument name, parse them.
          // Regardless, collect all the attributes we've parsed so far.
          ArgInfo.ArgAttrs = null;
          if ($this().getLangOpts().ObjC2) {
            $this().MaybeParseGNUAttributes(paramAttrs);
            ArgInfo.ArgAttrs = paramAttrs.getList();
          }
          
          // Code completion for the next piece of the selector.
          if ($this().Tok.is(tok.TokenKind.code_completion)) {
            KeyIdents.push_back(SelIdent);
            $this().Actions.CodeCompleteObjCMethodDeclSelector($this().getCurScope(), 
                mType == tok.TokenKind.minus, 
                /*AtParameterName=*/ true, 
                new OpaquePtr<QualType>(ReturnType), new ArrayRef<IdentifierInfo /*P*/ >(KeyIdents));
            $this().cutOffParsing();
            return null;
          }
          if ($this().Tok.isNot(tok.TokenKind.identifier)) {
            JavaCleaner $c$ = $createJavaCleaner();
            try {
              $c$.clean($out_DiagnosticBuilder$C_TokenKind($c$.track($this().Diag($this().Tok, diag.err_expected)), 
                  tok.TokenKind.identifier)); // missing argument name.
              break;
            } finally {
              $c$.$destroy();
            }
          }
          
          ArgInfo.Name = $this().Tok.getIdentifierInfo();
          ArgInfo.NameLoc.$assignMove($this().Tok.getLocation());
          $this().ConsumeToken(); // Eat the identifier.
          
          ArgInfos.push_back(ArgInfo);
          KeyIdents.push_back(SelIdent);
          KeyLocs.push_back(selLoc);
          
          // Make sure the attributes persist.
          allParamAttrs.takeAllFrom(paramAttrs.getPool());
          
          // Code completion for the next piece of the selector.
          if ($this().Tok.is(tok.TokenKind.code_completion)) {
            $this().Actions.CodeCompleteObjCMethodDeclSelector($this().getCurScope(), 
                mType == tok.TokenKind.minus, 
                /*AtParameterName=*/ false, 
                new OpaquePtr<QualType>(ReturnType), new ArrayRef<IdentifierInfo /*P*/ >(KeyIdents));
            $this().cutOffParsing();
            return null;
          }
          
          // Check for another keyword selector.
          SelIdent = $this().ParseObjCSelectorPiece(selLoc);
          if (!(SelIdent != null) && $this().Tok.isNot(tok.TokenKind.colon)) {
            break;
          }
          if (!(SelIdent != null)) {
            SourceLocation ColonLoc = $this().Tok.getLocation();
            if ($eq_SourceLocation$C($this().PP.getLocForEndOfToken(/*NO_COPY*/ArgInfo.NameLoc), ColonLoc)) {
              JavaCleaner $c$ = $createJavaCleaner();
              try {
                $c$.clean($out_DiagnosticBuilder$C_IdentifierInfo$C$P($c$.track($this().Diag(new SourceLocation(ArgInfo.NameLoc), diag.warn_missing_selector_name)), ArgInfo.Name));
                $c$.clean($out_DiagnosticBuilder$C_IdentifierInfo$C$P($c$.track($this().Diag(new SourceLocation(ArgInfo.NameLoc), diag.note_missing_selector_name)), ArgInfo.Name));
                $c$.clean($out_DiagnosticBuilder$C_IdentifierInfo$C$P($c$.track($this().Diag(new SourceLocation(ColonLoc), diag.note_force_empty_selector_name)), ArgInfo.Name));
              } finally {
                $c$.$destroy();
              }
            }
          }
        } finally {
          if (paramAttrs != null) { paramAttrs.$destroy(); }
        }
        // We have a selector or a colon, continue parsing.
      }
      
      boolean isVariadic = false;
      boolean cStyleParamWarned = false;
      // Parse the (optional) parameter list.
      while ($this().Tok.is(tok.TokenKind.comma)) {
        DeclSpec DS = null;
        Declarator ParmDecl = null;
        try {
          $this().ConsumeToken();
          if ($this().Tok.is(tok.TokenKind.ellipsis)) {
            isVariadic = true;
            $this().ConsumeToken();
            break;
          }
          if (!cStyleParamWarned) {
            JavaCleaner $c$ = $createJavaCleaner();
            try {
              $c$.clean($c$.track($this().Diag($this().Tok, diag.warn_cstyle_param)));
              cStyleParamWarned = true;
            } finally {
              $c$.$destroy();
            }
          }
          DS/*J*/= new DeclSpec($this().AttrFactory);
          $this().ParseDeclarationSpecifiers(DS);
          // Parse the declarator.
          ParmDecl/*J*/= new Declarator(DS, Declarator.TheContext.PrototypeContext);
          $this().ParseDeclarator(ParmDecl);
          IdentifierInfo /*P*/ ParmII = ParmDecl.getIdentifier();
          Decl /*P*/ Param = $this().Actions.ActOnParamDeclarator($this().getCurScope(), ParmDecl);
          CParamInfo.push_back(new DeclaratorChunk.ParamInfo(ParmII, 
                  ParmDecl.getIdentifierLoc(), 
                  Param, 
                  (SmallVectorToken /*P*/)null));
        } finally {
          if (ParmDecl != null) { ParmDecl.$destroy(); }
          if (DS != null) { DS.$destroy(); }
        }
      }
      
      // FIXME: Add support for optional parameter list...
      // If attributes exist after the method, parse them.
      if ($this().getLangOpts().ObjC2) {
        $this().MaybeParseGNUAttributes(methodAttrs);
      }
      if (KeyIdents.size() == 0) {
        return null;
      }
      
      Selector Sel = $this().PP.getSelectorTable().getSelector(KeyIdents.size(), 
          $AddrOf(KeyIdents.data()));
      Decl /*P*/ Result = $this().Actions.ActOnMethodDeclaration($this().getCurScope(), new SourceLocation(mLoc), $this().Tok.getLocation(), 
          mType, DSRet, new OpaquePtr<QualType>(ReturnType), 
          new ArrayRef<SourceLocation>(KeyLocs), new Selector(Sel), $AddrOf(ArgInfos.begin()), 
          CParamInfo.data(), CParamInfo.size(), 
          methodAttrs.getList(), 
          MethodImplKind, isVariadic, MethodDefinition);
      
      PD.complete(Result);
      return Result;
    } finally {
      if (allParamAttrs != null) { allParamAttrs.$destroy(); }
      if (PrototypeScope != null) { PrototypeScope.$destroy(); }
      if (methodAttrs != null) { methodAttrs.$destroy(); }
      if (PD != null) { PD.$destroy(); }
    }
  }


///   Parse property attribute declarations.
///
///   property-attr-decl: '(' property-attrlist ')'
///   property-attrlist:
///     property-attribute
///     property-attrlist ',' property-attribute
///   property-attribute:
///     getter '=' identifier
///     setter '=' identifier ':'
///     readonly
///     readwrite
///     assign
///     retain
///     copy
///     nonatomic
///     atomic
///     strong
///     weak
///     unsafe_unretained
///     nonnull
///     nullable
///     null_unspecified
///     null_resettable
///     class
///
//<editor-fold defaultstate="collapsed" desc="clang::Parser::ParseObjCPropertyAttribute">
@Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseObjc.cpp", line = 857,
   FQN="clang::Parser::ParseObjCPropertyAttribute", NM="_ZN5clang6Parser26ParseObjCPropertyAttributeERNS_12ObjCDeclSpecE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseObjc.cpp -nm=_ZN5clang6Parser26ParseObjCPropertyAttributeERNS_12ObjCDeclSpecE")
  //</editor-fold>
  protected /*private*/ void ParseObjCPropertyAttribute(final ObjCDeclSpec /*&*/ DS) {
    BalancedDelimiterTracker T = null;
    try {
      assert ($this().Tok.getKind() == tok.TokenKind.l_paren);
      T/*J*/= new BalancedDelimiterTracker(/*Deref*/$this(), tok.TokenKind.l_paren);
      T.consumeOpen();
      while (true) {
        if ($this().Tok.is(tok.TokenKind.code_completion)) {
          $this().Actions.CodeCompleteObjCPropertyFlags($this().getCurScope(), DS);
          $this().cutOffParsing();
          return;
        }
        /*const*/ IdentifierInfo /*P*/ II = $this().Tok.getIdentifierInfo();
        
        // If this is not an identifier at all, bail out early.
        if (!(II != null)) {
          T.consumeClose();
          return;
        }
        
        SourceLocation AttrName = $this().ConsumeToken(); // consume last attribute name
        if (II.isStr(/*KEEP_STR*/"readonly")) {
          DS.setPropertyAttributes(ObjCDeclSpec.ObjCPropertyAttributeKind.DQ_PR_readonly);
        } else if (II.isStr(/*KEEP_STR*/"assign")) {
          DS.setPropertyAttributes(ObjCDeclSpec.ObjCPropertyAttributeKind.DQ_PR_assign);
        } else if (II.isStr(/*KEEP_STR*/"unsafe_unretained")) {
          DS.setPropertyAttributes(ObjCDeclSpec.ObjCPropertyAttributeKind.DQ_PR_unsafe_unretained);
        } else if (II.isStr(/*KEEP_STR*/"readwrite")) {
          DS.setPropertyAttributes(ObjCDeclSpec.ObjCPropertyAttributeKind.DQ_PR_readwrite);
        } else if (II.isStr(/*KEEP_STR*/"retain")) {
          DS.setPropertyAttributes(ObjCDeclSpec.ObjCPropertyAttributeKind.DQ_PR_retain);
        } else if (II.isStr(/*KEEP_STR*/"strong")) {
          DS.setPropertyAttributes(ObjCDeclSpec.ObjCPropertyAttributeKind.DQ_PR_strong);
        } else if (II.isStr(/*KEEP_STR*/"copy")) {
          DS.setPropertyAttributes(ObjCDeclSpec.ObjCPropertyAttributeKind.DQ_PR_copy);
        } else if (II.isStr(/*KEEP_STR*/"nonatomic")) {
          DS.setPropertyAttributes(ObjCDeclSpec.ObjCPropertyAttributeKind.DQ_PR_nonatomic);
        } else if (II.isStr(/*KEEP_STR*/"atomic")) {
          DS.setPropertyAttributes(ObjCDeclSpec.ObjCPropertyAttributeKind.DQ_PR_atomic);
        } else if (II.isStr(/*KEEP_STR*/"weak")) {
          DS.setPropertyAttributes(ObjCDeclSpec.ObjCPropertyAttributeKind.DQ_PR_weak);
        } else if (II.isStr(/*KEEP_STR*/"getter") || II.isStr(/*KEEP_STR*/"setter")) {
          boolean IsSetter = II.getNameStart().$at(0) == $$s;
          
          // getter/setter require extra treatment.
          /*uint*/int DiagID = IsSetter ? diag.err_objc_expected_equal_for_setter : diag.err_objc_expected_equal_for_getter;
          if ($this().ExpectAndConsume(tok.TokenKind.equal, DiagID)) {
            $this().SkipUntil(tok.TokenKind.r_paren, SkipUntilFlags.StopAtSemi);
            return;
          }
          if ($this().Tok.is(tok.TokenKind.code_completion)) {
            if (IsSetter) {
              $this().Actions.CodeCompleteObjCPropertySetter($this().getCurScope());
            } else {
              $this().Actions.CodeCompleteObjCPropertyGetter($this().getCurScope());
            }
            $this().cutOffParsing();
            return;
          }
          
          SourceLocation SelLoc/*J*/= new SourceLocation();
          IdentifierInfo /*P*/ SelIdent = $this().ParseObjCSelectorPiece(SelLoc);
          if (!(SelIdent != null)) {
            JavaCleaner $c$ = $createJavaCleaner();
            try {
              $c$.clean($out$Same2Bool($c$.track($this().Diag($this().Tok, diag.err_objc_expected_selector_for_getter_setter)), 
                  IsSetter));
              $this().SkipUntil(tok.TokenKind.r_paren, SkipUntilFlags.StopAtSemi);
              return;
            } finally {
              $c$.$destroy();
            }
          }
          if (IsSetter) {
            DS.setPropertyAttributes(ObjCDeclSpec.ObjCPropertyAttributeKind.DQ_PR_setter);
            DS.setSetterName(SelIdent);
            if ($this().ExpectAndConsume(tok.TokenKind.colon, 
                diag.err_expected_colon_after_setter_name)) {
              $this().SkipUntil(tok.TokenKind.r_paren, SkipUntilFlags.StopAtSemi);
              return;
            }
          } else {
            DS.setPropertyAttributes(ObjCDeclSpec.ObjCPropertyAttributeKind.DQ_PR_getter);
            DS.setGetterName(SelIdent);
          }
        } else if (II.isStr(/*KEEP_STR*/"nonnull")) {
          if (((DS.getPropertyAttributes() & ObjCDeclSpec.ObjCPropertyAttributeKind.DQ_PR_nullability) != 0)) {
            diagnoseRedundantPropertyNullability(/*Deref*/$this(), DS, 
                NullabilityKind.NonNull, 
                $this().Tok.getLocation());
          }
          DS.setPropertyAttributes(ObjCDeclSpec.ObjCPropertyAttributeKind.DQ_PR_nullability);
          DS.setNullability($this().Tok.getLocation(), NullabilityKind.NonNull);
        } else if (II.isStr(/*KEEP_STR*/"nullable")) {
          if (((DS.getPropertyAttributes() & ObjCDeclSpec.ObjCPropertyAttributeKind.DQ_PR_nullability) != 0)) {
            diagnoseRedundantPropertyNullability(/*Deref*/$this(), DS, 
                NullabilityKind.Nullable, 
                $this().Tok.getLocation());
          }
          DS.setPropertyAttributes(ObjCDeclSpec.ObjCPropertyAttributeKind.DQ_PR_nullability);
          DS.setNullability($this().Tok.getLocation(), NullabilityKind.Nullable);
        } else if (II.isStr(/*KEEP_STR*/"null_unspecified")) {
          if (((DS.getPropertyAttributes() & ObjCDeclSpec.ObjCPropertyAttributeKind.DQ_PR_nullability) != 0)) {
            diagnoseRedundantPropertyNullability(/*Deref*/$this(), DS, 
                NullabilityKind.Unspecified, 
                $this().Tok.getLocation());
          }
          DS.setPropertyAttributes(ObjCDeclSpec.ObjCPropertyAttributeKind.DQ_PR_nullability);
          DS.setNullability($this().Tok.getLocation(), NullabilityKind.Unspecified);
        } else if (II.isStr(/*KEEP_STR*/"null_resettable")) {
          if (((DS.getPropertyAttributes() & ObjCDeclSpec.ObjCPropertyAttributeKind.DQ_PR_nullability) != 0)) {
            diagnoseRedundantPropertyNullability(/*Deref*/$this(), DS, 
                NullabilityKind.Unspecified, 
                $this().Tok.getLocation());
          }
          DS.setPropertyAttributes(ObjCDeclSpec.ObjCPropertyAttributeKind.DQ_PR_nullability);
          DS.setNullability($this().Tok.getLocation(), NullabilityKind.Unspecified);
          
          // Also set the null_resettable bit.
          DS.setPropertyAttributes(ObjCDeclSpec.ObjCPropertyAttributeKind.DQ_PR_null_resettable);
        } else if (II.isStr(/*KEEP_STR*/"class")) {
          DS.setPropertyAttributes(ObjCDeclSpec.ObjCPropertyAttributeKind.DQ_PR_class);
        } else {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            $c$.clean($out_DiagnosticBuilder$C_IdentifierInfo$C$P($c$.track($this().Diag(new SourceLocation(AttrName), diag.err_objc_expected_property_attr)), II));
            $this().SkipUntil(tok.TokenKind.r_paren, SkipUntilFlags.StopAtSemi);
            return;
          } finally {
            $c$.$destroy();
          }
        }
        if ($this().Tok.isNot(tok.TokenKind.comma)) {
          break;
        }
        
        $this().ConsumeToken();
      }
      
      T.consumeClose();
    } finally {
      if (T != null) { T.$destroy(); }
    }
  }


///   objc-method-def: objc-method-proto ';'[opt] '{' body '}'
///
//<editor-fold defaultstate="collapsed" desc="clang::Parser::ParseObjCMethodDefinition">
@Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseObjc.cpp", line = 2702,
   FQN="clang::Parser::ParseObjCMethodDefinition", NM="_ZN5clang6Parser25ParseObjCMethodDefinitionEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseObjc.cpp -nm=_ZN5clang6Parser25ParseObjCMethodDefinitionEv")
  //</editor-fold>
  protected /*private*/ Decl /*P*/ ParseObjCMethodDefinition() {
    PrettyDeclStackTraceEntry CrashInfo = null;
    try {
      Decl /*P*/ MDecl = $this().ParseObjCMethodPrototype();
      
      CrashInfo/*J*/= new PrettyDeclStackTraceEntry($this().Actions, MDecl, $this().Tok.getLocation(), 
          $("parsing Objective-C method"));
      
      // parse optional ';'
      if ($this().Tok.is(tok.TokenKind.semi)) {
        if (($this().CurParsedObjCImpl != null)) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            $c$.clean($out_DiagnosticBuilder$C_FixItHint$C($c$.track($this().Diag($this().Tok, diag.warn_semicolon_before_method_body)), 
                FixItHint.CreateRemoval(new SourceRange($this().Tok.getLocation()))));
          } finally {
            $c$.$destroy();
          }
        }
        $this().ConsumeToken();
      }
      
      // We should have an opening brace now.
      if ($this().Tok.isNot(tok.TokenKind.l_brace)) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($c$.track($this().Diag($this().Tok, diag.err_expected_method_body)));
          
          // Skip over garbage, until we get to '{'.  Don't eat the '{'.
          $this().SkipUntil(tok.TokenKind.l_brace, $bitor_SkipUntilFlags(/*KEEP_ENUM*/SkipUntilFlags.StopAtSemi, /*KEEP_ENUM*/SkipUntilFlags.StopBeforeMatch));
          
          // If we didn't find the '{', bail out.
          if ($this().Tok.isNot(tok.TokenKind.l_brace)) {
            return null;
          }
        } finally {
          $c$.$destroy();
        }
      }
      if (!(MDecl != null)) {
        $this().ConsumeBrace();
        $this().SkipUntil(tok.TokenKind.r_brace);
        return null;
      }
      
      // Allow the rest of sema to find private method decl implementations.
      $this().Actions.AddAnyMethodToGlobalPool(MDecl);
      assert (($this().CurParsedObjCImpl != null)) : "ParseObjCMethodDefinition - Method out of @implementation";
      // Consume the tokens and store them for later parsing.
      $this().StashAwayMethodOrFunctionBodyTokens(MDecl);
      return MDecl;
    } finally {
      if (CrashInfo != null) { CrashInfo.$destroy(); }
    }
  }

// ^{...}

//===--------------------------------------------------------------------===//
// Objective-C Expressions
//<editor-fold defaultstate="collapsed" desc="clang::Parser::ParseObjCAtExpression">
@Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseObjc.cpp", line = 2783,
   FQN="clang::Parser::ParseObjCAtExpression", NM="_ZN5clang6Parser21ParseObjCAtExpressionENS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseObjc.cpp -nm=_ZN5clang6Parser21ParseObjCAtExpressionENS_14SourceLocationE")
  //</editor-fold>
  protected /*private*/ ActionResultTTrue<Expr /*P*/ > ParseObjCAtExpression(SourceLocation AtLoc) {
    switch ($this().Tok.getKind()) {
     case tok.TokenKind.code_completion:
      $this().Actions.CodeCompleteObjCAtExpression($this().getCurScope());
      $this().cutOffParsing();
      return ExprError();
     case tok.TokenKind.minus:
     case tok.TokenKind.plus:
      {
        /*tok.TokenKind*/char Kind = $this().Tok.getKind();
        SourceLocation OpLoc = $this().ConsumeToken();
        if (!$this().Tok.is(tok.TokenKind.numeric_constant)) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            /*const*/char$ptr/*char P*/ Symbol = null;
            switch (Kind) {
             case tok.TokenKind.minus:
              Symbol = $tryClone($MINUS);
              break;
             case tok.TokenKind.plus:
              Symbol = $tryClone($PLUS);
              break;
             default:
              throw new llvm_unreachable("missing unary operator case");
            }
            $c$.clean($out_DiagnosticBuilder$C_char$ptr$C($c$.track($this().Diag($this().Tok, diag.err_nsnumber_nonliteral_unary)), 
                Symbol));
            return ExprError();
          } finally {
            $c$.$destroy();
          }
        }
        
        ActionResultTTrue<Expr /*P*/ > Lit/*J*/= $this().Actions.ActOnNumericConstant($this().Tok);
        if (Lit.isInvalid()) {
          return Lit;
        }
        $this().ConsumeToken(); // Consume the literal token.
        
        Lit.$assignMove($this().Actions.ActOnUnaryOp($this().getCurScope(), new SourceLocation(OpLoc), Kind, Lit.get()));
        if (Lit.isInvalid()) {
          return Lit;
        }
        
        return $this().ParsePostfixExpressionSuffix($this().Actions.BuildObjCNumericLiteral(new SourceLocation(AtLoc), Lit.get()));
      }
     case tok.TokenKind.string_literal: // primary-expression: string-literal
     case tok.TokenKind.wide_string_literal:
      return $this().ParsePostfixExpressionSuffix($this().ParseObjCStringLiteral(new SourceLocation(AtLoc)));
     case tok.TokenKind.char_constant:
      return $this().ParsePostfixExpressionSuffix($this().ParseObjCCharacterLiteral(new SourceLocation(AtLoc)));
     case tok.TokenKind.numeric_constant:
      return $this().ParsePostfixExpressionSuffix($this().ParseObjCNumericLiteral(new SourceLocation(AtLoc)));
     case tok.TokenKind.kw_true: // Objective-C++, etc.
     case tok.TokenKind.kw___objc_yes: // c/c++/objc/objc++ __objc_yes
      return $this().ParsePostfixExpressionSuffix($this().ParseObjCBooleanLiteral(new SourceLocation(AtLoc), true));
     case tok.TokenKind.kw_false: // Objective-C++, etc.
     case tok.TokenKind.kw___objc_no: // c/c++/objc/objc++ __objc_no
      return $this().ParsePostfixExpressionSuffix($this().ParseObjCBooleanLiteral(new SourceLocation(AtLoc), false));
     case tok.TokenKind.l_square:
      // Objective-C array literal
      return $this().ParsePostfixExpressionSuffix($this().ParseObjCArrayLiteral(new SourceLocation(AtLoc)));
     case tok.TokenKind.l_brace:
      // Objective-C dictionary literal
      return $this().ParsePostfixExpressionSuffix($this().ParseObjCDictionaryLiteral(new SourceLocation(AtLoc)));
     case tok.TokenKind.l_paren:
      // Objective-C boxed expression
      return $this().ParsePostfixExpressionSuffix($this().ParseObjCBoxedExpr(new SourceLocation(AtLoc)));
     default:
      if ($this().Tok.getIdentifierInfo() == null) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          return $c$.clean(ExprError($c$.track($this().Diag(new SourceLocation(AtLoc), diag.err_unexpected_at))));
        } finally {
          $c$.$destroy();
        }
      }
      switch ($this().Tok.getIdentifierInfo().getObjCKeywordID()) {
       case tok.ObjCKeywordKind.objc_encode:
        return $this().ParsePostfixExpressionSuffix($this().ParseObjCEncodeExpression(new SourceLocation(AtLoc)));
       case tok.ObjCKeywordKind.objc_protocol:
        return $this().ParsePostfixExpressionSuffix($this().ParseObjCProtocolExpression(new SourceLocation(AtLoc)));
       case tok.ObjCKeywordKind.objc_selector:
        return $this().ParsePostfixExpressionSuffix($this().ParseObjCSelectorExpression(new SourceLocation(AtLoc)));
       case tok.ObjCKeywordKind.objc_available:
        return $this().ParseAvailabilityCheckExpr(new SourceLocation(AtLoc));
       default:
        {
          /*const*/char$ptr/*char P*/ str = null;
          if ($this().GetLookAheadToken(1).is(tok.TokenKind.l_brace)) {
            /*char*/byte ch = $this().Tok.getIdentifierInfo().getNameStart().$at(0);
            str = $tryClone(ch == $$t ? $try : (ch == $$f ? $("finally") : (ch == $$a ? $("autoreleasepool") : null)));
          }
          if ((str != null)) {
            JavaCleaner $c$ = $createJavaCleaner();
            try {
              SourceLocation kwLoc = $this().Tok.getLocation();
              return $c$.clean(ExprError($out_DiagnosticBuilder$C_FixItHint$C($c$.track($this().Diag(new SourceLocation(AtLoc), diag.err_unexpected_at)), 
                      FixItHint.CreateReplacement(new SourceRange(/*NO_COPY*/kwLoc), new StringRef(str)))));
            } finally {
              $c$.$destroy();
            }
          } else {
            JavaCleaner $c$ = $createJavaCleaner();
            try {
              return $c$.clean(ExprError($c$.track($this().Diag(new SourceLocation(AtLoc), diag.err_unexpected_at))));
            } finally {
              $c$.$destroy();
            }
          }
        }
      }
    }
  }

//<editor-fold defaultstate="collapsed" desc="clang::Parser::ParseObjCStringLiteral">
@Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseObjc.cpp", line = 3324,
   FQN="clang::Parser::ParseObjCStringLiteral", NM="_ZN5clang6Parser22ParseObjCStringLiteralENS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseObjc.cpp -nm=_ZN5clang6Parser22ParseObjCStringLiteralENS_14SourceLocationE")
  //</editor-fold>
  protected /*private*/ ActionResultTTrue<Expr /*P*/ > ParseObjCStringLiteral(SourceLocation AtLoc) {
    ActionResultTTrue<Expr /*P*/ > Res/*J*/= $this().ParseStringLiteralExpression();
    if (Res.isInvalid()) {
      return Res;
    }
    
    // @"foo" @"bar" is a valid concatenated string.  Eat any subsequent string
    // expressions.  At this point, we know that the only valid thing that starts
    // with '@' is an @"".
    SmallVector<SourceLocation> AtLocs/*J*/= new SmallVector<SourceLocation>(4, new SourceLocation());
    SmallVector<Expr /*P*/ > AtStrings/*J*/= new SmallVector<Expr /*P*/ >(12, (Expr /*P*/ )null);
    AtLocs.push_back(AtLoc);
    AtStrings.push_back(Res.get());
    while ($this().Tok.is(tok.TokenKind.at)) {
      AtLocs.push_back($this().ConsumeToken()); // eat the @.
      
      // Invalid unless there is a string literal.
      if (!$this().isTokenStringLiteral()) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          return $c$.clean(ExprError($c$.track($this().Diag($this().Tok, diag.err_objc_concat_string))));
        } finally {
          $c$.$destroy();
        }
      }
      
      ActionResultTTrue<Expr /*P*/ > Lit/*J*/= $this().ParseStringLiteralExpression();
      if (Lit.isInvalid()) {
        return Lit;
      }
      
      AtStrings.push_back(Lit.get());
    }
    
    return $this().Actions.ParseObjCStringLiteral(AtLocs.data(), new ArrayRef<Expr /*P*/ >(AtStrings));
  }


/// ParseObjCCharacterLiteral -
/// objc-scalar-literal : '@' character-literal
///                        ;
//<editor-fold defaultstate="collapsed" desc="clang::Parser::ParseObjCCharacterLiteral">
@Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseObjc.cpp", line = 3367,
   FQN="clang::Parser::ParseObjCCharacterLiteral", NM="_ZN5clang6Parser25ParseObjCCharacterLiteralENS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseObjc.cpp -nm=_ZN5clang6Parser25ParseObjCCharacterLiteralENS_14SourceLocationE")
  //</editor-fold>
  protected /*private*/ ActionResultTTrue<Expr /*P*/ > ParseObjCCharacterLiteral(SourceLocation AtLoc) {
    ActionResultTTrue<Expr /*P*/ > Lit/*J*/= $this().Actions.ActOnCharacterConstant($this().Tok);
    if (Lit.isInvalid()) {
      return Lit;
    }
    $this().ConsumeToken(); // Consume the literal token.
    return $this().Actions.BuildObjCNumericLiteral(new SourceLocation(AtLoc), Lit.get());
  }


/// ParseObjCNumericLiteral -
/// objc-scalar-literal : '@' scalar-literal
///                        ;
/// scalar-literal : | numeric-constant			/* any numeric constant. */
///                    ;
//<editor-fold defaultstate="collapsed" desc="clang::Parser::ParseObjCNumericLiteral">
@Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseObjc.cpp", line = 3381,
   FQN="clang::Parser::ParseObjCNumericLiteral", NM="_ZN5clang6Parser23ParseObjCNumericLiteralENS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseObjc.cpp -nm=_ZN5clang6Parser23ParseObjCNumericLiteralENS_14SourceLocationE")
  //</editor-fold>
  protected /*private*/ ActionResultTTrue<Expr /*P*/ > ParseObjCNumericLiteral(SourceLocation AtLoc) {
    ActionResultTTrue<Expr /*P*/ > Lit/*J*/= $this().Actions.ActOnNumericConstant($this().Tok);
    if (Lit.isInvalid()) {
      return Lit;
    }
    $this().ConsumeToken(); // Consume the literal token.
    return $this().Actions.BuildObjCNumericLiteral(new SourceLocation(AtLoc), Lit.get());
  }


/// ParseObjCBooleanLiteral -
/// objc-scalar-literal : '@' boolean-keyword
///                        ;
/// boolean-keyword: 'true' | 'false' | '__objc_yes' | '__objc_no'
///                        ;
//<editor-fold defaultstate="collapsed" desc="clang::Parser::ParseObjCBooleanLiteral">
@Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseObjc.cpp", line = 3358,
   FQN="clang::Parser::ParseObjCBooleanLiteral", NM="_ZN5clang6Parser23ParseObjCBooleanLiteralENS_14SourceLocationEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseObjc.cpp -nm=_ZN5clang6Parser23ParseObjCBooleanLiteralENS_14SourceLocationEb")
  //</editor-fold>
  protected /*private*/ ActionResultTTrue<Expr /*P*/ > ParseObjCBooleanLiteral(SourceLocation AtLoc, 
                         boolean ArgValue) {
    SourceLocation EndLoc = $this().ConsumeToken(); // consume the keyword.
    return $this().Actions.ActOnObjCBoolLiteral(new SourceLocation(AtLoc), new SourceLocation(EndLoc), ArgValue);
  }

//<editor-fold defaultstate="collapsed" desc="clang::Parser::ParseObjCArrayLiteral">
@Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseObjc.cpp", line = 3415,
   FQN="clang::Parser::ParseObjCArrayLiteral", NM="_ZN5clang6Parser21ParseObjCArrayLiteralENS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseObjc.cpp -nm=_ZN5clang6Parser21ParseObjCArrayLiteralENS_14SourceLocationE")
  //</editor-fold>
  protected /*private*/ ActionResultTTrue<Expr /*P*/ > ParseObjCArrayLiteral(SourceLocation AtLoc) {
    SmallVector<Expr /*P*/ > ElementExprs/*J*/= new SmallVector<Expr /*P*/ >(12, (Expr /*P*/ )null); // array elements.
    $this().ConsumeBracket(); // consume the l_square.
    while ($this().Tok.isNot(tok.TokenKind.r_square)) {
      // Parse list of array element expressions (all must be id types).
      ActionResultTTrue<Expr /*P*/ > Res/*J*/= $this().ParseAssignmentExpression();
      if (Res.isInvalid()) {
        // We must manually skip to a ']', otherwise the expression skipper will
        // stop at the ']' when it skips to the ';'.  We want it to skip beyond
        // the enclosing expression.
        $this().SkipUntil(tok.TokenKind.r_square, SkipUntilFlags.StopAtSemi);
        return Res;
      }
      
      // Parse the ellipsis that indicates a pack expansion.
      if ($this().Tok.is(tok.TokenKind.ellipsis)) {
        Res.$assignMove($this().Actions.ActOnPackExpansion(Res.get(), $this().ConsumeToken()));
      }
      if (Res.isInvalid()) {
        return new ActionResultTTrue<Expr /*P*/ >(true);
      }
      
      ElementExprs.push_back(Res.get());
      if ($this().Tok.is(tok.TokenKind.comma)) {
        $this().ConsumeToken(); // Eat the ','.
      } else if ($this().Tok.isNot(tok.TokenKind.r_square)) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          return $c$.clean(ExprError($out_DiagnosticBuilder$C_TokenKind($out_DiagnosticBuilder$C_TokenKind($c$.track($this().Diag($this().Tok, diag.err_expected_either)), tok.TokenKind.r_square), 
                  tok.TokenKind.comma)));
        } finally {
          $c$.$destroy();
        }
      }
    }
    SourceLocation EndLoc = $this().ConsumeBracket(); // location of ']'
    MutableArrayRef<Expr /*P*/ > Args/*J*/= new MutableArrayRef<Expr /*P*/ >(ElementExprs);
    return $this().Actions.BuildObjCArrayLiteral(new SourceRange(/*NO_COPY*/AtLoc, /*NO_COPY*/EndLoc), new MutableArrayRef<Expr /*P*/ >(Args));
  }

//<editor-fold defaultstate="collapsed" desc="clang::Parser::ParseObjCDictionaryLiteral">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseObjc.cpp", line = 3449,
   FQN="clang::Parser::ParseObjCDictionaryLiteral", NM="_ZN5clang6Parser26ParseObjCDictionaryLiteralENS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseObjc.cpp -nm=_ZN5clang6Parser26ParseObjCDictionaryLiteralENS_14SourceLocationE")
  //</editor-fold>
  protected /*private*/ ActionResultTTrue<Expr /*P*/ > ParseObjCDictionaryLiteral(SourceLocation AtLoc) {
    SmallVector<ObjCDictionaryElement> Elements = null;
    try {
      Elements/*J*/= new SmallVector<ObjCDictionaryElement>(4, new ObjCDictionaryElement()); // dictionary elements.
      $this().ConsumeBrace(); // consume the l_square.
      while ($this().Tok.isNot(tok.TokenKind.r_brace)) {
        // Parse the comma separated key : value expressions.
        ActionResultTTrue<Expr /*P*/ > KeyExpr/*J*/= new ActionResultTTrue<Expr /*P*/ >();
        {
          ColonProtectionRAIIObject X = null;
          try {
            X/*J*/= new ColonProtectionRAIIObject(/*Deref*/$this());
            KeyExpr.$assignMove($this().ParseAssignmentExpression());
            if (KeyExpr.isInvalid()) {
              // We must manually skip to a '}', otherwise the expression skipper will
              // stop at the '}' when it skips to the ';'.  We want it to skip beyond
              // the enclosing expression.
              $this().SkipUntil(tok.TokenKind.r_brace, SkipUntilFlags.StopAtSemi);
              return KeyExpr;
            }
          } finally {
            if (X != null) { X.$destroy(); }
          }
        }
        if ($this().ExpectAndConsume(tok.TokenKind.colon)) {
          $this().SkipUntil(tok.TokenKind.r_brace, SkipUntilFlags.StopAtSemi);
          return ExprError();
        }
        
        ActionResultTTrue<Expr /*P*/ > ValueExpr/*J*/= $this().ParseAssignmentExpression();
        if (ValueExpr.isInvalid()) {
          // We must manually skip to a '}', otherwise the expression skipper will
          // stop at the '}' when it skips to the ';'.  We want it to skip beyond
          // the enclosing expression.
          $this().SkipUntil(tok.TokenKind.r_brace, SkipUntilFlags.StopAtSemi);
          return ValueExpr;
        }
        
        // Parse the ellipsis that designates this as a pack expansion.
        SourceLocation EllipsisLoc/*J*/= new SourceLocation();
        if ($this().getLangOpts().CPlusPlus) {
          $this().TryConsumeToken(tok.TokenKind.ellipsis, EllipsisLoc);
        }
        
        // We have a valid expression. Collect it in a vector so we can
        // build the argument list.
        ObjCDictionaryElement Element = new ObjCDictionaryElement(
          KeyExpr.get(), ValueExpr.get(), EllipsisLoc, OptionalUInt.None()
        );
        Elements.push_back(Element);
        if (!$this().TryConsumeToken(tok.TokenKind.comma) && $this().Tok.isNot(tok.TokenKind.r_brace)) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            return $c$.clean(ExprError($out_DiagnosticBuilder$C_TokenKind($out_DiagnosticBuilder$C_TokenKind($c$.track($this().Diag($this().Tok, diag.err_expected_either)), tok.TokenKind.r_brace), 
                    tok.TokenKind.comma)));
          } finally {
            $c$.$destroy();
          }
        }
      }
      SourceLocation EndLoc = $this().ConsumeBrace();
      
      // Create the ObjCDictionaryLiteral.
      return $this().Actions.BuildObjCDictionaryLiteral(new SourceRange(/*NO_COPY*/AtLoc, /*NO_COPY*/EndLoc), 
          new MutableArrayRef<ObjCDictionaryElement>(Elements));
    } finally {
      if (Elements != null) { Elements.$destroy(); }
    }
  }


/// ParseObjCBoxedExpr -
/// objc-box-expression:
///       @( assignment-expression )
//<editor-fold defaultstate="collapsed" desc="clang::Parser::ParseObjCBoxedExpr">
@Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseObjc.cpp", line = 3393,
   FQN="clang::Parser::ParseObjCBoxedExpr", NM="_ZN5clang6Parser18ParseObjCBoxedExprENS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseObjc.cpp -nm=_ZN5clang6Parser18ParseObjCBoxedExprENS_14SourceLocationE")
  //</editor-fold>
  protected /*private*/ ActionResultTTrue<Expr /*P*/ > ParseObjCBoxedExpr(SourceLocation AtLoc) {
    BalancedDelimiterTracker T = null;
    try {
      if ($this().Tok.isNot(tok.TokenKind.l_paren)) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          return $c$.clean(ExprError($out_DiagnosticBuilder$C_char$ptr$C($c$.track($this().Diag($this().Tok, diag.err_expected_lparen_after)), /*KEEP_STR*/$AT)));
        } finally {
          $c$.$destroy();
        }
      }
      
      T/*J*/= new BalancedDelimiterTracker(/*Deref*/$this(), tok.TokenKind.l_paren);
      T.consumeOpen();
      ActionResultTTrue<Expr /*P*/ > ValueExpr/*J*/= $this().ParseAssignmentExpression();
      if (T.consumeClose()) {
        return ExprError();
      }
      if (ValueExpr.isInvalid()) {
        return ExprError();
      }
      
      // Wrap the sub-expression in a parenthesized expression, to distinguish
      // a boxed expression from a literal.
      SourceLocation LPLoc = T.getOpenLocation(), RPLoc = T.getCloseLocation();
      ValueExpr.$assignMove($this().Actions.ActOnParenExpr(new SourceLocation(LPLoc), new SourceLocation(RPLoc), ValueExpr.get()));
      return $this().Actions.BuildObjCBoxedExpr(new SourceRange(/*NO_COPY*/AtLoc, /*NO_COPY*/RPLoc), 
          ValueExpr.get());
    } finally {
      if (T != null) { T.$destroy(); }
    }
  }


///    objc-encode-expression:
///      \@encode ( type-name )
//<editor-fold defaultstate="collapsed" desc="clang::Parser::ParseObjCEncodeExpression">
@Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseObjc.cpp", line = 3506,
   FQN="clang::Parser::ParseObjCEncodeExpression", NM="_ZN5clang6Parser25ParseObjCEncodeExpressionENS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseObjc.cpp -nm=_ZN5clang6Parser25ParseObjCEncodeExpressionENS_14SourceLocationE")
  //</editor-fold>
  protected /*private*/ ActionResultTTrue<Expr /*P*/ > ParseObjCEncodeExpression(SourceLocation AtLoc) {
    BalancedDelimiterTracker T = null;
    try {
      assert ($this().Tok.isObjCAtKeyword(tok.ObjCKeywordKind.objc_encode)) : "Not an @encode expression!";
      
      SourceLocation EncLoc = $this().ConsumeToken();
      if ($this().Tok.isNot(tok.TokenKind.l_paren)) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          return $c$.clean(ExprError($out_DiagnosticBuilder$C_char$ptr$C($c$.track($this().Diag($this().Tok, diag.err_expected_lparen_after)), /*KEEP_STR*/"@encode")));
        } finally {
          $c$.$destroy();
        }
      }
      
      T/*J*/= new BalancedDelimiterTracker(/*Deref*/$this(), tok.TokenKind.l_paren);
      T.consumeOpen();
      
      ActionResult<OpaquePtr<QualType> > Ty = $this().ParseTypeName();
      
      T.consumeClose();
      if (Ty.isInvalid()) {
        return ExprError();
      }
      
      return $this().Actions.ParseObjCEncodeExpression(new SourceLocation(AtLoc), new SourceLocation(EncLoc), T.getOpenLocation(), 
          Ty.get(), T.getCloseLocation());
    } finally {
      if (T != null) { T.$destroy(); }
    }
  }


///     objc-selector-expression
///       @selector '(' '('[opt] objc-keyword-selector ')'[opt] ')'
//<editor-fold defaultstate="collapsed" desc="clang::Parser::ParseObjCSelectorExpression">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseObjc.cpp", line = 3556,
   FQN="clang::Parser::ParseObjCSelectorExpression", NM="_ZN5clang6Parser27ParseObjCSelectorExpressionENS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseObjc.cpp -nm=_ZN5clang6Parser27ParseObjCSelectorExpressionENS_14SourceLocationE")
  //</editor-fold>
  protected /*private*/ ActionResultTTrue<Expr /*P*/ > ParseObjCSelectorExpression(SourceLocation AtLoc) {
    BalancedDelimiterTracker T = null;
    try {
      SourceLocation SelectorLoc = $this().ConsumeToken();
      if ($this().Tok.isNot(tok.TokenKind.l_paren)) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          return $c$.clean(ExprError($out_DiagnosticBuilder$C_char$ptr$C($c$.track($this().Diag($this().Tok, diag.err_expected_lparen_after)), /*KEEP_STR*/"@selector")));
        } finally {
          $c$.$destroy();
        }
      }
      
      SmallVector<IdentifierInfo /*P*/> KeyIdents/*J*/= new SmallVector<IdentifierInfo /*P*/>(12, (IdentifierInfo /*P*/)null);
      SourceLocation sLoc/*J*/= new SourceLocation();
      
      T/*J*/= new BalancedDelimiterTracker(/*Deref*/$this(), tok.TokenKind.l_paren);
      T.consumeOpen();
      boolean HasOptionalParen = $this().Tok.is(tok.TokenKind.l_paren);
      if (HasOptionalParen) {
        $this().ConsumeParen();
      }
      if ($this().Tok.is(tok.TokenKind.code_completion)) {
        $this().Actions.CodeCompleteObjCSelector($this().getCurScope(), new ArrayRef<IdentifierInfo /*P*/ >(KeyIdents));
        $this().cutOffParsing();
        return ExprError();
      }
      
      IdentifierInfo /*P*/ SelIdent = $this().ParseObjCSelectorPiece(sLoc);
      if (!(SelIdent != null) // missing selector name.
         && $this().Tok.isNot(tok.TokenKind.colon) && $this().Tok.isNot(tok.TokenKind.coloncolon)) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          return $c$.clean(ExprError($out_DiagnosticBuilder$C_TokenKind($c$.track($this().Diag($this().Tok, diag.err_expected)), tok.TokenKind.identifier)));
        } finally {
          $c$.$destroy();
        }
      }
      
      KeyIdents.push_back(SelIdent);
      
      /*uint*/int nColons = 0;
      if ($this().Tok.isNot(tok.TokenKind.r_paren)) {
        while (true) {
          if ($this().TryConsumeToken(tok.TokenKind.coloncolon)) { // Handle :: in C++.
            ++nColons;
            KeyIdents.push_back((IdentifierInfo /*P*/ /*const*/)null);
          } else if ($this().ExpectAndConsume(tok.TokenKind.colon)) { // Otherwise expect ':'.
            return ExprError();
          }
          ++nColons;
          if ($this().Tok.is(tok.TokenKind.r_paren)) {
            break;
          }
          if ($this().Tok.is(tok.TokenKind.code_completion)) {
            $this().Actions.CodeCompleteObjCSelector($this().getCurScope(), new ArrayRef<IdentifierInfo /*P*/ >(KeyIdents));
            $this().cutOffParsing();
            return ExprError();
          }
          
          // Check for another keyword selector.
          SourceLocation Loc/*J*/= new SourceLocation();
          SelIdent = $this().ParseObjCSelectorPiece(Loc);
          KeyIdents.push_back(SelIdent);
          if (!(SelIdent != null) && $this().Tok.isNot(tok.TokenKind.colon) && $this().Tok.isNot(tok.TokenKind.coloncolon)) {
            break;
          }
        }
      }
      if (HasOptionalParen && $this().Tok.is(tok.TokenKind.r_paren)) {
        $this().ConsumeParen(); // ')'
      }
      T.consumeClose();
      Selector Sel = $this().PP.getSelectorTable().getSelector(nColons, $AddrOf(KeyIdents.data()));
      return $this().Actions.ParseObjCSelectorExpression(new Selector(Sel), new SourceLocation(AtLoc), new SourceLocation(SelectorLoc), 
          T.getOpenLocation(), 
          T.getCloseLocation(), 
          !HasOptionalParen);
    } finally {
      if (T != null) { T.$destroy(); }
    }
  }


///     objc-protocol-expression
///       \@protocol ( protocol-name )
//<editor-fold defaultstate="collapsed" desc="clang::Parser::ParseObjCProtocolExpression">
@Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseObjc.cpp", line = 3531,
   FQN="clang::Parser::ParseObjCProtocolExpression", NM="_ZN5clang6Parser27ParseObjCProtocolExpressionENS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseObjc.cpp -nm=_ZN5clang6Parser27ParseObjCProtocolExpressionENS_14SourceLocationE")
  //</editor-fold>
  protected /*private*/ ActionResultTTrue<Expr /*P*/ > ParseObjCProtocolExpression(SourceLocation AtLoc) {
    BalancedDelimiterTracker T = null;
    try {
      SourceLocation ProtoLoc = $this().ConsumeToken();
      if ($this().Tok.isNot(tok.TokenKind.l_paren)) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          return $c$.clean(ExprError($out_DiagnosticBuilder$C_char$ptr$C($c$.track($this().Diag($this().Tok, diag.err_expected_lparen_after)), /*KEEP_STR*/"@protocol")));
        } finally {
          $c$.$destroy();
        }
      }
      
      T/*J*/= new BalancedDelimiterTracker(/*Deref*/$this(), tok.TokenKind.l_paren);
      T.consumeOpen();
      if ($this().Tok.isNot(tok.TokenKind.identifier)) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          return $c$.clean(ExprError($out_DiagnosticBuilder$C_TokenKind($c$.track($this().Diag($this().Tok, diag.err_expected)), tok.TokenKind.identifier)));
        } finally {
          $c$.$destroy();
        }
      }
      
      IdentifierInfo /*P*/ protocolId = $this().Tok.getIdentifierInfo();
      SourceLocation ProtoIdLoc = $this().ConsumeToken();
      
      T.consumeClose();
      
      return $this().Actions.ParseObjCProtocolExpression(protocolId, new SourceLocation(AtLoc), new SourceLocation(ProtoLoc), 
          T.getOpenLocation(), new SourceLocation(ProtoIdLoc), 
          T.getCloseLocation());
    } finally {
      if (T != null) { T.$destroy(); }
    }
  }


/// \brief Determine whether the parser is currently referring to a an
/// Objective-C message send, using a simplified heuristic to avoid overhead.
///
/// This routine will only return true for a subset of valid message-send
/// expressions.
//<editor-fold defaultstate="collapsed" desc="clang::Parser::isSimpleObjCMessageExpression">
@Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseObjc.cpp", line = 2979,
   FQN="clang::Parser::isSimpleObjCMessageExpression", NM="_ZN5clang6Parser29isSimpleObjCMessageExpressionEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseObjc.cpp -nm=_ZN5clang6Parser29isSimpleObjCMessageExpressionEv")
  //</editor-fold>
  protected /*private*/ boolean isSimpleObjCMessageExpression() {
    assert ($this().Tok.is(tok.TokenKind.l_square) && $this().getLangOpts().ObjC1) : "Incorrect start for isSimpleObjCMessageExpression";
    return $this().GetLookAheadToken(1).is(tok.TokenKind.identifier)
       && $this().GetLookAheadToken(2).is(tok.TokenKind.identifier);
  }


///   objc-message-expr:
///     '[' objc-receiver objc-message-args ']'
///
///   objc-receiver: [C]
///     'super'
///     expression
///     class-name
///     type-name
///
//<editor-fold defaultstate="collapsed" desc="clang::Parser::ParseObjCMessageExpression">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseObjc.cpp", line = 3023,
   FQN="clang::Parser::ParseObjCMessageExpression", NM="_ZN5clang6Parser26ParseObjCMessageExpressionEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseObjc.cpp -nm=_ZN5clang6Parser26ParseObjCMessageExpressionEv")
  //</editor-fold>
  protected /*private*/ ActionResultTTrue<Expr /*P*/ > ParseObjCMessageExpression() {
    InMessageExpressionRAIIObject InMessage = null;
    try {
      assert ($this().Tok.is(tok.TokenKind.l_square)) : "'[' expected";
      SourceLocation LBracLoc = $this().ConsumeBracket(); // consume '['
      if ($this().Tok.is(tok.TokenKind.code_completion)) {
        $this().Actions.CodeCompleteObjCMessageReceiver($this().getCurScope());
        $this().cutOffParsing();
        return ExprError();
      }
      
      InMessage/*J*/= new InMessageExpressionRAIIObject(/*Deref*/$this(), true);
      if ($this().getLangOpts().CPlusPlus) {
        // We completely separate the C and C++ cases because C++ requires
        // more complicated (read: slower) parsing. 
        
        // Handle send to super.  
        // FIXME: This doesn't benefit from the same typo-correction we
        // get in Objective-C.
        if ($this().Tok.is(tok.TokenKind.identifier) && $this().Tok.getIdentifierInfo() == $this().Ident_super
           && $this().NextToken().isNot(tok.TokenKind.period) && $this().getCurScope().isInObjcMethodScope()) {
          return $this().ParseObjCMessageExpressionBody(new SourceLocation(LBracLoc), $this().ConsumeToken(), new OpaquePtr<QualType>(null), 
              (Expr /*P*/ )null);
        }
        
        // Parse the receiver, which is either a type or an expression.
        bool$ref IsExpr = create_bool$ref();
        type$ref<Object/*void P*/> TypeOrExpr = create_type$ref(null);
        if ($this().ParseObjCXXMessageReceiver(IsExpr, TypeOrExpr)) {
          $this().SkipUntil(tok.TokenKind.r_square, SkipUntilFlags.StopAtSemi);
          return ExprError();
        }
        if (IsExpr.$deref()) {
          return $this().ParseObjCMessageExpressionBody(new SourceLocation(LBracLoc), new SourceLocation(), new OpaquePtr<QualType>(null), 
              ((/*static_cast*/Expr /*P*/ )(TypeOrExpr.$deref())));
        }
        
        return $this().ParseObjCMessageExpressionBody(new SourceLocation(LBracLoc), new SourceLocation(), 
            OpaquePtr.<QualType>getFromOpaquePtr((QualType)TypeOrExpr.$deref()), 
            (Expr /*P*/ )null);
      }
      if ($this().Tok.is(tok.TokenKind.identifier)) {
        IdentifierInfo /*P*/ Name = $this().Tok.getIdentifierInfo();
        SourceLocation NameLoc = $this().Tok.getLocation();
        OpaquePtr<QualType> ReceiverType/*J*/= new OpaquePtr<QualType>();
        switch ($this().Actions.getObjCMessageKind($this().getCurScope(), Name, new SourceLocation(NameLoc), 
            Name == $this().Ident_super, 
            $this().NextToken().is(tok.TokenKind.period), 
            ReceiverType)) {
         case ObjCSuperMessage:
          return $this().ParseObjCMessageExpressionBody(new SourceLocation(LBracLoc), $this().ConsumeToken(), new OpaquePtr<QualType>(null), 
              (Expr /*P*/ )null);
         case ObjCClassMessage:
          if (!ReceiverType.$bool()) {
            $this().SkipUntil(tok.TokenKind.r_square, SkipUntilFlags.StopAtSemi);
            return ExprError();
          }
          
          $this().ConsumeToken(); // the type name
          
          // Parse type arguments and protocol qualifiers.
          if ($this().Tok.is(tok.TokenKind.less)) {
            SourceLocation NewEndLoc/*J*/= new SourceLocation();
            ActionResult<OpaquePtr<QualType> > NewReceiverType = $this().parseObjCTypeArgsAndProtocolQualifiers(new SourceLocation(NameLoc), new OpaquePtr<QualType>(ReceiverType), 
                /*consumeLastToken=*/ true, 
                NewEndLoc);
            if (!NewReceiverType.isUsable()) {
              $this().SkipUntil(tok.TokenKind.r_square, SkipUntilFlags.StopAtSemi);
              return ExprError();
            }
            
            ReceiverType.$assignMove(NewReceiverType.get());
          }
          
          return $this().ParseObjCMessageExpressionBody(new SourceLocation(LBracLoc), new SourceLocation(), 
              new OpaquePtr<QualType>(ReceiverType), (Expr /*P*/ )null);
         case ObjCInstanceMessage:
          // Fall through to parse an expression.
          break;
        }
      }
      
      // Otherwise, an arbitrary expression can be the receiver of a send.
      ActionResultTTrue<Expr /*P*/ > Res = $this().Actions.CorrectDelayedTyposInExpr($this().ParseExpression());
      if (Res.isInvalid()) {
        $this().SkipUntil(tok.TokenKind.r_square, SkipUntilFlags.StopAtSemi);
        return Res;
      }
      
      return $this().ParseObjCMessageExpressionBody(new SourceLocation(LBracLoc), new SourceLocation(), new OpaquePtr<QualType>(null), 
          Res.get());
    } finally {
      if (InMessage != null) { InMessage.$destroy(); }
    }
  }


/// \brief Parse the remainder of an Objective-C message following the
/// '[' objc-receiver.
///
/// This routine handles sends to super, class messages (sent to a
/// class name), and instance messages (sent to an object), and the
/// target is represented by \p SuperLoc, \p ReceiverType, or \p
/// ReceiverExpr, respectively. Only one of these parameters may have
/// a valid value.
///
/// \param LBracLoc The location of the opening '['.
///
/// \param SuperLoc If this is a send to 'super', the location of the
/// 'super' keyword that indicates a send to the superclass.
///
/// \param ReceiverType If this is a class message, the type of the
/// class we are sending a message to.
///
/// \param ReceiverExpr If this is an instance message, the expression
/// used to compute the receiver object.
///
///   objc-message-args:
///     objc-selector
///     objc-keywordarg-list
///
///   objc-keywordarg-list:
///     objc-keywordarg
///     objc-keywordarg-list objc-keywordarg
///
///   objc-keywordarg:
///     selector-name[opt] ':' objc-keywordexpr
///
///   objc-keywordexpr:
///     nonempty-expr-list
///
///   nonempty-expr-list:
///     assignment-expression
///     nonempty-expr-list , assignment-expression
///
//<editor-fold defaultstate="collapsed" desc="clang::Parser::ParseObjCMessageExpressionBody">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseObjc.cpp", line = 3157,
   FQN="clang::Parser::ParseObjCMessageExpressionBody", NM="_ZN5clang6Parser30ParseObjCMessageExpressionBodyENS_14SourceLocationES1_NS_9OpaquePtrINS_8QualTypeEEEPNS_4ExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseObjc.cpp -nm=_ZN5clang6Parser30ParseObjCMessageExpressionBodyENS_14SourceLocationES1_NS_9OpaquePtrINS_8QualTypeEEEPNS_4ExprE")
  //</editor-fold>
  protected /*private*/ ActionResultTTrue<Expr /*P*/ > ParseObjCMessageExpressionBody(SourceLocation LBracLoc, 
                                SourceLocation SuperLoc, 
                                OpaquePtr<QualType> ReceiverType, 
                                Expr /*P*/ ReceiverExpr) {
    InMessageExpressionRAIIObject InMessage = null;
    try {
      InMessage/*J*/= new InMessageExpressionRAIIObject(/*Deref*/$this(), true);
      if ($this().Tok.is(tok.TokenKind.code_completion)) {
        if (SuperLoc.isValid()) {
          $this().Actions.CodeCompleteObjCSuperMessage($this().getCurScope(), new SourceLocation(SuperLoc), new ArrayRef<IdentifierInfo /*P*/ >(None), 
              false);
        } else if (ReceiverType.$bool()) {
          $this().Actions.CodeCompleteObjCClassMessage($this().getCurScope(), new OpaquePtr<QualType>(ReceiverType), new ArrayRef<IdentifierInfo /*P*/ >(None), 
              false);
        } else {
          $this().Actions.CodeCompleteObjCInstanceMessage($this().getCurScope(), ReceiverExpr, 
              new ArrayRef<IdentifierInfo /*P*/ >(None), false);
        }
        $this().cutOffParsing();
        return ExprError();
      }
      
      // Parse objc-selector
      SourceLocation Loc/*J*/= new SourceLocation();
      IdentifierInfo /*P*/ selIdent = $this().ParseObjCSelectorPiece(Loc);
      
      SmallVector<IdentifierInfo /*P*/> KeyIdents/*J*/= new SmallVector<IdentifierInfo /*P*/>(12, (IdentifierInfo /*P*/)null);
      SmallVector<SourceLocation> KeyLocs/*J*/= new SmallVector<SourceLocation>(12, new SourceLocation());
      SmallVector<Expr /*P*/ > KeyExprs/*J*/= new SmallVector<Expr /*P*/ >(12, (Expr /*P*/ )null);
      if ($this().Tok.is(tok.TokenKind.colon)) {
        while (true) {
          // Each iteration parses a single keyword argument.
          KeyIdents.push_back(selIdent);
          KeyLocs.push_back(Loc);
          if ($this().ExpectAndConsume(tok.TokenKind.colon)) {
            // We must manually skip to a ']', otherwise the expression skipper will
            // stop at the ']' when it skips to the ';'.  We want it to skip beyond
            // the enclosing expression.
            $this().SkipUntil(tok.TokenKind.r_square, SkipUntilFlags.StopAtSemi);
            return ExprError();
          }
          
          ///  Parse the expression after ':'
          if ($this().Tok.is(tok.TokenKind.code_completion)) {
            if (SuperLoc.isValid()) {
              $this().Actions.CodeCompleteObjCSuperMessage($this().getCurScope(), new SourceLocation(SuperLoc), 
                  new ArrayRef<IdentifierInfo /*P*/ >(KeyIdents), 
                  /*AtArgumentEpression=*/ true);
            } else if (ReceiverType.$bool()) {
              $this().Actions.CodeCompleteObjCClassMessage($this().getCurScope(), new OpaquePtr<QualType>(ReceiverType), 
                  new ArrayRef<IdentifierInfo /*P*/ >(KeyIdents), 
                  /*AtArgumentEpression=*/ true);
            } else {
              $this().Actions.CodeCompleteObjCInstanceMessage($this().getCurScope(), ReceiverExpr, 
                  new ArrayRef<IdentifierInfo /*P*/ >(KeyIdents), 
                  /*AtArgumentEpression=*/ true);
            }
            
            $this().cutOffParsing();
            return ExprError();
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
          
          ActionResultTTrue<Expr /*P*/ > Res/*J*/= new ActionResultTTrue<Expr /*P*/ >(Expr);
          if (Res.isInvalid()) {
            // We must manually skip to a ']', otherwise the expression skipper will
            // stop at the ']' when it skips to the ';'.  We want it to skip beyond
            // the enclosing expression.
            $this().SkipUntil(tok.TokenKind.r_square, SkipUntilFlags.StopAtSemi);
            return Res;
          }
          
          // We have a valid expression.
          KeyExprs.push_back(Res.get());
          
          // Code completion after each argument.
          if ($this().Tok.is(tok.TokenKind.code_completion)) {
            if (SuperLoc.isValid()) {
              $this().Actions.CodeCompleteObjCSuperMessage($this().getCurScope(), new SourceLocation(SuperLoc), 
                  new ArrayRef<IdentifierInfo /*P*/ >(KeyIdents), 
                  /*AtArgumentEpression=*/ false);
            } else if (ReceiverType.$bool()) {
              $this().Actions.CodeCompleteObjCClassMessage($this().getCurScope(), new OpaquePtr<QualType>(ReceiverType), 
                  new ArrayRef<IdentifierInfo /*P*/ >(KeyIdents), 
                  /*AtArgumentEpression=*/ false);
            } else {
              $this().Actions.CodeCompleteObjCInstanceMessage($this().getCurScope(), ReceiverExpr, 
                  new ArrayRef<IdentifierInfo /*P*/ >(KeyIdents), 
                  /*AtArgumentEpression=*/ false);
            }
            $this().cutOffParsing();
            return ExprError();
          }
          
          // Check for another keyword selector.
          selIdent = $this().ParseObjCSelectorPiece(Loc);
          if (!(selIdent != null) && $this().Tok.isNot(tok.TokenKind.colon)) {
            break;
          }
          // We have a selector or a colon, continue parsing.
        }
        // Parse the, optional, argument list, comma separated.
        while ($this().Tok.is(tok.TokenKind.comma)) {
          SourceLocation commaLoc = $this().ConsumeToken(); // Eat the ','.
          ///  Parse the expression after ','
          ActionResultTTrue<Expr /*P*/ > Res/*J*/= $this().ParseAssignmentExpression();
          if ($this().Tok.is(tok.TokenKind.colon)) {
            Res.$assignMove($this().Actions.CorrectDelayedTyposInExpr(new ActionResultTTrue<Expr /*P*/ >(Res)));
          }
          if (Res.isInvalid()) {
            if ($this().Tok.is(tok.TokenKind.colon)) {
              JavaCleaner $c$ = $createJavaCleaner();
              try {
                $c$.clean($out_DiagnosticBuilder$C_FixItHint$C($c$.track($this().Diag(new SourceLocation(commaLoc), diag.note_extra_comma_message_arg)), 
                    FixItHint.CreateRemoval(new SourceRange(/*NO_COPY*/commaLoc))));
              } finally {
                $c$.$destroy();
              }
            }
            // We must manually skip to a ']', otherwise the expression skipper will
            // stop at the ']' when it skips to the ';'.  We want it to skip beyond
            // the enclosing expression.
            $this().SkipUntil(tok.TokenKind.r_square, SkipUntilFlags.StopAtSemi);
            return Res;
          }
          
          // We have a valid expression.
          KeyExprs.push_back(Res.get());
        }
      } else if (!(selIdent != null)) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_DiagnosticBuilder$C_TokenKind($c$.track($this().Diag($this().Tok, diag.err_expected)), tok.TokenKind.identifier)); // missing selector name.
          
          // We must manually skip to a ']', otherwise the expression skipper will
          // stop at the ']' when it skips to the ';'.  We want it to skip beyond
          // the enclosing expression.
          $this().SkipUntil(tok.TokenKind.r_square, SkipUntilFlags.StopAtSemi);
          return ExprError();
        } finally {
          $c$.$destroy();
        }
      }
      if ($this().Tok.isNot(tok.TokenKind.r_square)) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_DiagnosticBuilder$C_TokenKind($c$.track($this().Diag($this().Tok, diag.err_expected)), 
              ($this().Tok.is(tok.TokenKind.identifier) ? tok.TokenKind.colon : tok.TokenKind.r_square)));
          // We must manually skip to a ']', otherwise the expression skipper will
          // stop at the ']' when it skips to the ';'.  We want it to skip beyond
          // the enclosing expression.
          $this().SkipUntil(tok.TokenKind.r_square, SkipUntilFlags.StopAtSemi);
          return ExprError();
        } finally {
          $c$.$destroy();
        }
      }
      
      SourceLocation RBracLoc = $this().ConsumeBracket(); // consume ']'
      
      /*uint*/int nKeys = KeyIdents.size();
      if (nKeys == 0) {
        KeyIdents.push_back(selIdent);
        KeyLocs.push_back(Loc);
      }
      Selector Sel = $this().PP.getSelectorTable().getSelector(nKeys, $AddrOf(KeyIdents.data()));
      if (SuperLoc.isValid()) {
        return $this().Actions.ActOnSuperMessage($this().getCurScope(), new SourceLocation(SuperLoc), new Selector(Sel), 
            new SourceLocation(LBracLoc), new ArrayRef<SourceLocation>(KeyLocs), new SourceLocation(RBracLoc), new MutableArrayRef<Expr /*P*/ >(KeyExprs));
      } else if (ReceiverType.$bool()) {
        return $this().Actions.ActOnClassMessage($this().getCurScope(), new OpaquePtr<QualType>(ReceiverType), new Selector(Sel), 
            new SourceLocation(LBracLoc), new ArrayRef<SourceLocation>(KeyLocs), new SourceLocation(RBracLoc), new MutableArrayRef<Expr /*P*/ >(KeyExprs));
      }
      return $this().Actions.ActOnInstanceMessage($this().getCurScope(), ReceiverExpr, new Selector(Sel), 
          new SourceLocation(LBracLoc), new ArrayRef<SourceLocation>(KeyLocs), new SourceLocation(RBracLoc), new MutableArrayRef<Expr /*P*/ >(KeyExprs));
    } finally {
      if (InMessage != null) { InMessage.$destroy(); }
    }
  }


/// \brief Parse the receiver of an Objective-C++ message send.
///
/// This routine parses the receiver of a message send in
/// Objective-C++ either as a type or as an expression. Note that this
/// routine must not be called to parse a send to 'super', since it
/// has no way to return such a result.
/// 
/// \param IsExpr Whether the receiver was parsed as an expression.
///
/// \param TypeOrExpr If the receiver was parsed as an expression (\c
/// IsExpr is true), the parsed expression. If the receiver was parsed
/// as a type (\c IsExpr is false), the parsed type.
///
/// \returns True if an error occurred during parsing or semantic
/// analysis, in which case the arguments do not have valid
/// values. Otherwise, returns false for a successful parse.
///
///   objc-receiver: [C++]
///     'super' [not parsed here]
///     expression
///     simple-type-specifier
///     typename-specifier
//<editor-fold defaultstate="collapsed" desc="clang::Parser::ParseObjCXXMessageReceiver">
@Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseObjc.cpp", line = 2906,
   FQN="clang::Parser::ParseObjCXXMessageReceiver", NM="_ZN5clang6Parser26ParseObjCXXMessageReceiverERbRPv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseObjc.cpp -nm=_ZN5clang6Parser26ParseObjCXXMessageReceiverERbRPv")
  //</editor-fold>
  protected /*private*/ boolean ParseObjCXXMessageReceiver(final bool$ref/*bool &*/ IsExpr, final type$ref<Object>/*void P&*/ TypeOrExpr) {
    InMessageExpressionRAIIObject InMessage = null;
    DeclSpec DS = null;
    Declarator DeclaratorInfo = null;
    try {
      InMessage/*J*/= new InMessageExpressionRAIIObject(/*Deref*/$this(), true);
      if ($this().Tok.isOneOf$T(tok.TokenKind.identifier, tok.TokenKind.coloncolon, tok.TokenKind.kw_typename, 
          tok.TokenKind.annot_cxxscope)) {
        $this().TryAnnotateTypeOrScopeToken();
      }
      if (!$this().Actions.isSimpleTypeSpecifier($this().Tok.getKind())) {
        //   objc-receiver:
        //     expression
        // Make sure any typos in the receiver are corrected or diagnosed, so that
        // proper recovery can happen. FIXME: Perhaps filter the corrected expr to
        // only the things that are valid ObjC receivers?
        ActionResultTTrue<Expr /*P*/ > Receiver = $this().Actions.CorrectDelayedTyposInExpr($this().ParseExpression());
        if (Receiver.isInvalid()) {
          return true;
        }
        
        IsExpr.$set(true);
        TypeOrExpr.$set(Receiver.get());
        return false;
      }
      
      // objc-receiver:
      //   typename-specifier
      //   simple-type-specifier
      //   expression (that starts with one of the above)
      DS/*J*/= new DeclSpec($this().AttrFactory);
      $this().ParseCXXSimpleTypeSpecifier(DS);
      if ($this().Tok.is(tok.TokenKind.l_paren)) {
        // If we see an opening parentheses at this point, we are
        // actually parsing an expression that starts with a
        // function-style cast, e.g.,
        //
        //   postfix-expression:
        //     simple-type-specifier ( expression-list [opt] )
        //     typename-specifier ( expression-list [opt] )
        //
        // Parse the remainder of this case, then the (optional)
        // postfix-expression suffix, followed by the (optional)
        // right-hand side of the binary expression. We have an
        // instance method.
        ActionResultTTrue<Expr /*P*/ > Receiver = $this().ParseCXXTypeConstructExpression(DS);
        if (!Receiver.isInvalid()) {
          Receiver.$assignMove($this().ParsePostfixExpressionSuffix(new ActionResultTTrue<Expr /*P*/ >(JD$T.INSTANCE, Receiver.get())));
        }
        if (!Receiver.isInvalid()) {
          Receiver.$assignMove($this().ParseRHSOfBinaryExpression(new ActionResultTTrue<Expr /*P*/ >(JD$T.INSTANCE, Receiver.get()), prec.Level.Comma));
        }
        if (Receiver.isInvalid()) {
          return true;
        }
        
        IsExpr.$set(true);
        TypeOrExpr.$set(Receiver.get());
        return false;
      }
      
      // We have a class message. Turn the simple-type-specifier or
      // typename-specifier we parsed into a type and parse the
      // remainder of the class message.
      DeclaratorInfo/*J*/= new Declarator(DS, Declarator.TheContext.TypeNameContext);
      ActionResult<OpaquePtr<QualType> > Type = $this().Actions.ActOnTypeName($this().getCurScope(), DeclaratorInfo);
      if (Type.isInvalid()) {
        return true;
      }
      
      IsExpr.$set(false);
      TypeOrExpr.$set(Type.get().getAsOpaquePtr());
      return false;
    } finally {
      if (DeclaratorInfo != null) { DeclaratorInfo.$destroy(); }
      if (DS != null) { DS.$destroy(); }
      if (InMessage != null) { InMessage.$destroy(); }
    }
  }


//===--------------------------------------------------------------------===//
// Objective-C Statements
//<editor-fold defaultstate="collapsed" desc="clang::Parser::ParseObjCAtStatement">
@Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseObjc.cpp", line = 2744,
   FQN="clang::Parser::ParseObjCAtStatement", NM="_ZN5clang6Parser20ParseObjCAtStatementENS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseObjc.cpp -nm=_ZN5clang6Parser20ParseObjCAtStatementENS_14SourceLocationE")
  //</editor-fold>
  protected /*private*/ ActionResultTTrue<Stmt /*P*/ > ParseObjCAtStatement(SourceLocation AtLoc) {
    if ($this().Tok.is(tok.TokenKind.code_completion)) {
      $this().Actions.CodeCompleteObjCAtStatement($this().getCurScope());
      $this().cutOffParsing();
      return StmtError();
    }
    if ($this().Tok.isObjCAtKeyword(tok.ObjCKeywordKind.objc_try)) {
      return $this().ParseObjCTryStmt(new SourceLocation(AtLoc));
    }
    if ($this().Tok.isObjCAtKeyword(tok.ObjCKeywordKind.objc_throw)) {
      return $this().ParseObjCThrowStmt(new SourceLocation(AtLoc));
    }
    if ($this().Tok.isObjCAtKeyword(tok.ObjCKeywordKind.objc_synchronized)) {
      return $this().ParseObjCSynchronizedStmt(new SourceLocation(AtLoc));
    }
    if ($this().Tok.isObjCAtKeyword(tok.ObjCKeywordKind.objc_autoreleasepool)) {
      return $this().ParseObjCAutoreleasePoolStmt(new SourceLocation(AtLoc));
    }
    if ($this().Tok.isObjCAtKeyword(tok.ObjCKeywordKind.objc_import)
       && $this().getLangOpts().DebuggerSupport) {
      $this().SkipUntil(tok.TokenKind.semi);
      return $this().Actions.ActOnNullStmt($this().Tok.getLocation());
    }
    
    ActionResultTTrue<Expr /*P*/ > Res/*J*/= $this().ParseExpressionWithLeadingAt(new SourceLocation(AtLoc));
    if (Res.isInvalid()) {
      // If the expression is invalid, skip ahead to the next semicolon. Not
      // doing this opens us up to the possibility of infinite loops if
      // ParseExpression does not consume any tokens.
      $this().SkipUntil(tok.TokenKind.semi);
      return StmtError();
    }
    
    // Otherwise, eat the semicolon.
    $this().ExpectAndConsumeSemi(diag.err_expected_semi_after_expr);
    return $this().Actions.ActOnExprStmt(new ActionResultTTrue<Expr /*P*/ >(Res));
  }


///  objc-try-catch-statement:
///    @try compound-statement objc-catch-list[opt]
///    @try compound-statement objc-catch-list[opt] @finally compound-statement
///
///  objc-catch-list:
///    @catch ( parameter-declaration ) compound-statement
///    objc-catch-list @catch ( catch-parameter-declaration ) compound-statement
///  catch-parameter-declaration:
///     parameter-declaration
///     '...' [OBJC2]
///
//<editor-fold defaultstate="collapsed" desc="clang::Parser::ParseObjCTryStmt">
@Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseObjc.cpp", line = 2533,
   FQN="clang::Parser::ParseObjCTryStmt", NM="_ZN5clang6Parser16ParseObjCTryStmtENS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseObjc.cpp -nm=_ZN5clang6Parser16ParseObjCTryStmtENS_14SourceLocationE")
  //</editor-fold>
  protected /*private*/ ActionResultTTrue<Stmt /*P*/ > ParseObjCTryStmt(SourceLocation atLoc) {
    ParseScope TryScope = null;
    try {
      boolean catch_or_finally_seen = false;
      
      $this().ConsumeToken(); // consume try
      if ($this().Tok.isNot(tok.TokenKind.l_brace)) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_DiagnosticBuilder$C_TokenKind($c$.track($this().Diag($this().Tok, diag.err_expected)), tok.TokenKind.l_brace));
          return StmtError();
        } finally {
          $c$.$destroy();
        }
      }
      SmallVector<Stmt /*P*/ > CatchStmts/*J*/= new SmallVector<Stmt /*P*/ >(32, (Stmt /*P*/ )null);
      ActionResultTTrue<Stmt /*P*/ > FinallyStmt/*J*/= new ActionResultTTrue<Stmt /*P*/ >();
      TryScope/*J*/= new ParseScope($this(), Scope.ScopeFlags.DeclScope);
      ActionResultTTrue<Stmt /*P*/ > TryBody/*J*/= $this().ParseCompoundStatementBody();
      TryScope.Exit();
      if (TryBody.isInvalid()) {
        TryBody.$assignMove($this().Actions.ActOnNullStmt($this().Tok.getLocation()));
      }
      while ($this().Tok.is(tok.TokenKind.at)) {
        // At this point, we need to lookahead to determine if this @ is the start
        // of an @catch or @finally.  We don't want to consume the @ token if this
        // is an @try or @encode or something else.
        Token AfterAt = new Token($this().GetLookAheadToken(1));
        if (!AfterAt.isObjCAtKeyword(tok.ObjCKeywordKind.objc_catch)
           && !AfterAt.isObjCAtKeyword(tok.ObjCKeywordKind.objc_finally)) {
          break;
        }
        
        SourceLocation AtCatchFinallyLoc = $this().ConsumeToken();
        if ($this().Tok.isObjCAtKeyword(tok.ObjCKeywordKind.objc_catch)) {
          Decl /*P*/ FirstPart = null;
          $this().ConsumeToken(); // consume catch
          if ($this().Tok.is(tok.TokenKind.l_paren)) {
            ParseScope CatchScope = null;
            try {
              $this().ConsumeParen();
              CatchScope/*J*/= new ParseScope($this(), Scope.ScopeFlags.DeclScope | Scope.ScopeFlags.AtCatchScope);
              if ($this().Tok.isNot(tok.TokenKind.ellipsis)) {
                DeclSpec DS = null;
                Declarator ParmDecl = null;
                try {
                  DS/*J*/= new DeclSpec($this().AttrFactory);
                  $this().ParseDeclarationSpecifiers(DS);
                  ParmDecl/*J*/= new Declarator(DS, Declarator.TheContext.ObjCCatchContext);
                  $this().ParseDeclarator(ParmDecl);
                  
                  // Inform the actions module about the declarator, so it
                  // gets added to the current scope.
                  FirstPart = $this().Actions.ActOnObjCExceptionDecl($this().getCurScope(), ParmDecl);
                } finally {
                  if (ParmDecl != null) { ParmDecl.$destroy(); }
                  if (DS != null) { DS.$destroy(); }
                }
              } else {
                $this().ConsumeToken(); // consume '...'
              }
              
              SourceLocation RParenLoc/*J*/= new SourceLocation();
              if ($this().Tok.is(tok.TokenKind.r_paren)) {
                RParenLoc.$assignMove($this().ConsumeParen());
              } else { // Skip over garbage, until we get to ')'.  Eat the ')'.
                $this().SkipUntil(tok.TokenKind.r_paren, SkipUntilFlags.StopAtSemi);
              }
              
              ActionResultTTrue<Stmt /*P*/ > CatchBody/*J*/= new ActionResultTTrue<Stmt /*P*/ >(true);
              if ($this().Tok.is(tok.TokenKind.l_brace)) {
                CatchBody.$assignMove($this().ParseCompoundStatementBody());
              } else {
                JavaCleaner $c$ = $createJavaCleaner();
                try {
                  $c$.clean($out_DiagnosticBuilder$C_TokenKind($c$.track($this().Diag($this().Tok, diag.err_expected)), tok.TokenKind.l_brace));
                } finally {
                  $c$.$destroy();
                }
              }
              if (CatchBody.isInvalid()) {
                CatchBody.$assignMove($this().Actions.ActOnNullStmt($this().Tok.getLocation()));
              }
              
              ActionResultTTrue<Stmt /*P*/ > Catch = $this().Actions.ActOnObjCAtCatchStmt(new SourceLocation(AtCatchFinallyLoc), 
                  new SourceLocation(RParenLoc), 
                  FirstPart, 
                  CatchBody.get());
              if (!Catch.isInvalid()) {
                CatchStmts.push_back(Catch.get());
              }
            } finally {
              if (CatchScope != null) { CatchScope.$destroy(); }
            }
          } else {
            JavaCleaner $c$ = $createJavaCleaner();
            try {
              $c$.clean($out_DiagnosticBuilder$C_char$ptr$C($c$.track($this().Diag(new SourceLocation(AtCatchFinallyLoc), diag.err_expected_lparen_after)), 
                  /*KEEP_STR*/"@catch clause"));
              return StmtError();
            } finally {
              $c$.$destroy();
            }
          }
          catch_or_finally_seen = true;
        } else {
          ParseScope FinallyScope = null;
          try {
            assert ($this().Tok.isObjCAtKeyword(tok.ObjCKeywordKind.objc_finally)) : "Lookahead confused?";
            $this().ConsumeToken(); // consume finally
            FinallyScope/*J*/= new ParseScope($this(), Scope.ScopeFlags.DeclScope);
            
            ActionResultTTrue<Stmt /*P*/ > FinallyBody/*J*/= new ActionResultTTrue<Stmt /*P*/ >(true);
            if ($this().Tok.is(tok.TokenKind.l_brace)) {
              FinallyBody.$assignMove($this().ParseCompoundStatementBody());
            } else {
              JavaCleaner $c$ = $createJavaCleaner();
              try {
                $c$.clean($out_DiagnosticBuilder$C_TokenKind($c$.track($this().Diag($this().Tok, diag.err_expected)), tok.TokenKind.l_brace));
              } finally {
                $c$.$destroy();
              }
            }
            if (FinallyBody.isInvalid()) {
              FinallyBody.$assignMove($this().Actions.ActOnNullStmt($this().Tok.getLocation()));
            }
            FinallyStmt.$assignMove($this().Actions.ActOnObjCAtFinallyStmt(new SourceLocation(AtCatchFinallyLoc), 
                    FinallyBody.get()));
            catch_or_finally_seen = true;
            break;
          } finally {
            if (FinallyScope != null) { FinallyScope.$destroy(); }
          }
        }
      }
      if (!catch_or_finally_seen) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($c$.track($this().Diag(new SourceLocation(atLoc), diag.err_missing_catch_finally)));
          return StmtError();
        } finally {
          $c$.$destroy();
        }
      }
      
      return $this().Actions.ActOnObjCAtTryStmt(new SourceLocation(atLoc), TryBody.get(), 
          new MutableArrayRef<Stmt /*P*/ >(CatchStmts), 
          FinallyStmt.get());
    } finally {
      if (TryScope != null) { TryScope.$destroy(); }
    }
  }


///  objc-throw-statement:
///    throw expression[opt];
///
//<editor-fold defaultstate="collapsed" desc="clang::Parser::ParseObjCThrowStmt">
@Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseObjc.cpp", line = 2455,
   FQN="clang::Parser::ParseObjCThrowStmt", NM="_ZN5clang6Parser18ParseObjCThrowStmtENS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseObjc.cpp -nm=_ZN5clang6Parser18ParseObjCThrowStmtENS_14SourceLocationE")
  //</editor-fold>
  protected /*private*/ ActionResultTTrue<Stmt /*P*/ > ParseObjCThrowStmt(SourceLocation atLoc) {
    ActionResultTTrue<Expr /*P*/ > Res/*J*/= new ActionResultTTrue<Expr /*P*/ >();
    $this().ConsumeToken(); // consume throw
    if ($this().Tok.isNot(tok.TokenKind.semi)) {
      Res.$assignMove($this().ParseExpression());
      if (Res.isInvalid()) {
        $this().SkipUntil(tok.TokenKind.semi);
        return StmtError();
      }
    }
    // consume ';'
    $this().ExpectAndConsume(tok.TokenKind.semi, diag.err_expected_after, new StringRef(/*KEEP_STR*/"@throw"));
    return $this().Actions.ActOnObjCAtThrowStmt(new SourceLocation(atLoc), Res.get(), $this().getCurScope());
  }


/// objc-synchronized-statement:
///   @synchronized '(' expression ')' compound-statement
///
//<editor-fold defaultstate="collapsed" desc="clang::Parser::ParseObjCSynchronizedStmt">
@Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseObjc.cpp", line = 2473,
   FQN="clang::Parser::ParseObjCSynchronizedStmt", NM="_ZN5clang6Parser25ParseObjCSynchronizedStmtENS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseObjc.cpp -nm=_ZN5clang6Parser25ParseObjCSynchronizedStmtENS_14SourceLocationE")
  //</editor-fold>
  protected /*private*/ ActionResultTTrue<Stmt /*P*/ > ParseObjCSynchronizedStmt(SourceLocation atLoc) {
    ParseScope bodyScope = null;
    try {
      $this().ConsumeToken(); // consume synchronized
      if ($this().Tok.isNot(tok.TokenKind.l_paren)) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_DiagnosticBuilder$C_char$ptr$C($c$.track($this().Diag($this().Tok, diag.err_expected_lparen_after)), /*KEEP_STR*/"@synchronized"));
          return StmtError();
        } finally {
          $c$.$destroy();
        }
      }
      
      // The operand is surrounded with parentheses.
      $this().ConsumeParen(); // '('
      ActionResultTTrue<Expr /*P*/ > operand/*J*/= $this().ParseExpression();
      if ($this().Tok.is(tok.TokenKind.r_paren)) {
        $this().ConsumeParen(); // ')'
      } else {
        if (!operand.isInvalid()) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            $c$.clean($out_DiagnosticBuilder$C_TokenKind($c$.track($this().Diag($this().Tok, diag.err_expected)), tok.TokenKind.r_paren));
          } finally {
            $c$.$destroy();
          }
        }
        
        // Skip forward until we see a left brace, but don't consume it.
        $this().SkipUntil(tok.TokenKind.l_brace, $bitor_SkipUntilFlags(/*KEEP_ENUM*/SkipUntilFlags.StopAtSemi, /*KEEP_ENUM*/SkipUntilFlags.StopBeforeMatch));
      }
      
      // Require a compound statement.
      if ($this().Tok.isNot(tok.TokenKind.l_brace)) {
        if (!operand.isInvalid()) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            $c$.clean($out_DiagnosticBuilder$C_TokenKind($c$.track($this().Diag($this().Tok, diag.err_expected)), tok.TokenKind.l_brace));
          } finally {
            $c$.$destroy();
          }
        }
        return StmtError();
      }
      
      // Check the @synchronized operand now.
      if (!operand.isInvalid()) {
        operand.$assignMove($this().Actions.ActOnObjCAtSynchronizedOperand(new SourceLocation(atLoc), operand.get()));
      }
      
      // Parse the compound statement within a new scope.
      bodyScope/*J*/= new ParseScope($this(), Scope.ScopeFlags.DeclScope);
      ActionResultTTrue<Stmt /*P*/ > body/*J*/= $this().ParseCompoundStatementBody();
      bodyScope.Exit();
      
      // If there was a semantic or parse error earlier with the
      // operand, fail now.
      if (operand.isInvalid()) {
        return StmtError();
      }
      if (body.isInvalid()) {
        body.$assignMove($this().Actions.ActOnNullStmt($this().Tok.getLocation()));
      }
      
      return $this().Actions.ActOnObjCAtSynchronizedStmt(new SourceLocation(atLoc), operand.get(), body.get());
    } finally {
      if (bodyScope != null) { bodyScope.$destroy(); }
    }
  }


/// objc-autoreleasepool-statement:
///   @autoreleasepool compound-statement
///
//<editor-fold defaultstate="collapsed" desc="clang::Parser::ParseObjCAutoreleasePoolStmt">
@Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseObjc.cpp", line = 2636,
   FQN="clang::Parser::ParseObjCAutoreleasePoolStmt", NM="_ZN5clang6Parser28ParseObjCAutoreleasePoolStmtENS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseObjc.cpp -nm=_ZN5clang6Parser28ParseObjCAutoreleasePoolStmtENS_14SourceLocationE")
  //</editor-fold>
  protected /*private*/ ActionResultTTrue<Stmt /*P*/ > ParseObjCAutoreleasePoolStmt(SourceLocation atLoc) {
    ParseScope BodyScope = null;
    try {
      $this().ConsumeToken(); // consume autoreleasepool
      if ($this().Tok.isNot(tok.TokenKind.l_brace)) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_DiagnosticBuilder$C_TokenKind($c$.track($this().Diag($this().Tok, diag.err_expected)), tok.TokenKind.l_brace));
          return StmtError();
        } finally {
          $c$.$destroy();
        }
      }
      // Enter a scope to hold everything within the compound stmt.  Compound
      // statements can always hold declarations.
      BodyScope/*J*/= new ParseScope($this(), Scope.ScopeFlags.DeclScope);
      
      ActionResultTTrue<Stmt /*P*/ > AutoreleasePoolBody/*J*/= $this().ParseCompoundStatementBody();
      
      BodyScope.Exit();
      if (AutoreleasePoolBody.isInvalid()) {
        AutoreleasePoolBody.$assignMove($this().Actions.ActOnNullStmt($this().Tok.getLocation()));
      }
      return $this().Actions.ActOnObjCAutoreleasePoolStmt(new SourceLocation(atLoc), 
          AutoreleasePoolBody.get());
    } finally {
      if (BodyScope != null) { BodyScope.$destroy(); }
    }
  }


/// ParseObjCTypeQualifierList - This routine parses the objective-c's type
/// qualifier list and builds their bitmask representation in the input
/// argument.
///
///   objc-type-qualifiers:
///     objc-type-qualifier
///     objc-type-qualifiers objc-type-qualifier
///
///   objc-type-qualifier:
///     'in'
///     'out'
///     'inout'
///     'oneway'
///     'bycopy'
///     'byref'
///     'nonnull'
///     'nullable'
///     'null_unspecified'
///
//<editor-fold defaultstate="collapsed" desc="clang::Parser::ParseObjCTypeQualifierList">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseObjc.cpp", line = 1150,
   FQN="clang::Parser::ParseObjCTypeQualifierList", NM="_ZN5clang6Parser26ParseObjCTypeQualifierListERNS_12ObjCDeclSpecENS_10Declarator10TheContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseObjc.cpp -nm=_ZN5clang6Parser26ParseObjCTypeQualifierListERNS_12ObjCDeclSpecENS_10Declarator10TheContextE")
  //</editor-fold>
  protected /*private*/ void ParseObjCTypeQualifierList(final ObjCDeclSpec /*&*/ DS, 
                            Declarator.TheContext Context) {
    assert (Context == Declarator.TheContext.ObjCParameterContext || Context == Declarator.TheContext.ObjCResultContext);
    while (true) {
      if ($this().Tok.is(tok.TokenKind.code_completion)) {
        $this().Actions.CodeCompleteObjCPassingType($this().getCurScope(), DS, 
            Context == Declarator.TheContext.ObjCParameterContext);
        $this().cutOffParsing();
        return;
      }
      if ($this().Tok.isNot(tok.TokenKind.identifier)) {
        return;
      }
      
      /*const*/ IdentifierInfo /*P*/ II = $this().Tok.getIdentifierInfo();
      for (/*uint*/int i = 0; i != ObjCTypeQual.objc_NumQuals.getValue(); ++i) {
        if (II != $this().ObjCTypeQuals[i]
           || $this().NextToken().is(tok.TokenKind.less)
           || $this().NextToken().is(tok.TokenKind.coloncolon)) {
          continue;
        }
        
        /*ObjCDeclSpec::ObjCDeclQualifier*//*uint*/int Qual;
        NullabilityKind Nullability = NullabilityKind.INVALID;
        switch (ObjCTypeQual.valueOf(i)) {
         default:
          throw new llvm_unreachable("Unknown decl qualifier");
         case objc_in:
          Qual = ObjCDeclSpec.ObjCDeclQualifier.DQ_In;
          break;
         case objc_out:
          Qual = ObjCDeclSpec.ObjCDeclQualifier.DQ_Out;
          break;
         case objc_inout:
          Qual = ObjCDeclSpec.ObjCDeclQualifier.DQ_Inout;
          break;
         case objc_oneway:
          Qual = ObjCDeclSpec.ObjCDeclQualifier.DQ_Oneway;
          break;
         case objc_bycopy:
          Qual = ObjCDeclSpec.ObjCDeclQualifier.DQ_Bycopy;
          break;
         case objc_byref:
          Qual = ObjCDeclSpec.ObjCDeclQualifier.DQ_Byref;
          break;
         case objc_nonnull:
          Qual = ObjCDeclSpec.ObjCDeclQualifier.DQ_CSNullability;
          Nullability = NullabilityKind.NonNull;
          break;
         case objc_nullable:
          Qual = ObjCDeclSpec.ObjCDeclQualifier.DQ_CSNullability;
          Nullability = NullabilityKind.Nullable;
          break;
         case objc_null_unspecified:
          Qual = ObjCDeclSpec.ObjCDeclQualifier.DQ_CSNullability;
          Nullability = NullabilityKind.Unspecified;
          break;
        }
        
        // FIXME: Diagnose redundant specifiers.
        DS.setObjCDeclQualifier(Qual);
        if (Qual == ObjCDeclSpec.ObjCDeclQualifier.DQ_CSNullability) {
          DS.setNullability($this().Tok.getLocation(), Nullability);
        }
        
        $this().ConsumeToken();
        II = null;
        break;
      }
      
      // If this wasn't a recognized qualifier, bail out.
      if ((II != null)) {
        return;
      }
    }
  }


/// \brief Determine whether we are currently at the start of an Objective-C
/// class message that appears to be missing the open bracket '['.
//<editor-fold defaultstate="collapsed" desc="clang::Parser::isStartOfObjCClassMessageMissingOpenBracket">
@Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseObjc.cpp", line = 2986,
   FQN="clang::Parser::isStartOfObjCClassMessageMissingOpenBracket", NM="_ZN5clang6Parser43isStartOfObjCClassMessageMissingOpenBracketEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseObjc.cpp -nm=_ZN5clang6Parser43isStartOfObjCClassMessageMissingOpenBracketEv")
  //</editor-fold>
  protected /*private*/ boolean isStartOfObjCClassMessageMissingOpenBracket() {
    if (!$this().getLangOpts().ObjC1 || !$this().NextToken().is(tok.TokenKind.identifier)
       || $this().InMessageExpression) {
      return false;
    }
    
    OpaquePtr<QualType> Type/*J*/= new OpaquePtr<QualType>();
    if ($this().Tok.is(tok.TokenKind.annot_typename)) {
      Type.$assignMove(getTypeAnnotation($this().Tok));
    } else if ($this().Tok.is(tok.TokenKind.identifier)) {
      Type.$assignMove($this().Actions.getTypeName($Deref($this().Tok.getIdentifierInfo()), $this().Tok.getLocation(), 
              $this().getCurScope()));
    } else {
      return false;
    }
    if (!Type.getQualType().isNull() && Type.getQualType().$arrow().isObjCObjectOrInterfaceType()) {
      final /*const*/ Token /*&*/ AfterNext = $this().GetLookAheadToken(2);
      if (AfterNext.isOneOf(tok.TokenKind.colon, tok.TokenKind.r_square)) {
        if ($this().Tok.is(tok.TokenKind.identifier)) {
          $this().TryAnnotateTypeOrScopeToken();
        }
        
        return $this().Tok.is(tok.TokenKind.annot_typename);
      }
    }
    
    return false;
  }

} // END OF class Parser_ParseObjc
