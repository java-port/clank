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

package org.clang.rewrite.core;

import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.java.std.*;
import static org.clank.support.NativePointer.*;
import org.llvm.support.*;
import org.clang.basic.*;
import org.clang.lex.*;

//<editor-fold defaultstate="collapsed" desc="clang::TokenRewriter">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Rewrite/Core/TokenRewriter.h", line = 28,
 FQN="clang::TokenRewriter", NM="_ZN5clang13TokenRewriterE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Rewrite/TokenRewriter.cpp -nm=_ZN5clang13TokenRewriterE")
//</editor-fold>
public class TokenRewriter implements Destructors.ClassWithDestructor {
  /// TokenList - This is the list of raw tokens that make up this file.  Each
  /// of these tokens has a unique SourceLocation, which is a FileID.
  private std.list<Token> TokenList;
  
  /// TokenRefTy - This is the type used to refer to a token in the TokenList.
  /*typedef std::list<Token>::iterator TokenRefTy*/
//  public final class TokenRefTy extends std.list.iterator<Token>{ };
  
  /// TokenAtLoc - This map indicates which token exists at a specific
  /// SourceLocation.  Since each token has a unique SourceLocation, this is a
  /// one to one map.  The token can return its own location directly, to map
  /// backwards.
  private std.mapTypeType<SourceLocation, std.list.iterator<Token>> TokenAtLoc;
  
  /// ScratchBuf - This is the buffer that we create scratch tokens from.
  ///
  private std.unique_ptr<ScratchBuffer> ScratchBuf;
  
  //<editor-fold defaultstate="collapsed" desc="clang::TokenRewriter::TokenRewriter">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Rewrite/Core/TokenRewriter.h", line = 46,
   FQN="clang::TokenRewriter::TokenRewriter", NM="_ZN5clang13TokenRewriterC1ERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Rewrite/TokenRewriter.cpp -nm=_ZN5clang13TokenRewriterC1ERKS0_")
  //</editor-fold>
  private TokenRewriter(/*const*/ TokenRewriter /*&*/ $Prm0) { throw new UnsupportedOperationException("Deleted");}

  //<editor-fold defaultstate="collapsed" desc="clang::TokenRewriter::operator=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Rewrite/Core/TokenRewriter.h", line = 47,
   FQN="clang::TokenRewriter::operator=", NM="_ZN5clang13TokenRewriteraSERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Rewrite/TokenRewriter.cpp -nm=_ZN5clang13TokenRewriteraSERKS0_")
  //</editor-fold>
  private void $assign(/*const*/ TokenRewriter /*&*/ $Prm0) { throw new UnsupportedOperationException("Deleted");}

/*public:*/
  /// TokenRewriter - This creates a TokenRewriter for the file with the
  /// specified FileID.
  //<editor-fold defaultstate="collapsed" desc="clang::TokenRewriter::TokenRewriter">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Rewrite/TokenRewriter.cpp", line = 21,
   FQN="clang::TokenRewriter::TokenRewriter", NM="_ZN5clang13TokenRewriterC1ENS_6FileIDERNS_13SourceManagerERKNS_11LangOptionsE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Rewrite/TokenRewriter.cpp -nm=_ZN5clang13TokenRewriterC1ENS_6FileIDERNS_13SourceManagerERKNS_11LangOptionsE")
  //</editor-fold>
  public TokenRewriter(FileID FID, SourceManager /*&*/ SM, 
      /*const*/ LangOptions /*&*/ LangOpts) {
    // : TokenList(), TokenAtLoc(), ScratchBuf() 
    //START JInit
    this.TokenList = new std.list<Token>(new Token());
    this.TokenAtLoc = new std.mapTypeType<SourceLocation, std.list.iterator<Token>>(new std.list.iterator<Token>());
    this.ScratchBuf = new std.unique_ptr<ScratchBuffer>();
    //END JInit
    Lexer RawLex = null;
    try {
      ScratchBuf.reset(new ScratchBuffer(SM));
      
      // Create a lexer to lex all the tokens of the main file in raw mode.
      /*const*/ MemoryBuffer /*P*/ FromFile = SM.getBuffer(/*NO_COPY*/FID);
      RawLex/*J*/= new Lexer(/*NO_COPY*/FID, FromFile, SM, LangOpts);
      
      // Return all comments and whitespace as tokens.
      RawLex.SetKeepWhitespaceMode(true);
      
      // Lex the file, populating our datastructures.
      Token RawTok/*J*/= new Token();
      RawLex.LexFromRawLexer(RawTok);
      while (RawTok.isNot(tok.TokenKind.eof)) {
        
        AddToken(RawTok, TokenList.end());
        RawLex.LexFromRawLexer(RawTok);
      }
    } finally {
      if (RawLex != null) { RawLex.$destroy(); }
    }
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TokenRewriter::~TokenRewriter">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Rewrite/TokenRewriter.cpp", line = 49,
   FQN="clang::TokenRewriter::~TokenRewriter", NM="_ZN5clang13TokenRewriterD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Rewrite/TokenRewriter.cpp -nm=_ZN5clang13TokenRewriterD0Ev")
  //</editor-fold>
  public void $destroy() {
    //START JDestroy
    ScratchBuf.$destroy();
    TokenAtLoc.$destroy();
    TokenList.$destroy();
    //END JDestroy
  }

  
  /*typedef std::list<Token>::const_iterator token_iterator*/
//  public final class token_iterator extends std.list.iterator<Token>{ };
  //<editor-fold defaultstate="collapsed" desc="clang::TokenRewriter::token_begin">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Rewrite/Core/TokenRewriter.h", line = 55,
   FQN="clang::TokenRewriter::token_begin", NM="_ZNK5clang13TokenRewriter11token_beginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Rewrite/TokenRewriter.cpp -nm=_ZNK5clang13TokenRewriter11token_beginEv")
  //</editor-fold>
  public std.list.iterator<Token> token_begin() /*const*/ {
    return TokenList.begin$Const();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TokenRewriter::token_end">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Rewrite/Core/TokenRewriter.h", line = 56,
   FQN="clang::TokenRewriter::token_end", NM="_ZNK5clang13TokenRewriter9token_endEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Rewrite/TokenRewriter.cpp -nm=_ZNK5clang13TokenRewriter9token_endEv")
  //</editor-fold>
  public std.list.iterator<Token> token_end() /*const*/ {
    return TokenList.end$Const();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::TokenRewriter::AddTokenBefore">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Rewrite/TokenRewriter.cpp", line = 81,
   FQN="clang::TokenRewriter::AddTokenBefore", NM="_ZN5clang13TokenRewriter14AddTokenBeforeESt20_List_const_iteratorINS_5TokenEEPKc",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Rewrite/TokenRewriter.cpp -nm=_ZN5clang13TokenRewriter14AddTokenBeforeESt20_List_const_iteratorINS_5TokenEEPKc")
  //</editor-fold>
  public std.list.iterator<Token> AddTokenBefore(std.list.iterator<Token> I, /*const*/char$ptr/*char P*/ Val) {
    /*uint*/int Len = strlen(Val);
    
    // Plop the string into the scratch buffer, then create a token for this
    // string.
    Token Tok/*J*/= new Token();
    Tok.startToken();
    /*const*/char$ptr/*char P*/ Spelling = create_char$null$ptr();
    Tok.setLocation(ScratchBuf.$arrow().getToken(Val, Len, Spelling));
    Tok.setLength(Len);
    
    // TODO: Form a whole lexer around this and relex the token!  For now, just
    // set kind to tok::unknown.
    Tok.setKind(tok.TokenKind.unknown);
    
    return new std.list.iterator<Token>(AddToken(Tok, RemapIterator(new std.list.iterator<Token>(I))));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TokenRewriter::AddTokenAfter">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Rewrite/Core/TokenRewriter.h", line = 60,
   FQN="clang::TokenRewriter::AddTokenAfter", NM="_ZN5clang13TokenRewriter13AddTokenAfterESt20_List_const_iteratorINS_5TokenEEPKc",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Rewrite/TokenRewriter.cpp -nm=_ZN5clang13TokenRewriter13AddTokenAfterESt20_List_const_iteratorINS_5TokenEEPKc")
  //</editor-fold>
  public std.list.iterator<Token> AddTokenAfter(std.list.iterator<Token> I, /*const*/char$ptr/*char P*/ Val) {
    assert (I.$noteq(token_end())) : "Cannot insert after token_end()!";
    return AddTokenBefore(new std.list.iterator<Token>(I.$preInc()), Val);
  }

/*private:*/
  /// RemapIterator - Convert from token_iterator (a const iterator) to
  /// TokenRefTy (a non-const iterator).
  
  /// RemapIterator - Convert from token_iterator (a const iterator) to
  /// TokenRefTy (a non-const iterator).
  //<editor-fold defaultstate="collapsed" desc="clang::TokenRewriter::RemapIterator">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Rewrite/TokenRewriter.cpp", line = 55,
   FQN="clang::TokenRewriter::RemapIterator", NM="_ZN5clang13TokenRewriter13RemapIteratorESt20_List_const_iteratorINS_5TokenEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Rewrite/TokenRewriter.cpp -nm=_ZN5clang13TokenRewriter13RemapIteratorESt20_List_const_iteratorINS_5TokenEE")
  //</editor-fold>
  private std.list.iterator<Token> RemapIterator(std.list.iterator<Token> I) {
    if (I.$eq(token_end())) {
      return TokenList.end();
    }
    
    // FIXME: This is horrible, we should use our own list or something to avoid
    // this.
    std.mapTypeType.iterator<SourceLocation, std.list.iterator<Token>> MapIt = TokenAtLoc.find(I.$arrow().getLocation());
    assert (MapIt.$noteq(TokenAtLoc.end())) : "iterator not in rewriter?";
    return new std.list.iterator<Token>(MapIt.$arrow().second);
  }

  
  /// AddToken - Add the specified token into the Rewriter before the other
  /// position.
  
  /// AddToken - Add the specified token into the Rewriter before the other
  /// position.
  //<editor-fold defaultstate="collapsed" desc="clang::TokenRewriter::AddToken">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Rewrite/TokenRewriter.cpp", line = 69,
   FQN="clang::TokenRewriter::AddToken", NM="_ZN5clang13TokenRewriter8AddTokenERKNS_5TokenESt14_List_iteratorIS1_E",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Rewrite/TokenRewriter.cpp -nm=_ZN5clang13TokenRewriter8AddTokenERKNS_5TokenESt14_List_iteratorIS1_E")
  //</editor-fold>
  private std.list.iterator<Token> AddToken(/*const*/ Token /*&*/ T, std.list.iterator<Token> Where) {
    Where.$assignMove(TokenList.insert__List_const_iterator$_Tp_T$C$R(new std.list.iterator<Token>(Where), T));
    
    boolean InsertSuccess = TokenAtLoc.insert$T(std.make_pair(T.getLocation(), 
            Where)).second;
    assert (InsertSuccess) : "Token location already in rewriter!";
    //(void)InsertSuccess;
    return new std.list.iterator<Token>(JD$Move.INSTANCE, Where);
  }

  
  @Override public String toString() {
    return "" + "TokenList=" + TokenList // NOI18N
              + ", TokenAtLoc=" + TokenAtLoc // NOI18N
              + ", ScratchBuf=" + ScratchBuf; // NOI18N
  }
}
