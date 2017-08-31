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

import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.java.std.*;
import static org.clank.support.NativePointer.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.clang.basic.*;

//<editor-fold defaultstate="collapsed" desc="clang::LoopHintAttr">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/Attrs.inc", line = 3048,
 FQN="clang::LoopHintAttr", NM="_ZN5clang12LoopHintAttrE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZN5clang12LoopHintAttrE")
//</editor-fold>
public class LoopHintAttr extends /*public*/ Attr {
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::LoopHintAttr::OptionType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/Attrs.inc", line = 3050,
   FQN="clang::LoopHintAttr::OptionType", NM="_ZN5clang12LoopHintAttr10OptionTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZN5clang12LoopHintAttr10OptionTypeE")
  //</editor-fold>
  public enum OptionType implements Native.ComparableLower {
    Vectorize(0),
    VectorizeWidth(Vectorize.getValue() + 1),
    Interleave(VectorizeWidth.getValue() + 1),
    InterleaveCount(Interleave.getValue() + 1),
    Unroll(InterleaveCount.getValue() + 1),
    UnrollCount(Unroll.getValue() + 1),
    Distribute(UnrollCount.getValue() + 1);

    //<editor-fold defaultstate="collapsed" desc="hidden">
    public static OptionType valueOf(int val) {
      OptionType out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
      assert out != null : "no value for " + val;
      assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
      return out;
    }

    private static final class Values {
      private static final OptionType[] VALUES;
      private static final OptionType[] _VALUES; // [0] not used
      static {
        int max = 0;
        int min = 0;
        for (OptionType kind : OptionType.values()) {
          if (kind.value > max) { max = kind.value; }
          if (kind.value < min) { min = kind.value; }
        }
        _VALUES = new OptionType[min < 0 ? (1-min) : 0];
        VALUES = new OptionType[max >= 0 ? (1+max) : 0];
        for (OptionType kind : OptionType.values()) {
          if (kind.value < 0) {
            _VALUES[-kind.value] = kind;
          } else {
            VALUES[kind.value] = kind;
          }
        }
      }
    }

    private final /*uint*/int value;
    private OptionType(int val) { this.value = (/*uint*/int)val;}
    public /*uint*/int getValue() { return value;}
    @Override public boolean $less(Object obj) { return Unsigned.$less_uint(value, ((OptionType)obj).value);}
    @Override public boolean $lesseq(Object obj) { return Unsigned.$lesseq_uint(value, ((OptionType)obj).value);}
    //</editor-fold>
  };
/*private:*/
  private OptionType option;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::LoopHintAttr::LoopHintState">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/Attrs.inc", line = 3063,
   FQN="clang::LoopHintAttr::LoopHintState", NM="_ZN5clang12LoopHintAttr13LoopHintStateE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZN5clang12LoopHintAttr13LoopHintStateE")
  //</editor-fold>
  public enum LoopHintState implements Native.ComparableLower {
    Enable(0),
    Disable(Enable.getValue() + 1),
    Numeric(Disable.getValue() + 1),
    AssumeSafety(Numeric.getValue() + 1),
    Full(AssumeSafety.getValue() + 1);

    //<editor-fold defaultstate="collapsed" desc="hidden">
    public static LoopHintState valueOf(int val) {
      LoopHintState out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
      assert out != null : "no value for " + val;
      assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
      return out;
    }

    private static final class Values {
      private static final LoopHintState[] VALUES;
      private static final LoopHintState[] _VALUES; // [0] not used
      static {
        int max = 0;
        int min = 0;
        for (LoopHintState kind : LoopHintState.values()) {
          if (kind.value > max) { max = kind.value; }
          if (kind.value < min) { min = kind.value; }
        }
        _VALUES = new LoopHintState[min < 0 ? (1-min) : 0];
        VALUES = new LoopHintState[max >= 0 ? (1+max) : 0];
        for (LoopHintState kind : LoopHintState.values()) {
          if (kind.value < 0) {
            _VALUES[-kind.value] = kind;
          } else {
            VALUES[kind.value] = kind;
          }
        }
      }
    }

    private final /*uint*/int value;
    private LoopHintState(int val) { this.value = (/*uint*/int)val;}
    public /*uint*/int getValue() { return value;}
    @Override public boolean $less(Object obj) { return Unsigned.$less_uint(value, ((LoopHintState)obj).value);}
    @Override public boolean $lesseq(Object obj) { return Unsigned.$lesseq_uint(value, ((LoopHintState)obj).value);}
    //</editor-fold>
  };
/*private:*/
  private LoopHintState state;
  
  private Expr /*P*/ value;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::LoopHintAttr::Spelling">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/Attrs.inc", line = 3076,
   FQN="clang::LoopHintAttr::Spelling", NM="_ZN5clang12LoopHintAttr8SpellingE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZN5clang12LoopHintAttr8SpellingE")
  //</editor-fold>
  public enum Spelling implements Native.ComparableLower {
    Pragma_clang_loop(0),
    Pragma_unroll(1),
    Pragma_nounroll(2);

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
  
  //<editor-fold defaultstate="collapsed" desc="clang::LoopHintAttr::CreateImplicit">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/Attrs.inc", line = 3082,
   FQN="clang::LoopHintAttr::CreateImplicit", NM="_ZN5clang12LoopHintAttr14CreateImplicitERNS_10ASTContextENS0_8SpellingENS0_10OptionTypeENS0_13LoopHintStateEPNS_4ExprENS_11SourceRangeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZN5clang12LoopHintAttr14CreateImplicitERNS_10ASTContextENS0_8SpellingENS0_10OptionTypeENS0_13LoopHintStateEPNS_4ExprENS_11SourceRangeE")
  //</editor-fold>
  public static LoopHintAttr /*P*/ CreateImplicit(final ASTContext /*&*/ Ctx, Spelling S, OptionType Option, LoopHintState State, Expr /*P*/ Value) {
    return CreateImplicit(Ctx, S, Option, State, Value, new SourceRange());
  }
  public static LoopHintAttr /*P*/ CreateImplicit(final ASTContext /*&*/ Ctx, Spelling S, OptionType Option, LoopHintState State, Expr /*P*/ Value, SourceRange Loc/*= SourceRange()*/) {
    LoopHintAttr /*P*/ A = /*FIXME:NEW_EXPR*//*new (Ctx)*/ new LoopHintAttr(new SourceRange(Loc), Ctx, Option, State, Value, S.getValue());
    A.setImplicit(true);
    return A;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::LoopHintAttr::LoopHintAttr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/Attrs.inc", line = 3088,
   FQN="clang::LoopHintAttr::LoopHintAttr", NM="_ZN5clang12LoopHintAttrC1ENS_11SourceRangeERNS_10ASTContextENS0_10OptionTypeENS0_13LoopHintStateEPNS_4ExprEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZN5clang12LoopHintAttrC1ENS_11SourceRangeERNS_10ASTContextENS0_10OptionTypeENS0_13LoopHintStateEPNS_4ExprEj")
  //</editor-fold>
  public LoopHintAttr(SourceRange R, final ASTContext /*&*/ Ctx, 
      OptionType Option, 
      LoopHintState State, 
      Expr /*P*/ Value, 
      /*uint*/int SI) {
    // : Attr(attr::LoopHint, R, SI, false, false), option(Option), state(State), value(Value) 
    //START JInit
    super(attr.Kind.LoopHint, new SourceRange(R), SI, false, false);
    this.option = Option;
    this.state = State;
    this.value = Value;
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::LoopHintAttr::clone">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/AttrImpl.inc", line = 2893,
   FQN="clang::LoopHintAttr::clone", NM="_ZNK5clang12LoopHintAttr5cloneERNS_10ASTContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZNK5clang12LoopHintAttr5cloneERNS_10ASTContextE")
  //</editor-fold>
  public LoopHintAttr /*P*/ clone(final ASTContext /*&*/ C) /*const*/ {
    LoopHintAttr /*P*/ A = /*FIXME:NEW_EXPR*//*new (C)*/ new LoopHintAttr(new SourceRange(getLocation()), C, option, state, value, getSpellingListIndex());
    A.Inherited = Inherited;
    A.IsPackExpansion = IsPackExpansion;
    A.Implicit = Implicit;
    return A;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::LoopHintAttr::printPretty">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/AttrImpl.inc", line = 2901,
   FQN="clang::LoopHintAttr::printPretty", NM="_ZNK5clang12LoopHintAttr11printPrettyERN4llvm11raw_ostreamERKNS_14PrintingPolicyE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZNK5clang12LoopHintAttr11printPrettyERN4llvm11raw_ostreamERKNS_14PrintingPolicyE")
  //</editor-fold>
  public void printPretty(final raw_ostream /*&*/ OS, final /*const*/ PrintingPolicy /*&*/ Policy) /*const*/ {
    switch (SpellingListIndex) {
     default:
      throw new llvm_unreachable("Unknown attribute spelling!");
//      break;
     case 0:
      {
        OS.$out(/*KEEP_STR*/"#pragma clang loop ");
        printPrettyPragma(OS, Policy);
        OS.$out(/*KEEP_STR*/$LF);
        break;
      }
     case 1:
      {
        OS.$out(/*KEEP_STR*/"#pragma unroll ");
        printPrettyPragma(OS, Policy);
        OS.$out(/*KEEP_STR*/$LF);
        break;
      }
     case 2:
      {
        OS.$out(/*KEEP_STR*/"#pragma nounroll ");
        printPrettyPragma(OS, Policy);
        OS.$out(/*KEEP_STR*/$LF);
        break;
      }
    }
  }

  //<editor-fold defaultstate="collapsed" desc="clang::LoopHintAttr::getSpelling">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/AttrImpl.inc", line = 2924,
   FQN="clang::LoopHintAttr::getSpelling", NM="_ZNK5clang12LoopHintAttr11getSpellingEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZNK5clang12LoopHintAttr11getSpellingEv")
  //</editor-fold>
  public /*const*/char$ptr/*char P*/ getSpelling() /*const*/ {
    switch (SpellingListIndex) {
     default:
      throw new llvm_unreachable("Unknown attribute spelling!");
//      return $("(No spelling)");
     case 0:
      return $("loop");
     case 1:
      return $("unroll");
     case 2:
      return $("nounroll");
    }
  }

  //<editor-fold defaultstate="collapsed" desc="clang::LoopHintAttr::getSemanticSpelling">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/Attrs.inc", line = 3105,
   FQN="clang::LoopHintAttr::getSemanticSpelling", NM="_ZNK5clang12LoopHintAttr19getSemanticSpellingEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZNK5clang12LoopHintAttr19getSemanticSpellingEv")
  //</editor-fold>
  public Spelling getSemanticSpelling() /*const*/ {
    switch (SpellingListIndex) {
     default:
      throw new llvm_unreachable("Unknown spelling list index");
     case 0:
      return Spelling.Pragma_clang_loop;
     case 1:
      return Spelling.Pragma_unroll;
     case 2:
      return Spelling.Pragma_nounroll;
    }
  }

  //<editor-fold defaultstate="collapsed" desc="clang::LoopHintAttr::getOption">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/Attrs.inc", line = 3113,
   FQN="clang::LoopHintAttr::getOption", NM="_ZNK5clang12LoopHintAttr9getOptionEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZNK5clang12LoopHintAttr9getOptionEv")
  //</editor-fold>
  public OptionType getOption() /*const*/ {
    return option;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::LoopHintAttr::ConvertStrToOptionType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/Attrs.inc", line = 3117,
   FQN="clang::LoopHintAttr::ConvertStrToOptionType", NM="_ZN5clang12LoopHintAttr22ConvertStrToOptionTypeEN4llvm9StringRefERNS0_10OptionTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZN5clang12LoopHintAttr22ConvertStrToOptionTypeEN4llvm9StringRefERNS0_10OptionTypeE")
  //</editor-fold>
  public static boolean ConvertStrToOptionType(StringRef Val, final type$ref<OptionType /*&*/> Out) {
    Optional<OptionType> R = new StringSwitch<Optional<OptionType> >(/*NO_COPY*/Val).
        Case(/*KEEP_STR*/"vectorize", new Optional<OptionType>(JD$T$RR.INSTANCE, LoopHintAttr.OptionType.Vectorize)).
        Case(/*KEEP_STR*/"vectorize_width", new Optional<OptionType>(JD$T$RR.INSTANCE, LoopHintAttr.OptionType.VectorizeWidth)).
        Case(/*KEEP_STR*/"interleave", new Optional<OptionType>(JD$T$RR.INSTANCE, LoopHintAttr.OptionType.Interleave)).
        Case(/*KEEP_STR*/"interleave_count", new Optional<OptionType>(JD$T$RR.INSTANCE, LoopHintAttr.OptionType.InterleaveCount)).
        Case(/*KEEP_STR*/"unroll", new Optional<OptionType>(JD$T$RR.INSTANCE, LoopHintAttr.OptionType.Unroll)).
        Case(/*KEEP_STR*/"unroll_count", new Optional<OptionType>(JD$T$RR.INSTANCE, LoopHintAttr.OptionType.UnrollCount)).
        Case(/*KEEP_STR*/"distribute", new Optional<OptionType>(JD$T$RR.INSTANCE, LoopHintAttr.OptionType.Distribute)).
        Default(new Optional<OptionType>());
    if (R.$bool()) {
      Out.$set(R.$star());
      return true;
    }
    return false;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::LoopHintAttr::ConvertOptionTypeToStr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/Attrs.inc", line = 3134,
   FQN="clang::LoopHintAttr::ConvertOptionTypeToStr", NM="_ZN5clang12LoopHintAttr22ConvertOptionTypeToStrENS0_10OptionTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZN5clang12LoopHintAttr22ConvertOptionTypeToStrENS0_10OptionTypeE")
  //</editor-fold>
  public static /*const*/char$ptr/*char P*/ ConvertOptionTypeToStr(OptionType Val) {
    switch (Val) {
     case Vectorize:
      return $("vectorize");
     case VectorizeWidth:
      return $("vectorize_width");
     case Interleave:
      return $("interleave");
     case InterleaveCount:
      return $("interleave_count");
     case Unroll:
      return $("unroll");
     case UnrollCount:
      return $("unroll_count");
     case Distribute:
      return $("distribute");
    }
    throw new llvm_unreachable("No enumerator with that value");
  }

  //<editor-fold defaultstate="collapsed" desc="clang::LoopHintAttr::getState">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/Attrs.inc", line = 3146,
   FQN="clang::LoopHintAttr::getState", NM="_ZNK5clang12LoopHintAttr8getStateEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZNK5clang12LoopHintAttr8getStateEv")
  //</editor-fold>
  public LoopHintState getState() /*const*/ {
    return state;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::LoopHintAttr::ConvertStrToLoopHintState">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/Attrs.inc", line = 3150,
   FQN="clang::LoopHintAttr::ConvertStrToLoopHintState", NM="_ZN5clang12LoopHintAttr25ConvertStrToLoopHintStateEN4llvm9StringRefERNS0_13LoopHintStateE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZN5clang12LoopHintAttr25ConvertStrToLoopHintStateEN4llvm9StringRefERNS0_13LoopHintStateE")
  //</editor-fold>
  public static boolean ConvertStrToLoopHintState(StringRef Val, final type$ref<LoopHintState /*&*/> Out) {
    Optional<LoopHintState> R = new StringSwitch<Optional<LoopHintState> >(/*NO_COPY*/Val).
        Case(/*KEEP_STR*/"enable", new Optional<LoopHintState>(JD$T$RR.INSTANCE, LoopHintAttr.LoopHintState.Enable)).
        Case(/*KEEP_STR*/"disable", new Optional<LoopHintState>(JD$T$RR.INSTANCE, LoopHintAttr.LoopHintState.Disable)).
        Case(/*KEEP_STR*/"numeric", new Optional<LoopHintState>(JD$T$RR.INSTANCE, LoopHintAttr.LoopHintState.Numeric)).
        Case(/*KEEP_STR*/"assume_safety", new Optional<LoopHintState>(JD$T$RR.INSTANCE, LoopHintAttr.LoopHintState.AssumeSafety)).
        Case(/*KEEP_STR*/"full", new Optional<LoopHintState>(JD$T$RR.INSTANCE, LoopHintAttr.LoopHintState.Full)).
        Default(new Optional<LoopHintState>());
    if (R.$bool()) {
      Out.$set(R.$star());
      return true;
    }
    return false;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::LoopHintAttr::ConvertLoopHintStateToStr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/Attrs.inc", line = 3165,
   FQN="clang::LoopHintAttr::ConvertLoopHintStateToStr", NM="_ZN5clang12LoopHintAttr25ConvertLoopHintStateToStrENS0_13LoopHintStateE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZN5clang12LoopHintAttr25ConvertLoopHintStateToStrENS0_13LoopHintStateE")
  //</editor-fold>
  public static /*const*/char$ptr/*char P*/ ConvertLoopHintStateToStr(LoopHintState Val) {
    switch (Val) {
     case Enable:
      return $("enable");
     case Disable:
      return $("disable");
     case Numeric:
      return $("numeric");
     case AssumeSafety:
      return $("assume_safety");
     case Full:
      return $("full");
    }
    throw new llvm_unreachable("No enumerator with that value");
  }

  //<editor-fold defaultstate="collapsed" desc="clang::LoopHintAttr::getValue">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/Attrs.inc", line = 3175,
   FQN="clang::LoopHintAttr::getValue", NM="_ZNK5clang12LoopHintAttr8getValueEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZNK5clang12LoopHintAttr8getValueEv")
  //</editor-fold>
  public Expr /*P*/ getValue() /*const*/ {
    return value;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::LoopHintAttr::getOptionName">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/Attrs.inc", line = 3180,
   FQN="clang::LoopHintAttr::getOptionName", NM="_ZN5clang12LoopHintAttr13getOptionNameEi",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZN5clang12LoopHintAttr13getOptionNameEi")
  //</editor-fold>
  public static /*const*/char$ptr/*char P*/ getOptionName(int Option) {
    switch (OptionType.valueOf(Option)) {
     case Vectorize:
      return $("vectorize");
     case VectorizeWidth:
      return $("vectorize_width");
     case Interleave:
      return $("interleave");
     case InterleaveCount:
      return $("interleave_count");
     case Unroll:
      return $("unroll");
     case UnrollCount:
      return $("unroll_count");
     case Distribute:
      return $("distribute");
    }
    throw new llvm_unreachable("Unhandled LoopHint option.");
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::LoopHintAttr::printPrettyPragma">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/Attrs.inc", line = 3193,
   FQN="clang::LoopHintAttr::printPrettyPragma", NM="_ZNK5clang12LoopHintAttr17printPrettyPragmaERN4llvm11raw_ostreamERKNS_14PrintingPolicyE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZNK5clang12LoopHintAttr17printPrettyPragmaERN4llvm11raw_ostreamERKNS_14PrintingPolicyE")
  //</editor-fold>
  public void printPrettyPragma(final raw_ostream /*&*/ OS, final /*const*/ PrintingPolicy /*&*/ Policy) /*const*/ {
    /*uint*/int SpellingIndex = getSpellingListIndex();
    // For "#pragma unroll" and "#pragma nounroll" the string "unroll" or
    // "nounroll" is already emitted as the pragma name.
    if (SpellingIndex == Spelling.Pragma_nounroll.getValue()) {
      return;
    } else if (SpellingIndex == Spelling.Pragma_unroll.getValue()) {
      OS.$out(getValueString(Policy));
      return;
    }
    assert (SpellingIndex == Spelling.Pragma_clang_loop.getValue()) : "Unexpected spelling";
    OS.$out(getOptionName(option.getValue())).$out(getValueString(Policy));
  }

  
  // Return a string containing the loop hint argument including the
  // enclosing parentheses.
  //<editor-fold defaultstate="collapsed" desc="clang::LoopHintAttr::getValueString">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/Attrs.inc", line = 3210,
   FQN="clang::LoopHintAttr::getValueString", NM="_ZNK5clang12LoopHintAttr14getValueStringERKNS_14PrintingPolicyE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZNK5clang12LoopHintAttr14getValueStringERKNS_14PrintingPolicyE")
  //</editor-fold>
  public std.string getValueString(final /*const*/ PrintingPolicy /*&*/ Policy) /*const*/ {
    raw_string_ostream OS = null;
    try {
      std.string ValueName/*J*/= new std.string();
      OS/*J*/= new raw_string_ostream(ValueName);
      OS.$out(/*KEEP_STR*/$LPAREN);
      if (state == LoopHintState.Numeric) {
        value.printPretty(OS, (PrinterHelper /*P*/ )null, Policy);
      } else if (state == LoopHintState.Enable) {
        OS.$out(/*KEEP_STR*/"enable");
      } else if (state == LoopHintState.Full) {
        OS.$out(/*KEEP_STR*/"full");
      } else if (state == LoopHintState.AssumeSafety) {
        OS.$out(/*KEEP_STR*/"assume_safety");
      } else {
        OS.$out(/*KEEP_STR*/"disable");
      }
      OS.$out(/*KEEP_STR*/$RPAREN);
      return new std.string(OS.str());
    } finally {
      if (OS != null) { OS.$destroy(); }
    }
  }

  
  // Return a string suitable for identifying this attribute in diagnostics.
  //<editor-fold defaultstate="collapsed" desc="clang::LoopHintAttr::getDiagnosticName">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/Attrs.inc", line = 3229,
   FQN="clang::LoopHintAttr::getDiagnosticName", NM="_ZNK5clang12LoopHintAttr17getDiagnosticNameERKNS_14PrintingPolicyE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZNK5clang12LoopHintAttr17getDiagnosticNameERKNS_14PrintingPolicyE")
  //</editor-fold>
  public std.string getDiagnosticName(final /*const*/ PrintingPolicy /*&*/ Policy) /*const*/ {
    /*uint*/int SpellingIndex = getSpellingListIndex();
    if (SpellingIndex == Spelling.Pragma_nounroll.getValue()) {
      return new std.string(/*KEEP_STR*/"#pragma nounroll");
    } else if (SpellingIndex == Spelling.Pragma_unroll.getValue()) {
      return $add_T$C$P_string(/*KEEP_STR*/"#pragma unroll", (option == OptionType.UnrollCount ? getValueString(Policy) : new std.string(/*KEEP_STR*/$EMPTY)));
    }
    assert (SpellingIndex == Spelling.Pragma_clang_loop.getValue()) : "Unexpected spelling";
    return $add_T$C$P_string(getOptionName(option.getValue()), getValueString(Policy));
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::LoopHintAttr::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/Attrs.inc", line = 3241,
   FQN="clang::LoopHintAttr::classof", NM="_ZN5clang12LoopHintAttr7classofEPKNS_4AttrE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZN5clang12LoopHintAttr7classofEPKNS_4AttrE")
  //</editor-fold>
  public static boolean classof(/*const*/ Attr /*P*/ A) {
    return A.getKind() == attr.Kind.LoopHint;
  }

  
  @Override public String toString() {
    return "" + "option=" + option // NOI18N
              + ", state=" + state // NOI18N
              + ", value=" + value // NOI18N
              + super.toString(); // NOI18N
  }
}
