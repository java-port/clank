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

import org.clank.support.*;
import org.clank.support.aliases.*;
import static org.clank.support.NativePointer.*;
import org.llvm.support.*;
import org.clang.basic.*;

//<editor-fold defaultstate="collapsed" desc="clang::TypeTagForDatatypeAttr">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/Attrs.inc", line = 6752,
 FQN="clang::TypeTagForDatatypeAttr", NM="_ZN5clang22TypeTagForDatatypeAttrE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZN5clang22TypeTagForDatatypeAttrE")
//</editor-fold>
public class TypeTagForDatatypeAttr extends /*public*/ InheritableAttr {
  private IdentifierInfo /*P*/ argumentKind;
  
  private TypeSourceInfo /*P*/ matchingCType;
  
  private boolean layoutCompatible;
  
  private boolean mustBeNull;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::TypeTagForDatatypeAttr::CreateImplicit">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/Attrs.inc", line = 6762,
   FQN="clang::TypeTagForDatatypeAttr::CreateImplicit", NM="_ZN5clang22TypeTagForDatatypeAttr14CreateImplicitERNS_10ASTContextEPNS_14IdentifierInfoEPNS_14TypeSourceInfoEbbNS_11SourceRangeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZN5clang22TypeTagForDatatypeAttr14CreateImplicitERNS_10ASTContextEPNS_14IdentifierInfoEPNS_14TypeSourceInfoEbbNS_11SourceRangeE")
  //</editor-fold>
  public static TypeTagForDatatypeAttr /*P*/ CreateImplicit(final ASTContext /*&*/ Ctx, IdentifierInfo /*P*/ ArgumentKind, TypeSourceInfo /*P*/ MatchingCType, boolean LayoutCompatible, boolean MustBeNull) {
    return CreateImplicit(Ctx, ArgumentKind, MatchingCType, LayoutCompatible, MustBeNull, new SourceRange());
  }
  public static TypeTagForDatatypeAttr /*P*/ CreateImplicit(final ASTContext /*&*/ Ctx, IdentifierInfo /*P*/ ArgumentKind, TypeSourceInfo /*P*/ MatchingCType, boolean LayoutCompatible, boolean MustBeNull, SourceRange Loc/*= SourceRange()*/) {
    TypeTagForDatatypeAttr /*P*/ A = /*FIXME:NEW_EXPR*//*new (Ctx)*/ new TypeTagForDatatypeAttr(new SourceRange(Loc), Ctx, ArgumentKind, MatchingCType, LayoutCompatible, MustBeNull, 0);
    A.setImplicit(true);
    return A;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::TypeTagForDatatypeAttr::TypeTagForDatatypeAttr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/Attrs.inc", line = 6768,
   FQN="clang::TypeTagForDatatypeAttr::TypeTagForDatatypeAttr", NM="_ZN5clang22TypeTagForDatatypeAttrC1ENS_11SourceRangeERNS_10ASTContextEPNS_14IdentifierInfoEPNS_14TypeSourceInfoEbbj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZN5clang22TypeTagForDatatypeAttrC1ENS_11SourceRangeERNS_10ASTContextEPNS_14IdentifierInfoEPNS_14TypeSourceInfoEbbj")
  //</editor-fold>
  public TypeTagForDatatypeAttr(SourceRange R, final ASTContext /*&*/ Ctx, 
      IdentifierInfo /*P*/ ArgumentKind, 
      TypeSourceInfo /*P*/ MatchingCType, 
      boolean LayoutCompatible, 
      boolean MustBeNull, 
      /*uint*/int SI) {
    // : InheritableAttr(attr::TypeTagForDatatype, R, SI, false, false), argumentKind(ArgumentKind), matchingCType(MatchingCType), layoutCompatible(LayoutCompatible), mustBeNull(MustBeNull) 
    //START JInit
    super(attr.Kind.TypeTagForDatatype, new SourceRange(R), SI, false, false);
    this.argumentKind = ArgumentKind;
    this.matchingCType = MatchingCType;
    this.layoutCompatible = LayoutCompatible;
    this.mustBeNull = MustBeNull;
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::TypeTagForDatatypeAttr::clone">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/AttrImpl.inc", line = 6409,
   FQN="clang::TypeTagForDatatypeAttr::clone", NM="_ZNK5clang22TypeTagForDatatypeAttr5cloneERNS_10ASTContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZNK5clang22TypeTagForDatatypeAttr5cloneERNS_10ASTContextE")
  //</editor-fold>
  public TypeTagForDatatypeAttr /*P*/ clone(final ASTContext /*&*/ C) /*const*/ {
    TypeTagForDatatypeAttr /*P*/ A = /*FIXME:NEW_EXPR*//*new (C)*/ new TypeTagForDatatypeAttr(new SourceRange(getLocation()), C, argumentKind, matchingCType, layoutCompatible, mustBeNull, getSpellingListIndex());
    A.Inherited = Inherited;
    A.IsPackExpansion = IsPackExpansion;
    A.Implicit = Implicit;
    return A;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TypeTagForDatatypeAttr::printPretty">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/AttrImpl.inc", line = 6417,
   FQN="clang::TypeTagForDatatypeAttr::printPretty", NM="_ZNK5clang22TypeTagForDatatypeAttr11printPrettyERN4llvm11raw_ostreamERKNS_14PrintingPolicyE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZNK5clang22TypeTagForDatatypeAttr11printPrettyERN4llvm11raw_ostreamERKNS_14PrintingPolicyE")
  //</editor-fold>
  public void printPretty(final raw_ostream /*&*/ OS, final /*const*/ PrintingPolicy /*&*/ Policy) /*const*/ {
    switch (SpellingListIndex) {
     default:
      throw new llvm_unreachable("Unknown attribute spelling!");
//      break;
     case 0:
      {
        OS.$out(/*KEEP_STR*/" __attribute__((type_tag_for_datatype(").$out(getArgumentKind().getName()).$out(/*KEEP_STR*/$COMMA_SPACE).$out(getMatchingCType().getAsString()).$out(/*KEEP_STR*/$COMMA_SPACE).$out_int((getLayoutCompatible() ? 1 : 0)).$out(/*KEEP_STR*/$COMMA_SPACE).$out_int((getMustBeNull() ? 1 : 0)).$out(/*KEEP_STR*/")))");
        break;
      }
    }
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TypeTagForDatatypeAttr::getSpelling">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/AttrImpl.inc", line = 6429,
   FQN="clang::TypeTagForDatatypeAttr::getSpelling", NM="_ZNK5clang22TypeTagForDatatypeAttr11getSpellingEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZNK5clang22TypeTagForDatatypeAttr11getSpellingEv")
  //</editor-fold>
  public /*const*/char$ptr/*char P*/ getSpelling() /*const*/ {
    switch (SpellingListIndex) {
     default:
      throw new llvm_unreachable("Unknown attribute spelling!");
//      return $("(No spelling)");
     case 0:
      return $("type_tag_for_datatype");
    }
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TypeTagForDatatypeAttr::getArgumentKind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/Attrs.inc", line = 6787,
   FQN="clang::TypeTagForDatatypeAttr::getArgumentKind", NM="_ZNK5clang22TypeTagForDatatypeAttr15getArgumentKindEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZNK5clang22TypeTagForDatatypeAttr15getArgumentKindEv")
  //</editor-fold>
  public IdentifierInfo /*P*/ getArgumentKind() /*const*/ {
    return argumentKind;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::TypeTagForDatatypeAttr::getMatchingCType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/Attrs.inc", line = 6791,
   FQN="clang::TypeTagForDatatypeAttr::getMatchingCType", NM="_ZNK5clang22TypeTagForDatatypeAttr16getMatchingCTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZNK5clang22TypeTagForDatatypeAttr16getMatchingCTypeEv")
  //</editor-fold>
  public QualType getMatchingCType() /*const*/ {
    return matchingCType.getType();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TypeTagForDatatypeAttr::getMatchingCTypeLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/Attrs.inc", line = 6793,
   FQN="clang::TypeTagForDatatypeAttr::getMatchingCTypeLoc", NM="_ZNK5clang22TypeTagForDatatypeAttr19getMatchingCTypeLocEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZNK5clang22TypeTagForDatatypeAttr19getMatchingCTypeLocEv")
  //</editor-fold>
  public TypeSourceInfo /*P*/ getMatchingCTypeLoc() /*const*/ {
    return matchingCType;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::TypeTagForDatatypeAttr::getLayoutCompatible">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/Attrs.inc", line = 6797,
   FQN="clang::TypeTagForDatatypeAttr::getLayoutCompatible", NM="_ZNK5clang22TypeTagForDatatypeAttr19getLayoutCompatibleEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZNK5clang22TypeTagForDatatypeAttr19getLayoutCompatibleEv")
  //</editor-fold>
  public boolean getLayoutCompatible() /*const*/ {
    return layoutCompatible;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::TypeTagForDatatypeAttr::getMustBeNull">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/Attrs.inc", line = 6801,
   FQN="clang::TypeTagForDatatypeAttr::getMustBeNull", NM="_ZNK5clang22TypeTagForDatatypeAttr13getMustBeNullEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZNK5clang22TypeTagForDatatypeAttr13getMustBeNullEv")
  //</editor-fold>
  public boolean getMustBeNull() /*const*/ {
    return mustBeNull;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::TypeTagForDatatypeAttr::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/Attrs.inc", line = 6807,
   FQN="clang::TypeTagForDatatypeAttr::classof", NM="_ZN5clang22TypeTagForDatatypeAttr7classofEPKNS_4AttrE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZN5clang22TypeTagForDatatypeAttr7classofEPKNS_4AttrE")
  //</editor-fold>
  public static boolean classof(/*const*/ Attr /*P*/ A) {
    return A.getKind() == attr.Kind.TypeTagForDatatype;
  }

  
  @Override public String toString() {
    return "" + "argumentKind=" + argumentKind // NOI18N
              + ", matchingCType=" + matchingCType // NOI18N
              + ", layoutCompatible=" + layoutCompatible // NOI18N
              + ", mustBeNull=" + mustBeNull // NOI18N
              + super.toString(); // NOI18N
  }
}
