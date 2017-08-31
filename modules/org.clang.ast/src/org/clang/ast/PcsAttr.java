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

//<editor-fold defaultstate="collapsed" desc="clang::PcsAttr">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/Attrs.inc", line = 5470,
 FQN="clang::PcsAttr", NM="_ZN5clang7PcsAttrE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZN5clang7PcsAttrE")
//</editor-fold>
public class PcsAttr extends /*public*/ InheritableAttr {
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::PcsAttr::PCSType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/Attrs.inc", line = 5472,
   FQN="clang::PcsAttr::PCSType", NM="_ZN5clang7PcsAttr7PCSTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZN5clang7PcsAttr7PCSTypeE")
  //</editor-fold>
  public enum PCSType implements Native.ComparableLower {
    AAPCS(0),
    AAPCS_VFP(AAPCS.getValue() + 1);

    //<editor-fold defaultstate="collapsed" desc="hidden">
    public static PCSType valueOf(int val) {
      PCSType out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
      assert out != null : "no value for " + val;
      assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
      return out;
    }

    private static final class Values {
      private static final PCSType[] VALUES;
      private static final PCSType[] _VALUES; // [0] not used
      static {
        int max = 0;
        int min = 0;
        for (PCSType kind : PCSType.values()) {
          if (kind.value > max) { max = kind.value; }
          if (kind.value < min) { min = kind.value; }
        }
        _VALUES = new PCSType[min < 0 ? (1-min) : 0];
        VALUES = new PCSType[max >= 0 ? (1+max) : 0];
        for (PCSType kind : PCSType.values()) {
          if (kind.value < 0) {
            _VALUES[-kind.value] = kind;
          } else {
            VALUES[kind.value] = kind;
          }
        }
      }
    }

    private final /*uint*/int value;
    private PCSType(int val) { this.value = (/*uint*/int)val;}
    public /*uint*/int getValue() { return value;}
    @Override public boolean $less(Object obj) { return Unsigned.$less_uint(value, ((PCSType)obj).value);}
    @Override public boolean $lesseq(Object obj) { return Unsigned.$lesseq_uint(value, ((PCSType)obj).value);}
    //</editor-fold>
  };
/*private:*/
  private PCSType pCS;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::PcsAttr::CreateImplicit">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/Attrs.inc", line = 5480,
   FQN="clang::PcsAttr::CreateImplicit", NM="_ZN5clang7PcsAttr14CreateImplicitERNS_10ASTContextENS0_7PCSTypeENS_11SourceRangeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZN5clang7PcsAttr14CreateImplicitERNS_10ASTContextENS0_7PCSTypeENS_11SourceRangeE")
  //</editor-fold>
  public static PcsAttr /*P*/ CreateImplicit(final ASTContext /*&*/ Ctx, PCSType PCS) {
    return CreateImplicit(Ctx, PCS, new SourceRange());
  }
  public static PcsAttr /*P*/ CreateImplicit(final ASTContext /*&*/ Ctx, PCSType PCS, SourceRange Loc/*= SourceRange()*/) {
    PcsAttr /*P*/ A = /*FIXME:NEW_EXPR*//*new (Ctx)*/ new PcsAttr(new SourceRange(Loc), Ctx, PCS, 0);
    A.setImplicit(true);
    return A;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::PcsAttr::PcsAttr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/Attrs.inc", line = 5486,
   FQN="clang::PcsAttr::PcsAttr", NM="_ZN5clang7PcsAttrC1ENS_11SourceRangeERNS_10ASTContextENS0_7PCSTypeEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZN5clang7PcsAttrC1ENS_11SourceRangeERNS_10ASTContextENS0_7PCSTypeEj")
  //</editor-fold>
  public PcsAttr(SourceRange R, final ASTContext /*&*/ Ctx, 
      PCSType PCS, 
      /*uint*/int SI) {
    // : InheritableAttr(attr::Pcs, R, SI, false, false), pCS(PCS) 
    //START JInit
    super(attr.Kind.Pcs, new SourceRange(R), SI, false, false);
    this.pCS = PCS;
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::PcsAttr::clone">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/AttrImpl.inc", line = 5071,
   FQN="clang::PcsAttr::clone", NM="_ZNK5clang7PcsAttr5cloneERNS_10ASTContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZNK5clang7PcsAttr5cloneERNS_10ASTContextE")
  //</editor-fold>
  public PcsAttr /*P*/ clone(final ASTContext /*&*/ C) /*const*/ {
    PcsAttr /*P*/ A = /*FIXME:NEW_EXPR*//*new (C)*/ new PcsAttr(new SourceRange(getLocation()), C, pCS, getSpellingListIndex());
    A.Inherited = Inherited;
    A.IsPackExpansion = IsPackExpansion;
    A.Implicit = Implicit;
    return A;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::PcsAttr::printPretty">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/AttrImpl.inc", line = 5079,
   FQN="clang::PcsAttr::printPretty", NM="_ZNK5clang7PcsAttr11printPrettyERN4llvm11raw_ostreamERKNS_14PrintingPolicyE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZNK5clang7PcsAttr11printPrettyERN4llvm11raw_ostreamERKNS_14PrintingPolicyE")
  //</editor-fold>
  public void printPretty(final raw_ostream /*&*/ OS, final /*const*/ PrintingPolicy /*&*/ Policy) /*const*/ {
    switch (SpellingListIndex) {
     default:
      throw new llvm_unreachable("Unknown attribute spelling!");
//      break;
     case 0:
      {
        OS.$out(/*KEEP_STR*/" __attribute__((pcs(\"").$out(PcsAttr.ConvertPCSTypeToStr(getPCS())).$out(/*KEEP_STR*/"\")))");
        break;
      }
     case 1:
      {
        OS.$out(/*KEEP_STR*/" [[gnu::pcs(\"").$out(PcsAttr.ConvertPCSTypeToStr(getPCS())).$out(/*KEEP_STR*/"\")]]");
        break;
      }
    }
  }

  //<editor-fold defaultstate="collapsed" desc="clang::PcsAttr::getSpelling">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/AttrImpl.inc", line = 5095,
   FQN="clang::PcsAttr::getSpelling", NM="_ZNK5clang7PcsAttr11getSpellingEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZNK5clang7PcsAttr11getSpellingEv")
  //</editor-fold>
  public /*const*/char$ptr/*char P*/ getSpelling() /*const*/ {
    switch (SpellingListIndex) {
     default:
      throw new llvm_unreachable("Unknown attribute spelling!");
//      return $("(No spelling)");
     case 0:
      return $("pcs");
     case 1:
      return $("pcs");
    }
  }

  //<editor-fold defaultstate="collapsed" desc="clang::PcsAttr::getPCS">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/Attrs.inc", line = 5499,
   FQN="clang::PcsAttr::getPCS", NM="_ZNK5clang7PcsAttr6getPCSEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZNK5clang7PcsAttr6getPCSEv")
  //</editor-fold>
  public PCSType getPCS() /*const*/ {
    return pCS;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::PcsAttr::ConvertStrToPCSType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/Attrs.inc", line = 5503,
   FQN="clang::PcsAttr::ConvertStrToPCSType", NM="_ZN5clang7PcsAttr19ConvertStrToPCSTypeEN4llvm9StringRefERNS0_7PCSTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZN5clang7PcsAttr19ConvertStrToPCSTypeEN4llvm9StringRefERNS0_7PCSTypeE")
  //</editor-fold>
  public static boolean ConvertStrToPCSType(StringRef Val, final type$ref<PCSType /*&*/> Out) {
    Optional<PCSType> R = new StringSwitch<Optional<PCSType> >(/*NO_COPY*/Val).
        Case(/*KEEP_STR*/"aapcs", new Optional<PCSType>(JD$T$RR.INSTANCE, PcsAttr.PCSType.AAPCS)).
        Case(/*KEEP_STR*/"aapcs-vfp", new Optional<PCSType>(JD$T$RR.INSTANCE, PcsAttr.PCSType.AAPCS_VFP)).
        Default(new Optional<PCSType>());
    if (R.$bool()) {
      Out.$set(R.$star());
      return true;
    }
    return false;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::PcsAttr::ConvertPCSTypeToStr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/Attrs.inc", line = 5515,
   FQN="clang::PcsAttr::ConvertPCSTypeToStr", NM="_ZN5clang7PcsAttr19ConvertPCSTypeToStrENS0_7PCSTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZN5clang7PcsAttr19ConvertPCSTypeToStrENS0_7PCSTypeE")
  //</editor-fold>
  public static /*const*/char$ptr/*char P*/ ConvertPCSTypeToStr(PCSType Val) {
    switch (Val) {
     case AAPCS:
      return $("aapcs");
     case AAPCS_VFP:
      return $("aapcs-vfp");
    }
    throw new llvm_unreachable("No enumerator with that value");
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::PcsAttr::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/Attrs.inc", line = 5524,
   FQN="clang::PcsAttr::classof", NM="_ZN5clang7PcsAttr7classofEPKNS_4AttrE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZN5clang7PcsAttr7classofEPKNS_4AttrE")
  //</editor-fold>
  public static boolean classof(/*const*/ Attr /*P*/ A) {
    return A.getKind() == attr.Kind.Pcs;
  }

  
  @Override public String toString() {
    return "" + "pCS=" + pCS // NOI18N
              + super.toString(); // NOI18N
  }
}
