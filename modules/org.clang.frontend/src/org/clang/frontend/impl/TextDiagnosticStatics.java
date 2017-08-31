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
package org.clang.frontend.impl;

import org.llvm.support.sys.locale;
import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import static org.clank.java.std.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import static org.clang.basic.BasicClangGlobals.*;
import org.clang.basic.*;
import org.clang.lex.*;
import org.clang.frontend.impl.*;
import static org.llvm.support.ConvertUTFGlobals.*;


//<editor-fold defaultstate="collapsed" desc="static type TextDiagnosticStatics">
@Converted(kind = Converted.Kind.AUTO,
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/TextDiagnostic.cpp -nm=_ZL10caretColor;_ZL10errorColor;_ZL10expandTabsRSsj;_ZL10fatalColor;_ZL10fixitColor;_ZL10savedColor;_ZL11remarkColor;_ZL12byteToColumnN4llvm9StringRefEjRNS_15SmallVectorImplIiEE;_ZL12columnToByteN4llvm9StringRefEjRNS_15SmallVectorImplIiEE;_ZL12warningColor;_ZL13findEndOfWordjN4llvm9StringRefEjjj;_ZL13templateColor;_ZL14highlightRangeRKN5clang15CharSourceRangeEjNS_6FileIDERKN12_GLOBAL__N_115SourceColumnMapERSsRKNS_13SourceManagerERKNS_11LangOptionsE;_ZL14skipWhitespacejN4llvm9StringRefEj;_ZL16printWordWrappedRN4llvm11raw_ostreamENS_9StringRefEjjbj;_ZL19WordWrapIndentation;_ZL23buildFixItInsertionLinejRKN12_GLOBAL__N_115SourceColumnMapEN4llvm8ArrayRefIN5clang9FixItHintEEERKNS5_13SourceManagerEPKNS5_17DiagnosticOptionsE;_ZL23findMatchingPunctuationc;_ZL25applyTemplateHighlightingRN4llvm11raw_ostreamENS_9StringRefERbb;_ZL29printableTextForNextCharacterN4llvm9StringRefEPjj;_ZL29selectInterestingSourceRegionRSsS_S_jRKN12_GLOBAL__N_115SourceColumnMapE;_ZL32bytesSincePreviousTabOrLineBeginN4llvm9StringRefEj;_ZL9noteColor; -static-type=TextDiagnosticStatics -package=org.clang.frontend.impl")
//</editor-fold>
public final class TextDiagnosticStatics {

//<editor-fold defaultstate="collapsed" desc="noteColor">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/TextDiagnostic.cpp", line = 27,
 FQN="noteColor", NM="_ZL9noteColor",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/TextDiagnostic.cpp -nm=_ZL9noteColor")
//</editor-fold>
public static /*const*/  raw_ostream.Colors noteColor = raw_ostream.Colors.BLACK;
//<editor-fold defaultstate="collapsed" desc="remarkColor">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/TextDiagnostic.cpp", line = 29,
 FQN="remarkColor", NM="_ZL11remarkColor",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/TextDiagnostic.cpp -nm=_ZL11remarkColor")
//</editor-fold>
public static /*const*/  raw_ostream.Colors remarkColor = raw_ostream.Colors.BLUE;
//<editor-fold defaultstate="collapsed" desc="fixitColor">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/TextDiagnostic.cpp", line = 31,
 FQN="fixitColor", NM="_ZL10fixitColor",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/TextDiagnostic.cpp -nm=_ZL10fixitColor")
//</editor-fold>
public static /*const*/  raw_ostream.Colors fixitColor = raw_ostream.Colors.GREEN;
//<editor-fold defaultstate="collapsed" desc="caretColor">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/TextDiagnostic.cpp", line = 33,
 FQN="caretColor", NM="_ZL10caretColor",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/TextDiagnostic.cpp -nm=_ZL10caretColor")
//</editor-fold>
public static /*const*/  raw_ostream.Colors caretColor = raw_ostream.Colors.GREEN;
//<editor-fold defaultstate="collapsed" desc="warningColor">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/TextDiagnostic.cpp", line = 35,
 FQN="warningColor", NM="_ZL12warningColor",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/TextDiagnostic.cpp -nm=_ZL12warningColor")
//</editor-fold>
public static /*const*/  raw_ostream.Colors warningColor = raw_ostream.Colors.MAGENTA;
//<editor-fold defaultstate="collapsed" desc="templateColor">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/TextDiagnostic.cpp", line = 37,
 FQN="templateColor", NM="_ZL13templateColor",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/TextDiagnostic.cpp -nm=_ZL13templateColor")
//</editor-fold>
public static /*const*/  raw_ostream.Colors templateColor = raw_ostream.Colors.CYAN;
//<editor-fold defaultstate="collapsed" desc="errorColor">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/TextDiagnostic.cpp", line = 39,
 FQN="errorColor", NM="_ZL10errorColor",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/TextDiagnostic.cpp -nm=_ZL10errorColor")
//</editor-fold>
public static /*const*/  raw_ostream.Colors errorColor = raw_ostream.Colors.RED;
//<editor-fold defaultstate="collapsed" desc="fatalColor">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/TextDiagnostic.cpp", line = 40,
 FQN="fatalColor", NM="_ZL10fatalColor",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/TextDiagnostic.cpp -nm=_ZL10fatalColor")
//</editor-fold>
public static /*const*/  raw_ostream.Colors fatalColor = raw_ostream.Colors.RED;
// Used for changing only the bold attribute.
//<editor-fold defaultstate="collapsed" desc="savedColor">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/TextDiagnostic.cpp", line = 42,
 FQN="savedColor", NM="_ZL10savedColor",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/TextDiagnostic.cpp -nm=_ZL10savedColor")
//</editor-fold>
public static /*const*/  raw_ostream.Colors savedColor = raw_ostream.Colors.SAVEDCOLOR;

/// \brief Add highlights to differences in template strings.
//<editor-fold defaultstate="collapsed" desc="applyTemplateHighlighting">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/TextDiagnostic.cpp", line = 46,
 FQN="applyTemplateHighlighting", NM="_ZL25applyTemplateHighlightingRN4llvm11raw_ostreamENS_9StringRefERbb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/TextDiagnostic.cpp -nm=_ZL25applyTemplateHighlightingRN4llvm11raw_ostreamENS_9StringRefERbb")
//</editor-fold>
public static void applyTemplateHighlighting(raw_ostream /*&*/ OS, StringRef Str, 
                         bool$ref/*bool &*/ Normal, boolean Bold) {
  while (true) {
    /*size_t*/int Pos = Str.find(ToggleHighlight);
    OS.$out(Str.slice(0, Pos));
    if (Pos == StringRef.npos) {
      break;
    }
    
    Str.$assign$substr((int)Pos + 1);
    if (Normal.$deref()) {
      OS.changeColor(templateColor, true);
    } else {
      OS.resetColor();
      if (Bold) {
        OS.changeColor(savedColor, true);
      }
    }
    Normal.$set(!Normal.$deref());
  }
}


/// \brief Number of spaces to indent when word-wrapping.
//<editor-fold defaultstate="collapsed" desc="WordWrapIndentation">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/TextDiagnostic.cpp", line = 67,
 FQN="WordWrapIndentation", NM="_ZL19WordWrapIndentation",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/TextDiagnostic.cpp -nm=_ZL19WordWrapIndentation")
//</editor-fold>
public static /*const*//*uint*/int WordWrapIndentation = 6;
//<editor-fold defaultstate="collapsed" desc="bytesSincePreviousTabOrLineBegin">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/TextDiagnostic.cpp", line = 69,
 FQN="bytesSincePreviousTabOrLineBegin", NM="_ZL32bytesSincePreviousTabOrLineBeginN4llvm9StringRefEj",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/TextDiagnostic.cpp -nm=_ZL32bytesSincePreviousTabOrLineBeginN4llvm9StringRefEj")
//</editor-fold>
public static int bytesSincePreviousTabOrLineBegin(StringRef SourceLine, /*size_t*/int i) {
  int bytes = 0;
  while ($less_uint(0, i)) {
    if (SourceLine.$at(--i) == $$TAB) {
      break;
    }
    ++bytes;
  }
  return bytes;
}


/// \brief returns a printable representation of first item from input range
///
/// This function returns a printable representation of the next item in a line
///  of source. If the next byte begins a valid and printable character, that
///  character is returned along with 'true'.
///
/// Otherwise, if the next byte begins a valid, but unprintable character, a
///  printable, escaped representation of the character is returned, along with
///  'false'. Otherwise a printable, escaped representation of the next byte
///  is returned along with 'false'.
///
/// \note The index is updated to be used with a subsequent call to
///        printableTextForNextCharacter.
///
/// \param SourceLine The line of source
/// \param i Pointer to byte index,
/// \param TabStop used to expand tabs
/// \return pair(printable text, 'true' iff original text was printable)
///
//<editor-fold defaultstate="collapsed" desc="printableTextForNextCharacter">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/TextDiagnostic.cpp", line = 98,
 FQN="printableTextForNextCharacter", NM="_ZL29printableTextForNextCharacterN4llvm9StringRefEPjj",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/TextDiagnostic.cpp -nm=_ZL29printableTextForNextCharacterN4llvm9StringRefEPjj")
//</editor-fold>
public static std.pairTypeBool<SmallString/*16*/> printableTextForNextCharacter(StringRef SourceLine, uint$ptr/*size_t P*/ i, 
                             /*uint*/int TabStop) {
  assert ((i != null)) : "i must not be null";
  assert ($less_uint(i.$star(), SourceLine.size())) : "must point to a valid index";
  if (SourceLine.$at(i.$star()) == $$TAB) {
    assert ($less_uint(0, TabStop) && $lesseq_uint(TabStop, DiagnosticOptions.Unnamed_enum1.MaxTabStop.getValue())) : "Invalid -ftabstop value";
    /*uint*/int col = bytesSincePreviousTabOrLineBegin(new StringRef(SourceLine), i.$star());
    /*uint*/int NumSpaces = TabStop - col % TabStop;
    assert ($less_uint(0, NumSpaces) && $lesseq_uint(NumSpaces, TabStop)) : "Invalid computation of space amt";
    i.$set$preInc(0);
    
    SmallString/*16*/ expandedTab/*J*/= new SmallString/*16*/(16);
    expandedTab.assign(NumSpaces, $$SPACE);
    return std.make_pair_T_bool(expandedTab, true);
  }
  
  /*const*/char$ptr/*uchar P*/ begin, /*P*/ end;
  begin = SourceLine.begin().$add(i.$star());
  end = begin.$add((SourceLine.size() - i.$star()));
  if ((isLegalUTF8Sequence(begin, end) != 0)) {
    int/*UTF32*/ $c[] = new$uint$elem(0);
    uint$ptr/*UTF32 P*/ cptr = create_uint$ptr($c);
    /*const*/char$ptr/*uchar P*/ original_begin = $tryClone(begin);
    /*const*/char$ptr/*uchar P*/ cp_end = $tryClone(begin.$add(getNumBytesForUTF8(SourceLine.$at(i.$star()))));
    
    ConversionResult res = ConvertUTF8toUTF32(begin.$addr(), cp_end, cptr.$addr(), cptr.$add(1), 
        ConversionFlags.strictConversion);
    int/*UTF32*/ c = $c[0];
    //(void)res;
    assert (ConversionResult.conversionOK == res);
    assert (0 < begin.$sub(original_begin)) : "we must be further along in the string now";
    i.$set$addassign(0, begin.$sub(original_begin));
    if (!locale.isPrint(c)) {
      // If next character is valid UTF-8, but not printable
      SmallString/*16*/ expandedCP/*J*/= new SmallString/*16*/(new StringRef(/*KEEP_STR*/"<U+>"), 16);
      while ((c != 0)) {
        expandedCP.insert(expandedCP.begin().$add(3), llvm.hexdigit($rem_uint(c, 16)));
        c = $div_uint(c, 16);
      }
      while ($less_uint(expandedCP.size(), 8)) {
        expandedCP.insert(expandedCP.begin().$add(3), llvm.hexdigit(0));
      }
      return std.make_pair_T_bool(expandedCP, false);
    }
    
    // If next character is valid UTF-8, and printable
    return std.make_pair_T_bool(new SmallString/*16*/(original_begin, cp_end, 16), true);
  }
  
  // If next byte is not valid UTF-8 (and therefore not printable)
  SmallString/*16*/ expandedByte/*J*/= new SmallString/*16*/(new StringRef(/*KEEP_STR*/"<XX>"), 16);
  /*uchar*/byte __byte = SourceLine.$at(i.$star());
  expandedByte.$set(1, llvm.hexdigit($uchar2int(__byte) / 16));
  expandedByte.$set(2, llvm.hexdigit($uchar2int(__byte) % 16));
  i.$set$preInc(0);
  return std.make_pair_T_bool(expandedByte, false);
}

//<editor-fold defaultstate="collapsed" desc="expandTabs">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/TextDiagnostic.cpp", line = 162,
 FQN="expandTabs", NM="_ZL10expandTabsRSsj",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/TextDiagnostic.cpp -nm=_ZL10expandTabsRSsj")
//</editor-fold>
public static void expandTabs(std.string/*&*/ SourceLine, /*uint*/int TabStop) {
  /*size_t*/int i = SourceLine.size();
  while ($greater_uint(i, 0)) {
    i--;
    if (SourceLine.$at(i) != $$TAB) {
      continue;
    }
    uint$ptr/*size_t*/ tmp_i = create_uint$ptr(i);
    std.pairTypeBool<SmallString/*16*/> res = printableTextForNextCharacter(new StringRef(SourceLine), /*AddrOf*/tmp_i, TabStop);
    SourceLine.replace(i, 1, res.first.c_str());
  }
}


/// This function takes a raw source line and produces a mapping from the bytes
///  of the printable representation of the line to the columns those printable
///  characters will appear at (numbering the first column as 0).
///
/// If a byte 'i' corresponds to multiple columns (e.g. the byte contains a tab
///  character) then the array will map that byte to the first column the
///  tab appears at and the next value in the map will have been incremented
///  more than once.
///
/// If a byte is the first in a sequence of bytes that together map to a single
///  entity in the output, then the array will map that byte to the appropriate
///  column while the subsequent bytes will be -1.
///
/// The last element in the array does not correspond to any byte in the input
///  and instead is the number of columns needed to display the source
///
/// example: (given a tabstop of 8)
///
///    "a \t \u3042" -> {0,1,2,8,9,-1,-1,11}
///
///  (\\u3042 is represented in UTF-8 by three bytes and takes two columns to
///   display)
//<editor-fold defaultstate="collapsed" desc="byteToColumn">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/TextDiagnostic.cpp", line = 197,
 FQN="byteToColumn", NM="_ZL12byteToColumnN4llvm9StringRefEjRNS_15SmallVectorImplIiEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/TextDiagnostic.cpp -nm=_ZL12byteToColumnN4llvm9StringRefEjRNS_15SmallVectorImplIiEE")
//</editor-fold>
public static void byteToColumn(StringRef SourceLine, /*uint*/int TabStop, 
            SmallVectorImplInt/*&*/ out) {
  out.clear();
  if (SourceLine.empty()) {
    out.resize(1/*U*/, 0);
    return;
  }
  
  out.resize(SourceLine.size() + 1, -1);
  
  int columns = 0;
  uint$ptr/*size_t*/ i = create_uint$ptr(0);
  while ($less_uint(i, SourceLine.size())) {
    out.$set(i.$star(), columns);
    std.pairTypeBool<SmallString/*16*/> res = printableTextForNextCharacter(new StringRef(SourceLine), /*AddrOf*/i, TabStop);
    columns += locale.columnWidth(res.first.$StringRef());
  }
  out.ref$back().$set(columns);
}


/// This function takes a raw source line and produces a mapping from columns
///  to the byte of the source line that produced the character displaying at
///  that column. This is the inverse of the mapping produced by byteToColumn()
///
/// The last element in the array is the number of bytes in the source string
///
/// example: (given a tabstop of 8)
///
///    "a \t \u3042" -> {0,1,2,-1,-1,-1,-1,-1,3,4,-1,7}
///
///  (\\u3042 is represented in UTF-8 by three bytes and takes two columns to
///   display)
//<editor-fold defaultstate="collapsed" desc="columnToByte">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/TextDiagnostic.cpp", line = 231,
 FQN="columnToByte", NM="_ZL12columnToByteN4llvm9StringRefEjRNS_15SmallVectorImplIiEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/TextDiagnostic.cpp -nm=_ZL12columnToByteN4llvm9StringRefEjRNS_15SmallVectorImplIiEE")
//</editor-fold>
public static void columnToByte(StringRef SourceLine, /*uint*/int TabStop, 
            SmallVectorImplInt/*&*/ out) {
  out.clear();
  if (SourceLine.empty()) {
    out.resize(1/*U*/, 0);
    return;
  }
  
  int columns = 0;
  uint$ptr/*size_t*/ i = create_uint$ptr(0);
  while ($less_uint(i, SourceLine.size())) {
    out.resize(columns + 1, -1);
    out.ref$back().$set((int) i.$star());
    std.pairTypeBool<SmallString/*16*/> res = printableTextForNextCharacter(new StringRef(SourceLine), /*AddrOf*/i, TabStop);
    columns += locale.columnWidth(res.first.$StringRef());
  }
  out.resize(columns + 1, -1);
  out.ref$back().$set((int) i.$star());
}

// end anonymous namespace

/// \brief When the source code line we want to print is too long for
/// the terminal, select the "interesting" region.
//<editor-fold defaultstate="collapsed" desc="selectInterestingSourceRegion">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/TextDiagnostic.cpp", line = 321,
 FQN="selectInterestingSourceRegion", NM="_ZL29selectInterestingSourceRegionRSsS_S_jRKN12_GLOBAL__N_115SourceColumnMapE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/TextDiagnostic.cpp -nm=_ZL29selectInterestingSourceRegionRSsS_S_jRKN12_GLOBAL__N_115SourceColumnMapE")
//</editor-fold>
public static void selectInterestingSourceRegion(std.string/*&*/ SourceLine, 
                             std.string/*&*/ CaretLine, 
                             std.string/*&*/ FixItInsertionLine, 
                             /*uint*/int Columns, 
                             /*const*/ SourceColumnMap /*&*/ map) {
  /*uint*/int CaretColumns = CaretLine.size();
  /*uint*/int FixItColumns = locale.columnWidth(new StringRef(FixItInsertionLine));
  /*uint*/int MaxColumns = std.max(((/*static_cast*//*uint*/int)(map.columns())), 
      std.max(CaretColumns, FixItColumns));
  // if the number of columns is less than the desired number we're done
  if ($lesseq_uint(MaxColumns, Columns)) {
    return;
  }
  
  // No special characters are allowed in CaretLine.
  assert ($eq___normal_iterator$C(CaretLine.end(), std.find_if(CaretLine.begin(), CaretLine.end(),  (c) -> 
          {
            return c < $$SPACE || $$TILDE < c;
          }
)));
  
  // Find the slice that we need to display the full caret line
  // correctly.
  /*uint*/int CaretStart = 0, CaretEnd = CaretLine.size();
  for (; CaretStart != CaretEnd; ++CaretStart)  {
    if (!isWhitespace(CaretLine.$at(CaretStart))) {
      break;
    }
  }
  
  for (; CaretEnd != CaretStart; --CaretEnd)  {
    if (!isWhitespace(CaretLine.$at(CaretEnd - 1))) {
      break;
    }
  }
  
  // caret has already been inserted into CaretLine so the above whitespace
  // check is guaranteed to include the caret
  
  // If we have a fix-it line, make sure the slice includes all of the
  // fix-it information.
  if (!FixItInsertionLine.empty()) {
    /*uint*/int FixItStart = 0, FixItEnd = FixItInsertionLine.size();
    for (; FixItStart != FixItEnd; ++FixItStart)  {
      if (!isWhitespace(FixItInsertionLine.$at(FixItStart))) {
        break;
      }
    }
    
    for (; FixItEnd != FixItStart; --FixItEnd)  {
      if (!isWhitespace(FixItInsertionLine.$at(FixItEnd - 1))) {
        break;
      }
    }
    
    // We can safely use the byte offset FixItStart as the column offset
    // because the characters up until FixItStart are all ASCII whitespace
    // characters.
    /*uint*/int FixItStartCol = FixItStart;
    /*uint*/int FixItEndCol = locale.columnWidth(new StringRef(FixItInsertionLine.substr(0, FixItEnd)));
    
    CaretStart = std.min(FixItStartCol, CaretStart);
    CaretEnd = std.max(FixItEndCol, CaretEnd);
  }
  
  // CaretEnd may have been set at the middle of a character
  // If it's not at a character's first column then advance it past the current
  //   character.
  while (((/*static_cast*/int)(CaretEnd)) < map.columns()
     && -1 == map.columnToByte(CaretEnd)) {
    ++CaretEnd;
  }
  assert ((((/*static_cast*/int)(CaretStart)) > map.columns() || -1 != map.columnToByte(CaretStart))) : "CaretStart must not point to a column in the middle of a source line character";
  assert ((((/*static_cast*/int)(CaretEnd)) > map.columns() || -1 != map.columnToByte(CaretEnd))) : "CaretEnd must not point to a column in the middle of a source line character";
  
  // CaretLine[CaretStart, CaretEnd) contains all of the interesting
  // parts of the caret line. While this slice is smaller than the
  // number of columns we have, try to grow the slice to encompass
  // more context.
  /*uint*/int SourceStart = map.columnToByte(std.min_uint(CaretStart, 
          map.columns()));
  /*uint*/int SourceEnd = map.columnToByte(std.min_uint(CaretEnd, 
          map.columns()));
  
  /*uint*/int CaretColumnsOutsideSource = CaretEnd - CaretStart
     - (map.byteToColumn(SourceEnd) - map.byteToColumn(SourceStart));
  
  /*const*/String/*char P*/ front_ellipse = "  ...";
  /*const*/String/*char P*/ front_space = "     ";
  /*const*/String/*char P*/ back_ellipse = "...";
  /*uint*/int ellipses_space = strlen(front_ellipse) + strlen(back_ellipse);
  
  /*uint*/int TargetColumns = Columns;
  // Give us extra room for the ellipses
  //  and any of the caret line that extends past the source
  if ($greater_uint(TargetColumns, ellipses_space + CaretColumnsOutsideSource)) {
    TargetColumns -= ellipses_space + CaretColumnsOutsideSource;
  }
  while ($greater_uint(SourceStart, 0) || $less_uint(SourceEnd, SourceLine.size())) {
    boolean ExpandedRegion = false;
    if ($greater_uint(SourceStart, 0)) {
      /*uint*/int NewStart = map.startOfPreviousColumn(SourceStart);
      
      // Skip over any whitespace we see here; we're looking for
      // another bit of interesting text.
      // FIXME: Detect non-ASCII whitespace characters too.
      while ((NewStart != 0) && isWhitespace(SourceLine.$at(NewStart))) {
        NewStart = map.startOfPreviousColumn(NewStart);
      }
      
      // Skip over this bit of "interesting" text.
      while ((NewStart != 0)) {
        /*uint*/int Prev = map.startOfPreviousColumn(NewStart);
        if (isWhitespace(SourceLine.$at(Prev))) {
          break;
        }
        NewStart = Prev;
      }
      assert (map.byteToColumn(NewStart) != -1);
      /*uint*/int NewColumns = map.byteToColumn(SourceEnd)
         - map.byteToColumn(NewStart);
      if ($lesseq_uint(NewColumns, TargetColumns)) {
        SourceStart = NewStart;
        ExpandedRegion = true;
      }
    }
    if ($less_uint(SourceEnd, SourceLine.size())) {
      /*uint*/int NewEnd = map.startOfNextColumn(SourceEnd);
      
      // Skip over any whitespace we see here; we're looking for
      // another bit of interesting text.
      // FIXME: Detect non-ASCII whitespace characters too.
      while ($less_uint(NewEnd, SourceLine.size()) && isWhitespace(SourceLine.$at(NewEnd))) {
        NewEnd = map.startOfNextColumn(NewEnd);
      }
      
      // Skip over this bit of "interesting" text.
      while ($less_uint(NewEnd, SourceLine.size()) && isWhitespace(SourceLine.$at(NewEnd))) {
        NewEnd = map.startOfNextColumn(NewEnd);
      }
      assert (map.byteToColumn(NewEnd) != -1);
      /*uint*/int NewColumns = map.byteToColumn(NewEnd)
         - map.byteToColumn(SourceStart);
      if ($lesseq_uint(NewColumns, TargetColumns)) {
        SourceEnd = NewEnd;
        ExpandedRegion = true;
      }
    }
    if (!ExpandedRegion) {
      break;
    }
  }
  
  CaretStart = map.byteToColumn(SourceStart);
  CaretEnd = map.byteToColumn(SourceEnd) + CaretColumnsOutsideSource;
  
  // [CaretStart, CaretEnd) is the slice we want. Update the various
  // output lines to show only this slice, with two-space padding
  // before the lines so that it looks nicer.
  assert (CaretStart != (/*uint*/int)-1 && CaretEnd != (/*uint*/int)-1 && SourceStart != (/*uint*/int)-1 && SourceEnd != (/*uint*/int)-1);
  assert ($lesseq_uint(SourceStart, SourceEnd));
  assert ($lesseq_uint(CaretStart, CaretEnd));
  
  /*uint*/int BackColumnsRemoved = map.byteToColumn(SourceLine.size()) - map.byteToColumn(SourceEnd);
  /*uint*/int FrontColumnsRemoved = CaretStart;
  /*uint*/int ColumnsKept = CaretEnd - CaretStart;
  
  // We checked up front that the line needed truncation
  assert ($greater_uint(FrontColumnsRemoved + ColumnsKept + BackColumnsRemoved, Columns));
  
  // The line needs some truncation, and we'd prefer to keep the front
  //  if possible, so remove the back
  if ($greater_uint(BackColumnsRemoved, strlen(back_ellipse))) {
    SourceLine.replace(SourceEnd, std.string.npos, back_ellipse);
  }
  
  // If that's enough then we're done
  if ($lesseq_uint(FrontColumnsRemoved + ColumnsKept, Columns)) {
    return;
  }
  
  // Otherwise remove the front as well
  if ($greater_uint(FrontColumnsRemoved, strlen(front_ellipse))) {
    SourceLine.replace(0, SourceStart, front_ellipse);
    CaretLine.replace(0, CaretStart, front_space);
    if (!FixItInsertionLine.empty()) {
      FixItInsertionLine.replace(0, CaretStart, front_space);
    }
  }
}


/// \brief Skip over whitespace in the string, starting at the given
/// index.
///
/// \returns The index of the first non-whitespace character that is
/// greater than or equal to Idx or, if no such character exists,
/// returns the end of the string.
//<editor-fold defaultstate="collapsed" desc="skipWhitespace">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/TextDiagnostic.cpp", line = 515,
 FQN="skipWhitespace", NM="_ZL14skipWhitespacejN4llvm9StringRefEj",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/TextDiagnostic.cpp -nm=_ZL14skipWhitespacejN4llvm9StringRefEj")
//</editor-fold>
public static /*uint*/int skipWhitespace(/*uint*/int Idx, StringRef Str, /*uint*/int Length) {
  while ($less_uint(Idx, Length) && isWhitespace(Str.$at(Idx))) {
    ++Idx;
  }
  return Idx;
}


/// \brief If the given character is the start of some kind of
/// balanced punctuation (e.g., quotes or parentheses), return the
/// character that will terminate the punctuation.
///
/// \returns The ending punctuation character, if any, or the NULL
/// character if the input character does not start any punctuation.
//<editor-fold defaultstate="collapsed" desc="findMatchingPunctuation">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/TextDiagnostic.cpp", line = 527,
 FQN="findMatchingPunctuation", NM="_ZL23findMatchingPunctuationc",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/TextDiagnostic.cpp -nm=_ZL23findMatchingPunctuationc")
//</editor-fold>
public static /*inline*/ /*char*/byte findMatchingPunctuation(/*char*/byte c) {
  switch (c) {
   case '\'':
    return $$SGL_QUOTE;
   case '`':
    return $$SGL_QUOTE;
   case '"':
    return $$DBL_QUOTE;
   case '(':
    return $$RPAREN;
   case '[':
    return $$RSQUARE;
   case '{':
    return $$RCURLY;
   default:
    break;
  }
  
  return 0;
}


/// \brief Find the end of the word starting at the given offset
/// within a string.
///
/// \returns the index pointing one character past the end of the
/// word.
//<editor-fold defaultstate="collapsed" desc="findEndOfWord">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/TextDiagnostic.cpp", line = 546,
 FQN="findEndOfWord", NM="_ZL13findEndOfWordjN4llvm9StringRefEjjj",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/TextDiagnostic.cpp -nm=_ZL13findEndOfWordjN4llvm9StringRefEjjj")
//</editor-fold>
public static /*uint*/int findEndOfWord(/*uint*/int Start, StringRef Str, 
             /*uint*/int Length, /*uint*/int Column, 
             /*uint*/int Columns) {
  assert ($less_uint(Start, Str.size())) : "Invalid start position!";
  /*uint*/int End = Start + 1;
  
  // If we are already at the end of the string, take that as the word.
  if (End == Str.size()) {
    return End;
  }
  
  // Determine if the start of the string is actually opening
  // punctuation, e.g., a quote or parentheses.
  /*char*/byte EndPunct = findMatchingPunctuation(Str.$at(Start));
  if (!(EndPunct != 0)) {
    // This is a normal word. Just find the first space character.
    while ($less_uint(End, Length) && !isWhitespace(Str.$at(End))) {
      ++End;
    }
    return End;
  }
  
  // We have the start of a balanced punctuation sequence (quotes,
  // parentheses, etc.). Determine the full sequence is.
  SmallString/*16*/ PunctuationEndStack/*J*/= new SmallString/*16*/(16);
  PunctuationEndStack.push_back(EndPunct);
  while ($less_uint(End, Length) && !PunctuationEndStack.empty()) {
    if (Str.$at(End) == PunctuationEndStack.back()) {
      PunctuationEndStack.pop_back();
    } else {
      /*char*/byte SubEndPunct = findMatchingPunctuation(Str.$at(End));
      if ((SubEndPunct != 0)) {
        PunctuationEndStack.push_back(SubEndPunct);
      }
    }
    
    ++End;
  }
  
  // Find the first space character after the punctuation ended.
  while ($less_uint(End, Length) && !isWhitespace(Str.$at(End))) {
    ++End;
  }
  
  /*uint*/int PunctWordLength = End - Start;
  if ($lesseq_uint(Column + PunctWordLength, Columns)
    // ... or the word is "short enough" to take up the next line
    // without too much ugly white space
     || $less_uint(PunctWordLength, Columns / 3)) {
    return End; // Take the whole thing as a single "word".
  }
  
  // The whole quoted/parenthesized string is too long to print as a
  // single "word". Instead, find the "word" that starts just after
  // the punctuation and use that end-point instead. This will recurse
  // until it finds something small enough to consider a word.
  return findEndOfWord(Start + 1, Str, Length, Column + 1, Columns);
}


/// \brief Print the given string to a stream, word-wrapping it to
/// some number of columns in the process.
///
/// \param OS the stream to which the word-wrapping string will be
/// emitted.
/// \param Str the string to word-wrap and output.
/// \param Columns the number of columns to word-wrap to.
/// \param Column the column number at which the first character of \p
/// Str will be printed. This will be non-zero when part of the first
/// line has already been printed.
/// \param Bold if the current text should be bold
/// \param Indentation the number of spaces to indent any lines beyond
/// the first line.
/// \returns true if word-wrapping was required, or false if the
/// string fit on the first line.
//<editor-fold defaultstate="collapsed" desc="printWordWrapped">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/TextDiagnostic.cpp", line = 613,
 FQN="printWordWrapped", NM="_ZL16printWordWrappedRN4llvm11raw_ostreamENS_9StringRefEjjbj",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/TextDiagnostic.cpp -nm=_ZL16printWordWrappedRN4llvm11raw_ostreamENS_9StringRefEjjbj")
//</editor-fold>
public static boolean printWordWrapped(raw_ostream /*&*/ OS, StringRef Str, 
                /*uint*/int Columns) {
  return printWordWrapped(OS, Str, 
                Columns, 
                0, 
                false, 
                WordWrapIndentation);
}
public static boolean printWordWrapped(raw_ostream /*&*/ OS, StringRef Str, 
                /*uint*/int Columns, 
                /*uint*/int Column/*= 0*/) {
  return printWordWrapped(OS, Str, 
                Columns, 
                Column, 
                false, 
                WordWrapIndentation);
}
public static boolean printWordWrapped(raw_ostream /*&*/ OS, StringRef Str, 
                /*uint*/int Columns, 
                /*uint*/int Column/*= 0*/, 
                boolean Bold/*= false*/) {
  return printWordWrapped(OS, Str, 
                Columns, 
                Column, 
                Bold, 
                WordWrapIndentation);
}
public static boolean printWordWrapped(raw_ostream /*&*/ OS, StringRef Str, 
                /*uint*/int Columns, 
                /*uint*/int Column/*= 0*/, 
                boolean Bold/*= false*/, 
                /*uint*/int Indentation/*= WordWrapIndentation*/) {
  /*const*//*uint*/int Length = std.min(Str.find($$LF), Str.size());
  bool$ref TextNormal = create_bool$ref(true);
  
  // The string used to indent each line.
  SmallString/*16*/ IndentStr/*J*/= new SmallString/*16*/(16);
  IndentStr.assign(Indentation, $$SPACE);
  boolean Wrapped = false;
  for (/*uint*/int WordStart = 0, WordEnd; $less_uint(WordStart, Length);
       WordStart = WordEnd) {
    // Find the beginning of the next word.
    WordStart = skipWhitespace(WordStart, Str, Length);
    if (WordStart == Length) {
      break;
    }
    
    // Find the end of this word.
    WordEnd = findEndOfWord(WordStart, Str, Length, Column, Columns);
    
    // Does this word fit on the current line?
    /*uint*/int WordLength = WordEnd - WordStart;
    if ($less_uint(Column + WordLength, Columns)) {
      // This word fits on the current line; print it there.
      if ((WordStart != 0)) {
        OS.$out_char($$SPACE);
        Column += 1;
      }
      applyTemplateHighlighting(OS, Str.substr(WordStart, WordLength), 
          TextNormal, Bold);
      Column += WordLength;
      continue;
    }
    
    // This word does not fit on the current line, so wrap to the next
    // line.
    OS.$out_char($$LF);
    OS.write(/*AddrOf*/IndentStr.data(), Indentation);
    applyTemplateHighlighting(OS, Str.substr(WordStart, WordLength), 
        TextNormal, Bold);
    Column = Indentation + WordLength;
    Wrapped = true;
  }
  
  // Append any remaning text from the message with its existing formatting.
  applyTemplateHighlighting(OS, Str.substr(Length), TextNormal, Bold);
  assert (TextNormal.$deref()) : "Text highlighted at end of diagnostic message.";
  
  return Wrapped;
}


/// \brief Highlight a SourceRange (with ~'s) for any characters on LineNo.
//<editor-fold defaultstate="collapsed" desc="highlightRange">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/TextDiagnostic.cpp", line = 915,
 old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/TextDiagnostic.cpp", old_line = 907,
 FQN="highlightRange", NM="_ZL14highlightRangeRKN5clang15CharSourceRangeEjNS_6FileIDERKN12_GLOBAL__N_115SourceColumnMapERSsRKNS_13SourceManagerERKNS_11LangOptionsE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/TextDiagnostic.cpp -nm=_ZL14highlightRangeRKN5clang15CharSourceRangeEjNS_6FileIDERKN12_GLOBAL__N_115SourceColumnMapERSsRKNS_13SourceManagerERKNS_11LangOptionsE")
//</editor-fold>
public static void highlightRange(/*const*/ CharSourceRange /*&*/ R, 
              /*uint*/int LineNo, FileID FID, 
              /*const*/ SourceColumnMap /*&*/ map, 
              std.string/*&*/ CaretLine, 
              /*const*/ SourceManager /*&*/ SM, 
              /*const*/ LangOptions /*&*/ LangOpts) {
  if (!R.isValid()) {
    return;
  }
  
  SourceLocation Begin = R.getBegin();
  SourceLocation End = R.getEnd();
  
  /*uint*/int StartLineNo = SM.getExpansionLineNumber(/*NO_COPY*/Begin);
  if ($greater_uint(StartLineNo, LineNo) || SM.getFileID(/*NO_COPY*/Begin).$noteq(FID)) {
    return; // No intersection.
  }
  
  /*uint*/int EndLineNo = SM.getExpansionLineNumber(/*NO_COPY*/End);
  if ($less_uint(EndLineNo, LineNo) || SM.getFileID(/*NO_COPY*/End).$noteq(FID)) {
    return; // No intersection.
  }
  
  // Compute the column number of the start.
  /*uint*/int StartColNo = 0;
  if (StartLineNo == LineNo) {
    StartColNo = SM.getExpansionColumnNumber(/*NO_COPY*/Begin);
    if ((StartColNo != 0)) {
      --StartColNo; // Zero base the col #.
    }
  }
  
  // Compute the column number of the end.
  /*uint*/int EndColNo = map.getSourceLine().size();
  if (EndLineNo == LineNo) {
    EndColNo = SM.getExpansionColumnNumber(/*NO_COPY*/End);
    if ((EndColNo != 0)) {
      --EndColNo; // Zero base the col #.
      
      // Add in the length of the token, so that we cover multi-char tokens if
      // this is a token range.
      if (R.isTokenRange()) {
        EndColNo += Lexer.MeasureTokenLength(/*NO_COPY*/End, SM, LangOpts);
      }
    } else {
      EndColNo = CaretLine.size();
    }
  }
  assert ($lesseq_uint(StartColNo, EndColNo)) : "Invalid range!";
  
  // Check that a token range does not highlight only whitespace.
  if (R.isTokenRange()) {
    // Pick the first non-whitespace column.
    while ($less_uint(StartColNo, map.getSourceLine().size())
       && (map.getSourceLine().$at(StartColNo) == $$SPACE
       || map.getSourceLine().$at(StartColNo) == $$TAB)) {
      StartColNo = map.startOfNextColumn(StartColNo);
    }
    
    // Pick the last non-whitespace column.
    if ($greater_uint(EndColNo, map.getSourceLine().size())) {
      EndColNo = map.getSourceLine().size();
    }
    while ((EndColNo != 0)
       && (map.getSourceLine().$at(EndColNo - 1) == $$SPACE
       || map.getSourceLine().$at(EndColNo - 1) == $$TAB)) {
      EndColNo = map.startOfPreviousColumn(EndColNo);
    }
    
    // If the start/end passed each other, then we are trying to highlight a
    // range that just exists in whitespace, which must be some sort of other
    // bug.
    assert ($lesseq_uint(StartColNo, EndColNo)) : "Trying to highlight whitespace??";
  }
  assert ($lesseq_uint(StartColNo, map.getSourceLine().size())) : "Invalid range!";
  assert ($lesseq_uint(EndColNo, map.getSourceLine().size())) : "Invalid range!";
  
  // Fill the range with ~'s.
  StartColNo = map.byteToContainingColumn(StartColNo);
  EndColNo = map.byteToContainingColumn(EndColNo);
  assert ($lesseq_uint(StartColNo, EndColNo)) : "Invalid range!";
  if ($less_uint(CaretLine.size(), EndColNo)) {
    CaretLine.resize(EndColNo, $$SPACE);
  }
  std.fill(CaretLine.begin().$add(StartColNo), CaretLine.begin().$add(EndColNo), $$TILDE);
}

//<editor-fold defaultstate="collapsed" desc="buildFixItInsertionLine">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/TextDiagnostic.cpp", line = 994,
 old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/TextDiagnostic.cpp", old_line = 986,
 FQN="buildFixItInsertionLine", NM="_ZL23buildFixItInsertionLinejRKN12_GLOBAL__N_115SourceColumnMapEN4llvm8ArrayRefIN5clang9FixItHintEEERKNS5_13SourceManagerEPKNS5_17DiagnosticOptionsE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/TextDiagnostic.cpp -nm=_ZL23buildFixItInsertionLinejRKN12_GLOBAL__N_115SourceColumnMapEN4llvm8ArrayRefIN5clang9FixItHintEEERKNS5_13SourceManagerEPKNS5_17DiagnosticOptionsE")
//</editor-fold>
public static std.string buildFixItInsertionLine(/*uint*/int LineNo, 
                       /*const*/ SourceColumnMap /*&*/ map, 
                       ArrayRef<FixItHint> Hints, 
                       /*const*/ SourceManager /*&*/ SM, 
                       /*const*/ DiagnosticOptions /*P*/ DiagOpts) {
  std.string FixItInsertionLine/*J*/= new std.string();
  if (Hints.empty() || !DiagOpts.ShowFixits) {
    return FixItInsertionLine;
  }
  /*uint*/int PrevHintEndCol = 0;
  
  for (type$ptr<FixItHint> I = $tryClone(Hints.begin()), /*P*/ E = Hints.end();
       I.$noteq(E); I.$preInc()) {
    if (!I.$star().CodeToInsert.empty()) {
      // We have an insertion hint. Determine whether the inserted
      // code contains no newlines and is on the same line as the caret.
      long/*<FileID, uint>*/ HintLocInfo = SM.getDecomposedExpansionLoc(I./*->*/$star().RemoveRange.getBegin().getRawEncoding());
      if (LineNo == SM.getLineNumber(/*NO_COPY*/$first_FileID(HintLocInfo), $second_offset(HintLocInfo))
         && new StringRef(I.$star().CodeToInsert).find_first_of(/*STRINGREF_STR*/"\n\015") == StringRef.npos) {
        // Insert the new code into the line just below the code
        // that the user wrote.
        // Note: When modifying this function, be very careful about what is a
        // "column" (printed width, platform-dependent) and what is a
        // "byte offset" (SourceManager "column").
        /*uint*/int HintByteOffset = SM.getColumnNumber(/*NO_COPY*/$first_FileID(HintLocInfo), $second_offset(HintLocInfo)) - 1;
        
        // The hint must start inside the source or right at the end
        assert ($less_uint(HintByteOffset, ((/*static_cast*//*uint*/int)(map.bytes())) + 1));
        /*uint*/int HintCol = map.byteToContainingColumn(HintByteOffset);
        
        // If we inserted a long previous hint, push this one forwards, and add
        // an extra space to show that this is not part of the previous
        // completion. This is sort of the best we can do when two hints appear
        // to overlap.
        //
        // Note that if this hint is located immediately after the previous
        // hint, no space will be added, since the location is more important.
        if ($less_uint(HintCol, PrevHintEndCol)) {
          HintCol = PrevHintEndCol + 1;
        }
        
        // This should NOT use HintByteOffset, because the source might have
        // Unicode characters in earlier columns.
        /*uint*/int NewFixItLineSize = FixItInsertionLine.size()
           + (HintCol - PrevHintEndCol) + I.$star().CodeToInsert.size();
        if ($greater_uint(NewFixItLineSize, FixItInsertionLine.size())) {
          FixItInsertionLine.resize(NewFixItLineSize, $$SPACE);
        }
        
        std.copy(I.$star().CodeToInsert.begin$Const(), I.$star().CodeToInsert.end$Const(), 
            FixItInsertionLine.end().$sub(I.$star().CodeToInsert.size()));
        
        PrevHintEndCol
           = HintCol + locale.columnWidth(new StringRef(I.$star().CodeToInsert));
      } else {
        FixItInsertionLine.clear();
        break;
      }
    }
  }
  
  expandTabs(FixItInsertionLine, DiagOpts.TabStop);
  
  return FixItInsertionLine;
}

} // END OF class TextDiagnosticStatics
