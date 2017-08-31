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
import static org.llvm.adt.ADTAliases.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.clank.support.NativeCallback.*;
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
import static org.clang.parse.impl.ParseOpenMPStatics.*;


//<editor-fold defaultstate="collapsed" desc="static type Parser_ParseOpenMP">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -empty-body -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType -split-class=clang::Parser@this -extends=Parser_ParseObjc ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseOpenMP.cpp -nm=_ZN5clang6Parser17ParseOpenMPClauseENS_16OpenMPClauseKindE;_ZN5clang6Parser17ParseOpenMPClauseENS_19OpenMPDirectiveKindENS_16OpenMPClauseKindEb;_ZN5clang6Parser18ParseOpenMPVarListENS_19OpenMPDirectiveKindENS_16OpenMPClauseKindERN4llvm15SmallVectorImplIPNS_4ExprEEERNS0_19OpenMPVarListDataTyE;_ZN5clang6Parser21ParseOpenMPParensExprEN4llvm9StringRefERNS_14SourceLocationE;_ZN5clang6Parser23ParseOpenMPSimpleClauseENS_16OpenMPClauseKindE;_ZN5clang6Parser24ParseOpenMPSimpleVarListENS_19OpenMPDirectiveKindERKN4llvm12function_refIFvRNS_12CXXScopeSpecENS_19DeclarationNameInfoEEEEb;_ZN5clang6Parser24ParseOpenMPVarListClauseENS_19OpenMPDirectiveKindENS_16OpenMPClauseKindE;_ZN5clang6Parser26ParseOMPDeclareSimdClausesENS_9OpaquePtrINS_12DeclGroupRefEEERN4llvm11SmallVectorINS_5TokenELj4EEENS_14SourceLocationE;_ZN5clang6Parser27ParseOpenMPSingleExprClauseENS_16OpenMPClauseKindE;_ZN5clang6Parser34ParseOpenMPSingleExprWithArgClauseENS_16OpenMPClauseKindE;_ZN5clang6Parser36ParseOpenMPDeclareReductionDirectiveENS_15AccessSpecifierE;_ZN5clang6Parser42ParseOpenMPDeclarativeDirectiveWithExtDeclERNS_15AccessSpecifierERNS0_25ParsedAttributesWithRangeENS_17TypeSpecifierTypeEPNS_4DeclE;_ZN5clang6Parser43ParseOpenMPDeclarativeOrExecutableDirectiveENS0_21AllowedContsructsKindE; -static-type=Parser_ParseOpenMP -package=org.clang.parse")
//</editor-fold>
public class Parser_ParseOpenMP extends Parser_ParseObjc {
private final /*split clang::Parser*/ Parser $this() { return (Parser)this; }


//===--------------------------------------------------------------------===//
// OpenMP: Directives and clauses.
/// Parse clauses for '#pragma omp declare simd'.

/// Parse clauses for '#pragma omp declare simd'.
//<editor-fold defaultstate="collapsed" desc="clang::Parser::ParseOMPDeclareSimdClauses">
@Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseOpenMP.cpp", line = 493,
   FQN="clang::Parser::ParseOMPDeclareSimdClauses", NM="_ZN5clang6Parser26ParseOMPDeclareSimdClausesENS_9OpaquePtrINS_12DeclGroupRefEEERN4llvm11SmallVectorINS_5TokenELj4EEENS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseOpenMP.cpp -nm=_ZN5clang6Parser26ParseOMPDeclareSimdClausesENS_9OpaquePtrINS_12DeclGroupRefEEERN4llvm11SmallVectorINS_5TokenELj4EEENS_14SourceLocationE")
  //</editor-fold>
  protected /*private*/ OpaquePtr<DeclGroupRef> ParseOMPDeclareSimdClauses(OpaquePtr<DeclGroupRef> Ptr, 
                            final SmallVectorToken /*&*/ Toks, SourceLocation Loc) {
    FNContextRAII FnContext = null;
    try {
      $this().PP.EnterToken($this().Tok);
      $this().PP.EnterTokenStream(new ArrayRefToken(Toks), /*DisableMacroExpansion=*/ true);
      // Consume the previously pushed token.
      $this().ConsumeAnyToken(/*ConsumeCodeCompletionTok=*/ true);
      
      FnContext/*J*/= new FNContextRAII(/*Deref*/$this(), new OpaquePtr<DeclGroupRef>(Ptr));
      type$ref<OMPDeclareSimdDeclAttr.BranchStateTy> BS = create_type$ref(OMPDeclareSimdDeclAttr.BranchStateTy.BS_Undefined);
      ActionResultTTrue<Expr /*P*/ > Simdlen/*J*/= new ActionResultTTrue<Expr /*P*/ >();
      SmallVector<Expr /*P*/ > Uniforms/*J*/= new SmallVector<Expr /*P*/ >(4, (Expr /*P*/ )null);
      SmallVector<Expr /*P*/ > Aligneds/*J*/= new SmallVector<Expr /*P*/ >(4, (Expr /*P*/ )null);
      SmallVector<Expr /*P*/ > Alignments/*J*/= new SmallVector<Expr /*P*/ >(4, (Expr /*P*/ )null);
      SmallVector<Expr /*P*/ > Linears/*J*/= new SmallVector<Expr /*P*/ >(4, (Expr /*P*/ )null);
      SmallVectorUInt LinModifiers/*J*/= new SmallVectorUInt(4, 0);
      SmallVector<Expr /*P*/ > Steps/*J*/= new SmallVector<Expr /*P*/ >(4, (Expr /*P*/ )null);
      boolean IsError = parseDeclareSimdClauses(/*Deref*/$this(), BS, Simdlen, Uniforms, Aligneds, 
          Alignments, Linears, LinModifiers, Steps);
      // Need to check for extra tokens.
      if ($this().Tok.isNot(tok.TokenKind.annot_pragma_openmp_end)) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_DiagnosticBuilder$C_char$ptr$C($c$.track($this().Diag($this().Tok, diag.warn_omp_extra_tokens_at_eol)), 
              getOpenMPDirectiveName(OpenMPDirectiveKind.OMPD_declare_simd)));
          while ($this().Tok.isNot(tok.TokenKind.annot_pragma_openmp_end)) {
            $this().ConsumeAnyToken();
          }
        } finally {
          $c$.$destroy();
        }
      }
      // Skip the last annot_pragma_openmp_end.
      SourceLocation EndLoc = $this().ConsumeToken();
      if (!IsError) {
        return $this().Actions.ActOnOpenMPDeclareSimdDirective(new OpaquePtr<DeclGroupRef>(Ptr), BS.$deref(), Simdlen.get(), new ArrayRef<Expr /*P*/ >(Uniforms), new ArrayRef<Expr /*P*/ >(Aligneds), new ArrayRef<Expr /*P*/ >(Alignments), new ArrayRef<Expr /*P*/ >(Linears), 
            new ArrayRefUInt(LinModifiers), new ArrayRef<Expr /*P*/ >(Steps), new SourceRange(/*NO_COPY*/Loc, /*NO_COPY*/EndLoc));
      }
      return new OpaquePtr<DeclGroupRef>(JD$Move.INSTANCE, Ptr);
    } finally {
      if (FnContext != null) { FnContext.$destroy(); }
    }
  }

/// \brief Parses declarative OpenMP directives.

/// \brief Parsing of declarative OpenMP directives.
///
///       threadprivate-directive:
///         annot_pragma_openmp 'threadprivate' simple-variable-list
///         annot_pragma_openmp_end
///
///       declare-reduction-directive:
///        annot_pragma_openmp 'declare' 'reduction' [...]
///        annot_pragma_openmp_end
///
///       declare-simd-directive:
///         annot_pragma_openmp 'declare simd' {<clause> [,]}
///         annot_pragma_openmp_end
///         <function declaration/definition>
///
//<editor-fold defaultstate="collapsed" desc="clang::Parser::ParseOpenMPDeclarativeDirectiveWithExtDecl">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseOpenMP.cpp", line = 546,
   FQN="clang::Parser::ParseOpenMPDeclarativeDirectiveWithExtDecl", NM="_ZN5clang6Parser42ParseOpenMPDeclarativeDirectiveWithExtDeclERNS_15AccessSpecifierERNS0_25ParsedAttributesWithRangeENS_17TypeSpecifierTypeEPNS_4DeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseOpenMP.cpp -nm=_ZN5clang6Parser42ParseOpenMPDeclarativeDirectiveWithExtDeclERNS_15AccessSpecifierERNS0_25ParsedAttributesWithRangeENS_17TypeSpecifierTypeEPNS_4DeclE")
  //</editor-fold>
  protected /*private*/ OpaquePtr<DeclGroupRef> ParseOpenMPDeclarativeDirectiveWithExtDecl(final type$ref<AccessSpecifier>/*&*/ AS, final ParsedAttributesWithRange /*&*/ Attrs) {
    return $this().ParseOpenMPDeclarativeDirectiveWithExtDecl(AS, Attrs, 
                                            DeclSpec.TST_unspecified, (Decl /*P*/ )null);
  }
  protected /*private*/ OpaquePtr<DeclGroupRef> ParseOpenMPDeclarativeDirectiveWithExtDecl(final type$ref<AccessSpecifier>/*&*/ AS, final ParsedAttributesWithRange /*&*/ Attrs, 
                                            TypeSpecifierType TagType/*= DeclSpec::TST_unspecified*/) {
    return $this().ParseOpenMPDeclarativeDirectiveWithExtDecl(AS, Attrs, 
                                            TagType, (Decl /*P*/ )null);
  }
  protected /*private*/ OpaquePtr<DeclGroupRef> ParseOpenMPDeclarativeDirectiveWithExtDecl(final type$ref<AccessSpecifier>/*&*/ AS, final ParsedAttributesWithRange /*&*/ Attrs, 
                                            TypeSpecifierType TagType/*= DeclSpec::TST_unspecified*/, Decl /*P*/ Tag/*= null*/) {
    ParenBraceBracketBalancer BalancerRAIIObj = null;
    try {
      assert ($this().Tok.is(tok.TokenKind.annot_pragma_openmp)) : "Not an OpenMP directive!";
      BalancerRAIIObj/*J*/= new ParenBraceBracketBalancer(/*Deref*/$this());
      
      SourceLocation Loc = $this().ConsumeToken();
      OpenMPDirectiveKind DKind = ParseOpenMPDirectiveKind(/*Deref*/$this());
      switch (DKind) {
       case OMPD_threadprivate:
        {
          ThreadprivateListParserHelper Helper = null;
          try {
            $this().ConsumeToken();
            Helper/*J*/= new ThreadprivateListParserHelper($this());
            if (!$this().ParseOpenMPSimpleVarList(OpenMPDirectiveKind.OMPD_threadprivate, Helper, true)) {
              // The last seen token is annot_pragma_openmp_end - need to check for
              // extra tokens.
              if ($this().Tok.isNot(tok.TokenKind.annot_pragma_openmp_end)) {
                JavaCleaner $c$ = $createJavaCleaner();
                try {
                  $c$.clean($out_DiagnosticBuilder$C_char$ptr$C($c$.track($this().Diag($this().Tok, diag.warn_omp_extra_tokens_at_eol)), 
                      getOpenMPDirectiveName(OpenMPDirectiveKind.OMPD_threadprivate)));
                  $this().SkipUntil(tok.TokenKind.annot_pragma_openmp_end, SkipUntilFlags.StopBeforeMatch);
                } finally {
                  $c$.$destroy();
                }
              }
              // Skip the last annot_pragma_openmp_end.
              $this().ConsumeToken();
              return $this().Actions.ActOnOpenMPThreadprivateDirective(new SourceLocation(Loc), 
                  Helper.getIdentifiers());
            }
            break;
          } finally {
            if (Helper != null) { Helper.$destroy(); }
          }
        }
       case OMPD_declare_reduction:
        $this().ConsumeToken();
        {
          OpaquePtr<DeclGroupRef> Res = $this().ParseOpenMPDeclareReductionDirective(AS.$deref());
          if (Res.$bool()) {
            // The last seen token is annot_pragma_openmp_end - need to check for
            // extra tokens.
            if ($this().Tok.isNot(tok.TokenKind.annot_pragma_openmp_end)) {
              JavaCleaner $c$ = $createJavaCleaner();
              try {
                $c$.clean($out_DiagnosticBuilder$C_char$ptr$C($c$.track($this().Diag($this().Tok, diag.warn_omp_extra_tokens_at_eol)), 
                    getOpenMPDirectiveName(OpenMPDirectiveKind.OMPD_declare_reduction)));
                while ($this().Tok.isNot(tok.TokenKind.annot_pragma_openmp_end)) {
                  $this().ConsumeAnyToken();
                }
              } finally {
                $c$.$destroy();
              }
            }
            // Skip the last annot_pragma_openmp_end.
            $this().ConsumeToken();
            return Res;
          }
        }
        break;
       case OMPD_declare_simd:
        {
          // The syntax is:
          // { #pragma omp declare simd }
          // <function-declaration-or-definition>
          //
          $this().ConsumeToken();
          SmallVectorToken Toks/*J*/= new SmallVectorToken(4, null);
          while ($this().Tok.isNot(tok.TokenKind.annot_pragma_openmp_end)) {
            Toks.push_back($this().Tok);
            $this().ConsumeAnyToken();
          }
          Toks.push_back($this().Tok);
          $this().ConsumeAnyToken();
          
          OpaquePtr<DeclGroupRef> Ptr/*J*/= new OpaquePtr<DeclGroupRef>();
          if ($this().Tok.is(tok.TokenKind.annot_pragma_openmp)) {
            Ptr.$assignMove($this().ParseOpenMPDeclarativeDirectiveWithExtDecl(AS, Attrs, TagType, Tag));
          } else if ($this().Tok.isNot(tok.TokenKind.r_brace) && !$this().isEofOrEom()) {
            // Here we expect to see some function declaration.
            if (AS.$deref() == AccessSpecifier.AS_none) {
              ParsingDeclSpec PDS = null;
              try {
                assert (TagType == DeclSpec.TST_unspecified);
                $this().MaybeParseCXX11Attributes(Attrs);
                $this().MaybeParseMicrosoftAttributes(Attrs);
                PDS/*J*/= new ParsingDeclSpec(/*Deref*/$this());
                Ptr.$assignMove($this().ParseExternalDeclaration(Attrs, $AddrOf(PDS)));
              } finally {
                if (PDS != null) { PDS.$destroy(); }
              }
            } else {
              Ptr.$assignMove(
                  $this().ParseCXXClassMemberDeclarationWithPragmas(AS, Attrs, TagType, Tag)
              );
            }
          }
          if (!Ptr.$bool()) {
            JavaCleaner $c$ = $createJavaCleaner();
            try {
              $c$.clean($c$.track($this().Diag(new SourceLocation(Loc), diag.err_omp_decl_in_declare_simd)));
              return new OpaquePtr<DeclGroupRef>();
            } finally {
              $c$.$destroy();
            }
          }
          return $this().ParseOMPDeclareSimdClauses(new OpaquePtr<DeclGroupRef>(Ptr), Toks, new SourceLocation(Loc));
        }
       case OMPD_declare_target:
        {
          SourceLocation DTLoc = $this().ConsumeAnyToken();
          if ($this().Tok.isNot(tok.TokenKind.annot_pragma_openmp_end)) {
            // OpenMP 4.5 syntax with list of entities.
            SmallSetVector</*const*/ NamedDecl /*P*/ > SameDirectiveDecls/*J*/= new SmallSetVector</*const*/ NamedDecl /*P*/ >(16, (/*const*/ NamedDecl /*P*/ ) null);
            try {
//              SameDirectiveDecls/*J*/= new SmallSetVector</*const*/ NamedDecl /*P*/ >(16, (/*const*/ NamedDecl /*P*/ ) null);
              while ($this().Tok.isNot(tok.TokenKind.annot_pragma_openmp_end)) {
                final type$ref<OMPDeclareTargetDeclAttr.MapTypeTy> MT = create_type$ref(OMPDeclareTargetDeclAttr.MapTypeTy.MT_To);
                if ($this().Tok.is(tok.TokenKind.identifier)) {
                  IdentifierInfo /*P*/ II = $this().Tok.getIdentifierInfo();
                  StringRef ClauseName = II.getName();
                  // Parse 'to|link' clauses.
                  if (!OMPDeclareTargetDeclAttr.ConvertStrToMapTypeTy(new StringRef(ClauseName), 
                      MT)) {
                    JavaCleaner $c$ = $createJavaCleaner();
                    try {
                      $c$.clean($out_DiagnosticBuilder$C_StringRef($c$.track($this().Diag($this().Tok, diag.err_omp_declare_target_unexpected_clause)), 
                          /*NO_COPY*/ClauseName));
                      break;
                    } finally {
                      $c$.$destroy();
                    }
                  }
                  $this().ConsumeToken();
                }
                CXXScopeSpec$RefDeclarationNameInfo2Void Callback = /*[this, MT, &SameDirectiveDecls]*/ (final CXXScopeSpec /*&*/SS, DeclarationNameInfo NameInfo) -> 
                  {
                    $this().Actions.ActOnOpenMPDeclareTargetName($this().getCurScope(), SS, NameInfo, MT.$deref(), 
                        SameDirectiveDecls);
                  }
  ;
                if ($this().ParseOpenMPSimpleVarList(OpenMPDirectiveKind.OMPD_declare_target, Callback, true)) {
                  break;
                }
                
                // Consume optional ','.
                if ($this().Tok.is(tok.TokenKind.comma)) {
                  $this().ConsumeToken();
                }
              }
              $this().SkipUntil(tok.TokenKind.annot_pragma_openmp_end, SkipUntilFlags.StopBeforeMatch);
              $this().ConsumeAnyToken();
              return new OpaquePtr<DeclGroupRef>();
            } finally {
              if (SameDirectiveDecls != null) { SameDirectiveDecls.$destroy(); }
            }
          }
          
          // Skip the last annot_pragma_openmp_end.
          $this().ConsumeAnyToken();
          if (!$this().Actions.ActOnStartOpenMPDeclareTargetDirective(new SourceLocation(DTLoc))) {
            return new OpaquePtr<DeclGroupRef>();
          }
          
          DKind = ParseOpenMPDirectiveKind(/*Deref*/$this());
          while (DKind != OpenMPDirectiveKind.OMPD_end_declare_target && DKind != OpenMPDirectiveKind.OMPD_declare_target
             && $this().Tok.isNot(tok.TokenKind.eof) && $this().Tok.isNot(tok.TokenKind.r_brace)) {
            ParsedAttributesWithRange attrs = null;
            try {
              attrs/*J*/= new ParsedAttributesWithRange($this().AttrFactory);
              $this().MaybeParseCXX11Attributes(attrs);
              $this().MaybeParseMicrosoftAttributes(attrs);
              $this().ParseExternalDeclaration(attrs);
              if ($this().Tok.isAnnotation() && $this().Tok.is(tok.TokenKind.annot_pragma_openmp)) {
                TentativeParsingAction TPA = null;
                try {
                  TPA/*J*/= new TentativeParsingAction(/*Deref*/$this());
                  $this().ConsumeToken();
                  DKind = ParseOpenMPDirectiveKind(/*Deref*/$this());
                  if (DKind != OpenMPDirectiveKind.OMPD_end_declare_target) {
                    TPA.Revert();
                  } else {
                    TPA.Commit();
                  }
                } finally {
                  if (TPA != null) { TPA.$destroy(); }
                }
              }
            } finally {
              if (attrs != null) { attrs.$destroy(); }
            }
          }
          if (DKind == OpenMPDirectiveKind.OMPD_end_declare_target) {
            $this().ConsumeAnyToken();
            if ($this().Tok.isNot(tok.TokenKind.annot_pragma_openmp_end)) {
              JavaCleaner $c$ = $createJavaCleaner();
              try {
                $c$.clean($out_DiagnosticBuilder$C_char$ptr$C($c$.track($this().Diag($this().Tok, diag.warn_omp_extra_tokens_at_eol)), 
                    getOpenMPDirectiveName(OpenMPDirectiveKind.OMPD_end_declare_target)));
                $this().SkipUntil(tok.TokenKind.annot_pragma_openmp_end, SkipUntilFlags.StopBeforeMatch);
              } finally {
                $c$.$destroy();
              }
            }
            // Skip the last annot_pragma_openmp_end.
            $this().ConsumeAnyToken();
          } else {
            JavaCleaner $c$ = $createJavaCleaner();
            try {
              $c$.clean($c$.track($this().Diag($this().Tok, diag.err_expected_end_declare_target)));
              $c$.clean($out_DiagnosticBuilder$C_char$ptr$C($c$.track($this().Diag(new SourceLocation(DTLoc), diag.note_matching)), /*KEEP_STR*/"'#pragma omp declare target'"));
            } finally {
              $c$.$destroy();
            }
          }
          $this().Actions.ActOnFinishOpenMPDeclareTargetDirective();
          return new OpaquePtr<DeclGroupRef>();
        }
       case OMPD_unknown:
        {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            $c$.clean($c$.track($this().Diag($this().Tok, diag.err_omp_unknown_directive)));
            break;
          } finally {
            $c$.$destroy();
          }
        }
       case OMPD_parallel:
       case OMPD_simd:
       case OMPD_task:
       case OMPD_taskyield:
       case OMPD_barrier:
       case OMPD_taskwait:
       case OMPD_taskgroup:
       case OMPD_flush:
       case OMPD_for:
       case OMPD_for_simd:
       case OMPD_sections:
       case OMPD_section:
       case OMPD_single:
       case OMPD_master:
       case OMPD_ordered:
       case OMPD_critical:
       case OMPD_parallel_for:
       case OMPD_parallel_for_simd:
       case OMPD_parallel_sections:
       case OMPD_atomic:
       case OMPD_target:
       case OMPD_teams:
       case OMPD_cancellation_point:
       case OMPD_cancel:
       case OMPD_target_data:
       case OMPD_target_enter_data:
       case OMPD_target_exit_data:
       case OMPD_target_parallel:
       case OMPD_target_parallel_for:
       case OMPD_taskloop:
       case OMPD_taskloop_simd:
       case OMPD_distribute:
       case OMPD_end_declare_target:
       case OMPD_target_update:
       case OMPD_distribute_parallel_for:
       case OMPD_distribute_parallel_for_simd:
       case OMPD_distribute_simd:
       case OMPD_target_parallel_for_simd:
        {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            $c$.clean($out_DiagnosticBuilder$C_char$ptr$C($c$.track($this().Diag($this().Tok, diag.err_omp_unexpected_directive)), 
                getOpenMPDirectiveName(DKind)));
            break;
          } finally {
            $c$.$destroy();
          }
        }
      }
      while ($this().Tok.isNot(tok.TokenKind.annot_pragma_openmp_end)) {
        $this().ConsumeAnyToken();
      }
      $this().ConsumeAnyToken();
      return new OpaquePtr<DeclGroupRef>(null);
    } finally {
      if (BalancerRAIIObj != null) { BalancerRAIIObj.$destroy(); }
    }
  }

/// \brief Parse 'omp declare reduction' construct.

/// \brief Parse 'omp declare reduction' construct.
///
///       declare-reduction-directive:
///        annot_pragma_openmp 'declare' 'reduction'
///        '(' <reduction_id> ':' <type> {',' <type>} ':' <expression> ')'
///        ['initializer' '(' ('omp_priv' '=' <expression>)|<function_call> ')']
///        annot_pragma_openmp_end
/// <reduction_id> is either a base language identifier or one of the following
/// operators: '+', '-', '*', '&', '|', '^', '&&' and '||'.
///
//<editor-fold defaultstate="collapsed" desc="clang::Parser::ParseOpenMPDeclareReductionDirective">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseOpenMP.cpp", line = 204,
   FQN="clang::Parser::ParseOpenMPDeclareReductionDirective", NM="_ZN5clang6Parser36ParseOpenMPDeclareReductionDirectiveENS_15AccessSpecifierE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseOpenMP.cpp -nm=_ZN5clang6Parser36ParseOpenMPDeclareReductionDirectiveENS_15AccessSpecifierE")
  //</editor-fold>
  protected /*private*/ OpaquePtr<DeclGroupRef> ParseOpenMPDeclareReductionDirective(AccessSpecifier AS) {
    BalancedDelimiterTracker T = null;
    try {
      // Parse '('.
      T/*J*/= new BalancedDelimiterTracker(/*Deref*/$this(), tok.TokenKind.l_paren, tok.TokenKind.annot_pragma_openmp_end);
      if (T.expectAndConsume(diag.err_expected_lparen_after, 
          getOpenMPDirectiveName(OpenMPDirectiveKind.OMPD_declare_reduction))) {
        $this().SkipUntil(tok.TokenKind.annot_pragma_openmp_end, SkipUntilFlags.StopBeforeMatch);
        return new OpaquePtr<DeclGroupRef>();
      }
      
      DeclarationName Name = parseOpenMPReductionId(/*Deref*/$this());
      if (Name.isEmpty() && $this().Tok.is(tok.TokenKind.annot_pragma_openmp_end)) {
        return new OpaquePtr<DeclGroupRef>();
      }
      
      // Consume ':'.
      boolean IsCorrect = !$this().ExpectAndConsume(tok.TokenKind.colon);
      if (!IsCorrect && $this().Tok.is(tok.TokenKind.annot_pragma_openmp_end)) {
        return new OpaquePtr<DeclGroupRef>();
      }
      
      IsCorrect = IsCorrect && !Name.isEmpty();
      if ($this().Tok.is(tok.TokenKind.colon) || $this().Tok.is(tok.TokenKind.annot_pragma_openmp_end)) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($c$.track($this().Diag($this().Tok.getLocation(), diag.err_expected_type)));
          IsCorrect = false;
        } finally {
          $c$.$destroy();
        }
      }
      if (!IsCorrect && $this().Tok.is(tok.TokenKind.annot_pragma_openmp_end)) {
        return new OpaquePtr<DeclGroupRef>();
      }
      
      SmallVector<std.pair<QualType, SourceLocation>> ReductionTypes/*J*/= new SmallVector<std.pair<QualType, SourceLocation>>(8, new std.pairTypeType<QualType, SourceLocation>(new QualType(), new SourceLocation()));
      // Parse list of types until ':' token.
      do {
        ColonProtectionRAIIObject ColonRAII = null;
        try {
          ColonRAII/*J*/= new ColonProtectionRAIIObject(/*Deref*/$this());
          SourceRange Range/*J*/= new SourceRange();
          ActionResult<OpaquePtr<QualType> > TR = $this().ParseTypeName($AddrOf(Range), Declarator.TheContext.PrototypeContext, AS);
          if (TR.isUsable()) {
            QualType ReductionType = $this().Actions.ActOnOpenMPDeclareReductionType(Range.getBegin(), new ActionResult<OpaquePtr<QualType> >(TR));
            if (!ReductionType.isNull()) {
              ReductionTypes.push_back(std.make_pair(ReductionType, Range.getBegin()));
            }
          } else {
            $this().SkipUntil(tok.TokenKind.comma, tok.TokenKind.colon, tok.TokenKind.annot_pragma_openmp_end, 
                SkipUntilFlags.StopBeforeMatch);
          }
          if ($this().Tok.is(tok.TokenKind.colon) || $this().Tok.is(tok.TokenKind.annot_pragma_openmp_end)) {
            break;
          }
          
          // Consume ','.
          if ($this().ExpectAndConsume(tok.TokenKind.comma)) {
            IsCorrect = false;
            if ($this().Tok.is(tok.TokenKind.annot_pragma_openmp_end)) {
              JavaCleaner $c$ = $createJavaCleaner();
              try {
                $c$.clean($c$.track($this().Diag($this().Tok.getLocation(), diag.err_expected_type)));
                return new OpaquePtr<DeclGroupRef>();
              } finally {
                $c$.$destroy();
              }
            }
          }
        } finally {
          if (ColonRAII != null) { ColonRAII.$destroy(); }
        }
      } while ($this().Tok.isNot(tok.TokenKind.annot_pragma_openmp_end));
      if (ReductionTypes.empty()) {
        $this().SkipUntil(tok.TokenKind.annot_pragma_openmp_end, SkipUntilFlags.StopBeforeMatch);
        return new OpaquePtr<DeclGroupRef>();
      }
      if (!IsCorrect && $this().Tok.is(tok.TokenKind.annot_pragma_openmp_end)) {
        return new OpaquePtr<DeclGroupRef>();
      }
      
      // Consume ':'.
      if ($this().ExpectAndConsume(tok.TokenKind.colon)) {
        IsCorrect = false;
      }
      if ($this().Tok.is(tok.TokenKind.annot_pragma_openmp_end)) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($c$.track($this().Diag($this().Tok.getLocation(), diag.err_expected_expression)));
          return new OpaquePtr<DeclGroupRef>();
        } finally {
          $c$.$destroy();
        }
      }
      
      OpaquePtr<DeclGroupRef> DRD = $this().Actions.ActOnOpenMPDeclareReductionDirectiveStart($this().getCurScope(), $this().Actions.getCurLexicalContext(), new DeclarationName(Name), new ArrayRef<std.pair<QualType, SourceLocation> >(ReductionTypes), AS);
      
      // Parse <combiner> expression and then parse initializer if any for each
      // correct type.
      /*uint*/int I = 0, E = ReductionTypes.size();
      for (Decl /*P*/ D : DRD.getDeclGroupRef()) {
        TentativeParsingAction TPA = null;
        ParseScope OMPDRScope = null;
        try {
          TPA/*J*/= new TentativeParsingAction(/*Deref*/$this());
          OMPDRScope/*J*/= new ParseScope($this(), Scope.ScopeFlags.FnScope | Scope.ScopeFlags.DeclScope
                 | Scope.ScopeFlags.OpenMPDirectiveScope);
          // Parse <combiner> expression.
          $this().Actions.ActOnOpenMPDeclareReductionCombinerStart($this().getCurScope(), D);
          ActionResultTTrue<Expr /*P*/ > CombinerResult = $this().Actions.ActOnFinishFullExpr($this().ParseAssignmentExpression().get(), 
              D.getLocation(), /*DiscardedValue=*/ true);
          $this().Actions.ActOnOpenMPDeclareReductionCombinerEnd(D, CombinerResult.get());
          if (CombinerResult.isInvalid() && $this().Tok.isNot(tok.TokenKind.r_paren)
             && $this().Tok.isNot(tok.TokenKind.annot_pragma_openmp_end)) {
            TPA.Commit();
            IsCorrect = false;
            break;
          }
          IsCorrect = !T.consumeClose() && IsCorrect && CombinerResult.isUsable();
          ActionResultTTrue<Expr /*P*/ > InitializerResult/*J*/= new ActionResultTTrue<Expr /*P*/ >();
          if ($this().Tok.isNot(tok.TokenKind.annot_pragma_openmp_end)) {
            BalancedDelimiterTracker _T = null;
            try {
              // Parse <initializer> expression.
              if ($this().Tok.is(tok.TokenKind.identifier)
                 && $this().Tok.getIdentifierInfo().isStr(/*KEEP_STR*/"initializer")) {
                $this().ConsumeToken();
              } else {
                JavaCleaner $c$ = $createJavaCleaner();
                try {
                  $c$.clean($out_DiagnosticBuilder$C_char$ptr$C($c$.track($this().Diag($this().Tok.getLocation(), diag.err_expected)), /*KEEP_STR*/"'initializer'"));
                  TPA.Commit();
                  IsCorrect = false;
                  break;
                } finally {
                  $c$.$destroy();
                }
              }
              // Parse '('.
              _T/*J*/= new BalancedDelimiterTracker(/*Deref*/$this(), tok.TokenKind.l_paren, 
                  tok.TokenKind.annot_pragma_openmp_end);
              IsCorrect
                 = !_T.expectAndConsume(diag.err_expected_lparen_after, $("initializer"))
                 && IsCorrect;
              if ($this().Tok.isNot(tok.TokenKind.annot_pragma_openmp_end)) {
                ParseScope _OMPDRScope = null;
                try {
                  _OMPDRScope/*J*/= new ParseScope($this(), Scope.ScopeFlags.FnScope | Scope.ScopeFlags.DeclScope
                         | Scope.ScopeFlags.OpenMPDirectiveScope);
                  // Parse expression.
                  $this().Actions.ActOnOpenMPDeclareReductionInitializerStart($this().getCurScope(), D);
                  InitializerResult.$assignMove($this().Actions.ActOnFinishFullExpr($this().ParseAssignmentExpression().get(), D.getLocation(), 
                          /*DiscardedValue=*/ true));
                  $this().Actions.ActOnOpenMPDeclareReductionInitializerEnd(D, InitializerResult.get());
                  if (InitializerResult.isInvalid() && $this().Tok.isNot(tok.TokenKind.r_paren)
                     && $this().Tok.isNot(tok.TokenKind.annot_pragma_openmp_end)) {
                    TPA.Commit();
                    IsCorrect = false;
                    break;
                  }
                  IsCorrect
                     = !_T.consumeClose() && IsCorrect && !InitializerResult.isInvalid();
                } finally {
                  if (_OMPDRScope != null) { _OMPDRScope.$destroy(); }
                }
              }
            } finally {
              if (_T != null) { _T.$destroy(); }
            }
          }
          
          ++I;
          // Revert parsing if not the last type, otherwise accept it, we're done with
          // parsing.
          if (I != E) {
            TPA.Revert();
          } else {
            TPA.Commit();
          }
        } finally {
          if (OMPDRScope != null) { OMPDRScope.$destroy(); }
          if (TPA != null) { TPA.$destroy(); }
        }
      }
      return $this().Actions.ActOnOpenMPDeclareReductionDirectiveEnd($this().getCurScope(), new OpaquePtr<DeclGroupRef>(DRD), 
          IsCorrect);
    } finally {
      if (T != null) { T.$destroy(); }
    }
  }


/// \brief Parses simple list of variables.
///
/// \param Kind Kind of the directive.
/// \param Callback Callback function to be called for the list elements.
/// \param AllowScopeSpecifier true, if the variables can have fully
/// qualified names.
///

// Parses simple list:
//   simple-variable-list:
//         '(' id-expression {, id-expression} ')'
//
//<editor-fold defaultstate="collapsed" desc="clang::Parser::ParseOpenMPSimpleVarList">
@Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseOpenMP.cpp", line = 991,
   FQN="clang::Parser::ParseOpenMPSimpleVarList", NM="_ZN5clang6Parser24ParseOpenMPSimpleVarListENS_19OpenMPDirectiveKindERKN4llvm12function_refIFvRNS_12CXXScopeSpecENS_19DeclarationNameInfoEEEEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseOpenMP.cpp -nm=_ZN5clang6Parser24ParseOpenMPSimpleVarListENS_19OpenMPDirectiveKindERKN4llvm12function_refIFvRNS_12CXXScopeSpecENS_19DeclarationNameInfoEEEEb")
  //</editor-fold>
  protected /*private*/ boolean ParseOpenMPSimpleVarList(OpenMPDirectiveKind Kind, 
                          final /*const*/CXXScopeSpec$RefDeclarationNameInfo2Void/*&*/ Callback, 
                          boolean AllowScopeSpecifier) {
    BalancedDelimiterTracker T = null;
    try {
      // Parse '('.
      T/*J*/= new BalancedDelimiterTracker(/*Deref*/$this(), tok.TokenKind.l_paren, tok.TokenKind.annot_pragma_openmp_end);
      if (T.expectAndConsume(diag.err_expected_lparen_after, 
          getOpenMPDirectiveName(Kind))) {
        return true;
      }
      boolean IsCorrect = true;
      boolean NoIdentIsFound = true;
      
      // Read tokens while ')' or annot_pragma_openmp_end is not found.
      while ($this().Tok.isNot(tok.TokenKind.r_paren) && $this().Tok.isNot(tok.TokenKind.annot_pragma_openmp_end)) {
        CXXScopeSpec SS = null;
        try {
          SS/*J*/= new CXXScopeSpec();
          SourceLocation TemplateKWLoc/*J*/= new SourceLocation();
          UnqualifiedId Name/*J*/= new UnqualifiedId();
          // Read var name.
          Token PrevTok = new Token($this().Tok);
          NoIdentIsFound = false;
          if (AllowScopeSpecifier && $this().getLangOpts().CPlusPlus
             && $this().ParseOptionalCXXScopeSpecifier(SS, new OpaquePtr<QualType>(null), false)) {
            IsCorrect = false;
            $this().SkipUntil(tok.TokenKind.comma, tok.TokenKind.r_paren, tok.TokenKind.annot_pragma_openmp_end, 
                SkipUntilFlags.StopBeforeMatch);
          } else if ($this().ParseUnqualifiedId(SS, false, false, false, new OpaquePtr<QualType>(null), 
              TemplateKWLoc, Name)) {
            IsCorrect = false;
            $this().SkipUntil(tok.TokenKind.comma, tok.TokenKind.r_paren, tok.TokenKind.annot_pragma_openmp_end, 
                SkipUntilFlags.StopBeforeMatch);
          } else if ($this().Tok.isNot(tok.TokenKind.comma) && $this().Tok.isNot(tok.TokenKind.r_paren)
             && $this().Tok.isNot(tok.TokenKind.annot_pragma_openmp_end)) {
            JavaCleaner $c$ = $createJavaCleaner();
            try {
              IsCorrect = false;
              $this().SkipUntil(tok.TokenKind.comma, tok.TokenKind.r_paren, tok.TokenKind.annot_pragma_openmp_end, 
                  SkipUntilFlags.StopBeforeMatch);
              $c$.clean($out_DiagnosticBuilder$C_SourceRange($out_DiagnosticBuilder$C_TokenKind($c$.track($this().Diag(PrevTok.getLocation(), diag.err_expected)), 
                      tok.TokenKind.identifier), 
                  new SourceRange(PrevTok.getLocation(), /*NO_COPY*/$this().PrevTokLocation)));
            } finally {
              $c$.$destroy();
            }
          } else {
            Callback.$call(SS, $this().Actions.GetNameFromUnqualifiedId(Name));
          }
          // Consume ','.
          if ($this().Tok.is(tok.TokenKind.comma)) {
            $this().ConsumeToken();
          }
        } finally {
          if (SS != null) { SS.$destroy(); }
        }
      }
      if (NoIdentIsFound) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_DiagnosticBuilder$C_TokenKind($c$.track($this().Diag($this().Tok, diag.err_expected)), tok.TokenKind.identifier));
          IsCorrect = false;
        } finally {
          $c$.$destroy();
        }
      }
      
      // Parse ')'.
      IsCorrect = !T.consumeClose() && IsCorrect;
      
      return !IsCorrect;
    } finally {
      if (T != null) { T.$destroy(); }
    }
  }

/// \brief Parses declarative or executable directive.
///
/// \param Allowed ACK_Any, if any directives are allowed,
/// ACK_StatementsOpenMPAnyExecutable - if any executable directives are
/// allowed, ACK_StatementsOpenMPNonStandalone - if only non-standalone
/// executable directives are allowed.
///

/// \brief Parsing of declarative or executable OpenMP directives.
///
///       threadprivate-directive:
///         annot_pragma_openmp 'threadprivate' simple-variable-list
///         annot_pragma_openmp_end
///
///       declare-reduction-directive:
///         annot_pragma_openmp 'declare' 'reduction' '(' <reduction_id> ':'
///         <type> {',' <type>} ':' <expression> ')' ['initializer' '('
///         ('omp_priv' '=' <expression>|<function_call>) ')']
///         annot_pragma_openmp_end
///
///       executable-directive:
///         annot_pragma_openmp 'parallel' | 'simd' | 'for' | 'sections' |
///         'section' | 'single' | 'master' | 'critical' [ '(' <name> ')' ] |
///         'parallel for' | 'parallel sections' | 'task' | 'taskyield' |
///         'barrier' | 'taskwait' | 'flush' | 'ordered' | 'atomic' |
///         'for simd' | 'parallel for simd' | 'target' | 'target data' |
///         'taskgroup' | 'teams' | 'taskloop' | 'taskloop simd' |
///         'distribute' | 'target enter data' | 'target exit data' |
///         'target parallel' | 'target parallel for' |
///         'target update' | 'distribute parallel for' |
///         'distribute paralle for simd' | 'distribute simd' |
///         'target parallel for simd' {clause}
///         annot_pragma_openmp_end
///
//<editor-fold defaultstate="collapsed" desc="clang::Parser::ParseOpenMPDeclarativeOrExecutableDirective">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseOpenMP.cpp", line = 780,
   FQN="clang::Parser::ParseOpenMPDeclarativeOrExecutableDirective", NM="_ZN5clang6Parser43ParseOpenMPDeclarativeOrExecutableDirectiveENS0_21AllowedContsructsKindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseOpenMP.cpp -nm=_ZN5clang6Parser43ParseOpenMPDeclarativeOrExecutableDirectiveENS0_21AllowedContsructsKindE")
  //</editor-fold>
  protected /*private*/ ActionResultTTrue<Stmt /*P*/ > ParseOpenMPDeclarativeOrExecutableDirective(AllowedContsructsKind Allowed) {
    ParenBraceBracketBalancer BalancerRAIIObj = null;
    try {
      assert ($this().Tok.is(tok.TokenKind.annot_pragma_openmp)) : "Not an OpenMP directive!";
      BalancerRAIIObj/*J*/= new ParenBraceBracketBalancer(/*Deref*/$this());
      SmallVector<OMPClause /*P*/ > Clauses/*J*/= new SmallVector<OMPClause /*P*/ >(5, (OMPClause /*P*/ )null);
      SmallVector<PointerBoolPair<OMPClause /*P*/ >> FirstClauses/*J*/= new SmallVector<PointerBoolPair<OMPClause /*P*/ >>(OpenMPClauseKind.OMPC_unknown.getValue() + 1, new PointerBoolPair<OMPClause/*P*/>());
      /*uint*/int ScopeFlags = Scope.ScopeFlags.FnScope | Scope.ScopeFlags.DeclScope | Scope.ScopeFlags.OpenMPDirectiveScope;
      SourceLocation Loc = $this().ConsumeToken(), EndLoc/*J*/= new SourceLocation();
      OpenMPDirectiveKind DKind = ParseOpenMPDirectiveKind(/*Deref*/$this());
      OpenMPDirectiveKind CancelRegion = OpenMPDirectiveKind.OMPD_unknown;
      // Name of critical directive.
      DeclarationNameInfo DirName/*J*/= new DeclarationNameInfo();
      ActionResultTTrue<Stmt /*P*/ > Directive = StmtError();
      boolean HasAssociatedStatement = true;
      boolean FlushHasClause = false;
      switch (DKind) {
       case OMPD_threadprivate:
        {
          ThreadprivateListParserHelper Helper = null;
          try {
            if (Allowed != AllowedContsructsKind.ACK_Any) {
              JavaCleaner $c$ = $createJavaCleaner();
              try {
                $c$.clean($out_DiagnosticBuilder$C_int($out_DiagnosticBuilder$C_char$ptr$C($c$.track($this().Diag($this().Tok, diag.err_omp_immediate_directive)), 
                        getOpenMPDirectiveName(DKind)), 0));
              } finally {
                $c$.$destroy();
              }
            }
            $this().ConsumeToken();
            Helper/*J*/= new ThreadprivateListParserHelper($this());
            if (!$this().ParseOpenMPSimpleVarList(OpenMPDirectiveKind.OMPD_threadprivate, (Helper), false)) {
              // The last seen token is annot_pragma_openmp_end - need to check for
              // extra tokens.
              if ($this().Tok.isNot(tok.TokenKind.annot_pragma_openmp_end)) {
                JavaCleaner $c$ = $createJavaCleaner();
                try {
                  $c$.clean($out_DiagnosticBuilder$C_char$ptr$C($c$.track($this().Diag($this().Tok, diag.warn_omp_extra_tokens_at_eol)), 
                      getOpenMPDirectiveName(OpenMPDirectiveKind.OMPD_threadprivate)));
                  $this().SkipUntil(tok.TokenKind.annot_pragma_openmp_end, SkipUntilFlags.StopBeforeMatch);
                } finally {
                  $c$.$destroy();
                }
              }
              OpaquePtr<DeclGroupRef> Res = $this().Actions.ActOnOpenMPThreadprivateDirective(new SourceLocation(Loc), Helper.getIdentifiers());
              Directive.$assignMove($this().Actions.ActOnDeclStmt(new OpaquePtr<DeclGroupRef>(Res), new SourceLocation(Loc), $this().Tok.getLocation()));
            }
            $this().SkipUntil(tok.TokenKind.annot_pragma_openmp_end);
            break;
          } finally {
            if (Helper != null) { Helper.$destroy(); }
          }
        }
       case OMPD_declare_reduction:
        $this().ConsumeToken();
        {
          OpaquePtr<DeclGroupRef> Res = $this().ParseOpenMPDeclareReductionDirective(/*AS=*/ AccessSpecifier.AS_none);
          if (Res.$bool()) {
            // The last seen token is annot_pragma_openmp_end - need to check for
            // extra tokens.
            if ($this().Tok.isNot(tok.TokenKind.annot_pragma_openmp_end)) {
              JavaCleaner $c$ = $createJavaCleaner();
              try {
                $c$.clean($out_DiagnosticBuilder$C_char$ptr$C($c$.track($this().Diag($this().Tok, diag.warn_omp_extra_tokens_at_eol)), 
                    getOpenMPDirectiveName(OpenMPDirectiveKind.OMPD_declare_reduction)));
                while ($this().Tok.isNot(tok.TokenKind.annot_pragma_openmp_end)) {
                  $this().ConsumeAnyToken();
                }
              } finally {
                $c$.$destroy();
              }
            }
            $this().ConsumeAnyToken();
            Directive.$assignMove($this().Actions.ActOnDeclStmt(new OpaquePtr<DeclGroupRef>(Res), new SourceLocation(Loc), $this().Tok.getLocation()));
          } else {
            $this().SkipUntil(tok.TokenKind.annot_pragma_openmp_end);
          }
        }
        break;
       case OMPD_flush:
        if ($this().PP.LookAhead(0).is(tok.TokenKind.l_paren)) {
          FlushHasClause = true;
          // Push copy of the current token back to stream to properly parse
          // pseudo-clause OMPFlushClause.
          $this().PP.EnterToken($this().Tok);
        }
       case OMPD_taskyield:
       case OMPD_barrier:
       case OMPD_taskwait:
       case OMPD_cancellation_point:
       case OMPD_cancel:
       case OMPD_target_enter_data:
       case OMPD_target_exit_data:
       case OMPD_target_update:
        if (Allowed == AllowedContsructsKind.ACK_StatementsOpenMPNonStandalone) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            $c$.clean($out_DiagnosticBuilder$C_int($out_DiagnosticBuilder$C_char$ptr$C($c$.track($this().Diag($this().Tok, diag.err_omp_immediate_directive)), 
                    getOpenMPDirectiveName(DKind)), 0));
          } finally {
            $c$.$destroy();
          }
        }
        HasAssociatedStatement = false;
       case OMPD_parallel:
       case OMPD_simd:
       case OMPD_for:
       case OMPD_for_simd:
       case OMPD_sections:
       case OMPD_single:
       case OMPD_section:
       case OMPD_master:
       case OMPD_critical:
       case OMPD_parallel_for:
       case OMPD_parallel_for_simd:
       case OMPD_parallel_sections:
       case OMPD_task:
       case OMPD_ordered:
       case OMPD_atomic:
       case OMPD_target:
       case OMPD_teams:
       case OMPD_taskgroup:
       case OMPD_target_data:
       case OMPD_target_parallel:
       case OMPD_target_parallel_for:
       case OMPD_taskloop:
       case OMPD_taskloop_simd:
       case OMPD_distribute:
       case OMPD_distribute_parallel_for:
       case OMPD_distribute_parallel_for_simd:
       case OMPD_distribute_simd:
       case OMPD_target_parallel_for_simd:
        {
          ParseScope OMPDirectiveScope = null;
          try {
            $this().ConsumeToken();
            // Parse directive name of the 'critical' directive if any.
            if (DKind == OpenMPDirectiveKind.OMPD_critical) {
              BalancedDelimiterTracker T = null;
              try {
                T/*J*/= new BalancedDelimiterTracker(/*Deref*/$this(), tok.TokenKind.l_paren, 
                    tok.TokenKind.annot_pragma_openmp_end);
                if (!T.consumeOpen()) {
                  if ($this().Tok.isAnyIdentifier()) {
                    DirName.$assignMove(
                        new DeclarationNameInfo(new DeclarationName($this().Tok.getIdentifierInfo()), $this().Tok.getLocation())
                    );
                    $this().ConsumeAnyToken();
                  } else {
                    JavaCleaner $c$ = $createJavaCleaner();
                    try {
                      $c$.clean($c$.track($this().Diag($this().Tok, diag.err_omp_expected_identifier_for_critical)));
                    } finally {
                      $c$.$destroy();
                    }
                  }
                  T.consumeClose();
                }
              } finally {
                if (T != null) { T.$destroy(); }
              }
            } else if (DKind == OpenMPDirectiveKind.OMPD_cancellation_point || DKind == OpenMPDirectiveKind.OMPD_cancel) {
              CancelRegion = ParseOpenMPDirectiveKind(/*Deref*/$this());
              if ($this().Tok.isNot(tok.TokenKind.annot_pragma_openmp_end)) {
                $this().ConsumeToken();
              }
            }
            if (isOpenMPLoopDirective(DKind)) {
              ScopeFlags |= Scope.ScopeFlags.OpenMPLoopDirectiveScope;
            }
            if (isOpenMPSimdDirective(DKind)) {
              ScopeFlags |= Scope.ScopeFlags.OpenMPSimdDirectiveScope;
            }
            OMPDirectiveScope/*J*/= new ParseScope($this(), ScopeFlags);
            $this().Actions.StartOpenMPDSABlock(DKind, DirName, $this().Actions.getCurScope(), new SourceLocation(Loc));
            while ($this().Tok.isNot(tok.TokenKind.annot_pragma_openmp_end)) {
              OpenMPClauseKind CKind = $this().Tok.isAnnotation() ? OpenMPClauseKind.OMPC_unknown : FlushHasClause ? OpenMPClauseKind.OMPC_flush : getOpenMPClauseKind(new StringRef($this().PP.getSpelling($this().Tok)));
              $this().Actions.StartOpenMPClause(CKind);
              FlushHasClause = false;
              OMPClause /*P*/ Clause = $this().ParseOpenMPClause(DKind, CKind, !FirstClauses.$at(/*KEEP_ENUM*/CKind.getValue()).getInt());
              FirstClauses.$at(/*KEEP_ENUM*/CKind.getValue()).setInt(true);
              if ((Clause != null)) {
                FirstClauses.$at(/*KEEP_ENUM*/CKind.getValue()).setPointer(Clause);
                Clauses.push_back(Clause);
              }
              
              // Skip ',' if any.
              if ($this().Tok.is(tok.TokenKind.comma)) {
                $this().ConsumeToken();
              }
              $this().Actions.EndOpenMPClause();
            }
            // End location of the directive.
            EndLoc.$assignMove($this().Tok.getLocation());
            // Consume final annot_pragma_openmp_end.
            $this().ConsumeToken();
            
            // OpenMP [2.13.8, ordered Construct, Syntax]
            // If the depend clause is specified, the ordered construct is a stand-alone
            // directive.
            if (DKind == OpenMPDirectiveKind.OMPD_ordered && FirstClauses.$at(/*KEEP_ENUM*/OpenMPClauseKind.OMPC_depend.getValue()).getInt()) {
              if (Allowed == AllowedContsructsKind.ACK_StatementsOpenMPNonStandalone) {
                JavaCleaner $c$ = $createJavaCleaner();
                try {
                  $c$.clean($out_DiagnosticBuilder$C_char$ptr$C($out_DiagnosticBuilder$C_int($out_DiagnosticBuilder$C_char$ptr$C($c$.track($this().Diag(new SourceLocation(Loc), diag.err_omp_immediate_directive)), 
                              getOpenMPDirectiveName(DKind)), 1), 
                      getOpenMPClauseName(OpenMPClauseKind.OMPC_depend)));
                } finally {
                  $c$.$destroy();
                }
              }
              HasAssociatedStatement = false;
            }
            
            ActionResultTTrue<Stmt /*P*/ > AssociatedStmt/*J*/= new ActionResultTTrue<Stmt /*P*/ >();
            if (HasAssociatedStatement) {
              Sema.CompoundScopeRAII CompoundScope = null;
              try {
                // The body is a block scope like in Lambdas and Blocks.
                CompoundScope/*J*/= new Sema.CompoundScopeRAII($this().Actions);
                $this().Actions.ActOnOpenMPRegionStart(DKind, $this().getCurScope());
                $this().Actions.ActOnStartOfCompoundStmt();
                // Parse statement
                AssociatedStmt.$assignMove($this().ParseStatement());
                $this().Actions.ActOnFinishOfCompoundStmt();
                AssociatedStmt.$assignMove($this().Actions.ActOnOpenMPRegionEnd(new ActionResultTTrue<Stmt /*P*/ >(AssociatedStmt), new ArrayRef<OMPClause /*P*/ >(Clauses)));
              } finally {
                if (CompoundScope != null) { CompoundScope.$destroy(); }
              }
            }
            Directive.$assignMove($this().Actions.ActOnOpenMPExecutableDirective(DKind, DirName, CancelRegion, new ArrayRef<OMPClause /*P*/ >(Clauses), AssociatedStmt.get(), new SourceLocation(Loc), 
                    new SourceLocation(EndLoc)));
            
            // Exit scope.
            $this().Actions.EndOpenMPDSABlock(Directive.get());
            OMPDirectiveScope.Exit();
            break;
          } finally {
            if (OMPDirectiveScope != null) { OMPDirectiveScope.$destroy(); }
          }
        }
       case OMPD_declare_simd:
       case OMPD_declare_target:
       case OMPD_end_declare_target:
        {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            $c$.clean($out_DiagnosticBuilder$C_char$ptr$C($c$.track($this().Diag($this().Tok, diag.err_omp_unexpected_directive)), 
                getOpenMPDirectiveName(DKind)));
            $this().SkipUntil(tok.TokenKind.annot_pragma_openmp_end);
            break;
          } finally {
            $c$.$destroy();
          }
        }
       case OMPD_unknown:
        {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            $c$.clean($c$.track($this().Diag($this().Tok, diag.err_omp_unknown_directive)));
            $this().SkipUntil(tok.TokenKind.annot_pragma_openmp_end);
            break;
          } finally {
            $c$.$destroy();
          }
        }
      }
      return Directive;
    } finally {
      if (BalancerRAIIObj != null) { BalancerRAIIObj.$destroy(); }
    }
  }

/// \brief Parses clause of kind \a CKind for directive of a kind \a Kind.
///
/// \param DKind Kind of current directive.
/// \param CKind Kind of current clause.
/// \param FirstClause true, if this is the first clause of a kind \a CKind
/// in current directive.
///

/// \brief Parsing of OpenMP clauses.
///
///    clause:
///       if-clause | final-clause | num_threads-clause | safelen-clause |
///       default-clause | private-clause | firstprivate-clause | shared-clause
///       | linear-clause | aligned-clause | collapse-clause |
///       lastprivate-clause | reduction-clause | proc_bind-clause |
///       schedule-clause | copyin-clause | copyprivate-clause | untied-clause |
///       mergeable-clause | flush-clause | read-clause | write-clause |
///       update-clause | capture-clause | seq_cst-clause | device-clause |
///       simdlen-clause | threads-clause | simd-clause | num_teams-clause |
///       thread_limit-clause | priority-clause | grainsize-clause |
///       nogroup-clause | num_tasks-clause | hint-clause | to-clause |
///       from-clause | is_device_ptr-clause
///
//<editor-fold defaultstate="collapsed" desc="clang::Parser::ParseOpenMPClause">
@Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseOpenMP.cpp", line = 1066,
   FQN="clang::Parser::ParseOpenMPClause", NM="_ZN5clang6Parser17ParseOpenMPClauseENS_19OpenMPDirectiveKindENS_16OpenMPClauseKindEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseOpenMP.cpp -nm=_ZN5clang6Parser17ParseOpenMPClauseENS_19OpenMPDirectiveKindENS_16OpenMPClauseKindEb")
  //</editor-fold>
  protected /*private*/ OMPClause /*P*/ ParseOpenMPClause(OpenMPDirectiveKind DKind, 
                   OpenMPClauseKind CKind, boolean FirstClause) {
    OMPClause /*P*/ Clause = null;
    boolean ErrorFound = false;
    // Check if clause is allowed for the given directive.
    if (CKind != OpenMPClauseKind.OMPC_unknown && !isAllowedClauseForDirective(DKind, CKind)) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_DiagnosticBuilder$C_char$ptr$C($out_DiagnosticBuilder$C_char$ptr$C($c$.track($this().Diag($this().Tok, diag.err_omp_unexpected_clause)), getOpenMPClauseName(CKind)), 
            getOpenMPDirectiveName(DKind)));
        ErrorFound = true;
      } finally {
        $c$.$destroy();
      }
    }
    switch (CKind) {
     case OMPC_final:
     case OMPC_num_threads:
     case OMPC_safelen:
     case OMPC_simdlen:
     case OMPC_collapse:
     case OMPC_ordered:
     case OMPC_device:
     case OMPC_num_teams:
     case OMPC_thread_limit:
     case OMPC_priority:
     case OMPC_grainsize:
     case OMPC_num_tasks:
     case OMPC_hint:
      // OpenMP [2.5, Restrictions]
      //  At most one num_threads clause can appear on the directive.
      // OpenMP [2.8.1, simd construct, Restrictions]
      //  Only one safelen  clause can appear on a simd directive.
      //  Only one simdlen  clause can appear on a simd directive.
      //  Only one collapse clause can appear on a simd directive.
      // OpenMP [2.9.1, target data construct, Restrictions]
      //  At most one device clause can appear on the directive.
      // OpenMP [2.11.1, task Construct, Restrictions]
      //  At most one if clause can appear on the directive.
      //  At most one final clause can appear on the directive.
      // OpenMP [teams Construct, Restrictions]
      //  At most one num_teams clause can appear on the directive.
      //  At most one thread_limit clause can appear on the directive.
      // OpenMP [2.9.1, task Construct, Restrictions]
      // At most one priority clause can appear on the directive.
      // OpenMP [2.9.2, taskloop Construct, Restrictions]
      // At most one grainsize clause can appear on the directive.
      // OpenMP [2.9.2, taskloop Construct, Restrictions]
      // At most one num_tasks clause can appear on the directive.
      if (!FirstClause) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_DiagnosticBuilder$C_int($out_DiagnosticBuilder$C_char$ptr$C($out_DiagnosticBuilder$C_char$ptr$C($c$.track($this().Diag($this().Tok, diag.err_omp_more_one_clause)), 
                      getOpenMPDirectiveName(DKind)), getOpenMPClauseName(CKind)), 0));
          ErrorFound = true;
        } finally {
          $c$.$destroy();
        }
      }
      if (CKind == OpenMPClauseKind.OMPC_ordered && $this().PP.LookAhead(/*N=*/ 0).isNot(tok.TokenKind.l_paren)) {
        Clause = $this().ParseOpenMPClause(CKind);
      } else {
        Clause = $this().ParseOpenMPSingleExprClause(CKind);
      }
      break;
     case OMPC_default:
     case OMPC_proc_bind:
      // OpenMP [2.14.3.1, Restrictions]
      //  Only a single default clause may be specified on a parallel, task or
      //  teams directive.
      // OpenMP [2.5, parallel Construct, Restrictions]
      //  At most one proc_bind clause can appear on the directive.
      if (!FirstClause) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_DiagnosticBuilder$C_int($out_DiagnosticBuilder$C_char$ptr$C($out_DiagnosticBuilder$C_char$ptr$C($c$.track($this().Diag($this().Tok, diag.err_omp_more_one_clause)), 
                      getOpenMPDirectiveName(DKind)), getOpenMPClauseName(CKind)), 0));
          ErrorFound = true;
        } finally {
          $c$.$destroy();
        }
      }
      
      Clause = $this().ParseOpenMPSimpleClause(CKind);
      break;
     case OMPC_schedule:
     case OMPC_dist_schedule:
     case OMPC_defaultmap:
      // OpenMP [2.7.1, Restrictions, p. 3]
      //  Only one schedule clause can appear on a loop directive.
      // OpenMP [2.10.4, Restrictions, p. 106]
      //  At most one defaultmap clause can appear on the directive.
      if (!FirstClause) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_DiagnosticBuilder$C_int($out_DiagnosticBuilder$C_char$ptr$C($out_DiagnosticBuilder$C_char$ptr$C($c$.track($this().Diag($this().Tok, diag.err_omp_more_one_clause)), 
                      getOpenMPDirectiveName(DKind)), getOpenMPClauseName(CKind)), 0));
          ErrorFound = true;
        } finally {
          $c$.$destroy();
        }
      }
     case OMPC_if:
      Clause = $this().ParseOpenMPSingleExprWithArgClause(CKind);
      break;
     case OMPC_nowait:
     case OMPC_untied:
     case OMPC_mergeable:
     case OMPC_read:
     case OMPC_write:
     case OMPC_update:
     case OMPC_capture:
     case OMPC_seq_cst:
     case OMPC_threads:
     case OMPC_simd:
     case OMPC_nogroup:
      // OpenMP [2.7.1, Restrictions, p. 9]
      //  Only one ordered clause can appear on a loop directive.
      // OpenMP [2.7.1, Restrictions, C/C++, p. 4]
      //  Only one nowait clause can appear on a for directive.
      if (!FirstClause) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_DiagnosticBuilder$C_int($out_DiagnosticBuilder$C_char$ptr$C($out_DiagnosticBuilder$C_char$ptr$C($c$.track($this().Diag($this().Tok, diag.err_omp_more_one_clause)), 
                      getOpenMPDirectiveName(DKind)), getOpenMPClauseName(CKind)), 0));
          ErrorFound = true;
        } finally {
          $c$.$destroy();
        }
      }
      
      Clause = $this().ParseOpenMPClause(CKind);
      break;
     case OMPC_private:
     case OMPC_firstprivate:
     case OMPC_lastprivate:
     case OMPC_shared:
     case OMPC_reduction:
     case OMPC_linear:
     case OMPC_aligned:
     case OMPC_copyin:
     case OMPC_copyprivate:
     case OMPC_flush:
     case OMPC_depend:
     case OMPC_map:
     case OMPC_to:
     case OMPC_from:
     case OMPC_use_device_ptr:
     case OMPC_is_device_ptr:
      Clause = $this().ParseOpenMPVarListClause(DKind, CKind);
      break;
     case OMPC_unknown:
      {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_DiagnosticBuilder$C_char$ptr$C($c$.track($this().Diag($this().Tok, diag.warn_omp_extra_tokens_at_eol)), 
              getOpenMPDirectiveName(DKind)));
          $this().SkipUntil(tok.TokenKind.annot_pragma_openmp_end, SkipUntilFlags.StopBeforeMatch);
          break;
        } finally {
          $c$.$destroy();
        }
      }
     case OMPC_threadprivate:
     case OMPC_uniform:
      {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_DiagnosticBuilder$C_char$ptr$C($out_DiagnosticBuilder$C_char$ptr$C($c$.track($this().Diag($this().Tok, diag.err_omp_unexpected_clause)), getOpenMPClauseName(CKind)), 
              getOpenMPDirectiveName(DKind)));
          $this().SkipUntil(tok.TokenKind.comma, tok.TokenKind.annot_pragma_openmp_end, SkipUntilFlags.StopBeforeMatch);
          break;
        } finally {
          $c$.$destroy();
        }
      }
    }
    return ErrorFound ? null : Clause;
  }

/// \brief Parses clause with a single expression of a kind \a Kind.
///
/// \param Kind Kind of current clause.
///

/// \brief Parsing of OpenMP clauses with single expressions like 'final',
/// 'collapse', 'safelen', 'num_threads', 'simdlen', 'num_teams',
/// 'thread_limit', 'simdlen', 'priority', 'grainsize', 'num_tasks' or 'hint'.
///
///    final-clause:
///      'final' '(' expression ')'
///
///    num_threads-clause:
///      'num_threads' '(' expression ')'
///
///    safelen-clause:
///      'safelen' '(' expression ')'
///
///    simdlen-clause:
///      'simdlen' '(' expression ')'
///
///    collapse-clause:
///      'collapse' '(' expression ')'
///
///    priority-clause:
///      'priority' '(' expression ')'
///
///    grainsize-clause:
///      'grainsize' '(' expression ')'
///
///    num_tasks-clause:
///      'num_tasks' '(' expression ')'
///
///    hint-clause:
///      'hint' '(' expression ')'
///
//<editor-fold defaultstate="collapsed" desc="clang::Parser::ParseOpenMPSingleExprClause">
@Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseOpenMP.cpp", line = 1262,
   FQN="clang::Parser::ParseOpenMPSingleExprClause", NM="_ZN5clang6Parser27ParseOpenMPSingleExprClauseENS_16OpenMPClauseKindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseOpenMP.cpp -nm=_ZN5clang6Parser27ParseOpenMPSingleExprClauseENS_16OpenMPClauseKindE")
  //</editor-fold>
  protected /*private*/ OMPClause /*P*/ ParseOpenMPSingleExprClause(OpenMPClauseKind Kind) {
    SourceLocation Loc = $this().ConsumeToken();
    SourceLocation LLoc = $this().Tok.getLocation();
    SourceLocation RLoc/*J*/= new SourceLocation();
    
    ActionResultTTrue<Expr /*P*/ > Val = $this().ParseOpenMPParensExpr(new StringRef(getOpenMPClauseName(Kind)), RLoc);
    if (Val.isInvalid()) {
      return null;
    }
    
    return $this().Actions.ActOnOpenMPSingleExprClause(Kind, Val.get(), new SourceLocation(Loc), new SourceLocation(LLoc), new SourceLocation(RLoc));
  }

/// \brief Parses simple clause of a kind \a Kind.
///
/// \param Kind Kind of current clause.
///

/// \brief Parsing of simple OpenMP clauses like 'default' or 'proc_bind'.
///
///    default-clause:
///         'default' '(' 'none' | 'shared' ')
///
///    proc_bind-clause:
///         'proc_bind' '(' 'master' | 'close' | 'spread' ')
///
//<editor-fold defaultstate="collapsed" desc="clang::Parser::ParseOpenMPSimpleClause">
@Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseOpenMP.cpp", line = 1283,
   FQN="clang::Parser::ParseOpenMPSimpleClause", NM="_ZN5clang6Parser23ParseOpenMPSimpleClauseENS_16OpenMPClauseKindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseOpenMP.cpp -nm=_ZN5clang6Parser23ParseOpenMPSimpleClauseENS_16OpenMPClauseKindE")
  //</editor-fold>
  protected /*private*/ OMPClause /*P*/ ParseOpenMPSimpleClause(OpenMPClauseKind Kind) {
    BalancedDelimiterTracker T = null;
    try {
      SourceLocation Loc = $this().Tok.getLocation();
      SourceLocation LOpen = $this().ConsumeToken();
      // Parse '('.
      T/*J*/= new BalancedDelimiterTracker(/*Deref*/$this(), tok.TokenKind.l_paren, tok.TokenKind.annot_pragma_openmp_end);
      if (T.expectAndConsume(diag.err_expected_lparen_after, 
          getOpenMPClauseName(Kind))) {
        return null;
      }
      
      /*uint*/int Type = getOpenMPSimpleClauseType(Kind, new StringRef($this().Tok.isAnnotation() ? new std.string(/*KEEP_STR*/$EMPTY) : $this().PP.getSpelling($this().Tok)));
      SourceLocation TypeLoc = $this().Tok.getLocation();
      if ($this().Tok.isNot(tok.TokenKind.r_paren) && $this().Tok.isNot(tok.TokenKind.comma)
         && $this().Tok.isNot(tok.TokenKind.annot_pragma_openmp_end)) {
        $this().ConsumeAnyToken();
      }
      
      // Parse ')'.
      T.consumeClose();
      
      return $this().Actions.ActOnOpenMPSimpleClause(Kind, Type, new SourceLocation(TypeLoc), new SourceLocation(LOpen), new SourceLocation(Loc), 
          $this().Tok.getLocation());
    } finally {
      if (T != null) { T.$destroy(); }
    }
  }

/// \brief Parses clause with a single expression and an additional argument
/// of a kind \a Kind.
///
/// \param Kind Kind of current clause.
///

/// \brief Parsing of OpenMP clauses with single expressions and some additional
/// argument like 'schedule' or 'dist_schedule'.
///
///    schedule-clause:
///      'schedule' '(' [ modifier [ ',' modifier ] ':' ] kind [',' expression ]
///      ')'
///
///    if-clause:
///      'if' '(' [ directive-name-modifier ':' ] expression ')'
///
///    defaultmap:
///      'defaultmap' '(' modifier ':' kind ')'
///
//<editor-fold defaultstate="collapsed" desc="clang::Parser::ParseOpenMPSingleExprWithArgClause">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseOpenMP.cpp", line = 1353,
   FQN="clang::Parser::ParseOpenMPSingleExprWithArgClause", NM="_ZN5clang6Parser34ParseOpenMPSingleExprWithArgClauseENS_16OpenMPClauseKindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseOpenMP.cpp -nm=_ZN5clang6Parser34ParseOpenMPSingleExprWithArgClauseENS_16OpenMPClauseKindE")
  //</editor-fold>
  protected /*private*/ OMPClause /*P*/ ParseOpenMPSingleExprWithArgClause(OpenMPClauseKind Kind) {
    BalancedDelimiterTracker T = null;
    try {
      SourceLocation Loc = $this().ConsumeToken();
      SourceLocation DelimLoc/*J*/= new SourceLocation();
      // Parse '('.
      T/*J*/= new BalancedDelimiterTracker(/*Deref*/$this(), tok.TokenKind.l_paren, tok.TokenKind.annot_pragma_openmp_end);
      if (T.expectAndConsume(diag.err_expected_lparen_after, 
          getOpenMPClauseName(Kind))) {
        return null;
      }
      
      ActionResultTTrue<Expr /*P*/ > Val/*J*/= new ActionResultTTrue<Expr /*P*/ >();
      SmallVectorUInt Arg/*J*/= new SmallVectorUInt(4, 0);
      SmallVector<SourceLocation> KLoc/*J*/= new SmallVector<SourceLocation>(4, new SourceLocation());
      if (Kind == OpenMPClauseKind.OMPC_schedule) {
//        //<editor-fold defaultstate="collapsed" desc="">
//        @Converted(kind = Converted.Kind.AUTO,
//         source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseOpenMP.cpp", line = 1366,
//         FQN="", NM="_ZN5clang6Parser34ParseOpenMPSingleExprWithArgClauseENS_16OpenMPClauseKindE_Unnamed_enum",
//         cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseOpenMP.cpp -nm=_ZN5clang6Parser34ParseOpenMPSingleExprWithArgClauseENS_16OpenMPClauseKindE_Unnamed_enum")
//        //</editor-fold>
        /*enum ANONYMOUS_INT_CONSTANTS {*/
          final /*uint*/int Modifier1 = 0;
          final /*uint*/int Modifier2 = Modifier1 + 1;
          final /*uint*/int ScheduleKind = Modifier2 + 1;
          final /*uint*/int NumberOfElements = ScheduleKind + 1;
        /*}*/;
        Arg.resize(NumberOfElements);
        KLoc.resize(NumberOfElements);
        Arg.$set(/*KEEP_ENUM*/Modifier1, OpenMPScheduleClauseModifier.OMPC_SCHEDULE_MODIFIER_unknown);
        Arg.$set(/*KEEP_ENUM*/Modifier2, OpenMPScheduleClauseModifier.OMPC_SCHEDULE_MODIFIER_unknown);
        Arg.$set(/*KEEP_ENUM*/ScheduleKind, OpenMPScheduleClauseKind.OMPC_SCHEDULE_unknown);
        /*uint*/int KindModifier = getOpenMPSimpleClauseType(Kind, new StringRef($this().Tok.isAnnotation() ? new std.string(/*KEEP_STR*/$EMPTY) : $this().PP.getSpelling($this().Tok)));
        if ($greater_uint_int(KindModifier, OpenMPScheduleClauseKind.OMPC_SCHEDULE_unknown)) {
          // Parse 'modifier'
          Arg.$set(/*KEEP_ENUM*/Modifier1, KindModifier);
          KLoc.$at(/*KEEP_ENUM*/Modifier1).$assignMove($this().Tok.getLocation());
          if ($this().Tok.isNot(tok.TokenKind.r_paren) && $this().Tok.isNot(tok.TokenKind.comma)
             && $this().Tok.isNot(tok.TokenKind.annot_pragma_openmp_end)) {
            $this().ConsumeAnyToken();
          }
          if ($this().Tok.is(tok.TokenKind.comma)) {
            // Parse ',' 'modifier'
            $this().ConsumeAnyToken();
            KindModifier = getOpenMPSimpleClauseType(Kind, new StringRef($this().Tok.isAnnotation() ? new std.string(/*KEEP_STR*/$EMPTY) : $this().PP.getSpelling($this().Tok)));
            Arg.$set(/*KEEP_ENUM*/Modifier2, $greater_uint_int(KindModifier, OpenMPScheduleClauseKind.OMPC_SCHEDULE_unknown) ? KindModifier : (/*uint*/int)OpenMPScheduleClauseKind.OMPC_SCHEDULE_unknown);
            KLoc.$at(/*KEEP_ENUM*/Modifier2).$assignMove($this().Tok.getLocation());
            if ($this().Tok.isNot(tok.TokenKind.r_paren) && $this().Tok.isNot(tok.TokenKind.comma)
               && $this().Tok.isNot(tok.TokenKind.annot_pragma_openmp_end)) {
              $this().ConsumeAnyToken();
            }
          }
          // Parse ':'
          if ($this().Tok.is(tok.TokenKind.colon)) {
            $this().ConsumeAnyToken();
          } else {
            JavaCleaner $c$ = $createJavaCleaner();
            try {
              $c$.clean($out_DiagnosticBuilder$C_char$ptr$C($c$.track($this().Diag($this().Tok, diag.warn_pragma_expected_colon)), /*KEEP_STR*/"schedule modifier"));
            } finally {
              $c$.$destroy();
            }
          }
          KindModifier = getOpenMPSimpleClauseType(Kind, new StringRef($this().Tok.isAnnotation() ? new std.string(/*KEEP_STR*/$EMPTY) : $this().PP.getSpelling($this().Tok)));
        }
        Arg.$set(/*KEEP_ENUM*/ScheduleKind, KindModifier);
        KLoc.$at(/*KEEP_ENUM*/ScheduleKind).$assignMove($this().Tok.getLocation());
        if ($this().Tok.isNot(tok.TokenKind.r_paren) && $this().Tok.isNot(tok.TokenKind.comma)
           && $this().Tok.isNot(tok.TokenKind.annot_pragma_openmp_end)) {
          $this().ConsumeAnyToken();
        }
        if ((Arg.$at(/*KEEP_ENUM*/ScheduleKind) == OpenMPScheduleClauseKind.OMPC_SCHEDULE_static
           || Arg.$at(/*KEEP_ENUM*/ScheduleKind) == OpenMPScheduleClauseKind.OMPC_SCHEDULE_dynamic
           || Arg.$at(/*KEEP_ENUM*/ScheduleKind) == OpenMPScheduleClauseKind.OMPC_SCHEDULE_guided)
           && $this().Tok.is(tok.TokenKind.comma)) {
          DelimLoc.$assignMove($this().ConsumeAnyToken());
        }
      } else if (Kind == OpenMPClauseKind.OMPC_dist_schedule) {
        Arg.push_back(getOpenMPSimpleClauseType(Kind, new StringRef($this().Tok.isAnnotation() ? new std.string(/*KEEP_STR*/$EMPTY) : $this().PP.getSpelling($this().Tok))));
        KLoc.push_back($this().Tok.getLocation());
        if ($this().Tok.isNot(tok.TokenKind.r_paren) && $this().Tok.isNot(tok.TokenKind.comma)
           && $this().Tok.isNot(tok.TokenKind.annot_pragma_openmp_end)) {
          $this().ConsumeAnyToken();
        }
        if (Arg.back() == OpenMPDistScheduleClauseKind.OMPC_DIST_SCHEDULE_static && $this().Tok.is(tok.TokenKind.comma)) {
          DelimLoc.$assignMove($this().ConsumeAnyToken());
        }
      } else if (Kind == OpenMPClauseKind.OMPC_defaultmap) {
        // Get a defaultmap modifier
        Arg.push_back(getOpenMPSimpleClauseType(Kind, new StringRef($this().Tok.isAnnotation() ? new std.string(/*KEEP_STR*/$EMPTY) : $this().PP.getSpelling($this().Tok))));
        KLoc.push_back($this().Tok.getLocation());
        if ($this().Tok.isNot(tok.TokenKind.r_paren) && $this().Tok.isNot(tok.TokenKind.comma)
           && $this().Tok.isNot(tok.TokenKind.annot_pragma_openmp_end)) {
          $this().ConsumeAnyToken();
        }
        // Parse ':'
        if ($this().Tok.is(tok.TokenKind.colon)) {
          $this().ConsumeAnyToken();
        } else if (Arg.back() != OpenMPDefaultmapClauseModifier.OMPC_DEFAULTMAP_MODIFIER_unknown) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            $c$.clean($out_DiagnosticBuilder$C_char$ptr$C($c$.track($this().Diag($this().Tok, diag.warn_pragma_expected_colon)), /*KEEP_STR*/"defaultmap modifier"));
          } finally {
            $c$.$destroy();
          }
        }
        // Get a defaultmap kind
        Arg.push_back(getOpenMPSimpleClauseType(Kind, new StringRef($this().Tok.isAnnotation() ? new std.string(/*KEEP_STR*/$EMPTY) : $this().PP.getSpelling($this().Tok))));
        KLoc.push_back($this().Tok.getLocation());
        if ($this().Tok.isNot(tok.TokenKind.r_paren) && $this().Tok.isNot(tok.TokenKind.comma)
           && $this().Tok.isNot(tok.TokenKind.annot_pragma_openmp_end)) {
          $this().ConsumeAnyToken();
        }
      } else {
        assert (Kind == OpenMPClauseKind.OMPC_if);
        KLoc.push_back($this().Tok.getLocation());
        Arg.push_back(ParseOpenMPDirectiveKind(/*Deref*/$this()).getValue());
        if (Arg.back() != OpenMPDirectiveKind.OMPD_unknown.getValue()) {
          $this().ConsumeToken();
          if ($this().Tok.is(tok.TokenKind.colon)) {
            DelimLoc.$assignMove($this().ConsumeToken());
          } else {
            JavaCleaner $c$ = $createJavaCleaner();
            try {
              $c$.clean($out_DiagnosticBuilder$C_char$ptr$C($c$.track($this().Diag($this().Tok, diag.warn_pragma_expected_colon)), 
                  /*KEEP_STR*/"directive name modifier"));
            } finally {
              $c$.$destroy();
            }
          }
        }
      }
      
      boolean NeedAnExpression = (Kind == OpenMPClauseKind.OMPC_schedule && DelimLoc.isValid())
         || (Kind == OpenMPClauseKind.OMPC_dist_schedule && DelimLoc.isValid())
         || Kind == OpenMPClauseKind.OMPC_if;
      if (NeedAnExpression) {
        SourceLocation ELoc = $this().Tok.getLocation();
        ActionResultTTrue<Expr /*P*/ > LHS/*J*/= $this().ParseCastExpression(false, false, TypeCastState.NotTypeCast);
        Val.$assignMove($this().ParseRHSOfBinaryExpression(new ActionResultTTrue<Expr /*P*/ >(LHS), prec.Level.Conditional));
        Val.$assignMove($this().Actions.ActOnFinishFullExpr(Val.get(), new SourceLocation(ELoc)));
      }
      
      // Parse ')'.
      T.consumeClose();
      if (NeedAnExpression && Val.isInvalid()) {
        return null;
      }
      
      return $this().Actions.ActOnOpenMPSingleExprWithArgClause(Kind, new ArrayRefUInt(Arg), Val.get(), new SourceLocation(Loc), T.getOpenLocation(), new ArrayRef<SourceLocation>(KLoc), new SourceLocation(DelimLoc), 
          T.getCloseLocation());
    } finally {
      if (T != null) { T.$destroy(); }
    }
  }

/// \brief Parses clause without any additional arguments.
///
/// \param Kind Kind of current clause.
///

/// \brief Parsing of OpenMP clauses like 'ordered'.
///
///    ordered-clause:
///         'ordered'
///
///    nowait-clause:
///         'nowait'
///
///    untied-clause:
///         'untied'
///
///    mergeable-clause:
///         'mergeable'
///
///    read-clause:
///         'read'
///
///    threads-clause:
///         'threads'
///
///    simd-clause:
///         'simd'
///
///    nogroup-clause:
///         'nogroup'
///
//<editor-fold defaultstate="collapsed" desc="clang::Parser::ParseOpenMPClause">
@Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseOpenMP.cpp", line = 1332,
   FQN="clang::Parser::ParseOpenMPClause", NM="_ZN5clang6Parser17ParseOpenMPClauseENS_16OpenMPClauseKindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseOpenMP.cpp -nm=_ZN5clang6Parser17ParseOpenMPClauseENS_16OpenMPClauseKindE")
  //</editor-fold>
  protected /*private*/ OMPClause /*P*/ ParseOpenMPClause(OpenMPClauseKind Kind) {
    SourceLocation Loc = $this().Tok.getLocation();
    $this().ConsumeAnyToken();
    
    return $this().Actions.ActOnOpenMPClause(Kind, new SourceLocation(Loc), $this().Tok.getLocation());
  }

/// \brief Parses clause with the list of variables of a kind \a Kind.
///
/// \param Kind Kind of current clause.
///

/// \brief Parsing of OpenMP clause 'private', 'firstprivate', 'lastprivate',
/// 'shared', 'copyin', 'copyprivate', 'flush' or 'reduction'.
///
///    private-clause:
///       'private' '(' list ')'
///    firstprivate-clause:
///       'firstprivate' '(' list ')'
///    lastprivate-clause:
///       'lastprivate' '(' list ')'
///    shared-clause:
///       'shared' '(' list ')'
///    linear-clause:
///       'linear' '(' linear-list [ ':' linear-step ] ')'
///    aligned-clause:
///       'aligned' '(' list [ ':' alignment ] ')'
///    reduction-clause:
///       'reduction' '(' reduction-identifier ':' list ')'
///    copyprivate-clause:
///       'copyprivate' '(' list ')'
///    flush-clause:
///       'flush' '(' list ')'
///    depend-clause:
///       'depend' '(' in | out | inout : list | source ')'
///    map-clause:
///       'map' '(' [ [ always , ]
///          to | from | tofrom | alloc | release | delete ':' ] list ')';
///    to-clause:
///       'to' '(' list ')'
///    from-clause:
///       'from' '(' list ')'
///    use_device_ptr-clause:
///       'use_device_ptr' '(' list ')'
///    is_device_ptr-clause:
///       'is_device_ptr' '(' list ')'
///
/// For 'linear' clause linear-list may have the following forms:
///  list
///  modifier(list)
/// where modifier is 'val' (C) or 'ref', 'val' or 'uval'(C++).
//<editor-fold defaultstate="collapsed" desc="clang::Parser::ParseOpenMPVarListClause">
@Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseOpenMP.cpp", line = 1765,
   FQN="clang::Parser::ParseOpenMPVarListClause", NM="_ZN5clang6Parser24ParseOpenMPVarListClauseENS_19OpenMPDirectiveKindENS_16OpenMPClauseKindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseOpenMP.cpp -nm=_ZN5clang6Parser24ParseOpenMPVarListClauseENS_19OpenMPDirectiveKindENS_16OpenMPClauseKindE")
  //</editor-fold>
  protected /*private*/ OMPClause /*P*/ ParseOpenMPVarListClause(OpenMPDirectiveKind DKind, 
                          OpenMPClauseKind Kind) {
    OpenMPVarListDataTy Data = null;
    try {
      SourceLocation Loc = $this().Tok.getLocation();
      SourceLocation LOpen = $this().ConsumeToken();
      SmallVector<Expr /*P*/ > Vars/*J*/= new SmallVector<Expr /*P*/ >(4, (Expr /*P*/ )null);
      Data/*J*/= new OpenMPVarListDataTy();
      if ($this().ParseOpenMPVarList(DKind, Kind, Vars, Data)) {
        return null;
      }
      
      return $this().Actions.ActOnOpenMPVarListClause(Kind, new ArrayRef<Expr /*P*/ >(Vars), Data.TailExpr, new SourceLocation(Loc), new SourceLocation(LOpen), new SourceLocation(Data.ColonLoc), $this().Tok.getLocation(), 
          Data.ReductionIdScopeSpec, Data.ReductionId, Data.DepKind, Data.LinKind, 
          Data.MapTypeModifier, Data.MapType, Data.IsMapTypeImplicit, 
          new SourceLocation(Data.DepLinMapLoc));
    } finally {
      if (Data != null) { Data.$destroy(); }
    }
  }

/// Parses simple expression in parens for single-expression clauses of OpenMP
/// constructs.
/// \param RLoc Returned location of right paren.

/// Parses simple expression in parens for single-expression clauses of OpenMP
/// constructs.
/// \param RLoc Returned location of right paren.
//<editor-fold defaultstate="collapsed" desc="clang::Parser::ParseOpenMPParensExpr">
@Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseOpenMP.cpp", line = 1212,
   FQN="clang::Parser::ParseOpenMPParensExpr", NM="_ZN5clang6Parser21ParseOpenMPParensExprEN4llvm9StringRefERNS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseOpenMP.cpp -nm=_ZN5clang6Parser21ParseOpenMPParensExprEN4llvm9StringRefERNS_14SourceLocationE")
  //</editor-fold>
  public ActionResultTTrue<Expr /*P*/ > ParseOpenMPParensExpr(StringRef ClauseName, 
                       final SourceLocation /*&*/ RLoc) {
    BalancedDelimiterTracker T = null;
    try {
      T/*J*/= new BalancedDelimiterTracker(/*Deref*/$this(), tok.TokenKind.l_paren, tok.TokenKind.annot_pragma_openmp_end);
      if (T.expectAndConsume(diag.err_expected_lparen_after, ClauseName.data())) {
        return ExprError();
      }
      
      SourceLocation ELoc = $this().Tok.getLocation();
      ActionResultTTrue<Expr /*P*/ > LHS/*J*/= $this().ParseCastExpression(/*isUnaryExpression=*/ false, /*isAddressOfOperand=*/ false, TypeCastState.NotTypeCast);
      ActionResultTTrue<Expr /*P*/ > Val/*J*/= $this().ParseRHSOfBinaryExpression(new ActionResultTTrue<Expr /*P*/ >(LHS), prec.Level.Conditional);
      Val.$assignMove($this().Actions.ActOnFinishFullExpr(Val.get(), new SourceLocation(ELoc)));
      
      // Parse ')'.
      T.consumeClose();
      
      RLoc.$assignMove(T.getCloseLocation());
      return Val;
    } finally {
      if (T != null) { T.$destroy(); }
    }
  }


/// Parses clauses with list.

/// Parses clauses with list.
//<editor-fold defaultstate="collapsed" desc="clang::Parser::ParseOpenMPVarList">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseOpenMP.cpp", line = 1523,
   FQN="clang::Parser::ParseOpenMPVarList", NM="_ZN5clang6Parser18ParseOpenMPVarListENS_19OpenMPDirectiveKindENS_16OpenMPClauseKindERN4llvm15SmallVectorImplIPNS_4ExprEEERNS0_19OpenMPVarListDataTyE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseOpenMP.cpp -nm=_ZN5clang6Parser18ParseOpenMPVarListENS_19OpenMPDirectiveKindENS_16OpenMPClauseKindERN4llvm15SmallVectorImplIPNS_4ExprEEERNS0_19OpenMPVarListDataTyE")
  //</editor-fold>
  public boolean ParseOpenMPVarList(OpenMPDirectiveKind DKind, 
                    OpenMPClauseKind Kind, 
                    final SmallVectorImpl<Expr /*P*/ > /*&*/ Vars, 
                    final OpenMPVarListDataTy /*&*/ Data) {
    BalancedDelimiterTracker T = null;
    BalancedDelimiterTracker LinearT = null;
    try {
      UnqualifiedId UnqualifiedReductionId/*J*/= new UnqualifiedId();
      boolean InvalidReductionId = false;
      boolean MapTypeModifierSpecified = false;
      
      // Parse '('.
      T/*J*/= new BalancedDelimiterTracker(/*Deref*/$this(), tok.TokenKind.l_paren, tok.TokenKind.annot_pragma_openmp_end);
      if (T.expectAndConsume(diag.err_expected_lparen_after, 
          getOpenMPClauseName(Kind))) {
        return true;
      }
      
      boolean NeedRParenForLinear = false;
      LinearT/*J*/= new BalancedDelimiterTracker(/*Deref*/$this(), tok.TokenKind.l_paren, 
          tok.TokenKind.annot_pragma_openmp_end);
      // Handle reduction-identifier for reduction clause.
      if (Kind == OpenMPClauseKind.OMPC_reduction) {
        ColonProtectionRAIIObject ColonRAII = null;
        try {
          ColonRAII/*J*/= new ColonProtectionRAIIObject(/*Deref*/$this());
          if ($this().getLangOpts().CPlusPlus) {
            $this().ParseOptionalCXXScopeSpecifier(Data.ReductionIdScopeSpec, 
                /*ObjectType=*/ new OpaquePtr<QualType>(null), 
                /*EnteringContext=*/ false);
          }
          InvalidReductionId = ParseReductionId(/*Deref*/$this(), Data.ReductionIdScopeSpec, 
              UnqualifiedReductionId);
          if (InvalidReductionId) {
            $this().SkipUntil(tok.TokenKind.colon, tok.TokenKind.r_paren, tok.TokenKind.annot_pragma_openmp_end, 
                SkipUntilFlags.StopBeforeMatch);
          }
          if ($this().Tok.is(tok.TokenKind.colon)) {
            Data.ColonLoc.$assignMove($this().ConsumeToken());
          } else {
            JavaCleaner $c$ = $createJavaCleaner();
            try {
              $c$.clean($out_DiagnosticBuilder$C_char$ptr$C($c$.track($this().Diag($this().Tok, diag.warn_pragma_expected_colon)), /*KEEP_STR*/"reduction identifier"));
            } finally {
              $c$.$destroy();
            }
          }
          if (!InvalidReductionId) {
            Data.ReductionId.$assignMove(
                $this().Actions.GetNameFromUnqualifiedId(UnqualifiedReductionId)
            );
          }
        } finally {
          if (ColonRAII != null) { ColonRAII.$destroy(); }
        }
      } else if (Kind == OpenMPClauseKind.OMPC_depend) {
        ColonProtectionRAIIObject ColonRAII = null;
        try {
          // Handle dependency type for depend clause.
          ColonRAII/*J*/= new ColonProtectionRAIIObject(/*Deref*/$this());
          Data.DepKind
             = /*static_cast*/OpenMPDependClauseKind.valueOf(getOpenMPSimpleClauseType(Kind, new StringRef($this().Tok.is(tok.TokenKind.identifier) ? $this().PP.getSpelling($this().Tok) : new std.string(/*KEEP_STR*/$EMPTY))));
          Data.DepLinMapLoc.$assignMove($this().Tok.getLocation());
          if (Data.DepKind == OpenMPDependClauseKind.OMPC_DEPEND_unknown) {
            $this().SkipUntil(tok.TokenKind.colon, tok.TokenKind.r_paren, tok.TokenKind.annot_pragma_openmp_end, 
                SkipUntilFlags.StopBeforeMatch);
          } else {
            $this().ConsumeToken();
            // Special processing for depend(source) clause.
            if (DKind == OpenMPDirectiveKind.OMPD_ordered && Data.DepKind == OpenMPDependClauseKind.OMPC_DEPEND_source) {
              // Parse ')'.
              T.consumeClose();
              return false;
            }
          }
          if ($this().Tok.is(tok.TokenKind.colon)) {
            Data.ColonLoc.$assignMove($this().ConsumeToken());
          } else {
            JavaCleaner $c$ = $createJavaCleaner();
            try {
              $c$.clean($out_DiagnosticBuilder$C_char$ptr$C($c$.track($this().Diag($this().Tok, DKind == OpenMPDirectiveKind.OMPD_ordered ? diag.warn_pragma_expected_colon_r_paren : diag.warn_pragma_expected_colon)), 
                  /*KEEP_STR*/"dependency type"));
            } finally {
              $c$.$destroy();
            }
          }
        } finally {
          if (ColonRAII != null) { ColonRAII.$destroy(); }
        }
      } else if (Kind == OpenMPClauseKind.OMPC_linear) {
        // Try to parse modifier if any.
        if ($this().Tok.is(tok.TokenKind.identifier) && $this().PP.LookAhead(0).is(tok.TokenKind.l_paren)) {
          Data.LinKind = /*static_cast*/OpenMPLinearClauseKind.valueOf(getOpenMPSimpleClauseType(Kind, new StringRef($this().PP.getSpelling($this().Tok))));
          Data.DepLinMapLoc.$assignMove($this().ConsumeToken());
          LinearT.consumeOpen();
          NeedRParenForLinear = true;
        }
      } else if (Kind == OpenMPClauseKind.OMPC_map) {
        ColonProtectionRAIIObject ColonRAII = null;
        try {
          // Handle map type for map clause.
          ColonRAII/*J*/= new ColonProtectionRAIIObject(/*Deref*/$this());
          
          /// The map clause modifier token can be either a identifier or the C++
          /// delete keyword.
          final BoolPredicate<Token> /*&&*/IsMapClauseModifierToken = /*[]*/(final Token /*&*/ Tok) -> 
            {
              return Tok.isOneOf(tok.TokenKind.identifier, tok.TokenKind.kw_delete);
            }
  ;
          
          // The first identifier may be a list item, a map-type or a
          // map-type-modifier. The map modifier can also be delete which has the same
          // spelling of the C++ delete keyword.
          Data.MapType
             = IsMapClauseModifierToken.$call($this().Tok) ? /*static_cast*/OpenMPMapClauseKind.valueOf(getOpenMPSimpleClauseType(Kind, new StringRef($this().PP.getSpelling($this().Tok)))) : OpenMPMapClauseKind.OMPC_MAP_unknown;
          Data.DepLinMapLoc.$assignMove($this().Tok.getLocation());
          boolean ColonExpected = false;
          if (IsMapClauseModifierToken.$call($this().Tok)) {
            if ($this().PP.LookAhead(0).is(tok.TokenKind.colon)) {
              if (Data.MapType == OpenMPMapClauseKind.OMPC_MAP_unknown) {
                JavaCleaner $c$ = $createJavaCleaner();
                try {
                  $c$.clean($c$.track($this().Diag($this().Tok, diag.err_omp_unknown_map_type)));
                } finally {
                  $c$.$destroy();
                }
              } else if (Data.MapType == OpenMPMapClauseKind.OMPC_MAP_always) {
                JavaCleaner $c$ = $createJavaCleaner();
                try {
                  $c$.clean($c$.track($this().Diag($this().Tok, diag.err_omp_map_type_missing)));
                } finally {
                  $c$.$destroy();
                }
              }
              $this().ConsumeToken();
            } else if ($this().PP.LookAhead(0).is(tok.TokenKind.comma)) {
              if (IsMapClauseModifierToken.$call($this().PP.LookAhead(1))
                 && $this().PP.LookAhead(2).is(tok.TokenKind.colon)) {
                Data.MapTypeModifier = Data.MapType;
                if (Data.MapTypeModifier != OpenMPMapClauseKind.OMPC_MAP_always) {
                  JavaCleaner $c$ = $createJavaCleaner();
                  try {
                    $c$.clean($c$.track($this().Diag($this().Tok, diag.err_omp_unknown_map_type_modifier)));
                    Data.MapTypeModifier = OpenMPMapClauseKind.OMPC_MAP_unknown;
                  } finally {
                    $c$.$destroy();
                  }
                } else {
                  MapTypeModifierSpecified = true;
                }
                
                $this().ConsumeToken();
                $this().ConsumeToken();
                
                Data.MapType
                   = IsMapClauseModifierToken.$call($this().Tok) ? /*static_cast*/OpenMPMapClauseKind.valueOf(getOpenMPSimpleClauseType(Kind, new StringRef($this().PP.getSpelling($this().Tok)))) : OpenMPMapClauseKind.OMPC_MAP_unknown;
                if (Data.MapType == OpenMPMapClauseKind.OMPC_MAP_unknown
                   || Data.MapType == OpenMPMapClauseKind.OMPC_MAP_always) {
                  JavaCleaner $c$ = $createJavaCleaner();
                  try {
                    $c$.clean($c$.track($this().Diag($this().Tok, diag.err_omp_unknown_map_type)));
                  } finally {
                    $c$.$destroy();
                  }
                }
                $this().ConsumeToken();
              } else {
                Data.MapType = OpenMPMapClauseKind.OMPC_MAP_tofrom;
                Data.IsMapTypeImplicit = true;
              }
            } else {
              Data.MapType = OpenMPMapClauseKind.OMPC_MAP_tofrom;
              Data.IsMapTypeImplicit = true;
            }
          } else {
            Data.MapType = OpenMPMapClauseKind.OMPC_MAP_tofrom;
            Data.IsMapTypeImplicit = true;
          }
          if ($this().Tok.is(tok.TokenKind.colon)) {
            Data.ColonLoc.$assignMove($this().ConsumeToken());
          } else if (ColonExpected) {
            JavaCleaner $c$ = $createJavaCleaner();
            try {
              $c$.clean($out_DiagnosticBuilder$C_char$ptr$C($c$.track($this().Diag($this().Tok, diag.warn_pragma_expected_colon)), /*KEEP_STR*/"map type"));
            } finally {
              $c$.$destroy();
            }
          }
        } finally {
          if (ColonRAII != null) { ColonRAII.$destroy(); }
        }
      }
      
      boolean IsComma = (Kind != OpenMPClauseKind.OMPC_reduction && Kind != OpenMPClauseKind.OMPC_depend && Kind != OpenMPClauseKind.OMPC_map)
         || (Kind == OpenMPClauseKind.OMPC_reduction && !InvalidReductionId)
         || (Kind == OpenMPClauseKind.OMPC_map && Data.MapType != OpenMPMapClauseKind.OMPC_MAP_unknown
         && (!MapTypeModifierSpecified
         || Data.MapTypeModifier == OpenMPMapClauseKind.OMPC_MAP_always))
         || (Kind == OpenMPClauseKind.OMPC_depend && Data.DepKind != OpenMPDependClauseKind.OMPC_DEPEND_unknown);
      /*const*/boolean MayHaveTail = (Kind == OpenMPClauseKind.OMPC_linear || Kind == OpenMPClauseKind.OMPC_aligned);
      while (IsComma || ($this().Tok.isNot(tok.TokenKind.r_paren) && $this().Tok.isNot(tok.TokenKind.colon)
         && $this().Tok.isNot(tok.TokenKind.annot_pragma_openmp_end))) {
        ColonProtectionRAIIObject ColonRAII = null;
        try {
          ColonRAII/*J*/= new ColonProtectionRAIIObject(/*Deref*/$this(), MayHaveTail);
          // Parse variable
          ActionResultTTrue<Expr /*P*/ > VarExpr = $this().Actions.CorrectDelayedTyposInExpr($this().ParseAssignmentExpression());
          if (VarExpr.isUsable()) {
            Vars.push_back(VarExpr.get());
          } else {
            $this().SkipUntil(tok.TokenKind.comma, tok.TokenKind.r_paren, tok.TokenKind.annot_pragma_openmp_end, 
                SkipUntilFlags.StopBeforeMatch);
          }
          // Skip ',' if any
          IsComma = $this().Tok.is(tok.TokenKind.comma);
          if (IsComma) {
            $this().ConsumeToken();
          } else if ($this().Tok.isNot(tok.TokenKind.r_paren)
             && $this().Tok.isNot(tok.TokenKind.annot_pragma_openmp_end)
             && (!MayHaveTail || $this().Tok.isNot(tok.TokenKind.colon))) {
            JavaCleaner $c$ = $createJavaCleaner();
            try {
              $c$.clean($out$Same2Bool($out_DiagnosticBuilder$C_char$ptr$C($c$.track($this().Diag($this().Tok, diag.err_omp_expected_punc)), 
                      ((Kind == OpenMPClauseKind.OMPC_flush) ? getOpenMPDirectiveName(OpenMPDirectiveKind.OMPD_flush) : getOpenMPClauseName(Kind))), 
                  (Kind == OpenMPClauseKind.OMPC_flush)));
            } finally {
              $c$.$destroy();
            }
          }
        } finally {
          if (ColonRAII != null) { ColonRAII.$destroy(); }
        }
      }
      
      // Parse ')' for linear clause with modifier.
      if (NeedRParenForLinear) {
        LinearT.consumeClose();
      }
      
      // Parse ':' linear-step (or ':' alignment).
      /*const*/boolean MustHaveTail = MayHaveTail && $this().Tok.is(tok.TokenKind.colon);
      if (MustHaveTail) {
        Data.ColonLoc.$assignMove($this().Tok.getLocation());
        SourceLocation ELoc = $this().ConsumeToken();
        ActionResultTTrue<Expr /*P*/ > Tail = $this().ParseAssignmentExpression();
        Tail.$assignMove($this().Actions.ActOnFinishFullExpr(Tail.get(), new SourceLocation(ELoc)));
        if (Tail.isUsable()) {
          Data.TailExpr = Tail.get();
        } else {
          $this().SkipUntil(tok.TokenKind.comma, tok.TokenKind.r_paren, tok.TokenKind.annot_pragma_openmp_end, 
              SkipUntilFlags.StopBeforeMatch);
        }
      }
      
      // Parse ')'.
      T.consumeClose();
      if ((Kind == OpenMPClauseKind.OMPC_depend && Data.DepKind != OpenMPDependClauseKind.OMPC_DEPEND_unknown
         && Vars.empty())
         || (Kind != OpenMPClauseKind.OMPC_depend && Kind != OpenMPClauseKind.OMPC_map && Vars.empty())
         || (MustHaveTail && !(Data.TailExpr != null)) || InvalidReductionId) {
        return true;
      }
      return false;
    } finally {
      if (LinearT != null) { LinearT.$destroy(); }
      if (T != null) { T.$destroy(); }
    }
  }

} // END OF class Parser_ParseOpenMP
