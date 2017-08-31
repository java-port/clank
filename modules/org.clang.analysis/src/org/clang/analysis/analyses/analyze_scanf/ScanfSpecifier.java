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

package org.clang.analysis.analyses.analyze_scanf;

import org.clank.support.*;
import org.clank.support.aliases.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Unsigned.*;
import org.llvm.support.*;
import org.clang.ast.*;
import org.clang.basic.*;
import org.clang.analysis.analyses.analyze_format_string.*;
import static org.clang.analysis.java.AnalysisRTTI.cast_ScanfConversionSpecifier;
import static org.clang.ast.java.AstTypesRTTI.*;


//<editor-fold defaultstate="collapsed" desc="clang::analyze_scanf::ScanfSpecifier">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/FormatString.h", line = 559,
 FQN="clang::analyze_scanf::ScanfSpecifier", NM="_ZN5clang13analyze_scanf14ScanfSpecifierE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ScanfFormatString.cpp -nm=_ZN5clang13analyze_scanf14ScanfSpecifierE")
//</editor-fold>
public class ScanfSpecifier extends /*public*/ FormatSpecifier {
  private OptionalFlag SuppressAssignment; // '*'
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::analyze_scanf::ScanfSpecifier::ScanfSpecifier">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/FormatString.h", line = 562,
   FQN="clang::analyze_scanf::ScanfSpecifier::ScanfSpecifier", NM="_ZN5clang13analyze_scanf14ScanfSpecifierC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ScanfFormatString.cpp -nm=_ZN5clang13analyze_scanf14ScanfSpecifierC1Ev")
  //</editor-fold>
  public ScanfSpecifier() {
    // : FormatSpecifier(/* isPrintf = */ false), SuppressAssignment("*") 
    //START JInit
    super(false);
    this.SuppressAssignment = new OptionalFlag($STAR);
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::analyze_scanf::ScanfSpecifier::setSuppressAssignment">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/FormatString.h", line = 566,
   FQN="clang::analyze_scanf::ScanfSpecifier::setSuppressAssignment", NM="_ZN5clang13analyze_scanf14ScanfSpecifier21setSuppressAssignmentEPKc",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ScanfFormatString.cpp -nm=_ZN5clang13analyze_scanf14ScanfSpecifier21setSuppressAssignmentEPKc")
  //</editor-fold>
  public void setSuppressAssignment(/*const*/char$ptr/*char P*/ position) {
    SuppressAssignment.setPosition(position);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::analyze_scanf::ScanfSpecifier::getSuppressAssignment">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/FormatString.h", line = 570,
   FQN="clang::analyze_scanf::ScanfSpecifier::getSuppressAssignment", NM="_ZNK5clang13analyze_scanf14ScanfSpecifier21getSuppressAssignmentEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ScanfFormatString.cpp -nm=_ZNK5clang13analyze_scanf14ScanfSpecifier21getSuppressAssignmentEv")
  //</editor-fold>
  public /*const*/ OptionalFlag /*&*/ getSuppressAssignment() /*const*/ {
    return SuppressAssignment;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::analyze_scanf::ScanfSpecifier::setConversionSpecifier">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/FormatString.h", line = 574,
   FQN="clang::analyze_scanf::ScanfSpecifier::setConversionSpecifier", NM="_ZN5clang13analyze_scanf14ScanfSpecifier22setConversionSpecifierERKNS0_24ScanfConversionSpecifierE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ScanfFormatString.cpp -nm=_ZN5clang13analyze_scanf14ScanfSpecifier22setConversionSpecifierERKNS0_24ScanfConversionSpecifierE")
  //</editor-fold>
  public void setConversionSpecifier(final /*const*/ ScanfConversionSpecifier /*&*/ cs) {
    CS.$assign(cs);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::analyze_scanf::ScanfSpecifier::getConversionSpecifier">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/FormatString.h", line = 578,
   FQN="clang::analyze_scanf::ScanfSpecifier::getConversionSpecifier", NM="_ZNK5clang13analyze_scanf14ScanfSpecifier22getConversionSpecifierEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ScanfFormatString.cpp -nm=_ZNK5clang13analyze_scanf14ScanfSpecifier22getConversionSpecifierEv")
  //</editor-fold>
  public /*const*/ ScanfConversionSpecifier /*&*/ getConversionSpecifier() /*const*/ {
    return cast_ScanfConversionSpecifier(CS);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::analyze_scanf::ScanfSpecifier::consumesDataArgument">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/FormatString.h", line = 582,
   FQN="clang::analyze_scanf::ScanfSpecifier::consumesDataArgument", NM="_ZNK5clang13analyze_scanf14ScanfSpecifier20consumesDataArgumentEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ScanfFormatString.cpp -nm=_ZNK5clang13analyze_scanf14ScanfSpecifier20consumesDataArgumentEv")
  //</editor-fold>
  public boolean consumesDataArgument() /*const*/ {
    return CS.consumesDataArgument() && !SuppressAssignment.$bool();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::analyze_scanf::ScanfSpecifier::getArgType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ScanfFormatString.cpp", line = 226,
   FQN="clang::analyze_scanf::ScanfSpecifier::getArgType", NM="_ZNK5clang13analyze_scanf14ScanfSpecifier10getArgTypeERNS_10ASTContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ScanfFormatString.cpp -nm=_ZNK5clang13analyze_scanf14ScanfSpecifier10getArgTypeERNS_10ASTContextE")
  //</editor-fold>
  public ArgType getArgType(final ASTContext /*&*/ Ctx) /*const*/ {
    final /*const*/ ScanfConversionSpecifier /*&*/ CS = getConversionSpecifier();
    if (!CS.consumesDataArgument()) {
      return ArgType.Invalid();
    }
    switch (CS.getKind()) {
     case dArg:
     case DArg:
     case iArg:
      // Signed int.
      switch (LM.getKind()) {
       case LengthModifier.Kind.None:
        return ArgType.PtrTo(new ArgType(new CanQual<Type>(Ctx.IntTy)));
       case LengthModifier.Kind.AsChar:
        return ArgType.PtrTo(new ArgType(ArgType.Kind.AnyCharTy));
       case LengthModifier.Kind.AsShort:
        return ArgType.PtrTo(new ArgType(new CanQual<Type>(Ctx.ShortTy)));
       case LengthModifier.Kind.AsLong:
        return ArgType.PtrTo(new ArgType(new CanQual<Type>(Ctx.LongTy)));
       case LengthModifier.Kind.AsLongLong:
       case LengthModifier.Kind.AsQuad:
        return ArgType.PtrTo(new ArgType(new CanQual<Type>(Ctx.LongLongTy)));
       case LengthModifier.Kind.AsInt64:
        return ArgType.PtrTo(new ArgType(Ctx.LongLongTy.$QualType(), $__int64));
       case LengthModifier.Kind.AsIntMax:
        return ArgType.PtrTo(new ArgType(Ctx.getIntMaxType().$QualType(), $("intmax_t")));
       case LengthModifier.Kind.AsSizeT:
        // FIXME: ssize_t.
        return new ArgType();
       case LengthModifier.Kind.AsPtrDiff:
        return ArgType.PtrTo(new ArgType(Ctx.getPointerDiffType(), $("ptrdiff_t")));
       case LengthModifier.Kind.AsLongDouble:
        // GNU extension.
        return ArgType.PtrTo(new ArgType(new CanQual<Type>(Ctx.LongLongTy)));
       case LengthModifier.Kind.AsAllocate:
       case LengthModifier.Kind.AsMAllocate:
       case LengthModifier.Kind.AsInt32:
       case LengthModifier.Kind.AsInt3264:
       case LengthModifier.Kind.AsWide:
        return ArgType.Invalid();
      }
     case oArg:
     case OArg:
     case uArg:
     case UArg:
     case xArg:
     case XArg:
      
      // Unsigned int.
      switch (LM.getKind()) {
       case LengthModifier.Kind.None:
        return ArgType.PtrTo(new ArgType(new CanQual<Type>(Ctx.UnsignedIntTy)));
       case LengthModifier.Kind.AsChar:
        return ArgType.PtrTo(new ArgType(new CanQual<Type>(Ctx.UnsignedCharTy)));
       case LengthModifier.Kind.AsShort:
        return ArgType.PtrTo(new ArgType(new CanQual<Type>(Ctx.UnsignedShortTy)));
       case LengthModifier.Kind.AsLong:
        return ArgType.PtrTo(new ArgType(new CanQual<Type>(Ctx.UnsignedLongTy)));
       case LengthModifier.Kind.AsLongLong:
       case LengthModifier.Kind.AsQuad:
        return ArgType.PtrTo(new ArgType(new CanQual<Type>(Ctx.UnsignedLongLongTy)));
       case LengthModifier.Kind.AsInt64:
        return ArgType.PtrTo(new ArgType(Ctx.UnsignedLongLongTy.$QualType(), $("unsigned __int64")));
       case LengthModifier.Kind.AsIntMax:
        return ArgType.PtrTo(new ArgType(Ctx.getUIntMaxType().$QualType(), $("uintmax_t")));
       case LengthModifier.Kind.AsSizeT:
        return ArgType.PtrTo(new ArgType(Ctx.getSizeType().$QualType(), $("size_t")));
       case LengthModifier.Kind.AsPtrDiff:
        // FIXME: Unsigned version of ptrdiff_t?
        return new ArgType();
       case LengthModifier.Kind.AsLongDouble:
        // GNU extension.
        return ArgType.PtrTo(new ArgType(new CanQual<Type>(Ctx.UnsignedLongLongTy)));
       case LengthModifier.Kind.AsAllocate:
       case LengthModifier.Kind.AsMAllocate:
       case LengthModifier.Kind.AsInt32:
       case LengthModifier.Kind.AsInt3264:
       case LengthModifier.Kind.AsWide:
        return ArgType.Invalid();
      }
     case aArg:
     case AArg:
     case eArg:
     case EArg:
     case fArg:
     case FArg:
     case gArg:
     case GArg:
      
      // Float.
      switch (LM.getKind()) {
       case LengthModifier.Kind.None:
        return ArgType.PtrTo(new ArgType(new CanQual<Type>(Ctx.FloatTy)));
       case LengthModifier.Kind.AsLong:
        return ArgType.PtrTo(new ArgType(new CanQual<Type>(Ctx.DoubleTy)));
       case LengthModifier.Kind.AsLongDouble:
        return ArgType.PtrTo(new ArgType(new CanQual<Type>(Ctx.LongDoubleTy)));
       default:
        return ArgType.Invalid();
      }
     case cArg:
     case sArg:
     case ScanListArg:
      
      // Char, string and scanlist.
      switch (LM.getKind()) {
       case LengthModifier.Kind.None:
        return ArgType.PtrTo(new ArgType(ArgType.Kind.AnyCharTy));
       case LengthModifier.Kind.AsLong:
       case LengthModifier.Kind.AsWide:
        return ArgType.PtrTo(new ArgType(Ctx.getWideCharType(), $wchar_t));
       case LengthModifier.Kind.AsAllocate:
       case LengthModifier.Kind.AsMAllocate:
        return ArgType.PtrTo(new ArgType(ArgType.Kind.CStrTy));
       case LengthModifier.Kind.AsShort:
        if (Ctx.getTargetInfo().getTriple().isOSMSVCRT()) {
          return ArgType.PtrTo(new ArgType(ArgType.Kind.AnyCharTy));
        }
       default:
        return ArgType.Invalid();
      }
     case CArg:
     case SArg:
      // FIXME: Mac OS X specific?
      switch (LM.getKind()) {
       case LengthModifier.Kind.None:
       case LengthModifier.Kind.AsWide:
        return ArgType.PtrTo(new ArgType(Ctx.getWideCharType(), $wchar_t));
       case LengthModifier.Kind.AsAllocate:
       case LengthModifier.Kind.AsMAllocate:
        return ArgType.PtrTo(new ArgType(ArgType.Kind.WCStrTy, $("wchar_t *")));
       case LengthModifier.Kind.AsShort:
        if (Ctx.getTargetInfo().getTriple().isOSMSVCRT()) {
          return ArgType.PtrTo(new ArgType(ArgType.Kind.AnyCharTy));
        }
       default:
        return ArgType.Invalid();
      }
     case pArg:
      
      // Pointer.
      return ArgType.PtrTo(new ArgType(ArgType.Kind.CPointerTy));
     case nArg:
      
      // Write-back.
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
       case LengthModifier.Kind.AsInt64:
        return ArgType.PtrTo(new ArgType(Ctx.LongLongTy.$QualType(), $__int64));
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
       case LengthModifier.Kind.AsWide:
        return ArgType.Invalid();
      }
     default:
      break;
    }
    
    return new ArgType();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::analyze_scanf::ScanfSpecifier::fixType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ScanfFormatString.cpp", line = 407,
   FQN="clang::analyze_scanf::ScanfSpecifier::fixType", NM="_ZN5clang13analyze_scanf14ScanfSpecifier7fixTypeENS_8QualTypeES2_RKNS_11LangOptionsERNS_10ASTContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ScanfFormatString.cpp -nm=_ZN5clang13analyze_scanf14ScanfSpecifier7fixTypeENS_8QualTypeES2_RKNS_11LangOptionsERNS_10ASTContextE")
  //</editor-fold>
  public boolean fixType(QualType QT, QualType RawQT, 
         final /*const*/ LangOptions /*&*/ LangOpt, 
         final ASTContext /*&*/ Ctx) {
    
    // %n is different from other conversion specifiers; don't try to fix it.
    if (CS.getKind() == ConversionSpecifier.Kind.nArg) {
      return false;
    }
    if (!QT.$arrow().isPointerType()) {
      return false;
    }
    
    QualType PT = QT.$arrow().getPointeeType();
    {
      
      // If it's an enum, get its underlying type.
      /*const*/ EnumType /*P*/ ETy = PT.$arrow().getAs$EnumType();
      if ((ETy != null)) {
        PT.$assignMove(ETy.getDecl().getIntegerType());
      }
    }
    
    /*const*/ BuiltinType /*P*/ BT = PT.$arrow().getAs$BuiltinType();
    if (!(BT != null)) {
      return false;
    }
    
    // Pointer to a character.
    if (PT.$arrow().isAnyCharacterType()) {
      CS.setKind(ConversionSpecifier.Kind.sArg);
      if (PT.$arrow().isWideCharType()) {
        LM.setKind(LengthModifier.Kind.AsWideChar);
      } else {
        LM.setKind(LengthModifier.Kind.None);
      }
      {
        
        // If we know the target array length, we can use it as a field width.
        /*const*/ ConstantArrayType /*P*/ CAT = Ctx.getAsConstantArrayType(new QualType(RawQT));
        if ((CAT != null)) {
          if (CAT.getSizeModifier() == ArrayType.ArraySizeModifier.Normal) {
            FieldWidth.$assignMove(new OptionalAmount(OptionalAmount.HowSpecified.Constant, 
                    $ullong2uint(CAT.getSize().getZExtValue() - $int2ullong(1)), 
                    $EMPTY, 0, false));
          }
        }
      }
      return true;
    }
    
    // Figure out the length modifier.
    switch (BT.getKind()) {
     case UInt:
     case Int:
     case Float:
      // no modifier
      LM.setKind(LengthModifier.Kind.None);
      break;
     case Char_U:
     case UChar:
     case Char_S:
     case SChar:
      
      // hh
      LM.setKind(LengthModifier.Kind.AsChar);
      break;
     case Short:
     case UShort:
      
      // h
      LM.setKind(LengthModifier.Kind.AsShort);
      break;
     case Long:
     case ULong:
     case Double:
      
      // l
      LM.setKind(LengthModifier.Kind.AsLong);
      break;
     case LongLong:
     case ULongLong:
      
      // ll
      LM.setKind(LengthModifier.Kind.AsLongLong);
      break;
     case LongDouble:
      
      // L
      LM.setKind(LengthModifier.Kind.AsLongDouble);
      break;
     default:
      
      // Don't know.
      return false;
    }
    
    // Handle size_t, ptrdiff_t, etc. that have dedicated length modifiers in C99.
    if (isa_TypedefType(PT) && (LangOpt.C99 || LangOpt.CPlusPlus11)) {
      namedTypeToLengthModifier(new QualType(PT), LM);
    }
    
    // If fixing the length modifier was enough, we are done.
    if (hasValidLengthModifier(Ctx.getTargetInfo())) {
      final /*const*/ ArgType /*&*/ AT = getArgType(Ctx);
      if (AT.isValid() && (AT.matchesType(Ctx, new QualType(QT)).getValue() != 0)) {
        return true;
      }
    }
    
    // Figure out the conversion specifier.
    if (PT.$arrow().isRealFloatingType()) {
      CS.setKind(ConversionSpecifier.Kind.fArg);
    } else if (PT.$arrow().isSignedIntegerType()) {
      CS.setKind(ConversionSpecifier.Kind.dArg);
    } else if (PT.$arrow().isUnsignedIntegerType()) {
      CS.setKind(ConversionSpecifier.Kind.uArg);
    } else {
      throw new llvm_unreachable("Unexpected type");
    }
    
    return true;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::analyze_scanf::ScanfSpecifier::toString">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ScanfFormatString.cpp", line = 517,
   FQN="clang::analyze_scanf::ScanfSpecifier::toString", NM="_ZNK5clang13analyze_scanf14ScanfSpecifier8toStringERN4llvm11raw_ostreamE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ScanfFormatString.cpp -nm=_ZNK5clang13analyze_scanf14ScanfSpecifier8toStringERN4llvm11raw_ostreamE")
  //</editor-fold>
  public void __toString(final raw_ostream /*&*/ os) /*const*/ {
    os.$out(/*KEEP_STR*/$PERCENT);
    if (usesPositionalArg()) {
      os.$out_uint(getPositionalArgIndex()).$out(/*KEEP_STR*/$DOLLAR);
    }
    if (SuppressAssignment.$bool()) {
      os.$out(/*KEEP_STR*/$STAR);
    }
    
    FieldWidth.__toString(os);
    os.$out(LM.__toString());
    os.$out(CS.__toString());
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::analyze_scanf::ScanfSpecifier::Parse">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/FormatString.h", line = 593,
   FQN="clang::analyze_scanf::ScanfSpecifier::Parse", NM="_ZN5clang13analyze_scanf14ScanfSpecifier5ParseEPKcS3_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ScanfFormatString.cpp -nm=_ZN5clang13analyze_scanf14ScanfSpecifier5ParseEPKcS3_")
  //</editor-fold>
  public static ScanfSpecifier Parse(/*const*/char$ptr/*char P*/ beg, /*const*/char$ptr/*char P*/ end) {
    throw new UnsupportedOperationException("<<<DeclJavaPrinter::VisitFunctionDecl NULL BODY IN USED Translation Unit>>>");
  }


  //<editor-fold defaultstate="collapsed" desc="clang::analyze_scanf::ScanfSpecifier::ScanfSpecifier">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/FormatString.h", line = 559,
   FQN="clang::analyze_scanf::ScanfSpecifier::ScanfSpecifier", NM="_ZN5clang13analyze_scanf14ScanfSpecifierC1ERKS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ScanfFormatString.cpp -nm=_ZN5clang13analyze_scanf14ScanfSpecifierC1ERKS1_")
  //</editor-fold>
  public /*inline*/ ScanfSpecifier(final /*const*/ ScanfSpecifier /*&*/ $Prm0) {
    // : FormatSpecifier(), SuppressAssignment(.SuppressAssignment) 
    //START JInit
    super($Prm0);
    this.SuppressAssignment = new OptionalFlag($Prm0.SuppressAssignment);
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="clang::analyze_scanf::ScanfSpecifier::ScanfSpecifier">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/FormatString.h", line = 559,
   FQN="clang::analyze_scanf::ScanfSpecifier::ScanfSpecifier", NM="_ZN5clang13analyze_scanf14ScanfSpecifierC1EOS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ScanfFormatString.cpp -nm=_ZN5clang13analyze_scanf14ScanfSpecifierC1EOS1_")
  //</editor-fold>
  public /*inline*/ ScanfSpecifier(JD$Move _dparam, final ScanfSpecifier /*&&*/$Prm0) {
    // : FormatSpecifier(static_cast<ScanfSpecifier &&>()), SuppressAssignment(static_cast<ScanfSpecifier &&>().SuppressAssignment) 
    //START JInit
    super(JD$Move.INSTANCE, $Prm0);
    this.SuppressAssignment = new OptionalFlag(JD$Move.INSTANCE, $Prm0.SuppressAssignment);
    //END JInit
  }

  
  @Override public String toString() {
    return "" + "SuppressAssignment=" + SuppressAssignment // NOI18N
              + super.toString(); // NOI18N
  }
}
