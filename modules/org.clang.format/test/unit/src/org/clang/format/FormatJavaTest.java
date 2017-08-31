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

import org.junit.Test;
import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.tooling.core.*;
import org.clang.format.*;
import static org.clang.format.FormatGlobals.*;
import static org.clang.tooling.ToolingGlobals.*;
import org.clang.format.FormatTestUtils.test;


//<editor-fold defaultstate="collapsed" desc="static type FormatTestJava">
@Converted(kind = Converted.Kind.AUTO,
 NM="FormatTestJava",
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -print -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTestJava.cpp -test=FormatTestJava")
//</editor-fold>
public final class FormatJavaTest extends ADTSupportTestBase {

//JAVA: namespace clang {
//JAVA: namespace format {

////<editor-fold defaultstate="collapsed" desc="clang::format::FormatTestJava">
//@Converted(kind = Converted.Kind.AUTO,
// source = "${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTestJava.cpp", line = 20,
// FQN="clang::format::FormatTestJava", NM="_ZN5clang6format14FormatTestJavaE",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTestJava.cpp -nm=_ZN5clang6format14FormatTestJavaE")
////</editor-fold>
//public abstract static class FormatTestJava extends /*public*/ Test implements Destructors.ClassWithDestructor {
/*protected:*/
  //<editor-fold defaultstate="collapsed" desc="clang::format::FormatTestJava::format">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTestJava.cpp", line = 22,
   FQN="clang::format::FormatTestJava::format", NM="_ZN5clang6format14FormatTestJava6formatEN4llvm9StringRefEjjRKNS0_11FormatStyleE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTestJava.cpp -nm=_ZN5clang6format14FormatTestJava6formatEN4llvm9StringRefEjjRKNS0_11FormatStyleE")
  //</editor-fold>
  protected static std.string format(StringRef Code, /*uint*/int Offset, 
        /*uint*/int Length, final /*const*/ FormatStyle /*&*/ Style) {
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
      Ranges/*J*/= new std.vector<Range>(1, new Range(Offset, Length), new Range());
      Replaces = reformat(Style, new StringRef(Code), new ArrayRef<Range>(Ranges, false));
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

  
  //<editor-fold defaultstate="collapsed" desc="clang::format::FormatTestJava::format">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTestJava.cpp", line = 34,
   FQN="clang::format::FormatTestJava::format", NM="_ZN5clang6format14FormatTestJava6formatEN4llvm9StringRefERKNS0_11FormatStyleE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTestJava.cpp -nm=_ZN5clang6format14FormatTestJava6formatEN4llvm9StringRefERKNS0_11FormatStyleE")
  //</editor-fold>
  protected static std.string format(StringRef Code) {
    return format(Code, 
        getGoogleStyle(FormatStyle.LanguageKind.LK_Java));
  }
  protected static std.string format(StringRef Code, 
        final /*const*/ FormatStyle /*&*/ Style/*= $c$.track(getGoogleStyle(FormatStyle::LK_Java))*/) {
    return FormatJavaTest.format(new StringRef(Code), 0, Code.size(), Style);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::format::FormatTestJava::getStyleWithColumns">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTestJava.cpp", line = 40,
   FQN="clang::format::FormatTestJava::getStyleWithColumns", NM="_ZN5clang6format14FormatTestJava19getStyleWithColumnsEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTestJava.cpp -nm=_ZN5clang6format14FormatTestJava19getStyleWithColumnsEj")
  //</editor-fold>
  protected static FormatStyle getStyleWithColumns(/*uint*/int ColumnLimit) {
    FormatStyle Style = null;
    try {
      Style = getGoogleStyle(FormatStyle.LanguageKind.LK_Java);
      Style.ColumnLimit = ColumnLimit;
      return new FormatStyle(JD$Move.INSTANCE, Style);
    } finally {
      if (Style != null) { Style.$destroy(); }
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::format::FormatTestJava::verifyFormat">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTestJava.cpp", line = 46,
   FQN="clang::format::FormatTestJava::verifyFormat", NM="_ZN5clang6format14FormatTestJava12verifyFormatEN4llvm9StringRefERKNS0_11FormatStyleE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTestJava.cpp -nm=_ZN5clang6format14FormatTestJava12verifyFormatEN4llvm9StringRefERKNS0_11FormatStyleE")
  //</editor-fold>
  protected static void verifyFormat(StringRef Code) {
    verifyFormat(Code, 
              getGoogleStyle(FormatStyle.LanguageKind.LK_Java));
  }
  protected static void verifyFormat(StringRef Code, 
              final /*const*/ FormatStyle /*&*/ Style/*= $c$.track(getGoogleStyle(FormatStyle::LK_Java))*/) {
      EXPECT_EQ(Code.str(),FormatJavaTest.format(new StringRef(test.messUp(new StringRef(Code))), Style));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::format::FormatTestJava::~FormatTestJava">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTestJava.cpp", line = 20,
   FQN="clang::format::FormatTestJava::~FormatTestJava", NM="_ZN5clang6format14FormatTestJavaD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTestJava.cpp -nm=_ZN5clang6format14FormatTestJavaD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    super.$destroy();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::format::FormatTestJava::FormatTestJava">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTestJava.cpp", line = 20,
   FQN="clang::format::FormatTestJava::FormatTestJava", NM="_ZN5clang6format14FormatTestJavaC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTestJava.cpp -nm=_ZN5clang6format14FormatTestJavaC1Ev")
  //</editor-fold>
  public /*inline*/ FormatJavaTest() {
    // : Test() 
    //START JInit
    super(TestState.Successful);
    //END JInit
  }

  
  @Override public String toString() {
    return "" + super.toString(); // NOI18N
  }
//}
;
@Test
//<editor-fold defaultstate="collapsed" desc="clang::format::FormatTestJava_NoAlternativeOperatorNames_Test::TestBody">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTestJava.cpp", line = 53,
 FQN="clang::format::FormatTestJava_NoAlternativeOperatorNames_Test::TestBody", NM="_ZN5clang6format46FormatTestJava_NoAlternativeOperatorNames_Test8TestBodyEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTestJava.cpp -nm=_ZN5clang6format46FormatTestJava_NoAlternativeOperatorNames_Test8TestBodyEv")
//</editor-fold>
public void test_NoAlternativeOperatorNames() {
  if (markAsSkippedIfNeed(TestState.Successful)) { return; }
  FormatJavaTest.verifyFormat(new StringRef(/*KEEP_STR*/"someObject.and();"));
}

;
@Test
//<editor-fold defaultstate="collapsed" desc="clang::format::FormatTestJava_UnderstandsCasts_Test::TestBody">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTestJava.cpp", line = 57,
 FQN="clang::format::FormatTestJava_UnderstandsCasts_Test::TestBody", NM="_ZN5clang6format36FormatTestJava_UnderstandsCasts_Test8TestBodyEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTestJava.cpp -nm=_ZN5clang6format36FormatTestJava_UnderstandsCasts_Test8TestBodyEv")
//</editor-fold>
public void test_UnderstandsCasts() {
  if (markAsSkippedIfNeed(TestState.Successful)) { return; }
  FormatJavaTest.verifyFormat(new StringRef(/*KEEP_STR*/"a[b >> 1] = (byte) (c() << 4);"));
}

;
@Test
//<editor-fold defaultstate="collapsed" desc="clang::format::FormatTestJava_FormatsInstanceOfLikeOperators_Test::TestBody">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTestJava.cpp", line = 61,
 FQN="clang::format::FormatTestJava_FormatsInstanceOfLikeOperators_Test::TestBody", NM="_ZN5clang6format50FormatTestJava_FormatsInstanceOfLikeOperators_Test8TestBodyEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTestJava.cpp -nm=_ZN5clang6format50FormatTestJava_FormatsInstanceOfLikeOperators_Test8TestBodyEv")
//</editor-fold>
public void test_FormatsInstanceOfLikeOperators() {
  if (markAsSkippedIfNeed(TestState.Successful)) { return; }
  FormatStyle Style = null;
  try {
    Style = FormatJavaTest.getStyleWithColumns(50);
    FormatJavaTest.verifyFormat(new StringRef(/*KEEP_STR*/"return aaaaaaaaaaaaaaaaaaaaaaaaaaaaa\n    instanceof bbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbb;"), 
        Style);
    Style.BreakBeforeBinaryOperators = FormatStyle.BinaryOperatorStyle.BOS_None;
    FormatJavaTest.verifyFormat(new StringRef(/*KEEP_STR*/"return aaaaaaaaaaaaaaaaaaaaaaaaaaaaa instanceof\n    bbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbb;"), 
        Style);
    FormatJavaTest.verifyFormat(new StringRef(/*KEEP_STR*/"return aaaaaaaaaaaaaaaaaaa instanceof bbbbbbbbbbbbbbbbbbbbbbb\n    && ccccccccccccccccccc instanceof dddddddddddddddddddddd;"));
  } finally {
    if (Style != null) { Style.$destroy(); }
  }
}

;
@Test
//<editor-fold defaultstate="collapsed" desc="clang::format::FormatTestJava_Chromium_Test::TestBody">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTestJava.cpp", line = 74,
 FQN="clang::format::FormatTestJava_Chromium_Test::TestBody", NM="_ZN5clang6format28FormatTestJava_Chromium_Test8TestBodyEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTestJava.cpp -nm=_ZN5clang6format28FormatTestJava_Chromium_Test8TestBodyEv")
//</editor-fold>
public void test_Chromium() {
  if (markAsSkippedIfNeed(TestState.Successful)) { return; }
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    FormatJavaTest.verifyFormat(new StringRef(/*KEEP_STR*/"class SomeClass {\n    void f() {}\n    int g() {\n        return 0;\n    }\n    void h() {\n        while (true) f();\n        for (;;) f();\n        if (true) f();\n    }\n}"), 
        $c$.track(getChromiumStyle(FormatStyle.LanguageKind.LK_Java))); $c$.clean();
  } finally {
    $c$.$destroy();
  }
}

;
@Test
//<editor-fold defaultstate="collapsed" desc="clang::format::FormatTestJava_QualifiedNames_Test::TestBody">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTestJava.cpp", line = 89,
 FQN="clang::format::FormatTestJava_QualifiedNames_Test::TestBody", NM="_ZN5clang6format34FormatTestJava_QualifiedNames_Test8TestBodyEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTestJava.cpp -nm=_ZN5clang6format34FormatTestJava_QualifiedNames_Test8TestBodyEv")
//</editor-fold>
public void test_QualifiedNames() {
  if (markAsSkippedIfNeed(TestState.Successful)) { return; }
  FormatJavaTest.verifyFormat(new StringRef(/*KEEP_STR*/"public some.package.Type someFunction( // comment\n    int parameter) {}"));
}

;
@Test
//<editor-fold defaultstate="collapsed" desc="clang::format::FormatTestJava_ClassKeyword_Test::TestBody">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTestJava.cpp", line = 94,
 FQN="clang::format::FormatTestJava_ClassKeyword_Test::TestBody", NM="_ZN5clang6format32FormatTestJava_ClassKeyword_Test8TestBodyEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTestJava.cpp -nm=_ZN5clang6format32FormatTestJava_ClassKeyword_Test8TestBodyEv")
//</editor-fold>
public void test_ClassKeyword() {
  if (markAsSkippedIfNeed(TestState.Successful)) { return; }
  FormatJavaTest.verifyFormat(new StringRef(/*KEEP_STR*/"SomeClass.class.getName();"));
  FormatJavaTest.verifyFormat(new StringRef(/*KEEP_STR*/"Class c = SomeClass.class;"));
}

;
@Test
//<editor-fold defaultstate="collapsed" desc="clang::format::FormatTestJava_ClassDeclarations_Test::TestBody">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTestJava.cpp", line = 99,
 FQN="clang::format::FormatTestJava_ClassDeclarations_Test::TestBody", NM="_ZN5clang6format37FormatTestJava_ClassDeclarations_Test8TestBodyEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTestJava.cpp -nm=_ZN5clang6format37FormatTestJava_ClassDeclarations_Test8TestBodyEv")
//</editor-fold>
public void test_ClassDeclarations() {
  if (markAsSkippedIfNeed(TestState.Successful)) { return; }
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    FormatJavaTest.verifyFormat(new StringRef(/*KEEP_STR*/"public class SomeClass {\n  private int a;\n  private int b;\n}"));
    FormatJavaTest.verifyFormat(new StringRef(/*KEEP_STR*/"public class A {\n  class B {\n    int i;\n  }\n  class C {\n    int j;\n  }\n}"));
    FormatJavaTest.verifyFormat(new StringRef(/*KEEP_STR*/"public class A extends B.C {}"));
    
    FormatJavaTest.verifyFormat(new StringRef(/*KEEP_STR*/"abstract class SomeClass\n    extends SomeOtherClass implements SomeInterface {}"), 
        $c$.track(FormatJavaTest.getStyleWithColumns(60))); $c$.clean();
    FormatJavaTest.verifyFormat(new StringRef(/*KEEP_STR*/"abstract class SomeClass extends SomeOtherClass\n    implements SomeInterfaceeeeeeeeeeeee {}"), 
        $c$.track(FormatJavaTest.getStyleWithColumns(60))); $c$.clean();
    FormatJavaTest.verifyFormat(new StringRef(/*KEEP_STR*/"abstract class SomeClass\n    extends SomeOtherClass\n    implements SomeInterface {}"), 
        $c$.track(FormatJavaTest.getStyleWithColumns(40))); $c$.clean();
    FormatJavaTest.verifyFormat(new StringRef(/*KEEP_STR*/"abstract class SomeClass\n    extends SomeOtherClass\n    implements SomeInterface,\n               AnotherInterface {}"), 
        $c$.track(FormatJavaTest.getStyleWithColumns(40))); $c$.clean();
    FormatJavaTest.verifyFormat(new StringRef(/*KEEP_STR*/"abstract class SomeClass\n    implements SomeInterface, AnotherInterface {}"), 
        $c$.track(FormatJavaTest.getStyleWithColumns(60))); $c$.clean();
    FormatJavaTest.verifyFormat(new StringRef(/*KEEP_STR*/"@SomeAnnotation()\nabstract class aaaaaaaaaaaa\n    extends bbbbbbbbbbbbbbb implements cccccccccccc {}"), 
        $c$.track(FormatJavaTest.getStyleWithColumns(76))); $c$.clean();
    FormatJavaTest.verifyFormat(new StringRef(/*KEEP_STR*/"@SomeAnnotation()\nabstract class aaaaaaaaa<a>\n    extends bbbbbbbbbbbb<b> implements cccccccccccc {}"), 
        $c$.track(FormatJavaTest.getStyleWithColumns(76))); $c$.clean();
    FormatJavaTest.verifyFormat(new StringRef(/*KEEP_STR*/"interface SomeInterface<A> extends Foo, Bar {\n  void doStuff(int theStuff);\n  void doMoreStuff(int moreStuff);\n}"));
    FormatJavaTest.verifyFormat(new StringRef(/*KEEP_STR*/"public interface SomeInterface {\n  void doStuff(int theStuff);\n  void doMoreStuff(int moreStuff);\n}"));
    FormatJavaTest.verifyFormat(new StringRef(/*KEEP_STR*/"@interface SomeInterface {\n  void doStuff(int theStuff);\n  void doMoreStuff(int moreStuff);\n}"));
    FormatJavaTest.verifyFormat(new StringRef(/*KEEP_STR*/"public @interface SomeInterface {\n  void doStuff(int theStuff);\n  void doMoreStuff(int moreStuff);\n}"));
  } finally {
    $c$.$destroy();
  }
}

;
@Test
//<editor-fold defaultstate="collapsed" desc="clang::format::FormatTestJava_AnonymousClasses_Test::TestBody">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTestJava.cpp", line = 158,
 FQN="clang::format::FormatTestJava_AnonymousClasses_Test::TestBody", NM="_ZN5clang6format36FormatTestJava_AnonymousClasses_Test8TestBodyEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTestJava.cpp -nm=_ZN5clang6format36FormatTestJava_AnonymousClasses_Test8TestBodyEv")
//</editor-fold>
public void test_AnonymousClasses() {
  if (markAsSkippedIfNeed(TestState.Successful)) { return; }
  FormatJavaTest.verifyFormat(new StringRef(/*KEEP_STR*/"return new A() {\n  public String toString() {\n    return \"NotReallyA\";\n  }\n};"));
  FormatJavaTest.verifyFormat(new StringRef(/*KEEP_STR*/"A a = new A() {\n  public String toString() {\n    return \"NotReallyA\";\n  }\n};"));
}

;
@Test
//<editor-fold defaultstate="collapsed" desc="clang::format::FormatTestJava_EnumDeclarations_Test::TestBody">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTestJava.cpp", line = 171,
 FQN="clang::format::FormatTestJava_EnumDeclarations_Test::TestBody", NM="_ZN5clang6format36FormatTestJava_EnumDeclarations_Test8TestBodyEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTestJava.cpp -nm=_ZN5clang6format36FormatTestJava_EnumDeclarations_Test8TestBodyEv")
//</editor-fold>
public void test_EnumDeclarations() {
  if (markAsSkippedIfNeed(TestState.Successful)) { return; }
  FormatJavaTest.verifyFormat(new StringRef(/*KEEP_STR*/"enum SomeThing { ABC, CDE }"));
  FormatJavaTest.verifyFormat(new StringRef(/*KEEP_STR*/"enum SomeThing {\n  ABC,\n  CDE,\n}"));
  FormatJavaTest.verifyFormat(new StringRef(/*KEEP_STR*/"public class SomeClass {\n  enum SomeThing { ABC, CDE }\n  void f() {}\n}"));
  FormatJavaTest.verifyFormat(new StringRef(/*KEEP_STR*/"public class SomeClass implements SomeInterface {\n  enum SomeThing { ABC, CDE }\n  void f() {}\n}"));
  FormatJavaTest.verifyFormat(new StringRef(/*KEEP_STR*/"enum SomeThing {\n  ABC,\n  CDE;\n  void f() {}\n}"));
  FormatJavaTest.verifyFormat(new StringRef(/*KEEP_STR*/"enum SomeThing {\n  ABC(1, \"ABC\"),\n  CDE(2, \"CDE\");\n  Something(int i, String s) {}\n}"));
  FormatJavaTest.verifyFormat(new StringRef(/*KEEP_STR*/"enum SomeThing {\n  ABC(new int[] {1, 2}),\n  CDE(new int[] {2, 3});\n  Something(int[] i) {}\n}"));
  FormatJavaTest.verifyFormat(new StringRef(/*KEEP_STR*/"public enum SomeThing {\n  ABC {\n    public String toString() {\n      return \"ABC\";\n    }\n  },\n  CDE {\n    @Override\n    public String toString() {\n      return \"CDE\";\n    }\n  };\n  public void f() {}\n}"));
  FormatJavaTest.verifyFormat(new StringRef(/*KEEP_STR*/"private enum SomeEnum implements Foo<?, B> {\n  ABC {\n    @Override\n    public String toString() {\n      return \"ABC\";\n    }\n  },\n  CDE {\n    @Override\n    public String toString() {\n      return \"CDE\";\n    }\n  };\n}"));
}

;
@Test
//<editor-fold defaultstate="collapsed" desc="clang::format::FormatTestJava_ArrayInitializers_Test::TestBody">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTestJava.cpp", line = 230,
 FQN="clang::format::FormatTestJava_ArrayInitializers_Test::TestBody", NM="_ZN5clang6format37FormatTestJava_ArrayInitializers_Test8TestBodyEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTestJava.cpp -nm=_ZN5clang6format37FormatTestJava_ArrayInitializers_Test8TestBodyEv")
//</editor-fold>
public void test_ArrayInitializers() {
  if (markAsSkippedIfNeed(TestState.Successful)) { return; }
  FormatStyle Style = null;
  try {
    FormatJavaTest.verifyFormat(new StringRef(/*KEEP_STR*/"new int[] {1, 2, 3, 4};"));
    FormatJavaTest.verifyFormat(new StringRef(/*KEEP_STR*/"new int[] {\n    1, 2, 3, 4,\n};"));
    
    Style = FormatJavaTest.getStyleWithColumns(65);
    Style.Cpp11BracedListStyle = false;
    FormatJavaTest.verifyFormat(new StringRef(/*KEEP_STR*/"expected = new int[] { 10, 10, 10, 10, 10, 10, 10, 10, 10, 10,\n  100, 100, 100, 100, 100, 100, 100, 100, 100, 100 };"), 
        Style);
  } finally {
    if (Style != null) { Style.$destroy(); }
  }
}

;
@Test
//<editor-fold defaultstate="collapsed" desc="clang::format::FormatTestJava_ThrowsDeclarations_Test::TestBody">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTestJava.cpp", line = 244,
 FQN="clang::format::FormatTestJava_ThrowsDeclarations_Test::TestBody", NM="_ZN5clang6format38FormatTestJava_ThrowsDeclarations_Test8TestBodyEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTestJava.cpp -nm=_ZN5clang6format38FormatTestJava_ThrowsDeclarations_Test8TestBodyEv")
//</editor-fold>
public void test_ThrowsDeclarations() {
  if (markAsSkippedIfNeed(TestState.Successful)) { return; }
  FormatJavaTest.verifyFormat(new StringRef(/*KEEP_STR*/"public void doSooooooooooooooooooooooooooomething()\n    throws LooooooooooooooooooooooooooooongException {}"));
  FormatJavaTest.verifyFormat(new StringRef(/*KEEP_STR*/"public void doSooooooooooooooooooooooooooomething()\n    throws LoooooooooongException, LooooooooooongException {}"));
}

;
@Test
//<editor-fold defaultstate="collapsed" desc="clang::format::FormatTestJava_Annotations_Test::TestBody">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTestJava.cpp", line = 251,
 FQN="clang::format::FormatTestJava_Annotations_Test::TestBody", NM="_ZN5clang6format31FormatTestJava_Annotations_Test8TestBodyEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTestJava.cpp -nm=_ZN5clang6format31FormatTestJava_Annotations_Test8TestBodyEv")
//</editor-fold>
public void test_Annotations() {
  if (markAsSkippedIfNeed(TestState.Successful)) { return; }
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    FormatJavaTest.verifyFormat(new StringRef(/*KEEP_STR*/"@Override\npublic String toString() {}"));
    FormatJavaTest.verifyFormat(new StringRef(/*KEEP_STR*/"@Override\n@Nullable\npublic String getNameIfPresent() {}"));
    FormatJavaTest.verifyFormat(new StringRef(/*KEEP_STR*/"@Override // comment\n@Nullable\npublic String getNameIfPresent() {}"));
    FormatJavaTest.verifyFormat(new StringRef(/*KEEP_STR*/"@java.lang.Override // comment\n@Nullable\npublic String getNameIfPresent() {}"));
    
    FormatJavaTest.verifyFormat(new StringRef(/*KEEP_STR*/"@SuppressWarnings(value = \"unchecked\")\npublic void doSomething() {}"));
    FormatJavaTest.verifyFormat(new StringRef(/*KEEP_STR*/"@SuppressWarnings(value = \"unchecked\")\n@Author(name = \"abc\")\npublic void doSomething() {}"));
    
    FormatJavaTest.verifyFormat(new StringRef(/*KEEP_STR*/"DoSomething(new A() {\n  @Override\n  public String toString() {}\n});"));
    
    FormatJavaTest.verifyFormat(new StringRef(/*KEEP_STR*/"void SomeFunction(@Nullable String something) {}"));
    FormatJavaTest.verifyFormat(new StringRef(/*KEEP_STR*/"void SomeFunction(@org.llvm.Nullable String something) {}"));
    
    FormatJavaTest.verifyFormat(new StringRef(/*KEEP_STR*/"@Partial @Mock DataLoader loader;"));
    FormatJavaTest.verifyFormat(new StringRef(/*KEEP_STR*/"@Partial\n@Mock\nDataLoader loader;"), 
        $c$.track(getChromiumStyle(FormatStyle.LanguageKind.LK_Java))); $c$.clean();
    FormatJavaTest.verifyFormat(new StringRef(/*KEEP_STR*/"@SuppressWarnings(value = \"aaaaaaaaaaaaaaaaaaaaaaaaaaaaaa\")\npublic static int iiiiiiiiiiiiiiiiiiiiiiii;"));
    
    FormatJavaTest.verifyFormat(new StringRef(/*KEEP_STR*/"@SomeAnnotation(\"With some really looooooooooooooong text\")\nprivate static final long something = 0L;"));
    FormatJavaTest.verifyFormat(new StringRef(/*KEEP_STR*/"@org.llvm.Qualified(\"With some really looooooooooong text\")\nprivate static final long something = 0L;"));
    FormatJavaTest.verifyFormat(new StringRef(/*KEEP_STR*/"@Mock\nDataLoader loooooooooooooooooooooooader =\n    aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa;"), 
        $c$.track(FormatJavaTest.getStyleWithColumns(60))); $c$.clean();
    FormatJavaTest.verifyFormat(new StringRef(/*KEEP_STR*/"@org.llvm.QualifiedMock\nDataLoader loooooooooooooooooooooooader =\n    aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa;"), 
        $c$.track(FormatJavaTest.getStyleWithColumns(60))); $c$.clean();
    FormatJavaTest.verifyFormat(new StringRef(/*KEEP_STR*/"@Test(a)\naaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa =\n    aaaaaaaaaaaaaaaaaaaaaaaaaaaa(aaaaaaaaaaaaaaaaaaaaaaa);"));
    FormatJavaTest.verifyFormat(new StringRef(/*KEEP_STR*/"@SomeAnnotation(\n    aaaaaaaaaaaaaaaaa, aaaaaaaaaaaaaaaaaaaa)\nint i;"), 
        $c$.track(FormatJavaTest.getStyleWithColumns(50))); $c$.clean();
    FormatJavaTest.verifyFormat(new StringRef(/*KEEP_STR*/"@Test\nReturnType doSomething(\n    String aaaaaaaaaaaaa, String bbbbbbbbbbbbbbb) {}"), 
        $c$.track(FormatJavaTest.getStyleWithColumns(60))); $c$.clean();
    FormatJavaTest.verifyFormat(new StringRef(/*KEEP_STR*/"{\n  boolean someFunction(\n      @Param(aaaaaaaaaaaaaaaa) String aaaaa,\n      String bbbbbbbbbbbbbbb) {}\n}"), 
        $c$.track(FormatJavaTest.getStyleWithColumns(60))); $c$.clean();
    FormatJavaTest.verifyFormat(new StringRef(/*KEEP_STR*/"@Annotation(\"Some\"\n    + \" text\")\nList<Integer> list;"));
  } finally {
    $c$.$destroy();
  }
}

;
@Test
//<editor-fold defaultstate="collapsed" desc="clang::format::FormatTestJava_Generics_Test::TestBody">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTestJava.cpp", line = 320,
 FQN="clang::format::FormatTestJava_Generics_Test::TestBody", NM="_ZN5clang6format28FormatTestJava_Generics_Test8TestBodyEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTestJava.cpp -nm=_ZN5clang6format28FormatTestJava_Generics_Test8TestBodyEv")
//</editor-fold>
public void test_Generics() {
  if (markAsSkippedIfNeed(TestState.Successful)) { return; }
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    FormatJavaTest.verifyFormat(new StringRef(/*KEEP_STR*/"Iterable<?> a;"));
    FormatJavaTest.verifyFormat(new StringRef(/*KEEP_STR*/"Iterable<?> a;"));
    FormatJavaTest.verifyFormat(new StringRef(/*KEEP_STR*/"Iterable<? extends SomeObject> a;"));
    
    FormatJavaTest.verifyFormat(new StringRef(/*KEEP_STR*/"A.<B>doSomething();"));
    
    FormatJavaTest.verifyFormat(new StringRef(/*KEEP_STR*/"@Override\npublic Map<String, ?> getAll() {}"));
    
    FormatJavaTest.verifyFormat(new StringRef(/*KEEP_STR*/"public <R> ArrayList<R> get() {}"));
    FormatJavaTest.verifyFormat(new StringRef(/*KEEP_STR*/"protected <R> ArrayList<R> get() {}"));
    FormatJavaTest.verifyFormat(new StringRef(/*KEEP_STR*/"private <R> ArrayList<R> get() {}"));
    FormatJavaTest.verifyFormat(new StringRef(/*KEEP_STR*/"public static <R> ArrayList<R> get() {}"));
    FormatJavaTest.verifyFormat(new StringRef(/*KEEP_STR*/"public static native <R> ArrayList<R> get();"));
    FormatJavaTest.verifyFormat(new StringRef(/*KEEP_STR*/"public final <X> Foo foo() {}"));
    FormatJavaTest.verifyFormat(new StringRef(/*KEEP_STR*/"public abstract <X> Foo foo();"));
    FormatJavaTest.verifyFormat(new StringRef(/*KEEP_STR*/"<T extends B> T getInstance(Class<T> type);"));
    FormatJavaTest.verifyFormat(new StringRef(/*KEEP_STR*/"Function<F, ? extends T> function;"));
    
    FormatJavaTest.verifyFormat(new StringRef(/*KEEP_STR*/"private Foo<X, Y>[] foos;"));
    FormatJavaTest.verifyFormat(new StringRef(/*KEEP_STR*/"Foo<X, Y>[] foos = this.foos;"));
    FormatJavaTest.verifyFormat(new StringRef(/*KEEP_STR*/"return (a instanceof List<?>)\n    ? aaaaaaaaaaaaaaaaaaaaaaa(aaaaaaaaaaaaaaaaaaaaa)\n    : aaaaaaaaaaaaaaaaaaaaaaa;"), 
        $c$.track(FormatJavaTest.getStyleWithColumns(60))); $c$.clean();
    
    FormatJavaTest.verifyFormat(new StringRef(/*KEEP_STR*/"SomeLoooooooooooooooooooooongType name =\n    SomeType.foo(someArgument)\n        .<X>method()\n        .aaaaaaaaaaaaaaaaaaa()\n        .aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa();"));
  } finally {
    $c$.$destroy();
  }
}

;
@Test
//<editor-fold defaultstate="collapsed" desc="clang::format::FormatTestJava_StringConcatenation_Test::TestBody">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTestJava.cpp", line = 355,
 FQN="clang::format::FormatTestJava_StringConcatenation_Test::TestBody", NM="_ZN5clang6format39FormatTestJava_StringConcatenation_Test8TestBodyEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTestJava.cpp -nm=_ZN5clang6format39FormatTestJava_StringConcatenation_Test8TestBodyEv")
//</editor-fold>
public void test_StringConcatenation() {
  if (markAsSkippedIfNeed(TestState.Successful)) { return; }
  FormatJavaTest.verifyFormat(new StringRef(/*KEEP_STR*/"String someString = \"abc\"\n    + \"cde\";"));
}

;
@Test
//<editor-fold defaultstate="collapsed" desc="clang::format::FormatTestJava_TryCatchFinally_Test::TestBody">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTestJava.cpp", line = 360,
 FQN="clang::format::FormatTestJava_TryCatchFinally_Test::TestBody", NM="_ZN5clang6format35FormatTestJava_TryCatchFinally_Test8TestBodyEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTestJava.cpp -nm=_ZN5clang6format35FormatTestJava_TryCatchFinally_Test8TestBodyEv")
//</editor-fold>
public void test_TryCatchFinally() {
  if (markAsSkippedIfNeed(TestState.Successful)) { return; }
  FormatJavaTest.verifyFormat(new StringRef(/*KEEP_STR*/"try {\n  Something();\n} catch (SomeException e) {\n  HandleException(e);\n}"));
  FormatJavaTest.verifyFormat(new StringRef(/*KEEP_STR*/"try {\n  Something();\n} finally {\n  AlwaysDoThis();\n}"));
  FormatJavaTest.verifyFormat(new StringRef(/*KEEP_STR*/"try {\n  Something();\n} catch (SomeException e) {\n  HandleException(e);\n} finally {\n  AlwaysDoThis();\n}"));
  
  FormatJavaTest.verifyFormat(new StringRef(/*KEEP_STR*/"try {\n  Something();\n} catch (SomeException | OtherException e) {\n  HandleException(e);\n}"));
}

;
@Test
//<editor-fold defaultstate="collapsed" desc="clang::format::FormatTestJava_TryWithResources_Test::TestBody">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTestJava.cpp", line = 386,
 FQN="clang::format::FormatTestJava_TryWithResources_Test::TestBody", NM="_ZN5clang6format36FormatTestJava_TryWithResources_Test8TestBodyEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTestJava.cpp -nm=_ZN5clang6format36FormatTestJava_TryWithResources_Test8TestBodyEv")
//</editor-fold>
public void test_TryWithResources() {
  if (markAsSkippedIfNeed(TestState.Successful)) { return; }
  FormatJavaTest.verifyFormat(new StringRef(/*KEEP_STR*/"try (SomeResource rs = someFunction()) {\n  Something();\n}"));
  FormatJavaTest.verifyFormat(new StringRef(/*KEEP_STR*/"try (SomeResource rs = someFunction()) {\n  Something();\n} catch (SomeException e) {\n  HandleException(e);\n}"));
}

;
@Test
//<editor-fold defaultstate="collapsed" desc="clang::format::FormatTestJava_SynchronizedKeyword_Test::TestBody">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTestJava.cpp", line = 397,
 FQN="clang::format::FormatTestJava_SynchronizedKeyword_Test::TestBody", NM="_ZN5clang6format39FormatTestJava_SynchronizedKeyword_Test8TestBodyEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTestJava.cpp -nm=_ZN5clang6format39FormatTestJava_SynchronizedKeyword_Test8TestBodyEv")
//</editor-fold>
public void test_SynchronizedKeyword() {
  if (markAsSkippedIfNeed(TestState.Successful)) { return; }
  FormatJavaTest.verifyFormat(new StringRef(/*KEEP_STR*/"synchronized (mData) {\n  // ...\n}"));
}

;
@Test
//<editor-fold defaultstate="collapsed" desc="clang::format::FormatTestJava_AssertKeyword_Test::TestBody">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTestJava.cpp", line = 403,
 FQN="clang::format::FormatTestJava_AssertKeyword_Test::TestBody", NM="_ZN5clang6format33FormatTestJava_AssertKeyword_Test8TestBodyEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTestJava.cpp -nm=_ZN5clang6format33FormatTestJava_AssertKeyword_Test8TestBodyEv")
//</editor-fold>
public void test_AssertKeyword() {
  if (markAsSkippedIfNeed(TestState.Successful)) { return; }
  FormatJavaTest.verifyFormat(new StringRef(/*KEEP_STR*/"assert a && b;"));
}

;
@Test
//<editor-fold defaultstate="collapsed" desc="clang::format::FormatTestJava_PackageDeclarations_Test::TestBody">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTestJava.cpp", line = 407,
 FQN="clang::format::FormatTestJava_PackageDeclarations_Test::TestBody", NM="_ZN5clang6format39FormatTestJava_PackageDeclarations_Test8TestBodyEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTestJava.cpp -nm=_ZN5clang6format39FormatTestJava_PackageDeclarations_Test8TestBodyEv")
//</editor-fold>
public void test_PackageDeclarations() {
  if (markAsSkippedIfNeed(TestState.Successful)) { return; }
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    FormatJavaTest.verifyFormat(new StringRef(/*KEEP_STR*/"package some.really.loooooooooooooooooooooong.package;"), 
        $c$.track(FormatJavaTest.getStyleWithColumns(50))); $c$.clean();
  } finally {
    $c$.$destroy();
  }
}

;
@Test
//<editor-fold defaultstate="collapsed" desc="clang::format::FormatTestJava_ImportDeclarations_Test::TestBody">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTestJava.cpp", line = 412,
 FQN="clang::format::FormatTestJava_ImportDeclarations_Test::TestBody", NM="_ZN5clang6format38FormatTestJava_ImportDeclarations_Test8TestBodyEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTestJava.cpp -nm=_ZN5clang6format38FormatTestJava_ImportDeclarations_Test8TestBodyEv")
//</editor-fold>
public void test_ImportDeclarations() {
  if (markAsSkippedIfNeed(TestState.Successful)) { return; }
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    FormatJavaTest.verifyFormat(new StringRef(/*KEEP_STR*/"import some.really.loooooooooooooooooooooong.imported.Class;"), 
        $c$.track(FormatJavaTest.getStyleWithColumns(50))); $c$.clean();
    FormatJavaTest.verifyFormat(new StringRef(/*KEEP_STR*/"import static some.really.looooooooooooooooong.imported.Class;"), 
        $c$.track(FormatJavaTest.getStyleWithColumns(50))); $c$.clean();
  } finally {
    $c$.$destroy();
  }
}

;
@Test
//<editor-fold defaultstate="collapsed" desc="clang::format::FormatTestJava_MethodDeclarations_Test::TestBody">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTestJava.cpp", line = 419,
 FQN="clang::format::FormatTestJava_MethodDeclarations_Test::TestBody", NM="_ZN5clang6format38FormatTestJava_MethodDeclarations_Test8TestBodyEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTestJava.cpp -nm=_ZN5clang6format38FormatTestJava_MethodDeclarations_Test8TestBodyEv")
//</editor-fold>
public void test_MethodDeclarations() {
  if (markAsSkippedIfNeed(TestState.Successful)) { return; }
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    FormatJavaTest.verifyFormat(new StringRef(/*KEEP_STR*/"void methodName(Object arg1,\n    Object arg2, Object arg3) {}"), 
        $c$.track(FormatJavaTest.getStyleWithColumns(40))); $c$.clean();
    FormatJavaTest.verifyFormat(new StringRef(/*KEEP_STR*/"void methodName(\n    Object arg1, Object arg2) {}"), 
        $c$.track(FormatJavaTest.getStyleWithColumns(40))); $c$.clean();
  } finally {
    $c$.$destroy();
  }
}

;
@Test
//<editor-fold defaultstate="collapsed" desc="clang::format::FormatTestJava_CppKeywords_Test::TestBody">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTestJava.cpp", line = 428,
 FQN="clang::format::FormatTestJava_CppKeywords_Test::TestBody", NM="_ZN5clang6format31FormatTestJava_CppKeywords_Test8TestBodyEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTestJava.cpp -nm=_ZN5clang6format31FormatTestJava_CppKeywords_Test8TestBodyEv")
//</editor-fold>
public void test_CppKeywords() {
  if (markAsSkippedIfNeed(TestState.Successful)) { return; }
  FormatJavaTest.verifyFormat(new StringRef(/*KEEP_STR*/"public void union(Type a, Type b);"));
  FormatJavaTest.verifyFormat(new StringRef(/*KEEP_STR*/"public void struct(Object o);"));
  FormatJavaTest.verifyFormat(new StringRef(/*KEEP_STR*/"public void delete(Object o);"));
  FormatJavaTest.verifyFormat(new StringRef(/*KEEP_STR*/"return operator && (aa);"));
}

;
@Test
//<editor-fold defaultstate="collapsed" desc="clang::format::FormatTestJava_NeverAlignAfterReturn_Test::TestBody">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTestJava.cpp", line = 435,
 FQN="clang::format::FormatTestJava_NeverAlignAfterReturn_Test::TestBody", NM="_ZN5clang6format41FormatTestJava_NeverAlignAfterReturn_Test8TestBodyEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTestJava.cpp -nm=_ZN5clang6format41FormatTestJava_NeverAlignAfterReturn_Test8TestBodyEv")
//</editor-fold>
public void test_NeverAlignAfterReturn() {
  if (markAsSkippedIfNeed(TestState.Successful)) { return; }
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    FormatJavaTest.verifyFormat(new StringRef(/*KEEP_STR*/"return aaaaaaaaaaaaaaaaaaa\n    && bbbbbbbbbbbbbbbbbbb\n    && ccccccccccccccccccc;"), 
        $c$.track(FormatJavaTest.getStyleWithColumns(40))); $c$.clean();
    FormatJavaTest.verifyFormat(new StringRef(/*KEEP_STR*/"return (result == null)\n    ? aaaaaaaaaaaaaaaaa\n    : bbbbbbbbbbbbbbbbb;"), 
        $c$.track(FormatJavaTest.getStyleWithColumns(40))); $c$.clean();
    FormatJavaTest.verifyFormat(new StringRef(/*KEEP_STR*/"return aaaaaaaaaaaaaaaaaaa()\n    .bbbbbbbbbbbbbbbbbbb()\n    .ccccccccccccccccccc();"), 
        $c$.track(FormatJavaTest.getStyleWithColumns(40))); $c$.clean();
    FormatJavaTest.verifyFormat(new StringRef(/*KEEP_STR*/"return aaaaaaaaaaaaaaaaaaa()\n    .bbbbbbbbbbbbbbbbbbb(\n        ccccccccccccccc)\n    .ccccccccccccccccccc();"), 
        $c$.track(FormatJavaTest.getStyleWithColumns(40))); $c$.clean();
  } finally {
    $c$.$destroy();
  }
}

;
@Test
//<editor-fold defaultstate="collapsed" desc="clang::format::FormatTestJava_FormatsInnerBlocks_Test::TestBody">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTestJava.cpp", line = 455,
 FQN="clang::format::FormatTestJava_FormatsInnerBlocks_Test::TestBody", NM="_ZN5clang6format38FormatTestJava_FormatsInnerBlocks_Test8TestBodyEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTestJava.cpp -nm=_ZN5clang6format38FormatTestJava_FormatsInnerBlocks_Test8TestBodyEv")
//</editor-fold>
public void test_FormatsInnerBlocks() {
  if (markAsSkippedIfNeed(TestState.Successful)) { return; }
  FormatJavaTest.verifyFormat(new StringRef(/*KEEP_STR*/"someObject.someFunction(new Runnable() {\n  @Override\n  public void run() {\n    System.out.println(42);\n  }\n}, someOtherParameter);"));
  FormatJavaTest.verifyFormat(new StringRef(/*KEEP_STR*/"someFunction(new Runnable() {\n  public void run() {\n    System.out.println(42);\n  }\n});"));
  FormatJavaTest.verifyFormat(new StringRef(/*KEEP_STR*/"someObject.someFunction(\n    new Runnable() {\n      @Override\n      public void run() {\n        System.out.println(42);\n      }\n    },\n    new Runnable() {\n      @Override\n      public void run() {\n        System.out.println(43);\n      }\n    },\n    someOtherParameter);"));
}

;
@Test
//<editor-fold defaultstate="collapsed" desc="clang::format::FormatTestJava_FormatsLambdas_Test::TestBody">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTestJava.cpp", line = 483,
 FQN="clang::format::FormatTestJava_FormatsLambdas_Test::TestBody", NM="_ZN5clang6format34FormatTestJava_FormatsLambdas_Test8TestBodyEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTestJava.cpp -nm=_ZN5clang6format34FormatTestJava_FormatsLambdas_Test8TestBodyEv")
//</editor-fold>
public void test_FormatsLambdas() {
  if (markAsSkippedIfNeed(TestState.Successful)) { return; }
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    FormatJavaTest.verifyFormat(new StringRef(/*KEEP_STR*/"(aaaaaaaaaa, bbbbbbbbbb) -> aaaaaaaaaa + bbbbbbbbbb;"));
    FormatJavaTest.verifyFormat(new StringRef(/*KEEP_STR*/"(aaaaaaaaaa, bbbbbbbbbb)\n    -> aaaaaaaaaa + bbbbbbbbbb;"), 
        $c$.track(FormatJavaTest.getStyleWithColumns(40))); $c$.clean();
    FormatJavaTest.verifyFormat(new StringRef(/*KEEP_STR*/"Runnable someLambda = () -> DoSomething();"));
    FormatJavaTest.verifyFormat(new StringRef(/*KEEP_STR*/"Runnable someLambda = () -> {\n  DoSomething();\n}"));
    
    FormatJavaTest.verifyFormat(new StringRef(/*KEEP_STR*/"Runnable someLambda =\n    (int aaaaa) -> DoSomething(aaaaa);"), 
        $c$.track(FormatJavaTest.getStyleWithColumns(40))); $c$.clean();
  } finally {
    $c$.$destroy();
  }
}

;
@Test
//<editor-fold defaultstate="collapsed" desc="clang::format::FormatTestJava_BreaksStringLiterals_Test::TestBody">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTestJava.cpp", line = 498,
 FQN="clang::format::FormatTestJava_BreaksStringLiterals_Test::TestBody", NM="_ZN5clang6format40FormatTestJava_BreaksStringLiterals_Test8TestBodyEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTestJava.cpp -nm=_ZN5clang6format40FormatTestJava_BreaksStringLiterals_Test8TestBodyEv")
//</editor-fold>
public void test_BreaksStringLiterals() {
  if (markAsSkippedIfNeed(TestState.Successful)) { return; }
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    // FIXME: String literal breaking is currently disabled for Java and JS, as it
    // requires strings to be merged using "+" which we don't support.
    EXPECT_EQ("\"some text other\";",$c$.clean(FormatJavaTest.format(new StringRef(/*KEEP_STR*/"\"some text other\";"), $c$.track(FormatJavaTest.getStyleWithColumns(14)))));
  } finally {
    $c$.$destroy();
  }
}

;
@Test
//<editor-fold defaultstate="collapsed" desc="clang::format::FormatTestJava_AlignsBlockComments_Test::TestBody">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTestJava.cpp", line = 505,
 FQN="clang::format::FormatTestJava_AlignsBlockComments_Test::TestBody", NM="_ZN5clang6format39FormatTestJava_AlignsBlockComments_Test8TestBodyEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTestJava.cpp -nm=_ZN5clang6format39FormatTestJava_AlignsBlockComments_Test8TestBodyEv")
//</editor-fold>
public void test_AlignsBlockComments() {
    if (markAsSkippedIfNeed(TestState.Successful)) { return; }
    EXPECT_EQ("/*\n * Really multi-line\n * comment.\n */\nvoid f() {}",FormatJavaTest.format(new StringRef(/*KEEP_STR*/"  /*\n   * Really multi-line\n   * comment.\n   */\n  void f() {}")));
}

//} JAVA: end of namespace format // end namespace tooling
//} JAVA: end of namespace clang
//<editor-fold defaultstate="collapsed" desc="__builtin_trap">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTestJava.cpp", line = 49,
 FQN="__builtin_trap", NM="_Z14__builtin_trap",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTestJava.cpp -nm=_Z14__builtin_trap")
//</editor-fold>
public static void __builtin_trap()/* __attribute__((nothrow))*/ {
  throw new UnsupportedOperationException("<<<DeclJavaPrinter::VisitFunctionDecl NULL BODY IN USED Translation Unit>>>");
}

} // END OF class FormatTestJava
