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
package org.clang.frontend.test;

import org.clang.tools.driver.test.DriverTestFileBase;
import org.junit.*;

/**
 * Collection of all test files from test/Frontend folder
 * @author Vladimir Voskresensky
 */
public class AllFrontendTest extends DriverTestFileBase {
  private static final String TEST_LOCATION = "${LLVM_SRC}/llvm/tools/clang/test/Frontend/";
  public AllFrontendTest() {
    super(TEST_LOCATION, TestState.Successful);
  }
  
  public static void main(String[] args) {
    // Print tests which will be accepted per test case
    DriverTestFileBase.printAllTestFiles(false, 
            TEST_LOCATION, (test)->{ return true;/*test.getFileIndexInFolder()<120;*/ }, 
            "${SPUTNIK}/modules/org.clang.frontend/test/unit/src/org/clang/frontend/test/AllFrontendTest.txt");
  }  

  @Override
  protected boolean keepStacksForUnimplementedMethods() {
    return false;
  }
  
  @Test
  public void test_Weverything_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Frontend/Weverything.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -verify -Weverything -pedantic-errors ${LLVM_SRC}/llvm/tools/clang/test/Frontend/Weverything.c
    RUN("%clang_cc1 -verify -Weverything -pedantic-errors %s");
  }

  @Test
  public void test_Wno_everything_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Frontend/Wno-everything.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -verify -Wno-everything -Wsign-compare ${LLVM_SRC}/llvm/tools/clang/test/Frontend/Wno-everything.c
    RUN("%clang_cc1 -verify -Wno-everything -Wsign-compare %s");
  }

  @Test
  public void test_ast_codegen_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Frontend/ast-codegen.c");
    // REQUIRES: x86-registered-target
    if (!CHECK_REQUIRES("x86-registered-target")) {
      return;
    }
    // ${LLVM_SRC}/build/bin/clang -target i386-unknown-unknown -emit-ast -o ${TEST_TEMP_DIR}/ast-codegen.c.tmp.ast ${LLVM_SRC}/llvm/tools/clang/test/Frontend/ast-codegen.c
    RUN(TestState.Failed, "%clang -target i386-unknown-unknown -emit-ast -o %t.ast %s");
    // ${LLVM_SRC}/build/bin/clang -target i386-unknown-unknown -emit-llvm -S -o - ${TEST_TEMP_DIR}/ast-codegen.c.tmp.ast | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Frontend/ast-codegen.c
    RUN(TestState.Failed, "%clang -target i386-unknown-unknown -emit-llvm -S -o - %t.ast")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_ast_main_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Frontend/ast-main.c");
    // ${LLVM_SRC}/build/bin/clang -emit-llvm -S -o ${TEST_TEMP_DIR}/ast-main.c.tmp1.ll -x c - < ${LLVM_SRC}/llvm/tools/clang/test/Frontend/ast-main.c
    RUN( "%clang -emit-llvm -S -o %t1.ll -x c - < %s");
    // ${LLVM_SRC}/build/bin/clang -emit-ast -o ${TEST_TEMP_DIR}/ast-main.c.tmp.ast ${LLVM_SRC}/llvm/tools/clang/test/Frontend/ast-main.c
    RUN( "%clang -emit-ast -o %t.ast %s");
    // ${LLVM_SRC}/build/bin/clang -emit-llvm -S -o ${TEST_TEMP_DIR}/ast-main.c.tmp2.ll -x ast - < ${TEST_TEMP_DIR}/ast-main.c.tmp.ast
    RUN( "%clang -emit-llvm -S -o %t2.ll -x ast - < %t.ast");
    // diff ${TEST_TEMP_DIR}/ast-main.c.tmp1.ll ${TEST_TEMP_DIR}/ast-main.c.tmp2.ll
    RUN( "diff %t1.ll %t2.ll");
  }

  @Test
  public void test_ast_main_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Frontend/ast-main.cpp");
    // ${LLVM_SRC}/build/bin/clang -emit-llvm -S -o ${TEST_TEMP_DIR}/ast-main.cpp.tmp1.ll -x c++ - < ${LLVM_SRC}/llvm/tools/clang/test/Frontend/ast-main.cpp
    RUN(TestState.Failed, "%clang -emit-llvm -S -o %t1.ll -x c++ - < %s");
    // ${LLVM_SRC}/build/bin/clang -fno-delayed-template-parsing -emit-ast -o ${TEST_TEMP_DIR}/ast-main.cpp.tmp.ast ${LLVM_SRC}/llvm/tools/clang/test/Frontend/ast-main.cpp
    RUN(TestState.Failed, "%clang -fno-delayed-template-parsing -emit-ast -o %t.ast %s");
    // ${LLVM_SRC}/build/bin/clang -emit-llvm -S -o ${TEST_TEMP_DIR}/ast-main.cpp.tmp2.ll -x ast - < ${TEST_TEMP_DIR}/ast-main.cpp.tmp.ast
    RUN(TestState.Failed, "%clang -emit-llvm -S -o %t2.ll -x ast - < %t.ast");
    // diff ${TEST_TEMP_DIR}/ast-main.cpp.tmp1.ll ${TEST_TEMP_DIR}/ast-main.cpp.tmp2.ll
    RUN(TestState.Failed, "diff %t1.ll %t2.ll");
  }

  @Test
  public void test_backend_diagnostic_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Frontend/backend-diagnostic.c");
    // REQUIRES: x86-registered-target
    if (!CHECK_REQUIRES("x86-registered-target")) {
      return;
    }
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/Frontend/backend-diagnostic.c -mllvm -warn-stack-size=0 -no-integrated-as -S -o - -triple=i386-apple-darwin 2> ${TEST_TEMP_DIR}/backend-diagnostic.c.tmp.err
    RUN(TestState.SemanticErrors/*WarnStackSize from llvm/CodeGen is not generated*/, "not %clang_cc1 %s -mllvm -warn-stack-size=0 -no-integrated-as -S -o - -triple=i386-apple-darwin 2> %t.err");
    // ${LLVM_SRC}/build/bin/FileCheck < ${TEST_TEMP_DIR}/backend-diagnostic.c.tmp.err ${LLVM_SRC}/llvm/tools/clang/test/Frontend/backend-diagnostic.c --check-prefix=REGULAR --check-prefix=ASM
    RUN(TestState.Failed, "FileCheck < %t.err %s --check-prefix=REGULAR --check-prefix=ASM");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/Frontend/backend-diagnostic.c -mllvm -warn-stack-size=0 -no-integrated-as -S -o - -triple=i386-apple-darwin -Werror=frame-larger-than= 2> ${TEST_TEMP_DIR}/backend-diagnostic.c.tmp.err
    RUN(TestState.SemanticErrors/*WarnStackSize from llvm/CodeGen is not generated*/, "not %clang_cc1 %s -mllvm -warn-stack-size=0 -no-integrated-as -S -o - -triple=i386-apple-darwin -Werror=frame-larger-than= 2> %t.err");
    // ${LLVM_SRC}/build/bin/FileCheck < ${TEST_TEMP_DIR}/backend-diagnostic.c.tmp.err ${LLVM_SRC}/llvm/tools/clang/test/Frontend/backend-diagnostic.c --check-prefix=PROMOTE --check-prefix=ASM
    RUN(TestState.Failed, "FileCheck < %t.err %s --check-prefix=PROMOTE --check-prefix=ASM");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/Frontend/backend-diagnostic.c -mllvm -warn-stack-size=0 -no-integrated-as -S -o - -triple=i386-apple-darwin -Wno-frame-larger-than= 2> ${TEST_TEMP_DIR}/backend-diagnostic.c.tmp.err
    RUN(TestState.SemanticErrors/*WarnStackSize from llvm/CodeGen is not generated*/, "not %clang_cc1 %s -mllvm -warn-stack-size=0 -no-integrated-as -S -o - -triple=i386-apple-darwin -Wno-frame-larger-than= 2> %t.err");
    // ${LLVM_SRC}/build/bin/FileCheck < ${TEST_TEMP_DIR}/backend-diagnostic.c.tmp.err ${LLVM_SRC}/llvm/tools/clang/test/Frontend/backend-diagnostic.c --check-prefix=IGNORE --check-prefix=ASM
    RUN(TestState.Failed, "FileCheck < %t.err %s --check-prefix=IGNORE --check-prefix=ASM");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/Frontend/backend-diagnostic.c -S -o - -triple=i386-apple-darwin -verify -no-integrated-as
    RUN(TestState.Failed, "%clang_cc1 %s -S -o - -triple=i386-apple-darwin -verify -no-integrated-as");
  }

  @Test
  public void test_backend_option_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Frontend/backend-option.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/Frontend/backend-option.c -emit-llvm -backend-option -time-passes -o - 2>&1 | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Frontend/backend-option.c
    RUN(TestState.Failed, "%clang_cc1 %s -emit-llvm -backend-option -time-passes -o - 2>&1")./*|*/
      I("FileCheck %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/Frontend/backend-option.c -emit-llvm -backend-option -time-passes -o - -triple spir-unknown-unknown 2>&1 | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Frontend/backend-option.c
    RUN(TestState.Failed, "%clang_cc1 %s -emit-llvm -backend-option -time-passes -o - -triple spir-unknown-unknown 2>&1")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_cc1_return_codes_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Frontend/cc1-return-codes.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -help
    RUN("%clang -cc1 -help");
    // ${LLVM_SRC}/build/bin/clang -cc1 -version
    RUN(TestState.Failed, "%clang -cc1 -version");
  }

  @Test
  public void test_cpp_output_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Frontend/cpp-output.c");
    // ${LLVM_SRC}/build/bin/clang -E -o ${TEST_TEMP_DIR}/cpp-output.c.tmp -C ${LLVM_SRC}/llvm/tools/clang/test/Frontend/cpp-output.c
    RUN("%clang -E -o %t -C %s");
    // grep '^int x; // comment' ${TEST_TEMP_DIR}/cpp-output.c.tmp
    RUN("grep '^int x; // comment' %t");
    // grep '^x x' ${TEST_TEMP_DIR}/cpp-output.c.tmp
    RUN("grep '^x x' %t");
    // ${LLVM_SRC}/build/bin/clang -E -o ${TEST_TEMP_DIR}/cpp-output.c.tmp -CC ${LLVM_SRC}/llvm/tools/clang/test/Frontend/cpp-output.c
    RUN("%clang -E -o %t -CC %s");
    // grep '^int x; // comment' ${TEST_TEMP_DIR}/cpp-output.c.tmp
    RUN("grep '^int x; // comment' %t");
    // grep '^x /\* comment \*/ x /\* comment \*/' ${TEST_TEMP_DIR}/cpp-output.c.tmp
    RUN("grep '^x /\\* comment \\*/ x /\\* comment \\*/' %t");
  }

  @Test
  public void test_darwin_eabi_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Frontend/darwin-eabi.c");
    // ${LLVM_SRC}/build/bin/clang -arch armv6m -dM -E ${LLVM_SRC}/llvm/tools/clang/test/Frontend/darwin-eabi.c | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Frontend/darwin-eabi.c
    RUN("%clang -arch armv6m -dM -E %s")./*|*/
      I("FileCheck %s");
    // ${LLVM_SRC}/build/bin/clang -arch armv7m -dM -E ${LLVM_SRC}/llvm/tools/clang/test/Frontend/darwin-eabi.c | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Frontend/darwin-eabi.c
    RUN("%clang -arch armv7m -dM -E %s")./*|*/
      I("FileCheck %s");
    // ${LLVM_SRC}/build/bin/clang -arch armv7em -dM -E ${LLVM_SRC}/llvm/tools/clang/test/Frontend/darwin-eabi.c | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Frontend/darwin-eabi.c
    RUN("%clang -arch armv7em -dM -E %s")./*|*/
      I("FileCheck %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple thumbv7m-apple-unknown-macho -dM -E ${LLVM_SRC}/llvm/tools/clang/test/Frontend/darwin-eabi.c | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Frontend/darwin-eabi.c
    RUN("%clang_cc1 -triple thumbv7m-apple-unknown-macho -dM -E %s")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_darwin_version_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Frontend/darwin-version.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple armv6-apple-ios3.0.0 -dM -E -o ${TEST_TEMP_DIR}/darwin-version.c.tmp ${LLVM_SRC}/llvm/tools/clang/test/Frontend/darwin-version.c
    RUN("%clang_cc1 -triple armv6-apple-ios3.0.0 -dM -E -o %t %s");
    // grep __ENVIRONMENT_IPHONE_OS_VERSION_MIN_REQUIRED__ ${TEST_TEMP_DIR}/darwin-version.c.tmp | grep 30000 | ${LLVM_SRC}/build/bin/count 1
    RUN("grep '__ENVIRONMENT_IPHONE_OS_VERSION_MIN_REQUIRED__' %t")./*|*/
      I("grep '30000'")./*|*/
      I("count 1");
    // grep __ENVIRONMENT_MAC_OS_X_VERSION_MIN_REQUIRED__ ${TEST_TEMP_DIR}/darwin-version.c.tmp
    RUN("not grep '__ENVIRONMENT_MAC_OS_X_VERSION_MIN_REQUIRED__' %t");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple armv6-apple-ios2.0.0 -dM -E -o ${TEST_TEMP_DIR}/darwin-version.c.tmp ${LLVM_SRC}/llvm/tools/clang/test/Frontend/darwin-version.c
    RUN("%clang_cc1 -triple armv6-apple-ios2.0.0 -dM -E -o %t %s");
    // grep __ENVIRONMENT_IPHONE_OS_VERSION_MIN_REQUIRED__ ${TEST_TEMP_DIR}/darwin-version.c.tmp | grep 20000 | ${LLVM_SRC}/build/bin/count 1
    RUN("grep '__ENVIRONMENT_IPHONE_OS_VERSION_MIN_REQUIRED__' %t")./*|*/
      I("grep '20000'")./*|*/
      I("count 1");
    // grep __ENVIRONMENT_MAC_OS_X_VERSION_MIN_REQUIRED__ ${TEST_TEMP_DIR}/darwin-version.c.tmp
    RUN("not grep '__ENVIRONMENT_MAC_OS_X_VERSION_MIN_REQUIRED__' %t");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple armv6-apple-ios2.2.0 -dM -E -o ${TEST_TEMP_DIR}/darwin-version.c.tmp ${LLVM_SRC}/llvm/tools/clang/test/Frontend/darwin-version.c
    RUN("%clang_cc1 -triple armv6-apple-ios2.2.0 -dM -E -o %t %s");
    // grep __ENVIRONMENT_IPHONE_OS_VERSION_MIN_REQUIRED__ ${TEST_TEMP_DIR}/darwin-version.c.tmp | grep 20200 | ${LLVM_SRC}/build/bin/count 1
    RUN("grep '__ENVIRONMENT_IPHONE_OS_VERSION_MIN_REQUIRED__' %t")./*|*/
      I("grep '20200'")./*|*/
      I("count 1");
    // grep __ENVIRONMENT_MAC_OS_X_VERSION_MIN_REQUIRED__ ${TEST_TEMP_DIR}/darwin-version.c.tmp
    RUN("not grep '__ENVIRONMENT_MAC_OS_X_VERSION_MIN_REQUIRED__' %t");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple armv6-apple-ios2.3.1 -dM -E -o ${TEST_TEMP_DIR}/darwin-version.c.tmp ${LLVM_SRC}/llvm/tools/clang/test/Frontend/darwin-version.c
    RUN("%clang_cc1 -triple armv6-apple-ios2.3.1 -dM -E -o %t %s");
    // grep __ENVIRONMENT_IPHONE_OS_VERSION_MIN_REQUIRED__ ${TEST_TEMP_DIR}/darwin-version.c.tmp | grep 20301 | ${LLVM_SRC}/build/bin/count 1
    RUN("grep '__ENVIRONMENT_IPHONE_OS_VERSION_MIN_REQUIRED__' %t")./*|*/
      I("grep '20301'")./*|*/
      I("count 1");
    // grep __ENVIRONMENT_MAC_OS_X_VERSION_MIN_REQUIRED__ ${TEST_TEMP_DIR}/darwin-version.c.tmp
    RUN("not grep '__ENVIRONMENT_MAC_OS_X_VERSION_MIN_REQUIRED__' %t");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i386-apple-macosx10.4.0 -dM -E -o ${TEST_TEMP_DIR}/darwin-version.c.tmp ${LLVM_SRC}/llvm/tools/clang/test/Frontend/darwin-version.c
    RUN("%clang_cc1 -triple i386-apple-macosx10.4.0 -dM -E -o %t %s");
    // grep __ENVIRONMENT_MAC_OS_X_VERSION_MIN_REQUIRED__ ${TEST_TEMP_DIR}/darwin-version.c.tmp | grep 1040 | ${LLVM_SRC}/build/bin/count 1
    RUN("grep '__ENVIRONMENT_MAC_OS_X_VERSION_MIN_REQUIRED__' %t")./*|*/
      I("grep '1040'")./*|*/
      I("count 1");
    // grep __ENVIRONMENT_IPHONE_OS_VERSION_MIN_REQUIRED__ ${TEST_TEMP_DIR}/darwin-version.c.tmp
    RUN("not grep '__ENVIRONMENT_IPHONE_OS_VERSION_MIN_REQUIRED__' %t");
    // grep __ENVIRONMENT_TV_OS_VERSION_MIN_REQUIRED__ ${TEST_TEMP_DIR}/darwin-version.c.tmp
    RUN("not grep '__ENVIRONMENT_TV_OS_VERSION_MIN_REQUIRED__' %t");
    // grep __ENVIRONMENT_WATCH_OS_VERSION_MIN_REQUIRED__ ${TEST_TEMP_DIR}/darwin-version.c.tmp
    RUN("not grep '__ENVIRONMENT_WATCH_OS_VERSION_MIN_REQUIRED__' %t");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i386-apple-macosx10.4.10 -dM -E -o ${TEST_TEMP_DIR}/darwin-version.c.tmp ${LLVM_SRC}/llvm/tools/clang/test/Frontend/darwin-version.c
    RUN("%clang_cc1 -triple i386-apple-macosx10.4.10 -dM -E -o %t %s");
    // grep __ENVIRONMENT_MAC_OS_X_VERSION_MIN_REQUIRED__ ${TEST_TEMP_DIR}/darwin-version.c.tmp | grep 1049 | ${LLVM_SRC}/build/bin/count 1
    RUN("grep '__ENVIRONMENT_MAC_OS_X_VERSION_MIN_REQUIRED__' %t")./*|*/
      I("grep '1049'")./*|*/
      I("count 1");
    // grep __ENVIRONMENT_IPHONE_OS_VERSION_MIN_REQUIRED__ ${TEST_TEMP_DIR}/darwin-version.c.tmp
    RUN("not grep '__ENVIRONMENT_IPHONE_OS_VERSION_MIN_REQUIRED__' %t");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i386-apple-macosx10.5.0 -dM -E -o ${TEST_TEMP_DIR}/darwin-version.c.tmp ${LLVM_SRC}/llvm/tools/clang/test/Frontend/darwin-version.c
    RUN("%clang_cc1 -triple i386-apple-macosx10.5.0 -dM -E -o %t %s");
    // grep __ENVIRONMENT_MAC_OS_X_VERSION_MIN_REQUIRED__ ${TEST_TEMP_DIR}/darwin-version.c.tmp | grep 1050 | ${LLVM_SRC}/build/bin/count 1
    RUN("grep '__ENVIRONMENT_MAC_OS_X_VERSION_MIN_REQUIRED__' %t")./*|*/
      I("grep '1050'")./*|*/
      I("count 1");
    // grep __ENVIRONMENT_IPHONE_OS_VERSION_MIN_REQUIRED__ ${TEST_TEMP_DIR}/darwin-version.c.tmp
    RUN("not grep '__ENVIRONMENT_IPHONE_OS_VERSION_MIN_REQUIRED__' %t");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i386-apple-macosx10.6.0 -dM -E -o ${TEST_TEMP_DIR}/darwin-version.c.tmp ${LLVM_SRC}/llvm/tools/clang/test/Frontend/darwin-version.c
    RUN("%clang_cc1 -triple i386-apple-macosx10.6.0 -dM -E -o %t %s");
    // grep __ENVIRONMENT_MAC_OS_X_VERSION_MIN_REQUIRED__ ${TEST_TEMP_DIR}/darwin-version.c.tmp | grep 1060 | ${LLVM_SRC}/build/bin/count 1
    RUN("grep '__ENVIRONMENT_MAC_OS_X_VERSION_MIN_REQUIRED__' %t")./*|*/
      I("grep '1060'")./*|*/
      I("count 1");
    // grep __ENVIRONMENT_IPHONE_OS_VERSION_MIN_REQUIRED__ ${TEST_TEMP_DIR}/darwin-version.c.tmp
    RUN("not grep '__ENVIRONMENT_IPHONE_OS_VERSION_MIN_REQUIRED__' %t");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-apple-macosx10.10.0 -dM -E -o ${TEST_TEMP_DIR}/darwin-version.c.tmp ${LLVM_SRC}/llvm/tools/clang/test/Frontend/darwin-version.c
    RUN("%clang_cc1 -triple x86_64-apple-macosx10.10.0 -dM -E -o %t %s");
    // grep __ENVIRONMENT_MAC_OS_X_VERSION_MIN_REQUIRED__ ${TEST_TEMP_DIR}/darwin-version.c.tmp | grep 101000 | ${LLVM_SRC}/build/bin/count 1
    RUN("grep '__ENVIRONMENT_MAC_OS_X_VERSION_MIN_REQUIRED__' %t")./*|*/
      I("grep '101000'")./*|*/
      I("count 1");
    // grep __ENVIRONMENT_IPHONE_OS_VERSION_MIN_REQUIRED__ ${TEST_TEMP_DIR}/darwin-version.c.tmp
    RUN("not grep '__ENVIRONMENT_IPHONE_OS_VERSION_MIN_REQUIRED__' %t");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple arm64-apple-tvos8.3 -dM -E -o ${TEST_TEMP_DIR}/darwin-version.c.tmp ${LLVM_SRC}/llvm/tools/clang/test/Frontend/darwin-version.c
    RUN("%clang_cc1 -triple arm64-apple-tvos8.3 -dM -E -o %t %s");
    // grep __ENVIRONMENT_TV_OS_VERSION_MIN_REQUIRED__ ${TEST_TEMP_DIR}/darwin-version.c.tmp | grep 80300 | ${LLVM_SRC}/build/bin/count 1
    RUN("grep '__ENVIRONMENT_TV_OS_VERSION_MIN_REQUIRED__' %t")./*|*/
      I("grep '80300'")./*|*/
      I("count 1");
    // grep __ENVIRONMENT_MAC_OS_X_VERSION_MIN_REQUIRED__ ${TEST_TEMP_DIR}/darwin-version.c.tmp
    RUN("not grep '__ENVIRONMENT_MAC_OS_X_VERSION_MIN_REQUIRED__' %t");
    // grep __ENVIRONMENT_IPHONE_OS_VERSION_MIN_REQUIRED__ ${TEST_TEMP_DIR}/darwin-version.c.tmp
    RUN("not grep '__ENVIRONMENT_IPHONE_OS_VERSION_MIN_REQUIRED__' %t");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-apple-tvos8.3 -dM -E -o ${TEST_TEMP_DIR}/darwin-version.c.tmp ${LLVM_SRC}/llvm/tools/clang/test/Frontend/darwin-version.c
    RUN("%clang_cc1 -triple x86_64-apple-tvos8.3 -dM -E -o %t %s");
    // grep __ENVIRONMENT_TV_OS_VERSION_MIN_REQUIRED__ ${TEST_TEMP_DIR}/darwin-version.c.tmp | grep 80300 | ${LLVM_SRC}/build/bin/count 1
    RUN("grep '__ENVIRONMENT_TV_OS_VERSION_MIN_REQUIRED__' %t")./*|*/
      I("grep '80300'")./*|*/
      I("count 1");
    // grep __ENVIRONMENT_MAC_OS_X_VERSION_MIN_REQUIRED__ ${TEST_TEMP_DIR}/darwin-version.c.tmp
    RUN("not grep '__ENVIRONMENT_MAC_OS_X_VERSION_MIN_REQUIRED__' %t");
    // grep __ENVIRONMENT_IPHONE_OS_VERSION_MIN_REQUIRED__ ${TEST_TEMP_DIR}/darwin-version.c.tmp
    RUN("not grep '__ENVIRONMENT_IPHONE_OS_VERSION_MIN_REQUIRED__' %t");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple armv7k-apple-watchos2.1 -dM -E -o ${TEST_TEMP_DIR}/darwin-version.c.tmp ${LLVM_SRC}/llvm/tools/clang/test/Frontend/darwin-version.c
    RUN("%clang_cc1 -triple armv7k-apple-watchos2.1 -dM -E -o %t %s");
    // grep __ENVIRONMENT_WATCH_OS_VERSION_MIN_REQUIRED__ ${TEST_TEMP_DIR}/darwin-version.c.tmp | grep 20100 | ${LLVM_SRC}/build/bin/count 1
    RUN("grep '__ENVIRONMENT_WATCH_OS_VERSION_MIN_REQUIRED__' %t")./*|*/
      I("grep '20100'")./*|*/
      I("count 1");
    // grep __ENVIRONMENT_MAC_OS_X_VERSION_MIN_REQUIRED__ ${TEST_TEMP_DIR}/darwin-version.c.tmp
    RUN("not grep '__ENVIRONMENT_MAC_OS_X_VERSION_MIN_REQUIRED__' %t");
    // grep __ENVIRONMENT_IPHONE_OS_VERSION_MIN_REQUIRED__ ${TEST_TEMP_DIR}/darwin-version.c.tmp
    RUN("not grep '__ENVIRONMENT_IPHONE_OS_VERSION_MIN_REQUIRED__' %t");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i386-apple-watchos2.1 -dM -E -o ${TEST_TEMP_DIR}/darwin-version.c.tmp ${LLVM_SRC}/llvm/tools/clang/test/Frontend/darwin-version.c
    RUN("%clang_cc1 -triple i386-apple-watchos2.1 -dM -E -o %t %s");
    // grep __ENVIRONMENT_WATCH_OS_VERSION_MIN_REQUIRED__ ${TEST_TEMP_DIR}/darwin-version.c.tmp | grep 20100 | ${LLVM_SRC}/build/bin/count 1
    RUN("grep '__ENVIRONMENT_WATCH_OS_VERSION_MIN_REQUIRED__' %t")./*|*/
      I("grep '20100'")./*|*/
      I("count 1");
    // grep __ENVIRONMENT_MAC_OS_X_VERSION_MIN_REQUIRED__ ${TEST_TEMP_DIR}/darwin-version.c.tmp
    RUN("not grep '__ENVIRONMENT_MAC_OS_X_VERSION_MIN_REQUIRED__' %t");
    // grep __ENVIRONMENT_IPHONE_OS_VERSION_MIN_REQUIRED__ ${TEST_TEMP_DIR}/darwin-version.c.tmp
    RUN("not grep '__ENVIRONMENT_IPHONE_OS_VERSION_MIN_REQUIRED__' %t");
  }

  @Test
  public void test_dependency_gen_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Frontend/dependency-gen.c");
    // rm -rf ${TEST_TEMP_DIR}/dependency-gen.c.tmp.dir
    RUN(TestState.Failed, "rm -rf %t.dir");
    // mkdir -p ${TEST_TEMP_DIR}/dependency-gen.c.tmp.dir/a/b
    RUN(TestState.Failed, "mkdir -p %t.dir/a/b");
    // echo > ${TEST_TEMP_DIR}/dependency-gen.c.tmp.dir/a/b/x.h
    RUN(TestState.Failed, "echo > %t.dir/a/b/x.h");
    // cd ${TEST_TEMP_DIR}/dependency-gen.c.tmp.dir
    RUN(TestState.Failed, "cd %t.dir");
    // ${LLVM_SRC}/build/bin/clang -MD -MF - ${LLVM_SRC}/llvm/tools/clang/test/Frontend/dependency-gen.c -fsyntax-only -I a/b | ${LLVM_SRC}/build/bin/FileCheck -check-prefix=CHECK-ONE ${LLVM_SRC}/llvm/tools/clang/test/Frontend/dependency-gen.c
    RUN(TestState.Failed, "%clang -MD -MF - %s -fsyntax-only -I a/b")./*|*/
      I("FileCheck -check-prefix=CHECK-ONE %s");
    // ${LLVM_SRC}/build/bin/clang -MD -MF - ${LLVM_SRC}/llvm/tools/clang/test/Frontend/dependency-gen.c -fsyntax-only -include a/b/x.h -DINCLUDE_FLAG_TEST | ${LLVM_SRC}/build/bin/FileCheck -check-prefix=CHECK-TWO ${LLVM_SRC}/llvm/tools/clang/test/Frontend/dependency-gen.c
    RUN(TestState.Failed, "%clang -MD -MF - %s -fsyntax-only -include a/b/x.h -DINCLUDE_FLAG_TEST")./*|*/
      I("FileCheck -check-prefix=CHECK-TWO %s");
    // ${LLVM_SRC}/build/bin/clang -MD -MF - ${LLVM_SRC}/llvm/tools/clang/test/Frontend/dependency-gen.c -fsyntax-only -I ./a/b | ${LLVM_SRC}/build/bin/FileCheck -check-prefix=CHECK-THREE ${LLVM_SRC}/llvm/tools/clang/test/Frontend/dependency-gen.c
    RUN(TestState.Failed, "%clang -MD -MF - %s -fsyntax-only -I ./a/b")./*|*/
      I("FileCheck -check-prefix=CHECK-THREE %s");
    // ${LLVM_SRC}/build/bin/clang -MD -MF - ${LLVM_SRC}/llvm/tools/clang/test/Frontend/dependency-gen.c -fsyntax-only -I .//./a/b/ | ${LLVM_SRC}/build/bin/FileCheck -check-prefix=CHECK-FOUR ${LLVM_SRC}/llvm/tools/clang/test/Frontend/dependency-gen.c
    RUN(TestState.Failed, "%clang -MD -MF - %s -fsyntax-only -I .//./a/b/")./*|*/
      I("FileCheck -check-prefix=CHECK-FOUR %s");
    // ${LLVM_SRC}/build/bin/clang -MD -MF - ${LLVM_SRC}/llvm/tools/clang/test/Frontend/dependency-gen.c -fsyntax-only -I a/b/. | ${LLVM_SRC}/build/bin/FileCheck -check-prefix=CHECK-FIVE ${LLVM_SRC}/llvm/tools/clang/test/Frontend/dependency-gen.c
    RUN(TestState.Failed, "%clang -MD -MF - %s -fsyntax-only -I a/b/.")./*|*/
      I("FileCheck -check-prefix=CHECK-FIVE %s");
    // cd a/b
    RUN(TestState.Failed, "cd a/b");
    // ${LLVM_SRC}/build/bin/clang -MD -MF - ${LLVM_SRC}/llvm/tools/clang/test/Frontend/dependency-gen.c -fsyntax-only -I ./ | ${LLVM_SRC}/build/bin/FileCheck -check-prefix=CHECK-SIX ${LLVM_SRC}/llvm/tools/clang/test/Frontend/dependency-gen.c
    RUN(TestState.Failed, "%clang -MD -MF - %s -fsyntax-only -I ./")./*|*/
      I("FileCheck -check-prefix=CHECK-SIX %s");
    // echo fun:foo > ${TEST_TEMP_DIR}/dependency-gen.c.tmp.blacklist
    RUN(TestState.Failed, "echo \"fun:foo\" > %t.blacklist");
    // ${LLVM_SRC}/build/bin/clang -MD -MF - ${LLVM_SRC}/llvm/tools/clang/test/Frontend/dependency-gen.c -fsyntax-only -fsanitize=cfi-vcall -flto -fvisibility=hidden '-fsanitize-blacklist=${TEST_TEMP_DIR}/dependency-gen.c.tmp.blacklist' -I ./ | ${LLVM_SRC}/build/bin/FileCheck -check-prefix=CHECK-SEVEN ${LLVM_SRC}/llvm/tools/clang/test/Frontend/dependency-gen.c
    RUN(TestState.Failed, "%clang -MD -MF - %s -fsyntax-only -fsanitize=cfi-vcall -flto -fvisibility=hidden -fsanitize-blacklist=%t.blacklist -I ./")./*|*/
      I("FileCheck -check-prefix=CHECK-SEVEN %s");
  }

  @Test
  public void test_dependency_gen_escaping_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Frontend/dependency-gen-escaping.c");
    // ${LLVM_SRC}/build/bin/clang -M -MG -fno-ms-compatibility ${LLVM_SRC}/llvm/tools/clang/test/Frontend/dependency-gen-escaping.c | ${LLVM_SRC}/build/bin/FileCheck -strict-whitespace ${LLVM_SRC}/llvm/tools/clang/test/Frontend/dependency-gen-escaping.c --check-prefix=CHECK --check-prefix=SEP2F
    RUN("%clang -M -MG -fno-ms-compatibility %s")./*|*/
      I("FileCheck -strict-whitespace %s --check-prefix=CHECK --check-prefix=SEP2F");
    // ${LLVM_SRC}/build/bin/clang -M -MG -fms-compatibility ${LLVM_SRC}/llvm/tools/clang/test/Frontend/dependency-gen-escaping.c | ${LLVM_SRC}/build/bin/FileCheck -strict-whitespace ${LLVM_SRC}/llvm/tools/clang/test/Frontend/dependency-gen-escaping.c --check-prefix=CHECK --check-prefix=SEP5C
    RUN("%clang -M -MG -fms-compatibility %s")./*|*/
      I("FileCheck -strict-whitespace %s --check-prefix=CHECK --check-prefix=SEP5C");
    // ${LLVM_SRC}/build/bin/clang -M -MG -MV ${LLVM_SRC}/llvm/tools/clang/test/Frontend/dependency-gen-escaping.c | ${LLVM_SRC}/build/bin/FileCheck -strict-whitespace ${LLVM_SRC}/llvm/tools/clang/test/Frontend/dependency-gen-escaping.c --check-prefix=NMAKE
    RUN("%clang -M -MG -MV %s")./*|*/
      I("FileCheck -strict-whitespace %s --check-prefix=NMAKE");
  }

  @Test
  public void test_dependency_generation_crash_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Frontend/dependency-generation-crash.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -E -dependency-file bla -MT ${TEST_TEMP_DIR}/dependency-generation-crash.c.tmp/doesnotexist/bla.o -MP -o ${TEST_TEMP_DIR}/dependency-generation-crash.c.tmp/doesnotexist/bla.o -x c /dev/null 2>&1 | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Frontend/dependency-generation-crash.c
    RUN("not %clang_cc1 -E -dependency-file bla -MT %t/doesnotexist/bla.o -MP -o %t/doesnotexist/bla.o -x c /dev/null 2>&1")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_diagnostics_option_names_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Frontend/diagnostics-option-names.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fdiagnostics-show-option -Werror -Weverything ${LLVM_SRC}/llvm/tools/clang/test/Frontend/diagnostics-option-names.c 2> ${TEST_TEMP_DIR}/diagnostics-option-names.c.tmp
    RUN("not %clang_cc1 -fdiagnostics-show-option -Werror -Weverything %s 2> %t");
    // ${LLVM_SRC}/build/bin/FileCheck < ${TEST_TEMP_DIR}/diagnostics-option-names.c.tmp ${LLVM_SRC}/llvm/tools/clang/test/Frontend/diagnostics-option-names.c
    RUN("FileCheck < %t %s");
  }

  @Test
  public void test_disable_output_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Frontend/disable-output.c");
    // REQUIRES: x86-registered-target
    if (!CHECK_REQUIRES("x86-registered-target")) {
      return;
    }
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/Frontend/disable-output.c -emit-llvm-only -triple=i386-apple-darwin -o ${TEST_TEMP_DIR}/disable-output.c.tmp
    RUN(TestState.Failed, "%clang_cc1 %s -emit-llvm-only -triple=i386-apple-darwin -o %t");
    // rm ${TEST_TEMP_DIR}/disable-output.c.tmp
    RUN(TestState.Failed, "not rm %t");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/Frontend/disable-output.c -emit-codegen-only -triple=i386-apple-darwin -o ${TEST_TEMP_DIR}/disable-output.c.tmp
    RUN(TestState.Failed, "%clang_cc1 %s -emit-codegen-only -triple=i386-apple-darwin -o %t");
    // rm ${TEST_TEMP_DIR}/disable-output.c.tmp
    RUN(TestState.Failed, "not rm %t");
  }

  @Test
  public void test_exceptions_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Frontend/exceptions.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fms-compatibility -fexceptions -fcxx-exceptions -DMS_MODE -verify ${LLVM_SRC}/llvm/tools/clang/test/Frontend/exceptions.c
    RUN("%clang_cc1 -fms-compatibility -fexceptions -fcxx-exceptions -DMS_MODE -verify %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fms-compatibility -fexceptions -verify ${LLVM_SRC}/llvm/tools/clang/test/Frontend/exceptions.c
    RUN("%clang_cc1 -fms-compatibility -fexceptions -verify %s");
  }

  @Test
  public void test_force_include_not_found_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Frontend/force-include-not-found.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/Frontend/force-include-not-found.c -include '/abspath/missing file with spaces.h' 2>&1 | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Frontend/force-include-not-found.c
    RUN("not %clang_cc1 %s -include \"/abspath/missing file with spaces.h\" 2>&1")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_gnu_inline_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Frontend/gnu-inline.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c89 -fsyntax-only -x c -E -dM ${LLVM_SRC}/llvm/tools/clang/test/Frontend/gnu-inline.c | ${LLVM_SRC}/build/bin/FileCheck --check-prefix=GNU-INLINE ${LLVM_SRC}/llvm/tools/clang/test/Frontend/gnu-inline.c
    RUN("%clang_cc1 -std=c89 -fsyntax-only -x c -E -dM %s")./*|*/
      I("FileCheck --check-prefix=GNU-INLINE %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c99 -fsyntax-only -x c -E -dM ${LLVM_SRC}/llvm/tools/clang/test/Frontend/gnu-inline.c | ${LLVM_SRC}/build/bin/FileCheck --check-prefix=STDC-INLINE ${LLVM_SRC}/llvm/tools/clang/test/Frontend/gnu-inline.c
    RUN("%clang_cc1 -std=c99 -fsyntax-only -x c -E -dM %s")./*|*/
      I("FileCheck --check-prefix=STDC-INLINE %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c99 -fgnu89-inline -fsyntax-only -x c -E -dM ${LLVM_SRC}/llvm/tools/clang/test/Frontend/gnu-inline.c | ${LLVM_SRC}/build/bin/FileCheck --check-prefix=GNU-INLINE ${LLVM_SRC}/llvm/tools/clang/test/Frontend/gnu-inline.c
    RUN("%clang_cc1 -std=c99 -fgnu89-inline -fsyntax-only -x c -E -dM %s")./*|*/
      I("FileCheck --check-prefix=GNU-INLINE %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -x c++ -E -dM ${LLVM_SRC}/llvm/tools/clang/test/Frontend/gnu-inline.c | ${LLVM_SRC}/build/bin/FileCheck --check-prefix=GNU-INLINE ${LLVM_SRC}/llvm/tools/clang/test/Frontend/gnu-inline.c
    RUN("%clang_cc1 -fsyntax-only -x c++ -E -dM %s")./*|*/
      I("FileCheck --check-prefix=GNU-INLINE %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fgnu89-inline -fsyntax-only -x c++ ${LLVM_SRC}/llvm/tools/clang/test/Frontend/gnu-inline.c 2>&1 | ${LLVM_SRC}/build/bin/FileCheck --check-prefix=CXX ${LLVM_SRC}/llvm/tools/clang/test/Frontend/gnu-inline.c
    RUN("not %clang_cc1 -fgnu89-inline -fsyntax-only -x c++ %s 2>&1")./*|*/
      I("FileCheck --check-prefix=CXX %s");
  }

  @Test
  public void test_gnu_mcount_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Frontend/gnu-mcount.c");
    // ${LLVM_SRC}/build/bin/clang -target armv7-unknown-none-eabi -pg -S -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/Frontend/gnu-mcount.c | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Frontend/gnu-mcount.c -check-prefix CHECK -check-prefix CHECK-ARM-EABI
    RUN(TestState.Failed, "%clang -target armv7-unknown-none-eabi -pg -S -emit-llvm -o - %s")./*|*/
      I("FileCheck %s -check-prefix CHECK -check-prefix CHECK-ARM-EABI");
    // ${LLVM_SRC}/build/bin/clang -target armv7-unknown-none-eabi -pg -meabi gnu -S -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/Frontend/gnu-mcount.c | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Frontend/gnu-mcount.c -check-prefix CHECK -check-prefix CHECK-ARM-EABI-MEABI-GNU
    RUN(TestState.Failed, "%clang -target armv7-unknown-none-eabi -pg -meabi gnu -S -emit-llvm -o - %s")./*|*/
      I("FileCheck %s -check-prefix CHECK -check-prefix CHECK-ARM-EABI-MEABI-GNU");
    // ${LLVM_SRC}/build/bin/clang -target aarch64-unknown-none-eabi -pg -S -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/Frontend/gnu-mcount.c | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Frontend/gnu-mcount.c -check-prefix CHECK -check-prefix CHECK-ARM64-EABI
    RUN(TestState.Failed, "%clang -target aarch64-unknown-none-eabi -pg -S -emit-llvm -o - %s")./*|*/
      I("FileCheck %s -check-prefix CHECK -check-prefix CHECK-ARM64-EABI");
    // ${LLVM_SRC}/build/bin/clang -target aarch64-unknown-none-eabi -pg -meabi gnu -S -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/Frontend/gnu-mcount.c | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Frontend/gnu-mcount.c -check-prefix CHECK -check-prefix CHECK-ARM64-EABI-MEABI-GNU
    RUN(TestState.Failed, "%clang -target aarch64-unknown-none-eabi -pg -meabi gnu -S -emit-llvm -o - %s")./*|*/
      I("FileCheck %s -check-prefix CHECK -check-prefix CHECK-ARM64-EABI-MEABI-GNU");
    // ${LLVM_SRC}/build/bin/clang -target armv7-unknown-linux-gnueabi -pg -S -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/Frontend/gnu-mcount.c | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Frontend/gnu-mcount.c -check-prefix CHECK -check-prefix CHECK-ARM-EABI
    RUN(TestState.Failed, "%clang -target armv7-unknown-linux-gnueabi -pg -S -emit-llvm -o - %s")./*|*/
      I("FileCheck %s -check-prefix CHECK -check-prefix CHECK-ARM-EABI");
    // ${LLVM_SRC}/build/bin/clang -target armv7-unknown-linux-gnueabi -meabi gnu -pg -S -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/Frontend/gnu-mcount.c | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Frontend/gnu-mcount.c -check-prefix CHECK -check-prefix CHECK-ARM-EABI-MEABI-GNU
    RUN(TestState.Failed, "%clang -target armv7-unknown-linux-gnueabi -meabi gnu -pg -S -emit-llvm -o - %s")./*|*/
      I("FileCheck %s -check-prefix CHECK -check-prefix CHECK-ARM-EABI-MEABI-GNU");
    // ${LLVM_SRC}/build/bin/clang -target aarch64-unknown-linux-gnueabi -pg -S -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/Frontend/gnu-mcount.c | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Frontend/gnu-mcount.c -check-prefix CHECK -check-prefix CHECK-ARM64-EABI
    RUN(TestState.Failed, "%clang -target aarch64-unknown-linux-gnueabi -pg -S -emit-llvm -o - %s")./*|*/
      I("FileCheck %s -check-prefix CHECK -check-prefix CHECK-ARM64-EABI");
    // ${LLVM_SRC}/build/bin/clang -target aarch64-unknown-linux-gnueabi -meabi gnu -pg -S -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/Frontend/gnu-mcount.c | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Frontend/gnu-mcount.c -check-prefix CHECK -check-prefix CHECK-ARM64-EABI-MEABI-GNU
    RUN(TestState.Failed, "%clang -target aarch64-unknown-linux-gnueabi -meabi gnu -pg -S -emit-llvm -o - %s")./*|*/
      I("FileCheck %s -check-prefix CHECK -check-prefix CHECK-ARM64-EABI-MEABI-GNU");
    // ${LLVM_SRC}/build/bin/clang -target armv7-unknown-linux-gnueabihf -pg -S -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/Frontend/gnu-mcount.c | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Frontend/gnu-mcount.c -check-prefix CHECK -check-prefix CHECK-ARM-EABI
    RUN(TestState.Failed, "%clang -target armv7-unknown-linux-gnueabihf -pg -S -emit-llvm -o - %s")./*|*/
      I("FileCheck %s -check-prefix CHECK -check-prefix CHECK-ARM-EABI");
    // ${LLVM_SRC}/build/bin/clang -target armv7-unknown-linux-gnueabihf -meabi gnu -pg -S -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/Frontend/gnu-mcount.c | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Frontend/gnu-mcount.c -check-prefix CHECK -check-prefix CHECK-ARM-EABI-MEABI-GNU
    RUN(TestState.Failed, "%clang -target armv7-unknown-linux-gnueabihf -meabi gnu -pg -S -emit-llvm -o - %s")./*|*/
      I("FileCheck %s -check-prefix CHECK -check-prefix CHECK-ARM-EABI-MEABI-GNU");
    // ${LLVM_SRC}/build/bin/clang -target aarch64-unknown-linux-gnueabihf -pg -S -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/Frontend/gnu-mcount.c | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Frontend/gnu-mcount.c -check-prefix CHECK -check-prefix CHECK-ARM64-EABI
    RUN(TestState.Failed, "%clang -target aarch64-unknown-linux-gnueabihf -pg -S -emit-llvm -o - %s")./*|*/
      I("FileCheck %s -check-prefix CHECK -check-prefix CHECK-ARM64-EABI");
    // ${LLVM_SRC}/build/bin/clang -target aarch64-unknown-linux-gnueabihf -meabi gnu -pg -S -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/Frontend/gnu-mcount.c | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Frontend/gnu-mcount.c -check-prefix CHECK -check-prefix CHECK-ARM64-EABI-MEABI-GNU
    RUN(TestState.Failed, "%clang -target aarch64-unknown-linux-gnueabihf -meabi gnu -pg -S -emit-llvm -o - %s")./*|*/
      I("FileCheck %s -check-prefix CHECK -check-prefix CHECK-ARM64-EABI-MEABI-GNU");
    // ${LLVM_SRC}/build/bin/clang -target armv7-unknown-freebsd-gnueabihf -pg -S -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/Frontend/gnu-mcount.c | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Frontend/gnu-mcount.c -check-prefix CHECK -check-prefix CHECK-ARM-EABI-FREEBSD
    RUN(TestState.Failed, "%clang -target armv7-unknown-freebsd-gnueabihf -pg -S -emit-llvm -o - %s")./*|*/
      I("FileCheck %s -check-prefix CHECK -check-prefix CHECK-ARM-EABI-FREEBSD");
    // ${LLVM_SRC}/build/bin/clang -target armv7-unknown-freebsd-gnueabihf -meabi gnu -pg -S -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/Frontend/gnu-mcount.c | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Frontend/gnu-mcount.c -check-prefix CHECK -check-prefix CHECK-ARM-EABI-FREEBSD
    RUN(TestState.Failed, "%clang -target armv7-unknown-freebsd-gnueabihf -meabi gnu -pg -S -emit-llvm -o - %s")./*|*/
      I("FileCheck %s -check-prefix CHECK -check-prefix CHECK-ARM-EABI-FREEBSD");
    // ${LLVM_SRC}/build/bin/clang -target aarch64-unknown-freebsd-gnueabihf -pg -S -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/Frontend/gnu-mcount.c | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Frontend/gnu-mcount.c -check-prefix CHECK -check-prefix CHECK-ARM64-EABI-FREEBSD
    RUN(TestState.Failed, "%clang -target aarch64-unknown-freebsd-gnueabihf -pg -S -emit-llvm -o - %s")./*|*/
      I("FileCheck %s -check-prefix CHECK -check-prefix CHECK-ARM64-EABI-FREEBSD");
    // ${LLVM_SRC}/build/bin/clang -target aarch64-unknown-freebsd-gnueabihf -meabi gnu -pg -S -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/Frontend/gnu-mcount.c | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Frontend/gnu-mcount.c -check-prefix CHECK -check-prefix CHECK-ARM64-EABI-FREEBSD
    RUN(TestState.Failed, "%clang -target aarch64-unknown-freebsd-gnueabihf -meabi gnu -pg -S -emit-llvm -o - %s")./*|*/
      I("FileCheck %s -check-prefix CHECK -check-prefix CHECK-ARM64-EABI-FREEBSD");
    // ${LLVM_SRC}/build/bin/clang -target armv7-unknown-openbsd-gnueabihf -pg -S -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/Frontend/gnu-mcount.c | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Frontend/gnu-mcount.c -check-prefix CHECK -check-prefix CHECK-ARM-EABI-OPENBSD
    RUN(TestState.Failed, "%clang -target armv7-unknown-openbsd-gnueabihf -pg -S -emit-llvm -o - %s")./*|*/
      I("FileCheck %s -check-prefix CHECK -check-prefix CHECK-ARM-EABI-OPENBSD");
    // ${LLVM_SRC}/build/bin/clang -target armv7-unknown-openbsd-gnueabihf -meabi gnu -pg -S -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/Frontend/gnu-mcount.c | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Frontend/gnu-mcount.c -check-prefix CHECK -check-prefix CHECK-ARM-EABI-OPENBSD
    RUN(TestState.Failed, "%clang -target armv7-unknown-openbsd-gnueabihf -meabi gnu -pg -S -emit-llvm -o - %s")./*|*/
      I("FileCheck %s -check-prefix CHECK -check-prefix CHECK-ARM-EABI-OPENBSD");
    // ${LLVM_SRC}/build/bin/clang -target aarch64-unknown-openbsd-gnueabihf -pg -S -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/Frontend/gnu-mcount.c | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Frontend/gnu-mcount.c -check-prefix CHECK -check-prefix CHECK-ARM64-EABI-OPENBSD
    RUN(TestState.Failed, "%clang -target aarch64-unknown-openbsd-gnueabihf -pg -S -emit-llvm -o - %s")./*|*/
      I("FileCheck %s -check-prefix CHECK -check-prefix CHECK-ARM64-EABI-OPENBSD");
    // ${LLVM_SRC}/build/bin/clang -target aarch64-unknown-openbsd-gnueabihf -meabi gnu -pg -S -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/Frontend/gnu-mcount.c | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Frontend/gnu-mcount.c -check-prefix CHECK -check-prefix CHECK-ARM64-EABI-OPENBSD
    RUN(TestState.Failed, "%clang -target aarch64-unknown-openbsd-gnueabihf -meabi gnu -pg -S -emit-llvm -o - %s")./*|*/
      I("FileCheck %s -check-prefix CHECK -check-prefix CHECK-ARM64-EABI-OPENBSD");
    // ${LLVM_SRC}/build/bin/clang -target armv7-unknown-netbsd-gnueabihf -pg -S -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/Frontend/gnu-mcount.c | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Frontend/gnu-mcount.c -check-prefix CHECK -check-prefix CHECK-ARM-EABI-NETBSD
    RUN(TestState.Failed, "%clang -target armv7-unknown-netbsd-gnueabihf -pg -S -emit-llvm -o - %s")./*|*/
      I("FileCheck %s -check-prefix CHECK -check-prefix CHECK-ARM-EABI-NETBSD");
    // ${LLVM_SRC}/build/bin/clang -target armv7-unknown-netbsd-gnueabihf -meabi gnu -pg -S -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/Frontend/gnu-mcount.c | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Frontend/gnu-mcount.c -check-prefix CHECK -check-prefix CHECK-ARM-EABI-NETBSD
    RUN(TestState.Failed, "%clang -target armv7-unknown-netbsd-gnueabihf -meabi gnu -pg -S -emit-llvm -o - %s")./*|*/
      I("FileCheck %s -check-prefix CHECK -check-prefix CHECK-ARM-EABI-NETBSD");
    // ${LLVM_SRC}/build/bin/clang -target aarch64-unknown-netbsd-gnueabihf -pg -S -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/Frontend/gnu-mcount.c | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Frontend/gnu-mcount.c -check-prefix CHECK -check-prefix CHECK-ARM64-EABI-NETBSD
    RUN(TestState.Failed, "%clang -target aarch64-unknown-netbsd-gnueabihf -pg -S -emit-llvm -o - %s")./*|*/
      I("FileCheck %s -check-prefix CHECK -check-prefix CHECK-ARM64-EABI-NETBSD");
    // ${LLVM_SRC}/build/bin/clang -target aarch64-unknown-netbsd-gnueabihf -meabi gnu -pg -S -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/Frontend/gnu-mcount.c | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Frontend/gnu-mcount.c -check-prefix CHECK -check-prefix CHECK-ARM64-EABI-NETBSD
    RUN(TestState.Failed, "%clang -target aarch64-unknown-netbsd-gnueabihf -meabi gnu -pg -S -emit-llvm -o - %s")./*|*/
      I("FileCheck %s -check-prefix CHECK -check-prefix CHECK-ARM64-EABI-NETBSD");
    // ${LLVM_SRC}/build/bin/clang -target armv7-apple-ios -pg -S -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/Frontend/gnu-mcount.c | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Frontend/gnu-mcount.c -check-prefix CHECK -check-prefix CHECK-ARM-IOS
    RUN(TestState.Failed, "%clang -target armv7-apple-ios -pg -S -emit-llvm -o - %s")./*|*/
      I("FileCheck %s -check-prefix CHECK -check-prefix CHECK-ARM-IOS");
    // ${LLVM_SRC}/build/bin/clang -target armv7-apple-ios -pg -meabi gnu -S -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/Frontend/gnu-mcount.c | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Frontend/gnu-mcount.c -check-prefix CHECK -check-prefix CHECK-ARM-IOS
    RUN(TestState.Failed, "%clang -target armv7-apple-ios -pg -meabi gnu -S -emit-llvm -o - %s")./*|*/
      I("FileCheck %s -check-prefix CHECK -check-prefix CHECK-ARM-IOS");
    // ${LLVM_SRC}/build/bin/clang -target arm64-apple-ios -pg -S -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/Frontend/gnu-mcount.c | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Frontend/gnu-mcount.c -check-prefix CHECK -check-prefix CHECK-ARM-IOS
    RUN(TestState.Failed, "%clang -target arm64-apple-ios -pg -S -emit-llvm -o - %s")./*|*/
      I("FileCheck %s -check-prefix CHECK -check-prefix CHECK-ARM-IOS");
    // ${LLVM_SRC}/build/bin/clang -target arm64-apple-ios -pg -meabi gnu -S -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/Frontend/gnu-mcount.c | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Frontend/gnu-mcount.c -check-prefix CHECK -check-prefix CHECK-ARM-IOS
    RUN(TestState.Failed, "%clang -target arm64-apple-ios -pg -meabi gnu -S -emit-llvm -o - %s")./*|*/
      I("FileCheck %s -check-prefix CHECK -check-prefix CHECK-ARM-IOS");
    // ${LLVM_SRC}/build/bin/clang -target armv7-unknown-bitrig-gnueabihf -pg -S -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/Frontend/gnu-mcount.c | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Frontend/gnu-mcount.c -check-prefix CHECK -check-prefix CHECK-ARM-EABI-BIGRIG
    RUN(TestState.Failed, "%clang -target armv7-unknown-bitrig-gnueabihf -pg -S -emit-llvm -o - %s")./*|*/
      I("FileCheck %s -check-prefix CHECK -check-prefix CHECK-ARM-EABI-BIGRIG");
    // ${LLVM_SRC}/build/bin/clang -target armv7-unknown-bitrig-gnueabihf -meabi gnu -pg -S -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/Frontend/gnu-mcount.c | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Frontend/gnu-mcount.c -check-prefix CHECK -check-prefix CHECK-ARM-EABI-BIGRIG
    RUN(TestState.Failed, "%clang -target armv7-unknown-bitrig-gnueabihf -meabi gnu -pg -S -emit-llvm -o - %s")./*|*/
      I("FileCheck %s -check-prefix CHECK -check-prefix CHECK-ARM-EABI-BIGRIG");
    // ${LLVM_SRC}/build/bin/clang -target aarch64-unknown-bitrig-gnueabihf -pg -S -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/Frontend/gnu-mcount.c | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Frontend/gnu-mcount.c -check-prefix CHECK -check-prefix CHECK-ARM64-EABI-BITRIG
    RUN(TestState.Failed, "%clang -target aarch64-unknown-bitrig-gnueabihf -pg -S -emit-llvm -o - %s")./*|*/
      I("FileCheck %s -check-prefix CHECK -check-prefix CHECK-ARM64-EABI-BITRIG");
    // ${LLVM_SRC}/build/bin/clang -target aarch64-unknown-bitrig-gnueabihf -meabi gnu -pg -S -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/Frontend/gnu-mcount.c | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Frontend/gnu-mcount.c -check-prefix CHECK -check-prefix CHECK-ARM64-EABI-BITRIG
    RUN(TestState.Failed, "%clang -target aarch64-unknown-bitrig-gnueabihf -meabi gnu -pg -S -emit-llvm -o - %s")./*|*/
      I("FileCheck %s -check-prefix CHECK -check-prefix CHECK-ARM64-EABI-BITRIG");
    // ${LLVM_SRC}/build/bin/clang -target armv7-unknown-rtems-gnueabihf -pg -S -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/Frontend/gnu-mcount.c | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Frontend/gnu-mcount.c -check-prefix CHECK -check-prefix CHECK-ARM-EABI-RTEMS
    RUN(TestState.Failed, "%clang -target armv7-unknown-rtems-gnueabihf -pg -S -emit-llvm -o - %s")./*|*/
      I("FileCheck %s -check-prefix CHECK -check-prefix CHECK-ARM-EABI-RTEMS");
    // ${LLVM_SRC}/build/bin/clang -target armv7-unknown-rtems-gnueabihf -meabi gnu -pg -S -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/Frontend/gnu-mcount.c | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Frontend/gnu-mcount.c -check-prefix CHECK -check-prefix CHECK-ARM-EABI-RTEMS
    RUN(TestState.Failed, "%clang -target armv7-unknown-rtems-gnueabihf -meabi gnu -pg -S -emit-llvm -o - %s")./*|*/
      I("FileCheck %s -check-prefix CHECK -check-prefix CHECK-ARM-EABI-RTEMS");
    // ${LLVM_SRC}/build/bin/clang -target aarch64-unknown-rtems-gnueabihf -pg -S -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/Frontend/gnu-mcount.c | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Frontend/gnu-mcount.c -check-prefix CHECK -check-prefix CHECK-ARM64-EABI-RTEMS
    RUN(TestState.Failed, "%clang -target aarch64-unknown-rtems-gnueabihf -pg -S -emit-llvm -o - %s")./*|*/
      I("FileCheck %s -check-prefix CHECK -check-prefix CHECK-ARM64-EABI-RTEMS");
    // ${LLVM_SRC}/build/bin/clang -target aarch64-unknown-rtems-gnueabihf -meabi gnu -pg -S -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/Frontend/gnu-mcount.c | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Frontend/gnu-mcount.c -check-prefix CHECK -check-prefix CHECK-ARM64-EABI-RTEMS
    RUN(TestState.Failed, "%clang -target aarch64-unknown-rtems-gnueabihf -meabi gnu -pg -S -emit-llvm -o - %s")./*|*/
      I("FileCheck %s -check-prefix CHECK -check-prefix CHECK-ARM64-EABI-RTEMS");
    // ${LLVM_SRC}/build/bin/clang -target armv7-unknown-cloudabi-gnueabihf -pg -S -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/Frontend/gnu-mcount.c | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Frontend/gnu-mcount.c -check-prefix CHECK -check-prefix CHECK-ARM-EABI-CLOUDABI
    RUN(TestState.Failed, "%clang -target armv7-unknown-cloudabi-gnueabihf -pg -S -emit-llvm -o - %s")./*|*/
      I("FileCheck %s -check-prefix CHECK -check-prefix CHECK-ARM-EABI-CLOUDABI");
    // ${LLVM_SRC}/build/bin/clang -target armv7-unknown-cloudabi-gnueabihf -meabi gnu -pg -S -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/Frontend/gnu-mcount.c | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Frontend/gnu-mcount.c -check-prefix CHECK -check-prefix CHECK-ARM-EABI-CLOUDABI
    RUN(TestState.Failed, "%clang -target armv7-unknown-cloudabi-gnueabihf -meabi gnu -pg -S -emit-llvm -o - %s")./*|*/
      I("FileCheck %s -check-prefix CHECK -check-prefix CHECK-ARM-EABI-CLOUDABI");
    // ${LLVM_SRC}/build/bin/clang -target aarch64-unknown-cloudabi-gnueabihf -pg -S -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/Frontend/gnu-mcount.c | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Frontend/gnu-mcount.c -check-prefix CHECK -check-prefix CHECK-ARM64-EABI-CLOUDABI
    RUN(TestState.Failed, "%clang -target aarch64-unknown-cloudabi-gnueabihf -pg -S -emit-llvm -o - %s")./*|*/
      I("FileCheck %s -check-prefix CHECK -check-prefix CHECK-ARM64-EABI-CLOUDABI");
    // ${LLVM_SRC}/build/bin/clang -target aarch64-unknown-cloudabi-gnueabihf -meabi gnu -pg -S -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/Frontend/gnu-mcount.c | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Frontend/gnu-mcount.c -check-prefix CHECK -check-prefix CHECK-ARM64-EABI-CLOUDABI
    RUN(TestState.Failed, "%clang -target aarch64-unknown-cloudabi-gnueabihf -meabi gnu -pg -S -emit-llvm -o - %s")./*|*/
      I("FileCheck %s -check-prefix CHECK -check-prefix CHECK-ARM64-EABI-CLOUDABI");
  }

  @Test
  public void test_hexagon_target_basic_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Frontend/hexagon-target-basic.c");
    // REQUIRES: hexagon-registered-target
    if (!CHECK_REQUIRES("hexagon-registered-target")) {
      return;
    }
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm -triple hexagon-unknown-unknown ${LLVM_SRC}/llvm/tools/clang/test/Frontend/hexagon-target-basic.c -S -o /dev/null
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm -triple hexagon-unknown-unknown %s -S -o /dev/null");
  }

  @Test
  public void test_iframework_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Frontend/iframework.c");
    // ${LLVM_SRC}/build/bin/clang -fsyntax-only -iframework ${LLVM_SRC}/llvm/tools/clang/test/Frontend/Inputs ${LLVM_SRC}/llvm/tools/clang/test/Frontend/iframework.c -Xclang -verify
    RUN("%clang -fsyntax-only -iframework %S/Inputs %s -Xclang -verify");
  }

  @Test
  public void test_invalid_o_level_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Frontend/invalid-o-level.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/Frontend/invalid-o-level.c -O900 -o /dev/null 2>&1 | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Frontend/invalid-o-level.c
    RUN("%clang_cc1 %s -O900 -o /dev/null 2>&1")./*|*/
      I("FileCheck %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/Frontend/invalid-o-level.c -O8 -o /dev/null 2>&1 | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Frontend/invalid-o-level.c
    RUN("%clang_cc1 %s -O8 -o /dev/null 2>&1")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_ir_support_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Frontend/ir-support.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -S -o - ${LLVM_SRC}/llvm/tools/clang/test/Frontend/ir-support.c | grep -v \.file > ${TEST_TEMP_DIR}/ir-support.c.tmp.s
    RUN(TestState.Failed, "%clang_cc1 -S -o - %s")./*|*/
      I("grep -v '\\.file' > %t.s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm-bc -o ${TEST_TEMP_DIR}/ir-support.c.tmp.bc ${LLVM_SRC}/llvm/tools/clang/test/Frontend/ir-support.c
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm-bc -o %t.bc %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -S -o - ${TEST_TEMP_DIR}/ir-support.c.tmp.bc | grep -v \.file > ${TEST_TEMP_DIR}/ir-support.c.tmp.bc.s
    RUN(TestState.Failed, "%clang_cc1 -S -o - %t.bc")./*|*/
      I("grep -v '\\.file' > %t.bc.s");
    // diff ${TEST_TEMP_DIR}/ir-support.c.tmp.s ${TEST_TEMP_DIR}/ir-support.c.tmp.bc.s
    RUN(TestState.Failed, "diff %t.s %t.bc.s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm -o ${TEST_TEMP_DIR}/ir-support.c.tmp.ll ${LLVM_SRC}/llvm/tools/clang/test/Frontend/ir-support.c
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm -o %t.ll %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -S -o - ${TEST_TEMP_DIR}/ir-support.c.tmp.ll | grep -v \.file > ${TEST_TEMP_DIR}/ir-support.c.tmp.ll.s
    RUN(TestState.Failed, "%clang_cc1 -S -o - %t.ll")./*|*/
      I("grep -v '\\.file' > %t.ll.s");
    // diff ${TEST_TEMP_DIR}/ir-support.c.tmp.s ${TEST_TEMP_DIR}/ir-support.c.tmp.ll.s
    RUN(TestState.Failed, "diff %t.s %t.ll.s");
  }

  @Test
  public void test_macros_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Frontend/macros.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -DA= -DB=1 -verify -fsyntax-only ${LLVM_SRC}/llvm/tools/clang/test/Frontend/macros.c
    RUN("%clang_cc1 -DA= -DB=1 -verify -fsyntax-only %s");
  }

  @Test
  public void test_mfpmath_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Frontend/mfpmath.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i686-pc-linux -target-feature -sse ${LLVM_SRC}/llvm/tools/clang/test/Frontend/mfpmath.c
    RUN("%clang_cc1 -triple i686-pc-linux -target-feature -sse  %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i686-pc-linux -target-feature -sse -mfpmath 387 ${LLVM_SRC}/llvm/tools/clang/test/Frontend/mfpmath.c
    RUN("%clang_cc1 -triple i686-pc-linux -target-feature -sse -mfpmath 387 %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i686-pc-linux -target-feature +sse ${LLVM_SRC}/llvm/tools/clang/test/Frontend/mfpmath.c
    RUN("%clang_cc1 -triple i686-pc-linux -target-feature +sse %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i686-pc-linux -target-feature +sse -mfpmath sse ${LLVM_SRC}/llvm/tools/clang/test/Frontend/mfpmath.c
    RUN("%clang_cc1 -triple i686-pc-linux -target-feature +sse -mfpmath sse %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i686-pc-linux -target-feature +sse -mfpmath xyz ${LLVM_SRC}/llvm/tools/clang/test/Frontend/mfpmath.c 2>&1 | ${LLVM_SRC}/build/bin/FileCheck --check-prefix=CHECK-XYZ ${LLVM_SRC}/llvm/tools/clang/test/Frontend/mfpmath.c
    RUN("not %clang_cc1 -triple i686-pc-linux -target-feature +sse -mfpmath xyz %s 2>&1")./*|*/
      I("FileCheck --check-prefix=CHECK-XYZ %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i686-pc-linux -target-feature +sse -mfpmath 387 ${LLVM_SRC}/llvm/tools/clang/test/Frontend/mfpmath.c 2>&1 | ${LLVM_SRC}/build/bin/FileCheck --check-prefix=CHECK-NO-387 ${LLVM_SRC}/llvm/tools/clang/test/Frontend/mfpmath.c
    RUN("not %clang_cc1 -triple i686-pc-linux -target-feature +sse -mfpmath 387 %s 2>&1")./*|*/
      I("FileCheck --check-prefix=CHECK-NO-387 %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i686-pc-linux -target-feature -sse -mfpmath sse ${LLVM_SRC}/llvm/tools/clang/test/Frontend/mfpmath.c 2>&1 | ${LLVM_SRC}/build/bin/FileCheck --check-prefix=CHECK-NO-SSE ${LLVM_SRC}/llvm/tools/clang/test/Frontend/mfpmath.c
    RUN("not %clang_cc1 -triple i686-pc-linux -target-feature -sse -mfpmath sse %s 2>&1")./*|*/
      I("FileCheck --check-prefix=CHECK-NO-SSE %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple arm-apple-darwin10 -mfpmath vfp ${LLVM_SRC}/llvm/tools/clang/test/Frontend/mfpmath.c
    RUN("%clang_cc1 -triple arm-apple-darwin10 -mfpmath vfp %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple arm-apple-darwin10 -mfpmath vfp2 ${LLVM_SRC}/llvm/tools/clang/test/Frontend/mfpmath.c
    RUN("%clang_cc1 -triple arm-apple-darwin10 -mfpmath vfp2 %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple arm-apple-darwin10 -mfpmath vfp3 ${LLVM_SRC}/llvm/tools/clang/test/Frontend/mfpmath.c
    RUN("%clang_cc1 -triple arm-apple-darwin10 -mfpmath vfp3 %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple arm-apple-darwin10 -mfpmath vfp4 ${LLVM_SRC}/llvm/tools/clang/test/Frontend/mfpmath.c
    RUN("%clang_cc1 -triple arm-apple-darwin10 -mfpmath vfp4 %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple arm-apple-darwin10 -target-cpu cortex-a9 -mfpmath neon ${LLVM_SRC}/llvm/tools/clang/test/Frontend/mfpmath.c
    RUN("%clang_cc1 -triple arm-apple-darwin10 -target-cpu cortex-a9 -mfpmath neon %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple arm-apple-darwin10 -mfpmath foo ${LLVM_SRC}/llvm/tools/clang/test/Frontend/mfpmath.c 2>&1 ${LLVM_SRC}/build/bin/FileCheck --check-prefix=CHECK-FOO ${LLVM_SRC}/llvm/tools/clang/test/Frontend/mfpmath.c
    RUN("not %clang_cc1 -triple arm-apple-darwin10 -mfpmath foo %s 2>&1 FileCheck --check-prefix=CHECK-FOO %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple arm-apple-darwin10 -target-cpu arm1136j-s -mfpmath neon ${LLVM_SRC}/llvm/tools/clang/test/Frontend/mfpmath.c 2>&1 | ${LLVM_SRC}/build/bin/FileCheck --check-prefix=CHECK-NO-NEON ${LLVM_SRC}/llvm/tools/clang/test/Frontend/mfpmath.c
    RUN("not %clang_cc1 -triple arm-apple-darwin10 -target-cpu arm1136j-s -mfpmath neon %s 2>&1")./*|*/
      I("FileCheck --check-prefix=CHECK-NO-NEON %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple arm-apple-darwin10 -target-cpu cortex-a9 -target-feature -neon -mfpmath neon ${LLVM_SRC}/llvm/tools/clang/test/Frontend/mfpmath.c 2>&1 | ${LLVM_SRC}/build/bin/FileCheck --check-prefix=CHECK-NO-NEON ${LLVM_SRC}/llvm/tools/clang/test/Frontend/mfpmath.c
    RUN("not %clang_cc1 -triple arm-apple-darwin10 -target-cpu cortex-a9 -target-feature -neon -mfpmath neon %s 2>&1")./*|*/
      I("FileCheck --check-prefix=CHECK-NO-NEON %s");
  }

  @Test
  public void test_mips_long_double_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Frontend/mips-long-double.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple mips64-unknown-freebsd -std=c11 -verify ${LLVM_SRC}/llvm/tools/clang/test/Frontend/mips-long-double.c
    RUN("%clang_cc1 -triple mips64-unknown-freebsd -std=c11 -verify %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple mips-unknown-freebsd -std=c11 -verify ${LLVM_SRC}/llvm/tools/clang/test/Frontend/mips-long-double.c
    RUN("%clang_cc1 -triple mips-unknown-freebsd -std=c11 -verify %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple mips-unknown-linux -std=c11 -verify ${LLVM_SRC}/llvm/tools/clang/test/Frontend/mips-long-double.c
    RUN("%clang_cc1 -triple mips-unknown-linux -std=c11 -verify %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple mips64-unknown-linux -std=c11 -verify ${LLVM_SRC}/llvm/tools/clang/test/Frontend/mips-long-double.c
    RUN("%clang_cc1 -triple mips64-unknown-linux -std=c11 -verify %s");
  }

  @Test
  public void test_opencl_cl() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Frontend/opencl.cl");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/Frontend/opencl.cl -verify -fsyntax-only
    RUN("%clang_cc1 %s -verify -fsyntax-only");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/Frontend/opencl.cl -verify -fsyntax-only -cl-std=CL1.1
    RUN("%clang_cc1 %s -verify -fsyntax-only -cl-std=CL1.1");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/Frontend/opencl.cl -verify -fsyntax-only -cl-std=CL1.2
    RUN("%clang_cc1 %s -verify -fsyntax-only -cl-std=CL1.2");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/Frontend/opencl.cl -verify -fsyntax-only -cl-std=CL2.0
    RUN("%clang_cc1 %s -verify -fsyntax-only -cl-std=CL2.0");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/Frontend/opencl.cl -verify -fsyntax-only -fblocks -DBLOCKS
    RUN("%clang_cc1 %s -verify -fsyntax-only -fblocks -DBLOCKS");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/Frontend/opencl.cl -verify -fsyntax-only -cl-std=CL1.1 -fblocks -DBLOCKS
    RUN("%clang_cc1 %s -verify -fsyntax-only -cl-std=CL1.1 -fblocks -DBLOCKS");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/Frontend/opencl.cl -verify -fsyntax-only -cl-std=CL1.2 -fblocks -DBLOCKS
    RUN("%clang_cc1 %s -verify -fsyntax-only -cl-std=CL1.2 -fblocks -DBLOCKS");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/Frontend/opencl.cl -triple amdgcn--amdhsa -x c -std=c99 -verify -fsyntax-only
    RUN("%clang_cc1 %s -triple amdgcn--amdhsa -x c -std=c99 -verify -fsyntax-only");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -cl-std=CL1.1 -cl-strict-aliasing -fblocks ${LLVM_SRC}/llvm/tools/clang/test/Frontend/opencl.cl 2>&1 | ${LLVM_SRC}/build/bin/FileCheck --check-prefix=CHECK-INVALID-OPENCL-VERSION11 ${LLVM_SRC}/llvm/tools/clang/test/Frontend/opencl.cl
    RUN("%clang_cc1 -cl-std=CL1.1 -cl-strict-aliasing -fblocks %s 2>&1")./*|*/
      I("FileCheck --check-prefix=CHECK-INVALID-OPENCL-VERSION11 %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -cl-std=CL1.2 -cl-strict-aliasing -fblocks ${LLVM_SRC}/llvm/tools/clang/test/Frontend/opencl.cl 2>&1 | ${LLVM_SRC}/build/bin/FileCheck --check-prefix=CHECK-INVALID-OPENCL-VERSION12 ${LLVM_SRC}/llvm/tools/clang/test/Frontend/opencl.cl
    RUN("%clang_cc1 -cl-std=CL1.2 -cl-strict-aliasing -fblocks %s 2>&1")./*|*/
      I("FileCheck --check-prefix=CHECK-INVALID-OPENCL-VERSION12 %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -cl-std=CL2.0 -cl-strict-aliasing ${LLVM_SRC}/llvm/tools/clang/test/Frontend/opencl.cl 2>&1 | ${LLVM_SRC}/build/bin/FileCheck --check-prefix=CHECK-INVALID-OPENCL-VERSION20 ${LLVM_SRC}/llvm/tools/clang/test/Frontend/opencl.cl
    RUN("%clang_cc1 -cl-std=CL2.0 -cl-strict-aliasing %s 2>&1")./*|*/
      I("FileCheck --check-prefix=CHECK-INVALID-OPENCL-VERSION20 %s");
  }

  @Test
  public void test_optimization_remark_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Frontend/optimization-remark.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/Frontend/optimization-remark.c -Rpass=inline -Rpass-analysis=inline -Rpass-missed=inline -O0 -emit-llvm-only -verify
    RUN(TestState.Failed, "%clang_cc1 %s -Rpass=inline -Rpass-analysis=inline -Rpass-missed=inline -O0 -emit-llvm-only -verify");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/Frontend/optimization-remark.c -Rpass=inline -Rpass-analysis=inline -Rpass-missed=inline -O0 -emit-llvm-only -debug-info-kind=line-tables-only -verify
    RUN(TestState.Failed, "%clang_cc1 %s -Rpass=inline -Rpass-analysis=inline -Rpass-missed=inline -O0 -emit-llvm-only -debug-info-kind=line-tables-only -verify");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/Frontend/optimization-remark.c -Rpass=inline -emit-llvm -o - 2>/dev/null | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Frontend/optimization-remark.c
    RUN(TestState.Failed, "%clang_cc1 %s -Rpass=inline -emit-llvm -o - 2>/dev/null")./*|*/
      I("FileCheck %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/Frontend/optimization-remark.c -Rpass=inline -emit-llvm -o - 2>&1 | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Frontend/optimization-remark.c --check-prefix=CHECK-REMARKS
    RUN(TestState.Failed, "%clang_cc1 %s -Rpass=inline -emit-llvm -o - 2>&1")./*|*/
      I("FileCheck %s --check-prefix=CHECK-REMARKS");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/Frontend/optimization-remark.c -Rpass=inline -Rno-pass -emit-llvm -o - 2>&1 | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Frontend/optimization-remark.c --check-prefix=CHECK-NO-REMARKS
    RUN(TestState.Failed, "%clang_cc1 %s -Rpass=inline -Rno-pass -emit-llvm -o - 2>&1")./*|*/
      I("FileCheck %s --check-prefix=CHECK-NO-REMARKS");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/Frontend/optimization-remark.c -Rpass=inline -Rno-everything -emit-llvm -o - 2>&1 | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Frontend/optimization-remark.c --check-prefix=CHECK-NO-REMARKS
    RUN(TestState.Failed, "%clang_cc1 %s -Rpass=inline -Rno-everything -emit-llvm -o - 2>&1")./*|*/
      I("FileCheck %s --check-prefix=CHECK-NO-REMARKS");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/Frontend/optimization-remark.c -Rpass=inline -Rno-everything -Reverything -emit-llvm -o - 2>&1 | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Frontend/optimization-remark.c --check-prefix=CHECK-REMARKS
    RUN(TestState.Failed, "%clang_cc1 %s -Rpass=inline -Rno-everything -Reverything -emit-llvm -o - 2>&1")./*|*/
      I("FileCheck %s --check-prefix=CHECK-REMARKS");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/Frontend/optimization-remark.c -Reverything -emit-llvm -o - 2>/dev/null | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Frontend/optimization-remark.c --check-prefix=CHECK-NO-REMARKS
    RUN(TestState.Failed, "%clang_cc1 %s -Reverything -emit-llvm -o - 2>/dev/null")./*|*/
      I("FileCheck %s --check-prefix=CHECK-NO-REMARKS");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/Frontend/optimization-remark.c -Rpass -emit-llvm -o - 2>/dev/null | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Frontend/optimization-remark.c --check-prefix=CHECK-NO-REMARKS
    RUN(TestState.Failed, "%clang_cc1 %s -Rpass -emit-llvm -o - 2>/dev/null")./*|*/
      I("FileCheck %s --check-prefix=CHECK-NO-REMARKS");
  }

  @Test
  public void test_optimization_remark_analysis_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Frontend/optimization-remark-analysis.c");
    // ${LLVM_SRC}/build/bin/clang -O1 -fvectorize -target x86_64-unknown-unknown -emit-llvm -Rpass-analysis -S ${LLVM_SRC}/llvm/tools/clang/test/Frontend/optimization-remark-analysis.c -o - 2>&1 | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Frontend/optimization-remark-analysis.c --check-prefix=RPASS
    RUN(TestState.Failed, "%clang -O1 -fvectorize -target x86_64-unknown-unknown -emit-llvm -Rpass-analysis -S %s -o - 2>&1")./*|*/
      I("FileCheck %s --check-prefix=RPASS");
    // ${LLVM_SRC}/build/bin/clang -O1 -fvectorize -target x86_64-unknown-unknown -emit-llvm -S ${LLVM_SRC}/llvm/tools/clang/test/Frontend/optimization-remark-analysis.c -o - 2>&1 | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Frontend/optimization-remark-analysis.c
    RUN(TestState.Failed, "%clang -O1 -fvectorize -target x86_64-unknown-unknown -emit-llvm -S %s -o - 2>&1")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_optimization_remark_line_directive_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Frontend/optimization-remark-line-directive.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/Frontend/optimization-remark-line-directive.c -Rpass=inline -debug-info-kind=line-tables-only -dwarf-column-info -emit-llvm-only -verify
    RUN(TestState.Failed, "%clang_cc1 %s -Rpass=inline -debug-info-kind=line-tables-only -dwarf-column-info -emit-llvm-only -verify");
  }

  @Test
  public void test_optimization_remark_options_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Frontend/optimization-remark-options.c");
    // ${LLVM_SRC}/build/bin/clang -O1 -fvectorize -target x86_64-unknown-unknown -Rpass-analysis=loop-vectorize -emit-llvm -S ${LLVM_SRC}/llvm/tools/clang/test/Frontend/optimization-remark-options.c -o - 2>&1 | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Frontend/optimization-remark-options.c
    RUN(TestState.Failed, "%clang -O1 -fvectorize -target x86_64-unknown-unknown -Rpass-analysis=loop-vectorize -emit-llvm -S %s -o - 2>&1")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_output_failures_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Frontend/output-failures.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm -o ${LLVM_SRC}/llvm/tools/clang/test/Frontend/doesnotexist/somename ${LLVM_SRC}/llvm/tools/clang/test/Frontend/output-failures.c 2> ${TEST_TEMP_DIR}/output-failures.c.tmp
    RUN("not %clang_cc1 -emit-llvm -o %S/doesnotexist/somename %s 2> %t");
    // ${LLVM_SRC}/build/bin/FileCheck -check-prefix=OUTPUTFAIL '-input-file=${TEST_TEMP_DIR}/output-failures.c.tmp' ${LLVM_SRC}/llvm/tools/clang/test/Frontend/output-failures.c
    RUN("FileCheck -check-prefix=OUTPUTFAIL -input-file=%t %s");
  }

  @Test
  public void test_plugin_annotate_functions_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Frontend/plugin-annotate-functions.c");
    // REQUIRES: plugins, examples
    if (!CHECK_REQUIRES("plugins, examples")) {
      return;
    }
    // ${LLVM_SRC}/build/bin/clang '-fplugin=${LLVM_SRC}/build/tools/clang/lib/AnnotateFunctions${LLVM_SRC}/llvm/tools/clang/test/Frontendluginext' -emit-llvm -DPRAGMA_ON -S ${LLVM_SRC}/llvm/tools/clang/test/Frontend/plugin-annotate-functions.c -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Frontend/plugin-annotate-functions.c --check-prefix=PRAGMA
    RUN(TestState.Failed, "%clang -fplugin=%llvmshlibdir/AnnotateFunctions%pluginext -emit-llvm -DPRAGMA_ON -S %s -o -")./*|*/
      I("FileCheck %s --check-prefix=PRAGMA");
    // ${LLVM_SRC}/build/bin/clang '-fplugin=${LLVM_SRC}/build/tools/clang/lib/AnnotateFunctions${LLVM_SRC}/llvm/tools/clang/test/Frontendluginext' -emit-llvm -S ${LLVM_SRC}/llvm/tools/clang/test/Frontend/plugin-annotate-functions.c -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Frontend/plugin-annotate-functions.c --check-prefix=NOPRAGMA
    RUN(TestState.Failed, "%clang -fplugin=%llvmshlibdir/AnnotateFunctions%pluginext -emit-llvm -S %s -o -")./*|*/
      I("FileCheck %s --check-prefix=NOPRAGMA");
    // ${LLVM_SRC}/build/bin/clang '-fplugin=${LLVM_SRC}/build/tools/clang/lib/AnnotateFunctions${LLVM_SRC}/llvm/tools/clang/test/Frontendluginext' -emit-llvm -DBAD_PRAGMA -S ${LLVM_SRC}/llvm/tools/clang/test/Frontend/plugin-annotate-functions.c -o - 2>&1 | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Frontend/plugin-annotate-functions.c --check-prefix=BADPRAGMA
    RUN(TestState.Failed, "not %clang -fplugin=%llvmshlibdir/AnnotateFunctions%pluginext -emit-llvm -DBAD_PRAGMA -S %s -o - 2>&1")./*|*/
      I("FileCheck %s --check-prefix=BADPRAGMA");
  }

  @Test
  public void test_plugin_delayed_template_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Frontend/plugin-delayed-template.cpp");
    // REQUIRES: plugins, examples
    if (!CHECK_REQUIRES("plugins, examples")) {
      return;
    }
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fdelayed-template-parsing -load ${LLVM_SRC}/build/tools/clang/lib/PrintFunctionNames${LLVM_SRC}/llvm/tools/clang/test/Frontendluginext -plugin print-fns -plugin-arg-print-fns -parse-template -plugin-arg-print-fns ForcedTemplate ${LLVM_SRC}/llvm/tools/clang/test/Frontend/plugin-delayed-template.cpp 2>&1 | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Frontend/plugin-delayed-template.cpp
    RUN(TestState.Failed, "%clang_cc1 -fdelayed-template-parsing -load %llvmshlibdir/PrintFunctionNames%pluginext -plugin print-fns -plugin-arg-print-fns -parse-template -plugin-arg-print-fns ForcedTemplate %s 2>&1")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_plugins_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Frontend/plugins.c");
    // REQUIRES: plugins, examples
    if (!CHECK_REQUIRES("plugins, examples")) {
      return;
    }
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -load ${LLVM_SRC}/build/tools/clang/lib/PrintFunctionNames.so -plugin print-fns ${LLVM_SRC}/llvm/tools/clang/test/Frontend/plugins.c 2>&1 | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Frontend/plugins.c
    RUN(TestState.Failed, "%clang_cc1 -load %llvmshlibdir/PrintFunctionNames%pluginext -plugin print-fns %s 2>&1")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_preprocessed_output_macro_first_token_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Frontend/preprocessed-output-macro-first-token.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fms-extensions -E ${LLVM_SRC}/llvm/tools/clang/test/Frontend/preprocessed-output-macro-first-token.c
    RUN("%clang_cc1 -fms-extensions -E %s");
  }

  @Test
  public void test_print_header_includes_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Frontend/print-header-includes.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc '-I${LLVM_SRC}/llvm/tools/clang/test/Frontend' -include Inputs/test3.h -E -H -o /dev/null ${LLVM_SRC}/llvm/tools/clang/test/Frontend/print-header-includes.c 2> ${TEST_TEMP_DIR}/print-header-includes.c.tmp.stderr
    RUN("%clang_cc1 -I%S -include Inputs/test3.h -E -H -o /dev/null %s 2> %t.stderr");
    // ${LLVM_SRC}/build/bin/FileCheck < ${TEST_TEMP_DIR}/print-header-includes.c.tmp.stderr ${LLVM_SRC}/llvm/tools/clang/test/Frontend/print-header-includes.c
    RUN("FileCheck < %t.stderr %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc '-I${LLVM_SRC}/llvm/tools/clang/test/Frontend' -include Inputs/test3.h -E --show-includes -o /dev/null ${LLVM_SRC}/llvm/tools/clang/test/Frontend/print-header-includes.c | ${LLVM_SRC}/build/bin/FileCheck --strict-whitespace --check-prefix=MS ${LLVM_SRC}/llvm/tools/clang/test/Frontend/print-header-includes.c
    RUN("%clang_cc1 -I%S -include Inputs/test3.h -E --show-includes -o /dev/null %s")./*|*/
      I("FileCheck --strict-whitespace --check-prefix=MS %s");
    // echo fun:foo > ${TEST_TEMP_DIR}/print-header-includes.c.tmp.blacklist
    RUN("echo \"fun:foo\" > %t.blacklist");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc '-I${LLVM_SRC}/llvm/tools/clang/test/Frontend' -fsanitize=address '-fdepfile-entry=${TEST_TEMP_DIR}/print-header-includes.c.tmp.blacklist' -E --show-includes -o /dev/null ${LLVM_SRC}/llvm/tools/clang/test/Frontend/print-header-includes.c | ${LLVM_SRC}/build/bin/FileCheck --strict-whitespace --check-prefix=MS-BLACKLIST ${LLVM_SRC}/llvm/tools/clang/test/Frontend/print-header-includes.c
    RUN("%clang_cc1 -I%S -fsanitize=address -fdepfile-entry=%t.blacklist -E --show-includes -o /dev/null %s")./*|*/
      I("FileCheck --strict-whitespace --check-prefix=MS-BLACKLIST %s");
  }

  @Test
  public void test_profile_sample_use_loc_tracking_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Frontend/profile-sample-use-loc-tracking.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/Frontend/profile-sample-use-loc-tracking.c '-fprofile-sample-use=${LLVM_SRC}/llvm/tools/clang/test/Frontend/Inputs/profile-sample-use-loc-tracking.prof' -emit-llvm -o - 2>/dev/null | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Frontend/profile-sample-use-loc-tracking.c
    RUN(TestState.Failed, "%clang_cc1 %s -fprofile-sample-use=%S/Inputs/profile-sample-use-loc-tracking.prof -emit-llvm -o - 2>/dev/null")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_rewrite_includes_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Frontend/rewrite-includes.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -verify -E -frewrite-includes -DFIRST -I ${LLVM_SRC}/llvm/tools/clang/test/Frontend/Inputs ${LLVM_SRC}/llvm/tools/clang/test/Frontend/rewrite-includes.c -o - | ${LLVM_SRC}/build/bin/FileCheck -strict-whitespace ${LLVM_SRC}/llvm/tools/clang/test/Frontend/rewrite-includes.c
    RUN("not %clang_cc1 -verify -E -frewrite-includes -DFIRST -I %S/Inputs %s -o -")./*|*/
      I("FileCheck -strict-whitespace %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -verify -E -frewrite-includes -P -DFIRST -I ${LLVM_SRC}/llvm/tools/clang/test/Frontend/Inputs ${LLVM_SRC}/llvm/tools/clang/test/Frontend/rewrite-includes.c -o - | ${LLVM_SRC}/build/bin/FileCheck -check-prefix=CHECKNL -strict-whitespace ${LLVM_SRC}/llvm/tools/clang/test/Frontend/rewrite-includes.c
    RUN("not %clang_cc1 -verify -E -frewrite-includes -P -DFIRST -I %S/Inputs %s -o -")./*|*/
      I("FileCheck -check-prefix=CHECKNL -strict-whitespace %s");
  }

  @Test
  public void test_rewrite_includes_bom_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Frontend/rewrite-includes-bom.c");
    // REQUIRES: shell
    if (!CHECK_REQUIRES("shell")) {
      return;
    }
    // grep -q "$'^\xEF\xBB\xBF'" ${LLVM_SRC}/llvm/tools/clang/test/Frontend/Inputs/rewrite-includes-bom.h
    RUN(TestState.Failed, "grep -q $'^\\xEF\\xBB\\xBF' %S/Inputs/rewrite-includes-bom.h");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -E -frewrite-includes -I ${LLVM_SRC}/llvm/tools/clang/test/Frontend/Inputs ${LLVM_SRC}/llvm/tools/clang/test/Frontend/rewrite-includes-bom.c -o ${TEST_TEMP_DIR}/rewrite-includes-bom.c.tmp.c
    RUN(TestState.Failed, "%clang_cc1 -E -frewrite-includes -I %S/Inputs %s -o %t.c");
    // ! grep -q "$'\xEF\xBB\xBF'" ${TEST_TEMP_DIR}/rewrite-includes-bom.c.tmp.c
    RUN(TestState.Failed, "! grep -q $'\\xEF\\xBB\\xBF' %t.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${TEST_TEMP_DIR}/rewrite-includes-bom.c.tmp.c
    RUN(TestState.Failed, "%clang_cc1 -fsyntax-only -verify %t.c");
  }

  @Test
  public void test_rewrite_includes_cli_include_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Frontend/rewrite-includes-cli-include.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -verify -E -frewrite-includes -include ${LLVM_SRC}/llvm/tools/clang/test/Frontend/Inputs/rewrite-includes2.h ${LLVM_SRC}/llvm/tools/clang/test/Frontend/rewrite-includes-cli-include.c -o - | ${LLVM_SRC}/build/bin/FileCheck -strict-whitespace ${LLVM_SRC}/llvm/tools/clang/test/Frontend/rewrite-includes-cli-include.c
    RUN("not %clang_cc1 -verify -E -frewrite-includes -include %S/Inputs/rewrite-includes2.h %s -o -")./*|*/
      I("FileCheck -strict-whitespace %s");
  }

  @Test
  public void test_rewrite_includes_eof_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Frontend/rewrite-includes-eof.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -E -frewrite-includes -I ${LLVM_SRC}/llvm/tools/clang/test/Frontend/Inputs ${LLVM_SRC}/llvm/tools/clang/test/Frontend/rewrite-includes-eof.c
    RUN("%clang_cc1 -E -frewrite-includes -I %S/Inputs %s");
  }

  @Test
  public void test_rewrite_includes_header_cmd_line_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Frontend/rewrite-includes-header-cmd-line.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -E -frewrite-includes -include rewrite-includes2.h -I ${LLVM_SRC}/llvm/tools/clang/test/Frontend/Inputs ${LLVM_SRC}/llvm/tools/clang/test/Frontend/rewrite-includes-header-cmd-line.c -o - | ${LLVM_SRC}/build/bin/FileCheck -strict-whitespace ${LLVM_SRC}/llvm/tools/clang/test/Frontend/rewrite-includes-header-cmd-line.c
    RUN("%clang_cc1 -E -frewrite-includes -include rewrite-includes2.h -I %S/Inputs %s -o -")./*|*/
      I("FileCheck -strict-whitespace %s");
  }

  @Test
  public void test_rewrite_includes_invalid_hasinclude_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Frontend/rewrite-includes-invalid-hasinclude.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -E -frewrite-includes -DFIRST -I ${LLVM_SRC}/llvm/tools/clang/test/Frontend/Inputs ${LLVM_SRC}/llvm/tools/clang/test/Frontend/rewrite-includes-invalid-hasinclude.c -o - | ${LLVM_SRC}/build/bin/FileCheck -strict-whitespace ${LLVM_SRC}/llvm/tools/clang/test/Frontend/rewrite-includes-invalid-hasinclude.c
    RUN("not %clang_cc1 -E -frewrite-includes -DFIRST -I %S/Inputs %s -o -")./*|*/
      I("FileCheck -strict-whitespace %s");
  }

  @Test
  public void test_rewrite_includes_line_markers_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Frontend/rewrite-includes-line-markers.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -E -frewrite-includes -I ${LLVM_SRC}/llvm/tools/clang/test/Frontend/Inputs ${LLVM_SRC}/llvm/tools/clang/test/Frontend/rewrite-includes-line-markers.c | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Frontend/rewrite-includes-line-markers.c --check-prefix=GNU
    RUN("%clang_cc1 -E -frewrite-includes -I %S/Inputs %s")./*|*/
      I("FileCheck %s --check-prefix=GNU");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -E -frewrite-includes -fuse-line-directives -I ${LLVM_SRC}/llvm/tools/clang/test/Frontend/Inputs ${LLVM_SRC}/llvm/tools/clang/test/Frontend/rewrite-includes-line-markers.c | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Frontend/rewrite-includes-line-markers.c --check-prefix=LINE
    RUN("%clang_cc1 -E -frewrite-includes -fuse-line-directives -I %S/Inputs %s")./*|*/
      I("FileCheck %s --check-prefix=LINE");
  }

  @Test
  public void test_rewrite_includes_messages_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Frontend/rewrite-includes-messages.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -E -frewrite-includes ${LLVM_SRC}/llvm/tools/clang/test/Frontend/rewrite-includes-messages.c '-I${LLVM_SRC}/llvm/tools/clang/test/Frontend/Inputs/' | ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -Wall -fsyntax-only -Wunused-macros -x c - 2>&1 > ${TEST_TEMP_DIR}/rewrite-includes-messages.c.tmp.1
    RUN(TestState.Failed, "%clang_cc1 -E -frewrite-includes %s -I%S/Inputs/")./*|*/
      I("%clang_cc1 -Wall -fsyntax-only -Wunused-macros -x c - 2>&1 > %t.1");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc '-I${LLVM_SRC}/llvm/tools/clang/test/Frontend/Inputs/' -Wall -Wunused-macros -fsyntax-only ${LLVM_SRC}/llvm/tools/clang/test/Frontend/rewrite-includes-messages.c 2>&1 > ${TEST_TEMP_DIR}/rewrite-includes-messages.c.tmp.2
    RUN(TestState.Failed, "%clang_cc1 -I%S/Inputs/ -Wall -Wunused-macros -fsyntax-only %s 2>&1 > %t.2");
    // diff ${TEST_TEMP_DIR}/rewrite-includes-messages.c.tmp.1 ${TEST_TEMP_DIR}/rewrite-includes-messages.c.tmp.2 -u
    RUN(TestState.Failed, "diff %t.1 %t.2 -u");
  }

  @Test
  public void test_rewrite_includes_missing_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Frontend/rewrite-includes-missing.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -verify -E -frewrite-includes ${LLVM_SRC}/llvm/tools/clang/test/Frontend/rewrite-includes-missing.c -o - | ${LLVM_SRC}/build/bin/FileCheck -strict-whitespace ${LLVM_SRC}/llvm/tools/clang/test/Frontend/rewrite-includes-missing.c
    RUN("%clang_cc1 -verify -E -frewrite-includes %s -o -")./*|*/
      I("FileCheck -strict-whitespace %s");
  }

  @Test
  public void test_rewrite_includes_modules_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Frontend/rewrite-includes-modules.c");
    // rm -rf ${TEST_TEMP_DIR}/rewrite-includes-modules.c.tmp
    RUN("rm -rf %t");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fmodules -fimplicit-module-maps '-fmodules-cache-path=${TEST_TEMP_DIR}/rewrite-includes-modules.c.tmp' -x objective-c ${LLVM_SRC}/llvm/tools/clang/test/Frontend/rewrite-includes-modules.c -F ${LLVM_SRC}/llvm/tools/clang/test/Frontend/../Modules/Inputs -E -frewrite-includes -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Frontend/rewrite-includes-modules.c
    RUN("%clang_cc1 -fmodules -fimplicit-module-maps -fmodules-cache-path=%t -x objective-c %s -F %S/../Modules/Inputs -E -frewrite-includes -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_rewrite_includes_warnings_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Frontend/rewrite-includes-warnings.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -verify -Wall -Wextra -E -frewrite-includes ${LLVM_SRC}/llvm/tools/clang/test/Frontend/rewrite-includes-warnings.c
    RUN("%clang_cc1 -verify -Wall -Wextra -E -frewrite-includes %s");
  }

  @Test
  public void test_rewrite_macros_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Frontend/rewrite-macros.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/Frontend/rewrite-macros.c -verify -rewrite-macros -o ${TEST_TEMP_DIR}/rewrite-macros.c.tmp
    RUN(TestState.Failed, "%clang_cc1 %s -verify -rewrite-macros -o %t");
    // ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Frontend/rewrite-macros.c < ${TEST_TEMP_DIR}/rewrite-macros.c.tmp
    RUN(TestState.Failed, "FileCheck %s < %t");
  }

  @Test
  public void test_source_col_map_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Frontend/source-col-map.c");
    // REQUIRES: utf8-capable-terminal
    if (!CHECK_REQUIRES("utf8-capable-terminal")) {
      return;
    }
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -fmessage-length 75 -o /dev/null -x c < ${LLVM_SRC}/llvm/tools/clang/test/Frontend/source-col-map.c 2>&1 | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Frontend/source-col-map.c -strict-whitespace
    RUN("not %clang_cc1 -fsyntax-only -fmessage-length 75 -o /dev/null -x c < %s 2>&1")./*|*/
      I("FileCheck %s -strict-whitespace");
  }

  @Test
  public void test_stdin_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Frontend/stdin.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -E - < /dev/null > ${TEST_TEMP_DIR}/stdin.c.tmp
    RUN(TestState.Failed, "%clang_cc1 -E - < /dev/null > %t");
    // grep <built-in> ${TEST_TEMP_DIR}/stdin.c.tmp
    RUN(TestState.Failed, "grep '<built-in>' %t");
  }

  @Test
  public void test_stdlang_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Frontend/stdlang.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x cuda -std=c++11 -DCUDA ${LLVM_SRC}/llvm/tools/clang/test/Frontend/stdlang.c
    RUN("%clang_cc1 -x cuda -std=c++11 -DCUDA %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x cl -DOPENCL ${LLVM_SRC}/llvm/tools/clang/test/Frontend/stdlang.c
    RUN("%clang_cc1 -x cl -DOPENCL %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x cl -cl-std=cl -DOPENCL ${LLVM_SRC}/llvm/tools/clang/test/Frontend/stdlang.c
    RUN("%clang_cc1 -x cl -cl-std=cl -DOPENCL %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x cl -cl-std=cl1.1 -DOPENCL ${LLVM_SRC}/llvm/tools/clang/test/Frontend/stdlang.c
    RUN("%clang_cc1 -x cl -cl-std=cl1.1 -DOPENCL %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x cl -cl-std=cl1.2 -DOPENCL ${LLVM_SRC}/llvm/tools/clang/test/Frontend/stdlang.c
    RUN("%clang_cc1 -x cl -cl-std=cl1.2 -DOPENCL %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x cl -cl-std=cl2.0 -DOPENCL ${LLVM_SRC}/llvm/tools/clang/test/Frontend/stdlang.c
    RUN("%clang_cc1 -x cl -cl-std=cl2.0 -DOPENCL %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x cl -cl-std=CL -DOPENCL ${LLVM_SRC}/llvm/tools/clang/test/Frontend/stdlang.c
    RUN("%clang_cc1 -x cl -cl-std=CL -DOPENCL %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x cl -cl-std=CL1.1 -DOPENCL ${LLVM_SRC}/llvm/tools/clang/test/Frontend/stdlang.c
    RUN("%clang_cc1 -x cl -cl-std=CL1.1 -DOPENCL %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x cl -cl-std=CL1.2 -DOPENCL ${LLVM_SRC}/llvm/tools/clang/test/Frontend/stdlang.c
    RUN("%clang_cc1 -x cl -cl-std=CL1.2 -DOPENCL %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x cl -cl-std=CL2.0 -DOPENCL ${LLVM_SRC}/llvm/tools/clang/test/Frontend/stdlang.c
    RUN("%clang_cc1 -x cl -cl-std=CL2.0 -DOPENCL %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x cl -std=c99 -DOPENCL ${LLVM_SRC}/llvm/tools/clang/test/Frontend/stdlang.c 2>&1 | ${LLVM_SRC}/build/bin/FileCheck --check-prefix=CHECK-C99 ${LLVM_SRC}/llvm/tools/clang/test/Frontend/stdlang.c
    RUN("not %clang_cc1 -x cl -std=c99 -DOPENCL %s 2>&1")./*|*/
      I("FileCheck --check-prefix=CHECK-C99 %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x cl -cl-std=invalid -DOPENCL ${LLVM_SRC}/llvm/tools/clang/test/Frontend/stdlang.c 2>&1 | ${LLVM_SRC}/build/bin/FileCheck --check-prefix=CHECK-INVALID ${LLVM_SRC}/llvm/tools/clang/test/Frontend/stdlang.c
    RUN("not %clang_cc1 -x cl -cl-std=invalid -DOPENCL %s 2>&1")./*|*/
      I("FileCheck --check-prefix=CHECK-INVALID %s");
  }

  @Test
  public void test_system_header_prefix_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Frontend/system-header-prefix.c");
    // ${LLVM_SRC}/build/bin/clang --system-header-prefix=libs/ --no-system-header-prefix=libs/mylib/ '-I${LLVM_SRC}/llvm/tools/clang/test/Frontend/Inputs/SystemHeaderPrefix' -Wundef -E ${LLVM_SRC}/llvm/tools/clang/test/Frontend/system-header-prefix.c 2>&1 | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Frontend/system-header-prefix.c
    RUN("%clang --system-header-prefix=libs/ --no-system-header-prefix=libs/mylib/ -I%S/Inputs/SystemHeaderPrefix -Wundef -E %s 2>&1")./*|*/
      I("FileCheck %s");
    // ${LLVM_SRC}/build/bin/clang --system-header-prefix libs/ --no-system-header-prefix libs/mylib/ '-I${LLVM_SRC}/llvm/tools/clang/test/Frontend/Inputs/SystemHeaderPrefix' -Wundef -E ${LLVM_SRC}/llvm/tools/clang/test/Frontend/system-header-prefix.c 2>&1 | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Frontend/system-header-prefix.c
    RUN("%clang --system-header-prefix libs/ --no-system-header-prefix libs/mylib/ -I%S/Inputs/SystemHeaderPrefix -Wundef -E %s 2>&1")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_trigraphs_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Frontend/trigraphs.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -DSTDCPP11 -std=c++11 -verify -fsyntax-only ${LLVM_SRC}/llvm/tools/clang/test/Frontend/trigraphs.cpp
    RUN("%clang_cc1 -DSTDCPP11 -std=c++11 -verify -fsyntax-only %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -DSTDGNU11 -std=gnu++11 -verify -fsyntax-only ${LLVM_SRC}/llvm/tools/clang/test/Frontend/trigraphs.cpp
    RUN("%clang_cc1 -DSTDGNU11 -std=gnu++11 -verify -fsyntax-only %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -DSTDGNU11TRI -ftrigraphs -std=gnu++11 -verify -fsyntax-only ${LLVM_SRC}/llvm/tools/clang/test/Frontend/trigraphs.cpp
    RUN("%clang_cc1 -DSTDGNU11TRI -ftrigraphs -std=gnu++11 -verify -fsyntax-only %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -DSTDCPP17 -std=c++1z -verify -fsyntax-only ${LLVM_SRC}/llvm/tools/clang/test/Frontend/trigraphs.cpp
    RUN("%clang_cc1 -DSTDCPP17 -std=c++1z -verify -fsyntax-only %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -DSTDCPP17TRI -ftrigraphs -std=c++1z -verify -fsyntax-only ${LLVM_SRC}/llvm/tools/clang/test/Frontend/trigraphs.cpp
    RUN("%clang_cc1 -DSTDCPP17TRI -ftrigraphs -std=c++1z -verify -fsyntax-only %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -DMSCOMPAT -fms-compatibility -std=c++11 -verify -fsyntax-only ${LLVM_SRC}/llvm/tools/clang/test/Frontend/trigraphs.cpp
    RUN("%clang_cc1 -DMSCOMPAT -fms-compatibility -std=c++11 -verify -fsyntax-only %s");
  }

  @Test
  public void test_undef_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Frontend/undef.c");
    // ${LLVM_SRC}/build/bin/clang -undef -x assembler-with-cpp -E ${LLVM_SRC}/llvm/tools/clang/test/Frontend/undef.c
    RUN("%clang -undef -x assembler-with-cpp -E %s");
  }

  @Test
  public void test_unknown_pragmas_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Frontend/unknown-pragmas.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -Eonly -Wall -verify ${LLVM_SRC}/llvm/tools/clang/test/Frontend/unknown-pragmas.c
    RUN("%clang_cc1 -Eonly -Wall -verify %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -E -dM -Wall -verify ${LLVM_SRC}/llvm/tools/clang/test/Frontend/unknown-pragmas.c
    RUN("%clang_cc1 -E -dM -Wall -verify %s");
  }

  @Test
  public void test_verify_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Frontend/verify.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -DTEST1 -verify ${LLVM_SRC}/llvm/tools/clang/test/Frontend/verify.c
    RUN("%clang_cc1 -DTEST1 -verify %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -DTEST2 -verify ${LLVM_SRC}/llvm/tools/clang/test/Frontend/verify.c 2>&1 | ${LLVM_SRC}/build/bin/FileCheck -check-prefix=CHECK2 ${LLVM_SRC}/llvm/tools/clang/test/Frontend/verify.c
    RUN("not %clang_cc1 -DTEST2 -verify %s 2>&1")./*|*/
      I("FileCheck -check-prefix=CHECK2 %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -DTEST3 -verify ${LLVM_SRC}/llvm/tools/clang/test/Frontend/verify.c 2>&1 | ${LLVM_SRC}/build/bin/FileCheck -check-prefix=CHECK3 ${LLVM_SRC}/llvm/tools/clang/test/Frontend/verify.c
    RUN("not %clang_cc1 -DTEST3 -verify %s 2>&1")./*|*/
      I("FileCheck -check-prefix=CHECK3 %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -DTEST4 -verify ${LLVM_SRC}/llvm/tools/clang/test/Frontend/verify.c 2>&1 | ${LLVM_SRC}/build/bin/FileCheck -check-prefix=CHECK4 ${LLVM_SRC}/llvm/tools/clang/test/Frontend/verify.c
    RUN("not %clang_cc1 -DTEST4 -verify %s 2>&1")./*|*/
      I("FileCheck -check-prefix=CHECK4 %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -DTEST5 -verify ${LLVM_SRC}/llvm/tools/clang/test/Frontend/verify.c 2>&1 | ${LLVM_SRC}/build/bin/FileCheck -check-prefix=CHECK5 ${LLVM_SRC}/llvm/tools/clang/test/Frontend/verify.c
    RUN("not %clang_cc1 -DTEST5 -verify %s 2>&1")./*|*/
      I("FileCheck -check-prefix=CHECK5 %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -verify ${TEST_TEMP_DIR}/verify.c.tmp.invalid 2>&1 | ${LLVM_SRC}/build/bin/FileCheck -check-prefix=CHECK6 ${LLVM_SRC}/llvm/tools/clang/test/Frontend/verify.c
    RUN("not %clang_cc1 -verify %t.invalid 2>&1")./*|*/
      I("FileCheck -check-prefix=CHECK6 %s");
    // printf '//expected-error@2{{1}}\n#error 2\n' | not ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -verify 2>&1 | ${LLVM_SRC}/build/bin/FileCheck -check-prefix=CHECK7 ${LLVM_SRC}/llvm/tools/clang/test/Frontend/verify.c
    RUN("printf '//expected-error@2{{1}}\\n#error 2\\n'")./*|*/
      I("not %clang_cc1 -verify 2>&1")./*|*/
      I("FileCheck -check-prefix=CHECK7 %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -DTEST8 -verify ${LLVM_SRC}/llvm/tools/clang/test/Frontend/verify.c 2>&1 | ${LLVM_SRC}/build/bin/FileCheck -check-prefix=CHECK8 ${LLVM_SRC}/llvm/tools/clang/test/Frontend/verify.c
    RUN("not %clang_cc1 -DTEST8 -verify %s 2>&1")./*|*/
      I("FileCheck -check-prefix=CHECK8 %s");
  }

  @Test
  public void test_verify_fatal_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Frontend/verify-fatal.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -Wfatal-errors -verify ${LLVM_SRC}/llvm/tools/clang/test/Frontend/verify-fatal.c 2>&1 | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Frontend/verify-fatal.c
    RUN("not %clang_cc1 -Wfatal-errors -verify %s 2>&1")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_verify_ignore_unexpected_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Frontend/verify-ignore-unexpected.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -DTEST_SWITCH -verify-ignore-unexpected=remark,aoeu,note -verify ${LLVM_SRC}/llvm/tools/clang/test/Frontend/verify-ignore-unexpected.c 2>&1 | ${LLVM_SRC}/build/bin/FileCheck -check-prefix=CHECK-BAD-SWITCH ${LLVM_SRC}/llvm/tools/clang/test/Frontend/verify-ignore-unexpected.c
    RUN("not %clang_cc1 -DTEST_SWITCH -verify-ignore-unexpected=remark,aoeu,note -verify %s 2>&1")./*|*/
      I("FileCheck -check-prefix=CHECK-BAD-SWITCH %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -DTEST1 -verify ${LLVM_SRC}/llvm/tools/clang/test/Frontend/verify-ignore-unexpected.c
    RUN("%clang_cc1 -DTEST1 -verify %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -DTEST1 -verify -verify-ignore-unexpected ${LLVM_SRC}/llvm/tools/clang/test/Frontend/verify-ignore-unexpected.c
    RUN("%clang_cc1 -DTEST1 -verify -verify-ignore-unexpected %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -DTEST2 -verify ${LLVM_SRC}/llvm/tools/clang/test/Frontend/verify-ignore-unexpected.c 2>&1 | ${LLVM_SRC}/build/bin/FileCheck -check-prefix=CHECK-UNEXP ${LLVM_SRC}/llvm/tools/clang/test/Frontend/verify-ignore-unexpected.c
    RUN("not %clang_cc1 -DTEST2 -verify %s 2>&1")./*|*/
      I("FileCheck -check-prefix=CHECK-UNEXP %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -DTEST2 -verify -verify-ignore-unexpected= ${LLVM_SRC}/llvm/tools/clang/test/Frontend/verify-ignore-unexpected.c 2>&1 | ${LLVM_SRC}/build/bin/FileCheck -check-prefix=CHECK-UNEXP ${LLVM_SRC}/llvm/tools/clang/test/Frontend/verify-ignore-unexpected.c
    RUN("not %clang_cc1 -DTEST2 -verify -verify-ignore-unexpected= %s 2>&1")./*|*/
      I("FileCheck -check-prefix=CHECK-UNEXP %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -DTEST2 -verify -verify-ignore-unexpected=note ${LLVM_SRC}/llvm/tools/clang/test/Frontend/verify-ignore-unexpected.c 2>&1 | ${LLVM_SRC}/build/bin/FileCheck -check-prefix=CHECK-NOTE ${LLVM_SRC}/llvm/tools/clang/test/Frontend/verify-ignore-unexpected.c
    RUN("not %clang_cc1 -DTEST2 -verify -verify-ignore-unexpected=note %s 2>&1")./*|*/
      I("FileCheck -check-prefix=CHECK-NOTE %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -DTEST2 -verify -verify-ignore-unexpected=warning ${LLVM_SRC}/llvm/tools/clang/test/Frontend/verify-ignore-unexpected.c 2>&1 | ${LLVM_SRC}/build/bin/FileCheck -check-prefix=CHECK-WARN ${LLVM_SRC}/llvm/tools/clang/test/Frontend/verify-ignore-unexpected.c
    RUN("not %clang_cc1 -DTEST2 -verify -verify-ignore-unexpected=warning %s 2>&1")./*|*/
      I("FileCheck -check-prefix=CHECK-WARN %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -DTEST2 -verify -verify-ignore-unexpected=error ${LLVM_SRC}/llvm/tools/clang/test/Frontend/verify-ignore-unexpected.c 2>&1 | ${LLVM_SRC}/build/bin/FileCheck -check-prefix=CHECK-ERR ${LLVM_SRC}/llvm/tools/clang/test/Frontend/verify-ignore-unexpected.c
    RUN("not %clang_cc1 -DTEST2 -verify -verify-ignore-unexpected=error %s 2>&1")./*|*/
      I("FileCheck -check-prefix=CHECK-ERR %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -DTEST3 -verify -verify-ignore-unexpected ${LLVM_SRC}/llvm/tools/clang/test/Frontend/verify-ignore-unexpected.c 2>&1 | ${LLVM_SRC}/build/bin/FileCheck -check-prefix=CHECK-EXP ${LLVM_SRC}/llvm/tools/clang/test/Frontend/verify-ignore-unexpected.c
    RUN("not %clang_cc1 -DTEST3 -verify -verify-ignore-unexpected %s 2>&1")./*|*/
      I("FileCheck -check-prefix=CHECK-EXP %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -DTEST4 -verify -verify-ignore-unexpected ${LLVM_SRC}/llvm/tools/clang/test/Frontend/verify-ignore-unexpected.c 2>&1 | ${LLVM_SRC}/build/bin/FileCheck -check-prefix=CHECK-NOEXP ${LLVM_SRC}/llvm/tools/clang/test/Frontend/verify-ignore-unexpected.c
    RUN("not %clang_cc1 -DTEST4 -verify -verify-ignore-unexpected %s 2>&1")./*|*/
      I("FileCheck -check-prefix=CHECK-NOEXP %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -DTEST4 -verify -verify-ignore-unexpected=warning,error,note ${LLVM_SRC}/llvm/tools/clang/test/Frontend/verify-ignore-unexpected.c 2>&1 | ${LLVM_SRC}/build/bin/FileCheck -check-prefix=CHECK-NOEXP ${LLVM_SRC}/llvm/tools/clang/test/Frontend/verify-ignore-unexpected.c
    RUN("not %clang_cc1 -DTEST4 -verify -verify-ignore-unexpected=warning,error,note %s 2>&1")./*|*/
      I("FileCheck -check-prefix=CHECK-NOEXP %s");
  }

  @Test
  public void test_verify_unknown_arg_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Frontend/verify-unknown-arg.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -asdf -verify ${LLVM_SRC}/llvm/tools/clang/test/Frontend/verify-unknown-arg.c 2>&1 | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Frontend/verify-unknown-arg.c
    RUN("not %clang_cc1 -asdf -verify %s 2>&1")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_verify2_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Frontend/verify2.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -verify ${LLVM_SRC}/llvm/tools/clang/test/Frontend/verify2.c 2>&1 | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Frontend/verify2.c
    RUN("not %clang_cc1 -verify %s 2>&1")./*|*/
      I("FileCheck %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -DCHECK2 -verify ${LLVM_SRC}/llvm/tools/clang/test/Frontend/verify2.c 2>&1 | ${LLVM_SRC}/build/bin/FileCheck -check-prefix=CHECK2 ${LLVM_SRC}/llvm/tools/clang/test/Frontend/verify2.c
    RUN("not %clang_cc1 -DCHECK2 -verify %s 2>&1")./*|*/
      I("FileCheck -check-prefix=CHECK2 %s");
  }

  @Test
  public void test_verify3_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Frontend/verify3.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -DTEST1 -verify ${LLVM_SRC}/llvm/tools/clang/test/Frontend/verify3.c 2>&1 | ${LLVM_SRC}/build/bin/FileCheck -check-prefix=CHECK1 ${LLVM_SRC}/llvm/tools/clang/test/Frontend/verify3.c
    RUN("not %clang_cc1 -DTEST1 -verify %s 2>&1")./*|*/
      I("FileCheck -check-prefix=CHECK1 %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -DTEST2 -verify ${LLVM_SRC}/llvm/tools/clang/test/Frontend/verify3.c 2>&1 | ${LLVM_SRC}/build/bin/FileCheck -check-prefix=CHECK2 ${LLVM_SRC}/llvm/tools/clang/test/Frontend/verify3.c
    RUN("not %clang_cc1 -DTEST2 -verify %s 2>&1")./*|*/
      I("FileCheck -check-prefix=CHECK2 %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -DTEST3 -verify ${LLVM_SRC}/llvm/tools/clang/test/Frontend/verify3.c 2>&1 | ${LLVM_SRC}/build/bin/FileCheck -check-prefix=CHECK3 ${LLVM_SRC}/llvm/tools/clang/test/Frontend/verify3.c
    RUN("not %clang_cc1 -DTEST3 -verify %s 2>&1")./*|*/
      I("FileCheck -check-prefix=CHECK3 %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -verify ${LLVM_SRC}/llvm/tools/clang/test/Frontend/verify3.c 2>&1 | ${LLVM_SRC}/build/bin/FileCheck -check-prefix=CHECK3 ${LLVM_SRC}/llvm/tools/clang/test/Frontend/verify3.c
    RUN("not %clang_cc1 -verify %s 2>&1")./*|*/
      I("FileCheck -check-prefix=CHECK3 %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -E -DTEST4 -verify ${LLVM_SRC}/llvm/tools/clang/test/Frontend/verify3.c 2>&1 | ${LLVM_SRC}/build/bin/FileCheck -check-prefix=CHECK4 ${LLVM_SRC}/llvm/tools/clang/test/Frontend/verify3.c
    RUN("%clang_cc1 -E -DTEST4 -verify %s 2>&1")./*|*/
      I("FileCheck -check-prefix=CHECK4 %s");
  }

  @Test
  public void test_warning_mapping_1_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Frontend/warning-mapping-1.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -verify -Wsign-compare -Werror -w ${LLVM_SRC}/llvm/tools/clang/test/Frontend/warning-mapping-1.c
    RUN("%clang_cc1 -verify -Wsign-compare -Werror -w %s");
  }

  @Test
  public void test_warning_mapping_2_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Frontend/warning-mapping-2.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -verify -pedantic-errors -w ${LLVM_SRC}/llvm/tools/clang/test/Frontend/warning-mapping-2.c
    RUN("%clang_cc1 -verify -pedantic-errors -w %s");
  }

  @Test
  public void test_warning_mapping_3_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Frontend/warning-mapping-3.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -Wunused-function -Werror -Wfatal-errors ${LLVM_SRC}/llvm/tools/clang/test/Frontend/warning-mapping-3.c 2> ${TEST_TEMP_DIR}/warning-mapping-3.c.tmp.err
    RUN("not %clang_cc1 -Wunused-function -Werror -Wfatal-errors %s 2> %t.err");
    // ${LLVM_SRC}/build/bin/FileCheck < ${TEST_TEMP_DIR}/warning-mapping-3.c.tmp.err ${LLVM_SRC}/llvm/tools/clang/test/Frontend/warning-mapping-3.c
    RUN("FileCheck < %t.err %s");
  }

  @Test
  public void test_warning_mapping_4_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Frontend/warning-mapping-4.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -verify -Wno-error=sign-compare ${LLVM_SRC}/llvm/tools/clang/test/Frontend/warning-mapping-4.c
    RUN("%clang_cc1 -verify -Wno-error=sign-compare %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -verify -Wsign-compare -w -Wno-error=sign-compare ${LLVM_SRC}/llvm/tools/clang/test/Frontend/warning-mapping-4.c
    RUN("%clang_cc1 -verify -Wsign-compare -w -Wno-error=sign-compare %s");
  }

  @Test
  public void test_warning_mapping_5_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Frontend/warning-mapping-5.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -verify -Werror ${LLVM_SRC}/llvm/tools/clang/test/Frontend/warning-mapping-5.c
    RUN("%clang_cc1 -verify -Werror %s");
  }

  @Test
  public void test_warning_options_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Frontend/warning-options.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -Wmonkey -Wno-monkey -Wno-unused-command-line-arguments -Wno-unused-command-line-argument -Wmodule-build -Rmodule-built ${LLVM_SRC}/llvm/tools/clang/test/Frontend/warning-options.cpp 2>&1 | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Frontend/warning-options.cpp
    RUN("%clang_cc1 -Wmonkey -Wno-monkey -Wno-unused-command-line-arguments -Wno-unused-command-line-argument -Wmodule-build -Rmodule-built %s 2>&1")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_windows_nul_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Frontend/windows-nul.c");
    // REQUIRES: system-windows
    if (!CHECK_REQUIRES("system-windows")) {
      return;
    }
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc nul
    RUN(TestState.Failed, "%clang_cc1 nul");
  }

  @Test
  public void test_x86_target_cpu_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Frontend/x86-target-cpu.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-unknown-unknown -target-cpu nocona -verify ${LLVM_SRC}/llvm/tools/clang/test/Frontend/x86-target-cpu.c
    RUN("%clang_cc1 -triple x86_64-unknown-unknown -target-cpu nocona -verify %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-unknown-unknown -target-cpu core2 -verify ${LLVM_SRC}/llvm/tools/clang/test/Frontend/x86-target-cpu.c
    RUN("%clang_cc1 -triple x86_64-unknown-unknown -target-cpu core2 -verify %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-unknown-unknown -target-cpu penryn -verify ${LLVM_SRC}/llvm/tools/clang/test/Frontend/x86-target-cpu.c
    RUN("%clang_cc1 -triple x86_64-unknown-unknown -target-cpu penryn -verify %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-unknown-unknown -target-cpu nehalem -verify ${LLVM_SRC}/llvm/tools/clang/test/Frontend/x86-target-cpu.c
    RUN("%clang_cc1 -triple x86_64-unknown-unknown -target-cpu nehalem -verify %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-unknown-unknown -target-cpu westmere -verify ${LLVM_SRC}/llvm/tools/clang/test/Frontend/x86-target-cpu.c
    RUN("%clang_cc1 -triple x86_64-unknown-unknown -target-cpu westmere -verify %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-unknown-unknown -target-cpu sandybridge -verify ${LLVM_SRC}/llvm/tools/clang/test/Frontend/x86-target-cpu.c
    RUN("%clang_cc1 -triple x86_64-unknown-unknown -target-cpu sandybridge -verify %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-unknown-unknown -target-cpu ivybridge -verify ${LLVM_SRC}/llvm/tools/clang/test/Frontend/x86-target-cpu.c
    RUN("%clang_cc1 -triple x86_64-unknown-unknown -target-cpu ivybridge -verify %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-unknown-unknown -target-cpu haswell -verify ${LLVM_SRC}/llvm/tools/clang/test/Frontend/x86-target-cpu.c
    RUN("%clang_cc1 -triple x86_64-unknown-unknown -target-cpu haswell -verify %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-unknown-unknown -target-cpu broadwell -verify ${LLVM_SRC}/llvm/tools/clang/test/Frontend/x86-target-cpu.c
    RUN("%clang_cc1 -triple x86_64-unknown-unknown -target-cpu broadwell -verify %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-unknown-unknown -target-cpu bonnell -verify ${LLVM_SRC}/llvm/tools/clang/test/Frontend/x86-target-cpu.c
    RUN("%clang_cc1 -triple x86_64-unknown-unknown -target-cpu bonnell -verify %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-unknown-unknown -target-cpu silvermont -verify ${LLVM_SRC}/llvm/tools/clang/test/Frontend/x86-target-cpu.c
    RUN("%clang_cc1 -triple x86_64-unknown-unknown -target-cpu silvermont -verify %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-unknown-unknown -target-cpu k8 -verify ${LLVM_SRC}/llvm/tools/clang/test/Frontend/x86-target-cpu.c
    RUN("%clang_cc1 -triple x86_64-unknown-unknown -target-cpu k8 -verify %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-unknown-unknown -target-cpu opteron -verify ${LLVM_SRC}/llvm/tools/clang/test/Frontend/x86-target-cpu.c
    RUN("%clang_cc1 -triple x86_64-unknown-unknown -target-cpu opteron -verify %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-unknown-unknown -target-cpu athlon64 -verify ${LLVM_SRC}/llvm/tools/clang/test/Frontend/x86-target-cpu.c
    RUN("%clang_cc1 -triple x86_64-unknown-unknown -target-cpu athlon64 -verify %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-unknown-unknown -target-cpu athlon-fx -verify ${LLVM_SRC}/llvm/tools/clang/test/Frontend/x86-target-cpu.c
    RUN("%clang_cc1 -triple x86_64-unknown-unknown -target-cpu athlon-fx -verify %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-unknown-unknown -target-cpu k8-sse3 -verify ${LLVM_SRC}/llvm/tools/clang/test/Frontend/x86-target-cpu.c
    RUN("%clang_cc1 -triple x86_64-unknown-unknown -target-cpu k8-sse3 -verify %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-unknown-unknown -target-cpu opteron-sse3 -verify ${LLVM_SRC}/llvm/tools/clang/test/Frontend/x86-target-cpu.c
    RUN("%clang_cc1 -triple x86_64-unknown-unknown -target-cpu opteron-sse3 -verify %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-unknown-unknown -target-cpu athlon64-sse3 -verify ${LLVM_SRC}/llvm/tools/clang/test/Frontend/x86-target-cpu.c
    RUN("%clang_cc1 -triple x86_64-unknown-unknown -target-cpu athlon64-sse3 -verify %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-unknown-unknown -target-cpu amdfam10 -verify ${LLVM_SRC}/llvm/tools/clang/test/Frontend/x86-target-cpu.c
    RUN("%clang_cc1 -triple x86_64-unknown-unknown -target-cpu amdfam10 -verify %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-unknown-unknown -target-cpu barcelona -verify ${LLVM_SRC}/llvm/tools/clang/test/Frontend/x86-target-cpu.c
    RUN("%clang_cc1 -triple x86_64-unknown-unknown -target-cpu barcelona -verify %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-unknown-unknown -target-cpu bdver1 -verify ${LLVM_SRC}/llvm/tools/clang/test/Frontend/x86-target-cpu.c
    RUN("%clang_cc1 -triple x86_64-unknown-unknown -target-cpu bdver1 -verify %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-unknown-unknown -target-cpu bdver2 -verify ${LLVM_SRC}/llvm/tools/clang/test/Frontend/x86-target-cpu.c
    RUN("%clang_cc1 -triple x86_64-unknown-unknown -target-cpu bdver2 -verify %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-unknown-unknown -target-cpu bdver3 -verify ${LLVM_SRC}/llvm/tools/clang/test/Frontend/x86-target-cpu.c
    RUN("%clang_cc1 -triple x86_64-unknown-unknown -target-cpu bdver3 -verify %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-unknown-unknown -target-cpu bdver4 -verify ${LLVM_SRC}/llvm/tools/clang/test/Frontend/x86-target-cpu.c
    RUN("%clang_cc1 -triple x86_64-unknown-unknown -target-cpu bdver4 -verify %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-unknown-unknown -target-cpu btver1 -verify ${LLVM_SRC}/llvm/tools/clang/test/Frontend/x86-target-cpu.c
    RUN("%clang_cc1 -triple x86_64-unknown-unknown -target-cpu btver1 -verify %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-unknown-unknown -target-cpu btver2 -verify ${LLVM_SRC}/llvm/tools/clang/test/Frontend/x86-target-cpu.c
    RUN("%clang_cc1 -triple x86_64-unknown-unknown -target-cpu btver2 -verify %s");
  }

  @Test
  public void test_x86_64_nacl_types_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Frontend/x86_64-nacl-types.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-unknown-nacl -std=c++11 -verify ${LLVM_SRC}/llvm/tools/clang/test/Frontend/x86_64-nacl-types.cpp
    RUN("%clang_cc1 -triple x86_64-unknown-nacl -std=c++11 -verify %s");
  }
  
}
