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

//<editor-fold defaultstate="collapsed" desc="clang::MSInheritanceAttr">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/Attrs.inc", line = 3268,
 FQN="clang::MSInheritanceAttr", NM="_ZN5clang17MSInheritanceAttrE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZN5clang17MSInheritanceAttrE")
//</editor-fold>
public class MSInheritanceAttr extends /*public*/ InheritableAttr {
  private boolean bestCase;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::MSInheritanceAttr::Spelling">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/Attrs.inc", line = 3272,
   FQN="clang::MSInheritanceAttr::Spelling", NM="_ZN5clang17MSInheritanceAttr8SpellingE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZN5clang17MSInheritanceAttr8SpellingE")
  //</editor-fold>
  public enum Spelling implements Native.ComparableLower {
    Keyword_single_inheritance(0),
    Keyword_multiple_inheritance(1),
    Keyword_virtual_inheritance(2),
    Keyword_unspecified_inheritance(3);

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
  
  //<editor-fold defaultstate="collapsed" desc="clang::MSInheritanceAttr::CreateImplicit">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/Attrs.inc", line = 3279,
   FQN="clang::MSInheritanceAttr::CreateImplicit", NM="_ZN5clang17MSInheritanceAttr14CreateImplicitERNS_10ASTContextENS0_8SpellingEbNS_11SourceRangeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZN5clang17MSInheritanceAttr14CreateImplicitERNS_10ASTContextENS0_8SpellingEbNS_11SourceRangeE")
  //</editor-fold>
  public static MSInheritanceAttr /*P*/ CreateImplicit(final ASTContext /*&*/ Ctx, Spelling S, boolean BestCase) {
    return CreateImplicit(Ctx, S, BestCase, new SourceRange());
  }
  public static MSInheritanceAttr /*P*/ CreateImplicit(final ASTContext /*&*/ Ctx, Spelling S, boolean BestCase, SourceRange Loc/*= SourceRange()*/) {
    MSInheritanceAttr /*P*/ A = /*FIXME:NEW_EXPR*//*new (Ctx)*/ new MSInheritanceAttr(new SourceRange(Loc), Ctx, BestCase, S.getValue());
    A.setImplicit(true);
    return A;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::MSInheritanceAttr::MSInheritanceAttr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/Attrs.inc", line = 3285,
   FQN="clang::MSInheritanceAttr::MSInheritanceAttr", NM="_ZN5clang17MSInheritanceAttrC1ENS_11SourceRangeERNS_10ASTContextEbj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZN5clang17MSInheritanceAttrC1ENS_11SourceRangeERNS_10ASTContextEbj")
  //</editor-fold>
  public MSInheritanceAttr(SourceRange R, final ASTContext /*&*/ Ctx, 
      boolean BestCase, 
      /*uint*/int SI) {
    // : InheritableAttr(attr::MSInheritance, R, SI, false, false), bestCase(BestCase) 
    //START JInit
    super(attr.Kind.MSInheritance, new SourceRange(R), SI, false, false);
    this.bestCase = BestCase;
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::MSInheritanceAttr::MSInheritanceAttr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/Attrs.inc", line = 3294,
   FQN="clang::MSInheritanceAttr::MSInheritanceAttr", NM="_ZN5clang17MSInheritanceAttrC1ENS_11SourceRangeERNS_10ASTContextEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZN5clang17MSInheritanceAttrC1ENS_11SourceRangeERNS_10ASTContextEj")
  //</editor-fold>
  public MSInheritanceAttr(SourceRange R, final ASTContext /*&*/ Ctx, 
      /*uint*/int SI) {
    // : InheritableAttr(attr::MSInheritance, R, SI, false, false), bestCase(implicit bool()) 
    //START JInit
    super(attr.Kind.MSInheritance, new SourceRange(R), SI, false, false);
    this.bestCase = /*implicit-init*/((boolean)/*zero-init*/false);
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::MSInheritanceAttr::clone">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/AttrImpl.inc", line = 2974,
   FQN="clang::MSInheritanceAttr::clone", NM="_ZNK5clang17MSInheritanceAttr5cloneERNS_10ASTContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZNK5clang17MSInheritanceAttr5cloneERNS_10ASTContextE")
  //</editor-fold>
  public MSInheritanceAttr /*P*/ clone(final ASTContext /*&*/ C) /*const*/ {
    MSInheritanceAttr /*P*/ A = /*FIXME:NEW_EXPR*//*new (C)*/ new MSInheritanceAttr(new SourceRange(getLocation()), C, bestCase, getSpellingListIndex());
    A.Inherited = Inherited;
    A.IsPackExpansion = IsPackExpansion;
    A.Implicit = Implicit;
    return A;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::MSInheritanceAttr::printPretty">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/AttrImpl.inc", line = 2982,
   FQN="clang::MSInheritanceAttr::printPretty", NM="_ZNK5clang17MSInheritanceAttr11printPrettyERN4llvm11raw_ostreamERKNS_14PrintingPolicyE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZNK5clang17MSInheritanceAttr11printPrettyERN4llvm11raw_ostreamERKNS_14PrintingPolicyE")
  //</editor-fold>
  public void printPretty(final raw_ostream /*&*/ OS, final /*const*/ PrintingPolicy /*&*/ Policy) /*const*/ {
    switch (SpellingListIndex) {
     default:
      throw new llvm_unreachable("Unknown attribute spelling!");
//      break;
     case 0:
      {
        OS.$out(/*KEEP_STR*/" __single_inheritance(").$out_int((getBestCase() ? 1 : 0)).$out(/*KEEP_STR*/$RPAREN);
        break;
      }
     case 1:
      {
        OS.$out(/*KEEP_STR*/" __multiple_inheritance(").$out_int((getBestCase() ? 1 : 0)).$out(/*KEEP_STR*/$RPAREN);
        break;
      }
     case 2:
      {
        OS.$out(/*KEEP_STR*/" __virtual_inheritance(").$out_int((getBestCase() ? 1 : 0)).$out(/*KEEP_STR*/$RPAREN);
        break;
      }
     case 3:
      {
        OS.$out(/*KEEP_STR*/" __unspecified_inheritance(").$out_int((getBestCase() ? 1 : 0)).$out(/*KEEP_STR*/$RPAREN);
        break;
      }
    }
  }

  //<editor-fold defaultstate="collapsed" desc="clang::MSInheritanceAttr::getSpelling">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/AttrImpl.inc", line = 3006,
   FQN="clang::MSInheritanceAttr::getSpelling", NM="_ZNK5clang17MSInheritanceAttr11getSpellingEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZNK5clang17MSInheritanceAttr11getSpellingEv")
  //</editor-fold>
  public /*const*/char$ptr/*char P*/ getSpelling() /*const*/ {
    switch (SpellingListIndex) {
     default:
      throw new llvm_unreachable("Unknown attribute spelling!");
//      return $("(No spelling)");
     case 0:
      return $__single_inheritance;
     case 1:
      return $__multiple_inheritance;
     case 2:
      return $__virtual_inheritance;
     case 3:
      return $("__unspecified_inheritance");
    }
  }

  //<editor-fold defaultstate="collapsed" desc="clang::MSInheritanceAttr::getSemanticSpelling">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/Attrs.inc", line = 3306,
   FQN="clang::MSInheritanceAttr::getSemanticSpelling", NM="_ZNK5clang17MSInheritanceAttr19getSemanticSpellingEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZNK5clang17MSInheritanceAttr19getSemanticSpellingEv")
  //</editor-fold>
  public Spelling getSemanticSpelling() /*const*/ {
    switch (SpellingListIndex) {
     default:
      throw new llvm_unreachable("Unknown spelling list index");
     case 0:
      return Spelling.Keyword_single_inheritance;
     case 1:
      return Spelling.Keyword_multiple_inheritance;
     case 2:
      return Spelling.Keyword_virtual_inheritance;
     case 3:
      return Spelling.Keyword_unspecified_inheritance;
    }
  }

  //<editor-fold defaultstate="collapsed" desc="clang::MSInheritanceAttr::getBestCase">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/Attrs.inc", line = 3315,
   FQN="clang::MSInheritanceAttr::getBestCase", NM="_ZNK5clang17MSInheritanceAttr11getBestCaseEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZNK5clang17MSInheritanceAttr11getBestCaseEv")
  //</editor-fold>
  public boolean getBestCase() /*const*/ {
    return bestCase;
  }

  
  public static /*const*/boolean DefaultBestCase = true;
  
  //<editor-fold defaultstate="collapsed" desc="clang::MSInheritanceAttr::hasVBPtrOffsetField">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/Attrs.inc", line = 3322,
   FQN="clang::MSInheritanceAttr::hasVBPtrOffsetField", NM="_ZN5clang17MSInheritanceAttr19hasVBPtrOffsetFieldENS0_8SpellingE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZN5clang17MSInheritanceAttr19hasVBPtrOffsetFieldENS0_8SpellingE")
  //</editor-fold>
  public static boolean hasVBPtrOffsetField(Spelling Inheritance) {
    return Inheritance == Spelling.Keyword_unspecified_inheritance;
  }

  
  // Only member pointers to functions need a this adjustment, since it can be
  // combined with the field offset for data pointers.
  //<editor-fold defaultstate="collapsed" desc="clang::MSInheritanceAttr::hasNVOffsetField">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/Attrs.inc", line = 3328,
   FQN="clang::MSInheritanceAttr::hasNVOffsetField", NM="_ZN5clang17MSInheritanceAttr16hasNVOffsetFieldEbNS0_8SpellingE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZN5clang17MSInheritanceAttr16hasNVOffsetFieldEbNS0_8SpellingE")
  //</editor-fold>
  public static boolean hasNVOffsetField(boolean IsMemberFunction, Spelling Inheritance) {
    return IsMemberFunction && Inheritance.getValue() >= Spelling.Keyword_multiple_inheritance.getValue();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::MSInheritanceAttr::hasVBTableOffsetField">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/Attrs.inc", line = 3332,
   FQN="clang::MSInheritanceAttr::hasVBTableOffsetField", NM="_ZN5clang17MSInheritanceAttr21hasVBTableOffsetFieldENS0_8SpellingE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZN5clang17MSInheritanceAttr21hasVBTableOffsetFieldENS0_8SpellingE")
  //</editor-fold>
  public static boolean hasVBTableOffsetField(Spelling Inheritance) {
    return Inheritance.getValue() >= Spelling.Keyword_virtual_inheritance.getValue();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::MSInheritanceAttr::hasOnlyOneField">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/Attrs.inc", line = 3336,
   FQN="clang::MSInheritanceAttr::hasOnlyOneField", NM="_ZN5clang17MSInheritanceAttr15hasOnlyOneFieldEbNS0_8SpellingE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZN5clang17MSInheritanceAttr15hasOnlyOneFieldEbNS0_8SpellingE")
  //</editor-fold>
  public static boolean hasOnlyOneField(boolean IsMemberFunction, 
                 Spelling Inheritance) {
    if (IsMemberFunction) {
      return Inheritance.getValue() <= Spelling.Keyword_single_inheritance.getValue();
    }
    return Inheritance.getValue() <= Spelling.Keyword_multiple_inheritance.getValue();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::MSInheritanceAttr::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/Attrs.inc", line = 3344,
   FQN="clang::MSInheritanceAttr::classof", NM="_ZN5clang17MSInheritanceAttr7classofEPKNS_4AttrE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZN5clang17MSInheritanceAttr7classofEPKNS_4AttrE")
  //</editor-fold>
  public static boolean classof(/*const*/ Attr /*P*/ A) {
    return A.getKind() == attr.Kind.MSInheritance;
  }

  
  @Override public String toString() {
    return "" + "bestCase=" + bestCase // NOI18N
              + super.toString(); // NOI18N
  }
}
