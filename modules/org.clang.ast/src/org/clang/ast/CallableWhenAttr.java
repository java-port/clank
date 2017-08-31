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
import static org.clank.support.NativePointer.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.clang.basic.*;

//<editor-fold defaultstate="collapsed" desc="clang::CallableWhenAttr">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/Attrs.inc", line = 1578,
 FQN="clang::CallableWhenAttr", NM="_ZN5clang16CallableWhenAttrE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZN5clang16CallableWhenAttrE")
//</editor-fold>
public class CallableWhenAttr extends /*public*/ InheritableAttr {
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::CallableWhenAttr::ConsumedState">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/Attrs.inc", line = 1580,
   FQN="clang::CallableWhenAttr::ConsumedState", NM="_ZN5clang16CallableWhenAttr13ConsumedStateE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZN5clang16CallableWhenAttr13ConsumedStateE")
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
  private /*uint*/int callableStates_Size;
  private type$ptr<ConsumedState/*P*/> callableStates_;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::CallableWhenAttr::CreateImplicit">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/Attrs.inc", line = 1590,
   FQN="clang::CallableWhenAttr::CreateImplicit", NM="_ZN5clang16CallableWhenAttr14CreateImplicitERNS_10ASTContextEPNS0_13ConsumedStateEjNS_11SourceRangeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZN5clang16CallableWhenAttr14CreateImplicitERNS_10ASTContextEPNS0_13ConsumedStateEjNS_11SourceRangeE")
  //</editor-fold>
  public static CallableWhenAttr /*P*/ CreateImplicit(final ASTContext /*&*/ Ctx, type$ptr<ConsumedState/*P*/> CallableStates, /*uint*/int CallableStatesSize) {
    return CreateImplicit(Ctx, CallableStates, CallableStatesSize, new SourceRange());
  }
  public static CallableWhenAttr /*P*/ CreateImplicit(final ASTContext /*&*/ Ctx, type$ptr<ConsumedState/*P*/> CallableStates, /*uint*/int CallableStatesSize, SourceRange Loc/*= SourceRange()*/) {
    CallableWhenAttr /*P*/ A = /*FIXME:NEW_EXPR*//*new (Ctx)*/ new CallableWhenAttr(new SourceRange(Loc), Ctx, CallableStates, CallableStatesSize, 0);
    A.setImplicit(true);
    return A;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CallableWhenAttr::CallableWhenAttr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/Attrs.inc", line = 1596,
   FQN="clang::CallableWhenAttr::CallableWhenAttr", NM="_ZN5clang16CallableWhenAttrC1ENS_11SourceRangeERNS_10ASTContextEPNS0_13ConsumedStateEjj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZN5clang16CallableWhenAttrC1ENS_11SourceRangeERNS_10ASTContextEPNS0_13ConsumedStateEjj")
  //</editor-fold>
  public CallableWhenAttr(SourceRange R, final ASTContext /*&*/ Ctx, 
      type$ptr<ConsumedState/*P*/> CallableStates, /*uint*/int CallableStatesSize, 
      /*uint*/int SI) {
    // : InheritableAttr(attr::CallableWhen, R, SI, false, false), callableStates_Size(CallableStatesSize), callableStates_(new (Ctx, 16) new ConsumedState [callableStates_Size]) 
    //START JInit
    super(attr.Kind.CallableWhen, new SourceRange(R), SI, false, false);
    this.callableStates_Size = CallableStatesSize;
    this.callableStates_ = create_type$ptr(/*FIXME:NEW_EXPR*//*new (Ctx, 16)*/ new ConsumedState [callableStates_Size]);
    //END JInit
    std.copy(CallableStates, CallableStates.$add(callableStates_Size), callableStates_);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CallableWhenAttr::CallableWhenAttr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/Attrs.inc", line = 1606,
   FQN="clang::CallableWhenAttr::CallableWhenAttr", NM="_ZN5clang16CallableWhenAttrC1ENS_11SourceRangeERNS_10ASTContextEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZN5clang16CallableWhenAttrC1ENS_11SourceRangeERNS_10ASTContextEj")
  //</editor-fold>
  public CallableWhenAttr(SourceRange R, final ASTContext /*&*/ Ctx, 
      /*uint*/int SI) {
    // : InheritableAttr(attr::CallableWhen, R, SI, false, false), callableStates_Size(0), callableStates_(null) 
    //START JInit
    super(attr.Kind.CallableWhen, new SourceRange(R), SI, false, false);
    this.callableStates_Size = 0;
    this.callableStates_ = null;
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CallableWhenAttr::clone">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/AttrImpl.inc", line = 1399,
   FQN="clang::CallableWhenAttr::clone", NM="_ZNK5clang16CallableWhenAttr5cloneERNS_10ASTContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZNK5clang16CallableWhenAttr5cloneERNS_10ASTContextE")
  //</editor-fold>
  public CallableWhenAttr /*P*/ clone(final ASTContext /*&*/ C) /*const*/ {
    CallableWhenAttr /*P*/ A = /*FIXME:NEW_EXPR*//*new (C)*/ new CallableWhenAttr(new SourceRange(getLocation()), C, callableStates_, callableStates_Size, getSpellingListIndex());
    A.Inherited = Inherited;
    A.IsPackExpansion = IsPackExpansion;
    A.Implicit = Implicit;
    return A;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CallableWhenAttr::printPretty">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/AttrImpl.inc", line = 1407,
   FQN="clang::CallableWhenAttr::printPretty", NM="_ZNK5clang16CallableWhenAttr11printPrettyERN4llvm11raw_ostreamERKNS_14PrintingPolicyE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZNK5clang16CallableWhenAttr11printPrettyERN4llvm11raw_ostreamERKNS_14PrintingPolicyE")
  //</editor-fold>
  public void printPretty(final raw_ostream /*&*/ OS, final /*const*/ PrintingPolicy /*&*/ Policy) /*const*/ {
    switch (SpellingListIndex) {
     default:
      throw new llvm_unreachable("Unknown attribute spelling!");
//      break;
     case 0:
      {
        OS.$out(/*KEEP_STR*/" __attribute__((callable_when(");
        boolean isFirst = true;
        for (final /*const*/ ConsumedState /*&*/ Val : callableStates()) {
          if (isFirst) {
            isFirst = false;
          } else {
            OS.$out(/*KEEP_STR*/$COMMA_SPACE);
          }
          OS.$out(/*KEEP_STR*/$DBL_QUOTE).$out(CallableWhenAttr.ConvertConsumedStateToStr(Val)).$out(/*KEEP_STR*/$DBL_QUOTE);
        }
        OS.$out(/*KEEP_STR*/")))");
        break;
      }
    }
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CallableWhenAttr::getSpelling">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/AttrImpl.inc", line = 1426,
   FQN="clang::CallableWhenAttr::getSpelling", NM="_ZNK5clang16CallableWhenAttr11getSpellingEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZNK5clang16CallableWhenAttr11getSpellingEv")
  //</editor-fold>
  public /*const*/char$ptr/*char P*/ getSpelling() /*const*/ {
    switch (SpellingListIndex) {
     default:
      throw new llvm_unreachable("Unknown attribute spelling!");
//      return $("(No spelling)");
     case 0:
      return $("callable_when");
    }
  }

  /*typedef ConsumedState *callableStates_iterator*/
//  public final class callableStates_iterator extends type$ptr<ConsumedState/*P*/> { };
  //<editor-fold defaultstate="collapsed" desc="clang::CallableWhenAttr::callableStates_begin">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/Attrs.inc", line = 1619,
   FQN="clang::CallableWhenAttr::callableStates_begin", NM="_ZNK5clang16CallableWhenAttr20callableStates_beginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZNK5clang16CallableWhenAttr20callableStates_beginEv")
  //</editor-fold>
  public type$ptr<ConsumedState>/*callableStates_iterator*/ callableStates_begin() /*const*/ {
    return callableStates_;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CallableWhenAttr::callableStates_end">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/Attrs.inc", line = 1620,
   FQN="clang::CallableWhenAttr::callableStates_end", NM="_ZNK5clang16CallableWhenAttr18callableStates_endEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZNK5clang16CallableWhenAttr18callableStates_endEv")
  //</editor-fold>
  public type$ptr<ConsumedState>/*callableStates_iterator*/ callableStates_end() /*const*/ {
    return callableStates_.$add(callableStates_Size);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CallableWhenAttr::callableStates_size">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/Attrs.inc", line = 1621,
   FQN="clang::CallableWhenAttr::callableStates_size", NM="_ZNK5clang16CallableWhenAttr19callableStates_sizeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZNK5clang16CallableWhenAttr19callableStates_sizeEv")
  //</editor-fold>
  public /*uint*/int callableStates_size() /*const*/ {
    return callableStates_Size;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CallableWhenAttr::callableStates">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/Attrs.inc", line = 1622,
   FQN="clang::CallableWhenAttr::callableStates", NM="_ZNK5clang16CallableWhenAttr14callableStatesEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZNK5clang16CallableWhenAttr14callableStatesEv")
  //</editor-fold>
  public iterator_range<ConsumedState/*callableStates_iterator*/> callableStates() /*const*/ {
    return llvm.make_range(callableStates_begin(), callableStates_end());
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CallableWhenAttr::ConvertStrToConsumedState">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/Attrs.inc", line = 1625,
   FQN="clang::CallableWhenAttr::ConvertStrToConsumedState", NM="_ZN5clang16CallableWhenAttr25ConvertStrToConsumedStateEN4llvm9StringRefERNS0_13ConsumedStateE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZN5clang16CallableWhenAttr25ConvertStrToConsumedStateEN4llvm9StringRefERNS0_13ConsumedStateE")
  //</editor-fold>
  public static boolean ConvertStrToConsumedState(StringRef Val, final type$ref<ConsumedState /*&*/> Out) {
    Optional<ConsumedState> R = new StringSwitch<Optional<ConsumedState> >(/*NO_COPY*/Val).
        Case(/*KEEP_STR*/"unknown", new Optional<ConsumedState>(JD$T$RR.INSTANCE, CallableWhenAttr.ConsumedState.Unknown)).
        Case(/*KEEP_STR*/"consumed", new Optional<ConsumedState>(JD$T$RR.INSTANCE, CallableWhenAttr.ConsumedState.Consumed)).
        Case(/*KEEP_STR*/"unconsumed", new Optional<ConsumedState>(JD$T$RR.INSTANCE, CallableWhenAttr.ConsumedState.Unconsumed)).
        Default(new Optional<ConsumedState>());
    if (R.$bool()) {
      Out.$set(R.$star());
      return true;
    }
    return false;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CallableWhenAttr::ConvertConsumedStateToStr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/Attrs.inc", line = 1638,
   FQN="clang::CallableWhenAttr::ConvertConsumedStateToStr", NM="_ZN5clang16CallableWhenAttr25ConvertConsumedStateToStrENS0_13ConsumedStateE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZN5clang16CallableWhenAttr25ConvertConsumedStateToStrENS0_13ConsumedStateE")
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

  
  //<editor-fold defaultstate="collapsed" desc="clang::CallableWhenAttr::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/Attrs.inc", line = 1648,
   FQN="clang::CallableWhenAttr::classof", NM="_ZN5clang16CallableWhenAttr7classofEPKNS_4AttrE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZN5clang16CallableWhenAttr7classofEPKNS_4AttrE")
  //</editor-fold>
  public static boolean classof(/*const*/ Attr /*P*/ A) {
    return A.getKind() == attr.Kind.CallableWhen;
  }

  
  @Override public String toString() {
    return "" + "callableStates_Size=" + callableStates_Size // NOI18N
              + ", callableStates_=" + callableStates_ // NOI18N
              + super.toString(); // NOI18N
  }
}
