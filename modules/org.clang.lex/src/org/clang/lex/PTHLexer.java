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

package org.clang.lex;

import static org.clank.support.Native.$AddrOf;
import org.clang.basic.*;
import static org.clang.basic.BasicClangGlobals.*;
import org.clang.lex.*;
import org.clang.lex.impl.PTHLexerStatics;
import static org.clang.lex.impl.PTHLexerStatics.*;
import org.clank.support.*;
import static org.clank.support.Native.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.NativeType.*;
import static org.clank.support.Unsigned.*;
import org.clank.support.aliases.*;
import org.llvm.adt.*;
import static org.llvm.support.llvm.support.*;
import org.llvm.support.llvm.support.endian;
import static org.llvm.support.llvm.support.endianness.*;

//<editor-fold defaultstate="collapsed" desc="clang::PTHLexer">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/PTHLexer.h", line = 24,
 FQN = "clang::PTHLexer", NM = "_ZN5clang8PTHLexerE",
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PTHLexer.cpp -nm=_ZN5clang8PTHLexerE")
//</editor-fold>
public final class PTHLexer extends /*public*/ PreprocessorLexer implements Destructors.ClassWithDestructor {
  // JAVA FIX: this bit and mask are used to serialize and deserialize Incomplete token flag in FileOffset value
  public static final int INCOMPLETE_TOKEN_FLAG_BIT = 1 << 31; // see PTHWriter.EmitToken
  public static final int INCOMPLETE_TOKEN_FLAG_MASK = ~INCOMPLETE_TOKEN_FLAG_BIT;
  
  private final/*SourceLocation*/int FileStartLoc;
  
  /// TokBuf - Buffer from PTH file containing raw token data.
  private final/*const*/char$ptr/*uchar P*/ TokBuf;
  
  /// CurPtr - Pointer into current offset of the token buffer where
  ///  the next token will be read.
  private /*const*/int/*uchar P*/ CurPtr;// JAVA: Current Offset in TokBuf buffer
  
  /// LastHashTokPtr - Pointer into TokBuf of the last processed '#'
  ///  token that appears at the start of a line.
  private /*const*/int/*uchar P*/ LastHashTokPtr;// JAVA: Offset in TokBuf buffer
  private static final int INVALID = -1;
  
  /// PPCond - Pointer to a side table in the PTH file that provides a
  ///  a consise summary of the preproccessor conditional block structure.
  ///  This is used to perform quick skipping of conditional blocks.
  private final/*const*/char$ptr/*uchar P*/ PPCond;
  
  /// CurPPCondPtr - Pointer inside PPCond that refers to the next entry
  ///  to process when doing quick skipping of preprocessor blocks.
  private /*const*/int/*uchar P*/ CurPPCondPtr = -1; // JAVA: Current Offset for PPCond buffer 
  
  /// JAVA: copied from Lexer and modified
  /// ExtendedTokenMode - The lexer can optionally keep comments and whitespace
  /// and return them as tokens.  This is used for -C and -CC modes, and
  /// whitespace preservation can be useful for some clients that want to lex
  /// the file in raw mode and get every character from the file.
  ///
  /// When this is set to 2 it returns comments and whitespace.  When set to 1
  /// it returns comments, when it is set to 0 it returns normal tokens only.
  /// JAVA: PTHLexer supports only comments, but not whitespaces, 
  //        Native doesn't support any of them
  private boolean ExtendedTokenMode;
  
  //<editor-fold defaultstate="collapsed" desc="clang::PTHLexer::PTHLexer">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/PTHLexer.h", line = 47,
   FQN="clang::PTHLexer::PTHLexer", NM="_ZN5clang8PTHLexerC1ERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/AnalysisBasedWarnings.cpp -nm=_ZN5clang8PTHLexerC1ERKS0_")
  //</editor-fold>
  private PTHLexer(/*const*/ PTHLexer /*&*/ $Prm0) { throw new UnsupportedOperationException("Deleted");}

  //<editor-fold defaultstate="collapsed" desc="clang::PTHLexer::operator=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/PTHLexer.h", line = 48,
   FQN="clang::PTHLexer::operator=", NM="_ZN5clang8PTHLexeraSERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/AnalysisBasedWarnings.cpp -nm=_ZN5clang8PTHLexeraSERKS0_")
  //</editor-fold>
  private void $assign(/*const*/ PTHLexer /*&*/ $Prm0) { throw new UnsupportedOperationException("Deleted");}
  
  
  /// ReadToken - Used by PTHLexer to read tokens TokBuf.
  //<editor-fold defaultstate="collapsed" desc="clang::PTHLexer::ReadToken">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/PTHLexer.h", line = 51,
   FQN = "clang::PTHLexer::ReadToken", NM = "_ZN5clang8PTHLexer9ReadTokenERNS_5TokenE",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PTHLexer.cpp -nm=_ZN5clang8PTHLexer9ReadTokenERNS_5TokenE")
  //</editor-fold>
  private void ReadToken(Token /*&*/ T) {throw new UnsupportedOperationException("ReadToken doesn't have implementation");}

  //<editor-fold defaultstate="collapsed" desc="clang::PTHLexer::LexEndOfFile">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/PTHLexer.cpp", line = 129,
   FQN = "clang::PTHLexer::LexEndOfFile", NM = "_ZN5clang8PTHLexer12LexEndOfFileERNS_5TokenE",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PTHLexer.cpp -nm=_ZN5clang8PTHLexer12LexEndOfFileERNS_5TokenE")
  //</editor-fold>
  private boolean LexEndOfFile(Token /*&*/ Result) {
    // If we hit the end of the file while parsing a preprocessor directive,
    // end the preprocessor directive first.  The next token returned will
    // then be the end of file.
    if (ParsingPreprocessorDirective) {
      ParsingPreprocessorDirective = false; // Done parsing the "line".
      
      // JAVA FIX: Restore comment saving mode, in case it was disabled for directive.
      resetExtendedTokenMode();      
      return true; // Have a token.
    }
    assert (!LexingRawMode);
    
    // If we are in a #if directive, emit an error.
    while (!ConditionalStack.empty()) {
      if ($noteq_SourceLocation$C(PP.getCodeCompletionFileLoc().getRawEncoding(), FileStartLoc)) {
        PP.Diag(ConditionalStack.back().getIfLoc(), diag.err_pp_unterminated_conditional).$destroy();
      }
      ConditionalStack.pop_back();
    }
    
    // Finally, let the preprocessor handle this.
    return PP.HandleEndOfFile(Result);
  }

  
  /// PTHMgr - The PTHManager object that created this PTHLexer.
  private final PTHManager /*&*/ PTHMgr;
  private final Token EofToken;
/*protected:*/
  /*friend  class PTHManager*/;
  
  /// Create a PTHLexer for the specified token stream.
  
  //===----------------------------------------------------------------------===//
  // PTHLexer methods.
  //===----------------------------------------------------------------------===//
  //<editor-fold defaultstate="collapsed" desc="clang::PTHLexer::PTHLexer">
  @Converted(kind = Converted.Kind.MANUAL, source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/PTHLexer.cpp", line = 37,
   FQN = "clang::PTHLexer::PTHLexer", NM = "_ZN5clang8PTHLexerC1ERNS_12PreprocessorENS_6FileIDEPKhS5_RNS_10PTHManagerE",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PTHLexer.cpp -nm=_ZN5clang8PTHLexerC1ERNS_12PreprocessorENS_6FileIDEPKhS5_RNS_10PTHManagerE")
  //</editor-fold>
  protected PTHLexer(Preprocessor /*&*/ PP, FileID FID, /*const*/char$ptr/*uchar P*/ D, /*const*/char$ptr/*uchar P*/ ppcond, PTHManager /*&*/ PM) {
    this(PP, FID.$ID(), D, ppcond, PM);
  }
  protected PTHLexer(Preprocessor /*&*/ PP, /*FileID*/int FID, /*const*/char$ptr/*uchar P*/ D, /*const*/char$ptr/*uchar P*/ ppcond, PTHManager /*&*/ PM) {
    /* : PreprocessorLexer(&PP, FID), FileStartLoc(), TokBuf(D), CurPtr(D), LastHashTokPtr(0), PPCond(ppcond), CurPPCondPtr(ppcond), PTHMgr(PM), EofToken()*/ 
    //START JInit
    super($AddrOf(PP), FID);
//    this.FileStartLoc = SourceLocation.getInvalid();
    this.TokBuf = $toConst(D);
    this.CurPtr = 0;//$tryClone(D);
    this.LastHashTokPtr = INVALID;
    this.PPCond = $toConst(ppcond);
    this.CurPPCondPtr = ppcond == null ? INVALID : 0;//$tryClone(ppcond);
    this.PTHMgr = PM;
    this.EofToken = new Token();
    //END JInit
    
    FileStartLoc = PP.getSourceManager().getLocForStartOfFile(FID);
    resetExtendedTokenMode();
  }

/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::PTHLexer::~PTHLexer">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/PTHLexer.h", line = 67,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/PTHLexer.h", old_line = 68,
   FQN = "clang::PTHLexer::~PTHLexer", NM = "_ZN5clang8PTHLexerD0Ev",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PTHLexer.cpp -nm=_ZN5clang8PTHLexerD0Ev")
  //</editor-fold>
  @Override public void $destroy() {
    super.$destroy();
  }

  // JAVA FIX: copied from Lexer to be available for Java's PTHLexer as well (which can keep more tokens than Native)    
  /// isKeepWhitespaceMode - Return true if the lexer should return tokens for
  /// every character in the file, including whitespace and comments.  This
  /// should only be used in raw mode, as the preprocessor is not prepared to
  /// deal with the excess tokens.
  //<editor-fold defaultstate="collapsed" desc="clang::Lexer::isKeepWhitespaceMode">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/Lexer.h", line = 166,
   FQN = "clang::Lexer::isKeepWhitespaceMode", NM = "_ZNK5clang5Lexer20isKeepWhitespaceModeEv",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/Lexer.cpp -nm=_ZNK5clang5Lexer20isKeepWhitespaceModeEv")
  //</editor-fold>
  @Override public boolean isKeepWhitespaceMode() /*const*/ {
    return false;
  }
  
  /// JAVA FIX: copied from Lexer to be available for Java's PTHLexer as well (which can keep more tokens than Native)    
  /// SetKeepWhitespaceMode - This method lets clients enable or disable
  /// whitespace retention mode.
  //<editor-fold defaultstate="collapsed" desc="clang::Lexer::SetKeepWhitespaceMode">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/Lexer.h", line = 172,
   FQN = "clang::Lexer::SetKeepWhitespaceMode", NM = "_ZN5clang5Lexer21SetKeepWhitespaceModeEb",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/Lexer.cpp -nm=_ZN5clang5Lexer21SetKeepWhitespaceModeEb")
  //</editor-fold>
  @Override public void SetKeepWhitespaceMode(boolean Mode) {
    if (Mode) {
      throw new UnsupportedOperationException("PTHLexer doesn't support keep whitespace mode");
    } else {
      // this is request to disable all extended modes, so disable comments
      SetCommentRetentionState(false);
    }    
  }
  
  // JAVA FIX: copied from Lexer to be available for Java's PTHLexer as well (which can keep more tokens than Native)  
  /// inKeepCommentMode - Return true if the lexer should return comments as
  /// tokens.
  //<editor-fold defaultstate="collapsed" desc="clang::Lexer::inKeepCommentMode">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/Lexer.h", line = 180,
   FQN = "clang::Lexer::inKeepCommentMode", NM = "_ZNK5clang5Lexer17inKeepCommentModeEv",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/Lexer.cpp -nm=_ZNK5clang5Lexer17inKeepCommentModeEv")
  //</editor-fold>
  @Override public boolean inKeepCommentMode() /*const*/ {
    return ExtendedTokenMode;
  }

  // JAVA FIX: copied from Lexer to be available for Java's PTHLexer as well (which can keep more tokens than Native)  
  /// SetCommentRetentionMode - Change the comment retention mode of the lexer
  /// to the specified mode.  This is really only useful when lexing in raw
  /// mode, because otherwise the lexer needs to manage this.
  //<editor-fold defaultstate="collapsed" desc="clang::Lexer::SetCommentRetentionState">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/Lexer.h", line = 187,
   FQN = "clang::Lexer::SetCommentRetentionState", NM = "_ZN5clang5Lexer24SetCommentRetentionStateEb",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/Lexer.cpp -nm=_ZN5clang5Lexer24SetCommentRetentionStateEb")
  //</editor-fold>
  @Override public void SetCommentRetentionState(boolean Mode) {
    ExtendedTokenMode = Mode;
  }

  /// JAVA FIX: copied from Lexer to be available for Java's PTHLexer as well (which can keep more tokens than Native)    
  /// Sets the extended token mode back to its initial value, according to the
  /// language options and preprocessor. This controls whether the lexer
  /// produces comment and whitespace tokens.
  ///
  /// This requires the lexer to have an associated preprocessor. A standalone
  /// lexer has nothing to reset to.
  //<editor-fold defaultstate="collapsed" desc="clang::Lexer::resetExtendedTokenMode">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC, source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/Lexer.cpp", line = 120,
   FQN = "clang::Lexer::resetExtendedTokenMode", NM = "_ZN5clang5Lexer22resetExtendedTokenModeEv",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/Lexer.cpp -nm=_ZN5clang5Lexer22resetExtendedTokenModeEv")
  //</editor-fold>  
  @Override public void resetExtendedTokenMode() {
    assert ((PP != null)) : "Cannot reset token mode without a preprocessor";
    SetCommentRetentionState(PP.getCommentRetentionState());
  }
    
  /// Lex - Return the next token.
  //<editor-fold defaultstate="collapsed" desc="clang::PTHLexer::Lex">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC, source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/PTHLexer.cpp", line = 45,
   FQN = "clang::PTHLexer::Lex", NM = "_ZN5clang8PTHLexer3LexERNS_5TokenE",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PTHLexer.cpp -nm=_ZN5clang8PTHLexer3LexERNS_5TokenE")
  //</editor-fold>
  public boolean Lex(Token /*&*/ Tok) {
   //===--------------------------------------==//
   // Read the raw token data, see PTHWriter.EmitToken 
   //===--------------------------------------==//
   //JAVA: using namespace llvm::support;
   while(true) { // JAVA PERF: loop to skip comments
    // Shadow CurPtr into an automatic variable.
    /*const*/int/*uchar P*/ CurPtrShadow = CurPtr;
    
    // JAVA: check we are inside TokBuffer
    assert (this.PPCond == null) 
            || ((this.PPCond.$index() - (TokBuf.$index() + CurPtrShadow)) > sizeof$uint32()) 
            : "out of Tokens buffer:" + (TokBuf.$index() + CurPtrShadow) + " vs. " + PPCond.$index();
    
    // Read in the data for the token, see PTHWriter.EmitToken.        
    /*uint*/int Word0 = endian.read_uint32(little, aligned, TokBuf, CurPtrShadow);
                                          CurPtrShadow += sizeof$uint32();
    int/*uint32_t*/ IdentifierID = endian.read_uint32(little, aligned, TokBuf, CurPtrShadow);
                                          CurPtrShadow += sizeof$uint32();
    int/*uint32_t*/ FileOffsetRaw = endian.read_uint32(little, aligned, TokBuf, CurPtrShadow);
                                          CurPtrShadow += sizeof$uint32();
    
    // Decompress all Token data, see PTHWriter.EmitToken                              
    /*tok.TokenKind*/char TKind = $int2ushort(Word0 & 0xFF);
    /*Token.TokenFlags*/char TFlags = (/*Token.TokenFlags*/char)((Word0 >>> 8) & 0xFF);
    // JAVA FIX: Incomplete Flag is kept in FileOffsetRaw, see PTHWriter.EmitToken
    int FileOffset = FileOffsetRaw & INCOMPLETE_TOKEN_FLAG_MASK;
    if (FileOffsetRaw != FileOffset) {
      TFlags |= Token.TokenFlags.Incomplete;
    }
    int/*uint32_t*/ Len = (Word0 >>> 16) & 0xFFFF/*unsigned shift*/;
    /*SourceLocation*/int TokenLoc = SourceLocation.$getLocWithOffset(FileStartLoc, FileOffset);

    CurPtr = CurPtrShadow;
    
    // JAVA FIX: handle comment tokens emited into PTH (absent in Native)
    // do it before constructing real token to save instructions when comments are
    // not needed
    boolean commentTok = (TKind == tok.TokenKind.comment);
    if (commentTok) {
      // Notify comment handlers about the comment unless we're in a #if 0 block.
      assert PP != null;
      // notify PP comment handlers (i.e. VerifyDiagnosticConsumer)
      // as in Lexer.Skip*Comment in non-raw-mode
      if (!isLexingRawMode() 
           && PP.HandleComment(Tok, $CommentSourceRange(TokenLoc, SourceLocation.$getLocWithOffset(TokenLoc, Len)))) {
        // return token constructed by HandleComment
        return true;
      }
      if (!inKeepCommentMode()) {
        // skip comment and start to read the next token
        continue;
      }
    }
    
    //===--------------------------------------==//
    // Construct the token itself.
    //===--------------------------------------==//
    Tok.startToken();
    Tok.setKind(TKind);
    Tok.setFlag(TFlags);
    Tok.setLocation(TokenLoc);
    Tok.setLength(Len);
    
    // Handle identifiers.
    if (Tok.isLiteral()) {
      Tok.setLiteralData(PTHMgr.SpellingBase.$array(), PTHMgr.SpellingBase.$index() + IdentifierID);
      // JAVA FIX: check token kind according to the current Lang Options
      CheckLiteralToken(Tok, TKind, TokenLoc, Len);
    } else if ((IdentifierID != 0)) {
      MIOpt.ReadToken();
      IdentifierInfo /*P*/ II = PTHMgr.GetIdentifierInfo(IdentifierID - 1);
      
      Tok.setIdentifierInfo(II);
      
      // Change the kind of this identifier to the appropriate token kind, e.g.
      // turning "for" into a keyword.
      Tok.setKind(II.getTokenID());
      if (!LexingRawMode && II.isHandleIdentifierCase()) {
        return PP.HandleIdentifier(Tok);
      }
      
      return true;
    }
    
    //===--------------------------------------==//
    // Process the token.
    //===--------------------------------------==//
    if (TKind == tok.TokenKind.eof) {
      // Save the end-of-file token.
      EofToken.$assign(Tok);
      assert (!LexingRawMode);
      if (ParsingPreprocessorDirective) {
        // this could be the case for imbalanced
        // #if 0
        // #elif        
        assert PreprocessorDirectiveHashLoc == Tok.$getLocation() : "only incomplete file is expected";
        PreprocessorDirectiveEodLoc = PreprocessorDirectiveHashLoc;
        ParsingPreprocessorDirective = false;
        // rollback for the next reparse
        CurPtr -= StoredTokenSize;
        return true;
      }
      
      return LexEndOfFile(Tok);
    }
    if (TKind == tok.TokenKind.hash && Tok.isAtStartOfLine()) {
      LastHashTokPtr = CurPtr - StoredTokenSize;
      // JAVA: keep location of pp start 
      PreprocessorDirectiveHashLoc = Tok.$getLocation();
      assert (!LexingRawMode);
      PP.HandleDirective(Tok);
      
      return false;
    }
    if (TKind == tok.TokenKind.eod) {
      assert (ParsingPreprocessorDirective);
      ParsingPreprocessorDirective = false;
      // JAVA: keep location of pp eod
      PreprocessorDirectiveEodLoc = Tok.$getLocation();
      // Restore comment saving mode, in case it was disabled for directive.
      resetExtendedTokenMode();
      return true;
    }
    
    // JAVA: do not break Multiple Include optimization due to comment token
    if (!commentTok) {
      MIOpt.ReadToken();
    }
    return true;
   } // JAVA: end of while(true) loop to skip comments
  }

  
  // FIXME: We can just grab the last token instead of storing a copy
  // into EofToken.
  //<editor-fold defaultstate="collapsed" desc="clang::PTHLexer::getEOF">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/PTHLexer.cpp", line = 154,
   FQN = "clang::PTHLexer::getEOF", NM = "_ZN5clang8PTHLexer6getEOFERNS_5TokenE",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PTHLexer.cpp -nm=_ZN5clang8PTHLexer6getEOFERNS_5TokenE")
  //</editor-fold>
  public void getEOF(Token /*&*/ Tok) {
    assert (EofToken.is(tok.TokenKind.eof));
    Tok.$assign(EofToken);
  }

  //#define DISK_TOKEN_SIZE (1+1+2+4+4)
  public static final int DISK_TOKEN_SIZE = PTHLexerStatics.StoredTokenSize;
  static {
    int expected  = (1+1+2+4+4);
    assert DISK_TOKEN_SIZE == expected : "expected " + expected + " vs. " + DISK_TOKEN_SIZE;
  }
  
  /// DiscardToEndOfLine - Read the rest of the current preprocessor line as an
  /// uninterpreted string.  This switches the lexer out of directive mode.
  //<editor-fold defaultstate="collapsed" desc="clang::PTHLexer::DiscardToEndOfLine">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC, source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/PTHLexer.cpp", line = 159,
   FQN = "clang::PTHLexer::DiscardToEndOfLine", NM = "_ZN5clang8PTHLexer18DiscardToEndOfLineEv",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PTHLexer.cpp -nm=_ZN5clang8PTHLexer18DiscardToEndOfLineEv")
  //</editor-fold>
  protected void DiscardToEndOfLine() {
    assert (ParsingPreprocessorDirective && ParsingFilename == false) : "Must be in a preprocessing directive!";
    // JAVA PERF: use method which is faster and handles EOD location
    ReadToEndOfLine(null);
  }

  // JAVA FIX: copied from Lexer to allow PTHLexer produce user diagnostics
  /// ReadToEndOfLine - Read the rest of the current preprocessor line as an
  /// uninterpreted string.  This switches the lexer out of directive mode.
  //<editor-fold defaultstate="collapsed" desc="clang::Lexer::ReadToEndOfLine">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/Lexer.cpp", line = 2452,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/Lexer.cpp", old_line = 2424,
   FQN="clang::Lexer::ReadToEndOfLine", NM="_ZN5clang5Lexer15ReadToEndOfLineEPN4llvm15SmallVectorImplIcEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/Lexer.cpp -nm=_ZN5clang5Lexer15ReadToEndOfLineEPN4llvm15SmallVectorImplIcEE")
  //</editor-fold>
  @Override protected void ReadToEndOfLine(SmallString/*P*/ Result/*= 0*/) {
    // JAVA FIX: allow PTHLexer produce user diagnostics
    assert (ParsingPreprocessorDirective && ParsingFilename == false) : "Must be in a preprocessing directive!";

    // Skip tokens by only peeking at their token kind and the flags.
    // We don't need to actually reconstruct full tokens from the token buffer.
    // This saves some copies and IdentifierInfo* lookup.
    /*const*/int/*uchar P*/ p = CurPtr;
    /*SourceLocation*/int CurrentLoc = this.getCurCharSourceLocation();
    /*tok.TokenKind*/char Kind;
    do {
      // Read the token kind.  Are we at the end of the file?
      // PERF: do not bother about byte=>short conversion, because we check only for EOD/EOF
      Kind = $uchar2ushort(/*(uint8_t)*/TokBuf.$at(p));
      assert Kind != tok.TokenKind.eof : "must be EOD before EOF at " + p;
      
      // Read the token flags.  Are we at the start of the next line?
      // PERF: commented out and moved to assert
      // /*Token.TokenFlags*/int y = /*(uint8_t)*/TokBuf.$at(p+sizeof$uint8());
      assert (TokBuf.$at(p+sizeof$uint8()) & Token.TokenFlags.StartOfLine) == 0 : "Can not have token with start-of-line at " + p + " before EOD";

      // Skip to the next token.
      p += StoredTokenSize;
    } while (Kind != tok.TokenKind.eod);

    // We assume that if the preprocessor wishes to read to the end of
    // the line that it also means to end the current preprocessor directive.
    ParsingPreprocessorDirective = false;
    
    // prepare EOD location
    assert Kind == tok.TokenKind.eod : "Called not from pp-directive?";
    assert TokBuf.$at(p-StoredTokenSize) == tok.TokenKind.eod : "incorrectly shifted after EOD?" + p;
    int FileOffset = endian.read_uint32(little, aligned, TokBuf, p-sizeof$uint32());
    PreprocessorDirectiveEodLoc = SourceLocation.$getLocWithOffset(FileStartLoc, FileOffset);
    
    // when requested add source text as is
    if (Result != null) {
      CharSourceRange Range = CharSourceRange.getCharRange(CurrentLoc, PreprocessorDirectiveEodLoc);
      StringRef sourceText = Lexer.getSourceText(Range, PP.getSourceManager(), PP.getLangOpts());
      Result.append(sourceText);
    }

    CurPtr = p;      
  }
  
  /// isNextPPTokenLParen - Return 1 if the next unexpanded token will return a
  /// tok::l_paren token, 0 if it is something else and 2 if there are no more
  /// tokens controlled by this lexer.
  //<editor-fold defaultstate="collapsed" desc="clang::PTHLexer::isNextPPTokenLParen">
  @Converted(kind = Converted.Kind.MANUAL, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/PTHLexer.h", line = 81,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/PTHLexer.h", old_line = 82,
   FQN = "clang::PTHLexer::isNextPPTokenLParen", NM = "_ZN5clang8PTHLexer19isNextPPTokenLParenEv",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PTHLexer.cpp -nm=_ZN5clang8PTHLexer19isNextPPTokenLParenEv")
  //</editor-fold>
  public /*uint*/int isNextPPTokenLParen() {
    // isNextPPTokenLParen is not on the hot path, and all we care about is
    // whether or not we are at a token with kind tok::eof or tok::l_paren.
    // Just read the first byte from the current token pointer to determine
    // its kind.
    /*tok.TokenKind*/char x = $uchar2ushort(TokBuf.$at(CurPtr));
    // PERF: we don't need manually extend byte to keep unsigned, 
    // because interested only in eof && l_paren values which are less than 127
    return x == tok.TokenKind.eof ? 2 : (x == tok.TokenKind.l_paren ? 1 : 0);
  }

  
  /// IndirectLex - An indirect call to 'Lex' that can be invoked via
  ///  the PreprocessorLexer interface.
  //<editor-fold defaultstate="collapsed" desc="clang::PTHLexer::IndirectLex">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/PTHLexer.h", line = 92,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/PTHLexer.h", old_line = 93,
   FQN = "clang::PTHLexer::IndirectLex", NM = "_ZN5clang8PTHLexer11IndirectLexERNS_5TokenE",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PTHLexer.cpp -nm=_ZN5clang8PTHLexer11IndirectLexERNS_5TokenE")
  //</editor-fold>
  @Override public void IndirectLex(Token /*&*/ Result) {
    Lex(Result);
  }

  // JAVA: renamed from getSourceLocation in resolve_conflicts.properties
  /// getSourceLocation - Return a source location for the token in
  /// the current file.
  //<editor-fold defaultstate="collapsed" desc="clang::PTHLexer::getSourceLocation">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC, source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/PTHLexer.cpp", line = 286,
   FQN = "clang::PTHLexer::getSourceLocation", NM = "_ZN5clang8PTHLexer17getSourceLocationEv",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PTHLexer.cpp -nm=_ZN5clang8PTHLexer17getSourceLocationEv")
  //</editor-fold>
  @Override protected /*SourceLocation*/int getCurCharSourceLocation()/* override*/ {
    // getSourceLocation is not on the hot path.  It is used to get the location
    // of the next token when transitioning back to this lexer when done
    // handling a #included file.  Just read the necessary data from the token
    // data buffer to construct the SourceLocation object.
    // NOTE: This is a virtual function; hence it is defined out-of-line.
    //JAVA: using namespace llvm::support;

    // JAVA: it became hot due to object allocations
    // JAVA FIX: use the previos token + it's length
    if (this.CurPtr == 0) {
      // exactly the start of the file
      return FileStartLoc;
    } else {
      // remove $add and SourceLocation
      /*const*/int/*uchar P*/ OffsetPtr = this.CurPtr - 4; // last 32bits
      /*const*/int/*uchar P*/ LengthPtr = this.CurPtr - StoredTokenSize + 1 + 1; // 16bits after two bytes
      int/*uint32_t*/ Offset = endian.read_uint32(little, aligned, TokBuf, OffsetPtr);
                                      // PERF: OffsetPtr += sizeof$uint32(); // shift index
      int/*uint32_t*/ Len = endian.read_uint16(little, aligned, TokBuf, LengthPtr)/*unsigned*/;
                                      // PERF: LengthPtr += sizeof$uint16(); // shift index
      return SourceLocation.$getLocWithOffset(FileStartLoc, Offset + Len);
    }
  }
  
  @Override public/*SourceLocation*/int getFileLoc() {
    return FileStartLoc;
  }
  
  /// SkipBlock - Used by Preprocessor to skip the current conditional block.
  
  /// SkipBlock - Used by Preprocessor to skip the current conditional block.
  //<editor-fold defaultstate="collapsed" desc="clang::PTHLexer::SkipBlock">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC, source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/PTHLexer.cpp", line = 188,
   FQN = "clang::PTHLexer::SkipBlock", NM = "_ZN5clang8PTHLexer9SkipBlockEv",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PTHLexer.cpp -nm=_ZN5clang8PTHLexer9SkipBlockEv")
  //</editor-fold>
  /*friend*/final boolean SkipBlock() {
    assert true : "This method was changed to always finish after hash";
    
    assert ((PPCond != null)) : "No cached PP conditional information.";
    assert ((CurPPCondPtr != INVALID)) : "No cached PP conditional information.";
    assert ((LastHashTokPtr != INVALID)) : "No known '#' token.";
    
    /*const*/int/*uchar P*/ HashEntryI; // JAVA: Offset in TokBuf
    int/*uint32_t*/ TableIdx;
    
    do {
      // Read the token offset from the side-table.
      int/*uint32_t*/ Offset = endian.read_uint32(little, aligned, PPCond, CurPPCondPtr); 
                                    CurPPCondPtr+=sizeof$uint32();
      
      // Read the target table index from the side-table.
      TableIdx = endian.read_uint32(little, aligned, PPCond, CurPPCondPtr);
                                    CurPPCondPtr+=sizeof$uint32();
      
      // Compute the actual memory address of the '#' token data for this entry.
      HashEntryI = /*TokBuf.$add*/(Offset);
      
      // Optmization: "Sibling jumping".  #if...#else...#endif blocks can
      //  contain nested blocks.  In the side-table we can jump over these
      //  nested blocks instead of doing a linear search if the next "sibling"
      //  entry is not at a location greater than LastHashTokPtr.
      if ((HashEntryI < LastHashTokPtr) && (TableIdx != 0)) {
        // In the side-table we are still at an entry for a '#' token that
        // is earlier than the last one we saw.  Check if the location we would
        // stride gets us closer.
        /*const*/int/*uchar P*/ NextPPCondPtr = /*PPCond.$add*/(TableIdx * (sizeof$uint32() * 2));
        assert (NextPPCondPtr >= CurPPCondPtr);
        // Read where we should jump to. // JAVA: Offset in TokBuf
        /*const*/int/*uchar P*/ HashEntryJ = /*TokBuf.$add*/(endian.read_uint32(little, aligned, PPCond, NextPPCondPtr));
                                                                    NextPPCondPtr+=sizeof$uint32();
        if ((HashEntryJ <= LastHashTokPtr)) {
          // Jump directly to the next entry in the side table.
          HashEntryI =  HashEntryJ;
          TableIdx = endian.read_uint32(little, aligned, PPCond, NextPPCondPtr);
                            NextPPCondPtr+=sizeof$uint32();
          CurPPCondPtr = NextPPCondPtr;
        }
      }
    } while ((HashEntryI < LastHashTokPtr));
    assert (HashEntryI == LastHashTokPtr) : "No PP-cond entry found for '#'";
    assert ((TableIdx != 0)) : "No jumping from #endifs.";
    
    // Update our side-table iterator.
    /*const*/int/*uchar P*/ NextPPCondPtr = /*PPCond.$add*/(TableIdx * (sizeof$uint32() * 2));
    assert (NextPPCondPtr >= CurPPCondPtr);
    CurPPCondPtr = NextPPCondPtr;
    
    // Read where we should jump to.
    HashEntryI = /*TokBuf.$add*/(endian.read_uint32(little, aligned, PPCond, NextPPCondPtr));
                            NextPPCondPtr+=sizeof$uint32();
    int/*uint32_t*/ NextIdx = endian.read_uint32(little, aligned, PPCond, NextPPCondPtr);
                            //PERF: NextPPCondPtr+=sizeof$uint32();
    
    // By construction NextIdx will be zero if this is a #endif.  This is useful
    // to know to obviate lexing another token.
    boolean isEndif = NextIdx == 0;
    
    // JAVA FIX: initialize parsing PP mode and hash location
    assert !ParsingPreprocessorDirective;
    ParsingPreprocessorDirective = true;
    byte hashKind = TokBuf.$at(HashEntryI);
    assert (hashKind == tok.TokenKind.hash) || (hashKind == tok.TokenKind.eof) :
            "only hash or EOF for unterminated conditional directive is expected " + tok.getTokenName($uint2ushort(hashKind & 0xFF));
    int/*uint32_t*/ FileOffset = endian.read_uint32(little, aligned, TokBuf, HashEntryI + sizeof$uint32() + sizeof$uint32());
    PreprocessorDirectiveHashLoc = SourceLocation.$getLocWithOffset(FileStartLoc, FileOffset);
    if (hashKind == tok.TokenKind.eof) {
      // unterminated conditional directive
      LastHashTokPtr = HashEntryI;
      CurPtr = HashEntryI;
      assert isEndif : "incomplete files expected to be finished with fake endif";
      return true;
    }
    // This case can occur when we see something like this:
    //
    //  #if ...
    //   /* a comment or nothing */
    //  #elif
    //
    // If we are skipping the first #if block it will be the case that CurPtr
    // already points 'elif'.  Just return.
    if (CurPtr > HashEntryI) {
      // JAVA FIX: need to fix this case
      assert (CurPtr == (HashEntryI + StoredTokenSize));
      assert false : "investigate the usecase, but we are exactly after hash, so this is OK state";
      // Did we reach a #endif?  If so, go ahead and consume that token as well.
      if (isEndif) {
        // JAVA FIX: don't shift, but stay after hash to allow client filter out comment tokens
        // and lex endif token
        if (false) {
          CurPtr += (StoredTokenSize * 2);
        }
      } else {
        LastHashTokPtr = HashEntryI;
      }
      
      return isEndif;
    }
    
    // Otherwise, we need to advance.  Update CurPtr to point to the '#' token.
    CurPtr = HashEntryI;
    
    // Update the location of the last observed '#'.  This is useful if we
    // are skipping multiple blocks.
    LastHashTokPtr = CurPtr;
    assert (((short)(TokBuf.$at(CurPtr) & 0xFF)) == tok.TokenKind.hash);
    CurPtr += StoredTokenSize;
    
    // Did we reach a #endif?  If so, go ahead and consume that token as well.
    if (isEndif) {
      // JAVA FIX: don't shift, but stay after hash to allow client filter out comment tokens
      // and lex endif token
      if (false) {
        CurPtr += (StoredTokenSize * 2);
      }
    }
    
    return isEndif;
  }

  // JAVA FIX: introduced method in base class
  //<editor-fold defaultstate="collapsed" desc="clang::Lexer::cutOffLexing">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/Lexer.h", line = 642,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/Lexer.h", old_line = 622,
   FQN="clang::Lexer::cutOffLexing", NM="_ZN5clang5Lexer12cutOffLexingEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/Lexer.cpp -nm=_ZN5clang5Lexer12cutOffLexingEv")
  //</editor-fold>
  @Override/*friend*/protected void cutOffLexing() {
    // FIXME PERF: can pass EOF position to the constructor instead of below loop
    
    // Skip tokens by only peeking at their token kind 
    // We don't need to actually reconstruct full tokens from the token buffer.
    // This saves some copies and it also reduces IdentifierInfo* lookup.
    /*const*/int/*uchar P*/ p = CurPtr;
    while (true) {
      // Read the token kind.  Are we at the end of the file?
      /*tok.TokenKind*/char Kind = $uchar2ushort(/*(uint8_t)*/TokBuf.$at(p));
      if (Kind == tok.TokenKind.eof) {
        break;
      }
      // Skip to the next token.
      p += StoredTokenSize;
    }

    CurPtr = p;
  }

  private void CheckLiteralToken(Token Tok, /*tok.TokenKind*/char TKind, /*SourceLocation*/int TokenLoc, int Len) {
    if (LexingRawMode) {
      return;
    }
    assert Tok.getKind() == TKind : tok.getTokenName(TKind) + " vs. " + Tok;
    assert Tok.$getLocation() == TokenLoc : SourceLocation.getFromRawEncoding(TokenLoc) + " vs. " + Tok;
    assert Tok.getLength() == Len : Len + " vs " + Tok;
    LangOptions LangOpts = PP.getLangOpts();
    if (tok.isCharLiteral(TKind)) {
      CheckCharConstantToken(LangOpts, TKind, TokenLoc, Tok, Len);
    } else if (tok.isStringLiteral(TKind)) {
      CheckStringLiteralToken(LangOpts, TKind, TokenLoc, Tok, Len);
    } else if (Tok.isIncomplete()) {
      NativeTrace.assertTrueInConsole(false, "unexpected incomplete token", Tok);
    }
  }      

  private void CheckCharConstantToken(LangOptions LangOpts, /*tok.TokenKind*/char TKind, /*SourceLocation*/int TokenLoc, Token Tok, int Len) {
    assert true : "Copied diagnostics from Lexer.LexCharConstant";
    
    // we are not in LexingRawMode, so produce diagnostics
    assert !LexingRawMode;
    
    assert Tok.getKind() == TKind : tok.getTokenName(TKind) + " vs. " + Tok;
    assert Tok.$getLocation() == TokenLoc : SourceLocation.getFromRawEncoding(TokenLoc) + " vs. " + Tok;
    assert Tok.getLength() == Len : Len + " vs " + Tok;
    assert LangOpts == PP.getLangOpts();
    if (!isLexingRawMode()) {
      if (TKind == tok.TokenKind.utf16_char_constant || TKind == tok.TokenKind.utf32_char_constant) {
        PP.Diag(TokenLoc, LangOpts.CPlusPlus ? diag.warn_cxx98_compat_unicode_literal : diag.warn_c99_compat_unicode_literal).$destroy();
      } else if (TKind == tok.TokenKind.utf8_char_constant) {
        PP.Diag(TokenLoc, diag.warn_cxx14_compat_u8_character_literal).$destroy();
      }
    }
    
    if (Tok.isIncomplete()) {
      if (!isLexingRawMode() && !LangOpts.AsmPreprocessor) {
        boolean empty = false;
        if ((Tok.getLiteralData().$at(Len-1) == $$SGL_QUOTE)) {
          // distinguish empty literal '' vs. unterminated u8'
          int SglQuoteStartIdx = 0;
          // find starting quote skipping possible UTF prefixes
          while (SglQuoteStartIdx < (Len-1) && Tok.getLiteralData().$at(SglQuoteStartIdx) != $$SGL_QUOTE) {
            SglQuoteStartIdx++;
          }
          empty = (SglQuoteStartIdx == Len-2);
        }
        if (empty) {
          PP.Diag(TokenLoc, diag.ext_empty_character).$destroy();
        } else {
          $out_DiagnosticBuilder$C_int(PP.Diag(TokenLoc, diag.ext_unterminated_char_or_string), 0).$destroy();
        }
      }
    }
  }

  private void CheckStringLiteralToken(LangOptions LangOpts, /*tok.TokenKind*/char Kind, /*SourceLocation*/int TokenLoc, Token Tok, int Len) {
    assert true : "Copied diagnostics from Lexer.LexStringLiteral";
    
    // we are not in LexingRawMode, so produce diagnostics
    assert !LexingRawMode;
    
    assert Tok.getKind() == Kind : tok.getTokenName(Kind) + " vs. " + Tok;
    assert Tok.$getLocation() == TokenLoc : SourceLocation.getFromRawEncoding(TokenLoc) + " vs. " + Tok;
    assert Tok.getLength() == Len : Len + " vs " + Tok;
    assert LangOpts == PP.getLangOpts();
    if ((Kind == tok.TokenKind.utf8_string_literal || Kind == tok.TokenKind.utf16_string_literal || Kind == tok.TokenKind.utf32_string_literal)) {
      PP.Diag(TokenLoc, LangOpts.CPlusPlus ? diag.warn_cxx98_compat_unicode_literal : diag.warn_c99_compat_unicode_literal).$destroy();
    }
    
    if (Tok.isIncomplete()) {
      if (!LangOpts.AsmPreprocessor) {
        $out_DiagnosticBuilder$C_int(PP.Diag(TokenLoc, diag.ext_unterminated_char_or_string), 1).$destroy();
      }
    }
  }  
}
