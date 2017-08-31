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
import org.clang.lex.llvm.ArrayRefToken;
import org.clang.basic.target.TargetInfo;
import org.clank.support.*;
import org.clank.support.aliases.*;
import static org.clank.support.Casts.*;
import static org.clank.java.std.*;
import static org.llvm.support.llvm.*;
import static org.clang.basic.BasicClangGlobals.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import org.llvm.adt.*;
import org.clang.basic.*;
import org.clang.lex.*;
import static org.clang.lex.LexClangGlobals.expandUCNs;
import static org.clang.lex.impl.LiteralSupportStatics.*;
import static org.clank.support.Unsigned.*;


/// StringLiteralParser - This decodes string escape characters and performs
/// wide string analysis and Translation Phase #6 (concatenation of string
/// literals) (C99 5.1.1.2p1).
//<editor-fold defaultstate="collapsed" desc="clang::StringLiteralParser">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/LiteralSupport.h", line = 194,
 old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/LiteralSupport.h", old_line = 184,
 FQN="clang::StringLiteralParser", NM="_ZN5clang19StringLiteralParserE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZN5clang19StringLiteralParserE")
//</editor-fold>
public class StringLiteralParser implements Destructors.ClassWithDestructor {
  private /*const*/ SourceManager /*&*/ SM;
  private /*const*/ LangOptions /*&*/ Features;
  private /*const*/ TargetInfo /*&*/ Target;
  private DiagnosticsEngine /*P*/ Diags;
  
  private /*uint*/int MaxTokenLength;
  private /*uint*/int SizeBound;
  private /*uint*/int CharByteWidth;
  private /*tok.TokenKind*/char Kind;
  private SmallString/*512*/ ResultBuf;
  private char$ptr/*char P*/ ResultPtr; // cursor
  private SmallString/*32*/ UDSuffixBuf;
  private /*uint*/int UDSuffixToken;
  private /*uint*/int UDSuffixOffset;
/*public:*/
  
  /// \verbatim
  ///       string-literal: [C++0x lex.string]
  ///         encoding-prefix " [s-char-sequence] "
  ///         encoding-prefix R raw-string
  ///       encoding-prefix:
  ///         u8
  ///         u
  ///         U
  ///         L
  ///       s-char-sequence:
  ///         s-char
  ///         s-char-sequence s-char
  ///       s-char:
  ///         any member of the source character set except the double-quote ",
  ///           backslash \, or new-line character
  ///         escape-sequence
  ///         universal-character-name
  ///       raw-string:
  ///         " d-char-sequence ( r-char-sequence ) d-char-sequence "
  ///       r-char-sequence:
  ///         r-char
  ///         r-char-sequence r-char
  ///       r-char:
  ///         any member of the source character set, except a right parenthesis )
  ///           followed by the initial d-char-sequence (which may be empty)
  ///           followed by a double quote ".
  ///       d-char-sequence:
  ///         d-char
  ///         d-char-sequence d-char
  ///       d-char:
  ///         any member of the basic source character set except:
  ///           space, the left parenthesis (, the right parenthesis ),
  ///           the backslash \, and the control characters representing horizontal
  ///           tab, vertical tab, form feed, and newline.
  ///       escape-sequence: [C++0x lex.ccon]
  ///         simple-escape-sequence
  ///         octal-escape-sequence
  ///         hexadecimal-escape-sequence
  ///       simple-escape-sequence:
  ///         one of \' \" \? \\ \a \b \f \n \r \t \v
  ///       octal-escape-sequence:
  ///         \ octal-digit
  ///         \ octal-digit octal-digit
  ///         \ octal-digit octal-digit octal-digit
  ///       hexadecimal-escape-sequence:
  ///         \x hexadecimal-digit
  ///         hexadecimal-escape-sequence hexadecimal-digit
  ///       universal-character-name:
  ///         \\u hex-quad
  ///         \U hex-quad hex-quad
  ///       hex-quad:
  ///         hex-digit hex-digit hex-digit hex-digit
  /// \endverbatim
  ///
  //<editor-fold defaultstate="collapsed" desc="clang::StringLiteralParser::StringLiteralParser">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/LiteralSupport.cpp", line = 1265,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/LiteralSupport.cpp", old_line = 1252,
   FQN="clang::StringLiteralParser::StringLiteralParser", NM="_ZN5clang19StringLiteralParserC1EN4llvm8ArrayRefINS_5TokenEEERNS_12PreprocessorEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/LiteralSupport.cpp -nm=_ZN5clang19StringLiteralParserC1EN4llvm8ArrayRefINS_5TokenEEERNS_12PreprocessorEb")
  //</editor-fold>
  public StringLiteralParser(ArrayRefToken StringToks, 
      Preprocessor /*&*/ PP) {
    this(StringToks, 
      PP, true);
  }
  public StringLiteralParser(ArrayRefToken StringToks, 
      Preprocessor /*&*/ PP, boolean Complain/*= true*/) {
    /* : SM(PP.getSourceManager()), Features(PP.getLangOpts()), Target(PP.getTargetInfo()), Diags(Complain ? &PP.getDiagnostics() : null), MaxTokenLength(0), SizeBound(0), CharByteWidth(0), Kind(tok::unknown), ResultBuf(), ResultPtr(ResultBuf.data()), UDSuffixBuf(), hadError(false), Pascal(false)*/ 
    //START JInit
    this./*&*/SM=/*&*/PP.getSourceManager();
    this./*&*/Features=/*&*/PP.getLangOpts();
    this./*&*/Target=/*&*/PP.getTargetInfo();
    this.Diags = Complain ? $AddrOf(PP.getDiagnostics()) : null;
    this.MaxTokenLength = 0;
    this.SizeBound = 0;
    this.CharByteWidth = 0;
    this.Kind = tok.TokenKind.unknown;
    this.ResultBuf = new SmallString/*512*/(512);
    this.ResultPtr = ResultBuf.data();
    this.UDSuffixBuf = new SmallString/*32*/(32);
    this.hadError = create_bool$ref(false);
    this.Pascal = false;
    //END JInit
    init(StringToks);
  }


  //<editor-fold defaultstate="collapsed" desc="clang::StringLiteralParser::StringLiteralParser">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/LiteralSupport.h", line = 212,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/LiteralSupport.h", old_line = 202,
   FQN="clang::StringLiteralParser::StringLiteralParser", NM="_ZN5clang19StringLiteralParserC1EN4llvm8ArrayRefINS_5TokenEEERKNS_13SourceManagerERKNS_11LangOptionsERKNS_10TargetInfoEPNS_17DiagnosticsEngineE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZN5clang19StringLiteralParserC1EN4llvm8ArrayRefINS_5TokenEEERKNS_13SourceManagerERKNS_11LangOptionsERKNS_10TargetInfoEPNS_17DiagnosticsEngineE")
  //</editor-fold>
  public StringLiteralParser(ArrayRefToken StringToks, 
      /*const*/ SourceManager /*&*/ sm, /*const*/ LangOptions /*&*/ features, 
      /*const*/ TargetInfo /*&*/ target) {
    this(StringToks, 
      sm, features, 
      target, 
      (DiagnosticsEngine /*P*/ )null);
  }
  public StringLiteralParser(ArrayRefToken StringToks, 
      /*const*/ SourceManager /*&*/ sm, /*const*/ LangOptions /*&*/ features, 
      /*const*/ TargetInfo /*&*/ target, 
      DiagnosticsEngine /*P*/ diags/*= null*/) {
    /* : SM(sm), Features(features), Target(target), Diags(diags), MaxTokenLength(0), SizeBound(0), CharByteWidth(0), Kind(tok::unknown), ResultBuf(), ResultPtr(ResultBuf.data()), UDSuffixBuf(), hadError(false), Pascal(false)*/ 
    //START JInit
    this./*&*/SM=/*&*/sm;
    this./*&*/Features=/*&*/features;
    this./*&*/Target=/*&*/target;
    this.Diags = diags;
    this.MaxTokenLength = 0;
    this.SizeBound = 0;
    this.CharByteWidth = 0;
    this.Kind = tok.TokenKind.unknown;
    this.ResultBuf = new SmallString/*512*/(512);
    this.ResultPtr = ResultBuf.data();
    this.UDSuffixBuf = new SmallString/*32*/(32);
    this.hadError = create_bool$ref(false);
    this.Pascal = false;
    //END JInit
    init(StringToks);
  }

  
  private bool$ref hadError; // JAVA: MANUAL_SEMANTIC added accessor to hide field
 
  @Converted(kind = Converted.Kind.MANUAL_ADDED)
  public boolean hadError() {
    return hadError.$deref();
  }
  
  public boolean Pascal;
  
  //<editor-fold defaultstate="collapsed" desc="clang::StringLiteralParser::GetString">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/LiteralSupport.h", line = 226,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/LiteralSupport.h", old_line = 216,
   FQN="clang::StringLiteralParser::GetString", NM="_ZNK5clang19StringLiteralParser9GetStringEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZNK5clang19StringLiteralParser9GetStringEv")
  //</editor-fold>
  public StringRef GetString() /*const*/ {
    return new StringRef(ResultBuf.data(), GetStringLength());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::StringLiteralParser::GetStringLength">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/LiteralSupport.h", line = 229,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/LiteralSupport.h", old_line = 219,
   FQN="clang::StringLiteralParser::GetStringLength", NM="_ZNK5clang19StringLiteralParser15GetStringLengthEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZNK5clang19StringLiteralParser15GetStringLengthEv")
  //</editor-fold>
  public /*uint*/int GetStringLength() /*const*/ {
    return ResultPtr.$sub(ResultBuf.data());
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::StringLiteralParser::GetNumStringChars">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/LiteralSupport.h", line = 231,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/LiteralSupport.h", old_line = 221,
   FQN="clang::StringLiteralParser::GetNumStringChars", NM="_ZNK5clang19StringLiteralParser17GetNumStringCharsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZNK5clang19StringLiteralParser17GetNumStringCharsEv")
  //</editor-fold>
  public /*uint*/int GetNumStringChars() /*const*/ {
    return GetStringLength() / CharByteWidth;
  }

  /// getOffsetOfStringByte - This function returns the offset of the
  /// specified byte of the string data represented by Token.  This handles
  /// advancing over escape sequences in the string.
  ///
  /// If the Diagnostics pointer is non-null, then this will do semantic
  /// checking of the string literal and emit errors and warnings.
  /// getOffsetOfStringByte - This function returns the offset of the
  /// specified byte of the string data represented by Token.  This handles
  /// advancing over escape sequences in the string.
  ///
  /// If the Diagnostics pointer is non-null, then this will do semantic
  /// checking of the string literal and emit errors and warnings.
  
  /// getOffsetOfStringByte - This function returns the offset of the
  /// specified byte of the string data represented by Token.  This handles
  /// advancing over escape sequences in the string.
  //<editor-fold defaultstate="collapsed" desc="clang::StringLiteralParser::getOffsetOfStringByte">
  @Converted(kind = Converted.Kind.MANUAL,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/LiteralSupport.cpp", line = 1625,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/LiteralSupport.cpp", old_line = 1612,
   FQN="clang::StringLiteralParser::getOffsetOfStringByte", NM="_ZNK5clang19StringLiteralParser21getOffsetOfStringByteERKNS_5TokenEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/LiteralSupport.cpp -nm=_ZNK5clang19StringLiteralParser21getOffsetOfStringByteERKNS_5TokenEj")
  //</editor-fold>
  public /*uint*/int getOffsetOfStringByte(/*const*/ Token /*&*/ Tok, 
          /*uint*/int ByteNo) /*const*/ {
    // Get the spelling of the token.
    SmallString/*32*/ SpellingBuffer/*J*/= new SmallString/*32*/(32);
    SpellingBuffer.resize(Tok.getLength());
    
    bool$ptr StringInvalid = null; // JAVA: use return value marker instead of bool$ptr
    /*const*/char$ptr/*char P*/ SpellingPtr = $noClone($AddrOf(SpellingBuffer.data()));
    /*uint*/int TokLen = Lexer.getSpelling(Tok, SpellingPtr, SM, Features, 
            /*AddrOf*/StringInvalid);
    if (TokLen == Lexer.INVALID_SPELLING) {
      return 0;
    }
    
    /*const*/char$ptr/*char P*/ SpellingStart = $tryClone(SpellingPtr);
    /*const*/char$ptr/*char P*/ SpellingEnd = $noClone(SpellingPtr.$add(TokLen));
    
    // Handle UTF-8 strings just like narrow strings.
    if (SpellingPtr.$at(0) == $$u && SpellingPtr.$at(1) == $$8) {
      SpellingPtr.$inc(2);
    }
    assert (SpellingPtr.$at(0) != $$L && SpellingPtr.$at(0) != $$u && SpellingPtr.$at(0) != $$U) : "Doesn't handle wide or utf strings yet";
    
    // For raw string literals, this is easy.
    if (SpellingPtr.$at(0) == $$R) {
      assert (SpellingPtr.$at(1) == $$DBL_QUOTE) : "Should be a raw string literal!";
      // Skip 'R"'.
      SpellingPtr.$inc(2);
      while (SpellingPtr.$star() != $$LPAREN) {
        SpellingPtr.$preInc();
        assert (SpellingPtr.$less(SpellingEnd)) : "Missing ( for raw string literal";
      }
      // Skip '('.
      SpellingPtr.$preInc();
      return SpellingPtr.$sub(SpellingStart) + ByteNo;
    }
    
    // Skip over the leading quote
    assert (SpellingPtr.$at(0) == $$DBL_QUOTE) : "Should be a string literal!";
    SpellingPtr.$preInc();
    
    // Skip over bytes until we find the offset we're looking for.
    while ((ByteNo != 0)) {
      assert (SpellingPtr.$less(SpellingEnd)) : "Didn't find byte offset!";
      
      // Step over non-escapes simply.
      if (SpellingPtr.$star() != $$BACK_SLASH) {
        SpellingPtr.$preInc();
        --ByteNo;
        continue;
      }
      
      // Otherwise, this is an escape character.  Advance over it.
      bool$ref HadError = create_bool$ref(false);
      if (SpellingPtr.$at(1) == $$u || SpellingPtr.$at(1) == $$U) {
        /*const*/int/*char P*/ EscapePtr = SpellingPtr.$index();
        /*uint*/int Len = MeasureUCNEscape(SpellingStart, SpellingPtr, SpellingEnd, 
                1, Features, HadError);
        if ($greater_uint(Len, ByteNo)) {
          // ByteNo is somewhere within the escape sequence.
          $setIndex(SpellingPtr, EscapePtr);
          break;
        }
        ByteNo -= Len;
      } else {
        ProcessCharEscape(SpellingStart, SpellingPtr, SpellingEnd, HadError, 
                new FullSourceLoc(Tok.$getLocation(), SM), 
                CharByteWidth * 8, Diags, Features);
        --ByteNo;
      }
      assert (!HadError.$deref()) : "This method isn't valid on erroneous strings";
    }
    
    return SpellingPtr.$sub(SpellingStart);
  }


  
  //<editor-fold defaultstate="collapsed" desc="clang::StringLiteralParser::isAscii">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/LiteralSupport.h", line = 242,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/LiteralSupport.h", old_line = 232,
   FQN="clang::StringLiteralParser::isAscii", NM="_ZNK5clang19StringLiteralParser7isAsciiEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZNK5clang19StringLiteralParser7isAsciiEv")
  //</editor-fold>
  public boolean isAscii() /*const*/ {
    return Kind == tok.TokenKind.string_literal;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::StringLiteralParser::isWide">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/LiteralSupport.h", line = 243,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/LiteralSupport.h", old_line = 233,
   FQN="clang::StringLiteralParser::isWide", NM="_ZNK5clang19StringLiteralParser6isWideEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZNK5clang19StringLiteralParser6isWideEv")
  //</editor-fold>
  public boolean isWide() /*const*/ {
    return Kind == tok.TokenKind.wide_string_literal;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::StringLiteralParser::isUTF8">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/LiteralSupport.h", line = 244,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/LiteralSupport.h", old_line = 234,
   FQN="clang::StringLiteralParser::isUTF8", NM="_ZNK5clang19StringLiteralParser6isUTF8Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZNK5clang19StringLiteralParser6isUTF8Ev")
  //</editor-fold>
  public boolean isUTF8() /*const*/ {
    return Kind == tok.TokenKind.utf8_string_literal;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::StringLiteralParser::isUTF16">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/LiteralSupport.h", line = 245,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/LiteralSupport.h", old_line = 235,
   FQN="clang::StringLiteralParser::isUTF16", NM="_ZNK5clang19StringLiteralParser7isUTF16Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZNK5clang19StringLiteralParser7isUTF16Ev")
  //</editor-fold>
  public boolean isUTF16() /*const*/ {
    return Kind == tok.TokenKind.utf16_string_literal;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::StringLiteralParser::isUTF32">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/LiteralSupport.h", line = 246,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/LiteralSupport.h", old_line = 236,
   FQN="clang::StringLiteralParser::isUTF32", NM="_ZNK5clang19StringLiteralParser7isUTF32Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZNK5clang19StringLiteralParser7isUTF32Ev")
  //</editor-fold>
  public boolean isUTF32() /*const*/ {
    return Kind == tok.TokenKind.utf32_string_literal;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::StringLiteralParser::isPascal">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/LiteralSupport.h", line = 247,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/LiteralSupport.h", old_line = 237,
   FQN="clang::StringLiteralParser::isPascal", NM="_ZNK5clang19StringLiteralParser8isPascalEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZNK5clang19StringLiteralParser8isPascalEv")
  //</editor-fold>
  public boolean isPascal() /*const*/ {
    return Pascal;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::StringLiteralParser::getUDSuffix">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/LiteralSupport.h", line = 249,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/LiteralSupport.h", old_line = 239,
   FQN="clang::StringLiteralParser::getUDSuffix", NM="_ZNK5clang19StringLiteralParser11getUDSuffixEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZNK5clang19StringLiteralParser11getUDSuffixEv")
  //</editor-fold>
  public StringRef getUDSuffix() /*const*/ {
    return UDSuffixBuf.$StringRef();
  }
  
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC, optimized = Converted.Optimization.VALUE_TYPE)
  public SmallString $getUDSuffix() /*const*/ {
    return UDSuffixBuf;
  }

  /// Get the index of a token containing a ud-suffix.
  //<editor-fold defaultstate="collapsed" desc="clang::StringLiteralParser::getUDSuffixToken">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/LiteralSupport.h", line = 252,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/LiteralSupport.h", old_line = 242,
   FQN="clang::StringLiteralParser::getUDSuffixToken", NM="_ZNK5clang19StringLiteralParser16getUDSuffixTokenEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZNK5clang19StringLiteralParser16getUDSuffixTokenEv")
  //</editor-fold>
  public /*uint*/int getUDSuffixToken() /*const*/ {
    assert (!UDSuffixBuf.empty()) : "no ud-suffix";
    return UDSuffixToken;
  }

  /// Get the spelling offset of the first byte of the ud-suffix.
  //<editor-fold defaultstate="collapsed" desc="clang::StringLiteralParser::getUDSuffixOffset">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/LiteralSupport.h", line = 257,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/LiteralSupport.h", old_line = 247,
   FQN="clang::StringLiteralParser::getUDSuffixOffset", NM="_ZNK5clang19StringLiteralParser17getUDSuffixOffsetEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZNK5clang19StringLiteralParser17getUDSuffixOffsetEv")
  //</editor-fold>
  public /*uint*/int getUDSuffixOffset() /*const*/ {
    assert (!UDSuffixBuf.empty()) : "no ud-suffix";
    return UDSuffixOffset;
  }

/*private:*/
  //<editor-fold defaultstate="collapsed" desc="clang::StringLiteralParser::init">
  @Converted(kind = Converted.Kind.MANUAL,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/LiteralSupport.cpp", line = 1275,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/LiteralSupport.cpp", old_line = 1262,
   FQN="clang::StringLiteralParser::init", NM="_ZN5clang19StringLiteralParser4initEN4llvm8ArrayRefINS_5TokenEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/LiteralSupport.cpp -nm=_ZN5clang19StringLiteralParser4initEN4llvm8ArrayRefINS_5TokenEEE")
  //</editor-fold>
  private void init(ArrayRefToken StringToks) {
    // The literal token may have come from an invalid source location (e.g. due
    // to a PCH error), in which case the token length will be 0.
    if (StringToks.empty() || $less_uint(StringToks.$at(0).getLength(), 2)) {
      // JAVA FIX: use token location when possible for better diagnostic
      DiagnoseLexingError(StringToks.empty() ? SourceLocation.getInvalid(): StringToks.$at(0).$getLocation());
      return;
    }
    
    // Scan all of the string portions, remember the max individual token length,
    // computing a bound on the concatenated string length, and see whether any
    // piece is a wide-string.  If any of the string portions is a wide-string
    // literal, the result is a wide-string literal [C99 6.4.5p4].
    assert (!StringToks.empty()) : "expected at least one token";
    MaxTokenLength = StringToks.$at(0).getLength();
    assert ($greatereq_uint(StringToks.$at(0).getLength(), 2)) : "literal token is invalid!";
    SizeBound = StringToks.$at(0).getLength() - 2; // -2 for "".
    Kind = StringToks.$at(0).getKind();
    
    hadError.$set(false);
    
    // Implement Translation Phase #6: concatenation of string literals
    /// (C99 5.1.1.2p1).  The common case is only one string fragment.
    for (/*uint*/int i = 1; i != StringToks.size(); ++i) {
      if ($less_uint(StringToks.$at(i).getLength(), 2)) {
        DiagnoseLexingError(StringToks.$at(i).$getLocation());
        return;
      }
  
      // The string could be shorter than this if it needs cleaning, but this is a
      // reasonable bound, which is all we need.
      assert ($greatereq_uint(StringToks.$at(i).getLength(), 2)) : "literal token is invalid!";
      SizeBound += StringToks.$at(i).getLength() - 2; // -2 for "".
      
      // Remember maximum string piece length.
      if ($greater_uint(StringToks.$at(i).getLength(), MaxTokenLength)) {
        MaxTokenLength = StringToks.$at(i).getLength();
      }
      
      // Remember if we see any wide or utf-8/16/32 strings.
      // Also check for illegal concatenations.
      if (StringToks.$at(i).isNot(Kind) && StringToks.$at(i).isNot(tok.TokenKind.string_literal)) {
        if (isAscii()) {
          Kind = StringToks.$at(i).getKind();
        } else {
          if ((Diags != null)) {
            JavaCleaner $c$ = $createJavaCleaner();
            try {
              $c$.clean($c$.track(Diags.Report(StringToks.$at(i).$getLocation(), 
                  diag.err_unsupported_string_concat)));
            } finally {
              $c$.$destroy();
            }
          }
          hadError.$set(true);
        }
      }
    }
    
    // Include space for the null terminator.
    ++SizeBound;
    
    // TODO: K&R warning: "traditional C rejects string constant concatenation"
    
    // Get the width in bytes of char/wchar_t/char16_t/char32_t
    CharByteWidth = getCharWidth(Kind, Target);
    assert ((CharByteWidth & 7) == 0) : "Assumes character size is byte multiple";
    CharByteWidth /= 8;
    
    // The output buffer size needs to be large enough to hold wide characters.
    // This is a worst-case assumption which basically corresponds to L"" "long".
    SizeBound *= CharByteWidth;
    
    // Size the temporary buffer to hold the result string data.
    ResultBuf.resize(SizeBound);
    
    // Likewise, but for each string piece.
    SmallString/*512*/ TokenBuf/*J*/= new SmallString/*512*/(512);
    TokenBuf.resize(MaxTokenLength);
    
    // Loop over all the strings, getting their spelling, and expanding them to
    // wide strings as appropriate.
    ResultPtr = $noClone($AddrOf(ResultBuf.data())); // Next byte to fill in.
    
    Pascal = false;
    
    /*SourceLocation*/int UDSuffixTokLoc/*J*/= SourceLocation.getInvalid();
    
    for (/*uint*/int i = 0, e = StringToks.size(); i != e; ++i) {
      /*const*/char$ptr/*char P*/ ThisTokBuf = $noClone($AddrOf(TokenBuf.data()));
      // Get the spelling of the token, which eliminates trigraphs, etc.  We know
      // that ThisTokBuf points to a buffer that is big enough for the whole token
      // and 'spelled' tokens can only shrink.
      bool$ptr StringInvalid = null; // JAVA: use return value marker instead of bool$ptr
      /*uint*/int ThisTokLen = Lexer.getSpelling(StringToks.$at(i), ThisTokBuf, SM, Features, 
              /*AddrOf*/StringInvalid);
      if (ThisTokLen == Lexer.INVALID_SPELLING) {
        DiagnoseLexingError(StringToks.$at(i).$getLocation());
        return;
      }
      
      /*const*/char$ptr/*char P*/ ThisTokBegin = $tryClone(ThisTokBuf);
      /*const*/char$ptr/*char P*/ ThisTokEnd = $noClone(ThisTokBuf.$add(ThisTokLen));
      
      // Remove an optional ud-suffix.
      if (ThisTokEnd.$at(-1) != $$DBL_QUOTE) {
        /*const*/int/*char P*/ UDSuffixEnd = ThisTokEnd.$index();
        do {
          ThisTokEnd.$preDec();
        } while (ThisTokEnd.$at(-1) != $$DBL_QUOTE);
        
        // PERF: we call $noClone + $cleanConst instead of $tryClone 
        // only because ThisTokEnd is not changed while UDSuffix is used
        // (although ThisTokEnd is modified after)
        StringRef UDSuffix/*J*/= new StringRef($noClone(ThisTokEnd), UDSuffixEnd - ThisTokEnd.$index());
        Native.$cleanConst(ThisTokEnd);
        //
        if (UDSuffixBuf.empty()) {
          if (StringToks.$at(i).hasUCN()) {
            expandUCNs(UDSuffixBuf, UDSuffix);
          } else {
            UDSuffixBuf.assign(UDSuffix);
          }
          UDSuffixToken = i;
          UDSuffixOffset = ThisTokEnd.$sub(ThisTokBuf);
          UDSuffixTokLoc = StringToks.$at(i).$getLocation();
        } else {
          SmallString/*32*/ ExpandedUDSuffix/*J*/= new SmallString/*32*/(32);
          if (StringToks.$at(i).hasUCN()) {
            expandUCNs(ExpandedUDSuffix, /*NO_COPY*/UDSuffix);
            UDSuffix.$assignMove(ExpandedUDSuffix.$StringRef());
          }
          
          // C++11 [lex.ext]p8: At the end of phase 6, if a string literal is the
          // result of a concatenation involving at least one user-defined-string-
          // literal, all the participating user-defined-string-literals shall
          // have the same ud-suffix.
          if ($noteq_StringRef(UDSuffixBuf.$StringRef(), /*NO_COPY*/UDSuffix)) {
            if ((Diags != null)) {
              JavaCleaner $c$ = $createJavaCleaner();
              try {
                /*SourceLocation*/int TokLoc = StringToks.$at(i).$getLocation();
                $c$.clean($out_DiagnosticBuilder$C_SourceRange($out_DiagnosticBuilder$C_SourceRange($out_DiagnosticBuilder$C_StringRef($out_DiagnosticBuilder$C_StringRef($c$.track(Diags.Report(/*NO_COPY*/TokLoc, diag.err_string_concat_mixed_suffix)), 
                                UDSuffixBuf.$StringRef()), /*NO_COPY*/UDSuffix), 
                        new SourceRange(/*NO_COPY*/UDSuffixTokLoc, /*NO_COPY*/UDSuffixTokLoc)), 
                    new SourceRange(/*NO_COPY*/TokLoc, /*NO_COPY*/TokLoc)));
              } finally {
                $c$.$destroy();
              }
            }
            hadError.$set(true);
          }
        }
      }
      
      // Strip the end quote.
      ThisTokEnd.$preDec();
      
      // TODO: Input character set mapping support.
      
      // Skip marker for wide or unicode strings.
      if (ThisTokBuf.$at(0) == $$L || ThisTokBuf.$at(0) == $$u || ThisTokBuf.$at(0) == $$U) {
        ThisTokBuf.$preInc();
        // Skip 8 of u8 marker for utf8 strings.
        if (ThisTokBuf.$at(0) == $$8) {
          ThisTokBuf.$preInc();
        }
      }

      // JAVA FIX:
      // in the case of "#pragma message \" \n " here ThisTokBuf becomes equal ThisTokEnd
      if (ThisTokBuf.$greatereq(ThisTokEnd)) {
        hadError.$set(true);
        return;
      }

      // Check for raw string
      if (ThisTokBuf.$at(0) == $$R) {
        ThisTokBuf.$inc(2); // skip R"
        
        /*const*/int/*char P*/ Prefix = ThisTokBuf.$index();
        while (ThisTokBuf.$at(0) !=$$LPAREN) {
          ThisTokBuf.$preInc();
        }
        ThisTokBuf.$preInc(); // skip '('
        
        // Remove same number of characters from the end
        ThisTokEnd.$dec(ThisTokBuf.$index() - Prefix);
        assert (ThisTokEnd.$greatereq(ThisTokBuf)) : "malformed raw string literal";
        
        // C++14 [lex.string]p4: A source-file new-line in a raw string literal
        // results in a new-line in the resulting execution string-literal.
        StringRef RemainingTokenSpan/*J*/= new StringRef(ThisTokBuf, ThisTokEnd.$sub(ThisTokBuf));
        while (!RemainingTokenSpan.empty()) {
          // Split the string literal on \r\n boundaries.
          /*size_t*/int CRLFPos = RemainingTokenSpan.find(/*STRINGREF_STR*/"\015\n");
          StringRef BeforeCRLF = RemainingTokenSpan.substr(0, CRLFPos);
          StringRef AfterCRLF = RemainingTokenSpan.substr(CRLFPos);
          
          // Copy everything before the \r\n sequence into the string literal.
          if (CopyStringFragment(StringToks.$at(i), ThisTokBegin, new StringRef(BeforeCRLF))) {
            hadError.$set(true);
          }
          
          // Point into the \n inside the \r\n sequence and operate on the
          // remaining portion of the literal.
          RemainingTokenSpan.$assignMove(AfterCRLF.substr(1));
        }
      } else {
        if (ThisTokBuf.$at(0) != $$DBL_QUOTE) {
          // The file may have come from PCH and then changed after loading the
          // PCH; Fail gracefully.
          DiagnoseLexingError(StringToks.$at(i).$getLocation());
          return;
        }
        ThisTokBuf.$preInc(); // skip "
        
        // Check if this is a pascal string
        if (Features.PascalStrings && $noteq_ptr(ThisTokBuf.$add(1), ThisTokEnd)
            && ThisTokBuf.$at(0) == $$BACK_SLASH && ThisTokBuf.$at(1) == $$p) {
          
          // If the \p sequence is found in the first token, we have a pascal string
          // Otherwise, if we already have a pascal string, ignore the first \p
          if (i == 0) {
            ThisTokBuf.$preInc();
            Pascal = true;
          } else if (Pascal) {
            ThisTokBuf.$inc(2);
          }
        }
        while (ThisTokBuf.$less(ThisTokEnd)) {
          // Is this a span of non-escape characters?
          if (ThisTokBuf.$at(0) != $$BACK_SLASH) {
            /*const*/char$ptr/*char P*/ InStart = $tryClone(ThisTokBuf);
            do {
              ThisTokBuf.$preInc();
            } while (ThisTokBuf.$less(ThisTokEnd) && ThisTokBuf.$at(0) != $$BACK_SLASH);
            
            // Copy the character span over.
            if (CopyStringFragment(StringToks.$at(i), ThisTokBegin, 
                    new StringRef(InStart, ThisTokBuf.$sub(InStart)))) {
              hadError.$set(true);
            }
            continue;
          }
          // Is this a Universal Character Name escape?
          if (ThisTokBuf.$at(1) == $$u || ThisTokBuf.$at(1) == $$U) {
            EncodeUCNEscape(ThisTokBegin, ThisTokBuf, ThisTokEnd, 
                ResultPtr.$addr().star$ref(), hadError, 
                new FullSourceLoc(StringToks.$at(i).$getLocation(), SM), 
                CharByteWidth, Diags, Features);
            continue;
          }
          // Otherwise, this is a non-UCN escape character.  Process it.
          /*uint*/int ResultChar = ProcessCharEscape(ThisTokBegin, ThisTokBuf, ThisTokEnd, hadError, 
              new FullSourceLoc(StringToks.$at(i).$getLocation(), SM), 
              CharByteWidth * 8, Diags, Features);
          if (CharByteWidth == 4) {
            // FIXME: Make the type of the result buffer correct instead of
            // using reinterpret_cast.
            uint$ptr/*UTF32 P*/ ResultWidePtr = $tryClone(reinterpret_cast(uint$ptr/*UTF32 P*/ .class, ResultPtr));
            ResultWidePtr.$set(ResultChar);
            ResultPtr.$inc(4);
          } else if (CharByteWidth == 2) {
            // FIXME: Make the type of the result buffer correct instead of
            // using reinterpret_cast.
            ushort$ptr/*UTF16 P*/ ResultWidePtr = $tryClone(reinterpret_cast(ushort$ptr/*UTF16 P*/ .class, ResultPtr));
            ResultWidePtr.$set($uint2UTF16(ResultChar & 0xFFFF));
            ResultPtr.$inc(2);
          } else {
            assert (CharByteWidth == 1) : "Unexpected char width";
            ResultPtr.$set($uint2char(ResultChar & 0xFF));
            ResultPtr.$preInc();
          }
        }
      }
    }
    if (Pascal) {
      if (CharByteWidth == 4) {
        // FIXME: Make the type of the result buffer correct instead of
        // using reinterpret_cast.
        uint$ptr/*UTF32 P*/ ResultWidePtr = $tryClone(reinterpret_cast(uint$ptr/*UTF32 P*/ .class, ResultBuf.data()));
        ResultWidePtr.$set(0, GetNumStringChars() - 1);
      } else if (CharByteWidth == 2) {
        // FIXME: Make the type of the result buffer correct instead of
        // using reinterpret_cast.
        ushort$ptr/*UTF16 P*/ ResultWidePtr = $tryClone(reinterpret_cast(ushort$ptr/*UTF16 P*/ .class, ResultBuf.data()));
        ResultWidePtr.$set(0, $uint2UTF16(GetNumStringChars() - 1));
      } else {
        assert (CharByteWidth == 1) : "Unexpected char width";
        ResultBuf.$set(0, $uint2char(GetNumStringChars() - 1));
      }
      
      // Verify that pascal strings aren't too large.
      if ($greater_uint(GetStringLength(), 256)) {
        if ((Diags != null)) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            $c$.clean($out_DiagnosticBuilder$C_SourceRange($c$.track(Diags.Report(StringToks.front().getLocation(), 
                    diag.err_pascal_string_too_long)), 
                new SourceRange(StringToks.front().getLocation(), 
                    StringToks.back().getLocation())));
          } finally {
            $c$.$destroy();
          }
        }
        hadError.$set(true);
        return;
      }
    } else if ((Diags != null)) {
      // Complain if this string literal has too many characters.
      /*uint*/int MaxChars = Features.CPlusPlus ? 65536 : Features.C99 ? 4095 : 509;
      if ($greater_uint(GetNumStringChars(), MaxChars)) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_DiagnosticBuilder$C_SourceRange($out_DiagnosticBuilder$C_int($out_DiagnosticBuilder$C_uint($out_DiagnosticBuilder$C_uint($c$.track(Diags.Report(StringToks.front().getLocation(), 
                              diag.ext_string_too_long)), 
                          GetNumStringChars()), MaxChars), 
                  (Features.CPlusPlus ? 2 : Features.C99 ? 1 : 0)), 
              new SourceRange(StringToks.front().getLocation(), 
                  StringToks.back().getLocation())));
        } finally {
          $c$.$destroy();
        }
      }
    }
  }

  
  
  /// \brief This function copies from Fragment, which is a sequence of bytes
  /// within Tok's contents (which begin at TokBegin) into ResultPtr.
  /// Performs widening for multi-byte characters.
  //<editor-fold defaultstate="collapsed" desc="clang::StringLiteralParser::CopyStringFragment">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/LiteralSupport.cpp", line = 1571,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/LiteralSupport.cpp", old_line = 1558,
   FQN="clang::StringLiteralParser::CopyStringFragment", NM="_ZN5clang19StringLiteralParser18CopyStringFragmentERKNS_5TokenEPKcN4llvm9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/LiteralSupport.cpp -nm=_ZN5clang19StringLiteralParser18CopyStringFragmentERKNS_5TokenEPKcN4llvm9StringRefE")
  //</editor-fold>
  private boolean CopyStringFragment(/*const*/ Token /*&*/ Tok, 
          /*const*/char$ptr/*char P*/ TokBegin, 
          StringRef Fragment) {
    /*const*/type$ref<char$ptr>/*UTF8 P*/ ErrorPtrTmp = create_type$ref(null);
    if (ConvertUTF8toWide(CharByteWidth, Fragment, ResultPtr.$addr().star$ref(), ErrorPtrTmp)) {
      return false;
    }
    
    // If we see bad encoding for unprefixed string literals, warn and
    // simply copy the byte values, for compatibility with gcc and older
    // versions of clang.
    boolean NoErrorOnBadEncoding = isAscii();
    if (NoErrorOnBadEncoding) {
      memcpy(ResultPtr, Fragment.data(), Fragment.size());
      ResultPtr.$inc(Fragment.size());
    }
    if ((Diags != null)) {
      /*const*/char$ptr/*char P*/ ErrorPtr = $tryClone(reinterpret_cast(/*const*/char$ptr/*char P*/ .class, ErrorPtrTmp.$deref()));
      
      FullSourceLoc SourceLoc/*J*/= new FullSourceLoc(Tok.$getLocation(), SM);
      /*const*/ DiagnosticBuilder /*&*/ Builder = Diag(Diags, Features, SourceLoc, TokBegin, 
              ErrorPtr, resyncUTF8(ErrorPtr, Fragment.end()), 
              NoErrorOnBadEncoding ? diag.warn_bad_string_encoding : diag.err_bad_string_encoding);
      
      /*const*/char$ptr/*char P*/ NextStart = $tryClone(resyncUTF8(ErrorPtr, Fragment.end()));
      StringRef NextFragment/*J*/= new StringRef(NextStart, Fragment.end().$sub(NextStart));
      
      // Decode into a dummy buffer.
      SmallString/*512*/ Dummy/*J*/= new SmallString/*512*/(512);
      Dummy.reserve(Fragment.size() * CharByteWidth);
      char$ptr/*char P*/ Ptr = $tryClone(Dummy.data());
      while (!ConvertUTF8toWide(CharByteWidth, NextFragment, Ptr.$addr().star$ref(), ErrorPtrTmp)) {
        /*const*/char$ptr/*char P*/ _ErrorPtr = $tryClone(reinterpret_cast(/*const*/char$ptr/*char P*/ .class, ErrorPtrTmp.$deref()));
        NextStart = $tryClone(resyncUTF8(_ErrorPtr, Fragment.end()));
        $out_DiagnosticBuilder$C_CharSourceRange$C(Builder, MakeCharSourceRange(Features, SourceLoc, TokBegin, 
                _ErrorPtr, NextStart));
        NextFragment.$assignMove(new StringRef(NextStart, Fragment.end().$sub(NextStart)));
      }
      // JAVA: bug 7508 - not Java-cleaned object is left in code
      Builder.$destroy();
    }
    return !NoErrorOnBadEncoding;
  }


  //<editor-fold defaultstate="collapsed" desc="clang::StringLiteralParser::DiagnoseLexingError">
  @Converted(kind = Converted.Kind.MANUAL,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/LiteralSupport.cpp", line = 1616,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/LiteralSupport.cpp", old_line = 1603,
   FQN="clang::StringLiteralParser::DiagnoseLexingError", NM="_ZN5clang19StringLiteralParser19DiagnoseLexingErrorENS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/LiteralSupport.cpp -nm=_ZN5clang19StringLiteralParser19DiagnoseLexingErrorENS_14SourceLocationE")
  //</editor-fold>
  private void DiagnoseLexingError(/*SourceLocation*/int Loc) {
    hadError.$set(true);
    if ((Diags != null)) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($c$.track(Diags.Report(/*NO_COPY*/Loc, diag.err_lexing_string)));
      } finally {
        $c$.$destroy();
      }
    }
  }


  //<editor-fold defaultstate="collapsed" desc="clang::StringLiteralParser::~StringLiteralParser">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/LiteralSupport.h", line = 194,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/LiteralSupport.h", old_line = 184,
   FQN="clang::StringLiteralParser::~StringLiteralParser", NM="_ZN5clang19StringLiteralParserD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZN5clang19StringLiteralParserD0Ev")
  //</editor-fold>
  public /*inline*/ void $destroy() {
    //START JDestroy
    UDSuffixBuf.$destroy();
    ResultBuf.$destroy();
    //END JDestroy
  }

  
  public String toString() {
    return "" /* STACKOVERFLOW: NEVER PRINT SourceManager + ", SourceMgr=" + SourceMgr // NOI18N*/
              + ", Features=" + Features // NOI18N
              + ", Target=" + Target // NOI18N
              /* STACKOVERFLOW: NEVER PRINT DIAGS + ", Diag=" + Diag // NOI18N*/
              + ", MaxTokenLength=" + MaxTokenLength // NOI18N
              + ", SizeBound=" + SizeBound // NOI18N
              + ", CharByteWidth=" + CharByteWidth // NOI18N
              + ", Kind=" + Kind // NOI18N
              + ", ResultBuf=" + ResultBuf // NOI18N
              + ", ResultPtr=" + ResultPtr // NOI18N
              + ", UDSuffixBuf=" + UDSuffixBuf // NOI18N
              + ", UDSuffixToken=" + UDSuffixToken // NOI18N
              + ", UDSuffixOffset=" + UDSuffixOffset // NOI18N
              + ", hadError=" + hadError // NOI18N
              + ", Pascal=" + Pascal; // NOI18N
  }  
}
