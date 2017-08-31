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
 * Collection of all test files from top test/Analysis/inlining folder
 * @author Vladimir Voskresensky
 */
public class Analysis_inlining_Test extends DriverTestFileBase {
  private static final String TEST_LOCATION = "${LLVM_SRC}/llvm/tools/clang/test/Analysis/inlining/";
  public Analysis_inlining_Test() {
    super(TEST_LOCATION, TestState.Successful);
  }
  
  public static void main(String[] args) {
    // Print tests which will be accepted per test case
    DriverTestFileBase.printAllTestFiles(false, TEST_LOCATION, (test)->true, 
            "${SPUTNIK}/modules/org.clang.staticanalyzer/test/unit/src/org/clang/staticanalyzer/test/Analysis_inlining_Test.txt");
  }

  @Override
  protected boolean keepStacksForUnimplementedMethods() {
    return false;
  }

  @Test
  public void test_DynDispatchBifurcate_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Analysis/inlining/DynDispatchBifurcate.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -analyze '-analyzer-checker=core,osx' -analyzer-config 'ipa=dynamic-bifurcate' -verify ${LLVM_SRC}/llvm/tools/clang/test/Analysis/inlining/DynDispatchBifurcate.m
    RUN("%clang_cc1 -analyze -analyzer-checker=core,osx -analyzer-config ipa=dynamic-bifurcate -verify %s");
  }

  @Test
  public void test_InlineObjCClassMethod_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Analysis/inlining/InlineObjCClassMethod.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -analyze '-analyzer-checker=core,debug.ExprInspection' -analyzer-config 'ipa=dynamic-bifurcate' -verify ${LLVM_SRC}/llvm/tools/clang/test/Analysis/inlining/InlineObjCClassMethod.m
    RUN("%clang_cc1 -analyze -analyzer-checker=core,debug.ExprInspection -analyzer-config ipa=dynamic-bifurcate -verify %s");
  }

  @Test
  public void test_InlineObjCInstanceMethod_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Analysis/inlining/InlineObjCInstanceMethod.m");
    // ${LLVM_SRC}/build/bin/clang --analyze -Xanalyzer '-analyzer-checker=osx.cocoa.IncompatibleMethodTypes,osx.coreFoundation.CFRetainRelease' -Xclang -verify ${LLVM_SRC}/llvm/tools/clang/test/Analysis/inlining/InlineObjCInstanceMethod.m
    RUN("%clang --analyze -Xanalyzer -analyzer-checker=osx.cocoa.IncompatibleMethodTypes,osx.coreFoundation.CFRetainRelease -Xclang -verify %s");
  }

  @Test
  public void test_ObjCDynTypePopagation_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Analysis/inlining/ObjCDynTypePopagation.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -analyze '-analyzer-checker=core,debug.ExprInspection' -analyzer-config 'ipa=dynamic-bifurcate' -verify ${LLVM_SRC}/llvm/tools/clang/test/Analysis/inlining/ObjCDynTypePopagation.m
    RUN("%clang_cc1 -analyze -analyzer-checker=core,debug.ExprInspection -analyzer-config ipa=dynamic-bifurcate -verify %s");
  }

  @Test
  public void test_ObjCImproperDynamictallyDetectableCast_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Analysis/inlining/ObjCImproperDynamictallyDetectableCast.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -analyze '-analyzer-checker=core,debug.ExprInspection' -analyzer-config 'ipa=dynamic-bifurcate' -verify ${LLVM_SRC}/llvm/tools/clang/test/Analysis/inlining/ObjCImproperDynamictallyDetectableCast.m
    RUN("%clang_cc1 -analyze -analyzer-checker=core,debug.ExprInspection -analyzer-config ipa=dynamic-bifurcate -verify %s");
  }

  @Test
  public void test_RetainCountExamples_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Analysis/inlining/RetainCountExamples.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -analyze '-analyzer-checker=core,osx.cocoa.RetainCount' -analyzer-config 'ipa=dynamic-bifurcate' -verify ${LLVM_SRC}/llvm/tools/clang/test/Analysis/inlining/RetainCountExamples.m
    RUN("%clang_cc1 -analyze -analyzer-checker=core,osx.cocoa.RetainCount -analyzer-config ipa=dynamic-bifurcate -verify %s");
  }

  @Test
  public void test_analysis_order_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Analysis/inlining/analysis-order.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -analyze '-analyzer-checker=core.builtin.NoReturnFunctions' -analyzer-display-progress ${LLVM_SRC}/llvm/tools/clang/test/Analysis/inlining/analysis-order.c 2>&1 | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Analysis/inlining/analysis-order.c
    RUN("%clang_cc1 -analyze -analyzer-checker=core.builtin.NoReturnFunctions -analyzer-display-progress %s 2>&1")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_assume_super_init_does_not_return_nil_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Analysis/inlining/assume-super-init-does-not-return-nil.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -analyze '-analyzer-checker=core,osx' -verify ${LLVM_SRC}/llvm/tools/clang/test/Analysis/inlining/assume-super-init-does-not-return-nil.m
    RUN("%clang_cc1 -analyze -analyzer-checker=core,osx -verify %s");
  }

  @Test
  public void test_containers_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Analysis/inlining/containers.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -analyze '-std=c++11' '-analyzer-checker=core,unix.Malloc,debug.ExprInspection' -analyzer-config 'c++-inlining=destructors' -analyzer-config 'c++-container-inlining=false' -verify ${LLVM_SRC}/llvm/tools/clang/test/Analysis/inlining/containers.cpp
    RUN(TestState.Failed, "%clang_cc1 -analyze -std=c++11 -analyzer-checker=core,unix.Malloc,debug.ExprInspection -analyzer-config c++-inlining=destructors -analyzer-config c++-container-inlining=false -verify %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -analyze '-std=c++11' '-analyzer-checker=core,unix.Malloc,debug.ExprInspection' -analyzer-config 'c++-inlining=destructors' -analyzer-config 'c++-container-inlining=true' '-DINLINE=1' -verify ${LLVM_SRC}/llvm/tools/clang/test/Analysis/inlining/containers.cpp
    RUN(TestState.Failed, "%clang_cc1 -analyze -std=c++11 -analyzer-checker=core,unix.Malloc,debug.ExprInspection -analyzer-config c++-inlining=destructors -analyzer-config c++-container-inlining=true -DINLINE=1 -verify %s");
  }

  @Test
  public void test_dyn_dispatch_bifurcate_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Analysis/inlining/dyn-dispatch-bifurcate.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -analyze '-analyzer-checker=core,debug.ExprInspection' -analyzer-config 'ipa=dynamic-bifurcate' -verify -Wno-reinterpret-base-class ${LLVM_SRC}/llvm/tools/clang/test/Analysis/inlining/dyn-dispatch-bifurcate.cpp
    RUN(TestState.Failed, "%clang_cc1 -analyze -analyzer-checker=core,debug.ExprInspection -analyzer-config ipa=dynamic-bifurcate -verify -Wno-reinterpret-base-class %s");
  }

  @Test
  public void test_eager_reclamation_path_notes_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Analysis/inlining/eager-reclamation-path-notes.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -analyze '-analyzer-checker=core' '-analyzer-output=text' -analyzer-config 'graph-trim-interval=5' -verify ${LLVM_SRC}/llvm/tools/clang/test/Analysis/inlining/eager-reclamation-path-notes.c
    RUN(TestState.Failed, "%clang_cc1 -analyze -analyzer-checker=core -analyzer-output=text -analyzer-config graph-trim-interval=5 -verify %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -analyze '-analyzer-checker=core' '-analyzer-output=plist-multi-file' -analyzer-config 'graph-trim-interval=5' -analyzer-config 'path-diagnostics-alternate=false' ${LLVM_SRC}/llvm/tools/clang/test/Analysis/inlining/eager-reclamation-path-notes.c -o ${TEST_TEMP_DIR}/eager-reclamation-path-notes.c.tmp.plist
    RUN(TestState.Failed, "%clang_cc1 -analyze -analyzer-checker=core -analyzer-output=plist-multi-file -analyzer-config graph-trim-interval=5 -analyzer-config path-diagnostics-alternate=false %s -o %t.plist");
    // ${LLVM_SRC}/build/bin/FileCheck "--input-file=${TEST_TEMP_DIR}/eager-reclamation-path-notes.c.tmp.plist" ${LLVM_SRC}/llvm/tools/clang/test/Analysis/inlining/eager-reclamation-path-notes.c
    RUN(TestState.Failed, "FileCheck --input-file=%t.plist %s");
  }

  @Test
  public void test_eager_reclamation_path_notes_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Analysis/inlining/eager-reclamation-path-notes.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -analyze '-analyzer-checker=core' '-analyzer-output=text' -analyzer-config 'graph-trim-interval=5' -analyzer-config 'suppress-null-return-paths=false' -verify ${LLVM_SRC}/llvm/tools/clang/test/Analysis/inlining/eager-reclamation-path-notes.cpp
    RUN(TestState.Failed, "%clang_cc1 -analyze -analyzer-checker=core -analyzer-output=text -analyzer-config graph-trim-interval=5 -analyzer-config suppress-null-return-paths=false -verify %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -analyze '-analyzer-checker=core' '-analyzer-output=plist-multi-file' -analyzer-config 'graph-trim-interval=5' -analyzer-config 'suppress-null-return-paths=false' -analyzer-config 'path-diagnostics-alternate=false' ${LLVM_SRC}/llvm/tools/clang/test/Analysis/inlining/eager-reclamation-path-notes.cpp -o ${TEST_TEMP_DIR}/eager-reclamation-path-notes.cpp.tmp.plist
    RUN(TestState.Failed, "%clang_cc1 -analyze -analyzer-checker=core -analyzer-output=plist-multi-file -analyzer-config graph-trim-interval=5 -analyzer-config suppress-null-return-paths=false -analyzer-config path-diagnostics-alternate=false %s -o %t.plist");
    // ${LLVM_SRC}/build/bin/FileCheck "--input-file=${TEST_TEMP_DIR}/eager-reclamation-path-notes.cpp.tmp.plist" ${LLVM_SRC}/llvm/tools/clang/test/Analysis/inlining/eager-reclamation-path-notes.cpp
    RUN(TestState.Failed, "FileCheck --input-file=%t.plist %s");
  }

  @Test
  public void test_false_positive_suppression_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Analysis/inlining/false-positive-suppression.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -analyze -analyzer-eagerly-assume '-analyzer-checker=core' -analyzer-config 'suppress-null-return-paths=false' -verify ${LLVM_SRC}/llvm/tools/clang/test/Analysis/inlining/false-positive-suppression.c
    RUN("%clang_cc1 -analyze -analyzer-eagerly-assume -analyzer-checker=core -analyzer-config suppress-null-return-paths=false -verify %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -analyze -analyzer-eagerly-assume '-analyzer-checker=core' -verify '-DSUPPRESSED=1' ${LLVM_SRC}/llvm/tools/clang/test/Analysis/inlining/false-positive-suppression.c
    RUN("%clang_cc1 -analyze -analyzer-eagerly-assume -analyzer-checker=core -verify -DSUPPRESSED=1 %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -analyze -analyzer-eagerly-assume '-analyzer-checker=core' -analyzer-config 'avoid-suppressing-null-argument-paths=true' '-DSUPPRESSED=1' '-DNULL_ARGS=1' -verify ${LLVM_SRC}/llvm/tools/clang/test/Analysis/inlining/false-positive-suppression.c
    RUN("%clang_cc1 -analyze -analyzer-eagerly-assume -analyzer-checker=core -analyzer-config avoid-suppressing-null-argument-paths=true -DSUPPRESSED=1 -DNULL_ARGS=1 -verify %s");
  }

  @Test
  public void test_false_positive_suppression_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Analysis/inlining/false-positive-suppression.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -analyze '-analyzer-checker=core' -analyzer-config 'suppress-null-return-paths=false' -verify ${LLVM_SRC}/llvm/tools/clang/test/Analysis/inlining/false-positive-suppression.cpp
    RUN(TestState.Failed, "%clang_cc1 -analyze -analyzer-checker=core -analyzer-config suppress-null-return-paths=false -verify %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -analyze '-analyzer-checker=core' -verify '-DSUPPRESSED=1' ${LLVM_SRC}/llvm/tools/clang/test/Analysis/inlining/false-positive-suppression.cpp
    RUN(TestState.Failed, "%clang_cc1 -analyze -analyzer-checker=core -verify -DSUPPRESSED=1 %s");
  }

  @Test
  public void test_false_positive_suppression_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Analysis/inlining/false-positive-suppression.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -analyze '-analyzer-checker=core' -analyzer-config 'suppress-null-return-paths=false' -verify ${LLVM_SRC}/llvm/tools/clang/test/Analysis/inlining/false-positive-suppression.m
    RUN("%clang_cc1 -analyze -analyzer-checker=core -analyzer-config suppress-null-return-paths=false -verify %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -analyze '-analyzer-checker=core' -verify '-DSUPPRESSED=1' ${LLVM_SRC}/llvm/tools/clang/test/Analysis/inlining/false-positive-suppression.m
    RUN("%clang_cc1 -analyze -analyzer-checker=core -verify -DSUPPRESSED=1 %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -analyze '-analyzer-checker=core' -analyzer-config 'avoid-suppressing-null-argument-paths=true' '-DSUPPRESSED=1' '-DNULL_ARGS=1' -verify ${LLVM_SRC}/llvm/tools/clang/test/Analysis/inlining/false-positive-suppression.m
    RUN("%clang_cc1 -analyze -analyzer-checker=core -analyzer-config avoid-suppressing-null-argument-paths=true -DSUPPRESSED=1 -DNULL_ARGS=1 -verify %s");
  }

  @Test
  public void test_inline_defensive_checks_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Analysis/inlining/inline-defensive-checks.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -analyze '-analyzer-checker=core' -analyzer-config 'suppress-inlined-defensive-checks=true' -verify ${LLVM_SRC}/llvm/tools/clang/test/Analysis/inlining/inline-defensive-checks.c
    RUN("%clang_cc1 -analyze -analyzer-checker=core -analyzer-config suppress-inlined-defensive-checks=true -verify %s");
  }

  @Test
  public void test_inline_defensive_checks_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Analysis/inlining/inline-defensive-checks.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -analyze '-analyzer-checker=core' -verify ${LLVM_SRC}/llvm/tools/clang/test/Analysis/inlining/inline-defensive-checks.cpp
    RUN("%clang_cc1 -analyze -analyzer-checker=core -verify %s");
  }

  @Test
  public void test_inline_defensive_checks_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Analysis/inlining/inline-defensive-checks.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -analyze '-analyzer-checker=core' -analyzer-config 'suppress-inlined-defensive-checks=true' -verify ${LLVM_SRC}/llvm/tools/clang/test/Analysis/inlining/inline-defensive-checks.m
    RUN("%clang_cc1 -analyze -analyzer-checker=core -analyzer-config suppress-inlined-defensive-checks=true -verify %s");
  }

  @Test
  public void test_path_notes_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Analysis/inlining/path-notes.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -analyze '-analyzer-checker=core' '-analyzer-output=text' -analyzer-config 'suppress-null-return-paths=false' -verify ${LLVM_SRC}/llvm/tools/clang/test/Analysis/inlining/path-notes.c
    RUN(TestState.Failed, "%clang_cc1 -analyze -analyzer-checker=core -analyzer-output=text -analyzer-config suppress-null-return-paths=false -verify %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -analyze '-analyzer-checker=core' '-analyzer-output=plist-multi-file' -analyzer-config 'suppress-null-return-paths=false' -analyzer-config 'path-diagnostics-alternate=false' ${LLVM_SRC}/llvm/tools/clang/test/Analysis/inlining/path-notes.c -o ${TEST_TEMP_DIR}/path-notes.c.tmp.plist
    RUN(TestState.Failed, "%clang_cc1 -analyze -analyzer-checker=core -analyzer-output=plist-multi-file -analyzer-config suppress-null-return-paths=false -analyzer-config path-diagnostics-alternate=false %s -o %t.plist");
    // ${LLVM_SRC}/build/bin/FileCheck "--input-file=${TEST_TEMP_DIR}/path-notes.c.tmp.plist" ${LLVM_SRC}/llvm/tools/clang/test/Analysis/inlining/path-notes.c
    RUN(TestState.Failed, "FileCheck --input-file=%t.plist %s");
  }

  @Test
  public void test_path_notes_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Analysis/inlining/path-notes.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -analyze '-analyzer-checker=core' '-analyzer-output=text' -analyzer-config 'c++-inlining=destructors' '-std=c++11' -verify -Wno-tautological-undefined-compare ${LLVM_SRC}/llvm/tools/clang/test/Analysis/inlining/path-notes.cpp
    RUN(TestState.Failed, "%clang_cc1 -analyze -analyzer-checker=core -analyzer-output=text -analyzer-config c++-inlining=destructors -std=c++11 -verify -Wno-tautological-undefined-compare %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -analyze '-analyzer-checker=core' '-analyzer-output=plist-multi-file' -analyzer-config 'c++-inlining=destructors' '-std=c++11' -analyzer-config 'path-diagnostics-alternate=false' ${LLVM_SRC}/llvm/tools/clang/test/Analysis/inlining/path-notes.cpp -o ${TEST_TEMP_DIR}/path-notes.cpp.tmp.plist -Wno-tautological-undefined-compare
    RUN(TestState.Failed, "%clang_cc1 -analyze -analyzer-checker=core -analyzer-output=plist-multi-file -analyzer-config c++-inlining=destructors -std=c++11 -analyzer-config path-diagnostics-alternate=false %s -o %t.plist -Wno-tautological-undefined-compare");
    // ${LLVM_SRC}/build/bin/FileCheck "--input-file=${TEST_TEMP_DIR}/path-notes.cpp.tmp.plist" ${LLVM_SRC}/llvm/tools/clang/test/Analysis/inlining/path-notes.cpp
    RUN(TestState.Failed, "FileCheck --input-file=%t.plist %s");
  }

  @Test
  public void test_path_notes_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Analysis/inlining/path-notes.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -analyze '-analyzer-checker=core,osx.cocoa.NilArg,osx.cocoa.RetainCount' '-analyzer-output=text' -analyzer-config 'suppress-null-return-paths=false' -fblocks -verify ${LLVM_SRC}/llvm/tools/clang/test/Analysis/inlining/path-notes.m
    RUN(TestState.Failed, "%clang_cc1 -analyze -analyzer-checker=core,osx.cocoa.NilArg,osx.cocoa.RetainCount -analyzer-output=text -analyzer-config suppress-null-return-paths=false -fblocks -verify %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -analyze '-analyzer-checker=core,osx.cocoa.NilArg,osx.cocoa.RetainCount' '-analyzer-output=plist-multi-file' -analyzer-config 'suppress-null-return-paths=false' -analyzer-config 'path-diagnostics-alternate=false' -fblocks ${LLVM_SRC}/llvm/tools/clang/test/Analysis/inlining/path-notes.m -o ${TEST_TEMP_DIR}/path-notes.m.tmp.plist
    RUN(TestState.Failed, "%clang_cc1 -analyze -analyzer-checker=core,osx.cocoa.NilArg,osx.cocoa.RetainCount -analyzer-output=plist-multi-file -analyzer-config suppress-null-return-paths=false -analyzer-config path-diagnostics-alternate=false -fblocks %s -o %t.plist");
    // ${LLVM_SRC}/build/bin/FileCheck "--input-file=${TEST_TEMP_DIR}/path-notes.m.tmp.plist" ${LLVM_SRC}/llvm/tools/clang/test/Analysis/inlining/path-notes.m
    RUN(TestState.Failed, "FileCheck --input-file=%t.plist %s");
  }

  @Test
  public void test_retain_count_self_init_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Analysis/inlining/retain-count-self-init.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -analyze '-analyzer-checker=core,osx.cocoa.RetainCount,osx.cocoa.SelfInit' -analyzer-config 'ipa=dynamic-bifurcate' -verify ${LLVM_SRC}/llvm/tools/clang/test/Analysis/inlining/retain-count-self-init.m
    RUN("%clang_cc1 -analyze -analyzer-checker=core,osx.cocoa.RetainCount,osx.cocoa.SelfInit -analyzer-config ipa=dynamic-bifurcate -verify %s");
  }

  @Test
  public void test_stl_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Analysis/inlining/stl.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -analyze '-analyzer-checker=core,unix.Malloc,cplusplus.NewDelete,debug.ExprInspection' -analyzer-config 'c++-container-inlining=true' -analyzer-config 'c++-stdlib-inlining=false' '-std=c++11' -verify ${LLVM_SRC}/llvm/tools/clang/test/Analysis/inlining/stl.cpp
    RUN(TestState.Failed, "%clang_cc1 -analyze -analyzer-checker=core,unix.Malloc,cplusplus.NewDelete,debug.ExprInspection -analyzer-config c++-container-inlining=true -analyzer-config c++-stdlib-inlining=false -std=c++11 -verify %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -analyze '-analyzer-checker=core,unix.Malloc,cplusplus.NewDelete,debug.ExprInspection' -analyzer-config 'c++-container-inlining=true' -analyzer-config 'c++-stdlib-inlining=true' '-std=c++11' '-DINLINE=1' -verify ${LLVM_SRC}/llvm/tools/clang/test/Analysis/inlining/stl.cpp
    RUN(TestState.Failed, "%clang_cc1 -analyze -analyzer-checker=core,unix.Malloc,cplusplus.NewDelete,debug.ExprInspection -analyzer-config c++-container-inlining=true -analyzer-config c++-stdlib-inlining=true -std=c++11 -DINLINE=1 -verify %s");
  }

  @Test
  public void test_test_always_inline_size_option_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Analysis/inlining/test-always-inline-size-option.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -analyze '-analyzer-checker=core,debug.ExprInspection' '-analyzer-inline-max-stack-depth=3' -analyzer-config 'ipa-always-inline-size=3' -verify ${LLVM_SRC}/llvm/tools/clang/test/Analysis/inlining/test-always-inline-size-option.c
    RUN("%clang_cc1 -analyze -analyzer-checker=core,debug.ExprInspection -analyzer-inline-max-stack-depth=3 -analyzer-config ipa-always-inline-size=3 -verify %s");
  }

  @Test
  public void test_test_objc_inlining_option_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Analysis/inlining/test_objc_inlining_option.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -analyze '-analyzer-checker=core' -analyzer-config 'ipa=dynamic-bifurcate' -analyzer-config 'objc-inlining=false' -verify ${LLVM_SRC}/llvm/tools/clang/test/Analysis/inlining/test_objc_inlining_option.m
    RUN("%clang_cc1 -analyze -analyzer-checker=core -analyzer-config ipa=dynamic-bifurcate -analyzer-config objc-inlining=false -verify %s");
  }

}
