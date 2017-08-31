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
package org.clang.sema.test;

import org.clang.tools.driver.test.DriverTestFileBase;
import org.junit.*;

/**
 * Collection of all test files from test/CodeCompletion folder
 * @author Vladimir Voskresensky
 */
public class AllCodeCompletionTest extends DriverTestFileBase {
  private static final String TEST_LOCATION = "${LLVM_SRC}/llvm/tools/clang/test/CodeCompletion/";
  public AllCodeCompletionTest() {
    super(TEST_LOCATION, TestState.Successful);
  }
  
  public static void main(String[] args) {
    // Print tests which will be accepted per test case
    DriverTestFileBase.printAllTestFiles(false, TEST_LOCATION, (test)->true, 
            "${SPUTNIK}/modules/org.clang.sema/test/unit/src/org/clang/sema/test/AllCodeCompletionTest.txt");
  }  
  
  @Override
  protected boolean keepStacksForUnimplementedMethods() {
    return false;
  }
  
  @Test
  public void test_PR9728_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeCompletion/PR9728.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only "-code-completion-at=${LLVM_SRC}/llvm/tools/clang/test/CodeCompletion/PR9728.cpp:6:20" ${LLVM_SRC}/llvm/tools/clang/test/CodeCompletion/PR9728.cpp -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeCompletion/PR9728.cpp
    RUN("%clang_cc1 -fsyntax-only -code-completion-at=%s:6:20 %s -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_auto_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeCompletion/auto.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c++11 "-code-completion-at=${LLVM_SRC}/llvm/tools/clang/test/CodeCompletion/auto.cpp:2:9" ${LLVM_SRC}/llvm/tools/clang/test/CodeCompletion/auto.cpp
    RUN("%clang_cc1 -std=c++11 -code-completion-at=%s:2:9 %s");
  }

  @Test
  public void test_bracket_decl_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeCompletion/bracket-decl.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -code-completion-macros "-code-completion-at=${LLVM_SRC}/llvm/tools/clang/test/CodeCompletion/bracket-decl.c:6:12" ${LLVM_SRC}/llvm/tools/clang/test/CodeCompletion/bracket-decl.c -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeCompletion/bracket-decl.c
    RUN("%clang_cc1 -fsyntax-only -code-completion-macros -code-completion-at=%s:6:12 %s -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_call_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeCompletion/call.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c89 -fsyntax-only "-code-completion-at=${LLVM_SRC}/llvm/tools/clang/test/CodeCompletion/call.c:6:6" ${LLVM_SRC}/llvm/tools/clang/test/CodeCompletion/call.c -o - | ${LLVM_SRC}/build/bin/FileCheck -check-prefix=CHECK-CC1 ${LLVM_SRC}/llvm/tools/clang/test/CodeCompletion/call.c
    RUN("%clang_cc1 -std=c89 -fsyntax-only  -code-completion-at=%s:6:6 %s -o -")./*|*/
      I("FileCheck -check-prefix=CHECK-CC1 %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c89 -fsyntax-only "-code-completion-at=${LLVM_SRC}/llvm/tools/clang/test/CodeCompletion/call.c:6:9" ${LLVM_SRC}/llvm/tools/clang/test/CodeCompletion/call.c -o - | ${LLVM_SRC}/build/bin/FileCheck -check-prefix=CHECK-CC2 ${LLVM_SRC}/llvm/tools/clang/test/CodeCompletion/call.c
    RUN("%clang_cc1 -std=c89 -fsyntax-only -code-completion-at=%s:6:9 %s -o -")./*|*/
      I("FileCheck -check-prefix=CHECK-CC2 %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c89 -fsyntax-only "-code-completion-at=${LLVM_SRC}/llvm/tools/clang/test/CodeCompletion/call.c:8:6" ${LLVM_SRC}/llvm/tools/clang/test/CodeCompletion/call.c -o - | ${LLVM_SRC}/build/bin/FileCheck -check-prefix=CHECK-CC3 ${LLVM_SRC}/llvm/tools/clang/test/CodeCompletion/call.c
    RUN("%clang_cc1 -std=c89 -fsyntax-only -code-completion-at=%s:8:6 %s -o -")./*|*/
      I("FileCheck -check-prefix=CHECK-CC3 %s");
  }

  @Test
  public void test_call_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeCompletion/call.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -code-completion-patterns "-code-completion-at=${LLVM_SRC}/llvm/tools/clang/test/CodeCompletion/call.cpp:19:9" ${LLVM_SRC}/llvm/tools/clang/test/CodeCompletion/call.cpp -o - | ${LLVM_SRC}/build/bin/FileCheck -check-prefix=CHECK-CC1 ${LLVM_SRC}/llvm/tools/clang/test/CodeCompletion/call.cpp
    RUN("%clang_cc1 -fsyntax-only -code-completion-patterns -code-completion-at=%s:19:9 %s -o -")./*|*/
      I("FileCheck -check-prefix=CHECK-CC1 %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only "-code-completion-at=${LLVM_SRC}/llvm/tools/clang/test/CodeCompletion/call.cpp:19:13" ${LLVM_SRC}/llvm/tools/clang/test/CodeCompletion/call.cpp -o - | ${LLVM_SRC}/build/bin/FileCheck -check-prefix=CHECK-CC2 ${LLVM_SRC}/llvm/tools/clang/test/CodeCompletion/call.cpp
    RUN("%clang_cc1 -fsyntax-only -code-completion-at=%s:19:13 %s -o -")./*|*/
      I("FileCheck -check-prefix=CHECK-CC2 %s");
  }

  @Test
  public void test_constexpr_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeCompletion/constexpr.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -std=c++11 "-code-completion-at=${LLVM_SRC}/llvm/tools/clang/test/CodeCompletion/constexpr.cpp:12:9" ${LLVM_SRC}/llvm/tools/clang/test/CodeCompletion/constexpr.cpp -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeCompletion/constexpr.cpp
    RUN("%clang_cc1 -fsyntax-only -std=c++11 -code-completion-at=%s:12:9 %s -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_ctor_initializer_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeCompletion/ctor-initializer.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only "-code-completion-at=${LLVM_SRC}/llvm/tools/clang/test/CodeCompletion/ctor-initializer.cpp:2:12" ${LLVM_SRC}/llvm/tools/clang/test/CodeCompletion/ctor-initializer.cpp -o - | ${LLVM_SRC}/build/bin/FileCheck -check-prefix=CHECK-CC1 ${LLVM_SRC}/llvm/tools/clang/test/CodeCompletion/ctor-initializer.cpp
    RUN("%clang_cc1 -fsyntax-only -code-completion-at=%s:2:12 %s -o -")./*|*/
      I("FileCheck -check-prefix=CHECK-CC1 %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only "-code-completion-at=${LLVM_SRC}/llvm/tools/clang/test/CodeCompletion/ctor-initializer.cpp:7:30" ${LLVM_SRC}/llvm/tools/clang/test/CodeCompletion/ctor-initializer.cpp -o - | ${LLVM_SRC}/build/bin/FileCheck -check-prefix=CHECK-CC2 ${LLVM_SRC}/llvm/tools/clang/test/CodeCompletion/ctor-initializer.cpp
    RUN("%clang_cc1 -fsyntax-only -code-completion-at=%s:7:30 %s -o -")./*|*/
      I("FileCheck -check-prefix=CHECK-CC2 %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only "-code-completion-at=${LLVM_SRC}/llvm/tools/clang/test/CodeCompletion/ctor-initializer.cpp:23:22" ${LLVM_SRC}/llvm/tools/clang/test/CodeCompletion/ctor-initializer.cpp -o - | ${LLVM_SRC}/build/bin/FileCheck -check-prefix=CHECK-CC3 ${LLVM_SRC}/llvm/tools/clang/test/CodeCompletion/ctor-initializer.cpp
    RUN("%clang_cc1 -fsyntax-only -code-completion-at=%s:23:22 %s -o -")./*|*/
      I("FileCheck -check-prefix=CHECK-CC3 %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only "-code-completion-at=${LLVM_SRC}/llvm/tools/clang/test/CodeCompletion/ctor-initializer.cpp:28:29" ${LLVM_SRC}/llvm/tools/clang/test/CodeCompletion/ctor-initializer.cpp -o - | ${LLVM_SRC}/build/bin/FileCheck -check-prefix=CHECK-CC4 ${LLVM_SRC}/llvm/tools/clang/test/CodeCompletion/ctor-initializer.cpp
    RUN("%clang_cc1 -fsyntax-only -code-completion-at=%s:28:29 %s -o -")./*|*/
      I("FileCheck -check-prefix=CHECK-CC4 %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only "-code-completion-at=${LLVM_SRC}/llvm/tools/clang/test/CodeCompletion/ctor-initializer.cpp:35:39" ${LLVM_SRC}/llvm/tools/clang/test/CodeCompletion/ctor-initializer.cpp -o - | ${LLVM_SRC}/build/bin/FileCheck -check-prefix=CHECK-CC5 ${LLVM_SRC}/llvm/tools/clang/test/CodeCompletion/ctor-initializer.cpp
    RUN("%clang_cc1 -fsyntax-only -code-completion-at=%s:35:39 %s -o -")./*|*/
      I("FileCheck -check-prefix=CHECK-CC5 %s");
  }

  @Test
  public void test_documentation_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeCompletion/documentation.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -code-completion-brief-comments "-code-completion-at=${LLVM_SRC}/llvm/tools/clang/test/CodeCompletion/documentation.cpp:21:1" ${LLVM_SRC}/llvm/tools/clang/test/CodeCompletion/documentation.cpp -o - | ${LLVM_SRC}/build/bin/FileCheck -check-prefix=CHECK-CC1 ${LLVM_SRC}/llvm/tools/clang/test/CodeCompletion/documentation.cpp
    RUN("%clang_cc1 -fsyntax-only -code-completion-brief-comments -code-completion-at=%s:21:1 %s -o -")./*|*/
      I("FileCheck -check-prefix=CHECK-CC1 %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -code-completion-brief-comments "-code-completion-at=${LLVM_SRC}/llvm/tools/clang/test/CodeCompletion/documentation.cpp:23:6" ${LLVM_SRC}/llvm/tools/clang/test/CodeCompletion/documentation.cpp -o - | ${LLVM_SRC}/build/bin/FileCheck -check-prefix=CHECK-CC2 ${LLVM_SRC}/llvm/tools/clang/test/CodeCompletion/documentation.cpp
    RUN("%clang_cc1 -fsyntax-only -code-completion-brief-comments -code-completion-at=%s:23:6 %s -o -")./*|*/
      I("FileCheck -check-prefix=CHECK-CC2 %s");
  }

  @Test
  public void test_documentation_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeCompletion/documentation.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -code-completion-brief-comments "-code-completion-at=${LLVM_SRC}/llvm/tools/clang/test/CodeCompletion/documentation.m:15:8" ${LLVM_SRC}/llvm/tools/clang/test/CodeCompletion/documentation.m -o - | ${LLVM_SRC}/build/bin/FileCheck -check-prefix=CHECK-CC1 ${LLVM_SRC}/llvm/tools/clang/test/CodeCompletion/documentation.m
    RUN("%clang_cc1 -fsyntax-only -code-completion-brief-comments -code-completion-at=%s:15:8 %s -o -")./*|*/
      I("FileCheck -check-prefix=CHECK-CC1 %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -code-completion-brief-comments "-code-completion-at=${LLVM_SRC}/llvm/tools/clang/test/CodeCompletion/documentation.m:16:9" ${LLVM_SRC}/llvm/tools/clang/test/CodeCompletion/documentation.m -o - | ${LLVM_SRC}/build/bin/FileCheck -check-prefix=CHECK-CC2 ${LLVM_SRC}/llvm/tools/clang/test/CodeCompletion/documentation.m
    RUN("%clang_cc1 -fsyntax-only -code-completion-brief-comments -code-completion-at=%s:16:9 %s -o -")./*|*/
      I("FileCheck -check-prefix=CHECK-CC2 %s");
  }

  @Test
  public void test_enum_switch_case_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeCompletion/enum-switch-case.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only "-code-completion-at=${LLVM_SRC}/llvm/tools/clang/test/CodeCompletion/enum-switch-case.c:19:10" ${LLVM_SRC}/llvm/tools/clang/test/CodeCompletion/enum-switch-case.c -o - | ${LLVM_SRC}/build/bin/FileCheck -check-prefix=CHECK-CC1 ${LLVM_SRC}/llvm/tools/clang/test/CodeCompletion/enum-switch-case.c
    RUN("%clang_cc1 -fsyntax-only -code-completion-at=%s:19:10 %s -o -")./*|*/
      I("FileCheck -check-prefix=CHECK-CC1 %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only "-code-completion-at=${LLVM_SRC}/llvm/tools/clang/test/CodeCompletion/enum-switch-case.c:25:10" ${LLVM_SRC}/llvm/tools/clang/test/CodeCompletion/enum-switch-case.c -o - | ${LLVM_SRC}/build/bin/FileCheck -check-prefix=CHECK-CC2 ${LLVM_SRC}/llvm/tools/clang/test/CodeCompletion/enum-switch-case.c
    RUN("%clang_cc1 -fsyntax-only -code-completion-at=%s:25:10 %s -o -")./*|*/
      I("FileCheck -check-prefix=CHECK-CC2 %s");
  }

  @Test
  public void test_enum_switch_case_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeCompletion/enum-switch-case.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only "-code-completion-at=${LLVM_SRC}/llvm/tools/clang/test/CodeCompletion/enum-switch-case.cpp:21:8" ${LLVM_SRC}/llvm/tools/clang/test/CodeCompletion/enum-switch-case.cpp -o - | ${LLVM_SRC}/build/bin/FileCheck -check-prefix=CHECK-CC1 ${LLVM_SRC}/llvm/tools/clang/test/CodeCompletion/enum-switch-case.cpp
    RUN("%clang_cc1 -fsyntax-only -code-completion-at=%s:21:8 %s -o -")./*|*/
      I("FileCheck -check-prefix=CHECK-CC1 %s");
  }

  @Test
  public void test_enum_switch_case_qualified_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeCompletion/enum-switch-case-qualified.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only "-code-completion-at=${LLVM_SRC}/llvm/tools/clang/test/CodeCompletion/enum-switch-case-qualified.cpp:23:8" ${LLVM_SRC}/llvm/tools/clang/test/CodeCompletion/enum-switch-case-qualified.cpp -o - | ${LLVM_SRC}/build/bin/FileCheck -check-prefix=CHECK-CC1 ${LLVM_SRC}/llvm/tools/clang/test/CodeCompletion/enum-switch-case-qualified.cpp
    RUN("%clang_cc1 -fsyntax-only -code-completion-at=%s:23:8 %s -o -")./*|*/
      I("FileCheck -check-prefix=CHECK-CC1 %s");
  }

  @Test
  public void test_function_templates_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeCompletion/function-templates.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only "-code-completion-at=${LLVM_SRC}/llvm/tools/clang/test/CodeCompletion/function-templates.cpp:15:8" ${LLVM_SRC}/llvm/tools/clang/test/CodeCompletion/function-templates.cpp -o - | ${LLVM_SRC}/build/bin/FileCheck -check-prefix=CHECK-CC1 ${LLVM_SRC}/llvm/tools/clang/test/CodeCompletion/function-templates.cpp
    RUN("%clang_cc1 -fsyntax-only -code-completion-at=%s:15:8 %s -o -")./*|*/
      I("FileCheck -check-prefix=CHECK-CC1 %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only "-code-completion-at=${LLVM_SRC}/llvm/tools/clang/test/CodeCompletion/function-templates.cpp:16:9" ${LLVM_SRC}/llvm/tools/clang/test/CodeCompletion/function-templates.cpp -o - | ${LLVM_SRC}/build/bin/FileCheck -check-prefix=CHECK-CC2 ${LLVM_SRC}/llvm/tools/clang/test/CodeCompletion/function-templates.cpp
    RUN("%clang_cc1 -fsyntax-only -code-completion-at=%s:16:9 %s -o -")./*|*/
      I("FileCheck -check-prefix=CHECK-CC2 %s");
  }

  @Test
  public void test_functions_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeCompletion/functions.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only "-code-completion-at=${LLVM_SRC}/llvm/tools/clang/test/CodeCompletion/functions.cpp:5:5" ${LLVM_SRC}/llvm/tools/clang/test/CodeCompletion/functions.cpp -o - | ${LLVM_SRC}/build/bin/FileCheck -check-prefix=CHECK-CC1 ${LLVM_SRC}/llvm/tools/clang/test/CodeCompletion/functions.cpp
    RUN("%clang_cc1 -fsyntax-only -code-completion-at=%s:5:5 %s -o -")./*|*/
      I("FileCheck -check-prefix=CHECK-CC1 %s");
  }

  @Test
  public void test_macros_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeCompletion/macros.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -include ${LLVM_SRC}/llvm/tools/clang/test/CodeCompletion/Inputs/macros.h -fsyntax-only -code-completion-macros "-code-completion-at=${LLVM_SRC}/llvm/tools/clang/test/CodeCompletion/macros.c:12:14" ${LLVM_SRC}/llvm/tools/clang/test/CodeCompletion/macros.c -o - | ${LLVM_SRC}/build/bin/FileCheck -check-prefix=CC1 ${LLVM_SRC}/llvm/tools/clang/test/CodeCompletion/macros.c
    RUN("%clang_cc1 -include %S/Inputs/macros.h -fsyntax-only -code-completion-macros -code-completion-at=%s:12:14 %s -o -")./*|*/
      I("FileCheck -check-prefix=CC1 %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -include ${LLVM_SRC}/llvm/tools/clang/test/CodeCompletion/Inputs/macros.h -fsyntax-only -code-completion-macros "-code-completion-at=${LLVM_SRC}/llvm/tools/clang/test/CodeCompletion/macros.c:14:9" ${LLVM_SRC}/llvm/tools/clang/test/CodeCompletion/macros.c -o - | ${LLVM_SRC}/build/bin/FileCheck -check-prefix=CC2 ${LLVM_SRC}/llvm/tools/clang/test/CodeCompletion/macros.c
    RUN("%clang_cc1 -include %S/Inputs/macros.h -fsyntax-only -code-completion-macros -code-completion-at=%s:14:9 %s -o -")./*|*/
      I("FileCheck -check-prefix=CC2 %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -include ${LLVM_SRC}/llvm/tools/clang/test/CodeCompletion/Inputs/macros.h -fsyntax-only -code-completion-macros "-code-completion-at=${LLVM_SRC}/llvm/tools/clang/test/CodeCompletion/macros.c:17:7" ${LLVM_SRC}/llvm/tools/clang/test/CodeCompletion/macros.c -o - | ${LLVM_SRC}/build/bin/FileCheck -check-prefix=CC3 ${LLVM_SRC}/llvm/tools/clang/test/CodeCompletion/macros.c
    RUN("%clang_cc1 -include %S/Inputs/macros.h -fsyntax-only -code-completion-macros -code-completion-at=%s:17:7 %s -o -")./*|*/
      I("FileCheck -check-prefix=CC3 %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-pch -o ${TEST_TEMP_DIR}/macros.c.tmp ${LLVM_SRC}/llvm/tools/clang/test/CodeCompletion/Inputs/macros.h
    RUN("%clang_cc1 -emit-pch -o %t %S/Inputs/macros.h");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -include-pch ${TEST_TEMP_DIR}/macros.c.tmp -fsyntax-only -code-completion-macros "-code-completion-at=${LLVM_SRC}/llvm/tools/clang/test/CodeCompletion/macros.c:12:14" ${LLVM_SRC}/llvm/tools/clang/test/CodeCompletion/macros.c -o - | ${LLVM_SRC}/build/bin/FileCheck -check-prefix=CC1 ${LLVM_SRC}/llvm/tools/clang/test/CodeCompletion/macros.c
    RUN("%clang_cc1 -include-pch %t -fsyntax-only -code-completion-macros -code-completion-at=%s:12:14 %s -o -")./*|*/
      I("FileCheck -check-prefix=CC1 %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -include-pch ${TEST_TEMP_DIR}/macros.c.tmp -fsyntax-only -code-completion-macros "-code-completion-at=${LLVM_SRC}/llvm/tools/clang/test/CodeCompletion/macros.c:14:9" ${LLVM_SRC}/llvm/tools/clang/test/CodeCompletion/macros.c -o - | ${LLVM_SRC}/build/bin/FileCheck -check-prefix=CC2 ${LLVM_SRC}/llvm/tools/clang/test/CodeCompletion/macros.c
    RUN("%clang_cc1 -include-pch %t -fsyntax-only -code-completion-macros -code-completion-at=%s:14:9 %s -o -")./*|*/
      I("FileCheck -check-prefix=CC2 %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -include-pch ${TEST_TEMP_DIR}/macros.c.tmp -fsyntax-only -code-completion-macros "-code-completion-at=${LLVM_SRC}/llvm/tools/clang/test/CodeCompletion/macros.c:17:7" ${LLVM_SRC}/llvm/tools/clang/test/CodeCompletion/macros.c -o - | ${LLVM_SRC}/build/bin/FileCheck -check-prefix=CC3 ${LLVM_SRC}/llvm/tools/clang/test/CodeCompletion/macros.c
    RUN("%clang_cc1 -include-pch %t -fsyntax-only -code-completion-macros -code-completion-at=%s:17:7 %s -o -")./*|*/
      I("FileCheck -check-prefix=CC3 %s");
  }

  @Test
  public void test_macros_in_modules_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeCompletion/macros-in-modules.c");
    // rm -rf ${TEST_TEMP_DIR}/macros-in-modules.c.tmp && mkdir ${TEST_TEMP_DIR}/macros-in-modules.c.tmp
    RUN("rm -rf %t");
    RUN("mkdir %t");
    // echo 'module Foo { header "foo.h" }' > ${TEST_TEMP_DIR}/macros-in-modules.c.tmp/module.modulemap
    RUN("echo 'module Foo { header \"foo.h\" }' > %t/module.modulemap");
    // echo '#define FOO_MACRO 42' > ${TEST_TEMP_DIR}/macros-in-modules.c.tmp/foo.h
    RUN("echo '#define FOO_MACRO 42' > %t/foo.h");
    // c-index-test "-code-completion-at=${LLVM_SRC}/llvm/tools/clang/test/CodeCompletion/macros-in-modules.c:9:1' -I ${TEST_TEMP_DIR}/macros-in-modules.c.tmp ${LLVM_SRC}/llvm/tools/clang/test/CodeCompletion/macros-in-modules.c | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeCompletion/macros-in-modules.c
    RUN("c-index-test -code-completion-at=%s:9:1 -I %t %s")./*|*/
      I("FileCheck %s");
    // c-index-test "-code-completion-at=${LLVM_SRC}/llvm/tools/clang/test/CodeCompletion/macros-in-modules.c:9:1' -I ${TEST_TEMP_DIR}/macros-in-modules.c.tmp -fmodules '-fmodules-cache-path=${TEST_TEMP_DIR}/macros-in-modules.c.tmp" ${LLVM_SRC}/llvm/tools/clang/test/CodeCompletion/macros-in-modules.c | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeCompletion/macros-in-modules.c
    RUN("c-index-test -code-completion-at=%s:9:1 -I %t -fmodules -fmodules-cache-path=%t %s")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_macros_in_modules_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeCompletion/macros-in-modules.m");
    // rm -rf ${TEST_TEMP_DIR}/macros-in-modules.m.tmp && mkdir ${TEST_TEMP_DIR}/macros-in-modules.m.tmp
    RUN("rm -rf %t");
    RUN("mkdir %t");
    // echo 'module Foo { header "foo.h" }' > ${TEST_TEMP_DIR}/macros-in-modules.m.tmp/module.modulemap
    RUN("echo 'module Foo { header \"foo.h\" }' > %t/module.modulemap");
    // echo '#define FOO_MACRO 42' > ${TEST_TEMP_DIR}/macros-in-modules.m.tmp/foo.h
    RUN("echo '#define FOO_MACRO 42' > %t/foo.h");
    // c-index-test "-code-completion-at=${LLVM_SRC}/llvm/tools/clang/test/CodeCompletion/macros-in-modules.m:8:1' -I ${TEST_TEMP_DIR}/macros-in-modules.m.tmp '-fmodules-cache-path=${TEST_TEMP_DIR}/macros-in-modules.m.tmp' -fmodules ${LLVM_SRC}/llvm/tools/clang/test/CodeCompletion/macros-in-modules.m | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeCompletion/macros-in-modules.m
    RUN("c-index-test -code-completion-at=%s:8:1 -I %t -fmodules-cache-path=%t -fmodules %s")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_member_access_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeCompletion/member-access.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only "-code-completion-at=${LLVM_SRC}/llvm/tools/clang/test/CodeCompletion/member-access.c:8:6" ${LLVM_SRC}/llvm/tools/clang/test/CodeCompletion/member-access.c -o - | ${LLVM_SRC}/build/bin/FileCheck -check-prefix=CHECK-CC1 ${LLVM_SRC}/llvm/tools/clang/test/CodeCompletion/member-access.c
    RUN("%clang_cc1 -fsyntax-only -code-completion-at=%s:8:6 %s -o -")./*|*/
      I("FileCheck -check-prefix=CHECK-CC1 %s");
  }

  @Test
  public void test_member_access_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeCompletion/member-access.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only "-code-completion-at=${LLVM_SRC}/llvm/tools/clang/test/CodeCompletion/member-access.cpp:29:6" ${LLVM_SRC}/llvm/tools/clang/test/CodeCompletion/member-access.cpp -o - | ${LLVM_SRC}/build/bin/FileCheck -check-prefix=CHECK-CC1 ${LLVM_SRC}/llvm/tools/clang/test/CodeCompletion/member-access.cpp
    RUN(TestState.Failed, "%clang_cc1 -fsyntax-only -code-completion-at=%s:29:6 %s -o -")./*|*/
      I("FileCheck -check-prefix=CHECK-CC1 %s");
  }

  @Test
  public void test_namespace_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeCompletion/namespace.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only "-code-completion-at=${LLVM_SRC}/llvm/tools/clang/test/CodeCompletion/namespace.cpp:10:12" ${LLVM_SRC}/llvm/tools/clang/test/CodeCompletion/namespace.cpp -o - | ${LLVM_SRC}/build/bin/FileCheck -check-prefix=CHECK-CC1 ${LLVM_SRC}/llvm/tools/clang/test/CodeCompletion/namespace.cpp
    RUN("%clang_cc1 -fsyntax-only -code-completion-at=%s:10:12 %s -o -")./*|*/
      I("FileCheck -check-prefix=CHECK-CC1 %s");
  }

  @Test
  public void test_namespace_alias_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeCompletion/namespace-alias.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only "-code-completion-at=${LLVM_SRC}/llvm/tools/clang/test/CodeCompletion/namespace-alias.cpp:13:18" ${LLVM_SRC}/llvm/tools/clang/test/CodeCompletion/namespace-alias.cpp -o - | ${LLVM_SRC}/build/bin/FileCheck -check-prefix=CHECK-CC1 ${LLVM_SRC}/llvm/tools/clang/test/CodeCompletion/namespace-alias.cpp
    RUN("%clang_cc1 -fsyntax-only -code-completion-at=%s:13:18 %s -o -")./*|*/
      I("FileCheck -check-prefix=CHECK-CC1 %s");
  }

  @Test
  public void test_nested_name_specifier_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeCompletion/nested-name-specifier.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only "-code-completion-at=${LLVM_SRC}/llvm/tools/clang/test/CodeCompletion/nested-name-specifier.cpp:12:4" ${LLVM_SRC}/llvm/tools/clang/test/CodeCompletion/nested-name-specifier.cpp -o - | ${LLVM_SRC}/build/bin/FileCheck -check-prefix=CHECK-CC1 ${LLVM_SRC}/llvm/tools/clang/test/CodeCompletion/nested-name-specifier.cpp
    RUN("%clang_cc1 -fsyntax-only -code-completion-at=%s:12:4 %s -o -")./*|*/
      I("FileCheck -check-prefix=CHECK-CC1 %s");
  }

  @Test
  public void test_objc_expr_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeCompletion/objc-expr.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -code-completion-patterns "-code-completion-at=${LLVM_SRC}/llvm/tools/clang/test/CodeCompletion/objc-expr.m:4:11" ${LLVM_SRC}/llvm/tools/clang/test/CodeCompletion/objc-expr.m -fno-const-strings -o - | ${LLVM_SRC}/build/bin/FileCheck -check-prefix=CHECK-AT ${LLVM_SRC}/llvm/tools/clang/test/CodeCompletion/objc-expr.m
    RUN("%clang_cc1 -fsyntax-only -code-completion-patterns -code-completion-at=%s:4:11 %s -fno-const-strings -o -")./*|*/
      I("FileCheck -check-prefix=CHECK-AT %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -code-completion-patterns "-code-completion-at=${LLVM_SRC}/llvm/tools/clang/test/CodeCompletion/objc-expr.m:4:11" ${LLVM_SRC}/llvm/tools/clang/test/CodeCompletion/objc-expr.m -fconst-strings -o - | ${LLVM_SRC}/build/bin/FileCheck -check-prefix=CHECK-CONST-STRINGS ${LLVM_SRC}/llvm/tools/clang/test/CodeCompletion/objc-expr.m
    RUN("%clang_cc1 -fsyntax-only -code-completion-patterns -code-completion-at=%s:4:11 %s -fconst-strings -o -")./*|*/
      I("FileCheck -check-prefix=CHECK-CONST-STRINGS %s");
  }

  @Test
  public void test_objc_message_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeCompletion/objc-message.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only "-code-completion-at=${LLVM_SRC}/llvm/tools/clang/test/CodeCompletion/objc-message.m:23:19" ${LLVM_SRC}/llvm/tools/clang/test/CodeCompletion/objc-message.m -o - | ${LLVM_SRC}/build/bin/FileCheck -check-prefix=CHECK-CC1 ${LLVM_SRC}/llvm/tools/clang/test/CodeCompletion/objc-message.m
    RUN("%clang_cc1 -fsyntax-only -code-completion-at=%s:23:19 %s -o -")./*|*/
      I("FileCheck -check-prefix=CHECK-CC1 %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only "-code-completion-at=${LLVM_SRC}/llvm/tools/clang/test/CodeCompletion/objc-message.m:24:8" ${LLVM_SRC}/llvm/tools/clang/test/CodeCompletion/objc-message.m -o - | ${LLVM_SRC}/build/bin/FileCheck -check-prefix=CHECK-CC2 ${LLVM_SRC}/llvm/tools/clang/test/CodeCompletion/objc-message.m
    RUN("%clang_cc1 -fsyntax-only -code-completion-at=%s:24:8 %s -o -")./*|*/
      I("FileCheck -check-prefix=CHECK-CC2 %s");
  }

  @Test
  public void test_objc_message_mm() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeCompletion/objc-message.mm");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -std=c++11 "-code-completion-at=${LLVM_SRC}/llvm/tools/clang/test/CodeCompletion/objc-message.mm:33:7" ${LLVM_SRC}/llvm/tools/clang/test/CodeCompletion/objc-message.mm -o - | ${LLVM_SRC}/build/bin/FileCheck -check-prefix=CHECK-CC1 ${LLVM_SRC}/llvm/tools/clang/test/CodeCompletion/objc-message.mm
    RUN("%clang_cc1 -fsyntax-only -std=c++11 -code-completion-at=%s:33:7 %s -o -")./*|*/
      I("FileCheck -check-prefix=CHECK-CC1 %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -std=c++11 "-code-completion-at=${LLVM_SRC}/llvm/tools/clang/test/CodeCompletion/objc-message.mm:38:7" ${LLVM_SRC}/llvm/tools/clang/test/CodeCompletion/objc-message.mm -o - | ${LLVM_SRC}/build/bin/FileCheck -check-prefix=CHECK-CC2 ${LLVM_SRC}/llvm/tools/clang/test/CodeCompletion/objc-message.mm
    RUN("%clang_cc1 -fsyntax-only -std=c++11 -code-completion-at=%s:38:7 %s -o -")./*|*/
      I("FileCheck -check-prefix=CHECK-CC2 %s");
  }

  @Test
  public void test_operator_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeCompletion/operator.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only "-code-completion-at=${LLVM_SRC}/llvm/tools/clang/test/CodeCompletion/operator.cpp:10:11" ${LLVM_SRC}/llvm/tools/clang/test/CodeCompletion/operator.cpp -o - | ${LLVM_SRC}/build/bin/FileCheck -check-prefix=CHECK-CC1 ${LLVM_SRC}/llvm/tools/clang/test/CodeCompletion/operator.cpp
    RUN("%clang_cc1 -fsyntax-only -code-completion-at=%s:10:11 %s -o -")./*|*/
      I("FileCheck -check-prefix=CHECK-CC1 %s");
  }

  @Test
  public void test_ordinary_name_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeCompletion/ordinary-name.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -isystem ${LLVM_SRC}/llvm/tools/clang/test/CodeCompletion/Inputs -fsyntax-only "-code-completion-at=${LLVM_SRC}/llvm/tools/clang/test/CodeCompletion/ordinary-name.c:6:9" ${LLVM_SRC}/llvm/tools/clang/test/CodeCompletion/ordinary-name.c -o - | ${LLVM_SRC}/build/bin/FileCheck -check-prefix=CHECK-CC1 ${LLVM_SRC}/llvm/tools/clang/test/CodeCompletion/ordinary-name.c
    RUN("%clang_cc1 -isystem %S/Inputs -fsyntax-only -code-completion-at=%s:6:9 %s -o -")./*|*/
      I("FileCheck -check-prefix=CHECK-CC1 %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -isystem ${LLVM_SRC}/llvm/tools/clang/test/CodeCompletion/Inputs -fsyntax-only "-code-completion-at=${LLVM_SRC}/llvm/tools/clang/test/CodeCompletion/ordinary-name.c:1:11" ${LLVM_SRC}/llvm/tools/clang/test/CodeCompletion/ordinary-name.c
    RUN("%clang_cc1 -isystem %S/Inputs -fsyntax-only -code-completion-at=%s:1:11 %s");
  }

  @Test
  public void test_ordinary_name_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeCompletion/ordinary-name.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -fcxx-exceptions -code-completion-patterns "-code-completion-at=${LLVM_SRC}/llvm/tools/clang/test/CodeCompletion/ordinary-name.cpp:6:14' -std=gnu++98 ${LLVM_SRC}/llvm/tools/clang/test/CodeCompletion/ordinary-name.cpp -o - | ${LLVM_SRC}/build/bin/FileCheck -check-prefix=CHECK-CC1 ${LLVM_SRC}/llvm/tools/clang/test/CodeCompletion/ordinary-name.cpp
    RUN(TestState.Failed, "%clang_cc1 -fsyntax-only -fcxx-exceptions -code-completion-patterns -code-completion-at=%s:6:14 -std=gnu++98 %s -o -")./*|*/
      I("FileCheck -check-prefix=CHECK-CC1 %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -code-completion-patterns "-code-completion-at=${LLVM_SRC}/llvm/tools/clang/test/CodeCompletion/ordinary-name.cpp:4:1' -std=gnu++98 ${LLVM_SRC}/llvm/tools/clang/test/CodeCompletion/ordinary-name.cpp -o - | ${LLVM_SRC}/build/bin/FileCheck -check-prefix=CHECK-CC2 ${LLVM_SRC}/llvm/tools/clang/test/CodeCompletion/ordinary-name.cpp
    RUN(TestState.Failed, "%clang_cc1 -fsyntax-only  -code-completion-patterns -code-completion-at=%s:4:1 -std=gnu++98 %s -o -")./*|*/
      I("FileCheck -check-prefix=CHECK-CC2 %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -code-completion-patterns "-code-completion-at=${LLVM_SRC}/llvm/tools/clang/test/CodeCompletion/ordinary-name.cpp:1:19' -std=gnu++98 ${LLVM_SRC}/llvm/tools/clang/test/CodeCompletion/ordinary-name.cpp -o - | ${LLVM_SRC}/build/bin/FileCheck -check-prefix=CHECK-CC3 ${LLVM_SRC}/llvm/tools/clang/test/CodeCompletion/ordinary-name.cpp
    RUN(TestState.Failed, "%clang_cc1 -fsyntax-only -code-completion-patterns -code-completion-at=%s:1:19 -std=gnu++98 %s -o -")./*|*/
      I("FileCheck -check-prefix=CHECK-CC3 %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -fcxx-exceptions -code-completion-patterns "-code-completion-at=${LLVM_SRC}/llvm/tools/clang/test/CodeCompletion/ordinary-name.cpp:6:11' -std=gnu++98 ${LLVM_SRC}/llvm/tools/clang/test/CodeCompletion/ordinary-name.cpp -o - | ${LLVM_SRC}/build/bin/FileCheck -check-prefix=CHECK-CC4 ${LLVM_SRC}/llvm/tools/clang/test/CodeCompletion/ordinary-name.cpp
    RUN(TestState.Failed, "%clang_cc1 -fsyntax-only -fcxx-exceptions -code-completion-patterns -code-completion-at=%s:6:11 -std=gnu++98 %s -o -")./*|*/
      I("FileCheck -check-prefix=CHECK-CC4 %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -fno-rtti -code-completion-patterns "-code-completion-at=${LLVM_SRC}/llvm/tools/clang/test/CodeCompletion/ordinary-name.cpp:6:14' -std=gnu++98 ${LLVM_SRC}/llvm/tools/clang/test/CodeCompletion/ordinary-name.cpp -o - | ${LLVM_SRC}/build/bin/FileCheck -check-prefix=CHECK-NO-RTTI ${LLVM_SRC}/llvm/tools/clang/test/CodeCompletion/ordinary-name.cpp
    RUN(TestState.Failed, "%clang_cc1 -fsyntax-only -fno-rtti -code-completion-patterns -code-completion-at=%s:6:14 -std=gnu++98 %s -o -")./*|*/
      I("FileCheck -check-prefix=CHECK-NO-RTTI %s");
  }

  @Test
  public void test_ordinary_name_cxx11_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeCompletion/ordinary-name-cxx11.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -fcxx-exceptions -code-completion-patterns "-code-completion-at=${LLVM_SRC}/llvm/tools/clang/test/CodeCompletion/ordinary-name-cxx11.cpp:6:14' -std=gnu++11 ${LLVM_SRC}/llvm/tools/clang/test/CodeCompletion/ordinary-name-cxx11.cpp -o - | ${LLVM_SRC}/build/bin/FileCheck -check-prefix=CHECK-CC1 ${LLVM_SRC}/llvm/tools/clang/test/CodeCompletion/ordinary-name-cxx11.cpp
    RUN(TestState.Failed, "%clang_cc1 -fsyntax-only -fcxx-exceptions -code-completion-patterns -code-completion-at=%s:6:14 -std=gnu++11 %s -o -")./*|*/
      I("FileCheck -check-prefix=CHECK-CC1 %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -code-completion-patterns "-code-completion-at=${LLVM_SRC}/llvm/tools/clang/test/CodeCompletion/ordinary-name-cxx11.cpp:4:1' -std=gnu++11 ${LLVM_SRC}/llvm/tools/clang/test/CodeCompletion/ordinary-name-cxx11.cpp -o - | ${LLVM_SRC}/build/bin/FileCheck -check-prefix=CHECK-CC2 ${LLVM_SRC}/llvm/tools/clang/test/CodeCompletion/ordinary-name-cxx11.cpp
    RUN(TestState.Failed, "%clang_cc1 -fsyntax-only  -code-completion-patterns -code-completion-at=%s:4:1 -std=gnu++11 %s -o -")./*|*/
      I("FileCheck -check-prefix=CHECK-CC2 %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -code-completion-patterns "-code-completion-at=${LLVM_SRC}/llvm/tools/clang/test/CodeCompletion/ordinary-name-cxx11.cpp:1:19' -std=gnu++11 ${LLVM_SRC}/llvm/tools/clang/test/CodeCompletion/ordinary-name-cxx11.cpp -o - | ${LLVM_SRC}/build/bin/FileCheck -check-prefix=CHECK-CC3 ${LLVM_SRC}/llvm/tools/clang/test/CodeCompletion/ordinary-name-cxx11.cpp
    RUN(TestState.Failed, "%clang_cc1 -fsyntax-only -code-completion-patterns -code-completion-at=%s:1:19 -std=gnu++11 %s -o -")./*|*/
      I("FileCheck -check-prefix=CHECK-CC3 %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -fcxx-exceptions -code-completion-patterns "-code-completion-at=${LLVM_SRC}/llvm/tools/clang/test/CodeCompletion/ordinary-name-cxx11.cpp:6:11' -std=gnu++11 ${LLVM_SRC}/llvm/tools/clang/test/CodeCompletion/ordinary-name-cxx11.cpp -o - | ${LLVM_SRC}/build/bin/FileCheck -check-prefix=CHECK-CC4 ${LLVM_SRC}/llvm/tools/clang/test/CodeCompletion/ordinary-name-cxx11.cpp
    RUN(TestState.Failed, "%clang_cc1 -fsyntax-only -fcxx-exceptions -code-completion-patterns -code-completion-at=%s:6:11 -std=gnu++11 %s -o -")./*|*/
      I("FileCheck -check-prefix=CHECK-CC4 %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -fno-rtti -code-completion-patterns "-code-completion-at=${LLVM_SRC}/llvm/tools/clang/test/CodeCompletion/ordinary-name-cxx11.cpp:6:14' -std=gnu++11 ${LLVM_SRC}/llvm/tools/clang/test/CodeCompletion/ordinary-name-cxx11.cpp -o - | ${LLVM_SRC}/build/bin/FileCheck -check-prefix=CHECK-NO-RTTI ${LLVM_SRC}/llvm/tools/clang/test/CodeCompletion/ordinary-name-cxx11.cpp
    RUN(TestState.Failed, "%clang_cc1 -fsyntax-only -fno-rtti -code-completion-patterns -code-completion-at=%s:6:14 -std=gnu++11 %s -o -")./*|*/
      I("FileCheck -check-prefix=CHECK-NO-RTTI %s");
  }

  @Test
  public void test_pch_and_module_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeCompletion/pch-and-module.m");
    // c-index-test "-code-completion-at=${LLVM_SRC}/llvm/tools/clang/test/CodeCompletion/pch-and-module.m:5:11" ${LLVM_SRC}/llvm/tools/clang/test/CodeCompletion/pch-and-module.m -I ${LLVM_SRC}/llvm/tools/clang/test/CodeCompletion/Inputs | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeCompletion/pch-and-module.m
    RUN("c-index-test -code-completion-at=%s:5:11 %s -I %S/Inputs")./*|*/
      I("FileCheck %s");
    // rm -rf ${TEST_TEMP_DIR}/pch-and-module.m.tmp && mkdir ${TEST_TEMP_DIR}/pch-and-module.m.tmp
    RUN("rm -rf %t");
    RUN("mkdir %t");
    // c-index-test "-code-completion-at=${LLVM_SRC}/llvm/tools/clang/test/CodeCompletion/pch-and-module.m:5:11" ${LLVM_SRC}/llvm/tools/clang/test/CodeCompletion/pch-and-module.m -I ${LLVM_SRC}/llvm/tools/clang/test/CodeCompletion/Inputs -fmodules '-fmodules-cache-path=${TEST_TEMP_DIR}/pch-and-module.m.tmp/mcp' | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeCompletion/pch-and-module.m
    RUN("c-index-test -code-completion-at=%s:5:11 %s -I %S/Inputs -fmodules -fmodules-cache-path=%t/mcp")./*|*/
      I("FileCheck %s");
    // rm -rf ${TEST_TEMP_DIR}/pch-and-module.m.tmp && mkdir ${TEST_TEMP_DIR}/pch-and-module.m.tmp
    RUN("rm -rf %t");
    RUN("mkdir %t");
    // c-index-test -write-pch ${TEST_TEMP_DIR}/pch-and-module.m.tmp/import_moduleA.pch -x objective-c-header ${LLVM_SRC}/llvm/tools/clang/test/CodeCompletion/Inputs/import_moduleA.h -I ${LLVM_SRC}/llvm/tools/clang/test/CodeCompletion/Inputs
    RUN("c-index-test -write-pch %t/import_moduleA.pch -x objective-c-header %S/Inputs/import_moduleA.h -I %S/Inputs");
    // c-index-test "-code-completion-at=${LLVM_SRC}/llvm/tools/clang/test/CodeCompletion/pch-and-module.m:5:11" ${LLVM_SRC}/llvm/tools/clang/test/CodeCompletion/pch-and-module.m -include-pch ${TEST_TEMP_DIR}/pch-and-module.m.tmp/import_moduleA.pch -I ${LLVM_SRC}/llvm/tools/clang/test/CodeCompletion/Inputs | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeCompletion/pch-and-module.m
    RUN("c-index-test -code-completion-at=%s:5:11 %s -include-pch %t/import_moduleA.pch -I %S/Inputs")./*|*/
      I("FileCheck %s");
    // rm -rf ${TEST_TEMP_DIR}/pch-and-module.m.tmp && mkdir ${TEST_TEMP_DIR}/pch-and-module.m.tmp
    RUN("rm -rf %t");
    RUN("mkdir %t");
    // c-index-test -write-pch ${TEST_TEMP_DIR}/pch-and-module.m.tmp/import_moduleA.pch -x objective-c-header ${LLVM_SRC}/llvm/tools/clang/test/CodeCompletion/Inputs/import_moduleA.h -fmodules '-fmodules-cache-path=${TEST_TEMP_DIR}/pch-and-module.m.tmp/mcp' -I ${LLVM_SRC}/llvm/tools/clang/test/CodeCompletion/Inputs
    RUN("c-index-test -write-pch %t/import_moduleA.pch -x objective-c-header %S/Inputs/import_moduleA.h -fmodules -fmodules-cache-path=%t/mcp -I %S/Inputs");
    // c-index-test "-code-completion-at=${LLVM_SRC}/llvm/tools/clang/test/CodeCompletion/pch-and-module.m:5:11" ${LLVM_SRC}/llvm/tools/clang/test/CodeCompletion/pch-and-module.m -include-pch ${TEST_TEMP_DIR}/pch-and-module.m.tmp/import_moduleA.pch -I ${LLVM_SRC}/llvm/tools/clang/test/CodeCompletion/Inputs -fmodules '-fmodules-cache-path=${TEST_TEMP_DIR}/pch-and-module.m.tmp/mcp' | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeCompletion/pch-and-module.m
    RUN("c-index-test -code-completion-at=%s:5:11 %s -include-pch %t/import_moduleA.pch -I %S/Inputs -fmodules -fmodules-cache-path=%t/mcp")./*|*/
      I("FileCheck %s");
    // rm -rf ${TEST_TEMP_DIR}/pch-and-module.m.tmp && mkdir ${TEST_TEMP_DIR}/pch-and-module.m.tmp
    RUN("rm -rf %t");
    RUN("mkdir %t");
    // env CINDEXTEST_EDITING=1 c-index-test "-code-completion-at=${LLVM_SRC}/llvm/tools/clang/test/CodeCompletion/pch-and-module.m:5:11" ${LLVM_SRC}/llvm/tools/clang/test/CodeCompletion/pch-and-module.m -I ${LLVM_SRC}/llvm/tools/clang/test/CodeCompletion/Inputs | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeCompletion/pch-and-module.m
    RUN("env CINDEXTEST_EDITING=1 c-index-test -code-completion-at=%s:5:11 %s -I %S/Inputs")./*|*/
      I("FileCheck %s");
    // rm -rf ${TEST_TEMP_DIR}/pch-and-module.m.tmp
    RUN("rm -rf %t");
    // env CINDEXTEST_EDITING=1 c-index-test "-code-completion-at=${LLVM_SRC}/llvm/tools/clang/test/CodeCompletion/pch-and-module.m:5:11" ${LLVM_SRC}/llvm/tools/clang/test/CodeCompletion/pch-and-module.m -I ${LLVM_SRC}/llvm/tools/clang/test/CodeCompletion/Inputs -fmodules '-fmodules-cache-path=${TEST_TEMP_DIR}/pch-and-module.m.tmp/mcp' | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeCompletion/pch-and-module.m
    RUN("env CINDEXTEST_EDITING=1 c-index-test -code-completion-at=%s:5:11 %s -I %S/Inputs -fmodules -fmodules-cache-path=%t/mcp")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_preamble_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeCompletion/preamble.c");
    // env CINDEXTEST_EDITING=1 c-index-test "-code-completion-at=${LLVM_SRC}/llvm/tools/clang/test/CodeCompletion/preamble.c:4:5' -Xclang -code-completion-patterns ${LLVM_SRC}/llvm/tools/clang/test/CodeCompletion/preamble.c | ${LLVM_SRC}/build/bin/FileCheck -check-prefix=CHECK-CC1 ${LLVM_SRC}/llvm/tools/clang/test/CodeCompletion/preamble.c
    RUN("env CINDEXTEST_EDITING=1 c-index-test -code-completion-at=%s:4:5 -Xclang -code-completion-patterns  %s")./*|*/
      I("FileCheck -check-prefix=CHECK-CC1 %s");
  }

  @Test
  public void test_stdin_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeCompletion/stdin.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -code-completion-at=-:4:6 < ${LLVM_SRC}/llvm/tools/clang/test/CodeCompletion/stdin.c -o - | ${LLVM_SRC}/build/bin/FileCheck -check-prefix=CHECK-CC1 ${LLVM_SRC}/llvm/tools/clang/test/CodeCompletion/stdin.c
    RUN("%clang_cc1 -fsyntax-only -code-completion-at=-:4:6 < %s -o -")./*|*/
      I("FileCheck -check-prefix=CHECK-CC1 %s");
  }

  @Test
  public void test_tag_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeCompletion/tag.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only "-code-completion-at=${LLVM_SRC}/llvm/tools/clang/test/CodeCompletion/tag.c:9:7" ${LLVM_SRC}/llvm/tools/clang/test/CodeCompletion/tag.c -o - | ${LLVM_SRC}/build/bin/FileCheck -check-prefix=CHECK-CC1 ${LLVM_SRC}/llvm/tools/clang/test/CodeCompletion/tag.c
    RUN("%clang_cc1 -fsyntax-only -code-completion-at=%s:9:7 %s -o -")./*|*/
      I("FileCheck -check-prefix=CHECK-CC1 %s");
  }

  @Test
  public void test_tag_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeCompletion/tag.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only "-code-completion-at=${LLVM_SRC}/llvm/tools/clang/test/CodeCompletion/tag.cpp:17:10" ${LLVM_SRC}/llvm/tools/clang/test/CodeCompletion/tag.cpp -o - | ${LLVM_SRC}/build/bin/FileCheck -check-prefix=CHECK-CC1 ${LLVM_SRC}/llvm/tools/clang/test/CodeCompletion/tag.cpp
    RUN("%clang_cc1 -fsyntax-only -code-completion-at=%s:17:10 %s -o -")./*|*/
      I("FileCheck -check-prefix=CHECK-CC1 %s");
  }

  @Test
  public void test_templates_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeCompletion/templates.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only "-code-completion-at=${LLVM_SRC}/llvm/tools/clang/test/CodeCompletion/templates.cpp:18:8" ${LLVM_SRC}/llvm/tools/clang/test/CodeCompletion/templates.cpp -o - | ${LLVM_SRC}/build/bin/FileCheck -check-prefix=CHECK-CC1 ${LLVM_SRC}/llvm/tools/clang/test/CodeCompletion/templates.cpp
    RUN("%clang_cc1 -fsyntax-only -code-completion-at=%s:18:8 %s -o -")./*|*/
      I("FileCheck -check-prefix=CHECK-CC1 %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only "-code-completion-at=${LLVM_SRC}/llvm/tools/clang/test/CodeCompletion/templates.cpp:19:5" ${LLVM_SRC}/llvm/tools/clang/test/CodeCompletion/templates.cpp -o - | ${LLVM_SRC}/build/bin/FileCheck -check-prefix=CHECK-CC2 ${LLVM_SRC}/llvm/tools/clang/test/CodeCompletion/templates.cpp
    RUN("%clang_cc1 -fsyntax-only -code-completion-at=%s:19:5 %s -o -")./*|*/
      I("FileCheck -check-prefix=CHECK-CC2 %s");
  }

  @Test
  public void test_truncation_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeCompletion/truncation.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only "-code-completion-at=${LLVM_SRC}/llvm/tools/clang/test/CodeCompletion/truncation.c.h:4:8' -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeCompletion/truncation.c | ${LLVM_SRC}/build/bin/FileCheck -check-prefix=CHECK-CC1 ${LLVM_SRC}/llvm/tools/clang/test/CodeCompletion/truncation.c
    RUN(TestState.Failed, "%clang_cc1 -fsyntax-only -code-completion-at=%s.h:4:8 -o - %s")./*|*/
      I("FileCheck -check-prefix=CHECK-CC1 %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only "-code-completion-at=${LLVM_SRC}/llvm/tools/clang/test/CodeCompletion/truncation.c:5:8' -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeCompletion/truncation.c | ${LLVM_SRC}/build/bin/FileCheck -check-prefix=CHECK-CC2 ${LLVM_SRC}/llvm/tools/clang/test/CodeCompletion/truncation.c
    RUN(TestState.Failed, "%clang_cc1 -fsyntax-only -code-completion-at=%s:5:8 -o - %s")./*|*/
      I("FileCheck -check-prefix=CHECK-CC2 %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only "-code-completion-at=${LLVM_SRC}/llvm/tools/clang/test/CodeCompletion/truncation.c:3:3' -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeCompletion/truncation.c
    RUN(TestState.Failed, "%clang_cc1 -fsyntax-only -code-completion-at=%s:3:3 -o - %s");
  }

  @Test
  public void test_using_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeCompletion/using.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only "-code-completion-at=${LLVM_SRC}/llvm/tools/clang/test/CodeCompletion/using.cpp:16:10" ${LLVM_SRC}/llvm/tools/clang/test/CodeCompletion/using.cpp -o - | ${LLVM_SRC}/build/bin/FileCheck -check-prefix=CHECK-CC1 ${LLVM_SRC}/llvm/tools/clang/test/CodeCompletion/using.cpp
    RUN("%clang_cc1 -fsyntax-only -code-completion-at=%s:16:10 %s -o -")./*|*/
      I("FileCheck -check-prefix=CHECK-CC1 %s");
  }

  @Test
  public void test_using_namespace_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeCompletion/using-namespace.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only "-code-completion-at=${LLVM_SRC}/llvm/tools/clang/test/CodeCompletion/using-namespace.cpp:14:20" ${LLVM_SRC}/llvm/tools/clang/test/CodeCompletion/using-namespace.cpp -o - | ${LLVM_SRC}/build/bin/FileCheck -check-prefix=CHECK-CC1 ${LLVM_SRC}/llvm/tools/clang/test/CodeCompletion/using-namespace.cpp
    RUN("%clang_cc1 -fsyntax-only -code-completion-at=%s:14:20 %s -o -")./*|*/
      I("FileCheck -check-prefix=CHECK-CC1 %s");
  }
  
}
