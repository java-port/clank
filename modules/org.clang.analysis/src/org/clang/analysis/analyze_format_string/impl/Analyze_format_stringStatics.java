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
package org.clang.analysis.analyze_format_string.impl;

import org.clank.support.*;
import org.clank.support.aliases.*;
import static org.clank.support.Casts.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import org.clang.basic.*;
import org.clang.analysis.analyses.analyze_format_string.*;
import org.clang.analysis.impl.*;
import static org.llvm.support.ConvertUTFGlobals.getNumBytesForUTF8;


//<editor-fold defaultstate="collapsed" desc="static type Analyze_format_stringStatics">
@Converted(kind = Converted.Kind.AUTO,
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/FormatString.cpp -nm=_ZN5clang21analyze_format_string11ParseAmountERPKcS2_;_ZN5clang21analyze_format_string15ParseFieldWidthERNS0_19FormatStringHandlerERNS0_15FormatSpecifierEPKcRS6_S6_Pj;_ZN5clang21analyze_format_string16ParseArgPositionERNS0_19FormatStringHandlerERNS0_15FormatSpecifierEPKcRS6_S6_;_ZN5clang21analyze_format_string19ParseLengthModifierERNS0_15FormatSpecifierERPKcS4_RKNS_11LangOptionsEb;_ZN5clang21analyze_format_string19ParsePositionAmountERNS0_19FormatStringHandlerEPKcRS4_S4_NS0_15PositionContextE;_ZN5clang21analyze_format_string22ParseNonPositionAmountERPKcS2_Rj;_ZN5clang21analyze_format_string25ParseUTF8InvalidSpecifierEPKcS2_Rj; -static-type=Analyze_format_stringStatics -package=org.clang.analysis.analyze_format_string.impl")
//</editor-fold>
public final class Analyze_format_stringStatics {


//===----------------------------------------------------------------------===//
// Functions for parsing format strings components in both printf and
// scanf format strings.
//===----------------------------------------------------------------------===//
//<editor-fold defaultstate="collapsed" desc="clang::analyze_format_string::ParseAmount">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/FormatString.cpp", line = 37,
 FQN="clang::analyze_format_string::ParseAmount", NM="_ZN5clang21analyze_format_string11ParseAmountERPKcS2_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/FormatString.cpp -nm=_ZN5clang21analyze_format_string11ParseAmountERPKcS2_")
//</editor-fold>
public static OptionalAmount ParseAmount(final char$ptr/*const char P &*/ Beg, /*const*/char$ptr/*char P*/ E) {
  UpdateOnReturn</*const*/char$ptr/*char P*/ > UpdateBeg = null;
  try {
    /*const*/char$ptr/*char P*/ I = $tryClone(Beg);
    UpdateBeg/*J*/= new UpdateOnReturn</*const*/char$ptr/*char P*/ >(Beg, I);
    
    /*uint*/int accumulator = 0;
    boolean hasDigits = false;
    
    for (; $noteq_ptr(I, E); I.$preInc()) {
      /*char*/byte c = I.$star();
      if (c >= $$0 && c <= $$9) {
        hasDigits = true;
        accumulator = (accumulator * 10) + (c - $$0);
        continue;
      }
      if (hasDigits) {
        return new OptionalAmount(OptionalAmount.HowSpecified.Constant, accumulator, Beg, I.$sub(Beg), 
            false);
      }
      
      break;
    }
    
    return new OptionalAmount();
  } finally {
    if (UpdateBeg != null) { UpdateBeg.$destroy(); }
  }
}

//<editor-fold defaultstate="collapsed" desc="clang::analyze_format_string::ParseNonPositionAmount">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/FormatString.cpp", line = 63,
 FQN="clang::analyze_format_string::ParseNonPositionAmount", NM="_ZN5clang21analyze_format_string22ParseNonPositionAmountERPKcS2_Rj",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/FormatString.cpp -nm=_ZN5clang21analyze_format_string22ParseNonPositionAmountERPKcS2_Rj")
//</editor-fold>
public static OptionalAmount ParseNonPositionAmount(final char$ptr/*const char P &*/ Beg, 
                      /*const*/char$ptr/*char P*/ E, 
                      final uint$ref/*uint &*/ argIndex) {
  if (Beg.$star() == $$STAR) {
    Beg.$preInc();
    return new OptionalAmount(OptionalAmount.HowSpecified.Arg, argIndex.$set$postInc(), Beg, 0, false);
  }
  
  return ParseAmount(Beg, E);
}

//<editor-fold defaultstate="collapsed" desc="clang::analyze_format_string::ParsePositionAmount">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/FormatString.cpp", line = 75,
 FQN="clang::analyze_format_string::ParsePositionAmount", NM="_ZN5clang21analyze_format_string19ParsePositionAmountERNS0_19FormatStringHandlerEPKcRS4_S4_NS0_15PositionContextE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/FormatString.cpp -nm=_ZN5clang21analyze_format_string19ParsePositionAmountERNS0_19FormatStringHandlerEPKcRS4_S4_NS0_15PositionContextE")
//</editor-fold>
public static OptionalAmount ParsePositionAmount(final FormatStringHandler /*&*/ H, 
                   /*const*/char$ptr/*char P*/ Start, 
                   final char$ptr/*const char P &*/ Beg, 
                   /*const*/char$ptr/*char P*/ E, 
                   PositionContext p) {
  if (Beg.$star() == $$STAR) {
    /*const*/char$ptr/*char P*/ I = $tryClone(Beg.$add(1));
    final /*const*/ OptionalAmount /*&*/ Amt = ParseAmount(I, E);
    if (Amt.getHowSpecified() == OptionalAmount.HowSpecified.NotSpecified) {
      H.HandleInvalidPosition(Beg, I.$sub(Beg), p);
      return new OptionalAmount(false);
    }
    if ($eq_ptr(I, E)) {
      // No more characters left?
      H.HandleIncompleteSpecifier(Start, E.$sub(Start));
      return new OptionalAmount(false);
    }
    assert (Amt.getHowSpecified() == OptionalAmount.HowSpecified.Constant);
    if (I.$star() == $$DOLLAR) {
      // Handle positional arguments
      
      // Special case: '*0$', since this is an easy mistake.
      if (Amt.getConstantAmount() == 0) {
        H.HandleZeroPosition(Beg, I.$sub(Beg) + 1);
        return new OptionalAmount(false);
      }
      
      /*const*/char$ptr/*char P*/ Tmp = $tryClone(Beg);
      Beg.$assign(I.$preInc());
      
      return new OptionalAmount(OptionalAmount.HowSpecified.Arg, Amt.getConstantAmount() - 1, 
          Tmp, 0, true);
    }
    
    H.HandleInvalidPosition(Beg, I.$sub(Beg), p);
    return new OptionalAmount(false);
  }
  
  return ParseAmount(Beg, E);
}

//<editor-fold defaultstate="collapsed" desc="clang::analyze_format_string::ParseFieldWidth">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/FormatString.cpp", line = 122,
 FQN="clang::analyze_format_string::ParseFieldWidth", NM="_ZN5clang21analyze_format_string15ParseFieldWidthERNS0_19FormatStringHandlerERNS0_15FormatSpecifierEPKcRS6_S6_Pj",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/FormatString.cpp -nm=_ZN5clang21analyze_format_string15ParseFieldWidthERNS0_19FormatStringHandlerERNS0_15FormatSpecifierEPKcRS6_S6_Pj")
//</editor-fold>
public static boolean ParseFieldWidth(final FormatStringHandler /*&*/ H, 
               final FormatSpecifier /*&*/ CS, 
               /*const*/char$ptr/*char P*/ Start, 
               final char$ptr/*const char P &*/ Beg, /*const*/char$ptr/*char P*/ E, 
               uint$ptr/*uint P*/ argIndex) {
  // FIXME: Support negative field widths.
  if (Native.$bool(argIndex)) {
    CS.setFieldWidth(ParseNonPositionAmount(Beg, E, argIndex.star$ref()));
  } else {
    /*const*/ OptionalAmount Amt = ParsePositionAmount(H, Start, Beg, E, 
        PositionContext.FieldWidthPos);
    if (Amt.isInvalid()) {
      return true;
    }
    CS.setFieldWidth(Amt);
  }
  return false;
}

//<editor-fold defaultstate="collapsed" desc="clang::analyze_format_string::ParseArgPosition">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/FormatString.cpp", line = 144,
 FQN="clang::analyze_format_string::ParseArgPosition", NM="_ZN5clang21analyze_format_string16ParseArgPositionERNS0_19FormatStringHandlerERNS0_15FormatSpecifierEPKcRS6_S6_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/FormatString.cpp -nm=_ZN5clang21analyze_format_string16ParseArgPositionERNS0_19FormatStringHandlerERNS0_15FormatSpecifierEPKcRS6_S6_")
//</editor-fold>
public static boolean ParseArgPosition(final FormatStringHandler /*&*/ H, 
                final FormatSpecifier /*&*/ FS, 
                /*const*/char$ptr/*char P*/ Start, 
                final char$ptr/*const char P &*/ Beg, 
                /*const*/char$ptr/*char P*/ E) {
  /*const*/char$ptr/*char P*/ I = $tryClone(Beg);
  
  final /*const*/ OptionalAmount /*&*/ Amt = ParseAmount(I, E);
  if ($eq_ptr(I, E)) {
    // No more characters left?
    H.HandleIncompleteSpecifier(Start, E.$sub(Start));
    return true;
  }
  if (Amt.getHowSpecified() == OptionalAmount.HowSpecified.Constant && (I.$postInc()).$star() == $$DOLLAR) {
    // Warn that positional arguments are non-standard.
    H.HandlePosition(Start, I.$sub(Start));
    
    // Special case: '%0$', since this is an easy mistake.
    if (Amt.getConstantAmount() == 0) {
      H.HandleZeroPosition(Start, I.$sub(Start));
      return true;
    }
    
    FS.setArgIndex(Amt.getConstantAmount() - 1);
    FS.setUsesPositionalArg();
    // Update the caller's pointer if we decided to consume
    // these characters.
    Beg.$assign(I);
    return false;
  }
  
  return false;
}


/// Returns true if a LengthModifier was parsed and installed in the
/// FormatSpecifier& argument, and false otherwise.
//<editor-fold defaultstate="collapsed" desc="clang::analyze_format_string::ParseLengthModifier">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/FormatString.cpp", line = 181,
 FQN="clang::analyze_format_string::ParseLengthModifier", NM="_ZN5clang21analyze_format_string19ParseLengthModifierERNS0_15FormatSpecifierERPKcS4_RKNS_11LangOptionsEb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/FormatString.cpp -nm=_ZN5clang21analyze_format_string19ParseLengthModifierERNS0_15FormatSpecifierERPKcS4_RKNS_11LangOptionsEb")
//</editor-fold>
public static boolean ParseLengthModifier(final FormatSpecifier /*&*/ FS, 
                   final char$ptr/*const char P &*/ I, 
                   /*const*/char$ptr/*char P*/ E, 
                   final /*const*/ LangOptions /*&*/ LO) {
  return ParseLengthModifier(FS, 
                   I, 
                   E, 
                   LO, 
                   false);
}
public static boolean ParseLengthModifier(final FormatSpecifier /*&*/ FS, 
                   final char$ptr/*const char P &*/ I, 
                   /*const*/char$ptr/*char P*/ E, 
                   final /*const*/ LangOptions /*&*/ LO, 
                   boolean IsScanf/*= false*/) {
  /*LengthModifier.Kind*/int lmKind = LengthModifier.Kind.None;
  /*const*/char$ptr/*char P*/ lmPosition = $tryClone(I);
  switch (I.$star()) {
   default:
    return false;
   case 'h':
    I.$preInc();
    if ($noteq_ptr(I, E) && I.$star() == $$h) {
      I.$preInc();
      lmKind = LengthModifier.Kind.AsChar;
    } else {
      lmKind = LengthModifier.Kind.AsShort;
    }
    break;
   case 'l':
    I.$preInc();
    if ($noteq_ptr(I, E) && I.$star() == $$l) {
      I.$preInc();
      lmKind = LengthModifier.Kind.AsLongLong;
    } else {
      lmKind = LengthModifier.Kind.AsLong;
    }
    break;
   case 'j':
    lmKind = LengthModifier.Kind.AsIntMax;
    I.$preInc();
    break;
   case 'z':
    lmKind = LengthModifier.Kind.AsSizeT;
    I.$preInc();
    break;
   case 't':
    lmKind = LengthModifier.Kind.AsPtrDiff;
    I.$preInc();
    break;
   case 'L':
    lmKind = LengthModifier.Kind.AsLongDouble;
    I.$preInc();
    break;
   case 'q':
    lmKind = LengthModifier.Kind.AsQuad;
    I.$preInc();
    break;
   case 'a':
    if (IsScanf && !LO.C99 && !LO.CPlusPlus11) {
      // For scanf in C90, look at the next character to see if this should
      // be parsed as the GNU extension 'a' length modifier. If not, this
      // will be parsed as a conversion specifier.
      I.$preInc();
      if ($noteq_ptr(I, E) && (I.$star() == $$s || I.$star() == $$S || I.$star() == $$LSQUARE)) {
        lmKind = LengthModifier.Kind.AsAllocate;
        break;
      }
      I.$preDec();
    }
    return false;
   case 'm':
    if (IsScanf) {
      lmKind = LengthModifier.Kind.AsMAllocate;
      I.$preInc();
      break;
    }
    return false;
   case 'I':
    // printf: AsInt64, AsInt32, AsInt3264
    // scanf:  AsInt64
    if ($noteq_ptr(I.$add(1), E) && $noteq_ptr(I.$add(2), E)) {
      if (I.$at(1) == $$6 && I.$at(2) == $$4) {
        I.$inc(3);
        lmKind = LengthModifier.Kind.AsInt64;
        break;
      }
      if (IsScanf) {
        return false;
      }
      if (I.$at(1) == $$3 && I.$at(2) == $$2) {
        I.$inc(3);
        lmKind = LengthModifier.Kind.AsInt32;
        break;
      }
    }
    I.$preInc();
    lmKind = LengthModifier.Kind.AsInt3264;
    break;
   case 'w':
    lmKind = LengthModifier.Kind.AsWide;
    I.$preInc();
    break;
  }
  LengthModifier lm/*J*/= new LengthModifier(lmPosition, lmKind);
  FS.setLengthModifier(new LengthModifier(lm));
  return true;
}


/// Returns true if the invalid specifier in \p SpecifierBegin is a UTF-8
/// string; check that it won't go further than \p FmtStrEnd and write
/// up the total size in \p Len.
//<editor-fold defaultstate="collapsed" desc="clang::analyze_format_string::ParseUTF8InvalidSpecifier">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/FormatString.cpp", line = 264,
 FQN="clang::analyze_format_string::ParseUTF8InvalidSpecifier", NM="_ZN5clang21analyze_format_string25ParseUTF8InvalidSpecifierEPKcS2_Rj",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/FormatString.cpp -nm=_ZN5clang21analyze_format_string25ParseUTF8InvalidSpecifierEPKcS2_Rj")
//</editor-fold>
public static boolean ParseUTF8InvalidSpecifier(/*const*/char$ptr/*char P*/ SpecifierBegin, /*const*/char$ptr/*char P*/ FmtStrEnd, final uint$ref/*uint &*/ Len) {
  if (SpecifierBegin.$add(1).$greatereq(FmtStrEnd)) {
    return false;
  }
  
  /*const*/char$ptr/*UTF8 P*/ SB = $tryClone(reinterpret_cast(/*const*/char$ptr/*UTF8 P*/ .class, SpecifierBegin.$add(1)));
  /*const*/char$ptr/*UTF8 P*/ SE = $tryClone(reinterpret_cast(/*const*/char$ptr/*UTF8 P*/ .class, FmtStrEnd));
  /*const*//*char*/byte FirstByte = SB.$star();
  
  // If the invalid specifier is a multibyte UTF-8 string, return the
  // total length accordingly so that the conversion specifier can be
  // properly updated to reflect a complete UTF-8 specifier.
  /*uint*/int NumBytes = getNumBytesForUTF8(FirstByte);
  if (NumBytes == 1) {
    return false;
  }
  if (SB.$add(NumBytes).$greater(SE)) {
    return false;
  }
  
  Len.$set(NumBytes + 1);
  return true;
}

} // END OF class Analyze_format_stringStatics
