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

import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.java.std.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.clang.basic.*;
import org.clang.lex.*;
import static org.clang.basic.BasicClangGlobals.*;
import static org.clang.lex.LexClangGlobals.*;
import static org.clang.lex.impl.LiteralSupportStatics.*;


/// NumericLiteralParser - This performs strict semantic analysis of the content
/// of a ppnumber, classifying it as either integer, floating, or erroneous,
/// determines the radix of the value and can convert it to a useful value.
//<editor-fold defaultstate="collapsed" desc="clang::NumericLiteralParser">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/LiteralSupport.h", line = 43,
 old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/LiteralSupport.h", old_line = 42,
 FQN="clang::NumericLiteralParser", NM="_ZN5clang20NumericLiteralParserE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/LiteralSupport.cpp -nm=_ZN5clang20NumericLiteralParserE")
//</editor-fold>
public class NumericLiteralParser implements Destructors.ClassWithDestructor {
  private Preprocessor /*&*/ PP; // needed for diagnostics
  private final/*const*/char$ptr/*char P*//*const*/ ThisTokBegin;
  private static final int NULL$INDEX = -1;
  private final/*const*/int/*char P*//*const*/ ThisTokBegin$Index;
  private /*const*/int/*char P*//*const*/ ThisTokEnd$Index;
  private /*const*/int/*char P*/ DigitsBegin$Index;
  private /*const*/int/*char P*/ SuffixBegin$Index; // markers
  private /*const*/char$ptr/*char P*/ s; // cursor
  
  private /*uint*/int radix;
  
  private boolean saw_exponent;
  
  private boolean saw_period;
  
  private boolean saw_ud_suffix;
  
  private SmallString/*32*/ UDSuffixBuf;
/*public:*/
  
  ///       integer-constant: [C99 6.4.4.1]
  ///         decimal-constant integer-suffix
  ///         octal-constant integer-suffix
  ///         hexadecimal-constant integer-suffix
  ///         binary-literal integer-suffix [GNU, C++1y]
  ///       user-defined-integer-literal: [C++11 lex.ext]
  ///         decimal-literal ud-suffix
  ///         octal-literal ud-suffix
  ///         hexadecimal-literal ud-suffix
  ///         binary-literal ud-suffix [GNU, C++1y]
  ///       decimal-constant:
  ///         nonzero-digit
  ///         decimal-constant digit
  ///       octal-constant:
  ///         0
  ///         octal-constant octal-digit
  ///       hexadecimal-constant:
  ///         hexadecimal-prefix hexadecimal-digit
  ///         hexadecimal-constant hexadecimal-digit
  ///       hexadecimal-prefix: one of
  ///         0x 0X
  ///       binary-literal:
  ///         0b binary-digit
  ///         0B binary-digit
  ///         binary-literal binary-digit
  ///       integer-suffix:
  ///         unsigned-suffix [long-suffix]
  ///         unsigned-suffix [long-long-suffix]
  ///         long-suffix [unsigned-suffix]
  ///         long-long-suffix [unsigned-sufix]
  ///       nonzero-digit:
  ///         1 2 3 4 5 6 7 8 9
  ///       octal-digit:
  ///         0 1 2 3 4 5 6 7
  ///       hexadecimal-digit:
  ///         0 1 2 3 4 5 6 7 8 9
  ///         a b c d e f
  ///         A B C D E F
  ///       binary-digit:
  ///         0
  ///         1
  ///       unsigned-suffix: one of
  ///         u U
  ///       long-suffix: one of
  ///         l L
  ///       long-long-suffix: one of
  ///         ll LL
  ///
  ///       floating-constant: [C99 6.4.4.2]
  ///         TODO: add rules...
  ///
  //<editor-fold defaultstate="collapsed" desc="clang::NumericLiteralParser::NumericLiteralParser">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC, optimized = Converted.Optimization.COMPLEX,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/LiteralSupport.cpp", line = 507,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/LiteralSupport.cpp", old_line = 506,
   FQN="clang::NumericLiteralParser::NumericLiteralParser", NM="_ZN5clang20NumericLiteralParserC1EN4llvm9StringRefENS_14SourceLocationERNS_12PreprocessorE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/LiteralSupport.cpp -nm=_ZN5clang20NumericLiteralParserC1EN4llvm9StringRefENS_14SourceLocationERNS_12PreprocessorE")
  //</editor-fold>
  public NumericLiteralParser(StringRef TokSpelling, 
      SourceLocation TokLoc, 
      Preprocessor /*&*/ PP) {
    this(TokSpelling, TokLoc.getRawEncoding(), PP);
  }
  public NumericLiteralParser(StringRef TokSpelling, 
      /*SourceLocation*/int TokLoc, 
      Preprocessor /*&*/ PP) {
    /* : PP(PP), ThisTokBegin(TokSpelling.begin()), ThisTokEnd(TokSpelling.end()), UDSuffixBuf()*/ 
    //START JInit
    this.PP = PP;
    this.ThisTokBegin = $noClone(TokSpelling.begin());
    this.UDSuffixBuf = new SmallString/*32*/(32);
    //END JInit
    this.ThisTokBegin$Index = ThisTokBegin.$index();
    this.ThisTokEnd$Index = ThisTokBegin$Index + TokSpelling.size();

    // This routine assumes that the range begin/end matches the regex for integer
    // and FP constants (specifically, the 'pp-number' regex), and assumes that
    // the byte at "*end" is both valid and not part of the regex.  Because of
    // this, it doesn't have to check for 'overscan' in various places.
    assert (!isPreprocessingNumberBody(Ptr$star(ThisTokEnd$Index))) : "didn't maximally munch?";

    DigitsBegin$Index = ThisTokBegin$Index;
    s = $tryClone(ThisTokBegin);
    saw_exponent = false;
    saw_period = false;
    saw_ud_suffix = false;
    isLong = false;
    isUnsigned = false;
    isLongLong = false;
    isHalf = false;
    isFloat = false;
    isImaginary = false;
    isFloat128 = false;
    MicrosoftInteger = 0;
    hadError = false;
    if (s.$star() == $$0) { // parse radix
      ParseNumberStartingWithZero(/*NO_COPY*/TokLoc);
      if (hadError) {
        return;
      }
    } else { // the first digit is non-zero
      radix = 10;
      s = $noClone(SkipDigits(s));
      if (s.$index() == ThisTokEnd$Index) {
        // Done.
      } else {
        ParseDecimalOrOctalCommon(/*NO_COPY*/TokLoc);
        if (hadError) {
          return;
        }        
      }
    }

    SuffixBegin$Index = s.$index();
    checkSeparator(/*NO_COPY*/TokLoc, s, CheckSeparatorKind.CSK_AfterDigits);

    // Parse the suffix.  At this point we can classify whether we have an FP or
    // integer constant.
    boolean isFPConstant = isFloatingLiteral();
    /*const*/int/*char P*/ ImaginarySuffixLoc$Index = NULL$INDEX;

    // Loop over all of the characters of the suffix.  If we see something bad,
    // we break out of the loop.
    for (; (s.$index() != ThisTokEnd$Index); s.$preInc()) {
      switch (s.$star()) {
       case 'h': // FP Suffix for "half".
       case 'H':
        // OpenCL Extension v1.2 s9.5 - h or H suffix for half type.
        if (!PP.getLangOpts().Half) {
          break;
        }
        if (!isFPConstant) {
          break; // Error for integer constant.
        }
        if (isHalf || isFloat || isLong) {
          break; // HH, FH, LH invalid.
        }
        isHalf = true;
        continue; // Success.
       case 'f': // FP Suffix for "float"
       case 'F':
        if (!isFPConstant) {
          break; // Error for integer constant.
        }
        if (isHalf || isFloat || isLong || isFloat128) {
          break; // HF, FF, LF, QF invalid.
        }
        isFloat = true;
        continue; // Success.
       case 'q': // FP Suffix for "__float128"
       case 'Q':
        if (!isFPConstant) {
          break; // Error for integer constant.
        }
        if (isHalf || isFloat || isLong || isFloat128) {
          break; // HQ, FQ, LQ, QQ invalid.
        }
        isFloat128 = true;
        continue; // Success.
       case 'u':
       case 'U':
        if (isFPConstant) {
          break; // Error for floating constant.
        }
        if (isUnsigned) {
          break; // Cannot be repeated.
        }
        isUnsigned = true;
        continue; // Success.
       case 'l':
       case 'L':
        if (isLong || isLongLong) {
          break; // Cannot be repeated.
        }
        if (isHalf || isFloat || isFloat128) {
          break; // LH, LF, LQ invalid.
        }

        // Check for long long.  The L's need to be adjacent and the same case.
        if (s.$at(1) == s.$at(0)) {
          assert (s.$index() + 1 < ThisTokEnd$Index) : "didn't maximally munch?";
          if (isFPConstant) {
            break; // long long invalid for floats.
          }
          isLongLong = true;
          s.$preInc(); // Eat both of them.
        } else {
          isLong = true;
        }
        continue; // Success.
       case 'i':
       case 'I':
        if (PP.getLangOpts().MicrosoftExt) {
          if (isLong || isLongLong || (MicrosoftInteger != 0)) {
            break;
          }
          if (!isFPConstant) {
            // Allow i8, i16, i32, and i64.
            switch (s.$at(1)) {
             case '8':
              s.$inc(2); // i8 suffix
              MicrosoftInteger = 8;
              break;
             case '1':
              if (s.$at(2) == $$6) {
                s.$inc(3); // i16 suffix
                MicrosoftInteger = 16;
              }
              break;
             case '3':
              if (s.$at(2) == $$2) {
                s.$inc(3); // i32 suffix
                MicrosoftInteger = 32;
              }
              break;
             case '6':
              if (s.$at(2) == $$4) {
                s.$inc(3); // i64 suffix
                MicrosoftInteger = 64;
              }
              break;
             default:
              break;
            }
          }
          if ((MicrosoftInteger != 0)) {
            assert (s.$index() <= ThisTokEnd$Index) : "didn't maximally munch?";
            break;
          }
        }
        // "i", "if", and "il" are user-defined suffixes in C++1y.
        if (PP.getLangOpts().CPlusPlus14 && s.$star() == $$i) {
          break;
        }
       case 'j':
       case 'J':
        // fall through.
        if (isImaginary) {
          break; // Cannot be repeated.
        }
        isImaginary = true;
        ImaginarySuffixLoc$Index = s.$index();
        continue; // Success.
      }
      // If we reached here, there was an error or a ud-suffix.
      break;
    }
    if (s.$index() != ThisTokEnd$Index) {
      // JAVA: moved cleaner close to Diag
      // JavaCleaner $c$ = $createJavaCleaner();
      // try {
      // FIXME: Don't bother expanding UCNs if !tok.hasUCN().
      expandUCNs(UDSuffixBuf, new StringRef($SuffixBegin(), ThisTokEnd$Index - SuffixBegin$Index));
      if (isValidUDSuffix(PP.getLangOpts(), UDSuffixBuf.$StringRef())) {
        // Any suffix pieces we might have parsed are actually part of the
        // ud-suffix.
        isLong = false;
        isUnsigned = false;
        isLongLong = false;
        isFloat = false;
        isHalf = false;
        isImaginary = false;
        MicrosoftInteger = 0;

        saw_ud_suffix = true;
        return;
      }
      // JAVA: moved cleaner close to Diag
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        // Report an error if there are any.
        $c$.clean($out$Same2Bool($out_DiagnosticBuilder$C_StringRef($c$.track(PP.Diag(PP.AdvanceToTokenCharacter(/*NO_COPY*/TokLoc, SuffixBegin$Index - ThisTokBegin$Index), 
                    diag.err_invalid_suffix_constant)), 
                new StringRef($SuffixBegin(), (ThisTokEnd$Index - SuffixBegin$Index))), isFPConstant));
        hadError = true;
        return;
      } finally {
        $c$.$destroy();
      }
    }
    if (isImaginary) {
      assert NULL$INDEX != ImaginarySuffixLoc$Index;
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($c$.track(PP.Diag(PP.AdvanceToTokenCharacter(/*NO_COPY*/TokLoc, 
                (ImaginarySuffixLoc$Index - ThisTokBegin$Index)), 
            diag.ext_imaginary_constant)));
      } finally {
        $c$.$destroy();
      }
    }
  }

  public /*JBIT bool*/ boolean hadError /*: 1*/;
  public /*JBIT bool*/ boolean isUnsigned /*: 1*/;
  public /*JBIT bool*/ boolean isLong /*: 1*/; // This is *not* set for long long.
  public /*JBIT bool*/ boolean isLongLong /*: 1*/;
  public /*JBIT bool*/ boolean isHalf /*: 1*/; // 1.0h
  public /*JBIT bool*/ boolean isFloat /*: 1*/; // 1.0f
  public /*JBIT bool*/ boolean isImaginary /*: 1*/; // 1.0i
  public /*JBIT bool*/ boolean isFloat128 /*: 1*/; // 1.0q
  public byte/*uint8_t*/ MicrosoftInteger; // Microsoft suffix extension i8, i16, i32, or i64.
  
  //<editor-fold defaultstate="collapsed" desc="clang::NumericLiteralParser::isIntegerLiteral">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/LiteralSupport.h", line = 71,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/LiteralSupport.h", old_line = 68,
   FQN="clang::NumericLiteralParser::isIntegerLiteral", NM="_ZNK5clang20NumericLiteralParser16isIntegerLiteralEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/LiteralSupport.cpp -nm=_ZNK5clang20NumericLiteralParser16isIntegerLiteralEv")
  //</editor-fold>
  public boolean isIntegerLiteral() /*const*/ {
    return !saw_period && !saw_exponent;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::NumericLiteralParser::isFloatingLiteral">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/LiteralSupport.h", line = 74,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/LiteralSupport.h", old_line = 71,
   FQN="clang::NumericLiteralParser::isFloatingLiteral", NM="_ZNK5clang20NumericLiteralParser17isFloatingLiteralEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/LiteralSupport.cpp -nm=_ZNK5clang20NumericLiteralParser17isFloatingLiteralEv")
  //</editor-fold>
  public boolean isFloatingLiteral() /*const*/ {
    return saw_period || saw_exponent;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::NumericLiteralParser::hasUDSuffix">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/LiteralSupport.h", line = 78,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/LiteralSupport.h", old_line = 75,
   FQN="clang::NumericLiteralParser::hasUDSuffix", NM="_ZNK5clang20NumericLiteralParser11hasUDSuffixEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/LiteralSupport.cpp -nm=_ZNK5clang20NumericLiteralParser11hasUDSuffixEv")
  //</editor-fold>
  public boolean hasUDSuffix() /*const*/ {
    return saw_ud_suffix;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::NumericLiteralParser::getUDSuffix">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/LiteralSupport.h", line = 81,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/LiteralSupport.h", old_line = 78,
   FQN="clang::NumericLiteralParser::getUDSuffix", NM="_ZNK5clang20NumericLiteralParser11getUDSuffixEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/LiteralSupport.cpp -nm=_ZNK5clang20NumericLiteralParser11getUDSuffixEv")
  //</editor-fold>
  public StringRef getUDSuffix() /*const*/ {
    assert (saw_ud_suffix);
    return UDSuffixBuf.$StringRef();
  }

  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC, optimized = Converted.Optimization.VALUE_TYPE)
  public SmallString $getUDSuffix() /*const*/ {
    return UDSuffixBuf;
  }
  
  //<editor-fold defaultstate="collapsed" desc="clang::NumericLiteralParser::getUDSuffixOffset">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/LiteralSupport.h", line = 85,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/LiteralSupport.h", old_line = 82,
   FQN="clang::NumericLiteralParser::getUDSuffixOffset", NM="_ZNK5clang20NumericLiteralParser17getUDSuffixOffsetEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/LiteralSupport.cpp -nm=_ZNK5clang20NumericLiteralParser17getUDSuffixOffsetEv")
  //</editor-fold>
  public /*uint*/int getUDSuffixOffset() /*const*/ {
    assert (saw_ud_suffix);
    return SuffixBegin$Index - ThisTokBegin$Index;
  }

  
  
  /// Determine whether a suffix is a valid ud-suffix. We avoid treating reserved
  /// suffixes as ud-suffixes, because the diagnostic experience is better if we
  /// treat it as an invalid suffix.
  //<editor-fold defaultstate="collapsed" desc="clang::NumericLiteralParser::isValidUDSuffix">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/LiteralSupport.cpp", line = 737,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/LiteralSupport.cpp", old_line = 699,
   FQN="clang::NumericLiteralParser::isValidUDSuffix", NM="_ZN5clang20NumericLiteralParser15isValidUDSuffixERKNS_11LangOptionsEN4llvm9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/LiteralSupport.cpp -nm=_ZN5clang20NumericLiteralParser15isValidUDSuffixERKNS_11LangOptionsEN4llvm9StringRefE")
  //</editor-fold>
  public static boolean isValidUDSuffix(/*const*/ LangOptions /*&*/ LangOpts, 
          StringRef Suffix) {
    if (!LangOpts.CPlusPlus11 || Suffix.empty()) {
      return false;
    }
    
    // By C++11 [lex.ext]p10, ud-suffixes starting with an '_' are always valid.
    if (Suffix.$at(0) == $$UNDERSCORE) {
      return true;
    }
    
    // In C++11, there are no library suffixes.
    if (!LangOpts.CPlusPlus14) {
      return false;
    }
    
    // In C++1y, "s", "h", "min", "ms", "us", and "ns" are used in the library.
    // Per tweaked N3660, "il", "i", and "if" are also used in the library.
    return new StringSwitchBool(/*NO_COPY*/Suffix).
        Cases(/*KEEP_STR*/"h", /*KEEP_STR*/"min", /*KEEP_STR*/"s", true).
        Cases(/*KEEP_STR*/"ms", /*KEEP_STR*/"us", /*KEEP_STR*/"ns", true).
        Cases(/*KEEP_STR*/"il", /*KEEP_STR*/"i", /*KEEP_STR*/"if", true).
        Default(false);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::NumericLiteralParser::getRadix">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/LiteralSupport.h", line = 92,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/LiteralSupport.h", old_line = 89,
   FQN="clang::NumericLiteralParser::getRadix", NM="_ZNK5clang20NumericLiteralParser8getRadixEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/LiteralSupport.cpp -nm=_ZNK5clang20NumericLiteralParser8getRadixEv")
  //</editor-fold>
  public /*uint*/int getRadix() /*const*/ {
    return radix;
  }

  
  /// GetIntegerValue - Convert this numeric literal value to an APInt that
  /// matches Val's input width.  If there is an overflow (i.e., if the unsigned
  /// value read is larger than the APInt's bits will hold), set Val to the low
  /// bits of the result and return true.  Otherwise, return false.
  
  /// GetIntegerValue - Convert this numeric literal value to an APInt that
  /// matches Val's input width.  If there is an overflow, set Val to the low bits
  /// of the result and return true.  Otherwise, return false.
  //<editor-fold defaultstate="collapsed" desc="clang::NumericLiteralParser::GetIntegerValue">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/LiteralSupport.cpp", line = 913,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/LiteralSupport.cpp", old_line = 900,
   FQN="clang::NumericLiteralParser::GetIntegerValue", NM="_ZN5clang20NumericLiteralParser15GetIntegerValueERN4llvm5APIntE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/LiteralSupport.cpp -nm=_ZN5clang20NumericLiteralParser15GetIntegerValueERN4llvm5APIntE")
  //</editor-fold>
  public boolean GetIntegerValue(APInt /*&*/ Val) {
    // Fast path: Compute a conservative bound on the maximum number of
    // bits per digit in this radix. If we can't possibly overflow a
    // uint64 based on that bound then do the simple conversion to
    // integer. This avoids the expensive overflow checking below, and
    // handles the common cases that matter (small decimal integers and
    // hex/octal values which don't overflow).
    /*const*//*uint*/int NumDigits = SuffixBegin$Index - DigitsBegin$Index;
    if (alwaysFitsInto64Bits(radix, NumDigits)) {
      long/*uint64_t*/ N = 0;
      for (/*const*/int/*char P*/ Ptr = DigitsBegin$Index; Ptr != SuffixBegin$Index; ++Ptr)  {
        if (!isDigitSeparator(Ptr$star(Ptr))) {
          N = N * $uint2ullong(radix) + $uint2ullong(llvm.hexDigitValue(Ptr$star(Ptr)));
        }
      }

      // This will truncate the value to Val's input width. Simply check
      // for overflow by comparing.
      Val.$assign(N);
      return Val.getZExtValue() != N;
    }

    Val.$assign(0);
    /*const*/int/*char P*/ Ptr = DigitsBegin$Index;

    APInt RadixVal/*J*/= new APInt(JD$UInt_ULong.INSTANCE, Val.getBitWidth(), $uint2ulong(radix));
    APInt CharVal/*J*/= new APInt(JD$UInt_ULong.INSTANCE, Val.getBitWidth(), 0);
    APInt OldVal = new APInt(Val);

    boolean OverflowOccurred = false;
    while (Ptr < SuffixBegin$Index) {
      if (isDigitSeparator(Ptr$star(Ptr))) {
        ++Ptr;
        continue;
      }

      /*uint*/int C = llvm.hexDigitValue(Ptr$star(Ptr));++Ptr;
      
      // If this letter is out of bound for this radix, reject it.
      assert ($less_uint(C, radix)) : "NumericLiteralParser ctor should have rejected this";

      CharVal.$assign($uint2ulong(C));

      // Add the digit to the value in the appropriate radix.  If adding in digits
      // made the value smaller, then this overflowed.
      OldVal.$assign(Val);

      // Multiply by radix, did overflow occur on the multiply?
      Val.$starassign(RadixVal);
      OverflowOccurred |= Val.udiv(RadixVal).$noteq(OldVal);

      // Add value, did overflow occur on the value?
      //   (a + b) ult b  <=> overflow
      Val.$addassign(CharVal);
      OverflowOccurred |= Val.ult(CharVal);
    }
    return OverflowOccurred;
  }

  
  /// GetFloatValue - Convert this numeric literal to a floating value, using
  /// the specified APFloat fltSemantics (specifying float, double, etc).
  /// The optional bool isExact (passed-by-reference) has its value
  /// set to true if the returned APFloat can represent the number in the
  /// literal exactly, and false otherwise.
  //<editor-fold defaultstate="collapsed" desc="clang::NumericLiteralParser::GetFloatValue">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/LiteralSupport.cpp", line = 970,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/LiteralSupport.cpp", old_line = 957,
   FQN="clang::NumericLiteralParser::GetFloatValue", NM="_ZN5clang20NumericLiteralParser13GetFloatValueERN4llvm7APFloatE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/LiteralSupport.cpp -nm=_ZN5clang20NumericLiteralParser13GetFloatValueERN4llvm7APFloatE")
  //</editor-fold>
  public /*APFloat::opStatus*//*uint*/int GetFloatValue(APFloat /*&*/ Result) {
    //JAVA: using llvm::APFloat;
    
    /*uint*/int n = std.min(SuffixBegin$Index - ThisTokBegin$Index, ThisTokEnd$Index - ThisTokBegin$Index);
    
    SmallString/*16*/ Buffer/*J*/= new SmallString/*16*/(16);
    StringRef Str/*J*/= new StringRef(ThisTokBegin, n);
    if (Str.find($$SGL_QUOTE) != StringRef.npos) {
      Buffer.reserve(n);
      std.<back_insert_iteratorChar>remove_copy_if(Str.begin(), Str.end(), std.back_inserter(Buffer), 
          /*AddrOf*/ NumericLiteralParser::isDigitSeparator);
      Str.$assignMove(Buffer.$StringRef());
    }
    
    return Result.convertFromString(/*NO_COPY*/Str, APFloat.roundingMode.rmNearestTiesToEven);
  }
  
/*private:*/


  /// ParseNumberStartingWithZero - This method is called when the first character
  /// of the number is found to be a zero.  This means it is either an octal
  /// number (like '04') or a hex number ('0x123a') a binary number ('0b1010') or
  /// a floating point number (01239.123e4).  Eat the prefix, determining the
  /// radix etc.
  //<editor-fold defaultstate="collapsed" desc="clang::NumericLiteralParser::ParseNumberStartingWithZero">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/LiteralSupport.cpp", line = 780,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/LiteralSupport.cpp", old_line = 742,
   FQN="clang::NumericLiteralParser::ParseNumberStartingWithZero", NM="_ZN5clang20NumericLiteralParser27ParseNumberStartingWithZeroENS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/LiteralSupport.cpp -nm=_ZN5clang20NumericLiteralParser27ParseNumberStartingWithZeroENS_14SourceLocationE")
  //</editor-fold>
  private void ParseNumberStartingWithZero(/*SourceLocation*/int TokLoc) {
    assert (s.$at(0) == $$0) : "Invalid method call";
    s.$preInc();
    
    byte c1 = s.$at(0);
    byte c2; // JAVA FIX: not safe to init here, because can be after-of-eof (test_eof_number_c)

    // Handle a hex number like 0x1234.
    if ((c1 == $$x || c1 == $$X) && (isHexDigit(/*JAVA init c2*/c2 = s.$at(1)) || c2 == $$DOT)) {
      s.$preInc();
      assert (s.$index() < (ThisTokEnd$Index)) : "didn't maximally munch?";
      radix = 16;
      DigitsBegin$Index = s.$index();
      /*char*/byte DigitsBegin$at0 = c2; // for containsDigits
      assert DigitsBegin$at0 == s.$at(0);
      s = $noClone(SkipHexDigits(s));
      boolean HasSignificandDigits = containsDigits(DigitsBegin$Index, s.$index(), DigitsBegin$at0);
      if (s.$index() == ThisTokEnd$Index) {
        // Done.
      } else if (s.$star() == $$DOT) {
        s.$preInc();
        saw_period = true;
        /*const*/int/*char P*/ floatDigitsBegin$Index = s.$index();
        /*char*/byte floatDigitsBegin$at0 = s.$star(); // for containsDigits
        assert $$DOT == s.$at(-1) : "Expected . to be seen before s.$preInc above but got " + $uchar2ushort(s.$at(-1));
        s = $noClone(SkipHexDigits(s));
        if (containsDigits(floatDigitsBegin$Index, s.$index(), floatDigitsBegin$at0)) {
          HasSignificandDigits = true;
        }
        if (HasSignificandDigits) {
          // JAVA: unfold
          int s$index = s.$index();
          /*const*/char$ptr/*char P*/ floatDigitsBegin = (s);
          $setIndex(floatDigitsBegin, floatDigitsBegin$Index);
          checkSeparator(/*NO_COPY*/TokLoc, floatDigitsBegin, CheckSeparatorKind.CSK_BeforeDigits);
          $setIndex(floatDigitsBegin, s$index);
          assert s == floatDigitsBegin : "must be the same pointers";
          assert s.$index() == s$index : "must be the same indices";
        }
      }
      if (!HasSignificandDigits) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_DiagnosticBuilder$C_int($out_DiagnosticBuilder$C_uint($c$.track(PP.Diag(PP.AdvanceToTokenCharacter(/*NO_COPY*/TokLoc, s.$sub(ThisTokBegin)), 
                      diag.err_hex_constant_requires)), 
                  PP.getLangOpts().CPlusPlus), 1));
          hadError = true;
          return;
        } finally {
          $c$.$destroy();
        }
      }
      
      // A binary exponent can appear with or with a '.'. If dotted, the
      // binary exponent is required.
      if (s.$star() == $$p || s.$star() == $$P) {
        checkSeparator(/*NO_COPY*/TokLoc, s, CheckSeparatorKind.CSK_AfterDigits);
        /*const*/int/*char P*/ Exponent$Index = s.$index();
        s.$preInc();
        saw_exponent = true;
        if (s.$star() == $$PLUS || s.$star() == $$MINUS) {
          s.$preInc(); // sign
        }
        // JAVA PERF: instead of extra clone use indices
        int s$index = s.$index();
        /*char*/byte s$at0 = s.$at(0);
        /*const*/char$ptr/*char P*/ first_non_digit = $noClone(SkipDigits(s));
        assert first_non_digit == s : "we used SkipDigits above which reuse pointer";
        int first_non_digit$index = first_non_digit.$index();
        if (!containsDigits(s$index, first_non_digit$index, s$at0)) {
          $setIndex(s, s$index);
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            $c$.clean($c$.track(PP.Diag(PP.AdvanceToTokenCharacter(/*NO_COPY*/TokLoc, (Exponent$Index - ThisTokBegin$Index)), 
                diag.err_exponent_has_no_digits)));
            hadError = true;
            return;
          } finally {
            $c$.$destroy();
          }
        }       
        // JAVA: restore index which could be moved by SkipDigits above
        $setIndex(s, s$index);
        checkSeparator(/*NO_COPY*/TokLoc, s, CheckSeparatorKind.CSK_BeforeDigits);
        // JAVA: replaced s = $tryClone(first_non_digit);
        $setIndex(s, first_non_digit$index);
        if (!PP.getLangOpts().HexFloats) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            $c$.clean($c$.track(PP.Diag(/*NO_COPY*/TokLoc, PP.getLangOpts().CPlusPlus ? diag.ext_hex_literal_invalid : diag.ext_hex_constant_invalid)));
          } finally {
            $c$.$destroy();
          }
        } else if (PP.getLangOpts().CPlusPlus1z) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            $c$.clean($c$.track(PP.Diag(/*NO_COPY*/TokLoc, diag.warn_cxx1z_hex_literal)));
          } finally {
            $c$.$destroy();
          }
        }
      } else if (saw_period) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_DiagnosticBuilder$C_int($out_DiagnosticBuilder$C_uint($c$.track(PP.Diag(PP.AdvanceToTokenCharacter(/*NO_COPY*/TokLoc, s.$sub(ThisTokBegin)), 
                      diag.err_hex_constant_requires)), 
                  PP.getLangOpts().CPlusPlus), 0));
          hadError = true;
        } finally {
          $c$.$destroy();
        }
      }
      return;
    }
    
    // Handle simple binary numbers 0b01010
    if ((c1 == $$b || c1 == $$B) && (s.$at(1) == $$0 || s.$at(1) == $$1)) {
//      JAVA: removed cleaner, because not all branches set hadError state to 'true'      
//      JavaCleaner $c$ = $createJavaCleaner();
//      try {
      // 0b101010 is a C++1y / GCC extension.
      PP.Diag(/*NO_COPY*/TokLoc, 
          PP.getLangOpts().CPlusPlus14 ? diag.warn_cxx11_compat_binary_literal : PP.getLangOpts().CPlusPlus ? diag.ext_binary_literal_cxx14 : diag.ext_binary_literal).$destroy();
      s.$preInc();
      assert (s.$index() < (ThisTokEnd$Index)) : "didn't maximally munch?";
      radix = 2;
      DigitsBegin$Index = s.$index();
      s = $noClone(SkipBinaryDigits(s));
      if (s.$index() == ThisTokEnd$Index) {
        // Done.
      } else if (isHexDigit(s.$star())) {
        $out_DiagnosticBuilder$C_int($out_DiagnosticBuilder$C_StringRef(PP.Diag(PP.AdvanceToTokenCharacter(TokLoc, s.$sub(ThisTokBegin)),
                diag.err_invalid_digit), new StringRef(s, 1)), 2).$destroy();
        hadError = true;
      }
      // Other suffixes will be diagnosed by the caller.
      return;
    }
    
    // For now, the radix is set to 8. If we discover that we have a
    // floating point constant, the radix will change to 10. Octal floating
    // point constants are not permitted (only decimal and hexadecimal).
    radix = 8;
    DigitsBegin$Index = s.$index();
    s = $noClone(SkipOctalDigits(s));
    if (s.$index() == ThisTokEnd$Index) {
      return; // Done, simple octal number like 01234
    }
    
    // If we have some other non-octal digit that *is* a decimal digit, see if
    // this is part of a floating point number like 094.123 or 09e1.
    if (isDigit(s.$star())) {
      // JAVA PERF: instead of clone use indices
      int s$index = s.$index();
      /*const*/char$ptr/*char P*/ EndDecimal = $noClone(SkipDigits(s));
      assert s == EndDecimal : "we used SkipDigits above which reuse pointer";
      if (EndDecimal.$at(0) == $$DOT || EndDecimal.$at(0) == $$e || EndDecimal.$at(0) == $$E) {
        s = $noClone(EndDecimal);
        radix = 10;
      } else {
        // JAVA: restore back to original index, because could be shifted by SkipDigits above
        $setIndex(s, s$index);
      }
    }
    
    ParseDecimalOrOctalCommon(TokLoc);
  }

  
  /// ParseDecimalOrOctalCommon - This method is called for decimal or octal
  /// numbers. It issues an error for illegal digits, and handles floating point
  /// parsing. If it detects a floating point number, the radix is set to 10.
  //<editor-fold defaultstate="collapsed" desc="clang::NumericLiteralParser::ParseDecimalOrOctalCommon">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC, optimized = Converted.Optimization.VALUE_TYPE,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/LiteralSupport.cpp", line = 694,
   FQN="clang::NumericLiteralParser::ParseDecimalOrOctalCommon", NM="_ZN5clang20NumericLiteralParser25ParseDecimalOrOctalCommonENS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/LiteralSupport.cpp -nm=_ZN5clang20NumericLiteralParser25ParseDecimalOrOctalCommonENS_14SourceLocationE")
  //</editor-fold>
  private void ParseDecimalOrOctalCommon(/*SourceLocation*/int TokLoc) {
    assert ((radix == 8 || radix == 10)) : "Unexpected radix";
    
    // If we have a hex digit other than 'e' (which denotes a FP exponent) then
    // the code is using an incorrect base.
    if (isHexDigit(s.$star()) && s.$star() != $$e && s.$star() != $$E) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_DiagnosticBuilder$C_int($out_DiagnosticBuilder$C_StringRef($c$.track(PP.Diag(PP.AdvanceToTokenCharacter(/*NO_COPY*/TokLoc, s.$sub(ThisTokBegin)), 
                    diag.err_invalid_digit)), new StringRef(s, 1)), (radix == 8 ? 1 : 0)));
      hadError = true;
      return;
      } finally {
        $c$.$destroy();
      }
    }
    if (s.$star() == $$DOT) {
      checkSeparator(/*NO_COPY*/TokLoc, s, CheckSeparatorKind.CSK_AfterDigits);
      s.$preInc();
      radix = 10;
      saw_period = true;
      checkSeparator(/*NO_COPY*/TokLoc, s, CheckSeparatorKind.CSK_BeforeDigits);
      s = $noClone(SkipDigits(s)); // Skip suffix.
    }
    if (s.$star() == $$e || s.$star() == $$E) { // exponent
      checkSeparator(/*NO_COPY*/TokLoc, s, CheckSeparatorKind.CSK_AfterDigits);
      /*const*/int/*char P*/ Exponent$Index = s.$index();
      s.$preInc();
      radix = 10;
      saw_exponent = true;
      if (s.$star() == $$PLUS || s.$star() == $$MINUS) {
        s.$preInc(); // sign
      }
      // JAVA PERF: instead of extra clone use indices
      int s$index = s.$index();
      /*char*/byte s$at0 = s.$at(0); // JAVA: for containsDigits
      /*const*/char$ptr/*char P*/ first_non_digit = $noClone(SkipDigits(s));
      assert first_non_digit == s : "we used SkipDigits above which reuse pointer";
      int first_non_digit$index = first_non_digit.$index();
      if (containsDigits(s$index, first_non_digit$index, s$at0)) {
        $setIndex(s, s$index);
        checkSeparator(/*NO_COPY*/TokLoc, s, CheckSeparatorKind.CSK_BeforeDigits);
        $setIndex(s, first_non_digit$index);
      } else {
        $setIndex(s, s$index);
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($c$.track(PP.Diag(PP.AdvanceToTokenCharacter(/*NO_COPY*/TokLoc, Exponent$Index - ThisTokBegin$Index), 
              diag.err_exponent_has_no_digits)));
          hadError = true;
          return;
        } finally {
          $c$.$destroy();
        }
      }
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::NumericLiteralParser::isDigitSeparator">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/LiteralSupport.h", line = 112,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/LiteralSupport.h", old_line = 108,
   FQN="clang::NumericLiteralParser::isDigitSeparator", NM="_ZN5clang20NumericLiteralParser16isDigitSeparatorEc",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/LiteralSupport.cpp -nm=_ZN5clang20NumericLiteralParser16isDigitSeparatorEc")
  //</editor-fold>
  private static boolean isDigitSeparator(/*char*/byte C) {
    return C == $$SGL_QUOTE;
  }

  
  /// \brief Determine whether the sequence of characters [Start, End) contains
  /// any real digits (not digit separators).
  //<editor-fold defaultstate="collapsed" desc="clang::NumericLiteralParser::containsDigits">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/LiteralSupport.h", line = 116,
   FQN="clang::NumericLiteralParser::containsDigits", NM="_ZN5clang20NumericLiteralParser14containsDigitsEPKcS2_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/LiteralSupport.cpp -nm=_ZN5clang20NumericLiteralParser14containsDigitsEPKcS2_")
  //</editor-fold>
  private boolean containsDigits(/*const char P*/int Start$Index, /*const char P*/int End$Index, /*char*/byte Start$at0) {
    return (Start$Index != End$Index) && ((Start$Index + 1 != End$Index) || !isDigitSeparator(Start$at0));
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::NumericLiteralParser::CheckSeparatorKind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/LiteralSupport.h", line = 120,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/LiteralSupport.h", old_line = 110,
   FQN="clang::NumericLiteralParser::CheckSeparatorKind", NM="_ZN5clang20NumericLiteralParser18CheckSeparatorKindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/LiteralSupport.cpp -nm=_ZN5clang20NumericLiteralParser18CheckSeparatorKindE")
  //</editor-fold>
  private enum CheckSeparatorKind implements Native.ComparableLower {
    CSK_BeforeDigits(0),
    CSK_AfterDigits(CSK_BeforeDigits.getValue() + 1);

    //<editor-fold defaultstate="collapsed" desc="hidden">
    public static CheckSeparatorKind valueOf(int val) {
      CheckSeparatorKind out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
      assert out != null : "no value for " + val;
      assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
      return out;
    }

    private static final class Values {
      private static final CheckSeparatorKind[] VALUES;
      private static final CheckSeparatorKind[] _VALUES; // [0] not used
      static {
        int max = 0;
        int min = 0;
        for (CheckSeparatorKind kind : CheckSeparatorKind.values()) {
          if (kind.value > max) { max = kind.value; }
          if (kind.value < min) { min = kind.value; }
        }
        _VALUES = new CheckSeparatorKind[min < 0 ? (1-min) : 0];
        VALUES = new CheckSeparatorKind[max >= 0 ? (1+max) : 0];
        for (CheckSeparatorKind kind : CheckSeparatorKind.values()) {
          if (kind.value < 0) {
            _VALUES[-kind.value] = kind;
          } else {
            VALUES[kind.value] = kind;
          }
        }
      }
    }

    private final /*uint*/int value;
    private CheckSeparatorKind(int val) { this.value = (/*uint*/int)val;}
    public /*uint*/int getValue() { return value;}
    @Override public boolean $less(Object obj) { return Unsigned.$less_uint(value, ((CheckSeparatorKind)obj).value);}
    @Override public boolean $lesseq(Object obj) { return Unsigned.$lesseq_uint(value, ((CheckSeparatorKind)obj).value);}
    //</editor-fold>
  };
  
  /// \brief Ensure that we don't have a digit separator here.
  //<editor-fold defaultstate="collapsed" desc="clang::NumericLiteralParser::checkSeparator">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/LiteralSupport.cpp", line = 759,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/LiteralSupport.cpp", old_line = 721,
   FQN="clang::NumericLiteralParser::checkSeparator", NM="_ZN5clang20NumericLiteralParser14checkSeparatorENS_14SourceLocationEPKcNS0_18CheckSeparatorKindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/LiteralSupport.cpp -nm=_ZN5clang20NumericLiteralParser14checkSeparatorENS_14SourceLocationEPKcNS0_18CheckSeparatorKindE")
  //</editor-fold>
  private void checkSeparator(/*SourceLocation*/int TokLoc, 
          /*const*/char$ptr/*char P*/ Pos, 
          CheckSeparatorKind IsAfterDigits) {
    int $PosDecremented = 0;
    if (IsAfterDigits == CheckSeparatorKind.CSK_AfterDigits) {
      if (Pos.$index() == ThisTokBegin$Index) {
        return;
      }
      $PosDecremented--;
    } else if (Pos.$index() == ThisTokEnd$Index) {
      return;
    }
    if (isDigitSeparator(Pos.$at($PosDecremented))) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_DiagnosticBuilder$C_int($c$.track(PP.Diag(PP.AdvanceToTokenCharacter(/*NO_COPY*/TokLoc, $PosDecremented + Pos.$sub(ThisTokBegin)), 
                diag.err_digit_separator_not_between_digits)), 
            IsAfterDigits.getValue()));
      } finally {
        $c$.$destroy();
      }
    }
  }

  
  /// SkipHexDigits - Read and skip over any hex digits, up to End.
  /// Return a pointer to the first non-hex digit or End.
  //<editor-fold defaultstate="collapsed" desc="clang::NumericLiteralParser::SkipHexDigits">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC, optimized = Converted.Optimization.VALUE_TYPE,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/LiteralSupport.h", line = 128,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/LiteralSupport.h", old_line = 118,
   FQN="clang::NumericLiteralParser::SkipHexDigits", NM="_ZN5clang20NumericLiteralParser13SkipHexDigitsEPKc",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/LiteralSupport.cpp -nm=_ZN5clang20NumericLiteralParser13SkipHexDigitsEPKc")
  //</editor-fold>
  private /*const*/char$ptr/*char P*/ SkipHexDigits(/*const*/char$ptr/*char P*/ ptr) {
    // JAVA: don't clone, because return value is the same as input param
    ptr = $noClone(ptr);
    /*char*/byte ptr$star; // try to call once ptr.$star()
    while ((ptr.$index() != ThisTokEnd$Index) && (isHexDigit((ptr$star = ptr.$star())) || isDigitSeparator(ptr$star))) {
      ptr.$preInc();
    }
    return ptr;
  }

  
  /// SkipOctalDigits - Read and skip over any octal digits, up to End.
  /// Return a pointer to the first non-hex digit or End.
  //<editor-fold defaultstate="collapsed" desc="clang::NumericLiteralParser::SkipOctalDigits">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC, optimized = Converted.Optimization.VALUE_TYPE,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/LiteralSupport.h", line = 136,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/LiteralSupport.h", old_line = 126,
   FQN="clang::NumericLiteralParser::SkipOctalDigits", NM="_ZN5clang20NumericLiteralParser15SkipOctalDigitsEPKc",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/LiteralSupport.cpp -nm=_ZN5clang20NumericLiteralParser15SkipOctalDigitsEPKc")
  //</editor-fold>
  private /*const*/char$ptr/*char P*/ SkipOctalDigits(/*const*/char$ptr/*char P*/ ptr) {
    // JAVA PERF: don't clone, because return value is the same as input param
    ptr = $noClone(ptr);
    /*char*/byte ptr$star; // try to call once ptr.$star()
    while ((ptr.$index() != ThisTokEnd$Index) 
            && (((ptr$star = ptr.$star()) >= $$0 && ptr$star <= $$7) || isDigitSeparator(ptr$star))) {
      ptr.$preInc();
    }
    return ptr;
  }

  
  /// SkipDigits - Read and skip over any digits, up to End.
  /// Return a pointer to the first non-hex digit or End.
  //<editor-fold defaultstate="collapsed" desc="clang::NumericLiteralParser::SkipDigits">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC, optimized = Converted.Optimization.VALUE_TYPE,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/LiteralSupport.h", line = 145,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/LiteralSupport.h", old_line = 135,
   FQN="clang::NumericLiteralParser::SkipDigits", NM="_ZN5clang20NumericLiteralParser10SkipDigitsEPKc",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/LiteralSupport.cpp -nm=_ZN5clang20NumericLiteralParser10SkipDigitsEPKc")
  //</editor-fold>
  private /*const*/char$ptr/*char P*/ SkipDigits(/*const*/char$ptr/*char P*/ ptr) {
    // PERF: no cloning, changed callers
    ptr = $noClone(ptr);
    /*char*/byte ptr$star; // try to call once ptr.$star()
    while ((ptr.$index() != ThisTokEnd$Index) && (isDigit((ptr$star = ptr.$star())) || isDigitSeparator(ptr$star))) {
      ptr.$preInc();
    }
    return ptr;
  }

  
  /// SkipBinaryDigits - Read and skip over any binary digits, up to End.
  /// Return a pointer to the first non-binary digit or End.
  //<editor-fold defaultstate="collapsed" desc="clang::NumericLiteralParser::SkipBinaryDigits">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC, optimized = Converted.Optimization.VALUE_TYPE,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/LiteralSupport.h", line = 153,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/LiteralSupport.h", old_line = 143,
   FQN="clang::NumericLiteralParser::SkipBinaryDigits", NM="_ZN5clang20NumericLiteralParser16SkipBinaryDigitsEPKc",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/LiteralSupport.cpp -nm=_ZN5clang20NumericLiteralParser16SkipBinaryDigitsEPKc")
  //</editor-fold>
  private /*const*/char$ptr/*char P*/ SkipBinaryDigits(/*const*/char$ptr/*char P*/ ptr) {
    // JAVA PERF: don't clone, because return value is the same as input param
    ptr = $noClone(ptr);
    /*char*/byte ptr$star; // try to call once ptr.$star()
    while ((ptr.$index() != ThisTokEnd$Index) && ((ptr$star = ptr.$star()) == $$0 || ptr$star == $$1 || isDigitSeparator(ptr$star))) {
      ptr.$preInc();
    }
    return ptr;
  }


  //<editor-fold defaultstate="collapsed" desc="clang::NumericLiteralParser::~NumericLiteralParser">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/LiteralSupport.h", line = 43,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/LiteralSupport.h", old_line = 42,
   FQN="clang::NumericLiteralParser::~NumericLiteralParser", NM="_ZN5clang20NumericLiteralParserD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp -nm=_ZN5clang20NumericLiteralParserD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    //START JDestroy
    UDSuffixBuf.$destroy();
    //END JDestroy
  }

  //<editor-fold defaultstate="collapsed" desc="clang::NumericLiteralParser::NumericLiteralParser">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/LiteralSupport.h", line = 43,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/LiteralSupport.h", old_line = 42,
   FQN="clang::NumericLiteralParser::NumericLiteralParser", NM="_ZN5clang20NumericLiteralParserC1ERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/LiteralSupport.cpp -nm=_ZN5clang20NumericLiteralParserC1ERKS0_")
  //</editor-fold>
  public /*inline*/ NumericLiteralParser(/*const*/ NumericLiteralParser /*&*/ $Prm0) {
    /*<<<default copy constructor: may be there is another TU where objects are copied?>>>*/
    // memcpy(this, $1, sizeof($1));
    throw new UnsupportedOperationException();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::NumericLiteralParser::NumericLiteralParser">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/LiteralSupport.h", line = 43,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/LiteralSupport.h", old_line = 42,
   FQN="clang::NumericLiteralParser::NumericLiteralParser", NM="_ZN5clang20NumericLiteralParserC1EOS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/LiteralSupport.cpp -nm=_ZN5clang20NumericLiteralParserC1EOS0_")
  //</editor-fold>
  public /*inline*/ NumericLiteralParser(JD$Move _dparam, NumericLiteralParser /*&&*/$Prm0) {
    /*<<<default copy constructor: may be there is another TU where objects are copied?>>>*/
    // memcpy(this, $1, sizeof($1));
    throw new UnsupportedOperationException();
  }

  public String toString() {
    return "" /* STACKOVERFLOW: NEVER PRINT Preprocessor + ", PP=" + PP // NOI18N */
              + ", ThisTokBegin=" + ThisTokBegin // NOI18N
              + ", ThisTokEnd=" + ThisTokEnd$Index // NOI18N
              + ", DigitsBegin=" + DigitsBegin$Index // NOI18N
              + ", SuffixBegin=" + SuffixBegin$Index // NOI18N
              + ", s=" + s // NOI18N
              + ", radix=" + radix // NOI18N
              + ", saw_exponent=" + saw_exponent // NOI18N
              + ", saw_period=" + saw_period // NOI18N
              + ", saw_ud_suffix=" + saw_ud_suffix // NOI18N
              + ", UDSuffixBuf=" + UDSuffixBuf // NOI18N
              + ", hadError=" + hadError // NOI18N
              + ", isUnsigned=" + isUnsigned // NOI18N
              + ", isLong=" + isLong // NOI18N
              + ", isLongLong=" + isLongLong // NOI18N
              + ", isHalf=" + isHalf // NOI18N
              + ", isFloat=" + isFloat // NOI18N
              + ", isImaginary=" + isImaginary // NOI18N
              + ", isFloat128=" + isFloat128 // NOI18N
              + ", MicrosoftInteger=" + $uchar2uint(MicrosoftInteger); // NOI18N
  }
  
  private char$ptr $SuffixBegin() {
    int shift = SuffixBegin$Index-ThisTokBegin$Index;
    return shift == 0 ? ThisTokBegin : ThisTokBegin.$add(shift);
  }
  
  private byte Ptr$star(int PtrIndex) {
    return ThisTokBegin.$at(PtrIndex - ThisTokBegin$Index);
  }
}
