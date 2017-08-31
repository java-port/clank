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

//<editor-fold defaultstate="collapsed" desc="clang::ParamTypestateAttr">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/Attrs.inc", line = 5354,
 FQN="clang::ParamTypestateAttr", NM="_ZN5clang18ParamTypestateAttrE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZN5clang18ParamTypestateAttrE")
//</editor-fold>
public class ParamTypestateAttr extends /*public*/ InheritableAttr {
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::ParamTypestateAttr::ConsumedState">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/Attrs.inc", line = 5356,
   FQN="clang::ParamTypestateAttr::ConsumedState", NM="_ZN5clang18ParamTypestateAttr13ConsumedStateE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZN5clang18ParamTypestateAttr13ConsumedStateE")
  //</editor-fold>
  public enum ConsumedState implements Native.ComparableLower {
    Unknown(0),
    Consumed(Unknown.getValue() + 1),
    Unconsumed(Consumed.getValue() + 1);

    //<editor-fold defaultstate="collapsed" desc="hidden">
    public static ConsumedState valueOf(int val) {
      ConsumedState out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
      assert out != null : "no value for " + val;
      assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
      return out;
    }

    private static final class Values {
      private static final ConsumedState[] VALUES;
      private static final ConsumedState[] _VALUES; // [0] not used
      static {
        int max = 0;
        int min = 0;
        for (ConsumedState kind : ConsumedState.values()) {
          if (kind.value > max) { max = kind.value; }
          if (kind.value < min) { min = kind.value; }
        }
        _VALUES = new ConsumedState[min < 0 ? (1-min) : 0];
        VALUES = new ConsumedState[max >= 0 ? (1+max) : 0];
        for (ConsumedState kind : ConsumedState.values()) {
          if (kind.value < 0) {
            _VALUES[-kind.value] = kind;
          } else {
            VALUES[kind.value] = kind;
          }
        }
      }
    }

    private final /*uint*/int value;
    private ConsumedState(int val) { this.value = (/*uint*/int)val;}
    public /*uint*/int getValue() { return value;}
    @Override public boolean $less(Object obj) { return Unsigned.$less_uint(value, ((ConsumedState)obj).value);}
    @Override public boolean $lesseq(Object obj) { return Unsigned.$lesseq_uint(value, ((ConsumedState)obj).value);}
    //</editor-fold>
  };
/*private:*/
  private ConsumedState paramState;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::ParamTypestateAttr::CreateImplicit">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/Attrs.inc", line = 5365,
   FQN="clang::ParamTypestateAttr::CreateImplicit", NM="_ZN5clang18ParamTypestateAttr14CreateImplicitERNS_10ASTContextENS0_13ConsumedStateENS_11SourceRangeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZN5clang18ParamTypestateAttr14CreateImplicitERNS_10ASTContextENS0_13ConsumedStateENS_11SourceRangeE")
  //</editor-fold>
  public static ParamTypestateAttr /*P*/ CreateImplicit(final ASTContext /*&*/ Ctx, ConsumedState ParamState) {
    return CreateImplicit(Ctx, ParamState, new SourceRange());
  }
  public static ParamTypestateAttr /*P*/ CreateImplicit(final ASTContext /*&*/ Ctx, ConsumedState ParamState, SourceRange Loc/*= SourceRange()*/) {
    ParamTypestateAttr /*P*/ A = /*FIXME:NEW_EXPR*//*new (Ctx)*/ new ParamTypestateAttr(new SourceRange(Loc), Ctx, ParamState, 0);
    A.setImplicit(true);
    return A;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ParamTypestateAttr::ParamTypestateAttr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/Attrs.inc", line = 5371,
   FQN="clang::ParamTypestateAttr::ParamTypestateAttr", NM="_ZN5clang18ParamTypestateAttrC1ENS_11SourceRangeERNS_10ASTContextENS0_13ConsumedStateEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZN5clang18ParamTypestateAttrC1ENS_11SourceRangeERNS_10ASTContextENS0_13ConsumedStateEj")
  //</editor-fold>
  public ParamTypestateAttr(SourceRange R, final ASTContext /*&*/ Ctx, 
      ConsumedState ParamState, 
      /*uint*/int SI) {
    // : InheritableAttr(attr::ParamTypestate, R, SI, false, false), paramState(ParamState) 
    //START JInit
    super(attr.Kind.ParamTypestate, new SourceRange(R), SI, false, false);
    this.paramState = ParamState;
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ParamTypestateAttr::clone">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/AttrImpl.inc", line = 4969,
   FQN="clang::ParamTypestateAttr::clone", NM="_ZNK5clang18ParamTypestateAttr5cloneERNS_10ASTContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZNK5clang18ParamTypestateAttr5cloneERNS_10ASTContextE")
  //</editor-fold>
  public ParamTypestateAttr /*P*/ clone(final ASTContext /*&*/ C) /*const*/ {
    ParamTypestateAttr /*P*/ A = /*FIXME:NEW_EXPR*//*new (C)*/ new ParamTypestateAttr(new SourceRange(getLocation()), C, paramState, getSpellingListIndex());
    A.Inherited = Inherited;
    A.IsPackExpansion = IsPackExpansion;
    A.Implicit = Implicit;
    return A;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ParamTypestateAttr::printPretty">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/AttrImpl.inc", line = 4977,
   FQN="clang::ParamTypestateAttr::printPretty", NM="_ZNK5clang18ParamTypestateAttr11printPrettyERN4llvm11raw_ostreamERKNS_14PrintingPolicyE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZNK5clang18ParamTypestateAttr11printPrettyERN4llvm11raw_ostreamERKNS_14PrintingPolicyE")
  //</editor-fold>
  public void printPretty(final raw_ostream /*&*/ OS, final /*const*/ PrintingPolicy /*&*/ Policy) /*const*/ {
    switch (SpellingListIndex) {
     default:
      throw new llvm_unreachable("Unknown attribute spelling!");
//      break;
     case 0:
      {
        OS.$out(/*KEEP_STR*/" __attribute__((param_typestate(\"").$out(ParamTypestateAttr.ConvertConsumedStateToStr(getParamState())).$out(/*KEEP_STR*/"\")))");
        break;
      }
    }
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ParamTypestateAttr::getSpelling">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/AttrImpl.inc", line = 4989,
   FQN="clang::ParamTypestateAttr::getSpelling", NM="_ZNK5clang18ParamTypestateAttr11getSpellingEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZNK5clang18ParamTypestateAttr11getSpellingEv")
  //</editor-fold>
  public /*const*/char$ptr/*char P*/ getSpelling() /*const*/ {
    switch (SpellingListIndex) {
     default:
      throw new llvm_unreachable("Unknown attribute spelling!");
//      return $("(No spelling)");
     case 0:
      return $("param_typestate");
    }
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ParamTypestateAttr::getParamState">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/Attrs.inc", line = 5384,
   FQN="clang::ParamTypestateAttr::getParamState", NM="_ZNK5clang18ParamTypestateAttr13getParamStateEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZNK5clang18ParamTypestateAttr13getParamStateEv")
  //</editor-fold>
  public ConsumedState getParamState() /*const*/ {
    return paramState;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ParamTypestateAttr::ConvertStrToConsumedState">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/Attrs.inc", line = 5388,
   FQN="clang::ParamTypestateAttr::ConvertStrToConsumedState", NM="_ZN5clang18ParamTypestateAttr25ConvertStrToConsumedStateEN4llvm9StringRefERNS0_13ConsumedStateE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZN5clang18ParamTypestateAttr25ConvertStrToConsumedStateEN4llvm9StringRefERNS0_13ConsumedStateE")
  //</editor-fold>
  public static boolean ConvertStrToConsumedState(StringRef Val, final type$ref<ConsumedState /*&*/> Out) {
    Optional<ConsumedState> R = new StringSwitch<Optional<ConsumedState> >(/*NO_COPY*/Val).
        Case(/*KEEP_STR*/"unknown", new Optional<ConsumedState>(JD$T$RR.INSTANCE, ParamTypestateAttr.ConsumedState.Unknown)).
        Case(/*KEEP_STR*/"consumed", new Optional<ConsumedState>(JD$T$RR.INSTANCE, ParamTypestateAttr.ConsumedState.Consumed)).
        Case(/*KEEP_STR*/"unconsumed", new Optional<ConsumedState>(JD$T$RR.INSTANCE, ParamTypestateAttr.ConsumedState.Unconsumed)).
        Default(new Optional<ConsumedState>());
    if (R.$bool()) {
      Out.$set(R.$star());
      return true;
    }
    return false;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ParamTypestateAttr::ConvertConsumedStateToStr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/Attrs.inc", line = 5401,
   FQN="clang::ParamTypestateAttr::ConvertConsumedStateToStr", NM="_ZN5clang18ParamTypestateAttr25ConvertConsumedStateToStrENS0_13ConsumedStateE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZN5clang18ParamTypestateAttr25ConvertConsumedStateToStrENS0_13ConsumedStateE")
  //</editor-fold>
  public static /*const*/char$ptr/*char P*/ ConvertConsumedStateToStr(ConsumedState Val) {
    switch (Val) {
     case Unknown:
      return $unknown;
     case Consumed:
      return $("consumed");
     case Unconsumed:
      return $("unconsumed");
    }
    throw new llvm_unreachable("No enumerator with that value");
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ParamTypestateAttr::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/Attrs.inc", line = 5411,
   FQN="clang::ParamTypestateAttr::classof", NM="_ZN5clang18ParamTypestateAttr7classofEPKNS_4AttrE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZN5clang18ParamTypestateAttr7classofEPKNS_4AttrE")
  //</editor-fold>
  public static boolean classof(/*const*/ Attr /*P*/ A) {
    return A.getKind() == attr.Kind.ParamTypestate;
  }

  
  @Override public String toString() {
    return "" + "paramState=" + paramState // NOI18N
              + super.toString(); // NOI18N
  }
}
