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
import static org.clank.support.Native.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.tooling.core.*;
import org.clang.format.*;
import static org.clang.format.FormatGlobals.*;
import static org.clang.tooling.ToolingGlobals.*;


//<editor-fold defaultstate="collapsed" desc="static type SortImportsTestJS">
@Converted(kind = Converted.Kind.AUTO,
 NM="SortImportsTestJS",
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -print -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Format/SortImportsTestJS.cpp -test=SortImportsTestJS")
//</editor-fold>
public final class SortImportsJSTest extends ADTSupportTestBase {

//JAVA: namespace clang {
//JAVA: namespace format {
//JAVA: namespace (anonymous) {

////<editor-fold defaultstate="collapsed" desc="clang::format::(anonymous namespace)::SortImportsTestJS">
//@Converted(kind = Converted.Kind.AUTO,
// source = "${LLVM_SRC}/llvm/tools/clang/unittests/Format/SortImportsTestJS.cpp", line = 21,
// FQN="clang::format::(anonymous namespace)::SortImportsTestJS", NM="_ZN5clang6format12_GLOBAL__N_117SortImportsTestJSE",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Format/SortImportsTestJS.cpp -nm=_ZN5clang6format12_GLOBAL__N_117SortImportsTestJSE")
////</editor-fold>
//public abstract static class SortImportsTestJS extends /*public*/ Test implements Destructors.ClassWithDestructor {
/*protected:*/
  //<editor-fold defaultstate="collapsed" desc="clang::format::(anonymous namespace)::SortImportsTestJS::sort">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/unittests/Format/SortImportsTestJS.cpp", line = 23,
   FQN="clang::format::(anonymous namespace)::SortImportsTestJS::sort", NM="_ZN5clang6format12_GLOBAL__N_117SortImportsTestJS4sortEN4llvm9StringRefEjj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Format/SortImportsTestJS.cpp -nm=_ZN5clang6format12_GLOBAL__N_117SortImportsTestJS4sortEN4llvm9StringRefEjj")
  //</editor-fold>
  protected std.string sort(StringRef Code) {
    return sort(Code, 0, 0);
  }
  protected std.string sort(StringRef Code, /*uint*/int Offset/*= 0*/) {
    return sort(Code, Offset, 0);
  }
  protected std.string sort(StringRef Code, /*uint*/int Offset/*= 0*/, /*uint*/int Length/*= 0*/) {
    std.vector<Range> Ranges = null;
    Expected<std.string> Sorted = null;
    Expected<std.string> Formatted = null;
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      StringRef FileName = new StringRef(/*KEEP_STR*/"input.js");
      if (Length == 0/*U*/) {
        Length = Code.size() - Offset;
      }
      Ranges/*J*/= new std.vector<Range>(1, new Range(Offset, Length), new Range());
      Sorted = $c$.clean(applyAllReplacements(new StringRef(Code), $c$.track(sortIncludes(Style, new StringRef(Code), new ArrayRef<Range>(Ranges, false), new StringRef(FileName)))));
      EXPECT_TRUE(((/*static_cast*/boolean)(Sorted.$bool())));
      Formatted = $c$.clean(applyAllReplacements(new StringRef(Sorted.$star()), $c$.track(reformat(Style, new StringRef(Sorted.$star()), new ArrayRef<Range>(Ranges, false), new StringRef(FileName)))));
      EXPECT_TRUE(((/*static_cast*/boolean)(Formatted.$bool())));
      return new std.string(Formatted.$star());
    } finally {
      if (Formatted != null) { Formatted.$destroy(); }
      if (Sorted != null) { Sorted.$destroy(); }
      if (Ranges != null) { Ranges.$destroy(); }
      $c$.$destroy();
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::format::(anonymous namespace)::SortImportsTestJS::verifySort">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/unittests/Format/SortImportsTestJS.cpp", line = 37,
   FQN="clang::format::(anonymous namespace)::SortImportsTestJS::verifySort", NM="_ZN5clang6format12_GLOBAL__N_117SortImportsTestJS10verifySortEN4llvm9StringRefES4_jj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Format/SortImportsTestJS.cpp -nm=_ZN5clang6format12_GLOBAL__N_117SortImportsTestJS10verifySortEN4llvm9StringRefES4_jj")
  //</editor-fold>
  protected void verifySort(StringRef Expected, StringRef Code) {
    verifySort(Expected, Code, 
            0, 0);
  }
  protected void verifySort(StringRef Expected, StringRef Code, 
            /*uint*/int Offset/*= 0*/) {
    verifySort(Expected, Code, 
            Offset, 0);
  }
  protected void verifySort(StringRef Expected, StringRef Code, 
            /*uint*/int Offset/*= 0*/, /*uint*/int Length/*= 0*/) {
    std.string Result = sort(new StringRef(Code), Offset, Length);
      EXPECT_EQ(Expected.str(),Result);
  }

  
  protected FormatStyle Style/* = getGoogleStyle(FormatStyle::LK_JavaScript)*/;
  //<editor-fold defaultstate="collapsed" desc="clang::format::(anonymous namespace)::SortImportsTestJS::~SortImportsTestJS">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/unittests/Format/SortImportsTestJS.cpp", line = 21,
   FQN="clang::format::(anonymous namespace)::SortImportsTestJS::~SortImportsTestJS", NM="_ZN5clang6format12_GLOBAL__N_117SortImportsTestJSD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Format/SortImportsTestJS.cpp -nm=_ZN5clang6format12_GLOBAL__N_117SortImportsTestJSD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    //START JDestroy
    Style.$destroy();
    super.$destroy();
    //END JDestroy
  }

  //<editor-fold defaultstate="collapsed" desc="clang::format::(anonymous namespace)::SortImportsTestJS::SortImportsTestJS">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/unittests/Format/SortImportsTestJS.cpp", line = 21,
   FQN="clang::format::(anonymous namespace)::SortImportsTestJS::SortImportsTestJS", NM="_ZN5clang6format12_GLOBAL__N_117SortImportsTestJSC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Format/SortImportsTestJS.cpp -nm=_ZN5clang6format12_GLOBAL__N_117SortImportsTestJSC1Ev")
  //</editor-fold>
  public /*inline*/ SortImportsJSTest() {
    // : Test(), Style($c$.track(getGoogleStyle(FormatStyle::LK_JavaScript))) 
    //START JInit
    super(TestState.Successful);
    /*InClass*/this.Style = getGoogleStyle(FormatStyle.LanguageKind.LK_JavaScript);
    //END JInit
  }

  
  @Override public String toString() {
    return "" + "Style=" + Style // NOI18N
              + super.toString(); // NOI18N
  }
//}
;
@Test
//<editor-fold defaultstate="collapsed" desc="clang::format::(anonymous namespace)::SortImportsTestJS_AlreadySorted_Test::TestBody">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/unittests/Format/SortImportsTestJS.cpp", line = 48,
 FQN="clang::format::(anonymous namespace)::SortImportsTestJS_AlreadySorted_Test::TestBody", NM="_ZN5clang6format12_GLOBAL__N_136SortImportsTestJS_AlreadySorted_Test8TestBodyEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Format/SortImportsTestJS.cpp -nm=_ZN5clang6format12_GLOBAL__N_136SortImportsTestJS_AlreadySorted_Test8TestBodyEv")
//</editor-fold>
public void test_AlreadySorted() {
  if (markAsSkippedIfNeed(TestState.Successful)) { return; }
  verifySort(new StringRef(/*KEEP_STR*/"import {sym} from 'a';\nimport {sym} from 'b';\nimport {sym} from 'c';\n\nlet x = 1;"), 
      new StringRef(/*KEEP_STR*/"import {sym} from 'a';\nimport {sym} from 'b';\nimport {sym} from 'c';\n\nlet x = 1;"));
}

;
@Test
//<editor-fold defaultstate="collapsed" desc="clang::format::(anonymous namespace)::SortImportsTestJS_BasicSorting_Test::TestBody">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/unittests/Format/SortImportsTestJS.cpp", line = 61,
 FQN="clang::format::(anonymous namespace)::SortImportsTestJS_BasicSorting_Test::TestBody", NM="_ZN5clang6format12_GLOBAL__N_135SortImportsTestJS_BasicSorting_Test8TestBodyEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Format/SortImportsTestJS.cpp -nm=_ZN5clang6format12_GLOBAL__N_135SortImportsTestJS_BasicSorting_Test8TestBodyEv")
//</editor-fold>
public void test_BasicSorting() {
  if (markAsSkippedIfNeed(TestState.Successful)) { return; }
  verifySort(new StringRef(/*KEEP_STR*/"import {sym} from 'a';\nimport {sym} from 'b';\nimport {sym} from 'c';\n\nlet x = 1;"), 
      new StringRef(/*KEEP_STR*/"import {sym} from 'a';\nimport {sym} from 'c';\nimport {sym} from 'b';\nlet x = 1;"));
}

;
@Test
//<editor-fold defaultstate="collapsed" desc="clang::format::(anonymous namespace)::SortImportsTestJS_WrappedImportStatements_Test::TestBody">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/unittests/Format/SortImportsTestJS.cpp", line = 73,
 FQN="clang::format::(anonymous namespace)::SortImportsTestJS_WrappedImportStatements_Test::TestBody", NM="_ZN5clang6format12_GLOBAL__N_146SortImportsTestJS_WrappedImportStatements_Test8TestBodyEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Format/SortImportsTestJS.cpp -nm=_ZN5clang6format12_GLOBAL__N_146SortImportsTestJS_WrappedImportStatements_Test8TestBodyEv")
//</editor-fold>
public void test_WrappedImportStatements() {
  if (markAsSkippedIfNeed(TestState.Successful)) { return; }
  verifySort(new StringRef(/*KEEP_STR*/"import {sym1, sym2} from 'a';\nimport {sym} from 'b';\n\n1;"), 
      new StringRef(/*KEEP_STR*/"import\n  {sym}\n  from 'b';\nimport {\n  sym1,\n  sym2\n} from 'a';\n1;"));
}

;
@Test
//<editor-fold defaultstate="collapsed" desc="clang::format::(anonymous namespace)::SortImportsTestJS_SeparateMainCodeBody_Test::TestBody">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/unittests/Format/SortImportsTestJS.cpp", line = 88,
 FQN="clang::format::(anonymous namespace)::SortImportsTestJS_SeparateMainCodeBody_Test::TestBody", NM="_ZN5clang6format12_GLOBAL__N_143SortImportsTestJS_SeparateMainCodeBody_Test8TestBodyEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Format/SortImportsTestJS.cpp -nm=_ZN5clang6format12_GLOBAL__N_143SortImportsTestJS_SeparateMainCodeBody_Test8TestBodyEv")
//</editor-fold>
public void test_SeparateMainCodeBody() {
  if (markAsSkippedIfNeed(TestState.Successful)) { return; }
  verifySort(new StringRef(/*KEEP_STR*/"import {sym} from 'a';\nlet x = 1;\n"), 
      new StringRef(/*KEEP_STR*/"import {sym} from 'a'; let x = 1;\n"));
}

;
@Test
//<editor-fold defaultstate="collapsed" desc="clang::format::(anonymous namespace)::SortImportsTestJS_Comments_Test::TestBody">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/unittests/Format/SortImportsTestJS.cpp", line = 95,
 FQN="clang::format::(anonymous namespace)::SortImportsTestJS_Comments_Test::TestBody", NM="_ZN5clang6format12_GLOBAL__N_131SortImportsTestJS_Comments_Test8TestBodyEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Format/SortImportsTestJS.cpp -nm=_ZN5clang6format12_GLOBAL__N_131SortImportsTestJS_Comments_Test8TestBodyEv")
//</editor-fold>
public void test_Comments() {
  if (markAsSkippedIfNeed(TestState.Successful)) { return; }
  verifySort(new StringRef(/*KEEP_STR*/"/** @fileoverview This is a great file. */\n// A very important import follows.\nimport {sym} from 'a';  /* more comments */\nimport {sym} from 'b';  // from //foo:bar\n"), 
      new StringRef(/*KEEP_STR*/"/** @fileoverview This is a great file. */\nimport {sym} from 'b';  // from //foo:bar\n// A very important import follows.\nimport {sym} from 'a';  /* more comments */\n"));
}

;
@Test
//<editor-fold defaultstate="collapsed" desc="clang::format::(anonymous namespace)::SortImportsTestJS_SortStar_Test::TestBody">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/unittests/Format/SortImportsTestJS.cpp", line = 106,
 FQN="clang::format::(anonymous namespace)::SortImportsTestJS_SortStar_Test::TestBody", NM="_ZN5clang6format12_GLOBAL__N_131SortImportsTestJS_SortStar_Test8TestBodyEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Format/SortImportsTestJS.cpp -nm=_ZN5clang6format12_GLOBAL__N_131SortImportsTestJS_SortStar_Test8TestBodyEv")
//</editor-fold>
public void test_SortStar() {
  if (markAsSkippedIfNeed(TestState.Successful)) { return; }
  verifySort(new StringRef(/*KEEP_STR*/"import * as foo from 'a';\nimport {sym} from 'a';\nimport * as bar from 'b';\n"), 
      new StringRef(/*KEEP_STR*/"import {sym} from 'a';\nimport * as foo from 'a';\nimport * as bar from 'b';\n"));
}

;
@Test
//<editor-fold defaultstate="collapsed" desc="clang::format::(anonymous namespace)::SortImportsTestJS_AliasesSymbols_Test::TestBody">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/unittests/Format/SortImportsTestJS.cpp", line = 115,
 FQN="clang::format::(anonymous namespace)::SortImportsTestJS_AliasesSymbols_Test::TestBody", NM="_ZN5clang6format12_GLOBAL__N_137SortImportsTestJS_AliasesSymbols_Test8TestBodyEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Format/SortImportsTestJS.cpp -nm=_ZN5clang6format12_GLOBAL__N_137SortImportsTestJS_AliasesSymbols_Test8TestBodyEv")
//</editor-fold>
public void test_AliasesSymbols() {
  if (markAsSkippedIfNeed(TestState.Successful)) { return; }
  verifySort(new StringRef(/*KEEP_STR*/"import {sym1 as alias1} from 'b';\nimport {sym2 as alias2, sym3 as alias3} from 'c';\n"), 
      new StringRef(/*KEEP_STR*/"import {sym2 as alias2, sym3 as alias3} from 'c';\nimport {sym1 as alias1} from 'b';\n"));
}

;
@Test
//<editor-fold defaultstate="collapsed" desc="clang::format::(anonymous namespace)::SortImportsTestJS_SortSymbols_Test::TestBody">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/unittests/Format/SortImportsTestJS.cpp", line = 122,
 FQN="clang::format::(anonymous namespace)::SortImportsTestJS_SortSymbols_Test::TestBody", NM="_ZN5clang6format12_GLOBAL__N_134SortImportsTestJS_SortSymbols_Test8TestBodyEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Format/SortImportsTestJS.cpp -nm=_ZN5clang6format12_GLOBAL__N_134SortImportsTestJS_SortSymbols_Test8TestBodyEv")
//</editor-fold>
public void test_SortSymbols() {
  if (markAsSkippedIfNeed(TestState.Successful)) { return; }
  verifySort(new StringRef(/*KEEP_STR*/"import {sym1, sym2 as a, sym3} from 'b';\n"), 
      new StringRef(/*KEEP_STR*/"import {sym2 as a, sym1, sym3} from 'b';\n"));
  verifySort(new StringRef(/*KEEP_STR*/"import {sym1 /* important! */, /*!*/ sym2 as a} from 'b';\n"), 
      new StringRef(/*KEEP_STR*/"import {/*!*/ sym2 as a, sym1 /* important! */} from 'b';\n"));
  verifySort(new StringRef(/*KEEP_STR*/"import {sym1, sym2} from 'b';\n"), new StringRef(/*KEEP_STR*/"import {\n  sym2 \n,\n sym1 \n} from 'b';\n"));
}

;
@Test
//<editor-fold defaultstate="collapsed" desc="clang::format::(anonymous namespace)::SortImportsTestJS_GroupImports_Test::TestBody">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/unittests/Format/SortImportsTestJS.cpp", line = 134,
 FQN="clang::format::(anonymous namespace)::SortImportsTestJS_GroupImports_Test::TestBody", NM="_ZN5clang6format12_GLOBAL__N_135SortImportsTestJS_GroupImports_Test8TestBodyEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Format/SortImportsTestJS.cpp -nm=_ZN5clang6format12_GLOBAL__N_135SortImportsTestJS_GroupImports_Test8TestBodyEv")
//</editor-fold>
public void test_GroupImports() {
  if (markAsSkippedIfNeed(TestState.Successful)) { return; }
  verifySort(new StringRef(/*KEEP_STR*/"import {a} from 'absolute';\n\nimport {b} from '../parent';\nimport {b} from '../parent/nested';\n\nimport {b} from './relative/path';\nimport {b} from './relative/path/nested';\n\nlet x = 1;\n"), 
      new StringRef(/*KEEP_STR*/"import {b} from './relative/path/nested';\nimport {b} from './relative/path';\nimport {b} from '../parent/nested';\nimport {b} from '../parent';\nimport {a} from 'absolute';\nlet x = 1;\n"));
}

;
@Test
//<editor-fold defaultstate="collapsed" desc="clang::format::(anonymous namespace)::SortImportsTestJS_Exports_Test::TestBody">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/unittests/Format/SortImportsTestJS.cpp", line = 152,
 FQN="clang::format::(anonymous namespace)::SortImportsTestJS_Exports_Test::TestBody", NM="_ZN5clang6format12_GLOBAL__N_130SortImportsTestJS_Exports_Test8TestBodyEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Format/SortImportsTestJS.cpp -nm=_ZN5clang6format12_GLOBAL__N_130SortImportsTestJS_Exports_Test8TestBodyEv")
//</editor-fold>
public void test_Exports() {
  if (markAsSkippedIfNeed(TestState.Successful)) { return; }
  verifySort(new StringRef(/*KEEP_STR*/"import {S} from 'bpath';\n\nimport {T} from './cpath';\n\nexport {A, B} from 'apath';\nexport {P} from '../parent';\nexport {R} from './relative';\nexport {S};\n\nlet x = 1;\nexport y = 1;\n"), 
      new StringRef(/*KEEP_STR*/"export {R} from './relative';\nimport {T} from './cpath';\nexport {S};\nexport {A, B} from 'apath';\nimport {S} from 'bpath';\nexport {P} from '../parent';\nlet x = 1;\nexport y = 1;\n"));
  verifySort(new StringRef(/*KEEP_STR*/"import {S} from 'bpath';\n\nexport {T} from 'epath';\n"), 
      new StringRef(/*KEEP_STR*/"export {T} from 'epath';\nimport {S} from 'bpath';\n"));
}

;
@Test
//<editor-fold defaultstate="collapsed" desc="clang::format::(anonymous namespace)::SortImportsTestJS_SideEffectImports_Test::TestBody">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/unittests/Format/SortImportsTestJS.cpp", line = 179,
 FQN="clang::format::(anonymous namespace)::SortImportsTestJS_SideEffectImports_Test::TestBody", NM="_ZN5clang6format12_GLOBAL__N_140SortImportsTestJS_SideEffectImports_Test8TestBodyEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Format/SortImportsTestJS.cpp -nm=_ZN5clang6format12_GLOBAL__N_140SortImportsTestJS_SideEffectImports_Test8TestBodyEv")
//</editor-fold>
public void test_SideEffectImports() {
  if (markAsSkippedIfNeed(TestState.Successful)) { return; }
  verifySort(new StringRef(/*KEEP_STR*/"import 'ZZside-effect';\nimport 'AAside-effect';\n\nimport {A} from 'absolute';\n\nimport {R} from './relative';\n"), 
      new StringRef(/*KEEP_STR*/"import {R} from './relative';\nimport 'ZZside-effect';\nimport {A} from 'absolute';\nimport 'AAside-effect';\n"));
}

;
@Test
//<editor-fold defaultstate="collapsed" desc="clang::format::(anonymous namespace)::SortImportsTestJS_AffectedRange_Test::TestBody">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/unittests/Format/SortImportsTestJS.cpp", line = 192,
 FQN="clang::format::(anonymous namespace)::SortImportsTestJS_AffectedRange_Test::TestBody", NM="_ZN5clang6format12_GLOBAL__N_136SortImportsTestJS_AffectedRange_Test8TestBodyEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Format/SortImportsTestJS.cpp -nm=_ZN5clang6format12_GLOBAL__N_136SortImportsTestJS_AffectedRange_Test8TestBodyEv")
//</editor-fold>
public void test_AffectedRange() {
  if (markAsSkippedIfNeed(TestState.Successful)) { return; }
  // Sort excluding a suffix.
  verifySort(new StringRef(/*KEEP_STR*/"import {sym} from 'b';\nimport {sym} from 'c';\nimport {sym} from 'a';\nlet x = 1;"), 
      new StringRef(/*KEEP_STR*/"import {sym} from 'c';\nimport {sym} from 'b';\nimport {sym} from 'a';\nlet x = 1;"), 
      0, 30);
  // Sort excluding a prefix.
  verifySort(new StringRef(/*KEEP_STR*/"import {sym} from 'c';\nimport {sym} from 'a';\nimport {sym} from 'b';\n\nlet x = 1;"), 
      new StringRef(/*KEEP_STR*/"import {sym} from 'c';\nimport {sym} from 'b';\nimport {sym} from 'a';\n\nlet x = 1;"), 
      30, 0);
  // Sort a range within imports.
  verifySort(new StringRef(/*KEEP_STR*/"import {sym} from 'c';\nimport {sym} from 'a';\nimport {sym} from 'b';\nimport {sym} from 'c';\nlet x = 1;"), 
      new StringRef(/*KEEP_STR*/"import {sym} from 'c';\nimport {sym} from 'b';\nimport {sym} from 'a';\nimport {sym} from 'c';\nlet x = 1;"), 
      24, 30);
}

;
@Test
//<editor-fold defaultstate="collapsed" desc="clang::format::(anonymous namespace)::SortImportsTestJS_SortingCanShrink_Test::TestBody">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/unittests/Format/SortImportsTestJS.cpp", line = 229,
 FQN="clang::format::(anonymous namespace)::SortImportsTestJS_SortingCanShrink_Test::TestBody", NM="_ZN5clang6format12_GLOBAL__N_139SortImportsTestJS_SortingCanShrink_Test8TestBodyEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Format/SortImportsTestJS.cpp -nm=_ZN5clang6format12_GLOBAL__N_139SortImportsTestJS_SortingCanShrink_Test8TestBodyEv")
//</editor-fold>
public void test_SortingCanShrink() {
  if (markAsSkippedIfNeed(TestState.Successful)) { return; }
  // Sort excluding a suffix.
  verifySort(new StringRef(/*KEEP_STR*/"import {B} from 'a';\nimport {A} from 'b';\n\n1;"), 
      new StringRef(/*KEEP_STR*/"import {A} from 'b';\n\nimport {B} from 'a';\n\n1;"));
}

;
@Test
//<editor-fold defaultstate="collapsed" desc="clang::format::(anonymous namespace)::SortImportsTestJS_TrailingComma_Test::TestBody">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/unittests/Format/SortImportsTestJS.cpp", line = 242,
 FQN="clang::format::(anonymous namespace)::SortImportsTestJS_TrailingComma_Test::TestBody", NM="_ZN5clang6format12_GLOBAL__N_136SortImportsTestJS_TrailingComma_Test8TestBodyEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Format/SortImportsTestJS.cpp -nm=_ZN5clang6format12_GLOBAL__N_136SortImportsTestJS_TrailingComma_Test8TestBodyEv")
//</editor-fold>
public void test_TrailingComma() {
  if (markAsSkippedIfNeed(TestState.Successful)) { return; }
  verifySort(new StringRef(/*KEEP_STR*/"import {A, B,} from 'aa';\n"), new StringRef(/*KEEP_STR*/"import {B, A,} from 'aa';\n"));
}

;
@Test
//<editor-fold defaultstate="collapsed" desc="clang::format::(anonymous namespace)::SortImportsTestJS_SortCaseInsensitive_Test::TestBody">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/unittests/Format/SortImportsTestJS.cpp", line = 246,
 FQN="clang::format::(anonymous namespace)::SortImportsTestJS_SortCaseInsensitive_Test::TestBody", NM="_ZN5clang6format12_GLOBAL__N_142SortImportsTestJS_SortCaseInsensitive_Test8TestBodyEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Format/SortImportsTestJS.cpp -nm=_ZN5clang6format12_GLOBAL__N_142SortImportsTestJS_SortCaseInsensitive_Test8TestBodyEv")
//</editor-fold>
public void test_SortCaseInsensitive() {
  if (markAsSkippedIfNeed(TestState.Successful)) { return; }
  verifySort(new StringRef(/*KEEP_STR*/"import {A} from 'aa';\nimport {A} from 'Ab';\nimport {A} from 'b';\nimport {A} from 'Bc';\n\n1;"), 
      new StringRef(/*KEEP_STR*/"import {A} from 'b';\nimport {A} from 'Bc';\nimport {A} from 'Ab';\nimport {A} from 'aa';\n\n1;"));
  verifySort(new StringRef(/*KEEP_STR*/"import {aa, Ab, b, Bc} from 'x';\n\n1;"), 
      new StringRef(/*KEEP_STR*/"import {b, Bc, Ab, aa} from 'x';\n\n1;"));
}

//} JAVA: end of namespace (anonymous) // end namespace
//} JAVA: end of namespace format // end namespace format
//} JAVA: end of namespace clang
//<editor-fold defaultstate="collapsed" desc="__builtin_trap">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/unittests/Format/SortImportsTestJS.cpp", line = 40,
 FQN="__builtin_trap", NM="_Z14__builtin_trap",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Format/SortImportsTestJS.cpp -nm=_Z14__builtin_trap")
//</editor-fold>
public static void __builtin_trap()/* __attribute__((nothrow))*/ {
  throw new UnsupportedOperationException("<<<DeclJavaPrinter::VisitFunctionDecl NULL BODY IN USED Translation Unit>>>");
}

} // END OF class SortImportsTestJS
