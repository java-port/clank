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

package org.clang.analysis.analyses.analyze_format_string;

import org.clank.support.*;
import org.clank.support.JavaDifferentiators.*;
import static org.llvm.support.llvm.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.clang.ast.*;
import org.clang.basic.*;
import org.clang.analysis.analyses.analyze_format_string.*;
import org.clang.basic.target.TargetInfo;
import static org.clang.ast.java.AstTypesRTTI.*;


//<editor-fold defaultstate="collapsed" desc="clang::analyze_format_string::FormatSpecifier">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/FormatString.h", line = 341,
 FQN="clang::analyze_format_string::FormatSpecifier", NM="_ZN5clang21analyze_format_string15FormatSpecifierE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/FormatString.cpp -nm=_ZN5clang21analyze_format_string15FormatSpecifierE")
//</editor-fold>
public class FormatSpecifier {
/*protected:*/
  protected LengthModifier LM;
  protected OptionalAmount FieldWidth;
  protected ConversionSpecifier CS;
  /// Positional arguments, an IEEE extension:
  ///  IEEE Std 1003.1, 2004 Edition
  ///  http://www.opengroup.org/onlinepubs/009695399/functions/printf.html
  protected boolean UsesPositionalArg;
  protected /*uint*/int argIndex;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::analyze_format_string::FormatSpecifier::FormatSpecifier">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/FormatString.h", line = 352,
   FQN="clang::analyze_format_string::FormatSpecifier::FormatSpecifier", NM="_ZN5clang21analyze_format_string15FormatSpecifierC1Eb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/FormatString.cpp -nm=_ZN5clang21analyze_format_string15FormatSpecifierC1Eb")
  //</editor-fold>
  public FormatSpecifier(boolean isPrintf) {
    // : LM(), FieldWidth(), CS(isPrintf), UsesPositionalArg(false), argIndex(0) 
    //START JInit
    this.LM = new LengthModifier();
    this.FieldWidth = new OptionalAmount();
    this.CS = new ConversionSpecifier(isPrintf);
    this.UsesPositionalArg = false;
    this.argIndex = 0;
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::analyze_format_string::FormatSpecifier::setLengthModifier">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/FormatString.h", line = 355,
   FQN="clang::analyze_format_string::FormatSpecifier::setLengthModifier", NM="_ZN5clang21analyze_format_string15FormatSpecifier17setLengthModifierENS0_14LengthModifierE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/FormatString.cpp -nm=_ZN5clang21analyze_format_string15FormatSpecifier17setLengthModifierENS0_14LengthModifierE")
  //</editor-fold>
  public void setLengthModifier(LengthModifier lm) {
    LM.$assign(lm);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::analyze_format_string::FormatSpecifier::setUsesPositionalArg">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/FormatString.h", line = 359,
   FQN="clang::analyze_format_string::FormatSpecifier::setUsesPositionalArg", NM="_ZN5clang21analyze_format_string15FormatSpecifier20setUsesPositionalArgEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/FormatString.cpp -nm=_ZN5clang21analyze_format_string15FormatSpecifier20setUsesPositionalArgEv")
  //</editor-fold>
  public void setUsesPositionalArg() {
    UsesPositionalArg = true;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::analyze_format_string::FormatSpecifier::setArgIndex">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/FormatString.h", line = 361,
   FQN="clang::analyze_format_string::FormatSpecifier::setArgIndex", NM="_ZN5clang21analyze_format_string15FormatSpecifier11setArgIndexEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/FormatString.cpp -nm=_ZN5clang21analyze_format_string15FormatSpecifier11setArgIndexEj")
  //</editor-fold>
  public void setArgIndex(/*uint*/int i) {
    argIndex = i;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::analyze_format_string::FormatSpecifier::getArgIndex">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/FormatString.h", line = 365,
   FQN="clang::analyze_format_string::FormatSpecifier::getArgIndex", NM="_ZNK5clang21analyze_format_string15FormatSpecifier11getArgIndexEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/FormatString.cpp -nm=_ZNK5clang21analyze_format_string15FormatSpecifier11getArgIndexEv")
  //</editor-fold>
  public /*uint*/int getArgIndex() /*const*/ {
    return argIndex;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::analyze_format_string::FormatSpecifier::getPositionalArgIndex">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/FormatString.h", line = 369,
   FQN="clang::analyze_format_string::FormatSpecifier::getPositionalArgIndex", NM="_ZNK5clang21analyze_format_string15FormatSpecifier21getPositionalArgIndexEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/FormatString.cpp -nm=_ZNK5clang21analyze_format_string15FormatSpecifier21getPositionalArgIndexEv")
  //</editor-fold>
  public /*uint*/int getPositionalArgIndex() /*const*/ {
    return argIndex + 1;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::analyze_format_string::FormatSpecifier::getLengthModifier">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/FormatString.h", line = 373,
   FQN="clang::analyze_format_string::FormatSpecifier::getLengthModifier", NM="_ZNK5clang21analyze_format_string15FormatSpecifier17getLengthModifierEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/FormatString.cpp -nm=_ZNK5clang21analyze_format_string15FormatSpecifier17getLengthModifierEv")
  //</editor-fold>
  public /*const*/ LengthModifier /*&*/ getLengthModifier() /*const*/ {
    return LM;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::analyze_format_string::FormatSpecifier::getFieldWidth">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/FormatString.h", line = 377,
   FQN="clang::analyze_format_string::FormatSpecifier::getFieldWidth", NM="_ZNK5clang21analyze_format_string15FormatSpecifier13getFieldWidthEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/FormatString.cpp -nm=_ZNK5clang21analyze_format_string15FormatSpecifier13getFieldWidthEv")
  //</editor-fold>
  public /*const*/ OptionalAmount /*&*/ getFieldWidth() /*const*/ {
    return FieldWidth;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::analyze_format_string::FormatSpecifier::setFieldWidth">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/FormatString.h", line = 381,
   FQN="clang::analyze_format_string::FormatSpecifier::setFieldWidth", NM="_ZN5clang21analyze_format_string15FormatSpecifier13setFieldWidthERKNS0_14OptionalAmountE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/FormatString.cpp -nm=_ZN5clang21analyze_format_string15FormatSpecifier13setFieldWidthERKNS0_14OptionalAmountE")
  //</editor-fold>
  public void setFieldWidth(final /*const*/ OptionalAmount /*&*/ Amt) {
    FieldWidth.$assign(Amt);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::analyze_format_string::FormatSpecifier::usesPositionalArg">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/FormatString.h", line = 385,
   FQN="clang::analyze_format_string::FormatSpecifier::usesPositionalArg", NM="_ZNK5clang21analyze_format_string15FormatSpecifier17usesPositionalArgEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/FormatString.cpp -nm=_ZNK5clang21analyze_format_string15FormatSpecifier17usesPositionalArgEv")
  //</editor-fold>
  public boolean usesPositionalArg() /*const*/ {
    return UsesPositionalArg;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::analyze_format_string::FormatSpecifier::hasValidLengthModifier">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/FormatString.cpp", line = 657,
   FQN="clang::analyze_format_string::FormatSpecifier::hasValidLengthModifier", NM="_ZNK5clang21analyze_format_string15FormatSpecifier22hasValidLengthModifierERKNS_10TargetInfoE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/FormatString.cpp -nm=_ZNK5clang21analyze_format_string15FormatSpecifier22hasValidLengthModifierERKNS_10TargetInfoE")
  //</editor-fold>
  public boolean hasValidLengthModifier(final /*const*/ TargetInfo /*&*/ Target) /*const*/ {
    switch (LM.getKind()) {
     case LengthModifier.Kind.None:
      return true;
     case LengthModifier.Kind.AsShort:
      
      // Handle most integer flags
      if (Target.getTriple().isOSMSVCRT()) {
        switch (CS.getKind()) {
         case cArg:
         case CArg:
         case sArg:
         case SArg:
         case ZArg:
          return true;
         default:
          break;
        }
      }
     case LengthModifier.Kind.AsChar:
     case LengthModifier.Kind.AsLongLong:
     case LengthModifier.Kind.AsQuad:
     case LengthModifier.Kind.AsIntMax:
     case LengthModifier.Kind.AsSizeT:
     case LengthModifier.Kind.AsPtrDiff:
      // Fall through.
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
       case nArg:
        return true;
       case FreeBSDrArg:
       case FreeBSDyArg:
        return Target.getTriple().isOSFreeBSD() || Target.getTriple().isPS4();
       default:
        return false;
      }
     case LengthModifier.Kind.AsLong: // or AsWideChar
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
       case fArg:
       case FArg:
       case eArg:
       case EArg:
       case gArg:
       case GArg:
       case nArg:
       case cArg:
       case sArg:
       case ScanListArg:
       case ZArg:
        return true;
       case FreeBSDrArg:
       case FreeBSDyArg:
        return Target.getTriple().isOSFreeBSD() || Target.getTriple().isPS4();
       default:
        return false;
      }
     case LengthModifier.Kind.AsLongDouble:
      switch (CS.getKind()) {
       case aArg:
       case AArg:
       case fArg:
       case FArg:
       case eArg:
       case EArg:
       case gArg:
       case GArg:
        return true;
       case dArg:
       case iArg:
       case oArg:
       case uArg:
       case xArg:
       case XArg:
        // GNU libc extension.
        return !Target.getTriple().isOSDarwin()
           && !Target.getTriple().isOSWindows();
       default:
        return false;
      }
     case LengthModifier.Kind.AsAllocate:
      switch (CS.getKind()) {
       case sArg:
       case SArg:
       case ScanListArg:
        return true;
       default:
        return false;
      }
     case LengthModifier.Kind.AsMAllocate:
      switch (CS.getKind()) {
       case cArg:
       case CArg:
       case sArg:
       case SArg:
       case ScanListArg:
        return true;
       default:
        return false;
      }
     case LengthModifier.Kind.AsInt32:
     case LengthModifier.Kind.AsInt3264:
     case LengthModifier.Kind.AsInt64:
      switch (CS.getKind()) {
       case dArg:
       case iArg:
       case oArg:
       case uArg:
       case xArg:
       case XArg:
        return Target.getTriple().isOSMSVCRT();
       default:
        return false;
      }
     case LengthModifier.Kind.AsWide:
      switch (CS.getKind()) {
       case cArg:
       case CArg:
       case sArg:
       case SArg:
       case ZArg:
        return Target.getTriple().isOSMSVCRT();
       default:
        return false;
      }
    }
    throw new llvm_unreachable("Invalid LengthModifier Kind!");
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::analyze_format_string::FormatSpecifier::hasStandardLengthModifier">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/FormatString.cpp", line = 809,
   FQN="clang::analyze_format_string::FormatSpecifier::hasStandardLengthModifier", NM="_ZNK5clang21analyze_format_string15FormatSpecifier25hasStandardLengthModifierEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/FormatString.cpp -nm=_ZNK5clang21analyze_format_string15FormatSpecifier25hasStandardLengthModifierEv")
  //</editor-fold>
  public boolean hasStandardLengthModifier() /*const*/ {
    switch (LM.getKind()) {
     case LengthModifier.Kind.None:
     case LengthModifier.Kind.AsChar:
     case LengthModifier.Kind.AsShort:
     case LengthModifier.Kind.AsLong:
     case LengthModifier.Kind.AsLongLong:
     case LengthModifier.Kind.AsIntMax:
     case LengthModifier.Kind.AsSizeT:
     case LengthModifier.Kind.AsPtrDiff:
     case LengthModifier.Kind.AsLongDouble:
      return true;
     case LengthModifier.Kind.AsAllocate:
     case LengthModifier.Kind.AsMAllocate:
     case LengthModifier.Kind.AsQuad:
     case LengthModifier.Kind.AsInt32:
     case LengthModifier.Kind.AsInt3264:
     case LengthModifier.Kind.AsInt64:
     case LengthModifier.Kind.AsWide:
      return false;
    }
    throw new llvm_unreachable("Invalid LengthModifier Kind!");
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::analyze_format_string::FormatSpecifier::getCorrectedLengthModifier">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/FormatString.cpp", line = 893,
   FQN="clang::analyze_format_string::FormatSpecifier::getCorrectedLengthModifier", NM="_ZNK5clang21analyze_format_string15FormatSpecifier26getCorrectedLengthModifierEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/FormatString.cpp -nm=_ZNK5clang21analyze_format_string15FormatSpecifier26getCorrectedLengthModifierEv")
  //</editor-fold>
  public Optional<LengthModifier> getCorrectedLengthModifier() /*const*/ {
    if (CS.isAnyIntArg() || CS.getKind() == ConversionSpecifier.Kind.nArg) {
      if (LM.getKind() == LengthModifier.Kind.AsLongDouble
         || LM.getKind() == LengthModifier.Kind.AsQuad) {
        LengthModifier FixedLM/*J*/= new LengthModifier(LM);
        FixedLM.setKind(LengthModifier.Kind.AsLongLong);
        return new Optional<LengthModifier>(JD$T$C$R.INSTANCE, FixedLM);
      }
    }
    
    return new Optional<LengthModifier>(None);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::analyze_format_string::FormatSpecifier::hasStandardConversionSpecifier">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/FormatString.cpp", line = 833,
   FQN="clang::analyze_format_string::FormatSpecifier::hasStandardConversionSpecifier", NM="_ZNK5clang21analyze_format_string15FormatSpecifier30hasStandardConversionSpecifierERKNS_11LangOptionsE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/FormatString.cpp -nm=_ZNK5clang21analyze_format_string15FormatSpecifier30hasStandardConversionSpecifierERKNS_11LangOptionsE")
  //</editor-fold>
  public boolean hasStandardConversionSpecifier(final /*const*/ LangOptions /*&*/ LangOpt) /*const*/ {
    switch (CS.getKind()) {
     case cArg:
     case dArg:
     case iArg:
     case oArg:
     case uArg:
     case xArg:
     case XArg:
     case fArg:
     case FArg:
     case eArg:
     case EArg:
     case gArg:
     case GArg:
     case aArg:
     case AArg:
     case sArg:
     case pArg:
     case nArg:
     case ObjCObjArg:
     case ScanListArg:
     case PercentArg:
      return true;
     case CArg:
     case SArg:
      return LangOpt.ObjC1 || LangOpt.ObjC2;
     case InvalidSpecifier:
     case FreeBSDbArg:
     case FreeBSDDArg:
     case FreeBSDrArg:
     case FreeBSDyArg:
     case PrintErrno:
     case DArg:
     case OArg:
     case UArg:
     case ZArg:
      return false;
    }
    throw new llvm_unreachable("Invalid ConversionSpecifier Kind!");
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::analyze_format_string::FormatSpecifier::hasStandardLengthConversionCombination">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/FormatString.cpp", line = 876,
   FQN="clang::analyze_format_string::FormatSpecifier::hasStandardLengthConversionCombination", NM="_ZNK5clang21analyze_format_string15FormatSpecifier38hasStandardLengthConversionCombinationEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/FormatString.cpp -nm=_ZNK5clang21analyze_format_string15FormatSpecifier38hasStandardLengthConversionCombinationEv")
  //</editor-fold>
  public boolean hasStandardLengthConversionCombination() /*const*/ {
    if (LM.getKind() == LengthModifier.Kind.AsLongDouble) {
      switch (CS.getKind()) {
       case dArg:
       case iArg:
       case oArg:
       case uArg:
       case xArg:
       case XArg:
        return false;
       default:
        return true;
      }
    }
    return true;
  }

  
  /// For a TypedefType QT, if it is a named integer type such as size_t,
  /// assign the appropriate value to LM and return true.
  //<editor-fold defaultstate="collapsed" desc="clang::analyze_format_string::FormatSpecifier::namedTypeToLengthModifier">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/FormatString.cpp", line = 906,
   FQN="clang::analyze_format_string::FormatSpecifier::namedTypeToLengthModifier", NM="_ZN5clang21analyze_format_string15FormatSpecifier25namedTypeToLengthModifierENS_8QualTypeERNS0_14LengthModifierE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/FormatString.cpp -nm=_ZN5clang21analyze_format_string15FormatSpecifier25namedTypeToLengthModifierENS_8QualTypeERNS0_14LengthModifierE")
  //</editor-fold>
  public static boolean namedTypeToLengthModifier(QualType QT, 
                           final LengthModifier /*&*/ LM) {
    assert (isa_TypedefType(QT)) : "Expected a TypedefType";
    /*const*/ TypedefNameDecl /*P*/ Typedef = cast_TypedefType(QT).getDecl();
    
    for (;;) {
      /*const*/ IdentifierInfo /*P*/ Identifier = Typedef.getIdentifier();
      if ($eq_StringRef(Identifier.getName(), /*STRINGREF_STR*/"size_t")) {
        LM.setKind(LengthModifier.Kind.AsSizeT);
        return true;
      } else if ($eq_StringRef(Identifier.getName(), /*STRINGREF_STR*/"ssize_t")) {
        // Not C99, but common in Unix.
        LM.setKind(LengthModifier.Kind.AsSizeT);
        return true;
      } else if ($eq_StringRef(Identifier.getName(), /*STRINGREF_STR*/"intmax_t")) {
        LM.setKind(LengthModifier.Kind.AsIntMax);
        return true;
      } else if ($eq_StringRef(Identifier.getName(), /*STRINGREF_STR*/"uintmax_t")) {
        LM.setKind(LengthModifier.Kind.AsIntMax);
        return true;
      } else if ($eq_StringRef(Identifier.getName(), /*STRINGREF_STR*/"ptrdiff_t")) {
        LM.setKind(LengthModifier.Kind.AsPtrDiff);
        return true;
      }
      
      QualType T = Typedef.getUnderlyingType();
      if (!isa_TypedefType(T)) {
        break;
      }
      
      Typedef = cast_TypedefType(T).getDecl();
    }
    return false;
  }


  //<editor-fold defaultstate="collapsed" desc="clang::analyze_format_string::FormatSpecifier::FormatSpecifier">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/FormatString.h", line = 341,
   FQN="clang::analyze_format_string::FormatSpecifier::FormatSpecifier", NM="_ZN5clang21analyze_format_string15FormatSpecifierC1ERKS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ScanfFormatString.cpp -nm=_ZN5clang21analyze_format_string15FormatSpecifierC1ERKS1_")
  //</editor-fold>
  public /*inline*/ FormatSpecifier(final /*const*/ FormatSpecifier /*&*/ $Prm0) {
    // : LM(.LM), FieldWidth(.FieldWidth), CS(.CS), UsesPositionalArg(.UsesPositionalArg), argIndex(.argIndex) 
    //START JInit
    this.LM = new LengthModifier($Prm0.LM);
    this.FieldWidth = new OptionalAmount($Prm0.FieldWidth);
    this.CS = new ConversionSpecifier($Prm0.CS);
    this.UsesPositionalArg = $Prm0.UsesPositionalArg;
    this.argIndex = $Prm0.argIndex;
    //END JInit
  }


  //<editor-fold defaultstate="collapsed" desc="clang::analyze_format_string::FormatSpecifier::FormatSpecifier">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/FormatString.h", line = 341,
   FQN="clang::analyze_format_string::FormatSpecifier::FormatSpecifier", NM="_ZN5clang21analyze_format_string15FormatSpecifierC1EOS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ScanfFormatString.cpp -nm=_ZN5clang21analyze_format_string15FormatSpecifierC1EOS1_")
  //</editor-fold>
  public /*inline*/ FormatSpecifier(JD$Move _dparam, final FormatSpecifier /*&&*/$Prm0) {
    // : LM(static_cast<FormatSpecifier &&>().LM), FieldWidth(static_cast<FormatSpecifier &&>().FieldWidth), CS(static_cast<FormatSpecifier &&>().CS), UsesPositionalArg(static_cast<FormatSpecifier &&>().UsesPositionalArg), argIndex(static_cast<FormatSpecifier &&>().argIndex) 
    //START JInit
    this.LM = new LengthModifier(JD$Move.INSTANCE, $Prm0.LM);
    this.FieldWidth = new OptionalAmount(JD$Move.INSTANCE, $Prm0.FieldWidth);
    this.CS = new ConversionSpecifier(JD$Move.INSTANCE, $Prm0.CS);
    this.UsesPositionalArg = $Prm0.UsesPositionalArg;
    this.argIndex = $Prm0.argIndex;
    //END JInit
  }

  
  @Override public String toString() {
    return "" + "LM=" + LM // NOI18N
              + ", FieldWidth=" + FieldWidth // NOI18N
              + ", CS=" + CS // NOI18N
              + ", UsesPositionalArg=" + UsesPositionalArg // NOI18N
              + ", argIndex=" + argIndex; // NOI18N
  }
}
