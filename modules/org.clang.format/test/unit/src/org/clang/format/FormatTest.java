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

package org.clang.format;

import java.lang.reflect.Field;
import org.junit.Test;
import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import org.clank.support.JavaDifferentiators.*;
import static org.llvm.support.llvm.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.tooling.core.*;
import org.clang.basic.*;
import org.clang.basic.vfs.*;
import static org.clang.format.FormatGlobals.*;
import static org.clang.tooling.ToolingGlobals.*;
import org.clang.format.FormatTestUtils.test;


//<editor-fold defaultstate="collapsed" desc="static type FormatTest">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 NM="FormatTest",
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -print -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp -test=FormatTest")
//</editor-fold>
public final class FormatTest extends ADTSupportTestBase {
  
  //<editor-fold defaultstate="collapsed" desc="clang::format::(anonymous namespace)::FormatTest::FormatTest">
  @Converted(kind = Converted.Kind.MANUAL,
   source = "${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp", line = 28,
   FQN="clang::format::(anonymous namespace)::FormatTest::FormatTest", NM="_ZN5clang6format12_GLOBAL__N_110FormatTestC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp -nm=_ZN5clang6format12_GLOBAL__N_110FormatTestC1Ev")
  //</editor-fold>
  public /*inline*/ FormatTest() {
    // : Test() 
    //START JInit
    super(TestState.Successful);
    //END JInit
  }
  

//JAVA: namespace clang {
//JAVA: namespace format {
//JAVA: namespace (anonymous) {

//<editor-fold defaultstate="collapsed" desc="clang::format::(anonymous namespace)::getGoogleStyle">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION, source = "${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp", line = 26, FQN = "clang::format::(anonymous namespace)::getGoogleStyle", NM = "_ZN5clang6format12_GLOBAL__N_114getGoogleStyleEv", cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp -nm=_ZN5clang6format12_GLOBAL__N_114getGoogleStyleEv")
  public static FormatStyle getGoogleStyle() {
    return FormatGlobals.getGoogleStyle(FormatStyle.LanguageKind.LK_Cpp);
  }


////<editor-fold defaultstate="collapsed" desc="clang::format::(anonymous namespace)::FormatTest">
//@Converted(kind = Converted.Kind.AUTO,
// source = "${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp", line = 28,
// FQN="clang::format::(anonymous namespace)::FormatTest", NM="_ZN5clang6format12_GLOBAL__N_110FormatTestE",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp -nm=_ZN5clang6format12_GLOBAL__N_110FormatTestE")
////</editor-fold>
//public abstract static class FormatTest extends /*public*/ Test implements Destructors.ClassWithDestructor {
/*protected:*/
  //<editor-fold defaultstate="collapsed" desc="clang::format::(anonymous namespace)::FormatTest::IncompleteCheck">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp", line = 30,
   FQN="clang::format::(anonymous namespace)::FormatTest::IncompleteCheck", NM="_ZN5clang6format12_GLOBAL__N_110FormatTest15IncompleteCheckE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp -nm=_ZN5clang6format12_GLOBAL__N_110FormatTest15IncompleteCheckE")
  //</editor-fold>
  protected enum IncompleteCheck implements Native.NativeUIntEnum {
    IC_ExpectComplete(0),
    IC_ExpectIncomplete(IC_ExpectComplete.getValue() + 1),
    IC_DoNotCheck(IC_ExpectIncomplete.getValue() + 1);

    //<editor-fold defaultstate="collapsed" desc="hidden">
    public static IncompleteCheck valueOf(int val) {
      IncompleteCheck out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
      assert out != null : "no value for " + val;
      assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
      return out;
    }

    private static final class Values {
      private static final IncompleteCheck[] VALUES;
      private static final IncompleteCheck[] _VALUES; // [0] not used
      static {
        int max = 0;
        int min = 0;
        for (IncompleteCheck kind : IncompleteCheck.values()) {
          if (kind.value > max) { max = kind.value; }
          if (kind.value < min) { min = kind.value; }
        }
        _VALUES = new IncompleteCheck[min < 0 ? (1-min) : 0];
        VALUES = new IncompleteCheck[max >= 0 ? (1+max) : 0];
        for (IncompleteCheck kind : IncompleteCheck.values()) {
          if (kind.value < 0) {
            if (_VALUES[-kind.value] == null) {
              _VALUES[-kind.value] = kind;
            } else {
              assert true: "Must not replace " + _VALUES[-kind.value] + " by " + kind + ". Switch to int-based enum or filter valid.";
            }
          } else {
            if (VALUES[kind.value] == null) {
              VALUES[kind.value] = kind;
            } else {
              assert true: "Must not replace " + VALUES[kind.value] + " by " + kind + ". Switch to int-based enum or filter valid.";
            }
          }
        }
      }
    }

    private final /*uint*/int value;
    private IncompleteCheck(int val) { this.value = (/*uint*/int)val;}
    @Override public final /*uint*/int getValue() { return value;}
    //</editor-fold>
  };
  
  //<editor-fold defaultstate="collapsed" desc="clang::format::(anonymous namespace)::FormatTest::format">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp", line = 36,
   FQN="clang::format::(anonymous namespace)::FormatTest::format", NM="_ZN5clang6format12_GLOBAL__N_110FormatTest6formatEN4llvm9StringRefERKNS0_11FormatStyleENS2_15IncompleteCheckE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp -nm=_ZN5clang6format12_GLOBAL__N_110FormatTest6formatEN4llvm9StringRefERKNS0_11FormatStyleENS2_15IncompleteCheckE")
  //</editor-fold>
  protected std.string format(StringRef Code) {
    return format(Code, 
        getLLVMStyle(), 
        IncompleteCheck.IC_ExpectComplete);
  }
  protected std.string format(StringRef Code, 
        final /*const*/ FormatStyle /*&*/ Style/*= $c$.track(getLLVMStyle())*/) {
    return format(Code, 
        Style, 
        IncompleteCheck.IC_ExpectComplete);
  }
  protected std.string format(StringRef Code, 
        final /*const*/ FormatStyle /*&*/ Style/*= $c$.track(getLLVMStyle())*/, 
        IncompleteCheck CheckIncomplete/*= IC_ExpectComplete*/) {
    std.vector<Range> Ranges = null;
    std.setType<Replacement> Replaces = null;
    Expected<std.string> Result = null;
    try {
      do {
        if (/*::*/llvm.DebugFlag && /*::*/llvm.isCurrentDebugType(/*KEEP_STR*/"format-test")) {
          llvm.errs().$out(/*KEEP_STR*/"---\n");
        }
      } while (false);
      do {
        if (/*::*/llvm.DebugFlag && /*::*/llvm.isCurrentDebugType(/*KEEP_STR*/"format-test")) {
          llvm.errs().$out(/*NO_COPY*/Code).$out(/*KEEP_STR*/"\n\n");
        }
      } while (false);
      Ranges/*J*/= new std.vector<Range>(1, new Range(0, Code.size()), new Range());
      bool$ptr IncompleteFormat = create_bool$ptr(false);
      Replaces = reformat(Style, new StringRef(Code), new ArrayRef<Range>(Ranges, false), new StringRef(/*KEEP_STR*/"<stdin>"), /*AddrOf*/IncompleteFormat);
      if (CheckIncomplete != IncompleteCheck.IC_DoNotCheck) {
        boolean ExpectedIncompleteFormat = CheckIncomplete == IncompleteCheck.IC_ExpectIncomplete;
      EXPECT_EQ(ExpectedIncompleteFormat,IncompleteFormat.$star());
      }
      ReplacementCount = Replaces.size();
      Result = applyAllReplacements(new StringRef(Code), Replaces);
      EXPECT_TRUE(((/*static_cast*/boolean)(Result.$bool())));
      do {
        if (/*::*/llvm.DebugFlag && /*::*/llvm.isCurrentDebugType(/*KEEP_STR*/"format-test")) {
          llvm.errs().$out(/*KEEP_STR*/$LF).$out(Result.$star()).$out(/*KEEP_STR*/"\n\n");
        }
      } while (false);
      return new std.string(Result.$star());
    } finally {
      if (Result != null) { Result.$destroy(); }
      if (Replaces != null) { Replaces.$destroy(); }
      if (Ranges != null) { Ranges.$destroy(); }
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::format::(anonymous namespace)::FormatTest::getLLVMStyleWithColumns">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp", line = 56,
   FQN="clang::format::(anonymous namespace)::FormatTest::getLLVMStyleWithColumns", NM="_ZN5clang6format12_GLOBAL__N_110FormatTest23getLLVMStyleWithColumnsEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp -nm=_ZN5clang6format12_GLOBAL__N_110FormatTest23getLLVMStyleWithColumnsEj")
  //</editor-fold>
  protected FormatStyle getLLVMStyleWithColumns(/*uint*/int ColumnLimit) {
    FormatStyle Style = null;
    try {
      Style = getLLVMStyle();
      Style.ColumnLimit = ColumnLimit;
      return new FormatStyle(JD$Move.INSTANCE, Style);
    } finally {
      if (Style != null) { Style.$destroy(); }
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::format::(anonymous namespace)::FormatTest::getGoogleStyleWithColumns">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp", line = 62,
   FQN="clang::format::(anonymous namespace)::FormatTest::getGoogleStyleWithColumns", NM="_ZN5clang6format12_GLOBAL__N_110FormatTest25getGoogleStyleWithColumnsEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp -nm=_ZN5clang6format12_GLOBAL__N_110FormatTest25getGoogleStyleWithColumnsEj")
  //</editor-fold>
  protected FormatStyle getGoogleStyleWithColumns(/*uint*/int ColumnLimit) {
    FormatStyle Style = null;
    try {
      Style = getGoogleStyle();
      Style.ColumnLimit = ColumnLimit;
      return new FormatStyle(JD$Move.INSTANCE, Style);
    } finally {
      if (Style != null) { Style.$destroy(); }
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::format::(anonymous namespace)::FormatTest::verifyFormat">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp", line = 68,
   FQN="clang::format::(anonymous namespace)::FormatTest::verifyFormat", NM="_ZN5clang6format12_GLOBAL__N_110FormatTest12verifyFormatEN4llvm9StringRefERKNS0_11FormatStyleE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp -nm=_ZN5clang6format12_GLOBAL__N_110FormatTest12verifyFormatEN4llvm9StringRefERKNS0_11FormatStyleE")
  //</editor-fold>
  protected void verifyFormat(StringRef Code) {
    verifyFormat(Code, 
              getLLVMStyle());
  }
  protected void verifyFormat(StringRef Code, 
              final /*const*/ FormatStyle /*&*/ Style/*= $c$.track(getLLVMStyle())*/) {
      EXPECT_EQ(Code.str(),format(new StringRef(test.messUp(new StringRef(Code))), Style));
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::format::(anonymous namespace)::FormatTest::verifyIncompleteFormat">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp", line = 73,
   FQN="clang::format::(anonymous namespace)::FormatTest::verifyIncompleteFormat", NM="_ZN5clang6format12_GLOBAL__N_110FormatTest22verifyIncompleteFormatEN4llvm9StringRefERKNS0_11FormatStyleE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp -nm=_ZN5clang6format12_GLOBAL__N_110FormatTest22verifyIncompleteFormatEN4llvm9StringRefERKNS0_11FormatStyleE")
  //</editor-fold>
  protected void verifyIncompleteFormat(StringRef Code) {
    verifyIncompleteFormat(Code, 
                        getLLVMStyle());
  }
  protected void verifyIncompleteFormat(StringRef Code, 
                        final /*const*/ FormatStyle /*&*/ Style/*= $c$.track(getLLVMStyle())*/) {
      EXPECT_EQ(Code.str(),format(new StringRef(test.messUp(new StringRef(Code))), Style, IncompleteCheck.IC_ExpectIncomplete));
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::format::(anonymous namespace)::FormatTest::verifyGoogleFormat">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp", line = 79,
   FQN="clang::format::(anonymous namespace)::FormatTest::verifyGoogleFormat", NM="_ZN5clang6format12_GLOBAL__N_110FormatTest18verifyGoogleFormatEN4llvm9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp -nm=_ZN5clang6format12_GLOBAL__N_110FormatTest18verifyGoogleFormatEN4llvm9StringRefE")
  //</editor-fold>
  protected void verifyGoogleFormat(StringRef Code) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      verifyFormat(new StringRef(Code), $c$.track(getGoogleStyle())); $c$.clean();
    } finally {
      $c$.$destroy();
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::format::(anonymous namespace)::FormatTest::verifyIndependentOfContext">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp", line = 83,
   FQN="clang::format::(anonymous namespace)::FormatTest::verifyIndependentOfContext", NM="_ZN5clang6format12_GLOBAL__N_110FormatTest26verifyIndependentOfContextEN4llvm9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp -nm=_ZN5clang6format12_GLOBAL__N_110FormatTest26verifyIndependentOfContextEN4llvm9StringRefE")
  //</editor-fold>
  protected void verifyIndependentOfContext(StringRef text) {
    verifyFormat(new StringRef(text));
    verifyFormat(new StringRef($add_Twine$C($add_char$ptr$C_StringRef$C(/*KEEP_STR*/"void f() { ", text), new Twine(/*KEEP_STR*/" }")).str()));
  }

  
  /// \brief Verify that clang-format does not crash on the given input.
  //<editor-fold defaultstate="collapsed" desc="clang::format::(anonymous namespace)::FormatTest::verifyNoCrash">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp", line = 89,
   FQN="clang::format::(anonymous namespace)::FormatTest::verifyNoCrash", NM="_ZN5clang6format12_GLOBAL__N_110FormatTest13verifyNoCrashEN4llvm9StringRefERKNS0_11FormatStyleE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp -nm=_ZN5clang6format12_GLOBAL__N_110FormatTest13verifyNoCrashEN4llvm9StringRefERKNS0_11FormatStyleE")
  //</editor-fold>
  protected void verifyNoCrash(StringRef Code) {
    verifyNoCrash(Code, 
               getLLVMStyle());
  }
  protected void verifyNoCrash(StringRef Code, 
               final /*const*/ FormatStyle /*&*/ Style/*= $c$.track(getLLVMStyle())*/) {
    format(new StringRef(Code), Style, IncompleteCheck.IC_DoNotCheck);
  }

  
  protected int ReplacementCount;
  //<editor-fold defaultstate="collapsed" desc="clang::format::(anonymous namespace)::FormatTest::~FormatTest">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp", line = 28,
   FQN="clang::format::(anonymous namespace)::FormatTest::~FormatTest", NM="_ZN5clang6format12_GLOBAL__N_110FormatTestD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp -nm=_ZN5clang6format12_GLOBAL__N_110FormatTestD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    super.$destroy();
  }

  @Override public String toString() {
    return "" + "ReplacementCount=" + ReplacementCount // NOI18N
              + super.toString(); // NOI18N
  }
//}
;
@Test
//<editor-fold defaultstate="collapsed" desc="clang::format::(anonymous namespace)::FormatTest_MessUp_Test::TestBody">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp", line = 97,
 FQN="clang::format::(anonymous namespace)::FormatTest_MessUp_Test::TestBody", NM="_ZN5clang6format12_GLOBAL__N_122FormatTest_MessUp_Test8TestBodyEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp -nm=_ZN5clang6format12_GLOBAL__N_122FormatTest_MessUp_Test8TestBodyEv")
//</editor-fold>
public void test_MessUp() {
    if (markAsSkippedIfNeed(TestState.Successful)) { return; }
    EXPECT_EQ("1 2 3",test.messUp(new StringRef(/*KEEP_STR*/"1 2 3")));
    EXPECT_EQ("1 2 3\n",test.messUp(new StringRef(/*KEEP_STR*/"1\n2\n3\n")));
    EXPECT_EQ("a\n//b\nc",test.messUp(new StringRef(/*KEEP_STR*/"a\n//b\nc")));
    EXPECT_EQ("a\n#b\nc",test.messUp(new StringRef(/*KEEP_STR*/"a\n#b\nc")));
    EXPECT_EQ("a\n#b c d\ne",test.messUp(new StringRef(/*KEEP_STR*/"a\n#b\\\nc\\\nd\ne")));
}


//===----------------------------------------------------------------------===//
// Basic function tests.
//===----------------------------------------------------------------------===//
;
@Test
//<editor-fold defaultstate="collapsed" desc="clang::format::(anonymous namespace)::FormatTest_DoesNotChangeCorrectlyFormattedCode_Test::TestBody">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp", line = 109,
 FQN="clang::format::(anonymous namespace)::FormatTest_DoesNotChangeCorrectlyFormattedCode_Test::TestBody", NM="_ZN5clang6format12_GLOBAL__N_151FormatTest_DoesNotChangeCorrectlyFormattedCode_Test8TestBodyEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp -nm=_ZN5clang6format12_GLOBAL__N_151FormatTest_DoesNotChangeCorrectlyFormattedCode_Test8TestBodyEv")
//</editor-fold>
public void test_DoesNotChangeCorrectlyFormattedCode() {
    if (markAsSkippedIfNeed(TestState.Successful)) { return; }
    EXPECT_EQ(";",format(new StringRef(/*KEEP_STR*/";")));
}

;
@Test
//<editor-fold defaultstate="collapsed" desc="clang::format::(anonymous namespace)::FormatTest_FormatsGlobalStatementsAt0_Test::TestBody">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp", line = 113,
 FQN="clang::format::(anonymous namespace)::FormatTest_FormatsGlobalStatementsAt0_Test::TestBody", NM="_ZN5clang6format12_GLOBAL__N_142FormatTest_FormatsGlobalStatementsAt0_Test8TestBodyEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp -nm=_ZN5clang6format12_GLOBAL__N_142FormatTest_FormatsGlobalStatementsAt0_Test8TestBodyEv")
//</editor-fold>
public void test_FormatsGlobalStatementsAt0() {
    if (markAsSkippedIfNeed(TestState.Successful)) { return; }
    EXPECT_EQ("int i;",format(new StringRef(/*KEEP_STR*/"  int i;")));
    EXPECT_EQ("\nint i;",format(new StringRef(/*KEEP_STR*/" \n\t \013 \014  int i;")));
    EXPECT_EQ("int i;\nint j;",format(new StringRef(/*KEEP_STR*/"    int i; int j;")));
    EXPECT_EQ("int i;\nint j;",format(new StringRef(/*KEEP_STR*/"    int i;\n  int j;")));
}

;
@Test
//<editor-fold defaultstate="collapsed" desc="clang::format::(anonymous namespace)::FormatTest_FormatsUnwrappedLinesAtFirstFormat_Test::TestBody">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp", line = 120,
 FQN="clang::format::(anonymous namespace)::FormatTest_FormatsUnwrappedLinesAtFirstFormat_Test::TestBody", NM="_ZN5clang6format12_GLOBAL__N_150FormatTest_FormatsUnwrappedLinesAtFirstFormat_Test8TestBodyEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp -nm=_ZN5clang6format12_GLOBAL__N_150FormatTest_FormatsUnwrappedLinesAtFirstFormat_Test8TestBodyEv")
//</editor-fold>
public void test_FormatsUnwrappedLinesAtFirstFormat() {
    if (markAsSkippedIfNeed(TestState.Successful)) { return; }
    EXPECT_EQ("int i;",format(new StringRef(/*KEEP_STR*/"int\ni;")));
}

;
@Test
//<editor-fold defaultstate="collapsed" desc="clang::format::(anonymous namespace)::FormatTest_FormatsNestedBlockStatements_Test::TestBody">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp", line = 124,
 FQN="clang::format::(anonymous namespace)::FormatTest_FormatsNestedBlockStatements_Test::TestBody", NM="_ZN5clang6format12_GLOBAL__N_144FormatTest_FormatsNestedBlockStatements_Test8TestBodyEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp -nm=_ZN5clang6format12_GLOBAL__N_144FormatTest_FormatsNestedBlockStatements_Test8TestBodyEv")
//</editor-fold>
public void test_FormatsNestedBlockStatements() {
    if (markAsSkippedIfNeed(TestState.Successful)) { return; }
    EXPECT_EQ("{\n  {\n    {}\n  }\n}",format(new StringRef(/*KEEP_STR*/"{{{}}}")));
}

;
@Test
//<editor-fold defaultstate="collapsed" desc="clang::format::(anonymous namespace)::FormatTest_FormatsNestedCall_Test::TestBody">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp", line = 128,
 FQN="clang::format::(anonymous namespace)::FormatTest_FormatsNestedCall_Test::TestBody", NM="_ZN5clang6format12_GLOBAL__N_133FormatTest_FormatsNestedCall_Test8TestBodyEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp -nm=_ZN5clang6format12_GLOBAL__N_133FormatTest_FormatsNestedCall_Test8TestBodyEv")
//</editor-fold>
public void test_FormatsNestedCall() {
  if (markAsSkippedIfNeed(TestState.Successful)) { return; }
  verifyFormat(new StringRef(/*KEEP_STR*/"Method(f1, f2(f3));"));
  verifyFormat(new StringRef(/*KEEP_STR*/"Method(f1(f2, f3()));"));
  verifyFormat(new StringRef(/*KEEP_STR*/"Method(f1(f2, (f3())));"));
}

;
@Test
//<editor-fold defaultstate="collapsed" desc="clang::format::(anonymous namespace)::FormatTest_NestedNameSpecifiers_Test::TestBody">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp", line = 134,
 FQN="clang::format::(anonymous namespace)::FormatTest_NestedNameSpecifiers_Test::TestBody", NM="_ZN5clang6format12_GLOBAL__N_136FormatTest_NestedNameSpecifiers_Test8TestBodyEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp -nm=_ZN5clang6format12_GLOBAL__N_136FormatTest_NestedNameSpecifiers_Test8TestBodyEv")
//</editor-fold>
public void test_NestedNameSpecifiers() {
  if (markAsSkippedIfNeed(TestState.Successful)) { return; }
  verifyFormat(new StringRef(/*KEEP_STR*/"vector<::Type> v;"));
  verifyFormat(new StringRef(/*KEEP_STR*/"::ns::SomeFunction(::ns::SomeOtherFunction())"));
  verifyFormat(new StringRef(/*KEEP_STR*/"static constexpr bool Bar = decltype(bar())::value;"));
  verifyFormat(new StringRef(/*KEEP_STR*/"bool a = 2 < ::SomeFunction();"));
}

;
@Test
//<editor-fold defaultstate="collapsed" desc="clang::format::(anonymous namespace)::FormatTest_OnlyGeneratesNecessaryReplacements_Test::TestBody">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp", line = 141,
 FQN="clang::format::(anonymous namespace)::FormatTest_OnlyGeneratesNecessaryReplacements_Test::TestBody", NM="_ZN5clang6format12_GLOBAL__N_150FormatTest_OnlyGeneratesNecessaryReplacements_Test8TestBodyEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp -nm=_ZN5clang6format12_GLOBAL__N_150FormatTest_OnlyGeneratesNecessaryReplacements_Test8TestBodyEv")
//</editor-fold>
public void test_OnlyGeneratesNecessaryReplacements() {
    if (markAsSkippedIfNeed(TestState.Successful)) { return; }
    EXPECT_EQ("if (a) {\n  f();\n}",format(new StringRef(/*KEEP_STR*/"if(a){f();}")));
    EXPECT_EQ(4,ReplacementCount);
    EXPECT_EQ("if (a) {\n  f();\n}",format(new StringRef(/*KEEP_STR*/"if (a) {\n  f();\n}")));
    EXPECT_EQ(0,ReplacementCount);
    //EXPECT_EQ("/*\015\n\015\n*/\015\n",format(new StringRef(/*KEEP_STR*/"/*\015\n\015\n*/\015\n")));
    //EXPECT_EQ(0,ReplacementCount);
}
@Test
public void test_OnlyGeneratesNecessaryReplacements_failed() {
    if (markAsSkippedIfNeed(TestState.Failed)) { return; }
    EXPECT_EQ("/*\015\n\015\n*/\015\n",format(new StringRef(/*KEEP_STR*/"/*\015\n\015\n*/\015\n")));
    EXPECT_EQ(0,ReplacementCount);
}

;
@Test
//<editor-fold defaultstate="collapsed" desc="clang::format::(anonymous namespace)::FormatTest_RemovesEmptyLines_Test::TestBody">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp", line = 163,
 FQN="clang::format::(anonymous namespace)::FormatTest_RemovesEmptyLines_Test::TestBody", NM="_ZN5clang6format12_GLOBAL__N_133FormatTest_RemovesEmptyLines_Test8TestBodyEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp -nm=_ZN5clang6format12_GLOBAL__N_133FormatTest_RemovesEmptyLines_Test8TestBodyEv")
//</editor-fold>
public void test_RemovesEmptyLines() {
  if (markAsSkippedIfNeed(TestState.Successful)) { return; }
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    EXPECT_EQ("class C {\n  int i;\n};",format(new StringRef(/*KEEP_STR*/"class C {\n int i;\n\n};")));
    
    // Don't remove empty lines at the start of namespaces or extern "C" blocks.
    EXPECT_EQ("namespace N {\n\nint i;\n}",$c$.clean(format(new StringRef(/*KEEP_STR*/"namespace N {\n\nint    i;\n}"), $c$.track(getGoogleStyle()))));
    EXPECT_EQ("extern /**/ \"C\" /**/ {\n\nint i;\n}",$c$.clean(format(new StringRef(/*KEEP_STR*/"extern /**/ \"C\" /**/ {\n\nint    i;\n}"), $c$.track(getGoogleStyle()))));
    
    // ...but do keep inlining and removing empty lines for non-block extern "C"
    // functions.
    verifyFormat(new StringRef(/*KEEP_STR*/"extern \"C\" int f() { return 42; }"), $c$.track(getGoogleStyle())); $c$.clean();
    EXPECT_EQ("extern \"C\" int f() {\n  int i = 42;\n  return i;\n}",$c$.clean(format(new StringRef(/*KEEP_STR*/"extern \"C\" int f() {\n\n  int i = 42;\n  return i;\n}"), $c$.track(getGoogleStyle()))));
    
    // Remove empty lines at the beginning and end of blocks.
    EXPECT_EQ("void f() {\n\n  if (a) {\n\n    f();\n  }\n}",$c$.clean(format(new StringRef(/*KEEP_STR*/"void f() {\n\n  if (a) {\n\n    f();\n\n  }\n\n}"), $c$.track(getLLVMStyle()))));
    EXPECT_EQ("void f() {\n  if (a) {\n    f();\n  }\n}",$c$.clean(format(new StringRef(/*KEEP_STR*/"void f() {\n\n  if (a) {\n\n    f();\n\n  }\n\n}"), $c$.track(getGoogleStyle()))));
    
    // Don't remove empty lines in more complex control statements.
    EXPECT_EQ("void f() {\n  if (a) {\n    f();\n\n  } else if (b) {\n    f();\n  }\n}",format(new StringRef(/*KEEP_STR*/"void f() {\n  if (a) {\n    f();\n\n  } else if (b) {\n    f();\n\n  }\n\n}")));
    
    // FIXME: This is slightly inconsistent.
    EXPECT_EQ("namespace {\nint i;\n}",format(new StringRef(/*KEEP_STR*/"namespace {\nint i;\n\n}")));
    EXPECT_EQ("namespace {\nint i;\n\n} // namespace",format(new StringRef(/*KEEP_STR*/"namespace {\nint i;\n\n}  // namespace")));
  } finally {
    $c$.$destroy();
  }
}

;
@Test
//<editor-fold defaultstate="collapsed" desc="clang::format::(anonymous namespace)::FormatTest_RecognizesBinaryOperatorKeywords_Test::TestBody">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp", line = 278,
 FQN="clang::format::(anonymous namespace)::FormatTest_RecognizesBinaryOperatorKeywords_Test::TestBody", NM="_ZN5clang6format12_GLOBAL__N_148FormatTest_RecognizesBinaryOperatorKeywords_Test8TestBodyEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp -nm=_ZN5clang6format12_GLOBAL__N_148FormatTest_RecognizesBinaryOperatorKeywords_Test8TestBodyEv")
//</editor-fold>
public void test_RecognizesBinaryOperatorKeywords() {
  if (markAsSkippedIfNeed(TestState.Successful)) { return; }
  verifyFormat(new StringRef(/*KEEP_STR*/"x = (a) and (b);"));
  verifyFormat(new StringRef(/*KEEP_STR*/"x = (a) or (b);"));
  verifyFormat(new StringRef(/*KEEP_STR*/"x = (a) bitand (b);"));
  verifyFormat(new StringRef(/*KEEP_STR*/"x = (a) bitor (b);"));
  verifyFormat(new StringRef(/*KEEP_STR*/"x = (a) not_eq (b);"));
  verifyFormat(new StringRef(/*KEEP_STR*/"x = (a) and_eq (b);"));
  verifyFormat(new StringRef(/*KEEP_STR*/"x = (a) or_eq (b);"));
  verifyFormat(new StringRef(/*KEEP_STR*/"x = (a) xor (b);"));
}


//===----------------------------------------------------------------------===//
// Tests for control statements.
//===----------------------------------------------------------------------===//
;
@Test
//<editor-fold defaultstate="collapsed" desc="clang::format::(anonymous namespace)::FormatTest_FormatIfWithoutCompoundStatement_Test::TestBody">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp", line = 293,
 FQN="clang::format::(anonymous namespace)::FormatTest_FormatIfWithoutCompoundStatement_Test::TestBody", NM="_ZN5clang6format12_GLOBAL__N_148FormatTest_FormatIfWithoutCompoundStatement_Test8TestBodyEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp -nm=_ZN5clang6format12_GLOBAL__N_148FormatTest_FormatIfWithoutCompoundStatement_Test8TestBodyEv")
//</editor-fold>
public void test_FormatIfWithoutCompoundStatement() {
  if (markAsSkippedIfNeed(TestState.Successful)) { return; }
  FormatStyle AllowsMergedIf = null;
  try {
    verifyFormat(new StringRef(/*KEEP_STR*/"if (true)\n  f();\ng();"));
    verifyFormat(new StringRef(/*KEEP_STR*/"if (a)\n  if (b)\n    if (c)\n      g();\nh();"));
    verifyFormat(new StringRef(/*KEEP_STR*/"if (a)\n  if (b) {\n    f();\n  }\ng();"));
    
    AllowsMergedIf = getLLVMStyle();
    AllowsMergedIf.AlignEscapedNewlinesLeft = true;
    AllowsMergedIf.AllowShortIfStatementsOnASingleLine = true;
    verifyFormat(new StringRef(/*KEEP_STR*/"if (a)\n  // comment\n  f();"), 
        AllowsMergedIf);
    verifyFormat(new StringRef(/*KEEP_STR*/"{\n  if (a)\n  label:\n    f();\n}"), 
        AllowsMergedIf);
    verifyFormat(new StringRef(/*KEEP_STR*/"#define A \\\n  if (a)  \\\n  label:  \\\n    f()"), 
        AllowsMergedIf);
    verifyFormat(new StringRef(/*KEEP_STR*/"if (a)\n  ;"), 
        AllowsMergedIf);
    verifyFormat(new StringRef(/*KEEP_STR*/"if (a)\n  if (b) return;"), 
        AllowsMergedIf);
    
    verifyFormat(new StringRef(/*KEEP_STR*/"if (a) // Can't merge this\n  f();\n"), 
        AllowsMergedIf);
    verifyFormat(new StringRef(/*KEEP_STR*/"if (a) /* still don't merge */\n  f();"), 
        AllowsMergedIf);
    verifyFormat(new StringRef(/*KEEP_STR*/"if (a) { // Never merge this\n  f();\n}"), 
        AllowsMergedIf);
    verifyFormat(new StringRef(/*KEEP_STR*/"if (a) { /* Never merge this */\n  f();\n}"), 
        AllowsMergedIf);
    
    AllowsMergedIf.ColumnLimit = 14;
    verifyFormat(new StringRef(/*KEEP_STR*/"if (a) return;"), AllowsMergedIf);
    verifyFormat(new StringRef(/*KEEP_STR*/"if (aaaaaaaaa)\n  return;"), 
        AllowsMergedIf);
    
    AllowsMergedIf.ColumnLimit = 13;
    verifyFormat(new StringRef(/*KEEP_STR*/"if (a)\n  return;"), AllowsMergedIf);
  } finally {
    if (AllowsMergedIf != null) { AllowsMergedIf.$destroy(); }
  }
}

;
@Test
//<editor-fold defaultstate="collapsed" desc="clang::format::(anonymous namespace)::FormatTest_FormatLoopsWithoutCompoundStatement_Test::TestBody">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp", line = 348,
 FQN="clang::format::(anonymous namespace)::FormatTest_FormatLoopsWithoutCompoundStatement_Test::TestBody", NM="_ZN5clang6format12_GLOBAL__N_151FormatTest_FormatLoopsWithoutCompoundStatement_Test8TestBodyEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp -nm=_ZN5clang6format12_GLOBAL__N_151FormatTest_FormatLoopsWithoutCompoundStatement_Test8TestBodyEv")
//</editor-fold>
public void test_FormatLoopsWithoutCompoundStatement() {
  if (markAsSkippedIfNeed(TestState.Successful)) { return; }
  FormatStyle AllowsMergedLoops = null;
  try {
    AllowsMergedLoops = getLLVMStyle();
    AllowsMergedLoops.AllowShortLoopsOnASingleLine = true;
    verifyFormat(new StringRef(/*KEEP_STR*/"while (true) continue;"), AllowsMergedLoops);
    verifyFormat(new StringRef(/*KEEP_STR*/"for (;;) continue;"), AllowsMergedLoops);
    verifyFormat(new StringRef(/*KEEP_STR*/"for (int &v : vec) v *= 2;"), AllowsMergedLoops);
    verifyFormat(new StringRef(/*KEEP_STR*/"while (true)\n  ;"), 
        AllowsMergedLoops);
    verifyFormat(new StringRef(/*KEEP_STR*/"for (;;)\n  ;"), 
        AllowsMergedLoops);
    verifyFormat(new StringRef(/*KEEP_STR*/"for (;;)\n  for (;;) continue;"), 
        AllowsMergedLoops);
    verifyFormat(new StringRef(/*KEEP_STR*/"for (;;) // Can't merge this\n  continue;"), 
        AllowsMergedLoops);
    verifyFormat(new StringRef(/*KEEP_STR*/"for (;;) /* still don't merge */\n  continue;"), 
        AllowsMergedLoops);
  } finally {
    if (AllowsMergedLoops != null) { AllowsMergedLoops.$destroy(); }
  }
}

;
@Test
//<editor-fold defaultstate="collapsed" desc="clang::format::(anonymous namespace)::FormatTest_FormatShortBracedStatements_Test::TestBody">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp", line = 371,
 FQN="clang::format::(anonymous namespace)::FormatTest_FormatShortBracedStatements_Test::TestBody", NM="_ZN5clang6format12_GLOBAL__N_143FormatTest_FormatShortBracedStatements_Test8TestBodyEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp -nm=_ZN5clang6format12_GLOBAL__N_143FormatTest_FormatShortBracedStatements_Test8TestBodyEv")
//</editor-fold>
public void test_FormatShortBracedStatements() {
  if (markAsSkippedIfNeed(TestState.Successful)) { return; }
  FormatStyle AllowSimpleBracedStatements = null;
  try {
    AllowSimpleBracedStatements = getLLVMStyle();
    AllowSimpleBracedStatements.AllowShortBlocksOnASingleLine = true;
    
    AllowSimpleBracedStatements.AllowShortIfStatementsOnASingleLine = true;
    AllowSimpleBracedStatements.AllowShortLoopsOnASingleLine = true;
    
    verifyFormat(new StringRef(/*KEEP_STR*/"if (true) {}"), AllowSimpleBracedStatements);
    verifyFormat(new StringRef(/*KEEP_STR*/"while (true) {}"), AllowSimpleBracedStatements);
    verifyFormat(new StringRef(/*KEEP_STR*/"for (;;) {}"), AllowSimpleBracedStatements);
    verifyFormat(new StringRef(/*KEEP_STR*/"if (true) { f(); }"), AllowSimpleBracedStatements);
    verifyFormat(new StringRef(/*KEEP_STR*/"while (true) { f(); }"), AllowSimpleBracedStatements);
    verifyFormat(new StringRef(/*KEEP_STR*/"for (;;) { f(); }"), AllowSimpleBracedStatements);
    verifyFormat(new StringRef(/*KEEP_STR*/"if (true) { //\n  f();\n}"), 
        AllowSimpleBracedStatements);
    verifyFormat(new StringRef(/*KEEP_STR*/"if (true) {\n  f();\n  f();\n}"), 
        AllowSimpleBracedStatements);
    verifyFormat(new StringRef(/*KEEP_STR*/"if (true) {\n  f();\n} else {\n  f();\n}"), 
        AllowSimpleBracedStatements);
    
    verifyFormat(new StringRef(/*KEEP_STR*/"template <int> struct A2 {\n  struct B {};\n};"), 
        AllowSimpleBracedStatements);
    
    AllowSimpleBracedStatements.AllowShortIfStatementsOnASingleLine = false;
    verifyFormat(new StringRef(/*KEEP_STR*/"if (true) {\n  f();\n}"), 
        AllowSimpleBracedStatements);
    verifyFormat(new StringRef(/*KEEP_STR*/"if (true) {\n  f();\n} else {\n  f();\n}"), 
        AllowSimpleBracedStatements);
    
    AllowSimpleBracedStatements.AllowShortLoopsOnASingleLine = false;
    verifyFormat(new StringRef(/*KEEP_STR*/"while (true) {\n  f();\n}"), 
        AllowSimpleBracedStatements);
    verifyFormat(new StringRef(/*KEEP_STR*/"for (;;) {\n  f();\n}"), 
        AllowSimpleBracedStatements);
  } finally {
    if (AllowSimpleBracedStatements != null) { AllowSimpleBracedStatements.$destroy(); }
  }
}

;
@Test
//<editor-fold defaultstate="collapsed" desc="clang::format::(anonymous namespace)::FormatTest_ParseIfElse_Test::TestBody">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp", line = 428,
 FQN="clang::format::(anonymous namespace)::FormatTest_ParseIfElse_Test::TestBody", NM="_ZN5clang6format12_GLOBAL__N_127FormatTest_ParseIfElse_Test8TestBodyEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp -nm=_ZN5clang6format12_GLOBAL__N_127FormatTest_ParseIfElse_Test8TestBodyEv")
//</editor-fold>
public void test_ParseIfElse() {
  if (markAsSkippedIfNeed(TestState.Successful)) { return; }
  verifyFormat(new StringRef(/*KEEP_STR*/"if (true)\n  if (true)\n    if (true)\n      f();\n    else\n      g();\n  else\n    h();\nelse\n  i();"));
  verifyFormat(new StringRef(/*KEEP_STR*/"if (true)\n  if (true)\n    if (true) {\n      if (true)\n        f();\n    } else {\n      g();\n    }\n  else\n    h();\nelse {\n  i();\n}"));
  verifyFormat(new StringRef(/*KEEP_STR*/"void f() {\n  if (a) {\n  } else {\n  }\n}"));
}

;
@Test
//<editor-fold defaultstate="collapsed" desc="clang::format::(anonymous namespace)::FormatTest_ElseIf_Test::TestBody">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp", line = 459,
 FQN="clang::format::(anonymous namespace)::FormatTest_ElseIf_Test::TestBody", NM="_ZN5clang6format12_GLOBAL__N_122FormatTest_ElseIf_Test8TestBodyEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp -nm=_ZN5clang6format12_GLOBAL__N_122FormatTest_ElseIf_Test8TestBodyEv")
//</editor-fold>
public void test_ElseIf() {
  if (markAsSkippedIfNeed(TestState.Successful)) { return; }
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    verifyFormat(new StringRef(/*KEEP_STR*/"if (a) {\n} else if (b) {\n}"));
    verifyFormat(new StringRef(/*KEEP_STR*/"if (a)\n  f();\nelse if (b)\n  g();\nelse\n  h();"));
    verifyFormat(new StringRef(/*KEEP_STR*/"if (a) {\n  f();\n}\n// or else ..\nelse {\n  g()\n}"));
    
    verifyFormat(new StringRef(/*KEEP_STR*/"if (a) {\n} else if (aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa(\n               aaaaaaaaaaaaaaaaaaaaaaaaaaaa)) {\n}"));
    verifyFormat(new StringRef(/*KEEP_STR*/"if (a) {\n} else if (\n    aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa) {\n}"), 
        $c$.track(getLLVMStyleWithColumns(62))); $c$.clean();
  } finally {
    $c$.$destroy();
  }
}

;
@Test
//<editor-fold defaultstate="collapsed" desc="clang::format::(anonymous namespace)::FormatTest_FormatsForLoop_Test::TestBody">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp", line = 486,
 FQN="clang::format::(anonymous namespace)::FormatTest_FormatsForLoop_Test::TestBody", NM="_ZN5clang6format12_GLOBAL__N_130FormatTest_FormatsForLoop_Test8TestBodyEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp -nm=_ZN5clang6format12_GLOBAL__N_130FormatTest_FormatsForLoop_Test8TestBodyEv")
//</editor-fold>
public void test_FormatsForLoop() {
  if (markAsSkippedIfNeed(TestState.Successful)) { return; }
  FormatStyle NoBinPacking = null;
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    verifyFormat(new StringRef(/*KEEP_STR*/"for (int VeryVeryLongLoopVariable = 0; VeryVeryLongLoopVariable < 10;\n     ++VeryVeryLongLoopVariable)\n  ;"));
    verifyFormat(new StringRef(/*KEEP_STR*/"for (;;)\n  f();"));
    verifyFormat(new StringRef(/*KEEP_STR*/"for (;;) {\n}"));
    verifyFormat(new StringRef(/*KEEP_STR*/"for (;;) {\n  f();\n}"));
    verifyFormat(new StringRef(/*KEEP_STR*/"for (int i = 0; (i < 10); ++i) {\n}"));
    
    verifyFormat(new StringRef(/*KEEP_STR*/"for (std::vector<UnwrappedLine>::iterator I = UnwrappedLines.begin(),\n                                          E = UnwrappedLines.end();\n     I != E; ++I) {\n}"));
    
    verifyFormat(new StringRef(/*KEEP_STR*/"for (MachineFun::iterator IIII = PrevIt, EEEE = F.end(); IIII != EEEE;\n     ++IIIII) {\n}"));
    verifyFormat(new StringRef(/*KEEP_STR*/"for (aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa aaaaaaaaaaa =\n         aaaaaaaaaaaaaaaa.aaaaaaaaaaaaaaa;\n     aaaaaaaaaaa != aaaaaaaaaaaaaaaaaaa; ++aaaaaaaaaaa) {\n}"));
    verifyFormat(new StringRef(/*KEEP_STR*/"for (llvm::ArrayRef<NamedDecl *>::iterator\n         I = FD->getDeclsInPrototypeScope().begin(),\n         E = FD->getDeclsInPrototypeScope().end();\n     I != E; ++I) {\n}"));
    verifyFormat(new StringRef(/*KEEP_STR*/"for (SmallVectorImpl<TemplateIdAnnotationn *>::iterator\n         I = Container.begin(),\n         E = Container.end();\n     I != E; ++I) {\n}"), 
        $c$.track(getLLVMStyleWithColumns(76))); $c$.clean();
    
    verifyFormat(new StringRef(/*KEEP_STR*/"for (aaaaaaaaaaaaaaaaa aaaaaaaaaaa = aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa;\n     aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa !=\n     aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa(\n         aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa);\n     ++aaaaaaaaaaa) {\n}"));
    verifyFormat(new StringRef(/*KEEP_STR*/"for (int i = 0; i < aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa ||\n                bbbbbbbbbbbbbbbbbbbb < ccccccccccccccc;\n     ++i) {\n}"));
    verifyFormat(new StringRef(/*KEEP_STR*/"for (int aaaaaaaaaaa = 1; aaaaaaaaaaa <= bbbbbbbbbbbbbbb;\n     aaaaaaaaaaa++, bbbbbbbbbbbbbbbbb++) {\n}"));
    verifyFormat(new StringRef(/*KEEP_STR*/"for (some_namespace::SomeIterator iter( // force break\n         aaaaaaaaaa);\n     iter; ++iter) {\n}"));
    verifyFormat(new StringRef(/*KEEP_STR*/"for (auto aaaaaaaaaaaaaaaaaaaaaaaaaaa(\n         aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa);\n     aaaaaaaaaaaaaaaaaaaaaaaaaaa != bbbbbbbbbbbbbbbbbbbbbbb;\n     ++aaaaaaaaaaaaaaaaaaaaaaaaaaa) {"));
    
    NoBinPacking = getLLVMStyle();
    NoBinPacking.BinPackParameters = false;
    verifyFormat(new StringRef(/*KEEP_STR*/"for (int aaaaaaaaaaa = 1;\n     aaaaaaaaaaa <= aaaaaaaaaaaaaaaaaaaaaa(aaaaaaaaaaaaaaaa,\n                                           aaaaaaaaaaaaaaaa,\n                                           aaaaaaaaaaaaaaaa,\n                                           aaaaaaaaaaaaaaaa);\n     aaaaaaaaaaa++, bbbbbbbbbbbbbbbbb++) {\n}"), 
        NoBinPacking);
    verifyFormat(new StringRef(/*KEEP_STR*/"for (std::vector<UnwrappedLine>::iterator I = UnwrappedLines.begin(),\n                                          E = UnwrappedLines.end();\n     I != E;\n     ++I) {\n}"), 
        NoBinPacking);
  } finally {
    if (NoBinPacking != null) { NoBinPacking.$destroy(); }
    $c$.$destroy();
  }
}

;
@Test
//<editor-fold defaultstate="collapsed" desc="clang::format::(anonymous namespace)::FormatTest_RangeBasedForLoops_Test::TestBody">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp", line = 559,
 FQN="clang::format::(anonymous namespace)::FormatTest_RangeBasedForLoops_Test::TestBody", NM="_ZN5clang6format12_GLOBAL__N_134FormatTest_RangeBasedForLoops_Test8TestBodyEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp -nm=_ZN5clang6format12_GLOBAL__N_134FormatTest_RangeBasedForLoops_Test8TestBodyEv")
//</editor-fold>
public void test_RangeBasedForLoops() {
  if (markAsSkippedIfNeed(TestState.Successful)) { return; }
  verifyFormat(new StringRef(/*KEEP_STR*/"for (auto aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa :\n     aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa) {\n}"));
  verifyFormat(new StringRef(/*KEEP_STR*/"for (auto aaaaaaaaaaaaaaaaaaaaa :\n     aaaaaaaaaaaaaaaaa(aaaaaaaaaaaaaaaa, aaaaaaaaaaaaa)) {\n}"));
  verifyFormat(new StringRef(/*KEEP_STR*/"for (const aaaaaaaaaaaaaaaaaaaaa &aaaaaaaaa :\n     aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa) {\n}"));
  verifyFormat(new StringRef(/*KEEP_STR*/"for (aaaaaaaaa aaaaaaaaaaaaaaaaaaaaa :\n     aaaaaaaaaaaa.aaaaaaaaaaaa().aaaaaaaaa().a()) {\n}"));
}

;
@Test
//<editor-fold defaultstate="collapsed" desc="clang::format::(anonymous namespace)::FormatTest_ForEachLoops_Test::TestBody">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp", line = 570,
 FQN="clang::format::(anonymous namespace)::FormatTest_ForEachLoops_Test::TestBody", NM="_ZN5clang6format12_GLOBAL__N_128FormatTest_ForEachLoops_Test8TestBodyEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp -nm=_ZN5clang6format12_GLOBAL__N_128FormatTest_ForEachLoops_Test8TestBodyEv")
//</editor-fold>
public void test_ForEachLoops() {
  if (markAsSkippedIfNeed(TestState.Successful)) { return; }
  verifyFormat(new StringRef(/*KEEP_STR*/"void f() {\n  foreach (Item *item, itemlist) {}\n  Q_FOREACH (Item *item, itemlist) {}\n  BOOST_FOREACH (Item *item, itemlist) {}\n  UNKNOWN_FORACH(Item * item, itemlist) {}\n}"));
  
  // As function-like macros.
  verifyFormat(new StringRef(/*KEEP_STR*/"#define foreach(x, y)\n#define Q_FOREACH(x, y)\n#define BOOST_FOREACH(x, y)\n#define UNKNOWN_FOREACH(x, y)\n"));
  
  // Not as function-like macros.
  verifyFormat(new StringRef(/*KEEP_STR*/"#define foreach (x, y)\n#define Q_FOREACH (x, y)\n#define BOOST_FOREACH (x, y)\n#define UNKNOWN_FOREACH (x, y)\n"));
}

;
@Test
//<editor-fold defaultstate="collapsed" desc="clang::format::(anonymous namespace)::FormatTest_FormatsWhileLoop_Test::TestBody">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp", line = 591,
 FQN="clang::format::(anonymous namespace)::FormatTest_FormatsWhileLoop_Test::TestBody", NM="_ZN5clang6format12_GLOBAL__N_132FormatTest_FormatsWhileLoop_Test8TestBodyEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp -nm=_ZN5clang6format12_GLOBAL__N_132FormatTest_FormatsWhileLoop_Test8TestBodyEv")
//</editor-fold>
public void test_FormatsWhileLoop() {
  if (markAsSkippedIfNeed(TestState.Successful)) { return; }
  verifyFormat(new StringRef(/*KEEP_STR*/"while (true) {\n}"));
  verifyFormat(new StringRef(/*KEEP_STR*/"while (true)\n  f();"));
  verifyFormat(new StringRef(/*KEEP_STR*/"while () {\n}"));
  verifyFormat(new StringRef(/*KEEP_STR*/"while () {\n  f();\n}"));
}

;
@Test
//<editor-fold defaultstate="collapsed" desc="clang::format::(anonymous namespace)::FormatTest_FormatsDoWhile_Test::TestBody">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp", line = 601,
 FQN="clang::format::(anonymous namespace)::FormatTest_FormatsDoWhile_Test::TestBody", NM="_ZN5clang6format12_GLOBAL__N_130FormatTest_FormatsDoWhile_Test8TestBodyEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp -nm=_ZN5clang6format12_GLOBAL__N_130FormatTest_FormatsDoWhile_Test8TestBodyEv")
//</editor-fold>
public void test_FormatsDoWhile() {
  if (markAsSkippedIfNeed(TestState.Successful)) { return; }
  verifyFormat(new StringRef(/*KEEP_STR*/"do {\n  do_something();\n} while (something());"));
  verifyFormat(new StringRef(/*KEEP_STR*/"do\n  do_something();\nwhile (something());"));
}

;
@Test
//<editor-fold defaultstate="collapsed" desc="clang::format::(anonymous namespace)::FormatTest_FormatsSwitchStatement_Test::TestBody">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp", line = 610,
 FQN="clang::format::(anonymous namespace)::FormatTest_FormatsSwitchStatement_Test::TestBody", NM="_ZN5clang6format12_GLOBAL__N_138FormatTest_FormatsSwitchStatement_Test8TestBodyEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp -nm=_ZN5clang6format12_GLOBAL__N_138FormatTest_FormatsSwitchStatement_Test8TestBodyEv")
//</editor-fold>
public void test_FormatsSwitchStatement() {
  if (markAsSkippedIfNeed(TestState.Successful)) { return; }
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    verifyFormat(new StringRef(/*KEEP_STR*/"switch (x) {\ncase 1:\n  f();\n  break;\ncase kFoo:\ncase ns::kBar:\ncase kBaz:\n  break;\ndefault:\n  g();\n  break;\n}"));
    verifyFormat(new StringRef(/*KEEP_STR*/"switch (x) {\ncase 1: {\n  f();\n  break;\n}\ncase 2: {\n  break;\n}\n}"));
    verifyFormat(new StringRef(/*KEEP_STR*/"switch (x) {\ncase 1: {\n  f();\n  {\n    g();\n    h();\n  }\n  break;\n}\n}"));
    verifyFormat(new StringRef(/*KEEP_STR*/"switch (x) {\ncase 1: {\n  f();\n  if (foo) {\n    g();\n    h();\n  }\n  break;\n}\n}"));
    verifyFormat(new StringRef(/*KEEP_STR*/"switch (x) {\ncase 1: {\n  f();\n  g();\n} break;\n}"));
    verifyFormat(new StringRef(/*KEEP_STR*/"switch (test)\n  ;"));
    verifyFormat(new StringRef(/*KEEP_STR*/"switch (x) {\ndefault: {\n  // Do nothing.\n}\n}"));
    verifyFormat(new StringRef(/*KEEP_STR*/"switch (x) {\n// comment\n// if 1, do f()\ncase 1:\n  f();\n}"));
    verifyFormat(new StringRef(/*KEEP_STR*/"switch (x) {\ncase 1:\n  // Do amazing stuff\n  {\n    f();\n    g();\n  }\n  break;\n}"));
    verifyFormat(new StringRef(/*KEEP_STR*/"#define A          \\\n  switch (x) {     \\\n  case a:          \\\n    foo = b;       \\\n  }"), 
        $c$.track(getLLVMStyleWithColumns(20))); $c$.clean();
    verifyFormat(new StringRef(/*KEEP_STR*/"#define OPERATION_CASE(name)           \\\n  case OP_name:                        \\\n    return operations::Operation##name\n"), 
        $c$.track(getLLVMStyleWithColumns(40))); $c$.clean();
    verifyFormat(new StringRef(/*KEEP_STR*/"switch (x) {\ncase 1:;\ndefault:;\n  int i;\n}"));
    
    verifyGoogleFormat(new StringRef(/*KEEP_STR*/"switch (x) {\n  case 1:\n    f();\n    break;\n  case kFoo:\n  case ns::kBar:\n  case kBaz:\n    break;\n  default:\n    g();\n    break;\n}"));
    verifyGoogleFormat(new StringRef(/*KEEP_STR*/"switch (x) {\n  case 1: {\n    f();\n    break;\n  }\n}"));
    verifyGoogleFormat(new StringRef(/*KEEP_STR*/"switch (test)\n  ;"));
    
    verifyGoogleFormat(new StringRef(/*KEEP_STR*/"#define OPERATION_CASE(name) \\\n  case OP_name:              \\\n    return operations::Operation##name\n"));
    verifyGoogleFormat(new StringRef(/*KEEP_STR*/"Operation codeToOperation(OperationCode OpCode) {\n  // Get the correction operation class.\n  switch (OpCode) {\n    CASE(Add);\n    CASE(Subtract);\n    default:\n      return operations::Unknown;\n  }\n#undef OPERATION_CASE\n}"));
    verifyFormat(new StringRef(/*KEEP_STR*/"DEBUG({\n  switch (x) {\n  case A:\n    f();\n    break;\n  // On B:\n  case B:\n    g();\n    break;\n  }\n});"));
    verifyFormat(new StringRef(/*KEEP_STR*/"switch (a) {\ncase (b):\n  return;\n}"));
    
    verifyFormat(new StringRef(/*KEEP_STR*/"switch (a) {\ncase some_namespace::\n    some_constant:\n  return;\n}"), 
        $c$.track(getLLVMStyleWithColumns(34))); $c$.clean();
  } finally {
    $c$.$destroy();
  }
}

;
@Test
//<editor-fold defaultstate="collapsed" desc="clang::format::(anonymous namespace)::FormatTest_CaseRanges_Test::TestBody">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp", line = 754,
 FQN="clang::format::(anonymous namespace)::FormatTest_CaseRanges_Test::TestBody", NM="_ZN5clang6format12_GLOBAL__N_126FormatTest_CaseRanges_Test8TestBodyEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp -nm=_ZN5clang6format12_GLOBAL__N_126FormatTest_CaseRanges_Test8TestBodyEv")
//</editor-fold>
public void test_CaseRanges() {
  if (markAsSkippedIfNeed(TestState.Successful)) { return; }
  verifyFormat(new StringRef(/*KEEP_STR*/"switch (x) {\ncase 'A' ... 'Z':\ncase 1 ... 5:\ncase a ... b:\n  break;\n}"));
}

;
@Test
//<editor-fold defaultstate="collapsed" desc="clang::format::(anonymous namespace)::FormatTest_ShortCaseLabels_Test::TestBody">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp", line = 763,
 FQN="clang::format::(anonymous namespace)::FormatTest_ShortCaseLabels_Test::TestBody", NM="_ZN5clang6format12_GLOBAL__N_131FormatTest_ShortCaseLabels_Test8TestBodyEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp -nm=_ZN5clang6format12_GLOBAL__N_131FormatTest_ShortCaseLabels_Test8TestBodyEv")
//</editor-fold>
public void test_ShortCaseLabels() {
  if (markAsSkippedIfNeed(TestState.Successful)) { return; }
  FormatStyle Style = null;
  try {
    Style = getLLVMStyle();
    Style.AllowShortCaseLabelsOnASingleLine = true;
    verifyFormat(new StringRef(/*KEEP_STR*/"switch (a) {\ncase 1: x = 1; break;\ncase 2: return;\ncase 3:\ncase 4:\ncase 5: return;\ncase 6: // comment\n  return;\ncase 7:\n  // comment\n  return;\ncase 8:\n  x = 8; // comment\n  break;\ndefault: y = 1; break;\n}"), 
        Style);
    verifyFormat(new StringRef(/*KEEP_STR*/"switch (a) {\n#if FOO\ncase 0: return 0;\n#endif\n}"), 
        Style);
    verifyFormat(new StringRef(/*KEEP_STR*/"switch (a) {\ncase 1: {\n}\ncase 2: {\n  return;\n}\ncase 3: {\n  x = 1;\n  return;\n}\ncase 4:\n  if (x)\n    return;\n}"), 
        Style);
    Style.ColumnLimit = 21;
    verifyFormat(new StringRef(/*KEEP_STR*/"switch (a) {\ncase 1: x = 1; break;\ncase 2: return;\ncase 3:\ncase 4:\ncase 5: return;\ndefault:\n  y = 1;\n  break;\n}"), 
        Style);
  } finally {
    if (Style != null) { Style.$destroy(); }
  }
}

;
@Test
//<editor-fold defaultstate="collapsed" desc="clang::format::(anonymous namespace)::FormatTest_FormatsLabels_Test::TestBody">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp", line = 818,
 FQN="clang::format::(anonymous namespace)::FormatTest_FormatsLabels_Test::TestBody", NM="_ZN5clang6format12_GLOBAL__N_129FormatTest_FormatsLabels_Test8TestBodyEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp -nm=_ZN5clang6format12_GLOBAL__N_129FormatTest_FormatsLabels_Test8TestBodyEv")
//</editor-fold>
public void test_FormatsLabels() {
  if (markAsSkippedIfNeed(TestState.Successful)) { return; }
  verifyFormat(new StringRef(/*KEEP_STR*/"void f() {\n  some_code();\ntest_label:\n  some_other_code();\n  {\n    some_more_code();\n  another_label:\n    some_more_code();\n  }\n}"));
  verifyFormat(new StringRef(/*KEEP_STR*/"{\n  some_code();\ntest_label:\n  some_other_code();\n}"));
  verifyFormat(new StringRef(/*KEEP_STR*/"{\n  some_code();\ntest_label:;\n  int i = 0;\n}"));
}


//===----------------------------------------------------------------------===//
// Tests for comments.
//===----------------------------------------------------------------------===//
;
@Test
//<editor-fold defaultstate="collapsed" desc="clang::format::(anonymous namespace)::FormatTest_UnderstandsSingleLineComments_Test::TestBody">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp", line = 845,
 FQN="clang::format::(anonymous namespace)::FormatTest_UnderstandsSingleLineComments_Test::TestBody", NM="_ZN5clang6format12_GLOBAL__N_145FormatTest_UnderstandsSingleLineComments_Test8TestBodyEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp -nm=_ZN5clang6format12_GLOBAL__N_145FormatTest_UnderstandsSingleLineComments_Test8TestBodyEv")
//</editor-fold>
public void test_UnderstandsSingleLineComments() {
  if (markAsSkippedIfNeed(TestState.Successful)) { return; }
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    verifyFormat(new StringRef(/*KEEP_STR*/"//* */"));
    verifyFormat(new StringRef(/*KEEP_STR*/"// line 1\n// line 2\nvoid f() {}\n"));
    
    verifyFormat(new StringRef(/*KEEP_STR*/"void f() {\n  // Doesn't do anything\n}"));
    verifyFormat(new StringRef(/*KEEP_STR*/"SomeObject\n    // Calling someFunction on SomeObject\n    .someFunction();"));
    verifyFormat(new StringRef(/*KEEP_STR*/"auto result = SomeObject\n                  // Calling someFunction on SomeObject\n                  .someFunction();"));
    verifyFormat(new StringRef(/*KEEP_STR*/"void f(int i,  // some comment (probably for i)\n       int j,  // some comment (probably for j)\n       int k); // some comment (probably for k)"));
    verifyFormat(new StringRef(/*KEEP_STR*/"void f(int i,\n       // some comment (probably for j)\n       int j,\n       // some comment (probably for k)\n       int k);"));
    
    verifyFormat(new StringRef(/*KEEP_STR*/"int i    // This is a fancy variable\n    = 5; // with nicely aligned comment."));
    
    verifyFormat(new StringRef(/*KEEP_STR*/"// Leading comment.\nint a; // Trailing comment."));
    verifyFormat(new StringRef(/*KEEP_STR*/"int a; // Trailing comment\n       // on 2\n       // or 3 lines.\nint b;"));
    verifyFormat(new StringRef(/*KEEP_STR*/"int a; // Trailing comment\n\n// Leading comment.\nint b;"));
    verifyFormat(new StringRef(/*KEEP_STR*/"int a;    // Comment.\n          // More details.\nint bbbb; // Another comment."));
    verifyFormat(new StringRef(/*KEEP_STR*/"int aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa; // comment\nint bbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbb;   // comment\nint cccccccccccccccccccccccccccccc;       // comment\nint ddd;                     // looooooooooooooooooooooooong comment\nint aaaaaaaaaaaaaaaaaaaaaaa; // comment\nint bbbbbbbbbbbbbbbbbbbbb;   // comment\nint ccccccccccccccccccc;     // comment"));
    
    verifyFormat(new StringRef(/*KEEP_STR*/"#include \"a\"     // comment\n#include \"a/b/c\" // comment"));
    verifyFormat(new StringRef(/*KEEP_STR*/"#include <a>     // comment\n#include <a/b/c> // comment"));
    EXPECT_EQ("#include \"a\"     // comment\n#include \"a/b/c\" // comment",format(new StringRef(/*KEEP_STR*/"#include \\\n  \"a\" // comment\n#include \"a/b/c\" // comment")));
    
    verifyFormat(new StringRef(/*KEEP_STR*/"enum E {\n  // comment\n  VAL_A, // comment\n  VAL_B\n};"));
    
    verifyFormat(new StringRef(/*KEEP_STR*/"aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa =\n    bbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbb; // Trailing comment"));
    verifyFormat(new StringRef(/*KEEP_STR*/"aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa =\n    // Comment inside a statement.\n    bbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbb;"));
    verifyFormat(new StringRef(/*KEEP_STR*/"SomeFunction(a,\n             // comment\n             b + x);"));
    verifyFormat(new StringRef(/*KEEP_STR*/"SomeFunction(a, a,\n             // comment\n             b + x);"));
    verifyFormat(new StringRef(/*KEEP_STR*/"bool aaaaaaaaaaaaa = // comment\n    aaaaaaaaaaaaaaaaaaaaaaaaaaaaaa || aaaaaaaaaaaaaaaaaaaaaaaaaaaa ||\n    aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa || aaaaaaaaaaaaaaaaaaaaaaaaaaaaa;"));
    
    verifyFormat(new StringRef(/*KEEP_STR*/"int aaaa; // aaaaa\nint aa;   // aaaaaaa"), 
        $c$.track(getLLVMStyleWithColumns(20))); $c$.clean();
    EXPECT_EQ("void f() { // This does something ..\n}\nint a; // This is unrelated",format(new StringRef(/*KEEP_STR*/"void f()    {     // This does something ..\n  }\nint   a;     // This is unrelated")));
    EXPECT_EQ("class C {\n  void f() { // This does something ..\n  }          // awesome..\n\n  int a; // This is unrelated\n};",format(new StringRef(/*KEEP_STR*/"class C{void f()    { // This does something ..\n      } // awesome..\n \nint a;    // This is unrelated\n};")));
    EXPECT_EQ("int i; // single line trailing comment",format(new StringRef(/*KEEP_STR*/"int i;\\\n// single line trailing comment")));
    
    verifyGoogleFormat(new StringRef(/*KEEP_STR*/"int a;  // Trailing comment."));
    
    verifyFormat(new StringRef(/*KEEP_STR*/"someFunction(anotherFunction( // Force break.\n    parameter));"));
    
    verifyGoogleFormat(new StringRef(/*KEEP_STR*/"#endif  // HEADER_GUARD"));
    
    verifyFormat(new StringRef(/*KEEP_STR*/"const char *test[] = {\n    // A\n    \"aaaa\",\n    // B\n    \"aaaaa\"};"));
    verifyGoogleFormat(new StringRef(/*KEEP_STR*/"aaaaaaaaaaaaaaaaaaaaaaaaaa(\n    aaaaaaaaaaaaaaaaaaaaaa);  // 81_cols_with_this_comment"));
    EXPECT_EQ("D(a, {\n  // test\n  int a;\n});",format(new StringRef(/*KEEP_STR*/"D(a, {\n// test\nint a;\n});")));
    EXPECT_EQ("lineWith(); // comment\n// at start\notherLine();",format(new StringRef(/*KEEP_STR*/"lineWith();   // comment\n// at start\notherLine();")));
    EXPECT_EQ("lineWith(); // comment\n/*\n * at start */\notherLine();",format(new StringRef(/*KEEP_STR*/"lineWith();   // comment\n/*\n * at start */\notherLine();")));
    EXPECT_EQ("lineWith(); // comment\n            // at start\notherLine();",format(new StringRef(/*KEEP_STR*/"lineWith();   // comment\n // at start\notherLine();")));
    EXPECT_EQ("lineWith(); // comment\n// at start\notherLine(); // comment",format(new StringRef(/*KEEP_STR*/"lineWith();   // comment\n// at start\notherLine();   // comment")));
    EXPECT_EQ("lineWith();\n// at start\notherLine(); // comment",format(new StringRef(/*KEEP_STR*/"lineWith();\n // at start\notherLine();   // comment")));
    EXPECT_EQ("// first\n// at start\notherLine(); // comment",format(new StringRef(/*KEEP_STR*/"// first\n // at start\notherLine();   // comment")));
    EXPECT_EQ("f();\n// first\n// at start\notherLine(); // comment",format(new StringRef(/*KEEP_STR*/"f();\n// first\n // at start\notherLine();   // comment")));
    verifyFormat(new StringRef(/*KEEP_STR*/"f(); // comment\n// first\n// at start\notherLine();"));
    EXPECT_EQ("f(); // comment\n// first\n// at start\notherLine();",format(new StringRef(/*KEEP_STR*/"f();   // comment\n// first\n // at start\notherLine();")));
    EXPECT_EQ("f(); // comment\n     // first\n// at start\notherLine();",format(new StringRef(/*KEEP_STR*/"f();   // comment\n // first\n// at start\notherLine();")));
    EXPECT_EQ("void f() {\n  lineWith(); // comment\n  // at start\n}",format(new StringRef(/*KEEP_STR*/"void              f() {\n  lineWith(); // comment\n  // at start\n}")));
    EXPECT_EQ("int xy; // a\nint z;  // b",format(new StringRef(/*KEEP_STR*/"int xy;    // a\nint z;    //b")));
    EXPECT_EQ("int xy; // a\nint z; // bb",$c$.clean(format(new StringRef(/*KEEP_STR*/"int xy;    // a\nint z;    //bb"), $c$.track(getLLVMStyleWithColumns(12)))));
    
    verifyFormat(new StringRef(/*KEEP_STR*/"#define A                                                  \\\n  int i; /* iiiiiiiiiiiiiiiiiiiii */                       \\\n  int jjjjjjjjjjjjjjjjjjjjjjjj; /* */"), 
        $c$.track(getLLVMStyleWithColumns(60))); $c$.clean();
    verifyFormat(new StringRef(/*KEEP_STR*/"#define A                                                   \\\n  int i;                        /* iiiiiiiiiiiiiiiiiiiii */ \\\n  int jjjjjjjjjjjjjjjjjjjjjjjj; /* */"), 
        $c$.track(getLLVMStyleWithColumns(61))); $c$.clean();
    
    verifyFormat(new StringRef(/*KEEP_STR*/"if ( // This is some comment\n    x + 3) {\n}"));
    EXPECT_EQ("if ( // This is some comment\n     // spanning two lines\n    x + 3) {\n}",format(new StringRef(/*KEEP_STR*/"if( // This is some comment\n     // spanning two lines\n x + 3) {\n}")));
    
    verifyNoCrash(new StringRef(/*KEEP_STR*/"/\\\n/"));
    verifyNoCrash(new StringRef(/*KEEP_STR*/"/\\\n* */"));
    // The 0-character somehow makes the lexer return a proper comment.
    verifyNoCrash(new StringRef(/*KEEP_STR*/"/*\\\000\n/", 6));
  } finally {
    $c$.$destroy();
  }
}

;
@Test
//<editor-fold defaultstate="collapsed" desc="clang::format::(anonymous namespace)::FormatTest_KeepsParameterWithTrailingCommentsOnTheirOwnLine_Test::TestBody">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp", line = 1089,
 FQN="clang::format::(anonymous namespace)::FormatTest_KeepsParameterWithTrailingCommentsOnTheirOwnLine_Test::TestBody", NM="_ZN5clang6format12_GLOBAL__N_164FormatTest_KeepsParameterWithTrailingCommentsOnTheirOwnLine_Test8TestBodyEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp -nm=_ZN5clang6format12_GLOBAL__N_164FormatTest_KeepsParameterWithTrailingCommentsOnTheirOwnLine_Test8TestBodyEv")
//</editor-fold>
public void test_KeepsParameterWithTrailingCommentsOnTheirOwnLine() {
  if (markAsSkippedIfNeed(TestState.Successful)) { return; }
    EXPECT_EQ("SomeFunction(a,\n             b, // comment\n             c);",format(new StringRef(/*KEEP_STR*/"SomeFunction(a,\n          b, // comment\n      c);")));
    EXPECT_EQ("SomeFunction(a, b,\n             // comment\n             c);",format(new StringRef(/*KEEP_STR*/"SomeFunction(a,\n          b,\n  // comment\n      c);")));
    EXPECT_EQ("SomeFunction(a, b, // comment (unclear relation)\n             c);",format(new StringRef(/*KEEP_STR*/"SomeFunction(a, b, // comment (unclear relation)\n      c);")));
    EXPECT_EQ("SomeFunction(a, // comment\n             b,\n             c); // comment",format(new StringRef(/*KEEP_STR*/"SomeFunction(a,     // comment\n          b,\n      c); // comment")));
}

;
@Test
//<editor-fold defaultstate="collapsed" desc="clang::format::(anonymous namespace)::FormatTest_RemovesTrailingWhitespaceOfComments_Test::TestBody">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp", line = 1115,
 FQN="clang::format::(anonymous namespace)::FormatTest_RemovesTrailingWhitespaceOfComments_Test::TestBody", NM="_ZN5clang6format12_GLOBAL__N_151FormatTest_RemovesTrailingWhitespaceOfComments_Test8TestBodyEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp -nm=_ZN5clang6format12_GLOBAL__N_151FormatTest_RemovesTrailingWhitespaceOfComments_Test8TestBodyEv")
//</editor-fold>
public void test_RemovesTrailingWhitespaceOfComments() {
  if (markAsSkippedIfNeed(TestState.Successful)) { return; }
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    EXPECT_EQ("// comment",format(new StringRef(/*KEEP_STR*/"// comment  ")));
    EXPECT_EQ("int aaaaaaa, bbbbbbb; // comment",$c$.clean(format(new StringRef(/*KEEP_STR*/"int aaaaaaa, bbbbbbb; // comment                   "), $c$.track(getLLVMStyleWithColumns(33)))));
    EXPECT_EQ("// comment\\\n",format(new StringRef(/*KEEP_STR*/"// comment\\\n  \t \013   \014   ")));
    EXPECT_EQ("// comment    \\\n",format(new StringRef(/*KEEP_STR*/"// comment    \\\n  \t \013   \014   ")));
  } finally {
    $c$.$destroy();
  }
}

;
@Test
//<editor-fold defaultstate="collapsed" desc="clang::format::(anonymous namespace)::FormatTest_UnderstandsBlockComments_Test::TestBody">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp", line = 1124,
 FQN="clang::format::(anonymous namespace)::FormatTest_UnderstandsBlockComments_Test::TestBody", NM="_ZN5clang6format12_GLOBAL__N_140FormatTest_UnderstandsBlockComments_Test8TestBodyEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp -nm=_ZN5clang6format12_GLOBAL__N_140FormatTest_UnderstandsBlockComments_Test8TestBodyEv")
//</editor-fold>
public void test_UnderstandsBlockComments() {
  if (markAsSkippedIfNeed(TestState.Successful)) { return; }
  FormatStyle NoBinPacking = null;
  try {
    verifyFormat(new StringRef(/*KEEP_STR*/"f(/*noSpaceAfterParameterNamingComment=*/true);"));
    verifyFormat(new StringRef(/*KEEP_STR*/"void f() { g(/*aaa=*/x, /*bbb=*/!y, /*c=*/::c); }"));
    EXPECT_EQ("f(aaaaaaaaaaaaaaaaaaaaaaaaa, /* Trailing comment for aa... */\n  bbbbbbbbbbbbbbbbbbbbbbbbb);",format(new StringRef(/*KEEP_STR*/"f(aaaaaaaaaaaaaaaaaaaaaaaaa ,   \\\n/* Trailing comment for aa... */\n  bbbbbbbbbbbbbbbbbbbbbbbbb);")));
    EXPECT_EQ("f(aaaaaaaaaaaaaaaaaaaaaaaaa,\n  /* Leading comment for bb... */ bbbbbbbbbbbbbbbbbbbbbbbbb);",format(new StringRef(/*KEEP_STR*/"f(aaaaaaaaaaaaaaaaaaaaaaaaa    ,   \n/* Leading comment for bb... */   bbbbbbbbbbbbbbbbbbbbbbbbb);")));
    EXPECT_EQ("void aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa(\n    aaaaaaaaaaaaaaaaaa,\n    aaaaaaaaaaaaaaaaaa) { /*aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa*/\n}",format(new StringRef(/*KEEP_STR*/"void      aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa(\n                      aaaaaaaaaaaaaaaaaa  ,\n    aaaaaaaaaaaaaaaaaa) {   /*aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa*/\n}")));
    verifyFormat(new StringRef(/*KEEP_STR*/"f(/* aaaaaaaaaaaaaaaaaa = */\n  aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa);"));
    
    NoBinPacking = getLLVMStyle();
    NoBinPacking.BinPackParameters = false;
    verifyFormat(new StringRef(/*KEEP_STR*/"aaaaaaaa(/* parameter 1 */ aaaaaa,\n         /* parameter 2 */ aaaaaa,\n         /* parameter 3 */ aaaaaa,\n         /* parameter 4 */ aaaaaa);"), 
        NoBinPacking);
    
    // Aligning block comments in macros.
    verifyGoogleFormat(new StringRef(/*KEEP_STR*/"#define A        \\\n  int i;   /*a*/ \\\n  int jjj; /*b*/"));
  } finally {
    if (NoBinPacking != null) { NoBinPacking.$destroy(); }
  }
}

;
@Test
//<editor-fold defaultstate="collapsed" desc="clang::format::(anonymous namespace)::FormatTest_AlignsBlockComments_Test::TestBody">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp", line = 1163,
 FQN="clang::format::(anonymous namespace)::FormatTest_AlignsBlockComments_Test::TestBody", NM="_ZN5clang6format12_GLOBAL__N_135FormatTest_AlignsBlockComments_Test8TestBodyEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp -nm=_ZN5clang6format12_GLOBAL__N_135FormatTest_AlignsBlockComments_Test8TestBodyEv")
//</editor-fold>
public void test_AlignsBlockComments() {
  if (markAsSkippedIfNeed(TestState.Successful)) { return; }
    EXPECT_EQ("/*\n * Really multi-line\n * comment.\n */\nvoid f() {}",format(new StringRef(/*KEEP_STR*/"  /*\n   * Really multi-line\n   * comment.\n   */\n  void f() {}")));
    EXPECT_EQ("class C {\n  /*\n   * Another multi-line\n   * comment.\n   */\n  void f() {}\n};",format(new StringRef(/*KEEP_STR*/"class C {\n/*\n * Another multi-line\n * comment.\n */\nvoid f() {}\n};")));
    EXPECT_EQ("/*\n  1. This is a comment with non-trivial formatting.\n     1.1. We have to indent/outdent all lines equally\n         1.1.1. to keep the formatting.\n */",format(new StringRef(/*KEEP_STR*/"  /*\n    1. This is a comment with non-trivial formatting.\n       1.1. We have to indent/outdent all lines equally\n           1.1.1. to keep the formatting.\n   */")));
    EXPECT_EQ("/*\nDon't try to outdent if there's not enough indentation.\n*/",format(new StringRef(/*KEEP_STR*/"  /*\n Don't try to outdent if there's not enough indentation.\n */")));
    EXPECT_EQ("int i; /* Comment with empty...\n        *\n        * line. */",format(new StringRef(/*KEEP_STR*/"int i; /* Comment with empty...\n        *\n        * line. */")));
    EXPECT_EQ("int foobar = 0; /* comment */\nint bar = 0;    /* multiline\n                   comment 1 */\nint baz = 0;    /* multiline\n                   comment 2 */\nint bzz = 0;    /* multiline\n                   comment 3 */",format(new StringRef(/*KEEP_STR*/"int foobar = 0; /* comment */\nint bar = 0;    /* multiline\n                   comment 1 */\nint baz = 0; /* multiline\n                comment 2 */\nint bzz = 0;         /* multiline\n                        comment 3 */")));
    EXPECT_EQ("int foobar = 0; /* comment */\nint bar = 0;    /* multiline\n   comment */\nint baz = 0;    /* multiline\ncomment */",format(new StringRef(/*KEEP_STR*/"int foobar = 0; /* comment */\nint bar = 0; /* multiline\ncomment */\nint baz = 0;        /* multiline\ncomment */")));
}

;
@Test
//<editor-fold defaultstate="collapsed" desc="clang::format::(anonymous namespace)::FormatTest_CommentReflowingCanBeTurnedOff_Test::TestBody">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp", line = 1237,
 FQN="clang::format::(anonymous namespace)::FormatTest_CommentReflowingCanBeTurnedOff_Test::TestBody", NM="_ZN5clang6format12_GLOBAL__N_146FormatTest_CommentReflowingCanBeTurnedOff_Test8TestBodyEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp -nm=_ZN5clang6format12_GLOBAL__N_146FormatTest_CommentReflowingCanBeTurnedOff_Test8TestBodyEv")
//</editor-fold>
public void test_CommentReflowingCanBeTurnedOff() {
  if (markAsSkippedIfNeed(TestState.Successful)) { return; }
  FormatStyle Style = null;
  try {
    Style = getLLVMStyleWithColumns(20);
    Style.ReflowComments = false;
    verifyFormat(new StringRef(/*KEEP_STR*/"// aaaaaaaaa aaaaaaaaaa aaaaaaaaaa"), Style);
    verifyFormat(new StringRef(/*KEEP_STR*/"/* aaaaaaaaa aaaaaaaaaa aaaaaaaaaa */"), Style);
  } finally {
    if (Style != null) { Style.$destroy(); }
  }
}

;
@Test
//<editor-fold defaultstate="collapsed" desc="clang::format::(anonymous namespace)::FormatTest_CorrectlyHandlesLengthOfBlockComments_Test::TestBody">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp", line = 1244,
 FQN="clang::format::(anonymous namespace)::FormatTest_CorrectlyHandlesLengthOfBlockComments_Test::TestBody", NM="_ZN5clang6format12_GLOBAL__N_153FormatTest_CorrectlyHandlesLengthOfBlockComments_Test8TestBodyEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp -nm=_ZN5clang6format12_GLOBAL__N_153FormatTest_CorrectlyHandlesLengthOfBlockComments_Test8TestBodyEv")
//</editor-fold>
public void test_CorrectlyHandlesLengthOfBlockComments() {
  if (markAsSkippedIfNeed(TestState.Successful)) { return; }
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    EXPECT_EQ("double *x; /* aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa\n              aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa */",format(new StringRef(/*KEEP_STR*/"double *x; /* aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa\n              aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa */")));
    EXPECT_EQ("void ffffffffffff(\n    int aaaaaaaa, int bbbbbbbb,\n    int cccccccccccc) { /*\n                           aaaaaaaaaa\n                           aaaaaaaaaaaaa\n                           bbbbbbbbbbbbbb\n                           bbbbbbbbbb\n                         */\n}",$c$.clean(format(new StringRef(/*KEEP_STR*/"void ffffffffffff(int aaaaaaaa, int bbbbbbbb, int cccccccccccc)\n{ /*\n     aaaaaaaaaa aaaaaaaaaaaaa\n     bbbbbbbbbbbbbb bbbbbbbbbb\n   */\n}"), $c$.track(getLLVMStyleWithColumns(40)))));
  } finally {
    $c$.$destroy();
  }
}

;
@Test
//<editor-fold defaultstate="collapsed" desc="clang::format::(anonymous namespace)::FormatTest_DontBreakNonTrailingBlockComments_Test::TestBody">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp", line = 1268,
 FQN="clang::format::(anonymous namespace)::FormatTest_DontBreakNonTrailingBlockComments_Test::TestBody", NM="_ZN5clang6format12_GLOBAL__N_149FormatTest_DontBreakNonTrailingBlockComments_Test8TestBodyEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp -nm=_ZN5clang6format12_GLOBAL__N_149FormatTest_DontBreakNonTrailingBlockComments_Test8TestBodyEv")
//</editor-fold>
public void test_DontBreakNonTrailingBlockComments() {
  if (markAsSkippedIfNeed(TestState.Successful)) { return; }
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    EXPECT_EQ("void ffffffffff(\n    int aaaaa /* test */);",$c$.clean(format(new StringRef(/*KEEP_STR*/"void ffffffffff(int aaaaa /* test */);"), $c$.track(getLLVMStyleWithColumns(35)))));
  } finally {
    $c$.$destroy();
  }
}

;
@Test
//<editor-fold defaultstate="collapsed" desc="clang::format::(anonymous namespace)::FormatTest_SplitsLongCxxComments_Test::TestBody">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp", line = 1275,
 FQN="clang::format::(anonymous namespace)::FormatTest_SplitsLongCxxComments_Test::TestBody", NM="_ZN5clang6format12_GLOBAL__N_137FormatTest_SplitsLongCxxComments_Test8TestBodyEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp -nm=_ZN5clang6format12_GLOBAL__N_137FormatTest_SplitsLongCxxComments_Test8TestBodyEv")
//</editor-fold>
public void test_SplitsLongCxxComments() {
  if (markAsSkippedIfNeed(TestState.Successful)) { return; }
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    EXPECT_EQ("// A comment that\n// doesn't fit on\n// one line",$c$.clean(format(new StringRef(/*KEEP_STR*/"// A comment that doesn't fit on one line"), $c$.track(getLLVMStyleWithColumns(20)))));
    EXPECT_EQ("/// A comment that\n/// doesn't fit on\n/// one line",$c$.clean(format(new StringRef(/*KEEP_STR*/"/// A comment that doesn't fit on one line"), $c$.track(getLLVMStyleWithColumns(20)))));
    EXPECT_EQ("//! A comment that\n//! doesn't fit on\n//! one line",$c$.clean(format(new StringRef(/*KEEP_STR*/"//! A comment that doesn't fit on one line"), $c$.track(getLLVMStyleWithColumns(20)))));
    EXPECT_EQ("// a b c d\n// e f  g\n// h i j k",$c$.clean(format(new StringRef(/*KEEP_STR*/"// a b c d e f  g h i j k"), $c$.track(getLLVMStyleWithColumns(10)))));
    EXPECT_EQ("// a b c d\n// e f  g\n// h i j k",$c$.clean(format(new StringRef(/*KEEP_STR*/"\\\n// a b c d e f  g h i j k"), $c$.track(getLLVMStyleWithColumns(10)))));
    EXPECT_EQ("if (true) // A comment that\n          // doesn't fit on\n          // one line",$c$.clean(format(new StringRef(/*KEEP_STR*/"if (true) // A comment that doesn't fit on one line   "), $c$.track(getLLVMStyleWithColumns(30)))));
    EXPECT_EQ("//    Don't_touch_leading_whitespace",$c$.clean(format(new StringRef(/*KEEP_STR*/"//    Don't_touch_leading_whitespace"), $c$.track(getLLVMStyleWithColumns(20)))));
    EXPECT_EQ("// Add leading\n// whitespace",$c$.clean(format(new StringRef(/*KEEP_STR*/"//Add leading whitespace"), $c$.track(getLLVMStyleWithColumns(20)))));
    EXPECT_EQ("/// Add leading\n/// whitespace",$c$.clean(format(new StringRef(/*KEEP_STR*/"///Add leading whitespace"), $c$.track(getLLVMStyleWithColumns(20)))));
    EXPECT_EQ("//! Add leading\n//! whitespace",$c$.clean(format(new StringRef(/*KEEP_STR*/"//!Add leading whitespace"), $c$.track(getLLVMStyleWithColumns(20)))));
    EXPECT_EQ("// whitespace",$c$.clean(format(new StringRef(/*KEEP_STR*/"//whitespace"), $c$.track(getLLVMStyle()))));
    EXPECT_EQ("// Even if it makes the line exceed the column\n// limit",$c$.clean(format(new StringRef(/*KEEP_STR*/"//Even if it makes the line exceed the column limit"), $c$.track(getLLVMStyleWithColumns(51)))));
    EXPECT_EQ("//--But not here",$c$.clean(format(new StringRef(/*KEEP_STR*/"//--But not here"), $c$.track(getLLVMStyle()))));
    EXPECT_EQ("// aa bb cc dd",$c$.clean(format(new StringRef(/*KEEP_STR*/"// aa bb             cc dd                   "), $c$.track(getLLVMStyleWithColumns(15)))));
    EXPECT_EQ("// A comment before\n// a macro\n// definition\n#define a b",$c$.clean(format(new StringRef(/*KEEP_STR*/"// A comment before a macro definition\n#define a b"), $c$.track(getLLVMStyleWithColumns(20)))));
    EXPECT_EQ("void ffffff(\n    int aaaaaaaaa,  // wwww\n    int bbbbbbbbbb, // xxxxxxx\n                    // yyyyyyyyyy\n    int c, int d, int e) {}",$c$.clean(format(new StringRef(/*KEEP_STR*/"void ffffff(\n    int aaaaaaaaa, // wwww\n    int bbbbbbbbbb, // xxxxxxx yyyyyyyyyy\n    int c, int d, int e) {}"), $c$.track(getLLVMStyleWithColumns(40)))));
    EXPECT_EQ("//\t aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa",$c$.clean(format(new StringRef(/*KEEP_STR*/"//\t aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"), $c$.track(getLLVMStyleWithColumns(20)))));
    EXPECT_EQ("#define XXX // a b c d\n            // e f g h",$c$.clean(format(new StringRef(/*KEEP_STR*/"#define XXX // a b c d e f g h"), $c$.track(getLLVMStyleWithColumns(22)))));
    EXPECT_EQ("#define XXX // q w e r\n            // t y u i",$c$.clean(format(new StringRef(/*KEEP_STR*/"#define XXX //q w e r t y u i"), $c$.track(getLLVMStyleWithColumns(22)))));
  } finally {
    $c$.$destroy();
  }
}

;
@Test
//<editor-fold defaultstate="collapsed" desc="clang::format::(anonymous namespace)::FormatTest_PreservesHangingIndentInCxxComments_Test::TestBody">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp", line = 1358,
 FQN="clang::format::(anonymous namespace)::FormatTest_PreservesHangingIndentInCxxComments_Test::TestBody", NM="_ZN5clang6format12_GLOBAL__N_151FormatTest_PreservesHangingIndentInCxxComments_Test8TestBodyEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp -nm=_ZN5clang6format12_GLOBAL__N_151FormatTest_PreservesHangingIndentInCxxComments_Test8TestBodyEv")
//</editor-fold>
public void test_PreservesHangingIndentInCxxComments() {
  if (markAsSkippedIfNeed(TestState.Successful)) { return; }
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    EXPECT_EQ("//     A comment\n//     that doesn't\n//     fit on one\n//     line",$c$.clean(format(new StringRef(/*KEEP_STR*/"//     A comment that doesn't fit on one line"), $c$.track(getLLVMStyleWithColumns(20)))));
    EXPECT_EQ("///     A comment\n///     that doesn't\n///     fit on one\n///     line",$c$.clean(format(new StringRef(/*KEEP_STR*/"///     A comment that doesn't fit on one line"), $c$.track(getLLVMStyleWithColumns(20)))));
  } finally {
    $c$.$destroy();
  }
}

;
@Test
//<editor-fold defaultstate="collapsed" desc="clang::format::(anonymous namespace)::FormatTest_DontSplitLineCommentsWithEscapedNewlines_Test::TestBody">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp", line = 1373,
 FQN="clang::format::(anonymous namespace)::FormatTest_DontSplitLineCommentsWithEscapedNewlines_Test::TestBody", NM="_ZN5clang6format12_GLOBAL__N_156FormatTest_DontSplitLineCommentsWithEscapedNewlines_Test8TestBodyEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp -nm=_ZN5clang6format12_GLOBAL__N_156FormatTest_DontSplitLineCommentsWithEscapedNewlines_Test8TestBodyEv")
//</editor-fold>
public void test_DontSplitLineCommentsWithEscapedNewlines() {
  if (markAsSkippedIfNeed(TestState.Successful)) { return; }
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    EXPECT_EQ("// aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa\\\n// aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa\\\n// aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa",format(new StringRef(/*KEEP_STR*/"// aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa\\\n// aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa\\\n// aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa")));
    EXPECT_EQ("int a; // AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA\\\n       // AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA\\\n       // AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA",$c$.clean(format(new StringRef(/*KEEP_STR*/"int a; // AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA\\\n       // AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA\\\n       // AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA"), $c$.track(getLLVMStyleWithColumns(50)))));
    // FIXME: One day we might want to implement adjustment of leading whitespace
    // of the consecutive lines in this kind of comment:
    EXPECT_EQ("double\n    a; // AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA\\\n          // AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA\\\n          // AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA",$c$.clean(format(new StringRef(/*KEEP_STR*/"double a; // AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA\\\n          // AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA\\\n          // AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA"), $c$.track(getLLVMStyleWithColumns(49)))));
  } finally {
    $c$.$destroy();
  }
}

;
@Test
//<editor-fold defaultstate="collapsed" desc="clang::format::(anonymous namespace)::FormatTest_DontSplitLineCommentsWithPragmas_Test::TestBody">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp", line = 1399,
 FQN="clang::format::(anonymous namespace)::FormatTest_DontSplitLineCommentsWithPragmas_Test::TestBody", NM="_ZN5clang6format12_GLOBAL__N_148FormatTest_DontSplitLineCommentsWithPragmas_Test8TestBodyEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp -nm=_ZN5clang6format12_GLOBAL__N_148FormatTest_DontSplitLineCommentsWithPragmas_Test8TestBodyEv")
//</editor-fold>
public void test_DontSplitLineCommentsWithPragmas() {
  if (markAsSkippedIfNeed(TestState.Successful)) { return; }
  FormatStyle Pragmas = null;
  try {
    Pragmas = getLLVMStyleWithColumns(30);
    Pragmas.CommentPragmas.$assign_T$C$P(/*KEEP_STR*/"^ IWYU pragma:");
    EXPECT_EQ("// IWYU pragma: aaaaaaaaaaaaaaaaaa bbbbbbbbbbbbbb",format(new StringRef(/*KEEP_STR*/"// IWYU pragma: aaaaaaaaaaaaaaaaaa bbbbbbbbbbbbbb"), Pragmas));
    EXPECT_EQ("/* IWYU pragma: aaaaaaaaaaaaaaaaaa bbbbbbbbbbbbbb */",format(new StringRef(/*KEEP_STR*/"/* IWYU pragma: aaaaaaaaaaaaaaaaaa bbbbbbbbbbbbbb */"), Pragmas));
  } finally {
    if (Pragmas != null) { Pragmas.$destroy(); }
  }
}

;
@Test
//<editor-fold defaultstate="collapsed" desc="clang::format::(anonymous namespace)::FormatTest_PriorityOfCommentBreaking_Test::TestBody">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp", line = 1410,
 FQN="clang::format::(anonymous namespace)::FormatTest_PriorityOfCommentBreaking_Test::TestBody", NM="_ZN5clang6format12_GLOBAL__N_141FormatTest_PriorityOfCommentBreaking_Test8TestBodyEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp -nm=_ZN5clang6format12_GLOBAL__N_141FormatTest_PriorityOfCommentBreaking_Test8TestBodyEv")
//</editor-fold>
public void test_PriorityOfCommentBreaking() {
  if (markAsSkippedIfNeed(TestState.Successful)) { return; }
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    EXPECT_EQ("if (xxx ==\n        yyy && // aaaaaaaaaaaa bbbbbbbbb\n    zzz)\n  q();",$c$.clean(format(new StringRef(/*KEEP_STR*/"if (xxx == yyy && // aaaaaaaaaaaa bbbbbbbbb\n    zzz) q();"), $c$.track(getLLVMStyleWithColumns(40)))));
    EXPECT_EQ("if (xxxxxxxxxx ==\n        yyy && // aaaaaa bbbbbbbb cccc\n    zzz)\n  q();",$c$.clean(format(new StringRef(/*KEEP_STR*/"if (xxxxxxxxxx == yyy && // aaaaaa bbbbbbbb cccc\n    zzz) q();"), $c$.track(getLLVMStyleWithColumns(40)))));
    EXPECT_EQ("if (xxxxxxxxxx &&\n        yyy || // aaaaaa bbbbbbbb cccc\n    zzz)\n  q();",$c$.clean(format(new StringRef(/*KEEP_STR*/"if (xxxxxxxxxx && yyy || // aaaaaa bbbbbbbb cccc\n    zzz) q();"), $c$.track(getLLVMStyleWithColumns(40)))));
    EXPECT_EQ("fffffffff(\n    &xxx, // aaaaaaaaaaaa bbbbbbbbbbb\n    zzz);",$c$.clean(format(new StringRef(/*KEEP_STR*/"fffffffff(&xxx, // aaaaaaaaaaaa bbbbbbbbbbb\n zzz);"), $c$.track(getLLVMStyleWithColumns(40)))));
  } finally {
    $c$.$destroy();
  }
}

;
@Test
//<editor-fold defaultstate="collapsed" desc="clang::format::(anonymous namespace)::FormatTest_MultiLineCommentsInDefines_Test::TestBody">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp", line = 1440,
 FQN="clang::format::(anonymous namespace)::FormatTest_MultiLineCommentsInDefines_Test::TestBody", NM="_ZN5clang6format12_GLOBAL__N_142FormatTest_MultiLineCommentsInDefines_Test8TestBodyEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp -nm=_ZN5clang6format12_GLOBAL__N_142FormatTest_MultiLineCommentsInDefines_Test8TestBodyEv")
//</editor-fold>
public void test_MultiLineCommentsInDefines() {
  if (markAsSkippedIfNeed(TestState.Successful)) { return; }
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    EXPECT_EQ("#define A(x) /* \\\n  a comment     \\\n  inside */     \\\n  f();",$c$.clean(format(new StringRef(/*KEEP_STR*/"#define A(x) /* \\\n  a comment     \\\n  inside */     \\\n  f();"), $c$.track(getLLVMStyleWithColumns(17)))));
    EXPECT_EQ("#define A(      \\\n    x) /*       \\\n  a comment     \\\n  inside */     \\\n  f();",$c$.clean(format(new StringRef(/*KEEP_STR*/"#define A(      \\\n    x) /*       \\\n  a comment     \\\n  inside */     \\\n  f();"), $c$.track(getLLVMStyleWithColumns(17)))));
  } finally {
    $c$.$destroy();
  }
}

;
@Test
//<editor-fold defaultstate="collapsed" desc="clang::format::(anonymous namespace)::FormatTest_ParsesCommentsAdjacentToPPDirectives_Test::TestBody">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp", line = 1463,
 FQN="clang::format::(anonymous namespace)::FormatTest_ParsesCommentsAdjacentToPPDirectives_Test::TestBody", NM="_ZN5clang6format12_GLOBAL__N_152FormatTest_ParsesCommentsAdjacentToPPDirectives_Test8TestBodyEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp -nm=_ZN5clang6format12_GLOBAL__N_152FormatTest_ParsesCommentsAdjacentToPPDirectives_Test8TestBodyEv")
//</editor-fold>
public void test_ParsesCommentsAdjacentToPPDirectives() {
  if (markAsSkippedIfNeed(TestState.Successful)) { return; }
    EXPECT_EQ("namespace {}\n// Test\n#define A",format(new StringRef(/*KEEP_STR*/"namespace {}\n   // Test\n#define A")));
    EXPECT_EQ("namespace {}\n/* Test */\n#define A",format(new StringRef(/*KEEP_STR*/"namespace {}\n   /* Test */\n#define A")));
    EXPECT_EQ("namespace {}\n/* Test */ #define A",format(new StringRef(/*KEEP_STR*/"namespace {}\n   /* Test */    #define A")));
}

;
@Test
//<editor-fold defaultstate="collapsed" desc="clang::format::(anonymous namespace)::FormatTest_SplitsLongLinesInComments_Test::TestBody">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp", line = 1472,
 FQN="clang::format::(anonymous namespace)::FormatTest_SplitsLongLinesInComments_Test::TestBody", NM="_ZN5clang6format12_GLOBAL__N_141FormatTest_SplitsLongLinesInComments_Test8TestBodyEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp -nm=_ZN5clang6format12_GLOBAL__N_141FormatTest_SplitsLongLinesInComments_Test8TestBodyEv")
//</editor-fold>
public void test_SplitsLongLinesInComments() {
  if (markAsSkippedIfNeed(TestState.Successful)) { return; }
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    EXPECT_EQ("/* This is a long\n * comment that\n * doesn't\n * fit on one line.\n */",$c$.clean(format(new StringRef(/*KEEP_STR*/"/* This is a long                                         comment that doesn't                                    fit on one line.  */"), $c$.track(getLLVMStyleWithColumns(20)))));
    EXPECT_EQ("/* a b c d\n * e f  g\n * h i j k\n */",$c$.clean(format(new StringRef(/*KEEP_STR*/"/* a b c d e f  g h i j k */"), $c$.track(getLLVMStyleWithColumns(10)))));
    EXPECT_EQ("/* a b c d\n * e f  g\n * h i j k\n */",$c$.clean(format(new StringRef(/*KEEP_STR*/"\\\n/* a b c d e f  g h i j k */"), $c$.track(getLLVMStyleWithColumns(10)))));
    EXPECT_EQ("/*\nThis is a long\ncomment that doesn't\nfit on one line.\n*/",$c$.clean(format(new StringRef(/*KEEP_STR*/"/*\nThis is a long                                         comment that doesn't                                    fit on one line.                                      \n*/"), $c$.track(getLLVMStyleWithColumns(20)))));
    EXPECT_EQ("/*\n * This is a long\n * comment that\n * doesn't fit on\n * one line.\n */",$c$.clean(format(new StringRef(/*KEEP_STR*/"/*      \n * This is a long    comment that        doesn't fit on      one line.                                            \n */"), $c$.track(getLLVMStyleWithColumns(20)))));
    EXPECT_EQ("/*\n * This_is_a_comment_with_words_that_dont_fit_on_one_line\n * so_it_should_be_broken\n * wherever_a_space_occurs\n */",$c$.clean(format(new StringRef(/*KEEP_STR*/"/*\n * This_is_a_comment_with_words_that_dont_fit_on_one_line    so_it_should_be_broken    wherever_a_space_occurs                             \n */"), $c$.track(getLLVMStyleWithColumns(20)))));
    EXPECT_EQ("/*\n *    This_comment_can_not_be_broken_into_lines\n */",$c$.clean(format(new StringRef(/*KEEP_STR*/"/*\n *    This_comment_can_not_be_broken_into_lines\n */"), $c$.track(getLLVMStyleWithColumns(20)))));
    EXPECT_EQ("{\n  /*\n  This is another\n  long comment that\n  doesn't fit on one\n  line    1234567890\n  */\n}",$c$.clean(format(new StringRef(/*KEEP_STR*/"{\n/*\nThis is another       long comment that   doesn't fit on one  line    1234567890\n*/\n}"), $c$.track(getLLVMStyleWithColumns(20)))));
    EXPECT_EQ("{\n  /*\n   * This        i s\n   * another comment\n   * t hat  doesn' t\n   * fit on one l i\n   * n e\n   */\n}",$c$.clean(format(new StringRef(/*KEEP_STR*/"{\n/*\n * This        i s   another comment   t hat  doesn' t   fit on one l i   n e\n */\n}"), $c$.track(getLLVMStyleWithColumns(20)))));
    EXPECT_EQ("/*\n * This is a long\n * comment that\n * doesn't fit on\n * one line\n */",$c$.clean(format(new StringRef(/*KEEP_STR*/"   /*\n    * This is a long comment that doesn't fit on one line\n    */"), $c$.track(getLLVMStyleWithColumns(20)))));
    EXPECT_EQ("{\n  if (something) /* This is a\n                    long\n                    comment */\n    ;\n}",$c$.clean(format(new StringRef(/*KEEP_STR*/"{\n  if (something) /* This is a long comment */\n    ;\n}"), $c$.track(getLLVMStyleWithColumns(30)))));
    EXPECT_EQ("/* A comment before\n * a macro\n * definition */\n#define a b",$c$.clean(format(new StringRef(/*KEEP_STR*/"/* A comment before a macro definition */\n#define a b"), $c$.track(getLLVMStyleWithColumns(20)))));
    EXPECT_EQ("/* some comment\n     *   a comment\n* that we break\n * another comment\n* we have to break\n* a left comment\n */",$c$.clean(format(new StringRef(/*KEEP_STR*/"  /* some comment\n       *   a comment that we break\n   * another comment we have to break\n* a left comment\n   */"), $c$.track(getLLVMStyleWithColumns(20)))));
    EXPECT_EQ("/**\n * multiline block\n * comment\n *\n */",$c$.clean(format(new StringRef(/*KEEP_STR*/"/**\n * multiline block comment\n *\n */"), $c$.track(getLLVMStyleWithColumns(20)))));
    EXPECT_EQ("/*\n\n\n    */\n",format(new StringRef(/*KEEP_STR*/"  /*       \n      \n               \n      */\n")));
    EXPECT_EQ("/* a a */",$c$.clean(format(new StringRef(/*KEEP_STR*/"/* a a            */"), $c$.track(getLLVMStyleWithColumns(15)))));
    EXPECT_EQ("/* a a bc  */",$c$.clean(format(new StringRef(/*KEEP_STR*/"/* a a            bc  */"), $c$.track(getLLVMStyleWithColumns(15)))));
    EXPECT_EQ("/* aaa aaa\n * aaaaa */",$c$.clean(format(new StringRef(/*KEEP_STR*/"/* aaa aaa aaaaa       */"), $c$.track(getLLVMStyleWithColumns(15)))));
    EXPECT_EQ("/* aaa aaa\n * aaaaa     */",$c$.clean(format(new StringRef(/*KEEP_STR*/"/* aaa aaa aaaaa     */"), $c$.track(getLLVMStyleWithColumns(15)))));
  } finally {
    $c$.$destroy();
  }
}

;
@Test
//<editor-fold defaultstate="collapsed" desc="clang::format::(anonymous namespace)::FormatTest_SplitsLongLinesInCommentsInPreprocessor_Test::TestBody">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp", line = 1650,
 FQN="clang::format::(anonymous namespace)::FormatTest_SplitsLongLinesInCommentsInPreprocessor_Test::TestBody", NM="_ZN5clang6format12_GLOBAL__N_155FormatTest_SplitsLongLinesInCommentsInPreprocessor_Test8TestBodyEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp -nm=_ZN5clang6format12_GLOBAL__N_155FormatTest_SplitsLongLinesInCommentsInPreprocessor_Test8TestBodyEv")
//</editor-fold>
public void test_SplitsLongLinesInCommentsInPreprocessor() {
  if (markAsSkippedIfNeed(TestState.Successful)) { return; }
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    EXPECT_EQ("#define X          \\\n  /*               \\\n   Test            \\\n   Macro comment   \\\n   with a long     \\\n   line            \\\n   */              \\\n  A + B",$c$.clean(format(new StringRef(/*KEEP_STR*/"#define X \\\n  /*\n   Test\n   Macro comment with a long  line\n   */ \\\n  A + B"), $c$.track(getLLVMStyleWithColumns(20)))));
    EXPECT_EQ("#define X          \\\n  /* Macro comment \\\n     with a long   \\\n     line */       \\\n  A + B",$c$.clean(format(new StringRef(/*KEEP_STR*/"#define X \\\n  /* Macro comment with a long\n     line */ \\\n  A + B"), $c$.track(getLLVMStyleWithColumns(20)))));
    EXPECT_EQ("#define X          \\\n  /* Macro comment \\\n   * with a long   \\\n   * line */       \\\n  A + B",$c$.clean(format(new StringRef(/*KEEP_STR*/"#define X \\\n  /* Macro comment with a long  line */ \\\n  A + B"), $c$.track(getLLVMStyleWithColumns(20)))));
  } finally {
    $c$.$destroy();
  }
}

;
@Test
//<editor-fold defaultstate="collapsed" desc="clang::format::(anonymous namespace)::FormatTest_CommentsInStaticInitializers_Test::TestBody">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp", line = 1687,
 FQN="clang::format::(anonymous namespace)::FormatTest_CommentsInStaticInitializers_Test::TestBody", NM="_ZN5clang6format12_GLOBAL__N_144FormatTest_CommentsInStaticInitializers_Test8TestBodyEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp -nm=_ZN5clang6format12_GLOBAL__N_144FormatTest_CommentsInStaticInitializers_Test8TestBodyEv")
//</editor-fold>
public void test_CommentsInStaticInitializers() {
  if (markAsSkippedIfNeed(TestState.Successful)) { return; }
    EXPECT_EQ("static SomeType type = {aaaaaaaaaaaaaaaaaaaa, /* comment */\n                        aaaaaaaaaaaaaaaaaaaa /* comment */,\n                        /* comment */ aaaaaaaaaaaaaaaaaaaa,\n                        aaaaaaaaaaaaaaaaaaaa, // comment\n                        aaaaaaaaaaaaaaaaaaaa};",format(new StringRef(/*KEEP_STR*/"static SomeType type = { aaaaaaaaaaaaaaaaaaaa  ,  /* comment */\n                   aaaaaaaaaaaaaaaaaaaa   /* comment */ ,\n                     /* comment */   aaaaaaaaaaaaaaaaaaaa ,\n              aaaaaaaaaaaaaaaaaaaa ,   // comment\n                  aaaaaaaaaaaaaaaaaaaa };")));
  verifyFormat(new StringRef(/*KEEP_STR*/"static SomeType type = {aaaaaaaaaaa, // comment for aa...\n                        bbbbbbbbbbb, ccccccccccc};"));
  verifyFormat(new StringRef(/*KEEP_STR*/"static SomeType type = {aaaaaaaaaaa,\n                        // comment for bb....\n                        bbbbbbbbbbb, ccccccccccc};"));
  verifyGoogleFormat(new StringRef(/*KEEP_STR*/"static SomeType type = {aaaaaaaaaaa,  // comment for aa...\n                        bbbbbbbbbbb, ccccccccccc};"));
  verifyGoogleFormat(new StringRef(/*KEEP_STR*/"static SomeType type = {aaaaaaaaaaa,\n                        // comment for bb....\n                        bbbbbbbbbbb, ccccccccccc};"));
  
  verifyFormat(new StringRef(/*KEEP_STR*/"S s = {{a, b, c},  // Group #1\n       {d, e, f},  // Group #2\n       {g, h, i}}; // Group #3"));
  verifyFormat(new StringRef(/*KEEP_STR*/"S s = {{// Group #1\n        a, b, c},\n       {// Group #2\n        d, e, f},\n       {// Group #3\n        g, h, i}};"));
    EXPECT_EQ("S s = {\n    // Some comment\n    a,\n\n    // Comment after empty line\n    b}",format(new StringRef(/*KEEP_STR*/"S s =    {\n      // Some comment\n  a,\n  \n     // Comment after empty line\n      b\n}")));
    EXPECT_EQ("S s = {\n    /* Some comment */\n    a,\n\n    /* Comment after empty line */\n    b}",format(new StringRef(/*KEEP_STR*/"S s =    {\n      /* Some comment */\n  a,\n  \n     /* Comment after empty line */\n      b\n}")));
  verifyFormat(new StringRef(/*KEEP_STR*/"const uint8_t aaaaaaaaaaaaaaaaaaaaaa[0] = {\n    0x00, 0x00, 0x00, 0x00, 0x00, 0x00, // comment\n    0x00, 0x00, 0x00, 0x00, 0x00, 0x00, // comment\n    0x00, 0x00, 0x00, 0x00};            // comment\n"));
}

;
@Test
//<editor-fold defaultstate="collapsed" desc="clang::format::(anonymous namespace)::FormatTest_IgnoresIf0Contents_Test::TestBody">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp", line = 1753,
 FQN="clang::format::(anonymous namespace)::FormatTest_IgnoresIf0Contents_Test::TestBody", NM="_ZN5clang6format12_GLOBAL__N_134FormatTest_IgnoresIf0Contents_Test8TestBodyEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp -nm=_ZN5clang6format12_GLOBAL__N_134FormatTest_IgnoresIf0Contents_Test8TestBodyEv")
//</editor-fold>
public void test_IgnoresIf0Contents() {
  if (markAsSkippedIfNeed(TestState.Successful)) { return; }
    EXPECT_EQ("#if 0\n}{)(&*(^%%#%@! fsadj f;ldjs ,:;| <<<>>>][)(][\n#endif\nvoid f() {}",format(new StringRef(/*KEEP_STR*/"#if 0\n}{)(&*(^%%#%@! fsadj f;ldjs ,:;| <<<>>>][)(][\n#endif\nvoid f(  ) {  }")));
    EXPECT_EQ("#if false\nvoid f(  ) {  }\n#endif\nvoid g() {}\n",format(new StringRef(/*KEEP_STR*/"#if false\nvoid f(  ) {  }\n#endif\nvoid g(  ) {  }\n")));
    EXPECT_EQ("enum E {\n  One,\n  Two,\n#if 0\nThree,\n      Four,\n#endif\n  Five\n};",format(new StringRef(/*KEEP_STR*/"enum E {\n  One,Two,\n#if 0\nThree,\n      Four,\n#endif\n  Five};")));
    EXPECT_EQ("enum F {\n  One,\n#if 1\n  Two,\n#if 0\nThree,\n      Four,\n#endif\n  Five\n#endif\n};",format(new StringRef(/*KEEP_STR*/"enum F {\nOne,\n#if 1\nTwo,\n#if 0\nThree,\n      Four,\n#endif\nFive\n#endif\n};")));
    EXPECT_EQ("enum G {\n  One,\n#if 0\nTwo,\n#else\n  Three,\n#endif\n  Four\n};",format(new StringRef(/*KEEP_STR*/"enum G {\nOne,\n#if 0\nTwo,\n#else\nThree,\n#endif\nFour\n};")));
    EXPECT_EQ("enum H {\n  One,\n#if 0\n#ifdef Q\nTwo,\n#else\nThree,\n#endif\n#endif\n  Four\n};",format(new StringRef(/*KEEP_STR*/"enum H {\nOne,\n#if 0\n#ifdef Q\nTwo,\n#else\nThree,\n#endif\n#endif\nFour\n};")));
    EXPECT_EQ("enum I {\n  One,\n#if /* test */ 0 || 1\nTwo,\nThree,\n#endif\n  Four\n};",format(new StringRef(/*KEEP_STR*/"enum I {\nOne,\n#if /* test */ 0 || 1\nTwo,\nThree,\n#endif\nFour\n};")));
    EXPECT_EQ("enum J {\n  One,\n#if 0\n#if 0\nTwo,\n#else\nThree,\n#endif\nFour,\n#endif\n  Five\n};",format(new StringRef(/*KEEP_STR*/"enum J {\nOne,\n#if 0\n#if 0\nTwo,\n#else\nThree,\n#endif\nFour,\n#endif\nFive\n};")));
}


//===----------------------------------------------------------------------===//
// Tests for classes, namespaces, etc.
//===----------------------------------------------------------------------===//
;
@Test
//<editor-fold defaultstate="collapsed" desc="clang::format::(anonymous namespace)::FormatTest_DoesNotBreakSemiAfterClassDecl_Test::TestBody">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp", line = 1894,
 FQN="clang::format::(anonymous namespace)::FormatTest_DoesNotBreakSemiAfterClassDecl_Test::TestBody", NM="_ZN5clang6format12_GLOBAL__N_146FormatTest_DoesNotBreakSemiAfterClassDecl_Test8TestBodyEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp -nm=_ZN5clang6format12_GLOBAL__N_146FormatTest_DoesNotBreakSemiAfterClassDecl_Test8TestBodyEv")
//</editor-fold>
public void test_DoesNotBreakSemiAfterClassDecl() {
  if (markAsSkippedIfNeed(TestState.Successful)) { return; }
  verifyFormat(new StringRef(/*KEEP_STR*/"class A {};"));
}

;
@Test
//<editor-fold defaultstate="collapsed" desc="clang::format::(anonymous namespace)::FormatTest_UnderstandsAccessSpecifiers_Test::TestBody">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp", line = 1898,
 FQN="clang::format::(anonymous namespace)::FormatTest_UnderstandsAccessSpecifiers_Test::TestBody", NM="_ZN5clang6format12_GLOBAL__N_143FormatTest_UnderstandsAccessSpecifiers_Test8TestBodyEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp -nm=_ZN5clang6format12_GLOBAL__N_143FormatTest_UnderstandsAccessSpecifiers_Test8TestBodyEv")
//</editor-fold>
public void test_UnderstandsAccessSpecifiers() {
  if (markAsSkippedIfNeed(TestState.Successful)) { return; }
  verifyFormat(new StringRef(/*KEEP_STR*/"class A {\npublic:\npublic: // comment\nprotected:\nprivate:\n  void f() {}\n};"));
  verifyGoogleFormat(new StringRef(/*KEEP_STR*/"class A {\n public:\n protected:\n private:\n  void f() {}\n};"));
  verifyFormat(new StringRef(/*KEEP_STR*/"class A {\npublic slots:\n  void f1() {}\npublic Q_SLOTS:\n  void f2() {}\nprotected slots:\n  void f3() {}\nprotected Q_SLOTS:\n  void f4() {}\nprivate slots:\n  void f5() {}\nprivate Q_SLOTS:\n  void f6() {}\nsignals:\n  void g1();\nQ_SIGNALS:\n  void g2();\n};"));
  
  // Don't interpret 'signals' the wrong way.
  verifyFormat(new StringRef(/*KEEP_STR*/"signals.set();"));
  verifyFormat(new StringRef(/*KEEP_STR*/"for (Signals signals : f()) {\n}"));
  verifyFormat(new StringRef(/*KEEP_STR*/"{\n  signals.set(); // This needs indentation.\n}"));
}

;
@Test
//<editor-fold defaultstate="collapsed" desc="clang::format::(anonymous namespace)::FormatTest_SeparatesLogicalBlocks_Test::TestBody">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp", line = 1939,
 FQN="clang::format::(anonymous namespace)::FormatTest_SeparatesLogicalBlocks_Test::TestBody", NM="_ZN5clang6format12_GLOBAL__N_138FormatTest_SeparatesLogicalBlocks_Test8TestBodyEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp -nm=_ZN5clang6format12_GLOBAL__N_138FormatTest_SeparatesLogicalBlocks_Test8TestBodyEv")
//</editor-fold>
public void test_SeparatesLogicalBlocks() {
  if (markAsSkippedIfNeed(TestState.Successful)) { return; }
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    EXPECT_EQ("class A {\npublic:\n  void f();\n\nprivate:\n  void g() {}\n  // test\nprotected:\n  int h;\n};",format(new StringRef(/*KEEP_STR*/"class A {\npublic:\nvoid f();\nprivate:\nvoid g() {}\n// test\nprotected:\nint h;\n};")));
    EXPECT_EQ("class A {\nprotected:\npublic:\n  void f();\n};",format(new StringRef(/*KEEP_STR*/"class A {\nprotected:\n\npublic:\n\n  void f();\n};")));
    
    // Even ensure proper spacing inside macros.
    EXPECT_EQ("#define B     \\\n  class A {   \\\n   protected: \\\n   public:    \\\n    void f(); \\\n  };",$c$.clean(format(new StringRef(/*KEEP_STR*/"#define B     \\\n  class A {   \\\n   protected: \\\n              \\\n   public:    \\\n              \\\n    void f(); \\\n  };"), $c$.track(getGoogleStyle()))));
    // But don't remove empty lines after macros ending in access specifiers.
    EXPECT_EQ("#define A private:\n\nint i;",format(new StringRef(/*KEEP_STR*/"#define A         private:\n\nint              i;")));
  } finally {
    $c$.$destroy();
  }
}

;
@Test
//<editor-fold defaultstate="collapsed" desc="clang::format::(anonymous namespace)::FormatTest_FormatsClasses_Test::TestBody">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp", line = 1997,
 FQN="clang::format::(anonymous namespace)::FormatTest_FormatsClasses_Test::TestBody", NM="_ZN5clang6format12_GLOBAL__N_130FormatTest_FormatsClasses_Test8TestBodyEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp -nm=_ZN5clang6format12_GLOBAL__N_130FormatTest_FormatsClasses_Test8TestBodyEv")
//</editor-fold>
public void test_FormatsClasses() {
  if (markAsSkippedIfNeed(TestState.Successful)) { return; }
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    verifyFormat(new StringRef(/*KEEP_STR*/"class A : public B {};"));
    verifyFormat(new StringRef(/*KEEP_STR*/"class A : public ::B {};"));
    
    verifyFormat(new StringRef(/*KEEP_STR*/"class AAAAAAAAAAAAAAAAAAAA : public BBBBBBBBBBBBBBBBBBBBBBBBBBBBBB,\n                             public CCCCCCCCCCCCCCCCCCCCCCCCCCCCCC {};"));
    verifyFormat(new StringRef(/*KEEP_STR*/"class AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA\n    : public BBBBBBBBBBBBBBBBBBBBBBBBBBBBBB,\n      public CCCCCCCCCCCCCCCCCCCCCCCCCCCCCC {};"));
    verifyFormat(new StringRef(/*KEEP_STR*/"class A : public B, public C, public D, public E, public F {};"));
    verifyFormat(new StringRef(/*KEEP_STR*/"class AAAAAAAAAAAA : public B,\n                     public C,\n                     public D,\n                     public E,\n                     public F,\n                     public G {};"));
    
    verifyFormat(new StringRef(/*KEEP_STR*/"class\n    ReallyReallyLongClassName {\n  int i;\n};"), 
        $c$.track(getLLVMStyleWithColumns(32))); $c$.clean();
    verifyFormat(new StringRef(/*KEEP_STR*/"struct aaaaaaaaaaaaa : public aaaaaaaaaaaaaaaaaaa< // break\n                           aaaaaaaaaaaaaaaa> {};"));
    verifyFormat(new StringRef(/*KEEP_STR*/"struct aaaaaaaaaaaaaaaaaaaa\n    : public aaaaaaaaaaaaaaaaaaa<aaaaaaaaaaaaaaaaaaaaa,\n                                 aaaaaaaaaaaaaaaaaaaaaa> {};"));
    verifyFormat(new StringRef(/*KEEP_STR*/"template <class R, class C>\nstruct Aaaaaaaaaaaaaaaaa<R (C::*)(int) const>\n    : Aaaaaaaaaaaaaaaaa<R (C::*)(int)> {};"));
    verifyFormat(new StringRef(/*KEEP_STR*/"class ::A::B {};"));
  } finally {
    $c$.$destroy();
  }
}

;
@Test
//<editor-fold defaultstate="collapsed" desc="clang::format::(anonymous namespace)::FormatTest_FormatsVariableDeclarationsAfterStructOrClass_Test::TestBody">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp", line = 2032,
 FQN="clang::format::(anonymous namespace)::FormatTest_FormatsVariableDeclarationsAfterStructOrClass_Test::TestBody", NM="_ZN5clang6format12_GLOBAL__N_161FormatTest_FormatsVariableDeclarationsAfterStructOrClass_Test8TestBodyEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp -nm=_ZN5clang6format12_GLOBAL__N_161FormatTest_FormatsVariableDeclarationsAfterStructOrClass_Test8TestBodyEv")
//</editor-fold>
public void test_FormatsVariableDeclarationsAfterStructOrClass() {
  if (markAsSkippedIfNeed(TestState.Successful)) { return; }
  verifyFormat(new StringRef(/*KEEP_STR*/"class A {\n} a, b;"));
  verifyFormat(new StringRef(/*KEEP_STR*/"struct A {\n} a, b;"));
  verifyFormat(new StringRef(/*KEEP_STR*/"union A {\n} a;"));
}

;
@Test
//<editor-fold defaultstate="collapsed" desc="clang::format::(anonymous namespace)::FormatTest_FormatsEnum_Test::TestBody">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp", line = 2038,
 FQN="clang::format::(anonymous namespace)::FormatTest_FormatsEnum_Test::TestBody", NM="_ZN5clang6format12_GLOBAL__N_127FormatTest_FormatsEnum_Test8TestBodyEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp -nm=_ZN5clang6format12_GLOBAL__N_127FormatTest_FormatsEnum_Test8TestBodyEv")
//</editor-fold>
public void test_FormatsEnum() {
  if (markAsSkippedIfNeed(TestState.Successful)) { return; }
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    verifyFormat(new StringRef(/*KEEP_STR*/"enum {\n  Zero,\n  One = 1,\n  Two = One + 1,\n  Three = (One + Two),\n  Four = (Zero && (One ^ Two)) | (One << Two),\n  Five = (One, Two, Three, Four, 5)\n};"));
    verifyGoogleFormat(new StringRef(/*KEEP_STR*/"enum {\n  Zero,\n  One = 1,\n  Two = One + 1,\n  Three = (One + Two),\n  Four = (Zero && (One ^ Two)) | (One << Two),\n  Five = (One, Two, Three, Four, 5)\n};"));
    verifyFormat(new StringRef(/*KEEP_STR*/"enum Enum {};"));
    verifyFormat(new StringRef(/*KEEP_STR*/"enum {};"));
    verifyFormat(new StringRef(/*KEEP_STR*/"enum X E {} d;"));
    verifyFormat(new StringRef(/*KEEP_STR*/"enum __attribute__((...)) E {} d;"));
    verifyFormat(new StringRef(/*KEEP_STR*/"enum __declspec__((...)) E {} d;"));
    verifyFormat(new StringRef(/*KEEP_STR*/"enum {\n  Bar = Foo<int, int>::value\n};"), 
        $c$.track(getLLVMStyleWithColumns(30))); $c$.clean();
    
    verifyFormat(new StringRef(/*KEEP_STR*/"enum ShortEnum { A, B, C };"));
    verifyGoogleFormat(new StringRef(/*KEEP_STR*/"enum ShortEnum { A, B, C };"));
    EXPECT_EQ("enum KeepEmptyLines {\n  ONE,\n\n  TWO,\n\n  THREE\n}",format(new StringRef(/*KEEP_STR*/"enum KeepEmptyLines {\n  ONE,\n\n  TWO,\n\n\n  THREE\n}")));
    verifyFormat(new StringRef(/*KEEP_STR*/"enum E { // comment\n  ONE,\n  TWO\n};\nint i;"));
    // Not enums.
    verifyFormat(new StringRef(/*KEEP_STR*/"enum X f() {\n  a();\n  return 42;\n}"));
    verifyFormat(new StringRef(/*KEEP_STR*/"enum X Type::f() {\n  a();\n  return 42;\n}"));
    verifyFormat(new StringRef(/*KEEP_STR*/"enum ::X f() {\n  a();\n  return 42;\n}"));
    verifyFormat(new StringRef(/*KEEP_STR*/"enum ns::X f() {\n  a();\n  return 42;\n}"));
  } finally {
    $c$.$destroy();
  }
}

;
@Test
//<editor-fold defaultstate="collapsed" desc="clang::format::(anonymous namespace)::FormatTest_FormatsEnumsWithErrors_Test::TestBody">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp", line = 2107,
 FQN="clang::format::(anonymous namespace)::FormatTest_FormatsEnumsWithErrors_Test::TestBody", NM="_ZN5clang6format12_GLOBAL__N_138FormatTest_FormatsEnumsWithErrors_Test8TestBodyEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp -nm=_ZN5clang6format12_GLOBAL__N_138FormatTest_FormatsEnumsWithErrors_Test8TestBodyEv")
//</editor-fold>
public void test_FormatsEnumsWithErrors() {
  if (markAsSkippedIfNeed(TestState.Successful)) { return; }
  verifyFormat(new StringRef(/*KEEP_STR*/"enum Type {\n  One = 0; // These semicolons should be commas.\n  Two = 1;\n};"));
  verifyFormat(new StringRef(/*KEEP_STR*/"namespace n {\nenum Type {\n  One,\n  Two, // missing };\n  int i;\n}\nvoid g() {}"));
}

;
@Test
//<editor-fold defaultstate="collapsed" desc="clang::format::(anonymous namespace)::FormatTest_FormatsEnumStruct_Test::TestBody">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp", line = 2121,
 FQN="clang::format::(anonymous namespace)::FormatTest_FormatsEnumStruct_Test::TestBody", NM="_ZN5clang6format12_GLOBAL__N_133FormatTest_FormatsEnumStruct_Test8TestBodyEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp -nm=_ZN5clang6format12_GLOBAL__N_133FormatTest_FormatsEnumStruct_Test8TestBodyEv")
//</editor-fold>
public void test_FormatsEnumStruct() {
  if (markAsSkippedIfNeed(TestState.Successful)) { return; }
  verifyFormat(new StringRef(/*KEEP_STR*/"enum struct {\n  Zero,\n  One = 1,\n  Two = One + 1,\n  Three = (One + Two),\n  Four = (Zero && (One ^ Two)) | (One << Two),\n  Five = (One, Two, Three, Four, 5)\n};"));
  verifyFormat(new StringRef(/*KEEP_STR*/"enum struct Enum {};"));
  verifyFormat(new StringRef(/*KEEP_STR*/"enum struct {};"));
  verifyFormat(new StringRef(/*KEEP_STR*/"enum struct X E {} d;"));
  verifyFormat(new StringRef(/*KEEP_STR*/"enum struct __attribute__((...)) E {} d;"));
  verifyFormat(new StringRef(/*KEEP_STR*/"enum struct __declspec__((...)) E {} d;"));
  verifyFormat(new StringRef(/*KEEP_STR*/"enum struct X f() {\n  a();\n  return 42;\n}"));
}

;
@Test
//<editor-fold defaultstate="collapsed" desc="clang::format::(anonymous namespace)::FormatTest_FormatsEnumClass_Test::TestBody">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp", line = 2138,
 FQN="clang::format::(anonymous namespace)::FormatTest_FormatsEnumClass_Test::TestBody", NM="_ZN5clang6format12_GLOBAL__N_132FormatTest_FormatsEnumClass_Test8TestBodyEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp -nm=_ZN5clang6format12_GLOBAL__N_132FormatTest_FormatsEnumClass_Test8TestBodyEv")
//</editor-fold>
public void test_FormatsEnumClass() {
  if (markAsSkippedIfNeed(TestState.Successful)) { return; }
  verifyFormat(new StringRef(/*KEEP_STR*/"enum class {\n  Zero,\n  One = 1,\n  Two = One + 1,\n  Three = (One + Two),\n  Four = (Zero && (One ^ Two)) | (One << Two),\n  Five = (One, Two, Three, Four, 5)\n};"));
  verifyFormat(new StringRef(/*KEEP_STR*/"enum class Enum {};"));
  verifyFormat(new StringRef(/*KEEP_STR*/"enum class {};"));
  verifyFormat(new StringRef(/*KEEP_STR*/"enum class X E {} d;"));
  verifyFormat(new StringRef(/*KEEP_STR*/"enum class __attribute__((...)) E {} d;"));
  verifyFormat(new StringRef(/*KEEP_STR*/"enum class __declspec__((...)) E {} d;"));
  verifyFormat(new StringRef(/*KEEP_STR*/"enum class X f() {\n  a();\n  return 42;\n}"));
}

;
@Test
//<editor-fold defaultstate="collapsed" desc="clang::format::(anonymous namespace)::FormatTest_FormatsEnumTypes_Test::TestBody">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp", line = 2155,
 FQN="clang::format::(anonymous namespace)::FormatTest_FormatsEnumTypes_Test::TestBody", NM="_ZN5clang6format12_GLOBAL__N_132FormatTest_FormatsEnumTypes_Test8TestBodyEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp -nm=_ZN5clang6format12_GLOBAL__N_132FormatTest_FormatsEnumTypes_Test8TestBodyEv")
//</editor-fold>
public void test_FormatsEnumTypes() {
  if (markAsSkippedIfNeed(TestState.Successful)) { return; }
  verifyFormat(new StringRef(/*KEEP_STR*/"enum X : int {\n  A, // Force multiple lines.\n  B\n};"));
  verifyFormat(new StringRef(/*KEEP_STR*/"enum X : int { A, B };"));
  verifyFormat(new StringRef(/*KEEP_STR*/"enum X : std::uint32_t { A, B };"));
}

;
@Test
//<editor-fold defaultstate="collapsed" desc="clang::format::(anonymous namespace)::FormatTest_FormatsNSEnums_Test::TestBody">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp", line = 2164,
 FQN="clang::format::(anonymous namespace)::FormatTest_FormatsNSEnums_Test::TestBody", NM="_ZN5clang6format12_GLOBAL__N_130FormatTest_FormatsNSEnums_Test8TestBodyEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp -nm=_ZN5clang6format12_GLOBAL__N_130FormatTest_FormatsNSEnums_Test8TestBodyEv")
//</editor-fold>
public void test_FormatsNSEnums() {
  if (markAsSkippedIfNeed(TestState.Successful)) { return; }
  verifyGoogleFormat(new StringRef(/*KEEP_STR*/"typedef NS_ENUM(NSInteger, SomeName) { AAA, BBB }"));
  verifyGoogleFormat(new StringRef(/*KEEP_STR*/"typedef NS_ENUM(NSInteger, MyType) {\n  // Information about someDecentlyLongValue.\n  someDecentlyLongValue,\n  // Information about anotherDecentlyLongValue.\n  anotherDecentlyLongValue,\n  // Information about aThirdDecentlyLongValue.\n  aThirdDecentlyLongValue\n};"));
  verifyGoogleFormat(new StringRef(/*KEEP_STR*/"typedef NS_OPTIONS(NSInteger, MyType) {\n  a = 1,\n  b = 2,\n  c = 3,\n};"));
  verifyGoogleFormat(new StringRef(/*KEEP_STR*/"typedef CF_ENUM(NSInteger, MyType) {\n  a = 1,\n  b = 2,\n  c = 3,\n};"));
  verifyGoogleFormat(new StringRef(/*KEEP_STR*/"typedef CF_OPTIONS(NSInteger, MyType) {\n  a = 1,\n  b = 2,\n  c = 3,\n};"));
}

;
@Test
//<editor-fold defaultstate="collapsed" desc="clang::format::(anonymous namespace)::FormatTest_FormatsBitfields_Test::TestBody">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp", line = 2191,
 FQN="clang::format::(anonymous namespace)::FormatTest_FormatsBitfields_Test::TestBody", NM="_ZN5clang6format12_GLOBAL__N_132FormatTest_FormatsBitfields_Test8TestBodyEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp -nm=_ZN5clang6format12_GLOBAL__N_132FormatTest_FormatsBitfields_Test8TestBodyEv")
//</editor-fold>
public void test_FormatsBitfields() {
  if (markAsSkippedIfNeed(TestState.Successful)) { return; }
  verifyFormat(new StringRef(/*KEEP_STR*/"struct Bitfields {\n  unsigned sClass : 8;\n  unsigned ValueKind : 2;\n};"));
  verifyFormat(new StringRef(/*KEEP_STR*/"struct A {\n  int aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa : 1,\n      bbbbbbbbbbbbbbbbbbbbbbbbb;\n};"));
  verifyFormat(new StringRef(/*KEEP_STR*/"struct MyStruct {\n  uchar data;\n  uchar : 8;\n  uchar : 8;\n  uchar other;\n};"));
}

;
@Test
//<editor-fold defaultstate="collapsed" desc="clang::format::(anonymous namespace)::FormatTest_FormatsNamespaces_Test::TestBody">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp", line = 2208,
 FQN="clang::format::(anonymous namespace)::FormatTest_FormatsNamespaces_Test::TestBody", NM="_ZN5clang6format12_GLOBAL__N_133FormatTest_FormatsNamespaces_Test8TestBodyEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp -nm=_ZN5clang6format12_GLOBAL__N_133FormatTest_FormatsNamespaces_Test8TestBodyEv")
//</editor-fold>
public void test_FormatsNamespaces() {
  if (markAsSkippedIfNeed(TestState.Successful)) { return; }
  FormatStyle Style = null;
  try {
    verifyFormat(new StringRef(/*KEEP_STR*/"namespace some_namespace {\nclass A {};\nvoid f() { f(); }\n}"));
    verifyFormat(new StringRef(/*KEEP_STR*/"namespace {\nclass A {};\nvoid f() { f(); }\n}"));
    verifyFormat(new StringRef(/*KEEP_STR*/"inline namespace X {\nclass A {};\nvoid f() { f(); }\n}"));
    verifyFormat(new StringRef(/*KEEP_STR*/"using namespace some_namespace;\nclass A {};\nvoid f() { f(); }"));
    
    // This code is more common than we thought; if we
    // layout this correctly the semicolon will go into
    // its own line, which is undesirable.
    verifyFormat(new StringRef(/*KEEP_STR*/"namespace {};"));
    verifyFormat(new StringRef(/*KEEP_STR*/"namespace {\nclass A {};\n};"));
    
    verifyFormat(new StringRef(/*KEEP_STR*/"namespace {\nint SomeVariable = 0; // comment\n} // namespace"));
    EXPECT_EQ("#ifndef HEADER_GUARD\n#define HEADER_GUARD\nnamespace my_namespace {\nint i;\n} // my_namespace\n#endif // HEADER_GUARD",format(new StringRef(/*KEEP_STR*/"#ifndef HEADER_GUARD\n #define HEADER_GUARD\n   namespace my_namespace {\nint i;\n}    // my_namespace\n#endif    // HEADER_GUARD")));
    EXPECT_EQ("namespace A::B {\nclass C {};\n}",format(new StringRef(/*KEEP_STR*/"namespace A::B {\nclass C {};\n}")));
    
    Style = getLLVMStyle();
    Style.NamespaceIndentation = FormatStyle.NamespaceIndentationKind.NI_All;
    EXPECT_EQ("namespace out {\n  int i;\n  namespace in {\n    int i;\n  } // namespace\n} // namespace",format(new StringRef(/*KEEP_STR*/"namespace out {\nint i;\nnamespace in {\nint i;\n} // namespace\n} // namespace"), Style));
    
    Style.NamespaceIndentation = FormatStyle.NamespaceIndentationKind.NI_Inner;
    EXPECT_EQ("namespace out {\nint i;\nnamespace in {\n  int i;\n} // namespace\n} // namespace",format(new StringRef(/*KEEP_STR*/"namespace out {\nint i;\nnamespace in {\nint i;\n} // namespace\n} // namespace"), Style));
  } finally {
    if (Style != null) { Style.$destroy(); }
  }
}

;
@Test
//<editor-fold defaultstate="collapsed" desc="clang::format::(anonymous namespace)::FormatTest_FormatsExternC_Test::TestBody">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp", line = 2288,
 FQN="clang::format::(anonymous namespace)::FormatTest_FormatsExternC_Test::TestBody", NM="_ZN5clang6format12_GLOBAL__N_130FormatTest_FormatsExternC_Test8TestBodyEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp -nm=_ZN5clang6format12_GLOBAL__N_130FormatTest_FormatsExternC_Test8TestBodyEv")
//</editor-fold>
public void test_FormatsExternC() {
  if (markAsSkippedIfNeed(TestState.Successful)) { return; }
  verifyFormat(new StringRef(/*KEEP_STR*/"extern \"C\" {\nint a;"));
}

;
@Test
//<editor-fold defaultstate="collapsed" desc="clang::format::(anonymous namespace)::FormatTest_FormatsInlineASM_Test::TestBody">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp", line = 2290,
 FQN="clang::format::(anonymous namespace)::FormatTest_FormatsInlineASM_Test::TestBody", NM="_ZN5clang6format12_GLOBAL__N_132FormatTest_FormatsInlineASM_Test8TestBodyEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp -nm=_ZN5clang6format12_GLOBAL__N_132FormatTest_FormatsInlineASM_Test8TestBodyEv")
//</editor-fold>
public void test_FormatsInlineASM() {
  if (markAsSkippedIfNeed(TestState.Successful)) { return; }
  verifyFormat(new StringRef(/*KEEP_STR*/"asm(\"xyz\" : \"=a\"(a), \"=d\"(b) : \"a\"(data));"));
  verifyFormat(new StringRef(/*KEEP_STR*/"asm(\"nop\" ::: \"memory\");"));
  verifyFormat(new StringRef(/*KEEP_STR*/"asm(\"movq\\t%%rbx, %%rsi\\n\\t\"\n    \"cpuid\\n\\t\"\n    \"xchgq\\t%%rbx, %%rsi\\n\\t\"\n    : \"=a\"(*rEAX), \"=S\"(*rEBX), \"=c\"(*rECX), \"=d\"(*rEDX)\n    : \"a\"(value));"));
    EXPECT_EQ("void NS_InvokeByIndex(void *that, unsigned int methodIndex) {\n  __asm {\n        mov     edx,[that] // vtable in edx\n        mov     eax,methodIndex\n        call    [edx][eax*4] // stdcall\n  }\n}",format(new StringRef(/*KEEP_STR*/"void NS_InvokeByIndex(void *that,   unsigned int methodIndex) {\n    __asm {\n        mov     edx,[that] // vtable in edx\n        mov     eax,methodIndex\n        call    [edx][eax*4] // stdcall\n    }\n}")));
    EXPECT_EQ("_asm {\n  xor eax, eax;\n  cpuid;\n}",format(new StringRef(/*KEEP_STR*/"_asm {\n  xor eax, eax;\n  cpuid;\n}")));
  verifyFormat(new StringRef(/*KEEP_STR*/"void function() {\n  // comment\n  asm(\"\");\n}"));
    EXPECT_EQ("__asm {\n}\nint i;",format(new StringRef(/*KEEP_STR*/"__asm   {\n}\nint   i;")));
}

;
@Test
//<editor-fold defaultstate="collapsed" desc="clang::format::(anonymous namespace)::FormatTest_FormatTryCatch_Test::TestBody">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp", line = 2334,
 FQN="clang::format::(anonymous namespace)::FormatTest_FormatTryCatch_Test::TestBody", NM="_ZN5clang6format12_GLOBAL__N_130FormatTest_FormatTryCatch_Test8TestBodyEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp -nm=_ZN5clang6format12_GLOBAL__N_130FormatTest_FormatTryCatch_Test8TestBodyEv")
//</editor-fold>
public void test_FormatTryCatch() {
  if (markAsSkippedIfNeed(TestState.Successful)) { return; }
  verifyFormat(new StringRef(/*KEEP_STR*/"try {\n  throw a * b;\n} catch (int a) {\n  // Do nothing.\n} catch (...) {\n  exit(42);\n}"));
  
  // Function-level try statements.
  verifyFormat(new StringRef(/*KEEP_STR*/"int f() try { return 4; } catch (...) {\n  return 5;\n}"));
  verifyFormat(new StringRef(/*KEEP_STR*/"class A {\n  int a;\n  A() try : a(0) {\n  } catch (...) {\n    throw;\n  }\n};\n"));
  
  // Incomplete try-catch blocks.
  verifyIncompleteFormat(new StringRef(/*KEEP_STR*/"try {} catch ("));
}

;
@Test
//<editor-fold defaultstate="collapsed" desc="clang::format::(anonymous namespace)::FormatTest_FormatSEHTryCatch_Test::TestBody">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp", line = 2359,
 FQN="clang::format::(anonymous namespace)::FormatTest_FormatSEHTryCatch_Test::TestBody", NM="_ZN5clang6format12_GLOBAL__N_133FormatTest_FormatSEHTryCatch_Test8TestBodyEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp -nm=_ZN5clang6format12_GLOBAL__N_133FormatTest_FormatSEHTryCatch_Test8TestBodyEv")
//</editor-fold>
public void test_FormatSEHTryCatch() {
  if (markAsSkippedIfNeed(TestState.Successful)) { return; }
  verifyFormat(new StringRef(/*KEEP_STR*/"__try {\n  int a = b * c;\n} __except (EXCEPTION_EXECUTE_HANDLER) {\n  // Do nothing.\n}"));
  
  verifyFormat(new StringRef(/*KEEP_STR*/"__try {\n  int a = b * c;\n} __finally {\n  // Do nothing.\n}"));
  
  verifyFormat(new StringRef(/*KEEP_STR*/"DEBUG({\n  __try {\n  } __finally {\n  }\n});\n"));
}

;
@Test
//<editor-fold defaultstate="collapsed" desc="clang::format::(anonymous namespace)::FormatTest_IncompleteTryCatchBlocks_Test::TestBody">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp", line = 2379,
 FQN="clang::format::(anonymous namespace)::FormatTest_IncompleteTryCatchBlocks_Test::TestBody", NM="_ZN5clang6format12_GLOBAL__N_140FormatTest_IncompleteTryCatchBlocks_Test8TestBodyEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp -nm=_ZN5clang6format12_GLOBAL__N_140FormatTest_IncompleteTryCatchBlocks_Test8TestBodyEv")
//</editor-fold>
public void test_IncompleteTryCatchBlocks() {
  if (markAsSkippedIfNeed(TestState.Successful)) { return; }
  verifyFormat(new StringRef(/*KEEP_STR*/"try {\n  f();\n} catch {\n  g();\n}"));
  verifyFormat(new StringRef(/*KEEP_STR*/"try {\n  f();\n} catch (A a) MACRO(x) {\n  g();\n} catch (B b) MACRO(x) {\n  g();\n}"));
}

;
@Test
//<editor-fold defaultstate="collapsed" desc="clang::format::(anonymous namespace)::FormatTest_FormatTryCatchBraceStyles_Test::TestBody">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp", line = 2394,
 FQN="clang::format::(anonymous namespace)::FormatTest_FormatTryCatchBraceStyles_Test::TestBody", NM="_ZN5clang6format12_GLOBAL__N_141FormatTest_FormatTryCatchBraceStyles_Test8TestBodyEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp -nm=_ZN5clang6format12_GLOBAL__N_141FormatTest_FormatTryCatchBraceStyles_Test8TestBodyEv")
//</editor-fold>
public void test_FormatTryCatchBraceStyles() {
  if (markAsSkippedIfNeed(TestState.Successful)) { return; }
  FormatStyle Style = null;
  try {
    Style = getLLVMStyle();
    for (FormatStyle.BraceBreakingStyle BraceStyle : new /*const*/ FormatStyle.BraceBreakingStyle [/*3*/] {
      FormatStyle.BraceBreakingStyle.BS_Attach, FormatStyle.BraceBreakingStyle.BS_Mozilla, 
      FormatStyle.BraceBreakingStyle.BS_WebKit}) {
      Style.BreakBeforeBraces = BraceStyle;
      verifyFormat(new StringRef(/*KEEP_STR*/"try {\n  // something\n} catch (...) {\n  // something\n}"), 
          Style);
    }
    Style.BreakBeforeBraces = FormatStyle.BraceBreakingStyle.BS_Stroustrup;
    verifyFormat(new StringRef(/*KEEP_STR*/"try {\n  // something\n}\ncatch (...) {\n  // something\n}"), 
        Style);
    verifyFormat(new StringRef(/*KEEP_STR*/"__try {\n  // something\n}\n__finally {\n  // something\n}"), 
        Style);
    verifyFormat(new StringRef(/*KEEP_STR*/"@try {\n  // something\n}\n@finally {\n  // something\n}"), 
        Style);
    Style.BreakBeforeBraces = FormatStyle.BraceBreakingStyle.BS_Allman;
    verifyFormat(new StringRef(/*KEEP_STR*/"try\n{\n  // something\n}\ncatch (...)\n{\n  // something\n}"), 
        Style);
    Style.BreakBeforeBraces = FormatStyle.BraceBreakingStyle.BS_GNU;
    verifyFormat(new StringRef(/*KEEP_STR*/"try\n  {\n    // something\n  }\ncatch (...)\n  {\n    // something\n  }"), 
        Style);
    Style.BreakBeforeBraces = FormatStyle.BraceBreakingStyle.BS_Custom;
    Style.BraceWrapping.BeforeCatch = true;
    verifyFormat(new StringRef(/*KEEP_STR*/"try {\n  // something\n}\ncatch (...) {\n  // something\n}"), 
        Style);
  } finally {
    if (Style != null) { Style.$destroy(); }
  }
}

;
@Test
//<editor-fold defaultstate="collapsed" desc="clang::format::(anonymous namespace)::FormatTest_FormatObjCTryCatch_Test::TestBody">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp", line = 2459,
 FQN="clang::format::(anonymous namespace)::FormatTest_FormatObjCTryCatch_Test::TestBody", NM="_ZN5clang6format12_GLOBAL__N_134FormatTest_FormatObjCTryCatch_Test8TestBodyEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp -nm=_ZN5clang6format12_GLOBAL__N_134FormatTest_FormatObjCTryCatch_Test8TestBodyEv")
//</editor-fold>
public void test_FormatObjCTryCatch() {
  if (markAsSkippedIfNeed(TestState.Successful)) { return; }
  verifyFormat(new StringRef(/*KEEP_STR*/"@try {\n  f();\n} @catch (NSException e) {\n  @throw;\n} @finally {\n  exit(42);\n}"));
  verifyFormat(new StringRef(/*KEEP_STR*/"DEBUG({\n  @try {\n  } @finally {\n  }\n});\n"));
}

;
@Test
//<editor-fold defaultstate="collapsed" desc="clang::format::(anonymous namespace)::FormatTest_FormatObjCAutoreleasepool_Test::TestBody">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp", line = 2474,
 FQN="clang::format::(anonymous namespace)::FormatTest_FormatObjCAutoreleasepool_Test::TestBody", NM="_ZN5clang6format12_GLOBAL__N_141FormatTest_FormatObjCAutoreleasepool_Test8TestBodyEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp -nm=_ZN5clang6format12_GLOBAL__N_141FormatTest_FormatObjCAutoreleasepool_Test8TestBodyEv")
//</editor-fold>
public void test_FormatObjCAutoreleasepool() {
  if (markAsSkippedIfNeed(TestState.Successful)) { return; }
  FormatStyle Style = null;
  try {
    Style = getLLVMStyle();
    verifyFormat(new StringRef(/*KEEP_STR*/"@autoreleasepool {\n  f();\n}\n@autoreleasepool {\n  f();\n}\n"), 
        Style);
    Style.BreakBeforeBraces = FormatStyle.BraceBreakingStyle.BS_Allman;
    verifyFormat(new StringRef(/*KEEP_STR*/"@autoreleasepool\n{\n  f();\n}\n@autoreleasepool\n{\n  f();\n}\n"), 
        Style);
  } finally {
    if (Style != null) { Style.$destroy(); }
  }
}

;
@Test
//<editor-fold defaultstate="collapsed" desc="clang::format::(anonymous namespace)::FormatTest_StaticInitializers_Test::TestBody">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp", line = 2495,
 FQN="clang::format::(anonymous namespace)::FormatTest_StaticInitializers_Test::TestBody", NM="_ZN5clang6format12_GLOBAL__N_134FormatTest_StaticInitializers_Test8TestBodyEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp -nm=_ZN5clang6format12_GLOBAL__N_134FormatTest_StaticInitializers_Test8TestBodyEv")
//</editor-fold>
public void test_StaticInitializers() {
  if (markAsSkippedIfNeed(TestState.Successful)) { return; }
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    verifyFormat(new StringRef(/*KEEP_STR*/"static SomeClass SC = {1, 'a'};"));
    
    verifyFormat(new StringRef(/*KEEP_STR*/"static SomeClass WithALoooooooooooooooooooongName = {\n    100000000, \"aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa\"};"));
    
    // Here, everything other than the "}" would fit on a line.
    verifyFormat(new StringRef(/*KEEP_STR*/"static int LooooooooooooooooooooooooongVariable[1] = {\n    10000000000000000000000000};"));
    EXPECT_EQ("S s = {a,\n\n       b};",format(new StringRef(/*KEEP_STR*/"S s = {\n  a,\n\n  b\n};")));
    
    // FIXME: This would fit into the column limit if we'd fit "{ {" on the first
    // line. However, the formatting looks a bit off and this probably doesn't
    // happen often in practice.
    verifyFormat(new StringRef(/*KEEP_STR*/"static int Variable[1] = {\n    {1000000000000000000000000000000000000}};"), 
        $c$.track(getLLVMStyleWithColumns(40))); $c$.clean();
  } finally {
    $c$.$destroy();
  }
}

;
@Test
//<editor-fold defaultstate="collapsed" desc="clang::format::(anonymous namespace)::FormatTest_DesignatedInitializers_Test::TestBody">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp", line = 2522,
 FQN="clang::format::(anonymous namespace)::FormatTest_DesignatedInitializers_Test::TestBody", NM="_ZN5clang6format12_GLOBAL__N_138FormatTest_DesignatedInitializers_Test8TestBodyEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp -nm=_ZN5clang6format12_GLOBAL__N_138FormatTest_DesignatedInitializers_Test8TestBodyEv")
//</editor-fold>
public void test_DesignatedInitializers() {
  if (markAsSkippedIfNeed(TestState.Successful)) { return; }
  verifyFormat(new StringRef(/*KEEP_STR*/"const struct A a = {.a = 1, .b = 2};"));
  verifyFormat(new StringRef(/*KEEP_STR*/"const struct A a = {.aaaaaaaaaa = 1,\n                    .bbbbbbbbbb = 2,\n                    .cccccccccc = 3,\n                    .dddddddddd = 4,\n                    .eeeeeeeeee = 5};"));
  verifyFormat(new StringRef(/*KEEP_STR*/"const struct Aaaaaaaaaaaaaaaa aaaaaaaaaaaaaaaaaa = {\n    .aaaaaaaaaaaaaaaaaaaaaaaaaaa = 1,\n    .bbbbbbbbbbbbbbbbbbbbbbbbbbb = 2,\n    .ccccccccccccccccccccccccccc = 3,\n    .ddddddddddddddddddddddddddd = 4,\n    .eeeeeeeeeeeeeeeeeeeeeeeeeee = 5};"));
  
  verifyGoogleFormat(new StringRef(/*KEEP_STR*/"const struct A a = {.a = 1, .b = 2};"));
}

;
@Test
//<editor-fold defaultstate="collapsed" desc="clang::format::(anonymous namespace)::FormatTest_NestedStaticInitializers_Test::TestBody">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp", line = 2539,
 FQN="clang::format::(anonymous namespace)::FormatTest_NestedStaticInitializers_Test::TestBody", NM="_ZN5clang6format12_GLOBAL__N_140FormatTest_NestedStaticInitializers_Test8TestBodyEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp -nm=_ZN5clang6format12_GLOBAL__N_140FormatTest_NestedStaticInitializers_Test8TestBodyEv")
//</editor-fold>
public void test_NestedStaticInitializers() {
  if (markAsSkippedIfNeed(TestState.Successful)) { return; }
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    verifyFormat(new StringRef(/*KEEP_STR*/"static A x = {{{}}};\n"));
    verifyFormat(new StringRef(/*KEEP_STR*/"static A x = {{{init1, init2, init3, init4},\n               {init1, init2, init3, init4}}};"), 
        $c$.track(getLLVMStyleWithColumns(50))); $c$.clean();
    
    verifyFormat(new StringRef(/*KEEP_STR*/"somes Status::global_reps[3] = {\n    {kGlobalRef, OK_CODE, NULL, NULL, NULL},\n    {kGlobalRef, CANCELLED_CODE, NULL, NULL, NULL},\n    {kGlobalRef, UNKNOWN_CODE, NULL, NULL, NULL}};"), 
        $c$.track(getLLVMStyleWithColumns(60))); $c$.clean();
    verifyGoogleFormat(new StringRef(/*KEEP_STR*/"SomeType Status::global_reps[3] = {\n    {kGlobalRef, OK_CODE, NULL, NULL, NULL},\n    {kGlobalRef, CANCELLED_CODE, NULL, NULL, NULL},\n    {kGlobalRef, UNKNOWN_CODE, NULL, NULL, NULL}};"));
    verifyFormat(new StringRef(/*KEEP_STR*/"CGRect cg_rect = {{rect.fLeft, rect.fTop},\n                  {rect.fRight - rect.fLeft, rect.fBottom - rect.fTop}};"));
    
    verifyFormat(new StringRef(/*KEEP_STR*/"SomeArrayOfSomeType a = {\n    {{1, 2, 3},\n     {1, 2, 3},\n     {111111111111111111111111111111, 222222222222222222222222222222,\n      333333333333333333333333333333},\n     {1, 2, 3},\n     {1, 2, 3}}};"));
    verifyFormat(new StringRef(/*KEEP_STR*/"SomeArrayOfSomeType a = {\n    {{1, 2, 3}},\n    {{1, 2, 3}},\n    {{111111111111111111111111111111, 222222222222222222222222222222,\n      333333333333333333333333333333}},\n    {{1, 2, 3}},\n    {{1, 2, 3}}};"));
    
    verifyFormat(new StringRef(/*KEEP_STR*/"struct {\n  unsigned bit;\n  const char *const name;\n} kBitsToOs[] = {{kOsMac, \"Mac\"},\n                 {kOsWin, \"Windows\"},\n                 {kOsLinux, \"Linux\"},\n                 {kOsCrOS, \"Chrome OS\"}};"));
    verifyFormat(new StringRef(/*KEEP_STR*/"struct {\n  unsigned bit;\n  const char *const name;\n} kBitsToOs[] = {\n    {kOsMac, \"Mac\"},\n    {kOsWin, \"Windows\"},\n    {kOsLinux, \"Linux\"},\n    {kOsCrOS, \"Chrome OS\"},\n};"));
  } finally {
    $c$.$destroy();
  }
}

;
@Test
//<editor-fold defaultstate="collapsed" desc="clang::format::(anonymous namespace)::FormatTest_FormatsSmallMacroDefinitionsInSingleLine_Test::TestBody">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp", line = 2593,
 FQN="clang::format::(anonymous namespace)::FormatTest_FormatsSmallMacroDefinitionsInSingleLine_Test::TestBody", NM="_ZN5clang6format12_GLOBAL__N_156FormatTest_FormatsSmallMacroDefinitionsInSingleLine_Test8TestBodyEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp -nm=_ZN5clang6format12_GLOBAL__N_156FormatTest_FormatsSmallMacroDefinitionsInSingleLine_Test8TestBodyEv")
//</editor-fold>
public void test_FormatsSmallMacroDefinitionsInSingleLine() {
  if (markAsSkippedIfNeed(TestState.Successful)) { return; }
  verifyFormat(new StringRef(/*KEEP_STR*/"#define ALooooooooooooooooooooooooooooooooooooooongMacro(                      \\\n    aLoooooooooooooooooooooooongFuuuuuuuuuuuuuunctiooooooooo)"));
}

;
@Test
//<editor-fold defaultstate="collapsed" desc="clang::format::(anonymous namespace)::FormatTest_DoesNotBreakPureVirtualFunctionDefinition_Test::TestBody">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp", line = 2599,
 FQN="clang::format::(anonymous namespace)::FormatTest_DoesNotBreakPureVirtualFunctionDefinition_Test::TestBody", NM="_ZN5clang6format12_GLOBAL__N_157FormatTest_DoesNotBreakPureVirtualFunctionDefinition_Test8TestBodyEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp -nm=_ZN5clang6format12_GLOBAL__N_157FormatTest_DoesNotBreakPureVirtualFunctionDefinition_Test8TestBodyEv")
//</editor-fold>
public void test_DoesNotBreakPureVirtualFunctionDefinition() {
  if (markAsSkippedIfNeed(TestState.Successful)) { return; }
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    verifyFormat(new StringRef(/*KEEP_STR*/"virtual void write(ELFWriter *writerrr,\n                   OwningPtr<FileOutputBuffer> &buffer) = 0;"));
    
    // Do break defaulted and deleted functions.
    verifyFormat(new StringRef(/*KEEP_STR*/"virtual void ~Deeeeeeeestructor() =\n    default;"), 
        $c$.track(getLLVMStyleWithColumns(40))); $c$.clean();
    verifyFormat(new StringRef(/*KEEP_STR*/"virtual void ~Deeeeeeeestructor() =\n    delete;"), 
        $c$.track(getLLVMStyleWithColumns(40))); $c$.clean();
  } finally {
    $c$.$destroy();
  }
}

;
@Test
//<editor-fold defaultstate="collapsed" desc="clang::format::(anonymous namespace)::FormatTest_BreaksStringLiteralsOnlyInDefine_Test::TestBody">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp", line = 2612,
 FQN="clang::format::(anonymous namespace)::FormatTest_BreaksStringLiteralsOnlyInDefine_Test::TestBody", NM="_ZN5clang6format12_GLOBAL__N_148FormatTest_BreaksStringLiteralsOnlyInDefine_Test8TestBodyEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp -nm=_ZN5clang6format12_GLOBAL__N_148FormatTest_BreaksStringLiteralsOnlyInDefine_Test8TestBodyEv")
//</editor-fold>
public void test_BreaksStringLiteralsOnlyInDefine() {
  if (markAsSkippedIfNeed(TestState.Successful)) { return; }
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    verifyFormat(new StringRef(/*KEEP_STR*/"# 1111 \"/aaaaaaaaa/aaaaaaaaaaaaaaaaaaa/aaaaaaaa.cpp\" 2 3"), 
        $c$.track(getLLVMStyleWithColumns(40))); $c$.clean();
    verifyFormat(new StringRef(/*KEEP_STR*/"#line 11111 \"/aaaaaaaaa/aaaaaaaaaaaaaaaaaaa/aaaaaaaa.cpp\""), 
        $c$.track(getLLVMStyleWithColumns(40))); $c$.clean();
    EXPECT_EQ("#define Q                              \\\n  \"/aaaaaaaaa/aaaaaaaaaaaaaaaaaaa/\"    \\\n  \"aaaaaaaa.cpp\"",$c$.clean(format(new StringRef(/*KEEP_STR*/"#define Q \"/aaaaaaaaa/aaaaaaaaaaaaaaaaaaa/aaaaaaaa.cpp\""), $c$.track(getLLVMStyleWithColumns(40)))));
  } finally {
    $c$.$destroy();
  }
}

;
@Test
//<editor-fold defaultstate="collapsed" desc="clang::format::(anonymous namespace)::FormatTest_UnderstandsLinePPDirective_Test::TestBody">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp", line = 2624,
 FQN="clang::format::(anonymous namespace)::FormatTest_UnderstandsLinePPDirective_Test::TestBody", NM="_ZN5clang6format12_GLOBAL__N_142FormatTest_UnderstandsLinePPDirective_Test8TestBodyEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp -nm=_ZN5clang6format12_GLOBAL__N_142FormatTest_UnderstandsLinePPDirective_Test8TestBodyEv")
//</editor-fold>
public void test_UnderstandsLinePPDirective() {
  if (markAsSkippedIfNeed(TestState.Successful)) { return; }
    EXPECT_EQ("# 123 \"A string literal\"",format(new StringRef(/*KEEP_STR*/"   #     123    \"A string literal\"")));
}

;
@Test
//<editor-fold defaultstate="collapsed" desc="clang::format::(anonymous namespace)::FormatTest_LayoutUnknownPPDirective_Test::TestBody">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp", line = 2629,
 FQN="clang::format::(anonymous namespace)::FormatTest_LayoutUnknownPPDirective_Test::TestBody", NM="_ZN5clang6format12_GLOBAL__N_140FormatTest_LayoutUnknownPPDirective_Test8TestBodyEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp -nm=_ZN5clang6format12_GLOBAL__N_140FormatTest_LayoutUnknownPPDirective_Test8TestBodyEv")
//</editor-fold>
public void test_LayoutUnknownPPDirective() {
  if (markAsSkippedIfNeed(TestState.Successful)) { return; }
    EXPECT_EQ("#;",format(new StringRef(/*KEEP_STR*/"#;")));
  verifyFormat(new StringRef(/*KEEP_STR*/"#\n;\n;\n;"));
}

;
@Test
//<editor-fold defaultstate="collapsed" desc="clang::format::(anonymous namespace)::FormatTest_UnescapedEndOfLineEndsPPDirective_Test::TestBody">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp", line = 2634,
 FQN="clang::format::(anonymous namespace)::FormatTest_UnescapedEndOfLineEndsPPDirective_Test::TestBody", NM="_ZN5clang6format12_GLOBAL__N_149FormatTest_UnescapedEndOfLineEndsPPDirective_Test8TestBodyEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp -nm=_ZN5clang6format12_GLOBAL__N_149FormatTest_UnescapedEndOfLineEndsPPDirective_Test8TestBodyEv")
//</editor-fold>
public void test_UnescapedEndOfLineEndsPPDirective() {
  if (markAsSkippedIfNeed(TestState.Successful)) { return; }
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    EXPECT_EQ("#line 42 \"test\"\n",format(new StringRef(/*KEEP_STR*/"#  \\\n  line  \\\n  42  \\\n  \"test\"\n")));
    EXPECT_EQ("#define A B\n",$c$.clean(format(new StringRef(/*KEEP_STR*/"#  \\\n define  \\\n    A  \\\n       B\n"), $c$.track(getLLVMStyleWithColumns(12)))));
  } finally {
    $c$.$destroy();
  }
}

;
@Test
//<editor-fold defaultstate="collapsed" desc="clang::format::(anonymous namespace)::FormatTest_EndOfFileEndsPPDirective_Test::TestBody">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp", line = 2641,
 FQN="clang::format::(anonymous namespace)::FormatTest_EndOfFileEndsPPDirective_Test::TestBody", NM="_ZN5clang6format12_GLOBAL__N_140FormatTest_EndOfFileEndsPPDirective_Test8TestBodyEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp -nm=_ZN5clang6format12_GLOBAL__N_140FormatTest_EndOfFileEndsPPDirective_Test8TestBodyEv")
//</editor-fold>
public void test_EndOfFileEndsPPDirective() {
  if (markAsSkippedIfNeed(TestState.Successful)) { return; }
    EXPECT_EQ("#line 42 \"test\"",format(new StringRef(/*KEEP_STR*/"#  \\\n  line  \\\n  42  \\\n  \"test\"")));
    EXPECT_EQ("#define A B",format(new StringRef(/*KEEP_STR*/"#  \\\n define  \\\n    A  \\\n       B")));
}

;
@Test
//<editor-fold defaultstate="collapsed" desc="clang::format::(anonymous namespace)::FormatTest_DoesntRemoveUnknownTokens_Test::TestBody">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp", line = 2647,
 FQN="clang::format::(anonymous namespace)::FormatTest_DoesntRemoveUnknownTokens_Test::TestBody", NM="_ZN5clang6format12_GLOBAL__N_141FormatTest_DoesntRemoveUnknownTokens_Test8TestBodyEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp -nm=_ZN5clang6format12_GLOBAL__N_141FormatTest_DoesntRemoveUnknownTokens_Test8TestBodyEv")
//</editor-fold>
public void test_DoesntRemoveUnknownTokens() {
  if (markAsSkippedIfNeed(TestState.Successful)) { return; }
  verifyFormat(new StringRef(/*KEEP_STR*/"#define A \\x20"));
  verifyFormat(new StringRef(/*KEEP_STR*/"#define A \\ x20"));
    EXPECT_EQ("#define A \\ x20",format(new StringRef(/*KEEP_STR*/"#define A \\   x20")));
  verifyFormat(new StringRef(/*KEEP_STR*/"#define A ''"));
  verifyFormat(new StringRef(/*KEEP_STR*/"#define A ''qqq"));
  verifyFormat(new StringRef(/*KEEP_STR*/"#define A `qqq"));
  verifyFormat(new StringRef(/*KEEP_STR*/"f(\"aaaa, bbbb, \"\\\"ccccc\\\"\");"));
    EXPECT_EQ("const char *c = STRINGIFY(\n\\na : b);",format(new StringRef(/*KEEP_STR*/"const char * c = STRINGIFY(\n\\na : b);")));
  
  verifyFormat(new StringRef(/*KEEP_STR*/"a\015\\"));
  verifyFormat(new StringRef(/*KEEP_STR*/"a\013\\"));
  verifyFormat(new StringRef(/*KEEP_STR*/"a\014\\"));
}

;
@Test
//<editor-fold defaultstate="collapsed" desc="clang::format::(anonymous namespace)::FormatTest_IndentsPPDirectiveInReducedSpace_Test::TestBody">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp", line = 2665,
 FQN="clang::format::(anonymous namespace)::FormatTest_IndentsPPDirectiveInReducedSpace_Test::TestBody", NM="_ZN5clang6format12_GLOBAL__N_148FormatTest_IndentsPPDirectiveInReducedSpace_Test8TestBodyEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp -nm=_ZN5clang6format12_GLOBAL__N_148FormatTest_IndentsPPDirectiveInReducedSpace_Test8TestBodyEv")
//</editor-fold>
public void test_IndentsPPDirectiveInReducedSpace() {
  if (markAsSkippedIfNeed(TestState.Successful)) { return; }
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    verifyFormat(new StringRef(/*KEEP_STR*/"#define A(BB)"), $c$.track(getLLVMStyleWithColumns(13))); $c$.clean();
    verifyFormat(new StringRef(/*KEEP_STR*/"#define A( \\\n    BB)"), $c$.track(getLLVMStyleWithColumns(12))); $c$.clean();
    verifyFormat(new StringRef(/*KEEP_STR*/"#define A( \\\n    A, B)"), $c$.track(getLLVMStyleWithColumns(12))); $c$.clean();
    // FIXME: We never break before the macro name.
    verifyFormat(new StringRef(/*KEEP_STR*/"#define AA( \\\n    B)"), $c$.track(getLLVMStyleWithColumns(12))); $c$.clean();
    
    verifyFormat(new StringRef(/*KEEP_STR*/"#define A A\n#define A A"));
    verifyFormat(new StringRef(/*KEEP_STR*/"#define A(X) A\n#define A A"));
    
    verifyFormat(new StringRef(/*KEEP_STR*/"#define Something Other"), $c$.track(getLLVMStyleWithColumns(23))); $c$.clean();
    verifyFormat(new StringRef(/*KEEP_STR*/"#define Something    \\\n  Other"), $c$.track(getLLVMStyleWithColumns(22))); $c$.clean();
  } finally {
    $c$.$destroy();
  }
}

;
@Test
//<editor-fold defaultstate="collapsed" desc="clang::format::(anonymous namespace)::FormatTest_HandlePreprocessorDirectiveContext_Test::TestBody">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp", line = 2679,
 FQN="clang::format::(anonymous namespace)::FormatTest_HandlePreprocessorDirectiveContext_Test::TestBody", NM="_ZN5clang6format12_GLOBAL__N_150FormatTest_HandlePreprocessorDirectiveContext_Test8TestBodyEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp -nm=_ZN5clang6format12_GLOBAL__N_150FormatTest_HandlePreprocessorDirectiveContext_Test8TestBodyEv")
//</editor-fold>
public void test_HandlePreprocessorDirectiveContext() {
  if (markAsSkippedIfNeed(TestState.Successful)) { return; }
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    EXPECT_EQ("// somecomment\n#include \"a.h\"\n#define A(  \\\n    A, B)\n#include \"b.h\"\n// somecomment\n",$c$.clean(format(new StringRef(/*KEEP_STR*/"  // somecomment\n  #include \"a.h\"\n#define A(A,\\\n    B)\n    #include \"b.h\"\n // somecomment\n"), $c$.track(getLLVMStyleWithColumns(13)))));
  } finally {
    $c$.$destroy();
  }
}

;
@Test
//<editor-fold defaultstate="collapsed" desc="clang::format::(anonymous namespace)::FormatTest_LayoutSingleHash_Test::TestBody">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp", line = 2695,
 FQN="clang::format::(anonymous namespace)::FormatTest_LayoutSingleHash_Test::TestBody", NM="_ZN5clang6format12_GLOBAL__N_132FormatTest_LayoutSingleHash_Test8TestBodyEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp -nm=_ZN5clang6format12_GLOBAL__N_132FormatTest_LayoutSingleHash_Test8TestBodyEv")
//</editor-fold>
public void test_LayoutSingleHash() {
  if (markAsSkippedIfNeed(TestState.Successful)) { return; }
    EXPECT_EQ("#\na;",format(new StringRef(/*KEEP_STR*/"#\na;")));
}

;
@Test
//<editor-fold defaultstate="collapsed" desc="clang::format::(anonymous namespace)::FormatTest_LayoutCodeInMacroDefinitions_Test::TestBody">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp", line = 2697,
 FQN="clang::format::(anonymous namespace)::FormatTest_LayoutCodeInMacroDefinitions_Test::TestBody", NM="_ZN5clang6format12_GLOBAL__N_144FormatTest_LayoutCodeInMacroDefinitions_Test8TestBodyEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp -nm=_ZN5clang6format12_GLOBAL__N_144FormatTest_LayoutCodeInMacroDefinitions_Test8TestBodyEv")
//</editor-fold>
public void test_LayoutCodeInMacroDefinitions() {
  if (markAsSkippedIfNeed(TestState.Successful)) { return; }
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    EXPECT_EQ("#define A    \\\n  c;         \\\n  e;\nf;",$c$.clean(format(new StringRef(/*KEEP_STR*/"#define A c; e;\nf;"), $c$.track(getLLVMStyleWithColumns(14)))));
  } finally {
    $c$.$destroy();
  }
}

;
@Test
//<editor-fold defaultstate="collapsed" desc="clang::format::(anonymous namespace)::FormatTest_LayoutRemainingTokens_Test::TestBody">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp", line = 2707,
 FQN="clang::format::(anonymous namespace)::FormatTest_LayoutRemainingTokens_Test::TestBody", NM="_ZN5clang6format12_GLOBAL__N_137FormatTest_LayoutRemainingTokens_Test8TestBodyEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp -nm=_ZN5clang6format12_GLOBAL__N_137FormatTest_LayoutRemainingTokens_Test8TestBodyEv")
//</editor-fold>
public void test_LayoutRemainingTokens() {
  if (markAsSkippedIfNeed(TestState.Successful)) { return; }
    EXPECT_EQ("{}",format(new StringRef(/*KEEP_STR*/"{}")));
}

;
@Test
//<editor-fold defaultstate="collapsed" desc="clang::format::(anonymous namespace)::FormatTest_MacroDefinitionInsideStatement_Test::TestBody">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp", line = 2709,
 FQN="clang::format::(anonymous namespace)::FormatTest_MacroDefinitionInsideStatement_Test::TestBody", NM="_ZN5clang6format12_GLOBAL__N_146FormatTest_MacroDefinitionInsideStatement_Test8TestBodyEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp -nm=_ZN5clang6format12_GLOBAL__N_146FormatTest_MacroDefinitionInsideStatement_Test8TestBodyEv")
//</editor-fold>
public void test_MacroDefinitionInsideStatement() {
  if (markAsSkippedIfNeed(TestState.Successful)) { return; }
    EXPECT_EQ("int x,\n#define A\n    y;",format(new StringRef(/*KEEP_STR*/"int x,\n#define A\ny;")));
}

;
@Test
//<editor-fold defaultstate="collapsed" desc="clang::format::(anonymous namespace)::FormatTest_HashInMacroDefinition_Test::TestBody">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp", line = 2716,
 FQN="clang::format::(anonymous namespace)::FormatTest_HashInMacroDefinition_Test::TestBody", NM="_ZN5clang6format12_GLOBAL__N_137FormatTest_HashInMacroDefinition_Test8TestBodyEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp -nm=_ZN5clang6format12_GLOBAL__N_137FormatTest_HashInMacroDefinition_Test8TestBodyEv")
//</editor-fold>
public void test_HashInMacroDefinition() {
  if (markAsSkippedIfNeed(TestState.Successful)) { return; }
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    EXPECT_EQ("#define A(c) L#c",$c$.clean(format(new StringRef(/*KEEP_STR*/"#define A(c) L#c"), $c$.track(getLLVMStyle()))));
    verifyFormat(new StringRef(/*KEEP_STR*/"#define A \\\n  b #c;"), $c$.track(getLLVMStyleWithColumns(11))); $c$.clean();
    verifyFormat(new StringRef(/*KEEP_STR*/"#define A  \\\n  {        \\\n    f(#c); \\\n  }"), 
        $c$.track(getLLVMStyleWithColumns(11))); $c$.clean();
    
    verifyFormat(new StringRef(/*KEEP_STR*/"#define A(X)         \\\n  void function##X()"), 
        $c$.track(getLLVMStyleWithColumns(22))); $c$.clean();
    
    verifyFormat(new StringRef(/*KEEP_STR*/"#define A(a, b, c)   \\\n  void a##b##c()"), 
        $c$.track(getLLVMStyleWithColumns(22))); $c$.clean();
    
    verifyFormat(new StringRef(/*KEEP_STR*/"#define A void # ## #"), $c$.track(getLLVMStyleWithColumns(22))); $c$.clean();
  } finally {
    $c$.$destroy();
  }
}

;
@Test
//<editor-fold defaultstate="collapsed" desc="clang::format::(anonymous namespace)::FormatTest_RespectWhitespaceInMacroDefinitions_Test::TestBody">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp", line = 2736,
 FQN="clang::format::(anonymous namespace)::FormatTest_RespectWhitespaceInMacroDefinitions_Test::TestBody", NM="_ZN5clang6format12_GLOBAL__N_151FormatTest_RespectWhitespaceInMacroDefinitions_Test8TestBodyEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp -nm=_ZN5clang6format12_GLOBAL__N_151FormatTest_RespectWhitespaceInMacroDefinitions_Test8TestBodyEv")
//</editor-fold>
public void test_RespectWhitespaceInMacroDefinitions() {
  if (markAsSkippedIfNeed(TestState.Successful)) { return; }
    EXPECT_EQ("#define A (x)",format(new StringRef(/*KEEP_STR*/"#define A (x)")));
    EXPECT_EQ("#define A(x)",format(new StringRef(/*KEEP_STR*/"#define A(x)")));
}

;
@Test
//<editor-fold defaultstate="collapsed" desc="clang::format::(anonymous namespace)::FormatTest_EmptyLinesInMacroDefinitions_Test::TestBody">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp", line = 2741,
 FQN="clang::format::(anonymous namespace)::FormatTest_EmptyLinesInMacroDefinitions_Test::TestBody", NM="_ZN5clang6format12_GLOBAL__N_144FormatTest_EmptyLinesInMacroDefinitions_Test8TestBodyEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp -nm=_ZN5clang6format12_GLOBAL__N_144FormatTest_EmptyLinesInMacroDefinitions_Test8TestBodyEv")
//</editor-fold>
public void test_EmptyLinesInMacroDefinitions() {
  if (markAsSkippedIfNeed(TestState.Successful)) { return; }
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    EXPECT_EQ("#define A b;",$c$.clean(format(new StringRef(/*KEEP_STR*/"#define A \\\n          \\\n  b;"), $c$.track(getLLVMStyleWithColumns(25)))));
    EXPECT_EQ("#define A \\\n          \\\n  a;      \\\n  b;",$c$.clean(format(new StringRef(/*KEEP_STR*/"#define A \\\n          \\\n  a;      \\\n  b;"), $c$.track(getLLVMStyleWithColumns(11)))));
    EXPECT_EQ("#define A \\\n  a;      \\\n          \\\n  b;",$c$.clean(format(new StringRef(/*KEEP_STR*/"#define A \\\n  a;      \\\n          \\\n  b;"), $c$.track(getLLVMStyleWithColumns(11)))));
  } finally {
    $c$.$destroy();
  }
}

;
@Test
//<editor-fold defaultstate="collapsed" desc="clang::format::(anonymous namespace)::FormatTest_MacroDefinitionsWithIncompleteCode_Test::TestBody">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp", line = 2766,
 FQN="clang::format::(anonymous namespace)::FormatTest_MacroDefinitionsWithIncompleteCode_Test::TestBody", NM="_ZN5clang6format12_GLOBAL__N_150FormatTest_MacroDefinitionsWithIncompleteCode_Test8TestBodyEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp -nm=_ZN5clang6format12_GLOBAL__N_150FormatTest_MacroDefinitionsWithIncompleteCode_Test8TestBodyEv")
//</editor-fold>
public void test_MacroDefinitionsWithIncompleteCode() {
  if (markAsSkippedIfNeed(TestState.Successful)) { return; }
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    verifyIncompleteFormat(new StringRef(/*KEEP_STR*/"#define A :"));
    verifyFormat(new StringRef(/*KEEP_STR*/"#define SOMECASES  \\\n  case 1:          \\\n  case 2\n"), 
        $c$.track(getLLVMStyleWithColumns(20))); $c$.clean();
    verifyFormat(new StringRef(/*KEEP_STR*/"#define MACRO(a) \\\n  if (a)         \\\n    f();         \\\n  else           \\\n    g()"), 
        $c$.track(getLLVMStyleWithColumns(18))); $c$.clean();
    verifyFormat(new StringRef(/*KEEP_STR*/"#define A template <typename T>"));
    verifyIncompleteFormat(new StringRef(/*KEEP_STR*/"#define STR(x) #x\nf(STR(this_is_a_string_literal{));"));
    verifyFormat(new StringRef(/*KEEP_STR*/"#pragma omp threadprivate( \\\n    y)), // expected-warning"), 
        $c$.track(getLLVMStyleWithColumns(28))); $c$.clean();
    verifyFormat(new StringRef(/*KEEP_STR*/"#d, = };"));
    verifyFormat(new StringRef(/*KEEP_STR*/"#if \"a"));
    verifyIncompleteFormat(new StringRef(/*KEEP_STR*/"({\n#define b     \\\n  }           \\\n  a\na"), 
        $c$.track(getLLVMStyleWithColumns(15))); $c$.clean();
    verifyFormat(new StringRef(/*KEEP_STR*/"#define A     \\\n  {           \\\n    {\n#define B     \\\n  }           \\\n  }"), 
        $c$.track(getLLVMStyleWithColumns(15))); $c$.clean();
    verifyNoCrash(new StringRef(/*KEEP_STR*/"#if a\na(\n#else\n#endif\n{a"));
    verifyNoCrash(new StringRef(/*KEEP_STR*/"a={0,1\n#if a\n#else\n;\n#endif\n}"));
    verifyNoCrash(new StringRef(/*KEEP_STR*/"#if a\na(\n#else\n#endif\n) a {a,b,c,d,f,g};"));
    verifyNoCrash(new StringRef(/*KEEP_STR*/"#ifdef A\n a(\n #else\n #endif\n) = []() {      \n)}"));
  } finally {
    $c$.$destroy();
  }
}

;
@Test
//<editor-fold defaultstate="collapsed" desc="clang::format::(anonymous namespace)::FormatTest_MacrosWithoutTrailingSemicolon_Test::TestBody">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp", line = 2805,
 FQN="clang::format::(anonymous namespace)::FormatTest_MacrosWithoutTrailingSemicolon_Test::TestBody", NM="_ZN5clang6format12_GLOBAL__N_146FormatTest_MacrosWithoutTrailingSemicolon_Test8TestBodyEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp -nm=_ZN5clang6format12_GLOBAL__N_146FormatTest_MacrosWithoutTrailingSemicolon_Test8TestBodyEv")
//</editor-fold>
public void test_MacrosWithoutTrailingSemicolon() {
  if (markAsSkippedIfNeed(TestState.Successful)) { return; }
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    verifyFormat(new StringRef(/*KEEP_STR*/"SOME_TYPE_NAME abc;")); // Gated on the newline.
    EXPECT_EQ("class A : public QObject {\n  Q_OBJECT\n\n  A() {}\n};",format(new StringRef(/*KEEP_STR*/"class A  :  public QObject {\n     Q_OBJECT\n\n  A() {\n}\n}  ;")));
    EXPECT_EQ("MACRO\n/*static*/ int i;",format(new StringRef(/*KEEP_STR*/"MACRO\n /*static*/ int   i;")));
    EXPECT_EQ("SOME_MACRO\nnamespace {\nvoid f();\n}",format(new StringRef(/*KEEP_STR*/"SOME_MACRO\n  namespace    {\nvoid   f(  );\n}")));
    // Only if the identifier contains at least 5 characters.
    EXPECT_EQ("HTTP f();",format(new StringRef(/*KEEP_STR*/"HTTP\nf();")));
    EXPECT_EQ("MACRO\nf();",format(new StringRef(/*KEEP_STR*/"MACRO\nf();")));
    // Only if everything is upper case.
    EXPECT_EQ("class A : public QObject {\n  Q_Object A() {}\n};",format(new StringRef(/*KEEP_STR*/"class A  :  public QObject {\n     Q_Object\n  A() {\n}\n}  ;")));
    
    // Only if the next line can actually start an unwrapped line.
    EXPECT_EQ("SOME_WEIRD_LOG_MACRO << SomeThing;",format(new StringRef(/*KEEP_STR*/"SOME_WEIRD_LOG_MACRO\n<< SomeThing;")));
    
    verifyFormat(new StringRef(/*KEEP_STR*/"VISIT_GL_CALL(GenBuffers, void, (GLsizei n, GLuint* buffers), (n, buffers))\n"), 
        $c$.track(getChromiumStyle(FormatStyle.LanguageKind.LK_Cpp))); $c$.clean();
  } finally {
    $c$.$destroy();
  }
}

;
@Test
//<editor-fold defaultstate="collapsed" desc="clang::format::(anonymous namespace)::FormatTest_MacroCallsWithoutTrailingSemicolon_Test::TestBody">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp", line = 2851,
 FQN="clang::format::(anonymous namespace)::FormatTest_MacroCallsWithoutTrailingSemicolon_Test::TestBody", NM="_ZN5clang6format12_GLOBAL__N_150FormatTest_MacroCallsWithoutTrailingSemicolon_Test8TestBodyEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp -nm=_ZN5clang6format12_GLOBAL__N_150FormatTest_MacroCallsWithoutTrailingSemicolon_Test8TestBodyEv")
//</editor-fold>
public void test_MacroCallsWithoutTrailingSemicolon() {
  if (markAsSkippedIfNeed(TestState.Successful)) { return; }
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    EXPECT_EQ("INITIALIZE_PASS_BEGIN(ScopDetection, \"polly-detect\")\nINITIALIZE_AG_DEPENDENCY(AliasAnalysis)\nINITIALIZE_PASS_DEPENDENCY(DominatorTree)\nclass X {};\nINITIALIZE_PASS_END(ScopDetection, \"polly-detect\")\nint *createScopDetectionPass() { return 0; }",format(new StringRef(/*KEEP_STR*/"  INITIALIZE_PASS_BEGIN(ScopDetection, \"polly-detect\")\n  INITIALIZE_AG_DEPENDENCY(AliasAnalysis)\n  INITIALIZE_PASS_DEPENDENCY(DominatorTree)\n  class X {};\n  INITIALIZE_PASS_END(ScopDetection, \"polly-detect\")\n  int *createScopDetectionPass() { return 0; }")));
    // FIXME: We could probably treat IPC_BEGIN_MESSAGE_MAP/IPC_END_MESSAGE_MAP as
    // braces, so that inner block is indented one level more.
    EXPECT_EQ("int q() {\n  IPC_BEGIN_MESSAGE_MAP(WebKitTestController, message)\n  IPC_MESSAGE_HANDLER(xxx, qqq)\n  IPC_END_MESSAGE_MAP()\n}",format(new StringRef(/*KEEP_STR*/"int q() {\n  IPC_BEGIN_MESSAGE_MAP(WebKitTestController, message)\n    IPC_MESSAGE_HANDLER(xxx, qqq)\n  IPC_END_MESSAGE_MAP()\n}")));
    
    // Same inside macros.
    EXPECT_EQ("#define LIST(L) \\\n  L(A)          \\\n  L(B)          \\\n  L(C)",$c$.clean(format(new StringRef(/*KEEP_STR*/"#define LIST(L) \\\n  L(A) \\\n  L(B) \\\n  L(C)"), $c$.track(getGoogleStyle()))));
    
    // These must not be recognized as macros.
    EXPECT_EQ("int q() {\n  f(x);\n  f(x) {}\n  f(x)->g();\n  f(x)->*g();\n  f(x).g();\n  f(x) = x;\n  f(x) += x;\n  f(x) -= x;\n  f(x) *= x;\n  f(x) /= x;\n  f(x) %= x;\n  f(x) &= x;\n  f(x) |= x;\n  f(x) ^= x;\n  f(x) >>= x;\n  f(x) <<= x;\n  f(x)[y].z();\n  LOG(INFO) << x;\n  ifstream(x) >> x;\n}\n",format(new StringRef(/*KEEP_STR*/"int q() {\n  f(x)\n;\n  f(x)\n {}\n  f(x)\n->g();\n  f(x)\n->*g();\n  f(x)\n.g();\n  f(x)\n = x;\n  f(x)\n += x;\n  f(x)\n -= x;\n  f(x)\n *= x;\n  f(x)\n /= x;\n  f(x)\n %= x;\n  f(x)\n &= x;\n  f(x)\n |= x;\n  f(x)\n ^= x;\n  f(x)\n >>= x;\n  f(x)\n <<= x;\n  f(x)\n[y].z();\n  LOG(INFO)\n << x;\n  ifstream(x)\n >> x;\n}\n")));
    EXPECT_EQ("int q() {\n  F(x)\n  if (1) {\n  }\n  F(x)\n  while (1) {\n  }\n  F(x)\n  G(x);\n  F(x)\n  try {\n    Q();\n  } catch (...) {\n  }\n}\n",format(new StringRef(/*KEEP_STR*/"int q() {\nF(x)\nif (1) {}\nF(x)\nwhile (1) {}\nF(x)\nG(x);\nF(x)\ntry { Q(); } catch (...) {}\n}\n")));
    EXPECT_EQ("class A {\n  A() : t(0) {}\n  A(int i) noexcept() : {}\n  A(X x)\n  try : t(0) {\n  } catch (...) {\n  }\n};",format(new StringRef(/*KEEP_STR*/"class A {\n  A()\n : t(0) {}\n  A(int i)\n noexcept() : {}\n  A(X x)\n  try : t(0) {} catch (...) {}\n};")));
    EXPECT_EQ("class SomeClass {\npublic:\n  SomeClass() EXCLUSIVE_LOCK_FUNCTION(mu_);\n};",format(new StringRef(/*KEEP_STR*/"class SomeClass {\npublic:\n  SomeClass()\n  EXCLUSIVE_LOCK_FUNCTION(mu_);\n};")));
    EXPECT_EQ("class SomeClass {\npublic:\n  SomeClass()\n      EXCLUSIVE_LOCK_FUNCTION(mu_);\n};",$c$.clean(format(new StringRef(/*KEEP_STR*/"class SomeClass {\npublic:\n  SomeClass()\n  EXCLUSIVE_LOCK_FUNCTION(mu_);\n};"), $c$.track(getLLVMStyleWithColumns(40)))));
    
    verifyFormat(new StringRef(/*KEEP_STR*/"MACRO(>)"));
  } finally {
    $c$.$destroy();
  }
}

;
@Test
//<editor-fold defaultstate="collapsed" desc="clang::format::(anonymous namespace)::FormatTest_LayoutMacroDefinitionsStatementsSpanningBlocks_Test::TestBody">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp", line = 2994,
 FQN="clang::format::(anonymous namespace)::FormatTest_LayoutMacroDefinitionsStatementsSpanningBlocks_Test::TestBody", NM="_ZN5clang6format12_GLOBAL__N_162FormatTest_LayoutMacroDefinitionsStatementsSpanningBlocks_Test8TestBodyEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp -nm=_ZN5clang6format12_GLOBAL__N_162FormatTest_LayoutMacroDefinitionsStatementsSpanningBlocks_Test8TestBodyEv")
//</editor-fold>
public void test_LayoutMacroDefinitionsStatementsSpanningBlocks() {
  if (markAsSkippedIfNeed(TestState.Successful)) { return; }
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    verifyFormat(new StringRef(/*KEEP_STR*/"#define A \\\n  f({     \\\n    g();  \\\n  });"), 
        $c$.track(getLLVMStyleWithColumns(11))); $c$.clean();
  } finally {
    $c$.$destroy();
  }
}

;
@Test
//<editor-fold defaultstate="collapsed" desc="clang::format::(anonymous namespace)::FormatTest_IndentPreprocessorDirectivesAtZero_Test::TestBody">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp", line = 3002,
 FQN="clang::format::(anonymous namespace)::FormatTest_IndentPreprocessorDirectivesAtZero_Test::TestBody", NM="_ZN5clang6format12_GLOBAL__N_150FormatTest_IndentPreprocessorDirectivesAtZero_Test8TestBodyEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp -nm=_ZN5clang6format12_GLOBAL__N_150FormatTest_IndentPreprocessorDirectivesAtZero_Test8TestBodyEv")
//</editor-fold>
public void test_IndentPreprocessorDirectivesAtZero() {
  if (markAsSkippedIfNeed(TestState.Successful)) { return; }
    EXPECT_EQ("{\n  {\n#define A\n  }\n}",format(new StringRef(/*KEEP_STR*/"{{\n#define A\n}}")));
}

;
@Test
//<editor-fold defaultstate="collapsed" desc="clang::format::(anonymous namespace)::FormatTest_FormatHashIfNotAtStartOfLine_Test::TestBody">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp", line = 3006,
 FQN="clang::format::(anonymous namespace)::FormatTest_FormatHashIfNotAtStartOfLine_Test::TestBody", NM="_ZN5clang6format12_GLOBAL__N_144FormatTest_FormatHashIfNotAtStartOfLine_Test8TestBodyEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp -nm=_ZN5clang6format12_GLOBAL__N_144FormatTest_FormatHashIfNotAtStartOfLine_Test8TestBodyEv")
//</editor-fold>
public void test_FormatHashIfNotAtStartOfLine() {
  if (markAsSkippedIfNeed(TestState.Successful)) { return; }
  verifyFormat(new StringRef(/*KEEP_STR*/"{\n  { a #c; }\n}"));
}

;
@Test
//<editor-fold defaultstate="collapsed" desc="clang::format::(anonymous namespace)::FormatTest_FormatUnbalancedStructuralElements_Test::TestBody">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp", line = 3010,
 FQN="clang::format::(anonymous namespace)::FormatTest_FormatUnbalancedStructuralElements_Test::TestBody", NM="_ZN5clang6format12_GLOBAL__N_150FormatTest_FormatUnbalancedStructuralElements_Test8TestBodyEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp -nm=_ZN5clang6format12_GLOBAL__N_150FormatTest_FormatUnbalancedStructuralElements_Test8TestBodyEv")
//</editor-fold>
public void test_FormatUnbalancedStructuralElements() {
  if (markAsSkippedIfNeed(TestState.Successful)) { return; }
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    EXPECT_EQ("#define A \\\n  {       \\\n    {\nint i;",$c$.clean(format(new StringRef(/*KEEP_STR*/"#define A { {\nint i;"), $c$.track(getLLVMStyleWithColumns(11)))));
    EXPECT_EQ("#define A \\\n  }       \\\n  }\nint i;",$c$.clean(format(new StringRef(/*KEEP_STR*/"#define A } }\nint i;"), $c$.track(getLLVMStyleWithColumns(11)))));
  } finally {
    $c$.$destroy();
  }
}

;
@Test
//<editor-fold defaultstate="collapsed" desc="clang::format::(anonymous namespace)::FormatTest_EscapedNewlines_Test::TestBody">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp", line = 3017,
 FQN="clang::format::(anonymous namespace)::FormatTest_EscapedNewlines_Test::TestBody", NM="_ZN5clang6format12_GLOBAL__N_131FormatTest_EscapedNewlines_Test8TestBodyEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp -nm=_ZN5clang6format12_GLOBAL__N_131FormatTest_EscapedNewlines_Test8TestBodyEv")
//</editor-fold>
public void test_EscapedNewlines() {
  if (markAsSkippedIfNeed(TestState.Successful)) { return; }
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    EXPECT_EQ("#define A \\\n  int i;  \\\n  int j;",$c$.clean(format(new StringRef(/*KEEP_STR*/"#define A \\\nint i;\\\n  int j;"), $c$.track(getLLVMStyleWithColumns(11)))));
    EXPECT_EQ("#define A\n\nint i;",format(new StringRef(/*KEEP_STR*/"#define A \\\n\n int i;")));
    EXPECT_EQ("template <class T> f();",format(new StringRef(/*KEEP_STR*/"\\\ntemplate <class T> f();")));
    EXPECT_EQ("/* \\  \\  \\\n*/",format(new StringRef(/*KEEP_STR*/"\\\n/* \\  \\  \\\n*/")));
    EXPECT_EQ("<a\n\\\\\n>",format(new StringRef(/*KEEP_STR*/"<a\n\\\\\n>")));
  } finally {
    $c$.$destroy();
  }
}

;
@Test
//<editor-fold defaultstate="collapsed" desc="clang::format::(anonymous namespace)::FormatTest_DontCrashOnBlockComments_Test::TestBody">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp", line = 3027,
 FQN="clang::format::(anonymous namespace)::FormatTest_DontCrashOnBlockComments_Test::TestBody", NM="_ZN5clang6format12_GLOBAL__N_140FormatTest_DontCrashOnBlockComments_Test8TestBodyEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp -nm=_ZN5clang6format12_GLOBAL__N_140FormatTest_DontCrashOnBlockComments_Test8TestBodyEv")
//</editor-fold>
public void test_DontCrashOnBlockComments() {
  if (markAsSkippedIfNeed(TestState.Successful)) { return; }
    EXPECT_EQ("int xxxxxxxxx; /* yyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyy\nzzzzzz\n0*/",format(new StringRef(/*KEEP_STR*/"int xxxxxxxxx;                          /* yyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyy zzzzzz\n0*/")));
}

;
@Test
//<editor-fold defaultstate="collapsed" desc="clang::format::(anonymous namespace)::FormatTest_CalculateSpaceOnConsecutiveLinesInMacro_Test::TestBody">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp", line = 3038,
 FQN="clang::format::(anonymous namespace)::FormatTest_CalculateSpaceOnConsecutiveLinesInMacro_Test::TestBody", NM="_ZN5clang6format12_GLOBAL__N_155FormatTest_CalculateSpaceOnConsecutiveLinesInMacro_Test8TestBodyEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp -nm=_ZN5clang6format12_GLOBAL__N_155FormatTest_CalculateSpaceOnConsecutiveLinesInMacro_Test8TestBodyEv")
//</editor-fold>
public void test_CalculateSpaceOnConsecutiveLinesInMacro() {
  if (markAsSkippedIfNeed(TestState.Successful)) { return; }
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    verifyFormat(new StringRef(/*KEEP_STR*/"#define A \\\n  int v(  \\\n      a); \\\n  int i;"), 
        $c$.track(getLLVMStyleWithColumns(11))); $c$.clean();
  } finally {
    $c$.$destroy();
  }
}

;
@Test
//<editor-fold defaultstate="collapsed" desc="clang::format::(anonymous namespace)::FormatTest_MixingPreprocessorDirectivesAndNormalCode_Test::TestBody">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp", line = 3046,
 FQN="clang::format::(anonymous namespace)::FormatTest_MixingPreprocessorDirectivesAndNormalCode_Test::TestBody", NM="_ZN5clang6format12_GLOBAL__N_157FormatTest_MixingPreprocessorDirectivesAndNormalCode_Test8TestBodyEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp -nm=_ZN5clang6format12_GLOBAL__N_157FormatTest_MixingPreprocessorDirectivesAndNormalCode_Test8TestBodyEv")
//</editor-fold>
public void test_MixingPreprocessorDirectivesAndNormalCode() {
  if (markAsSkippedIfNeed(TestState.Successful)) { return; }
    EXPECT_EQ("#define ALooooooooooooooooooooooooooooooooooooooongMacro(                      \\\n    aLoooooooooooooooooooooooongFuuuuuuuuuuuuuunctiooooooooo)\n\nAlooooooooooooooooooooooooooooooooooooooongCaaaaaaaaaal(\n    aLooooooooooooooooooooooonPaaaaaaaaaaaaaaaaaaaaarmmmm);\n",format(new StringRef(/*KEEP_STR*/"  #define   ALooooooooooooooooooooooooooooooooooooooongMacro(\\\naLoooooooooooooooooooooooongFuuuuuuuuuuuuuunctiooooooooo)\n  \n   AlooooooooooooooooooooooooooooooooooooooongCaaaaaaaaaal(\n  aLooooooooooooooooooooooonPaaaaaaaaaaaaaaaaaaaaarmmmm);\n")));
}

;
@Test
//<editor-fold defaultstate="collapsed" desc="clang::format::(anonymous namespace)::FormatTest_LayoutStatementsAroundPreprocessorDirectives_Test::TestBody">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp", line = 3062,
 FQN="clang::format::(anonymous namespace)::FormatTest_LayoutStatementsAroundPreprocessorDirectives_Test::TestBody", NM="_ZN5clang6format12_GLOBAL__N_160FormatTest_LayoutStatementsAroundPreprocessorDirectives_Test8TestBodyEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp -nm=_ZN5clang6format12_GLOBAL__N_160FormatTest_LayoutStatementsAroundPreprocessorDirectives_Test8TestBodyEv")
//</editor-fold>
public void test_LayoutStatementsAroundPreprocessorDirectives() {
  if (markAsSkippedIfNeed(TestState.Successful)) { return; }
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    EXPECT_EQ("int\n#define A\n    a;",format(new StringRef(/*KEEP_STR*/"int\n#define A\na;")));
    verifyFormat(new StringRef(/*KEEP_STR*/"functionCallTo(\n    someOtherFunction(\n        withSomeParameters, whichInSequence,\n        areLongerThanALine(andAnotherCall,\n#define A B\n                           withMoreParamters,\n                           whichStronglyInfluenceTheLayout),\n        andMoreParameters),\n    trailing);"), 
        $c$.track(getLLVMStyleWithColumns(69)));$c$.clean();
    verifyFormat(new StringRef(/*KEEP_STR*/"Foo::Foo()\n#ifdef BAR\n    : baz(0)\n#endif\n{\n}"));
    verifyFormat(new StringRef(/*KEEP_STR*/"void f() {\n  if (true)\n#ifdef A\n    f(42);\n  x();\n#else\n    g();\n  x();\n#endif\n}"));
    verifyFormat(new StringRef(/*KEEP_STR*/"void f(param1, param2,\n       param3,\n#ifdef A\n       param4(param5,\n#ifdef A1\n              param6,\n#ifdef A2\n              param7),\n#else\n              param8),\n       param9,\n#endif\n       param10,\n#endif\n       param11)\n#else\n       param12)\n#endif\n{\n  x();\n}"), 
        $c$.track(getLLVMStyleWithColumns(28)));$c$.clean();
    verifyFormat(new StringRef(/*KEEP_STR*/"#if 1\nint i;"));
    verifyFormat(new StringRef(/*KEEP_STR*/"#if 1\n#endif\n#if 1\n#else\n#endif\n"));
    verifyFormat(new StringRef(/*KEEP_STR*/"DEBUG({\n  return aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa +\n         aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa;\n});\n#if a\n#else\n#endif"));
    
    verifyIncompleteFormat(new StringRef(/*KEEP_STR*/"void f(\n#if A\n    );\n#else\n#endif"));
  } finally {
    $c$.$destroy();
  }
}

;
@Test
//<editor-fold defaultstate="collapsed" desc="clang::format::(anonymous namespace)::FormatTest_GraciouslyHandleIncorrectPreprocessorConditions_Test::TestBody">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp", line = 3137,
 FQN="clang::format::(anonymous namespace)::FormatTest_GraciouslyHandleIncorrectPreprocessorConditions_Test::TestBody", NM="_ZN5clang6format12_GLOBAL__N_163FormatTest_GraciouslyHandleIncorrectPreprocessorConditions_Test8TestBodyEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp -nm=_ZN5clang6format12_GLOBAL__N_163FormatTest_GraciouslyHandleIncorrectPreprocessorConditions_Test8TestBodyEv")
//</editor-fold>
public void test_GraciouslyHandleIncorrectPreprocessorConditions() {
  if (markAsSkippedIfNeed(TestState.Successful)) { return; }
  verifyFormat(new StringRef(/*KEEP_STR*/"#endif\n#if B"));
}

;
@Test
//<editor-fold defaultstate="collapsed" desc="clang::format::(anonymous namespace)::FormatTest_FormatsJoinedLinesOnSubsequentRuns_Test::TestBody">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp", line = 3142,
 FQN="clang::format::(anonymous namespace)::FormatTest_FormatsJoinedLinesOnSubsequentRuns_Test::TestBody", NM="_ZN5clang6format12_GLOBAL__N_150FormatTest_FormatsJoinedLinesOnSubsequentRuns_Test8TestBodyEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp -nm=_ZN5clang6format12_GLOBAL__N_150FormatTest_FormatsJoinedLinesOnSubsequentRuns_Test8TestBodyEv")
//</editor-fold>
public void test_FormatsJoinedLinesOnSubsequentRuns() {
  if (markAsSkippedIfNeed(TestState.Successful)) { return; }
  FormatStyle SingleLine = null;
  try {
    SingleLine = getLLVMStyle();
    SingleLine.AllowShortIfStatementsOnASingleLine = true;
    verifyFormat(new StringRef(/*KEEP_STR*/"#if 0\n#elif 1\n#endif\nvoid foo() {\n  if (test) foo2();\n}"), 
        SingleLine);
  } finally {
    if (SingleLine != null) { SingleLine.$destroy(); }
  }
}

;
@Test
//<editor-fold defaultstate="collapsed" desc="clang::format::(anonymous namespace)::FormatTest_LayoutBlockInsideParens_Test::TestBody">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp", line = 3154,
 FQN="clang::format::(anonymous namespace)::FormatTest_LayoutBlockInsideParens_Test::TestBody", NM="_ZN5clang6format12_GLOBAL__N_139FormatTest_LayoutBlockInsideParens_Test8TestBodyEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp -nm=_ZN5clang6format12_GLOBAL__N_139FormatTest_LayoutBlockInsideParens_Test8TestBodyEv")
//</editor-fold>
public void test_LayoutBlockInsideParens() {
  if (markAsSkippedIfNeed(TestState.Successful)) { return; }
  verifyFormat(new StringRef(/*KEEP_STR*/"functionCall({ int i; });"));
  verifyFormat(new StringRef(/*KEEP_STR*/"functionCall({\n  int i;\n  int j;\n});"));
  verifyFormat(new StringRef(/*KEEP_STR*/"functionCall(\n    {\n      int i;\n      int j;\n    },\n    aaaa, bbbb, cccc);"));
  verifyFormat(new StringRef(/*KEEP_STR*/"functionA(functionB({\n            int i;\n            int j;\n          }),\n          aaaa, bbbb, cccc);"));
  verifyFormat(new StringRef(/*KEEP_STR*/"functionCall(\n    {\n      int i;\n      int j;\n    },\n    aaaa, bbbb, // comment\n    cccc);"));
  verifyFormat(new StringRef(/*KEEP_STR*/"functionA(functionB({\n            int i;\n            int j;\n          }),\n          aaaa, bbbb, // comment\n          cccc);"));
  verifyFormat(new StringRef(/*KEEP_STR*/"functionCall(aaaa, bbbb, { int i; });"));
  verifyFormat(new StringRef(/*KEEP_STR*/"functionCall(aaaa, bbbb, {\n  int i;\n  int j;\n});"));
  verifyFormat(new StringRef(/*KEEP_STR*/"Aaa(\n    {\n      int i; // break\n    },\n    aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa(bbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbb,\n                                     ccccccccccccccccc));"));
  verifyFormat(new StringRef(/*KEEP_STR*/"DEBUG({\n  if (a)\n    f();\n});"));
}

;
@Test
//<editor-fold defaultstate="collapsed" desc="clang::format::(anonymous namespace)::FormatTest_LayoutBlockInsideStatement_Test::TestBody">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp", line = 3202,
 FQN="clang::format::(anonymous namespace)::FormatTest_LayoutBlockInsideStatement_Test::TestBody", NM="_ZN5clang6format12_GLOBAL__N_142FormatTest_LayoutBlockInsideStatement_Test8TestBodyEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp -nm=_ZN5clang6format12_GLOBAL__N_142FormatTest_LayoutBlockInsideStatement_Test8TestBodyEv")
//</editor-fold>
public void test_LayoutBlockInsideStatement() {
  if (markAsSkippedIfNeed(TestState.Successful)) { return; }
    EXPECT_EQ("SOME_MACRO { int i; }\nint i;",format(new StringRef(/*KEEP_STR*/"  SOME_MACRO  {int i;}  int i;")));
}

;
@Test
//<editor-fold defaultstate="collapsed" desc="clang::format::(anonymous namespace)::FormatTest_LayoutNestedBlocks_Test::TestBody">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp", line = 3208,
 FQN="clang::format::(anonymous namespace)::FormatTest_LayoutNestedBlocks_Test::TestBody", NM="_ZN5clang6format12_GLOBAL__N_134FormatTest_LayoutNestedBlocks_Test8TestBodyEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp -nm=_ZN5clang6format12_GLOBAL__N_134FormatTest_LayoutNestedBlocks_Test8TestBodyEv")
//</editor-fold>
public void test_LayoutNestedBlocks() {
  if (markAsSkippedIfNeed(TestState.Successful)) { return; }
  FormatStyle Style = null;
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    verifyFormat(new StringRef(/*KEEP_STR*/"void AddOsStrings(unsigned bitmask) {\n  struct s {\n    int i;\n  };\n  s kBitsToOs[] = {{10}};\n  for (int i = 0; i < 10; ++i)\n    return;\n}"));
    verifyFormat(new StringRef(/*KEEP_STR*/"call(parameter, {\n  something();\n  // Comment using all columns.\n  somethingelse();\n});"), 
        $c$.track(getLLVMStyleWithColumns(40))); $c$.clean();
    verifyFormat(new StringRef(/*KEEP_STR*/"DEBUG( //\n    { f(); }, a);"));
    verifyFormat(new StringRef(/*KEEP_STR*/"DEBUG( //\n    {\n      f(); //\n    },\n    a);"));
    EXPECT_EQ("call(parameter, {\n  something();\n  // Comment too\n  // looooooooooong.\n  somethingElse();\n});",$c$.clean(format(new StringRef(/*KEEP_STR*/"call(parameter, {\n  something();\n  // Comment too looooooooooong.\n  somethingElse();\n});"), $c$.track(getLLVMStyleWithColumns(29)))));
    EXPECT_EQ("DEBUG({ int i; });",format(new StringRef(/*KEEP_STR*/"DEBUG({ int   i; });")));
    EXPECT_EQ("DEBUG({ // comment\n  int i;\n});",format(new StringRef(/*KEEP_STR*/"DEBUG({ // comment\nint  i;\n});")));
    EXPECT_EQ("DEBUG({\n  int i;\n\n  // comment\n  int j;\n});",format(new StringRef(/*KEEP_STR*/"DEBUG({\n  int  i;\n\n  // comment\n  int  j;\n});")));
    
    verifyFormat(new StringRef(/*KEEP_STR*/"DEBUG({\n  if (a)\n    return;\n});"));
    verifyGoogleFormat(new StringRef(/*KEEP_STR*/"DEBUG({\n  if (a) return;\n});"));
    Style = getGoogleStyle();
    Style.ColumnLimit = 45;
    verifyFormat(new StringRef(/*KEEP_STR*/"Debug(aaaaa,\n      {\n        if (aaaaaaaaaaaaaaaaaaaaaaaa) return;\n      },\n      a);"), 
        Style);
    
    verifyFormat(new StringRef(/*KEEP_STR*/"SomeFunction({MACRO({ return output; }), b});"));
    
    verifyNoCrash(new StringRef(/*KEEP_STR*/"^{v^{a}}"));
  } finally {
    if (Style != null) { Style.$destroy(); }
    $c$.$destroy();
  }
}

;
@Test
//<editor-fold defaultstate="collapsed" desc="clang::format::(anonymous namespace)::FormatTest_FormatNestedBlocksInMacros_Test::TestBody">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp", line = 3284,
 FQN="clang::format::(anonymous namespace)::FormatTest_FormatNestedBlocksInMacros_Test::TestBody", NM="_ZN5clang6format12_GLOBAL__N_142FormatTest_FormatNestedBlocksInMacros_Test8TestBodyEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp -nm=_ZN5clang6format12_GLOBAL__N_142FormatTest_FormatNestedBlocksInMacros_Test8TestBodyEv")
//</editor-fold>
public void test_FormatNestedBlocksInMacros() {
  if (markAsSkippedIfNeed(TestState.Successful)) { return; }
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    EXPECT_EQ("#define MACRO()                     \\\n  Debug(aaa, /* force line break */ \\\n        {                           \\\n          int i;                    \\\n          int j;                    \\\n        })",$c$.clean(format(new StringRef(/*KEEP_STR*/"#define   MACRO()   Debug(aaa,  /* force line break */ \\\n          {  int   i;  int  j;   })"), $c$.track(getGoogleStyle()))));
    EXPECT_EQ("#define A                                       \\\n  [] {                                          \\\n    xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx(        \\\n        xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx); \\\n  }",$c$.clean(format(new StringRef(/*KEEP_STR*/"#define A [] { xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx( \\\nxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx); }"), $c$.track(getGoogleStyle()))));
  } finally {
    $c$.$destroy();
  }
}

;
@Test
//<editor-fold defaultstate="collapsed" desc="clang::format::(anonymous namespace)::FormatTest_PutEmptyBlocksIntoOneLine_Test::TestBody">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp", line = 3305,
 FQN="clang::format::(anonymous namespace)::FormatTest_PutEmptyBlocksIntoOneLine_Test::TestBody", NM="_ZN5clang6format12_GLOBAL__N_141FormatTest_PutEmptyBlocksIntoOneLine_Test8TestBodyEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp -nm=_ZN5clang6format12_GLOBAL__N_141FormatTest_PutEmptyBlocksIntoOneLine_Test8TestBodyEv")
//</editor-fold>
public void test_PutEmptyBlocksIntoOneLine() {
  if (markAsSkippedIfNeed(TestState.Successful)) { return; }
    EXPECT_EQ("{}",format(new StringRef(/*KEEP_STR*/"{}")));
  verifyFormat(new StringRef(/*KEEP_STR*/"enum E {};"));
  verifyFormat(new StringRef(/*KEEP_STR*/"enum E {}"));
}

;
@Test
//<editor-fold defaultstate="collapsed" desc="clang::format::(anonymous namespace)::FormatTest_FormatBeginBlockEndMacros_Test::TestBody">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp", line = 3311,
 FQN="clang::format::(anonymous namespace)::FormatTest_FormatBeginBlockEndMacros_Test::TestBody", NM="_ZN5clang6format12_GLOBAL__N_141FormatTest_FormatBeginBlockEndMacros_Test8TestBodyEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp -nm=_ZN5clang6format12_GLOBAL__N_141FormatTest_FormatBeginBlockEndMacros_Test8TestBodyEv")
//</editor-fold>
public void test_FormatBeginBlockEndMacros() {
  if (markAsSkippedIfNeed(TestState.Successful)) { return; }
  FormatStyle Style = null;
  try {
    Style = getLLVMStyle();
    Style.MacroBlockBegin.$assign_T$C$P(/*KEEP_STR*/"^[A-Z_]+_BEGIN$");
    Style.MacroBlockEnd.$assign_T$C$P(/*KEEP_STR*/"^[A-Z_]+_END$");
    verifyFormat(new StringRef(/*KEEP_STR*/"FOO_BEGIN\n  FOO_ENTRY\nFOO_END"), Style);
    verifyFormat(new StringRef(/*KEEP_STR*/"FOO_BEGIN\n  NESTED_FOO_BEGIN\n    NESTED_FOO_ENTRY\n  NESTED_FOO_END\nFOO_END"), Style);
    verifyFormat(new StringRef(/*KEEP_STR*/"FOO_BEGIN(Foo, Bar)\n  int x;\n  x = 1;\nFOO_END(Baz)"), Style);
  } finally {
    if (Style != null) { Style.$destroy(); }
  }
}


//===----------------------------------------------------------------------===//
// Line break tests.
//===----------------------------------------------------------------------===//
;
@Test
//<editor-fold defaultstate="collapsed" desc="clang::format::(anonymous namespace)::FormatTest_PreventConfusingIndents_Test::TestBody">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp", line = 3333,
 FQN="clang::format::(anonymous namespace)::FormatTest_PreventConfusingIndents_Test::TestBody", NM="_ZN5clang6format12_GLOBAL__N_139FormatTest_PreventConfusingIndents_Test8TestBodyEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp -nm=_ZN5clang6format12_GLOBAL__N_139FormatTest_PreventConfusingIndents_Test8TestBodyEv")
//</editor-fold>
public void test_PreventConfusingIndents() {
  if (markAsSkippedIfNeed(TestState.Successful)) { return; }
  verifyFormat(new StringRef(/*KEEP_STR*/"void f() {\n  SomeLongMethodName(SomeReallyLongMethod(CallOtherReallyLongMethod(\n                         parameter, parameter, parameter)),\n                     SecondLongCall(parameter));\n}"));
  verifyFormat(new StringRef(/*KEEP_STR*/"aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa(\n    aaaaaaaaaaaaaaaaaaaaaaaa(\n        aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa),\n    aaaaaaaaaaaaaaaaaaaaaaaa);"));
  verifyFormat(new StringRef(/*KEEP_STR*/"aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa\n    [aaaaaaaaaaaaaaaaaaaaaaaa\n         [aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa]\n         [aaaaaaaaaaaaaaaaaaaaaaaa]];"));
  verifyFormat(new StringRef(/*KEEP_STR*/"aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa<\n    aaaaaaaaaaaaaaaaaaaaaaaa<\n        aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa>,\n    aaaaaaaaaaaaaaaaaaaaaaaa>;"));
  verifyFormat(new StringRef(/*KEEP_STR*/"int a = bbbb && ccc && fffff(\n#define A Just forcing a new line\n                           ddd);"));
}

;
@Test
//<editor-fold defaultstate="collapsed" desc="clang::format::(anonymous namespace)::FormatTest_LineBreakingInBinaryExpressions_Test::TestBody">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp", line = 3360,
 FQN="clang::format::(anonymous namespace)::FormatTest_LineBreakingInBinaryExpressions_Test::TestBody", NM="_ZN5clang6format12_GLOBAL__N_147FormatTest_LineBreakingInBinaryExpressions_Test8TestBodyEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp -nm=_ZN5clang6format12_GLOBAL__N_147FormatTest_LineBreakingInBinaryExpressions_Test8TestBodyEv")
//</editor-fold>
public void test_LineBreakingInBinaryExpressions() {
  if (markAsSkippedIfNeed(TestState.Successful)) { return; }
  FormatStyle OnePerLine = null;
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    verifyFormat(new StringRef(/*KEEP_STR*/"bool aaaaaaa =\n    aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa(aaa).aaaaaaaaaaaaaaaaaaa() ||\n    bbbbbbbb();"));
    verifyFormat(new StringRef(/*KEEP_STR*/"bool aaaaaaa =\n    aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa(aaa).aaaaaaaaaaaaaaaaaaa() or\n    bbbbbbbb();"));
    
    verifyFormat(new StringRef(/*KEEP_STR*/"bool aaaaaaaaaaaaaaaaaaaaa =\n    aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa != bbbbbbbbbbbbbbbbbb &&\n    ccccccccc == ddddddddddd;"));
    verifyFormat(new StringRef(/*KEEP_STR*/"bool aaaaaaaaaaaaaaaaaaaaa =\n    aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa != bbbbbbbbbbbbbbbbbb and\n    ccccccccc == ddddddddddd;"));
    verifyFormat(new StringRef(/*KEEP_STR*/"bool aaaaaaaaaaaaaaaaaaaaa =\n    aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa not_eq bbbbbbbbbbbbbbbbbb and\n    ccccccccc == ddddddddddd;"));
    
    verifyFormat(new StringRef(/*KEEP_STR*/"aaaaaa = aaaaaaa(aaaaaaa, // break\n                 aaaaaa) &&\n         bbbbbb && cccccc;"));
    verifyFormat(new StringRef(/*KEEP_STR*/"aaaaaa = aaaaaaa(aaaaaaa, // break\n                 aaaaaa) >>\n         bbbbbb;"));
    verifyFormat(new StringRef(/*KEEP_STR*/"aa = Whitespaces.addUntouchableComment(\n    SourceMgr.getSpellingColumnNumber(\n        TheLine.Last->FormatTok.Tok.getLocation()) -\n    1);"));
    
    verifyFormat(new StringRef(/*KEEP_STR*/"if ((aaaaaaaaaaaaaaaaaaaaaaaaaaaaaa ||\n     bbbbbbbbbbbbbbbbbb) && // aaaaaaaaaaaaaaaa\n    cccccc) {\n}"));
    verifyFormat(new StringRef(/*KEEP_STR*/"b = a &&\n    // Comment\n    b.c && d;"));
    
    // If the LHS of a comparison is not a binary expression itself, the
    // additional linebreak confuses many people.
    verifyFormat(new StringRef(/*KEEP_STR*/"if (aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa(\n        aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa) > 5) {\n}"));
    verifyFormat(new StringRef(/*KEEP_STR*/"if (aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa(\n        aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa) == 5) {\n}"));
    verifyFormat(new StringRef(/*KEEP_STR*/"if (aaaaaaaaaaaaaaaaaaaaaaaaaa.aaaaaaaaaaaaaaaaaaaaaa(\n        aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa) == 5) {\n}"));
    // Even explicit parentheses stress the precedence enough to make the
    // additional break unnecessary.
    verifyFormat(new StringRef(/*KEEP_STR*/"if ((aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa +\n     aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa) == 5) {\n}"));
    // This cases is borderline, but with the indentation it is still readable.
    verifyFormat(new StringRef(/*KEEP_STR*/"if (aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa(\n        aaaaaaaaaaaaaaa) > aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa +\n                               aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa) {\n}"), 
        $c$.track(getLLVMStyleWithColumns(75))); $c$.clean();
    
    // If the LHS is a binary expression, we should still use the additional break
    // as otherwise the formatting hides the operator precedence.
    verifyFormat(new StringRef(/*KEEP_STR*/"if (aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa +\n        aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa ==\n    5) {\n}"));
    
    OnePerLine = getLLVMStyle();
    OnePerLine.BinPackParameters = false;
    verifyFormat(new StringRef(/*KEEP_STR*/"if (aaaaaaaaaaaaaaaaaaaaaaaaaaaa || aaaaaaaaaaaaaaaaaaaaaaaaaaaa ||\n    aaaaaaaaaaaaaaaaaaaaaaaaaaaa || aaaaaaaaaaaaaaaaaaaaaaaaaaaa ||\n    aaaaaaaaaaaaaaaaaaaaaaaaaaaa) {\n}"), 
        OnePerLine);
  } finally {
    if (OnePerLine != null) { OnePerLine.$destroy(); }
    $c$.$destroy();
  }
}

;
@Test
//<editor-fold defaultstate="collapsed" desc="clang::format::(anonymous namespace)::FormatTest_ExpressionIndentation_Test::TestBody">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp", line = 3442,
 FQN="clang::format::(anonymous namespace)::FormatTest_ExpressionIndentation_Test::TestBody", NM="_ZN5clang6format12_GLOBAL__N_137FormatTest_ExpressionIndentation_Test8TestBodyEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp -nm=_ZN5clang6format12_GLOBAL__N_137FormatTest_ExpressionIndentation_Test8TestBodyEv")
//</editor-fold>
public void test_ExpressionIndentation() {
  if (markAsSkippedIfNeed(TestState.Successful)) { return; }
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    verifyFormat(new StringRef(/*KEEP_STR*/"bool value = aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa +\n                     aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa +\n                     aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa ==\n                 aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa *\n                         bbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbb +\n                     bbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbb &&\n             aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa *\n                     aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa >\n                 ccccccccccccccccccccccccccccccccccccccccc;"));
    verifyFormat(new StringRef(/*KEEP_STR*/"if (aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa *\n            aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa +\n        aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa ==\n    bbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbb) {\n}"));
    verifyFormat(new StringRef(/*KEEP_STR*/"if (aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa +\n        aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa *\n            aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa ==\n    bbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbb) {\n}"));
    verifyFormat(new StringRef(/*KEEP_STR*/"if (aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa ==\n    aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa *\n            aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa +\n        bbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbb) {\n}"));
    verifyFormat(new StringRef(/*KEEP_STR*/"if () {\n} else if (aaaaa &&\n           bbbbb > // break\n               ccccc) {\n}"));
    
    // Presence of a trailing comment used to change indentation of b.
    verifyFormat(new StringRef(/*KEEP_STR*/"return aaaaaaaaaaaaaaaaaaa +\n       b;\nreturn aaaaaaaaaaaaaaaaaaa +\n       b; //"), 
        $c$.track(getLLVMStyleWithColumns(30))); $c$.clean();
  } finally {
    $c$.$destroy();
  }
}

;
@Test
//<editor-fold defaultstate="collapsed" desc="clang::format::(anonymous namespace)::FormatTest_ExpressionIndentationBreakingBeforeOperators_Test::TestBody">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp", line = 3478,
 FQN="clang::format::(anonymous namespace)::FormatTest_ExpressionIndentationBreakingBeforeOperators_Test::TestBody", NM="_ZN5clang6format12_GLOBAL__N_160FormatTest_ExpressionIndentationBreakingBeforeOperators_Test8TestBodyEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp -nm=_ZN5clang6format12_GLOBAL__N_160FormatTest_ExpressionIndentationBreakingBeforeOperators_Test8TestBodyEv")
//</editor-fold>
public void test_ExpressionIndentationBreakingBeforeOperators() {
  if (markAsSkippedIfNeed(TestState.Successful)) { return; }
  FormatStyle Style = null;
  try {
    // Not sure what the best system is here. Like this, the LHS can be found
    // immediately above an operator (everything with the same or a higher
    // indent). The RHS is aligned right of the operator and so compasses
    // everything until something with the same indent as the operator is found.
    // FIXME: Is this a good system?
    Style = getLLVMStyle();
    Style.BreakBeforeBinaryOperators = FormatStyle.BinaryOperatorStyle.BOS_All;
    verifyFormat(new StringRef(/*KEEP_STR*/"bool value = aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa\n                     + aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa\n                     + aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa\n                 == aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa\n                            * bbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbb\n                        + bbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbb\n             && aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa\n                        * aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa\n                    > ccccccccccccccccccccccccccccccccccccccccc;"), 
        Style);
    verifyFormat(new StringRef(/*KEEP_STR*/"if (aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa\n            * aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa\n        + aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa\n    == bbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbb) {\n}"), 
        Style);
    verifyFormat(new StringRef(/*KEEP_STR*/"if (aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa\n        + aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa\n              * aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa\n    == bbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbb) {\n}"), 
        Style);
    verifyFormat(new StringRef(/*KEEP_STR*/"if (aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa\n    == aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa\n               * aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa\n           + bbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbb) {\n}"), 
        Style);
    verifyFormat(new StringRef(/*KEEP_STR*/"if () {\n} else if (aaaaa\n           && bbbbb // break\n                  > ccccc) {\n}"), 
        Style);
    verifyFormat(new StringRef(/*KEEP_STR*/"return (a)\n       // comment\n       + b;"), 
        Style);
    verifyFormat(new StringRef(/*KEEP_STR*/"int aaaaaa = aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa\n                 * bbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbb\n             + cc;"), 
        Style);
    
    verifyFormat(new StringRef(/*KEEP_STR*/"aaaaaaaaaaaaaaaaaaaaaaaaaaaaa\n    = aaaaaaaaaaaaaaaaaaaa + aaaaaaaaaaaaaaaaaaaaaaaaaaaa;"), 
        Style);
    
    // Forced by comments.
    verifyFormat(new StringRef(/*KEEP_STR*/"unsigned ContentSize =\n    sizeof(int16_t)   // DWARF ARange version number\n    + sizeof(int32_t) // Offset of CU in the .debug_info section\n    + sizeof(int8_t)  // Pointer Size (in bytes)\n    + sizeof(int8_t); // Segment Size (in bytes)"));
    
    verifyFormat(new StringRef(/*KEEP_STR*/"return boost::fusion::at_c<0>(iiii).second\n       == boost::fusion::at_c<1>(iiii).second;"), 
        Style);
    
    Style.ColumnLimit = 60;
    verifyFormat(new StringRef(/*KEEP_STR*/"zzzzzzzzzz\n    = bbbbbbbbbbbbbbbbb\n      >> aaaaaaaaaaaaaaaa(aaaaaaaaaaaaaaaaaaaaaaaaaa);"), 
        Style);
  } finally {
    if (Style != null) { Style.$destroy(); }
  }
}

;
@Test
//<editor-fold defaultstate="collapsed" desc="clang::format::(anonymous namespace)::FormatTest_NoOperandAlignment_Test::TestBody">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp", line = 3551,
 FQN="clang::format::(anonymous namespace)::FormatTest_NoOperandAlignment_Test::TestBody", NM="_ZN5clang6format12_GLOBAL__N_134FormatTest_NoOperandAlignment_Test8TestBodyEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp -nm=_ZN5clang6format12_GLOBAL__N_134FormatTest_NoOperandAlignment_Test8TestBodyEv")
//</editor-fold>
public void test_NoOperandAlignment() {
  if (markAsSkippedIfNeed(TestState.Successful)) { return; }
  FormatStyle Style = null;
  try {
    Style = getLLVMStyle();
    Style.AlignOperands = false;
    Style.BreakBeforeBinaryOperators = FormatStyle.BinaryOperatorStyle.BOS_NonAssignment;
    verifyFormat(new StringRef(/*KEEP_STR*/"bool value = aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa\n            + aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa\n            + aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa\n        == aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa\n                * bbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbb\n            + bbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbb\n    && aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa\n            * aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa\n        > ccccccccccccccccccccccccccccccccccccccccc;"), 
        Style);
    
    verifyFormat(new StringRef(/*KEEP_STR*/"int aaaaaa = aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa\n        * bbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbb\n    + cc;"), 
        Style);
    verifyFormat(new StringRef(/*KEEP_STR*/"int a = aa\n    + bbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbb\n        * cccccccccccccccccccccccccccccccccccc;"), 
        Style);
    
    Style.AlignAfterOpenBracket = FormatStyle.BracketAlignmentStyle.BAS_DontAlign;
    verifyFormat(new StringRef(/*KEEP_STR*/"return (a > b\n    // comment1\n    // comment2\n    || c);"), 
        Style);
  } finally {
    if (Style != null) { Style.$destroy(); }
  }
}

;
@Test
//<editor-fold defaultstate="collapsed" desc="clang::format::(anonymous namespace)::FormatTest_BreakingBeforeNonAssigmentOperators_Test::TestBody">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp", line = 3583,
 FQN="clang::format::(anonymous namespace)::FormatTest_BreakingBeforeNonAssigmentOperators_Test::TestBody", NM="_ZN5clang6format12_GLOBAL__N_151FormatTest_BreakingBeforeNonAssigmentOperators_Test8TestBodyEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp -nm=_ZN5clang6format12_GLOBAL__N_151FormatTest_BreakingBeforeNonAssigmentOperators_Test8TestBodyEv")
//</editor-fold>
public void test_BreakingBeforeNonAssigmentOperators() {
  if (markAsSkippedIfNeed(TestState.Successful)) { return; }
  FormatStyle Style = null;
  try {
    Style = getLLVMStyle();
    Style.BreakBeforeBinaryOperators = FormatStyle.BinaryOperatorStyle.BOS_NonAssignment;
    verifyFormat(new StringRef(/*KEEP_STR*/"int aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa =\n    aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa\n    + bbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbb;"), 
        Style);
  } finally {
    if (Style != null) { Style.$destroy(); }
  }
}

;
@Test
//<editor-fold defaultstate="collapsed" desc="clang::format::(anonymous namespace)::FormatTest_ConstructorInitializers_Test::TestBody">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp", line = 3592,
 FQN="clang::format::(anonymous namespace)::FormatTest_ConstructorInitializers_Test::TestBody", NM="_ZN5clang6format12_GLOBAL__N_139FormatTest_ConstructorInitializers_Test8TestBodyEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp -nm=_ZN5clang6format12_GLOBAL__N_139FormatTest_ConstructorInitializers_Test8TestBodyEv")
//</editor-fold>
public void test_ConstructorInitializers() {
  if (markAsSkippedIfNeed(TestState.Successful)) { return; }
  FormatStyle OnePerLine = null;
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    verifyFormat(new StringRef(/*KEEP_STR*/"Constructor() : Initializer(FitsOnTheLine) {}"));
    verifyFormat(new StringRef(/*KEEP_STR*/"Constructor() : Inttializer(FitsOnTheLine) {}"), 
        $c$.track(getLLVMStyleWithColumns(45))); $c$.clean();
    verifyFormat(new StringRef(/*KEEP_STR*/"Constructor()\n    : Inttializer(FitsOnTheLine) {}"), 
        $c$.track(getLLVMStyleWithColumns(44))); $c$.clean();
    verifyFormat(new StringRef(/*KEEP_STR*/"Constructor()\n    : Inttializer(FitsOnTheLine) {}"), 
        $c$.track(getLLVMStyleWithColumns(43))); $c$.clean();
    
    verifyFormat(new StringRef(/*KEEP_STR*/"template <typename T>\nConstructor() : Initializer(FitsOnTheLine) {}"), 
        $c$.track(getLLVMStyleWithColumns(45))); $c$.clean();
    
    verifyFormat(new StringRef(/*KEEP_STR*/"SomeClass::Constructor()\n    : aaaaaaaaaaaaa(aaaaaaaaaaaaaa), aaaaaaaaaaaaaaa(aaaaaaaaaaaa) {}"));
    
    verifyFormat(new StringRef(/*KEEP_STR*/"SomeClass::Constructor()\n    : aaaaaaaaaaaaa(aaaaaaaaaaaaaa), aaaaaaaaaaaaa(aaaaaaaaaaaaaa),\n      aaaaaaaaaaaaa(aaaaaaaaaaaaaa) {}"));
    verifyFormat(new StringRef(/*KEEP_STR*/"SomeClass::Constructor()\n    : aaaaaaaaaaaaaaaaaaaaaaaaaaaaaa(aaaaaaaaaaaaaaaaaaaaaaaaaaaaaa),\n      aaaaaaaaaaaaaaa(aaaaaaaaaaaa) {}"));
    verifyFormat(new StringRef(/*KEEP_STR*/"Constructor(aaaaaa aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa,\n            aaaaaa aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa)\n    : aaaaaaaaaa(aaaaaa) {}"));
    
    verifyFormat(new StringRef(/*KEEP_STR*/"Constructor()\n    : aaaaaaaaaaaaaaaaaaaaaaaa(aaaaaaaaaaaaaaaaaaaaaaaaaaa),\n      aaaaaaaaaaaaaaaaaaaaaaaa(aaaaaaaaaaaaaaaaaaaaaaaaaaa,\n                               aaaaaaaaaaaaaaaaaaaaaaaaaaa),\n      aaaaaaaaaaaaaaaaaaaaaaa() {}"));
    
    verifyFormat(new StringRef(/*KEEP_STR*/"Constructor()\n    : aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa(\n          aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa) {}"));
    
    verifyFormat(new StringRef(/*KEEP_STR*/"Constructor(int Parameter = 0)\n    : aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa(aaaaaaaaaaaaaaaaa),\n      aaaaaaaaaaaa(aaaaaaaaaaaaaaaaa) {}"));
    verifyFormat(new StringRef(/*KEEP_STR*/"Constructor()\n    : aaaaaaaaaaaaaaaaaaaa(a), bbbbbbbbbbbbbbbbbbbbbbbb(b) {\n}"), 
        $c$.track(getLLVMStyleWithColumns(60))); $c$.clean();
    verifyFormat(new StringRef(/*KEEP_STR*/"Constructor()\n    : aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa(\n          aaaaaaaaaaaaaaaaaaaaaaaaa(aaaa, aaaa)) {}"));
    
    // Here a line could be saved by splitting the second initializer onto two
    // lines, but that is not desirable.
    verifyFormat(new StringRef(/*KEEP_STR*/"Constructor()\n    : aaaaaaaaaaaaaaaaaaaaaaaa(aaaaaaaaaaaaaaaaaaaaaaaa),\n      aaaaaaaaaaa(aaaaaaaaaaa),\n      aaaaaaaaaaaaaaaaaaaaat(aaaaaaaaaaaaaaaaaaaaaaaaaaaa) {}"));
    
    OnePerLine = getLLVMStyle();
    OnePerLine.ConstructorInitializerAllOnOneLineOrOnePerLine = true;
    OnePerLine.AllowAllParametersOfDeclarationOnNextLine = false;
    verifyFormat(new StringRef(/*KEEP_STR*/"SomeClass::Constructor()\n    : aaaaaaaaaaaaa(aaaaaaaaaaaaaa),\n      aaaaaaaaaaaaa(aaaaaaaaaaaaaa),\n      aaaaaaaaaaaaa(aaaaaaaaaaaaaa) {}"), 
        OnePerLine);
    verifyFormat(new StringRef(/*KEEP_STR*/"SomeClass::Constructor()\n    : aaaaaaaaaaaaa(aaaaaaaaaaaaaa), // Some comment\n      aaaaaaaaaaaaa(aaaaaaaaaaaaaa),\n      aaaaaaaaaaaaa(aaaaaaaaaaaaaa) {}"), 
        OnePerLine);
    verifyFormat(new StringRef(/*KEEP_STR*/"MyClass::MyClass(int var)\n    : some_var_(var),            // 4 space indent\n      some_other_var_(var + 1) { // lined up\n}"), 
        OnePerLine);
    verifyFormat(new StringRef(/*KEEP_STR*/"Constructor()\n    : aaaaa(aaaaaa),\n      aaaaa(aaaaaa),\n      aaaaa(aaaaaa),\n      aaaaa(aaaaaa),\n      aaaaa(aaaaaa) {}"), 
        OnePerLine);
    verifyFormat(new StringRef(/*KEEP_STR*/"Constructor()\n    : aaaaa(aaaaaaaaaaaaaaaaaaaaaa, aaaaaaaaaaaaaaaaaaaaaa,\n            aaaaaaaaaaaaaaaaaaaaaa) {}"), 
        OnePerLine);
    OnePerLine.BinPackParameters = false;
    verifyFormat(new StringRef(/*KEEP_STR*/"Constructor()\n    : aaaaaaaaaaaaaaaaaaaaaaaa(\n          aaaaaaaaaaa().aaa(),\n          aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa) {}"), 
        OnePerLine);
    OnePerLine.ColumnLimit = 60;
    verifyFormat(new StringRef(/*KEEP_STR*/"Constructor()\n    : aaaaaaaaaaaaaaaaaaaa(a),\n      bbbbbbbbbbbbbbbbbbbbbbbb(b) {}"), 
        OnePerLine);
    EXPECT_EQ("Constructor()\n    : // Comment forcing unwanted break.\n      aaaa(aaaa) {}",format(new StringRef(/*KEEP_STR*/"Constructor() :\n    // Comment forcing unwanted break.\n    aaaa(aaaa) {}")));
  } finally {
    if (OnePerLine != null) { OnePerLine.$destroy(); }
    $c$.$destroy();
  }
}

;
@Test
//<editor-fold defaultstate="collapsed" desc="clang::format::(anonymous namespace)::FormatTest_MemoizationTests_Test::TestBody">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp", line = 3701,
 FQN="clang::format::(anonymous namespace)::FormatTest_MemoizationTests_Test::TestBody", NM="_ZN5clang6format12_GLOBAL__N_132FormatTest_MemoizationTests_Test8TestBodyEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp -nm=_ZN5clang6format12_GLOBAL__N_132FormatTest_MemoizationTests_Test8TestBodyEv")
//</editor-fold>
public void test_MemoizationTests() {
  // The test failed by timeout
  if (markAsSkippedIfNeed(TestState.Successful)) { return; }
  FormatStyle OnePerLine = null;
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    // This breaks if the memoization lookup does not take \c Indent and
    // \c LastSpace into account.
    verifyFormat(new StringRef(/*KEEP_STR*/"extern CFRunLoopTimerRef\nCFRunLoopTimerCreate(CFAllocatorRef allocato, CFAbsoluteTime fireDate,\n                     CFTimeInterval interval, CFOptionFlags flags,\n                     CFIndex order, CFRunLoopTimerCallBack callout,\n                     CFRunLoopTimerContext *context) {}"));
    
    // Deep nesting somewhat works around our memoization.
    verifyFormat(new StringRef(/*KEEP_STR*/"aaaaa(aaaaa(aaaaa(aaaaa(aaaaa(aaaaa(aaaaa(aaaaa(aaaaa(aaaaa(aaaaa(\n    aaaaa(aaaaa(aaaaa(aaaaa(aaaaa(aaaaa(aaaaa(aaaaa(aaaaa(aaaaa(\n        aaaaa(aaaaa(aaaaa(aaaaa(aaaaa(aaaaa(aaaaa(aaaaa(aaaaa(\n            aaaaa(aaaaa(aaaaa(aaaaa(aaaaa(aaaaa(aaaaa(aaaaa(aaaaa(\n                aaaaa())))))))))))))))))))))))))))))))))))))));"), 
        $c$.track(getLLVMStyleWithColumns(65))); $c$.clean();
    verifyFormat(new StringRef(/*KEEP_STR*/"aaaaa(\n    aaaaa,\n    aaaaa(\n        aaaaa,\n        aaaaa(\n            aaaaa,\n            aaaaa(\n                aaaaa,\n                aaaaa(\n                    aaaaa,\n                    aaaaa(\n                        aaaaa,\n                        aaaaa(\n                            aaaaa,\n                            aaaaa(\n                                aaaaa,\n                                aaaaa(\n                                    aaaaa,\n                                    aaaaa(\n                                        aaaaa,\n                                        aaaaa(\n                                            aaaaa,\n                                            aaaaa(\n                                                aaaaa,\n                                                aaaaa))))))))))));"), 
        $c$.track(getLLVMStyleWithColumns(65))); $c$.clean();
    verifyFormat(new StringRef(/*KEEP_STR*/"a(a(a(a(a(a(a(a(a(a(a(a(a(a(a(a(a(a(a(a(a(a(), a), a), a), a),\n                                  a),\n                                a),\n                              a),\n                            a),\n                          a),\n                        a),\n                      a),\n                    a),\n                  a),\n                a),\n              a),\n            a),\n          a),\n        a),\n      a),\n    a),\n  a)"), 
        $c$.track(getLLVMStyleWithColumns(65))); $c$.clean();
    
    // This test takes VERY long when memoization is broken.
    OnePerLine = getLLVMStyle();
    OnePerLine.ConstructorInitializerAllOnOneLineOrOnePerLine = true;
    OnePerLine.BinPackParameters = false;
    std.string input = new std.string(JD$T$C$P_T2$C$R.INSTANCE, /*KEEP_STR*/"Constructor()\n    : aaaa(a,\n");
    for (/*uint*/int i = 0, e = 80; i != e; ++i) {
      input.$addassign_T$C$P(/*KEEP_STR*/"           a,\n");
    }
    input.$addassign_T$C$P(/*KEEP_STR*/"           a) {}");
    verifyFormat(new StringRef(input), OnePerLine);
  } finally {
    if (OnePerLine != null) { OnePerLine.$destroy(); }
    $c$.$destroy();
  }
}

;
@Test
//<editor-fold defaultstate="collapsed" desc="clang::format::(anonymous namespace)::FormatTest_BreaksAsHighAsPossible_Test::TestBody">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp", line = 3780,
 FQN="clang::format::(anonymous namespace)::FormatTest_BreaksAsHighAsPossible_Test::TestBody", NM="_ZN5clang6format12_GLOBAL__N_138FormatTest_BreaksAsHighAsPossible_Test8TestBodyEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp -nm=_ZN5clang6format12_GLOBAL__N_138FormatTest_BreaksAsHighAsPossible_Test8TestBodyEv")
//</editor-fold>
public void test_BreaksAsHighAsPossible() {
  if (markAsSkippedIfNeed(TestState.Successful)) { return; }
  verifyFormat(new StringRef(/*KEEP_STR*/"void f() {\n  if ((aaaaaaaaaaaaaaaaaaaaaaaaaaaaa && aaaaaaaaaaaaaaaaaaaaaaaaaa) ||\n      (bbbbbbbbbbbbbbbbbbbbbbbbbbbbbbb && bbbbbbbbbbbbbbbbbbbbbbbbbb))\n    f();\n}"));
  verifyFormat(new StringRef(/*KEEP_STR*/"if (Intervals[i].getRange().getFirst() <\n    Intervals[i - 1].getRange().getLast()) {\n}"));
}

;
@Test
//<editor-fold defaultstate="collapsed" desc="clang::format::(anonymous namespace)::FormatTest_BreaksFunctionDeclarations_Test::TestBody">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp", line = 3791,
 FQN="clang::format::(anonymous namespace)::FormatTest_BreaksFunctionDeclarations_Test::TestBody", NM="_ZN5clang6format12_GLOBAL__N_142FormatTest_BreaksFunctionDeclarations_Test8TestBodyEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp -nm=_ZN5clang6format12_GLOBAL__N_142FormatTest_BreaksFunctionDeclarations_Test8TestBodyEv")
//</editor-fold>
public void test_BreaksFunctionDeclarations() {
  if (markAsSkippedIfNeed(TestState.Successful)) { return; }
  FormatStyle Style = null;
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    // Principially, we break function declarations in a certain order:
    // 1) break amongst arguments.
    verifyFormat(new StringRef(/*KEEP_STR*/"Aaaaaaaaaaaaaa bbbbbbbbbbbbbb(Cccccccccccccc cccccccccccccc,\n                              Cccccccccccccc cccccccccccccc);"));
    verifyFormat(new StringRef(/*KEEP_STR*/"template <class TemplateIt>\nSomeReturnType SomeFunction(TemplateIt begin, TemplateIt end,\n                            TemplateIt *stop) {}"));
    
    // 2) break after return type.
    verifyFormat(new StringRef(/*KEEP_STR*/"Aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa\nbbbbbbbbbbbbbb(Cccccccccccccc cccccccccccccccccccccccccc);"), 
        $c$.track(getGoogleStyle())); $c$.clean();
    
    // 3) break after (.
    verifyFormat(new StringRef(/*KEEP_STR*/"Aaaaaaaaaaaaaaaaaaaaaaaa bbbbbbbbbbbbbbbbbb(\n    Cccccccccccccccccccccccccccccc cccccccccccccccccccccccccccccccc);"), 
        $c$.track(getGoogleStyle())); $c$.clean();
    
    // 4) break before after nested name specifiers.
    verifyFormat(new StringRef(/*KEEP_STR*/"Aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa\nSomeClasssssssssssssssssssssssssssssssssssssss::\n    bbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbb(Cccccccccccccc cccccccccc);"), 
        $c$.track(getGoogleStyle())); $c$.clean();
    
    // However, there are exceptions, if a sufficient amount of lines can be
    // saved.
    // FIXME: The precise cut-offs wrt. the number of saved lines might need some
    // more adjusting.
    verifyFormat(new StringRef(/*KEEP_STR*/"Aaaaaaaaaaaaaaaaaa bbbbbbbbbbbbbb(Cccccccccccccc cccccccccc,\n                                  Cccccccccccccc cccccccccc,\n                                  Cccccccccccccc cccccccccc,\n                                  Cccccccccccccc cccccccccc,\n                                  Cccccccccccccc cccccccccc);"));
    verifyFormat(new StringRef(/*KEEP_STR*/"Aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa\nbbbbbbbbbbb(Cccccccccccccc cccccccccc, Cccccccccccccc cccccccccc,\n            Cccccccccccccc cccccccccc, Cccccccccccccc cccccccccc,\n            Cccccccccccccc cccccccccc, Cccccccccccccc cccccccccc);"), 
        $c$.track(getGoogleStyle())); $c$.clean();
    verifyFormat(new StringRef(/*KEEP_STR*/"Aaaaaaaaaa bbbbbbbbbbbbbbbbbbbbbbbbbbbbbb(Cccccccccccccc cccccccccc,\n                                          Cccccccccccccc cccccccccc,\n                                          Cccccccccccccc cccccccccc,\n                                          Cccccccccccccc cccccccccc,\n                                          Cccccccccccccc cccccccccc,\n                                          Cccccccccccccc cccccccccc,\n                                          Cccccccccccccc cccccccccc);"));
    verifyFormat(new StringRef(/*KEEP_STR*/"Aaaaaaaaaa bbbbbbbbbbbbbbbbbbbbbbbbbbbbbb(\n    Cccccccccccccc cccccccccc, Cccccccccccccc cccccccccc,\n    Cccccccccccccc cccccccccc, Cccccccccccccc cccccccccc,\n    Cccccccccccccc cccccccccc, Cccccccccccccc cccccccccc,\n    Cccccccccccccc cccccccccc, Cccccccccccccc cccccccccc);"));
    
    // Break after multi-line parameters.
    verifyFormat(new StringRef(/*KEEP_STR*/"void aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa(\n    aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa\n        aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa,\n    bbbb bbbb);"));
    verifyFormat(new StringRef(/*KEEP_STR*/"void SomeLoooooooooooongFunction(\n    std::unique_ptr<aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa>\n        aaaaaaaaaaaaaaaaaaaaaaaaaa,\n    int bbbbbbbbbbbbb);"));
    
    // Treat overloaded operators like other functions.
    verifyFormat(new StringRef(/*KEEP_STR*/"SomeLoooooooooooooooooooooooooogType\noperator>(const SomeLoooooooooooooooooooooooooogType &other);"));
    verifyFormat(new StringRef(/*KEEP_STR*/"SomeLoooooooooooooooooooooooooogType\noperator>>(const SomeLooooooooooooooooooooooooogType &other);"));
    verifyFormat(new StringRef(/*KEEP_STR*/"SomeLoooooooooooooooooooooooooogType\noperator<<(const SomeLooooooooooooooooooooooooogType &other);"));
    verifyGoogleFormat(new StringRef(/*KEEP_STR*/"SomeLoooooooooooooooooooooooooooooogType operator>>(\n    const SomeLooooooooogType &a, const SomeLooooooooogType &b);"));
    verifyGoogleFormat(new StringRef(/*KEEP_STR*/"SomeLoooooooooooooooooooooooooooooogType operator<<(\n    const SomeLooooooooogType &a, const SomeLooooooooogType &b);"));
    verifyFormat(new StringRef(/*KEEP_STR*/"void aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa(\n    int aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa = 1);"));
    verifyFormat(new StringRef(/*KEEP_STR*/"aaaaaaaaaaaaaaaaaaaaaa\naaaaaaaaaaaaaaaaaaaaaaaaa(int aaaaaaaaaaaaaaaaaaaaaaaa = 1);"));
    verifyGoogleFormat(new StringRef(/*KEEP_STR*/"typename aaaaaaaaaa<aaaaaa>::aaaaaaaaaaa\naaaaaaaaaa<aaaaaa>::aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa(\n    bool *aaaaaaaaaaaaaaaaaa, bool *aa) {}"));
    verifyGoogleFormat(new StringRef(/*KEEP_STR*/"template <typename T>\naaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa\naaaaaaaaaaaaaaaaaaaaaaa<T>::aaaaaaaaaaaaa(\n    aaaaaaaaaaaaaaaaaaaaaaa aaaaaaaaaaaaaaa);"));
    
    Style = getLLVMStyle();
    Style.PointerAlignment = FormatStyle.PointerAlignmentStyle.PAS_Left;
    verifyFormat(new StringRef(/*KEEP_STR*/"void aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa(\n    aaaaaaaaaaaaaaaaaaaaaaaaa* const aaaaaaaaaaaa) {}"), 
        Style);
    verifyFormat(new StringRef(/*KEEP_STR*/"void aaaaaaa(aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa*\n                 aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa) {}"), 
        Style);
  } finally {
    if (Style != null) { Style.$destroy(); }
    $c$.$destroy();
  }
}

;
@Test
//<editor-fold defaultstate="collapsed" desc="clang::format::(anonymous namespace)::FormatTest_TrailingReturnType_Test::TestBody">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp", line = 3895,
 FQN="clang::format::(anonymous namespace)::FormatTest_TrailingReturnType_Test::TestBody", NM="_ZN5clang6format12_GLOBAL__N_134FormatTest_TrailingReturnType_Test8TestBodyEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp -nm=_ZN5clang6format12_GLOBAL__N_134FormatTest_TrailingReturnType_Test8TestBodyEv")
//</editor-fold>
public void test_TrailingReturnType() {
  if (markAsSkippedIfNeed(TestState.Successful)) { return; }
  verifyFormat(new StringRef(/*KEEP_STR*/"auto foo() -> int;\n"));
  verifyFormat(new StringRef(/*KEEP_STR*/"struct S {\n  auto bar() const -> int;\n};"));
  verifyFormat(new StringRef(/*KEEP_STR*/"template <size_t Order, typename T>\nauto load_img(const std::string &filename)\n    -> alias::tensor<Order, T, mem::tag::cpu> {}"));
  verifyFormat(new StringRef(/*KEEP_STR*/"auto SomeFunction(A aaaaaaaaaaaaaaaaaaaaa) const\n    -> decltype(f(aaaaaaaaaaaaaaaaaaaaa)) {}"));
  verifyFormat(new StringRef(/*KEEP_STR*/"auto doSomething(Aaaaaa *aaaaaa) -> decltype(aaaaaa->f()) {}"));
  verifyFormat(new StringRef(/*KEEP_STR*/"template <typename T>\nauto aaaaaaaaaaaaaaaaaaaaaa(T t)\n    -> decltype(eaaaaaaaaaaaaaaa<T>(t.a).aaaaaaaa());"));
  
  // Not trailing return types.
  verifyFormat(new StringRef(/*KEEP_STR*/"void f() { auto a = b->c(); }"));
}

;
@Test
//<editor-fold defaultstate="collapsed" desc="clang::format::(anonymous namespace)::FormatTest_BreaksFunctionDeclarationsWithTrailingTokens_Test::TestBody">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp", line = 3914,
 FQN="clang::format::(anonymous namespace)::FormatTest_BreaksFunctionDeclarationsWithTrailingTokens_Test::TestBody", NM="_ZN5clang6format12_GLOBAL__N_160FormatTest_BreaksFunctionDeclarationsWithTrailingTokens_Test8TestBodyEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp -nm=_ZN5clang6format12_GLOBAL__N_160FormatTest_BreaksFunctionDeclarationsWithTrailingTokens_Test8TestBodyEv")
//</editor-fold>
public void test_BreaksFunctionDeclarationsWithTrailingTokens() {
  if (markAsSkippedIfNeed(TestState.Successful)) { return; }
  FormatStyle Style = null;
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    // Avoid breaking before trailing 'const' or other trailing annotations, if
    // they are not function-like.
    Style = getGoogleStyle();
    Style.ColumnLimit = 47;
    verifyFormat(new StringRef(/*KEEP_STR*/"void someLongFunction(\n    int someLoooooooooooooongParameter) const {\n}"), 
        $c$.track(getLLVMStyleWithColumns(47))); $c$.clean();
    verifyFormat(new StringRef(/*KEEP_STR*/"LoooooongReturnType\nsomeLoooooooongFunction() const {}"), 
        $c$.track(getLLVMStyleWithColumns(47))); $c$.clean();
    verifyFormat(new StringRef(/*KEEP_STR*/"LoooooongReturnType someLoooooooongFunction()\n    const {}"), 
        Style);
    verifyFormat(new StringRef(/*KEEP_STR*/"void SomeFunction(aaaaa aaaaaaaaaaaaaaaaaaaa,\n                  aaaaa aaaaaaaaaaaaaaaaaaaa) OVERRIDE;"));
    verifyFormat(new StringRef(/*KEEP_STR*/"void SomeFunction(aaaaa aaaaaaaaaaaaaaaaaaaa,\n                  aaaaa aaaaaaaaaaaaaaaaaaaa) OVERRIDE FINAL;"));
    verifyFormat(new StringRef(/*KEEP_STR*/"void SomeFunction(aaaaa aaaaaaaaaaaaaaaaaaaa,\n                  aaaaa aaaaaaaaaaaaaaaaaaaa) override final;"));
    verifyFormat(new StringRef(/*KEEP_STR*/"virtual void aaaaa(aaaaaaaaaaaaaaaaaaaaaaaaaa aaaa,\n                   aaaaaaaaaaa aaaaa) const override;"));
    verifyGoogleFormat(new StringRef(/*KEEP_STR*/"virtual void aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa()\n    const override;"));
    
    // Even if the first parameter has to be wrapped.
    verifyFormat(new StringRef(/*KEEP_STR*/"void someLongFunction(\n    int someLongParameter) const {}"), 
        $c$.track(getLLVMStyleWithColumns(46))); $c$.clean();
    verifyFormat(new StringRef(/*KEEP_STR*/"void someLongFunction(\n    int someLongParameter) const {}"), 
        Style);
    verifyFormat(new StringRef(/*KEEP_STR*/"void someLongFunction(\n    int someLongParameter) override {}"), 
        Style);
    verifyFormat(new StringRef(/*KEEP_STR*/"void someLongFunction(\n    int someLongParameter) OVERRIDE {}"), 
        Style);
    verifyFormat(new StringRef(/*KEEP_STR*/"void someLongFunction(\n    int someLongParameter) final {}"), 
        Style);
    verifyFormat(new StringRef(/*KEEP_STR*/"void someLongFunction(\n    int someLongParameter) FINAL {}"), 
        Style);
    verifyFormat(new StringRef(/*KEEP_STR*/"void someLongFunction(\n    int parameter) const override {}"), 
        Style);
    
    Style.BreakBeforeBraces = FormatStyle.BraceBreakingStyle.BS_Allman;
    verifyFormat(new StringRef(/*KEEP_STR*/"void someLongFunction(\n    int someLongParameter) const\n{\n}"), 
        Style);
    
    // Unless these are unknown annotations.
    verifyFormat(new StringRef(/*KEEP_STR*/"void SomeFunction(aaaaaaaaaa aaaaaaaaaaaaaaa,\n                  aaaaaaaaaa aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa)\n    LONG_AND_UGLY_ANNOTATION;"));
    
    // Breaking before function-like trailing annotations is fine to keep them
    // close to their arguments.
    verifyFormat(new StringRef(/*KEEP_STR*/"void aaaaaaaaaaaa(int aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa)\n    LOCKS_EXCLUDED(aaaaaaaaaaaaa);"));
    verifyFormat(new StringRef(/*KEEP_STR*/"void aaaaaaaaaaaa(int aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa) const\n    LOCKS_EXCLUDED(aaaaaaaaaaaaa);"));
    verifyFormat(new StringRef(/*KEEP_STR*/"void aaaaaaaaaaaa(int aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa) const\n    LOCKS_EXCLUDED(aaaaaaaaaaaaa) {}"));
    verifyGoogleFormat(new StringRef(/*KEEP_STR*/"void aaaaaaaaaaaaaa(aaaaaaaa aaa) override\n    AAAAAAAAAAAAAAAAAAAAAAAA(aaaaaaaaaaaaaaa);"));
    verifyFormat(new StringRef(/*KEEP_STR*/"SomeFunction([](int i) LOCKS_EXCLUDED(a) {});"));
    
    verifyFormat(new StringRef(/*KEEP_STR*/"void aaaaaaaaaaaaaaaaaa()\n    __attribute__((aaaaaaaaaaaaaaaaaaaaaaaaa, aaaaaaaaaaaaaaaaaaaaaaa,\n                   aaaaaaaaaaaaaaaaaaaaaaaaa));"));
    verifyFormat(new StringRef(/*KEEP_STR*/"bool aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa\n    __attribute__((unused));"));
    verifyGoogleFormat(new StringRef(/*KEEP_STR*/"bool aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa\n    GUARDED_BY(aaaaaaaaaaaa);"));
    verifyGoogleFormat(new StringRef(/*KEEP_STR*/"bool aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa\n    GUARDED_BY(aaaaaaaaaaaa);"));
    verifyGoogleFormat(new StringRef(/*KEEP_STR*/"bool aaaaaaaaaaaaaaaaaaaaaaaaaaaaaa GUARDED_BY(aaaaaaaaaaaa) =\n    aaaaaaaa::aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa;"));
    verifyGoogleFormat(new StringRef(/*KEEP_STR*/"bool aaaaaaaaaaaaaaaaaaaaaaaaaaaaaa GUARDED_BY(aaaaaaaaaaaa) =\n    aaaaaaaaaaaaaaaaaaaaaaaaa;"));
  } finally {
    if (Style != null) { Style.$destroy(); }
    $c$.$destroy();
  }
}

;
@Test
//<editor-fold defaultstate="collapsed" desc="clang::format::(anonymous namespace)::FormatTest_FunctionAnnotations_Test::TestBody">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp", line = 4007,
 FQN="clang::format::(anonymous namespace)::FormatTest_FunctionAnnotations_Test::TestBody", NM="_ZN5clang6format12_GLOBAL__N_135FormatTest_FunctionAnnotations_Test8TestBodyEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp -nm=_ZN5clang6format12_GLOBAL__N_135FormatTest_FunctionAnnotations_Test8TestBodyEv")
//</editor-fold>
public void test_FunctionAnnotations() {
  if (markAsSkippedIfNeed(TestState.Successful)) { return; }
  verifyFormat(new StringRef(/*KEEP_STR*/"DEPRECATED(\"Use NewClass::NewFunction instead.\")\nint OldFunction(const string &parameter) {}"));
  verifyFormat(new StringRef(/*KEEP_STR*/"DEPRECATED(\"Use NewClass::NewFunction instead.\")\nstring OldFunction(const string &parameter) {}"));
  verifyFormat(new StringRef(/*KEEP_STR*/"template <typename T>\nDEPRECATED(\"Use NewClass::NewFunction instead.\")\nstring OldFunction(const string &parameter) {}"));
  
  // Not function annotations.
  verifyFormat(new StringRef(/*KEEP_STR*/"ASSERT(\"aaaaa\") << aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa\n                << bbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbb"));
  verifyFormat(new StringRef(/*KEEP_STR*/"TEST_F(ThisIsATestFixtureeeeeeeeeeeee,\n       ThisIsATestWithAReallyReallyReallyReallyLongName) {}"));
  verifyFormat(new StringRef(/*KEEP_STR*/"MACRO(abc).function() // wrap\n    << abc;"));
  verifyFormat(new StringRef(/*KEEP_STR*/"MACRO(abc)->function() // wrap\n    << abc;"));
  verifyFormat(new StringRef(/*KEEP_STR*/"MACRO(abc)::function() // wrap\n    << abc;"));
}

;
@Test
//<editor-fold defaultstate="collapsed" desc="clang::format::(anonymous namespace)::FormatTest_BreaksDesireably_Test::TestBody">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp", line = 4029,
 FQN="clang::format::(anonymous namespace)::FormatTest_BreaksDesireably_Test::TestBody", NM="_ZN5clang6format12_GLOBAL__N_132FormatTest_BreaksDesireably_Test8TestBodyEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp -nm=_ZN5clang6format12_GLOBAL__N_132FormatTest_BreaksDesireably_Test8TestBodyEv")
//</editor-fold>
public void test_BreaksDesireably() {
  if (markAsSkippedIfNeed(TestState.Successful)) { return; }
  verifyFormat(new StringRef(/*KEEP_STR*/"if (aaaaaaaaaaaaaaaaaaa(aaaaaaaaaaaaaaa) ||\n    aaaaaaaaaaaaaaaaaaa(aaaaaaaaaaaaaaa) ||\n    aaaaaaaaaaaaaaaaaaa(aaaaaaaaaaaaaaa)) {\n}"));
  verifyFormat(new StringRef(/*KEEP_STR*/"if (aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa(\n        aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa)) {\n}"));
  
  verifyFormat(new StringRef(/*KEEP_STR*/"aaaaaaaaaaaaaaaaaaaaa(aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa,\n                      aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa) {}"));
  
  verifyFormat(new StringRef(/*KEEP_STR*/"aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa(\n    aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa(\n        aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa));"));
  
  verifyFormat(new StringRef(/*KEEP_STR*/"aaaaaaaa(aaaaaaaaaaaaa, aaaaaaaaaaaaaaa(aaaaaaaaaaaaaaaaaaaaaaaaaaaaa(\n                            aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa)),\n         aaaaaaaa(aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa(\n             aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa)));"));
  
  verifyFormat(new StringRef(/*KEEP_STR*/"aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa ||\n    (aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa);"));
  
  verifyFormat(new StringRef(/*KEEP_STR*/"void f() {\n  aaaaaaaaaaaaaaaaaaaaaaaaaaaaaa(aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa &&\n                                 aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa);\n}"));
  verifyFormat(new StringRef(/*KEEP_STR*/"aaaaaa(new Aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa(\n    aaaaaaaaaaaaaaaaaaaaaaaaaaaaa));"));
  verifyFormat(new StringRef(/*KEEP_STR*/"aaaaaa(aaa, new Aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa(\n                aaaaaaaaaaaaaaaaaaaaaaaaaaaaa));"));
  verifyFormat(new StringRef(/*KEEP_STR*/"aaaaaaaaaaaaaaaaa(aaaaaaaaaaaaaaaaaaaaaaaaaaaaaa +\n                      aaaaaaaaaaaaaaaaaaaaaaaaaaaaaa,\n                  aaaaaaaaaaaaaaaaaaaaaaaaaaaaaa);"));
  
  // Indent consistently independent of call expression and unary operator.
  verifyFormat(new StringRef(/*KEEP_STR*/"aaaaaaaaaaa(bbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbb(\n    dddddddddddddddddddddddddddddd));"));
  verifyFormat(new StringRef(/*KEEP_STR*/"aaaaaaaaaaa(!bbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbb(\n    dddddddddddddddddddddddddddddd));"));
  verifyFormat(new StringRef(/*KEEP_STR*/"aaaaaaaaaaa(bbbbbbbbbbbbbbbbbbbbbbbbb.ccccccccccccccccc(\n    dddddddddddddddddddddddddddddd));"));
  
  // This test case breaks on an incorrect memoization, i.e. an optimization not
  // taking into account the StopAt value.
  verifyFormat(new StringRef(/*KEEP_STR*/"return aaaaaaaaaaaaaaaaaaaaaaaa || aaaaaaaaaaaaaaaaaaaaaaa ||\n       aaaaaaaaaaa(aaaaaaaaa) || aaaaaaaaaaaaaaaaaaaaaaa ||\n       aaaaaaaaaaaaaaaaaaaaaaaaa || aaaaaaaaaaaaaaaaaaaaaaa ||\n       (aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa);"));
  
  verifyFormat(new StringRef(/*KEEP_STR*/"{\n  {\n    {\n      Annotation.SpaceRequiredBefore =\n          Line.Tokens[i - 1].Tok.isNot(tok::l_paren) &&\n          Line.Tokens[i - 1].Tok.isNot(tok::l_square);\n    }\n  }\n}"));
    
    // Break on an outer level if there was a break on an inner level.
    EXPECT_EQ("f(g(h(a, // comment\n      b, c),\n    d, e),\n  x, y);",format(new StringRef(/*KEEP_STR*/"f(g(h(a, // comment\n    b, c), d, e), x, y);")));
  
  // Prefer breaking similar line breaks.
  verifyFormat(new StringRef(/*KEEP_STR*/"const int kTrackingOptions = NSTrackingMouseMoved |\n                             NSTrackingMouseEnteredAndExited |\n                             NSTrackingActiveAlways;"));
}

;
@Test
//<editor-fold defaultstate="collapsed" desc="clang::format::(anonymous namespace)::FormatTest_FormatsDeclarationsOnePerLine_Test::TestBody">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp", line = 4106,
 FQN="clang::format::(anonymous namespace)::FormatTest_FormatsDeclarationsOnePerLine_Test::TestBody", NM="_ZN5clang6format12_GLOBAL__N_145FormatTest_FormatsDeclarationsOnePerLine_Test8TestBodyEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp -nm=_ZN5clang6format12_GLOBAL__N_145FormatTest_FormatsDeclarationsOnePerLine_Test8TestBodyEv")
//</editor-fold>
public void test_FormatsDeclarationsOnePerLine() {
  if (markAsSkippedIfNeed(TestState.Successful)) { return; }
  FormatStyle NoBinPacking = null;
  try {
    NoBinPacking = getGoogleStyle();
    NoBinPacking.BinPackParameters = false;
    NoBinPacking.BinPackArguments = true;
    verifyFormat(new StringRef(/*KEEP_STR*/"void f() {\n  f(aaaaaaaaaaaaaaaaaaaa, aaaaaaaaaaaaaaaaaaaa,\n    aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa);\n}"), 
        NoBinPacking);
    verifyFormat(new StringRef(/*KEEP_STR*/"void f(int aaaaaaaaaaaaaaaaaaaa,\n       int aaaaaaaaaaaaaaaaaaaa,\n       int aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa) {}"), 
        NoBinPacking);
    
    NoBinPacking.AllowAllParametersOfDeclarationOnNextLine = false;
    verifyFormat(new StringRef(/*KEEP_STR*/"void aaaaaaaaaaaaaaaaaa(aaaaaaaaaaaaaaaaaaaaaaaaaaaa,\n                        vector<int> bbbbbbbbbbbbbbb);"), 
        NoBinPacking);
    // FIXME: This behavior difference is probably not wanted. However, currently
    // we cannot distinguish BreakBeforeParameter being set because of the wrapped
    // template arguments from BreakBeforeParameter being set because of the
    // one-per-line formatting.
    verifyFormat(new StringRef(/*KEEP_STR*/"void fffffffffff(aaaaaaaaaaaaaaaaaaaaaaaaaaa<aaaaaaaaaaaaaaaaaaaaaaa,\n                                             aaaaaaaaaa> aaaaaaaaaa);"), 
        NoBinPacking);
    verifyFormat(new StringRef(/*KEEP_STR*/"void fffffffffff(\n    aaaaaaaaaaaaaaaaaaaaaaaaaaa<aaaaaaaaaaaaaaaaaaaaaaa, aaaaaaaaaa>\n        aaaaaaaaaa);"));
  } finally {
    if (NoBinPacking != null) { NoBinPacking.$destroy(); }
  }
}

;
@Test
//<editor-fold defaultstate="collapsed" desc="clang::format::(anonymous namespace)::FormatTest_FormatsOneParameterPerLineIfNecessary_Test::TestBody">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp", line = 4138,
 FQN="clang::format::(anonymous namespace)::FormatTest_FormatsOneParameterPerLineIfNecessary_Test::TestBody", NM="_ZN5clang6format12_GLOBAL__N_153FormatTest_FormatsOneParameterPerLineIfNecessary_Test8TestBodyEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp -nm=_ZN5clang6format12_GLOBAL__N_153FormatTest_FormatsOneParameterPerLineIfNecessary_Test8TestBodyEv")
//</editor-fold>
public void test_FormatsOneParameterPerLineIfNecessary() {
  if (markAsSkippedIfNeed(TestState.Successful)) { return; }
  FormatStyle NoBinPacking = null;
  try {
    NoBinPacking = getGoogleStyle();
    NoBinPacking.BinPackParameters = false;
    NoBinPacking.BinPackArguments = false;
    verifyFormat(new StringRef(/*KEEP_STR*/"f(aaaaaaaaaaaaaaaaaaaa,\n  aaaaaaaaaaaaaaaaaaaa,\n  aaaaaaaaaaaaaaaaaaaa + aaaaaaaaaaaaaaaaaaaa);"), 
        NoBinPacking);
    verifyFormat(new StringRef(/*KEEP_STR*/"aaaaaaa(aaaaaaaaaaaaa,\n        aaaaaaaaaaaaa,\n        aaaaaaaaaaaaa(aaaaaaaaaaaaaaaaa, aaaaaaaaaaaaaaaa));"), 
        NoBinPacking);
    verifyFormat(new StringRef(/*KEEP_STR*/"aaaaaaaa(aaaaaaaaaaaaa,\n         aaaaaaaaaaaaaaa(aaaaaaaaaaaaaaaaaaaaaaaaaaaaa(\n             aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa)),\n         aaaaaaaa(aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa(\n             aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa)));"), 
        NoBinPacking);
    verifyFormat(new StringRef(/*KEEP_STR*/"aaaaaaaaaaaaaaa(aaaaaaaaa, aaaaaaaaa, aaaaaaaaaaaaaaaaaaaaa)\n    .aaaaaaaaaaaaaaaaaa();"), 
        NoBinPacking);
    verifyFormat(new StringRef(/*KEEP_STR*/"void f() {\n  aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa(\n      aaaaaaaaaa, aaaaaaaaaa, aaaaaaaaaa, aaaaaaaaaaa);\n}"), 
        NoBinPacking);
    
    verifyFormat(new StringRef(/*KEEP_STR*/"aaaaaaaaaaaa(aaaaaaaaaaaaaaaaaaaaaaaaaaaa + aaaaaaaaaaaaaaaaaaaaaaaaa,\n             aaaaaaaaaaaa,\n             aaaaaaaaaaaa);"), 
        NoBinPacking);
    verifyFormat(new StringRef(/*KEEP_STR*/"somefunction(someotherFunction(ddddddddddddddddddddddddddddddddddd,\n                               ddddddddddddddddddddddddddddd),\n             test);"), 
        NoBinPacking);
    
    verifyFormat(new StringRef(/*KEEP_STR*/"std::vector<aaaaaaaaaaaaaaaaaaaaaaa,\n            aaaaaaaaaaaaaaaaaaaaaaa,\n            aaaaaaaaaaaaaaaaaaaaaaa>\n    aaaaaaaaaaaaaaaaaa;"), 
        NoBinPacking);
    verifyFormat(new StringRef(/*KEEP_STR*/"a(\"a\"\n  \"a\",\n  a);"));
    
    NoBinPacking.AllowAllParametersOfDeclarationOnNextLine = false;
    verifyFormat(new StringRef(/*KEEP_STR*/"void aaaaaaaaaa(aaaaaaaaa,\n                aaaaaaaaa,\n                aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa);"), 
        NoBinPacking);
    verifyFormat(new StringRef(/*KEEP_STR*/"void f() {\n  aaaaaaaaaaaaaaaaaaaaaaa(aaaaaaaaa, aaaaaaaaa, aaaaaaaaaaaaaaaaaaaaa)\n      .aaaaaaa();\n}"), 
        NoBinPacking);
    verifyFormat(new StringRef(/*KEEP_STR*/"template <class SomeType, class SomeOtherType>\nSomeType SomeFunction(SomeType Type, SomeOtherType OtherType) {}"), 
        NoBinPacking);
  } finally {
    if (NoBinPacking != null) { NoBinPacking.$destroy(); }
  }
}

;
@Test
//<editor-fold defaultstate="collapsed" desc="clang::format::(anonymous namespace)::FormatTest_AdaptiveOnePerLineFormatting_Test::TestBody">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp", line = 4203,
 FQN="clang::format::(anonymous namespace)::FormatTest_AdaptiveOnePerLineFormatting_Test::TestBody", NM="_ZN5clang6format12_GLOBAL__N_144FormatTest_AdaptiveOnePerLineFormatting_Test8TestBodyEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp -nm=_ZN5clang6format12_GLOBAL__N_144FormatTest_AdaptiveOnePerLineFormatting_Test8TestBodyEv")
//</editor-fold>
public void test_AdaptiveOnePerLineFormatting() {
  if (markAsSkippedIfNeed(TestState.Successful)) { return; }
  FormatStyle Style = null;
  try {
    Style = getLLVMStyleWithColumns(15);
    Style.ExperimentalAutoDetectBinPacking = true;
    EXPECT_EQ("aaa(aaaa,\n    aaaa,\n    aaaa);\naaa(aaaa,\n    aaaa,\n    aaaa);",format(new StringRef(/*KEEP_STR*/"aaa(aaaa,\n  aaaa,\n    aaaa  );\naaa(aaaa,  aaaa,  aaaa);"), Style));
    EXPECT_EQ("aaa(aaaa, aaaa,\n    aaaa);\naaa(aaaa, aaaa,\n    aaaa);",format(new StringRef(/*KEEP_STR*/"aaa(aaaa,  aaaa,\n    aaaa  );\naaa(aaaa,  aaaa,  aaaa);"), Style));
  } finally {
    if (Style != null) { Style.$destroy(); }
  }
}

;
@Test
//<editor-fold defaultstate="collapsed" desc="clang::format::(anonymous namespace)::FormatTest_FormatsBuilderPattern_Test::TestBody">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp", line = 4227,
 FQN="clang::format::(anonymous namespace)::FormatTest_FormatsBuilderPattern_Test::TestBody", NM="_ZN5clang6format12_GLOBAL__N_137FormatTest_FormatsBuilderPattern_Test8TestBodyEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp -nm=_ZN5clang6format12_GLOBAL__N_137FormatTest_FormatsBuilderPattern_Test8TestBodyEv")
//</editor-fold>
public void test_FormatsBuilderPattern() {
  if (markAsSkippedIfNeed(TestState.Successful)) { return; }
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    verifyFormat(new StringRef(/*KEEP_STR*/"return llvm::StringSwitch<Reference::Kind>(name)\n    .StartsWith(\".eh_frame_hdr\", ORDER_EH_FRAMEHDR)\n    .StartsWith(\".eh_frame\", ORDER_EH_FRAME)\n    .StartsWith(\".init\", ORDER_INIT)\n    .StartsWith(\".fini\", ORDER_FINI)\n    .StartsWith(\".hash\", ORDER_HASH)\n    .Default(ORDER_TEXT);\n"));
    
    verifyFormat(new StringRef(/*KEEP_STR*/"return aaaaaaaaaaaaaaaaa->aaaaa().aaaaaaaaaaaaa().aaaaaa() <\n       aaaaaaaaaaaaaaa->aaaaa().aaaaaaaaaaaaa().aaaaaa();"));
    verifyFormat(new StringRef(/*KEEP_STR*/"aaaaaaa->aaaaaaa\n    ->aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa(\n        aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa)\n    ->aaaaaaaa(aaaaaaaaaaaaaaa);"));
    verifyFormat(new StringRef(/*KEEP_STR*/"aaaaaaa->aaaaaaa\n    ->aaaaaaaaaaaaaaaaaaaaaaa(aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa)\n    ->aaaaaaaa(aaaaaaaaaaaaaaa);"));
    verifyFormat(new StringRef(/*KEEP_STR*/"aaaaaaaaaaaaaaaaaaa()->aaaaaa(bbbbb)->aaaaaaaaaaaaaaaaaaa( // break\n    aaaaaaaaaaaaaa);"));
    verifyFormat(new StringRef(/*KEEP_STR*/"aaaaaaaaaaaaaaaaaaaaaaa *aaaaaaaaa =\n    aaaaaa->aaaaaaaaaaaa()\n        ->aaaaaaaaaaaaaaaa(\n            aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa)\n        ->aaaaaaaaaaaaaaaaa();"));
    verifyGoogleFormat(new StringRef(/*KEEP_STR*/"void f() {\n  someo->Add((new util::filetools::Handler(dir))\n                 ->OnEvent1(NewPermanentCallback(\n                     this, &HandlerHolderClass::EventHandlerCBA))\n                 ->OnEvent2(NewPermanentCallback(\n                     this, &HandlerHolderClass::EventHandlerCBB))\n                 ->OnEvent3(NewPermanentCallback(\n                     this, &HandlerHolderClass::EventHandlerCBC))\n                 ->OnEvent5(NewPermanentCallback(\n                     this, &HandlerHolderClass::EventHandlerCBD))\n                 ->OnEvent6(NewPermanentCallback(\n                     this, &HandlerHolderClass::EventHandlerCBE)));\n}"));
    
    verifyFormat(new StringRef(/*KEEP_STR*/"aaaaaaaaaaa().aaaaaaaaaaa().aaaaaaaaaaa().aaaaaaaaaaa().aaaaaaaaaaa();"));
    verifyFormat(new StringRef(/*KEEP_STR*/"aaaaaaaaaaaaaaa()\n    .aaaaaaaaaaaaaaa()\n    .aaaaaaaaaaaaaaa()\n    .aaaaaaaaaaaaaaa()\n    .aaaaaaaaaaaaaaa();"));
    verifyFormat(new StringRef(/*KEEP_STR*/"aaaaaaaaaaaaaaa.aaaaaaaaaaaaaaa()\n    .aaaaaaaaaaaaaaa()\n    .aaaaaaaaaaaaaaa()\n    .aaaaaaaaaaaaaaa();"));
    verifyFormat(new StringRef(/*KEEP_STR*/"aaaaaaaaaaaaaaa.aaaaaaaaaaaaaaa()\n    .aaaaaaaaaaaaaaa.aaaaaaaaaaaaaaa()\n    .aaaaaaaaaaaaaaa();"));
    verifyFormat(new StringRef(/*KEEP_STR*/"aaaaaaaaaaaaa->aaaaaaaaaaaaaaaaaaaaaaaa()\n    ->aaaaaaaaaaaaaae(0)\n    ->aaaaaaaaaaaaaaa();"));
    
    // Don't linewrap after very short segments.
    verifyFormat(new StringRef(/*KEEP_STR*/"a().aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa()\n    .aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa()\n    .aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa();"));
    verifyFormat(new StringRef(/*KEEP_STR*/"aa().aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa()\n    .aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa()\n    .aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa();"));
    verifyFormat(new StringRef(/*KEEP_STR*/"aaa()\n    .aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa()\n    .aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa()\n    .aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa();"));
    
    verifyFormat(new StringRef(/*KEEP_STR*/"aaaaaaaaaaaaaaaaaaaaaaaaaaa.aaaaaaaaaaaaa()\n    .aaaaaaaaaaaaaaaaaaaaaaaaaa()\n    .has<bbbbbbbbbbbbbbbbbbbbb>();"));
    verifyFormat(new StringRef(/*KEEP_STR*/"aaaaaaaaaaaaaaaaaaaaaaaaaaa.aaaaaaaaaaaaa()\n    .aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa<\n        aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa>();"));
    
    // Prefer not to break after empty parentheses.
    verifyFormat(new StringRef(/*KEEP_STR*/"FirstToken->WhitespaceRange.getBegin().getLocWithOffset(\n    First->LastNewlineOffset);"));
    
    // Prefer not to create "hanging" indents.
    verifyFormat(new StringRef(/*KEEP_STR*/"return !soooooooooooooome_map\n            .insert(aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa)\n            .second;"));
    verifyFormat(new StringRef(/*KEEP_STR*/"return aaaaaaaaaaaaaaaa\n    .aaaaaaaaaaaaaaaaaaaaaaa(aaaaaaaaaaaaaaaaa, aaaaaaaaaaaaaaaaa)\n    .aaaa(aaaaaaaaaaaaaa);"));
    // No hanging indent here.
    verifyFormat(new StringRef(/*KEEP_STR*/"aaaaaaaaaaaaaaaa.aaaaaaaaaaaaaa.aaaaaaaaaaaaaaa(\n    aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa);"));
    verifyFormat(new StringRef(/*KEEP_STR*/"aaaaaaaaaaaaaaaa.aaaaaaaaaaaaaa().aaaaaaaaaaaaaaa(\n    aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa);"));
    verifyFormat(new StringRef(/*KEEP_STR*/"aaaaaaaaaaaaaaaaaa.aaaaaaaaaaaaaaaaaaa(aaaaaaaaaaaaaaaaaaaa)\n    .aaa(aaaaaaaaaaaaaaaaaaaaaaaaaaaaa);"), 
        $c$.track(getLLVMStyleWithColumns(60))); $c$.clean();
    verifyFormat(new StringRef(/*KEEP_STR*/"aaaaaaaaaaaaaaaaaa\n    .aaaaaaaaaaaaaaaaaaa(aaaaaaaaaaaaaaaaaaaa)\n    .aaa(aaaaaaaaaaaaaaaaaaaaaaaaaaaaa);"), 
        $c$.track(getLLVMStyleWithColumns(59))); $c$.clean();
    verifyFormat(new StringRef(/*KEEP_STR*/"aaaa.aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa(\n        aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa)\n    .aaaaaa(aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa);"));
  } finally {
    $c$.$destroy();
  }
}

;
@Test
//<editor-fold defaultstate="collapsed" desc="clang::format::(anonymous namespace)::FormatTest_BreaksAccordingToOperatorPrecedence_Test::TestBody">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp", line = 4338,
 FQN="clang::format::(anonymous namespace)::FormatTest_BreaksAccordingToOperatorPrecedence_Test::TestBody", NM="_ZN5clang6format12_GLOBAL__N_151FormatTest_BreaksAccordingToOperatorPrecedence_Test8TestBodyEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp -nm=_ZN5clang6format12_GLOBAL__N_151FormatTest_BreaksAccordingToOperatorPrecedence_Test8TestBodyEv")
//</editor-fold>
public void test_BreaksAccordingToOperatorPrecedence() {
  if (markAsSkippedIfNeed(TestState.Successful)) { return; }
  verifyFormat(new StringRef(/*KEEP_STR*/"if (aaaaaaaaaaaaaaaaaaaaaaaaa ||\n    bbbbbbbbbbbbbbbbbbbbbbbbb && ccccccccccccccccccccccccc) {\n}"));
  verifyFormat(new StringRef(/*KEEP_STR*/"if (aaaaaaaaaaaaaaaaaaaaaaaaa or\n    bbbbbbbbbbbbbbbbbbbbbbbbb and cccccccccccccccccccccccc) {\n}"));
  
  verifyFormat(new StringRef(/*KEEP_STR*/"if (aaaaaaaaaaaaaaaaaaaaaaaaa && bbbbbbbbbbbbbbbbbbbbbbbbb ||\n    ccccccccccccccccccccccccc) {\n}"));
  verifyFormat(new StringRef(/*KEEP_STR*/"if (aaaaaaaaaaaaaaaaaaaaaaaaa and bbbbbbbbbbbbbbbbbbbbbbbb or\n    ccccccccccccccccccccccccc) {\n}"));
  
  verifyFormat(new StringRef(/*KEEP_STR*/"if (aaaaaaaaaaaaaaaaaaaaaaaaa || bbbbbbbbbbbbbbbbbbbbbbbbb ||\n    ccccccccccccccccccccccccc) {\n}"));
  verifyFormat(new StringRef(/*KEEP_STR*/"if (aaaaaaaaaaaaaaaaaaaaaaaaa or bbbbbbbbbbbbbbbbbbbbbbbbb or\n    ccccccccccccccccccccccccc) {\n}"));
  
  verifyFormat(new StringRef(/*KEEP_STR*/"if ((aaaaaaaaaaaaaaaaaaaaaaaaa || bbbbbbbbbbbbbbbbbbbbbbbbb) &&\n    ccccccccccccccccccccccccc) {\n}"));
  verifyFormat(new StringRef(/*KEEP_STR*/"if ((aaaaaaaaaaaaaaaaaaaaaaaaa or bbbbbbbbbbbbbbbbbbbbbbbbb) and\n    ccccccccccccccccccccccccc) {\n}"));
  
  verifyFormat(new StringRef(/*KEEP_STR*/"return aaaa & AAAAAAAAAAAAAAAAAAAAAAAAAAAAA ||\n       bbbb & BBBBBBBBBBBBBBBBBBBBBBBBBBBBB ||\n       cccc & CCCCCCCCCCCCCCCCCCCCCCCCCC ||\n       dddd & DDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDD;"));
  verifyFormat(new StringRef(/*KEEP_STR*/"return aaaa & AAAAAAAAAAAAAAAAAAAAAAAAAAAAA or\n       bbbb & BBBBBBBBBBBBBBBBBBBBBBBBBBBBB or\n       cccc & CCCCCCCCCCCCCCCCCCCCCCCCCC or\n       dddd & DDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDD;"));
  
  verifyFormat(new StringRef(/*KEEP_STR*/"if ((aaaaaaaaaa != aaaaaaaaaaaaaaa ||\n     aaaaaaaaaaaaaaaaaaaaaaaa() >= aaaaaaaaaaaaaaaaaaaa) &&\n    aaaaaaaaaaaaaaa != aa) {\n}"));
  verifyFormat(new StringRef(/*KEEP_STR*/"if ((aaaaaaaaaa != aaaaaaaaaaaaaaa or\n     aaaaaaaaaaaaaaaaaaaaaaaa() >= aaaaaaaaaaaaaaaaaaaa) and\n    aaaaaaaaaaaaaaa != aa) {\n}"));
}

;
@Test
//<editor-fold defaultstate="collapsed" desc="clang::format::(anonymous namespace)::FormatTest_BreaksAfterAssignments_Test::TestBody">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp", line = 4380,
 FQN="clang::format::(anonymous namespace)::FormatTest_BreaksAfterAssignments_Test::TestBody", NM="_ZN5clang6format12_GLOBAL__N_138FormatTest_BreaksAfterAssignments_Test8TestBodyEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp -nm=_ZN5clang6format12_GLOBAL__N_138FormatTest_BreaksAfterAssignments_Test8TestBodyEv")
//</editor-fold>
public void test_BreaksAfterAssignments() {
  if (markAsSkippedIfNeed(TestState.Successful)) { return; }
  verifyFormat(new StringRef(/*KEEP_STR*/"unsigned Cost =\n    TTI.getMemoryOpCost(I->getOpcode(), VectorTy, SI->getAlignment(),\n                        SI->getPointerAddressSpaceee());\n"));
  verifyFormat(new StringRef(/*KEEP_STR*/"CharSourceRange LineRange = CharSourceRange::getTokenRange(\n    Line.Tokens.front().Tok.getLo(), Line.Tokens.back().Tok.getLoc());"));
  
  verifyFormat(new StringRef(/*KEEP_STR*/"aaaaaaaaaaaaaaaaaaaaaaaaaa aaaa = aaaaaaaaaaaaaa(0).aaaa().aaaaaaaaa(\n    aaaaaaaaaaaaaaaaaaa::aaaaaaaaaaaaaaaaaaaaa);"));
  verifyFormat(new StringRef(/*KEEP_STR*/"unsigned OriginalStartColumn =\n    SourceMgr.getSpellingColumnNumber(\n        Current.FormatTok.getStartOfNonWhitespace()) -\n    1;"));
}

;
@Test
//<editor-fold defaultstate="collapsed" desc="clang::format::(anonymous namespace)::FormatTest_AlignsAfterAssignments_Test::TestBody">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp", line = 4398,
 FQN="clang::format::(anonymous namespace)::FormatTest_AlignsAfterAssignments_Test::TestBody", NM="_ZN5clang6format12_GLOBAL__N_138FormatTest_AlignsAfterAssignments_Test8TestBodyEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp -nm=_ZN5clang6format12_GLOBAL__N_138FormatTest_AlignsAfterAssignments_Test8TestBodyEv")
//</editor-fold>
public void test_AlignsAfterAssignments() {
  if (markAsSkippedIfNeed(TestState.Successful)) { return; }
  verifyFormat(new StringRef(/*KEEP_STR*/"int Result = aaaaaaaaaaaaaaaaaaaaaaaaa + aaaaaaaaaaaaaaaaaaaaaaaaa +\n             aaaaaaaaaaaaaaaaaaaaaaaaa;"));
  verifyFormat(new StringRef(/*KEEP_STR*/"Result += aaaaaaaaaaaaaaaaaaaaaaaaa + aaaaaaaaaaaaaaaaaaaaaaaaa +\n          aaaaaaaaaaaaaaaaaaaaaaaaa;"));
  verifyFormat(new StringRef(/*KEEP_STR*/"Result >>= aaaaaaaaaaaaaaaaaaaaaaaaa + aaaaaaaaaaaaaaaaaaaaaaaaa +\n           aaaaaaaaaaaaaaaaaaaaaaaaa;"));
  verifyFormat(new StringRef(/*KEEP_STR*/"int Result = (aaaaaaaaaaaaaaaaaaaaaaaaa + aaaaaaaaaaaaaaaaaaaaaaaaa +\n              aaaaaaaaaaaaaaaaaaaaaaaaa);"));
  verifyFormat(new StringRef(/*KEEP_STR*/"double LooooooooooooooooooooooooongResult = aaaaaaaaaaaaaaaaaaaaaaaa +\n                                            aaaaaaaaaaaaaaaaaaaaaaaa +\n                                            aaaaaaaaaaaaaaaaaaaaaaaa;"));
}

;
@Test
//<editor-fold defaultstate="collapsed" desc="clang::format::(anonymous namespace)::FormatTest_AlignsAfterReturn_Test::TestBody">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp", line = 4417,
 FQN="clang::format::(anonymous namespace)::FormatTest_AlignsAfterReturn_Test::TestBody", NM="_ZN5clang6format12_GLOBAL__N_133FormatTest_AlignsAfterReturn_Test8TestBodyEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp -nm=_ZN5clang6format12_GLOBAL__N_133FormatTest_AlignsAfterReturn_Test8TestBodyEv")
//</editor-fold>
public void test_AlignsAfterReturn() {
  if (markAsSkippedIfNeed(TestState.Successful)) { return; }
  verifyFormat(new StringRef(/*KEEP_STR*/"return aaaaaaaaaaaaaaaaaaaaaaaaa + aaaaaaaaaaaaaaaaaaaaaaaaa +\n       aaaaaaaaaaaaaaaaaaaaaaaaa;"));
  verifyFormat(new StringRef(/*KEEP_STR*/"return (aaaaaaaaaaaaaaaaaaaaaaaaa + aaaaaaaaaaaaaaaaaaaaaaaaa +\n        aaaaaaaaaaaaaaaaaaaaaaaaa);"));
  verifyFormat(new StringRef(/*KEEP_STR*/"return aaaaaaaaaaaaaaaaaaaaaa + aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa >=\n       aaaaaaaaaaaaaaaaaaaaaa();"));
  verifyFormat(new StringRef(/*KEEP_STR*/"return (aaaaaaaaaaaaaaaaaaaaaa + aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa >=\n        aaaaaaaaaaaaaaaaaaaaaa());"));
  verifyFormat(new StringRef(/*KEEP_STR*/"return aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa(\n    aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa);"));
  verifyFormat(new StringRef(/*KEEP_STR*/"return aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa(\n           aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa) &&\n       aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa;"));
  verifyFormat(new StringRef(/*KEEP_STR*/"return\n    // true if code is one of a or b.\n    code == a || code == b;"));
}

;
@Test
//<editor-fold defaultstate="collapsed" desc="clang::format::(anonymous namespace)::FormatTest_AlignsAfterOpenBracket_Test::TestBody">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp", line = 4440,
 FQN="clang::format::(anonymous namespace)::FormatTest_AlignsAfterOpenBracket_Test::TestBody", NM="_ZN5clang6format12_GLOBAL__N_138FormatTest_AlignsAfterOpenBracket_Test8TestBodyEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp -nm=_ZN5clang6format12_GLOBAL__N_138FormatTest_AlignsAfterOpenBracket_Test8TestBodyEv")
//</editor-fold>
public void test_AlignsAfterOpenBracket() {
  if (markAsSkippedIfNeed(TestState.Successful)) { return; }
  FormatStyle Style = null;
  try {
    verifyFormat(new StringRef(/*KEEP_STR*/"void aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa(aaaaaaaaaaa aaaaaaaa,\n                                                aaaaaaaaa aaaaaaa) {}"));
    verifyFormat(new StringRef(/*KEEP_STR*/"SomeLongVariableName->someVeryLongFunctionName(aaaaaaaaaaa aaaaaaaaa,\n                                               aaaaaaaaaaa aaaaaaaaa);"));
    verifyFormat(new StringRef(/*KEEP_STR*/"SomeLongVariableName->someFunction(foooooooo(aaaaaaaaaaaaaaa,\n                                             aaaaaaaaaaaaaaaaaaaaa));"));
    Style = getLLVMStyle();
    Style.AlignAfterOpenBracket = FormatStyle.BracketAlignmentStyle.BAS_DontAlign;
    verifyFormat(new StringRef(/*KEEP_STR*/"void aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa(\n    aaaaaaaaaaa aaaaaaaa, aaaaaaaaa aaaaaaa) {}"), 
        Style);
    verifyFormat(new StringRef(/*KEEP_STR*/"SomeLongVariableName->someVeryLongFunctionName(\n    aaaaaaaaaaa aaaaaaaaa, aaaaaaaaaaa aaaaaaaaa);"), 
        Style);
    verifyFormat(new StringRef(/*KEEP_STR*/"SomeLongVariableName->someFunction(\n    foooooooo(aaaaaaaaaaaaaaa, aaaaaaaaaaaaaaaaaaaaa));"), 
        Style);
    verifyFormat(new StringRef(/*KEEP_STR*/"void aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa(aaaaaaaaaaa aaaaaaaa,\n    aaaaaaaaa aaaaaaa, aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa) {}"), 
        Style);
    verifyFormat(new StringRef(/*KEEP_STR*/"SomeLongVariableName->someVeryLongFunctionName(aaaaaaaaaaa aaaaaaaaa,\n    aaaaaaaaaaa aaaaaaaaa, aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa);"), 
        Style);
    verifyFormat(new StringRef(/*KEEP_STR*/"SomeLongVariableName->someFunction(foooooooo(aaaaaaaaaaaaaaa,\n    aaaaaaaaaaaaaaaaaaaaa, aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa));"), 
        Style);
    
    verifyFormat(new StringRef(/*KEEP_STR*/"bbbbbbbbbbbb(aaaaaaaaaaaaaaaaaaaaaaaa, //\n    ccccccc(aaaaaaaaaaaaaaaaa,         //\n        b));"), 
        Style);
    
    Style.AlignAfterOpenBracket = FormatStyle.BracketAlignmentStyle.BAS_AlwaysBreak;
    Style.BinPackArguments = false;
    Style.BinPackParameters = false;
    verifyFormat(new StringRef(/*KEEP_STR*/"void aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa(\n    aaaaaaaaaaa aaaaaaaa,\n    aaaaaaaaa aaaaaaa,\n    aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa) {}"), 
        Style);
    verifyFormat(new StringRef(/*KEEP_STR*/"SomeLongVariableName->someVeryLongFunctionName(\n    aaaaaaaaaaa aaaaaaaaa,\n    aaaaaaaaaaa aaaaaaaaa,\n    aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa);"), 
        Style);
    verifyFormat(new StringRef(/*KEEP_STR*/"SomeLongVariableName->someFunction(foooooooo(\n    aaaaaaaaaaaaaaa,\n    aaaaaaaaaaaaaaaaaaaaa,\n    aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa));"), 
        Style);
    verifyFormat(new StringRef(/*KEEP_STR*/"aaaaaaaaaaaaaaaaaaaaaaaa(aaaaaaaaaaaaaaaaaaaaa(\n    aaaaaaaaaaaaaaaaaaaa(aaaaaaaaaaaaaaaaa, aaaaaaaaaaaaaaaa)));"), 
        Style);
    verifyFormat(new StringRef(/*KEEP_STR*/"aaaaaaaaaaaaaaaaaaaaaaaa(aaaaaaaaaa.aaaaaaaaaa(\n    aaaaaaaaaaaaaaaaaaaa(aaaaaaaaaaaaaaaaa, aaaaaaaaaaaaaaaa)));"), 
        Style);
    verifyFormat(new StringRef(/*KEEP_STR*/"aaaaaaaaaaaaaaaaaaaaaaaa(\n    aaaaaaaaaaaaaaaaaaaaa(\n        aaaaaaaaaaaaaaaaaaaa(aaaaaaaaaaaaaaaaa, aaaaaaaaaaaaaaaa)),\n    aaaaaaaaaaaaaaaa);"), 
        Style);
    verifyFormat(new StringRef(/*KEEP_STR*/"aaaaaaaaaaaaaaaaaaaaaaaa(\n    aaaaaaaaaaaaaaaaaaaaa(\n        aaaaaaaaaaaaaaaaaaaa(aaaaaaaaaaaaaaaaa, aaaaaaaaaaaaaaaa)) &&\n    aaaaaaaaaaaaaaaa);"), 
        Style);
  } finally {
    if (Style != null) { Style.$destroy(); }
  }
}

;
@Test
//<editor-fold defaultstate="collapsed" desc="clang::format::(anonymous namespace)::FormatTest_ParenthesesAndOperandAlignment_Test::TestBody">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp", line = 4519,
 FQN="clang::format::(anonymous namespace)::FormatTest_ParenthesesAndOperandAlignment_Test::TestBody", NM="_ZN5clang6format12_GLOBAL__N_146FormatTest_ParenthesesAndOperandAlignment_Test8TestBodyEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp -nm=_ZN5clang6format12_GLOBAL__N_146FormatTest_ParenthesesAndOperandAlignment_Test8TestBodyEv")
//</editor-fold>
public void test_ParenthesesAndOperandAlignment() {
  if (markAsSkippedIfNeed(TestState.Successful)) { return; }
  FormatStyle Style = null;
  try {
    Style = getLLVMStyleWithColumns(40);
    verifyFormat(new StringRef(/*KEEP_STR*/"int a = f(aaaaaaaaaaaaaaaaaaaaaa &&\n          bbbbbbbbbbbbbbbbbbbbbb);"), 
        Style);
    Style.AlignAfterOpenBracket = FormatStyle.BracketAlignmentStyle.BAS_Align;
    Style.AlignOperands = false;
    verifyFormat(new StringRef(/*KEEP_STR*/"int a = f(aaaaaaaaaaaaaaaaaaaaaa &&\n          bbbbbbbbbbbbbbbbbbbbbb);"), 
        Style);
    Style.AlignAfterOpenBracket = FormatStyle.BracketAlignmentStyle.BAS_DontAlign;
    Style.AlignOperands = true;
    verifyFormat(new StringRef(/*KEEP_STR*/"int a = f(aaaaaaaaaaaaaaaaaaaaaa &&\n          bbbbbbbbbbbbbbbbbbbbbb);"), 
        Style);
    Style.AlignAfterOpenBracket = FormatStyle.BracketAlignmentStyle.BAS_DontAlign;
    Style.AlignOperands = false;
    verifyFormat(new StringRef(/*KEEP_STR*/"int a = f(aaaaaaaaaaaaaaaaaaaaaa &&\n    bbbbbbbbbbbbbbbbbbbbbb);"), 
        Style);
  } finally {
    if (Style != null) { Style.$destroy(); }
  }
}

;
@Test
//<editor-fold defaultstate="collapsed" desc="clang::format::(anonymous namespace)::FormatTest_BreaksConditionalExpressions_Test::TestBody">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp", line = 4541,
 FQN="clang::format::(anonymous namespace)::FormatTest_BreaksConditionalExpressions_Test::TestBody", NM="_ZN5clang6format12_GLOBAL__N_144FormatTest_BreaksConditionalExpressions_Test8TestBodyEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp -nm=_ZN5clang6format12_GLOBAL__N_144FormatTest_BreaksConditionalExpressions_Test8TestBodyEv")
//</editor-fold>
public void test_BreaksConditionalExpressions() {
  if (markAsSkippedIfNeed(TestState.Successful)) { return; }
  FormatStyle NoBinPacking = null;
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    verifyFormat(new StringRef(/*KEEP_STR*/"aaaa(aaaaaaaaaaaaaaaaaaaa, aaaaaaaaaaaaaaaaaaaaaaaaaa\n                               ? aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa\n                               : aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa);"));
    verifyFormat(new StringRef(/*KEEP_STR*/"aaaa(aaaaaaaaaaaaaaaaaaaa, aaaaaaa ? aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa\n                                   : aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa);"));
    verifyFormat(new StringRef(/*KEEP_STR*/"aaaaaaaaaaaaaaaaaaaaaaaaaaaaaa(aaaaaaaaaaaaaaaaaaaa ? aaaa(aaaaaa)\n                                                    : aaaaaaaaaaaaa);"));
    verifyFormat(new StringRef(/*KEEP_STR*/"aaaaaaaaaaaaaaaaaa(aaaaaaaaaaaaaaaaaaaaaaaaa,\n                   aaaaaaaaaaaaaaaa ? aaaaaaaaaaaaaaaaaaaaaaaaaaaaa\n                                    : aaaaaaaaaaaaaaaaaaaaaaaaaaaa,\n                   aaaaaaaaaaaaa);"));
    verifyFormat(new StringRef(/*KEEP_STR*/"aaaaaaaaaaaaaaaaaa(aaaaaaaaaaaaaaaaaaaaaaaaa,\n                   aaaaaaaaaaaaaaaa ?: aaaaaaaaaaaaaaaaaaaaaaaaaaaa,\n                   aaaaaaaaaaaaa);"));
    verifyFormat(new StringRef(/*KEEP_STR*/"aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa\n    ? aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa(\n          aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa)\n    : aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa(\n          aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa);"));
    verifyFormat(new StringRef(/*KEEP_STR*/"aaaaaa(aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa,\n       aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa\n           ? aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa(\n                 aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa)\n           : aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa(\n                 aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa),\n       aaaaaaaaaaaaaaaaaaaaaaaaaaa);"));
    verifyFormat(new StringRef(/*KEEP_STR*/"aaaaaa(aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa,\n       aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa\n           ?: aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa(\n                  aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa),\n       aaaaaaaaaaaaaaaaaaaaaaaaaaa);"));
    verifyFormat(new StringRef(/*KEEP_STR*/"aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa\n    ? aaaaaaaaaaaaaaaaaaaaaaaaaaa\n    : aaaaaaaaaaaaaaaaaaaaaaaaaaa;"));
    verifyFormat(new StringRef(/*KEEP_STR*/"aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa aaaaaa =\n    aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa\n        ? aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa\n        : aaaaaaaaaaaaaaaa;"));
    verifyFormat(new StringRef(/*KEEP_STR*/"aaaaaaaaaaaaaaaaaaaaaaaaaaaaaa == aaaaaaaaaaaaaaaaaaaaaaaaaaaaaa\n    ? aaaaaaaaaaaaaaa\n    : aaaaaaaaaaaaaaa;"));
    verifyFormat(new StringRef(/*KEEP_STR*/"f(aaaaaaaaaaaaaaaa == // force break\n          aaaaaaaaa\n      ? b\n      : c);"));
    verifyFormat(new StringRef(/*KEEP_STR*/"return aaaa == bbbb\n           // comment\n           ? aaaa\n           : bbbb;"));
    verifyFormat(new StringRef(/*KEEP_STR*/"unsigned Indent =\n    format(TheLine.First, IndentForLevel[TheLine.Level] >= 0\n                              ? IndentForLevel[TheLine.Level]\n                              : TheLine * 2,\n           TheLine.InPPDirective, PreviousEndOfLineColumn);"), 
        $c$.track(getLLVMStyleWithColumns(70))); $c$.clean();
    verifyFormat(new StringRef(/*KEEP_STR*/"bool aaaaaa = aaaaaaaaaaaaa //\n                  ? aaaaaaaaaaaaaaa\n                  : bbbbbbbbbbbbbbb //\n                        ? ccccccccccccccc\n                        : ddddddddddddddd;"));
    verifyFormat(new StringRef(/*KEEP_STR*/"bool aaaaaa = aaaaaaaaaaaaa //\n                  ? aaaaaaaaaaaaaaa\n                  : (bbbbbbbbbbbbbbb //\n                         ? ccccccccccccccc\n                         : ddddddddddddddd);"));
    verifyFormat(new StringRef(/*KEEP_STR*/"int aaaaaaaaaaaaaaaaaaaaaaaaaaa = aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa\n                                      ? aaaaaaaaaaaaaaaaaaaaaaaaa +\n                                            aaaaaaaaaaaaaaaaaaaaa +\n                                            aaaaaaaaaaaaaaaaaaaaa\n                                      : aaaaaaaaaa;"));
    verifyFormat(new StringRef(/*KEEP_STR*/"aaaaaa = aaaaaaaaaaaa\n             ? aaaaaaaaaa ? aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa\n                          : aaaaaaaaaaaaaaaaaaaaaa\n             : aaaaaaaaaaaaaaaaaaaaaaaaaaaa;"));
    
    NoBinPacking = getLLVMStyle();
    NoBinPacking.BinPackArguments = false;
    verifyFormat(new StringRef(/*KEEP_STR*/"void f() {\n  g(aaa,\n    aaaaaaaaaa == aaaaaaaaaa ? aaaa : aaaaa,\n    aaaaaaaaaaaaaaaaaaaaaaaaaaaaaa == aaaaaaaaaaaaaaaaaaaaaaaaaaaaaa\n        ? aaaaaaaaaaaaaaa\n        : aaaaaaaaaaaaaaa);\n}"), 
        NoBinPacking);
    verifyFormat(new StringRef(/*KEEP_STR*/"void f() {\n  g(aaa,\n    aaaaaaaaaa == aaaaaaaaaa ? aaaa : aaaaa,\n    aaaaaaaaaaaaaaaaaaaaaaaaaaaaaa == aaaaaaaaaaaaaaaaaaaaaaaaaaaaaa\n        ?: aaaaaaaaaaaaaaa);\n}"), 
        NoBinPacking);
    
    verifyFormat(new StringRef(/*KEEP_STR*/"SomeFunction(aaaaaaaaaaaaaaaaa,\n             // comment.\n             ccccccccccccccccccccccccccccccccccccccc\n                 ? aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa\n                 : bbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbb);"));
    
    // Assignments in conditional expressions. Apparently not uncommon :-(.
    verifyFormat(new StringRef(/*KEEP_STR*/"return a != b\n           // comment\n           ? a = b\n           : a = b;"));
    verifyFormat(new StringRef(/*KEEP_STR*/"return a != b\n           // comment\n           ? a = a != b\n                     // comment\n                     ? a = b\n                     : a\n           : a;\n"));
    verifyFormat(new StringRef(/*KEEP_STR*/"return a != b\n           // comment\n           ? a\n           : a = a != b\n                     // comment\n                     ? a = b\n                     : a;"));
  } finally {
    if (NoBinPacking != null) { NoBinPacking.$destroy(); }
    $c$.$destroy();
  }
}

;
@Test
//<editor-fold defaultstate="collapsed" desc="clang::format::(anonymous namespace)::FormatTest_BreaksConditionalExpressionsAfterOperator_Test::TestBody">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp", line = 4672,
 FQN="clang::format::(anonymous namespace)::FormatTest_BreaksConditionalExpressionsAfterOperator_Test::TestBody", NM="_ZN5clang6format12_GLOBAL__N_157FormatTest_BreaksConditionalExpressionsAfterOperator_Test8TestBodyEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp -nm=_ZN5clang6format12_GLOBAL__N_157FormatTest_BreaksConditionalExpressionsAfterOperator_Test8TestBodyEv")
//</editor-fold>
public void test_BreaksConditionalExpressionsAfterOperator() {
  if (markAsSkippedIfNeed(TestState.Successful)) { return; }
  FormatStyle Style = null;
  try {
    Style = getLLVMStyle();
    Style.BreakBeforeTernaryOperators = false;
    Style.ColumnLimit = 70;
    verifyFormat(new StringRef(/*KEEP_STR*/"aaaa(aaaaaaaaaaaaaaaaaaaa, aaaaaaaaaaaaaaaaaaaaaaaaaa ?\n                               aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa :\n                               aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa);"), 
        Style);
    verifyFormat(new StringRef(/*KEEP_STR*/"aaaa(aaaaaaaaaaaaaaaaaaaa, aaaaaaa ? aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa :\n                                     aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa);"), 
        Style);
    verifyFormat(new StringRef(/*KEEP_STR*/"aaaaaaaaaaaaaaaaaaaaaaaaaaaaaa(aaaaaaaaaaaaaaaaaaaa ? aaaa(aaaaaa) :\n                                                      aaaaaaaaaaaaa);"), 
        Style);
    verifyFormat(new StringRef(/*KEEP_STR*/"aaaaaaaaaaaaaaaaaa(aaaaaaaaaaaaaaaaaaaaaaaaa,\n                   aaaaaaaaaaaaaaaa ? aaaaaaaaaaaaaaaaaaaaaaaaaaaaa :\n                                      aaaaaaaaaaaaaaaaaaaaaaaaaaaa,\n                   aaaaaaaaaaaaa);"), 
        Style);
    verifyFormat(new StringRef(/*KEEP_STR*/"aaaaaaaaaaaaaaaaaa(aaaaaaaaaaaaaaaaaaaaaaaaa,\n                   aaaaaaaaaaaaaaaa ?: aaaaaaaaaaaaaaaaaaaaaaaaaaaa,\n                   aaaaaaaaaaaaa);"), 
        Style);
    verifyFormat(new StringRef(/*KEEP_STR*/"aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa ?\n    aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa(\n        aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa) :\n    aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa(\n        aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa);"), 
        Style);
    verifyFormat(new StringRef(/*KEEP_STR*/"aaaaaa(aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa,\n       aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa ?\n           aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa(\n               aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa) :\n           aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa(\n               aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa),\n       aaaaaaaaaaaaaaaaaaaaaaaaaaa);"), 
        Style);
    verifyFormat(new StringRef(/*KEEP_STR*/"aaaaaa(aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa,\n       aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa ?:\n           aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa(\n               aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa),\n       aaaaaaaaaaaaaaaaaaaaaaaaaaa);"), 
        Style);
    verifyFormat(new StringRef(/*KEEP_STR*/"aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa ?\n    aaaaaaaaaaaaaaaaaaaaaaaaaaa :\n    aaaaaaaaaaaaaaaaaaaaaaaaaaa;"), 
        Style);
    verifyFormat(new StringRef(/*KEEP_STR*/"aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa aaaaaa =\n    aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa ?\n        aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa :\n        aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa;"), 
        Style);
    verifyFormat(new StringRef(/*KEEP_STR*/"aaaaaaaaaaaaaaaaaaaaaaaaaaaaaa == aaaaaaaaaaaaaaaaaaaaaaaaaaaaaa ?\n    aaaaaaaaaaaaaaa :\n    aaaaaaaaaaaaaaa;"), 
        Style);
    verifyFormat(new StringRef(/*KEEP_STR*/"f(aaaaaaaaaaaaaaaa == // force break\n          aaaaaaaaa ?\n      b :\n      c);"), 
        Style);
    verifyFormat(new StringRef(/*KEEP_STR*/"unsigned Indent =\n    format(TheLine.First, IndentForLevel[TheLine.Level] >= 0 ?\n                              IndentForLevel[TheLine.Level] :\n                              TheLine * 2,\n           TheLine.InPPDirective, PreviousEndOfLineColumn);"), 
        Style);
    verifyFormat(new StringRef(/*KEEP_STR*/"bool aaaaaa = aaaaaaaaaaaaa ? //\n                  aaaaaaaaaaaaaaa :\n                  bbbbbbbbbbbbbbb ? //\n                      ccccccccccccccc :\n                      ddddddddddddddd;"), 
        Style);
    verifyFormat(new StringRef(/*KEEP_STR*/"bool aaaaaa = aaaaaaaaaaaaa ? //\n                  aaaaaaaaaaaaaaa :\n                  (bbbbbbbbbbbbbbb ? //\n                       ccccccccccccccc :\n                       ddddddddddddddd);"), 
        Style);
    verifyFormat(new StringRef(/*KEEP_STR*/"int i = aaaaaaaaaaaaaaaaaaaaaaaaaaaaaa ?\n            /*bbbbbbbbbbbbbbb=*/bbbbbbbbbbbbbbbbbbbbbbbbb :\n            ccccccccccccccccccccccccccc;"), 
        Style);
    verifyFormat(new StringRef(/*KEEP_STR*/"return aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa ?\n           aaaaa :\n           bbbbbbbbbbbbbbb + cccccccccccccccc;"), 
        Style);
  } finally {
    if (Style != null) { Style.$destroy(); }
  }
}

;
@Test
//<editor-fold defaultstate="collapsed" desc="clang::format::(anonymous namespace)::FormatTest_DeclarationsOfMultipleVariables_Test::TestBody">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp", line = 4768,
 FQN="clang::format::(anonymous namespace)::FormatTest_DeclarationsOfMultipleVariables_Test::TestBody", NM="_ZN5clang6format12_GLOBAL__N_147FormatTest_DeclarationsOfMultipleVariables_Test8TestBodyEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp -nm=_ZN5clang6format12_GLOBAL__N_147FormatTest_DeclarationsOfMultipleVariables_Test8TestBodyEv")
//</editor-fold>
public void test_DeclarationsOfMultipleVariables() {
  if (markAsSkippedIfNeed(TestState.Successful)) { return; }
  FormatStyle Style = null;
  try {
    verifyFormat(new StringRef(/*KEEP_STR*/"bool aaaaaaaaaaaaaaaaa = aaaaaa->aaaaaaaaaaaaaaaaa(),\n     aaaaaaaaaaa = aaaaaa->aaaaaaaaaaa();"));
    verifyFormat(new StringRef(/*KEEP_STR*/"bool a = true, b = false;"));
    
    verifyFormat(new StringRef(/*KEEP_STR*/"bool aaaaaaaaaaaaaaaaaaaaaaaaa =\n         aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa(aaaaaaaaaaaaaaaa),\n     bbbbbbbbbbbbbbbbbbbbbbbbb =\n         bbbbbbbbbbbbbbbbbbbbbbbbbbbbbbb(bbbbbbbbbbbbbbbb);"));
    verifyFormat(new StringRef(/*KEEP_STR*/"bool aaaaaaaaaaaaaaaaaaaaa =\n         bbbbbbbbbbbbbbbbbbbbbbbbbbbb && cccccccccccccccccccccccccccc,\n     d = e && f;"));
    verifyFormat(new StringRef(/*KEEP_STR*/"aaaaaaaaa a = aaaaaaaaaaaaaaaaaaaa, b = bbbbbbbbbbbbbbbbbbbb,\n          c = cccccccccccccccccccc, d = dddddddddddddddddddd;"));
    verifyFormat(new StringRef(/*KEEP_STR*/"aaaaaaaaa *a = aaaaaaaaaaaaaaaaaaa, *b = bbbbbbbbbbbbbbbbbbb,\n          *c = ccccccccccccccccccc, *d = ddddddddddddddddddd;"));
    verifyFormat(new StringRef(/*KEEP_STR*/"aaaaaaaaa ***a = aaaaaaaaaaaaaaaaaaa, ***b = bbbbbbbbbbbbbbb,\n          ***c = ccccccccccccccccccc, ***d = ddddddddddddddd;"));
    
    Style = getGoogleStyle();
    Style.PointerAlignment = FormatStyle.PointerAlignmentStyle.PAS_Left;
    Style.DerivePointerAlignment = false;
    verifyFormat(new StringRef(/*KEEP_STR*/"aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa\n    *aaaaaaaaaaaaaaaaaaaaaaaaaaaaa = aaaaaaaaaaaaaaaaaaa,\n    *b = bbbbbbbbbbbbbbbbbbb;"), 
        Style);
    verifyFormat(new StringRef(/*KEEP_STR*/"aaaaaaaaa *a = aaaaaaaaaaaaaaaaaaa, *b = bbbbbbbbbbbbbbbbbbb,\n          *b = bbbbbbbbbbbbbbbbbbb, *d = ddddddddddddddddddd;"), 
        Style);
  } finally {
    if (Style != null) { Style.$destroy(); }
  }
}

;
@Test
//<editor-fold defaultstate="collapsed" desc="clang::format::(anonymous namespace)::FormatTest_ConditionalExpressionsInBrackets_Test::TestBody">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp", line = 4800,
 FQN="clang::format::(anonymous namespace)::FormatTest_ConditionalExpressionsInBrackets_Test::TestBody", NM="_ZN5clang6format12_GLOBAL__N_148FormatTest_ConditionalExpressionsInBrackets_Test8TestBodyEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp -nm=_ZN5clang6format12_GLOBAL__N_148FormatTest_ConditionalExpressionsInBrackets_Test8TestBodyEv")
//</editor-fold>
public void test_ConditionalExpressionsInBrackets() {
  if (markAsSkippedIfNeed(TestState.Successful)) { return; }
  verifyFormat(new StringRef(/*KEEP_STR*/"arr[foo ? bar : baz];"));
  verifyFormat(new StringRef(/*KEEP_STR*/"f()[foo ? bar : baz];"));
  verifyFormat(new StringRef(/*KEEP_STR*/"(a + b)[foo ? bar : baz];"));
  verifyFormat(new StringRef(/*KEEP_STR*/"arr[foo ? (4 > 5 ? 4 : 5) : 5 < 5 ? 5 : 7];"));
}

;
@Test
//<editor-fold defaultstate="collapsed" desc="clang::format::(anonymous namespace)::FormatTest_AlignsStringLiterals_Test::TestBody">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp", line = 4807,
 FQN="clang::format::(anonymous namespace)::FormatTest_AlignsStringLiterals_Test::TestBody", NM="_ZN5clang6format12_GLOBAL__N_136FormatTest_AlignsStringLiterals_Test8TestBodyEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp -nm=_ZN5clang6format12_GLOBAL__N_136FormatTest_AlignsStringLiterals_Test8TestBodyEv")
//</editor-fold>
public void test_AlignsStringLiterals() {
  if (markAsSkippedIfNeed(TestState.Successful)) { return; }
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    verifyFormat(new StringRef(/*KEEP_STR*/"loooooooooooooooooooooooooongFunction(\"short literal \"\n                                      \"short literal\");"));
    verifyFormat(new StringRef(/*KEEP_STR*/"looooooooooooooooooooooooongFunction(\n    \"short literal\"\n    \"looooooooooooooooooooooooooooooooooooooooooooooooong literal\");"));
    verifyFormat(new StringRef(/*KEEP_STR*/"someFunction(\"Always break between multi-line\"\n             \" string literals\",\n             and, other, parameters);"));
    EXPECT_EQ("fun + \"1243\" /* comment */\n      \"5678\";",$c$.clean(format(new StringRef(/*KEEP_STR*/"fun + \"1243\" /* comment */\n      \"5678\";"), $c$.track(getLLVMStyleWithColumns(28)))));
    EXPECT_EQ("aaaaaa = \"aaaaaaaaaaaaaaaaaaaaaaaaaa aaaaaaaaaaaaaaaaaaaaaaaaaaaa \"\n         \"aaaaaaaaaaaaaaaaaaaaa\"\n         \"aaaaaaaaaaaaaaaa\";",format(new StringRef(/*KEEP_STR*/"aaaaaa =\"aaaaaaaaaaaaaaaaaaaaaaaaaa aaaaaaaaaaaaaaaaaaaaaaaaaaaa aaaaaaaaaaaaaaaaaaaaa\" \"aaaaaaaaaaaaaaaa\";")));
    verifyFormat(new StringRef(/*KEEP_STR*/"a = a + \"a\"\n        \"a\"\n        \"a\";"));
    verifyFormat(new StringRef(/*KEEP_STR*/"f(\"a\", \"b\"\n       \"c\");"));
    
    verifyFormat(new StringRef(/*KEEP_STR*/"#define LL_FORMAT \"ll\"\nprintf(\"aaaaa: %d, bbbbbb: %\" LL_FORMAT \"d, cccccccc: %\" LL_FORMAT\n       \"d, ddddddddd: %\" LL_FORMAT \"d\");"));
    
    verifyFormat(new StringRef(/*KEEP_STR*/"#define A(X)          \\\n  \"aaaaa\" #X \"bbbbbb\" \\\n  \"ccccc\""), 
        $c$.track(getLLVMStyleWithColumns(23))); $c$.clean();
    verifyFormat(new StringRef(/*KEEP_STR*/"#define A \"def\"\nf(\"abc\" A \"ghi\"\n  \"jkl\");"));
    
    verifyFormat(new StringRef(/*KEEP_STR*/"f(L\"a\"\n  L\"b\");"));
    verifyFormat(new StringRef(/*KEEP_STR*/"#define A(X)            \\\n  L\"aaaaa\" #X L\"bbbbbb\" \\\n  L\"ccccc\""), 
        $c$.track(getLLVMStyleWithColumns(25))); $c$.clean();
    
    verifyFormat(new StringRef(/*KEEP_STR*/"f(@\"a\"\n  @\"b\");"));
    verifyFormat(new StringRef(/*KEEP_STR*/"NSString s = @\"a\"\n             @\"b\"\n             @\"c\";"));
    verifyFormat(new StringRef(/*KEEP_STR*/"NSString s = @\"a\"\n              \"b\"\n              \"c\";"));
  } finally {
    $c$.$destroy();
  }
}

;
@Test
//<editor-fold defaultstate="collapsed" desc="clang::format::(anonymous namespace)::FormatTest_ReturnTypeBreakingStyle_Test::TestBody">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp", line = 4866,
 FQN="clang::format::(anonymous namespace)::FormatTest_ReturnTypeBreakingStyle_Test::TestBody", NM="_ZN5clang6format12_GLOBAL__N_139FormatTest_ReturnTypeBreakingStyle_Test8TestBodyEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp -nm=_ZN5clang6format12_GLOBAL__N_139FormatTest_ReturnTypeBreakingStyle_Test8TestBodyEv")
//</editor-fold>
public void test_ReturnTypeBreakingStyle() {
  if (markAsSkippedIfNeed(TestState.Successful)) { return; }
  FormatStyle Style = null;
  try {
    Style = getLLVMStyle();
    // No declarations or definitions should be moved to own line.
    Style.AlwaysBreakAfterReturnType = FormatStyle.ReturnTypeBreakingStyle.RTBS_None;
    verifyFormat(new StringRef(/*KEEP_STR*/"class A {\n  int f() { return 1; }\n  int g();\n};\nint f() { return 1; }\nint g();\n"), 
        Style);
    
    // All declarations and definitions should have the return type moved to its
    // own
    // line.
    Style.AlwaysBreakAfterReturnType = FormatStyle.ReturnTypeBreakingStyle.RTBS_All;
    verifyFormat(new StringRef(/*KEEP_STR*/"class E {\n  int\n  f() {\n    return 1;\n  }\n  int\n  g();\n};\nint\nf() {\n  return 1;\n}\nint\ng();\n"), 
        Style);
    
    // Top-level definitions, and no kinds of declarations should have the
    // return type moved to its own line.
    Style.AlwaysBreakAfterReturnType = FormatStyle.ReturnTypeBreakingStyle.RTBS_TopLevelDefinitions;
    verifyFormat(new StringRef(/*KEEP_STR*/"class B {\n  int f() { return 1; }\n  int g();\n};\nint\nf() {\n  return 1;\n}\nint g();\n"), 
        Style);
    
    // Top-level definitions and declarations should have the return type moved
    // to its own line.
    Style.AlwaysBreakAfterReturnType = FormatStyle.ReturnTypeBreakingStyle.RTBS_TopLevel;
    verifyFormat(new StringRef(/*KEEP_STR*/"class C {\n  int f() { return 1; }\n  int g();\n};\nint\nf() {\n  return 1;\n}\nint\ng();\n"), 
        Style);
    
    // All definitions should have the return type moved to its own line, but no
    // kinds of declarations.
    Style.AlwaysBreakAfterReturnType = FormatStyle.ReturnTypeBreakingStyle.RTBS_AllDefinitions;
    verifyFormat(new StringRef(/*KEEP_STR*/"class D {\n  int\n  f() {\n    return 1;\n  }\n  int g();\n};\nint\nf() {\n  return 1;\n}\nint g();\n"), 
        Style);
    verifyFormat(new StringRef(/*KEEP_STR*/"const char *\nf(void) {\n  return \"\";\n}\nconst char *bar(void);\n"),  // No break here.
        Style);
    verifyFormat(new StringRef(/*KEEP_STR*/"template <class T>\nT *\nf(T &c) {\n  return NULL;\n}\ntemplate <class T> T *f(T &c);\n"),  // No break here.
        Style);
    verifyFormat(new StringRef(/*KEEP_STR*/"class C {\n  int\n  operator+() {\n    return 1;\n  }\n  int\n  operator()() {\n    return 1;\n  }\n};\n"), 
        Style);
    verifyFormat(new StringRef(/*KEEP_STR*/"void\nA::operator()() {}\nvoid\nA::operator>>() {}\nvoid\nA::operator+() {}\n"), 
        Style);
    verifyFormat(new StringRef(/*KEEP_STR*/"void *operator new(std::size_t s);"),  // No break here.
        Style);
    verifyFormat(new StringRef(/*KEEP_STR*/"void *\noperator new(std::size_t s) {}"), 
        Style);
    verifyFormat(new StringRef(/*KEEP_STR*/"void *\noperator delete[](void *ptr) {}"), 
        Style);
    Style.BreakBeforeBraces = FormatStyle.BraceBreakingStyle.BS_Stroustrup;
    verifyFormat(new StringRef(/*KEEP_STR*/"const char *\nf(void)\n{\n  return \"\";\n}\nconst char *bar(void);\n"),  // No break here.
        Style);
    verifyFormat(new StringRef(/*KEEP_STR*/"template <class T>\nT *\nf(T &c)\n{\n  return NULL;\n}\ntemplate <class T> T *f(T &c);\n"),  // No break here.
        Style);
  } finally {
    if (Style != null) { Style.$destroy(); }
  }
}

;
@Test
//<editor-fold defaultstate="collapsed" desc="clang::format::(anonymous namespace)::FormatTest_AlwaysBreakBeforeMultilineStrings_Test::TestBody">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp", line = 5000,
 FQN="clang::format::(anonymous namespace)::FormatTest_AlwaysBreakBeforeMultilineStrings_Test::TestBody", NM="_ZN5clang6format12_GLOBAL__N_149FormatTest_AlwaysBreakBeforeMultilineStrings_Test8TestBodyEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp -nm=_ZN5clang6format12_GLOBAL__N_149FormatTest_AlwaysBreakBeforeMultilineStrings_Test8TestBodyEv")
//</editor-fold>
public void test_AlwaysBreakBeforeMultilineStrings() {
  if (markAsSkippedIfNeed(TestState.Successful)) { return; }
  FormatStyle NoBreak = null;
  FormatStyle Break = null;
  try {
    NoBreak = getLLVMStyle();
    NoBreak.AlwaysBreakBeforeMultilineStrings = false;
    Break = getLLVMStyle();
    Break.AlwaysBreakBeforeMultilineStrings = true;
    verifyFormat(new StringRef(/*KEEP_STR*/"aaaa = \"bbbb\"\n       \"cccc\";"), 
        NoBreak);
    verifyFormat(new StringRef(/*KEEP_STR*/"aaaa =\n    \"bbbb\"\n    \"cccc\";"), 
        Break);
    verifyFormat(new StringRef(/*KEEP_STR*/"aaaa(\"bbbb\"\n     \"cccc\");"), 
        NoBreak);
    verifyFormat(new StringRef(/*KEEP_STR*/"aaaa(\n    \"bbbb\"\n    \"cccc\");"), 
        Break);
    verifyFormat(new StringRef(/*KEEP_STR*/"aaaa(qqq, \"bbbb\"\n          \"cccc\");"), 
        NoBreak);
    verifyFormat(new StringRef(/*KEEP_STR*/"aaaa(qqq,\n     \"bbbb\"\n     \"cccc\");"), 
        Break);
    verifyFormat(new StringRef(/*KEEP_STR*/"aaaa(qqq,\n     L\"bbbb\"\n     L\"cccc\");"), 
        Break);
    verifyFormat(new StringRef(/*KEEP_STR*/"aaaaa(aaaaaa, aaaaaaa(\"aaaa\"\n                      \"bbbb\"));"), 
        Break);
    verifyFormat(new StringRef(/*KEEP_STR*/"string s = someFunction(\n    \"abc\"\n    \"abc\");"), 
        Break);
    
    // As we break before unary operators, breaking right after them is bad.
    verifyFormat(new StringRef(/*KEEP_STR*/"string foo = abc ? \"x\"\n                   \"blah blah blah blah blah blah\"\n                 : \"y\";"), 
        Break);
    
    // Don't break if there is no column gain.
    verifyFormat(new StringRef(/*KEEP_STR*/"f(\"aaaa\"\n  \"bbbb\");"), 
        Break);
    
    // Treat literals with escaped newlines like multi-line string literals.
    EXPECT_EQ("x = \"a\\\nb\\\nc\";",format(new StringRef(/*KEEP_STR*/"x = \"a\\\nb\\\nc\";"), NoBreak));
    EXPECT_EQ("xxxx =\n    \"a\\\nb\\\nc\";",format(new StringRef(/*KEEP_STR*/"xxxx = \"a\\\nb\\\nc\";"), Break));
    
    // Exempt ObjC strings for now.
    EXPECT_EQ("NSString *const kString = @\"aaaa\"\n                          @\"bbbb\";",format(new StringRef(/*KEEP_STR*/"NSString *const kString = @\"aaaa\"\n@\"bbbb\";"), Break));
    
    Break.ColumnLimit = 0;
    verifyFormat(new StringRef(/*KEEP_STR*/"const char *hello = \"hello llvm\";"), Break);
  } finally {
    if (Break != null) { Break.$destroy(); }
    if (NoBreak != null) { NoBreak.$destroy(); }
  }
}

;
@Test
//<editor-fold defaultstate="collapsed" desc="clang::format::(anonymous namespace)::FormatTest_AlignsPipes_Test::TestBody">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp", line = 5077,
 FQN="clang::format::(anonymous namespace)::FormatTest_AlignsPipes_Test::TestBody", NM="_ZN5clang6format12_GLOBAL__N_127FormatTest_AlignsPipes_Test8TestBodyEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp -nm=_ZN5clang6format12_GLOBAL__N_127FormatTest_AlignsPipes_Test8TestBodyEv")
//</editor-fold>
public void test_AlignsPipes() {
  if (markAsSkippedIfNeed(TestState.Successful)) { return; }
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    verifyFormat(new StringRef(/*KEEP_STR*/"aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa\n    << aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa\n    << aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa;"));
    verifyFormat(new StringRef(/*KEEP_STR*/"aaaaaaaaaaaaaaaaaaaa << aaaaaaaaaaaaaaaaaaaa << aaaaaaaaaaaaaaaaaaaa\n                     << aaaaaaaaaaaaaaaaaaaa;"));
    verifyFormat(new StringRef(/*KEEP_STR*/"aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa << aaaaaaaaaaaaaaaaaaaaaaaaaaaa\n                                 << aaaaaaaaaaaaaaaaaaaaaaaaaaaa;"));
    verifyFormat(new StringRef(/*KEEP_STR*/"llvm::outs() << \"aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa\"\n                \"bbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbb\"\n             << \"ccccccccccccccccccccccccccccccccccccccccccccccccc\";"));
    verifyFormat(new StringRef(/*KEEP_STR*/"aaaaaaaa << (aaaaaaaaaaaaaaaaaaa << aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa\n                                 << aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa)\n         << aaaaaaaaaaaaaaaaaaaaaaaaaaaaa;"));
    verifyFormat(new StringRef(/*KEEP_STR*/"llvm::errs() << aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa(\n                    aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa,\n                    aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa)\n             << bbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbb;"));
    verifyFormat(new StringRef(/*KEEP_STR*/"llvm::errs() << \"aaaaaaaaaaaaaaaaaaaaaaa: \"\n             << aaaaaaaaaaaaaaaaa(aaaaaaaa, aaaaaaaaaaa);"));
    verifyFormat(new StringRef(/*KEEP_STR*/"llvm::errs() << aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa(\n    aaaaaaaaaaaaaaaaaaaaaaaaaaaa, aaaaaaaaaaaaaaaaaaaaaaaaaaaa);"));
    
    verifyFormat(new StringRef(/*KEEP_STR*/"return out << \"somepacket = {\\n\"\n           << \" aaaaaa = \" << pkt.aaaaaa << \"\\n\"\n           << \" bbbb = \" << pkt.bbbb << \"\\n\"\n           << \" cccccc = \" << pkt.cccccc << \"\\n\"\n           << \" ddd = [\" << pkt.ddd << \"]\\n\"\n           << \"}\";"));
    
    verifyFormat(new StringRef(/*KEEP_STR*/"llvm::outs() << \"aaaaaaaaaaaaaaaa: \" << aaaaaaaaaaaaaaaa\n             << \"aaaaaaaaaaaaaaaa: \" << aaaaaaaaaaaaaaaa\n             << \"aaaaaaaaaaaaaaaa: \" << aaaaaaaaaaaaaaaa;"));
    verifyFormat(new StringRef(/*KEEP_STR*/"llvm::outs() << \"aaaaaaaaaaaaaaaaa = \" << aaaaaaaaaaaaaaaaa\n             << \"bbbbbbbbbbbbbbbbb = \" << bbbbbbbbbbbbbbbbb\n             << \"ccccccccccccccccc = \" << ccccccccccccccccc\n             << \"ddddddddddddddddd = \" << ddddddddddddddddd\n             << \"eeeeeeeeeeeeeeeee = \" << eeeeeeeeeeeeeeeee;"));
    verifyFormat(new StringRef(/*KEEP_STR*/"llvm::outs() << aaaaaaaaaaaaaaaaaaaaaaaa << \"=\"\n             << bbbbbbbbbbbbbbbbbbbbbbbbbbbbbbb;"));
    verifyFormat(new StringRef(/*KEEP_STR*/"void f() {\n  llvm::outs() << \"aaaaaaaaaaaaaaaaaaaa: \"\n               << aaaaaaaaaaaaa(aaaaaaaaaaaaaaaaaaaaaaaaaaaa);\n}"));
    verifyFormat(new StringRef(/*KEEP_STR*/"llvm::outs() << \"aaaaaaaaaaaaaaaa: \"\n             << aaaaaaaa.aaaaaaaaaaaa(aaa)->aaaaaaaaaaaaaa();"));
    verifyFormat(new StringRef(/*KEEP_STR*/"llvm::errs() << aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa(\n                    aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa,\n                    aaaaaaaaaaaaaaaaaaaaa)\n             << aaaaaaaaaaaaaaaaaaaaaaaaaa;"));
    verifyFormat(new StringRef(/*KEEP_STR*/"LOG_IF(aaa == //\n       bbb)\n    << a << b;"));
    
    // Breaking before the first "<<" is generally not desirable.
    verifyFormat(new StringRef(/*KEEP_STR*/"llvm::errs()\n    << \"aaaaaaaaaaaaaaaaaaa: \" << aaaaaaaaaaaaaaaaaaaaaaaaaaaa\n    << \"aaaaaaaaaaaaaaaaaaa: \" << aaaaaaaaaaaaaaaaaaaaaaaaaaaa\n    << \"aaaaaaaaaaaaaaaaaaa: \" << aaaaaaaaaaaaaaaaaaaaaaaaaaaa\n    << \"aaaaaaaaaaaaaaaaaaa: \" << aaaaaaaaaaaaaaaaaaaaaaaaaaaa;"), 
        $c$.track(getLLVMStyleWithColumns(70))); $c$.clean();
    verifyFormat(new StringRef(/*KEEP_STR*/"llvm::errs() << \"aaaaaaaaaaaaaaaaaaa: \"\n             << aaaaaaaaaaaaaaaaaaaaaaaaaaaa\n             << \"aaaaaaaaaaaaaaaaaaa: \"\n             << aaaaaaaaaaaaaaaaaaaaaaaaaaaa\n             << \"aaaaaaaaaaaaaaaaaaa: \"\n             << aaaaaaaaaaaaaaaaaaaaaaaaaaaa;"), 
        $c$.track(getLLVMStyleWithColumns(70))); $c$.clean();
    
    // But sometimes, breaking before the first "<<" is desirable.
    verifyFormat(new StringRef(/*KEEP_STR*/"Diag(aaaaaaaaaaaaaaaaaaaa, aaaaaaaa)\n    << aaaaaaaaaaaaaaaaaaaaaaaaa(aaaaaaaaaaaaa);"));
    verifyFormat(new StringRef(/*KEEP_STR*/"Diag(aaaaaaaaaaaaaaaaaaaaaaaaaaaaa, bbbbbbbbb)\n    << aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa\n    << aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa;"));
    verifyFormat(new StringRef(/*KEEP_STR*/"SemaRef.Diag(Loc, diag::note_for_range_begin_end)\n    << BEF << IsTemplate << Description << E->getType();"));
    verifyFormat(new StringRef(/*KEEP_STR*/"Diag(aaaaaaaaaaaaaaaaaaaa, aaaaaaaa)\n    << aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa(\n           aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa);"));
    verifyFormat(new StringRef(/*KEEP_STR*/"Diag(aaaaaaaaaaaaaaaaaaaa, aaaaaaaa)\n    << aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa(\n           aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa)\n    << aaa;"));
    
    verifyFormat(new StringRef(/*KEEP_STR*/"llvm::errs() << aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa\n                    .aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa();"));
    
    EXPECT_EQ("llvm::errs() << \"\n             << a;",format(new StringRef(/*KEEP_STR*/"llvm::errs() << \"\n<<a;")));
    
    verifyFormat(new StringRef(/*KEEP_STR*/"void f() {\n  CHECK_EQ(aaaa, (*bbbbbbbbb)->cccccc)\n      << \"qqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqq\";\n}"));
    
    // Handle 'endl'.
    verifyFormat(new StringRef(/*KEEP_STR*/"llvm::errs() << aaaaaaaaaaaaaaaaaaaaaa << endl\n             << bbbbbbbbbbbbbbbbbbbbbb << endl;"));
    verifyFormat(new StringRef(/*KEEP_STR*/"llvm::errs() << endl << bbbbbbbbbbbbbbbbbbbbbb << endl;"));
    
    // Handle '\n'.
    verifyFormat(new StringRef(/*KEEP_STR*/"llvm::errs() << aaaaaaaaaaaaaaaaaaaaaa << \"\\n\"\n             << bbbbbbbbbbbbbbbbbbbbbb << \"\\n\";"));
    verifyFormat(new StringRef(/*KEEP_STR*/"llvm::errs() << aaaaaaaaaaaaaaaaaaaaaa << '\\n'\n             << bbbbbbbbbbbbbbbbbbbbbb << '\\n';"));
    verifyFormat(new StringRef(/*KEEP_STR*/"llvm::errs() << aaaa << \"aaaaaaaaaaaaaaaaaa\\n\"\n             << bbbb << \"bbbbbbbbbbbbbbbbbb\\n\";"));
    verifyFormat(new StringRef(/*KEEP_STR*/"llvm::errs() << \"\\n\" << bbbbbbbbbbbbbbbbbbbbbb << \"\\n\";"));
  } finally {
    $c$.$destroy();
  }
}

;
@Test
//<editor-fold defaultstate="collapsed" desc="clang::format::(anonymous namespace)::FormatTest_UnderstandsEquals_Test::TestBody">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp", line = 5200,
 FQN="clang::format::(anonymous namespace)::FormatTest_UnderstandsEquals_Test::TestBody", NM="_ZN5clang6format12_GLOBAL__N_133FormatTest_UnderstandsEquals_Test8TestBodyEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp -nm=_ZN5clang6format12_GLOBAL__N_133FormatTest_UnderstandsEquals_Test8TestBodyEv")
//</editor-fold>
public void test_UnderstandsEquals() {
  if (markAsSkippedIfNeed(TestState.Successful)) { return; }
  verifyFormat(new StringRef(/*KEEP_STR*/"aaaaaaaaaaaaaaaaa =\n    aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa;"));
  verifyFormat(new StringRef(/*KEEP_STR*/"if (aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa =\n        aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa) {\n}"));
  verifyFormat(new StringRef(/*KEEP_STR*/"if (a) {\n  f();\n} else if (aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa =\n               aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa) {\n}"));
  
  verifyFormat(new StringRef(/*KEEP_STR*/"if (int aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa =\n        100000000 + 10000000) {\n}"));
}

;
@Test
//<editor-fold defaultstate="collapsed" desc="clang::format::(anonymous namespace)::FormatTest_WrapsAtFunctionCallsIfNecessary_Test::TestBody">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp", line = 5218,
 FQN="clang::format::(anonymous namespace)::FormatTest_WrapsAtFunctionCallsIfNecessary_Test::TestBody", NM="_ZN5clang6format12_GLOBAL__N_147FormatTest_WrapsAtFunctionCallsIfNecessary_Test8TestBodyEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp -nm=_ZN5clang6format12_GLOBAL__N_147FormatTest_WrapsAtFunctionCallsIfNecessary_Test8TestBodyEv")
//</editor-fold>
public void test_WrapsAtFunctionCallsIfNecessary() {
  if (markAsSkippedIfNeed(TestState.Successful)) { return; }
  FormatStyle NoBinPacking = null;
  try {
    verifyFormat(new StringRef(/*KEEP_STR*/"LoooooooooooooooooooooooooooooooooooooongObject\n    .looooooooooooooooooooooooooooooooooooooongFunction();"));
    
    verifyFormat(new StringRef(/*KEEP_STR*/"LoooooooooooooooooooooooooooooooooooooongObject\n    ->looooooooooooooooooooooooooooooooooooooongFunction();"));
    
    verifyFormat(new StringRef(/*KEEP_STR*/"LooooooooooooooooooooooooooooooooongObject->shortFunction(Parameter1,\n                                                          Parameter2);"));
    
    verifyFormat(new StringRef(/*KEEP_STR*/"ShortObject->shortFunction(\n    LooooooooooooooooooooooooooooooooooooooooooooooongParameter1,\n    LooooooooooooooooooooooooooooooooooooooooooooooongParameter2);"));
    
    verifyFormat(new StringRef(/*KEEP_STR*/"loooooooooooooongFunction(\n    LoooooooooooooongObject->looooooooooooooooongFunction());"));
    
    verifyFormat(new StringRef(/*KEEP_STR*/"function(LoooooooooooooooooooooooooooooooooooongObject\n             ->loooooooooooooooooooooooooooooooooooooooongFunction());"));
    
    verifyFormat(new StringRef(/*KEEP_STR*/"EXPECT_CALL(SomeObject, SomeFunction(Parameter))\n    .WillRepeatedly(Return(SomeValue));"));
    verifyFormat(new StringRef(/*KEEP_STR*/"void f() {\n  EXPECT_CALL(SomeObject, SomeFunction(Parameter))\n      .Times(2)\n      .WillRepeatedly(Return(SomeValue));\n}"));
    verifyFormat(new StringRef(/*KEEP_STR*/"SomeMap[std::pair(aaaaaaaaaaaa, bbbbbbbbbbbbbbb)].insert(\n    ccccccccccccccccccccccc);"));
    verifyFormat(new StringRef(/*KEEP_STR*/"aaaaa(aaaaa(aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa,\n            aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa)\n          .aaaaa(aaaaa),\n      aaaaaaaaaaaaaaaaaaaaa);"));
    verifyFormat(new StringRef(/*KEEP_STR*/"void f() {\n  aaaaaaaaaaaaaaaaaaaaaaaaa(\n      aaaaaaaaaaaaa(aaaaaaaaaaaaaaaaaaaaaaaaa)->aaaaaaaaa());\n}"));
    verifyFormat(new StringRef(/*KEEP_STR*/"aaaaa(aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa,\n      aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa)\n    .aaaaaaaaaaaaaaa(aa(aaaaaaaaaaaaaaaaaaaaaaaaaaa,\n                        aaaaaaaaaaaaaaaaaaaaaaaaaaa,\n                        aaaaaaaaaaaaaaaaaaaaaaaaaaa));"));
    verifyFormat(new StringRef(/*KEEP_STR*/"if (aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa\n        .aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa\n        .aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa\n        .aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa()) {\n}"));
    
    // Here, it is not necessary to wrap at "." or "->".
    verifyFormat(new StringRef(/*KEEP_STR*/"if (aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa(aaaaaaaaaaaa) ||\n    aaaa.aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa) {\n}"));
    verifyFormat(new StringRef(/*KEEP_STR*/"aaaaaaaaaaa->aaaaaaaaa(\n    aaaaaaaaaaaaaaaaaaaaaaaaa,\n    aaaaaaaaaaaaaaaaaa->aaaaaaaaa(aaaaaaaaaaaaaaaaaaaaaaaaa));\n"));
    
    verifyFormat(new StringRef(/*KEEP_STR*/"aaaaaaaaaaaaaaaaaaaaaaaaa(\n    aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa().aaaaaaaaaaaaaaaaa());"));
    verifyFormat(new StringRef(/*KEEP_STR*/"a->aaaaaa()->aaaaaaaaaaa(aaaaaaaa()->aaaaaa()->aaaaa() *\n                         aaaaaaaaa()->aaaaaa()->aaaaa());"));
    verifyFormat(new StringRef(/*KEEP_STR*/"a->aaaaaa()->aaaaaaaaaaa(aaaaaaaa()->aaaaaa()->aaaaa() ||\n                         aaaaaaaaa()->aaaaaa()->aaaaa());"));
    
    verifyFormat(new StringRef(/*KEEP_STR*/"aaaaa(aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa,\n      aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa)\n    .a();"));
    
    NoBinPacking = getLLVMStyle();
    NoBinPacking.BinPackParameters = false;
    verifyFormat(new StringRef(/*KEEP_STR*/"aaaaaaaaaaaaaaaaaaaaaa(aaaaaaaaaaaaaaaaaaaaa)\n    .aaaaaaaaaaaaaaaaa(aaaaaaaaaaaaaaaaaaaaa)\n    .aaaaaaaaaaaaaaaaaaa(aaaaaaaaaaaaaaaaaaa,\n                         aaaaaaaaaaaaaaaaaaa,\n                         aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa);"), 
        NoBinPacking);
    
    // If there is a subsequent call, change to hanging indentation.
    verifyFormat(new StringRef(/*KEEP_STR*/"aaaaaaaaaaaaaaaaaaaa(aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa(\n                         aaaaaaaaaaaaaaaaaa, aaaaaaaaaaaaaaaaa))\n    .aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa();"));
    verifyFormat(new StringRef(/*KEEP_STR*/"aaaaaaaaaaaaaaaaaaaa(aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa(\n    aaaaaaaaaaaaaaaaaa, aaaaaaaaaaaaaaaaa));"));
    verifyFormat(new StringRef(/*KEEP_STR*/"aaaaaaaaaa = aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa(\n                 aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa)\n                 .aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa();"));
    verifyFormat(new StringRef(/*KEEP_STR*/"aaaaaaaaaa(aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa(\n               aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa)\n               .aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa());"));
  } finally {
    if (NoBinPacking != null) { NoBinPacking.$destroy(); }
  }
}

;
@Test
//<editor-fold defaultstate="collapsed" desc="clang::format::(anonymous namespace)::FormatTest_WrapsTemplateDeclarations_Test::TestBody">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp", line = 5314,
 FQN="clang::format::(anonymous namespace)::FormatTest_WrapsTemplateDeclarations_Test::TestBody", NM="_ZN5clang6format12_GLOBAL__N_141FormatTest_WrapsTemplateDeclarations_Test8TestBodyEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp -nm=_ZN5clang6format12_GLOBAL__N_141FormatTest_WrapsTemplateDeclarations_Test8TestBodyEv")
//</editor-fold>
public void test_WrapsTemplateDeclarations() {
  if (markAsSkippedIfNeed(TestState.Successful)) { return; }
  FormatStyle AlwaysBreak = null;
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    verifyFormat(new StringRef(/*KEEP_STR*/"template <typename T>\nvirtual void loooooooooooongFunction(int Param1, int Param2);"));
    verifyFormat(new StringRef(/*KEEP_STR*/"template <typename T>\n// T should be one of {A, B}.\nvirtual void loooooooooooongFunction(int Param1, int Param2);"));
    verifyFormat(new StringRef(/*KEEP_STR*/"template <typename T>\nusing comment_to_xml_conversion = comment_to_xml_conversion<T, int>;"));
    verifyFormat(new StringRef(/*KEEP_STR*/"template <typename T>\nvoid f(int Paaaaaaaaaaaaaaaaaaaaaaaaaaaaaaram1,\n       int Paaaaaaaaaaaaaaaaaaaaaaaaaaaaaaram2);"));
    verifyFormat(new StringRef(/*KEEP_STR*/"template <typename T>\nvoid looooooooooooooooooooongFunction(int Paaaaaaaaaaaaaaaaaaaaram1,\n                                      int Paaaaaaaaaaaaaaaaaaaaram2);"));
    verifyFormat(new StringRef(/*KEEP_STR*/"template <typename T>\naaaaaaaaaaaaaaaaaaa(aaaaaaaaaaaaaaaaaa,\n                    aaaaaaaaaaaaaaaaaaaaaaaaaa<T>::aaaaaaaaaa,\n                    aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa);"));
    verifyFormat(new StringRef(/*KEEP_STR*/"template <typename T>\nvoid aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa(\n    int aaaaaaaaaaaaaaaaaaaaaa);"));
    verifyFormat(new StringRef(/*KEEP_STR*/"template <typename T1, typename T2 = char, typename T3 = char,\n          typename T4 = char>\nvoid f();"));
    verifyFormat(new StringRef(/*KEEP_STR*/"template <typename aaaaaaaaaaa, typename bbbbbbbbbbbbb,\n          template <typename> class cccccccccccccccccccccc,\n          typename ddddddddddddd>\nclass C {};"));
    verifyFormat(new StringRef(/*KEEP_STR*/"aaaaaaaaaaaaaaaaaaaaaaaa<aaaaaaaaaaaaaaaaa, aaaaaaaaaaaaaaaaa>(\n    aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa);"));
    
    verifyFormat(new StringRef(/*KEEP_STR*/"void f() {\n  a<aaaaaaaaaaaaaaaaaaaaa, aaaaaaaaaaaaaaaaaaa>(\n      a(aaaaaaaaaaaaaaaaaa, aaaaaaaaaaaaaaaa));\n}"));
    
    verifyFormat(new StringRef(/*KEEP_STR*/"template <typename T> class C {};"));
    verifyFormat(new StringRef(/*KEEP_STR*/"template <typename T> void f();"));
    verifyFormat(new StringRef(/*KEEP_STR*/"template <typename T> void f() {}"));
    verifyFormat(new StringRef(/*KEEP_STR*/"aaaaaaaaaaaaa<aaaaaaaaaa, aaaaaaaaaaa,\n              aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa,\n              aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa> *aaaa =\n    new aaaaaaaaaaaaa<aaaaaaaaaa, aaaaaaaaaaa,\n                      aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa,\n                      aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa>(\n        bbbbbbbbbbbbbbbbbbbbbbbb);"), 
        $c$.track(getLLVMStyleWithColumns(72))); $c$.clean();
    EXPECT_EQ("static_cast<A< //\n    B> *>(\n\n    );",format(new StringRef(/*KEEP_STR*/"static_cast<A<//\n    B>*>(\n\n    );")));
    verifyFormat(new StringRef(/*KEEP_STR*/"int aaaaaaaaaaaaaaaaaaaaaaaaaaaaa(\n    const typename aaaaaaaaaaaaaaaa aaaaaaaaaaaaaaaaaaa);"));
    
    AlwaysBreak = getLLVMStyle();
    AlwaysBreak.AlwaysBreakTemplateDeclarations = true;
    verifyFormat(new StringRef(/*KEEP_STR*/"template <typename T>\nclass C {};"), AlwaysBreak);
    verifyFormat(new StringRef(/*KEEP_STR*/"template <typename T>\nvoid f();"), AlwaysBreak);
    verifyFormat(new StringRef(/*KEEP_STR*/"template <typename T>\nvoid f() {}"), AlwaysBreak);
    verifyFormat(new StringRef(/*KEEP_STR*/"void aaaaaaaaaaaaaaaaaaa<aaaaaaaaaaaaaaaaaaaaaaaaaaaaa,\n                         bbbbbbbbbbbbbbbbbbbbbbbbbbbb>(\n    ccccccccccccccccccccccccccccccccccccccccccccccc);"));
    verifyFormat(new StringRef(/*KEEP_STR*/"template <template <typename> class Fooooooo,\n          template <typename> class Baaaaaaar>\nstruct C {};"), 
        AlwaysBreak);
    verifyFormat(new StringRef(/*KEEP_STR*/"template <typename T> // T can be A, B or C.\nstruct C {};"), 
        AlwaysBreak);
    verifyFormat(new StringRef(/*KEEP_STR*/"template <enum E> class A {\npublic:\n  E *f();\n};"));
  } finally {
    if (AlwaysBreak != null) { AlwaysBreak.$destroy(); }
    $c$.$destroy();
  }
}

;
@Test
//<editor-fold defaultstate="collapsed" desc="clang::format::(anonymous namespace)::FormatTest_WrapsAtNestedNameSpecifiers_Test::TestBody">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp", line = 5399,
 FQN="clang::format::(anonymous namespace)::FormatTest_WrapsAtNestedNameSpecifiers_Test::TestBody", NM="_ZN5clang6format12_GLOBAL__N_143FormatTest_WrapsAtNestedNameSpecifiers_Test8TestBodyEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp -nm=_ZN5clang6format12_GLOBAL__N_143FormatTest_WrapsAtNestedNameSpecifiers_Test8TestBodyEv")
//</editor-fold>
public void test_WrapsAtNestedNameSpecifiers() {
  if (markAsSkippedIfNeed(TestState.Successful)) { return; }
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    verifyFormat(new StringRef(/*KEEP_STR*/"aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa::\n    aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa();"));
    verifyFormat(new StringRef(/*KEEP_STR*/"aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa::\n    aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa(\n        aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa());"));
    
    // FIXME: Should we have the extra indent after the second break?
    verifyFormat(new StringRef(/*KEEP_STR*/"aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa::\n    aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa::\n        aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa();"));
    
    verifyFormat(new StringRef(/*KEEP_STR*/"aaaaaaaaaaaaaaa(bbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbb::\n                    cccccccccccccccccccccccccccccccccccccccccccccc());"));
    
    // Breaking at nested name specifiers is generally not desirable.
    verifyFormat(new StringRef(/*KEEP_STR*/"aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa::aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa(\n    aaaaaaaaaaaaaaaaaaaaaaa);"));
    
    verifyFormat(new StringRef(/*KEEP_STR*/"aaaaaaaaaaaaaaaaaa(aaaaaaaa, aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa::\n                                 aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa,\n                   aaaaaaaaaaaaaaaaaaaaa);"), 
        $c$.track(getLLVMStyleWithColumns(74))); $c$.clean();
    
    verifyFormat(new StringRef(/*KEEP_STR*/"aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa::\n    aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa\n        .aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa();"));
  } finally {
    $c$.$destroy();
  }
}

;
@Test
//<editor-fold defaultstate="collapsed" desc="clang::format::(anonymous namespace)::FormatTest_UnderstandsTemplateParameters_Test::TestBody">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp", line = 5434,
 FQN="clang::format::(anonymous namespace)::FormatTest_UnderstandsTemplateParameters_Test::TestBody", NM="_ZN5clang6format12_GLOBAL__N_145FormatTest_UnderstandsTemplateParameters_Test8TestBodyEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp -nm=_ZN5clang6format12_GLOBAL__N_145FormatTest_UnderstandsTemplateParameters_Test8TestBodyEv")
//</editor-fold>
public void test_UnderstandsTemplateParameters() {
  if (markAsSkippedIfNeed(TestState.Successful)) { return; }
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    verifyFormat(new StringRef(/*KEEP_STR*/"A<int> a;"));
    verifyFormat(new StringRef(/*KEEP_STR*/"A<A<A<int>>> a;"));
    verifyFormat(new StringRef(/*KEEP_STR*/"A<A<A<int, 2>, 3>, 4> a;"));
    verifyFormat(new StringRef(/*KEEP_STR*/"bool x = a < 1 || 2 > a;"));
    verifyFormat(new StringRef(/*KEEP_STR*/"bool x = 5 < f<int>();"));
    verifyFormat(new StringRef(/*KEEP_STR*/"bool x = f<int>() > 5;"));
    verifyFormat(new StringRef(/*KEEP_STR*/"bool x = 5 < a<int>::x;"));
    verifyFormat(new StringRef(/*KEEP_STR*/"bool x = a < 4 ? a > 2 : false;"));
    verifyFormat(new StringRef(/*KEEP_STR*/"bool x = f() ? a < 2 : a > 2;"));
    
    verifyGoogleFormat(new StringRef(/*KEEP_STR*/"A<A<int>> a;"));
    verifyGoogleFormat(new StringRef(/*KEEP_STR*/"A<A<A<int>>> a;"));
    verifyGoogleFormat(new StringRef(/*KEEP_STR*/"A<A<A<A<int>>>> a;"));
    verifyGoogleFormat(new StringRef(/*KEEP_STR*/"A<A<int> > a;"));
    verifyGoogleFormat(new StringRef(/*KEEP_STR*/"A<A<A<int> > > a;"));
    verifyGoogleFormat(new StringRef(/*KEEP_STR*/"A<A<A<A<int> > > > a;"));
    verifyGoogleFormat(new StringRef(/*KEEP_STR*/"A<::A<int>> a;"));
    verifyGoogleFormat(new StringRef(/*KEEP_STR*/"A<::A> a;"));
    verifyGoogleFormat(new StringRef(/*KEEP_STR*/"A< ::A> a;"));
    verifyGoogleFormat(new StringRef(/*KEEP_STR*/"A< ::A<int> > a;"));
    EXPECT_EQ("A<A<A<A>>> a;",$c$.clean(format(new StringRef(/*KEEP_STR*/"A<A<A<A> >> a;"), $c$.track(getGoogleStyle()))));
    EXPECT_EQ("A<A<A<A>>> a;",$c$.clean(format(new StringRef(/*KEEP_STR*/"A<A<A<A>> > a;"), $c$.track(getGoogleStyle()))));
    EXPECT_EQ("A<::A<int>> a;",$c$.clean(format(new StringRef(/*KEEP_STR*/"A< ::A<int>> a;"), $c$.track(getGoogleStyle()))));
    EXPECT_EQ("A<::A<int>> a;",$c$.clean(format(new StringRef(/*KEEP_STR*/"A<::A<int> > a;"), $c$.track(getGoogleStyle()))));
    EXPECT_EQ("auto x = [] { A<A<A<A>>> a; };",$c$.clean(format(new StringRef(/*KEEP_STR*/"auto x=[]{A<A<A<A> >> a;};"), $c$.track(getGoogleStyle()))));
    
    verifyFormat(new StringRef(/*KEEP_STR*/"A<A>> a;"), $c$.track(getChromiumStyle(FormatStyle.LanguageKind.LK_Cpp))); $c$.clean();
    
    verifyFormat(new StringRef(/*KEEP_STR*/"test >> a >> b;"));
    verifyFormat(new StringRef(/*KEEP_STR*/"test << a >> b;"));
    
    verifyFormat(new StringRef(/*KEEP_STR*/"f<int>();"));
    verifyFormat(new StringRef(/*KEEP_STR*/"template <typename T> void f() {}"));
    verifyFormat(new StringRef(/*KEEP_STR*/"struct A<std::enable_if<sizeof(T2) < sizeof(int32)>::type>;"));
    verifyFormat(new StringRef(/*KEEP_STR*/"struct A<std::enable_if<sizeof(T2) ? sizeof(int32) : sizeof(char)>::type>;"));
    verifyFormat(new StringRef(/*KEEP_STR*/"template <class T> struct S<std::is_arithmetic<T>{}> {};"));
    verifyFormat(new StringRef(/*KEEP_STR*/"f(a.operator()<A>());"));
    verifyFormat(new StringRef(/*KEEP_STR*/"f(aaaaaaaaaaaaaaaaaaaaaaaaaaaaaa\n      .template operator()<A>());"), 
        $c$.track(getLLVMStyleWithColumns(35))); $c$.clean();
    
    // Not template parameters.
    verifyFormat(new StringRef(/*KEEP_STR*/"return a < b && c > d;"));
    verifyFormat(new StringRef(/*KEEP_STR*/"void f() {\n  while (a < b && c > d) {\n  }\n}"));
    verifyFormat(new StringRef(/*KEEP_STR*/"template <typename... Types>\ntypename enable_if<0 < sizeof...(Types)>::type Foo() {}"));
    
    verifyFormat(new StringRef(/*KEEP_STR*/"aaaaaaaaaaaaaaaaaaaaaaaaaaaa(\n    aaaaaaaaaaaaaaaaaaaaaaaaaaaaa >> aaaaa);"), 
        $c$.track(getLLVMStyleWithColumns(60))); $c$.clean();
    verifyFormat(new StringRef(/*KEEP_STR*/"static_assert(is_convertible<A &&, B>::value, \"AAA\");"));
    verifyFormat(new StringRef(/*KEEP_STR*/"Constructor(A... a) : a_(X<A>{std::forward<A>(a)}...) {}"));
    verifyFormat(new StringRef(/*KEEP_STR*/"< < < < < < < < < < < < < < < < < < < < < < < < < < < < < <"));
  } finally {
    $c$.$destroy();
  }
}

;
@Test
//<editor-fold defaultstate="collapsed" desc="clang::format::(anonymous namespace)::FormatTest_UnderstandsBinaryOperators_Test::TestBody">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp", line = 5495,
 FQN="clang::format::(anonymous namespace)::FormatTest_UnderstandsBinaryOperators_Test::TestBody", NM="_ZN5clang6format12_GLOBAL__N_142FormatTest_UnderstandsBinaryOperators_Test8TestBodyEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp -nm=_ZN5clang6format12_GLOBAL__N_142FormatTest_UnderstandsBinaryOperators_Test8TestBodyEv")
//</editor-fold>
public void test_UnderstandsBinaryOperators() {
  if (markAsSkippedIfNeed(TestState.Successful)) { return; }
  verifyFormat(new StringRef(/*KEEP_STR*/"COMPARE(a, ==, b);"));
  verifyFormat(new StringRef(/*KEEP_STR*/"auto s = sizeof...(Ts) - 1;"));
}

;
@Test
//<editor-fold defaultstate="collapsed" desc="clang::format::(anonymous namespace)::FormatTest_UnderstandsPointersToMembers_Test::TestBody">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp", line = 5500,
 FQN="clang::format::(anonymous namespace)::FormatTest_UnderstandsPointersToMembers_Test::TestBody", NM="_ZN5clang6format12_GLOBAL__N_144FormatTest_UnderstandsPointersToMembers_Test8TestBodyEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp -nm=_ZN5clang6format12_GLOBAL__N_144FormatTest_UnderstandsPointersToMembers_Test8TestBodyEv")
//</editor-fold>
public void test_UnderstandsPointersToMembers() {
  if (markAsSkippedIfNeed(TestState.Successful)) { return; }
  FormatStyle Style = null;
  try {
    verifyFormat(new StringRef(/*KEEP_STR*/"int A::*x;"));
    verifyFormat(new StringRef(/*KEEP_STR*/"int (S::*func)(void *);"));
    verifyFormat(new StringRef(/*KEEP_STR*/"void f() { int (S::*func)(void *); }"));
    verifyFormat(new StringRef(/*KEEP_STR*/"typedef bool *(Class::*Member)() const;"));
    verifyFormat(new StringRef(/*KEEP_STR*/"void f() {\n  (a->*f)();\n  a->*x;\n  (a.*f)();\n  ((*a).*f)();\n  a.*x;\n}"));
    verifyFormat(new StringRef(/*KEEP_STR*/"void f() {\n  (a->*aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa)(\n      aaaa, bbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbb);\n}"));
    verifyFormat(new StringRef(/*KEEP_STR*/"(aaaaaaaaaa->*bbbbbbb)(\n    aaaaaaaaaaaaaaaaaaaaaaaaaaa(aaaaaaaaaaaaaaaaaaaaaaaaaaa));"));
    Style = getLLVMStyle();
    Style.PointerAlignment = FormatStyle.PointerAlignmentStyle.PAS_Left;
    verifyFormat(new StringRef(/*KEEP_STR*/"typedef bool* (Class::*Member)() const;"), Style);
  } finally {
    if (Style != null) { Style.$destroy(); }
  }
}

;
@Test
//<editor-fold defaultstate="collapsed" desc="clang::format::(anonymous namespace)::FormatTest_UnderstandsUnaryOperators_Test::TestBody">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp", line = 5524,
 FQN="clang::format::(anonymous namespace)::FormatTest_UnderstandsUnaryOperators_Test::TestBody", NM="_ZN5clang6format12_GLOBAL__N_141FormatTest_UnderstandsUnaryOperators_Test8TestBodyEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp -nm=_ZN5clang6format12_GLOBAL__N_141FormatTest_UnderstandsUnaryOperators_Test8TestBodyEv")
//</editor-fold>
public void test_UnderstandsUnaryOperators() {
  if (markAsSkippedIfNeed(TestState.Successful)) { return; }
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    verifyFormat(new StringRef(/*KEEP_STR*/"int a = -2;"));
    verifyFormat(new StringRef(/*KEEP_STR*/"f(-1, -2, -3);"));
    verifyFormat(new StringRef(/*KEEP_STR*/"a[-1] = 5;"));
    verifyFormat(new StringRef(/*KEEP_STR*/"int a = 5 + -2;"));
    verifyFormat(new StringRef(/*KEEP_STR*/"if (i == -1) {\n}"));
    verifyFormat(new StringRef(/*KEEP_STR*/"if (i != -1) {\n}"));
    verifyFormat(new StringRef(/*KEEP_STR*/"if (i > -1) {\n}"));
    verifyFormat(new StringRef(/*KEEP_STR*/"if (i < -1) {\n}"));
    verifyFormat(new StringRef(/*KEEP_STR*/"++(a->f());"));
    verifyFormat(new StringRef(/*KEEP_STR*/"--(a->f());"));
    verifyFormat(new StringRef(/*KEEP_STR*/"(a->f())++;"));
    verifyFormat(new StringRef(/*KEEP_STR*/"a[42]++;"));
    verifyFormat(new StringRef(/*KEEP_STR*/"if (!(a->f())) {\n}"));
    
    verifyFormat(new StringRef(/*KEEP_STR*/"a-- > b;"));
    verifyFormat(new StringRef(/*KEEP_STR*/"b ? -a : c;"));
    verifyFormat(new StringRef(/*KEEP_STR*/"n * sizeof char16;"));
    verifyFormat(new StringRef(/*KEEP_STR*/"n * alignof char16;"), $c$.track(getGoogleStyle())); $c$.clean();
    verifyFormat(new StringRef(/*KEEP_STR*/"sizeof(char);"));
    verifyFormat(new StringRef(/*KEEP_STR*/"alignof(char);"), $c$.track(getGoogleStyle())); $c$.clean();
    
    verifyFormat(new StringRef(/*KEEP_STR*/"return -1;"));
    verifyFormat(new StringRef(/*KEEP_STR*/"switch (a) {\ncase -1:\n  break;\n}"));
    verifyFormat(new StringRef(/*KEEP_STR*/"#define X -1"));
    verifyFormat(new StringRef(/*KEEP_STR*/"#define X -kConstant"));
    
    verifyFormat(new StringRef(/*KEEP_STR*/"const NSPoint kBrowserFrameViewPatternOffset = {-5, +3};"));
    verifyFormat(new StringRef(/*KEEP_STR*/"const NSPoint kBrowserFrameViewPatternOffset = {+5, -3};"));
    
    verifyFormat(new StringRef(/*KEEP_STR*/"int a = /* confusing comment */ -1;"));
    // FIXME: The space after 'i' is wrong, but hopefully, this is a rare case.
    verifyFormat(new StringRef(/*KEEP_STR*/"int a = i /* confusing comment */++;"));
  } finally {
    $c$.$destroy();
  }
}

;
@Test
//<editor-fold defaultstate="collapsed" desc="clang::format::(anonymous namespace)::FormatTest_DoesNotIndentRelativeToUnaryOperators_Test::TestBody">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp", line = 5562,
 FQN="clang::format::(anonymous namespace)::FormatTest_DoesNotIndentRelativeToUnaryOperators_Test::TestBody", NM="_ZN5clang6format12_GLOBAL__N_153FormatTest_DoesNotIndentRelativeToUnaryOperators_Test8TestBodyEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp -nm=_ZN5clang6format12_GLOBAL__N_153FormatTest_DoesNotIndentRelativeToUnaryOperators_Test8TestBodyEv")
//</editor-fold>
public void test_DoesNotIndentRelativeToUnaryOperators() {
  if (markAsSkippedIfNeed(TestState.Successful)) { return; }
  verifyFormat(new StringRef(/*KEEP_STR*/"if (!aaaaaaaaaa( // break\n        aaaaa)) {\n}"));
  verifyFormat(new StringRef(/*KEEP_STR*/"aaaaaaaaaa(!aaaaaaaaaa( // break\n    aaaaa));"));
  verifyFormat(new StringRef(/*KEEP_STR*/"*aaa = aaaaaaa( // break\n    bbbbbb);"));
}

;
@Test
//<editor-fold defaultstate="collapsed" desc="clang::format::(anonymous namespace)::FormatTest_UnderstandsOverloadedOperators_Test::TestBody">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp", line = 5572,
 FQN="clang::format::(anonymous namespace)::FormatTest_UnderstandsOverloadedOperators_Test::TestBody", NM="_ZN5clang6format12_GLOBAL__N_146FormatTest_UnderstandsOverloadedOperators_Test8TestBodyEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp -nm=_ZN5clang6format12_GLOBAL__N_146FormatTest_UnderstandsOverloadedOperators_Test8TestBodyEv")
//</editor-fold>
public void test_UnderstandsOverloadedOperators() {
  if (markAsSkippedIfNeed(TestState.Successful)) { return; }
  verifyFormat(new StringRef(/*KEEP_STR*/"bool operator<();"));
  verifyFormat(new StringRef(/*KEEP_STR*/"bool operator>();"));
  verifyFormat(new StringRef(/*KEEP_STR*/"bool operator=();"));
  verifyFormat(new StringRef(/*KEEP_STR*/"bool operator==();"));
  verifyFormat(new StringRef(/*KEEP_STR*/"bool operator!=();"));
  verifyFormat(new StringRef(/*KEEP_STR*/"int operator+();"));
  verifyFormat(new StringRef(/*KEEP_STR*/"int operator++();"));
  verifyFormat(new StringRef(/*KEEP_STR*/"bool operator,();"));
  verifyFormat(new StringRef(/*KEEP_STR*/"bool operator();"));
  verifyFormat(new StringRef(/*KEEP_STR*/"bool operator()();"));
  verifyFormat(new StringRef(/*KEEP_STR*/"bool operator[]();"));
  verifyFormat(new StringRef(/*KEEP_STR*/"operator bool();"));
  verifyFormat(new StringRef(/*KEEP_STR*/"operator int();"));
  verifyFormat(new StringRef(/*KEEP_STR*/"operator void *();"));
  verifyFormat(new StringRef(/*KEEP_STR*/"operator SomeType<int>();"));
  verifyFormat(new StringRef(/*KEEP_STR*/"operator SomeType<int, int>();"));
  verifyFormat(new StringRef(/*KEEP_STR*/"operator SomeType<SomeType<int>>();"));
  verifyFormat(new StringRef(/*KEEP_STR*/"void *operator new(std::size_t size);"));
  verifyFormat(new StringRef(/*KEEP_STR*/"void *operator new[](std::size_t size);"));
  verifyFormat(new StringRef(/*KEEP_STR*/"void operator delete(void *ptr);"));
  verifyFormat(new StringRef(/*KEEP_STR*/"void operator delete[](void *ptr);"));
  verifyFormat(new StringRef(/*KEEP_STR*/"template <typename AAAAAAA, typename BBBBBBB>\nAAAAAAA operator/(const AAAAAAA &a, BBBBBBB &b);"));
  verifyFormat(new StringRef(/*KEEP_STR*/"aaaaaaaaaaaaaaaaaaaaaa operator,(\n    aaaaaaaaaaaaaaaaaaaaa &aaaaaaaaaaaaaaaaaaaaaaaaaa) const;"));
  
  verifyFormat(new StringRef(/*KEEP_STR*/"ostream &operator<<(ostream &OutputStream,\n                    SomeReallyLongType WithSomeReallyLongValue);"));
  verifyFormat(new StringRef(/*KEEP_STR*/"bool operator<(const aaaaaaaaaaaaaaaaaaaaa &left,\n               const aaaaaaaaaaaaaaaaaaaaa &right) {\n  return left.group < right.group;\n}"));
  verifyFormat(new StringRef(/*KEEP_STR*/"SomeType &operator=(const SomeType &S);"));
  verifyFormat(new StringRef(/*KEEP_STR*/"f.template operator()<int>();"));
  
  verifyGoogleFormat(new StringRef(/*KEEP_STR*/"operator void*();"));
  verifyGoogleFormat(new StringRef(/*KEEP_STR*/"operator SomeType<SomeType<int>>();"));
  verifyGoogleFormat(new StringRef(/*KEEP_STR*/"operator ::A();"));
  
  verifyFormat(new StringRef(/*KEEP_STR*/"using A::operator+;"));
  verifyFormat(new StringRef(/*KEEP_STR*/"inline A operator^(const A &lhs, const A &rhs) {}\nint i;"));
}

;
@Test
//<editor-fold defaultstate="collapsed" desc="clang::format::(anonymous namespace)::FormatTest_UnderstandsFunctionRefQualification_Test::TestBody">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp", line = 5618,
 FQN="clang::format::(anonymous namespace)::FormatTest_UnderstandsFunctionRefQualification_Test::TestBody", NM="_ZN5clang6format12_GLOBAL__N_151FormatTest_UnderstandsFunctionRefQualification_Test8TestBodyEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp -nm=_ZN5clang6format12_GLOBAL__N_151FormatTest_UnderstandsFunctionRefQualification_Test8TestBodyEv")
//</editor-fold>
public void test_UnderstandsFunctionRefQualification() {
  if (markAsSkippedIfNeed(TestState.Successful)) { return; }
  FormatStyle AlignLeft = null;
  FormatStyle Spaces = null;
  try {
    verifyFormat(new StringRef(/*KEEP_STR*/"Deleted &operator=(const Deleted &) & = default;"));
    verifyFormat(new StringRef(/*KEEP_STR*/"Deleted &operator=(const Deleted &) && = delete;"));
    verifyFormat(new StringRef(/*KEEP_STR*/"SomeType MemberFunction(const Deleted &) & = delete;"));
    verifyFormat(new StringRef(/*KEEP_STR*/"SomeType MemberFunction(const Deleted &) && = delete;"));
    verifyFormat(new StringRef(/*KEEP_STR*/"Deleted &operator=(const Deleted &) &;"));
    verifyFormat(new StringRef(/*KEEP_STR*/"Deleted &operator=(const Deleted &) &&;"));
    verifyFormat(new StringRef(/*KEEP_STR*/"SomeType MemberFunction(const Deleted &) &;"));
    verifyFormat(new StringRef(/*KEEP_STR*/"SomeType MemberFunction(const Deleted &) &&;"));
    verifyFormat(new StringRef(/*KEEP_STR*/"SomeType MemberFunction(const Deleted &) && {}"));
    verifyFormat(new StringRef(/*KEEP_STR*/"SomeType MemberFunction(const Deleted &) && final {}"));
    verifyFormat(new StringRef(/*KEEP_STR*/"SomeType MemberFunction(const Deleted &) && override {}"));
    verifyFormat(new StringRef(/*KEEP_STR*/"SomeType MemberFunction(const Deleted &) const &;"));
    
    AlignLeft = getLLVMStyle();
    AlignLeft.PointerAlignment = FormatStyle.PointerAlignmentStyle.PAS_Left;
    verifyFormat(new StringRef(/*KEEP_STR*/"void A::b() && {}"), AlignLeft);
    verifyFormat(new StringRef(/*KEEP_STR*/"Deleted& operator=(const Deleted&) & = default;"), AlignLeft);
    verifyFormat(new StringRef(/*KEEP_STR*/"SomeType MemberFunction(const Deleted&) & = delete;"), 
        AlignLeft);
    verifyFormat(new StringRef(/*KEEP_STR*/"Deleted& operator=(const Deleted&) &;"), AlignLeft);
    verifyFormat(new StringRef(/*KEEP_STR*/"SomeType MemberFunction(const Deleted&) &;"), AlignLeft);
    verifyFormat(new StringRef(/*KEEP_STR*/"auto Function(T t) & -> void {}"), AlignLeft);
    verifyFormat(new StringRef(/*KEEP_STR*/"auto Function(T... t) & -> void {}"), AlignLeft);
    verifyFormat(new StringRef(/*KEEP_STR*/"auto Function(T) & -> void {}"), AlignLeft);
    verifyFormat(new StringRef(/*KEEP_STR*/"auto Function(T) & -> void;"), AlignLeft);
    verifyFormat(new StringRef(/*KEEP_STR*/"SomeType MemberFunction(const Deleted&) const &;"), AlignLeft);
    
    Spaces = getLLVMStyle();
    Spaces.SpacesInCStyleCastParentheses = true;
    verifyFormat(new StringRef(/*KEEP_STR*/"Deleted &operator=(const Deleted &) & = default;"), Spaces);
    verifyFormat(new StringRef(/*KEEP_STR*/"SomeType MemberFunction(const Deleted &) & = delete;"), Spaces);
    verifyFormat(new StringRef(/*KEEP_STR*/"Deleted &operator=(const Deleted &) &;"), Spaces);
    verifyFormat(new StringRef(/*KEEP_STR*/"SomeType MemberFunction(const Deleted &) &;"), Spaces);
    
    Spaces.SpacesInCStyleCastParentheses = false;
    Spaces.SpacesInParentheses = true;
    verifyFormat(new StringRef(/*KEEP_STR*/"Deleted &operator=( const Deleted & ) & = default;"), Spaces);
    verifyFormat(new StringRef(/*KEEP_STR*/"SomeType MemberFunction( const Deleted & ) & = delete;"), Spaces);
    verifyFormat(new StringRef(/*KEEP_STR*/"Deleted &operator=( const Deleted & ) &;"), Spaces);
    verifyFormat(new StringRef(/*KEEP_STR*/"SomeType MemberFunction( const Deleted & ) &;"), Spaces);
  } finally {
    if (Spaces != null) { Spaces.$destroy(); }
    if (AlignLeft != null) { AlignLeft.$destroy(); }
  }
}

;
@Test
//<editor-fold defaultstate="collapsed" desc="clang::format::(anonymous namespace)::FormatTest_UnderstandsNewAndDelete_Test::TestBody">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp", line = 5661,
 FQN="clang::format::(anonymous namespace)::FormatTest_UnderstandsNewAndDelete_Test::TestBody", NM="_ZN5clang6format12_GLOBAL__N_139FormatTest_UnderstandsNewAndDelete_Test8TestBodyEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp -nm=_ZN5clang6format12_GLOBAL__N_139FormatTest_UnderstandsNewAndDelete_Test8TestBodyEv")
//</editor-fold>
public void test_UnderstandsNewAndDelete() {
  if (markAsSkippedIfNeed(TestState.Successful)) { return; }
  verifyFormat(new StringRef(/*KEEP_STR*/"void f() {\n  A *a = new A;\n  A *a = new (placement) A;\n  delete a;\n  delete (A *)a;\n}"));
  verifyFormat(new StringRef(/*KEEP_STR*/"new (aaaaaaaaaaaaaaaaaaaaaaaaaa(aaaaaaaaaaaaaaaaaaaaaaa))\n    typename aaaaaaaaaaaaaaaaaaaaaaaa();"));
  verifyFormat(new StringRef(/*KEEP_STR*/"auto aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa =\n    new (aaaaaaaaaaaaaaaaaaaaaaaaaa(aaaaaaaaaaaaaaaaaaaaaaa))\n        typename aaaaaaaaaaaaaaaaaaaaaaaa();"));
  verifyFormat(new StringRef(/*KEEP_STR*/"delete[] h->p;"));
}

;
@Test
//<editor-fold defaultstate="collapsed" desc="clang::format::(anonymous namespace)::FormatTest_UnderstandsUsesOfStarAndAmp_Test::TestBody">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp", line = 5676,
 FQN="clang::format::(anonymous namespace)::FormatTest_UnderstandsUsesOfStarAndAmp_Test::TestBody", NM="_ZN5clang6format12_GLOBAL__N_143FormatTest_UnderstandsUsesOfStarAndAmp_Test8TestBodyEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp -nm=_ZN5clang6format12_GLOBAL__N_143FormatTest_UnderstandsUsesOfStarAndAmp_Test8TestBodyEv")
//</editor-fold>
public void test_UnderstandsUsesOfStarAndAmp() {
  if (markAsSkippedIfNeed(TestState.Successful)) { return; }
  FormatStyle Left = null;
  FormatStyle PointerLeft = null;
  FormatStyle PointerMiddle = null;
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    verifyFormat(new StringRef(/*KEEP_STR*/"int *f(int *a) {}"));
    verifyFormat(new StringRef(/*KEEP_STR*/"int main(int argc, char **argv) {}"));
    verifyFormat(new StringRef(/*KEEP_STR*/"Test::Test(int b) : a(b * b) {}"));
    verifyIndependentOfContext(new StringRef(/*KEEP_STR*/"f(a, *a);"));
    verifyFormat(new StringRef(/*KEEP_STR*/"void g() { f(*a); }"));
    verifyIndependentOfContext(new StringRef(/*KEEP_STR*/"int a = b * 10;"));
    verifyIndependentOfContext(new StringRef(/*KEEP_STR*/"int a = 10 * b;"));
    verifyIndependentOfContext(new StringRef(/*KEEP_STR*/"int a = b * c;"));
    verifyIndependentOfContext(new StringRef(/*KEEP_STR*/"int a += b * c;"));
    verifyIndependentOfContext(new StringRef(/*KEEP_STR*/"int a -= b * c;"));
    verifyIndependentOfContext(new StringRef(/*KEEP_STR*/"int a *= b * c;"));
    verifyIndependentOfContext(new StringRef(/*KEEP_STR*/"int a /= b * c;"));
    verifyIndependentOfContext(new StringRef(/*KEEP_STR*/"int a = *b;"));
    verifyIndependentOfContext(new StringRef(/*KEEP_STR*/"int a = *b * c;"));
    verifyIndependentOfContext(new StringRef(/*KEEP_STR*/"int a = b * *c;"));
    verifyIndependentOfContext(new StringRef(/*KEEP_STR*/"int a = b * (10);"));
    verifyIndependentOfContext(new StringRef(/*KEEP_STR*/"S << b * (10);"));
    verifyIndependentOfContext(new StringRef(/*KEEP_STR*/"return 10 * b;"));
    verifyIndependentOfContext(new StringRef(/*KEEP_STR*/"return *b * *c;"));
    verifyIndependentOfContext(new StringRef(/*KEEP_STR*/"return a & ~b;"));
    verifyIndependentOfContext(new StringRef(/*KEEP_STR*/"f(b ? *c : *d);"));
    verifyIndependentOfContext(new StringRef(/*KEEP_STR*/"int a = b ? *c : *d;"));
    verifyIndependentOfContext(new StringRef(/*KEEP_STR*/"*b = a;"));
    verifyIndependentOfContext(new StringRef(/*KEEP_STR*/"a * ~b;"));
    verifyIndependentOfContext(new StringRef(/*KEEP_STR*/"a * !b;"));
    verifyIndependentOfContext(new StringRef(/*KEEP_STR*/"a * +b;"));
    verifyIndependentOfContext(new StringRef(/*KEEP_STR*/"a * -b;"));
    verifyIndependentOfContext(new StringRef(/*KEEP_STR*/"a * ++b;"));
    verifyIndependentOfContext(new StringRef(/*KEEP_STR*/"a * --b;"));
    verifyIndependentOfContext(new StringRef(/*KEEP_STR*/"a[4] * b;"));
    verifyIndependentOfContext(new StringRef(/*KEEP_STR*/"a[a * a] = 1;"));
    verifyIndependentOfContext(new StringRef(/*KEEP_STR*/"f() * b;"));
    verifyIndependentOfContext(new StringRef(/*KEEP_STR*/"a * [self dostuff];"));
    verifyIndependentOfContext(new StringRef(/*KEEP_STR*/"int x = a * (a + b);"));
    verifyIndependentOfContext(new StringRef(/*KEEP_STR*/"(a *)(a + b);"));
    verifyIndependentOfContext(new StringRef(/*KEEP_STR*/"*(int *)(p & ~3UL) = 0;"));
    verifyIndependentOfContext(new StringRef(/*KEEP_STR*/"int *pa = (int *)&a;"));
    verifyIndependentOfContext(new StringRef(/*KEEP_STR*/"return sizeof(int **);"));
    verifyIndependentOfContext(new StringRef(/*KEEP_STR*/"return sizeof(int ******);"));
    verifyIndependentOfContext(new StringRef(/*KEEP_STR*/"return (int **&)a;"));
    verifyIndependentOfContext(new StringRef(/*KEEP_STR*/"f((*PointerToArray)[10]);"));
    verifyFormat(new StringRef(/*KEEP_STR*/"void f(Type (*parameter)[10]) {}"));
    verifyFormat(new StringRef(/*KEEP_STR*/"void f(Type (&parameter)[10]) {}"));
    verifyGoogleFormat(new StringRef(/*KEEP_STR*/"return sizeof(int**);"));
    verifyIndependentOfContext(new StringRef(/*KEEP_STR*/"Type **A = static_cast<Type **>(P);"));
    verifyGoogleFormat(new StringRef(/*KEEP_STR*/"Type** A = static_cast<Type**>(P);"));
    verifyFormat(new StringRef(/*KEEP_STR*/"auto a = [](int **&, int ***) {};"));
    verifyFormat(new StringRef(/*KEEP_STR*/"auto PointerBinding = [](const char *S) {};"));
    verifyFormat(new StringRef(/*KEEP_STR*/"typedef typeof(int(int, int)) *MyFunc;"));
    verifyFormat(new StringRef(/*KEEP_STR*/"[](const decltype(*a) &value) {}"));
    verifyFormat(new StringRef(/*KEEP_STR*/"decltype(a * b) F();"));
    verifyFormat(new StringRef(/*KEEP_STR*/"#define MACRO() [](A *a) { return 1; }"));
    verifyFormat(new StringRef(/*KEEP_STR*/"Constructor() : member([](A *a, B *b) {}) {}"));
    verifyIndependentOfContext(new StringRef(/*KEEP_STR*/"typedef void (*f)(int *a);"));
    verifyIndependentOfContext(new StringRef(/*KEEP_STR*/"int i{a * b};"));
    verifyIndependentOfContext(new StringRef(/*KEEP_STR*/"aaa && aaa->f();"));
    verifyIndependentOfContext(new StringRef(/*KEEP_STR*/"int x = ~*p;"));
    verifyFormat(new StringRef(/*KEEP_STR*/"Constructor() : a(a), area(width * height) {}"));
    verifyFormat(new StringRef(/*KEEP_STR*/"Constructor() : a(a), area(a, width * height) {}"));
    verifyGoogleFormat(new StringRef(/*KEEP_STR*/"MACRO Constructor(const int& i) : a(a), b(b) {}"));
    verifyFormat(new StringRef(/*KEEP_STR*/"void f() { f(a, c * d); }"));
    verifyFormat(new StringRef(/*KEEP_STR*/"void f() { f(new a(), c * d); }"));
    
    verifyIndependentOfContext(new StringRef(/*KEEP_STR*/"InvalidRegions[*R] = 0;"));
    
    verifyIndependentOfContext(new StringRef(/*KEEP_STR*/"A<int *> a;"));
    verifyIndependentOfContext(new StringRef(/*KEEP_STR*/"A<int **> a;"));
    verifyIndependentOfContext(new StringRef(/*KEEP_STR*/"A<int *, int *> a;"));
    verifyIndependentOfContext(new StringRef(/*KEEP_STR*/"A<int *[]> a;"));
    verifyIndependentOfContext(new StringRef(/*KEEP_STR*/"const char *const p = reinterpret_cast<const char *const>(q);"));
    verifyIndependentOfContext(new StringRef(/*KEEP_STR*/"A<int **, int **> a;"));
    verifyIndependentOfContext(new StringRef(/*KEEP_STR*/"void f(int *a = d * e, int *b = c * d);"));
    verifyFormat(new StringRef(/*KEEP_STR*/"for (char **a = b; *a; ++a) {\n}"));
    verifyFormat(new StringRef(/*KEEP_STR*/"for (; a && b;) {\n}"));
    verifyFormat(new StringRef(/*KEEP_STR*/"bool foo = true && [] { return false; }();"));
    
    verifyFormat(new StringRef(/*KEEP_STR*/"aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa(\n    aaaaaaaaaaaaaaaaaaaaaaaaaaaa, *aaaaaaaaaaaaaaaaaaaaaaaaaaaaa);"));
    
    verifyGoogleFormat(new StringRef(/*KEEP_STR*/"int const* a = &b;"));
    verifyGoogleFormat(new StringRef(/*KEEP_STR*/"**outparam = 1;"));
    verifyGoogleFormat(new StringRef(/*KEEP_STR*/"*outparam = a * b;"));
    verifyGoogleFormat(new StringRef(/*KEEP_STR*/"int main(int argc, char** argv) {}"));
    verifyGoogleFormat(new StringRef(/*KEEP_STR*/"A<int*> a;"));
    verifyGoogleFormat(new StringRef(/*KEEP_STR*/"A<int**> a;"));
    verifyGoogleFormat(new StringRef(/*KEEP_STR*/"A<int*, int*> a;"));
    verifyGoogleFormat(new StringRef(/*KEEP_STR*/"A<int**, int**> a;"));
    verifyGoogleFormat(new StringRef(/*KEEP_STR*/"f(b ? *c : *d);"));
    verifyGoogleFormat(new StringRef(/*KEEP_STR*/"int a = b ? *c : *d;"));
    verifyGoogleFormat(new StringRef(/*KEEP_STR*/"Type* t = **x;"));
    verifyGoogleFormat(new StringRef(/*KEEP_STR*/"Type* t = *++*x;"));
    verifyGoogleFormat(new StringRef(/*KEEP_STR*/"*++*x;"));
    verifyGoogleFormat(new StringRef(/*KEEP_STR*/"Type* t = const_cast<T*>(&*x);"));
    verifyGoogleFormat(new StringRef(/*KEEP_STR*/"Type* t = x++ * y;"));
    verifyGoogleFormat(new StringRef(/*KEEP_STR*/"const char* const p = reinterpret_cast<const char* const>(q);"));
    verifyGoogleFormat(new StringRef(/*KEEP_STR*/"void f(int i = 0, SomeType** temps = NULL);"));
    verifyGoogleFormat(new StringRef(/*KEEP_STR*/"void f(Bar* a = nullptr, Bar* b);"));
    verifyGoogleFormat(new StringRef(/*KEEP_STR*/"template <typename T>\nvoid f(int i = 0, SomeType** temps = NULL);"));
    
    Left = getLLVMStyle();
    Left.PointerAlignment = FormatStyle.PointerAlignmentStyle.PAS_Left;
    verifyFormat(new StringRef(/*KEEP_STR*/"x = *a(x) = *a(y);"), Left);
    verifyFormat(new StringRef(/*KEEP_STR*/"for (;; * = b) {\n}"), Left);
    verifyFormat(new StringRef(/*KEEP_STR*/"return *this += 1;"), Left);
    
    verifyIndependentOfContext(new StringRef(/*KEEP_STR*/"a = *(x + y);"));
    verifyIndependentOfContext(new StringRef(/*KEEP_STR*/"a = &(x + y);"));
    verifyIndependentOfContext(new StringRef(/*KEEP_STR*/"*(x + y).call();"));
    verifyIndependentOfContext(new StringRef(/*KEEP_STR*/"&(x + y)->call();"));
    verifyFormat(new StringRef(/*KEEP_STR*/"void f() { &(*I).first; }"));
    
    verifyIndependentOfContext(new StringRef(/*KEEP_STR*/"f(b * /* confusing comment */ ++c);"));
    verifyFormat(new StringRef(/*KEEP_STR*/"int *MyValues = {\n    *A, // Operator detection might be confused by the '{'\n    *BB // Operator detection might be confused by previous comment\n};"));
    
    verifyIndependentOfContext(new StringRef(/*KEEP_STR*/"if (int *a = &b)"));
    verifyIndependentOfContext(new StringRef(/*KEEP_STR*/"if (int &a = *b)"));
    verifyIndependentOfContext(new StringRef(/*KEEP_STR*/"if (a & b[i])"));
    verifyIndependentOfContext(new StringRef(/*KEEP_STR*/"if (a::b::c::d & b[i])"));
    verifyIndependentOfContext(new StringRef(/*KEEP_STR*/"if (*b[i])"));
    verifyIndependentOfContext(new StringRef(/*KEEP_STR*/"if (int *a = (&b))"));
    verifyIndependentOfContext(new StringRef(/*KEEP_STR*/"while (int *a = &b)"));
    verifyIndependentOfContext(new StringRef(/*KEEP_STR*/"size = sizeof *a;"));
    verifyIndependentOfContext(new StringRef(/*KEEP_STR*/"if (a && (b = c))"));
    verifyFormat(new StringRef(/*KEEP_STR*/"void f() {\n  for (const int &v : Values) {\n  }\n}"));
    verifyFormat(new StringRef(/*KEEP_STR*/"for (int i = a * a; i < 10; ++i) {\n}"));
    verifyFormat(new StringRef(/*KEEP_STR*/"for (int i = 0; i < a * a; ++i) {\n}"));
    verifyGoogleFormat(new StringRef(/*KEEP_STR*/"for (int i = 0; i * 2 < z; i *= 2) {\n}"));
    
    verifyFormat(new StringRef(/*KEEP_STR*/"#define A (!a * b)"));
    verifyFormat(new StringRef(/*KEEP_STR*/"#define MACRO     \\\n  int *i = a * b; \\\n  void f(a *b);"), 
        $c$.track(getLLVMStyleWithColumns(19))); $c$.clean();
    
    verifyIndependentOfContext(new StringRef(/*KEEP_STR*/"A = new SomeType *[Length];"));
    verifyIndependentOfContext(new StringRef(/*KEEP_STR*/"A = new SomeType *[Length]();"));
    verifyIndependentOfContext(new StringRef(/*KEEP_STR*/"T **t = new T *;"));
    verifyIndependentOfContext(new StringRef(/*KEEP_STR*/"T **t = new T *();"));
    verifyGoogleFormat(new StringRef(/*KEEP_STR*/"A = new SomeType*[Length]();"));
    verifyGoogleFormat(new StringRef(/*KEEP_STR*/"A = new SomeType*[Length];"));
    verifyGoogleFormat(new StringRef(/*KEEP_STR*/"T** t = new T*;"));
    verifyGoogleFormat(new StringRef(/*KEEP_STR*/"T** t = new T*();"));
    
    PointerLeft = getLLVMStyle();
    PointerLeft.PointerAlignment = FormatStyle.PointerAlignmentStyle.PAS_Left;
    verifyFormat(new StringRef(/*KEEP_STR*/"delete *x;"), PointerLeft);
    verifyFormat(new StringRef(/*KEEP_STR*/"STATIC_ASSERT((a & b) == 0);"));
    verifyFormat(new StringRef(/*KEEP_STR*/"STATIC_ASSERT(0 == (a & b));"));
    verifyFormat(new StringRef(/*KEEP_STR*/"template <bool a, bool b> typename t::if<x && y>::type f() {}"));
    verifyFormat(new StringRef(/*KEEP_STR*/"template <int *y> f() {}"));
    verifyFormat(new StringRef(/*KEEP_STR*/"vector<int *> v;"));
    verifyFormat(new StringRef(/*KEEP_STR*/"vector<int *const> v;"));
    verifyFormat(new StringRef(/*KEEP_STR*/"vector<int *const **const *> v;"));
    verifyFormat(new StringRef(/*KEEP_STR*/"vector<int *volatile> v;"));
    verifyFormat(new StringRef(/*KEEP_STR*/"vector<a * b> v;"));
    verifyFormat(new StringRef(/*KEEP_STR*/"foo<b && false>();"));
    verifyFormat(new StringRef(/*KEEP_STR*/"foo<b & 1>();"));
    verifyFormat(new StringRef(/*KEEP_STR*/"decltype(*::std::declval<const T &>()) void F();"));
    verifyFormat(new StringRef(/*KEEP_STR*/"template <class T, class = typename std::enable_if<\n                       std::is_integral<T>::value &&\n                       (sizeof(T) > 1 || sizeof(T) < 8)>::type>\nvoid F();"), 
        $c$.track(getLLVMStyleWithColumns(76))); $c$.clean();
    verifyFormat(new StringRef(/*KEEP_STR*/"template <class T,\n          class = typename ::std::enable_if<\n              ::std::is_array<T>{} && ::std::is_array<T>{}>::type>\nvoid F();"), 
        $c$.track(getGoogleStyleWithColumns(68))); $c$.clean();
    
    verifyIndependentOfContext(new StringRef(/*KEEP_STR*/"MACRO(int *i);"));
    verifyIndependentOfContext(new StringRef(/*KEEP_STR*/"MACRO(auto *a);"));
    verifyIndependentOfContext(new StringRef(/*KEEP_STR*/"MACRO(const A *a);"));
    verifyIndependentOfContext(new StringRef(/*KEEP_STR*/"MACRO('0' <= c && c <= '9');"));
    // FIXME: Is there a way to make this work?
    // verifyIndependentOfContext("MACRO(A *a);");
    verifyFormat(new StringRef(/*KEEP_STR*/"DatumHandle const *operator->() const { return input_; }"));
    verifyFormat(new StringRef(/*KEEP_STR*/"return options != nullptr && operator==(*options);"));
    EXPECT_EQ("#define OP(x)                                    \\\n  ostream &operator<<(ostream &s, const A &a) {  \\\n    return s << a.DebugString();                 \\\n  }",$c$.clean(format(new StringRef(/*KEEP_STR*/"#define OP(x) \\\n  ostream &operator<<(ostream &s, const A &a) { \\\n    return s << a.DebugString(); \\\n  }"), $c$.track(getLLVMStyleWithColumns(50)))));
    
    // FIXME: We cannot handle this case yet; we might be able to figure out that
    // foo<x> d > v; doesn't make sense.
    verifyFormat(new StringRef(/*KEEP_STR*/"foo<a<b && c> d> v;"));
    
    PointerMiddle = getLLVMStyle();
    PointerMiddle.PointerAlignment = FormatStyle.PointerAlignmentStyle.PAS_Middle;
    verifyFormat(new StringRef(/*KEEP_STR*/"delete *x;"), PointerMiddle);
    verifyFormat(new StringRef(/*KEEP_STR*/"int * x;"), PointerMiddle);
    verifyFormat(new StringRef(/*KEEP_STR*/"template <int * y> f() {}"), PointerMiddle);
    verifyFormat(new StringRef(/*KEEP_STR*/"int * f(int * a) {}"), PointerMiddle);
    verifyFormat(new StringRef(/*KEEP_STR*/"int main(int argc, char ** argv) {}"), PointerMiddle);
    verifyFormat(new StringRef(/*KEEP_STR*/"Test::Test(int b) : a(b * b) {}"), PointerMiddle);
    verifyFormat(new StringRef(/*KEEP_STR*/"A<int *> a;"), PointerMiddle);
    verifyFormat(new StringRef(/*KEEP_STR*/"A<int **> a;"), PointerMiddle);
    verifyFormat(new StringRef(/*KEEP_STR*/"A<int *, int *> a;"), PointerMiddle);
    verifyFormat(new StringRef(/*KEEP_STR*/"A<int * []> a;"), PointerMiddle);
    verifyFormat(new StringRef(/*KEEP_STR*/"A = new SomeType *[Length]();"), PointerMiddle);
    verifyFormat(new StringRef(/*KEEP_STR*/"A = new SomeType *[Length];"), PointerMiddle);
    verifyFormat(new StringRef(/*KEEP_STR*/"T ** t = new T *;"), PointerMiddle);
    
    // Member function reference qualifiers aren't binary operators.
    verifyFormat(new StringRef(/*KEEP_STR*/"string // break\noperator()() & {}"));
    verifyFormat(new StringRef(/*KEEP_STR*/"string // break\noperator()() && {}"));
    verifyGoogleFormat(new StringRef(/*KEEP_STR*/"template <typename T>\nauto x() & -> int {}"));
  } finally {
    if (PointerMiddle != null) { PointerMiddle.$destroy(); }
    if (PointerLeft != null) { PointerLeft.$destroy(); }
    if (Left != null) { Left.$destroy(); }
    $c$.$destroy();
  }
}

;
@Test
//<editor-fold defaultstate="collapsed" desc="clang::format::(anonymous namespace)::FormatTest_UnderstandsAttributes_Test::TestBody">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp", line = 5909,
 FQN="clang::format::(anonymous namespace)::FormatTest_UnderstandsAttributes_Test::TestBody", NM="_ZN5clang6format12_GLOBAL__N_137FormatTest_UnderstandsAttributes_Test8TestBodyEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp -nm=_ZN5clang6format12_GLOBAL__N_137FormatTest_UnderstandsAttributes_Test8TestBodyEv")
//</editor-fold>
public void test_UnderstandsAttributes() {
  if (markAsSkippedIfNeed(TestState.Successful)) { return; }
  FormatStyle AfterType = null;
  try {
    verifyFormat(new StringRef(/*KEEP_STR*/"SomeType s __attribute__((unused)) (InitValue);"));
    verifyFormat(new StringRef(/*KEEP_STR*/"aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa __attribute__((unused))\naaaaaaaaaaaaaaaaaaaaaaa(int i);"));
    AfterType = getLLVMStyle();
    AfterType.AlwaysBreakAfterReturnType = FormatStyle.ReturnTypeBreakingStyle.RTBS_AllDefinitions;
    verifyFormat(new StringRef(/*KEEP_STR*/"__attribute__((nodebug)) void\nfoo() {}\n"), 
        AfterType);
  } finally {
    if (AfterType != null) { AfterType.$destroy(); }
  }
}

;
@Test
//<editor-fold defaultstate="collapsed" desc="clang::format::(anonymous namespace)::FormatTest_UnderstandsEllipsis_Test::TestBody">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp", line = 5920,
 FQN="clang::format::(anonymous namespace)::FormatTest_UnderstandsEllipsis_Test::TestBody", NM="_ZN5clang6format12_GLOBAL__N_135FormatTest_UnderstandsEllipsis_Test8TestBodyEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp -nm=_ZN5clang6format12_GLOBAL__N_135FormatTest_UnderstandsEllipsis_Test8TestBodyEv")
//</editor-fold>
public void test_UnderstandsEllipsis() {
  if (markAsSkippedIfNeed(TestState.Successful)) { return; }
  FormatStyle PointersLeft = null;
  try {
    verifyFormat(new StringRef(/*KEEP_STR*/"int printf(const char *fmt, ...);"));
    verifyFormat(new StringRef(/*KEEP_STR*/"template <class... Ts> void Foo(Ts... ts) { Foo(ts...); }"));
    verifyFormat(new StringRef(/*KEEP_STR*/"template <class... Ts> void Foo(Ts *... ts) {}"));
    
    PointersLeft = getLLVMStyle();
    PointersLeft.PointerAlignment = FormatStyle.PointerAlignmentStyle.PAS_Left;
    verifyFormat(new StringRef(/*KEEP_STR*/"template <class... Ts> void Foo(Ts*... ts) {}"), PointersLeft);
  } finally {
    if (PointersLeft != null) { PointersLeft.$destroy(); }
  }
}

;
@Test
//<editor-fold defaultstate="collapsed" desc="clang::format::(anonymous namespace)::FormatTest_AdaptivelyFormatsPointersAndReferences_Test::TestBody">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp", line = 5930,
 FQN="clang::format::(anonymous namespace)::FormatTest_AdaptivelyFormatsPointersAndReferences_Test::TestBody", NM="_ZN5clang6format12_GLOBAL__N_154FormatTest_AdaptivelyFormatsPointersAndReferences_Test8TestBodyEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp -nm=_ZN5clang6format12_GLOBAL__N_154FormatTest_AdaptivelyFormatsPointersAndReferences_Test8TestBodyEv")
//</editor-fold>
public void test_AdaptivelyFormatsPointersAndReferences() {
  if (markAsSkippedIfNeed(TestState.Successful)) { return; }
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    EXPECT_EQ("int *a;\nint *a;\nint *a;",$c$.clean(format(new StringRef(/*KEEP_STR*/"int *a;\nint* a;\nint *a;"), $c$.track(getGoogleStyle()))));
    EXPECT_EQ("int* a;\nint* a;\nint* a;",$c$.clean(format(new StringRef(/*KEEP_STR*/"int* a;\nint* a;\nint *a;"), $c$.track(getGoogleStyle()))));
    EXPECT_EQ("int *a;\nint *a;\nint *a;",$c$.clean(format(new StringRef(/*KEEP_STR*/"int *a;\nint * a;\nint *  a;"), $c$.track(getGoogleStyle()))));
    EXPECT_EQ("auto x = [] {\n  int *a;\n  int *a;\n  int *a;\n};",$c$.clean(format(new StringRef(/*KEEP_STR*/"auto x=[]{int *a;\nint * a;\nint *  a;};"), $c$.track(getGoogleStyle()))));
  } finally {
    $c$.$destroy();
  }
}

;
@Test
//<editor-fold defaultstate="collapsed" desc="clang::format::(anonymous namespace)::FormatTest_UnderstandsRvalueReferences_Test::TestBody">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp", line = 5963,
 FQN="clang::format::(anonymous namespace)::FormatTest_UnderstandsRvalueReferences_Test::TestBody", NM="_ZN5clang6format12_GLOBAL__N_143FormatTest_UnderstandsRvalueReferences_Test8TestBodyEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp -nm=_ZN5clang6format12_GLOBAL__N_143FormatTest_UnderstandsRvalueReferences_Test8TestBodyEv")
//</editor-fold>
public void test_UnderstandsRvalueReferences() {
  if (markAsSkippedIfNeed(TestState.Successful)) { return; }
  verifyFormat(new StringRef(/*KEEP_STR*/"int f(int &&a) {}"));
  verifyFormat(new StringRef(/*KEEP_STR*/"int f(int a, char &&b) {}"));
  verifyFormat(new StringRef(/*KEEP_STR*/"void f() { int &&a = b; }"));
  verifyGoogleFormat(new StringRef(/*KEEP_STR*/"int f(int a, char&& b) {}"));
  verifyGoogleFormat(new StringRef(/*KEEP_STR*/"void f() { int&& a = b; }"));
  
  verifyIndependentOfContext(new StringRef(/*KEEP_STR*/"A<int &&> a;"));
  verifyIndependentOfContext(new StringRef(/*KEEP_STR*/"A<int &&, int &&> a;"));
  verifyGoogleFormat(new StringRef(/*KEEP_STR*/"A<int&&> a;"));
  verifyGoogleFormat(new StringRef(/*KEEP_STR*/"A<int&&, int&&> a;"));
  
  // Not rvalue references:
  verifyFormat(new StringRef(/*KEEP_STR*/"template <bool B, bool C> class A {\n  static_assert(B && C, \"Something is wrong\");\n};"));
  verifyGoogleFormat(new StringRef(/*KEEP_STR*/"#define IF(a, b, c) if (a && (b == c))"));
  verifyGoogleFormat(new StringRef(/*KEEP_STR*/"#define WHILE(a, b, c) while (a && (b == c))"));
  verifyFormat(new StringRef(/*KEEP_STR*/"#define A(a, b) (a && b)"));
}

;
@Test
//<editor-fold defaultstate="collapsed" desc="clang::format::(anonymous namespace)::FormatTest_FormatsBinaryOperatorsPrecedingEquals_Test::TestBody">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp", line = 5984,
 FQN="clang::format::(anonymous namespace)::FormatTest_FormatsBinaryOperatorsPrecedingEquals_Test::TestBody", NM="_ZN5clang6format12_GLOBAL__N_153FormatTest_FormatsBinaryOperatorsPrecedingEquals_Test8TestBodyEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp -nm=_ZN5clang6format12_GLOBAL__N_153FormatTest_FormatsBinaryOperatorsPrecedingEquals_Test8TestBodyEv")
//</editor-fold>
public void test_FormatsBinaryOperatorsPrecedingEquals() {
  if (markAsSkippedIfNeed(TestState.Successful)) { return; }
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    verifyFormat(new StringRef(/*KEEP_STR*/"void f() {\n  x[aaaaaaaaa -\n    b] = 23;\n}"), 
        $c$.track(getLLVMStyleWithColumns(15))); $c$.clean();
  } finally {
    $c$.$destroy();
  }
}

;
@Test
//<editor-fold defaultstate="collapsed" desc="clang::format::(anonymous namespace)::FormatTest_FormatsCasts_Test::TestBody">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp", line = 5992,
 FQN="clang::format::(anonymous namespace)::FormatTest_FormatsCasts_Test::TestBody", NM="_ZN5clang6format12_GLOBAL__N_128FormatTest_FormatsCasts_Test8TestBodyEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp -nm=_ZN5clang6format12_GLOBAL__N_128FormatTest_FormatsCasts_Test8TestBodyEv")
//</editor-fold>
public void test_FormatsCasts() {
  if (markAsSkippedIfNeed(TestState.Successful)) { return; }
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    verifyFormat(new StringRef(/*KEEP_STR*/"Type *A = static_cast<Type *>(P);"));
    verifyFormat(new StringRef(/*KEEP_STR*/"Type *A = (Type *)P;"));
    verifyFormat(new StringRef(/*KEEP_STR*/"Type *A = (vector<Type *, int *>)P;"));
    verifyFormat(new StringRef(/*KEEP_STR*/"int a = (int)(2.0f);"));
    verifyFormat(new StringRef(/*KEEP_STR*/"int a = (int)2.0f;"));
    verifyFormat(new StringRef(/*KEEP_STR*/"x[(int32)y];"));
    verifyFormat(new StringRef(/*KEEP_STR*/"x = (int32)y;"));
    verifyFormat(new StringRef(/*KEEP_STR*/"#define AA(X) sizeof(((X *)NULL)->a)"));
    verifyFormat(new StringRef(/*KEEP_STR*/"int a = (int)*b;"));
    verifyFormat(new StringRef(/*KEEP_STR*/"int a = (int)2.0f;"));
    verifyFormat(new StringRef(/*KEEP_STR*/"int a = (int)~0;"));
    verifyFormat(new StringRef(/*KEEP_STR*/"int a = (int)++a;"));
    verifyFormat(new StringRef(/*KEEP_STR*/"int a = (int)sizeof(int);"));
    verifyFormat(new StringRef(/*KEEP_STR*/"int a = (int)+2;"));
    verifyFormat(new StringRef(/*KEEP_STR*/"my_int a = (my_int)2.0f;"));
    verifyFormat(new StringRef(/*KEEP_STR*/"my_int a = (my_int)sizeof(int);"));
    verifyFormat(new StringRef(/*KEEP_STR*/"return (my_int)aaa;"));
    verifyFormat(new StringRef(/*KEEP_STR*/"#define x ((int)-1)"));
    verifyFormat(new StringRef(/*KEEP_STR*/"#define LENGTH(x, y) (x) - (y) + 1"));
    verifyFormat(new StringRef(/*KEEP_STR*/"#define p(q) ((int *)&q)"));
    verifyFormat(new StringRef(/*KEEP_STR*/"fn(a)(b) + 1;"));
    
    verifyFormat(new StringRef(/*KEEP_STR*/"void f() { my_int a = (my_int)*b; }"));
    verifyFormat(new StringRef(/*KEEP_STR*/"void f() { return P ? (my_int)*P : (my_int)0; }"));
    verifyFormat(new StringRef(/*KEEP_STR*/"my_int a = (my_int)~0;"));
    verifyFormat(new StringRef(/*KEEP_STR*/"my_int a = (my_int)++a;"));
    verifyFormat(new StringRef(/*KEEP_STR*/"my_int a = (my_int)-2;"));
    verifyFormat(new StringRef(/*KEEP_STR*/"my_int a = (my_int)1;"));
    verifyFormat(new StringRef(/*KEEP_STR*/"my_int a = (my_int *)1;"));
    verifyFormat(new StringRef(/*KEEP_STR*/"my_int a = (const my_int)-1;"));
    verifyFormat(new StringRef(/*KEEP_STR*/"my_int a = (const my_int *)-1;"));
    verifyFormat(new StringRef(/*KEEP_STR*/"my_int a = (my_int)(my_int)-1;"));
    verifyFormat(new StringRef(/*KEEP_STR*/"my_int a = (ns::my_int)-2;"));
    verifyFormat(new StringRef(/*KEEP_STR*/"case (my_int)ONE:"));
    verifyFormat(new StringRef(/*KEEP_STR*/"auto x = (X)this;"));
    
    // FIXME: single value wrapped with paren will be treated as cast.
    verifyFormat(new StringRef(/*KEEP_STR*/"void f(int i = (kValue)*kMask) {}"));
    
    verifyFormat(new StringRef(/*KEEP_STR*/"{ (void)F; }"));
    
    // Don't break after a cast's
    verifyFormat(new StringRef(/*KEEP_STR*/"int aaaaaaaaaaaaaaaaaaaaaaaaaaa =\n    (aaaaaaaaaaaaaaaaaaaaaaaaaa *)(aaaaaaaaaaaaaaaaaaaaaa +\n                                   bbbbbbbbbbbbbbbbbbbbbb);"));
    
    // These are not casts.
    verifyFormat(new StringRef(/*KEEP_STR*/"void f(int *) {}"));
    verifyFormat(new StringRef(/*KEEP_STR*/"f(foo)->b;"));
    verifyFormat(new StringRef(/*KEEP_STR*/"f(foo).b;"));
    verifyFormat(new StringRef(/*KEEP_STR*/"f(foo)(b);"));
    verifyFormat(new StringRef(/*KEEP_STR*/"f(foo)[b];"));
    verifyFormat(new StringRef(/*KEEP_STR*/"[](foo) { return 4; }(bar);"));
    verifyFormat(new StringRef(/*KEEP_STR*/"(*funptr)(foo)[4];"));
    verifyFormat(new StringRef(/*KEEP_STR*/"funptrs[4](foo)[4];"));
    verifyFormat(new StringRef(/*KEEP_STR*/"void f(int *);"));
    verifyFormat(new StringRef(/*KEEP_STR*/"void f(int *) = 0;"));
    verifyFormat(new StringRef(/*KEEP_STR*/"void f(SmallVector<int>) {}"));
    verifyFormat(new StringRef(/*KEEP_STR*/"void f(SmallVector<int>);"));
    verifyFormat(new StringRef(/*KEEP_STR*/"void f(SmallVector<int>) = 0;"));
    verifyFormat(new StringRef(/*KEEP_STR*/"void f(int i = (kA * kB) & kMask) {}"));
    verifyFormat(new StringRef(/*KEEP_STR*/"int a = sizeof(int) * b;"));
    verifyFormat(new StringRef(/*KEEP_STR*/"int a = alignof(int) * b;"), $c$.track(getGoogleStyle())); $c$.clean();
    verifyFormat(new StringRef(/*KEEP_STR*/"template <> void f<int>(int i) SOME_ANNOTATION;"));
    verifyFormat(new StringRef(/*KEEP_STR*/"f(\"%\" SOME_MACRO(ll) \"d\");"));
    verifyFormat(new StringRef(/*KEEP_STR*/"aaaaa &operator=(const aaaaa &) LLVM_DELETED_FUNCTION;"));
    
    // These are not casts, but at some point were confused with casts.
    verifyFormat(new StringRef(/*KEEP_STR*/"virtual void foo(int *) override;"));
    verifyFormat(new StringRef(/*KEEP_STR*/"virtual void foo(char &) const;"));
    verifyFormat(new StringRef(/*KEEP_STR*/"virtual void foo(int *a, char *) const;"));
    verifyFormat(new StringRef(/*KEEP_STR*/"int a = sizeof(int *) + b;"));
    verifyFormat(new StringRef(/*KEEP_STR*/"int a = alignof(int *) + b;"), $c$.track(getGoogleStyle())); $c$.clean();
    verifyFormat(new StringRef(/*KEEP_STR*/"bool b = f(g<int>) && c;"));
    verifyFormat(new StringRef(/*KEEP_STR*/"typedef void (*f)(int i) func;"));
    
    verifyFormat(new StringRef(/*KEEP_STR*/"aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa *foo = (aaaaaaaaaaaaaaaaa *)\n    bbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbb;"));
    // FIXME: The indentation here is not ideal.
    verifyFormat(new StringRef(/*KEEP_STR*/"aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa\n    [bbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbb] = (*cccccccccccccccc)\n        [dddddddddddddddddddddddddddddddddddddddddddddddddddddddd];"));
  } finally {
    $c$.$destroy();
  }
}

;
@Test
//<editor-fold defaultstate="collapsed" desc="clang::format::(anonymous namespace)::FormatTest_FormatsFunctionTypes_Test::TestBody">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp", line = 6078,
 FQN="clang::format::(anonymous namespace)::FormatTest_FormatsFunctionTypes_Test::TestBody", NM="_ZN5clang6format12_GLOBAL__N_136FormatTest_FormatsFunctionTypes_Test8TestBodyEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp -nm=_ZN5clang6format12_GLOBAL__N_136FormatTest_FormatsFunctionTypes_Test8TestBodyEv")
//</editor-fold>
public void test_FormatsFunctionTypes() {
  if (markAsSkippedIfNeed(TestState.Successful)) { return; }
  verifyFormat(new StringRef(/*KEEP_STR*/"A<bool()> a;"));
  verifyFormat(new StringRef(/*KEEP_STR*/"A<SomeType()> a;"));
  verifyFormat(new StringRef(/*KEEP_STR*/"A<void (*)(int, std::string)> a;"));
  verifyFormat(new StringRef(/*KEEP_STR*/"A<void *(int)>;"));
  verifyFormat(new StringRef(/*KEEP_STR*/"void *(*a)(int *, SomeType *);"));
  verifyFormat(new StringRef(/*KEEP_STR*/"int (*func)(void *);"));
  verifyFormat(new StringRef(/*KEEP_STR*/"void f() { int (*func)(void *); }"));
  verifyFormat(new StringRef(/*KEEP_STR*/"template <class CallbackClass>\nusing MyCallback = void (CallbackClass::*)(SomeObject *Data);"));
  
  verifyGoogleFormat(new StringRef(/*KEEP_STR*/"A<void*(int*, SomeType*)>;"));
  verifyGoogleFormat(new StringRef(/*KEEP_STR*/"void* (*a)(int);"));
  verifyGoogleFormat(new StringRef(/*KEEP_STR*/"template <class CallbackClass>\nusing MyCallback = void (CallbackClass::*)(SomeObject* Data);"));
  
  // Other constructs can look somewhat like function types:
  verifyFormat(new StringRef(/*KEEP_STR*/"A<sizeof(*x)> a;"));
  verifyFormat(new StringRef(/*KEEP_STR*/"#define DEREF_AND_CALL_F(x) f(*x)"));
  verifyFormat(new StringRef(/*KEEP_STR*/"some_var = function(*some_pointer_var)[0];"));
  verifyFormat(new StringRef(/*KEEP_STR*/"void f() { function(*some_pointer_var)[0] = 10; }"));
  verifyFormat(new StringRef(/*KEEP_STR*/"int x = f(&h)();"));
  verifyFormat(new StringRef(/*KEEP_STR*/"returnsFunction(&param1, &param2)(param);"));
}

;
@Test
//<editor-fold defaultstate="collapsed" desc="clang::format::(anonymous namespace)::FormatTest_FormatsPointersToArrayTypes_Test::TestBody">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp", line = 6104,
 FQN="clang::format::(anonymous namespace)::FormatTest_FormatsPointersToArrayTypes_Test::TestBody", NM="_ZN5clang6format12_GLOBAL__N_143FormatTest_FormatsPointersToArrayTypes_Test8TestBodyEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp -nm=_ZN5clang6format12_GLOBAL__N_143FormatTest_FormatsPointersToArrayTypes_Test8TestBodyEv")
//</editor-fold>
public void test_FormatsPointersToArrayTypes() {
  if (markAsSkippedIfNeed(TestState.Successful)) { return; }
  verifyFormat(new StringRef(/*KEEP_STR*/"A (*foo_)[6];"));
  verifyFormat(new StringRef(/*KEEP_STR*/"vector<int> (*foo_)[6];"));
}

;
@Test
//<editor-fold defaultstate="collapsed" desc="clang::format::(anonymous namespace)::FormatTest_BreaksLongVariableDeclarations_Test::TestBody">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp", line = 6109,
 FQN="clang::format::(anonymous namespace)::FormatTest_BreaksLongVariableDeclarations_Test::TestBody", NM="_ZN5clang6format12_GLOBAL__N_146FormatTest_BreaksLongVariableDeclarations_Test8TestBodyEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp -nm=_ZN5clang6format12_GLOBAL__N_146FormatTest_BreaksLongVariableDeclarations_Test8TestBodyEv")
//</editor-fold>
public void test_BreaksLongVariableDeclarations() {
  if (markAsSkippedIfNeed(TestState.Successful)) { return; }
  verifyFormat(new StringRef(/*KEEP_STR*/"LoooooooooooooooooooooooooooooooooooooooongType\n    LoooooooooooooooooooooooooooooooooooooooongVariable;"));
  verifyFormat(new StringRef(/*KEEP_STR*/"LoooooooooooooooooooooooooooooooooooooooongType const\n    LoooooooooooooooooooooooooooooooooooooooongVariable;"));
  verifyFormat(new StringRef(/*KEEP_STR*/"LoooooooooooooooooooooooooooooooooooooooongType\n    *LoooooooooooooooooooooooooooooooooooooooongVariable;"));
  
  // Different ways of ()-initializiation.
  verifyFormat(new StringRef(/*KEEP_STR*/"LoooooooooooooooooooooooooooooooooooooooongType\n    LoooooooooooooooooooooooooooooooooooooooongVariable(1);"));
  verifyFormat(new StringRef(/*KEEP_STR*/"LoooooooooooooooooooooooooooooooooooooooongType\n    LoooooooooooooooooooooooooooooooooooooooongVariable(a);"));
  verifyFormat(new StringRef(/*KEEP_STR*/"LoooooooooooooooooooooooooooooooooooooooongType\n    LoooooooooooooooooooooooooooooooooooooooongVariable({});"));
  verifyFormat(new StringRef(/*KEEP_STR*/"LoooooooooooooooooooooooooooooooooooooooongType\n    LoooooooooooooooooooooooooooooooooooooongVariable([A a]);"));
}

;
@Test
//<editor-fold defaultstate="collapsed" desc="clang::format::(anonymous namespace)::FormatTest_BreaksLongDeclarations_Test::TestBody">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp", line = 6128,
 FQN="clang::format::(anonymous namespace)::FormatTest_BreaksLongDeclarations_Test::TestBody", NM="_ZN5clang6format12_GLOBAL__N_138FormatTest_BreaksLongDeclarations_Test8TestBodyEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp -nm=_ZN5clang6format12_GLOBAL__N_138FormatTest_BreaksLongDeclarations_Test8TestBodyEv")
//</editor-fold>
public void test_BreaksLongDeclarations() {
  if (markAsSkippedIfNeed(TestState.Successful)) { return; }
  FormatStyle Indented = null;
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    verifyFormat(new StringRef(/*KEEP_STR*/"typedef LoooooooooooooooooooooooooooooooooooooooongType\n    AnotherNameForTheLongType;"));
    verifyFormat(new StringRef(/*KEEP_STR*/"typedef LongTemplateType<aaaaaaaaaaaaaaaaaaa()>\n    aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa;"));
    verifyFormat(new StringRef(/*KEEP_STR*/"LoooooooooooooooooooooooooooooooooooooooongReturnType\nLoooooooooooooooooooooooooooooooongFunctionDeclaration();"));
    verifyFormat(new StringRef(/*KEEP_STR*/"LoooooooooooooooooooooooooooooooooooooooongReturnType *\nLoooooooooooooooooooooooooooooooongFunctionDeclaration();"));
    verifyFormat(new StringRef(/*KEEP_STR*/"LoooooooooooooooooooooooooooooooooooooooongReturnType\nLooooooooooooooooooooooooooooooooooongFunctionDefinition() {}"));
    verifyFormat(new StringRef(/*KEEP_STR*/"LoooooooooooooooooooooooooooooooooooooooongReturnType MACRO\nLooooooooooooooooooooooooooooooooooongFunctionDefinition() {}"));
    verifyFormat(new StringRef(/*KEEP_STR*/"LoooooooooooooooooooooooooooooooooooooooongReturnType const\nLooooooooooooooooooooooooooooooooooongFunctionDefinition() {}"));
    verifyFormat(new StringRef(/*KEEP_STR*/"decltype(LoooooooooooooooooooooooooooooooooooooooongName)\nLooooooooooooooooooooooooooooooooooongFunctionDefinition() {}"));
    verifyFormat(new StringRef(/*KEEP_STR*/"LoooooooooooooooooooooooooooooooooooooooongReturnType\nLooooooooooooooooooooooooooongFunctionDeclaration(T... t);"));
    verifyFormat(new StringRef(/*KEEP_STR*/"LoooooooooooooooooooooooooooooooooooooooongReturnType\nLooooooooooooooooooooooooooongFunctionDeclaration(T /*t*/) {}"));
    Indented = getLLVMStyle();
    Indented.IndentWrappedFunctionNames = true;
    verifyFormat(new StringRef(/*KEEP_STR*/"LoooooooooooooooooooooooooooooooooooooooongReturnType\n    LoooooooooooooooooooooooooooooooongFunctionDeclaration();"), 
        Indented);
    verifyFormat(new StringRef(/*KEEP_STR*/"LoooooooooooooooooooooooooooooooooooooooongReturnType\n    LooooooooooooooooooooooooooooooooooongFunctionDefinition() {}"), 
        Indented);
    verifyFormat(new StringRef(/*KEEP_STR*/"LoooooooooooooooooooooooooooooooooooooooongReturnType const\n    LooooooooooooooooooooooooooooooooooongFunctionDefinition() {}"), 
        Indented);
    verifyFormat(new StringRef(/*KEEP_STR*/"decltype(LoooooooooooooooooooooooooooooooooooooooongName)\n    LooooooooooooooooooooooooooooooooooongFunctionDefinition() {}"), 
        Indented);
    
    // FIXME: Without the comment, this breaks after "(".
    verifyFormat(new StringRef(/*KEEP_STR*/"LoooooooooooooooooooooooooooooooooooooooongType  // break\n    (*LoooooooooooooooooooooooooooongFunctionTypeVarialbe)();"), 
        $c$.track(getGoogleStyle())); $c$.clean();
    
    verifyFormat(new StringRef(/*KEEP_STR*/"int *someFunction(int LoooooooooooooooooooongParam1,\n                  int LoooooooooooooooooooongParam2) {}"));
    verifyFormat(new StringRef(/*KEEP_STR*/"TypeSpecDecl *TypeSpecDecl::Create(ASTContext &C, DeclContext *DC,\n                                   SourceLocation L, IdentifierIn *II,\n                                   Type *T) {}"));
    verifyFormat(new StringRef(/*KEEP_STR*/"ReallyLongReturnType<TemplateParam1, TemplateParam2>\nReallyReaaallyLongFunctionName(\n    const std::string &SomeParameter,\n    const SomeType<string, SomeOtherTemplateParameter>\n        &ReallyReallyLongParameterName,\n    const SomeType<string, SomeOtherTemplateParameter>\n        &AnotherLongParameterName) {}"));
    verifyFormat(new StringRef(/*KEEP_STR*/"template <typename A>\nSomeLoooooooooooooooooooooongType<\n    typename some_namespace::SomeOtherType<A>::Type>\nFunction() {}"));
    
    verifyGoogleFormat(new StringRef(/*KEEP_STR*/"aaaaaaaaaaaaaaaa::aaaaaaaaaaaaaaaa<aaaaaaaaaaaaa, aaaaaaaaaaaa>\n    aaaaaaaaaaaaaaaaaaaaaaa;"));
    verifyGoogleFormat(new StringRef(/*KEEP_STR*/"TypeSpecDecl* TypeSpecDecl::Create(ASTContext& C, DeclContext* DC,\n                                   SourceLocation L) {}"));
    verifyGoogleFormat(new StringRef(/*KEEP_STR*/"some_namespace::LongReturnType\nlong_namespace::SomeVeryLongClass::SomeVeryLongFunction(\n    int first_long_parameter, int second_parameter) {}"));
    
    verifyGoogleFormat(new StringRef(/*KEEP_STR*/"template <typename T>\naaaaaaaa::aaaaa::aaaaaa<T, aaaaaaaaaaaaaaaaaaaaaaaaa>\naaaaaaaaaaaaaaaaaaaaaaaa<T>::aaaaaaa() {}"));
    verifyGoogleFormat(new StringRef(/*KEEP_STR*/"A<A<A>> aaaaaaaaaa(int aaaaaaaaaaaaaaaaaaaaaaaaaaa,\n                   int aaaaaaaaaaaaaaaaaaaaaaa);"));
    
    verifyFormat(new StringRef(/*KEEP_STR*/"typedef size_t (*aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa)(\n    const aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa\n        *aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa);"));
    verifyFormat(new StringRef(/*KEEP_STR*/"void aaaaaaaaaaaaaaaaaaaaaaaaaaaaa(\n    vector<aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa>\n        aaaaaaaaaaaaaaaaaaaaaaaa);"));
    verifyFormat(new StringRef(/*KEEP_STR*/"void aaaaaaaaaaaaaaaaaaaaaaaaaaaaa(\n    vector<aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa<\n        aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa>>\n        aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa);"));
  } finally {
    if (Indented != null) { Indented.$destroy(); }
    $c$.$destroy();
  }
}

;
@Test
//<editor-fold defaultstate="collapsed" desc="clang::format::(anonymous namespace)::FormatTest_FormatsArrays_Test::TestBody">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp", line = 6219,
 FQN="clang::format::(anonymous namespace)::FormatTest_FormatsArrays_Test::TestBody", NM="_ZN5clang6format12_GLOBAL__N_129FormatTest_FormatsArrays_Test8TestBodyEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp -nm=_ZN5clang6format12_GLOBAL__N_129FormatTest_FormatsArrays_Test8TestBodyEv")
//</editor-fold>
public void test_FormatsArrays() {
  if (markAsSkippedIfNeed(TestState.Successful)) { return; }
  FormatStyle NoColumnLimit = null;
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    verifyFormat(new StringRef(/*KEEP_STR*/"aaaaaaaaaaaaaaaaaaaaaaaaa[aaaaaaaaaaaaaaaaaaaaaaaaa]\n                         [bbbbbbbbbbbbbbbbbbbbbbbbb] = c;"));
    verifyFormat(new StringRef(/*KEEP_STR*/"aaaaaaaaaaaaaaaaaaaaaaaaa[aaaaaaaaaaa(aaaaaaaaaaaa)]\n                         [bbbbbbbbbbb(bbbbbbbbbbbb)] = c;"));
    verifyFormat(new StringRef(/*KEEP_STR*/"if (aaaaaaaaaaaaaaaaaaaaaaaa &&\n    aaaaaaaaaaaaaaaaaaa[aaaaaaaaaaaaa][aaaaaaaaaaaaa]) {\n}"));
    verifyFormat(new StringRef(/*KEEP_STR*/"aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa\n    [bbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbb] = ccccccccccc;"));
    verifyFormat(new StringRef(/*KEEP_STR*/"aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa\n    [a][bbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbb] = cccccccc;"));
    verifyFormat(new StringRef(/*KEEP_STR*/"aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa\n    [aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa]\n    [bbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbb] = ccccccccccc;"));
    verifyFormat(new StringRef(/*KEEP_STR*/"llvm::outs() << \"aaaaaaaaaaaa: \"\n             << (*aaaaaaaiaaaaaaa)[aaaaaaaaaaaaaaaaaaaaaaaaa]\n                                  [aaaaaaaaaaaaaaaaaaaaaaaaaaaaaa];"));
    verifyFormat(new StringRef(/*KEEP_STR*/"aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa[aaaaaaaaaaaaaaaaa][a]\n    .aaaaaaaaaaaaaaaaaaaaaa();"));
    
    verifyGoogleFormat(new StringRef(/*KEEP_STR*/"aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa<int>\n    aaaaaaaaaaaaaaaaaaaaaaaaaaaaaa[aaaaaaaaaaaa];"));
    verifyFormat(new StringRef(/*KEEP_STR*/"aaaaaaaaaaa aaaaaaaaaaaaaaa = aaaaaaaaaaaaaaaaaaaaaaaaaa->aaaaaaaaa[0]\n                                  .aaaaaaa[0]\n                                  .aaaaaaaaaaaaaaaaaaaaaa();"));
    verifyFormat(new StringRef(/*KEEP_STR*/"a[::b::c];"));
    
    verifyNoCrash(new StringRef(/*KEEP_STR*/"a[,Y?)]"), $c$.track(getLLVMStyleWithColumns(10))); $c$.clean();
    
    NoColumnLimit = getLLVMStyleWithColumns(0);
    verifyFormat(new StringRef(/*KEEP_STR*/"aaaaa[bbbbbb].cccccc()"), NoColumnLimit);
  } finally {
    if (NoColumnLimit != null) { NoColumnLimit.$destroy(); }
    $c$.$destroy();
  }
}

;
@Test
//<editor-fold defaultstate="collapsed" desc="clang::format::(anonymous namespace)::FormatTest_LineStartsWithSpecialCharacter_Test::TestBody">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp", line = 6254,
 FQN="clang::format::(anonymous namespace)::FormatTest_LineStartsWithSpecialCharacter_Test::TestBody", NM="_ZN5clang6format12_GLOBAL__N_146FormatTest_LineStartsWithSpecialCharacter_Test8TestBodyEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp -nm=_ZN5clang6format12_GLOBAL__N_146FormatTest_LineStartsWithSpecialCharacter_Test8TestBodyEv")
//</editor-fold>
public void test_LineStartsWithSpecialCharacter() {
  if (markAsSkippedIfNeed(TestState.Successful)) { return; }
  verifyFormat(new StringRef(/*KEEP_STR*/"(a)->b();"));
  verifyFormat(new StringRef(/*KEEP_STR*/"--a;"));
}

;
@Test
//<editor-fold defaultstate="collapsed" desc="clang::format::(anonymous namespace)::FormatTest_HandlesIncludeDirectives_Test::TestBody">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp", line = 6259,
 FQN="clang::format::(anonymous namespace)::FormatTest_HandlesIncludeDirectives_Test::TestBody", NM="_ZN5clang6format12_GLOBAL__N_140FormatTest_HandlesIncludeDirectives_Test8TestBodyEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp -nm=_ZN5clang6format12_GLOBAL__N_140FormatTest_HandlesIncludeDirectives_Test8TestBodyEv")
//</editor-fold>
public void test_HandlesIncludeDirectives() {
  if (markAsSkippedIfNeed(TestState.Successful)) { return; }
  FormatStyle Style = null;
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    verifyFormat(new StringRef(/*KEEP_STR*/"#include <string>\n#include <a/b/c.h>\n#include \"a/b/string\"\n#include \"string.h\"\n#include \"string.h\"\n#include <a-a>\n#include < path with space >\n#include_next <test.h>#include \"abc.h\" // this is included for ABC\n#include \"some long include\" // with a comment\n#include \"some very long include paaaaaaaaaaaaaaaaaaaaaaath\""), 
        $c$.track(getLLVMStyleWithColumns(35))); $c$.clean();
    EXPECT_EQ("#include \"a.h\"",format(new StringRef(/*KEEP_STR*/"#include  \"a.h\"")));
    EXPECT_EQ("#include <a>",format(new StringRef(/*KEEP_STR*/"#include<a>")));
    
    verifyFormat(new StringRef(/*KEEP_STR*/"#import <string>"));
    verifyFormat(new StringRef(/*KEEP_STR*/"#import <a/b/c.h>"));
    verifyFormat(new StringRef(/*KEEP_STR*/"#import \"a/b/string\""));
    verifyFormat(new StringRef(/*KEEP_STR*/"#import \"string.h\""));
    verifyFormat(new StringRef(/*KEEP_STR*/"#import \"string.h\""));
    verifyFormat(new StringRef(/*KEEP_STR*/"#if __has_include(<strstream>)\n#include <strstream>\n#endif"));
    
    verifyFormat(new StringRef(/*KEEP_STR*/"#define MY_IMPORT <a/b>"));
    
    // Protocol buffer definition or missing "#".
    verifyFormat(new StringRef(/*KEEP_STR*/"import \"aaaaaaaaaaaaaaaaa/aaaaaaaaaaaaaaa\";"), 
        $c$.track(getLLVMStyleWithColumns(30))); $c$.clean();
    
    Style = getLLVMStyle();
    Style.AlwaysBreakBeforeMultilineStrings = true;
    Style.ColumnLimit = 0;
    verifyFormat(new StringRef(/*KEEP_STR*/"#import \"abc.h\""), Style);
    
    // But 'import' might also be a regular C++ namespace.
    verifyFormat(new StringRef(/*KEEP_STR*/"import::SomeFunction(aaaaaaaaaaaaaaaaaaaaaaaaaaa,\n                     aaaaaaaaaaaaaaaaaaaaaaaaaaaaa);"));
  } finally {
    if (Style != null) { Style.$destroy(); }
    $c$.$destroy();
  }
}


//===----------------------------------------------------------------------===//
// Error recovery tests.
//===----------------------------------------------------------------------===//
;
@Test
//<editor-fold defaultstate="collapsed" desc="clang::format::(anonymous namespace)::FormatTest_IncompleteParameterLists_Test::TestBody">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp", line = 6304,
 FQN="clang::format::(anonymous namespace)::FormatTest_IncompleteParameterLists_Test::TestBody", NM="_ZN5clang6format12_GLOBAL__N_140FormatTest_IncompleteParameterLists_Test8TestBodyEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp -nm=_ZN5clang6format12_GLOBAL__N_140FormatTest_IncompleteParameterLists_Test8TestBodyEv")
//</editor-fold>
public void test_IncompleteParameterLists() {
  if (markAsSkippedIfNeed(TestState.Successful)) { return; }
  FormatStyle NoBinPacking = null;
  try {
    NoBinPacking = getLLVMStyle();
    NoBinPacking.BinPackParameters = false;
    verifyFormat(new StringRef(/*KEEP_STR*/"void aaaaaaaaaaaaaaaaaa(int level,\n                        double *min_x,\n                        double *max_x,\n                        double *min_y,\n                        double *max_y,\n                        double *min_z,\n                        double *max_z, ) {}"), 
        NoBinPacking);
  } finally {
    if (NoBinPacking != null) { NoBinPacking.$destroy(); }
  }
}

;
@Test
//<editor-fold defaultstate="collapsed" desc="clang::format::(anonymous namespace)::FormatTest_IncorrectCodeTrailingStuff_Test::TestBody">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp", line = 6317,
 FQN="clang::format::(anonymous namespace)::FormatTest_IncorrectCodeTrailingStuff_Test::TestBody", NM="_ZN5clang6format12_GLOBAL__N_142FormatTest_IncorrectCodeTrailingStuff_Test8TestBodyEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp -nm=_ZN5clang6format12_GLOBAL__N_142FormatTest_IncorrectCodeTrailingStuff_Test8TestBodyEv")
//</editor-fold>
public void test_IncorrectCodeTrailingStuff() {
  if (markAsSkippedIfNeed(TestState.Successful)) { return; }
  verifyFormat(new StringRef(/*KEEP_STR*/"void f() { return; }\n42"));
  verifyFormat(new StringRef(/*KEEP_STR*/"void f() {\n  if (0)\n    return;\n}\n42"));
  verifyFormat(new StringRef(/*KEEP_STR*/"void f() { return }\n42"));
  verifyFormat(new StringRef(/*KEEP_STR*/"void f() {\n  if (0)\n    return\n}\n42"));
}

;
@Test
//<editor-fold defaultstate="collapsed" desc="clang::format::(anonymous namespace)::FormatTest_IncorrectCodeMissingSemicolon_Test::TestBody">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp", line = 6332,
 FQN="clang::format::(anonymous namespace)::FormatTest_IncorrectCodeMissingSemicolon_Test::TestBody", NM="_ZN5clang6format12_GLOBAL__N_145FormatTest_IncorrectCodeMissingSemicolon_Test8TestBodyEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp -nm=_ZN5clang6format12_GLOBAL__N_145FormatTest_IncorrectCodeMissingSemicolon_Test8TestBodyEv")
//</editor-fold>
public void test_IncorrectCodeMissingSemicolon() {
  if (markAsSkippedIfNeed(TestState.Successful)) { return; }
    EXPECT_EQ("void f() { return }",format(new StringRef(/*KEEP_STR*/"void  f ( )  {  return  }")));
    EXPECT_EQ("void f() {\n  if (a)\n    return\n}",format(new StringRef(/*KEEP_STR*/"void  f  (  )  {  if  ( a )  return  }")));
    EXPECT_EQ("namespace N {\nvoid f()\n}",format(new StringRef(/*KEEP_STR*/"namespace  N  {  void f()  }")));
    EXPECT_EQ("namespace N {\nvoid f() {}\nvoid g()\n}",format(new StringRef(/*KEEP_STR*/"namespace N  { void f( ) { } void g( ) }")));
}

;
@Test
//<editor-fold defaultstate="collapsed" desc="clang::format::(anonymous namespace)::FormatTest_IndentationWithinColumnLimitNotPossible_Test::TestBody">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp", line = 6350,
 FQN="clang::format::(anonymous namespace)::FormatTest_IndentationWithinColumnLimitNotPossible_Test::TestBody", NM="_ZN5clang6format12_GLOBAL__N_155FormatTest_IndentationWithinColumnLimitNotPossible_Test8TestBodyEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp -nm=_ZN5clang6format12_GLOBAL__N_155FormatTest_IndentationWithinColumnLimitNotPossible_Test8TestBodyEv")
//</editor-fold>
public void test_IndentationWithinColumnLimitNotPossible() {
  if (markAsSkippedIfNeed(TestState.Successful)) { return; }
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    verifyFormat(new StringRef(/*KEEP_STR*/"int aaaaaaaa =\n    // Overlylongcomment\n    b;"), 
        $c$.track(getLLVMStyleWithColumns(20))); $c$.clean();
    verifyFormat(new StringRef(/*KEEP_STR*/"function(\n    ShortArgument,\n    LoooooooooooongArgument);\n"), 
        $c$.track(getLLVMStyleWithColumns(20))); $c$.clean();
  } finally {
    $c$.$destroy();
  }
}

;
@Test
//<editor-fold defaultstate="collapsed" desc="clang::format::(anonymous namespace)::FormatTest_IncorrectAccessSpecifier_Test::TestBody">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp", line = 6361,
 FQN="clang::format::(anonymous namespace)::FormatTest_IncorrectAccessSpecifier_Test::TestBody", NM="_ZN5clang6format12_GLOBAL__N_140FormatTest_IncorrectAccessSpecifier_Test8TestBodyEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp -nm=_ZN5clang6format12_GLOBAL__N_140FormatTest_IncorrectAccessSpecifier_Test8TestBodyEv")
//</editor-fold>
public void test_IncorrectAccessSpecifier() {
  if (markAsSkippedIfNeed(TestState.Successful)) { return; }
  verifyFormat(new StringRef(/*KEEP_STR*/"public:"));
  verifyFormat(new StringRef(/*KEEP_STR*/"class A {\npublic\n  void f() {}\n};"));
  verifyFormat(new StringRef(/*KEEP_STR*/"public\nint qwerty;"));
  verifyFormat(new StringRef(/*KEEP_STR*/"public\nB {}"));
  verifyFormat(new StringRef(/*KEEP_STR*/"public\n{}"));
  verifyFormat(new StringRef(/*KEEP_STR*/"public\nB { int x; }"));
}

;
@Test
//<editor-fold defaultstate="collapsed" desc="clang::format::(anonymous namespace)::FormatTest_IncorrectCodeUnbalancedBraces_Test::TestBody">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp", line = 6377,
 FQN="clang::format::(anonymous namespace)::FormatTest_IncorrectCodeUnbalancedBraces_Test::TestBody", NM="_ZN5clang6format12_GLOBAL__N_145FormatTest_IncorrectCodeUnbalancedBraces_Test8TestBodyEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp -nm=_ZN5clang6format12_GLOBAL__N_145FormatTest_IncorrectCodeUnbalancedBraces_Test8TestBodyEv")
//</editor-fold>
public void test_IncorrectCodeUnbalancedBraces() {
  if (markAsSkippedIfNeed(TestState.Successful)) { return; }
  verifyFormat(new StringRef(/*KEEP_STR*/$LCURLY));
  verifyFormat(new StringRef(/*KEEP_STR*/"#})"));
  verifyNoCrash(new StringRef(/*KEEP_STR*/"(/**/[:!] ?[)."));
}

;
@Test
//<editor-fold defaultstate="collapsed" desc="clang::format::(anonymous namespace)::FormatTest_IncorrectCodeDoNoWhile_Test::TestBody">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp", line = 6383,
 FQN="clang::format::(anonymous namespace)::FormatTest_IncorrectCodeDoNoWhile_Test::TestBody", NM="_ZN5clang6format12_GLOBAL__N_138FormatTest_IncorrectCodeDoNoWhile_Test8TestBodyEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp -nm=_ZN5clang6format12_GLOBAL__N_138FormatTest_IncorrectCodeDoNoWhile_Test8TestBodyEv")
//</editor-fold>
public void test_IncorrectCodeDoNoWhile() {
  if (markAsSkippedIfNeed(TestState.Successful)) { return; }
  verifyFormat(new StringRef(/*KEEP_STR*/"do {\n}"));
  verifyFormat(new StringRef(/*KEEP_STR*/"do {\n}\nf();"));
  verifyFormat(new StringRef(/*KEEP_STR*/"do {\n}\nwheeee(fun);"));
  verifyFormat(new StringRef(/*KEEP_STR*/"do {\n  f();\n}"));
}

;
@Test
//<editor-fold defaultstate="collapsed" desc="clang::format::(anonymous namespace)::FormatTest_IncorrectCodeMissingParens_Test::TestBody">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp", line = 6394,
 FQN="clang::format::(anonymous namespace)::FormatTest_IncorrectCodeMissingParens_Test::TestBody", NM="_ZN5clang6format12_GLOBAL__N_142FormatTest_IncorrectCodeMissingParens_Test8TestBodyEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp -nm=_ZN5clang6format12_GLOBAL__N_142FormatTest_IncorrectCodeMissingParens_Test8TestBodyEv")
//</editor-fold>
public void test_IncorrectCodeMissingParens() {
  if (markAsSkippedIfNeed(TestState.Successful)) { return; }
  verifyFormat(new StringRef(/*KEEP_STR*/"if {\n  foo;\n  foo();\n}"));
  verifyFormat(new StringRef(/*KEEP_STR*/"switch {\n  foo;\n  foo();\n}"));
  verifyIncompleteFormat(new StringRef(/*KEEP_STR*/"for {\n  foo;\n  foo();\n}"));
  verifyFormat(new StringRef(/*KEEP_STR*/"while {\n  foo;\n  foo();\n}"));
  verifyFormat(new StringRef(/*KEEP_STR*/"do {\n  foo;\n  foo();\n} while;"));
}

;
@Test
//<editor-fold defaultstate="collapsed" desc="clang::format::(anonymous namespace)::FormatTest_DoesNotTouchUnwrappedLinesWithErrors_Test::TestBody">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp", line = 6402,
 FQN="clang::format::(anonymous namespace)::FormatTest_DoesNotTouchUnwrappedLinesWithErrors_Test::TestBody", NM="_ZN5clang6format12_GLOBAL__N_152FormatTest_DoesNotTouchUnwrappedLinesWithErrors_Test8TestBodyEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp -nm=_ZN5clang6format12_GLOBAL__N_152FormatTest_DoesNotTouchUnwrappedLinesWithErrors_Test8TestBodyEv")
//</editor-fold>
public void test_DoesNotTouchUnwrappedLinesWithErrors() {
  if (markAsSkippedIfNeed(TestState.Successful)) { return; }
  verifyIncompleteFormat(new StringRef(/*KEEP_STR*/"namespace {\nclass Foo { Foo (\n};\n} // comment"));
}

;
@Test
//<editor-fold defaultstate="collapsed" desc="clang::format::(anonymous namespace)::FormatTest_IncorrectCodeErrorDetection_Test::TestBody">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp", line = 6409,
 FQN="clang::format::(anonymous namespace)::FormatTest_IncorrectCodeErrorDetection_Test::TestBody", NM="_ZN5clang6format12_GLOBAL__N_143FormatTest_IncorrectCodeErrorDetection_Test8TestBodyEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp -nm=_ZN5clang6format12_GLOBAL__N_143FormatTest_IncorrectCodeErrorDetection_Test8TestBodyEv")
//</editor-fold>
public void test_IncorrectCodeErrorDetection() {
  if (markAsSkippedIfNeed(TestState.Successful)) { return; }
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    EXPECT_EQ("{\n  {}\n",format(new StringRef(/*KEEP_STR*/"{\n{\n}\n")));
    EXPECT_EQ("{\n  {}\n",format(new StringRef(/*KEEP_STR*/"{\n  {\n}\n")));
    EXPECT_EQ("{\n  {}\n",format(new StringRef(/*KEEP_STR*/"{\n  {\n  }\n")));
    EXPECT_EQ("{\n  {}\n}\n}\n",format(new StringRef(/*KEEP_STR*/"{\n  {\n    }\n  }\n}\n")));
    EXPECT_EQ("{\n  {\n    breakme(\n        qwe);\n  }\n",$c$.clean(format(new StringRef(/*KEEP_STR*/"{\n    {\n breakme(qwe);\n}\n"), $c$.track(getLLVMStyleWithColumns(10)))));
  } finally {
    $c$.$destroy();
  }
}

;
@Test
//<editor-fold defaultstate="collapsed" desc="clang::format::(anonymous namespace)::FormatTest_LayoutCallsInsideBraceInitializers_Test::TestBody">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp", line = 6427,
 FQN="clang::format::(anonymous namespace)::FormatTest_LayoutCallsInsideBraceInitializers_Test::TestBody", NM="_ZN5clang6format12_GLOBAL__N_150FormatTest_LayoutCallsInsideBraceInitializers_Test8TestBodyEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp -nm=_ZN5clang6format12_GLOBAL__N_150FormatTest_LayoutCallsInsideBraceInitializers_Test8TestBodyEv")
//</editor-fold>
public void test_LayoutCallsInsideBraceInitializers() {
  if (markAsSkippedIfNeed(TestState.Successful)) { return; }
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    verifyFormat(new StringRef(/*KEEP_STR*/"int x = {\n    avariable,\n    b(alongervariable)};"), 
        $c$.track(getLLVMStyleWithColumns(25))); $c$.clean();
  } finally {
    $c$.$destroy();
  }
}

;
@Test
//<editor-fold defaultstate="collapsed" desc="clang::format::(anonymous namespace)::FormatTest_LayoutBraceInitializersInReturnStatement_Test::TestBody">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp", line = 6434,
 FQN="clang::format::(anonymous namespace)::FormatTest_LayoutBraceInitializersInReturnStatement_Test::TestBody", NM="_ZN5clang6format12_GLOBAL__N_156FormatTest_LayoutBraceInitializersInReturnStatement_Test8TestBodyEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp -nm=_ZN5clang6format12_GLOBAL__N_156FormatTest_LayoutBraceInitializersInReturnStatement_Test8TestBodyEv")
//</editor-fold>
public void test_LayoutBraceInitializersInReturnStatement() {
  if (markAsSkippedIfNeed(TestState.Successful)) { return; }
  verifyFormat(new StringRef(/*KEEP_STR*/"return (a)(b){1, 2, 3};"));
}

;
@Test
//<editor-fold defaultstate="collapsed" desc="clang::format::(anonymous namespace)::FormatTest_LayoutCxx11BraceInitializers_Test::TestBody">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp", line = 6438,
 FQN="clang::format::(anonymous namespace)::FormatTest_LayoutCxx11BraceInitializers_Test::TestBody", NM="_ZN5clang6format12_GLOBAL__N_144FormatTest_LayoutCxx11BraceInitializers_Test8TestBodyEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp -nm=_ZN5clang6format12_GLOBAL__N_144FormatTest_LayoutCxx11BraceInitializers_Test8TestBodyEv")
//</editor-fold>
public void test_LayoutCxx11BraceInitializers() {
  if (markAsSkippedIfNeed(TestState.Successful)) { return; }
  FormatStyle NoBinPacking = null;
  FormatStyle ExtraSpaces = null;
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    verifyFormat(new StringRef(/*KEEP_STR*/"vector<int> x{1, 2, 3, 4};"));
    verifyFormat(new StringRef(/*KEEP_STR*/"vector<int> x{\n    1, 2, 3, 4,\n};"));
    verifyFormat(new StringRef(/*KEEP_STR*/"vector<T> x{{}, {}, {}, {}};"));
    verifyFormat(new StringRef(/*KEEP_STR*/"f({1, 2});"));
    verifyFormat(new StringRef(/*KEEP_STR*/"auto v = Foo{-1};"));
    verifyFormat(new StringRef(/*KEEP_STR*/"f({1, 2}, {{2, 3}, {4, 5}}, c, {d});"));
    verifyFormat(new StringRef(/*KEEP_STR*/"Class::Class : member{1, 2, 3} {}"));
    verifyFormat(new StringRef(/*KEEP_STR*/"new vector<int>{1, 2, 3};"));
    verifyFormat(new StringRef(/*KEEP_STR*/"new int[3]{1, 2, 3};"));
    verifyFormat(new StringRef(/*KEEP_STR*/"new int{1};"));
    verifyFormat(new StringRef(/*KEEP_STR*/"return {arg1, arg2};"));
    verifyFormat(new StringRef(/*KEEP_STR*/"return {arg1, SomeType{parameter}};"));
    verifyFormat(new StringRef(/*KEEP_STR*/"int count = set<int>{f(), g(), h()}.size();"));
    verifyFormat(new StringRef(/*KEEP_STR*/"new T{arg1, arg2};"));
    verifyFormat(new StringRef(/*KEEP_STR*/"f(MyMap[{composite, key}]);"));
    verifyFormat(new StringRef(/*KEEP_STR*/"class Class {\n  T member = {arg1, arg2};\n};"));
    verifyFormat(new StringRef(/*KEEP_STR*/"vector<int> foo = {::SomeGlobalFunction()};"));
    verifyFormat(new StringRef(/*KEEP_STR*/"static_assert(std::is_integral<int>{} + 0, \"\");"));
    verifyFormat(new StringRef(/*KEEP_STR*/"int a = std::is_integral<int>{} + 0;"));
    
    verifyFormat(new StringRef(/*KEEP_STR*/"int foo(int i) { return fo1{}(i); }"));
    verifyFormat(new StringRef(/*KEEP_STR*/"int foo(int i) { return fo1{}(i); }"));
    verifyFormat(new StringRef(/*KEEP_STR*/"auto i = decltype(x){};"));
    verifyFormat(new StringRef(/*KEEP_STR*/"std::vector<int> v = {1, 0 /* comment */};"));
    verifyFormat(new StringRef(/*KEEP_STR*/"Node n{1, Node{1000}, //\n       2};"));
    verifyFormat(new StringRef(/*KEEP_STR*/"Aaaa aaaaaaa{\n    {\n        aaaa,\n    },\n};"));
    verifyFormat(new StringRef(/*KEEP_STR*/"class C : public D {\n  SomeClass SC{2};\n};"));
    verifyFormat(new StringRef(/*KEEP_STR*/"class C : public A {\n  class D : public B {\n    void f() { int i{2}; }\n  };\n};"));
    verifyFormat(new StringRef(/*KEEP_STR*/"#define A {a, a},"));
    
    // In combination with BinPackArguments = false.
    NoBinPacking = getLLVMStyle();
    NoBinPacking.BinPackArguments = false;
    verifyFormat(new StringRef(/*KEEP_STR*/"const Aaaaaa aaaaa = {aaaaa,\n                      bbbbb,\n                      ccccc,\n                      ddddd,\n                      eeeee,\n                      ffffff,\n                      ggggg,\n                      hhhhhh,\n                      iiiiii,\n                      jjjjjj,\n                      kkkkkk};"), 
        NoBinPacking);
    verifyFormat(new StringRef(/*KEEP_STR*/"const Aaaaaa aaaaa = {\n    aaaaa,\n    bbbbb,\n    ccccc,\n    ddddd,\n    eeeee,\n    ffffff,\n    ggggg,\n    hhhhhh,\n    iiiiii,\n    jjjjjj,\n    kkkkkk,\n};"), 
        NoBinPacking);
    verifyFormat(new StringRef(/*KEEP_STR*/"const Aaaaaa aaaaa = {\n    aaaaa,  bbbbb,  ccccc,  ddddd,  eeeee,  ffffff, ggggg, hhhhhh,\n    iiiiii, jjjjjj, kkkkkk, aaaaa,  bbbbb,  ccccc,  ddddd, eeeee,\n    ffffff, ggggg,  hhhhhh, iiiiii, jjjjjj, kkkkkk,\n};"), 
        NoBinPacking);
    
    // FIXME: The alignment of these trailing comments might be bad. Then again,
    // this might be utterly useless in real code.
    verifyFormat(new StringRef(/*KEEP_STR*/"Constructor::Constructor()\n    : some_value{         //\n                 aaaaaaa, //\n                 bbbbbbb} {}"));
    
    // In braced lists, the first comment is always assumed to belong to the
    // first element. Thus, it can be moved to the next or previous line as
    // appropriate.
    EXPECT_EQ("function({// First element:\n          1,\n          // Second element:\n          2});",format(new StringRef(/*KEEP_STR*/"function({\n    // First element:\n    1,\n    // Second element:\n    2});")));
    EXPECT_EQ("std::vector<int> MyNumbers{\n    // First element:\n    1,\n    // Second element:\n    2};",$c$.clean(format(new StringRef(/*KEEP_STR*/"std::vector<int> MyNumbers{// First element:\n                           1,\n                           // Second element:\n                           2};"), $c$.track(getLLVMStyleWithColumns(30)))));
    // A trailing comma should still lead to an enforced line break.
    EXPECT_EQ("vector<int> SomeVector = {\n    // aaa\n    1, 2,\n};",format(new StringRef(/*KEEP_STR*/"vector<int> SomeVector = { // aaa\n    1, 2, };")));
    
    ExtraSpaces = getLLVMStyle();
    ExtraSpaces.Cpp11BracedListStyle = false;
    ExtraSpaces.ColumnLimit = 75;
    verifyFormat(new StringRef(/*KEEP_STR*/"vector<int> x{ 1, 2, 3, 4 };"), ExtraSpaces);
    verifyFormat(new StringRef(/*KEEP_STR*/"vector<T> x{ {}, {}, {}, {} };"), ExtraSpaces);
    verifyFormat(new StringRef(/*KEEP_STR*/"f({ 1, 2 });"), ExtraSpaces);
    verifyFormat(new StringRef(/*KEEP_STR*/"auto v = Foo{ 1 };"), ExtraSpaces);
    verifyFormat(new StringRef(/*KEEP_STR*/"f({ 1, 2 }, { { 2, 3 }, { 4, 5 } }, c, { d });"), ExtraSpaces);
    verifyFormat(new StringRef(/*KEEP_STR*/"Class::Class : member{ 1, 2, 3 } {}"), ExtraSpaces);
    verifyFormat(new StringRef(/*KEEP_STR*/"new vector<int>{ 1, 2, 3 };"), ExtraSpaces);
    verifyFormat(new StringRef(/*KEEP_STR*/"new int[3]{ 1, 2, 3 };"), ExtraSpaces);
    verifyFormat(new StringRef(/*KEEP_STR*/"return { arg1, arg2 };"), ExtraSpaces);
    verifyFormat(new StringRef(/*KEEP_STR*/"return { arg1, SomeType{ parameter } };"), ExtraSpaces);
    verifyFormat(new StringRef(/*KEEP_STR*/"int count = set<int>{ f(), g(), h() }.size();"), ExtraSpaces);
    verifyFormat(new StringRef(/*KEEP_STR*/"new T{ arg1, arg2 };"), ExtraSpaces);
    verifyFormat(new StringRef(/*KEEP_STR*/"f(MyMap[{ composite, key }]);"), ExtraSpaces);
    verifyFormat(new StringRef(/*KEEP_STR*/"class Class {\n  T member = { arg1, arg2 };\n};"), 
        ExtraSpaces);
    verifyFormat(new StringRef(/*KEEP_STR*/"foo = aaaaaaaaaaa ? vector<int>{ aaaaaaaaaaaaaaaaaaaaaaaaaaa,\n                                 aaaaaaaaaaaaaaaaaaaa, aaaaa }\n                  : vector<int>{ bbbbbbbbbbbbbbbbbbbbbbbbbbb,\n                                 bbbbbbbbbbbbbbbbbbbb, bbbbb };"), 
        ExtraSpaces);
    verifyFormat(new StringRef(/*KEEP_STR*/"DoSomethingWithVector({} /* No data */);"), ExtraSpaces);
    verifyFormat(new StringRef(/*KEEP_STR*/"DoSomethingWithVector({ {} /* No data */ }, { { 1, 2 } });"), 
        ExtraSpaces);
    verifyFormat(new StringRef(/*KEEP_STR*/"someFunction(OtherParam,\n             BracedList{ // comment 1 (Forcing interesting break)\n                         param1, param2,\n                         // comment 2\n                         param3, param4 });"), 
        ExtraSpaces);
    verifyFormat(new StringRef(/*KEEP_STR*/"std::this_thread::sleep_for(\n    std::chrono::nanoseconds{ std::chrono::seconds{ 1 } } / 5);"), 
        ExtraSpaces);
    verifyFormat(new StringRef(/*KEEP_STR*/"std::vector<MyValues> aaaaaaaaaaaaaaaaaaa{\n    aaaaaaa,\n    aaaaaaaaaa,\n    aaaaa,\n    aaaaaaaaaaaaaaa,\n    aaa,\n    aaaaaaaaaa,\n    a,\n    aaaaaaaaaaaaaaaaaaaaa,\n    aaaaaaaaaaaa,\n    aaaaaaaaaaaaaaaaaaa + aaaaaaaaaaaaaaaaaaa,\n    aaaaaaa,\n    a};"));
    verifyFormat(new StringRef(/*KEEP_STR*/"vector<int> foo = { ::SomeGlobalFunction() };"), ExtraSpaces);
  } finally {
    if (ExtraSpaces != null) { ExtraSpaces.$destroy(); }
    if (NoBinPacking != null) { NoBinPacking.$destroy(); }
    $c$.$destroy();
  }
}

;
@Test
//<editor-fold defaultstate="collapsed" desc="clang::format::(anonymous namespace)::FormatTest_FormatsBracedListsInColumnLayout_Test::TestBody">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp", line = 6614,
 FQN="clang::format::(anonymous namespace)::FormatTest_FormatsBracedListsInColumnLayout_Test::TestBody", NM="_ZN5clang6format12_GLOBAL__N_148FormatTest_FormatsBracedListsInColumnLayout_Test8TestBodyEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp -nm=_ZN5clang6format12_GLOBAL__N_148FormatTest_FormatsBracedListsInColumnLayout_Test8TestBodyEv")
//</editor-fold>
public void test_FormatsBracedListsInColumnLayout() {
  if (markAsSkippedIfNeed(TestState.Successful)) { return; }
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    verifyFormat(new StringRef(/*KEEP_STR*/"vector<int> x = {1, 22, 333, 4444, 55555, 666666, 7777777,\n                 1, 22, 333, 4444, 55555, 666666, 7777777,\n                 1, 22, 333, 4444, 55555, 666666, 7777777,\n                 1, 22, 333, 4444, 55555, 666666, 7777777,\n                 1, 22, 333, 4444, 55555, 666666, 7777777,\n                 1, 22, 333, 4444, 55555, 666666, 7777777};"));
    verifyFormat(new StringRef(/*KEEP_STR*/"vector<int> x = {1, 22, 333, 4444, 55555, 666666, 7777777, //\n                 1, 22, 333, 4444, 55555, 666666, 7777777,\n                 1, 22, 333, 4444, 55555, //\n                 1, 22, 333, 4444, 55555, 666666, 7777777,\n                 1, 22, 333, 4444, 55555, 666666, 7777777};"));
    verifyFormat(new StringRef(/*KEEP_STR*/"vector<int> x = {1,       22, 333, 4444, 55555, 666666, 7777777,\n                 1,       22, 333, 4444, 55555, 666666, 7777777,\n                 1,       22, 333, 4444, 55555, 666666, // comment\n                 7777777, 1,  22,  333,  4444,  55555,  666666,\n                 7777777, 1,  22,  333,  4444,  55555,  666666,\n                 7777777, 1,  22,  333,  4444,  55555,  666666,\n                 7777777};"));
    verifyFormat(new StringRef(/*KEEP_STR*/"static const uint16_t CallerSavedRegs64Bittttt[] = {\n    X86::RAX, X86::RDX, X86::RCX, X86::RSI, X86::RDI,\n    X86::R8,  X86::R9,  X86::R10, X86::R11, 0};"));
    verifyFormat(new StringRef(/*KEEP_STR*/"static const uint16_t CallerSavedRegs64Bittttt[] = {\n    X86::RAX, X86::RDX, X86::RCX, X86::RSI, X86::RDI,\n    // Separating comment.\n    X86::R8, X86::R9, X86::R10, X86::R11, 0};"));
    verifyFormat(new StringRef(/*KEEP_STR*/"static const uint16_t CallerSavedRegs64Bittttt[] = {\n    // Leading comment\n    X86::RAX, X86::RDX, X86::RCX, X86::RSI, X86::RDI,\n    X86::R8,  X86::R9,  X86::R10, X86::R11, 0};"));
    verifyFormat(new StringRef(/*KEEP_STR*/"vector<int> x = {1, 1, 1, 1,\n                 1, 1, 1, 1};"), 
        $c$.track(getLLVMStyleWithColumns(39))); $c$.clean();
    verifyFormat(new StringRef(/*KEEP_STR*/"vector<int> x = {1, 1, 1, 1,\n                 1, 1, 1, 1};"), 
        $c$.track(getLLVMStyleWithColumns(38))); $c$.clean();
    verifyFormat(new StringRef(/*KEEP_STR*/"vector<int> aaaaaaaaaaaaaaaaaaaaaa = {\n    1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1};"), 
        $c$.track(getLLVMStyleWithColumns(43))); $c$.clean();
    verifyFormat(new StringRef(/*KEEP_STR*/"static unsigned SomeValues[10][3] = {\n    {1, 4, 0},  {4, 9, 0},  {4, 5, 9},  {8, 5, 4}, {1, 8, 4},\n    {10, 1, 6}, {11, 0, 9}, {2, 11, 9}, {5, 2, 9}, {11, 2, 7}};"));
    verifyFormat(new StringRef(/*KEEP_STR*/"static auto fields = new vector<string>{\n    \"aaaaaaaaaaaaa\",\n    \"aaaaaaaaaaaaa\",\n    \"aaaaaaaaaaaa\",\n    \"aaaaaaaaaaaaaa\",\n    \"aaaaaaaaaaaaaaaaaaaaaaaaa\",\n    \"aaaaaaaaaaaa\",\n    \"aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa\",\n};"));
    verifyFormat(new StringRef(/*KEEP_STR*/"vector<int> x = {1, 2, 3, 4, aaaaaaaaaaaaaaaaa, 6};"));
    verifyFormat(new StringRef(/*KEEP_STR*/"vector<int> x = {1, aaaaaaaaaaaaaaaaaaaaaa,\n                 2, bbbbbbbbbbbbbbbbbbbbbb,\n                 3, cccccccccccccccccccccc};"), 
        $c$.track(getLLVMStyleWithColumns(60))); $c$.clean();
    
    // Trailing commas.
    verifyFormat(new StringRef(/*KEEP_STR*/"vector<int> x = {\n    1, 1, 1, 1, 1, 1, 1, 1,\n};"), 
        $c$.track(getLLVMStyleWithColumns(39))); $c$.clean();
    verifyFormat(new StringRef(/*KEEP_STR*/"vector<int> x = {\n    1, 1, 1, 1, 1, 1, 1, 1, //\n};"), 
        $c$.track(getLLVMStyleWithColumns(39))); $c$.clean();
    verifyFormat(new StringRef(/*KEEP_STR*/"vector<int> x = {1, 1, 1, 1,\n                 1, 1, 1, 1,\n                 /**/ /**/};"), 
        $c$.track(getLLVMStyleWithColumns(39))); $c$.clean();
    
    // Trailing comment in the first line.
    verifyFormat(new StringRef(/*KEEP_STR*/"vector<int> iiiiiiiiiiiiiii = {                      //\n    1111111111, 2222222222, 33333333333, 4444444444, //\n    111111111,  222222222,  3333333333,  444444444,  //\n    11111111,   22222222,   333333333,   44444444};"));
    // Trailing comment in the last line.
    verifyFormat(new StringRef(/*KEEP_STR*/"int aaaaa[] = {\n    1, 2, 3, // comment\n    4, 5, 6  // comment\n};"));
    
    // With nested lists, we should either format one item per line or all nested
    // lists one on line.
    // FIXME: For some nested lists, we can do better.
    verifyFormat(new StringRef(/*KEEP_STR*/"return {{aaaaaaaaaaaaaaaaaaaaa},\n        {aaaaaaaaaaaaaaaaaaa},\n        {aaaaaaaaaaaaaaaaaaaaa},\n        {aaaaaaaaaaaaaaaaa}};"), 
        $c$.track(getLLVMStyleWithColumns(60))); $c$.clean();
    verifyFormat(new StringRef(/*KEEP_STR*/"SomeStruct my_struct_array = {\n    {aaaaaa, aaaaaaaa, aaaaaaaaaa, aaaaaaaaa, aaaaaaaaa, aaaaaaaaaa,\n     aaaaaaaaaaaaa, aaaaaaa, aaa},\n    {aaa, aaa},\n    {aaa, aaa},\n    {aaaa, aaaa, aaaa, aaaa, aaaa, aaaa, aaaa, aaa},\n    {aaaaaaaaaaaaaaaaa, aaaaaaaaaaaaaaaaa, aaaaaaaaaaaaaaaaaaaaaaaa,\n     aaaaaaaaaaaa, a, aaaaaaaaaa, aaaaaaaaa, aaa}};"));
    
    // No column layout should be used here.
    verifyFormat(new StringRef(/*KEEP_STR*/"aaaaaaaaaaaaaaa = {aaaaaaaaaaaaaaaaaaaaaaaaaaa, 0, 0,\n                   bbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbb};"));
    
    verifyNoCrash(new StringRef(/*KEEP_STR*/"a<,"));
    
    // No braced initializer here.
    verifyFormat(new StringRef(/*KEEP_STR*/"void f() {\n  struct Dummy {};\n  f(v);\n}"));
    
    // Long lists should be formatted in columns even if they are nested.
    verifyFormat(new StringRef(/*KEEP_STR*/"vector<int> x = function({1, 22, 333, 4444, 55555, 666666, 7777777,\n                          1, 22, 333, 4444, 55555, 666666, 7777777,\n                          1, 22, 333, 4444, 55555, 666666, 7777777,\n                          1, 22, 333, 4444, 55555, 666666, 7777777,\n                          1, 22, 333, 4444, 55555, 666666, 7777777,\n                          1, 22, 333, 4444, 55555, 666666, 7777777});"));
  } finally {
    $c$.$destroy();
  }
}

;
@Test
//<editor-fold defaultstate="collapsed" desc="clang::format::(anonymous namespace)::FormatTest_PullTrivialFunctionDefinitionsIntoSingleLine_Test::TestBody">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp", line = 6738,
 FQN="clang::format::(anonymous namespace)::FormatTest_PullTrivialFunctionDefinitionsIntoSingleLine_Test::TestBody", NM="_ZN5clang6format12_GLOBAL__N_160FormatTest_PullTrivialFunctionDefinitionsIntoSingleLine_Test8TestBodyEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp -nm=_ZN5clang6format12_GLOBAL__N_160FormatTest_PullTrivialFunctionDefinitionsIntoSingleLine_Test8TestBodyEv")
//</editor-fold>
public void test_PullTrivialFunctionDefinitionsIntoSingleLine() {
  if (markAsSkippedIfNeed(TestState.Successful)) { return; }
  FormatStyle DoNotMerge = null;
  FormatStyle NoColumnLimit = null;
  FormatStyle DoNotMergeNoColumnLimit = null;
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    DoNotMerge = getLLVMStyle();
    DoNotMerge.AllowShortFunctionsOnASingleLine = FormatStyle.ShortFunctionStyle.SFS_None;
    
    verifyFormat(new StringRef(/*KEEP_STR*/"void f() { return 42; }"));
    verifyFormat(new StringRef(/*KEEP_STR*/"void f() {\n  return 42;\n}"), 
        DoNotMerge);
    verifyFormat(new StringRef(/*KEEP_STR*/"void f() {\n  // Comment\n}"));
    verifyFormat(new StringRef(/*KEEP_STR*/"{\n#error {\n  int a;\n}"));
    verifyFormat(new StringRef(/*KEEP_STR*/"{\n  int a;\n#error {\n}"));
    verifyFormat(new StringRef(/*KEEP_STR*/"void f() {} // comment"));
    verifyFormat(new StringRef(/*KEEP_STR*/"void f() { int a; } // comment"));
    verifyFormat(new StringRef(/*KEEP_STR*/"void f() {\n} // comment"), 
        DoNotMerge);
    verifyFormat(new StringRef(/*KEEP_STR*/"void f() {\n  int a;\n} // comment"), 
        DoNotMerge);
    verifyFormat(new StringRef(/*KEEP_STR*/"void f() {\n} // comment"), 
        $c$.track(getLLVMStyleWithColumns(15))); $c$.clean();
    
    verifyFormat(new StringRef(/*KEEP_STR*/"void f() { return 42; }"), $c$.track(getLLVMStyleWithColumns(23))); $c$.clean();
    verifyFormat(new StringRef(/*KEEP_STR*/"void f() {\n  return 42;\n}"), $c$.track(getLLVMStyleWithColumns(22))); $c$.clean();
    
    verifyFormat(new StringRef(/*KEEP_STR*/"void f() {}"), $c$.track(getLLVMStyleWithColumns(11))); $c$.clean();
    verifyFormat(new StringRef(/*KEEP_STR*/"void f() {\n}"), $c$.track(getLLVMStyleWithColumns(10))); $c$.clean();
    verifyFormat(new StringRef(/*KEEP_STR*/"class C {\n  C()\n      : iiiiiiii(nullptr),\n        kkkkkkk(nullptr),\n        mmmmmmm(nullptr),\n        nnnnnnn(nullptr) {}\n};"), 
        $c$.track(getGoogleStyle())); $c$.clean();
    
    NoColumnLimit = getLLVMStyle();
    NoColumnLimit.ColumnLimit = 0;
    EXPECT_EQ("A() : b(0) {}",format(new StringRef(/*KEEP_STR*/"A():b(0){}"), NoColumnLimit));
    EXPECT_EQ("class C {\n  A() : b(0) {}\n};",format(new StringRef(/*KEEP_STR*/"class C{A():b(0){}};"), NoColumnLimit));
    EXPECT_EQ("A()\n    : b(0) {\n}",format(new StringRef(/*KEEP_STR*/"A()\n:b(0)\n{\n}"), NoColumnLimit));
    
    DoNotMergeNoColumnLimit = new FormatStyle(NoColumnLimit);
    DoNotMergeNoColumnLimit.AllowShortFunctionsOnASingleLine
       = FormatStyle.ShortFunctionStyle.SFS_None;
    EXPECT_EQ("A()\n    : b(0) {\n}",format(new StringRef(/*KEEP_STR*/"A():b(0){}"), DoNotMergeNoColumnLimit));
    EXPECT_EQ("A()\n    : b(0) {\n}",format(new StringRef(/*KEEP_STR*/"A()\n:b(0)\n{\n}"), DoNotMergeNoColumnLimit));
    
    verifyFormat(new StringRef(/*KEEP_STR*/"#define A          \\\n  void f() {       \\\n    int i;         \\\n  }"), 
        $c$.track(getLLVMStyleWithColumns(20))); $c$.clean();
    verifyFormat(new StringRef(/*KEEP_STR*/"#define A           \\\n  void f() { int i; }"), 
        $c$.track(getLLVMStyleWithColumns(21))); $c$.clean();
    verifyFormat(new StringRef(/*KEEP_STR*/"#define A            \\\n  void f() {         \\\n    int i;           \\\n  }                  \\\n  int j;"), 
        $c$.track(getLLVMStyleWithColumns(22))); $c$.clean();
    verifyFormat(new StringRef(/*KEEP_STR*/"#define A             \\\n  void f() { int i; } \\\n  int j;"), 
        $c$.track(getLLVMStyleWithColumns(23))); $c$.clean();
  } finally {
    if (DoNotMergeNoColumnLimit != null) { DoNotMergeNoColumnLimit.$destroy(); }
    if (NoColumnLimit != null) { NoColumnLimit.$destroy(); }
    if (DoNotMerge != null) { DoNotMerge.$destroy(); }
    $c$.$destroy();
  }
}

;
@Test
//<editor-fold defaultstate="collapsed" desc="clang::format::(anonymous namespace)::FormatTest_PullInlineFunctionDefinitionsIntoSingleLine_Test::TestBody">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp", line = 6829,
 FQN="clang::format::(anonymous namespace)::FormatTest_PullInlineFunctionDefinitionsIntoSingleLine_Test::TestBody", NM="_ZN5clang6format12_GLOBAL__N_159FormatTest_PullInlineFunctionDefinitionsIntoSingleLine_Test8TestBodyEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp -nm=_ZN5clang6format12_GLOBAL__N_159FormatTest_PullInlineFunctionDefinitionsIntoSingleLine_Test8TestBodyEv")
//</editor-fold>
public void test_PullInlineFunctionDefinitionsIntoSingleLine() {
  if (markAsSkippedIfNeed(TestState.Successful)) { return; }
  FormatStyle MergeInlineOnly = null;
  try {
    MergeInlineOnly = getLLVMStyle();
    MergeInlineOnly.AllowShortFunctionsOnASingleLine = FormatStyle.ShortFunctionStyle.SFS_Inline;
    verifyFormat(new StringRef(/*KEEP_STR*/"class C {\n  int f() { return 42; }\n};"), 
        MergeInlineOnly);
    verifyFormat(new StringRef(/*KEEP_STR*/"int f() {\n  return 42;\n}"), 
        MergeInlineOnly);
  } finally {
    if (MergeInlineOnly != null) { MergeInlineOnly.$destroy(); }
  }
}

;
@Test
//<editor-fold defaultstate="collapsed" desc="clang::format::(anonymous namespace)::FormatTest_UnderstandContextOfRecordTypeKeywords_Test::TestBody">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp", line = 6842,
 FQN="clang::format::(anonymous namespace)::FormatTest_UnderstandContextOfRecordTypeKeywords_Test::TestBody", NM="_ZN5clang6format12_GLOBAL__N_153FormatTest_UnderstandContextOfRecordTypeKeywords_Test8TestBodyEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp -nm=_ZN5clang6format12_GLOBAL__N_153FormatTest_UnderstandContextOfRecordTypeKeywords_Test8TestBodyEv")
//</editor-fold>
public void test_UnderstandContextOfRecordTypeKeywords() {
  if (markAsSkippedIfNeed(TestState.Successful)) { return; }
  // Elaborate type variable declarations.
  verifyFormat(new StringRef(/*KEEP_STR*/"struct foo a = {bar};\nint n;"));
  verifyFormat(new StringRef(/*KEEP_STR*/"class foo a = {bar};\nint n;"));
  verifyFormat(new StringRef(/*KEEP_STR*/"union foo a = {bar};\nint n;"));
  
  // Elaborate types inside function definitions.
  verifyFormat(new StringRef(/*KEEP_STR*/"struct foo f() {}\nint n;"));
  verifyFormat(new StringRef(/*KEEP_STR*/"class foo f() {}\nint n;"));
  verifyFormat(new StringRef(/*KEEP_STR*/"union foo f() {}\nint n;"));
  
  // Templates.
  verifyFormat(new StringRef(/*KEEP_STR*/"template <class X> void f() {}\nint n;"));
  verifyFormat(new StringRef(/*KEEP_STR*/"template <struct X> void f() {}\nint n;"));
  verifyFormat(new StringRef(/*KEEP_STR*/"template <union X> void f() {}\nint n;"));
  
  // Actual definitions...
  verifyFormat(new StringRef(/*KEEP_STR*/"struct {\n} n;"));
  verifyFormat(new StringRef(/*KEEP_STR*/"template <template <class T, class Y>, class Z> class X {\n} n;"));
  verifyFormat(new StringRef(/*KEEP_STR*/"union Z {\n  int n;\n} x;"));
  verifyFormat(new StringRef(/*KEEP_STR*/"class MACRO Z {\n} n;"));
  verifyFormat(new StringRef(/*KEEP_STR*/"class MACRO(X) Z {\n} n;"));
  verifyFormat(new StringRef(/*KEEP_STR*/"class __attribute__(X) Z {\n} n;"));
  verifyFormat(new StringRef(/*KEEP_STR*/"class __declspec(X) Z {\n} n;"));
  verifyFormat(new StringRef(/*KEEP_STR*/"class A##B##C {\n} n;"));
  verifyFormat(new StringRef(/*KEEP_STR*/"class alignas(16) Z {\n} n;"));
  verifyFormat(new StringRef(/*KEEP_STR*/"class MACRO(X) alignas(16) Z {\n} n;"));
  verifyFormat(new StringRef(/*KEEP_STR*/"class MACROA MACRO(X) Z {\n} n;"));
  
  // Redefinition from nested context:
  verifyFormat(new StringRef(/*KEEP_STR*/"class A::B::C {\n} n;"));
  
  // Template definitions.
  verifyFormat(new StringRef(/*KEEP_STR*/"template <typename F>\nMatcher(const Matcher<F> &Other,\n        typename enable_if_c<is_base_of<F, T>::value &&\n                             !is_same<F, T>::value>::type * = 0)\n    : Implementation(new ImplicitCastMatcher<F>(Other)) {}"));
  
  // FIXME: This is still incorrectly handled at the formatter side.
  verifyFormat(new StringRef(/*KEEP_STR*/"template <> struct X < 15, i<3 && 42 < 50 && 33 < 28> {};"));
  verifyFormat(new StringRef(/*KEEP_STR*/"int i = SomeFunction(a<b, a> b);"));
  
  // FIXME:
  // This now gets parsed incorrectly as class definition.
  // verifyFormat("class A<int> f() {\n}\nint n;");
  
  // Elaborate types where incorrectly parsing the structural element would
  // break the indent.
  verifyFormat(new StringRef(/*KEEP_STR*/"if (true)\n  class X x;\nelse\n  f();\n"));
  
  // This is simply incomplete. Formatting is not important, but must not crash.
  verifyFormat(new StringRef(/*KEEP_STR*/"class A:"));
}

;
@Test
//<editor-fold defaultstate="collapsed" desc="clang::format::(anonymous namespace)::FormatTest_DoNotInterfereWithErrorAndWarning_Test::TestBody">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp", line = 6902,
 FQN="clang::format::(anonymous namespace)::FormatTest_DoNotInterfereWithErrorAndWarning_Test::TestBody", NM="_ZN5clang6format12_GLOBAL__N_149FormatTest_DoNotInterfereWithErrorAndWarning_Test8TestBodyEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp -nm=_ZN5clang6format12_GLOBAL__N_149FormatTest_DoNotInterfereWithErrorAndWarning_Test8TestBodyEv")
//</editor-fold>
public void test_DoNotInterfereWithErrorAndWarning() {
  if (markAsSkippedIfNeed(TestState.Successful)) { return; }
    EXPECT_EQ("#error Leave     all         white!!!!! space* alone!\n",format(new StringRef(/*KEEP_STR*/"#error Leave     all         white!!!!! space* alone!\n")));
    EXPECT_EQ("#warning Leave     all         white!!!!! space* alone!\n",format(new StringRef(/*KEEP_STR*/"#warning Leave     all         white!!!!! space* alone!\n")));
    EXPECT_EQ("#error 1",format(new StringRef(/*KEEP_STR*/"  #  error   1")));
    EXPECT_EQ("#warning 1",format(new StringRef(/*KEEP_STR*/"  #  warning 1")));
}

;
@Test
//<editor-fold defaultstate="collapsed" desc="clang::format::(anonymous namespace)::FormatTest_FormatHashIfExpressions_Test::TestBody">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp", line = 6912,
 FQN="clang::format::(anonymous namespace)::FormatTest_FormatHashIfExpressions_Test::TestBody", NM="_ZN5clang6format12_GLOBAL__N_139FormatTest_FormatHashIfExpressions_Test8TestBodyEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp -nm=_ZN5clang6format12_GLOBAL__N_139FormatTest_FormatHashIfExpressions_Test8TestBodyEv")
//</editor-fold>
public void test_FormatHashIfExpressions() {
  if (markAsSkippedIfNeed(TestState.Successful)) { return; }
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    verifyFormat(new StringRef(/*KEEP_STR*/"#if AAAA && BBBB"));
    verifyFormat(new StringRef(/*KEEP_STR*/"#if (AAAA && BBBB)"));
    verifyFormat(new StringRef(/*KEEP_STR*/"#elif (AAAA && BBBB)"));
    // FIXME: Come up with a better indentation for #elif.
    verifyFormat(new StringRef(/*KEEP_STR*/"#if !defined(AAAAAAA) && (defined CCCCCC || defined DDDDDD) &&  \\\n    defined(BBBBBBBB)\n#elif !defined(AAAAAA) && (defined CCCCC || defined DDDDDD) &&  \\\n    defined(BBBBBBBB)\n#endif"), 
        $c$.track(getLLVMStyleWithColumns(65))); $c$.clean();
  } finally {
    $c$.$destroy();
  }
}

;
@Test
//<editor-fold defaultstate="collapsed" desc="clang::format::(anonymous namespace)::FormatTest_MergeHandlingInTheFaceOfPreprocessorDirectives_Test::TestBody">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp", line = 6926,
 FQN="clang::format::(anonymous namespace)::FormatTest_MergeHandlingInTheFaceOfPreprocessorDirectives_Test::TestBody", NM="_ZN5clang6format12_GLOBAL__N_162FormatTest_MergeHandlingInTheFaceOfPreprocessorDirectives_Test8TestBodyEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp -nm=_ZN5clang6format12_GLOBAL__N_162FormatTest_MergeHandlingInTheFaceOfPreprocessorDirectives_Test8TestBodyEv")
//</editor-fold>
public void test_MergeHandlingInTheFaceOfPreprocessorDirectives() {
  if (markAsSkippedIfNeed(TestState.Successful)) { return; }
  FormatStyle AllowsMergedIf = null;
  FormatStyle ShortMergedIf = null;
  try {
    AllowsMergedIf = getGoogleStyle();
    AllowsMergedIf.AllowShortIfStatementsOnASingleLine = true;
    verifyFormat(new StringRef(/*KEEP_STR*/"void f() { f(); }\n#error E"), AllowsMergedIf);
    verifyFormat(new StringRef(/*KEEP_STR*/"if (true) return 42;\n#error E"), AllowsMergedIf);
    verifyFormat(new StringRef(/*KEEP_STR*/"if (true)\n#error E\n  return 42;"), AllowsMergedIf);
    EXPECT_EQ("if (true) return 42;",format(new StringRef(/*KEEP_STR*/"if (true)\nreturn 42;"), AllowsMergedIf));
    ShortMergedIf = new FormatStyle(AllowsMergedIf);
    ShortMergedIf.ColumnLimit = 25;
    verifyFormat(new StringRef(/*KEEP_STR*/"#define A \\\n  if (true) return 42;"), 
        ShortMergedIf);
    verifyFormat(new StringRef(/*KEEP_STR*/"#define A \\\n  f();    \\\n  if (true)\n#define B"), 
        ShortMergedIf);
    verifyFormat(new StringRef(/*KEEP_STR*/"#define A \\\n  f();    \\\n  if (true)\ng();"), 
        ShortMergedIf);
    verifyFormat(new StringRef(/*KEEP_STR*/"{\n#ifdef A\n  // Comment\n  if (true) continue;\n#endif\n  // Comment\n  if (true) continue;\n}"), 
        ShortMergedIf);
    ShortMergedIf.ColumnLimit = 29;
    verifyFormat(new StringRef(/*KEEP_STR*/"#define A                   \\\n  if (aaaaaaaaaa) return 1; \\\n  return 2;"), 
        ShortMergedIf);
    ShortMergedIf.ColumnLimit = 28;
    verifyFormat(new StringRef(/*KEEP_STR*/"#define A         \\\n  if (aaaaaaaaaa) \\\n    return 1;     \\\n  return 2;"), 
        ShortMergedIf);
  } finally {
    if (ShortMergedIf != null) { ShortMergedIf.$destroy(); }
    if (AllowsMergedIf != null) { AllowsMergedIf.$destroy(); }
  }
}

;
@Test
//<editor-fold defaultstate="collapsed" desc="clang::format::(anonymous namespace)::FormatTest_BlockCommentsInControlLoops_Test::TestBody">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp", line = 6971,
 FQN="clang::format::(anonymous namespace)::FormatTest_BlockCommentsInControlLoops_Test::TestBody", NM="_ZN5clang6format12_GLOBAL__N_143FormatTest_BlockCommentsInControlLoops_Test8TestBodyEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp -nm=_ZN5clang6format12_GLOBAL__N_143FormatTest_BlockCommentsInControlLoops_Test8TestBodyEv")
//</editor-fold>
public void test_BlockCommentsInControlLoops() {
  if (markAsSkippedIfNeed(TestState.Successful)) { return; }
  verifyFormat(new StringRef(/*KEEP_STR*/"if (0) /* a comment in a strange place */ {\n  f();\n}"));
  verifyFormat(new StringRef(/*KEEP_STR*/"if (0) /* a comment in a strange place */ {\n  f();\n} /* another comment */ else /* comment #3 */ {\n  g();\n}"));
  verifyFormat(new StringRef(/*KEEP_STR*/"while (0) /* a comment in a strange place */ {\n  f();\n}"));
  verifyFormat(new StringRef(/*KEEP_STR*/"for (;;) /* a comment in a strange place */ {\n  f();\n}"));
  verifyFormat(new StringRef(/*KEEP_STR*/"do /* a comment in a strange place */ {\n  f();\n} /* another comment */ while (0);"));
}

;
@Test
//<editor-fold defaultstate="collapsed" desc="clang::format::(anonymous namespace)::FormatTest_BlockComments_Test::TestBody">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp", line = 6991,
 FQN="clang::format::(anonymous namespace)::FormatTest_BlockComments_Test::TestBody", NM="_ZN5clang6format12_GLOBAL__N_129FormatTest_BlockComments_Test8TestBodyEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp -nm=_ZN5clang6format12_GLOBAL__N_129FormatTest_BlockComments_Test8TestBodyEv")
//</editor-fold>
public void test_BlockComments() {
  if (markAsSkippedIfNeed(TestState.Successful)) { return; }
  FormatStyle NoBinPacking = null;
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    EXPECT_EQ("/* */ /* */ /* */\n/* */ /* */ /* */",format(new StringRef(/*KEEP_STR*/"/* *//* */  /* */\n/* *//* */  /* */")));
    EXPECT_EQ("/* */ a /* */ b;",format(new StringRef(/*KEEP_STR*/"  /* */  a/* */  b;")));
    EXPECT_EQ("#define A /*123*/ \\\n  b\n/* */\nsomeCall(\n    parameter);",$c$.clean(format(new StringRef(/*KEEP_STR*/"#define A /*123*/ b\n/* */\nsomeCall(parameter);"), $c$.track(getLLVMStyleWithColumns(15)))));
    EXPECT_EQ("#define A\n/* */ someCall(\n    parameter);",$c$.clean(format(new StringRef(/*KEEP_STR*/"#define A\n/* */someCall(parameter);"), $c$.track(getLLVMStyleWithColumns(15)))));
    EXPECT_EQ("/*\n**\n*/",format(new StringRef(/*KEEP_STR*/"/*\n**\n*/")));
    EXPECT_EQ("/*\n*\n * aaaaaa\n * aaaaaa\n*/",$c$.clean(format(new StringRef(/*KEEP_STR*/"/*\n*\n * aaaaaa aaaaaa\n*/"), $c$.track(getLLVMStyleWithColumns(10)))));
    EXPECT_EQ("/*\n**\n* aaaaaa\n*aaaaaa\n*/",$c$.clean(format(new StringRef(/*KEEP_STR*/"/*\n**\n* aaaaaa aaaaaa\n*/"), $c$.track(getLLVMStyleWithColumns(10)))));
    EXPECT_EQ("int aaaaaaaaaaaaaaaaaaaaaaaaaaaa =\n    /* line 1\n       bbbbbbbbbbbb */\n    bbbbbbbbbbbbbbbbbbbbbbbbbbbb;",$c$.clean(format(new StringRef(/*KEEP_STR*/"int aaaaaaaaaaaaaaaaaaaaaaaaaaaa =\n    /* line 1\n       bbbbbbbbbbbb */ bbbbbbbbbbbbbbbbbbbbbbbbbbbb;"), $c$.track(getLLVMStyleWithColumns(50)))));
    
    NoBinPacking = getLLVMStyle();
    NoBinPacking.BinPackParameters = false;
    EXPECT_EQ("someFunction(1, /* comment 1 */\n             2, /* comment 2 */\n             3, /* comment 3 */\n             aaaa,\n             bbbb);",format(new StringRef(/*KEEP_STR*/"someFunction (1,   /* comment 1 */\n                2, /* comment 2 */  \n               3,   /* comment 3 */\naaaa, bbbb );"), NoBinPacking));
    verifyFormat(new StringRef(/*KEEP_STR*/"bool aaaaaaaaaaaaa = /* comment: */ aaaaaaaaaaaaaaaaaaaaaaaaaaaaaa ||\n                     aaaaaaaaaaaaaaaaaaaaaaaaaaaa;"));
    EXPECT_EQ("bool aaaaaaaaaaaaa = /* trailing comment */\n    aaaaaaaaaaaaaaaaaaaaaaaaaaa || aaaaaaaaaaaaaaaaaaaaaaaaa ||\n    aaaaaaaaaaaaaaaaaaaaaaaaaaaa || aaaaaaaaaaaaaaaaaaaaaaaaaa;",format(new StringRef(/*KEEP_STR*/"bool       aaaaaaaaaaaaa =       /* trailing comment */\n    aaaaaaaaaaaaaaaaaaaaaaaaaaa||aaaaaaaaaaaaaaaaaaaaaaaaa    ||\n    aaaaaaaaaaaaaaaaaaaaaaaaaaaa   || aaaaaaaaaaaaaaaaaaaaaaaaaa;")));
    EXPECT_EQ("int aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa; /* comment */\nint bbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbb;   /* comment */\nint cccccccccccccccccccccccccccccc;       /* comment */\n",format(new StringRef(/*KEEP_STR*/"int aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa; /* comment */\nint      bbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbb; /* comment */\nint    cccccccccccccccccccccccccccccc;  /* comment */\n")));
    
    verifyFormat(new StringRef(/*KEEP_STR*/"void f(int * /* unused */) {}"));
    EXPECT_EQ("/*\n **\n */",format(new StringRef(/*KEEP_STR*/"/*\n **\n */")));
    EXPECT_EQ("/*\n *q\n */",format(new StringRef(/*KEEP_STR*/"/*\n *q\n */")));
    EXPECT_EQ("/*\n * q\n */",format(new StringRef(/*KEEP_STR*/"/*\n * q\n */")));
    EXPECT_EQ("/*\n **/",format(new StringRef(/*KEEP_STR*/"/*\n **/")));
    EXPECT_EQ("/*\n ***/",format(new StringRef(/*KEEP_STR*/"/*\n ***/")));
  } finally {
    if (NoBinPacking != null) { NoBinPacking.$destroy(); }
    $c$.$destroy();
  }
}

;
@Test
//<editor-fold defaultstate="collapsed" desc="clang::format::(anonymous namespace)::FormatTest_BlockCommentsInMacros_Test::TestBody">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp", line = 7102,
 FQN="clang::format::(anonymous namespace)::FormatTest_BlockCommentsInMacros_Test::TestBody", NM="_ZN5clang6format12_GLOBAL__N_137FormatTest_BlockCommentsInMacros_Test8TestBodyEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp -nm=_ZN5clang6format12_GLOBAL__N_137FormatTest_BlockCommentsInMacros_Test8TestBodyEv")
//</editor-fold>
public void test_BlockCommentsInMacros() {
  if (markAsSkippedIfNeed(TestState.Successful)) { return; }
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    EXPECT_EQ("#define A          \\\n  {                \\\n    /* one line */ \\\n    someCall();",$c$.clean(format(new StringRef(/*KEEP_STR*/"#define A {        \\\n  /* one line */   \\\n  someCall();"), $c$.track(getLLVMStyleWithColumns(20)))));
    EXPECT_EQ("#define A          \\\n  {                \\\n    /* previous */ \\\n    /* one line */ \\\n    someCall();",$c$.clean(format(new StringRef(/*KEEP_STR*/"#define A {        \\\n  /* previous */   \\\n  /* one line */   \\\n  someCall();"), $c$.track(getLLVMStyleWithColumns(20)))));
  } finally {
    $c$.$destroy();
  }
}

;
@Test
//<editor-fold defaultstate="collapsed" desc="clang::format::(anonymous namespace)::FormatTest_BlockCommentsAtEndOfLine_Test::TestBody">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp", line = 7123,
 FQN="clang::format::(anonymous namespace)::FormatTest_BlockCommentsAtEndOfLine_Test::TestBody", NM="_ZN5clang6format12_GLOBAL__N_140FormatTest_BlockCommentsAtEndOfLine_Test8TestBodyEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp -nm=_ZN5clang6format12_GLOBAL__N_140FormatTest_BlockCommentsAtEndOfLine_Test8TestBodyEv")
//</editor-fold>
public void test_BlockCommentsAtEndOfLine() {
  if (markAsSkippedIfNeed(TestState.Successful)) { return; }
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    EXPECT_EQ("a = {\n    1111 /*    */\n};",$c$.clean(format(new StringRef(/*KEEP_STR*/"a = {1111 /*    */\n};"), $c$.track(getLLVMStyleWithColumns(15)))));
    EXPECT_EQ("a = {\n    1111 /*      */\n};",$c$.clean(format(new StringRef(/*KEEP_STR*/"a = {1111 /*      */\n};"), $c$.track(getLLVMStyleWithColumns(15)))));
    
    // FIXME: The formatting is still wrong here.
    EXPECT_EQ("a = {\n    1111 /*      a\n            */\n};",$c$.clean(format(new StringRef(/*KEEP_STR*/"a = {1111 /*      a */\n};"), $c$.track(getLLVMStyleWithColumns(15)))));
  } finally {
    $c$.$destroy();
  }
}

;
@Test
//<editor-fold defaultstate="collapsed" desc="clang::format::(anonymous namespace)::FormatTest_IndentLineCommentsInStartOfBlockAtEndOfFile_Test::TestBody">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp", line = 7147,
 FQN="clang::format::(anonymous namespace)::FormatTest_IndentLineCommentsInStartOfBlockAtEndOfFile_Test::TestBody", NM="_ZN5clang6format12_GLOBAL__N_159FormatTest_IndentLineCommentsInStartOfBlockAtEndOfFile_Test8TestBodyEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp -nm=_ZN5clang6format12_GLOBAL__N_159FormatTest_IndentLineCommentsInStartOfBlockAtEndOfFile_Test8TestBodyEv")
//</editor-fold>
public void test_IndentLineCommentsInStartOfBlockAtEndOfFile() {
  if (markAsSkippedIfNeed(TestState.Successful)) { return; }
  verifyFormat(new StringRef(/*KEEP_STR*/"{\n  // a\n  // b"));
}

;
@Test
//<editor-fold defaultstate="collapsed" desc="clang::format::(anonymous namespace)::FormatTest_FormatStarDependingOnContext_Test::TestBody">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp", line = 7153,
 FQN="clang::format::(anonymous namespace)::FormatTest_FormatStarDependingOnContext_Test::TestBody", NM="_ZN5clang6format12_GLOBAL__N_144FormatTest_FormatStarDependingOnContext_Test8TestBodyEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp -nm=_ZN5clang6format12_GLOBAL__N_144FormatTest_FormatStarDependingOnContext_Test8TestBodyEv")
//</editor-fold>
public void test_FormatStarDependingOnContext() {
  if (markAsSkippedIfNeed(TestState.Successful)) { return; }
  verifyFormat(new StringRef(/*KEEP_STR*/"void f(int *a);"));
  verifyFormat(new StringRef(/*KEEP_STR*/"void f() { f(fint * b); }"));
  verifyFormat(new StringRef(/*KEEP_STR*/"class A {\n  void f(int *a);\n};"));
  verifyFormat(new StringRef(/*KEEP_STR*/"class A {\n  int *a;\n};"));
  verifyFormat(new StringRef(/*KEEP_STR*/"namespace a {\nnamespace b {\nclass A {\n  void f() {}\n  int *a;\n};\n}\n}"));
}

;
@Test
//<editor-fold defaultstate="collapsed" desc="clang::format::(anonymous namespace)::FormatTest_SpecialTokensAtEndOfLine_Test::TestBody">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp", line = 7168,
 FQN="clang::format::(anonymous namespace)::FormatTest_SpecialTokensAtEndOfLine_Test::TestBody", NM="_ZN5clang6format12_GLOBAL__N_140FormatTest_SpecialTokensAtEndOfLine_Test8TestBodyEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp -nm=_ZN5clang6format12_GLOBAL__N_140FormatTest_SpecialTokensAtEndOfLine_Test8TestBodyEv")
//</editor-fold>
public void test_SpecialTokensAtEndOfLine() {
  if (markAsSkippedIfNeed(TestState.Successful)) { return; }
  verifyFormat(new StringRef(/*KEEP_STR*/$while));
  verifyFormat(new StringRef(/*KEEP_STR*/$operator));
}


//===----------------------------------------------------------------------===//
// Objective-C tests.
//===----------------------------------------------------------------------===//
;
@Test
//<editor-fold defaultstate="collapsed" desc="clang::format::(anonymous namespace)::FormatTest_FormatForObjectiveCMethodDecls_Test::TestBody">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp", line = 7177,
 FQN="clang::format::(anonymous namespace)::FormatTest_FormatForObjectiveCMethodDecls_Test::TestBody", NM="_ZN5clang6format12_GLOBAL__N_146FormatTest_FormatForObjectiveCMethodDecls_Test8TestBodyEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp -nm=_ZN5clang6format12_GLOBAL__N_146FormatTest_FormatForObjectiveCMethodDecls_Test8TestBodyEv")
//</editor-fold>
public void test_FormatForObjectiveCMethodDecls() {
  if (markAsSkippedIfNeed(TestState.Successful)) { return; }
  FormatStyle Style = null;
  try {
    verifyFormat(new StringRef(/*KEEP_STR*/"- (void)sendAction:(SEL)aSelector to:(BOOL)anObject;"));
    EXPECT_EQ("- (NSUInteger)indexOfObject:(id)anObject;",format(new StringRef(/*KEEP_STR*/"-(NSUInteger)indexOfObject:(id)anObject;")));
    EXPECT_EQ("- (NSInteger)Mthod1;",format(new StringRef(/*KEEP_STR*/"-(NSInteger)Mthod1;")));
    EXPECT_EQ("+ (id)Mthod2;",format(new StringRef(/*KEEP_STR*/"+(id)Mthod2;")));
    EXPECT_EQ("- (NSInteger)Method3:(id)anObject;",format(new StringRef(/*KEEP_STR*/"-(NSInteger)Method3:(id)anObject;")));
    EXPECT_EQ("- (NSInteger)Method4:(id)anObject;",format(new StringRef(/*KEEP_STR*/"-(NSInteger)Method4:(id)anObject;")));
    EXPECT_EQ("- (NSInteger)Method5:(id)anObject:(id)AnotherObject;",format(new StringRef(/*KEEP_STR*/"-(NSInteger)Method5:(id)anObject:(id)AnotherObject;")));
    EXPECT_EQ("- (id)Method6:(id)A:(id)B:(id)C:(id)D;",format(new StringRef(/*KEEP_STR*/"- (id)Method6:(id)A:(id)B:(id)C:(id)D;")));
    EXPECT_EQ("- (void)sendAction:(SEL)aSelector to:(id)anObject forAllCells:(BOOL)flag;",format(new StringRef(/*KEEP_STR*/"- (void)sendAction:(SEL)aSelector to:(id)anObject forAllCells:(BOOL)flag;")));
    
    // Very long objectiveC method declaration.
    verifyFormat(new StringRef(/*KEEP_STR*/"- (void)aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa:\n    (SoooooooooooooooooooooomeType *)bbbbbbbbbb;"));
    verifyFormat(new StringRef(/*KEEP_STR*/"- (NSUInteger)indexOfObject:(id)anObject\n                    inRange:(NSRange)range\n                   outRange:(NSRange)out_range\n                  outRange1:(NSRange)out_range1\n                  outRange2:(NSRange)out_range2\n                  outRange3:(NSRange)out_range3\n                  outRange4:(NSRange)out_range4\n                  outRange5:(NSRange)out_range5\n                  outRange6:(NSRange)out_range6\n                  outRange7:(NSRange)out_range7\n                  outRange8:(NSRange)out_range8\n                  outRange9:(NSRange)out_range9;"));
    
    // When the function name has to be wrapped.
    Style = getLLVMStyle();
    Style.IndentWrappedFunctionNames = false;
    verifyFormat(new StringRef(/*KEEP_STR*/"- (SomeLooooooooooooooooooooongType *)\nveryLooooooooooongName:(NSString)aaaaaaaaaaaaaa\n           anotherName:(NSString)bbbbbbbbbbbbbb {\n}"), 
        Style);
    Style.IndentWrappedFunctionNames = true;
    verifyFormat(new StringRef(/*KEEP_STR*/"- (SomeLooooooooooooooooooooongType *)\n    veryLooooooooooongName:(NSString)aaaaaaaaaaaaaa\n               anotherName:(NSString)bbbbbbbbbbbbbb {\n}"), 
        Style);
    
    verifyFormat(new StringRef(/*KEEP_STR*/"- (int)sum:(vector<int>)numbers;"));
    verifyGoogleFormat(new StringRef(/*KEEP_STR*/"- (void)setDelegate:(id<Protocol>)delegate;"));
    // FIXME: In LLVM style, there should be a space in front of a '<' for ObjC
    // protocol lists (but not for template classes):
    // verifyFormat("- (void)setDelegate:(id <Protocol>)delegate;");
    verifyFormat(new StringRef(/*KEEP_STR*/"- (int (*)())foo:(int (*)())f;"));
    verifyGoogleFormat(new StringRef(/*KEEP_STR*/"- (int (*)())foo:(int (*)())foo;"));
    
    // If there's no return type (very rare in practice!), LLVM and Google style
    // agree.
    verifyFormat(new StringRef(/*KEEP_STR*/"- foo;"));
    verifyFormat(new StringRef(/*KEEP_STR*/"- foo:(int)f;"));
    verifyGoogleFormat(new StringRef(/*KEEP_STR*/"- foo:(int)foo;"));
  } finally {
    if (Style != null) { Style.$destroy(); }
  }
}

;
@Test
//<editor-fold defaultstate="collapsed" desc="clang::format::(anonymous namespace)::FormatTest_FormatObjCInterface_Test::TestBody">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp", line = 7243,
 FQN="clang::format::(anonymous namespace)::FormatTest_FormatObjCInterface_Test::TestBody", NM="_ZN5clang6format12_GLOBAL__N_135FormatTest_FormatObjCInterface_Test8TestBodyEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp -nm=_ZN5clang6format12_GLOBAL__N_135FormatTest_FormatObjCInterface_Test8TestBodyEv")
//</editor-fold>
public void test_FormatObjCInterface() {
  if (markAsSkippedIfNeed(TestState.Successful)) { return; }
  FormatStyle OnePerLine = null;
  try {
    verifyFormat(new StringRef(/*KEEP_STR*/"@interface Foo : NSObject <NSSomeDelegate> {\n@public\n  int field1;\n@protected\n  int field2;\n@private\n  int field3;\n@package\n  int field4;\n}\n+ (id)init;\n@end"));
    
    verifyGoogleFormat(new StringRef(/*KEEP_STR*/"@interface Foo : NSObject<NSSomeDelegate> {\n @public\n  int field1;\n @protected\n  int field2;\n @private\n  int field3;\n @package\n  int field4;\n}\n+ (id)init;\n@end"));
    
    verifyFormat(new StringRef(/*KEEP_STR*/"@interface /* wait for it */ Foo\n+ (id)init;\n// Look, a comment!\n- (int)answerWith:(int)i;\n@end"));
    
    verifyFormat(new StringRef(/*KEEP_STR*/"@interface Foo\n@end\n@interface Bar\n@end"));
    
    verifyFormat(new StringRef(/*KEEP_STR*/"@interface Foo : Bar\n+ (id)init;\n@end"));
    
    verifyFormat(new StringRef(/*KEEP_STR*/"@interface Foo : /**/ Bar /**/ <Baz, /**/ Quux>\n+ (id)init;\n@end"));
    
    verifyGoogleFormat(new StringRef(/*KEEP_STR*/"@interface Foo : Bar<Baz, Quux>\n+ (id)init;\n@end"));
    
    verifyFormat(new StringRef(/*KEEP_STR*/"@interface Foo (HackStuff)\n+ (id)init;\n@end"));
    
    verifyFormat(new StringRef(/*KEEP_STR*/"@interface Foo ()\n+ (id)init;\n@end"));
    
    verifyFormat(new StringRef(/*KEEP_STR*/"@interface Foo (HackStuff) <MyProtocol>\n+ (id)init;\n@end"));
    
    verifyGoogleFormat(new StringRef(/*KEEP_STR*/"@interface Foo (HackStuff)<MyProtocol>\n+ (id)init;\n@end"));
    
    verifyFormat(new StringRef(/*KEEP_STR*/"@interface Foo {\n  int _i;\n}\n+ (id)init;\n@end"));
    
    verifyFormat(new StringRef(/*KEEP_STR*/"@interface Foo : Bar {\n  int _i;\n}\n+ (id)init;\n@end"));
    
    verifyFormat(new StringRef(/*KEEP_STR*/"@interface Foo : Bar <Baz, Quux> {\n  int _i;\n}\n+ (id)init;\n@end"));
    
    verifyFormat(new StringRef(/*KEEP_STR*/"@interface Foo (HackStuff) {\n  int _i;\n}\n+ (id)init;\n@end"));
    
    verifyFormat(new StringRef(/*KEEP_STR*/"@interface Foo () {\n  int _i;\n}\n+ (id)init;\n@end"));
    
    verifyFormat(new StringRef(/*KEEP_STR*/"@interface Foo (HackStuff) <MyProtocol> {\n  int _i;\n}\n+ (id)init;\n@end"));
    
    OnePerLine = getGoogleStyle();
    OnePerLine.BinPackParameters = false;
    verifyFormat(new StringRef(/*KEEP_STR*/"@interface aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa ()<\n    aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa,\n    aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa,\n    aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa,\n    aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa> {\n}"), 
        OnePerLine);
  } finally {
    if (OnePerLine != null) { OnePerLine.$destroy(); }
  }
}

;
@Test
//<editor-fold defaultstate="collapsed" desc="clang::format::(anonymous namespace)::FormatTest_FormatObjCImplementation_Test::TestBody">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp", line = 7356,
 FQN="clang::format::(anonymous namespace)::FormatTest_FormatObjCImplementation_Test::TestBody", NM="_ZN5clang6format12_GLOBAL__N_140FormatTest_FormatObjCImplementation_Test8TestBodyEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp -nm=_ZN5clang6format12_GLOBAL__N_140FormatTest_FormatObjCImplementation_Test8TestBodyEv")
//</editor-fold>
public void test_FormatObjCImplementation() {
  if (markAsSkippedIfNeed(TestState.Successful)) { return; }
  verifyFormat(new StringRef(/*KEEP_STR*/"@implementation Foo : NSObject {\n@public\n  int field1;\n@protected\n  int field2;\n@private\n  int field3;\n@package\n  int field4;\n}\n+ (id)init {\n}\n@end"));
  
  verifyGoogleFormat(new StringRef(/*KEEP_STR*/"@implementation Foo : NSObject {\n @public\n  int field1;\n @protected\n  int field2;\n @private\n  int field3;\n @package\n  int field4;\n}\n+ (id)init {\n}\n@end"));
  
  verifyFormat(new StringRef(/*KEEP_STR*/"@implementation Foo\n+ (id)init {\n  if (true)\n    return nil;\n}\n// Look, a comment!\n- (int)answerWith:(int)i {\n  return i;\n}\n+ (int)answerWith:(int)i {\n  return i;\n}\n@end"));
  
  verifyFormat(new StringRef(/*KEEP_STR*/"@implementation Foo\n@end\n@implementation Bar\n@end"));
    EXPECT_EQ("@implementation Foo : Bar\n+ (id)init {\n}\n- (void)foo {\n}\n@end",format(new StringRef(/*KEEP_STR*/"@implementation Foo : Bar\n+(id)init{}\n-(void)foo{}\n@end")));
  
  verifyFormat(new StringRef(/*KEEP_STR*/"@implementation Foo {\n  int _i;\n}\n+ (id)init {\n}\n@end"));
  
  verifyFormat(new StringRef(/*KEEP_STR*/"@implementation Foo : Bar {\n  int _i;\n}\n+ (id)init {\n}\n@end"));
  
  verifyFormat(new StringRef(/*KEEP_STR*/"@implementation Foo (HackStuff)\n+ (id)init {\n}\n@end"));
  verifyFormat(new StringRef(/*KEEP_STR*/"@implementation ObjcClass\n- (void)method;\n{}\n@end"));
}

;
@Test
//<editor-fold defaultstate="collapsed" desc="clang::format::(anonymous namespace)::FormatTest_FormatObjCProtocol_Test::TestBody">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp", line = 7432,
 FQN="clang::format::(anonymous namespace)::FormatTest_FormatObjCProtocol_Test::TestBody", NM="_ZN5clang6format12_GLOBAL__N_134FormatTest_FormatObjCProtocol_Test8TestBodyEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp -nm=_ZN5clang6format12_GLOBAL__N_134FormatTest_FormatObjCProtocol_Test8TestBodyEv")
//</editor-fold>
public void test_FormatObjCProtocol() {
  if (markAsSkippedIfNeed(TestState.Successful)) { return; }
  verifyFormat(new StringRef(/*KEEP_STR*/"@protocol Foo\n@property(weak) id delegate;\n- (NSUInteger)numberOfThings;\n@end"));
  
  verifyFormat(new StringRef(/*KEEP_STR*/"@protocol MyProtocol <NSObject>\n- (NSUInteger)numberOfThings;\n@end"));
  
  verifyGoogleFormat(new StringRef(/*KEEP_STR*/"@protocol MyProtocol<NSObject>\n- (NSUInteger)numberOfThings;\n@end"));
  
  verifyFormat(new StringRef(/*KEEP_STR*/"@protocol Foo;\n@protocol Bar;\n"));
  
  verifyFormat(new StringRef(/*KEEP_STR*/"@protocol Foo\n@end\n@protocol Bar\n@end"));
  
  verifyFormat(new StringRef(/*KEEP_STR*/"@protocol myProtocol\n- (void)mandatoryWithInt:(int)i;\n@optional\n- (void)optional;\n@required\n- (void)required;\n@optional\n@property(assign) int madProp;\n@end\n"));
  
  verifyFormat(new StringRef(/*KEEP_STR*/"@property(nonatomic, assign, readonly)\n    int *looooooooooooooooooooooooooooongNumber;\n@property(nonatomic, assign, readonly)\n    NSString *looooooooooooooooooooooooooooongName;"));
  
  verifyFormat(new StringRef(/*KEEP_STR*/"@implementation PR18406\n}\n@end"));
}

;
@Test
//<editor-fold defaultstate="collapsed" desc="clang::format::(anonymous namespace)::FormatTest_FormatObjCMethodDeclarations_Test::TestBody">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp", line = 7474,
 FQN="clang::format::(anonymous namespace)::FormatTest_FormatObjCMethodDeclarations_Test::TestBody", NM="_ZN5clang6format12_GLOBAL__N_144FormatTest_FormatObjCMethodDeclarations_Test8TestBodyEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp -nm=_ZN5clang6format12_GLOBAL__N_144FormatTest_FormatObjCMethodDeclarations_Test8TestBodyEv")
//</editor-fold>
public void test_FormatObjCMethodDeclarations() {
  if (markAsSkippedIfNeed(TestState.Successful)) { return; }
  FormatStyle continuationStyle = null;
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    verifyFormat(new StringRef(/*KEEP_STR*/"- (void)doSomethingWith:(GTMFoo *)theFoo\n                   rect:(NSRect)theRect\n               interval:(float)theInterval {\n}"));
    verifyFormat(new StringRef(/*KEEP_STR*/"- (void)shortf:(GTMFoo *)theFoo\n      longKeyword:(NSRect)theRect\n    longerKeyword:(float)theInterval\n            error:(NSError **)theError {\n}"));
    verifyFormat(new StringRef(/*KEEP_STR*/"- (void)shortf:(GTMFoo *)theFoo\n          longKeyword:(NSRect)theRect\n    evenLongerKeyword:(float)theInterval\n                error:(NSError **)theError {\n}"));
    verifyFormat(new StringRef(/*KEEP_STR*/"- (instancetype)initXxxxxx:(id<x>)x\n                         y:(id<yyyyyyyyyyyyyyyyyyyy>)y\n    NS_DESIGNATED_INITIALIZER;"), 
        $c$.track(getLLVMStyleWithColumns(60))); $c$.clean();
    
    // Continuation indent width should win over aligning colons if the function
    // name is long.
    continuationStyle = getGoogleStyle();
    continuationStyle.ColumnLimit = 40;
    continuationStyle.IndentWrappedFunctionNames = true;
    verifyFormat(new StringRef(/*KEEP_STR*/"- (void)shortf:(GTMFoo *)theFoo\n    dontAlignNamef:(NSRect)theRect {\n}"), 
        continuationStyle);
    
    // Make sure we don't break aligning for short parameter names.
    verifyFormat(new StringRef(/*KEEP_STR*/"- (void)shortf:(GTMFoo *)theFoo\n       aShortf:(NSRect)theRect {\n}"), 
        continuationStyle);
  } finally {
    if (continuationStyle != null) { continuationStyle.$destroy(); }
    $c$.$destroy();
  }
}

;
@Test
//<editor-fold defaultstate="collapsed" desc="clang::format::(anonymous namespace)::FormatTest_FormatObjCMethodExpr_Test::TestBody">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp", line = 7511,
 FQN="clang::format::(anonymous namespace)::FormatTest_FormatObjCMethodExpr_Test::TestBody", NM="_ZN5clang6format12_GLOBAL__N_136FormatTest_FormatObjCMethodExpr_Test8TestBodyEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp -nm=_ZN5clang6format12_GLOBAL__N_136FormatTest_FormatObjCMethodExpr_Test8TestBodyEv")
//</editor-fold>
public void test_FormatObjCMethodExpr() {
  if (markAsSkippedIfNeed(TestState.Successful)) { return; }
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    verifyFormat(new StringRef(/*KEEP_STR*/"[foo bar:baz];"));
    verifyFormat(new StringRef(/*KEEP_STR*/"return [foo bar:baz];"));
    verifyFormat(new StringRef(/*KEEP_STR*/"return (a)[foo bar:baz];"));
    verifyFormat(new StringRef(/*KEEP_STR*/"f([foo bar:baz]);"));
    verifyFormat(new StringRef(/*KEEP_STR*/"f(2, [foo bar:baz]);"));
    verifyFormat(new StringRef(/*KEEP_STR*/"f(2, a ? b : c);"));
    verifyFormat(new StringRef(/*KEEP_STR*/"[[self initWithInt:4] bar:[baz quux:arrrr]];"));
    
    // Unary operators.
    verifyFormat(new StringRef(/*KEEP_STR*/"int a = +[foo bar:baz];"));
    verifyFormat(new StringRef(/*KEEP_STR*/"int a = -[foo bar:baz];"));
    verifyFormat(new StringRef(/*KEEP_STR*/"int a = ![foo bar:baz];"));
    verifyFormat(new StringRef(/*KEEP_STR*/"int a = ~[foo bar:baz];"));
    verifyFormat(new StringRef(/*KEEP_STR*/"int a = ++[foo bar:baz];"));
    verifyFormat(new StringRef(/*KEEP_STR*/"int a = --[foo bar:baz];"));
    verifyFormat(new StringRef(/*KEEP_STR*/"int a = sizeof [foo bar:baz];"));
    verifyFormat(new StringRef(/*KEEP_STR*/"int a = alignof [foo bar:baz];"), $c$.track(getGoogleStyle())); $c$.clean();
    verifyFormat(new StringRef(/*KEEP_STR*/"int a = &[foo bar:baz];"));
    verifyFormat(new StringRef(/*KEEP_STR*/"int a = *[foo bar:baz];"));
    // FIXME: Make casts work, without breaking f()[4].
    // verifyFormat("int a = (int)[foo bar:baz];");
    // verifyFormat("return (int)[foo bar:baz];");
    // verifyFormat("(void)[foo bar:baz];");
    verifyFormat(new StringRef(/*KEEP_STR*/"return (MyType *)[self.tableView cellForRowAtIndexPath:cell];"));
    
    // Binary operators.
    verifyFormat(new StringRef(/*KEEP_STR*/"[foo bar:baz], [foo bar:baz];"));
    verifyFormat(new StringRef(/*KEEP_STR*/"[foo bar:baz] = [foo bar:baz];"));
    verifyFormat(new StringRef(/*KEEP_STR*/"[foo bar:baz] *= [foo bar:baz];"));
    verifyFormat(new StringRef(/*KEEP_STR*/"[foo bar:baz] /= [foo bar:baz];"));
    verifyFormat(new StringRef(/*KEEP_STR*/"[foo bar:baz] %= [foo bar:baz];"));
    verifyFormat(new StringRef(/*KEEP_STR*/"[foo bar:baz] += [foo bar:baz];"));
    verifyFormat(new StringRef(/*KEEP_STR*/"[foo bar:baz] -= [foo bar:baz];"));
    verifyFormat(new StringRef(/*KEEP_STR*/"[foo bar:baz] <<= [foo bar:baz];"));
    verifyFormat(new StringRef(/*KEEP_STR*/"[foo bar:baz] >>= [foo bar:baz];"));
    verifyFormat(new StringRef(/*KEEP_STR*/"[foo bar:baz] &= [foo bar:baz];"));
    verifyFormat(new StringRef(/*KEEP_STR*/"[foo bar:baz] ^= [foo bar:baz];"));
    verifyFormat(new StringRef(/*KEEP_STR*/"[foo bar:baz] |= [foo bar:baz];"));
    verifyFormat(new StringRef(/*KEEP_STR*/"[foo bar:baz] ? [foo bar:baz] : [foo bar:baz];"));
    verifyFormat(new StringRef(/*KEEP_STR*/"[foo bar:baz] || [foo bar:baz];"));
    verifyFormat(new StringRef(/*KEEP_STR*/"[foo bar:baz] && [foo bar:baz];"));
    verifyFormat(new StringRef(/*KEEP_STR*/"[foo bar:baz] | [foo bar:baz];"));
    verifyFormat(new StringRef(/*KEEP_STR*/"[foo bar:baz] ^ [foo bar:baz];"));
    verifyFormat(new StringRef(/*KEEP_STR*/"[foo bar:baz] & [foo bar:baz];"));
    verifyFormat(new StringRef(/*KEEP_STR*/"[foo bar:baz] == [foo bar:baz];"));
    verifyFormat(new StringRef(/*KEEP_STR*/"[foo bar:baz] != [foo bar:baz];"));
    verifyFormat(new StringRef(/*KEEP_STR*/"[foo bar:baz] >= [foo bar:baz];"));
    verifyFormat(new StringRef(/*KEEP_STR*/"[foo bar:baz] <= [foo bar:baz];"));
    verifyFormat(new StringRef(/*KEEP_STR*/"[foo bar:baz] > [foo bar:baz];"));
    verifyFormat(new StringRef(/*KEEP_STR*/"[foo bar:baz] < [foo bar:baz];"));
    verifyFormat(new StringRef(/*KEEP_STR*/"[foo bar:baz] >> [foo bar:baz];"));
    verifyFormat(new StringRef(/*KEEP_STR*/"[foo bar:baz] << [foo bar:baz];"));
    verifyFormat(new StringRef(/*KEEP_STR*/"[foo bar:baz] - [foo bar:baz];"));
    verifyFormat(new StringRef(/*KEEP_STR*/"[foo bar:baz] + [foo bar:baz];"));
    verifyFormat(new StringRef(/*KEEP_STR*/"[foo bar:baz] * [foo bar:baz];"));
    verifyFormat(new StringRef(/*KEEP_STR*/"[foo bar:baz] / [foo bar:baz];"));
    verifyFormat(new StringRef(/*KEEP_STR*/"[foo bar:baz] % [foo bar:baz];"));
    // Whew!
    verifyFormat(new StringRef(/*KEEP_STR*/"return in[42];"));
    verifyFormat(new StringRef(/*KEEP_STR*/"for (auto v : in[1]) {\n}"));
    verifyFormat(new StringRef(/*KEEP_STR*/"for (int i = 0; i < in[a]; ++i) {\n}"));
    verifyFormat(new StringRef(/*KEEP_STR*/"for (int i = 0; in[a] < i; ++i) {\n}"));
    verifyFormat(new StringRef(/*KEEP_STR*/"for (int i = 0; i < n; ++i, ++in[a]) {\n}"));
    verifyFormat(new StringRef(/*KEEP_STR*/"for (int i = 0; i < n; ++i, in[a]++) {\n}"));
    verifyFormat(new StringRef(/*KEEP_STR*/"for (int i = 0; i < f(in[a]); ++i, in[a]++) {\n}"));
    verifyFormat(new StringRef(/*KEEP_STR*/"for (id foo in [self getStuffFor:bla]) {\n}"));
    verifyFormat(new StringRef(/*KEEP_STR*/"[self aaaaa:MACRO(a, b:, c:)];"));
    verifyFormat(new StringRef(/*KEEP_STR*/"[self aaaaa:(1 + 2) bbbbb:3];"));
    verifyFormat(new StringRef(/*KEEP_STR*/"[self aaaaa:(Type)a bbbbb:3];"));
    
    verifyFormat(new StringRef(/*KEEP_STR*/"[self stuffWithInt:(4 + 2) float:4.5];"));
    verifyFormat(new StringRef(/*KEEP_STR*/"[self stuffWithInt:a ? b : c float:4.5];"));
    verifyFormat(new StringRef(/*KEEP_STR*/"[self stuffWithInt:a ? [self foo:bar] : c];"));
    verifyFormat(new StringRef(/*KEEP_STR*/"[self stuffWithInt:a ? (e ? f : g) : c];"));
    verifyFormat(new StringRef(/*KEEP_STR*/"[cond ? obj1 : obj2 methodWithParam:param]"));
    verifyFormat(new StringRef(/*KEEP_STR*/"[button setAction:@selector(zoomOut:)];"));
    verifyFormat(new StringRef(/*KEEP_STR*/"[color getRed:&r green:&g blue:&b alpha:&a];"));
    
    verifyFormat(new StringRef(/*KEEP_STR*/"arr[[self indexForFoo:a]];"));
    verifyFormat(new StringRef(/*KEEP_STR*/"throw [self errorFor:a];"));
    verifyFormat(new StringRef(/*KEEP_STR*/"@throw [self errorFor:a];"));
    
    verifyFormat(new StringRef(/*KEEP_STR*/"[(id)foo bar:(id)baz quux:(id)snorf];"));
    verifyFormat(new StringRef(/*KEEP_STR*/"[(id)foo bar:(id) ? baz : quux];"));
    verifyFormat(new StringRef(/*KEEP_STR*/"4 > 4 ? (id)a : (id)baz;"));
    
    // This tests that the formatter doesn't break after "backing" but before ":",
    // which would be at 80 columns.
    verifyFormat(new StringRef(/*KEEP_STR*/"void f() {\n  if ((self = [super initWithContentRect:contentRect\n                               styleMask:styleMask ?: otherMask\n                                 backing:NSBackingStoreBuffered\n                                   defer:YES]))"));
    
    verifyFormat(new StringRef(/*KEEP_STR*/"[foo checkThatBreakingAfterColonWorksOk:\n         [bar ifItDoes:reduceOverallLineLengthLikeInThisCase]];"));
    
    verifyFormat(new StringRef(/*KEEP_STR*/"[myObj short:arg1 // Force line break\n          longKeyword:arg2 != nil ? arg2 : @\"longKeyword\"\n    evenLongerKeyword:arg3 ?: @\"evenLongerKeyword\"\n                error:arg4];"));
    verifyFormat(new StringRef(/*KEEP_STR*/"void f() {\n  popup_window_.reset([[RenderWidgetPopupWindow alloc]\n      initWithContentRect:NSMakeRect(origin_global.x, origin_global.y,\n                                     pos.width(), pos.height())\n                styleMask:NSBorderlessWindowMask\n                  backing:NSBackingStoreBuffered\n                    defer:NO]);\n}"));
    verifyFormat(new StringRef(/*KEEP_STR*/"void f() {\n  popup_wdow_.reset([[RenderWidgetPopupWindow alloc]\n      iniithContentRect:NSMakRet(origin_global.x, origin_global.y,\n                                 pos.width(), pos.height())\n                syeMask:NSBorderlessWindowMask\n                  bking:NSBackingStoreBuffered\n                    der:NO]);\n}"), 
        $c$.track(getLLVMStyleWithColumns(70))); $c$.clean();
    verifyFormat(new StringRef(/*KEEP_STR*/"void f() {\n  popup_window_.reset([[RenderWidgetPopupWindow alloc]\n      initWithContentRect:NSMakeRect(origin_global.x, origin_global.y,\n                                     pos.width(), pos.height())\n                styleMask:NSBorderlessWindowMask\n                  backing:NSBackingStoreBuffered\n                    defer:NO]);\n}"), 
        $c$.track(getChromiumStyle(FormatStyle.LanguageKind.LK_Cpp))); $c$.clean();
    verifyFormat(new StringRef(/*KEEP_STR*/"[contentsContainer replaceSubview:[subviews objectAtIndex:0]\n                             with:contentsNativeView];"));
    
    verifyFormat(new StringRef(/*KEEP_STR*/"[pboard addTypes:[NSArray arrayWithObject:kBookmarkButtonDragType]\n           owner:nillllll];"));
    
    verifyFormat(new StringRef(/*KEEP_STR*/"[pboard setData:[NSData dataWithBytes:&button length:sizeof(button)]\n        forType:kBookmarkButtonDragType];"));
    
    verifyFormat(new StringRef(/*KEEP_STR*/"[defaultCenter addObserver:self\n                  selector:@selector(willEnterFullscreen)\n                      name:kWillEnterFullscreenNotification\n                    object:nil];"));
    verifyFormat(new StringRef(/*KEEP_STR*/"[image_rep drawInRect:drawRect\n             fromRect:NSZeroRect\n            operation:NSCompositeCopy\n             fraction:1.0\n       respectFlipped:NO\n                hints:nil];"));
    verifyFormat(new StringRef(/*KEEP_STR*/"[aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa\n    aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa];"));
    verifyFormat(new StringRef(/*KEEP_STR*/"[aaaaaaaaaaaaaaaaaaaa(aaaaaaaaaaaaaaaaaaaaa)\n    aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa];"));
    verifyFormat(new StringRef(/*KEEP_STR*/"[aaaaaaaaaaaaaaaaaaaaaaa.aaaaaaaa[aaaaaaaaaaaaaaaaaaaaa]\n    aaaaaaaaaaaaaaaaaaaaaa];"));
    verifyFormat(new StringRef(/*KEEP_STR*/"[call aaaaaaaa.aaaaaa.aaaaaaaa.aaaaaaaa.aaaaaaaa.aaaaaaaa\n        .aaaaaaaa];"),  // FIXME: Indentation seems off.
        $c$.track(getLLVMStyleWithColumns(60))); $c$.clean();
    
    verifyFormat(new StringRef(/*KEEP_STR*/"scoped_nsobject<NSTextField> message(\n    // The frame will be fixed up when |-setMessageText:| is called.\n    [[NSTextField alloc] initWithFrame:NSMakeRect(0, 0, 0, 0)]);"));
    verifyFormat(new StringRef(/*KEEP_STR*/"[self aaaaaa:bbbbbbbbbbbbb\n    aaaaaaaaaa:bbbbbbbbbbbbbbbbb\n         aaaaa:bbbbbbbbbbb + bbbbbbbbbbbb\n          aaaa:bbb];"));
    verifyFormat(new StringRef(/*KEEP_STR*/"[self param:function( //\n                parameter)]"));
    verifyFormat(new StringRef(/*KEEP_STR*/"[self aaaaaaaaaa:aaaaaaaaaaaaaaa | aaaaaaaaaaaaaaa | aaaaaaaaaaaaaaa |\n                 aaaaaaaaaaaaaaa | aaaaaaaaaaaaaaa | aaaaaaaaaaaaaaa |\n                 aaaaaaaaaaaaaaa | aaaaaaaaaaaaaaa];"));
    
    // FIXME: This violates the column limit.
    verifyFormat(new StringRef(/*KEEP_STR*/"[aaaaaaaaaaaaaaaaaaaaaaaaa\n    aaaaaaaaaaaaaaaaa:aaaaaaaa\n                  aaa:aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa];"), 
        $c$.track(getLLVMStyleWithColumns(60))); $c$.clean();
    
    // Variadic parameters.
    verifyFormat(new StringRef(/*KEEP_STR*/"NSArray *myStrings = [NSArray stringarray:@\"a\", @\"b\", nil];"));
    verifyFormat(new StringRef(/*KEEP_STR*/"[self aaaaaaaaaaaaa:aaaaaaaaaaaaaaa, aaaaaaaaaaaaaaa, aaaaaaaaaaaaaaa,\n                    aaaaaaaaaaaaaaa, aaaaaaaaaaaaaaa, aaaaaaaaaaaaaaa,\n                    aaaaaaaaaaaaaaa, aaaaaaaaaaaaaaa];"));
    verifyFormat(new StringRef(/*KEEP_STR*/"[self // break\n      a:a\n    aaa:aaa];"));
    verifyFormat(new StringRef(/*KEEP_STR*/"bool a = ([aaaaaaaa aaaaa] == aaaaaaaaaaaaaaaaa ||\n          [aaaaaaaa aaaaa] == aaaaaaaaaaaaaaaaaaaa);"));
  } finally {
    $c$.$destroy();
  }
}

;
@Test
//<editor-fold defaultstate="collapsed" desc="clang::format::(anonymous namespace)::FormatTest_ObjCAt_Test::TestBody">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp", line = 7713,
 FQN="clang::format::(anonymous namespace)::FormatTest_ObjCAt_Test::TestBody", NM="_ZN5clang6format12_GLOBAL__N_122FormatTest_ObjCAt_Test8TestBodyEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp -nm=_ZN5clang6format12_GLOBAL__N_122FormatTest_ObjCAt_Test8TestBodyEv")
//</editor-fold>
public void test_ObjCAt() {
  if (markAsSkippedIfNeed(TestState.Successful)) { return; }
  verifyFormat(new StringRef(/*KEEP_STR*/"@autoreleasepool"));
  verifyFormat(new StringRef(/*KEEP_STR*/"@catch"));
  verifyFormat(new StringRef(/*KEEP_STR*/"@class"));
  verifyFormat(new StringRef(/*KEEP_STR*/"@compatibility_alias"));
  verifyFormat(new StringRef(/*KEEP_STR*/"@defs"));
  verifyFormat(new StringRef(/*KEEP_STR*/"@dynamic"));
  verifyFormat(new StringRef(/*KEEP_STR*/"@encode"));
  verifyFormat(new StringRef(/*KEEP_STR*/"@end"));
  verifyFormat(new StringRef(/*KEEP_STR*/"@finally"));
  verifyFormat(new StringRef(/*KEEP_STR*/"@implementation"));
  verifyFormat(new StringRef(/*KEEP_STR*/"@import"));
  verifyFormat(new StringRef(/*KEEP_STR*/"@interface"));
  verifyFormat(new StringRef(/*KEEP_STR*/"@optional"));
  verifyFormat(new StringRef(/*KEEP_STR*/"@package"));
  verifyFormat(new StringRef(/*KEEP_STR*/"@private"));
  verifyFormat(new StringRef(/*KEEP_STR*/"@property"));
  verifyFormat(new StringRef(/*KEEP_STR*/"@protected"));
  verifyFormat(new StringRef(/*KEEP_STR*/"@protocol"));
  verifyFormat(new StringRef(/*KEEP_STR*/"@public"));
  verifyFormat(new StringRef(/*KEEP_STR*/"@required"));
  verifyFormat(new StringRef(/*KEEP_STR*/"@selector"));
  verifyFormat(new StringRef(/*KEEP_STR*/"@synchronized"));
  verifyFormat(new StringRef(/*KEEP_STR*/"@synthesize"));
  verifyFormat(new StringRef(/*KEEP_STR*/"@throw"));
  verifyFormat(new StringRef(/*KEEP_STR*/"@try"));
    EXPECT_EQ("@interface",format(new StringRef(/*KEEP_STR*/"@ interface")));
  
  // The precise formatting of this doesn't matter, nobody writes code like
  // this.
  verifyFormat(new StringRef(/*KEEP_STR*/"@ /*foo*/ interface"));
}

;
@Test
//<editor-fold defaultstate="collapsed" desc="clang::format::(anonymous namespace)::FormatTest_ObjCSnippets_Test::TestBody">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp", line = 7747,
 FQN="clang::format::(anonymous namespace)::FormatTest_ObjCSnippets_Test::TestBody", NM="_ZN5clang6format12_GLOBAL__N_128FormatTest_ObjCSnippets_Test8TestBodyEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp -nm=_ZN5clang6format12_GLOBAL__N_128FormatTest_ObjCSnippets_Test8TestBodyEv")
//</editor-fold>
public void test_ObjCSnippets() {
  if (markAsSkippedIfNeed(TestState.Successful)) { return; }
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    verifyFormat(new StringRef(/*KEEP_STR*/"@autoreleasepool {\n  foo();\n}"));
    verifyFormat(new StringRef(/*KEEP_STR*/"@class Foo, Bar;"));
    verifyFormat(new StringRef(/*KEEP_STR*/"@compatibility_alias AliasName ExistingClass;"));
    verifyFormat(new StringRef(/*KEEP_STR*/"@dynamic textColor;"));
    verifyFormat(new StringRef(/*KEEP_STR*/"char *buf1 = @encode(int *);"));
    verifyFormat(new StringRef(/*KEEP_STR*/"char *buf1 = @encode(typeof(4 * 5));"));
    verifyFormat(new StringRef(/*KEEP_STR*/"char *buf1 = @encode(int **);"));
    verifyFormat(new StringRef(/*KEEP_STR*/"Protocol *proto = @protocol(p1);"));
    verifyFormat(new StringRef(/*KEEP_STR*/"SEL s = @selector(foo:);"));
    verifyFormat(new StringRef(/*KEEP_STR*/"@synchronized(self) {\n  f();\n}"));
    
    verifyFormat(new StringRef(/*KEEP_STR*/"@synthesize dropArrowPosition = dropArrowPosition_;"));
    verifyGoogleFormat(new StringRef(/*KEEP_STR*/"@synthesize dropArrowPosition = dropArrowPosition_;"));
    
    verifyFormat(new StringRef(/*KEEP_STR*/"@property(assign, nonatomic) CGFloat hoverAlpha;"));
    verifyFormat(new StringRef(/*KEEP_STR*/"@property(assign, getter=isEditable) BOOL editable;"));
    verifyGoogleFormat(new StringRef(/*KEEP_STR*/"@property(assign, getter=isEditable) BOOL editable;"));
    verifyFormat(new StringRef(/*KEEP_STR*/"@property (assign, getter=isEditable) BOOL editable;"), 
        $c$.track(getMozillaStyle())); $c$.clean();
    verifyFormat(new StringRef(/*KEEP_STR*/"@property BOOL editable;"), $c$.track(getMozillaStyle())); $c$.clean();
    verifyFormat(new StringRef(/*KEEP_STR*/"@property (assign, getter=isEditable) BOOL editable;"), 
        $c$.track(getWebKitStyle())); $c$.clean();
    verifyFormat(new StringRef(/*KEEP_STR*/"@property BOOL editable;"), $c$.track(getWebKitStyle())); $c$.clean();
    
    verifyFormat(new StringRef(/*KEEP_STR*/"@import foo.bar;\n@import baz;"));
  } finally {
    $c$.$destroy();
  }
}

;
@Test
//<editor-fold defaultstate="collapsed" desc="clang::format::(anonymous namespace)::FormatTest_ObjCForIn_Test::TestBody">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp", line = 7780,
 FQN="clang::format::(anonymous namespace)::FormatTest_ObjCForIn_Test::TestBody", NM="_ZN5clang6format12_GLOBAL__N_125FormatTest_ObjCForIn_Test8TestBodyEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp -nm=_ZN5clang6format12_GLOBAL__N_125FormatTest_ObjCForIn_Test8TestBodyEv")
//</editor-fold>
public void test_ObjCForIn() {
  if (markAsSkippedIfNeed(TestState.Successful)) { return; }
  verifyFormat(new StringRef(/*KEEP_STR*/"- (void)test {\n  for (NSString *n in arrayOfStrings) {\n    foo(n);\n  }\n}"));
  verifyFormat(new StringRef(/*KEEP_STR*/"- (void)test {\n  for (NSString *n in (__bridge NSArray *)arrayOfStrings) {\n    foo(n);\n  }\n}"));
}

;
@Test
//<editor-fold defaultstate="collapsed" desc="clang::format::(anonymous namespace)::FormatTest_ObjCLiterals_Test::TestBody">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp", line = 7793,
 FQN="clang::format::(anonymous namespace)::FormatTest_ObjCLiterals_Test::TestBody", NM="_ZN5clang6format12_GLOBAL__N_128FormatTest_ObjCLiterals_Test8TestBodyEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp -nm=_ZN5clang6format12_GLOBAL__N_128FormatTest_ObjCLiterals_Test8TestBodyEv")
//</editor-fold>
public void test_ObjCLiterals() {
  if (markAsSkippedIfNeed(TestState.Successful)) { return; }
  verifyFormat(new StringRef(/*KEEP_STR*/"@\"String\""));
  verifyFormat(new StringRef(/*KEEP_STR*/"@1"));
  verifyFormat(new StringRef(/*KEEP_STR*/"@+4.8"));
  verifyFormat(new StringRef(/*KEEP_STR*/"@-4"));
  verifyFormat(new StringRef(/*KEEP_STR*/"@1LL"));
  verifyFormat(new StringRef(/*KEEP_STR*/"@.5"));
  verifyFormat(new StringRef(/*KEEP_STR*/"@'c'"));
  verifyFormat(new StringRef(/*KEEP_STR*/"@true"));
  
  verifyFormat(new StringRef(/*KEEP_STR*/"NSNumber *smallestInt = @(-INT_MAX - 1);"));
  verifyFormat(new StringRef(/*KEEP_STR*/"NSNumber *piOverTwo = @(M_PI / 2);"));
  verifyFormat(new StringRef(/*KEEP_STR*/"NSNumber *favoriteColor = @(Green);"));
  verifyFormat(new StringRef(/*KEEP_STR*/"NSString *path = @(getenv(\"PATH\"));"));
  
  verifyFormat(new StringRef(/*KEEP_STR*/"[dictionary setObject:@(1) forKey:@\"number\"];"));
}

;
@Test
//<editor-fold defaultstate="collapsed" desc="clang::format::(anonymous namespace)::FormatTest_ObjCDictLiterals_Test::TestBody">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp", line = 7811,
 FQN="clang::format::(anonymous namespace)::FormatTest_ObjCDictLiterals_Test::TestBody", NM="_ZN5clang6format12_GLOBAL__N_132FormatTest_ObjCDictLiterals_Test8TestBodyEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp -nm=_ZN5clang6format12_GLOBAL__N_132FormatTest_ObjCDictLiterals_Test8TestBodyEv")
//</editor-fold>
public void test_ObjCDictLiterals() {
  if (markAsSkippedIfNeed(TestState.Successful)) { return; }
  verifyFormat(new StringRef(/*KEEP_STR*/"@{"));
  verifyFormat(new StringRef(/*KEEP_STR*/"@{}"));
  verifyFormat(new StringRef(/*KEEP_STR*/"@{@\"one\" : @1}"));
  verifyFormat(new StringRef(/*KEEP_STR*/"return @{@\"one\" : @1;"));
  verifyFormat(new StringRef(/*KEEP_STR*/"@{@\"one\" : @1}"));
  
  verifyFormat(new StringRef(/*KEEP_STR*/"@{@\"one\" : @{@2 : @1}}"));
  verifyFormat(new StringRef(/*KEEP_STR*/"@{\n  @\"one\" : @{@2 : @1},\n}"));
  
  verifyFormat(new StringRef(/*KEEP_STR*/"@{1 > 2 ? @\"one\" : @\"two\" : 1 > 2 ? @1 : @2}"));
  verifyIncompleteFormat(new StringRef(/*KEEP_STR*/"[self setDict:@{}"));
  verifyIncompleteFormat(new StringRef(/*KEEP_STR*/"[self setDict:@{@1 : @2}"));
  verifyFormat(new StringRef(/*KEEP_STR*/"NSLog(@\"%@\", @{@1 : @2, @2 : @3}[@1]);"));
  verifyFormat(new StringRef(/*KEEP_STR*/"NSDictionary *masses = @{@\"H\" : @1.0078, @\"He\" : @4.0026};"));
  verifyFormat(new StringRef(/*KEEP_STR*/"NSDictionary *settings = @{AVEncoderKey : @(AVAudioQualityMax)};"));
  
  verifyFormat(new StringRef(/*KEEP_STR*/"NSDictionary *d = @{\n  @\"nam\" : NSUserNam(),\n  @\"dte\" : [NSDate date],\n  @\"processInfo\" : [NSProcessInfo processInfo]\n};"));
  verifyFormat(new StringRef(/*KEEP_STR*/"@{\n  NSFontAttributeNameeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee : regularFont,\n};"));
  verifyGoogleFormat(new StringRef(/*KEEP_STR*/"@{\n  NSFontAttributeNameeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee : regularFont,\n};"));
  verifyFormat(new StringRef(/*KEEP_STR*/"@{\n  NSFontAttributeNameeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee :\n      reeeeeeeeeeeeeeeeeeeeeeeegularFont,\n};"));
  
  // We should try to be robust in case someone forgets the "@".
  verifyFormat(new StringRef(/*KEEP_STR*/"NSDictionary *d = {\n  @\"nam\" : NSUserNam(),\n  @\"dte\" : [NSDate date],\n  @\"processInfo\" : [NSProcessInfo processInfo]\n};"));
  verifyFormat(new StringRef(/*KEEP_STR*/"NSMutableDictionary *dictionary =\n    [NSMutableDictionary dictionaryWithDictionary:@{\n      aaaaaaaaaaaaaaaaaaaaa : aaaaaaaaaaaaa,\n      bbbbbbbbbbbbbbbbbb : bbbbb,\n      cccccccccccccccc : ccccccccccccccc\n    }];"));
  
  // Ensure that casts before the key are kept on the same line as the key.
  verifyFormat(new StringRef(/*KEEP_STR*/"NSDictionary *d = @{\n  (aaaaaaaa id)aaaaaaaaa : (aaaaaaaa id)aaaaaaaaaaaaaaaaaaaaaaaa,\n  (aaaaaaaa id)aaaaaaaaaaaaaa : (aaaaaaaa id)aaaaaaaaaaaaaa,\n};"));
}

;
@Test
//<editor-fold defaultstate="collapsed" desc="clang::format::(anonymous namespace)::FormatTest_ObjCArrayLiterals_Test::TestBody">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp", line = 7874,
 FQN="clang::format::(anonymous namespace)::FormatTest_ObjCArrayLiterals_Test::TestBody", NM="_ZN5clang6format12_GLOBAL__N_133FormatTest_ObjCArrayLiterals_Test8TestBodyEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp -nm=_ZN5clang6format12_GLOBAL__N_133FormatTest_ObjCArrayLiterals_Test8TestBodyEv")
//</editor-fold>
public void test_ObjCArrayLiterals() {
  if (markAsSkippedIfNeed(TestState.Successful)) { return; }
  verifyIncompleteFormat(new StringRef(/*KEEP_STR*/"@["));
  verifyFormat(new StringRef(/*KEEP_STR*/"@[]"));
  verifyFormat(new StringRef(/*KEEP_STR*/"NSArray *array = @[ @\" Hey \", NSApp, [NSNumber numberWithInt:42] ];"));
  verifyFormat(new StringRef(/*KEEP_STR*/"return @[ @3, @[], @[ @4, @5 ] ];"));
  verifyFormat(new StringRef(/*KEEP_STR*/"NSArray *array = @[ [foo description] ];"));
  
  verifyFormat(new StringRef(/*KEEP_STR*/"NSArray *some_variable = @[\n  aaaa == bbbbbbbbbbb ? @\"aaaaaaaaaaaa\" : @\"aaaaaaaaaaaaaa\",\n  @\"aaaaaaaaaaaaaaaaa\",\n  @\"aaaaaaaaaaaaaaaaa\",\n  @\"aaaaaaaaaaaaaaaaa\",\n];"));
  verifyFormat(new StringRef(/*KEEP_STR*/"NSArray *some_variable = @[\n  aaaa == bbbbbbbbbbb ? @\"aaaaaaaaaaaa\" : @\"aaaaaaaaaaaaaa\",\n  @\"aaaaaaaaaaaaaaaa\", @\"aaaaaaaaaaaaaaaa\", @\"aaaaaaaaaaaaaaaa\"\n];"));
  verifyFormat(new StringRef(/*KEEP_STR*/"NSArray *some_variable = @[\n  @\"aaaaaaaaaaaaaaaaa\",\n  @\"aaaaaaaaaaaaaaaaa\",\n  @\"aaaaaaaaaaaaaaaaa\",\n  @\"aaaaaaaaaaaaaaaaa\",\n];"));
  verifyFormat(new StringRef(/*KEEP_STR*/"NSArray *array = @[\n  @\"a\",\n  @\"a\",\n];"));
  
  // We should try to be robust in case someone forgets the "@".
  verifyFormat(new StringRef(/*KEEP_STR*/"NSArray *some_variable = [\n  @\"aaaaaaaaaaaaaaaaa\",\n  @\"aaaaaaaaaaaaaaaaa\",\n  @\"aaaaaaaaaaaaaaaaa\",\n  @\"aaaaaaaaaaaaaaaaa\",\n];"));
  verifyFormat(new StringRef(/*KEEP_STR*/"- (NSAttributedString *)attributedStringForSegment:(NSUInteger)segment\n                                             index:(NSUInteger)index\n                                nonDigitAttributes:\n                                    (NSDictionary *)noDigitAttributes;"));
  verifyFormat(new StringRef(/*KEEP_STR*/"[someFunction someLooooooooooooongParameter:@[\n  NSBundle.mainBundle.infoDictionary[@\"a\"]\n]];"));
}

;
@Test
//<editor-fold defaultstate="collapsed" desc="clang::format::(anonymous namespace)::FormatTest_BreaksStringLiterals_Test::TestBody">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp", line = 7922,
 FQN="clang::format::(anonymous namespace)::FormatTest_BreaksStringLiterals_Test::TestBody", NM="_ZN5clang6format12_GLOBAL__N_136FormatTest_BreaksStringLiterals_Test8TestBodyEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp -nm=_ZN5clang6format12_GLOBAL__N_136FormatTest_BreaksStringLiterals_Test8TestBodyEv")
//</editor-fold>
public void test_BreaksStringLiterals() {
  if (markAsSkippedIfNeed(TestState.Successful)) { return; }
  FormatStyle Style = null;
  FormatStyle AlignLeft = null;
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    EXPECT_EQ("\"some text \"\n\"other\";",$c$.clean(format(new StringRef(/*KEEP_STR*/"\"some text other\";"), $c$.track(getLLVMStyleWithColumns(12)))));
    EXPECT_EQ("\"some text \"\n\"other\";",$c$.clean(format(new StringRef(/*KEEP_STR*/"\\\n\"some text other\";"), $c$.track(getLLVMStyleWithColumns(12)))));
    EXPECT_EQ("#define A  \\\n  \"some \"  \\\n  \"text \"  \\\n  \"other\";",$c$.clean(format(new StringRef(/*KEEP_STR*/"#define A \"some text other\";"), $c$.track(getLLVMStyleWithColumns(12)))));
    EXPECT_EQ("#define A  \\\n  \"so \"    \\\n  \"text \"  \\\n  \"other\";",$c$.clean(format(new StringRef(/*KEEP_STR*/"#define A \"so text other\";"), $c$.track(getLLVMStyleWithColumns(12)))));
    EXPECT_EQ("\"some text\"",$c$.clean(format(new StringRef(/*KEEP_STR*/"\"some text\""), $c$.track(getLLVMStyleWithColumns(1)))));
    EXPECT_EQ("\"some text\"",$c$.clean(format(new StringRef(/*KEEP_STR*/"\"some text\""), $c$.track(getLLVMStyleWithColumns(11)))));
    EXPECT_EQ("\"some \"\n\"text\"",$c$.clean(format(new StringRef(/*KEEP_STR*/"\"some text\""), $c$.track(getLLVMStyleWithColumns(10)))));
    EXPECT_EQ("\"some \"\n\"text\"",$c$.clean(format(new StringRef(/*KEEP_STR*/"\"some text\""), $c$.track(getLLVMStyleWithColumns(7)))));
    EXPECT_EQ("\"some\"\n\" tex\"\n\"t\"",$c$.clean(format(new StringRef(/*KEEP_STR*/"\"some text\""), $c$.track(getLLVMStyleWithColumns(6)))));
    EXPECT_EQ("\"some\"\n\" tex\"\n\" and\"",$c$.clean(format(new StringRef(/*KEEP_STR*/"\"some tex and\""), $c$.track(getLLVMStyleWithColumns(6)))));
    EXPECT_EQ("\"some\"\n\"/tex\"\n\"/and\"",$c$.clean(format(new StringRef(/*KEEP_STR*/"\"some/tex/and\""), $c$.track(getLLVMStyleWithColumns(6)))));
    EXPECT_EQ("variable =\n    \"long string \"\n    \"literal\";",$c$.clean(format(new StringRef(/*KEEP_STR*/"variable = \"long string literal\";"), $c$.track(getLLVMStyleWithColumns(20)))));
    EXPECT_EQ("variable = f(\n    \"long string \"\n    \"literal\",\n    short,\n    loooooooooooooooooooong);",$c$.clean(format(new StringRef(/*KEEP_STR*/"variable = f(\"long string literal\", short, loooooooooooooooooooong);"), $c$.track(getLLVMStyleWithColumns(20)))));
    EXPECT_EQ("f(g(\"long string \"\n    \"literal\"),\n  b);",$c$.clean(format(new StringRef(/*KEEP_STR*/"f(g(\"long string literal\"), b);"), $c$.track(getLLVMStyleWithColumns(20)))));
    EXPECT_EQ("f(g(\"long string \"\n    \"literal\",\n    a),\n  b);",$c$.clean(format(new StringRef(/*KEEP_STR*/"f(g(\"long string literal\", a), b);"), $c$.track(getLLVMStyleWithColumns(20)))));
    EXPECT_EQ("f(\"one two\".split(\n    variable));",$c$.clean(format(new StringRef(/*KEEP_STR*/"f(\"one two\".split(variable));"), $c$.track(getLLVMStyleWithColumns(20)))));
    EXPECT_EQ("f(\"one two three four five six \"\n  \"seven\".split(\n      really_looooong_variable));",$c$.clean(format(new StringRef(/*KEEP_STR*/"f(\"one two three four five six seven\".split(really_looooong_variable));"), $c$.track(getLLVMStyleWithColumns(33)))));
    EXPECT_EQ("f(\"some \"\n  \"text\",\n  other);",$c$.clean(format(new StringRef(/*KEEP_STR*/"f(\"some text\", other);"), $c$.track(getLLVMStyleWithColumns(10)))));
    
    // Only break as a last resort.
    verifyFormat(new StringRef(/*KEEP_STR*/"aaaaaaaaaaaaaaaaaaaa(\n    aaaaaaaaaaaaaaaaaaaa,\n    aaaaaa(\"aaa aaaaa aaa aaa aaaaa aaa aaaaa aaa aaa aaaaaa\"));"));
    EXPECT_EQ("\"splitmea\"\n\"trandomp\"\n\"oint\"",$c$.clean(format(new StringRef(/*KEEP_STR*/"\"splitmeatrandompoint\""), $c$.track(getLLVMStyleWithColumns(10)))));
    EXPECT_EQ("\"split/\"\n\"pathat/\"\n\"slashes\"",$c$.clean(format(new StringRef(/*KEEP_STR*/"\"split/pathat/slashes\""), $c$.track(getLLVMStyleWithColumns(10)))));
    EXPECT_EQ("\"split/\"\n\"pathat/\"\n\"slashes\"",$c$.clean(format(new StringRef(/*KEEP_STR*/"\"split/pathat/slashes\""), $c$.track(getLLVMStyleWithColumns(10)))));
    EXPECT_EQ("\"split at \"\n\"spaces/at/\"\n\"slashes.at.any$\"\n\"non-alphanumeric%\"\n\"1111111111characte\"\n\"rs\"",$c$.clean(format(new StringRef(/*KEEP_STR*/"\"split at spaces/at/slashes.at.any$non-alphanumeric%1111111111characters\""), $c$.track(getLLVMStyleWithColumns(20)))));
    
    // Verify that splitting the strings understands
    // Style::AlwaysBreakBeforeMultilineStrings.
    EXPECT_EQ("aaaaaaaaaaaa(\n    \"aaaaaaaaaaaaaaaaaaaaaaaaaa aaaaaaaaaaaaaaaaaaaaaa \"\n    \"aaaaaaaaaaaaaaaaaaaaaaaaaa aaaaaaaaaaaaaaaaaaaaaa\");",$c$.clean(format(new StringRef(/*KEEP_STR*/"aaaaaaaaaaaa(\"aaaaaaaaaaaaaaaaaaaaaaaaaa aaaaaaaaaaaaaaaaaaaaaa aaaaaaaaaaaaaaaaaaaaaaaaaa aaaaaaaaaaaaaaaaaaaaaa\");"), $c$.track(getGoogleStyle()))));
    EXPECT_EQ("return \"aaaaaaaaaaaaaaaaaaaaaa aaaaaaaaaaaaaaaaaaaaaaaaaa \"\n       \"aaaaaaaaaaaaaaaaaaaaaaaaaa aaaaaaaaaaaaaaaaaaaaaa\";",$c$.clean(format(new StringRef(/*KEEP_STR*/"return \"aaaaaaaaaaaaaaaaaaaaaa aaaaaaaaaaaaaaaaaaaaaaaaaa aaaaaaaaaaaaaaaaaaaaaaaaaa aaaaaaaaaaaaaaaaaaaaaa\";"), $c$.track(getGoogleStyle()))));
    EXPECT_EQ("llvm::outs() << \"aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa \"\n                \"aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa\";",format(new StringRef(/*KEEP_STR*/"llvm::outs() << \"aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa\";")));
    EXPECT_EQ("ffff(\n    {\"aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa \"\n     \"aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa\"});",$c$.clean(format(new StringRef(/*KEEP_STR*/"ffff({\"aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa\"});"), $c$.track(getGoogleStyle()))));
    
    Style = getLLVMStyleWithColumns(12);
    Style.BreakStringLiterals = false;
    EXPECT_EQ("\"some text other\";",format(new StringRef(/*KEEP_STR*/"\"some text other\";"), Style));
    
    AlignLeft = getLLVMStyleWithColumns(12);
    AlignLeft.AlignEscapedNewlinesLeft = true;
    EXPECT_EQ("#define A \\\n  \"some \" \\\n  \"text \" \\\n  \"other\";",format(new StringRef(/*KEEP_STR*/"#define A \"some text other\";"), AlignLeft));
  } finally {
    if (AlignLeft != null) { AlignLeft.$destroy(); }
    if (Style != null) { Style.$destroy(); }
    $c$.$destroy();
  }
}

;
@Test
//<editor-fold defaultstate="collapsed" desc="clang::format::(anonymous namespace)::FormatTest_FullyRemoveEmptyLines_Test::TestBody">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp", line = 8083,
 FQN="clang::format::(anonymous namespace)::FormatTest_FullyRemoveEmptyLines_Test::TestBody", NM="_ZN5clang6format12_GLOBAL__N_137FormatTest_FullyRemoveEmptyLines_Test8TestBodyEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp -nm=_ZN5clang6format12_GLOBAL__N_137FormatTest_FullyRemoveEmptyLines_Test8TestBodyEv")
//</editor-fold>
public void test_FullyRemoveEmptyLines() {
  if (markAsSkippedIfNeed(TestState.Successful)) { return; }
  FormatStyle NoEmptyLines = null;
  try {
    NoEmptyLines = getLLVMStyleWithColumns(80);
    NoEmptyLines.MaxEmptyLinesToKeep = 0;
    EXPECT_EQ("int i = a(b());",format(new StringRef(/*KEEP_STR*/"int i=a(\n\n b(\n\n\n )\n\n);"), NoEmptyLines));
  } finally {
    if (NoEmptyLines != null) { NoEmptyLines.$destroy(); }
  }
}

;
@Test
//<editor-fold defaultstate="collapsed" desc="clang::format::(anonymous namespace)::FormatTest_BreaksStringLiteralsWithTabs_Test::TestBody">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp", line = 8090,
 FQN="clang::format::(anonymous namespace)::FormatTest_BreaksStringLiteralsWithTabs_Test::TestBody", NM="_ZN5clang6format12_GLOBAL__N_144FormatTest_BreaksStringLiteralsWithTabs_Test8TestBodyEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp -nm=_ZN5clang6format12_GLOBAL__N_144FormatTest_BreaksStringLiteralsWithTabs_Test8TestBodyEv")
//</editor-fold>
public void test_BreaksStringLiteralsWithTabs() {
  if (markAsSkippedIfNeed(TestState.Successful)) { return; }
    EXPECT_EQ("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa(\n    \"x\t\");",format(new StringRef(/*KEEP_STR*/"aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa(\"x\t\");")));
}

;
@Test
//<editor-fold defaultstate="collapsed" desc="clang::format::(anonymous namespace)::FormatTest_BreaksWideAndNSStringLiterals_Test::TestBody">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp", line = 8100,
 FQN="clang::format::(anonymous namespace)::FormatTest_BreaksWideAndNSStringLiterals_Test::TestBody", NM="_ZN5clang6format12_GLOBAL__N_145FormatTest_BreaksWideAndNSStringLiterals_Test8TestBodyEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp -nm=_ZN5clang6format12_GLOBAL__N_145FormatTest_BreaksWideAndNSStringLiterals_Test8TestBodyEv")
//</editor-fold>
public void test_BreaksWideAndNSStringLiterals() {
  if (markAsSkippedIfNeed(TestState.Successful)) { return; }
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    EXPECT_EQ("u8\"utf8 string \"\nu8\"literal\";",$c$.clean(format(new StringRef(/*KEEP_STR*/"u8\"utf8 string literal\";"), $c$.track(getGoogleStyleWithColumns(16)))));
    EXPECT_EQ("u\"utf16 string \"\nu\"literal\";",$c$.clean(format(new StringRef(/*KEEP_STR*/"u\"utf16 string literal\";"), $c$.track(getGoogleStyleWithColumns(16)))));
    EXPECT_EQ("U\"utf32 string \"\nU\"literal\";",$c$.clean(format(new StringRef(/*KEEP_STR*/"U\"utf32 string literal\";"), $c$.track(getGoogleStyleWithColumns(16)))));
    EXPECT_EQ("L\"wide string \"\nL\"literal\";",$c$.clean(format(new StringRef(/*KEEP_STR*/"L\"wide string literal\";"), $c$.track(getGoogleStyleWithColumns(16)))));
    EXPECT_EQ("@\"NSString \"\n@\"literal\";",$c$.clean(format(new StringRef(/*KEEP_STR*/"@\"NSString literal\";"), $c$.track(getGoogleStyleWithColumns(19)))));
    
    // This input makes clang-format try to split the incomplete unicode escape
    // sequence, which used to lead to a crasher.
    verifyNoCrash(new StringRef(/*KEEP_STR*/"aaaaaaaaaaaaaaaaaaaa = L\"\\udff\"'; // aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"), 
        $c$.track(getLLVMStyleWithColumns(60))); $c$.clean();
  } finally {
    $c$.$destroy();
  }
}

;
@Test
//<editor-fold defaultstate="collapsed" desc="clang::format::(anonymous namespace)::FormatTest_DoesNotBreakRawStringLiterals_Test::TestBody">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp", line = 8127,
 FQN="clang::format::(anonymous namespace)::FormatTest_DoesNotBreakRawStringLiterals_Test::TestBody", NM="_ZN5clang6format12_GLOBAL__N_145FormatTest_DoesNotBreakRawStringLiterals_Test8TestBodyEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp -nm=_ZN5clang6format12_GLOBAL__N_145FormatTest_DoesNotBreakRawStringLiterals_Test8TestBodyEv")
//</editor-fold>
public void test_DoesNotBreakRawStringLiterals() {
  if (markAsSkippedIfNeed(TestState.Successful)) { return; }
  FormatStyle Style = null;
  try {
    Style = getGoogleStyleWithColumns(15);
    EXPECT_EQ("R\"x(raw literal)x\";",format(new StringRef(/*KEEP_STR*/"R\"x(raw literal)x\";"), Style));
    EXPECT_EQ("uR\"x(raw literal)x\";",format(new StringRef(/*KEEP_STR*/"uR\"x(raw literal)x\";"), Style));
    EXPECT_EQ("LR\"x(raw literal)x\";",format(new StringRef(/*KEEP_STR*/"LR\"x(raw literal)x\";"), Style));
    EXPECT_EQ("UR\"x(raw literal)x\";",format(new StringRef(/*KEEP_STR*/"UR\"x(raw literal)x\";"), Style));
    EXPECT_EQ("u8R\"x(raw literal)x\";",format(new StringRef(/*KEEP_STR*/"u8R\"x(raw literal)x\";"), Style));
  } finally {
    if (Style != null) { Style.$destroy(); }
  }
}

;
@Test
//<editor-fold defaultstate="collapsed" desc="clang::format::(anonymous namespace)::FormatTest_BreaksStringLiteralsWithin_TMacro_Test::TestBody">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp", line = 8137,
 FQN="clang::format::(anonymous namespace)::FormatTest_BreaksStringLiteralsWithin_TMacro_Test::TestBody", NM="_ZN5clang6format12_GLOBAL__N_149FormatTest_BreaksStringLiteralsWithin_TMacro_Test8TestBodyEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp -nm=_ZN5clang6format12_GLOBAL__N_149FormatTest_BreaksStringLiteralsWithin_TMacro_Test8TestBodyEv")
//</editor-fold>
public void test_BreaksStringLiteralsWithin_TMacro() {
  if (markAsSkippedIfNeed(TestState.Successful)) { return; }
  FormatStyle Style = null;
  try {
    Style = getLLVMStyleWithColumns(20);
    EXPECT_EQ("_T(\"aaaaaaaaaaaaaa\")\n_T(\"aaaaaaaaaaaaaa\")\n_T(\"aaaaaaaaaaaa\")",format(new StringRef(/*KEEP_STR*/"  _T(\"aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa\")"), Style));
    EXPECT_EQ("f(x, _T(\"aaaaaaaaa\")\n     _T(\"aaaaaa\"),\n  z);",format(new StringRef(/*KEEP_STR*/"f(x, _T(\"aaaaaaaaaaaaaaa\"), z);"), Style));
    
    // FIXME: Handle embedded spaces in one iteration.
    //  EXPECT_EQ("_T(\"aaaaaaaaaaaaa\")\n"
    //            "_T(\"aaaaaaaaaaaaa\")\n"
    //            "_T(\"aaaaaaaaaaaaa\")\n"
    //            "_T(\"a\")",
    //            format("  _T ( \"aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa\" )",
    //                   getLLVMStyleWithColumns(20)));
    EXPECT_EQ("_T ( \"aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa\" )",format(new StringRef(/*KEEP_STR*/"  _T ( \"aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa\" )"), Style));
    EXPECT_EQ("f(\n#if !TEST\n    _T(\"XXXXXXXXXXXXXXXXXXXXXXXXXXXXXn\")\n#endif\n    );",format(new StringRef(/*KEEP_STR*/"f(\n#if !TEST\n_T(\"XXXXXXXXXXXXXXXXXXXXXXXXXXXXXn\")\n#endif\n);")));
    EXPECT_EQ("f(\n\n    _T(\"XXXXXXXXXXXXXXXXXXXXXXXXXXXXXn\"));",format(new StringRef(/*KEEP_STR*/"f(\n\n_T(\"XXXXXXXXXXXXXXXXXXXXXXXXXXXXXn\"));")));
  } finally {
    if (Style != null) { Style.$destroy(); }
  }
}

;
@Test
//<editor-fold defaultstate="collapsed" desc="clang::format::(anonymous namespace)::FormatTest_DontSplitStringLiteralsWithEscapedNewlines_Test::TestBody">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp", line = 8177,
 FQN="clang::format::(anonymous namespace)::FormatTest_DontSplitStringLiteralsWithEscapedNewlines_Test::TestBody", NM="_ZN5clang6format12_GLOBAL__N_158FormatTest_DontSplitStringLiteralsWithEscapedNewlines_Test8TestBodyEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp -nm=_ZN5clang6format12_GLOBAL__N_158FormatTest_DontSplitStringLiteralsWithEscapedNewlines_Test8TestBodyEv")
//</editor-fold>
public void test_DontSplitStringLiteralsWithEscapedNewlines() {
  if (markAsSkippedIfNeed(TestState.Successful)) { return; }
    EXPECT_EQ("aaaaaaaaaaa = \"aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa\\\n  aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa\\\n  aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa\";",format(new StringRef(/*KEEP_STR*/"aaaaaaaaaaa  =  \"aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa\\\n  aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa\\\n  aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa\";")));
}

;
@Test
//<editor-fold defaultstate="collapsed" desc="clang::format::(anonymous namespace)::FormatTest_CountsCharactersInMultilineRawStringLiterals_Test::TestBody">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp", line = 8187,
 FQN="clang::format::(anonymous namespace)::FormatTest_CountsCharactersInMultilineRawStringLiterals_Test::TestBody", NM="_ZN5clang6format12_GLOBAL__N_160FormatTest_CountsCharactersInMultilineRawStringLiterals_Test8TestBodyEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp -nm=_ZN5clang6format12_GLOBAL__N_160FormatTest_CountsCharactersInMultilineRawStringLiterals_Test8TestBodyEv")
//</editor-fold>
public void test_CountsCharactersInMultilineRawStringLiterals() {
  if (markAsSkippedIfNeed(TestState.Successful)) { return; }
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    EXPECT_EQ("f(g(R\"x(raw literal)x\", a), b);",$c$.clean(format(new StringRef(/*KEEP_STR*/"f(g(R\"x(raw literal)x\",   a), b);"), $c$.track(getGoogleStyle()))));
    EXPECT_EQ("fffffffffff(g(R\"x(\nmultiline raw string literal xxxxxxxxxxxxxx\n)x\",\n              a),\n            b);",$c$.clean(format(new StringRef(/*KEEP_STR*/"fffffffffff(g(R\"x(\nmultiline raw string literal xxxxxxxxxxxxxx\n)x\", a), b);"), $c$.track(getGoogleStyleWithColumns(20)))));
    EXPECT_EQ("fffffffffff(\n    g(R\"x(qqq\nmultiline raw string literal xxxxxxxxxxxxxx\n)x\",\n      a),\n    b);",$c$.clean(format(new StringRef(/*KEEP_STR*/"fffffffffff(g(R\"x(qqq\nmultiline raw string literal xxxxxxxxxxxxxx\n)x\", a), b);"), $c$.track(getGoogleStyleWithColumns(20)))));
    EXPECT_EQ("fffffffffff(R\"x(\nmultiline raw string literal xxxxxxxxxxxxxx\n)x\");",$c$.clean(format(new StringRef(/*KEEP_STR*/"fffffffffff(R\"x(\nmultiline raw string literal xxxxxxxxxxxxxx\n)x\");"), $c$.track(getGoogleStyleWithColumns(20)))));
    EXPECT_EQ("fffffffffff(R\"x(\nmultiline raw string literal xxxxxxxxxxxxxx\n)x\" + bbbbbb);",$c$.clean(format(new StringRef(/*KEEP_STR*/"fffffffffff(R\"x(\nmultiline raw string literal xxxxxxxxxxxxxx\n)x\" +   bbbbbb);"), $c$.track(getGoogleStyleWithColumns(20)))));
    EXPECT_EQ("fffffffffff(\n    R\"x(\nmultiline raw string literal xxxxxxxxxxxxxx\n)x\" +\n    bbbbbb);",$c$.clean(format(new StringRef(/*KEEP_STR*/"fffffffffff(\n R\"x(\nmultiline raw string literal xxxxxxxxxxxxxx\n)x\" + bbbbbb);"), $c$.track(getGoogleStyleWithColumns(20)))));
  } finally {
    $c$.$destroy();
  }
}

;
@Test
//<editor-fold defaultstate="collapsed" desc="clang::format::(anonymous namespace)::FormatTest_SkipsUnknownStringLiterals_Test::TestBody">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp", line = 8236,
 FQN="clang::format::(anonymous namespace)::FormatTest_SkipsUnknownStringLiterals_Test::TestBody", NM="_ZN5clang6format12_GLOBAL__N_142FormatTest_SkipsUnknownStringLiterals_Test8TestBodyEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp -nm=_ZN5clang6format12_GLOBAL__N_142FormatTest_SkipsUnknownStringLiterals_Test8TestBodyEv")
//</editor-fold>
public void test_SkipsUnknownStringLiterals() {
  if (markAsSkippedIfNeed(TestState.Successful)) { return; }
  verifyFormat(new StringRef(/*KEEP_STR*/"string a = \"unterminated;"));
  EXPECT_EQ("function(\"unterminated,\n         OtherParameter);",format(new StringRef(/*KEEP_STR*/"function(  \"unterminated,\n    OtherParameter);")));
}

;
@Test
//<editor-fold defaultstate="collapsed" desc="clang::format::(anonymous namespace)::FormatTest_DoesNotTryToParseUDLiteralsInPreCpp11Code_Test::TestBody">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp", line = 8244,
 FQN="clang::format::(anonymous namespace)::FormatTest_DoesNotTryToParseUDLiteralsInPreCpp11Code_Test::TestBody", NM="_ZN5clang6format12_GLOBAL__N_157FormatTest_DoesNotTryToParseUDLiteralsInPreCpp11Code_Test8TestBodyEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp -nm=_ZN5clang6format12_GLOBAL__N_157FormatTest_DoesNotTryToParseUDLiteralsInPreCpp11Code_Test8TestBodyEv")
//</editor-fold>
public void test_DoesNotTryToParseUDLiteralsInPreCpp11Code() {
  if (markAsSkippedIfNeed(TestState.Successful)) { return; }
  FormatStyle Style = null;
  try {
    Style = getLLVMStyle();
    Style.Standard = FormatStyle.LanguageStandard.LS_Cpp03;
    EXPECT_EQ("#define x(_a) printf(\"foo\" _a);",format(new StringRef(/*KEEP_STR*/"#define x(_a) printf(\"foo\"_a);"), Style));
  } finally {
    if (Style != null) { Style.$destroy(); }
  }
}

;
@Test
//<editor-fold defaultstate="collapsed" desc="clang::format::(anonymous namespace)::FormatTest_UnderstandsCpp1y_Test::TestBody">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp", line = 8251,
 FQN="clang::format::(anonymous namespace)::FormatTest_UnderstandsCpp1y_Test::TestBody", NM="_ZN5clang6format12_GLOBAL__N_132FormatTest_UnderstandsCpp1y_Test8TestBodyEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp -nm=_ZN5clang6format12_GLOBAL__N_132FormatTest_UnderstandsCpp1y_Test8TestBodyEv")
//</editor-fold>
public void test_UnderstandsCpp1y() {
  if (markAsSkippedIfNeed(TestState.Successful)) { return; }
  verifyFormat(new StringRef(/*KEEP_STR*/"int bi{1'000'000};"));
}

;
@Test
//<editor-fold defaultstate="collapsed" desc="clang::format::(anonymous namespace)::FormatTest_BreakStringLiteralsBeforeUnbreakableTokenSequence_Test::TestBody">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp", line = 8253,
 FQN="clang::format::(anonymous namespace)::FormatTest_BreakStringLiteralsBeforeUnbreakableTokenSequence_Test::TestBody", NM="_ZN5clang6format12_GLOBAL__N_165FormatTest_BreakStringLiteralsBeforeUnbreakableTokenSequence_Test8TestBodyEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp -nm=_ZN5clang6format12_GLOBAL__N_165FormatTest_BreakStringLiteralsBeforeUnbreakableTokenSequence_Test8TestBodyEv")
//</editor-fold>
public void test_BreakStringLiteralsBeforeUnbreakableTokenSequence() {
  if (markAsSkippedIfNeed(TestState.Successful)) { return; }
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    EXPECT_EQ("someFunction(\"aaabbbcccd\"\n             \"ddeeefff\");",$c$.clean(format(new StringRef(/*KEEP_STR*/"someFunction(\"aaabbbcccdddeeefff\");"), $c$.track(getLLVMStyleWithColumns(25)))));
    EXPECT_EQ("someFunction1234567890(\n    \"aaabbbcccdddeeefff\");",$c$.clean(format(new StringRef(/*KEEP_STR*/"someFunction1234567890(\"aaabbbcccdddeeefff\");"), $c$.track(getLLVMStyleWithColumns(26)))));
    EXPECT_EQ("someFunction1234567890(\n    \"aaabbbcccdddeeeff\"\n    \"f\");",$c$.clean(format(new StringRef(/*KEEP_STR*/"someFunction1234567890(\"aaabbbcccdddeeefff\");"), $c$.track(getLLVMStyleWithColumns(25)))));
    EXPECT_EQ("someFunction1234567890(\n    \"aaabbbcccdddeeeff\"\n    \"f\");",$c$.clean(format(new StringRef(/*KEEP_STR*/"someFunction1234567890(\"aaabbbcccdddeeefff\");"), $c$.track(getLLVMStyleWithColumns(24)))));
    EXPECT_EQ("someFunction(\"aaabbbcc \"\n             \"ddde \"\n             \"efff\");",$c$.clean(format(new StringRef(/*KEEP_STR*/"someFunction(\"aaabbbcc ddde efff\");"), $c$.track(getLLVMStyleWithColumns(25)))));
    EXPECT_EQ("someFunction(\"aaabbbccc \"\n             \"ddeeefff\");",$c$.clean(format(new StringRef(/*KEEP_STR*/"someFunction(\"aaabbbccc ddeeefff\");"), $c$.track(getLLVMStyleWithColumns(25)))));
    EXPECT_EQ("someFunction1234567890(\n    \"aaabb \"\n    \"cccdddeeefff\");",$c$.clean(format(new StringRef(/*KEEP_STR*/"someFunction1234567890(\"aaabb cccdddeeefff\");"), $c$.track(getLLVMStyleWithColumns(25)))));
    EXPECT_EQ("#define A          \\\n  string s =       \\\n      \"123456789\"  \\\n      \"0\";         \\\n  int i;",$c$.clean(format(new StringRef(/*KEEP_STR*/"#define A string s = \"1234567890\"; int i;"), $c$.track(getLLVMStyleWithColumns(20)))));
    // FIXME: Put additional penalties on breaking at non-whitespace locations.
    EXPECT_EQ("someFunction(\"aaabbbcc \"\n             \"dddeeeff\"\n             \"f\");",$c$.clean(format(new StringRef(/*KEEP_STR*/"someFunction(\"aaabbbcc dddeeefff\");"), $c$.track(getLLVMStyleWithColumns(25)))));
  } finally {
    $c$.$destroy();
  }
}

;
@Test
//<editor-fold defaultstate="collapsed" desc="clang::format::(anonymous namespace)::FormatTest_DoNotBreakStringLiteralsInEscapeSequence_Test::TestBody">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp", line = 8301,
 FQN="clang::format::(anonymous namespace)::FormatTest_DoNotBreakStringLiteralsInEscapeSequence_Test::TestBody", NM="_ZN5clang6format12_GLOBAL__N_156FormatTest_DoNotBreakStringLiteralsInEscapeSequence_Test8TestBodyEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp -nm=_ZN5clang6format12_GLOBAL__N_156FormatTest_DoNotBreakStringLiteralsInEscapeSequence_Test8TestBodyEv")
//</editor-fold>
public void test_DoNotBreakStringLiteralsInEscapeSequence() {
  if (markAsSkippedIfNeed(TestState.Successful)) { return; }
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    EXPECT_EQ("\"\\a\"",$c$.clean(format(new StringRef(/*KEEP_STR*/"\"\\a\""), $c$.track(getLLVMStyleWithColumns(3)))));
    EXPECT_EQ("\"\\\"",$c$.clean(format(new StringRef(/*KEEP_STR*/"\"\\\""), $c$.track(getLLVMStyleWithColumns(2)))));
    EXPECT_EQ("\"test\"\n\"\\n\"",$c$.clean(format(new StringRef(/*KEEP_STR*/"\"test\\n\""), $c$.track(getLLVMStyleWithColumns(7)))));
    EXPECT_EQ("\"tes\\\\\"\n\"n\"",$c$.clean(format(new StringRef(/*KEEP_STR*/"\"tes\\\\n\""), $c$.track(getLLVMStyleWithColumns(7)))));
    EXPECT_EQ("\"\\\\\\\\\"\n\"\\n\"",$c$.clean(format(new StringRef(/*KEEP_STR*/"\"\\\\\\\\\\n\""), $c$.track(getLLVMStyleWithColumns(7)))));
    EXPECT_EQ("\"\\uff01\"",$c$.clean(format(new StringRef(/*KEEP_STR*/"\"\\uff01\""), $c$.track(getLLVMStyleWithColumns(7)))));
    EXPECT_EQ("\"\\uff01\"\n\"test\"",$c$.clean(format(new StringRef(/*KEEP_STR*/"\"\\uff01test\""), $c$.track(getLLVMStyleWithColumns(8)))));
    EXPECT_EQ("\"\\Uff01ff02\"",$c$.clean(format(new StringRef(/*KEEP_STR*/"\"\\Uff01ff02\""), $c$.track(getLLVMStyleWithColumns(11)))));
    EXPECT_EQ("\"\\x000000000001\"\n\"next\"",$c$.clean(format(new StringRef(/*KEEP_STR*/"\"\\x000000000001next\""), $c$.track(getLLVMStyleWithColumns(16)))));
    EXPECT_EQ("\"\\x000000000001next\"",$c$.clean(format(new StringRef(/*KEEP_STR*/"\"\\x000000000001next\""), $c$.track(getLLVMStyleWithColumns(15)))));
    EXPECT_EQ("\"\\x000000000001\"",$c$.clean(format(new StringRef(/*KEEP_STR*/"\"\\x000000000001\""), $c$.track(getLLVMStyleWithColumns(7)))));
    EXPECT_EQ("\"test\"\n\"\\000000\"\n\"000001\"",$c$.clean(format(new StringRef(/*KEEP_STR*/"\"test\\000000000001\""), $c$.track(getLLVMStyleWithColumns(9)))));
    EXPECT_EQ("\"test\\000\"\n\"00000000\"\n\"1\"",$c$.clean(format(new StringRef(/*KEEP_STR*/"\"test\\000000000001\""), $c$.track(getLLVMStyleWithColumns(10)))));
  } finally {
    $c$.$destroy();
  }
}

;
@Test
//<editor-fold defaultstate="collapsed" desc="clang::format::(anonymous namespace)::FormatTest_DoNotCreateUnreasonableUnwrappedLines_Test::TestBody">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp", line = 8336,
 FQN="clang::format::(anonymous namespace)::FormatTest_DoNotCreateUnreasonableUnwrappedLines_Test::TestBody", NM="_ZN5clang6format12_GLOBAL__N_153FormatTest_DoNotCreateUnreasonableUnwrappedLines_Test8TestBodyEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp -nm=_ZN5clang6format12_GLOBAL__N_153FormatTest_DoNotCreateUnreasonableUnwrappedLines_Test8TestBodyEv")
//</editor-fold>
public void test_DoNotCreateUnreasonableUnwrappedLines() {
  if (markAsSkippedIfNeed(TestState.Successful)) { return; }
  verifyFormat(new StringRef(/*KEEP_STR*/"void f() {\n  return g() {}\n  void h() {}"));
  verifyFormat(new StringRef(/*KEEP_STR*/"int a[] = {void forgot_closing_brace(){f();\ng();\n}"));
}

;
@Test
//<editor-fold defaultstate="collapsed" desc="clang::format::(anonymous namespace)::FormatTest_DoNotPrematurelyEndUnwrappedLineForReturnStatements_Test::TestBody">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp", line = 8345,
 FQN="clang::format::(anonymous namespace)::FormatTest_DoNotPrematurelyEndUnwrappedLineForReturnStatements_Test::TestBody", NM="_ZN5clang6format12_GLOBAL__N_167FormatTest_DoNotPrematurelyEndUnwrappedLineForReturnStatements_Test8TestBodyEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp -nm=_ZN5clang6format12_GLOBAL__N_167FormatTest_DoNotPrematurelyEndUnwrappedLineForReturnStatements_Test8TestBodyEv")
//</editor-fold>
public void test_DoNotPrematurelyEndUnwrappedLineForReturnStatements() {
  if (markAsSkippedIfNeed(TestState.Successful)) { return; }
  verifyFormat(new StringRef(/*KEEP_STR*/"void f() { return C{param1, param2}.SomeCall(param1, param2); }"));
}

;
@Test
//<editor-fold defaultstate="collapsed" desc="clang::format::(anonymous namespace)::FormatTest_FormatsClosingBracesInEmptyNestedBlocks_Test::TestBody">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp", line = 8350,
 FQN="clang::format::(anonymous namespace)::FormatTest_FormatsClosingBracesInEmptyNestedBlocks_Test::TestBody", NM="_ZN5clang6format12_GLOBAL__N_155FormatTest_FormatsClosingBracesInEmptyNestedBlocks_Test8TestBodyEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp -nm=_ZN5clang6format12_GLOBAL__N_155FormatTest_FormatsClosingBracesInEmptyNestedBlocks_Test8TestBodyEv")
//</editor-fold>
public void test_FormatsClosingBracesInEmptyNestedBlocks() {
  if (markAsSkippedIfNeed(TestState.Successful)) { return; }
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    verifyFormat(new StringRef(/*KEEP_STR*/"class X {\n  void f() {\n  }\n};"), 
        $c$.track(getLLVMStyleWithColumns(12))); $c$.clean();
  } finally {
    $c$.$destroy();
  }
}

;
@Test
//<editor-fold defaultstate="collapsed" desc="clang::format::(anonymous namespace)::FormatTest_ConfigurableIndentWidth_Test::TestBody">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp", line = 8358,
 FQN="clang::format::(anonymous namespace)::FormatTest_ConfigurableIndentWidth_Test::TestBody", NM="_ZN5clang6format12_GLOBAL__N_139FormatTest_ConfigurableIndentWidth_Test8TestBodyEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp -nm=_ZN5clang6format12_GLOBAL__N_139FormatTest_ConfigurableIndentWidth_Test8TestBodyEv")
//</editor-fold>
public void test_ConfigurableIndentWidth() {
  if (markAsSkippedIfNeed(TestState.Successful)) { return; }
  FormatStyle EightIndent = null;
  try {
    EightIndent = getLLVMStyleWithColumns(18);
    EightIndent.IndentWidth = 8;
    EightIndent.ContinuationIndentWidth = 8;
    verifyFormat(new StringRef(/*KEEP_STR*/"void f() {\n        someFunction();\n        if (true) {\n                f();\n        }\n}"), 
        EightIndent);
    verifyFormat(new StringRef(/*KEEP_STR*/"class X {\n        void f() {\n        }\n};"), 
        EightIndent);
    verifyFormat(new StringRef(/*KEEP_STR*/"int x[] = {\n        call(),\n        call()};"), 
        EightIndent);
  } finally {
    if (EightIndent != null) { EightIndent.$destroy(); }
  }
}

;
@Test
//<editor-fold defaultstate="collapsed" desc="clang::format::(anonymous namespace)::FormatTest_ConfigurableFunctionDeclarationIndentAfterType_Test::TestBody">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp", line = 8380,
 FQN="clang::format::(anonymous namespace)::FormatTest_ConfigurableFunctionDeclarationIndentAfterType_Test::TestBody", NM="_ZN5clang6format12_GLOBAL__N_162FormatTest_ConfigurableFunctionDeclarationIndentAfterType_Test8TestBodyEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp -nm=_ZN5clang6format12_GLOBAL__N_162FormatTest_ConfigurableFunctionDeclarationIndentAfterType_Test8TestBodyEv")
//</editor-fold>
public void test_ConfigurableFunctionDeclarationIndentAfterType() {
  if (markAsSkippedIfNeed(TestState.Successful)) { return; }
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    verifyFormat(new StringRef(/*KEEP_STR*/"double\nf();"), 
        $c$.track(getLLVMStyleWithColumns(8))); $c$.clean();
  } finally {
    $c$.$destroy();
  }
}

;
@Test
//<editor-fold defaultstate="collapsed" desc="clang::format::(anonymous namespace)::FormatTest_ConfigurableUseOfTab_Test::TestBody">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp", line = 8386,
 FQN="clang::format::(anonymous namespace)::FormatTest_ConfigurableUseOfTab_Test::TestBody", NM="_ZN5clang6format12_GLOBAL__N_136FormatTest_ConfigurableUseOfTab_Test8TestBodyEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp -nm=_ZN5clang6format12_GLOBAL__N_136FormatTest_ConfigurableUseOfTab_Test8TestBodyEv")
//</editor-fold>
public void test_ConfigurableUseOfTab() {
  if (markAsSkippedIfNeed(TestState.Successful)) { return; }
  FormatStyle Tab = null;
  try {
    Tab = getLLVMStyleWithColumns(42);
    Tab.IndentWidth = 8;
    Tab.UseTab = FormatStyle.UseTabStyle.UT_Always;
    Tab.AlignEscapedNewlinesLeft = true;
    EXPECT_EQ("if (aaaaaaaa && // q\n    bb)\t\t// w\n\t;",format(new StringRef(/*KEEP_STR*/"if (aaaaaaaa &&// q\nbb)// w\n;"), Tab));
    EXPECT_EQ("if (aaa && bbb) // w\n\t;",format(new StringRef(/*KEEP_STR*/"if(aaa&&bbb)// w\n;"), Tab));
    
    verifyFormat(new StringRef(/*KEEP_STR*/"class X {\n\tvoid f() {\n\t\tsomeFunction(parameter1,\n\t\t\t     parameter2);\n\t}\n};"), 
        Tab);
    verifyFormat(new StringRef(/*KEEP_STR*/"#define A                        \\\n\tvoid f() {               \\\n\t\tsomeFunction(    \\\n\t\t    parameter1,  \\\n\t\t    parameter2); \\\n\t}"), 
        Tab);
    
    Tab.TabWidth = 4;
    Tab.IndentWidth = 8;
    verifyFormat(new StringRef(/*KEEP_STR*/"class TabWidth4Indent8 {\n\t\tvoid f() {\n\t\t\t\tsomeFunction(parameter1,\n\t\t\t\t\t\t\t parameter2);\n\t\t}\n};"), 
        Tab);
    
    Tab.TabWidth = 4;
    Tab.IndentWidth = 4;
    verifyFormat(new StringRef(/*KEEP_STR*/"class TabWidth4Indent4 {\n\tvoid f() {\n\t\tsomeFunction(parameter1,\n\t\t\t\t\t parameter2);\n\t}\n};"), 
        Tab);
    
    Tab.TabWidth = 8;
    Tab.IndentWidth = 4;
    verifyFormat(new StringRef(/*KEEP_STR*/"class TabWidth8Indent4 {\n    void f() {\n\tsomeFunction(parameter1,\n\t\t     parameter2);\n    }\n};"), 
        Tab);
    
    Tab.TabWidth = 8;
    Tab.IndentWidth = 8;
    EXPECT_EQ("/*\n\t      a\t\tcomment\n\t      in multiple lines\n       */",format(new StringRef(/*KEEP_STR*/"   /*\t \t \n \t \t a\t\tcomment\t \t\n \t \t in multiple lines\t\n \t  */"), Tab));
    
    Tab.UseTab = FormatStyle.UseTabStyle.UT_ForIndentation;
    verifyFormat(new StringRef(/*KEEP_STR*/"{\n\taaaaaaaaaaaaaaaaaaaaaaaaaaaa();\n\taaaaaaaaaaaaaaaaaaaaaaaaaaaa();\n\taaaaaaaaaaaaaaaaaaaaaaaaaaaa();\n\taaaaaaaaaaaaaaaaaaaaaaaaaaaa();\n\taaaaaaaaaaaaaaaaaaaaaaaaaaaa();\n\taaaaaaaaaaaaaaaaaaaaaaaaaaaa();\n};"), 
        Tab);
    verifyFormat(new StringRef(/*KEEP_STR*/"enum AA {\n\ta1, // Force multiple lines\n\ta2,\n\ta3\n};"), 
        Tab);
    EXPECT_EQ("if (aaaaaaaa && // q\n    bb)         // w\n\t;",format(new StringRef(/*KEEP_STR*/"if (aaaaaaaa &&// q\nbb)// w\n;"), Tab));
    verifyFormat(new StringRef(/*KEEP_STR*/"class X {\n\tvoid f() {\n\t\tsomeFunction(parameter1,\n\t\t             parameter2);\n\t}\n};"), 
        Tab);
    verifyFormat(new StringRef(/*KEEP_STR*/"{\n\tQ(\n\t    {\n\t\t    int a;\n\t\t    someFunction(aaaaaaaa,\n\t\t                 bbbbbbb);\n\t    },\n\t    p);\n}"), 
        Tab);
    EXPECT_EQ("{\n\t/* aaaa\n\t   bbbb */\n}",format(new StringRef(/*KEEP_STR*/"{\n/* aaaa\n   bbbb */\n}"), Tab));
    EXPECT_EQ("{\n\t/*\n\t  aaaaaaaaaaaaaaaaaaaaaaaaaa\n\t  bbbbbbbbbbbbb\n\t*/\n}",format(new StringRef(/*KEEP_STR*/"{\n/*\n  aaaaaaaaaaaaaaaaaaaaaaaaaa bbbbbbbbbbbbb\n*/\n}"), Tab));
    EXPECT_EQ("{\n\t// aaaaaaaaaaaaaaaaaaaaaaaaaa\n\t// bbbbbbbbbbbbb\n}",format(new StringRef(/*KEEP_STR*/"{\n\t// aaaaaaaaaaaaaaaaaaaaaaaaaa bbbbbbbbbbbbb\n}"), Tab));
    EXPECT_EQ("{\n\t/*\n\t  aaaaaaaaaaaaaaaaaaaaaaaaaa\n\t  bbbbbbbbbbbbb\n\t*/\n}",format(new StringRef(/*KEEP_STR*/"{\n\t/*\n\t  aaaaaaaaaaaaaaaaaaaaaaaaaa bbbbbbbbbbbbb\n\t*/\n}"), Tab));
    EXPECT_EQ("{\n\t/*\n\n\t*/\n}",format(new StringRef(/*KEEP_STR*/"{\n\t/*\n\n\t*/\n}"), Tab));
    EXPECT_EQ("{\n\t/*\n asdf\n\t*/\n}",format(new StringRef(/*KEEP_STR*/"{\n\t/*\n asdf\n\t*/\n}"), Tab));
    
    Tab.UseTab = FormatStyle.UseTabStyle.UT_Never;
    EXPECT_EQ("/*\n              a\t\tcomment\n              in multiple lines\n       */",format(new StringRef(/*KEEP_STR*/"   /*\t \t \n \t \t a\t\tcomment\t \t\n \t \t in multiple lines\t\n \t  */"), Tab));
    EXPECT_EQ("/* some\n   comment */",format(new StringRef(/*KEEP_STR*/" \t \t /* some\n \t \t    comment */"), Tab));
    EXPECT_EQ("int a; /* some\n   comment */",format(new StringRef(/*KEEP_STR*/" \t \t int a; /* some\n \t \t    comment */"), Tab));
    EXPECT_EQ("int a; /* some\ncomment */",format(new StringRef(/*KEEP_STR*/" \t \t int\ta; /* some\n \t \t    comment */"), Tab));
    EXPECT_EQ("f(\"\t\t\"); /* some\n    comment */",format(new StringRef(/*KEEP_STR*/" \t \t f(\"\t\t\"); /* some\n \t \t    comment */"), Tab));
    EXPECT_EQ("{\n  /*\n   * Comment\n   */\n  int i;\n}",format(new StringRef(/*KEEP_STR*/"{\n\t/*\n\t * Comment\n\t */\n\t int i;\n}")));
    
    Tab.UseTab = FormatStyle.UseTabStyle.UT_ForContinuationAndIndentation;
    Tab.TabWidth = 8;
    Tab.IndentWidth = 8;
    EXPECT_EQ("if (aaaaaaaa && // q\n    bb)         // w\n\t;",format(new StringRef(/*KEEP_STR*/"if (aaaaaaaa &&// q\nbb)// w\n;"), Tab));
    EXPECT_EQ("if (aaa && bbb) // w\n\t;",format(new StringRef(/*KEEP_STR*/"if(aaa&&bbb)// w\n;"), Tab));
    verifyFormat(new StringRef(/*KEEP_STR*/"class X {\n\tvoid f() {\n\t\tsomeFunction(parameter1,\n\t\t\t     parameter2);\n\t}\n};"), 
        Tab);
    verifyFormat(new StringRef(/*KEEP_STR*/"#define A                        \\\n\tvoid f() {               \\\n\t\tsomeFunction(    \\\n\t\t    parameter1,  \\\n\t\t    parameter2); \\\n\t}"), 
        Tab);
    Tab.TabWidth = 4;
    Tab.IndentWidth = 8;
    verifyFormat(new StringRef(/*KEEP_STR*/"class TabWidth4Indent8 {\n\t\tvoid f() {\n\t\t\t\tsomeFunction(parameter1,\n\t\t\t\t\t\t\t parameter2);\n\t\t}\n};"), 
        Tab);
    Tab.TabWidth = 4;
    Tab.IndentWidth = 4;
    verifyFormat(new StringRef(/*KEEP_STR*/"class TabWidth4Indent4 {\n\tvoid f() {\n\t\tsomeFunction(parameter1,\n\t\t\t\t\t parameter2);\n\t}\n};"), 
        Tab);
    Tab.TabWidth = 8;
    Tab.IndentWidth = 4;
    verifyFormat(new StringRef(/*KEEP_STR*/"class TabWidth8Indent4 {\n    void f() {\n\tsomeFunction(parameter1,\n\t\t     parameter2);\n    }\n};"), 
        Tab);
    Tab.TabWidth = 8;
    Tab.IndentWidth = 8;
    EXPECT_EQ("/*\n\t      a\t\tcomment\n\t      in multiple lines\n       */",format(new StringRef(/*KEEP_STR*/"   /*\t \t \n \t \t a\t\tcomment\t \t\n \t \t in multiple lines\t\n \t  */"), Tab));
    verifyFormat(new StringRef(/*KEEP_STR*/"{\n\taaaaaaaaaaaaaaaaaaaaaaaaaaaa();\n\taaaaaaaaaaaaaaaaaaaaaaaaaaaa();\n\taaaaaaaaaaaaaaaaaaaaaaaaaaaa();\n\taaaaaaaaaaaaaaaaaaaaaaaaaaaa();\n\taaaaaaaaaaaaaaaaaaaaaaaaaaaa();\n\taaaaaaaaaaaaaaaaaaaaaaaaaaaa();\n};"), 
        Tab);
    verifyFormat(new StringRef(/*KEEP_STR*/"enum AA {\n\ta1, // Force multiple lines\n\ta2,\n\ta3\n};"), 
        Tab);
    EXPECT_EQ("if (aaaaaaaa && // q\n    bb)         // w\n\t;",format(new StringRef(/*KEEP_STR*/"if (aaaaaaaa &&// q\nbb)// w\n;"), Tab));
    verifyFormat(new StringRef(/*KEEP_STR*/"class X {\n\tvoid f() {\n\t\tsomeFunction(parameter1,\n\t\t\t     parameter2);\n\t}\n};"), 
        Tab);
    verifyFormat(new StringRef(/*KEEP_STR*/"{\n\tQ(\n\t    {\n\t\t    int a;\n\t\t    someFunction(aaaaaaaa,\n\t\t\t\t bbbbbbb);\n\t    },\n\t    p);\n}"), 
        Tab);
    EXPECT_EQ("{\n\t/* aaaa\n\t   bbbb */\n}",format(new StringRef(/*KEEP_STR*/"{\n/* aaaa\n   bbbb */\n}"), Tab));
    EXPECT_EQ("{\n\t/*\n\t  aaaaaaaaaaaaaaaaaaaaaaaaaa\n\t  bbbbbbbbbbbbb\n\t*/\n}",format(new StringRef(/*KEEP_STR*/"{\n/*\n  aaaaaaaaaaaaaaaaaaaaaaaaaa bbbbbbbbbbbbb\n*/\n}"), Tab));
    EXPECT_EQ("{\n\t// aaaaaaaaaaaaaaaaaaaaaaaaaa\n\t// bbbbbbbbbbbbb\n}",format(new StringRef(/*KEEP_STR*/"{\n\t// aaaaaaaaaaaaaaaaaaaaaaaaaa bbbbbbbbbbbbb\n}"), Tab));
    EXPECT_EQ("{\n\t/*\n\t  aaaaaaaaaaaaaaaaaaaaaaaaaa\n\t  bbbbbbbbbbbbb\n\t*/\n}",format(new StringRef(/*KEEP_STR*/"{\n\t/*\n\t  aaaaaaaaaaaaaaaaaaaaaaaaaa bbbbbbbbbbbbb\n\t*/\n}"), Tab));
    EXPECT_EQ("{\n\t/*\n\n\t*/\n}",format(new StringRef(/*KEEP_STR*/"{\n\t/*\n\n\t*/\n}"), Tab));
    EXPECT_EQ("{\n\t/*\n asdf\n\t*/\n}",format(new StringRef(/*KEEP_STR*/"{\n\t/*\n asdf\n\t*/\n}"), Tab));
    EXPECT_EQ("/*\n\t      a\t\tcomment\n\t      in multiple lines\n       */",format(new StringRef(/*KEEP_STR*/"   /*\t \t \n \t \t a\t\tcomment\t \t\n \t \t in multiple lines\t\n \t  */"), Tab));
    EXPECT_EQ("/* some\n   comment */",format(new StringRef(/*KEEP_STR*/" \t \t /* some\n \t \t    comment */"), Tab));
    EXPECT_EQ("int a; /* some\n   comment */",format(new StringRef(/*KEEP_STR*/" \t \t int a; /* some\n \t \t    comment */"), Tab));
    EXPECT_EQ("int a; /* some\ncomment */",format(new StringRef(/*KEEP_STR*/" \t \t int\ta; /* some\n \t \t    comment */"), Tab));
    EXPECT_EQ("f(\"\t\t\"); /* some\n    comment */",format(new StringRef(/*KEEP_STR*/" \t \t f(\"\t\t\"); /* some\n \t \t    comment */"), Tab));
    EXPECT_EQ("{\n  /*\n   * Comment\n   */\n  int i;\n}",format(new StringRef(/*KEEP_STR*/"{\n\t/*\n\t * Comment\n\t */\n\t int i;\n}")));
    Tab.AlignConsecutiveAssignments = true;
    Tab.AlignConsecutiveDeclarations = true;
    Tab.TabWidth = 4;
    Tab.IndentWidth = 4;
    verifyFormat(new StringRef(/*KEEP_STR*/"class Assign {\n\tvoid f() {\n\t\tint         x      = 123;\n\t\tint         random = 4;\n\t\tstd::string alphabet =\n\t\t\t\"abcdefghijklmnopqrstuvwxyz\";\n\t}\n};"), 
        Tab);
  } finally {
    if (Tab != null) { Tab.$destroy(); }
  }
}

;
@Test
//<editor-fold defaultstate="collapsed" desc="clang::format::(anonymous namespace)::FormatTest_CalculatesOriginalColumn_Test::TestBody">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp", line = 8835,
 FQN="clang::format::(anonymous namespace)::FormatTest_CalculatesOriginalColumn_Test::TestBody", NM="_ZN5clang6format12_GLOBAL__N_140FormatTest_CalculatesOriginalColumn_Test8TestBodyEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp -nm=_ZN5clang6format12_GLOBAL__N_140FormatTest_CalculatesOriginalColumn_Test8TestBodyEv")
//</editor-fold>
public void test_CalculatesOriginalColumn() {
  if (markAsSkippedIfNeed(TestState.Successful)) { return; }
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    EXPECT_EQ("\"qqqqqqqqqqqqqqqqqqqqqqqqqq\\\nq\"; /* some\n       comment */",$c$.clean(format(new StringRef(/*KEEP_STR*/"  \"qqqqqqqqqqqqqqqqqqqqqqqqqq\\\nq\"; /* some\n       comment */"), $c$.track(getLLVMStyle()))));
    EXPECT_EQ("// qqqqqqqqqqqqqqqqqqqqqqqqqq\n/* some\n   comment */",$c$.clean(format(new StringRef(/*KEEP_STR*/"// qqqqqqqqqqqqqqqqqqqqqqqqqq\n /* some\n    comment */"), $c$.track(getLLVMStyle()))));
    EXPECT_EQ("// qqqqqqqqqqqqqqqqqqqqqqqqqq\\\nqqq\n/* some\n   comment */",$c$.clean(format(new StringRef(/*KEEP_STR*/"// qqqqqqqqqqqqqqqqqqqqqqqqqq\\\nqqq\n /* some\n    comment */"), $c$.track(getLLVMStyle()))));
    EXPECT_EQ("inttt qqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqq\\\nwwww; /* some\n         comment */",$c$.clean(format(new StringRef(/*KEEP_STR*/"  inttt qqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqq\\\nwwww; /* some\n         comment */"), $c$.track(getLLVMStyle()))));
  } finally {
    $c$.$destroy();
  }
}

;
@Test
//<editor-fold defaultstate="collapsed" desc="clang::format::(anonymous namespace)::FormatTest_ConfigurableSpaceBeforeParens_Test::TestBody">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp", line = 8868,
 FQN="clang::format::(anonymous namespace)::FormatTest_ConfigurableSpaceBeforeParens_Test::TestBody", NM="_ZN5clang6format12_GLOBAL__N_145FormatTest_ConfigurableSpaceBeforeParens_Test8TestBodyEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp -nm=_ZN5clang6format12_GLOBAL__N_145FormatTest_ConfigurableSpaceBeforeParens_Test8TestBodyEv")
//</editor-fold>
public void test_ConfigurableSpaceBeforeParens() {
  if (markAsSkippedIfNeed(TestState.Successful)) { return; }
  FormatStyle NoSpace = null;
  FormatStyle Space = null;
  try {
    NoSpace = getLLVMStyle();
    NoSpace.SpaceBeforeParens = FormatStyle.SpaceBeforeParensOptions.SBPO_Never;
    
    verifyFormat(new StringRef(/*KEEP_STR*/"while(true)\n  continue;"), 
        NoSpace);
    verifyFormat(new StringRef(/*KEEP_STR*/"for(;;)\n  continue;"), 
        NoSpace);
    verifyFormat(new StringRef(/*KEEP_STR*/"if(true)\n  f();\nelse if(true)\n  f();"), 
        NoSpace);
    verifyFormat(new StringRef(/*KEEP_STR*/"do {\n  do_something();\n} while(something());"), 
        NoSpace);
    verifyFormat(new StringRef(/*KEEP_STR*/"switch(x) {\ndefault:\n  break;\n}"), 
        NoSpace);
    verifyFormat(new StringRef(/*KEEP_STR*/"auto i = std::make_unique<int>(5);"), NoSpace);
    verifyFormat(new StringRef(/*KEEP_STR*/"size_t x = sizeof(x);"), NoSpace);
    verifyFormat(new StringRef(/*KEEP_STR*/"auto f(int x) -> decltype(x);"), NoSpace);
    verifyFormat(new StringRef(/*KEEP_STR*/"int f(T x) noexcept(x.create());"), NoSpace);
    verifyFormat(new StringRef(/*KEEP_STR*/"alignas(128) char a[128];"), NoSpace);
    verifyFormat(new StringRef(/*KEEP_STR*/"size_t x = alignof(MyType);"), NoSpace);
    verifyFormat(new StringRef(/*KEEP_STR*/"static_assert(sizeof(char) == 1, \"Impossible!\");"), NoSpace);
    verifyFormat(new StringRef(/*KEEP_STR*/"int f() throw(Deprecated);"), NoSpace);
    verifyFormat(new StringRef(/*KEEP_STR*/"typedef void (*cb)(int);"), NoSpace);
    verifyFormat(new StringRef(/*KEEP_STR*/"T A::operator()();"), NoSpace);
    verifyFormat(new StringRef(/*KEEP_STR*/"X A::operator++(T);"), NoSpace);
    
    Space = getLLVMStyle();
    Space.SpaceBeforeParens = FormatStyle.SpaceBeforeParensOptions.SBPO_Always;
    
    verifyFormat(new StringRef(/*KEEP_STR*/"int f ();"), Space);
    verifyFormat(new StringRef(/*KEEP_STR*/"void f (int a, T b) {\n  while (true)\n    continue;\n}"), 
        Space);
    verifyFormat(new StringRef(/*KEEP_STR*/"if (true)\n  f ();\nelse if (true)\n  f ();"), 
        Space);
    verifyFormat(new StringRef(/*KEEP_STR*/"do {\n  do_something ();\n} while (something ());"), 
        Space);
    verifyFormat(new StringRef(/*KEEP_STR*/"switch (x) {\ndefault:\n  break;\n}"), 
        Space);
    verifyFormat(new StringRef(/*KEEP_STR*/"A::A () : a (1) {}"), Space);
    verifyFormat(new StringRef(/*KEEP_STR*/"void f () __attribute__ ((asdf));"), Space);
    verifyFormat(new StringRef(/*KEEP_STR*/"*(&a + 1);\n&((&a)[1]);\na[(b + c) * d];\n(((a + 1) * 2) + 3) * 4;"), 
        Space);
    verifyFormat(new StringRef(/*KEEP_STR*/"#define A(x) x"), Space);
    verifyFormat(new StringRef(/*KEEP_STR*/"#define A (x) x"), Space);
    verifyFormat(new StringRef(/*KEEP_STR*/"#if defined(x)\n#endif"), 
        Space);
    verifyFormat(new StringRef(/*KEEP_STR*/"auto i = std::make_unique<int> (5);"), Space);
    verifyFormat(new StringRef(/*KEEP_STR*/"size_t x = sizeof (x);"), Space);
    verifyFormat(new StringRef(/*KEEP_STR*/"auto f (int x) -> decltype (x);"), Space);
    verifyFormat(new StringRef(/*KEEP_STR*/"int f (T x) noexcept (x.create ());"), Space);
    verifyFormat(new StringRef(/*KEEP_STR*/"alignas (128) char a[128];"), Space);
    verifyFormat(new StringRef(/*KEEP_STR*/"size_t x = alignof (MyType);"), Space);
    verifyFormat(new StringRef(/*KEEP_STR*/"static_assert (sizeof (char) == 1, \"Impossible!\");"), Space);
    verifyFormat(new StringRef(/*KEEP_STR*/"int f () throw (Deprecated);"), Space);
    verifyFormat(new StringRef(/*KEEP_STR*/"typedef void (*cb) (int);"), Space);
    verifyFormat(new StringRef(/*KEEP_STR*/"T A::operator() ();"), Space);
    verifyFormat(new StringRef(/*KEEP_STR*/"X A::operator++ (T);"), Space);
  } finally {
    if (Space != null) { Space.$destroy(); }
    if (NoSpace != null) { NoSpace.$destroy(); }
  }
}

;
@Test
//<editor-fold defaultstate="collapsed" desc="clang::format::(anonymous namespace)::FormatTest_ConfigurableSpacesInParentheses_Test::TestBody">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp", line = 8952,
 FQN="clang::format::(anonymous namespace)::FormatTest_ConfigurableSpacesInParentheses_Test::TestBody", NM="_ZN5clang6format12_GLOBAL__N_147FormatTest_ConfigurableSpacesInParentheses_Test8TestBodyEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp -nm=_ZN5clang6format12_GLOBAL__N_147FormatTest_ConfigurableSpacesInParentheses_Test8TestBodyEv")
//</editor-fold>
public void test_ConfigurableSpacesInParentheses() {
  if (markAsSkippedIfNeed(TestState.Successful)) { return; }
  FormatStyle Spaces = null;
  try {
    Spaces = getLLVMStyle();
    
    Spaces.SpacesInParentheses = true;
    verifyFormat(new StringRef(/*KEEP_STR*/"call( x, y, z );"), Spaces);
    verifyFormat(new StringRef(/*KEEP_STR*/"call();"), Spaces);
    verifyFormat(new StringRef(/*KEEP_STR*/"std::function<void( int, int )> callback;"), Spaces);
    verifyFormat(new StringRef(/*KEEP_STR*/"void inFunction() { std::function<void( int, int )> fct; }"), 
        Spaces);
    verifyFormat(new StringRef(/*KEEP_STR*/"while ( (bool)1 )\n  continue;"), 
        Spaces);
    verifyFormat(new StringRef(/*KEEP_STR*/"for ( ;; )\n  continue;"), 
        Spaces);
    verifyFormat(new StringRef(/*KEEP_STR*/"if ( true )\n  f();\nelse if ( true )\n  f();"), 
        Spaces);
    verifyFormat(new StringRef(/*KEEP_STR*/"do {\n  do_something( (int)i );\n} while ( something() );"), 
        Spaces);
    verifyFormat(new StringRef(/*KEEP_STR*/"switch ( x ) {\ndefault:\n  break;\n}"), 
        Spaces);
    
    Spaces.SpacesInParentheses = false;
    Spaces.SpacesInCStyleCastParentheses = true;
    verifyFormat(new StringRef(/*KEEP_STR*/"Type *A = ( Type * )P;"), Spaces);
    verifyFormat(new StringRef(/*KEEP_STR*/"Type *A = ( vector<Type *, int *> )P;"), Spaces);
    verifyFormat(new StringRef(/*KEEP_STR*/"x = ( int32 )y;"), Spaces);
    verifyFormat(new StringRef(/*KEEP_STR*/"int a = ( int )(2.0f);"), Spaces);
    verifyFormat(new StringRef(/*KEEP_STR*/"#define AA(X) sizeof((( X * )NULL)->a)"), Spaces);
    verifyFormat(new StringRef(/*KEEP_STR*/"my_int a = ( my_int )sizeof(int);"), Spaces);
    verifyFormat(new StringRef(/*KEEP_STR*/"#define x (( int )-1)"), Spaces);
    
    // Run the first set of tests again with:
    Spaces.SpacesInParentheses = false;
    Spaces.SpaceInEmptyParentheses = true;
    Spaces.SpacesInCStyleCastParentheses = true;
    verifyFormat(new StringRef(/*KEEP_STR*/"call(x, y, z);"), Spaces);
    verifyFormat(new StringRef(/*KEEP_STR*/"call( );"), Spaces);
    verifyFormat(new StringRef(/*KEEP_STR*/"std::function<void(int, int)> callback;"), Spaces);
    verifyFormat(new StringRef(/*KEEP_STR*/"while (( bool )1)\n  continue;"), 
        Spaces);
    verifyFormat(new StringRef(/*KEEP_STR*/"for (;;)\n  continue;"), 
        Spaces);
    verifyFormat(new StringRef(/*KEEP_STR*/"if (true)\n  f( );\nelse if (true)\n  f( );"), 
        Spaces);
    verifyFormat(new StringRef(/*KEEP_STR*/"do {\n  do_something(( int )i);\n} while (something( ));"), 
        Spaces);
    verifyFormat(new StringRef(/*KEEP_STR*/"switch (x) {\ndefault:\n  break;\n}"), 
        Spaces);
    
    // Run the first set of tests again with:
    Spaces.SpaceAfterCStyleCast = true;
    verifyFormat(new StringRef(/*KEEP_STR*/"call(x, y, z);"), Spaces);
    verifyFormat(new StringRef(/*KEEP_STR*/"call( );"), Spaces);
    verifyFormat(new StringRef(/*KEEP_STR*/"std::function<void(int, int)> callback;"), Spaces);
    verifyFormat(new StringRef(/*KEEP_STR*/"while (( bool ) 1)\n  continue;"), 
        Spaces);
    verifyFormat(new StringRef(/*KEEP_STR*/"for (;;)\n  continue;"), 
        Spaces);
    verifyFormat(new StringRef(/*KEEP_STR*/"if (true)\n  f( );\nelse if (true)\n  f( );"), 
        Spaces);
    verifyFormat(new StringRef(/*KEEP_STR*/"do {\n  do_something(( int ) i);\n} while (something( ));"), 
        Spaces);
    verifyFormat(new StringRef(/*KEEP_STR*/"switch (x) {\ndefault:\n  break;\n}"), 
        Spaces);
    
    // Run subset of tests again with:
    Spaces.SpacesInCStyleCastParentheses = false;
    Spaces.SpaceAfterCStyleCast = true;
    verifyFormat(new StringRef(/*KEEP_STR*/"while ((bool) 1)\n  continue;"), 
        Spaces);
    verifyFormat(new StringRef(/*KEEP_STR*/"do {\n  do_something((int) i);\n} while (something( ));"), 
        Spaces);
  } finally {
    if (Spaces != null) { Spaces.$destroy(); }
  }
}

;
@Test
//<editor-fold defaultstate="collapsed" desc="clang::format::(anonymous namespace)::FormatTest_ConfigurableSpacesInSquareBrackets_Test::TestBody">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp", line = 9058,
 FQN="clang::format::(anonymous namespace)::FormatTest_ConfigurableSpacesInSquareBrackets_Test::TestBody", NM="_ZN5clang6format12_GLOBAL__N_150FormatTest_ConfigurableSpacesInSquareBrackets_Test8TestBodyEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp -nm=_ZN5clang6format12_GLOBAL__N_150FormatTest_ConfigurableSpacesInSquareBrackets_Test8TestBodyEv")
//</editor-fold>
public void test_ConfigurableSpacesInSquareBrackets() {
  if (markAsSkippedIfNeed(TestState.Successful)) { return; }
  FormatStyle Spaces = null;
  try {
    verifyFormat(new StringRef(/*KEEP_STR*/"int a[5];"));
    verifyFormat(new StringRef(/*KEEP_STR*/"a[3] += 42;"));
    
    Spaces = getLLVMStyle();
    Spaces.SpacesInSquareBrackets = true;
    // Lambdas unchanged.
    verifyFormat(new StringRef(/*KEEP_STR*/"int c = []() -> int { return 2; }();\n"), Spaces);
    verifyFormat(new StringRef(/*KEEP_STR*/"return [i, args...] {};"), Spaces);
    
    // Not lambdas.
    verifyFormat(new StringRef(/*KEEP_STR*/"int a[ 5 ];"), Spaces);
    verifyFormat(new StringRef(/*KEEP_STR*/"a[ 3 ] += 42;"), Spaces);
    verifyFormat(new StringRef(/*KEEP_STR*/"constexpr char hello[]{\"hello\"};"), Spaces);
    verifyFormat(new StringRef(/*KEEP_STR*/"double &operator[](int i) { return 0; }\nint i;"), 
        Spaces);
    verifyFormat(new StringRef(/*KEEP_STR*/"std::unique_ptr<int[]> foo() {}"), Spaces);
    verifyFormat(new StringRef(/*KEEP_STR*/"int i = a[ a ][ a ]->f();"), Spaces);
    verifyFormat(new StringRef(/*KEEP_STR*/"int i = (*b)[ a ]->f();"), Spaces);
  } finally {
    if (Spaces != null) { Spaces.$destroy(); }
  }
}

;
@Test
//<editor-fold defaultstate="collapsed" desc="clang::format::(anonymous namespace)::FormatTest_ConfigurableSpaceBeforeAssignmentOperators_Test::TestBody">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp", line = 9080,
 FQN="clang::format::(anonymous namespace)::FormatTest_ConfigurableSpaceBeforeAssignmentOperators_Test::TestBody", NM="_ZN5clang6format12_GLOBAL__N_158FormatTest_ConfigurableSpaceBeforeAssignmentOperators_Test8TestBodyEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp -nm=_ZN5clang6format12_GLOBAL__N_158FormatTest_ConfigurableSpaceBeforeAssignmentOperators_Test8TestBodyEv")
//</editor-fold>
public void test_ConfigurableSpaceBeforeAssignmentOperators() {
  if (markAsSkippedIfNeed(TestState.Successful)) { return; }
  FormatStyle Spaces = null;
  try {
    verifyFormat(new StringRef(/*KEEP_STR*/"int a = 5;"));
    verifyFormat(new StringRef(/*KEEP_STR*/"a += 42;"));
    verifyFormat(new StringRef(/*KEEP_STR*/"a or_eq 8;"));
    
    Spaces = getLLVMStyle();
    Spaces.SpaceBeforeAssignmentOperators = false;
    verifyFormat(new StringRef(/*KEEP_STR*/"int a= 5;"), Spaces);
    verifyFormat(new StringRef(/*KEEP_STR*/"a+= 42;"), Spaces);
    verifyFormat(new StringRef(/*KEEP_STR*/"a or_eq 8;"), Spaces);
  } finally {
    if (Spaces != null) { Spaces.$destroy(); }
  }
}

;
@Test
//<editor-fold defaultstate="collapsed" desc="clang::format::(anonymous namespace)::FormatTest_AlignConsecutiveAssignments_Test::TestBody">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp", line = 9092,
 FQN="clang::format::(anonymous namespace)::FormatTest_AlignConsecutiveAssignments_Test::TestBody", NM="_ZN5clang6format12_GLOBAL__N_143FormatTest_AlignConsecutiveAssignments_Test8TestBodyEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp -nm=_ZN5clang6format12_GLOBAL__N_143FormatTest_AlignConsecutiveAssignments_Test8TestBodyEv")
//</editor-fold>
public void test_AlignConsecutiveAssignments() {
  if (markAsSkippedIfNeed(TestState.Successful)) { return; }
  FormatStyle Alignment = null;
  try {
    Alignment = getLLVMStyle();
    Alignment.AlignConsecutiveAssignments = false;
    verifyFormat(new StringRef(/*KEEP_STR*/"int a = 5;\nint oneTwoThree = 123;"), 
        Alignment);
    verifyFormat(new StringRef(/*KEEP_STR*/"int a = 5;\nint oneTwoThree = 123;"), 
        Alignment);
    
    Alignment.AlignConsecutiveAssignments = true;
    verifyFormat(new StringRef(/*KEEP_STR*/"int a           = 5;\nint oneTwoThree = 123;"), 
        Alignment);
    verifyFormat(new StringRef(/*KEEP_STR*/"int a           = method();\nint oneTwoThree = 133;"), 
        Alignment);
    verifyFormat(new StringRef(/*KEEP_STR*/"a &= 5;\nbcd *= 5;\nghtyf += 5;\ndvfvdb -= 5;\na /= 5;\nvdsvsv %= 5;\nsfdbddfbdfbb ^= 5;\ndvsdsv |= 5;\nint dsvvdvsdvvv = 123;"), 
        Alignment);
    verifyFormat(new StringRef(/*KEEP_STR*/"int i = 1, j = 10;\nsomething = 2000;"), 
        Alignment);
    verifyFormat(new StringRef(/*KEEP_STR*/"something = 2000;\nint i = 1, j = 10;\n"), 
        Alignment);
    verifyFormat(new StringRef(/*KEEP_STR*/"something = 2000;\nanother   = 911;\nint i = 1, j = 10;\noneMore = 1;\ni       = 2;"), 
        Alignment);
    verifyFormat(new StringRef(/*KEEP_STR*/"int a   = 5;\nint one = 1;\nmethod();\nint oneTwoThree = 123;\nint oneTwo      = 12;"), 
        Alignment);
    verifyFormat(new StringRef(/*KEEP_STR*/"int oneTwoThree = 123;\nint oneTwo      = 12;\nmethod();\n"), 
        Alignment);
    verifyFormat(new StringRef(/*KEEP_STR*/"int oneTwoThree = 123; // comment\nint oneTwo      = 12;  // comment"), 
        Alignment);
    EXPECT_EQ("int a = 5;\n\nint oneTwoThree = 123;",format(new StringRef(/*KEEP_STR*/"int a       = 5;\n\nint oneTwoThree= 123;"), Alignment));
    EXPECT_EQ("int a   = 5;\nint one = 1;\n\nint oneTwoThree = 123;",format(new StringRef(/*KEEP_STR*/"int a = 5;\nint one = 1;\n\nint oneTwoThree = 123;"), Alignment));
    EXPECT_EQ("int a   = 5;\nint one = 1;\n\nint oneTwoThree = 123;\nint oneTwo      = 12;",format(new StringRef(/*KEEP_STR*/"int a = 5;\nint one = 1;\n\nint oneTwoThree = 123;\nint oneTwo = 12;"), Alignment));
    Alignment.AlignEscapedNewlinesLeft = true;
    verifyFormat(new StringRef(/*KEEP_STR*/"#define A               \\\n  int aaaa       = 12;  \\\n  int b          = 23;  \\\n  int ccc        = 234; \\\n  int dddddddddd = 2345;"), 
        Alignment);
    Alignment.AlignEscapedNewlinesLeft = false;
    verifyFormat(new StringRef(/*KEEP_STR*/"#define A                                                                      \\\n  int aaaa       = 12;                                                         \\\n  int b          = 23;                                                         \\\n  int ccc        = 234;                                                        \\\n  int dddddddddd = 2345;"), 
        Alignment);
    verifyFormat(new StringRef(/*KEEP_STR*/"void SomeFunction(int parameter = 1, int i = 2, int j = 3, int k = 4, int l = 5,\n                  int m = 6) {\n  int j      = 10;\n  otherThing = 1;\n}"), 
        Alignment);
    verifyFormat(new StringRef(/*KEEP_STR*/"void SomeFunction(int parameter = 0) {\n  int i   = 1;\n  int j   = 2;\n  int big = 10000;\n}"), 
        Alignment);
    verifyFormat(new StringRef(/*KEEP_STR*/"class C {\npublic:\n  int i            = 1;\n  virtual void f() = 0;\n};"), 
        Alignment);
    verifyFormat(new StringRef(/*KEEP_STR*/"int i = 1;\nif (SomeType t = getSomething()) {\n}\nint j   = 2;\nint big = 10000;"), 
        Alignment);
    verifyFormat(new StringRef(/*KEEP_STR*/"int j = 7;\nfor (int k = 0; k < N; ++k) {\n}\nint j   = 2;\nint big = 10000;\n}"), 
        Alignment);
    Alignment.BreakBeforeBinaryOperators = FormatStyle.BinaryOperatorStyle.BOS_All;
    verifyFormat(new StringRef(/*KEEP_STR*/"int i = 1;\nLooooooooooongType loooooooooooooooooooooongVariable\n    = someLooooooooooooooooongFunction();\nint j = 2;"), 
        Alignment);
    Alignment.BreakBeforeBinaryOperators = FormatStyle.BinaryOperatorStyle.BOS_None;
    verifyFormat(new StringRef(/*KEEP_STR*/"int i = 1;\nLooooooooooongType loooooooooooooooooooooongVariable =\n    someLooooooooooooooooongFunction();\nint j = 2;"), 
        Alignment);
    
    verifyFormat(new StringRef(/*KEEP_STR*/"auto lambda = []() {\n  auto i = 0;\n  return 0;\n};\nint i  = 0;\nauto v = type{\n    i = 1,   //\n    (i = 2), //\n    i = 3    //\n};"), 
        Alignment);
    
    // FIXME: Should align all three assignments
    verifyFormat(new StringRef(/*KEEP_STR*/"int i      = 1;\nSomeType a = SomeFunction(looooooooooooooooooooooongParameterA,\n                          loooooooooooooooooooooongParameterB);\nint j = 2;"), 
        Alignment);
    
    verifyFormat(new StringRef(/*KEEP_STR*/"template <typename T, typename T_0 = very_long_type_name_0,\n          typename B   = very_long_type_name_1,\n          typename T_2 = very_long_type_name_2>\nauto foo() {}\n"), 
        Alignment);
    verifyFormat(new StringRef(/*KEEP_STR*/"int a, b = 1;\nint c  = 2;\nint dd = 3;\n"), 
        Alignment);
    verifyFormat(new StringRef(/*KEEP_STR*/"int aa       = ((1 > 2) ? 3 : 4);\nfloat b[1][] = {{3.f}};\n"), 
        Alignment);
  } finally {
    if (Alignment != null) { Alignment.$destroy(); }
  }
}

;
@Test
//<editor-fold defaultstate="collapsed" desc="clang::format::(anonymous namespace)::FormatTest_AlignConsecutiveDeclarations_Test::TestBody">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp", line = 9268,
 FQN="clang::format::(anonymous namespace)::FormatTest_AlignConsecutiveDeclarations_Test::TestBody", NM="_ZN5clang6format12_GLOBAL__N_144FormatTest_AlignConsecutiveDeclarations_Test8TestBodyEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp -nm=_ZN5clang6format12_GLOBAL__N_144FormatTest_AlignConsecutiveDeclarations_Test8TestBodyEv")
//</editor-fold>
public void test_AlignConsecutiveDeclarations() {
  if (markAsSkippedIfNeed(TestState.Successful)) { return; }
  FormatStyle Alignment = null;
  try {
    Alignment = getLLVMStyle();
    Alignment.AlignConsecutiveDeclarations = false;
    verifyFormat(new StringRef(/*KEEP_STR*/"float const a = 5;\nint oneTwoThree = 123;"), 
        Alignment);
    verifyFormat(new StringRef(/*KEEP_STR*/"int a = 5;\nfloat const oneTwoThree = 123;"), 
        Alignment);
    
    Alignment.AlignConsecutiveDeclarations = true;
    verifyFormat(new StringRef(/*KEEP_STR*/"float const a = 5;\nint         oneTwoThree = 123;"), 
        Alignment);
    verifyFormat(new StringRef(/*KEEP_STR*/"int         a = method();\nfloat const oneTwoThree = 133;"), 
        Alignment);
    verifyFormat(new StringRef(/*KEEP_STR*/"int i = 1, j = 10;\nsomething = 2000;"), 
        Alignment);
    verifyFormat(new StringRef(/*KEEP_STR*/"something = 2000;\nint i = 1, j = 10;\n"), 
        Alignment);
    verifyFormat(new StringRef(/*KEEP_STR*/"float      something = 2000;\ndouble     another = 911;\nint        i = 1, j = 10;\nconst int *oneMore = 1;\nunsigned   i = 2;"), 
        Alignment);
    verifyFormat(new StringRef(/*KEEP_STR*/"float a = 5;\nint   one = 1;\nmethod();\nconst double       oneTwoThree = 123;\nconst unsigned int oneTwo = 12;"), 
        Alignment);
    verifyFormat(new StringRef(/*KEEP_STR*/"int      oneTwoThree{0}; // comment\nunsigned oneTwo;         // comment"), 
        Alignment);
    EXPECT_EQ("float const a = 5;\n\nint oneTwoThree = 123;",format(new StringRef(/*KEEP_STR*/"float const   a = 5;\n\nint           oneTwoThree= 123;"), Alignment));
    EXPECT_EQ("float a = 5;\nint   one = 1;\n\nunsigned oneTwoThree = 123;",format(new StringRef(/*KEEP_STR*/"float    a = 5;\nint      one = 1;\n\nunsigned oneTwoThree = 123;"), Alignment));
    EXPECT_EQ("float a = 5;\nint   one = 1;\n\nunsigned oneTwoThree = 123;\nint      oneTwo = 12;",format(new StringRef(/*KEEP_STR*/"float    a = 5;\nint one = 1;\n\nunsigned oneTwoThree = 123;\nint oneTwo = 12;"), Alignment));
    Alignment.AlignConsecutiveAssignments = true;
    verifyFormat(new StringRef(/*KEEP_STR*/"float      something = 2000;\ndouble     another   = 911;\nint        i = 1, j = 10;\nconst int *oneMore = 1;\nunsigned   i       = 2;"), 
        Alignment);
    verifyFormat(new StringRef(/*KEEP_STR*/"int      oneTwoThree = {0}; // comment\nunsigned oneTwo      = 0;   // comment"), 
        Alignment);
    EXPECT_EQ("void SomeFunction(int parameter = 0) {\n  int const i   = 1;\n  int *     j   = 2;\n  int       big = 10000;\n\n  unsigned oneTwoThree = 123;\n  int      oneTwo      = 12;\n  method();\n  float k  = 2;\n  int   ll = 10000;\n}",format(new StringRef(/*KEEP_STR*/"void SomeFunction(int parameter= 0) {\n int const  i= 1;\n  int *j=2;\n int big  =  10000;\n\nunsigned oneTwoThree  =123;\nint oneTwo = 12;\n  method();\nfloat k= 2;\nint ll=10000;\n}"), Alignment));
    Alignment.AlignConsecutiveAssignments = false;
    Alignment.AlignEscapedNewlinesLeft = true;
    verifyFormat(new StringRef(/*KEEP_STR*/"#define A              \\\n  int       aaaa = 12; \\\n  float     b = 23;    \\\n  const int ccc = 234; \\\n  unsigned  dddddddddd = 2345;"), 
        Alignment);
    Alignment.AlignEscapedNewlinesLeft = false;
    Alignment.ColumnLimit = 30;
    verifyFormat(new StringRef(/*KEEP_STR*/"#define A                    \\\n  int       aaaa = 12;       \\\n  float     b = 23;          \\\n  const int ccc = 234;       \\\n  int       dddddddddd = 2345;"), 
        Alignment);
    Alignment.ColumnLimit = 80;
    verifyFormat(new StringRef(/*KEEP_STR*/"void SomeFunction(int parameter = 1, int i = 2, int j = 3, int k = 4, int l = 5,\n                  int m = 6) {\n  const int j = 10;\n  otherThing = 1;\n}"), 
        Alignment);
    verifyFormat(new StringRef(/*KEEP_STR*/"void SomeFunction(int parameter = 0) {\n  int const i = 1;\n  int *     j = 2;\n  int       big = 10000;\n}"), 
        Alignment);
    verifyFormat(new StringRef(/*KEEP_STR*/"class C {\npublic:\n  int          i = 1;\n  virtual void f() = 0;\n};"), 
        Alignment);
    verifyFormat(new StringRef(/*KEEP_STR*/"float i = 1;\nif (SomeType t = getSomething()) {\n}\nconst unsigned j = 2;\nint            big = 10000;"), 
        Alignment);
    verifyFormat(new StringRef(/*KEEP_STR*/"float j = 7;\nfor (int k = 0; k < N; ++k) {\n}\nunsigned j = 2;\nint      big = 10000;\n}"), 
        Alignment);
    Alignment.BreakBeforeBinaryOperators = FormatStyle.BinaryOperatorStyle.BOS_All;
    verifyFormat(new StringRef(/*KEEP_STR*/"float              i = 1;\nLooooooooooongType loooooooooooooooooooooongVariable\n    = someLooooooooooooooooongFunction();\nint j = 2;"), 
        Alignment);
    Alignment.BreakBeforeBinaryOperators = FormatStyle.BinaryOperatorStyle.BOS_None;
    verifyFormat(new StringRef(/*KEEP_STR*/"int                i = 1;\nLooooooooooongType loooooooooooooooooooooongVariable =\n    someLooooooooooooooooongFunction();\nint j = 2;"), 
        Alignment);
    
    Alignment.AlignConsecutiveAssignments = true;
    verifyFormat(new StringRef(/*KEEP_STR*/"auto lambda = []() {\n  auto  ii = 0;\n  float j  = 0;\n  return 0;\n};\nint   i  = 0;\nfloat i2 = 0;\nauto  v  = type{\n    i = 1,   //\n    (i = 2), //\n    i = 3    //\n};"), 
        Alignment);
    Alignment.AlignConsecutiveAssignments = false;
    
    // FIXME: Should align all three declarations
    verifyFormat(new StringRef(/*KEEP_STR*/"int      i = 1;\nSomeType a = SomeFunction(looooooooooooooooooooooongParameterA,\n                          loooooooooooooooooooooongParameterB);\nint j = 2;"), 
        Alignment);
    
    // Test interactions with ColumnLimit and AlignConsecutiveAssignments:
    // We expect declarations and assignments to align, as long as it doesn't
    // exceed the column limit, starting a new alignemnt sequence whenever it
    // happens.
    Alignment.AlignConsecutiveAssignments = true;
    Alignment.ColumnLimit = 30;
    verifyFormat(new StringRef(/*KEEP_STR*/"float    ii              = 1;\nunsigned j               = 2;\nint someVerylongVariable = 1;\nAnotherLongType  ll = 123456;\nVeryVeryLongType k  = 2;\nint              myvar = 1;"), 
        Alignment);
    Alignment.ColumnLimit = 80;
    Alignment.AlignConsecutiveAssignments = false;
    
    verifyFormat(new StringRef(/*KEEP_STR*/"template <typename LongTemplate, typename VeryLongTemplateTypeName,\n          typename LongType, typename B>\nauto foo() {}\n"), 
        Alignment);
    verifyFormat(new StringRef(/*KEEP_STR*/"float a, b = 1;\nint   c = 2;\nint   dd = 3;\n"), 
        Alignment);
    verifyFormat(new StringRef(/*KEEP_STR*/"int   aa = ((1 > 2) ? 3 : 4);\nfloat b[1][] = {{3.f}};\n"), 
        Alignment);
    Alignment.AlignConsecutiveAssignments = true;
    verifyFormat(new StringRef(/*KEEP_STR*/"float a, b = 1;\nint   c  = 2;\nint   dd = 3;\n"), 
        Alignment);
    verifyFormat(new StringRef(/*KEEP_STR*/"int   aa     = ((1 > 2) ? 3 : 4);\nfloat b[1][] = {{3.f}};\n"), 
        Alignment);
    Alignment.AlignConsecutiveAssignments = false;
    
    Alignment.ColumnLimit = 30;
    Alignment.BinPackParameters = false;
    verifyFormat(new StringRef(/*KEEP_STR*/"void foo(float     a,\n         float     b,\n         int       c,\n         uint32_t *d) {\n  int *  e = 0;\n  float  f = 0;\n  double g = 0;\n}\nvoid bar(ino_t     a,\n         int       b,\n         uint32_t *c,\n         bool      d) {}\n"), 
        Alignment);
    Alignment.BinPackParameters = true;
    Alignment.ColumnLimit = 80;
  } finally {
    if (Alignment != null) { Alignment.$destroy(); }
  }
}

;
@Test
//<editor-fold defaultstate="collapsed" desc="clang::format::(anonymous namespace)::FormatTest_LinuxBraceBreaking_Test::TestBody">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp", line = 9509,
 FQN="clang::format::(anonymous namespace)::FormatTest_LinuxBraceBreaking_Test::TestBody", NM="_ZN5clang6format12_GLOBAL__N_134FormatTest_LinuxBraceBreaking_Test8TestBodyEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp -nm=_ZN5clang6format12_GLOBAL__N_134FormatTest_LinuxBraceBreaking_Test8TestBodyEv")
//</editor-fold>
public void test_LinuxBraceBreaking() {
  if (markAsSkippedIfNeed(TestState.Successful)) { return; }
  FormatStyle LinuxBraceStyle = null;
  try {
    LinuxBraceStyle = getLLVMStyle();
    LinuxBraceStyle.BreakBeforeBraces = FormatStyle.BraceBreakingStyle.BS_Linux;
    verifyFormat(new StringRef(/*KEEP_STR*/"namespace a\n{\nclass A\n{\n  void f()\n  {\n    if (true) {\n      a();\n      b();\n    } else {\n      a();\n    }\n  }\n  void g() { return; }\n};\nstruct B {\n  int x;\n};\n}\n"), 
        LinuxBraceStyle);
    verifyFormat(new StringRef(/*KEEP_STR*/"enum X {\n  Y = 0,\n}\n"), 
        LinuxBraceStyle);
    verifyFormat(new StringRef(/*KEEP_STR*/"struct S {\n  int Type;\n  union {\n    int x;\n    double y;\n  } Value;\n  class C\n  {\n    MyFavoriteType Value;\n  } Class;\n}\n"), 
        LinuxBraceStyle);
  } finally {
    if (LinuxBraceStyle != null) { LinuxBraceStyle.$destroy(); }
  }
}

;
@Test
//<editor-fold defaultstate="collapsed" desc="clang::format::(anonymous namespace)::FormatTest_MozillaBraceBreaking_Test::TestBody">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp", line = 9550,
 FQN="clang::format::(anonymous namespace)::FormatTest_MozillaBraceBreaking_Test::TestBody", NM="_ZN5clang6format12_GLOBAL__N_136FormatTest_MozillaBraceBreaking_Test8TestBodyEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp -nm=_ZN5clang6format12_GLOBAL__N_136FormatTest_MozillaBraceBreaking_Test8TestBodyEv")
//</editor-fold>
public void test_MozillaBraceBreaking() {
  if (markAsSkippedIfNeed(TestState.Successful)) { return; }
  FormatStyle MozillaBraceStyle = null;
  try {
    MozillaBraceStyle = getLLVMStyle();
    MozillaBraceStyle.BreakBeforeBraces = FormatStyle.BraceBreakingStyle.BS_Mozilla;
    verifyFormat(new StringRef(/*KEEP_STR*/"namespace a {\nclass A\n{\n  void f()\n  {\n    if (true) {\n      a();\n      b();\n    }\n  }\n  void g() { return; }\n};\nenum E\n{\n  A,\n  // foo\n  B,\n  C\n};\nstruct B\n{\n  int x;\n};\n}\n"), 
        MozillaBraceStyle);
    verifyFormat(new StringRef(/*KEEP_STR*/"struct S\n{\n  int Type;\n  union\n  {\n    int x;\n    double y;\n  } Value;\n  class C\n  {\n    MyFavoriteType Value;\n  } Class;\n}\n"), 
        MozillaBraceStyle);
  } finally {
    if (MozillaBraceStyle != null) { MozillaBraceStyle.$destroy(); }
  }
}

;
@Test
//<editor-fold defaultstate="collapsed" desc="clang::format::(anonymous namespace)::FormatTest_StroustrupBraceBreaking_Test::TestBody">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp", line = 9594,
 FQN="clang::format::(anonymous namespace)::FormatTest_StroustrupBraceBreaking_Test::TestBody", NM="_ZN5clang6format12_GLOBAL__N_139FormatTest_StroustrupBraceBreaking_Test8TestBodyEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp -nm=_ZN5clang6format12_GLOBAL__N_139FormatTest_StroustrupBraceBreaking_Test8TestBodyEv")
//</editor-fold>
public void test_StroustrupBraceBreaking() {
  if (markAsSkippedIfNeed(TestState.Successful)) { return; }
  FormatStyle StroustrupBraceStyle = null;
  try {
    StroustrupBraceStyle = getLLVMStyle();
    StroustrupBraceStyle.BreakBeforeBraces = FormatStyle.BraceBreakingStyle.BS_Stroustrup;
    verifyFormat(new StringRef(/*KEEP_STR*/"namespace a {\nclass A {\n  void f()\n  {\n    if (true) {\n      a();\n      b();\n    }\n  }\n  void g() { return; }\n};\nstruct B {\n  int x;\n};\n}\n"), 
        StroustrupBraceStyle);
    
    verifyFormat(new StringRef(/*KEEP_STR*/"void foo()\n{\n  if (a) {\n    a();\n  }\n  else {\n    b();\n  }\n}\n"), 
        StroustrupBraceStyle);
    
    verifyFormat(new StringRef(/*KEEP_STR*/"#ifdef _DEBUG\nint foo(int i = 0)\n#else\nint foo(int i = 5)\n#endif\n{\n  return i;\n}"), 
        StroustrupBraceStyle);
    
    verifyFormat(new StringRef(/*KEEP_STR*/"void foo() {}\nvoid bar()\n#ifdef _DEBUG\n{\n  foo();\n}\n#else\n{\n}\n#endif"), 
        StroustrupBraceStyle);
    
    verifyFormat(new StringRef(/*KEEP_STR*/"void foobar() { int i = 5; }\n#ifdef _DEBUG\nvoid bar() {}\n#else\nvoid bar() { foobar(); }\n#endif"), 
        StroustrupBraceStyle);
  } finally {
    if (StroustrupBraceStyle != null) { StroustrupBraceStyle.$destroy(); }
  }
}

;
@Test
//<editor-fold defaultstate="collapsed" desc="clang::format::(anonymous namespace)::FormatTest_AllmanBraceBreaking_Test::TestBody">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp", line = 9656,
 FQN="clang::format::(anonymous namespace)::FormatTest_AllmanBraceBreaking_Test::TestBody", NM="_ZN5clang6format12_GLOBAL__N_135FormatTest_AllmanBraceBreaking_Test8TestBodyEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp -nm=_ZN5clang6format12_GLOBAL__N_135FormatTest_AllmanBraceBreaking_Test8TestBodyEv")
//</editor-fold>
public void test_AllmanBraceBreaking() {
  if (markAsSkippedIfNeed(TestState.Successful)) { return; }
  FormatStyle AllmanBraceStyle = null;
  FormatStyle BreakBeforeBraceShortIfs = null;
  try {
    AllmanBraceStyle = getLLVMStyle();
    AllmanBraceStyle.BreakBeforeBraces = FormatStyle.BraceBreakingStyle.BS_Allman;
    verifyFormat(new StringRef(/*KEEP_STR*/"namespace a\n{\nclass A\n{\n  void f()\n  {\n    if (true)\n    {\n      a();\n      b();\n    }\n  }\n  void g() { return; }\n};\nstruct B\n{\n  int x;\n};\n}"), 
        AllmanBraceStyle);
    
    verifyFormat(new StringRef(/*KEEP_STR*/"void f()\n{\n  if (true)\n  {\n    a();\n  }\n  else if (false)\n  {\n    b();\n  }\n  else\n  {\n    c();\n  }\n}\n"), 
        AllmanBraceStyle);
    
    verifyFormat(new StringRef(/*KEEP_STR*/"void f()\n{\n  for (int i = 0; i < 10; ++i)\n  {\n    a();\n  }\n  while (false)\n  {\n    b();\n  }\n  do\n  {\n    c();\n  } while (false)\n}\n"), 
        AllmanBraceStyle);
    
    verifyFormat(new StringRef(/*KEEP_STR*/"void f(int a)\n{\n  switch (a)\n  {\n  case 0:\n    break;\n  case 1:\n  {\n    break;\n  }\n  case 2:\n  {\n  }\n  break;\n  default:\n    break;\n  }\n}\n"), 
        AllmanBraceStyle);
    
    verifyFormat(new StringRef(/*KEEP_STR*/"enum X\n{\n  Y = 0,\n}\n"), 
        AllmanBraceStyle);
    verifyFormat(new StringRef(/*KEEP_STR*/"enum X\n{\n  Y = 0\n}\n"), 
        AllmanBraceStyle);
    
    verifyFormat(new StringRef(/*KEEP_STR*/"@interface BSApplicationController ()\n{\n@private\n  id _extraIvar;\n}\n@end\n"), 
        AllmanBraceStyle);
    
    verifyFormat(new StringRef(/*KEEP_STR*/"#ifdef _DEBUG\nint foo(int i = 0)\n#else\nint foo(int i = 5)\n#endif\n{\n  return i;\n}"), 
        AllmanBraceStyle);
    
    verifyFormat(new StringRef(/*KEEP_STR*/"void foo() {}\nvoid bar()\n#ifdef _DEBUG\n{\n  foo();\n}\n#else\n{\n}\n#endif"), 
        AllmanBraceStyle);
    
    verifyFormat(new StringRef(/*KEEP_STR*/"void foobar() { int i = 5; }\n#ifdef _DEBUG\nvoid bar() {}\n#else\nvoid bar() { foobar(); }\n#endif"), 
        AllmanBraceStyle);
    
    // This shouldn't affect ObjC blocks..
    verifyFormat(new StringRef(/*KEEP_STR*/"[self doSomeThingWithACompletionHandler:^{\n  // ...\n  int i;\n}];"), 
        AllmanBraceStyle);
    verifyFormat(new StringRef(/*KEEP_STR*/"void (^block)(void) = ^{\n  // ...\n  int i;\n};"), 
        AllmanBraceStyle);
    // .. or dict literals.
    verifyFormat(new StringRef(/*KEEP_STR*/"void f()\n{\n  [object someMethod:@{ @\"a\" : @\"b\" }];\n}"), 
        AllmanBraceStyle);
    verifyFormat(new StringRef(/*KEEP_STR*/"int f()\n{ // comment\n  return 42;\n}"), 
        AllmanBraceStyle);
    
    AllmanBraceStyle.ColumnLimit = 19;
    verifyFormat(new StringRef(/*KEEP_STR*/"void f() { int i; }"), AllmanBraceStyle);
    AllmanBraceStyle.ColumnLimit = 18;
    verifyFormat(new StringRef(/*KEEP_STR*/"void f()\n{\n  int i;\n}"), 
        AllmanBraceStyle);
    AllmanBraceStyle.ColumnLimit = 80;
    
    BreakBeforeBraceShortIfs = new FormatStyle(AllmanBraceStyle);
    BreakBeforeBraceShortIfs.AllowShortIfStatementsOnASingleLine = true;
    BreakBeforeBraceShortIfs.AllowShortLoopsOnASingleLine = true;
    verifyFormat(new StringRef(/*KEEP_STR*/"void f(bool b)\n{\n  if (b)\n  {\n    return;\n  }\n}\n"), 
        BreakBeforeBraceShortIfs);
    verifyFormat(new StringRef(/*KEEP_STR*/"void f(bool b)\n{\n  if (b) return;\n}\n"), 
        BreakBeforeBraceShortIfs);
    verifyFormat(new StringRef(/*KEEP_STR*/"void f(bool b)\n{\n  while (b)\n  {\n    return;\n  }\n}\n"), 
        BreakBeforeBraceShortIfs);
  } finally {
    if (BreakBeforeBraceShortIfs != null) { BreakBeforeBraceShortIfs.$destroy(); }
    if (AllmanBraceStyle != null) { AllmanBraceStyle.$destroy(); }
  }
}

;
@Test
//<editor-fold defaultstate="collapsed" desc="clang::format::(anonymous namespace)::FormatTest_GNUBraceBreaking_Test::TestBody">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp", line = 9842,
 FQN="clang::format::(anonymous namespace)::FormatTest_GNUBraceBreaking_Test::TestBody", NM="_ZN5clang6format12_GLOBAL__N_132FormatTest_GNUBraceBreaking_Test8TestBodyEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp -nm=_ZN5clang6format12_GLOBAL__N_132FormatTest_GNUBraceBreaking_Test8TestBodyEv")
//</editor-fold>
public void test_GNUBraceBreaking() {
  if (markAsSkippedIfNeed(TestState.Successful)) { return; }
  FormatStyle GNUBraceStyle = null;
  try {
    GNUBraceStyle = getLLVMStyle();
    GNUBraceStyle.BreakBeforeBraces = FormatStyle.BraceBreakingStyle.BS_GNU;
    verifyFormat(new StringRef(/*KEEP_STR*/"namespace a\n{\nclass A\n{\n  void f()\n  {\n    int a;\n    {\n      int b;\n    }\n    if (true)\n      {\n        a();\n        b();\n      }\n  }\n  void g() { return; }\n}\n}"), 
        GNUBraceStyle);
    
    verifyFormat(new StringRef(/*KEEP_STR*/"void f()\n{\n  if (true)\n    {\n      a();\n    }\n  else if (false)\n    {\n      b();\n    }\n  else\n    {\n      c();\n    }\n}\n"), 
        GNUBraceStyle);
    
    verifyFormat(new StringRef(/*KEEP_STR*/"void f()\n{\n  for (int i = 0; i < 10; ++i)\n    {\n      a();\n    }\n  while (false)\n    {\n      b();\n    }\n  do\n    {\n      c();\n    }\n  while (false);\n}\n"), 
        GNUBraceStyle);
    
    verifyFormat(new StringRef(/*KEEP_STR*/"void f(int a)\n{\n  switch (a)\n    {\n    case 0:\n      break;\n    case 1:\n      {\n        break;\n      }\n    case 2:\n      {\n      }\n      break;\n    default:\n      break;\n    }\n}\n"), 
        GNUBraceStyle);
    
    verifyFormat(new StringRef(/*KEEP_STR*/"enum X\n{\n  Y = 0,\n}\n"), 
        GNUBraceStyle);
    
    verifyFormat(new StringRef(/*KEEP_STR*/"@interface BSApplicationController ()\n{\n@private\n  id _extraIvar;\n}\n@end\n"), 
        GNUBraceStyle);
    
    verifyFormat(new StringRef(/*KEEP_STR*/"#ifdef _DEBUG\nint foo(int i = 0)\n#else\nint foo(int i = 5)\n#endif\n{\n  return i;\n}"), 
        GNUBraceStyle);
    
    verifyFormat(new StringRef(/*KEEP_STR*/"void foo() {}\nvoid bar()\n#ifdef _DEBUG\n{\n  foo();\n}\n#else\n{\n}\n#endif"), 
        GNUBraceStyle);
    
    verifyFormat(new StringRef(/*KEEP_STR*/"void foobar() { int i = 5; }\n#ifdef _DEBUG\nvoid bar() {}\n#else\nvoid bar() { foobar(); }\n#endif"), 
        GNUBraceStyle);
  } finally {
    if (GNUBraceStyle != null) { GNUBraceStyle.$destroy(); }
  }
}

;
@Test
//<editor-fold defaultstate="collapsed" desc="clang::format::(anonymous namespace)::FormatTest_WebKitBraceBreaking_Test::TestBody">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp", line = 9966,
 FQN="clang::format::(anonymous namespace)::FormatTest_WebKitBraceBreaking_Test::TestBody", NM="_ZN5clang6format12_GLOBAL__N_135FormatTest_WebKitBraceBreaking_Test8TestBodyEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp -nm=_ZN5clang6format12_GLOBAL__N_135FormatTest_WebKitBraceBreaking_Test8TestBodyEv")
//</editor-fold>
public void test_WebKitBraceBreaking() {
  if (markAsSkippedIfNeed(TestState.Successful)) { return; }
  FormatStyle WebKitBraceStyle = null;
  try {
    WebKitBraceStyle = getLLVMStyle();
    WebKitBraceStyle.BreakBeforeBraces = FormatStyle.BraceBreakingStyle.BS_WebKit;
    verifyFormat(new StringRef(/*KEEP_STR*/"namespace a {\nclass A {\n  void f()\n  {\n    if (true) {\n      a();\n      b();\n    }\n  }\n  void g() { return; }\n};\nenum E {\n  A,\n  // foo\n  B,\n  C\n};\nstruct B {\n  int x;\n};\n}\n"), 
        WebKitBraceStyle);
    verifyFormat(new StringRef(/*KEEP_STR*/"struct S {\n  int Type;\n  union {\n    int x;\n    double y;\n  } Value;\n  class C {\n    MyFavoriteType Value;\n  } Class;\n};\n"), 
        WebKitBraceStyle);
  } finally {
    if (WebKitBraceStyle != null) { WebKitBraceStyle.$destroy(); }
  }
}

;
@Test
//<editor-fold defaultstate="collapsed" desc="clang::format::(anonymous namespace)::FormatTest_CatchExceptionReferenceBinding_Test::TestBody">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp", line = 10004,
 FQN="clang::format::(anonymous namespace)::FormatTest_CatchExceptionReferenceBinding_Test::TestBody", NM="_ZN5clang6format12_GLOBAL__N_146FormatTest_CatchExceptionReferenceBinding_Test8TestBodyEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp -nm=_ZN5clang6format12_GLOBAL__N_146FormatTest_CatchExceptionReferenceBinding_Test8TestBodyEv")
//</editor-fold>
public void test_CatchExceptionReferenceBinding() {
  if (markAsSkippedIfNeed(TestState.Successful)) { return; }
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    verifyFormat(new StringRef(/*KEEP_STR*/"void f() {\n  try {\n  } catch (const Exception &e) {\n  }\n}\n"), 
        $c$.track(getLLVMStyle())); $c$.clean();
  } finally {
    $c$.$destroy();
  }
}

;
@Test
//<editor-fold defaultstate="collapsed" desc="clang::format::(anonymous namespace)::FormatTest_UnderstandsPragmas_Test::TestBody">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp", line = 10013,
 FQN="clang::format::(anonymous namespace)::FormatTest_UnderstandsPragmas_Test::TestBody", NM="_ZN5clang6format12_GLOBAL__N_134FormatTest_UnderstandsPragmas_Test8TestBodyEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp -nm=_ZN5clang6format12_GLOBAL__N_134FormatTest_UnderstandsPragmas_Test8TestBodyEv")
//</editor-fold>
public void test_UnderstandsPragmas() {
  if (markAsSkippedIfNeed(TestState.Successful)) { return; }
  verifyFormat(new StringRef(/*KEEP_STR*/"#pragma omp reduction(| : var)"));
  verifyFormat(new StringRef(/*KEEP_STR*/"#pragma omp reduction(+ : var)"));
    EXPECT_EQ("#pragma mark Any non-hyphenated or hyphenated string (including parentheses).",format(new StringRef(/*KEEP_STR*/"#pragma    mark   Any non-hyphenated or hyphenated string (including parentheses).")));
}

;
@Test
//<editor-fold defaultstate="collapsed" desc="clang::format::(anonymous namespace)::FormatTest_UnderstandPragmaOption_Test::TestBody">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp", line = 10023,
 FQN="clang::format::(anonymous namespace)::FormatTest_UnderstandPragmaOption_Test::TestBody", NM="_ZN5clang6format12_GLOBAL__N_138FormatTest_UnderstandPragmaOption_Test8TestBodyEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp -nm=_ZN5clang6format12_GLOBAL__N_138FormatTest_UnderstandPragmaOption_Test8TestBodyEv")
//</editor-fold>
public void test_UnderstandPragmaOption() {
  if (markAsSkippedIfNeed(TestState.Successful)) { return; }
  verifyFormat(new StringRef(/*KEEP_STR*/"#pragma option -C -A"));
    EXPECT_EQ("#pragma option -C -A",format(new StringRef(/*KEEP_STR*/"#pragma    option   -C   -A")));
}

;
@Test
//<editor-fold defaultstate="collapsed" desc="clang::format::(anonymous namespace)::FormatTest_GetsPredefinedStyleByName_Test::TestBody">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp", line = 10034,
 FQN="clang::format::(anonymous namespace)::FormatTest_GetsPredefinedStyleByName_Test::TestBody", NM="_ZN5clang6format12_GLOBAL__N_141FormatTest_GetsPredefinedStyleByName_Test8TestBodyEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp -nm=_ZN5clang6format12_GLOBAL__N_141FormatTest_GetsPredefinedStyleByName_Test8TestBodyEv")
//</editor-fold>
public void test_GetsPredefinedStyleByName() {
  if (markAsSkippedIfNeed(TestState.Successful)) { return; }
  SmallVector<FormatStyle> Styles = null;
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    Styles/*J*/= new SmallVector<FormatStyle>(3, new FormatStyle());
    Styles.resize(3);
    
    $c$.clean(Styles.$at(0).$assignMove($c$.track(getLLVMStyle())));
    EXPECT_TRUE(getPredefinedStyle(new StringRef(/*KEEP_STR*/"LLVM"), FormatStyle.LanguageKind.LK_Cpp, /*AddrOf*/Styles.$at(1)));
    EXPECT_TRUE(getPredefinedStyle(new StringRef(/*KEEP_STR*/"lLvM"), FormatStyle.LanguageKind.LK_Cpp, /*AddrOf*/Styles.$at(2)));
    for (/*size_t*/int i = 1; $less_uint(i, Styles.size()); ++i)  {
    EXPECT_EQ(Styles.$at(0),Styles.$at(i));
    }
    
    $c$.clean(Styles.$at(0).$assignMove($c$.track(getGoogleStyle())));
    EXPECT_TRUE(getPredefinedStyle(new StringRef(/*KEEP_STR*/"Google"), FormatStyle.LanguageKind.LK_Cpp, /*AddrOf*/Styles.$at(1)));
    EXPECT_TRUE(getPredefinedStyle(new StringRef(/*KEEP_STR*/"gOOgle"), FormatStyle.LanguageKind.LK_Cpp, /*AddrOf*/Styles.$at(2)));
    for (/*size_t*/int i = 1; $less_uint(i, Styles.size()); ++i)  {
    EXPECT_EQ(Styles.$at(0),Styles.$at(i));
    }
    
    $c$.clean(Styles.$at(0).$assignMove($c$.track(FormatGlobals.getGoogleStyle(FormatStyle.LanguageKind.LK_JavaScript))));
    EXPECT_TRUE(getPredefinedStyle(new StringRef(/*KEEP_STR*/"Google"), FormatStyle.LanguageKind.LK_JavaScript, /*AddrOf*/Styles.$at(1)));
    EXPECT_TRUE(getPredefinedStyle(new StringRef(/*KEEP_STR*/"gOOgle"), FormatStyle.LanguageKind.LK_JavaScript, /*AddrOf*/Styles.$at(2)));
    for (/*size_t*/int i = 1; $less_uint(i, Styles.size()); ++i)  {
    EXPECT_EQ(Styles.$at(0),Styles.$at(i));
    }
    
    $c$.clean(Styles.$at(0).$assignMove($c$.track(getChromiumStyle(FormatStyle.LanguageKind.LK_Cpp))));
    EXPECT_TRUE(getPredefinedStyle(new StringRef(/*KEEP_STR*/"Chromium"), FormatStyle.LanguageKind.LK_Cpp, /*AddrOf*/Styles.$at(1)));
    EXPECT_TRUE(getPredefinedStyle(new StringRef(/*KEEP_STR*/"cHRoMiUM"), FormatStyle.LanguageKind.LK_Cpp, /*AddrOf*/Styles.$at(2)));
    for (/*size_t*/int i = 1; $less_uint(i, Styles.size()); ++i)  {
    EXPECT_EQ(Styles.$at(0),Styles.$at(i));
    }
    
    $c$.clean(Styles.$at(0).$assignMove($c$.track(getMozillaStyle())));
    EXPECT_TRUE(getPredefinedStyle(new StringRef(/*KEEP_STR*/"Mozilla"), FormatStyle.LanguageKind.LK_Cpp, /*AddrOf*/Styles.$at(1)));
    EXPECT_TRUE(getPredefinedStyle(new StringRef(/*KEEP_STR*/"moZILla"), FormatStyle.LanguageKind.LK_Cpp, /*AddrOf*/Styles.$at(2)));
    for (/*size_t*/int i = 1; $less_uint(i, Styles.size()); ++i)  {
    EXPECT_EQ(Styles.$at(0),Styles.$at(i));
    }
    
    $c$.clean(Styles.$at(0).$assignMove($c$.track(getWebKitStyle())));
    EXPECT_TRUE(getPredefinedStyle(new StringRef(/*KEEP_STR*/"WebKit"), FormatStyle.LanguageKind.LK_Cpp, /*AddrOf*/Styles.$at(1)));
    EXPECT_TRUE(getPredefinedStyle(new StringRef(/*KEEP_STR*/"wEbKit"), FormatStyle.LanguageKind.LK_Cpp, /*AddrOf*/Styles.$at(2)));
    for (/*size_t*/int i = 1; $less_uint(i, Styles.size()); ++i)  {
    EXPECT_EQ(Styles.$at(0),Styles.$at(i));
    }
    
    $c$.clean(Styles.$at(0).$assignMove($c$.track(getGNUStyle())));
    EXPECT_TRUE(getPredefinedStyle(new StringRef(/*KEEP_STR*/"GNU"), FormatStyle.LanguageKind.LK_Cpp, /*AddrOf*/Styles.$at(1)));
    EXPECT_TRUE(getPredefinedStyle(new StringRef(/*KEEP_STR*/"gnU"), FormatStyle.LanguageKind.LK_Cpp, /*AddrOf*/Styles.$at(2)));
    for (/*size_t*/int i = 1; $less_uint(i, Styles.size()); ++i)  {
    EXPECT_EQ(Styles.$at(0),Styles.$at(i));
    }
    EXPECT_FALSE(getPredefinedStyle(new StringRef(/*KEEP_STR*/"qwerty"), FormatStyle.LanguageKind.LK_Cpp, /*AddrOf*/Styles.$at(0)));
  } finally {
    if (Styles != null) { Styles.$destroy(); }
    $c$.$destroy();
  }
}

;
@Test
//<editor-fold defaultstate="collapsed" desc="clang::format::(anonymous namespace)::FormatTest_GetsCorrectBasedOnStyle_Test::TestBody">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp", line = 10078,
 FQN="clang::format::(anonymous namespace)::FormatTest_GetsCorrectBasedOnStyle_Test::TestBody", NM="_ZN5clang6format12_GLOBAL__N_139FormatTest_GetsCorrectBasedOnStyle_Test8TestBodyEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp -nm=_ZN5clang6format12_GLOBAL__N_139FormatTest_GetsCorrectBasedOnStyle_Test8TestBodyEv")
//</editor-fold>
public void test_GetsCorrectBasedOnStyle() {
  if (markAsSkippedIfNeed(TestState.Successful)) { return; }
  SmallVector<FormatStyle> Styles = null;
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    Styles/*J*/= new SmallVector<FormatStyle>(8, new FormatStyle());
    Styles.resize(2);
    
    $c$.clean(Styles.$at(0).$assignMove($c$.track(getGoogleStyle())));
    $c$.clean(Styles.$at(1).$assignMove($c$.track(getLLVMStyle())));
    EXPECT_EQ(0,parseConfiguration(new StringRef(/*KEEP_STR*/"BasedOnStyle: Google"), /*AddrOf*/Styles.$at(1)).value());
    for (/*size_t*/int i = 1; $less_uint(i, Styles.size()); ++i)  {
    EXPECT_EQ(Styles.$at(0),Styles.$at(i));
    }
    
    Styles.resize(5);
    $c$.clean(Styles.$at(0).$assignMove($c$.track(FormatGlobals.getGoogleStyle(FormatStyle.LanguageKind.LK_JavaScript))));
    $c$.clean(Styles.$at(1).$assignMove($c$.track(getLLVMStyle())));
    Styles.$at(1).Language = FormatStyle.LanguageKind.LK_JavaScript;
    EXPECT_EQ(0,parseConfiguration(new StringRef(/*KEEP_STR*/"BasedOnStyle: Google"), /*AddrOf*/Styles.$at(1)).value());
    
    $c$.clean(Styles.$at(2).$assignMove($c$.track(getLLVMStyle())));
    Styles.$at(2).Language = FormatStyle.LanguageKind.LK_JavaScript;
    EXPECT_EQ(0,parseConfiguration(new StringRef(/*KEEP_STR*/"Language: JavaScript\nBasedOnStyle: Google"), /*AddrOf*/Styles.$at(2)).value());
    
    $c$.clean(Styles.$at(3).$assignMove($c$.track(getLLVMStyle())));
    Styles.$at(3).Language = FormatStyle.LanguageKind.LK_JavaScript;
    EXPECT_EQ(0,parseConfiguration(new StringRef(/*KEEP_STR*/"BasedOnStyle: Google\nLanguage: JavaScript"), /*AddrOf*/Styles.$at(3)).value());
    
    $c$.clean(Styles.$at(4).$assignMove($c$.track(getLLVMStyle())));
    Styles.$at(4).Language = FormatStyle.LanguageKind.LK_JavaScript;
    EXPECT_EQ(0,parseConfiguration(new StringRef(/*KEEP_STR*/"---\nBasedOnStyle: LLVM\nIndentWidth: 123\n---\nBasedOnStyle: Google\nLanguage: JavaScript"), /*AddrOf*/Styles.$at(4)).value());
    for (/*size_t*/int i = 1; $less_uint(i, Styles.size()); ++i)  {
    EXPECT_EQ(Styles.$at(0),Styles.$at(i));
    }
  } finally {
    if (Styles != null) { Styles.$destroy(); }
    $c$.$destroy();
  }
}

private static class FieldAccessor<T> {
  final Object instance;
  final String fieldName;
  final Field f;
  public FieldAccessor(Object instance, String fieldName) {
    this.instance = instance;
    this.fieldName = fieldName;
    Class<?> cls = instance.getClass();
    try {
      f = cls.getField(fieldName);
    } catch (NoSuchFieldException | SecurityException | IllegalArgumentException ex) {
      final IllegalAccessError error = new IllegalAccessError(ex.getMessage());
      error.initCause(ex);
      throw error;
    }
  }

  public T $get() {
    try {
      return (T) f.get(instance);
    } catch (IllegalAccessException ex) { 
      final IllegalAccessError error = new IllegalAccessError(ex.getMessage());
      error.initCause(ex);
      throw error;
    }
  }

  public T $set(T value) {
    try {
      f.set(instance, value);
      return (T) f.get(instance);
    } catch (IllegalAccessException ex) { 
      final IllegalAccessError error = new IllegalAccessError(ex.getMessage());
      error.initCause(ex);
      throw error;
    }
  }    
  public String $name() {
    return fieldName;
  }    
}

@Converted(kind = Converted.Kind.MANUAL, source = "${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp", line = 10143)
private static void CHECK_PARSE(FormatStyle Style, String TEXT, String fieldName, Object VALUE) {
  FieldAccessor<Boolean> FIELD = new FieldAccessor<Boolean>(Style, fieldName);
  EXPECT_NE(VALUE, FIELD.$get());
  EXPECT_EQ(0, parseConfiguration(new StringRef(TEXT), Style).value());
  EXPECT_EQ(VALUE, FIELD.$get());
}

@Converted(kind = Converted.Kind.MANUAL, source = "${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp", line = 10120)
private static void CHECK_PARSE_BOOL_FIELD(FormatStyle Style, String fieldName, String CONFIG_NAME) {
  FieldAccessor<Boolean> FIELD = new FieldAccessor<Boolean>(Style, fieldName);
  FIELD.$set(false);
  EXPECT_EQ(0, parseConfiguration(new StringRef(CONFIG_NAME + ": true"), Style).value());
  EXPECT_TRUE(FIELD.$get());
  EXPECT_EQ(0, parseConfiguration(new StringRef(CONFIG_NAME + ": false"), Style).value());
  EXPECT_FALSE(FIELD.$get());
}

@Converted(kind = Converted.Kind.MANUAL, source = "${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp", line = 10127)
private static void CHECK_PARSE_BOOL(FormatStyle Style, String fieldName) {
  CHECK_PARSE_BOOL_FIELD(Style, fieldName, fieldName);
}

@Converted(kind = Converted.Kind.MANUAL, source = "${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp", line = 10129)
private static void CHECK_PARSE_NESTED_BOOL_FIELD(FormatStyle Style, String structName, String fieldName, String CONFIG_NAME) {
  FieldAccessor<Object> STRUCT = new FieldAccessor<Object>(Style, structName);
  FieldAccessor<Boolean> FIELD = new FieldAccessor<Boolean>(STRUCT.$get(), fieldName);
  EXPECT_EQ(0,
            parseConfiguration(new StringRef(STRUCT.$name() + ":\n  " + CONFIG_NAME + ": true"), Style)
                .value());
  EXPECT_TRUE(FIELD.$get());
  EXPECT_EQ(0,
            parseConfiguration(new StringRef(STRUCT.$name() + ":\n  " + CONFIG_NAME + ": false"), Style)
                .value());
  EXPECT_FALSE(FIELD.$get());
}

@Converted(kind = Converted.Kind.MANUAL, source = "${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp", line = 10140)
private static void CHECK_PARSE_NESTED_BOOL(FormatStyle Style, String structName, String fieldName) {
  CHECK_PARSE_NESTED_BOOL_FIELD(Style, structName, fieldName, fieldName);
}


@Test
//<editor-fold defaultstate="collapsed" desc="clang::format::(anonymous namespace)::FormatTest_ParsesConfigurationBools_Test::TestBody">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp", line = 10148,
 FQN="clang::format::(anonymous namespace)::FormatTest_ParsesConfigurationBools_Test::TestBody", NM="_ZN5clang6format12_GLOBAL__N_140FormatTest_ParsesConfigurationBools_Test8TestBodyEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp -nm=_ZN5clang6format12_GLOBAL__N_140FormatTest_ParsesConfigurationBools_Test8TestBodyEv")
//</editor-fold>
public void test_ParsesConfigurationBools() {
  if (markAsSkippedIfNeed(TestState.Successful)) { return; }
  FormatStyle Style = new FormatStyle(/*zero-init*/);
  Style.Language = FormatStyle.LanguageKind.LK_Cpp;
  CHECK_PARSE_BOOL(Style, "AlignEscapedNewlinesLeft");
  CHECK_PARSE_BOOL(Style, "AlignOperands");
  CHECK_PARSE_BOOL(Style, "AlignTrailingComments");
  CHECK_PARSE_BOOL(Style, "AlignConsecutiveAssignments");
  CHECK_PARSE_BOOL(Style, "AlignConsecutiveDeclarations");
  CHECK_PARSE_BOOL(Style, "AllowAllParametersOfDeclarationOnNextLine");
  CHECK_PARSE_BOOL(Style, "AllowShortBlocksOnASingleLine");
  CHECK_PARSE_BOOL(Style, "AllowShortCaseLabelsOnASingleLine");
  CHECK_PARSE_BOOL(Style, "AllowShortIfStatementsOnASingleLine");
  CHECK_PARSE_BOOL(Style, "AllowShortLoopsOnASingleLine");
  CHECK_PARSE_BOOL(Style, "AlwaysBreakTemplateDeclarations");
  CHECK_PARSE_BOOL(Style, "BinPackArguments");
  CHECK_PARSE_BOOL(Style, "BinPackParameters");
  CHECK_PARSE_BOOL(Style, "BreakAfterJavaFieldAnnotations");
  CHECK_PARSE_BOOL(Style, "BreakBeforeTernaryOperators");
  CHECK_PARSE_BOOL(Style, "BreakConstructorInitializersBeforeComma");
  CHECK_PARSE_BOOL(Style, "BreakStringLiterals");
  CHECK_PARSE_BOOL(Style, "ConstructorInitializerAllOnOneLineOrOnePerLine");
  CHECK_PARSE_BOOL(Style, "DerivePointerAlignment");
  CHECK_PARSE_BOOL_FIELD(Style, "DerivePointerAlignment", "DerivePointerBinding");
  
  CHECK_PARSE_BOOL(Style, "DisableFormat");
  CHECK_PARSE_BOOL(Style, "IndentCaseLabels");
  CHECK_PARSE_BOOL(Style, "IndentWrappedFunctionNames");
  CHECK_PARSE_BOOL(Style, "KeepEmptyLinesAtTheStartOfBlocks");
  CHECK_PARSE_BOOL(Style, "ObjCSpaceAfterProperty");
  CHECK_PARSE_BOOL(Style, "ObjCSpaceBeforeProtocolList");
  CHECK_PARSE_BOOL(Style, "Cpp11BracedListStyle");
  CHECK_PARSE_BOOL(Style, "ReflowComments");
  CHECK_PARSE_BOOL(Style, "SortIncludes");
  CHECK_PARSE_BOOL(Style, "SpacesInParentheses");
  CHECK_PARSE_BOOL(Style, "SpacesInSquareBrackets");
  CHECK_PARSE_BOOL(Style, "SpacesInAngles");
  CHECK_PARSE_BOOL(Style, "SpaceInEmptyParentheses");
  CHECK_PARSE_BOOL(Style, "SpacesInContainerLiterals");
  CHECK_PARSE_BOOL(Style, "SpacesInCStyleCastParentheses");
  CHECK_PARSE_BOOL(Style, "SpaceAfterCStyleCast");
  CHECK_PARSE_BOOL(Style, "SpaceBeforeAssignmentOperators");

  CHECK_PARSE_NESTED_BOOL(Style, "BraceWrapping", "AfterClass");
  CHECK_PARSE_NESTED_BOOL(Style, "BraceWrapping", "AfterControlStatement");
  CHECK_PARSE_NESTED_BOOL(Style, "BraceWrapping", "AfterEnum");
  CHECK_PARSE_NESTED_BOOL(Style, "BraceWrapping", "AfterFunction");
  CHECK_PARSE_NESTED_BOOL(Style, "BraceWrapping", "AfterNamespace");
  CHECK_PARSE_NESTED_BOOL(Style, "BraceWrapping", "AfterObjCDeclaration");
  CHECK_PARSE_NESTED_BOOL(Style, "BraceWrapping", "AfterStruct");
  CHECK_PARSE_NESTED_BOOL(Style, "BraceWrapping", "AfterUnion");
  CHECK_PARSE_NESTED_BOOL(Style, "BraceWrapping", "BeforeCatch");
  CHECK_PARSE_NESTED_BOOL(Style, "BraceWrapping", "BeforeElse");
  CHECK_PARSE_NESTED_BOOL(Style, "BraceWrapping", "IndentBraces");
}

@Test
//<editor-fold defaultstate="collapsed" desc="clang::format::(anonymous namespace)::FormatTest_ParsesConfiguration_Test::TestBody">
@Converted(kind = Converted.Kind.MANUAL,
 source = "${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp", line = 10204,
 FQN="clang::format::(anonymous namespace)::FormatTest_ParsesConfiguration_Test::TestBody", NM="_ZN5clang6format12_GLOBAL__N_135FormatTest_ParsesConfiguration_Test8TestBodyEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp -nm=_ZN5clang6format12_GLOBAL__N_135FormatTest_ParsesConfiguration_Test8TestBodyEv")
//</editor-fold>
public void test_ParsesConfiguration() {
  if (markAsSkippedIfNeed(TestState.Successful)) { return; }
  FormatStyle BaseStyle = null;
  std.vectorString BoostForeach = null;
  std.vectorString BoostAndQForeach = null;
  std.vector<FormatStyle.IncludeCategory> ExpectedCategories = null;
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    FormatStyle Style = new FormatStyle(/*zero-init*/);
    Style.Language = FormatStyle.LanguageKind.LK_Cpp;
    CHECK_PARSE(Style, "AccessModifierOffset: -1234", "AccessModifierOffset", -1234);
    CHECK_PARSE(Style, "ConstructorInitializerIndentWidth: 1234", 
                "ConstructorInitializerIndentWidth", 1234);
    CHECK_PARSE(Style, "ObjCBlockIndentWidth: 1234", "ObjCBlockIndentWidth", 1234);
    CHECK_PARSE(Style, "ColumnLimit: 1234", "ColumnLimit", 1234);
    CHECK_PARSE(Style, "MaxEmptyLinesToKeep: 1234", "MaxEmptyLinesToKeep", 1234);
    CHECK_PARSE(Style, "PenaltyBreakBeforeFirstCallParameter: 1234", 
                "PenaltyBreakBeforeFirstCallParameter", 1234);
    CHECK_PARSE(Style, "PenaltyExcessCharacter: 1234", "PenaltyExcessCharacter", 1234);
    CHECK_PARSE(Style, "PenaltyReturnTypeOnItsOwnLine: 1234", 
                "PenaltyReturnTypeOnItsOwnLine", 1234);
    CHECK_PARSE(Style, "SpacesBeforeTrailingComments: 1234", 
                "SpacesBeforeTrailingComments", 1234);
    CHECK_PARSE(Style, "IndentWidth: 32", "IndentWidth", 32);
    CHECK_PARSE(Style, "ContinuationIndentWidth: 11", "ContinuationIndentWidth", 11);
    CHECK_PARSE(Style, "CommentPragmas: '// abc$'", "CommentPragmas", "// abc$");
    
    Style.PointerAlignment = FormatStyle.PointerAlignmentStyle.PAS_Middle;
    CHECK_PARSE(Style, "PointerAlignment: Left", "PointerAlignment", FormatStyle.PointerAlignmentStyle.PAS_Left);
    CHECK_PARSE(Style, "PointerAlignment: Right", "PointerAlignment", FormatStyle.PointerAlignmentStyle.PAS_Right);
    CHECK_PARSE(Style, "PointerAlignment: Middle", "PointerAlignment", FormatStyle.PointerAlignmentStyle.PAS_Middle);
    // For backward compatibility:
    CHECK_PARSE(Style, "PointerBindsToType: Left", "PointerAlignment", FormatStyle.PointerAlignmentStyle.PAS_Left);
    CHECK_PARSE(Style, "PointerBindsToType: Right", "PointerAlignment", FormatStyle.PointerAlignmentStyle.PAS_Right);
    CHECK_PARSE(Style, "PointerBindsToType: Middle", "PointerAlignment", FormatStyle.PointerAlignmentStyle.PAS_Middle);
    
    Style.Standard = FormatStyle.LanguageStandard.LS_Auto;
    CHECK_PARSE(Style, "Standard: Cpp03", "Standard", FormatStyle.LanguageStandard.LS_Cpp03);
    CHECK_PARSE(Style, "Standard: Cpp11", "Standard", FormatStyle.LanguageStandard.LS_Cpp11);
    CHECK_PARSE(Style, "Standard: C++03", "Standard", FormatStyle.LanguageStandard.LS_Cpp03);
    CHECK_PARSE(Style, "Standard: C++11", "Standard", FormatStyle.LanguageStandard.LS_Cpp11);
    CHECK_PARSE(Style, "Standard: Auto", "Standard", FormatStyle.LanguageStandard.LS_Auto);
    
    Style.BreakBeforeBinaryOperators = FormatStyle.BinaryOperatorStyle.BOS_All;
    CHECK_PARSE(Style, "BreakBeforeBinaryOperators: NonAssignment",
                "BreakBeforeBinaryOperators", FormatStyle.BinaryOperatorStyle.BOS_NonAssignment);
    CHECK_PARSE(Style, "BreakBeforeBinaryOperators: None", "BreakBeforeBinaryOperators",
                FormatStyle.BinaryOperatorStyle.BOS_None);
    CHECK_PARSE(Style, "BreakBeforeBinaryOperators: All", "BreakBeforeBinaryOperators",
                FormatStyle.BinaryOperatorStyle.BOS_All);
    // For backward compatibility:
    CHECK_PARSE(Style, "BreakBeforeBinaryOperators: false", "BreakBeforeBinaryOperators",
                FormatStyle.BinaryOperatorStyle.BOS_None);
    CHECK_PARSE(Style, "BreakBeforeBinaryOperators: true", "BreakBeforeBinaryOperators",
                FormatStyle.BinaryOperatorStyle.BOS_All);
    
    Style.AlignAfterOpenBracket = FormatStyle.BracketAlignmentStyle.BAS_AlwaysBreak;
    CHECK_PARSE(Style, "AlignAfterOpenBracket: Align", "AlignAfterOpenBracket",
                FormatStyle.BracketAlignmentStyle.BAS_Align);
    CHECK_PARSE(Style, "AlignAfterOpenBracket: DontAlign", "AlignAfterOpenBracket",
                FormatStyle.BracketAlignmentStyle.BAS_DontAlign);
    CHECK_PARSE(Style, "AlignAfterOpenBracket: AlwaysBreak", "AlignAfterOpenBracket",
                FormatStyle.BracketAlignmentStyle.BAS_AlwaysBreak);
    // For backward compatibility:
    CHECK_PARSE(Style, "AlignAfterOpenBracket: false", "AlignAfterOpenBracket",
                FormatStyle.BracketAlignmentStyle.BAS_DontAlign);
    CHECK_PARSE(Style, "AlignAfterOpenBracket: true", "AlignAfterOpenBracket",
                FormatStyle.BracketAlignmentStyle.BAS_Align);
    
    Style.UseTab = FormatStyle.UseTabStyle.UT_ForIndentation;
    CHECK_PARSE(Style, "UseTab: Never", "UseTab", FormatStyle.UseTabStyle.UT_Never);
    CHECK_PARSE(Style, "UseTab: ForIndentation", "UseTab", FormatStyle.UseTabStyle.UT_ForIndentation);
    CHECK_PARSE(Style, "UseTab: Always", "UseTab", FormatStyle.UseTabStyle.UT_Always);
    CHECK_PARSE(Style, "UseTab: ForContinuationAndIndentation", "UseTab",
                FormatStyle.UseTabStyle.UT_ForContinuationAndIndentation);
    // For backward compatibility:
    CHECK_PARSE(Style, "UseTab: false", "UseTab", FormatStyle.UseTabStyle.UT_Never);
    CHECK_PARSE(Style, "UseTab: true", "UseTab", FormatStyle.UseTabStyle.UT_Always);
    
    Style.AllowShortFunctionsOnASingleLine = FormatStyle.ShortFunctionStyle.SFS_Inline;
    CHECK_PARSE(Style, "AllowShortFunctionsOnASingleLine: None",
                "AllowShortFunctionsOnASingleLine", FormatStyle.ShortFunctionStyle.SFS_None);
    CHECK_PARSE(Style, "AllowShortFunctionsOnASingleLine: Inline",
                "AllowShortFunctionsOnASingleLine", FormatStyle.ShortFunctionStyle.SFS_Inline);
    CHECK_PARSE(Style, "AllowShortFunctionsOnASingleLine: Empty",
                "AllowShortFunctionsOnASingleLine", FormatStyle.ShortFunctionStyle.SFS_Empty);
    CHECK_PARSE(Style, "AllowShortFunctionsOnASingleLine: All",
                "AllowShortFunctionsOnASingleLine", FormatStyle.ShortFunctionStyle.SFS_All);
    // For backward compatibility:
    CHECK_PARSE(Style, "AllowShortFunctionsOnASingleLine: false",
                "AllowShortFunctionsOnASingleLine", FormatStyle.ShortFunctionStyle.SFS_None);
    CHECK_PARSE(Style, "AllowShortFunctionsOnASingleLine: true",
                "AllowShortFunctionsOnASingleLine", FormatStyle.ShortFunctionStyle.SFS_All);
    
    Style.SpaceBeforeParens = FormatStyle.SpaceBeforeParensOptions.SBPO_Always;
    CHECK_PARSE(Style, "SpaceBeforeParens: Never", "SpaceBeforeParens",
                FormatStyle.SpaceBeforeParensOptions.SBPO_Never);
    CHECK_PARSE(Style, "SpaceBeforeParens: Always", "SpaceBeforeParens",
                FormatStyle.SpaceBeforeParensOptions.SBPO_Always);
    CHECK_PARSE(Style, "SpaceBeforeParens: ControlStatements", "SpaceBeforeParens",
                FormatStyle.SpaceBeforeParensOptions.SBPO_ControlStatements);
    // For backward compatibility:
    CHECK_PARSE(Style, "SpaceAfterControlStatementKeyword: false", "SpaceBeforeParens",
                FormatStyle.SpaceBeforeParensOptions.SBPO_Never);
    CHECK_PARSE(Style, "SpaceAfterControlStatementKeyword: true", "SpaceBeforeParens",
                FormatStyle.SpaceBeforeParensOptions.SBPO_ControlStatements);
    
    Style.ColumnLimit = 123;
    BaseStyle = getLLVMStyle();
    CHECK_PARSE(Style, "BasedOnStyle: LLVM", "ColumnLimit", BaseStyle.ColumnLimit);
    CHECK_PARSE(Style, "BasedOnStyle: LLVM\nColumnLimit: 1234", "ColumnLimit", 1234);
    
    Style.BreakBeforeBraces = FormatStyle.BraceBreakingStyle.BS_Stroustrup;
    CHECK_PARSE(Style, "BreakBeforeBraces: Attach", "BreakBeforeBraces",
                FormatStyle.BraceBreakingStyle.BS_Attach);
    CHECK_PARSE(Style, "BreakBeforeBraces: Linux", "BreakBeforeBraces",
                FormatStyle.BraceBreakingStyle.BS_Linux);
    CHECK_PARSE(Style, "BreakBeforeBraces: Mozilla", "BreakBeforeBraces",
                FormatStyle.BraceBreakingStyle.BS_Mozilla);
    CHECK_PARSE(Style, "BreakBeforeBraces: Stroustrup", "BreakBeforeBraces",
                FormatStyle.BraceBreakingStyle.BS_Stroustrup);
    CHECK_PARSE(Style, "BreakBeforeBraces: Allman", "BreakBeforeBraces",
                FormatStyle.BraceBreakingStyle.BS_Allman);
    CHECK_PARSE(Style, "BreakBeforeBraces: GNU", "BreakBeforeBraces", FormatStyle.BraceBreakingStyle.BS_GNU);
    CHECK_PARSE(Style, "BreakBeforeBraces: WebKit", "BreakBeforeBraces",
                FormatStyle.BraceBreakingStyle.BS_WebKit);
    CHECK_PARSE(Style, "BreakBeforeBraces: Custom", "BreakBeforeBraces",
                FormatStyle.BraceBreakingStyle.BS_Custom);
    
    Style.AlwaysBreakAfterReturnType = FormatStyle.ReturnTypeBreakingStyle.RTBS_All;
    CHECK_PARSE(Style, "AlwaysBreakAfterReturnType: None", "AlwaysBreakAfterReturnType",
                FormatStyle.ReturnTypeBreakingStyle.RTBS_None);
    CHECK_PARSE(Style, "AlwaysBreakAfterReturnType: All", "AlwaysBreakAfterReturnType",
                FormatStyle.ReturnTypeBreakingStyle.RTBS_All);
    CHECK_PARSE(Style, "AlwaysBreakAfterReturnType: TopLevel",
                "AlwaysBreakAfterReturnType", FormatStyle.ReturnTypeBreakingStyle.RTBS_TopLevel);
    CHECK_PARSE(Style, "AlwaysBreakAfterReturnType: AllDefinitions",
                "AlwaysBreakAfterReturnType", FormatStyle.ReturnTypeBreakingStyle.RTBS_AllDefinitions);
    CHECK_PARSE(Style, "AlwaysBreakAfterReturnType: TopLevelDefinitions",
                "AlwaysBreakAfterReturnType",
                FormatStyle.ReturnTypeBreakingStyle.RTBS_TopLevelDefinitions);
    
    Style.AlwaysBreakAfterDefinitionReturnType = FormatStyle.DefinitionReturnTypeBreakingStyle.DRTBS_All;
    CHECK_PARSE(Style, "AlwaysBreakAfterDefinitionReturnType: None",
                "AlwaysBreakAfterDefinitionReturnType", FormatStyle.DefinitionReturnTypeBreakingStyle.DRTBS_None);
    CHECK_PARSE(Style, "AlwaysBreakAfterDefinitionReturnType: All",
                "AlwaysBreakAfterDefinitionReturnType", FormatStyle.DefinitionReturnTypeBreakingStyle.DRTBS_All);
    CHECK_PARSE(Style, "AlwaysBreakAfterDefinitionReturnType: TopLevel",
                "AlwaysBreakAfterDefinitionReturnType",
                FormatStyle.DefinitionReturnTypeBreakingStyle.DRTBS_TopLevel);
    
    Style.NamespaceIndentation = FormatStyle.NamespaceIndentationKind.NI_All;
    CHECK_PARSE(Style, "NamespaceIndentation: None", "NamespaceIndentation",
                FormatStyle.NamespaceIndentationKind.NI_None);
    CHECK_PARSE(Style, "NamespaceIndentation: Inner", "NamespaceIndentation",
                FormatStyle.NamespaceIndentationKind.NI_Inner);
    CHECK_PARSE(Style, "NamespaceIndentation: All", "NamespaceIndentation",
                FormatStyle.NamespaceIndentationKind.NI_All);
    
    // FIXME: This is required because parsing a configuration simply overwrites
    // the first N elements of the list instead of resetting it.
    Style.ForEachMacros.clear();
    BoostForeach/*J*/= new std.vectorString(std.string.EMPTY);
    BoostForeach.push_back_T$RR(new std.string(JD$T$C$P_T2$C$R.INSTANCE, /*KEEP_STR*/"BOOST_FOREACH"));
    CHECK_PARSE(Style, "ForEachMacros: [BOOST_FOREACH]", "ForEachMacros", BoostForeach);
    BoostAndQForeach/*J*/= new std.vectorString(std.string.EMPTY);
    BoostAndQForeach.push_back_T$RR(new std.string(JD$T$C$P_T2$C$R.INSTANCE, /*KEEP_STR*/"BOOST_FOREACH"));
    BoostAndQForeach.push_back_T$RR(new std.string(JD$T$C$P_T2$C$R.INSTANCE, /*KEEP_STR*/"Q_FOREACH"));
    CHECK_PARSE(Style, "ForEachMacros: [BOOST_FOREACH, Q_FOREACH]", "ForEachMacros",
                BoostAndQForeach);
    
    Style.IncludeCategories.clear();
    ExpectedCategories = $c$.clean(/*{ */new std.vector<FormatStyle.IncludeCategory>($c$.track(new /*const*/ FormatStyle.IncludeCategory [/*2*/] {
          new FormatStyle.IncludeCategory($("abc/.*"), 2), 
          new FormatStyle.IncludeCategory($DOT_STAR, 1)}), new FormatStyle.IncludeCategory())/* }*/);
    CHECK_PARSE(Style, "IncludeCategories:\n" +
                "  - Regex: abc/.*\n" +
                "    Priority: 2\n" +
                "  - Regex: .*\n" +
                "    Priority: 1",
                "IncludeCategories", ExpectedCategories);
    CHECK_PARSE(Style, "IncludeIsMainRegex: 'abc$'", "IncludeIsMainRegex", "abc$");
  } finally {
    if (ExpectedCategories != null) { ExpectedCategories.$destroy(); }
    if (BoostAndQForeach != null) { BoostAndQForeach.$destroy(); }
    if (BoostForeach != null) { BoostForeach.$destroy(); }
    if (BaseStyle != null) { BaseStyle.$destroy(); }
    $c$.$destroy();
  }
}

;
@Test
//<editor-fold defaultstate="collapsed" desc="clang::format::(anonymous namespace)::FormatTest_ParsesConfigurationWithLanguages_Test::TestBody">
@Converted(kind = Converted.Kind.MANUAL,
 source = "${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp", line = 10386,
 FQN="clang::format::(anonymous namespace)::FormatTest_ParsesConfigurationWithLanguages_Test::TestBody", NM="_ZN5clang6format12_GLOBAL__N_148FormatTest_ParsesConfigurationWithLanguages_Test8TestBodyEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp -nm=_ZN5clang6format12_GLOBAL__N_148FormatTest_ParsesConfigurationWithLanguages_Test8TestBodyEv")
//</editor-fold>
public void test_ParsesConfigurationWithLanguages() {
  if (markAsSkippedIfNeed(TestState.Successful)) { return; }
  FormatStyle Style = new FormatStyle(/*zero-init*/);
  Style.Language = FormatStyle.LanguageKind.LK_Cpp;
  CHECK_PARSE(Style, "Language: Cpp\n" +
              "IndentWidth: 12",
              "IndentWidth", 12);
  EXPECT_EQ(parseConfiguration(new StringRef(/*KEEP_STR*/"Language: JavaScript\nIndentWidth: 34"), /*AddrOf*/Style),ParseError.Unsuitable);
  EXPECT_EQ(12/*U*/,Style.IndentWidth);
  CHECK_PARSE(Style, "IndentWidth: 56", "IndentWidth", 56);
  EXPECT_EQ(FormatStyle.LanguageKind.LK_Cpp,Style.Language);
  
  Style.Language = FormatStyle.LanguageKind.LK_JavaScript;
  CHECK_PARSE(Style, "Language: JavaScript\n" +
              "IndentWidth: 12",
              "IndentWidth", 12);
  CHECK_PARSE(Style, "IndentWidth: 23", "IndentWidth", 23);
  EXPECT_EQ(parseConfiguration(new StringRef(/*KEEP_STR*/"Language: Cpp\nIndentWidth: 34"), /*AddrOf*/Style),ParseError.Unsuitable);
  EXPECT_EQ(23/*U*/,Style.IndentWidth);
  CHECK_PARSE(Style, "IndentWidth: 56", "IndentWidth", 56);
  EXPECT_EQ(FormatStyle.LanguageKind.LK_JavaScript,Style.Language);
  CHECK_PARSE(Style, "BasedOnStyle: LLVM\n" +
              "IndentWidth: 67",
              "IndentWidth", 67);

  CHECK_PARSE(Style, "---\n" +
              "Language: JavaScript\n" +
              "IndentWidth: 12\n" +
              "---\n" +
              "Language: Cpp\n" +
              "IndentWidth: 34\n" +
              "...\n",
              "IndentWidth", 12);
  
  Style.Language = FormatStyle.LanguageKind.LK_Cpp;
  CHECK_PARSE(Style, "---\n" +
              "Language: JavaScript\n" +
              "IndentWidth: 12\n" +
              "---\n" +
              "Language: Cpp\n" +
              "IndentWidth: 34\n" +
              "...\n",
              "IndentWidth", 34);
  CHECK_PARSE(Style, "---\n" +
              "IndentWidth: 78\n" +
              "---\n" +
              "Language: JavaScript\n" +
              "IndentWidth: 56\n" +
              "...\n",
              "IndentWidth", 78);
  
  Style.ColumnLimit = 123;
  Style.IndentWidth = 234;
  Style.BreakBeforeBraces = FormatStyle.BraceBreakingStyle.BS_Linux;
  Style.TabWidth = 345;
    EXPECT_FALSE((parseConfiguration(new StringRef(/*KEEP_STR*/"---\nIndentWidth: 456\nBreakBeforeBraces: Allman\n---\nLanguage: JavaScript\nIndentWidth: 111\nTabWidth: 111\n---\nLanguage: Cpp\nBreakBeforeBraces: Stroustrup\nTabWidth: 789\n...\n"), /*AddrOf*/Style)).$bool());
    EXPECT_EQ(123/*U*/,Style.ColumnLimit);
    EXPECT_EQ(456/*U*/,Style.IndentWidth);
    EXPECT_EQ(FormatStyle.BraceBreakingStyle.BS_Stroustrup,Style.BreakBeforeBraces);
    EXPECT_EQ(789/*U*/,Style.TabWidth);
    EXPECT_EQ(parseConfiguration(new StringRef(/*KEEP_STR*/"---\nLanguage: JavaScript\nIndentWidth: 56\n---\nIndentWidth: 78\n...\n"), /*AddrOf*/Style),ParseError.Error);
    EXPECT_EQ(parseConfiguration(new StringRef(/*KEEP_STR*/"---\nLanguage: JavaScript\nIndentWidth: 56\n---\nLanguage: JavaScript\nIndentWidth: 78\n...\n"), /*AddrOf*/Style),ParseError.Error);
    EXPECT_EQ(FormatStyle.LanguageKind.LK_Cpp,Style.Language);
}

;
@Test
//<editor-fold defaultstate="collapsed" desc="clang::format::(anonymous namespace)::FormatTest_UsesLanguageForBasedOnStyle_Test::TestBody">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp", line = 10488,
 FQN="clang::format::(anonymous namespace)::FormatTest_UsesLanguageForBasedOnStyle_Test::TestBody", NM="_ZN5clang6format12_GLOBAL__N_143FormatTest_UsesLanguageForBasedOnStyle_Test8TestBodyEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp -nm=_ZN5clang6format12_GLOBAL__N_143FormatTest_UsesLanguageForBasedOnStyle_Test8TestBodyEv")
//</editor-fold>
public void test_UsesLanguageForBasedOnStyle() {
  if (markAsSkippedIfNeed(TestState.Successful)) { return; }
  FormatStyle Style = new FormatStyle(/*zero-init*/);
  Style.Language = FormatStyle.LanguageKind.LK_JavaScript;
  Style.BreakBeforeTernaryOperators = true;
    EXPECT_EQ(0,parseConfiguration(new StringRef(/*KEEP_STR*/"BasedOnStyle: Google"), /*AddrOf*/Style).value());
    EXPECT_FALSE((Style.BreakBeforeTernaryOperators));
  
  Style.BreakBeforeTernaryOperators = true;
    EXPECT_EQ(0,parseConfiguration(new StringRef(/*KEEP_STR*/"---\nBasedOnStyle: Google\n---\nLanguage: JavaScript\nIndentWidth: 76\n...\n"), /*AddrOf*/Style).value());
    EXPECT_FALSE((Style.BreakBeforeTernaryOperators));
    EXPECT_EQ(76/*U*/,Style.IndentWidth);
    EXPECT_EQ(FormatStyle.LanguageKind.LK_JavaScript,Style.Language);
}

;
@Test
//<editor-fold defaultstate="collapsed" desc="clang::format::(anonymous namespace)::FormatTest_ConfigurationRoundTripTest_Test::TestBody">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp", line = 10509,
 FQN="clang::format::(anonymous namespace)::FormatTest_ConfigurationRoundTripTest_Test::TestBody", NM="_ZN5clang6format12_GLOBAL__N_142FormatTest_ConfigurationRoundTripTest_Test8TestBodyEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp -nm=_ZN5clang6format12_GLOBAL__N_142FormatTest_ConfigurationRoundTripTest_Test8TestBodyEv")
//</editor-fold>
public void test_ConfigurationRoundTripTest() {
  if (markAsSkippedIfNeed(TestState.Successful)) { return; }
  FormatStyle Style = null;
  try {
    Style = getLLVMStyle();
    std.string YAML = configurationAsText(Style);
    FormatStyle ParsedStyle = new FormatStyle(/*zero-init*/);
    ParsedStyle.Language = FormatStyle.LanguageKind.LK_Cpp;
    EXPECT_EQ(0,parseConfiguration(new StringRef(YAML), /*AddrOf*/ParsedStyle).value());
    EXPECT_EQ(Style,ParsedStyle);
  } finally {
    if (Style != null) { Style.$destroy(); }
  }
}

;
@Test
//<editor-fold defaultstate="collapsed" desc="clang::format::(anonymous namespace)::FormatTest_WorksFor8bitEncodings_Test::TestBody">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp", line = 10518,
 FQN="clang::format::(anonymous namespace)::FormatTest_WorksFor8bitEncodings_Test::TestBody", NM="_ZN5clang6format12_GLOBAL__N_137FormatTest_WorksFor8bitEncodings_Test8TestBodyEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp -nm=_ZN5clang6format12_GLOBAL__N_137FormatTest_WorksFor8bitEncodings_Test8TestBodyEv")
//</editor-fold>
public void test_WorksFor8bitEncodings() {
  if (markAsSkippedIfNeed(TestState.Successful)) { return; }
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    EXPECT_EQ("\"\316\344\355\340\346\344\373 \342 \"\n\"\361\362\363\344\270\355\363\376 \"\n\"\347\350\354\355\376\376 \"\n\"\357\356\360\363...\"",$c$.clean(format(new StringRef(/*KEEP_STR*/"\"\316\344\355\340\346\344\373 \342 \361\362\363\344\270\355\363\376 \347\350\354\355\376\376 \357\356\360\363...\""), $c$.track(getLLVMStyleWithColumns(12)))));
  } finally {
    $c$.$destroy();
  }
}

;
@Test
//<editor-fold defaultstate="collapsed" desc="clang::format::(anonymous namespace)::FormatTest_HandlesUTF8BOM_Test::TestBody">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp", line = 10529,
 FQN="clang::format::(anonymous namespace)::FormatTest_HandlesUTF8BOM_Test::TestBody", NM="_ZN5clang6format12_GLOBAL__N_130FormatTest_HandlesUTF8BOM_Test8TestBodyEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp -nm=_ZN5clang6format12_GLOBAL__N_130FormatTest_HandlesUTF8BOM_Test8TestBodyEv")
//</editor-fold>
public void test_HandlesUTF8BOM() {
  if (markAsSkippedIfNeed(TestState.Successful)) { return; }
    EXPECT_EQ("\357\273\277",format(new StringRef(/*KEEP_STR*/"\357\273\277")));
    EXPECT_EQ("\357\273\277#include <iostream>",format(new StringRef(/*KEEP_STR*/"\357\273\277#include <iostream>")));
    EXPECT_EQ("\357\273\277\n#include <iostream>",format(new StringRef(/*KEEP_STR*/"\357\273\277\n#include <iostream>")));
}

;
@Test
//<editor-fold defaultstate="collapsed" desc="clang::format::(anonymous namespace)::FormatTest_CountsUTF8CharactersProperly_Test::TestBody">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp", line = 10540,
 FQN="clang::format::(anonymous namespace)::FormatTest_CountsUTF8CharactersProperly_Test::TestBody", NM="_ZN5clang6format12_GLOBAL__N_144FormatTest_CountsUTF8CharactersProperly_Test8TestBodyEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp -nm=_ZN5clang6format12_GLOBAL__N_144FormatTest_CountsUTF8CharactersProperly_Test8TestBodyEv")
//</editor-fold>
public void test_CountsUTF8CharactersProperly() {
  if (markAsSkippedIfNeed(TestState.Successful)) { return; }
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    verifyFormat(new StringRef(/*KEEP_STR*/"\"\320\236\320\264\320\275\320\260\320\266\320\264\321\213 \320\262 \321\201\321\202\321\203\320\264\321\221\320\275\321\203\321\216 \320\267\320\270\320\274\320\275\321\216\321\216 \320\277\320\276\321\200\321\203...\""), 
        $c$.track(getLLVMStyleWithColumns(35))); $c$.clean();
    verifyFormat(new StringRef(/*KEEP_STR*/"\"\344\270\200 \344\272\214 \344\270\211 \345\233\233 \344\272\224 \345\205\255 \344\270\203 \345\205\253 \344\271\235 \345\215\201\""), 
        $c$.track(getLLVMStyleWithColumns(31))); $c$.clean();
    verifyFormat(new StringRef(/*KEEP_STR*/"// \320\236\320\264\320\275\320\260\320\266\320\264\321\213 \320\262 \321\201\321\202\321\203\320\264\321\221\320\275\321\203\321\216 \320\267\320\270\320\274\320\275\321\216\321\216 \320\277\320\276\321\200\321\203..."), 
        $c$.track(getLLVMStyleWithColumns(36))); $c$.clean();
    verifyFormat(new StringRef(/*KEEP_STR*/"// \344\270\200 \344\272\214 \344\270\211 \345\233\233 \344\272\224 \345\205\255 \344\270\203 \345\205\253 \344\271\235 \345\215\201"), $c$.track(getLLVMStyleWithColumns(32))); $c$.clean();
    verifyFormat(new StringRef(/*KEEP_STR*/"/* \320\236\320\264\320\275\320\260\320\266\320\264\321\213 \320\262 \321\201\321\202\321\203\320\264\321\221\320\275\321\203\321\216 \320\267\320\270\320\274\320\275\321\216\321\216 \320\277\320\276\321\200\321\203... */"), 
        $c$.track(getLLVMStyleWithColumns(39))); $c$.clean();
    verifyFormat(new StringRef(/*KEEP_STR*/"/* \344\270\200 \344\272\214 \344\270\211 \345\233\233 \344\272\224 \345\205\255 \344\270\203 \345\205\253 \344\271\235 \345\215\201 */"), 
        $c$.track(getLLVMStyleWithColumns(35))); $c$.clean();
  } finally {
    $c$.$destroy();
  }
}

;
@Test
//<editor-fold defaultstate="collapsed" desc="clang::format::(anonymous namespace)::FormatTest_SplitsUTF8Strings_Test::TestBody">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp", line = 10554,
 FQN="clang::format::(anonymous namespace)::FormatTest_SplitsUTF8Strings_Test::TestBody", NM="_ZN5clang6format12_GLOBAL__N_133FormatTest_SplitsUTF8Strings_Test8TestBodyEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp -nm=_ZN5clang6format12_GLOBAL__N_133FormatTest_SplitsUTF8Strings_Test8TestBodyEv")
//</editor-fold>
public void test_SplitsUTF8Strings() {
  if (markAsSkippedIfNeed(TestState.Successful)) { return; }
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    // Non-printable characters' width is currently considered to be the length in
    // bytes in UTF8. The characters can be displayed in very different manner
    // (zero-width, single width with a substitution glyph, expanded to their code
    // (e.g. "<8d>"), so there's no single correct way to handle them.
    EXPECT_EQ("\"aaaa\303\204\"\n\"\302\215\";",$c$.clean(format(new StringRef(/*KEEP_STR*/"\"aaaa\303\204\302\215\";"), $c$.track(getLLVMStyleWithColumns(10)))));
    EXPECT_EQ("\"aaaaaaa\303\204\"\n\"\302\215\";",$c$.clean(format(new StringRef(/*KEEP_STR*/"\"aaaaaaa\303\204\302\215\";"), $c$.track(getLLVMStyleWithColumns(10)))));
    EXPECT_EQ("\"\320\236\320\264\320\275\320\260\320\266\320\264\321\213, \320\262 \"\n\"\321\201\321\202\321\203\320\264\321\221\320\275\321\203\321\216 \"\n\"\320\267\320\270\320\274\320\275\321\216\321\216 \"\n\"\320\277\320\276\321\200\321\203,\"",$c$.clean(format(new StringRef(/*KEEP_STR*/"\"\320\236\320\264\320\275\320\260\320\266\320\264\321\213, \320\262 \321\201\321\202\321\203\320\264\321\221\320\275\321\203\321\216 \320\267\320\270\320\274\320\275\321\216\321\216 \320\277\320\276\321\200\321\203,\""), $c$.track(getLLVMStyleWithColumns(13)))));
    EXPECT_EQ("\"\344\270\200 \344\272\214 \344\270\211 \"\n\"\345\233\233 \344\272\224\345\205\255 \"\n\"\344\270\203 \345\205\253 \344\271\235 \"\n\"\345\215\201\"",$c$.clean(format(new StringRef(/*KEEP_STR*/"\"\344\270\200 \344\272\214 \344\270\211 \345\233\233 \344\272\224\345\205\255 \344\270\203 \345\205\253 \344\271\235 \345\215\201\""), $c$.track(getLLVMStyleWithColumns(11)))));
    EXPECT_EQ("\"\344\270\200\t\344\272\214 \"\n\"\t\344\270\211 \"\n\"\345\233\233 \344\272\224\t\345\205\255 \"\n\"\t\344\270\203 \"\n\"\345\205\253\344\271\235\345\215\201\tqq\"",$c$.clean(format(new StringRef(/*KEEP_STR*/"\"\344\270\200\t\344\272\214 \t\344\270\211 \345\233\233 \344\272\224\t\345\205\255 \t\344\270\203 \345\205\253\344\271\235\345\215\201\tqq\""), $c$.track(getLLVMStyleWithColumns(11)))));
    
    // UTF8 character in an escape sequence.
    EXPECT_EQ("\"aaaaaa\"\n\"\\\302\215\"",$c$.clean(format(new StringRef(/*KEEP_STR*/"\"aaaaaa\\\302\215\""), $c$.track(getLLVMStyleWithColumns(10)))));
  } finally {
    $c$.$destroy();
  }
}

;
@Test
//<editor-fold defaultstate="collapsed" desc="clang::format::(anonymous namespace)::FormatTest_HandlesDoubleWidthCharsInMultiLineStrings_Test::TestBody">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp", line = 10591,
 FQN="clang::format::(anonymous namespace)::FormatTest_HandlesDoubleWidthCharsInMultiLineStrings_Test::TestBody", NM="_ZN5clang6format12_GLOBAL__N_157FormatTest_HandlesDoubleWidthCharsInMultiLineStrings_Test8TestBodyEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp -nm=_ZN5clang6format12_GLOBAL__N_157FormatTest_HandlesDoubleWidthCharsInMultiLineStrings_Test8TestBodyEv")
//</editor-fold>
public void test_HandlesDoubleWidthCharsInMultiLineStrings() {
  if (markAsSkippedIfNeed(TestState.Successful)) { return; }
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    EXPECT_EQ("const char *sssss =\n    \"\344\270\200\344\272\214\344\270\211\345\233\233\344\272\224\345\205\255\344\270\203\345\205\253\\\n \344\271\235 \345\215\201\";",$c$.clean(format(new StringRef(/*KEEP_STR*/"const char *sssss = \"\344\270\200\344\272\214\344\270\211\345\233\233\344\272\224\345\205\255\344\270\203\345\205\253\\\n \344\271\235 \345\215\201\";"), $c$.track(getLLVMStyleWithColumns(30)))));
  } finally {
    $c$.$destroy();
  }
}

;
@Test
//<editor-fold defaultstate="collapsed" desc="clang::format::(anonymous namespace)::FormatTest_SplitsUTF8LineComments_Test::TestBody">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp", line = 10600,
 FQN="clang::format::(anonymous namespace)::FormatTest_SplitsUTF8LineComments_Test::TestBody", NM="_ZN5clang6format12_GLOBAL__N_138FormatTest_SplitsUTF8LineComments_Test8TestBodyEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp -nm=_ZN5clang6format12_GLOBAL__N_138FormatTest_SplitsUTF8LineComments_Test8TestBodyEv")
//</editor-fold>
public void test_SplitsUTF8LineComments() {
  if (markAsSkippedIfNeed(TestState.Successful)) { return; }
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    EXPECT_EQ("// aaaa\303\204\302\215",$c$.clean(format(new StringRef(/*KEEP_STR*/"// aaaa\303\204\302\215"), $c$.track(getLLVMStyleWithColumns(10)))));
    EXPECT_EQ("// \320\257 \320\270\320\267 \320\273\320\265\321\201\321\203\n// \320\262\321\213\321\210\320\265\320\273; \320\261\321\213\320\273\n// \321\201\320\270\320\273\321\214\320\275\321\213\320\271\n// \320\274\320\276\321\200\320\276\320\267.",$c$.clean(format(new StringRef(/*KEEP_STR*/"// \320\257 \320\270\320\267 \320\273\320\265\321\201\321\203 \320\262\321\213\321\210\320\265\320\273; \320\261\321\213\320\273 \321\201\320\270\320\273\321\214\320\275\321\213\320\271 \320\274\320\276\321\200\320\276\320\267."), $c$.track(getLLVMStyleWithColumns(13)))));
    EXPECT_EQ("// \344\270\200\344\272\214\344\270\211\n// \345\233\233\344\272\224\345\205\255\344\270\203\n// \345\205\253  \344\271\235\n// \345\215\201",$c$.clean(format(new StringRef(/*KEEP_STR*/"// \344\270\200\344\272\214\344\270\211 \345\233\233\344\272\224\345\205\255\344\270\203 \345\205\253  \344\271\235 \345\215\201"), $c$.track(getLLVMStyleWithColumns(9)))));
  } finally {
    $c$.$destroy();
  }
}

;
@Test
//<editor-fold defaultstate="collapsed" desc="clang::format::(anonymous namespace)::FormatTest_SplitsUTF8BlockComments_Test::TestBody">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp", line = 10616,
 FQN="clang::format::(anonymous namespace)::FormatTest_SplitsUTF8BlockComments_Test::TestBody", NM="_ZN5clang6format12_GLOBAL__N_139FormatTest_SplitsUTF8BlockComments_Test8TestBodyEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp -nm=_ZN5clang6format12_GLOBAL__N_139FormatTest_SplitsUTF8BlockComments_Test8TestBodyEv")
//</editor-fold>
public void test_SplitsUTF8BlockComments() {
  if (markAsSkippedIfNeed(TestState.Successful)) { return; }
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    EXPECT_EQ("/* \320\223\320\273\321\217\320\266\321\203,\n * \320\277\320\276\320\264\320\275\320\270\320\274\320\260\320\265\321\202\321\201\321\217\n * \320\274\320\265\320\264\320\273\320\265\320\275\320\275\320\276 \320\262\n * \320\263\320\276\321\200\321\203\n * \320\233\320\276\321\210\320\260\320\264\320\272\320\260,\n * \320\262\320\265\320\267\321\203\321\211\320\260\321\217\n * \321\205\320\262\320\276\321\200\320\276\321\201\321\202\321\203\n * \320\262\320\276\320\267. */",$c$.clean(format(new StringRef(/*KEEP_STR*/"/* \320\223\320\273\321\217\320\266\321\203, \320\277\320\276\320\264\320\275\320\270\320\274\320\260\320\265\321\202\321\201\321\217 \320\274\320\265\320\264\320\273\320\265\320\275\320\275\320\276 \320\262 \320\263\320\276\321\200\321\203\n * \320\233\320\276\321\210\320\260\320\264\320\272\320\260, \320\262\320\265\320\267\321\203\321\211\320\260\321\217 \321\205\320\262\320\276\321\200\320\276\321\201\321\202\321\203 \320\262\320\276\320\267. */"), $c$.track(getLLVMStyleWithColumns(13)))));
    EXPECT_EQ("/* \344\270\200\344\272\214\344\270\211\n * \345\233\233\344\272\224\345\205\255\344\270\203\n * \345\205\253  \344\271\235\n * \345\215\201  */",$c$.clean(format(new StringRef(/*KEEP_STR*/"/* \344\270\200\344\272\214\344\270\211 \345\233\233\344\272\224\345\205\255\344\270\203 \345\205\253  \344\271\235 \345\215\201  */"), $c$.track(getLLVMStyleWithColumns(9)))));
    EXPECT_EQ("/* \360\235\223\243\360\235\223\256\360\235\223\274\360\235\223\275 \360\235\224\243\360\235\224\254\360\235\224\262\360\235\224\257\n * \360\235\225\223\360\235\225\252\360\235\225\245\360\235\225\226\n * \360\235\226\200\360\235\225\277\360\235\225\261-\360\235\237\240 */",$c$.clean(format(new StringRef(/*KEEP_STR*/"/* \360\235\223\243\360\235\223\256\360\235\223\274\360\235\223\275 \360\235\224\243\360\235\224\254\360\235\224\262\360\235\224\257 \360\235\225\223\360\235\225\252\360\235\225\245\360\235\225\226 \360\235\226\200\360\235\225\277\360\235\225\261-\360\235\237\240 */"), $c$.track(getLLVMStyleWithColumns(12)))));
  } finally {
    $c$.$destroy();
  }
}

// _MSC_VER
;
@Test
//<editor-fold defaultstate="collapsed" desc="clang::format::(anonymous namespace)::FormatTest_ConstructorInitializerIndentWidth_Test::TestBody">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp", line = 10642,
 FQN="clang::format::(anonymous namespace)::FormatTest_ConstructorInitializerIndentWidth_Test::TestBody", NM="_ZN5clang6format12_GLOBAL__N_149FormatTest_ConstructorInitializerIndentWidth_Test8TestBodyEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp -nm=_ZN5clang6format12_GLOBAL__N_149FormatTest_ConstructorInitializerIndentWidth_Test8TestBodyEv")
//</editor-fold>
public void test_ConstructorInitializerIndentWidth() {
  if (markAsSkippedIfNeed(TestState.Successful)) { return; }
  FormatStyle Style = null;
  try {
    Style = getLLVMStyle();
    
    Style.ConstructorInitializerIndentWidth = 4;
    verifyFormat(new StringRef(/*KEEP_STR*/"SomeClass::Constructor()\n    : aaaaaaaaaaaaa(aaaaaaaaaaaaaa), aaaaaaaaaaaaa(aaaaaaaaaaaaaa),\n      aaaaaaaaaaaaa(aaaaaaaaaaaaaa) {}"), 
        Style);
    
    Style.ConstructorInitializerIndentWidth = 2;
    verifyFormat(new StringRef(/*KEEP_STR*/"SomeClass::Constructor()\n  : aaaaaaaaaaaaa(aaaaaaaaaaaaaa), aaaaaaaaaaaaa(aaaaaaaaaaaaaa),\n    aaaaaaaaaaaaa(aaaaaaaaaaaaaa) {}"), 
        Style);
    
    Style.ConstructorInitializerIndentWidth = 0;
    verifyFormat(new StringRef(/*KEEP_STR*/"SomeClass::Constructor()\n: aaaaaaaaaaaaa(aaaaaaaaaaaaaa), aaaaaaaaaaaaa(aaaaaaaaaaaaaa),\n  aaaaaaaaaaaaa(aaaaaaaaaaaaaa) {}"), 
        Style);
    Style.AlignAfterOpenBracket = FormatStyle.BracketAlignmentStyle.BAS_AlwaysBreak;
    verifyFormat(new StringRef(/*KEEP_STR*/"SomeLongTemplateVariableName<\n    aaaaaaaaaaaaaaaaaaaaaaaaaaaaaa, aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa>"), 
        Style);
    verifyFormat(new StringRef(/*KEEP_STR*/"bool smaller = 1 < bbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbb(\n                       aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa);"), 
        Style);
  } finally {
    if (Style != null) { Style.$destroy(); }
  }
}

;
@Test
//<editor-fold defaultstate="collapsed" desc="clang::format::(anonymous namespace)::FormatTest_BreakConstructorInitializersBeforeComma_Test::TestBody">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp", line = 10676,
 FQN="clang::format::(anonymous namespace)::FormatTest_BreakConstructorInitializersBeforeComma_Test::TestBody", NM="_ZN5clang6format12_GLOBAL__N_155FormatTest_BreakConstructorInitializersBeforeComma_Test8TestBodyEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp -nm=_ZN5clang6format12_GLOBAL__N_155FormatTest_BreakConstructorInitializersBeforeComma_Test8TestBodyEv")
//</editor-fold>
public void test_BreakConstructorInitializersBeforeComma() {
  if (markAsSkippedIfNeed(TestState.Successful)) { return; }
  FormatStyle Style = null;
  try {
    Style = getLLVMStyle();
    Style.BreakConstructorInitializersBeforeComma = true;
    Style.ConstructorInitializerIndentWidth = 4;
    verifyFormat(new StringRef(/*KEEP_STR*/"SomeClass::Constructor()\n    : a(a)\n    , b(b)\n    , c(c) {}"), 
        Style);
    verifyFormat(new StringRef(/*KEEP_STR*/"SomeClass::Constructor()\n    : a(a) {}"), 
        Style);
    
    Style.ColumnLimit = 0;
    verifyFormat(new StringRef(/*KEEP_STR*/"SomeClass::Constructor()\n    : a(a) {}"), 
        Style);
    verifyFormat(new StringRef(/*KEEP_STR*/"SomeClass::Constructor() noexcept\n    : a(a) {}"), 
        Style);
    verifyFormat(new StringRef(/*KEEP_STR*/"SomeClass::Constructor()\n    : a(a)\n    , b(b)\n    , c(c) {}"), 
        Style);
    verifyFormat(new StringRef(/*KEEP_STR*/"SomeClass::Constructor()\n    : a(a) {\n  foo();\n  bar();\n}"), 
        Style);
    
    Style.AllowShortFunctionsOnASingleLine = FormatStyle.ShortFunctionStyle.SFS_None;
    verifyFormat(new StringRef(/*KEEP_STR*/"SomeClass::Constructor()\n    : a(a)\n    , b(b)\n    , c(c) {\n}"), 
        Style);
    verifyFormat(new StringRef(/*KEEP_STR*/"SomeClass::Constructor()\n    : a(a) {\n}"), 
        Style);
    
    Style.ColumnLimit = 80;
    Style.AllowShortFunctionsOnASingleLine = FormatStyle.ShortFunctionStyle.SFS_All;
    Style.ConstructorInitializerIndentWidth = 2;
    verifyFormat(new StringRef(/*KEEP_STR*/"SomeClass::Constructor()\n  : a(a)\n  , b(b)\n  , c(c) {}"), 
        Style);
    
    Style.ConstructorInitializerIndentWidth = 0;
    verifyFormat(new StringRef(/*KEEP_STR*/"SomeClass::Constructor()\n: a(a)\n, b(b)\n, c(c) {}"), 
        Style);
    
    Style.ConstructorInitializerAllOnOneLineOrOnePerLine = true;
    Style.ConstructorInitializerIndentWidth = 4;
    verifyFormat(new StringRef(/*KEEP_STR*/"SomeClass::Constructor() : aaaaaaaa(aaaaaaaa) {}"), Style);
    verifyFormat(new StringRef(/*KEEP_STR*/"SomeClass::Constructor() : aaaaa(aaaaa), aaaaa(aaaaa), aaaaa(aaaaa)\n"), 
        Style);
    verifyFormat(new StringRef(/*KEEP_STR*/"SomeClass::Constructor()\n    : aaaaaaaa(aaaaaaaa), aaaaaaaa(aaaaaaaa), aaaaaaaa(aaaaaaaa) {}"), 
        Style);
    Style.ConstructorInitializerIndentWidth = 4;
    Style.ColumnLimit = 60;
    verifyFormat(new StringRef(/*KEEP_STR*/"SomeClass::Constructor()\n    : aaaaaaaa(aaaaaaaa)\n    , aaaaaaaa(aaaaaaaa)\n    , aaaaaaaa(aaaaaaaa) {}"), 
        Style);
  } finally {
    if (Style != null) { Style.$destroy(); }
  }
}

;
@Test
//<editor-fold defaultstate="collapsed" desc="clang::format::(anonymous namespace)::FormatTest_Destructors_Test::TestBody">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp", line = 10753,
 FQN="clang::format::(anonymous namespace)::FormatTest_Destructors_Test::TestBody", NM="_ZN5clang6format12_GLOBAL__N_127FormatTest_Destructors_Test8TestBodyEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp -nm=_ZN5clang6format12_GLOBAL__N_127FormatTest_Destructors_Test8TestBodyEv")
//</editor-fold>
public void test_Destructors() {
  if (markAsSkippedIfNeed(TestState.Successful)) { return; }
  verifyFormat(new StringRef(/*KEEP_STR*/"void F(int &i) { i.~int(); }"));
  verifyFormat(new StringRef(/*KEEP_STR*/"void F(int &i) { i->~int(); }"));
}

;
@Test
//<editor-fold defaultstate="collapsed" desc="clang::format::(anonymous namespace)::FormatTest_FormatsWithWebKitStyle_Test::TestBody">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp", line = 10758,
 FQN="clang::format::(anonymous namespace)::FormatTest_FormatsWithWebKitStyle_Test::TestBody", NM="_ZN5clang6format12_GLOBAL__N_138FormatTest_FormatsWithWebKitStyle_Test8TestBodyEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp -nm=_ZN5clang6format12_GLOBAL__N_138FormatTest_FormatsWithWebKitStyle_Test8TestBodyEv")
//</editor-fold>
public void test_FormatsWithWebKitStyle() {
  if (markAsSkippedIfNeed(TestState.Successful)) { return; }
  FormatStyle Style = null;
  try {
    Style = getWebKitStyle();
    
    // Don't indent in outer namespaces.
    verifyFormat(new StringRef(/*KEEP_STR*/"namespace outer {\nint i;\nnamespace inner {\n    int i;\n} // namespace inner\n} // namespace outer\nnamespace other_outer {\nint i;\n}"), 
        Style);
    
    // Don't indent case labels.
    verifyFormat(new StringRef(/*KEEP_STR*/"switch (variable) {\ncase 1:\ncase 2:\n    doSomething();\n    break;\ndefault:\n    ++variable;\n}"), 
        Style);
    
    // Wrap before binary operators.
    EXPECT_EQ("void f()\n{\n    if (aaaaaaaaaaaaaaaa\n        && bbbbbbbbbbbbbbbbbbbbbbbb\n        && (cccccccccccccccccccccccccc || dddddddddddddddddddd))\n        return;\n}",format(new StringRef(/*KEEP_STR*/"void f() {\nif (aaaaaaaaaaaaaaaa\n&& bbbbbbbbbbbbbbbbbbbbbbbb\n&& (cccccccccccccccccccccccccc || dddddddddddddddddddd))\nreturn;\n}"), Style));
    
    // Allow functions on a single line.
    verifyFormat(new StringRef(/*KEEP_STR*/"void f() { return; }"), Style);
    
    // Constructor initializers are formatted one per line with the "," on the
    // new line.
    verifyFormat(new StringRef(/*KEEP_STR*/"Constructor()\n    : aaaaaaaaaaaaaaaaaaaaaaaa(aaaaaaaaaaaaaaaaaaaaaaaaaaa)\n    , aaaaaaaaaaaaaaaaaaaaaaaa(aaaaaaaaaaaaaa, // break\n          aaaaaaaaaaaaaa)\n    , aaaaaaaaaaaaaaaaaaaaaaa()\n{\n}"), 
        Style);
    verifyFormat(new StringRef(/*KEEP_STR*/"SomeClass::Constructor()\n    : a(a)\n{\n}"), 
        Style);
    EXPECT_EQ("SomeClass::Constructor()\n    : a(a)\n{\n}",format(new StringRef(/*KEEP_STR*/"SomeClass::Constructor():a(a){}"), Style));
    verifyFormat(new StringRef(/*KEEP_STR*/"SomeClass::Constructor()\n    : a(a)\n    , b(b)\n    , c(c)\n{\n}"), 
        Style);
    verifyFormat(new StringRef(/*KEEP_STR*/"SomeClass::Constructor()\n    : a(a)\n{\n    foo();\n    bar();\n}"), 
        Style);
    
    // Access specifiers should be aligned left.
    verifyFormat(new StringRef(/*KEEP_STR*/"class C {\npublic:\n    int i;\n};"), 
        Style);
    
    // Do not align comments.
    verifyFormat(new StringRef(/*KEEP_STR*/"int a; // Do not\ndouble b; // align comments."), 
        Style);
    
    // Do not align operands.
    EXPECT_EQ("ASSERT(aaaa\n    || bbbb);",format(new StringRef(/*KEEP_STR*/"ASSERT ( aaaa\n||bbbb);"), Style));
    
    // Accept input's line breaks.
    EXPECT_EQ("if (aaaaaaaaaaaaaaa\n    || bbbbbbbbbbbbbbb) {\n    i++;\n}",format(new StringRef(/*KEEP_STR*/"if (aaaaaaaaaaaaaaa\n|| bbbbbbbbbbbbbbb) { i++; }"), Style));
    EXPECT_EQ("if (aaaaaaaaaaaaaaa || bbbbbbbbbbbbbbb) {\n    i++;\n}",format(new StringRef(/*KEEP_STR*/"if (aaaaaaaaaaaaaaa || bbbbbbbbbbbbbbb) { i++; }"), Style));
    
    // Don't automatically break all macro definitions (llvm.org/PR17842).
    verifyFormat(new StringRef(/*KEEP_STR*/"#define aNumber 10"), Style);
    // However, generally keep the line breaks that the user authored.
    EXPECT_EQ("#define aNumber \\\n    10",format(new StringRef(/*KEEP_STR*/"#define aNumber \\\n 10"), Style));
    
    // Keep empty and one-element array literals on a single line.
    EXPECT_EQ("NSArray* a = [[NSArray alloc] initWithArray:@[]\n                                  copyItems:YES];",format(new StringRef(/*KEEP_STR*/"NSArray*a=[[NSArray alloc] initWithArray:@[]\ncopyItems:YES];"), Style));
    EXPECT_EQ("NSArray* a = [[NSArray alloc] initWithArray:@[ @\"a\" ]\n                                  copyItems:YES];",format(new StringRef(/*KEEP_STR*/"NSArray*a=[[NSArray alloc]initWithArray:@[ @\"a\" ]\n             copyItems:YES];"), Style));
    // FIXME: This does not seem right, there should be more indentation before
    // the array literal's entries. Nested blocks have the same problem.
    EXPECT_EQ("NSArray* a = [[NSArray alloc] initWithArray:@[\n    @\"a\",\n    @\"a\"\n]\n                                  copyItems:YES];",format(new StringRef(/*KEEP_STR*/"NSArray* a = [[NSArray alloc] initWithArray:@[\n     @\"a\",\n     @\"a\"\n     ]\n       copyItems:YES];"), Style));
    EXPECT_EQ("NSArray* a = [[NSArray alloc] initWithArray:@[ @\"a\", @\"a\" ]\n                                  copyItems:YES];",format(new StringRef(/*KEEP_STR*/"NSArray* a = [[NSArray alloc] initWithArray:@[ @\"a\", @\"a\" ]\n   copyItems:YES];"), Style));
    
    verifyFormat(new StringRef(/*KEEP_STR*/"[self.a b:c c:d];"), Style);
    EXPECT_EQ("[self.a b:c\n        c:d];",format(new StringRef(/*KEEP_STR*/"[self.a b:c\nc:d];"), Style));
  } finally {
    if (Style != null) { Style.$destroy(); }
  }
}

;
@Test
//<editor-fold defaultstate="collapsed" desc="clang::format::(anonymous namespace)::FormatTest_FormatsLambdas_Test::TestBody">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp", line = 10916,
 FQN="clang::format::(anonymous namespace)::FormatTest_FormatsLambdas_Test::TestBody", NM="_ZN5clang6format12_GLOBAL__N_130FormatTest_FormatsLambdas_Test8TestBodyEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp -nm=_ZN5clang6format12_GLOBAL__N_130FormatTest_FormatsLambdas_Test8TestBodyEv")
//</editor-fold>
public void test_FormatsLambdas() {
  if (markAsSkippedIfNeed(TestState.Successful)) { return; }
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    verifyFormat(new StringRef(/*KEEP_STR*/"int c = [b]() mutable { return [&b] { return b++; }(); }();\n"));
    verifyFormat(new StringRef(/*KEEP_STR*/"int c = [&] { [=] { return b++; }(); }();\n"));
    verifyFormat(new StringRef(/*KEEP_STR*/"int c = [&, &a, a] { [=, c, &d] { return b++; }(); }();\n"));
    verifyFormat(new StringRef(/*KEEP_STR*/"int c = [&a, &a, a] { [=, a, b, &c] { return b++; }(); }();\n"));
    verifyFormat(new StringRef(/*KEEP_STR*/"auto c = {[&a, &a, a] { [=, a, b, &c] { return b++; }(); }}\n"));
    verifyFormat(new StringRef(/*KEEP_STR*/"auto c = {[&a, &a, a] { [=, a, b, &c] {}(); }}\n"));
    verifyFormat(new StringRef(/*KEEP_STR*/"void f() {\n  other(x.begin(), x.end(), [&](int, int) { return 1; });\n}\n"));
    verifyFormat(new StringRef(/*KEEP_STR*/"void f() {\n  other(x.begin(), //\n        x.end(),   //\n        [&](int, int) { return 1; });\n}\n"));
    verifyFormat(new StringRef(/*KEEP_STR*/"SomeFunction([]() { // A cool function...\n  return 43;\n});"));
    EXPECT_EQ("SomeFunction([]() {\n#define A a\n  return 43;\n});",format(new StringRef(/*KEEP_STR*/"SomeFunction([](){\n#define A a\nreturn 43;\n});")));
    verifyFormat(new StringRef(/*KEEP_STR*/"void f() {\n  SomeFunction([](decltype(x), A *a) {});\n}"));
    verifyFormat(new StringRef(/*KEEP_STR*/"aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa(\n    [](const aaaaaaaaaa &a) { return a; });"));
    verifyFormat(new StringRef(/*KEEP_STR*/"string abc = SomeFunction(aaaaaaaaaaaaa, aaaaa, []() {\n  SomeOtherFunctioooooooooooooooooooooooooon();\n});"));
    verifyFormat(new StringRef(/*KEEP_STR*/"Constructor()\n    : Field([] { // comment\n        int i;\n      }) {}"));
    verifyFormat(new StringRef(/*KEEP_STR*/"auto my_lambda = [](const string &some_parameter) {\n  return some_parameter.size();\n};"));
    verifyFormat(new StringRef(/*KEEP_STR*/"std::function<std::string(const std::string &)> my_lambda =\n    [](const string &s) { return s; };"));
    verifyFormat(new StringRef(/*KEEP_STR*/"int i = aaaaaa ? 1 //\n               : [] {\n                   return 2; //\n                 }();"));
    verifyFormat(new StringRef(/*KEEP_STR*/"llvm::errs() << \"number of twos is \"\n             << std::count_if(v.begin(), v.end(), [](int x) {\n                  return x == 2; // force break\n                });"));
    verifyFormat(new StringRef(/*KEEP_STR*/"return aaaaaaaaaaaaaaaaaaaaaaaaaaaaaa([=](\n    int iiiiiiiiiiii) {\n  return aaaaaaaaaaaaaaaaaaaaaaa != aaaaaaaaaaaaaaaaaaaaaaa;\n});"), 
        $c$.track(getLLVMStyleWithColumns(60))); $c$.clean();
    verifyFormat(new StringRef(/*KEEP_STR*/"SomeFunction({[&] {\n                // comment\n              },\n              [&] {\n                // comment\n              }});"));
    verifyFormat(new StringRef(/*KEEP_STR*/"SomeFunction({[&] {\n  // comment\n}});"));
    verifyFormat(new StringRef(/*KEEP_STR*/"virtual aaaaaaaaaaaaaaaa(std::function<bool()> bbbbbbbbbbbb =\n                             [&]() { return true; },\n                         aaaaa aaaaaaaaa);"));
    
    // Lambdas with return types.
    verifyFormat(new StringRef(/*KEEP_STR*/"int c = []() -> int { return 2; }();\n"));
    verifyFormat(new StringRef(/*KEEP_STR*/"int c = []() -> int * { return 2; }();\n"));
    verifyFormat(new StringRef(/*KEEP_STR*/"int c = []() -> vector<int> { return {2}; }();\n"));
    verifyFormat(new StringRef(/*KEEP_STR*/"Foo([]() -> std::vector<int> { return {2}; }());"));
    verifyGoogleFormat(new StringRef(/*KEEP_STR*/"auto a = [&b, c](D* d) -> D* {};"));
    verifyGoogleFormat(new StringRef(/*KEEP_STR*/"auto a = [&b, c](D* d) -> pair<D*, D*> {};"));
    verifyGoogleFormat(new StringRef(/*KEEP_STR*/"auto a = [&b, c](D* d) -> D& {};"));
    verifyGoogleFormat(new StringRef(/*KEEP_STR*/"auto a = [&b, c](D* d) -> const D* {};"));
    verifyFormat(new StringRef(/*KEEP_STR*/"[a, a]() -> a<1> {};"));
    verifyFormat(new StringRef(/*KEEP_STR*/"auto aaaaaaaa = [](int i, // break for some reason\n                   int j) -> int {\n  return ffffffffffffffffffffffffffffffffffffffffffff(i * j);\n};"));
    verifyFormat(new StringRef(/*KEEP_STR*/"aaaaaaaaaaaaaaaaaaaaaa(\n    [](aaaaaaaaaaaaaaaaaaaaaaaaaaa &aaa) -> aaaaaaaaaaaaaaaa {\n      return aaaaaaaaaaaaaaaaa;\n    });"), 
        $c$.track(getLLVMStyleWithColumns(70))); $c$.clean();
    verifyFormat(new StringRef(/*KEEP_STR*/"[]() //\n    -> int {\n  return 1; //\n};"));
    
    // Multiple lambdas in the same parentheses change indentation rules.
    verifyFormat(new StringRef(/*KEEP_STR*/"SomeFunction(\n    []() {\n      int i = 42;\n      return i;\n    },\n    []() {\n      int j = 43;\n      return j;\n    });"));
    
    // More complex introducers.
    verifyFormat(new StringRef(/*KEEP_STR*/"return [i, args...] {};"));
    
    // Not lambdas.
    verifyFormat(new StringRef(/*KEEP_STR*/"constexpr char hello[]{\"hello\"};"));
    verifyFormat(new StringRef(/*KEEP_STR*/"double &operator[](int i) { return 0; }\nint i;"));
    verifyFormat(new StringRef(/*KEEP_STR*/"std::unique_ptr<int[]> foo() {}"));
    verifyFormat(new StringRef(/*KEEP_STR*/"int i = a[a][a]->f();"));
    verifyFormat(new StringRef(/*KEEP_STR*/"int i = (*b)[a]->f();"));
    
    // Other corner cases.
    verifyFormat(new StringRef(/*KEEP_STR*/"void f() {\n  bar([]() {} // Did not respect SpacesBeforeTrailingComments\n      );\n}"));
    
    // Lambdas created through weird macros.
    verifyFormat(new StringRef(/*KEEP_STR*/"void f() {\n  MACRO((const AA &a) { return 1; });\n  MACRO((AA &a) { return 1; });\n}"));
    
    verifyFormat(new StringRef(/*KEEP_STR*/"if (blah_blah(whatever, whatever, [] {\n      doo_dah();\n      doo_dah();\n    })) {\n}"));
    verifyFormat(new StringRef(/*KEEP_STR*/"auto lambda = []() {\n  int a = 2\n#if A\n          + 2\n#endif\n      ;\n};"));
  } finally {
    $c$.$destroy();
  }
}

;
@Test
//<editor-fold defaultstate="collapsed" desc="clang::format::(anonymous namespace)::FormatTest_FormatsBlocks_Test::TestBody">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp", line = 11058,
 FQN="clang::format::(anonymous namespace)::FormatTest_FormatsBlocks_Test::TestBody", NM="_ZN5clang6format12_GLOBAL__N_129FormatTest_FormatsBlocks_Test8TestBodyEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp -nm=_ZN5clang6format12_GLOBAL__N_129FormatTest_FormatsBlocks_Test8TestBodyEv")
//</editor-fold>
public void test_FormatsBlocks() {
  if (markAsSkippedIfNeed(TestState.Successful)) { return; }
  FormatStyle ShortBlocks = null;
  FormatStyle FourIndent = null;
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    ShortBlocks = getLLVMStyle();
    ShortBlocks.AllowShortBlocksOnASingleLine = true;
    verifyFormat(new StringRef(/*KEEP_STR*/"int (^Block)(int, int);"), ShortBlocks);
    verifyFormat(new StringRef(/*KEEP_STR*/"int (^Block1)(int, int) = ^(int i, int j)"), ShortBlocks);
    verifyFormat(new StringRef(/*KEEP_STR*/"void (^block)(int) = ^(id test) { int i; };"), ShortBlocks);
    verifyFormat(new StringRef(/*KEEP_STR*/"void (^block)(int) = ^(int test) { int i; };"), ShortBlocks);
    verifyFormat(new StringRef(/*KEEP_STR*/"void (^block)(int) = ^id(int test) { int i; };"), ShortBlocks);
    verifyFormat(new StringRef(/*KEEP_STR*/"void (^block)(int) = ^int(int test) { int i; };"), ShortBlocks);
    
    verifyFormat(new StringRef(/*KEEP_STR*/"foo(^{ bar(); });"), ShortBlocks);
    verifyFormat(new StringRef(/*KEEP_STR*/"foo(a, ^{ bar(); });"), ShortBlocks);
    verifyFormat(new StringRef(/*KEEP_STR*/"{ void (^block)(Object *x); }"), ShortBlocks);
    
    verifyFormat(new StringRef(/*KEEP_STR*/"[operation setCompletionBlock:^{\n  [self onOperationDone];\n}];"));
    verifyFormat(new StringRef(/*KEEP_STR*/"int i = {[operation setCompletionBlock:^{\n  [self onOperationDone];\n}]};"));
    verifyFormat(new StringRef(/*KEEP_STR*/"[operation setCompletionBlock:^(int *i) {\n  f();\n}];"));
    verifyFormat(new StringRef(/*KEEP_STR*/"int a = [operation block:^int(int *i) {\n  return 1;\n}];"));
    verifyFormat(new StringRef(/*KEEP_STR*/"[myObject doSomethingWith:arg1\n                      aaa:^int(int *a) {\n                        return 1;\n                      }\n                      bbb:f(a * bbbbbbbb)];"));
    
    verifyFormat(new StringRef(/*KEEP_STR*/"[operation setCompletionBlock:^{\n  [self.delegate newDataAvailable];\n}];"), 
        $c$.track(getLLVMStyleWithColumns(60))); $c$.clean();
    verifyFormat(new StringRef(/*KEEP_STR*/"dispatch_async(_fileIOQueue, ^{\n  NSString *path = [self sessionFilePath];\n  if (path) {\n    // ...\n  }\n});"));
    verifyFormat(new StringRef(/*KEEP_STR*/"[[SessionService sharedService]\n    loadWindowWithCompletionBlock:^(SessionWindow *window) {\n      if (window) {\n        [self windowDidLoad:window];\n      } else {\n        [self errorLoadingWindow];\n      }\n    }];"));
    verifyFormat(new StringRef(/*KEEP_STR*/"void (^largeBlock)(void) = ^{\n  // ...\n};\n"), 
        $c$.track(getLLVMStyleWithColumns(40))); $c$.clean();
    verifyFormat(new StringRef(/*KEEP_STR*/"[[SessionService sharedService]\n    loadWindowWithCompletionBlock: //\n        ^(SessionWindow *window) {\n          if (window) {\n            [self windowDidLoad:window];\n          } else {\n            [self errorLoadingWindow];\n          }\n        }];"), 
        $c$.track(getLLVMStyleWithColumns(60))); $c$.clean();
    verifyFormat(new StringRef(/*KEEP_STR*/"[myObject doSomethingWith:arg1\n    firstBlock:^(Foo *a) {\n      // ...\n      int i;\n    }\n    secondBlock:^(Bar *b) {\n      // ...\n      int i;\n    }\n    thirdBlock:^Foo(Bar *b) {\n      // ...\n      int i;\n    }];"));
    verifyFormat(new StringRef(/*KEEP_STR*/"[myObject doSomethingWith:arg1\n               firstBlock:-1\n              secondBlock:^(Bar *b) {\n                // ...\n                int i;\n              }];"));
    
    verifyFormat(new StringRef(/*KEEP_STR*/"f(^{\n  @autoreleasepool {\n    if (a) {\n      g();\n    }\n  }\n});"));
    verifyFormat(new StringRef(/*KEEP_STR*/"Block b = ^int *(A *a, B *b) {}"));
    
    FourIndent = getLLVMStyle();
    FourIndent.ObjCBlockIndentWidth = 4;
    verifyFormat(new StringRef(/*KEEP_STR*/"[operation setCompletionBlock:^{\n    [self onOperationDone];\n}];"), 
        FourIndent);
  } finally {
    if (FourIndent != null) { FourIndent.$destroy(); }
    if (ShortBlocks != null) { ShortBlocks.$destroy(); }
    $c$.$destroy();
  }
}

;
@Test
//<editor-fold defaultstate="collapsed" desc="clang::format::(anonymous namespace)::FormatTest_FormatsBlocksWithZeroColumnWidth_Test::TestBody">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp", line = 11159,
 FQN="clang::format::(anonymous namespace)::FormatTest_FormatsBlocksWithZeroColumnWidth_Test::TestBody", NM="_ZN5clang6format12_GLOBAL__N_148FormatTest_FormatsBlocksWithZeroColumnWidth_Test8TestBodyEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp -nm=_ZN5clang6format12_GLOBAL__N_148FormatTest_FormatsBlocksWithZeroColumnWidth_Test8TestBodyEv")
//</editor-fold>
public void test_FormatsBlocksWithZeroColumnWidth() {
  if (markAsSkippedIfNeed(TestState.Successful)) { return; }
  FormatStyle ZeroColumn = null;
  try {
    ZeroColumn = getLLVMStyle();
    ZeroColumn.ColumnLimit = 0;
    
    verifyFormat(new StringRef(/*KEEP_STR*/"[[SessionService sharedService] loadWindowWithCompletionBlock:^(SessionWindow *window) {\n  if (window) {\n    [self windowDidLoad:window];\n  } else {\n    [self errorLoadingWindow];\n  }\n}];"), 
        ZeroColumn);
    EXPECT_EQ("[[SessionService sharedService]\n    loadWindowWithCompletionBlock:^(SessionWindow *window) {\n      if (window) {\n        [self windowDidLoad:window];\n      } else {\n        [self errorLoadingWindow];\n      }\n    }];",format(new StringRef(/*KEEP_STR*/"[[SessionService sharedService]\nloadWindowWithCompletionBlock:^(SessionWindow *window) {\n                if (window) {\n    [self windowDidLoad:window];\n  } else {\n    [self errorLoadingWindow];\n  }\n}];"), ZeroColumn));
    verifyFormat(new StringRef(/*KEEP_STR*/"[myObject doSomethingWith:arg1\n    firstBlock:^(Foo *a) {\n      // ...\n      int i;\n    }\n    secondBlock:^(Bar *b) {\n      // ...\n      int i;\n    }\n    thirdBlock:^Foo(Bar *b) {\n      // ...\n      int i;\n    }];"), 
        ZeroColumn);
    verifyFormat(new StringRef(/*KEEP_STR*/"f(^{\n  @autoreleasepool {\n    if (a) {\n      g();\n    }\n  }\n});"), 
        ZeroColumn);
    verifyFormat(new StringRef(/*KEEP_STR*/"void (^largeBlock)(void) = ^{\n  // ...\n};"), 
        ZeroColumn);
    
    ZeroColumn.AllowShortBlocksOnASingleLine = true;
    EXPECT_EQ("void (^largeBlock)(void) = ^{ int i; };",format(new StringRef(/*KEEP_STR*/"void   (^largeBlock)(void) = ^{ int   i; };"), ZeroColumn));
    ZeroColumn.AllowShortBlocksOnASingleLine = false;
    EXPECT_EQ("void (^largeBlock)(void) = ^{\n  int i;\n};",format(new StringRef(/*KEEP_STR*/"void   (^largeBlock)(void) = ^{ int   i; };"), ZeroColumn));
  } finally {
    if (ZeroColumn != null) { ZeroColumn.$destroy(); }
  }
}

;
@Test
//<editor-fold defaultstate="collapsed" desc="clang::format::(anonymous namespace)::FormatTest_SupportsCRLF_Test::TestBody">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp", line = 11226,
 FQN="clang::format::(anonymous namespace)::FormatTest_SupportsCRLF_Test::TestBody", NM="_ZN5clang6format12_GLOBAL__N_128FormatTest_SupportsCRLF_Test8TestBodyEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp -nm=_ZN5clang6format12_GLOBAL__N_128FormatTest_SupportsCRLF_Test8TestBodyEv")
//</editor-fold>
public void test_SupportsCRLF() {
  if (markAsSkippedIfNeed(TestState.Successful)) { return; }
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    EXPECT_EQ("int a;\015\nint b;\015\nint c;\015\n",$c$.clean(format(new StringRef(/*KEEP_STR*/"int a;\015\n  int b;\015\n    int c;\015\n"), $c$.track(getLLVMStyle()))));
    EXPECT_EQ("int a;\015\nint b;\015\nint c;\015\n",$c$.clean(format(new StringRef(/*KEEP_STR*/"int a;\015\n  int b;\n    int c;\015\n"), $c$.track(getLLVMStyle()))));
    EXPECT_EQ("int a;\nint b;\nint c;\n",$c$.clean(format(new StringRef(/*KEEP_STR*/"int a;\015\n  int b;\n    int c;\n"), $c$.track(getLLVMStyle()))));
    EXPECT_EQ("\"aaaaaaa \"\015\n\"bbbbbbb\";\015\n",$c$.clean(format(new StringRef(/*KEEP_STR*/"\"aaaaaaa bbbbbbb\";\015\n"), $c$.track(getLLVMStyleWithColumns(10)))));
    EXPECT_EQ("#define A \\\015\n  b;      \\\015\n  c;      \\\015\n  d;\015\n",$c$.clean(format(new StringRef(/*KEEP_STR*/"#define A \\\015\n  b; \\\015\n  c; d; \015\n"), $c$.track(getGoogleStyle()))));
    EXPECT_EQ("/*\015\nmulti line block comments\015\nshould not introduce\015\nan extra carriage return\015\n*/\015\n",format(new StringRef(/*KEEP_STR*/"/*\015\nmulti line block comments\015\nshould not introduce\015\nan extra carriage return\015\n*/\015\n")));
  } finally {
    $c$.$destroy();
  }
}

;
@Test
//<editor-fold defaultstate="collapsed" desc="clang::format::(anonymous namespace)::FormatTest_MunchSemicolonAfterBlocks_Test::TestBody">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp", line = 11272,
 FQN="clang::format::(anonymous namespace)::FormatTest_MunchSemicolonAfterBlocks_Test::TestBody", NM="_ZN5clang6format12_GLOBAL__N_141FormatTest_MunchSemicolonAfterBlocks_Test8TestBodyEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp -nm=_ZN5clang6format12_GLOBAL__N_141FormatTest_MunchSemicolonAfterBlocks_Test8TestBodyEv")
//</editor-fold>
public void test_MunchSemicolonAfterBlocks() {
  if (markAsSkippedIfNeed(TestState.Successful)) { return; }
  verifyFormat(new StringRef(/*KEEP_STR*/"MY_CLASS(C) {\n  int i;\n  int j;\n};"));
}

;
@Test
//<editor-fold defaultstate="collapsed" desc="clang::format::(anonymous namespace)::FormatTest_ConfigurableContinuationIndentWidth_Test::TestBody">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp", line = 11279,
 FQN="clang::format::(anonymous namespace)::FormatTest_ConfigurableContinuationIndentWidth_Test::TestBody", NM="_ZN5clang6format12_GLOBAL__N_151FormatTest_ConfigurableContinuationIndentWidth_Test8TestBodyEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp -nm=_ZN5clang6format12_GLOBAL__N_151FormatTest_ConfigurableContinuationIndentWidth_Test8TestBodyEv")
//</editor-fold>
public void test_ConfigurableContinuationIndentWidth() {
  if (markAsSkippedIfNeed(TestState.Successful)) { return; }
  FormatStyle TwoIndent = null;
  FormatStyle SixIndent = null;
  try {
    TwoIndent = getLLVMStyleWithColumns(15);
    TwoIndent.ContinuationIndentWidth = 2;
    EXPECT_EQ("int i =\n  longFunction(\n    arg);",format(new StringRef(/*KEEP_STR*/"int i = longFunction(arg);"), TwoIndent));
    
    SixIndent = getLLVMStyleWithColumns(20);
    SixIndent.ContinuationIndentWidth = 6;
    EXPECT_EQ("int i =\n      longFunction(\n            arg);",format(new StringRef(/*KEEP_STR*/"int i = longFunction(arg);"), SixIndent));
  } finally {
    if (SixIndent != null) { SixIndent.$destroy(); }
    if (TwoIndent != null) { TwoIndent.$destroy(); }
  }
}

;
@Test
//<editor-fold defaultstate="collapsed" desc="clang::format::(anonymous namespace)::FormatTest_SpacesInAngles_Test::TestBody">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp", line = 11297,
 FQN="clang::format::(anonymous namespace)::FormatTest_SpacesInAngles_Test::TestBody", NM="_ZN5clang6format12_GLOBAL__N_130FormatTest_SpacesInAngles_Test8TestBodyEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp -nm=_ZN5clang6format12_GLOBAL__N_130FormatTest_SpacesInAngles_Test8TestBodyEv")
//</editor-fold>
public void test_SpacesInAngles() {
  if (markAsSkippedIfNeed(TestState.Successful)) { return; }
  FormatStyle Spaces = null;
  try {
    Spaces = getLLVMStyle();
    Spaces.SpacesInAngles = true;
    
    verifyFormat(new StringRef(/*KEEP_STR*/"static_cast< int >(arg);"), Spaces);
    verifyFormat(new StringRef(/*KEEP_STR*/"template < typename T0, typename T1 > void f() {}"), Spaces);
    verifyFormat(new StringRef(/*KEEP_STR*/"f< int, float >();"), Spaces);
    verifyFormat(new StringRef(/*KEEP_STR*/"template <> g() {}"), Spaces);
    verifyFormat(new StringRef(/*KEEP_STR*/"template < std::vector< int > > f() {}"), Spaces);
    verifyFormat(new StringRef(/*KEEP_STR*/"std::function< void(int, int) > fct;"), Spaces);
    verifyFormat(new StringRef(/*KEEP_STR*/"void inFunction() { std::function< void(int, int) > fct; }"), 
        Spaces);
    
    Spaces.Standard = FormatStyle.LanguageStandard.LS_Cpp03;
    Spaces.SpacesInAngles = true;
    verifyFormat(new StringRef(/*KEEP_STR*/"A< A< int > >();"), Spaces);
    
    Spaces.SpacesInAngles = false;
    verifyFormat(new StringRef(/*KEEP_STR*/"A<A<int> >();"), Spaces);
    
    Spaces.Standard = FormatStyle.LanguageStandard.LS_Cpp11;
    Spaces.SpacesInAngles = true;
    verifyFormat(new StringRef(/*KEEP_STR*/"A< A< int > >();"), Spaces);
    
    Spaces.SpacesInAngles = false;
    verifyFormat(new StringRef(/*KEEP_STR*/"A<A<int>>();"), Spaces);
  } finally {
    if (Spaces != null) { Spaces.$destroy(); }
  }
}

;
@Test
//<editor-fold defaultstate="collapsed" desc="clang::format::(anonymous namespace)::FormatTest_TripleAngleBrackets_Test::TestBody">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp", line = 11325,
 FQN="clang::format::(anonymous namespace)::FormatTest_TripleAngleBrackets_Test::TestBody", NM="_ZN5clang6format12_GLOBAL__N_135FormatTest_TripleAngleBrackets_Test8TestBodyEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp -nm=_ZN5clang6format12_GLOBAL__N_135FormatTest_TripleAngleBrackets_Test8TestBodyEv")
//</editor-fold>
public void test_TripleAngleBrackets() {
  if (markAsSkippedIfNeed(TestState.Successful)) { return; }
  verifyFormat(new StringRef(/*KEEP_STR*/"f<<<1, 1>>>();"));
  verifyFormat(new StringRef(/*KEEP_STR*/"f<<<1, 1, 1, s>>>();"));
  verifyFormat(new StringRef(/*KEEP_STR*/"f<<<a, b, c, d>>>();"));
    EXPECT_EQ("f<<<1, 1>>>();",format(new StringRef(/*KEEP_STR*/"f <<< 1, 1 >>> ();")));
  verifyFormat(new StringRef(/*KEEP_STR*/"f<param><<<1, 1>>>();"));
  verifyFormat(new StringRef(/*KEEP_STR*/"f<1><<<1, 1>>>();"));
    EXPECT_EQ("f<param><<<1, 1>>>();",format(new StringRef(/*KEEP_STR*/"f< param > <<< 1, 1 >>> ();")));
  verifyFormat(new StringRef(/*KEEP_STR*/"aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa<<<\n    1, 1>>>();"));
}

;
@Test
//<editor-fold defaultstate="collapsed" desc="clang::format::(anonymous namespace)::FormatTest_MergeLessLessAtEnd_Test::TestBody">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp", line = 11337,
 FQN="clang::format::(anonymous namespace)::FormatTest_MergeLessLessAtEnd_Test::TestBody", NM="_ZN5clang6format12_GLOBAL__N_134FormatTest_MergeLessLessAtEnd_Test8TestBodyEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp -nm=_ZN5clang6format12_GLOBAL__N_134FormatTest_MergeLessLessAtEnd_Test8TestBodyEv")
//</editor-fold>
public void test_MergeLessLessAtEnd() {
  if (markAsSkippedIfNeed(TestState.Successful)) { return; }
  verifyFormat(new StringRef(/*KEEP_STR*/$LT_LT));
    EXPECT_EQ("< < <",format(new StringRef(/*KEEP_STR*/"\\\n<<<")));
  verifyFormat(new StringRef(/*KEEP_STR*/"aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaallvm::outs() <<"));
  verifyFormat(new StringRef(/*KEEP_STR*/"aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaallvm::outs()\n    <<"));
}

;
@Test
//<editor-fold defaultstate="collapsed" desc="clang::format::(anonymous namespace)::FormatTest_HandleUnbalancedImplicitBracesAcrossPPBranches_Test::TestBody">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp", line = 11346,
 FQN="clang::format::(anonymous namespace)::FormatTest_HandleUnbalancedImplicitBracesAcrossPPBranches_Test::TestBody", NM="_ZN5clang6format12_GLOBAL__N_162FormatTest_HandleUnbalancedImplicitBracesAcrossPPBranches_Test8TestBodyEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp -nm=_ZN5clang6format12_GLOBAL__N_162FormatTest_HandleUnbalancedImplicitBracesAcrossPPBranches_Test8TestBodyEv")
//</editor-fold>
public void test_HandleUnbalancedImplicitBracesAcrossPPBranches() {
  if (markAsSkippedIfNeed(TestState.Successful)) { return; }
  std.string code = new std.string(JD$T$C$P_T2$C$R.INSTANCE, /*KEEP_STR*/"#if A\n#if B\na.\n#endif\n    a = 1;\n#else\n#endif\n#if C\n#else\n#endif\n");
    EXPECT_EQ(code,format(new StringRef(code)));
}

;
@Test
//<editor-fold defaultstate="collapsed" desc="clang::format::(anonymous namespace)::FormatTest_HandleConflictMarkers_Test::TestBody">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp", line = 11360,
 FQN="clang::format::(anonymous namespace)::FormatTest_HandleConflictMarkers_Test::TestBody", NM="_ZN5clang6format12_GLOBAL__N_137FormatTest_HandleConflictMarkers_Test8TestBodyEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp -nm=_ZN5clang6format12_GLOBAL__N_137FormatTest_HandleConflictMarkers_Test8TestBodyEv")
//</editor-fold>
public void test_HandleConflictMarkers() {
  if (markAsSkippedIfNeed(TestState.Successful)) { return; }
    // Git/SVN conflict markers.
    EXPECT_EQ("int a;\nvoid f() {\n  callme(some(parameter1,\n<<<<<<< text by the vcs\n              parameter2),\n||||||| text by the vcs\n              parameter2),\n         parameter3,\n======= text by the vcs\n              parameter2, parameter3),\n>>>>>>> text by the vcs\n         otherparameter);\n",format(new StringRef(/*KEEP_STR*/"int a;\nvoid f() {\n  callme(some(parameter1,\n<<<<<<< text by the vcs\n  parameter2),\n||||||| text by the vcs\n  parameter2),\n  parameter3,\n======= text by the vcs\n  parameter2,\n  parameter3),\n>>>>>>> text by the vcs\n  otherparameter);\n")));
    
    // Perforce markers.
    EXPECT_EQ("void f() {\n  function(\n>>>> text by the vcs\n      parameter,\n==== text by the vcs\n      parameter,\n==== text by the vcs\n      parameter,\n<<<< text by the vcs\n      parameter);\n",format(new StringRef(/*KEEP_STR*/"void f() {\n  function(\n>>>> text by the vcs\n  parameter,\n==== text by the vcs\n  parameter,\n==== text by the vcs\n  parameter,\n<<<< text by the vcs\n  parameter);\n")));
    EXPECT_EQ("<<<<<<<\n|||||||\n=======\n>>>>>>>",format(new StringRef(/*KEEP_STR*/"<<<<<<<\n|||||||\n=======\n>>>>>>>")));
    EXPECT_EQ("<<<<<<<\n|||||||\nint i;\n=======\n>>>>>>>",format(new StringRef(/*KEEP_STR*/"<<<<<<<\n|||||||\nint i;\n=======\n>>>>>>>")));
    
    // FIXME: Handle parsing of macros around conflict markers correctly:
    EXPECT_EQ("#define Macro \\\n<<<<<<<\nSomething \\\n|||||||\nElse \\\n=======\nOther \\\n>>>>>>>\n    End int i;\n",format(new StringRef(/*KEEP_STR*/"#define Macro \\\n<<<<<<<\n  Something \\\n|||||||\n  Else \\\n=======\n  Other \\\n>>>>>>>\n  End\nint i;\n")));
}

;
@Test
//<editor-fold defaultstate="collapsed" desc="clang::format::(anonymous namespace)::FormatTest_DisableRegions_Test::TestBody">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp", line = 11452,
 FQN="clang::format::(anonymous namespace)::FormatTest_DisableRegions_Test::TestBody", NM="_ZN5clang6format12_GLOBAL__N_130FormatTest_DisableRegions_Test8TestBodyEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp -nm=_ZN5clang6format12_GLOBAL__N_130FormatTest_DisableRegions_Test8TestBodyEv")
//</editor-fold>
public void test_DisableRegions() {
  if (markAsSkippedIfNeed(TestState.Successful)) { return; }
    EXPECT_EQ("int i;\n// clang-format off\n  int j;\n// clang-format on\nint k;",format(new StringRef(/*KEEP_STR*/" int  i;\n   // clang-format off\n  int j;\n // clang-format on\n   int   k;")));
    EXPECT_EQ("int i;\n/* clang-format off */\n  int j;\n/* clang-format on */\nint k;",format(new StringRef(/*KEEP_STR*/" int  i;\n   /* clang-format off */\n  int j;\n /* clang-format on */\n   int   k;")));
}

;
@Test
//<editor-fold defaultstate="collapsed" desc="clang::format::(anonymous namespace)::FormatTest_DoNotCrashOnInvalidInput_Test::TestBody">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp", line = 11475,
 FQN="clang::format::(anonymous namespace)::FormatTest_DoNotCrashOnInvalidInput_Test::TestBody", NM="_ZN5clang6format12_GLOBAL__N_140FormatTest_DoNotCrashOnInvalidInput_Test8TestBodyEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp -nm=_ZN5clang6format12_GLOBAL__N_140FormatTest_DoNotCrashOnInvalidInput_Test8TestBodyEv")
//</editor-fold>
public void test_DoNotCrashOnInvalidInput() {
  if (markAsSkippedIfNeed(TestState.Successful)) { return; }
  format(new StringRef(/*KEEP_STR*/"? ) ="));
  verifyNoCrash(new StringRef(/*KEEP_STR*/"#define a\\\n /**/}"));
}

;
@Test
//<editor-fold defaultstate="collapsed" desc="clang::format::(anonymous namespace)::FormatTest_FormatsTableGenCode_Test::TestBody">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp", line = 11480,
 FQN="clang::format::(anonymous namespace)::FormatTest_FormatsTableGenCode_Test::TestBody", NM="_ZN5clang6format12_GLOBAL__N_135FormatTest_FormatsTableGenCode_Test8TestBodyEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp -nm=_ZN5clang6format12_GLOBAL__N_135FormatTest_FormatsTableGenCode_Test8TestBodyEv")
//</editor-fold>
public void test_FormatsTableGenCode() {
  if (markAsSkippedIfNeed(TestState.Successful)) { return; }
  FormatStyle Style = null;
  try {
    Style = getLLVMStyle();
    Style.Language = FormatStyle.LanguageKind.LK_TableGen;
    verifyFormat(new StringRef(/*KEEP_STR*/"include \"a.td\"\ninclude \"b.td\""), Style);
  } finally {
    if (Style != null) { Style.$destroy(); }
  }
}

;
@Test
//<editor-fold defaultstate="collapsed" desc="clang::format::(anonymous namespace)::FormatStyle_GetStyleOfFile_Test::TestBody">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp", line = 11490,
 FQN="clang::format::(anonymous namespace)::FormatStyle_GetStyleOfFile_Test::TestBody", NM="_ZN5clang6format12_GLOBAL__N_131FormatStyle_GetStyleOfFile_Test8TestBodyEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp -nm=_ZN5clang6format12_GLOBAL__N_131FormatStyle_GetStyleOfFile_Test8TestBodyEv")
//</editor-fold>
public void test_GetStyleOfFile() {
  if (markAsSkippedIfNeed(TestState.Successful)) { return; }
  InMemoryFileSystem FS = null;
  FormatStyle Style1 = null;
  FormatStyle Style2 = null;
  FormatStyle Style3 = null;
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    FS/*J*/= new InMemoryFileSystem();
    // Test 1: format file in the same directory.
    ASSERT_TRUE($c$.clean(FS.addFile(new Twine(/*KEEP_STR*/"/a/.clang-format"), 0, $c$.track(MemoryBuffer.getMemBuffer(new StringRef(/*KEEP_STR*/"BasedOnStyle: LLVM"))))));
    ASSERT_TRUE($c$.clean(FS.addFile(new Twine(/*KEEP_STR*/"/a/test.cpp"), 0, $c$.track(MemoryBuffer.getMemBuffer(new StringRef(/*KEEP_STR*/"int i;"))))));
    Style1 = getStyle(new StringRef(/*KEEP_STR*/"file"), new StringRef(/*KEEP_STR*/"/a/.clang-format"), new StringRef(/*KEEP_STR*/"Google"), /*AddrOf*/FS);
    EXPECT_EQ(Style1,$c$.track(getLLVMStyle())); $c$.clean();
    
    // Test 2: fallback to default.
    ASSERT_TRUE($c$.clean(FS.addFile(new Twine(/*KEEP_STR*/"/b/test.cpp"), 0, $c$.track(MemoryBuffer.getMemBuffer(new StringRef(/*KEEP_STR*/"int i;"))))));
    Style2 = getStyle(new StringRef(/*KEEP_STR*/"file"), new StringRef(/*KEEP_STR*/"/b/test.cpp"), new StringRef(/*KEEP_STR*/"Mozilla"), /*AddrOf*/FS);
    EXPECT_EQ(Style2,$c$.track(getMozillaStyle())); $c$.clean();
    
    // Test 3: format file in parent directory.
    ASSERT_TRUE($c$.clean(FS.addFile(new Twine(/*KEEP_STR*/"/c/.clang-format"), 0, $c$.track(MemoryBuffer.getMemBuffer(new StringRef(/*KEEP_STR*/"BasedOnStyle: Google"))))));
    ASSERT_TRUE($c$.clean(FS.addFile(new Twine(/*KEEP_STR*/"/c/sub/sub/sub/test.cpp"), 0, $c$.track(MemoryBuffer.getMemBuffer(new StringRef(/*KEEP_STR*/"int i;"))))));
    Style3 = getStyle(new StringRef(/*KEEP_STR*/"file"), new StringRef(/*KEEP_STR*/"/c/sub/sub/sub/test.cpp"), new StringRef(/*KEEP_STR*/"LLVM"), /*AddrOf*/FS);
    EXPECT_EQ(Style3,$c$.track(getGoogleStyle())); $c$.clean();
  } finally {
    if (Style3 != null) { Style3.$destroy(); }
    if (Style2 != null) { Style2.$destroy(); }
    if (Style1 != null) { Style1.$destroy(); }
    if (FS != null) { FS.$destroy(); }
    $c$.$destroy();
  }
}

// _MSC_VER
//<editor-fold defaultstate="collapsed" desc="clang::format::(anonymous namespace)::ReplacementTest">
//@Converted(kind = Converted.Kind.AUTO,
// source = "${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp", line = 11502,
// FQN="clang::format::(anonymous namespace)::ReplacementTest", NM="_ZN5clang6format12_GLOBAL__N_115ReplacementTestE",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp -nm=_ZN5clang6format12_GLOBAL__N_115ReplacementTestE")
////</editor-fold>
//public abstract static class ReplacementTest extends /*public*/ Test implements Destructors.ClassWithDestructor {
/*protected:*/
  //<editor-fold defaultstate="collapsed" desc="clang::format::(anonymous namespace)::ReplacementTest::createReplacement">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp", line = 11521,
   FQN="clang::format::(anonymous namespace)::ReplacementTest::createReplacement", NM="_ZN5clang6format12_GLOBAL__N_115ReplacementTest17createReplacementENS_14SourceLocationEjN4llvm9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp -nm=_ZN5clang6format12_GLOBAL__N_115ReplacementTest17createReplacementENS_14SourceLocationEjN4llvm9StringRefE")
  //</editor-fold>
  protected Replacement createReplacement(SourceLocation Start, /*uint*/int Length, 
                   StringRef ReplacementText) {
    return new Replacement(Context.Sources, new SourceLocation(Start), Length, 
        new StringRef(ReplacementText));
  }

  
  protected RewriterTestContext Context = new RewriterTestContext();
//  //<editor-fold defaultstate="collapsed" desc="clang::format::(anonymous namespace)::ReplacementTest::~ReplacementTest">
//  @Converted(kind = Converted.Kind.AUTO,
//   source = "${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp", line = 11519,
//   FQN="clang::format::(anonymous namespace)::ReplacementTest::~ReplacementTest", NM="_ZN5clang6format12_GLOBAL__N_115ReplacementTestD0Ev",
//   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp -nm=_ZN5clang6format12_GLOBAL__N_115ReplacementTestD0Ev")
//  //</editor-fold>
//  @Override public /*inline*/ void $destroy() {
//    //START JDestroy
//    Context.$destroy();
//    super.$destroy();
//    //END JDestroy
//  }

//  //<editor-fold defaultstate="collapsed" desc="clang::format::(anonymous namespace)::ReplacementTest::ReplacementTest">
//  @Converted(kind = Converted.Kind.AUTO,
//   source = "${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp", line = 11519,
//   FQN="clang::format::(anonymous namespace)::ReplacementTest::ReplacementTest", NM="_ZN5clang6format12_GLOBAL__N_115ReplacementTestC1Ev",
//   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp -nm=_ZN5clang6format12_GLOBAL__N_115ReplacementTestC1Ev")
//  //</editor-fold>
//  public /*inline*/ ReplacementTest() {
//    // : Test(), Context() 
//    //START JInit
//    super();
//    this.Context = new RewriterTestContext();
//    //END JInit
//  }
//
//  
//  @Override public String toString() {
//    return "" + "Context=" + "[RewriterTestContext]" // NOI18N
//              + super.toString(); // NOI18N
//  }
//}
;
@Test
//<editor-fold defaultstate="collapsed" desc="clang::format::(anonymous namespace)::ReplacementTest_FormatCodeAfterReplacements_Test::TestBody">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp", line = 11530,
 FQN="clang::format::(anonymous namespace)::ReplacementTest_FormatCodeAfterReplacements_Test::TestBody", NM="_ZN5clang6format12_GLOBAL__N_148ReplacementTest_FormatCodeAfterReplacements_Test8TestBodyEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp -nm=_ZN5clang6format12_GLOBAL__N_148ReplacementTest_FormatCodeAfterReplacements_Test8TestBodyEv")
//</editor-fold>
public void test_FormatCodeAfterReplacements() {
  if (markAsSkippedIfNeed(TestState.Successful)) { return; }
  std.setType<Replacement> Replaces = null;
  FormatStyle Style = null;
  Expected<std.setType<Replacement>> FormattedReplaces = null;
  Expected<std.string> Result = null;
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    // Column limit is 20.
    std.string Code = new std.string(JD$T$C$P_T2$C$R.INSTANCE, /*KEEP_STR*/"Type *a =\n    new Type();\ng(iiiii, 0, jjjjj,\n  0, kkkkk, 0, mm);\nint  bad     = format   ;");
    std.string Expected = new std.string(JD$T$C$P_T2$C$R.INSTANCE, /*KEEP_STR*/"auto a = new Type();\ng(iiiii, nullptr,\n  jjjjj, nullptr,\n  kkkkk, nullptr,\n  mm);\nint  bad     = format   ;");
    FileID ID = Context.createInMemoryFile(new StringRef(/*KEEP_STR*/"format.cpp"), new StringRef(Code));
    Replaces/*J*/= new std.setType<Replacement>();
    $c$.clean(Replaces.insert_T$RR($c$.track(new Replacement(Context.Sources, Context.getLocation(new FileID(ID), 1, 1), 6, new StringRef(/*KEEP_STR*/"auto ")))));
    $c$.clean(Replaces.insert_T$RR($c$.track(new Replacement(Context.Sources, Context.getLocation(new FileID(ID), 3, 10), 1, new StringRef(/*KEEP_STR*/$nullptr)))));
    $c$.clean(Replaces.insert_T$RR($c$.track(new Replacement(Context.Sources, Context.getLocation(new FileID(ID), 4, 3), 1, new StringRef(/*KEEP_STR*/$nullptr)))));
    $c$.clean(Replaces.insert_T$RR($c$.track(new Replacement(Context.Sources, Context.getLocation(new FileID(ID), 4, 13), 1, new StringRef(/*KEEP_STR*/$nullptr)))));
    
    Style = FormatGlobals.getLLVMStyle();
    Style.ColumnLimit = 20; // Set column limit to 20 to increase readibility.
    FormattedReplaces = formatReplacements(new StringRef(Code), Replaces, Style);
    EXPECT_TRUE(((/*static_cast*/boolean)(FormattedReplaces.$bool())));
    Result = applyAllReplacements(new StringRef(Code), FormattedReplaces.$star());
    EXPECT_TRUE(((/*static_cast*/boolean)(Result.$bool())));
    EXPECT_EQ(Expected,Result.$star());
  } finally {
    if (Result != null) { Result.$destroy(); }
    if (FormattedReplaces != null) { FormattedReplaces.$destroy(); }
    if (Style != null) { Style.$destroy(); }
    if (Replaces != null) { Replaces.$destroy(); }
    $c$.$destroy();
  }
}

;
@Test
//<editor-fold defaultstate="collapsed" desc="clang::format::(anonymous namespace)::ReplacementTest_SortIncludesAfterReplacement_Test::TestBody">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp", line = 11564,
 FQN="clang::format::(anonymous namespace)::ReplacementTest_SortIncludesAfterReplacement_Test::TestBody", NM="_ZN5clang6format12_GLOBAL__N_149ReplacementTest_SortIncludesAfterReplacement_Test8TestBodyEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp -nm=_ZN5clang6format12_GLOBAL__N_149ReplacementTest_SortIncludesAfterReplacement_Test8TestBodyEv")
//</editor-fold>
public void test_SortIncludesAfterReplacement() {
  if (markAsSkippedIfNeed(TestState.Successful)) { return; }
  std.setType<Replacement> Replaces = null;
  FormatStyle Style = null;
  Expected<std.setType<Replacement>> FormattedReplaces = null;
  Expected<std.string> Result = null;
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    std.string Code = new std.string(JD$T$C$P_T2$C$R.INSTANCE, /*KEEP_STR*/"#include \"a.h\"\n#include \"c.h\"\n\nint main() {\n  return 0;\n}");
    std.string Expected = new std.string(JD$T$C$P_T2$C$R.INSTANCE, /*KEEP_STR*/"#include \"a.h\"\n#include \"b.h\"\n#include \"c.h\"\n\nint main() {\n  return 0;\n}");
    FileID ID = Context.createInMemoryFile(new StringRef(/*KEEP_STR*/"fix.cpp"), new StringRef(Code));
    Replaces/*J*/= new std.setType<Replacement>();
    $c$.clean(Replaces.insert_T$RR($c$.track(new Replacement(Context.Sources, Context.getLocation(new FileID(ID), 1, 1), 0, new StringRef(/*KEEP_STR*/"#include \"b.h\"\n")))));
    
    Style = FormatGlobals.getLLVMStyle();
    Style.SortIncludes = true;
    FormattedReplaces = formatReplacements(new StringRef(Code), Replaces, Style);
    EXPECT_TRUE(((/*static_cast*/boolean)(FormattedReplaces.$bool())));
    Result = applyAllReplacements(new StringRef(Code), FormattedReplaces.$star());
    EXPECT_TRUE(((/*static_cast*/boolean)(Result.$bool())));
    EXPECT_EQ(Expected,Result.$star());
  } finally {
    if (Result != null) { Result.$destroy(); }
    if (FormattedReplaces != null) { FormattedReplaces.$destroy(); }
    if (Style != null) { Style.$destroy(); }
    if (Replaces != null) { Replaces.$destroy(); }
    $c$.$destroy();
  }
}

//} JAVA: end of namespace (anonymous) // end namespace
//} JAVA: end of namespace format // end namespace format
//} JAVA: end of namespace clang
//<editor-fold defaultstate="collapsed" desc="__builtin_trap">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp", line = 70,
 FQN="__builtin_trap", NM="_Z14__builtin_trap",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTest.cpp -nm=_Z14__builtin_trap")
//</editor-fold>
public static void __builtin_trap()/* __attribute__((nothrow))*/ {
  throw new UnsupportedOperationException("<<<DeclJavaPrinter::VisitFunctionDecl NULL BODY IN USED Translation Unit>>>");
}
} // END OF class FormatTest
