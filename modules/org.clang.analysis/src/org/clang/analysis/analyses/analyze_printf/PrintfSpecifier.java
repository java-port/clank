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

package org.clang.analysis.analyses.analyze_printf;

import org.clank.support.*;
import org.clank.support.aliases.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.support.NativePointer.*;
import org.llvm.support.*;
import org.clang.ast.*;
import org.clang.basic.*;
import org.clang.analysis.analyses.analyze_format_string.*;
import static org.clang.analysis.java.AnalysisRTTI.cast_PrintfConversionSpecifier;
import static org.clang.ast.java.AstTypesRTTI.*;


//<editor-fold defaultstate="collapsed" desc="clang::analyze_printf::PrintfSpecifier">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/FormatString.h", line = 432,
 FQN="clang::analyze_printf::PrintfSpecifier", NM="_ZN5clang14analyze_printf15PrintfSpecifierE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/PrintfFormatString.cpp -nm=_ZN5clang14analyze_printf15PrintfSpecifierE")
//</editor-fold>
public class PrintfSpecifier extends /*public*/ FormatSpecifier {
  private OptionalFlag HasThousandsGrouping; // ''', POSIX extension.
  private OptionalFlag IsLeftJustified; // '-'
  private OptionalFlag HasPlusPrefix; // '+'
  private OptionalFlag HasSpacePrefix; // ' '
  private OptionalFlag HasAlternativeForm; // '#'
  private OptionalFlag HasLeadingZeroes; // '0'
  private OptionalFlag HasObjCTechnicalTerm; // '[tt]'
  private OptionalAmount Precision;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::analyze_printf::PrintfSpecifier::PrintfSpecifier">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/FormatString.h", line = 442,
   FQN="clang::analyze_printf::PrintfSpecifier::PrintfSpecifier", NM="_ZN5clang14analyze_printf15PrintfSpecifierC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/PrintfFormatString.cpp -nm=_ZN5clang14analyze_printf15PrintfSpecifierC1Ev")
  //</editor-fold>
  public PrintfSpecifier() {
    // : FormatSpecifier(/* isPrintf = */ true), HasThousandsGrouping("'"), IsLeftJustified("-"), HasPlusPrefix("+"), HasSpacePrefix(" "), HasAlternativeForm("#"), HasLeadingZeroes("0"), HasObjCTechnicalTerm("tt"), Precision() 
    //START JInit
    super(true);
    this.HasThousandsGrouping = new OptionalFlag($SGL_QUOTE);
    this.IsLeftJustified = new OptionalFlag($MINUS);
    this.HasPlusPrefix = new OptionalFlag($PLUS);
    this.HasSpacePrefix = new OptionalFlag($SPACE);
    this.HasAlternativeForm = new OptionalFlag($HASH);
    this.HasLeadingZeroes = new OptionalFlag($0);
    this.HasObjCTechnicalTerm = new OptionalFlag($("tt"));
    this.Precision = new OptionalAmount();
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::analyze_printf::PrintfSpecifier::Parse">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/FormatString.h", line = 448,
   FQN="clang::analyze_printf::PrintfSpecifier::Parse", NM="_ZN5clang14analyze_printf15PrintfSpecifier5ParseEPKcS3_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/PrintfFormatString.cpp -nm=_ZN5clang14analyze_printf15PrintfSpecifier5ParseEPKcS3_")
  //</editor-fold>
  public static PrintfSpecifier Parse(/*const*/char$ptr/*char P*/ beg, /*const*/char$ptr/*char P*/ end) {
    throw new UnsupportedOperationException("<<<DeclJavaPrinter::VisitFunctionDecl NULL BODY IN USED Translation Unit>>>");
  }


  
  // Methods for incrementally constructing the PrintfSpecifier.
  //<editor-fold defaultstate="collapsed" desc="clang::analyze_printf::PrintfSpecifier::setConversionSpecifier">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/FormatString.h", line = 451,
   FQN="clang::analyze_printf::PrintfSpecifier::setConversionSpecifier", NM="_ZN5clang14analyze_printf15PrintfSpecifier22setConversionSpecifierERKNS0_25PrintfConversionSpecifierE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/PrintfFormatString.cpp -nm=_ZN5clang14analyze_printf15PrintfSpecifier22setConversionSpecifierERKNS0_25PrintfConversionSpecifierE")
  //</editor-fold>
  public void setConversionSpecifier(final /*const*/ PrintfConversionSpecifier /*&*/ cs) {
    CS.$assign(cs);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::analyze_printf::PrintfSpecifier::setHasThousandsGrouping">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/FormatString.h", line = 454,
   FQN="clang::analyze_printf::PrintfSpecifier::setHasThousandsGrouping", NM="_ZN5clang14analyze_printf15PrintfSpecifier23setHasThousandsGroupingEPKc",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/PrintfFormatString.cpp -nm=_ZN5clang14analyze_printf15PrintfSpecifier23setHasThousandsGroupingEPKc")
  //</editor-fold>
  public void setHasThousandsGrouping(/*const*/char$ptr/*char P*/ position) {
    HasThousandsGrouping.setPosition(position);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::analyze_printf::PrintfSpecifier::setIsLeftJustified">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/FormatString.h", line = 457,
   FQN="clang::analyze_printf::PrintfSpecifier::setIsLeftJustified", NM="_ZN5clang14analyze_printf15PrintfSpecifier18setIsLeftJustifiedEPKc",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/PrintfFormatString.cpp -nm=_ZN5clang14analyze_printf15PrintfSpecifier18setIsLeftJustifiedEPKc")
  //</editor-fold>
  public void setIsLeftJustified(/*const*/char$ptr/*char P*/ position) {
    IsLeftJustified.setPosition(position);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::analyze_printf::PrintfSpecifier::setHasPlusPrefix">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/FormatString.h", line = 460,
   FQN="clang::analyze_printf::PrintfSpecifier::setHasPlusPrefix", NM="_ZN5clang14analyze_printf15PrintfSpecifier16setHasPlusPrefixEPKc",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/PrintfFormatString.cpp -nm=_ZN5clang14analyze_printf15PrintfSpecifier16setHasPlusPrefixEPKc")
  //</editor-fold>
  public void setHasPlusPrefix(/*const*/char$ptr/*char P*/ position) {
    HasPlusPrefix.setPosition(position);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::analyze_printf::PrintfSpecifier::setHasSpacePrefix">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/FormatString.h", line = 463,
   FQN="clang::analyze_printf::PrintfSpecifier::setHasSpacePrefix", NM="_ZN5clang14analyze_printf15PrintfSpecifier17setHasSpacePrefixEPKc",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/PrintfFormatString.cpp -nm=_ZN5clang14analyze_printf15PrintfSpecifier17setHasSpacePrefixEPKc")
  //</editor-fold>
  public void setHasSpacePrefix(/*const*/char$ptr/*char P*/ position) {
    HasSpacePrefix.setPosition(position);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::analyze_printf::PrintfSpecifier::setHasAlternativeForm">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/FormatString.h", line = 466,
   FQN="clang::analyze_printf::PrintfSpecifier::setHasAlternativeForm", NM="_ZN5clang14analyze_printf15PrintfSpecifier21setHasAlternativeFormEPKc",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/PrintfFormatString.cpp -nm=_ZN5clang14analyze_printf15PrintfSpecifier21setHasAlternativeFormEPKc")
  //</editor-fold>
  public void setHasAlternativeForm(/*const*/char$ptr/*char P*/ position) {
    HasAlternativeForm.setPosition(position);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::analyze_printf::PrintfSpecifier::setHasLeadingZeros">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/FormatString.h", line = 469,
   FQN="clang::analyze_printf::PrintfSpecifier::setHasLeadingZeros", NM="_ZN5clang14analyze_printf15PrintfSpecifier18setHasLeadingZerosEPKc",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/PrintfFormatString.cpp -nm=_ZN5clang14analyze_printf15PrintfSpecifier18setHasLeadingZerosEPKc")
  //</editor-fold>
  public void setHasLeadingZeros(/*const*/char$ptr/*char P*/ position) {
    HasLeadingZeroes.setPosition(position);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::analyze_printf::PrintfSpecifier::setHasObjCTechnicalTerm">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/FormatString.h", line = 472,
   FQN="clang::analyze_printf::PrintfSpecifier::setHasObjCTechnicalTerm", NM="_ZN5clang14analyze_printf15PrintfSpecifier23setHasObjCTechnicalTermEPKc",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/PrintfFormatString.cpp -nm=_ZN5clang14analyze_printf15PrintfSpecifier23setHasObjCTechnicalTermEPKc")
  //</editor-fold>
  public void setHasObjCTechnicalTerm(/*const*/char$ptr/*char P*/ position) {
    HasObjCTechnicalTerm.setPosition(position);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::analyze_printf::PrintfSpecifier::setUsesPositionalArg">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/FormatString.h", line = 475,
   FQN="clang::analyze_printf::PrintfSpecifier::setUsesPositionalArg", NM="_ZN5clang14analyze_printf15PrintfSpecifier20setUsesPositionalArgEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/PrintfFormatString.cpp -nm=_ZN5clang14analyze_printf15PrintfSpecifier20setUsesPositionalArgEv")
  //</editor-fold>
  public void setUsesPositionalArg() {
    UsesPositionalArg = true;
  }

  
  // Methods for querying the format specifier.
  //<editor-fold defaultstate="collapsed" desc="clang::analyze_printf::PrintfSpecifier::getConversionSpecifier">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/FormatString.h", line = 479,
   FQN="clang::analyze_printf::PrintfSpecifier::getConversionSpecifier", NM="_ZNK5clang14analyze_printf15PrintfSpecifier22getConversionSpecifierEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/PrintfFormatString.cpp -nm=_ZNK5clang14analyze_printf15PrintfSpecifier22getConversionSpecifierEv")
  //</editor-fold>
  public /*const*/ PrintfConversionSpecifier /*&*/ getConversionSpecifier() /*const*/ {
    return cast_PrintfConversionSpecifier(CS);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::analyze_printf::PrintfSpecifier::setPrecision">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/FormatString.h", line = 483,
   FQN="clang::analyze_printf::PrintfSpecifier::setPrecision", NM="_ZN5clang14analyze_printf15PrintfSpecifier12setPrecisionERKNS_21analyze_format_string14OptionalAmountE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/PrintfFormatString.cpp -nm=_ZN5clang14analyze_printf15PrintfSpecifier12setPrecisionERKNS_21analyze_format_string14OptionalAmountE")
  //</editor-fold>
  public void setPrecision(final /*const*/ OptionalAmount /*&*/ Amt) {
    Precision.$assign(Amt);
    Precision.setUsesDotPrefix();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::analyze_printf::PrintfSpecifier::getPrecision">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/FormatString.h", line = 488,
   FQN="clang::analyze_printf::PrintfSpecifier::getPrecision", NM="_ZNK5clang14analyze_printf15PrintfSpecifier12getPrecisionEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/PrintfFormatString.cpp -nm=_ZNK5clang14analyze_printf15PrintfSpecifier12getPrecisionEv")
  //</editor-fold>
  public /*const*/ OptionalAmount /*&*/ getPrecision() /*const*/ {
    return Precision;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::analyze_printf::PrintfSpecifier::consumesDataArgument">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/FormatString.h", line = 492,
   FQN="clang::analyze_printf::PrintfSpecifier::consumesDataArgument", NM="_ZNK5clang14analyze_printf15PrintfSpecifier20consumesDataArgumentEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/PrintfFormatString.cpp -nm=_ZNK5clang14analyze_printf15PrintfSpecifier20consumesDataArgumentEv")
  //</editor-fold>
  public boolean consumesDataArgument() /*const*/ {
    return getConversionSpecifier().consumesDataArgument();
  }

  
  /// \brief Returns the builtin type that a data argument
  /// paired with this format specifier should have.  This method
  /// will return null if the format specifier does not have
  /// a matching data argument or the matching argument matches
  /// more than one type.
  
  //===----------------------------------------------------------------------===//
  // Methods on PrintfSpecifier.
  //===----------------------------------------------------------------------===//
  //<editor-fold defaultstate="collapsed" desc="clang::analyze_printf::PrintfSpecifier::getArgType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/PrintfFormatString.cpp", line = 390,
   FQN="clang::analyze_printf::PrintfSpecifier::getArgType", NM="_ZNK5clang14analyze_printf15PrintfSpecifier10getArgTypeERNS_10ASTContextEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/PrintfFormatString.cpp -nm=_ZNK5clang14analyze_printf15PrintfSpecifier10getArgTypeERNS_10ASTContextEb")
  //</editor-fold>
  public ArgType getArgType(final ASTContext /*&*/ Ctx, 
            boolean IsObjCLiteral) /*const*/ {
    final /*const*/ PrintfConversionSpecifier /*&*/ CS = getConversionSpecifier();
    if (!CS.consumesDataArgument()) {
      return ArgType.Invalid();
    }
    if (CS.getKind() == ConversionSpecifier.Kind.cArg) {
      switch (LM.getKind()) {
       case LengthModifier.Kind.None:
        return new ArgType(new CanQual<Type>(Ctx.IntTy));
       case LengthModifier.Kind.AsLong:
       case LengthModifier.Kind.AsWide:
        return new ArgType(ArgType.Kind.WIntTy, $("wint_t"));
       case LengthModifier.Kind.AsShort:
        if (Ctx.getTargetInfo().getTriple().isOSMSVCRT()) {
          return new ArgType(new CanQual<Type>(Ctx.IntTy));
        }
       default:
        return ArgType.Invalid();
      }
    }
    if (CS.isIntArg()) {
      switch (LM.getKind()) {
       case LengthModifier.Kind.AsLongDouble:
        // GNU extension.
        return new ArgType(new CanQual<Type>(Ctx.LongLongTy));
       case LengthModifier.Kind.None:
        return new ArgType(new CanQual<Type>(Ctx.IntTy));
       case LengthModifier.Kind.AsInt32:
        return new ArgType(Ctx.IntTy.$QualType(), $__int32);
       case LengthModifier.Kind.AsChar:
        return new ArgType(ArgType.Kind.AnyCharTy);
       case LengthModifier.Kind.AsShort:
        return new ArgType(new CanQual<Type>(Ctx.ShortTy));
       case LengthModifier.Kind.AsLong:
        return new ArgType(new CanQual<Type>(Ctx.LongTy));
       case LengthModifier.Kind.AsLongLong:
       case LengthModifier.Kind.AsQuad:
        return new ArgType(new CanQual<Type>(Ctx.LongLongTy));
       case LengthModifier.Kind.AsInt64:
        return new ArgType(Ctx.LongLongTy.$QualType(), $__int64);
       case LengthModifier.Kind.AsIntMax:
        return new ArgType(Ctx.getIntMaxType().$QualType(), $("intmax_t"));
       case LengthModifier.Kind.AsSizeT:
        // FIXME: How to get the corresponding signed version of size_t?
        return new ArgType();
       case LengthModifier.Kind.AsInt3264:
        return Ctx.getTargetInfo().getTriple().isArch64Bit() ? new ArgType(Ctx.LongLongTy.$QualType(), $__int64) : new ArgType(Ctx.IntTy.$QualType(), $__int32);
       case LengthModifier.Kind.AsPtrDiff:
        return new ArgType(Ctx.getPointerDiffType(), $("ptrdiff_t"));
       case LengthModifier.Kind.AsAllocate:
       case LengthModifier.Kind.AsMAllocate:
       case LengthModifier.Kind.AsWide:
        return ArgType.Invalid();
      }
    }
    if (CS.isUIntArg()) {
      switch (LM.getKind()) {
       case LengthModifier.Kind.AsLongDouble:
        // GNU extension.
        return new ArgType(new CanQual<Type>(Ctx.UnsignedLongLongTy));
       case LengthModifier.Kind.None:
        return new ArgType(new CanQual<Type>(Ctx.UnsignedIntTy));
       case LengthModifier.Kind.AsInt32:
        return new ArgType(Ctx.UnsignedIntTy.$QualType(), $("unsigned __int32"));
       case LengthModifier.Kind.AsChar:
        return new ArgType(new CanQual<Type>(Ctx.UnsignedCharTy));
       case LengthModifier.Kind.AsShort:
        return new ArgType(new CanQual<Type>(Ctx.UnsignedShortTy));
       case LengthModifier.Kind.AsLong:
        return new ArgType(new CanQual<Type>(Ctx.UnsignedLongTy));
       case LengthModifier.Kind.AsLongLong:
       case LengthModifier.Kind.AsQuad:
        return new ArgType(new CanQual<Type>(Ctx.UnsignedLongLongTy));
       case LengthModifier.Kind.AsInt64:
        return new ArgType(Ctx.UnsignedLongLongTy.$QualType(), $("unsigned __int64"));
       case LengthModifier.Kind.AsIntMax:
        return new ArgType(Ctx.getUIntMaxType().$QualType(), $("uintmax_t"));
       case LengthModifier.Kind.AsSizeT:
        return new ArgType(Ctx.getSizeType().$QualType(), $("size_t"));
       case LengthModifier.Kind.AsInt3264:
        return Ctx.getTargetInfo().getTriple().isArch64Bit() ? new ArgType(Ctx.UnsignedLongLongTy.$QualType(), $("unsigned __int64")) : new ArgType(Ctx.UnsignedIntTy.$QualType(), $("unsigned __int32"));
       case LengthModifier.Kind.AsPtrDiff:
        // FIXME: How to get the corresponding unsigned
        // version of ptrdiff_t?
        return new ArgType();
       case LengthModifier.Kind.AsAllocate:
       case LengthModifier.Kind.AsMAllocate:
       case LengthModifier.Kind.AsWide:
        return ArgType.Invalid();
      }
    }
    if (CS.isDoubleArg()) {
      if (LM.getKind() == LengthModifier.Kind.AsLongDouble) {
        return new ArgType(new CanQual<Type>(Ctx.LongDoubleTy));
      }
      return new ArgType(new CanQual<Type>(Ctx.DoubleTy));
    }
    if (CS.getKind() == ConversionSpecifier.Kind.nArg) {
      switch (LM.getKind()) {
       case LengthModifier.Kind.None:
        return ArgType.PtrTo(new ArgType(new CanQual<Type>(Ctx.IntTy)));
       case LengthModifier.Kind.AsChar:
        return ArgType.PtrTo(new ArgType(new CanQual<Type>(Ctx.SignedCharTy)));
       case LengthModifier.Kind.AsShort:
        return ArgType.PtrTo(new ArgType(new CanQual<Type>(Ctx.ShortTy)));
       case LengthModifier.Kind.AsLong:
        return ArgType.PtrTo(new ArgType(new CanQual<Type>(Ctx.LongTy)));
       case LengthModifier.Kind.AsLongLong:
       case LengthModifier.Kind.AsQuad:
        return ArgType.PtrTo(new ArgType(new CanQual<Type>(Ctx.LongLongTy)));
       case LengthModifier.Kind.AsIntMax:
        return ArgType.PtrTo(new ArgType(Ctx.getIntMaxType().$QualType(), $("intmax_t")));
       case LengthModifier.Kind.AsSizeT:
        return new ArgType(); // FIXME: ssize_t
       case LengthModifier.Kind.AsPtrDiff:
        return ArgType.PtrTo(new ArgType(Ctx.getPointerDiffType(), $("ptrdiff_t")));
       case LengthModifier.Kind.AsLongDouble:
        return new ArgType(); // FIXME: Is this a known extension?
       case LengthModifier.Kind.AsAllocate:
       case LengthModifier.Kind.AsMAllocate:
       case LengthModifier.Kind.AsInt32:
       case LengthModifier.Kind.AsInt3264:
       case LengthModifier.Kind.AsInt64:
       case LengthModifier.Kind.AsWide:
        return ArgType.Invalid();
      }
    }
    switch (CS.getKind()) {
     case sArg:
      if (LM.getKind() == LengthModifier.Kind.AsWideChar) {
        if (IsObjCLiteral) {
          return new ArgType(Ctx.getPointerType(Ctx.UnsignedShortTy.withConst()), 
              $("const unichar *"));
        }
        return new ArgType(ArgType.Kind.WCStrTy, $("wchar_t *"));
      }
      if (LM.getKind() == LengthModifier.Kind.AsWide) {
        return new ArgType(ArgType.Kind.WCStrTy, $("wchar_t *"));
      }
      return new ArgType(ArgType.Kind.CStrTy);
     case SArg:
      if (IsObjCLiteral) {
        return new ArgType(Ctx.getPointerType(Ctx.UnsignedShortTy.withConst()), 
            $("const unichar *"));
      }
      if (Ctx.getTargetInfo().getTriple().isOSMSVCRT()
         && LM.getKind() == LengthModifier.Kind.AsShort) {
        return new ArgType(ArgType.Kind.CStrTy);
      }
      return new ArgType(ArgType.Kind.WCStrTy, $("wchar_t *"));
     case CArg:
      if (IsObjCLiteral) {
        return new ArgType(Ctx.UnsignedShortTy.$QualType(), $("unichar"));
      }
      if (Ctx.getTargetInfo().getTriple().isOSMSVCRT()
         && LM.getKind() == LengthModifier.Kind.AsShort) {
        return new ArgType(new CanQual<Type>(Ctx.IntTy));
      }
      return new ArgType(Ctx.WideCharTy.$QualType(), $wchar_t);
     case pArg:
      return new ArgType(ArgType.Kind.CPointerTy);
     case ObjCObjArg:
      return new ArgType(ArgType.Kind.ObjCPointerTy);
     default:
      break;
    }
    
    // FIXME: Handle other cases.
    return new ArgType();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::analyze_printf::PrintfSpecifier::hasThousandsGrouping">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/FormatString.h", line = 503,
   FQN="clang::analyze_printf::PrintfSpecifier::hasThousandsGrouping", NM="_ZNK5clang14analyze_printf15PrintfSpecifier20hasThousandsGroupingEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/PrintfFormatString.cpp -nm=_ZNK5clang14analyze_printf15PrintfSpecifier20hasThousandsGroupingEv")
  //</editor-fold>
  public /*const*/ OptionalFlag /*&*/ hasThousandsGrouping() /*const*/ {
    return HasThousandsGrouping;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::analyze_printf::PrintfSpecifier::isLeftJustified">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/FormatString.h", line = 506,
   FQN="clang::analyze_printf::PrintfSpecifier::isLeftJustified", NM="_ZNK5clang14analyze_printf15PrintfSpecifier15isLeftJustifiedEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/PrintfFormatString.cpp -nm=_ZNK5clang14analyze_printf15PrintfSpecifier15isLeftJustifiedEv")
  //</editor-fold>
  public /*const*/ OptionalFlag /*&*/ isLeftJustified() /*const*/ {
    return IsLeftJustified;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::analyze_printf::PrintfSpecifier::hasPlusPrefix">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/FormatString.h", line = 507,
   FQN="clang::analyze_printf::PrintfSpecifier::hasPlusPrefix", NM="_ZNK5clang14analyze_printf15PrintfSpecifier13hasPlusPrefixEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/PrintfFormatString.cpp -nm=_ZNK5clang14analyze_printf15PrintfSpecifier13hasPlusPrefixEv")
  //</editor-fold>
  public /*const*/ OptionalFlag /*&*/ hasPlusPrefix() /*const*/ {
    return HasPlusPrefix;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::analyze_printf::PrintfSpecifier::hasAlternativeForm">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/FormatString.h", line = 508,
   FQN="clang::analyze_printf::PrintfSpecifier::hasAlternativeForm", NM="_ZNK5clang14analyze_printf15PrintfSpecifier18hasAlternativeFormEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/PrintfFormatString.cpp -nm=_ZNK5clang14analyze_printf15PrintfSpecifier18hasAlternativeFormEv")
  //</editor-fold>
  public /*const*/ OptionalFlag /*&*/ hasAlternativeForm() /*const*/ {
    return HasAlternativeForm;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::analyze_printf::PrintfSpecifier::hasLeadingZeros">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/FormatString.h", line = 509,
   FQN="clang::analyze_printf::PrintfSpecifier::hasLeadingZeros", NM="_ZNK5clang14analyze_printf15PrintfSpecifier15hasLeadingZerosEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/PrintfFormatString.cpp -nm=_ZNK5clang14analyze_printf15PrintfSpecifier15hasLeadingZerosEv")
  //</editor-fold>
  public /*const*/ OptionalFlag /*&*/ hasLeadingZeros() /*const*/ {
    return HasLeadingZeroes;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::analyze_printf::PrintfSpecifier::hasSpacePrefix">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/FormatString.h", line = 510,
   FQN="clang::analyze_printf::PrintfSpecifier::hasSpacePrefix", NM="_ZNK5clang14analyze_printf15PrintfSpecifier14hasSpacePrefixEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/PrintfFormatString.cpp -nm=_ZNK5clang14analyze_printf15PrintfSpecifier14hasSpacePrefixEv")
  //</editor-fold>
  public /*const*/ OptionalFlag /*&*/ hasSpacePrefix() /*const*/ {
    return HasSpacePrefix;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::analyze_printf::PrintfSpecifier::hasObjCTechnicalTerm">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/FormatString.h", line = 511,
   FQN="clang::analyze_printf::PrintfSpecifier::hasObjCTechnicalTerm", NM="_ZNK5clang14analyze_printf15PrintfSpecifier20hasObjCTechnicalTermEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/PrintfFormatString.cpp -nm=_ZNK5clang14analyze_printf15PrintfSpecifier20hasObjCTechnicalTermEv")
  //</editor-fold>
  public /*const*/ OptionalFlag /*&*/ hasObjCTechnicalTerm() /*const*/ {
    return HasObjCTechnicalTerm;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::analyze_printf::PrintfSpecifier::usesPositionalArg">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/FormatString.h", line = 512,
   FQN="clang::analyze_printf::PrintfSpecifier::usesPositionalArg", NM="_ZNK5clang14analyze_printf15PrintfSpecifier17usesPositionalArgEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/PrintfFormatString.cpp -nm=_ZNK5clang14analyze_printf15PrintfSpecifier17usesPositionalArgEv")
  //</editor-fold>
  public boolean usesPositionalArg() /*const*/ {
    return UsesPositionalArg;
  }

  
  /// Changes the specifier and length according to a QualType, retaining any
  /// flags or options. Returns true on success, or false when a conversion
  /// was not successful.
  //<editor-fold defaultstate="collapsed" desc="clang::analyze_printf::PrintfSpecifier::fixType">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/PrintfFormatString.cpp", line = 555,
   FQN="clang::analyze_printf::PrintfSpecifier::fixType", NM="_ZN5clang14analyze_printf15PrintfSpecifier7fixTypeENS_8QualTypeERKNS_11LangOptionsERNS_10ASTContextEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/PrintfFormatString.cpp -nm=_ZN5clang14analyze_printf15PrintfSpecifier7fixTypeENS_8QualTypeERKNS_11LangOptionsERNS_10ASTContextEb")
  //</editor-fold>
  public boolean fixType(QualType QT, final /*const*/ LangOptions /*&*/ LangOpt, 
         final ASTContext /*&*/ Ctx, boolean IsObjCLiteral) {
    // %n is different from other conversion specifiers; don't try to fix it.
    if (CS.getKind() == ConversionSpecifier.Kind.nArg) {
      return false;
    }
    
    // Handle Objective-C objects first. Note that while the '%@' specifier will
    // not warn for structure pointer or void pointer arguments (because that's
    // how CoreFoundation objects are implemented), we only show a fixit for '%@'
    // if we know it's an object (block, id, class, or __attribute__((NSObject))).
    if (QT.$arrow().isObjCRetainableType()) {
      if (!IsObjCLiteral) {
        return false;
      }
      
      CS.setKind(ConversionSpecifier.Kind.ObjCObjArg);
      
      // Disable irrelevant flags
      HasThousandsGrouping.$assign(/*KEEP_BOOL*/false);
      HasPlusPrefix.$assign(/*KEEP_BOOL*/false);
      HasSpacePrefix.$assign(/*KEEP_BOOL*/false);
      HasAlternativeForm.$assign(/*KEEP_BOOL*/false);
      HasLeadingZeroes.$assign(/*KEEP_BOOL*/false);
      Precision.setHowSpecified(OptionalAmount.HowSpecified.NotSpecified);
      LM.setKind(LengthModifier.Kind.None);
      
      return true;
    }
    
    // Handle strings next (char *, wchar_t *)
    if (QT.$arrow().isPointerType() && (QT.$arrow().getPointeeType().$arrow().isAnyCharacterType())) {
      CS.setKind(ConversionSpecifier.Kind.sArg);
      
      // Disable irrelevant flags
      HasAlternativeForm.$assign(/*KEEP_BOOL*/false);
      HasLeadingZeroes.$assign(/*KEEP_BOOL*/false);
      
      // Set the long length modifier for wide characters
      if (QT.$arrow().getPointeeType().$arrow().isWideCharType()) {
        LM.setKind(LengthModifier.Kind.AsWideChar);
      } else {
        LM.setKind(LengthModifier.Kind.None);
      }
      
      return true;
    }
    {
      
      // If it's an enum, get its underlying type.
      /*const*/ EnumType /*P*/ ETy = QT.$arrow().getAs$EnumType();
      if ((ETy != null)) {
        QT.$assignMove(ETy.getDecl().getIntegerType());
      }
    }
    
    // We can only work with builtin types.
    /*const*/ BuiltinType /*P*/ BT = QT.$arrow().getAs$BuiltinType();
    if (!(BT != null)) {
      return false;
    }
    
    // Set length modifier
    switch (BT.getKind()) {
     case Bool:
     case WChar_U:
     case WChar_S:
     case Char16:
     case Char32:
     case UInt128:
     case Int128:
     case Half:
     case Float128:
      // Various types which are non-trivial to correct.
      return false;
     case OCLImage1dRO:
     case OCLImage1dArrayRO:
     case OCLImage1dBufferRO:
     case OCLImage2dRO:
     case OCLImage2dArrayRO:
     case OCLImage2dDepthRO:
     case OCLImage2dArrayDepthRO:
     case OCLImage2dMSAARO:
     case OCLImage2dArrayMSAARO:
     case OCLImage2dMSAADepthRO:
     case OCLImage2dArrayMSAADepthRO:
     case OCLImage3dRO:
     case OCLImage1dWO:
     case OCLImage1dArrayWO:
     case OCLImage1dBufferWO:
     case OCLImage2dWO:
     case OCLImage2dArrayWO:
     case OCLImage2dDepthWO:
     case OCLImage2dArrayDepthWO:
     case OCLImage2dMSAAWO:
     case OCLImage2dArrayMSAAWO:
     case OCLImage2dMSAADepthWO:
     case OCLImage2dArrayMSAADepthWO:
     case OCLImage3dWO:
     case OCLImage1dRW:
     case OCLImage1dArrayRW:
     case OCLImage1dBufferRW:
     case OCLImage2dRW:
     case OCLImage2dArrayRW:
     case OCLImage2dDepthRW:
     case OCLImage2dArrayDepthRW:
     case OCLImage2dMSAARW:
     case OCLImage2dArrayMSAARW:
     case OCLImage2dMSAADepthRW:
     case OCLImage2dArrayMSAADepthRW:
     case OCLImage3dRW:
     case Void:
     case NullPtr:
     case ObjCId:
     case ObjCClass:
     case ObjCSel:
     case OCLSampler:
     case OCLEvent:
     case OCLClkEvent:
     case OCLQueue:
     case OCLNDRange:
     case OCLReserveID:
     case Dependent:
     case Overload:
     case BoundMember:
     case PseudoObject:
     case UnknownAny:
     case BuiltinFn:
     case ARCUnbridgedCast:
     case OMPArraySection:
      // Misc other stuff which doesn't make sense here.
      return false;
     case UInt:
     case Int:
     case Float:
     case Double:
      LM.setKind(LengthModifier.Kind.None);
      break;
     case Char_U:
     case UChar:
     case Char_S:
     case SChar:
      LM.setKind(LengthModifier.Kind.AsChar);
      break;
     case Short:
     case UShort:
      LM.setKind(LengthModifier.Kind.AsShort);
      break;
     case Long:
     case ULong:
      LM.setKind(LengthModifier.Kind.AsLong);
      break;
     case LongLong:
     case ULongLong:
      LM.setKind(LengthModifier.Kind.AsLongLong);
      break;
     case LongDouble:
      LM.setKind(LengthModifier.Kind.AsLongDouble);
      break;
    }
    
    // Handle size_t, ptrdiff_t, etc. that have dedicated length modifiers in C99.
    if (isa_TypedefType(QT) && (LangOpt.C99 || LangOpt.CPlusPlus11)) {
      namedTypeToLengthModifier(new QualType(QT), LM);
    }
    
    // If fixing the length modifier was enough, we might be done.
    if (hasValidLengthModifier(Ctx.getTargetInfo())) {
      // If we're going to offer a fix anyway, make sure the sign matches.
      switch (CS.getKind()) {
       case uArg:
       case UArg:
        if (QT.$arrow().isSignedIntegerType()) {
          CS.setKind(ConversionSpecifier.Kind.dArg);
        }
        break;
       case dArg:
       case DArg:
       case iArg:
        if (QT.$arrow().isUnsignedIntegerType() && !HasPlusPrefix.$bool()) {
          CS.setKind(ConversionSpecifier.Kind.uArg);
        }
        break;
       default:
        // Other specifiers do not have signed/unsigned variants.
        break;
      }
      
      final /*const*/ ArgType /*&*/ ATR = getArgType(Ctx, IsObjCLiteral);
      if (ATR.isValid() && (ATR.matchesType(Ctx, new QualType(QT)).getValue() != 0)) {
        return true;
      }
    }
    
    // Set conversion specifier and disable any flags which do not apply to it.
    // Let typedefs to char fall through to int, as %c is silly for uint8_t.
    if (!isa_TypedefType(QT) && QT.$arrow().isCharType()) {
      CS.setKind(ConversionSpecifier.Kind.cArg);
      LM.setKind(LengthModifier.Kind.None);
      Precision.setHowSpecified(OptionalAmount.HowSpecified.NotSpecified);
      HasAlternativeForm.$assign(/*KEEP_BOOL*/false);
      HasLeadingZeroes.$assign(/*KEEP_BOOL*/false);
      HasPlusPrefix.$assign(/*KEEP_BOOL*/false);
    } else // Test for Floating type first as LongDouble can pass isUnsignedIntegerType
    if (QT.$arrow().isRealFloatingType()) {
      CS.setKind(ConversionSpecifier.Kind.fArg);
    } else if (QT.$arrow().isSignedIntegerType()) {
      CS.setKind(ConversionSpecifier.Kind.dArg);
      HasAlternativeForm.$assign(/*KEEP_BOOL*/false);
    } else if (QT.$arrow().isUnsignedIntegerType()) {
      CS.setKind(ConversionSpecifier.Kind.uArg);
      HasAlternativeForm.$assign(/*KEEP_BOOL*/false);
      HasPlusPrefix.$assign(/*KEEP_BOOL*/false);
    } else {
      throw new llvm_unreachable("Unexpected type");
    }
    
    return true;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::analyze_printf::PrintfSpecifier::toString">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/PrintfFormatString.cpp", line = 727,
   FQN="clang::analyze_printf::PrintfSpecifier::toString", NM="_ZNK5clang14analyze_printf15PrintfSpecifier8toStringERN4llvm11raw_ostreamE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/PrintfFormatString.cpp -nm=_ZNK5clang14analyze_printf15PrintfSpecifier8toStringERN4llvm11raw_ostreamE")
  //</editor-fold>
  public void __toString(final raw_ostream /*&*/ os) /*const*/ {
    // Whilst some features have no defined order, we are using the order
    // appearing in the C99 standard (ISO/IEC 9899:1999 (E) 7.19.6.1)
    os.$out(/*KEEP_STR*/$PERCENT);
    
    // Positional args
    if (usesPositionalArg()) {
      os.$out_uint(getPositionalArgIndex()).$out(/*KEEP_STR*/$DOLLAR);
    }
    
    // Conversion flags
    if (IsLeftJustified.$bool()) {
      os.$out(/*KEEP_STR*/$MINUS);
    }
    if (HasPlusPrefix.$bool()) {
      os.$out(/*KEEP_STR*/$PLUS);
    }
    if (HasSpacePrefix.$bool()) {
      os.$out(/*KEEP_STR*/$SPACE);
    }
    if (HasAlternativeForm.$bool()) {
      os.$out(/*KEEP_STR*/$HASH);
    }
    if (HasLeadingZeroes.$bool()) {
      os.$out(/*KEEP_STR*/$0);
    }
    
    // Minimum field width
    FieldWidth.__toString(os);
    // Precision
    Precision.__toString(os);
    // Length modifier
    os.$out(LM.__toString());
    // Conversion specifier
    os.$out(CS.__toString());
  }

  
  // Validation methods - to check if any element results in undefined behavior
  //<editor-fold defaultstate="collapsed" desc="clang::analyze_printf::PrintfSpecifier::hasValidPlusPrefix">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/PrintfFormatString.cpp", line = 754,
   FQN="clang::analyze_printf::PrintfSpecifier::hasValidPlusPrefix", NM="_ZNK5clang14analyze_printf15PrintfSpecifier18hasValidPlusPrefixEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/PrintfFormatString.cpp -nm=_ZNK5clang14analyze_printf15PrintfSpecifier18hasValidPlusPrefixEv")
  //</editor-fold>
  public boolean hasValidPlusPrefix() /*const*/ {
    if (!HasPlusPrefix.$bool()) {
      return true;
    }
    
    // The plus prefix only makes sense for signed conversions
    switch (CS.getKind()) {
     case dArg:
     case DArg:
     case iArg:
     case fArg:
     case FArg:
     case eArg:
     case EArg:
     case gArg:
     case GArg:
     case aArg:
     case AArg:
     case FreeBSDrArg:
     case FreeBSDyArg:
      return true;
     default:
      return false;
    }
  }

  //<editor-fold defaultstate="collapsed" desc="clang::analyze_printf::PrintfSpecifier::hasValidAlternativeForm">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/PrintfFormatString.cpp", line = 780,
   FQN="clang::analyze_printf::PrintfSpecifier::hasValidAlternativeForm", NM="_ZNK5clang14analyze_printf15PrintfSpecifier23hasValidAlternativeFormEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/PrintfFormatString.cpp -nm=_ZNK5clang14analyze_printf15PrintfSpecifier23hasValidAlternativeFormEv")
  //</editor-fold>
  public boolean hasValidAlternativeForm() /*const*/ {
    if (!HasAlternativeForm.$bool()) {
      return true;
    }
    
    // Alternate form flag only valid with the oxXaAeEfFgG conversions
    switch (CS.getKind()) {
     case oArg:
     case OArg:
     case xArg:
     case XArg:
     case aArg:
     case AArg:
     case eArg:
     case EArg:
     case fArg:
     case FArg:
     case gArg:
     case GArg:
     case FreeBSDrArg:
     case FreeBSDyArg:
      return true;
     default:
      return false;
    }
  }

  //<editor-fold defaultstate="collapsed" desc="clang::analyze_printf::PrintfSpecifier::hasValidLeadingZeros">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/PrintfFormatString.cpp", line = 807,
   FQN="clang::analyze_printf::PrintfSpecifier::hasValidLeadingZeros", NM="_ZNK5clang14analyze_printf15PrintfSpecifier20hasValidLeadingZerosEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/PrintfFormatString.cpp -nm=_ZNK5clang14analyze_printf15PrintfSpecifier20hasValidLeadingZerosEv")
  //</editor-fold>
  public boolean hasValidLeadingZeros() /*const*/ {
    if (!HasLeadingZeroes.$bool()) {
      return true;
    }
    
    // Leading zeroes flag only valid with the diouxXaAeEfFgG conversions
    switch (CS.getKind()) {
     case dArg:
     case DArg:
     case iArg:
     case oArg:
     case OArg:
     case uArg:
     case UArg:
     case xArg:
     case XArg:
     case aArg:
     case AArg:
     case eArg:
     case EArg:
     case fArg:
     case FArg:
     case gArg:
     case GArg:
     case FreeBSDrArg:
     case FreeBSDyArg:
      return true;
     default:
      return false;
    }
  }

  //<editor-fold defaultstate="collapsed" desc="clang::analyze_printf::PrintfSpecifier::hasValidSpacePrefix">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/PrintfFormatString.cpp", line = 839,
   FQN="clang::analyze_printf::PrintfSpecifier::hasValidSpacePrefix", NM="_ZNK5clang14analyze_printf15PrintfSpecifier19hasValidSpacePrefixEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/PrintfFormatString.cpp -nm=_ZNK5clang14analyze_printf15PrintfSpecifier19hasValidSpacePrefixEv")
  //</editor-fold>
  public boolean hasValidSpacePrefix() /*const*/ {
    if (!HasSpacePrefix.$bool()) {
      return true;
    }
    
    // The space prefix only makes sense for signed conversions
    switch (CS.getKind()) {
     case dArg:
     case DArg:
     case iArg:
     case fArg:
     case FArg:
     case eArg:
     case EArg:
     case gArg:
     case GArg:
     case aArg:
     case AArg:
     case FreeBSDrArg:
     case FreeBSDyArg:
      return true;
     default:
      return false;
    }
  }

  //<editor-fold defaultstate="collapsed" desc="clang::analyze_printf::PrintfSpecifier::hasValidLeftJustified">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/PrintfFormatString.cpp", line = 865,
   FQN="clang::analyze_printf::PrintfSpecifier::hasValidLeftJustified", NM="_ZNK5clang14analyze_printf15PrintfSpecifier21hasValidLeftJustifiedEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/PrintfFormatString.cpp -nm=_ZNK5clang14analyze_printf15PrintfSpecifier21hasValidLeftJustifiedEv")
  //</editor-fold>
  public boolean hasValidLeftJustified() /*const*/ {
    if (!IsLeftJustified.$bool()) {
      return true;
    }
    
    // The left justified flag is valid for all conversions except n
    switch (CS.getKind()) {
     case nArg:
      return false;
     default:
      return true;
    }
  }

  //<editor-fold defaultstate="collapsed" desc="clang::analyze_printf::PrintfSpecifier::hasValidThousandsGroupingPrefix">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/PrintfFormatString.cpp", line = 879,
   FQN="clang::analyze_printf::PrintfSpecifier::hasValidThousandsGroupingPrefix", NM="_ZNK5clang14analyze_printf15PrintfSpecifier31hasValidThousandsGroupingPrefixEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/PrintfFormatString.cpp -nm=_ZNK5clang14analyze_printf15PrintfSpecifier31hasValidThousandsGroupingPrefixEv")
  //</editor-fold>
  public boolean hasValidThousandsGroupingPrefix() /*const*/ {
    if (!HasThousandsGrouping.$bool()) {
      return true;
    }
    switch (CS.getKind()) {
     case dArg:
     case DArg:
     case iArg:
     case uArg:
     case UArg:
     case fArg:
     case FArg:
     case gArg:
     case GArg:
      return true;
     default:
      return false;
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::analyze_printf::PrintfSpecifier::hasValidPrecision">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/PrintfFormatString.cpp", line = 899,
   FQN="clang::analyze_printf::PrintfSpecifier::hasValidPrecision", NM="_ZNK5clang14analyze_printf15PrintfSpecifier17hasValidPrecisionEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/PrintfFormatString.cpp -nm=_ZNK5clang14analyze_printf15PrintfSpecifier17hasValidPrecisionEv")
  //</editor-fold>
  public boolean hasValidPrecision() /*const*/ {
    if (Precision.getHowSpecified() == OptionalAmount.HowSpecified.NotSpecified) {
      return true;
    }
    
    // Precision is only valid with the diouxXaAeEfFgGs conversions
    switch (CS.getKind()) {
     case dArg:
     case DArg:
     case iArg:
     case oArg:
     case OArg:
     case uArg:
     case UArg:
     case xArg:
     case XArg:
     case aArg:
     case AArg:
     case eArg:
     case EArg:
     case fArg:
     case FArg:
     case gArg:
     case GArg:
     case sArg:
     case FreeBSDrArg:
     case FreeBSDyArg:
      return true;
     default:
      return false;
    }
  }

  //<editor-fold defaultstate="collapsed" desc="clang::analyze_printf::PrintfSpecifier::hasValidFieldWidth">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/PrintfFormatString.cpp", line = 931,
   FQN="clang::analyze_printf::PrintfSpecifier::hasValidFieldWidth", NM="_ZNK5clang14analyze_printf15PrintfSpecifier18hasValidFieldWidthEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/PrintfFormatString.cpp -nm=_ZNK5clang14analyze_printf15PrintfSpecifier18hasValidFieldWidthEv")
  //</editor-fold>
  public boolean hasValidFieldWidth() /*const*/ {
    if (FieldWidth.getHowSpecified() == OptionalAmount.HowSpecified.NotSpecified) {
      return true;
    }
    
    // The field width is valid for all conversions except n
    switch (CS.getKind()) {
     case nArg:
      return false;
     default:
      return true;
    }
  }

  //<editor-fold defaultstate="collapsed" desc="clang::analyze_printf::PrintfSpecifier::PrintfSpecifier">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/FormatString.h", line = 432,
   FQN="clang::analyze_printf::PrintfSpecifier::PrintfSpecifier", NM="_ZN5clang14analyze_printf15PrintfSpecifierC1ERKS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/PrintfFormatString.cpp -nm=_ZN5clang14analyze_printf15PrintfSpecifierC1ERKS1_")
  //</editor-fold>
  public /*inline*/ PrintfSpecifier(final /*const*/ PrintfSpecifier /*&*/ $Prm0) {
    // : FormatSpecifier(), HasThousandsGrouping(.HasThousandsGrouping), IsLeftJustified(.IsLeftJustified), HasPlusPrefix(.HasPlusPrefix), HasSpacePrefix(.HasSpacePrefix), HasAlternativeForm(.HasAlternativeForm), HasLeadingZeroes(.HasLeadingZeroes), HasObjCTechnicalTerm(.HasObjCTechnicalTerm), Precision(.Precision) 
    //START JInit
    super($Prm0);
    this.HasThousandsGrouping = new OptionalFlag($Prm0.HasThousandsGrouping);
    this.IsLeftJustified = new OptionalFlag($Prm0.IsLeftJustified);
    this.HasPlusPrefix = new OptionalFlag($Prm0.HasPlusPrefix);
    this.HasSpacePrefix = new OptionalFlag($Prm0.HasSpacePrefix);
    this.HasAlternativeForm = new OptionalFlag($Prm0.HasAlternativeForm);
    this.HasLeadingZeroes = new OptionalFlag($Prm0.HasLeadingZeroes);
    this.HasObjCTechnicalTerm = new OptionalFlag($Prm0.HasObjCTechnicalTerm);
    this.Precision = new OptionalAmount($Prm0.Precision);
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="clang::analyze_printf::PrintfSpecifier::PrintfSpecifier">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/FormatString.h", line = 432,
   FQN="clang::analyze_printf::PrintfSpecifier::PrintfSpecifier", NM="_ZN5clang14analyze_printf15PrintfSpecifierC1EOS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/PrintfFormatString.cpp -nm=_ZN5clang14analyze_printf15PrintfSpecifierC1EOS1_")
  //</editor-fold>
  public /*inline*/ PrintfSpecifier(JD$Move _dparam, final PrintfSpecifier /*&&*/$Prm0) {
    // : FormatSpecifier(static_cast<PrintfSpecifier &&>()), HasThousandsGrouping(static_cast<PrintfSpecifier &&>().HasThousandsGrouping), IsLeftJustified(static_cast<PrintfSpecifier &&>().IsLeftJustified), HasPlusPrefix(static_cast<PrintfSpecifier &&>().HasPlusPrefix), HasSpacePrefix(static_cast<PrintfSpecifier &&>().HasSpacePrefix), HasAlternativeForm(static_cast<PrintfSpecifier &&>().HasAlternativeForm), HasLeadingZeroes(static_cast<PrintfSpecifier &&>().HasLeadingZeroes), HasObjCTechnicalTerm(static_cast<PrintfSpecifier &&>().HasObjCTechnicalTerm), Precision(static_cast<PrintfSpecifier &&>().Precision) 
    //START JInit
    super(JD$Move.INSTANCE, $Prm0);
    this.HasThousandsGrouping = new OptionalFlag(JD$Move.INSTANCE, $Prm0.HasThousandsGrouping);
    this.IsLeftJustified = new OptionalFlag(JD$Move.INSTANCE, $Prm0.IsLeftJustified);
    this.HasPlusPrefix = new OptionalFlag(JD$Move.INSTANCE, $Prm0.HasPlusPrefix);
    this.HasSpacePrefix = new OptionalFlag(JD$Move.INSTANCE, $Prm0.HasSpacePrefix);
    this.HasAlternativeForm = new OptionalFlag(JD$Move.INSTANCE, $Prm0.HasAlternativeForm);
    this.HasLeadingZeroes = new OptionalFlag(JD$Move.INSTANCE, $Prm0.HasLeadingZeroes);
    this.HasObjCTechnicalTerm = new OptionalFlag(JD$Move.INSTANCE, $Prm0.HasObjCTechnicalTerm);
    this.Precision = new OptionalAmount(JD$Move.INSTANCE, $Prm0.Precision);
    //END JInit
  }

  
  @Override public String toString() {
    return "" + "HasThousandsGrouping=" + HasThousandsGrouping // NOI18N
              + ", IsLeftJustified=" + IsLeftJustified // NOI18N
              + ", HasPlusPrefix=" + HasPlusPrefix // NOI18N
              + ", HasSpacePrefix=" + HasSpacePrefix // NOI18N
              + ", HasAlternativeForm=" + HasAlternativeForm // NOI18N
              + ", HasLeadingZeroes=" + HasLeadingZeroes // NOI18N
              + ", HasObjCTechnicalTerm=" + HasObjCTechnicalTerm // NOI18N
              + ", Precision=" + Precision // NOI18N
              + super.toString(); // NOI18N
  }
}
