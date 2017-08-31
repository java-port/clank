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
import org.clank.support.JavaDifferentiators.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Unsigned.*;
import org.llvm.adt.*;
import static org.clang.format.impl.EncodingStatics.*;
import static org.clang.format.impl.BreakableTokenFormatStatics.*;
import static org.clang.basic.BasicClangGlobals.*;
import static org.clang.format.impl.FormatStatics.*;


//<editor-fold defaultstate="collapsed" desc="static type BreakableTokenFormatStatics">
@Converted(kind = Converted.Kind.AUTO,
 NM="org.clang.format.impl.BreakableTokenFormatStatics",
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/BreakableToken.cpp -nm=_ZN5clang6formatL14getStringSplitEN4llvm9StringRefEjjjNS0_8encoding8EncodingE;_ZN5clang6formatL15getCommentSplitEN4llvm9StringRefEjjjNS0_8encoding8EncodingE;_ZN5clang6formatL26getLineCommentIndentPrefixEN4llvm9StringRefE;_ZN5clang6formatL7IsBlankEc; -static-type=BreakableTokenFormatStatics -package=org.clang.format.impl")
//</editor-fold>
public final class BreakableTokenFormatStatics {

//<editor-fold defaultstate="collapsed" desc="clang::format::IsBlank">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/BreakableToken.cpp", line = 29,
 FQN="clang::format::IsBlank", NM="_ZN5clang6formatL7IsBlankEc",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/BreakableToken.cpp -nm=_ZN5clang6formatL7IsBlankEc")
//</editor-fold>
public static boolean IsBlank(/*char*/byte C) {
  switch (C) {
   case ' ':
   case '\t':
   case '\013'/*\v*/:
   case '\f':
   case '\r':
    return true;
   default:
    return false;
  }
}

//<editor-fold defaultstate="collapsed" desc="clang::format::getCommentSplit">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/BreakableToken.cpp", line = 42,
 FQN="clang::format::getCommentSplit", NM="_ZN5clang6formatL15getCommentSplitEN4llvm9StringRefEjjjNS0_8encoding8EncodingE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/BreakableToken.cpp -nm=_ZN5clang6formatL15getCommentSplitEN4llvm9StringRefEjjjNS0_8encoding8EncodingE")
//</editor-fold>
public static std.pairUIntUInt getCommentSplit(StringRef Text, 
               /*uint*/int ContentStartColumn, 
               /*uint*/int ColumnLimit, 
               /*uint*/int TabWidth, 
               /*enum_conversion.properties: ADD FQN MAPPING FOR ENUM[encoding::Encoding] using FQN clang::format::encoding::Encoding*/Encoding $Encoding) {
  if ($lesseq_uint(ColumnLimit, ContentStartColumn + 1)) {
    return new std.pairUIntUInt(JD$T$C$R_T$RR.INSTANCE, StringRef.npos, 0);
  }
  
  /*uint*/int MaxSplit = ColumnLimit - ContentStartColumn + 1;
  /*uint*/int MaxSplitBytes = 0;
  
  for (/*uint*/int NumChars = 0;
       $less_uint(NumChars, MaxSplit) && $less_uint(MaxSplitBytes, Text.size());) {
    /*uint*/int BytesInChar = getCodePointNumBytes(Text.$at(MaxSplitBytes), $Encoding);
    NumChars += columnWidthWithTabs(Text.substr(MaxSplitBytes, BytesInChar), 
        ContentStartColumn, TabWidth, $Encoding);
    MaxSplitBytes += BytesInChar;
  }
  
  /*size_t*/int SpaceOffset = Text.find_last_of(/*STRINGREF_STR*/Blanks, MaxSplitBytes);
  if (SpaceOffset == StringRef.npos
    // Don't break at leading whitespace.
     || Text.find_last_not_of(/*STRINGREF_STR*/Blanks, SpaceOffset) == StringRef.npos) {
    // Make sure that we don't break at leading whitespace that
    // reaches past MaxSplit.
    /*size_t*/int FirstNonWhitespace = Text.find_first_not_of(/*STRINGREF_STR*/Blanks);
    if (FirstNonWhitespace == StringRef.npos) {
      // If the comment is only whitespace, we cannot split.
      return new std.pairUIntUInt(JD$T$C$R_T$RR.INSTANCE, StringRef.npos, 0);
    }
    SpaceOffset = Text.find_first_of(/*STRINGREF_STR*/Blanks, std.max(MaxSplitBytes, FirstNonWhitespace));
  }
  if (SpaceOffset != StringRef.npos && SpaceOffset != 0) {
    StringRef BeforeCut = Text.substr(0, SpaceOffset).rtrim(/*STRINGREF_STR*/Blanks);
    StringRef AfterCut = Text.substr(SpaceOffset).ltrim(/*STRINGREF_STR*/Blanks);
    return new std.pairUIntUInt(JD$T$RR_T1$RR.INSTANCE, BeforeCut.size(), 
        AfterCut.begin().$sub(BeforeCut.end()));
  }
  return new std.pairUIntUInt(JD$T$C$R_T$RR.INSTANCE, StringRef.npos, 0);
}

//<editor-fold defaultstate="collapsed" desc="clang::format::getStringSplit">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/BreakableToken.cpp", line = 85,
 FQN="clang::format::getStringSplit", NM="_ZN5clang6formatL14getStringSplitEN4llvm9StringRefEjjjNS0_8encoding8EncodingE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/BreakableToken.cpp -nm=_ZN5clang6formatL14getStringSplitEN4llvm9StringRefEjjjNS0_8encoding8EncodingE")
//</editor-fold>
public static std.pairUIntUInt getStringSplit(StringRef Text, /*uint*/int UsedColumns, /*uint*/int ColumnLimit, 
              /*uint*/int TabWidth, /*enum_conversion.properties: ADD FQN MAPPING FOR ENUM[encoding::Encoding] using FQN clang::format::encoding::Encoding*/Encoding $Encoding) {
  // FIXME: Reduce unit test case.
  if (Text.empty()) {
    return new std.pairUIntUInt(JD$T$C$R_T$RR.INSTANCE, StringRef.npos, 0);
  }
  if ($lesseq_uint(ColumnLimit, UsedColumns)) {
    return new std.pairUIntUInt(JD$T$C$R_T$RR.INSTANCE, StringRef.npos, 0);
  }
  /*uint*/int MaxSplit = ColumnLimit - UsedColumns;
  /*size_t*/int SpaceOffset = 0;
  /*size_t*/int SlashOffset = 0;
  /*size_t*/int WordStartOffset = 0;
  /*size_t*/int SplitPoint = 0;
  for (/*uint*/int Chars = 0;;) {
    /*uint*/int Advance;
    if (Text.$at(0) == $$BACK_SLASH) {
      Advance = getEscapeSequenceLength(new StringRef(Text));
      Chars += Advance;
    } else {
      Advance = getCodePointNumBytes(Text.$at(0), $Encoding);
      Chars += columnWidthWithTabs(Text.substr(0, Advance), UsedColumns + Chars, TabWidth, $Encoding);
    }
    if ($greater_uint(Chars, MaxSplit) || $lesseq_uint(Text.size(), Advance)) {
      break;
    }
    if (IsBlank(Text.$at(0))) {
      SpaceOffset = SplitPoint;
    }
    if (Text.$at(0) == $$SLASH) {
      SlashOffset = SplitPoint;
    }
    if (Advance == 1 && !isAlphanumeric(Text.$at(0))) {
      WordStartOffset = SplitPoint;
    }
    
    SplitPoint += Advance;
    Text.$assignMove(Text.substr(Advance));
  }
  if (SpaceOffset != 0) {
    return new std.pairUIntUInt(JD$T$RR_T1$RR.INSTANCE, SpaceOffset + 1, 0);
  }
  if (SlashOffset != 0) {
    return new std.pairUIntUInt(JD$T$RR_T1$RR.INSTANCE, SlashOffset + 1, 0);
  }
  if (WordStartOffset != 0) {
    return new std.pairUIntUInt(JD$T$RR_T1$RR.INSTANCE, WordStartOffset + 1, 0);
  }
  if (SplitPoint != 0) {
    return new std.pairUIntUInt(JD$T$RR_T1$RR.INSTANCE, SplitPoint, 0);
  }
  return new std.pairUIntUInt(JD$T$C$R_T$RR.INSTANCE, StringRef.npos, 0);
}

//<editor-fold defaultstate="collapsed" desc="clang::format::getLineCommentIndentPrefix">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/BreakableToken.cpp", line = 185,
 FQN="clang::format::getLineCommentIndentPrefix", NM="_ZN5clang6formatL26getLineCommentIndentPrefixEN4llvm9StringRefE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/BreakableToken.cpp -nm=_ZN5clang6formatL26getLineCommentIndentPrefixEN4llvm9StringRefE")
//</editor-fold>
public static StringRef getLineCommentIndentPrefix(StringRef Comment) {
  final/*static*/ /*const*/StringRef[]/*char P*//*const*//*[3]*/ KnownPrefixes = getLineCommentIndentPrefix$$.KnownPrefixes;
  StringRef LongestPrefix/*J*/= new StringRef();
  for (StringRef KnownPrefix : KnownPrefixes) {
    if (Comment.startswith(/*NO_COPY*/KnownPrefix)) {
      /*size_t*/int PrefixLength = KnownPrefix.size();
      while ($less_uint(PrefixLength, Comment.size()) && Comment.$at(PrefixLength) == $$SPACE) {
        ++PrefixLength;
      }
      if ($greater_uint(PrefixLength, LongestPrefix.size())) {
        LongestPrefix.$assignMove(Comment.substr(0, PrefixLength));
      }
    }
  }
  return LongestPrefix;
}
private static final class getLineCommentIndentPrefix$$ {
  static final StringRef[] KnownPrefixes = new /*const*/StringRef/*char P*//*const*/ [/*3*/] {new StringRef($("///")), new StringRef($("//")), new StringRef($("//!"))};
}

} // END OF class BreakableTokenFormatStatics
