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

package org.clang.ast;

import static org.clank.support.Native.$Deref;
import org.clank.support.*;
import org.clank.support.aliases.*;
import org.clank.support.JavaDifferentiators.*;
import static org.llvm.support.llvm.*;
import static org.clank.support.Unsigned.*;
import org.llvm.support.*;
import org.clang.basic.*;


/// \brief Wrapper for source info for builtin types.
//<editor-fold defaultstate="collapsed" desc="clang::BuiltinTypeLoc">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeLoc.h", line = 517,
 FQN="clang::BuiltinTypeLoc", NM="_ZN5clang14BuiltinTypeLocE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ARCMigrate/ObjCMT.cpp -nm=_ZN5clang14BuiltinTypeLocE")
//</editor-fold>
public class BuiltinTypeLoc extends /*public*/ Concrete$UnqualTypeLoc<BuiltinTypeLoc, BuiltinType, BuiltinLocInfo> {
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::BuiltinTypeLoc::getBuiltinLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeLoc.h", line = 522,
   FQN="clang::BuiltinTypeLoc::getBuiltinLoc", NM="_ZNK5clang14BuiltinTypeLoc13getBuiltinLocEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ARCMigrate/ObjCMT.cpp -nm=_ZNK5clang14BuiltinTypeLoc13getBuiltinLocEv")
  //</editor-fold>
  public SourceLocation getBuiltinLoc() /*const*/ {
    return new SourceLocation(getLocalData().BuiltinLoc);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::BuiltinTypeLoc::setBuiltinLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeLoc.h", line = 525,
   FQN="clang::BuiltinTypeLoc::setBuiltinLoc", NM="_ZN5clang14BuiltinTypeLoc13setBuiltinLocENS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ARCMigrate/ObjCMT.cpp -nm=_ZN5clang14BuiltinTypeLoc13setBuiltinLocENS_14SourceLocationE")
  //</editor-fold>
  public void setBuiltinLoc(SourceLocation Loc) {
    getLocalData().BuiltinLoc.$assign(Loc);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::BuiltinTypeLoc::getNameLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeLoc.h", line = 529,
   FQN="clang::BuiltinTypeLoc::getNameLoc", NM="_ZNK5clang14BuiltinTypeLoc10getNameLocEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ARCMigrate/ObjCMT.cpp -nm=_ZNK5clang14BuiltinTypeLoc10getNameLocEv")
  //</editor-fold>
  public SourceLocation getNameLoc() /*const*/ {
    return getBuiltinLoc();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::BuiltinTypeLoc::getWrittenBuiltinSpecs">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeLoc.h", line = 531,
   FQN="clang::BuiltinTypeLoc::getWrittenBuiltinSpecs", NM="_ZN5clang14BuiltinTypeLoc22getWrittenBuiltinSpecsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ARCMigrate/ObjCMT.cpp -nm=_ZN5clang14BuiltinTypeLoc22getWrittenBuiltinSpecsEv")
  //</editor-fold>
  public WrittenBuiltinSpecs /*&*/ getWrittenBuiltinSpecs() {
    return $Deref((((/*static_cast*/WrittenBuiltinSpecs /*P*/ )(getExtraLocalData().$star()))));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::BuiltinTypeLoc::getWrittenBuiltinSpecs">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeLoc.h", line = 534,
   FQN="clang::BuiltinTypeLoc::getWrittenBuiltinSpecs", NM="_ZNK5clang14BuiltinTypeLoc22getWrittenBuiltinSpecsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ARCMigrate/ObjCMT.cpp -nm=_ZNK5clang14BuiltinTypeLoc22getWrittenBuiltinSpecsEv")
  //</editor-fold>
  public /*const*/ WrittenBuiltinSpecs /*&*/ getWrittenBuiltinSpecs$Const() /*const*/ {
    return $Deref((((/*static_cast*/WrittenBuiltinSpecs /*P*/ )(getExtraLocalData().$star()))));
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::BuiltinTypeLoc::needsExtraLocalData">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeLoc.h", line = 538,
   FQN="clang::BuiltinTypeLoc::needsExtraLocalData", NM="_ZNK5clang14BuiltinTypeLoc19needsExtraLocalDataEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ARCMigrate/ObjCMT.cpp -nm=_ZNK5clang14BuiltinTypeLoc19needsExtraLocalDataEv")
  //</editor-fold>
  public boolean needsExtraLocalData() /*const*/ {
    BuiltinType.Kind bk = getTypePtr().getKind();
    return (bk.getValue() >= BuiltinType.Kind.UShort.getValue() && bk.getValue() <= BuiltinType.Kind.UInt128.getValue())
       || (bk.getValue() >= BuiltinType.Kind.Short.getValue() && bk.getValue() <= BuiltinType.Kind.Float128.getValue())
       || bk == BuiltinType.Kind.UChar
       || bk == BuiltinType.Kind.SChar;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::BuiltinTypeLoc::getExtraLocalDataSize">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeLoc.h", line = 546,
   FQN="clang::BuiltinTypeLoc::getExtraLocalDataSize", NM="_ZNK5clang14BuiltinTypeLoc21getExtraLocalDataSizeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ARCMigrate/ObjCMT.cpp -nm=_ZNK5clang14BuiltinTypeLoc21getExtraLocalDataSizeEv")
  //</editor-fold>
  public /*uint*/int getExtraLocalDataSize() /*const*/ {
    return needsExtraLocalData() ? $sizeof_WrittenBuiltinSpecs() : 0;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::BuiltinTypeLoc::getExtraLocalDataAlignment">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeLoc.h", line = 550,
   FQN="clang::BuiltinTypeLoc::getExtraLocalDataAlignment", NM="_ZNK5clang14BuiltinTypeLoc26getExtraLocalDataAlignmentEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ARCMigrate/ObjCMT.cpp -nm=_ZNK5clang14BuiltinTypeLoc26getExtraLocalDataAlignmentEv")
  //</editor-fold>
  public /*uint*/int getExtraLocalDataAlignment() /*const*/ {
    return needsExtraLocalData() ? alignOf(WrittenBuiltinSpecs.class) : 1;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::BuiltinTypeLoc::getLocalSourceRange">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeLoc.h", line = 554,
   FQN="clang::BuiltinTypeLoc::getLocalSourceRange", NM="_ZNK5clang14BuiltinTypeLoc19getLocalSourceRangeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ARCMigrate/ObjCMT.cpp -nm=_ZNK5clang14BuiltinTypeLoc19getLocalSourceRangeEv")
  //</editor-fold>
  public SourceRange getLocalSourceRange() /*const*/ {
    return new SourceRange(getBuiltinLoc(), getBuiltinLoc());
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::BuiltinTypeLoc::getWrittenSignSpec">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeLoc.h", line = 558,
   FQN="clang::BuiltinTypeLoc::getWrittenSignSpec", NM="_ZNK5clang14BuiltinTypeLoc18getWrittenSignSpecEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ARCMigrate/ObjCMT.cpp -nm=_ZNK5clang14BuiltinTypeLoc18getWrittenSignSpecEv")
  //</editor-fold>
  public TypeSpecifierSign getWrittenSignSpec() /*const*/ {
    if (needsExtraLocalData()) {
      return /*static_cast*/TypeSpecifierSign.valueOf($uchar2uint(getWrittenBuiltinSpecs$Const().Sign));
    } else {
      return TypeSpecifierSign.TSS_unspecified;
    }
  }

  //<editor-fold defaultstate="collapsed" desc="clang::BuiltinTypeLoc::hasWrittenSignSpec">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeLoc.h", line = 564,
   FQN="clang::BuiltinTypeLoc::hasWrittenSignSpec", NM="_ZNK5clang14BuiltinTypeLoc18hasWrittenSignSpecEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ARCMigrate/ObjCMT.cpp -nm=_ZNK5clang14BuiltinTypeLoc18hasWrittenSignSpecEv")
  //</editor-fold>
  public boolean hasWrittenSignSpec() /*const*/ {
    return getWrittenSignSpec() != TypeSpecifierSign.TSS_unspecified;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::BuiltinTypeLoc::setWrittenSignSpec">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeLoc.h", line = 567,
   FQN="clang::BuiltinTypeLoc::setWrittenSignSpec", NM="_ZN5clang14BuiltinTypeLoc18setWrittenSignSpecENS_17TypeSpecifierSignE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ARCMigrate/ObjCMT.cpp -nm=_ZN5clang14BuiltinTypeLoc18setWrittenSignSpecENS_17TypeSpecifierSignE")
  //</editor-fold>
  public void setWrittenSignSpec(TypeSpecifierSign written) {
    if (needsExtraLocalData()) {
      getWrittenBuiltinSpecs().Sign = $uint2uint_2bits(written.getValue());
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::BuiltinTypeLoc::getWrittenWidthSpec">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeLoc.h", line = 572,
   FQN="clang::BuiltinTypeLoc::getWrittenWidthSpec", NM="_ZNK5clang14BuiltinTypeLoc19getWrittenWidthSpecEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ARCMigrate/ObjCMT.cpp -nm=_ZNK5clang14BuiltinTypeLoc19getWrittenWidthSpecEv")
  //</editor-fold>
  public TypeSpecifierWidth getWrittenWidthSpec() /*const*/ {
    if (needsExtraLocalData()) {
      return /*static_cast*/TypeSpecifierWidth.valueOf($uchar2uint(getWrittenBuiltinSpecs$Const().Width));
    } else {
      return TypeSpecifierWidth.TSW_unspecified;
    }
  }

  //<editor-fold defaultstate="collapsed" desc="clang::BuiltinTypeLoc::hasWrittenWidthSpec">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeLoc.h", line = 578,
   FQN="clang::BuiltinTypeLoc::hasWrittenWidthSpec", NM="_ZNK5clang14BuiltinTypeLoc19hasWrittenWidthSpecEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ARCMigrate/ObjCMT.cpp -nm=_ZNK5clang14BuiltinTypeLoc19hasWrittenWidthSpecEv")
  //</editor-fold>
  public boolean hasWrittenWidthSpec() /*const*/ {
    return getWrittenWidthSpec() != TypeSpecifierWidth.TSW_unspecified;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::BuiltinTypeLoc::setWrittenWidthSpec">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeLoc.h", line = 581,
   FQN="clang::BuiltinTypeLoc::setWrittenWidthSpec", NM="_ZN5clang14BuiltinTypeLoc19setWrittenWidthSpecENS_18TypeSpecifierWidthE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ARCMigrate/ObjCMT.cpp -nm=_ZN5clang14BuiltinTypeLoc19setWrittenWidthSpecENS_18TypeSpecifierWidthE")
  //</editor-fold>
  public void setWrittenWidthSpec(TypeSpecifierWidth written) {
    if (needsExtraLocalData()) {
      getWrittenBuiltinSpecs().Width = $uint2uint_2bits(written.getValue());
    }
  }

  //<editor-fold defaultstate="collapsed" desc="clang::BuiltinTypeLoc::getWrittenTypeSpec">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/TypeLoc.cpp", line = 289,
   FQN="clang::BuiltinTypeLoc::getWrittenTypeSpec", NM="_ZNK5clang14BuiltinTypeLoc18getWrittenTypeSpecEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypeLoc.cpp -nm=_ZNK5clang14BuiltinTypeLoc18getWrittenTypeSpecEv")
  //</editor-fold>
  public TypeSpecifierType getWrittenTypeSpec() /*const*/ {
    if (needsExtraLocalData()) {
      return /*static_cast*/TypeSpecifierType.valueOf($uchar2uint(getWrittenBuiltinSpecs$Const().Type));
    }
    switch (getTypePtr().getKind()) {
     case Void:
      return TypeSpecifierType.TST_void;
     case Bool:
      return TypeSpecifierType.TST_bool;
     case Char_U:
     case Char_S:
      return TypeSpecifierType.TST_char;
     case Char16:
      return TypeSpecifierType.TST_char16;
     case Char32:
      return TypeSpecifierType.TST_char32;
     case WChar_S:
     case WChar_U:
      return TypeSpecifierType.TST_wchar;
     case UChar:
     case UShort:
     case UInt:
     case ULong:
     case ULongLong:
     case UInt128:
     case SChar:
     case Short:
     case Int:
     case Long:
     case LongLong:
     case Int128:
     case Half:
     case Float:
     case Double:
     case LongDouble:
     case Float128:
      throw new llvm_unreachable("Builtin type needs extra local data!");
     case NullPtr:
     case Overload:
     case Dependent:
     case BoundMember:
     case UnknownAny:
     case ARCUnbridgedCast:
     case PseudoObject:
     case ObjCId:
     case ObjCClass:
     case ObjCSel:
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
     case OCLSampler:
     case OCLEvent:
     case OCLClkEvent:
     case OCLQueue:
     case OCLNDRange:
     case OCLReserveID:
     case BuiltinFn:
     case OMPArraySection:
      return TypeSpecifierType.TST_unspecified;
    }
    throw new llvm_unreachable("Invalid BuiltinType Kind!");
  }


  //<editor-fold defaultstate="collapsed" desc="clang::BuiltinTypeLoc::hasWrittenTypeSpec">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeLoc.h", line = 587,
   FQN="clang::BuiltinTypeLoc::hasWrittenTypeSpec", NM="_ZNK5clang14BuiltinTypeLoc18hasWrittenTypeSpecEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ARCMigrate/ObjCMT.cpp -nm=_ZNK5clang14BuiltinTypeLoc18hasWrittenTypeSpecEv")
  //</editor-fold>
  public boolean hasWrittenTypeSpec() /*const*/ {
    return getWrittenTypeSpec() != TypeSpecifierType.TST_unspecified;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::BuiltinTypeLoc::setWrittenTypeSpec">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeLoc.h", line = 590,
   FQN="clang::BuiltinTypeLoc::setWrittenTypeSpec", NM="_ZN5clang14BuiltinTypeLoc18setWrittenTypeSpecENS_17TypeSpecifierTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ARCMigrate/ObjCMT.cpp -nm=_ZN5clang14BuiltinTypeLoc18setWrittenTypeSpecENS_17TypeSpecifierTypeE")
  //</editor-fold>
  public void setWrittenTypeSpec(TypeSpecifierType written) {
    if (needsExtraLocalData()) {
      getWrittenBuiltinSpecs().Type = $uint2uint_6bits(written.getValue());
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::BuiltinTypeLoc::hasModeAttr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeLoc.h", line = 595,
   FQN="clang::BuiltinTypeLoc::hasModeAttr", NM="_ZNK5clang14BuiltinTypeLoc11hasModeAttrEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ARCMigrate/ObjCMT.cpp -nm=_ZNK5clang14BuiltinTypeLoc11hasModeAttrEv")
  //</editor-fold>
  public boolean hasModeAttr() /*const*/ {
    if (needsExtraLocalData()) {
      return getWrittenBuiltinSpecs$Const().ModeAttr;
    } else {
      return false;
    }
  }

  //<editor-fold defaultstate="collapsed" desc="clang::BuiltinTypeLoc::setModeAttr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeLoc.h", line = 601,
   FQN="clang::BuiltinTypeLoc::setModeAttr", NM="_ZN5clang14BuiltinTypeLoc11setModeAttrEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ARCMigrate/ObjCMT.cpp -nm=_ZN5clang14BuiltinTypeLoc11setModeAttrEb")
  //</editor-fold>
  public void setModeAttr(boolean written) {
    if (needsExtraLocalData()) {
      getWrittenBuiltinSpecs().ModeAttr = written;
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::BuiltinTypeLoc::initializeLocal">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*call init data*/,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeLoc.h", line = 606,
   FQN="clang::BuiltinTypeLoc::initializeLocal", NM="_ZN5clang14BuiltinTypeLoc15initializeLocalERNS_10ASTContextENS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ARCMigrate/ObjCMT.cpp -nm=_ZN5clang14BuiltinTypeLoc15initializeLocalERNS_10ASTContextENS_14SourceLocationE")
  //</editor-fold>
  public final void initializeLocal(final ASTContext /*&*/ Context, SourceLocation Loc) {    
    setBuiltinLoc(/*NO_COPY*/Loc);
    if (needsExtraLocalData()) {
      final WrittenBuiltinSpecs /*&*/ wbs = getWrittenBuiltinSpecs();
      wbs.Sign = $uint2uint_2bits(TypeSpecifierSign.TSS_unspecified.getValue());
      wbs.Width = $uint2uint_2bits(TypeSpecifierWidth.TSW_unspecified.getValue());
      wbs.Type = $uint2uint_6bits(TypeSpecifierType.TST_unspecified.getValue());
      wbs.ModeAttr = false;
    }
  }

  //<editor-fold defaultstate="collapsed" desc="clang::BuiltinTypeLoc::BuiltinTypeLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeLoc.h", line = 517,
   FQN="clang::BuiltinTypeLoc::BuiltinTypeLoc", NM="_ZN5clang14BuiltinTypeLocC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ARCMigrate/ObjCMT.cpp -nm=_ZN5clang14BuiltinTypeLocC1Ev")
  //</editor-fold>
  public /*inline*/ BuiltinTypeLoc() {
    // : ConcreteTypeLoc<UnqualTypeLoc, BuiltinTypeLoc, BuiltinType, BuiltinLocInfo>() 
    //START JInit
    super();
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="clang::BuiltinTypeLoc::BuiltinTypeLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeLoc.h", line = 517,
   FQN="clang::BuiltinTypeLoc::BuiltinTypeLoc", NM="_ZN5clang14BuiltinTypeLocC1ERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ARCMigrate/ObjCMT.cpp -nm=_ZN5clang14BuiltinTypeLocC1ERKS0_")
  //</editor-fold>
  public /*inline*/ BuiltinTypeLoc(final /*const*/ BuiltinTypeLoc /*&*/ $Prm0) {
    // : ConcreteTypeLoc<UnqualTypeLoc, BuiltinTypeLoc, BuiltinType, BuiltinLocInfo>() 
    //START JInit
    super($Prm0);
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="clang::BuiltinTypeLoc::BuiltinTypeLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeLoc.h", line = 517,
   FQN="clang::BuiltinTypeLoc::BuiltinTypeLoc", NM="_ZN5clang14BuiltinTypeLocC1EOS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ARCMigrate/ObjCMT.cpp -nm=_ZN5clang14BuiltinTypeLocC1EOS0_")
  //</editor-fold>
  public /*inline*/ BuiltinTypeLoc(JD$Move _dparam, final BuiltinTypeLoc /*&&*/$Prm0) {
    // : ConcreteTypeLoc<UnqualTypeLoc, BuiltinTypeLoc, BuiltinType, BuiltinLocInfo>(static_cast<BuiltinTypeLoc &&>()) 
    //START JInit
    super(JD$Move.INSTANCE, $Prm0);
    //END JInit
  }

  @Override protected final void initJavaExtraLocalData(type$ptr extraLocalData$Ptr, int NumExtra) {
    assert NumExtra == 1;
    assert needsExtraLocalData();
    assert extraLocalData$Ptr.$star() == null : "Must be null: " + extraLocalData$Ptr.$star();
    extraLocalData$Ptr.$set(new WrittenBuiltinSpecs());
  }
  
  @Override protected final BuiltinLocInfo createJavaEmptyLocalTypeLocInfo() { return new BuiltinLocInfo(); }
  
  protected static int $sizeof_WrittenBuiltinSpecs() { return 1;  }    
  @Override protected Class<BuiltinType> getTypeClass() { return BuiltinType.class; }
  
  @Override public String toString() {
    return "" + super.toString(); // NOI18N
  }
}
