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
import static org.clang.sema.SemaClangGlobals.*;


//<editor-fold defaultstate="collapsed" desc="static type Parser_ParseStmt">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -empty-body -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType -split-class=clang::Parser@this -extends=Parser_ParsePragma ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseStmt.cpp -nm=_ZN5clang6Parser14ParseStatementEPNS_14SourceLocationEb;_ZN5clang6Parser16ParseCXXTryBlockEv;_ZN5clang6Parser16ParseDoStatementEv;_ZN5clang6Parser16ParseIfStatementEPNS_14SourceLocationE;_ZN5clang6Parser16ParseSEHTryBlockEv;_ZN5clang6Parser17ParseForStatementEPNS_14SourceLocationE;_ZN5clang6Parser18ParseCXXCatchBlockEb;_ZN5clang6Parser18ParseCaseStatementEbNS_12ActionResultIPNS_4ExprELb1EEE;_ZN5clang6Parser18ParseExprStatementEv;_ZN5clang6Parser18ParseGotoStatementEv;_ZN5clang6Parser19ParseBreakStatementEv;_ZN5clang6Parser19ParsePragmaLoopHintERN4llvm11SmallVectorIPNS_4StmtELj32EEENS0_21AllowedContsructsKindEPNS_14SourceLocationERNS0_25ParsedAttributesWithRangeE;_ZN5clang6Parser19ParseSEHExceptBlockENS_14SourceLocationE;_ZN5clang6Parser19ParseWhileStatementEPNS_14SourceLocationE;_ZN5clang6Parser20ParseReturnStatementEv;_ZN5clang6Parser20ParseSEHFinallyBlockENS_14SourceLocationE;_ZN5clang6Parser20ParseSwitchStatementEPNS_14SourceLocationE;_ZN5clang6Parser20isForRangeIdentifierEv;_ZN5clang6Parser21ParseDefaultStatementEv;_ZN5clang6Parser21ParseFunctionTryBlockEPNS_4DeclERNS0_10ParseScopeE;_ZN5clang6Parser21ParseLabeledStatementERNS0_25ParsedAttributesWithRangeE;_ZN5clang6Parser22ParseCXXTryBlockCommonENS_14SourceLocationEb;_ZN5clang6Parser22ParseCompoundStatementEb;_ZN5clang6Parser22ParseCompoundStatementEbj;_ZN5clang6Parser22ParseContinueStatementEv;_ZN5clang6Parser22ParseSEHLeaveStatementEv;_ZN5clang6Parser23trySkippingFunctionBodyEv;_ZN5clang6Parser25ParseParenExprOrConditionEPNS_12ActionResultIPNS_4StmtELb1EEERNS_4Sema15ConditionResultENS_14SourceLocationENS6_13ConditionKindE;_ZN5clang6Parser26ParseCompoundStatementBodyEb;_ZN5clang6Parser26ParseFunctionStatementBodyEPNS_4DeclERNS0_10ParseScopeE;_ZN5clang6Parser27ParseStatementOrDeclarationERN4llvm11SmallVectorIPNS_4StmtELj32EEENS0_21AllowedContsructsKindEPNS_14SourceLocationE;_ZN5clang6Parser30ParseOpenCLUnrollHintAttributeERNS_16ParsedAttributesE;_ZN5clang6Parser31ParseMicrosoftIfExistsStatementERN4llvm11SmallVectorIPNS_4StmtELj32EEE;_ZN5clang6Parser36ParseCompoundStatementLeadingPragmasEv;_ZN5clang6Parser42ParseStatementOrDeclarationAfterAttributesERN4llvm11SmallVectorIPNS_4StmtELj32EEENS0_21AllowedContsructsKindEPNS_14SourceLocationERNS0_25ParsedAttributesWithRangeE; -static-type=Parser_ParseStmt -package=org.clang.parse")
//</editor-fold>
public class Parser_ParseStmt extends Parser_ParsePragma {
private final /*split clang::Parser*/ Parser $this() { return (Parser)this; }


//===----------------------------------------------------------------------===//
// C99 6.8: Statements and Blocks.
//===----------------------------------------------------------------------===//

/// \brief Parse a standalone statement (for instance, as the body of an 'if',
/// 'while', or 'for').
//<editor-fold defaultstate="collapsed" desc="clang::Parser::ParseStatement">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*endLoc as final pointer*/,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseStmt.cpp", line = 35,
   FQN="clang::Parser::ParseStatement", NM="_ZN5clang6Parser14ParseStatementEPNS_14SourceLocationEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseStmt.cpp -nm=_ZN5clang6Parser14ParseStatementEPNS_14SourceLocationEb")
  //</editor-fold>
  protected /*private*/ ActionResultTTrue<Stmt /*P*/ > ParseStatement() {
    return $this().ParseStatement((SourceLocation /*P*/ )null, 
                false);
  }
  protected /*private*/ ActionResultTTrue<Stmt /*P*/ > ParseStatement(final SourceLocation /*P*/ TrailingElseLoc/*= null*/) {
    return $this().ParseStatement(TrailingElseLoc, 
                false);
  }
  protected /*private*/ ActionResultTTrue<Stmt /*P*/ > ParseStatement(final SourceLocation /*P*/ TrailingElseLoc/*= null*/, 
                boolean AllowOpenMPStandalone/*= false*/) {
    ActionResultTTrue<Stmt /*P*/ > Res/*J*/= new ActionResultTTrue<Stmt /*P*/ >();
    
    // We may get back a null statement if we found a #pragma. Keep going until
    // we get an actual statement.
    do {
      SmallVector<Stmt /*P*/ > Stmts/*J*/= new SmallVector<Stmt /*P*/ >(32, (Stmt /*P*/ )null);
      Res.$assignMove($this().ParseStatementOrDeclaration(Stmts, AllowOpenMPStandalone ? AllowedContsructsKind.ACK_StatementsOpenMPAnyExecutable : AllowedContsructsKind.ACK_StatementsOpenMPNonStandalone, 
              TrailingElseLoc));
    } while (!Res.isInvalid() && !(Res.get() != null));
    
    return Res;
  }


/// ParseStatementOrDeclaration - Read 'statement' or 'declaration'.
///       StatementOrDeclaration:
///         statement
///         declaration
///
///       statement:
///         labeled-statement
///         compound-statement
///         expression-statement
///         selection-statement
///         iteration-statement
///         jump-statement
/// [C++]   declaration-statement
/// [C++]   try-block
/// [MS]    seh-try-block
/// [OBC]   objc-throw-statement
/// [OBC]   objc-try-catch-statement
/// [OBC]   objc-synchronized-statement
/// [GNU]   asm-statement
/// [OMP]   openmp-construct             [TODO]
///
///       labeled-statement:
///         identifier ':' statement
///         'case' constant-expression ':' statement
///         'default' ':' statement
///
///       selection-statement:
///         if-statement
///         switch-statement
///
///       iteration-statement:
///         while-statement
///         do-statement
///         for-statement
///
///       expression-statement:
///         expression[opt] ';'
///
///       jump-statement:
///         'goto' identifier ';'
///         'continue' ';'
///         'break' ';'
///         'return' expression[opt] ';'
/// [GNU]   'goto' '*' expression ';'
///
/// [OBC] objc-throw-statement:
/// [OBC]   '@' 'throw' expression ';'
/// [OBC]   '@' 'throw' ';'
///
//<editor-fold defaultstate="collapsed" desc="clang::Parser::ParseStatementOrDeclaration">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*endLoc as final pointer*/,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseStmt.cpp", line = 101,
   FQN="clang::Parser::ParseStatementOrDeclaration", NM="_ZN5clang6Parser27ParseStatementOrDeclarationERN4llvm11SmallVectorIPNS_4StmtELj32EEENS0_21AllowedContsructsKindEPNS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseStmt.cpp -nm=_ZN5clang6Parser27ParseStatementOrDeclarationERN4llvm11SmallVectorIPNS_4StmtELj32EEENS0_21AllowedContsructsKindEPNS_14SourceLocationE")
  //</editor-fold>
  protected /*private*/ ActionResultTTrue<Stmt /*P*/ > ParseStatementOrDeclaration(final SmallVector<Stmt /*P*/ > /*&*/ Stmts, 
                             AllowedContsructsKind Allowed) {
    return $this().ParseStatementOrDeclaration(Stmts, 
                             Allowed, 
                             (SourceLocation /*P*/ )null);
  }
  protected /*private*/ ActionResultTTrue<Stmt /*P*/ > ParseStatementOrDeclaration(final SmallVector<Stmt /*P*/ > /*&*/ Stmts, 
                             AllowedContsructsKind Allowed, 
                             final SourceLocation /*P*/ TrailingElseLoc/*= null*/) {
    ParenBraceBracketBalancer BalancerRAIIObj = null;
    ParsedAttributesWithRange Attrs = null;
    try {
      
      BalancerRAIIObj/*J*/= new ParenBraceBracketBalancer(/*Deref*/$this());
      
      Attrs/*J*/= new ParsedAttributesWithRange($this().AttrFactory);
      $this().MaybeParseCXX11Attributes(Attrs, (SourceLocation /*P*/ )null, /*MightBeObjCMessageSend*/ true);
      if (!$this().MaybeParseOpenCLUnrollHintAttribute(Attrs)) {
        return StmtError();
      }
      
      ActionResultTTrue<Stmt /*P*/ > Res = $this().ParseStatementOrDeclarationAfterAttributes(Stmts, Allowed, TrailingElseLoc, Attrs);
      assert ((Attrs.empty() || Res.isInvalid() || Res.isUsable())) : "attributes on empty statement";
      if (Attrs.empty() || Res.isInvalid()) {
        return Res;
      }
      
      return $this().Actions.ProcessStmtAttributes(Res.get(), Attrs.getList(), new SourceRange(Attrs.Range));
    } finally {
      if (Attrs != null) { Attrs.$destroy(); }
      if (BalancerRAIIObj != null) { BalancerRAIIObj.$destroy(); }
    }
  }

//<editor-fold defaultstate="collapsed" desc="clang::Parser::ParseStatementOrDeclarationAfterAttributes">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*do/while(Retry) vs goto*/,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseStmt.cpp", line = 154,
   FQN="clang::Parser::ParseStatementOrDeclarationAfterAttributes", NM="_ZN5clang6Parser42ParseStatementOrDeclarationAfterAttributesERN4llvm11SmallVectorIPNS_4StmtELj32EEENS0_21AllowedContsructsKindEPNS_14SourceLocationERNS0_25ParsedAttributesWithRangeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseStmt.cpp -nm=_ZN5clang6Parser42ParseStatementOrDeclarationAfterAttributesERN4llvm11SmallVectorIPNS_4StmtELj32EEENS0_21AllowedContsructsKindEPNS_14SourceLocationERNS0_25ParsedAttributesWithRangeE")
  //</editor-fold>
  protected /*private*/ ActionResultTTrue<Stmt /*P*/ > ParseStatementOrDeclarationAfterAttributes(final SmallVector<Stmt /*P*/ > /*&*/ Stmts, 
                                            AllowedContsructsKind Allowed, final SourceLocation /*P*/ TrailingElseLoc, 
                                            final ParsedAttributesWithRange /*&*/ Attrs) {
    /*const*/char$ptr/*char P*/ SemiError = null;
    ActionResultTTrue<Stmt /*P*/ > Res/*J*/= new ActionResultTTrue<Stmt /*P*/ >();
   boolean Retry = false;
   do { // JAVA 
    // Cases in this switch statement should fall through if the parser expects
    // the token to end in a semicolon (in which case SemiError should be set),
    // or they directly 'return;' if not.
    /*tok.TokenKind*/char Kind = $this().Tok.getKind();
    SourceLocation AtLoc/*J*/= new SourceLocation();
    SwitchByKind:
    switch (Kind) {
     case tok.TokenKind.at: // May be a @try or @throw statement
      {
        $this().ProhibitAttributes(Attrs); // TODO: is it correct?
        AtLoc.$assignMove($this().ConsumeToken()); // consume @
        return $this().ParseObjCAtStatement(new SourceLocation(AtLoc));
      }
     case tok.TokenKind.code_completion:
      $this().Actions.CodeCompleteOrdinaryName($this().getCurScope(), Sema.ParserCompletionContext.PCC_Statement);
      $this().cutOffParsing();
      return StmtError();
     case tok.TokenKind.identifier:
      {
        Token Next = new Token($this().NextToken());
        if (Next.is(tok.TokenKind.colon)) { // C99 6.8.1: labeled-statement
  // identifier ':' statement
          return $this().ParseLabeledStatement(Attrs);
        }
        
        // Look up the identifier, and typo-correct it to a keyword if it's not
        // found.
        if (Next.isNot(tok.TokenKind.coloncolon)) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            // Try to limit which sets of keywords should be included in typo
            // correction based on what the next token is.
            if ($c$.clean($this().TryAnnotateName(/*IsAddressOfOperand*/ false, 
                $c$.track(new std.unique_ptr<CorrectionCandidateCallback>(JD$Unique_ptr$_Up$_Ep.INSTANCE, $c$.track(llvm.make_unique(new StatementFilterCCC(Next))))))
               == AnnotatedNameKind.ANK_Error)) {
              // Handle errors here by skipping up to the next semicolon or '}', and
              // eat the semicolon if that's what stopped us.
              $this().SkipUntil(tok.TokenKind.r_brace, $bitor_SkipUntilFlags(/*KEEP_ENUM*/SkipUntilFlags.StopAtSemi, /*KEEP_ENUM*/SkipUntilFlags.StopBeforeMatch));
              if ($this().Tok.is(tok.TokenKind.semi)) {
                $this().ConsumeToken();
              }
              return StmtError();
            }
            
            // If the identifier was typo-corrected, try again.
            if ($this().Tok.isNot(tok.TokenKind.identifier)) {
              Retry=true; break SwitchByKind;//goto Retry;
            }
          } finally {
            $c$.$destroy();
          }
        }
        // Fall through
      }
     default:
      {
        if (($this().getLangOpts().CPlusPlus || Allowed == AllowedContsructsKind.ACK_Any)
           && $this().isDeclarationStatement()) {
          SourceLocation DeclStart = $this().Tok.getLocation(), DeclEnd/*J*/= new SourceLocation();
          OpaquePtr<DeclGroupRef> Decl = $this().ParseDeclaration(Declarator.TheContext.BlockContext.getValue(), 
              DeclEnd, Attrs);
          return $this().Actions.ActOnDeclStmt(new OpaquePtr<DeclGroupRef>(Decl), new SourceLocation(DeclStart), new SourceLocation(DeclEnd));
        }
        if ($this().Tok.is(tok.TokenKind.r_brace)) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            $c$.clean($c$.track($this().Diag($this().Tok, diag.err_expected_statement)));
            return StmtError();
          } finally {
            $c$.$destroy();
          }
        }
        
        return $this().ParseExprStatement();
      }
     case tok.TokenKind.kw_case: // C99 6.8.1: labeled-statement
      return $this().ParseCaseStatement();
     case tok.TokenKind.kw_default: // C99 6.8.1: labeled-statement
      return $this().ParseDefaultStatement();
     case tok.TokenKind.l_brace: // C99 6.8.2: compound-statement
      return $this().ParseCompoundStatement();
     case tok.TokenKind.semi:
      { // C99 6.8.3p3: expression[opt] ';'
        boolean HasLeadingEmptyMacro = $this().Tok.hasLeadingEmptyMacro();
        return $this().Actions.ActOnNullStmt($this().ConsumeToken(), HasLeadingEmptyMacro);
      }
     case tok.TokenKind.kw_if: // C99 6.8.4.1: if-statement
      return $this().ParseIfStatement(TrailingElseLoc);
     case tok.TokenKind.kw_switch: // C99 6.8.4.2: switch-statement
      return $this().ParseSwitchStatement(TrailingElseLoc);
     case tok.TokenKind.kw_while: // C99 6.8.5.1: while-statement
      return $this().ParseWhileStatement(TrailingElseLoc);
     case tok.TokenKind.kw_do: // C99 6.8.5.2: do-statement
      Res.$assignMove($this().ParseDoStatement());
      SemiError = $tryClone($("do/while"));
      break;
     case tok.TokenKind.kw_for: // C99 6.8.5.3: for-statement
      return $this().ParseForStatement(TrailingElseLoc);
     case tok.TokenKind.kw_goto: // C99 6.8.6.1: goto-statement
      Res.$assignMove($this().ParseGotoStatement());
      SemiError = $tryClone($goto);
      break;
     case tok.TokenKind.kw_continue: // C99 6.8.6.2: continue-statement
      Res.$assignMove($this().ParseContinueStatement());
      SemiError = $tryClone($continue);
      break;
     case tok.TokenKind.kw_break: // C99 6.8.6.3: break-statement
      Res.$assignMove($this().ParseBreakStatement());
      SemiError = $tryClone($break);
      break;
     case tok.TokenKind.kw_return: // C99 6.8.6.4: return-statement
      Res.$assignMove($this().ParseReturnStatement());
      SemiError = $tryClone($return);
      break;
     case tok.TokenKind.kw_co_return: // C++ Coroutines: co_return statement
      Res.$assignMove($this().ParseReturnStatement());
      SemiError = $tryClone($co_return);
      break;
     case tok.TokenKind.kw_asm:
      {
        $this().ProhibitAttributes(Attrs);
        bool$ref msAsm = create_bool$ref(false);
        Res.$assignMove($this().ParseAsmStatement(msAsm));
        Res.$assignMove($this().Actions.ActOnFinishFullStmt(Res.get()));
        if (msAsm.$deref()) {
          return Res;
        }
        SemiError = $tryClone($asm);
        break;
      }
     case tok.TokenKind.kw___if_exists:
     case tok.TokenKind.kw___if_not_exists:
      $this().ProhibitAttributes(Attrs);
      $this().ParseMicrosoftIfExistsStatement(Stmts);
      // An __if_exists block is like a compound statement, but it doesn't create
      // a new scope.
      return StmtEmpty();
     case tok.TokenKind.kw_try: // C++ 15: try-block
      return $this().ParseCXXTryBlock();
     case tok.TokenKind.kw___try:
      $this().ProhibitAttributes(Attrs); // TODO: is it correct?
      return $this().ParseSEHTryBlock();
     case tok.TokenKind.kw___leave:
      Res.$assignMove($this().ParseSEHLeaveStatement());
      SemiError = $tryClone($__leave);
      break;
     case tok.TokenKind.annot_pragma_vis:
      $this().ProhibitAttributes(Attrs);
      $this().HandlePragmaVisibility();
      return StmtEmpty();
     case tok.TokenKind.annot_pragma_pack:
      $this().ProhibitAttributes(Attrs);
      $this().HandlePragmaPack();
      return StmtEmpty();
     case tok.TokenKind.annot_pragma_msstruct:
      $this().ProhibitAttributes(Attrs);
      $this().HandlePragmaMSStruct();
      return StmtEmpty();
     case tok.TokenKind.annot_pragma_align:
      $this().ProhibitAttributes(Attrs);
      $this().HandlePragmaAlign();
      return StmtEmpty();
     case tok.TokenKind.annot_pragma_weak:
      $this().ProhibitAttributes(Attrs);
      $this().HandlePragmaWeak();
      return StmtEmpty();
     case tok.TokenKind.annot_pragma_weakalias:
      $this().ProhibitAttributes(Attrs);
      $this().HandlePragmaWeakAlias();
      return StmtEmpty();
     case tok.TokenKind.annot_pragma_redefine_extname:
      $this().ProhibitAttributes(Attrs);
      $this().HandlePragmaRedefineExtname();
      return StmtEmpty();
     case tok.TokenKind.annot_pragma_fp_contract:
      {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $this().ProhibitAttributes(Attrs);
          $c$.clean($c$.track($this().Diag($this().Tok, diag.err_pragma_fp_contract_scope)));
          $this().ConsumeToken();
          return StmtError();
        } finally {
          $c$.$destroy();
        }
      }
     case tok.TokenKind.annot_pragma_opencl_extension:
      $this().ProhibitAttributes(Attrs);
      $this().HandlePragmaOpenCLExtension();
      return StmtEmpty();
     case tok.TokenKind.annot_pragma_captured:
      $this().ProhibitAttributes(Attrs);
      return $this().HandlePragmaCaptured();
     case tok.TokenKind.annot_pragma_openmp:
      $this().ProhibitAttributes(Attrs);
      return $this().ParseOpenMPDeclarativeOrExecutableDirective(Allowed);
     case tok.TokenKind.annot_pragma_ms_pointers_to_members:
      $this().ProhibitAttributes(Attrs);
      $this().HandlePragmaMSPointersToMembers();
      return StmtEmpty();
     case tok.TokenKind.annot_pragma_ms_pragma:
      $this().ProhibitAttributes(Attrs);
      $this().HandlePragmaMSPragma();
      return StmtEmpty();
     case tok.TokenKind.annot_pragma_ms_vtordisp:
      $this().ProhibitAttributes(Attrs);
      $this().HandlePragmaMSVtorDisp();
      return StmtEmpty();
     case tok.TokenKind.annot_pragma_loop_hint:
      $this().ProhibitAttributes(Attrs);
      return $this().ParsePragmaLoopHint(Stmts, Allowed, TrailingElseLoc, Attrs);
     case tok.TokenKind.annot_pragma_dump:
      $this().HandlePragmaDump();
      return StmtEmpty();
    }
  } while (Retry); // JAVA
    // If we reached this code, the statement must end in a semicolon.
    if (!$this().TryConsumeToken(tok.TokenKind.semi) && !Res.isInvalid()) {
      // If the result was valid, then we do want to diagnose this.  Use
      // ExpectAndConsume to emit the diagnostic, even though we know it won't
      // succeed.
      $this().ExpectAndConsume(tok.TokenKind.semi, diag.err_expected_semi_after_stmt, new StringRef(SemiError));
      // Skip until we see a } or ;, but don't eat it.
      $this().SkipUntil(tok.TokenKind.r_brace, $bitor_SkipUntilFlags(/*KEEP_ENUM*/SkipUntilFlags.StopAtSemi, /*KEEP_ENUM*/SkipUntilFlags.StopBeforeMatch));
    }
    
    return Res;
  }


/// \brief Parse an expression statement.
//<editor-fold defaultstate="collapsed" desc="clang::Parser::ParseExprStatement">
@Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseStmt.cpp", line = 397,
   FQN="clang::Parser::ParseExprStatement", NM="_ZN5clang6Parser18ParseExprStatementEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseStmt.cpp -nm=_ZN5clang6Parser18ParseExprStatementEv")
  //</editor-fold>
  protected /*private*/ ActionResultTTrue<Stmt /*P*/ > ParseExprStatement() {
    // If a case keyword is missing, this is where it should be inserted.
    Token OldToken = new Token($this().Tok);
    
    // expression[opt] ';'
    ActionResultTTrue<Expr /*P*/ > Expr/*J*/= $this().ParseExpression();
    if (Expr.isInvalid()) {
      // If the expression is invalid, skip ahead to the next semicolon or '}'.
      // Not doing this opens us up to the possibility of infinite loops if
      // ParseExpression does not consume any tokens.
      $this().SkipUntil(tok.TokenKind.r_brace, $bitor_SkipUntilFlags(/*KEEP_ENUM*/SkipUntilFlags.StopAtSemi, /*KEEP_ENUM*/SkipUntilFlags.StopBeforeMatch));
      if ($this().Tok.is(tok.TokenKind.semi)) {
        $this().ConsumeToken();
      }
      return $this().Actions.ActOnExprStmtError();
    }
    if ($this().Tok.is(tok.TokenKind.colon) && $this().getCurScope().isSwitchScope()
       && $this().Actions.CheckCaseExpression(Expr.get())) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        // If a constant expression is followed by a colon inside a switch block,
        // suggest a missing case keyword.
        $c$.clean($out_DiagnosticBuilder$C_FixItHint$C($c$.track($this().Diag(OldToken, diag.err_expected_case_before_expression)), 
            FixItHint.CreateInsertion(OldToken.getLocation(), new StringRef(/*KEEP_STR*/"case "))));
        
        // Recover parsing as a case statement.
        return $this().ParseCaseStatement(/*MissingCase=*/ true, new ActionResultTTrue<Expr /*P*/ >(Expr));
      } finally {
        $c$.$destroy();
      }
    }
    
    // Otherwise, eat the semicolon.
    $this().ExpectAndConsumeSemi(diag.err_expected_semi_after_expr);
    return $this().Actions.ActOnExprStmt(new ActionResultTTrue<Expr /*P*/ >(Expr));
  }


/// ParseLabeledStatement - We have an identifier and a ':' after it.
///
///       labeled-statement:
///         identifier ':' statement
/// [GNU]   identifier ':' attributes[opt] statement
///
//<editor-fold defaultstate="collapsed" desc="clang::Parser::ParseLabeledStatement">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseStmt.cpp", line = 564,
   FQN="clang::Parser::ParseLabeledStatement", NM="_ZN5clang6Parser21ParseLabeledStatementERNS0_25ParsedAttributesWithRangeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseStmt.cpp -nm=_ZN5clang6Parser21ParseLabeledStatementERNS0_25ParsedAttributesWithRangeE")
  //</editor-fold>
  protected /*private*/ ActionResultTTrue<Stmt /*P*/ > ParseLabeledStatement(final ParsedAttributesWithRange /*&*/ attrs) {
    assert ($this().Tok.is(tok.TokenKind.identifier) && ($this().Tok.getIdentifierInfo() != null)) : "Not an identifier!";
    
    Token IdentTok = new Token($this().Tok); // Save the whole token.
    $this().ConsumeToken(); // eat the identifier.
    assert ($this().Tok.is(tok.TokenKind.colon)) : "Not a label!";
    
    // identifier ':' statement
    SourceLocation ColonLoc = $this().ConsumeToken();
    
    // Read label attributes, if present.
    ActionResultTTrue<Stmt /*P*/ > SubStmt/*J*/= new ActionResultTTrue<Stmt /*P*/ >();
    if ($this().Tok.is(tok.TokenKind.kw___attribute)) {
      ParsedAttributesWithRange TempAttrs = null;
      try {
        TempAttrs/*J*/= new ParsedAttributesWithRange($this().AttrFactory);
        $this().ParseGNUAttributes(TempAttrs);
        
        // In C++, GNU attributes only apply to the label if they are followed by a
        // semicolon, to disambiguate label attributes from attributes on a labeled
        // declaration.
        //
        // This doesn't quite match what GCC does; if the attribute list is empty
        // and followed by a semicolon, GCC will reject (it appears to parse the
        // attributes as part of a statement in that case). That looks like a bug.
        if (!$this().getLangOpts().CPlusPlus || $this().Tok.is(tok.TokenKind.semi)) {
          attrs.takeAllFrom(TempAttrs);
        } else if ($this().isDeclarationStatement()) {
          SmallVector<Stmt /*P*/ > Stmts/*J*/= new SmallVector<Stmt /*P*/ >(32, (Stmt /*P*/ )null);
          // FIXME: We should do this whether or not we have a declaration
          // statement, but that doesn't work correctly (because ProhibitAttributes
          // can't handle GNU attributes), so only call it in the one case where
          // GNU attributes are allowed.
          SubStmt.$assignMove($this().ParseStatementOrDeclarationAfterAttributes(Stmts, /*Allowed=*/ AllowedContsructsKind.ACK_StatementsOpenMPNonStandalone, (SourceLocation /*P*/ )null, 
                  TempAttrs));
          if (!TempAttrs.empty() && !SubStmt.isInvalid()) {
            SubStmt.$assignMove($this().Actions.ProcessStmtAttributes(SubStmt.get(), TempAttrs.getList(), new SourceRange(TempAttrs.Range)));
          }
        } else {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            $c$.clean($out_DiagnosticBuilder$C_TokenKind($out_DiagnosticBuilder$C_char$ptr$C($c$.track($this().Diag($this().Tok, diag.err_expected_after)), /*KEEP_STR*/$__attribute__), tok.TokenKind.semi));
          } finally {
            $c$.$destroy();
          }
        }
      } finally {
        if (TempAttrs != null) { TempAttrs.$destroy(); }
      }
    }
    
    // If we've not parsed a statement yet, parse one now.
    if (!SubStmt.isInvalid() && !SubStmt.isUsable()) {
      SubStmt.$assignMove($this().ParseStatement());
    }
    
    // Broken substmt shouldn't prevent the label from being added to the AST.
    if (SubStmt.isInvalid()) {
      SubStmt.$assignMove($this().Actions.ActOnNullStmt(new SourceLocation(ColonLoc)));
    }
    
    LabelDecl /*P*/ LD = $this().Actions.LookupOrCreateLabel(IdentTok.getIdentifierInfo(), 
        IdentTok.getLocation());
    {
      AttributeList /*P*/ Attrs = attrs.getList();
      if ((Attrs != null)) {
        $this().Actions.ProcessDeclAttributeList($this().Actions.CurScope, LD, Attrs);
        attrs.clear();
      }
    }
    
    return $this().Actions.ActOnLabelStmt(IdentTok.getLocation(), LD, new SourceLocation(ColonLoc), 
        SubStmt.get());
  }


/// ParseCaseStatement
///       labeled-statement:
///         'case' constant-expression ':' statement
/// [GNU]   'case' constant-expression '...' constant-expression ':' statement
///
//<editor-fold defaultstate="collapsed" desc="clang::Parser::ParseCaseStatement">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseStmt.cpp", line = 632,
   FQN="clang::Parser::ParseCaseStatement", NM="_ZN5clang6Parser18ParseCaseStatementEbNS_12ActionResultIPNS_4ExprELb1EEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseStmt.cpp -nm=_ZN5clang6Parser18ParseCaseStatementEbNS_12ActionResultIPNS_4ExprELb1EEE")
  //</editor-fold>
  protected /*private*/ ActionResultTTrue<Stmt /*P*/ > ParseCaseStatement() {
    return $this().ParseCaseStatement(false, new ActionResultTTrue<Expr /*P*/ >());
  }
  protected /*private*/ ActionResultTTrue<Stmt /*P*/ > ParseCaseStatement(boolean MissingCase/*= false*/) {
    return $this().ParseCaseStatement(MissingCase, new ActionResultTTrue<Expr /*P*/ >());
  }
  protected /*private*/ ActionResultTTrue<Stmt /*P*/ > ParseCaseStatement(boolean MissingCase/*= false*/, ActionResultTTrue<Expr /*P*/ > Expr/*= ExprResult()*/) {
    assert ((MissingCase || $this().Tok.is(tok.TokenKind.kw_case))) : "Not a case stmt!";
    
    // It is very very common for code to contain many case statements recursively
    // nested, as in (but usually without indentation):
    //  case 1:
    //    case 2:
    //      case 3:
    //         case 4:
    //           case 5: etc.
    //
    // Parsing this naively works, but is both inefficient and can cause us to run
    // out of stack space in our recursive descent parser.  As a special case,
    // flatten this recursion into an iterative loop.  This is complex and gross,
    // but all the grossness is constrained to ParseCaseStatement (and some
    // weirdness in the actions), so this is just local grossness :).
    
    // TopLevelCase - This is the highest level we have parsed.  'case 1' in the
    // example above.
    ActionResultTTrue<Stmt /*P*/ > TopLevelCase/*J*/= new ActionResultTTrue<Stmt /*P*/ >(true);
    
    // DeepestParsedCaseStmt - This is the deepest statement we have parsed, which
    // gets updated each time a new case is parsed, and whose body is unset so
    // far.  When parsing 'case 4', this is the 'case 3' node.
    Stmt /*P*/ DeepestParsedCaseStmt = null;
    
    // While we have case statements, eat and stack them.
    SourceLocation ColonLoc/*J*/= new SourceLocation();
    do {
      ColonProtectionRAIIObject ColonProtection = null;
      try {
        SourceLocation CaseLoc = MissingCase ? Expr.get().getExprLoc() : $this().ConsumeToken(); // eat the 'case'.
        ColonLoc.$assignMove(new SourceLocation());
        if ($this().Tok.is(tok.TokenKind.code_completion)) {
          $this().Actions.CodeCompleteCase($this().getCurScope());
          $this().cutOffParsing();
          return StmtError();
        }
        
        /// We don't want to treat 'case x : y' as a potential typo for 'case x::y'.
        /// Disable this form of error recovery while we're parsing the case
        /// expression.
        ColonProtection/*J*/= new ColonProtectionRAIIObject(/*Deref*/$this());
        
        ActionResultTTrue<Expr /*P*/ > LHS/*J*/= new ActionResultTTrue<Expr /*P*/ >();
        if (!MissingCase) {
          LHS.$assignMove($this().ParseConstantExpression());
          if (!$this().getLangOpts().CPlusPlus11) {
            LHS.$assignMove($this().Actions.CorrectDelayedTyposInExpr(new ActionResultTTrue<Expr /*P*/ >(LHS), ( (Expr /*P*/ E) -> 
                          {
                            return $this().Actions.VerifyIntegerConstantExpression(E);
                          }
            )));
          }
          if (LHS.isInvalid()) {
            // If constant-expression is parsed unsuccessfully, recover by skipping
            // current case statement (moving to the colon that ends it).
            if ($this().SkipUntil(tok.TokenKind.colon, tok.TokenKind.r_brace, $bitor_SkipUntilFlags(/*KEEP_ENUM*/SkipUntilFlags.StopAtSemi, /*KEEP_ENUM*/SkipUntilFlags.StopBeforeMatch))) {
              $this().TryConsumeToken(tok.TokenKind.colon, ColonLoc);
              continue;
            }
            return StmtError();
          }
        } else {
          LHS.$assign(Expr);
          MissingCase = false;
        }
        
        // GNU case range extension.
        SourceLocation DotDotDotLoc/*J*/= new SourceLocation();
        ActionResultTTrue<Expr /*P*/ > RHS/*J*/= new ActionResultTTrue<Expr /*P*/ >();
        if ($this().TryConsumeToken(tok.TokenKind.ellipsis, DotDotDotLoc)) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            $c$.clean($c$.track($this().Diag(new SourceLocation(DotDotDotLoc), diag.ext_gnu_case_range)));
            RHS.$assignMove($this().ParseConstantExpression());
            if (RHS.isInvalid()) {
              if ($this().SkipUntil(tok.TokenKind.colon, tok.TokenKind.r_brace, $bitor_SkipUntilFlags(/*KEEP_ENUM*/SkipUntilFlags.StopAtSemi, /*KEEP_ENUM*/SkipUntilFlags.StopBeforeMatch))) {
                $this().TryConsumeToken(tok.TokenKind.colon, ColonLoc);
                continue;
              }
              return StmtError();
            }
          } finally {
            $c$.$destroy();
          }
        }
        
        ColonProtection.restore();
        if ($this().TryConsumeToken(tok.TokenKind.colon, ColonLoc)) {
        } else if ($this().TryConsumeToken(tok.TokenKind.semi, ColonLoc)
           || $this().TryConsumeToken(tok.TokenKind.coloncolon, ColonLoc)) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            // Treat "case blah;" or "case blah::" as a typo for "case blah:".
            $c$.clean($out_DiagnosticBuilder$C_FixItHint$C($out_DiagnosticBuilder$C_TokenKind($out_DiagnosticBuilder$C_char$ptr$C($c$.track($this().Diag(new SourceLocation(ColonLoc), diag.err_expected_after)), 
                        /*KEEP_STR*/"'case'"), tok.TokenKind.colon), 
                FixItHint.CreateReplacement(new SourceRange(/*NO_COPY*/ColonLoc), new StringRef(/*KEEP_STR*/$COLON))));
          } finally {
            $c$.$destroy();
          }
        } else {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            SourceLocation ExpectedLoc = $this().PP.getLocForEndOfToken(/*NO_COPY*/$this().PrevTokLocation);
            $c$.clean($out_DiagnosticBuilder$C_FixItHint$C($out_DiagnosticBuilder$C_TokenKind($out_DiagnosticBuilder$C_char$ptr$C($c$.track($this().Diag(new SourceLocation(ExpectedLoc), diag.err_expected_after)), 
                        /*KEEP_STR*/"'case'"), tok.TokenKind.colon), 
                FixItHint.CreateInsertion(/*NO_COPY*/ExpectedLoc, new StringRef(/*KEEP_STR*/$COLON))));
            ColonLoc.$assign(ExpectedLoc);
          } finally {
            $c$.$destroy();
          }
        }
        
        ActionResultTTrue<Stmt /*P*/ > Case = $this().Actions.ActOnCaseStmt(new SourceLocation(CaseLoc), LHS.get(), new SourceLocation(DotDotDotLoc), 
            RHS.get(), new SourceLocation(ColonLoc));
        
        // If we had a sema error parsing this case, then just ignore it and
        // continue parsing the sub-stmt.
        if (Case.isInvalid()) {
          if (TopLevelCase.isInvalid()) { // No parsed case stmts.
            return $this().ParseStatement(/*TrailingElseLoc=*/ (SourceLocation /*P*/ )null, 
                /*AllowOpenMPStandalone=*/ true);
          }
          // Otherwise, just don't add it as a nested case.
        } else {
          // If this is the first case statement we parsed, it becomes TopLevelCase.
          // Otherwise we link it into the current chain.
          Stmt /*P*/ NextDeepest = Case.get();
          if (TopLevelCase.isInvalid()) {
            TopLevelCase.$assign(Case);
          } else {
            $this().Actions.ActOnCaseStmtBody(DeepestParsedCaseStmt, Case.get());
          }
          DeepestParsedCaseStmt = NextDeepest;
        }
      } finally {
        if (ColonProtection != null) { ColonProtection.$destroy(); }
      }
      // Handle all case statements.
    } while ($this().Tok.is(tok.TokenKind.kw_case));
    
    // If we found a non-case statement, start by parsing it.
    ActionResultTTrue<Stmt /*P*/ > SubStmt/*J*/= new ActionResultTTrue<Stmt /*P*/ >();
    if ($this().Tok.isNot(tok.TokenKind.r_brace)) {
      SubStmt.$assignMove($this().ParseStatement(/*TrailingElseLoc=*/ (SourceLocation /*P*/ )null, 
              /*AllowOpenMPStandalone=*/ true));
    } else {
      // Nicely diagnose the common error "switch (X) { case 4: }", which is
      // not valid.  If ColonLoc doesn't point to a valid text location, there was
      // another parsing error, so avoid producing extra diagnostics.
      if (ColonLoc.isValid()) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          SourceLocation AfterColonLoc = $this().PP.getLocForEndOfToken(/*NO_COPY*/ColonLoc);
          $c$.clean($out_DiagnosticBuilder$C_FixItHint$C($c$.track($this().Diag(new SourceLocation(AfterColonLoc), diag.err_label_end_of_compound_statement)), 
              FixItHint.CreateInsertion(/*NO_COPY*/AfterColonLoc, new StringRef(/*KEEP_STR*/" ;"))));
        } finally {
          $c$.$destroy();
        }
      }
      SubStmt.$assignMove(StmtError());
    }
    
    // Install the body into the most deeply-nested case.
    if ((DeepestParsedCaseStmt != null)) {
      // Broken sub-stmt shouldn't prevent forming the case statement properly.
      if (SubStmt.isInvalid()) {
        SubStmt.$assignMove($this().Actions.ActOnNullStmt(new SourceLocation()));
      }
      $this().Actions.ActOnCaseStmtBody(DeepestParsedCaseStmt, SubStmt.get());
    }
    
    // Return the top level parsed statement tree.
    return TopLevelCase;
  }


/// ParseDefaultStatement
///       labeled-statement:
///         'default' ':' statement
/// Note that this does not parse the 'statement' at the end.
///
//<editor-fold defaultstate="collapsed" desc="clang::Parser::ParseDefaultStatement">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseStmt.cpp", line = 790,
   FQN="clang::Parser::ParseDefaultStatement", NM="_ZN5clang6Parser21ParseDefaultStatementEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseStmt.cpp -nm=_ZN5clang6Parser21ParseDefaultStatementEv")
  //</editor-fold>
  protected /*private*/ ActionResultTTrue<Stmt /*P*/ > ParseDefaultStatement() {
    assert ($this().Tok.is(tok.TokenKind.kw_default)) : "Not a default stmt!";
    SourceLocation DefaultLoc = $this().ConsumeToken(); // eat the 'default'.
    
    SourceLocation ColonLoc/*J*/= new SourceLocation();
    if ($this().TryConsumeToken(tok.TokenKind.colon, ColonLoc)) {
    } else if ($this().TryConsumeToken(tok.TokenKind.semi, ColonLoc)) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        // Treat "default;" as a typo for "default:".
        $c$.clean($out_DiagnosticBuilder$C_FixItHint$C($out_DiagnosticBuilder$C_TokenKind($out_DiagnosticBuilder$C_char$ptr$C($c$.track($this().Diag(new SourceLocation(ColonLoc), diag.err_expected_after)), 
                    /*KEEP_STR*/"'default'"), tok.TokenKind.colon), 
            FixItHint.CreateReplacement(new SourceRange(/*NO_COPY*/ColonLoc), new StringRef(/*KEEP_STR*/$COLON))));
      } finally {
        $c$.$destroy();
      }
    } else {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        SourceLocation ExpectedLoc = $this().PP.getLocForEndOfToken(/*NO_COPY*/$this().PrevTokLocation);
        $c$.clean($out_DiagnosticBuilder$C_FixItHint$C($out_DiagnosticBuilder$C_TokenKind($out_DiagnosticBuilder$C_char$ptr$C($c$.track($this().Diag(new SourceLocation(ExpectedLoc), diag.err_expected_after)), 
                    /*KEEP_STR*/"'default'"), tok.TokenKind.colon), 
            FixItHint.CreateInsertion(/*NO_COPY*/ExpectedLoc, new StringRef(/*KEEP_STR*/$COLON))));
        ColonLoc.$assign(ExpectedLoc);
      } finally {
        $c$.$destroy();
      }
    }
    
    ActionResultTTrue<Stmt /*P*/ > SubStmt/*J*/= new ActionResultTTrue<Stmt /*P*/ >();
    if ($this().Tok.isNot(tok.TokenKind.r_brace)) {
      SubStmt.$assignMove($this().ParseStatement(/*TrailingElseLoc=*/ (SourceLocation /*P*/ )null, 
              /*AllowOpenMPStandalone=*/ true));
    } else {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        // Diagnose the common error "switch (X) {... default: }", which is
        // not valid.
        SourceLocation AfterColonLoc = $this().PP.getLocForEndOfToken(/*NO_COPY*/ColonLoc);
        $c$.clean($out_DiagnosticBuilder$C_FixItHint$C($c$.track($this().Diag(new SourceLocation(AfterColonLoc), diag.err_label_end_of_compound_statement)), 
            FixItHint.CreateInsertion(/*NO_COPY*/AfterColonLoc, new StringRef(/*KEEP_STR*/" ;"))));
        SubStmt.$assignMove(new ActionResultTTrue<Stmt /*P*/>(true));
      } finally {
        $c$.$destroy();
      }
    }
    
    // Broken sub-stmt shouldn't prevent forming the case statement properly.
    if (SubStmt.isInvalid()) {
      SubStmt.$assignMove($this().Actions.ActOnNullStmt(new SourceLocation(ColonLoc)));
    }
    
    return $this().Actions.ActOnDefaultStmt(new SourceLocation(DefaultLoc), new SourceLocation(ColonLoc), 
        SubStmt.get(), $this().getCurScope());
  }

//<editor-fold defaultstate="collapsed" desc="clang::Parser::ParseCompoundStatement">
@Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseStmt.cpp", line = 831,
   FQN="clang::Parser::ParseCompoundStatement", NM="_ZN5clang6Parser22ParseCompoundStatementEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseStmt.cpp -nm=_ZN5clang6Parser22ParseCompoundStatementEb")
  //</editor-fold>
  protected /*private*/ ActionResultTTrue<Stmt /*P*/ > ParseCompoundStatement() {
    return $this().ParseCompoundStatement(false);
  }
  protected /*private*/ ActionResultTTrue<Stmt /*P*/ > ParseCompoundStatement(boolean isStmtExpr/*= false*/) {
    return $this().ParseCompoundStatement(isStmtExpr, Scope.ScopeFlags.DeclScope);
  }


/// ParseCompoundStatement - Parse a "{}" block.
///
///       compound-statement: [C99 6.8.2]
///         { block-item-list[opt] }
/// [GNU]   { label-declarations block-item-list } [TODO]
///
///       block-item-list:
///         block-item
///         block-item-list block-item
///
///       block-item:
///         declaration
/// [GNU]   '__extension__' declaration
///         statement
///
/// [GNU] label-declarations:
/// [GNU]   label-declaration
/// [GNU]   label-declarations label-declaration
///
/// [GNU] label-declaration:
/// [GNU]   '__label__' identifier-list ';'
///
//<editor-fold defaultstate="collapsed" desc="clang::Parser::ParseCompoundStatement">
@Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseStmt.cpp", line = 857,
   FQN="clang::Parser::ParseCompoundStatement", NM="_ZN5clang6Parser22ParseCompoundStatementEbj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseStmt.cpp -nm=_ZN5clang6Parser22ParseCompoundStatementEbj")
  //</editor-fold>
  protected /*private*/ ActionResultTTrue<Stmt /*P*/ > ParseCompoundStatement(boolean isStmtExpr, 
                        /*uint*/int ScopeFlags) {
    ParseScope CompoundScope = null;
    try {
      assert ($this().Tok.is(tok.TokenKind.l_brace)) : "Not a compount stmt!";
      
      // Enter a scope to hold everything within the compound stmt.  Compound
      // statements can always hold declarations.
      CompoundScope/*J*/= new ParseScope($this(), ScopeFlags);
      
      // Parse the statements in the body.
      return $this().ParseCompoundStatementBody(isStmtExpr);
    } finally {
      if (CompoundScope != null) { CompoundScope.$destroy(); }
    }
  }


/// Parse any pragmas at the start of the compound expression. We handle these
/// separately since some pragmas (FP_CONTRACT) must appear before any C
/// statement in the compound, but may be intermingled with other pragmas.
//<editor-fold defaultstate="collapsed" desc="clang::Parser::ParseCompoundStatementLeadingPragmas">
@Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseStmt.cpp", line = 872,
   FQN="clang::Parser::ParseCompoundStatementLeadingPragmas", NM="_ZN5clang6Parser36ParseCompoundStatementLeadingPragmasEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseStmt.cpp -nm=_ZN5clang6Parser36ParseCompoundStatementLeadingPragmasEv")
  //</editor-fold>
  protected /*private*/ void ParseCompoundStatementLeadingPragmas() {
    boolean checkForPragmas = true;
    while (checkForPragmas) {
      switch ($this().Tok.getKind()) {
       case tok.TokenKind.annot_pragma_vis:
        $this().HandlePragmaVisibility();
        break;
       case tok.TokenKind.annot_pragma_pack:
        $this().HandlePragmaPack();
        break;
       case tok.TokenKind.annot_pragma_msstruct:
        $this().HandlePragmaMSStruct();
        break;
       case tok.TokenKind.annot_pragma_align:
        $this().HandlePragmaAlign();
        break;
       case tok.TokenKind.annot_pragma_weak:
        $this().HandlePragmaWeak();
        break;
       case tok.TokenKind.annot_pragma_weakalias:
        $this().HandlePragmaWeakAlias();
        break;
       case tok.TokenKind.annot_pragma_redefine_extname:
        $this().HandlePragmaRedefineExtname();
        break;
       case tok.TokenKind.annot_pragma_opencl_extension:
        $this().HandlePragmaOpenCLExtension();
        break;
       case tok.TokenKind.annot_pragma_fp_contract:
        $this().HandlePragmaFPContract();
        break;
       case tok.TokenKind.annot_pragma_ms_pointers_to_members:
        $this().HandlePragmaMSPointersToMembers();
        break;
       case tok.TokenKind.annot_pragma_ms_pragma:
        $this().HandlePragmaMSPragma();
        break;
       case tok.TokenKind.annot_pragma_ms_vtordisp:
        $this().HandlePragmaMSVtorDisp();
        break;
       case tok.TokenKind.annot_pragma_dump:
        $this().HandlePragmaDump();
        break;
       default:
        checkForPragmas = false;
        break;
      }
    }
  }


/// ParseCompoundStatementBody - Parse a sequence of statements and invoke the
/// ActOnCompoundStmt action.  This expects the '{' to be the current token, and
/// consume the '}' at the end of the block.  It does not manipulate the scope
/// stack.
//<editor-fold defaultstate="collapsed" desc="clang::Parser::ParseCompoundStatementBody">
@Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseStmt.cpp", line = 927,
   FQN="clang::Parser::ParseCompoundStatementBody", NM="_ZN5clang6Parser26ParseCompoundStatementBodyEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseStmt.cpp -nm=_ZN5clang6Parser26ParseCompoundStatementBodyEb")
  //</editor-fold>
  protected /*private*/ ActionResultTTrue<Stmt /*P*/ > ParseCompoundStatementBody() {
    return $this().ParseCompoundStatementBody(false);
  }
  protected /*private*/ ActionResultTTrue<Stmt /*P*/ > ParseCompoundStatementBody(boolean isStmtExpr/*= false*/) {
    PrettyStackTraceLoc CrashInfo = null;
    Sema.FPContractStateRAII SaveFPContractState = null;
    InMessageExpressionRAIIObject InMessage = null;
    BalancedDelimiterTracker T = null;
    Sema.CompoundScopeRAII CompoundScope = null;
    try {
      CrashInfo/*J*/= new PrettyStackTraceLoc($this().PP.getSourceManager(), 
          $this().Tok.getLocation(), 
          $("in compound statement ('{}')"));
      
      // Record the state of the FP_CONTRACT pragma, restore on leaving the
      // compound statement.
      SaveFPContractState/*J*/= new Sema.FPContractStateRAII($this().Actions);
      
      InMessage/*J*/= new InMessageExpressionRAIIObject(/*Deref*/$this(), false);
      T/*J*/= new BalancedDelimiterTracker(/*Deref*/$this(), tok.TokenKind.l_brace);
      if (T.consumeOpen()) {
        return StmtError();
      }
      
      CompoundScope/*J*/= new Sema.CompoundScopeRAII($this().Actions);
      
      // Parse any pragmas at the beginning of the compound statement.
      $this().ParseCompoundStatementLeadingPragmas();
      
      SmallVector<Stmt /*P*/ > Stmts/*J*/= new SmallVector<Stmt /*P*/ >(32, (Stmt /*P*/ )null);
      
      // "__label__ X, Y, Z;" is the GNU "Local Label" extension.  These are
      // only allowed at the start of a compound stmt regardless of the language.
      while ($this().Tok.is(tok.TokenKind.kw___label__)) {
        DeclSpec DS = null;
        try {
          SourceLocation LabelLoc = $this().ConsumeToken();
          
          SmallVector<Decl /*P*/> DeclsInGroup/*J*/= new SmallVector<Decl /*P*/>(8, null);
          while (true) {
            if ($this().Tok.isNot(tok.TokenKind.identifier)) {
              JavaCleaner $c$ = $createJavaCleaner();
              try {
                $c$.clean($out_DiagnosticBuilder$C_TokenKind($c$.track($this().Diag($this().Tok, diag.err_expected)), tok.TokenKind.identifier));
                break;
              } finally {
                $c$.$destroy();
              }
            }
            
            IdentifierInfo /*P*/ II = $this().Tok.getIdentifierInfo();
            SourceLocation IdLoc = $this().ConsumeToken();
            DeclsInGroup.push_back($this().Actions.LookupOrCreateLabel(II, new SourceLocation(IdLoc), new SourceLocation(LabelLoc)));
            if (!$this().TryConsumeToken(tok.TokenKind.comma)) {
              break;
            }
          }
          
          DS/*J*/= new DeclSpec($this().AttrFactory);
          OpaquePtr<DeclGroupRef> Res = $this().Actions.FinalizeDeclaratorGroup($this().getCurScope(), DS, new ArrayRef<Decl /*P*/ >(DeclsInGroup));
          ActionResultTTrue<Stmt /*P*/ > R = $this().Actions.ActOnDeclStmt(new OpaquePtr<DeclGroupRef>(Res), new SourceLocation(LabelLoc), $this().Tok.getLocation());
          
          $this().ExpectAndConsumeSemi(diag.err_expected_semi_declaration);
          if (R.isUsable()) {
            Stmts.push_back(R.get());
          }
        } finally {
          if (DS != null) { DS.$destroy(); }
        }
      }
      while (!$this().tryParseMisplacedModuleImport() && $this().Tok.isNot(tok.TokenKind.r_brace)
         && $this().Tok.isNot(tok.TokenKind.eof)) {
        if ($this().Tok.is(tok.TokenKind.annot_pragma_unused)) {
          $this().HandlePragmaUnused();
          continue;
        }
        
        ActionResultTTrue<Stmt /*P*/ > R/*J*/= new ActionResultTTrue<Stmt /*P*/ >();
        if ($this().Tok.isNot(tok.TokenKind.kw___extension__)) {
          R.$assignMove($this().ParseStatementOrDeclaration(Stmts, AllowedContsructsKind.ACK_Any));
        } else {
          ParsedAttributesWithRange attrs = null;
          try {
            // __extension__ can start declarations and it can also be a unary
            // operator for expressions.  Consume multiple __extension__ markers here
            // until we can determine which is which.
            // FIXME: This loses extension expressions in the AST!
            SourceLocation ExtLoc = $this().ConsumeToken();
            while ($this().Tok.is(tok.TokenKind.kw___extension__)) {
              $this().ConsumeToken();
            }
            
            attrs/*J*/= new ParsedAttributesWithRange($this().AttrFactory);
            $this().MaybeParseCXX11Attributes(attrs, (SourceLocation /*P*/ )null, 
                /*MightBeObjCMessageSend*/ true);
            
            // If this is the start of a declaration, parse it as such.
            if ($this().isDeclarationStatement()) {
              ExtensionRAIIObject O = null;
              try {
                // __extension__ silences extension warnings in the subdeclaration.
                // FIXME: Save the __extension__ on the decl as a node somehow?
                O/*J*/= new ExtensionRAIIObject($this().Diags);
                
                SourceLocation DeclStart = $this().Tok.getLocation(), DeclEnd/*J*/= new SourceLocation();
                OpaquePtr<DeclGroupRef> Res = $this().ParseDeclaration(Declarator.TheContext.BlockContext.getValue(), DeclEnd, 
                    attrs);
                R.$assignMove($this().Actions.ActOnDeclStmt(new OpaquePtr<DeclGroupRef>(Res), new SourceLocation(DeclStart), new SourceLocation(DeclEnd)));
              } finally {
                if (O != null) { O.$destroy(); }
              }
            } else {
              // Otherwise this was a unary __extension__ marker.
              ActionResultTTrue<Expr /*P*/ > Res/*J*/= $this().ParseExpressionWithLeadingExtension(new SourceLocation(ExtLoc));
              if (Res.isInvalid()) {
                $this().SkipUntil(tok.TokenKind.semi);
                continue;
              }
              
              // FIXME: Use attributes?
              // Eat the semicolon at the end of stmt and convert the expr into a
              // statement.
              $this().ExpectAndConsumeSemi(diag.err_expected_semi_after_expr);
              R.$assignMove($this().Actions.ActOnExprStmt(new ActionResultTTrue<Expr /*P*/ >(Res)));
            }
          } finally {
            if (attrs != null) { attrs.$destroy(); }
          }
        }
        if (R.isUsable()) {
          Stmts.push_back(R.get());
        }
      }
      
      SourceLocation CloseLoc = $this().Tok.getLocation();
      
      // We broke out of the while loop because we found a '}' or EOF.
      if (!T.consumeClose()) {
        // Recover by creating a compound statement with what we parsed so far,
        // instead of dropping everything and returning StmtError();
        CloseLoc.$assignMove(T.getCloseLocation());
      }
      
      return $this().Actions.ActOnCompoundStmt(T.getOpenLocation(), new SourceLocation(CloseLoc), 
          new ArrayRef<Stmt /*P*/ >(Stmts), isStmtExpr);
    } finally {
      if (CompoundScope != null) { CompoundScope.$destroy(); }
      if (T != null) { T.$destroy(); }
      if (InMessage != null) { InMessage.$destroy(); }
      if (SaveFPContractState != null) { SaveFPContractState.$destroy(); }
      if (CrashInfo != null) { CrashInfo.$destroy(); }
    }
  }


/// ParseParenExprOrCondition:
/// [C  ]     '(' expression ')'
/// [C++]     '(' condition ')'
/// [C++1z]   '(' init-statement[opt] condition ')'
///
/// This function parses and performs error recovery on the specified condition
/// or expression (depending on whether we're in C++ or C mode).  This function
/// goes out of its way to recover well.  It returns true if there was a parser
/// error (the right paren couldn't be found), which indicates that the caller
/// should try to recover harder.  It returns false if the condition is
/// successfully parsed.  Note that a successful parse can still have semantic
/// errors in the condition.
//<editor-fold defaultstate="collapsed" desc="clang::Parser::ParseParenExprOrCondition">
@Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseStmt.cpp", line = 1056,
   FQN="clang::Parser::ParseParenExprOrCondition", NM="_ZN5clang6Parser25ParseParenExprOrConditionEPNS_12ActionResultIPNS_4StmtELb1EEERNS_4Sema15ConditionResultENS_14SourceLocationENS6_13ConditionKindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseStmt.cpp -nm=_ZN5clang6Parser25ParseParenExprOrConditionEPNS_12ActionResultIPNS_4StmtELb1EEERNS_4Sema15ConditionResultENS_14SourceLocationENS6_13ConditionKindE")
  //</editor-fold>
  protected /*private*/ boolean ParseParenExprOrCondition(ActionResultTTrue<Stmt /*P*/ > /*P*/ InitStmt, 
                           final Sema.ConditionResult /*&*/ Cond, 
                           SourceLocation Loc, 
                           Sema.ConditionKind CK) {
    BalancedDelimiterTracker T = null;
    try {
      T/*J*/= new BalancedDelimiterTracker(/*Deref*/$this(), tok.TokenKind.l_paren);
      T.consumeOpen();
      if ($this().getLangOpts().CPlusPlus) {
        Cond.$assignMove($this().ParseCXXCondition(InitStmt, new SourceLocation(Loc), CK));
      } else {
        ActionResultTTrue<Expr /*P*/ > CondExpr = $this().ParseExpression();
        
        // If required, convert to a boolean value.
        if (CondExpr.isInvalid()) {
          Cond.$assignMove(Sema.ConditionError());
        } else {
          Cond.$assignMove($this().Actions.ActOnCondition($this().getCurScope(), new SourceLocation(Loc), CondExpr.get(), CK));
        }
      }
      
      // If the parser was confused by the condition and we don't have a ')', try to
      // recover by skipping ahead to a semi and bailing out.  If condexp is
      // semantically invalid but we have well formed code, keep going.
      if (Cond.isInvalid() && $this().Tok.isNot(tok.TokenKind.r_paren)) {
        $this().SkipUntil(tok.TokenKind.semi);
        // Skipping may have stopped if it found the containing ')'.  If so, we can
        // continue parsing the if statement.
        if ($this().Tok.isNot(tok.TokenKind.r_paren)) {
          return true;
        }
      }
      
      // Otherwise the condition is valid or the rparen is present.
      T.consumeClose();
      
      // Check for extraneous ')'s to catch things like "if (foo())) {".  We know
      // that all callers are looking for a statement after the condition, so ")"
      // isn't valid.
      while ($this().Tok.is(tok.TokenKind.r_paren)) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_DiagnosticBuilder$C_FixItHint$C($c$.track($this().Diag($this().Tok, diag.err_extraneous_rparen_in_condition)), 
              FixItHint.CreateRemoval(new SourceRange($this().Tok.getLocation()))));
          $this().ConsumeParen();
        } finally {
          $c$.$destroy();
        }
      }
      
      return false;
    } finally {
      if (T != null) { T.$destroy(); }
    }
  }


/// ParseIfStatement
///       if-statement: [C99 6.8.4.1]
///         'if' '(' expression ')' statement
///         'if' '(' expression ')' statement 'else' statement
/// [C++]   'if' '(' condition ')' statement
/// [C++]   'if' '(' condition ')' statement 'else' statement
///
//<editor-fold defaultstate="collapsed" desc="clang::Parser::ParseIfStatement">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*Loc as final pointer*/,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseStmt.cpp", line = 1109,
   FQN="clang::Parser::ParseIfStatement", NM="_ZN5clang6Parser16ParseIfStatementEPNS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseStmt.cpp -nm=_ZN5clang6Parser16ParseIfStatementEPNS_14SourceLocationE")
  //</editor-fold>
  protected /*private*/ ActionResultTTrue<Stmt /*P*/ > ParseIfStatement(final SourceLocation /*P*/ TrailingElseLoc) {
    ParseScope IfScope = null;
    ParseScope InnerScope = null;
    try {
      assert ($this().Tok.is(tok.TokenKind.kw_if)) : "Not an if stmt!";
      SourceLocation IfLoc = $this().ConsumeToken(); // eat the 'if'.
      
      boolean IsConstexpr = false;
      if ($this().Tok.is(tok.TokenKind.kw_constexpr)) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($c$.track($this().Diag($this().Tok, $this().getLangOpts().CPlusPlus1z ? diag.warn_cxx14_compat_constexpr_if : diag.ext_constexpr_if)));
          IsConstexpr = true;
          $this().ConsumeToken();
        } finally {
          $c$.$destroy();
        }
      }
      if ($this().Tok.isNot(tok.TokenKind.l_paren)) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_DiagnosticBuilder$C_char$ptr$C($c$.track($this().Diag($this().Tok, diag.err_expected_lparen_after)), /*KEEP_STR*/$if));
          $this().SkipUntil(tok.TokenKind.semi);
          return StmtError();
        } finally {
          $c$.$destroy();
        }
      }
      
      boolean C99orCXX = $this().getLangOpts().C99 || $this().getLangOpts().CPlusPlus;
      
      // C99 6.8.4p3 - In C99, the if statement is a block.  This is not
      // the case for C90.
      //
      // C++ 6.4p3:
      // A name introduced by a declaration in a condition is in scope from its
      // point of declaration until the end of the substatements controlled by the
      // condition.
      // C++ 3.3.2p4:
      // Names declared in the for-init-statement, and in the condition of if,
      // while, for, and switch statements are local to the if, while, for, or
      // switch statement (including the controlled statement).
      //
      IfScope/*J*/= new ParseScope($this(), Scope.ScopeFlags.DeclScope | Scope.ScopeFlags.ControlScope, C99orCXX);
      
      // Parse the condition.
      ActionResultTTrue<Stmt /*P*/ > InitStmt/*J*/= new ActionResultTTrue<Stmt /*P*/ >();
      Sema.ConditionResult Cond/*J*/= new Sema.ConditionResult();
      if ($this().ParseParenExprOrCondition($AddrOf(InitStmt), Cond, new SourceLocation(IfLoc), 
          IsConstexpr ? Sema.ConditionKind.ConstexprIf : Sema.ConditionKind.Boolean)) {
        return StmtError();
      }
      
      OptionalBool ConstexprCondition/*J*/= new OptionalBool();
      if (IsConstexpr) {
        ConstexprCondition.$assignMove(Cond.getKnownValue());
      }
      
      // C99 6.8.4p3 - In C99, the body of the if statement is a scope, even if
      // there is no compound stmt.  C90 does not have this clause.  We only do this
      // if the body isn't a compound statement to avoid push/pop in common cases.
      //
      // C++ 6.4p1:
      // The substatement in a selection-statement (each substatement, in the else
      // form of the if statement) implicitly defines a local scope.
      //
      // For C++ we create a scope for the condition and a new scope for
      // substatements because:
      // -When the 'then' scope exits, we want the condition declaration to still be
      //    active for the 'else' scope too.
      // -Sema will detect name clashes by considering declarations of a
      //    'ControlScope' as part of its direct subscope.
      // -If we wanted the condition and substatement to be in the same scope, we
      //    would have to notify ParseStatement not to create a new scope. It's
      //    simpler to let it create a new scope.
      //
      InnerScope/*J*/= new ParseScope($this(), Scope.ScopeFlags.DeclScope, C99orCXX, $this().Tok.is(tok.TokenKind.l_brace));
      
      // Read the 'then' stmt.
      SourceLocation ThenStmtLoc = $this().Tok.getLocation();
      
      SourceLocation InnerStatementTrailingElseLoc/*J*/= new SourceLocation();
      ActionResultTTrue<Stmt /*P*/ > ThenStmt/*J*/= new ActionResultTTrue<Stmt /*P*/ >();
      {
        EnterExpressionEvaluationContext PotentiallyDiscarded = null;
        try {
          PotentiallyDiscarded/*J*/= new EnterExpressionEvaluationContext($this().Actions, Sema.ExpressionEvaluationContext.DiscardedStatement, (Decl /*P*/ )null, false, 
              /*ShouldEnter=*/ ConstexprCondition.$bool() && !ConstexprCondition.$star());
          ThenStmt.$assignMove($this().ParseStatement($AddrOf(InnerStatementTrailingElseLoc)));
        } finally {
          if (PotentiallyDiscarded != null) { PotentiallyDiscarded.$destroy(); }
        }
      }
      
      // Pop the 'if' scope if needed.
      InnerScope.Exit();
      
      // If it has an else, parse it.
      SourceLocation ElseLoc/*J*/= new SourceLocation();
      SourceLocation ElseStmtLoc/*J*/= new SourceLocation();
      ActionResultTTrue<Stmt /*P*/ > ElseStmt/*J*/= new ActionResultTTrue<Stmt /*P*/ >();
      if ($this().Tok.is(tok.TokenKind.kw_else)) {
        ParseScope _InnerScope = null;
        EnterExpressionEvaluationContext PotentiallyDiscarded = null;
        try {
          if ((TrailingElseLoc != null)) {
            TrailingElseLoc.$assignMove($this().Tok.getLocation());
          }
          
          ElseLoc.$assignMove($this().ConsumeToken());
          ElseStmtLoc.$assignMove($this().Tok.getLocation());
          
          // C99 6.8.4p3 - In C99, the body of the if statement is a scope, even if
          // there is no compound stmt.  C90 does not have this clause.  We only do
          // this if the body isn't a compound statement to avoid push/pop in common
          // cases.
          //
          // C++ 6.4p1:
          // The substatement in a selection-statement (each substatement, in the else
          // form of the if statement) implicitly defines a local scope.
          //
          _InnerScope/*J*/= new ParseScope($this(), Scope.ScopeFlags.DeclScope, C99orCXX, 
              $this().Tok.is(tok.TokenKind.l_brace));
          
          PotentiallyDiscarded/*J*/= new EnterExpressionEvaluationContext($this().Actions, Sema.ExpressionEvaluationContext.DiscardedStatement, (Decl /*P*/ )null, false, 
              /*ShouldEnter=*/ ConstexprCondition.$bool() && ConstexprCondition.$star());
          ElseStmt.$assignMove($this().ParseStatement());
          
          // Pop the 'else' scope if needed.
          _InnerScope.Exit();
        } finally {
          if (PotentiallyDiscarded != null) { PotentiallyDiscarded.$destroy(); }
          if (_InnerScope != null) { _InnerScope.$destroy(); }
        }
      } else if ($this().Tok.is(tok.TokenKind.code_completion)) {
        $this().Actions.CodeCompleteAfterIf($this().getCurScope());
        $this().cutOffParsing();
        return StmtError();
      } else if (InnerStatementTrailingElseLoc.isValid()) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($c$.track($this().Diag(new SourceLocation(InnerStatementTrailingElseLoc), diag.warn_dangling_else)));
        } finally {
          $c$.$destroy();
        }
      }
      
      IfScope.Exit();
      
      // If the then or else stmt is invalid and the other is valid (and present),
      // make turn the invalid one into a null stmt to avoid dropping the other
      // part.  If both are invalid, return error.
      if ((ThenStmt.isInvalid() && ElseStmt.isInvalid())
         || (ThenStmt.isInvalid() && ElseStmt.get() == null)
         || (ThenStmt.get() == null && ElseStmt.isInvalid())) {
        // Both invalid, or one is invalid and other is non-present: return error.
        return StmtError();
      }
      
      // Now if either are invalid, replace with a ';'.
      if (ThenStmt.isInvalid()) {
        ThenStmt.$assignMove($this().Actions.ActOnNullStmt(new SourceLocation(ThenStmtLoc)));
      }
      if (ElseStmt.isInvalid()) {
        ElseStmt.$assignMove($this().Actions.ActOnNullStmt(new SourceLocation(ElseStmtLoc)));
      }
      
      return $this().Actions.ActOnIfStmt(new SourceLocation(IfLoc), IsConstexpr, InitStmt.get(), new Sema.ConditionResult(Cond), 
          ThenStmt.get(), new SourceLocation(ElseLoc), ElseStmt.get());
    } finally {
      if (InnerScope != null) { InnerScope.$destroy(); }
      if (IfScope != null) { IfScope.$destroy(); }
    }
  }


/// ParseSwitchStatement
///       switch-statement:
///         'switch' '(' expression ')' statement
/// [C++]   'switch' '(' condition ')' statement
//<editor-fold defaultstate="collapsed" desc="clang::Parser::ParseSwitchStatement">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*Loc as final pointer*/,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseStmt.cpp", line = 1255,
   FQN="clang::Parser::ParseSwitchStatement", NM="_ZN5clang6Parser20ParseSwitchStatementEPNS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseStmt.cpp -nm=_ZN5clang6Parser20ParseSwitchStatementEPNS_14SourceLocationE")
  //</editor-fold>
  protected /*private*/ ActionResultTTrue<Stmt /*P*/ > ParseSwitchStatement(final SourceLocation /*P*/ TrailingElseLoc) {
    ParseScope SwitchScope = null;
    ParseScope InnerScope = null;
    try {
      assert ($this().Tok.is(tok.TokenKind.kw_switch)) : "Not a switch stmt!";
      SourceLocation SwitchLoc = $this().ConsumeToken(); // eat the 'switch'.
      if ($this().Tok.isNot(tok.TokenKind.l_paren)) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_DiagnosticBuilder$C_char$ptr$C($c$.track($this().Diag($this().Tok, diag.err_expected_lparen_after)), /*KEEP_STR*/$switch));
          $this().SkipUntil(tok.TokenKind.semi);
          return StmtError();
        } finally {
          $c$.$destroy();
        }
      }
      
      boolean C99orCXX = $this().getLangOpts().C99 || $this().getLangOpts().CPlusPlus;
      
      // C99 6.8.4p3 - In C99, the switch statement is a block.  This is
      // not the case for C90.  Start the switch scope.
      //
      // C++ 6.4p3:
      // A name introduced by a declaration in a condition is in scope from its
      // point of declaration until the end of the substatements controlled by the
      // condition.
      // C++ 3.3.2p4:
      // Names declared in the for-init-statement, and in the condition of if,
      // while, for, and switch statements are local to the if, while, for, or
      // switch statement (including the controlled statement).
      //
      /*uint*/int ScopeFlags = Scope.ScopeFlags.SwitchScope;
      if (C99orCXX) {
        ScopeFlags |= Scope.ScopeFlags.DeclScope | Scope.ScopeFlags.ControlScope;
      }
      SwitchScope/*J*/= new ParseScope($this(), ScopeFlags);
      
      // Parse the condition.
      ActionResultTTrue<Stmt /*P*/ > InitStmt/*J*/= new ActionResultTTrue<Stmt /*P*/ >();
      Sema.ConditionResult Cond/*J*/= new Sema.ConditionResult();
      if ($this().ParseParenExprOrCondition($AddrOf(InitStmt), Cond, new SourceLocation(SwitchLoc), 
          Sema.ConditionKind.Switch)) {
        return StmtError();
      }
      
      ActionResultTTrue<Stmt /*P*/ > Switch = $this().Actions.ActOnStartOfSwitchStmt(new SourceLocation(SwitchLoc), InitStmt.get(), new Sema.ConditionResult(Cond));
      if (Switch.isInvalid()) {
        // Skip the switch body.
        // FIXME: This is not optimal recovery, but parsing the body is more
        // dangerous due to the presence of case and default statements, which
        // will have no place to connect back with the switch.
        if ($this().Tok.is(tok.TokenKind.l_brace)) {
          $this().ConsumeBrace();
          $this().SkipUntil(tok.TokenKind.r_brace);
        } else {
          $this().SkipUntil(tok.TokenKind.semi);
        }
        return Switch;
      }
      
      // C99 6.8.4p3 - In C99, the body of the switch statement is a scope, even if
      // there is no compound stmt.  C90 does not have this clause.  We only do this
      // if the body isn't a compound statement to avoid push/pop in common cases.
      //
      // C++ 6.4p1:
      // The substatement in a selection-statement (each substatement, in the else
      // form of the if statement) implicitly defines a local scope.
      //
      // See comments in ParseIfStatement for why we create a scope for the
      // condition and a new scope for substatement in C++.
      //
      $this().getCurScope().AddFlags(Scope.ScopeFlags.BreakScope);
      InnerScope/*J*/= new ParseScope($this(), Scope.ScopeFlags.DeclScope, C99orCXX, $this().Tok.is(tok.TokenKind.l_brace));
      
      // We have incremented the mangling number for the SwitchScope and the
      // InnerScope, which is one too many.
      if (C99orCXX) {
        $this().getCurScope().decrementMSManglingNumber();
      }
      
      // Read the body statement.
      ActionResultTTrue<Stmt /*P*/ > Body/*J*/= $this().ParseStatement(TrailingElseLoc);
      
      // Pop the scopes.
      InnerScope.Exit();
      SwitchScope.Exit();
      
      return $this().Actions.ActOnFinishSwitchStmt(new SourceLocation(SwitchLoc), Switch.get(), Body.get());
    } finally {
      if (InnerScope != null) { InnerScope.$destroy(); }
      if (SwitchScope != null) { SwitchScope.$destroy(); }
    }
  }


/// ParseWhileStatement
///       while-statement: [C99 6.8.5.1]
///         'while' '(' expression ')' statement
/// [C++]   'while' '(' condition ')' statement
//<editor-fold defaultstate="collapsed" desc="clang::Parser::ParseWhileStatement">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*Loc as final pointer*/,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseStmt.cpp", line = 1340,
   FQN="clang::Parser::ParseWhileStatement", NM="_ZN5clang6Parser19ParseWhileStatementEPNS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseStmt.cpp -nm=_ZN5clang6Parser19ParseWhileStatementEPNS_14SourceLocationE")
  //</editor-fold>
  protected /*private*/ ActionResultTTrue<Stmt /*P*/ > ParseWhileStatement(final SourceLocation /*P*/ TrailingElseLoc) {
    ParseScope WhileScope = null;
    ParseScope InnerScope = null;
    try {
      assert ($this().Tok.is(tok.TokenKind.kw_while)) : "Not a while stmt!";
      SourceLocation WhileLoc = $this().Tok.getLocation();
      $this().ConsumeToken(); // eat the 'while'.
      if ($this().Tok.isNot(tok.TokenKind.l_paren)) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_DiagnosticBuilder$C_char$ptr$C($c$.track($this().Diag($this().Tok, diag.err_expected_lparen_after)), /*KEEP_STR*/$while));
          $this().SkipUntil(tok.TokenKind.semi);
          return StmtError();
        } finally {
          $c$.$destroy();
        }
      }
      
      boolean C99orCXX = $this().getLangOpts().C99 || $this().getLangOpts().CPlusPlus;
      
      // C99 6.8.5p5 - In C99, the while statement is a block.  This is not
      // the case for C90.  Start the loop scope.
      //
      // C++ 6.4p3:
      // A name introduced by a declaration in a condition is in scope from its
      // point of declaration until the end of the substatements controlled by the
      // condition.
      // C++ 3.3.2p4:
      // Names declared in the for-init-statement, and in the condition of if,
      // while, for, and switch statements are local to the if, while, for, or
      // switch statement (including the controlled statement).
      //
      /*uint*/int ScopeFlags;
      if (C99orCXX) {
        ScopeFlags = Scope.ScopeFlags.BreakScope | Scope.ScopeFlags.ContinueScope
           | Scope.ScopeFlags.DeclScope | Scope.ScopeFlags.ControlScope;
      } else {
        ScopeFlags = Scope.ScopeFlags.BreakScope | Scope.ScopeFlags.ContinueScope;
      }
      WhileScope/*J*/= new ParseScope($this(), ScopeFlags);
      
      // Parse the condition.
      Sema.ConditionResult Cond/*J*/= new Sema.ConditionResult();
      if ($this().ParseParenExprOrCondition((ActionResultTTrue<Stmt /*P*/ > /*P*/ )null, Cond, new SourceLocation(WhileLoc), 
          Sema.ConditionKind.Boolean)) {
        return StmtError();
      }
      
      // C99 6.8.5p5 - In C99, the body of the while statement is a scope, even if
      // there is no compound stmt.  C90 does not have this clause.  We only do this
      // if the body isn't a compound statement to avoid push/pop in common cases.
      //
      // C++ 6.5p2:
      // The substatement in an iteration-statement implicitly defines a local scope
      // which is entered and exited each time through the loop.
      //
      // See comments in ParseIfStatement for why we create a scope for the
      // condition and a new scope for substatement in C++.
      //
      InnerScope/*J*/= new ParseScope($this(), Scope.ScopeFlags.DeclScope, C99orCXX, $this().Tok.is(tok.TokenKind.l_brace));
      
      // Read the body statement.
      ActionResultTTrue<Stmt /*P*/ > Body/*J*/= $this().ParseStatement(TrailingElseLoc);
      
      // Pop the body scope if needed.
      InnerScope.Exit();
      WhileScope.Exit();
      if (Cond.isInvalid() || Body.isInvalid()) {
        return StmtError();
      }
      
      return $this().Actions.ActOnWhileStmt(new SourceLocation(WhileLoc), new Sema.ConditionResult(Cond), Body.get());
    } finally {
      if (InnerScope != null) { InnerScope.$destroy(); }
      if (WhileScope != null) { WhileScope.$destroy(); }
    }
  }


/// ParseDoStatement
///       do-statement: [C99 6.8.5.2]
///         'do' statement 'while' '(' expression ')' ';'
/// Note: this lets the caller parse the end ';'.
//<editor-fold defaultstate="collapsed" desc="clang::Parser::ParseDoStatement">
@Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseStmt.cpp", line = 1409,
   FQN="clang::Parser::ParseDoStatement", NM="_ZN5clang6Parser16ParseDoStatementEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseStmt.cpp -nm=_ZN5clang6Parser16ParseDoStatementEv")
  //</editor-fold>
  protected /*private*/ ActionResultTTrue<Stmt /*P*/ > ParseDoStatement() {
    ParseScope DoScope = null;
    ParseScope InnerScope = null;
    BalancedDelimiterTracker T = null;
    try {
      assert ($this().Tok.is(tok.TokenKind.kw_do)) : "Not a do stmt!";
      SourceLocation DoLoc = $this().ConsumeToken(); // eat the 'do'.
      
      // C99 6.8.5p5 - In C99, the do statement is a block.  This is not
      // the case for C90.  Start the loop scope.
      /*uint*/int ScopeFlags;
      if ($this().getLangOpts().C99) {
        ScopeFlags = Scope.ScopeFlags.BreakScope | Scope.ScopeFlags.ContinueScope | Scope.ScopeFlags.DeclScope;
      } else {
        ScopeFlags = Scope.ScopeFlags.BreakScope | Scope.ScopeFlags.ContinueScope;
      }
      
      DoScope/*J*/= new ParseScope($this(), ScopeFlags);
      
      // C99 6.8.5p5 - In C99, the body of the do statement is a scope, even if
      // there is no compound stmt.  C90 does not have this clause. We only do this
      // if the body isn't a compound statement to avoid push/pop in common cases.
      //
      // C++ 6.5p2:
      // The substatement in an iteration-statement implicitly defines a local scope
      // which is entered and exited each time through the loop.
      //
      boolean C99orCXX = $this().getLangOpts().C99 || $this().getLangOpts().CPlusPlus;
      InnerScope/*J*/= new ParseScope($this(), Scope.ScopeFlags.DeclScope, C99orCXX, $this().Tok.is(tok.TokenKind.l_brace));
      
      // Read the body statement.
      ActionResultTTrue<Stmt /*P*/ > Body/*J*/= $this().ParseStatement();
      
      // Pop the body scope if needed.
      InnerScope.Exit();
      if ($this().Tok.isNot(tok.TokenKind.kw_while)) {
        if (!Body.isInvalid()) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            $c$.clean($c$.track($this().Diag($this().Tok, diag.err_expected_while)));
            $c$.clean($out_DiagnosticBuilder$C_char$ptr$C($c$.track($this().Diag(new SourceLocation(DoLoc), diag.note_matching)), /*KEEP_STR*/"'do'"));
            $this().SkipUntil(tok.TokenKind.semi, SkipUntilFlags.StopBeforeMatch);
          } finally {
            $c$.$destroy();
          }
        }
        return StmtError();
      }
      SourceLocation WhileLoc = $this().ConsumeToken();
      if ($this().Tok.isNot(tok.TokenKind.l_paren)) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_DiagnosticBuilder$C_char$ptr$C($c$.track($this().Diag($this().Tok, diag.err_expected_lparen_after)), /*KEEP_STR*/"do/while"));
          $this().SkipUntil(tok.TokenKind.semi, SkipUntilFlags.StopBeforeMatch);
          return StmtError();
        } finally {
          $c$.$destroy();
        }
      }
      
      // Parse the parenthesized expression.
      T/*J*/= new BalancedDelimiterTracker(/*Deref*/$this(), tok.TokenKind.l_paren);
      T.consumeOpen();
      
      // A do-while expression is not a condition, so can't have attributes.
      $this().DiagnoseAndSkipCXX11Attributes();
      
      ActionResultTTrue<Expr /*P*/ > Cond = $this().ParseExpression();
      T.consumeClose();
      DoScope.Exit();
      if (Cond.isInvalid() || Body.isInvalid()) {
        return StmtError();
      }
      
      return $this().Actions.ActOnDoStmt(new SourceLocation(DoLoc), Body.get(), new SourceLocation(WhileLoc), T.getOpenLocation(), 
          Cond.get(), T.getCloseLocation());
    } finally {
      if (T != null) { T.$destroy(); }
      if (InnerScope != null) { InnerScope.$destroy(); }
      if (DoScope != null) { DoScope.$destroy(); }
    }
  }


/// ParseForStatement
///       for-statement: [C99 6.8.5.3]
///         'for' '(' expr[opt] ';' expr[opt] ';' expr[opt] ')' statement
///         'for' '(' declaration expr[opt] ';' expr[opt] ')' statement
/// [C++]   'for' '(' for-init-statement condition[opt] ';' expression[opt] ')'
/// [C++]       statement
/// [C++0x] 'for'
///             'co_await'[opt]    [Coroutines]
///             '(' for-range-declaration ':' for-range-initializer ')'
///             statement
/// [OBJC2] 'for' '(' declaration 'in' expr ')' statement
/// [OBJC2] 'for' '(' expr 'in' expr ')' statement
///
/// [C++] for-init-statement:
/// [C++]   expression-statement
/// [C++]   simple-declaration
///
/// [C++0x] for-range-declaration:
/// [C++0x]   attribute-specifier-seq[opt] type-specifier-seq declarator
/// [C++0x] for-range-initializer:
/// [C++0x]   expression
/// [C++0x]   braced-init-list            [TODO]
//<editor-fold defaultstate="collapsed" desc="clang::Parser::ParseForStatement">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*Loc as final pointer*/,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseStmt.cpp", line = 1515,
   FQN="clang::Parser::ParseForStatement", NM="_ZN5clang6Parser17ParseForStatementEPNS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseStmt.cpp -nm=_ZN5clang6Parser17ParseForStatementEPNS_14SourceLocationE")
  //</editor-fold>
  protected /*private*/ ActionResultTTrue<Stmt /*P*/ > ParseForStatement(final SourceLocation /*P*/ TrailingElseLoc) {
    ParseScope ForScope = null;
    BalancedDelimiterTracker T = null;
    ParsedAttributesWithRange attrs = null;
    ParseScope InnerScope = null;
    try {
      assert ($this().Tok.is(tok.TokenKind.kw_for)) : "Not a for stmt!";
      SourceLocation ForLoc = $this().ConsumeToken(); // eat the 'for'.
      
      SourceLocation CoawaitLoc/*J*/= new SourceLocation();
      if ($this().Tok.is(tok.TokenKind.kw_co_await)) {
        CoawaitLoc.$assignMove($this().ConsumeToken());
      }
      if ($this().Tok.isNot(tok.TokenKind.l_paren)) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_DiagnosticBuilder$C_char$ptr$C($c$.track($this().Diag($this().Tok, diag.err_expected_lparen_after)), /*KEEP_STR*/$for));
          $this().SkipUntil(tok.TokenKind.semi);
          return StmtError();
        } finally {
          $c$.$destroy();
        }
      }
      
      boolean C99orCXXorObjC = $this().getLangOpts().C99 || $this().getLangOpts().CPlusPlus
         || $this().getLangOpts().ObjC1;
      
      // C99 6.8.5p5 - In C99, the for statement is a block.  This is not
      // the case for C90.  Start the loop scope.
      //
      // C++ 6.4p3:
      // A name introduced by a declaration in a condition is in scope from its
      // point of declaration until the end of the substatements controlled by the
      // condition.
      // C++ 3.3.2p4:
      // Names declared in the for-init-statement, and in the condition of if,
      // while, for, and switch statements are local to the if, while, for, or
      // switch statement (including the controlled statement).
      // C++ 6.5.3p1:
      // Names declared in the for-init-statement are in the same declarative-region
      // as those declared in the condition.
      //
      /*uint*/int ScopeFlags = 0;
      if (C99orCXXorObjC) {
        ScopeFlags = Scope.ScopeFlags.DeclScope | Scope.ScopeFlags.ControlScope;
      }
      
      ForScope/*J*/= new ParseScope($this(), ScopeFlags);
      
      T/*J*/= new BalancedDelimiterTracker(/*Deref*/$this(), tok.TokenKind.l_paren);
      T.consumeOpen();
      
      ActionResultTTrue<Expr /*P*/ > Value/*J*/= new ActionResultTTrue<Expr /*P*/ >();
      
      boolean ForEach = false, ForRange = false;
      ActionResultTTrue<Stmt /*P*/ > FirstPart/*J*/= new ActionResultTTrue<Stmt /*P*/ >();
      Sema.ConditionResult SecondPart/*J*/= new Sema.ConditionResult();
      ActionResultTTrue<Expr /*P*/ > Collection/*J*/= new ActionResultTTrue<Expr /*P*/ >();
      ForRangeInit ForRangeInit/*J*/= new ForRangeInit();
      Sema.FullExprArg ThirdPart/*J*/= new Sema.FullExprArg($this().Actions);
      if ($this().Tok.is(tok.TokenKind.code_completion)) {
        $this().Actions.CodeCompleteOrdinaryName($this().getCurScope(), 
            C99orCXXorObjC ? Sema.ParserCompletionContext.PCC_ForInit : Sema.ParserCompletionContext.PCC_Expression);
        $this().cutOffParsing();
        return StmtError();
      }
      
      attrs/*J*/= new ParsedAttributesWithRange($this().AttrFactory);
      $this().MaybeParseCXX11Attributes(attrs);
      
      // Parse the first part of the for specifier.
      if ($this().Tok.is(tok.TokenKind.semi)) { // for (;
        $this().ProhibitAttributes(attrs);
        // no first part, eat the ';'.
        $this().ConsumeToken();
      } else if ($this().getLangOpts().CPlusPlus && $this().Tok.is(tok.TokenKind.identifier)
         && $this().isForRangeIdentifier()) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $this().ProhibitAttributes(attrs);
          IdentifierInfo /*P*/ Name = $this().Tok.getIdentifierInfo();
          SourceLocation Loc = $this().ConsumeToken();
          $this().MaybeParseCXX11Attributes(attrs);
          
          ForRangeInit.ColonLoc.$assignMove($this().ConsumeToken());
          if ($this().Tok.is(tok.TokenKind.l_brace)) {
            ForRangeInit.RangeExpr.$assignMove($this().ParseBraceInitializer());
          } else {
            ForRangeInit.RangeExpr.$assignMove($this().ParseExpression());
          }
          
          $c$.clean($out_DiagnosticBuilder$C_FixItHint$C($c$.track($this().Diag(new SourceLocation(Loc), diag.err_for_range_identifier)), 
              (($this().getLangOpts().CPlusPlus11 && !$this().getLangOpts().CPlusPlus1z) ? FixItHint.CreateInsertion(/*NO_COPY*/Loc, new StringRef(/*KEEP_STR*/"auto &&")) : new FixItHint())));
          
          FirstPart.$assignMove($this().Actions.ActOnCXXForRangeIdentifier($this().getCurScope(), new SourceLocation(Loc), Name, 
                  attrs, attrs.Range.getEnd()));
          ForRange = true;
        } finally {
          $c$.$destroy();
        }
      } else if ($this().isForInitDeclaration()) { // for (int X = 4;
  // Parse declaration, which eats the ';'.
        ColonProtectionRAIIObject ColonProtection = null;
        try {
          if (!C99orCXXorObjC) { // Use of C99-style for loops in C90 mode?
            JavaCleaner $c$ = $createJavaCleaner();
            try {
              $c$.clean($c$.track($this().Diag($this().Tok, diag.ext_c99_variable_decl_in_for_loop)));
            } finally {
              $c$.$destroy();
            }
          }
          
          // In C++0x, "for (T NS:a" might not be a typo for ::
          boolean MightBeForRangeStmt = $this().getLangOpts().CPlusPlus;
          ColonProtection/*J*/= new ColonProtectionRAIIObject(/*Deref*/$this(), MightBeForRangeStmt);
          
          SourceLocation DeclStart = $this().Tok.getLocation(), DeclEnd/*J*/= new SourceLocation();
          OpaquePtr<DeclGroupRef> DG = $this().ParseSimpleDeclaration(Declarator.TheContext.ForContext.getValue(), DeclEnd, attrs, false, 
              MightBeForRangeStmt ? $AddrOf(ForRangeInit) : (ForRangeInit /*P*/ )null);
          FirstPart.$assignMove($this().Actions.ActOnDeclStmt(new OpaquePtr<DeclGroupRef>(DG), new SourceLocation(DeclStart), $this().Tok.getLocation()));
          if (ForRangeInit.ParsedForRangeDecl()) {
            JavaCleaner $c$ = $createJavaCleaner();
            try {
              $c$.clean($c$.track($this().Diag(new SourceLocation(ForRangeInit.ColonLoc), $this().getLangOpts().CPlusPlus11 ? diag.warn_cxx98_compat_for_range : diag.ext_for_range)));
              
              ForRange = true;
            } finally {
              $c$.$destroy();
            }
          } else if ($this().Tok.is(tok.TokenKind.semi)) { // for (int x = 4;
            $this().ConsumeToken();
          } else if ((ForEach = $this().isTokIdentifier_in())) {
            $this().Actions.ActOnForEachDeclStmt(new OpaquePtr<DeclGroupRef>(DG));
            // ObjC: for (id x in expr)
            $this().ConsumeToken(); // consume 'in'
            if ($this().Tok.is(tok.TokenKind.code_completion)) {
              $this().Actions.CodeCompleteObjCForCollection($this().getCurScope(), new OpaquePtr<DeclGroupRef>(DG));
              $this().cutOffParsing();
              return StmtError();
            }
            Collection.$assignMove($this().ParseExpression());
          } else {
            JavaCleaner $c$ = $createJavaCleaner();
            try {
              $c$.clean($c$.track($this().Diag($this().Tok, diag.err_expected_semi_for)));
            } finally {
              $c$.$destroy();
            }
          }
        } finally {
          if (ColonProtection != null) { ColonProtection.$destroy(); }
        }
      } else {
        $this().ProhibitAttributes(attrs);
        Value.$assignMove($this().Actions.CorrectDelayedTyposInExpr($this().ParseExpression()));
        
        ForEach = $this().isTokIdentifier_in();
        
        // Turn the expression into a stmt.
        if (!Value.isInvalid()) {
          if (ForEach) {
            FirstPart.$assignMove($this().Actions.ActOnForEachLValueExpr(Value.get()));
          } else {
            FirstPart.$assignMove($this().Actions.ActOnExprStmt(new ActionResultTTrue<Expr /*P*/ >(Value)));
          }
        }
        if ($this().Tok.is(tok.TokenKind.semi)) {
          $this().ConsumeToken();
        } else if (ForEach) {
          $this().ConsumeToken(); // consume 'in'
          if ($this().Tok.is(tok.TokenKind.code_completion)) {
            $this().Actions.CodeCompleteObjCForCollection($this().getCurScope(), new OpaquePtr<DeclGroupRef>(null));
            $this().cutOffParsing();
            return StmtError();
          }
          Collection.$assignMove($this().ParseExpression());
        } else if ($this().getLangOpts().CPlusPlus11 && $this().Tok.is(tok.TokenKind.colon) && (FirstPart.get() != null)) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            // User tried to write the reasonable, but ill-formed, for-range-statement
            //   for (expr : expr) { ... }
            $c$.clean($out_DiagnosticBuilder$C_SourceRange($c$.track($this().Diag($this().Tok, diag.err_for_range_expected_decl)), 
                FirstPart.get().getSourceRange()));
            $this().SkipUntil(tok.TokenKind.r_paren, SkipUntilFlags.StopBeforeMatch);
            SecondPart.$assignMove(Sema.ConditionError());
          } finally {
            $c$.$destroy();
          }
        } else {
          if (!Value.isInvalid()) {
            JavaCleaner $c$ = $createJavaCleaner();
            try {
              $c$.clean($c$.track($this().Diag($this().Tok, diag.err_expected_semi_for)));
            } finally {
              $c$.$destroy();
            }
          } else {
            // Skip until semicolon or rparen, don't consume it.
            $this().SkipUntil(tok.TokenKind.r_paren, $bitor_SkipUntilFlags(/*KEEP_ENUM*/SkipUntilFlags.StopAtSemi, /*KEEP_ENUM*/SkipUntilFlags.StopBeforeMatch));
            if ($this().Tok.is(tok.TokenKind.semi)) {
              $this().ConsumeToken();
            }
          }
        }
      }
      
      // Parse the second part of the for specifier.
      $this().getCurScope().AddFlags(Scope.ScopeFlags.BreakScope | Scope.ScopeFlags.ContinueScope);
      if (!ForEach && !ForRange && !SecondPart.isInvalid()) {
        // Parse the second part of the for specifier.
        if ($this().Tok.is(tok.TokenKind.semi)) { // for (...;;
  // no second part.
        } else if ($this().Tok.is(tok.TokenKind.r_paren)) {
          // missing both semicolons.
        } else {
          if ($this().getLangOpts().CPlusPlus) {
            SecondPart.$assignMove(
                $this().ParseCXXCondition((ActionResultTTrue<Stmt /*P*/ > /*P*/ )null, new SourceLocation(ForLoc), Sema.ConditionKind.Boolean)
            );
          } else {
            ActionResultTTrue<Expr /*P*/ > SecondExpr = $this().ParseExpression();
            if (SecondExpr.isInvalid()) {
              SecondPart.$assignMove(Sema.ConditionError());
            } else {
              SecondPart.$assignMove(
                  $this().Actions.ActOnCondition($this().getCurScope(), new SourceLocation(ForLoc), SecondExpr.get(), 
                      Sema.ConditionKind.Boolean)
              );
            }
          }
        }
        if ($this().Tok.isNot(tok.TokenKind.semi)) {
          if (!SecondPart.isInvalid()) {
            JavaCleaner $c$ = $createJavaCleaner();
            try {
              $c$.clean($c$.track($this().Diag($this().Tok, diag.err_expected_semi_for)));
            } finally {
              $c$.$destroy();
            }
          } else {
            // Skip until semicolon or rparen, don't consume it.
            $this().SkipUntil(tok.TokenKind.r_paren, $bitor_SkipUntilFlags(/*KEEP_ENUM*/SkipUntilFlags.StopAtSemi, /*KEEP_ENUM*/SkipUntilFlags.StopBeforeMatch));
          }
        }
        if ($this().Tok.is(tok.TokenKind.semi)) {
          $this().ConsumeToken();
        }
        
        // Parse the third part of the for specifier.
        if ($this().Tok.isNot(tok.TokenKind.r_paren)) { // for (...;...;)
          ActionResultTTrue<Expr /*P*/ > Third = $this().ParseExpression();
          // FIXME: The C++11 standard doesn't actually say that this is a
          // discarded-value expression, but it clearly should be.
          ThirdPart.$assignMove($this().Actions.MakeFullDiscardedValueExpr(Third.get()));
        }
      }
      // Match the ')'.
      T.consumeClose();
      
      // C++ Coroutines [stmt.iter]:
      //   'co_await' can only be used for a range-based for statement.
      if (CoawaitLoc.isValid() && !ForRange) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($c$.track($this().Diag(new SourceLocation(CoawaitLoc), diag.err_for_co_await_not_range_for)));
          CoawaitLoc.$assignMove(new SourceLocation());
        } finally {
          $c$.$destroy();
        }
      }
      
      // We need to perform most of the semantic analysis for a C++0x for-range
      // statememt before parsing the body, in order to be able to deduce the type
      // of an auto-typed loop variable.
      ActionResultTTrue<Stmt /*P*/ > ForRangeStmt/*J*/= new ActionResultTTrue<Stmt /*P*/ >();
      ActionResultTTrue<Stmt /*P*/ > ForEachStmt/*J*/= new ActionResultTTrue<Stmt /*P*/ >();
      if (ForRange) {
        ActionResultTTrue<Expr /*P*/ > CorrectedRange = $this().Actions.CorrectDelayedTyposInExpr(ForRangeInit.RangeExpr.get());
        ForRangeStmt.$assignMove($this().Actions.ActOnCXXForRangeStmt($this().getCurScope(), new SourceLocation(ForLoc), new SourceLocation(CoawaitLoc), FirstPart.get(), 
                new SourceLocation(ForRangeInit.ColonLoc), CorrectedRange.get(), 
                T.getCloseLocation(), Sema.BuildForRangeKind.BFRK_Build));
        // Similarly, we need to do the semantic analysis for a for-range
        // statement immediately in order to close over temporaries correctly.
      } else if (ForEach) {
        ForEachStmt.$assignMove($this().Actions.ActOnObjCForCollectionStmt(new SourceLocation(ForLoc), 
                FirstPart.get(), 
                Collection.get(), 
                T.getCloseLocation()));
      } else {
        // In OpenMP loop region loop control variable must be captured and be
        // private. Perform analysis of first part (if any).
        if (($this().getLangOpts().OpenMP != 0) && FirstPart.isUsable()) {
          $this().Actions.ActOnOpenMPLoopInitialization(new SourceLocation(ForLoc), FirstPart.get());
        }
      }
      
      // C99 6.8.5p5 - In C99, the body of the for statement is a scope, even if
      // there is no compound stmt.  C90 does not have this clause.  We only do this
      // if the body isn't a compound statement to avoid push/pop in common cases.
      //
      // C++ 6.5p2:
      // The substatement in an iteration-statement implicitly defines a local scope
      // which is entered and exited each time through the loop.
      //
      // See comments in ParseIfStatement for why we create a scope for
      // for-init-statement/condition and a new scope for substatement in C++.
      //
      InnerScope/*J*/= new ParseScope($this(), Scope.ScopeFlags.DeclScope, C99orCXXorObjC, 
          $this().Tok.is(tok.TokenKind.l_brace));
      
      // The body of the for loop has the same local mangling number as the
      // for-init-statement.
      // It will only be incremented if the body contains other things that would
      // normally increment the mangling number (like a compound statement).
      if (C99orCXXorObjC) {
        $this().getCurScope().decrementMSManglingNumber();
      }
      
      // Read the body statement.
      ActionResultTTrue<Stmt /*P*/ > Body/*J*/= $this().ParseStatement(TrailingElseLoc);
      
      // Pop the body scope if needed.
      InnerScope.Exit();
      
      // Leave the for-scope.
      ForScope.Exit();
      if (Body.isInvalid()) {
        return StmtError();
      }
      if (ForEach) {
        return $this().Actions.FinishObjCForCollectionStmt(ForEachStmt.get(), 
            Body.get());
      }
      if (ForRange) {
        return $this().Actions.FinishCXXForRangeStmt(ForRangeStmt.get(), Body.get());
      }
      
      return $this().Actions.ActOnForStmt(new SourceLocation(ForLoc), T.getOpenLocation(), FirstPart.get(), 
          new Sema.ConditionResult(SecondPart), new Sema.FullExprArg(ThirdPart), T.getCloseLocation(), 
          Body.get());
    } finally {
      if (InnerScope != null) { InnerScope.$destroy(); }
      if (attrs != null) { attrs.$destroy(); }
      if (T != null) { T.$destroy(); }
      if (ForScope != null) { ForScope.$destroy(); }
    }
  }


/// ParseGotoStatement
///       jump-statement:
///         'goto' identifier ';'
/// [GNU]   'goto' '*' expression ';'
///
/// Note: this lets the caller parse the end ';'.
///
//<editor-fold defaultstate="collapsed" desc="clang::Parser::ParseGotoStatement">
@Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseStmt.cpp", line = 1815,
   FQN="clang::Parser::ParseGotoStatement", NM="_ZN5clang6Parser18ParseGotoStatementEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseStmt.cpp -nm=_ZN5clang6Parser18ParseGotoStatementEv")
  //</editor-fold>
  protected /*private*/ ActionResultTTrue<Stmt /*P*/ > ParseGotoStatement() {
    assert ($this().Tok.is(tok.TokenKind.kw_goto)) : "Not a goto stmt!";
    SourceLocation GotoLoc = $this().ConsumeToken(); // eat the 'goto'.
    
    ActionResultTTrue<Stmt /*P*/ > Res/*J*/= new ActionResultTTrue<Stmt /*P*/ >();
    if ($this().Tok.is(tok.TokenKind.identifier)) {
      LabelDecl /*P*/ LD = $this().Actions.LookupOrCreateLabel($this().Tok.getIdentifierInfo(), 
          $this().Tok.getLocation());
      Res.$assignMove($this().Actions.ActOnGotoStmt(new SourceLocation(GotoLoc), $this().Tok.getLocation(), LD));
      $this().ConsumeToken();
    } else if ($this().Tok.is(tok.TokenKind.star)) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        // GNU indirect goto extension.
        $c$.clean($c$.track($this().Diag($this().Tok, diag.ext_gnu_indirect_goto)));
        SourceLocation StarLoc = $this().ConsumeToken();
        ActionResultTTrue<Expr /*P*/ > R/*J*/= $this().ParseExpression();
        if (R.isInvalid()) { // Skip to the semicolon, but don't consume it.
          $this().SkipUntil(tok.TokenKind.semi, SkipUntilFlags.StopBeforeMatch);
          return StmtError();
        }
        Res.$assignMove($this().Actions.ActOnIndirectGotoStmt(new SourceLocation(GotoLoc), new SourceLocation(StarLoc), R.get()));
      } finally {
        $c$.$destroy();
      }
    } else {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_DiagnosticBuilder$C_TokenKind($c$.track($this().Diag($this().Tok, diag.err_expected)), tok.TokenKind.identifier));
        return StmtError();
      } finally {
        $c$.$destroy();
      }
    }
    
    return Res;
  }


/// ParseContinueStatement
///       jump-statement:
///         'continue' ';'
///
/// Note: this lets the caller parse the end ';'.
///
//<editor-fold defaultstate="collapsed" desc="clang::Parser::ParseContinueStatement">
@Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseStmt.cpp", line = 1849,
   FQN="clang::Parser::ParseContinueStatement", NM="_ZN5clang6Parser22ParseContinueStatementEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseStmt.cpp -nm=_ZN5clang6Parser22ParseContinueStatementEv")
  //</editor-fold>
  protected /*private*/ ActionResultTTrue<Stmt /*P*/ > ParseContinueStatement() {
    SourceLocation ContinueLoc = $this().ConsumeToken(); // eat the 'continue'.
    return $this().Actions.ActOnContinueStmt(new SourceLocation(ContinueLoc), $this().getCurScope());
  }


/// ParseBreakStatement
///       jump-statement:
///         'break' ';'
///
/// Note: this lets the caller parse the end ';'.
///
//<editor-fold defaultstate="collapsed" desc="clang::Parser::ParseBreakStatement">
@Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseStmt.cpp", line = 1860,
   FQN="clang::Parser::ParseBreakStatement", NM="_ZN5clang6Parser19ParseBreakStatementEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseStmt.cpp -nm=_ZN5clang6Parser19ParseBreakStatementEv")
  //</editor-fold>
  protected /*private*/ ActionResultTTrue<Stmt /*P*/ > ParseBreakStatement() {
    SourceLocation BreakLoc = $this().ConsumeToken(); // eat the 'break'.
    return $this().Actions.ActOnBreakStmt(new SourceLocation(BreakLoc), $this().getCurScope());
  }


/// ParseReturnStatement
///       jump-statement:
///         'return' expression[opt] ';'
///         'return' braced-init-list ';'
///         'co_return' expression[opt] ';'
///         'co_return' braced-init-list ';'
//<editor-fold defaultstate="collapsed" desc="clang::Parser::ParseReturnStatement">
@Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseStmt.cpp", line = 1871,
   FQN="clang::Parser::ParseReturnStatement", NM="_ZN5clang6Parser20ParseReturnStatementEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseStmt.cpp -nm=_ZN5clang6Parser20ParseReturnStatementEv")
  //</editor-fold>
  protected /*private*/ ActionResultTTrue<Stmt /*P*/ > ParseReturnStatement() {
    assert (($this().Tok.is(tok.TokenKind.kw_return) || $this().Tok.is(tok.TokenKind.kw_co_return))) : "Not a return stmt!";
    boolean IsCoreturn = $this().Tok.is(tok.TokenKind.kw_co_return);
    SourceLocation ReturnLoc = $this().ConsumeToken(); // eat the 'return'.
    
    ActionResultTTrue<Expr /*P*/ > R/*J*/= new ActionResultTTrue<Expr /*P*/ >();
    if ($this().Tok.isNot(tok.TokenKind.semi)) {
      // FIXME: Code completion for co_return.
      if ($this().Tok.is(tok.TokenKind.code_completion) && !IsCoreturn) {
        $this().Actions.CodeCompleteReturn($this().getCurScope());
        $this().cutOffParsing();
        return StmtError();
      }
      if ($this().Tok.is(tok.TokenKind.l_brace) && $this().getLangOpts().CPlusPlus) {
        R.$assignMove($this().ParseInitializer());
        if (R.isUsable()) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            $c$.clean($out_DiagnosticBuilder$C_SourceRange($c$.track($this().Diag(R.get().getLocStart(), $this().getLangOpts().CPlusPlus11 ? diag.warn_cxx98_compat_generalized_initializer_lists : diag.ext_generalized_initializer_lists)), 
                R.get().getSourceRange()));
          } finally {
            $c$.$destroy();
          }
        }
      } else {
        R.$assignMove($this().ParseExpression());
      }
      if (R.isInvalid()) {
        $this().SkipUntil(tok.TokenKind.r_brace, $bitor_SkipUntilFlags(/*KEEP_ENUM*/SkipUntilFlags.StopAtSemi, /*KEEP_ENUM*/SkipUntilFlags.StopBeforeMatch));
        return StmtError();
      }
    }
    if (IsCoreturn) {
      return $this().Actions.ActOnCoreturnStmt(new SourceLocation(ReturnLoc), R.get());
    }
    return $this().Actions.ActOnReturnStmt(new SourceLocation(ReturnLoc), create_type$ptr(R.get()), $this().getCurScope());
  }

//<editor-fold defaultstate="collapsed" desc="clang::Parser::ParsePragmaLoopHint">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*Loc as final pointer*/,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseStmt.cpp", line = 1905,
   FQN="clang::Parser::ParsePragmaLoopHint", NM="_ZN5clang6Parser19ParsePragmaLoopHintERN4llvm11SmallVectorIPNS_4StmtELj32EEENS0_21AllowedContsructsKindEPNS_14SourceLocationERNS0_25ParsedAttributesWithRangeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseStmt.cpp -nm=_ZN5clang6Parser19ParsePragmaLoopHintERN4llvm11SmallVectorIPNS_4StmtELj32EEENS0_21AllowedContsructsKindEPNS_14SourceLocationERNS0_25ParsedAttributesWithRangeE")
  //</editor-fold>
  protected /*private*/ ActionResultTTrue<Stmt /*P*/ > ParsePragmaLoopHint(final SmallVector<Stmt /*P*/ > /*&*/ Stmts, 
                     AllowedContsructsKind Allowed, 
                     final SourceLocation /*P*/ TrailingElseLoc, 
                     final ParsedAttributesWithRange /*&*/ Attrs) {
    ParsedAttributesWithRange TempAttrs = null;
    try {
      // Create temporary attribute list.
      TempAttrs/*J*/= new ParsedAttributesWithRange($this().AttrFactory);
      
      // Get loop hints and consume annotated token.
      while ($this().Tok.is(tok.TokenKind.annot_pragma_loop_hint)) {
        LoopHint Hint/*J*/= new LoopHint();
        if (!$this().HandlePragmaLoopHint(Hint)) {
          continue;
        }
        
        PointerUnion<Expr/*P*/, IdentifierLoc/*P*/> ArgHints[/*4*/] = new PointerUnion[/*4*/] {
          new PointerUnion<Expr/*P*/, IdentifierLoc/*P*/>(JD$T1.INSTANCE, IdentifierLoc /*P*/ .class, Hint.PragmaNameLoc), 
          new PointerUnion<Expr/*P*/, IdentifierLoc/*P*/>(JD$T1.INSTANCE, IdentifierLoc /*P*/ .class, Hint.OptionLoc), 
          new PointerUnion<Expr/*P*/, IdentifierLoc/*P*/>(JD$T1.INSTANCE, IdentifierLoc /*P*/ .class, Hint.StateLoc), 
          new PointerUnion<Expr /*P*/ , IdentifierLoc /*P*/ >(JD$T.INSTANCE, Expr /*P*/ .class, Hint.ValueExpr)};
        TempAttrs.addNew(Hint.PragmaNameLoc.Ident, new SourceRange(Hint.Range), (IdentifierInfo /*P*/ )null, 
            new SourceLocation(Hint.PragmaNameLoc.Loc), create_type$ptr(ArgHints), 4, 
            AttributeList.Syntax.AS_Pragma);
      }
      
      // Get the next statement.
      $this().MaybeParseCXX11Attributes(Attrs);
      
      ActionResultTTrue<Stmt /*P*/ > S = $this().ParseStatementOrDeclarationAfterAttributes(Stmts, Allowed, TrailingElseLoc, Attrs);
      
      Attrs.takeAllFrom(TempAttrs);
      return S;
    } finally {
      if (TempAttrs != null) { TempAttrs.$destroy(); }
    }
  }

//<editor-fold defaultstate="collapsed" desc="clang::Parser::ParseMicrosoftIfExistsStatement">
@Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseStmt.cpp", line = 2183,
   FQN="clang::Parser::ParseMicrosoftIfExistsStatement", NM="_ZN5clang6Parser31ParseMicrosoftIfExistsStatementERN4llvm11SmallVectorIPNS_4StmtELj32EEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseStmt.cpp -nm=_ZN5clang6Parser31ParseMicrosoftIfExistsStatementERN4llvm11SmallVectorIPNS_4StmtELj32EEE")
  //</editor-fold>
  protected /*private*/ void ParseMicrosoftIfExistsStatement(final SmallVector<Stmt /*P*/ > /*&*/ Stmts) {
    IfExistsCondition Result = null;
    BalancedDelimiterTracker Braces = null;
    try {
      Result/*J*/= new IfExistsCondition();
      if ($this().ParseMicrosoftIfExistsCondition(Result)) {
        return;
      }
      
      // Handle dependent statements by parsing the braces as a compound statement.
      // This is not the same behavior as Visual C++, which don't treat this as a
      // compound statement, but for Clang's type checking we can't have anything
      // inside these braces escaping to the surrounding code.
      if (Result.Behavior == IfExistsBehavior.IEB_Dependent) {
        if (!$this().Tok.is(tok.TokenKind.l_brace)) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            $c$.clean($out_DiagnosticBuilder$C_TokenKind($c$.track($this().Diag($this().Tok, diag.err_expected)), tok.TokenKind.l_brace));
            return;
          } finally {
            $c$.$destroy();
          }
        }
        
        ActionResultTTrue<Stmt /*P*/ > Compound = $this().ParseCompoundStatement();
        if (Compound.isInvalid()) {
          return;
        }
        
        ActionResultTTrue<Stmt /*P*/ > DepResult = $this().Actions.ActOnMSDependentExistsStmt(new SourceLocation(Result.KeywordLoc), 
            Result.IsIfExists, 
            Result.SS, 
            Result.Name, 
            Compound.get());
        if (DepResult.isUsable()) {
          Stmts.push_back(DepResult.get());
        }
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
        // Parse the statements below.
        break;
       case IEB_Dependent:
        throw new llvm_unreachable("Dependent case handled above");
       case IEB_Skip:
        Braces.skipToEnd();
        return;
      }
      
      // Condition is true, parse the statements.
      while ($this().Tok.isNot(tok.TokenKind.r_brace)) {
        ActionResultTTrue<Stmt /*P*/ > R = $this().ParseStatementOrDeclaration(Stmts, AllowedContsructsKind.ACK_Any);
        if (R.isUsable()) {
          Stmts.push_back(R.get());
        }
      }
      Braces.consumeClose();
    } finally {
      if (Braces != null) { Braces.$destroy(); }
      if (Result != null) { Result.$destroy(); }
    }
  }


//===--------------------------------------------------------------------===//
// C++ 6: Statements and Blocks

/// ParseCXXTryBlock - Parse a C++ try-block.
///
///       try-block:
///         'try' compound-statement handler-seq
///
//<editor-fold defaultstate="collapsed" desc="clang::Parser::ParseCXXTryBlock">
@Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseStmt.cpp", line = 2045,
   FQN="clang::Parser::ParseCXXTryBlock", NM="_ZN5clang6Parser16ParseCXXTryBlockEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseStmt.cpp -nm=_ZN5clang6Parser16ParseCXXTryBlockEv")
  //</editor-fold>
  protected /*private*/ ActionResultTTrue<Stmt /*P*/ > ParseCXXTryBlock() {
    assert ($this().Tok.is(tok.TokenKind.kw_try)) : "Expected 'try'";
    
    SourceLocation TryLoc = $this().ConsumeToken();
    return $this().ParseCXXTryBlockCommon(new SourceLocation(TryLoc));
  }


/// ParseCXXTryBlockCommon - Parse the common part of try-block and
/// function-try-block.
///
///       try-block:
///         'try' compound-statement handler-seq
///
///       function-try-block:
///         'try' ctor-initializer[opt] compound-statement handler-seq
///
///       handler-seq:
///         handler handler-seq[opt]
///
///       [Borland] try-block:
///         'try' compound-statement seh-except-block
///         'try' compound-statement seh-finally-block
///
//<editor-fold defaultstate="collapsed" desc="clang::Parser::ParseCXXTryBlockCommon">
@Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseStmt.cpp", line = 2068,
   FQN="clang::Parser::ParseCXXTryBlockCommon", NM="_ZN5clang6Parser22ParseCXXTryBlockCommonENS_14SourceLocationEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseStmt.cpp -nm=_ZN5clang6Parser22ParseCXXTryBlockCommonENS_14SourceLocationEb")
  //</editor-fold>
  protected /*private*/ ActionResultTTrue<Stmt /*P*/ > ParseCXXTryBlockCommon(SourceLocation TryLoc) {
    return $this().ParseCXXTryBlockCommon(TryLoc, false);
  }
  protected /*private*/ ActionResultTTrue<Stmt /*P*/ > ParseCXXTryBlockCommon(SourceLocation TryLoc, boolean FnTry/*= false*/) {
    if ($this().Tok.isNot(tok.TokenKind.l_brace)) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        return $c$.clean(StmtError($out_DiagnosticBuilder$C_TokenKind($c$.track($this().Diag($this().Tok, diag.err_expected)), tok.TokenKind.l_brace)));
      } finally {
        $c$.$destroy();
      }
    }
    
    ActionResultTTrue<Stmt /*P*/ > TryBlock/*J*/= $this().ParseCompoundStatement(/*isStmtExpr=*/ false, 
        Scope.ScopeFlags.DeclScope | Scope.ScopeFlags.TryScope
           | (FnTry ? Scope.ScopeFlags.FnTryCatchScope : 0));
    if (TryBlock.isInvalid()) {
      return TryBlock;
    }
    
    // Borland allows SEH-handlers with 'try'
    if (($this().Tok.is(tok.TokenKind.identifier)
       && $this().Tok.getIdentifierInfo() == $this().getSEHExceptKeyword())
       || $this().Tok.is(tok.TokenKind.kw___finally)) {
      // TODO: Factor into common return ParseSEHHandlerCommon(...)
      ActionResultTTrue<Stmt /*P*/ > Handler/*J*/= new ActionResultTTrue<Stmt /*P*/ >();
      if ($this().Tok.getIdentifierInfo() == $this().getSEHExceptKeyword()) {
        SourceLocation Loc = $this().ConsumeToken();
        Handler.$assignMove($this().ParseSEHExceptBlock(new SourceLocation(Loc)));
      } else {
        SourceLocation Loc = $this().ConsumeToken();
        Handler.$assignMove($this().ParseSEHFinallyBlock(new SourceLocation(Loc)));
      }
      if (Handler.isInvalid()) {
        return Handler;
      }
      
      return $this().Actions.ActOnSEHTryBlock(true/* IsCXXTry */, 
          new SourceLocation(TryLoc), 
          TryBlock.get(), 
          Handler.get());
    } else {
      SmallVector<Stmt /*P*/ > Handlers/*J*/= new SmallVector<Stmt /*P*/ >(32, (Stmt /*P*/ )null);
      
      // C++11 attributes can't appear here, despite this context seeming
      // statement-like.
      $this().DiagnoseAndSkipCXX11Attributes();
      if ($this().Tok.isNot(tok.TokenKind.kw_catch)) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          return $c$.clean(StmtError($c$.track($this().Diag($this().Tok, diag.err_expected_catch))));
        } finally {
          $c$.$destroy();
        }
      }
      while ($this().Tok.is(tok.TokenKind.kw_catch)) {
        ActionResultTTrue<Stmt /*P*/ > Handler/*J*/= $this().ParseCXXCatchBlock(FnTry);
        if (!Handler.isInvalid()) {
          Handlers.push_back(Handler.get());
        }
      }
      // Don't bother creating the full statement if we don't have any usable
      // handlers.
      if (Handlers.empty()) {
        return StmtError();
      }
      
      return $this().Actions.ActOnCXXTryBlock(new SourceLocation(TryLoc), TryBlock.get(), new ArrayRef<Stmt /*P*/ >(Handlers));
    }
  }


/// ParseCXXCatchBlock - Parse a C++ catch block, called handler in the standard
///
///   handler:
///     'catch' '(' exception-declaration ')' compound-statement
///
///   exception-declaration:
///     attribute-specifier-seq[opt] type-specifier-seq declarator
///     attribute-specifier-seq[opt] type-specifier-seq abstract-declarator[opt]
///     '...'
///
//<editor-fold defaultstate="collapsed" desc="clang::Parser::ParseCXXCatchBlock">
@Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseStmt.cpp", line = 2134,
   FQN="clang::Parser::ParseCXXCatchBlock", NM="_ZN5clang6Parser18ParseCXXCatchBlockEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseStmt.cpp -nm=_ZN5clang6Parser18ParseCXXCatchBlockEb")
  //</editor-fold>
  protected /*private*/ ActionResultTTrue<Stmt /*P*/ > ParseCXXCatchBlock() {
    return $this().ParseCXXCatchBlock(false);
  }
  protected /*private*/ ActionResultTTrue<Stmt /*P*/ > ParseCXXCatchBlock(boolean FnCatch/*= false*/) {
    BalancedDelimiterTracker T = null;
    ParseScope CatchScope = null;
    try {
      assert ($this().Tok.is(tok.TokenKind.kw_catch)) : "Expected 'catch'";
      
      SourceLocation CatchLoc = $this().ConsumeToken();
      
      T/*J*/= new BalancedDelimiterTracker(/*Deref*/$this(), tok.TokenKind.l_paren);
      if (T.expectAndConsume()) {
        return StmtError();
      }
      
      // C++ 3.3.2p3:
      // The name in a catch exception-declaration is local to the handler and
      // shall not be redeclared in the outermost block of the handler.
      CatchScope/*J*/= new ParseScope($this(), Scope.ScopeFlags.DeclScope | Scope.ScopeFlags.ControlScope
             | (FnCatch ? Scope.ScopeFlags.FnTryCatchScope : 0));
      
      // exception-declaration is equivalent to '...' or a parameter-declaration
      // without default arguments.
      Decl /*P*/ ExceptionDecl = null;
      if ($this().Tok.isNot(tok.TokenKind.ellipsis)) {
        ParsedAttributesWithRange Attributes = null;
        DeclSpec DS = null;
        Declarator ExDecl = null;
        try {
          Attributes/*J*/= new ParsedAttributesWithRange($this().AttrFactory);
          $this().MaybeParseCXX11Attributes(Attributes);
          
          DS/*J*/= new DeclSpec($this().AttrFactory);
          DS.takeAttributesFrom(Attributes);
          if ($this().ParseCXXTypeSpecifierSeq(DS)) {
            return StmtError();
          }
          
          ExDecl/*J*/= new Declarator(DS, Declarator.TheContext.CXXCatchContext);
          $this().ParseDeclarator(ExDecl);
          ExceptionDecl = $this().Actions.ActOnExceptionDeclarator($this().getCurScope(), ExDecl);
        } finally {
          if (ExDecl != null) { ExDecl.$destroy(); }
          if (DS != null) { DS.$destroy(); }
          if (Attributes != null) { Attributes.$destroy(); }
        }
      } else {
        $this().ConsumeToken();
      }
      
      T.consumeClose();
      if (T.getCloseLocation().isInvalid()) {
        return StmtError();
      }
      if ($this().Tok.isNot(tok.TokenKind.l_brace)) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          return $c$.clean(StmtError($out_DiagnosticBuilder$C_TokenKind($c$.track($this().Diag($this().Tok, diag.err_expected)), tok.TokenKind.l_brace)));
        } finally {
          $c$.$destroy();
        }
      }
      
      // FIXME: Possible draft standard bug: attribute-specifier should be allowed?
      ActionResultTTrue<Stmt /*P*/ > Block/*J*/= $this().ParseCompoundStatement();
      if (Block.isInvalid()) {
        return Block;
      }
      
      return $this().Actions.ActOnCXXCatchBlock(new SourceLocation(CatchLoc), ExceptionDecl, Block.get());
    } finally {
      if (CatchScope != null) { CatchScope.$destroy(); }
      if (T != null) { T.$destroy(); }
    }
  }


//===--------------------------------------------------------------------===//
// MS: SEH Statements and Blocks

/// ParseSEHTryBlockCommon
///
/// seh-try-block:
///   '__try' compound-statement seh-handler
///
/// seh-handler:
///   seh-except-block
///   seh-finally-block
///
//<editor-fold defaultstate="collapsed" desc="clang::Parser::ParseSEHTryBlock">
@Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseStmt.cpp", line = 438,
   FQN="clang::Parser::ParseSEHTryBlock", NM="_ZN5clang6Parser16ParseSEHTryBlockEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseStmt.cpp -nm=_ZN5clang6Parser16ParseSEHTryBlockEv")
  //</editor-fold>
  protected /*private*/ ActionResultTTrue<Stmt /*P*/ > ParseSEHTryBlock() {
    assert ($this().Tok.is(tok.TokenKind.kw___try)) : "Expected '__try'";
    SourceLocation TryLoc = $this().ConsumeToken();
    if ($this().Tok.isNot(tok.TokenKind.l_brace)) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        return $c$.clean(StmtError($out_DiagnosticBuilder$C_TokenKind($c$.track($this().Diag($this().Tok, diag.err_expected)), tok.TokenKind.l_brace)));
      } finally {
        $c$.$destroy();
      }
    }
    
    ActionResultTTrue<Stmt /*P*/ > TryBlock/*J*/= $this().ParseCompoundStatement(/*isStmtExpr=*/ false, 
        Scope.ScopeFlags.DeclScope | Scope.ScopeFlags.SEHTryScope);
    if (TryBlock.isInvalid()) {
      return TryBlock;
    }
    
    ActionResultTTrue<Stmt /*P*/ > Handler/*J*/= new ActionResultTTrue<Stmt /*P*/ >();
    if ($this().Tok.is(tok.TokenKind.identifier)
       && $this().Tok.getIdentifierInfo() == $this().getSEHExceptKeyword()) {
      SourceLocation Loc = $this().ConsumeToken();
      Handler.$assignMove($this().ParseSEHExceptBlock(new SourceLocation(Loc)));
    } else if ($this().Tok.is(tok.TokenKind.kw___finally)) {
      SourceLocation Loc = $this().ConsumeToken();
      Handler.$assignMove($this().ParseSEHFinallyBlock(new SourceLocation(Loc)));
    } else {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        return $c$.clean(StmtError($c$.track($this().Diag($this().Tok, diag.err_seh_expected_handler))));
      } finally {
        $c$.$destroy();
      }
    }
    if (Handler.isInvalid()) {
      return Handler;
    }
    
    return $this().Actions.ActOnSEHTryBlock(false/* IsCXXTry */, 
        new SourceLocation(TryLoc), 
        TryBlock.get(), 
        Handler.get());
  }


/// ParseSEHExceptBlock - Handle __except
///
/// seh-except-block:
///   '__except' '(' seh-filter-expression ')' compound-statement
///
//<editor-fold defaultstate="collapsed" desc="clang::Parser::ParseSEHExceptBlock">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseStmt.cpp", line = 476,
   FQN="clang::Parser::ParseSEHExceptBlock", NM="_ZN5clang6Parser19ParseSEHExceptBlockENS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseStmt.cpp -nm=_ZN5clang6Parser19ParseSEHExceptBlockENS_14SourceLocationE")
  //</editor-fold>
  protected /*private*/ ActionResultTTrue<Stmt /*P*/ > ParseSEHExceptBlock(SourceLocation ExceptLoc) {
    PoisonIdentifierRAIIObject raii = null;
    PoisonIdentifierRAIIObject raii2 = null;
    PoisonIdentifierRAIIObject raii3 = null;
    ParseScope ExpectScope = null;
    try {
      raii/*J*/= new PoisonIdentifierRAIIObject($this().Ident__exception_code, false);
          raii2/*J*/= new PoisonIdentifierRAIIObject($this().Ident___exception_code, false);
          raii3/*J*/= new PoisonIdentifierRAIIObject($this().Ident_GetExceptionCode, false);
      if ($this().ExpectAndConsume(tok.TokenKind.l_paren)) {
        return StmtError();
      }
      
      ExpectScope/*J*/= new ParseScope($this(), Scope.ScopeFlags.DeclScope | Scope.ScopeFlags.ControlScope
             | Scope.ScopeFlags.SEHExceptScope);
      if ($this().getLangOpts().Borland) {
        $this().Ident__exception_info.setIsPoisoned(false);
        $this().Ident___exception_info.setIsPoisoned(false);
        $this().Ident_GetExceptionInfo.setIsPoisoned(false);
      }
      
      ActionResultTTrue<Expr /*P*/ > FilterExpr/*J*/= new ActionResultTTrue<Expr /*P*/ >();
      {
        ParseScopeFlags FilterScope = null;
        try {
          FilterScope/*J*/= new ParseScopeFlags($this(), $this().getCurScope().getFlags()
                 | Scope.ScopeFlags.SEHFilterScope);
          FilterExpr.$assignMove($this().Actions.CorrectDelayedTyposInExpr($this().ParseExpression()));
        } finally {
          if (FilterScope != null) { FilterScope.$destroy(); }
        }
      }
      if ($this().getLangOpts().Borland) {
        $this().Ident__exception_info.setIsPoisoned(true);
        $this().Ident___exception_info.setIsPoisoned(true);
        $this().Ident_GetExceptionInfo.setIsPoisoned(true);
      }
      if (FilterExpr.isInvalid()) {
        return StmtError();
      }
      if ($this().ExpectAndConsume(tok.TokenKind.r_paren)) {
        return StmtError();
      }
      if ($this().Tok.isNot(tok.TokenKind.l_brace)) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          return $c$.clean(StmtError($out_DiagnosticBuilder$C_TokenKind($c$.track($this().Diag($this().Tok, diag.err_expected)), tok.TokenKind.l_brace)));
        } finally {
          $c$.$destroy();
        }
      }
      
      ActionResultTTrue<Stmt /*P*/ > Block/*J*/= $this().ParseCompoundStatement();
      if (Block.isInvalid()) {
        return Block;
      }
      
      return $this().Actions.ActOnSEHExceptBlock(new SourceLocation(ExceptLoc), FilterExpr.get(), Block.get());
    } finally {
      if (ExpectScope != null) { ExpectScope.$destroy(); }
      if (raii3 != null) { raii3.$destroy(); }
      if (raii2 != null) { raii2.$destroy(); }
      if (raii != null) { raii.$destroy(); }
    }
  }


/// ParseSEHFinallyBlock - Handle __finally
///
/// seh-finally-block:
///   '__finally' compound-statement
///
//<editor-fold defaultstate="collapsed" desc="clang::Parser::ParseSEHFinallyBlock">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseStmt.cpp", line = 528,
   FQN="clang::Parser::ParseSEHFinallyBlock", NM="_ZN5clang6Parser20ParseSEHFinallyBlockENS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseStmt.cpp -nm=_ZN5clang6Parser20ParseSEHFinallyBlockENS_14SourceLocationE")
  //</editor-fold>
  protected /*private*/ ActionResultTTrue<Stmt /*P*/ > ParseSEHFinallyBlock(SourceLocation FinallyLoc) {
    PoisonIdentifierRAIIObject raii = null;
    PoisonIdentifierRAIIObject raii2 = null;
    PoisonIdentifierRAIIObject raii3 = null;
    ParseScope FinallyScope = null;
    try {
      raii/*J*/= new PoisonIdentifierRAIIObject($this().Ident__abnormal_termination, false); 
          raii2/*J*/= new PoisonIdentifierRAIIObject($this().Ident___abnormal_termination, false);
          raii3/*J*/= new PoisonIdentifierRAIIObject($this().Ident_AbnormalTermination, false);
      if ($this().Tok.isNot(tok.TokenKind.l_brace)) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          return $c$.clean(StmtError($out_DiagnosticBuilder$C_TokenKind($c$.track($this().Diag($this().Tok, diag.err_expected)), tok.TokenKind.l_brace)));
        } finally {
          $c$.$destroy();
        }
      }
      
      FinallyScope/*J*/= new ParseScope($this(), 0);
      $this().Actions.ActOnStartSEHFinallyBlock();
      
      ActionResultTTrue<Stmt /*P*/ > Block/*J*/= $this().ParseCompoundStatement();
      if (Block.isInvalid()) {
        $this().Actions.ActOnAbortSEHFinallyBlock();
        return Block;
      }
      
      return $this().Actions.ActOnFinishSEHFinallyBlock(new SourceLocation(FinallyLoc), Block.get());
    } finally {
      if (FinallyScope != null) { FinallyScope.$destroy(); }
      if (raii3 != null) { raii3.$destroy(); }
      if (raii2 != null) { raii2.$destroy(); }
      if (raii != null) { raii.$destroy(); }
    }
  }


/// Handle __leave
///
/// seh-leave-statement:
///   '__leave' ';'
///
//<editor-fold defaultstate="collapsed" desc="clang::Parser::ParseSEHLeaveStatement">
@Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseStmt.cpp", line = 553,
   FQN="clang::Parser::ParseSEHLeaveStatement", NM="_ZN5clang6Parser22ParseSEHLeaveStatementEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseStmt.cpp -nm=_ZN5clang6Parser22ParseSEHLeaveStatementEv")
  //</editor-fold>
  protected /*private*/ ActionResultTTrue<Stmt /*P*/ > ParseSEHLeaveStatement() {
    SourceLocation LeaveLoc = $this().ConsumeToken(); // eat the '__leave'.
    return $this().Actions.ActOnSEHLeaveStmt(new SourceLocation(LeaveLoc), $this().getCurScope());
  }

//<editor-fold defaultstate="collapsed" desc="clang::Parser::ParseFunctionStatementBody">
@Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseStmt.cpp", line = 1935,
   FQN="clang::Parser::ParseFunctionStatementBody", NM="_ZN5clang6Parser26ParseFunctionStatementBodyEPNS_4DeclERNS0_10ParseScopeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseStmt.cpp -nm=_ZN5clang6Parser26ParseFunctionStatementBodyEPNS_4DeclERNS0_10ParseScopeE")
  //</editor-fold>
  protected /*private*/ Decl /*P*/ ParseFunctionStatementBody(Decl /*P*/ Decl, final ParseScope /*&*/ BodyScope) {
    PrettyDeclStackTraceEntry CrashInfo = null;
    Sema.PragmaStackSentinelRAII PragmaStackSentinel = null;
    try {
      assert ($this().Tok.is(tok.TokenKind.l_brace));
      SourceLocation LBraceLoc = $this().Tok.getLocation();
      
      CrashInfo/*J*/= new PrettyDeclStackTraceEntry($this().Actions, Decl, new SourceLocation(LBraceLoc), 
          $("parsing function body"));
      
      // Save and reset current vtordisp stack if we have entered a C++ method body.
      boolean IsCXXMethod = $this().getLangOpts().CPlusPlus && $bool2uint_1bit((Decl != null)) && isa(CXXMethodDecl.class, Decl);
      PragmaStackSentinel/*J*/= new Sema.PragmaStackSentinelRAII($this().Actions, new StringRef(/*KEEP_STR*/"InternalPragmaState"), IsCXXMethod);
      
      // Do not enter a scope for the brace, as the arguments are in the same scope
      // (the function body) as the body itself.  Instead, just read the statement
      // list and put it into a CompoundStmt for safe keeping.
      ActionResultTTrue<Stmt /*P*/ > FnBody/*J*/= $this().ParseCompoundStatementBody();
      
      // If the function body could not be parsed, make a bogus compoundstmt.
      if (FnBody.isInvalid()) {
        Sema.CompoundScopeRAII CompoundScope = null;
        try {
          CompoundScope/*J*/= new Sema.CompoundScopeRAII($this().Actions);
          FnBody.$assignMove($this().Actions.ActOnCompoundStmt(new SourceLocation(LBraceLoc), new SourceLocation(LBraceLoc), new ArrayRef<Stmt /*P*/ >(None), false));
        } finally {
          if (CompoundScope != null) { CompoundScope.$destroy(); }
        }
      }
      
      BodyScope.Exit();
      return $this().Actions.ActOnFinishFunctionBody(Decl, FnBody.get());
    } finally {
      if (PragmaStackSentinel != null) { PragmaStackSentinel.$destroy(); }
      if (CrashInfo != null) { CrashInfo.$destroy(); }
    }
  }


/// ParseFunctionTryBlock - Parse a C++ function-try-block.
///
///       function-try-block:
///         'try' ctor-initializer[opt] compound-statement handler-seq
///
//<editor-fold defaultstate="collapsed" desc="clang::Parser::ParseFunctionTryBlock">
@Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseStmt.cpp", line = 1968,
   FQN="clang::Parser::ParseFunctionTryBlock", NM="_ZN5clang6Parser21ParseFunctionTryBlockEPNS_4DeclERNS0_10ParseScopeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseStmt.cpp -nm=_ZN5clang6Parser21ParseFunctionTryBlockEPNS_4DeclERNS0_10ParseScopeE")
  //</editor-fold>
  protected /*private*/ Decl /*P*/ ParseFunctionTryBlock(Decl /*P*/ Decl, final ParseScope /*&*/ BodyScope) {
    PrettyDeclStackTraceEntry CrashInfo = null;
    Sema.PragmaStackSentinelRAII PragmaStackSentinel = null;
    try {
      assert ($this().Tok.is(tok.TokenKind.kw_try)) : "Expected 'try'";
      SourceLocation TryLoc = $this().ConsumeToken();
      
      CrashInfo/*J*/= new PrettyDeclStackTraceEntry($this().Actions, Decl, new SourceLocation(TryLoc), 
          $("parsing function try block"));
      
      // Constructor initializer list?
      if ($this().Tok.is(tok.TokenKind.colon)) {
        $this().ParseConstructorInitializer(Decl);
      } else {
        $this().Actions.ActOnDefaultCtorInitializers(Decl);
      }
      
      // Save and reset current vtordisp stack if we have entered a C++ method body.
      boolean IsCXXMethod = $this().getLangOpts().CPlusPlus && $bool2uint_1bit((Decl != null)) && isa(CXXMethodDecl.class, Decl);
      PragmaStackSentinel/*J*/= new Sema.PragmaStackSentinelRAII($this().Actions, new StringRef(/*KEEP_STR*/"InternalPragmaState"), IsCXXMethod);
      
      SourceLocation LBraceLoc = $this().Tok.getLocation();
      ActionResultTTrue<Stmt /*P*/ > FnBody/*J*/= $this().ParseCXXTryBlockCommon(new SourceLocation(TryLoc), /*FnTry*/ true);
      // If we failed to parse the try-catch, we just give the function an empty
      // compound statement as the body.
      if (FnBody.isInvalid()) {
        Sema.CompoundScopeRAII CompoundScope = null;
        try {
          CompoundScope/*J*/= new Sema.CompoundScopeRAII($this().Actions);
          FnBody.$assignMove($this().Actions.ActOnCompoundStmt(new SourceLocation(LBraceLoc), new SourceLocation(LBraceLoc), new ArrayRef<Stmt /*P*/ >(None), false));
        } finally {
          if (CompoundScope != null) { CompoundScope.$destroy(); }
        }
      }
      
      BodyScope.Exit();
      return $this().Actions.ActOnFinishFunctionBody(Decl, FnBody.get());
    } finally {
      if (PragmaStackSentinel != null) { PragmaStackSentinel.$destroy(); }
      if (CrashInfo != null) { CrashInfo.$destroy(); }
    }
  }


/// \brief When in code-completion, skip parsing of the function/method body
/// unless the body contains the code-completion point.
///
/// \returns true if the function body was skipped.
//<editor-fold defaultstate="collapsed" desc="clang::Parser::trySkippingFunctionBody">
@Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseStmt.cpp", line = 2000,
   FQN="clang::Parser::trySkippingFunctionBody", NM="_ZN5clang6Parser23trySkippingFunctionBodyEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseStmt.cpp -nm=_ZN5clang6Parser23trySkippingFunctionBodyEv")
  //</editor-fold>
  protected /*private*/ boolean trySkippingFunctionBody() {
    TentativeParsingAction PA = null;
    try {
      assert ($this().SkipFunctionBodies) : "Should only be called when SkipFunctionBodies is enabled";
      if (!$this().PP.isCodeCompletionEnabled()) {
        $this().SkipFunctionBody();
        return true;
      }
      
      // We're in code-completion mode. Skip parsing for all function bodies unless
      // the body contains the code-completion point.
      PA/*J*/= new TentativeParsingAction(/*Deref*/$this());
      boolean IsTryCatch = $this().Tok.is(tok.TokenKind.kw_try);
      SmallVectorToken Toks/*J*/= new SmallVectorToken(4, /*new Token()*/(Token)null);
      boolean ErrorInPrologue = $this().ConsumeAndStoreFunctionPrologue(Toks);
      if (llvm.any_of(Toks,  (Tok) -> 
            {
              return Tok.is(tok.TokenKind.code_completion);
            }
  )) {
        PA.Revert();
        return false;
      }
      if (ErrorInPrologue) {
        PA.Commit();
        $this().SkipMalformedDecl();
        return true;
      }
      if (!$this().SkipUntil(tok.TokenKind.r_brace, SkipUntilFlags.StopAtCodeCompletion)) {
        PA.Revert();
        return false;
      }
      while (IsTryCatch && $this().Tok.is(tok.TokenKind.kw_catch)) {
        if (!$this().SkipUntil(tok.TokenKind.l_brace, SkipUntilFlags.StopAtCodeCompletion)
           || !$this().SkipUntil(tok.TokenKind.r_brace, SkipUntilFlags.StopAtCodeCompletion)) {
          PA.Revert();
          return false;
        }
      }
      PA.Commit();
      return true;
    } finally {
      if (PA != null) { PA.$destroy(); }
    }
  }


/// \brief Determine whether this is a C++1z for-range-identifier.
//<editor-fold defaultstate="collapsed" desc="clang::Parser::isForRangeIdentifier">
@Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseStmt.cpp", line = 1474,
   FQN="clang::Parser::isForRangeIdentifier", NM="_ZN5clang6Parser20isForRangeIdentifierEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseStmt.cpp -nm=_ZN5clang6Parser20isForRangeIdentifierEv")
  //</editor-fold>
  protected /*private*/ boolean isForRangeIdentifier() {
    assert ($this().Tok.is(tok.TokenKind.identifier));
    
    final /*const*/ Token /*&*/ Next = $this().NextToken();
    if (Next.is(tok.TokenKind.colon)) {
      return true;
    }
    if (Next.isOneOf(tok.TokenKind.l_square, tok.TokenKind.kw_alignas)) {
      TentativeParsingAction PA = null;
      try {
        PA/*J*/= new TentativeParsingAction(/*Deref*/$this());
        $this().ConsumeToken();
        $this().SkipCXX11Attributes();
        boolean Result = $this().Tok.is(tok.TokenKind.colon);
        PA.Revert();
        return Result;
      } finally {
        if (PA != null) { PA.$destroy(); }
      }
    }
    
    return false;
  }

/// \brief Parses opencl_unroll_hint attribute.
/// \return false if error happens.
//<editor-fold defaultstate="collapsed" desc="clang::Parser::ParseOpenCLUnrollHintAttribute">
@Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseStmt.cpp", line = 2240,
   FQN="clang::Parser::ParseOpenCLUnrollHintAttribute", NM="_ZN5clang6Parser30ParseOpenCLUnrollHintAttributeERNS_16ParsedAttributesE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseStmt.cpp -nm=_ZN5clang6Parser30ParseOpenCLUnrollHintAttributeERNS_16ParsedAttributesE")
  //</editor-fold>
  protected /*private*/ boolean ParseOpenCLUnrollHintAttribute(final ParsedAttributes /*&*/ Attrs) {
    $this().MaybeParseGNUAttributes(Attrs);
    if (Attrs.empty()) {
      return true;
    }
    if (Attrs.getList().getKind() != AttributeList.Kind.AT_OpenCLUnrollHint) {
      return true;
    }
    if (!($this().Tok.is(tok.TokenKind.kw_for) || $this().Tok.is(tok.TokenKind.kw_while) || $this().Tok.is(tok.TokenKind.kw_do))) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($c$.track($this().Diag($this().Tok, diag.err_opencl_unroll_hint_on_non_loop)));
        return false;
      } finally {
        $c$.$destroy();
      }
    }
    return true;
  }

} // END OF class Parser_ParseStmt
