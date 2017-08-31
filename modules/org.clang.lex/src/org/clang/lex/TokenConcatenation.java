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

import org.clang.basic.*;
import static org.clang.basic.BasicClangGlobals.*;
import org.clang.lex.*;
import static org.clank.java.std.*;
import org.clank.support.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.NativeType.*;
import org.clank.support.aliases.*;
import org.llvm.adt.*;
import org.llvm.support.*;
import static org.clang.lex.impl.TokenConcatenationStatics.*;
import static org.clank.support.Unsigned.*;


/// TokenConcatenation class, which answers the question of
///   "Is it safe to emit two tokens without a whitespace between them, or
///    would that cause implicit concatenation of the tokens?"
///
/// For example, it emitting two identifiers "foo" and "bar" next to each
/// other would cause the lexer to produce one "foobar" token.  Emitting "1"
/// and ")" next to each other is safe.
///
//<editor-fold defaultstate="collapsed" desc="clang::TokenConcatenation">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/TokenConcatenation.h", line = 31,
 FQN="clang::TokenConcatenation", NM="_ZN5clang18TokenConcatenationE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/TokenConcatenation.cpp -nm=_ZN5clang18TokenConcatenationE")
//</editor-fold>
public class TokenConcatenation {
  private Preprocessor /*&*/ PP;
  
  //<editor-fold defaultstate="collapsed" desc="clang::TokenConcatenation::AvoidConcatInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/TokenConcatenation.h", line = 34,
   FQN="clang::TokenConcatenation::AvoidConcatInfo", NM="_ZN5clang18TokenConcatenation15AvoidConcatInfoE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/TokenConcatenation.cpp -nm=_ZN5clang18TokenConcatenation15AvoidConcatInfoE")
  //</editor-fold>
  private static final class/*enum*/ AvoidConcatInfo {
    /// By default, a token never needs to avoid concatenation.  Most tokens
    /// (e.g. ',', ')', etc) don't cause a problem when concatenated.
    public static final int aci_never_avoid_concat = 0;
    
    /// aci_custom_firstchar - AvoidConcat contains custom code to handle this
    /// token's requirements, and it needs to know the first character of the
    /// token.
    public static final int aci_custom_firstchar = 1;
    
    /// aci_custom - AvoidConcat contains custom code to handle this token's
    /// requirements, but it doesn't need to know the first character of the
    /// token.
    public static final int aci_custom = 2;
    
    /// aci_avoid_equal - Many tokens cannot be safely followed by an '='
    /// character.  For example, "<<" turns into "<<=" when followed by an =.
    public static final int aci_avoid_equal = 4;
  };
  
  /// TokenInfo - This array contains information for each token on what
  /// action to take when avoiding concatenation of tokens in the AvoidConcat
  /// method.
  private final /*char*/byte TokenInfo[/*tok::NUM_TOKENS*/] = new$char(tok.TokenKind.NUM_TOKENS);
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::TokenConcatenation::TokenConcatenation">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/TokenConcatenation.cpp", line = 70,
   FQN = "clang::TokenConcatenation::TokenConcatenation", NM = "_ZN5clang18TokenConcatenationC1ERNS_12PreprocessorE",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/TokenConcatenation.cpp -nm=_ZN5clang18TokenConcatenationC1ERNS_12PreprocessorE")
  //</editor-fold>
  public TokenConcatenation(Preprocessor /*&*/ pp) {
    /* : PP(pp)*/ 
    //START JInit
    this./*&*/PP=/*&*/pp;
    //END JInit
    memset(TokenInfo, $$TERM, sizeof_array (TokenInfo));
    
    // These tokens have custom code in AvoidConcat.
    TokenInfo[tok.TokenKind.identifier] |= AvoidConcatInfo.aci_custom;
    TokenInfo[tok.TokenKind.numeric_constant] |= AvoidConcatInfo.aci_custom_firstchar;
    TokenInfo[tok.TokenKind.period] |= AvoidConcatInfo.aci_custom_firstchar;
    TokenInfo[tok.TokenKind.amp] |= AvoidConcatInfo.aci_custom_firstchar;
    TokenInfo[tok.TokenKind.plus] |= AvoidConcatInfo.aci_custom_firstchar;
    TokenInfo[tok.TokenKind.minus] |= AvoidConcatInfo.aci_custom_firstchar;
    TokenInfo[tok.TokenKind.slash] |= AvoidConcatInfo.aci_custom_firstchar;
    TokenInfo[tok.TokenKind.less] |= AvoidConcatInfo.aci_custom_firstchar;
    TokenInfo[tok.TokenKind.greater] |= AvoidConcatInfo.aci_custom_firstchar;
    TokenInfo[tok.TokenKind.pipe] |= AvoidConcatInfo.aci_custom_firstchar;
    TokenInfo[tok.TokenKind.percent] |= AvoidConcatInfo.aci_custom_firstchar;
    TokenInfo[tok.TokenKind.colon] |= AvoidConcatInfo.aci_custom_firstchar;
    TokenInfo[tok.TokenKind.hash] |= AvoidConcatInfo.aci_custom_firstchar;
    TokenInfo[tok.TokenKind.arrow] |= AvoidConcatInfo.aci_custom_firstchar;
    
    // These tokens have custom code in C++11 mode.
    if (PP.getLangOpts().CPlusPlus11) {
      TokenInfo[tok.TokenKind.string_literal] |= AvoidConcatInfo.aci_custom;
      TokenInfo[tok.TokenKind.wide_string_literal] |= AvoidConcatInfo.aci_custom;
      TokenInfo[tok.TokenKind.utf8_string_literal] |= AvoidConcatInfo.aci_custom;
      TokenInfo[tok.TokenKind.utf16_string_literal] |= AvoidConcatInfo.aci_custom;
      TokenInfo[tok.TokenKind.utf32_string_literal] |= AvoidConcatInfo.aci_custom;
      TokenInfo[tok.TokenKind.char_constant] |= AvoidConcatInfo.aci_custom;
      TokenInfo[tok.TokenKind.wide_char_constant] |= AvoidConcatInfo.aci_custom;
      TokenInfo[tok.TokenKind.utf16_char_constant] |= AvoidConcatInfo.aci_custom;
      TokenInfo[tok.TokenKind.utf32_char_constant] |= AvoidConcatInfo.aci_custom;
    }
    
    // These tokens have custom code in C++1z mode.
    if (PP.getLangOpts().CPlusPlus1z) {
      TokenInfo[tok.TokenKind.utf8_char_constant] |= AvoidConcatInfo.aci_custom;
    }
    
    // These tokens change behavior if followed by an '='.
    TokenInfo[tok.TokenKind.amp] |= AvoidConcatInfo.aci_avoid_equal; // &=
    TokenInfo[tok.TokenKind.plus] |= AvoidConcatInfo.aci_avoid_equal; // +=
    TokenInfo[tok.TokenKind.minus] |= AvoidConcatInfo.aci_avoid_equal; // -=
    TokenInfo[tok.TokenKind.slash] |= AvoidConcatInfo.aci_avoid_equal; // /=
    TokenInfo[tok.TokenKind.less] |= AvoidConcatInfo.aci_avoid_equal; // <=
    TokenInfo[tok.TokenKind.greater] |= AvoidConcatInfo.aci_avoid_equal; // >=
    TokenInfo[tok.TokenKind.pipe] |= AvoidConcatInfo.aci_avoid_equal; // |=
    TokenInfo[tok.TokenKind.percent] |= AvoidConcatInfo.aci_avoid_equal; // %=
    TokenInfo[tok.TokenKind.star] |= AvoidConcatInfo.aci_avoid_equal; // *=
    TokenInfo[tok.TokenKind.exclaim] |= AvoidConcatInfo.aci_avoid_equal; // !=
    TokenInfo[tok.TokenKind.lessless] |= AvoidConcatInfo.aci_avoid_equal; // <<=
    TokenInfo[tok.TokenKind.greatergreater] |= AvoidConcatInfo.aci_avoid_equal; // >>=
    TokenInfo[tok.TokenKind.caret] |= AvoidConcatInfo.aci_avoid_equal; // ^=
    TokenInfo[tok.TokenKind.equal] |= AvoidConcatInfo.aci_avoid_equal; // ==
  }

  
  
  /// AvoidConcat - If printing PrevTok immediately followed by Tok would cause
  /// the two individual tokens to be lexed as a single token, return true
  /// (which causes a space to be printed between them).  This allows the output
  /// of -E mode to be lexed to the same token stream as lexing the input
  /// directly would.
  ///
  /// This code must conservatively return true if it doesn't want to be 100%
  /// accurate.  This will cause the output to include extra space characters,
  /// but the resulting output won't have incorrect concatenations going on.
  /// Examples include "..", which we print with a space between, because we
  /// don't want to track enough to tell "x.." from "...".
  //<editor-fold defaultstate="collapsed" desc="clang::TokenConcatenation::AvoidConcat">
  @Converted(kind = Converted.Kind.MANUAL, optimized = Converted.Optimization.VALUE_TYPE,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/TokenConcatenation.cpp", line = 157,
   FQN="clang::TokenConcatenation::AvoidConcat", NM="_ZNK5clang18TokenConcatenation11AvoidConcatERKNS_5TokenES3_S3_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/TokenConcatenation.cpp -nm=_ZNK5clang18TokenConcatenation11AvoidConcatERKNS_5TokenES3_S3_")
  //</editor-fold>
  public boolean AvoidConcat(/*const*/ Token /*&*/ PrevPrevTok, 
             /*const*/ Token /*&*/ PrevTok, 
             /*const*/ Token /*&*/ Tok) /*const*/ {
    // First, check to see if the tokens were directly adjacent in the original
    // source.  If they were, it must be okay to stick them together: if there
    // were an issue, the tokens would have been lexed differently.
    SourceManager /*&*/ SM = PP.getSourceManager();
    /*SourceLocation*/int PrevSpellLoc = SM.getSpellingLoc(PrevTok.$getLocation());
    /*SourceLocation*/int SpellLoc = SM.getSpellingLoc(Tok.$getLocation());
    if (SourceLocation.$getLocWithOffset(PrevSpellLoc, PrevTok.getLength()) == SpellLoc) {
      return false;
    }

    /*tok.TokenKind*/char PrevKind = PrevTok.getKind();
    if (!PrevTok.isAnnotation() && (PrevTok.getIdentifierInfo() != null)) {
      PrevKind = tok.TokenKind.identifier; // Language keyword or named operator.
    }

    // Look up information on when we should avoid concatenation with prevtok.
    /*uint*/int ConcatInfo = $char2uint(TokenInfo[PrevKind]);

    // If prevtok never causes a problem for anything after it, return quickly.
    if (ConcatInfo == 0) {
      return false;
    }
    if (((ConcatInfo & AvoidConcatInfo.aci_avoid_equal) != 0)) {
      // If the next token is '=' or '==', avoid concatenation.
      if (Tok.isOneOf(tok.TokenKind.equal, tok.TokenKind.equalequal)) {
        return true;
      }
      ConcatInfo &= ~AvoidConcatInfo.aci_avoid_equal;
    }
    if (Tok.isAnnotation()) {
      // Modules annotation can show up when generated automatically for includes.
      assert (Tok.isOneOf$T(tok.TokenKind.annot_module_include, tok.TokenKind.annot_module_begin, tok.TokenKind.annot_module_end)) : "unexpected annotation in AvoidConcat";
      ConcatInfo = 0;
    }
    if (ConcatInfo == 0) {
      return false;
    }

    // Basic algorithm: we look at the first character of the second token, and
    // determine whether it, if appended to the first token, would form (or
    // would contribute) to a larger token if concatenated.
    /*char*/byte FirstChar = 0;
    if (((ConcatInfo & AvoidConcatInfo.aci_custom) != 0)) {
      // If the token does not need to know the first character, don't get it.
    } else {
      FirstChar = GetFirstChar(PP, Tok);
    }
    switch (PrevKind) {
     default:
      throw new llvm_unreachable("InitAvoidConcatTokenInfo built wrong");
     case tok.TokenKind.raw_identifier:
      throw new llvm_unreachable("tok::raw_identifier in non-raw lexing mode!");
     case tok.TokenKind.string_literal:
     case tok.TokenKind.wide_string_literal:
     case tok.TokenKind.utf8_string_literal:
     case tok.TokenKind.utf16_string_literal:
     case tok.TokenKind.utf32_string_literal:
     case tok.TokenKind.char_constant:
     case tok.TokenKind.wide_char_constant:
     case tok.TokenKind.utf8_char_constant:
     case tok.TokenKind.utf16_char_constant:
     case tok.TokenKind.utf32_char_constant:
      if (!PP.getLangOpts().CPlusPlus11) {
        return false;
      }

      // In C++11, a string or character literal followed by an identifier is a
      // single token.
      if ((Tok.getIdentifierInfo() != null)) {
        return true;
      }

      // A ud-suffix is an identifier. If the previous token ends with one, treat
      // it as an identifier.
      if (!PrevTok.hasUDSuffix()) {
        return false;
      }
     case tok.TokenKind.identifier: // id+id or id+number or id+L"foo".
      // id+'.'... will not append.
      if (Tok.is(tok.TokenKind.numeric_constant)) {
        return GetFirstChar(PP, Tok) != $$DOT;
      }
      if ((Tok.getIdentifierInfo() != null)
         || Tok.isOneOf$T(tok.TokenKind.wide_string_literal, tok.TokenKind.utf8_string_literal, 
          tok.TokenKind.utf16_string_literal, tok.TokenKind.utf32_string_literal, 
          tok.TokenKind.wide_char_constant, tok.TokenKind.utf8_char_constant, 
          tok.TokenKind.utf16_char_constant, tok.TokenKind.utf32_char_constant)) {
        return true;
      }

      // If this isn't identifier + string, we're done.
      if (Tok.isNot(tok.TokenKind.char_constant) && Tok.isNot(tok.TokenKind.string_literal)) {
        return false;
      }

      // Otherwise, this is a narrow character or string.  If the *identifier*
      // is a literal 'L', 'u8', 'u' or 'U', avoid pasting L "foo" -> L"foo".
      return IsIdentifierStringPrefix(PrevTok);
     case tok.TokenKind.numeric_constant:
      return isPreprocessingNumberBody(FirstChar)
         || FirstChar == $$PLUS || FirstChar == $$MINUS;
     case tok.TokenKind.period: // ..., .*, .1234
      return (FirstChar == $$DOT && PrevPrevTok.is(tok.TokenKind.period))
         || isDigit(FirstChar)
         || (PP.getLangOpts().CPlusPlus && FirstChar == $$STAR);
     case tok.TokenKind.amp: // &&
      return FirstChar == $$AMP;
     case tok.TokenKind.plus: // ++
      return FirstChar == $$PLUS;
     case tok.TokenKind.minus: // --, ->, ->*
      return FirstChar == $$MINUS || FirstChar == $$GT;
     case tok.TokenKind.slash: //, /*, //
      return FirstChar == $$STAR || FirstChar == $$SLASH;
     case tok.TokenKind.less: // <<, <<=, <:, <%
      return FirstChar == $$LT || FirstChar == $$COLON || FirstChar == $$PERCENT;
     case tok.TokenKind.greater: // >>, >>=
      return FirstChar == $$GT;
     case tok.TokenKind.pipe: // ||
      return FirstChar == $$PIPE;
     case tok.TokenKind.percent: // %>, %:
      return FirstChar == $$GT || FirstChar == $$COLON;
     case tok.TokenKind.colon: // ::, :>
      return FirstChar == $$GT
         || (PP.getLangOpts().CPlusPlus && FirstChar == $$COLON);
     case tok.TokenKind.hash: // ##, #@, %:%:
      return FirstChar == $$HASH || FirstChar == $$AT || FirstChar == $$PERCENT;
     case tok.TokenKind.arrow: // ->*
      return PP.getLangOpts().CPlusPlus && FirstChar == $$STAR;
    }
  }

/*private:*/
  /// IsIdentifierStringPrefix - Return true if the spelling of the token
  /// is literally 'L', 'u', 'U', or 'u8'.
  
  /// IsIdentifierStringPrefix - Return true if the spelling of the token
  /// is literally 'L', 'u', 'U', or 'u8'. Including raw versions.
  //<editor-fold defaultstate="collapsed" desc="clang::TokenConcatenation::IsIdentifierStringPrefix">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC, optimized = Converted.Optimization.VALUE_TYPE,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/TokenConcatenation.cpp", line = 48,
   FQN="clang::TokenConcatenation::IsIdentifierStringPrefix", NM="_ZNK5clang18TokenConcatenation24IsIdentifierStringPrefixERKNS_5TokenE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/TokenConcatenation.cpp -nm=_ZNK5clang18TokenConcatenation24IsIdentifierStringPrefixERKNS_5TokenE")
  //</editor-fold>
  private boolean IsIdentifierStringPrefix(/*const*/ Token /*&*/ Tok) /*const*/ {
    /*const*/ LangOptions /*&*/ LangOpts = PP.getLangOpts();
    if (!Tok.needsCleaning()) {
      if (Tok.getLength() < 1 || Tok.getLength() > 3) {
        return false;
      }
      SourceManager /*&*/ SM = PP.getSourceManager();
      // JAVA PERF:
      char$ptr$array $CharacterDataPtr = SM.$CharacterDataPtr();
      /*const*/char$ptr/*char P*/ Ptr = SM.getCharacterData_ValidOnly(SM.getSpellingLoc(Tok.$getLocation()), $CharacterDataPtr);
      boolean out = IsStringPrefix(new StringRef(Ptr, Tok.getLength()), LangOpts.CPlusPlus11);
      SM.$releaseCharacterDataPtr($CharacterDataPtr);
      return out;
    }
    if (Tok.getLength() < 256) {
      /*char*/byte Buffer[/*256*/] = new$char(256);
      /*const*/char$ptr/*char P*/ TokPtr = create_char$ptr(Buffer);
      /*uint*/int length = PP.getSpelling(Tok, TokPtr);
      return IsStringPrefix(new StringRef(TokPtr, length), LangOpts.CPlusPlus11);
    }
    
    return IsStringPrefix(new StringRef(PP.getSpelling(Tok)), LangOpts.CPlusPlus11);
  }
  
  
  public String toString() {
    return "" /* STACKOVERFLOW: NEVER PRINT Preprocessor + ", PP=" + PP // NOI18N */
              + ", TokenInfo=" + TokenInfo; // NOI18N
  }
}
