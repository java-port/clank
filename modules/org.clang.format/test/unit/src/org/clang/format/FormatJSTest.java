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
import org.clank.support.aliases.*;
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


//<editor-fold defaultstate="collapsed" desc="static type FormatTestJS">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 NM="FormatTestJS",
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -print -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTestJS.cpp -test=FormatTestJS")
//</editor-fold>
public final class FormatJSTest extends ADTSupportTestBase {

//JAVA: namespace clang {
//JAVA: namespace format {

////<editor-fold defaultstate="collapsed" desc="clang::format::FormatTestJS">
//@Converted(kind = Converted.Kind.AUTO,
// source = "${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTestJS.cpp", line = 20,
// FQN="clang::format::FormatTestJS", NM="_ZN5clang6format12FormatTestJSE",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTestJS.cpp -nm=_ZN5clang6format12FormatTestJSE")
////</editor-fold>
//public abstract static class FormatTestJS extends /*public*/ Test implements Destructors.ClassWithDestructor {
/*protected:*/
  //<editor-fold defaultstate="collapsed" desc="clang::format::FormatTestJS::format">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTestJS.cpp", line = 22,
   FQN="clang::format::FormatTestJS::format", NM="_ZN5clang6format12FormatTestJS6formatEN4llvm9StringRefEjjRKNS0_11FormatStyleE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTestJS.cpp -nm=_ZN5clang6format12FormatTestJS6formatEN4llvm9StringRefEjjRKNS0_11FormatStyleE")
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
      bool$ptr IncompleteFormat = create_bool$ptr(false);
      Replaces = reformat(Style, new StringRef(Code), new ArrayRef<Range>(Ranges, false), new StringRef(/*KEEP_STR*/"<stdin>"), /*AddrOf*/IncompleteFormat);
      EXPECT_FALSE((IncompleteFormat));
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

  
  //<editor-fold defaultstate="collapsed" desc="clang::format::FormatTestJS::format">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTestJS.cpp", line = 37,
   FQN="clang::format::FormatTestJS::format", NM="_ZN5clang6format12FormatTestJS6formatEN4llvm9StringRefERKNS0_11FormatStyleE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTestJS.cpp -nm=_ZN5clang6format12FormatTestJS6formatEN4llvm9StringRefERKNS0_11FormatStyleE")
  //</editor-fold>
  protected static std.string format(StringRef Code) {
    return format(Code, 
        getGoogleStyle(FormatStyle.LanguageKind.LK_JavaScript));
  }
  protected static std.string format(StringRef Code, 
        final /*const*/ FormatStyle /*&*/ Style/*= $c$.track(getGoogleStyle(FormatStyle::LK_JavaScript))*/) {
    return FormatJSTest.format(new StringRef(Code), 0, Code.size(), Style);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::format::FormatTestJS::getGoogleJSStyleWithColumns">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTestJS.cpp", line = 43,
   FQN="clang::format::FormatTestJS::getGoogleJSStyleWithColumns", NM="_ZN5clang6format12FormatTestJS27getGoogleJSStyleWithColumnsEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTestJS.cpp -nm=_ZN5clang6format12FormatTestJS27getGoogleJSStyleWithColumnsEj")
  //</editor-fold>
  protected static FormatStyle getGoogleJSStyleWithColumns(/*uint*/int ColumnLimit) {
    FormatStyle Style = null;
    try {
      Style = getGoogleStyle(FormatStyle.LanguageKind.LK_JavaScript);
      Style.ColumnLimit = ColumnLimit;
      return new FormatStyle(JD$Move.INSTANCE, Style);
    } finally {
      if (Style != null) { Style.$destroy(); }
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::format::FormatTestJS::verifyFormat">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTestJS.cpp", line = 49,
   FQN="clang::format::FormatTestJS::verifyFormat", NM="_ZN5clang6format12FormatTestJS12verifyFormatEN4llvm9StringRefERKNS0_11FormatStyleE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTestJS.cpp -nm=_ZN5clang6format12FormatTestJS12verifyFormatEN4llvm9StringRefERKNS0_11FormatStyleE")
  //</editor-fold>
  protected static void verifyFormat(StringRef Code) {
    verifyFormat(Code, 
              getGoogleStyle(FormatStyle.LanguageKind.LK_JavaScript));
  }
  protected static void verifyFormat(StringRef Code, 
              final /*const*/ FormatStyle /*&*/ Style/*= $c$.track(getGoogleStyle(FormatStyle::LK_JavaScript))*/) {
    std.string Result = FormatJSTest.format(new StringRef(test.messUp(new StringRef(Code))), Style);
      EXPECT_EQ(Code.str(),Result);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::format::FormatTestJS::verifyFormat">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTestJS.cpp", line = 56,
   FQN="clang::format::FormatTestJS::verifyFormat", NM="_ZN5clang6format12FormatTestJS12verifyFormatEN4llvm9StringRefES3_RKNS0_11FormatStyleE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTestJS.cpp -nm=_ZN5clang6format12FormatTestJS12verifyFormatEN4llvm9StringRefES3_RKNS0_11FormatStyleE")
  //</editor-fold>
  protected static void verifyFormat(StringRef Expected, 
              StringRef Code) {
    verifyFormat(Expected, 
              Code, 
              getGoogleStyle(FormatStyle.LanguageKind.LK_JavaScript));
  }
  protected static void verifyFormat(StringRef Expected, 
              StringRef Code, 
              final /*const*/ FormatStyle /*&*/ Style/*= $c$.track(getGoogleStyle(FormatStyle::LK_JavaScript))*/) {
    std.string Result = FormatJSTest.format(new StringRef(Code), Style);
      EXPECT_EQ(Expected.str(),Result);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::format::FormatTestJS::~FormatTestJS">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTestJS.cpp", line = 20,
   FQN="clang::format::FormatTestJS::~FormatTestJS", NM="_ZN5clang6format12FormatTestJSD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTestJS.cpp -nm=_ZN5clang6format12FormatTestJSD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    super.$destroy();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::format::FormatTestJS::FormatTestJS">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTestJS.cpp", line = 20,
   FQN="clang::format::FormatTestJS::FormatTestJS", NM="_ZN5clang6format12FormatTestJSC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTestJS.cpp -nm=_ZN5clang6format12FormatTestJSC1Ev")
  //</editor-fold>
  public /*inline*/ FormatJSTest() {
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
//<editor-fold defaultstate="collapsed" desc="clang::format::FormatTestJS_BlockComments_Test::TestBody">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTestJS.cpp", line = 65,
 FQN="clang::format::FormatTestJS_BlockComments_Test::TestBody", NM="_ZN5clang6format31FormatTestJS_BlockComments_Test8TestBodyEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTestJS.cpp -nm=_ZN5clang6format31FormatTestJS_BlockComments_Test8TestBodyEv")
//</editor-fold>
public void test_BlockComments() {
  if (markAsSkippedIfNeed(TestState.Successful)) { return; }
  FormatJSTest.verifyFormat(new StringRef(/*KEEP_STR*/"/* aaaaaaaaaaaaa */ aaaaaaaaaaaaaaaaaaaaaaaaaaa(\n    aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa);"));
}

;
@Test
//<editor-fold defaultstate="collapsed" desc="clang::format::FormatTestJS_UnderstandsJavaScriptOperators_Test::TestBody">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTestJS.cpp", line = 70,
 FQN="clang::format::FormatTestJS_UnderstandsJavaScriptOperators_Test::TestBody", NM="_ZN5clang6format48FormatTestJS_UnderstandsJavaScriptOperators_Test8TestBodyEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTestJS.cpp -nm=_ZN5clang6format48FormatTestJS_UnderstandsJavaScriptOperators_Test8TestBodyEv")
//</editor-fold>
public void test_UnderstandsJavaScriptOperators() {
  if (markAsSkippedIfNeed(TestState.Successful)) { return; }
  FormatStyle Style = null;
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    FormatJSTest.verifyFormat(new StringRef(/*KEEP_STR*/"a == = b;"));
    FormatJSTest.verifyFormat(new StringRef(/*KEEP_STR*/"a != = b;"));
    
    FormatJSTest.verifyFormat(new StringRef(/*KEEP_STR*/"a === b;"));
    FormatJSTest.verifyFormat(new StringRef(/*KEEP_STR*/"aaaaaaa ===\n    b;"), $c$.track(FormatJSTest.getGoogleJSStyleWithColumns(10))); $c$.clean();
    FormatJSTest.verifyFormat(new StringRef(/*KEEP_STR*/"a !== b;"));
    FormatJSTest.verifyFormat(new StringRef(/*KEEP_STR*/"aaaaaaa !==\n    b;"), $c$.track(FormatJSTest.getGoogleJSStyleWithColumns(10))); $c$.clean();
    FormatJSTest.verifyFormat(new StringRef(/*KEEP_STR*/"if (a + b + c +\n        d !==\n    e + f + g)\n  q();"), 
        $c$.track(FormatJSTest.getGoogleJSStyleWithColumns(20))); $c$.clean();
    
    FormatJSTest.verifyFormat(new StringRef(/*KEEP_STR*/"a >> >= b;"));
    
    FormatJSTest.verifyFormat(new StringRef(/*KEEP_STR*/"a >>> b;"));
    FormatJSTest.verifyFormat(new StringRef(/*KEEP_STR*/"aaaaaaa >>>\n    b;"), $c$.track(FormatJSTest.getGoogleJSStyleWithColumns(10))); $c$.clean();
    FormatJSTest.verifyFormat(new StringRef(/*KEEP_STR*/"a >>>= b;"));
    FormatJSTest.verifyFormat(new StringRef(/*KEEP_STR*/"aaaaaaa >>>=\n    b;"), $c$.track(FormatJSTest.getGoogleJSStyleWithColumns(10))); $c$.clean();
    FormatJSTest.verifyFormat(new StringRef(/*KEEP_STR*/"if (a + b + c +\n        d >>>\n    e + f + g)\n  q();"), 
        $c$.track(FormatJSTest.getGoogleJSStyleWithColumns(20))); $c$.clean();
    FormatJSTest.verifyFormat(new StringRef(/*KEEP_STR*/"var x = aaaaaaaaaa ?\n    bbbbbb :\n    ccc;"), 
        $c$.track(FormatJSTest.getGoogleJSStyleWithColumns(20))); $c$.clean();
    
    FormatJSTest.verifyFormat(new StringRef(/*KEEP_STR*/"var b = a.map((x) => x + 1);"));
    FormatJSTest.verifyFormat(new StringRef(/*KEEP_STR*/"return ('aaa') in bbbb;"));
    FormatJSTest.verifyFormat(new StringRef(/*KEEP_STR*/"var x = aaaaaaaaaaaaaaaaaaaaaaaaa() in\n    aaaa.aaaaaa.aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa;"));
    Style = FormatJSTest.getGoogleJSStyleWithColumns(80);
    Style.AlignOperands = true;
    FormatJSTest.verifyFormat(new StringRef(/*KEEP_STR*/"var x = aaaaaaaaaaaaaaaaaaaaaaaaa() in\n        aaaa.aaaaaa.aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa;"), 
        Style);
    Style.BreakBeforeBinaryOperators = FormatStyle.BinaryOperatorStyle.BOS_All;
    FormatJSTest.verifyFormat(new StringRef(/*KEEP_STR*/"var x = aaaaaaaaaaaaaaaaaaaaaaaaa()\n            in aaaa.aaaaaa.aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa;"), 
        Style);
    
    // ES6 spread operator.
    FormatJSTest.verifyFormat(new StringRef(/*KEEP_STR*/"someFunction(...a);"));
    FormatJSTest.verifyFormat(new StringRef(/*KEEP_STR*/"var x = [1, ...a, 2];"));
  } finally {
    if (Style != null) { Style.$destroy(); }
    $c$.$destroy();
  }
}

;
@Test
//<editor-fold defaultstate="collapsed" desc="clang::format::FormatTestJS_UnderstandsAmpAmp_Test::TestBody">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTestJS.cpp", line = 119,
 FQN="clang::format::FormatTestJS_UnderstandsAmpAmp_Test::TestBody", NM="_ZN5clang6format35FormatTestJS_UnderstandsAmpAmp_Test8TestBodyEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTestJS.cpp -nm=_ZN5clang6format35FormatTestJS_UnderstandsAmpAmp_Test8TestBodyEv")
//</editor-fold>
public void test_UnderstandsAmpAmp() {
  if (markAsSkippedIfNeed(TestState.Successful)) { return; }
  FormatJSTest.verifyFormat(new StringRef(/*KEEP_STR*/"e && e.SomeFunction();"));
}

;
@Test
//<editor-fold defaultstate="collapsed" desc="clang::format::FormatTestJS_LiteralOperatorsCanBeKeywords_Test::TestBody">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTestJS.cpp", line = 123,
 FQN="clang::format::FormatTestJS_LiteralOperatorsCanBeKeywords_Test::TestBody", NM="_ZN5clang6format47FormatTestJS_LiteralOperatorsCanBeKeywords_Test8TestBodyEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTestJS.cpp -nm=_ZN5clang6format47FormatTestJS_LiteralOperatorsCanBeKeywords_Test8TestBodyEv")
//</editor-fold>
public void test_LiteralOperatorsCanBeKeywords() {
  if (markAsSkippedIfNeed(TestState.Successful)) { return; }
  FormatJSTest.verifyFormat(new StringRef(/*KEEP_STR*/"not.and.or.not_eq = 1;"));
}

;
@Test
//<editor-fold defaultstate="collapsed" desc="clang::format::FormatTestJS_ReservedWords_Test::TestBody">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTestJS.cpp", line = 127,
 FQN="clang::format::FormatTestJS_ReservedWords_Test::TestBody", NM="_ZN5clang6format31FormatTestJS_ReservedWords_Test8TestBodyEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTestJS.cpp -nm=_ZN5clang6format31FormatTestJS_ReservedWords_Test8TestBodyEv")
//</editor-fold>
public void test_ReservedWords() {
  if (markAsSkippedIfNeed(TestState.Successful)) { return; }
  // JavaScript reserved words (aka keywords) are only illegal when used as
  // Identifiers, but are legal as IdentifierNames.
  FormatJSTest.verifyFormat(new StringRef(/*KEEP_STR*/"x.class.struct = 1;"));
  FormatJSTest.verifyFormat(new StringRef(/*KEEP_STR*/"x.case = 1;"));
  FormatJSTest.verifyFormat(new StringRef(/*KEEP_STR*/"x.interface = 1;"));
  FormatJSTest.verifyFormat(new StringRef(/*KEEP_STR*/"x.for = 1;"));
  FormatJSTest.verifyFormat(new StringRef(/*KEEP_STR*/"x.of() = 1;"));
  FormatJSTest.verifyFormat(new StringRef(/*KEEP_STR*/"x.in() = 1;"));
  FormatJSTest.verifyFormat(new StringRef(/*KEEP_STR*/"x.let() = 1;"));
  FormatJSTest.verifyFormat(new StringRef(/*KEEP_STR*/"x.var() = 1;"));
  FormatJSTest.verifyFormat(new StringRef(/*KEEP_STR*/"x = {\n  a: 12,\n  interface: 1,\n  switch: 1,\n};"));
  FormatJSTest.verifyFormat(new StringRef(/*KEEP_STR*/"var struct = 2;"));
  FormatJSTest.verifyFormat(new StringRef(/*KEEP_STR*/"var union = 2;"));
  FormatJSTest.verifyFormat(new StringRef(/*KEEP_STR*/"var interface = 2;"));
  FormatJSTest.verifyFormat(new StringRef(/*KEEP_STR*/"interface = 2;"));
  FormatJSTest.verifyFormat(new StringRef(/*KEEP_STR*/"x = interface instanceof y;"));
}

;
@Test
//<editor-fold defaultstate="collapsed" desc="clang::format::FormatTestJS_CppKeywords_Test::TestBody">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTestJS.cpp", line = 150,
 FQN="clang::format::FormatTestJS_CppKeywords_Test::TestBody", NM="_ZN5clang6format29FormatTestJS_CppKeywords_Test8TestBodyEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTestJS.cpp -nm=_ZN5clang6format29FormatTestJS_CppKeywords_Test8TestBodyEv")
//</editor-fold>
public void test_CppKeywords() {
  if (markAsSkippedIfNeed(TestState.Successful)) { return; }
  // Make sure we don't mess stuff up because of C++ keywords.
  FormatJSTest.verifyFormat(new StringRef(/*KEEP_STR*/"return operator && (aa);"));
}

;
@Test
//<editor-fold defaultstate="collapsed" desc="clang::format::FormatTestJS_ES6DestructuringAssignment_Test::TestBody">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTestJS.cpp", line = 155,
 FQN="clang::format::FormatTestJS_ES6DestructuringAssignment_Test::TestBody", NM="_ZN5clang6format44FormatTestJS_ES6DestructuringAssignment_Test8TestBodyEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTestJS.cpp -nm=_ZN5clang6format44FormatTestJS_ES6DestructuringAssignment_Test8TestBodyEv")
//</editor-fold>
public void test_ES6DestructuringAssignment() {
  if (markAsSkippedIfNeed(TestState.Successful)) { return; }
  FormatJSTest.verifyFormat(new StringRef(/*KEEP_STR*/"var [a, b, c] = [1, 2, 3];"));
  FormatJSTest.verifyFormat(new StringRef(/*KEEP_STR*/"const [a, b, c] = [1, 2, 3];"));
  FormatJSTest.verifyFormat(new StringRef(/*KEEP_STR*/"let [a, b, c] = [1, 2, 3];"));
  FormatJSTest.verifyFormat(new StringRef(/*KEEP_STR*/"var {a, b} = {a: 1, b: 2};"));
  FormatJSTest.verifyFormat(new StringRef(/*KEEP_STR*/"let {a, b} = {a: 1, b: 2};"));
}

;
@Test
//<editor-fold defaultstate="collapsed" desc="clang::format::FormatTestJS_ContainerLiterals_Test::TestBody">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTestJS.cpp", line = 163,
 FQN="clang::format::FormatTestJS_ContainerLiterals_Test::TestBody", NM="_ZN5clang6format35FormatTestJS_ContainerLiterals_Test8TestBodyEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTestJS.cpp -nm=_ZN5clang6format35FormatTestJS_ContainerLiterals_Test8TestBodyEv")
//</editor-fold>
public void test_ContainerLiterals() {
  if (markAsSkippedIfNeed(TestState.Successful)) { return; }
  FormatJSTest.verifyFormat(new StringRef(/*KEEP_STR*/"var x = {y: function(a) { return a; }};"));
  FormatJSTest.verifyFormat(new StringRef(/*KEEP_STR*/"return {\n  link: function() {\n    f();  //\n  }\n};"));
  FormatJSTest.verifyFormat(new StringRef(/*KEEP_STR*/"return {\n  a: a,\n  link: function() {\n    f();  //\n  }\n};"));
  FormatJSTest.verifyFormat(new StringRef(/*KEEP_STR*/"return {\n  a: a,\n  link: function() {\n    f();  //\n  },\n  link: function() {\n    f();  //\n  }\n};"));
  FormatJSTest.verifyFormat(new StringRef(/*KEEP_STR*/"var stuff = {\n  // comment for update\n  update: false,\n  // comment for modules\n  modules: false,\n  // comment for tasks\n  tasks: false\n};"));
  FormatJSTest.verifyFormat(new StringRef(/*KEEP_STR*/"return {\n  'finish':\n      //\n      a\n};"));
  FormatJSTest.verifyFormat(new StringRef(/*KEEP_STR*/"var obj = {\n  fooooooooo: function(x) {\n    return x.zIsTooLongForOneLineWithTheDeclarationLine();\n  }\n};"));
  // Simple object literal, as opposed to enum style below.
  FormatJSTest.verifyFormat(new StringRef(/*KEEP_STR*/"var obj = {a: 123};"));
  // Enum style top level assignment.
  FormatJSTest.verifyFormat(new StringRef(/*KEEP_STR*/"X = {\n  a: 123\n};"));
  FormatJSTest.verifyFormat(new StringRef(/*KEEP_STR*/"X.Y = {\n  a: 123\n};"));
  // But only on the top level, otherwise its a plain object literal assignment.
  FormatJSTest.verifyFormat(new StringRef(/*KEEP_STR*/"function x() {\n  y = {z: 1};\n}"));
  FormatJSTest.verifyFormat(new StringRef(/*KEEP_STR*/"x = foo && {a: 123};"));
  
  // Arrow functions in object literals.
  FormatJSTest.verifyFormat(new StringRef(/*KEEP_STR*/"var x = {y: (a) => { return a; }};"));
  FormatJSTest.verifyFormat(new StringRef(/*KEEP_STR*/"var x = {y: (a) => a};"));
  
  // Computed keys.
  FormatJSTest.verifyFormat(new StringRef(/*KEEP_STR*/"var x = {[a]: 1, b: 2, [c]: 3};"));
  FormatJSTest.verifyFormat(new StringRef(/*KEEP_STR*/"var x = {\n  [a]: 1,\n  b: 2,\n  [c]: 3,\n};"));
  
  // Object literals can leave out labels.
  FormatJSTest.verifyFormat(new StringRef(/*KEEP_STR*/"f({a}, () => {\n  g();  //\n});"));
  
  // Keys can be quoted.
  FormatJSTest.verifyFormat(new StringRef(/*KEEP_STR*/"var x = {\n  a: a,\n  b: b,\n  'c': c,\n};"));
}

;
@Test
//<editor-fold defaultstate="collapsed" desc="clang::format::FormatTestJS_MethodsInObjectLiterals_Test::TestBody">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTestJS.cpp", line = 239,
 FQN="clang::format::FormatTestJS_MethodsInObjectLiterals_Test::TestBody", NM="_ZN5clang6format41FormatTestJS_MethodsInObjectLiterals_Test8TestBodyEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTestJS.cpp -nm=_ZN5clang6format41FormatTestJS_MethodsInObjectLiterals_Test8TestBodyEv")
//</editor-fold>
public void test_MethodsInObjectLiterals() {
  if (markAsSkippedIfNeed(TestState.Successful)) { return; }
  FormatJSTest.verifyFormat(new StringRef(/*KEEP_STR*/"var o = {\n  value: 'test',\n  get value() {  // getter\n    return this.value;\n  }\n};"));
  FormatJSTest.verifyFormat(new StringRef(/*KEEP_STR*/"var o = {\n  value: 'test',\n  set value(val) {  // setter\n    this.value = val;\n  }\n};"));
  FormatJSTest.verifyFormat(new StringRef(/*KEEP_STR*/"var o = {\n  value: 'test',\n  someMethod(val) {  // method\n    doSomething(this.value + val);\n  }\n};"));
  FormatJSTest.verifyFormat(new StringRef(/*KEEP_STR*/"var o = {\n  someMethod(val) {  // method\n    doSomething(this.value + val);\n  },\n  someOtherMethod(val) {  // method\n    doSomething(this.value + val);\n  }\n};"));
}

;
@Test
//<editor-fold defaultstate="collapsed" desc="clang::format::FormatTestJS_SpacesInContainerLiterals_Test::TestBody">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTestJS.cpp", line = 268,
 FQN="clang::format::FormatTestJS_SpacesInContainerLiterals_Test::TestBody", NM="_ZN5clang6format43FormatTestJS_SpacesInContainerLiterals_Test8TestBodyEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTestJS.cpp -nm=_ZN5clang6format43FormatTestJS_SpacesInContainerLiterals_Test8TestBodyEv")
//</editor-fold>
public void test_SpacesInContainerLiterals() {
  if (markAsSkippedIfNeed(TestState.Successful)) { return; }
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    FormatJSTest.verifyFormat(new StringRef(/*KEEP_STR*/"var arr = [1, 2, 3];"));
    FormatJSTest.verifyFormat(new StringRef(/*KEEP_STR*/"f({a: 1, b: 2, c: 3});"));
    
    FormatJSTest.verifyFormat(new StringRef(/*KEEP_STR*/"var object_literal_with_long_name = {\n  a: 'aaaaaaaaaaaaaaaaaa',\n  b: 'bbbbbbbbbbbbbbbbbb'\n};"));
    
    FormatJSTest.verifyFormat(new StringRef(/*KEEP_STR*/"f({a: 1, b: 2, c: 3});"), 
        $c$.track(getChromiumStyle(FormatStyle.LanguageKind.LK_JavaScript))); $c$.clean();
    FormatJSTest.verifyFormat(new StringRef(/*KEEP_STR*/"f({'a': [{}]});"));
  } finally {
    $c$.$destroy();
  }
}

;
@Test
//<editor-fold defaultstate="collapsed" desc="clang::format::FormatTestJS_SingleQuotedStrings_Test::TestBody">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTestJS.cpp", line = 282,
 FQN="clang::format::FormatTestJS_SingleQuotedStrings_Test::TestBody", NM="_ZN5clang6format37FormatTestJS_SingleQuotedStrings_Test8TestBodyEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTestJS.cpp -nm=_ZN5clang6format37FormatTestJS_SingleQuotedStrings_Test8TestBodyEv")
//</editor-fold>
public void test_SingleQuotedStrings() {
  if (markAsSkippedIfNeed(TestState.Successful)) { return; }
  FormatJSTest.verifyFormat(new StringRef(/*KEEP_STR*/"this.function('', true);"));
}

;
@Test
//<editor-fold defaultstate="collapsed" desc="clang::format::FormatTestJS_GoogScopes_Test::TestBody">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTestJS.cpp", line = 286,
 FQN="clang::format::FormatTestJS_GoogScopes_Test::TestBody", NM="_ZN5clang6format28FormatTestJS_GoogScopes_Test8TestBodyEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTestJS.cpp -nm=_ZN5clang6format28FormatTestJS_GoogScopes_Test8TestBodyEv")
//</editor-fold>
public void test_GoogScopes() {
  if (markAsSkippedIfNeed(TestState.Successful)) { return; }
  FormatJSTest.verifyFormat(new StringRef(/*KEEP_STR*/"goog.scope(function() {\nvar x = a.b;\nvar y = c.d;\n});  // goog.scope"));
  FormatJSTest.verifyFormat(new StringRef(/*KEEP_STR*/"goog.scope(function() {\n// test\nvar x = 0;\n// test\n});"));
}

;
@Test
//<editor-fold defaultstate="collapsed" desc="clang::format::FormatTestJS_GoogModules_Test::TestBody">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTestJS.cpp", line = 298,
 FQN="clang::format::FormatTestJS_GoogModules_Test::TestBody", NM="_ZN5clang6format29FormatTestJS_GoogModules_Test8TestBodyEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTestJS.cpp -nm=_ZN5clang6format29FormatTestJS_GoogModules_Test8TestBodyEv")
//</editor-fold>
public void test_GoogModules() {
  if (markAsSkippedIfNeed(TestState.Successful)) { return; }
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    FormatJSTest.verifyFormat(new StringRef(/*KEEP_STR*/"goog.module('this.is.really.absurdly.long');"), 
        $c$.track(FormatJSTest.getGoogleJSStyleWithColumns(40))); $c$.clean();
    FormatJSTest.verifyFormat(new StringRef(/*KEEP_STR*/"goog.require('this.is.really.absurdly.long');"), 
        $c$.track(FormatJSTest.getGoogleJSStyleWithColumns(40))); $c$.clean();
    FormatJSTest.verifyFormat(new StringRef(/*KEEP_STR*/"goog.provide('this.is.really.absurdly.long');"), 
        $c$.track(FormatJSTest.getGoogleJSStyleWithColumns(40))); $c$.clean();
    FormatJSTest.verifyFormat(new StringRef(/*KEEP_STR*/"var long = goog.require('this.is.really.absurdly.long');"), 
        $c$.track(FormatJSTest.getGoogleJSStyleWithColumns(40))); $c$.clean();
    FormatJSTest.verifyFormat(new StringRef(/*KEEP_STR*/"goog.setTestOnly('this.is.really.absurdly.long');"), 
        $c$.track(FormatJSTest.getGoogleJSStyleWithColumns(40))); $c$.clean();
    FormatJSTest.verifyFormat(new StringRef(/*KEEP_STR*/"goog.forwardDeclare('this.is.really.absurdly.long');"), 
        $c$.track(FormatJSTest.getGoogleJSStyleWithColumns(40))); $c$.clean();
    
    // These should be wrapped normally.
    FormatJSTest.verifyFormat(new StringRef(/*KEEP_STR*/"var MyLongClassName =\n    goog.module.get('my.long.module.name.followedBy.MyLongClassName');"));
  } finally {
    $c$.$destroy();
  }
}

;
@Test
//<editor-fold defaultstate="collapsed" desc="clang::format::FormatTestJS_FormatsNamespaces_Test::TestBody">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTestJS.cpp", line = 318,
 FQN="clang::format::FormatTestJS_FormatsNamespaces_Test::TestBody", NM="_ZN5clang6format35FormatTestJS_FormatsNamespaces_Test8TestBodyEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTestJS.cpp -nm=_ZN5clang6format35FormatTestJS_FormatsNamespaces_Test8TestBodyEv")
//</editor-fold>
public void test_FormatsNamespaces() {
  if (markAsSkippedIfNeed(TestState.Successful)) { return; }
  FormatJSTest.verifyFormat(new StringRef(/*KEEP_STR*/"namespace Foo {\n  export let x = 1;\n}\n"));
  FormatJSTest.verifyFormat(new StringRef(/*KEEP_STR*/"declare namespace Foo {\n  export let x: number;\n}\n"));
}

;
@Test
//<editor-fold defaultstate="collapsed" desc="clang::format::FormatTestJS_FormatsFreestandingFunctions_Test::TestBody">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTestJS.cpp", line = 327,
 FQN="clang::format::FormatTestJS_FormatsFreestandingFunctions_Test::TestBody", NM="_ZN5clang6format46FormatTestJS_FormatsFreestandingFunctions_Test8TestBodyEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTestJS.cpp -nm=_ZN5clang6format46FormatTestJS_FormatsFreestandingFunctions_Test8TestBodyEv")
//</editor-fold>
public void test_FormatsFreestandingFunctions() {
  if (markAsSkippedIfNeed(TestState.Successful)) { return; }
  FormatJSTest.verifyFormat(new StringRef(/*KEEP_STR*/"function outer1(a, b) {\n  function inner1(a, b) { return a; }\n  inner1(a, b);\n}\nfunction outer2(a, b) {\n  function inner2(a, b) { return a; }\n  inner2(a, b);\n}"));
  FormatJSTest.verifyFormat(new StringRef(/*KEEP_STR*/"function f() {}"));
}

;
@Test
//<editor-fold defaultstate="collapsed" desc="clang::format::FormatTestJS_GeneratorFunctions_Test::TestBody">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTestJS.cpp", line = 339,
 FQN="clang::format::FormatTestJS_GeneratorFunctions_Test::TestBody", NM="_ZN5clang6format36FormatTestJS_GeneratorFunctions_Test8TestBodyEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTestJS.cpp -nm=_ZN5clang6format36FormatTestJS_GeneratorFunctions_Test8TestBodyEv")
//</editor-fold>
public void test_GeneratorFunctions() {
  if (markAsSkippedIfNeed(TestState.Successful)) { return; }
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    FormatJSTest.verifyFormat(new StringRef(/*KEEP_STR*/"function* f() {\n  let x = 1;\n  yield x;\n  yield* something();\n}"));
    FormatJSTest.verifyFormat(new StringRef(/*KEEP_STR*/"function*\n    f() {\n}"), 
        $c$.track(FormatJSTest.getGoogleJSStyleWithColumns(8))); $c$.clean();
    FormatJSTest.verifyFormat(new StringRef(/*KEEP_STR*/"export function* f() {\n  yield 1;\n}\n"));
    FormatJSTest.verifyFormat(new StringRef(/*KEEP_STR*/"class X {\n  * generatorMethod() { yield x; }\n}"));
  } finally {
    $c$.$destroy();
  }
}

;
@Test
//<editor-fold defaultstate="collapsed" desc="clang::format::FormatTestJS_AsyncFunctions_Test::TestBody">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTestJS.cpp", line = 357,
 FQN="clang::format::FormatTestJS_AsyncFunctions_Test::TestBody", NM="_ZN5clang6format32FormatTestJS_AsyncFunctions_Test8TestBodyEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTestJS.cpp -nm=_ZN5clang6format32FormatTestJS_AsyncFunctions_Test8TestBodyEv")
//</editor-fold>
public void test_AsyncFunctions() {
  if (markAsSkippedIfNeed(TestState.Successful)) { return; }
  FormatJSTest.verifyFormat(new StringRef(/*KEEP_STR*/"async function f() {\n  let x = 1;\n  return fetch(x);\n}"));
  FormatJSTest.verifyFormat(new StringRef(/*KEEP_STR*/"async function* f() {\n  yield fetch(x);\n}"));
  FormatJSTest.verifyFormat(new StringRef(/*KEEP_STR*/"export async function f() {\n  return fetch(x);\n}"));
  FormatJSTest.verifyFormat(new StringRef(/*KEEP_STR*/"class X {\n  async asyncMethod() { return fetch(1); }\n}"));
  FormatJSTest.verifyFormat(new StringRef(/*KEEP_STR*/"function initialize() {\n  // Comment.\n  return async.then();\n}\n"));
}

;
@Test
//<editor-fold defaultstate="collapsed" desc="clang::format::FormatTestJS_ArrayLiterals_Test::TestBody">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTestJS.cpp", line = 377,
 FQN="clang::format::FormatTestJS_ArrayLiterals_Test::TestBody", NM="_ZN5clang6format31FormatTestJS_ArrayLiterals_Test8TestBodyEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTestJS.cpp -nm=_ZN5clang6format31FormatTestJS_ArrayLiterals_Test8TestBodyEv")
//</editor-fold>
public void test_ArrayLiterals() {
  if (markAsSkippedIfNeed(TestState.Successful)) { return; }
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    FormatJSTest.verifyFormat(new StringRef(/*KEEP_STR*/"var aaaaa: List<SomeThing> =\n    [new SomeThingAAAAAAAAAAAA(), new SomeThingBBBBBBBBB()];"));
    FormatJSTest.verifyFormat(new StringRef(/*KEEP_STR*/"return [\n  aaaaaaaaaaaaaaaaaaaaaaaaaaa, bbbbbbbbbbbbbbbbbbbbbbbbbbb,\n  ccccccccccccccccccccccccccc\n];"));
    FormatJSTest.verifyFormat(new StringRef(/*KEEP_STR*/"return [\n  aaaa().bbbbbbbb('A'),\n  aaaa().bbbbbbbb('B'),\n  aaaa().bbbbbbbb('C'),\n];"));
    FormatJSTest.verifyFormat(new StringRef(/*KEEP_STR*/"var someVariable = SomeFunction([\n  aaaaaaaaaaaaaaaaaaaaaaaaaaa, bbbbbbbbbbbbbbbbbbbbbbbbbbb,\n  ccccccccccccccccccccccccccc\n]);"));
    FormatJSTest.verifyFormat(new StringRef(/*KEEP_STR*/"var someVariable = SomeFunction([\n  [aaaaaaaaaaaaaaaaaaaaaa, bbbbbbbbbbbbbbbbbbbbbb],\n]);"), 
        $c$.track(FormatJSTest.getGoogleJSStyleWithColumns(51))); $c$.clean();
    FormatJSTest.verifyFormat(new StringRef(/*KEEP_STR*/"var someVariable = SomeFunction(aaaa, [\n  aaaaaaaaaaaaaaaaaaaaaaaaaaa, bbbbbbbbbbbbbbbbbbbbbbbbbbb,\n  ccccccccccccccccccccccccccc\n]);"));
    FormatJSTest.verifyFormat(new StringRef(/*KEEP_STR*/"var someVariable = SomeFunction(\n    aaaa,\n    [\n      aaaaaaaaaaaaaaaaaaaaaaaaaa, bbbbbbbbbbbbbbbbbbbbbbbbbb,\n      cccccccccccccccccccccccccc\n    ],\n    aaaa);"));
    FormatJSTest.verifyFormat(new StringRef(/*KEEP_STR*/"var aaaa = aaaaa ||  // wrap\n    [];"));
    
    FormatJSTest.verifyFormat(new StringRef(/*KEEP_STR*/"someFunction([], {a: a});"));
  } finally {
    $c$.$destroy();
  }
}

;
@Test
//<editor-fold defaultstate="collapsed" desc="clang::format::FormatTestJS_ColumnLayoutForArrayLiterals_Test::TestBody">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTestJS.cpp", line = 414,
 FQN="clang::format::FormatTestJS_ColumnLayoutForArrayLiterals_Test::TestBody", NM="_ZN5clang6format46FormatTestJS_ColumnLayoutForArrayLiterals_Test8TestBodyEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTestJS.cpp -nm=_ZN5clang6format46FormatTestJS_ColumnLayoutForArrayLiterals_Test8TestBodyEv")
//</editor-fold>
public void test_ColumnLayoutForArrayLiterals() {
  if (markAsSkippedIfNeed(TestState.Successful)) { return; }
  FormatJSTest.verifyFormat(new StringRef(/*KEEP_STR*/"var array = [\n  a, a, a, a, a, a, a, a, a, a, a, a, a, a, a,\n  a, a, a, a, a, a, a, a, a, a, a, a, a, a, a,\n];"));
  FormatJSTest.verifyFormat(new StringRef(/*KEEP_STR*/"var array = someFunction([\n  a, a, a, a, a, a, a, a, a, a, a, a, a, a, a,\n  a, a, a, a, a, a, a, a, a, a, a, a, a, a, a,\n]);"));
}

;
@Test
//<editor-fold defaultstate="collapsed" desc="clang::format::FormatTestJS_FunctionLiterals_Test::TestBody">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTestJS.cpp", line = 425,
 FQN="clang::format::FormatTestJS_FunctionLiterals_Test::TestBody", NM="_ZN5clang6format34FormatTestJS_FunctionLiterals_Test8TestBodyEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTestJS.cpp -nm=_ZN5clang6format34FormatTestJS_FunctionLiterals_Test8TestBodyEv")
//</editor-fold>
public void test_FunctionLiterals() {
  if (markAsSkippedIfNeed(TestState.Successful)) { return; }
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    FormatJSTest.verifyFormat(new StringRef(/*KEEP_STR*/"doFoo(function() {});"));
    FormatJSTest.verifyFormat(new StringRef(/*KEEP_STR*/"doFoo(function() { return 1; });"));
    FormatJSTest.verifyFormat(new StringRef(/*KEEP_STR*/"var func = function() {\n  return 1;\n};"));
    FormatJSTest.verifyFormat(new StringRef(/*KEEP_STR*/"var func =  //\n    function() {\n  return 1;\n};"));
    FormatJSTest.verifyFormat(new StringRef(/*KEEP_STR*/"return {\n  body: {\n    setAttribute: function(key, val) { this[key] = val; },\n    getAttribute: function(key) { return this[key]; },\n    style: {direction: ''}\n  }\n};"));
    FormatJSTest.verifyFormat(new StringRef(/*KEEP_STR*/"abc = xyz ? function() {\n  return 1;\n} : function() {\n  return -1;\n};"));
    
    FormatJSTest.verifyFormat(new StringRef(/*KEEP_STR*/"var closure = goog.bind(\n    function() {  // comment\n      foo();\n      bar();\n    },\n    this, arg1IsReallyLongAndNeeedsLineBreaks,\n    arg3IsReallyLongAndNeeedsLineBreaks);"));
    FormatJSTest.verifyFormat(new StringRef(/*KEEP_STR*/"var closure = goog.bind(function() {  // comment\n  foo();\n  bar();\n}, this);"));
    FormatJSTest.verifyFormat(new StringRef(/*KEEP_STR*/"return {\n  a: 'E',\n  b: function() {\n    return function() {\n      f();  //\n    };\n  }\n};"));
    FormatJSTest.verifyFormat(new StringRef(/*KEEP_STR*/"{\n  var someVariable = function(x) {\n    return x.zIsTooLongForOneLineWithTheDeclarationLine();\n  };\n}"));
    FormatJSTest.verifyFormat(new StringRef(/*KEEP_STR*/"someLooooooooongFunction(\n    aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa,\n    aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa,\n    function(aaaaaaaaaaaaaaaaaaaaaaaaaaaaa) {\n      // code\n    });"));
    
    FormatJSTest.verifyFormat(new StringRef(/*KEEP_STR*/"f({a: function() { return 1; }});"), 
        $c$.track(FormatJSTest.getGoogleJSStyleWithColumns(33))); $c$.clean();
    FormatJSTest.verifyFormat(new StringRef(/*KEEP_STR*/"f({\n  a: function() { return 1; }\n});"), 
        $c$.track(FormatJSTest.getGoogleJSStyleWithColumns(32))); $c$.clean();
    
    FormatJSTest.verifyFormat(new StringRef(/*KEEP_STR*/"return {\n  a: function SomeFunction() {\n    // ...\n    return 1;\n  }\n};"));
    FormatJSTest.verifyFormat(new StringRef(/*KEEP_STR*/"this.someObject.doSomething(aaaaaaaaaaaaaaaaaaaaaaaaaa)\n    .then(goog.bind(function(aaaaaaaaaaa) {\n      someFunction();\n      someFunction();\n    }, this), aaaaaaaaaaaaaaaaa);"));
    
    FormatJSTest.verifyFormat(new StringRef(/*KEEP_STR*/"someFunction(goog.bind(function() {\n  doSomething();\n  doSomething();\n}, this), goog.bind(function() {\n  doSomething();\n  doSomething();\n}, this));"));
    
    // FIXME: This is bad, we should be wrapping before "function() {".
    FormatJSTest.verifyFormat(new StringRef(/*KEEP_STR*/"someFunction(function() {\n  doSomething();  // break\n})\n    .doSomethingElse(\n        // break\n        );"));
  } finally {
    $c$.$destroy();
  }
}

;
@Test
//<editor-fold defaultstate="collapsed" desc="clang::format::FormatTestJS_InliningFunctionLiterals_Test::TestBody">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTestJS.cpp", line = 515,
 FQN="clang::format::FormatTestJS_InliningFunctionLiterals_Test::TestBody", NM="_ZN5clang6format42FormatTestJS_InliningFunctionLiterals_Test8TestBodyEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTestJS.cpp -nm=_ZN5clang6format42FormatTestJS_InliningFunctionLiterals_Test8TestBodyEv")
//</editor-fold>
public void test_InliningFunctionLiterals() {
  if (markAsSkippedIfNeed(TestState.Successful)) { return; }
  FormatStyle Style = null;
  try {
    Style = getGoogleStyle(FormatStyle.LanguageKind.LK_JavaScript);
    Style.AllowShortFunctionsOnASingleLine = FormatStyle.ShortFunctionStyle.SFS_Inline;
    FormatJSTest.verifyFormat(new StringRef(/*KEEP_STR*/"var func = function() {\n  return 1;\n};"), 
        Style);
    FormatJSTest.verifyFormat(new StringRef(/*KEEP_STR*/"var func = doSomething(function() { return 1; });"), Style);
    FormatJSTest.verifyFormat(new StringRef(/*KEEP_STR*/"var outer = function() {\n  var inner = function() { return 1; }\n};"), 
        Style);
    FormatJSTest.verifyFormat(new StringRef(/*KEEP_STR*/"function outer1(a, b) {\n  function inner1(a, b) { return a; }\n}"), 
        Style);
    
    Style.AllowShortFunctionsOnASingleLine = FormatStyle.ShortFunctionStyle.SFS_All;
    FormatJSTest.verifyFormat(new StringRef(/*KEEP_STR*/"var func = function() { return 1; };"), Style);
    FormatJSTest.verifyFormat(new StringRef(/*KEEP_STR*/"var func = doSomething(function() { return 1; });"), Style);
    FormatJSTest.verifyFormat(new StringRef(/*KEEP_STR*/"var outer = function() { var inner = function() { return 1; } };"), 
        Style);
    FormatJSTest.verifyFormat(new StringRef(/*KEEP_STR*/"function outer1(a, b) {\n  function inner1(a, b) { return a; }\n}"), 
        Style);
    
    Style.AllowShortFunctionsOnASingleLine = FormatStyle.ShortFunctionStyle.SFS_None;
    FormatJSTest.verifyFormat(new StringRef(/*KEEP_STR*/"var func = function() {\n  return 1;\n};"), 
        Style);
    FormatJSTest.verifyFormat(new StringRef(/*KEEP_STR*/"var func = doSomething(function() {\n  return 1;\n});"), 
        Style);
    FormatJSTest.verifyFormat(new StringRef(/*KEEP_STR*/"var outer = function() {\n  var inner = function() {\n    return 1;\n  }\n};"), 
        Style);
    FormatJSTest.verifyFormat(new StringRef(/*KEEP_STR*/"function outer1(a, b) {\n  function inner1(a, b) {\n    return a;\n  }\n}"), 
        Style);
    
    Style.AllowShortFunctionsOnASingleLine = FormatStyle.ShortFunctionStyle.SFS_Empty;
    FormatJSTest.verifyFormat(new StringRef(/*KEEP_STR*/"var func = function() {\n  return 1;\n};"), 
        Style);
  } finally {
    if (Style != null) { Style.$destroy(); }
  }
}

;
@Test
//<editor-fold defaultstate="collapsed" desc="clang::format::FormatTestJS_MultipleFunctionLiterals_Test::TestBody">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTestJS.cpp", line = 572,
 FQN="clang::format::FormatTestJS_MultipleFunctionLiterals_Test::TestBody", NM="_ZN5clang6format42FormatTestJS_MultipleFunctionLiterals_Test8TestBodyEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTestJS.cpp -nm=_ZN5clang6format42FormatTestJS_MultipleFunctionLiterals_Test8TestBodyEv")
//</editor-fold>
public void test_MultipleFunctionLiterals() {
  if (markAsSkippedIfNeed(TestState.Successful)) { return; }
  FormatJSTest.verifyFormat(new StringRef(/*KEEP_STR*/"promise.then(\n    function success() {\n      doFoo();\n      doBar();\n    },\n    function error() {\n      doFoo();\n      doBaz();\n    },\n    []);\n"));
  FormatJSTest.verifyFormat(new StringRef(/*KEEP_STR*/"promise.then(\n    function success() {\n      doFoo();\n      doBar();\n    },\n    [],\n    function error() {\n      doFoo();\n      doBaz();\n    });\n"));
  FormatJSTest.verifyFormat(new StringRef(/*KEEP_STR*/"promise.then(\n    [],\n    function success() {\n      doFoo();\n      doBar();\n    },\n    function error() {\n      doFoo();\n      doBaz();\n    });\n"));
  
  FormatJSTest.verifyFormat(new StringRef(/*KEEP_STR*/"getSomeLongPromise()\n    .then(function(value) { body(); })\n    .thenCatch(function(error) {\n      body();\n      body();\n    });"));
  FormatJSTest.verifyFormat(new StringRef(/*KEEP_STR*/"getSomeLongPromise()\n    .then(function(value) {\n      body();\n      body();\n    })\n    .thenCatch(function(error) {\n      body();\n      body();\n    });"));
  
  FormatJSTest.verifyFormat(new StringRef(/*KEEP_STR*/"getSomeLongPromise()\n    .then(function(value) { body(); })\n    .thenCatch(function(error) { body(); });"));
  
  FormatJSTest.verifyFormat(new StringRef(/*KEEP_STR*/"return [aaaaaaaaaaaaaaaaaaaaaa]\n    .aaaaaaa(function() {\n      //\n    })\n    .bbbbbb();"));
}

;
@Test
//<editor-fold defaultstate="collapsed" desc="clang::format::FormatTestJS_ArrowFunctions_Test::TestBody">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTestJS.cpp", line = 631,
 FQN="clang::format::FormatTestJS_ArrowFunctions_Test::TestBody", NM="_ZN5clang6format32FormatTestJS_ArrowFunctions_Test8TestBodyEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTestJS.cpp -nm=_ZN5clang6format32FormatTestJS_ArrowFunctions_Test8TestBodyEv")
//</editor-fold>
public void test_ArrowFunctions() {
  if (markAsSkippedIfNeed(TestState.Successful)) { return; }
  FormatJSTest.verifyFormat(new StringRef(/*KEEP_STR*/"var x = (a) => {\n  return a;\n};"));
  FormatJSTest.verifyFormat(new StringRef(/*KEEP_STR*/"var x = (a) => {\n  function y() { return 42; }\n  return a;\n};"));
  FormatJSTest.verifyFormat(new StringRef(/*KEEP_STR*/"var x = (a: type): {some: type} => {\n  return a;\n};"));
  FormatJSTest.verifyFormat(new StringRef(/*KEEP_STR*/"var x = (a) => a;"));
  FormatJSTest.verifyFormat(new StringRef(/*KEEP_STR*/"return () => [];"));
  FormatJSTest.verifyFormat(new StringRef(/*KEEP_STR*/"var aaaaaaaaaaaaaaaaaaaa = {\n  aaaaaaaaaaaaaaaaaaaaaaaaaaaa:\n      (aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa,\n       aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa) =>\n          aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa,\n};"));
  FormatJSTest.verifyFormat(new StringRef(/*KEEP_STR*/"var a = a.aaaaaaa(\n    (a: a) => aaaaaaaaaaaaaaaaaaaaaaaaa(bbbbbbbbb) &&\n        aaaaaaaaaaaaaaaaaaaaaaaaa(bbbbbbb));"));
  FormatJSTest.verifyFormat(new StringRef(/*KEEP_STR*/"var a = a.aaaaaaa(\n    (a: a) => aaaaaaaaaaaaaaaaaaaaa(bbbbbbbbb) ?\n        aaaaaaaaaaaaaaaaaaaaa(bbbbbbb) :\n        aaaaaaaaaaaaaaaaaaaaa(bbbbbbb));"));
  
  // FIXME: This is bad, we should be wrapping before "() => {".
  FormatJSTest.verifyFormat(new StringRef(/*KEEP_STR*/"someFunction(() => {\n  doSomething();  // break\n})\n    .doSomethingElse(\n        // break\n        );"));
}

;
@Test
//<editor-fold defaultstate="collapsed" desc="clang::format::FormatTestJS_ReturnStatements_Test::TestBody">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTestJS.cpp", line = 667,
 FQN="clang::format::FormatTestJS_ReturnStatements_Test::TestBody", NM="_ZN5clang6format34FormatTestJS_ReturnStatements_Test8TestBodyEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTestJS.cpp -nm=_ZN5clang6format34FormatTestJS_ReturnStatements_Test8TestBodyEv")
//</editor-fold>
public void test_ReturnStatements() {
  if (markAsSkippedIfNeed(TestState.Successful)) { return; }
  FormatJSTest.verifyFormat(new StringRef(/*KEEP_STR*/"function() {\n  return [hello, world];\n}"));
}

;
@Test
//<editor-fold defaultstate="collapsed" desc="clang::format::FormatTestJS_ForLoops_Test::TestBody">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTestJS.cpp", line = 673,
 FQN="clang::format::FormatTestJS_ForLoops_Test::TestBody", NM="_ZN5clang6format26FormatTestJS_ForLoops_Test8TestBodyEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTestJS.cpp -nm=_ZN5clang6format26FormatTestJS_ForLoops_Test8TestBodyEv")
//</editor-fold>
public void test_ForLoops() {
  if (markAsSkippedIfNeed(TestState.Successful)) { return; }
  FormatJSTest.verifyFormat(new StringRef(/*KEEP_STR*/"for (var i in [2, 3]) {\n}"));
  FormatJSTest.verifyFormat(new StringRef(/*KEEP_STR*/"for (var i of [2, 3]) {\n}"));
  FormatJSTest.verifyFormat(new StringRef(/*KEEP_STR*/"for (let {a, b} of x) {\n}"));
  FormatJSTest.verifyFormat(new StringRef(/*KEEP_STR*/"for (let {a, b} in x) {\n}"));
}

;
@Test
//<editor-fold defaultstate="collapsed" desc="clang::format::FormatTestJS_WrapRespectsAutomaticSemicolonInsertion_Test::TestBody">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTestJS.cpp", line = 684,
 FQN="clang::format::FormatTestJS_WrapRespectsAutomaticSemicolonInsertion_Test::TestBody", NM="_ZN5clang6format57FormatTestJS_WrapRespectsAutomaticSemicolonInsertion_Test8TestBodyEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTestJS.cpp -nm=_ZN5clang6format57FormatTestJS_WrapRespectsAutomaticSemicolonInsertion_Test8TestBodyEv")
//</editor-fold>
public void test_WrapRespectsAutomaticSemicolonInsertion() {
  if (markAsSkippedIfNeed(TestState.Successful)) { return; }
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    // The following statements must not wrap, as otherwise the program meaning
    // would change due to automatic semicolon insertion.
    // See http://www.ecma-international.org/ecma-262/5.1/#sec-7.9.1.
    FormatJSTest.verifyFormat(new StringRef(/*KEEP_STR*/"return aaaaa;"), $c$.track(FormatJSTest.getGoogleJSStyleWithColumns(10))); $c$.clean();
    FormatJSTest.verifyFormat(new StringRef(/*KEEP_STR*/"continue aaaaa;"), $c$.track(FormatJSTest.getGoogleJSStyleWithColumns(10))); $c$.clean();
    FormatJSTest.verifyFormat(new StringRef(/*KEEP_STR*/"break aaaaa;"), $c$.track(FormatJSTest.getGoogleJSStyleWithColumns(10))); $c$.clean();
    FormatJSTest.verifyFormat(new StringRef(/*KEEP_STR*/"throw aaaaa;"), $c$.track(FormatJSTest.getGoogleJSStyleWithColumns(10))); $c$.clean();
    FormatJSTest.verifyFormat(new StringRef(/*KEEP_STR*/"aaaaaaaaa++;"), $c$.track(FormatJSTest.getGoogleJSStyleWithColumns(10))); $c$.clean();
    FormatJSTest.verifyFormat(new StringRef(/*KEEP_STR*/"aaaaaaaaa--;"), $c$.track(FormatJSTest.getGoogleJSStyleWithColumns(10))); $c$.clean();
    FormatJSTest.verifyFormat(new StringRef(/*KEEP_STR*/"return [\n  aaa\n];"), 
        $c$.track(FormatJSTest.getGoogleJSStyleWithColumns(12))); $c$.clean();
  } finally {
    $c$.$destroy();
  }
}

;
@Test
//<editor-fold defaultstate="collapsed" desc="clang::format::FormatTestJS_AutomaticSemicolonInsertionHeuristic_Test::TestBody">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTestJS.cpp", line = 700,
 FQN="clang::format::FormatTestJS_AutomaticSemicolonInsertionHeuristic_Test::TestBody", NM="_ZN5clang6format54FormatTestJS_AutomaticSemicolonInsertionHeuristic_Test8TestBodyEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTestJS.cpp -nm=_ZN5clang6format54FormatTestJS_AutomaticSemicolonInsertionHeuristic_Test8TestBodyEv")
//</editor-fold>
public void test_AutomaticSemicolonInsertionHeuristic() {
  if (markAsSkippedIfNeed(TestState.Successful)) { return; }
  FormatJSTest.verifyFormat(new StringRef(/*KEEP_STR*/"a\nb;"), 
      new StringRef(/*KEEP_STR*/" a \n b ;"));
  FormatJSTest.verifyFormat(new StringRef(/*KEEP_STR*/"a()\nb;"), 
      new StringRef(/*KEEP_STR*/" a ()\n b ;"));
  FormatJSTest.verifyFormat(new StringRef(/*KEEP_STR*/"a[b]\nc;"), 
      new StringRef(/*KEEP_STR*/"a [b]\nc ;"));
  FormatJSTest.verifyFormat(new StringRef(/*KEEP_STR*/"1\na;"), 
      new StringRef(/*KEEP_STR*/"1 \na ;"));
  FormatJSTest.verifyFormat(new StringRef(/*KEEP_STR*/"a\n1;"), 
      new StringRef(/*KEEP_STR*/"a \n1 ;"));
  FormatJSTest.verifyFormat(new StringRef(/*KEEP_STR*/"a\n'x';"), 
      new StringRef(/*KEEP_STR*/"a \n 'x';"));
  FormatJSTest.verifyFormat(new StringRef(/*KEEP_STR*/"a++\nb;"), 
      new StringRef(/*KEEP_STR*/"a ++\nb ;"));
  FormatJSTest.verifyFormat(new StringRef(/*KEEP_STR*/"a\n!b && c;"), 
      new StringRef(/*KEEP_STR*/"a \n ! b && c;"));
  FormatJSTest.verifyFormat(new StringRef(/*KEEP_STR*/"a\nif (1) f();"), 
      new StringRef(/*KEEP_STR*/" a\n if (1) f();"));
  FormatJSTest.verifyFormat(new StringRef(/*KEEP_STR*/"a\nclass X {}"), 
      new StringRef(/*KEEP_STR*/" a\n class X {}"));
  FormatJSTest.verifyFormat(new StringRef(/*KEEP_STR*/"var a"), new StringRef(/*KEEP_STR*/"var\na"));
  FormatJSTest.verifyFormat(new StringRef(/*KEEP_STR*/"x instanceof String"), new StringRef(/*KEEP_STR*/"x\ninstanceof\nString"));
  FormatJSTest.verifyFormat(new StringRef(/*KEEP_STR*/"function f(@Foo bar) {}"), new StringRef(/*KEEP_STR*/"function f(@Foo\n  bar) {}"));
}

;
@Test
//<editor-fold defaultstate="collapsed" desc="clang::format::FormatTestJS_ClosureStyleCasts_Test::TestBody">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTestJS.cpp", line = 750,
 FQN="clang::format::FormatTestJS_ClosureStyleCasts_Test::TestBody", NM="_ZN5clang6format35FormatTestJS_ClosureStyleCasts_Test8TestBodyEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTestJS.cpp -nm=_ZN5clang6format35FormatTestJS_ClosureStyleCasts_Test8TestBodyEv")
//</editor-fold>
public void test_ClosureStyleCasts() {
  if (markAsSkippedIfNeed(TestState.Successful)) { return; }
  FormatJSTest.verifyFormat(new StringRef(/*KEEP_STR*/"var x = /** @type {foo} */ (bar);"));
}

;
@Test
//<editor-fold defaultstate="collapsed" desc="clang::format::FormatTestJS_TryCatch_Test::TestBody">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTestJS.cpp", line = 754,
 FQN="clang::format::FormatTestJS_TryCatch_Test::TestBody", NM="_ZN5clang6format26FormatTestJS_TryCatch_Test8TestBodyEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTestJS.cpp -nm=_ZN5clang6format26FormatTestJS_TryCatch_Test8TestBodyEv")
//</editor-fold>
public void test_TryCatch() {
  if (markAsSkippedIfNeed(TestState.Successful)) { return; }
  FormatJSTest.verifyFormat(new StringRef(/*KEEP_STR*/"try {\n  f();\n} catch (e) {\n  g();\n} finally {\n  h();\n}"));
  
  // But, of course, "catch" is a perfectly fine function name in JavaScript.
  FormatJSTest.verifyFormat(new StringRef(/*KEEP_STR*/"someObject.catch();"));
  FormatJSTest.verifyFormat(new StringRef(/*KEEP_STR*/"someObject.new();"));
  FormatJSTest.verifyFormat(new StringRef(/*KEEP_STR*/"someObject.delete();"));
}

;
@Test
//<editor-fold defaultstate="collapsed" desc="clang::format::FormatTestJS_StringLiteralConcatenation_Test::TestBody">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTestJS.cpp", line = 769,
 FQN="clang::format::FormatTestJS_StringLiteralConcatenation_Test::TestBody", NM="_ZN5clang6format44FormatTestJS_StringLiteralConcatenation_Test8TestBodyEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTestJS.cpp -nm=_ZN5clang6format44FormatTestJS_StringLiteralConcatenation_Test8TestBodyEv")
//</editor-fold>
public void test_StringLiteralConcatenation() {
  if (markAsSkippedIfNeed(TestState.Successful)) { return; }
  FormatJSTest.verifyFormat(new StringRef(/*KEEP_STR*/"var literal = 'hello ' +\n    'world';"));
}

;
@Test
//<editor-fold defaultstate="collapsed" desc="clang::format::FormatTestJS_RegexLiteralClassification_Test::TestBody">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTestJS.cpp", line = 774,
 FQN="clang::format::FormatTestJS_RegexLiteralClassification_Test::TestBody", NM="_ZN5clang6format44FormatTestJS_RegexLiteralClassification_Test8TestBodyEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTestJS.cpp -nm=_ZN5clang6format44FormatTestJS_RegexLiteralClassification_Test8TestBodyEv")
//</editor-fold>
public void test_RegexLiteralClassification() {
  if (markAsSkippedIfNeed(TestState.Successful)) { return; }
  // Regex literals.
  FormatJSTest.verifyFormat(new StringRef(/*KEEP_STR*/"var regex = /abc/;"));
  FormatJSTest.verifyFormat(new StringRef(/*KEEP_STR*/"f(/abc/);"));
  FormatJSTest.verifyFormat(new StringRef(/*KEEP_STR*/"f(abc, /abc/);"));
  FormatJSTest.verifyFormat(new StringRef(/*KEEP_STR*/"some_map[/abc/];"));
  FormatJSTest.verifyFormat(new StringRef(/*KEEP_STR*/"var x = a ? /abc/ : /abc/;"));
  FormatJSTest.verifyFormat(new StringRef(/*KEEP_STR*/"for (var i = 0; /abc/.test(s[i]); i++) {\n}"));
  FormatJSTest.verifyFormat(new StringRef(/*KEEP_STR*/"var x = !/abc/.test(y);"));
  FormatJSTest.verifyFormat(new StringRef(/*KEEP_STR*/"var x = a && /abc/.test(y);"));
  FormatJSTest.verifyFormat(new StringRef(/*KEEP_STR*/"var x = a || /abc/.test(y);"));
  FormatJSTest.verifyFormat(new StringRef(/*KEEP_STR*/"var x = a + /abc/.search(y);"));
  FormatJSTest.verifyFormat(new StringRef(/*KEEP_STR*/"/abc/.search(y);"));
  FormatJSTest.verifyFormat(new StringRef(/*KEEP_STR*/"var regexs = {/abc/, /abc/};"));
  FormatJSTest.verifyFormat(new StringRef(/*KEEP_STR*/"return /abc/;"));
  
  // Not regex literals.
  FormatJSTest.verifyFormat(new StringRef(/*KEEP_STR*/"var a = a / 2 + b / 3;"));
  FormatJSTest.verifyFormat(new StringRef(/*KEEP_STR*/"var a = a++ / 2;"));
  // Prefix unary can operate on regex literals, not that it makes sense.
  FormatJSTest.verifyFormat(new StringRef(/*KEEP_STR*/"var a = ++/a/;"));
  
  // This is a known issue, regular expressions are incorrectly detected if
  // directly following a closing parenthesis.
  FormatJSTest.verifyFormat(new StringRef(/*KEEP_STR*/"if (foo) / bar /.exec(baz);"));
}

;
@Test
//<editor-fold defaultstate="collapsed" desc="clang::format::FormatTestJS_RegexLiteralSpecialCharacters_Test::TestBody">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTestJS.cpp", line = 801,
 FQN="clang::format::FormatTestJS_RegexLiteralSpecialCharacters_Test::TestBody", NM="_ZN5clang6format47FormatTestJS_RegexLiteralSpecialCharacters_Test8TestBodyEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTestJS.cpp -nm=_ZN5clang6format47FormatTestJS_RegexLiteralSpecialCharacters_Test8TestBodyEv")
//</editor-fold>
public void test_RegexLiteralSpecialCharacters() {
  if (markAsSkippedIfNeed(TestState.Successful)) { return; }
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    FormatJSTest.verifyFormat(new StringRef(/*KEEP_STR*/"var regex = /=/;"));
    FormatJSTest.verifyFormat(new StringRef(/*KEEP_STR*/"var regex = /a*/;"));
    FormatJSTest.verifyFormat(new StringRef(/*KEEP_STR*/"var regex = /a+/;"));
    FormatJSTest.verifyFormat(new StringRef(/*KEEP_STR*/"var regex = /a?/;"));
    FormatJSTest.verifyFormat(new StringRef(/*KEEP_STR*/"var regex = /.a./;"));
    FormatJSTest.verifyFormat(new StringRef(/*KEEP_STR*/"var regex = /a\\*/;"));
    FormatJSTest.verifyFormat(new StringRef(/*KEEP_STR*/"var regex = /^a$/;"));
    FormatJSTest.verifyFormat(new StringRef(/*KEEP_STR*/"var regex = /\\/a/;"));
    FormatJSTest.verifyFormat(new StringRef(/*KEEP_STR*/"var regex = /(?:x)/;"));
    FormatJSTest.verifyFormat(new StringRef(/*KEEP_STR*/"var regex = /x(?=y)/;"));
    FormatJSTest.verifyFormat(new StringRef(/*KEEP_STR*/"var regex = /x(?!y)/;"));
    FormatJSTest.verifyFormat(new StringRef(/*KEEP_STR*/"var regex = /x|y/;"));
    FormatJSTest.verifyFormat(new StringRef(/*KEEP_STR*/"var regex = /a{2}/;"));
    FormatJSTest.verifyFormat(new StringRef(/*KEEP_STR*/"var regex = /a{1,3}/;"));
    
    FormatJSTest.verifyFormat(new StringRef(/*KEEP_STR*/"var regex = /[abc]/;"));
    FormatJSTest.verifyFormat(new StringRef(/*KEEP_STR*/"var regex = /[^abc]/;"));
    FormatJSTest.verifyFormat(new StringRef(/*KEEP_STR*/"var regex = /[\\b]/;"));
    FormatJSTest.verifyFormat(new StringRef(/*KEEP_STR*/"var regex = /[/]/;"));
    FormatJSTest.verifyFormat(new StringRef(/*KEEP_STR*/"var regex = /[\\/]/;"));
    FormatJSTest.verifyFormat(new StringRef(/*KEEP_STR*/"var regex = /\\[/;"));
    FormatJSTest.verifyFormat(new StringRef(/*KEEP_STR*/"var regex = /\\\\[/]/;"));
    FormatJSTest.verifyFormat(new StringRef(/*KEEP_STR*/"var regex = /}[\"]/;"));
    FormatJSTest.verifyFormat(new StringRef(/*KEEP_STR*/"var regex = /}[/\"]/;"));
    FormatJSTest.verifyFormat(new StringRef(/*KEEP_STR*/"var regex = /}[\"/]/;"));
    
    FormatJSTest.verifyFormat(new StringRef(/*KEEP_STR*/"var regex = /\\b/;"));
    FormatJSTest.verifyFormat(new StringRef(/*KEEP_STR*/"var regex = /\\B/;"));
    FormatJSTest.verifyFormat(new StringRef(/*KEEP_STR*/"var regex = /\\d/;"));
    FormatJSTest.verifyFormat(new StringRef(/*KEEP_STR*/"var regex = /\\D/;"));
    FormatJSTest.verifyFormat(new StringRef(/*KEEP_STR*/"var regex = /\\f/;"));
    FormatJSTest.verifyFormat(new StringRef(/*KEEP_STR*/"var regex = /\\n/;"));
    FormatJSTest.verifyFormat(new StringRef(/*KEEP_STR*/"var regex = /\\r/;"));
    FormatJSTest.verifyFormat(new StringRef(/*KEEP_STR*/"var regex = /\\s/;"));
    FormatJSTest.verifyFormat(new StringRef(/*KEEP_STR*/"var regex = /\\S/;"));
    FormatJSTest.verifyFormat(new StringRef(/*KEEP_STR*/"var regex = /\\t/;"));
    FormatJSTest.verifyFormat(new StringRef(/*KEEP_STR*/"var regex = /\\v/;"));
    FormatJSTest.verifyFormat(new StringRef(/*KEEP_STR*/"var regex = /\\w/;"));
    FormatJSTest.verifyFormat(new StringRef(/*KEEP_STR*/"var regex = /\\W/;"));
    FormatJSTest.verifyFormat(new StringRef(/*KEEP_STR*/"var regex = /a(a)\\1/;"));
    FormatJSTest.verifyFormat(new StringRef(/*KEEP_STR*/"var regex = /\\0/;"));
    FormatJSTest.verifyFormat(new StringRef(/*KEEP_STR*/"var regex = /\\\\/g;"));
    FormatJSTest.verifyFormat(new StringRef(/*KEEP_STR*/"var regex = /\\a\\\\/g;"));
    FormatJSTest.verifyFormat(new StringRef(/*KEEP_STR*/"var regex = /\u00007\\//g;")); // JAVA: original was "var regex = /\n\\//g;"
    FormatJSTest.verifyFormat(new StringRef(/*KEEP_STR*/"var regex = /a\\//;\nvar x = 0;"));
    FormatJSTest.verifyFormat(new StringRef(/*KEEP_STR*/"var regex = /'/g;"), new StringRef(/*KEEP_STR*/"var regex = /'/g ;"));
    FormatJSTest.verifyFormat(new StringRef(/*KEEP_STR*/"var regex = /'/g;  //'"), new StringRef(/*KEEP_STR*/"var regex = /'/g ; //'"));
    FormatJSTest.verifyFormat(new StringRef(/*KEEP_STR*/"var regex = /\\/*/;\nvar x = 0;"), 
        new StringRef(/*KEEP_STR*/"var regex = /\\/*/;\nvar x=0;"));
    FormatJSTest.verifyFormat(new StringRef(/*KEEP_STR*/"var x = /a\\//;"), new StringRef(/*KEEP_STR*/"var x = /a\\//  \n;"));
    FormatJSTest.verifyFormat(new StringRef(/*KEEP_STR*/"var regex = /\"/;"), $c$.track(FormatJSTest.getGoogleJSStyleWithColumns(16))); $c$.clean();
    FormatJSTest.verifyFormat(new StringRef(/*KEEP_STR*/"var regex =\n    /\"/;"), 
        $c$.track(FormatJSTest.getGoogleJSStyleWithColumns(15))); $c$.clean();
    FormatJSTest.verifyFormat(new StringRef(/*KEEP_STR*/"var regex =  //\n    /a/;"));
    FormatJSTest.verifyFormat(new StringRef(/*KEEP_STR*/"var regexs = [\n  /d/,   //\n  /aa/,  //\n];"));
  } finally {
    $c$.$destroy();
  }
}

;
@Test
//<editor-fold defaultstate="collapsed" desc="clang::format::FormatTestJS_RegexLiteralModifiers_Test::TestBody">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTestJS.cpp", line = 867,
 FQN="clang::format::FormatTestJS_RegexLiteralModifiers_Test::TestBody", NM="_ZN5clang6format39FormatTestJS_RegexLiteralModifiers_Test8TestBodyEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTestJS.cpp -nm=_ZN5clang6format39FormatTestJS_RegexLiteralModifiers_Test8TestBodyEv")
//</editor-fold>
public void test_RegexLiteralModifiers() {
  if (markAsSkippedIfNeed(TestState.Successful)) { return; }
  FormatJSTest.verifyFormat(new StringRef(/*KEEP_STR*/"var regex = /abc/g;"));
  FormatJSTest.verifyFormat(new StringRef(/*KEEP_STR*/"var regex = /abc/i;"));
  FormatJSTest.verifyFormat(new StringRef(/*KEEP_STR*/"var regex = /abc/m;"));
  FormatJSTest.verifyFormat(new StringRef(/*KEEP_STR*/"var regex = /abc/y;"));
}

;
@Test
//<editor-fold defaultstate="collapsed" desc="clang::format::FormatTestJS_RegexLiteralLength_Test::TestBody">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTestJS.cpp", line = 874,
 FQN="clang::format::FormatTestJS_RegexLiteralLength_Test::TestBody", NM="_ZN5clang6format36FormatTestJS_RegexLiteralLength_Test8TestBodyEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTestJS.cpp -nm=_ZN5clang6format36FormatTestJS_RegexLiteralLength_Test8TestBodyEv")
//</editor-fold>
public void test_RegexLiteralLength() {
  if (markAsSkippedIfNeed(TestState.Successful)) { return; }
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    FormatJSTest.verifyFormat(new StringRef(/*KEEP_STR*/"var regex = /aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa/;"), 
        $c$.track(FormatJSTest.getGoogleJSStyleWithColumns(60))); $c$.clean();
    FormatJSTest.verifyFormat(new StringRef(/*KEEP_STR*/"var regex =\n    /aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa/;"), 
        $c$.track(FormatJSTest.getGoogleJSStyleWithColumns(60))); $c$.clean();
    FormatJSTest.verifyFormat(new StringRef(/*KEEP_STR*/"var regex = /\\xaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa/;"), 
        $c$.track(FormatJSTest.getGoogleJSStyleWithColumns(50))); $c$.clean();
  } finally {
    $c$.$destroy();
  }
}

;
@Test
//<editor-fold defaultstate="collapsed" desc="clang::format::FormatTestJS_RegexLiteralExamples_Test::TestBody">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTestJS.cpp", line = 884,
 FQN="clang::format::FormatTestJS_RegexLiteralExamples_Test::TestBody", NM="_ZN5clang6format38FormatTestJS_RegexLiteralExamples_Test8TestBodyEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTestJS.cpp -nm=_ZN5clang6format38FormatTestJS_RegexLiteralExamples_Test8TestBodyEv")
//</editor-fold>
public void test_RegexLiteralExamples() {
  if (markAsSkippedIfNeed(TestState.Successful)) { return; }
  FormatJSTest.verifyFormat(new StringRef(/*KEEP_STR*/"var regex = search.match(/(?:?|&)times=([^?&]+)/i);"));
}

;
@Test
//<editor-fold defaultstate="collapsed" desc="clang::format::FormatTestJS_TypeAnnotations_Test::TestBody">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTestJS.cpp", line = 888,
 FQN="clang::format::FormatTestJS_TypeAnnotations_Test::TestBody", NM="_ZN5clang6format33FormatTestJS_TypeAnnotations_Test8TestBodyEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTestJS.cpp -nm=_ZN5clang6format33FormatTestJS_TypeAnnotations_Test8TestBodyEv")
//</editor-fold>
public void test_TypeAnnotations() {
  if (markAsSkippedIfNeed(TestState.Successful)) { return; }
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    FormatJSTest.verifyFormat(new StringRef(/*KEEP_STR*/"var x: string;"));
    FormatJSTest.verifyFormat(new StringRef(/*KEEP_STR*/"var x: {a: string; b: number;} = {};"));
    FormatJSTest.verifyFormat(new StringRef(/*KEEP_STR*/"function x(): string {\n  return 'x';\n}"));
    FormatJSTest.verifyFormat(new StringRef(/*KEEP_STR*/"function x(): {x: string} {\n  return {x: 'x'};\n}"));
    FormatJSTest.verifyFormat(new StringRef(/*KEEP_STR*/"function x(y: string): string {\n  return 'x';\n}"));
    FormatJSTest.verifyFormat(new StringRef(/*KEEP_STR*/"for (var y: string in x) {\n  x();\n}"));
    FormatJSTest.verifyFormat(new StringRef(/*KEEP_STR*/"for (var y: string of x) {\n  x();\n}"));
    FormatJSTest.verifyFormat(new StringRef(/*KEEP_STR*/"function x(y: {a?: number;} = {}): number {\n  return 12;\n}"));
    FormatJSTest.verifyFormat(new StringRef(/*KEEP_STR*/"((a: string, b: number): string => a + b);"));
    FormatJSTest.verifyFormat(new StringRef(/*KEEP_STR*/"var x: (y: number) => string;"));
    FormatJSTest.verifyFormat(new StringRef(/*KEEP_STR*/"var x: P<string, (a: number) => string>;"));
    FormatJSTest.verifyFormat(new StringRef(/*KEEP_STR*/"var x = {y: function(): z { return 1; }};"));
    FormatJSTest.verifyFormat(new StringRef(/*KEEP_STR*/"var x = {y: function(): {a: number} { return 1; }};"));
    FormatJSTest.verifyFormat(new StringRef(/*KEEP_STR*/"function someFunc(args: string[]):\n    {longReturnValue: string[]} {}"), 
        $c$.track(FormatJSTest.getGoogleJSStyleWithColumns(60))); $c$.clean();
  } finally {
    $c$.$destroy();
  }
}

;
@Test
//<editor-fold defaultstate="collapsed" desc="clang::format::FormatTestJS_UnionIntersectionTypes_Test::TestBody">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTestJS.cpp", line = 909,
 FQN="clang::format::FormatTestJS_UnionIntersectionTypes_Test::TestBody", NM="_ZN5clang6format40FormatTestJS_UnionIntersectionTypes_Test8TestBodyEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTestJS.cpp -nm=_ZN5clang6format40FormatTestJS_UnionIntersectionTypes_Test8TestBodyEv")
//</editor-fold>
public void test_UnionIntersectionTypes() {
  if (markAsSkippedIfNeed(TestState.Successful)) { return; }
  FormatJSTest.verifyFormat(new StringRef(/*KEEP_STR*/"let x: A|B = A | B;"));
  FormatJSTest.verifyFormat(new StringRef(/*KEEP_STR*/"let x: A&B|C = A & B;"));
  FormatJSTest.verifyFormat(new StringRef(/*KEEP_STR*/"let x: Foo<A|B> = new Foo<A|B>();"));
  FormatJSTest.verifyFormat(new StringRef(/*KEEP_STR*/"function(x: A|B): C&D {}"));
  FormatJSTest.verifyFormat(new StringRef(/*KEEP_STR*/"function(x: A|B = A | B): C&D {}"));
  FormatJSTest.verifyFormat(new StringRef(/*KEEP_STR*/"function x(path: number|string) {}"));
  FormatJSTest.verifyFormat(new StringRef(/*KEEP_STR*/"function x(): string|number {}"));
  FormatJSTest.verifyFormat(new StringRef(/*KEEP_STR*/"type Foo = Bar|Baz;"));
  FormatJSTest.verifyFormat(new StringRef(/*KEEP_STR*/"type Foo = Bar<X>|Baz;"));
  FormatJSTest.verifyFormat(new StringRef(/*KEEP_STR*/"type Foo = (Bar<X>|Baz);"));
  FormatJSTest.verifyFormat(new StringRef(/*KEEP_STR*/"let x: Bar|Baz;"));
  FormatJSTest.verifyFormat(new StringRef(/*KEEP_STR*/"let x: Bar<X>|Baz;"));
  FormatJSTest.verifyFormat(new StringRef(/*KEEP_STR*/"let x: (Foo|Bar)[];"));
}

;
@Test
//<editor-fold defaultstate="collapsed" desc="clang::format::FormatTestJS_ClassDeclarations_Test::TestBody">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTestJS.cpp", line = 925,
 FQN="clang::format::FormatTestJS_ClassDeclarations_Test::TestBody", NM="_ZN5clang6format35FormatTestJS_ClassDeclarations_Test8TestBodyEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTestJS.cpp -nm=_ZN5clang6format35FormatTestJS_ClassDeclarations_Test8TestBodyEv")
//</editor-fold>
public void test_ClassDeclarations() {
  if (markAsSkippedIfNeed(TestState.Successful)) { return; }
  FormatJSTest.verifyFormat(new StringRef(/*KEEP_STR*/"class C {\n  x: string = 12;\n}"));
  FormatJSTest.verifyFormat(new StringRef(/*KEEP_STR*/"class C {\n  x(): string => 12;\n}"));
  FormatJSTest.verifyFormat(new StringRef(/*KEEP_STR*/"class C {\n  ['x' + 2]: string = 12;\n}"));
  FormatJSTest.verifyFormat(new StringRef(/*KEEP_STR*/"class C {\n  private x: string = 12;\n}"));
  FormatJSTest.verifyFormat(new StringRef(/*KEEP_STR*/"class C {\n  private static x: string = 12;\n}"));
  FormatJSTest.verifyFormat(new StringRef(/*KEEP_STR*/"class C {\n  static x(): string { return 'asd'; }\n}"));
  FormatJSTest.verifyFormat(new StringRef(/*KEEP_STR*/"class C extends P implements I {}"));
  FormatJSTest.verifyFormat(new StringRef(/*KEEP_STR*/"class C extends p.P implements i.I {}"));
  FormatJSTest.verifyFormat(new StringRef(/*KEEP_STR*/"class Test {\n  aaaaaaaaaaaaaaaa(aaaaaaaaaaaaaaa: aaaaaaaaaaaaaaaaaaaa):\n      aaaaaaaaaaaaaaaaaaaaaa {}\n}"));
  FormatJSTest.verifyFormat(new StringRef(/*KEEP_STR*/"foo = class Name {\n  constructor() {}\n};"));
  FormatJSTest.verifyFormat(new StringRef(/*KEEP_STR*/"foo = class {\n  constructor() {}\n};"));
  FormatJSTest.verifyFormat(new StringRef(/*KEEP_STR*/"class C {\n  x: {y: Z;} = {};\n  private y: {y: Z;} = {};\n}"));
  
  // ':' is not a type declaration here.
  FormatJSTest.verifyFormat(new StringRef(/*KEEP_STR*/"class X {\n  subs = {\n    'b': {\n      'c': 1,\n    },\n  };\n}"));
  FormatJSTest.verifyFormat(new StringRef(/*KEEP_STR*/"@Component({\n  moduleId: module.id,\n})\nclass SessionListComponent implements OnDestroy, OnInit {\n}"));
}

;
@Test
//<editor-fold defaultstate="collapsed" desc="clang::format::FormatTestJS_InterfaceDeclarations_Test::TestBody">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTestJS.cpp", line = 964,
 FQN="clang::format::FormatTestJS_InterfaceDeclarations_Test::TestBody", NM="_ZN5clang6format39FormatTestJS_InterfaceDeclarations_Test8TestBodyEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTestJS.cpp -nm=_ZN5clang6format39FormatTestJS_InterfaceDeclarations_Test8TestBodyEv")
//</editor-fold>
public void test_InterfaceDeclarations() {
  if (markAsSkippedIfNeed(TestState.Successful)) { return; }
  FormatJSTest.verifyFormat(new StringRef(/*KEEP_STR*/"interface I {\n  x: string;\n  enum: string[];\n  enum?: string[];\n}\nvar y;"));
  // Ensure that state is reset after parsing the interface.
  FormatJSTest.verifyFormat(new StringRef(/*KEEP_STR*/"interface a {}\nexport function b() {}\nvar x;"));
  
  // Arrays of object type literals.
  FormatJSTest.verifyFormat(new StringRef(/*KEEP_STR*/"interface I {\n  o: {}[];\n}"));
}

;
@Test
//<editor-fold defaultstate="collapsed" desc="clang::format::FormatTestJS_EnumDeclarations_Test::TestBody">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTestJS.cpp", line = 982,
 FQN="clang::format::FormatTestJS_EnumDeclarations_Test::TestBody", NM="_ZN5clang6format34FormatTestJS_EnumDeclarations_Test8TestBodyEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTestJS.cpp -nm=_ZN5clang6format34FormatTestJS_EnumDeclarations_Test8TestBodyEv")
//</editor-fold>
public void test_EnumDeclarations() {
  if (markAsSkippedIfNeed(TestState.Successful)) { return; }
  FormatJSTest.verifyFormat(new StringRef(/*KEEP_STR*/"enum Foo {\n  A = 1,\n  B\n}"));
  FormatJSTest.verifyFormat(new StringRef(/*KEEP_STR*/"export /* somecomment*/ enum Foo {\n  A = 1,\n  B\n}"));
  FormatJSTest.verifyFormat(new StringRef(/*KEEP_STR*/"enum Foo {\n  A = 1,  // comment\n  B\n}\nvar x = 1;"));
}

;
@Test
//<editor-fold defaultstate="collapsed" desc="clang::format::FormatTestJS_MetadataAnnotations_Test::TestBody">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTestJS.cpp", line = 998,
 FQN="clang::format::FormatTestJS_MetadataAnnotations_Test::TestBody", NM="_ZN5clang6format37FormatTestJS_MetadataAnnotations_Test8TestBodyEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTestJS.cpp -nm=_ZN5clang6format37FormatTestJS_MetadataAnnotations_Test8TestBodyEv")
//</editor-fold>
public void test_MetadataAnnotations() {
  if (markAsSkippedIfNeed(TestState.Successful)) { return; }
  FormatJSTest.verifyFormat(new StringRef(/*KEEP_STR*/"@A\nclass C {\n}"));
  FormatJSTest.verifyFormat(new StringRef(/*KEEP_STR*/"@A({arg: 'value'})\nclass C {\n}"));
  FormatJSTest.verifyFormat(new StringRef(/*KEEP_STR*/"@A\n@B\nclass C {\n}"));
  FormatJSTest.verifyFormat(new StringRef(/*KEEP_STR*/"class C {\n  @A x: string;\n}"));
  FormatJSTest.verifyFormat(new StringRef(/*KEEP_STR*/"class C {\n  @A\n  private x(): string {\n    return 'y';\n  }\n}"));
  FormatJSTest.verifyFormat(new StringRef(/*KEEP_STR*/"class C {\n  private x(@A x: string) {}\n}"));
  FormatJSTest.verifyFormat(new StringRef(/*KEEP_STR*/"class X {}\nclass Y {}"));
}

;
@Test
//<editor-fold defaultstate="collapsed" desc="clang::format::FormatTestJS_TypeAliases_Test::TestBody">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTestJS.cpp", line = 1016,
 FQN="clang::format::FormatTestJS_TypeAliases_Test::TestBody", NM="_ZN5clang6format29FormatTestJS_TypeAliases_Test8TestBodyEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTestJS.cpp -nm=_ZN5clang6format29FormatTestJS_TypeAliases_Test8TestBodyEv")
//</editor-fold>
public void test_TypeAliases() {
  if (markAsSkippedIfNeed(TestState.Successful)) { return; }
  FormatJSTest.verifyFormat(new StringRef(/*KEEP_STR*/"type X = number;\nclass C {}"));
  FormatJSTest.verifyFormat(new StringRef(/*KEEP_STR*/"type X<Y> = Z<Y>;"));
  FormatJSTest.verifyFormat(new StringRef(/*KEEP_STR*/"type X = {\n  y: number\n};\nclass C {}"));
}

;
@Test
//<editor-fold defaultstate="collapsed" desc="clang::format::FormatTestJS_Modules_Test::TestBody">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTestJS.cpp", line = 1026,
 FQN="clang::format::FormatTestJS_Modules_Test::TestBody", NM="_ZN5clang6format25FormatTestJS_Modules_Test8TestBodyEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTestJS.cpp -nm=_ZN5clang6format25FormatTestJS_Modules_Test8TestBodyEv")
//</editor-fold>
public void test_Modules() {
  if (markAsSkippedIfNeed(TestState.Successful)) { return; }
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    FormatJSTest.verifyFormat(new StringRef(/*KEEP_STR*/"import SomeThing from 'some/module.js';"));
    FormatJSTest.verifyFormat(new StringRef(/*KEEP_STR*/"import {X, Y} from 'some/module.js';"));
    FormatJSTest.verifyFormat(new StringRef(/*KEEP_STR*/"import a, {X, Y} from 'some/module.js';"));
    FormatJSTest.verifyFormat(new StringRef(/*KEEP_STR*/"import {X, Y,} from 'some/module.js';"));
    FormatJSTest.verifyFormat(new StringRef(/*KEEP_STR*/"import {X as myLocalX, Y as myLocalY} from 'some/module.js';"));
    // Ensure Automatic Semicolon Insertion does not break on "as\n".
    FormatJSTest.verifyFormat(new StringRef(/*KEEP_STR*/"import {X as myX} from 'm';"), new StringRef(/*KEEP_STR*/"import {X as\n myX} from 'm';"));
    FormatJSTest.verifyFormat(new StringRef(/*KEEP_STR*/"import * as lib from 'some/module.js';"));
    FormatJSTest.verifyFormat(new StringRef(/*KEEP_STR*/"var x = {import: 1};\nx.import = 2;"));
    
    FormatJSTest.verifyFormat(new StringRef(/*KEEP_STR*/"export function fn() {\n  return 'fn';\n}"));
    FormatJSTest.verifyFormat(new StringRef(/*KEEP_STR*/"export function A() {}\nexport default function B() {}\nexport function C() {}"));
    FormatJSTest.verifyFormat(new StringRef(/*KEEP_STR*/"export default () => {\n  let x = 1;\n  return x;\n}"));
    FormatJSTest.verifyFormat(new StringRef(/*KEEP_STR*/"export const x = 12;"));
    FormatJSTest.verifyFormat(new StringRef(/*KEEP_STR*/"export default class X {}"));
    FormatJSTest.verifyFormat(new StringRef(/*KEEP_STR*/"export {X, Y} from 'some/module.js';"));
    FormatJSTest.verifyFormat(new StringRef(/*KEEP_STR*/"export {X, Y,} from 'some/module.js';"));
    FormatJSTest.verifyFormat(new StringRef(/*KEEP_STR*/"export {SomeVeryLongExport as X, SomeOtherVeryLongExport as Y} from 'some/module.js';"));
    // export without 'from' is wrapped.
    FormatJSTest.verifyFormat(new StringRef(/*KEEP_STR*/"export let someRatherLongVariableName =\n    someSurprisinglyLongVariable + someOtherRatherLongVar;"));
    // ... but not if from is just an identifier.
    FormatJSTest.verifyFormat(new StringRef(/*KEEP_STR*/"export {\n  from as from,\n  someSurprisinglyLongVariable as\n      from\n};"), 
        $c$.track(FormatJSTest.getGoogleJSStyleWithColumns(20))); $c$.clean();
    FormatJSTest.verifyFormat(new StringRef(/*KEEP_STR*/"export class C {\n  x: number;\n  y: string;\n}"));
    FormatJSTest.verifyFormat(new StringRef(/*KEEP_STR*/"export class X { y: number; }"));
    FormatJSTest.verifyFormat(new StringRef(/*KEEP_STR*/"export abstract class X { y: number; }"));
    FormatJSTest.verifyFormat(new StringRef(/*KEEP_STR*/"export default class X { y: number }"));
    FormatJSTest.verifyFormat(new StringRef(/*KEEP_STR*/"export default function() {\n  return 1;\n}"));
    FormatJSTest.verifyFormat(new StringRef(/*KEEP_STR*/"export var x = 12;"));
    FormatJSTest.verifyFormat(new StringRef(/*KEEP_STR*/"class C {}\nexport function f() {}\nvar v;"));
    FormatJSTest.verifyFormat(new StringRef(/*KEEP_STR*/"export var x: number = 12;"));
    FormatJSTest.verifyFormat(new StringRef(/*KEEP_STR*/"export const y = {\n  a: 1,\n  b: 2\n};"));
    FormatJSTest.verifyFormat(new StringRef(/*KEEP_STR*/"export enum Foo {\n  BAR,\n  // adsdasd\n  BAZ\n}"));
    FormatJSTest.verifyFormat(new StringRef(/*KEEP_STR*/"export default [\n  aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa,\n  bbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbb\n];"));
    FormatJSTest.verifyFormat(new StringRef(/*KEEP_STR*/"export default [];"));
    FormatJSTest.verifyFormat(new StringRef(/*KEEP_STR*/"export default () => {};"));
    FormatJSTest.verifyFormat(new StringRef(/*KEEP_STR*/"export interface Foo { foo: number; }\nexport class Bar {\n  blah(): string { return this.blah; };\n}"));
  } finally {
    $c$.$destroy();
  }
}

;
@Test
//<editor-fold defaultstate="collapsed" desc="clang::format::FormatTestJS_ImportWrapping_Test::TestBody">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTestJS.cpp", line = 1098,
 FQN="clang::format::FormatTestJS_ImportWrapping_Test::TestBody", NM="_ZN5clang6format32FormatTestJS_ImportWrapping_Test8TestBodyEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTestJS.cpp -nm=_ZN5clang6format32FormatTestJS_ImportWrapping_Test8TestBodyEv")
//</editor-fold>
public void test_ImportWrapping() {
  if (markAsSkippedIfNeed(TestState.Successful)) { return; }
  FormatStyle Style = null;
  try {
    FormatJSTest.verifyFormat(new StringRef(/*KEEP_STR*/"import {VeryLongImportsAreAnnoying, VeryLongImportsAreAnnoying, VeryLongImportsAreAnnoying, VeryLongImportsAreAnnoying} from 'some/module.js';"));
    Style = FormatJSTest.getGoogleJSStyleWithColumns(80);
    Style.JavaScriptWrapImports = true;
    FormatJSTest.verifyFormat(new StringRef(/*KEEP_STR*/"import {\n  VeryLongImportsAreAnnoying,\n  VeryLongImportsAreAnnoying,\n  VeryLongImportsAreAnnoying,\n} from 'some/module.js';"), 
        Style);
    FormatJSTest.verifyFormat(new StringRef(/*KEEP_STR*/"import {\n  A,\n  A,\n} from 'some/module.js';"), 
        Style);
    FormatJSTest.verifyFormat(new StringRef(/*KEEP_STR*/"export {\n  A,\n  A,\n} from 'some/module.js';"), 
        Style);
  } finally {
    if (Style != null) { Style.$destroy(); }
  }
}

;
@Test
//<editor-fold defaultstate="collapsed" desc="clang::format::FormatTestJS_TemplateStrings_Test::TestBody">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTestJS.cpp", line = 1122,
 FQN="clang::format::FormatTestJS_TemplateStrings_Test::TestBody", NM="_ZN5clang6format33FormatTestJS_TemplateStrings_Test8TestBodyEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTestJS.cpp -nm=_ZN5clang6format33FormatTestJS_TemplateStrings_Test8TestBodyEv")
//</editor-fold>
public void test_TemplateStrings() {
  if (markAsSkippedIfNeed(TestState.Successful)) { return; }
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    // Keeps any whitespace/indentation within the template string.
    FormatJSTest.verifyFormat(new StringRef(/*KEEP_STR*/"var x = `hello\n     ${  name    }\n  !`;"), 
        new StringRef(/*KEEP_STR*/"var x    =    `hello\n     ${  name    }\n  !`;"));
    
    FormatJSTest.verifyFormat(new StringRef(/*KEEP_STR*/"var x =\n    `hello ${world}` >= some();"), 
        $c$.track(FormatJSTest.getGoogleJSStyleWithColumns(34))); $c$.clean(); // Barely doesn't fit.
    FormatJSTest.verifyFormat(new StringRef(/*KEEP_STR*/"var x = `hello ${world}` >= some();"), 
        $c$.track(FormatJSTest.getGoogleJSStyleWithColumns(35))); $c$.clean(); // Barely fits.
    FormatJSTest.verifyFormat(new StringRef(/*KEEP_STR*/"var x = `hell\303\266 ${w\303\266rld}` >= s\303\266me();"), 
        $c$.track(FormatJSTest.getGoogleJSStyleWithColumns(35))); $c$.clean(); // Fits due to UTF-8.
    FormatJSTest.verifyFormat(new StringRef(/*KEEP_STR*/"var x = `hello\n  ${world}` >=\n    some();"), 
        new StringRef(/*KEEP_STR*/"var x =\n    `hello\n  ${world}` >= some();"), 
        $c$.track(FormatJSTest.getGoogleJSStyleWithColumns(21))); $c$.clean(); // Barely doesn't fit.
    FormatJSTest.verifyFormat(new StringRef(/*KEEP_STR*/"var x = `hello\n  ${world}` >= some();"), 
        new StringRef(/*KEEP_STR*/"var x =\n    `hello\n  ${world}` >= some();"), 
        $c$.track(FormatJSTest.getGoogleJSStyleWithColumns(22))); $c$.clean(); // Barely fits.
    
    FormatJSTest.verifyFormat(new StringRef(/*KEEP_STR*/"var x =\n    `h`;"), 
        $c$.track(FormatJSTest.getGoogleJSStyleWithColumns(11))); $c$.clean();
    FormatJSTest.verifyFormat(new StringRef(/*KEEP_STR*/"var x =\n    `multi\n  line`;"), new StringRef(/*KEEP_STR*/"var x = `multi\n  line`;"), 
        $c$.track(FormatJSTest.getGoogleJSStyleWithColumns(13))); $c$.clean();
    FormatJSTest.verifyFormat(new StringRef(/*KEEP_STR*/"aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa(\n    `aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa`);"));
    // Repro for an obscure width-miscounting issue with template strings.
    FormatJSTest.verifyFormat(new StringRef(/*KEEP_STR*/"someLongVariable =\n    `${logPrefix[11]}/${logPrefix[12]}/${logPrefix[13]}${logPrefix[14]}`;"), 
        new StringRef(/*KEEP_STR*/"someLongVariable = `${logPrefix[11]}/${logPrefix[12]}/${logPrefix[13]}${logPrefix[14]}`;"));
    
    // Make sure template strings get a proper ColumnWidth assigned, even if they
    // are first token in line.
    FormatJSTest.verifyFormat(new StringRef(/*KEEP_STR*/"var a = aaaaaaaaaaaaaaaaaaaaaaaaaaaa ||\n    `aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa`;"));
    
    // Two template strings.
    FormatJSTest.verifyFormat(new StringRef(/*KEEP_STR*/"var x = `hello` == `hello`;"));
    
    // Comments in template strings.
    FormatJSTest.verifyFormat(new StringRef(/*KEEP_STR*/"var x = `//a`;\nvar y;"), 
        new StringRef(/*KEEP_STR*/"var x =\n `//a`;\nvar y  ;"));
    FormatJSTest.verifyFormat(new StringRef(/*KEEP_STR*/"var x = `/*a`;\nvar y;"), 
        new StringRef(/*KEEP_STR*/"var x =\n `/*a`;\nvar y;"));
    // Unterminated string literals in a template string.
    FormatJSTest.verifyFormat(new StringRef(/*KEEP_STR*/"var x = `'`;  // comment with matching quote '\nvar y;"));
    FormatJSTest.verifyFormat(new StringRef(/*KEEP_STR*/"var x = `\"`;  // comment with matching quote \"\nvar y;"));
    FormatJSTest.verifyFormat(new StringRef(/*KEEP_STR*/"it(`'aaaaaaaaaaaaaaa   `, aaaaaaaaa);"), 
        new StringRef(/*KEEP_STR*/"it(`'aaaaaaaaaaaaaaa   `,   aaaaaaaaa) ;"), 
        $c$.track(FormatJSTest.getGoogleJSStyleWithColumns(40))); $c$.clean();
    // Backticks in a comment - not a template string.
    FormatJSTest.verifyFormat(new StringRef(/*KEEP_STR*/"var x = 1  // `/*a`;\n    ;"), 
        new StringRef(/*KEEP_STR*/"var x =\n 1  // `/*a`;\n    ;"));
    FormatJSTest.verifyFormat(new StringRef(/*KEEP_STR*/"/* ` */ var x = 1; /* ` */"), new StringRef(/*KEEP_STR*/"/* ` */ var x\n= 1; /* ` */"));
    // Comment spans multiple template strings.
    FormatJSTest.verifyFormat(new StringRef(/*KEEP_STR*/"var x = `/*a`;\nvar y = ` */ `;"), 
        new StringRef(/*KEEP_STR*/"var x =\n `/*a`;\nvar y =\n ` */ `;"));
    // Escaped backtick.
    FormatJSTest.verifyFormat(new StringRef(/*KEEP_STR*/"var x = ` \\` a`;\nvar y;"), 
        new StringRef(/*KEEP_STR*/"var x = ` \\` a`;\nvar y;"));
  } finally {
    $c$.$destroy();
  }
}

;
@Test
//<editor-fold defaultstate="collapsed" desc="clang::format::FormatTestJS_CastSyntax_Test::TestBody">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTestJS.cpp", line = 1211,
 FQN="clang::format::FormatTestJS_CastSyntax_Test::TestBody", NM="_ZN5clang6format28FormatTestJS_CastSyntax_Test8TestBodyEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTestJS.cpp -nm=_ZN5clang6format28FormatTestJS_CastSyntax_Test8TestBodyEv")
//</editor-fold>
public void test_CastSyntax() {
  if (markAsSkippedIfNeed(TestState.Successful)) { return; }
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    FormatJSTest.verifyFormat(new StringRef(/*KEEP_STR*/"var x = <type>foo;"));
    FormatJSTest.verifyFormat(new StringRef(/*KEEP_STR*/"var x = foo as type;"));
    FormatJSTest.verifyFormat(new StringRef(/*KEEP_STR*/"let x = (a + b) as\n    LongTypeIsLong;"), 
        $c$.track(FormatJSTest.getGoogleJSStyleWithColumns(20))); $c$.clean();
    FormatJSTest.verifyFormat(new StringRef(/*KEEP_STR*/"foo = <Bar[]>[\n  1,  //\n  2\n];"));
  } finally {
    $c$.$destroy();
  }
}

;
@Test
//<editor-fold defaultstate="collapsed" desc="clang::format::FormatTestJS_TypeArguments_Test::TestBody">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTestJS.cpp", line = 1223,
 FQN="clang::format::FormatTestJS_TypeArguments_Test::TestBody", NM="_ZN5clang6format31FormatTestJS_TypeArguments_Test8TestBodyEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTestJS.cpp -nm=_ZN5clang6format31FormatTestJS_TypeArguments_Test8TestBodyEv")
//</editor-fold>
public void test_TypeArguments() {
  if (markAsSkippedIfNeed(TestState.Successful)) { return; }
  FormatJSTest.verifyFormat(new StringRef(/*KEEP_STR*/"class X<Y> {}"));
  FormatJSTest.verifyFormat(new StringRef(/*KEEP_STR*/"new X<Y>();"));
  FormatJSTest.verifyFormat(new StringRef(/*KEEP_STR*/"foo<Y>(a);"));
  FormatJSTest.verifyFormat(new StringRef(/*KEEP_STR*/"var x: X<Y>[];"));
  FormatJSTest.verifyFormat(new StringRef(/*KEEP_STR*/"class C extends D<E> implements F<G>, H<I> {}"));
  FormatJSTest.verifyFormat(new StringRef(/*KEEP_STR*/"function f(a: List<any> = null) {}"));
  FormatJSTest.verifyFormat(new StringRef(/*KEEP_STR*/"function f(): List<any> {}"));
  FormatJSTest.verifyFormat(new StringRef(/*KEEP_STR*/"function aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa():\n    bbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbb {}"));
  FormatJSTest.verifyFormat(new StringRef(/*KEEP_STR*/"function aaaaaaaaaa(\n    aaaaaaaaaaaaaaaa: aaaaaaaaaaaaaaaaaaa,\n    aaaaaaaaaaaaaaaa: aaaaaaaaaaaaaaaaaaa):\n    aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa {}"));
}

;
@Test
//<editor-fold defaultstate="collapsed" desc="clang::format::FormatTestJS_UserDefinedTypeGuards_Test::TestBody">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTestJS.cpp", line = 1239,
 FQN="clang::format::FormatTestJS_UserDefinedTypeGuards_Test::TestBody", NM="_ZN5clang6format39FormatTestJS_UserDefinedTypeGuards_Test8TestBodyEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTestJS.cpp -nm=_ZN5clang6format39FormatTestJS_UserDefinedTypeGuards_Test8TestBodyEv")
//</editor-fold>
public void test_UserDefinedTypeGuards() {
  if (markAsSkippedIfNeed(TestState.Successful)) { return; }
  FormatJSTest.verifyFormat(new StringRef(/*KEEP_STR*/"function foo(check: Object):\n    check is {foo: string, bar: string, baz: string, foobar: string} {\n  return 'bar' in check;\n}\n"));
}

;
@Test
//<editor-fold defaultstate="collapsed" desc="clang::format::FormatTestJS_OptionalTypes_Test::TestBody">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTestJS.cpp", line = 1247,
 FQN="clang::format::FormatTestJS_OptionalTypes_Test::TestBody", NM="_ZN5clang6format31FormatTestJS_OptionalTypes_Test8TestBodyEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTestJS.cpp -nm=_ZN5clang6format31FormatTestJS_OptionalTypes_Test8TestBodyEv")
//</editor-fold>
public void test_OptionalTypes() {
  if (markAsSkippedIfNeed(TestState.Successful)) { return; }
  FormatJSTest.verifyFormat(new StringRef(/*KEEP_STR*/"function x(a?: b, c?, d?) {}"));
  FormatJSTest.verifyFormat(new StringRef(/*KEEP_STR*/"class X {\n  y?: z;\n  z?;\n}"));
  FormatJSTest.verifyFormat(new StringRef(/*KEEP_STR*/"interface X {\n  y?(): z;\n}"));
  FormatJSTest.verifyFormat(new StringRef(/*KEEP_STR*/"constructor({aa}: {\n  aa?: string,\n  aaaaaaaa?: string,\n  aaaaaaaaaaaaaaa?: boolean,\n  aaaaaa?: List<string>\n}) {}"));
}

;
@Test
//<editor-fold defaultstate="collapsed" desc="clang::format::FormatTestJS_IndexSignature_Test::TestBody">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTestJS.cpp", line = 1264,
 FQN="clang::format::FormatTestJS_IndexSignature_Test::TestBody", NM="_ZN5clang6format32FormatTestJS_IndexSignature_Test8TestBodyEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTestJS.cpp -nm=_ZN5clang6format32FormatTestJS_IndexSignature_Test8TestBodyEv")
//</editor-fold>
public void test_IndexSignature() {
  if (markAsSkippedIfNeed(TestState.Successful)) { return; }
  FormatJSTest.verifyFormat(new StringRef(/*KEEP_STR*/"var x: {[k: string]: v};"));
}

;
@Test
//<editor-fold defaultstate="collapsed" desc="clang::format::FormatTestJS_WrapAfterParen_Test::TestBody">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTestJS.cpp", line = 1268,
 FQN="clang::format::FormatTestJS_WrapAfterParen_Test::TestBody", NM="_ZN5clang6format32FormatTestJS_WrapAfterParen_Test8TestBodyEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTestJS.cpp -nm=_ZN5clang6format32FormatTestJS_WrapAfterParen_Test8TestBodyEv")
//</editor-fold>
public void test_WrapAfterParen() {
  if (markAsSkippedIfNeed(TestState.Successful)) { return; }
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    FormatJSTest.verifyFormat(new StringRef(/*KEEP_STR*/"xxxxxxxxxxx(\n    aaa, aaa);"), 
        $c$.track(FormatJSTest.getGoogleJSStyleWithColumns(20))); $c$.clean();
    FormatJSTest.verifyFormat(new StringRef(/*KEEP_STR*/"xxxxxxxxxxx(\n    aaa, aaa, aaa,\n    aaa, aaa, aaa);"), 
        $c$.track(FormatJSTest.getGoogleJSStyleWithColumns(20))); $c$.clean();
    FormatJSTest.verifyFormat(new StringRef(/*KEEP_STR*/"xxxxxxxxxxx(\n    aaaaaaaaaaaaaaaaaaaaaaaa,\n    function(x) {\n      y();  //\n    });"), 
        $c$.track(FormatJSTest.getGoogleJSStyleWithColumns(40))); $c$.clean();
    FormatJSTest.verifyFormat(new StringRef(/*KEEP_STR*/"while (aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa &&\n       bbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbb) {\n}"));
  } finally {
    $c$.$destroy();
  }
}

;
@Test
//<editor-fold defaultstate="collapsed" desc="clang::format::FormatTestJS_JSDocAnnotations_Test::TestBody">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTestJS.cpp", line = 1286,
 FQN="clang::format::FormatTestJS_JSDocAnnotations_Test::TestBody", NM="_ZN5clang6format34FormatTestJS_JSDocAnnotations_Test8TestBodyEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTestJS.cpp -nm=_ZN5clang6format34FormatTestJS_JSDocAnnotations_Test8TestBodyEv")
//</editor-fold>
public void test_JSDocAnnotations() {
  if (markAsSkippedIfNeed(TestState.Successful)) { return; }
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    FormatJSTest.verifyFormat(new StringRef(/*KEEP_STR*/"/**\n * @export {this.is.a.long.path.to.a.Type}\n */"), 
        new StringRef(/*KEEP_STR*/"/**\n * @export {this.is.a.long.path.to.a.Type}\n */"), 
        $c$.track(FormatJSTest.getGoogleJSStyleWithColumns(20))); $c$.clean();
  } finally {
    $c$.$destroy();
  }
}

;
@Test
//<editor-fold defaultstate="collapsed" desc="clang::format::FormatTestJS_RequoteStringsSingle_Test::TestBody">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTestJS.cpp", line = 1296,
 FQN="clang::format::FormatTestJS_RequoteStringsSingle_Test::TestBody", NM="_ZN5clang6format38FormatTestJS_RequoteStringsSingle_Test8TestBodyEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTestJS.cpp -nm=_ZN5clang6format38FormatTestJS_RequoteStringsSingle_Test8TestBodyEv")
//</editor-fold>
public void test_RequoteStringsSingle() {
  if (markAsSkippedIfNeed(TestState.Successful)) { return; }
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    FormatJSTest.verifyFormat(new StringRef(/*KEEP_STR*/"var x = 'foo';"), new StringRef(/*KEEP_STR*/"var x = \"foo\";"));
    FormatJSTest.verifyFormat(new StringRef(/*KEEP_STR*/"var x = 'fo\\'o\\'';"), new StringRef(/*KEEP_STR*/"var x = \"fo'o'\";"));
    FormatJSTest.verifyFormat(new StringRef(/*KEEP_STR*/"var x = 'fo\\'o\\'';"), new StringRef(/*KEEP_STR*/"var x = \"fo\\'o'\";"));
    FormatJSTest.verifyFormat(new StringRef(/*KEEP_STR*/"var x =\n    'foo\\'';"), 
        // Code below is 15 chars wide, doesn't fit into the line with the
        // \ escape added.
        new StringRef(/*KEEP_STR*/"var x = \"foo'\";"), $c$.track(FormatJSTest.getGoogleJSStyleWithColumns(15))); $c$.clean();
    // Removes no-longer needed \ escape from ".
    FormatJSTest.verifyFormat(new StringRef(/*KEEP_STR*/"var x = 'fo\"o';"), new StringRef(/*KEEP_STR*/"var x = \"fo\\\"o\";"));
    // Code below fits into 15 chars *after* removing the \ escape.
    FormatJSTest.verifyFormat(new StringRef(/*KEEP_STR*/"var x = 'fo\"o';"), new StringRef(/*KEEP_STR*/"var x = \"fo\\\"o\";"), 
        $c$.track(FormatJSTest.getGoogleJSStyleWithColumns(15))); $c$.clean();
    FormatJSTest.verifyFormat(new StringRef(/*KEEP_STR*/"// clang-format off\nlet x = \"double\";\n// clang-format on\nlet x = 'single';\n"), 
        new StringRef(/*KEEP_STR*/"// clang-format off\nlet x = \"double\";\n// clang-format on\nlet x = \"single\";\n"));
  } finally {
    $c$.$destroy();
  }
}

;
@Test
//<editor-fold defaultstate="collapsed" desc="clang::format::FormatTestJS_RequoteStringsDouble_Test::TestBody">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTestJS.cpp", line = 1321,
 FQN="clang::format::FormatTestJS_RequoteStringsDouble_Test::TestBody", NM="_ZN5clang6format38FormatTestJS_RequoteStringsDouble_Test8TestBodyEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTestJS.cpp -nm=_ZN5clang6format38FormatTestJS_RequoteStringsDouble_Test8TestBodyEv")
//</editor-fold>
public void test_RequoteStringsDouble() {
  if (markAsSkippedIfNeed(TestState.Successful)) { return; }
  FormatStyle DoubleQuotes = null;
  try {
    DoubleQuotes = getGoogleStyle(FormatStyle.LanguageKind.LK_JavaScript);
    DoubleQuotes.JavaScriptQuotes = FormatStyle.JavaScriptQuoteStyle.JSQS_Double;
    FormatJSTest.verifyFormat(new StringRef(/*KEEP_STR*/"var x = \"foo\";"), DoubleQuotes);
    FormatJSTest.verifyFormat(new StringRef(/*KEEP_STR*/"var x = \"foo\";"), new StringRef(/*KEEP_STR*/"var x = 'foo';"), DoubleQuotes);
    FormatJSTest.verifyFormat(new StringRef(/*KEEP_STR*/"var x = \"fo'o\";"), new StringRef(/*KEEP_STR*/"var x = 'fo\\'o';"), DoubleQuotes);
  } finally {
    if (DoubleQuotes != null) { DoubleQuotes.$destroy(); }
  }
}

;
@Test
//<editor-fold defaultstate="collapsed" desc="clang::format::FormatTestJS_RequoteStringsLeave_Test::TestBody">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTestJS.cpp", line = 1329,
 FQN="clang::format::FormatTestJS_RequoteStringsLeave_Test::TestBody", NM="_ZN5clang6format37FormatTestJS_RequoteStringsLeave_Test8TestBodyEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTestJS.cpp -nm=_ZN5clang6format37FormatTestJS_RequoteStringsLeave_Test8TestBodyEv")
//</editor-fold>
public void test_RequoteStringsLeave() {
  if (markAsSkippedIfNeed(TestState.Successful)) { return; }
  FormatStyle LeaveQuotes = null;
  try {
    LeaveQuotes = getGoogleStyle(FormatStyle.LanguageKind.LK_JavaScript);
    LeaveQuotes.JavaScriptQuotes = FormatStyle.JavaScriptQuoteStyle.JSQS_Leave;
    FormatJSTest.verifyFormat(new StringRef(/*KEEP_STR*/"var x = \"foo\";"), LeaveQuotes);
    FormatJSTest.verifyFormat(new StringRef(/*KEEP_STR*/"var x = 'foo';"), LeaveQuotes);
  } finally {
    if (LeaveQuotes != null) { LeaveQuotes.$destroy(); }
  }
}

;
@Test
//<editor-fold defaultstate="collapsed" desc="clang::format::FormatTestJS_SupportShebangLines_Test::TestBody">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTestJS.cpp", line = 1336,
 FQN="clang::format::FormatTestJS_SupportShebangLines_Test::TestBody", NM="_ZN5clang6format37FormatTestJS_SupportShebangLines_Test8TestBodyEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTestJS.cpp -nm=_ZN5clang6format37FormatTestJS_SupportShebangLines_Test8TestBodyEv")
//</editor-fold>
public void test_SupportShebangLines() {
  if (markAsSkippedIfNeed(TestState.Successful)) { return; }
  FormatJSTest.verifyFormat(new StringRef(/*KEEP_STR*/"#!/usr/bin/env node\nvar x = hello();"), 
      new StringRef(/*KEEP_STR*/"#!/usr/bin/env node\nvar x   =  hello();"));
}

;
@Test
//<editor-fold defaultstate="collapsed" desc="clang::format::FormatTestJS_NonNullAssertionOperator_Test::TestBody">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTestJS.cpp", line = 1343,
 FQN="clang::format::FormatTestJS_NonNullAssertionOperator_Test::TestBody", NM="_ZN5clang6format42FormatTestJS_NonNullAssertionOperator_Test8TestBodyEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTestJS.cpp -nm=_ZN5clang6format42FormatTestJS_NonNullAssertionOperator_Test8TestBodyEv")
//</editor-fold>
public void test_NonNullAssertionOperator() {
  if (markAsSkippedIfNeed(TestState.Successful)) { return; }
  FormatJSTest.verifyFormat(new StringRef(/*KEEP_STR*/"let x = foo!.bar();\n"));
  FormatJSTest.verifyFormat(new StringRef(/*KEEP_STR*/"let x = foo ? bar! : baz;\n"));
  FormatJSTest.verifyFormat(new StringRef(/*KEEP_STR*/"let x = !foo;\n"));
  FormatJSTest.verifyFormat(new StringRef(/*KEEP_STR*/"let x = foo[0]!;\n"));
  FormatJSTest.verifyFormat(new StringRef(/*KEEP_STR*/"let x = (foo)!;\n"));
  FormatJSTest.verifyFormat(new StringRef(/*KEEP_STR*/"let x = {foo: 1}!;\n"));
}

;
@Test
//<editor-fold defaultstate="collapsed" desc="clang::format::FormatTestJS_Conditional_Test::TestBody">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTestJS.cpp", line = 1352,
 FQN="clang::format::FormatTestJS_Conditional_Test::TestBody", NM="_ZN5clang6format29FormatTestJS_Conditional_Test8TestBodyEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTestJS.cpp -nm=_ZN5clang6format29FormatTestJS_Conditional_Test8TestBodyEv")
//</editor-fold>
public void test_Conditional() {
  if (markAsSkippedIfNeed(TestState.Successful)) { return; }
  FormatJSTest.verifyFormat(new StringRef(/*KEEP_STR*/"y = x ? 1 : 2;"));
  FormatJSTest.verifyFormat(new StringRef(/*KEEP_STR*/"x ? 1 : 2;"));
  FormatJSTest.verifyFormat(new StringRef(/*KEEP_STR*/"class Foo {\n  field = true ? 1 : 2;\n  method(a = true ? 1 : 2) {}\n}"));
}

//} JAVA: end of namespace format // end namespace tooling
//} JAVA: end of namespace clang
//<editor-fold defaultstate="collapsed" desc="__builtin_trap">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTestJS.cpp", line = 53,
 FQN="__builtin_trap", NM="_Z14__builtin_trap",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTestJS.cpp -nm=_Z14__builtin_trap")
//</editor-fold>
public static void __builtin_trap()/* __attribute__((nothrow))*/ {
  throw new UnsupportedOperationException("<<<DeclJavaPrinter::VisitFunctionDecl NULL BODY IN USED Translation Unit>>>");
}

} // END OF class FormatTestJS
