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
import static org.clank.support.Unsigned.*;
import org.llvm.support.*;
import org.clang.basic.*;

//<editor-fold defaultstate="collapsed" desc="clang::AssertCapabilityAttr">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/Attrs.inc", line = 812,
 FQN="clang::AssertCapabilityAttr", NM="_ZN5clang20AssertCapabilityAttrE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZN5clang20AssertCapabilityAttrE")
//</editor-fold>
public class AssertCapabilityAttr extends /*public*/ InheritableAttr {
  private Expr /*P*/ expr;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::AssertCapabilityAttr::Spelling">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/Attrs.inc", line = 816,
   FQN="clang::AssertCapabilityAttr::Spelling", NM="_ZN5clang20AssertCapabilityAttr8SpellingE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZN5clang20AssertCapabilityAttr8SpellingE")
  //</editor-fold>
  public enum Spelling implements Native.ComparableLower {
    GNU_assert_capability(0),
    CXX11_clang_assert_capability(1),
    GNU_assert_shared_capability(2),
    CXX11_clang_assert_shared_capability(3);

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
  
  //<editor-fold defaultstate="collapsed" desc="clang::AssertCapabilityAttr::CreateImplicit">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/Attrs.inc", line = 823,
   FQN="clang::AssertCapabilityAttr::CreateImplicit", NM="_ZN5clang20AssertCapabilityAttr14CreateImplicitERNS_10ASTContextENS0_8SpellingEPNS_4ExprENS_11SourceRangeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZN5clang20AssertCapabilityAttr14CreateImplicitERNS_10ASTContextENS0_8SpellingEPNS_4ExprENS_11SourceRangeE")
  //</editor-fold>
  public static AssertCapabilityAttr /*P*/ CreateImplicit(final ASTContext /*&*/ Ctx, Spelling S, Expr /*P*/ Expr) {
    return CreateImplicit(Ctx, S, Expr, new SourceRange());
  }
  public static AssertCapabilityAttr /*P*/ CreateImplicit(final ASTContext /*&*/ Ctx, Spelling S, Expr /*P*/ Expr, SourceRange Loc/*= SourceRange()*/) {
    AssertCapabilityAttr /*P*/ A = /*FIXME:NEW_EXPR*//*new (Ctx)*/ new AssertCapabilityAttr(new SourceRange(Loc), Ctx, Expr, S.getValue());
    A.setImplicit(true);
    return A;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::AssertCapabilityAttr::AssertCapabilityAttr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/Attrs.inc", line = 829,
   FQN="clang::AssertCapabilityAttr::AssertCapabilityAttr", NM="_ZN5clang20AssertCapabilityAttrC1ENS_11SourceRangeERNS_10ASTContextEPNS_4ExprEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZN5clang20AssertCapabilityAttrC1ENS_11SourceRangeERNS_10ASTContextEPNS_4ExprEj")
  //</editor-fold>
  public AssertCapabilityAttr(SourceRange R, final ASTContext /*&*/ Ctx, 
      Expr /*P*/ Expr, 
      /*uint*/int SI) {
    // : InheritableAttr(attr::AssertCapability, R, SI, true, true), expr(Expr) 
    //START JInit
    super(attr.Kind.AssertCapability, new SourceRange(R), SI, true, true);
    this.expr = Expr;
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::AssertCapabilityAttr::clone">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/AttrImpl.inc", line = 722,
   FQN="clang::AssertCapabilityAttr::clone", NM="_ZNK5clang20AssertCapabilityAttr5cloneERNS_10ASTContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZNK5clang20AssertCapabilityAttr5cloneERNS_10ASTContextE")
  //</editor-fold>
  public AssertCapabilityAttr /*P*/ clone(final ASTContext /*&*/ C) /*const*/ {
    AssertCapabilityAttr /*P*/ A = /*FIXME:NEW_EXPR*//*new (C)*/ new AssertCapabilityAttr(new SourceRange(getLocation()), C, expr, getSpellingListIndex());
    A.Inherited = Inherited;
    A.IsPackExpansion = IsPackExpansion;
    A.Implicit = Implicit;
    return A;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::AssertCapabilityAttr::printPretty">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/AttrImpl.inc", line = 730,
   FQN="clang::AssertCapabilityAttr::printPretty", NM="_ZNK5clang20AssertCapabilityAttr11printPrettyERN4llvm11raw_ostreamERKNS_14PrintingPolicyE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZNK5clang20AssertCapabilityAttr11printPrettyERN4llvm11raw_ostreamERKNS_14PrintingPolicyE")
  //</editor-fold>
  public void printPretty(final raw_ostream /*&*/ OS, final /*const*/ PrintingPolicy /*&*/ Policy) /*const*/ {
    switch (SpellingListIndex) {
     default:
      throw new llvm_unreachable("Unknown attribute spelling!");
//      break;
     case 0:
      {
        OS.$out(/*KEEP_STR*/" __attribute__((assert_capability(").$out(getExpr()).$out(/*KEEP_STR*/")))");
        break;
      }
     case 1:
      {
        OS.$out(/*KEEP_STR*/" [[clang::assert_capability(").$out(getExpr()).$out(/*KEEP_STR*/")]]");
        break;
      }
     case 2:
      {
        OS.$out(/*KEEP_STR*/" __attribute__((assert_shared_capability(").$out(getExpr()).$out(/*KEEP_STR*/")))");
        break;
      }
     case 3:
      {
        OS.$out(/*KEEP_STR*/" [[clang::assert_shared_capability(").$out(getExpr()).$out(/*KEEP_STR*/")]]");
        break;
      }
    }
  }

  //<editor-fold defaultstate="collapsed" desc="clang::AssertCapabilityAttr::getSpelling">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/AttrImpl.inc", line = 754,
   FQN="clang::AssertCapabilityAttr::getSpelling", NM="_ZNK5clang20AssertCapabilityAttr11getSpellingEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZNK5clang20AssertCapabilityAttr11getSpellingEv")
  //</editor-fold>
  public /*const*/char$ptr/*char P*/ getSpelling() /*const*/ {
    switch (SpellingListIndex) {
     default:
      throw new llvm_unreachable("Unknown attribute spelling!");
//      return $("(No spelling)");
     case 0:
      return $("assert_capability");
     case 1:
      return $("assert_capability");
     case 2:
      return $("assert_shared_capability");
     case 3:
      return $("assert_shared_capability");
    }
  }

  //<editor-fold defaultstate="collapsed" desc="clang::AssertCapabilityAttr::getSemanticSpelling">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/Attrs.inc", line = 842,
   FQN="clang::AssertCapabilityAttr::getSemanticSpelling", NM="_ZNK5clang20AssertCapabilityAttr19getSemanticSpellingEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZNK5clang20AssertCapabilityAttr19getSemanticSpellingEv")
  //</editor-fold>
  public Spelling getSemanticSpelling() /*const*/ {
    switch (SpellingListIndex) {
     default:
      throw new llvm_unreachable("Unknown spelling list index");
     case 0:
      return Spelling.GNU_assert_capability;
     case 1:
      return Spelling.CXX11_clang_assert_capability;
     case 2:
      return Spelling.GNU_assert_shared_capability;
     case 3:
      return Spelling.CXX11_clang_assert_shared_capability;
    }
  }

  //<editor-fold defaultstate="collapsed" desc="clang::AssertCapabilityAttr::isShared">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/Attrs.inc", line = 851,
   FQN="clang::AssertCapabilityAttr::isShared", NM="_ZNK5clang20AssertCapabilityAttr8isSharedEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZNK5clang20AssertCapabilityAttr8isSharedEv")
  //</editor-fold>
  public boolean isShared() /*const*/ {
    return SpellingListIndex == $int2uint_4bits(2)
       || SpellingListIndex == $int2uint_4bits(3);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::AssertCapabilityAttr::getExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/Attrs.inc", line = 853,
   FQN="clang::AssertCapabilityAttr::getExpr", NM="_ZNK5clang20AssertCapabilityAttr7getExprEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZNK5clang20AssertCapabilityAttr7getExprEv")
  //</editor-fold>
  public Expr /*P*/ getExpr() /*const*/ {
    return expr;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::AssertCapabilityAttr::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/Attrs.inc", line = 859,
   FQN="clang::AssertCapabilityAttr::classof", NM="_ZN5clang20AssertCapabilityAttr7classofEPKNS_4AttrE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZN5clang20AssertCapabilityAttr7classofEPKNS_4AttrE")
  //</editor-fold>
  public static boolean classof(/*const*/ Attr /*P*/ A) {
    return A.getKind() == attr.Kind.AssertCapability;
  }

  
  @Override public String toString() {
    return "" + "expr=" + expr // NOI18N
              + super.toString(); // NOI18N
  }
}
