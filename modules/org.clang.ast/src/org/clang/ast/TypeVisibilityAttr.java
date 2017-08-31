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
import org.clank.support.JavaDifferentiators.*;
import static org.clank.support.NativePointer.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.clang.basic.*;

//<editor-fold defaultstate="collapsed" desc="clang::TypeVisibilityAttr">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/Attrs.inc", line = 6810,
 FQN="clang::TypeVisibilityAttr", NM="_ZN5clang18TypeVisibilityAttrE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZN5clang18TypeVisibilityAttrE")
//</editor-fold>
public class TypeVisibilityAttr extends /*public*/ InheritableAttr {
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::TypeVisibilityAttr::VisibilityType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/Attrs.inc", line = 6812,
   FQN="clang::TypeVisibilityAttr::VisibilityType", NM="_ZN5clang18TypeVisibilityAttr14VisibilityTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZN5clang18TypeVisibilityAttr14VisibilityTypeE")
  //</editor-fold>
  public enum VisibilityType implements Native.ComparableLower {
    Default(0),
    Hidden(Default.getValue() + 1),
    Protected(Hidden.getValue() + 1);

    //<editor-fold defaultstate="collapsed" desc="hidden">
    public static VisibilityType valueOf(int val) {
      VisibilityType out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
      assert out != null : "no value for " + val;
      assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
      return out;
    }

    private static final class Values {
      private static final VisibilityType[] VALUES;
      private static final VisibilityType[] _VALUES; // [0] not used
      static {
        int max = 0;
        int min = 0;
        for (VisibilityType kind : VisibilityType.values()) {
          if (kind.value > max) { max = kind.value; }
          if (kind.value < min) { min = kind.value; }
        }
        _VALUES = new VisibilityType[min < 0 ? (1-min) : 0];
        VALUES = new VisibilityType[max >= 0 ? (1+max) : 0];
        for (VisibilityType kind : VisibilityType.values()) {
          if (kind.value < 0) {
            _VALUES[-kind.value] = kind;
          } else {
            VALUES[kind.value] = kind;
          }
        }
      }
    }

    private final /*uint*/int value;
    private VisibilityType(int val) { this.value = (/*uint*/int)val;}
    public /*uint*/int getValue() { return value;}
    @Override public boolean $less(Object obj) { return Unsigned.$less_uint(value, ((VisibilityType)obj).value);}
    @Override public boolean $lesseq(Object obj) { return Unsigned.$lesseq_uint(value, ((VisibilityType)obj).value);}
    //</editor-fold>
  };
/*private:*/
  private VisibilityType visibility;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::TypeVisibilityAttr::CreateImplicit">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/Attrs.inc", line = 6821,
   FQN="clang::TypeVisibilityAttr::CreateImplicit", NM="_ZN5clang18TypeVisibilityAttr14CreateImplicitERNS_10ASTContextENS0_14VisibilityTypeENS_11SourceRangeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZN5clang18TypeVisibilityAttr14CreateImplicitERNS_10ASTContextENS0_14VisibilityTypeENS_11SourceRangeE")
  //</editor-fold>
  public static TypeVisibilityAttr /*P*/ CreateImplicit(final ASTContext /*&*/ Ctx, VisibilityType Visibility) {
    return CreateImplicit(Ctx, Visibility, new SourceRange());
  }
  public static TypeVisibilityAttr /*P*/ CreateImplicit(final ASTContext /*&*/ Ctx, VisibilityType Visibility, SourceRange Loc/*= SourceRange()*/) {
    TypeVisibilityAttr /*P*/ A = /*FIXME:NEW_EXPR*//*new (Ctx)*/ new TypeVisibilityAttr(new SourceRange(Loc), Ctx, Visibility, 0);
    A.setImplicit(true);
    return A;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::TypeVisibilityAttr::TypeVisibilityAttr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/Attrs.inc", line = 6827,
   FQN="clang::TypeVisibilityAttr::TypeVisibilityAttr", NM="_ZN5clang18TypeVisibilityAttrC1ENS_11SourceRangeERNS_10ASTContextENS0_14VisibilityTypeEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZN5clang18TypeVisibilityAttrC1ENS_11SourceRangeERNS_10ASTContextENS0_14VisibilityTypeEj")
  //</editor-fold>
  public TypeVisibilityAttr(SourceRange R, final ASTContext /*&*/ Ctx, 
      VisibilityType Visibility, 
      /*uint*/int SI) {
    // : InheritableAttr(attr::TypeVisibility, R, SI, false, false), visibility(Visibility) 
    //START JInit
    super(attr.Kind.TypeVisibility, new SourceRange(R), SI, false, false);
    this.visibility = Visibility;
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::TypeVisibilityAttr::clone">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/AttrImpl.inc", line = 6439,
   FQN="clang::TypeVisibilityAttr::clone", NM="_ZNK5clang18TypeVisibilityAttr5cloneERNS_10ASTContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZNK5clang18TypeVisibilityAttr5cloneERNS_10ASTContextE")
  //</editor-fold>
  public TypeVisibilityAttr /*P*/ clone(final ASTContext /*&*/ C) /*const*/ {
    TypeVisibilityAttr /*P*/ A = /*FIXME:NEW_EXPR*//*new (C)*/ new TypeVisibilityAttr(new SourceRange(getLocation()), C, visibility, getSpellingListIndex());
    A.Inherited = Inherited;
    A.IsPackExpansion = IsPackExpansion;
    A.Implicit = Implicit;
    return A;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TypeVisibilityAttr::printPretty">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/AttrImpl.inc", line = 6447,
   FQN="clang::TypeVisibilityAttr::printPretty", NM="_ZNK5clang18TypeVisibilityAttr11printPrettyERN4llvm11raw_ostreamERKNS_14PrintingPolicyE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZNK5clang18TypeVisibilityAttr11printPrettyERN4llvm11raw_ostreamERKNS_14PrintingPolicyE")
  //</editor-fold>
  public void printPretty(final raw_ostream /*&*/ OS, final /*const*/ PrintingPolicy /*&*/ Policy) /*const*/ {
    switch (SpellingListIndex) {
     default:
      throw new llvm_unreachable("Unknown attribute spelling!");
//      break;
     case 0:
      {
        OS.$out(/*KEEP_STR*/" __attribute__((type_visibility(\"").$out(TypeVisibilityAttr.ConvertVisibilityTypeToStr(getVisibility())).$out(/*KEEP_STR*/"\")))");
        break;
      }
     case 1:
      {
        OS.$out(/*KEEP_STR*/" [[clang::type_visibility(\"").$out(TypeVisibilityAttr.ConvertVisibilityTypeToStr(getVisibility())).$out(/*KEEP_STR*/"\")]]");
        break;
      }
    }
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TypeVisibilityAttr::getSpelling">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/AttrImpl.inc", line = 6463,
   FQN="clang::TypeVisibilityAttr::getSpelling", NM="_ZNK5clang18TypeVisibilityAttr11getSpellingEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZNK5clang18TypeVisibilityAttr11getSpellingEv")
  //</editor-fold>
  public /*const*/char$ptr/*char P*/ getSpelling() /*const*/ {
    switch (SpellingListIndex) {
     default:
      throw new llvm_unreachable("Unknown attribute spelling!");
//      return $("(No spelling)");
     case 0:
      return $("type_visibility");
     case 1:
      return $("type_visibility");
    }
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TypeVisibilityAttr::getVisibility">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/Attrs.inc", line = 6840,
   FQN="clang::TypeVisibilityAttr::getVisibility", NM="_ZNK5clang18TypeVisibilityAttr13getVisibilityEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZNK5clang18TypeVisibilityAttr13getVisibilityEv")
  //</editor-fold>
  public VisibilityType getVisibility() /*const*/ {
    return visibility;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::TypeVisibilityAttr::ConvertStrToVisibilityType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/Attrs.inc", line = 6844,
   FQN="clang::TypeVisibilityAttr::ConvertStrToVisibilityType", NM="_ZN5clang18TypeVisibilityAttr26ConvertStrToVisibilityTypeEN4llvm9StringRefERNS0_14VisibilityTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZN5clang18TypeVisibilityAttr26ConvertStrToVisibilityTypeEN4llvm9StringRefERNS0_14VisibilityTypeE")
  //</editor-fold>
  public static boolean ConvertStrToVisibilityType(StringRef Val, final type$ref<VisibilityType /*&*/> Out) {
    Optional<VisibilityType> R = new StringSwitch<Optional<VisibilityType> >(/*NO_COPY*/Val).
        Case(/*KEEP_STR*/"default", new Optional<VisibilityType>(JD$T$RR.INSTANCE, TypeVisibilityAttr.VisibilityType.Default)).
        Case(/*KEEP_STR*/"hidden", new Optional<VisibilityType>(JD$T$RR.INSTANCE, TypeVisibilityAttr.VisibilityType.Hidden)).
        Case(/*KEEP_STR*/"internal", new Optional<VisibilityType>(JD$T$RR.INSTANCE, TypeVisibilityAttr.VisibilityType.Hidden)).
        Case(/*KEEP_STR*/"protected", new Optional<VisibilityType>(JD$T$RR.INSTANCE, TypeVisibilityAttr.VisibilityType.Protected)).
        Default(new Optional<VisibilityType>());
    if (R.$bool()) {
      Out.$set(R.$star());
      return true;
    }
    return false;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::TypeVisibilityAttr::ConvertVisibilityTypeToStr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/Attrs.inc", line = 6858,
   FQN="clang::TypeVisibilityAttr::ConvertVisibilityTypeToStr", NM="_ZN5clang18TypeVisibilityAttr26ConvertVisibilityTypeToStrENS0_14VisibilityTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZN5clang18TypeVisibilityAttr26ConvertVisibilityTypeToStrENS0_14VisibilityTypeE")
  //</editor-fold>
  public static /*const*/char$ptr/*char P*/ ConvertVisibilityTypeToStr(VisibilityType Val) {
    switch (Val) {
     case Default:
      return $default;
     case Hidden:
      return $("hidden");
     case Protected:
      return $protected;
    }
    throw new llvm_unreachable("No enumerator with that value");
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::TypeVisibilityAttr::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/Attrs.inc", line = 6868,
   FQN="clang::TypeVisibilityAttr::classof", NM="_ZN5clang18TypeVisibilityAttr7classofEPKNS_4AttrE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZN5clang18TypeVisibilityAttr7classofEPKNS_4AttrE")
  //</editor-fold>
  public static boolean classof(/*const*/ Attr /*P*/ A) {
    return A.getKind() == attr.Kind.TypeVisibility;
  }

  
  @Override public String toString() {
    return "" + "visibility=" + visibility // NOI18N
              + super.toString(); // NOI18N
  }
}
