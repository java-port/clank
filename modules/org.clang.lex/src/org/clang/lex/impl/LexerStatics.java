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
import org.clang.basic.*;
import static org.clang.basic.BasicClangGlobals.*;
import org.clang.lex.*;
import static org.clang.lex.impl.UnicodeCharSetsStatics.*;
import static org.clank.java.std.*;
import static org.clank.java.std_pair.*;
import org.clank.support.*;
import static org.clank.support.Native.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Unsigned.*;
import org.clank.support.aliases.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.llvm.support.sys.UnicodeCharSet;


//<editor-fold defaultstate="collapsed" desc="static type LexerStatics">
@Converted(kind = Converted.Kind.MANUAL, cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType -java-types-map=${SPUTNIK}/contrib/JConvert/llvmToClankType -print ${LLVM_SRC}/llvm/tools/clang/lib/Lex/Lexer.cpp -nm=_ZL23getBeginningOfFileTokenN5clang14SourceLocationERKNS_13SourceManagerERKNS_11LangOptionsE;_ZL15FindConflictEndPKcS0_N5clang18ConflictMarkerKindE;_ZL24isAllowedInitiallyIDCharjRKN5clang11LangOptionsE;_ZL25maybeDiagnoseIDCharCompatRN5clang17DiagnosticsEngineEjNS_15CharSourceRangeEb;_ZN12_GLOBAL__N_121PreambleDirectiveKindE;_ZL15isAllowedIDCharjRKN5clang11LangOptionsE;_ZL13makeCharRangeRN5clang5LexerEPKcS3_;_ZL21makeRangeFromFileLocsN5clang15CharSourceRangeERKNS_13SourceManagerERKNS_11LangOptionsE;_ZL15getSpellingSlowRKN5clang5TokenEPKcRKNS_11LangOptionsEPc;_ZL24GetTrigraphCharForLetterc;_ZL18DecodeTrigraphCharPKcPN5clang5LexerE;_ZL37isEndOfBlockCommentWithEscapedNewLinePKcPN5clang5LexerE;_ZL17GetMappedTokenLocRN5clang12PreprocessorENS_14SourceLocationEjj;_ZL17GetMappedTokenLocRN5clang12PreprocessorENS_14SourceLocationEjj; -static-type=LexerStatics")
//</editor-fold>
public final class LexerStatics {


/// \brief Slow case of getSpelling. Extract the characters comprising the
/// spelling of this token from the provided input buffer.
//<editor-fold defaultstate="collapsed" desc="getSpellingSlow">
@Converted(kind = Converted.Kind.MANUAL, source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/Lexer.cpp", line = 231,
 old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/Lexer.cpp", old_line = 237,
 FQN = "getSpellingSlow", NM = "_ZL15getSpellingSlowRKN5clang5TokenEPKcRKNS_11LangOptionsEPc",
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/Lexer.cpp -nm=_ZL15getSpellingSlowRKN5clang5TokenEPKcRKNS_11LangOptionsEPc")
//</editor-fold>
public static /*size_t*/int getSpellingSlow(/*const*/Token /*&*/ Tok, /*const*/char$ptr/*char P*/ _BufPtr, /*const*/LangOptions /*&*/ LangOpts, byte[]/*char P*/ Spelling, int toIdx) {
  assert (Tok.needsCleaning()) : "getSpellingSlow called on simple token";
  
  /*size_t*/int Length = 0;
  int BufPtr = _BufPtr.$index();
  int BufEnd = BufPtr + Tok.getLength();
  byte[] BufArray = _BufPtr.$array();
  if (tok.isStringLiteral(Tok.getKind())) {
    // Munch the encoding-prefix and opening double-quote.
    while (BufPtr < BufEnd) {
      /*<char-byte, size-int>pair*/long Size;
      Spelling[toIdx + Length++] = $first_byte(Size = Lexer.getCharAndSizeNoWarn(BufArray, BufPtr, LangOpts));
      BufPtr += $second_int(Size);
      if (Spelling[toIdx + Length - 1] == $('"')) {
        break;
      }
    }
    
    // Raw string literals need special handling; trigraph expansion and line
    // splicing do not occur within their d-char-sequence nor within their
    // r-char-sequence.
    if (Length >= 2 && Spelling[toIdx + Length - 2] == $('R') && Spelling[toIdx + Length - 1] == $('"')) {
      // Search backwards from the end of the token to find the matching closing
      // quote.
      /*const*/int/*char P*/ RawEnd = BufEnd;
      do  {
        --RawEnd;
      } while (BufArray[RawEnd] != $('"'));
      /*size_t*/int RawLength = RawEnd - BufPtr + 1;
      
      // Everything between the quotes is included verbatim in the spelling.
      memcpy(Spelling, toIdx + Length, BufArray, BufPtr, RawLength);
      Length += RawLength;
      BufPtr += RawLength;
      // The rest of the token is lexed normally.
    }
  }
  while (BufPtr < BufEnd) {
    /*<char-byte, size-int>pair*/long Size;
    Spelling[toIdx + Length++] = $first_byte(Size = Lexer.getCharAndSizeNoWarn(BufArray, BufPtr, LangOpts));
    BufPtr += $second_int(Size);
  }
  assert ($less_uint(Length, Tok.getLength())) : "NeedsCleaning flag set on token that didn't need cleaning!";
  return Length;
}

//<editor-fold defaultstate="collapsed" desc="getBeginningOfFileToken">
@Converted(kind = Converted.Kind.MANUAL, source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/Lexer.cpp", line = 449,
 old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/Lexer.cpp", old_line = 455,
 FQN = "getBeginningOfFileToken", NM = "_ZL23getBeginningOfFileTokenN5clang14SourceLocationERKNS_13SourceManagerERKNS_11LangOptionsE",
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/Lexer.cpp -nm=_ZL23getBeginningOfFileTokenN5clang14SourceLocationERKNS_13SourceManagerERKNS_11LangOptionsE")
//</editor-fold>
public static /*SourceLocation*/int getBeginningOfFileToken(SourceLocation Loc, /*const*/SourceManager /*&*/ SM, /*const*/LangOptions /*&*/ LangOpts) {
  return getBeginningOfFileToken(Loc.getRawEncoding(), SM, LangOpts);
}
public static /*SourceLocation*/int getBeginningOfFileToken(/*SourceLocation*/int Loc, /*const*/SourceManager /*&*/ SM, /*const*/LangOptions /*&*/ LangOpts) {
  Lexer TheLexer = null;
  try {
    assert (SourceLocation.isFileID(Loc));
    long/*<FileID, uint>*/ LocInfo = SM.getDecomposedLoc(Loc);
    if (FileID.isInvalid($first_FileID(LocInfo))) {
      return Loc;
    }
    
    bool$ptr Invalid = null;//create_bool$ptr(false);
    StringRef Buffer = SM.getBufferData($first_FileID(LocInfo), /*AddrOf*/Invalid);
    if (Buffer == SourceManager.INVALID_BUFFER_DATA) {
      return Loc;
    }
    
    // Back up from the current location until we hit the beginning of a line
    // (or the buffer). We'll relex from that point.
    /*const*/char$ptr/*char P*/ BufStart = Buffer.data();
    if ($second_offset(LocInfo) >= Buffer.size()) {
      return Loc;
    }
    
    /*const*/char$ptr/*char P*/ StrData = BufStart.$add($second_offset(LocInfo));
    if (StrData.$at(0) == '\n' || StrData.$at(0) == '\r') {
      return Loc;
    }
    int StrDataIndex = StrData.$index();
    /*const*/char$ptr/*char P*/ LexStart = StrData;
    while (LexStart.$noteq(BufStart)) {
      if (LexStart.$at(0) == '\n' || LexStart.$at(0) == '\r') {
        LexStart.$preInc();
        break;
      }
      
      LexStart.$preDec();
    }
    
    // Create a lexer starting at the beginning of this token.
    /*SourceLocation*/int LexerStartLoc = SourceLocation.$getLocWithOffset(Loc, -$second_offset(LocInfo));
    TheLexer/*J*/= new Lexer(LexerStartLoc, LangOpts, $noClone(BufStart), $noClone(LexStart), BufStart.$index() + Buffer.size());
    TheLexer.SetCommentRetentionState(true);
    
    // Lex tokens until we find the token that contains the source location.
    Token TheTok/*J*/= new Token();
    do {
      TheLexer.LexFromRawLexer(TheTok);
      if (TheLexer.getBufferLocation().$index() > StrDataIndex) {
        // Lexing this token has taken the lexer past the source location we're
        // looking for. If the current token encompasses our source location,
        // return the beginning of that token.
        if ((TheLexer.getBufferLocation().$index() - TheTok.getLength()) <= StrDataIndex) {
          return TheTok.$getLocation();
        }
        
        // We ended up skipping over the source location entirely, which means
        // that it points into whitespace. We're done here.
        break;
      }
    } while (TheTok.getKind() != tok.TokenKind.eof);
    
    // We've passed our source location; just return the original source location.
    return Loc;
  } finally {
    if (TheLexer != null) { TheLexer.$destroy(); }
  }
}

//<editor-fold defaultstate="collapsed" desc="makeRangeFromFileLocs">
@Converted(kind = Converted.Kind.MANUAL,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/Lexer.cpp", line = 831,
 old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/Lexer.cpp", old_line = 829,
 FQN="makeRangeFromFileLocs", NM="_ZL21makeRangeFromFileLocsN5clang15CharSourceRangeERKNS_13SourceManagerERKNS_11LangOptionsE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/Lexer.cpp -nm=_ZL21makeRangeFromFileLocsN5clang15CharSourceRangeERKNS_13SourceManagerERKNS_11LangOptionsE")
//</editor-fold>
public static CharSourceRange makeRangeFromFileLocs(CharSourceRange Range, /*const*/SourceManager /*&*/ SM, /*const*/LangOptions /*&*/ LangOpts) {
  /*SourceLocation*/int Begin = Range.$getBegin();
  /*SourceLocation*/int End = Range.$getEnd();
  assert (SourceLocation.isFileID(Begin) && SourceLocation.isFileID(End));
  if (Range.isTokenRange()) {
    End = Lexer.getLocForEndOfToken(End, 0, SM, LangOpts);
    if (SourceLocation.isInvalid(End)) {
      return new CharSourceRange();
    }
  }
  
  // Break down the source locations.
  /*FileID*/int FID/*J*/= FileID.getInvalidID();
  /*uint*/int BeginOffs;
  long/*<FileID, uint>*/ decompLoc = SM.getDecomposedLoc(Begin);
  FID = $first_FileID(decompLoc);
  BeginOffs = $second_offset(decompLoc);
//  llvm.tie(FID, BeginOffs).$assign(SM.getDecomposedLoc(Begin));
  if (FileID.isInvalid(FID)) {
    return new CharSourceRange();
  }
  
  /*uint*/uint$ptr EndOffs = create_uint$ptr();
  if (!SM.isInFileID(End, FID, $AddrOf(EndOffs)) || BeginOffs > EndOffs.$star()) {
    return new CharSourceRange();
  }
  
  return CharSourceRange.getCharRange(Begin, End);
}


/// GetMappedTokenLoc - If lexing out of a 'mapped buffer', where we pretend the
/// lexer buffer was all expanded at a single point, perform the mapping.
/// This is currently only used for _Pragma implementation, so it is the slow
/// path of the hot getSourceLocation method.  Do not allow it to be inlined.
//<editor-fold defaultstate="collapsed" desc="GetMappedTokenLoc">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/Lexer.cpp", line = 1045,
 old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/Lexer.cpp", old_line = 1018,
 FQN="GetMappedTokenLoc", NM="_ZL17GetMappedTokenLocRN5clang12PreprocessorENS_14SourceLocationEjj",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/Lexer.cpp -nm=_ZL17GetMappedTokenLocRN5clang12PreprocessorENS_14SourceLocationEjj")
//</editor-fold>
public static /*SourceLocation*/int GetMappedTokenLoc(Preprocessor /*&*/ PP, /*SourceLocation*/int FileLoc, /*uint*/int CharNo, /*uint*/int TokLen)/* __attribute__((noinline))*/ {
  assert (SourceLocation.isMacroID(FileLoc)) : "Must be a macro expansion";
  
  // Otherwise, we're lexing "mapped tokens".  This is used for things like
  // _Pragma handling.  Combine the expansion location of FileLoc with the
  // spelling location.
  SourceManager /*&*/ SM = PP.getSourceManager();
  
  // Create a new SLoc which is expanded from Expansion(FileLoc) but whose
  // characters come from spelling(FileLoc)+Offset.
  /*SourceLocation*/int SpellingLoc = SM.getSpellingLoc(FileLoc);
  SpellingLoc = SourceLocation.$getLocWithOffset(SpellingLoc, CharNo);
  
  // Figure out the expansion loc range, which is the range covered by the
  // original _Pragma(...) sequence.
  /*<SourceLocation, SourceLocation>*/long II = SM.getImmediateExpansionRange(FileLoc);
  
  return SM.createExpansionLoc(SpellingLoc, $first_int(II), $second_int(II), TokLen);
}


/// GetTrigraphCharForLetter - Given a character that occurs after a ?? pair,
/// return the decoded trigraph letter it corresponds to, or '\0' if nothing.
//<editor-fold defaultstate="collapsed" desc="GetTrigraphCharForLetter">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/Lexer.cpp", line = 1099,
 old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/Lexer.cpp", old_line = 1072,
 FQN="GetTrigraphCharForLetter", NM="_ZL24GetTrigraphCharForLetterc",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/Lexer.cpp -nm=_ZL24GetTrigraphCharForLetterc")
//</editor-fold>
public static /*char*/byte GetTrigraphCharForLetter(/*char*/byte Letter) {
  switch (Letter) {
   default:
    return 0;
   case '=':
    return '#';
   case ')':
    return ']';
   case '(':
    return '[';
   case '!':
    return '|';
   case '\'':
    return '^';
   case '>':
    return '}';
   case '/':
    return '\\';
   case '<':
    return '{';
   case '-':
    return '~';
  }
}


/// DecodeTrigraphChar - If the specified character is a legal trigraph when
/// prefixed with ??, emit a trigraph warning.  If trigraphs are enabled,
/// return the result character.  Finally, emit a warning about trigraph use
/// whether trigraphs are enabled or not.
//<editor-fold defaultstate="collapsed" desc="DecodeTrigraphChar">
@Converted(kind = Converted.Kind.MANUAL,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/Lexer.cpp", line = 1118,
 old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/Lexer.cpp", old_line = 1091,
 FQN="DecodeTrigraphChar", NM="_ZL18DecodeTrigraphCharPKcPN5clang5LexerE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/Lexer.cpp -nm=_ZL18DecodeTrigraphCharPKcPN5clang5LexerE")
//</editor-fold>
public static /*char*/byte DecodeTrigraphChar(/*const*/char$ptr/*char P*/ CP, Lexer /*P*/ L) {
  /*char*/byte Res = GetTrigraphCharForLetter(CP.$star());
  if (!(Res != 0) || !(L != null)) {
    return Res;
  }
  if (!L.getLangOpts().Trigraphs) {
    if (!L.isLexingRawMode()) {
      L.Diag(CP.$sub(2), diag.trigraph_ignored).$destroy();
    }
    return 0;
  }
  if (!L.isLexingRawMode()) {
    $out_DiagnosticBuilder$C_StringRef(L.Diag(CP.$sub(2), diag.trigraph_converted), new StringRef($AddrOf(new$char(1, Res)), 1)).$destroy();
  }
  return Res;
}

private final static /*const*/UnicodeCharSet C11AllowedIDChars/*J*/= new UnicodeCharSet(new ArrayRef(C11AllowedIDCharRanges));
private final static /*const*/UnicodeCharSet CXX03AllowedIDChars/*J*/= new UnicodeCharSet(new ArrayRef(CXX03AllowedIDCharRanges));
private final static /*const*/UnicodeCharSet C99AllowedIDChars/*J*/= new UnicodeCharSet(new ArrayRef(C99AllowedIDCharRanges));
private final static /*const*/UnicodeCharSet C11DisallowedInitialIDChars/*J*/= new UnicodeCharSet(new ArrayRef(C11DisallowedInitialIDCharRanges));
private final static /*const*/UnicodeCharSet C99DisallowedInitialIDChars/*J*/= new UnicodeCharSet(new ArrayRef(C99DisallowedInitialIDCharRanges));
//<editor-fold defaultstate="collapsed" desc="isAllowedIDChar">
@Converted(kind = Converted.Kind.MANUAL,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/Lexer.cpp", line = 1383,
 old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/Lexer.cpp", old_line = 1356,
 FQN="isAllowedIDChar", NM="_ZL15isAllowedIDCharjRKN5clang11LangOptionsE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/Lexer.cpp -nm=_ZL15isAllowedIDCharjRKN5clang11LangOptionsE")
//</editor-fold>
public static boolean isAllowedIDChar(int/*uint32_t*/ C, /*const*/LangOptions /*&*/ LangOpts) {
  if (LangOpts.AsmPreprocessor) {
    return false;
  } else if (LangOpts.CPlusPlus11 || LangOpts.C11) {
    return C11AllowedIDChars.contains(C);
  } else if (LangOpts.CPlusPlus) {
    return CXX03AllowedIDChars.contains(C);
  } else {
    return C99AllowedIDChars.contains(C);
  }
}

//<editor-fold defaultstate="collapsed" desc="isAllowedInitiallyIDChar">
@Converted(kind = Converted.Kind.MANUAL,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/Lexer.cpp", line = 1401,
 old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/Lexer.cpp", old_line = 1374,
 FQN="isAllowedInitiallyIDChar", NM="_ZL24isAllowedInitiallyIDCharjRKN5clang11LangOptionsE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/Lexer.cpp -nm=_ZL24isAllowedInitiallyIDCharjRKN5clang11LangOptionsE")
//</editor-fold>
public static boolean isAllowedInitiallyIDChar(int/*uint32_t*/ C, /*const*/LangOptions /*&*/ LangOpts) {
  assert (isAllowedIDChar(C, LangOpts));
  if (LangOpts.AsmPreprocessor) {
    return false;
  } else if (LangOpts.CPlusPlus11 || LangOpts.C11) {
    return !C11DisallowedInitialIDChars.contains(C);
  } else if (LangOpts.CPlusPlus) {
    return true;
  } else {
    return !C99DisallowedInitialIDChars.contains(C);
  }
}

//<editor-fold defaultstate="collapsed" desc="makeCharRange">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/Lexer.cpp", line = 1418,
 old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/Lexer.cpp", old_line = 1391,
 FQN="makeCharRange", NM="_ZL13makeCharRangeRN5clang5LexerEPKcS3_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/Lexer.cpp -nm=_ZL13makeCharRangeRN5clang5LexerEPKcS3_")
//</editor-fold>
public static /*inline*/ CharSourceRange makeCharRange(Lexer /*&*/ L, /*const*/char$ptr/*char P*/ Begin, /*const*/char$ptr/*char P*/ End) {
  return CharSourceRange.getCharRange(L.getCharSourceLocation(Begin), L.getCharSourceLocation(End));
}

//<editor-fold defaultstate="collapsed" desc="Unnamed_enum_maybeDiagnoseIDCharCompat">
@Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/Lexer.cpp", line = 1403,
 FQN="", NM="_ZL25maybeDiagnoseIDCharCompatRN5clang17DiagnosticsEngineEjNS_15CharSourceRangeEb_Lexer_cpp_Unnamed_enum",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/Lexer.cpp -nm=_ZL25maybeDiagnoseIDCharCompatRN5clang17DiagnosticsEngineEjNS_15CharSourceRangeEb_Lexer_cpp_Unnamed_enum")
//</editor-fold>
private enum Unnamed_enum_maybeDiagnoseIDCharCompat {
  CannotAppearInIdentifier(0),
  CannotStartIdentifier(CannotAppearInIdentifier.getValue() + 1);

  //<editor-fold defaultstate="collapsed" desc="hidden">
        public static Unnamed_enum_maybeDiagnoseIDCharCompat valueOf(int val) {
          Unnamed_enum_maybeDiagnoseIDCharCompat out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
          assert out != null : "no value for " + val;
          return out;
        }

        private static final class Values {
          private static final Unnamed_enum_maybeDiagnoseIDCharCompat[] VALUES;
          private static final Unnamed_enum_maybeDiagnoseIDCharCompat[] _VALUES; // [0] not used
          static {
            int max = 0;
            int min = 0;
            for (Unnamed_enum_maybeDiagnoseIDCharCompat kind : Unnamed_enum_maybeDiagnoseIDCharCompat.values()) {
              if (kind.value > max) { max = kind.value; }
              if (kind.value < min) { min = kind.value; }
            }
            _VALUES = new Unnamed_enum_maybeDiagnoseIDCharCompat[min < 0 ? (1-min) : 0];
            VALUES = new Unnamed_enum_maybeDiagnoseIDCharCompat[max >= 0 ? (1+max) : 0];
            for (Unnamed_enum_maybeDiagnoseIDCharCompat kind : Unnamed_enum_maybeDiagnoseIDCharCompat.values()) {
              if (kind.value < 0) {
                _VALUES[-kind.value] = kind;
              } else {
                VALUES[kind.value] = kind;
              }
            }
          }
        }

        private final int value;
        private Unnamed_enum_maybeDiagnoseIDCharCompat(/*uint*/int val) { this.value = (int)val;}
        public int getValue() { return (int)value;}
        //</editor-fold>
};

//<editor-fold defaultstate="collapsed" desc="maybeDiagnoseIDCharCompat">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/Lexer.cpp", line = 1424,
 old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/Lexer.cpp", old_line = 1397,
 FQN="maybeDiagnoseIDCharCompat", NM="_ZL25maybeDiagnoseIDCharCompatRN5clang17DiagnosticsEngineEjNS_15CharSourceRangeEb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/Lexer.cpp -nm=_ZL25maybeDiagnoseIDCharCompatRN5clang17DiagnosticsEngineEjNS_15CharSourceRangeEb")
//</editor-fold>
public static void maybeDiagnoseIDCharCompat(DiagnosticsEngine /*&*/ Diags, int/*uint32_t*/ C, 
                         CharSourceRange Range, boolean IsFirst) {
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    // Check C99 compatibility.
    if (!Diags.isIgnored(diag.warn_c99_compat_unicode_id, Range.getBegin())) {
      if (!C99AllowedIDChars.contains(C)) {
        $c$.clean($out_DiagnosticBuilder$C_int($out_DiagnosticBuilder$C_CharSourceRange$C($c$.track(Diags.Report(Range.getBegin(), diag.warn_c99_compat_unicode_id)), 
                Range), 
            Unnamed_enum_maybeDiagnoseIDCharCompat.CannotAppearInIdentifier.getValue()));
      } else if (IsFirst && C99DisallowedInitialIDChars.contains(C)) {
        $c$.clean($out_DiagnosticBuilder$C_int($out_DiagnosticBuilder$C_CharSourceRange$C($c$.track(Diags.Report(Range.getBegin(), diag.warn_c99_compat_unicode_id)), 
                Range), 
            Unnamed_enum_maybeDiagnoseIDCharCompat.CannotStartIdentifier.getValue()));
      }
    }
    
    // Check C++98 compatibility.
    if (!Diags.isIgnored(diag.warn_cxx98_compat_unicode_id, Range.getBegin())) {
      if (!CXX03AllowedIDChars.contains(C)) {
        $c$.clean($out_DiagnosticBuilder$C_CharSourceRange$C($c$.track(Diags.Report(Range.getBegin(), diag.warn_cxx98_compat_unicode_id)), 
            Range));
      }
    }
  } finally {
    $c$.$destroy();
  }
}


/// isBlockCommentEndOfEscapedNewLine - Return true if the specified newline
/// character (either \\n or \\r) is part of an escaped newline sequence.  Issue
/// a diagnostic if so.  We know that the newline is inside of a block comment.
//<editor-fold defaultstate="collapsed" desc="isEndOfBlockCommentWithEscapedNewLine">
@Converted(kind = Converted.Kind.MANUAL,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/Lexer.cpp", line = 2210,
 old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/Lexer.cpp", old_line = 2182,
 FQN="isEndOfBlockCommentWithEscapedNewLine", NM="_ZL37isEndOfBlockCommentWithEscapedNewLinePKcPN5clang5LexerE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/Lexer.cpp -nm=_ZL37isEndOfBlockCommentWithEscapedNewLinePKcPN5clang5LexerE")
//</editor-fold>
public static boolean isEndOfBlockCommentWithEscapedNewLine(/*const*/char$ptr/*char P*/ CurPtr, Lexer /*P*/ L) {
  assert (CurPtr.$at(0) == '\n' || CurPtr.$at(0) == '\r');
  
  // Back up off the newline.
  CurPtr.$preDec();
  
  // If this is a two-character newline sequence, skip the other character.
  if (CurPtr.$at(0) == '\n' || CurPtr.$at(0) == '\r') {
    // \n\n or \r\r -> not escaped newline.
    if (CurPtr.$at(0) == CurPtr.$at(1)) {
      return false;
    }
    // \n\r or \r\n -> skip the newline.
    CurPtr.$preDec();
  }
  
  // If we have horizontal whitespace, skip over it.  We allow whitespace
  // between the slash and newline.
  boolean HasSpace = false;
  while (isHorizontalWhitespace(CurPtr.$star()) || CurPtr.$star() == 0) {
    CurPtr.$preDec();
    HasSpace = true;
  }
  
  // If we have a slash, we know this is an escaped newline.
  if (CurPtr.$star() == '\\') {
    if (CurPtr.$at(-1) != $('*')) {
      return false;
    }
  } else {
    // It isn't a slash, is it the ?? / trigraph?
    if (CurPtr.$at(0) != $('/') || CurPtr.$at(-1) != $('?') || CurPtr.$at(-2) != $('?') || CurPtr.$at(-3) != $('*')) {
      return false;
    }
    
    // This is the trigraph ending the comment.  Emit a stern warning!
    CurPtr.$dec(2);
    
    // If no trigraphs are enabled, warn that we ignored this trigraph and
    // ignore this * character.
    if (!L.getLangOpts().Trigraphs) {
      if (!L.isLexingRawMode()) {
        L.Diag(CurPtr, diag.trigraph_ignored_block_comment).$destroy();
      }
      return false;
    }
    if (!L.isLexingRawMode()) {
      L.Diag(CurPtr, diag.trigraph_ends_block_comment).$destroy();
    }
  }
  
  // Warn about having an escaped newline between the */ characters.
  if (!L.isLexingRawMode()) {
    L.Diag(CurPtr, diag.escaped_newline_block_comment_end).$destroy();
  }
  
  // If there was space between the backslash and newline, warn about it.
  if (HasSpace && !L.isLexingRawMode()) {
    L.Diag(CurPtr, diag.backslash_newline_space).$destroy();
  }
  
  return true;
}


/// \brief Find the end of a version control conflict marker.
//<editor-fold defaultstate="collapsed" desc="FindConflictEnd">
@Converted(kind = Converted.Kind.MANUAL/*$cleanConst*/,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/Lexer.cpp", line = 2609,
 old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/Lexer.cpp", old_line = 2581,
 FQN="FindConflictEnd", NM="_ZL15FindConflictEndPKcS0_N5clang18ConflictMarkerKindE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/Lexer.cpp -nm=_ZL15FindConflictEndPKcS0_N5clang18ConflictMarkerKindE")
//</editor-fold>
public static /*const*/char$ptr/*char P*/ FindConflictEnd(/*const*/char$ptr/*char P*/ CurPtr, /*const*/char$ptr/*char P*/ BufferEnd, ConflictMarkerKind CMK) {
  /*const*/String/*char P*/ Terminator = CMK == ConflictMarkerKind.CMK_Perforce ? "<<<<\n" : ">>>>>>>";
  /*size_t*/int TermLen = CMK == ConflictMarkerKind.CMK_Perforce ? 5 : 7;
  StringRef RestOfBuffer = new StringRef(CurPtr, BufferEnd.$sub(CurPtr)).substr(TermLen);
  $cleanConst(CurPtr);//JAVA: clear const set by StringRef constructor
  /*size_t*/int Pos = RestOfBuffer.find(Terminator);
  while (Pos != StringRef.npos) {
    // Must occur at start of line.
    if (Pos == 0
       || (RestOfBuffer.$at(Pos - 1) != $$CR && RestOfBuffer.$at(Pos - 1) != $$LF)) {
      RestOfBuffer.$assign$substr(Pos + TermLen);
      Pos = RestOfBuffer.find(Terminator);
      continue;
    }
    return RestOfBuffer.data().$add(Pos);
  }
  return null;
}

} // END OF class LexerStatics
