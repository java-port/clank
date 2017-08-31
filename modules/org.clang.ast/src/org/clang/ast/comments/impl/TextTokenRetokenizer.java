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

package org.clang.ast.comments.impl;

import org.clank.support.*;
import org.clank.support.aliases.*;
import static org.clank.java.std.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.basic.*;
import org.clang.ast.comments.Token;
import org.clang.ast.comments.tok;
//import org.clang.lex.Token;
import org.clang.ast.comments.*;
import org.clang.ast.comments.llvm.ArrayRefCommentToken;
import static org.clang.basic.BasicClangGlobals.*;


/// Re-lexes a sequence of tok::text tokens.
//<editor-fold defaultstate="collapsed" desc="clang::comments::TextTokenRetokenizer">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/CommentParser.cpp", line = 31,
 FQN="clang::comments::TextTokenRetokenizer", NM="_ZN5clang8comments20TextTokenRetokenizerE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/CommentParser.cpp -nm=_ZN5clang8comments20TextTokenRetokenizerE")
//</editor-fold>
public class TextTokenRetokenizer implements Destructors.ClassWithDestructor {
  private final BumpPtrAllocatorImpl /*&*/ Allocator;
  private final Parser /*&*/ P;
  
  /// This flag is set when there are no more tokens we can fetch from lexer.
  private boolean NoMoreInterestingTokens;
  
  /// Token buffer: tokens we have processed and lookahead.
  private SmallVector<Token> Toks;
  
  /// A position in \c Toks.
  //<editor-fold defaultstate="collapsed" desc="clang::comments::TextTokenRetokenizer::Position">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/CommentParser.cpp", line = 42,
   FQN="clang::comments::TextTokenRetokenizer::Position", NM="_ZN5clang8comments20TextTokenRetokenizer8PositionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/CommentParser.cpp -nm=_ZN5clang8comments20TextTokenRetokenizer8PositionE")
  //</editor-fold>
  private static class/*struct*/ Position {
    public /*uint*/int CurToken;
    public /*const*/char$ptr/*char P*/ BufferStart;
    public /*const*/char$ptr/*char P*/ BufferEnd;
    public /*const*/char$ptr/*char P*/ BufferPtr;
    public SourceLocation BufferStartLoc;
    //<editor-fold defaultstate="collapsed" desc="clang::comments::TextTokenRetokenizer::Position::Position">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/CommentParser.cpp", line = 42,
     FQN="clang::comments::TextTokenRetokenizer::Position::Position", NM="_ZN5clang8comments20TextTokenRetokenizer8PositionC1ERKS2_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/CommentParser.cpp -nm=_ZN5clang8comments20TextTokenRetokenizer8PositionC1ERKS2_")
    //</editor-fold>
    public /*inline*/ Position(final /*const*/ Position /*&*/ $Prm0) {
      // : CurToken(.CurToken), BufferStart(.BufferStart), BufferEnd(.BufferEnd), BufferPtr(.BufferPtr), BufferStartLoc(.BufferStartLoc) 
      //START JInit
      this.CurToken = $Prm0.CurToken;
      this.BufferStart = $tryClone($Prm0.BufferStart);
      this.BufferEnd = $tryClone($Prm0.BufferEnd);
      this.BufferPtr = $tryClone($Prm0.BufferPtr);
      this.BufferStartLoc = new SourceLocation($Prm0.BufferStartLoc);
      //END JInit
    }

    //<editor-fold defaultstate="collapsed" desc="clang::comments::TextTokenRetokenizer::Position::Position">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/CommentParser.cpp", line = 42,
     FQN="clang::comments::TextTokenRetokenizer::Position::Position", NM="_ZN5clang8comments20TextTokenRetokenizer8PositionC1Ev",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/CommentParser.cpp -nm=_ZN5clang8comments20TextTokenRetokenizer8PositionC1Ev")
    //</editor-fold>
    public /*inline*/ Position() {
      // : BufferStartLoc() 
      //START JInit
      this.BufferStartLoc = new SourceLocation();
      //END JInit
    }

    //<editor-fold defaultstate="collapsed" desc="clang::comments::TextTokenRetokenizer::Position::operator=">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/CommentParser.cpp", line = 42,
     FQN="clang::comments::TextTokenRetokenizer::Position::operator=", NM="_ZN5clang8comments20TextTokenRetokenizer8PositionaSERKS2_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/CommentParser.cpp -nm=_ZN5clang8comments20TextTokenRetokenizer8PositionaSERKS2_")
    //</editor-fold>
    public /*inline*/ Position /*&*/ $assign(final /*const*/ Position /*&*/ $Prm0) {
      this.CurToken = $Prm0.CurToken;
      this.BufferStart = $tryClone($Prm0.BufferStart);
      this.BufferEnd = $tryClone($Prm0.BufferEnd);
      this.BufferPtr = $tryClone($Prm0.BufferPtr);
      this.BufferStartLoc.$assign($Prm0.BufferStartLoc);
      return /*Deref*/this;
    }

    
    @Override public String toString() {
      return "" + "CurToken=" + CurToken // NOI18N
                + ", BufferStart=" + BufferStart // NOI18N
                + ", BufferEnd=" + BufferEnd // NOI18N
                + ", BufferPtr=" + BufferPtr // NOI18N
                + ", BufferStartLoc=" + BufferStartLoc; // NOI18N
    }
  };
  
  /// Current position in Toks.
  private Position Pos;
  
  //<editor-fold defaultstate="collapsed" desc="clang::comments::TextTokenRetokenizer::isEnd">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/CommentParser.cpp", line = 53,
   FQN="clang::comments::TextTokenRetokenizer::isEnd", NM="_ZNK5clang8comments20TextTokenRetokenizer5isEndEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/CommentParser.cpp -nm=_ZNK5clang8comments20TextTokenRetokenizer5isEndEv")
  //</editor-fold>
  private boolean isEnd() /*const*/ {
    return $greatereq_uint(Pos.CurToken, Toks.size());
  }

  
  /// Sets up the buffer pointers to point to current token.
  //<editor-fold defaultstate="collapsed" desc="clang::comments::TextTokenRetokenizer::setupBuffer">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/CommentParser.cpp", line = 58,
   FQN="clang::comments::TextTokenRetokenizer::setupBuffer", NM="_ZN5clang8comments20TextTokenRetokenizer11setupBufferEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/CommentParser.cpp -nm=_ZN5clang8comments20TextTokenRetokenizer11setupBufferEv")
  //</editor-fold>
  private void setupBuffer() {
    assert (!isEnd());
    final /*const*/ Token /*&*/ Tok = Toks.$at(Pos.CurToken);
    
    Pos.BufferStart = $tryClone(Tok.getText().begin());
    Pos.BufferEnd = $tryClone(Tok.getText().end());
    Pos.BufferPtr = $tryClone(Pos.BufferStart);
    Pos.BufferStartLoc.$assignMove(Tok.getLocation());
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::comments::TextTokenRetokenizer::getSourceLocation">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/CommentParser.cpp", line = 68,
   FQN="clang::comments::TextTokenRetokenizer::getSourceLocation", NM="_ZNK5clang8comments20TextTokenRetokenizer17getSourceLocationEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/CommentParser.cpp -nm=_ZNK5clang8comments20TextTokenRetokenizer17getSourceLocationEv")
  //</editor-fold>
  private SourceLocation getSourceLocation() /*const*/ {
    /*const*//*uint*/int CharNo = Pos.BufferPtr.$sub(Pos.BufferStart);
    return Pos.BufferStartLoc.getLocWithOffset(CharNo);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::comments::TextTokenRetokenizer::peek">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/CommentParser.cpp", line = 73,
   FQN="clang::comments::TextTokenRetokenizer::peek", NM="_ZNK5clang8comments20TextTokenRetokenizer4peekEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/CommentParser.cpp -nm=_ZNK5clang8comments20TextTokenRetokenizer4peekEv")
  //</editor-fold>
  private /*char*/byte peek() /*const*/ {
    assert (!isEnd());
    assert ($noteq_ptr(Pos.BufferPtr, Pos.BufferEnd));
    return Pos.BufferPtr.$star();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::comments::TextTokenRetokenizer::consumeChar">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/CommentParser.cpp", line = 79,
   FQN="clang::comments::TextTokenRetokenizer::consumeChar", NM="_ZN5clang8comments20TextTokenRetokenizer11consumeCharEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/CommentParser.cpp -nm=_ZN5clang8comments20TextTokenRetokenizer11consumeCharEv")
  //</editor-fold>
  private void consumeChar() {
    assert (!isEnd());
    assert ($noteq_ptr(Pos.BufferPtr, Pos.BufferEnd));
    Pos.BufferPtr.$postInc();
    if ($eq_ptr(Pos.BufferPtr, Pos.BufferEnd)) {
      Pos.CurToken++;
      if (isEnd() && !addToken()) {
        return;
      }
      assert (!isEnd());
      setupBuffer();
    }
  }

  
  /// Add a token.
  /// Returns true on success, false if there are no interesting tokens to
  /// fetch from lexer.
  //<editor-fold defaultstate="collapsed" desc="clang::comments::TextTokenRetokenizer::addToken">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/CommentParser.cpp", line = 96,
   FQN="clang::comments::TextTokenRetokenizer::addToken", NM="_ZN5clang8comments20TextTokenRetokenizer8addTokenEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/CommentParser.cpp -nm=_ZN5clang8comments20TextTokenRetokenizer8addTokenEv")
  //</editor-fold>
  private boolean addToken() {
    if (NoMoreInterestingTokens) {
      return false;
    }
    if (P.Tok.is(tok.TokenKind.newline)) {
      // If we see a single newline token between text tokens, skip it.
      Token Newline = new Token(P.Tok);
      P.consumeToken();
      if (P.Tok.isNot(tok.TokenKind.text)) {
        P.putBack(Newline);
        NoMoreInterestingTokens = true;
        return false;
      }
    }
    if (P.Tok.isNot(tok.TokenKind.text)) {
      NoMoreInterestingTokens = true;
      return false;
    }
    
    Toks.push_back(P.Tok);
    P.consumeToken();
    if (Toks.size() == 1) {
      setupBuffer();
    }
    return true;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::comments::TextTokenRetokenizer::consumeWhitespace">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/CommentParser.cpp", line = 122,
   FQN="clang::comments::TextTokenRetokenizer::consumeWhitespace", NM="_ZN5clang8comments20TextTokenRetokenizer17consumeWhitespaceEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/CommentParser.cpp -nm=_ZN5clang8comments20TextTokenRetokenizer17consumeWhitespaceEv")
  //</editor-fold>
  private void consumeWhitespace() {
    while (!isEnd()) {
      if (isWhitespace(peek())) {
        consumeChar();
      } else {
        break;
      }
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::comments::TextTokenRetokenizer::formTokenWithChars">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/CommentParser.cpp", line = 131,
   FQN="clang::comments::TextTokenRetokenizer::formTokenWithChars", NM="_ZN5clang8comments20TextTokenRetokenizer18formTokenWithCharsERNS0_5TokenENS_14SourceLocationEPKcjN4llvm9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/CommentParser.cpp -nm=_ZN5clang8comments20TextTokenRetokenizer18formTokenWithCharsERNS0_5TokenENS_14SourceLocationEPKcjN4llvm9StringRefE")
  //</editor-fold>
  private void formTokenWithChars(final Token /*&*/ Result, 
                    SourceLocation Loc, 
                    /*const*/char$ptr/*char P*/ TokBegin, 
                    /*uint*/int TokLength, 
                    StringRef Text) {
    Result.setLocation(new SourceLocation(Loc));
    Result.setKind(tok.TokenKind.text);
    Result.setLength(TokLength);
    Result.TextPtr = $tryClone($("<UNSET>"));
    Result.IntVal = 7;
    Result.setText(new StringRef(Text));
  }

/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::comments::TextTokenRetokenizer::TextTokenRetokenizer">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/CommentParser.cpp", line = 147,
   FQN="clang::comments::TextTokenRetokenizer::TextTokenRetokenizer", NM="_ZN5clang8comments20TextTokenRetokenizerC1ERN4llvm20BumpPtrAllocatorImplINS2_15MallocAllocatorELj4096ELj4096EEERNS0_6ParserE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/CommentParser.cpp -nm=_ZN5clang8comments20TextTokenRetokenizerC1ERN4llvm20BumpPtrAllocatorImplINS2_15MallocAllocatorELj4096ELj4096EEERNS0_6ParserE")
  //</editor-fold>
  public TextTokenRetokenizer(final BumpPtrAllocatorImpl /*&*/ Allocator, final Parser /*&*/ P) {
    // : Allocator(Allocator), P(P), NoMoreInterestingTokens(false), Toks(), Pos() 
    //START JInit
    this./*&*/Allocator=/*&*/Allocator;
    this./*&*/P=/*&*/P;
    this.NoMoreInterestingTokens = false;
    this.Toks = new SmallVector<Token>(16, new Token());
    this.Pos = new Position();
    //END JInit
    Pos.CurToken = 0;
    addToken();
  }

  
  /// Extract a word -- sequence of non-whitespace characters.
  //<editor-fold defaultstate="collapsed" desc="clang::comments::TextTokenRetokenizer::lexWord">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/CommentParser.cpp", line = 154,
   FQN="clang::comments::TextTokenRetokenizer::lexWord", NM="_ZN5clang8comments20TextTokenRetokenizer7lexWordERNS0_5TokenE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/CommentParser.cpp -nm=_ZN5clang8comments20TextTokenRetokenizer7lexWordERNS0_5TokenE")
  //</editor-fold>
  public boolean lexWord(final Token /*&*/ Tok) {
    if (isEnd()) {
      return false;
    }
    
    Position SavedPos = new Position(Pos);
    
    consumeWhitespace();
    SmallString/*32*/ WordText/*J*/= new SmallString/*32*/(32);
    /*const*/char$ptr/*char P*/ WordBegin = $tryClone(Pos.BufferPtr);
    SourceLocation Loc = getSourceLocation();
    while (!isEnd()) {
      /*const*//*char*/byte C = peek();
      if (!isWhitespace(C)) {
        WordText.push_back(C);
        consumeChar();
      } else {
        break;
      }
    }
    /*const*//*uint*/int Length = WordText.size();
    if (Length == 0) {
      Pos.$assign(SavedPos);
      return false;
    }
    
    char$ptr/*char P*/ TextPtr = $tryClone(Allocator.//</*char*/byte>
            Allocate(Length + 1));
    
    memcpy(TextPtr, WordText.c_str(), Length + 1);
    StringRef Text = new StringRef(TextPtr, Length);
    
    formTokenWithChars(Tok, new SourceLocation(Loc), WordBegin, Length, new StringRef(Text));
    return true;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::comments::TextTokenRetokenizer::lexDelimitedSeq">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/CommentParser.cpp", line = 187,
   FQN="clang::comments::TextTokenRetokenizer::lexDelimitedSeq", NM="_ZN5clang8comments20TextTokenRetokenizer15lexDelimitedSeqERNS0_5TokenEcc",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/CommentParser.cpp -nm=_ZN5clang8comments20TextTokenRetokenizer15lexDelimitedSeqERNS0_5TokenEcc")
  //</editor-fold>
  public boolean lexDelimitedSeq(final Token /*&*/ Tok, /*char*/byte OpenDelim, /*char*/byte CloseDelim) {
    if (isEnd()) {
      return false;
    }
    
    Position SavedPos = new Position(Pos);
    
    consumeWhitespace();
    SmallString/*32*/ WordText/*J*/= new SmallString/*32*/(32);
    /*const*/char$ptr/*char P*/ WordBegin = $tryClone(Pos.BufferPtr);
    SourceLocation Loc = getSourceLocation();
    boolean Error = false;
    if (!isEnd()) {
      /*const*//*char*/byte C = peek();
      if (C == OpenDelim) {
        WordText.push_back(C);
        consumeChar();
      } else {
        Error = true;
      }
    }
    /*char*/byte C = $$TERM;
    while (!Error && !isEnd()) {
      C = peek();
      WordText.push_back(C);
      consumeChar();
      if (C == CloseDelim) {
        break;
      }
    }
    if (!Error && C != CloseDelim) {
      Error = true;
    }
    if (Error) {
      Pos.$assign(SavedPos);
      return false;
    }
    
    /*const*//*uint*/int Length = WordText.size();
    char$ptr/*char P*/ TextPtr = $tryClone(Allocator.//</*char*/byte>
            Allocate(Length + 1));
    
    memcpy(TextPtr, WordText.c_str(), Length + 1);
    StringRef Text = new StringRef(TextPtr, Length);
    
    formTokenWithChars(Tok, new SourceLocation(Loc), WordBegin, 
        Pos.BufferPtr.$sub(WordBegin), new StringRef(Text));
    return true;
  }

  
  /// Put back tokens that we didn't consume.
  //<editor-fold defaultstate="collapsed" desc="clang::comments::TextTokenRetokenizer::putBackLeftoverTokens">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/CommentParser.cpp", line = 234,
   FQN="clang::comments::TextTokenRetokenizer::putBackLeftoverTokens", NM="_ZN5clang8comments20TextTokenRetokenizer21putBackLeftoverTokensEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/CommentParser.cpp -nm=_ZN5clang8comments20TextTokenRetokenizer21putBackLeftoverTokensEv")
  //</editor-fold>
  public void putBackLeftoverTokens() {
    if (isEnd()) {
      return;
    }
    
    boolean HavePartialTok = false;
    Token PartialTok/*J*/= new Token();
    if ($noteq_ptr(Pos.BufferPtr, Pos.BufferStart)) {
      formTokenWithChars(PartialTok, getSourceLocation(), 
          Pos.BufferPtr, Pos.BufferEnd.$sub(Pos.BufferPtr), 
          new StringRef(Pos.BufferPtr, 
              Pos.BufferEnd.$sub(Pos.BufferPtr)));
      HavePartialTok = true;
      Pos.CurToken++;
    }
    
    P.putBack(new ArrayRefCommentToken(Toks.begin().$add(Pos.CurToken), Toks.end()));
    Pos.CurToken = Toks.size();
    if (HavePartialTok) {
      P.putBack(PartialTok);
    }
  }

  //<editor-fold defaultstate="collapsed" desc="clang::comments::TextTokenRetokenizer::~TextTokenRetokenizer">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/CommentParser.cpp", line = 31,
   FQN="clang::comments::TextTokenRetokenizer::~TextTokenRetokenizer", NM="_ZN5clang8comments20TextTokenRetokenizerD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/CommentParser.cpp -nm=_ZN5clang8comments20TextTokenRetokenizerD0Ev")
  //</editor-fold>
  public /*inline*/ void $destroy() {
    //START JDestroy
    Toks.$destroy();
    //END JDestroy
  }

  
  @Override public String toString() {
    return "" + "Allocator=" + "[BumpPtrAllocatorImpl]" // NOI18N
              + ", P=" + "[Parser]" // NOI18N
              + ", NoMoreInterestingTokens=" + NoMoreInterestingTokens // NOI18N
              + ", Toks=" + Toks // NOI18N
              + ", Pos=" + Pos; // NOI18N
  }
}
