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

package org.clang.staticanalyzer.test;

import org.clang.tools.driver.test.DriverTestFileBase;
import org.junit.*;

/**
 * Collection of all test files from top test/Analysis/diagnostics folder
 * @author Vladimir Voskresensky
 */
public class Analysis_diagnostics_Test extends DriverTestFileBase {
  private static final String TEST_LOCATION = "${LLVM_SRC}/llvm/tools/clang/test/Analysis/diagnostics/";
  public Analysis_diagnostics_Test() {
    super(TEST_LOCATION, TestState.Successful);
  }
  
  public static void main(String[] args) {
    // Print tests which will be accepted per test case
    DriverTestFileBase.printAllTestFiles(false, TEST_LOCATION, (test)->true, 
            "${SPUTNIK}/modules/org.clang.staticanalyzer/test/unit/src/org/clang/staticanalyzer/test/Analysis_diagnostics_Test.txt");
  }

  @Override
  protected boolean keepStacksForUnimplementedMethods() {
    return false;
  }

  @Test
  public void test_deref_track_symbolic_region_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Analysis/diagnostics/deref-track-symbolic-region.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -analyze '-analyzer-checker=core' '-analyzer-output=text' -verify ${LLVM_SRC}/llvm/tools/clang/test/Analysis/diagnostics/deref-track-symbolic-region.c
    RUN(TestState.Failed, "%clang_cc1 -analyze -analyzer-checker=core -analyzer-output=text -verify %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -analyze '-analyzer-checker=core' '-analyzer-output=plist-multi-file' -analyzer-config 'path-diagnostics-alternate=false' ${LLVM_SRC}/llvm/tools/clang/test/Analysis/diagnostics/deref-track-symbolic-region.c -o ${TEST_TEMP_DIR}/deref-track-symbolic-region.c.tmp.plist
    RUN(TestState.Failed, "%clang_cc1 -analyze -analyzer-checker=core -analyzer-output=plist-multi-file -analyzer-config path-diagnostics-alternate=false %s -o %t.plist");
    // ${LLVM_SRC}/build/bin/FileCheck "--input-file=${TEST_TEMP_DIR}/deref-track-symbolic-region.c.tmp.plist" ${LLVM_SRC}/llvm/tools/clang/test/Analysis/diagnostics/deref-track-symbolic-region.c
    RUN(TestState.Failed, "FileCheck --input-file=%t.plist %s");
  }

  @Test
  public void test_deref_track_symbolic_region_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Analysis/diagnostics/deref-track-symbolic-region.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -analyze '-analyzer-checker=core' '-analyzer-output=text' -verify ${LLVM_SRC}/llvm/tools/clang/test/Analysis/diagnostics/deref-track-symbolic-region.cpp
    RUN("%clang_cc1 -analyze -analyzer-checker=core -analyzer-output=text -verify %s");
  }

  @Test
  public void test_deref_track_symbolic_region_java_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Analysis/diagnostics/deref-track-symbolic-region-java.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -analyze '-analyzer-checker=core' '-analyzer-output=text' -verify ${LLVM_SRC}/llvm/tools/clang/test/Analysis/diagnostics/deref-track-symbolic-region-java.c
    RUN(TestState.Failed, "%clang_cc1 -analyze -analyzer-checker=core -analyzer-output=text -verify %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -analyze '-analyzer-checker=core' '-analyzer-output=plist-multi-file' -analyzer-config 'path-diagnostics-alternate=false' ${LLVM_SRC}/llvm/tools/clang/test/Analysis/diagnostics/deref-track-symbolic-region-java.c -o ${TEST_TEMP_DIR}/deref-track-symbolic-region-java.c.tmp.plist
    RUN(TestState.Failed, "%clang_cc1 -analyze -analyzer-checker=core -analyzer-output=plist-multi-file -analyzer-config path-diagnostics-alternate=false %s -o %t.plist");
    // ${LLVM_SRC}/build/bin/FileCheck "--input-file=${TEST_TEMP_DIR}/deref-track-symbolic-region-java.c.tmp.plist" ${LLVM_SRC}/llvm/tools/clang/test/Analysis/diagnostics/deref-track-symbolic-region-java.c
    RUN(TestState.Failed, "FileCheck --input-file=%t.plist %s");
  }

  @Test
  public void test_explicit_suppression_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Analysis/diagnostics/explicit-suppression.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -analyze '-analyzer-checker=core,debug.ExprInspection' -analyzer-config 'suppress-c++-stdlib=false' -verify ${LLVM_SRC}/llvm/tools/clang/test/Analysis/diagnostics/explicit-suppression.cpp
    RUN(TestState.Failed, "%clang_cc1 -analyze -analyzer-checker=core,debug.ExprInspection -analyzer-config suppress-c++-stdlib=false -verify %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -analyze '-analyzer-checker=core,debug.ExprInspection' -analyzer-config 'suppress-c++-stdlib=true' '-DSUPPRESSED=1' -verify ${LLVM_SRC}/llvm/tools/clang/test/Analysis/diagnostics/explicit-suppression.cpp
    RUN(TestState.Failed, "%clang_cc1 -analyze -analyzer-checker=core,debug.ExprInspection -analyzer-config suppress-c++-stdlib=true -DSUPPRESSED=1 -verify %s");
  }

  @Test
  public void test_false_positive_suppression_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Analysis/diagnostics/false-positive-suppression.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -I ${LLVM_SRC}/llvm/tools/clang/test/Analysis/diagnostics/Inputs -analyze '-analyzer-checker=core,unix' -verify ${LLVM_SRC}/llvm/tools/clang/test/Analysis/diagnostics/false-positive-suppression.c
    RUN("%clang_cc1 -I %S/Inputs -analyze -analyzer-checker=core,unix -verify %s");
  }

  @Test
  public void test_implicit_cxx_std_suppression_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Analysis/diagnostics/implicit-cxx-std-suppression.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -analyze '-analyzer-checker=core,unix.Malloc,cplusplus.NewDelete,debug.ExprInspection' -analyzer-config 'c++-container-inlining=true' -analyzer-config 'c++-stdlib-inlining=false' '-std=c++11' -verify ${LLVM_SRC}/llvm/tools/clang/test/Analysis/diagnostics/implicit-cxx-std-suppression.cpp
    RUN("%clang_cc1 -analyze -analyzer-checker=core,unix.Malloc,cplusplus.NewDelete,debug.ExprInspection -analyzer-config c++-container-inlining=true -analyzer-config c++-stdlib-inlining=false -std=c++11 -verify %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -analyze '-analyzer-checker=core,unix.Malloc,cplusplus.NewDelete,debug.ExprInspection' -analyzer-config 'c++-container-inlining=true' -analyzer-config 'c++-stdlib-inlining=true' '-std=c++11' -verify ${LLVM_SRC}/llvm/tools/clang/test/Analysis/diagnostics/implicit-cxx-std-suppression.cpp
    RUN("%clang_cc1 -analyze -analyzer-checker=core,unix.Malloc,cplusplus.NewDelete,debug.ExprInspection -analyzer-config c++-container-inlining=true -analyzer-config c++-stdlib-inlining=true -std=c++11 -verify %s");
  }

  @Test
  public void test_no_prune_paths_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Analysis/diagnostics/no-prune-paths.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -analyze '-analyzer-checker=core' '-analyzer-output=text' -verify ${LLVM_SRC}/llvm/tools/clang/test/Analysis/diagnostics/no-prune-paths.c
    RUN("%clang_cc1 -analyze -analyzer-checker=core -analyzer-output=text -verify %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -analyze '-analyzer-checker=core' '-analyzer-output=text' -analyzer-config 'prune-paths=false' '-DNPRUNE=1' -verify ${LLVM_SRC}/llvm/tools/clang/test/Analysis/diagnostics/no-prune-paths.c
    RUN("%clang_cc1 -analyze -analyzer-checker=core -analyzer-output=text -analyzer-config prune-paths=false -DNPRUNE=1 -verify %s");
  }

  @Test
  public void test_report_issues_within_main_file_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Analysis/diagnostics/report-issues-within-main-file.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -analyze '-analyzer-checker=core,unix' '-analyzer-output=plist-multi-file' -analyzer-config 'report-in-main-source-file=true' -analyzer-config 'path-diagnostics-alternate=false' ${LLVM_SRC}/llvm/tools/clang/test/Analysis/diagnostics/report-issues-within-main-file.cpp -o ${TEST_TEMP_DIR}/report-issues-within-main-file.cpp.tmp.plist
    RUN(TestState.Failed, "%clang_cc1 -analyze -analyzer-checker=core,unix -analyzer-output=plist-multi-file -analyzer-config report-in-main-source-file=true -analyzer-config path-diagnostics-alternate=false %s -o %t.plist");
    // ${LLVM_SRC}/build/bin/FileCheck "--input-file=${TEST_TEMP_DIR}/report-issues-within-main-file.cpp.tmp.plist" ${LLVM_SRC}/llvm/tools/clang/test/Analysis/diagnostics/report-issues-within-main-file.cpp
    RUN(TestState.Failed, "FileCheck --input-file=%t.plist %s");
  }

  @Test
  public void test_shortest_path_suppression_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Analysis/diagnostics/shortest-path-suppression.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -analyze '-analyzer-checker=core' -analyzer-config 'suppress-null-return-paths=true' '-analyzer-output=text' -verify ${LLVM_SRC}/llvm/tools/clang/test/Analysis/diagnostics/shortest-path-suppression.c
    RUN("%clang_cc1 -analyze -analyzer-checker=core -analyzer-config suppress-null-return-paths=true -analyzer-output=text -verify %s");
  }

  @Test
  public void test_text_diagnostics_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Analysis/diagnostics/text-diagnostics.c");
    // ${LLVM_SRC}/build/bin/clang --analyze -Xanalyzer '-analyzer-output=text' -fno-caret-diagnostics ${LLVM_SRC}/llvm/tools/clang/test/Analysis/diagnostics/text-diagnostics.c 2>&1 | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Analysis/diagnostics/text-diagnostics.c
    RUN("%clang --analyze -Xanalyzer -analyzer-output=text -fno-caret-diagnostics %s 2>&1")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_undef_value_caller_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Analysis/diagnostics/undef-value-caller.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -analyze '-analyzer-checker=core' '-analyzer-output=plist' -analyzer-config 'path-diagnostics-alternate=false' -o ${TEST_TEMP_DIR}/undef-value-caller.c.tmp ${LLVM_SRC}/llvm/tools/clang/test/Analysis/diagnostics/undef-value-caller.c
    RUN("%clang_cc1 -analyze -analyzer-checker=core -analyzer-output=plist -analyzer-config path-diagnostics-alternate=false -o %t %s");
    // ${LLVM_SRC}/build/bin/FileCheck --input-file ${TEST_TEMP_DIR}/undef-value-caller.c.tmp ${LLVM_SRC}/llvm/tools/clang/test/Analysis/diagnostics/undef-value-caller.c
    RUN("FileCheck --input-file %t %s");
  }

  @Test
  public void test_undef_value_param_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Analysis/diagnostics/undef-value-param.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -analyze '-analyzer-checker=core' '-analyzer-output=text' -verify ${LLVM_SRC}/llvm/tools/clang/test/Analysis/diagnostics/undef-value-param.c
    RUN(TestState.Failed, "%clang_cc1 -analyze -analyzer-checker=core -analyzer-output=text -verify %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -analyze '-analyzer-checker=core' '-analyzer-output=plist-multi-file' -analyzer-config 'path-diagnostics-alternate=false' ${LLVM_SRC}/llvm/tools/clang/test/Analysis/diagnostics/undef-value-param.c -o ${TEST_TEMP_DIR}/undef-value-param.c.tmp.plist
    RUN(TestState.Failed, "%clang_cc1 -analyze -analyzer-checker=core -analyzer-output=plist-multi-file -analyzer-config path-diagnostics-alternate=false %s -o %t.plist");
    // ${LLVM_SRC}/build/bin/FileCheck "--input-file=${TEST_TEMP_DIR}/undef-value-param.c.tmp.plist" ${LLVM_SRC}/llvm/tools/clang/test/Analysis/diagnostics/undef-value-param.c
    RUN(TestState.Failed, "FileCheck --input-file=%t.plist %s");
  }

  @Test
  public void test_undef_value_param_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Analysis/diagnostics/undef-value-param.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -analyze '-analyzer-checker=core,osx' '-analyzer-output=text' -verify ${LLVM_SRC}/llvm/tools/clang/test/Analysis/diagnostics/undef-value-param.m
    RUN(TestState.Failed, "%clang_cc1 -analyze -analyzer-checker=core,osx -analyzer-output=text -verify %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -analyze '-analyzer-checker=core,osx' '-analyzer-output=plist-multi-file' -analyzer-config 'path-diagnostics-alternate=false' ${LLVM_SRC}/llvm/tools/clang/test/Analysis/diagnostics/undef-value-param.m -o ${TEST_TEMP_DIR}/undef-value-param.m.tmp.plist
    RUN(TestState.Failed, "%clang_cc1 -analyze -analyzer-checker=core,osx -analyzer-output=plist-multi-file -analyzer-config path-diagnostics-alternate=false %s -o %t.plist");
    // ${LLVM_SRC}/build/bin/FileCheck "--input-file=${TEST_TEMP_DIR}/undef-value-param.m.tmp.plist" ${LLVM_SRC}/llvm/tools/clang/test/Analysis/diagnostics/undef-value-param.m
    RUN(TestState.Failed, "FileCheck --input-file=%t.plist %s");
  }

}
