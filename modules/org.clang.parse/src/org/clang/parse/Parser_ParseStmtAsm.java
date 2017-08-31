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

import org.llvm.support.target.Target;
import static org.clank.support.Native.$Deref;
import static org.clank.support.Native.$AddrOf;
import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import org.clank.support.JavaDifferentiators.*;
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
import org.clang.basic.target.TargetOptions;
import org.clang.lex.*;
import org.clang.lex.llvm.*;
import org.clang.sema.*;
import org.clang.parse.*;
import org.clang.parse.impl.*;
import static org.clang.parse.Parser.*;
import static org.clang.sema.SemaClangGlobals.*;
import static org.clang.parse.impl.ParseStmtAsmStatics.*;
import org.llvm.mc.*;
import org.llvm.mc.mcparser.*;
import org.llvm.support.target.TargetRegistry;


//<editor-fold defaultstate="collapsed" desc="static type Parser_ParseStmtAsm">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -empty-body -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType -split-class=clang::Parser@this -extends=Parser_ParseStmt ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseStmtAsm.cpp -nm=_ZN5clang6Parser17ParseAsmStatementERb;_ZN5clang6Parser19ParseAsmOperandsOptERN4llvm15SmallVectorImplIPNS_14IdentifierInfoEEERNS2_IPNS_4ExprEEESA_;_ZN5clang6Parser20ParseMSAsmIdentifierERN4llvm15SmallVectorImplINS_5TokenEEERjPvb;_ZN5clang6Parser26ParseMicrosoftAsmStatementENS_14SourceLocationE; -static-type=Parser_ParseStmtAsm -package=org.clang.parse")
//</editor-fold>
public class Parser_ParseStmtAsm extends Parser_ParseStmt {
private final /*split clang::Parser*/ Parser $this() { return (Parser)this; }


/// Parse an identifier in an MS-style inline assembly block.
///
/// \param CastInfo - a void* so that we don't have to teach Parser.h
///   about the actual type.
//<editor-fold defaultstate="collapsed" desc="clang::Parser::ParseMSAsmIdentifier">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseStmtAsm.cpp", line = 184,
   FQN="clang::Parser::ParseMSAsmIdentifier", NM="_ZN5clang6Parser20ParseMSAsmIdentifierERN4llvm15SmallVectorImplINS_5TokenEEERjPvb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseStmtAsm.cpp -nm=_ZN5clang6Parser20ParseMSAsmIdentifierERN4llvm15SmallVectorImplINS_5TokenEEERjPvb")
  //</editor-fold>
  public ActionResultTTrue<Expr /*P*/ > ParseMSAsmIdentifier(final SmallVectorToken/*&*/ LineToks, 
                      final uint$ref/*uint &*/ NumLineToksConsumed, 
                      Object/*void P*/ CastInfo, 
                      boolean IsUnevaluatedContext) {
    CXXScopeSpec SS = null;
    try {
      final InlineAsmIdentifierInfo /*&*/ Info = /*Deref*/(InlineAsmIdentifierInfo /*P*/ )CastInfo;
      
      // Push a fake token on the end so that we don't overrun the token
      // stream.  We use ';' because it expression-parsing should never
      // overrun it.
      /*tok.TokenKind*/char EndOfStream = tok.TokenKind.semi;
      Token EndOfStreamTok/*J*/= new Token();
      EndOfStreamTok.startToken();
      EndOfStreamTok.setKind(EndOfStream);
      LineToks.push_back(EndOfStreamTok);
      
      // Also copy the current token over.
      LineToks.push_back($this().Tok);
      
      $this().PP.EnterTokenStream(new ArrayRefToken(LineToks), /*DisableMacroExpansions*/ true);
      
      // Clear the current token and advance to the first token in LineToks.
      $this().ConsumeAnyToken();
      
      // Parse an optional scope-specifier if we're in C++.
      SS/*J*/= new CXXScopeSpec();
      if ($this().getLangOpts().CPlusPlus) {
        $this().ParseOptionalCXXScopeSpecifier(SS, new OpaquePtr<QualType>(null), /*EnteringContext=*/ false);
      }
      
      // Require an identifier here.
      SourceLocation TemplateKWLoc/*J*/= new SourceLocation();
      UnqualifiedId Id/*J*/= new UnqualifiedId();
      boolean Invalid = true;
      ActionResultTTrue<Expr /*P*/ > Result/*J*/= new ActionResultTTrue<Expr /*P*/ >();
      if ($this().Tok.is(tok.TokenKind.kw_this)) {
        Result.$assignMove($this().ParseCXXThis());
        Invalid = false;
      } else {
        Invalid = $this().ParseUnqualifiedId(SS, 
            /*EnteringContext=*/ false, 
            /*AllowDestructorName=*/ false, 
            /*AllowConstructorName=*/ false, 
            /*ObjectType=*/ new OpaquePtr<QualType>(null), TemplateKWLoc, Id);
        // Perform the lookup.
        Result.$assignMove($this().Actions.LookupInlineAsmIdentifier(SS, new SourceLocation(TemplateKWLoc), Id, Info, 
                IsUnevaluatedContext));
      }
      // While the next two tokens are 'period' 'identifier', repeatedly parse it as
      // a field access. We have to avoid consuming assembler directives that look
      // like '.' 'else'.
      while (Result.isUsable() && $this().Tok.is(tok.TokenKind.period)) {
        Token IdTok = new Token($this().PP.LookAhead(0));
        if (IdTok.isNot(tok.TokenKind.identifier)) {
          break;
        }
        $this().ConsumeToken(); // Consume the period.
        IdentifierInfo /*P*/ _Id = $this().Tok.getIdentifierInfo();
        $this().ConsumeToken(); // Consume the identifier.
        Result.$assignMove($this().Actions.LookupInlineAsmVarDeclField(Result.get(), _Id.getName(), 
                Info, $this().Tok.getLocation()));
      }
      
      // Figure out how many tokens we are into LineToks.
      /*uint*/int LineIndex = 0;
      if ($this().Tok.is(EndOfStream)) {
        LineIndex = LineToks.size() - 2;
      } else {
        while ($noteq_SourceLocation$C(LineToks.$at(LineIndex).getLocation(), $this().Tok.getLocation())) {
          LineIndex++;
          assert ($less_uint(LineIndex, LineToks.size() - 2)); // we added two extra tokens
        }
      }
      
      // If we've run into the poison token we inserted before, or there
      // was a parsing error, then claim the entire line.
      if (Invalid || $this().Tok.is(EndOfStream)) {
        NumLineToksConsumed.$set(LineToks.size() - 2);
      } else {
        // Otherwise, claim up to the start of the next token.
        NumLineToksConsumed.$set(LineIndex);
      }
      
      // Finally, restore the old parsing state by consuming all the tokens we
      // staged before, implicitly killing off the token-lexer we pushed.
      for (/*uint*/int i = 0, e = LineToks.size() - LineIndex - 2; i != e; ++i) {
        $this().ConsumeAnyToken();
      }
      assert ($this().Tok.is(EndOfStream));
      $this().ConsumeToken();
      
      // Leave LineToks in its original state.
      LineToks.pop_back();
      LineToks.pop_back();
      
      return Result;
    } finally {
      if (SS != null) { SS.$destroy(); }
    }
  }


/// ParseAsmStatement - Parse a GNU extended asm statement.
///       asm-statement:
///         gnu-asm-statement
///         ms-asm-statement
///
/// [GNU] gnu-asm-statement:
///         'asm' type-qualifier[opt] '(' asm-argument ')' ';'
///
/// [GNU] asm-argument:
///         asm-string-literal
///         asm-string-literal ':' asm-operands[opt]
///         asm-string-literal ':' asm-operands[opt] ':' asm-operands[opt]
///         asm-string-literal ':' asm-operands[opt] ':' asm-operands[opt]
///                 ':' asm-clobbers
///
/// [GNU] asm-clobbers:
///         asm-string-literal
///         asm-clobbers ',' asm-string-literal
///
//<editor-fold defaultstate="collapsed" desc="clang::Parser::ParseAsmStatement">
@Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseStmtAsm.cpp", line = 669,
   FQN="clang::Parser::ParseAsmStatement", NM="_ZN5clang6Parser17ParseAsmStatementERb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseStmtAsm.cpp -nm=_ZN5clang6Parser17ParseAsmStatementERb")
  //</editor-fold>
  protected /*private*/ ActionResultTTrue<Stmt /*P*/ > ParseAsmStatement(final bool$ref/*bool &*/ msAsm) {
    DeclSpec DS = null;
    BalancedDelimiterTracker T = null;
    try {
      assert ($this().Tok.is(tok.TokenKind.kw_asm)) : "Not an asm stmt";
      SourceLocation AsmLoc = $this().ConsumeToken();
      if ($this().getLangOpts().AsmBlocks && !isGCCAsmStatement($this().Tok)) {
        msAsm.$set(true);
        return $this().ParseMicrosoftAsmStatement(new SourceLocation(AsmLoc));
      }
      
      DS/*J*/= new DeclSpec($this().AttrFactory);
      SourceLocation Loc = $this().Tok.getLocation();
      $this().ParseTypeQualifierListOpt(DS, AttrRequirements.AR_VendorAttributesParsed);
      
      // GNU asms accept, but warn, about type-qualifiers other than volatile.
      if (((DS.getTypeQualifiers() & DeclSpec.TQ.TQ_const.getValue()) != 0)) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_DiagnosticBuilder$C_char$ptr$C($c$.track($this().Diag(new SourceLocation(Loc), diag.w_asm_qualifier_ignored)), /*KEEP_STR*/$const));
        } finally {
          $c$.$destroy();
        }
      }
      if (((DS.getTypeQualifiers() & DeclSpec.TQ.TQ_restrict.getValue()) != 0)) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_DiagnosticBuilder$C_char$ptr$C($c$.track($this().Diag(new SourceLocation(Loc), diag.w_asm_qualifier_ignored)), /*KEEP_STR*/$restrict));
        } finally {
          $c$.$destroy();
        }
      }
      // FIXME: Once GCC supports _Atomic, check whether it permits it here.
      if (((DS.getTypeQualifiers() & DeclSpec.TQ.TQ_atomic.getValue()) != 0)) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_DiagnosticBuilder$C_char$ptr$C($c$.track($this().Diag(new SourceLocation(Loc), diag.w_asm_qualifier_ignored)), /*KEEP_STR*/$_Atomic));
        } finally {
          $c$.$destroy();
        }
      }
      
      // Remember if this was a volatile asm.
      boolean isVolatile = ((DS.getTypeQualifiers() & DeclSpec.TQ.TQ_volatile.getValue()) != 0);
      
      // TODO: support "asm goto" constructs (PR#9295).
      if ($this().Tok.is(tok.TokenKind.kw_goto)) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($c$.track($this().Diag($this().Tok, diag.err_asm_goto_not_supported_yet)));
          $this().SkipUntil(tok.TokenKind.r_paren, SkipUntilFlags.StopAtSemi);
          return StmtError();
        } finally {
          $c$.$destroy();
        }
      }
      if ($this().Tok.isNot(tok.TokenKind.l_paren)) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_DiagnosticBuilder$C_char$ptr$C($c$.track($this().Diag($this().Tok, diag.err_expected_lparen_after)), /*KEEP_STR*/$asm));
          $this().SkipUntil(tok.TokenKind.r_paren, SkipUntilFlags.StopAtSemi);
          return StmtError();
        } finally {
          $c$.$destroy();
        }
      }
      T/*J*/= new BalancedDelimiterTracker(/*Deref*/$this(), tok.TokenKind.l_paren);
      T.consumeOpen();
      
      ActionResultTTrue<Expr /*P*/ > AsmString/*J*/= $this().ParseAsmStringLiteral();
      
      // Check if GNU-style InlineAsm is disabled.
      // Error on anything other than empty string.
      if (!($this().getLangOpts().GNUAsm || AsmString.isInvalid())) {
        /*const*/ StringLiteral /*P*/ SL = cast(StringLiteral.class, AsmString.get());
        if (!SL.getString().trim().empty()) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            $c$.clean($c$.track($this().Diag(new SourceLocation(Loc), diag.err_gnu_inline_asm_disabled)));
          } finally {
            $c$.$destroy();
          }
        }
      }
      if (AsmString.isInvalid()) {
        // Consume up to and including the closing paren.
        T.skipToEnd();
        return StmtError();
      }
      
      SmallVector<IdentifierInfo /*P*/> Names/*J*/= new SmallVector<IdentifierInfo /*P*/>(4, (IdentifierInfo /*P*/)null);
      SmallVector<Expr /*P*/ > Constraints/*J*/= new SmallVector<Expr /*P*/ >(12, (Expr /*P*/ )null);
      SmallVector<Expr /*P*/ > Exprs/*J*/= new SmallVector<Expr /*P*/ >(12, (Expr /*P*/ )null);
      SmallVector<Expr /*P*/ > Clobbers/*J*/= new SmallVector<Expr /*P*/ >(12, (Expr /*P*/ )null);
      if ($this().Tok.is(tok.TokenKind.r_paren)) {
        // We have a simple asm expression like 'asm("foo")'.
        T.consumeClose();
        return $this().Actions.ActOnGCCAsmStmt(new SourceLocation(AsmLoc), /*isSimple*/ true, isVolatile, 
            /*NumOutputs*/ 0, /*NumInputs*/ 0, create_type$null$ptr(), 
            new MutableArrayRef<Expr /*P*/ >(Constraints), new MutableArrayRef<Expr /*P*/ >(Exprs), AsmString.get(), 
            new MutableArrayRef<Expr /*P*/ >(Clobbers), T.getCloseLocation());
      }
      
      // Parse Outputs, if present.
      boolean AteExtraColon = false;
      if ($this().Tok.is(tok.TokenKind.colon) || $this().Tok.is(tok.TokenKind.coloncolon)) {
        // In C++ mode, parse "::" like ": :".
        AteExtraColon = $this().Tok.is(tok.TokenKind.coloncolon);
        $this().ConsumeToken();
        if (!AteExtraColon && $this().ParseAsmOperandsOpt(Names, Constraints, Exprs)) {
          return StmtError();
        }
      }
      
      /*uint*/int NumOutputs = Names.size();
      
      // Parse Inputs, if present.
      if (AteExtraColon || $this().Tok.is(tok.TokenKind.colon) || $this().Tok.is(tok.TokenKind.coloncolon)) {
        // In C++ mode, parse "::" like ": :".
        if (AteExtraColon) {
          AteExtraColon = false;
        } else {
          AteExtraColon = $this().Tok.is(tok.TokenKind.coloncolon);
          $this().ConsumeToken();
        }
        if (!AteExtraColon && $this().ParseAsmOperandsOpt(Names, Constraints, Exprs)) {
          return StmtError();
        }
      }
      assert (Names.size() == Constraints.size() && Constraints.size() == Exprs.size()) : "Input operand size mismatch!";
      
      /*uint*/int NumInputs = Names.size() - NumOutputs;
      
      // Parse the clobbers, if present.
      if (AteExtraColon || $this().Tok.is(tok.TokenKind.colon)) {
        if (!AteExtraColon) {
          $this().ConsumeToken();
        }
        
        // Parse the asm-string list for clobbers if present.
        if ($this().Tok.isNot(tok.TokenKind.r_paren)) {
          while (true) {
            ActionResultTTrue<Expr /*P*/ > Clobber/*J*/= $this().ParseAsmStringLiteral();
            if (Clobber.isInvalid()) {
              break;
            }
            
            Clobbers.push_back(Clobber.get());
            if (!$this().TryConsumeToken(tok.TokenKind.comma)) {
              break;
            }
          }
        }
      }
      
      T.consumeClose();
      return $this().Actions.ActOnGCCAsmStmt(new SourceLocation(AsmLoc), false, isVolatile, NumOutputs, NumInputs, Names.data(), 
          new MutableArrayRef<Expr /*P*/ >(Constraints), new MutableArrayRef<Expr /*P*/ >(Exprs), AsmString.get(), new MutableArrayRef<Expr /*P*/ >(Clobbers), T.getCloseLocation());
    } finally {
      if (T != null) { T.$destroy(); }
      if (DS != null) { DS.$destroy(); }
    }
  }


/// ParseMicrosoftAsmStatement. When -fms-extensions/-fasm-blocks is enabled,
/// this routine is called to collect the tokens for an MS asm statement.
///
/// [MS]  ms-asm-statement:
///         ms-asm-block
///         ms-asm-block ms-asm-statement
///
/// [MS]  ms-asm-block:
///         '__asm' ms-asm-line '\n'
///         '__asm' '{' ms-asm-instruction-block[opt] '}' ';'[opt]
///
/// [MS]  ms-asm-instruction-block
///         ms-asm-line
///         ms-asm-line '\n' ms-asm-instruction-block
///
//<editor-fold defaultstate="collapsed" desc="clang::Parser::ParseMicrosoftAsmStatement">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseStmtAsm.cpp", line = 380,
   FQN="clang::Parser::ParseMicrosoftAsmStatement", NM="_ZN5clang6Parser26ParseMicrosoftAsmStatementENS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseStmtAsm.cpp -nm=_ZN5clang6Parser26ParseMicrosoftAsmStatementENS_14SourceLocationE")
  //</editor-fold>
  protected /*private*/ ActionResultTTrue<Stmt /*P*/ > ParseMicrosoftAsmStatement(SourceLocation AsmLoc) {
    std.unique_ptr<MCRegisterInfo> MRI = null;
    std.unique_ptr<MCAsmInfo> MAI = null;
    std.unique_ptr<MCInstrInfo> MII = null;
    std.unique_ptr<MCObjectFileInfo> MOFI = null;
    std.unique_ptr<MCSubtargetInfo> STI = null;
    SourceMgr TempSrcMgr = null;
    MCContext Ctx = null;
    std.unique_ptr<MemoryBuffer> Buffer = null;
    std.unique_ptr<MCStreamer> Str = null;
    std.unique_ptr<MCAsmParser> Parser = null;
    MCTargetOptions MCOptions = null;
    std.unique_ptr<MCTargetAsmParser> TargetParser = null;
    std.unique_ptr<MCInstPrinter> IP = null;
    ClangAsmParserCallback Callback = null;
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      final SourceManager /*&*/ SrcMgr = $this().PP.getSourceManager();
      SourceLocation EndLoc = new SourceLocation(AsmLoc);
      SmallVectorToken AsmToks/*J*/= new SmallVectorToken(4, /*new Token()*/(Token)null);
      
      boolean SingleLineMode = true;
      /*uint*/int BraceNesting = 0;
      /*ushort*/char savedBraceCount = $this().BraceCount;
      boolean InAsmComment = false;
      FileID FID/*J*/= new FileID();
      /*uint*/int LineNo = 0;
      /*uint*/int NumTokensRead = 0;
      SmallVector<SourceLocation> LBraceLocs/*J*/= new SmallVector<SourceLocation>(4, new SourceLocation());
      boolean SkippedStartOfLine = false;
      if ($this().Tok.is(tok.TokenKind.l_brace)) {
        // Braced inline asm: consume the opening brace.
        SingleLineMode = false;
        BraceNesting = 1;
        EndLoc.$assignMove($this().ConsumeBrace());
        LBraceLocs.push_back(EndLoc);
        ++NumTokensRead;
      } else {
        // Single-line inline asm; compute which line it is on.
        std.pairTypeUInt<FileID> ExpAsmLoc = SrcMgr.getDecomposedExpansionLoc(/*NO_COPY*/EndLoc);
        FID.$assign(ExpAsmLoc.first);
        LineNo = SrcMgr.getLineNumber(/*NO_COPY*/FID, ExpAsmLoc.second);
        LBraceLocs.push_back(new SourceLocation());
      }
      
      SourceLocation TokLoc = $this().Tok.getLocation();
      do {
        // If we hit EOF, we're done, period.
        if ($this().isEofOrEom()) {
          break;
        }
        if (!InAsmComment && $this().Tok.is(tok.TokenKind.l_brace)) {
          // Consume the opening brace.
          SkippedStartOfLine = $this().Tok.isAtStartOfLine();
          AsmToks.push_back($this().Tok);
          EndLoc.$assignMove($this().ConsumeBrace());
          BraceNesting++;
          LBraceLocs.push_back(EndLoc);
          TokLoc.$assignMove($this().Tok.getLocation());
          ++NumTokensRead;
          continue;
        } else if (!InAsmComment && $this().Tok.is(tok.TokenKind.semi)) {
          // A semicolon in an asm is the start of a comment.
          InAsmComment = true;
          if (!SingleLineMode) {
            // Compute which line the comment is on.
            std.pairTypeUInt<FileID> ExpSemiLoc = SrcMgr.getDecomposedExpansionLoc(/*NO_COPY*/TokLoc);
            FID.$assign(ExpSemiLoc.first);
            LineNo = SrcMgr.getLineNumber(/*NO_COPY*/FID, ExpSemiLoc.second);
          }
        } else if (SingleLineMode || InAsmComment) {
          // If end-of-line is significant, check whether this token is on a
          // new line.
          std.pairTypeUInt<FileID> ExpLoc = SrcMgr.getDecomposedExpansionLoc(/*NO_COPY*/TokLoc);
          if (ExpLoc.first.$noteq(FID)
             || SrcMgr.getLineNumber(/*NO_COPY*/ExpLoc.first, ExpLoc.second) != LineNo) {
            // If this is a single-line __asm, we're done, except if the next
            // line is MS-style asm too, in which case we finish a comment
            // if needed and then keep processing the next line as a single
            // line __asm.
            boolean isAsm = $this().Tok.is(tok.TokenKind.kw_asm);
            if (SingleLineMode && (!isAsm || isGCCAsmStatement($this().NextToken()))) {
              break;
            }
            // We're no longer in a comment.
            InAsmComment = false;
            if (isAsm) {
              // If this is a new __asm {} block we want to process it seperately
              // from the single-line __asm statements
              if ($this().PP.LookAhead(0).is(tok.TokenKind.l_brace)) {
                break;
              }
              LineNo = SrcMgr.getLineNumber(/*NO_COPY*/ExpLoc.first, ExpLoc.second);
              SkippedStartOfLine = $this().Tok.isAtStartOfLine();
            }
          } else if (!InAsmComment && $this().Tok.is(tok.TokenKind.r_brace)) {
            // In MSVC mode, braces only participate in brace matching and
            // separating the asm statements.  This is an intentional
            // departure from the Apple gcc behavior.
            if (!(BraceNesting != 0)) {
              break;
            }
          }
        }
        if (!InAsmComment && (BraceNesting != 0) && $this().Tok.is(tok.TokenKind.r_brace)
           && $ushort2uint($this().BraceCount) == ($ushort2uint(savedBraceCount) + BraceNesting)) {
          // Consume the closing brace.
          SkippedStartOfLine = $this().Tok.isAtStartOfLine();
          // Don't want to add the closing brace of the whole asm block
          if (SingleLineMode || $greater_uint(BraceNesting, 1)) {
            $this().Tok.clearFlag(Token.TokenFlags.LeadingSpace);
            AsmToks.push_back($this().Tok);
          }
          EndLoc.$assignMove($this().ConsumeBrace());
          BraceNesting--;
          // Finish if all of the opened braces in the inline asm section were
          // consumed.
          if (BraceNesting == 0 && !SingleLineMode) {
            break;
          } else {
            LBraceLocs.pop_back();
            TokLoc.$assignMove($this().Tok.getLocation());
            ++NumTokensRead;
            continue;
          }
        }
        
        // Consume the next token; make sure we don't modify the brace count etc.
        // if we are in a comment.
        EndLoc.$assign(TokLoc);
        if (InAsmComment) {
          $this().PP.Lex($this().Tok);
        } else {
          // Set the token as the start of line if we skipped the original start
          // of line token in case it was a nested brace.
          if (SkippedStartOfLine) {
            $this().Tok.setFlag(Token.TokenFlags.StartOfLine);
          }
          AsmToks.push_back($this().Tok);
          $this().ConsumeAnyToken();
        }
        TokLoc.$assignMove($this().Tok.getLocation());
        ++NumTokensRead;
        SkippedStartOfLine = false;
      } while (true);
      if ((BraceNesting != 0) && $ushort2int($this().BraceCount) != $ushort2int(savedBraceCount)) {
        // __asm without closing brace (this can happen at EOF).
        for (/*uint*/int i = 0; $less_uint(i, BraceNesting); ++i) {
          $c$.clean($out_DiagnosticBuilder$C_TokenKind($c$.track($this().Diag($this().Tok, diag.err_expected)), tok.TokenKind.r_brace));
          $c$.clean($out_DiagnosticBuilder$C_TokenKind($c$.track($this().Diag(new SourceLocation(LBraceLocs.back()), diag.note_matching)), tok.TokenKind.l_brace));
          LBraceLocs.pop_back();
        }
        return StmtError();
      } else if (NumTokensRead == 0) {
        // Empty __asm.
        $c$.clean($out_DiagnosticBuilder$C_TokenKind($c$.track($this().Diag($this().Tok, diag.err_expected)), tok.TokenKind.l_brace));
        return StmtError();
      }
      
      // Okay, prepare to use MC to parse the assembly.
      SmallVector<StringRef> ConstraintRefs/*J*/= new SmallVector<StringRef>(4, new StringRef());
      SmallVector<Expr /*P*/ > Exprs/*J*/= new SmallVector<Expr /*P*/ >(4, (Expr /*P*/ )null);
      SmallVector<StringRef> ClobberRefs/*J*/= new SmallVector<StringRef>(4, new StringRef());
      
      // We need an actual supported target.
      final /*const*/ Triple /*&*/ TheTriple = $this().Actions.Context.getTargetInfo().getTriple();
      Triple.ArchType ArchTy = TheTriple.getArch();
      final /*const*/std.string/*&*/ TT = TheTriple.getTriple();
      /*const*/ Target /*P*/ TheTarget = null;
      boolean UnsupportedArch = (ArchTy != Triple.ArchType.x86 && ArchTy != Triple.ArchType.x86_64);
      if (UnsupportedArch) {
        $c$.clean($out_DiagnosticBuilder$C_StringRef($c$.track($this().Diag(new SourceLocation(AsmLoc), diag.err_msasm_unsupported_arch)), TheTriple.getArchName()));
      } else {
        std.string Error/*J*/= new std.string();
        TheTarget = TargetRegistry.lookupTarget(TT, Error);
        if (!(TheTarget != null)) {
          $c$.clean($out_DiagnosticBuilder$C_StringRef($c$.track($this().Diag(new SourceLocation(AsmLoc), diag.err_msasm_unable_to_create_target)), new StringRef(Error)));
        }
      }
      assert (!LBraceLocs.empty()) : "Should have at least one location here";
      
      // If we don't support assembly, or the assembly is empty, we don't
      // need to instantiate the AsmParser, etc.
      if (!(TheTarget != null) || AsmToks.empty()) {
        return $this().Actions.ActOnMSAsmStmt(new SourceLocation(AsmLoc), new SourceLocation(LBraceLocs.$at(0)), new ArrayRefToken(AsmToks), new StringRef(), 
            /*NumOutputs*/ 0, /*NumInputs*/ 0, 
            new ArrayRef<StringRef>(ConstraintRefs), new ArrayRef<StringRef>(ClobberRefs), new ArrayRef<Expr /*P*/ >(Exprs), new SourceLocation(EndLoc));
      }
      
      // Expand the tokens into a string buffer.
      SmallString/*512*/ AsmString/*J*/= new SmallString/*512*/(512);
      SmallVectorUInt TokOffsets/*J*/= new SmallVectorUInt(8, 0);
      if (buildMSAsmString($this().PP, new SourceLocation(AsmLoc), new ArrayRefToken(AsmToks), TokOffsets, AsmString)) {
        return StmtError();
      }
      
      TargetOptions TO = new TargetOptions($this().Actions.Context.getTargetInfo().getTargetOpts());
      std.string FeaturesStr = llvm.join(TO.Features.begin(), TO.Features.end(), new StringRef(/*KEEP_STR*/$COMMA));
      
      MRI/*J*/= new std.unique_ptr<MCRegisterInfo>(TheTarget.createMCRegInfo(new StringRef(TT)));
      MAI/*J*/= new std.unique_ptr<MCAsmInfo>(TheTarget.createMCAsmInfo(MRI.$star(), new StringRef(TT)));
      // Get the instruction descriptor.
      MII/*J*/= new std.unique_ptr<MCInstrInfo>(TheTarget.createMCInstrInfo());
      MOFI/*J*/= new std.unique_ptr<MCObjectFileInfo>(new MCObjectFileInfo());
      STI/*J*/= new std.unique_ptr<MCSubtargetInfo>(TheTarget.createMCSubtargetInfo(new StringRef(TT), new StringRef(TO.CPU), new StringRef(FeaturesStr)));
      
      TempSrcMgr/*J*/= new SourceMgr();
      Ctx/*J*/= new MCContext(MAI.get(), MRI.get(), MOFI.get(), $AddrOf(TempSrcMgr));
      MOFI.$arrow().InitMCObjectFileInfo(TheTriple, /*PIC*/ false, CodeModel.Model.Default, 
          Ctx);
      Buffer = MemoryBuffer.getMemBuffer(AsmString.$StringRef(), new StringRef(/*KEEP_STR*/"<MS inline asm>"));
      
      // Tell SrcMgr about this buffer, which is what the parser will pick up.
      $c$.clean(TempSrcMgr.AddNewSourceBuffer($c$.track(new std.unique_ptr<MemoryBuffer>(JD$Move.INSTANCE, std.move(Buffer))), new SMLoc()));
      
      Str/*J*/= new std.unique_ptr<MCStreamer>(createNullStreamer(Ctx));
      Parser/*J*/= new std.unique_ptr<MCAsmParser>(createMCAsmParser(TempSrcMgr, Ctx, $Deref(Str.get()), MAI.$star()));
      
      // FIXME: init MCOptions from sanitizer flags here.
      MCOptions/*J*/= new MCTargetOptions();
      TargetParser/*J*/= new std.unique_ptr<MCTargetAsmParser>(TheTarget.createMCAsmParser(STI.$star(), Parser.$star(), MII.$star(), MCOptions));
      
      IP/*J*/= new std.unique_ptr<MCInstPrinter>(TheTarget.createMCInstPrinter(new Triple(new Twine(TT)), 1, MAI.$star(), MII.$star(), MRI.$star()));
      
      // Change to the Intel dialect.
      Parser.$arrow().setAssemblerDialect(1);
      Parser.$arrow().setTargetParser($Deref(TargetParser.get()));
      Parser.$arrow().setParsingInlineAsm(true);
      TargetParser.$arrow().setParsingInlineAsm(true);
      
      Callback/*J*/= new ClangAsmParserCallback(/*Deref*/$this(), new SourceLocation(AsmLoc), AsmString.$StringRef(), new ArrayRefToken(AsmToks), 
          new ArrayRefUInt(TokOffsets));
      TargetParser.$arrow().setSemaCallback($AddrOf(Callback));
      TempSrcMgr.setDiagHandler(/*FunRef*/ClangAsmParserCallback::DiagHandlerCallback, 
          $AddrOf(Callback));
      
      /*uint*/uint$ref NumOutputs = create_uint$ref();
      /*uint*/uint$ref NumInputs = create_uint$ref();
      std.string AsmStringIR/*J*/= new std.string();
      SmallVector<std.pairTypeBool<Object/*void P*/>> OpExprs/*J*/= new SmallVector<std.pairTypeBool<Object/*void P*/>>(4, new std.pairPtrBool<Object/*void P*/>());
      SmallVector<std.string> Constraints/*J*/= new SmallVector<std.string>(4, new std.string());
      SmallVector<std.string> Clobbers/*J*/= new SmallVector<std.string>(4, new std.string());
      if (Parser.$arrow().parseMSInlineAsm(AsmLoc.getPtrEncoding(), AsmStringIR, NumOutputs, 
          NumInputs, OpExprs, Constraints, Clobbers, 
          MII.get(), IP.get(), Callback)) {
        return StmtError();
      }
      
      // Filter out "fpsw".  Clang doesn't accept it, and it always lists flags and
      // fpsr as clobbers.
      type$ptr<std.string> /*P*/ End = std.remove(Clobbers.begin(), Clobbers.end(), new std.string("fpsw"));
      Clobbers.erase(End, Clobbers.end());
      
      // Build the vector of clobber StringRefs.
      ClobberRefs.insert(ClobberRefs.end(), /*FIX_CAST*/(type$iterator<?, StringRef>)(Object)Clobbers.begin(), /*FIX_CAST*/(type$iterator<?, StringRef>)(Object)Clobbers.end());
      
      // Recast the void pointers and build the vector of constraint StringRefs.
      /*uint*/int NumExprs = NumOutputs.$deref() + NumInputs.$deref();
      ConstraintRefs.resize(NumExprs);
      Exprs.resize(NumExprs);
      for (/*uint*/int i = 0, e = NumExprs; i != e; ++i) {
        Expr /*P*/ OpExpr = ((/*static_cast*/Expr /*P*/ )(OpExprs.$at(i).first));
        if (!(OpExpr != null)) {
          return StmtError();
        }
        
        // Need address of variable.
        if (OpExprs.$at(i).second) {
          OpExpr
             = $this().Actions.BuildUnaryOp($this().getCurScope(), new SourceLocation(AsmLoc), UnaryOperatorKind.UO_AddrOf, OpExpr).get();
        }
        
        ConstraintRefs.$at(i).$assignMove(new StringRef(Constraints.$at(i)));
        Exprs.$set(i, OpExpr);
      }
      
      // FIXME: We should be passing source locations for better diagnostics.
      return $this().Actions.ActOnMSAsmStmt(new SourceLocation(AsmLoc), new SourceLocation(LBraceLocs.$at(0)), new ArrayRefToken(AsmToks), new StringRef(AsmStringIR), 
          NumOutputs.$deref(), NumInputs.$deref(), new ArrayRef<StringRef>(ConstraintRefs), 
          new ArrayRef<StringRef>(ClobberRefs), new ArrayRef<Expr /*P*/ >(Exprs), new SourceLocation(EndLoc));
    } finally {
      if (Callback != null) { Callback.$destroy(); }
      if (IP != null) { IP.$destroy(); }
      if (TargetParser != null) { TargetParser.$destroy(); }
      if (MCOptions != null) { MCOptions.$destroy(); }
      if (Parser != null) { Parser.$destroy(); }
      if (Str != null) { Str.$destroy(); }
      if (Buffer != null) { Buffer.$destroy(); }
      if (Ctx != null) { Ctx.$destroy(); }
      if (TempSrcMgr != null) { TempSrcMgr.$destroy(); }
      if (STI != null) { STI.$destroy(); }
      if (MOFI != null) { MOFI.$destroy(); }
      if (MII != null) { MII.$destroy(); }
      if (MAI != null) { MAI.$destroy(); }
      if (MRI != null) { MRI.$destroy(); }
      $c$.$destroy();
    }
  }


/// ParseAsmOperands - Parse the asm-operands production as used by
/// asm-statement, assuming the leading ':' token was eaten.
///
/// [GNU] asm-operands:
///         asm-operand
///         asm-operands ',' asm-operand
///
/// [GNU] asm-operand:
///         asm-string-literal '(' expression ')'
///         '[' identifier ']' asm-string-literal '(' expression ')'
///
//
// FIXME: Avoid unnecessary std::string trashing.
//<editor-fold defaultstate="collapsed" desc="clang::Parser::ParseAsmOperandsOpt">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseStmtAsm.cpp", line = 811,
   FQN="clang::Parser::ParseAsmOperandsOpt", NM="_ZN5clang6Parser19ParseAsmOperandsOptERN4llvm15SmallVectorImplIPNS_14IdentifierInfoEEERNS2_IPNS_4ExprEEESA_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseStmtAsm.cpp -nm=_ZN5clang6Parser19ParseAsmOperandsOptERN4llvm15SmallVectorImplIPNS_14IdentifierInfoEEERNS2_IPNS_4ExprEEESA_")
  //</editor-fold>
  protected /*private*/ boolean ParseAsmOperandsOpt(final SmallVectorImpl<IdentifierInfo /*P*/ > /*&*/ Names, 
                     final SmallVectorImpl<Expr /*P*/ > /*&*/ Constraints, 
                     final SmallVectorImpl<Expr /*P*/ > /*&*/ Exprs) {
    // 'asm-operands' isn't present?
    if (!$this().isTokenStringLiteral() && $this().Tok.isNot(tok.TokenKind.l_square)) {
      return false;
    }
    while (true) {
      BalancedDelimiterTracker T = null;
      try {
        // Read the [id] if present.
        if ($this().Tok.is(tok.TokenKind.l_square)) {
          BalancedDelimiterTracker _T = null;
          try {
            _T/*J*/= new BalancedDelimiterTracker(/*Deref*/$this(), tok.TokenKind.l_square);
            _T.consumeOpen();
            if ($this().Tok.isNot(tok.TokenKind.identifier)) {
              JavaCleaner $c$ = $createJavaCleaner();
              try {
                $c$.clean($out_DiagnosticBuilder$C_TokenKind($c$.track($this().Diag($this().Tok, diag.err_expected)), tok.TokenKind.identifier));
                $this().SkipUntil(tok.TokenKind.r_paren, SkipUntilFlags.StopAtSemi);
                return true;
              } finally {
                $c$.$destroy();
              }
            }
            
            IdentifierInfo /*P*/ II = $this().Tok.getIdentifierInfo();
            $this().ConsumeToken();
            
            Names.push_back(II);
            _T.consumeClose();
          } finally {
            if (_T != null) { _T.$destroy(); }
          }
        } else {
          Names.push_back((IdentifierInfo /*P*/ /*const*/)null);
        }
        
        ActionResultTTrue<Expr /*P*/ > Constraint/*J*/= $this().ParseAsmStringLiteral();
        if (Constraint.isInvalid()) {
          $this().SkipUntil(tok.TokenKind.r_paren, SkipUntilFlags.StopAtSemi);
          return true;
        }
        Constraints.push_back(Constraint.get());
        if ($this().Tok.isNot(tok.TokenKind.l_paren)) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            $c$.clean($out_DiagnosticBuilder$C_char$ptr$C($c$.track($this().Diag($this().Tok, diag.err_expected_lparen_after)), /*KEEP_STR*/"asm operand"));
            $this().SkipUntil(tok.TokenKind.r_paren, SkipUntilFlags.StopAtSemi);
            return true;
          } finally {
            $c$.$destroy();
          }
        }
        
        // Read the parenthesized expression.
        T/*J*/= new BalancedDelimiterTracker(/*Deref*/$this(), tok.TokenKind.l_paren);
        T.consumeOpen();
        ActionResultTTrue<Expr /*P*/ > Res = $this().Actions.CorrectDelayedTyposInExpr($this().ParseExpression());
        T.consumeClose();
        if (Res.isInvalid()) {
          $this().SkipUntil(tok.TokenKind.r_paren, SkipUntilFlags.StopAtSemi);
          return true;
        }
        Exprs.push_back(Res.get());
        // Eat the comma and continue parsing if it exists.
        if (!$this().TryConsumeToken(tok.TokenKind.comma)) {
          return false;
        }
      } finally {
        if (T != null) { T.$destroy(); }
      }
    }
  }

} // END OF class Parser_ParseStmtAsm
