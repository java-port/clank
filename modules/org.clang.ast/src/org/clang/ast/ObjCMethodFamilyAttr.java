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

//<editor-fold defaultstate="collapsed" desc="clang::ObjCMethodFamilyAttr">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/Attrs.inc", line = 4795,
 FQN="clang::ObjCMethodFamilyAttr", NM="_ZN5clang20ObjCMethodFamilyAttrE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZN5clang20ObjCMethodFamilyAttrE")
//</editor-fold>
public class ObjCMethodFamilyAttr extends /*public*/ InheritableAttr {
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCMethodFamilyAttr::FamilyKind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/Attrs.inc", line = 4797,
   FQN="clang::ObjCMethodFamilyAttr::FamilyKind", NM="_ZN5clang20ObjCMethodFamilyAttr10FamilyKindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZN5clang20ObjCMethodFamilyAttr10FamilyKindE")
  //</editor-fold>
  public enum FamilyKind implements Native.ComparableLower {
    OMF_None(0),
    OMF_alloc(OMF_None.getValue() + 1),
    OMF_copy(OMF_alloc.getValue() + 1),
    OMF_init(OMF_copy.getValue() + 1),
    OMF_mutableCopy(OMF_init.getValue() + 1),
    OMF_new(OMF_mutableCopy.getValue() + 1);

    //<editor-fold defaultstate="collapsed" desc="hidden">
    public static FamilyKind valueOf(int val) {
      FamilyKind out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
      assert out != null : "no value for " + val;
      assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
      return out;
    }

    private static final class Values {
      private static final FamilyKind[] VALUES;
      private static final FamilyKind[] _VALUES; // [0] not used
      static {
        int max = 0;
        int min = 0;
        for (FamilyKind kind : FamilyKind.values()) {
          if (kind.value > max) { max = kind.value; }
          if (kind.value < min) { min = kind.value; }
        }
        _VALUES = new FamilyKind[min < 0 ? (1-min) : 0];
        VALUES = new FamilyKind[max >= 0 ? (1+max) : 0];
        for (FamilyKind kind : FamilyKind.values()) {
          if (kind.value < 0) {
            _VALUES[-kind.value] = kind;
          } else {
            VALUES[kind.value] = kind;
          }
        }
      }
    }

    private final /*uint*/int value;
    private FamilyKind(int val) { this.value = (/*uint*/int)val;}
    public /*uint*/int getValue() { return value;}
    @Override public boolean $less(Object obj) { return Unsigned.$less_uint(value, ((FamilyKind)obj).value);}
    @Override public boolean $lesseq(Object obj) { return Unsigned.$lesseq_uint(value, ((FamilyKind)obj).value);}
    //</editor-fold>
  };
/*private:*/
  private FamilyKind family;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCMethodFamilyAttr::CreateImplicit">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/Attrs.inc", line = 4809,
   FQN="clang::ObjCMethodFamilyAttr::CreateImplicit", NM="_ZN5clang20ObjCMethodFamilyAttr14CreateImplicitERNS_10ASTContextENS0_10FamilyKindENS_11SourceRangeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZN5clang20ObjCMethodFamilyAttr14CreateImplicitERNS_10ASTContextENS0_10FamilyKindENS_11SourceRangeE")
  //</editor-fold>
  public static ObjCMethodFamilyAttr /*P*/ CreateImplicit(final ASTContext /*&*/ Ctx, FamilyKind Family) {
    return CreateImplicit(Ctx, Family, new SourceRange());
  }
  public static ObjCMethodFamilyAttr /*P*/ CreateImplicit(final ASTContext /*&*/ Ctx, FamilyKind Family, SourceRange Loc/*= SourceRange()*/) {
    ObjCMethodFamilyAttr /*P*/ A = /*FIXME:NEW_EXPR*//*new (Ctx)*/ new ObjCMethodFamilyAttr(new SourceRange(Loc), Ctx, Family, 0);
    A.setImplicit(true);
    return A;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCMethodFamilyAttr::ObjCMethodFamilyAttr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/Attrs.inc", line = 4815,
   FQN="clang::ObjCMethodFamilyAttr::ObjCMethodFamilyAttr", NM="_ZN5clang20ObjCMethodFamilyAttrC1ENS_11SourceRangeERNS_10ASTContextENS0_10FamilyKindEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZN5clang20ObjCMethodFamilyAttrC1ENS_11SourceRangeERNS_10ASTContextENS0_10FamilyKindEj")
  //</editor-fold>
  public ObjCMethodFamilyAttr(SourceRange R, final ASTContext /*&*/ Ctx, 
      FamilyKind Family, 
      /*uint*/int SI) {
    // : InheritableAttr(attr::ObjCMethodFamily, R, SI, false, false), family(Family) 
    //START JInit
    super(attr.Kind.ObjCMethodFamily, new SourceRange(R), SI, false, false);
    this.family = Family;
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCMethodFamilyAttr::clone">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/AttrImpl.inc", line = 4378,
   FQN="clang::ObjCMethodFamilyAttr::clone", NM="_ZNK5clang20ObjCMethodFamilyAttr5cloneERNS_10ASTContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZNK5clang20ObjCMethodFamilyAttr5cloneERNS_10ASTContextE")
  //</editor-fold>
  public ObjCMethodFamilyAttr /*P*/ clone(final ASTContext /*&*/ C) /*const*/ {
    ObjCMethodFamilyAttr /*P*/ A = /*FIXME:NEW_EXPR*//*new (C)*/ new ObjCMethodFamilyAttr(new SourceRange(getLocation()), C, family, getSpellingListIndex());
    A.Inherited = Inherited;
    A.IsPackExpansion = IsPackExpansion;
    A.Implicit = Implicit;
    return A;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ObjCMethodFamilyAttr::printPretty">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/AttrImpl.inc", line = 4386,
   FQN="clang::ObjCMethodFamilyAttr::printPretty", NM="_ZNK5clang20ObjCMethodFamilyAttr11printPrettyERN4llvm11raw_ostreamERKNS_14PrintingPolicyE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZNK5clang20ObjCMethodFamilyAttr11printPrettyERN4llvm11raw_ostreamERKNS_14PrintingPolicyE")
  //</editor-fold>
  public void printPretty(final raw_ostream /*&*/ OS, final /*const*/ PrintingPolicy /*&*/ Policy) /*const*/ {
    switch (SpellingListIndex) {
     default:
      throw new llvm_unreachable("Unknown attribute spelling!");
//      break;
     case 0:
      {
        OS.$out(/*KEEP_STR*/" __attribute__((objc_method_family(\"").$out(ObjCMethodFamilyAttr.ConvertFamilyKindToStr(getFamily())).$out(/*KEEP_STR*/"\")))");
        break;
      }
    }
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ObjCMethodFamilyAttr::getSpelling">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/AttrImpl.inc", line = 4398,
   FQN="clang::ObjCMethodFamilyAttr::getSpelling", NM="_ZNK5clang20ObjCMethodFamilyAttr11getSpellingEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZNK5clang20ObjCMethodFamilyAttr11getSpellingEv")
  //</editor-fold>
  public /*const*/char$ptr/*char P*/ getSpelling() /*const*/ {
    switch (SpellingListIndex) {
     default:
      throw new llvm_unreachable("Unknown attribute spelling!");
//      return $("(No spelling)");
     case 0:
      return $("objc_method_family");
    }
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ObjCMethodFamilyAttr::getFamily">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/Attrs.inc", line = 4828,
   FQN="clang::ObjCMethodFamilyAttr::getFamily", NM="_ZNK5clang20ObjCMethodFamilyAttr9getFamilyEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZNK5clang20ObjCMethodFamilyAttr9getFamilyEv")
  //</editor-fold>
  public FamilyKind getFamily() /*const*/ {
    return family;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCMethodFamilyAttr::ConvertStrToFamilyKind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/Attrs.inc", line = 4832,
   FQN="clang::ObjCMethodFamilyAttr::ConvertStrToFamilyKind", NM="_ZN5clang20ObjCMethodFamilyAttr22ConvertStrToFamilyKindEN4llvm9StringRefERNS0_10FamilyKindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZN5clang20ObjCMethodFamilyAttr22ConvertStrToFamilyKindEN4llvm9StringRefERNS0_10FamilyKindE")
  //</editor-fold>
  public static boolean ConvertStrToFamilyKind(StringRef Val, final type$ref<FamilyKind /*&*/> Out) {
    Optional<FamilyKind> R = new StringSwitch<Optional<FamilyKind> >(/*NO_COPY*/Val).
        Case(/*KEEP_STR*/"none", new Optional<FamilyKind>(JD$T$RR.INSTANCE, ObjCMethodFamilyAttr.FamilyKind.OMF_None)).
        Case(/*KEEP_STR*/"alloc", new Optional<FamilyKind>(JD$T$RR.INSTANCE, ObjCMethodFamilyAttr.FamilyKind.OMF_alloc)).
        Case(/*KEEP_STR*/"copy", new Optional<FamilyKind>(JD$T$RR.INSTANCE, ObjCMethodFamilyAttr.FamilyKind.OMF_copy)).
        Case(/*KEEP_STR*/"init", new Optional<FamilyKind>(JD$T$RR.INSTANCE, ObjCMethodFamilyAttr.FamilyKind.OMF_init)).
        Case(/*KEEP_STR*/"mutableCopy", new Optional<FamilyKind>(JD$T$RR.INSTANCE, ObjCMethodFamilyAttr.FamilyKind.OMF_mutableCopy)).
        Case(/*KEEP_STR*/"new", new Optional<FamilyKind>(JD$T$RR.INSTANCE, ObjCMethodFamilyAttr.FamilyKind.OMF_new)).
        Default(new Optional<FamilyKind>());
    if (R.$bool()) {
      Out.$set(R.$star());
      return true;
    }
    return false;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCMethodFamilyAttr::ConvertFamilyKindToStr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/Attrs.inc", line = 4848,
   FQN="clang::ObjCMethodFamilyAttr::ConvertFamilyKindToStr", NM="_ZN5clang20ObjCMethodFamilyAttr22ConvertFamilyKindToStrENS0_10FamilyKindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZN5clang20ObjCMethodFamilyAttr22ConvertFamilyKindToStrENS0_10FamilyKindE")
  //</editor-fold>
  public static /*const*/char$ptr/*char P*/ ConvertFamilyKindToStr(FamilyKind Val) {
    switch (Val) {
     case OMF_None:
      return $("none");
     case OMF_alloc:
      return $("alloc");
     case OMF_copy:
      return $("copy");
     case OMF_init:
      return $("init");
     case OMF_mutableCopy:
      return $("mutableCopy");
     case OMF_new:
      return $new;
    }
    throw new llvm_unreachable("No enumerator with that value");
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCMethodFamilyAttr::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/Attrs.inc", line = 4861,
   FQN="clang::ObjCMethodFamilyAttr::classof", NM="_ZN5clang20ObjCMethodFamilyAttr7classofEPKNS_4AttrE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZN5clang20ObjCMethodFamilyAttr7classofEPKNS_4AttrE")
  //</editor-fold>
  public static boolean classof(/*const*/ Attr /*P*/ A) {
    return A.getKind() == attr.Kind.ObjCMethodFamily;
  }

  
  @Override public String toString() {
    return "" + "family=" + family // NOI18N
              + super.toString(); // NOI18N
  }
}
