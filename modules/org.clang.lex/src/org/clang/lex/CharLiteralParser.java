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
import org.clank.support.*;
import org.clank.support.aliases.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.support.Casts.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.basic.*;
import org.clang.lex.*;
import static org.clang.lex.LexClangGlobals.*;
import static org.llvm.support.ConvertUTFGlobals.*;
import static org.clang.lex.impl.LiteralSupportStatics.*;

/// CharLiteralParser - Perform interpretation and semantic analysis of a
/// character literal.
//<editor-fold defaultstate="collapsed" desc="clang::CharLiteralParser">
@Converted(kind = Converted.Kind.MANUAL,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/LiteralSupport.h", line = 164,
 old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/LiteralSupport.h", old_line = 154,
 FQN="clang::CharLiteralParser", NM="_ZN5clang17CharLiteralParserE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/LiteralSupport.cpp -nm=_ZN5clang17CharLiteralParserE")
//</editor-fold>
public class CharLiteralParser implements Destructors.ClassWithDestructor {
  private long/*uint64_t*/ Value;
  private /*tok.TokenKind*/char Kind;
  private boolean IsMultiChar;
  private boolean HadError;
  private SmallString/*32*/ UDSuffixBuf;
  private /*uint*/int UDSuffixOffset;
/*public:*/
  
  /// \verbatim
  ///       user-defined-character-literal: [C++11 lex.ext]
  ///         character-literal ud-suffix
  ///       ud-suffix:
  ///         identifier
  ///       character-literal: [C++11 lex.ccon]
  ///         ' c-char-sequence '
  ///         u' c-char-sequence '
  ///         U' c-char-sequence '
  ///         L' c-char-sequence '
  ///         u8' c-char-sequence ' [C++1z lex.ccon]  
  ///       c-char-sequence:
  ///         c-char
  ///         c-char-sequence c-char
  ///       c-char:
  ///         any member of the source character set except the single-quote ',
  ///           backslash \, or new-line character
  ///         escape-sequence
  ///         universal-character-name
  ///       escape-sequence:
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
  ///       universal-character-name: [C++11 lex.charset]
  ///         \\u hex-quad
  ///         \U hex-quad hex-quad
  ///       hex-quad:
  ///         hex-digit hex-digit hex-digit hex-digit
  /// \endverbatim
  ///
  //<editor-fold defaultstate="collapsed" desc="clang::CharLiteralParser::CharLiteralParser">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   optimized = Converted.Optimization.COMPLEX,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/LiteralSupport.cpp", line = 1028,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/LiteralSupport.cpp", old_line = 1015,
   FQN="clang::CharLiteralParser::CharLiteralParser", NM="_ZN5clang17CharLiteralParserC1EPKcS2_NS_14SourceLocationERNS_12PreprocessorENS_3tok9TokenKindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/LiteralSupport.cpp -nm=_ZN5clang17CharLiteralParserC1EPKcS2_NS_14SourceLocationERNS_12PreprocessorENS_3tok9TokenKindE")
  //</editor-fold>
  public CharLiteralParser(/*const*/char$ptr/*char P*/ begin, /*const*/char$ptr/*char P*/ end, 
      SourceLocation Loc, final Preprocessor /*&*/ PP, 
      /*tok.TokenKind*/char kind) {
    // : UDSuffixBuf() 
    //START JInit
    this.UDSuffixBuf = new SmallString/*32*/(32);
    //END JInit
    begin = $tryClone(begin); // JAVA: added cloning of pointer to avoid it's spoiling
  
    // At this point we know that the character matches the regex "(L|u|U)?'.*'".
    HadError = false;

    Kind = kind;

    /*const*/char$ptr/*char P*/ TokBegin = $tryClone(begin);

    // Skip over wide character determinant.
    if (Kind != tok.TokenKind.char_constant) {
      begin.$preInc();
    }
    if (Kind == tok.TokenKind.utf8_char_constant) {
      begin.$preInc();
    }

    // Skip over the entry quote.
    assert (begin.$at(0) == $$SGL_QUOTE) : "Invalid token lexed";
    begin.$preInc();

    // Remove an optional ud-suffix.
    if (end.$at(-1) != $$SGL_QUOTE) {
      /*const*/int/*char P*/ UDSuffixEnd = end.$index();
      do {
        end.$preDec();
      } while (end.$at(-1) != $$SGL_QUOTE);
      // JAVA FIX: inf the case of incomplete token '\ begin == end (like in test_eof_char_c)
      if (begin.$greatereq(end)) {
        HadError = true;
        return;
      }
      
      // FIXME: Don't bother with this if !tok.hasUCN().
      expandUCNs(UDSuffixBuf, new StringRef(end, UDSuffixEnd - end.$index()));
      // JAVA: clean const added to end by StringRef
      Native.$cleanConst(end);
      UDSuffixOffset = end.$sub(TokBegin);
    }

    // JAVA FIX: in the case of "#if 'x\n" begin == end
    if (begin.$greatereq(end)) {
      HadError = true;
      return;
    }    
    // Trim the ending quote.
    end.$preDec();

    // FIXME: The "Value" is an uint64_t so we can handle char literals of
    // up to 64-bits.
    // FIXME: This extensively assumes that 'char' is 8-bits.
    assert (PP.getTargetInfo().getCharWidth() == 8) : "Assumes char is 8 bits";
    assert (PP.getTargetInfo().getIntWidth() <= 64 && (PP.getTargetInfo().getIntWidth() & 7) == 0) : "Assumes sizeof(int) on target is <= 64 and a multiple of char";
    assert (PP.getTargetInfo().getWCharWidth() <= 64) : "Assumes sizeof(wchar) on target is <= 64";

    SmallVectorUInt codepoint_buffer/*J*/= new SmallVectorUInt(4, 0);
    codepoint_buffer.resize(end.$sub(begin));
    uint$ptr/*uint32_t P*/ buffer_begin = $tryClone($AddrOf(codepoint_buffer.ref$front().deref$ptr()));
    uint$ptr/*uint32_t P*/ buffer_end = buffer_begin.$add(codepoint_buffer.size());

    // Unicode escapes representing characters that cannot be correctly
    // represented in a single code unit are disallowed in character literals
    // by this implementation.
    /*uint32_t*/int largest_character_for_kind;
    if (tok.TokenKind.wide_char_constant == Kind) {
      largest_character_for_kind
         = 0xFFFFFFFF/*U*/ >>> (32 - PP.getTargetInfo().getWCharWidth());
    } else if (tok.TokenKind.utf8_char_constant == Kind) {
      largest_character_for_kind = 0x7F;
    } else if (tok.TokenKind.utf16_char_constant == Kind) {
      largest_character_for_kind = 0xFFFF;
    } else if (tok.TokenKind.utf32_char_constant == Kind) {
      largest_character_for_kind = 0x10FFFF;
    } else {
      largest_character_for_kind = 0x7F/*U*/;
    }
    while (begin.$noteq(end)) {
      // Is this a span of non-escape characters?
      if (begin.$at(0) != $$BACK_SLASH) {
        /*const*/char$ptr/*char P*/ start = $tryClone(begin);
        do {
          begin.$preInc();
        } while (begin.$noteq(end) && begin.$star() != $$BACK_SLASH);

        /*const*/int/*char P*/ tmp_in_start = start.$index();
        uint$ptr/*uint32_t P*/ tmp_out_start = $tryClone(buffer_begin);
         ConversionResult res = ConvertUTF8toUTF32(((/*const*/type$ptr<char$ptr>/*UTF8 P P*/ )reinterpret_cast(/*const*/type$ptr.class, start.$addr())), 
            reinterpret_cast(/*const*/char$ptr/*UTF8 P*/ .class, begin), 
            buffer_begin.$addr(), buffer_end, ConversionFlags.strictConversion);
        if (res != ConversionResult.conversionOK) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            // If we see bad encoding for unprefixed character literals, warn and
            // simply copy the byte values, for compatibility with gcc and
            // older versions of clang.
            boolean NoErrorOnBadEncoding = isAscii();
            /*uint*/int Msg = diag.err_bad_character_encoding;
            if (NoErrorOnBadEncoding) {
              Msg = diag.warn_bad_character_encoding;
            }
            $c$.clean($c$.track(PP.Diag(/*NO_COPY*/Loc, Msg)));
            if (NoErrorOnBadEncoding) {
              $setIndex(start, tmp_in_start);
              buffer_begin = $tryClone(tmp_out_start);
              for (; start.$noteq(begin); start.$preInc() , buffer_begin.$preInc())  {
                buffer_begin.$set($uchar2uint((/*static_cast*/byte/*uint8_t*/)(start.$star())));
              }
            } else {
              HadError = true;
            }
          } finally {
            $c$.$destroy();
          }
        } else {
          for (; tmp_out_start.$less(buffer_begin); tmp_out_start.$preInc()) {
            if ($greater_uint(tmp_out_start.$star(), largest_character_for_kind)) {
              JavaCleaner $c$ = $createJavaCleaner();
              try {
                HadError = (true);
                $c$.clean($c$.track(PP.Diag(/*NO_COPY*/Loc, diag.err_character_too_large)));
              } finally {
                $c$.$destroy();
              }
            }
          }
        }

        continue;
      }
      // Is this a Universal Character Name escape?
      if (begin.$at(1) == $$u || begin.$at(1) == $$U) {
        ushort$ref UcnLen = create_ushort$ref(0);
        if (!ProcessUCNEscape(TokBegin, begin, end, buffer_begin.star$ref(), UcnLen, 
            new FullSourceLoc(/*NO_COPY*/Loc, PP.getSourceManager()), 
            $AddrOf(PP.getDiagnostics()), PP.getLangOpts(), true)) {
          HadError = true;
        } else if ($greater_uint(buffer_begin.$star(), largest_character_for_kind)) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            HadError =(true);
            $c$.clean($c$.track(PP.Diag(/*NO_COPY*/Loc, diag.err_character_too_large)));
          } finally {
            $c$.$destroy();
          }
        }

        buffer_begin.$preInc();
        continue;
      }
      /*uint*/int CharWidth = getCharWidth(Kind, PP.getTargetInfo());
      bool$ref _HadError = create_bool$ref(HadError);
      long/*uint64_t*/ result = $uint2long(ProcessCharEscape(TokBegin, begin, end, _HadError, 
          new FullSourceLoc(/*NO_COPY*/Loc, PP.getSourceManager()), 
          CharWidth, $AddrOf(PP.getDiagnostics()), PP.getLangOpts()));
      HadError = _HadError.$deref();
      buffer_begin.$set($long2uint(result));buffer_begin.$preInc();
    }

    /*uint*/int NumCharsSoFar = buffer_begin.$sub($AddrOf(codepoint_buffer.ref$front().deref$ptr()));
    if (NumCharsSoFar > 1) {
      if (isWide()) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($c$.track(PP.Diag(/*NO_COPY*/Loc, diag.warn_extraneous_char_constant)));
        } finally {
          $c$.$destroy();
        }
      } else if (isAscii() && NumCharsSoFar == 4) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($c$.track(PP.Diag(/*NO_COPY*/Loc, diag.ext_four_char_character_literal)));
        } finally {
          $c$.$destroy();
        }
      } else if (isAscii()) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($c$.track(PP.Diag(/*NO_COPY*/Loc, diag.ext_multichar_character_literal)));
        } finally {
          $c$.$destroy();
        }
      } else {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($c$.track(PP.Diag(/*NO_COPY*/Loc, diag.err_multichar_utf_character_literal)));
        } finally {
          $c$.$destroy();
        }
      }
      IsMultiChar = true;
    } else {
      IsMultiChar = false;
    }

    APInt LitVal/*J*/= new APInt(JD$UInt_ULong.INSTANCE, PP.getTargetInfo().getIntWidth(), 0);

    // Narrow character literals act as though their value is concatenated
    // in this implementation, but warn on overflow.
    boolean multi_char_too_long = false;
    if (isAscii() && isMultiChar()) {
      LitVal.$assign(0);
      for (/*size_t*/int i = 0; i < NumCharsSoFar; ++i) {
        // check for enough leading zeros to shift into
        multi_char_too_long |= (LitVal.countLeadingZeros() < 8);
        LitVal.$lshiftassign(8);
        LitVal.$assignMove(LitVal.$add($uint2ulong((codepoint_buffer.$at(i) & 0xFF))));
      }
    } else if (NumCharsSoFar > 0) {
      // otherwise just take the last character
      LitVal.$assign($uint2ulong(buffer_begin.$at(-1)));
    }
    if (!HadError && multi_char_too_long) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($c$.track(PP.Diag(/*NO_COPY*/Loc, diag.warn_char_constant_too_large)));
      } finally {
        $c$.$destroy();
      }
    }

    // Transfer the value from APInt to uint64_t
    Value = LitVal.getZExtValue();

    // If this is a single narrow character, sign extend it (e.g. '\xFF' is "-1")
    // if 'char' is signed for this target (C99 6.4.4.4p10).  Note that multiple
    // character constants are not sign extended in the this implementation:
    // '\xFF\xFF' = 65536 and '\x0\xFF' = 255, which matches GCC.
    if (isAscii() && NumCharsSoFar == 1 && ((Value & 128) != 0)
       && PP.getLangOpts().CharIsSigned) {
      Value = (/*schar*/byte)Value;
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CharLiteralParser::hadError">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/LiteralSupport.h", line = 176,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/LiteralSupport.h", old_line = 166,
   FQN="clang::CharLiteralParser::hadError", NM="_ZNK5clang17CharLiteralParser8hadErrorEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/LiteralSupport.cpp -nm=_ZNK5clang17CharLiteralParser8hadErrorEv")
  //</editor-fold>
  public boolean hadError() /*const*/ {
    return HadError;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CharLiteralParser::isAscii">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/LiteralSupport.h", line = 177,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/LiteralSupport.h", old_line = 167,
   FQN="clang::CharLiteralParser::isAscii", NM="_ZNK5clang17CharLiteralParser7isAsciiEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/LiteralSupport.cpp -nm=_ZNK5clang17CharLiteralParser7isAsciiEv")
  //</editor-fold>
  public boolean isAscii() /*const*/ {
    return Kind == tok.TokenKind.char_constant;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CharLiteralParser::isWide">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/LiteralSupport.h", line = 178,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/LiteralSupport.h", old_line = 168,
   FQN="clang::CharLiteralParser::isWide", NM="_ZNK5clang17CharLiteralParser6isWideEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/LiteralSupport.cpp -nm=_ZNK5clang17CharLiteralParser6isWideEv")
  //</editor-fold>
  public boolean isWide() /*const*/ {
    return Kind == tok.TokenKind.wide_char_constant;
  }
  
  //<editor-fold defaultstate="collapsed" desc="clang::CharLiteralParser::isUTF8">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/LiteralSupport.h", line = 179,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/LiteralSupport.h", old_line = 169,
   FQN="clang::CharLiteralParser::isUTF8", NM="_ZNK5clang17CharLiteralParser6isUTF8Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/LiteralSupport.cpp -nm=_ZNK5clang17CharLiteralParser6isUTF8Ev")
  //</editor-fold>
  public boolean isUTF8() /*const*/ {
    return Kind == tok.TokenKind.utf8_char_constant;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CharLiteralParser::isUTF16">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/LiteralSupport.h", line = 180,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/LiteralSupport.h", old_line = 170,
   FQN="clang::CharLiteralParser::isUTF16", NM="_ZNK5clang17CharLiteralParser7isUTF16Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/LiteralSupport.cpp -nm=_ZNK5clang17CharLiteralParser7isUTF16Ev")
  //</editor-fold>
  public boolean isUTF16() /*const*/ {
    return Kind == tok.TokenKind.utf16_char_constant;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CharLiteralParser::isUTF32">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/LiteralSupport.h", line = 181,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/LiteralSupport.h", old_line = 171,
   FQN="clang::CharLiteralParser::isUTF32", NM="_ZNK5clang17CharLiteralParser7isUTF32Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/LiteralSupport.cpp -nm=_ZNK5clang17CharLiteralParser7isUTF32Ev")
  //</editor-fold>
  public boolean isUTF32() /*const*/ {
    return Kind == tok.TokenKind.utf32_char_constant;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CharLiteralParser::isMultiChar">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/LiteralSupport.h", line = 182,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/LiteralSupport.h", old_line = 172,
   FQN="clang::CharLiteralParser::isMultiChar", NM="_ZNK5clang17CharLiteralParser11isMultiCharEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/LiteralSupport.cpp -nm=_ZNK5clang17CharLiteralParser11isMultiCharEv")
  //</editor-fold>
  public boolean isMultiChar() /*const*/ {
    return IsMultiChar;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CharLiteralParser::getValue">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/LiteralSupport.h", line = 183,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/LiteralSupport.h", old_line = 173,
   FQN="clang::CharLiteralParser::getValue", NM="_ZNK5clang17CharLiteralParser8getValueEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/LiteralSupport.cpp -nm=_ZNK5clang17CharLiteralParser8getValueEv")
  //</editor-fold>
  public long/*uint64_t*/ getValue() /*const*/ {
    return Value;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CharLiteralParser::getUDSuffix">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/LiteralSupport.h", line = 184,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/LiteralSupport.h", old_line = 174,
   FQN="clang::CharLiteralParser::getUDSuffix", NM="_ZNK5clang17CharLiteralParser11getUDSuffixEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/LiteralSupport.cpp -nm=_ZNK5clang17CharLiteralParser11getUDSuffixEv")
  //</editor-fold>
  public StringRef getUDSuffix() /*const*/ {
    return UDSuffixBuf.$StringRef();
  }

  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC, optimized = Converted.Optimization.VALUE_TYPE)
  public SmallString $getUDSuffix() /*const*/ {
    return UDSuffixBuf;
  }
  
  //<editor-fold defaultstate="collapsed" desc="clang::CharLiteralParser::getUDSuffixOffset">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/LiteralSupport.h", line = 185,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/LiteralSupport.h", old_line = 175,
   FQN="clang::CharLiteralParser::getUDSuffixOffset", NM="_ZNK5clang17CharLiteralParser17getUDSuffixOffsetEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/LiteralSupport.cpp -nm=_ZNK5clang17CharLiteralParser17getUDSuffixOffsetEv")
  //</editor-fold>
  public /*uint*/int getUDSuffixOffset() /*const*/ {
    assert (!UDSuffixBuf.empty()) : "no ud-suffix";
    return UDSuffixOffset;
  }


  //<editor-fold defaultstate="collapsed" desc="clang::CharLiteralParser::~CharLiteralParser">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/LiteralSupport.h", line = 164,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/LiteralSupport.h", old_line = 154,
   FQN="clang::CharLiteralParser::~CharLiteralParser", NM="_ZN5clang17CharLiteralParserD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp -nm=_ZN5clang17CharLiteralParserD0Ev")
  //</editor-fold>
  public /*inline*/ void $destroy() {
    if (this.UDSuffixBuf != null) {
      this.UDSuffixBuf.$destroy();
    }
  }
  

  @Override public String toString() {
    return "" + "Value=" + Value // NOI18N
              + ", Kind=" + tok.$kind2String(Kind) // NOI18N
              + ", IsMultiChar=" + IsMultiChar // NOI18N
              + ", HadError=" + HadError // NOI18N
              + ", UDSuffixBuf=" + UDSuffixBuf // NOI18N
              + ", UDSuffixOffset=" + UDSuffixOffset; // NOI18N
  }  
}
