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

//<editor-fold defaultstate="collapsed" desc="clang::ArgumentWithTypeTagAttr">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/Attrs.inc", line = 700,
 FQN="clang::ArgumentWithTypeTagAttr", NM="_ZN5clang23ArgumentWithTypeTagAttrE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZN5clang23ArgumentWithTypeTagAttrE")
//</editor-fold>
public class ArgumentWithTypeTagAttr extends /*public*/ InheritableAttr {
  private IdentifierInfo /*P*/ argumentKind;
  
  private /*uint*/int argumentIdx;
  
  private /*uint*/int typeTagIdx;
  
  private boolean isPointer;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::ArgumentWithTypeTagAttr::Spelling">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/Attrs.inc", line = 710,
   FQN="clang::ArgumentWithTypeTagAttr::Spelling", NM="_ZN5clang23ArgumentWithTypeTagAttr8SpellingE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZN5clang23ArgumentWithTypeTagAttr8SpellingE")
  //</editor-fold>
  public enum Spelling implements Native.ComparableLower {
    GNU_argument_with_type_tag(0),
    GNU_pointer_with_type_tag(1);

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
  
  //<editor-fold defaultstate="collapsed" desc="clang::ArgumentWithTypeTagAttr::CreateImplicit">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/Attrs.inc", line = 715,
   FQN="clang::ArgumentWithTypeTagAttr::CreateImplicit", NM="_ZN5clang23ArgumentWithTypeTagAttr14CreateImplicitERNS_10ASTContextENS0_8SpellingEPNS_14IdentifierInfoEjjbNS_11SourceRangeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZN5clang23ArgumentWithTypeTagAttr14CreateImplicitERNS_10ASTContextENS0_8SpellingEPNS_14IdentifierInfoEjjbNS_11SourceRangeE")
  //</editor-fold>
  public static ArgumentWithTypeTagAttr /*P*/ CreateImplicit(final ASTContext /*&*/ Ctx, Spelling S, IdentifierInfo /*P*/ ArgumentKind, /*uint*/int ArgumentIdx, /*uint*/int TypeTagIdx, boolean IsPointer) {
    return CreateImplicit(Ctx, S, ArgumentKind, ArgumentIdx, TypeTagIdx, IsPointer, new SourceRange());
  }
  public static ArgumentWithTypeTagAttr /*P*/ CreateImplicit(final ASTContext /*&*/ Ctx, Spelling S, IdentifierInfo /*P*/ ArgumentKind, /*uint*/int ArgumentIdx, /*uint*/int TypeTagIdx, boolean IsPointer, SourceRange Loc/*= SourceRange()*/) {
    ArgumentWithTypeTagAttr /*P*/ A = /*FIXME:NEW_EXPR*//*new (Ctx)*/ new ArgumentWithTypeTagAttr(new SourceRange(Loc), Ctx, ArgumentKind, ArgumentIdx, TypeTagIdx, IsPointer, S.getValue());
    A.setImplicit(true);
    return A;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ArgumentWithTypeTagAttr::ArgumentWithTypeTagAttr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/Attrs.inc", line = 721,
   FQN="clang::ArgumentWithTypeTagAttr::ArgumentWithTypeTagAttr", NM="_ZN5clang23ArgumentWithTypeTagAttrC1ENS_11SourceRangeERNS_10ASTContextEPNS_14IdentifierInfoEjjbj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZN5clang23ArgumentWithTypeTagAttrC1ENS_11SourceRangeERNS_10ASTContextEPNS_14IdentifierInfoEjjbj")
  //</editor-fold>
  public ArgumentWithTypeTagAttr(SourceRange R, final ASTContext /*&*/ Ctx, 
      IdentifierInfo /*P*/ ArgumentKind, 
      /*uint*/int ArgumentIdx, 
      /*uint*/int TypeTagIdx, 
      boolean IsPointer, 
      /*uint*/int SI) {
    // : InheritableAttr(attr::ArgumentWithTypeTag, R, SI, false, false), argumentKind(ArgumentKind), argumentIdx(ArgumentIdx), typeTagIdx(TypeTagIdx), isPointer(IsPointer) 
    //START JInit
    super(attr.Kind.ArgumentWithTypeTag, new SourceRange(R), SI, false, false);
    this.argumentKind = ArgumentKind;
    this.argumentIdx = ArgumentIdx;
    this.typeTagIdx = TypeTagIdx;
    this.isPointer = IsPointer;
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ArgumentWithTypeTagAttr::clone">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/AttrImpl.inc", line = 650,
   FQN="clang::ArgumentWithTypeTagAttr::clone", NM="_ZNK5clang23ArgumentWithTypeTagAttr5cloneERNS_10ASTContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZNK5clang23ArgumentWithTypeTagAttr5cloneERNS_10ASTContextE")
  //</editor-fold>
  public ArgumentWithTypeTagAttr /*P*/ clone(final ASTContext /*&*/ C) /*const*/ {
    ArgumentWithTypeTagAttr /*P*/ A = /*FIXME:NEW_EXPR*//*new (C)*/ new ArgumentWithTypeTagAttr(new SourceRange(getLocation()), C, argumentKind, argumentIdx, typeTagIdx, isPointer, getSpellingListIndex());
    A.Inherited = Inherited;
    A.IsPackExpansion = IsPackExpansion;
    A.Implicit = Implicit;
    return A;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ArgumentWithTypeTagAttr::printPretty">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/AttrImpl.inc", line = 658,
   FQN="clang::ArgumentWithTypeTagAttr::printPretty", NM="_ZNK5clang23ArgumentWithTypeTagAttr11printPrettyERN4llvm11raw_ostreamERKNS_14PrintingPolicyE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZNK5clang23ArgumentWithTypeTagAttr11printPrettyERN4llvm11raw_ostreamERKNS_14PrintingPolicyE")
  //</editor-fold>
  public void printPretty(final raw_ostream /*&*/ OS, final /*const*/ PrintingPolicy /*&*/ Policy) /*const*/ {
    switch (SpellingListIndex) {
     default:
      throw new llvm_unreachable("Unknown attribute spelling!");
//      break;
     case 0:
      {
        OS.$out(/*KEEP_STR*/" __attribute__((argument_with_type_tag(").$out(getArgumentKind().getName()).$out(/*KEEP_STR*/$COMMA_SPACE).$out_uint(getArgumentIdx()).$out(/*KEEP_STR*/$COMMA_SPACE).$out_uint(getTypeTagIdx()).$out(/*KEEP_STR*/$COMMA_SPACE).$out_int((getIsPointer() ? 1 : 0)).$out(/*KEEP_STR*/")))");
        break;
      }
     case 1:
      {
        OS.$out(/*KEEP_STR*/" __attribute__((pointer_with_type_tag(").$out(getArgumentKind().getName()).$out(/*KEEP_STR*/$COMMA_SPACE).$out_uint(getArgumentIdx()).$out(/*KEEP_STR*/$COMMA_SPACE).$out_uint(getTypeTagIdx()).$out(/*KEEP_STR*/$COMMA_SPACE).$out_int((getIsPointer() ? 1 : 0)).$out(/*KEEP_STR*/")))");
        break;
      }
    }
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ArgumentWithTypeTagAttr::getSpelling">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/AttrImpl.inc", line = 674,
   FQN="clang::ArgumentWithTypeTagAttr::getSpelling", NM="_ZNK5clang23ArgumentWithTypeTagAttr11getSpellingEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZNK5clang23ArgumentWithTypeTagAttr11getSpellingEv")
  //</editor-fold>
  public /*const*/char$ptr/*char P*/ getSpelling() /*const*/ {
    switch (SpellingListIndex) {
     default:
      throw new llvm_unreachable("Unknown attribute spelling!");
//      return $("(No spelling)");
     case 0:
      return $("argument_with_type_tag");
     case 1:
      return $("pointer_with_type_tag");
    }
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ArgumentWithTypeTagAttr::getSemanticSpelling">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/Attrs.inc", line = 740,
   FQN="clang::ArgumentWithTypeTagAttr::getSemanticSpelling", NM="_ZNK5clang23ArgumentWithTypeTagAttr19getSemanticSpellingEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZNK5clang23ArgumentWithTypeTagAttr19getSemanticSpellingEv")
  //</editor-fold>
  public Spelling getSemanticSpelling() /*const*/ {
    switch (SpellingListIndex) {
     default:
      throw new llvm_unreachable("Unknown spelling list index");
     case 0:
      return Spelling.GNU_argument_with_type_tag;
     case 1:
      return Spelling.GNU_pointer_with_type_tag;
    }
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ArgumentWithTypeTagAttr::getArgumentKind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/Attrs.inc", line = 747,
   FQN="clang::ArgumentWithTypeTagAttr::getArgumentKind", NM="_ZNK5clang23ArgumentWithTypeTagAttr15getArgumentKindEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZNK5clang23ArgumentWithTypeTagAttr15getArgumentKindEv")
  //</editor-fold>
  public IdentifierInfo /*P*/ getArgumentKind() /*const*/ {
    return argumentKind;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ArgumentWithTypeTagAttr::getArgumentIdx">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/Attrs.inc", line = 751,
   FQN="clang::ArgumentWithTypeTagAttr::getArgumentIdx", NM="_ZNK5clang23ArgumentWithTypeTagAttr14getArgumentIdxEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZNK5clang23ArgumentWithTypeTagAttr14getArgumentIdxEv")
  //</editor-fold>
  public /*uint*/int getArgumentIdx() /*const*/ {
    return argumentIdx;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ArgumentWithTypeTagAttr::getTypeTagIdx">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/Attrs.inc", line = 755,
   FQN="clang::ArgumentWithTypeTagAttr::getTypeTagIdx", NM="_ZNK5clang23ArgumentWithTypeTagAttr13getTypeTagIdxEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZNK5clang23ArgumentWithTypeTagAttr13getTypeTagIdxEv")
  //</editor-fold>
  public /*uint*/int getTypeTagIdx() /*const*/ {
    return typeTagIdx;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ArgumentWithTypeTagAttr::getIsPointer">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/Attrs.inc", line = 759,
   FQN="clang::ArgumentWithTypeTagAttr::getIsPointer", NM="_ZNK5clang23ArgumentWithTypeTagAttr12getIsPointerEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZNK5clang23ArgumentWithTypeTagAttr12getIsPointerEv")
  //</editor-fold>
  public boolean getIsPointer() /*const*/ {
    return isPointer;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ArgumentWithTypeTagAttr::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/Attrs.inc", line = 765,
   FQN="clang::ArgumentWithTypeTagAttr::classof", NM="_ZN5clang23ArgumentWithTypeTagAttr7classofEPKNS_4AttrE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZN5clang23ArgumentWithTypeTagAttr7classofEPKNS_4AttrE")
  //</editor-fold>
  public static boolean classof(/*const*/ Attr /*P*/ A) {
    return A.getKind() == attr.Kind.ArgumentWithTypeTag;
  }

  
  @Override public String toString() {
    return "" + "argumentKind=" + argumentKind // NOI18N
              + ", argumentIdx=" + argumentIdx // NOI18N
              + ", typeTagIdx=" + typeTagIdx // NOI18N
              + ", isPointer=" + isPointer // NOI18N
              + super.toString(); // NOI18N
  }
}
