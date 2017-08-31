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

import org.clank.support.*;
import org.clank.support.aliases.*;
import static org.clank.support.Casts.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.llvm.adt.*;
import static org.clang.format.impl.EncodingStatics.*;
import static org.llvm.support.ConvertUTFGlobals.*;
import org.llvm.support.sys.unicode;


//<editor-fold defaultstate="collapsed" desc="static type EncodingStatics">
@Converted(kind = Converted.Kind.AUTO,
 NM="org.clang.format.impl.EncodingStatics",
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/Format.cpp -nm=_ZN5clang6format8encoding10isHexDigitEc;_ZN5clang6format8encoding10isOctDigitEc;_ZN5clang6format8encoding11columnWidthEN4llvm9StringRefENS1_8EncodingE;_ZN5clang6format8encoding14detectEncodingEN4llvm9StringRefE;_ZN5clang6format8encoding17getCodePointCountEN4llvm9StringRefENS1_8EncodingE;_ZN5clang6format8encoding19columnWidthWithTabsEN4llvm9StringRefEjjNS1_8EncodingE;_ZN5clang6format8encoding20getCodePointNumBytesEcNS1_8EncodingE;_ZN5clang6format8encoding21getCodePointCountUTF8EN4llvm9StringRefE;_ZN5clang6format8encoding23getEscapeSequenceLengthEN4llvm9StringRefE;_ZN5clang6format8encoding8EncodingE; -static-type=EncodingStatics -package=org.clang.format.impl")
//</editor-fold>
public final class EncodingStatics {

//<editor-fold defaultstate="collapsed" desc="clang::format::encoding::Encoding">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/Encoding.h", line = 28,
 FQN="clang::format::encoding::Encoding", NM="_ZN5clang6format8encoding8EncodingE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/Format.cpp -nm=_ZN5clang6format8encoding8EncodingE")
//</editor-fold>
public enum Encoding implements Native.NativeUIntEnum {
  Encoding_UTF8(0),
  Encoding_Unknown(Encoding_UTF8.getValue() + 1); // We treat all other encodings as 8-bit encodings.

  //<editor-fold defaultstate="collapsed" desc="hidden">
  public static Encoding valueOf(int val) {
    Encoding out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
    assert out != null : "no value for " + val;
    assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
    return out;
  }

  private static final class Values {
    private static final Encoding[] VALUES;
    private static final Encoding[] _VALUES; // [0] not used
    static {
      int max = 0;
      int min = 0;
      for (Encoding kind : Encoding.values()) {
        if (kind.value > max) { max = kind.value; }
        if (kind.value < min) { min = kind.value; }
      }
      _VALUES = new Encoding[min < 0 ? (1-min) : 0];
      VALUES = new Encoding[max >= 0 ? (1+max) : 0];
      for (Encoding kind : Encoding.values()) {
        if (kind.value < 0) {
          if (_VALUES[-kind.value] == null) {
            _VALUES[-kind.value] = kind;
          } else {
            assert true: "Must not replace " + _VALUES[-kind.value] + " by " + kind + ". Switch to int-based enum or filter valid.";
          }
        } else {
          if (VALUES[kind.value] == null) {
            VALUES[kind.value] = kind;
          } else {
            assert true: "Must not replace " + VALUES[kind.value] + " by " + kind + ". Switch to int-based enum or filter valid.";
          }
        }
      }
    }
  }

  private final /*uint*/int value;
  private Encoding(int val) { this.value = (/*uint*/int)val;}
  @Override public final /*uint*/int getValue() { return value;}
  //</editor-fold>
}

/// \brief Detects encoding of the Text. If the Text can be decoded using UTF-8,
/// it is considered UTF8, otherwise we treat it as some 8-bit encoding.
//<editor-fold defaultstate="collapsed" desc="clang::format::encoding::detectEncoding">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/Encoding.h", line = 35,
 FQN="clang::format::encoding::detectEncoding", NM="_ZN5clang6format8encoding14detectEncodingEN4llvm9StringRefE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/Format.cpp -nm=_ZN5clang6format8encoding14detectEncodingEN4llvm9StringRefE")
//</editor-fold>
public static /*inline*/ Encoding detectEncoding(StringRef Text) {
  /*const*/char$ptr/*UTF8 P*/ Ptr = $tryClone(reinterpret_cast(/*const*/char$ptr/*UTF8 P*/ .class, Text.begin()));
  /*const*/char$ptr/*UTF8 P*/ BufEnd = $tryClone(reinterpret_cast(/*const*/char$ptr/*UTF8 P*/ .class, Text.end()));
  if ((/*::*/isLegalUTF8String(Ptr.$addr(), BufEnd) != 0)) {
    return Encoding.Encoding_UTF8;
  }
  return Encoding.Encoding_Unknown;
}

//<editor-fold defaultstate="collapsed" desc="clang::format::encoding::getCodePointCountUTF8">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/Encoding.h", line = 43,
 FQN="clang::format::encoding::getCodePointCountUTF8", NM="_ZN5clang6format8encoding21getCodePointCountUTF8EN4llvm9StringRefE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/Format.cpp -nm=_ZN5clang6format8encoding21getCodePointCountUTF8EN4llvm9StringRefE")
//</editor-fold>
public static /*inline*/ /*uint*/int getCodePointCountUTF8(StringRef Text) {
  /*uint*/int CodePoints = 0;
  for (/*size_t*/int i = 0, e = Text.size(); $less_uint(i, e); i += getNumBytesForUTF8(Text.$at(i))) {
    ++CodePoints;
  }
  return CodePoints;
}


/// \brief Gets the number of code points in the Text using the specified
/// Encoding.
//<editor-fold defaultstate="collapsed" desc="clang::format::encoding::getCodePointCount">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/Encoding.h", line = 53,
 FQN="clang::format::encoding::getCodePointCount", NM="_ZN5clang6format8encoding17getCodePointCountEN4llvm9StringRefENS1_8EncodingE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/Format.cpp -nm=_ZN5clang6format8encoding17getCodePointCountEN4llvm9StringRefENS1_8EncodingE")
//</editor-fold>
public static /*inline*/ /*uint*/int getCodePointCount(StringRef Text, Encoding $Encoding) {
  switch ($Encoding) {
   case Encoding_UTF8:
    return getCodePointCountUTF8(new StringRef(Text));
   default:
    return Text.size();
  }
}


/// \brief Returns the number of columns required to display the \p Text on a
/// generic Unicode-capable terminal. Text is assumed to use the specified
/// \p Encoding.
//<editor-fold defaultstate="collapsed" desc="clang::format::encoding::columnWidth">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/Encoding.h", line = 65,
 FQN="clang::format::encoding::columnWidth", NM="_ZN5clang6format8encoding11columnWidthEN4llvm9StringRefENS1_8EncodingE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/Format.cpp -nm=_ZN5clang6format8encoding11columnWidthEN4llvm9StringRefENS1_8EncodingE")
//</editor-fold>
public static /*inline*/ /*uint*/int columnWidth(StringRef Text, Encoding $Encoding) {
  if ($Encoding == Encoding.Encoding_UTF8) {
    int ContentWidth = unicode.columnWidthUTF8(new StringRef(Text));
    // FIXME: Figure out the correct way to handle this in the presence of both
    // printable and unprintable multi-byte UTF-8 characters. Falling back to
    // returning the number of bytes may cause problems, as columnWidth suddenly
    // becomes non-additive.
    if (ContentWidth >= 0) {
      return ContentWidth;
    }
  }
  return Text.size();
}


/// \brief Returns the number of columns required to display the \p Text,
/// starting from the \p StartColumn on a terminal with the \p TabWidth. The
/// text is assumed to use the specified \p Encoding.
//<editor-fold defaultstate="collapsed" desc="clang::format::encoding::columnWidthWithTabs">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/Encoding.h", line = 81,
 FQN="clang::format::encoding::columnWidthWithTabs", NM="_ZN5clang6format8encoding19columnWidthWithTabsEN4llvm9StringRefEjjNS1_8EncodingE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/Format.cpp -nm=_ZN5clang6format8encoding19columnWidthWithTabsEN4llvm9StringRefEjjNS1_8EncodingE")
//</editor-fold>
public static /*inline*/ /*uint*/int columnWidthWithTabs(StringRef Text, /*uint*/int StartColumn, 
                   /*uint*/int TabWidth, Encoding $Encoding) {
  /*uint*/int TotalWidth = 0;
  StringRef Tail = new StringRef(Text);
  for (;;) {
    /*size_t*/int TabPos = Tail.find($$TAB);
    if (TabPos == StringRef.npos) {
      return TotalWidth + columnWidth(new StringRef(Tail), $Encoding);
    }
    TotalWidth += columnWidth(Tail.substr(0, TabPos), $Encoding);
    TotalWidth += TabWidth - $rem_uint((TotalWidth + StartColumn), TabWidth);
    Tail.$assignMove(Tail.substr(TabPos + 1));
  }
}


/// \brief Gets the number of bytes in a sequence representing a single
/// codepoint and starting with FirstChar in the specified Encoding.
//<editor-fold defaultstate="collapsed" desc="clang::format::encoding::getCodePointNumBytes">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/Encoding.h", line = 97,
 FQN="clang::format::encoding::getCodePointNumBytes", NM="_ZN5clang6format8encoding20getCodePointNumBytesEcNS1_8EncodingE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/Format.cpp -nm=_ZN5clang6format8encoding20getCodePointNumBytesEcNS1_8EncodingE")
//</editor-fold>
public static /*inline*/ /*uint*/int getCodePointNumBytes(/*char*/byte FirstChar, Encoding $Encoding) {
  switch ($Encoding) {
   case Encoding_UTF8:
    return getNumBytesForUTF8(FirstChar);
   default:
    return 1;
  }
}

//<editor-fold defaultstate="collapsed" desc="clang::format::encoding::isOctDigit">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/Encoding.h", line = 106,
 FQN="clang::format::encoding::isOctDigit", NM="_ZN5clang6format8encoding10isOctDigitEc",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/Format.cpp -nm=_ZN5clang6format8encoding10isOctDigitEc")
//</editor-fold>
public static /*inline*/ boolean isOctDigit(/*char*/byte c) {
  return $$0 <= c && c <= $$7;
}

//<editor-fold defaultstate="collapsed" desc="clang::format::encoding::isHexDigit">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/Encoding.h", line = 108,
 FQN="clang::format::encoding::isHexDigit", NM="_ZN5clang6format8encoding10isHexDigitEc",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/Format.cpp -nm=_ZN5clang6format8encoding10isHexDigitEc")
//</editor-fold>
public static /*inline*/ boolean isHexDigit(/*char*/byte c) {
  return ($$0 <= c && c <= $$9) || ($$a <= c && c <= $$f)
     || ($$A <= c && c <= $$F);
}


/// \brief Gets the length of an escape sequence inside a C++ string literal.
/// Text should span from the beginning of the escape sequence (starting with a
/// backslash) to the end of the string literal.
//<editor-fold defaultstate="collapsed" desc="clang::format::encoding::getEscapeSequenceLength">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/Encoding.h", line = 116,
 FQN="clang::format::encoding::getEscapeSequenceLength", NM="_ZN5clang6format8encoding23getEscapeSequenceLengthEN4llvm9StringRefE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/Format.cpp -nm=_ZN5clang6format8encoding23getEscapeSequenceLengthEN4llvm9StringRefE")
//</editor-fold>
public static /*inline*/ /*uint*/int getEscapeSequenceLength(StringRef Text) {
  assert (Text.$at(0) == $$BACK_SLASH);
  if ($less_uint(Text.size(), 2)) {
    return 1;
  }
  switch (Text.$at(1)) {
   case 'u':
    return 6;
   case 'U':
    return 10;
   case 'x':
    {
      /*uint*/int I = 2; // Point after '\x'.
      while ($less_uint(I, Text.size()) && isHexDigit(Text.$at(I))) {
        ++I;
      }
      return I;
    }
   default:
    if (isOctDigit(Text.$at(1))) {
      /*uint*/int I = 1;
      while ($less_uint(I, Text.size()) && $less_uint(I, 4) && isOctDigit(Text.$at(I))) {
        ++I;
      }
      return I;
    }
    return 1 + getNumBytesForUTF8(Text.$at(1));
  }
}

} // END OF class EncodingStatics
