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
package org.llvm.support.impl;

import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.llvm.adt.*;


//<editor-fold defaultstate="collapsed" desc="static type YAMLParserStatics">
@Converted(kind = Converted.Kind.AUTO,
 NM="org.llvm.support.impl.YAMLParserStatics",
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/YAMLParser.cpp -nm=_ZL10decodeUTF8N4llvm9StringRefE;_ZL10encodeUTF8jRN4llvm15SmallVectorImplIcEE;_ZL10wasEscapedPKcS0_;_ZL15is_ns_hex_digitc;_ZL15is_ns_word_charc;_ZL18getUnicodeEncodingN4llvm9StringRefE;_ZL20getChompedLineBreakscjN4llvm9StringRefE; -static-type=YAMLParserStatics -package=org.llvm.support.impl")
//</editor-fold>
public final class YAMLParserStatics {


/// getUnicodeEncoding - Reads up to the first 4 bytes to determine the Unicode
///                      encoding form of \a Input.
///
/// @param Input A string of length 0 or more.
/// @returns An EncodingInfo indicating the Unicode encoding form of the input
///          and how long the byte order mark is if one exists.
//<editor-fold defaultstate="collapsed" desc="getUnicodeEncoding">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*make_pair*/,
 source = "${LLVM_SRC}/llvm/lib/Support/YAMLParser.cpp", line = 48,
 FQN="getUnicodeEncoding", NM="_ZL18getUnicodeEncodingN4llvm9StringRefE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/YAMLParser.cpp -nm=_ZL18getUnicodeEncodingN4llvm9StringRefE")
//</editor-fold>
public static std.pairTypeUInt<UnicodeEncodingForm> getUnicodeEncoding(StringRef Input) {
  if (Input.size() == 0) {
    return std.make_pair_E_int2uint(UnicodeEncodingForm.UEF_Unknown, 0);
  }
  switch ($uchar2int(((byte/*uint8_t*/)(Input.$at(0))))) {
   case 0x00:
    if ($greatereq_uint(Input.size(), 4)) {
      if (Input.$at(1) == 0
         && $uchar2int(((byte/*uint8_t*/)(Input.$at(2)))) == 0xFE
         && $uchar2int(((byte/*uint8_t*/)(Input.$at(3)))) == 0xFF) {
        return std.make_pair_E_int2uint(UnicodeEncodingForm.UEF_UTF32_BE, 4);
      }
      if (Input.$at(1) == 0 && Input.$at(2) == 0 && Input.$at(3) != 0) {
        return std.make_pair_E_int2uint(UnicodeEncodingForm.UEF_UTF32_BE, 0);
      }
    }
    if ($greatereq_uint(Input.size(), 2) && Input.$at(1) != 0) {
      return std.make_pair_E_int2uint(UnicodeEncodingForm.UEF_UTF16_BE, 0);
    }
    return std.make_pair_E_int2uint(UnicodeEncodingForm.UEF_Unknown, 0);
   case 0xFF:
    if ($greatereq_uint(Input.size(), 4)
       && $uchar2int(((byte/*uint8_t*/)(Input.$at(1)))) == 0xFE
       && Input.$at(2) == 0
       && Input.$at(3) == 0) {
      return std.make_pair_E_int2uint(UnicodeEncodingForm.UEF_UTF32_LE, 4);
    }
    if ($greatereq_uint(Input.size(), 2) && $uchar2int(((byte/*uint8_t*/)(Input.$at(1)))) == 0xFE) {
      return std.make_pair_E_int2uint(UnicodeEncodingForm.UEF_UTF16_LE, 2);
    }
    return std.make_pair_E_int2uint(UnicodeEncodingForm.UEF_Unknown, 0);
   case 0xFE:
    if ($greatereq_uint(Input.size(), 2) && $uchar2int(((byte/*uint8_t*/)(Input.$at(1)))) == 0xFF) {
      return std.make_pair_E_int2uint(UnicodeEncodingForm.UEF_UTF16_BE, 2);
    }
    return std.make_pair_E_int2uint(UnicodeEncodingForm.UEF_Unknown, 0);
   case 0xEF:
    if ($greatereq_uint(Input.size(), 3)
       && $uchar2int(((byte/*uint8_t*/)(Input.$at(1)))) == 0xBB
       && $uchar2int(((byte/*uint8_t*/)(Input.$at(2)))) == 0xBF) {
      return std.make_pair_E_int2uint(UnicodeEncodingForm.UEF_UTF8, 3);
    }
    return std.make_pair_E_int2uint(UnicodeEncodingForm.UEF_Unknown, 0);
  }
  
  // It could still be utf-32 or utf-16.
  if ($greatereq_uint(Input.size(), 4) && Input.$at(1) == 0 && Input.$at(2) == 0 && Input.$at(3) == 0) {
    return std.make_pair_E_int2uint(UnicodeEncodingForm.UEF_UTF32_LE, 0);
  }
  if ($greatereq_uint(Input.size(), 2) && Input.$at(1) == 0) {
    return std.make_pair_E_int2uint(UnicodeEncodingForm.UEF_UTF16_LE, 0);
  }
  
  return std.make_pair_E_int2uint(UnicodeEncodingForm.UEF_UTF8, 0);
}

//<editor-fold defaultstate="collapsed" desc="decodeUTF8">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*make_pair and other*/,
 source = "${LLVM_SRC}/llvm/lib/Support/YAMLParser.cpp", line = 213,
 FQN="decodeUTF8", NM="_ZL10decodeUTF8N4llvm9StringRefE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/YAMLParser.cpp -nm=_ZL10decodeUTF8N4llvm9StringRefE")
//</editor-fold>
public static std.pairUIntUInt decodeUTF8(StringRef Range) {
  char$ptr Position = $tryClone(Range.begin());
  char$ptr End = $tryClone(Range.end());
  // 1 byte: [0x00, 0x7f]
  // Bit pattern: 0xxxxxxx
  if ((Position.$star() & 0x80) == 0) {
    return std.make_pair_int2uint_int2uint(0xFF & Position.$star(), 1);
  }
  // 2 bytes: [0x80, 0x7ff]
  // Bit pattern: 110xxxxx 10xxxxxx
  if ($noteq_ptr(Position.$add(1), End)
     && ((Position.$star() & 0xE0) == 0xC0)
     && (((Position.$add(1)).$star() & 0xC0) == 0x80)) {
    /*uint32_t*/int codepoint = ((Position.$star() & 0x1F) << 6)
       | ((Position.$add(1)).$star() & 0x3F);
    if ($greatereq_uint(codepoint, 0x80)) {
      return std.make_pair_uint_int2uint(codepoint, 2);
    }
  }
  // 3 bytes: [0x8000, 0xffff]
  // Bit pattern: 1110xxxx 10xxxxxx 10xxxxxx
  if ($noteq_ptr(Position.$add(2), End)
     && ((Position.$star() & 0xF0) == 0xE0)
     && (((Position.$add(1)).$star() & 0xC0) == 0x80)
     && (((Position.$add(2)).$star() & 0xC0) == 0x80)) {
    /*uint32_t*/int codepoint = ((Position.$star() & 0x0F) << 12)
       | (((Position.$add(1)).$star() & 0x3F) << 6)
       | ((Position.$add(2)).$star() & 0x3F);
    // Codepoints between 0xD800 and 0xDFFF are invalid, as
    // they are high / low surrogate halves used by UTF-16.
    if ($greatereq_uint(codepoint, 0x800)
       && ($less_uint(codepoint, 0xD800) || $greater_uint(codepoint, 0xDFFF))) {
      return std.make_pair_uint_int2uint(codepoint, 3);
    }
  }
  // 4 bytes: [0x10000, 0x10FFFF]
  // Bit pattern: 11110xxx 10xxxxxx 10xxxxxx 10xxxxxx
  if ($noteq_ptr(Position.$add(3), End)
     && ((Position.$star() & 0xF8) == 0xF0)
     && (((Position.$add(1)).$star() & 0xC0) == 0x80)
     && (((Position.$add(2)).$star() & 0xC0) == 0x80)
     && (((Position.$add(3)).$star() & 0xC0) == 0x80)) {
    /*uint32_t*/int codepoint = ((Position.$star() & 0x07) << 18)
       | (((Position.$add(1)).$star() & 0x3F) << 12)
       | (((Position.$add(2)).$star() & 0x3F) << 6)
       | ((Position.$add(3)).$star() & 0x3F);
    if ($greatereq_uint(codepoint, 0x10000) && $lesseq_uint(codepoint, 0x10FFFF)) {
      return std.make_pair_uint_int2uint(codepoint, 4);
    }
  }
  return std.make_pair_int2uint_int2uint(0, 0);
}

// end namespace llvm

/// encodeUTF8 - Encode \a UnicodeScalarValue in UTF-8 and append it to result.
//<editor-fold defaultstate="collapsed" desc="encodeUTF8">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/Support/YAMLParser.cpp", line = 573,
 FQN="encodeUTF8", NM="_ZL10encodeUTF8jRN4llvm15SmallVectorImplIcEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/YAMLParser.cpp -nm=_ZL10encodeUTF8jRN4llvm15SmallVectorImplIcEE")
//</editor-fold>
public static void encodeUTF8(/*uint32_t*/int UnicodeScalarValue, 
          final SmallString/*&*/ Result) {
  if ($lesseq_uint(UnicodeScalarValue, 0x7F)) {
    Result.push_back($uint2char(UnicodeScalarValue & 0x7F));
  } else if ($lesseq_uint(UnicodeScalarValue, 0x7FF)) {
    byte/*uint8_t*/ FirstByte = $uint2uchar(0xC0 | ((UnicodeScalarValue & 0x7C0) >>> 6));
    byte/*uint8_t*/ SecondByte = $uint2uchar(0x80 | (UnicodeScalarValue & 0x3F));
    Result.push_back(FirstByte);
    Result.push_back(SecondByte);
  } else if ($lesseq_uint(UnicodeScalarValue, 0xFFFF)) {
    byte/*uint8_t*/ FirstByte = $uint2uchar(0xE0 | ((UnicodeScalarValue & 0xF000) >>> 12));
    byte/*uint8_t*/ SecondByte = $uint2uchar(0x80 | ((UnicodeScalarValue & 0xFC0) >>> 6));
    byte/*uint8_t*/ ThirdByte = $uint2uchar(0x80 | (UnicodeScalarValue & 0x3F));
    Result.push_back(FirstByte);
    Result.push_back(SecondByte);
    Result.push_back(ThirdByte);
  } else if ($lesseq_uint(UnicodeScalarValue, 0x10FFFF)) {
    byte/*uint8_t*/ FirstByte = $uint2uchar(0xF0 | ((UnicodeScalarValue & 0x1F0000) >>> 18));
    byte/*uint8_t*/ SecondByte = $uint2uchar(0x80 | ((UnicodeScalarValue & 0x3F000) >>> 12));
    byte/*uint8_t*/ ThirdByte = $uint2uchar(0x80 | ((UnicodeScalarValue & 0xFC0) >>> 6));
    byte/*uint8_t*/ FourthByte = $uint2uchar(0x80 | (UnicodeScalarValue & 0x3F));
    Result.push_back(FirstByte);
    Result.push_back(SecondByte);
    Result.push_back(ThirdByte);
    Result.push_back(FourthByte);
  }
}

//<editor-fold defaultstate="collapsed" desc="is_ns_hex_digit">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/Support/YAMLParser.cpp", line = 909,
 FQN="is_ns_hex_digit", NM="_ZL15is_ns_hex_digitc",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/YAMLParser.cpp -nm=_ZL15is_ns_hex_digitc")
//</editor-fold>
public static boolean is_ns_hex_digit(/*const*//*char*/byte C) {
  return (C >= $$0 && C <= $$9)
     || (C >= $$a && C <= $$z)
     || (C >= $$A && C <= $$Z);
}

//<editor-fold defaultstate="collapsed" desc="is_ns_word_char">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/Support/YAMLParser.cpp", line = 915,
 FQN="is_ns_word_char", NM="_ZL15is_ns_word_charc",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/YAMLParser.cpp -nm=_ZL15is_ns_word_charc")
//</editor-fold>
public static boolean is_ns_word_char(/*const*//*char*/byte C) {
  return C == $$MINUS
     || (C >= $$a && C <= $$z)
     || (C >= $$A && C <= $$Z);
}


// Forbidding inlining improves performance by roughly 20%.
// FIXME: Remove once llvm optimizes this to the faster version without hints.

// Returns whether a character at 'Position' was escaped with a leading '\'.
// 'First' specifies the position of the first character in the string.
//<editor-fold defaultstate="collapsed" desc="wasEscaped">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/Support/YAMLParser.cpp", line = 1265,
 FQN="wasEscaped", NM="_ZL10wasEscapedPKcS0_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/YAMLParser.cpp -nm=_ZL10wasEscapedPKcS0_")
//</editor-fold>
public static boolean wasEscaped(char$ptr First, 
          char$ptr Position)/* __attribute__((noinline))*/ {
  assert (Position.$sub(1).$greatereq(First));
  char$ptr I = $tryClone(Position.$sub(1));
  // We calculate the number of consecutive '\'s before the current position
  // by iterating backwards through our string.
  while (I.$greatereq(First) && I.$star() == $$BACK_SLASH) {
    I.$preDec();
  }
  // (Position - 1 - I) now contains the number of '\'s before the current
  // position. If it is odd, the character at 'Position' was escaped.
  return (Position.$sub(1).$sub(I)) % 2 == 1;
}


/// Get the number of line breaks after chomping.
///
/// Return the number of trailing line breaks to emit, depending on
/// \p ChompingIndicator.
//<editor-fold defaultstate="collapsed" desc="getChompedLineBreaks">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/Support/YAMLParser.cpp", line = 1460,
 FQN="getChompedLineBreaks", NM="_ZL20getChompedLineBreakscjN4llvm9StringRefE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/YAMLParser.cpp -nm=_ZL20getChompedLineBreakscjN4llvm9StringRefE")
//</editor-fold>
public static /*uint*/int getChompedLineBreaks(/*char*/byte ChompingIndicator, 
                    /*uint*/int LineBreaks, StringRef Str) {
  if (ChompingIndicator == $$MINUS) { // Strip all line breaks.
    return 0;
  }
  if (ChompingIndicator == $$PLUS) { // Keep all line breaks.
    return LineBreaks;
  }
  // Clip trailing lines.
  return Str.empty() ? 0 : 1;
}

} // END OF class YAMLParserStatics
