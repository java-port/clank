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
import static org.llvm.support.llvm.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import org.llvm.adt.*;
import org.clang.basic.*;
import org.clang.analysis.analyses.analyze_format_string.*;
import org.clang.analysis.impl.*;
import org.clang.analysis.analyze_format_string.impl.*;
import static org.clang.analysis.impl.PrintfFormatStringStatics.*;
import org.clang.basic.target.TargetInfo;
import static org.clang.analysis.analyze_format_string.impl.Analyze_format_stringStatics.*;
import org.clang.analysis.analyses.analyze_printf.*;


//<editor-fold defaultstate="collapsed" desc="static type PrintfFormatStringStatics">
@Converted(kind = Converted.Kind.AUTO,
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/PrintfFormatString.cpp -nm=_ZL14ParseObjCFlagsRN5clang21analyze_format_string19FormatStringHandlerERNS_14analyze_printf15PrintfSpecifierEPKcS7_b;_ZL14ParsePrecisionRN5clang21analyze_format_string19FormatStringHandlerERNS_14analyze_printf15PrintfSpecifierEPKcRS7_S7_Pj;_ZL20ParsePrintfSpecifierRN5clang21analyze_format_string19FormatStringHandlerERPKcS4_RjRKNS_11LangOptionsERKNS_10TargetInfoEbb; -static-type=PrintfFormatStringStatics -package=org.clang.analysis.impl")
//</editor-fold>
public final class PrintfFormatStringStatics {

//<editor-fold defaultstate="collapsed" desc="ParsePrecision">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/PrintfFormatString.cpp", line = 37,
 FQN="ParsePrecision", NM="_ZL14ParsePrecisionRN5clang21analyze_format_string19FormatStringHandlerERNS_14analyze_printf15PrintfSpecifierEPKcRS7_S7_Pj",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/PrintfFormatString.cpp -nm=_ZL14ParsePrecisionRN5clang21analyze_format_string19FormatStringHandlerERNS_14analyze_printf15PrintfSpecifierEPKcRS7_S7_Pj")
//</editor-fold>
public static boolean ParsePrecision(final FormatStringHandler /*&*/ H, final PrintfSpecifier /*&*/ FS, 
              /*const*/char$ptr/*char P*/ Start, final char$ptr/*const char P &*/ Beg, /*const*/char$ptr/*char P*/ E, 
              uint$ptr/*uint P*/ argIndex) {
  if (Native.$bool(argIndex)) {
    FS.setPrecision(ParseNonPositionAmount(Beg, E, argIndex.star$ref()));
  } else {
    /*const*/ OptionalAmount Amt = ParsePositionAmount(H, Start, Beg, E, 
        /*analyze_format_string.*/PositionContext.PrecisionPos);
    if (Amt.isInvalid()) {
      return true;
    }
    FS.setPrecision(Amt);
  }
  return false;
}

//<editor-fold defaultstate="collapsed" desc="ParseObjCFlags">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/PrintfFormatString.cpp", line = 52,
 FQN="ParseObjCFlags", NM="_ZL14ParseObjCFlagsRN5clang21analyze_format_string19FormatStringHandlerERNS_14analyze_printf15PrintfSpecifierEPKcS7_b",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/PrintfFormatString.cpp -nm=_ZL14ParseObjCFlagsRN5clang21analyze_format_string19FormatStringHandlerERNS_14analyze_printf15PrintfSpecifierEPKcS7_b")
//</editor-fold>
public static boolean ParseObjCFlags(final FormatStringHandler /*&*/ H, final PrintfSpecifier /*&*/ FS, 
              /*const*/char$ptr/*char P*/ FlagBeg, /*const*/char$ptr/*char P*/ E, boolean Warn) {
  StringRef Flag/*J*/= new StringRef(FlagBeg, E.$sub(FlagBeg));
  // Currently there is only one flag.
  if ($eq_StringRef(/*NO_COPY*/Flag, /*STRINGREF_STR*/"tt")) {
    FS.setHasObjCTechnicalTerm(FlagBeg);
    return false;
  }
  // Handle either the case of no flag or an invalid flag.
  if (Warn) {
    if ($eq_StringRef(/*NO_COPY*/Flag, /*STRINGREF_STR*/"")) {
      H.HandleEmptyObjCModifierFlag(FlagBeg, E.$sub(FlagBeg));
    } else {
      H.HandleInvalidObjCModifierFlag(FlagBeg, E.$sub(FlagBeg));
    }
  }
  return true;
}

//<editor-fold defaultstate="collapsed" desc="ParsePrintfSpecifier">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/PrintfFormatString.cpp", line = 70,
 FQN="ParsePrintfSpecifier", NM="_ZL20ParsePrintfSpecifierRN5clang21analyze_format_string19FormatStringHandlerERPKcS4_RjRKNS_11LangOptionsERKNS_10TargetInfoEbb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/PrintfFormatString.cpp -nm=_ZL20ParsePrintfSpecifierRN5clang21analyze_format_string19FormatStringHandlerERPKcS4_RjRKNS_11LangOptionsERKNS_10TargetInfoEbb")
//</editor-fold>
public static SpecifierResult<PrintfSpecifier> ParsePrintfSpecifier(final FormatStringHandler /*&*/ H, 
                    final char$ptr/*const char P &*/ Beg, 
                    /*const*/char$ptr/*char P*/ E, 
                    final uint$ref/*uint &*/ argIndex, 
                    final /*const*/ LangOptions /*&*/ LO, 
                    final /*const*/ TargetInfo /*&*/ Target, 
                    boolean Warn, 
                    boolean isFreeBSDKPrintf) {
  UpdateOnReturn</*const*/char$ptr/*char P*/ > UpdateBeg = null;
  try {
    
    //JAVA: using namespace clang::analyze_format_string;
    //JAVA: using namespace clang::analyze_printf;
    
    /*const*/char$ptr/*char P*/ I = $tryClone(Beg);
    /*const*/char$ptr/*char P*/ Start = null;
    UpdateBeg/*J*/= new UpdateOnReturn</*const*/char$ptr/*char P*/ >(Beg, I);
    
    // Look for a '%' character that indicates the start of a format specifier.
    for (; $noteq_ptr(I, E); I.$preInc()) {
      /*char*/byte c = I.$star();
      if (c == $$TERM) {
        // Detect spurious null characters, which are likely errors.
        H.HandleNullChar(I);
        return new SpecifierResult<PrintfSpecifier>(true);
      }
      if (c == $$PERCENT) {
        Start = $tryClone(I.$postInc()); // Record the start of the format specifier.
        break;
      }
    }
    
    // No format specifier found?
    if (!Native.$bool(Start)) {
      return new SpecifierResult<PrintfSpecifier>(false);
    }
    if ($eq_ptr(I, E)) {
      // No more characters left?
      if (Warn) {
        H.HandleIncompleteSpecifier(Start, E.$sub(Start));
      }
      return new SpecifierResult<PrintfSpecifier>(true);
    }
    
    PrintfSpecifier FS/*J*/= new PrintfSpecifier();
    if (ParseArgPosition(H, FS, Start, I, E)) {
      return new SpecifierResult<PrintfSpecifier>(true);
    }
    if ($eq_ptr(I, E)) {
      // No more characters left?
      if (Warn) {
        H.HandleIncompleteSpecifier(Start, E.$sub(Start));
      }
      return new SpecifierResult<PrintfSpecifier>(true);
    }
    
    // Look for flags (if any).
    boolean hasMore = true;
    for (; $noteq_ptr(I, E); I.$preInc()) {
      switch (I.$star()) {
       default:
        hasMore = false;
        break;
       case '\'':
        // FIXME: POSIX specific.  Always accept?
        FS.setHasThousandsGrouping(I);
        break;
       case '-':
        FS.setIsLeftJustified(I);
        break;
       case '+':
        FS.setHasPlusPrefix(I);
        break;
       case ' ':
        FS.setHasSpacePrefix(I);
        break;
       case '#':
        FS.setHasAlternativeForm(I);
        break;
       case '0':
        FS.setHasLeadingZeros(I);
        break;
      }
      if (!hasMore) {
        break;
      }
    }
    if ($eq_ptr(I, E)) {
      // No more characters left?
      if (Warn) {
        H.HandleIncompleteSpecifier(Start, E.$sub(Start));
      }
      return new SpecifierResult<PrintfSpecifier>(true);
    }
    
    // Look for the field width (if any).
    if (ParseFieldWidth(H, FS, Start, I, E, 
        FS.usesPositionalArg() ? (uint$ptr/*uint P*/ )null : argIndex.deref$ptr())) {
      return new SpecifierResult<PrintfSpecifier>(true);
    }
    if ($eq_ptr(I, E)) {
      // No more characters left?
      if (Warn) {
        H.HandleIncompleteSpecifier(Start, E.$sub(Start));
      }
      return new SpecifierResult<PrintfSpecifier>(true);
    }
    
    // Look for the precision (if any).
    if (I.$star() == $$DOT) {
      I.$preInc();
      if ($eq_ptr(I, E)) {
        if (Warn) {
          H.HandleIncompleteSpecifier(Start, E.$sub(Start));
        }
        return new SpecifierResult<PrintfSpecifier>(true);
      }
      if (ParsePrecision(H, FS, Start, I, E, 
          FS.usesPositionalArg() ? (uint$ptr/*uint P*/ )null : argIndex.deref$ptr())) {
        return new SpecifierResult<PrintfSpecifier>(true);
      }
      if ($eq_ptr(I, E)) {
        // No more characters left?
        if (Warn) {
          H.HandleIncompleteSpecifier(Start, E.$sub(Start));
        }
        return new SpecifierResult<PrintfSpecifier>(true);
      }
    }
    
    // Look for the length modifier.
    if (ParseLengthModifier(FS, I, E, LO) && $eq_ptr(I, E)) {
      // No more characters left?
      if (Warn) {
        H.HandleIncompleteSpecifier(Start, E.$sub(Start));
      }
      return new SpecifierResult<PrintfSpecifier>(true);
    }
    
    // Look for the Objective-C modifier flags, if any.
    // We parse these here, even if they don't apply to
    // the conversion specifier, and then emit an error
    // later if the conversion specifier isn't '@'.  This
    // enables better recovery, and we don't know if
    // these flags are applicable until later.
    /*const*/char$ptr/*char P*/ ObjCModifierFlagsStart = null;
    /*const*/char$ptr/*char P*/ ObjCModifierFlagsEnd = null;
    if (I.$star() == $$LSQUARE) {
      ObjCModifierFlagsStart = $tryClone(I);
      I.$preInc();
      /*const*/char$ptr/*char P*/ flagStart = $tryClone(I);
      for (;; I.$preInc()) {
        ObjCModifierFlagsEnd = $tryClone(I);
        if ($eq_ptr(I, E)) {
          if (Warn) {
            H.HandleIncompleteSpecifier(Start, E.$sub(Start));
          }
          return new SpecifierResult<PrintfSpecifier>(true);
        }
        // Did we find the closing ']'?
        if (I.$star() == $$RSQUARE) {
          if (ParseObjCFlags(H, FS, flagStart, I, Warn)) {
            return new SpecifierResult<PrintfSpecifier>(true);
          }
          I.$preInc();
          break;
        }
        // There are no separators defined yet for multiple
        // Objective-C modifier flags.  When those are
        // defined, this is the place to check.
      }
    }
    if (I.$star() == $$TERM) {
      // Detect spurious null characters, which are likely errors.
      H.HandleNullChar(I);
      return new SpecifierResult<PrintfSpecifier>(true);
    }
    
    // Finally, look for the conversion specifier.
    /*const*/char$ptr/*char P*/ conversionPosition = $tryClone(I.$postInc());
    ConversionSpecifier.Kind k = ConversionSpecifier.Kind.InvalidSpecifier;
    switch (conversionPosition.$star()) {
     default:
      break;
     case '%':
      // C99: 7.19.6.1 (section 8).
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
     case 'c':
      k = ConversionSpecifier.Kind.cArg;
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
     case 'o':
      k = ConversionSpecifier.Kind.oArg;
      break;
     case 'p':
      k = ConversionSpecifier.Kind.pArg;
      break;
     case 's':
      k = ConversionSpecifier.Kind.sArg;
      break;
     case 'u':
      k = ConversionSpecifier.Kind.uArg;
      break;
     case 'x':
      k = ConversionSpecifier.Kind.xArg;
      break;
     case 'C':
      // POSIX specific.
      k = ConversionSpecifier.Kind.CArg;
      break;
     case 'S':
      k = ConversionSpecifier.Kind.SArg;
      break;
     case '@':
      k = ConversionSpecifier.Kind.ObjCObjArg;
      break;
     case 'm':
      // Glibc specific.
      k = ConversionSpecifier.Kind.PrintErrno;
      break;
     case 'b':
      // FreeBSD kernel specific.
      if (isFreeBSDKPrintf) {
        k = ConversionSpecifier.Kind.FreeBSDbArg; // int followed by char *
      }
      break;
     case 'r':
      if (isFreeBSDKPrintf) {
        k = ConversionSpecifier.Kind.FreeBSDrArg; // int
      }
      break;
     case 'y':
      if (isFreeBSDKPrintf) {
        k = ConversionSpecifier.Kind.FreeBSDyArg; // int
      }
      break;
     case 'D':
      // Apple-specific.
      if (isFreeBSDKPrintf) {
        k = ConversionSpecifier.Kind.FreeBSDDArg; // void * followed by char *
      } else if (Target.getTriple().isOSDarwin()) {
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
     case 'Z':
      // MS specific.
      if (Target.getTriple().isOSMSVCRT()) {
        k = ConversionSpecifier.Kind.ZArg;
      }
    }
    
    // Check to see if we used the Objective-C modifier flags with
    // a conversion specifier other than '@'.
    if (k != ConversionSpecifier.Kind.ObjCObjArg
       && k != ConversionSpecifier.Kind.InvalidSpecifier
       && Native.$bool(ObjCModifierFlagsStart)) {
      H.HandleObjCFlagsWithNonObjCConversion(ObjCModifierFlagsStart, 
          ObjCModifierFlagsEnd.$add(1), 
          conversionPosition);
      return new SpecifierResult<PrintfSpecifier>(true);
    }
    
    PrintfConversionSpecifier CS/*J*/= new PrintfConversionSpecifier(conversionPosition, k);
    FS.setConversionSpecifier(CS);
    if (CS.consumesDataArgument() && !FS.usesPositionalArg()) {
      FS.setArgIndex(argIndex.$set$postInc());
    }
    // FreeBSD kernel specific.
    if (k == ConversionSpecifier.Kind.FreeBSDbArg
       || k == ConversionSpecifier.Kind.FreeBSDDArg) {
      argIndex.$set$postInc();
    }
    if (k == ConversionSpecifier.Kind.InvalidSpecifier) {
      uint$ref Len = create_uint$ref(I.$sub(Start));
      if (ParseUTF8InvalidSpecifier(Start, E, Len)) {
        CS.setEndScanList(Start.$add(Len.$deref()));
        FS.setConversionSpecifier(CS);
      }
      // Assume the conversion takes one argument.
      return new SpecifierResult<PrintfSpecifier>(!H.HandleInvalidPrintfConversionSpecifier(FS, Start, Len.$deref()));
    }
    return new SpecifierResult<PrintfSpecifier>(Start, FS);
  } finally {
    if (UpdateBeg != null) { UpdateBeg.$destroy(); }
  }
}

} // END OF class PrintfFormatStringStatics
