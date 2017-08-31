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
import static org.clank.support.NativePointer.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.tooling.core.*;
import org.clang.format.*;
import static org.clang.format.FormatGlobals.*;
import static org.clang.tooling.ToolingGlobals.*;
import org.clang.format.FormatTestUtils.test;


//<editor-fold defaultstate="collapsed" desc="static type FormatTestProto">
@Converted(kind = Converted.Kind.AUTO,
 NM="FormatTestProto",
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -print -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTestProto.cpp -test=FormatTestProto")
//</editor-fold>
public final class FormatProtoTest extends ADTSupportTestBase {

//JAVA: namespace clang {
//JAVA: namespace format {

////<editor-fold defaultstate="collapsed" desc="clang::format::FormatTestProto">
//@Converted(kind = Converted.Kind.AUTO,
// source = "${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTestProto.cpp", line = 20,
// FQN="clang::format::FormatTestProto", NM="_ZN5clang6format15FormatTestProtoE",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTestProto.cpp -nm=_ZN5clang6format15FormatTestProtoE")
////</editor-fold>
//public abstract static class FormatTestProto extends /*public*/ Test implements Destructors.ClassWithDestructor {
/*protected:*/
  //<editor-fold defaultstate="collapsed" desc="clang::format::FormatTestProto::format">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTestProto.cpp", line = 22,
   FQN="clang::format::FormatTestProto::format", NM="_ZN5clang6format15FormatTestProto6formatEN4llvm9StringRefEjjRKNS0_11FormatStyleE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTestProto.cpp -nm=_ZN5clang6format15FormatTestProto6formatEN4llvm9StringRefEjjRKNS0_11FormatStyleE")
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

  
  //<editor-fold defaultstate="collapsed" desc="clang::format::FormatTestProto::format">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTestProto.cpp", line = 34,
   FQN="clang::format::FormatTestProto::format", NM="_ZN5clang6format15FormatTestProto6formatEN4llvm9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTestProto.cpp -nm=_ZN5clang6format15FormatTestProto6formatEN4llvm9StringRefE")
  //</editor-fold>
  protected static std.string format(StringRef Code) {
    FormatStyle Style = null;
    try {
      Style = getGoogleStyle(FormatStyle.LanguageKind.LK_Proto);
      Style.ColumnLimit = 60; // To make writing tests easier.
      return FormatProtoTest.format(new StringRef(Code), 0, Code.size(), Style);
    } finally {
      if (Style != null) { Style.$destroy(); }
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::format::FormatTestProto::verifyFormat">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTestProto.cpp", line = 40,
   FQN="clang::format::FormatTestProto::verifyFormat", NM="_ZN5clang6format15FormatTestProto12verifyFormatEN4llvm9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTestProto.cpp -nm=_ZN5clang6format15FormatTestProto12verifyFormatEN4llvm9StringRefE")
  //</editor-fold>
  protected static void verifyFormat(StringRef Code) {
      EXPECT_EQ(Code.str(),FormatProtoTest.format(new StringRef(test.messUp(new StringRef(Code)))));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::format::FormatTestProto::~FormatTestProto">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTestProto.cpp", line = 20,
   FQN="clang::format::FormatTestProto::~FormatTestProto", NM="_ZN5clang6format15FormatTestProtoD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTestProto.cpp -nm=_ZN5clang6format15FormatTestProtoD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    super.$destroy();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::format::FormatTestProto::FormatTestProto">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTestProto.cpp", line = 20,
   FQN="clang::format::FormatTestProto::FormatTestProto", NM="_ZN5clang6format15FormatTestProtoC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTestProto.cpp -nm=_ZN5clang6format15FormatTestProtoC1Ev")
  //</editor-fold>
  public /*inline*/ FormatProtoTest() {
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
//<editor-fold defaultstate="collapsed" desc="clang::format::FormatTestProto_FormatsMessages_Test::TestBody">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTestProto.cpp", line = 45,
 FQN="clang::format::FormatTestProto_FormatsMessages_Test::TestBody", NM="_ZN5clang6format36FormatTestProto_FormatsMessages_Test8TestBodyEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTestProto.cpp -nm=_ZN5clang6format36FormatTestProto_FormatsMessages_Test8TestBodyEv")
//</editor-fold>
public void test_FormatsMessages() {
  if (markAsSkippedIfNeed(TestState.Successful)) { return; }
  FormatProtoTest.verifyFormat(new StringRef(/*KEEP_STR*/"message SomeMessage {\n  required int32 field1 = 1;\n}"));
  FormatProtoTest.verifyFormat(new StringRef(/*KEEP_STR*/"message SomeMessage {\n  required .absolute.Reference field1 = 1;\n}"));
  FormatProtoTest.verifyFormat(new StringRef(/*KEEP_STR*/"message SomeMessage {\n  required int32 field1 = 1;\n  optional string field2 = 2 [default = \"2\"]\n}"));
  
  FormatProtoTest.verifyFormat(new StringRef(/*KEEP_STR*/"message SomeMessage {\n  optional really.really.long.qualified.type.aaa.aaaaaaa\n      fiiiiiiiiiiiiiiiiiiiiiiiiield = 1;\n  optional\n      really.really.long.qualified.type.aaa.aaaaaaa.aaaaaaaa\n          another_fiiiiiiiiiiiiiiiiiiiiield = 2;\n}"));
}

;
@Test
//<editor-fold defaultstate="collapsed" desc="clang::format::FormatTestProto_KeywordsInOtherLanguages_Test::TestBody">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTestProto.cpp", line = 66,
 FQN="clang::format::FormatTestProto_KeywordsInOtherLanguages_Test::TestBody", NM="_ZN5clang6format45FormatTestProto_KeywordsInOtherLanguages_Test8TestBodyEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTestProto.cpp -nm=_ZN5clang6format45FormatTestProto_KeywordsInOtherLanguages_Test8TestBodyEv")
//</editor-fold>
public void test_KeywordsInOtherLanguages() {
  if (markAsSkippedIfNeed(TestState.Successful)) { return; }
  FormatProtoTest.verifyFormat(new StringRef(/*KEEP_STR*/"optional string operator = 1;"));
}

;
@Test
//<editor-fold defaultstate="collapsed" desc="clang::format::FormatTestProto_FormatsEnums_Test::TestBody">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTestProto.cpp", line = 70,
 FQN="clang::format::FormatTestProto_FormatsEnums_Test::TestBody", NM="_ZN5clang6format33FormatTestProto_FormatsEnums_Test8TestBodyEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTestProto.cpp -nm=_ZN5clang6format33FormatTestProto_FormatsEnums_Test8TestBodyEv")
//</editor-fold>
public void test_FormatsEnums() {
  if (markAsSkippedIfNeed(TestState.Successful)) { return; }
  FormatProtoTest.verifyFormat(new StringRef(/*KEEP_STR*/"enum Type {\n  UNKNOWN = 0;\n  TYPE_A = 1;\n  TYPE_B = 2;\n};"));
  FormatProtoTest.verifyFormat(new StringRef(/*KEEP_STR*/"enum Type {\n  UNKNOWN = 0 [(some_options) = {a: aa, b: bb}];\n};"));
  FormatProtoTest.verifyFormat(new StringRef(/*KEEP_STR*/"enum Type {\n  UNKNOWN = 0 [(some_options) = {\n    a: aa,  // wrap\n    b: bb\n  }];\n};"));
}

;
@Test
//<editor-fold defaultstate="collapsed" desc="clang::format::FormatTestProto_UnderstandsReturns_Test::TestBody">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTestProto.cpp", line = 87,
 FQN="clang::format::FormatTestProto_UnderstandsReturns_Test::TestBody", NM="_ZN5clang6format39FormatTestProto_UnderstandsReturns_Test8TestBodyEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTestProto.cpp -nm=_ZN5clang6format39FormatTestProto_UnderstandsReturns_Test8TestBodyEv")
//</editor-fold>
public void test_UnderstandsReturns() {
  if (markAsSkippedIfNeed(TestState.Successful)) { return; }
  FormatProtoTest.verifyFormat(new StringRef(/*KEEP_STR*/"rpc Search(SearchRequest) returns (SearchResponse);"));
}

;
@Test
//<editor-fold defaultstate="collapsed" desc="clang::format::FormatTestProto_MessageFieldAttributes_Test::TestBody">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTestProto.cpp", line = 91,
 FQN="clang::format::FormatTestProto_MessageFieldAttributes_Test::TestBody", NM="_ZN5clang6format43FormatTestProto_MessageFieldAttributes_Test8TestBodyEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTestProto.cpp -nm=_ZN5clang6format43FormatTestProto_MessageFieldAttributes_Test8TestBodyEv")
//</editor-fold>
public void test_MessageFieldAttributes() {
  if (markAsSkippedIfNeed(TestState.Successful)) { return; }
  FormatProtoTest.verifyFormat(new StringRef(/*KEEP_STR*/"optional string test = 1 [default = \"test\"];"));
  FormatProtoTest.verifyFormat(new StringRef(/*KEEP_STR*/"optional bool a = 1 [default = true, deprecated = true];"));
  FormatProtoTest.verifyFormat(new StringRef(/*KEEP_STR*/"optional LongMessageType long_proto_field = 1 [\n  default = REALLY_REALLY_LONG_CONSTANT_VALUE,\n  deprecated = true\n];"));
  FormatProtoTest.verifyFormat(new StringRef(/*KEEP_STR*/"optional LongMessageType long_proto_field = 1\n    [default = REALLY_REALLY_LONG_CONSTANT_VALUE];"));
  FormatProtoTest.verifyFormat(new StringRef(/*KEEP_STR*/"repeated double value = 1\n    [(aaaaaaa.aaaaaaaaa) = {aaaaaaaaaaaaaaaaa: AAAAAAAA}];"));
  FormatProtoTest.verifyFormat(new StringRef(/*KEEP_STR*/"repeated double value = 1 [(aaaaaaa.aaaaaaaaa) = {\n  aaaaaaaaaaaaaaaa: AAAAAAAAAA,\n  bbbbbbbbbbbbbbbb: BBBBBBBBBB\n}];"));
  FormatProtoTest.verifyFormat(new StringRef(/*KEEP_STR*/"repeated double value = 1 [(aaaaaaa.aaaaaaaaa) = {\n  aaaaaaaaaaaaaaaa: AAAAAAAAAA\n  bbbbbbbbbbbbbbbb: BBBBBBBBBB\n}];"));
  FormatProtoTest.verifyFormat(new StringRef(/*KEEP_STR*/"repeated double value = 1 [\n  (aaaaaaa.aaaaaaaaa) = {\n    aaaaaaaaaaaaaaaa: AAAAAAAAAA\n    bbbbbbbbbbbbbbbb: BBBBBBBBBB\n  },\n  (bbbbbbb.bbbbbbbbb) = {\n    aaaaaaaaaaaaaaaa: AAAAAAAAAA\n    bbbbbbbbbbbbbbbb: BBBBBBBBBB\n  }\n];"));
  FormatProtoTest.verifyFormat(new StringRef(/*KEEP_STR*/"repeated double value = 1 [(aaaaaaa.aaaaaaaaa) = {\n  type: \"AAAAAAAAAA\"\n  is: \"AAAAAAAAAA\"\n  or: \"BBBBBBBBBB\"\n}];"));
  FormatProtoTest.verifyFormat(new StringRef(/*KEEP_STR*/"repeated double value = 1 [(aaaaaaa.aaaaaaaaa) = {\n  aaaaaaaaaaaaaaaa: AAAAAAAAAA,\n  bbbbbbb: BBBB,\n  bbbb: BBB\n}];"));
  FormatProtoTest.verifyFormat(new StringRef(/*KEEP_STR*/"optional AAA aaa = 1 [\n  foo = {\n    key: 'a'  //\n  },\n  bar = {\n    key: 'a'  //\n  }\n];"));
}

;
@Test
//<editor-fold defaultstate="collapsed" desc="clang::format::FormatTestProto_DoesntWrapFileOptions_Test::TestBody">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTestProto.cpp", line = 140,
 FQN="clang::format::FormatTestProto_DoesntWrapFileOptions_Test::TestBody", NM="_ZN5clang6format42FormatTestProto_DoesntWrapFileOptions_Test8TestBodyEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTestProto.cpp -nm=_ZN5clang6format42FormatTestProto_DoesntWrapFileOptions_Test8TestBodyEv")
//</editor-fold>
public void test_DoesntWrapFileOptions() {
    if (markAsSkippedIfNeed(TestState.Successful)) { return; }
    EXPECT_EQ("option java_package = \"some.really.long.package.that.exceeds.the.column.limit\";",FormatProtoTest.format(new StringRef(/*KEEP_STR*/"option    java_package   =    \"some.really.long.package.that.exceeds.the.column.limit\";")));
}

;
@Test
//<editor-fold defaultstate="collapsed" desc="clang::format::FormatTestProto_FormatsOptions_Test::TestBody">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTestProto.cpp", line = 148,
 FQN="clang::format::FormatTestProto_FormatsOptions_Test::TestBody", NM="_ZN5clang6format35FormatTestProto_FormatsOptions_Test8TestBodyEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTestProto.cpp -nm=_ZN5clang6format35FormatTestProto_FormatsOptions_Test8TestBodyEv")
//</editor-fold>
public void test_FormatsOptions() {
  if (markAsSkippedIfNeed(TestState.Successful)) { return; }
  FormatProtoTest.verifyFormat(new StringRef(/*KEEP_STR*/"option (MyProto.options) = {\n  field_a: OK\n  field_b: \"OK\"\n  field_c: \"OK\"\n  msg_field: {field_d: 123}\n};"));
  FormatProtoTest.verifyFormat(new StringRef(/*KEEP_STR*/"option (MyProto.options) = {\n  field_a: OK\n  field_b: \"OK\"\n  field_c: \"OK\"\n  msg_field: {field_d: 123 field_e: OK}\n};"));
  FormatProtoTest.verifyFormat(new StringRef(/*KEEP_STR*/"option (MyProto.options) = {\n  field_a: OK  // Comment\n  field_b: \"OK\"\n  field_c: \"OK\"\n  msg_field: {field_d: 123}\n};"));
  FormatProtoTest.verifyFormat(new StringRef(/*KEEP_STR*/"option (MyProto.options) = {\n  field_c: \"OK\"\n  msg_field{field_d: 123}\n};"));
  
  // Support syntax with <> instead of {}.
  FormatProtoTest.verifyFormat(new StringRef(/*KEEP_STR*/"option (MyProto.options) = {\n  field_c: \"OK\",\n  msg_field: <field_d: 123>\n};"));
}

;
@Test
//<editor-fold defaultstate="collapsed" desc="clang::format::FormatTestProto_FormatsService_Test::TestBody">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTestProto.cpp", line = 179,
 FQN="clang::format::FormatTestProto_FormatsService_Test::TestBody", NM="_ZN5clang6format35FormatTestProto_FormatsService_Test8TestBodyEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTestProto.cpp -nm=_ZN5clang6format35FormatTestProto_FormatsService_Test8TestBodyEv")
//</editor-fold>
public void test_FormatsService() {
  if (markAsSkippedIfNeed(TestState.Successful)) { return; }
  FormatProtoTest.verifyFormat(new StringRef(/*KEEP_STR*/"service SearchService {\n  rpc Search(SearchRequest) returns (SearchResponse) {\n    option foo = true;\n  }\n};"));
}

;
@Test
//<editor-fold defaultstate="collapsed" desc="clang::format::FormatTestProto_ExtendingMessage_Test::TestBody">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTestProto.cpp", line = 187,
 FQN="clang::format::FormatTestProto_ExtendingMessage_Test::TestBody", NM="_ZN5clang6format37FormatTestProto_ExtendingMessage_Test8TestBodyEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTestProto.cpp -nm=_ZN5clang6format37FormatTestProto_ExtendingMessage_Test8TestBodyEv")
//</editor-fold>
public void test_ExtendingMessage() {
  if (markAsSkippedIfNeed(TestState.Successful)) { return; }
  FormatProtoTest.verifyFormat(new StringRef(/*KEEP_STR*/"extend .foo.Bar {\n}"));
}

;
@Test
//<editor-fold defaultstate="collapsed" desc="clang::format::FormatTestProto_FormatsImports_Test::TestBody">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTestProto.cpp", line = 192,
 FQN="clang::format::FormatTestProto_FormatsImports_Test::TestBody", NM="_ZN5clang6format35FormatTestProto_FormatsImports_Test8TestBodyEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTestProto.cpp -nm=_ZN5clang6format35FormatTestProto_FormatsImports_Test8TestBodyEv")
//</editor-fold>
public void test_FormatsImports() {
  if (markAsSkippedIfNeed(TestState.Successful)) { return; }
  FormatProtoTest.verifyFormat(new StringRef(/*KEEP_STR*/"import \"a.proto\";\nimport \"b.proto\";\n// comment\nmessage A {\n}"));
  
  FormatProtoTest.verifyFormat(new StringRef(/*KEEP_STR*/"import public \"a.proto\";\nimport \"b.proto\";\n// comment\nmessage A {\n}"));
  
  // Missing semicolons should not confuse clang-format.
  FormatProtoTest.verifyFormat(new StringRef(/*KEEP_STR*/"import \"a.proto\"\nimport \"b.proto\"\n// comment\nmessage A {\n}"));
}

//} JAVA: end of namespace format // end namespace tooling
//} JAVA: end of namespace clang
//<editor-fold defaultstate="collapsed" desc="__builtin_trap">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTestProto.cpp", line = 41,
 FQN="__builtin_trap", NM="_Z14__builtin_trap",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Format/FormatTestProto.cpp -nm=_Z14__builtin_trap")
//</editor-fold>
public static void __builtin_trap()/* __attribute__((nothrow))*/ {
  throw new UnsupportedOperationException("<<<DeclJavaPrinter::VisitFunctionDecl NULL BODY IN USED Translation Unit>>>");
}

} // END OF class FormatTestProto
