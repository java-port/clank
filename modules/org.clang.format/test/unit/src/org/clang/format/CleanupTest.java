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
import org.clang.basic.*;
import org.clang.format.*;
import static org.clang.format.FormatGlobals.*;
import static org.clang.tooling.ToolingGlobals.*;
import static org.clank.java.std_defines.UINT_MAX;


//<editor-fold defaultstate="collapsed" desc="static type CleanupTest">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 NM="CleanupTest",
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -print -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Format/CleanupTest.cpp -test=CleanupTest")
//</editor-fold>
public final class CleanupTest extends ADTSupportTestBase {

//JAVA: namespace clang {
//JAVA: namespace format {
//JAVA: namespace (anonymous) {

////<editor-fold defaultstate="collapsed" desc="clang::format::(anonymous namespace)::CleanupTest">
//@Converted(kind = Converted.Kind.AUTO,
// source = "${LLVM_SRC}/llvm/tools/clang/unittests/Format/CleanupTest.cpp", line = 21,
// FQN="clang::format::(anonymous namespace)::CleanupTest", NM="_ZN5clang6format12_GLOBAL__N_111CleanupTestE",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Format/CleanupTest.cpp -nm=_ZN5clang6format12_GLOBAL__N_111CleanupTestE")
////</editor-fold>
//public abstract static class CleanupTest extends /*public*/ Test implements Destructors.ClassWithDestructor {
/*protected:*/
  //<editor-fold defaultstate="collapsed" desc="clang::format::(anonymous namespace)::CleanupTest::cleanup">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/unittests/Format/CleanupTest.cpp", line = 23,
   FQN="clang::format::(anonymous namespace)::CleanupTest::cleanup", NM="_ZN5clang6format12_GLOBAL__N_111CleanupTest7cleanupEN4llvm9StringRefERKSt6vectorINS_7tooling5RangeESaIS7_EERKNS0_11FormatStyleE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Format/CleanupTest.cpp -nm=_ZN5clang6format12_GLOBAL__N_111CleanupTest7cleanupEN4llvm9StringRefERKSt6vectorINS_7tooling5RangeESaIS7_EERKNS0_11FormatStyleE")
  //</editor-fold>
  protected std.string cleanup(StringRef Code, 
         final /*const*/std.vector<Range> /*&*/ Ranges) {
    return cleanup(Code, 
         Ranges, 
         getLLVMStyle());
  }
  protected std.string cleanup(StringRef Code, 
         final /*const*/std.vector<Range> /*&*/ Ranges, 
         final /*const*/ FormatStyle /*&*/ Style/*= $c$.track(getLLVMStyle())*/) {
    std.setType<Replacement> Replaces = null;
    Expected<std.string> Result = null;
    try {
      Replaces = FormatGlobals.cleanup(Style, new StringRef(Code), new ArrayRef<Range>(Ranges, false));
      
      Result = applyAllReplacements(new StringRef(Code), Replaces);
      EXPECT_TRUE(((/*static_cast*/boolean)(Result.$bool())));
      return new std.string(Result.$star());
    } finally {
      if (Result != null) { Result.$destroy(); }
      if (Replaces != null) { Replaces.$destroy(); }
    }
  }

  //<editor-fold defaultstate="collapsed" desc="clang::format::(anonymous namespace)::CleanupTest::~CleanupTest">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/unittests/Format/CleanupTest.cpp", line = 21,
   FQN="clang::format::(anonymous namespace)::CleanupTest::~CleanupTest", NM="_ZN5clang6format12_GLOBAL__N_111CleanupTestD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Format/CleanupTest.cpp -nm=_ZN5clang6format12_GLOBAL__N_111CleanupTestD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    super.$destroy();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::format::(anonymous namespace)::CleanupTest::CleanupTest">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/unittests/Format/CleanupTest.cpp", line = 21,
   FQN="clang::format::(anonymous namespace)::CleanupTest::CleanupTest", NM="_ZN5clang6format12_GLOBAL__N_111CleanupTestC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Format/CleanupTest.cpp -nm=_ZN5clang6format12_GLOBAL__N_111CleanupTestC1Ev")
  //</editor-fold>
  public /*inline*/ CleanupTest() {
    // : Test() 
    //START JInit
    super();
    //END JInit
  }

  
  @Override public String toString() {
    return "" + super.toString(); // NOI18N
  }
//}
;
@Test
//<editor-fold defaultstate="collapsed" desc="clang::format::(anonymous namespace)::CleanupTest_DeleteEmptyNamespaces_Test::TestBody">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/unittests/Format/CleanupTest.cpp", line = 34,
 FQN="clang::format::(anonymous namespace)::CleanupTest_DeleteEmptyNamespaces_Test::TestBody", NM="_ZN5clang6format12_GLOBAL__N_138CleanupTest_DeleteEmptyNamespaces_Test8TestBodyEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Format/CleanupTest.cpp -nm=_ZN5clang6format12_GLOBAL__N_138CleanupTest_DeleteEmptyNamespaces_Test8TestBodyEv")
//</editor-fold>
public void test_DeleteEmptyNamespaces() {
  if (markAsSkippedIfNeed(TestState.Successful)) { return; }
  std.vector<Range> Ranges = null;
  try {
    std.string Code = new std.string(JD$T$C$P_T2$C$R.INSTANCE, /*KEEP_STR*/"namespace A {\nnamespace B {\n} // namespace B\n} // namespace A\n\nnamespace C {\nnamespace D { int i; }\ninline namespace E { namespace { } }\n}");
    std.string Expected = new std.string(JD$T$C$P_T2$C$R.INSTANCE, /*KEEP_STR*/"\n\n\n\n\nnamespace C {\nnamespace D { int i; }\n   \n}");
    Ranges/*J*/= new std.vector<Range>(new Range());
    Ranges.push_back_T$RR(new Range(28, 0));
    Ranges.push_back_T$RR(new Range(91, 6));
    Ranges.push_back_T$RR(new Range(132, 0));
    std.string Result = cleanup(new StringRef(Code), Ranges);
    EXPECT_EQ(Expected,Result);
  } finally {
    if (Ranges != null) { Ranges.$destroy(); }
  }
}

;
@Test
//<editor-fold defaultstate="collapsed" desc="clang::format::(anonymous namespace)::CleanupTest_NamespaceWithSyntaxError_Test::TestBody">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/unittests/Format/CleanupTest.cpp", line = 54,
 FQN="clang::format::(anonymous namespace)::CleanupTest_NamespaceWithSyntaxError_Test::TestBody", NM="_ZN5clang6format12_GLOBAL__N_141CleanupTest_NamespaceWithSyntaxError_Test8TestBodyEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Format/CleanupTest.cpp -nm=_ZN5clang6format12_GLOBAL__N_141CleanupTest_NamespaceWithSyntaxError_Test8TestBodyEv")
//</editor-fold>
public void test_NamespaceWithSyntaxError() {
  if (markAsSkippedIfNeed(TestState.Successful)) { return; }
  std.vector<Range> Ranges = null;
  try {
    std.string Code = new std.string(JD$T$C$P_T2$C$R.INSTANCE, /*KEEP_STR*/"namespace A {\nnamespace B {\n} // namespace A\n\nnamespace C {\nnamespace D int i; }\ninline namespace E { namespace { } }\n}");
    std.string Expected = new std.string(JD$T$C$P_T2$C$R.INSTANCE, /*KEEP_STR*/"namespace A {\n\n\n\nnamespace C {\nnamespace D int i; }\n   \n}");
    Ranges/*J*/= new std.vector<Range>(1, new Range(0, Code.size()), new Range());
    std.string Result = cleanup(new StringRef(Code), Ranges);
    EXPECT_EQ(Expected,Result);
  } finally {
    if (Ranges != null) { Ranges.$destroy(); }
  }
}

;
@Test
//<editor-fold defaultstate="collapsed" desc="clang::format::(anonymous namespace)::CleanupTest_EmptyNamespaceNotAffected_Test::TestBody">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/unittests/Format/CleanupTest.cpp", line = 71,
 FQN="clang::format::(anonymous namespace)::CleanupTest_EmptyNamespaceNotAffected_Test::TestBody", NM="_ZN5clang6format12_GLOBAL__N_142CleanupTest_EmptyNamespaceNotAffected_Test8TestBodyEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Format/CleanupTest.cpp -nm=_ZN5clang6format12_GLOBAL__N_142CleanupTest_EmptyNamespaceNotAffected_Test8TestBodyEv")
//</editor-fold>
public void test_EmptyNamespaceNotAffected() {
  if (markAsSkippedIfNeed(TestState.Successful)) { return; }
  std.vector<Range> Ranges = null;
  try {
    std.string Code = new std.string(JD$T$C$P_T2$C$R.INSTANCE, /*KEEP_STR*/"namespace A {\n\nnamespace {\n\n}}");
    // Even though the namespaces are empty, but the inner most empty namespace
    // block is not affected by the changed ranges.
    std.string Expected = new std.string(JD$T$C$P_T2$C$R.INSTANCE, /*KEEP_STR*/"namespace A {\n\nnamespace {\n\n}}");
    // Set the changed range to be the second "\n".
    Ranges/*J*/= new std.vector<Range>(1, new Range(14, 0), new Range());
    std.string Result = cleanup(new StringRef(Code), Ranges);
    EXPECT_EQ(Expected,Result);
  } finally {
    if (Ranges != null) { Ranges.$destroy(); }
  }
}

;
@Test
//<editor-fold defaultstate="collapsed" desc="clang::format::(anonymous namespace)::CleanupTest_EmptyNamespaceWithCommentsNoBreakBeforeBrace_Test::TestBody">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/unittests/Format/CleanupTest.cpp", line = 84,
 FQN="clang::format::(anonymous namespace)::CleanupTest_EmptyNamespaceWithCommentsNoBreakBeforeBrace_Test::TestBody", NM="_ZN5clang6format12_GLOBAL__N_161CleanupTest_EmptyNamespaceWithCommentsNoBreakBeforeBrace_Test8TestBodyEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Format/CleanupTest.cpp -nm=_ZN5clang6format12_GLOBAL__N_161CleanupTest_EmptyNamespaceWithCommentsNoBreakBeforeBrace_Test8TestBodyEv")
//</editor-fold>
public void test_EmptyNamespaceWithCommentsNoBreakBeforeBrace() {
  if (markAsSkippedIfNeed(TestState.Successful)) { return; }
  std.vector<Range> Ranges = null;
  try {
    std.string Code = new std.string(JD$T$C$P_T2$C$R.INSTANCE, /*KEEP_STR*/"namespace A {\nnamespace B {\n// Yo\n} // namespace B\n} // namespace A\nnamespace C { // Yo\n}");
    std.string Expected = new std.string(JD$T$C$P_T2$C$R.INSTANCE, /*KEEP_STR*/"\n\n\n\n\n\n");
    Ranges/*J*/= new std.vector<Range>(1, new Range(0, Code.size()), new Range());
    std.string Result = cleanup(new StringRef(Code), Ranges);
    EXPECT_EQ(Expected,Result);
  } finally {
    if (Ranges != null) { Ranges.$destroy(); }
  }
}

;
@Test
//<editor-fold defaultstate="collapsed" desc="clang::format::(anonymous namespace)::CleanupTest_EmptyNamespaceWithCommentsBreakBeforeBrace_Test::TestBody">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/unittests/Format/CleanupTest.cpp", line = 98,
 FQN="clang::format::(anonymous namespace)::CleanupTest_EmptyNamespaceWithCommentsBreakBeforeBrace_Test::TestBody", NM="_ZN5clang6format12_GLOBAL__N_159CleanupTest_EmptyNamespaceWithCommentsBreakBeforeBrace_Test8TestBodyEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Format/CleanupTest.cpp -nm=_ZN5clang6format12_GLOBAL__N_159CleanupTest_EmptyNamespaceWithCommentsBreakBeforeBrace_Test8TestBodyEv")
//</editor-fold>
public void test_EmptyNamespaceWithCommentsBreakBeforeBrace() {
  if (markAsSkippedIfNeed(TestState.Successful)) { return; }
  std.vector<Range> Ranges = null;
  FormatStyle Style = null;
  try {
    std.string Code = new std.string(JD$T$C$P_T2$C$R.INSTANCE, /*KEEP_STR*/"namespace A\n/* Yo */ {\nnamespace B\n{\n// Yo\n} // namespace B\n} // namespace A\nnamespace C\n{ // Yo\n}\n");
    std.string Expected = new std.string(JD$T$C$P_T2$C$R.INSTANCE, /*KEEP_STR*/"\n\n\n\n\n\n\n\n\n\n");
    Ranges/*J*/= new std.vector<Range>(1, new Range(0, Code.size()), new Range());
    Style = getLLVMStyle();
    Style.BraceWrapping.AfterNamespace = true;
    std.string Result = cleanup(new StringRef(Code), Ranges, Style);
    EXPECT_EQ(Expected,Result);
  } finally {
    if (Style != null) { Style.$destroy(); }
    if (Ranges != null) { Ranges.$destroy(); }
  }
}

;
@Test
//<editor-fold defaultstate="collapsed" desc="clang::format::(anonymous namespace)::CleanupTest_CtorInitializationSimpleRedundantComma_Test::TestBody">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/unittests/Format/CleanupTest.cpp", line = 117,
 FQN="clang::format::(anonymous namespace)::CleanupTest_CtorInitializationSimpleRedundantComma_Test::TestBody", NM="_ZN5clang6format12_GLOBAL__N_155CleanupTest_CtorInitializationSimpleRedundantComma_Test8TestBodyEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Format/CleanupTest.cpp -nm=_ZN5clang6format12_GLOBAL__N_155CleanupTest_CtorInitializationSimpleRedundantComma_Test8TestBodyEv")
//</editor-fold>
public void test_CtorInitializationSimpleRedundantComma() {
  if (markAsSkippedIfNeed(TestState.Successful)) { return; }
  std.vector<Range> Ranges = null;
  try {
    std.string Code = new std.string(JD$T$C$P_T2$C$R.INSTANCE, /*KEEP_STR*/"class A {\nA() : , {} };");
    std.string Expected = new std.string(JD$T$C$P_T2$C$R.INSTANCE, /*KEEP_STR*/"class A {\nA()  {} };");
    Ranges/*J*/= new std.vector<Range>(new Range());
    Ranges.push_back_T$RR(new Range(17, 0));
    Ranges.push_back_T$RR(new Range(19, 0));
    std.string Result = cleanup(new StringRef(Code), Ranges);
    EXPECT_EQ(Expected,Result);
    
    Code.$assign_T$C$P(/*KEEP_STR*/"class A {\nA() : x(1), {} };");
    Expected.$assign_T$C$P(/*KEEP_STR*/"class A {\nA() : x(1) {} };");
    Ranges.clear();
    Ranges.push_back_T$RR(new Range(23, 0));
    Result.$assignMove(cleanup(new StringRef(Code), Ranges));
    EXPECT_EQ(Expected,Result);
    
    Code.$assign_T$C$P(/*KEEP_STR*/"class A {\nA() :,,,,{} };");
    Expected.$assign_T$C$P(/*KEEP_STR*/"class A {\nA() {} };");
    Ranges.clear();
    Ranges.push_back_T$RR(new Range(15, 0));
    Result.$assignMove(cleanup(new StringRef(Code), Ranges));
    EXPECT_EQ(Expected,Result);
  } finally {
    if (Ranges != null) { Ranges.$destroy(); }
  }
}

;
@Test
//<editor-fold defaultstate="collapsed" desc="clang::format::(anonymous namespace)::CleanupTest_ListSimpleRedundantComma_Test::TestBody">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/unittests/Format/CleanupTest.cpp", line = 141,
 FQN="clang::format::(anonymous namespace)::CleanupTest_ListSimpleRedundantComma_Test::TestBody", NM="_ZN5clang6format12_GLOBAL__N_141CleanupTest_ListSimpleRedundantComma_Test8TestBodyEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Format/CleanupTest.cpp -nm=_ZN5clang6format12_GLOBAL__N_141CleanupTest_ListSimpleRedundantComma_Test8TestBodyEv")
//</editor-fold>
public void test_ListSimpleRedundantComma() {
  if (markAsSkippedIfNeed(TestState.Successful)) { return; }
  std.vector<Range> Ranges = null;
  try {
    std.string Code = new std.string(JD$T$C$P_T2$C$R.INSTANCE, /*KEEP_STR*/"void f() { std::vector<int> v = {1,2,,,3,{4,5}}; }");
    std.string Expected = new std.string(JD$T$C$P_T2$C$R.INSTANCE, /*KEEP_STR*/"void f() { std::vector<int> v = {1,2,3,{4,5}}; }");
    Ranges/*J*/= new std.vector<Range>(new Range());
    Ranges.push_back_T$RR(new Range(40, 0));
    std.string Result = cleanup(new StringRef(Code), Ranges);
    EXPECT_EQ(Expected,Result);
    
    Code.$assign_T$C$P(/*KEEP_STR*/"int main() { f(1,,2,3,,4);}");
    Expected.$assign_T$C$P(/*KEEP_STR*/"int main() { f(1,2,3,4);}");
    Ranges.clear();
    Ranges.push_back_T$RR(new Range(17, 0));
    Ranges.push_back_T$RR(new Range(22, 0));
    Result.$assignMove(cleanup(new StringRef(Code), Ranges));
    EXPECT_EQ(Expected,Result);
  } finally {
    if (Ranges != null) { Ranges.$destroy(); }
  }
}

;
@Test
//<editor-fold defaultstate="collapsed" desc="clang::format::(anonymous namespace)::CleanupTest_CtorInitializationBracesInParens_Test::TestBody">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/unittests/Format/CleanupTest.cpp", line = 158,
 FQN="clang::format::(anonymous namespace)::CleanupTest_CtorInitializationBracesInParens_Test::TestBody", NM="_ZN5clang6format12_GLOBAL__N_149CleanupTest_CtorInitializationBracesInParens_Test8TestBodyEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Format/CleanupTest.cpp -nm=_ZN5clang6format12_GLOBAL__N_149CleanupTest_CtorInitializationBracesInParens_Test8TestBodyEv")
//</editor-fold>
public void test_CtorInitializationBracesInParens() {
  if (markAsSkippedIfNeed(TestState.Successful)) { return; }
  std.vector<Range> Ranges = null;
  try {
    std.string Code = new std.string(JD$T$C$P_T2$C$R.INSTANCE, /*KEEP_STR*/"class A {\nA() : x({1}),, {} };");
    std.string Expected = new std.string(JD$T$C$P_T2$C$R.INSTANCE, /*KEEP_STR*/"class A {\nA() : x({1}) {} };");
    Ranges/*J*/= new std.vector<Range>(new Range());
    Ranges.push_back_T$RR(new Range(24, 0));
    Ranges.push_back_T$RR(new Range(26, 0));
    std.string Result = cleanup(new StringRef(Code), Ranges);
    EXPECT_EQ(Expected,Result);
  } finally {
    if (Ranges != null) { Ranges.$destroy(); }
  }
}

;
@Test
//<editor-fold defaultstate="collapsed" desc="clang::format::(anonymous namespace)::CleanupTest_RedundantCommaNotInAffectedRanges_Test::TestBody">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/unittests/Format/CleanupTest.cpp", line = 168,
 FQN="clang::format::(anonymous namespace)::CleanupTest_RedundantCommaNotInAffectedRanges_Test::TestBody", NM="_ZN5clang6format12_GLOBAL__N_150CleanupTest_RedundantCommaNotInAffectedRanges_Test8TestBodyEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Format/CleanupTest.cpp -nm=_ZN5clang6format12_GLOBAL__N_150CleanupTest_RedundantCommaNotInAffectedRanges_Test8TestBodyEv")
//</editor-fold>
public void test_RedundantCommaNotInAffectedRanges() {
  if (markAsSkippedIfNeed(TestState.Successful)) { return; }
  std.vector<Range> Ranges = null;
  try {
    std.string Code = new std.string(JD$T$C$P_T2$C$R.INSTANCE, /*KEEP_STR*/"class A {\nA() : x({1}), /* comment */, { int x = 0; } };");
    std.string Expected = new std.string(JD$T$C$P_T2$C$R.INSTANCE, /*KEEP_STR*/"class A {\nA() : x({1}), /* comment */, { int x = 0; } };");
    // Set the affected range to be "int x = 0", which does not intercept the
    // constructor initialization list.
    Ranges/*J*/= new std.vector<Range>(1, new Range(42, 9), new Range());
    std.string Result = cleanup(new StringRef(Code), Ranges);
    EXPECT_EQ(Expected,Result);
    
    Code.$assign_T$C$P(/*KEEP_STR*/"class A {\nA() : x(1), {} };");
    Expected.$assign_T$C$P(/*KEEP_STR*/"class A {\nA() : x(1), {} };");
    // No range. Fixer should do nothing.
    Ranges.clear();
    Result.$assignMove(cleanup(new StringRef(Code), Ranges));
    EXPECT_EQ(Expected,Result);
  } finally {
    if (Ranges != null) { Ranges.$destroy(); }
  }
}


// FIXME: delete comments too.
;
@Test
//<editor-fold defaultstate="collapsed" desc="clang::format::(anonymous namespace)::CleanupTest_CtorInitializationCommentAroundCommas_Test::TestBody">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/unittests/Format/CleanupTest.cpp", line = 188,
 FQN="clang::format::(anonymous namespace)::CleanupTest_CtorInitializationCommentAroundCommas_Test::TestBody", NM="_ZN5clang6format12_GLOBAL__N_154CleanupTest_CtorInitializationCommentAroundCommas_Test8TestBodyEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Format/CleanupTest.cpp -nm=_ZN5clang6format12_GLOBAL__N_154CleanupTest_CtorInitializationCommentAroundCommas_Test8TestBodyEv")
//</editor-fold>
public void test_CtorInitializationCommentAroundCommas() {
  if (markAsSkippedIfNeed(TestState.Successful)) { return; }
  std.vector<Range> Ranges = null;
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    // Remove redundant commas around comment.
    std.string Code = new std.string(JD$T$C$P_T2$C$R.INSTANCE, /*KEEP_STR*/"class A {\nA() : x({1}), /* comment */, {} };");
    std.string Expected = new std.string(JD$T$C$P_T2$C$R.INSTANCE, /*KEEP_STR*/"class A {\nA() : x({1}) /* comment */ {} };");
    Ranges/*J*/= new std.vector<Range>(new Range());
    Ranges.push_back_T$RR(new Range(25, 0));
    Ranges.push_back_T$RR(new Range(40, 0));
    std.string Result = cleanup(new StringRef(Code), Ranges);
    EXPECT_EQ(Expected,Result);
    
    // Remove trailing comma and ignore comment.
    Code.$assign_T$C$P(/*KEEP_STR*/"class A {\nA() : x({1}), // comment\n{} };");
    Expected.$assign_T$C$P(/*KEEP_STR*/"class A {\nA() : x({1}) // comment\n{} };");
    $c$.clean(Ranges.$assignMove($c$.track(new std.vector<Range>(1, new Range(25, 0), new Range()))));
    Result.$assignMove(cleanup(new StringRef(Code), Ranges));
    EXPECT_EQ(Expected,Result);
    
    // Remove trailing comma and ignore comment.
    Code.$assign_T$C$P(/*KEEP_STR*/"class A {\nA() : x({1}), // comment\n , y(1),{} };");
    Expected.$assign_T$C$P(/*KEEP_STR*/"class A {\nA() : x({1}), // comment\n  y(1){} };");
    $c$.clean(Ranges.$assignMove($c$.track(new std.vector<Range>(1, new Range(38, 0), new Range()))));
    Result.$assignMove(cleanup(new StringRef(Code), Ranges));
    EXPECT_EQ(Expected,Result);
    
    // Remove trailing comma and ignore comment.
    Code.$assign_T$C$P(/*KEEP_STR*/"class A {\nA() : x({1}), \n/* comment */, y(1),{} };");
    Expected.$assign_T$C$P(/*KEEP_STR*/"class A {\nA() : x({1}), \n/* comment */ y(1){} };");
    $c$.clean(Ranges.$assignMove($c$.track(new std.vector<Range>(1, new Range(40, 0), new Range()))));
    Result.$assignMove(cleanup(new StringRef(Code), Ranges));
    EXPECT_EQ(Expected,Result);
    
    // Remove trailing comma and ignore comment.
    Code.$assign_T$C$P(/*KEEP_STR*/"class A {\nA() : , // comment\n y(1),{} };");
    Expected.$assign_T$C$P(/*KEEP_STR*/"class A {\nA() :  // comment\n y(1){} };");
    $c$.clean(Ranges.$assignMove($c$.track(new std.vector<Range>(1, new Range(17, 0), new Range()))));
    Result.$assignMove(cleanup(new StringRef(Code), Ranges));
    EXPECT_EQ(Expected,Result);
  } finally {
    if (Ranges != null) { Ranges.$destroy(); }
    $c$.$destroy();
  }
}

;
@Test
//<editor-fold defaultstate="collapsed" desc="clang::format::(anonymous namespace)::CleanupTest_CtorInitializerInNamespace_Test::TestBody">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/unittests/Format/CleanupTest.cpp", line = 227,
 FQN="clang::format::(anonymous namespace)::CleanupTest_CtorInitializerInNamespace_Test::TestBody", NM="_ZN5clang6format12_GLOBAL__N_143CleanupTest_CtorInitializerInNamespace_Test8TestBodyEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Format/CleanupTest.cpp -nm=_ZN5clang6format12_GLOBAL__N_143CleanupTest_CtorInitializerInNamespace_Test8TestBodyEv")
//</editor-fold>
public void test_CtorInitializerInNamespace() {
  if (markAsSkippedIfNeed(TestState.Successful)) { return; }
  std.vector<Range> Ranges = null;
  try {
    std.string Code = new std.string(JD$T$C$P_T2$C$R.INSTANCE, /*KEEP_STR*/"namespace A {\nnamespace B {\n} // namespace A\n\nnamespace C {\nclass A { A() : x(0),, {} };\ninline namespace E { namespace { } }\n}");
    std.string Expected = new std.string(JD$T$C$P_T2$C$R.INSTANCE, /*KEEP_STR*/"namespace A {\n\n\n\nnamespace C {\nclass A { A() : x(0) {} };\n   \n}");
    Ranges/*J*/= new std.vector<Range>(1, new Range(0, Code.size()), new Range());
    std.string Result = cleanup(new StringRef(Code), Ranges);
    EXPECT_EQ(Expected,Result);
  } finally {
    if (Ranges != null) { Ranges.$destroy(); }
  }
}


////<editor-fold defaultstate="collapsed" desc="clang::format::(anonymous namespace)::CleanUpReplacementsTest">
//@Converted(kind = Converted.Kind.AUTO,
// source = "${LLVM_SRC}/llvm/tools/clang/unittests/Format/CleanupTest.cpp", line = 244,
// FQN="clang::format::(anonymous namespace)::CleanUpReplacementsTest", NM="_ZN5clang6format12_GLOBAL__N_123CleanUpReplacementsTestE",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Format/CleanupTest.cpp -nm=_ZN5clang6format12_GLOBAL__N_123CleanUpReplacementsTestE")
////</editor-fold>
//public abstract static class CleanUpReplacementsTest extends /*public*/ ADTSupportTestBase implements Destructors.ClassWithDestructor {
/*protected:*/
  //<editor-fold defaultstate="collapsed" desc="clang::format::(anonymous namespace)::CleanUpReplacementsTest::createReplacement">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/unittests/Format/CleanupTest.cpp", line = 246,
   FQN="clang::format::(anonymous namespace)::CleanUpReplacementsTest::createReplacement", NM="_ZN5clang6format12_GLOBAL__N_123CleanUpReplacementsTest17createReplacementEjjN4llvm9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Format/CleanupTest.cpp -nm=_ZN5clang6format12_GLOBAL__N_123CleanUpReplacementsTest17createReplacementEjjN4llvm9StringRefE")
  //</editor-fold>
  protected Replacement createReplacement(/*uint*/int Offset, /*uint*/int Length, 
                   StringRef Text) {
    return new Replacement(new StringRef(FileName), Offset, Length, new StringRef(Text));
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::format::(anonymous namespace)::CleanUpReplacementsTest::createInsertion">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/unittests/Format/CleanupTest.cpp", line = 251,
   FQN="clang::format::(anonymous namespace)::CleanUpReplacementsTest::createInsertion", NM="_ZN5clang6format12_GLOBAL__N_123CleanUpReplacementsTest15createInsertionEN4llvm9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Format/CleanupTest.cpp -nm=_ZN5clang6format12_GLOBAL__N_123CleanUpReplacementsTest15createInsertionEN4llvm9StringRefE")
  //</editor-fold>
  protected Replacement createInsertion(String HeaderName) {
    return createInsertion(new StringRef(create_char$ptr_utf8(HeaderName), HeaderName.length()));
  }
  protected Replacement createInsertion(StringRef HeaderName) {
    return createReplacement(UINT_MAX, 0, new StringRef(HeaderName));
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::format::(anonymous namespace)::CleanUpReplacementsTest::apply">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/unittests/Format/CleanupTest.cpp", line = 255,
   FQN="clang::format::(anonymous namespace)::CleanUpReplacementsTest::apply", NM="_ZN5clang6format12_GLOBAL__N_123CleanUpReplacementsTest5applyEN4llvm9StringRefESt3setINS_7tooling11ReplacementESt4lessIS7_ESaIS7_EE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Format/CleanupTest.cpp -nm=_ZN5clang6format12_GLOBAL__N_123CleanUpReplacementsTest5applyEN4llvm9StringRefESt3setINS_7tooling11ReplacementESt4lessIS7_ESaIS7_EE")
  //</editor-fold>
  protected /*inline*/ std.string apply(std.string Code, 
       /*const*/ std.setType<Replacement> Replaces) {
    return apply(new StringRef(Code), Replaces);
  }
  protected /*inline*/ std.string apply(StringRef Code, 
       /*const*/ std.setType<Replacement> Replaces) {
    Expected<std.setType<Replacement>> CleanReplaces = null;
    Expected<std.string> Result = null;
    try {
      CleanReplaces = cleanupAroundReplacements(new StringRef(Code), Replaces, Style);
      EXPECT_TRUE(((/*static_cast*/boolean)(CleanReplaces.$bool())));
      Result = applyAllReplacements(new StringRef(Code), CleanReplaces.$star());
      EXPECT_TRUE(((/*static_cast*/boolean)(Result.$bool())));
      return new std.string(Result.$star());
    } finally {
      if (Result != null) { Result.$destroy(); }
      if (CleanReplaces != null) { CleanReplaces.$destroy(); }
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::format::(anonymous namespace)::CleanUpReplacementsTest::formatAndApply">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/unittests/Format/CleanupTest.cpp", line = 265,
   FQN="clang::format::(anonymous namespace)::CleanUpReplacementsTest::formatAndApply", NM="_ZN5clang6format12_GLOBAL__N_123CleanUpReplacementsTest14formatAndApplyEN4llvm9StringRefESt3setINS_7tooling11ReplacementESt4lessIS7_ESaIS7_EE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Format/CleanupTest.cpp -nm=_ZN5clang6format12_GLOBAL__N_123CleanUpReplacementsTest14formatAndApplyEN4llvm9StringRefESt3setINS_7tooling11ReplacementESt4lessIS7_ESaIS7_EE")
  //</editor-fold>
  protected /*inline*/ std.string formatAndApply(StringRef Code, 
                /*const*/ std.setType<Replacement> Replaces) {
    Expected<std.setType<Replacement>> CleanReplaces = null;
    Expected<std.setType<Replacement>> FormattedReplaces = null;
    Expected<std.string> Result = null;
    try {
      
      CleanReplaces = cleanupAroundReplacements(new StringRef(Code), Replaces, Style);
      EXPECT_TRUE(((/*static_cast*/boolean)(CleanReplaces.$bool())));
      FormattedReplaces = formatReplacements(new StringRef(Code), CleanReplaces.$star(), Style);
      EXPECT_TRUE(((/*static_cast*/boolean)(FormattedReplaces.$bool())));
      Result = applyAllReplacements(new StringRef(Code), FormattedReplaces.$star());
      EXPECT_TRUE(((/*static_cast*/boolean)(Result.$bool())));
      return new std.string(Result.$star());
    } finally {
      if (Result != null) { Result.$destroy(); }
      if (FormattedReplaces != null) { FormattedReplaces.$destroy(); }
      if (CleanReplaces != null) { CleanReplaces.$destroy(); }
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::format::(anonymous namespace)::CleanUpReplacementsTest::getOffset">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/unittests/Format/CleanupTest.cpp", line = 279,
   FQN="clang::format::(anonymous namespace)::CleanUpReplacementsTest::getOffset", NM="_ZN5clang6format12_GLOBAL__N_123CleanUpReplacementsTest9getOffsetEN4llvm9StringRefEii",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Format/CleanupTest.cpp -nm=_ZN5clang6format12_GLOBAL__N_123CleanUpReplacementsTest9getOffsetEN4llvm9StringRefEii")
  //</editor-fold>
  protected int getOffset(StringRef Code, int Line, int Column) {
    RewriterTestContext Context = null;
    try {
      Context/*J*/= new RewriterTestContext();
      FileID ID = Context.createInMemoryFile(new StringRef(FileName), new StringRef(Code));
      std.pairTypeUInt<FileID> DecomposedLocation = Context.Sources.getDecomposedLoc(Context.getLocation(new FileID(ID), Line, Column));
      return DecomposedLocation.second;
    } finally {
      if (Context != null) { Context.$destroy(); }
    }
  }

  
  protected /*const*/std.string FileName/* = "fix.cpp"*/;
  protected FormatStyle Style/* = getLLVMStyle()*/;
//  //<editor-fold defaultstate="collapsed" desc="clang::format::(anonymous namespace)::CleanUpReplacementsTest::~CleanUpReplacementsTest">
//  @Converted(kind = Converted.Kind.AUTO,
//   source = "${LLVM_SRC}/llvm/tools/clang/unittests/Format/CleanupTest.cpp", line = 244,
//   FQN="clang::format::(anonymous namespace)::CleanUpReplacementsTest::~CleanUpReplacementsTest", NM="_ZN5clang6format12_GLOBAL__N_123CleanUpReplacementsTestD0Ev",
//   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Format/CleanupTest.cpp -nm=_ZN5clang6format12_GLOBAL__N_123CleanUpReplacementsTestD0Ev")
//  //</editor-fold>
//  @Override public /*inline*/ void $destroy() {
//    //START JDestroy
//    Style.$destroy();
//    FileName.$destroy();
//    super.$destroy();
//    //END JDestroy
//  }

//  //<editor-fold defaultstate="collapsed" desc="clang::format::(anonymous namespace)::CleanUpReplacementsTest::CleanUpReplacementsTest">
//  @Converted(kind = Converted.Kind.AUTO,
//   source = "${LLVM_SRC}/llvm/tools/clang/unittests/Format/CleanupTest.cpp", line = 244,
//   FQN="clang::format::(anonymous namespace)::CleanUpReplacementsTest::CleanUpReplacementsTest", NM="_ZN5clang6format12_GLOBAL__N_123CleanUpReplacementsTestC1Ev",
//   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Format/CleanupTest.cpp -nm=_ZN5clang6format12_GLOBAL__N_123CleanUpReplacementsTestC1Ev")
//  //</editor-fold>
//  public /*inline*/ CleanUpReplacementsTest() {
//    // : Test(), FileName("fix.cpp"), Style($c$.track(getLLVMStyle())) 
//    //START JInit
//    super();
  {
    /*InClass*/this.FileName = new std.string(JD$T$C$P_T2$C$R.INSTANCE, /*KEEP_STR*/"fix.cpp");
    /*InClass*/this.Style = getLLVMStyle();
    //END JInit
  }

  
//  @Override public String toString() {
//    return "" + "FileName=" + FileName // NOI18N
//              + ", Style=" + Style // NOI18N
//              + super.toString(); // NOI18N
//  }
//};
;
@Test
//<editor-fold defaultstate="collapsed" desc="clang::format::(anonymous namespace)::CleanUpReplacementsTest_FixOnlyAffectedCodeAfterReplacements_Test::TestBody">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/unittests/Format/CleanupTest.cpp", line = 291,
 FQN="clang::format::(anonymous namespace)::CleanUpReplacementsTest_FixOnlyAffectedCodeAfterReplacements_Test::TestBody", NM="_ZN5clang6format12_GLOBAL__N_165CleanUpReplacementsTest_FixOnlyAffectedCodeAfterReplacements_Test8TestBodyEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Format/CleanupTest.cpp -nm=_ZN5clang6format12_GLOBAL__N_165CleanUpReplacementsTest_FixOnlyAffectedCodeAfterReplacements_Test8TestBodyEv")
//</editor-fold>
public void test_FixOnlyAffectedCodeAfterReplacements() {
  if (markAsSkippedIfNeed(TestState.Successful)) { return; }
  std.setType<Replacement> Replaces = null;
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    std.string Code = new std.string(JD$T$C$P_T2$C$R.INSTANCE, /*KEEP_STR*/"namespace A {\nnamespace B {\n  int x;\n} // namespace B\n} // namespace A\n\nnamespace C {\nnamespace D { int i; }\ninline namespace E { namespace { int y; } }\nint x=     0;}");
    std.string Expected = new std.string(JD$T$C$P_T2$C$R.INSTANCE, /*KEEP_STR*/"\n\nnamespace C {\nnamespace D { int i; }\n\nint x=     0;}");
    Replaces = $c$.clean(/*{ */new std.setType<Replacement>(JD$Initializer_list$_Key_T1$C$R_T2$C$R.INSTANCE, $c$.track(new /*const*/ Replacement [/*2*/] {
          $c$.track(createReplacement(getOffset(new StringRef(Code), 3, 3), 6, new StringRef(/*KEEP_STR*/$EMPTY))), 
          $c$.track(createReplacement(getOffset(new StringRef(Code), 9, 34), 6, new StringRef(/*KEEP_STR*/$EMPTY)))}))/* }*/);
    EXPECT_EQ(Expected,$c$.clean(formatAndApply(new StringRef(Code), $c$.track(new std.setType<Replacement>(Replaces)))));
  } finally {
    if (Replaces != null) { Replaces.$destroy(); }
    $c$.$destroy();
  }
}

;
@Test
//<editor-fold defaultstate="collapsed" desc="clang::format::(anonymous namespace)::CleanUpReplacementsTest_NoExistingIncludeWithoutDefine_Test::TestBody">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/unittests/Format/CleanupTest.cpp", line = 314,
 FQN="clang::format::(anonymous namespace)::CleanUpReplacementsTest_NoExistingIncludeWithoutDefine_Test::TestBody", NM="_ZN5clang6format12_GLOBAL__N_159CleanUpReplacementsTest_NoExistingIncludeWithoutDefine_Test8TestBodyEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Format/CleanupTest.cpp -nm=_ZN5clang6format12_GLOBAL__N_159CleanUpReplacementsTest_NoExistingIncludeWithoutDefine_Test8TestBodyEv")
//</editor-fold>
public void test_NoExistingIncludeWithoutDefine() {
  if (markAsSkippedIfNeed(TestState.Successful)) { return; }
  std.setType<Replacement> Replaces = null;
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    std.string Code = new std.string(JD$T$C$P_T2$C$R.INSTANCE, /*KEEP_STR*/"int main() {}");
    std.string Expected = new std.string(JD$T$C$P_T2$C$R.INSTANCE, /*KEEP_STR*/"#include \"a.h\"\nint main() {}");
    Replaces = $c$.clean(/*{ */new std.setType<Replacement>(JD$Initializer_list$_Key_T1$C$R_T2$C$R.INSTANCE, $c$.track(new /*const*/ Replacement [/*1*/] {$c$.track(createInsertion(new StringRef(/*KEEP_STR*/"#include \"a.h\"")))}))/* }*/);
    EXPECT_EQ(Expected,$c$.clean(apply(new StringRef(Code), $c$.track(new std.setType<Replacement>(Replaces)))));
  } finally {
    if (Replaces != null) { Replaces.$destroy(); }
    $c$.$destroy();
  }
}

;
@Test
//<editor-fold defaultstate="collapsed" desc="clang::format::(anonymous namespace)::CleanUpReplacementsTest_NoExistingIncludeWithDefine_Test::TestBody">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/unittests/Format/CleanupTest.cpp", line = 322,
 FQN="clang::format::(anonymous namespace)::CleanUpReplacementsTest_NoExistingIncludeWithDefine_Test::TestBody", NM="_ZN5clang6format12_GLOBAL__N_156CleanUpReplacementsTest_NoExistingIncludeWithDefine_Test8TestBodyEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Format/CleanupTest.cpp -nm=_ZN5clang6format12_GLOBAL__N_156CleanUpReplacementsTest_NoExistingIncludeWithDefine_Test8TestBodyEv")
//</editor-fold>
public void test_NoExistingIncludeWithDefine() {
  if (markAsSkippedIfNeed(TestState.Successful)) { return; }
  std.setType<Replacement> Replaces = null;
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    std.string Code = new std.string(JD$T$C$P_T2$C$R.INSTANCE, /*KEEP_STR*/"#ifndef A_H\n#define A_H\nclass A {};\n#define MMM 123\n#endif");
    std.string Expected = new std.string(JD$T$C$P_T2$C$R.INSTANCE, /*KEEP_STR*/"#ifndef A_H\n#define A_H\n#include \"b.h\"\nclass A {};\n#define MMM 123\n#endif");
    
    Replaces = $c$.clean(/*{ */new std.setType<Replacement>(JD$Initializer_list$_Key_T1$C$R_T2$C$R.INSTANCE, $c$.track(new /*const*/ Replacement [/*1*/] {$c$.track(createInsertion(new StringRef(/*KEEP_STR*/"#include \"b.h\"")))}))/* }*/);
    EXPECT_EQ(Expected,$c$.clean(apply(new StringRef(Code), $c$.track(new std.setType<Replacement>(Replaces)))));
  } finally {
    if (Replaces != null) { Replaces.$destroy(); }
    $c$.$destroy();
  }
}

;
@Test
//<editor-fold defaultstate="collapsed" desc="clang::format::(anonymous namespace)::CleanUpReplacementsTest_InsertBeforeCategoryWithLowerPriority_Test::TestBody">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/unittests/Format/CleanupTest.cpp", line = 339,
 FQN="clang::format::(anonymous namespace)::CleanUpReplacementsTest_InsertBeforeCategoryWithLowerPriority_Test::TestBody", NM="_ZN5clang6format12_GLOBAL__N_166CleanUpReplacementsTest_InsertBeforeCategoryWithLowerPriority_Test8TestBodyEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Format/CleanupTest.cpp -nm=_ZN5clang6format12_GLOBAL__N_166CleanUpReplacementsTest_InsertBeforeCategoryWithLowerPriority_Test8TestBodyEv")
//</editor-fold>
public void test_InsertBeforeCategoryWithLowerPriority() {
  if (markAsSkippedIfNeed(TestState.Successful)) { return; }
  std.setType<Replacement> Replaces = null;
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    std.string Code = new std.string(JD$T$C$P_T2$C$R.INSTANCE, /*KEEP_STR*/"#ifndef A_H\n#define A_H\n\n\n\n#include <vector>\nclass A {};\n#define MMM 123\n#endif");
    std.string Expected = new std.string(JD$T$C$P_T2$C$R.INSTANCE, /*KEEP_STR*/"#ifndef A_H\n#define A_H\n\n\n\n#include \"a.h\"\n#include <vector>\nclass A {};\n#define MMM 123\n#endif");
    
    Replaces = $c$.clean(/*{ */new std.setType<Replacement>(JD$Initializer_list$_Key_T1$C$R_T2$C$R.INSTANCE, $c$.track(new /*const*/ Replacement [/*1*/] {$c$.track(createInsertion(new StringRef(/*KEEP_STR*/"#include \"a.h\"")))}))/* }*/);
    EXPECT_EQ(Expected,$c$.clean(apply(new StringRef(Code), $c$.track(new std.setType<Replacement>(Replaces)))));
  } finally {
    if (Replaces != null) { Replaces.$destroy(); }
    $c$.$destroy();
  }
}

;
@Test
//<editor-fold defaultstate="collapsed" desc="clang::format::(anonymous namespace)::CleanUpReplacementsTest_InsertAfterMainHeader_Test::TestBody">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/unittests/Format/CleanupTest.cpp", line = 364,
 FQN="clang::format::(anonymous namespace)::CleanUpReplacementsTest_InsertAfterMainHeader_Test::TestBody", NM="_ZN5clang6format12_GLOBAL__N_150CleanUpReplacementsTest_InsertAfterMainHeader_Test8TestBodyEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Format/CleanupTest.cpp -nm=_ZN5clang6format12_GLOBAL__N_150CleanUpReplacementsTest_InsertAfterMainHeader_Test8TestBodyEv")
//</editor-fold>
public void test_InsertAfterMainHeader() {
  if (markAsSkippedIfNeed(TestState.Successful)) { return; }
  std.setType<Replacement> Replaces = null;
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    std.string Code = new std.string(JD$T$C$P_T2$C$R.INSTANCE, /*KEEP_STR*/"#include \"fix.h\"\n\nint main() {}");
    std.string Expected = new std.string(JD$T$C$P_T2$C$R.INSTANCE, /*KEEP_STR*/"#include \"fix.h\"\n#include <a>\n\nint main() {}");
    Replaces = $c$.clean(/*{ */new std.setType<Replacement>(JD$Initializer_list$_Key_T1$C$R_T2$C$R.INSTANCE, $c$.track(new /*const*/ Replacement [/*1*/] {$c$.track(createInsertion(new StringRef(/*KEEP_STR*/"#include <a>")))}))/* }*/);
    $c$.clean(Style.$assignMove($c$.track(FormatGlobals.getGoogleStyle(FormatStyle.LanguageKind.LK_Cpp))));
    EXPECT_EQ(Expected,$c$.clean(apply(new StringRef(Code), $c$.track(new std.setType<Replacement>(Replaces)))));
  } finally {
    if (Replaces != null) { Replaces.$destroy(); }
    $c$.$destroy();
  }
}

;
@Test
//<editor-fold defaultstate="collapsed" desc="clang::format::(anonymous namespace)::CleanUpReplacementsTest_InsertBeforeSystemHeaderLLVM_Test::TestBody">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/unittests/Format/CleanupTest.cpp", line = 377,
 FQN="clang::format::(anonymous namespace)::CleanUpReplacementsTest_InsertBeforeSystemHeaderLLVM_Test::TestBody", NM="_ZN5clang6format12_GLOBAL__N_157CleanUpReplacementsTest_InsertBeforeSystemHeaderLLVM_Test8TestBodyEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Format/CleanupTest.cpp -nm=_ZN5clang6format12_GLOBAL__N_157CleanUpReplacementsTest_InsertBeforeSystemHeaderLLVM_Test8TestBodyEv")
//</editor-fold>
public void test_InsertBeforeSystemHeaderLLVM() {
  if (markAsSkippedIfNeed(TestState.Successful)) { return; }
  std.setType<Replacement> Replaces = null;
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    std.string Code = new std.string(JD$T$C$P_T2$C$R.INSTANCE, /*KEEP_STR*/"#include <memory>\n\nint main() {}");
    std.string Expected = new std.string(JD$T$C$P_T2$C$R.INSTANCE, /*KEEP_STR*/"#include \"z.h\"\n#include <memory>\n\nint main() {}");
    Replaces = $c$.clean(/*{ */new std.setType<Replacement>(JD$Initializer_list$_Key_T1$C$R_T2$C$R.INSTANCE, $c$.track(new /*const*/ Replacement [/*1*/] {$c$.track(createInsertion(new StringRef(/*KEEP_STR*/"#include \"z.h\"")))}))/* }*/);
    EXPECT_EQ(Expected,$c$.clean(apply(new StringRef(Code), $c$.track(new std.setType<Replacement>(Replaces)))));
  } finally {
    if (Replaces != null) { Replaces.$destroy(); }
    $c$.$destroy();
  }
}

;
@Test
//<editor-fold defaultstate="collapsed" desc="clang::format::(anonymous namespace)::CleanUpReplacementsTest_InsertAfterSystemHeaderGoogle_Test::TestBody">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/unittests/Format/CleanupTest.cpp", line = 389,
 FQN="clang::format::(anonymous namespace)::CleanUpReplacementsTest_InsertAfterSystemHeaderGoogle_Test::TestBody", NM="_ZN5clang6format12_GLOBAL__N_158CleanUpReplacementsTest_InsertAfterSystemHeaderGoogle_Test8TestBodyEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Format/CleanupTest.cpp -nm=_ZN5clang6format12_GLOBAL__N_158CleanUpReplacementsTest_InsertAfterSystemHeaderGoogle_Test8TestBodyEv")
//</editor-fold>
public void test_InsertAfterSystemHeaderGoogle() {
  if (markAsSkippedIfNeed(TestState.Successful)) { return; }
  std.setType<Replacement> Replaces = null;
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    std.string Code = new std.string(JD$T$C$P_T2$C$R.INSTANCE, /*KEEP_STR*/"#include <memory>\n\nint main() {}");
    std.string Expected = new std.string(JD$T$C$P_T2$C$R.INSTANCE, /*KEEP_STR*/"#include <memory>\n#include \"z.h\"\n\nint main() {}");
    Replaces = $c$.clean(/*{ */new std.setType<Replacement>(JD$Initializer_list$_Key_T1$C$R_T2$C$R.INSTANCE, $c$.track(new /*const*/ Replacement [/*1*/] {$c$.track(createInsertion(new StringRef(/*KEEP_STR*/"#include \"z.h\"")))}))/* }*/);
    $c$.clean(Style.$assignMove($c$.track(FormatGlobals.getGoogleStyle(FormatStyle.LanguageKind.LK_Cpp))));
    EXPECT_EQ(Expected,$c$.clean(apply(new StringRef(Code), $c$.track(new std.setType<Replacement>(Replaces)))));
  } finally {
    if (Replaces != null) { Replaces.$destroy(); }
    $c$.$destroy();
  }
}

;
@Test
//<editor-fold defaultstate="collapsed" desc="clang::format::(anonymous namespace)::CleanUpReplacementsTest_InsertOneIncludeLLVMStyle_Test::TestBody">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/unittests/Format/CleanupTest.cpp", line = 402,
 FQN="clang::format::(anonymous namespace)::CleanUpReplacementsTest_InsertOneIncludeLLVMStyle_Test::TestBody", NM="_ZN5clang6format12_GLOBAL__N_154CleanUpReplacementsTest_InsertOneIncludeLLVMStyle_Test8TestBodyEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Format/CleanupTest.cpp -nm=_ZN5clang6format12_GLOBAL__N_154CleanUpReplacementsTest_InsertOneIncludeLLVMStyle_Test8TestBodyEv")
//</editor-fold>
public void test_InsertOneIncludeLLVMStyle() {
  if (markAsSkippedIfNeed(TestState.Successful)) { return; }
  std.setType<Replacement> Replaces = null;
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    std.string Code = new std.string(JD$T$C$P_T2$C$R.INSTANCE, /*KEEP_STR*/"#include \"x/fix.h\"\n#include \"a.h\"\n#include \"b.h\"\n#include \"clang/Format/Format.h\"\n#include <memory>\n");
    std.string Expected = new std.string(JD$T$C$P_T2$C$R.INSTANCE, /*KEEP_STR*/"#include \"x/fix.h\"\n#include \"a.h\"\n#include \"b.h\"\n#include \"d.h\"\n#include \"clang/Format/Format.h\"\n#include \"llvm/x/y.h\"\n#include <memory>\n");
    Replaces = $c$.clean(/*{ */new std.setType<Replacement>(JD$Initializer_list$_Key_T1$C$R_T2$C$R.INSTANCE, $c$.track(new /*const*/ Replacement [/*2*/] {
          $c$.track(createInsertion(new StringRef(/*KEEP_STR*/"#include \"d.h\""))), 
          $c$.track(createInsertion(new StringRef(/*KEEP_STR*/"#include \"llvm/x/y.h\"")))}))/* }*/);
    EXPECT_EQ(Expected,$c$.clean(apply(new StringRef(Code), $c$.track(new std.setType<Replacement>(Replaces)))));
  } finally {
    if (Replaces != null) { Replaces.$destroy(); }
    $c$.$destroy();
  }
}

;
@Test
//<editor-fold defaultstate="collapsed" desc="clang::format::(anonymous namespace)::CleanUpReplacementsTest_InsertMultipleIncludesLLVMStyle_Test::TestBody">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/unittests/Format/CleanupTest.cpp", line = 420,
 FQN="clang::format::(anonymous namespace)::CleanUpReplacementsTest_InsertMultipleIncludesLLVMStyle_Test::TestBody", NM="_ZN5clang6format12_GLOBAL__N_160CleanUpReplacementsTest_InsertMultipleIncludesLLVMStyle_Test8TestBodyEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Format/CleanupTest.cpp -nm=_ZN5clang6format12_GLOBAL__N_160CleanUpReplacementsTest_InsertMultipleIncludesLLVMStyle_Test8TestBodyEv")
//</editor-fold>
public void test_InsertMultipleIncludesLLVMStyle() {
  if (markAsSkippedIfNeed(TestState.Successful)) { return; }
  std.setType<Replacement> Replaces = null;
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    std.string Code = new std.string(JD$T$C$P_T2$C$R.INSTANCE, /*KEEP_STR*/"#include \"x/fix.h\"\n#include \"a.h\"\n#include \"b.h\"\n#include \"clang/Format/Format.h\"\n#include <memory>\n");
    std.string Expected = new std.string(JD$T$C$P_T2$C$R.INSTANCE, /*KEEP_STR*/"#include \"x/fix.h\"\n#include \"a.h\"\n#include \"b.h\"\n#include \"new/new.h\"\n#include \"clang/Format/Format.h\"\n#include <memory>\n#include <list>\n");
    Replaces = $c$.clean(/*{ */new std.setType<Replacement>(JD$Initializer_list$_Key_T1$C$R_T2$C$R.INSTANCE, $c$.track(new /*const*/ Replacement [/*2*/] {
          $c$.track(createInsertion(new StringRef(/*KEEP_STR*/"#include <list>"))), 
          $c$.track(createInsertion(new StringRef(/*KEEP_STR*/"#include \"new/new.h\"")))}))/* }*/);
    EXPECT_EQ(Expected,$c$.clean(apply(new StringRef(Code), $c$.track(new std.setType<Replacement>(Replaces)))));
  } finally {
    if (Replaces != null) { Replaces.$destroy(); }
    $c$.$destroy();
  }
}

;
@Test
//<editor-fold defaultstate="collapsed" desc="clang::format::(anonymous namespace)::CleanUpReplacementsTest_InsertNewSystemIncludeGoogleStyle_Test::TestBody">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/unittests/Format/CleanupTest.cpp", line = 438,
 FQN="clang::format::(anonymous namespace)::CleanUpReplacementsTest_InsertNewSystemIncludeGoogleStyle_Test::TestBody", NM="_ZN5clang6format12_GLOBAL__N_162CleanUpReplacementsTest_InsertNewSystemIncludeGoogleStyle_Test8TestBodyEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Format/CleanupTest.cpp -nm=_ZN5clang6format12_GLOBAL__N_162CleanUpReplacementsTest_InsertNewSystemIncludeGoogleStyle_Test8TestBodyEv")
//</editor-fold>
public void test_InsertNewSystemIncludeGoogleStyle() {
  if (markAsSkippedIfNeed(TestState.Successful)) { return; }
  std.setType<Replacement> Replaces = null;
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    std.string Code = new std.string(JD$T$C$P_T2$C$R.INSTANCE, /*KEEP_STR*/"#include \"x/fix.h\"\n\n#include \"y/a.h\"\n#include \"z/b.h\"\n");
    // FIXME: inserting after the empty line following the main header might be
    // prefered.
    std.string Expected = new std.string(JD$T$C$P_T2$C$R.INSTANCE, /*KEEP_STR*/"#include \"x/fix.h\"\n#include <vector>\n\n#include \"y/a.h\"\n#include \"z/b.h\"\n");
    Replaces = $c$.clean(/*{ */new std.setType<Replacement>(JD$Initializer_list$_Key_T1$C$R_T2$C$R.INSTANCE, $c$.track(new /*const*/ Replacement [/*1*/] {$c$.track(createInsertion(new StringRef(/*KEEP_STR*/"#include <vector>")))}))/* }*/);
    $c$.clean(Style.$assignMove($c$.track(FormatGlobals.getGoogleStyle(FormatStyle.LanguageKind.LK_Cpp))));
    EXPECT_EQ(Expected,$c$.clean(apply(new StringRef(Code), $c$.track(new std.setType<Replacement>(Replaces)))));
  } finally {
    if (Replaces != null) { Replaces.$destroy(); }
    $c$.$destroy();
  }
}

;
@Test
//<editor-fold defaultstate="collapsed" desc="clang::format::(anonymous namespace)::CleanUpReplacementsTest_InsertMultipleIncludesGoogleStyle_Test::TestBody">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/unittests/Format/CleanupTest.cpp", line = 455,
 FQN="clang::format::(anonymous namespace)::CleanUpReplacementsTest_InsertMultipleIncludesGoogleStyle_Test::TestBody", NM="_ZN5clang6format12_GLOBAL__N_162CleanUpReplacementsTest_InsertMultipleIncludesGoogleStyle_Test8TestBodyEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Format/CleanupTest.cpp -nm=_ZN5clang6format12_GLOBAL__N_162CleanUpReplacementsTest_InsertMultipleIncludesGoogleStyle_Test8TestBodyEv")
//</editor-fold>
public void test_InsertMultipleIncludesGoogleStyle() {
  if (markAsSkippedIfNeed(TestState.Successful)) { return; }
  std.setType<Replacement> Replaces = null;
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    std.string Code = new std.string(JD$T$C$P_T2$C$R.INSTANCE, /*KEEP_STR*/"#include \"x/fix.h\"\n\n#include <vector>\n\n#include \"y/a.h\"\n#include \"z/b.h\"\n");
    std.string Expected = new std.string(JD$T$C$P_T2$C$R.INSTANCE, /*KEEP_STR*/"#include \"x/fix.h\"\n\n#include <vector>\n#include <list>\n\n#include \"y/a.h\"\n#include \"z/b.h\"\n#include \"x/x.h\"\n");
    Replaces = $c$.clean(/*{ */new std.setType<Replacement>(JD$Initializer_list$_Key_T1$C$R_T2$C$R.INSTANCE, $c$.track(new /*const*/ Replacement [/*2*/] {
          $c$.track(createInsertion(new StringRef(/*KEEP_STR*/"#include <list>"))), 
          $c$.track(createInsertion(new StringRef(/*KEEP_STR*/"#include \"x/x.h\"")))}))/* }*/);
    $c$.clean(Style.$assignMove($c$.track(FormatGlobals.getGoogleStyle(FormatStyle.LanguageKind.LK_Cpp))));
    EXPECT_EQ(Expected,$c$.clean(apply(new StringRef(Code), $c$.track(new std.setType<Replacement>(Replaces)))));
  } finally {
    if (Replaces != null) { Replaces.$destroy(); }
    $c$.$destroy();
  }
}

;
@Test
//<editor-fold defaultstate="collapsed" desc="clang::format::(anonymous namespace)::CleanUpReplacementsTest_InsertMultipleNewHeadersAndSortLLVM_Test::TestBody">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/unittests/Format/CleanupTest.cpp", line = 476,
 FQN="clang::format::(anonymous namespace)::CleanUpReplacementsTest_InsertMultipleNewHeadersAndSortLLVM_Test::TestBody", NM="_ZN5clang6format12_GLOBAL__N_164CleanUpReplacementsTest_InsertMultipleNewHeadersAndSortLLVM_Test8TestBodyEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Format/CleanupTest.cpp -nm=_ZN5clang6format12_GLOBAL__N_164CleanUpReplacementsTest_InsertMultipleNewHeadersAndSortLLVM_Test8TestBodyEv")
//</editor-fold>
public void test_InsertMultipleNewHeadersAndSortLLVM() {
  if (markAsSkippedIfNeed(TestState.Successful)) { return; }
  std.setType<Replacement> Replaces = null;
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    std.string Code = new std.string(JD$T$C$P_T2$C$R.INSTANCE, /*KEEP_STR*/"\nint x;");
    std.string Expected = new std.string(JD$T$C$P_T2$C$R.INSTANCE, /*KEEP_STR*/"\n#include \"fix.h\"\n#include \"a.h\"\n#include \"b.h\"\n#include \"c.h\"\n#include <list>\n#include <vector>\nint x;");
    Replaces = $c$.clean(/*{ */new std.setType<Replacement>(JD$Initializer_list$_Key_T1$C$R_T2$C$R.INSTANCE, $c$.track(new /*const*/ Replacement [/*6*/] {
          $c$.track(createInsertion(new StringRef(/*KEEP_STR*/"#include \"a.h\""))), 
          $c$.track(createInsertion(new StringRef(/*KEEP_STR*/"#include \"c.h\""))), 
          $c$.track(createInsertion(new StringRef(/*KEEP_STR*/"#include \"b.h\""))), 
          $c$.track(createInsertion(new StringRef(/*KEEP_STR*/"#include <vector>"))), 
          $c$.track(createInsertion(new StringRef(/*KEEP_STR*/"#include <list>"))), 
          $c$.track(createInsertion(new StringRef(/*KEEP_STR*/"#include \"fix.h\"")))}))/* }*/);
    EXPECT_EQ(Expected,$c$.clean(formatAndApply(new StringRef(Code), $c$.track(new std.setType<Replacement>(Replaces)))));
  } finally {
    if (Replaces != null) { Replaces.$destroy(); }
    $c$.$destroy();
  }
}

;
@Test
//<editor-fold defaultstate="collapsed" desc="clang::format::(anonymous namespace)::CleanUpReplacementsTest_InsertMultipleNewHeadersAndSortGoogle_Test::TestBody">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/unittests/Format/CleanupTest.cpp", line = 494,
 FQN="clang::format::(anonymous namespace)::CleanUpReplacementsTest_InsertMultipleNewHeadersAndSortGoogle_Test::TestBody", NM="_ZN5clang6format12_GLOBAL__N_166CleanUpReplacementsTest_InsertMultipleNewHeadersAndSortGoogle_Test8TestBodyEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Format/CleanupTest.cpp -nm=_ZN5clang6format12_GLOBAL__N_166CleanUpReplacementsTest_InsertMultipleNewHeadersAndSortGoogle_Test8TestBodyEv")
//</editor-fold>
public void test_InsertMultipleNewHeadersAndSortGoogle() {
  if (markAsSkippedIfNeed(TestState.Successful)) { return; }
  std.setType<Replacement> Replaces = null;
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    std.string Code = new std.string(JD$T$C$P_T2$C$R.INSTANCE, /*KEEP_STR*/"\nint x;");
    std.string Expected = new std.string(JD$T$C$P_T2$C$R.INSTANCE, /*KEEP_STR*/"\n#include \"fix.h\"\n#include <list>\n#include <vector>\n#include \"a.h\"\n#include \"b.h\"\n#include \"c.h\"\nint x;");
    Replaces = $c$.clean(/*{ */new std.setType<Replacement>(JD$Initializer_list$_Key_T1$C$R_T2$C$R.INSTANCE, $c$.track(new /*const*/ Replacement [/*6*/] {
          $c$.track(createInsertion(new StringRef(/*KEEP_STR*/"#include \"a.h\""))), 
          $c$.track(createInsertion(new StringRef(/*KEEP_STR*/"#include \"c.h\""))), 
          $c$.track(createInsertion(new StringRef(/*KEEP_STR*/"#include \"b.h\""))), 
          $c$.track(createInsertion(new StringRef(/*KEEP_STR*/"#include <vector>"))), 
          $c$.track(createInsertion(new StringRef(/*KEEP_STR*/"#include <list>"))), 
          $c$.track(createInsertion(new StringRef(/*KEEP_STR*/"#include \"fix.h\"")))}))/* }*/);
    $c$.clean(Style.$assignMove($c$.track(FormatGlobals.getGoogleStyle(FormatStyle.LanguageKind.LK_Cpp))));
    EXPECT_EQ(Expected,$c$.clean(formatAndApply(new StringRef(Code), $c$.track(new std.setType<Replacement>(Replaces)))));
  } finally {
    if (Replaces != null) { Replaces.$destroy(); }
    $c$.$destroy();
  }
}

;
@Test
//<editor-fold defaultstate="collapsed" desc="clang::format::(anonymous namespace)::CleanUpReplacementsTest_FormatCorrectLineWhenHeadersAreInserted_Test::TestBody">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/unittests/Format/CleanupTest.cpp", line = 513,
 FQN="clang::format::(anonymous namespace)::CleanUpReplacementsTest_FormatCorrectLineWhenHeadersAreInserted_Test::TestBody", NM="_ZN5clang6format12_GLOBAL__N_168CleanUpReplacementsTest_FormatCorrectLineWhenHeadersAreInserted_Test8TestBodyEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Format/CleanupTest.cpp -nm=_ZN5clang6format12_GLOBAL__N_168CleanUpReplacementsTest_FormatCorrectLineWhenHeadersAreInserted_Test8TestBodyEv")
//</editor-fold>
public void test_FormatCorrectLineWhenHeadersAreInserted() {
  if (markAsSkippedIfNeed(TestState.Successful)) { return; }
  std.setType<Replacement> Replaces = null;
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    std.string Code = new std.string(JD$T$C$P_T2$C$R.INSTANCE, /*KEEP_STR*/
                      "\n"
                    + "int x;\n"
                    + "int    a;\n"
                    + "int    a;\n"
                    + "int    a;");
    
    std.string Expected = new std.string(JD$T$C$P_T2$C$R.INSTANCE, /*KEEP_STR*/
                      "\n"
                    + "#include \"x.h\"\n"
                    + "#include \"y.h\"\n"
                    + "#include \"clang/x/x.h\"\n"
                    + "#include <list>\n"
                    + "#include <vector>\n"
                    + "int x;\n"
                    + "int    a;\n"
                    + "int b;\n"
                    + "int    a;");
    Replaces = $c$.clean(/*{ */new std.setType<Replacement>(JD$Initializer_list$_Key_T1$C$R_T2$C$R.INSTANCE, $c$.track(new /*const*/ Replacement [/*6*/] {
          $c$.track(createReplacement(getOffset(new StringRef(Code), 4, 8), 1, new StringRef(/*KEEP_STR*/$b))), 
          $c$.track(createInsertion(new StringRef(/*KEEP_STR*/"#include <vector>"))), 
          $c$.track(createInsertion(new StringRef(/*KEEP_STR*/"#include <list>"))), 
          $c$.track(createInsertion(new StringRef(/*KEEP_STR*/"#include \"clang/x/x.h\""))), 
          $c$.track(createInsertion(new StringRef(/*KEEP_STR*/"#include \"y.h\""))), 
          $c$.track(createInsertion(new StringRef(/*KEEP_STR*/"#include \"x.h\"")))}))/* }*/);
    EXPECT_EQ(Expected,$c$.clean(formatAndApply(new StringRef(Code), $c$.track(new std.setType<Replacement>(Replaces)))));
  } finally {
    if (Replaces != null) { Replaces.$destroy(); }
    $c$.$destroy();
  }
}

;
@Test
//<editor-fold defaultstate="collapsed" desc="clang::format::(anonymous namespace)::CleanUpReplacementsTest_NotConfusedByDefine_Test::TestBody">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/unittests/Format/CleanupTest.cpp", line = 539,
 FQN="clang::format::(anonymous namespace)::CleanUpReplacementsTest_NotConfusedByDefine_Test::TestBody", NM="_ZN5clang6format12_GLOBAL__N_148CleanUpReplacementsTest_NotConfusedByDefine_Test8TestBodyEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Format/CleanupTest.cpp -nm=_ZN5clang6format12_GLOBAL__N_148CleanUpReplacementsTest_NotConfusedByDefine_Test8TestBodyEv")
//</editor-fold>
public void test_NotConfusedByDefine() {
  if (markAsSkippedIfNeed(TestState.Successful)) { return; }
  std.setType<Replacement> Replaces = null;
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    std.string Code = new std.string(JD$T$C$P_T2$C$R.INSTANCE, /*KEEP_STR*/"void f() {}\n#define A \\\n  int i;");
    std.string Expected = new std.string(JD$T$C$P_T2$C$R.INSTANCE, /*KEEP_STR*/"#include <vector>\nvoid f() {}\n#define A \\\n  int i;");
    Replaces = $c$.clean(/*{ */new std.setType<Replacement>(JD$Initializer_list$_Key_T1$C$R_T2$C$R.INSTANCE, $c$.track(new /*const*/ Replacement [/*1*/] {$c$.track(createInsertion(new StringRef(/*KEEP_STR*/"#include <vector>")))}))/* }*/);
    EXPECT_EQ(Expected,$c$.clean(formatAndApply(new StringRef(Code), $c$.track(new std.setType<Replacement>(Replaces)))));
  } finally {
    if (Replaces != null) { Replaces.$destroy(); }
    $c$.$destroy();
  }
}

;
@Test
//<editor-fold defaultstate="collapsed" desc="clang::format::(anonymous namespace)::CleanUpReplacementsTest_SkippedTopComment_Test::TestBody">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/unittests/Format/CleanupTest.cpp", line = 551,
 FQN="clang::format::(anonymous namespace)::CleanUpReplacementsTest_SkippedTopComment_Test::TestBody", NM="_ZN5clang6format12_GLOBAL__N_146CleanUpReplacementsTest_SkippedTopComment_Test8TestBodyEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Format/CleanupTest.cpp -nm=_ZN5clang6format12_GLOBAL__N_146CleanUpReplacementsTest_SkippedTopComment_Test8TestBodyEv")
//</editor-fold>
public void test_SkippedTopComment() {
  if (markAsSkippedIfNeed(TestState.Successful)) { return; }
  std.setType<Replacement> Replaces = null;
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    std.string Code = new std.string(JD$T$C$P_T2$C$R.INSTANCE, /*KEEP_STR*/"// comment\n\n   // comment\n");
    std.string Expected = new std.string(JD$T$C$P_T2$C$R.INSTANCE, /*KEEP_STR*/"// comment\n\n   // comment\n#include <vector>\n");
    Replaces = $c$.clean(/*{ */new std.setType<Replacement>(JD$Initializer_list$_Key_T1$C$R_T2$C$R.INSTANCE, $c$.track(new /*const*/ Replacement [/*1*/] {$c$.track(createInsertion(new StringRef(/*KEEP_STR*/"#include <vector>")))}))/* }*/);
    EXPECT_EQ(Expected,$c$.clean(apply(new StringRef(Code), $c$.track(new std.setType<Replacement>(Replaces)))));
  } finally {
    if (Replaces != null) { Replaces.$destroy(); }
    $c$.$destroy();
  }
}

;
@Test
//<editor-fold defaultstate="collapsed" desc="clang::format::(anonymous namespace)::CleanUpReplacementsTest_SkippedMixedComments_Test::TestBody">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/unittests/Format/CleanupTest.cpp", line = 563,
 FQN="clang::format::(anonymous namespace)::CleanUpReplacementsTest_SkippedMixedComments_Test::TestBody", NM="_ZN5clang6format12_GLOBAL__N_149CleanUpReplacementsTest_SkippedMixedComments_Test8TestBodyEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Format/CleanupTest.cpp -nm=_ZN5clang6format12_GLOBAL__N_149CleanUpReplacementsTest_SkippedMixedComments_Test8TestBodyEv")
//</editor-fold>
public void test_SkippedMixedComments() {
  if (markAsSkippedIfNeed(TestState.Successful)) { return; }
  std.setType<Replacement> Replaces = null;
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    std.string Code = new std.string(JD$T$C$P_T2$C$R.INSTANCE, /*KEEP_STR*/"// comment\n// comment \\\n comment continued\n/*\n* comment\n*/\n");
    std.string Expected = new std.string(JD$T$C$P_T2$C$R.INSTANCE, /*KEEP_STR*/"// comment\n// comment \\\n comment continued\n/*\n* comment\n*/\n#include <vector>\n");
    Replaces = $c$.clean(/*{ */new std.setType<Replacement>(JD$Initializer_list$_Key_T1$C$R_T2$C$R.INSTANCE, $c$.track(new /*const*/ Replacement [/*1*/] {$c$.track(createInsertion(new StringRef(/*KEEP_STR*/"#include <vector>")))}))/* }*/);
    EXPECT_EQ(Expected,$c$.clean(apply(new StringRef(Code), $c$.track(new std.setType<Replacement>(Replaces)))));
  } finally {
    if (Replaces != null) { Replaces.$destroy(); }
    $c$.$destroy();
  }
}

;
@Test
//<editor-fold defaultstate="collapsed" desc="clang::format::(anonymous namespace)::CleanUpReplacementsTest_MultipleBlockCommentsInOneLine_Test::TestBody">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/unittests/Format/CleanupTest.cpp", line = 581,
 FQN="clang::format::(anonymous namespace)::CleanUpReplacementsTest_MultipleBlockCommentsInOneLine_Test::TestBody", NM="_ZN5clang6format12_GLOBAL__N_159CleanUpReplacementsTest_MultipleBlockCommentsInOneLine_Test8TestBodyEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Format/CleanupTest.cpp -nm=_ZN5clang6format12_GLOBAL__N_159CleanUpReplacementsTest_MultipleBlockCommentsInOneLine_Test8TestBodyEv")
//</editor-fold>
public void test_MultipleBlockCommentsInOneLine() {
  if (markAsSkippedIfNeed(TestState.Successful)) { return; }
  std.setType<Replacement> Replaces = null;
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    std.string Code = new std.string(JD$T$C$P_T2$C$R.INSTANCE, /*KEEP_STR*/"/*\n* comment\n*/ /* comment\n*/\n\n\n/* c1 */ /*c2 */\n");
    std.string Expected = new std.string(JD$T$C$P_T2$C$R.INSTANCE, /*KEEP_STR*/"/*\n* comment\n*/ /* comment\n*/\n\n\n/* c1 */ /*c2 */\n#include <vector>\n");
    Replaces = $c$.clean(/*{ */new std.setType<Replacement>(JD$Initializer_list$_Key_T1$C$R_T2$C$R.INSTANCE, $c$.track(new /*const*/ Replacement [/*1*/] {$c$.track(createInsertion(new StringRef(/*KEEP_STR*/"#include <vector>")))}))/* }*/);
    EXPECT_EQ(Expected,$c$.clean(apply(new StringRef(Code), $c$.track(new std.setType<Replacement>(Replaces)))));
  } finally {
    if (Replaces != null) { Replaces.$destroy(); }
    $c$.$destroy();
  }
}

;
@Test
//<editor-fold defaultstate="collapsed" desc="clang::format::(anonymous namespace)::CleanUpReplacementsTest_CodeAfterComments_Test::TestBody">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/unittests/Format/CleanupTest.cpp", line = 599,
 FQN="clang::format::(anonymous namespace)::CleanUpReplacementsTest_CodeAfterComments_Test::TestBody", NM="_ZN5clang6format12_GLOBAL__N_146CleanUpReplacementsTest_CodeAfterComments_Test8TestBodyEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Format/CleanupTest.cpp -nm=_ZN5clang6format12_GLOBAL__N_146CleanUpReplacementsTest_CodeAfterComments_Test8TestBodyEv")
//</editor-fold>
public void test_CodeAfterComments() {
  if (markAsSkippedIfNeed(TestState.Successful)) { return; }
  std.setType<Replacement> Replaces = null;
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    std.string Code = new std.string(JD$T$C$P_T2$C$R.INSTANCE, /*KEEP_STR*/"/*\n* comment\n*/ /* comment\n*/\n\n\n/* c1 */ /*c2 */\n\nint x;\n");
    std.string Expected = new std.string(JD$T$C$P_T2$C$R.INSTANCE, /*KEEP_STR*/"/*\n* comment\n*/ /* comment\n*/\n\n\n/* c1 */ /*c2 */\n\n#include <vector>\nint x;\n");
    Replaces = $c$.clean(/*{ */new std.setType<Replacement>(JD$Initializer_list$_Key_T1$C$R_T2$C$R.INSTANCE, $c$.track(new /*const*/ Replacement [/*1*/] {$c$.track(createInsertion(new StringRef(/*KEEP_STR*/"#include <vector>")))}))/* }*/);
    EXPECT_EQ(Expected, $c$.clean(apply(new StringRef(Code), $c$.track(new std.setType<Replacement>(Replaces)))));
  } finally {
    if (Replaces != null) { Replaces.$destroy(); }
    $c$.$destroy();
  }
}

;
@Test
//<editor-fold defaultstate="collapsed" desc="clang::format::(anonymous namespace)::CleanUpReplacementsTest_FakeHeaderGuardIfDef_Test::TestBody">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/unittests/Format/CleanupTest.cpp", line = 621,
 FQN="clang::format::(anonymous namespace)::CleanUpReplacementsTest_FakeHeaderGuardIfDef_Test::TestBody", NM="_ZN5clang6format12_GLOBAL__N_149CleanUpReplacementsTest_FakeHeaderGuardIfDef_Test8TestBodyEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Format/CleanupTest.cpp -nm=_ZN5clang6format12_GLOBAL__N_149CleanUpReplacementsTest_FakeHeaderGuardIfDef_Test8TestBodyEv")
//</editor-fold>
public void test_FakeHeaderGuardIfDef() {
  if (markAsSkippedIfNeed(TestState.Successful)) { return; }
  std.setType<Replacement> Replaces = null;
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    std.string Code = new std.string(JD$T$C$P_T2$C$R.INSTANCE, /*KEEP_STR*/"// comment \n#ifdef X\n#define X\n");
    std.string Expected = new std.string(JD$T$C$P_T2$C$R.INSTANCE, /*KEEP_STR*/"// comment \n#include <vector>\n#ifdef X\n#define X\n");
    Replaces = $c$.clean(/*{ */new std.setType<Replacement>(JD$Initializer_list$_Key_T1$C$R_T2$C$R.INSTANCE, $c$.track(new /*const*/ Replacement [/*1*/] {$c$.track(createInsertion(new StringRef(/*KEEP_STR*/"#include <vector>")))}))/* }*/);
    EXPECT_EQ(Expected,$c$.clean(apply(new StringRef(Code), $c$.track(new std.setType<Replacement>(Replaces)))));
  } finally {
    if (Replaces != null) { Replaces.$destroy(); }
    $c$.$destroy();
  }
}

;
@Test
//<editor-fold defaultstate="collapsed" desc="clang::format::(anonymous namespace)::CleanUpReplacementsTest_RealHeaderGuardAfterComments_Test::TestBody">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/unittests/Format/CleanupTest.cpp", line = 633,
 FQN="clang::format::(anonymous namespace)::CleanUpReplacementsTest_RealHeaderGuardAfterComments_Test::TestBody", NM="_ZN5clang6format12_GLOBAL__N_157CleanUpReplacementsTest_RealHeaderGuardAfterComments_Test8TestBodyEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Format/CleanupTest.cpp -nm=_ZN5clang6format12_GLOBAL__N_157CleanUpReplacementsTest_RealHeaderGuardAfterComments_Test8TestBodyEv")
//</editor-fold>
public void test_RealHeaderGuardAfterComments() {
  if (markAsSkippedIfNeed(TestState.Successful)) { return; }
  std.setType<Replacement> Replaces = null;
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    std.string Code = new std.string(JD$T$C$P_T2$C$R.INSTANCE, /*KEEP_STR*/"// comment \n#ifndef X\n#define X\nint x;\n#define Y 1\n");
    std.string Expected = new std.string(JD$T$C$P_T2$C$R.INSTANCE, /*KEEP_STR*/"// comment \n#ifndef X\n#define X\n#include <vector>\nint x;\n#define Y 1\n");
    Replaces = $c$.clean(/*{ */new std.setType<Replacement>(JD$Initializer_list$_Key_T1$C$R_T2$C$R.INSTANCE, $c$.track(new /*const*/ Replacement [/*1*/] {$c$.track(createInsertion(new StringRef(/*KEEP_STR*/"#include <vector>")))}))/* }*/);
    EXPECT_EQ(Expected,$c$.clean(apply(new StringRef(Code), $c$.track(new std.setType<Replacement>(Replaces)))));
  } finally {
    if (Replaces != null) { Replaces.$destroy(); }
    $c$.$destroy();
  }
}

;
@Test
//<editor-fold defaultstate="collapsed" desc="clang::format::(anonymous namespace)::CleanUpReplacementsTest_IfNDefWithNoDefine_Test::TestBody">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/unittests/Format/CleanupTest.cpp", line = 649,
 FQN="clang::format::(anonymous namespace)::CleanUpReplacementsTest_IfNDefWithNoDefine_Test::TestBody", NM="_ZN5clang6format12_GLOBAL__N_147CleanUpReplacementsTest_IfNDefWithNoDefine_Test8TestBodyEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Format/CleanupTest.cpp -nm=_ZN5clang6format12_GLOBAL__N_147CleanUpReplacementsTest_IfNDefWithNoDefine_Test8TestBodyEv")
//</editor-fold>
public void test_IfNDefWithNoDefine() {
  if (markAsSkippedIfNeed(TestState.Successful)) { return; }
  std.setType<Replacement> Replaces = null;
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    std.string Code = new std.string(JD$T$C$P_T2$C$R.INSTANCE, /*KEEP_STR*/"// comment \n#ifndef X\nint x;\n#define Y 1\n");
    std.string Expected = new std.string(JD$T$C$P_T2$C$R.INSTANCE, /*KEEP_STR*/"// comment \n#include <vector>\n#ifndef X\nint x;\n#define Y 1\n");
    Replaces = $c$.clean(/*{ */new std.setType<Replacement>(JD$Initializer_list$_Key_T1$C$R_T2$C$R.INSTANCE, $c$.track(new /*const*/ Replacement [/*1*/] {$c$.track(createInsertion(new StringRef(/*KEEP_STR*/"#include <vector>")))}))/* }*/);
    EXPECT_EQ(Expected,$c$.clean(apply(new StringRef(Code), $c$.track(new std.setType<Replacement>(Replaces)))));
  } finally {
    if (Replaces != null) { Replaces.$destroy(); }
    $c$.$destroy();
  }
}

;
@Test
//<editor-fold defaultstate="collapsed" desc="clang::format::(anonymous namespace)::CleanUpReplacementsTest_HeaderGuardWithComment_Test::TestBody">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/unittests/Format/CleanupTest.cpp", line = 663,
 FQN="clang::format::(anonymous namespace)::CleanUpReplacementsTest_HeaderGuardWithComment_Test::TestBody", NM="_ZN5clang6format12_GLOBAL__N_151CleanUpReplacementsTest_HeaderGuardWithComment_Test8TestBodyEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Format/CleanupTest.cpp -nm=_ZN5clang6format12_GLOBAL__N_151CleanUpReplacementsTest_HeaderGuardWithComment_Test8TestBodyEv")
//</editor-fold>
public void test_HeaderGuardWithComment() {
  if (markAsSkippedIfNeed(TestState.Successful)) { return; }
  std.setType<Replacement> Replaces = null;
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    std.string Code = new std.string(JD$T$C$P_T2$C$R.INSTANCE, /*KEEP_STR*/"// comment \n#ifndef X // comment\n// comment\n/* comment\n*/\n/* comment */ #define X\nint x;\n#define Y 1\n");
    std.string Expected = new std.string(JD$T$C$P_T2$C$R.INSTANCE, /*KEEP_STR*/"// comment \n#ifndef X // comment\n// comment\n/* comment\n*/\n/* comment */ #define X\n#include <vector>\nint x;\n#define Y 1\n");
    Replaces = $c$.clean(/*{ */new std.setType<Replacement>(JD$Initializer_list$_Key_T1$C$R_T2$C$R.INSTANCE, $c$.track(new /*const*/ Replacement [/*1*/] {$c$.track(createInsertion(new StringRef(/*KEEP_STR*/"#include <vector>")))}))/* }*/);
    EXPECT_EQ(Expected,$c$.clean(apply(new StringRef(Code), $c$.track(new std.setType<Replacement>(Replaces)))));
  } finally {
    if (Replaces != null) { Replaces.$destroy(); }
    $c$.$destroy();
  }
}

;
@Test
//<editor-fold defaultstate="collapsed" desc="clang::format::(anonymous namespace)::CleanUpReplacementsTest_EmptyCode_Test::TestBody">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/unittests/Format/CleanupTest.cpp", line = 685,
 FQN="clang::format::(anonymous namespace)::CleanUpReplacementsTest_EmptyCode_Test::TestBody", NM="_ZN5clang6format12_GLOBAL__N_138CleanUpReplacementsTest_EmptyCode_Test8TestBodyEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Format/CleanupTest.cpp -nm=_ZN5clang6format12_GLOBAL__N_138CleanUpReplacementsTest_EmptyCode_Test8TestBodyEv")
//</editor-fold>
public void test_EmptyCode() {
  if (markAsSkippedIfNeed(TestState.Successful)) { return; }
  std.setType<Replacement> Replaces = null;
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    std.string Code = new std.string(JD$T$C$P_T2$C$R.INSTANCE, /*KEEP_STR*/$EMPTY);
    std.string Expected = new std.string(JD$T$C$P_T2$C$R.INSTANCE, /*KEEP_STR*/"#include <vector>\n");
    Replaces = $c$.clean(/*{ */new std.setType<Replacement>(JD$Initializer_list$_Key_T1$C$R_T2$C$R.INSTANCE, $c$.track(new /*const*/ Replacement [/*1*/] {$c$.track(createInsertion(new StringRef(/*KEEP_STR*/"#include <vector>")))}))/* }*/);
    EXPECT_EQ(Expected,$c$.clean(apply(new StringRef(Code), $c$.track(new std.setType<Replacement>(Replaces)))));
  } finally {
    if (Replaces != null) { Replaces.$destroy(); }
    $c$.$destroy();
  }
}


// FIXME: although this case does not crash, the insertion is wrong. A '\n'
// should be inserted between the two #includes.
;
@Test
//<editor-fold defaultstate="collapsed" desc="clang::format::(anonymous namespace)::CleanUpReplacementsTest_NoNewLineAtTheEndOfCode_Test::TestBody">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/unittests/Format/CleanupTest.cpp", line = 694,
 FQN="clang::format::(anonymous namespace)::CleanUpReplacementsTest_NoNewLineAtTheEndOfCode_Test::TestBody", NM="_ZN5clang6format12_GLOBAL__N_152CleanUpReplacementsTest_NoNewLineAtTheEndOfCode_Test8TestBodyEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Format/CleanupTest.cpp -nm=_ZN5clang6format12_GLOBAL__N_152CleanUpReplacementsTest_NoNewLineAtTheEndOfCode_Test8TestBodyEv")
//</editor-fold>
public void test_NoNewLineAtTheEndOfCode() {
  if (markAsSkippedIfNeed(TestState.Successful)) { return; }
  std.setType<Replacement> Replaces = null;
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    std.string Code = new std.string(JD$T$C$P_T2$C$R.INSTANCE, /*KEEP_STR*/"#include <map>");
    std.string Expected = new std.string(JD$T$C$P_T2$C$R.INSTANCE, /*KEEP_STR*/"#include <map>#include <vector>\n");
    Replaces = $c$.clean(/*{ */new std.setType<Replacement>(JD$Initializer_list$_Key_T1$C$R_T2$C$R.INSTANCE, $c$.track(new /*const*/ Replacement [/*1*/] {$c$.track(createInsertion(new StringRef(/*KEEP_STR*/"#include <vector>")))}))/* }*/);
    EXPECT_EQ(Expected,$c$.clean(apply(new StringRef(Code), $c$.track(new std.setType<Replacement>(Replaces)))));
  } finally {
    if (Replaces != null) { Replaces.$destroy(); }
    $c$.$destroy();
  }
}

;
@Test
//<editor-fold defaultstate="collapsed" desc="clang::format::(anonymous namespace)::CleanUpReplacementsTest_SkipExistingHeaders_Test::TestBody">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/unittests/Format/CleanupTest.cpp", line = 701,
 FQN="clang::format::(anonymous namespace)::CleanUpReplacementsTest_SkipExistingHeaders_Test::TestBody", NM="_ZN5clang6format12_GLOBAL__N_148CleanUpReplacementsTest_SkipExistingHeaders_Test8TestBodyEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Format/CleanupTest.cpp -nm=_ZN5clang6format12_GLOBAL__N_148CleanUpReplacementsTest_SkipExistingHeaders_Test8TestBodyEv")
//</editor-fold>
public void test_SkipExistingHeaders() {
  if (markAsSkippedIfNeed(TestState.Successful)) { return; }
  std.setType<Replacement> Replaces = null;
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    std.string Code = new std.string(JD$T$C$P_T2$C$R.INSTANCE, /*KEEP_STR*/"#include \"a.h\"\n#include <vector>\n");
    std.string Expected = new std.string(JD$T$C$P_T2$C$R.INSTANCE, /*KEEP_STR*/"#include \"a.h\"\n#include <vector>\n");
    Replaces = $c$.clean(/*{ */new std.setType<Replacement>(JD$Initializer_list$_Key_T1$C$R_T2$C$R.INSTANCE, $c$.track(new /*const*/ Replacement [/*2*/] {
          $c$.track(createInsertion(new StringRef(/*KEEP_STR*/"#include <vector>"))), 
          $c$.track(createInsertion(new StringRef(/*KEEP_STR*/"#include \"a.h\"")))}))/* }*/);
    EXPECT_EQ(Expected,$c$.clean(apply(new StringRef(Code), $c$.track(new std.setType<Replacement>(Replaces)))));
  } finally {
    if (Replaces != null) { Replaces.$destroy(); }
    $c$.$destroy();
  }
}

;
@Test
//<editor-fold defaultstate="collapsed" desc="clang::format::(anonymous namespace)::CleanUpReplacementsTest_AddIncludesWithDifferentForms_Test::TestBody">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/unittests/Format/CleanupTest.cpp", line = 711,
 FQN="clang::format::(anonymous namespace)::CleanUpReplacementsTest_AddIncludesWithDifferentForms_Test::TestBody", NM="_ZN5clang6format12_GLOBAL__N_158CleanUpReplacementsTest_AddIncludesWithDifferentForms_Test8TestBodyEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Format/CleanupTest.cpp -nm=_ZN5clang6format12_GLOBAL__N_158CleanUpReplacementsTest_AddIncludesWithDifferentForms_Test8TestBodyEv")
//</editor-fold>
public void test_AddIncludesWithDifferentForms() {
  if (markAsSkippedIfNeed(TestState.Successful)) { return; }
  std.setType<Replacement> Replaces = null;
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    std.string Code = new std.string(JD$T$C$P_T2$C$R.INSTANCE, /*KEEP_STR*/"#include \"a.h\"\n#include <vector>\n");
    // FIXME: this might not be the best behavior.
    std.string Expected = new std.string(JD$T$C$P_T2$C$R.INSTANCE, /*KEEP_STR*/"#include \"a.h\"\n#include \"vector\"\n#include <vector>\n#include <a.h>\n");
    Replaces = $c$.clean(/*{ */new std.setType<Replacement>(JD$Initializer_list$_Key_T1$C$R_T2$C$R.INSTANCE, $c$.track(new /*const*/ Replacement [/*2*/] {
          $c$.track(createInsertion(new StringRef(/*KEEP_STR*/"#include \"vector\""))), 
          $c$.track(createInsertion(new StringRef(/*KEEP_STR*/"#include <a.h>")))}))/* }*/);
    EXPECT_EQ(Expected,$c$.clean(apply(new StringRef(Code), $c$.track(new std.setType<Replacement>(Replaces)))));
  } finally {
    if (Replaces != null) { Replaces.$destroy(); }
    $c$.$destroy();
  }
}

//} JAVA: end of namespace (anonymous) // end namespace
//} JAVA: end of namespace format // end namespace format
//} JAVA: end of namespace clang
//<editor-fold defaultstate="collapsed" desc="__builtin_trap">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/unittests/Format/CleanupTest.cpp", line = 51,
 FQN="__builtin_trap", NM="_Z14__builtin_trap",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Format/CleanupTest.cpp -nm=_Z14__builtin_trap")
//</editor-fold>
public static void __builtin_trap()/* __attribute__((nothrow))*/ {
  throw new UnsupportedOperationException("<<<DeclJavaPrinter::VisitFunctionDecl NULL BODY IN USED Translation Unit>>>");
}

} // END OF class CleanupTest
