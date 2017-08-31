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
import static org.clank.support.Casts.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Unsigned.*;
import org.llvm.support.*;
import org.clang.basic.*;

//<editor-fold defaultstate="collapsed" desc="clang::AlignedAttr">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/Attrs.inc", line = 464,
 FQN="clang::AlignedAttr", NM="_ZN5clang11AlignedAttrE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZN5clang11AlignedAttrE")
//</editor-fold>
public class AlignedAttr extends /*public*/ InheritableAttr {
  private boolean isalignmentExpr;
  //<editor-fold defaultstate="collapsed" desc="clang::AlignedAttr::(anonymous)">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/Attrs.inc", line = 466,
   FQN="clang::AlignedAttr::(anonymous)", NM="_ZN5clang11AlignedAttrE_Unnamed_union1",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZN5clang11AlignedAttrE_Unnamed_union1")
  //</editor-fold>
  private static class/*union*/ Unnamed_union1 {
    public Expr /*P*/ alignmentExpr;
    public TypeSourceInfo /*P*/ alignmentType;

    //<editor-fold defaultstate="collapsed" desc="clang::AlignedAttr::(anonymous union)::">
    @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*assign fields*/,
     source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/Attrs.inc", line = 466,
     FQN="clang::AlignedAttr::(anonymous union)::", NM="_ZN5clang11AlignedAttrUt_C1ERKS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclAttr.cpp -nm=_ZN5clang11AlignedAttrUt_C1ERKS1_")
    //</editor-fold>
    public /*inline*/ Unnamed_union1(final Unnamed_union1 $Prm0) {
      this.alignmentExpr = $Prm0.alignmentExpr;
      this.alignmentType = $Prm0.alignmentType;
    }

    public /*inline*/ Unnamed_union1() {
      this.alignmentExpr = null;
      this.alignmentType = null;
    }

    @Override public String toString() {
      return "" + "alignmentExpr=" + alignmentExpr // NOI18N
                + ", alignmentType=" + alignmentType; // NOI18N
    }
  };
  private final Unnamed_union1 Unnamed_field1;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::AlignedAttr::Spelling">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/Attrs.inc", line = 472,
   FQN="clang::AlignedAttr::Spelling", NM="_ZN5clang11AlignedAttr8SpellingE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZN5clang11AlignedAttr8SpellingE")
  //</editor-fold>
  public enum Spelling implements Native.ComparableLower {
    GNU_aligned(0),
    CXX11_gnu_aligned(1),
    Declspec_align(2),
    Keyword_alignas(3),
    Keyword_Alignas(4);

    //<editor-fold defaultstate="collapsed" desc="hidden">
    public static Spelling valueOf(int val) {
      Spelling out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
      assert out != null : "no value for " + val;
      assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
      return out;
    }

    private static final class Values {
      private static final Spelling[] VALUES;
      private static final Spelling[] _VALUES; // [0] not used
      static {
        int max = 0;
        int min = 0;
        for (Spelling kind : Spelling.values()) {
          if (kind.value > max) { max = kind.value; }
          if (kind.value < min) { min = kind.value; }
        }
        _VALUES = new Spelling[min < 0 ? (1-min) : 0];
        VALUES = new Spelling[max >= 0 ? (1+max) : 0];
        for (Spelling kind : Spelling.values()) {
          if (kind.value < 0) {
            _VALUES[-kind.value] = kind;
          } else {
            VALUES[kind.value] = kind;
          }
        }
      }
    }

    private final /*uint*/int value;
    private Spelling(int val) { this.value = (/*uint*/int)val;}
    public /*uint*/int getValue() { return value;}
    @Override public boolean $less(Object obj) { return Unsigned.$less_uint(value, ((Spelling)obj).value);}
    @Override public boolean $lesseq(Object obj) { return Unsigned.$lesseq_uint(value, ((Spelling)obj).value);}
    //</editor-fold>
  };
  
  //<editor-fold defaultstate="collapsed" desc="clang::AlignedAttr::CreateImplicit">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/Attrs.inc", line = 480,
   FQN="clang::AlignedAttr::CreateImplicit", NM="_ZN5clang11AlignedAttr14CreateImplicitERNS_10ASTContextENS0_8SpellingEbPvNS_11SourceRangeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZN5clang11AlignedAttr14CreateImplicitERNS_10ASTContextENS0_8SpellingEbPvNS_11SourceRangeE")
  //</editor-fold>
  public static AlignedAttr /*P*/ CreateImplicit(final ASTContext /*&*/ Ctx, Spelling S, boolean IsAlignmentExpr, Object/*void P*/ Alignment) {
    return CreateImplicit(Ctx, S, IsAlignmentExpr, Alignment, new SourceRange());
  }
  public static AlignedAttr /*P*/ CreateImplicit(final ASTContext /*&*/ Ctx, Spelling S, boolean IsAlignmentExpr, Object/*void P*/ Alignment, SourceRange Loc/*= SourceRange()*/) {
    AlignedAttr /*P*/ A = /*FIXME:NEW_EXPR*//*new (Ctx)*/ new AlignedAttr(new SourceRange(Loc), Ctx, IsAlignmentExpr, Alignment, S.getValue());
    A.setImplicit(true);
    return A;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::AlignedAttr::AlignedAttr">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/Attrs.inc", line = 486,
   FQN="clang::AlignedAttr::AlignedAttr", NM="_ZN5clang11AlignedAttrC1ENS_11SourceRangeERNS_10ASTContextEbPvj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZN5clang11AlignedAttrC1ENS_11SourceRangeERNS_10ASTContextEbPvj")
  //</editor-fold>
  public AlignedAttr(SourceRange R, final ASTContext /*&*/ Ctx, 
      boolean IsAlignmentExpr, Object/*void P*/ Alignment, 
      /*uint*/int SI) {
    // : InheritableAttr(attr::Aligned, R, SI, false, false), isalignmentExpr(IsAlignmentExpr) 
    //START JInit
    super(attr.Kind.Aligned, new SourceRange(R), SI, false, false);
    this.isalignmentExpr = IsAlignmentExpr;
    //END JInit
    this.Unnamed_field1 = new Unnamed_union1();
    if (isalignmentExpr) {
      Unnamed_field1.alignmentExpr = reinterpret_cast(Expr /*P*/ .class, Alignment);
    } else {
      Unnamed_field1.alignmentType = reinterpret_cast(TypeSourceInfo /*P*/ .class, Alignment);
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::AlignedAttr::AlignedAttr">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/Attrs.inc", line = 499,
   FQN="clang::AlignedAttr::AlignedAttr", NM="_ZN5clang11AlignedAttrC1ENS_11SourceRangeERNS_10ASTContextEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZN5clang11AlignedAttrC1ENS_11SourceRangeERNS_10ASTContextEj")
  //</editor-fold>
  public AlignedAttr(SourceRange R, final ASTContext /*&*/ Ctx, 
      /*uint*/int SI) {
    // : InheritableAttr(attr::Aligned, R, SI, false, false), isalignmentExpr(false) 
    //START JInit
    super(attr.Kind.Aligned, new SourceRange(R), SI, false, false);
    this.isalignmentExpr = false;
    //END JInit
    this.Unnamed_field1 = new Unnamed_union1();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::AlignedAttr::clone">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/AttrImpl.inc", line = 419,
   FQN="clang::AlignedAttr::clone", NM="_ZNK5clang11AlignedAttr5cloneERNS_10ASTContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZNK5clang11AlignedAttr5cloneERNS_10ASTContextE")
  //</editor-fold>
  public AlignedAttr /*P*/ clone(final ASTContext /*&*/ C) /*const*/ {
    AlignedAttr /*P*/ A = /*FIXME:NEW_EXPR*//*new (C)*/ new AlignedAttr(new SourceRange(getLocation()), C, isalignmentExpr, isalignmentExpr ? (reinterpret_cast(/*static_cast*/Object/*void P*/ .class, (Unnamed_field1.alignmentExpr))) : Unnamed_field1.alignmentType, getSpellingListIndex());
    A.Inherited = Inherited;
    A.IsPackExpansion = IsPackExpansion;
    A.Implicit = Implicit;
    return A;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::AlignedAttr::printPretty">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/AttrImpl.inc", line = 427,
   FQN="clang::AlignedAttr::printPretty", NM="_ZNK5clang11AlignedAttr11printPrettyERN4llvm11raw_ostreamERKNS_14PrintingPolicyE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZNK5clang11AlignedAttr11printPrettyERN4llvm11raw_ostreamERKNS_14PrintingPolicyE")
  //</editor-fold>
  public void printPretty(final raw_ostream /*&*/ OS, final /*const*/ PrintingPolicy /*&*/ Policy) /*const*/ {
    switch (SpellingListIndex) {
     default:
      throw new llvm_unreachable("Unknown attribute spelling!");
//      break;
     case 0:
      {
        OS.$out(/*KEEP_STR*/" __attribute__((aligned(");
        if (isalignmentExpr && (Unnamed_field1.alignmentExpr != null)) {
          Unnamed_field1.alignmentExpr.printPretty(OS, (PrinterHelper /*P*/ )null, Policy);
        }
        OS.$out(/*KEEP_STR*/")))");
        break;
      }
     case 1:
      {
        OS.$out(/*KEEP_STR*/" [[gnu::aligned(");
        if (isalignmentExpr && (Unnamed_field1.alignmentExpr != null)) {
          Unnamed_field1.alignmentExpr.printPretty(OS, (PrinterHelper /*P*/ )null, Policy);
        }
        OS.$out(/*KEEP_STR*/")]]");
        break;
      }
     case 2:
      {
        OS.$out(/*KEEP_STR*/" __declspec(align(");
        if (isalignmentExpr && (Unnamed_field1.alignmentExpr != null)) {
          Unnamed_field1.alignmentExpr.printPretty(OS, (PrinterHelper /*P*/ )null, Policy);
        }
        OS.$out(/*KEEP_STR*/"))");
        break;
      }
     case 3:
      {
        OS.$out(/*KEEP_STR*/" alignas(");
        if (isalignmentExpr && (Unnamed_field1.alignmentExpr != null)) {
          Unnamed_field1.alignmentExpr.printPretty(OS, (PrinterHelper /*P*/ )null, Policy);
        }
        OS.$out(/*KEEP_STR*/$RPAREN);
        break;
      }
     case 4:
      {
        OS.$out(/*KEEP_STR*/" _Alignas(");
        if (isalignmentExpr && (Unnamed_field1.alignmentExpr != null)) {
          Unnamed_field1.alignmentExpr.printPretty(OS, (PrinterHelper /*P*/ )null, Policy);
        }
        OS.$out(/*KEEP_STR*/$RPAREN);
        break;
      }
    }
  }

  //<editor-fold defaultstate="collapsed" desc="clang::AlignedAttr::getSpelling">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/AttrImpl.inc", line = 470,
   FQN="clang::AlignedAttr::getSpelling", NM="_ZNK5clang11AlignedAttr11getSpellingEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZNK5clang11AlignedAttr11getSpellingEv")
  //</editor-fold>
  public /*const*/char$ptr/*char P*/ getSpelling() /*const*/ {
    switch (SpellingListIndex) {
     default:
      throw new llvm_unreachable("Unknown attribute spelling!");
//      return $("(No spelling)");
     case 0:
      return $("aligned");
     case 1:
      return $("aligned");
     case 2:
      return $("align");
     case 3:
      return $alignas;
     case 4:
      return $_Alignas;
    }
  }

  //<editor-fold defaultstate="collapsed" desc="clang::AlignedAttr::getSemanticSpelling">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/Attrs.inc", line = 511,
   FQN="clang::AlignedAttr::getSemanticSpelling", NM="_ZNK5clang11AlignedAttr19getSemanticSpellingEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZNK5clang11AlignedAttr19getSemanticSpellingEv")
  //</editor-fold>
  public Spelling getSemanticSpelling() /*const*/ {
    switch (SpellingListIndex) {
     default:
      throw new llvm_unreachable("Unknown spelling list index");
     case 0:
      return Spelling.GNU_aligned;
     case 1:
      return Spelling.CXX11_gnu_aligned;
     case 2:
      return Spelling.Declspec_align;
     case 3:
      return Spelling.Keyword_alignas;
     case 4:
      return Spelling.Keyword_Alignas;
    }
  }

  //<editor-fold defaultstate="collapsed" desc="clang::AlignedAttr::isGNU">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/Attrs.inc", line = 521,
   FQN="clang::AlignedAttr::isGNU", NM="_ZNK5clang11AlignedAttr5isGNUEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZNK5clang11AlignedAttr5isGNUEv")
  //</editor-fold>
  public boolean isGNU() /*const*/ {
    return SpellingListIndex == $int2uint_4bits(0)
       || SpellingListIndex == $int2uint_4bits(1);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::AlignedAttr::isC11">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/Attrs.inc", line = 523,
   FQN="clang::AlignedAttr::isC11", NM="_ZNK5clang11AlignedAttr5isC11Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZNK5clang11AlignedAttr5isC11Ev")
  //</editor-fold>
  public boolean isC11() /*const*/ {
    return SpellingListIndex == $int2uint_4bits(4);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::AlignedAttr::isAlignas">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/Attrs.inc", line = 524,
   FQN="clang::AlignedAttr::isAlignas", NM="_ZNK5clang11AlignedAttr9isAlignasEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZNK5clang11AlignedAttr9isAlignasEv")
  //</editor-fold>
  public boolean isAlignas() /*const*/ {
    return SpellingListIndex == $int2uint_4bits(3)
       || SpellingListIndex == $int2uint_4bits(4);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::AlignedAttr::isDeclspec">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/Attrs.inc", line = 526,
   FQN="clang::AlignedAttr::isDeclspec", NM="_ZNK5clang11AlignedAttr10isDeclspecEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZNK5clang11AlignedAttr10isDeclspecEv")
  //</editor-fold>
  public boolean isDeclspec() /*const*/ {
    return SpellingListIndex == $int2uint_4bits(2);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::AlignedAttr::isAlignmentDependent">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/AttrImpl.inc", line = 406,
   FQN="clang::AlignedAttr::isAlignmentDependent", NM="_ZNK5clang11AlignedAttr20isAlignmentDependentEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZNK5clang11AlignedAttr20isAlignmentDependentEv")
  //</editor-fold>
  public boolean isAlignmentDependent() /*const*/ {
    if (isalignmentExpr) {
      return (Unnamed_field1.alignmentExpr != null) && (Unnamed_field1.alignmentExpr.isValueDependent() || Unnamed_field1.alignmentExpr.isTypeDependent());
    } else {
      return Unnamed_field1.alignmentType.getType().$arrow().isDependentType();
    }
  }

  //<editor-fold defaultstate="collapsed" desc="clang::AlignedAttr::getAlignment">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/AttrImpl.inc", line = 412,
   FQN="clang::AlignedAttr::getAlignment", NM="_ZNK5clang11AlignedAttr12getAlignmentERNS_10ASTContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZNK5clang11AlignedAttr12getAlignmentERNS_10ASTContextE")
  //</editor-fold>
  public /*uint*/int getAlignment(final ASTContext /*&*/ Ctx) /*const*/ {
    assert (!isAlignmentDependent());
    if (isalignmentExpr) {
      return $ullong2uint((Unnamed_field1.alignmentExpr != null) ? Unnamed_field1.alignmentExpr.EvaluateKnownConstInt(Ctx).getZExtValue() * Ctx.getCharWidth() : $uint2ullong(Ctx.getTargetDefaultAlignForAttributeAligned()));
    } else {
      return 0; // FIXME
    }
  }

  //<editor-fold defaultstate="collapsed" desc="clang::AlignedAttr::isAlignmentExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/Attrs.inc", line = 529,
   FQN="clang::AlignedAttr::isAlignmentExpr", NM="_ZNK5clang11AlignedAttr15isAlignmentExprEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZNK5clang11AlignedAttr15isAlignmentExprEv")
  //</editor-fold>
  public boolean isAlignmentExpr() /*const*/ {
    return isalignmentExpr;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::AlignedAttr::getAlignmentExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/Attrs.inc", line = 532,
   FQN="clang::AlignedAttr::getAlignmentExpr", NM="_ZNK5clang11AlignedAttr16getAlignmentExprEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZNK5clang11AlignedAttr16getAlignmentExprEv")
  //</editor-fold>
  public Expr /*P*/ getAlignmentExpr() /*const*/ {
    assert (isalignmentExpr);
    return Unnamed_field1.alignmentExpr;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::AlignedAttr::getAlignmentType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/Attrs.inc", line = 536,
   FQN="clang::AlignedAttr::getAlignmentType", NM="_ZNK5clang11AlignedAttr16getAlignmentTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZNK5clang11AlignedAttr16getAlignmentTypeEv")
  //</editor-fold>
  public TypeSourceInfo /*P*/ getAlignmentType() /*const*/ {
    assert (!isalignmentExpr);
    return Unnamed_field1.alignmentType;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::AlignedAttr::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/Attrs.inc", line = 543,
   FQN="clang::AlignedAttr::classof", NM="_ZN5clang11AlignedAttr7classofEPKNS_4AttrE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZN5clang11AlignedAttr7classofEPKNS_4AttrE")
  //</editor-fold>
  public static boolean classof(/*const*/ Attr /*P*/ A) {
    return A.getKind() == attr.Kind.Aligned;
  }


  //<editor-fold defaultstate="collapsed" desc="clang::AlignedAttr::AlignedAttr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/Attrs.inc", line = 464,
   FQN="clang::AlignedAttr::AlignedAttr", NM="_ZN5clang11AlignedAttrC1ERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclAttr.cpp -nm=_ZN5clang11AlignedAttrC1ERKS0_")
  //</editor-fold>
  public /*inline*/ AlignedAttr(final /*const*/ AlignedAttr /*&*/ $Prm0) {
    // : InheritableAttr(), isalignmentExpr(.isalignmentExpr), Unnamed_field1(.) 
    //START JInit
    super($Prm0);
    this.isalignmentExpr = $Prm0.isalignmentExpr;
    this.Unnamed_field1 = new Unnamed_union1($Prm0.Unnamed_field1);
    //END JInit
  }

  
  @Override public String toString() {
    return "" + "isalignmentExpr=" + isalignmentExpr // NOI18N
              + ", Unnamed_field1=" + Unnamed_field1 // NOI18N
              + super.toString(); // NOI18N
  }
}
