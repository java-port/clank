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
package org.clang.rewrite.test;

import org.clang.tools.driver.test.DriverTestFileBase;
import org.junit.*;

/**
 * Collection of all test files from test/Rewriter folder
 * @author Vladimir Voskresensky
 */
@Ignore
public class AllRewriterTest extends DriverTestFileBase {
  private static final String TEST_LOCATION = "${LLVM_SRC}/llvm/tools/clang/test/Rewriter/";
  public AllRewriterTest() {
    super(TEST_LOCATION, TestState.Successful);
  }
  
  public static void main(String[] args) {
    // Print tests which will be accepted per test case
    DriverTestFileBase.printAllTestFiles(false, 
            TEST_LOCATION, (test)->{ return true;/*test.getFileIndexInFolder()<120;*/ }, 
            "${SPUTNIK}/modules/org.clang.rewrite/test/unit/src/org/clang/rewrite/test/AllRewriterTest.txt");
  }  

  @Override
  protected boolean keepStacksForUnimplementedMethods() {
    return false;
  }
  
  @Test
  public void test_blockcast3_mm() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Rewriter/blockcast3.mm");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -E ${LLVM_SRC}/llvm/tools/clang/test/Rewriter/blockcast3.mm -o ${TEST_TEMP_DIR}/blockcast3.mm.tmp.mm
    RUN(TestState.Failed, "%clang_cc1 -E %s -o %t.mm");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x objective-c++ -fblocks -fms-extensions -rewrite-objc -fobjc-runtime=macosx-fragile-10.5 ${TEST_TEMP_DIR}/blockcast3.mm.tmp.mm -o ${TEST_TEMP_DIR}/blockcast3.mm.tmp-rw.cpp
    RUN(TestState.Failed, "%clang_cc1 -x objective-c++ -fblocks -fms-extensions -rewrite-objc -fobjc-runtime=macosx-fragile-10.5 %t.mm -o %t-rw.cpp");
    // ${LLVM_SRC}/build/bin/FileCheck -check-prefix CHECK-LP '--input-file=${TEST_TEMP_DIR}/blockcast3.mm.tmp-rw.cpp' ${LLVM_SRC}/llvm/tools/clang/test/Rewriter/blockcast3.mm
    RUN(TestState.Failed, "FileCheck -check-prefix CHECK-LP --input-file=%t-rw.cpp %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x objective-c++ -fblocks -fms-extensions -rewrite-objc ${TEST_TEMP_DIR}/blockcast3.mm.tmp.mm -o ${TEST_TEMP_DIR}/blockcast3.mm.tmp-modern-rw.cpp
    RUN(TestState.Failed, "%clang_cc1 -x objective-c++ -fblocks -fms-extensions -rewrite-objc %t.mm -o %t-modern-rw.cpp");
    // ${LLVM_SRC}/build/bin/FileCheck -check-prefix CHECK-LP '--input-file=${TEST_TEMP_DIR}/blockcast3.mm.tmp-modern-rw.cpp' ${LLVM_SRC}/llvm/tools/clang/test/Rewriter/blockcast3.mm
    RUN(TestState.Failed, "FileCheck -check-prefix CHECK-LP --input-file=%t-modern-rw.cpp %s");
  }

  @Test
  public void test_blockstruct_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Rewriter/blockstruct.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x objective-c -Wno-return-type -fblocks -fms-extensions -rewrite-objc -fobjc-runtime=macosx-fragile-10.5 ${LLVM_SRC}/llvm/tools/clang/test/Rewriter/blockstruct.m -o ${TEST_TEMP_DIR}/blockstruct.m.tmp-rw.cpp
    RUN(TestState.Failed, "%clang_cc1 -x objective-c -Wno-return-type -fblocks -fms-extensions -rewrite-objc -fobjc-runtime=macosx-fragile-10.5 %s -o %t-rw.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -fblocks -Wno-address-of-temporary '-D"id=void*"' '-D"SEL=void*"' '-D"__declspec(X)="' ${TEST_TEMP_DIR}/blockstruct.m.tmp-rw.cpp
    RUN(TestState.Failed, "%clang_cc1 -fsyntax-only -fblocks -Wno-address-of-temporary -D\"id=void*\" -D\"SEL=void*\" -D\"__declspec(X)=\" %t-rw.cpp");
  }

  @Test
  public void test_crash_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Rewriter/crash.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -rewrite-objc -fobjc-runtime=macosx-fragile-10.5 -o - ${LLVM_SRC}/llvm/tools/clang/test/Rewriter/crash.m
    RUN(TestState.Failed, "%clang_cc1 -rewrite-objc -fobjc-runtime=macosx-fragile-10.5 -o - %s");
  }

  @Test
  public void test_finally_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Rewriter/finally.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -rewrite-objc -fobjc-runtime=macosx-fragile-10.5 -fobjc-exceptions -verify ${LLVM_SRC}/llvm/tools/clang/test/Rewriter/finally.m -o -
    RUN(TestState.Failed, "%clang_cc1 -rewrite-objc -fobjc-runtime=macosx-fragile-10.5 -fobjc-exceptions -verify %s -o -");
  }

  @Test
  public void test_func_in_impl_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Rewriter/func-in-impl.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -E ${LLVM_SRC}/llvm/tools/clang/test/Rewriter/func-in-impl.m -o ${TEST_TEMP_DIR}/func-in-impl.m.tmp.m
    RUN(TestState.Failed, "%clang_cc1 -E %s -o %t.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fobjc-runtime=macosx-fragile-10.5 -rewrite-objc ${TEST_TEMP_DIR}/func-in-impl.m.tmp.m -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Rewriter/func-in-impl.m
    RUN(TestState.Failed, "%clang_cc1 -fobjc-runtime=macosx-fragile-10.5 -rewrite-objc %t.m -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_id_test_3_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Rewriter/id-test-3.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -rewrite-objc -fobjc-runtime=macosx-fragile-10.5 ${LLVM_SRC}/llvm/tools/clang/test/Rewriter/id-test-3.m -o -
    RUN(TestState.Failed, "%clang_cc1 -rewrite-objc -fobjc-runtime=macosx-fragile-10.5 %s -o -");
  }

  @Test
  public void test_inner_block_helper_funcs_mm() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Rewriter/inner-block-helper-funcs.mm");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x objective-c++ -fblocks -fms-extensions -rewrite-objc -fobjc-runtime=macosx-fragile-10.5 ${LLVM_SRC}/llvm/tools/clang/test/Rewriter/inner-block-helper-funcs.mm -o ${TEST_TEMP_DIR}/inner-block-helper-funcs.mm.tmp-rw.cpp
    RUN(TestState.Failed, "%clang_cc1 -x objective-c++ -fblocks -fms-extensions -rewrite-objc -fobjc-runtime=macosx-fragile-10.5 %s -o %t-rw.cpp");
    // ${LLVM_SRC}/build/bin/FileCheck -check-prefix CHECK-LP '--input-file=${TEST_TEMP_DIR}/inner-block-helper-funcs.mm.tmp-rw.cpp' ${LLVM_SRC}/llvm/tools/clang/test/Rewriter/inner-block-helper-funcs.mm
    RUN(TestState.Failed, "FileCheck  -check-prefix CHECK-LP --input-file=%t-rw.cpp %s");
  }

  @Test
  public void test_instancetype_test_mm() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Rewriter/instancetype-test.mm");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x objective-c++ -Wno-return-type -fms-extensions -rewrite-objc -fobjc-runtime=macosx-fragile-10.5 ${LLVM_SRC}/llvm/tools/clang/test/Rewriter/instancetype-test.mm -o ${TEST_TEMP_DIR}/instancetype-test.mm.tmp-rw.cpp
    RUN(TestState.Failed, "%clang_cc1 -x objective-c++ -Wno-return-type -fms-extensions -rewrite-objc -fobjc-runtime=macosx-fragile-10.5 %s -o %t-rw.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -Wno-address-of-temporary '-D"Class=void*"' '-D"id=void*"' '-D"SEL=void*"' '-D"__declspec(X)="' ${TEST_TEMP_DIR}/instancetype-test.mm.tmp-rw.cpp
    RUN(TestState.Failed, "%clang_cc1 -fsyntax-only -Wno-address-of-temporary -D\"Class=void*\" -D\"id=void*\" -D\"SEL=void*\" -D\"__declspec(X)=\" %t-rw.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x objective-c++ -Wno-return-type -fms-extensions -rewrite-objc ${LLVM_SRC}/llvm/tools/clang/test/Rewriter/instancetype-test.mm -o ${TEST_TEMP_DIR}/instancetype-test.mm.tmp-modern-rw.cpp
    RUN(TestState.Failed, "%clang_cc1 -x objective-c++ -Wno-return-type -fms-extensions -rewrite-objc %s -o %t-modern-rw.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -Wno-address-of-temporary '-D"Class=void*"' '-D"id=void*"' '-D"SEL=void*"' '-D"__declspec(X)="' ${TEST_TEMP_DIR}/instancetype-test.mm.tmp-modern-rw.cpp
    RUN(TestState.Failed, "%clang_cc1 -fsyntax-only -Wno-address-of-temporary -D\"Class=void*\" -D\"id=void*\" -D\"SEL=void*\" -D\"__declspec(X)=\" %t-modern-rw.cpp");
  }

  @Test
  public void test_ivar_encoding_1_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Rewriter/ivar-encoding-1.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -rewrite-objc -fobjc-runtime=macosx-fragile-10.5 ${LLVM_SRC}/llvm/tools/clang/test/Rewriter/ivar-encoding-1.m -o -
    RUN(TestState.Failed, "%clang_cc1 -rewrite-objc -fobjc-runtime=macosx-fragile-10.5  %s -o -");
  }

  @Test
  public void test_ivar_encoding_2_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Rewriter/ivar-encoding-2.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -rewrite-objc -fobjc-runtime=macosx-fragile-10.5 ${LLVM_SRC}/llvm/tools/clang/test/Rewriter/ivar-encoding-2.m -o -
    RUN(TestState.Failed, "%clang_cc1 -rewrite-objc -fobjc-runtime=macosx-fragile-10.5  %s -o -");
  }

  @Test
  public void test_line_generation_test_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Rewriter/line-generation-test.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -E ${LLVM_SRC}/llvm/tools/clang/test/Rewriter/line-generation-test.m -o ${TEST_TEMP_DIR}/line-generation-test.m.tmp.mm
    RUN(TestState.Failed, "%clang_cc1 -E %s -o %t.mm");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fms-extensions -rewrite-objc -debug-info-kind=limited ${TEST_TEMP_DIR}/line-generation-test.m.tmp.mm -o ${TEST_TEMP_DIR}/line-generation-test.m.tmp-rw.cpp
    RUN(TestState.Failed, "%clang_cc1 -fms-extensions -rewrite-objc -debug-info-kind=limited %t.mm -o %t-rw.cpp");
    // ${LLVM_SRC}/build/bin/FileCheck -check-prefix CHECK-LINE '--input-file=${TEST_TEMP_DIR}/line-generation-test.m.tmp-rw.cpp' ${LLVM_SRC}/llvm/tools/clang/test/Rewriter/line-generation-test.m
    RUN(TestState.Failed, "FileCheck  -check-prefix CHECK-LINE --input-file=%t-rw.cpp %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fms-extensions -rewrite-objc ${TEST_TEMP_DIR}/line-generation-test.m.tmp.mm -o ${TEST_TEMP_DIR}/line-generation-test.m.tmp-rwnog.cpp
    RUN(TestState.Failed, "%clang_cc1 -fms-extensions -rewrite-objc %t.mm -o %t-rwnog.cpp");
    // ${LLVM_SRC}/build/bin/FileCheck -check-prefix CHECK-NOLINE '--input-file=${TEST_TEMP_DIR}/line-generation-test.m.tmp-rwnog.cpp' ${LLVM_SRC}/llvm/tools/clang/test/Rewriter/line-generation-test.m
    RUN(TestState.Failed, "FileCheck  -check-prefix CHECK-NOLINE --input-file=%t-rwnog.cpp %s");
  }

  @Test
  public void test_metadata_test_1_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Rewriter/metadata-test-1.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -rewrite-objc -fobjc-runtime=macosx-fragile-10.5 ${LLVM_SRC}/llvm/tools/clang/test/Rewriter/metadata-test-1.m -o -
    RUN(TestState.Failed, "%clang_cc1 -rewrite-objc -fobjc-runtime=macosx-fragile-10.5  %s -o -");
  }

  @Test
  public void test_metadata_test_2_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Rewriter/metadata-test-2.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -rewrite-objc -fobjc-runtime=macosx-fragile-10.5 ${LLVM_SRC}/llvm/tools/clang/test/Rewriter/metadata-test-2.m -o -
    RUN(TestState.Failed, "%clang_cc1 -rewrite-objc -fobjc-runtime=macosx-fragile-10.5  %s -o -");
  }

  @Test
  public void test_method_encoding_1_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Rewriter/method-encoding-1.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -rewrite-objc -fobjc-runtime=macosx-fragile-10.5 ${LLVM_SRC}/llvm/tools/clang/test/Rewriter/method-encoding-1.m -o -
    RUN(TestState.Failed, "%clang_cc1 -rewrite-objc -fobjc-runtime=macosx-fragile-10.5  %s -o -");
  }

  @Test
  public void test_missing_dllimport_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Rewriter/missing-dllimport.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i686-pc-win32 -fms-extensions -verify ${LLVM_SRC}/llvm/tools/clang/test/Rewriter/missing-dllimport.c
    RUN(TestState.Failed, "%clang_cc1 -triple i686-pc-win32 -fms-extensions -verify %s");
  }

  @Test
  public void test_modern_write_bf_abi_mm() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Rewriter/modern-write-bf-abi.mm");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x objective-c++ -Wno-return-type -fms-extensions -rewrite-objc ${LLVM_SRC}/llvm/tools/clang/test/Rewriter/modern-write-bf-abi.mm -o ${TEST_TEMP_DIR}/modern-write-bf-abi.mm.tmp-modern-rw.cpp
    RUN(TestState.Failed, "%clang_cc1 -x objective-c++ -Wno-return-type -fms-extensions -rewrite-objc %s -o %t-modern-rw.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -Wno-address-of-temporary '-D"Class=void*"' '-D"id=void*"' '-D"SEL=void*"' '-D"__declspec(X)="' ${TEST_TEMP_DIR}/modern-write-bf-abi.mm.tmp-modern-rw.cpp
    RUN(TestState.Failed, "%clang_cc1 -fsyntax-only -Wno-address-of-temporary -D\"Class=void*\" -D\"id=void*\" -D\"SEL=void*\" -D\"__declspec(X)=\" %t-modern-rw.cpp");
  }

  @Test
  public void test_no_integrated_preprocessing_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Rewriter/no-integrated-preprocessing.m");
    // ${LLVM_SRC}/build/bin/clang -target i386-unknown-unknown -fms-extensions -rewrite-objc ${LLVM_SRC}/llvm/tools/clang/test/Rewriter/no-integrated-preprocessing.m -o ${TEST_TEMP_DIR}/no-integrated-preprocessing.m.tmp-rw.cpp
    RUN(TestState.Failed, "%clang -target i386-unknown-unknown -fms-extensions -rewrite-objc %s -o %t-rw.cpp");
    // ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Rewriter/no-integrated-preprocessing.m < ${TEST_TEMP_DIR}/no-integrated-preprocessing.m.tmp-rw.cpp
    RUN(TestState.Failed, "FileCheck %s < %t-rw.cpp");
  }

  @Test
  public void test_no_integrated_preprocessing_64bit_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Rewriter/no-integrated-preprocessing-64bit.m");
    // ${LLVM_SRC}/build/bin/clang -target x86_64-unknown-unknown -fms-extensions -rewrite-objc ${LLVM_SRC}/llvm/tools/clang/test/Rewriter/no-integrated-preprocessing-64bit.m -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Rewriter/no-integrated-preprocessing-64bit.m
    RUN(TestState.Failed, "%clang -target x86_64-unknown-unknown -fms-extensions -rewrite-objc %s -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_objc_bool_literal_check_modern_mm() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Rewriter/objc-bool-literal-check-modern.mm");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -E ${LLVM_SRC}/llvm/tools/clang/test/Rewriter/objc-bool-literal-check-modern.mm -o ${TEST_TEMP_DIR}/objc-bool-literal-check-modern.mm.tmp.mm
    RUN(TestState.Failed, "%clang_cc1 -E %s -o %t.mm");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x objective-c++ -fblocks -fms-extensions -rewrite-objc ${TEST_TEMP_DIR}/objc-bool-literal-check-modern.mm.tmp.mm -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Rewriter/objc-bool-literal-check-modern.mm
    RUN(TestState.Failed, "%clang_cc1 -x objective-c++ -fblocks -fms-extensions -rewrite-objc %t.mm -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_objc_bool_literal_modern_mm() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Rewriter/objc-bool-literal-modern.mm");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x objective-c++ -fms-extensions -rewrite-objc ${LLVM_SRC}/llvm/tools/clang/test/Rewriter/objc-bool-literal-modern.mm -o ${TEST_TEMP_DIR}/objc-bool-literal-modern.mm.tmp-rw.cpp
    RUN(TestState.Failed, "%clang_cc1 -x objective-c++ -fms-extensions -rewrite-objc %s -o %t-rw.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only '-D"__declspec(X)="' ${TEST_TEMP_DIR}/objc-bool-literal-modern.mm.tmp-rw.cpp
    RUN(TestState.Failed, "%clang_cc1 -fsyntax-only -D\"__declspec(X)=\" %t-rw.cpp");
  }

  @Test
  public void test_objc_bool_literal_modern_1_mm() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Rewriter/objc-bool-literal-modern-1.mm");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x objective-c++ -fblocks -fms-extensions -rewrite-objc ${LLVM_SRC}/llvm/tools/clang/test/Rewriter/objc-bool-literal-modern-1.mm -o ${TEST_TEMP_DIR}/objc-bool-literal-modern-1.mm.tmp-rw.cpp
    RUN(TestState.Failed, "%clang_cc1 -x objective-c++ -fblocks -fms-extensions -rewrite-objc %s -o %t-rw.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -Wno-address-of-temporary '-D"__declspec(X)="' ${TEST_TEMP_DIR}/objc-bool-literal-modern-1.mm.tmp-rw.cpp
    RUN(TestState.Failed, "%clang_cc1 -fsyntax-only -Wno-address-of-temporary -D\"__declspec(X)=\" %t-rw.cpp");
  }

  @Test
  public void test_objc_encoding_bug_1_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Rewriter/objc-encoding-bug-1.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -rewrite-objc -fobjc-runtime=macosx-fragile-10.5 ${LLVM_SRC}/llvm/tools/clang/test/Rewriter/objc-encoding-bug-1.m -o -
    RUN(TestState.Failed, "%clang_cc1 -rewrite-objc -fobjc-runtime=macosx-fragile-10.5  %s -o -");
  }

  @Test
  public void test_objc_ivar_receiver_1_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Rewriter/objc-ivar-receiver-1.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -rewrite-objc -fobjc-runtime=macosx-fragile-10.5 ${LLVM_SRC}/llvm/tools/clang/test/Rewriter/objc-ivar-receiver-1.m -o -
    RUN(TestState.Failed, "%clang_cc1 -rewrite-objc -fobjc-runtime=macosx-fragile-10.5  %s -o -");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -rewrite-objc -fobjc-runtime=macosx-fragile-10.5 ${LLVM_SRC}/llvm/tools/clang/test/Rewriter/objc-ivar-receiver-1.m -o - | grep newInv->_container
    RUN(TestState.Failed, "%clang_cc1 -rewrite-objc -fobjc-runtime=macosx-fragile-10.5  %s -o -")./*|*/
      I("grep 'newInv->_container'");
  }

  @Test
  public void test_objc_modern_StretAPI_mm() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Rewriter/objc-modern-StretAPI.mm");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x objective-c++ -fblocks -fms-extensions -rewrite-objc ${LLVM_SRC}/llvm/tools/clang/test/Rewriter/objc-modern-StretAPI.mm -o ${TEST_TEMP_DIR}/objc-modern-StretAPI.mm.tmp-rw.cpp
    RUN(TestState.Failed, "%clang_cc1 -x objective-c++ -fblocks -fms-extensions -rewrite-objc %s -o %t-rw.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -fblocks -Wno-address-of-temporary '-D"Class=void*"' '-D"id=void*"' '-D"SEL=void*"' '-D"__declspec(X)="' ${TEST_TEMP_DIR}/objc-modern-StretAPI.mm.tmp-rw.cpp
    RUN(TestState.Failed, "%clang_cc1 -fsyntax-only -fblocks -Wno-address-of-temporary -D\"Class=void*\" -D\"id=void*\" -D\"SEL=void*\" -D\"__declspec(X)=\" %t-rw.cpp");
  }

  @Test
  public void test_objc_modern_StretAPI_2_mm() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Rewriter/objc-modern-StretAPI-2.mm");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x objective-c++ -fblocks -fms-extensions -rewrite-objc ${LLVM_SRC}/llvm/tools/clang/test/Rewriter/objc-modern-StretAPI-2.mm -o ${TEST_TEMP_DIR}/objc-modern-StretAPI-2.mm.tmp-rw.cpp
    RUN(TestState.Failed, "%clang_cc1 -x objective-c++ -fblocks -fms-extensions -rewrite-objc %s -o %t-rw.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -fblocks -Wno-address-of-temporary '-D"Class=void*"' '-D"id=void*"' '-D"SEL=void*"' '-D"__declspec(X)="' ${TEST_TEMP_DIR}/objc-modern-StretAPI-2.mm.tmp-rw.cpp
    RUN(TestState.Failed, "%clang_cc1 -fsyntax-only -fblocks -Wno-address-of-temporary -D\"Class=void*\" -D\"id=void*\" -D\"SEL=void*\" -D\"__declspec(X)=\" %t-rw.cpp");
  }

  @Test
  public void test_objc_modern_StretAPI_3_mm() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Rewriter/objc-modern-StretAPI-3.mm");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x objective-c++ -fblocks -fms-extensions -rewrite-objc ${LLVM_SRC}/llvm/tools/clang/test/Rewriter/objc-modern-StretAPI-3.mm -o ${TEST_TEMP_DIR}/objc-modern-StretAPI-3.mm.tmp-rw.cpp
    RUN(TestState.Failed, "%clang_cc1 -x objective-c++ -fblocks -fms-extensions -rewrite-objc %s -o %t-rw.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -fblocks -Wno-address-of-temporary '-D"Class=void*"' '-D"id=void*"' '-D"SEL=void*"' '-D"__declspec(X)="' ${TEST_TEMP_DIR}/objc-modern-StretAPI-3.mm.tmp-rw.cpp
    RUN(TestState.Failed, "%clang_cc1 -fsyntax-only -fblocks -Wno-address-of-temporary -D\"Class=void*\" -D\"id=void*\" -D\"SEL=void*\" -D\"__declspec(X)=\" %t-rw.cpp");
  }

  @Test
  public void test_objc_modern_boxing_mm() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Rewriter/objc-modern-boxing.mm");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -E ${LLVM_SRC}/llvm/tools/clang/test/Rewriter/objc-modern-boxing.mm -o ${TEST_TEMP_DIR}/objc-modern-boxing.mm.tmp.mm
    RUN(TestState.Failed, "%clang_cc1 -E %s -o %t.mm");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x objective-c++ -fblocks -fms-extensions -rewrite-objc ${TEST_TEMP_DIR}/objc-modern-boxing.mm.tmp.mm -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Rewriter/objc-modern-boxing.mm
    RUN(TestState.Failed, "%clang_cc1 -x objective-c++ -fblocks -fms-extensions -rewrite-objc %t.mm -o -")./*|*/
      I("FileCheck %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x objective-c++ -fblocks -fms-extensions -rewrite-objc ${TEST_TEMP_DIR}/objc-modern-boxing.mm.tmp.mm -o ${TEST_TEMP_DIR}/objc-modern-boxing.mm.tmp-rw.cpp
    RUN(TestState.Failed, "%clang_cc1 -x objective-c++ -fblocks -fms-extensions -rewrite-objc %t.mm -o %t-rw.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -Werror -Wno-address-of-temporary '-D"Class=void*"' '-D"id=void*"' '-D"SEL=void*"' -U__declspec '-D"__declspec(X)="' ${TEST_TEMP_DIR}/objc-modern-boxing.mm.tmp-rw.cpp -Wno-attributes
    RUN(TestState.Failed, "%clang_cc1 -fsyntax-only -Werror -Wno-address-of-temporary -D\"Class=void*\" -D\"id=void*\" -D\"SEL=void*\" -U__declspec -D\"__declspec(X)=\" %t-rw.cpp -Wno-attributes");
  }

  @Test
  public void test_objc_modern_class_init_mm() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Rewriter/objc-modern-class-init.mm");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x objective-c++ -fblocks -fms-extensions -rewrite-objc ${LLVM_SRC}/llvm/tools/clang/test/Rewriter/objc-modern-class-init.mm -o ${TEST_TEMP_DIR}/objc-modern-class-init.mm.tmp-rw.cpp
    RUN(TestState.Failed, "%clang_cc1 -x objective-c++ -fblocks -fms-extensions -rewrite-objc %s -o %t-rw.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -fblocks -Wno-address-of-temporary '-D"Class=void*"' '-D"id=void*"' '-D"SEL=void*"' '-D"__declspec(X)="' ${TEST_TEMP_DIR}/objc-modern-class-init.mm.tmp-rw.cpp
    RUN(TestState.Failed, "%clang_cc1 -fsyntax-only -fblocks -Wno-address-of-temporary -D\"Class=void*\" -D\"id=void*\" -D\"SEL=void*\" -D\"__declspec(X)=\" %t-rw.cpp");
  }

  @Test
  public void test_objc_modern_class_init_hooks_mm() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Rewriter/objc-modern-class-init-hooks.mm");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -E ${LLVM_SRC}/llvm/tools/clang/test/Rewriter/objc-modern-class-init-hooks.mm -o ${TEST_TEMP_DIR}/objc-modern-class-init-hooks.mm.tmp.mm
    RUN(TestState.Failed, "%clang_cc1 -E %s -o %t.mm");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x objective-c++ -fblocks -fms-extensions -rewrite-objc ${TEST_TEMP_DIR}/objc-modern-class-init-hooks.mm.tmp.mm -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Rewriter/objc-modern-class-init-hooks.mm
    RUN(TestState.Failed, "%clang_cc1 -x objective-c++ -fblocks -fms-extensions -rewrite-objc %t.mm -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_objc_modern_container_subscript_mm() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Rewriter/objc-modern-container-subscript.mm");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x objective-c++ -fblocks -fms-extensions -rewrite-objc ${LLVM_SRC}/llvm/tools/clang/test/Rewriter/objc-modern-container-subscript.mm -o ${TEST_TEMP_DIR}/objc-modern-container-subscript.mm.tmp-rw.cpp
    RUN(TestState.Failed, "%clang_cc1 -x objective-c++ -fblocks -fms-extensions -rewrite-objc %s -o %t-rw.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -fblocks -Wno-address-of-temporary '-D"Class=void*"' '-D"id=void*"' '-D"SEL=void*"' '-D"__declspec(X)="' ${TEST_TEMP_DIR}/objc-modern-container-subscript.mm.tmp-rw.cpp
    RUN(TestState.Failed, "%clang_cc1 -fsyntax-only -fblocks -Wno-address-of-temporary -D\"Class=void*\" -D\"id=void*\" -D\"SEL=void*\" -D\"__declspec(X)=\" %t-rw.cpp");
  }

  @Test
  public void test_objc_modern_fast_enumeration_mm() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Rewriter/objc-modern-fast-enumeration.mm");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -E ${LLVM_SRC}/llvm/tools/clang/test/Rewriter/objc-modern-fast-enumeration.mm -o ${TEST_TEMP_DIR}/objc-modern-fast-enumeration.mm.tmp.mm
    RUN(TestState.Failed, "%clang_cc1 -E %s -o %t.mm");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x objective-c++ -fblocks -fms-extensions -rewrite-objc ${TEST_TEMP_DIR}/objc-modern-fast-enumeration.mm.tmp.mm -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Rewriter/objc-modern-fast-enumeration.mm
    RUN(TestState.Failed, "%clang_cc1 -x objective-c++ -fblocks -fms-extensions -rewrite-objc %t.mm -o -")./*|*/
      I("FileCheck %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x objective-c++ -fblocks -fms-extensions -rewrite-objc ${TEST_TEMP_DIR}/objc-modern-fast-enumeration.mm.tmp.mm -o ${TEST_TEMP_DIR}/objc-modern-fast-enumeration.mm.tmp-rw.cpp
    RUN(TestState.Failed, "%clang_cc1 -x objective-c++ -fblocks -fms-extensions -rewrite-objc %t.mm -o %t-rw.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -triple i686-pc-win32 -Werror -Wno-address-of-temporary '-D"Class=struct objc_class *"' '-D"id=struct objc_object *"' '-D"SEL=void*"' -U__declspec '-D"__declspec(X)="' ${TEST_TEMP_DIR}/objc-modern-fast-enumeration.mm.tmp-rw.cpp -Wno-attributes
    RUN(TestState.Failed, "%clang_cc1 -fsyntax-only -triple i686-pc-win32 -Werror -Wno-address-of-temporary -D\"Class=struct objc_class *\" -D\"id=struct objc_object *\" -D\"SEL=void*\" -U__declspec -D\"__declspec(X)=\" %t-rw.cpp -Wno-attributes");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -triple x86_64-pc-win32 -Werror -Wno-address-of-temporary -D_WIN64 '-D"Class=struct objc_class *"' '-D"id=struct objc_object *"' '-D"SEL=void*"' -U__declspec '-D"__declspec(X)="' ${TEST_TEMP_DIR}/objc-modern-fast-enumeration.mm.tmp-rw.cpp -Wno-attributes
    RUN(TestState.Failed, "%clang_cc1 -fsyntax-only -triple x86_64-pc-win32 -Werror -Wno-address-of-temporary -D_WIN64 -D\"Class=struct objc_class *\" -D\"id=struct objc_object *\" -D\"SEL=void*\" -U__declspec -D\"__declspec(X)=\" %t-rw.cpp -Wno-attributes");
  }

  @Test
  public void test_objc_modern_getclass_proto_mm() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Rewriter/objc-modern-getclass-proto.mm");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -E ${LLVM_SRC}/llvm/tools/clang/test/Rewriter/objc-modern-getclass-proto.mm -o ${TEST_TEMP_DIR}/objc-modern-getclass-proto.mm.tmp.mm
    RUN(TestState.Failed, "%clang_cc1 -E %s -o %t.mm");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x objective-c++ -fblocks -fms-extensions -rewrite-objc -fobjc-runtime=macosx-fragile-10.5 ${TEST_TEMP_DIR}/objc-modern-getclass-proto.mm.tmp.mm -o ${TEST_TEMP_DIR}/objc-modern-getclass-proto.mm.tmp-rw.cpp
    RUN(TestState.Failed, "%clang_cc1 -x objective-c++ -fblocks -fms-extensions -rewrite-objc -fobjc-runtime=macosx-fragile-10.5 %t.mm -o %t-rw.cpp");
  }

  @Test
  public void test_objc_modern_implicit_cast_mm() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Rewriter/objc-modern-implicit-cast.mm");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x objective-c++ -fblocks -fms-extensions -rewrite-objc ${LLVM_SRC}/llvm/tools/clang/test/Rewriter/objc-modern-implicit-cast.mm -o ${TEST_TEMP_DIR}/objc-modern-implicit-cast.mm.tmp-rw.cpp
    RUN(TestState.Failed, "%clang_cc1 -x objective-c++ -fblocks -fms-extensions -rewrite-objc %s -o %t-rw.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -fblocks -Wno-address-of-temporary '-D"Class=void*"' '-D"id=void*"' '-D"SEL=void*"' '-D"__declspec(X)="' ${TEST_TEMP_DIR}/objc-modern-implicit-cast.mm.tmp-rw.cpp
    RUN(TestState.Failed, "%clang_cc1 -fsyntax-only -fblocks -Wno-address-of-temporary -D\"Class=void*\" -D\"id=void*\" -D\"SEL=void*\" -D\"__declspec(X)=\" %t-rw.cpp");
  }

  @Test
  public void test_objc_modern_ivar_receiver_1_mm() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Rewriter/objc-modern-ivar-receiver-1.mm");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -E ${LLVM_SRC}/llvm/tools/clang/test/Rewriter/objc-modern-ivar-receiver-1.mm -o ${TEST_TEMP_DIR}/objc-modern-ivar-receiver-1.mm.tmp.mm
    RUN(TestState.Failed, "%clang_cc1 -E %s -o %t.mm");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x objective-c++ -fblocks -fms-extensions -rewrite-objc ${TEST_TEMP_DIR}/objc-modern-ivar-receiver-1.mm.tmp.mm -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Rewriter/objc-modern-ivar-receiver-1.mm
    RUN(TestState.Failed, "%clang_cc1 -x objective-c++ -fblocks -fms-extensions -rewrite-objc %t.mm -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_objc_modern_linkage_spec_mm() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Rewriter/objc-modern-linkage-spec.mm");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x objective-c++ -fms-extensions -rewrite-objc ${LLVM_SRC}/llvm/tools/clang/test/Rewriter/objc-modern-linkage-spec.mm -o ${TEST_TEMP_DIR}/objc-modern-linkage-spec.mm.tmp-rw.cpp
    RUN(TestState.Failed, "%clang_cc1 -x objective-c++ -fms-extensions -rewrite-objc %s -o %t-rw.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -Wno-attributes '-D"__declspec(X)="' ${TEST_TEMP_DIR}/objc-modern-linkage-spec.mm.tmp-rw.cpp
    RUN(TestState.Failed, "%clang_cc1 -fsyntax-only -Wno-attributes -D\"__declspec(X)=\" %t-rw.cpp");
  }

  @Test
  public void test_objc_modern_metadata_visibility_mm() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Rewriter/objc-modern-metadata-visibility.mm");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -E ${LLVM_SRC}/llvm/tools/clang/test/Rewriter/objc-modern-metadata-visibility.mm -o ${TEST_TEMP_DIR}/objc-modern-metadata-visibility.mm.tmp.mm
    RUN(TestState.Failed, "%clang_cc1 -E %s -o %t.mm");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x objective-c++ -fblocks -fms-extensions -rewrite-objc ${TEST_TEMP_DIR}/objc-modern-metadata-visibility.mm.tmp.mm -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Rewriter/objc-modern-metadata-visibility.mm
    RUN(TestState.Failed, "%clang_cc1 -x objective-c++ -fblocks -fms-extensions -rewrite-objc %t.mm -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_objc_modern_numeric_literal_mm() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Rewriter/objc-modern-numeric-literal.mm");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -E ${LLVM_SRC}/llvm/tools/clang/test/Rewriter/objc-modern-numeric-literal.mm -o ${TEST_TEMP_DIR}/objc-modern-numeric-literal.mm.tmp.mm
    RUN(TestState.Failed, "%clang_cc1 -E %s -o %t.mm");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x objective-c++ -fblocks -fms-extensions -rewrite-objc ${TEST_TEMP_DIR}/objc-modern-numeric-literal.mm.tmp.mm -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Rewriter/objc-modern-numeric-literal.mm
    RUN(TestState.Failed, "%clang_cc1 -x objective-c++ -fblocks -fms-extensions -rewrite-objc %t.mm -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_objc_modern_property_attributes_mm() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Rewriter/objc-modern-property-attributes.mm");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -E ${LLVM_SRC}/llvm/tools/clang/test/Rewriter/objc-modern-property-attributes.mm -o ${TEST_TEMP_DIR}/objc-modern-property-attributes.mm.tmp.mm
    RUN(TestState.Failed, "%clang_cc1 -E %s -o %t.mm");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x objective-c++ -fblocks -fms-extensions -rewrite-objc ${TEST_TEMP_DIR}/objc-modern-property-attributes.mm.tmp.mm -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Rewriter/objc-modern-property-attributes.mm
    RUN(TestState.Failed, "%clang_cc1 -x objective-c++ -fblocks -fms-extensions -rewrite-objc %t.mm -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_objc_modern_property_bitfield_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Rewriter/objc-modern-property-bitfield.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x objective-c++ -Wno-return-type -fms-extensions -rewrite-objc ${LLVM_SRC}/llvm/tools/clang/test/Rewriter/objc-modern-property-bitfield.m -o ${TEST_TEMP_DIR}/objc-modern-property-bitfield.m.tmp-modern-rw.cpp
    RUN(TestState.Failed, "%clang_cc1 -x objective-c++ -Wno-return-type -fms-extensions -rewrite-objc %s -o %t-modern-rw.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -Wno-address-of-temporary '-D"Class=void*"' '-D"id=void*"' '-D"SEL=void*"' '-D"__declspec(X)="' ${TEST_TEMP_DIR}/objc-modern-property-bitfield.m.tmp-modern-rw.cpp
    RUN(TestState.Failed, "%clang_cc1 -fsyntax-only -Wno-address-of-temporary -D\"Class=void*\" -D\"id=void*\" -D\"SEL=void*\" -D\"__declspec(X)=\" %t-modern-rw.cpp");
  }

  @Test
  public void test_objc_string_concat_1_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Rewriter/objc-string-concat-1.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -rewrite-objc -fobjc-runtime=macosx-fragile-10.5 ${LLVM_SRC}/llvm/tools/clang/test/Rewriter/objc-string-concat-1.m -o -
    RUN(TestState.Failed, "%clang_cc1 -rewrite-objc -fobjc-runtime=macosx-fragile-10.5  %s -o -");
  }

  @Test
  public void test_objc_super_test_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Rewriter/objc-super-test.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -rewrite-objc -fobjc-runtime=macosx-fragile-10.5 ${LLVM_SRC}/llvm/tools/clang/test/Rewriter/objc-super-test.m -o - | grep objc_msgSendSuper | grep MainMethod
    RUN(TestState.Failed, "%clang_cc1 -rewrite-objc -fobjc-runtime=macosx-fragile-10.5  %s -o -")./*|*/
      I("grep objc_msgSendSuper")./*|*/
      I("grep MainMethod");
  }

  @Test
  public void test_objc_synchronized_1_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Rewriter/objc-synchronized-1.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -rewrite-objc -fobjc-runtime=macosx-fragile-10.5 ${LLVM_SRC}/llvm/tools/clang/test/Rewriter/objc-synchronized-1.m -o -
    RUN(TestState.Failed, "%clang_cc1 -rewrite-objc -fobjc-runtime=macosx-fragile-10.5  %s -o -");
  }

  @Test
  public void test_properties_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Rewriter/properties.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i686-pc-windows -x objective-c -Wno-return-type -fblocks -fms-extensions -rewrite-objc -fobjc-runtime=macosx-fragile-10.5 ${LLVM_SRC}/llvm/tools/clang/test/Rewriter/properties.m -o ${TEST_TEMP_DIR}/properties.m.tmp-rw.cpp
    RUN(TestState.Failed, "%clang_cc1 -triple i686-pc-windows -x objective-c -Wno-return-type -fblocks -fms-extensions -rewrite-objc -fobjc-runtime=macosx-fragile-10.5  %s -o %t-rw.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i686-pc-windows -fsyntax-only -fms-extensions -Wno-address-of-temporary '-Did="void *"' '-D"SEL=void*"' '-D"__declspec(X)="' ${TEST_TEMP_DIR}/properties.m.tmp-rw.cpp
    RUN(TestState.Failed, "%clang_cc1 -triple i686-pc-windows -fsyntax-only -fms-extensions -Wno-address-of-temporary -Did=\"void *\" -D\"SEL=void*\" -D\"__declspec(X)=\" %t-rw.cpp");
  }

  @Test
  public void test_property_dot_syntax_mm() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Rewriter/property-dot-syntax.mm");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x objective-c++ -Wno-return-type -fblocks -fms-extensions -rewrite-objc -fobjc-runtime=macosx-fragile-10.5 ${LLVM_SRC}/llvm/tools/clang/test/Rewriter/property-dot-syntax.mm -o ${TEST_TEMP_DIR}/property-dot-syntax.mm.tmp-rw.cpp
    RUN(TestState.Failed, "%clang_cc1 -x objective-c++ -Wno-return-type -fblocks -fms-extensions -rewrite-objc -fobjc-runtime=macosx-fragile-10.5 %s -o %t-rw.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -fblocks -Wno-address-of-temporary '-D"id=void*"' '-D"SEL=void*"' '-D"__declspec(X)="' ${TEST_TEMP_DIR}/property-dot-syntax.mm.tmp-rw.cpp
    RUN(TestState.Failed, "%clang_cc1 -fsyntax-only -fblocks -Wno-address-of-temporary -D\"id=void*\" -D\"SEL=void*\" -D\"__declspec(X)=\" %t-rw.cpp");
  }

  @Test
  public void test_protocol_rewrite_1_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Rewriter/protocol-rewrite-1.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x objective-c -Wno-objc-root-class -fms-extensions -rewrite-objc ${LLVM_SRC}/llvm/tools/clang/test/Rewriter/protocol-rewrite-1.m -o ${TEST_TEMP_DIR}/protocol-rewrite-1.m.tmp-rw.cpp
    RUN(TestState.Failed, "%clang_cc1 -x objective-c -Wno-objc-root-class -fms-extensions -rewrite-objc %s -o %t-rw.cpp");
    // ${LLVM_SRC}/build/bin/FileCheck '--input-file=${TEST_TEMP_DIR}/protocol-rewrite-1.m.tmp-rw.cpp' ${LLVM_SRC}/llvm/tools/clang/test/Rewriter/protocol-rewrite-1.m
    RUN(TestState.Failed, "FileCheck  --input-file=%t-rw.cpp %s");
  }

  @Test
  public void test_protocol_rewrite_2_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Rewriter/protocol-rewrite-2.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -rewrite-objc -fobjc-runtime=macosx-fragile-10.5 ${LLVM_SRC}/llvm/tools/clang/test/Rewriter/protocol-rewrite-2.m -o ${TEST_TEMP_DIR}/protocol-rewrite-2.m.tmp.cpp
    RUN(TestState.Failed, "%clang_cc1 -rewrite-objc -fobjc-runtime=macosx-fragile-10.5  %s -o %t.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only ${TEST_TEMP_DIR}/protocol-rewrite-2.m.tmp.cpp
    RUN(TestState.Failed, "%clang_cc1 -fsyntax-only %t.cpp");
  }

  @Test
  public void test_rewrite_anonymous_union_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Rewriter/rewrite-anonymous-union.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -rewrite-objc -fobjc-runtime=macosx-fragile-10.5 -o - ${LLVM_SRC}/llvm/tools/clang/test/Rewriter/rewrite-anonymous-union.m
    RUN(TestState.Failed, "%clang_cc1 -rewrite-objc -fobjc-runtime=macosx-fragile-10.5  -o - %s");
  }

  @Test
  public void test_rewrite_api_bug_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Rewriter/rewrite-api-bug.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -rewrite-objc -fobjc-runtime=macosx-fragile-10.5 ${LLVM_SRC}/llvm/tools/clang/test/Rewriter/rewrite-api-bug.m -o -
    RUN(TestState.Failed, "%clang_cc1 -rewrite-objc -fobjc-runtime=macosx-fragile-10.5  %s -o -");
  }

  @Test
  public void test_rewrite_block_argument_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Rewriter/rewrite-block-argument.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x objective-c -Wno-return-type -fblocks -fms-extensions -rewrite-objc -fobjc-runtime=macosx-fragile-10.5 ${LLVM_SRC}/llvm/tools/clang/test/Rewriter/rewrite-block-argument.m -o ${TEST_TEMP_DIR}/rewrite-block-argument.m.tmp-rw.cpp
    RUN(TestState.Failed, "%clang_cc1 -x objective-c -Wno-return-type -fblocks -fms-extensions -rewrite-objc -fobjc-runtime=macosx-fragile-10.5  %s -o %t-rw.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -Wno-address-of-temporary '-Did="void *"' '-D"SEL=void*"' '-D"__declspec(X)="' -emit-llvm -o ${TEST_TEMP_DIR}/rewrite-block-argument.m.tmp ${TEST_TEMP_DIR}/rewrite-block-argument.m.tmp-rw.cpp
    RUN(TestState.Failed, "%clang_cc1 -Wno-address-of-temporary -Did=\"void *\" -D\"SEL=void*\" -D\"__declspec(X)=\" -emit-llvm -o %t %t-rw.cpp");
  }

  @Test
  public void test_rewrite_block_consts_mm() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Rewriter/rewrite-block-consts.mm");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x objective-c++ -Wno-return-type -fblocks -fms-extensions -rewrite-objc -fobjc-runtime=macosx-fragile-10.5 ${LLVM_SRC}/llvm/tools/clang/test/Rewriter/rewrite-block-consts.mm -o ${TEST_TEMP_DIR}/rewrite-block-consts.mm.tmp-rw.cpp
    RUN(TestState.Failed, "%clang_cc1 -x objective-c++ -Wno-return-type -fblocks -fms-extensions -rewrite-objc -fobjc-runtime=macosx-fragile-10.5 %s -o %t-rw.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -Wno-address-of-temporary '-D__block=""' '-D"SEL=void*"' '-D"__declspec(X)="' ${TEST_TEMP_DIR}/rewrite-block-consts.mm.tmp-rw.cpp
    RUN(TestState.Failed, "%clang_cc1 -fsyntax-only -Wno-address-of-temporary -D__block=\"\" -D\"SEL=void*\" -D\"__declspec(X)=\" %t-rw.cpp");
  }

  @Test
  public void test_rewrite_block_ivar_call_mm() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Rewriter/rewrite-block-ivar-call.mm");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x objective-c++ -fblocks -rewrite-objc -fobjc-runtime=macosx-fragile-10.5 -o - ${LLVM_SRC}/llvm/tools/clang/test/Rewriter/rewrite-block-ivar-call.mm
    RUN(TestState.Failed, "%clang_cc1 -x objective-c++ -fblocks -rewrite-objc -fobjc-runtime=macosx-fragile-10.5 -o - %s");
  }

  @Test
  public void test_rewrite_block_literal_mm() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Rewriter/rewrite-block-literal.mm");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -E ${LLVM_SRC}/llvm/tools/clang/test/Rewriter/rewrite-block-literal.mm -o ${TEST_TEMP_DIR}/rewrite-block-literal.mm.tmp.mm
    RUN(TestState.Failed, "%clang_cc1 -E %s -o %t.mm");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x objective-c++ -fblocks -fms-extensions -rewrite-objc ${TEST_TEMP_DIR}/rewrite-block-literal.mm.tmp.mm -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Rewriter/rewrite-block-literal.mm
    RUN(TestState.Failed, "%clang_cc1 -x objective-c++ -fblocks -fms-extensions -rewrite-objc %t.mm -o -")./*|*/
      I("FileCheck %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x objective-c++ -Wno-return-type -fblocks -fms-extensions -rewrite-objc -fobjc-runtime=macosx-fragile-10.5 ${LLVM_SRC}/llvm/tools/clang/test/Rewriter/rewrite-block-literal.mm -o ${TEST_TEMP_DIR}/rewrite-block-literal.mm.tmp-rw.cpp
    RUN(TestState.Failed, "%clang_cc1 -x objective-c++ -Wno-return-type -fblocks -fms-extensions -rewrite-objc -fobjc-runtime=macosx-fragile-10.5 %s -o %t-rw.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -Wno-address-of-temporary '-D"Class=void*"' '-D"id=void*"' '-D"SEL=void*"' '-D"__declspec(X)="' ${TEST_TEMP_DIR}/rewrite-block-literal.mm.tmp-rw.cpp
    RUN(TestState.Failed, "%clang_cc1 -fsyntax-only -Wno-address-of-temporary -D\"Class=void*\" -D\"id=void*\" -D\"SEL=void*\" -D\"__declspec(X)=\" %t-rw.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x objective-c++ -Wno-return-type -fblocks -fms-extensions -rewrite-objc ${LLVM_SRC}/llvm/tools/clang/test/Rewriter/rewrite-block-literal.mm -o ${TEST_TEMP_DIR}/rewrite-block-literal.mm.tmp-modern-rw.cpp
    RUN(TestState.Failed, "%clang_cc1 -x objective-c++ -Wno-return-type -fblocks -fms-extensions -rewrite-objc %s -o %t-modern-rw.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -Wno-address-of-temporary '-D"Class=void*"' '-D"id=void*"' '-D"SEL=void*"' '-D"__declspec(X)="' ${TEST_TEMP_DIR}/rewrite-block-literal.mm.tmp-modern-rw.cpp
    RUN(TestState.Failed, "%clang_cc1 -fsyntax-only -Wno-address-of-temporary -D\"Class=void*\" -D\"id=void*\" -D\"SEL=void*\" -D\"__declspec(X)=\" %t-modern-rw.cpp");
  }

  @Test
  public void test_rewrite_block_literal_1_mm() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Rewriter/rewrite-block-literal-1.mm");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x objective-c++ -Wno-return-type -fblocks -fms-extensions -rewrite-objc -fobjc-runtime=macosx-fragile-10.5 ${LLVM_SRC}/llvm/tools/clang/test/Rewriter/rewrite-block-literal-1.mm -o ${TEST_TEMP_DIR}/rewrite-block-literal-1.mm.tmp-rw.cpp
    RUN(TestState.Failed, "%clang_cc1 -x objective-c++ -Wno-return-type -fblocks -fms-extensions -rewrite-objc -fobjc-runtime=macosx-fragile-10.5 %s -o %t-rw.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -Wno-address-of-temporary '-Did="void *"' '-D"SEL=void*"' '-D"__declspec(X)="' ${TEST_TEMP_DIR}/rewrite-block-literal-1.mm.tmp-rw.cpp
    RUN(TestState.Failed, "%clang_cc1 -fsyntax-only -Wno-address-of-temporary -Did=\"void *\" -D\"SEL=void*\" -D\"__declspec(X)=\" %t-rw.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x objective-c++ -Wno-return-type -fblocks -fms-extensions -rewrite-objc ${LLVM_SRC}/llvm/tools/clang/test/Rewriter/rewrite-block-literal-1.mm -o ${TEST_TEMP_DIR}/rewrite-block-literal-1.mm.tmp-modern-rw.cpp
    RUN(TestState.Failed, "%clang_cc1 -x objective-c++ -Wno-return-type -fblocks -fms-extensions -rewrite-objc %s -o %t-modern-rw.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -Wno-address-of-temporary '-Did="void *"' '-D"SEL=void*"' '-D"__declspec(X)="' ${TEST_TEMP_DIR}/rewrite-block-literal-1.mm.tmp-modern-rw.cpp
    RUN(TestState.Failed, "%clang_cc1 -fsyntax-only -Wno-address-of-temporary -Did=\"void *\" -D\"SEL=void*\" -D\"__declspec(X)=\" %t-modern-rw.cpp");
  }

  @Test
  public void test_rewrite_block_pointer_mm() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Rewriter/rewrite-block-pointer.mm");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x objective-c++ -Wno-return-type -fblocks -fms-extensions -rewrite-objc -fobjc-runtime=macosx-fragile-10.5 ${LLVM_SRC}/llvm/tools/clang/test/Rewriter/rewrite-block-pointer.mm -o ${TEST_TEMP_DIR}/rewrite-block-pointer.mm.tmp-rw.cpp
    RUN(TestState.Failed, "%clang_cc1 -x objective-c++ -Wno-return-type -fblocks -fms-extensions -rewrite-objc -fobjc-runtime=macosx-fragile-10.5 %s -o %t-rw.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -Wno-address-of-temporary '-D"SEL=void*"' '-D"__declspec(X)="' ${TEST_TEMP_DIR}/rewrite-block-pointer.mm.tmp-rw.cpp
    RUN(TestState.Failed, "%clang_cc1 -fsyntax-only -Wno-address-of-temporary -D\"SEL=void*\" -D\"__declspec(X)=\" %t-rw.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x objective-c++ -Wno-return-type -fblocks -fms-extensions -rewrite-objc ${LLVM_SRC}/llvm/tools/clang/test/Rewriter/rewrite-block-pointer.mm -o ${TEST_TEMP_DIR}/rewrite-block-pointer.mm.tmp-modern-rw.cpp
    RUN(TestState.Failed, "%clang_cc1 -x objective-c++ -Wno-return-type -fblocks -fms-extensions -rewrite-objc %s -o %t-modern-rw.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -Wno-address-of-temporary '-D"SEL=void*"' '-D"__declspec(X)="' ${TEST_TEMP_DIR}/rewrite-block-pointer.mm.tmp-modern-rw.cpp
    RUN(TestState.Failed, "%clang_cc1 -fsyntax-only -Wno-address-of-temporary -D\"SEL=void*\" -D\"__declspec(X)=\" %t-modern-rw.cpp");
  }

  @Test
  public void test_rewrite_block_property_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Rewriter/rewrite-block-property.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x objective-c++ -Wno-return-type -fblocks -fms-extensions -rewrite-objc -fobjc-runtime=macosx-fragile-10.5 ${LLVM_SRC}/llvm/tools/clang/test/Rewriter/rewrite-block-property.m -o ${TEST_TEMP_DIR}/rewrite-block-property.m.tmp-rw.cpp
    RUN(TestState.Failed, "%clang_cc1 -x objective-c++ -Wno-return-type -fblocks -fms-extensions -rewrite-objc -fobjc-runtime=macosx-fragile-10.5  %s -o %t-rw.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -fblocks -Wno-address-of-temporary '-D"id=void*"' '-D"SEL=void*"' '-D"__declspec(X)="' ${TEST_TEMP_DIR}/rewrite-block-property.m.tmp-rw.cpp
    RUN(TestState.Failed, "%clang_cc1 -fsyntax-only -fblocks -Wno-address-of-temporary -D\"id=void*\" -D\"SEL=void*\" -D\"__declspec(X)=\" %t-rw.cpp");
  }

  @Test
  public void test_rewrite_byref_in_nested_blocks_mm() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Rewriter/rewrite-byref-in-nested-blocks.mm");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x objective-c++ -Wno-return-type -fblocks -fms-extensions -rewrite-objc -fobjc-runtime=macosx-fragile-10.5 ${LLVM_SRC}/llvm/tools/clang/test/Rewriter/rewrite-byref-in-nested-blocks.mm -o ${TEST_TEMP_DIR}/rewrite-byref-in-nested-blocks.mm.tmp-rw.cpp
    RUN(TestState.Failed, "%clang_cc1 -x objective-c++ -Wno-return-type -fblocks -fms-extensions -rewrite-objc -fobjc-runtime=macosx-fragile-10.5 %s -o %t-rw.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -fblocks -Wno-address-of-temporary '-D"SEL=void*"' -U__declspec '-D"__declspec(X)="' ${TEST_TEMP_DIR}/rewrite-byref-in-nested-blocks.mm.tmp-rw.cpp
    RUN(TestState.Failed, "%clang_cc1 -fsyntax-only -fblocks -Wno-address-of-temporary -D\"SEL=void*\" -U__declspec -D\"__declspec(X)=\" %t-rw.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x objective-c++ -Wno-return-type -fblocks -fms-extensions -rewrite-objc ${LLVM_SRC}/llvm/tools/clang/test/Rewriter/rewrite-byref-in-nested-blocks.mm -o ${TEST_TEMP_DIR}/rewrite-byref-in-nested-blocks.mm.tmp-modern-rw.cpp
    RUN(TestState.Failed, "%clang_cc1 -x objective-c++ -Wno-return-type -fblocks -fms-extensions -rewrite-objc %s -o %t-modern-rw.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -Werror -Wno-address-of-temporary '-D"SEL=void*"' -U__declspec '-D"__declspec(X)="' ${TEST_TEMP_DIR}/rewrite-byref-in-nested-blocks.mm.tmp-modern-rw.cpp
    RUN(TestState.Failed, "%clang_cc1 -fsyntax-only -Werror -Wno-address-of-temporary -D\"SEL=void*\" -U__declspec  -D\"__declspec(X)=\" %t-modern-rw.cpp");
  }

  @Test
  public void test_rewrite_byref_vars_mm() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Rewriter/rewrite-byref-vars.mm");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x objective-c++ -Wno-return-type -fblocks -fms-extensions -rewrite-objc -fobjc-runtime=macosx-fragile-10.5 ${LLVM_SRC}/llvm/tools/clang/test/Rewriter/rewrite-byref-vars.mm -o ${TEST_TEMP_DIR}/rewrite-byref-vars.mm.tmp-rw.cpp
    RUN(TestState.Failed, "%clang_cc1 -x objective-c++ -Wno-return-type -fblocks -fms-extensions -rewrite-objc -fobjc-runtime=macosx-fragile-10.5 %s -o %t-rw.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -fblocks -Wno-address-of-temporary '-D"id=void*"' '-D"SEL=void*"' '-D"__declspec(X)="' ${TEST_TEMP_DIR}/rewrite-byref-vars.mm.tmp-rw.cpp
    RUN(TestState.Failed, "%clang_cc1 -fsyntax-only -fblocks -Wno-address-of-temporary -D\"id=void*\" -D\"SEL=void*\" -D\"__declspec(X)=\" %t-rw.cpp");
  }

  @Test
  public void test_rewrite_captured_nested_bvar_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Rewriter/rewrite-captured-nested-bvar.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x c -fblocks -fms-extensions -rewrite-objc ${LLVM_SRC}/llvm/tools/clang/test/Rewriter/rewrite-captured-nested-bvar.c -o ${TEST_TEMP_DIR}/rewrite-captured-nested-bvar.c.tmp-rw.cpp
    RUN(TestState.Failed, "%clang_cc1 -x c -fblocks -fms-extensions -rewrite-objc %s -o %t-rw.cpp");
    // ${LLVM_SRC}/build/bin/FileCheck '--input-file=${TEST_TEMP_DIR}/rewrite-captured-nested-bvar.c.tmp-rw.cpp' ${LLVM_SRC}/llvm/tools/clang/test/Rewriter/rewrite-captured-nested-bvar.c
    RUN(TestState.Failed, "FileCheck --input-file=%t-rw.cpp %s");
  }

  @Test
  public void test_rewrite_cast_ivar_access_mm() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Rewriter/rewrite-cast-ivar-access.mm");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x objective-c++ -fblocks -fms-extensions -rewrite-objc -fobjc-runtime=macosx-fragile-10.5 ${LLVM_SRC}/llvm/tools/clang/test/Rewriter/rewrite-cast-ivar-access.mm -o ${TEST_TEMP_DIR}/rewrite-cast-ivar-access.mm.tmp-rw.cpp
    RUN(TestState.Failed, "%clang_cc1 -x objective-c++ -fblocks -fms-extensions -rewrite-objc -fobjc-runtime=macosx-fragile-10.5 %s -o %t-rw.cpp");
    // ${LLVM_SRC}/build/bin/FileCheck -check-prefix CHECK-LP '--input-file=${TEST_TEMP_DIR}/rewrite-cast-ivar-access.mm.tmp-rw.cpp' ${LLVM_SRC}/llvm/tools/clang/test/Rewriter/rewrite-cast-ivar-access.mm
    RUN(TestState.Failed, "FileCheck -check-prefix CHECK-LP --input-file=%t-rw.cpp %s");
  }

  @Test
  public void test_rewrite_cast_ivar_modern_access_mm() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Rewriter/rewrite-cast-ivar-modern-access.mm");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x objective-c++ -fblocks -fms-extensions -rewrite-objc ${LLVM_SRC}/llvm/tools/clang/test/Rewriter/rewrite-cast-ivar-modern-access.mm -o ${TEST_TEMP_DIR}/rewrite-cast-ivar-modern-access.mm.tmp-rw.cpp
    RUN(TestState.Failed, "%clang_cc1 -x objective-c++ -fblocks -fms-extensions -rewrite-objc %s -o %t-rw.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -fblocks -Wno-address-of-temporary '-D"Class=void*"' '-D"id=void*"' '-D"SEL=void*"' '-D"__declspec(X)="' ${TEST_TEMP_DIR}/rewrite-cast-ivar-modern-access.mm.tmp-rw.cpp
    RUN(TestState.Failed, "%clang_cc1 -fsyntax-only -fblocks -Wno-address-of-temporary -D\"Class=void*\" -D\"id=void*\" -D\"SEL=void*\" -D\"__declspec(X)=\" %t-rw.cpp");
  }

  @Test
  public void test_rewrite_cast_to_bool_mm() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Rewriter/rewrite-cast-to-bool.mm");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x objective-c++ -Wno-return-type -fblocks -fms-extensions -rewrite-objc -fobjc-runtime=macosx-fragile-10.5 ${LLVM_SRC}/llvm/tools/clang/test/Rewriter/rewrite-cast-to-bool.mm -o ${TEST_TEMP_DIR}/rewrite-cast-to-bool.mm.tmp-rw.cpp
    RUN(TestState.Failed, "%clang_cc1 -x objective-c++ -Wno-return-type -fblocks -fms-extensions -rewrite-objc -fobjc-runtime=macosx-fragile-10.5 %s -o %t-rw.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -fblocks -Wno-address-of-temporary '-D"id=void*"' '-D"SEL=void*"' '-D"__declspec(X)="' ${TEST_TEMP_DIR}/rewrite-cast-to-bool.mm.tmp-rw.cpp
    RUN(TestState.Failed, "%clang_cc1 -fsyntax-only -fblocks -Wno-address-of-temporary -D\"id=void*\" -D\"SEL=void*\" -D\"__declspec(X)=\" %t-rw.cpp");
  }

  @Test
  public void test_rewrite_category_property_mm() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Rewriter/rewrite-category-property.mm");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x objective-c++ -fms-extensions -rewrite-objc -fobjc-runtime=macosx-fragile-10.5 ${LLVM_SRC}/llvm/tools/clang/test/Rewriter/rewrite-category-property.mm -o ${TEST_TEMP_DIR}/rewrite-category-property.mm.tmp-rw.cpp
    RUN(TestState.Failed, "%clang_cc1 -x objective-c++ -fms-extensions -rewrite-objc -fobjc-runtime=macosx-fragile-10.5 %s -o %t-rw.cpp");
    // ${LLVM_SRC}/build/bin/FileCheck -check-prefix CHECK-LP '--input-file=${TEST_TEMP_DIR}/rewrite-category-property.mm.tmp-rw.cpp' ${LLVM_SRC}/llvm/tools/clang/test/Rewriter/rewrite-category-property.mm
    RUN(TestState.Failed, "FileCheck -check-prefix CHECK-LP --input-file=%t-rw.cpp %s");
  }

  @Test
  public void test_rewrite_constructor_init_mm() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Rewriter/rewrite-constructor-init.mm");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x objective-c++ -Wno-return-type -fblocks -fms-extensions -rewrite-objc -fobjc-runtime=macosx-fragile-10.5 ${LLVM_SRC}/llvm/tools/clang/test/Rewriter/rewrite-constructor-init.mm -o ${TEST_TEMP_DIR}/rewrite-constructor-init.mm.tmp-rw.cpp
    RUN(TestState.Failed, "%clang_cc1 -x objective-c++ -Wno-return-type -fblocks -fms-extensions -rewrite-objc -fobjc-runtime=macosx-fragile-10.5 %s -o %t-rw.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -fblocks -Wno-address-of-temporary '-D"SEL=void*"' '-D"__declspec(X)="' ${TEST_TEMP_DIR}/rewrite-constructor-init.mm.tmp-rw.cpp
    RUN(TestState.Failed, "%clang_cc1 -fsyntax-only -fblocks -Wno-address-of-temporary -D\"SEL=void*\" -D\"__declspec(X)=\" %t-rw.cpp");
  }

  @Test
  public void test_rewrite_eh_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Rewriter/rewrite-eh.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -rewrite-objc -fobjc-runtime=macosx-fragile-10.5 -fobjc-exceptions -o - ${LLVM_SRC}/llvm/tools/clang/test/Rewriter/rewrite-eh.m
    RUN(TestState.Failed, "%clang_cc1 -rewrite-objc -fobjc-runtime=macosx-fragile-10.5  -fobjc-exceptions -o - %s");
  }

  @Test
  public void test_rewrite_elaborated_type_mm() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Rewriter/rewrite-elaborated-type.mm");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x objective-c++ -Wno-return-type -fms-extensions -rewrite-objc -fobjc-runtime=macosx-fragile-10.5 ${LLVM_SRC}/llvm/tools/clang/test/Rewriter/rewrite-elaborated-type.mm -o ${TEST_TEMP_DIR}/rewrite-elaborated-type.mm.tmp-rw.cpp
    RUN(TestState.Failed, "%clang_cc1 -x objective-c++ -Wno-return-type -fms-extensions -rewrite-objc -fobjc-runtime=macosx-fragile-10.5 %s -o %t-rw.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -Wno-address-of-temporary -D_Bool=bool '-D"id=void*"' '-D"SEL=void*"' '-D"__declspec(X)="' ${TEST_TEMP_DIR}/rewrite-elaborated-type.mm.tmp-rw.cpp
    RUN(TestState.Failed, "%clang_cc1 -fsyntax-only -Wno-address-of-temporary -D_Bool=bool -D\"id=void*\" -D\"SEL=void*\" -D\"__declspec(X)=\" %t-rw.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x objective-c++ -Wno-return-type -fms-extensions -rewrite-objc ${LLVM_SRC}/llvm/tools/clang/test/Rewriter/rewrite-elaborated-type.mm -o ${TEST_TEMP_DIR}/rewrite-elaborated-type.mm.tmp-modern-rw.cpp
    RUN(TestState.Failed, "%clang_cc1 -x objective-c++ -Wno-return-type -fms-extensions -rewrite-objc %s -o %t-modern-rw.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -Wno-address-of-temporary -D_Bool=bool '-D"id=void*"' '-D"SEL=void*"' '-D"__declspec(X)="' ${TEST_TEMP_DIR}/rewrite-elaborated-type.mm.tmp-modern-rw.cpp
    RUN(TestState.Failed, "%clang_cc1 -fsyntax-only -Wno-address-of-temporary -D_Bool=bool -D\"id=void*\" -D\"SEL=void*\" -D\"__declspec(X)=\" %t-modern-rw.cpp");
  }

  @Test
  public void test_rewrite_extern_c_mm() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Rewriter/rewrite-extern-c.mm");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x objective-c++ -fblocks -rewrite-objc -fobjc-runtime=macosx-fragile-10.5 -o - ${LLVM_SRC}/llvm/tools/clang/test/Rewriter/rewrite-extern-c.mm
    RUN(TestState.Failed, "%clang_cc1 -x objective-c++ -fblocks -rewrite-objc -fobjc-runtime=macosx-fragile-10.5 -o - %s");
  }

  @Test
  public void test_rewrite_foreach_1_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Rewriter/rewrite-foreach-1.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -rewrite-objc -fobjc-runtime=macosx-fragile-10.5 ${LLVM_SRC}/llvm/tools/clang/test/Rewriter/rewrite-foreach-1.m -o -
    RUN(TestState.Failed, "%clang_cc1 -rewrite-objc -fobjc-runtime=macosx-fragile-10.5  %s -o -");
  }

  @Test
  public void test_rewrite_foreach_2_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Rewriter/rewrite-foreach-2.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -rewrite-objc -fobjc-runtime=macosx-fragile-10.5 ${LLVM_SRC}/llvm/tools/clang/test/Rewriter/rewrite-foreach-2.m -o -
    RUN(TestState.Failed, "%clang_cc1 -rewrite-objc -fobjc-runtime=macosx-fragile-10.5  %s -o -");
  }

  @Test
  public void test_rewrite_foreach_3_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Rewriter/rewrite-foreach-3.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -rewrite-objc -fobjc-runtime=macosx-fragile-10.5 ${LLVM_SRC}/llvm/tools/clang/test/Rewriter/rewrite-foreach-3.m -o -
    RUN(TestState.Failed, "%clang_cc1 -rewrite-objc -fobjc-runtime=macosx-fragile-10.5  %s -o -");
  }

  @Test
  public void test_rewrite_foreach_4_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Rewriter/rewrite-foreach-4.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -rewrite-objc -fobjc-runtime=macosx-fragile-10.5 ${LLVM_SRC}/llvm/tools/clang/test/Rewriter/rewrite-foreach-4.m -o -
    RUN(TestState.Failed, "%clang_cc1 -rewrite-objc -fobjc-runtime=macosx-fragile-10.5  %s -o -");
  }

  @Test
  public void test_rewrite_foreach_5_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Rewriter/rewrite-foreach-5.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x objective-c++ -Wno-return-type -fblocks -fms-extensions -rewrite-objc -fobjc-runtime=macosx-fragile-10.5 ${LLVM_SRC}/llvm/tools/clang/test/Rewriter/rewrite-foreach-5.m -o ${TEST_TEMP_DIR}/rewrite-foreach-5.m.tmp-rw.cpp
    RUN(TestState.Failed, "%clang_cc1 -x objective-c++ -Wno-return-type -fblocks -fms-extensions -rewrite-objc -fobjc-runtime=macosx-fragile-10.5  %s -o %t-rw.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -fblocks -Wno-address-of-temporary '-D"id=struct objc_object*"' '-D"SEL=void*"' '-D"__declspec(X)="' ${TEST_TEMP_DIR}/rewrite-foreach-5.m.tmp-rw.cpp
    RUN(TestState.Failed, "%clang_cc1 -fsyntax-only -fblocks -Wno-address-of-temporary -D\"id=struct objc_object*\" -D\"SEL=void*\" -D\"__declspec(X)=\" %t-rw.cpp");
  }

  @Test
  public void test_rewrite_foreach_6_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Rewriter/rewrite-foreach-6.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x objective-c++ -Wno-return-type -fblocks -fms-extensions -rewrite-objc -fobjc-runtime=macosx-fragile-10.5 ${LLVM_SRC}/llvm/tools/clang/test/Rewriter/rewrite-foreach-6.m -o ${TEST_TEMP_DIR}/rewrite-foreach-6.m.tmp-rw.cpp
    RUN(TestState.Failed, "%clang_cc1 -x objective-c++ -Wno-return-type -fblocks -fms-extensions -rewrite-objc -fobjc-runtime=macosx-fragile-10.5  %s -o %t-rw.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -fblocks -Wno-address-of-temporary '-D"id=struct objc_object*"' '-D"SEL=void*"' '-D"__declspec(X)="' ${TEST_TEMP_DIR}/rewrite-foreach-6.m.tmp-rw.cpp
    RUN(TestState.Failed, "%clang_cc1 -fsyntax-only -fblocks -Wno-address-of-temporary -D\"id=struct objc_object*\" -D\"SEL=void*\" -D\"__declspec(X)=\" %t-rw.cpp");
  }

  @Test
  public void test_rewrite_foreach_7_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Rewriter/rewrite-foreach-7.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -rewrite-objc -fobjc-runtime=macosx-fragile-10.5 ${LLVM_SRC}/llvm/tools/clang/test/Rewriter/rewrite-foreach-7.m -o -
    RUN(TestState.Failed, "%clang_cc1 -rewrite-objc -fobjc-runtime=macosx-fragile-10.5  %s -o -");
  }

  @Test
  public void test_rewrite_foreach_in_block_mm() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Rewriter/rewrite-foreach-in-block.mm");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x objective-c++ -Wno-return-type -fblocks -fms-extensions -rewrite-objc -fobjc-runtime=macosx-fragile-10.5 ${LLVM_SRC}/llvm/tools/clang/test/Rewriter/rewrite-foreach-in-block.mm -o ${TEST_TEMP_DIR}/rewrite-foreach-in-block.mm.tmp-rw.cpp
    RUN(TestState.Failed, "%clang_cc1 -x objective-c++ -Wno-return-type -fblocks -fms-extensions -rewrite-objc -fobjc-runtime=macosx-fragile-10.5 %s -o %t-rw.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -Wno-address-of-temporary '-D"id=struct objc_object*"' '-D"SEL=void*"' '-D"__declspec(X)="' ${TEST_TEMP_DIR}/rewrite-foreach-in-block.mm.tmp-rw.cpp
    RUN(TestState.Failed, "%clang_cc1 -fsyntax-only -Wno-address-of-temporary -D\"id=struct objc_object*\" -D\"SEL=void*\" -D\"__declspec(X)=\" %t-rw.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x objective-c++ -Wno-return-type -fblocks -fms-extensions -rewrite-objc ${LLVM_SRC}/llvm/tools/clang/test/Rewriter/rewrite-foreach-in-block.mm -o ${TEST_TEMP_DIR}/rewrite-foreach-in-block.mm.tmp-modern-rw.cpp
    RUN(TestState.Failed, "%clang_cc1 -x objective-c++ -Wno-return-type -fblocks -fms-extensions -rewrite-objc %s -o %t-modern-rw.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -Wno-address-of-temporary '-D"id=struct objc_object*"' '-D"SEL=void*"' '-D"__declspec(X)="' ${TEST_TEMP_DIR}/rewrite-foreach-in-block.mm.tmp-modern-rw.cpp
    RUN(TestState.Failed, "%clang_cc1 -fsyntax-only -Wno-address-of-temporary -D\"id=struct objc_object*\" -D\"SEL=void*\" -D\"__declspec(X)=\" %t-modern-rw.cpp");
  }

  @Test
  public void test_rewrite_foreach_protocol_id_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Rewriter/rewrite-foreach-protocol-id.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x objective-c++ -Wno-return-type -fblocks -fms-extensions -rewrite-objc -fobjc-runtime=macosx-fragile-10.5 ${LLVM_SRC}/llvm/tools/clang/test/Rewriter/rewrite-foreach-protocol-id.m -o ${TEST_TEMP_DIR}/rewrite-foreach-protocol-id.m.tmp-rw.cpp
    RUN(TestState.Failed, "%clang_cc1 -x objective-c++ -Wno-return-type -fblocks -fms-extensions -rewrite-objc -fobjc-runtime=macosx-fragile-10.5  %s -o %t-rw.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -fblocks -Wno-address-of-temporary '-D"id=struct objc_object*"' '-D"SEL=void*"' '-D"__declspec(X)="' ${TEST_TEMP_DIR}/rewrite-foreach-protocol-id.m.tmp-rw.cpp
    RUN(TestState.Failed, "%clang_cc1 -fsyntax-only -fblocks -Wno-address-of-temporary -D\"id=struct objc_object*\" -D\"SEL=void*\" -D\"__declspec(X)=\" %t-rw.cpp");
  }

  @Test
  public void test_rewrite_forward_class_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Rewriter/rewrite-forward-class.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x objective-c -Wno-return-type -fblocks -fms-extensions -rewrite-objc -fobjc-runtime=macosx-fragile-10.5 ${LLVM_SRC}/llvm/tools/clang/test/Rewriter/rewrite-forward-class.m -o ${TEST_TEMP_DIR}/rewrite-forward-class.m.tmp-rw.cpp
    RUN(TestState.Failed, "%clang_cc1 -x objective-c -Wno-return-type -fblocks -fms-extensions -rewrite-objc -fobjc-runtime=macosx-fragile-10.5  %s -o %t-rw.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -fblocks -Wno-address-of-temporary '-D"id=void*"' '-D"SEL=void*"' '-D"__declspec(X)="' ${TEST_TEMP_DIR}/rewrite-forward-class.m.tmp-rw.cpp
    RUN(TestState.Failed, "%clang_cc1 -fsyntax-only -fblocks -Wno-address-of-temporary -D\"id=void*\" -D\"SEL=void*\" -D\"__declspec(X)=\" %t-rw.cpp");
  }

  @Test
  public void test_rewrite_forward_class_mm() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Rewriter/rewrite-forward-class.mm");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x objective-c++ -Wno-return-type -fblocks -fms-extensions -rewrite-objc ${LLVM_SRC}/llvm/tools/clang/test/Rewriter/rewrite-forward-class.mm -o ${TEST_TEMP_DIR}/rewrite-forward-class.mm.tmp-rw.cpp
    RUN(TestState.Failed, "%clang_cc1 -x objective-c++ -Wno-return-type -fblocks -fms-extensions -rewrite-objc %s -o %t-rw.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -fblocks -Wno-address-of-temporary '-D"id=void*"' '-D"SEL=void*"' '-D"__declspec(X)="' ${TEST_TEMP_DIR}/rewrite-forward-class.mm.tmp-rw.cpp
    RUN(TestState.Failed, "%clang_cc1 -fsyntax-only -fblocks -Wno-address-of-temporary -D\"id=void*\" -D\"SEL=void*\" -D\"__declspec(X)=\" %t-rw.cpp");
  }

  @Test
  public void test_rewrite_function_decl_mm() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Rewriter/rewrite-function-decl.mm");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fms-extensions -rewrite-objc -fobjc-runtime=macosx-fragile-10.5 -x objective-c++ -fblocks -o - ${LLVM_SRC}/llvm/tools/clang/test/Rewriter/rewrite-function-decl.mm
    RUN(TestState.Failed, "%clang_cc1 -fms-extensions -rewrite-objc -fobjc-runtime=macosx-fragile-10.5 -x objective-c++ -fblocks -o - %s");
  }

  @Test
  public void test_rewrite_implementation_mm() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Rewriter/rewrite-implementation.mm");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x objective-c++ -fblocks -fms-extensions -rewrite-objc -fobjc-runtime=macosx-fragile-10.5 ${LLVM_SRC}/llvm/tools/clang/test/Rewriter/rewrite-implementation.mm -o ${TEST_TEMP_DIR}/rewrite-implementation.mm.tmp-rw.cpp
    RUN(TestState.Failed, "%clang_cc1 -x objective-c++ -fblocks -fms-extensions -rewrite-objc -fobjc-runtime=macosx-fragile-10.5 %s -o %t-rw.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -Wno-address-of-temporary '-D"SEL=void*"' '-D"__declspec(X)="' ${TEST_TEMP_DIR}/rewrite-implementation.mm.tmp-rw.cpp
    RUN(TestState.Failed, "%clang_cc1 -fsyntax-only -Wno-address-of-temporary -D\"SEL=void*\" -D\"__declspec(X)=\" %t-rw.cpp");
  }

  @Test
  public void test_rewrite_interface_locals_mm() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Rewriter/rewrite-interface-locals.mm");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x objective-c++ -fblocks -fms-extensions -rewrite-objc ${LLVM_SRC}/llvm/tools/clang/test/Rewriter/rewrite-interface-locals.mm -o ${TEST_TEMP_DIR}/rewrite-interface-locals.mm.tmp-rw.cpp
    RUN(TestState.Failed, "%clang_cc1 -x objective-c++ -fblocks -fms-extensions -rewrite-objc %s -o %t-rw.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -fblocks -Wno-address-of-temporary '-D"Class=void*"' '-D"id=void*"' '-D"SEL=void*"' '-D"__declspec(X)="' ${TEST_TEMP_DIR}/rewrite-interface-locals.mm.tmp-rw.cpp
    RUN(TestState.Failed, "%clang_cc1 -fsyntax-only -fblocks -Wno-address-of-temporary -D\"Class=void*\" -D\"id=void*\" -D\"SEL=void*\" -D\"__declspec(X)=\" %t-rw.cpp");
  }

  @Test
  public void test_rewrite_ivar_use_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Rewriter/rewrite-ivar-use.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x objective-c++ -Wno-return-type -fblocks -fms-extensions -rewrite-objc -fobjc-runtime=macosx-fragile-10.5 ${LLVM_SRC}/llvm/tools/clang/test/Rewriter/rewrite-ivar-use.m -o ${TEST_TEMP_DIR}/rewrite-ivar-use.m.tmp-rw.cpp
    RUN(TestState.Failed, "%clang_cc1 -x objective-c++ -Wno-return-type -fblocks -fms-extensions -rewrite-objc -fobjc-runtime=macosx-fragile-10.5 %s -o %t-rw.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -fblocks -Wno-address-of-temporary '-D"Class=void*"' '-D"id=void*"' '-D"SEL=void*"' '-D"__declspec(X)="' ${TEST_TEMP_DIR}/rewrite-ivar-use.m.tmp-rw.cpp
    RUN(TestState.Failed, "%clang_cc1 -fsyntax-only -fblocks -Wno-address-of-temporary -D\"Class=void*\" -D\"id=void*\" -D\"SEL=void*\" -D\"__declspec(X)=\" %t-rw.cpp");
  }

  @Test
  public void test_rewrite_line_directive_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Rewriter/rewrite-line-directive.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -E ${LLVM_SRC}/llvm/tools/clang/test/Rewriter/rewrite-line-directive.m -o ${TEST_TEMP_DIR}/rewrite-line-directive.m.tmp.mm
    RUN(TestState.Failed, "%clang_cc1 -E %s -o %t.mm");
    // ${LLVM_SRC}/build/bin/clang -fms-extensions -rewrite-objc ${TEST_TEMP_DIR}/rewrite-line-directive.m.tmp.mm -o ${TEST_TEMP_DIR}/rewrite-line-directive.m.tmp-rw.cpp
    RUN(TestState.Failed, "%clang -fms-extensions -rewrite-objc %t.mm -o %t-rw.cpp");
    // ${LLVM_SRC}/build/bin/FileCheck -check-prefix CHECK-LP '--input-file=${TEST_TEMP_DIR}/rewrite-line-directive.m.tmp-rw.cpp' ${LLVM_SRC}/llvm/tools/clang/test/Rewriter/rewrite-line-directive.m
    RUN(TestState.Failed, "FileCheck -check-prefix CHECK-LP --input-file=%t-rw.cpp %s");
    // ${LLVM_SRC}/build/bin/clang -g -fms-extensions -rewrite-objc ${TEST_TEMP_DIR}/rewrite-line-directive.m.tmp.mm -o ${TEST_TEMP_DIR}/rewrite-line-directive.m.tmp-rw.cpp
    RUN(TestState.Failed, "%clang -g -fms-extensions -rewrite-objc %t.mm -o %t-rw.cpp");
    // ${LLVM_SRC}/build/bin/FileCheck -check-prefix CHECK-LPG '--input-file=${TEST_TEMP_DIR}/rewrite-line-directive.m.tmp-rw.cpp' ${LLVM_SRC}/llvm/tools/clang/test/Rewriter/rewrite-line-directive.m
    RUN(TestState.Failed, "FileCheck -check-prefix CHECK-LPG --input-file=%t-rw.cpp %s");
  }

  @Test
  public void test_rewrite_local_externs_in_block_mm() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Rewriter/rewrite-local-externs-in-block.mm");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x objective-c++ -Wno-return-type -fblocks -fms-extensions -rewrite-objc -fobjc-runtime=macosx-fragile-10.5 ${LLVM_SRC}/llvm/tools/clang/test/Rewriter/rewrite-local-externs-in-block.mm -o ${TEST_TEMP_DIR}/rewrite-local-externs-in-block.mm.tmp-rw.cpp
    RUN(TestState.Failed, "%clang_cc1 -x objective-c++ -Wno-return-type -fblocks -fms-extensions -rewrite-objc -fobjc-runtime=macosx-fragile-10.5 %s -o %t-rw.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -Wno-address-of-temporary '-D"SEL=void*"' '-D"__declspec(X)="' ${TEST_TEMP_DIR}/rewrite-local-externs-in-block.mm.tmp-rw.cpp
    RUN(TestState.Failed, "%clang_cc1 -fsyntax-only -Wno-address-of-temporary -D\"SEL=void*\" -D\"__declspec(X)=\" %t-rw.cpp");
  }

  @Test
  public void test_rewrite_local_static_id_mm() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Rewriter/rewrite-local-static-id.mm");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x objective-c++ -Wno-return-type -fblocks -fms-extensions -rewrite-objc -fobjc-runtime=macosx-fragile-10.5 ${LLVM_SRC}/llvm/tools/clang/test/Rewriter/rewrite-local-static-id.mm -o ${TEST_TEMP_DIR}/rewrite-local-static-id.mm.tmp-rw.cpp
    RUN(TestState.Failed, "%clang_cc1 -x objective-c++ -Wno-return-type -fblocks -fms-extensions -rewrite-objc -fobjc-runtime=macosx-fragile-10.5 %s -o %t-rw.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -Wno-address-of-temporary '-Did="void *"' '-D"SEL=void*"' '-D"__declspec(X)="' -emit-llvm -o ${TEST_TEMP_DIR}/rewrite-local-static-id.mm.tmp ${TEST_TEMP_DIR}/rewrite-local-static-id.mm.tmp-rw.cpp
    RUN(TestState.Failed, "%clang_cc1 -Wno-address-of-temporary -Did=\"void *\" -D\"SEL=void*\" -D\"__declspec(X)=\" -emit-llvm -o %t %t-rw.cpp");
  }

  @Test
  public void test_rewrite_message_expr_mm() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Rewriter/rewrite-message-expr.mm");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x objective-c++ -fblocks -fms-extensions -rewrite-objc -fobjc-runtime=macosx-fragile-10.5 ${LLVM_SRC}/llvm/tools/clang/test/Rewriter/rewrite-message-expr.mm -o ${TEST_TEMP_DIR}/rewrite-message-expr.mm.tmp-rw.cpp
    RUN(TestState.Failed, "%clang_cc1 -x objective-c++ -fblocks -fms-extensions -rewrite-objc -fobjc-runtime=macosx-fragile-10.5 %s -o %t-rw.cpp");
    // ${LLVM_SRC}/build/bin/FileCheck -check-prefix CHECK-LP '--input-file=${TEST_TEMP_DIR}/rewrite-message-expr.mm.tmp-rw.cpp' ${LLVM_SRC}/llvm/tools/clang/test/Rewriter/rewrite-message-expr.mm
    RUN(TestState.Failed, "FileCheck -check-prefix CHECK-LP --input-file=%t-rw.cpp %s");
  }

  @Test
  public void test_rewrite_modern_array_literal_mm() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Rewriter/rewrite-modern-array-literal.mm");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x objective-c++ -fms-extensions -rewrite-objc ${LLVM_SRC}/llvm/tools/clang/test/Rewriter/rewrite-modern-array-literal.mm -o ${TEST_TEMP_DIR}/rewrite-modern-array-literal.mm.tmp-rw.cpp
    RUN(TestState.Failed, "%clang_cc1 -x objective-c++ -fms-extensions -rewrite-objc %s -o %t-rw.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -Wno-address-of-temporary '-D"Class=void*"' '-D"id=void*"' '-D"SEL=void*"' '-D"__declspec(X)="' ${TEST_TEMP_DIR}/rewrite-modern-array-literal.mm.tmp-rw.cpp
    RUN(TestState.Failed, "%clang_cc1 -fsyntax-only -Wno-address-of-temporary -D\"Class=void*\" -D\"id=void*\" -D\"SEL=void*\" -D\"__declspec(X)=\" %t-rw.cpp");
  }

  @Test
  public void test_rewrite_modern_atautoreleasepool_mm() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Rewriter/rewrite-modern-atautoreleasepool.mm");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -E ${LLVM_SRC}/llvm/tools/clang/test/Rewriter/rewrite-modern-atautoreleasepool.mm -o ${TEST_TEMP_DIR}/rewrite-modern-atautoreleasepool.mm.tmp.mm
    RUN(TestState.Failed, "%clang_cc1 -E %s -o %t.mm");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x objective-c++ -fblocks -fms-extensions -rewrite-objc ${TEST_TEMP_DIR}/rewrite-modern-atautoreleasepool.mm.tmp.mm -o ${TEST_TEMP_DIR}/rewrite-modern-atautoreleasepool.mm.tmp-rw.cpp
    RUN(TestState.Failed, "%clang_cc1 -x objective-c++ -fblocks -fms-extensions -rewrite-objc %t.mm -o %t-rw.cpp");
    // ${LLVM_SRC}/build/bin/FileCheck '--input-file=${TEST_TEMP_DIR}/rewrite-modern-atautoreleasepool.mm.tmp-rw.cpp' ${LLVM_SRC}/llvm/tools/clang/test/Rewriter/rewrite-modern-atautoreleasepool.mm
    RUN(TestState.Failed, "FileCheck --input-file=%t-rw.cpp %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -Wno-address-of-temporary '-D"Class=void*"' '-D"id=void*"' '-D"SEL=void*"' '-D"__declspec(X)="' ${TEST_TEMP_DIR}/rewrite-modern-atautoreleasepool.mm.tmp-rw.cpp
    RUN(TestState.Failed, "%clang_cc1 -fsyntax-only -Wno-address-of-temporary -D\"Class=void*\" -D\"id=void*\" -D\"SEL=void*\" -D\"__declspec(X)=\" %t-rw.cpp");
  }

  @Test
  public void test_rewrite_modern_block_mm() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Rewriter/rewrite-modern-block.mm");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x objective-c++ -fblocks -fms-extensions -rewrite-objc ${LLVM_SRC}/llvm/tools/clang/test/Rewriter/rewrite-modern-block.mm -o ${TEST_TEMP_DIR}/rewrite-modern-block.mm.tmp-rw.cpp
    RUN(TestState.Failed, "%clang_cc1 -x objective-c++ -fblocks -fms-extensions -rewrite-objc %s -o %t-rw.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -Werror -Wno-address-of-temporary '-D"Class=void*"' '-D"id=void*"' '-D"SEL=void*"' -U__declspec '-D"__declspec(X)="' ${TEST_TEMP_DIR}/rewrite-modern-block.mm.tmp-rw.cpp
    RUN(TestState.Failed, "%clang_cc1 -fsyntax-only -Werror -Wno-address-of-temporary -D\"Class=void*\" -D\"id=void*\" -D\"SEL=void*\" -U__declspec -D\"__declspec(X)=\" %t-rw.cpp");
  }

  @Test
  public void test_rewrite_modern_block_consts_mm() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Rewriter/rewrite-modern-block-consts.mm");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x objective-c++ -Wno-return-type -fblocks -fms-extensions -rewrite-objc ${LLVM_SRC}/llvm/tools/clang/test/Rewriter/rewrite-modern-block-consts.mm -o ${TEST_TEMP_DIR}/rewrite-modern-block-consts.mm.tmp-modern-rw.cpp
    RUN(TestState.Failed, "%clang_cc1 -x objective-c++ -Wno-return-type -fblocks -fms-extensions -rewrite-objc %s -o %t-modern-rw.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -Werror -Wno-address-of-temporary -U__declspec '-D"__declspec(X)="' ${TEST_TEMP_DIR}/rewrite-modern-block-consts.mm.tmp-modern-rw.cpp
    RUN(TestState.Failed, "%clang_cc1 -fsyntax-only -Werror -Wno-address-of-temporary -U__declspec -D\"__declspec(X)=\" %t-modern-rw.cpp");
  }

  @Test
  public void test_rewrite_modern_block_ivar_call_mm() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Rewriter/rewrite-modern-block-ivar-call.mm");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -E ${LLVM_SRC}/llvm/tools/clang/test/Rewriter/rewrite-modern-block-ivar-call.mm -o ${TEST_TEMP_DIR}/rewrite-modern-block-ivar-call.mm.tmp.m
    RUN(TestState.Failed, "%clang_cc1 -E %s -o %t.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fblocks -rewrite-objc -fms-extensions ${TEST_TEMP_DIR}/rewrite-modern-block-ivar-call.mm.tmp.m -o ${TEST_TEMP_DIR}/rewrite-modern-block-ivar-call.mm.tmp-rw.cpp
    RUN(TestState.Failed, "%clang_cc1 -fblocks -rewrite-objc -fms-extensions %t.m -o %t-rw.cpp");
    // ${LLVM_SRC}/build/bin/FileCheck '--input-file=${TEST_TEMP_DIR}/rewrite-modern-block-ivar-call.mm.tmp-rw.cpp' ${LLVM_SRC}/llvm/tools/clang/test/Rewriter/rewrite-modern-block-ivar-call.mm
    RUN(TestState.Failed, "FileCheck --input-file=%t-rw.cpp %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -Wno-address-of-temporary '-D"Class=void*"' '-D"id=void*"' '-D"SEL=void*"' '-D"__declspec(X)="' ${TEST_TEMP_DIR}/rewrite-modern-block-ivar-call.mm.tmp-rw.cpp
    RUN(TestState.Failed, "%clang_cc1 -fsyntax-only -Wno-address-of-temporary -D\"Class=void*\" -D\"id=void*\" -D\"SEL=void*\" -D\"__declspec(X)=\" %t-rw.cpp");
  }

  @Test
  public void test_rewrite_modern_captured_nested_bvar_mm() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Rewriter/rewrite-modern-captured-nested-bvar.mm");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -E ${LLVM_SRC}/llvm/tools/clang/test/Rewriter/rewrite-modern-captured-nested-bvar.mm -o ${TEST_TEMP_DIR}/rewrite-modern-captured-nested-bvar.mm.tmp.mm
    RUN(TestState.Failed, "%clang_cc1 -E %s -o %t.mm");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x objective-c++ -fblocks -fms-extensions -rewrite-objc ${TEST_TEMP_DIR}/rewrite-modern-captured-nested-bvar.mm.tmp.mm -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Rewriter/rewrite-modern-captured-nested-bvar.mm
    RUN(TestState.Failed, "%clang_cc1 -x objective-c++ -fblocks -fms-extensions -rewrite-objc %t.mm -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_rewrite_modern_catch_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Rewriter/rewrite-modern-catch.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x objective-c -Wno-return-type -fblocks -fms-extensions -rewrite-objc ${LLVM_SRC}/llvm/tools/clang/test/Rewriter/rewrite-modern-catch.m -o ${TEST_TEMP_DIR}/rewrite-modern-catch.m.tmp-rw.cpp
    RUN(TestState.Failed, "%clang_cc1 -x objective-c -Wno-return-type -fblocks -fms-extensions -rewrite-objc %s -o %t-rw.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -fcxx-exceptions -fexceptions -Wno-address-of-temporary '-D"id=void*"' '-D"SEL=void*"' '-D"__declspec(X)="' ${TEST_TEMP_DIR}/rewrite-modern-catch.m.tmp-rw.cpp
    RUN(TestState.Failed, "%clang_cc1 -fsyntax-only -fcxx-exceptions -fexceptions  -Wno-address-of-temporary -D\"id=void*\" -D\"SEL=void*\" -D\"__declspec(X)=\" %t-rw.cpp");
  }

  @Test
  public void test_rewrite_modern_class_mm() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Rewriter/rewrite-modern-class.mm");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x objective-c++ -Wno-return-type -fblocks -fms-extensions -rewrite-objc ${LLVM_SRC}/llvm/tools/clang/test/Rewriter/rewrite-modern-class.mm -o ${TEST_TEMP_DIR}/rewrite-modern-class.mm.tmp-rw.cpp
    RUN(TestState.Failed, "%clang_cc1 -x objective-c++ -Wno-return-type -fblocks -fms-extensions -rewrite-objc %s -o %t-rw.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -fblocks -Wno-address-of-temporary '-D"Class=void*"' '-D"id=void*"' '-D"SEL=void*"' '-D"__declspec(X)="' ${TEST_TEMP_DIR}/rewrite-modern-class.mm.tmp-rw.cpp
    RUN(TestState.Failed, "%clang_cc1 -fsyntax-only -fblocks -Wno-address-of-temporary -D\"Class=void*\" -D\"id=void*\" -D\"SEL=void*\" -D\"__declspec(X)=\" %t-rw.cpp");
  }

  @Test
  public void test_rewrite_modern_container_literal_mm() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Rewriter/rewrite-modern-container-literal.mm");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x objective-c++ -fms-extensions -rewrite-objc ${LLVM_SRC}/llvm/tools/clang/test/Rewriter/rewrite-modern-container-literal.mm -o ${TEST_TEMP_DIR}/rewrite-modern-container-literal.mm.tmp-rw.cpp
    RUN(TestState.Failed, "%clang_cc1 -x objective-c++ -fms-extensions -rewrite-objc %s -o %t-rw.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -Wno-address-of-temporary '-D"Class=void*"' '-D"id=void*"' '-D"SEL=void*"' '-D"__declspec(X)="' ${TEST_TEMP_DIR}/rewrite-modern-container-literal.mm.tmp-rw.cpp
    RUN(TestState.Failed, "%clang_cc1 -fsyntax-only -Wno-address-of-temporary -D\"Class=void*\" -D\"id=void*\" -D\"SEL=void*\" -D\"__declspec(X)=\" %t-rw.cpp");
  }

  @Test
  public void test_rewrite_modern_default_property_synthesis_mm() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Rewriter/rewrite-modern-default-property-synthesis.mm");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -E ${LLVM_SRC}/llvm/tools/clang/test/Rewriter/rewrite-modern-default-property-synthesis.mm -o ${TEST_TEMP_DIR}/rewrite-modern-default-property-synthesis.mm.tmp.mm
    RUN(TestState.Failed, "%clang_cc1 -E %s -o %t.mm");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x objective-c++ -fms-extensions -rewrite-objc ${TEST_TEMP_DIR}/rewrite-modern-default-property-synthesis.mm.tmp.mm -o ${TEST_TEMP_DIR}/rewrite-modern-default-property-synthesis.mm.tmp-rw.cpp
    RUN(TestState.Failed, "%clang_cc1 -x objective-c++ -fms-extensions -rewrite-objc %t.mm -o %t-rw.cpp");
    // ${LLVM_SRC}/build/bin/FileCheck '--input-file=${TEST_TEMP_DIR}/rewrite-modern-default-property-synthesis.mm.tmp-rw.cpp' ${LLVM_SRC}/llvm/tools/clang/test/Rewriter/rewrite-modern-default-property-synthesis.mm
    RUN(TestState.Failed, "FileCheck --input-file=%t-rw.cpp %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -Werror '-DSEL="void *"' '-Did="struct objc_object *"' -Wno-attributes -Wno-address-of-temporary -U__declspec '-D"__declspec(X)="' ${TEST_TEMP_DIR}/rewrite-modern-default-property-synthesis.mm.tmp-rw.cpp
    RUN(TestState.Failed, "%clang_cc1 -fsyntax-only  -Werror -DSEL=\"void *\" -Did=\"struct objc_object *\" -Wno-attributes -Wno-address-of-temporary -U__declspec -D\"__declspec(X)=\" %t-rw.cpp");
  }

  @Test
  public void test_rewrite_modern_extern_c_func_decl_mm() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Rewriter/rewrite-modern-extern-c-func-decl.mm");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fms-extensions -U__declspec -rewrite-objc -x objective-c++ -fblocks -o ${TEST_TEMP_DIR}/rewrite-modern-extern-c-func-decl.mm.tmp-rw.cpp ${LLVM_SRC}/llvm/tools/clang/test/Rewriter/rewrite-modern-extern-c-func-decl.mm
    RUN(TestState.Failed, "%clang_cc1 -fms-extensions -U__declspec -rewrite-objc -x objective-c++ -fblocks -o %t-rw.cpp %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -Werror -Wno-address-of-temporary -Wno-attributes '-D"Class=void*"' '-D"id=void*"' '-D"SEL=void*"' -U__declspec '-D"__declspec(X)="' ${TEST_TEMP_DIR}/rewrite-modern-extern-c-func-decl.mm.tmp-rw.cpp
    RUN(TestState.Failed, "%clang_cc1 -fsyntax-only -Werror -Wno-address-of-temporary -Wno-attributes -D\"Class=void*\" -D\"id=void*\" -D\"SEL=void*\" -U__declspec -D\"__declspec(X)=\" %t-rw.cpp");
  }

  @Test
  public void test_rewrite_modern_ivar_access_mm() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Rewriter/rewrite-modern-ivar-access.mm");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fblocks -rewrite-objc -fms-extensions ${LLVM_SRC}/llvm/tools/clang/test/Rewriter/rewrite-modern-ivar-access.mm -o ${TEST_TEMP_DIR}/rewrite-modern-ivar-access.mm.tmp-rw.cpp
    RUN(TestState.Failed, "%clang_cc1 -fblocks -rewrite-objc -fms-extensions %s -o %t-rw.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -Werror -fsyntax-only -Wno-address-of-temporary -Wno-c++11-narrowing -std=c++11 '-D"Class=void*"' '-D"id=void*"' '-D"SEL=void*"' -U__declspec '-D"__declspec(X)="' ${TEST_TEMP_DIR}/rewrite-modern-ivar-access.mm.tmp-rw.cpp
    RUN(TestState.Failed, "%clang_cc1 -Werror -fsyntax-only -Wno-address-of-temporary -Wno-c++11-narrowing -std=c++11 -D\"Class=void*\" -D\"id=void*\" -D\"SEL=void*\" -U__declspec -D\"__declspec(X)=\" %t-rw.cpp");
  }

  @Test
  public void test_rewrite_modern_ivar_use_mm() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Rewriter/rewrite-modern-ivar-use.mm");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x objective-c++ -Wno-return-type -fblocks -fms-extensions -rewrite-objc ${LLVM_SRC}/llvm/tools/clang/test/Rewriter/rewrite-modern-ivar-use.mm -o ${TEST_TEMP_DIR}/rewrite-modern-ivar-use.mm.tmp-rw-modern.cpp
    RUN(TestState.Failed, "%clang_cc1 -x objective-c++ -Wno-return-type -fblocks -fms-extensions -rewrite-objc %s -o %t-rw-modern.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -fblocks -Wno-address-of-temporary '-D"Class=void*"' '-D"id=void*"' '-D"SEL=void*"' '-D"__declspec(X)="' ${TEST_TEMP_DIR}/rewrite-modern-ivar-use.mm.tmp-rw-modern.cpp
    RUN(TestState.Failed, "%clang_cc1 -fsyntax-only -fblocks -Wno-address-of-temporary -D\"Class=void*\" -D\"id=void*\" -D\"SEL=void*\" -D\"__declspec(X)=\" %t-rw-modern.cpp");
  }

  @Test
  public void test_rewrite_modern_ivars_mm() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Rewriter/rewrite-modern-ivars.mm");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x objective-c++ -Wno-return-type -fblocks -fms-extensions -rewrite-objc ${LLVM_SRC}/llvm/tools/clang/test/Rewriter/rewrite-modern-ivars.mm -o ${TEST_TEMP_DIR}/rewrite-modern-ivars.mm.tmp-rw.cpp
    RUN(TestState.Failed, "%clang_cc1 -x objective-c++ -Wno-return-type -fblocks -fms-extensions -rewrite-objc %s -o %t-rw.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -fblocks -Wno-address-of-temporary '-D"Class=void*"' '-D"id=void*"' '-D"SEL=void*"' '-D"__declspec(X)="' ${TEST_TEMP_DIR}/rewrite-modern-ivars.mm.tmp-rw.cpp
    RUN(TestState.Failed, "%clang_cc1 -fsyntax-only -fblocks -Wno-address-of-temporary -D\"Class=void*\" -D\"id=void*\" -D\"SEL=void*\" -D\"__declspec(X)=\" %t-rw.cpp");
  }

  @Test
  public void test_rewrite_modern_ivars_1_mm() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Rewriter/rewrite-modern-ivars-1.mm");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x objective-c++ -Wno-return-type -fblocks -fms-extensions -rewrite-objc ${LLVM_SRC}/llvm/tools/clang/test/Rewriter/rewrite-modern-ivars-1.mm -o ${TEST_TEMP_DIR}/rewrite-modern-ivars-1.mm.tmp-rw.cpp
    RUN(TestState.Failed, "%clang_cc1 -x objective-c++ -Wno-return-type -fblocks -fms-extensions -rewrite-objc %s -o %t-rw.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -Werror -Wno-address-of-temporary '-D"Class=void*"' '-D"id=void*"' '-D"SEL=void*"' -U__declspec '-D"__declspec(X)="' ${TEST_TEMP_DIR}/rewrite-modern-ivars-1.mm.tmp-rw.cpp
    RUN(TestState.Failed, "%clang_cc1 -fsyntax-only -Werror -Wno-address-of-temporary -D\"Class=void*\" -D\"id=void*\" -D\"SEL=void*\" -U__declspec -D\"__declspec(X)=\" %t-rw.cpp");
  }

  @Test
  public void test_rewrite_modern_ivars_2_mm() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Rewriter/rewrite-modern-ivars-2.mm");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i386-apple-darwin9 -x objective-c++ -Wno-return-type -fblocks -fms-extensions -rewrite-objc ${LLVM_SRC}/llvm/tools/clang/test/Rewriter/rewrite-modern-ivars-2.mm -o ${TEST_TEMP_DIR}/rewrite-modern-ivars-2.mm.tmp-rw.cpp
    RUN(TestState.Failed, "%clang_cc1 -triple i386-apple-darwin9 -x objective-c++ -Wno-return-type -fblocks -fms-extensions -rewrite-objc %s -o %t-rw.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i386-apple-darwin9 -fsyntax-only -fblocks -Wno-address-of-temporary '-D"Class=void*"' '-D"id=void*"' '-D"SEL=void*"' '-D"__declspec(X)="' ${TEST_TEMP_DIR}/rewrite-modern-ivars-2.mm.tmp-rw.cpp
    RUN(TestState.Failed, "%clang_cc1 -triple i386-apple-darwin9 -fsyntax-only -fblocks -Wno-address-of-temporary -D\"Class=void*\" -D\"id=void*\" -D\"SEL=void*\" -D\"__declspec(X)=\" %t-rw.cpp");
  }

  @Test
  public void test_rewrite_modern_nested_ivar_mm() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Rewriter/rewrite-modern-nested-ivar.mm");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -E ${LLVM_SRC}/llvm/tools/clang/test/Rewriter/rewrite-modern-nested-ivar.mm -o ${TEST_TEMP_DIR}/rewrite-modern-nested-ivar.mm.tmp.m
    RUN(TestState.Failed, "%clang_cc1 -E %s -o %t.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fblocks -rewrite-objc -fms-extensions ${TEST_TEMP_DIR}/rewrite-modern-nested-ivar.mm.tmp.m -o ${TEST_TEMP_DIR}/rewrite-modern-nested-ivar.mm.tmp-rw.cpp
    RUN(TestState.Failed, "%clang_cc1 -fblocks -rewrite-objc -fms-extensions %t.m -o %t-rw.cpp");
    // ${LLVM_SRC}/build/bin/FileCheck '--input-file=${TEST_TEMP_DIR}/rewrite-modern-nested-ivar.mm.tmp-rw.cpp' ${LLVM_SRC}/llvm/tools/clang/test/Rewriter/rewrite-modern-nested-ivar.mm
    RUN(TestState.Failed, "FileCheck --input-file=%t-rw.cpp %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -Wno-address-of-temporary '-D"Class=void*"' '-D"id=void*"' '-D"SEL=void*"' '-D"__declspec(X)="' ${TEST_TEMP_DIR}/rewrite-modern-nested-ivar.mm.tmp-rw.cpp
    RUN(TestState.Failed, "%clang_cc1 -fsyntax-only -Wno-address-of-temporary -D\"Class=void*\" -D\"id=void*\" -D\"SEL=void*\" -D\"__declspec(X)=\" %t-rw.cpp");
  }

  @Test
  public void test_rewrite_modern_private_ivars_mm() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Rewriter/rewrite-modern-private-ivars.mm");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fblocks -rewrite-objc -fms-extensions ${LLVM_SRC}/llvm/tools/clang/test/Rewriter/rewrite-modern-private-ivars.mm -o ${TEST_TEMP_DIR}/rewrite-modern-private-ivars.mm.tmp-rw.cpp
    RUN(TestState.Failed, "%clang_cc1 -fblocks -rewrite-objc -fms-extensions %s -o %t-rw.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -Werror -fsyntax-only -Wno-address-of-temporary -Wno-c++11-narrowing -std=c++11 '-D"Class=void*"' '-D"id=void*"' '-D"SEL=void*"' -U__declspec '-D"__declspec(X)="' ${TEST_TEMP_DIR}/rewrite-modern-private-ivars.mm.tmp-rw.cpp
    RUN(TestState.Failed, "%clang_cc1 -Werror -fsyntax-only -Wno-address-of-temporary -Wno-c++11-narrowing -std=c++11 -D\"Class=void*\" -D\"id=void*\" -D\"SEL=void*\" -U__declspec -D\"__declspec(X)=\" %t-rw.cpp");
  }

  @Test
  public void test_rewrite_modern_protocol_mm() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Rewriter/rewrite-modern-protocol.mm");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x objective-c++ -Wno-return-type -fblocks -fms-extensions -rewrite-objc ${LLVM_SRC}/llvm/tools/clang/test/Rewriter/rewrite-modern-protocol.mm -o ${TEST_TEMP_DIR}/rewrite-modern-protocol.mm.tmp-rw.cpp
    RUN(TestState.Failed, "%clang_cc1 -x objective-c++ -Wno-return-type -fblocks -fms-extensions -rewrite-objc %s -o %t-rw.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -fblocks -Wno-address-of-temporary '-D"Class=void*"' '-D"id=void*"' '-D"SEL=void*"' '-D"__declspec(X)="' ${TEST_TEMP_DIR}/rewrite-modern-protocol.mm.tmp-rw.cpp
    RUN(TestState.Failed, "%clang_cc1 -fsyntax-only -fblocks -Wno-address-of-temporary -D\"Class=void*\" -D\"id=void*\" -D\"SEL=void*\" -D\"__declspec(X)=\" %t-rw.cpp");
  }

  @Test
  public void test_rewrite_modern_protocol_1_mm() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Rewriter/rewrite-modern-protocol-1.mm");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -E ${LLVM_SRC}/llvm/tools/clang/test/Rewriter/rewrite-modern-protocol-1.mm -o ${TEST_TEMP_DIR}/rewrite-modern-protocol-1.mm.tmp.mm
    RUN(TestState.Failed, "%clang_cc1 -E %s -o %t.mm");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x objective-c++ -fblocks -fms-extensions -rewrite-objc ${TEST_TEMP_DIR}/rewrite-modern-protocol-1.mm.tmp.mm -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Rewriter/rewrite-modern-protocol-1.mm
    RUN(TestState.Failed, "%clang_cc1 -x objective-c++ -fblocks -fms-extensions -rewrite-objc %t.mm -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_rewrite_modern_qualified_type_mm() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Rewriter/rewrite-modern-qualified-type.mm");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x objective-c++ -Wno-return-type -fms-extensions -rewrite-objc ${LLVM_SRC}/llvm/tools/clang/test/Rewriter/rewrite-modern-qualified-type.mm -o ${TEST_TEMP_DIR}/rewrite-modern-qualified-type.mm.tmp-modern-rw.cpp
    RUN(TestState.Failed, "%clang_cc1 -x objective-c++ -Wno-return-type -fms-extensions -rewrite-objc %s -o %t-modern-rw.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -Wno-address-of-temporary -D_Bool=bool '-D"id=void*"' '-D"SEL=void*"' '-D"__declspec(X)="' ${TEST_TEMP_DIR}/rewrite-modern-qualified-type.mm.tmp-modern-rw.cpp
    RUN(TestState.Failed, "%clang_cc1 -fsyntax-only -Wno-address-of-temporary -D_Bool=bool -D\"id=void*\" -D\"SEL=void*\" -D\"__declspec(X)=\" %t-modern-rw.cpp");
  }

  @Test
  public void test_rewrite_modern_struct_ivar_mm() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Rewriter/rewrite-modern-struct-ivar.mm");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -E ${LLVM_SRC}/llvm/tools/clang/test/Rewriter/rewrite-modern-struct-ivar.mm -o ${TEST_TEMP_DIR}/rewrite-modern-struct-ivar.mm.tmp.mm
    RUN(TestState.Failed, "%clang_cc1 -E %s -o %t.mm");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fblocks -rewrite-objc -fms-extensions ${TEST_TEMP_DIR}/rewrite-modern-struct-ivar.mm.tmp.mm -o ${TEST_TEMP_DIR}/rewrite-modern-struct-ivar.mm.tmp-rw.cpp
    RUN(TestState.Failed, "%clang_cc1 -fblocks -rewrite-objc -fms-extensions %t.mm -o %t-rw.cpp");
    // ${LLVM_SRC}/build/bin/FileCheck '--input-file=${TEST_TEMP_DIR}/rewrite-modern-struct-ivar.mm.tmp-rw.cpp' ${LLVM_SRC}/llvm/tools/clang/test/Rewriter/rewrite-modern-struct-ivar.mm
    RUN(TestState.Failed, "FileCheck --input-file=%t-rw.cpp %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -Werror -Wno-address-of-temporary -Wno-c++11-narrowing -std=c++11 '-D"Class=void*"' '-D"id=void*"' '-D"SEL=void*"' -U__declspec '-D"__declspec(X)="' ${TEST_TEMP_DIR}/rewrite-modern-struct-ivar.mm.tmp-rw.cpp
    RUN(TestState.Failed, "%clang_cc1 -fsyntax-only -Werror -Wno-address-of-temporary -Wno-c++11-narrowing -std=c++11 -D\"Class=void*\" -D\"id=void*\" -D\"SEL=void*\" -U__declspec -D\"__declspec(X)=\" %t-rw.cpp");
  }

  @Test
  public void test_rewrite_modern_struct_ivar_1_mm() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Rewriter/rewrite-modern-struct-ivar-1.mm");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fblocks -rewrite-objc -fms-extensions ${LLVM_SRC}/llvm/tools/clang/test/Rewriter/rewrite-modern-struct-ivar-1.mm -o ${TEST_TEMP_DIR}/rewrite-modern-struct-ivar-1.mm.tmp-rw.cpp
    RUN(TestState.Failed, "%clang_cc1 -fblocks -rewrite-objc -fms-extensions %s -o %t-rw.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -Werror -fsyntax-only -Wno-address-of-temporary -Wno-c++11-narrowing -std=c++11 '-D"Class=void*"' '-D"id=void*"' '-D"SEL=void*"' -U__declspec '-D"__declspec(X)="' ${TEST_TEMP_DIR}/rewrite-modern-struct-ivar-1.mm.tmp-rw.cpp
    RUN(TestState.Failed, "%clang_cc1 -Werror -fsyntax-only -Wno-address-of-temporary -Wno-c++11-narrowing -std=c++11 -D\"Class=void*\" -D\"id=void*\" -D\"SEL=void*\" -U__declspec -D\"__declspec(X)=\" %t-rw.cpp");
  }

  @Test
  public void test_rewrite_modern_super_mm() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Rewriter/rewrite-modern-super.mm");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x objective-c++ -fblocks -fms-extensions -rewrite-objc ${LLVM_SRC}/llvm/tools/clang/test/Rewriter/rewrite-modern-super.mm -o ${TEST_TEMP_DIR}/rewrite-modern-super.mm.tmp-rw.cpp
    RUN(TestState.Failed, "%clang_cc1 -x objective-c++ -fblocks -fms-extensions -rewrite-objc %s -o %t-rw.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -Wno-address-of-temporary '-D"id=struct objc_object *"' '-D"SEL=void*"' '-D"__declspec(X)="' ${TEST_TEMP_DIR}/rewrite-modern-super.mm.tmp-rw.cpp
    RUN(TestState.Failed, "%clang_cc1 -fsyntax-only -Wno-address-of-temporary -D\"id=struct objc_object *\" -D\"SEL=void*\" -D\"__declspec(X)=\" %t-rw.cpp");
  }

  @Test
  public void test_rewrite_modern_synchronized_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Rewriter/rewrite-modern-synchronized.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x objective-c -Wno-return-type -fblocks -fms-extensions -rewrite-objc ${LLVM_SRC}/llvm/tools/clang/test/Rewriter/rewrite-modern-synchronized.m -o ${TEST_TEMP_DIR}/rewrite-modern-synchronized.m.tmp-rw.cpp
    RUN(TestState.Failed, "%clang_cc1 -x objective-c -Wno-return-type -fblocks -fms-extensions -rewrite-objc %s -o %t-rw.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -fcxx-exceptions -fexceptions -Wno-address-of-temporary '-D"SEL=void*"' '-D"Class=struct objc_class *"' '-D"__declspec(X)="' ${TEST_TEMP_DIR}/rewrite-modern-synchronized.m.tmp-rw.cpp
    RUN(TestState.Failed, "%clang_cc1 -fsyntax-only -fcxx-exceptions -fexceptions  -Wno-address-of-temporary -D\"SEL=void*\" -D\"Class=struct objc_class *\" -D\"__declspec(X)=\" %t-rw.cpp");
  }

  @Test
  public void test_rewrite_modern_throw_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Rewriter/rewrite-modern-throw.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x objective-c -Wno-return-type -fblocks -fms-extensions -rewrite-objc ${LLVM_SRC}/llvm/tools/clang/test/Rewriter/rewrite-modern-throw.m -o ${TEST_TEMP_DIR}/rewrite-modern-throw.m.tmp-rw.cpp
    RUN(TestState.Failed, "%clang_cc1 -x objective-c -Wno-return-type -fblocks -fms-extensions -rewrite-objc %s -o %t-rw.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -fcxx-exceptions -fexceptions -Wno-address-of-temporary '-D"SEL=void*"' '-D"__declspec(X)="' ${TEST_TEMP_DIR}/rewrite-modern-throw.m.tmp-rw.cpp
    RUN(TestState.Failed, "%clang_cc1 -fsyntax-only -fcxx-exceptions -fexceptions  -Wno-address-of-temporary -D\"SEL=void*\" -D\"__declspec(X)=\" %t-rw.cpp");
  }

  @Test
  public void test_rewrite_modern_try_catch_finally_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Rewriter/rewrite-modern-try-catch-finally.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x objective-c -Wno-return-type -fblocks -fms-extensions -rewrite-objc ${LLVM_SRC}/llvm/tools/clang/test/Rewriter/rewrite-modern-try-catch-finally.m -o ${TEST_TEMP_DIR}/rewrite-modern-try-catch-finally.m.tmp-rw.cpp
    RUN(TestState.Failed, "%clang_cc1 -x objective-c -Wno-return-type -fblocks -fms-extensions -rewrite-objc %s -o %t-rw.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -fcxx-exceptions -fexceptions -Wno-address-of-temporary '-D"SEL=void*"' '-D"__declspec(X)="' ${TEST_TEMP_DIR}/rewrite-modern-try-catch-finally.m.tmp-rw.cpp
    RUN(TestState.Failed, "%clang_cc1 -fsyntax-only -fcxx-exceptions -fexceptions  -Wno-address-of-temporary -D\"SEL=void*\" -D\"__declspec(X)=\" %t-rw.cpp");
  }

  @Test
  public void test_rewrite_modern_try_finally_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Rewriter/rewrite-modern-try-finally.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x objective-c -Wno-return-type -fblocks -fms-extensions -rewrite-objc ${LLVM_SRC}/llvm/tools/clang/test/Rewriter/rewrite-modern-try-finally.m -o ${TEST_TEMP_DIR}/rewrite-modern-try-finally.m.tmp-rw.cpp
    RUN(TestState.Failed, "%clang_cc1 -x objective-c -Wno-return-type -fblocks -fms-extensions -rewrite-objc %s -o %t-rw.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -fcxx-exceptions -fexceptions -Wno-address-of-temporary '-D"SEL=void*"' '-D"__declspec(X)="' ${TEST_TEMP_DIR}/rewrite-modern-try-finally.m.tmp-rw.cpp
    RUN(TestState.Failed, "%clang_cc1 -fsyntax-only -fcxx-exceptions -fexceptions  -Wno-address-of-temporary -D\"SEL=void*\" -D\"__declspec(X)=\" %t-rw.cpp");
  }

  @Test
  public void test_rewrite_modern_typeof_mm() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Rewriter/rewrite-modern-typeof.mm");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x objective-c++ -fblocks -fms-extensions -rewrite-objc ${LLVM_SRC}/llvm/tools/clang/test/Rewriter/rewrite-modern-typeof.mm -o ${TEST_TEMP_DIR}/rewrite-modern-typeof.mm.tmp-rw.cpp
    RUN(TestState.Failed, "%clang_cc1 -x objective-c++ -fblocks -fms-extensions -rewrite-objc %s -o %t-rw.cpp");
    // ${LLVM_SRC}/build/bin/FileCheck -check-prefix CHECK-LP '--input-file=${TEST_TEMP_DIR}/rewrite-modern-typeof.mm.tmp-rw.cpp' ${LLVM_SRC}/llvm/tools/clang/test/Rewriter/rewrite-modern-typeof.mm
    RUN(TestState.Failed, "FileCheck -check-prefix CHECK-LP --input-file=%t-rw.cpp %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -Wno-address-of-temporary -Wno-attributes '-D"Class=void*"' '-D"id=void*"' '-D"SEL=void*"' '-D"__declspec(X)="' ${TEST_TEMP_DIR}/rewrite-modern-typeof.mm.tmp-rw.cpp
    RUN(TestState.Failed, "%clang_cc1 -fsyntax-only -Wno-address-of-temporary -Wno-attributes -D\"Class=void*\" -D\"id=void*\" -D\"SEL=void*\" -D\"__declspec(X)=\" %t-rw.cpp");
  }

  @Test
  public void test_rewrite_nest_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Rewriter/rewrite-nest.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -rewrite-objc -fobjc-runtime=macosx-fragile-10.5 ${LLVM_SRC}/llvm/tools/clang/test/Rewriter/rewrite-nest.m -o -
    RUN(TestState.Failed, "%clang_cc1 -rewrite-objc -fobjc-runtime=macosx-fragile-10.5  %s -o -");
  }

  @Test
  public void test_rewrite_nested_blocks_mm() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Rewriter/rewrite-nested-blocks.mm");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x objective-c++ -Wno-return-type -fblocks -fms-extensions -rewrite-objc -fobjc-runtime=macosx-fragile-10.5 ${LLVM_SRC}/llvm/tools/clang/test/Rewriter/rewrite-nested-blocks.mm -o ${TEST_TEMP_DIR}/rewrite-nested-blocks.mm.tmp-rw.cpp
    RUN(TestState.Failed, "%clang_cc1 -x objective-c++ -Wno-return-type -fblocks -fms-extensions -rewrite-objc -fobjc-runtime=macosx-fragile-10.5 %s -o %t-rw.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -Wno-address-of-temporary '-D"SEL=void*"' '-D"__declspec(X)="' ${TEST_TEMP_DIR}/rewrite-nested-blocks.mm.tmp-rw.cpp
    RUN(TestState.Failed, "%clang_cc1 -fsyntax-only -Wno-address-of-temporary -D\"SEL=void*\" -D\"__declspec(X)=\" %t-rw.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x objective-c++ -Wno-return-type -fblocks -fms-extensions -rewrite-objc ${LLVM_SRC}/llvm/tools/clang/test/Rewriter/rewrite-nested-blocks.mm -o ${TEST_TEMP_DIR}/rewrite-nested-blocks.mm.tmp-modern-rw.cpp
    RUN(TestState.Failed, "%clang_cc1 -x objective-c++ -Wno-return-type -fblocks -fms-extensions -rewrite-objc %s -o %t-modern-rw.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -Wno-address-of-temporary '-D"SEL=void*"' '-D"__declspec(X)="' ${TEST_TEMP_DIR}/rewrite-nested-blocks.mm.tmp-modern-rw.cpp
    RUN(TestState.Failed, "%clang_cc1 -fsyntax-only -Wno-address-of-temporary -D\"SEL=void*\" -D\"__declspec(X)=\" %t-modern-rw.cpp");
  }

  @Test
  public void test_rewrite_nested_blocks_1_mm() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Rewriter/rewrite-nested-blocks-1.mm");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x objective-c++ -Wno-return-type -fblocks -fms-extensions -rewrite-objc -fobjc-runtime=macosx-fragile-10.5 ${LLVM_SRC}/llvm/tools/clang/test/Rewriter/rewrite-nested-blocks-1.mm -o ${TEST_TEMP_DIR}/rewrite-nested-blocks-1.mm.tmp-rw.cpp
    RUN(TestState.Failed, "%clang_cc1 -x objective-c++ -Wno-return-type -fblocks -fms-extensions -rewrite-objc -fobjc-runtime=macosx-fragile-10.5 %s -o %t-rw.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -fblocks -Wno-address-of-temporary '-D"id=void*"' '-D"SEL=void*"' '-D"__declspec(X)="' ${TEST_TEMP_DIR}/rewrite-nested-blocks-1.mm.tmp-rw.cpp
    RUN(TestState.Failed, "%clang_cc1 -fsyntax-only -fblocks -Wno-address-of-temporary -D\"id=void*\" -D\"SEL=void*\" -D\"__declspec(X)=\" %t-rw.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x objective-c++ -Wno-return-type -fblocks -fms-extensions -rewrite-objc ${LLVM_SRC}/llvm/tools/clang/test/Rewriter/rewrite-nested-blocks-1.mm -o ${TEST_TEMP_DIR}/rewrite-nested-blocks-1.mm.tmp-modern-rw.cpp
    RUN(TestState.Failed, "%clang_cc1 -x objective-c++ -Wno-return-type -fblocks -fms-extensions -rewrite-objc %s -o %t-modern-rw.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -Wno-address-of-temporary '-D"id=void*"' '-D"SEL=void*"' '-D"__declspec(X)="' ${TEST_TEMP_DIR}/rewrite-nested-blocks-1.mm.tmp-modern-rw.cpp
    RUN(TestState.Failed, "%clang_cc1 -fsyntax-only -Wno-address-of-temporary -D\"id=void*\" -D\"SEL=void*\" -D\"__declspec(X)=\" %t-modern-rw.cpp");
  }

  @Test
  public void test_rewrite_nested_blocks_2_mm() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Rewriter/rewrite-nested-blocks-2.mm");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x objective-c++ -Wno-return-type -fblocks -fms-extensions -rewrite-objc -fobjc-runtime=macosx-fragile-10.5 ${LLVM_SRC}/llvm/tools/clang/test/Rewriter/rewrite-nested-blocks-2.mm -o ${TEST_TEMP_DIR}/rewrite-nested-blocks-2.mm.tmp-rw.cpp
    RUN(TestState.Failed, "%clang_cc1 -x objective-c++ -Wno-return-type -fblocks -fms-extensions -rewrite-objc -fobjc-runtime=macosx-fragile-10.5 %s -o %t-rw.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -fblocks -Wno-address-of-temporary '-D"id=void*"' '-D"SEL=void*"' '-D"__declspec(X)="' ${TEST_TEMP_DIR}/rewrite-nested-blocks-2.mm.tmp-rw.cpp
    RUN(TestState.Failed, "%clang_cc1 -fsyntax-only -fblocks -Wno-address-of-temporary -D\"id=void*\" -D\"SEL=void*\" -D\"__declspec(X)=\" %t-rw.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x objective-c++ -Wno-return-type -fblocks -fms-extensions -rewrite-objc ${LLVM_SRC}/llvm/tools/clang/test/Rewriter/rewrite-nested-blocks-2.mm -o ${TEST_TEMP_DIR}/rewrite-nested-blocks-2.mm.tmp-modern-rw.cpp
    RUN(TestState.Failed, "%clang_cc1 -x objective-c++ -Wno-return-type -fblocks -fms-extensions -rewrite-objc %s -o %t-modern-rw.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -Wno-address-of-temporary '-D"id=void*"' '-D"SEL=void*"' '-D"__declspec(X)="' ${TEST_TEMP_DIR}/rewrite-nested-blocks-2.mm.tmp-modern-rw.cpp
    RUN(TestState.Failed, "%clang_cc1 -fsyntax-only -Wno-address-of-temporary -D\"id=void*\" -D\"SEL=void*\" -D\"__declspec(X)=\" %t-modern-rw.cpp");
  }

  @Test
  public void test_rewrite_nested_ivar_mm() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Rewriter/rewrite-nested-ivar.mm");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x objective-c++ -Wno-return-type -fblocks -fms-extensions -rewrite-objc -fobjc-runtime=macosx-fragile-10.5 ${LLVM_SRC}/llvm/tools/clang/test/Rewriter/rewrite-nested-ivar.mm -o ${TEST_TEMP_DIR}/rewrite-nested-ivar.mm.tmp-rw.cpp
    RUN(TestState.Failed, "%clang_cc1 -x objective-c++ -Wno-return-type -fblocks -fms-extensions -rewrite-objc -fobjc-runtime=macosx-fragile-10.5 %s -o %t-rw.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -fblocks -Wno-address-of-temporary '-D"id=void*"' '-D"SEL=void*"' '-D"__declspec(X)="' ${TEST_TEMP_DIR}/rewrite-nested-ivar.mm.tmp-rw.cpp
    RUN(TestState.Failed, "%clang_cc1 -fsyntax-only -fblocks -Wno-address-of-temporary -D\"id=void*\" -D\"SEL=void*\" -D\"__declspec(X)=\" %t-rw.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x objective-c++ -Wno-return-type -fblocks -fms-extensions -rewrite-objc ${LLVM_SRC}/llvm/tools/clang/test/Rewriter/rewrite-nested-ivar.mm -o ${TEST_TEMP_DIR}/rewrite-nested-ivar.mm.tmp-rw-modern.cpp
    RUN(TestState.Failed, "%clang_cc1 -x objective-c++ -Wno-return-type -fblocks -fms-extensions -rewrite-objc %s -o %t-rw-modern.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -fblocks -Wno-address-of-temporary '-D"id=void*"' '-D"SEL=void*"' '-D"__declspec(X)="' ${TEST_TEMP_DIR}/rewrite-nested-ivar.mm.tmp-rw-modern.cpp
    RUN(TestState.Failed, "%clang_cc1 -fsyntax-only -fblocks -Wno-address-of-temporary -D\"id=void*\" -D\"SEL=void*\" -D\"__declspec(X)=\" %t-rw-modern.cpp");
  }

  @Test
  public void test_rewrite_nested_property_in_blocks_mm() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Rewriter/rewrite-nested-property-in-blocks.mm");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i686-pc-windows -x objective-c++ -Wno-return-type -fblocks -fms-extensions -rewrite-objc -fobjc-runtime=macosx-fragile-10.5 ${LLVM_SRC}/llvm/tools/clang/test/Rewriter/rewrite-nested-property-in-blocks.mm -o ${TEST_TEMP_DIR}/rewrite-nested-property-in-blocks.mm.tmp-rw.cpp
    RUN(TestState.Failed, "%clang_cc1 -triple i686-pc-windows -x objective-c++ -Wno-return-type -fblocks -fms-extensions -rewrite-objc -fobjc-runtime=macosx-fragile-10.5 %s -o %t-rw.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i686-pc-windows -fsyntax-only -fms-extensions -Wno-address-of-temporary '-Did="void *"' '-D"SEL=void*"' '-D"__declspec(X)="' ${TEST_TEMP_DIR}/rewrite-nested-property-in-blocks.mm.tmp-rw.cpp
    RUN(TestState.Failed, "%clang_cc1 -triple i686-pc-windows -fsyntax-only -fms-extensions -Wno-address-of-temporary -Did=\"void *\" -D\"SEL=void*\" -D\"__declspec(X)=\" %t-rw.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i686-pc-windows -x objective-c++ -Wno-return-type -fblocks -fms-extensions -rewrite-objc ${LLVM_SRC}/llvm/tools/clang/test/Rewriter/rewrite-nested-property-in-blocks.mm -o ${TEST_TEMP_DIR}/rewrite-nested-property-in-blocks.mm.tmp-modern-rw.cpp
    RUN(TestState.Failed, "%clang_cc1 -triple i686-pc-windows -x objective-c++ -Wno-return-type -fblocks -fms-extensions -rewrite-objc %s -o %t-modern-rw.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i686-pc-windows -fsyntax-only -fms-extensions -Wno-address-of-temporary '-Did="void *"' '-D"SEL=void*"' '-D"__declspec(X)="' ${TEST_TEMP_DIR}/rewrite-nested-property-in-blocks.mm.tmp-modern-rw.cpp
    RUN(TestState.Failed, "%clang_cc1 -triple i686-pc-windows -fsyntax-only -fms-extensions -Wno-address-of-temporary -Did=\"void *\" -D\"SEL=void*\" -D\"__declspec(X)=\" %t-modern-rw.cpp");
  }

  @Test
  public void test_rewrite_no_nextline_mm() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Rewriter/rewrite-no-nextline.mm");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x objective-c++ -Wno-return-type -fblocks -fms-extensions -rewrite-objc -fobjc-runtime=macosx-fragile-10.5 ${LLVM_SRC}/llvm/tools/clang/test/Rewriter/rewrite-no-nextline.mm -o ${TEST_TEMP_DIR}/rewrite-no-nextline.mm.tmp-rw.cpp
    RUN(TestState.Failed, "%clang_cc1 -x objective-c++ -Wno-return-type -fblocks -fms-extensions -rewrite-objc -fobjc-runtime=macosx-fragile-10.5 %s -o %t-rw.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -Wno-address-of-temporary '-D"SEL=void*"' '-D"__declspec(X)="' ${TEST_TEMP_DIR}/rewrite-no-nextline.mm.tmp-rw.cpp
    RUN(TestState.Failed, "%clang_cc1 -fsyntax-only -Wno-address-of-temporary -D\"SEL=void*\" -D\"__declspec(X)=\" %t-rw.cpp");
  }

  @Test
  public void test_rewrite_property_attributes_mm() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Rewriter/rewrite-property-attributes.mm");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x objective-c++ -Wno-return-type -fblocks -fms-extensions -rewrite-objc -fobjc-runtime=macosx-fragile-10.5 ${LLVM_SRC}/llvm/tools/clang/test/Rewriter/rewrite-property-attributes.mm -o ${TEST_TEMP_DIR}/rewrite-property-attributes.mm.tmp-rw.cpp
    RUN(TestState.Failed, "%clang_cc1 -x objective-c++ -Wno-return-type -fblocks -fms-extensions -rewrite-objc -fobjc-runtime=macosx-fragile-10.5 %s -o %t-rw.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -Wno-address-of-temporary '-D"id=void*"' '-D"SEL=void*"' '-D"__declspec(X)="' ${TEST_TEMP_DIR}/rewrite-property-attributes.mm.tmp-rw.cpp
    RUN(TestState.Failed, "%clang_cc1 -fsyntax-only -Wno-address-of-temporary  -D\"id=void*\" -D\"SEL=void*\" -D\"__declspec(X)=\" %t-rw.cpp");
  }

  @Test
  public void test_rewrite_property_set_cfstring_mm() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Rewriter/rewrite-property-set-cfstring.mm");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x objective-c++ -Wno-return-type -fblocks -fms-extensions -rewrite-objc -fobjc-runtime=macosx-fragile-10.5 ${LLVM_SRC}/llvm/tools/clang/test/Rewriter/rewrite-property-set-cfstring.mm -o ${TEST_TEMP_DIR}/rewrite-property-set-cfstring.mm.tmp-rw.cpp
    RUN(TestState.Failed, "%clang_cc1 -x objective-c++ -Wno-return-type -fblocks -fms-extensions -rewrite-objc -fobjc-runtime=macosx-fragile-10.5 %s -o %t-rw.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -fblocks -Wno-address-of-temporary '-D"id=void*"' '-D"SEL=void*"' '-D"__declspec(X)="' ${TEST_TEMP_DIR}/rewrite-property-set-cfstring.mm.tmp-rw.cpp
    RUN(TestState.Failed, "%clang_cc1 -fsyntax-only -fblocks -Wno-address-of-temporary -D\"id=void*\" -D\"SEL=void*\" -D\"__declspec(X)=\" %t-rw.cpp");
  }

  @Test
  public void test_rewrite_protocol_property_mm() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Rewriter/rewrite-protocol-property.mm");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x objective-c++ -Wno-return-type -fblocks -fms-extensions -rewrite-objc -fobjc-runtime=macosx-fragile-10.5 ${LLVM_SRC}/llvm/tools/clang/test/Rewriter/rewrite-protocol-property.mm -o ${TEST_TEMP_DIR}/rewrite-protocol-property.mm.tmp-rw.cpp
    RUN(TestState.Failed, "%clang_cc1 -x objective-c++ -Wno-return-type -fblocks -fms-extensions -rewrite-objc -fobjc-runtime=macosx-fragile-10.5 %s -o %t-rw.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -fblocks -Wno-address-of-temporary '-Did="void*"' '-D"SEL=void*"' '-D"__declspec(X)="' ${TEST_TEMP_DIR}/rewrite-protocol-property.mm.tmp-rw.cpp
    RUN(TestState.Failed, "%clang_cc1 -fsyntax-only -fblocks -Wno-address-of-temporary -Did=\"void*\" -D\"SEL=void*\" -D\"__declspec(X)=\" %t-rw.cpp");
  }

  @Test
  public void test_rewrite_protocol_qualified_mm() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Rewriter/rewrite-protocol-qualified.mm");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x objective-c++ -Wno-return-type -fblocks -fms-extensions -rewrite-objc -fobjc-runtime=macosx-fragile-10.5 ${LLVM_SRC}/llvm/tools/clang/test/Rewriter/rewrite-protocol-qualified.mm -o ${TEST_TEMP_DIR}/rewrite-protocol-qualified.mm.tmp-rw.cpp
    RUN(TestState.Failed, "%clang_cc1 -x objective-c++ -Wno-return-type -fblocks -fms-extensions -rewrite-objc -fobjc-runtime=macosx-fragile-10.5 %s -o %t-rw.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -Wno-address-of-temporary '-D"SEL=void*"' '-D"id=void*"' '-D"__declspec(X)="' ${TEST_TEMP_DIR}/rewrite-protocol-qualified.mm.tmp-rw.cpp
    RUN(TestState.Failed, "%clang_cc1 -fsyntax-only -Wno-address-of-temporary -D\"SEL=void*\" -D\"id=void*\" -D\"__declspec(X)=\" %t-rw.cpp");
  }

  @Test
  public void test_rewrite_protocol_type_1_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Rewriter/rewrite-protocol-type-1.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -rewrite-objc -fobjc-runtime=macosx-fragile-10.5 ${LLVM_SRC}/llvm/tools/clang/test/Rewriter/rewrite-protocol-type-1.m -o -
    RUN(TestState.Failed, "%clang_cc1 -rewrite-objc -fobjc-runtime=macosx-fragile-10.5  %s -o -");
  }

  @Test
  public void test_rewrite_qualified_id_mm() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Rewriter/rewrite-qualified-id.mm");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x objective-c++ -Wno-return-type -fblocks -fms-extensions -rewrite-objc -fobjc-runtime=macosx-fragile-10.5 ${LLVM_SRC}/llvm/tools/clang/test/Rewriter/rewrite-qualified-id.mm -o ${TEST_TEMP_DIR}/rewrite-qualified-id.mm.tmp-rw.cpp
    RUN(TestState.Failed, "%clang_cc1 -x objective-c++ -Wno-return-type -fblocks -fms-extensions -rewrite-objc -fobjc-runtime=macosx-fragile-10.5 %s -o %t-rw.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -Wno-address-of-temporary '-D"SEL=void*"' '-D"__declspec(X)="' ${TEST_TEMP_DIR}/rewrite-qualified-id.mm.tmp-rw.cpp
    RUN(TestState.Failed, "%clang_cc1 -fsyntax-only -Wno-address-of-temporary -D\"SEL=void*\" -D\"__declspec(X)=\" %t-rw.cpp");
  }

  @Test
  public void test_rewrite_rewritten_initializer_mm() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Rewriter/rewrite-rewritten-initializer.mm");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x objective-c++ -Wno-return-type -fblocks -fms-extensions -rewrite-objc -fobjc-runtime=macosx-fragile-10.5 ${LLVM_SRC}/llvm/tools/clang/test/Rewriter/rewrite-rewritten-initializer.mm -o ${TEST_TEMP_DIR}/rewrite-rewritten-initializer.mm.tmp-rw.cpp
    RUN(TestState.Failed, "%clang_cc1 -x objective-c++ -Wno-return-type -fblocks -fms-extensions -rewrite-objc -fobjc-runtime=macosx-fragile-10.5 %s -o %t-rw.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -Wno-address-of-temporary '-D"SEL=void*"' -U__declspec '-D"__declspec(X)="' ${TEST_TEMP_DIR}/rewrite-rewritten-initializer.mm.tmp-rw.cpp
    RUN(TestState.Failed, "%clang_cc1 -fsyntax-only -Wno-address-of-temporary -D\"SEL=void*\" -U__declspec -D\"__declspec(X)=\" %t-rw.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x objective-c++ -Wno-return-type -fblocks -fms-extensions -rewrite-objc ${LLVM_SRC}/llvm/tools/clang/test/Rewriter/rewrite-rewritten-initializer.mm -o ${TEST_TEMP_DIR}/rewrite-rewritten-initializer.mm.tmp-rw-modern.cpp
    RUN(TestState.Failed, "%clang_cc1 -x objective-c++ -Wno-return-type -fblocks -fms-extensions -rewrite-objc %s -o %t-rw-modern.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -Werror -Wno-address-of-temporary '-D"SEL=void*"' -U__declspec '-D"__declspec(X)="' ${TEST_TEMP_DIR}/rewrite-rewritten-initializer.mm.tmp-rw-modern.cpp
    RUN(TestState.Failed, "%clang_cc1 -fsyntax-only -Werror -Wno-address-of-temporary -D\"SEL=void*\" -U__declspec -D\"__declspec(X)=\" %t-rw-modern.cpp");
  }

  @Test
  public void test_rewrite_static_block_mm() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Rewriter/rewrite-static-block.mm");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x objective-c++ -Wno-return-type -fblocks -fms-extensions -rewrite-objc -fobjc-runtime=macosx-fragile-10.5 ${LLVM_SRC}/llvm/tools/clang/test/Rewriter/rewrite-static-block.mm -o ${TEST_TEMP_DIR}/rewrite-static-block.mm.tmp-rw.cpp
    RUN(TestState.Failed, "%clang_cc1 -x objective-c++ -Wno-return-type -fblocks -fms-extensions -rewrite-objc -fobjc-runtime=macosx-fragile-10.5 %s -o %t-rw.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -Wno-address-of-temporary '-D"SEL=void*"' '-D"__declspec(X)="' ${TEST_TEMP_DIR}/rewrite-static-block.mm.tmp-rw.cpp -emit-llvm -o ${TEST_TEMP_DIR}/rewrite-static-block.mm.tmp-rw.ll
    RUN(TestState.Failed, "%clang_cc1 -Wno-address-of-temporary -D\"SEL=void*\" -D\"__declspec(X)=\" %t-rw.cpp -emit-llvm -o %t-rw.ll");
    // ${LLVM_SRC}/build/bin/FileCheck '--input-file=${TEST_TEMP_DIR}/rewrite-static-block.mm.tmp-rw.ll' ${LLVM_SRC}/llvm/tools/clang/test/Rewriter/rewrite-static-block.mm
    RUN(TestState.Failed, "FileCheck --input-file=%t-rw.ll %s");
  }

  @Test
  public void test_rewrite_super_message_mm() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Rewriter/rewrite-super-message.mm");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x objective-c++ -Wno-return-type -fblocks -fms-extensions -rewrite-objc -fobjc-runtime=macosx-fragile-10.5 ${LLVM_SRC}/llvm/tools/clang/test/Rewriter/rewrite-super-message.mm -o ${TEST_TEMP_DIR}/rewrite-super-message.mm.tmp-rw.cpp
    RUN(TestState.Failed, "%clang_cc1 -x objective-c++ -Wno-return-type -fblocks -fms-extensions -rewrite-objc -fobjc-runtime=macosx-fragile-10.5 %s -o %t-rw.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -Wno-address-of-temporary -DKEEP_ATTRIBUTES '-D"id=struct objc_object *"' '-D"Class=struct objc_class *"' '-D"SEL=void*"' '-D"__declspec(X)="' -emit-llvm -o - ${TEST_TEMP_DIR}/rewrite-super-message.mm.tmp-rw.cpp | ${LLVM_SRC}/build/bin/FileCheck ${TEST_TEMP_DIR}/rewrite-super-message.mm.tmp-rw.cpp
    RUN(TestState.Failed, "%clang_cc1 -fsyntax-only -Wno-address-of-temporary -DKEEP_ATTRIBUTES -D\"id=struct objc_object *\" -D\"Class=struct objc_class *\" -D\"SEL=void*\" -D\"__declspec(X)=\" -emit-llvm -o - %t-rw.cpp")./*|*/
      I("FileCheck %t-rw.cpp");
  }

  @Test
  public void test_rewrite_trivial_constructor_mm() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Rewriter/rewrite-trivial-constructor.mm");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fms-extensions -rewrite-objc -fobjc-runtime=macosx-fragile-10.5 -x objective-c++ -fblocks -o - ${LLVM_SRC}/llvm/tools/clang/test/Rewriter/rewrite-trivial-constructor.mm
    RUN(TestState.Failed, "%clang_cc1 -fms-extensions -rewrite-objc -fobjc-runtime=macosx-fragile-10.5 -x objective-c++ -fblocks -o - %s");
  }

  @Test
  public void test_rewrite_try_catch_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Rewriter/rewrite-try-catch.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -rewrite-objc -fobjc-runtime=macosx-fragile-10.5 ${LLVM_SRC}/llvm/tools/clang/test/Rewriter/rewrite-try-catch.m -o -
    RUN(TestState.Failed, "%clang_cc1 -rewrite-objc -fobjc-runtime=macosx-fragile-10.5  %s -o -");
  }

  @Test
  public void test_rewrite_typeof_mm() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Rewriter/rewrite-typeof.mm");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x objective-c++ -fblocks -fms-extensions -rewrite-objc -fobjc-runtime=macosx-fragile-10.5 ${LLVM_SRC}/llvm/tools/clang/test/Rewriter/rewrite-typeof.mm -o ${TEST_TEMP_DIR}/rewrite-typeof.mm.tmp-rw.cpp
    RUN(TestState.Failed, "%clang_cc1 -x objective-c++ -fblocks -fms-extensions -rewrite-objc -fobjc-runtime=macosx-fragile-10.5 %s -o %t-rw.cpp");
    // ${LLVM_SRC}/build/bin/FileCheck -check-prefix CHECK-LP '--input-file=${TEST_TEMP_DIR}/rewrite-typeof.mm.tmp-rw.cpp' ${LLVM_SRC}/llvm/tools/clang/test/Rewriter/rewrite-typeof.mm
    RUN(TestState.Failed, "FileCheck -check-prefix CHECK-LP --input-file=%t-rw.cpp %s");
  }

  @Test
  public void test_rewrite_unique_block_api_mm() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Rewriter/rewrite-unique-block-api.mm");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x objective-c++ -fblocks -fms-extensions -rewrite-objc -fobjc-runtime=macosx-fragile-10.5 ${LLVM_SRC}/llvm/tools/clang/test/Rewriter/rewrite-unique-block-api.mm -o ${TEST_TEMP_DIR}/rewrite-unique-block-api.mm.tmp-rw.cpp
    RUN(TestState.Failed, "%clang_cc1 -x objective-c++ -fblocks -fms-extensions -rewrite-objc -fobjc-runtime=macosx-fragile-10.5 %s -o %t-rw.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -Wno-address-of-temporary '-D"SEL=void*"' '-D"__declspec(X)="' ${TEST_TEMP_DIR}/rewrite-unique-block-api.mm.tmp-rw.cpp
    RUN(TestState.Failed, "%clang_cc1 -fsyntax-only -Wno-address-of-temporary -D\"SEL=void*\" -D\"__declspec(X)=\" %t-rw.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x objective-c++ -fblocks -fms-extensions -rewrite-objc ${LLVM_SRC}/llvm/tools/clang/test/Rewriter/rewrite-unique-block-api.mm -o ${TEST_TEMP_DIR}/rewrite-unique-block-api.mm.tmp-modern-rw.cpp
    RUN(TestState.Failed, "%clang_cc1 -x objective-c++ -fblocks -fms-extensions -rewrite-objc %s -o %t-modern-rw.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -Wno-address-of-temporary '-D"SEL=void*"' '-D"__declspec(X)="' ${TEST_TEMP_DIR}/rewrite-unique-block-api.mm.tmp-modern-rw.cpp
    RUN(TestState.Failed, "%clang_cc1 -fsyntax-only -Wno-address-of-temporary -D\"SEL=void*\" -D\"__declspec(X)=\" %t-modern-rw.cpp");
  }

  @Test
  public void test_rewrite_user_defined_accessors_mm() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Rewriter/rewrite-user-defined-accessors.mm");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x objective-c++ -Wno-return-type -fblocks -fms-extensions -rewrite-objc -fobjc-runtime=macosx-fragile-10.5 ${LLVM_SRC}/llvm/tools/clang/test/Rewriter/rewrite-user-defined-accessors.mm -o ${TEST_TEMP_DIR}/rewrite-user-defined-accessors.mm.tmp-rw.cpp
    RUN(TestState.Failed, "%clang_cc1 -x objective-c++ -Wno-return-type -fblocks -fms-extensions -rewrite-objc -fobjc-runtime=macosx-fragile-10.5 %s -o %t-rw.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -fblocks -Wno-address-of-temporary '-Did="void*"' '-D"SEL=void*"' '-D"__declspec(X)="' ${TEST_TEMP_DIR}/rewrite-user-defined-accessors.mm.tmp-rw.cpp
    RUN(TestState.Failed, "%clang_cc1 -fsyntax-only -fblocks -Wno-address-of-temporary -Did=\"void*\" -D\"SEL=void*\" -D\"__declspec(X)=\" %t-rw.cpp");
  }

  @Test
  public void test_rewrite_vararg_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Rewriter/rewrite-vararg.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x objective-c++ -Wno-return-type -fblocks -fms-extensions -rewrite-objc -fobjc-runtime=macosx-fragile-10.5 ${LLVM_SRC}/llvm/tools/clang/test/Rewriter/rewrite-vararg.m -o ${TEST_TEMP_DIR}/rewrite-vararg.m.tmp-rw.cpp
    RUN(TestState.Failed, "%clang_cc1 -x objective-c++ -Wno-return-type -fblocks -fms-extensions -rewrite-objc -fobjc-runtime=macosx-fragile-10.5  %s -o %t-rw.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -fblocks -Wno-address-of-temporary '-D"id=void*"' '-D"SEL=void*"' '-D"__declspec(X)="' ${TEST_TEMP_DIR}/rewrite-vararg.m.tmp-rw.cpp
    RUN(TestState.Failed, "%clang_cc1 -fsyntax-only -fblocks -Wno-address-of-temporary -D\"id=void*\" -D\"SEL=void*\" -D\"__declspec(X)=\" %t-rw.cpp");
  }

  @Test
  public void test_rewrite_weak_attr_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Rewriter/rewrite-weak-attr.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i686-pc-win32 -fms-extensions -fblocks -Dnil=0 -rewrite-objc -fobjc-runtime=macosx-fragile-10.5 -o - ${LLVM_SRC}/llvm/tools/clang/test/Rewriter/rewrite-weak-attr.m
    RUN(TestState.Failed, "%clang_cc1 -triple i686-pc-win32 -fms-extensions -fblocks -Dnil=0 -rewrite-objc -fobjc-runtime=macosx-fragile-10.5   -o - %s");
  }

  @Test
  public void test_static_type_protocol_1_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Rewriter/static-type-protocol-1.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -rewrite-objc -fobjc-runtime=macosx-fragile-10.5 ${LLVM_SRC}/llvm/tools/clang/test/Rewriter/static-type-protocol-1.m -o -
    RUN(TestState.Failed, "%clang_cc1 -rewrite-objc -fobjc-runtime=macosx-fragile-10.5  %s -o -");
  }

  @Test
  public void test_undecl_objc_h_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Rewriter/undecl-objc-h.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -rewrite-objc -fobjc-runtime=macosx-fragile-10.5 ${LLVM_SRC}/llvm/tools/clang/test/Rewriter/undecl-objc-h.m -o -
    RUN(TestState.Failed, "%clang_cc1 -rewrite-objc -fobjc-runtime=macosx-fragile-10.5  %s -o -");
  }

  @Test
  public void test_undeclared_method_1_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Rewriter/undeclared-method-1.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -rewrite-objc -fobjc-runtime=macosx-fragile-10.5 ${LLVM_SRC}/llvm/tools/clang/test/Rewriter/undeclared-method-1.m -o -
    RUN(TestState.Failed, "%clang_cc1 -rewrite-objc -fobjc-runtime=macosx-fragile-10.5  %s -o -");
  }

  @Test
  public void test_undef_field_reference_1_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Rewriter/undef-field-reference-1.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -rewrite-objc -fobjc-runtime=macosx-fragile-10.5 ${LLVM_SRC}/llvm/tools/clang/test/Rewriter/undef-field-reference-1.m -o -
    RUN(TestState.Failed, "%clang_cc1 -rewrite-objc -fobjc-runtime=macosx-fragile-10.5  %s -o -");
  }

  @Test
  public void test_unnamed_bf_modern_write_mm() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Rewriter/unnamed-bf-modern-write.mm");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -E ${LLVM_SRC}/llvm/tools/clang/test/Rewriter/unnamed-bf-modern-write.mm -o ${TEST_TEMP_DIR}/unnamed-bf-modern-write.mm.tmp.mm
    RUN(TestState.Failed, "%clang_cc1 -E %s -o %t.mm");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x objective-c++ -fblocks -fms-extensions -rewrite-objc ${TEST_TEMP_DIR}/unnamed-bf-modern-write.mm.tmp.mm -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Rewriter/unnamed-bf-modern-write.mm
    RUN(TestState.Failed, "%clang_cc1 -x objective-c++ -fblocks -fms-extensions -rewrite-objc %t.mm -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_va_method_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Rewriter/va-method.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -rewrite-objc -fobjc-runtime=macosx-fragile-10.5 ${LLVM_SRC}/llvm/tools/clang/test/Rewriter/va-method.m -o -
    RUN(TestState.Failed, "%clang_cc1 -rewrite-objc -fobjc-runtime=macosx-fragile-10.5  %s -o -");
  }

  @Test
  public void test_weak_byref_objects_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Rewriter/weak_byref_objects.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fblocks -triple i386-apple-darwin9 -fobjc-gc -rewrite-objc -fobjc-runtime=macosx-fragile-10.5 ${LLVM_SRC}/llvm/tools/clang/test/Rewriter/weak_byref_objects.m -o -
    RUN(TestState.Failed, "%clang_cc1 -fblocks -triple i386-apple-darwin9 -fobjc-gc -rewrite-objc -fobjc-runtime=macosx-fragile-10.5  %s -o -");
  }
  
}
