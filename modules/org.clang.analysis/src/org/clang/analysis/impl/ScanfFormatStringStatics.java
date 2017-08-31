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
package org.clang.analysis.impl;

import org.clank.support.*;
import org.clank.support.aliases.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import org.clang.basic.*;
import org.clang.analysis.analyses.analyze_format_string.*;
import org.clang.analysis.impl.*;
import org.clang.analysis.analyses.analyze_scanf.*;
import org.clang.analysis.analyze_format_string.impl.*;
import org.clang.basic.target.TargetInfo;
import static org.clang.analysis.analyze_format_string.impl.Analyze_format_stringStatics.*;


//<editor-fold defaultstate="collapsed" desc="static type ScanfFormatStringStatics">
@Converted(kind = Converted.Kind.AUTO,
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ScanfFormatString.cpp -nm=_ZL13ParseScanListRN5clang21analyze_format_string19FormatStringHandlerERNS_13analyze_scanf24ScanfConversionSpecifierERPKcS7_;_ZL19ParseScanfSpecifierRN5clang21analyze_format_string19FormatStringHandlerERPKcS4_RjRKNS_11LangOptionsERKNS_10TargetInfoE; -static-type=ScanfFormatStringStatics -package=org.clang.analysis.impl")
//</editor-fold>
public final class ScanfFormatStringStatics {

//<editor-fold defaultstate="collapsed" desc="ParseScanList">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ScanfFormatString.cpp", line = 32,
 FQN="ParseScanList", NM="_ZL13ParseScanListRN5clang21analyze_format_string19FormatStringHandlerERNS_13analyze_scanf24ScanfConversionSpecifierERPKcS7_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ScanfFormatString.cpp -nm=_ZL13ParseScanListRN5clang21analyze_format_string19FormatStringHandlerERNS_13analyze_scanf24ScanfConversionSpecifierERPKcS7_")
//</editor-fold>
public static boolean ParseScanList(final FormatStringHandler /*&*/ H, 
             final ScanfConversionSpecifier /*&*/ CS, 
             final char$ptr/*const char P &*/ Beg, /*const*/char$ptr/*char P*/ E) {
  UpdateOnReturn</*const*/char$ptr/*char P*/ > UpdateBeg = null;
  try {
    /*const*/char$ptr/*char P*/ I = $tryClone(Beg);
    /*const*/char$ptr/*char P*/ start = $tryClone(I.$sub(1));
    UpdateBeg/*J*/= new UpdateOnReturn</*const*/char$ptr/*char P*/ >(Beg, I);
    
    // No more characters?
    if ($eq_ptr(I, E)) {
      H.HandleIncompleteScanList(start, I);
      return true;
    }
    
    // Special case: ']' is the first character.
    if (I.$star() == $$RSQUARE) {
      if ($eq_ptr(I.$preInc(), E)) {
        H.HandleIncompleteScanList(start, I.$sub(1));
        return true;
      }
    }
    
    // Special case: "^]" are the first characters.
    if ($noteq_ptr(I.$add(1), E) && I.$at(0) == $$CARET && I.$at(1) == $$RSQUARE) {
      I.$inc(2);
      if ($eq_ptr(I, E)) {
        H.HandleIncompleteScanList(start, I.$sub(1));
        return true;
      }
    }
    
    // Look for a ']' character which denotes the end of the scan list.
    while (I.$star() != $$RSQUARE) {
      if ($eq_ptr(I.$preInc(), E)) {
        H.HandleIncompleteScanList(start, I.$sub(1));
        return true;
      }
    }
    
    CS.setEndScanList(I);
    return false;
  } finally {
    if (UpdateBeg != null) { UpdateBeg.$destroy(); }
  }
}


// FIXME: Much of this is copy-paste from ParsePrintfSpecifier.
// We can possibly refactor.
//<editor-fold defaultstate="collapsed" desc="ParseScanfSpecifier">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ScanfFormatString.cpp", line = 76,
 FQN="ParseScanfSpecifier", NM="_ZL19ParseScanfSpecifierRN5clang21analyze_format_string19FormatStringHandlerERPKcS4_RjRKNS_11LangOptionsERKNS_10TargetInfoE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ScanfFormatString.cpp -nm=_ZL19ParseScanfSpecifierRN5clang21analyze_format_string19FormatStringHandlerERPKcS4_RjRKNS_11LangOptionsERKNS_10TargetInfoE")
//</editor-fold>
public static SpecifierResult<ScanfSpecifier> ParseScanfSpecifier(final FormatStringHandler /*&*/ H, 
                   final char$ptr/*const char P &*/ Beg, 
                   /*const*/char$ptr/*char P*/ E, 
                   final uint$ref/*uint &*/ argIndex, 
                   final /*const*/ LangOptions /*&*/ LO, 
                   final /*const*/ TargetInfo /*&*/ Target) {
  UpdateOnReturn</*const*/char$ptr/*char P*/ > UpdateBeg = null;
  try {
    //JAVA: using namespace clang::analyze_format_string;
    //JAVA: using namespace clang::analyze_scanf;
    /*const*/char$ptr/*char P*/ I = $tryClone(Beg);
    /*const*/char$ptr/*char P*/ Start = null;
    UpdateBeg/*J*/= new UpdateOnReturn</*const*/char$ptr/*char P*/ >(Beg, I);
    
    // Look for a '%' character that indicates the start of a format specifier.
    for (; $noteq_ptr(I, E); I.$preInc()) {
      /*char*/byte c = I.$star();
      if (c == $$TERM) {
        // Detect spurious null characters, which are likely errors.
        H.HandleNullChar(I);
        return new SpecifierResult<ScanfSpecifier>(true);
      }
      if (c == $$PERCENT) {
        Start = $tryClone(I.$postInc()); // Record the start of the format specifier.
        break;
      }
    }
    
    // No format specifier found?
    if (!Native.$bool(Start)) {
      return new SpecifierResult<ScanfSpecifier>(false);
    }
    if ($eq_ptr(I, E)) {
      // No more characters left?
      H.HandleIncompleteSpecifier(Start, E.$sub(Start));
      return new SpecifierResult<ScanfSpecifier>(true);
    }
    
    ScanfSpecifier FS/*J*/= new ScanfSpecifier();
    if (ParseArgPosition(H, FS, Start, I, E)) {
      return new SpecifierResult<ScanfSpecifier>(true);
    }
    if ($eq_ptr(I, E)) {
      // No more characters left?
      H.HandleIncompleteSpecifier(Start, E.$sub(Start));
      return new SpecifierResult<ScanfSpecifier>(true);
    }
    
    // Look for '*' flag if it is present.
    if (I.$star() == $$STAR) {
      FS.setSuppressAssignment(I);
      if ($eq_ptr(I.$preInc(), E)) {
        H.HandleIncompleteSpecifier(Start, E.$sub(Start));
        return new SpecifierResult<ScanfSpecifier>(true);
      }
    }
    
    // Look for the field width (if any).  Unlike printf, this is either
    // a fixed integer or isn't present.
    final /*const*/ OptionalAmount /*&*/ Amt = Analyze_format_stringStatics.ParseAmount(I, E);
    if (Amt.getHowSpecified() != OptionalAmount.HowSpecified.NotSpecified) {
      assert (Amt.getHowSpecified() == OptionalAmount.HowSpecified.Constant);
      FS.setFieldWidth(Amt);
      if ($eq_ptr(I, E)) {
        // No more characters left?
        H.HandleIncompleteSpecifier(Start, E.$sub(Start));
        return new SpecifierResult<ScanfSpecifier>(true);
      }
    }
    
    // Look for the length modifier.
    if (ParseLengthModifier(FS, I, E, LO, /*scanf=*/ true) && $eq_ptr(I, E)) {
      // No more characters left?
      H.HandleIncompleteSpecifier(Start, E.$sub(Start));
      return new SpecifierResult<ScanfSpecifier>(true);
    }
    
    // Detect spurious null characters, which are likely errors.
    if (I.$star() == $$TERM) {
      H.HandleNullChar(I);
      return new SpecifierResult<ScanfSpecifier>(true);
    }
    
    // Finally, look for the conversion specifier.
    /*const*/char$ptr/*char P*/ conversionPosition = $tryClone(I.$postInc());
    ScanfConversionSpecifier.Kind k = ScanfConversionSpecifier.Kind.InvalidSpecifier;
    switch (conversionPosition.$star()) {
     default:
      break;
     case '%':
      k = ConversionSpecifier.Kind.PercentArg;
      break;
     case 'A':
      k = ConversionSpecifier.Kind.AArg;
      break;
     case 'E':
      k = ConversionSpecifier.Kind.EArg;
      break;
     case 'F':
      k = ConversionSpecifier.Kind.FArg;
      break;
     case 'G':
      k = ConversionSpecifier.Kind.GArg;
      break;
     case 'X':
      k = ConversionSpecifier.Kind.XArg;
      break;
     case 'a':
      k = ConversionSpecifier.Kind.aArg;
      break;
     case 'd':
      k = ConversionSpecifier.Kind.dArg;
      break;
     case 'e':
      k = ConversionSpecifier.Kind.eArg;
      break;
     case 'f':
      k = ConversionSpecifier.Kind.fArg;
      break;
     case 'g':
      k = ConversionSpecifier.Kind.gArg;
      break;
     case 'i':
      k = ConversionSpecifier.Kind.iArg;
      break;
     case 'n':
      k = ConversionSpecifier.Kind.nArg;
      break;
     case 'c':
      k = ConversionSpecifier.Kind.cArg;
      break;
     case 'C':
      k = ConversionSpecifier.Kind.CArg;
      break;
     case 'S':
      k = ConversionSpecifier.Kind.SArg;
      break;
     case '[':
      k = ConversionSpecifier.Kind.ScanListArg;
      break;
     case 'u':
      k = ConversionSpecifier.Kind.uArg;
      break;
     case 'x':
      k = ConversionSpecifier.Kind.xArg;
      break;
     case 'o':
      k = ConversionSpecifier.Kind.oArg;
      break;
     case 's':
      k = ConversionSpecifier.Kind.sArg;
      break;
     case 'p':
      k = ConversionSpecifier.Kind.pArg;
      break;
     case 'D':
      // Apple extensions
      // Apple-specific
      if (Target.getTriple().isOSDarwin()) {
        k = ConversionSpecifier.Kind.DArg;
      }
      break;
     case 'O':
      if (Target.getTriple().isOSDarwin()) {
        k = ConversionSpecifier.Kind.OArg;
      }
      break;
     case 'U':
      if (Target.getTriple().isOSDarwin()) {
        k = ConversionSpecifier.Kind.UArg;
      }
      break;
    }
    ScanfConversionSpecifier CS/*J*/= new ScanfConversionSpecifier(conversionPosition, k);
    if (k == ScanfConversionSpecifier.Kind.ScanListArg) {
      if (ParseScanList(H, CS, I, E)) {
        return new SpecifierResult<ScanfSpecifier>(true);
      }
    }
    FS.setConversionSpecifier(CS);
    if (CS.consumesDataArgument() && !FS.getSuppressAssignment().$bool()
       && !FS.usesPositionalArg()) {
      FS.setArgIndex(argIndex.$set$postInc());
    }
    
    // FIXME: '%' and '*' doesn't make sense.  Issue a warning.
    // FIXME: 'ConsumedSoFar' and '*' doesn't make sense.
    if (k == ScanfConversionSpecifier.Kind.InvalidSpecifier) {
      uint$ref Len = create_uint$ref(I.$sub(Beg));
      if (ParseUTF8InvalidSpecifier(Beg, E, Len)) {
        CS.setEndScanList(Beg.$add(Len.$deref()));
        FS.setConversionSpecifier(CS);
      }
      // Assume the conversion takes one argument.
      return new SpecifierResult<ScanfSpecifier>(!H.HandleInvalidScanfConversionSpecifier(FS, Beg, Len.$deref()));
    }
    return new SpecifierResult<ScanfSpecifier>(Start, FS);
  } finally {
    if (UpdateBeg != null) { UpdateBeg.$destroy(); }
  }
}

} // END OF class ScanfFormatStringStatics
