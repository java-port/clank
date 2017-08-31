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

//<editor-fold defaultstate="collapsed" desc="clang::AlwaysInlineAttr">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/Attrs.inc", line = 546,
 FQN="clang::AlwaysInlineAttr", NM="_ZN5clang16AlwaysInlineAttrE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZN5clang16AlwaysInlineAttrE")
//</editor-fold>
public class AlwaysInlineAttr extends /*public*/ InheritableAttr {
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::AlwaysInlineAttr::Spelling">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/Attrs.inc", line = 548,
   FQN="clang::AlwaysInlineAttr::Spelling", NM="_ZN5clang16AlwaysInlineAttr8SpellingE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZN5clang16AlwaysInlineAttr8SpellingE")
  //</editor-fold>
  public enum Spelling implements Native.ComparableLower {
    GNU_always_inline(0),
    CXX11_gnu_always_inline(1),
    Keyword_forceinline(2);

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
  
  //<editor-fold defaultstate="collapsed" desc="clang::AlwaysInlineAttr::CreateImplicit">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/Attrs.inc", line = 554,
   FQN="clang::AlwaysInlineAttr::CreateImplicit", NM="_ZN5clang16AlwaysInlineAttr14CreateImplicitERNS_10ASTContextENS0_8SpellingENS_11SourceRangeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZN5clang16AlwaysInlineAttr14CreateImplicitERNS_10ASTContextENS0_8SpellingENS_11SourceRangeE")
  //</editor-fold>
  public static AlwaysInlineAttr /*P*/ CreateImplicit(final ASTContext /*&*/ Ctx, Spelling S) {
    return CreateImplicit(Ctx, S, new SourceRange());
  }
  public static AlwaysInlineAttr /*P*/ CreateImplicit(final ASTContext /*&*/ Ctx, Spelling S, SourceRange Loc/*= SourceRange()*/) {
    AlwaysInlineAttr /*P*/ A = /*FIXME:NEW_EXPR*//*new (Ctx)*/ new AlwaysInlineAttr(new SourceRange(Loc), Ctx, S.getValue());
    A.setImplicit(true);
    return A;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::AlwaysInlineAttr::AlwaysInlineAttr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/Attrs.inc", line = 560,
   FQN="clang::AlwaysInlineAttr::AlwaysInlineAttr", NM="_ZN5clang16AlwaysInlineAttrC1ENS_11SourceRangeERNS_10ASTContextEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZN5clang16AlwaysInlineAttrC1ENS_11SourceRangeERNS_10ASTContextEj")
  //</editor-fold>
  public AlwaysInlineAttr(SourceRange R, final ASTContext /*&*/ Ctx, 
      /*uint*/int SI) {
    // : InheritableAttr(attr::AlwaysInline, R, SI, false, false) 
    //START JInit
    super(attr.Kind.AlwaysInline, new SourceRange(R), SI, false, false);
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::AlwaysInlineAttr::clone">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/AttrImpl.inc", line = 488,
   FQN="clang::AlwaysInlineAttr::clone", NM="_ZNK5clang16AlwaysInlineAttr5cloneERNS_10ASTContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZNK5clang16AlwaysInlineAttr5cloneERNS_10ASTContextE")
  //</editor-fold>
  public AlwaysInlineAttr /*P*/ clone(final ASTContext /*&*/ C) /*const*/ {
    AlwaysInlineAttr /*P*/ A = /*FIXME:NEW_EXPR*//*new (C)*/ new AlwaysInlineAttr(new SourceRange(getLocation()), C, getSpellingListIndex());
    A.Inherited = Inherited;
    A.IsPackExpansion = IsPackExpansion;
    A.Implicit = Implicit;
    return A;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::AlwaysInlineAttr::printPretty">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/AttrImpl.inc", line = 496,
   FQN="clang::AlwaysInlineAttr::printPretty", NM="_ZNK5clang16AlwaysInlineAttr11printPrettyERN4llvm11raw_ostreamERKNS_14PrintingPolicyE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZNK5clang16AlwaysInlineAttr11printPrettyERN4llvm11raw_ostreamERKNS_14PrintingPolicyE")
  //</editor-fold>
  public void printPretty(final raw_ostream /*&*/ OS, final /*const*/ PrintingPolicy /*&*/ Policy) /*const*/ {
    switch (SpellingListIndex) {
     default:
      throw new llvm_unreachable("Unknown attribute spelling!");
//      break;
     case 0:
      {
        OS.$out(/*KEEP_STR*/" __attribute__((always_inline))");
        break;
      }
     case 1:
      {
        OS.$out(/*KEEP_STR*/" [[gnu::always_inline]]");
        break;
      }
     case 2:
      {
        OS.$out(/*KEEP_STR*/" __forceinline");
        break;
      }
    }
  }

  //<editor-fold defaultstate="collapsed" desc="clang::AlwaysInlineAttr::getSpelling">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/AttrImpl.inc", line = 516,
   FQN="clang::AlwaysInlineAttr::getSpelling", NM="_ZNK5clang16AlwaysInlineAttr11getSpellingEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZNK5clang16AlwaysInlineAttr11getSpellingEv")
  //</editor-fold>
  public /*const*/char$ptr/*char P*/ getSpelling() /*const*/ {
    switch (SpellingListIndex) {
     default:
      throw new llvm_unreachable("Unknown attribute spelling!");
//      return $("(No spelling)");
     case 0:
      return $("always_inline");
     case 1:
      return $("always_inline");
     case 2:
      return $("__forceinline"); // JAVA: replaced by usual string constants
    }
  }

  //<editor-fold defaultstate="collapsed" desc="clang::AlwaysInlineAttr::getSemanticSpelling">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/Attrs.inc", line = 571,
   FQN="clang::AlwaysInlineAttr::getSemanticSpelling", NM="_ZNK5clang16AlwaysInlineAttr19getSemanticSpellingEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZNK5clang16AlwaysInlineAttr19getSemanticSpellingEv")
  //</editor-fold>
  public Spelling getSemanticSpelling() /*const*/ {
    switch (SpellingListIndex) {
     default:
      throw new llvm_unreachable("Unknown spelling list index");
     case 0:
      return Spelling.GNU_always_inline;
     case 1:
      return Spelling.CXX11_gnu_always_inline;
     case 2:
      return Spelling.Keyword_forceinline;
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::AlwaysInlineAttr::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/Attrs.inc", line = 581,
   FQN="clang::AlwaysInlineAttr::classof", NM="_ZN5clang16AlwaysInlineAttr7classofEPKNS_4AttrE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZN5clang16AlwaysInlineAttr7classofEPKNS_4AttrE")
  //</editor-fold>
  public static boolean classof(/*const*/ Attr /*P*/ A) {
    return A.getKind() == attr.Kind.AlwaysInline;
  }

  
  @Override public String toString() {
    return "" + super.toString(); // NOI18N
  }
}
