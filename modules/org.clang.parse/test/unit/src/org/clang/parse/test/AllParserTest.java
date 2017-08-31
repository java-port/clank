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

package org.clang.parse.test;

import org.clang.tools.driver.test.DriverTestFileBase;
import org.junit.*;

/**
 * Collection of all test files from test/Parser folder
 * @author Vladimir Voskresensky
 */
public class AllParserTest extends DriverTestFileBase {
  private static final String TEST_LOCATION = "${LLVM_SRC}/llvm/tools/clang/test/Parser/";
  public AllParserTest() {
    super(TEST_LOCATION, TestState.Successful);
  }
  
  public static void main(String[] args) {
    // Print tests which will be accepted per test case
    DriverTestFileBase.printAllTestFiles(false, TEST_LOCATION, (test)->true, 
            "${SPUTNIK}/modules/org.clang.parse/test/unit/src/org/clang/parse/test/AllParserTest.txt");
  }  
  
  @Override
  protected boolean keepStacksForUnimplementedMethods() {
    return false;
  }
  
  @Test
  public void test_CompoundStmtScope_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Parser/CompoundStmtScope.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/Parser/CompoundStmtScope.c
    RUN("%clang_cc1 -fsyntax-only -verify %s");
  }

  @Test
  public void test_DelayedTemplateParsing_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Parser/DelayedTemplateParsing.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fms-extensions -fdelayed-template-parsing -fsyntax-only -verify -std=c++11 ${LLVM_SRC}/llvm/tools/clang/test/Parser/DelayedTemplateParsing.cpp
    RUN("%clang_cc1 -fms-extensions -fdelayed-template-parsing -fsyntax-only -verify -std=c++11 %s");
  }

  @Test
  public void test_MicrosoftExtensions_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Parser/MicrosoftExtensions.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i386-mingw32 -fsyntax-only -Wno-missing-declarations -verify -fms-extensions ${LLVM_SRC}/llvm/tools/clang/test/Parser/MicrosoftExtensions.c
    RUN("%clang_cc1 -triple i386-mingw32 -fsyntax-only -Wno-missing-declarations -verify -fms-extensions  %s");
  }

  @Test
  public void test_MicrosoftExtensions_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Parser/MicrosoftExtensions.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/Parser/MicrosoftExtensions.cpp -triple i386-pc-win32 -std=c++14 -fsyntax-only -Wno-unused-getter-return-value -Wno-unused-value -Wmicrosoft -verify -fms-extensions -fms-compatibility -fdelayed-template-parsing
    RUN("%clang_cc1 %s -triple i386-pc-win32 -std=c++14 -fsyntax-only -Wno-unused-getter-return-value -Wno-unused-value -Wmicrosoft -verify -fms-extensions -fms-compatibility -fdelayed-template-parsing");
  }

  @Test
  public void test_MicrosoftExtensionsInlineAsm_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Parser/MicrosoftExtensionsInlineAsm.c");
    // REQUIRES: x86-registered-target
    if (!CHECK_REQUIRES("x86-registered-target")) {
      return;
    }
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i386-mingw32 -fsyntax-only -verify -fms-extensions ${LLVM_SRC}/llvm/tools/clang/test/Parser/MicrosoftExtensionsInlineAsm.c
    RUN(TestState.Failed, "%clang_cc1 -triple i386-mingw32 -fsyntax-only -verify -fms-extensions  %s");
  }

  @Test
  public void test_PR11000_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Parser/PR11000.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c++11 ${LLVM_SRC}/llvm/tools/clang/test/Parser/PR11000.cpp 2>&1 | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Parser/PR11000.cpp
    RUN("not %clang_cc1 -std=c++11 %s 2>&1")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_PR21872_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Parser/PR21872.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only ${LLVM_SRC}/llvm/tools/clang/test/Parser/PR21872.cpp
    RUN("not %clang_cc1 -fsyntax-only %s");
  }

  @Test
  public void test_access_spec_attrs_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Parser/access-spec-attrs.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/Parser/access-spec-attrs.cpp -fsyntax-only -verify
    RUN("%clang_cc1 %s -fsyntax-only -verify");
  }

  @Test
  public void test_altivec_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Parser/altivec.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple=powerpc-apple-darwin8 -faltivec -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/Parser/altivec.c
    RUN("%clang_cc1 -triple=powerpc-apple-darwin8 -faltivec -fsyntax-only -verify %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple=powerpc64-unknown-linux-gnu -faltivec -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/Parser/altivec.c
    RUN("%clang_cc1 -triple=powerpc64-unknown-linux-gnu -faltivec -fsyntax-only -verify %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple=powerpc64le-unknown-linux-gnu -faltivec -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/Parser/altivec.c
    RUN("%clang_cc1 -triple=powerpc64le-unknown-linux-gnu -faltivec -fsyntax-only -verify %s");
  }

  @Test
  public void test_altivec_csk_bool_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Parser/altivec-csk-bool.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple powerpc64-unknown-linux-gnu -faltivec -fsyntax-only ${LLVM_SRC}/llvm/tools/clang/test/Parser/altivec-csk-bool.c
    RUN("%clang_cc1 -triple powerpc64-unknown-linux-gnu -faltivec -fsyntax-only %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple powerpc64le-unknown-linux-gnu -faltivec -fsyntax-only ${LLVM_SRC}/llvm/tools/clang/test/Parser/altivec-csk-bool.c
    RUN("%clang_cc1 -triple powerpc64le-unknown-linux-gnu -faltivec -fsyntax-only %s");
  }

  @Test
  public void test_annotation_token_in_lexed_body_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Parser/annotation-token-in-lexed-body.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/Parser/annotation-token-in-lexed-body.cpp
    RUN("%clang_cc1 -fsyntax-only -verify %s");
  }

  @Test
  public void test_argument_qualified_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Parser/argument_qualified.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/Parser/argument_qualified.c
    RUN("%clang_cc1 %s");
  }

  @Test
  public void test_argument_redef_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Parser/argument_redef.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/Parser/argument_redef.c
    RUN("%clang_cc1 -fsyntax-only -verify %s");
  }

  @Test
  public void test_argument_scope_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Parser/argument_scope.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only ${LLVM_SRC}/llvm/tools/clang/test/Parser/argument_scope.c
    RUN("%clang_cc1 -fsyntax-only %s");
  }

  @Test
  public void test_arm_windows_calling_convention_handling_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Parser/arm-windows-calling-convention-handling.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple thumbv7-windows -fms-compatibility -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/Parser/arm-windows-calling-convention-handling.c
    RUN("%clang_cc1 -triple thumbv7-windows -fms-compatibility -fsyntax-only -verify %s");
  }

  @Test
  public void test_asm_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Parser/asm.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/Parser/asm.c
    RUN(TestState.Failed, "%clang_cc1 -fsyntax-only -verify %s");
  }

  @Test
  public void test_asm_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Parser/asm.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -std=c++11 ${LLVM_SRC}/llvm/tools/clang/test/Parser/asm.cpp
    RUN("%clang_cc1 -fsyntax-only -verify -std=c++11 %s");
  }

  @Test
  public void test_asm_constraints_pr7869_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Parser/asm-constraints-pr7869.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/Parser/asm-constraints-pr7869.c
    RUN("%clang_cc1 %s");
  }

  @Test
  public void test_atomic_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Parser/atomic.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c11 ${LLVM_SRC}/llvm/tools/clang/test/Parser/atomic.c -fsyntax-only -verify -pedantic
    RUN("%clang_cc1 -std=c11 %s -fsyntax-only -verify -pedantic");
  }

  @Test
  public void test_attr_availability_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Parser/attr-availability.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/Parser/attr-availability.c
    RUN("%clang_cc1 -fsyntax-only -verify %s");
  }

  @Test
  public void test_attributes_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Parser/attributes.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/Parser/attributes.c -pedantic -std=c99
    RUN("%clang_cc1 -fsyntax-only -verify %s -pedantic -std=c99");
  }

  @Test
  public void test_attributes_mm() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Parser/attributes.mm");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -verify -fsyntax-only -Wno-objc-root-class ${LLVM_SRC}/llvm/tools/clang/test/Parser/attributes.mm
    RUN("%clang_cc1 -verify -fsyntax-only -Wno-objc-root-class %s");
  }

  @Test
  public void test_backtrack_crash_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Parser/backtrack-crash.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/Parser/backtrack-crash.cpp -fsyntax-only -verify -pedantic
    RUN("%clang_cc1 %s -fsyntax-only -verify -pedantic");
  }

  @Test
  public void test_bad_control_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Parser/bad-control.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/Parser/bad-control.c
    RUN("%clang_cc1 -fsyntax-only -verify %s");
  }

  @Test
  public void test_block_block_storageclass_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Parser/block-block-storageclass.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -fblocks -verify ${LLVM_SRC}/llvm/tools/clang/test/Parser/block-block-storageclass.c
    RUN("%clang_cc1 -fsyntax-only -fblocks -verify %s");
  }

  @Test
  public void test_block_pointer_decl_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Parser/block-pointer-decl.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -fblocks ${LLVM_SRC}/llvm/tools/clang/test/Parser/block-pointer-decl.c
    RUN("%clang_cc1 -fsyntax-only -verify -fblocks %s");
  }

  @Test
  public void test_bracket_crash_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Parser/bracket-crash.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -std=c++11 ${LLVM_SRC}/llvm/tools/clang/test/Parser/bracket-crash.cpp
    RUN("not %clang_cc1 -fsyntax-only -std=c++11 %s");
  }

  @Test
  public void test_brackets_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Parser/brackets.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/Parser/brackets.c
    RUN("%clang_cc1 -fsyntax-only -verify %s");
    // cp ${LLVM_SRC}/llvm/tools/clang/test/Parser/brackets.c ${TEST_TEMP_DIR}/brackets.c.tmp
    RUN("cp %s %t");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fixit ${TEST_TEMP_DIR}/brackets.c.tmp -x c -DFIXIT
    RUN("not %clang_cc1 -fixit %t -x c -DFIXIT");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only ${TEST_TEMP_DIR}/brackets.c.tmp -x c -DFIXIT
    RUN("%clang_cc1 -fsyntax-only %t -x c -DFIXIT");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -fdiagnostics-parseable-fixits ${LLVM_SRC}/llvm/tools/clang/test/Parser/brackets.c 2>&1 | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Parser/brackets.c -strict-whitespace
    RUN("not %clang_cc1 -fsyntax-only -fdiagnostics-parseable-fixits %s 2>&1")./*|*/
      I("FileCheck %s -strict-whitespace");
  }

  @Test
  public void test_brackets_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Parser/brackets.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/Parser/brackets.cpp
    RUN("%clang_cc1 -fsyntax-only -verify %s");
    // cp ${LLVM_SRC}/llvm/tools/clang/test/Parser/brackets.cpp ${TEST_TEMP_DIR}/brackets.cpp.tmp
    RUN("cp %s %t");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fixit ${TEST_TEMP_DIR}/brackets.cpp.tmp -x c++ -DFIXIT
    RUN("not %clang_cc1 -fixit %t -x c++ -DFIXIT");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only ${TEST_TEMP_DIR}/brackets.cpp.tmp -x c++ -DFIXIT
    RUN("%clang_cc1 -fsyntax-only %t -x c++ -DFIXIT");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -fdiagnostics-parseable-fixits ${LLVM_SRC}/llvm/tools/clang/test/Parser/brackets.cpp 2>&1 | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Parser/brackets.cpp -strict-whitespace
    RUN("not %clang_cc1 -fsyntax-only -fdiagnostics-parseable-fixits %s 2>&1")./*|*/
      I("FileCheck %s -strict-whitespace");
  }

  @Test
  public void test_builtin_classify_type_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Parser/builtin_classify_type.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/Parser/builtin_classify_type.c
    RUN("%clang_cc1 -fsyntax-only -verify %s");
  }

  @Test
  public void test_builtin_types_compatible_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Parser/builtin_types_compatible.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/Parser/builtin_types_compatible.c
    RUN("%clang_cc1 -fsyntax-only -verify %s");
  }

  @Test
  public void test_c_namespace_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Parser/c-namespace.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only ${LLVM_SRC}/llvm/tools/clang/test/Parser/c-namespace.c
    RUN("%clang_cc1 -fsyntax-only %s");
  }

  @Test
  public void test_c11_noreturn_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Parser/c11-noreturn.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c11 -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/Parser/c11-noreturn.c
    RUN("%clang_cc1 -std=c11 -fsyntax-only -verify %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c99 -pedantic -fsyntax-only ${LLVM_SRC}/llvm/tools/clang/test/Parser/c11-noreturn.c 2>&1 | ${LLVM_SRC}/build/bin/FileCheck -check-prefix=CHECK-EXT ${LLVM_SRC}/llvm/tools/clang/test/Parser/c11-noreturn.c
    RUN("not %clang_cc1 -std=c99 -pedantic -fsyntax-only %s 2>&1")./*|*/
      I("FileCheck -check-prefix=CHECK-EXT %s");
  }

  @Test
  public void test_c1x_alignas_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Parser/c1x-alignas.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c11 -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/Parser/c1x-alignas.c
    RUN("%clang_cc1 -std=c11 -fsyntax-only -verify %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c99 -pedantic -fsyntax-only ${LLVM_SRC}/llvm/tools/clang/test/Parser/c1x-alignas.c 2>&1 | ${LLVM_SRC}/build/bin/FileCheck -check-prefix=CHECK-EXT ${LLVM_SRC}/llvm/tools/clang/test/Parser/c1x-alignas.c
    RUN("not %clang_cc1 -std=c99 -pedantic -fsyntax-only %s 2>&1")./*|*/
      I("FileCheck -check-prefix=CHECK-EXT %s");
  }

  @Test
  public void test_c1x_generic_selection_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Parser/c1x-generic-selection.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c1x -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/Parser/c1x-generic-selection.c
    RUN("%clang_cc1 -std=c1x -fsyntax-only -verify %s");
  }

  @Test
  public void test_captured_statements_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Parser/captured-statements.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -verify ${LLVM_SRC}/llvm/tools/clang/test/Parser/captured-statements.c
    RUN("%clang_cc1 -verify %s");
  }

  @Test
  public void test_char_literal_printing_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Parser/char-literal-printing.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -ast-print ${LLVM_SRC}/llvm/tools/clang/test/Parser/char-literal-printing.c
    RUN("%clang_cc1 -ast-print %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x c++ -ast-print ${LLVM_SRC}/llvm/tools/clang/test/Parser/char-literal-printing.c
    RUN("%clang_cc1 -x c++ -ast-print %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x c++ -std=c++11 -ast-print ${LLVM_SRC}/llvm/tools/clang/test/Parser/char-literal-printing.c
    RUN("%clang_cc1 -x c++ -std=c++11 -ast-print %s");
  }

  @Test
  public void test_check_objc2_syntax_1_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Parser/check-objc2-syntax-1.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/Parser/check-objc2-syntax-1.m
    RUN("%clang_cc1 -fsyntax-only -verify %s");
  }

  @Test // ObjCInterfaceTypeLoc recursion in getFullSize
  public void test_check_syntax_1_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Parser/check-syntax-1.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/Parser/check-syntax-1.m
    RUN("%clang_cc1 -fsyntax-only -verify %s");
  }

  @Test
  public void test_check_cast_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Parser/check_cast.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/Parser/check_cast.c
    RUN("%clang_cc1 -fsyntax-only -verify %s");
  }

  @Test
  public void test_colon_colon_parentheses_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Parser/colon-colon-parentheses.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/Parser/colon-colon-parentheses.cpp -fsyntax-only -verify -DPR21815
    RUN("%clang_cc1 %s -fsyntax-only -verify -DPR21815");
    // cp ${LLVM_SRC}/llvm/tools/clang/test/Parser/colon-colon-parentheses.cpp ${TEST_TEMP_DIR}/colon-colon-parentheses.cpp.tmp
    RUN("cp %s %t");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x c++ -fixit ${TEST_TEMP_DIR}/colon-colon-parentheses.cpp.tmp
    RUN("not %clang_cc1 -x c++ -fixit %t");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x c++ ${TEST_TEMP_DIR}/colon-colon-parentheses.cpp.tmp
    RUN("%clang_cc1 -x c++ %t");
  }

  @Test
  public void test_compound_literal_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Parser/compound_literal.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/Parser/compound_literal.c
    RUN("%clang_cc1 -fsyntax-only -verify %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -x c++ ${LLVM_SRC}/llvm/tools/clang/test/Parser/compound_literal.c
    RUN("%clang_cc1 -fsyntax-only -verify -x c++ %s");
  }

  @Test
  public void test_control_scope_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Parser/control-scope.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/Parser/control-scope.c -std=c90 -verify
    RUN("%clang_cc1 %s -std=c90 -verify");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/Parser/control-scope.c -std=c99
    RUN("%clang_cc1 %s -std=c99");
  }

  @Ignore @Test
  public void test_crash_report_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Parser/crash-report.c");
    // REQUIRES: crash-recovery
    if (!CHECK_REQUIRES("crash-recovery")) {
      return;
    }
    // REQUIRES: shell, backtrace
    if (!CHECK_REQUIRES("shell, backtrace")) {
      return;
    }
    // --crash ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/Parser/crash-report.c 2>&1 | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Parser/crash-report.c
    RUN(TestState.Failed, "not --crash %clang_cc1 %s 2>&1")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_cuda_kernel_call_cu() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Parser/cuda-kernel-call.cu");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/Parser/cuda-kernel-call.cu
    RUN("%clang_cc1 -fsyntax-only -verify %s");
  }

  @Test
  public void test_cuda_kernel_call_cxx11_cu() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Parser/cuda-kernel-call-c++11.cu");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -std=c++11 -verify ${LLVM_SRC}/llvm/tools/clang/test/Parser/cuda-kernel-call-c++11.cu
    RUN("%clang_cc1 -fsyntax-only -std=c++11 -verify %s");
  }

  @Test
  public void test_cxx_altivec_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Parser/cxx-altivec.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple=powerpc-apple-darwin8 -faltivec -fsyntax-only -verify -std=c++11 ${LLVM_SRC}/llvm/tools/clang/test/Parser/cxx-altivec.cpp
    RUN("%clang_cc1 -triple=powerpc-apple-darwin8 -faltivec -fsyntax-only -verify -std=c++11 %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple=powerpc64-unknown-linux-gnu -faltivec -fsyntax-only -verify -std=c++11 ${LLVM_SRC}/llvm/tools/clang/test/Parser/cxx-altivec.cpp
    RUN("%clang_cc1 -triple=powerpc64-unknown-linux-gnu -faltivec -fsyntax-only -verify -std=c++11 %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple=powerpc64le-unknown-linux-gnu -faltivec -fsyntax-only -verify -std=c++11 ${LLVM_SRC}/llvm/tools/clang/test/Parser/cxx-altivec.cpp
    RUN("%clang_cc1 -triple=powerpc64le-unknown-linux-gnu -faltivec -fsyntax-only -verify -std=c++11 %s");
  }

  @Test
  public void test_cxx_ambig_decl_expr_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Parser/cxx-ambig-decl-expr.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/Parser/cxx-ambig-decl-expr.cpp
    RUN("%clang_cc1 -fsyntax-only -verify %s");
  }

  @Test
  public void test_cxx_ambig_decl_expr_xfail_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Parser/cxx-ambig-decl-expr-xfail.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/Parser/cxx-ambig-decl-expr-xfail.cpp
    RUN(TestState.Failed, "%clang_cc1 -fsyntax-only -verify %s");
  }

  @Test
  public void test_cxx_ambig_init_templ_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Parser/cxx-ambig-init-templ.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -Wno-uninitialized -std=c++11 -verify ${LLVM_SRC}/llvm/tools/clang/test/Parser/cxx-ambig-init-templ.cpp
    RUN("%clang_cc1 -Wno-uninitialized -std=c++11 -verify %s");
  }

  @Test
  public void test_cxx_ambig_paren_expr_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Parser/cxx-ambig-paren-expr.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -pedantic -verify ${LLVM_SRC}/llvm/tools/clang/test/Parser/cxx-ambig-paren-expr.cpp
    RUN("%clang_cc1 -fsyntax-only -pedantic -verify %s");
  }

  @Test
  public void test_cxx_ambig_paren_expr_asan_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Parser/cxx-ambig-paren-expr-asan.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -pedantic -verify ${LLVM_SRC}/llvm/tools/clang/test/Parser/cxx-ambig-paren-expr-asan.cpp
    RUN("%clang_cc1 -fsyntax-only -pedantic -verify %s");
  }

  @Test
  public void test_cxx_attributes_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Parser/cxx-attributes.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/Parser/cxx-attributes.cpp
    RUN("%clang_cc1 -fsyntax-only -verify %s");
  }

  @Test
  public void test_cxx_bool_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Parser/cxx-bool.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only ${LLVM_SRC}/llvm/tools/clang/test/Parser/cxx-bool.cpp
    RUN("%clang_cc1 -fsyntax-only %s");
  }

  @Test
  public void test_cxx_casting_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Parser/cxx-casting.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/Parser/cxx-casting.cpp
    RUN("%clang_cc1 -fsyntax-only -verify %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -std=c++98 ${LLVM_SRC}/llvm/tools/clang/test/Parser/cxx-casting.cpp
    RUN("%clang_cc1 -fsyntax-only -verify -std=c++98 %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -std=c++11 ${LLVM_SRC}/llvm/tools/clang/test/Parser/cxx-casting.cpp
    RUN("%clang_cc1 -fsyntax-only -verify -std=c++11 %s");
  }

  @Test
  public void test_cxx_class_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Parser/cxx-class.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -pedantic -fcxx-exceptions ${LLVM_SRC}/llvm/tools/clang/test/Parser/cxx-class.cpp
    RUN("%clang_cc1 -fsyntax-only -verify -pedantic -fcxx-exceptions %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -pedantic -fcxx-exceptions -std=c++98 ${LLVM_SRC}/llvm/tools/clang/test/Parser/cxx-class.cpp
    RUN("%clang_cc1 -fsyntax-only -verify -pedantic -fcxx-exceptions -std=c++98 %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -pedantic -fcxx-exceptions -std=c++11 ${LLVM_SRC}/llvm/tools/clang/test/Parser/cxx-class.cpp
    RUN("%clang_cc1 -fsyntax-only -verify -pedantic -fcxx-exceptions -std=c++11 %s");
  }

  @Test
  public void test_cxx_class_template_specialization_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Parser/cxx-class-template-specialization.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/Parser/cxx-class-template-specialization.cpp
    RUN("%clang_cc1 -fsyntax-only -verify %s");
  }

  @Test
  public void test_cxx_concept_declaration_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Parser/cxx-concept-declaration.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c++14 -fconcepts-ts -x c++ -verify ${LLVM_SRC}/llvm/tools/clang/test/Parser/cxx-concept-declaration.cpp
    RUN("%clang_cc1 -std=c++14 -fconcepts-ts -x c++ -verify %s");
  }

  @Test
  public void test_cxx_concepts_ambig_constraint_expr_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Parser/cxx-concepts-ambig-constraint-expr.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c++14 -fconcepts-ts -x c++ ${LLVM_SRC}/llvm/tools/clang/test/Parser/cxx-concepts-ambig-constraint-expr.cpp -verify
    RUN("%clang_cc1 -std=c++14 -fconcepts-ts -x c++ %s -verify");
  }

  @Test
  public void test_cxx_concepts_requires_clause_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Parser/cxx-concepts-requires-clause.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c++14 -fconcepts-ts -x c++ ${LLVM_SRC}/llvm/tools/clang/test/Parser/cxx-concepts-requires-clause.cpp -verify
    RUN("%clang_cc1 -std=c++14 -fconcepts-ts -x c++ %s -verify");
  }

  @Test
  public void test_cxx_condition_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Parser/cxx-condition.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/Parser/cxx-condition.cpp
    RUN("%clang_cc1 -fsyntax-only -verify %s");
  }

  @Test
  public void test_cxx_decl_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Parser/cxx-decl.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -verify -fsyntax-only -triple i386-linux -pedantic-errors -fcxx-exceptions -fexceptions ${LLVM_SRC}/llvm/tools/clang/test/Parser/cxx-decl.cpp
    RUN("%clang_cc1 -verify -fsyntax-only -triple i386-linux -pedantic-errors -fcxx-exceptions -fexceptions %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -verify -fsyntax-only -triple i386-linux -pedantic-errors -fcxx-exceptions -fexceptions -std=c++98 ${LLVM_SRC}/llvm/tools/clang/test/Parser/cxx-decl.cpp
    RUN("%clang_cc1 -verify -fsyntax-only -triple i386-linux -pedantic-errors -fcxx-exceptions -fexceptions -std=c++98 %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -verify -fsyntax-only -triple i386-linux -pedantic-errors -fcxx-exceptions -fexceptions -std=c++11 ${LLVM_SRC}/llvm/tools/clang/test/Parser/cxx-decl.cpp
    RUN("%clang_cc1 -verify -fsyntax-only -triple i386-linux -pedantic-errors -fcxx-exceptions -fexceptions -std=c++11 %s");
  }

  @Test
  public void test_cxx_default_args_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Parser/cxx-default-args.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/Parser/cxx-default-args.cpp
    RUN("%clang_cc1 -fsyntax-only -verify %s");
  }

  @Test
  public void test_cxx_default_delete_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Parser/cxx-default-delete.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c++11 -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/Parser/cxx-default-delete.cpp
    RUN("%clang_cc1 -std=c++11 -fsyntax-only -verify %s");
  }

  @Test
  public void test_cxx_ext_delete_default_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Parser/cxx-ext-delete-default.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -std=c++98 ${LLVM_SRC}/llvm/tools/clang/test/Parser/cxx-ext-delete-default.cpp
    RUN("%clang_cc1 -fsyntax-only -verify -std=c++98 %s");
  }

  @Test
  public void test_cxx_extern_c_array_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Parser/cxx-extern-c-array.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/Parser/cxx-extern-c-array.cpp
    RUN("%clang_cc1 -fsyntax-only -verify %s");
  }

  @Test
  public void test_cxx_extra_semi_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Parser/cxx-extra-semi.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -pedantic -verify -DPEDANTIC ${LLVM_SRC}/llvm/tools/clang/test/Parser/cxx-extra-semi.cpp
    RUN("%clang_cc1 -fsyntax-only -pedantic -verify -DPEDANTIC %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -Wextra-semi -verify ${LLVM_SRC}/llvm/tools/clang/test/Parser/cxx-extra-semi.cpp
    RUN("%clang_cc1 -fsyntax-only -Wextra-semi -verify %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -Wextra-semi -verify -std=c++11 ${LLVM_SRC}/llvm/tools/clang/test/Parser/cxx-extra-semi.cpp
    RUN("%clang_cc1 -fsyntax-only -Wextra-semi -verify -std=c++11 %s");
    // cp ${LLVM_SRC}/llvm/tools/clang/test/Parser/cxx-extra-semi.cpp ${TEST_TEMP_DIR}/cxx-extra-semi.cpp.tmp
    RUN("cp %s %t");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x c++ -Wextra-semi -fixit ${TEST_TEMP_DIR}/cxx-extra-semi.cpp.tmp
    RUN("%clang_cc1 -x c++ -Wextra-semi -fixit %t");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x c++ -Wextra-semi -Werror ${TEST_TEMP_DIR}/cxx-extra-semi.cpp.tmp
    RUN("%clang_cc1 -x c++ -Wextra-semi -Werror %t");
  }

  @Test
  public void test_cxx_friend_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Parser/cxx-friend.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/Parser/cxx-friend.cpp
    RUN("%clang_cc1 -fsyntax-only -verify %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -std=c++98 ${LLVM_SRC}/llvm/tools/clang/test/Parser/cxx-friend.cpp
    RUN("%clang_cc1 -fsyntax-only -verify -std=c++98 %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -std=c++11 ${LLVM_SRC}/llvm/tools/clang/test/Parser/cxx-friend.cpp
    RUN("%clang_cc1 -fsyntax-only -verify -std=c++11 %s");
  }

  @Test
  public void test_cxx_in_c_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Parser/cxx-in-c.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/Parser/cxx-in-c.c
    RUN("%clang_cc1 -fsyntax-only -verify %s");
  }

  @Test
  public void test_cxx_invalid_for_range_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Parser/cxx-invalid-for-range.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c++11 -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/Parser/cxx-invalid-for-range.cpp
    RUN("%clang_cc1 -std=c++11 -fsyntax-only -verify %s");
  }

  @Test
  public void test_cxx_invalid_function_decl_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Parser/cxx-invalid-function-decl.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/Parser/cxx-invalid-function-decl.cpp
    RUN("%clang_cc1 -fsyntax-only -verify %s");
  }

  @Test
  public void test_cxx_member_crash_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Parser/cxx-member-crash.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only ${LLVM_SRC}/llvm/tools/clang/test/Parser/cxx-member-crash.cpp 2>&1 | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Parser/cxx-member-crash.cpp
    RUN("not %clang_cc1 -fsyntax-only %s 2>&1")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_cxx_member_init_missing_paren_crash_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Parser/cxx-member-init-missing-paren-crash.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only ${LLVM_SRC}/llvm/tools/clang/test/Parser/cxx-member-init-missing-paren-crash.cpp
    RUN("not %clang_cc1 -fsyntax-only %s");
  }

  @Test
  public void test_cxx_member_initializers_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Parser/cxx-member-initializers.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -std=c++11 ${LLVM_SRC}/llvm/tools/clang/test/Parser/cxx-member-initializers.cpp
    RUN("%clang_cc1 -fsyntax-only -verify -std=c++11 %s");
  }

  @Test
  public void test_cxx_namespace_alias_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Parser/cxx-namespace-alias.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/Parser/cxx-namespace-alias.cpp
    RUN("%clang_cc1 -fsyntax-only -verify %s");
  }

  @Test
  public void test_cxx_reference_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Parser/cxx-reference.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/Parser/cxx-reference.cpp
    RUN("%clang_cc1 -fsyntax-only -verify %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -std=c++98 ${LLVM_SRC}/llvm/tools/clang/test/Parser/cxx-reference.cpp
    RUN("%clang_cc1 -fsyntax-only -verify -std=c++98 %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -std=c++11 ${LLVM_SRC}/llvm/tools/clang/test/Parser/cxx-reference.cpp
    RUN("%clang_cc1 -fsyntax-only -verify -std=c++11 %s");
  }

  @Test
  public void test_cxx_stmt_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Parser/cxx-stmt.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fcxx-exceptions -fexceptions -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/Parser/cxx-stmt.cpp
    RUN("%clang_cc1 -fcxx-exceptions -fexceptions -fsyntax-only -verify %s");
  }

  @Test
  public void test_cxx_template_argument_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Parser/cxx-template-argument.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/Parser/cxx-template-argument.cpp
    RUN("%clang_cc1 -fsyntax-only -verify %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -std=c++98 ${LLVM_SRC}/llvm/tools/clang/test/Parser/cxx-template-argument.cpp
    RUN("%clang_cc1 -fsyntax-only -verify -std=c++98 %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -std=c++11 ${LLVM_SRC}/llvm/tools/clang/test/Parser/cxx-template-argument.cpp
    RUN("%clang_cc1 -fsyntax-only -verify -std=c++11 %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/Parser/cxx-template-argument.cpp -fdelayed-template-parsing
    RUN("%clang_cc1 -fsyntax-only -verify %s -fdelayed-template-parsing");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -std=c++98 ${LLVM_SRC}/llvm/tools/clang/test/Parser/cxx-template-argument.cpp -fdelayed-template-parsing
    RUN("%clang_cc1 -fsyntax-only -verify -std=c++98 %s -fdelayed-template-parsing");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -std=c++11 ${LLVM_SRC}/llvm/tools/clang/test/Parser/cxx-template-argument.cpp -fdelayed-template-parsing
    RUN("%clang_cc1 -fsyntax-only -verify -std=c++11 %s -fdelayed-template-parsing");
  }

  @Test
  public void test_cxx_template_decl_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Parser/cxx-template-decl.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/Parser/cxx-template-decl.cpp
    RUN("%clang_cc1 -fsyntax-only -verify %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/Parser/cxx-template-decl.cpp -fdelayed-template-parsing -DDELAYED_TEMPLATE_PARSING
    RUN("%clang_cc1 -fsyntax-only -verify %s -fdelayed-template-parsing -DDELAYED_TEMPLATE_PARSING");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -std=gnu++1z ${LLVM_SRC}/llvm/tools/clang/test/Parser/cxx-template-decl.cpp
    RUN("%clang_cc1 -fsyntax-only -verify -std=gnu++1z %s");
  }

  @Test
  public void test_cxx_throw_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Parser/cxx-throw.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fcxx-exceptions -fexceptions -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/Parser/cxx-throw.cpp
    RUN("%clang_cc1 -fcxx-exceptions -fexceptions -fsyntax-only -verify %s");
  }

  @Test
  public void test_cxx_typeid_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Parser/cxx-typeid.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/Parser/cxx-typeid.cpp
    RUN("%clang_cc1 -fsyntax-only -verify %s");
  }

  @Test
  public void test_cxx_typeof_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Parser/cxx-typeof.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/Parser/cxx-typeof.cpp
    RUN("%clang_cc1 -fsyntax-only -verify %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -std=gnu++98 ${LLVM_SRC}/llvm/tools/clang/test/Parser/cxx-typeof.cpp
    RUN("%clang_cc1 -fsyntax-only -verify -std=gnu++98 %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -std=gnu++11 ${LLVM_SRC}/llvm/tools/clang/test/Parser/cxx-typeof.cpp
    RUN("%clang_cc1 -fsyntax-only -verify -std=gnu++11 %s");
  }

  @Test
  public void test_cxx_undeclared_identifier_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Parser/cxx-undeclared-identifier.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -pedantic -verify ${LLVM_SRC}/llvm/tools/clang/test/Parser/cxx-undeclared-identifier.cpp
    RUN("%clang_cc1 -fsyntax-only -pedantic -verify %s");
  }

  @Test
  public void test_cxx_using_declaration_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Parser/cxx-using-declaration.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/Parser/cxx-using-declaration.cpp
    RUN("%clang_cc1 -fsyntax-only -verify %s");
  }

  @Test
  public void test_cxx_using_directive_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Parser/cxx-using-directive.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/Parser/cxx-using-directive.cpp
    RUN("%clang_cc1 -fsyntax-only -verify %s");
  }

  @Test
  public void test_cxx_variadic_func_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Parser/cxx-variadic-func.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/Parser/cxx-variadic-func.cpp
    RUN("%clang_cc1 -fsyntax-only -verify %s");
  }

  @Test
  public void test_cxx0x_ambig_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Parser/cxx0x-ambig.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -std=c++11 ${LLVM_SRC}/llvm/tools/clang/test/Parser/cxx0x-ambig.cpp
    RUN("%clang_cc1 -fsyntax-only -verify -std=c++11 %s");
  }

  @Test
  public void test_cxx0x_attributes_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Parser/cxx0x-attributes.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fcxx-exceptions -fexceptions -fsyntax-only -verify -std=c++11 -Wc++14-compat -Wc++14-extensions -Wc++1z-extensions ${LLVM_SRC}/llvm/tools/clang/test/Parser/cxx0x-attributes.cpp
    RUN("%clang_cc1 -fcxx-exceptions -fexceptions -fsyntax-only -verify -std=c++11 -Wc++14-compat -Wc++14-extensions -Wc++1z-extensions %s");
  }

  @Test
  public void test_cxx0x_condition_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Parser/cxx0x-condition.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -std=c++11 ${LLVM_SRC}/llvm/tools/clang/test/Parser/cxx0x-condition.cpp
    RUN("%clang_cc1 -fsyntax-only -verify -std=c++11 %s");
  }

  @Test
  public void test_cxx0x_decl_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Parser/cxx0x-decl.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -verify -fsyntax-only -std=c++11 -pedantic-errors -triple x86_64-linux-gnu ${LLVM_SRC}/llvm/tools/clang/test/Parser/cxx0x-decl.cpp
    RUN("%clang_cc1 -verify -fsyntax-only -std=c++11 -pedantic-errors -triple x86_64-linux-gnu %s");
  }

  @Test
  public void test_cxx0x_for_range_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Parser/cxx0x-for-range.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -fdiagnostics-parseable-fixits -std=c++11 ${LLVM_SRC}/llvm/tools/clang/test/Parser/cxx0x-for-range.cpp 2>&1 | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Parser/cxx0x-for-range.cpp
    RUN("not %clang_cc1 -fsyntax-only -fdiagnostics-parseable-fixits -std=c++11 %s 2>&1")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_cxx0x_in_cxx98_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Parser/cxx0x-in-cxx98.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c++98 -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/Parser/cxx0x-in-cxx98.cpp
    RUN("%clang_cc1 -std=c++98 -fsyntax-only -verify %s");
  }

  @Test
  public void test_cxx0x_lambda_expressions_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Parser/cxx0x-lambda-expressions.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -Wno-unused-value -verify -std=c++11 ${LLVM_SRC}/llvm/tools/clang/test/Parser/cxx0x-lambda-expressions.cpp
    RUN("%clang_cc1 -fsyntax-only -Wno-unused-value -verify -std=c++11 %s");
  }

  @Test
  public void test_cxx0x_literal_operators_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Parser/cxx0x-literal-operators.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -std=c++11 ${LLVM_SRC}/llvm/tools/clang/test/Parser/cxx0x-literal-operators.cpp
    RUN("%clang_cc1 -fsyntax-only -verify -std=c++11 %s");
  }

  @Test
  public void test_cxx0x_member_initializers_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Parser/cxx0x-member-initializers.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -std=c++11 ${LLVM_SRC}/llvm/tools/clang/test/Parser/cxx0x-member-initializers.cpp
    RUN("%clang_cc1 -fsyntax-only -verify -std=c++11 %s");
  }

  @Test
  public void test_cxx0x_override_control_keywords_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Parser/cxx0x-override-control-keywords.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -std=c++11 ${LLVM_SRC}/llvm/tools/clang/test/Parser/cxx0x-override-control-keywords.cpp
    RUN("%clang_cc1 -fsyntax-only -verify -std=c++11 %s");
  }

  @Test
  public void test_cxx0x_rvalue_reference_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Parser/cxx0x-rvalue-reference.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -std=c++11 ${LLVM_SRC}/llvm/tools/clang/test/Parser/cxx0x-rvalue-reference.cpp
    RUN("%clang_cc1 -fsyntax-only -verify -std=c++11 %s");
  }

  @Test
  public void test_cxx11_base_spec_attributes_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Parser/cxx11-base-spec-attributes.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c++11 ${LLVM_SRC}/llvm/tools/clang/test/Parser/cxx11-base-spec-attributes.cpp -verify
    RUN("%clang_cc1 -std=c++11 %s -verify");
  }

  @Test
  public void test_cxx11_brace_initializers_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Parser/cxx11-brace-initializers.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/Parser/cxx11-brace-initializers.cpp -std=c++11
    RUN("%clang_cc1 -fsyntax-only -verify %s -std=c++11");
  }

  @Test
  public void test_cxx11_stmt_attributes_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Parser/cxx11-stmt-attributes.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fcxx-exceptions -fexceptions -fsyntax-only -verify -std=c++11 ${LLVM_SRC}/llvm/tools/clang/test/Parser/cxx11-stmt-attributes.cpp
    RUN("%clang_cc1 -fcxx-exceptions -fexceptions -fsyntax-only -verify -std=c++11 %s");
  }

  @Test
  public void test_cxx11_templates_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Parser/cxx11-templates.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c++11 -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/Parser/cxx11-templates.cpp
    RUN("%clang_cc1 -std=c++11 -fsyntax-only -verify %s");
  }

  @Test
  public void test_cxx11_type_specifier_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Parser/cxx11-type-specifier.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -verify ${LLVM_SRC}/llvm/tools/clang/test/Parser/cxx11-type-specifier.cpp -std=c++11 -fcxx-exceptions
    RUN("%clang_cc1 -verify %s -std=c++11 -fcxx-exceptions");
  }

  @Test
  public void test_cxx11_user_defined_literals_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Parser/cxx11-user-defined-literals.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c++11 -verify ${LLVM_SRC}/llvm/tools/clang/test/Parser/cxx11-user-defined-literals.cpp -fms-extensions -triple x86_64-apple-darwin9.0.0
    RUN("%clang_cc1 -std=c++11 -verify %s -fms-extensions -triple x86_64-apple-darwin9.0.0");
  }

  @Test
  public void test_cxx1z_attributes_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Parser/cxx1z-attributes.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -std=c++1z ${LLVM_SRC}/llvm/tools/clang/test/Parser/cxx1z-attributes.cpp
    RUN("%clang_cc1 -fsyntax-only -verify -std=c++1z %s");
  }

  @Test
  public void test_cxx1z_coroutines_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Parser/cxx1z-coroutines.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c++11 -fcoroutines ${LLVM_SRC}/llvm/tools/clang/test/Parser/cxx1z-coroutines.cpp -verify
    RUN("%clang_cc1 -std=c++11 -fcoroutines %s -verify");
  }

  @Test
  public void test_cxx1z_fold_expressions_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Parser/cxx1z-fold-expressions.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c++1z -verify ${LLVM_SRC}/llvm/tools/clang/test/Parser/cxx1z-fold-expressions.cpp
    RUN("%clang_cc1 -std=c++1z -verify %s");
  }

  @Test
  public void test_cxx1z_init_statement_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Parser/cxx1z-init-statement.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c++1z -verify ${LLVM_SRC}/llvm/tools/clang/test/Parser/cxx1z-init-statement.cpp -Wno-vexing-parse
    RUN("%clang_cc1 -std=c++1z -verify %s -Wno-vexing-parse");
  }

  @Test
  public void test_cxx1z_nested_namespace_definition_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Parser/cxx1z-nested-namespace-definition.cpp");
    // cp ${LLVM_SRC}/llvm/tools/clang/test/Parser/cxx1z-nested-namespace-definition.cpp ${TEST_TEMP_DIR}/cxx1z-nested-namespace-definition.cpp.tmp
    RUN("cp %s %t");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/Parser/cxx1z-nested-namespace-definition.cpp
    RUN("%clang_cc1 -fsyntax-only -verify %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x c++ -fixit ${TEST_TEMP_DIR}/cxx1z-nested-namespace-definition.cpp.tmp -Werror -DFIXIT
    RUN("not %clang_cc1 -x c++ -fixit %t -Werror -DFIXIT");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x c++ ${TEST_TEMP_DIR}/cxx1z-nested-namespace-definition.cpp.tmp -DFIXIT
    RUN("%clang_cc1 -x c++ %t -DFIXIT");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/Parser/cxx1z-nested-namespace-definition.cpp -std=c++1z -Wc++14-compat
    RUN("%clang_cc1 -fsyntax-only -verify %s -std=c++1z -Wc++14-compat");
  }

  @Test
  public void test_debugger_import_module_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Parser/debugger-import-module.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -fdebugger-support -verify ${LLVM_SRC}/llvm/tools/clang/test/Parser/debugger-import-module.m
    RUN("%clang_cc1 -fsyntax-only -fdebugger-support -verify %s");
  }

  @Test
  public void test_declarators_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Parser/declarators.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/Parser/declarators.c -fsyntax-only -verify -pedantic
    RUN("%clang_cc1 %s -fsyntax-only -verify -pedantic");
  }

  @Test
  public void test_designator_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Parser/designator.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only ${LLVM_SRC}/llvm/tools/clang/test/Parser/designator.c -verify -pedantic
    RUN("%clang_cc1 -fsyntax-only %s -verify -pedantic");
  }

  @Test
  public void test_diag_crash_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Parser/diag-crash.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/Parser/diag-crash.c
    RUN("%clang_cc1 -fsyntax-only -verify %s");
  }

  @Test
  public void test_empty_translation_unit_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Parser/empty-translation-unit.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -std=c99 -pedantic -W -verify ${LLVM_SRC}/llvm/tools/clang/test/Parser/empty-translation-unit.c
    RUN("%clang_cc1 -fsyntax-only -std=c99 -pedantic -W -verify %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -x c++ -std=c++03 -pedantic-errors -W ${LLVM_SRC}/llvm/tools/clang/test/Parser/empty-translation-unit.c
    RUN("%clang_cc1 -fsyntax-only -x c++ -std=c++03 -pedantic-errors -W %s");
  }

  @Test
  public void test_encode_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Parser/encode.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/Parser/encode.m
    RUN("%clang_cc1 -fsyntax-only -verify %s");
  }

  @Test
  public void test_enhanced_proto_1_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Parser/enhanced-proto-1.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/Parser/enhanced-proto-1.m
    RUN("%clang_cc1 -fsyntax-only -verify %s");
  }

  @Test
  public void test_eof_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Parser/eof.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/Parser/eof.cpp -fsyntax-only 2>&1 | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Parser/eof.cpp
    RUN("not %clang_cc1 %s -fsyntax-only 2>&1")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_eof2_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Parser/eof2.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/Parser/eof2.cpp -fsyntax-only 2>&1 | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Parser/eof2.cpp
    RUN("not %clang_cc1 %s -fsyntax-only 2>&1")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_expressions_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Parser/expressions.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/Parser/expressions.c
    RUN("%clang_cc1 -fsyntax-only -verify %s");
  }

  @Test
  public void test_expressions_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Parser/expressions.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/Parser/expressions.m
    RUN("%clang_cc1 -fsyntax-only -verify %s");
  }

  @Test
  public void test_extension_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Parser/extension.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/Parser/extension.c -fsyntax-only -pedantic -verify -std=c89
    RUN("%clang_cc1 %s -fsyntax-only -pedantic -verify -std=c89");
  }

  @Test
  public void test_extra_semi_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Parser/extra-semi.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/Parser/extra-semi.cpp
    RUN("%clang_cc1 -fsyntax-only -verify %s");
    // cp ${LLVM_SRC}/llvm/tools/clang/test/Parser/extra-semi.cpp ${TEST_TEMP_DIR}/extra-semi.cpp.tmp.cpp
    RUN("cp %s %t.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only ${TEST_TEMP_DIR}/extra-semi.cpp.tmp.cpp -fixit
    RUN("not %clang_cc1 -fsyntax-only %t.cpp -fixit");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only ${TEST_TEMP_DIR}/extra-semi.cpp.tmp.cpp
    RUN("%clang_cc1 -fsyntax-only %t.cpp");
  }

  @Test
  public void test_for_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Parser/for.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/Parser/for.cpp
    RUN("%clang_cc1 -fsyntax-only -verify %s");
  }

  @Test
  public void test_function_decls_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Parser/function-decls.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/Parser/function-decls.c -ast-print
    RUN("%clang_cc1 %s -ast-print");
  }

  @Test
  public void test_goto_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Parser/goto.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/Parser/goto.c
    RUN("%clang_cc1 -fsyntax-only -verify %s");
  }

  @Test
  public void test_if_scope_c90_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Parser/if-scope-c90.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -std=c90 ${LLVM_SRC}/llvm/tools/clang/test/Parser/if-scope-c90.c
    RUN("%clang_cc1 -fsyntax-only -verify -std=c90 %s");
  }

  @Test
  public void test_if_scope_c99_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Parser/if-scope-c99.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -std=c99 ${LLVM_SRC}/llvm/tools/clang/test/Parser/if-scope-c99.c
    RUN("%clang_cc1 -fsyntax-only -verify -std=c99 %s");
  }

  @Test
  public void test_implicit_casts_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Parser/implicit-casts.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -pedantic ${LLVM_SRC}/llvm/tools/clang/test/Parser/implicit-casts.c
    RUN("%clang_cc1 -fsyntax-only -verify -pedantic %s");
  }

  @Test
  public void test_knr_parameter_attributes_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Parser/knr_parameter_attributes.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -W -Wall -Werror -verify ${LLVM_SRC}/llvm/tools/clang/test/Parser/knr_parameter_attributes.c
    RUN("%clang_cc1 -fsyntax-only -W -Wall -Werror -verify %s");
  }

  @Test
  public void test_method_def_in_class_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Parser/method-def-in-class.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/Parser/method-def-in-class.m
    RUN("%clang_cc1 -fsyntax-only -verify %s");
  }

  @Test
  public void test_method_prototype_1_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Parser/method-prototype-1.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/Parser/method-prototype-1.m -fsyntax-only
    RUN("%clang_cc1 %s -fsyntax-only");
  }

  @Test
  public void test_missing_closing_rbrace_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Parser/missing-closing-rbrace.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/Parser/missing-closing-rbrace.m
    RUN("%clang_cc1 -fsyntax-only -verify %s");
  }

  @Test
  public void test_missing_end_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Parser/missing-end.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/Parser/missing-end.m
    RUN("%clang_cc1 -fsyntax-only -verify %s");
  }

  @Test
  public void test_missing_end_2_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Parser/missing-end-2.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/Parser/missing-end-2.m
    RUN("%clang_cc1 -fsyntax-only -verify %s");
  }

  @Test
  public void test_missing_end_3_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Parser/missing-end-3.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/Parser/missing-end-3.m
    RUN("%clang_cc1 -fsyntax-only -verify %s");
  }

  @Test
  public void test_missing_end_4_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Parser/missing-end-4.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -Wno-objc-root-class ${LLVM_SRC}/llvm/tools/clang/test/Parser/missing-end-4.m
    RUN("%clang_cc1 -fsyntax-only -verify -Wno-objc-root-class %s");
  }

  @Test
  public void test_missing_selector_name_mm() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Parser/missing-selector-name.mm");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -Wno-objc-root-class ${LLVM_SRC}/llvm/tools/clang/test/Parser/missing-selector-name.mm
    RUN("%clang_cc1 -fsyntax-only -verify -Wno-objc-root-class %s");
  }

  @Test
  public void test_ms_anachronism_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Parser/ms-anachronism.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i686-windows-msvc -fms-extensions -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/Parser/ms-anachronism.c
    RUN("%clang_cc1 -triple i686-windows-msvc -fms-extensions -fsyntax-only -verify %s");
  }

  @Test
  public void test_ms_if_exists_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Parser/ms-if-exists.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/Parser/ms-if-exists.c -fsyntax-only -Wmicrosoft -verify -fms-extensions
    RUN("%clang_cc1 %s -fsyntax-only -Wmicrosoft -verify -fms-extensions");
  }

  @Test
  public void test_ms_if_exists_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Parser/ms-if-exists.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/Parser/ms-if-exists.cpp -std=c++11 -fsyntax-only -Wmicrosoft -verify -fms-extensions
    RUN("%clang_cc1 %s -std=c++11 -fsyntax-only -Wmicrosoft -verify -fms-extensions");
  }

  @Test
  public void test_ms_inline_asm_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Parser/ms-inline-asm.c");
    // REQUIRES: x86-registered-target
    if (!CHECK_REQUIRES("x86-registered-target")) {
      return;
    }
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/Parser/ms-inline-asm.c -triple i386-apple-darwin10 -verify -fasm-blocks
    RUN(TestState.Failed, "%clang_cc1 %s -triple i386-apple-darwin10 -verify -fasm-blocks");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/Parser/ms-inline-asm.c -triple i386-apple-darwin10 -verify -fasm-blocks -fno-gnu-inline-asm
    RUN(TestState.Failed, "%clang_cc1 %s -triple i386-apple-darwin10 -verify -fasm-blocks -fno-gnu-inline-asm");
  }

  @Test
  public void test_ms_inline_asm_nested_braces_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Parser/ms-inline-asm-nested-braces.c");
    // REQUIRES: x86-registered-target
    if (!CHECK_REQUIRES("x86-registered-target")) {
      return;
    }
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/Parser/ms-inline-asm-nested-braces.c -triple i386-apple-darwin10 -verify -fasm-blocks
    RUN("%clang_cc1 %s -triple i386-apple-darwin10 -verify -fasm-blocks");
  }

  @Test
  public void test_ms_seh_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Parser/ms-seh.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/Parser/ms-seh.c -fsyntax-only -Wmicrosoft -verify -fms-extensions
    RUN("%clang_cc1 %s -fsyntax-only -Wmicrosoft -verify -fms-extensions");
  }

  @Test
  public void test_namelookup_bug_1_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Parser/namelookup-bug-1.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -verify ${LLVM_SRC}/llvm/tools/clang/test/Parser/namelookup-bug-1.c
    RUN("%clang_cc1 -verify %s");
  }

  @Test
  public void test_namelookup_bug_2_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Parser/namelookup-bug-2.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -verify ${LLVM_SRC}/llvm/tools/clang/test/Parser/namelookup-bug-2.c
    RUN("%clang_cc1 -verify %s");
  }

  @Test
  public void test_namespace_alias_attr_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Parser/namespace-alias-attr.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -verify ${LLVM_SRC}/llvm/tools/clang/test/Parser/namespace-alias-attr.cpp
    RUN("%clang_cc1 -verify %s");
  }

  @Test
  public void test_namespaces_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Parser/namespaces.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c++11 -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/Parser/namespaces.cpp
    RUN("%clang_cc1 -std=c++11 -fsyntax-only -verify %s");
  }

  @Test
  public void test_no_gnu_inline_asm_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Parser/no-gnu-inline-asm.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/Parser/no-gnu-inline-asm.c -triple i686-apple-darwin -verify -fsyntax-only -fno-gnu-inline-asm
    RUN("%clang_cc1 %s -triple i686-apple-darwin -verify -fsyntax-only -fno-gnu-inline-asm");
  }

  @Test
  public void test_nullability_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Parser/nullability.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -std=c99 -Wno-nullability-declspec -pedantic ${LLVM_SRC}/llvm/tools/clang/test/Parser/nullability.c -verify
    RUN("%clang_cc1 -fsyntax-only -std=c99 -Wno-nullability-declspec -pedantic %s -verify");
  }

  @Test // ObjCInterfaceTypeLoc recursion in getFullSize
  public void test_objc_alias_printing_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Parser/objc-alias-printing.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -ast-print ${LLVM_SRC}/llvm/tools/clang/test/Parser/objc-alias-printing.m
    RUN("%clang_cc1 -ast-print %s");
  }

  @Test
  public void test_objc_available_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Parser/objc-available.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -Wunguarded-availability -triple x86_64-apple-macosx10.10.0 -verify ${LLVM_SRC}/llvm/tools/clang/test/Parser/objc-available.m
    RUN("%clang_cc1 -fsyntax-only -Wunguarded-availability -triple x86_64-apple-macosx10.10.0 -verify %s");
  }

  @Test
  public void test_objc_boxing_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Parser/objc-boxing.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/Parser/objc-boxing.m
    RUN("%clang_cc1 -fsyntax-only -verify %s");
  }

  @Test
  public void test_objc_category_neg_1_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Parser/objc-category-neg-1.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/Parser/objc-category-neg-1.m
    RUN("%clang_cc1 -fsyntax-only -verify %s");
  }

  @Test
  public void test_objc_class_property_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Parser/objc-class-property.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/Parser/objc-class-property.m
    RUN("%clang_cc1 -fsyntax-only -verify %s");
  }

  @Test
  public void test_objc_default_ctor_init_mm() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Parser/objc-default-ctor-init.mm");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-apple-macosx10.10 -std=c++11 -ast-dump ${LLVM_SRC}/llvm/tools/clang/test/Parser/objc-default-ctor-init.mm | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Parser/objc-default-ctor-init.mm
    RUN("%clang_cc1 -triple x86_64-apple-macosx10.10 -std=c++11 -ast-dump %s")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_objc_diag_width_mm() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Parser/objc-diag-width.mm");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/Parser/objc-diag-width.mm 2>&1 | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Parser/objc-diag-width.mm
    RUN("not %clang_cc1 %s 2>&1")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_objc_error_qualified_implementation_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Parser/objc-error-qualified-implementation.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -Wno-objc-root-class -verify ${LLVM_SRC}/llvm/tools/clang/test/Parser/objc-error-qualified-implementation.m
    RUN("%clang_cc1 -fsyntax-only -Wno-objc-root-class -verify %s");
  }

  @Test
  public void test_objc_forcollection_1_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Parser/objc-forcollection-1.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only ${LLVM_SRC}/llvm/tools/clang/test/Parser/objc-forcollection-1.m
    RUN("%clang_cc1 -fsyntax-only %s");
  }

  @Test
  public void test_objc_forcollection_neg_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Parser/objc-forcollection-neg.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -Wno-objc-root-class ${LLVM_SRC}/llvm/tools/clang/test/Parser/objc-forcollection-neg.m
    RUN("%clang_cc1 -fsyntax-only -verify -Wno-objc-root-class %s");
  }

  @Test
  public void test_objc_forcollection_neg_2_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Parser/objc-forcollection-neg-2.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -Wno-objc-root-class ${LLVM_SRC}/llvm/tools/clang/test/Parser/objc-forcollection-neg-2.m
    RUN("%clang_cc1 -fsyntax-only -verify -Wno-objc-root-class %s");
  }

  @Test
  public void test_objc_foreach_syntax_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Parser/objc-foreach-syntax.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -Wno-objc-root-class ${LLVM_SRC}/llvm/tools/clang/test/Parser/objc-foreach-syntax.m
    RUN("%clang_cc1 -fsyntax-only -verify -Wno-objc-root-class %s");
  }

  @Test
  public void test_objc_init_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Parser/objc-init.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -fobjc-runtime=macosx-fragile -verify -pedantic -Wno-objc-root-class ${LLVM_SRC}/llvm/tools/clang/test/Parser/objc-init.m
    RUN("%clang_cc1 -fsyntax-only -fobjc-runtime=macosx-fragile -verify -pedantic -Wno-objc-root-class %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -fobjc-runtime=macosx-fragile -verify -x objective-c++ -Wno-objc-root-class ${LLVM_SRC}/llvm/tools/clang/test/Parser/objc-init.m
    RUN("%clang_cc1 -fsyntax-only -fobjc-runtime=macosx-fragile -verify -x objective-c++ -Wno-objc-root-class %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -fobjc-runtime=macosx-fragile -verify -x objective-c++ -Wno-objc-root-class -std=c++98 ${LLVM_SRC}/llvm/tools/clang/test/Parser/objc-init.m
    RUN("%clang_cc1 -fsyntax-only -fobjc-runtime=macosx-fragile -verify -x objective-c++ -Wno-objc-root-class -std=c++98 %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -fobjc-runtime=macosx-fragile -verify -x objective-c++ -Wno-objc-root-class -std=c++11 ${LLVM_SRC}/llvm/tools/clang/test/Parser/objc-init.m
    RUN("%clang_cc1 -fsyntax-only -fobjc-runtime=macosx-fragile -verify -x objective-c++ -Wno-objc-root-class -std=c++11 %s");
  }

  @Test
  public void test_objc_interfaces_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Parser/objc-interfaces.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/Parser/objc-interfaces.m -fsyntax-only -verify
    RUN("%clang_cc1 %s -fsyntax-only -verify");
  }

  @Test
  public void test_objc_messaging_1_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Parser/objc-messaging-1.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/Parser/objc-messaging-1.m -fsyntax-only -verify
    RUN("%clang_cc1 %s -fsyntax-only -verify");
  }

  @Test
  public void test_objc_messaging_neg_1_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Parser/objc-messaging-neg-1.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/Parser/objc-messaging-neg-1.m
    RUN("%clang_cc1 -fsyntax-only -verify %s");
  }

  @Test
  public void test_objc_missing_impl_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Parser/objc-missing-impl.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/Parser/objc-missing-impl.m
    RUN("%clang_cc1 -fsyntax-only -verify %s");
  }

  @Test
  public void test_objc_property_syntax_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Parser/objc-property-syntax.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -Wno-objc-root-class ${LLVM_SRC}/llvm/tools/clang/test/Parser/objc-property-syntax.m
    RUN("%clang_cc1 -fsyntax-only -verify -Wno-objc-root-class %s");
  }

  @Test
  public void test_objc_quirks_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Parser/objc-quirks.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -pedantic ${LLVM_SRC}/llvm/tools/clang/test/Parser/objc-quirks.m
    RUN("%clang_cc1 -fsyntax-only -verify -pedantic %s");
  }

  @Test
  public void test_objc_recover_mm() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Parser/objc-recover.mm");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -Wno-objc-root-class ${LLVM_SRC}/llvm/tools/clang/test/Parser/objc-recover.mm
    RUN("%clang_cc1 -fsyntax-only -verify -Wno-objc-root-class %s");
  }

  @Test
  public void test_objc_synthesized_recover_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Parser/objc-synthesized-recover.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -Wno-objc-root-class ${LLVM_SRC}/llvm/tools/clang/test/Parser/objc-synthesized-recover.m
    RUN("%clang_cc1 -fsyntax-only -verify -Wno-objc-root-class %s");
  }

  @Test
  public void test_objc_try_catch_1_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Parser/objc-try-catch-1.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -fobjc-exceptions ${LLVM_SRC}/llvm/tools/clang/test/Parser/objc-try-catch-1.m
    RUN("%clang_cc1 -fsyntax-only -verify -fobjc-exceptions %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -fobjc-exceptions -x objective-c++ ${LLVM_SRC}/llvm/tools/clang/test/Parser/objc-try-catch-1.m
    RUN("%clang_cc1 -fsyntax-only -verify -fobjc-exceptions -x objective-c++ %s");
  }

  @Test
  public void test_objc_type_printing_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Parser/objc-type-printing.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -ast-print ${LLVM_SRC}/llvm/tools/clang/test/Parser/objc-type-printing.m
    RUN("%clang_cc1 -ast-print %s");
  }

  @Test
  public void test_objcbridge_related_attribute_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Parser/objcbridge-related-attribute.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -verify -fsyntax-only ${LLVM_SRC}/llvm/tools/clang/test/Parser/objcbridge-related-attribute.m
    RUN("%clang_cc1 -verify -fsyntax-only %s");
  }

  @Test
  public void test_objcxx_at_mm() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Parser/objcxx-at.mm");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/Parser/objcxx-at.mm
    RUN("%clang_cc1 -fsyntax-only -verify %s");
  }

  @Test
  public void test_objcxx_lambda_expressions_neg_mm() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Parser/objcxx-lambda-expressions-neg.mm");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -Wno-unused-value -verify ${LLVM_SRC}/llvm/tools/clang/test/Parser/objcxx-lambda-expressions-neg.mm
    RUN("%clang_cc1 -fsyntax-only -Wno-unused-value -verify %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -Wno-unused-value -verify -std=c++98 ${LLVM_SRC}/llvm/tools/clang/test/Parser/objcxx-lambda-expressions-neg.mm
    RUN("%clang_cc1 -fsyntax-only -Wno-unused-value -verify -std=c++98 %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -Wno-unused-value -verify -std=c++11 ${LLVM_SRC}/llvm/tools/clang/test/Parser/objcxx-lambda-expressions-neg.mm
    RUN("%clang_cc1 -fsyntax-only -Wno-unused-value -verify -std=c++11 %s");
  }

  @Test
  public void test_objcxx0x_lambda_expressions_mm() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Parser/objcxx0x-lambda-expressions.mm");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -Wno-unused-value -Wno-c++1y-extensions -std=c++11 ${LLVM_SRC}/llvm/tools/clang/test/Parser/objcxx0x-lambda-expressions.mm
    RUN("%clang_cc1 -fsyntax-only -verify -Wno-unused-value -Wno-c++1y-extensions -std=c++11 %s");
  }

  @Test
  public void test_objcxx11_attributes_mm() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Parser/objcxx11-attributes.mm");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -std=c++11 ${LLVM_SRC}/llvm/tools/clang/test/Parser/objcxx11-attributes.mm
    RUN("%clang_cc1 -fsyntax-only -verify -std=c++11 %s");
  }

  @Test
  public void test_objcxx11_initialized_temps_mm() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Parser/objcxx11-initialized-temps.mm");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -std=c++11 ${LLVM_SRC}/llvm/tools/clang/test/Parser/objcxx11-initialized-temps.mm
    RUN("%clang_cc1 -fsyntax-only -verify -std=c++11 %s");
  }

  @Test
  public void test_objcxx11_messaging_and_lambda_mm() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Parser/objcxx11-messaging-and-lambda.mm");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -std=c++11 ${LLVM_SRC}/llvm/tools/clang/test/Parser/objcxx11-messaging-and-lambda.mm
    RUN("%clang_cc1 -fsyntax-only -verify -std=c++11 %s");
  }

  @Test
  public void test_objcxx11_protocol_in_template_mm() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Parser/objcxx11-protocol-in-template.mm");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/Parser/objcxx11-protocol-in-template.mm
    RUN("%clang_cc1 -fsyntax-only -verify %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -std=c++11 ${LLVM_SRC}/llvm/tools/clang/test/Parser/objcxx11-protocol-in-template.mm
    RUN("%clang_cc1 -fsyntax-only -verify -std=c++11 %s");
  }

  @Test
  public void test_objcxx11_user_defined_literal_mm() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Parser/objcxx11-user-defined-literal.mm");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -std=c++11 ${LLVM_SRC}/llvm/tools/clang/test/Parser/objcxx11-user-defined-literal.mm
    RUN("%clang_cc1 -fsyntax-only -verify -std=c++11 %s");
  }

  @Test
  public void test_objcxx14_protocol_in_template_mm() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Parser/objcxx14-protocol-in-template.mm");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -std=c++14 ${LLVM_SRC}/llvm/tools/clang/test/Parser/objcxx14-protocol-in-template.mm
    RUN("%clang_cc1 -fsyntax-only -verify -std=c++14 %s");
  }

  @Test
  public void test_offsetof_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Parser/offsetof.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/Parser/offsetof.c
    RUN("%clang_cc1 -fsyntax-only -verify %s");
  }

  @Test
  public void test_opencl_astype_cl() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Parser/opencl-astype.cl");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/Parser/opencl-astype.cl -triple spir-unknown-unknown
    RUN("%clang_cc1 -fsyntax-only -verify %s -triple spir-unknown-unknown");
  }

  @Test
  public void test_opencl_atomics_cl20_cl() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Parser/opencl-atomics-cl20.cl");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/Parser/opencl-atomics-cl20.cl -triple spir-unknown-unknown -verify -pedantic -fsyntax-only
    RUN("%clang_cc1 %s -triple spir-unknown-unknown -verify -pedantic -fsyntax-only");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/Parser/opencl-atomics-cl20.cl -triple spir-unknown-unknown -verify -fsyntax-only -cl-std=CL2.0 -DCL20
    RUN("%clang_cc1 %s -triple spir-unknown-unknown -verify -fsyntax-only -cl-std=CL2.0 -DCL20");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/Parser/opencl-atomics-cl20.cl -triple spir-unknown-unknown -verify -fsyntax-only -cl-std=CL2.0 -DCL20 -DEXT -Wpedantic-core-features
    RUN("%clang_cc1 %s -triple spir-unknown-unknown -verify -fsyntax-only -cl-std=CL2.0 -DCL20 -DEXT -Wpedantic-core-features");
  }

  @Test
  public void test_opencl_cl20_cl() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Parser/opencl-cl20.cl");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/Parser/opencl-cl20.cl -verify -pedantic -fsyntax-only
    RUN("%clang_cc1 %s -verify -pedantic -fsyntax-only");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/Parser/opencl-cl20.cl -verify -pedantic -fsyntax-only -cl-std=CL2.0 -DCL20
    RUN("%clang_cc1 %s -verify -pedantic -fsyntax-only -cl-std=CL2.0 -DCL20");
  }

  @Test
  public void test_opencl_image_access_cl() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Parser/opencl-image-access.cl");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/Parser/opencl-image-access.cl -fsyntax-only -verify
    RUN(TestState.Failed, "%clang_cc1 %s -fsyntax-only -verify");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/Parser/opencl-image-access.cl -fsyntax-only -verify -cl-std=CL2.0 -DCL20
    RUN(TestState.Failed, "%clang_cc1 %s -fsyntax-only -verify -cl-std=CL2.0 -DCL20");
  }

  @Test
  public void test_opencl_kernel_cl() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Parser/opencl-kernel.cl");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/Parser/opencl-kernel.cl -verify -pedantic -fsyntax-only
    RUN("%clang_cc1 %s -verify -pedantic -fsyntax-only");
  }

  @Test
  public void test_opencl_keywords_cl() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Parser/opencl-keywords.cl");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/Parser/opencl-keywords.cl -verify -pedantic -fsyntax-only
    RUN("%clang_cc1 %s -verify -pedantic -fsyntax-only");
  }

  @Test
  public void test_opencl_pragma_cl() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Parser/opencl-pragma.cl");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/Parser/opencl-pragma.cl -verify -pedantic -Wno-empty-translation-unit -fsyntax-only -triple spir-unknown-unknown
    RUN("%clang_cc1 %s -verify -pedantic -Wno-empty-translation-unit -fsyntax-only -triple spir-unknown-unknown");
  }

  @Test
  public void test_opencl_storage_class_cl() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Parser/opencl-storage-class.cl");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/Parser/opencl-storage-class.cl -verify -fsyntax-only -triple spir-unknown-unknown
    RUN("%clang_cc1 %s -verify -fsyntax-only -triple spir-unknown-unknown");
  }

  @Test
  public void test_opencl_unroll_hint_cl() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Parser/opencl-unroll-hint.cl");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -O0 -cl-std=CL2.0 -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/Parser/opencl-unroll-hint.cl
    RUN("%clang_cc1 -O0 -cl-std=CL2.0 -fsyntax-only -verify %s");
  }

  @Test
  public void test_parenthesis_balance_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Parser/parenthesis-balance.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/Parser/parenthesis-balance.cpp
    RUN("%clang_cc1 -fsyntax-only -verify %s");
  }

  @Test
  public void test_parmvardecl_conversion_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Parser/parmvardecl_conversion.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/Parser/parmvardecl_conversion.c
    RUN("%clang_cc1 -fsyntax-only -verify %s");
  }

  @Test
  public void test_parser_overflow_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Parser/parser_overflow.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/Parser/parser_overflow.c -fsyntax-only -DHUGE 2>&1 | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Parser/parser_overflow.c
    RUN("not %clang_cc1 %s -fsyntax-only -DHUGE 2>&1")./*|*/
      I("FileCheck %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/Parser/parser_overflow.c -fsyntax-only 2>&1 | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Parser/parser_overflow.c
    RUN("not %clang_cc1 %s -fsyntax-only 2>&1")./*|*/
      I("FileCheck %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/Parser/parser_overflow.c -fsyntax-only -fbracket-depth 299 2>&1 | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Parser/parser_overflow.c
    RUN("not %clang_cc1 %s -fsyntax-only -fbracket-depth 299 2>&1")./*|*/
      I("FileCheck %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/Parser/parser_overflow.c -fsyntax-only -fbracket-depth 300
    RUN("%clang_cc1 %s -fsyntax-only -fbracket-depth 300");
    // ${LLVM_SRC}/build/bin/clang ${LLVM_SRC}/llvm/tools/clang/test/Parser/parser_overflow.c -fsyntax-only -fbracket-depth=299 2>&1 | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Parser/parser_overflow.c
    RUN("not %clang %s -fsyntax-only -fbracket-depth=299 2>&1")./*|*/
      I("FileCheck %s");
    // ${LLVM_SRC}/build/bin/clang ${LLVM_SRC}/llvm/tools/clang/test/Parser/parser_overflow.c -fsyntax-only -fbracket-depth=300
    RUN("%clang %s -fsyntax-only -fbracket-depth=300");
  }

  @Test
  public void test_placeholder_recovery_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Parser/placeholder-recovery.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/Parser/placeholder-recovery.m
    RUN("%clang_cc1 -fsyntax-only -verify %s");
  }

  @Test
  public void test_pointer_arithmetic_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Parser/pointer-arithmetic.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/Parser/pointer-arithmetic.c
    RUN("%clang_cc1 -fsyntax-only -verify %s");
  }

  @Test
  public void test_pointer_promotion_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Parser/pointer_promotion.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/Parser/pointer_promotion.c
    RUN("%clang_cc1 -fsyntax-only -verify %s");
  }

  @Test
  public void test_pragma_fp_contract_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Parser/pragma-fp-contract.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/Parser/pragma-fp-contract.c
    RUN("%clang_cc1 -fsyntax-only -verify %s");
  }

  @Test
  public void test_pragma_loop_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Parser/pragma-loop.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c++11 -verify ${LLVM_SRC}/llvm/tools/clang/test/Parser/pragma-loop.cpp
    RUN("%clang_cc1 -std=c++11 -verify %s");
  }

  @Test
  public void test_pragma_loop_safety_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Parser/pragma-loop-safety.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c++11 -verify ${LLVM_SRC}/llvm/tools/clang/test/Parser/pragma-loop-safety.cpp
    RUN("%clang_cc1 -std=c++11 -verify %s");
  }

  @Test
  public void test_pragma_optimize_diagnostics_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Parser/pragma-optimize-diagnostics.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/Parser/pragma-optimize-diagnostics.cpp
    RUN("%clang_cc1 -fsyntax-only -verify %s");
  }

  @Test
  public void test_pragma_options_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Parser/pragma-options.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i386-apple-darwin9 -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/Parser/pragma-options.c
    RUN("%clang_cc1 -triple i386-apple-darwin9 -fsyntax-only -verify %s");
  }

  @Test
  public void test_pragma_options_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Parser/pragma-options.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i386-apple-darwin9 -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/Parser/pragma-options.cpp
    RUN("%clang_cc1 -triple i386-apple-darwin9 -fsyntax-only -verify %s");
  }

  @Test
  public void test_pragma_pack_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Parser/pragma-pack.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/Parser/pragma-pack.c
    RUN("%clang_cc1 -fsyntax-only -verify %s");
  }

  @Test
  public void test_pragma_unroll_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Parser/pragma-unroll.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c++11 -verify ${LLVM_SRC}/llvm/tools/clang/test/Parser/pragma-unroll.cpp
    RUN("%clang_cc1 -std=c++11 -verify %s");
  }

  @Test
  public void test_pragma_visibility_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Parser/pragma-visibility.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/Parser/pragma-visibility.c
    RUN("%clang_cc1 -fsyntax-only -verify %s");
  }

  @Test
  public void test_pragma_visibility2_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Parser/pragma-visibility2.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm -triple i386-linux-gnu -o ${TEST_TEMP_DIR}/pragma-visibility2.c.tmp ${LLVM_SRC}/llvm/tools/clang/test/Parser/pragma-visibility2.c
    RUN("%clang_cc1 -emit-llvm -triple i386-linux-gnu -o %t %s");
    // ${LLVM_SRC}/build/bin/FileCheck '--input-file=${TEST_TEMP_DIR}/pragma-visibility2.c.tmp' ${LLVM_SRC}/llvm/tools/clang/test/Parser/pragma-visibility2.c
    RUN("FileCheck --input-file=%t %s");
  }

  @Test
  public void test_pragma_weak_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Parser/pragma-weak.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/Parser/pragma-weak.c
    RUN("%clang_cc1 -fsyntax-only -verify %s");
  }

  @Test
  public void test_promote_types_in_proto_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Parser/promote_types_in_proto.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/Parser/promote_types_in_proto.c
    RUN("%clang_cc1 %s");
  }

  @Test
  public void test_recovery_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Parser/recovery.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -pedantic -fblocks ${LLVM_SRC}/llvm/tools/clang/test/Parser/recovery.c
    RUN("%clang_cc1 -fsyntax-only -verify -pedantic -fblocks %s");
  }

  @Test
  public void test_recovery_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Parser/recovery.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -verify -std=c++11 -fms-extensions ${LLVM_SRC}/llvm/tools/clang/test/Parser/recovery.cpp
    RUN("%clang_cc1 -verify -std=c++11 -fms-extensions %s");
  }

  @Test
  public void test_recovery_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Parser/recovery.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -pedantic -fblocks ${LLVM_SRC}/llvm/tools/clang/test/Parser/recovery.m
    RUN("%clang_cc1 -fsyntax-only -verify -pedantic -fblocks %s");
  }

  @Test
  public void test_recursion_limits_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Parser/recursion-limits.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only ${LLVM_SRC}/llvm/tools/clang/test/Parser/recursion-limits.cpp -verify
    RUN("%clang_cc1 -fsyntax-only %s -verify");
  }

  @Test
  public void test_selector_1_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Parser/selector-1.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/Parser/selector-1.m
    RUN("%clang_cc1 -fsyntax-only -verify %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x objective-c++ -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/Parser/selector-1.m
    RUN("%clang_cc1 -x objective-c++ -fsyntax-only -verify %s");
  }

  @Test
  public void test_skip_function_bodies_mm() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Parser/skip-function-bodies.mm");
    // env CINDEXTEST_SKIP_FUNCTION_BODIES=1 c-index-test -test-load-source all ${LLVM_SRC}/llvm/tools/clang/test/Parser/skip-function-bodies.mm | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Parser/skip-function-bodies.mm
    RUN("env CINDEXTEST_SKIP_FUNCTION_BODIES=1 c-index-test -test-load-source all %s")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_statements_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Parser/statements.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/Parser/statements.c -Wno-unreachable-code
    RUN("%clang_cc1 -fsyntax-only -verify %s -Wno-unreachable-code");
  }

  @Test
  public void test_struct_recursion_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Parser/struct-recursion.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/Parser/struct-recursion.c -fsyntax-only
    RUN("%clang_cc1 %s -fsyntax-only");
  }

  @Test
  public void test_switch_recovery_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Parser/switch-recovery.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/Parser/switch-recovery.cpp
    RUN("%clang_cc1 -fsyntax-only -verify %s");
  }

  @Test
  public void test_top_level_semi_cxx0x_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Parser/top-level-semi-cxx0x.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -pedantic -std=c++11 -verify ${LLVM_SRC}/llvm/tools/clang/test/Parser/top-level-semi-cxx0x.cpp
    RUN("%clang_cc1 -fsyntax-only -pedantic -std=c++11 -verify %s");
  }

  @Test
  public void test_traditional_arg_scope_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Parser/traditional_arg_scope.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only ${LLVM_SRC}/llvm/tools/clang/test/Parser/traditional_arg_scope.c -verify
    RUN("%clang_cc1 -fsyntax-only %s -verify");
  }

  @Test
  public void test_typeof_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Parser/typeof.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/Parser/typeof.c
    RUN("%clang_cc1 -fsyntax-only -verify %s");
  }

  @Test
  public void test_types_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Parser/types.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/Parser/types.c -fsyntax-only -verify
    RUN("%clang_cc1 %s -fsyntax-only -verify");
  }

  @Test
  public void test_vsx_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Parser/vsx.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple=powerpc64-unknown-linux-gnu -faltivec -target-feature +vsx -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/Parser/vsx.c
    RUN("%clang_cc1 -triple=powerpc64-unknown-linux-gnu -faltivec -target-feature +vsx -fsyntax-only -verify %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple=powerpc64le-unknown-linux-gnu -faltivec -target-feature +vsx -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/Parser/vsx.c
    RUN("%clang_cc1 -triple=powerpc64le-unknown-linux-gnu -faltivec -target-feature +vsx -fsyntax-only -verify %s");
  }

  @Test
  public void test_warn_cuda_compat_cu() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Parser/warn-cuda-compat.cu");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -Wno-cuda-compat -Werror ${LLVM_SRC}/llvm/tools/clang/test/Parser/warn-cuda-compat.cu
    RUN("%clang_cc1 -Wno-cuda-compat -Werror %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -Wcuda-compat -verify ${LLVM_SRC}/llvm/tools/clang/test/Parser/warn-cuda-compat.cu
    RUN("%clang_cc1 -Wcuda-compat -verify %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x c++ -Wcuda-compat -Werror ${LLVM_SRC}/llvm/tools/clang/test/Parser/warn-cuda-compat.cu
    RUN("%clang_cc1 -x c++ -Wcuda-compat -Werror %s");
  }

  @Test
  public void test_warn_dangling_else_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Parser/warn-dangling-else.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -Wdangling-else ${LLVM_SRC}/llvm/tools/clang/test/Parser/warn-dangling-else.cpp
    RUN("%clang_cc1 -fsyntax-only -verify -Wdangling-else %s");
  }

  @Test // ObjCInterfaceTypeLoc recursion in getFullSize
  public void test_warn_semicolon_before_method_body_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Parser/warn-semicolon-before-method-body.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -Wsemicolon-before-method-body -verify ${LLVM_SRC}/llvm/tools/clang/test/Parser/warn-semicolon-before-method-body.m
    RUN("%clang_cc1 -fsyntax-only -Wsemicolon-before-method-body -verify %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -Wsemicolon-before-method-body -fdiagnostics-parseable-fixits ${LLVM_SRC}/llvm/tools/clang/test/Parser/warn-semicolon-before-method-body.m 2>&1 | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Parser/warn-semicolon-before-method-body.m
    RUN("%clang_cc1 -fsyntax-only -Wsemicolon-before-method-body -fdiagnostics-parseable-fixits %s 2>&1")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_x64_windows_calling_convention_handling_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Parser/x64-windows-calling-convention-handling.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-windows -fms-compatibility -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/Parser/x64-windows-calling-convention-handling.c
    RUN("%clang_cc1 -triple x86_64-windows -fms-compatibility -fsyntax-only -verify %s");
  }
  
}
