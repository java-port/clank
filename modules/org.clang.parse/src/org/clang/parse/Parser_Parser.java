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
import static org.clank.support.Casts.*;
import static org.clank.java.std.*;
import static org.llvm.support.llvm.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
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
import org.clang.sema.java.SemaFunctionPointers.*;
import static org.clang.parse.Parser.*;
import static org.clang.sema.SemaClangGlobals.*;
import static org.clang.parse.impl.ParserStatics.*;


//<editor-fold defaultstate="collapsed" desc="static type Parser_Parser">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -empty-body -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType -split-class=clang::Parser@this -extends=Parser_ParseTentative ${LLVM_SRC}/llvm/tools/clang/lib/Parse/Parser.cpp -nm=_ZN5clang6Parser10EnterScopeEj;_ZN5clang6Parser10InitializeEv;_ZN5clang6Parser14ParseSimpleAsmEPNS_14SourceLocationE;_ZN5clang6Parser15TryAnnotateNameEbSt10unique_ptrINS_27CorrectionCandidateCallbackESt14default_deleteIS2_EE;_ZN5clang6Parser16ConsumeExtraSemiENS0_13ExtraSemiKindEj;_ZN5clang6Parser16ExpectAndConsumeENS_3tok9TokenKindEjN4llvm9StringRefE;_ZN5clang6Parser16SkipFunctionBodyEv;_ZN5clang6Parser17ParseModuleImportENS_14SourceLocationE;_ZN5clang6Parser17ParseTopLevelDeclERNS_9OpaquePtrINS_12DeclGroupRefEEE;_ZN5clang6Parser18AnnotateScopeTokenERNS_12CXXScopeSpecEb;_ZN5clang6Parser18SuggestParenthesesENS_14SourceLocationEjNS_11SourceRangeE;_ZN5clang6Parser19getSEHExceptKeywordEv;_ZN5clang6Parser20ExpectAndConsumeSemiEj;_ZN5clang6Parser21CodeCompleteDirectiveEb;_ZN5clang6Parser21CodeCompleteMacroNameEb;_ZN5clang6Parser21ParseAsmStringLiteralEv;_ZN5clang6Parser23ParseFunctionDefinitionERNS_17ParsingDeclaratorERKNS0_18ParsedTemplateInfoEPNS0_18LateParsedAttrListE;_ZN5clang6Parser23TryKeywordIdentFallbackEb;_ZN5clang6Parser23isTokenEqualOrEqualTypoEv;_ZN5clang6Parser24ParseExternalDeclarationERNS0_25ParsedAttributesWithRangeEPNS_15ParsingDeclSpecE;_ZN5clang6Parser24TryAnnotateCXXScopeTokenEb;_ZN5clang6Parser24takeTemplateIdAnnotationERKNS_5TokenE;_ZN5clang6Parser25CodeCompleteMacroArgumentEPNS_14IdentifierInfoEPNS_9MacroInfoEj;_ZN5clang6Parser25ParseKNRParamDeclarationsERNS_10DeclaratorE;_ZN5clang6Parser26parseMisplacedModuleImportEv;_ZN5clang6Parser27CodeCompleteNaturalLanguageEv;_ZN5clang6Parser27TryAnnotateTypeOrScopeTokenEbb;_ZN5clang6Parser27isStartOfFunctionDefinitionERKNS_17ParsingDeclaratorE;_ZN5clang6Parser28isDeclarationAfterDeclaratorEv;_ZN5clang6Parser30ParseDeclOrFunctionDefInternalERNS0_25ParsedAttributesWithRangeERNS_15ParsingDeclSpecENS_15AccessSpecifierE;_ZN5clang6Parser31ParseMicrosoftIfExistsConditionERNS0_17IfExistsConditionE;_ZN5clang6Parser33LateTemplateParserCleanupCallbackEPv;_ZN5clang6Parser34CodeCompleteInConditionalExclusionEv;_ZN5clang6Parser34CodeCompletePreprocessorExpressionEv;_ZN5clang6Parser35handleUnexpectedCodeCompletionTokenEv;_ZN5clang6Parser36ParseDeclarationOrFunctionDefinitionERNS0_25ParsedAttributesWithRangeEPNS_15ParsingDeclSpecENS_15AccessSpecifierE;_ZN5clang6Parser41ParseMicrosoftIfExistsExternalDeclarationEv;_ZN5clang6Parser41TryAnnotateTypeOrScopeTokenAfterScopeSpecEbbRNS_12CXXScopeSpecEb;_ZN5clang6Parser4DiagENS_14SourceLocationEj;_ZN5clang6Parser4DiagERKNS_5TokenEj;_ZN5clang6Parser9ExitScopeEv;_ZN5clang6Parser9SkipUntilEN4llvm8ArrayRefINS_3tok9TokenKindEEENS0_14SkipUntilFlagsE; -static-type=Parser_Parser -package=org.clang.parse")
//</editor-fold>
public class Parser_Parser extends Parser_ParseTentative implements CodeCompletionHandler {
private final /*split clang::Parser*/ Parser $this() { return (Parser)this; }

// end anonymous namespace
//<editor-fold defaultstate="collapsed" desc="clang::Parser::getSEHExceptKeyword">
@Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/Parser.cpp", line = 63,
   FQN="clang::Parser::getSEHExceptKeyword", NM="_ZN5clang6Parser19getSEHExceptKeywordEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/Parser.cpp -nm=_ZN5clang6Parser19getSEHExceptKeywordEv")
  //</editor-fold>
  protected /*private*/ IdentifierInfo /*P*/ getSEHExceptKeyword() {
    // __except is accepted as a (contextual) keyword 
    if (!($this().Ident__except != null) && ($this().getLangOpts().MicrosoftExt || $this().getLangOpts().Borland)) {
      $this().Ident__except = $this().PP.getIdentifierInfo(new StringRef(/*KEEP_STR*/"__except"));
    }
    
    return $this().Ident__except;
  }


// Parsing methods.

/// Initialize - Warm up the parser.
///

/// Initialize - Warm up the parser.
///
//<editor-fold defaultstate="collapsed" desc="clang::Parser::Initialize">
@Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/Parser.cpp", line = 452,
   FQN="clang::Parser::Initialize", NM="_ZN5clang6Parser10InitializeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/Parser.cpp -nm=_ZN5clang6Parser10InitializeEv")
  //</editor-fold>
  public void Initialize() {
    // Create the translation unit scope.  Install it as the current scope.
    assert ($this().getCurScope() == null) : "A scope is already active?";
    $this().EnterScope(Scope.ScopeFlags.DeclScope);
    $this().Actions.ActOnTranslationUnitScope($this().getCurScope());
    
    // Initialization for Objective-C context sensitive keywords recognition.
    // Referenced in Parser::ParseObjCTypeQualifierList.
    if ($this().getLangOpts().ObjC1) {
      $this().ObjCTypeQuals[ObjCTypeQual.objc_in.getValue()] = $AddrOf($this().PP.getIdentifierTable().get(new StringRef(/*KEEP_STR*/"in")));
      $this().ObjCTypeQuals[ObjCTypeQual.objc_out.getValue()] = $AddrOf($this().PP.getIdentifierTable().get(new StringRef(/*KEEP_STR*/"out")));
      $this().ObjCTypeQuals[ObjCTypeQual.objc_inout.getValue()] = $AddrOf($this().PP.getIdentifierTable().get(new StringRef(/*KEEP_STR*/"inout")));
      $this().ObjCTypeQuals[ObjCTypeQual.objc_oneway.getValue()] = $AddrOf($this().PP.getIdentifierTable().get(new StringRef(/*KEEP_STR*/"oneway")));
      $this().ObjCTypeQuals[ObjCTypeQual.objc_bycopy.getValue()] = $AddrOf($this().PP.getIdentifierTable().get(new StringRef(/*KEEP_STR*/"bycopy")));
      $this().ObjCTypeQuals[ObjCTypeQual.objc_byref.getValue()] = $AddrOf($this().PP.getIdentifierTable().get(new StringRef(/*KEEP_STR*/"byref")));
      $this().ObjCTypeQuals[ObjCTypeQual.objc_nonnull.getValue()] = $AddrOf($this().PP.getIdentifierTable().get(new StringRef(/*KEEP_STR*/"nonnull")));
      $this().ObjCTypeQuals[ObjCTypeQual.objc_nullable.getValue()] = $AddrOf($this().PP.getIdentifierTable().get(new StringRef(/*KEEP_STR*/"nullable")));
      $this().ObjCTypeQuals[ObjCTypeQual.objc_null_unspecified.getValue()]
         = $AddrOf($this().PP.getIdentifierTable().get(new StringRef(/*KEEP_STR*/"null_unspecified")));
    }
    
    $this().Ident_instancetype = null;
    $this().Ident_final = null;
    $this().Ident_sealed = null;
    $this().Ident_override = null;
    
    $this().Ident_super = $AddrOf($this().PP.getIdentifierTable().get(new StringRef(/*KEEP_STR*/"super")));
    
    $this().Ident_vector = null;
    $this().Ident_bool = null;
    $this().Ident_pixel = null;
    if ($this().getLangOpts().AltiVec || $this().getLangOpts().ZVector) {
      $this().Ident_vector = $AddrOf($this().PP.getIdentifierTable().get(new StringRef(/*KEEP_STR*/"vector")));
      $this().Ident_bool = $AddrOf($this().PP.getIdentifierTable().get(new StringRef(/*KEEP_STR*/"bool")));
    }
    if ($this().getLangOpts().AltiVec) {
      $this().Ident_pixel = $AddrOf($this().PP.getIdentifierTable().get(new StringRef(/*KEEP_STR*/"pixel")));
    }
    
    $this().Ident_introduced = null;
    $this().Ident_deprecated = null;
    $this().Ident_obsoleted = null;
    $this().Ident_unavailable = null;
    $this().Ident_strict = null;
    $this().Ident_replacement = null;
    
    $this().Ident__except = null;
    
    $this().Ident__exception_code = $this().Ident__exception_info = null;
    $this().Ident__abnormal_termination = $this().Ident___exception_code = null;
    $this().Ident___exception_info = $this().Ident___abnormal_termination = null;
    $this().Ident_GetExceptionCode = $this().Ident_GetExceptionInfo = null;
    $this().Ident_AbnormalTermination = null;
    if ($this().getLangOpts().Borland) {
      $this().Ident__exception_info = $this().PP.getIdentifierInfo(new StringRef(/*KEEP_STR*/"_exception_info"));
      $this().Ident___exception_info = $this().PP.getIdentifierInfo(new StringRef(/*KEEP_STR*/"__exception_info"));
      $this().Ident_GetExceptionInfo = $this().PP.getIdentifierInfo(new StringRef(/*KEEP_STR*/"GetExceptionInformation"));
      $this().Ident__exception_code = $this().PP.getIdentifierInfo(new StringRef(/*KEEP_STR*/"_exception_code"));
      $this().Ident___exception_code = $this().PP.getIdentifierInfo(new StringRef(/*KEEP_STR*/"__exception_code"));
      $this().Ident_GetExceptionCode = $this().PP.getIdentifierInfo(new StringRef(/*KEEP_STR*/"GetExceptionCode"));
      $this().Ident__abnormal_termination = $this().PP.getIdentifierInfo(new StringRef(/*KEEP_STR*/"_abnormal_termination"));
      $this().Ident___abnormal_termination = $this().PP.getIdentifierInfo(new StringRef(/*KEEP_STR*/"__abnormal_termination"));
      $this().Ident_AbnormalTermination = $this().PP.getIdentifierInfo(new StringRef(/*KEEP_STR*/"AbnormalTermination"));
      
      $this().PP.SetPoisonReason($this().Ident__exception_code, diag.err_seh___except_block);
      $this().PP.SetPoisonReason($this().Ident___exception_code, diag.err_seh___except_block);
      $this().PP.SetPoisonReason($this().Ident_GetExceptionCode, diag.err_seh___except_block);
      $this().PP.SetPoisonReason($this().Ident__exception_info, diag.err_seh___except_filter);
      $this().PP.SetPoisonReason($this().Ident___exception_info, diag.err_seh___except_filter);
      $this().PP.SetPoisonReason($this().Ident_GetExceptionInfo, diag.err_seh___except_filter);
      $this().PP.SetPoisonReason($this().Ident__abnormal_termination, diag.err_seh___finally_block);
      $this().PP.SetPoisonReason($this().Ident___abnormal_termination, diag.err_seh___finally_block);
      $this().PP.SetPoisonReason($this().Ident_AbnormalTermination, diag.err_seh___finally_block);
    }
    
    $this().Actions.Initialize();
    
    // Prime the lexer look-ahead.
    $this().ConsumeToken();
  }


/// ParseTopLevelDecl - Parse one top-level declaration. Returns true if
/// the EOF was encountered.

/// ParseTopLevelDecl - Parse one top-level declaration, return whatever the
/// action tells us to.  This returns true if the EOF was encountered.
//<editor-fold defaultstate="collapsed" desc="clang::Parser::ParseTopLevelDecl">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/Parser.cpp", line = 542,
   FQN="clang::Parser::ParseTopLevelDecl", NM="_ZN5clang6Parser17ParseTopLevelDeclERNS_9OpaquePtrINS_12DeclGroupRefEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/Parser.cpp -nm=_ZN5clang6Parser17ParseTopLevelDeclERNS_9OpaquePtrINS_12DeclGroupRefEEE")
  //</editor-fold>
  public boolean ParseTopLevelDecl(final OpaquePtr<DeclGroupRef> /*&*/ Result) {
    DestroyTemplateIdAnnotationsRAIIObj CleanupRAII = null;
    ParsedAttributesWithRange attrs = null;
    try {
      CleanupRAII/*J*/= new DestroyTemplateIdAnnotationsRAIIObj($this().TemplateIds);

      // Skip over the EOF token, flagging end of previous input for incremental
      // processing
      if ($this().PP.isIncrementalProcessingEnabled() && $this().Tok.is(tok.TokenKind.eof)) {
        $this().ConsumeToken();
      }

      Result.$assignMove(new OpaquePtr<DeclGroupRef>(null));
      switch ($this().Tok.getKind()) {
       case tok.TokenKind.annot_pragma_unused:
        $this().HandlePragmaUnused();
        return false;
       case tok.TokenKind.annot_module_include:
        $this().Actions.ActOnModuleInclude($this().Tok.getLocation(), 
            reinterpret_cast(Module /*P*/ .class, $this().Tok.getAnnotationValue()));
        $this().ConsumeToken();
        return false;
       case tok.TokenKind.annot_module_begin:
        $this().Actions.ActOnModuleBegin($this().Tok.getLocation(), reinterpret_cast(Module /*P*/ .class, $this().Tok.getAnnotationValue()));
        $this().ConsumeToken();
        return false;
       case tok.TokenKind.annot_module_end:
        $this().Actions.ActOnModuleEnd($this().Tok.getLocation(), reinterpret_cast(Module /*P*/ .class, $this().Tok.getAnnotationValue()));
        $this().ConsumeToken();
        return false;
       case tok.TokenKind.eof:
        // Late template parsing can begin.
        if ($this().getLangOpts().DelayedTemplateParsing) {
          $this().Actions.SetLateTemplateParser(/*FunRef*/Parser::LateTemplateParserCallback, 
              $this().PP.isIncrementalProcessingEnabled() ? /*FunRef*/Parser::LateTemplateParserCleanupCallback : (LateTemplateParserCleanupCB)null, 
              $this());
        }
        if (!$this().PP.isIncrementalProcessingEnabled()) {
          $this().Actions.ActOnEndOfTranslationUnit();
        }
        //else don't tell Sema that we ended parsing: more input might come.
        return true;
       default:
        break;
      }

      attrs/*J*/= new ParsedAttributesWithRange($this().AttrFactory);
      $this().MaybeParseCXX11Attributes(attrs);
      $this().MaybeParseMicrosoftAttributes(attrs);

      Result.$assignMove($this().ParseExternalDeclaration(attrs));
      return false;
    } finally {
      if (attrs != null) { attrs.$destroy(); }
      if (CleanupRAII != null) { CleanupRAII.$destroy(); }
    }
  }


/// \brief Returns true if the current token is '=' or is a type of '='.
/// For typos, give a fixit to '='
//<editor-fold defaultstate="collapsed" desc="clang::Parser::isTokenEqualOrEqualTypo">
@Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/Parser.cpp", line = 1829,
   FQN="clang::Parser::isTokenEqualOrEqualTypo", NM="_ZN5clang6Parser23isTokenEqualOrEqualTypoEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/Parser.cpp -nm=_ZN5clang6Parser23isTokenEqualOrEqualTypoEv")
  //</editor-fold>
  protected /*private*/ boolean isTokenEqualOrEqualTypo() {
    /*tok.TokenKind*/char Kind = $this().Tok.getKind();
    switch (Kind) {
     default:
      return false;
     case tok.TokenKind.ampequal: // &=
     case tok.TokenKind.starequal: // *=
     case tok.TokenKind.plusequal: // +=
     case tok.TokenKind.minusequal: // -=
     case tok.TokenKind.exclaimequal: // !=
     case tok.TokenKind.slashequal: // /=
     case tok.TokenKind.percentequal: // %=
     case tok.TokenKind.lessequal: // <=
     case tok.TokenKind.lesslessequal: // <<=
     case tok.TokenKind.greaterequal: // >=
     case tok.TokenKind.greatergreaterequal: // >>=
     case tok.TokenKind.caretequal: // ^=
     case tok.TokenKind.pipeequal: // |=
     case tok.TokenKind.equalequal: // ==
      {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_DiagnosticBuilder$C_FixItHint$C($out_DiagnosticBuilder$C_TokenKind($c$.track($this().Diag($this().Tok, diag.err_invalid_token_after_declarator_suggest_equal)), 
                  Kind), 
              FixItHint.CreateReplacement(new SourceRange($this().Tok.getLocation()), new StringRef(/*KEEP_STR*/$EQ))));
        } finally {
          $c$.$destroy();
        }
      }
     case tok.TokenKind.equal:
      return true;
    }
  }


///\ brief When we are consuming a code-completion token without having
/// matched specific position in the grammar, provide code-completion results
/// based on context.
///
/// \returns the source location of the code-completion token.
//<editor-fold defaultstate="collapsed" desc="clang::Parser::handleUnexpectedCodeCompletionToken">
@Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/Parser.cpp", line = 1856,
   FQN="clang::Parser::handleUnexpectedCodeCompletionToken", NM="_ZN5clang6Parser35handleUnexpectedCodeCompletionTokenEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/Parser.cpp -nm=_ZN5clang6Parser35handleUnexpectedCodeCompletionTokenEv")
  //</editor-fold>
  protected /*private*/ SourceLocation handleUnexpectedCodeCompletionToken() {
    assert ($this().Tok.is(tok.TokenKind.code_completion));
    $this().PrevTokLocation.$assignMove($this().Tok.getLocation());
    
    for (Scope /*P*/ S = $this().getCurScope(); (S != null); S = S.getParent()) {
      if (((S.getFlags() & Scope.ScopeFlags.FnScope) != 0)) {
        $this().Actions.CodeCompleteOrdinaryName($this().getCurScope(), 
            Sema.ParserCompletionContext.PCC_RecoveryInFunction);
        $this().cutOffParsing();
        return new SourceLocation($this().PrevTokLocation);
      }
      if (((S.getFlags() & Scope.ScopeFlags.ClassScope) != 0)) {
        $this().Actions.CodeCompleteOrdinaryName($this().getCurScope(), Sema.ParserCompletionContext.PCC_Class);
        $this().cutOffParsing();
        return new SourceLocation($this().PrevTokLocation);
      }
    }
    
    $this().Actions.CodeCompleteOrdinaryName($this().getCurScope(), Sema.ParserCompletionContext.PCC_Namespace);
    $this().cutOffParsing();
    return new SourceLocation($this().PrevTokLocation);
  }

// If NeedType is true, then TryAnnotateTypeOrScopeToken will try harder to
// find a type name by attempting typo correction.

/// TryAnnotateTypeOrScopeToken - If the current token position is on a
/// typename (possibly qualified in C++) or a C++ scope specifier not followed
/// by a typename, TryAnnotateTypeOrScopeToken will replace one or more tokens
/// with a single annotation token representing the typename or C++ scope
/// respectively.
/// This simplifies handling of C++ scope specifiers and allows efficient
/// backtracking without the need to re-parse and resolve nested-names and
/// typenames.
/// It will mainly be called when we expect to treat identifiers as typenames
/// (if they are typenames). For example, in C we do not expect identifiers
/// inside expressions to be treated as typenames so it will not be called
/// for expressions in C.
/// The benefit for C/ObjC is that a typename will be annotated and
/// Actions.getTypeName will not be needed to be called again (e.g. getTypeName
/// will not be called twice, once to check whether we have a declaration
/// specifier, and another one to get the actual type inside
/// ParseDeclarationSpecifiers).
///
/// This returns true if an error occurred.
///
/// Note that this routine emits an error if you call it with ::new or ::delete
/// as the current tokens, so only call it in contexts where these are invalid.
//<editor-fold defaultstate="collapsed" desc="clang::Parser::TryAnnotateTypeOrScopeToken">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/Parser.cpp", line = 1586,
   FQN="clang::Parser::TryAnnotateTypeOrScopeToken", NM="_ZN5clang6Parser27TryAnnotateTypeOrScopeTokenEbb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/Parser.cpp -nm=_ZN5clang6Parser27TryAnnotateTypeOrScopeTokenEbb")
  //</editor-fold>
  public boolean TryAnnotateTypeOrScopeToken() {
    return $this().TryAnnotateTypeOrScopeToken(false, false);
  }
  public boolean TryAnnotateTypeOrScopeToken(boolean EnteringContext/*= false*/) {
    return $this().TryAnnotateTypeOrScopeToken(EnteringContext, false);
  }
  public boolean TryAnnotateTypeOrScopeToken(boolean EnteringContext/*= false*/, boolean NeedType/*= false*/) {
    CXXScopeSpec SS = null;
    try {
      assert (($this().Tok.is(tok.TokenKind.identifier) || $this().Tok.is(tok.TokenKind.coloncolon) || $this().Tok.is(tok.TokenKind.kw_typename) || $this().Tok.is(tok.TokenKind.annot_cxxscope) || $this().Tok.is(tok.TokenKind.kw_decltype) || $this().Tok.is(tok.TokenKind.annot_template_id) || $this().Tok.is(tok.TokenKind.kw___super))) : "Cannot be a type or scope token!";
      if ($this().Tok.is(tok.TokenKind.kw_typename)) {
        CXXScopeSpec _SS = null;
        try {
          // MSVC lets you do stuff like:
          //   typename typedef T_::D D;
          //
          // We will consume the typedef token here and put it back after we have
          // parsed the first identifier, transforming it into something more like:
          //   typename T_::D typedef D;
          if ($this().getLangOpts().MSVCCompat && $this().NextToken().is(tok.TokenKind.kw_typedef)) {
            Token TypedefToken/*J*/= new Token();
            $this().PP.Lex(TypedefToken);
            boolean Result = $this().TryAnnotateTypeOrScopeToken(EnteringContext, NeedType);
            $this().PP.EnterToken($this().Tok);
            $this().Tok.$assign(TypedefToken);
            if (!Result) {
              JavaCleaner $c$ = $createJavaCleaner();
              try {
                $c$.clean($c$.track($this().Diag($this().Tok.getLocation(), diag.warn_expected_qualified_after_typename)));
              } finally {
                $c$.$destroy();
              }
            }
            return Result;
          }
          
          // Parse a C++ typename-specifier, e.g., "typename T::type".
          //
          //   typename-specifier:
          //     'typename' '::' [opt] nested-name-specifier identifier
          //     'typename' '::' [opt] nested-name-specifier template [opt]
          //            simple-template-id
          SourceLocation TypenameLoc = $this().ConsumeToken();
          _SS/*J*/= new CXXScopeSpec();
          if ($this().ParseOptionalCXXScopeSpecifier(_SS, /*ObjectType=*/ new OpaquePtr<QualType>(null), 
              /*EnteringContext=*/ false, (bool$ptr/*bool P*/ )null, 
              /*IsTypename*/ true)) {
            return true;
          }
          if (!_SS.isSet()) {
            JavaCleaner $c$ = $createJavaCleaner();
            try {
              if ($this().Tok.is(tok.TokenKind.identifier) || $this().Tok.is(tok.TokenKind.annot_template_id)
                 || $this().Tok.is(tok.TokenKind.annot_decltype)) {
                // Attempt to recover by skipping the invalid 'typename'
                if ($this().Tok.is(tok.TokenKind.annot_decltype)
                   || (!$this().TryAnnotateTypeOrScopeToken(EnteringContext, NeedType)
                   && $this().Tok.isAnnotation())) {
                  /*uint*/int DiagID = diag.err_expected_qualified_after_typename;
                  // MS compatibility: MSVC permits using known types with typename.
                  // e.g. "typedef typename T* pointer_type"
                  if ($this().getLangOpts().MicrosoftExt) {
                    DiagID = diag.warn_expected_qualified_after_typename;
                  }
                  $c$.clean($c$.track($this().Diag($this().Tok.getLocation(), DiagID)));
                  return false;
                }
              }
              
              $c$.clean($c$.track($this().Diag($this().Tok.getLocation(), diag.err_expected_qualified_after_typename)));
              return true;
            } finally {
              $c$.$destroy();
            }
          }
          
          ActionResult<OpaquePtr<QualType> > Ty/*J*/= new ActionResult<OpaquePtr<QualType> >(JD$T.INSTANCE, new OpaquePtr<>());
          if ($this().Tok.is(tok.TokenKind.identifier)) {
            // FIXME: check whether the next token is '<', first!
            Ty.$assignMove($this().Actions.ActOnTypenameType($this().getCurScope(), new SourceLocation(TypenameLoc), _SS, 
                    $Deref($this().Tok.getIdentifierInfo()), 
                    $this().Tok.getLocation()));
          } else if ($this().Tok.is(tok.TokenKind.annot_template_id)) {
            TemplateIdAnnotation /*P*/ TemplateId = $this().takeTemplateIdAnnotation($this().Tok);
            if (TemplateId.Kind != TemplateNameKind.TNK_Type_template
               && TemplateId.Kind != TemplateNameKind.TNK_Dependent_template_name) {
              JavaCleaner $c$ = $createJavaCleaner();
              try {
                $c$.clean($out_DiagnosticBuilder$C_SourceRange($c$.track($this().Diag($this().Tok, diag.err_typename_refers_to_non_type_template)), 
                    $this().Tok.getAnnotationRange()));
                return true;
              } finally {
                $c$.$destroy();
              }
            }
            
            MutableArrayRef<ParsedTemplateArgument> TemplateArgsPtr/*J*/= new MutableArrayRef<ParsedTemplateArgument>(TemplateId.getTemplateArgs(), 
                TemplateId.NumArgs, false);
            
            Ty.$assignMove($this().Actions.ActOnTypenameType($this().getCurScope(), new SourceLocation(TypenameLoc), _SS, 
                    new SourceLocation(TemplateId.TemplateKWLoc), 
                    new OpaquePtr<TemplateName>(TemplateId.Template), 
                    new SourceLocation(TemplateId.TemplateNameLoc), 
                    new SourceLocation(TemplateId.LAngleLoc), 
                    new MutableArrayRef<ParsedTemplateArgument>(TemplateArgsPtr), 
                    new SourceLocation(TemplateId.RAngleLoc)));
          } else {
            JavaCleaner $c$ = $createJavaCleaner();
            try {
              $c$.clean($out_DiagnosticBuilder$C_SourceRange($c$.track($this().Diag($this().Tok, diag.err_expected_type_name_after_typename)), 
                  _SS.getRange()));
              return true;
            } finally {
              $c$.$destroy();
            }
          }
          
          SourceLocation EndLoc = $this().Tok.getLastLoc();
          $this().Tok.setKind(tok.TokenKind.annot_typename);
          setTypeAnnotation($this().Tok, Ty.isInvalid() ? new OpaquePtr<QualType>(null) : Ty.get());
          $this().Tok.setAnnotationEndLoc(/*NO_COPY*/EndLoc);
          $this().Tok.setLocation(/*NO_COPY*/TypenameLoc);
          $this().PP.AnnotateCachedTokens($this().Tok);
          return false;
        } finally {
          if (_SS != null) { _SS.$destroy(); }
        }
      }
      
      // Remembers whether the token was originally a scope annotation.
      boolean WasScopeAnnotation = $this().Tok.is(tok.TokenKind.annot_cxxscope);
      
      SS/*J*/= new CXXScopeSpec();
      if ($this().getLangOpts().CPlusPlus) {
        if ($this().ParseOptionalCXXScopeSpecifier(SS, new OpaquePtr<QualType>(null), EnteringContext)) {
          return true;
        }
      }
      
      return $this().TryAnnotateTypeOrScopeTokenAfterScopeSpec(EnteringContext, NeedType, 
          SS, !WasScopeAnnotation);
    } finally {
      if (SS != null) { SS.$destroy(); }
    }
  }


/// \brief Try to annotate a type or scope token, having already parsed an
/// optional scope specifier. \p IsNewScope should be \c true unless the scope
/// specifier was extracted from an existing tok::annot_cxxscope annotation.
//<editor-fold defaultstate="collapsed" desc="clang::Parser::TryAnnotateTypeOrScopeTokenAfterScopeSpec">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/Parser.cpp", line = 1699,
   FQN="clang::Parser::TryAnnotateTypeOrScopeTokenAfterScopeSpec", NM="_ZN5clang6Parser41TryAnnotateTypeOrScopeTokenAfterScopeSpecEbbRNS_12CXXScopeSpecEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/Parser.cpp -nm=_ZN5clang6Parser41TryAnnotateTypeOrScopeTokenAfterScopeSpecEbbRNS_12CXXScopeSpecEb")
  //</editor-fold>
  public boolean TryAnnotateTypeOrScopeTokenAfterScopeSpec(boolean EnteringContext, 
                                           boolean NeedType, 
                                           final CXXScopeSpec /*&*/ SS, 
                                           boolean IsNewScope) {
    if ($this().Tok.is(tok.TokenKind.identifier)) {
      IdentifierInfo /*P*/ CorrectedII = null;
      {
        // Determine whether the identifier is a type name.
        OpaquePtr<QualType> Ty = $this().Actions.getTypeName($Deref($this().Tok.getIdentifierInfo()), $this().Tok.getLocation(), $this().getCurScope(), $AddrOf(SS), 
            false, $this().NextToken().is(tok.TokenKind.period), new OpaquePtr<QualType>(null), 
            /*IsCtorOrDtorName=*/ false, 
            /*NonTrivialTypeSourceInfo*/ true, 
            NeedType ? create_type$ptr($AddrOf(CorrectedII)) : null);
        if (Ty.$bool()) {
          // A FixIt was applied as a result of typo correction
          if ((CorrectedII != null)) {
            $this().Tok.setIdentifierInfo(CorrectedII);
          }
          
          SourceLocation BeginLoc = $this().Tok.getLocation();
          if (SS.isNotEmpty()) { // it was a C++ qualified type name.
            BeginLoc.$assignMove(SS.getBeginLoc());
          }
          
          /// An Objective-C object type followed by '<' is a specialization of
          /// a parameterized class type or a protocol-qualified type.
          if ($this().getLangOpts().ObjC1 && $this().NextToken().is(tok.TokenKind.less)
             && (Ty.getQualType().$arrow().isObjCObjectType()
             || Ty.getQualType().$arrow().isObjCObjectPointerType())) {
            // Consume the name.
            SourceLocation IdentifierLoc = $this().ConsumeToken();
            SourceLocation NewEndLoc/*J*/= new SourceLocation();
            ActionResult<OpaquePtr<QualType> > NewType = $this().parseObjCTypeArgsAndProtocolQualifiers(new SourceLocation(IdentifierLoc), new OpaquePtr<QualType>(Ty), 
                /*consumeLastToken=*/ false, 
                NewEndLoc);
            if (NewType.isUsable()) {
              Ty.$assignMove(NewType.get());
            }
          }
          
          // This is a typename. Replace the current token in-place with an
          // annotation type token.
          $this().Tok.setKind(tok.TokenKind.annot_typename);
          setTypeAnnotation($this().Tok, new OpaquePtr<QualType>(Ty));
          $this().Tok.setAnnotationEndLoc($this().Tok.getLocation());
          $this().Tok.setLocation(/*NO_COPY*/BeginLoc);
          
          // In case the tokens were cached, have Preprocessor replace
          // them with the annotation token.
          $this().PP.AnnotateCachedTokens($this().Tok);
          return false;
        }
      }
      if (!$this().getLangOpts().CPlusPlus) {
        // If we're in C, we can't have :: tokens at all (the lexer won't return
        // them).  If the identifier is not a type, then it can't be scope either,
        // just early exit.
        return false;
      }
      
      // If this is a template-id, annotate with a template-id or type token.
      if ($this().NextToken().is(tok.TokenKind.less)) {
        OpaquePtr<TemplateName> Template/*J*/= new OpaquePtr<TemplateName>();
        UnqualifiedId TemplateName/*J*/= new UnqualifiedId();
        TemplateName.setIdentifier($this().Tok.getIdentifierInfo(), $this().Tok.getLocation());
        bool$ref MemberOfUnknownSpecialization = create_bool$ref();
        {
          TemplateNameKind TNK = $this().Actions.isTemplateName($this().getCurScope(), SS, 
              /*hasTemplateKeyword=*/ false, TemplateName, 
              /*ObjectType=*/ new OpaquePtr<QualType>(null), EnteringContext, 
              Template, MemberOfUnknownSpecialization);
          if ((TNK.getValue() != 0)) {
            // Consume the identifier.
            $this().ConsumeToken();
            if ($this().AnnotateTemplateIdToken(new OpaquePtr<TemplateName>(Template), TNK, SS, new SourceLocation(), 
                TemplateName)) {
              // If an unrecoverable error occurred, we need to return true here,
              // because the token stream is in a damaged state.  We may not return
              // a valid identifier.
              return true;
            }
          }
        }
      }
      // The current token, which is either an identifier or a
      // template-id, is not part of the annotation. Fall through to
      // push that token back into the stream and complete the C++ scope
      // specifier annotation.
    }
    if ($this().Tok.is(tok.TokenKind.annot_template_id)) {
      TemplateIdAnnotation /*P*/ TemplateId = $this().takeTemplateIdAnnotation($this().Tok);
      if (TemplateId.Kind == TemplateNameKind.TNK_Type_template) {
        // A template-id that refers to a type was parsed into a
        // template-id annotation in a context where we weren't allowed
        // to produce a type annotation token. Update the template-id
        // annotation token to a type annotation token now.
        $this().AnnotateTemplateIdTokenAsType();
        return false;
      }
    }
    if (SS.isEmpty()) {
      return false;
    }
    
    // A C++ scope specifier that isn't followed by a typename.
    $this().AnnotateScopeToken(SS, IsNewScope);
    return false;
  }


/// TryAnnotateScopeToken - Like TryAnnotateTypeOrScopeToken but only
/// annotates C++ scope specifiers and template-ids.  This returns
/// true if there was an error that could not be recovered from.
///
/// Note that this routine emits an error if you call it with ::new or ::delete
/// as the current tokens, so only call it in contexts where these are invalid.
//<editor-fold defaultstate="collapsed" desc="clang::Parser::TryAnnotateCXXScopeToken">
@Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/Parser.cpp", line = 1811,
   FQN="clang::Parser::TryAnnotateCXXScopeToken", NM="_ZN5clang6Parser24TryAnnotateCXXScopeTokenEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/Parser.cpp -nm=_ZN5clang6Parser24TryAnnotateCXXScopeTokenEb")
  //</editor-fold>
  public boolean TryAnnotateCXXScopeToken() {
    return $this().TryAnnotateCXXScopeToken(false);
  }
  public boolean TryAnnotateCXXScopeToken(boolean EnteringContext/*= false*/) {
    CXXScopeSpec SS = null;
    try {
      assert ($this().getLangOpts().CPlusPlus) : "Call sites of this function should be guarded by checking for C++";
      assert (($this().Tok.is(tok.TokenKind.identifier) || $this().Tok.is(tok.TokenKind.coloncolon) || ($this().Tok.is(tok.TokenKind.annot_template_id) && $this().NextToken().is(tok.TokenKind.coloncolon)) || $this().Tok.is(tok.TokenKind.kw_decltype) || $this().Tok.is(tok.TokenKind.kw___super))) : "Cannot be a type or scope token!";
      
      SS/*J*/= new CXXScopeSpec();
      if ($this().ParseOptionalCXXScopeSpecifier(SS, new OpaquePtr<QualType>(null), EnteringContext)) {
        return true;
      }
      if (SS.isEmpty()) {
        return false;
      }
      
      $this().AnnotateScopeToken(SS, true);
      return false;
    } finally {
      if (SS != null) { SS.$destroy(); }
    }
  }


/// \brief Attempt to classify the name at the current token position. This may
/// form a type, scope or primary expression annotation, or replace the token
/// with a typo-corrected keyword. This is only appropriate when the current
/// name must refer to an entity which has already been declared.
///
/// \param IsAddressOfOperand Must be \c true if the name is preceded by an '&'
///        and might possibly have a dependent nested name specifier.
/// \param CCC Indicates how to perform typo-correction for this name. If NULL,
///        no typo correction will be performed.
//<editor-fold defaultstate="collapsed" desc="clang::Parser::TryAnnotateName">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/Parser.cpp", line = 1421,
   FQN="clang::Parser::TryAnnotateName", NM="_ZN5clang6Parser15TryAnnotateNameEbSt10unique_ptrINS_27CorrectionCandidateCallbackESt14default_deleteIS2_EE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/Parser.cpp -nm=_ZN5clang6Parser15TryAnnotateNameEbSt10unique_ptrINS_27CorrectionCandidateCallbackESt14default_deleteIS2_EE")
  //</editor-fold>
  protected /*private*/ Parser.AnnotatedNameKind TryAnnotateName(boolean IsAddressOfOperand) {
    return $this().TryAnnotateName(IsAddressOfOperand, 
                 new std.unique_ptr<CorrectionCandidateCallback>(JD$NullPtr.INSTANCE, null));
  }
  protected /*private*/ Parser.AnnotatedNameKind TryAnnotateName(boolean IsAddressOfOperand, 
                 std.unique_ptr<CorrectionCandidateCallback> CCC/*= null*/) {
    CXXScopeSpec SS = null;
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      assert ($this().Tok.is(tok.TokenKind.identifier) || $this().Tok.is(tok.TokenKind.annot_cxxscope));
      
      /*const*/boolean EnteringContext = false;
      /*const*/boolean WasScopeAnnotation = $this().Tok.is(tok.TokenKind.annot_cxxscope);
      
      SS/*J*/= new CXXScopeSpec();
      if ($this().getLangOpts().CPlusPlus
         && $this().ParseOptionalCXXScopeSpecifier(SS, new OpaquePtr<QualType>(null), EnteringContext)) {
        return AnnotatedNameKind.ANK_Error;
      }
      if ($this().Tok.isNot(tok.TokenKind.identifier) || SS.isInvalid()) {
        if ($this().TryAnnotateTypeOrScopeTokenAfterScopeSpec(EnteringContext, false, SS, 
            !WasScopeAnnotation)) {
          return AnnotatedNameKind.ANK_Error;
        }
        return AnnotatedNameKind.ANK_Unresolved;
      }
      
      final type$ref<IdentifierInfo /*P*/> Name = create_type$ref($this().Tok.getIdentifierInfo());
      SourceLocation NameLoc = $this().Tok.getLocation();
      
      // FIXME: Move the tentative declaration logic into ClassifyName so we can
      // typo-correct to tentatively-declared identifiers.
      if ($this().isTentativelyDeclared(Name.$deref())) {
        // Identifier has been tentatively declared, and thus cannot be resolved as
        // an expression. Fall back to annotating it as a type.
        if ($this().TryAnnotateTypeOrScopeTokenAfterScopeSpec(EnteringContext, false, SS, 
            !WasScopeAnnotation)) {
          return AnnotatedNameKind.ANK_Error;
        }
        return $this().Tok.is(tok.TokenKind.annot_typename) ? AnnotatedNameKind.ANK_Success : AnnotatedNameKind.ANK_TentativeDecl;
      }
      
      Token Next = new Token($this().NextToken());
      
      // Look up and classify the identifier. We don't perform any typo-correction
      // after a scope specifier, because in general we can't recover from typos
      // there (eg, after correcting 'A::tempalte B<X>::C' [sic], we would need to
      // jump back into scope specifier parsing).
      Sema.NameClassification Classification = $c$.clean($this().Actions.ClassifyName($this().getCurScope(), SS, Name, new SourceLocation(NameLoc), Next, IsAddressOfOperand, 
          $c$.track(SS.isEmpty() ? new unique_ptr<CorrectionCandidateCallback>(JD$Move.INSTANCE, std.move(CCC)) : new unique_ptr<CorrectionCandidateCallback>(JD$NullPtr.INSTANCE, null))));
      switch (Classification.getKind()) {
       case NC_Error:
        return AnnotatedNameKind.ANK_Error;
       case NC_Keyword:
        // The identifier was typo-corrected to a keyword.
        $this().Tok.setIdentifierInfo(Name.$deref());
        $this().Tok.setKind(Name.$deref().getTokenID());
        $this().PP.TypoCorrectToken($this().Tok);
        if (SS.isNotEmpty()) {
          $this().AnnotateScopeToken(SS, !WasScopeAnnotation);
        }
        // We've "annotated" this as a keyword.
        return AnnotatedNameKind.ANK_Success;
       case NC_Unknown:
        // It's not something we know about. Leave it unannotated.
        break;
       case NC_Type:
        {
          SourceLocation BeginLoc = new SourceLocation(NameLoc);
          if (SS.isNotEmpty()) {
            BeginLoc.$assignMove(SS.getBeginLoc());
          }
          
          /// An Objective-C object type followed by '<' is a specialization of
          /// a parameterized class type or a protocol-qualified type.
          OpaquePtr<QualType> Ty = Classification.getType();
          if ($this().getLangOpts().ObjC1 && $this().NextToken().is(tok.TokenKind.less)
             && (Ty.getQualType().$arrow().isObjCObjectType()
             || Ty.getQualType().$arrow().isObjCObjectPointerType())) {
            // Consume the name.
            SourceLocation IdentifierLoc = $this().ConsumeToken();
            SourceLocation NewEndLoc/*J*/= new SourceLocation();
            ActionResult<OpaquePtr<QualType> > NewType = $this().parseObjCTypeArgsAndProtocolQualifiers(new SourceLocation(IdentifierLoc), new OpaquePtr<QualType>(Ty), 
                /*consumeLastToken=*/ false, 
                NewEndLoc);
            if (NewType.isUsable()) {
              Ty.$assignMove(NewType.get());
            }
          }
          
          $this().Tok.setKind(tok.TokenKind.annot_typename);
          setTypeAnnotation($this().Tok, new OpaquePtr<QualType>(Ty));
          $this().Tok.setAnnotationEndLoc($this().Tok.getLocation());
          $this().Tok.setLocation(/*NO_COPY*/BeginLoc);
          $this().PP.AnnotateCachedTokens($this().Tok);
          return AnnotatedNameKind.ANK_Success;
        }
       case NC_Expression:
        $this().Tok.setKind(tok.TokenKind.annot_primary_expr);
        setExprAnnotation($this().Tok, Classification.getExpression());
        $this().Tok.setAnnotationEndLoc(/*NO_COPY*/NameLoc);
        if (SS.isNotEmpty()) {
          $this().Tok.setLocation(SS.getBeginLoc());
        }
        $this().PP.AnnotateCachedTokens($this().Tok);
        return AnnotatedNameKind.ANK_Success;
       case NC_TypeTemplate:
        if (Next.isNot(tok.TokenKind.less)) {
          // This may be a type template being used as a template template argument.
          if (SS.isNotEmpty()) {
            $this().AnnotateScopeToken(SS, !WasScopeAnnotation);
          }
          return AnnotatedNameKind.ANK_TemplateName;
        }
       case NC_VarTemplate:
       case NC_FunctionTemplate:
        {
          // We have a type, variable or function template followed by '<'.
          $this().ConsumeToken();
          UnqualifiedId Id/*J*/= new UnqualifiedId();
          Id.setIdentifier(Name.$deref(), new SourceLocation(NameLoc));
          if ($this().AnnotateTemplateIdToken(OpaquePtr.<TemplateName>make(Classification.getTemplateName()), 
              Classification.getTemplateNameKind(), SS, new SourceLocation(), Id)) {
            return AnnotatedNameKind.ANK_Error;
          }
          return AnnotatedNameKind.ANK_Success;
        }
       case NC_NestedNameSpecifier:
        throw new llvm_unreachable("already parsed nested name specifier");
      }
      
      // Unable to classify the name, but maybe we can annotate a scope specifier.
      if (SS.isNotEmpty()) {
        $this().AnnotateScopeToken(SS, !WasScopeAnnotation);
      }
      return AnnotatedNameKind.ANK_Unresolved;
    } finally {
      if (SS != null) { SS.$destroy(); }
      $c$.$destroy();
    }
  }


/// Push a tok::annot_cxxscope token onto the token stream.
//<editor-fold defaultstate="collapsed" desc="clang::Parser::AnnotateScopeToken">
@Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/Parser.cpp", line = 1394,
   FQN="clang::Parser::AnnotateScopeToken", NM="_ZN5clang6Parser18AnnotateScopeTokenERNS_12CXXScopeSpecEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/Parser.cpp -nm=_ZN5clang6Parser18AnnotateScopeTokenERNS_12CXXScopeSpecEb")
  //</editor-fold>
  protected /*private*/ void AnnotateScopeToken(final CXXScopeSpec /*&*/ SS, boolean IsNewAnnotation) {
    // Push the current token back into the token stream (or revert it if it is
    // cached) and use an annotation scope token for current token.
    if ($this().PP.isBacktrackEnabled()) {
      $this().PP.RevertCachedTokens(1);
    } else {
      $this().PP.EnterToken($this().Tok);
    }
    $this().Tok.setKind(tok.TokenKind.annot_cxxscope);
    $this().Tok.setAnnotationValue($this().Actions.SaveNestedNameSpecifierAnnotation(SS));
    $this().Tok.setAnnotationRange(SS.getRange());
    
    // In case the tokens were cached, have Preprocessor replace them
    // with the annotation token.  We don't need to do this if we've
    // just reverted back to a prior state.
    if (IsNewAnnotation) {
      $this().PP.AnnotateCachedTokens($this().Tok);
    }
  }


/// TryKeywordIdentFallback - For compatibility with system headers using
/// keywords as identifiers, attempt to convert the current token to an
/// identifier and optionally disable the keyword for the remainder of the
/// translation unit. This returns false if the token was not replaced,
/// otherwise emits a diagnostic and returns true.
//<editor-fold defaultstate="collapsed" desc="clang::Parser::TryKeywordIdentFallback">
@Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/Parser.cpp", line = 1553,
   FQN="clang::Parser::TryKeywordIdentFallback", NM="_ZN5clang6Parser23TryKeywordIdentFallbackEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/Parser.cpp -nm=_ZN5clang6Parser23TryKeywordIdentFallbackEb")
  //</editor-fold>
  protected /*private*/ boolean TryKeywordIdentFallback(boolean DisableKeyword) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      assert ($this().Tok.isNot(tok.TokenKind.identifier));
      $c$.clean($out$Same2Bool($out_DiagnosticBuilder$C_StringRef($c$.track($this().Diag($this().Tok, diag.ext_keyword_as_ident)), 
              new StringRef($this().PP.getSpelling($this().Tok))), 
          DisableKeyword));
      if (DisableKeyword) {
        $this().Tok.getIdentifierInfo().revertTokenIDToIdentifier();
      }
      $this().Tok.setKind(tok.TokenKind.identifier);
      return true;
    } finally {
      $c$.$destroy();
    }
  }


/// \brief Get the TemplateIdAnnotation from the token.

/// \brief Get the TemplateIdAnnotation from the token and put it in the
/// cleanup pool so that it gets destroyed when parsing the current top level
/// declaration is finished.
//<editor-fold defaultstate="collapsed" desc="clang::Parser::takeTemplateIdAnnotation">
@Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/Parser.cpp", line = 1382,
   FQN="clang::Parser::takeTemplateIdAnnotation", NM="_ZN5clang6Parser24takeTemplateIdAnnotationERKNS_5TokenE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/Parser.cpp -nm=_ZN5clang6Parser24takeTemplateIdAnnotationERKNS_5TokenE")
  //</editor-fold>
  protected /*private*/ TemplateIdAnnotation /*P*/ takeTemplateIdAnnotation(final /*const*/ Token /*&*/ _tok) {
    assert (_tok.is(tok.TokenKind.annot_template_id)) : "Expected template-id token";
    TemplateIdAnnotation /*P*/ Id = ((/*static_cast*/TemplateIdAnnotation /*P*/ )(_tok.getAnnotationValue()));
    return Id;
  }


/// ExpectAndConsume - The parser expects that 'ExpectedTok' is next in the
/// input.  If so, it is consumed and false is returned.
///
/// If a trivial punctuator misspelling is encountered, a FixIt error
/// diagnostic is issued and false is returned after recovery.
///
/// If the input is malformed, this emits the specified diagnostic and true is
/// returned.
//<editor-fold defaultstate="collapsed" desc="clang::Parser::ExpectAndConsume">
@Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/Parser.cpp", line = 131,
   FQN="clang::Parser::ExpectAndConsume", NM="_ZN5clang6Parser16ExpectAndConsumeENS_3tok9TokenKindEjN4llvm9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/Parser.cpp -nm=_ZN5clang6Parser16ExpectAndConsumeENS_3tok9TokenKindEjN4llvm9StringRefE")
  //</editor-fold>
  public/*private*/ boolean ExpectAndConsume(/*tok.TokenKind*/char ExpectedTok) {
    return $this().ExpectAndConsume(ExpectedTok, diag.err_expected, 
                  new StringRef(/*KEEP_STR*/$EMPTY));
  }
  public/*private*/ boolean ExpectAndConsume(/*tok.TokenKind*/char ExpectedTok, /*uint*/int DiagID/*= diag::err_expected*/) {
    return $this().ExpectAndConsume(ExpectedTok, DiagID, 
                  new StringRef(/*KEEP_STR*/$EMPTY));
  }
  public/*private*/ boolean ExpectAndConsume(/*tok.TokenKind*/char ExpectedTok, /*uint*/int DiagID/*= diag::err_expected*/, 
                  StringRef Msg/*= ""*/) {
    DiagnosticBuilder DB = null;
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      if ($this().Tok.is(ExpectedTok) || $this().Tok.is(tok.TokenKind.code_completion)) {
        $this().ConsumeAnyToken();
        return false;
      }
      
      // Detect common single-character typos and resume.
      if (IsCommonTypo(ExpectedTok, $this().Tok)) {
        SourceLocation Loc = $this().Tok.getLocation();
        {
          DiagnosticBuilder DB$1 = null;
          try {
            DB$1 = $this().Diag(/*NO_COPY*/Loc, DiagID);
            $out_DiagnosticBuilder$C_FixItHint$C(DB$1, FixItHint.CreateReplacement(new SourceRange(/*NO_COPY*/Loc), new StringRef(tok.getPunctuatorSpelling(ExpectedTok))));
            if (DiagID == diag.err_expected) {
              $out_DiagnosticBuilder$C_TokenKind(DB$1, ExpectedTok);
            } else if (DiagID == diag.err_expected_after) {
              $out_DiagnosticBuilder$C_TokenKind($out_DiagnosticBuilder$C_StringRef(DB$1, /*NO_COPY*/Msg), ExpectedTok);
            } else {
              $out_DiagnosticBuilder$C_StringRef(DB$1, /*NO_COPY*/Msg);
            }
          } finally {
            if (DB$1 != null) { DB$1.$destroy(); }
          }
        }
        
        // Pretend there wasn't a problem.
        $this().ConsumeAnyToken();
        return false;
      }
      
      SourceLocation EndLoc = $this().PP.getLocForEndOfToken(/*NO_COPY*/$this().PrevTokLocation);
      /*const*/char$ptr/*char P*/ Spelling = null;
      if (EndLoc.isValid()) {
        Spelling = $tryClone(tok.getPunctuatorSpelling(ExpectedTok));
      }
      
      DB = $c$.clean(Native.$bool(Spelling) ? new DiagnosticBuilder($out_DiagnosticBuilder$C_FixItHint$C($c$.track($this().Diag(/*NO_COPY*/EndLoc, DiagID)), FixItHint.CreateInsertion(/*NO_COPY*/EndLoc, new StringRef(Spelling)))) : $this().Diag($this().Tok, DiagID));
      if (DiagID == diag.err_expected) {
        $out_DiagnosticBuilder$C_TokenKind(DB, ExpectedTok);
      } else if (DiagID == diag.err_expected_after) {
        $out_DiagnosticBuilder$C_TokenKind($out_DiagnosticBuilder$C_StringRef(DB, /*NO_COPY*/Msg), ExpectedTok);
      } else {
        $out_DiagnosticBuilder$C_StringRef(DB, /*NO_COPY*/Msg);
      }
      
      return true;
    } finally {
      if (DB != null) { DB.$destroy(); }
      $c$.$destroy();
    }
  }


/// \brief The parser expects a semicolon and, if present, will consume it.
///
/// If the next token is not a semicolon, this emits the specified diagnostic,
/// or, if there's just some closing-delimiter noise (e.g., ')' or ']') prior
/// to the semicolon, consumes that extra token.
//<editor-fold defaultstate="collapsed" desc="clang::Parser::ExpectAndConsumeSemi">
@Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/Parser.cpp", line = 177,
   FQN="clang::Parser::ExpectAndConsumeSemi", NM="_ZN5clang6Parser20ExpectAndConsumeSemiEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/Parser.cpp -nm=_ZN5clang6Parser20ExpectAndConsumeSemiEj")
  //</editor-fold>
  public/*private*/ boolean ExpectAndConsumeSemi(/*uint*/int DiagID) {
    if ($this().TryConsumeToken(tok.TokenKind.semi)) {
      return false;
    }
    if ($this().Tok.is(tok.TokenKind.code_completion)) {
      $this().handleUnexpectedCodeCompletionToken();
      return false;
    }
    if (($this().Tok.is(tok.TokenKind.r_paren) || $this().Tok.is(tok.TokenKind.r_square))
       && $this().NextToken().is(tok.TokenKind.semi)) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_DiagnosticBuilder$C_FixItHint$C($out_DiagnosticBuilder$C_StringRef($c$.track($this().Diag($this().Tok, diag.err_extraneous_token_before_semi)), 
                new StringRef($this().PP.getSpelling($this().Tok))), 
            FixItHint.CreateRemoval(new SourceRange($this().Tok.getLocation()))));
        $this().ConsumeAnyToken(); // The ')' or ']'.
        $this().ConsumeToken(); // The ';'.
        return false;
      } finally {
        $c$.$destroy();
      }
    }
    
    return $this().ExpectAndConsume(tok.TokenKind.semi, DiagID);
  }


/// \brief Consume any extra semi-colons until the end of the line.
//<editor-fold defaultstate="collapsed" desc="clang::Parser::ConsumeExtraSemi">
@Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/Parser.cpp", line = 199,
   FQN="clang::Parser::ConsumeExtraSemi", NM="_ZN5clang6Parser16ConsumeExtraSemiENS0_13ExtraSemiKindEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/Parser.cpp -nm=_ZN5clang6Parser16ConsumeExtraSemiENS0_13ExtraSemiKindEj")
  //</editor-fold>
  protected /*private*/ void ConsumeExtraSemi(ExtraSemiKind Kind) {
    $this().ConsumeExtraSemi(Kind, TypeSpecifierType.TST_unspecified.getValue());
  }
  protected /*private*/ void ConsumeExtraSemi(ExtraSemiKind Kind, /*uint*/int TST/*= TST_unspecified*/) {
    if (!$this().Tok.is(tok.TokenKind.semi)) {
      return;
    }
    
    boolean HadMultipleSemis = false;
    SourceLocation StartLoc = $this().Tok.getLocation();
    SourceLocation EndLoc = $this().Tok.getLocation();
    $this().ConsumeToken();
    while (($this().Tok.is(tok.TokenKind.semi) && !$this().Tok.isAtStartOfLine())) {
      HadMultipleSemis = true;
      EndLoc.$assignMove($this().Tok.getLocation());
      $this().ConsumeToken();
    }
    
    // C++11 allows extra semicolons at namespace scope, but not in any of the
    // other contexts.
    if (Kind == ExtraSemiKind.OutsideFunction && $this().getLangOpts().CPlusPlus) {
      if ($this().getLangOpts().CPlusPlus11) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_DiagnosticBuilder$C_FixItHint$C($c$.track($this().Diag(new SourceLocation(StartLoc), diag.warn_cxx98_compat_top_level_semi)), 
              FixItHint.CreateRemoval(new SourceRange(/*NO_COPY*/StartLoc, /*NO_COPY*/EndLoc))));
        } finally {
          $c$.$destroy();
        }
      } else {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_DiagnosticBuilder$C_FixItHint$C($c$.track($this().Diag(new SourceLocation(StartLoc), diag.ext_extra_semi_cxx11)), 
              FixItHint.CreateRemoval(new SourceRange(/*NO_COPY*/StartLoc, /*NO_COPY*/EndLoc))));
        } finally {
          $c$.$destroy();
        }
      }
      return;
    }
    if (Kind != ExtraSemiKind.AfterMemberFunctionDefinition || HadMultipleSemis) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_DiagnosticBuilder$C_FixItHint$C($out_DiagnosticBuilder$C_char$ptr$C($out_DiagnosticBuilder$C_int($c$.track($this().Diag(new SourceLocation(StartLoc), diag.ext_extra_semi)), 
                    Kind.getValue()), DeclSpec.getSpecifierName(TypeSpecifierType.valueOf(TST), 
                    $this().Actions.getASTContext().getPrintingPolicy())), 
            FixItHint.CreateRemoval(new SourceRange(/*NO_COPY*/StartLoc, /*NO_COPY*/EndLoc))));
      } finally {
        $c$.$destroy();
      }
    } else {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        // A single semicolon is valid after a member function definition.
        $c$.clean($out_DiagnosticBuilder$C_FixItHint$C($c$.track($this().Diag(new SourceLocation(StartLoc), diag.warn_extra_semi_after_mem_fn_def)), 
            FixItHint.CreateRemoval(new SourceRange(/*NO_COPY*/StartLoc, /*NO_COPY*/EndLoc))));
      } finally {
        $c$.$destroy();
      }
    }
  }


/// EnterScope - Start a new scope.

//===----------------------------------------------------------------------===//
// Scope manipulation
//===----------------------------------------------------------------------===//

/// EnterScope - Start a new scope.
//<editor-fold defaultstate="collapsed" desc="clang::Parser::EnterScope">
@Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/Parser.cpp", line = 373,
   FQN="clang::Parser::EnterScope", NM="_ZN5clang6Parser10EnterScopeEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/Parser.cpp -nm=_ZN5clang6Parser10EnterScopeEj")
  //</editor-fold>
  public void EnterScope(/*uint*/int ScopeFlags) {
    if (($this().NumCachedScopes != 0)) {
      Scope /*P*/ N = $this().ScopeCache[--$this().NumCachedScopes];
      N.Init($this().getCurScope(), ScopeFlags);
      $this().Actions.CurScope = N;
    } else {
      $this().Actions.CurScope = new Scope($this().getCurScope(), ScopeFlags, $this().Diags);
    }
  }


/// ExitScope - Pop a scope off the scope stack.

/// ExitScope - Pop a scope off the scope stack.
//<editor-fold defaultstate="collapsed" desc="clang::Parser::ExitScope">
@Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/Parser.cpp", line = 384,
   FQN="clang::Parser::ExitScope", NM="_ZN5clang6Parser9ExitScopeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/Parser.cpp -nm=_ZN5clang6Parser9ExitScopeEv")
  //</editor-fold>
  public void ExitScope() {
    assert (($this().getCurScope() != null)) : "Scope imbalance!";
    
    // Inform the actions module that this scope is going away if there are any
    // decls in it.
    $this().Actions.ActOnPopScope($this().Tok.getLocation(), $this().getCurScope());
    
    Scope /*P*/ OldScope = $this().getCurScope();
    $this().Actions.CurScope = OldScope.getParent();
    if ($this().NumCachedScopes == ScopeCacheSize) {
      if (OldScope != null) { OldScope.$destroy();};
    } else {
      $this().ScopeCache[$this().NumCachedScopes++] = OldScope;
    }
  }


//===--------------------------------------------------------------------===//
// Diagnostic Emission and Error recovery.
//<editor-fold defaultstate="collapsed" desc="clang::Parser::Diag">
@Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/Parser.cpp", line = 94,
   FQN="clang::Parser::Diag", NM="_ZN5clang6Parser4DiagENS_14SourceLocationEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/Parser.cpp -nm=_ZN5clang6Parser4DiagENS_14SourceLocationEj")
  //</editor-fold>
  public final DiagnosticBuilder Diag(SourceLocation Loc, /*uint*/uint$ref DiagID) {
    return $this().Diag(/*NO_COPY*/Loc, DiagID.$deref());
  }
  public DiagnosticBuilder Diag(SourceLocation Loc, /*uint*/int DiagID) {
    return $this().Diags.Report(/*NO_COPY*/Loc, DiagID);
  }

//<editor-fold defaultstate="collapsed" desc="clang::Parser::Diag">
@Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/Parser.cpp", line = 98,
   FQN="clang::Parser::Diag", NM="_ZN5clang6Parser4DiagERKNS_5TokenEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/Parser.cpp -nm=_ZN5clang6Parser4DiagERKNS_5TokenEj")
  //</editor-fold>
  public final DiagnosticBuilder Diag(final /*const*/ Token /*&*/ Tok, /*uint*/uint$ref DiagID) {
    return $this().Diag(Tok, DiagID.$deref());
  }
  public DiagnosticBuilder Diag(final /*const*/ Token /*&*/ Tok, /*uint*/int DiagID) {
    return $this().Diag(Tok.getLocation(), DiagID);
  }


/// \brief Emits a diagnostic suggesting parentheses surrounding a
/// given range.
///
/// \param Loc The location where we'll emit the diagnostic.
/// \param DK The kind of diagnostic to emit.
/// \param ParenRange Source range enclosing code that should be parenthesized.
//<editor-fold defaultstate="collapsed" desc="clang::Parser::SuggestParentheses">
@Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/Parser.cpp", line = 108,
   FQN="clang::Parser::SuggestParentheses", NM="_ZN5clang6Parser18SuggestParenthesesENS_14SourceLocationEjNS_11SourceRangeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/Parser.cpp -nm=_ZN5clang6Parser18SuggestParenthesesENS_14SourceLocationEjNS_11SourceRangeE")
  //</editor-fold>
  protected /*private*/ void SuggestParentheses(SourceLocation Loc, /*uint*/int DK, 
                    SourceRange ParenRange) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      SourceLocation EndLoc = $this().PP.getLocForEndOfToken(ParenRange.getEnd());
      if (!ParenRange.getEnd().isFileID() || EndLoc.isInvalid()) {
        // We can't display the parentheses, so just dig the
        // warning/error and return.
        $c$.clean($c$.track($this().Diag(new SourceLocation(Loc), DK)));
        return;
      }
      
      $c$.clean($out_DiagnosticBuilder$C_FixItHint$C($out_DiagnosticBuilder$C_FixItHint$C($c$.track($this().Diag(new SourceLocation(Loc), DK)), 
              FixItHint.CreateInsertion(ParenRange.getBegin(), new StringRef(/*KEEP_STR*/$LPAREN))), 
          FixItHint.CreateInsertion(/*NO_COPY*/EndLoc, new StringRef(/*KEEP_STR*/$RPAREN))));
    } finally {
      $c$.$destroy();
    }
  }


/// SkipUntil - Read tokens until we get to the specified token, then consume
/// it (unless no flag StopBeforeMatch).  Because we cannot guarantee that the
/// token will ever occur, this skips to the next token, or to some likely
/// good stopping point.  If StopAtSemi is true, skipping will stop at a ';'
/// character.
///
/// If SkipUntil finds the specified token, it returns true, otherwise it
/// returns false.
//<editor-fold defaultstate="collapsed" desc="clang::Parser::SkipUntil">
@Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/Parser.cpp", line = 252,
   FQN="clang::Parser::SkipUntil", NM="_ZN5clang6Parser9SkipUntilEN4llvm8ArrayRefINS_3tok9TokenKindEEENS0_14SkipUntilFlagsE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/Parser.cpp -nm=_ZN5clang6Parser9SkipUntilEN4llvm8ArrayRefINS_3tok9TokenKindEEENS0_14SkipUntilFlagsE")
  //</editor-fold>
  public boolean SkipUntil(ArrayRefUShort/*<tok.TokenKind>*/ Toks) {
    return $this().SkipUntil(Toks, ((/*static_cast*//*SkipUntilFlags*//*uint*/int)(0)));
  }
  public boolean SkipUntil(ArrayRefUShort/*<tok.TokenKind>*/ Toks, /*SkipUntilFlags*//*uint*/int Flags/*= static_cast<SkipUntilFlags>(0)*/) {
    // We always want this function to skip at least one token if the first token
    // isn't T and if not at EOF.
    boolean isFirstTokenSkipped = true;
    while (true) {
      // If we found one of the tokens, stop and return true.
      for (/*uint*/int i = 0, NumToks = Toks.size(); i != NumToks; ++i) {
        if ($this().Tok.is(Toks.$at(i))) {
          if (HasFlagsSet(Flags, SkipUntilFlags.StopBeforeMatch)) {
            // Noop, don't consume the token.
          } else {
            $this().ConsumeAnyToken();
          }
          return true;
        }
      }
      
      // Important special case: The caller has given up and just wants us to
      // skip the rest of the file. Do this without recursing, since we can
      // get here precisely because the caller detected too much recursion.
      if (Toks.size() == 1 && Toks.$at(0) == tok.TokenKind.eof
         && !HasFlagsSet(Flags, SkipUntilFlags.StopAtSemi)
         && !HasFlagsSet(Flags, SkipUntilFlags.StopAtCodeCompletion)) {
        while ($this().Tok.isNot(tok.TokenKind.eof)) {
          $this().ConsumeAnyToken();
        }
        return true;
      }
      switch ($this().Tok.getKind()) {
       case tok.TokenKind.eof:
        // Ran out of tokens.
        return false;
       case tok.TokenKind.annot_pragma_openmp:
       case tok.TokenKind.annot_pragma_openmp_end:
       case tok.TokenKind.annot_module_begin:
       case tok.TokenKind.annot_module_end:
       case tok.TokenKind.annot_module_include:
        // Stop before we change submodules. They generally indicate a "good"
        // place to pick up parsing again (except in the special case where
        // we're trying to skip to EOF).
        return false;
       case tok.TokenKind.code_completion:
        if (!HasFlagsSet(Flags, SkipUntilFlags.StopAtCodeCompletion)) {
          $this().handleUnexpectedCodeCompletionToken();
        }
        return false;
       case tok.TokenKind.l_paren:
        // Recursively skip properly-nested parens.
        $this().ConsumeParen();
        if (HasFlagsSet(Flags, SkipUntilFlags.StopAtCodeCompletion)) {
          $this().SkipUntil(tok.TokenKind.r_paren, SkipUntilFlags.StopAtCodeCompletion);
        } else {
          $this().SkipUntil(tok.TokenKind.r_paren);
        }
        break;
       case tok.TokenKind.l_square:
        // Recursively skip properly-nested square brackets.
        $this().ConsumeBracket();
        if (HasFlagsSet(Flags, SkipUntilFlags.StopAtCodeCompletion)) {
          $this().SkipUntil(tok.TokenKind.r_square, SkipUntilFlags.StopAtCodeCompletion);
        } else {
          $this().SkipUntil(tok.TokenKind.r_square);
        }
        break;
       case tok.TokenKind.l_brace:
        // Recursively skip properly-nested braces.
        $this().ConsumeBrace();
        if (HasFlagsSet(Flags, SkipUntilFlags.StopAtCodeCompletion)) {
          $this().SkipUntil(tok.TokenKind.r_brace, SkipUntilFlags.StopAtCodeCompletion);
        } else {
          $this().SkipUntil(tok.TokenKind.r_brace);
        }
        break;
       case tok.TokenKind.r_paren:
        
        // Okay, we found a ']' or '}' or ')', which we think should be balanced.
        // Since the user wasn't looking for this token (if they were, it would
        // already be handled), this isn't balanced.  If there is a LHS token at a
        // higher level, we will assume that this matches the unbalanced token
        // and return it.  Otherwise, this is a spurious RHS token, which we skip.
        if (($this().ParenCount != 0) && !isFirstTokenSkipped) {
          return false; // Matches something.
        }
        $this().ConsumeParen();
        break;
       case tok.TokenKind.r_square:
        if (($this().BracketCount != 0) && !isFirstTokenSkipped) {
          return false; // Matches something.
        }
        $this().ConsumeBracket();
        break;
       case tok.TokenKind.r_brace:
        if (($this().BraceCount != 0) && !isFirstTokenSkipped) {
          return false; // Matches something.
        }
        $this().ConsumeBrace();
        break;
       case tok.TokenKind.string_literal:
       case tok.TokenKind.wide_string_literal:
       case tok.TokenKind.utf8_string_literal:
       case tok.TokenKind.utf16_string_literal:
       case tok.TokenKind.utf32_string_literal:
        $this().ConsumeStringToken();
        break;
       case tok.TokenKind.semi:
        if (HasFlagsSet(Flags, SkipUntilFlags.StopAtSemi)) {
          return false;
        }
       default:
        // Skip this token.
        $this().ConsumeToken();
        break;
      }
      isFirstTokenSkipped = false;
    }
  }

//<editor-fold defaultstate="collapsed" desc="clang::Parser::LateTemplateParserCleanupCallback">
@Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/Parser.cpp", line = 533,
   FQN="clang::Parser::LateTemplateParserCleanupCallback", NM="_ZN5clang6Parser33LateTemplateParserCleanupCallbackEPv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/Parser.cpp -nm=_ZN5clang6Parser33LateTemplateParserCleanupCallbackEPv")
  //</editor-fold>
  protected /*private*/ static void LateTemplateParserCleanupCallback(Object/*void P*/ P) {
    DestroyTemplateIdAnnotationsRAIIObj CleanupRAII = null;
    try {
      // While this RAII helper doesn't bracket any actual work, the destructor will
      // clean up annotations that were created during ActOnEndOfTranslationUnit
      // when incremental processing is enabled.
      CleanupRAII/*J*/= new DestroyTemplateIdAnnotationsRAIIObj(((Parser /*P*/ )P).TemplateIds);
    } finally {
      if (CleanupRAII != null) { CleanupRAII.$destroy(); }
    }
  }


/// ParseExternalDeclaration:
///
///       external-declaration: [C99 6.9], declaration: [C++ dcl.dcl]
///         function-definition
///         declaration
/// [GNU]   asm-definition
/// [GNU]   __extension__ external-declaration
/// [OBJC]  objc-class-definition
/// [OBJC]  objc-class-declaration
/// [OBJC]  objc-alias-declaration
/// [OBJC]  objc-protocol-definition
/// [OBJC]  objc-method-definition
/// [OBJC]  @end
/// [C++]   linkage-specification
/// [GNU] asm-definition:
///         simple-asm-expr ';'
/// [C++11] empty-declaration
/// [C++11] attribute-declaration
///
/// [C++11] empty-declaration:
///           ';'
///
/// [C++0x/GNU] 'extern' 'template' declaration
//<editor-fold defaultstate="collapsed" desc="clang::Parser::ParseExternalDeclaration">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*go_to*/,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/Parser.cpp", line = 627,
   FQN="clang::Parser::ParseExternalDeclaration", NM="_ZN5clang6Parser24ParseExternalDeclarationERNS0_25ParsedAttributesWithRangeEPNS_15ParsingDeclSpecE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/Parser.cpp -nm=_ZN5clang6Parser24ParseExternalDeclarationERNS0_25ParsedAttributesWithRangeEPNS_15ParsingDeclSpecE")
  //</editor-fold>
  protected /*private*/ OpaquePtr<DeclGroupRef> ParseExternalDeclaration(final ParsedAttributesWithRange /*&*/ attrs) {
    return $this().ParseExternalDeclaration(attrs, 
                          (ParsingDeclSpec /*P*/ )null);
  }
  protected /*private*/ OpaquePtr<DeclGroupRef> ParseExternalDeclaration(final ParsedAttributesWithRange /*&*/ attrs, 
                          ParsingDeclSpec /*P*/ DS/*= null*/) {
    if (System.getProperty("use.parser.in.test") != null) {
      if (!Boolean.getBoolean("use.parser.in.test")) {
        NativeTrace.traceNotImplemented("only cosume tokens, Parser.ParseExternalDeclaration");
        $this().ConsumeAnyToken();
        return new OpaquePtr<DeclGroupRef>();      
      }    
    }
    DestroyTemplateIdAnnotationsRAIIObj CleanupRAII = null;
    ParenBraceBracketBalancer BalancerRAIIObj = null;
    try {
      CleanupRAII/*J*/= new DestroyTemplateIdAnnotationsRAIIObj($this().TemplateIds);
      BalancerRAIIObj/*J*/= new ParenBraceBracketBalancer(/*Deref*/$this());
      if ($this().PP.isCodeCompletionReached()) {
        $this().cutOffParsing();
        return new OpaquePtr<DeclGroupRef>(null);
      }
      
      Decl /*P*/ SingleDecl = null;
      boolean $dont_know = false;
      switch ($this().Tok.getKind()) {
       case tok.TokenKind.annot_pragma_vis:
        $this().HandlePragmaVisibility();
        return new OpaquePtr<DeclGroupRef>(null);
       case tok.TokenKind.annot_pragma_pack:
        $this().HandlePragmaPack();
        return new OpaquePtr<DeclGroupRef>(null);
       case tok.TokenKind.annot_pragma_msstruct:
        $this().HandlePragmaMSStruct();
        return new OpaquePtr<DeclGroupRef>(null);
       case tok.TokenKind.annot_pragma_align:
        $this().HandlePragmaAlign();
        return new OpaquePtr<DeclGroupRef>(null);
       case tok.TokenKind.annot_pragma_weak:
        $this().HandlePragmaWeak();
        return new OpaquePtr<DeclGroupRef>(null);
       case tok.TokenKind.annot_pragma_weakalias:
        $this().HandlePragmaWeakAlias();
        return new OpaquePtr<DeclGroupRef>(null);
       case tok.TokenKind.annot_pragma_redefine_extname:
        $this().HandlePragmaRedefineExtname();
        return new OpaquePtr<DeclGroupRef>(null);
       case tok.TokenKind.annot_pragma_fp_contract:
        $this().HandlePragmaFPContract();
        return new OpaquePtr<DeclGroupRef>(null);
       case tok.TokenKind.annot_pragma_opencl_extension:
        $this().HandlePragmaOpenCLExtension();
        return new OpaquePtr<DeclGroupRef>(null);
       case tok.TokenKind.annot_pragma_openmp:
        {
          type$ref<AccessSpecifier> AS = create_type$ref(AccessSpecifier.AS_none);
          return $this().ParseOpenMPDeclarativeDirectiveWithExtDecl(AS, attrs);
        }
       case tok.TokenKind.annot_pragma_ms_pointers_to_members:
        $this().HandlePragmaMSPointersToMembers();
        return new OpaquePtr<DeclGroupRef>(null);
       case tok.TokenKind.annot_pragma_ms_vtordisp:
        $this().HandlePragmaMSVtorDisp();
        return new OpaquePtr<DeclGroupRef>(null);
       case tok.TokenKind.annot_pragma_ms_pragma:
        $this().HandlePragmaMSPragma();
        return new OpaquePtr<DeclGroupRef>(null);
       case tok.TokenKind.annot_pragma_dump:
        $this().HandlePragmaDump();
        return new OpaquePtr<DeclGroupRef>(null);
       case tok.TokenKind.semi:
        // Either a C++11 empty-declaration or attribute-declaration.
        SingleDecl = $this().Actions.ActOnEmptyDeclaration($this().getCurScope(), 
            attrs.getList(), 
            $this().Tok.getLocation());
        $this().ConsumeExtraSemi(ExtraSemiKind.OutsideFunction);
        break;
       case tok.TokenKind.r_brace:
        {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            $c$.clean($c$.track($this().Diag($this().Tok, diag.err_extraneous_closing_brace)));
            $this().ConsumeBrace();
            return new OpaquePtr<DeclGroupRef>(null);
          } finally {
            $c$.$destroy();
          }
        }
       case tok.TokenKind.eof:
        {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            $c$.clean($c$.track($this().Diag($this().Tok, diag.err_expected_external_declaration)));
            return new OpaquePtr<DeclGroupRef>(null);
          } finally {
            $c$.$destroy();
          }
        }
       case tok.TokenKind.kw___extension__:
        {
          ExtensionRAIIObject O = null;
          try {
            // __extension__ silences extension warnings in the subexpression.
            O/*J*/= new ExtensionRAIIObject($this().Diags); // Use RAII to do this.
            $this().ConsumeToken();
            return $this().ParseExternalDeclaration(attrs);
          } finally {
            if (O != null) { O.$destroy(); }
          }
        }
       case tok.TokenKind.kw_asm:
        {
          $this().ProhibitAttributes(attrs);
          
          SourceLocation StartLoc = $this().Tok.getLocation();
          SourceLocation EndLoc/*J*/= new SourceLocation();
          
          ActionResultTTrue<Expr /*P*/ > Result/*J*/= $this().ParseSimpleAsm($AddrOf(EndLoc));
          
          // Check if GNU-style InlineAsm is disabled.
          // Empty asm string is allowed because it will not introduce
          // any assembly code.
          if (!($this().getLangOpts().GNUAsm || Result.isInvalid())) {
            /*const*/ StringLiteral /*P*/ SL = cast(StringLiteral.class, Result.get());
            if (!SL.getString().trim().empty()) {
              JavaCleaner $c$ = $createJavaCleaner();
              try {
                $c$.clean($c$.track($this().Diag(new SourceLocation(StartLoc), diag.err_gnu_inline_asm_disabled)));
              } finally {
                $c$.$destroy();
              }
            }
          }
          
          $this().ExpectAndConsume(tok.TokenKind.semi, diag.err_expected_after, 
              new StringRef(/*KEEP_STR*/"top-level asm block"));
          if (Result.isInvalid()) {
            return new OpaquePtr<DeclGroupRef>(null);
          }
          SingleDecl = $this().Actions.ActOnFileScopeAsmDecl(Result.get(), new SourceLocation(StartLoc), new SourceLocation(EndLoc));
          break;
        }
       case tok.TokenKind.at:
        return $this().ParseObjCAtDirectives();
       case tok.TokenKind.minus:
       case tok.TokenKind.plus:
        if (!$this().getLangOpts().ObjC1) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            $c$.clean($c$.track($this().Diag($this().Tok, diag.err_expected_external_declaration)));
            $this().ConsumeToken();
            return new OpaquePtr<DeclGroupRef>(null);
          } finally {
            $c$.$destroy();
          }
        }
        SingleDecl = $this().ParseObjCMethodDefinition();
        break;
       case tok.TokenKind.code_completion:
        $this().Actions.CodeCompleteOrdinaryName($this().getCurScope(), 
            ($this().CurParsedObjCImpl != null) ? Sema.ParserCompletionContext.PCC_ObjCImplementation : Sema.ParserCompletionContext.PCC_Namespace);
        $this().cutOffParsing();
        return new OpaquePtr<DeclGroupRef>(null);
       case tok.TokenKind.kw_using:
       case tok.TokenKind.kw_namespace:
       case tok.TokenKind.kw_typedef:
       case tok.TokenKind.kw_template:
       case tok.TokenKind.kw_export: // As in 'export template'
       case tok.TokenKind.kw_static_assert:
       case tok.TokenKind.kw__Static_assert:
        {
          SourceLocation DeclEnd/*J*/= new SourceLocation();
          return $this().ParseDeclaration(Declarator.TheContext.FileContext.getValue(), DeclEnd, attrs);
        }
       case tok.TokenKind.kw_static:
        // Parse (then ignore) 'static' prior to a template instantiation. This is
        // a GCC extension that we intentionally do not support.
        if ($this().getLangOpts().CPlusPlus && $this().NextToken().is(tok.TokenKind.kw_template)) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            $c$.clean($out_DiagnosticBuilder$C_int($c$.track($this().Diag($this().ConsumeToken(), diag.warn_static_inline_explicit_inst_ignored)), 
                0));
            SourceLocation DeclEnd/*J*/= new SourceLocation();
            return $this().ParseDeclaration(Declarator.TheContext.FileContext.getValue(), DeclEnd, attrs);
          } finally {
            $c$.$destroy();
          }
        }
        $dont_know = true; break/*switch*/;
       case tok.TokenKind.kw_inline:
        if ($this().getLangOpts().CPlusPlus) {
          /*tok.TokenKind*/char NextKind = $this().NextToken().getKind();
          
          // Inline namespaces. Allowed as an extension even in C++03.
          if (NextKind == tok.TokenKind.kw_namespace) {
            SourceLocation DeclEnd/*J*/= new SourceLocation();
            return $this().ParseDeclaration(Declarator.TheContext.FileContext.getValue(), DeclEnd, attrs);
          }
          
          // Parse (then ignore) 'inline' prior to a template instantiation. This is
          // a GCC extension that we intentionally do not support.
          if (NextKind == tok.TokenKind.kw_template) {
            JavaCleaner $c$ = $createJavaCleaner();
            try {
              $c$.clean($out_DiagnosticBuilder$C_int($c$.track($this().Diag($this().ConsumeToken(), diag.warn_static_inline_explicit_inst_ignored)), 
                  1));
              SourceLocation DeclEnd/*J*/= new SourceLocation();
              return $this().ParseDeclaration(Declarator.TheContext.FileContext.getValue(), DeclEnd, attrs);
            } finally {
              $c$.$destroy();
            }
          }
        }
        $dont_know = true; break/*switch*/;
       case tok.TokenKind.kw_extern:
        if ($this().getLangOpts().CPlusPlus && $this().NextToken().is(tok.TokenKind.kw_template)) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            // Extern templates
            SourceLocation ExternLoc = $this().ConsumeToken();
            SourceLocation TemplateLoc = $this().ConsumeToken();
            $c$.clean($out_DiagnosticBuilder$C_SourceRange($c$.track($this().Diag(new SourceLocation(ExternLoc), $this().getLangOpts().CPlusPlus11 ? diag.warn_cxx98_compat_extern_template : diag.ext_extern_template)), new SourceRange(/*NO_COPY*/ExternLoc, /*NO_COPY*/TemplateLoc)));
            SourceLocation DeclEnd/*J*/= new SourceLocation();
            return $this().Actions.ConvertDeclToDeclGroup($this().ParseExplicitInstantiation(Declarator.TheContext.FileContext.getValue(), 
                    new SourceLocation(ExternLoc), new SourceLocation(TemplateLoc), DeclEnd));
          } finally {
            $c$.$destroy();
          }
        }
        $dont_know = true; break/*switch*/;
       case tok.TokenKind.kw___if_exists:
       case tok.TokenKind.kw___if_not_exists:
        $this().ParseMicrosoftIfExistsExternalDeclaration();
        return new OpaquePtr<DeclGroupRef>(null);
       default:
       $dont_know=true;
       break;
      }
      if ($dont_know) {
        // We can't tell whether this is a function-definition or declaration yet.
        return $this().ParseDeclarationOrFunctionDefinition(attrs, DS);
      }
      // This routine returns a DeclGroup, if the thing we parsed only contains a
      // single decl, convert it now.
      return $this().Actions.ConvertDeclToDeclGroup(SingleDecl);
    } finally {
      if (BalancerRAIIObj != null) { BalancerRAIIObj.$destroy(); }
      if (CleanupRAII != null) { CleanupRAII.$destroy(); }
    }
  }


/// \brief Determine whether the current token, if it occurs after a
/// declarator, continues a declaration or declaration list.
//<editor-fold defaultstate="collapsed" desc="clang::Parser::isDeclarationAfterDeclarator">
@Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/Parser.cpp", line = 823,
   FQN="clang::Parser::isDeclarationAfterDeclarator", NM="_ZN5clang6Parser28isDeclarationAfterDeclaratorEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/Parser.cpp -nm=_ZN5clang6Parser28isDeclarationAfterDeclaratorEv")
  //</editor-fold>
  protected /*private*/ boolean isDeclarationAfterDeclarator() {
    // Check for '= delete' or '= default'
    if ($this().getLangOpts().CPlusPlus && $this().Tok.is(tok.TokenKind.equal)) {
      final /*const*/ Token /*&*/ KW = $this().NextToken();
      if (KW.is(tok.TokenKind.kw_default) || KW.is(tok.TokenKind.kw_delete)) {
        return false;
      }
    }
    
    return $this().Tok.is(tok.TokenKind.equal) // int X()=  -> not a function def
       || $this().Tok.is(tok.TokenKind.comma) // int X(),  -> not a function def
       || $this().Tok.is(tok.TokenKind.semi) // int X();  -> not a function def
       || $this().Tok.is(tok.TokenKind.kw_asm) // int X() __asm__ -> not a function def
       || $this().Tok.is(tok.TokenKind.kw___attribute) // int X() __attr__ -> not a function def
       || ($this().getLangOpts().CPlusPlus
       && $this().Tok.is(tok.TokenKind.l_paren)); // int X(0) -> not a function def [C++]
  }


/// \brief Determine whether the current token, if it occurs after a
/// declarator, indicates the start of a function definition.
//<editor-fold defaultstate="collapsed" desc="clang::Parser::isStartOfFunctionDefinition">
@Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/Parser.cpp", line = 842,
   FQN="clang::Parser::isStartOfFunctionDefinition", NM="_ZN5clang6Parser27isStartOfFunctionDefinitionERKNS_17ParsingDeclaratorE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/Parser.cpp -nm=_ZN5clang6Parser27isStartOfFunctionDefinitionERKNS_17ParsingDeclaratorE")
  //</editor-fold>
  protected /*private*/ boolean isStartOfFunctionDefinition(final /*const*/ ParsingDeclarator /*&*/ Declarator) {
    assert (Declarator.isFunctionDeclarator()) : "Isn't a function declarator";
    if ($this().Tok.is(tok.TokenKind.l_brace)) { // int X() {}
      return true;
    }
    
    // Handle K&R C argument lists: int X(f) int f; {}
    if (!$this().getLangOpts().CPlusPlus
       && Declarator.getFunctionTypeInfo$Const().isKNRPrototype()) {
      return $this().isDeclarationSpecifier();
    }
    if ($this().getLangOpts().CPlusPlus && $this().Tok.is(tok.TokenKind.equal)) {
      final /*const*/ Token /*&*/ KW = $this().NextToken();
      return KW.is(tok.TokenKind.kw_default) || KW.is(tok.TokenKind.kw_delete);
    }
    
    return $this().Tok.is(tok.TokenKind.colon) // X() : Base() {} (used for ctors)
       || $this().Tok.is(tok.TokenKind.kw_try); // X() try { ... }
  }

//<editor-fold defaultstate="collapsed" desc="clang::Parser::ParseDeclarationOrFunctionDefinition">
@Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/Parser.cpp", line = 948,
   FQN="clang::Parser::ParseDeclarationOrFunctionDefinition", NM="_ZN5clang6Parser36ParseDeclarationOrFunctionDefinitionERNS0_25ParsedAttributesWithRangeEPNS_15ParsingDeclSpecENS_15AccessSpecifierE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/Parser.cpp -nm=_ZN5clang6Parser36ParseDeclarationOrFunctionDefinitionERNS0_25ParsedAttributesWithRangeEPNS_15ParsingDeclSpecENS_15AccessSpecifierE")
  //</editor-fold>
  protected /*private*/ OpaquePtr<DeclGroupRef> ParseDeclarationOrFunctionDefinition(final ParsedAttributesWithRange /*&*/ attrs) {
    return $this().ParseDeclarationOrFunctionDefinition(attrs, 
                                      (ParsingDeclSpec /*P*/ )null, 
                                      AccessSpecifier.AS_none);
  }
  protected /*private*/ OpaquePtr<DeclGroupRef> ParseDeclarationOrFunctionDefinition(final ParsedAttributesWithRange /*&*/ attrs, 
                                      ParsingDeclSpec /*P*/ DS/*= null*/) {
    return $this().ParseDeclarationOrFunctionDefinition(attrs, 
                                      DS, 
                                      AccessSpecifier.AS_none);
  }
  protected /*private*/ OpaquePtr<DeclGroupRef> ParseDeclarationOrFunctionDefinition(final ParsedAttributesWithRange /*&*/ attrs, 
                                      ParsingDeclSpec /*P*/ DS/*= null*/, 
                                      AccessSpecifier AS/*= AS_none*/) {
    if ((DS != null)) {
      return $this().ParseDeclOrFunctionDefInternal(attrs, $Deref(DS), AS);
    } else {
      ParsingDeclSpec PDS = null;
      ObjCDeclContextSwitch ObjCDC = null;
      try {
        PDS/*J*/= new ParsingDeclSpec(/*Deref*/$this());
        // Must temporarily exit the objective-c container scope for
        // parsing c constructs and re-enter objc container scope
        // afterwards.
        ObjCDC/*J*/= new ObjCDeclContextSwitch(/*Deref*/$this());
        
        return $this().ParseDeclOrFunctionDefInternal(attrs, PDS, AS);
      } finally {
        if (ObjCDC != null) { ObjCDC.$destroy(); }
        if (PDS != null) { PDS.$destroy(); }
      }
    }
  }


/// ParseDeclarationOrFunctionDefinition - Parse either a function-definition or
/// a declaration.  We can't tell which we have until we read up to the
/// compound-statement in function-definition. TemplateParams, if
/// non-NULL, provides the template parameters when we're parsing a
/// C++ template-declaration.
///
///       function-definition: [C99 6.9.1]
///         decl-specs      declarator declaration-list[opt] compound-statement
/// [C90] function-definition: [C99 6.7.1] - implicit int result
/// [C90]   decl-specs[opt] declarator declaration-list[opt] compound-statement
///
///       declaration: [C99 6.7]
///         declaration-specifiers init-declarator-list[opt] ';'
/// [!C99]  init-declarator-list ';'                   [TODO: warn in c99 mode]
/// [OMP]   threadprivate-directive                              [TODO]
///
//<editor-fold defaultstate="collapsed" desc="clang::Parser::ParseDeclOrFunctionDefInternal">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/Parser.cpp", line = 877,
   FQN="clang::Parser::ParseDeclOrFunctionDefInternal", NM="_ZN5clang6Parser30ParseDeclOrFunctionDefInternalERNS0_25ParsedAttributesWithRangeERNS_15ParsingDeclSpecENS_15AccessSpecifierE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/Parser.cpp -nm=_ZN5clang6Parser30ParseDeclOrFunctionDefInternalERNS0_25ParsedAttributesWithRangeERNS_15ParsingDeclSpecENS_15AccessSpecifierE")
  //</editor-fold>
  protected /*private*/ OpaquePtr<DeclGroupRef> ParseDeclOrFunctionDefInternal(final ParsedAttributesWithRange /*&*/ attrs, 
                                final ParsingDeclSpec /*&*/ DS, 
                                AccessSpecifier AS) {
    // Parse the common declaration-specifiers piece.
    $this().ParseDeclarationSpecifiers(DS, new ParsedTemplateInfo(), AS, DeclSpecContext.DSC_top_level);
    
    // If we had a free-standing type definition with a missing semicolon, we
    // may get this far before the problem becomes obvious.
    if (DS.hasTagDefinition()
       && $this().DiagnoseMissingSemiAfterTagDefinition(DS, AS, DeclSpecContext.DSC_top_level)) {
      return new OpaquePtr<DeclGroupRef>(null);
    }
    
    // C99 6.7.2.3p6: Handle "struct-or-union identifier;", "enum { X };"
    // declaration-specifiers init-declarator-list[opt] ';'
    if ($this().Tok.is(tok.TokenKind.semi)) {
      $this().ProhibitAttributes(attrs);
      $this().ConsumeToken();
      type$ref<RecordDecl> /*P*/ AnonRecord = create_type$ref((RecordDecl)null);
      Decl /*P*/ TheDecl = $this().Actions.ParsedFreeStandingDeclSpec($this().getCurScope(), AccessSpecifier.AS_none, 
          DS, AnonRecord);
      DS.complete(TheDecl);
      if (AnonRecord.$bool()) {
        Decl /*P*/ decls[/*2*/] = new Decl /*P*/ [/*2*/] {AnonRecord.$deref(), TheDecl};
        return $this().Actions.BuildDeclaratorGroup(new MutableArrayRef<Decl /*P*/ >(decls, true), /*TypeMayContainAuto=*/ false);
      }
      return $this().Actions.ConvertDeclToDeclGroup(TheDecl);
    }
    
    DS.takeAttributesFrom(attrs);
    
    // ObjC2 allows prefix attributes on class interfaces and protocols.
    // FIXME: This still needs better diagnostics. We should only accept
    // attributes here, no types, etc.
    if ($this().getLangOpts().ObjC2 && $this().Tok.is(tok.TokenKind.at)) {
      SourceLocation AtLoc = $this().ConsumeToken(); // the "@"
      if (!$this().Tok.isObjCAtKeyword(tok.ObjCKeywordKind.objc_interface)
         && !$this().Tok.isObjCAtKeyword(tok.ObjCKeywordKind.objc_protocol)) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($c$.track($this().Diag($this().Tok, diag.err_objc_unexpected_attr)));
          $this().SkipUntil(tok.TokenKind.semi); // FIXME: better skip?
          return new OpaquePtr<DeclGroupRef>(null);
        } finally {
          $c$.$destroy();
        }
      }
      
      DS.abort();
      
      /*const*/char$ptr/*char P*/ PrevSpec = create_char$null$ptr();
      /*uint*/uint$ref DiagID = create_uint$ref();
      if (DS.SetTypeSpecType(DeclSpec.TST_unspecified, new SourceLocation(AtLoc), PrevSpec, DiagID, 
          $this().Actions.getASTContext().getPrintingPolicy())) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_DiagnosticBuilder$C_char$ptr$C($c$.track($this().Diag(AtLoc, DiagID)), PrevSpec));
        } finally {
          $c$.$destroy();
        }
      }
      if ($this().Tok.isObjCAtKeyword(tok.ObjCKeywordKind.objc_protocol)) {
        return $this().ParseObjCAtProtocolDeclaration(new SourceLocation(AtLoc), DS.getAttributes());
      }
      
      return $this().Actions.ConvertDeclToDeclGroup($this().ParseObjCAtInterfaceDeclaration(new SourceLocation(AtLoc), DS.getAttributes()));
    }
    
    // If the declspec consisted only of 'extern' and we have a string
    // literal following it, this must be a C++ linkage specifier like
    // 'extern "C"'.
    if ($this().getLangOpts().CPlusPlus && $this().isTokenStringLiteral()
       && DS.getStorageClassSpec() == DeclSpec.SCS.SCS_extern
       && DS.getParsedSpecifiers() == DeclSpec.ParsedSpecifiers.PQ_StorageClassSpecifier.getValue()) {
      Decl /*P*/ TheDecl = $this().ParseLinkage(DS, Declarator.TheContext.FileContext.getValue());
      return $this().Actions.ConvertDeclToDeclGroup(TheDecl);
    }
    
    return $this().ParseDeclGroup(DS, Declarator.TheContext.FileContext.getValue());
  }

//<editor-fold defaultstate="collapsed" desc="clang::Parser::SkipFunctionBody">
@Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/Parser.cpp", line = 1181,
   FQN="clang::Parser::SkipFunctionBody", NM="_ZN5clang6Parser16SkipFunctionBodyEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/Parser.cpp -nm=_ZN5clang6Parser16SkipFunctionBodyEv")
  //</editor-fold>
  protected /*private*/ void SkipFunctionBody() {
    if ($this().Tok.is(tok.TokenKind.equal)) {
      $this().SkipUntil(tok.TokenKind.semi);
      return;
    }
    
    boolean IsFunctionTryBlock = $this().Tok.is(tok.TokenKind.kw_try);
    if (IsFunctionTryBlock) {
      $this().ConsumeToken();
    }
    
    SmallVectorToken Skipped/*J*/= new SmallVectorToken(4, /*new Token()*/(Token)null);
    if ($this().ConsumeAndStoreFunctionPrologue(Skipped)) {
      $this().SkipMalformedDecl();
    } else {
      $this().SkipUntil(tok.TokenKind.r_brace);
      while (IsFunctionTryBlock && $this().Tok.is(tok.TokenKind.kw_catch)) {
        $this().SkipUntil(tok.TokenKind.l_brace);
        $this().SkipUntil(tok.TokenKind.r_brace);
      }
    }
  }


/// ParseFunctionDefinition - We parsed and verified that the specified
/// Declarator is well formed.  If this is a K&R-style function, read the
/// parameters declaration-list, then start the compound-statement.
///
///       function-definition: [C99 6.9.1]
///         decl-specs      declarator declaration-list[opt] compound-statement
/// [C90] function-definition: [C99 6.7.1] - implicit int result
/// [C90]   decl-specs[opt] declarator declaration-list[opt] compound-statement
/// [C++] function-definition: [C++ 8.4]
///         decl-specifier-seq[opt] declarator ctor-initializer[opt]
///         function-body
/// [C++] function-definition: [C++ 8.4]
///         decl-specifier-seq[opt] declarator function-try-block
///
//<editor-fold defaultstate="collapsed" desc="clang::Parser::ParseFunctionDefinition">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/Parser.cpp", line = 979,
   FQN="clang::Parser::ParseFunctionDefinition", NM="_ZN5clang6Parser23ParseFunctionDefinitionERNS_17ParsingDeclaratorERKNS0_18ParsedTemplateInfoEPNS0_18LateParsedAttrListE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/Parser.cpp -nm=_ZN5clang6Parser23ParseFunctionDefinitionERNS_17ParsingDeclaratorERKNS0_18ParsedTemplateInfoEPNS0_18LateParsedAttrListE")
  //</editor-fold>
  protected /*private*/ Decl /*P*/ ParseFunctionDefinition(final ParsingDeclarator /*&*/ D) {
    return $this().ParseFunctionDefinition(D, 
                         new ParsedTemplateInfo(), 
                         (LateParsedAttrList /*P*/ )null);
  }
  protected /*private*/ Decl /*P*/ ParseFunctionDefinition(final ParsingDeclarator /*&*/ D, 
                         final /*const*/ ParsedTemplateInfo /*&*/ TemplateInfo/*= ParsedTemplateInfo()*/) {
    return $this().ParseFunctionDefinition(D, 
                         TemplateInfo, 
                         (LateParsedAttrList /*P*/ )null);
  }
  protected /*private*/ Decl /*P*/ ParseFunctionDefinition(final ParsingDeclarator /*&*/ D, 
                         final /*const*/ ParsedTemplateInfo /*&*/ TemplateInfo/*= ParsedTemplateInfo()*/, 
                         LateParsedAttrList /*P*/ LateParsedAttrs/*= null*/) {
    PoisonSEHIdentifiersRAIIObject PoisonSEHIdentifiers = null;
    ParseScope BodyScope = null;
    try {
      // Poison SEH identifiers so they are flagged as illegal in function bodies.
      PoisonSEHIdentifiers/*J*/= new PoisonSEHIdentifiersRAIIObject(/*Deref*/$this(), true);
      final /*const*/ DeclaratorChunk.FunctionTypeInfo /*&*/ FTI = D.getFunctionTypeInfo();
      
      // If this is C90 and the declspecs were completely missing, fudge in an
      // implicit int.  We do this here because this is the only place where
      // declaration-specifiers are completely optional in the grammar.
      if ($this().getLangOpts().ImplicitInt && D.getDeclSpec().isEmpty()) {
        /*const*/char$ptr/*char P*/ PrevSpec = create_char$null$ptr();
        /*uint*/uint$ref DiagID = create_uint$ref();
        final /*const*/ PrintingPolicy /*&*/ Policy = $this().Actions.getASTContext().getPrintingPolicy();
        D.getMutableDeclSpec().SetTypeSpecType(DeclSpec.TST_int, 
            D.getIdentifierLoc(), 
            PrevSpec, DiagID, 
            Policy);
        D.SetRangeBegin(D.getDeclSpec().getSourceRange().getBegin());
      }
      
      // If this declaration was formed with a K&R-style identifier list for the
      // arguments, parse declarations for all of the args next.
      // int foo(a,b) int a; float b; {}
      if (FTI.isKNRPrototype()) {
        $this().ParseKNRParamDeclarations(D);
      }
      
      // We should have either an opening brace or, in a C++ constructor,
      // we may have a colon.
      if ($this().Tok.isNot(tok.TokenKind.l_brace)
         && (!$this().getLangOpts().CPlusPlus
         || ($this().Tok.isNot(tok.TokenKind.colon) && $this().Tok.isNot(tok.TokenKind.kw_try)
         && $this().Tok.isNot(tok.TokenKind.equal)))) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($c$.track($this().Diag($this().Tok, diag.err_expected_fn_body)));
          
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
      
      // Check to make sure that any normal attributes are allowed to be on
      // a definition.  Late parsed attributes are checked at the end.
      if ($this().Tok.isNot(tok.TokenKind.equal)) {
        AttributeList /*P*/ DtorAttrs = D.getAttributes();
        while ((DtorAttrs != null)) {
          if (DtorAttrs.isKnownToGCC()
             && !DtorAttrs.isCXX11Attribute()) {
            JavaCleaner $c$ = $createJavaCleaner();
            try {
              $c$.clean($out_DiagnosticBuilder$C_IdentifierInfo$C$P($c$.track($this().Diag(DtorAttrs.getLoc(), diag.warn_attribute_on_function_definition)), 
                  DtorAttrs.getName()));
            } finally {
              $c$.$destroy();
            }
          }
          DtorAttrs = DtorAttrs.getNext();
        }
      }
      
      // In delayed template parsing mode, for function template we consume the
      // tokens and store them for late parsing at the end of the translation unit.
      if ($this().getLangOpts().DelayedTemplateParsing && $this().Tok.isNot(tok.TokenKind.equal)
         && TemplateInfo.Kind == ParsedTemplateInfo.Unnamed_enum.Template
         && $this().Actions.canDelayFunctionBody(D)) {
        ParseScope _BodyScope = null;
        try {
          MutableArrayRef<TemplateParameterList /*P*/ > TemplateParameterLists/*J*/= new MutableArrayRef<TemplateParameterList /*P*/ >($Deref(TemplateInfo.TemplateParams));
          
          _BodyScope/*J*/= new ParseScope($this(), Scope.ScopeFlags.FnScope | Scope.ScopeFlags.DeclScope);
          Scope /*P*/ ParentScope = $this().getCurScope().getParent();
          
          D.setFunctionDefinitionKind(FunctionDefinitionKind.FDK_Definition);
          Decl /*P*/ DP = $this().Actions.HandleDeclarator(ParentScope, D, 
              new MutableArrayRef<TemplateParameterList /*P*/ >(TemplateParameterLists));
          D.complete(DP);
          D.getMutableDeclSpec().abort();
          if ($this().SkipFunctionBodies && (!(DP != null) || $this().Actions.canSkipFunctionBody(DP))
             && $this().trySkippingFunctionBody()) {
            _BodyScope.Exit();
            return $this().Actions.ActOnSkippedFunctionBody(DP);
          }
          
          SmallVectorToken Toks/*J*/= new SmallVectorToken(4, /*new Token()*/(Token)null);
          $this().LexTemplateFunctionForLateParsing(Toks);
          if ((DP != null)) {
            FunctionDecl /*P*/ FnD = DP.getAsFunction();
            $this().Actions.CheckForFunctionRedefinition(FnD);
            $this().Actions.MarkAsLateParsedTemplate(FnD, DP, Toks);
          }
          return DP;
        } finally {
          if (_BodyScope != null) { _BodyScope.$destroy(); }
        }
      } else if (($this().CurParsedObjCImpl != null)
         && !(TemplateInfo.TemplateParams != null)
         && ($this().Tok.is(tok.TokenKind.l_brace) || $this().Tok.is(tok.TokenKind.kw_try)
         || $this().Tok.is(tok.TokenKind.colon))
         && $this().Actions.CurContext.isTranslationUnit()) {
        ParseScope _BodyScope = null;
        try {
          _BodyScope/*J*/= new ParseScope($this(), Scope.ScopeFlags.FnScope | Scope.ScopeFlags.DeclScope);
          Scope /*P*/ ParentScope = $this().getCurScope().getParent();
          
          D.setFunctionDefinitionKind(FunctionDefinitionKind.FDK_Definition);
          Decl /*P*/ FuncDecl = $this().Actions.HandleDeclarator(ParentScope, D, 
              MutableArrayRef.<TemplateParameterList /*P*/ >None());
          D.complete(FuncDecl);
          D.getMutableDeclSpec().abort();
          if ((FuncDecl != null)) {
            // Consume the tokens and store them for later parsing.
            $this().StashAwayMethodOrFunctionBodyTokens(FuncDecl);
            $this().CurParsedObjCImpl.HasCFunction = true;
            return FuncDecl;
          }
        } finally {
          if (_BodyScope != null) { _BodyScope.$destroy(); }
        }
        // FIXME: Should we really fall through here?
      }
      
      // Enter a scope for the function body.
      BodyScope/*J*/= new ParseScope($this(), Scope.ScopeFlags.FnScope | Scope.ScopeFlags.DeclScope);
      
      // Tell the actions module that we have entered a function definition with the
      // specified Declarator for the function.
      Sema.SkipBodyInfo SkipBody/*J*/= new Sema.SkipBodyInfo();
      Decl /*P*/ Res = $this().Actions.ActOnStartOfFunctionDef($this().getCurScope(), D, 
          (TemplateInfo.TemplateParams != null) ? new MutableArrayRef<TemplateParameterList /*P*/ >($Deref(TemplateInfo.TemplateParams)) : MutableArrayRef.<TemplateParameterList /*P*/ >None(), 
          $AddrOf(SkipBody));
      if (SkipBody.ShouldSkip) {
        $this().SkipFunctionBody();
        return Res;
      }
      
      // Break out of the ParsingDeclarator context before we parse the body.
      D.complete(Res);
      
      // Break out of the ParsingDeclSpec context, too.  This const_cast is
      // safe because we're always the sole owner.
      D.getMutableDeclSpec().abort();
      if ($this().TryConsumeToken(tok.TokenKind.equal)) {
        assert ($this().getLangOpts().CPlusPlus) : "Only C++ function definitions have '='";
        
        boolean Delete = false;
        SourceLocation KWLoc/*J*/= new SourceLocation();
        if ($this().TryConsumeToken(tok.TokenKind.kw_delete, KWLoc)) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            $c$.clean($out_DiagnosticBuilder$C_int($c$.track($this().Diag(new SourceLocation(KWLoc), $this().getLangOpts().CPlusPlus11 ? diag.warn_cxx98_compat_defaulted_deleted_function : diag.ext_defaulted_deleted_function)), 
                1/* deleted */));
            $this().Actions.SetDeclDeleted(Res, new SourceLocation(KWLoc));
            Delete = true;
          } finally {
            $c$.$destroy();
          }
        } else if ($this().TryConsumeToken(tok.TokenKind.kw_default, KWLoc)) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            $c$.clean($out_DiagnosticBuilder$C_int($c$.track($this().Diag(new SourceLocation(KWLoc), $this().getLangOpts().CPlusPlus11 ? diag.warn_cxx98_compat_defaulted_deleted_function : diag.ext_defaulted_deleted_function)), 
                0/* defaulted */));
            $this().Actions.SetDeclDefaulted(Res, new SourceLocation(KWLoc));
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
        
        Stmt /*P*/ GeneratedBody = (Res != null) ? Res.getBody() : null;
        $this().Actions.ActOnFinishFunctionBody(Res, GeneratedBody, false);
        return Res;
      }
      if ($this().SkipFunctionBodies && (!(Res != null) || $this().Actions.canSkipFunctionBody(Res))
         && $this().trySkippingFunctionBody()) {
        BodyScope.Exit();
        $this().Actions.ActOnSkippedFunctionBody(Res);
        return $this().Actions.ActOnFinishFunctionBody(Res, (Stmt /*P*/ )null, false);
      }
      if ($this().Tok.is(tok.TokenKind.kw_try)) {
        return $this().ParseFunctionTryBlock(Res, BodyScope);
      }
      
      // If we have a colon, then we're probably parsing a C++
      // ctor-initializer.
      if ($this().Tok.is(tok.TokenKind.colon)) {
        $this().ParseConstructorInitializer(Res);
        
        // Recover from error.
        if (!$this().Tok.is(tok.TokenKind.l_brace)) {
          BodyScope.Exit();
          $this().Actions.ActOnFinishFunctionBody(Res, (Stmt /*P*/ )null);
          return Res;
        }
      } else {
        $this().Actions.ActOnDefaultCtorInitializers(Res);
      }
      
      // Late attributes are parsed in the same scope as the function body.
      if ((LateParsedAttrs != null)) {
        $this().ParseLexedAttributeList($Deref(LateParsedAttrs), Res, false, true);
      }
      
      return $this().ParseFunctionStatementBody(Res, BodyScope);
    } finally {
      if (BodyScope != null) { BodyScope.$destroy(); }
      if (PoisonSEHIdentifiers != null) { PoisonSEHIdentifiers.$destroy(); }
    }
  }


/// ParseKNRParamDeclarations - Parse 'declaration-list[opt]' which provides
/// types for a function with a K&R-style identifier list for arguments.
//<editor-fold defaultstate="collapsed" desc="clang::Parser::ParseKNRParamDeclarations">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/Parser.cpp", line = 1205,
   FQN="clang::Parser::ParseKNRParamDeclarations", NM="_ZN5clang6Parser25ParseKNRParamDeclarationsERNS_10DeclaratorE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/Parser.cpp -nm=_ZN5clang6Parser25ParseKNRParamDeclarationsERNS_10DeclaratorE")
  //</editor-fold>
  protected /*private*/ void ParseKNRParamDeclarations(final Declarator /*&*/ D) {
    ParseScope PrototypeScope = null;
    try {
      // We know that the top-level of this declarator is a function.
      final DeclaratorChunk.FunctionTypeInfo /*&*/ FTI = D.getFunctionTypeInfo();
      
      // Enter function-declaration scope, limiting any declarators to the
      // function prototype scope, including parameter declarators.
      PrototypeScope/*J*/= new ParseScope($this(), Scope.ScopeFlags.FunctionPrototypeScope
             | Scope.ScopeFlags.FunctionDeclarationScope | Scope.ScopeFlags.DeclScope);
      
      // Read all the argument declarations.
      while ($this().isDeclarationSpecifier()) {
        DeclSpec DS = null;
        Declarator ParmDeclarator = null;
        try {
          SourceLocation DSStart = $this().Tok.getLocation();
          
          // Parse the common declaration-specifiers piece.
          DS/*J*/= new DeclSpec($this().AttrFactory);
          $this().ParseDeclarationSpecifiers(DS);
          
          // C99 6.9.1p6: 'each declaration in the declaration list shall have at
          // least one declarator'.
          // NOTE: GCC just makes this an ext-warn.  It's not clear what it does with
          // the declarations though.  It's trivial to ignore them, really hard to do
          // anything else with them.
          if ($this().TryConsumeToken(tok.TokenKind.semi)) {
            JavaCleaner $c$ = $createJavaCleaner();
            try {
              $c$.clean($c$.track($this().Diag(new SourceLocation(DSStart), diag.err_declaration_does_not_declare_param)));
              continue;
            } finally {
              $c$.$destroy();
            }
          }
          
          // C99 6.9.1p6: Declarations shall contain no storage-class specifiers other
          // than register.
          if (DS.getStorageClassSpec() != DeclSpec.SCS.SCS_unspecified
             && DS.getStorageClassSpec() != DeclSpec.SCS.SCS_register) {
            JavaCleaner $c$ = $createJavaCleaner();
            try {
              $c$.clean($c$.track($this().Diag(DS.getStorageClassSpecLoc(), 
                  diag.err_invalid_storage_class_in_func_decl)));
              DS.ClearStorageClassSpecs();
            } finally {
              $c$.$destroy();
            }
          }
          if (DS.getThreadStorageClassSpec() != DeclSpec.TSCS_unspecified) {
            JavaCleaner $c$ = $createJavaCleaner();
            try {
              $c$.clean($c$.track($this().Diag(DS.getThreadStorageClassSpecLoc(), 
                  diag.err_invalid_storage_class_in_func_decl)));
              DS.ClearStorageClassSpecs();
            } finally {
              $c$.$destroy();
            }
          }
          
          // Parse the first declarator attached to this declspec.
          ParmDeclarator/*J*/= new Declarator(DS, Declarator.TheContext.KNRTypeListContext);
          $this().ParseDeclarator(ParmDeclarator);
          
          // Handle the full declarator list.
          while (true) {
            // If attributes are present, parse them.
            $this().MaybeParseGNUAttributes(ParmDeclarator);
            
            // Ask the actions module to compute the type for this declarator.
            Decl /*P*/ Param = $this().Actions.ActOnParamDeclarator($this().getCurScope(), ParmDeclarator);
            if ((Param != null)
              // A missing identifier has already been diagnosed.
               && (ParmDeclarator.getIdentifier() != null)) {
              
              // Scan the argument list looking for the correct param to apply this
              // type.
              for (/*uint*/int i = 0;; ++i) {
                // C99 6.9.1p6: those declarators shall declare only identifiers from
                // the identifier list.
                if (i == FTI.NumParams) {
                  JavaCleaner $c$ = $createJavaCleaner();
                  try {
                    $c$.clean($out_DiagnosticBuilder$C_IdentifierInfo$C$P($c$.track($this().Diag(ParmDeclarator.getIdentifierLoc(), diag.err_no_matching_param)), 
                        ParmDeclarator.getIdentifier()));
                    break;
                  } finally {
                    $c$.$destroy();
                  }
                }
                if (FTI.Params.$at(i).Ident == ParmDeclarator.getIdentifier()) {
                  // Reject redefinitions of parameters.
                  if ((FTI.Params.$at(i).Param != null)) {
                    JavaCleaner $c$ = $createJavaCleaner();
                    try {
                      $c$.clean($out_DiagnosticBuilder$C_IdentifierInfo$C$P($c$.track($this().Diag(ParmDeclarator.getIdentifierLoc(), 
                              diag.err_param_redefinition)), 
                          ParmDeclarator.getIdentifier()));
                    } finally {
                      $c$.$destroy();
                    }
                  } else {
                    FTI.Params.$at(i).Param = Param;
                  }
                  break;
                }
              }
            }
            
            // If we don't have a comma, it is either the end of the list (a ';') or
            // an error, bail out.
            if ($this().Tok.isNot(tok.TokenKind.comma)) {
              break;
            }
            
            ParmDeclarator.clear$Declarator();
            
            // Consume the comma.
            ParmDeclarator.setCommaLoc($this().ConsumeToken());
            
            // Parse the next declarator.
            $this().ParseDeclarator(ParmDeclarator);
          }
          
          // Consume ';' and continue parsing.
          if (!$this().ExpectAndConsumeSemi(diag.err_expected_semi_declaration)) {
            continue;
          }
          
          // Otherwise recover by skipping to next semi or mandatory function body.
          if ($this().SkipUntil(tok.TokenKind.l_brace, $bitor_SkipUntilFlags(/*KEEP_ENUM*/SkipUntilFlags.StopAtSemi, /*KEEP_ENUM*/SkipUntilFlags.StopBeforeMatch))) {
            break;
          }
          $this().TryConsumeToken(tok.TokenKind.semi);
        } finally {
          if (ParmDeclarator != null) { ParmDeclarator.$destroy(); }
          if (DS != null) { DS.$destroy(); }
        }
      }
      
      // The actions module must verify that all arguments were declared.
      $this().Actions.ActOnFinishKNRParamDeclarations($this().getCurScope(), D, $this().Tok.getLocation());
    } finally {
      if (PrototypeScope != null) { PrototypeScope.$destroy(); }
    }
  }

// EndLoc, if non-NULL, is filled with the location of the last token of
// the simple-asm.

/// ParseSimpleAsm
///
/// [GNU] simple-asm-expr:
///         'asm' '(' asm-string-literal ')'
///
//<editor-fold defaultstate="collapsed" desc="clang::Parser::ParseSimpleAsm">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*changed param to final ref*/,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/Parser.cpp", line = 1348,
   FQN="clang::Parser::ParseSimpleAsm", NM="_ZN5clang6Parser14ParseSimpleAsmEPNS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/Parser.cpp -nm=_ZN5clang6Parser14ParseSimpleAsmEPNS_14SourceLocationE")
  //</editor-fold>
  protected /*private*/ ActionResultTTrue<Expr /*P*/ > ParseSimpleAsm() {
    return $this().ParseSimpleAsm((SourceLocation/*P*/ )null);
  }
  protected /*private*/ ActionResultTTrue<Expr /*P*/ > ParseSimpleAsm(final SourceLocation /*P*/ EndLoc/*= null*/) {
    BalancedDelimiterTracker T = null;
    try {
      assert ($this().Tok.is(tok.TokenKind.kw_asm)) : "Not an asm!";
      SourceLocation Loc = $this().ConsumeToken();
      if ($this().Tok.is(tok.TokenKind.kw_volatile)) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          // Remove from the end of 'asm' to the end of 'volatile'.
          SourceRange RemovalRange/*J*/= new SourceRange($this().PP.getLocForEndOfToken(/*NO_COPY*/Loc), 
              $this().PP.getLocForEndOfToken($this().Tok.getLocation()));
          
          $c$.clean($out_DiagnosticBuilder$C_FixItHint$C($c$.track($this().Diag($this().Tok, diag.warn_file_asm_volatile)), 
              FixItHint.CreateRemoval(/*NO_COPY*/RemovalRange)));
          $this().ConsumeToken();
        } finally {
          $c$.$destroy();
        }
      }
      
      T/*J*/= new BalancedDelimiterTracker(/*Deref*/$this(), tok.TokenKind.l_paren);
      if (T.consumeOpen()) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_DiagnosticBuilder$C_char$ptr$C($c$.track($this().Diag($this().Tok, diag.err_expected_lparen_after)), /*KEEP_STR*/$asm));
          return ExprError();
        } finally {
          $c$.$destroy();
        }
      }
      
      ActionResultTTrue<Expr /*P*/ > Result/*J*/= $this().ParseAsmStringLiteral();
      if (!Result.isInvalid()) {
        // Close the paren and get the location of the end bracket
        T.consumeClose();
        if ((EndLoc != null)) {
          EndLoc.$assignMove(T.getCloseLocation());
        }
      } else if ($this().SkipUntil(tok.TokenKind.r_paren, $bitor_SkipUntilFlags(/*KEEP_ENUM*/SkipUntilFlags.StopAtSemi, /*KEEP_ENUM*/SkipUntilFlags.StopBeforeMatch))) {
        if ((EndLoc != null)) {
          EndLoc.$assignMove($this().Tok.getLocation());
        }
        $this().ConsumeParen();
      }
      
      return Result;
    } finally {
      if (T != null) { T.$destroy(); }
    }
  }


/// ParseAsmStringLiteral - This is just a normal string-literal, but is not
/// allowed to be a wide string, and is not subject to character translation.
///
/// [GNU] asm-string-literal:
///         string-literal
///
//<editor-fold defaultstate="collapsed" desc="clang::Parser::ParseAsmStringLiteral">
@Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/Parser.cpp", line = 1323,
   FQN="clang::Parser::ParseAsmStringLiteral", NM="_ZN5clang6Parser21ParseAsmStringLiteralEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/Parser.cpp -nm=_ZN5clang6Parser21ParseAsmStringLiteralEv")
  //</editor-fold>
  protected /*private*/ ActionResultTTrue<Expr /*P*/ > ParseAsmStringLiteral() {
    if (!$this().isTokenStringLiteral()) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_DiagnosticBuilder$C_char$ptr$C($out_DiagnosticBuilder$C_int($c$.track($this().Diag($this().Tok, diag.err_expected_string_literal)), 
                /*Source='in...'*/ 0), /*KEEP_STR*/"'asm'"));
        return ExprError();
      } finally {
        $c$.$destroy();
      }
    }
    
    ActionResultTTrue<Expr /*P*/ > AsmString/*J*/= $this().ParseStringLiteralExpression();
    if (!AsmString.isInvalid()) {
      /*const*/ StringLiteral /*P*/ SL = cast(StringLiteral.class, AsmString.get());
      if (!SL.isAscii()) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_DiagnosticBuilder$C_SourceRange($out$Same2Bool($c$.track($this().Diag($this().Tok, diag.err_asm_operand_wide_string_literal)), 
                  SL.isWide()), 
              SL.getSourceRange()));
          return ExprError();
        } finally {
          $c$.$destroy();
        }
      }
    }
    return AsmString;
  }

//<editor-fold defaultstate="collapsed" desc="clang::Parser::ParseMicrosoftIfExistsCondition">
@Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/Parser.cpp", line = 1909,
   FQN="clang::Parser::ParseMicrosoftIfExistsCondition", NM="_ZN5clang6Parser31ParseMicrosoftIfExistsConditionERNS0_17IfExistsConditionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/Parser.cpp -nm=_ZN5clang6Parser31ParseMicrosoftIfExistsConditionERNS0_17IfExistsConditionE")
  //</editor-fold>
  protected /*private*/ boolean ParseMicrosoftIfExistsCondition(final IfExistsCondition /*&*/ Result) {
    BalancedDelimiterTracker T = null;
    try {
      assert (($this().Tok.is(tok.TokenKind.kw___if_exists) || $this().Tok.is(tok.TokenKind.kw___if_not_exists))) : "Expected '__if_exists' or '__if_not_exists'";
      Result.IsIfExists = $this().Tok.is(tok.TokenKind.kw___if_exists);
      Result.KeywordLoc.$assignMove($this().ConsumeToken());
      
      T/*J*/= new BalancedDelimiterTracker(/*Deref*/$this(), tok.TokenKind.l_paren);
      if (T.consumeOpen()) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_DiagnosticBuilder$C_char$ptr$C($c$.track($this().Diag($this().Tok, diag.err_expected_lparen_after)), 
              (Result.IsIfExists ? $__if_exists : $__if_not_exists)));
          return true;
        } finally {
          $c$.$destroy();
        }
      }
      
      // Parse nested-name-specifier.
      if ($this().getLangOpts().CPlusPlus) {
        $this().ParseOptionalCXXScopeSpecifier(Result.SS, new OpaquePtr<QualType>(null), 
            /*EnteringContext=*/ false);
      }
      
      // Check nested-name specifier.
      if (Result.SS.isInvalid()) {
        T.skipToEnd();
        return true;
      }
      
      // Parse the unqualified-id.
      SourceLocation TemplateKWLoc/*J*/= new SourceLocation(); // FIXME: parsed, but unused.
      if ($this().ParseUnqualifiedId(Result.SS, false, true, true, new OpaquePtr<QualType>(null), TemplateKWLoc, 
          Result.Name)) {
        T.skipToEnd();
        return true;
      }
      if (T.consumeClose()) {
        return true;
      }
      
      // Check if the symbol exists.
      switch ($this().Actions.CheckMicrosoftIfExistsSymbol($this().getCurScope(), new SourceLocation(Result.KeywordLoc), 
          Result.IsIfExists, Result.SS, 
          Result.Name)) {
       case IER_Exists:
        Result.Behavior = Result.IsIfExists ? IfExistsBehavior.IEB_Parse : IfExistsBehavior.IEB_Skip;
        break;
       case IER_DoesNotExist:
        Result.Behavior = !Result.IsIfExists ? IfExistsBehavior.IEB_Parse : IfExistsBehavior.IEB_Skip;
        break;
       case IER_Dependent:
        Result.Behavior = IfExistsBehavior.IEB_Dependent;
        break;
       case IER_Error:
        return true;
      }
      
      return false;
    } finally {
      if (T != null) { T.$destroy(); }
    }
  }

//<editor-fold defaultstate="collapsed" desc="clang::Parser::ParseMicrosoftIfExistsExternalDeclaration">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/Parser.cpp", line = 1967,
   FQN="clang::Parser::ParseMicrosoftIfExistsExternalDeclaration", NM="_ZN5clang6Parser41ParseMicrosoftIfExistsExternalDeclarationEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/Parser.cpp -nm=_ZN5clang6Parser41ParseMicrosoftIfExistsExternalDeclarationEv")
  //</editor-fold>
  protected /*private*/ void ParseMicrosoftIfExistsExternalDeclaration() {
    IfExistsCondition Result = null;
    BalancedDelimiterTracker Braces = null;
    try {
      Result/*J*/= new IfExistsCondition();
      if ($this().ParseMicrosoftIfExistsCondition(Result)) {
        return;
      }
      
      Braces/*J*/= new BalancedDelimiterTracker(/*Deref*/$this(), tok.TokenKind.l_brace);
      if (Braces.consumeOpen()) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_DiagnosticBuilder$C_TokenKind($c$.track($this().Diag($this().Tok, diag.err_expected)), tok.TokenKind.l_brace));
          return;
        } finally {
          $c$.$destroy();
        }
      }
      switch (Result.Behavior) {
       case IEB_Parse:
        // Parse declarations below.
        break;
       case IEB_Dependent:
        throw new llvm_unreachable("Cannot have a dependent external declaration");
       case IEB_Skip:
        Braces.skipToEnd();
        return;
      }
      
      // Parse the declarations.
      // FIXME: Support module import within __if_exists?
      while ($this().Tok.isNot(tok.TokenKind.r_brace) && !$this().isEofOrEom()) {
        ParsedAttributesWithRange attrs = null;
        try {
          attrs/*J*/= new ParsedAttributesWithRange($this().AttrFactory);
          $this().MaybeParseCXX11Attributes(attrs);
          $this().MaybeParseMicrosoftAttributes(attrs);
          OpaquePtr<DeclGroupRef> _Result = $this().ParseExternalDeclaration(attrs);
          if (_Result.$bool() && !($this().getCurScope().getParent() != null)) {
            $this().Actions.getASTConsumer().HandleTopLevelDecl(_Result.getDeclGroupRef());
          }
        } finally {
          if (attrs != null) { attrs.$destroy(); }
        }
      }
      Braces.consumeClose();
    } finally {
      if (Braces != null) { Braces.$destroy(); }
      if (Result != null) { Result.$destroy(); }
    }
  }


//===--------------------------------------------------------------------===//
// Modules
//<editor-fold defaultstate="collapsed" desc="clang::Parser::ParseModuleImport">
@Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/Parser.cpp", line = 2004,
   FQN="clang::Parser::ParseModuleImport", NM="_ZN5clang6Parser17ParseModuleImportENS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/Parser.cpp -nm=_ZN5clang6Parser17ParseModuleImportENS_14SourceLocationE")
  //</editor-fold>
  protected /*private*/ OpaquePtr<DeclGroupRef> ParseModuleImport(SourceLocation AtLoc) {
    assert ($this().Tok.isObjCAtKeyword(tok.ObjCKeywordKind.objc_import)) : "Improper start to module import";
    SourceLocation ImportLoc = $this().ConsumeToken();
    
    SmallVector<std.pair<IdentifierInfo /*P*/ , SourceLocation>> Path/*J*/= new SmallVector<std.pair<IdentifierInfo /*P*/ , SourceLocation>>(2, new std.pairPtrType<IdentifierInfo /*P*/ , SourceLocation>(null, new SourceLocation()));
    
    // Parse the module path.
    do {
      if (!$this().Tok.is(tok.TokenKind.identifier)) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          if ($this().Tok.is(tok.TokenKind.code_completion)) {
            $this().Actions.CodeCompleteModuleImport(new SourceLocation(ImportLoc), new ModuleIdPath(Path));
            $this().cutOffParsing();
            return new OpaquePtr<DeclGroupRef>(null);
          }
          
          $c$.clean($c$.track($this().Diag($this().Tok, diag.err_module_expected_ident)));
          $this().SkipUntil(tok.TokenKind.semi);
          return new OpaquePtr<DeclGroupRef>(null);
        } finally {
          $c$.$destroy();
        }
      }
      
      // Record this part of the module path.
      Path.push_back(std.make_pair_Ptr_T($this().Tok.getIdentifierInfo(), $this().Tok.getLocation()));
      $this().ConsumeToken();
      if ($this().Tok.is(tok.TokenKind.period)) {
        $this().ConsumeToken();
        continue;
      }
      
      break;
    } while (true);
    if ($this().PP.hadModuleLoaderFatalFailure()) {
      // With a fatal failure in the module loader, we abort parsing.
      $this().cutOffParsing();
      return new OpaquePtr<DeclGroupRef>(null);
    }
    
    ActionResult<Decl /*P*/ > Import = $this().Actions.ActOnModuleImport(new SourceLocation(AtLoc), new SourceLocation(ImportLoc), new ModuleIdPath(Path));
    $this().ExpectAndConsumeSemi(diag.err_module_expected_semi);
    if (Import.isInvalid()) {
      return new OpaquePtr<DeclGroupRef>(null);
    }
    
    return $this().Actions.ConvertDeclToDeclGroup(Import.get());
  }


/// \brief Try recover parser when module annotation appears where it must not
/// be found.
/// \returns false if the recover was successful and parsing may be continued, or
/// true if parser must bail out to top level and handle the token there.
//<editor-fold defaultstate="collapsed" desc="clang::Parser::parseMisplacedModuleImport">
@Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/Parser.cpp", line = 2055,
   FQN="clang::Parser::parseMisplacedModuleImport", NM="_ZN5clang6Parser26parseMisplacedModuleImportEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/Parser.cpp -nm=_ZN5clang6Parser26parseMisplacedModuleImportEv")
  //</editor-fold>
  protected /*private*/ boolean parseMisplacedModuleImport() {
    while (true) {
      switch ($this().Tok.getKind()) {
       case tok.TokenKind.annot_module_end:
        // Inform caller that recovery failed, the error must be handled at upper
        // level.
        return true;
       case tok.TokenKind.annot_module_begin:
        $this().Actions.diagnoseMisplacedModuleImport(reinterpret_cast(Module /*P*/ .class, $this().Tok.getAnnotationValue()), $this().Tok.getLocation());
        return true;
       case tok.TokenKind.annot_module_include:
        // Module import found where it should not be, for instance, inside a
        // namespace. Recover by importing the module.
        $this().Actions.ActOnModuleInclude($this().Tok.getLocation(), 
            reinterpret_cast(Module /*P*/ .class, $this().Tok.getAnnotationValue()));
        $this().ConsumeToken();
        // If there is another module import, process it.
        continue;
       default:
        return false;
      }
    }
    //return false;
  }


//===--------------------------------------------------------------------===//
// Preprocessor code-completion pass-through

// Code-completion pass-through functions
//<editor-fold defaultstate="collapsed" desc="clang::Parser::CodeCompleteDirective">
@Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/Parser.cpp", line = 1882,
   FQN="clang::Parser::CodeCompleteDirective", NM="_ZN5clang6Parser21CodeCompleteDirectiveEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/Parser.cpp -nm=_ZN5clang6Parser21CodeCompleteDirectiveEb")
  //</editor-fold>
  @Override public/*private*/ void CodeCompleteDirective(boolean InConditional)/* override*/ {
    $this().Actions.CodeCompletePreprocessorDirective(InConditional);
  }

//<editor-fold defaultstate="collapsed" desc="clang::Parser::CodeCompleteInConditionalExclusion">
@Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/Parser.cpp", line = 1886,
   FQN="clang::Parser::CodeCompleteInConditionalExclusion", NM="_ZN5clang6Parser34CodeCompleteInConditionalExclusionEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/Parser.cpp -nm=_ZN5clang6Parser34CodeCompleteInConditionalExclusionEv")
  //</editor-fold>
  @Override public/*private*/ void CodeCompleteInConditionalExclusion()/* override*/ {
    $this().Actions.CodeCompleteInPreprocessorConditionalExclusion($this().getCurScope());
  }

//<editor-fold defaultstate="collapsed" desc="clang::Parser::CodeCompleteMacroName">
@Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/Parser.cpp", line = 1890,
   FQN="clang::Parser::CodeCompleteMacroName", NM="_ZN5clang6Parser21CodeCompleteMacroNameEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/Parser.cpp -nm=_ZN5clang6Parser21CodeCompleteMacroNameEb")
  //</editor-fold>
  @Override public/*private*/ void CodeCompleteMacroName(boolean IsDefinition)/* override*/ {
    $this().Actions.CodeCompletePreprocessorMacroName(IsDefinition);
  }

//<editor-fold defaultstate="collapsed" desc="clang::Parser::CodeCompletePreprocessorExpression">
@Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/Parser.cpp", line = 1894,
   FQN="clang::Parser::CodeCompletePreprocessorExpression", NM="_ZN5clang6Parser34CodeCompletePreprocessorExpressionEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/Parser.cpp -nm=_ZN5clang6Parser34CodeCompletePreprocessorExpressionEv")
  //</editor-fold>
  @Override public/*private*/ void CodeCompletePreprocessorExpression()/* override*/ {
    $this().Actions.CodeCompletePreprocessorExpression();
  }

//<editor-fold defaultstate="collapsed" desc="clang::Parser::CodeCompleteMacroArgument">
@Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/Parser.cpp", line = 1898,
   FQN="clang::Parser::CodeCompleteMacroArgument", NM="_ZN5clang6Parser25CodeCompleteMacroArgumentEPNS_14IdentifierInfoEPNS_9MacroInfoEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/Parser.cpp -nm=_ZN5clang6Parser25CodeCompleteMacroArgumentEPNS_14IdentifierInfoEPNS_9MacroInfoEj")
  //</editor-fold>
  @Override public/*private*/ void CodeCompleteMacroArgument(IdentifierInfo /*P*/ Macro, 
                           MacroInfo /*P*/ MacroInfo, 
                           /*uint*/int ArgumentIndex)/* override*/ {
    $this().Actions.CodeCompletePreprocessorMacroArgument($this().getCurScope(), Macro, MacroInfo, 
        ArgumentIndex);
  }

//<editor-fold defaultstate="collapsed" desc="clang::Parser::CodeCompleteNaturalLanguage">
@Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/Parser.cpp", line = 1905,
   FQN="clang::Parser::CodeCompleteNaturalLanguage", NM="_ZN5clang6Parser27CodeCompleteNaturalLanguageEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/Parser.cpp -nm=_ZN5clang6Parser27CodeCompleteNaturalLanguageEv")
  //</editor-fold>
  @Override public/*private*/ void CodeCompleteNaturalLanguage()/* override*/ {
    $this().Actions.CodeCompleteNaturalLanguage();
  }

} // END OF class Parser_Parser
