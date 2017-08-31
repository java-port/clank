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
import static org.clank.java.std.*;
import static org.llvm.adt.ADTAliases.*;
import static org.llvm.support.llvm.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.basic.*;
import org.clang.format.*;
import org.clang.lex.*;
import static org.clang.format.impl.EncodingStatics.*;
import static org.clang.basic.BasicClangGlobals.*;
import org.clang.format.java.FormatFunctionPointers.*;
import static org.clang.format.FormatGlobals.*;

//<editor-fold defaultstate="collapsed" desc="clang::format::FormatTokenLexer">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/FormatTokenLexer.h", line = 29,
 FQN="clang::format::FormatTokenLexer", NM="_ZN5clang6format16FormatTokenLexerE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/FormatTokenLexer.cpp -nm=_ZN5clang6format16FormatTokenLexerE")
//</editor-fold>
public class FormatTokenLexer implements Destructors.ClassWithDestructor {
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::format::FormatTokenLexer::FormatTokenLexer">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/FormatTokenLexer.cpp", line = 26,
   FQN="clang::format::FormatTokenLexer::FormatTokenLexer", NM="_ZN5clang6format16FormatTokenLexerC1ERKNS_13SourceManagerENS_6FileIDERKNS0_11FormatStyleENS0_8encoding8EncodingE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/FormatTokenLexer.cpp -nm=_ZN5clang6format16FormatTokenLexerC1ERKNS_13SourceManagerENS_6FileIDERKNS0_11FormatStyleENS0_8encoding8EncodingE")
  //</editor-fold>
  public FormatTokenLexer(final /*const*/ SourceManager /*&*/ SourceMgr, FileID ID, 
      final /*const*/ FormatStyle /*&*/ Style, 
      /*enum_conversion.properties: ADD FQN MAPPING FOR ENUM[encoding::Encoding] using FQN clang::format::encoding::Encoding*/Encoding $Encoding) {
    // : FormatTok(null), IsFirstToken(true), GreaterStashed(false), LessStashed(false), Column(0), TrailingWhitespace(0), Lex(), SourceMgr(SourceMgr), ID(ID), Style(Style), IdentTable(getFormattingLangOpts(Style)), Keywords(IdentTable), Encoding(Encoding), Allocator(), FirstInLineIndex(0), Tokens(), ForEachMacros(), FormattingDisabled(false), MacroBlockBeginRegex(Style.MacroBlockBegin), MacroBlockEndRegex(Style.MacroBlockEnd) 
    //START JInit
    this.FormatTok = null;
    this.IsFirstToken = true;
    this.GreaterStashed = false;
    this.LessStashed = false;
    this.Column = 0;
    this.TrailingWhitespace = 0;
    this.Lex = new std.unique_ptr<Lexer>();
    this./*&*/SourceMgr=/*&*/SourceMgr;
    this.ID = new FileID(ID);
    this./*&*/Style=/*&*/Style;
    this.IdentTable = new IdentifierTable(getFormattingLangOpts(Style));
    this.Keywords = new AdditionalKeywords(IdentTable);
    this.Encoding = $Encoding;
    this.Allocator = new SpecificBumpPtrAllocator<FormatToken>(FormatToken.class);
    this.FirstInLineIndex = 0;
    this.Tokens = new SmallVector<FormatToken /*P*/ >(16, (FormatToken /*P*/ )null);
    this.ForEachMacros = new SmallVector<IdentifierInfo /*P*/>(8, (IdentifierInfo /*P*/)null);
    this.FormattingDisabled = false;
    this.MacroBlockBeginRegex = new Regex(new StringRef(Style.MacroBlockBegin));
    this.MacroBlockEndRegex = new Regex(new StringRef(Style.MacroBlockEnd));
    //END JInit
    Lex.reset(new Lexer(/*NO_COPY*/ID, SourceMgr.getBuffer(/*NO_COPY*/ID), SourceMgr, 
            getFormattingLangOpts(Style)));
    Lex.$arrow().SetKeepWhitespaceMode(true);
    
    for (final /*const*/std.string/*&*/ ForEachMacro : Style.ForEachMacros)  {
      ForEachMacros.push_back(/*AddrOf*/IdentTable.get(/*new StringRef(*/ForEachMacro/*)*/));
    }
    std.sort(ForEachMacros.begin(), ForEachMacros.end());
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::format::FormatTokenLexer::lex">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/FormatTokenLexer.cpp", line = 45,
   FQN="clang::format::FormatTokenLexer::lex", NM="_ZN5clang6format16FormatTokenLexer3lexEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/FormatTokenLexer.cpp -nm=_ZN5clang6format16FormatTokenLexer3lexEv")
  //</editor-fold>
  public ArrayRef<FormatToken /*P*/ > lex() {
    assert (Tokens.empty());
    assert (FirstInLineIndex == 0);
    do {
      Tokens.push_back(getNextToken());
      if (Style.Language == FormatStyle.LanguageKind.LK_JavaScript) {
        tryParseJSRegexLiteral();
        tryParseTemplateString();
      }
      tryMergePreviousTokens();
      if ($greater_uint(Tokens.back().NewlinesBefore, 0) || Tokens.back().IsMultiline) {
        FirstInLineIndex = Tokens.size() - 1;
      }
    } while (Tokens.back().Tok.isNot(tok.TokenKind.eof));
    return new ArrayRef<FormatToken /*P*/ >(Tokens, true);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::format::FormatTokenLexer::getKeywords">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/FormatTokenLexer.h", line = 36,
   FQN="clang::format::FormatTokenLexer::getKeywords", NM="_ZN5clang6format16FormatTokenLexer11getKeywordsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/FormatTokenLexer.cpp -nm=_ZN5clang6format16FormatTokenLexer11getKeywordsEv")
  //</editor-fold>
  public /*const*/ AdditionalKeywords /*&*/ getKeywords() {
    return Keywords;
  }

/*private:*/
  //<editor-fold defaultstate="collapsed" desc="clang::format::FormatTokenLexer::tryMergePreviousTokens">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/FormatTokenLexer.cpp", line = 61,
   FQN="clang::format::FormatTokenLexer::tryMergePreviousTokens", NM="_ZN5clang6format16FormatTokenLexer22tryMergePreviousTokensEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/FormatTokenLexer.cpp -nm=_ZN5clang6format16FormatTokenLexer22tryMergePreviousTokensEv")
  //</editor-fold>
  private void tryMergePreviousTokens() {
    if (tryMerge_TMacro()) {
      return;
    }
    if (tryMergeConflictMarkers()) {
      return;
    }
    if (tryMergeLessLess()) {
      return;
    }
    if (Style.Language == FormatStyle.LanguageKind.LK_JavaScript) {
      final/*static*/ /*const*/ char JSIdentity[/*2*/] = tryMergePreviousTokens$$.JSIdentity;
      final/*static*/ /*const*/ char JSNotIdentity[/*2*/] = tryMergePreviousTokens$$.JSNotIdentity;
      final/*static*/ /*const*/ char JSShiftEqual[/*3*/] = tryMergePreviousTokens$$.JSShiftEqual;
      final/*static*/ /*const*/ char JSRightArrow[/*2*/] = tryMergePreviousTokens$$.JSRightArrow;
      // FIXME: Investigate what token type gives the correct operator priority.
      if (tryMergeTokens(new ArrayRefUShort/*<tok.TokenKind>*/(JSIdentity), TokenType.TT_BinaryOperator)) {
        return;
      }
      if (tryMergeTokens(new ArrayRefUShort/*<tok.TokenKind>*/(JSNotIdentity), TokenType.TT_BinaryOperator)) {
        return;
      }
      if (tryMergeTokens(new ArrayRefUShort/*<tok.TokenKind>*/(JSShiftEqual), TokenType.TT_BinaryOperator)) {
        return;
      }
      if (tryMergeTokens(new ArrayRefUShort/*<tok.TokenKind>*/(JSRightArrow), TokenType.TT_JsFatArrow)) {
        return;
      }
    }
  }
  private static final class tryMergePreviousTokens$$ {
    static final/*static*/ /*const*/ char JSIdentity[/*2*/] = new /*tok.TokenKind*/char [/*2*/] {tok.TokenKind.equalequal, tok.TokenKind.equal};
    static final/*static*/ /*const*/ char JSNotIdentity[/*2*/] = new /*tok.TokenKind*/char [/*2*/] {
      tok.TokenKind.exclaimequal, 
      tok.TokenKind.equal};
    static final/*static*/ /*const*/ char JSShiftEqual[/*3*/] = new /*tok.TokenKind*/char [/*3*/] {
      tok.TokenKind.greater, tok.TokenKind.greater, 
      tok.TokenKind.greaterequal};
    static final/*static*/ /*const*/ char JSRightArrow[/*2*/] = new /*tok.TokenKind*/char [/*2*/] {tok.TokenKind.equal, tok.TokenKind.greater};
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::format::FormatTokenLexer::tryMergeLessLess">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/FormatTokenLexer.cpp", line = 88,
   FQN="clang::format::FormatTokenLexer::tryMergeLessLess", NM="_ZN5clang6format16FormatTokenLexer16tryMergeLessLessEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/FormatTokenLexer.cpp -nm=_ZN5clang6format16FormatTokenLexer16tryMergeLessLessEv")
  //</editor-fold>
  private boolean tryMergeLessLess() {
    // Merge X,less,less,Y into X,lessless,Y unless X or Y is less.
    if ($less_uint(Tokens.size(), 3)) {
      return false;
    }
    
    boolean FourthTokenIsLess = false;
    if ($greater_uint(Tokens.size(), 3)) {
      FourthTokenIsLess = (Tokens.end().$sub(4)).$at(0).is_TokenKind(tok.TokenKind.less);
    }
    
    type$ptr<FormatToken /*P*/ /*P*/> First = $tryClone(Tokens.end().$sub(3));
    if (First.$at(2).is_TokenKind(tok.TokenKind.less) || First.$at(1).isNot(tok.TokenKind.less)
       || First.$at(0).isNot(tok.TokenKind.less) || FourthTokenIsLess) {
      return false;
    }
    
    // Only merge if there currently is no whitespace between the two "<".
    if ($noteq_SourceLocation$C(First.$at(1).WhitespaceRange.getBegin(), 
        First.$at(1).WhitespaceRange.getEnd())) {
      return false;
    }
    
    First.$at(0).Tok.setKind(tok.TokenKind.lessless);
    First.$at(0).TokenText.$assignMove(/*STRINGREF_STR*/$LT_LT);
    First.$at(0).ColumnWidth += 1;
    Tokens.erase(Tokens.end().$sub(2));
    return true;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::format::FormatTokenLexer::tryMergeTokens">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/FormatTokenLexer.cpp", line = 114,
   FQN="clang::format::FormatTokenLexer::tryMergeTokens", NM="_ZN5clang6format16FormatTokenLexer14tryMergeTokensEN4llvm8ArrayRefINS_3tok9TokenKindEEENS0_9TokenTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/FormatTokenLexer.cpp -nm=_ZN5clang6format16FormatTokenLexer14tryMergeTokensEN4llvm8ArrayRefINS_3tok9TokenKindEEENS0_9TokenTypeE")
  //</editor-fold>
  private boolean tryMergeTokens(ArrayRefUShort/*<tok.TokenKind>*/ Kinds, 
                TokenType NewType) {
    if ($less_uint(Tokens.size(), Kinds.size())) {
      return false;
    }
    
    type$ptr<FormatToken /*P*/ /*P*/> First = $tryClone(Tokens.end().$sub(Kinds.size()));
    if (!First.$at(0).is_TokenKind(Kinds.$at(0))) {
      return false;
    }
    /*uint*/int AddLength = 0;
    for (/*uint*/int i = 1; $less_uint(i, Kinds.size()); ++i) {
      if (!First.$at(i).is_TokenKind(Kinds.$at(i))
         || $noteq_SourceLocation$C(First.$at(i).WhitespaceRange.getBegin(), 
          First.$at(i).WhitespaceRange.getEnd())) {
        return false;
      }
      AddLength += First.$at(i).TokenText.size();
    }
    Tokens.resize(Tokens.size() - Kinds.size() + 1);
    First.$at(0).TokenText.$assignMove(new StringRef(First.$at(0).TokenText.data(), 
            First.$at(0).TokenText.size() + AddLength));
    First.$at(0).ColumnWidth += AddLength;
    First.$at(0).Type = NewType;
    return true;
  }

  
  // Returns \c true if \p Tok can only be followed by an operand in JavaScript.
  
  // Returns \c true if \p Tok can only be followed by an operand in JavaScript.
  //<editor-fold defaultstate="collapsed" desc="clang::format::FormatTokenLexer::precedesOperand">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/FormatTokenLexer.cpp", line = 140,
   FQN="clang::format::FormatTokenLexer::precedesOperand", NM="_ZN5clang6format16FormatTokenLexer15precedesOperandEPNS0_11FormatTokenE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/FormatTokenLexer.cpp -nm=_ZN5clang6format16FormatTokenLexer15precedesOperandEPNS0_11FormatTokenE")
  //</editor-fold>
  private boolean precedesOperand(FormatToken /*P*/ Tok) {
    // NB: This is not entirely correct, as an r_paren can introduce an operand
    // location in e.g. `if (foo) /bar/.exec(...);`. That is a rare enough
    // corner case to not matter in practice, though.
    return Tok.isOneOf(tok.TokenKind.period, tok.TokenKind.l_paren, tok.TokenKind.comma, tok.TokenKind.l_brace, 
        tok.TokenKind.r_brace, tok.TokenKind.l_square, tok.TokenKind.semi, tok.TokenKind.exclaim, 
        tok.TokenKind.colon, tok.TokenKind.question, tok.TokenKind.tilde)
       || Tok.isOneOf(tok.TokenKind.kw_return, tok.TokenKind.kw_do, tok.TokenKind.kw_case, tok.TokenKind.kw_throw, 
        tok.TokenKind.kw_else, tok.TokenKind.kw_new, tok.TokenKind.kw_delete, tok.TokenKind.kw_void, 
        tok.TokenKind.kw_typeof) || Tok.isOneOf(Keywords.kw_instanceof, Keywords.kw_in)
       || Tok.isBinaryOperator();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::format::FormatTokenLexer::canPrecedeRegexLiteral">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/FormatTokenLexer.cpp", line = 153,
   FQN="clang::format::FormatTokenLexer::canPrecedeRegexLiteral", NM="_ZN5clang6format16FormatTokenLexer22canPrecedeRegexLiteralEPNS0_11FormatTokenE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/FormatTokenLexer.cpp -nm=_ZN5clang6format16FormatTokenLexer22canPrecedeRegexLiteralEPNS0_11FormatTokenE")
  //</editor-fold>
  private boolean canPrecedeRegexLiteral(FormatToken /*P*/ Prev) {
    if (!(Prev != null)) {
      return true;
    }
    
    // Regex literals can only follow after prefix unary operators, not after
    // postfix unary operators. If the '++' is followed by a non-operand
    // introducing token, the slash here is the operand and not the start of a
    // regex.
    if (Prev.isOneOf(tok.TokenKind.plusplus, tok.TokenKind.minusminus)) {
      return ($less_uint(Tokens.size(), 3) || precedesOperand(Tokens.$at(Tokens.size() - 3)));
    }
    
    // The previous token must introduce an operand location where regex
    // literals can occur.
    if (!precedesOperand(Prev)) {
      return false;
    }
    
    return true;
  }

  
  // Tries to parse a JavaScript Regex literal starting at the current token,
  // if that begins with a slash and is in a location where JavaScript allows
  // regex literals. Changes the current token to a regex literal and updates
  // its text if successful.
  
  // Tries to parse a JavaScript Regex literal starting at the current token,
  // if that begins with a slash and is in a location where JavaScript allows
  // regex literals. Changes the current token to a regex literal and updates
  // its text if successful.
  //<editor-fold defaultstate="collapsed" desc="clang::format::FormatTokenLexer::tryParseJSRegexLiteral">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/FormatTokenLexer.cpp", line = 176,
   FQN="clang::format::FormatTokenLexer::tryParseJSRegexLiteral", NM="_ZN5clang6format16FormatTokenLexer22tryParseJSRegexLiteralEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/FormatTokenLexer.cpp -nm=_ZN5clang6format16FormatTokenLexer22tryParseJSRegexLiteralEv")
  //</editor-fold>
  private void tryParseJSRegexLiteral() {
    FormatToken /*P*/ RegexToken = Tokens.back();
    if (!RegexToken.isOneOf(tok.TokenKind.slash, tok.TokenKind.slashequal)) {
      return;
    }
    
    FormatToken /*P*/ Prev = null;
    for (std.reverse_iterator<FormatToken /*P*/ > I = Tokens.rbegin().$add(1), E = Tokens.rend(); $noteq_reverse_iterator$C(I, E); I.$preInc()) {
      // NB: Because previous pointers are not initialized yet, this cannot use
      // Token.getPreviousNonComment.
      if ((I.$star()).isNot(tok.TokenKind.comment)) {
        Prev = I.$star();
        break;
      }
    }
    if (!canPrecedeRegexLiteral(Prev)) {
      return;
    }
    
    // 'Manually' lex ahead in the current file buffer.
    /*const*/char$ptr/*char P*/ Offset = $tryClone(Lex.$arrow().getBufferLocation());
    /*const*/char$ptr/*char P*/ RegexBegin = $tryClone(Offset.$sub(RegexToken.TokenText.size()));
    StringRef Buffer = Lex.$arrow().getBuffer();
    boolean InCharacterClass = false;
    boolean HaveClosingSlash = false;
    for (; !HaveClosingSlash && $noteq_ptr(Offset, Buffer.end()); Offset.$preInc()) {
      // Regular expressions are terminated with a '/', which can only be
      // escaped using '\' or a character class between '[' and ']'.
      // See http://www.ecma-international.org/ecma-262/5.1/#sec-7.8.5.
      switch (Offset.$star()) {
       case '\\':
        // Skip the escaped character.
        Offset.$preInc();
        break;
       case '[':
        InCharacterClass = true;
        break;
       case ']':
        InCharacterClass = false;
        break;
       case '/':
        if (!InCharacterClass) {
          HaveClosingSlash = true;
        }
        break;
      }
    }
    
    RegexToken.Type = TokenType.TT_RegexLiteral;
    // Treat regex literals like other string_literals.
    RegexToken.Tok.setKind(tok.TokenKind.string_literal);
    RegexToken.TokenText.$assignMove(new StringRef(RegexBegin, Offset.$sub(RegexBegin)));
    RegexToken.ColumnWidth = RegexToken.TokenText.size();
    
    resetLexer(SourceMgr.getFileOffset(Lex.$arrow().getCharSourceLocation(Offset)));
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::format::FormatTokenLexer::tryParseTemplateString">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/FormatTokenLexer.cpp", line = 231,
   FQN="clang::format::FormatTokenLexer::tryParseTemplateString", NM="_ZN5clang6format16FormatTokenLexer22tryParseTemplateStringEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/FormatTokenLexer.cpp -nm=_ZN5clang6format16FormatTokenLexer22tryParseTemplateStringEv")
  //</editor-fold>
  private void tryParseTemplateString() {
    FormatToken /*P*/ BacktickToken = Tokens.back();
    //JAVA: lexer ctreats incomplete tokens instead some unknown
    if (!(BacktickToken.is_TokenKind(tok.TokenKind.unknown) || BacktickToken.Tok.isIncomplete()) || $noteq_StringRef(/*NO_COPY*/BacktickToken.TokenText, /*STRINGREF_STR*/"`")) {
      return;
    }
    
    // 'Manually' lex ahead in the current file buffer.
    /*const*/char$ptr/*char P*/ Offset = $tryClone(Lex.$arrow().getBufferLocation());
    /*const*/char$ptr/*char P*/ TmplBegin = $tryClone(Offset.$sub(BacktickToken.TokenText.size())); // at "`"
    for (; $noteq_ptr(Offset, Lex.$arrow().getBuffer().end()) && Offset.$star() != $$BACKQUOTE; Offset.$preInc()) {
      if (Offset.$star() == $$BACK_SLASH) {
        Offset.$preInc(); // Skip the escaped character.
      }
    }
    
    StringRef LiteralText/*J*/= new StringRef(TmplBegin, Offset.$sub(TmplBegin) + 1);
    BacktickToken.Type = TokenType.TT_TemplateString;
    BacktickToken.Tok.setKind(tok.TokenKind.string_literal);
    BacktickToken.TokenText.$assign(LiteralText);
    
    // Adjust width for potentially multiline string literals.
    /*size_t*/int FirstBreak = LiteralText.find($$LF);
    StringRef FirstLineText = FirstBreak == StringRef.npos ? new StringRef(LiteralText) : LiteralText.substr(0, FirstBreak);
    BacktickToken.ColumnWidth = EncodingStatics.columnWidthWithTabs(new StringRef(FirstLineText), BacktickToken.OriginalColumn, Style.TabWidth, Encoding);
    /*size_t*/int LastBreak = LiteralText.rfind($$LF);
    if (LastBreak != StringRef.npos) {
      BacktickToken.IsMultiline = true;
      /*uint*/int StartColumn = 0; // The template tail spans the entire line.
      BacktickToken.LastLineColumnWidth = EncodingStatics.columnWidthWithTabs(LiteralText.substr(LastBreak + 1, LiteralText.size()), StartColumn, 
          Style.TabWidth, Encoding);
    }
    
    resetLexer(SourceMgr.getFileOffset(Lex.$arrow().getCharSourceLocation(Offset.$add(1))));
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::format::FormatTokenLexer::tryMerge_TMacro">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/FormatTokenLexer.cpp", line = 268,
   FQN="clang::format::FormatTokenLexer::tryMerge_TMacro", NM="_ZN5clang6format16FormatTokenLexer15tryMerge_TMacroEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/FormatTokenLexer.cpp -nm=_ZN5clang6format16FormatTokenLexer15tryMerge_TMacroEv")
  //</editor-fold>
  private boolean tryMerge_TMacro() {
    if ($less_uint(Tokens.size(), 4)) {
      return false;
    }
    FormatToken /*P*/ Last = Tokens.back();
    if (!Last.is_TokenKind(tok.TokenKind.r_paren)) {
      return false;
    }
    
    FormatToken /*P*/ String = Tokens.$at(Tokens.size() - 2);
    if (!String.is_TokenKind(tok.TokenKind.string_literal) || String.IsMultiline) {
      return false;
    }
    if (!Tokens.$at(Tokens.size() - 3).is_TokenKind(tok.TokenKind.l_paren)) {
      return false;
    }
    
    FormatToken /*P*/ Macro = Tokens.$at(Tokens.size() - 4);
    if ($noteq_StringRef(/*NO_COPY*/Macro.TokenText, /*STRINGREF_STR*/"_T")) {
      return false;
    }
    
    /*const*/char$ptr/*char P*/ Start = $tryClone(Macro.TokenText.data());
    /*const*/char$ptr/*char P*/ End = $tryClone(Last.TokenText.data().$add(Last.TokenText.size()));
    String.TokenText.$assignMove(new StringRef(Start, End.$sub(Start)));
    String.IsFirst = Macro.IsFirst;
    String.LastNewlineOffset = Macro.LastNewlineOffset;
    String.WhitespaceRange.$assign(Macro.WhitespaceRange);
    String.OriginalColumn = Macro.OriginalColumn;
    String.ColumnWidth = EncodingStatics.columnWidthWithTabs(new StringRef(String.TokenText), String.OriginalColumn, Style.TabWidth, Encoding);
    String.NewlinesBefore = Macro.NewlinesBefore;
    String.HasUnescapedNewline = Macro.HasUnescapedNewline;
    
    Tokens.pop_back();
    Tokens.pop_back();
    Tokens.pop_back();
    Tokens.ref$back().$set(String);
    return true;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::format::FormatTokenLexer::tryMergeConflictMarkers">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/FormatTokenLexer.cpp", line = 305,
   FQN="clang::format::FormatTokenLexer::tryMergeConflictMarkers", NM="_ZN5clang6format16FormatTokenLexer23tryMergeConflictMarkersEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/FormatTokenLexer.cpp -nm=_ZN5clang6format16FormatTokenLexer23tryMergeConflictMarkersEv")
  //</editor-fold>
  private boolean tryMergeConflictMarkers() {
    if (Tokens.back().NewlinesBefore == 0 && Tokens.back().isNot(tok.TokenKind.eof)) {
      return false;
    }
    
    // Conflict lines look like:
    // <marker> <text from the vcs>
    // For example:
    // >>>>>>> /file/in/file/system at revision 1234
    //
    // We merge all tokens in a line that starts with a conflict marker
    // into a single token with a special token type that the unwrapped line
    // parser will use to correctly rebuild the underlying code.
    pairTypeUInt<FileID> tmp = SourceMgr.getDecomposedLoc(Tokens.$at(FirstInLineIndex).getStartOfNonWhitespace());
    FileID ID/*J*/= tmp.first;//new FileID();
    // Get the position of the first token in the line.
    /*uint*/int FirstInLineOffset = tmp.second;
    //std.tie(ID, FirstInLineOffset).$assign(SourceMgr.getDecomposedLoc(Tokens.$at(FirstInLineIndex).getStartOfNonWhitespace()));
    StringRef Buffer = SourceMgr.getBuffer(/*NO_COPY*/ID).getBuffer();
    // Calculate the offset of the start of the current line.
    /*size_t*/int LineOffset = Buffer.rfind($$LF, FirstInLineOffset);
    if (LineOffset == StringRef.npos) {
      LineOffset = 0;
    } else {
      ++LineOffset;
    }
    
    /*size_t*/int FirstSpace = Buffer.find_first_of(/*STRINGREF_STR*/" \n", LineOffset);
    StringRef LineStart/*J*/= new StringRef();
    if (FirstSpace == StringRef.npos) {
      LineStart.$assignMove(Buffer.substr(LineOffset));
    } else {
      LineStart.$assignMove(Buffer.substr(LineOffset, FirstSpace - LineOffset));
    }
    
    TokenType Type = TokenType.TT_Unknown;
    if ($eq_StringRef(/*NO_COPY*/LineStart, /*STRINGREF_STR*/"<<<<<<<") || $eq_StringRef(/*NO_COPY*/LineStart, /*STRINGREF_STR*/">>>>")) {
      Type = TokenType.TT_ConflictStart;
    } else if ($eq_StringRef(/*NO_COPY*/LineStart, /*STRINGREF_STR*/"|||||||") || $eq_StringRef(/*NO_COPY*/LineStart, /*STRINGREF_STR*/"=======")
       || $eq_StringRef(/*NO_COPY*/LineStart, /*STRINGREF_STR*/"====")) {
      Type = TokenType.TT_ConflictAlternative;
    } else if ($eq_StringRef(/*NO_COPY*/LineStart, /*STRINGREF_STR*/">>>>>>>") || $eq_StringRef(/*NO_COPY*/LineStart, /*STRINGREF_STR*/"<<<<")) {
      Type = TokenType.TT_ConflictEnd;
    }
    if (Type != TokenType.TT_Unknown) {
      FormatToken /*P*/ Next = Tokens.back();
      
      Tokens.resize(FirstInLineIndex + 1);
      // We do not need to build a complete token here, as we will skip it
      // during parsing anyway (as we must not touch whitespace around conflict
      // markers).
      Tokens.back().Type = Type;
      Tokens.back().Tok.setKind(tok.TokenKind.kw___unknown_anytype);
      
      Tokens.push_back(Next);
      return true;
    }
    
    return false;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::format::FormatTokenLexer::getStashedToken">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/FormatTokenLexer.cpp", line = 367,
   FQN="clang::format::FormatTokenLexer::getStashedToken", NM="_ZN5clang6format16FormatTokenLexer15getStashedTokenEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/FormatTokenLexer.cpp -nm=_ZN5clang6format16FormatTokenLexer15getStashedTokenEv")
  //</editor-fold>
  private FormatToken /*P*/ getStashedToken() {
    // Create a synthesized second '>' or '<' token.
    Token Tok = new Token(FormatTok.Tok);
    StringRef TokenText = new StringRef(FormatTok.TokenText);
    
    /*uint*/int OriginalColumn = FormatTok.OriginalColumn;
    FormatTok = ((/*JCast*/FormatToken /*P*/ )(/*NEW_EXPR [System] Allocator.Allocate() =*/ /*new (Allocator.Allocate())*/ $new_uint_voidPtr(Allocator.Allocate(), (type$ptr<?> New$Mem)->{
        return new FormatToken();
     })));
    FormatTok.Tok.$assign(Tok);
    SourceLocation TokLocation = FormatTok.Tok.getLocation().getLocWithOffset(Tok.getLength() - 1);
    FormatTok.Tok.setLocation(/*NO_COPY*/TokLocation);
    FormatTok.WhitespaceRange.$assignMove(new SourceRange(/*NO_COPY*/TokLocation, /*NO_COPY*/TokLocation));
    FormatTok.TokenText.$assign(TokenText);
    FormatTok.ColumnWidth = 1;
    FormatTok.OriginalColumn = OriginalColumn + 1;
    
    return FormatTok;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::format::FormatTokenLexer::getNextToken">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/FormatTokenLexer.cpp", line = 386,
   FQN="clang::format::FormatTokenLexer::getNextToken", NM="_ZN5clang6format16FormatTokenLexer12getNextTokenEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/FormatTokenLexer.cpp -nm=_ZN5clang6format16FormatTokenLexer12getNextTokenEv")
  //</editor-fold>
  private FormatToken /*P*/ getNextToken() {
    if (GreaterStashed) {
      GreaterStashed = false;
      return getStashedToken();
    }
    if (LessStashed) {
      LessStashed = false;
      return getStashedToken();
    }
    
    FormatTok = ((/*JCast*/FormatToken /*P*/ )(/*NEW_EXPR [System] Allocator.Allocate() =*/ /*new (Allocator.Allocate())*/ $new_uint_voidPtr(Allocator.Allocate(), (type$ptr<?> New$Mem)->{
        return new FormatToken();
     })));
    readRawToken(/*Deref*/FormatTok);
    SourceLocation WhitespaceStart = FormatTok.Tok.getLocation().getLocWithOffset(-TrailingWhitespace);
    FormatTok.IsFirst = IsFirstToken;
    IsFirstToken = false;
    
    // Consume and record whitespace until we find a significant token.
    /*uint*/int WhitespaceLength = TrailingWhitespace;
    //JAVA: lexer ctreats incomplete tokens instead some unknown
    while (FormatTok.Tok.is(tok.TokenKind.unknown) || FormatTok.Tok.isIncomplete()) {
      StringRef Text = new StringRef(FormatTok.TokenText);
      Int2UInt EscapesNewline = /*[&, &Text]*/ (int pos) -> {
            // A '\r' here is just part of '\r\n'. Skip it.
            if (pos >= 0 && Text.$at(pos) == $$CR) {
              --pos;
            }
            // See whether there is an odd number of '\' before this.
            /*uint*/int count = 0;
            for (; pos >= 0; --pos , ++count)  {
              if (Text.$at(pos) != $$BACK_SLASH) {
                break;
              }
            }
            return count & 1;
          };
      // FIXME: This miscounts tok:unknown tokens that are not just
      // whitespace, e.g. a '`' character.
      for (int i = 0, e = Text.size(); i != e; ++i) {
        switch (Text.$at(i)) {
         case '\n':
          ++FormatTok.NewlinesBefore;
          FormatTok.HasUnescapedNewline = !(EscapesNewline.$call(i - 1) != 0);
          FormatTok.LastNewlineOffset = WhitespaceLength + i + 1;
          Column = 0;
          break;
         case '\r':
          FormatTok.LastNewlineOffset = WhitespaceLength + i + 1;
          Column = 0;
          break;
         case '\f':
         case '\013'/*\v*/:
          Column = 0;
          break;
         case ' ':
          ++Column;
          break;
         case '\t':
          Column += Style.TabWidth - $rem_uint(Column, Style.TabWidth);
          break;
         case '\\':
          if (i + 1 == e || (Text.$at(i + 1) != $$CR && Text.$at(i + 1) != $$LF)) {
            FormatTok.Type = TokenType.TT_ImplicitStringLiteral;
          }
          break;
         default:
          FormatTok.Type = TokenType.TT_ImplicitStringLiteral;
          break;
        }
        if (FormatTok.Type == TokenType.TT_ImplicitStringLiteral) {
          break;
        }
      }
      if (FormatTok.is_TokenType(TokenType.TT_ImplicitStringLiteral)) {
        break;
      }
      WhitespaceLength += FormatTok.Tok.getLength();
      
      readRawToken(/*Deref*/FormatTok);
    }
    
    // In case the token starts with escaped newlines, we want to
    // take them into account as whitespace - this pattern is quite frequent
    // in macro definitions.
    // FIXME: Add a more explicit test.
    while ($greater_uint(FormatTok.TokenText.size(), 1) && FormatTok.TokenText.$at(0) == $$BACK_SLASH
       && FormatTok.TokenText.$at(1) == $$LF) {
      ++FormatTok.NewlinesBefore;
      WhitespaceLength += 2;
      FormatTok.LastNewlineOffset = 2;
      Column = 0;
      FormatTok.TokenText.$assignMove(FormatTok.TokenText.substr(2));
    }
    
    FormatTok.WhitespaceRange.$assignMove(new SourceRange(/*NO_COPY*/WhitespaceStart, WhitespaceStart.getLocWithOffset(WhitespaceLength)));
    
    FormatTok.OriginalColumn = Column;
    
    TrailingWhitespace = 0;
    if (FormatTok.Tok.is(tok.TokenKind.comment)) {
      // FIXME: Add the trimmed whitespace to Column.
      StringRef UntrimmedText = new StringRef(FormatTok.TokenText);
      FormatTok.TokenText.$assignMove(FormatTok.TokenText.rtrim(/*STRINGREF_STR*/" \t\013\014"));
      TrailingWhitespace = UntrimmedText.size() - FormatTok.TokenText.size();
    } else if (FormatTok.Tok.is(tok.TokenKind.raw_identifier)) {
      final IdentifierInfo /*&*/ Info = IdentTable.get(/*NO_COPY*/FormatTok.TokenText.$string());
      FormatTok.Tok.setIdentifierInfo(/*AddrOf*/Info);
      FormatTok.Tok.setKind(Info.getTokenID());
      if (Style.Language == FormatStyle.LanguageKind.LK_Java
         && FormatTok.isOneOf(tok.TokenKind.kw_struct, tok.TokenKind.kw_union, tok.TokenKind.kw_delete, 
          tok.TokenKind.kw_operator)) {
        FormatTok.Tok.setKind(tok.TokenKind.identifier);
        FormatTok.Tok.setIdentifierInfo((IdentifierInfo /*P*/ )null);
      } else if (Style.Language == FormatStyle.LanguageKind.LK_JavaScript
         && FormatTok.isOneOf(tok.TokenKind.kw_struct, tok.TokenKind.kw_union, 
          tok.TokenKind.kw_operator)) {
        FormatTok.Tok.setKind(tok.TokenKind.identifier);
        FormatTok.Tok.setIdentifierInfo((IdentifierInfo /*P*/ )null);
      }
    } else if (FormatTok.Tok.is(tok.TokenKind.greatergreater)) {
      FormatTok.Tok.setKind(tok.TokenKind.greater);
      FormatTok.TokenText.$assignMove(FormatTok.TokenText.substr(0, 1));
      GreaterStashed = true;
    } else if (FormatTok.Tok.is(tok.TokenKind.lessless)) {
      FormatTok.Tok.setKind(tok.TokenKind.less);
      FormatTok.TokenText.$assignMove(FormatTok.TokenText.substr(0, 1));
      LessStashed = true;
    }
    
    // Now FormatTok is the next non-whitespace token.
    StringRef Text = new StringRef(FormatTok.TokenText);
    /*size_t*/int FirstNewlinePos = Text.find($$LF);
    if (FirstNewlinePos == StringRef.npos) {
      // FIXME: ColumnWidth actually depends on the start column, we need to
      // take this into account when the token is moved.
      FormatTok.ColumnWidth
         = columnWidthWithTabs(new StringRef(Text), Column, Style.TabWidth, Encoding);
      Column += FormatTok.ColumnWidth;
    } else {
      FormatTok.IsMultiline = true;
      // FIXME: ColumnWidth actually depends on the start column, we need to
      // take this into account when the token is moved.
      FormatTok.ColumnWidth = columnWidthWithTabs(Text.substr(0, FirstNewlinePos), Column, Style.TabWidth, Encoding);
      
      // The last line of the token always starts in column 0.
      // Thus, the length can be precomputed even in the presence of tabs.
      FormatTok.LastLineColumnWidth = columnWidthWithTabs(Text.substr(Text.find_last_of($$LF) + 1), 0, Style.TabWidth, Encoding);
      Column = FormatTok.LastLineColumnWidth;
    }
    if (Style.Language == FormatStyle.LanguageKind.LK_Cpp) {
      if (!($greater_uint(Tokens.size(), 0) && (Tokens.back().Tok.getIdentifierInfo() != null)
         && Tokens.back().Tok.getIdentifierInfo().getPPKeywordID()
         == tok.PPKeywordKind.pp_define)
         && $noteq_ptr(std.find(ForEachMacros.begin(), ForEachMacros.end(), 
          FormatTok.Tok.getIdentifierInfo(), true), ForEachMacros.end())) {
        FormatTok.Type = TokenType.TT_ForEachMacro;
      } else if (FormatTok.is_TokenKind(tok.TokenKind.identifier)) {
        if (MacroBlockBeginRegex.find(/*match(*//*NO_COPY*/Text)) {
          FormatTok.Type = TokenType.TT_MacroBlockBegin;
        } else if (MacroBlockEndRegex.find(/*match(*//*NO_COPY*/Text)) {
          FormatTok.Type = TokenType.TT_MacroBlockEnd;
        }
      }
    }
    
    return FormatTok;
  }

  
  private FormatToken /*P*/ FormatTok;
  private boolean IsFirstToken;
  private boolean GreaterStashed;
  private boolean LessStashed;
  private /*uint*/int Column;
  private /*uint*/int TrailingWhitespace;
  private std.unique_ptr<Lexer> Lex;
  private final /*const*/ SourceManager /*&*/ SourceMgr;
  private FileID ID;
  private final /*const*/ FormatStyle /*&*/ Style;
  private IdentifierTable IdentTable;
  private AdditionalKeywords Keywords;
  private /*enum_conversion.properties: ADD FQN MAPPING FOR ENUM[encoding::Encoding] using FQN clang::format::encoding::Encoding*/Encoding Encoding;
  private SpecificBumpPtrAllocator<FormatToken> Allocator;
  // Index (in 'Tokens') of the last token that starts a new line.
  private /*uint*/int FirstInLineIndex;
  private SmallVector<FormatToken /*P*/ > Tokens;
  private SmallVector<IdentifierInfo /*P*/> ForEachMacros;
  
  private boolean FormattingDisabled;
  
  private Regex MacroBlockBeginRegex;
  private Regex MacroBlockEndRegex;
  
  //<editor-fold defaultstate="collapsed" desc="clang::format::FormatTokenLexer::readRawToken">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/FormatTokenLexer.cpp", line = 553,
   FQN="clang::format::FormatTokenLexer::readRawToken", NM="_ZN5clang6format16FormatTokenLexer12readRawTokenERNS0_11FormatTokenE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/FormatTokenLexer.cpp -nm=_ZN5clang6format16FormatTokenLexer12readRawTokenERNS0_11FormatTokenE")
  //</editor-fold>
  private void readRawToken(final FormatToken /*&*/ Tok) {
    Lex.$arrow().LexFromRawLexer(Tok.Tok);
    Tok.TokenText.$assignMove(SourceMgr.getCharacterDataStringRef_ValidOnly(Tok.Tok.getLocation().getRawEncoding(), Tok.Tok.getEndLoc().getRawEncoding()));
    // For formatting, treat unterminated string literals like normal string
    // literals.
    if (Tok.is_TokenKind(tok.TokenKind.unknown) || Tok.Tok.isIncomplete()) {
      if (!Tok.TokenText.empty() && Tok.TokenText.$at(0) == $$DBL_QUOTE) {
        if (Tok.Tok.getKind() == tok.TokenKind.string_literal) {
          Tok.Tok.clearFlag(Token.TokenFlags.Incomplete);
        } else {
          Tok.Tok.setKind(tok.TokenKind.string_literal);
        }
        Tok.IsUnterminatedLiteral = true;
      } else if (Style.Language == FormatStyle.LanguageKind.LK_JavaScript
         && $eq_StringRef(/*NO_COPY*/Tok.TokenText, /*STRINGREF_STR*/"''")) {
        Tok.Tok.setKind(tok.TokenKind.string_literal);
      }
    }
    if (Style.Language == FormatStyle.LanguageKind.LK_JavaScript
       && Tok.is_TokenKind(tok.TokenKind.char_constant)) {
      Tok.Tok.setKind(tok.TokenKind.string_literal);
    }
    if (Tok.is_TokenKind(tok.TokenKind.comment) && ($eq_StringRef(/*NO_COPY*/Tok.TokenText, /*STRINGREF_STR*/"// clang-format on")
       || $eq_StringRef(/*NO_COPY*/Tok.TokenText, /*STRINGREF_STR*/"/* clang-format on */"))) {
      FormattingDisabled = false;
    }
    
    Tok.Finalized = FormattingDisabled;
    if (Tok.is_TokenKind(tok.TokenKind.comment) && ($eq_StringRef(/*NO_COPY*/Tok.TokenText, /*STRINGREF_STR*/"// clang-format off")
       || $eq_StringRef(/*NO_COPY*/Tok.TokenText, /*STRINGREF_STR*/"/* clang-format off */"))) {
      FormattingDisabled = true;
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::format::FormatTokenLexer::resetLexer">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/FormatTokenLexer.cpp", line = 587,
   FQN="clang::format::FormatTokenLexer::resetLexer", NM="_ZN5clang6format16FormatTokenLexer10resetLexerEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/FormatTokenLexer.cpp -nm=_ZN5clang6format16FormatTokenLexer10resetLexerEj")
  //</editor-fold>
  private void resetLexer(/*uint*/int Offset) {
    StringRef Buffer = SourceMgr.getBufferData(/*NO_COPY*/ID);
    Lex.reset(new Lexer(SourceMgr.getLocForStartOfFile(/*NO_COPY*/ID), 
            getFormattingLangOpts(Style), Buffer.begin(), 
            Buffer.begin().$add(Offset), Buffer.end()));
    Lex.$arrow().SetKeepWhitespaceMode(true);
    TrailingWhitespace = 0;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::format::FormatTokenLexer::~FormatTokenLexer">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/FormatTokenLexer.h", line = 29,
   FQN="clang::format::FormatTokenLexer::~FormatTokenLexer", NM="_ZN5clang6format16FormatTokenLexerD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/TokenAnalyzer.cpp -nm=_ZN5clang6format16FormatTokenLexerD0Ev")
  //</editor-fold>
  public /*inline*/ void $destroy() {
    //START JDestroy
    MacroBlockEndRegex.$destroy();
    MacroBlockBeginRegex.$destroy();
    ForEachMacros.$destroy();
    Tokens.$destroy();
    Allocator.$destroy();
    IdentTable.$destroy();
    Lex.$destroy();
    //END JDestroy
  }


  
  @Override public String toString() {
    return "" + "FormatTok=" + FormatTok // NOI18N
              + ", IsFirstToken=" + IsFirstToken // NOI18N
              + ", GreaterStashed=" + GreaterStashed // NOI18N
              + ", LessStashed=" + LessStashed // NOI18N
              + ", Column=" + Column // NOI18N
              + ", TrailingWhitespace=" + TrailingWhitespace // NOI18N
              + ", Lex=" + "[Unique_ptr$Lexer]" // NOI18N
              + ", SourceMgr=" + "[SourceManager]" // NOI18N
              + ", ID=" + ID // NOI18N
              + ", Style=" + Style // NOI18N
              + ", IdentTable=" + IdentTable // NOI18N
              + ", Keywords=" + Keywords // NOI18N
              + ", Encoding=" + Encoding // NOI18N
              + ", Allocator=" + Allocator // NOI18N
              + ", FirstInLineIndex=" + FirstInLineIndex // NOI18N
              + ", Tokens=" + Tokens // NOI18N
              + ", ForEachMacros=" + ForEachMacros // NOI18N
              + ", FormattingDisabled=" + FormattingDisabled // NOI18N
              + ", MacroBlockBeginRegex=" + MacroBlockBeginRegex // NOI18N
              + ", MacroBlockEndRegex=" + MacroBlockEndRegex; // NOI18N
  }
}
