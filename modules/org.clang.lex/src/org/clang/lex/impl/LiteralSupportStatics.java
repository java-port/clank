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

import static org.clank.support.Native.$AddrOf;
import org.clang.basic.target.TargetInfo;
import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import static org.clank.support.Casts.*;
import static org.clank.java.std.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.clang.basic.*;
import org.clang.lex.*;
import static org.clang.basic.BasicClangGlobals.*;
import static org.llvm.support.ConvertUTFGlobals.*;


//<editor-fold defaultstate="collapsed" desc="static type LiteralSupportStatics">
@Converted(kind = Converted.Kind.AUTO,
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/LiteralSupport.cpp -nm=_ZL10resyncUTF8PKcS0_;_ZL12getCharWidthN5clang3tok9TokenKindERKNS_10TargetInfoE;_ZL15EncodeUCNEscapePKcRS0_S0_RPcRbN5clang13FullSourceLocEjPNS5_17DiagnosticsEngineERKNS5_11LangOptionsE;_ZL15appendCodePointjRN4llvm15SmallVectorImplIcEE;_ZL16MeasureUCNEscapePKcRS0_S0_jRKN5clang11LangOptionsERb;_ZL16ProcessUCNEscapePKcRS0_S0_RjRtN5clang13FullSourceLocEPNS4_17DiagnosticsEngineERKNS4_11LangOptionsEb;_ZL17ProcessCharEscapePKcRS0_S0_RbN5clang13FullSourceLocEjPNS3_17DiagnosticsEngineERKNS3_11LangOptionsE;_ZL19MakeCharSourceRangeRKN5clang11LangOptionsENS_13FullSourceLocEPKcS5_S5_;_ZL20alwaysFitsInto64Bitsjj;_ZL4DiagPN5clang17DiagnosticsEngineERKNS_11LangOptionsENS_13FullSourceLocEPKcS7_S7_j; -static-type=LiteralSupportStatics -package=org.clang.lex.impl")
//</editor-fold>
public final class LiteralSupportStatics {

//<editor-fold defaultstate="collapsed" desc="getCharWidth">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/LiteralSupport.cpp", line = 26,
 FQN="getCharWidth", NM="_ZL12getCharWidthN5clang3tok9TokenKindERKNS_10TargetInfoE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/LiteralSupport.cpp -nm=_ZL12getCharWidthN5clang3tok9TokenKindERKNS_10TargetInfoE")
//</editor-fold>
public static /*uint*/int getCharWidth(/*tok.TokenKind*/char kind, final /*const*/ TargetInfo /*&*/ Target) {
  switch (kind) {
   default:
    throw new llvm_unreachable("Unknown token type!");
   case tok.TokenKind.char_constant:
   case tok.TokenKind.string_literal:
   case tok.TokenKind.utf8_char_constant:
   case tok.TokenKind.utf8_string_literal:
    return Target.getCharWidth();
   case tok.TokenKind.wide_char_constant:
   case tok.TokenKind.wide_string_literal:
    return Target.getWCharWidth();
   case tok.TokenKind.utf16_char_constant:
   case tok.TokenKind.utf16_string_literal:
    return Target.getChar16Width();
   case tok.TokenKind.utf32_char_constant:
   case tok.TokenKind.utf32_string_literal:
    return Target.getChar32Width();
  }
}

//<editor-fold defaultstate="collapsed" desc="MakeCharSourceRange">
@Converted(kind = Converted.Kind.MANUAL,
 optimized = Converted.Optimization.VALUE_TYPE,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/LiteralSupport.cpp", line = 46,
 FQN="MakeCharSourceRange", NM="_ZL19MakeCharSourceRangeRKN5clang11LangOptionsENS_13FullSourceLocEPKcS5_S5_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/LiteralSupport.cpp -nm=_ZL19MakeCharSourceRangeRKN5clang11LangOptionsENS_13FullSourceLocEPKcS5_S5_")
//</editor-fold>
public static CharSourceRange MakeCharSourceRange(final /*const*/ LangOptions /*&*/ Features, 
        FullSourceLoc TokLoc, 
        /*const*/char$ptr/*char P*/ TokBegin, 
        /*const*/char$ptr/*char P*/ TokRangeBegin, 
        /*const*/char$ptr/*char P*/ TokRangeEnd) {
  /*SourceLocation*/int Begin = Lexer.AdvanceToTokenCharacter(/*NO_COPY*/TokLoc.getRawEncoding(), TokRangeBegin.$sub(TokBegin), 
          TokLoc.getManager(), Features);
  /*SourceLocation*/int End = Lexer.AdvanceToTokenCharacter(/*NO_COPY*/Begin, TokRangeEnd.$sub(TokRangeBegin), 
          TokLoc.getManager(), Features);
  return CharSourceRange.getCharRange(/*NO_COPY*/Begin, /*NO_COPY*/End);
}


/// \brief Produce a diagnostic highlighting some portion of a literal.
///
/// Emits the diagnostic \p DiagID, highlighting the range of characters from
/// \p TokRangeBegin (inclusive) to \p TokRangeEnd (exclusive), which must be
/// a substring of a spelling buffer for the token beginning at \p TokBegin.
//<editor-fold defaultstate="collapsed" desc="Diag">
@Converted(kind = Converted.Kind.MANUAL,
 optimized = Converted.Optimization.VALUE_TYPE,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/LiteralSupport.cpp", line = 65,
 FQN="Diag", NM="_ZL4DiagPN5clang17DiagnosticsEngineERKNS_11LangOptionsENS_13FullSourceLocEPKcS7_S7_j",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/LiteralSupport.cpp -nm=_ZL4DiagPN5clang17DiagnosticsEngineERKNS_11LangOptionsENS_13FullSourceLocEPKcS7_S7_j")
//</editor-fold>
public static DiagnosticBuilder Diag(DiagnosticsEngine /*P*/ Diags, 
    final /*const*/ LangOptions /*&*/ Features, FullSourceLoc TokLoc, 
    /*const*/char$ptr/*char P*/ TokBegin, /*const*/char$ptr/*char P*/ TokRangeBegin, 
    /*const*/char$ptr/*char P*/ TokRangeEnd, /*uint*/int DiagID) {
  JavaCleaner $c$ = $createJavaCleaner();
  try {  
    /*SourceLocation*/int Begin = Lexer.AdvanceToTokenCharacter(/*NO_COPY*/TokLoc.getRawEncoding(), TokRangeBegin.$sub(TokBegin), 
          TokLoc.getManager(), Features);
    return $c$.clean(new DiagnosticBuilder($out_DiagnosticBuilder$C_CharSourceRange$C($c$.track(Diags.Report(/*NO_COPY*/Begin, DiagID)), 
            MakeCharSourceRange(Features, /*NO_COPY*/TokLoc, TokBegin, TokRangeBegin, TokRangeEnd))));
  } finally {
    $c$.$destroy();
  }
}


/// ProcessCharEscape - Parse a standard C escape sequence, which can occur in
/// either a character or a string literal.
//<editor-fold defaultstate="collapsed" desc="ProcessCharEscape">
@Converted(kind = Converted.Kind.MANUAL,
 optimized = Converted.Optimization.VALUE_TYPE,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/LiteralSupport.cpp", line = 78,
 FQN="ProcessCharEscape", NM="_ZL17ProcessCharEscapePKcRS0_S0_RbN5clang13FullSourceLocEjPNS3_17DiagnosticsEngineERKNS3_11LangOptionsE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/LiteralSupport.cpp -nm=_ZL17ProcessCharEscapePKcRS0_S0_RbN5clang13FullSourceLocEjPNS3_17DiagnosticsEngineERKNS3_11LangOptionsE")
//</editor-fold>
public static /*uint*/int ProcessCharEscape(/*const*/char$ptr/*char P*/ ThisTokBegin, 
                 final char$ptr/*const char P &*/ ThisTokBuf, 
                 /*const*/char$ptr/*char P*/ ThisTokEnd, final bool$ref/*bool &*/ HadError, 
                 FullSourceLoc Loc, /*uint*/int CharWidth, 
                 DiagnosticsEngine /*P*/ Diags, 
                 final /*const*/ LangOptions /*&*/ Features) {
  /*const*/char$ptr/*char P*/ EscapeBegin = $tryClone(ThisTokBuf);
  
  // Skip the '\' char.
  ThisTokBuf.$preInc();
  
  // We know that this character can't be off the end of the buffer, because
  // that would have been \", which would not have been the end of string.
  /*uint*/int ResultChar = $char2uint(ThisTokBuf.$star());ThisTokBuf.$preInc();
  switch (ResultChar) {
   case '\\':
   case '\'':
   case '"':
   case '?':
    // These map to themselves.
    break;
   case 'a':
    // TODO: K&R: the meaning of '\\a' is different in traditional C
    ResultChar = 7;
    break;
   case 'b':
    ResultChar = 8;
    break;
   case 'e':
    if ((Diags != null)) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_DiagnosticBuilder$C_char$ptr$C($c$.track(Diag(Diags, Features, /*NO_COPY*/Loc, ThisTokBegin, EscapeBegin, ThisTokBuf, 
                diag.ext_nonstandard_escape)), /*KEEP_STR*/$e));
      } finally {
        $c$.$destroy();
      }
    }
    ResultChar = 27;
    break;
   case 'E':
    if ((Diags != null)) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_DiagnosticBuilder$C_char$ptr$C($c$.track(Diag(Diags, Features, /*NO_COPY*/Loc, ThisTokBegin, EscapeBegin, ThisTokBuf, 
                diag.ext_nonstandard_escape)), /*KEEP_STR*/$E));
      } finally {
        $c$.$destroy();
      }
    }
    ResultChar = 27;
    break;
   case 'f':
    ResultChar = 12;
    break;
   case 'n':
    ResultChar = 10;
    break;
   case 'r':
    ResultChar = 13;
    break;
   case 't':
    ResultChar = 9;
    break;
   case 'v':
    ResultChar = 11;
    break;
   case 'x':
    { // Hex escape.
      ResultChar = 0;
      if (ThisTokBuf.$eq(ThisTokEnd) || !isHexDigit(ThisTokBuf.$star())) {
        if ((Diags != null)) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            $c$.clean($out_DiagnosticBuilder$C_char$ptr$C($c$.track(Diag(Diags, Features, /*NO_COPY*/Loc, ThisTokBegin, EscapeBegin, ThisTokBuf, 
                    diag.err_hex_escape_no_digits)), /*KEEP_STR*/$x));
          } finally {
            $c$.$destroy();
          }
        }
        HadError.$set(true);
        break;
      }
      
      // Hex escapes are a maximal series of hex digits.
      boolean Overflow = false;
      for (; ThisTokBuf.$noteq(ThisTokEnd); ThisTokBuf.$preInc()) {
        int CharVal = llvm.hexDigitValue(ThisTokBuf.$at(0));
        if (CharVal == -1) {
          break;
        }
        // About to shift out a digit?
        if (((ResultChar & 0xF0000000/*U*/) != 0)) {
          Overflow = true;
        }
        ResultChar <<= 4;
        ResultChar |= CharVal;
      }
      
      // See if any bits will be truncated when evaluated as a character.
      if (CharWidth != 32 && (ResultChar >>> CharWidth) != 0) {
        Overflow = true;
        ResultChar &= ~0/*U*/ >>> (32 - CharWidth);
      }
      
      // Check for overflow.
      if (Overflow && (Diags != null)) { // Too many digits to fit in
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_DiagnosticBuilder$C_int($c$.track(Diag(Diags, Features, /*NO_COPY*/Loc, ThisTokBegin, EscapeBegin, ThisTokBuf, 
                  diag.err_escape_too_large)), 0));
        } finally {
          $c$.$destroy();
        }
      }
      break;
    }
   case '0':
   case '1':
   case '2':
   case '3':
   case '4':
   case '5':
   case '6':
   case '7':
    {
      // Octal escapes.
      ThisTokBuf.$preDec();
      ResultChar = 0;
      
      // Octal escapes are a series of octal digits with maximum length 3.
      // "\0123" is a two digit sequence equal to "\012" "3".
      /*uint*/int NumDigits = 0;
      do {
        ResultChar <<= 3;
        ResultChar |= $char2uint(ThisTokBuf.$star()) - $$0;ThisTokBuf.$preInc();
        ++NumDigits;
      } while (ThisTokBuf.$noteq(ThisTokEnd) && NumDigits < 3 
              && ThisTokBuf.$at(0) >= $$0 && ThisTokBuf.$at(0) <= $$7);
      
      // Check for overflow.  Reject '\777', but not L'\777'.
      if (CharWidth != 32 && (ResultChar >>> CharWidth) != 0) {
        if ((Diags != null)) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            $c$.clean($out_DiagnosticBuilder$C_int($c$.track(Diag(Diags, Features, /*NO_COPY*/Loc, ThisTokBegin, EscapeBegin, ThisTokBuf, 
                    diag.err_escape_too_large)), 1));
          } finally {
            $c$.$destroy();
          }
        }
        ResultChar &= ~0/*U*/ >>> (32 - CharWidth);
      }
      break;
    }
   case '(':
   case '{':
   case '[':
   case '%':
    // GCC accepts these as extensions.  We warn about them as such though.
    if ((Diags != null)) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_DiagnosticBuilder$C_StringRef($c$.track(Diag(Diags, Features, /*NO_COPY*/Loc, ThisTokBegin, EscapeBegin, ThisTokBuf, 
                diag.ext_nonstandard_escape)), 
            new StringRef(new std.string(1, $uint2char(ResultChar)))));
      } finally {
        $c$.$destroy();
      }
    }
    break;
   default:
    if (!(Diags != null)) {
      break;
    }
    if (isPrintable($uint2uchar(ResultChar))) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_DiagnosticBuilder$C_StringRef($c$.track(Diag(Diags, Features, /*NO_COPY*/Loc, ThisTokBegin, EscapeBegin, ThisTokBuf, 
                diag.ext_unknown_escape)), 
            new StringRef(new std.string(1, $uint2char(ResultChar)))));
      } finally {
        $c$.$destroy();
      }
    } else {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_DiagnosticBuilder$C_StringRef($c$.track(Diag(Diags, Features, /*NO_COPY*/Loc, ThisTokBegin, EscapeBegin, ThisTokBuf, 
                diag.ext_unknown_escape)), 
            new StringRef($add_T$C$P_string(/*KEEP_STR*/"x", llvm.utohexstr($uint2ulong(ResultChar))))));
      } finally {
        $c$.$destroy();
      }
    }
    break;
  }
  
  return ResultChar;
}

//<editor-fold defaultstate="collapsed" desc="appendCodePoint">
@Converted(kind = Converted.Kind.MANUAL,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/LiteralSupport.cpp", line = 217,
 FQN="appendCodePoint", NM="_ZL15appendCodePointjRN4llvm15SmallVectorImplIcEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/LiteralSupport.cpp -nm=_ZL15appendCodePointjRN4llvm15SmallVectorImplIcEE")
//</editor-fold>
public static void appendCodePoint(/*uint*/int Codepoint, 
               final SmallString/*&*/ Str) {
  /*char*/byte ResultBuf[/*4*/] = new$char(4);
  type$ref<char$ptr>/*char P*/ ResultPtr = create_type$ref(create_char$ptr(ResultBuf));
  boolean Res = llvm.ConvertCodePointToUTF8(Codepoint, ResultPtr);
  ///*J:(void)*/Res;
  assert (Res) : "Unexpected conversion failure";
  Str.append(ResultBuf, 0, ResultPtr.$deref().$index());//+1);
}


/// ProcessUCNEscape - Read the Universal Character Name, check constraints and
/// return the UTF32.
//<editor-fold defaultstate="collapsed" desc="ProcessUCNEscape">
@Converted(kind = Converted.Kind.MANUAL,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/LiteralSupport.cpp", line = 261,
 FQN="ProcessUCNEscape", NM="_ZL16ProcessUCNEscapePKcRS0_S0_RjRtN5clang13FullSourceLocEPNS4_17DiagnosticsEngineERKNS4_11LangOptionsEb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/LiteralSupport.cpp -nm=_ZL16ProcessUCNEscapePKcRS0_S0_RjRtN5clang13FullSourceLocEPNS4_17DiagnosticsEngineERKNS4_11LangOptionsEb")
//</editor-fold>
public static boolean ProcessUCNEscape(/*const*/char$ptr/*char P*/ ThisTokBegin, final char$ptr/*const char P &*/ ThisTokBuf, 
                /*const*/char$ptr/*char P*/ ThisTokEnd, 
                final /*uint32_t &*/uint$ref UcnVal, final ushort$ref/*ushort &*/ UcnLen, 
                FullSourceLoc Loc, DiagnosticsEngine /*P*/ Diags, 
                final /*const*/ LangOptions /*&*/ Features) {
  return ProcessUCNEscape(ThisTokBegin, ThisTokBuf, 
          ThisTokEnd, 
          UcnVal, UcnLen, 
          Loc, Diags, 
          Features, 
          false);
}
public static boolean ProcessUCNEscape(/*const*/char$ptr/*char P*/ ThisTokBegin, final char$ptr/*const char P &*/ ThisTokBuf, 
                /*const*/char$ptr/*char P*/ ThisTokEnd, 
                final /*uint32_t &*/uint$ref UcnVal, final ushort$ref/*ushort &*/ UcnLen, 
                FullSourceLoc Loc, DiagnosticsEngine /*P*/ Diags, 
                final /*const*/ LangOptions /*&*/ Features, 
                boolean in_char_string_literal/*= false*/) {
  /*const*/char$ptr/*char P*/ UcnBegin = $tryClone(ThisTokBuf);
  
  // Skip the '\\u' char's.
  ThisTokBuf.$inc(2);
  if ($eq_ptr(ThisTokBuf, ThisTokEnd) || !isHexDigit(ThisTokBuf.$star())) {
    if ((Diags != null)) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_DiagnosticBuilder$C_StringRef($c$.track(Diag(Diags, Features, /*NO_COPY*/Loc, ThisTokBegin, UcnBegin, ThisTokBuf, 
                diag.err_hex_escape_no_digits)), new StringRef(ThisTokBuf.$add(-1), 1)));
      } finally {
        $c$.$destroy();
      }
    }
    return false;
  }
  UcnLen.$set((char)(ThisTokBuf.$at(-1) == $$u ? 4 : 8));
  /*ushort*/char UcnLenSave = UcnLen.$deref();
  for (; ThisTokBuf.$noteq(ThisTokEnd) && (UcnLenSave != 0); ThisTokBuf.$preInc() , UcnLenSave--) {
    int CharVal = llvm.hexDigitValue(ThisTokBuf.$at(0));
    if (CharVal == -1) {
      break;
    }
    /*uint32_t*/int _UcnVal = UcnVal.$deref();
    _UcnVal <<= 4;
    _UcnVal |= CharVal;
    UcnVal.$set(_UcnVal);
  }
  // If we didn't consume the proper number of digits, there is a problem.
  if ((UcnLenSave != 0)) {
    if ((Diags != null)) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($c$.track(Diag(Diags, Features, /*NO_COPY*/Loc, ThisTokBegin, UcnBegin, ThisTokBuf, 
            diag.err_ucn_escape_incomplete)));
      } finally {
        $c$.$destroy();
      }
    }
    return false;
  }
  
  // Check UCN constraints (C99 6.4.3p2) [C++11 lex.charset p2]
  if (($lesseq_uint(0xD800, UcnVal.$deref()) && $lesseq_uint(UcnVal.$deref(), 0xDFFF)) // surrogate codepoints
     || $greater_uint(UcnVal.$deref(), 0x10FFFF)) { // maximum legal UTF32 value
    if ((Diags != null)) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($c$.track(Diag(Diags, Features, /*NO_COPY*/Loc, ThisTokBegin, UcnBegin, ThisTokBuf, 
            diag.err_ucn_escape_invalid)));
      } finally {
        $c$.$destroy();
      }
    }
    return false;
  }
  
  // C++11 allows UCNs that refer to control characters and basic source
  // characters inside character and string literals
  if ($less_uint(UcnVal.$deref(), 0xa0)
     && (UcnVal.$deref() != 0x24 && UcnVal.$deref() != 0x40 && UcnVal.$deref() != 0x60)) { // $, @, `
    boolean IsError = (!Features.CPlusPlus11 || !in_char_string_literal);
    if ((Diags != null)) {
      /*char*/byte BasicSCSChar = (byte) UcnVal.$deref();
      if ($greatereq_uint(UcnVal.$deref(), 0x20) && $less_uint(UcnVal.$deref(), 0x7f)) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_DiagnosticBuilder$C_StringRef($c$.track(Diag(Diags, Features, /*NO_COPY*/Loc, ThisTokBegin, UcnBegin, ThisTokBuf, 
                  IsError ? diag.err_ucn_escape_basic_scs : diag.warn_cxx98_compat_literal_ucn_escape_basic_scs)), 
              new StringRef($AddrOf(new$char$elem(BasicSCSChar)), 1)));
        } finally {
          $c$.$destroy();
        }
      } else {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($c$.track(Diag(Diags, Features, /*NO_COPY*/Loc, ThisTokBegin, UcnBegin, ThisTokBuf, 
              IsError ? diag.err_ucn_control_character : diag.warn_cxx98_compat_literal_ucn_control_character)));
        } finally {
          $c$.$destroy();
        }
      }
    }
    if (IsError) {
      return false;
    }
  }
  if (!Features.CPlusPlus && !Features.C99 && (Diags != null)) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($c$.track(Diag(Diags, Features, /*NO_COPY*/Loc, ThisTokBegin, UcnBegin, ThisTokBuf, 
          diag.warn_ucn_not_valid_in_c89_literal)));
    } finally {
      $c$.$destroy();
    }
  }
  
  return true;
}


/// MeasureUCNEscape - Determine the number of bytes within the resulting string
/// which this UCN will occupy.
//<editor-fold defaultstate="collapsed" desc="MeasureUCNEscape">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/LiteralSupport.cpp", line = 333,
 FQN="MeasureUCNEscape", NM="_ZL16MeasureUCNEscapePKcRS0_S0_jRKN5clang11LangOptionsERb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/LiteralSupport.cpp -nm=_ZL16MeasureUCNEscapePKcRS0_S0_jRKN5clang11LangOptionsERb")
//</editor-fold>
public static int MeasureUCNEscape(/*const*/char$ptr/*char P*/ ThisTokBegin, final char$ptr/*const char P &*/ ThisTokBuf, 
                /*const*/char$ptr/*char P*/ ThisTokEnd, /*uint*/int CharByteWidth, 
                final /*const*/ LangOptions /*&*/ Features, final bool$ref/*bool &*/ HadError) {
  // UTF-32: 4 bytes per escape.
  if (CharByteWidth == 4) {
    return 4;
  }
  
  uint$ref UcnVal = create_uint$ref(0);
  ushort$ref UcnLen = create_ushort$ref((0));
  FullSourceLoc Loc/*J*/= new FullSourceLoc();
  if (!ProcessUCNEscape(ThisTokBegin, ThisTokBuf, ThisTokEnd, UcnVal, 
      UcnLen, /*NO_COPY*/Loc, (DiagnosticsEngine /*P*/ )null, Features, true)) {
    HadError.$set(true);
    return 0;
  }
  
  // UTF-16: 2 bytes for BMP, 4 bytes otherwise.
  if (CharByteWidth == 2) {
    return $lesseq_uint(UcnVal.$deref(), 0xFFFF) ? 2 : 4;
  }
  
  // UTF-8.
  if ($less_uint(UcnVal.$deref(), 0x80)) {
    return 1;
  }
  if ($less_uint(UcnVal.$deref(), 0x800)) {
    return 2;
  }
  if ($less_uint(UcnVal.$deref(), 0x10000)) {
    return 3;
  }
  return 4;
}

private static final /*const*//*uint*/int byteMask = 0xBF;
private static final /*const*//*uint*/int byteMark = 0x80;

/// EncodeUCNEscape - Read the Universal Character Name, check constraints and
/// convert the UTF32 to UTF8 or UTF16. This is a subroutine of
/// StringLiteralParser. When we decide to implement UCN's for identifiers,
/// we will likely rework our support for UCN's.
//<editor-fold defaultstate="collapsed" desc="EncodeUCNEscape">
@Converted(kind = Converted.Kind.MANUAL,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/LiteralSupport.cpp", line = 368,
 FQN="EncodeUCNEscape", NM="_ZL15EncodeUCNEscapePKcRS0_S0_RPcRbN5clang13FullSourceLocEjPNS5_17DiagnosticsEngineERKNS5_11LangOptionsE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/LiteralSupport.cpp -nm=_ZL15EncodeUCNEscapePKcRS0_S0_RPcRbN5clang13FullSourceLocEjPNS5_17DiagnosticsEngineERKNS5_11LangOptionsE")
//</editor-fold>
public static void EncodeUCNEscape(/*const*/char$ptr/*char P*/ ThisTokBegin, final char$ptr/*const char P &*/ ThisTokBuf, 
               /*const*/char$ptr/*char P*/ ThisTokEnd, 
               final type$ref<char$ptr>/*char P&*/ ResultBuf, final bool$ref/*bool &*/ HadError, 
               FullSourceLoc Loc, /*uint*/int CharByteWidth, 
               DiagnosticsEngine /*P*/ Diags, 
               final /*const*/ LangOptions /*&*/ Features) {
  /*typedef uint32_t UTF32*/;
  uint$ref UcnVal = create_uint$ref(0);
  ushort$ref UcnLen = create_ushort$ref((0));
  if (!ProcessUCNEscape(ThisTokBegin, ThisTokBuf, ThisTokEnd, UcnVal, UcnLen, 
      /*NO_COPY*/Loc, Diags, Features, true)) {
    HadError.$set(true);
    return;
  }
  assert ((CharByteWidth == 1 || CharByteWidth == 2 || CharByteWidth == 4)) : "only character widths of 1, 2, or 4 bytes supported";
  
  ///*J:(void)*/UcnLen;
  assert (($ushort2int(UcnLen.$deref()) == 4 || $ushort2int(UcnLen.$deref()) == 8)) : "only ucn length of 4 or 8 supported";
  if (CharByteWidth == 4) {
    // FIXME: Make the type of the result buffer correct instead of
    // using reinterpret_cast.
    uint$ptr/*UTF32 P*/ ResultPtr = reinterpret_cast(uint$ptr/*UTF32 P*/ .class, ResultBuf.$deref());
    ResultPtr.$set(UcnVal.$deref());
    ResultBuf.$deref().$inc(4);
    return;
  }
  if (CharByteWidth == 2) {
    // FIXME: Make the type of the result buffer correct instead of
    // using reinterpret_cast.
    ushort$ptr/*UTF16 P*/ ResultPtr = reinterpret_cast(ushort$ptr/*UTF16 P*/ .class, ResultBuf.$deref());
    if ($lesseq_uint(UcnVal.$deref(), (int/*UTF32*/)0xFFFF)) {
      ResultPtr.$set((char)UcnVal.$deref());
      ResultBuf.$deref().$inc(2);
      return;
    }
    
    // Convert to UTF16.
    /*uint*/int _UcnVal = UcnVal.$deref();
    _UcnVal -= 0x10000;
    ResultPtr.$set((char)(0xD800 + (_UcnVal >>> 10)));
    (ResultPtr.$add(1)).$set((char)(0xDC00 + (_UcnVal & 0x3FF)));
    ResultBuf.$deref().$inc(4);
    return;
  }
  assert (CharByteWidth == 1) : "UTF-8 encoding is only for 1 byte characters";
  
  // Now that we've parsed/checked the UCN, we convert from UTF32->UTF8.
  // The conversion below was inspired by:
  //   http://www.unicode.org/Public/PROGRAMS/CVTUTF/ConvertUTF.c
  // First, we determine how many bytes the result will require.
  /*typedef uint8_t UTF8*/;
  
  /*ushort*/char bytesToWrite = 0;
  if ($less_uint(UcnVal.$deref(), (int/*UTF32*/)0x80)) {
    bytesToWrite = 1;
  } else if ($less_uint(UcnVal.$deref(), (int/*UTF32*/)0x800)) {
    bytesToWrite = 2;
  } else if ($less_uint(UcnVal.$deref(), (int/*UTF32*/)0x10000)) {
    bytesToWrite = 3;
  } else {
    bytesToWrite = 4;
  }
  
  // Once the bits are split out into bytes of UTF8, this is a mask OR-ed
  // into the first byte, depending on how many bytes follow.
  final/*static*/ /*const*/byte/*UTF8*/ firstByteMark[/*5*/] = EncodeUCNEscape$$.firstByteMark;
  // Finally, we write the bytes into ResultBuf.
  ResultBuf.$deref().$inc(bytesToWrite);
  /*uint32_t*/int _UcnVal = UcnVal.$deref(); // JAVA PERF
  switch (bytesToWrite) { // note: everything falls through.
   case 4:
    ResultBuf.$deref().$preDec().$set((byte/*UTF8*/)((_UcnVal | byteMark) & byteMask));
    _UcnVal >>>= 6;
   case 3:
    ResultBuf.$deref().$preDec().$set((byte/*UTF8*/)((_UcnVal | byteMark) & byteMask));
    _UcnVal >>>= 6;
   case 2:
    ResultBuf.$deref().$preDec().$set((byte/*UTF8*/)((_UcnVal | byteMark) & byteMask));
    _UcnVal >>>= 6;
   case 1:
    ResultBuf.$deref().$preDec().$set((byte/*UTF8*/)(_UcnVal | $uchar2uint(firstByteMark[bytesToWrite])));
  }
  UcnVal.$set(_UcnVal);
  // Update the buffer.
  ResultBuf.$deref().$inc(bytesToWrite);
}
private static final class EncodeUCNEscape$$ {
  static final/*static*/ /*const*/byte/*UTF8*/ firstByteMark[/*5*/] = new /*const*/byte/*UTF8*/ [/*5*/] {
    (byte)0x00, (byte)0x00, (byte)0xC0, (byte)0xE0, (byte)0xF0
  };
  static {
    assert NativeTrace.registerArrayWithImmutableContent(firstByteMark, "EncodeUCNEscape$$firstByteMark");
  }
}

//<editor-fold defaultstate="collapsed" desc="alwaysFitsInto64Bits">
@Converted(kind = Converted.Kind.MANUAL,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/LiteralSupport.cpp", line = 895,
 old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/LiteralSupport.cpp", old_line = 882,
 FQN="alwaysFitsInto64Bits", NM="_ZL20alwaysFitsInto64Bitsjj",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/LiteralSupport.cpp -nm=_ZL20alwaysFitsInto64Bitsjj")
//</editor-fold>
public static boolean alwaysFitsInto64Bits(/*uint*/int Radix, /*uint*/int NumDigits) {
  switch (Radix) {
   case 2:
    return NumDigits <= 64;
   case 8:
    return NumDigits <= (64 / 3); // Digits are groups of 3 bits.
   case 10:
    return NumDigits <= 19; // floor(log10(2^64))
   case 16:
    return NumDigits <= (64 / 4); // Digits are groups of 4 bits.
   default:
    throw new llvm_unreachable("impossible Radix");
  }
}

//<editor-fold defaultstate="collapsed" desc="resyncUTF8">
@Converted(kind = Converted.Kind.MANUAL,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/LiteralSupport.cpp", line = 1559,
 old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/LiteralSupport.cpp", old_line = 1546,
 FQN="resyncUTF8", NM="_ZL10resyncUTF8PKcS0_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/LiteralSupport.cpp -nm=_ZL10resyncUTF8PKcS0_")
//</editor-fold>
public static /*const*/char$ptr/*char P*/ resyncUTF8(/*const*/char$ptr/*char P*/ Err, /*const*/char$ptr/*char P*/ End) {
  if ($eq_ptr(Err, End)) {
    return End;
  }
  End = Err.$add(std.min_uint(getNumBytesForUTF8(Err.$star()), End.$sub(Err)));
  while (Err.$preInc().$noteq(End) && (Err.$star() & 0xC0) == 0x80) {
    ;
  }
  return Err;
}

} // END OF class LiteralSupportStatics
