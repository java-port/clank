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

package org.clang.ast.comments;

import static org.clank.support.Native.$AddrOf;
import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import static org.llvm.support.llvm.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.basic.*;
import org.clang.ast.comments.Token;
import static org.clang.ast.java.AstRTTI.*;
import org.clang.ast.comments.impl.CommentBriefParserCommentsStatics;
import org.clang.ast.comments.impl.TextTokenRetokenizer;
import org.clang.ast.comments.llvm.ArrayRefCommentToken;
import org.clang.ast.comments.llvm.SmallVectorCommentToken;
import static org.clang.basic.BasicClangGlobals.*;


/// Doxygen comment parser.
//<editor-fold defaultstate="collapsed" desc="clang::comments::Parser">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/CommentParser.h", line = 30,
 FQN="clang::comments::Parser", NM="_ZN5clang8comments6ParserE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/CommentParser.cpp -nm=_ZN5clang8comments6ParserE")
//</editor-fold>
public class Parser implements Destructors.ClassWithDestructor {
  //<editor-fold defaultstate="collapsed" desc="clang::comments::Parser::Parser">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/CommentParser.h", line = 31,
   FQN="clang::comments::Parser::Parser", NM="_ZN5clang8comments6ParserC1ERKS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/CommentParser.cpp -nm=_ZN5clang8comments6ParserC1ERKS1_")
  //</editor-fold>
  private Parser(final /*const*/ Parser /*&*/ $Prm0) { throw new UnsupportedOperationException("Deleted");}

  //<editor-fold defaultstate="collapsed" desc="clang::comments::Parser::operator=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/CommentParser.h", line = 32,
   FQN="clang::comments::Parser::operator=", NM="_ZN5clang8comments6ParseraSERKS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/CommentParser.cpp -nm=_ZN5clang8comments6ParseraSERKS1_")
  //</editor-fold>
  private void $assign(final /*const*/ Parser /*&*/ $Prm0) { throw new UnsupportedOperationException("Deleted");}

  
  /*friend  class TextTokenRetokenizer*/
  
  private final Lexer /*&*/ L;
  
  private final Sema /*&*/ S;
  
  /// Allocator for anything that goes into AST nodes.
  private final BumpPtrAllocatorImpl /*&*/ Allocator;
  
  /// Source manager for the comment being parsed.
  private final /*const*/ SourceManager /*&*/ SourceMgr;
  
  private final DiagnosticsEngine /*&*/ Diags;
  
  //<editor-fold defaultstate="collapsed" desc="clang::comments::Parser::Diag">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/CommentParser.h", line = 48,
   FQN="clang::comments::Parser::Diag", NM="_ZN5clang8comments6Parser4DiagENS_14SourceLocationEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/CommentParser.cpp -nm=_ZN5clang8comments6Parser4DiagENS_14SourceLocationEj")
  //</editor-fold>
  private DiagnosticBuilder Diag(SourceLocation Loc, /*uint*/int DiagID) {
    return Diags.Report(/*NO_COPY*/Loc, DiagID);
  }

  
  private final /*const*/ CommandTraits /*&*/ Traits;
  
  /// Current lookahead token.  We can safely assume that all tokens are from
  /// a single source file.
  public/*friend*//*private*/ Token Tok;
  
  /// A stack of additional lookahead tokens.
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC)
  private SmallVectorCommentToken MoreLATokens;
  
  //<editor-fold defaultstate="collapsed" desc="clang::comments::Parser::consumeToken">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/CommentParser.h", line = 61,
   FQN="clang::comments::Parser::consumeToken", NM="_ZN5clang8comments6Parser12consumeTokenEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/CommentParser.cpp -nm=_ZN5clang8comments6Parser12consumeTokenEv")
  //</editor-fold>
  public/*friend*//*private*/ void consumeToken() {
    if (MoreLATokens.empty()) {
      L.lex(Tok);
    } else {
      Tok.$assignMove(MoreLATokens.pop_back_val());
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::comments::Parser::putBack">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/CommentParser.h", line = 68,
   FQN="clang::comments::Parser::putBack", NM="_ZN5clang8comments6Parser7putBackERKNS0_5TokenE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/CommentParser.cpp -nm=_ZN5clang8comments6Parser7putBackERKNS0_5TokenE")
  //</editor-fold>
  public/*friend*//*private*/ void putBack(final /*const*/ Token /*&*/ OldTok) {
    MoreLATokens.push_back(Tok);
    Tok.$assign(OldTok);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::comments::Parser::putBack">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/CommentParser.h", line = 73,
   FQN="clang::comments::Parser::putBack", NM="_ZN5clang8comments6Parser7putBackEN4llvm8ArrayRefINS0_5TokenEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/CommentParser.cpp -nm=_ZN5clang8comments6Parser7putBackEN4llvm8ArrayRefINS0_5TokenEEE")
  //</editor-fold>
  public/*friend*//*private*/ void putBack(ArrayRefCommentToken Toks) {
    if (Toks.empty()) {
      return;
    }
    
    MoreLATokens.push_back(Tok);
    MoreLATokens.append(Toks.rbegin(), std.prev(Toks.rend()));
    
    Tok.$assign(Toks.$at(0));
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::comments::Parser::isTokBlockCommand">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/CommentParser.h", line = 83,
   FQN="clang::comments::Parser::isTokBlockCommand", NM="_ZN5clang8comments6Parser17isTokBlockCommandEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/CommentParser.cpp -nm=_ZN5clang8comments6Parser17isTokBlockCommandEv")
  //</editor-fold>
  private boolean isTokBlockCommand() {
    return (Tok.is(tok.TokenKind.backslash_command) || Tok.is(tok.TokenKind.at_command))
       && Traits.getCommandInfo(Tok.getCommandID()).IsBlockCommand;
  }

/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::comments::Parser::Parser">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   optimized = Converted.Optimization.VALUE_TYPE,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/CommentParser.cpp", line = 257,
   FQN="clang::comments::Parser::Parser", NM="_ZN5clang8comments6ParserC1ERNS0_5LexerERNS0_4SemaERN4llvm20BumpPtrAllocatorImplINS6_15MallocAllocatorELj4096ELj4096EEERKNS_13SourceManagerERNS_17DiagnosticsEngineERKNS0_13CommandTraitsE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/CommentParser.cpp -nm=_ZN5clang8comments6ParserC1ERNS0_5LexerERNS0_4SemaERN4llvm20BumpPtrAllocatorImplINS6_15MallocAllocatorELj4096ELj4096EEERKNS_13SourceManagerERNS_17DiagnosticsEngineERKNS0_13CommandTraitsE")
  //</editor-fold>
  public Parser(final Lexer /*&*/ L, final Sema /*&*/ S, final BumpPtrAllocatorImpl /*&*/ Allocator, 
      final /*const*/ SourceManager /*&*/ SourceMgr, final DiagnosticsEngine /*&*/ Diags, 
      final /*const*/ CommandTraits /*&*/ Traits) {
    // : L(L), S(S), Allocator(Allocator), SourceMgr(SourceMgr), Diags(Diags), Traits(Traits), Tok(), MoreLATokens() 
    //START JInit
    this./*&*/L=/*&*/L;
    this./*&*/S=/*&*/S;
    this./*&*/Allocator=/*&*/Allocator;
    this./*&*/SourceMgr=/*&*/SourceMgr;
    this./*&*/Diags=/*&*/Diags;
    this./*&*/Traits=/*&*/Traits;
    this.Tok = new Token();
    this.MoreLATokens = new SmallVectorCommentToken(8, /*PERF new Token()*/(Token)null);
    //END JInit
    consumeToken();
  }

  
  /// Parse arguments for \\param command.
  //<editor-fold defaultstate="collapsed" desc="clang::comments::Parser::parseParamCommandArgs">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/CommentParser.cpp", line = 265,
   FQN="clang::comments::Parser::parseParamCommandArgs", NM="_ZN5clang8comments6Parser21parseParamCommandArgsEPNS0_19ParamCommandCommentERNS0_20TextTokenRetokenizerE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/CommentParser.cpp -nm=_ZN5clang8comments6Parser21parseParamCommandArgsEPNS0_19ParamCommandCommentERNS0_20TextTokenRetokenizerE")
  //</editor-fold>
  public void parseParamCommandArgs(ParamCommandComment /*P*/ PC, 
                       final TextTokenRetokenizer /*&*/ Retokenizer) {
    Token Arg/*J*/= new Token();
    // Check if argument looks like direction specification: [dir]
    // e.g., [in], [out], [in,out]
    if (Retokenizer.lexDelimitedSeq(Arg, $$LSQUARE, $$RSQUARE)) {
      S.actOnParamCommandDirectionArg(PC, 
          Arg.getLocation(), 
          Arg.getEndLocation(), 
          Arg.getText());
    }
    if (Retokenizer.lexWord(Arg)) {
      S.actOnParamCommandParamNameArg(PC, 
          Arg.getLocation(), 
          Arg.getEndLocation(), 
          Arg.getText());
    }
  }

  
  /// Parse arguments for \\tparam command.
  //<editor-fold defaultstate="collapsed" desc="clang::comments::Parser::parseTParamCommandArgs">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/CommentParser.cpp", line = 283,
   FQN="clang::comments::Parser::parseTParamCommandArgs", NM="_ZN5clang8comments6Parser22parseTParamCommandArgsEPNS0_20TParamCommandCommentERNS0_20TextTokenRetokenizerE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/CommentParser.cpp -nm=_ZN5clang8comments6Parser22parseTParamCommandArgsEPNS0_20TParamCommandCommentERNS0_20TextTokenRetokenizerE")
  //</editor-fold>
  public void parseTParamCommandArgs(TParamCommandComment /*P*/ TPC, 
                        final TextTokenRetokenizer /*&*/ Retokenizer) {
    Token Arg/*J*/= new Token();
    if (Retokenizer.lexWord(Arg)) {
      S.actOnTParamCommandParamNameArg(TPC, 
          Arg.getLocation(), 
          Arg.getEndLocation(), 
          Arg.getText());
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::comments::Parser::parseBlockCommandArgs">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/CommentParser.cpp", line = 293,
   FQN="clang::comments::Parser::parseBlockCommandArgs", NM="_ZN5clang8comments6Parser21parseBlockCommandArgsEPNS0_19BlockCommandCommentERNS0_20TextTokenRetokenizerEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/CommentParser.cpp -nm=_ZN5clang8comments6Parser21parseBlockCommandArgsEPNS0_19BlockCommandCommentERNS0_20TextTokenRetokenizerEj")
  //</editor-fold>
  public void parseBlockCommandArgs(BlockCommandComment /*P*/ BC, 
                       final TextTokenRetokenizer /*&*/ Retokenizer, 
                       /*uint*/int NumArgs) {
    /*typedef BlockCommandComment::Argument Argument*/
//    final class Argument extends BlockCommandComment.Argument{ };
    BlockCommandComment.Argument /*P*/ Args[] = /*FIXME:NEW_EXPR*//*new (Allocator.Allocate<Argument>(NumArgs))*/ new BlockCommandComment.Argument [NumArgs];
    /*uint*/int ParsedArgs = 0;
    Token Arg/*J*/= new Token();
    while ($less_uint(ParsedArgs, NumArgs) && Retokenizer.lexWord(Arg)) {
      Args[ParsedArgs].$assignMove(new BlockCommandComment.Argument(new SourceRange(Arg.getLocation(), 
                  Arg.getEndLocation()), 
              Arg.getText()));
      ParsedArgs++;
    }
    
    S.actOnBlockCommandArgs(BC, llvm.makeArrayRef(Args, ParsedArgs));
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::comments::Parser::parseBlockCommand">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/CommentParser.cpp", line = 311,
   FQN="clang::comments::Parser::parseBlockCommand", NM="_ZN5clang8comments6Parser17parseBlockCommandEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/CommentParser.cpp -nm=_ZN5clang8comments6Parser17parseBlockCommandEv")
  //</editor-fold>
  public BlockCommandComment /*P*/ parseBlockCommand() {
    assert (Tok.is(tok.TokenKind.backslash_command) || Tok.is(tok.TokenKind.at_command));
    
    ParamCommandComment /*P*/ PC = null;
    TParamCommandComment /*P*/ TPC = null;
    BlockCommandComment /*P*/ BC = null;
    /*const*/ CommandInfo /*P*/ Info = Traits.getCommandInfo(Tok.getCommandID());
    CommandMarkerKind CommandMarker = Tok.is(tok.TokenKind.backslash_command) ? CommandMarkerKind.CMK_Backslash : CommandMarkerKind.CMK_At;
    if (Info.IsParamCommand) {
      PC = S.actOnParamCommandStart(Tok.getLocation(), 
          Tok.getEndLocation(), 
          Tok.getCommandID(), 
          CommandMarker);
    } else if (Info.IsTParamCommand) {
      TPC = S.actOnTParamCommandStart(Tok.getLocation(), 
          Tok.getEndLocation(), 
          Tok.getCommandID(), 
          CommandMarker);
    } else {
      BC = S.actOnBlockCommandStart(Tok.getLocation(), 
          Tok.getEndLocation(), 
          Tok.getCommandID(), 
          CommandMarker);
    }
    consumeToken();
    if (isTokBlockCommand()) {
      // Block command ahead.  We can't nest block commands, so pretend that this
      // command has an empty argument.
      ParagraphComment /*P*/ Paragraph = S.actOnParagraphComment(new ArrayRef<InlineContentComment /*P*/ >(None, true));
      if ((PC != null)) {
        S.actOnParamCommandFinish(PC, Paragraph);
        return PC;
      } else if ((TPC != null)) {
        S.actOnTParamCommandFinish(TPC, Paragraph);
        return TPC;
      } else {
        S.actOnBlockCommandFinish(BC, Paragraph);
        return BC;
      }
    }
    if ((PC != null) || (TPC != null) || Info.NumArgs > $int2uint_4bits(0)) {
      TextTokenRetokenizer Retokenizer = null;
      try {
        // In order to parse command arguments we need to retokenize a few
        // following text tokens.
        Retokenizer/*J*/= new TextTokenRetokenizer(Allocator, /*Deref*/this);
        if ((PC != null)) {
          parseParamCommandArgs(PC, Retokenizer);
        } else if ((TPC != null)) {
          parseTParamCommandArgs(TPC, Retokenizer);
        } else {
          parseBlockCommandArgs(BC, Retokenizer, Info.NumArgs);
        }
        
        Retokenizer.putBackLeftoverTokens();
      } finally {
        if (Retokenizer != null) { Retokenizer.$destroy(); }
      }
    }
    
    // If there's a block command ahead, we will attach an empty paragraph to
    // this command.
    boolean EmptyParagraph = false;
    if (isTokBlockCommand()) {
      EmptyParagraph = true;
    } else if (Tok.is(tok.TokenKind.newline)) {
      Token PrevTok = new Token(Tok);
      consumeToken();
      EmptyParagraph = isTokBlockCommand();
      putBack(PrevTok);
    }
    
    ParagraphComment /*P*/ Paragraph;
    if (EmptyParagraph) {
      Paragraph = S.actOnParagraphComment(new ArrayRef<InlineContentComment /*P*/ >(None, true));
    } else {
      BlockContentComment /*P*/ Block = parseParagraphOrBlockCommand();
      // Since we have checked for a block command, we should have parsed a
      // paragraph.
      Paragraph = cast_ParagraphComment(Block);
    }
    if ((PC != null)) {
      S.actOnParamCommandFinish(PC, Paragraph);
      return PC;
    } else if ((TPC != null)) {
      S.actOnTParamCommandFinish(TPC, Paragraph);
      return TPC;
    } else {
      S.actOnBlockCommandFinish(BC, Paragraph);
      return BC;
    }
  }

  //<editor-fold defaultstate="collapsed" desc="clang::comments::Parser::parseInlineCommand">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/CommentParser.cpp", line = 403,
   FQN="clang::comments::Parser::parseInlineCommand", NM="_ZN5clang8comments6Parser18parseInlineCommandEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/CommentParser.cpp -nm=_ZN5clang8comments6Parser18parseInlineCommandEv")
  //</editor-fold>
  public InlineCommandComment /*P*/ parseInlineCommand() {
    TextTokenRetokenizer Retokenizer = null;
    try {
      assert (Tok.is(tok.TokenKind.backslash_command) || Tok.is(tok.TokenKind.at_command));
      
      /*const*/ Token CommandTok = new Token(Tok);
      consumeToken();
      
      Retokenizer/*J*/= new TextTokenRetokenizer(Allocator, /*Deref*/this);
      
      Token ArgTok/*J*/= new Token();
      boolean ArgTokValid = Retokenizer.lexWord(ArgTok);
      
      InlineCommandComment /*P*/ IC;
      if (ArgTokValid) {
        IC = S.actOnInlineCommand(CommandTok.getLocation(), 
            CommandTok.getEndLocation(), 
            CommandTok.getCommandID(), 
            ArgTok.getLocation(), 
            ArgTok.getEndLocation(), 
            ArgTok.getText());
      } else {
        IC = S.actOnInlineCommand(CommandTok.getLocation(), 
            CommandTok.getEndLocation(), 
            CommandTok.getCommandID());
      }
      
      Retokenizer.putBackLeftoverTokens();
      
      return IC;
    } finally {
      if (Retokenizer != null) { Retokenizer.$destroy(); }
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::comments::Parser::parseHTMLStartTag">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/CommentParser.cpp", line = 433,
   FQN="clang::comments::Parser::parseHTMLStartTag", NM="_ZN5clang8comments6Parser17parseHTMLStartTagEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/CommentParser.cpp -nm=_ZN5clang8comments6Parser17parseHTMLStartTagEv")
  //</editor-fold>
  public HTMLStartTagComment /*P*/ parseHTMLStartTag() {
    assert (Tok.is(tok.TokenKind.html_start_tag));
    HTMLStartTagComment /*P*/ HST = S.actOnHTMLStartTagStart(Tok.getLocation(), 
        Tok.getHTMLTagStartName());
    consumeToken();
    
    SmallVector<HTMLStartTagComment.Attribute> Attrs/*J*/= new SmallVector<HTMLStartTagComment.Attribute>(2, new HTMLStartTagComment.Attribute());
    while (true) {
      switch (Tok.getKind()) {
       case html_ident:
        {
          Token Ident = new Token(Tok);
          consumeToken();
          if (Tok.isNot(tok.TokenKind.html_equals)) {
            Attrs.push_back(new HTMLStartTagComment.Attribute(Ident.getLocation(), 
                    Ident.getHTMLIdent()));
            continue;
          }
          Token Equals = new Token(Tok);
          consumeToken();
          if (Tok.isNot(tok.TokenKind.html_quoted_string)) {
            JavaCleaner $c$ = $createJavaCleaner();
            try {
              $c$.clean($out_DiagnosticBuilder$C_SourceRange($c$.track(Diag(Tok.getLocation(), 
                      diag.warn_doc_html_start_tag_expected_quoted_string)), 
                  new SourceRange(Equals.getLocation())));
              Attrs.push_back(new HTMLStartTagComment.Attribute(Ident.getLocation(), 
                      Ident.getHTMLIdent()));
              while (Tok.is(tok.TokenKind.html_equals)
                 || Tok.is(tok.TokenKind.html_quoted_string)) {
                consumeToken();
              }
              continue;
            } finally {
              $c$.$destroy();
            }
          }
          Attrs.push_back(new HTMLStartTagComment.Attribute(Ident.getLocation(), 
                  Ident.getHTMLIdent(), 
                  Equals.getLocation(), 
                  new SourceRange(Tok.getLocation(), 
                      Tok.getEndLocation()), 
                  Tok.getHTMLQuotedString()));
          consumeToken();
          continue;
        }
       case html_greater:
        S.actOnHTMLStartTagFinish(HST, 
            S.copyArray(HTMLStartTagComment.Attribute.class, llvm.makeArrayRef(Attrs)), 
            Tok.getLocation(), 
            /* IsSelfClosing = */ false);
        consumeToken();
        return HST;
       case html_slash_greater:
        S.actOnHTMLStartTagFinish(HST, 
            S.copyArray(HTMLStartTagComment.Attribute.class, llvm.makeArrayRef(Attrs)), 
            Tok.getLocation(), 
            /* IsSelfClosing = */ true);
        consumeToken();
        return HST;
       case html_equals:
       case html_quoted_string:
        {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            $c$.clean($c$.track(Diag(Tok.getLocation(), 
                diag.warn_doc_html_start_tag_expected_ident_or_greater)));
            while (Tok.is(tok.TokenKind.html_equals)
               || Tok.is(tok.TokenKind.html_quoted_string)) {
              consumeToken();
            }
            if (Tok.is(tok.TokenKind.html_ident)
               || Tok.is(tok.TokenKind.html_greater)
               || Tok.is(tok.TokenKind.html_slash_greater)) {
              continue;
            }
            
            S.actOnHTMLStartTagFinish(HST, 
                S.copyArray(HTMLStartTagComment.Attribute.class, llvm.makeArrayRef(Attrs)), 
                new SourceLocation(), 
                /* IsSelfClosing = */ false);
            return HST;
          } finally {
            $c$.$destroy();
          }
        }
       default:
        // Not a token from an HTML start tag.  Thus HTML tag prematurely ended.
        S.actOnHTMLStartTagFinish(HST, 
            S.copyArray(HTMLStartTagComment.Attribute.class, llvm.makeArrayRef(Attrs)), 
            new SourceLocation(), 
            /* IsSelfClosing = */ false);
        bool$ptr StartLineInvalid = create_bool$ptr();
        /*const*//*uint*/int StartLine = SourceMgr.getPresumedLineNumber(HST.getLocation(), 
            $AddrOf(StartLineInvalid));
        bool$ptr EndLineInvalid = create_bool$ptr();
        /*const*//*uint*/int EndLine = SourceMgr.getPresumedLineNumber(Tok.getLocation(), 
            $AddrOf(EndLineInvalid));
        if (StartLineInvalid.$star() || EndLineInvalid.$star() || StartLine == EndLine) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            $c$.clean($out_DiagnosticBuilder$C_SourceRange($c$.track(Diag(Tok.getLocation(), 
                    diag.warn_doc_html_start_tag_expected_ident_or_greater)), 
                HST.getSourceRange()));
          } finally {
            $c$.$destroy();
          }
        } else {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            $c$.clean($c$.track(Diag(Tok.getLocation(), 
                diag.warn_doc_html_start_tag_expected_ident_or_greater)));
            $c$.clean($out_DiagnosticBuilder$C_SourceRange($c$.track(Diag(HST.getLocation(), diag.note_doc_html_tag_started_here)), 
                HST.getSourceRange()));
          } finally {
            $c$.$destroy();
          }
        }
        return HST;
      }
    }
  }

  //<editor-fold defaultstate="collapsed" desc="clang::comments::Parser::parseHTMLEndTag">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/CommentParser.cpp", line = 538,
   FQN="clang::comments::Parser::parseHTMLEndTag", NM="_ZN5clang8comments6Parser15parseHTMLEndTagEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/CommentParser.cpp -nm=_ZN5clang8comments6Parser15parseHTMLEndTagEv")
  //</editor-fold>
  public HTMLEndTagComment /*P*/ parseHTMLEndTag() {
    assert (Tok.is(tok.TokenKind.html_end_tag));
    Token TokEndTag = new Token(Tok);
    consumeToken();
    SourceLocation Loc/*J*/= new SourceLocation();
    if (Tok.is(tok.TokenKind.html_greater)) {
      Loc.$assignMove(Tok.getLocation());
      consumeToken();
    }
    
    return S.actOnHTMLEndTag(TokEndTag.getLocation(), 
        new SourceLocation(Loc), 
        TokEndTag.getHTMLTagEndName());
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::comments::Parser::parseParagraphOrBlockCommand">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/CommentParser.cpp", line = 553,
   FQN="clang::comments::Parser::parseParagraphOrBlockCommand", NM="_ZN5clang8comments6Parser28parseParagraphOrBlockCommandEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/CommentParser.cpp -nm=_ZN5clang8comments6Parser28parseParagraphOrBlockCommandEv")
  //</editor-fold>
  public BlockContentComment /*P*/ parseParagraphOrBlockCommand() {
    SmallVector<InlineContentComment /*P*/ > Content/*J*/= new SmallVector<InlineContentComment /*P*/ >(8, (InlineContentComment /*P*/ )null);
    while (true) {
      switch (Tok.getKind()) {
       case verbatim_block_begin:
       case verbatim_line_name:
       case eof:
        assert (Content.size() != 0);
        break; // Block content or EOF ahead, finish this parapgaph.
       case unknown_command:
        Content.push_back(S.actOnUnknownCommand(Tok.getLocation(), 
                Tok.getEndLocation(), 
                Tok.getUnknownCommandName()));
        consumeToken();
        continue;
       case backslash_command:
       case at_command:
        {
          /*const*/ CommandInfo /*P*/ Info = Traits.getCommandInfo(Tok.getCommandID());
          if (Info.IsBlockCommand) {
            if (Content.size() == 0) {
              return parseBlockCommand();
            }
            break; // Block command ahead, finish this parapgaph.
          }
          if (Info.IsVerbatimBlockEndCommand) {
            JavaCleaner $c$ = $createJavaCleaner();
            try {
              $c$.clean($out_DiagnosticBuilder$C_SourceRange($out_DiagnosticBuilder$C_char$ptr$C($out$Same2Bool($c$.track(Diag(Tok.getLocation(), 
                              diag.warn_verbatim_block_end_without_start)), 
                          Tok.is(tok.TokenKind.at_command)), 
                      Info.Name), 
                  new SourceRange(Tok.getLocation(), Tok.getEndLocation())));
              consumeToken();
              continue;
            } finally {
              $c$.$destroy();
            }
          }
          if (Info.IsUnknownCommand) {
            Content.push_back(S.actOnUnknownCommand(Tok.getLocation(), 
                    Tok.getEndLocation(), 
                    Info.getID()));
            consumeToken();
            continue;
          }
          assert Native.$bool(Info.IsInlineCommand);
          Content.push_back(parseInlineCommand());
          continue;
        }
       case newline:
        {
          consumeToken();
          if (Tok.is(tok.TokenKind.newline) || Tok.is(tok.TokenKind.eof)) {
            consumeToken();
            break; // Two newlines -- end of paragraph.
          }
          // Also allow [tok::newline, tok::text, tok::newline] if the middle
          // tok::text is just whitespace.
          if (Tok.is(tok.TokenKind.text) && CommentBriefParserCommentsStatics.isWhitespace(Tok.getText())) {
            Token WhitespaceTok = new Token(Tok);
            consumeToken();
            if (Tok.is(tok.TokenKind.newline) || Tok.is(tok.TokenKind.eof)) {
              consumeToken();
              break;
            }
            // We have [tok::newline, tok::text, non-newline].  Put back tok::text.
            putBack(WhitespaceTok);
          }
          if ($greater_uint(Content.size(), 0)) {
            Content.back().addTrailingNewline();
          }
          continue;
        }
       case html_start_tag:
        
        // Don't deal with HTML tag soup now.
        Content.push_back(parseHTMLStartTag());
        continue;
       case html_end_tag:
        Content.push_back(parseHTMLEndTag());
        continue;
       case text:
        Content.push_back(S.actOnText(Tok.getLocation(), 
                Tok.getEndLocation(), 
                Tok.getText()));
        consumeToken();
        continue;
       case verbatim_block_line:
       case verbatim_block_end:
       case verbatim_line_text:
       case html_ident:
       case html_equals:
       case html_quoted_string:
       case html_greater:
       case html_slash_greater:
        throw new llvm_unreachable("should not see this token");
      }
      break;
    }
    
    return S.actOnParagraphComment(S.copyArray(InlineContentComment.class, llvm.makeArrayRef(Content)));
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::comments::Parser::parseVerbatimBlock">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/CommentParser.cpp", line = 655,
   FQN="clang::comments::Parser::parseVerbatimBlock", NM="_ZN5clang8comments6Parser18parseVerbatimBlockEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/CommentParser.cpp -nm=_ZN5clang8comments6Parser18parseVerbatimBlockEv")
  //</editor-fold>
  public VerbatimBlockComment /*P*/ parseVerbatimBlock() {
    assert (Tok.is(tok.TokenKind.verbatim_block_begin));
    
    VerbatimBlockComment /*P*/ VB = S.actOnVerbatimBlockStart(Tok.getLocation(), 
        Tok.getVerbatimBlockID());
    consumeToken();
    
    // Don't create an empty line if verbatim opening command is followed
    // by a newline.
    if (Tok.is(tok.TokenKind.newline)) {
      consumeToken();
    }
    
    SmallVector<VerbatimBlockLineComment /*P*/ > Lines/*J*/= new SmallVector<VerbatimBlockLineComment /*P*/ >(8, (VerbatimBlockLineComment /*P*/ )null);
    while (Tok.is(tok.TokenKind.verbatim_block_line)
       || Tok.is(tok.TokenKind.newline)) {
      VerbatimBlockLineComment /*P*/ Line;
      if (Tok.is(tok.TokenKind.verbatim_block_line)) {
        Line = S.actOnVerbatimBlockLine(Tok.getLocation(), 
            Tok.getVerbatimBlockText());
        consumeToken();
        if (Tok.is(tok.TokenKind.newline)) {
          consumeToken();
        }
      } else {
        // Empty line, just a tok::newline.
        Line = S.actOnVerbatimBlockLine(Tok.getLocation(), new StringRef(/*KEEP_STR*/$EMPTY));
        consumeToken();
      }
      Lines.push_back(Line);
    }
    if (Tok.is(tok.TokenKind.verbatim_block_end)) {
      /*const*/ CommandInfo /*P*/ Info = Traits.getCommandInfo(Tok.getVerbatimBlockID());
      S.actOnVerbatimBlockFinish(VB, Tok.getLocation(), 
          new StringRef(Info.Name), 
          S.copyArray(VerbatimBlockLineComment.class, llvm.makeArrayRef(Lines)));
      consumeToken();
    } else {
      // Unterminated \\verbatim block
      S.actOnVerbatimBlockFinish(VB, new SourceLocation(), new StringRef(/*KEEP_STR*/$EMPTY), 
          S.copyArray(VerbatimBlockLineComment.class, llvm.makeArrayRef(Lines)));
    }
    
    return VB;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::comments::Parser::parseVerbatimLine">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/CommentParser.cpp", line = 702,
   FQN="clang::comments::Parser::parseVerbatimLine", NM="_ZN5clang8comments6Parser17parseVerbatimLineEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/CommentParser.cpp -nm=_ZN5clang8comments6Parser17parseVerbatimLineEv")
  //</editor-fold>
  public VerbatimLineComment /*P*/ parseVerbatimLine() {
    assert (Tok.is(tok.TokenKind.verbatim_line_name));
    
    Token NameTok = new Token(Tok);
    consumeToken();
    
    SourceLocation TextBegin/*J*/= new SourceLocation();
    StringRef Text/*J*/= new StringRef();
    // Next token might not be a tok::verbatim_line_text if verbatim line
    // starting command comes just before a newline or comment end.
    if (Tok.is(tok.TokenKind.verbatim_line_text)) {
      TextBegin.$assignMove(Tok.getLocation());
      Text.$assignMove(Tok.getVerbatimLineText());
    } else {
      TextBegin.$assignMove(NameTok.getEndLocation());
      Text.$assignMove(/*STRINGREF_STR*/$EMPTY);
    }
    
    VerbatimLineComment /*P*/ VL = S.actOnVerbatimLine(NameTok.getLocation(), 
        NameTok.getVerbatimLineID(), 
        new SourceLocation(TextBegin), 
        new StringRef(Text));
    consumeToken();
    return VL;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::comments::Parser::parseBlockContent">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/CommentParser.cpp", line = 728,
   FQN="clang::comments::Parser::parseBlockContent", NM="_ZN5clang8comments6Parser17parseBlockContentEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/CommentParser.cpp -nm=_ZN5clang8comments6Parser17parseBlockContentEv")
  //</editor-fold>
  public BlockContentComment /*P*/ parseBlockContent() {
    switch (Tok.getKind()) {
     case text:
     case unknown_command:
     case backslash_command:
     case at_command:
     case html_start_tag:
     case html_end_tag:
      return parseParagraphOrBlockCommand();
     case verbatim_block_begin:
      return parseVerbatimBlock();
     case verbatim_line_name:
      return parseVerbatimLine();
     case eof:
     case newline:
     case verbatim_block_line:
     case verbatim_block_end:
     case verbatim_line_text:
     case html_ident:
     case html_equals:
     case html_quoted_string:
     case html_greater:
     case html_slash_greater:
      throw new llvm_unreachable("should not see this token");
    }
    throw new llvm_unreachable("bogus token kind");
  }

  //<editor-fold defaultstate="collapsed" desc="clang::comments::Parser::parseFullComment">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/CommentParser.cpp", line = 759,
   FQN="clang::comments::Parser::parseFullComment", NM="_ZN5clang8comments6Parser16parseFullCommentEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/CommentParser.cpp -nm=_ZN5clang8comments6Parser16parseFullCommentEv")
  //</editor-fold>
  public FullComment /*P*/ parseFullComment() {
    // Skip newlines at the beginning of the comment.
    while (Tok.is(tok.TokenKind.newline)) {
      consumeToken();
    }
    
    SmallVector<BlockContentComment /*P*/ > Blocks/*J*/= new SmallVector<BlockContentComment /*P*/ >(8, (BlockContentComment /*P*/ )null);
    while (Tok.isNot(tok.TokenKind.eof)) {
      Blocks.push_back(parseBlockContent());
      
      // Skip extra newlines after paragraph end.
      while (Tok.is(tok.TokenKind.newline)) {
        consumeToken();
      }
    }
    return S.actOnFullComment(S.copyArray(BlockContentComment.class, llvm.makeArrayRef(Blocks)));
  }


  //<editor-fold defaultstate="collapsed" desc="clang::comments::Parser::~Parser">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/CommentParser.h", line = 30,
   FQN="clang::comments::Parser::~Parser", NM="_ZN5clang8comments6ParserD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/RawCommentList.cpp -nm=_ZN5clang8comments6ParserD0Ev")
  //</editor-fold>
  public /*inline*/ void $destroy() {
    //START JDestroy
    MoreLATokens.$destroy();
    //END JDestroy
  }

  
  @Override public String toString() {
    return "" + "L=" + "[Lexer]" // NOI18N
              + ", S=" + "[Sema]" // NOI18N
              + ", Allocator=" + "[BumpPtrAllocatorImpl]" // NOI18N
              + ", SourceMgr=" + "[SourceManager]" // NOI18N
              + ", Diags=" + "[DiagnosticsEngine]" // NOI18N
              + ", Traits=" + Traits // NOI18N
              + ", Tok=" + Tok // NOI18N
              + ", MoreLATokens=" + MoreLATokens; // NOI18N
  }
}
