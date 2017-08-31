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

package org.clang.lex.impl;

import static org.clank.support.Native.$Deref;
import static org.clank.support.Native.$AddrOf;
import org.clank.support.*;
import org.clank.support.aliases.*;
import org.clang.basic.*;
import org.clang.lex.*;


//<editor-fold defaultstate="collapsed" desc="static type TokenLexerStatics">
@Converted(kind = Converted.Kind.MANUAL,
 cmd="jclank.sh -java-types-map=${SPUTNIK}/contrib/JConvert/llvmToClankType -java-imports=${SPUTNIK}/contrib/JConvert/llvmToClankImports -print ${LLVM_SRC}/llvm/tools/clang/lib/Lex/TokenLexer.cpp -file-filter=${LLVM_SRC}/llvm/tools/clang/lib/Lex/TokenLexer.cpp#743;${LLVM_SRC}/llvm/tools/clang/lib/Lex/TokenLexer.cpp#124; -static-type=TokenLexerStatics")
//</editor-fold>
public final class TokenLexerStatics {
  
/// \brief Checks if two tokens form wide string literal.
//<editor-fold defaultstate="collapsed" desc="isWideStringLiteralFromMacro">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION, 
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/TokenLexer.cpp", line = 410,
 FQN = "isWideStringLiteralFromMacro", NM = "_ZL28isWideStringLiteralFromMacroRKN5clang5TokenES2_",
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/TokenLexer.cpp -nm=_ZL28isWideStringLiteralFromMacroRKN5clang5TokenES2_")
//</editor-fold>
public static boolean isWideStringLiteralFromMacro(/*const*/ Token /*&*/ FirstTok, 
                            /*const*/ Token /*&*/ SecondTok) {
  return FirstTok.is(tok.TokenKind.identifier)
     && FirstTok.getIdentifierInfo().isStr("L") && SecondTok.isLiteral()
     && SecondTok.stringifiedInMacro();
}

/// \brief Finds the tokens that are consecutive (from the same FileID)
/// creates a single SLocEntry, and assigns SourceLocations to each token that
/// point to that SLocEntry. e.g for
///   assert(foo == bar);
/// There will be a single SLocEntry for the "foo == bar" chunk and locations
/// for the 'foo', '==', 'bar' tokens will point inside that chunk.
///
/// \arg begin_tokens will be updated to a position past all the found
/// consecutive tokens.
//<editor-fold defaultstate="collapsed" desc="updateConsecutiveMacroArgTokens">
@Converted(kind = Converted.Kind.MANUAL, optimized = Converted.Optimization.COMPLEX,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/TokenLexer.cpp", line = 765,
 FQN = "updateConsecutiveMacroArgTokens", NM = "_ZL31updateConsecutiveMacroArgTokensRN5clang13SourceManagerENS_14SourceLocationERPNS_5TokenES4_",
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/TokenLexer.cpp -nm=_ZL31updateConsecutiveMacroArgTokensRN5clang13SourceManagerENS_14SourceLocationERPNS_5TokenES4_")
//</editor-fold>
public static int updateConsecutiveMacroArgTokens(SourceManager /*&*/ SM, 
        /*SourceLocation*/int InstLoc, 
        Token[] /*P*//*&*/ begin_tokens, int begin_tokens_idx, 
        int /*P*/ end_tokens) {
  int$ptr $OffsPtr = SM.$getOffsetPtr();
  int out = updateConsecutiveMacroArgTokens($OffsPtr, SM, InstLoc, begin_tokens, begin_tokens_idx, end_tokens);
  SM.$releaseOffsetPtr($OffsPtr);
  return out;
}
private static int updateConsecutiveMacroArgTokens(int$ptr $OffsPtr, SourceManager /*&*/ SM, 
        /*SourceLocation*/int InstLoc, 
        Token[] /*P*//*&*/ begin_tokens, int begin_tokens_idx, 
        int /*P*/ end_tokens) {
  assert (begin_tokens_idx < end_tokens);
  
  /*SourceLocation*/int FirstLoc = begin_tokens[begin_tokens_idx].$getLocation();
  /*SourceLocation*/int CurLoc = FirstLoc;
  
  // Compare the source location offset of tokens and group together tokens that
  // are close, even if their locations point to different FileIDs. e.g.
  //
  //  |bar    |  foo | cake   |  (3 tokens from 3 consecutive FileIDs)
  //  ^                    ^
  //  |bar       foo   cake|     (one SLocEntry chunk for all tokens)
  //
  // we can perform this "merge" since the token's spelling location depends
  // on the relative offset.
  int /*P*/ NextTok = begin_tokens_idx + 1;
  for (; NextTok < end_tokens; ++NextTok) {
    /*SourceLocation*/int NextLoc = begin_tokens[NextTok].$getLocation();
    if (SourceLocation.isFileID(CurLoc) != SourceLocation.isFileID(NextLoc)) {
      break; // Token from different kind of FileID.
    }
    
    int$ptr RelOffs = $OffsPtr;
    if (!SM.isInSameSLocAddrSpace(CurLoc, NextLoc, $AddrOf(RelOffs))) {
      break; // Token from different local/loaded location.
      // Check that token is not before the previous token or more than 50
      // "characters" away.
    }
    if (RelOffs.$star() < 0 || RelOffs.$star() > 50) {
      break;
    }
    if (SourceLocation.isMacroID(CurLoc) && !SM.isWrittenInSameFile(/*NO_COPY*/CurLoc, /*NO_COPY*/NextLoc)) {
      break; // Token from a different macro.
    }
    
    CurLoc = NextLoc;
  }
  
  // For the consecutive tokens, find the length of the SLocEntry to contain
  // all of them.
  Token /*&*/ LastConsecutiveTok = $Deref(begin_tokens[NextTok-1]);
  int$ptr LastRelOffs = $OffsPtr;
  SM.isInSameSLocAddrSpace(FirstLoc, LastConsecutiveTok.$getLocation(), $AddrOf(LastRelOffs));
  /*uint*/int FullLength = LastRelOffs.$star() + LastConsecutiveTok.getLength();
  
  // Create a macro expansion SLocEntry that will "contain" all of the tokens.
  /*SourceLocation*/int Expansion = SM.createMacroArgExpansionLoc(/*NO_COPY*/FirstLoc, /*NO_COPY*/InstLoc, FullLength);
  
  // Change the location of the tokens from the spelling location to the new
  // expanded location.
  for (; begin_tokens_idx < NextTok; ++begin_tokens_idx) {
    Token /*&*/ Tok = $Deref(begin_tokens[begin_tokens_idx]);
    int$ptr RelOffs = $OffsPtr;
    SM.isInSameSLocAddrSpace(/*NO_COPY*/FirstLoc, Tok.$getLocation(), $AddrOf(RelOffs));
    Tok.setLocation(SourceLocation.$getLocWithOffset(Expansion, RelOffs.$star()));
  }
  return begin_tokens_idx;
}

} // END OF class TokenLexerStatics
