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
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.tooling.core.*;
import org.clang.format.*;
import static org.clang.format.FormatGlobals.*;
import static org.clang.tooling.ToolingGlobals.*;


//<editor-fold defaultstate="collapsed" desc="static type FormatTestSelective">
@Converted(kind = Converted.Kind.AUTO,
 NM="FormatTestSelective",
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -print -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTestSelective.cpp -test=FormatTestSelective")
//</editor-fold>
public final class FormatSelectiveTest extends ADTSupportTestBase {

//JAVA: namespace clang {
//JAVA: namespace format {
//JAVA: namespace (anonymous) {

////<editor-fold defaultstate="collapsed" desc="clang::format::(anonymous namespace)::FormatTestSelective">
//@Converted(kind = Converted.Kind.AUTO,
// source = "${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTestSelective.cpp", line = 21,
// FQN="clang::format::(anonymous namespace)::FormatTestSelective", NM="_ZN5clang6format12_GLOBAL__N_119FormatTestSelectiveE",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTestSelective.cpp -nm=_ZN5clang6format12_GLOBAL__N_119FormatTestSelectiveE")
////</editor-fold>
//public abstract static class FormatTestSelective extends /*public*/ Test implements Destructors.ClassWithDestructor {
/*protected:*/
  //<editor-fold defaultstate="collapsed" desc="clang::format::(anonymous namespace)::FormatTestSelective::format">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTestSelective.cpp", line = 23,
   FQN="clang::format::(anonymous namespace)::FormatTestSelective::format", NM="_ZN5clang6format12_GLOBAL__N_119FormatTestSelective6formatEN4llvm9StringRefEjj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTestSelective.cpp -nm=_ZN5clang6format12_GLOBAL__N_119FormatTestSelective6formatEN4llvm9StringRefEjj")
  //</editor-fold>
  protected std.string format(StringRef Code, /*uint*/int Offset, /*uint*/int Length) {
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

  
  protected FormatStyle Style/* = getLLVMStyle()*/;
  //<editor-fold defaultstate="collapsed" desc="clang::format::(anonymous namespace)::FormatTestSelective::~FormatTestSelective">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTestSelective.cpp", line = 21,
   FQN="clang::format::(anonymous namespace)::FormatTestSelective::~FormatTestSelective", NM="_ZN5clang6format12_GLOBAL__N_119FormatTestSelectiveD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTestSelective.cpp -nm=_ZN5clang6format12_GLOBAL__N_119FormatTestSelectiveD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    //START JDestroy
    Style.$destroy();
    super.$destroy();
    //END JDestroy
  }

  //<editor-fold defaultstate="collapsed" desc="clang::format::(anonymous namespace)::FormatTestSelective::FormatTestSelective">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTestSelective.cpp", line = 21,
   FQN="clang::format::(anonymous namespace)::FormatTestSelective::FormatTestSelective", NM="_ZN5clang6format12_GLOBAL__N_119FormatTestSelectiveC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTestSelective.cpp -nm=_ZN5clang6format12_GLOBAL__N_119FormatTestSelectiveC1Ev")
  //</editor-fold>
  public /*inline*/ FormatSelectiveTest() {
    // : Test(), Style($c$.track(getLLVMStyle())) 
    //START JInit
    super(TestState.Successful);
    /*InClass*/this.Style = getLLVMStyle();
    //END JInit
  }

  
  @Override public String toString() {
    return "" + "Style=" + Style // NOI18N
              + super.toString(); // NOI18N
  }
//}
;
@Test
//<editor-fold defaultstate="collapsed" desc="clang::format::(anonymous namespace)::FormatTestSelective_RemovesTrailingWhitespaceOfFormattedLine_Test::TestBody">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTestSelective.cpp", line = 40,
 FQN="clang::format::(anonymous namespace)::FormatTestSelective_RemovesTrailingWhitespaceOfFormattedLine_Test::TestBody", NM="_ZN5clang6format12_GLOBAL__N_165FormatTestSelective_RemovesTrailingWhitespaceOfFormattedLine_Test8TestBodyEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTestSelective.cpp -nm=_ZN5clang6format12_GLOBAL__N_165FormatTestSelective_RemovesTrailingWhitespaceOfFormattedLine_Test8TestBodyEv")
//</editor-fold>
public void test_RemovesTrailingWhitespaceOfFormattedLine() {
    if (markAsSkippedIfNeed(TestState.Successful)) { return; }
    EXPECT_EQ("int a;\nint b;",format(new StringRef(/*KEEP_STR*/"int a; \nint b;"), 0, 0));
    EXPECT_EQ("int a;",format(new StringRef(/*KEEP_STR*/"int a;         "), 0, 0));
    EXPECT_EQ("int a;\n",format(new StringRef(/*KEEP_STR*/"int a;  \n   \n   \n "), 0, 0));
    EXPECT_EQ("int a;\nint b;    ",format(new StringRef(/*KEEP_STR*/"int a;  \nint b;    "), 0, 0));
}

;
@Test
//<editor-fold defaultstate="collapsed" desc="clang::format::(anonymous namespace)::FormatTestSelective_FormatsCorrectRegionForLeadingWhitespace_Test::TestBody">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTestSelective.cpp", line = 47,
 FQN="clang::format::(anonymous namespace)::FormatTestSelective_FormatsCorrectRegionForLeadingWhitespace_Test::TestBody", NM="_ZN5clang6format12_GLOBAL__N_165FormatTestSelective_FormatsCorrectRegionForLeadingWhitespace_Test8TestBodyEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTestSelective.cpp -nm=_ZN5clang6format12_GLOBAL__N_165FormatTestSelective_FormatsCorrectRegionForLeadingWhitespace_Test8TestBodyEv")
//</editor-fold>
public void test_FormatsCorrectRegionForLeadingWhitespace() {
    if (markAsSkippedIfNeed(TestState.Successful)) { return; }
    EXPECT_EQ("{int b;\n  int a;\n}",format(new StringRef(/*KEEP_STR*/"{int b;\n  int  a;}"), 8, 0));
    EXPECT_EQ("{\n  int b;\n  int  a;}",format(new StringRef(/*KEEP_STR*/"{int b;\n  int  a;}"), 7, 0));
  
  Style.ColumnLimit = 12;
    EXPECT_EQ("#define A  \\\n  int a;   \\\n  int b;",format(new StringRef(/*KEEP_STR*/"#define A  \\\n  int a;   \\\n    int b;"), 26, 0));
    EXPECT_EQ("#define A  \\\n  int a;   \\\n  int b;",format(new StringRef(/*KEEP_STR*/"#define A  \\\n  int a;   \\\n  int b;"), 25, 0));
}

;
@Test
//<editor-fold defaultstate="collapsed" desc="clang::format::(anonymous namespace)::FormatTestSelective_FormatLineWhenInvokedOnTrailingNewline_Test::TestBody">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTestSelective.cpp", line = 74,
 FQN="clang::format::(anonymous namespace)::FormatTestSelective_FormatLineWhenInvokedOnTrailingNewline_Test::TestBody", NM="_ZN5clang6format12_GLOBAL__N_163FormatTestSelective_FormatLineWhenInvokedOnTrailingNewline_Test8TestBodyEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTestSelective.cpp -nm=_ZN5clang6format12_GLOBAL__N_163FormatTestSelective_FormatLineWhenInvokedOnTrailingNewline_Test8TestBodyEv")
//</editor-fold>
public void test_FormatLineWhenInvokedOnTrailingNewline() {
    if (markAsSkippedIfNeed(TestState.Successful)) { return; }
    EXPECT_EQ("int  b;\n\nint a;",format(new StringRef(/*KEEP_STR*/"int  b;\n\nint a;"), 8, 0));
    EXPECT_EQ("int b;\n\nint a;",format(new StringRef(/*KEEP_STR*/"int  b;\n\nint a;"), 7, 0));
    
    // This might not strictly be correct, but is likely good in all practical
    // cases.
    EXPECT_EQ("int b;\nint a;",format(new StringRef(/*KEEP_STR*/"int  b;int a;"), 7, 0));
}

;
@Test
//<editor-fold defaultstate="collapsed" desc="clang::format::(anonymous namespace)::FormatTestSelective_RemovesWhitespaceWhenTriggeredOnEmptyLine_Test::TestBody">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTestSelective.cpp", line = 83,
 FQN="clang::format::(anonymous namespace)::FormatTestSelective_RemovesWhitespaceWhenTriggeredOnEmptyLine_Test::TestBody", NM="_ZN5clang6format12_GLOBAL__N_166FormatTestSelective_RemovesWhitespaceWhenTriggeredOnEmptyLine_Test8TestBodyEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTestSelective.cpp -nm=_ZN5clang6format12_GLOBAL__N_166FormatTestSelective_RemovesWhitespaceWhenTriggeredOnEmptyLine_Test8TestBodyEv")
//</editor-fold>
public void test_RemovesWhitespaceWhenTriggeredOnEmptyLine() {
    if (markAsSkippedIfNeed(TestState.Successful)) { return; }
    EXPECT_EQ("int  a;\n\n int b;",format(new StringRef(/*KEEP_STR*/"int  a;\n  \n\n int b;"), 8, 0));
    EXPECT_EQ("int  a;\n\n int b;",format(new StringRef(/*KEEP_STR*/"int  a;\n  \n\n int b;"), 9, 0));
}

;
@Test
//<editor-fold defaultstate="collapsed" desc="clang::format::(anonymous namespace)::FormatTestSelective_ReformatsMovedLines_Test::TestBody">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTestSelective.cpp", line = 88,
 FQN="clang::format::(anonymous namespace)::FormatTestSelective_ReformatsMovedLines_Test::TestBody", NM="_ZN5clang6format12_GLOBAL__N_144FormatTestSelective_ReformatsMovedLines_Test8TestBodyEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTestSelective.cpp -nm=_ZN5clang6format12_GLOBAL__N_144FormatTestSelective_ReformatsMovedLines_Test8TestBodyEv")
//</editor-fold>
public void test_ReformatsMovedLines() {
    if (markAsSkippedIfNeed(TestState.Successful)) { return; }
    EXPECT_EQ("template <typename T> T *getFETokenInfo() const {\n  return static_cast<T *>(FETokenInfo);\n}\nint  a; // <- Should not be formatted",format(new StringRef(/*KEEP_STR*/"template<typename T>\nT *getFETokenInfo() const { return static_cast<T*>(FETokenInfo); }\nint  a; // <- Should not be formatted"), 9, 5));
}

;
@Test
//<editor-fold defaultstate="collapsed" desc="clang::format::(anonymous namespace)::FormatTestSelective_FormatsIfWithoutCompoundStatement_Test::TestBody">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTestSelective.cpp", line = 101,
 FQN="clang::format::(anonymous namespace)::FormatTestSelective_FormatsIfWithoutCompoundStatement_Test::TestBody", NM="_ZN5clang6format12_GLOBAL__N_158FormatTestSelective_FormatsIfWithoutCompoundStatement_Test8TestBodyEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTestSelective.cpp -nm=_ZN5clang6format12_GLOBAL__N_158FormatTestSelective_FormatsIfWithoutCompoundStatement_Test8TestBodyEv")
//</editor-fold>
public void test_FormatsIfWithoutCompoundStatement() {
  if (markAsSkippedIfNeed(TestState.Successful)) { return; }
  Style.AllowShortIfStatementsOnASingleLine = true;
    EXPECT_EQ("if (a) return;",format(new StringRef(/*KEEP_STR*/"if(a)\nreturn;"), 7, 1));
    EXPECT_EQ("if (a) return; // comment",format(new StringRef(/*KEEP_STR*/"if(a)\nreturn; // comment"), 20, 1));
}

;
@Test
//<editor-fold defaultstate="collapsed" desc="clang::format::(anonymous namespace)::FormatTestSelective_FormatsCommentsLocally_Test::TestBody">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTestSelective.cpp", line = 108,
 FQN="clang::format::(anonymous namespace)::FormatTestSelective_FormatsCommentsLocally_Test::TestBody", NM="_ZN5clang6format12_GLOBAL__N_147FormatTestSelective_FormatsCommentsLocally_Test8TestBodyEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTestSelective.cpp -nm=_ZN5clang6format12_GLOBAL__N_147FormatTestSelective_FormatsCommentsLocally_Test8TestBodyEv")
//</editor-fold>
public void test_FormatsCommentsLocally() {
    if (markAsSkippedIfNeed(TestState.Successful)) { return; }
    EXPECT_EQ("int a;    // comment\nint    b; // comment",format(new StringRef(/*KEEP_STR*/"int   a; // comment\nint    b; // comment"), 0, 0));
    EXPECT_EQ("int   a; // comment\n         // line 2\nint b;",format(new StringRef(/*KEEP_STR*/"int   a; // comment\n            // line 2\nint b;"), 28, 0));
    EXPECT_EQ("int aaaaaa; // comment\nint b;\nint c; // unrelated comment",format(new StringRef(/*KEEP_STR*/"int aaaaaa; // comment\nint b;\nint   c; // unrelated comment"), 31, 0));
    EXPECT_EQ("int a; // This\n       // is\n       // a",format(new StringRef(/*KEEP_STR*/"int a;      // This\n            // is\n            // a"), 0, 0));
    EXPECT_EQ("int a; // This\n       // is\n       // a\n// This is b\nint b;",format(new StringRef(/*KEEP_STR*/"int a; // This\n     // is\n     // a\n// This is b\nint b;"), 0, 0));
    EXPECT_EQ("int a; // This\n       // is\n       // a\n\n//This is unrelated",format(new StringRef(/*KEEP_STR*/"int a; // This\n     // is\n     // a\n\n//This is unrelated"), 0, 0));
    EXPECT_EQ("int a;\n// This is\n// not formatted.   ",format(new StringRef(/*KEEP_STR*/"int a;\n// This is\n// not formatted.   "), 0, 0));
    EXPECT_EQ("int x;  // Format this line.\nint xx; //\nint xxxxx; //",format(new StringRef(/*KEEP_STR*/"int x; // Format this line.\nint xx; //\nint xxxxx; //"), 0, 0));
}

;
@Test
//<editor-fold defaultstate="collapsed" desc="clang::format::(anonymous namespace)::FormatTestSelective_IndividualStatementsOfNestedBlocks_Test::TestBody">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTestSelective.cpp", line = 174,
 FQN="clang::format::(anonymous namespace)::FormatTestSelective_IndividualStatementsOfNestedBlocks_Test::TestBody", NM="_ZN5clang6format12_GLOBAL__N_159FormatTestSelective_IndividualStatementsOfNestedBlocks_Test8TestBodyEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTestSelective.cpp -nm=_ZN5clang6format12_GLOBAL__N_159FormatTestSelective_IndividualStatementsOfNestedBlocks_Test8TestBodyEv")
//</editor-fold>
public void test_IndividualStatementsOfNestedBlocks() {
    if (markAsSkippedIfNeed(TestState.Successful)) { return; }
    EXPECT_EQ("DEBUG({\n  int i;\n  int        j;\n});",format(new StringRef(/*KEEP_STR*/"DEBUG(   {\n  int        i;\n  int        j;\n}   )  ;"), 20, 1));
    EXPECT_EQ("DEBUG(   {\n  int        i;\n  int j;\n}   )  ;",format(new StringRef(/*KEEP_STR*/"DEBUG(   {\n  int        i;\n  int        j;\n}   )  ;"), 41, 1));
    EXPECT_EQ("DEBUG(   {\n    int        i;\n    int j;\n}   )  ;",format(new StringRef(/*KEEP_STR*/"DEBUG(   {\n    int        i;\n    int        j;\n}   )  ;"), 41, 1));
    EXPECT_EQ("DEBUG({\n  int i;\n  int j;\n});",format(new StringRef(/*KEEP_STR*/"DEBUG(   {\n    int        i;\n    int        j;\n}   )  ;"), 20, 1));
    EXPECT_EQ("Debug({\n        if (aaaaaaaaaaaaaaaaaaaaaaaa)\n          return;\n      },\n      a);",format(new StringRef(/*KEEP_STR*/"Debug({\n        if (aaaaaaaaaaaaaaaaaaaaaaaa)\n             return;\n      },\n      a);"), 50, 1));
    EXPECT_EQ("DEBUG({\n  DEBUG({\n    int a;\n    int b;\n  }) ;\n});",format(new StringRef(/*KEEP_STR*/"DEBUG({\n  DEBUG({\n    int a;\n    int    b;\n  }) ;\n});"), 35, 0));
    EXPECT_EQ("DEBUG({\n  int a; //\n});",format(new StringRef(/*KEEP_STR*/"DEBUG({\n    int a; //\n});"), 0, 0));
    EXPECT_EQ("someFunction(\n    [] {\n      // Only with this comment.\n      int i; // invoke formatting here.\n    }, // force line break\n    aaa);",format(new StringRef(/*KEEP_STR*/"someFunction(\n    [] {\n      // Only with this comment.\n      int   i; // invoke formatting here.\n    }, // force line break\n    aaa);"), 63, 1));
    EXPECT_EQ("int longlongname; // comment\nint x = f({\n  int x; // comment\n  int y; // comment\n});",format(new StringRef(/*KEEP_STR*/"int longlongname; // comment\nint x = f({\n  int x; // comment\n  int y; // comment\n});"), 65, 0));
    EXPECT_EQ("int s = f({\n  class X {\n  public:\n    void f();\n  };\n});",format(new StringRef(/*KEEP_STR*/"int s = f({\n  class X {\n    public:\n    void f();\n  };\n});"), 0, 0));
    EXPECT_EQ("SomeFunction(\n    [] {\n      int i;\n      return i;\n    },\n    [] {\n       return 2;\n    });",format(new StringRef(/*KEEP_STR*/"SomeFunction(\n    [] {\n      int i;\n       return i;\n    },\n    [] {\n       return 2;\n    });"), 40, 0));
}

;
@Test
//<editor-fold defaultstate="collapsed" desc="clang::format::(anonymous namespace)::FormatTestSelective_WrongIndent_Test::TestBody">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTestSelective.cpp", line = 300,
 FQN="clang::format::(anonymous namespace)::FormatTestSelective_WrongIndent_Test::TestBody", NM="_ZN5clang6format12_GLOBAL__N_136FormatTestSelective_WrongIndent_Test8TestBodyEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTestSelective.cpp -nm=_ZN5clang6format12_GLOBAL__N_136FormatTestSelective_WrongIndent_Test8TestBodyEv")
//</editor-fold>
public void test_WrongIndent() {
    if (markAsSkippedIfNeed(TestState.Successful)) { return; }
    EXPECT_EQ("namespace {\nint i;\nint j;\n}",format(new StringRef(/*KEEP_STR*/"namespace {\n  int i;\n  int j;\n}"), 15, 0));
    EXPECT_EQ("namespace {\n  int i;\n  int j;\n}",format(new StringRef(/*KEEP_STR*/"namespace {\n  int i;\n  int j;\n}"), 24, 0));
}

;
@Test
//<editor-fold defaultstate="collapsed" desc="clang::format::(anonymous namespace)::FormatTestSelective_AlwaysFormatsEntireMacroDefinitions_Test::TestBody">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTestSelective.cpp", line = 321,
 FQN="clang::format::(anonymous namespace)::FormatTestSelective_AlwaysFormatsEntireMacroDefinitions_Test::TestBody", NM="_ZN5clang6format12_GLOBAL__N_160FormatTestSelective_AlwaysFormatsEntireMacroDefinitions_Test8TestBodyEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTestSelective.cpp -nm=_ZN5clang6format12_GLOBAL__N_160FormatTestSelective_AlwaysFormatsEntireMacroDefinitions_Test8TestBodyEv")
//</editor-fold>
public void test_AlwaysFormatsEntireMacroDefinitions() {
  if (markAsSkippedIfNeed(TestState.Successful)) { return; }
  Style.AlignEscapedNewlinesLeft = true;
    EXPECT_EQ("int  i;\n#define A \\\n  int i;  \\\n  int j\nint  k;",format(new StringRef(/*KEEP_STR*/"int  i;\n#define A  \\\n int   i    ;  \\\n int   j\nint  k;"), 8, 0));
    // 8: position of "#define".
    EXPECT_EQ("int  i;\n#define A \\\n  int i;  \\\n  int j\nint  k;",format(new StringRef(/*KEEP_STR*/"int  i;\n#define A  \\\n int   i    ;  \\\n int   j\nint  k;"), 45, 0));
  // 45: position of "j".
}

;
@Test
//<editor-fold defaultstate="collapsed" desc="clang::format::(anonymous namespace)::FormatTestSelective_ReformatRegionAdjustsIndent_Test::TestBody">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTestSelective.cpp", line = 347,
 FQN="clang::format::(anonymous namespace)::FormatTestSelective_ReformatRegionAdjustsIndent_Test::TestBody", NM="_ZN5clang6format12_GLOBAL__N_152FormatTestSelective_ReformatRegionAdjustsIndent_Test8TestBodyEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTestSelective.cpp -nm=_ZN5clang6format12_GLOBAL__N_152FormatTestSelective_ReformatRegionAdjustsIndent_Test8TestBodyEv")
//</editor-fold>
public void test_ReformatRegionAdjustsIndent() {
    if (markAsSkippedIfNeed(TestState.Successful)) { return; }
    EXPECT_EQ("{\n{\na;\nb;\n}\n}",format(new StringRef(/*KEEP_STR*/"{\n{\na;\n     b;\n}\n}"), 13, 2));
    EXPECT_EQ("{\n{\n  a;\n  b;\n  c;\n d;\n}\n}",format(new StringRef(/*KEEP_STR*/"{\n{\n     a;\n   b;\n  c;\n d;\n}\n}"), 9, 2));
    EXPECT_EQ("{\n{\npublic:\n  b;\n}\n}",format(new StringRef(/*KEEP_STR*/"{\n{\npublic:\n     b;\n}\n}"), 17, 2));
    EXPECT_EQ("{\n{\na;\n}\n{\n  b; //\n}\n}",format(new StringRef(/*KEEP_STR*/"{\n{\na;\n}\n{\n           b; //\n}\n}"), 22, 2));
    EXPECT_EQ("  {\n    a; //\n  }",format(new StringRef(/*KEEP_STR*/"  {\na; //\n  }"), 4, 2));
    EXPECT_EQ("void f() {}\nvoid g() {}",format(new StringRef(/*KEEP_STR*/"void f() {}\nvoid g() {}"), 13, 0));
    EXPECT_EQ("int a; // comment\n       // line 2\nint b;",format(new StringRef(/*KEEP_STR*/"int a; // comment\n       // line 2\n  int b;"), 35, 0));
    EXPECT_EQ(" void f() {\n#define A 1\n }",format(new StringRef(/*KEEP_STR*/" void f() {\n     #define A 1\n }"), 20, 0));
    EXPECT_EQ(" void f() {\n    int i;\n#define A \\\n    int i;  \\\n   int j;\n    int k;\n }",format(new StringRef(/*KEEP_STR*/" void f() {\n    int i;\n#define A \\\n    int i;  \\\n   int j;\n      int k;\n }"), 67, 0));
  
  Style.ColumnLimit = 11;
    EXPECT_EQ("  int a;\n  void\n  ffffff() {\n  }",format(new StringRef(/*KEEP_STR*/"  int a;\nvoid ffffff() {}"), 11, 0));
}

;
@Test
//<editor-fold defaultstate="collapsed" desc="clang::format::(anonymous namespace)::FormatTestSelective_UnderstandsTabs_Test::TestBody">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTestSelective.cpp", line = 461,
 FQN="clang::format::(anonymous namespace)::FormatTestSelective_UnderstandsTabs_Test::TestBody", NM="_ZN5clang6format12_GLOBAL__N_140FormatTestSelective_UnderstandsTabs_Test8TestBodyEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTestSelective.cpp -nm=_ZN5clang6format12_GLOBAL__N_140FormatTestSelective_UnderstandsTabs_Test8TestBodyEv")
//</editor-fold>
public void test_UnderstandsTabs() {
  if (markAsSkippedIfNeed(TestState.Successful)) { return; }
  Style.IndentWidth = 8;
  Style.UseTab = FormatStyle.UseTabStyle.UT_Always;
  Style.AlignEscapedNewlinesLeft = true;
    EXPECT_EQ("void f() {\n\tf();\n\tg();\n}",format(new StringRef(/*KEEP_STR*/"void f() {\n\tf();\n\tg();\n}"), 0, 0));
    EXPECT_EQ("void f() {\n\tf();\n\tg();\n}",format(new StringRef(/*KEEP_STR*/"void f() {\n\tf();\n\tg();\n}"), 16, 0));
    EXPECT_EQ("void f() {\n  \tf();\n\tg();\n}",format(new StringRef(/*KEEP_STR*/"void f() {\n  \tf();\n  \tg();\n}"), 21, 0));
}

;
@Test
//<editor-fold defaultstate="collapsed" desc="clang::format::(anonymous namespace)::FormatTestSelective_StopFormattingWhenLeavingScope_Test::TestBody">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTestSelective.cpp", line = 494,
 FQN="clang::format::(anonymous namespace)::FormatTestSelective_StopFormattingWhenLeavingScope_Test::TestBody", NM="_ZN5clang6format12_GLOBAL__N_155FormatTestSelective_StopFormattingWhenLeavingScope_Test8TestBodyEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTestSelective.cpp -nm=_ZN5clang6format12_GLOBAL__N_155FormatTestSelective_StopFormattingWhenLeavingScope_Test8TestBodyEv")
//</editor-fold>
public void test_StopFormattingWhenLeavingScope() {
    if (markAsSkippedIfNeed(TestState.Successful)) { return; }
    EXPECT_EQ("void f() {\n  if (a) {\n    g();\n    h();\n}\n\nvoid g() {\n}",format(new StringRef(/*KEEP_STR*/"void f() {\n  if (a) {\n  g();\n  h();\n}\n\nvoid g() {\n}"), 15, 0));
}

;
@Test
//<editor-fold defaultstate="collapsed" desc="clang::format::(anonymous namespace)::FormatTestSelective_SelectivelyRequoteJavaScript_Test::TestBody">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTestSelective.cpp", line = 515,
 FQN="clang::format::(anonymous namespace)::FormatTestSelective_SelectivelyRequoteJavaScript_Test::TestBody", NM="_ZN5clang6format12_GLOBAL__N_153FormatTestSelective_SelectivelyRequoteJavaScript_Test8TestBodyEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTestSelective.cpp -nm=_ZN5clang6format12_GLOBAL__N_153FormatTestSelective_SelectivelyRequoteJavaScript_Test8TestBodyEv")
//</editor-fold>
public void test_SelectivelyRequoteJavaScript() {
  if (markAsSkippedIfNeed(TestState.Successful)) { return; }
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    $c$.clean(Style.$assignMove($c$.track(getGoogleStyle(FormatStyle.LanguageKind.LK_JavaScript))));
    EXPECT_EQ("var x = \"a\";\nvar x = 'a';\nvar x = \"a\";",format(new StringRef(/*KEEP_STR*/"var x = \"a\";\nvar x = \"a\";\nvar x = \"a\";"), 20, 0));
  } finally {
    $c$.$destroy();
  }
}

//} JAVA: end of namespace (anonymous) // end namespace
//} JAVA: end of namespace format // end namespace format
//} JAVA: end of namespace clang
} // END OF class FormatTestSelective
