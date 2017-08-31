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

package org.clang.format.impl;

import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import static org.llvm.support.llvm.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.basic.*;
import org.clang.format.*;
import static org.clang.basic.BasicClangGlobals.*;
import static org.clang.format.impl.FormatStatics.*;

//<editor-fold defaultstate="collapsed" desc="clang::format::UnwrappedLineParser">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/UnwrappedLineParser.h", line = 61,
 FQN="clang::format::UnwrappedLineParser", NM="_ZN5clang6format19UnwrappedLineParserE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/TokenAnalyzer.cpp -nm=_ZN5clang6format19UnwrappedLineParserE")
//</editor-fold>
public class UnwrappedLineParser implements Destructors.ClassWithDestructor {
/*public:*/
  // end anonymous namespace
  //<editor-fold defaultstate="collapsed" desc="clang::format::UnwrappedLineParser::UnwrappedLineParser">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/UnwrappedLineParser.cpp", line = 200,
   FQN="clang::format::UnwrappedLineParser::UnwrappedLineParser", NM="_ZN5clang6format19UnwrappedLineParserC1ERKNS0_11FormatStyleERKNS0_18AdditionalKeywordsEN4llvm8ArrayRefIPNS0_11FormatTokenEEERNS0_21UnwrappedLineConsumerE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/UnwrappedLineParser.cpp -nm=_ZN5clang6format19UnwrappedLineParserC1ERKNS0_11FormatStyleERKNS0_18AdditionalKeywordsEN4llvm8ArrayRefIPNS0_11FormatTokenEEERNS0_21UnwrappedLineConsumerE")
  //</editor-fold>
  public UnwrappedLineParser(final /*const*/ FormatStyle /*&*/ Style, 
      final /*const*/ AdditionalKeywords /*&*/ Keywords, 
      ArrayRef<FormatToken /*P*/ > Tokens, 
      final UnwrappedLineConsumer /*&*/ Callback) {
    // : Line(new UnwrappedLine), CommentsBeforeNextToken(), MustBreakBeforeNextToken(false), Lines(), PreprocessorDirectives(), CurrentLines(&Lines), DeclarationScopeStack(), Style(Style), Keywords(Keywords), Tokens(null), Callback(Callback), AllTokens(Tokens), PPStack(), PPBranchLevel(-1), PPLevelBranchIndex(), PPLevelBranchCount(), PPChainBranchIndex() 
    //START JInit
    this.Line = new std.unique_ptr<UnwrappedLine>(new UnwrappedLine());
    this.CommentsBeforeNextToken = new SmallVector<FormatToken /*P*/ >(1, (FormatToken /*P*/ )null);
    this.MustBreakBeforeNextToken = false;
    this.Lines = new SmallVector<UnwrappedLine>(8, new UnwrappedLine());
    this.PreprocessorDirectives = new SmallVector<UnwrappedLine>(4, new UnwrappedLine());
    this.CurrentLines = /*AddrOf*/Lines;
    this.DeclarationScopeStack = new std.vectorBool();
    this./*&*/Style=/*&*/Style;
    this./*&*/Keywords=/*&*/Keywords;
    this.Tokens = null;
    this./*&*/Callback=/*&*/Callback;
    this.AllTokens = new ArrayRef<FormatToken /*P*/ >(Tokens);
    this.PPStack = new SmallVector<PPBranchKind>(16, PPBranchKind.valueOf(0));
    this.PPBranchLevel = -1;
    this.PPLevelBranchIndex = new SmallVectorInt/*8*/(8);
    this.PPLevelBranchCount = new SmallVectorInt/*8*/(8);
    this.PPChainBranchIndex = new std.stackInt();
    //END JInit
  }


  //<editor-fold defaultstate="collapsed" desc="clang::format::UnwrappedLineParser::parse">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/UnwrappedLineParser.cpp", line = 220,
   FQN="clang::format::UnwrappedLineParser::parse", NM="_ZN5clang6format19UnwrappedLineParser5parseEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/UnwrappedLineParser.cpp -nm=_ZN5clang6format19UnwrappedLineParser5parseEv")
  //</editor-fold>
  public void parse() {
    IndexedTokenSource TokenSource = null;
    try {
      TokenSource/*J*/= new IndexedTokenSource(new ArrayRef<FormatToken /*P*/ >(AllTokens));
      do {
        do {
          if (/*::*/llvm.DebugFlag && /*::*/llvm.isCurrentDebugType(/*KEEP_STR*/"format-parser")) {
            llvm.dbgs().$out(/*KEEP_STR*/"----\n");
          }
        } while (false);
        reset();
        Tokens = /*AddrOf*/TokenSource;
        TokenSource.reset();
        
        readToken();
        parseFile();
        // Create line with eof token.
        pushToken(FormatTok);
        addUnwrappedLine();
        
        for (type$ptr<UnwrappedLine> I = $tryClone(Lines.begin()), 
            /*P*/ E = $tryClone(Lines.end());
             $noteq_ptr(I, E); I.$preInc()) {
          Callback.consumeUnwrappedLine(I.$star());
        }
        Callback.finishRun();
        Lines.clear();
        while (!PPLevelBranchIndex.empty()
           && PPLevelBranchIndex.back() + 1 >= PPLevelBranchCount.back()) {
          PPLevelBranchIndex.resize(PPLevelBranchIndex.size() - 1);
          PPLevelBranchCount.resize(PPLevelBranchCount.size() - 1);
        }
        if (!PPLevelBranchIndex.empty()) {
          PPLevelBranchIndex.ref$back().$assign(PPLevelBranchIndex.back() + 1);//++PPLevelBranchIndex.back();
          assert (PPLevelBranchIndex.size() == PPLevelBranchCount.size());
          assert (PPLevelBranchIndex.back() <= PPLevelBranchCount.back());
        }
      } while (!PPLevelBranchIndex.empty());
    } finally {
      if (TokenSource != null) { TokenSource.$destroy(); }
    }
  }


/*private:*/
  //<editor-fold defaultstate="collapsed" desc="clang::format::UnwrappedLineParser::reset">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/UnwrappedLineParser.cpp", line = 208,
   FQN="clang::format::UnwrappedLineParser::reset", NM="_ZN5clang6format19UnwrappedLineParser5resetEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/UnwrappedLineParser.cpp -nm=_ZN5clang6format19UnwrappedLineParser5resetEv")
  //</editor-fold>
  private void reset() {
    PPBranchLevel = -1;
    Line.reset(new UnwrappedLine());
    CommentsBeforeNextToken.clear();
    FormatTok = null;
    MustBreakBeforeNextToken = false;
    PreprocessorDirectives.clear();
    CurrentLines = /*AddrOf*/Lines;
    DeclarationScopeStack.clear();
    PPStack.clear();
  }


  //<editor-fold defaultstate="collapsed" desc="clang::format::UnwrappedLineParser::parseFile">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/UnwrappedLineParser.cpp", line = 254,
   FQN="clang::format::UnwrappedLineParser::parseFile", NM="_ZN5clang6format19UnwrappedLineParser9parseFileEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/UnwrappedLineParser.cpp -nm=_ZN5clang6format19UnwrappedLineParser9parseFileEv")
  //</editor-fold>
  private void parseFile() {
    ScopedDeclarationState DeclarationState = null;
    try {
      // The top-level context in a file always has declarations, except for pre-
      // processor directives and JavaScript files.
      boolean MustBeDeclaration = !Line.$arrow().InPPDirective && Style.Language != FormatStyle.LanguageKind.LK_JavaScript;
      DeclarationState/*J*/= new ScopedDeclarationState(Line.$star(), DeclarationScopeStack, 
          MustBeDeclaration);
      parseLevel(/*HasOpeningBrace=*/ false);
      // Make sure to format the remaining tokens.
      flushComments(true);
      addUnwrappedLine();
    } finally {
      if (DeclarationState != null) { DeclarationState.$destroy(); }
    }
  }


  //<editor-fold defaultstate="collapsed" desc="clang::format::UnwrappedLineParser::parseLevel">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/UnwrappedLineParser.cpp", line = 267,
   FQN="clang::format::UnwrappedLineParser::parseLevel", NM="_ZN5clang6format19UnwrappedLineParser10parseLevelEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/UnwrappedLineParser.cpp -nm=_ZN5clang6format19UnwrappedLineParser10parseLevelEb")
  //</editor-fold>
  private void parseLevel(boolean HasOpeningBrace) {
    boolean SwitchLabelEncountered = false;
    do {
      /*tok.TokenKind*/char kind = FormatTok.Tok.getKind();
      if (FormatTok.Type == TokenType.TT_MacroBlockBegin) {
        kind = tok.TokenKind.l_brace;
      } else if (FormatTok.Type == TokenType.TT_MacroBlockEnd) {
        kind = tok.TokenKind.r_brace;
      }
      switch (kind) {
       case tok.TokenKind.comment:
        nextToken();
        addUnwrappedLine();
        break;
       case tok.TokenKind.l_brace:
        // FIXME: Add parameter whether this can happen - if this happens, we must
        // be in a non-declaration context.
        if (!FormatTok.is_TokenType(TokenType.TT_MacroBlockBegin) && tryToParseBracedList()) {
          continue;
        }
        parseBlock(/*MustBeDeclaration=*/ false);
        addUnwrappedLine();
        break;
       case tok.TokenKind.r_brace:
        if (HasOpeningBrace) {
          return;
        }
        nextToken();
        addUnwrappedLine();
        break;
       case tok.TokenKind.kw_default:
       case tok.TokenKind.kw_case:
        if (!SwitchLabelEncountered
           && (Style.IndentCaseLabels || (Line.$arrow().InPPDirective && Line.$arrow().Level == 1))) {
          ++Line.$arrow().Level;
        }
        SwitchLabelEncountered = true;
        parseStructuralElement();
        break;
       default:
        parseStructuralElement();
        break;
      }
    } while (!eof());
  }


  //<editor-fold defaultstate="collapsed" desc="clang::format::UnwrappedLineParser::parseBlock">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/UnwrappedLineParser.cpp", line = 412,
   FQN="clang::format::UnwrappedLineParser::parseBlock", NM="_ZN5clang6format19UnwrappedLineParser10parseBlockEbbb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/UnwrappedLineParser.cpp -nm=_ZN5clang6format19UnwrappedLineParser10parseBlockEbbb")
  //</editor-fold>
  private void parseBlock(boolean MustBeDeclaration) {
    parseBlock(MustBeDeclaration, true, 
            true);
  }
  private void parseBlock(boolean MustBeDeclaration, boolean AddLevel/*= true*/) {
    parseBlock(MustBeDeclaration, AddLevel, 
            true);
  }
  private void parseBlock(boolean MustBeDeclaration, boolean AddLevel/*= true*/, 
            boolean MunchSemi/*= true*/) {
    ScopedDeclarationState DeclarationState = null;
    try {
      assert (FormatTok.isOneOf(tok.TokenKind.l_brace, TokenType.TT_MacroBlockBegin)) : "'{' or macro block token expected";
      /*const*/boolean MacroBlock = FormatTok.is_TokenType(TokenType.TT_MacroBlockBegin);
      FormatTok.BlockKind = BraceBlockKind.BK_Block;
      
      /*uint*/int InitialLevel = Line.$arrow().Level;
      nextToken();
      if (MacroBlock && FormatTok.is_TokenKind(tok.TokenKind.l_paren)) {
        parseParens();
      }
      
      addUnwrappedLine();
      
      DeclarationState/*J*/= new ScopedDeclarationState(Line.$star(), DeclarationScopeStack, 
          MustBeDeclaration);
      if (AddLevel) {
        ++Line.$arrow().Level;
      }
      parseLevel(/*HasOpeningBrace=*/ true);
      if (eof()) {
        return;
      }
      if (MacroBlock ? !FormatTok.is_TokenType(TokenType.TT_MacroBlockEnd) : !FormatTok.is_TokenKind(tok.TokenKind.r_brace)) {
        Line.$arrow().Level = InitialLevel;
        FormatTok.BlockKind = BraceBlockKind.BK_Block;
        return;
      }
      
      nextToken(); // Munch the closing brace.
      if (MacroBlock && FormatTok.is_TokenKind(tok.TokenKind.l_paren)) {
        parseParens();
      }
      if (MunchSemi && FormatTok.Tok.is(tok.TokenKind.semi)) {
        nextToken();
      }
      Line.$arrow().Level = InitialLevel;
    } finally {
      if (DeclarationState != null) { DeclarationState.$destroy(); }
    }
  }


  //<editor-fold defaultstate="collapsed" desc="clang::format::UnwrappedLineParser::parseChildBlock">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/UnwrappedLineParser.cpp", line = 484,
   FQN="clang::format::UnwrappedLineParser::parseChildBlock", NM="_ZN5clang6format19UnwrappedLineParser15parseChildBlockEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/UnwrappedLineParser.cpp -nm=_ZN5clang6format19UnwrappedLineParser15parseChildBlockEv")
  //</editor-fold>
  private void parseChildBlock() {
    FormatTok.BlockKind = BraceBlockKind.BK_Block;
    nextToken();
    {
      ScopedLineState LineState = null;
      ScopedDeclarationState DeclarationState = null;
      try {
        boolean GoogScope = Style.Language == FormatStyle.LanguageKind.LK_JavaScript && isGoogScope(Line.$star());
        LineState/*J*/= new ScopedLineState(/*Deref*/this);
        DeclarationState/*J*/= new ScopedDeclarationState(Line.$star(), DeclarationScopeStack, 
            /*MustBeDeclaration=*/ false);
        Line.$arrow().Level += GoogScope ? 0 : 1;
        parseLevel(/*HasOpeningBrace=*/ true);
        flushComments(isOnNewLine(/*Deref*/FormatTok));
        Line.$arrow().Level -= GoogScope ? 0 : 1;
      } finally {
        if (DeclarationState != null) { DeclarationState.$destroy(); }
        if (LineState != null) { LineState.$destroy(); }
      }
    }
    nextToken();
  }


  //<editor-fold defaultstate="collapsed" desc="clang::format::UnwrappedLineParser::parsePPDirective">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/UnwrappedLineParser.cpp", line = 501,
   FQN="clang::format::UnwrappedLineParser::parsePPDirective", NM="_ZN5clang6format19UnwrappedLineParser16parsePPDirectiveEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/UnwrappedLineParser.cpp -nm=_ZN5clang6format19UnwrappedLineParser16parsePPDirectiveEv")
  //</editor-fold>
  private void parsePPDirective() {
    ScopedMacroState MacroState = null;
    try {
      assert (FormatTok.Tok.is(tok.TokenKind.hash)) : "'#' expected";
      type$ref<FormatTokenSource> Tokens_ref = new type$ref<FormatTokenSource>() {
        @Override
        public FormatTokenSource $deref() {
          return Tokens;
        }

        @Override
        public FormatTokenSource $set(FormatTokenSource value) {
          Tokens = value;
          return Tokens;
        }
      };
      type$ref<FormatToken> FormatTok_ref = new type$ref<FormatToken>() {
        @Override
        public FormatToken $deref() {
          return FormatTok;
        }

        @Override
        public FormatToken $set(FormatToken value) {
          FormatTok = value;
          return FormatTok;
        }
      };
      MacroState/*J*/= new ScopedMacroState(Line.$star(), Tokens_ref, FormatTok_ref);
      nextToken();
      if (!(FormatTok.Tok.getIdentifierInfo() != null)) {
        parsePPUnknown();
        return;
      }
      switch (FormatTok.Tok.getIdentifierInfo().getPPKeywordID()) {
       case tok.PPKeywordKind.pp_define:
        parsePPDefine();
        return;
       case tok.PPKeywordKind.pp_if:
        parsePPIf(/*IfDef=*/ false);
        break;
       case tok.PPKeywordKind.pp_ifdef:
       case tok.PPKeywordKind.pp_ifndef:
        parsePPIf(/*IfDef=*/ true);
        break;
       case tok.PPKeywordKind.pp_else:
        parsePPElse();
        break;
       case tok.PPKeywordKind.pp_elif:
        parsePPElIf();
        break;
       case tok.PPKeywordKind.pp_endif:
        parsePPEndIf();
        break;
       default:
        parsePPUnknown();
        break;
      }
    } finally {
      if (MacroState != null) { MacroState.$destroy(); }
    }
  }


  //<editor-fold defaultstate="collapsed" desc="clang::format::UnwrappedLineParser::parsePPDefine">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/UnwrappedLineParser.cpp", line = 606,
   FQN="clang::format::UnwrappedLineParser::parsePPDefine", NM="_ZN5clang6format19UnwrappedLineParser13parsePPDefineEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/UnwrappedLineParser.cpp -nm=_ZN5clang6format19UnwrappedLineParser13parsePPDefineEv")
  //</editor-fold>
  private void parsePPDefine() {
    nextToken();
    if (FormatTok.Tok.getKind() != tok.TokenKind.identifier) {
      parsePPUnknown();
      return;
    }
    nextToken();
    if (FormatTok.Tok.getKind() == tok.TokenKind.l_paren
       && $eq_SourceLocation$C(FormatTok.WhitespaceRange.getBegin(), 
        FormatTok.WhitespaceRange.getEnd())) {
      parseParens();
    }
    addUnwrappedLine();
    Line.$arrow().Level = 1;
    
    // Errors during a preprocessor directive can only affect the layout of the
    // preprocessor directive, and thus we ignore them. An alternative approach
    // would be to use the same approach we use on the file level (no
    // re-indentation if there was a structural error) within the macro
    // definition.
    parseFile();
  }


  //<editor-fold defaultstate="collapsed" desc="clang::format::UnwrappedLineParser::parsePPIf">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/UnwrappedLineParser.cpp", line = 583,
   FQN="clang::format::UnwrappedLineParser::parsePPIf", NM="_ZN5clang6format19UnwrappedLineParser9parsePPIfEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/UnwrappedLineParser.cpp -nm=_ZN5clang6format19UnwrappedLineParser9parsePPIfEb")
  //</editor-fold>
  private void parsePPIf(boolean IfDef) {
    nextToken();
    boolean IsLiteralFalse = (FormatTok.Tok.isLiteral()
       && $noteq_ptr(FormatTok.Tok.getLiteralData(), null)
       && $eq_StringRef(new StringRef(FormatTok.Tok.getLiteralData(), 
            FormatTok.Tok.getLength()), /*STRINGREF_STR*/"0"))
       || FormatTok.Tok.is(tok.TokenKind.kw_false);
    conditionalCompilationStart(!IfDef && IsLiteralFalse);
    parsePPUnknown();
  }


  //<editor-fold defaultstate="collapsed" desc="clang::format::UnwrappedLineParser::parsePPElIf">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/UnwrappedLineParser.cpp", line = 599,
   FQN="clang::format::UnwrappedLineParser::parsePPElIf", NM="_ZN5clang6format19UnwrappedLineParser11parsePPElIfEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/UnwrappedLineParser.cpp -nm=_ZN5clang6format19UnwrappedLineParser11parsePPElIfEv")
  //</editor-fold>
  private void parsePPElIf() {
    parsePPElse();
  }


  //<editor-fold defaultstate="collapsed" desc="clang::format::UnwrappedLineParser::parsePPElse">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/UnwrappedLineParser.cpp", line = 594,
   FQN="clang::format::UnwrappedLineParser::parsePPElse", NM="_ZN5clang6format19UnwrappedLineParser11parsePPElseEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/UnwrappedLineParser.cpp -nm=_ZN5clang6format19UnwrappedLineParser11parsePPElseEv")
  //</editor-fold>
  private void parsePPElse() {
    conditionalCompilationAlternative();
    parsePPUnknown();
  }


  //<editor-fold defaultstate="collapsed" desc="clang::format::UnwrappedLineParser::parsePPEndIf">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/UnwrappedLineParser.cpp", line = 601,
   FQN="clang::format::UnwrappedLineParser::parsePPEndIf", NM="_ZN5clang6format19UnwrappedLineParser12parsePPEndIfEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/UnwrappedLineParser.cpp -nm=_ZN5clang6format19UnwrappedLineParser12parsePPEndIfEv")
  //</editor-fold>
  private void parsePPEndIf() {
    conditionalCompilationEnd();
    parsePPUnknown();
  }


  //<editor-fold defaultstate="collapsed" desc="clang::format::UnwrappedLineParser::parsePPUnknown">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/UnwrappedLineParser.cpp", line = 630,
   FQN="clang::format::UnwrappedLineParser::parsePPUnknown", NM="_ZN5clang6format19UnwrappedLineParser14parsePPUnknownEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/UnwrappedLineParser.cpp -nm=_ZN5clang6format19UnwrappedLineParser14parsePPUnknownEv")
  //</editor-fold>
  private void parsePPUnknown() {
    do {
      nextToken();
    } while (!eof());
    addUnwrappedLine();
  }


  
  // readTokenWithJavaScriptASI reads the next token and terminates the current
  // line if JavaScript Automatic Semicolon Insertion must
  // happen between the current token and the next token.
  //
  // This method is conservative - it cannot cover all edge cases of JavaScript,
  // but only aims to correctly handle certain well known cases. It *must not*
  // return true in speculative cases.
  //<editor-fold defaultstate="collapsed" desc="clang::format::UnwrappedLineParser::readTokenWithJavaScriptASI">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/UnwrappedLineParser.cpp", line = 714,
   FQN="clang::format::UnwrappedLineParser::readTokenWithJavaScriptASI", NM="_ZN5clang6format19UnwrappedLineParser26readTokenWithJavaScriptASIEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/UnwrappedLineParser.cpp -nm=_ZN5clang6format19UnwrappedLineParser26readTokenWithJavaScriptASIEv")
  //</editor-fold>
  private void readTokenWithJavaScriptASI() {
    FormatToken /*P*/ Previous = FormatTok;
    readToken();
    FormatToken /*P*/ Next = FormatTok;
    
    boolean IsOnSameLine = CommentsBeforeNextToken.empty() ? Next.NewlinesBefore == 0 : CommentsBeforeNextToken.front().NewlinesBefore == 0;
    if (IsOnSameLine) {
      return;
    }
    
    boolean PreviousMustBeValue = mustBeJSIdentOrValue(Keywords, Previous);
    if (PreviousMustBeValue && Line.$bool() && $greater_uint(Line.$arrow().Tokens.size(), 1)) {
      // If the token before the previous one is an '@', the previous token is an
      // annotation and can precede another identifier/value.
      /*const*/ FormatToken /*P*/ PrePrevious = std.prev(Line.$arrow().Tokens.end(), 2).$arrow().Tok;
      if (PrePrevious.is_TokenKind(tok.TokenKind.at)) {
        return;
      }
    }
    if (Next.is_TokenKind(tok.TokenKind.exclaim) && PreviousMustBeValue) {
      addUnwrappedLine();
    }
    boolean NextMustBeValue = mustBeJSIdentOrValue(Keywords, Next);
    if (NextMustBeValue && (PreviousMustBeValue
       || Previous.isOneOf(tok.TokenKind.r_square, tok.TokenKind.r_paren, 
        tok.TokenKind.plusplus, tok.TokenKind.minusminus))) {
      addUnwrappedLine();
    }
    if (PreviousMustBeValue && isJSDeclOrStmt(Keywords, Next)) {
      addUnwrappedLine();
    }
  }


  //<editor-fold defaultstate="collapsed" desc="clang::format::UnwrappedLineParser::parseStructuralElement">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/UnwrappedLineParser.cpp", line = 745,
   FQN="clang::format::UnwrappedLineParser::parseStructuralElement", NM="_ZN5clang6format19UnwrappedLineParser22parseStructuralElementEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/UnwrappedLineParser.cpp -nm=_ZN5clang6format19UnwrappedLineParser22parseStructuralElementEv")
  //</editor-fold>
  private void parseStructuralElement() {
    assert (!FormatTok.is_TokenKind(tok.TokenKind.l_brace));
    if (Style.Language == FormatStyle.LanguageKind.LK_TableGen
       && FormatTok.is_PPKeywordKind(tok.PPKeywordKind.pp_include)) {
      nextToken();
      if (FormatTok.is_TokenKind(tok.TokenKind.string_literal)) {
        nextToken();
      }
      addUnwrappedLine();
      return;
    }
    switch (FormatTok.Tok.getKind()) {
     case tok.TokenKind.at:
      nextToken();
      if (FormatTok.Tok.is(tok.TokenKind.l_brace)) {
        parseBracedList();
        break;
      }
      switch (FormatTok.Tok.getObjCKeywordID()) {
       case tok.ObjCKeywordKind.objc_public:
       case tok.ObjCKeywordKind.objc_protected:
       case tok.ObjCKeywordKind.objc_package:
       case tok.ObjCKeywordKind.objc_private:
        parseAccessSpecifier();
        /*JAVA:return*/return;
       case tok.ObjCKeywordKind.objc_interface:
       case tok.ObjCKeywordKind.objc_implementation:
        parseObjCInterfaceOrImplementation();
        /*JAVA:return*/return;
       case tok.ObjCKeywordKind.objc_protocol:
        parseObjCProtocol();
        /*JAVA:return*/return;
       case tok.ObjCKeywordKind.objc_end:
        return; // Handled by the caller.
       case tok.ObjCKeywordKind.objc_optional:
       case tok.ObjCKeywordKind.objc_required:
        nextToken();
        addUnwrappedLine();
        return;
       case tok.ObjCKeywordKind.objc_autoreleasepool:
        nextToken();
        if (FormatTok.Tok.is(tok.TokenKind.l_brace)) {
          if (Style.BraceWrapping.AfterObjCDeclaration) {
            addUnwrappedLine();
          }
          parseBlock(/*MustBeDeclaration=*/ false);
        }
        addUnwrappedLine();
        return;
       case tok.ObjCKeywordKind.objc_try:
        // This branch isn't strictly necessary (the kw_try case below would
        // do this too after the tok::at is parsed above).  But be explicit.
        parseTryCatch();
        return;
       default:
        break;
      }
      break;
     case tok.TokenKind.kw_asm:
      nextToken();
      if (FormatTok.is_TokenKind(tok.TokenKind.l_brace)) {
        FormatTok.Type = TokenType.TT_InlineASMBrace;
        nextToken();
        while ((FormatTok != null) && FormatTok.isNot(tok.TokenKind.eof)) {
          if (FormatTok.is_TokenKind(tok.TokenKind.r_brace)) {
            FormatTok.Type = TokenType.TT_InlineASMBrace;
            nextToken();
            addUnwrappedLine();
            break;
          }
          FormatTok.Finalized = true;
          nextToken();
        }
      }
      break;
     case tok.TokenKind.kw_namespace:
      parseNamespace();
      return;
     case tok.TokenKind.kw_inline:
      nextToken();
      if (FormatTok.Tok.is(tok.TokenKind.kw_namespace)) {
        parseNamespace();
        return;
      }
      break;
     case tok.TokenKind.kw_public:
     case tok.TokenKind.kw_protected:
     case tok.TokenKind.kw_private:
      if (Style.Language == FormatStyle.LanguageKind.LK_Java
         || Style.Language == FormatStyle.LanguageKind.LK_JavaScript) {
        nextToken();
      } else {
        parseAccessSpecifier();
      }
      return;
     case tok.TokenKind.kw_if:
      parseIfThenElse();
      return;
     case tok.TokenKind.kw_for:
     case tok.TokenKind.kw_while:
      parseForOrWhileLoop();
      return;
     case tok.TokenKind.kw_do:
      parseDoWhile();
      return;
     case tok.TokenKind.kw_switch:
      parseSwitch();
      return;
     case tok.TokenKind.kw_default:
      nextToken();
      parseLabel();
      return;
     case tok.TokenKind.kw_case:
      parseCaseLabel();
      return;
     case tok.TokenKind.kw_try:
     case tok.TokenKind.kw___try:
      parseTryCatch();
      return;
     case tok.TokenKind.kw_extern:
      nextToken();
      if (FormatTok.Tok.is(tok.TokenKind.string_literal)) {
        nextToken();
        if (FormatTok.Tok.is(tok.TokenKind.l_brace)) {
          parseBlock(/*MustBeDeclaration=*/ true, /*AddLevel=*/ false);
          addUnwrappedLine();
          return;
        }
      }
      break;
     case tok.TokenKind.kw_export:
      if (Style.Language == FormatStyle.LanguageKind.LK_JavaScript) {
        parseJavaScriptEs6ImportExport();
        return;
      }
      break;
     case tok.TokenKind.identifier:
      if (FormatTok.is_TokenType(TokenType.TT_ForEachMacro)) {
        parseForOrWhileLoop();
        return;
      }
      if (FormatTok.is_TokenType(TokenType.TT_MacroBlockBegin)) {
        parseBlock(/*MustBeDeclaration=*/ false, /*AddLevel=*/ true, 
            /*MunchSemi=*/ false);
        return;
      }
      if (FormatTok.is(Keywords.kw_import)) {
        if (Style.Language == FormatStyle.LanguageKind.LK_JavaScript) {
          parseJavaScriptEs6ImportExport();
          return;
        }
        if (Style.Language == FormatStyle.LanguageKind.LK_Proto) {
          nextToken();
          if (FormatTok.is_TokenKind(tok.TokenKind.kw_public)) {
            nextToken();
          }
          if (!FormatTok.is_TokenKind(tok.TokenKind.string_literal)) {
            return;
          }
          nextToken();
          if (FormatTok.is_TokenKind(tok.TokenKind.semi)) {
            nextToken();
          }
          addUnwrappedLine();
          return;
        }
      }
      if (FormatTok.isOneOf(Keywords.kw_signals, Keywords.kw_qsignals, 
          Keywords.kw_slots, Keywords.kw_qslots)) {
        nextToken();
        if (FormatTok.is_TokenKind(tok.TokenKind.colon)) {
          nextToken();
          addUnwrappedLine();
        }
        return;
      }
      // In all other cases, parse the declaration.
      break;
     default:
      break;
    }
    do {
      /*const*/ FormatToken /*P*/ Previous = getPreviousToken();
      switch (FormatTok.Tok.getKind()) {
       case tok.TokenKind.at:
        nextToken();
        if (FormatTok.Tok.is(tok.TokenKind.l_brace)) {
          parseBracedList();
        }
        break;
       case tok.TokenKind.kw_enum:
        // Ignore if this is part of "template <enum ...".
        if ((Previous != null) && Previous.is_TokenKind(tok.TokenKind.less)) {
          nextToken();
          break;
        }
        
        // parseEnum falls through and does not yet add an unwrapped line as an
        // enum definition can start a structural element.
        if (!parseEnum()) {
          break;
        }
        // This only applies for C++.
        if (Style.Language != FormatStyle.LanguageKind.LK_Cpp) {
          addUnwrappedLine();
          return;
        }
        break;
       case tok.TokenKind.kw_typedef:
        nextToken();
        if (FormatTok.isOneOf(Keywords.kw_NS_ENUM, Keywords.kw_NS_OPTIONS, 
            Keywords.kw_CF_ENUM, Keywords.kw_CF_OPTIONS)) {
          parseEnum();
        }
        break;
       case tok.TokenKind.kw_struct:
       case tok.TokenKind.kw_union:
       case tok.TokenKind.kw_class:
        // parseRecord falls through and does not yet add an unwrapped line as a
        // record declaration or definition can start a structural element.
        parseRecord();
        // This does not apply for Java and JavaScript.
        if (Style.Language == FormatStyle.LanguageKind.LK_Java
           || Style.Language == FormatStyle.LanguageKind.LK_JavaScript) {
          if (FormatTok.is_TokenKind(tok.TokenKind.semi)) {
            nextToken();
          }
          addUnwrappedLine();
          return;
        }
        break;
       case tok.TokenKind.period:
        nextToken();
        // In Java, classes have an implicit static member "class".
        if (Style.Language == FormatStyle.LanguageKind.LK_Java && (FormatTok != null)
           && FormatTok.is_TokenKind(tok.TokenKind.kw_class)) {
          nextToken();
        }
        if (Style.Language == FormatStyle.LanguageKind.LK_JavaScript && (FormatTok != null)
           && (FormatTok.Tok.getIdentifierInfo() != null)) {
          // JavaScript only has pseudo keywords, all keywords are allowed to
          // appear in "IdentifierName" positions. See http://es5.github.io/#x7.6
          nextToken();
        }
        break;
       case tok.TokenKind.semi:
        nextToken();
        addUnwrappedLine();
        return;
       case tok.TokenKind.r_brace:
        addUnwrappedLine();
        return;
       case tok.TokenKind.l_paren:
        parseParens();
        break;
       case tok.TokenKind.kw_operator:
        nextToken();
        if (FormatTok.isBinaryOperator()) {
          nextToken();
        }
        break;
       case tok.TokenKind.caret:
        nextToken();
        if (FormatTok.Tok.isAnyIdentifier()
           || FormatTok.isSimpleTypeSpecifier()) {
          nextToken();
        }
        if (FormatTok.is_TokenKind(tok.TokenKind.l_paren)) {
          parseParens();
        }
        if (FormatTok.is_TokenKind(tok.TokenKind.l_brace)) {
          parseChildBlock();
        }
        break;
       case tok.TokenKind.l_brace:
        if (!tryToParseBracedList()) {
          // A block outside of parentheses must be the last part of a
          // structural element.
          // FIXME: Figure out cases where this is not true, and add projections
          // for them (the one we know is missing are lambdas).
          if (Style.BraceWrapping.AfterFunction) {
            addUnwrappedLine();
          }
          FormatTok.Type = TokenType.TT_FunctionLBrace;
          parseBlock(/*MustBeDeclaration=*/ false);
          addUnwrappedLine();
          return;
        }
        // Otherwise this was a braced init list, and the structural
        // element continues.
        break;
       case tok.TokenKind.kw_try:
        // We arrive here when parsing function-try blocks.
        parseTryCatch();
        return;
       case tok.TokenKind.identifier:
        {
          if (FormatTok.is_TokenType(TokenType.TT_MacroBlockEnd)) {
            addUnwrappedLine();
            return;
          }
          
          // Parse function literal unless 'function' is the first token in a line
          // in which case this should be treated as a free-standing function.
          if (Style.Language == FormatStyle.LanguageKind.LK_JavaScript
             && (FormatTok.is(Keywords.kw_function)
             || FormatTok.startsSequence(Keywords.kw_async, 
              Keywords.kw_function))
             && $greater_uint(Line.$arrow().Tokens.size(), 0)) {
            tryToParseJSFunction();
            break;
          }
          if ((Style.Language == FormatStyle.LanguageKind.LK_JavaScript
             || Style.Language == FormatStyle.LanguageKind.LK_Java)
             && FormatTok.is(Keywords.kw_interface)) {
            if (Style.Language == FormatStyle.LanguageKind.LK_JavaScript) {
              // In JavaScript/TypeScript, "interface" can be used as a standalone
              // identifier, e.g. in `var interface = 1;`. If "interface" is
              // followed by another identifier, it is very like to be an actual
              // interface declaration.
              /*uint*/int StoredPosition = Tokens.getPosition();
              FormatToken /*P*/ Next = Tokens.getNextToken();
              FormatTok = Tokens.setPosition(StoredPosition);
              if ((Next != null) && !mustBeJSIdent(Keywords, Next)) {
                nextToken();
                break;
              }
            }
            parseRecord();
            addUnwrappedLine();
            return;
          }
          
          // See if the following token should start a new unwrapped line.
          StringRef Text = new StringRef(FormatTok.TokenText);
          nextToken();
          if (Line.$arrow().Tokens.size() == 1
            // JS doesn't have macros, and within classes colons indicate fields,
            // not labels.
             && Style.Language != FormatStyle.LanguageKind.LK_JavaScript) {
            if (FormatTok.Tok.is(tok.TokenKind.colon) && !Line.$arrow().MustBeDeclaration) {
              Line.$arrow().Tokens.begin().$arrow().Tok.MustBreakBefore = true;
              parseLabel();
              return;
            }
            // Recognize function-like macro usages without trailing semicolon as
            // well as free-standing macros like Q_OBJECT.
            boolean FunctionLike = FormatTok.is_TokenKind(tok.TokenKind.l_paren);
            if (FunctionLike) {
              parseParens();
            }
            
            boolean FollowedByNewline = CommentsBeforeNextToken.empty() ? $greater_uint(FormatTok.NewlinesBefore, 0) : $greater_uint(CommentsBeforeNextToken.front().NewlinesBefore, 0);
            if (FollowedByNewline && ($greatereq_uint(Text.size(), 5) || FunctionLike)
               && tokenCanStartNewLine(FormatTok.Tok) && $eq_StringRef(/*NO_COPY*/Text, new StringRef(Text.upper()))) {
              addUnwrappedLine();
              return;
            }
          }
          break;
        }
       case tok.TokenKind.equal:
        // Fat arrows (=>) have tok::TokenKind tok::equal but TokenType
        // TT_JsFatArrow. The always start an expression or a child block if
        // followed by a curly.
        if (FormatTok.is_TokenType(TokenType.TT_JsFatArrow)) {
          nextToken();
          if (FormatTok.is_TokenKind(tok.TokenKind.l_brace)) {
            parseChildBlock();
          }
          break;
        }
        
        nextToken();
        if (FormatTok.Tok.is(tok.TokenKind.l_brace)) {
          parseBracedList();
        }
        break;
       case tok.TokenKind.l_square:
        parseSquare();
        break;
       case tok.TokenKind.kw_new:
        parseNew();
        break;
       default:
        nextToken();
        break;
      }
    } while (!eof());
  }


  //<editor-fold defaultstate="collapsed" desc="clang::format::UnwrappedLineParser::tryToParseBracedList">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/UnwrappedLineParser.cpp", line = 1255,
   FQN="clang::format::UnwrappedLineParser::tryToParseBracedList", NM="_ZN5clang6format19UnwrappedLineParser20tryToParseBracedListEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/UnwrappedLineParser.cpp -nm=_ZN5clang6format19UnwrappedLineParser20tryToParseBracedListEv")
  //</editor-fold>
  private boolean tryToParseBracedList() {
    if (FormatTok.BlockKind == BraceBlockKind.BK_Unknown) {
      calculateBraceTypes();
    }
    assert (FormatTok.BlockKind != BraceBlockKind.BK_Unknown);
    if (FormatTok.BlockKind == BraceBlockKind.BK_Block) {
      return false;
    }
    parseBracedList();
    return true;
  }


  //<editor-fold defaultstate="collapsed" desc="clang::format::UnwrappedLineParser::parseBracedList">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/UnwrappedLineParser.cpp", line = 1265,
   FQN="clang::format::UnwrappedLineParser::parseBracedList", NM="_ZN5clang6format19UnwrappedLineParser15parseBracedListEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/UnwrappedLineParser.cpp -nm=_ZN5clang6format19UnwrappedLineParser15parseBracedListEb")
  //</editor-fold>
  private boolean parseBracedList() {
    return parseBracedList(false);
  }
  private boolean parseBracedList(boolean ContinueOnSemicolons/*= false*/) {
    boolean HasError = false;
    nextToken();
    
    // FIXME: Once we have an expression parser in the UnwrappedLineParser,
    // replace this by using parseAssigmentExpression() inside.
    do {
      if (Style.Language == FormatStyle.LanguageKind.LK_JavaScript) {
        if (FormatTok.is(Keywords.kw_function)
           || FormatTok.startsSequence(Keywords.kw_async, Keywords.kw_function)) {
          tryToParseJSFunction();
          continue;
        }
        if (FormatTok.is_TokenType(TokenType.TT_JsFatArrow)) {
          nextToken();
          // Fat arrows can be followed by simple expressions or by child blocks
          // in curly braces.
          if (FormatTok.is_TokenKind(tok.TokenKind.l_brace)) {
            parseChildBlock();
            continue;
          }
        }
      }
      switch (FormatTok.Tok.getKind()) {
       case tok.TokenKind.caret:
        nextToken();
        if (FormatTok.is_TokenKind(tok.TokenKind.l_brace)) {
          parseChildBlock();
        }
        break;
       case tok.TokenKind.l_square:
        tryToParseLambda();
        break;
       case tok.TokenKind.l_brace:
        // Assume there are no blocks inside a braced init list apart
        // from the ones we explicitly parse out (like lambdas).
        FormatTok.BlockKind = BraceBlockKind.BK_BracedInit;
        parseBracedList();
        break;
       case tok.TokenKind.l_paren:
        parseParens();
        // JavaScript can just have free standing methods and getters/setters in
        // object literals. Detect them by a "{" following ")".
        if (Style.Language == FormatStyle.LanguageKind.LK_JavaScript) {
          if (FormatTok.is_TokenKind(tok.TokenKind.l_brace)) {
            parseChildBlock();
          }
          break;
        }
        break;
       case tok.TokenKind.r_brace:
        nextToken();
        return !HasError;
       case tok.TokenKind.semi:
        // JavaScript (or more precisely TypeScript) can have semicolons in braced
        // lists (in so-called TypeMemberLists). Thus, the semicolon cannot be
        // used for error recovery if we have otherwise determined that this is
        // a braced list.
        if (Style.Language == FormatStyle.LanguageKind.LK_JavaScript) {
          nextToken();
          break;
        }
        HasError = true;
        if (!ContinueOnSemicolons) {
          return !HasError;
        }
        nextToken();
        break;
       case tok.TokenKind.comma:
        nextToken();
        break;
       default:
        nextToken();
        break;
      }
    } while (!eof());
    return false;
  }


  //<editor-fold defaultstate="collapsed" desc="clang::format::UnwrappedLineParser::parseParens">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/UnwrappedLineParser.cpp", line = 1342,
   FQN="clang::format::UnwrappedLineParser::parseParens", NM="_ZN5clang6format19UnwrappedLineParser11parseParensEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/UnwrappedLineParser.cpp -nm=_ZN5clang6format19UnwrappedLineParser11parseParensEv")
  //</editor-fold>
  private void parseParens() {
    assert (FormatTok.Tok.is(tok.TokenKind.l_paren)) : "'(' expected.";
    nextToken();
    do {
      switch (FormatTok.Tok.getKind()) {
       case tok.TokenKind.l_paren:
        parseParens();
        if (Style.Language == FormatStyle.LanguageKind.LK_Java && FormatTok.is_TokenKind(tok.TokenKind.l_brace)) {
          parseChildBlock();
        }
        break;
       case tok.TokenKind.r_paren:
        nextToken();
        return;
       case tok.TokenKind.r_brace:
        // A "}" inside parenthesis is an error if there wasn't a matching "{".
        return;
       case tok.TokenKind.l_square:
        tryToParseLambda();
        break;
       case tok.TokenKind.l_brace:
        if (!tryToParseBracedList()) {
          parseChildBlock();
        }
        break;
       case tok.TokenKind.at:
        nextToken();
        if (FormatTok.Tok.is(tok.TokenKind.l_brace)) {
          parseBracedList();
        }
        break;
       case tok.TokenKind.identifier:
        if (Style.Language == FormatStyle.LanguageKind.LK_JavaScript
           && (FormatTok.is(Keywords.kw_function)
           || FormatTok.startsSequence(Keywords.kw_async, Keywords.kw_function))) {
          tryToParseJSFunction();
        } else {
          nextToken();
        }
        break;
       default:
        nextToken();
        break;
      }
    } while (!eof());
  }


  //<editor-fold defaultstate="collapsed" desc="clang::format::UnwrappedLineParser::parseSquare">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/UnwrappedLineParser.cpp", line = 1385,
   FQN="clang::format::UnwrappedLineParser::parseSquare", NM="_ZN5clang6format19UnwrappedLineParser11parseSquareEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/UnwrappedLineParser.cpp -nm=_ZN5clang6format19UnwrappedLineParser11parseSquareEv")
  //</editor-fold>
  private void parseSquare() {
    assert (FormatTok.Tok.is(tok.TokenKind.l_square)) : "'[' expected.";
    if (tryToParseLambda()) {
      return;
    }
    do {
      switch (FormatTok.Tok.getKind()) {
       case tok.TokenKind.l_paren:
        parseParens();
        break;
       case tok.TokenKind.r_square:
        nextToken();
        return;
       case tok.TokenKind.r_brace:
        // A "}" inside parenthesis is an error if there wasn't a matching "{".
        return;
       case tok.TokenKind.l_square:
        parseSquare();
        break;
       case tok.TokenKind.l_brace:
        {
          if (!tryToParseBracedList()) {
            parseChildBlock();
          }
          break;
        }
       case tok.TokenKind.at:
        nextToken();
        if (FormatTok.Tok.is(tok.TokenKind.l_brace)) {
          parseBracedList();
        }
        break;
       default:
        nextToken();
        break;
      }
    } while (!eof());
  }


  //<editor-fold defaultstate="collapsed" desc="clang::format::UnwrappedLineParser::parseIfThenElse">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/UnwrappedLineParser.cpp", line = 1420,
   FQN="clang::format::UnwrappedLineParser::parseIfThenElse", NM="_ZN5clang6format19UnwrappedLineParser15parseIfThenElseEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/UnwrappedLineParser.cpp -nm=_ZN5clang6format19UnwrappedLineParser15parseIfThenElseEv")
  //</editor-fold>
  private void parseIfThenElse() {
    assert (FormatTok.Tok.is(tok.TokenKind.kw_if)) : "'if' expected";
    nextToken();
    if (FormatTok.Tok.is(tok.TokenKind.l_paren)) {
      parseParens();
    }
    boolean NeedsUnwrappedLine = false;
    if (FormatTok.Tok.is(tok.TokenKind.l_brace)) {
      CompoundStatementIndenter Indenter = null;
      try {
        Indenter/*J*/= new CompoundStatementIndenter(this, Style, Line.$arrow().Level_ref);
        parseBlock(/*MustBeDeclaration=*/ false);
        if (Style.BraceWrapping.BeforeElse) {
          addUnwrappedLine();
        } else {
          NeedsUnwrappedLine = true;
        }
      } finally {
        if (Indenter != null) { Indenter.$destroy(); }
      }
    } else {
      addUnwrappedLine();
      ++Line.$arrow().Level;
      parseStructuralElement();
      --Line.$arrow().Level;
    }
    if (FormatTok.Tok.is(tok.TokenKind.kw_else)) {
      nextToken();
      if (FormatTok.Tok.is(tok.TokenKind.l_brace)) {
        CompoundStatementIndenter Indenter = null;
        try {
          Indenter/*J*/= new CompoundStatementIndenter(this, Style, Line.$arrow().Level_ref);
          parseBlock(/*MustBeDeclaration=*/ false);
          addUnwrappedLine();
        } finally {
          if (Indenter != null) { Indenter.$destroy(); }
        }
      } else if (FormatTok.Tok.is(tok.TokenKind.kw_if)) {
        parseIfThenElse();
      } else {
        addUnwrappedLine();
        ++Line.$arrow().Level;
        parseStructuralElement();
        if (FormatTok.is_TokenKind(tok.TokenKind.eof)) {
          addUnwrappedLine();
        }
        --Line.$arrow().Level;
      }
    } else if (NeedsUnwrappedLine) {
      addUnwrappedLine();
    }
  }


  //<editor-fold defaultstate="collapsed" desc="clang::format::UnwrappedLineParser::parseTryCatch">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/UnwrappedLineParser.cpp", line = 1460,
   FQN="clang::format::UnwrappedLineParser::parseTryCatch", NM="_ZN5clang6format19UnwrappedLineParser13parseTryCatchEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/UnwrappedLineParser.cpp -nm=_ZN5clang6format19UnwrappedLineParser13parseTryCatchEv")
  //</editor-fold>
  private void parseTryCatch() {
    assert (FormatTok.isOneOf(tok.TokenKind.kw_try, tok.TokenKind.kw___try)) : "'try' expected";
    nextToken();
    boolean NeedsUnwrappedLine = false;
    if (FormatTok.is_TokenKind(tok.TokenKind.colon)) {
      // We are in a function try block, what comes is an initializer list.
      nextToken();
      while (FormatTok.is_TokenKind(tok.TokenKind.identifier)) {
        nextToken();
        if (FormatTok.is_TokenKind(tok.TokenKind.l_paren)) {
          parseParens();
        }
        if (FormatTok.is_TokenKind(tok.TokenKind.comma)) {
          nextToken();
        }
      }
    }
    // Parse try with resource.
    if (Style.Language == FormatStyle.LanguageKind.LK_Java && FormatTok.is_TokenKind(tok.TokenKind.l_paren)) {
      parseParens();
    }
    if (FormatTok.is_TokenKind(tok.TokenKind.l_brace)) {
      CompoundStatementIndenter Indenter = null;
      try {
        Indenter/*J*/= new CompoundStatementIndenter(this, Style, Line.$arrow().Level_ref);
        parseBlock(/*MustBeDeclaration=*/ false);
        if (Style.BraceWrapping.BeforeCatch) {
          addUnwrappedLine();
        } else {
          NeedsUnwrappedLine = true;
        }
      } finally {
        if (Indenter != null) { Indenter.$destroy(); }
      }
    } else if (!FormatTok.is_TokenKind(tok.TokenKind.kw_catch)) {
      // The C++ standard requires a compound-statement after a try.
      // If there's none, we try to assume there's a structuralElement
      // and try to continue.
      addUnwrappedLine();
      ++Line.$arrow().Level;
      parseStructuralElement();
      --Line.$arrow().Level;
    }
    while (true) {
      CompoundStatementIndenter Indenter = null;
      try {
        if (FormatTok.is_TokenKind(tok.TokenKind.at)) {
          nextToken();
        }
        if (!(FormatTok.isOneOf(tok.TokenKind.kw_catch) ||FormatTok.isOneOf(Keywords.kw___except, 
            tok.TokenKind.kw___finally)
           || ((Style.Language == FormatStyle.LanguageKind.LK_Java
           || Style.Language == FormatStyle.LanguageKind.LK_JavaScript)
           && FormatTok.is(Keywords.kw_finally))
           || (FormatTok.Tok.isObjCAtKeyword(tok.ObjCKeywordKind.objc_catch)
           || FormatTok.Tok.isObjCAtKeyword(tok.ObjCKeywordKind.objc_finally)))) {
          break;
        }
        nextToken();
        while (FormatTok.isNot(tok.TokenKind.l_brace)) {
          if (FormatTok.is_TokenKind(tok.TokenKind.l_paren)) {
            parseParens();
            continue;
          }
          if (FormatTok.isOneOf(tok.TokenKind.semi, tok.TokenKind.r_brace, tok.TokenKind.eof)) {
            return;
          }
          nextToken();
        }
        NeedsUnwrappedLine = false;
        Indenter/*J*/= new CompoundStatementIndenter(this, Style, Line.$arrow().Level_ref);
        parseBlock(/*MustBeDeclaration=*/ false);
        if (Style.BraceWrapping.BeforeCatch) {
          addUnwrappedLine();
        } else {
          NeedsUnwrappedLine = true;
        }
      } finally {
        if (Indenter != null) { Indenter.$destroy(); }
      }
    }
    if (NeedsUnwrappedLine) {
      addUnwrappedLine();
    }
  }


  //<editor-fold defaultstate="collapsed" desc="clang::format::UnwrappedLineParser::parseForOrWhileLoop">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/UnwrappedLineParser.cpp", line = 1578,
   FQN="clang::format::UnwrappedLineParser::parseForOrWhileLoop", NM="_ZN5clang6format19UnwrappedLineParser19parseForOrWhileLoopEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/UnwrappedLineParser.cpp -nm=_ZN5clang6format19UnwrappedLineParser19parseForOrWhileLoopEv")
  //</editor-fold>
  private void parseForOrWhileLoop() {
    assert (FormatTok.isOneOf(tok.TokenKind.kw_for, tok.TokenKind.kw_while, TokenType.TT_ForEachMacro)) : "'for', 'while' or foreach macro expected";
    nextToken();
    if (FormatTok.Tok.is(tok.TokenKind.l_paren)) {
      parseParens();
    }
    if (FormatTok.Tok.is(tok.TokenKind.l_brace)) {
      CompoundStatementIndenter Indenter = null;
      try {
        Indenter/*J*/= new CompoundStatementIndenter(this, Style, Line.$arrow().Level_ref);
        parseBlock(/*MustBeDeclaration=*/ false);
        addUnwrappedLine();
      } finally {
        if (Indenter != null) { Indenter.$destroy(); }
      }
    } else {
      addUnwrappedLine();
      ++Line.$arrow().Level;
      parseStructuralElement();
      --Line.$arrow().Level;
    }
  }


  //<editor-fold defaultstate="collapsed" desc="clang::format::UnwrappedLineParser::parseDoWhile">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/UnwrappedLineParser.cpp", line = 1596,
   FQN="clang::format::UnwrappedLineParser::parseDoWhile", NM="_ZN5clang6format19UnwrappedLineParser12parseDoWhileEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/UnwrappedLineParser.cpp -nm=_ZN5clang6format19UnwrappedLineParser12parseDoWhileEv")
  //</editor-fold>
  private void parseDoWhile() {
    assert (FormatTok.Tok.is(tok.TokenKind.kw_do)) : "'do' expected";
    nextToken();
    if (FormatTok.Tok.is(tok.TokenKind.l_brace)) {
      CompoundStatementIndenter Indenter = null;
      try {
        Indenter/*J*/= new CompoundStatementIndenter(this, Style, Line.$arrow().Level_ref);
        parseBlock(/*MustBeDeclaration=*/ false);
        if (Style.BraceWrapping.IndentBraces) {
          addUnwrappedLine();
        }
      } finally {
        if (Indenter != null) { Indenter.$destroy(); }
      }
    } else {
      addUnwrappedLine();
      ++Line.$arrow().Level;
      parseStructuralElement();
      --Line.$arrow().Level;
    }
    
    // FIXME: Add error handling.
    if (!FormatTok.Tok.is(tok.TokenKind.kw_while)) {
      addUnwrappedLine();
      return;
    }
    
    nextToken();
    parseStructuralElement();
  }


  //<editor-fold defaultstate="collapsed" desc="clang::format::UnwrappedLineParser::parseLabel">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/UnwrappedLineParser.cpp", line = 1621,
   FQN="clang::format::UnwrappedLineParser::parseLabel", NM="_ZN5clang6format19UnwrappedLineParser10parseLabelEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/UnwrappedLineParser.cpp -nm=_ZN5clang6format19UnwrappedLineParser10parseLabelEv")
  //</editor-fold>
  private void parseLabel() {
    nextToken();
    /*uint*/int OldLineLevel = Line.$arrow().Level;
    if ($greater_uint(Line.$arrow().Level, 1) || (!Line.$arrow().InPPDirective && $greater_uint(Line.$arrow().Level, 0))) {
      --Line.$arrow().Level;
    }
    if (CommentsBeforeNextToken.empty() && FormatTok.Tok.is(tok.TokenKind.l_brace)) {
      CompoundStatementIndenter Indenter = null;
      try {
        Indenter/*J*/= new CompoundStatementIndenter(this, Style, Line.$arrow().Level_ref);
        parseBlock(/*MustBeDeclaration=*/ false);
        if (FormatTok.Tok.is(tok.TokenKind.kw_break)) {
          if (Style.BraceWrapping.AfterControlStatement) {
            addUnwrappedLine();
          }
          parseStructuralElement();
        }
        addUnwrappedLine();
      } finally {
        if (Indenter != null) { Indenter.$destroy(); }
      }
    } else {
      if (FormatTok.is_TokenKind(tok.TokenKind.semi)) {
        nextToken();
      }
      addUnwrappedLine();
    }
    Line.$arrow().Level = OldLineLevel;
    if (FormatTok.isNot(tok.TokenKind.l_brace)) {
      parseStructuralElement();
      addUnwrappedLine();
    }
  }


  //<editor-fold defaultstate="collapsed" desc="clang::format::UnwrappedLineParser::parseCaseLabel">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/UnwrappedLineParser.cpp", line = 1647,
   FQN="clang::format::UnwrappedLineParser::parseCaseLabel", NM="_ZN5clang6format19UnwrappedLineParser14parseCaseLabelEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/UnwrappedLineParser.cpp -nm=_ZN5clang6format19UnwrappedLineParser14parseCaseLabelEv")
  //</editor-fold>
  private void parseCaseLabel() {
    assert (FormatTok.Tok.is(tok.TokenKind.kw_case)) : "'case' expected";
    // FIXME: fix handling of complex expressions here.
    do {
      nextToken();
    } while (!eof() && !FormatTok.Tok.is(tok.TokenKind.colon));
    parseLabel();
  }


  //<editor-fold defaultstate="collapsed" desc="clang::format::UnwrappedLineParser::parseSwitch">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/UnwrappedLineParser.cpp", line = 1656,
   FQN="clang::format::UnwrappedLineParser::parseSwitch", NM="_ZN5clang6format19UnwrappedLineParser11parseSwitchEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/UnwrappedLineParser.cpp -nm=_ZN5clang6format19UnwrappedLineParser11parseSwitchEv")
  //</editor-fold>
  private void parseSwitch() {
    assert (FormatTok.Tok.is(tok.TokenKind.kw_switch)) : "'switch' expected";
    nextToken();
    if (FormatTok.Tok.is(tok.TokenKind.l_paren)) {
      parseParens();
    }
    if (FormatTok.Tok.is(tok.TokenKind.l_brace)) {
      CompoundStatementIndenter Indenter = null;
      try {
        Indenter/*J*/= new CompoundStatementIndenter(this, Style, Line.$arrow().Level_ref);
        parseBlock(/*MustBeDeclaration=*/ false);
        addUnwrappedLine();
      } finally {
        if (Indenter != null) { Indenter.$destroy(); }
      }
    } else {
      addUnwrappedLine();
      ++Line.$arrow().Level;
      parseStructuralElement();
      --Line.$arrow().Level;
    }
  }


  //<editor-fold defaultstate="collapsed" desc="clang::format::UnwrappedLineParser::parseNamespace">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/UnwrappedLineParser.cpp", line = 1529,
   FQN="clang::format::UnwrappedLineParser::parseNamespace", NM="_ZN5clang6format19UnwrappedLineParser14parseNamespaceEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/UnwrappedLineParser.cpp -nm=_ZN5clang6format19UnwrappedLineParser14parseNamespaceEv")
  //</editor-fold>
  private void parseNamespace() {
    assert (FormatTok.Tok.is(tok.TokenKind.kw_namespace)) : "'namespace' expected";
    
    final /*const*/ FormatToken /*&*/ InitialToken = /*Deref*/FormatTok;
    nextToken();
    while (FormatTok.isOneOf(tok.TokenKind.identifier, tok.TokenKind.coloncolon)) {
      nextToken();
    }
    if (FormatTok.Tok.is(tok.TokenKind.l_brace)) {
      if (ShouldBreakBeforeBrace(Style, InitialToken)) {
        addUnwrappedLine();
      }
      
      boolean AddLevel = Style.NamespaceIndentation == FormatStyle.NamespaceIndentationKind.NI_All
         || (Style.NamespaceIndentation == FormatStyle.NamespaceIndentationKind.NI_Inner
         && $greater_uint(DeclarationScopeStack.size(), 1));
      parseBlock(/*MustBeDeclaration=*/ true, AddLevel);
      // Munch the semicolon after a namespace. This is more common than one would
      // think. Puttin the semicolon into its own line is very ugly.
      if (FormatTok.Tok.is(tok.TokenKind.semi)) {
        nextToken();
      }
      addUnwrappedLine();
    }
    // FIXME: Add error handling.
  }


  //<editor-fold defaultstate="collapsed" desc="clang::format::UnwrappedLineParser::parseNew">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/UnwrappedLineParser.cpp", line = 1553,
   FQN="clang::format::UnwrappedLineParser::parseNew", NM="_ZN5clang6format19UnwrappedLineParser8parseNewEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/UnwrappedLineParser.cpp -nm=_ZN5clang6format19UnwrappedLineParser8parseNewEv")
  //</editor-fold>
  private void parseNew() {
    assert (FormatTok.is_TokenKind(tok.TokenKind.kw_new)) : "'new' expected";
    nextToken();
    if (Style.Language != FormatStyle.LanguageKind.LK_Java) {
      return;
    }
    
    // In Java, we can parse everything up to the parens, which aren't optional.
    do {
      // There should not be a ;, { or } before the new's open paren.
      if (FormatTok.isOneOf(tok.TokenKind.semi, tok.TokenKind.l_brace, tok.TokenKind.r_brace)) {
        return;
      }
      
      // Consume the parens.
      if (FormatTok.is_TokenKind(tok.TokenKind.l_paren)) {
        parseParens();
        
        // If there is a class body of an anonymous class, consume that as child.
        if (FormatTok.is_TokenKind(tok.TokenKind.l_brace)) {
          parseChildBlock();
        }
        return;
      }
      nextToken();
    } while (!eof());
  }


  //<editor-fold defaultstate="collapsed" desc="clang::format::UnwrappedLineParser::parseAccessSpecifier">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/UnwrappedLineParser.cpp", line = 1673,
   FQN="clang::format::UnwrappedLineParser::parseAccessSpecifier", NM="_ZN5clang6format19UnwrappedLineParser20parseAccessSpecifierEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/UnwrappedLineParser.cpp -nm=_ZN5clang6format19UnwrappedLineParser20parseAccessSpecifierEv")
  //</editor-fold>
  private void parseAccessSpecifier() {
    nextToken();
    // Understand Qt's slots.
    if (FormatTok.isOneOf(Keywords.kw_slots, Keywords.kw_qslots)) {
      nextToken();
    }
    // Otherwise, we don't know what it is, and we'd better keep the next token.
    if (FormatTok.Tok.is(tok.TokenKind.colon)) {
      nextToken();
    }
    addUnwrappedLine();
  }


  //<editor-fold defaultstate="collapsed" desc="clang::format::UnwrappedLineParser::parseEnum">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/UnwrappedLineParser.cpp", line = 1684,
   FQN="clang::format::UnwrappedLineParser::parseEnum", NM="_ZN5clang6format19UnwrappedLineParser9parseEnumEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/UnwrappedLineParser.cpp -nm=_ZN5clang6format19UnwrappedLineParser9parseEnumEv")
  //</editor-fold>
  private boolean parseEnum() {
    // Won't be 'enum' for NS_ENUMs.
    if (FormatTok.Tok.is(tok.TokenKind.kw_enum)) {
      nextToken();
    }
    
    // In TypeScript, "enum" can also be used as property name, e.g. in interface
    // declarations. An "enum" keyword followed by a colon would be a syntax
    // error and thus assume it is just an identifier.
    if (Style.Language == FormatStyle.LanguageKind.LK_JavaScript
       && FormatTok.isOneOf(tok.TokenKind.colon, tok.TokenKind.question)) {
      return false;
    }
    
    // Eat up enum class ...
    if (FormatTok.Tok.is(tok.TokenKind.kw_class) || FormatTok.Tok.is(tok.TokenKind.kw_struct)) {
      nextToken();
    }
    while ((FormatTok.Tok.getIdentifierInfo() != null)
       || FormatTok.isOneOf(tok.TokenKind.colon, tok.TokenKind.coloncolon, tok.TokenKind.less, 
        tok.TokenKind.greater, tok.TokenKind.comma, tok.TokenKind.question)) {
      nextToken();
      // We can have macros or attributes in between 'enum' and the enum name.
      if (FormatTok.is_TokenKind(tok.TokenKind.l_paren)) {
        parseParens();
      }
      if (FormatTok.is_TokenKind(tok.TokenKind.identifier)) {
        nextToken();
        // If there are two identifiers in a row, this is likely an elaborate
        // return type. In Java, this can be "implements", etc.
        if (Style.Language == FormatStyle.LanguageKind.LK_Cpp
           && FormatTok.is_TokenKind(tok.TokenKind.identifier)) {
          return false;
        }
      }
    }
    
    // Just a declaration or something is wrong.
    if (FormatTok.isNot(tok.TokenKind.l_brace)) {
      return true;
    }
    FormatTok.BlockKind = BraceBlockKind.BK_Block;
    if (Style.Language == FormatStyle.LanguageKind.LK_Java) {
      // Java enums are different.
      parseJavaEnumBody();
      return true;
    }
    if (Style.Language == FormatStyle.LanguageKind.LK_Proto) {
      parseBlock(/*MustBeDeclaration=*/ true);
      return true;
    }
    
    // Parse enum body.
    boolean HasError = !parseBracedList(/*ContinueOnSemicolons=*/ true);
    if (HasError) {
      if (FormatTok.is_TokenKind(tok.TokenKind.semi)) {
        nextToken();
      }
      addUnwrappedLine();
    }
    return true;
    // There is no addUnwrappedLine() here so that we fall through to parsing a
    // structural element afterwards. Thus, in "enum A {} n, m;",
    // "} n, m;" will end up in one unwrapped line.
  }


  //<editor-fold defaultstate="collapsed" desc="clang::format::UnwrappedLineParser::parseJavaEnumBody">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/UnwrappedLineParser.cpp", line = 1746,
   FQN="clang::format::UnwrappedLineParser::parseJavaEnumBody", NM="_ZN5clang6format19UnwrappedLineParser17parseJavaEnumBodyEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/UnwrappedLineParser.cpp -nm=_ZN5clang6format19UnwrappedLineParser17parseJavaEnumBodyEv")
  //</editor-fold>
  private void parseJavaEnumBody() {
    // Determine whether the enum is simple, i.e. does not have a semicolon or
    // constants with class bodies. Simple enums can be formatted like braced
    // lists, contracted to a single line, etc.
    /*uint*/int StoredPosition = Tokens.getPosition();
    boolean IsSimple = true;
    FormatToken /*P*/ Tok = Tokens.getNextToken();
    while ((Tok != null)) {
      if (Tok.is_TokenKind(tok.TokenKind.r_brace)) {
        break;
      }
      if (Tok.isOneOf(tok.TokenKind.l_brace, tok.TokenKind.semi)) {
        IsSimple = false;
        break;
      }
      // FIXME: This will also mark enums with braces in the arguments to enum
      // constants as "not simple". This is probably fine in practice, though.
      Tok = Tokens.getNextToken();
    }
    FormatTok = Tokens.setPosition(StoredPosition);
    if (IsSimple) {
      parseBracedList();
      addUnwrappedLine();
      return;
    }
    
    // Parse the body of a more complex enum.
    // First add a line for everything up to the "{".
    nextToken();
    addUnwrappedLine();
    ++Line.$arrow().Level;
    
    // Parse the enum constants.
    while ((FormatTok != null)) {
      if (FormatTok.is_TokenKind(tok.TokenKind.l_brace)) {
        // Parse the constant's class body.
        parseBlock(/*MustBeDeclaration=*/ true, /*AddLevel=*/ true, 
            /*MunchSemi=*/ false);
      } else if (FormatTok.is_TokenKind(tok.TokenKind.l_paren)) {
        parseParens();
      } else if (FormatTok.is_TokenKind(tok.TokenKind.comma)) {
        nextToken();
        addUnwrappedLine();
      } else if (FormatTok.is_TokenKind(tok.TokenKind.semi)) {
        nextToken();
        addUnwrappedLine();
        break;
      } else if (FormatTok.is_TokenKind(tok.TokenKind.r_brace)) {
        addUnwrappedLine();
        break;
      } else {
        nextToken();
      }
    }
    
    // Parse the class body after the enum's ";" if any.
    parseLevel(/*HasOpeningBrace=*/ true);
    nextToken();
    --Line.$arrow().Level;
    addUnwrappedLine();
  }


  //<editor-fold defaultstate="collapsed" desc="clang::format::UnwrappedLineParser::parseRecord">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/UnwrappedLineParser.cpp", line = 1808,
   FQN="clang::format::UnwrappedLineParser::parseRecord", NM="_ZN5clang6format19UnwrappedLineParser11parseRecordEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/UnwrappedLineParser.cpp -nm=_ZN5clang6format19UnwrappedLineParser11parseRecordEv")
  //</editor-fold>
  private void parseRecord() {
    final /*const*/ FormatToken /*&*/ InitialToken = /*Deref*/FormatTok;
    nextToken();
    
    // The actual identifier can be a nested name specifier, and in macros
    // it is often token-pasted.
    while (FormatTok.isOneOf(tok.TokenKind.identifier, tok.TokenKind.coloncolon, tok.TokenKind.hashhash, 
        tok.TokenKind.kw___attribute, tok.TokenKind.kw___declspec, 
        tok.TokenKind.kw_alignas)
       || ((Style.Language == FormatStyle.LanguageKind.LK_Java
       || Style.Language == FormatStyle.LanguageKind.LK_JavaScript)
       && FormatTok.isOneOf(tok.TokenKind.period, tok.TokenKind.comma))) {
      boolean IsNonMacroIdentifier = FormatTok.is_TokenKind(tok.TokenKind.identifier)
         && $noteq_StringRef(/*NO_COPY*/FormatTok.TokenText, new StringRef(FormatTok.TokenText.upper()));
      nextToken();
      // We can have macros or attributes in between 'class' and the class name.
      if (!IsNonMacroIdentifier && FormatTok.Tok.is(tok.TokenKind.l_paren)) {
        parseParens();
      }
    }
    
    // Note that parsing away template declarations here leads to incorrectly
    // accepting function declarations as record declarations.
    // In general, we cannot solve this problem. Consider:
    // class A<int> B() {}
    // which can be a function definition or a class definition when B() is a
    // macro. If we find enough real-world cases where this is a problem, we
    // can parse for the 'template' keyword in the beginning of the statement,
    // and thus rule out the record production in case there is no template
    // (this would still leave us with an ambiguity between template function
    // and class declarations).
    if (FormatTok.isOneOf(tok.TokenKind.colon, tok.TokenKind.less)) {
      while (!eof()) {
        if (FormatTok.is_TokenKind(tok.TokenKind.l_brace)) {
          calculateBraceTypes(/*ExpectClassBody=*/ true);
          if (!tryToParseBracedList()) {
            break;
          }
        }
        if (FormatTok.Tok.is(tok.TokenKind.semi)) {
          return;
        }
        nextToken();
      }
    }
    if (FormatTok.Tok.is(tok.TokenKind.l_brace)) {
      if (ShouldBreakBeforeBrace(Style, InitialToken)) {
        addUnwrappedLine();
      }
      
      parseBlock(/*MustBeDeclaration=*/ true, /*AddLevel=*/ true, 
          /*MunchSemi=*/ false);
    }
    // There is no addUnwrappedLine() here so that we fall through to parsing a
    // structural element afterwards. Thus, in "class A {} n, m;",
    // "} n, m;" will end up in one unwrapped line.
  }


  //<editor-fold defaultstate="collapsed" desc="clang::format::UnwrappedLineParser::parseObjCProtocolList">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/UnwrappedLineParser.cpp", line = 1863,
   FQN="clang::format::UnwrappedLineParser::parseObjCProtocolList", NM="_ZN5clang6format19UnwrappedLineParser21parseObjCProtocolListEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/UnwrappedLineParser.cpp -nm=_ZN5clang6format19UnwrappedLineParser21parseObjCProtocolListEv")
  //</editor-fold>
  private void parseObjCProtocolList() {
    assert (FormatTok.Tok.is(tok.TokenKind.less)) : "'<' expected.";
    do  {
      nextToken();
    } while (!eof() && FormatTok.Tok.isNot(tok.TokenKind.greater));
    nextToken(); // Skip '>'.
  }


  //<editor-fold defaultstate="collapsed" desc="clang::format::UnwrappedLineParser::parseObjCUntilAtEnd">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/UnwrappedLineParser.cpp", line = 1871,
   FQN="clang::format::UnwrappedLineParser::parseObjCUntilAtEnd", NM="_ZN5clang6format19UnwrappedLineParser19parseObjCUntilAtEndEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/UnwrappedLineParser.cpp -nm=_ZN5clang6format19UnwrappedLineParser19parseObjCUntilAtEndEv")
  //</editor-fold>
  private void parseObjCUntilAtEnd() {
    do {
      if (FormatTok.Tok.isObjCAtKeyword(tok.ObjCKeywordKind.objc_end)) {
        nextToken();
        addUnwrappedLine();
        break;
      }
      if (FormatTok.is_TokenKind(tok.TokenKind.l_brace)) {
        parseBlock(/*MustBeDeclaration=*/ false);
        // In ObjC interfaces, nothing should be following the "}".
        addUnwrappedLine();
      } else if (FormatTok.is_TokenKind(tok.TokenKind.r_brace)) {
        // Ignore stray "}". parseStructuralElement doesn't consume them.
        nextToken();
        addUnwrappedLine();
      } else {
        parseStructuralElement();
      }
    } while (!eof());
  }


  //<editor-fold defaultstate="collapsed" desc="clang::format::UnwrappedLineParser::parseObjCInterfaceOrImplementation">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/UnwrappedLineParser.cpp", line = 1892,
   FQN="clang::format::UnwrappedLineParser::parseObjCInterfaceOrImplementation", NM="_ZN5clang6format19UnwrappedLineParser34parseObjCInterfaceOrImplementationEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/UnwrappedLineParser.cpp -nm=_ZN5clang6format19UnwrappedLineParser34parseObjCInterfaceOrImplementationEv")
  //</editor-fold>
  private void parseObjCInterfaceOrImplementation() {
    nextToken();
    nextToken(); // interface name
    
    // @interface can be followed by either a base class, or a category.
    if (FormatTok.Tok.is(tok.TokenKind.colon)) {
      nextToken();
      nextToken(); // base class name
    } else if (FormatTok.Tok.is(tok.TokenKind.l_paren)) {
      // Skip category, if present.
      parseParens();
    }
    if (FormatTok.Tok.is(tok.TokenKind.less)) {
      parseObjCProtocolList();
    }
    if (FormatTok.Tok.is(tok.TokenKind.l_brace)) {
      if (Style.BraceWrapping.AfterObjCDeclaration) {
        addUnwrappedLine();
      }
      parseBlock(/*MustBeDeclaration=*/ true);
    }
    
    // With instance variables, this puts '}' on its own line.  Without instance
    // variables, this ends the @interface line.
    addUnwrappedLine();
    
    parseObjCUntilAtEnd();
  }


  //<editor-fold defaultstate="collapsed" desc="clang::format::UnwrappedLineParser::parseObjCProtocol">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/UnwrappedLineParser.cpp", line = 1920,
   FQN="clang::format::UnwrappedLineParser::parseObjCProtocol", NM="_ZN5clang6format19UnwrappedLineParser17parseObjCProtocolEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/UnwrappedLineParser.cpp -nm=_ZN5clang6format19UnwrappedLineParser17parseObjCProtocolEv")
  //</editor-fold>
  private void parseObjCProtocol() {
    nextToken();
    nextToken(); // protocol name
    if (FormatTok.Tok.is(tok.TokenKind.less)) {
      parseObjCProtocolList();
    }
    
    // Check for protocol declaration.
    if (FormatTok.Tok.is(tok.TokenKind.semi)) {
      nextToken();
      addUnwrappedLine();
      /*JAVA:return*/return;
    }
    
    addUnwrappedLine();
    parseObjCUntilAtEnd();
  }


  //<editor-fold defaultstate="collapsed" desc="clang::format::UnwrappedLineParser::parseJavaScriptEs6ImportExport">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/UnwrappedLineParser.cpp", line = 1937,
   FQN="clang::format::UnwrappedLineParser::parseJavaScriptEs6ImportExport", NM="_ZN5clang6format19UnwrappedLineParser30parseJavaScriptEs6ImportExportEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/UnwrappedLineParser.cpp -nm=_ZN5clang6format19UnwrappedLineParser30parseJavaScriptEs6ImportExportEv")
  //</editor-fold>
  private void parseJavaScriptEs6ImportExport() {
    boolean IsImport = FormatTok.is(Keywords.kw_import);
    assert (IsImport || FormatTok.is_TokenKind(tok.TokenKind.kw_export));
    nextToken();
    
    // Consume the "default" in "export default class/function".
    if (FormatTok.is_TokenKind(tok.TokenKind.kw_default)) {
      nextToken();
    }
    
    // Consume "async function", "function" and "default function", so that these
    // get parsed as free-standing JS functions, i.e. do not require a trailing
    // semicolon.
    if (FormatTok.is(Keywords.kw_async)) {
      nextToken();
    }
    if (FormatTok.is(Keywords.kw_function)) {
      nextToken();
      return;
    }
    
    // For imports, `export *`, `export {...}`, consume the rest of the line up
    // to the terminating `;`. For everything else, just return and continue
    // parsing the structural element, i.e. the declaration or expression for
    // `export default`.
    if (!IsImport && !FormatTok.isOneOf(tok.TokenKind.l_brace, tok.TokenKind.star)
       && !FormatTok.isStringLiteral()) {
      return;
    }
    while (!eof() && FormatTok.isNot(tok.TokenKind.semi)) {
      if (FormatTok.is_TokenKind(tok.TokenKind.l_brace)) {
        FormatTok.BlockKind = BraceBlockKind.BK_Block;
        parseBracedList();
      } else {
        nextToken();
      }
    }
  }


  //<editor-fold defaultstate="collapsed" desc="clang::format::UnwrappedLineParser::tryToParseLambda">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/UnwrappedLineParser.cpp", line = 1117,
   FQN="clang::format::UnwrappedLineParser::tryToParseLambda", NM="_ZN5clang6format19UnwrappedLineParser16tryToParseLambdaEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/UnwrappedLineParser.cpp -nm=_ZN5clang6format19UnwrappedLineParser16tryToParseLambdaEv")
  //</editor-fold>
  private boolean tryToParseLambda() {
    if (Style.Language != FormatStyle.LanguageKind.LK_Cpp) {
      nextToken();
      return false;
    }
    /*const*/ FormatToken /*P*/ Previous = getPreviousToken();
    if ((Previous != null)
       && (Previous.isOneOf(tok.TokenKind.identifier, tok.TokenKind.kw_operator, tok.TokenKind.kw_new, 
        tok.TokenKind.kw_delete)
       || Previous.closesScope() || Previous.isSimpleTypeSpecifier())) {
      nextToken();
      return false;
    }
    assert (FormatTok.is_TokenKind(tok.TokenKind.l_square));
    final FormatToken /*&*/ LSquare = /*Deref*/FormatTok;
    if (!tryToParseLambdaIntroducer()) {
      return false;
    }
    while (FormatTok.isNot(tok.TokenKind.l_brace)) {
      if (FormatTok.isSimpleTypeSpecifier()) {
        nextToken();
        continue;
      }
      switch (FormatTok.Tok.getKind()) {
       case tok.TokenKind.l_brace:
        break;
       case tok.TokenKind.l_paren:
        parseParens();
        break;
       case tok.TokenKind.amp:
       case tok.TokenKind.star:
       case tok.TokenKind.kw_const:
       case tok.TokenKind.comma:
       case tok.TokenKind.less:
       case tok.TokenKind.greater:
       case tok.TokenKind.identifier:
       case tok.TokenKind.numeric_constant:
       case tok.TokenKind.coloncolon:
       case tok.TokenKind.kw_mutable:
        nextToken();
        break;
       case tok.TokenKind.arrow:
        FormatTok.Type = TokenType.TT_LambdaArrow;
        nextToken();
        break;
       default:
        return true;
      }
    }
    LSquare.Type = TokenType.TT_LambdaLSquare;
    parseChildBlock();
    return true;
  }


  //<editor-fold defaultstate="collapsed" desc="clang::format::UnwrappedLineParser::tryToParseLambdaIntroducer">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/UnwrappedLineParser.cpp", line = 1171,
   FQN="clang::format::UnwrappedLineParser::tryToParseLambdaIntroducer", NM="_ZN5clang6format19UnwrappedLineParser26tryToParseLambdaIntroducerEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/UnwrappedLineParser.cpp -nm=_ZN5clang6format19UnwrappedLineParser26tryToParseLambdaIntroducerEv")
  //</editor-fold>
  private boolean tryToParseLambdaIntroducer() {
    nextToken();
    if (FormatTok.is_TokenKind(tok.TokenKind.equal)) {
      nextToken();
      if (FormatTok.is_TokenKind(tok.TokenKind.r_square)) {
        nextToken();
        return true;
      }
      if (FormatTok.isNot(tok.TokenKind.comma)) {
        return false;
      }
      nextToken();
    } else if (FormatTok.is_TokenKind(tok.TokenKind.amp)) {
      nextToken();
      if (FormatTok.is_TokenKind(tok.TokenKind.r_square)) {
        nextToken();
        return true;
      }
      if (!FormatTok.isOneOf(tok.TokenKind.comma, tok.TokenKind.identifier)) {
        return false;
      }
      if (FormatTok.is_TokenKind(tok.TokenKind.comma)) {
        nextToken();
      }
    } else if (FormatTok.is_TokenKind(tok.TokenKind.r_square)) {
      nextToken();
      return true;
    }
    do {
      if (FormatTok.is_TokenKind(tok.TokenKind.amp)) {
        nextToken();
      }
      if (!FormatTok.isOneOf(tok.TokenKind.identifier, tok.TokenKind.kw_this)) {
        return false;
      }
      nextToken();
      if (FormatTok.is_TokenKind(tok.TokenKind.ellipsis)) {
        nextToken();
      }
      if (FormatTok.is_TokenKind(tok.TokenKind.comma)) {
        nextToken();
      } else if (FormatTok.is_TokenKind(tok.TokenKind.r_square)) {
        nextToken();
        return true;
      } else {
        return false;
      }
    } while (!eof());
    return false;
  }


  //<editor-fold defaultstate="collapsed" desc="clang::format::UnwrappedLineParser::tryToParseJSFunction">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/UnwrappedLineParser.cpp", line = 1217,
   FQN="clang::format::UnwrappedLineParser::tryToParseJSFunction", NM="_ZN5clang6format19UnwrappedLineParser20tryToParseJSFunctionEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/UnwrappedLineParser.cpp -nm=_ZN5clang6format19UnwrappedLineParser20tryToParseJSFunctionEv")
  //</editor-fold>
  private void tryToParseJSFunction() {
    assert (FormatTok.is(Keywords.kw_function) || FormatTok.startsSequence(Keywords.kw_async, Keywords.kw_function));
    if (FormatTok.is(Keywords.kw_async)) {
      nextToken();
    }
    // Consume "function".
    nextToken();
    
    // Consume * (generator function).
    if (FormatTok.is_TokenKind(tok.TokenKind.star)) {
      nextToken();
    }
    
    // Consume function name.
    if (FormatTok.is_TokenKind(tok.TokenKind.identifier)) {
      nextToken();
    }
    if (FormatTok.isNot(tok.TokenKind.l_paren)) {
      return;
    }
    
    // Parse formal parameter list.
    parseParens();
    if (FormatTok.is_TokenKind(tok.TokenKind.colon)) {
      // Parse a type definition.
      nextToken();
      
      // Eat the type declaration. For braced inline object types, balance braces,
      // otherwise just parse until finding an l_brace for the function body.
      if (FormatTok.is_TokenKind(tok.TokenKind.l_brace)) {
        tryToParseBracedList();
      } else {
        while (FormatTok.isNot(tok.TokenKind.l_brace) && !eof()) {
          nextToken();
        }
      }
    }
    
    parseChildBlock();
  }


  //<editor-fold defaultstate="collapsed" desc="clang::format::UnwrappedLineParser::addUnwrappedLine">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*why I removed push_back_T$RR? */,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/UnwrappedLineParser.cpp", line = 1997,
   FQN="clang::format::UnwrappedLineParser::addUnwrappedLine", NM="_ZN5clang6format19UnwrappedLineParser16addUnwrappedLineEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/UnwrappedLineParser.cpp -nm=_ZN5clang6format19UnwrappedLineParser16addUnwrappedLineEv")
  //</editor-fold>
  /*friend*/public/*private*/ void addUnwrappedLine() {
    if (Line.$arrow().Tokens.empty()) {
      return;
    }
    do {
      if (/*::*/llvm.DebugFlag && /*::*/llvm.isCurrentDebugType(/*KEEP_STR*/"format-parser")) {
        {
          if (CurrentLines == /*AddrOf*/Lines) {
            printDebugInfo(Line.$star());
          }
        }
        ;
      }
    } while (false);
    CurrentLines.push_back_T$RR(std.move(Line.$star()));
    // JAVA: why after move object's fields are used?
    Line.$arrow().Tokens.clear();
    if (CurrentLines == /*AddrOf*/Lines && !PreprocessorDirectives.empty()) {
      CurrentLines.append_T(std.make_move_iterator(PreprocessorDirectives.begin()), 
          std.make_move_iterator(PreprocessorDirectives.end()));
      PreprocessorDirectives.clear();
    }
  }


  //<editor-fold defaultstate="collapsed" desc="clang::format::UnwrappedLineParser::eof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/UnwrappedLineParser.cpp", line = 2014,
   FQN="clang::format::UnwrappedLineParser::eof", NM="_ZNK5clang6format19UnwrappedLineParser3eofEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/UnwrappedLineParser.cpp -nm=_ZNK5clang6format19UnwrappedLineParser3eofEv")
  //</editor-fold>
  private boolean eof() /*const*/ {
    return FormatTok.Tok.is(tok.TokenKind.eof);
  }


  //<editor-fold defaultstate="collapsed" desc="clang::format::UnwrappedLineParser::nextToken">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/UnwrappedLineParser.cpp", line = 2036,
   FQN="clang::format::UnwrappedLineParser::nextToken", NM="_ZN5clang6format19UnwrappedLineParser9nextTokenEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/UnwrappedLineParser.cpp -nm=_ZN5clang6format19UnwrappedLineParser9nextTokenEv")
  //</editor-fold>
  private void nextToken() {
    if (eof()) {
      return;
    }
    flushComments(isOnNewLine(/*Deref*/FormatTok));
    pushToken(FormatTok);
    if (Style.Language != FormatStyle.LanguageKind.LK_JavaScript) {
      readToken();
    } else {
      readTokenWithJavaScriptASI();
    }
  }


  //<editor-fold defaultstate="collapsed" desc="clang::format::UnwrappedLineParser::getPreviousToken">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/UnwrappedLineParser.cpp", line = 2047,
   FQN="clang::format::UnwrappedLineParser::getPreviousToken", NM="_ZN5clang6format19UnwrappedLineParser16getPreviousTokenEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/UnwrappedLineParser.cpp -nm=_ZN5clang6format19UnwrappedLineParser16getPreviousTokenEv")
  //</editor-fold>
  private /*const*/ FormatToken /*P*/ getPreviousToken() {
    // FIXME: This is a dirty way to access the previous token. Find a better
    // solution.
    if (!Line.$bool() || Line.$arrow().Tokens.empty()) {
      return null;
    }
    return Line.$arrow().Tokens.back().Tok;
  }


  //<editor-fold defaultstate="collapsed" desc="clang::format::UnwrappedLineParser::readToken">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/UnwrappedLineParser.cpp", line = 2055,
   FQN="clang::format::UnwrappedLineParser::readToken", NM="_ZN5clang6format19UnwrappedLineParser9readTokenEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/UnwrappedLineParser.cpp -nm=_ZN5clang6format19UnwrappedLineParser9readTokenEv")
  //</editor-fold>
  private void readToken() {
    boolean CommentsInCurrentLine = true;
    do {
      FormatTok = Tokens.getNextToken();
      assert Native.$bool(FormatTok);
      while (!Line.$arrow().InPPDirective && FormatTok.Tok.is(tok.TokenKind.hash)
         && (FormatTok.HasUnescapedNewline || FormatTok.IsFirst)) {
        ScopedLineState BlockState = null;
        try {
          // If there is an unfinished unwrapped line, we flush the preprocessor
          // directives only after that unwrapped line was finished later.
          boolean SwitchToPreprocessorLines = !Line.$arrow().Tokens.empty();
          BlockState/*J*/= new ScopedLineState(/*Deref*/this, SwitchToPreprocessorLines);
          // Comments stored before the preprocessor directive need to be output
          // before the preprocessor directive, at the same level as the
          // preprocessor directive, as we consider them to apply to the directive.
          flushComments(isOnNewLine(/*Deref*/FormatTok));
          parsePPDirective();
        } finally {
          if (BlockState != null) { BlockState.$destroy(); }
        }
      }
      while (FormatTok.Type == TokenType.TT_ConflictStart
         || FormatTok.Type == TokenType.TT_ConflictEnd
         || FormatTok.Type == TokenType.TT_ConflictAlternative) {
        if (FormatTok.Type == TokenType.TT_ConflictStart) {
          conditionalCompilationStart(/*Unreachable=*/ false);
        } else if (FormatTok.Type == TokenType.TT_ConflictAlternative) {
          conditionalCompilationAlternative();
        } else if (FormatTok.Type == TokenType.TT_ConflictEnd) {
          conditionalCompilationEnd();
        }
        FormatTok = Tokens.getNextToken();
        FormatTok.MustBreakBefore = true;
      }
      if (!PPStack.empty() && (PPStack.back() == PPBranchKind.PP_Unreachable)
         && !Line.$arrow().InPPDirective) {
        continue;
      }
      if (!FormatTok.Tok.is(tok.TokenKind.comment)) {
        return;
      }
      if (isOnNewLine(/*Deref*/FormatTok) || FormatTok.IsFirst) {
        CommentsInCurrentLine = false;
      }
      if (CommentsInCurrentLine) {
        pushToken(FormatTok);
      } else {
        CommentsBeforeNextToken.push_back(FormatTok);
      }
    } while (!eof());
  }


  //<editor-fold defaultstate="collapsed" desc="clang::format::UnwrappedLineParser::flushComments">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/UnwrappedLineParser.cpp", line = 2021,
   FQN="clang::format::UnwrappedLineParser::flushComments", NM="_ZN5clang6format19UnwrappedLineParser13flushCommentsEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/UnwrappedLineParser.cpp -nm=_ZN5clang6format19UnwrappedLineParser13flushCommentsEb")
  //</editor-fold>
  private void flushComments(boolean NewlineBeforeNext) {
    boolean JustComments = Line.$arrow().Tokens.empty();
    for (type$ptr<FormatToken /*P*/ /*P*/> I = $tryClone(CommentsBeforeNextToken.begin()), 
        /*P*/ E = $tryClone(CommentsBeforeNextToken.end());
         $noteq_ptr(I, E); I.$preInc()) {
      if (isOnNewLine(/*Deref*/I.$star()) && JustComments) {
        addUnwrappedLine();
      }
      pushToken(I.$star());
    }
    if (NewlineBeforeNext && JustComments) {
      addUnwrappedLine();
    }
    CommentsBeforeNextToken.clear();
  }


  //<editor-fold defaultstate="collapsed" desc="clang::format::UnwrappedLineParser::pushToken">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/UnwrappedLineParser.cpp", line = 2104,
   FQN="clang::format::UnwrappedLineParser::pushToken", NM="_ZN5clang6format19UnwrappedLineParser9pushTokenEPNS0_11FormatTokenE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/UnwrappedLineParser.cpp -nm=_ZN5clang6format19UnwrappedLineParser9pushTokenEPNS0_11FormatTokenE")
  //</editor-fold>
  private void pushToken(FormatToken /*P*/ Tok) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      Line.$arrow().Tokens.push_back_T$RR($c$.track(new UnwrappedLineNode(Tok))); $c$.clean();
      if (MustBreakBeforeNextToken) {
        Line.$arrow().Tokens.back().Tok.MustBreakBefore = true;
        MustBreakBeforeNextToken = false;
      }
    } finally {
      $c$.$destroy();
    }
  }


  //<editor-fold defaultstate="collapsed" desc="clang::format::UnwrappedLineParser::calculateBraceTypes">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/UnwrappedLineParser.cpp", line = 311,
   FQN="clang::format::UnwrappedLineParser::calculateBraceTypes", NM="_ZN5clang6format19UnwrappedLineParser19calculateBraceTypesEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/UnwrappedLineParser.cpp -nm=_ZN5clang6format19UnwrappedLineParser19calculateBraceTypesEb")
  //</editor-fold>
  private void calculateBraceTypes() {
    calculateBraceTypes(false);
  }
  private void calculateBraceTypes(boolean ExpectClassBody/*= false*/) {
    // We'll parse forward through the tokens until we hit
    // a closing brace or eof - note that getNextToken() will
    // parse macros, so this will magically work inside macro
    // definitions, too.
    /*uint*/int StoredPosition = Tokens.getPosition();
    FormatToken /*P*/ Tok = FormatTok;
    /*const*/ FormatToken /*P*/ PrevTok = getPreviousToken();
    // Keep a stack of positions of lbrace tokens. We will
    // update information about whether an lbrace starts a
    // braced init list or a different block during the loop.
    SmallVector<FormatToken /*P*/ > LBraceStack/*J*/= new SmallVector<FormatToken /*P*/ >(8, (FormatToken /*P*/ )null);
    assert (Tok.Tok.is(tok.TokenKind.l_brace));
    do {
      // Get next non-comment token.
      FormatToken /*P*/ NextTok;
      /*uint*/int ReadTokens = 0;
      do {
        NextTok = Tokens.getNextToken();
        ++ReadTokens;
      } while (NextTok.is_TokenKind(tok.TokenKind.comment));
      switch (Tok.Tok.getKind()) {
       case tok.TokenKind.l_brace:
        if (Style.Language == FormatStyle.LanguageKind.LK_JavaScript && (PrevTok != null)
           && PrevTok.is_TokenKind(tok.TokenKind.colon)) {
          // In TypeScript's TypeMemberLists, there can be semicolons between the
          // individual members.
          Tok.BlockKind = BraceBlockKind.BK_BracedInit;
        } else {
          Tok.BlockKind = BraceBlockKind.BK_Unknown;
        }
        LBraceStack.push_back(Tok);
        break;
       case tok.TokenKind.r_brace:
        if (LBraceStack.empty()) {
          break;
        }
        if (LBraceStack.back().BlockKind == BraceBlockKind.BK_Unknown) {
          boolean ProbablyBracedList = false;
          if (Style.Language == FormatStyle.LanguageKind.LK_Proto) {
            ProbablyBracedList = NextTok.isOneOf(tok.TokenKind.comma, tok.TokenKind.r_square);
          } else {
            // Using OriginalColumn to distinguish between ObjC methods and
            // binary operators is a bit hacky.
            boolean NextIsObjCMethod = NextTok.isOneOf(tok.TokenKind.plus, tok.TokenKind.minus)
               && NextTok.OriginalColumn == 0;
            
            // If there is a comma, semicolon or right paren after the closing
            // brace, we assume this is a braced initializer list.  Note that
            // regardless how we mark inner braces here, we will overwrite the
            // BlockKind later if we parse a braced list (where all blocks
            // inside are by default braced lists), or when we explicitly detect
            // blocks (for example while parsing lambdas).
            //
            // We exclude + and - as they can be ObjC visibility modifiers.
            ProbablyBracedList
               = (Style.Language == FormatStyle.LanguageKind.LK_JavaScript
               && NextTok.isOneOf(Keywords.kw_of, Keywords.kw_in))
               || NextTok.isOneOf(tok.TokenKind.comma, tok.TokenKind.period, tok.TokenKind.colon, 
                tok.TokenKind.r_paren, tok.TokenKind.r_square, tok.TokenKind.l_brace, 
                tok.TokenKind.l_square, tok.TokenKind.l_paren, tok.TokenKind.ellipsis)
               || (NextTok.is_TokenKind(tok.TokenKind.semi)
               && (!ExpectClassBody || LBraceStack.size() != 1))
               || (NextTok.isBinaryOperator() && !NextIsObjCMethod);
          }
          if (ProbablyBracedList) {
            Tok.BlockKind = BraceBlockKind.BK_BracedInit;
            LBraceStack.back().BlockKind = BraceBlockKind.BK_BracedInit;
          } else {
            Tok.BlockKind = BraceBlockKind.BK_Block;
            LBraceStack.back().BlockKind = BraceBlockKind.BK_Block;
          }
        }
        LBraceStack.pop_back();
        break;
       case tok.TokenKind.at:
       case tok.TokenKind.semi:
       case tok.TokenKind.kw_if:
       case tok.TokenKind.kw_while:
       case tok.TokenKind.kw_for:
       case tok.TokenKind.kw_switch:
       case tok.TokenKind.kw_try:
       case tok.TokenKind.kw___try:
        if (!LBraceStack.empty() && LBraceStack.back().BlockKind == BraceBlockKind.BK_Unknown) {
          LBraceStack.back().BlockKind = BraceBlockKind.BK_Block;
        }
        break;
       default:
        break;
      }
      PrevTok = Tok;
      Tok = NextTok;
    } while (Tok.Tok.isNot(tok.TokenKind.eof) && !LBraceStack.empty());
    
    // Assume other blocks for all unclosed opening braces.
    for (/*uint*/int i = 0, e = LBraceStack.size(); i != e; ++i) {
      if (LBraceStack.$at(i).BlockKind == BraceBlockKind.BK_Unknown) {
        LBraceStack.$at(i).BlockKind = BraceBlockKind.BK_Block;
      }
    }
    
    FormatTok = Tokens.setPosition(StoredPosition);
  }


  
  // Marks a conditional compilation edge (for example, an '#if', '#ifdef',
  // '#else' or merge conflict marker). If 'Unreachable' is true, assumes
  // this branch either cannot be taken (for example '#if false'), or should
  // not be taken in this round.
  
  // Marks a conditional compilation edge (for example, an '#if', '#ifdef',
  // '#else' or merge conflict marker). If 'Unreachable' is true, assumes
  // this branch either cannot be taken (for example '#if false'), or should
  // not be taken in this round.
  //<editor-fold defaultstate="collapsed" desc="clang::format::UnwrappedLineParser::conditionalCompilationCondition">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/UnwrappedLineParser.cpp", line = 537,
   FQN="clang::format::UnwrappedLineParser::conditionalCompilationCondition", NM="_ZN5clang6format19UnwrappedLineParser31conditionalCompilationConditionEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/UnwrappedLineParser.cpp -nm=_ZN5clang6format19UnwrappedLineParser31conditionalCompilationConditionEb")
  //</editor-fold>
  private void conditionalCompilationCondition(boolean Unreachable) {
    if (Unreachable || (!PPStack.empty() && PPStack.back() == PPBranchKind.PP_Unreachable)) {
      PPStack.push_back(PPBranchKind.PP_Unreachable);
    } else {
      PPStack.push_back(PPBranchKind.PP_Conditional);
    }
  }


  //<editor-fold defaultstate="collapsed" desc="clang::format::UnwrappedLineParser::conditionalCompilationStart">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/UnwrappedLineParser.cpp", line = 544,
   FQN="clang::format::UnwrappedLineParser::conditionalCompilationStart", NM="_ZN5clang6format19UnwrappedLineParser27conditionalCompilationStartEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/UnwrappedLineParser.cpp -nm=_ZN5clang6format19UnwrappedLineParser27conditionalCompilationStartEb")
  //</editor-fold>
  private void conditionalCompilationStart(boolean Unreachable) {
    ++PPBranchLevel;
    assert (PPBranchLevel >= 0 && PPBranchLevel <= (int)PPLevelBranchIndex.size());
    if (PPBranchLevel == (int)PPLevelBranchIndex.size()) {
      PPLevelBranchIndex.push_back(0);
      PPLevelBranchCount.push_back(0);
    }
    PPChainBranchIndex.push_value_type(0);
    boolean Skip = PPLevelBranchIndex.$at(PPBranchLevel) > 0;
    conditionalCompilationCondition(Unreachable || Skip);
  }


  //<editor-fold defaultstate="collapsed" desc="clang::format::UnwrappedLineParser::conditionalCompilationAlternative">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/UnwrappedLineParser.cpp", line = 556,
   FQN="clang::format::UnwrappedLineParser::conditionalCompilationAlternative", NM="_ZN5clang6format19UnwrappedLineParser33conditionalCompilationAlternativeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/UnwrappedLineParser.cpp -nm=_ZN5clang6format19UnwrappedLineParser33conditionalCompilationAlternativeEv")
  //</editor-fold>
  private void conditionalCompilationAlternative() {
    if (!PPStack.empty()) {
      PPStack.pop_back();
    }
    assert (PPBranchLevel < (int)PPLevelBranchIndex.size());
    if (!PPChainBranchIndex.empty()) {
      PPChainBranchIndex.top$ref().$set$preInc();//++PPChainBranchIndex.top();
    }
    conditionalCompilationCondition(PPBranchLevel >= 0 && !PPChainBranchIndex.empty()
           && PPLevelBranchIndex.$at(PPBranchLevel) != PPChainBranchIndex.top());
  }


  //<editor-fold defaultstate="collapsed" desc="clang::format::UnwrappedLineParser::conditionalCompilationEnd">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/UnwrappedLineParser.cpp", line = 567,
   FQN="clang::format::UnwrappedLineParser::conditionalCompilationEnd", NM="_ZN5clang6format19UnwrappedLineParser25conditionalCompilationEndEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/UnwrappedLineParser.cpp -nm=_ZN5clang6format19UnwrappedLineParser25conditionalCompilationEndEv")
  //</editor-fold>
  private void conditionalCompilationEnd() {
    assert (PPBranchLevel < (int)PPLevelBranchIndex.size());
    if (PPBranchLevel >= 0 && !PPChainBranchIndex.empty()) {
      if (PPChainBranchIndex.top() + 1 > PPLevelBranchCount.$at(PPBranchLevel)) {
        PPLevelBranchCount.$set(PPBranchLevel, PPChainBranchIndex.top() + 1);
      }
    }
    // Guard against #endif's without #if.
    if (PPBranchLevel > 0) {
      --PPBranchLevel;
    }
    if (!PPChainBranchIndex.empty()) {
      PPChainBranchIndex.pop();
    }
    if (!PPStack.empty()) {
      PPStack.pop_back();
    }
  }


  //<editor-fold defaultstate="collapsed" desc="clang::format::UnwrappedLineParser::isOnNewLine">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/UnwrappedLineParser.cpp", line = 2016,
   FQN="clang::format::UnwrappedLineParser::isOnNewLine", NM="_ZN5clang6format19UnwrappedLineParser11isOnNewLineERKNS0_11FormatTokenE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/UnwrappedLineParser.cpp -nm=_ZN5clang6format19UnwrappedLineParser11isOnNewLineERKNS0_11FormatTokenE")
  //</editor-fold>
  private boolean isOnNewLine(final /*const*/ FormatToken /*&*/ FormatTok) {
    return (Line.$arrow().InPPDirective || FormatTok.HasUnescapedNewline)
       && $greater_uint(FormatTok.NewlinesBefore, 0);
  }


  
  // FIXME: We are constantly running into bugs where Line.Level is incorrectly
  // subtracted from beyond 0. Introduce a method to subtract from Line.Level
  // and use that everywhere in the Parser.
  /*friend*/public/*private*/ std.unique_ptr<UnwrappedLine> Line;
  
  // Comments are sorted into unwrapped lines by whether they are in the same
  // line as the previous token, or not. If not, they belong to the next token.
  // Since the next token might already be in a new unwrapped line, we need to
  // store the comments belonging to that token.
  private SmallVector<FormatToken /*P*/ > CommentsBeforeNextToken;
  private FormatToken /*P*/ FormatTok;
  /*friend*/public/*private*/ boolean MustBreakBeforeNextToken;
  
  // The parsed lines. Only added to through \c CurrentLines.
  private SmallVector<UnwrappedLine> Lines;
  
  // Preprocessor directives are parsed out-of-order from other unwrapped lines.
  // Thus, we need to keep a list of preprocessor directives to be reported
  // after an unwarpped line that has been started was finished.
  /*friend*/public/*private*/ SmallVector<UnwrappedLine> PreprocessorDirectives;
  
  // New unwrapped lines are added via CurrentLines.
  // Usually points to \c &Lines. While parsing a preprocessor directive when
  // there is an unfinished previous unwrapped line, will point to
  // \c &PreprocessorDirectives.
  /*friend*/public/*private*/ SmallVectorImpl<UnwrappedLine> /*P*/ CurrentLines;
  
  // We store for each line whether it must be a declaration depending on
  // whether we are in a compound statement or not.
  private std.vectorBool DeclarationScopeStack;
  
  private final /*const*/ FormatStyle /*&*/ Style;
  private final /*const*/ AdditionalKeywords /*&*/ Keywords;
  
  private FormatTokenSource /*P*/ Tokens;
  private final UnwrappedLineConsumer /*&*/ Callback;
  
  // FIXME: This is a temporary measure until we have reworked the ownership
  // of the format tokens. The goal is to have the actual tokens created and
  // owned outside of and handed into the UnwrappedLineParser.
  private ArrayRef<FormatToken /*P*/ > AllTokens;
  
  // Represents preprocessor branch type, so we can find matching
  // #if/#else/#endif directives.
  //<editor-fold defaultstate="collapsed" desc="clang::format::UnwrappedLineParser::PPBranchKind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/UnwrappedLineParser.h", line = 175,
   FQN="clang::format::UnwrappedLineParser::PPBranchKind", NM="_ZN5clang6format19UnwrappedLineParser12PPBranchKindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/TokenAnalyzer.cpp -nm=_ZN5clang6format19UnwrappedLineParser12PPBranchKindE")
  //</editor-fold>
  private enum PPBranchKind implements Native.NativeUIntEnum {
    PP_Conditional(0), // Any #if, #ifdef, #ifndef, #elif, block outside #if 0
    PP_Unreachable(PP_Conditional.getValue() + 1); // #if 0 or a conditional preprocessor block inside #if 0

    //<editor-fold defaultstate="collapsed" desc="hidden">
    public static PPBranchKind valueOf(int val) {
      PPBranchKind out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
      assert out != null : "no value for " + val;
      assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
      return out;
    }

    private static final class Values {
      private static final PPBranchKind[] VALUES;
      private static final PPBranchKind[] _VALUES; // [0] not used
      static {
        int max = 0;
        int min = 0;
        for (PPBranchKind kind : PPBranchKind.values()) {
          if (kind.value > max) { max = kind.value; }
          if (kind.value < min) { min = kind.value; }
        }
        _VALUES = new PPBranchKind[min < 0 ? (1-min) : 0];
        VALUES = new PPBranchKind[max >= 0 ? (1+max) : 0];
        for (PPBranchKind kind : PPBranchKind.values()) {
          if (kind.value < 0) {
            if (_VALUES[-kind.value] == null) {
              _VALUES[-kind.value] = kind;
            } else {
              assert true: "Must not replace " + _VALUES[-kind.value] + " by " + kind + ". Switch to int-based enum or filter valid.";
            }
          } else {
            if (VALUES[kind.value] == null) {
              VALUES[kind.value] = kind;
            } else {
              assert true: "Must not replace " + VALUES[kind.value] + " by " + kind + ". Switch to int-based enum or filter valid.";
            }
          }
        }
      }
    }

    private final /*uint*/int value;
    private PPBranchKind(int val) { this.value = (/*uint*/int)val;}
    @Override public final /*uint*/int getValue() { return value;}
    //</editor-fold>
  };
  
  // Keeps a stack of currently active preprocessor branching directives.
  private SmallVector<PPBranchKind> PPStack;
  
  // The \c UnwrappedLineParser re-parses the code for each combination
  // of preprocessor branches that can be taken.
  // To that end, we take the same branch (#if, #else, or one of the #elif
  // branches) for each nesting level of preprocessor branches.
  // \c PPBranchLevel stores the current nesting level of preprocessor
  // branches during one pass over the code.
  private int PPBranchLevel;
  
  // Contains the current branch (#if, #else or one of the #elif branches)
  // for each nesting level.
  private SmallVectorInt/*8*/ PPLevelBranchIndex;
  
  // Contains the maximum number of branches at each nesting level.
  private SmallVectorInt/*8*/ PPLevelBranchCount;
  
  // Contains the number of branches per nesting level we are currently
  // in while parsing a preprocessor branch sequence.
  // This is used to update PPLevelBranchCount at the end of a branch
  // sequence.
  private std.stackInt PPChainBranchIndex;
  
  /*friend  class ScopedLineState*/
  /*friend  class CompoundStatementIndenter*/
  //<editor-fold defaultstate="collapsed" desc="clang::format::UnwrappedLineParser::~UnwrappedLineParser">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/UnwrappedLineParser.h", line = 61,
   FQN="clang::format::UnwrappedLineParser::~UnwrappedLineParser", NM="_ZN5clang6format19UnwrappedLineParserD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/TokenAnalyzer.cpp -nm=_ZN5clang6format19UnwrappedLineParserD0Ev")
  //</editor-fold>
  public /*inline*/ void $destroy() {
    //START JDestroy
    PPChainBranchIndex.$destroy();
    PPLevelBranchCount.$destroy();
    PPLevelBranchIndex.$destroy();
    PPStack.$destroy();
    DeclarationScopeStack.$destroy();
    PreprocessorDirectives.$destroy();
    Lines.$destroy();
    CommentsBeforeNextToken.$destroy();
    Line.$destroy();
    //END JDestroy
  }

  
  @Override public String toString() {
    return "" + "Line=" + Line // NOI18N
              + ", CommentsBeforeNextToken=" + CommentsBeforeNextToken // NOI18N
              + ", FormatTok=" + FormatTok // NOI18N
              + ", MustBreakBeforeNextToken=" + MustBreakBeforeNextToken // NOI18N
              + ", Lines=" + Lines // NOI18N
              + ", PreprocessorDirectives=" + PreprocessorDirectives // NOI18N
              + ", CurrentLines=" + CurrentLines // NOI18N
              + ", DeclarationScopeStack=" + DeclarationScopeStack // NOI18N
              + ", Style=" + Style // NOI18N
              + ", Keywords=" + Keywords // NOI18N
              + ", Tokens=" + "[FormatTokenSource]" // NOI18N
              + ", Callback=" + "[UnwrappedLineConsumer]" // NOI18N
              + ", AllTokens=" + AllTokens // NOI18N
              + ", PPStack=" + PPStack // NOI18N
              + ", PPBranchLevel=" + PPBranchLevel // NOI18N
              + ", PPLevelBranchIndex=" + PPLevelBranchIndex // NOI18N
              + ", PPLevelBranchCount=" + PPLevelBranchCount // NOI18N
              + ", PPChainBranchIndex=" + PPChainBranchIndex; // NOI18N
  }
}
