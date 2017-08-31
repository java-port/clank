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

import static org.clank.support.Native.$AddrOf;
import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.llvm.support.sys.*;


//<editor-fold defaultstate="collapsed" desc="static type SourceMgrStatics">
@Converted(kind = Converted.Kind.AUTO,
 NM="org.llvm.support.impl.SourceMgrStatics",
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/SourceMgr.cpp -nm=_ZL10isNonASCIIc;_ZL14buildFixItLineRNSt7__cxx1112basic_stringIcSt11char_traitsIcESaIcEEES5_N4llvm8ArrayRefINS6_7SMFixItEEENS7_IcEE;_ZL15printSourceLineRN4llvm11raw_ostreamENS_9StringRefE;_ZL7TabStop;_ZL8getCachePv; -static-type=SourceMgrStatics -package=org.llvm.support.impl")
//</editor-fold>
public final class SourceMgrStatics {

//<editor-fold defaultstate="collapsed" desc="TabStop">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/Support/SourceMgr.cpp", line = 24,
 FQN="TabStop", NM="_ZL7TabStop",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/SourceMgr.cpp -nm=_ZL7TabStop")
//</editor-fold>
public static /*const*//*size_t*/int TabStop = 8;
//<editor-fold defaultstate="collapsed" desc="getCache">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/Support/SourceMgr.cpp", line = 34,
 FQN="getCache", NM="_ZL8getCachePv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/SourceMgr.cpp -nm=_ZL8getCachePv")
//</editor-fold>
public static LineNoCacheTy /*P*/ getCache(Object/*void P*/ Ptr) {
  return (LineNoCacheTy /*P*/ )Ptr;
}

//<editor-fold defaultstate="collapsed" desc="buildFixItLine">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/lib/Support/SourceMgr.cpp", line = 243,
 FQN="buildFixItLine", NM="_ZL14buildFixItLineRSsS_N4llvm8ArrayRefINS0_7SMFixItEEENS1_IcEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/SourceMgr.cpp -nm=_ZL14buildFixItLineRSsS_N4llvm8ArrayRefINS0_7SMFixItEEENS1_IcEE")
//</editor-fold>
public static void buildFixItLine(final std.string/*&*/ CaretLine, final std.string/*&*/ FixItLine, 
              ArrayRef<SMFixIt> FixIts, ArrayRefChar SourceLine) {
  if (FixIts.empty()) {
    return;
  }
  
  /*const*/char$ptr/*char P*/ LineStart = $tryClone(SourceLine.begin());
  /*const*/char$ptr/*char P*/ LineEnd = $tryClone(SourceLine.end());
  
  /*size_t*/int PrevHintEndCol = 0;
  
  for (type$ptr<SMFixIt> I = $tryClone(FixIts.begin()), /*P*/ E = $tryClone(FixIts.end());
       $noteq_ptr(I, E); I.$preInc()) {
    // If the fixit contains a newline or tab, ignore it.
    if (I./*->*/$star().getText().find_first_of(/*STRINGREF_STR*/"\n\015\t") != StringRef.npos) {
      continue;
    }
    
    SMRange R = I./*->*/$star().getRange();
    
    // If the line doesn't contain any part of the range, then ignore it.
    if (R.Start.getPointer().$greater(LineEnd) || R.End.getPointer().$less(LineStart)) {
      continue;
    }
    
    // Translate from SMLoc to column.
    // Ignore pieces of the range that go onto other lines.
    // FIXME: Handle multibyte characters in the source line.
    /*uint*/int FirstCol;
    if (R.Start.getPointer().$less(LineStart)) {
      FirstCol = 0;
    } else {
      FirstCol = R.Start.getPointer().$sub(LineStart);
    }
    
    // If we inserted a long previous hint, push this one forwards, and add
    // an extra space to show that this is not part of the previous
    // completion. This is sort of the best we can do when two hints appear
    // to overlap.
    //
    // Note that if this hint is located immediately after the previous
    // hint, no space will be added, since the location is more important.
    /*uint*/int HintCol = FirstCol;
    if ($less_uint(HintCol, PrevHintEndCol)) {
      HintCol = PrevHintEndCol + 1;
    }
    
    // FIXME: This assertion is intended to catch unintended use of multibyte
    // characters in fixits. If we decide to do this, we'll have to track
    // separate byte widths for the source and fixit lines.
    assert ((/*size_t*/int)locale.columnWidth(I./*->*/$star().getText()) == I./*->*/$star().getText().size());
    
    // This relies on one byte per column in our fixit hints.
    /*uint*/int LastColumnModified = HintCol + I./*->*/$star().getText().size();
    if ($greater_uint(LastColumnModified, FixItLine.size())) {
      FixItLine.resize(LastColumnModified, $$SPACE);
    }
    
    std.copy(I./*->*/$star().getText().begin(), I./*->*/$star().getText().end(), 
        FixItLine.begin().$add(HintCol));
    
    PrevHintEndCol = LastColumnModified;
    
    // For replacements, mark the removal range with '~'.
    // FIXME: Handle multibyte characters in the source line.
    /*uint*/int LastCol;
    if (R.End.getPointer().$greatereq(LineEnd)) {
      LastCol = LineEnd.$sub(LineStart);
    } else {
      LastCol = R.End.getPointer().$sub(LineStart);
    }
    
    std.fill($AddrOf(CaretLine.ptr$at(FirstCol)), $AddrOf(CaretLine.ptr$at(LastCol)), $$TILDE);
  }
}

//<editor-fold defaultstate="collapsed" desc="printSourceLine">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/Support/SourceMgr.cpp", line = 313,
 FQN="printSourceLine", NM="_ZL15printSourceLineRN4llvm11raw_ostreamENS_9StringRefE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/SourceMgr.cpp -nm=_ZL15printSourceLineRN4llvm11raw_ostreamENS_9StringRefE")
//</editor-fold>
public static void printSourceLine(final raw_ostream /*&*/ S, StringRef LineContents) {
  // Print out the source line one character at a time, so we can expand tabs.
  for (/*uint*/int i = 0, e = LineContents.size(), OutCol = 0; i != e; ++i) {
    if (LineContents.$at(i) != $$TAB) {
      S.$out_char(LineContents.$at(i));
      ++OutCol;
      continue;
    }
    
    // If we have a tab, emit at least one space, then round up to 8 columns.
    do {
      S.$out_char($$SPACE);
      ++OutCol;
    } while (($rem_uint(OutCol, TabStop)) != 0);
  }
  S.$out_char($$LF);
}

//<editor-fold defaultstate="collapsed" desc="isNonASCII">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/Support/SourceMgr.cpp", line = 331,
 FQN="isNonASCII", NM="_ZL10isNonASCIIc",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/SourceMgr.cpp -nm=_ZL10isNonASCIIc")
//</editor-fold>
public static boolean isNonASCII(/*char*/byte c) {
  return ((c & 0x80) != 0);
}

} // END OF class SourceMgrStatics
