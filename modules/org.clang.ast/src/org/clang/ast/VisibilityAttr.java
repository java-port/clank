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

//<editor-fold defaultstate="collapsed" desc="clang::VisibilityAttr">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/Attrs.inc", line = 7148,
 FQN="clang::VisibilityAttr", NM="_ZN5clang14VisibilityAttrE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZN5clang14VisibilityAttrE")
//</editor-fold>
public class VisibilityAttr extends /*public*/ InheritableAttr {
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::VisibilityAttr::VisibilityType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/Attrs.inc", line = 7150,
   FQN="clang::VisibilityAttr::VisibilityType", NM="_ZN5clang14VisibilityAttr14VisibilityTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZN5clang14VisibilityAttr14VisibilityTypeE")
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
  //<editor-fold defaultstate="collapsed" desc="clang::VisibilityAttr::CreateImplicit">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/Attrs.inc", line = 7159,
   FQN="clang::VisibilityAttr::CreateImplicit", NM="_ZN5clang14VisibilityAttr14CreateImplicitERNS_10ASTContextENS0_14VisibilityTypeENS_11SourceRangeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZN5clang14VisibilityAttr14CreateImplicitERNS_10ASTContextENS0_14VisibilityTypeENS_11SourceRangeE")
  //</editor-fold>
  public static VisibilityAttr /*P*/ CreateImplicit(final ASTContext /*&*/ Ctx, VisibilityType Visibility) {
    return CreateImplicit(Ctx, Visibility, new SourceRange());
  }
  public static VisibilityAttr /*P*/ CreateImplicit(final ASTContext /*&*/ Ctx, VisibilityType Visibility, SourceRange Loc/*= SourceRange()*/) {
    VisibilityAttr /*P*/ A = /*FIXME:NEW_EXPR*//*new (Ctx)*/ new VisibilityAttr(new SourceRange(Loc), Ctx, Visibility, 0);
    A.setImplicit(true);
    return A;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::VisibilityAttr::VisibilityAttr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/Attrs.inc", line = 7165,
   FQN="clang::VisibilityAttr::VisibilityAttr", NM="_ZN5clang14VisibilityAttrC1ENS_11SourceRangeERNS_10ASTContextENS0_14VisibilityTypeEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZN5clang14VisibilityAttrC1ENS_11SourceRangeERNS_10ASTContextENS0_14VisibilityTypeEj")
  //</editor-fold>
  public VisibilityAttr(SourceRange R, final ASTContext /*&*/ Ctx, 
      VisibilityType Visibility, 
      /*uint*/int SI) {
    // : InheritableAttr(attr::Visibility, R, SI, false, false), visibility(Visibility) 
    //START JInit
    super(attr.Kind.Visibility, new SourceRange(R), SI, false, false);
    this.visibility = Visibility;
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::VisibilityAttr::clone">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/AttrImpl.inc", line = 6715,
   FQN="clang::VisibilityAttr::clone", NM="_ZNK5clang14VisibilityAttr5cloneERNS_10ASTContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZNK5clang14VisibilityAttr5cloneERNS_10ASTContextE")
  //</editor-fold>
  public VisibilityAttr /*P*/ clone(final ASTContext /*&*/ C) /*const*/ {
    VisibilityAttr /*P*/ A = /*FIXME:NEW_EXPR*//*new (C)*/ new VisibilityAttr(new SourceRange(getLocation()), C, visibility, getSpellingListIndex());
    A.Inherited = Inherited;
    A.IsPackExpansion = IsPackExpansion;
    A.Implicit = Implicit;
    return A;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::VisibilityAttr::printPretty">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/AttrImpl.inc", line = 6723,
   FQN="clang::VisibilityAttr::printPretty", NM="_ZNK5clang14VisibilityAttr11printPrettyERN4llvm11raw_ostreamERKNS_14PrintingPolicyE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZNK5clang14VisibilityAttr11printPrettyERN4llvm11raw_ostreamERKNS_14PrintingPolicyE")
  //</editor-fold>
  public void printPretty(final raw_ostream /*&*/ OS, final /*const*/ PrintingPolicy /*&*/ Policy) /*const*/ {
    switch (SpellingListIndex) {
     default:
      throw new llvm_unreachable("Unknown attribute spelling!");
//      break;
     case 0:
      {
        OS.$out(/*KEEP_STR*/" __attribute__((visibility(\"").$out(VisibilityAttr.ConvertVisibilityTypeToStr(getVisibility())).$out(/*KEEP_STR*/"\")))");
        break;
      }
     case 1:
      {
        OS.$out(/*KEEP_STR*/" [[gnu::visibility(\"").$out(VisibilityAttr.ConvertVisibilityTypeToStr(getVisibility())).$out(/*KEEP_STR*/"\")]]");
        break;
      }
    }
  }

  //<editor-fold defaultstate="collapsed" desc="clang::VisibilityAttr::getSpelling">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/AttrImpl.inc", line = 6739,
   FQN="clang::VisibilityAttr::getSpelling", NM="_ZNK5clang14VisibilityAttr11getSpellingEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZNK5clang14VisibilityAttr11getSpellingEv")
  //</editor-fold>
  public /*const*/char$ptr/*char P*/ getSpelling() /*const*/ {
    switch (SpellingListIndex) {
     default:
      throw new llvm_unreachable("Unknown attribute spelling!");
//      return $("(No spelling)");
     case 0:
      return $("visibility");
     case 1:
      return $("visibility");
    }
  }

  //<editor-fold defaultstate="collapsed" desc="clang::VisibilityAttr::getVisibility">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/Attrs.inc", line = 7178,
   FQN="clang::VisibilityAttr::getVisibility", NM="_ZNK5clang14VisibilityAttr13getVisibilityEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZNK5clang14VisibilityAttr13getVisibilityEv")
  //</editor-fold>
  public VisibilityType getVisibility() /*const*/ {
    return visibility;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::VisibilityAttr::ConvertStrToVisibilityType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/Attrs.inc", line = 7182,
   FQN="clang::VisibilityAttr::ConvertStrToVisibilityType", NM="_ZN5clang14VisibilityAttr26ConvertStrToVisibilityTypeEN4llvm9StringRefERNS0_14VisibilityTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZN5clang14VisibilityAttr26ConvertStrToVisibilityTypeEN4llvm9StringRefERNS0_14VisibilityTypeE")
  //</editor-fold>
  public static boolean ConvertStrToVisibilityType(StringRef Val, final type$ref<VisibilityType /*&*/> Out) {
    Optional<VisibilityType> R = new StringSwitch<Optional<VisibilityType> >(/*NO_COPY*/Val).
        Case(/*KEEP_STR*/"default", new Optional<VisibilityType>(JD$T$RR.INSTANCE, VisibilityAttr.VisibilityType.Default)).
        Case(/*KEEP_STR*/"hidden", new Optional<VisibilityType>(JD$T$RR.INSTANCE, VisibilityAttr.VisibilityType.Hidden)).
        Case(/*KEEP_STR*/"internal", new Optional<VisibilityType>(JD$T$RR.INSTANCE, VisibilityAttr.VisibilityType.Hidden)).
        Case(/*KEEP_STR*/"protected", new Optional<VisibilityType>(JD$T$RR.INSTANCE, VisibilityAttr.VisibilityType.Protected)).
        Default(new Optional<VisibilityType>());
    if (R.$bool()) {
      Out.$set(R.$star());
      return true;
    }
    return false;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::VisibilityAttr::ConvertVisibilityTypeToStr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/Attrs.inc", line = 7196,
   FQN="clang::VisibilityAttr::ConvertVisibilityTypeToStr", NM="_ZN5clang14VisibilityAttr26ConvertVisibilityTypeToStrENS0_14VisibilityTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZN5clang14VisibilityAttr26ConvertVisibilityTypeToStrENS0_14VisibilityTypeE")
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

  
  //<editor-fold defaultstate="collapsed" desc="clang::VisibilityAttr::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/Attrs.inc", line = 7206,
   FQN="clang::VisibilityAttr::classof", NM="_ZN5clang14VisibilityAttr7classofEPKNS_4AttrE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZN5clang14VisibilityAttr7classofEPKNS_4AttrE")
  //</editor-fold>
  public static boolean classof(/*const*/ Attr /*P*/ A) {
    return A.getKind() == attr.Kind.Visibility;
  }

  
  @Override public String toString() {
    return "" + "visibility=" + visibility // NOI18N
              + super.toString(); // NOI18N
  }
}
