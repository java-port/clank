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
package org.clang.rewrite.frontend.impl;

import org.clank.support.*;
import org.clank.support.aliases.*;
import static org.clank.support.Unsigned.*;
import org.llvm.support.*;
import org.clang.basic.*;
import org.clang.lex.*;
import org.clang.lex.llvm.SmallVectorToken;


//<editor-fold defaultstate="collapsed" desc="static type RewriteMacrosStatics">
@Converted(kind = Converted.Kind.AUTO,
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteMacros.cpp -nm=_ZL11isSameTokenRN5clang5TokenES1_;_ZL13GetNextRawTokRKSt6vectorIN5clang5TokenESaIS1_EERjb;_ZL24LexRawTokensFromMainFileRN5clang12PreprocessorERSt6vectorINS_5TokenESaIS3_EE; -static-type=RewriteMacrosStatics -package=org.clang.rewrite.frontend.impl")
//</editor-fold>
public final class RewriteMacrosStatics {


/// isSameToken - Return true if the two specified tokens start have the same
/// content.
//<editor-fold defaultstate="collapsed" desc="isSameToken">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteMacros.cpp", line = 28,
 FQN="isSameToken", NM="_ZL11isSameTokenRN5clang5TokenES1_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteMacros.cpp -nm=_ZL11isSameTokenRN5clang5TokenES1_")
//</editor-fold>
public static boolean isSameToken(Token /*&*/ RawTok, Token /*&*/ PPTok) {
  // If two tokens have the same kind and the same identifier info, they are
  // obviously the same.
  if (PPTok.getKind() == RawTok.getKind()
     && PPTok.getIdentifierInfo() == RawTok.getIdentifierInfo()) {
    return true;
  }
  
  // Otherwise, if they are different but have the same identifier info, they
  // are also considered to be the same.  This allows keywords and raw lexed
  // identifiers with the same name to be treated the same.
  if ((PPTok.getIdentifierInfo() != null)
     && PPTok.getIdentifierInfo() == RawTok.getIdentifierInfo()) {
    return true;
  }
  
  return false;
}


/// GetNextRawTok - Return the next raw token in the stream, skipping over
/// comments if ReturnComment is false.
//<editor-fold defaultstate="collapsed" desc="GetNextRawTok">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*use SmallVectorToken*/,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteMacros.cpp", line = 48,
 FQN="GetNextRawTok", NM="_ZL13GetNextRawTokRKSt6vectorIN5clang5TokenESaIS1_EERjb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteMacros.cpp -nm=_ZL13GetNextRawTokRKSt6vectorIN5clang5TokenESaIS1_EERjb")
//</editor-fold>
public static /*const*/ Token /*&*/ GetNextRawTok(/*const*/SmallVectorToken /*&*/ RawTokens, 
             uint$ref/*uint &*/ CurTok, boolean ReturnComment) {
  assert ($less_uint(CurTok.$deref(), RawTokens.size())) : "Overran eof!";
  
  // If the client doesn't want comments and we have one, skip it.
  if (!ReturnComment && RawTokens.$at$Const(CurTok.$deref()).is(tok.TokenKind.comment)) {
    CurTok.$set$preInc();
  }
  
  return RawTokens.$at$Const(CurTok.$set$postInc());
}


/// LexRawTokensFromMainFile - Lets all the raw tokens from the main file into
/// the specified vector.
//<editor-fold defaultstate="collapsed" desc="LexRawTokensFromMainFile">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*use SmallVectorToken*/,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteMacros.cpp", line = 62,
 FQN="LexRawTokensFromMainFile", NM="_ZL24LexRawTokensFromMainFileRN5clang12PreprocessorERSt6vectorINS_5TokenESaIS3_EE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteMacros.cpp -nm=_ZL24LexRawTokensFromMainFileRN5clang12PreprocessorERSt6vectorINS_5TokenESaIS3_EE")
//</editor-fold>
public static void LexRawTokensFromMainFile(Preprocessor /*&*/ PP, 
                        SmallVectorToken /*&*/ RawTokens) {
  Lexer RawLex = null;
  try {
    SourceManager /*&*/ SM = PP.getSourceManager();
    
    // Create a lexer to lex all the tokens of the main file in raw mode.  Even
    // though it is in raw mode, it will not return comments.
    /*const*/ MemoryBuffer /*P*/ FromFile = SM.getBuffer(SM.getMainFileID());
    RawLex/*J*/= new Lexer(SM.getMainFileID(), FromFile, SM, PP.getLangOpts());
    
    // Switch on comment lexing because we really do want them.
    RawLex.SetCommentRetentionState(true);
    
    Token RawTok/*J*/= new Token();
    do {
      RawLex.LexFromRawLexer(RawTok);
      
      // If we have an identifier with no identifier info for our raw token, look
      // up the indentifier info.  This is important for equality comparison of
      // identifier tokens.
      if (RawTok.is(tok.TokenKind.raw_identifier)) {
        PP.LookUpIdentifierInfo(RawTok);
      }
      
      RawTokens.push_back_T$C$R(RawTok);
    } while (RawTok.isNot(tok.TokenKind.eof));
  } finally {
    if (RawLex != null) { RawLex.$destroy(); }
  }
}

} // END OF class RewriteMacrosStatics
