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

//<editor-fold defaultstate="collapsed" desc="clang::TestTypestateAttr">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/Attrs.inc", line = 6550,
 FQN="clang::TestTypestateAttr", NM="_ZN5clang17TestTypestateAttrE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZN5clang17TestTypestateAttrE")
//</editor-fold>
public class TestTypestateAttr extends /*public*/ InheritableAttr {
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::TestTypestateAttr::ConsumedState">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/Attrs.inc", line = 6552,
   FQN="clang::TestTypestateAttr::ConsumedState", NM="_ZN5clang17TestTypestateAttr13ConsumedStateE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZN5clang17TestTypestateAttr13ConsumedStateE")
  //</editor-fold>
  public enum ConsumedState implements Native.ComparableLower {
    Consumed(0),
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
  private ConsumedState testState;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::TestTypestateAttr::CreateImplicit">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/Attrs.inc", line = 6560,
   FQN="clang::TestTypestateAttr::CreateImplicit", NM="_ZN5clang17TestTypestateAttr14CreateImplicitERNS_10ASTContextENS0_13ConsumedStateENS_11SourceRangeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZN5clang17TestTypestateAttr14CreateImplicitERNS_10ASTContextENS0_13ConsumedStateENS_11SourceRangeE")
  //</editor-fold>
  public static TestTypestateAttr /*P*/ CreateImplicit(final ASTContext /*&*/ Ctx, ConsumedState TestState) {
    return CreateImplicit(Ctx, TestState, new SourceRange());
  }
  public static TestTypestateAttr /*P*/ CreateImplicit(final ASTContext /*&*/ Ctx, ConsumedState TestState, SourceRange Loc/*= SourceRange()*/) {
    TestTypestateAttr /*P*/ A = /*FIXME:NEW_EXPR*//*new (Ctx)*/ new TestTypestateAttr(new SourceRange(Loc), Ctx, TestState, 0);
    A.setImplicit(true);
    return A;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::TestTypestateAttr::TestTypestateAttr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/Attrs.inc", line = 6566,
   FQN="clang::TestTypestateAttr::TestTypestateAttr", NM="_ZN5clang17TestTypestateAttrC1ENS_11SourceRangeERNS_10ASTContextENS0_13ConsumedStateEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZN5clang17TestTypestateAttrC1ENS_11SourceRangeERNS_10ASTContextENS0_13ConsumedStateEj")
  //</editor-fold>
  public TestTypestateAttr(SourceRange R, final ASTContext /*&*/ Ctx, 
      ConsumedState TestState, 
      /*uint*/int SI) {
    // : InheritableAttr(attr::TestTypestate, R, SI, false, false), testState(TestState) 
    //START JInit
    super(attr.Kind.TestTypestate, new SourceRange(R), SI, false, false);
    this.testState = TestState;
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::TestTypestateAttr::clone">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/AttrImpl.inc", line = 6189,
   FQN="clang::TestTypestateAttr::clone", NM="_ZNK5clang17TestTypestateAttr5cloneERNS_10ASTContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZNK5clang17TestTypestateAttr5cloneERNS_10ASTContextE")
  //</editor-fold>
  public TestTypestateAttr /*P*/ clone(final ASTContext /*&*/ C) /*const*/ {
    TestTypestateAttr /*P*/ A = /*FIXME:NEW_EXPR*//*new (C)*/ new TestTypestateAttr(new SourceRange(getLocation()), C, testState, getSpellingListIndex());
    A.Inherited = Inherited;
    A.IsPackExpansion = IsPackExpansion;
    A.Implicit = Implicit;
    return A;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TestTypestateAttr::printPretty">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/AttrImpl.inc", line = 6197,
   FQN="clang::TestTypestateAttr::printPretty", NM="_ZNK5clang17TestTypestateAttr11printPrettyERN4llvm11raw_ostreamERKNS_14PrintingPolicyE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZNK5clang17TestTypestateAttr11printPrettyERN4llvm11raw_ostreamERKNS_14PrintingPolicyE")
  //</editor-fold>
  public void printPretty(final raw_ostream /*&*/ OS, final /*const*/ PrintingPolicy /*&*/ Policy) /*const*/ {
    switch (SpellingListIndex) {
     default:
      throw new llvm_unreachable("Unknown attribute spelling!");
//      break;
     case 0:
      {
        OS.$out(/*KEEP_STR*/" __attribute__((test_typestate(\"").$out(TestTypestateAttr.ConvertConsumedStateToStr(getTestState())).$out(/*KEEP_STR*/"\")))");
        break;
      }
    }
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TestTypestateAttr::getSpelling">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/AttrImpl.inc", line = 6209,
   FQN="clang::TestTypestateAttr::getSpelling", NM="_ZNK5clang17TestTypestateAttr11getSpellingEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZNK5clang17TestTypestateAttr11getSpellingEv")
  //</editor-fold>
  public /*const*/char$ptr/*char P*/ getSpelling() /*const*/ {
    switch (SpellingListIndex) {
     default:
      throw new llvm_unreachable("Unknown attribute spelling!");
//      return $("(No spelling)");
     case 0:
      return $("test_typestate");
    }
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TestTypestateAttr::getTestState">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/Attrs.inc", line = 6579,
   FQN="clang::TestTypestateAttr::getTestState", NM="_ZNK5clang17TestTypestateAttr12getTestStateEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZNK5clang17TestTypestateAttr12getTestStateEv")
  //</editor-fold>
  public ConsumedState getTestState() /*const*/ {
    return testState;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::TestTypestateAttr::ConvertStrToConsumedState">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/Attrs.inc", line = 6583,
   FQN="clang::TestTypestateAttr::ConvertStrToConsumedState", NM="_ZN5clang17TestTypestateAttr25ConvertStrToConsumedStateEN4llvm9StringRefERNS0_13ConsumedStateE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZN5clang17TestTypestateAttr25ConvertStrToConsumedStateEN4llvm9StringRefERNS0_13ConsumedStateE")
  //</editor-fold>
  public static boolean ConvertStrToConsumedState(StringRef Val, final type$ref<ConsumedState /*&*/> Out) {
    Optional<ConsumedState> R = new StringSwitch<Optional<ConsumedState> >(/*NO_COPY*/Val).
        Case(/*KEEP_STR*/"consumed", new Optional<ConsumedState>(JD$T$RR.INSTANCE, TestTypestateAttr.ConsumedState.Consumed)).
        Case(/*KEEP_STR*/"unconsumed", new Optional<ConsumedState>(JD$T$RR.INSTANCE, TestTypestateAttr.ConsumedState.Unconsumed)).
        Default(new Optional<ConsumedState>());
    if (R.$bool()) {
      Out.$set(R.$star());
      return true;
    }
    return false;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::TestTypestateAttr::ConvertConsumedStateToStr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/Attrs.inc", line = 6595,
   FQN="clang::TestTypestateAttr::ConvertConsumedStateToStr", NM="_ZN5clang17TestTypestateAttr25ConvertConsumedStateToStrENS0_13ConsumedStateE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZN5clang17TestTypestateAttr25ConvertConsumedStateToStrENS0_13ConsumedStateE")
  //</editor-fold>
  public static /*const*/char$ptr/*char P*/ ConvertConsumedStateToStr(ConsumedState Val) {
    switch (Val) {
     case Consumed:
      return $("consumed");
     case Unconsumed:
      return $("unconsumed");
    }
    throw new llvm_unreachable("No enumerator with that value");
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::TestTypestateAttr::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/Attrs.inc", line = 6604,
   FQN="clang::TestTypestateAttr::classof", NM="_ZN5clang17TestTypestateAttr7classofEPKNS_4AttrE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZN5clang17TestTypestateAttr7classofEPKNS_4AttrE")
  //</editor-fold>
  public static boolean classof(/*const*/ Attr /*P*/ A) {
    return A.getKind() == attr.Kind.TestTypestate;
  }

  
  @Override public String toString() {
    return "" + "testState=" + testState // NOI18N
              + super.toString(); // NOI18N
  }
}
