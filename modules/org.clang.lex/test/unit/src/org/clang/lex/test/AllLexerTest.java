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
package org.clang.lex.test;

import org.clang.tools.driver.test.DriverTestFileBase;
import org.junit.*;

/**
 * Collection of all test files from test/Lexer folder
 * @author Vladimir Voskresensky
 */
public class AllLexerTest extends DriverTestFileBase {
  private static final String TEST_LOCATION = "${LLVM_SRC}/llvm/tools/clang/test/Lexer/";

  public AllLexerTest() {
    super(TEST_LOCATION, DriverTestFileBase.TestState.Successful);
  }

  public static void main(String[] args) {
    // Print tests which will be accepted per test case
    DriverTestFileBase.printAllTestFiles(false, TEST_LOCATION, (test)->true,
            "${SPUTNIK}/modules/org.clang.lex/test/unit/src/org/clang/lex/test/AllLexerTest.txt");
  }

  @Override
  protected boolean keepStacksForUnimplementedMethods() {
    return false;
  }

  @Test
  public void test_11_27_2007_FloatLiterals_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Lexer/11-27-2007-FloatLiterals.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/Lexer/11-27-2007-FloatLiterals.c -emit-llvm -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Lexer/11-27-2007-FloatLiterals.c
    RUN("%clang_cc1 %s -emit-llvm -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_badstring_in_if0_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Lexer/badstring_in_if0.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -E -verify ${LLVM_SRC}/llvm/tools/clang/test/Lexer/badstring_in_if0.c
    RUN("%clang_cc1 -E -verify %s");
  }

  @Test
  public void test_bcpl_escaped_newline_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Lexer/bcpl-escaped-newline.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -Eonly -ftrigraphs ${LLVM_SRC}/llvm/tools/clang/test/Lexer/bcpl-escaped-newline.c
    RUN("%clang_cc1 -Eonly -ftrigraphs %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -Eonly -verify ${LLVM_SRC}/llvm/tools/clang/test/Lexer/bcpl-escaped-newline.c
    RUN("%clang_cc1 -Eonly -verify %s");
  }

  @Test
  public void test_block_cmt_end_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Lexer/block_cmt_end.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -E -ftrigraphs ${LLVM_SRC}/llvm/tools/clang/test/Lexer/block_cmt_end.c | grep bar
    RUN("%clang_cc1 -E -ftrigraphs %s")./*|*/
      I("grep bar");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -E -ftrigraphs ${LLVM_SRC}/llvm/tools/clang/test/Lexer/block_cmt_end.c | grep foo
    RUN("%clang_cc1 -E -ftrigraphs %s")./*|*/
      I("grep foo");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -E -ftrigraphs ${LLVM_SRC}/llvm/tools/clang/test/Lexer/block_cmt_end.c | not grep qux
    RUN("%clang_cc1 -E -ftrigraphs %s")./*|*/
      I("not grep qux");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -E -ftrigraphs ${LLVM_SRC}/llvm/tools/clang/test/Lexer/block_cmt_end.c | not grep xyz
    RUN("%clang_cc1 -E -ftrigraphs %s")./*|*/
      I("not grep xyz");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -ftrigraphs -verify ${LLVM_SRC}/llvm/tools/clang/test/Lexer/block_cmt_end.c
    RUN("%clang_cc1 -fsyntax-only -ftrigraphs -verify %s");
  }

  @Test
  public void test_builtin_redef_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Lexer/builtin_redef.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/Lexer/builtin_redef.c -D__TIME__=1234 -U__DATE__ -E 2>&1 | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Lexer/builtin_redef.c --check-prefix=CHECK-OUT
    RUN("%clang_cc1 %s -D__TIME__=1234 -U__DATE__ -E 2>&1")./*|*/
      I("FileCheck %s --check-prefix=CHECK-OUT");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/Lexer/builtin_redef.c -D__TIME__=1234 -U__DATE__ -E 2>&1 | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Lexer/builtin_redef.c --check-prefix=CHECK-WARN
    RUN("%clang_cc1 %s -D__TIME__=1234 -U__DATE__ -E 2>&1")./*|*/
      I("FileCheck %s --check-prefix=CHECK-WARN");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/Lexer/builtin_redef.c -D__TIME__=1234 -U__DATE__ -E 2>&1 -pedantic-errors | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Lexer/builtin_redef.c --check-prefix=CHECK-ERR
    RUN("not %clang_cc1 %s -D__TIME__=1234 -U__DATE__ -E 2>&1 -pedantic-errors")./*|*/
      I("FileCheck %s --check-prefix=CHECK-ERR");
  }

  @Test
  public void test_c90_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Lexer/c90.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c90 -fsyntax-only ${LLVM_SRC}/llvm/tools/clang/test/Lexer/c90.c -verify -pedantic-errors
    RUN("%clang_cc1 -std=c90 -fsyntax-only %s -verify -pedantic-errors");
  }

  @Test
  public void test_case_insensitive_include_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Lexer/case-insensitive-include.c");
    // REQUIRES: case-insensitive-filesystem
    if (!CHECK_REQUIRES("case-insensitive-filesystem")) {
      return;
    }
    // mkdir -p ${TEST_TEMP_DIR}/apath
    RUN("mkdir -p %T/apath");
    // mkdir -p ${TEST_TEMP_DIR}/asystempath
    RUN("mkdir -p %T/asystempath");
    // cp ${LLVM_SRC}/llvm/tools/clang/test/Lexer/Inputs/case-insensitive-include.h ${TEST_TEMP_DIR}
    RUN("cp %S/Inputs/case-insensitive-include.h %T");
    // cp ${LLVM_SRC}/llvm/tools/clang/test/Lexer/Inputs/case-insensitive-include.h ${TEST_TEMP_DIR}/asystempath/case-insensitive-include2.h
    RUN("cp %S/Inputs/case-insensitive-include.h %T/asystempath/case-insensitive-include2.h");
    // cd ${TEST_TEMP_DIR}
    RUN("cd %T");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only ${LLVM_SRC}/llvm/tools/clang/test/Lexer/case-insensitive-include.c -include ${LLVM_SRC}/llvm/tools/clang/test/Lexer/case-insensitive-include.c -I ${TEST_TEMP_DIR} -isystem ${TEST_TEMP_DIR}/asystempath -verify
    RUN("%clang_cc1 -fsyntax-only %s -include %s -I %T -isystem %T/asystempath -verify");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -fdiagnostics-parseable-fixits ${LLVM_SRC}/llvm/tools/clang/test/Lexer/case-insensitive-include.c -include ${LLVM_SRC}/llvm/tools/clang/test/Lexer/case-insensitive-include.c -I ${TEST_TEMP_DIR} -isystem ${TEST_TEMP_DIR}/asystempath 2>&1 | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Lexer/case-insensitive-include.c
    RUN("%clang_cc1 -fsyntax-only -fdiagnostics-parseable-fixits %s -include %s -I %T -isystem %T/asystempath 2>&1")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_case_insensitive_include_ms_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Lexer/case-insensitive-include-ms.c");
    // REQUIRES: case-insensitive-filesystem
    if (!CHECK_REQUIRES("case-insensitive-filesystem")) {
      return;
    }
    // mkdir -p ${TEST_TEMP_DIR}/apath
    RUN("mkdir -p %T/apath");
    // cp ${LLVM_SRC}/llvm/tools/clang/test/Lexer/Inputs/case-insensitive-include.h ${TEST_TEMP_DIR}
    RUN("cp %S/Inputs/case-insensitive-include.h %T");
    // cd ${TEST_TEMP_DIR}
    RUN("cd %T");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -fms-compatibility ${LLVM_SRC}/llvm/tools/clang/test/Lexer/case-insensitive-include-ms.c -include ${LLVM_SRC}/llvm/tools/clang/test/Lexer/case-insensitive-include-ms.c -I ${TEST_TEMP_DIR} -verify
    RUN("%clang_cc1 -fsyntax-only -fms-compatibility %s -include %s -I %T -verify");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -fms-compatibility -fdiagnostics-parseable-fixits ${LLVM_SRC}/llvm/tools/clang/test/Lexer/case-insensitive-include-ms.c -include ${LLVM_SRC}/llvm/tools/clang/test/Lexer/case-insensitive-include-ms.c -I ${TEST_TEMP_DIR} 2>&1 | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Lexer/case-insensitive-include-ms.c
    RUN("%clang_cc1 -fsyntax-only -fms-compatibility -fdiagnostics-parseable-fixits %s -include %s -I %T 2>&1")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_case_insensitive_system_include_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Lexer/case-insensitive-system-include.c");
    // REQUIRES: case-insensitive-filesystem
    if (!CHECK_REQUIRES("case-insensitive-filesystem")) {
      return;
    }
    // mkdir -p ${TEST_TEMP_DIR}/asystempath
    RUN("mkdir -p %T/asystempath");
    // cp ${LLVM_SRC}/llvm/tools/clang/test/Lexer/Inputs/case-insensitive-include.h ${TEST_TEMP_DIR}/asystempath/
    RUN("cp %S/Inputs/case-insensitive-include.h %T/asystempath/");
    // cd ${TEST_TEMP_DIR}
    RUN("cd %T");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only ${LLVM_SRC}/llvm/tools/clang/test/Lexer/case-insensitive-system-include.c -include ${LLVM_SRC}/llvm/tools/clang/test/Lexer/case-insensitive-system-include.c -isystem ${TEST_TEMP_DIR}/asystempath -verify -Wnonportable-system-include-path
    RUN("%clang_cc1 -fsyntax-only %s -include %s -isystem %T/asystempath -verify -Wnonportable-system-include-path");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -fdiagnostics-parseable-fixits ${LLVM_SRC}/llvm/tools/clang/test/Lexer/case-insensitive-system-include.c -include ${LLVM_SRC}/llvm/tools/clang/test/Lexer/case-insensitive-system-include.c -isystem ${TEST_TEMP_DIR}/asystempath -Wnonportable-system-include-path 2>&1 | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Lexer/case-insensitive-system-include.c
    RUN("%clang_cc1 -fsyntax-only -fdiagnostics-parseable-fixits %s -include %s -isystem %T/asystempath -Wnonportable-system-include-path 2>&1")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_char_escapes_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Lexer/char-escapes.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -pedantic -verify ${LLVM_SRC}/llvm/tools/clang/test/Lexer/char-escapes.c
    RUN("%clang_cc1 -fsyntax-only -pedantic -verify %s");
  }

  @Test
  public void test_char_literal_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Lexer/char-literal.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-apple-darwin -std=c++11 -Wfour-char-constants -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/Lexer/char-literal.cpp
    RUN("%clang_cc1 -triple x86_64-apple-darwin -std=c++11 -Wfour-char-constants -fsyntax-only -verify %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-apple-darwin -std=c11 -x c -Wfour-char-constants -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/Lexer/char-literal.cpp
    RUN("%clang_cc1 -triple x86_64-apple-darwin -std=c11 -x c -Wfour-char-constants -fsyntax-only -verify %s");
  }

  @Test
  public void test_char_literal_encoding_error_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Lexer/char-literal-encoding-error.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c++11 -fsyntax-only -verify -x c++ ${LLVM_SRC}/llvm/tools/clang/test/Lexer/char-literal-encoding-error.c
    RUN("%clang_cc1 -std=c++11 -fsyntax-only -verify -x c++ %s");
  }

  @Test
  public void test_comment_escape_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Lexer/comment-escape.c");
    // ${LLVM_SRC}/build/bin/clang -fsyntax-only ${LLVM_SRC}/llvm/tools/clang/test/Lexer/comment-escape.c
    RUN("%clang -fsyntax-only %s");
  }

  @Test
  public void test_conflict_marker_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Lexer/conflict-marker.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/Lexer/conflict-marker.c -verify -fsyntax-only
    RUN("%clang_cc1 %s -verify -fsyntax-only");
  }

  @Test
  public void test_constants_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Lexer/constants.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -pedantic -ftrigraphs ${LLVM_SRC}/llvm/tools/clang/test/Lexer/constants.c
    RUN("%clang_cc1 -fsyntax-only -verify -pedantic -ftrigraphs %s");
  }

  @Test
  public void test_coroutines_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Lexer/coroutines.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only ${LLVM_SRC}/llvm/tools/clang/test/Lexer/coroutines.cpp
    RUN("%clang_cc1 -fsyntax-only %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fcoroutines -DCORO -fsyntax-only ${LLVM_SRC}/llvm/tools/clang/test/Lexer/coroutines.cpp
    RUN("%clang_cc1 -fcoroutines -DCORO -fsyntax-only %s");
  }

  @Test
  public void test_counter_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Lexer/counter.c");
    // ${LLVM_SRC}/build/bin/clang -E ${LLVM_SRC}/llvm/tools/clang/test/Lexer/counter.c | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Lexer/counter.c
    RUN("%clang -E %s")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_cross_windows_on_linux_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Lexer/cross-windows-on-linux.cpp");
    // REQUIRES: disabled
    if (!CHECK_REQUIRES("disabled")) {
      return;
    }
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -triple i686-win32 ${LLVM_SRC}/llvm/tools/clang/test/Lexer/cross-windows-on-linux.cpp 2>&1 | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Lexer/cross-windows-on-linux.cpp
    RUN("not %clang_cc1 -fsyntax-only -triple i686-win32 %s 2>&1")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_cross_windows_on_linux_default_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Lexer/cross-windows-on-linux-default.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -fms-compatibility -triple i686-win32 ${LLVM_SRC}/llvm/tools/clang/test/Lexer/cross-windows-on-linux-default.cpp 2>&1 | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Lexer/cross-windows-on-linux-default.cpp
    RUN("not %clang_cc1 -fsyntax-only -fms-compatibility -triple i686-win32 %s 2>&1")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_cxx_features_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Lexer/cxx-features.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c++98 -verify ${LLVM_SRC}/llvm/tools/clang/test/Lexer/cxx-features.cpp
    RUN("%clang_cc1 -std=c++98 -verify %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c++11 -verify ${LLVM_SRC}/llvm/tools/clang/test/Lexer/cxx-features.cpp
    RUN("%clang_cc1 -std=c++11 -verify %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c++1y -fsized-deallocation -verify ${LLVM_SRC}/llvm/tools/clang/test/Lexer/cxx-features.cpp
    RUN("%clang_cc1 -std=c++1y -fsized-deallocation -verify %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c++14 -fsized-deallocation -verify ${LLVM_SRC}/llvm/tools/clang/test/Lexer/cxx-features.cpp
    RUN("%clang_cc1 -std=c++14 -fsized-deallocation -verify %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c++1z -fsized-deallocation -verify ${LLVM_SRC}/llvm/tools/clang/test/Lexer/cxx-features.cpp
    RUN("%clang_cc1 -std=c++1z -fsized-deallocation -verify %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c++1z -fsized-deallocation -fconcepts-ts -DCONCEPTS_TS=1 -verify ${LLVM_SRC}/llvm/tools/clang/test/Lexer/cxx-features.cpp
    RUN("%clang_cc1 -std=c++1z -fsized-deallocation -fconcepts-ts -DCONCEPTS_TS=1 -verify %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fcoroutines -DCOROUTINES -verify ${LLVM_SRC}/llvm/tools/clang/test/Lexer/cxx-features.cpp
    RUN("%clang_cc1 -fcoroutines -DCOROUTINES -verify %s");
  }

  @Test
  public void test_cxx0x_keyword_as_cxx98_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Lexer/cxx0x_keyword_as_cxx98.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/Lexer/cxx0x_keyword_as_cxx98.cpp -verify -fsyntax-only -Wc++11-compat -std=c++98
    RUN("%clang_cc1 %s -verify -fsyntax-only -Wc++11-compat -std=c++98");
  }

  @Test
  public void test_cxx0x_raw_string_delim_length_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Lexer/cxx0x_raw_string_delim_length.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c++11 -verify ${LLVM_SRC}/llvm/tools/clang/test/Lexer/cxx0x_raw_string_delim_length.cpp
    RUN("%clang_cc1 -std=c++11 -verify %s");
  }

  @Test
  public void test_cxx0x_raw_string_directives_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Lexer/cxx0x_raw_string_directives.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c++11 -fsyntax-only ${LLVM_SRC}/llvm/tools/clang/test/Lexer/cxx0x_raw_string_directives.cpp
    RUN("%clang_cc1 -std=c++11 -fsyntax-only %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c++98 -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/Lexer/cxx0x_raw_string_directives.cpp
    RUN("%clang_cc1 -std=c++98 -fsyntax-only -verify %s");
  }

  @Test
  public void test_cxx0x_raw_string_unterminated_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Lexer/cxx0x_raw_string_unterminated.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c++11 -E ${LLVM_SRC}/llvm/tools/clang/test/Lexer/cxx0x_raw_string_unterminated.cpp 2>&1 | grep 'error: raw string missing terminating delimiter )foo"'
    RUN("not %clang_cc1 -std=c++11 -E %s 2>&1")./*|*/
      I("grep 'error: raw string missing terminating delimiter )foo\"'");
  }

  @Test
  public void test_cxx1y_binary_literal_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Lexer/cxx1y_binary_literal.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c++1y ${LLVM_SRC}/llvm/tools/clang/test/Lexer/cxx1y_binary_literal.cpp -verify
    RUN("%clang_cc1 -std=c++1y %s -verify");
  }

  @Test
  public void test_cxx1y_digit_separators_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Lexer/cxx1y_digit_separators.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c++1y -verify ${LLVM_SRC}/llvm/tools/clang/test/Lexer/cxx1y_digit_separators.cpp
    RUN("%clang_cc1 -std=c++1y -verify %s");
  }

  @Test
  public void test_cxx1z_trigraphs_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Lexer/cxx1z-trigraphs.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c++1z ${LLVM_SRC}/llvm/tools/clang/test/Lexer/cxx1z-trigraphs.cpp -verify
    RUN("%clang_cc1 -std=c++1z %s -verify");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c++1z ${LLVM_SRC}/llvm/tools/clang/test/Lexer/cxx1z-trigraphs.cpp -ftrigraphs -fsyntax-only
    RUN("%clang_cc1 -std=c++1z %s -ftrigraphs -fsyntax-only");
  }

  @Test
  public void test_digraph_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Lexer/digraph.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -ffreestanding ${LLVM_SRC}/llvm/tools/clang/test/Lexer/digraph.c
    RUN("%clang_cc1 -fsyntax-only -verify -ffreestanding %s");
  }

  @Test
  public void test_dollar_idents_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Lexer/dollar-idents.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -dump-tokens ${LLVM_SRC}/llvm/tools/clang/test/Lexer/dollar-idents.c 2>&1 | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Lexer/dollar-idents.c
    RUN("%clang_cc1 -dump-tokens %s 2>&1")./*|*/
      I("FileCheck %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -dump-tokens -x assembler-with-cpp ${LLVM_SRC}/llvm/tools/clang/test/Lexer/dollar-idents.c 2>&1 | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Lexer/dollar-idents.c --check-prefix=CHECK-ASM
    RUN("%clang_cc1 -dump-tokens -x assembler-with-cpp %s 2>&1")./*|*/
      I("FileCheck %s --check-prefix=CHECK-ASM");
  }

  @Test
  public void test_eof_char_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Lexer/eof-char.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/Lexer/eof-char.c -verify -fsyntax-only
    RUN("%clang_cc1 %s -verify -fsyntax-only");
  }

  @Test
  public void test_eof_conflict_marker_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Lexer/eof-conflict-marker.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/Lexer/eof-conflict-marker.c -verify -fsyntax-only
    RUN("%clang_cc1 %s -verify -fsyntax-only");
  }

  @Test
  public void test_eof_file_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Lexer/eof-file.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/Lexer/eof-file.c -verify -fsyntax-only
    RUN("%clang_cc1 %s -verify -fsyntax-only");
  }

  @Test
  public void test_eof_include_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Lexer/eof-include.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/Lexer/eof-include.c -verify
    RUN("%clang_cc1 %s -verify");
  }

  @Test
  public void test_eof_number_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Lexer/eof-number.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/Lexer/eof-number.c -verify -fsyntax-only -Wnewline-eof
    RUN("%clang_cc1 %s -verify -fsyntax-only -Wnewline-eof");
  }

  @Test
  public void test_eof_string_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Lexer/eof-string.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/Lexer/eof-string.c -verify -fsyntax-only
    RUN("%clang_cc1 %s -verify -fsyntax-only");
  }

  @Test
  public void test_escape_newline_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Lexer/escape_newline.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -E -ftrigraphs ${LLVM_SRC}/llvm/tools/clang/test/Lexer/escape_newline.c | grep -- ' ->'
    RUN("%clang_cc1 -E -ftrigraphs %s")./*|*/
      I("grep -- ' ->'");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -E -ftrigraphs ${LLVM_SRC}/llvm/tools/clang/test/Lexer/escape_newline.c 2>&1 | grep 'backslash and newline separated by space'
    RUN("%clang_cc1 -E -ftrigraphs %s 2>&1")./*|*/
      I("grep 'backslash and newline separated by space'");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -E -ftrigraphs ${LLVM_SRC}/llvm/tools/clang/test/Lexer/escape_newline.c 2>&1 | grep 'trigraph converted'
    RUN("%clang_cc1 -E -ftrigraphs %s 2>&1")./*|*/
      I("grep 'trigraph converted'");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -E -CC -ftrigraphs ${LLVM_SRC}/llvm/tools/clang/test/Lexer/escape_newline.c
    RUN("%clang_cc1 -E -CC -ftrigraphs %s");
  }

  @Test
  public void test_gnu_flags_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Lexer/gnu-flags.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/Lexer/gnu-flags.c -DNONE
    RUN("%clang_cc1 -fsyntax-only -verify %s -DNONE");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/Lexer/gnu-flags.c -DALL -Wgnu
    RUN("%clang_cc1 -fsyntax-only -verify %s -DALL -Wgnu");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/Lexer/gnu-flags.c -DALL -Wgnu-zero-variadic-macro-arguments -Wgnu-imaginary-constant -Wgnu-binary-literal -Wgnu-zero-line-directive
    RUN("%clang_cc1 -fsyntax-only -verify %s -DALL -Wgnu-zero-variadic-macro-arguments -Wgnu-imaginary-constant -Wgnu-binary-literal -Wgnu-zero-line-directive");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/Lexer/gnu-flags.c -DNONE -Wgnu -Wno-gnu-zero-variadic-macro-arguments -Wno-gnu-imaginary-constant -Wno-gnu-binary-literal -Wno-gnu-zero-line-directive
    RUN("%clang_cc1 -fsyntax-only -verify %s -DNONE -Wgnu -Wno-gnu-zero-variadic-macro-arguments -Wno-gnu-imaginary-constant -Wno-gnu-binary-literal -Wno-gnu-zero-line-directive");
  }

  @Test
  public void test_half_literal_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Lexer/half-literal.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -pedantic ${LLVM_SRC}/llvm/tools/clang/test/Lexer/half-literal.cpp
    RUN("%clang_cc1 -fsyntax-only -verify -pedantic %s");
  }

  @Test
  public void test_has_attribute_objc_boxable_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Lexer/has_attribute_objc_boxable.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -E ${LLVM_SRC}/llvm/tools/clang/test/Lexer/has_attribute_objc_boxable.m -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Lexer/has_attribute_objc_boxable.m
    RUN("%clang_cc1 -E %s -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_has_extension_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Lexer/has_extension.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c99 -E ${LLVM_SRC}/llvm/tools/clang/test/Lexer/has_extension.c -o - | ${LLVM_SRC}/build/bin/FileCheck --check-prefix=CHECK-PED-NONE ${LLVM_SRC}/llvm/tools/clang/test/Lexer/has_extension.c
    RUN("%clang_cc1 -std=c99 -E %s -o -")./*|*/
      I("FileCheck --check-prefix=CHECK-PED-NONE %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c99 -pedantic-errors -E ${LLVM_SRC}/llvm/tools/clang/test/Lexer/has_extension.c -o - | ${LLVM_SRC}/build/bin/FileCheck --check-prefix=CHECK-PED-ERR ${LLVM_SRC}/llvm/tools/clang/test/Lexer/has_extension.c
    RUN("%clang_cc1 -std=c99 -pedantic-errors -E %s -o -")./*|*/
      I("FileCheck --check-prefix=CHECK-PED-ERR %s");
  }

  @Test
  public void test_has_extension_cxx_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Lexer/has_extension_cxx.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c++98 -E ${LLVM_SRC}/llvm/tools/clang/test/Lexer/has_extension_cxx.cpp -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Lexer/has_extension_cxx.cpp
    RUN("%clang_cc1 -std=c++98 -E %s -o -")./*|*/
      I("FileCheck %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c++11 -E ${LLVM_SRC}/llvm/tools/clang/test/Lexer/has_extension_cxx.cpp -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Lexer/has_extension_cxx.cpp --check-prefix=CHECK11
    RUN("%clang_cc1 -std=c++11 -E %s -o -")./*|*/
      I("FileCheck %s --check-prefix=CHECK11");
  }

  @Test
  public void test_has_feature_address_sanitizer_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Lexer/has_feature_address_sanitizer.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -E -fsanitize=address ${LLVM_SRC}/llvm/tools/clang/test/Lexer/has_feature_address_sanitizer.cpp -o - | ${LLVM_SRC}/build/bin/FileCheck --check-prefix=CHECK-ASAN ${LLVM_SRC}/llvm/tools/clang/test/Lexer/has_feature_address_sanitizer.cpp
    RUN("%clang_cc1 -E -fsanitize=address %s -o -")./*|*/
      I("FileCheck --check-prefix=CHECK-ASAN %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -E -fsanitize=kernel-address ${LLVM_SRC}/llvm/tools/clang/test/Lexer/has_feature_address_sanitizer.cpp -o - | ${LLVM_SRC}/build/bin/FileCheck --check-prefix=CHECK-ASAN ${LLVM_SRC}/llvm/tools/clang/test/Lexer/has_feature_address_sanitizer.cpp
    RUN("%clang_cc1 -E -fsanitize=kernel-address %s -o -")./*|*/
      I("FileCheck --check-prefix=CHECK-ASAN %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -E ${LLVM_SRC}/llvm/tools/clang/test/Lexer/has_feature_address_sanitizer.cpp -o - | ${LLVM_SRC}/build/bin/FileCheck --check-prefix=CHECK-NO-ASAN ${LLVM_SRC}/llvm/tools/clang/test/Lexer/has_feature_address_sanitizer.cpp
    RUN("%clang_cc1 -E  %s -o -")./*|*/
      I("FileCheck --check-prefix=CHECK-NO-ASAN %s");
  }

  @Test
  public void test_has_feature_boxed_nsvalue_expressions_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Lexer/has_feature_boxed_nsvalue_expressions.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -E ${LLVM_SRC}/llvm/tools/clang/test/Lexer/has_feature_boxed_nsvalue_expressions.m -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Lexer/has_feature_boxed_nsvalue_expressions.m
    RUN("%clang_cc1 -E %s -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_has_feature_c1x_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Lexer/has_feature_c1x.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -E -triple x86_64-linux-gnu -std=c89 ${LLVM_SRC}/llvm/tools/clang/test/Lexer/has_feature_c1x.c -o - | ${LLVM_SRC}/build/bin/FileCheck --check-prefix=CHECK-NO-1X ${LLVM_SRC}/llvm/tools/clang/test/Lexer/has_feature_c1x.c
    RUN("%clang_cc1 -E -triple x86_64-linux-gnu -std=c89 %s -o -")./*|*/
      I("FileCheck --check-prefix=CHECK-NO-1X %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -E -triple x86_64-linux-gnu -std=iso9899:199409 ${LLVM_SRC}/llvm/tools/clang/test/Lexer/has_feature_c1x.c -o - | ${LLVM_SRC}/build/bin/FileCheck --check-prefix=CHECK-NO-1X ${LLVM_SRC}/llvm/tools/clang/test/Lexer/has_feature_c1x.c
    RUN("%clang_cc1 -E -triple x86_64-linux-gnu -std=iso9899:199409 %s -o -")./*|*/
      I("FileCheck --check-prefix=CHECK-NO-1X %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -E -triple x86_64-linux-gnu -std=c99 ${LLVM_SRC}/llvm/tools/clang/test/Lexer/has_feature_c1x.c -o - | ${LLVM_SRC}/build/bin/FileCheck --check-prefix=CHECK-NO-1X ${LLVM_SRC}/llvm/tools/clang/test/Lexer/has_feature_c1x.c
    RUN("%clang_cc1 -E -triple x86_64-linux-gnu -std=c99 %s -o -")./*|*/
      I("FileCheck --check-prefix=CHECK-NO-1X %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -E -triple x86_64-linux-gnu -std=c11 ${LLVM_SRC}/llvm/tools/clang/test/Lexer/has_feature_c1x.c -o - | ${LLVM_SRC}/build/bin/FileCheck --check-prefix=CHECK-1X ${LLVM_SRC}/llvm/tools/clang/test/Lexer/has_feature_c1x.c
    RUN("%clang_cc1 -E -triple x86_64-linux-gnu -std=c11 %s -o -")./*|*/
      I("FileCheck --check-prefix=CHECK-1X %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -E -triple x86_64-linux-gnu -std=gnu89 ${LLVM_SRC}/llvm/tools/clang/test/Lexer/has_feature_c1x.c -o - | ${LLVM_SRC}/build/bin/FileCheck --check-prefix=CHECK-NO-1X ${LLVM_SRC}/llvm/tools/clang/test/Lexer/has_feature_c1x.c
    RUN("%clang_cc1 -E -triple x86_64-linux-gnu -std=gnu89 %s -o -")./*|*/
      I("FileCheck --check-prefix=CHECK-NO-1X %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -E -triple x86_64-linux-gnu -std=gnu99 ${LLVM_SRC}/llvm/tools/clang/test/Lexer/has_feature_c1x.c -o - | ${LLVM_SRC}/build/bin/FileCheck --check-prefix=CHECK-NO-1X ${LLVM_SRC}/llvm/tools/clang/test/Lexer/has_feature_c1x.c
    RUN("%clang_cc1 -E -triple x86_64-linux-gnu -std=gnu99 %s -o -")./*|*/
      I("FileCheck --check-prefix=CHECK-NO-1X %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -E -triple x86_64-linux-gnu -std=gnu11 ${LLVM_SRC}/llvm/tools/clang/test/Lexer/has_feature_c1x.c -o - | ${LLVM_SRC}/build/bin/FileCheck --check-prefix=CHECK-1X ${LLVM_SRC}/llvm/tools/clang/test/Lexer/has_feature_c1x.c
    RUN("%clang_cc1 -E -triple x86_64-linux-gnu -std=gnu11 %s -o -")./*|*/
      I("FileCheck --check-prefix=CHECK-1X %s");
  }

  @Test
  public void test_has_feature_cxx0x_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Lexer/has_feature_cxx0x.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -E -triple x86_64-linux-gnu -std=c++11 ${LLVM_SRC}/llvm/tools/clang/test/Lexer/has_feature_cxx0x.cpp -o - | ${LLVM_SRC}/build/bin/FileCheck --check-prefix=CHECK-11 ${LLVM_SRC}/llvm/tools/clang/test/Lexer/has_feature_cxx0x.cpp
    RUN("%clang_cc1 -E -triple x86_64-linux-gnu -std=c++11 %s -o -")./*|*/
      I("FileCheck --check-prefix=CHECK-11 %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -E -triple armv7-apple-darwin -std=c++11 ${LLVM_SRC}/llvm/tools/clang/test/Lexer/has_feature_cxx0x.cpp -o - | ${LLVM_SRC}/build/bin/FileCheck --check-prefix=CHECK-NO-TLS ${LLVM_SRC}/llvm/tools/clang/test/Lexer/has_feature_cxx0x.cpp
    RUN("%clang_cc1 -E -triple armv7-apple-darwin -std=c++11 %s -o -")./*|*/
      I("FileCheck --check-prefix=CHECK-NO-TLS %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -E -triple x86_64-linux-gnu -std=c++98 ${LLVM_SRC}/llvm/tools/clang/test/Lexer/has_feature_cxx0x.cpp -o - | ${LLVM_SRC}/build/bin/FileCheck --check-prefix=CHECK-NO-11 ${LLVM_SRC}/llvm/tools/clang/test/Lexer/has_feature_cxx0x.cpp
    RUN("%clang_cc1 -E -triple x86_64-linux-gnu -std=c++98 %s -o -")./*|*/
      I("FileCheck --check-prefix=CHECK-NO-11 %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -E -triple x86_64-linux-gnu -std=c++14 ${LLVM_SRC}/llvm/tools/clang/test/Lexer/has_feature_cxx0x.cpp -o - | ${LLVM_SRC}/build/bin/FileCheck --check-prefix=CHECK-14 ${LLVM_SRC}/llvm/tools/clang/test/Lexer/has_feature_cxx0x.cpp
    RUN("%clang_cc1 -E -triple x86_64-linux-gnu -std=c++14 %s -o -")./*|*/
      I("FileCheck --check-prefix=CHECK-14 %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -E -triple x86_64-linux-gnu -std=c++1z ${LLVM_SRC}/llvm/tools/clang/test/Lexer/has_feature_cxx0x.cpp -o - | ${LLVM_SRC}/build/bin/FileCheck --check-prefix=CHECK-1Z ${LLVM_SRC}/llvm/tools/clang/test/Lexer/has_feature_cxx0x.cpp
    RUN("%clang_cc1 -E -triple x86_64-linux-gnu -std=c++1z %s -o -")./*|*/
      I("FileCheck --check-prefix=CHECK-1Z %s");
  }

  @Test
  public void test_has_feature_efficiency_sanitizer_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Lexer/has_feature_efficiency_sanitizer.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -E -fsanitize=efficiency-cache-frag ${LLVM_SRC}/llvm/tools/clang/test/Lexer/has_feature_efficiency_sanitizer.cpp -o - | ${LLVM_SRC}/build/bin/FileCheck --check-prefix=CHECK-ESAN ${LLVM_SRC}/llvm/tools/clang/test/Lexer/has_feature_efficiency_sanitizer.cpp
    RUN("%clang_cc1 -E -fsanitize=efficiency-cache-frag %s -o -")./*|*/
      I("FileCheck --check-prefix=CHECK-ESAN %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -E -fsanitize=efficiency-working-set ${LLVM_SRC}/llvm/tools/clang/test/Lexer/has_feature_efficiency_sanitizer.cpp -o - | ${LLVM_SRC}/build/bin/FileCheck --check-prefix=CHECK-ESAN ${LLVM_SRC}/llvm/tools/clang/test/Lexer/has_feature_efficiency_sanitizer.cpp
    RUN("%clang_cc1 -E -fsanitize=efficiency-working-set %s -o -")./*|*/
      I("FileCheck --check-prefix=CHECK-ESAN %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -E ${LLVM_SRC}/llvm/tools/clang/test/Lexer/has_feature_efficiency_sanitizer.cpp -o - | ${LLVM_SRC}/build/bin/FileCheck --check-prefix=CHECK-NO-ESAN ${LLVM_SRC}/llvm/tools/clang/test/Lexer/has_feature_efficiency_sanitizer.cpp
    RUN("%clang_cc1 -E  %s -o -")./*|*/
      I("FileCheck --check-prefix=CHECK-NO-ESAN %s");
  }

  @Test
  public void test_has_feature_exceptions_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Lexer/has_feature_exceptions.cpp");
    // ${LLVM_SRC}/build/bin/clang -E -fexceptions ${LLVM_SRC}/llvm/tools/clang/test/Lexer/has_feature_exceptions.cpp -o - | ${LLVM_SRC}/build/bin/FileCheck --check-prefix=CHECK-EXCEPTIONS ${LLVM_SRC}/llvm/tools/clang/test/Lexer/has_feature_exceptions.cpp
    RUN("%clang -E -fexceptions %s -o -")./*|*/
      I("FileCheck --check-prefix=CHECK-EXCEPTIONS %s");
    // ${LLVM_SRC}/build/bin/clang -E -fexceptions -fno-cxx-exceptions ${LLVM_SRC}/llvm/tools/clang/test/Lexer/has_feature_exceptions.cpp -o - | ${LLVM_SRC}/build/bin/FileCheck --check-prefix=CHECK-NO-EXCEPTIONS ${LLVM_SRC}/llvm/tools/clang/test/Lexer/has_feature_exceptions.cpp
    RUN("%clang -E -fexceptions -fno-cxx-exceptions %s -o -")./*|*/
      I("FileCheck --check-prefix=CHECK-NO-EXCEPTIONS %s");
    // ${LLVM_SRC}/build/bin/clang -E -fno-exceptions ${LLVM_SRC}/llvm/tools/clang/test/Lexer/has_feature_exceptions.cpp -o - | ${LLVM_SRC}/build/bin/FileCheck --check-prefix=CHECK-NO-EXCEPTIONS ${LLVM_SRC}/llvm/tools/clang/test/Lexer/has_feature_exceptions.cpp
    RUN("%clang -E -fno-exceptions %s -o -")./*|*/
      I("FileCheck --check-prefix=CHECK-NO-EXCEPTIONS %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -E -fcxx-exceptions ${LLVM_SRC}/llvm/tools/clang/test/Lexer/has_feature_exceptions.cpp -o - | ${LLVM_SRC}/build/bin/FileCheck --check-prefix=CHECK-EXCEPTIONS ${LLVM_SRC}/llvm/tools/clang/test/Lexer/has_feature_exceptions.cpp
    RUN("%clang_cc1 -E -fcxx-exceptions %s -o -")./*|*/
      I("FileCheck --check-prefix=CHECK-EXCEPTIONS %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -E -fobjc-exceptions ${LLVM_SRC}/llvm/tools/clang/test/Lexer/has_feature_exceptions.cpp -o - | ${LLVM_SRC}/build/bin/FileCheck --check-prefix=CHECK-NO-EXCEPTIONS ${LLVM_SRC}/llvm/tools/clang/test/Lexer/has_feature_exceptions.cpp
    RUN("%clang_cc1 -E -fobjc-exceptions %s -o -")./*|*/
      I("FileCheck --check-prefix=CHECK-NO-EXCEPTIONS %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -E -fexceptions ${LLVM_SRC}/llvm/tools/clang/test/Lexer/has_feature_exceptions.cpp -o - | ${LLVM_SRC}/build/bin/FileCheck --check-prefix=CHECK-NO-EXCEPTIONS ${LLVM_SRC}/llvm/tools/clang/test/Lexer/has_feature_exceptions.cpp
    RUN("%clang_cc1 -E -fexceptions %s -o -")./*|*/
      I("FileCheck --check-prefix=CHECK-NO-EXCEPTIONS %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -E ${LLVM_SRC}/llvm/tools/clang/test/Lexer/has_feature_exceptions.cpp -o - | ${LLVM_SRC}/build/bin/FileCheck --check-prefix=CHECK-NO-EXCEPTIONS ${LLVM_SRC}/llvm/tools/clang/test/Lexer/has_feature_exceptions.cpp
    RUN("%clang_cc1 -E %s -o -")./*|*/
      I("FileCheck --check-prefix=CHECK-NO-EXCEPTIONS %s");
  }

  @Test
  public void test_has_feature_memory_sanitizer_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Lexer/has_feature_memory_sanitizer.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -E -fsanitize=memory ${LLVM_SRC}/llvm/tools/clang/test/Lexer/has_feature_memory_sanitizer.cpp -o - | ${LLVM_SRC}/build/bin/FileCheck --check-prefix=CHECK-MSAN ${LLVM_SRC}/llvm/tools/clang/test/Lexer/has_feature_memory_sanitizer.cpp
    RUN("%clang_cc1 -E -fsanitize=memory %s -o -")./*|*/
      I("FileCheck --check-prefix=CHECK-MSAN %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -E ${LLVM_SRC}/llvm/tools/clang/test/Lexer/has_feature_memory_sanitizer.cpp -o - | ${LLVM_SRC}/build/bin/FileCheck --check-prefix=CHECK-NO-MSAN ${LLVM_SRC}/llvm/tools/clang/test/Lexer/has_feature_memory_sanitizer.cpp
    RUN("%clang_cc1 -E  %s -o -")./*|*/
      I("FileCheck --check-prefix=CHECK-NO-MSAN %s");
  }

  @Test
  public void test_has_feature_modules_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Lexer/has_feature_modules.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -E -fmodules ${LLVM_SRC}/llvm/tools/clang/test/Lexer/has_feature_modules.m -o - | ${LLVM_SRC}/build/bin/FileCheck --check-prefix=CHECK-HAS-OBJC-MODULES ${LLVM_SRC}/llvm/tools/clang/test/Lexer/has_feature_modules.m
    RUN("%clang_cc1 -E -fmodules %s -o -")./*|*/
      I("FileCheck --check-prefix=CHECK-HAS-OBJC-MODULES %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -E ${LLVM_SRC}/llvm/tools/clang/test/Lexer/has_feature_modules.m -o - | ${LLVM_SRC}/build/bin/FileCheck --check-prefix=CHECK-NO-OBJC-MODULES ${LLVM_SRC}/llvm/tools/clang/test/Lexer/has_feature_modules.m
    RUN("%clang_cc1 -E %s -o -")./*|*/
      I("FileCheck --check-prefix=CHECK-NO-OBJC-MODULES %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -E -x c -fmodules ${LLVM_SRC}/llvm/tools/clang/test/Lexer/has_feature_modules.m -o - | ${LLVM_SRC}/build/bin/FileCheck --check-prefix=CHECK-NO-OBJC-MODULES ${LLVM_SRC}/llvm/tools/clang/test/Lexer/has_feature_modules.m
    RUN("%clang_cc1 -E -x c -fmodules %s -o -")./*|*/
      I("FileCheck --check-prefix=CHECK-NO-OBJC-MODULES %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -E -fmodules ${LLVM_SRC}/llvm/tools/clang/test/Lexer/has_feature_modules.m -o - | ${LLVM_SRC}/build/bin/FileCheck --check-prefix=CHECK-HAS-MODULES ${LLVM_SRC}/llvm/tools/clang/test/Lexer/has_feature_modules.m
    RUN("%clang_cc1 -E -fmodules %s -o -")./*|*/
      I("FileCheck --check-prefix=CHECK-HAS-MODULES %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -E ${LLVM_SRC}/llvm/tools/clang/test/Lexer/has_feature_modules.m -o - | ${LLVM_SRC}/build/bin/FileCheck --check-prefix=CHECK-NO-MODULES ${LLVM_SRC}/llvm/tools/clang/test/Lexer/has_feature_modules.m
    RUN("%clang_cc1 -E %s -o -")./*|*/
      I("FileCheck --check-prefix=CHECK-NO-MODULES %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -E -x c -fmodules ${LLVM_SRC}/llvm/tools/clang/test/Lexer/has_feature_modules.m -o - | ${LLVM_SRC}/build/bin/FileCheck --check-prefix=CHECK-HAS-MODULES ${LLVM_SRC}/llvm/tools/clang/test/Lexer/has_feature_modules.m
    RUN("%clang_cc1 -E -x c -fmodules %s -o -")./*|*/
      I("FileCheck --check-prefix=CHECK-HAS-MODULES %s");
  }

  @Test
  public void test_has_feature_objc_arc_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Lexer/has_feature_objc_arc.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -E ${LLVM_SRC}/llvm/tools/clang/test/Lexer/has_feature_objc_arc.m -fobjc-arc -triple x86_64-apple-macosx10.7.0 -fobjc-runtime-has-weak | ${LLVM_SRC}/build/bin/FileCheck --check-prefix=CHECK-ARC ${LLVM_SRC}/llvm/tools/clang/test/Lexer/has_feature_objc_arc.m
    RUN("%clang_cc1 -E %s -fobjc-arc \"-triple\" \"x86_64-apple-macosx10.7.0\"  -fobjc-runtime-has-weak")./*|*/
      I("FileCheck --check-prefix=CHECK-ARC %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -E ${LLVM_SRC}/llvm/tools/clang/test/Lexer/has_feature_objc_arc.m -fobjc-arc -triple x86_64-apple-macosx10.6.0 | ${LLVM_SRC}/build/bin/FileCheck --check-prefix=CHECK-ARCLITE ${LLVM_SRC}/llvm/tools/clang/test/Lexer/has_feature_objc_arc.m
    RUN("%clang_cc1 -E %s -fobjc-arc \"-triple\" \"x86_64-apple-macosx10.6.0\"")./*|*/
      I("FileCheck --check-prefix=CHECK-ARCLITE %s");
  }

  @Test
  public void test_has_feature_rtti_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Lexer/has_feature_rtti.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -E ${LLVM_SRC}/llvm/tools/clang/test/Lexer/has_feature_rtti.cpp -o - | ${LLVM_SRC}/build/bin/FileCheck --check-prefix=CHECK-RTTI ${LLVM_SRC}/llvm/tools/clang/test/Lexer/has_feature_rtti.cpp
    RUN("%clang_cc1 -E %s -o -")./*|*/
      I("FileCheck --check-prefix=CHECK-RTTI %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -E -fno-rtti ${LLVM_SRC}/llvm/tools/clang/test/Lexer/has_feature_rtti.cpp -o - | ${LLVM_SRC}/build/bin/FileCheck --check-prefix=CHECK-NO-RTTI ${LLVM_SRC}/llvm/tools/clang/test/Lexer/has_feature_rtti.cpp
    RUN("%clang_cc1 -E -fno-rtti %s -o -")./*|*/
      I("FileCheck --check-prefix=CHECK-NO-RTTI %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -E -fno-rtti-data ${LLVM_SRC}/llvm/tools/clang/test/Lexer/has_feature_rtti.cpp -o - | ${LLVM_SRC}/build/bin/FileCheck --check-prefix=CHECK-NO-RTTI ${LLVM_SRC}/llvm/tools/clang/test/Lexer/has_feature_rtti.cpp
    RUN("%clang_cc1 -E -fno-rtti-data %s -o -")./*|*/
      I("FileCheck --check-prefix=CHECK-NO-RTTI %s");
  }

  @Test
  public void test_has_feature_thread_sanitizer_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Lexer/has_feature_thread_sanitizer.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -E -fsanitize=thread ${LLVM_SRC}/llvm/tools/clang/test/Lexer/has_feature_thread_sanitizer.cpp -o - | ${LLVM_SRC}/build/bin/FileCheck --check-prefix=CHECK-TSAN ${LLVM_SRC}/llvm/tools/clang/test/Lexer/has_feature_thread_sanitizer.cpp
    RUN("%clang_cc1 -E -fsanitize=thread %s -o -")./*|*/
      I("FileCheck --check-prefix=CHECK-TSAN %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -E ${LLVM_SRC}/llvm/tools/clang/test/Lexer/has_feature_thread_sanitizer.cpp -o - | ${LLVM_SRC}/build/bin/FileCheck --check-prefix=CHECK-NO-TSAN ${LLVM_SRC}/llvm/tools/clang/test/Lexer/has_feature_thread_sanitizer.cpp
    RUN("%clang_cc1 -E  %s -o -")./*|*/
      I("FileCheck --check-prefix=CHECK-NO-TSAN %s");
  }

  @Test
  public void test_has_feature_type_traits_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Lexer/has_feature_type_traits.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -E ${LLVM_SRC}/llvm/tools/clang/test/Lexer/has_feature_type_traits.cpp -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Lexer/has_feature_type_traits.cpp
    RUN("%clang_cc1 -E %s -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_header_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Lexer/header.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -Wno-header-guard ${LLVM_SRC}/llvm/tools/clang/test/Lexer/header.cpp
    RUN("%clang_cc1 -fsyntax-only -Wno-header-guard %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -Wheader-guard ${LLVM_SRC}/llvm/tools/clang/test/Lexer/header.cpp 2>&1 | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Lexer/header.cpp
    RUN("%clang_cc1 -fsyntax-only -Wheader-guard %s 2>&1")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_hexfloat_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Lexer/hexfloat.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c++98 -fsyntax-only -verify -pedantic ${LLVM_SRC}/llvm/tools/clang/test/Lexer/hexfloat.cpp
    RUN("%clang_cc1 -std=c++98 -fsyntax-only -verify -pedantic %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c++11 -fsyntax-only -verify -pedantic ${LLVM_SRC}/llvm/tools/clang/test/Lexer/hexfloat.cpp
    RUN("%clang_cc1 -std=c++11 -fsyntax-only -verify -pedantic %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c++14 -fsyntax-only -verify -pedantic ${LLVM_SRC}/llvm/tools/clang/test/Lexer/hexfloat.cpp
    RUN("%clang_cc1 -std=c++14 -fsyntax-only -verify -pedantic %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c++1z -fsyntax-only -verify -pedantic ${LLVM_SRC}/llvm/tools/clang/test/Lexer/hexfloat.cpp
    RUN("%clang_cc1 -std=c++1z -fsyntax-only -verify -pedantic %s");
  }

  @Test
  public void test_keywords_test_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Lexer/keywords_test.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c99 -E ${LLVM_SRC}/llvm/tools/clang/test/Lexer/keywords_test.c -o - | ${LLVM_SRC}/build/bin/FileCheck --check-prefix=CHECK-NONE ${LLVM_SRC}/llvm/tools/clang/test/Lexer/keywords_test.c
    RUN("%clang_cc1 -std=c99 -E %s -o -")./*|*/
      I("FileCheck --check-prefix=CHECK-NONE %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=gnu89 -E ${LLVM_SRC}/llvm/tools/clang/test/Lexer/keywords_test.c -o - | ${LLVM_SRC}/build/bin/FileCheck --check-prefix=CHECK-GNU-KEYWORDS ${LLVM_SRC}/llvm/tools/clang/test/Lexer/keywords_test.c
    RUN("%clang_cc1 -std=gnu89 -E %s -o -")./*|*/
      I("FileCheck --check-prefix=CHECK-GNU-KEYWORDS %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c99 -fgnu-keywords -E ${LLVM_SRC}/llvm/tools/clang/test/Lexer/keywords_test.c -o - | ${LLVM_SRC}/build/bin/FileCheck --check-prefix=CHECK-GNU-KEYWORDS ${LLVM_SRC}/llvm/tools/clang/test/Lexer/keywords_test.c
    RUN("%clang_cc1 -std=c99 -fgnu-keywords -E %s -o -")./*|*/
      I("FileCheck --check-prefix=CHECK-GNU-KEYWORDS %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=gnu89 -fno-gnu-keywords -E ${LLVM_SRC}/llvm/tools/clang/test/Lexer/keywords_test.c -o - | ${LLVM_SRC}/build/bin/FileCheck --check-prefix=CHECK-NONE ${LLVM_SRC}/llvm/tools/clang/test/Lexer/keywords_test.c
    RUN("%clang_cc1 -std=gnu89 -fno-gnu-keywords -E %s -o -")./*|*/
      I("FileCheck --check-prefix=CHECK-NONE %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c99 -fms-extensions -E ${LLVM_SRC}/llvm/tools/clang/test/Lexer/keywords_test.c -o - | ${LLVM_SRC}/build/bin/FileCheck --check-prefix=CHECK-MS-KEYWORDS ${LLVM_SRC}/llvm/tools/clang/test/Lexer/keywords_test.c
    RUN("%clang_cc1 -std=c99 -fms-extensions -E %s -o -")./*|*/
      I("FileCheck --check-prefix=CHECK-MS-KEYWORDS %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c99 -fdeclspec -E ${LLVM_SRC}/llvm/tools/clang/test/Lexer/keywords_test.c -o - | ${LLVM_SRC}/build/bin/FileCheck --check-prefix=CHECK-DECLSPEC-KEYWORD ${LLVM_SRC}/llvm/tools/clang/test/Lexer/keywords_test.c
    RUN("%clang_cc1 -std=c99 -fdeclspec -E %s -o -")./*|*/
      I("FileCheck --check-prefix=CHECK-DECLSPEC-KEYWORD %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c99 -fms-extensions -fno-declspec -E ${LLVM_SRC}/llvm/tools/clang/test/Lexer/keywords_test.c -o - | ${LLVM_SRC}/build/bin/FileCheck --check-prefix=CHECK-MS-KEYWORDS-WITHOUT-DECLSPEC ${LLVM_SRC}/llvm/tools/clang/test/Lexer/keywords_test.c
    RUN("%clang_cc1 -std=c99 -fms-extensions -fno-declspec -E %s -o -")./*|*/
      I("FileCheck --check-prefix=CHECK-MS-KEYWORDS-WITHOUT-DECLSPEC %s");
  }

  @Test
  public void test_keywords_test_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Lexer/keywords_test.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c++03 -fsyntax-only ${LLVM_SRC}/llvm/tools/clang/test/Lexer/keywords_test.cpp
    RUN("%clang_cc1 -std=c++03 -fsyntax-only %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c++11 -DCXX11 -fsyntax-only ${LLVM_SRC}/llvm/tools/clang/test/Lexer/keywords_test.cpp
    RUN("%clang_cc1 -std=c++11 -DCXX11 -fsyntax-only %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c++14 -fconcepts-ts -DCXX11 -DCONCEPTS -fsyntax-only ${LLVM_SRC}/llvm/tools/clang/test/Lexer/keywords_test.cpp
    RUN("%clang_cc1 -std=c++14 -fconcepts-ts -DCXX11 -DCONCEPTS -fsyntax-only %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c++03 -fdeclspec -DDECLSPEC -fsyntax-only ${LLVM_SRC}/llvm/tools/clang/test/Lexer/keywords_test.cpp
    RUN("%clang_cc1 -std=c++03 -fdeclspec -DDECLSPEC -fsyntax-only %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c++03 -fms-extensions -DDECLSPEC -fsyntax-only ${LLVM_SRC}/llvm/tools/clang/test/Lexer/keywords_test.cpp
    RUN("%clang_cc1 -std=c++03 -fms-extensions -DDECLSPEC -fsyntax-only %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c++03 -fborland-extensions -DDECLSPEC -fsyntax-only ${LLVM_SRC}/llvm/tools/clang/test/Lexer/keywords_test.cpp
    RUN("%clang_cc1 -std=c++03 -fborland-extensions -DDECLSPEC -fsyntax-only %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c++03 -fms-extensions -fno-declspec -fsyntax-only ${LLVM_SRC}/llvm/tools/clang/test/Lexer/keywords_test.cpp
    RUN("%clang_cc1 -std=c++03 -fms-extensions -fno-declspec -fsyntax-only %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c++03 -fborland-extensions -fno-declspec -fsyntax-only ${LLVM_SRC}/llvm/tools/clang/test/Lexer/keywords_test.cpp
    RUN("%clang_cc1 -std=c++03 -fborland-extensions -fno-declspec -fsyntax-only %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c++03 -fno-declspec -fdeclspec -DDECLSPEC -fsyntax-only ${LLVM_SRC}/llvm/tools/clang/test/Lexer/keywords_test.cpp
    RUN("%clang_cc1 -std=c++03 -fno-declspec -fdeclspec -DDECLSPEC -fsyntax-only %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c++03 -fdeclspec -fno-declspec -fsyntax-only ${LLVM_SRC}/llvm/tools/clang/test/Lexer/keywords_test.cpp
    RUN("%clang_cc1 -std=c++03 -fdeclspec -fno-declspec -fsyntax-only %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c++03 -fms-extensions -fno-declspec -fdeclspec -DDECLSPEC -fsyntax-only ${LLVM_SRC}/llvm/tools/clang/test/Lexer/keywords_test.cpp
    RUN("%clang_cc1 -std=c++03 -fms-extensions -fno-declspec -fdeclspec -DDECLSPEC -fsyntax-only %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c++03 -fms-extensions -fdeclspec -fno-declspec -fsyntax-only ${LLVM_SRC}/llvm/tools/clang/test/Lexer/keywords_test.cpp
    RUN("%clang_cc1 -std=c++03 -fms-extensions -fdeclspec -fno-declspec -fsyntax-only %s");
    // ${LLVM_SRC}/build/bin/clang -std=c++03 -target i686-windows-msvc -DDECLSPEC -fsyntax-only ${LLVM_SRC}/llvm/tools/clang/test/Lexer/keywords_test.cpp
    RUN("%clang -std=c++03 -target i686-windows-msvc -DDECLSPEC -fsyntax-only %s");
    // ${LLVM_SRC}/build/bin/clang -std=c++03 -target x86_64-scei-ps4 -DDECLSPEC -fsyntax-only ${LLVM_SRC}/llvm/tools/clang/test/Lexer/keywords_test.cpp
    RUN("%clang -std=c++03 -target x86_64-scei-ps4 -DDECLSPEC -fsyntax-only %s");
    // ${LLVM_SRC}/build/bin/clang -std=c++03 -target i686-windows-msvc -fno-declspec -fsyntax-only ${LLVM_SRC}/llvm/tools/clang/test/Lexer/keywords_test.cpp
    RUN("%clang -std=c++03 -target i686-windows-msvc -fno-declspec -fsyntax-only %s");
    // ${LLVM_SRC}/build/bin/clang -std=c++03 -target x86_64-scei-ps4 -fno-declspec -fsyntax-only ${LLVM_SRC}/llvm/tools/clang/test/Lexer/keywords_test.cpp
    RUN("%clang -std=c++03 -target x86_64-scei-ps4 -fno-declspec -fsyntax-only %s");
  }

  @Test
  public void test_long_long_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Lexer/long-long.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x c -std=c89 -fsyntax-only -verify -pedantic-errors -Wno-empty-translation-unit ${LLVM_SRC}/llvm/tools/clang/test/Lexer/long-long.cpp
    RUN("%clang_cc1 -x c   -std=c89   -fsyntax-only -verify -pedantic-errors -Wno-empty-translation-unit %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x c -std=c99 -fsyntax-only -verify -pedantic-errors -Wno-empty-translation-unit ${LLVM_SRC}/llvm/tools/clang/test/Lexer/long-long.cpp
    RUN("%clang_cc1 -x c   -std=c99   -fsyntax-only -verify -pedantic-errors -Wno-empty-translation-unit %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x c++ -std=c++98 -fsyntax-only -verify -pedantic-errors -Wno-empty-translation-unit ${LLVM_SRC}/llvm/tools/clang/test/Lexer/long-long.cpp
    RUN("%clang_cc1 -x c++ -std=c++98 -fsyntax-only -verify -pedantic-errors -Wno-empty-translation-unit %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x c++ -std=c++11 -fsyntax-only -verify -Wc++98-compat-pedantic -Wno-empty-translation-unit ${LLVM_SRC}/llvm/tools/clang/test/Lexer/long-long.cpp
    RUN("%clang_cc1 -x c++ -std=c++11 -fsyntax-only -verify -Wc++98-compat-pedantic -Wno-empty-translation-unit %s");
  }

  @Test
  public void test_ms_compatibility_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Lexer/ms-compatibility.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -E -fms-compatibility ${LLVM_SRC}/llvm/tools/clang/test/Lexer/ms-compatibility.c | ${LLVM_SRC}/build/bin/FileCheck --check-prefix=CHECK-MS-COMPAT ${LLVM_SRC}/llvm/tools/clang/test/Lexer/ms-compatibility.c
    RUN("%clang_cc1 -fsyntax-only -E -fms-compatibility %s")./*|*/
      I("FileCheck --check-prefix=CHECK-MS-COMPAT %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -E ${LLVM_SRC}/llvm/tools/clang/test/Lexer/ms-compatibility.c | ${LLVM_SRC}/build/bin/FileCheck --check-prefix=CHECK-NO-MS-COMPAT ${LLVM_SRC}/llvm/tools/clang/test/Lexer/ms-compatibility.c
    RUN("%clang_cc1 -fsyntax-only -E %s")./*|*/
      I("FileCheck --check-prefix=CHECK-NO-MS-COMPAT %s");
  }

  @Test
  public void test_ms_extensions_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Lexer/ms-extensions.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -fms-extensions ${LLVM_SRC}/llvm/tools/clang/test/Lexer/ms-extensions.c
    RUN("%clang_cc1 -fsyntax-only -verify -fms-extensions %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -fms-compatibility ${LLVM_SRC}/llvm/tools/clang/test/Lexer/ms-extensions.c
    RUN("%clang_cc1 -fsyntax-only -verify -fms-compatibility %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -triple i386-pc-win32 -fms-compatibility ${LLVM_SRC}/llvm/tools/clang/test/Lexer/ms-extensions.c
    RUN("%clang_cc1 -fsyntax-only -verify -triple i386-pc-win32 -fms-compatibility %s");
  }

  @Test
  public void test_ms_extensions_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Lexer/ms-extensions.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -Wreserved-user-defined-literal -fms-extensions -fms-compatibility -std=c++98 ${LLVM_SRC}/llvm/tools/clang/test/Lexer/ms-extensions.cpp
    RUN("%clang_cc1 -fsyntax-only -verify -Wreserved-user-defined-literal -fms-extensions -fms-compatibility -std=c++98 %s");
  }

  @Test
  public void test_msdos_cpm_eof_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Lexer/msdos-cpm-eof.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -fms-extensions -Wmicrosoft ${LLVM_SRC}/llvm/tools/clang/test/Lexer/msdos-cpm-eof.c
    RUN("%clang_cc1 -fsyntax-only -verify -fms-extensions -Wmicrosoft %s");
  }

  @Test
  public void test_multiple_include_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Lexer/multiple-include.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/Lexer/multiple-include.c -fsyntax-only
    RUN("%clang_cc1 %s -fsyntax-only");
  }

  @Test
  public void test_newline_eof_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Lexer/newline-eof.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -Wnewline-eof -verify ${LLVM_SRC}/llvm/tools/clang/test/Lexer/newline-eof.c
    RUN("%clang_cc1 -fsyntax-only -Wnewline-eof -verify %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -pedantic -verify ${LLVM_SRC}/llvm/tools/clang/test/Lexer/newline-eof.c
    RUN("%clang_cc1 -fsyntax-only -pedantic -verify %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -x c++ -std=c++03 -pedantic -verify ${LLVM_SRC}/llvm/tools/clang/test/Lexer/newline-eof.c
    RUN("%clang_cc1 -fsyntax-only -x c++ -std=c++03 -pedantic -verify %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -Wnewline-eof ${LLVM_SRC}/llvm/tools/clang/test/Lexer/newline-eof.c 2>&1 | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Lexer/newline-eof.c
    RUN("%clang_cc1 -fsyntax-only -Wnewline-eof %s 2>&1")./*|*/
      I("FileCheck %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -x c++ -std=c++11 -Wnewline-eof -verify ${LLVM_SRC}/llvm/tools/clang/test/Lexer/newline-eof.c
    RUN("%clang_cc1 -fsyntax-only -x c++ -std=c++11 -Wnewline-eof -verify %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -x c++ -std=c++11 -Werror -pedantic ${LLVM_SRC}/llvm/tools/clang/test/Lexer/newline-eof.c
    RUN("%clang_cc1 -fsyntax-only -x c++ -std=c++11 -Werror -pedantic %s");
  }

  @Test
  public void test_newline_eof_cxx98_compat_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Lexer/newline-eof-c++98-compat.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -Wc++98-compat-pedantic -std=c++11 -verify ${LLVM_SRC}/llvm/tools/clang/test/Lexer/newline-eof-c++98-compat.cpp
    RUN("%clang_cc1 -fsyntax-only -Wc++98-compat-pedantic -std=c++11 -verify %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -Wc++98-compat-pedantic -Wnewline-eof -std=c++11 -verify ${LLVM_SRC}/llvm/tools/clang/test/Lexer/newline-eof-c++98-compat.cpp
    RUN("%clang_cc1 -fsyntax-only -Wc++98-compat-pedantic -Wnewline-eof -std=c++11 -verify %s");
  }

  @Test
  public void test_numeric_literal_trash_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Lexer/numeric-literal-trash.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/Lexer/numeric-literal-trash.c
    RUN("%clang_cc1 -fsyntax-only -verify %s");
  }

  @Test
  public void test_objc_macros_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Lexer/objc_macros.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -triple x86_64-apple-macosx10.10.0 -fobjc-runtime-has-weak -fobjc-weak ${LLVM_SRC}/llvm/tools/clang/test/Lexer/objc_macros.m -verify ${LLVM_SRC}/llvm/tools/clang/test/Lexer/objc_macros.m
    RUN("%clang_cc1 -fsyntax-only \"-triple\" \"x86_64-apple-macosx10.10.0\" -fobjc-runtime-has-weak -fobjc-weak %s -verify %s");
  }

  @Test
  public void test_opencl_half_literal_cl() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Lexer/opencl-half-literal.cl");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/Lexer/opencl-half-literal.cl -fsyntax-only -verify -triple spir-unknown-unknown
    RUN("%clang_cc1 %s -fsyntax-only -verify -triple spir-unknown-unknown");
  }

  @Test
  public void test_pragma_mark_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Lexer/pragma-mark.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/Lexer/pragma-mark.c -fsyntax-only -verify
    RUN("%clang_cc1 %s -fsyntax-only -verify");
  }

  @Test
  public void test_pragma_message_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Lexer/pragma-message.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -Werror ${LLVM_SRC}/llvm/tools/clang/test/Lexer/pragma-message.c
    RUN("%clang_cc1 -fsyntax-only -verify -Werror %s");
  }

  @Test
  public void test_pragma_message2_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Lexer/pragma-message2.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -E -Werror -verify ${LLVM_SRC}/llvm/tools/clang/test/Lexer/pragma-message2.c 2>&1 | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Lexer/pragma-message2.c
    RUN("%clang_cc1 -E -Werror -verify %s 2>&1")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_pragma_operators_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Lexer/pragma-operators.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fms-extensions -std=c++11 -E ${LLVM_SRC}/llvm/tools/clang/test/Lexer/pragma-operators.cpp -fuse-line-directives | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Lexer/pragma-operators.cpp
    RUN("%clang_cc1 -fms-extensions -std=c++11 -E %s -fuse-line-directives")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_pragma_region_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Lexer/pragma-region.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -Wall -fms-extensions ${LLVM_SRC}/llvm/tools/clang/test/Lexer/pragma-region.c
    RUN("%clang_cc1 -fsyntax-only -verify -Wall -fms-extensions %s");
  }

  @Test
  public void test_preamble_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Lexer/preamble.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -print-preamble ${LLVM_SRC}/llvm/tools/clang/test/Lexer/preamble.c > ${TEST_TEMP_DIR}/preamble.c.tmp
    RUN("%clang_cc1 -print-preamble %s > %t");
    // echo END. >> ${TEST_TEMP_DIR}/preamble.c.tmp
    RUN("echo END. >> %t");
    // ${LLVM_SRC}/build/bin/FileCheck < ${TEST_TEMP_DIR}/preamble.c.tmp ${LLVM_SRC}/llvm/tools/clang/test/Lexer/preamble.c
    RUN("FileCheck < %t %s");
  }

  @Test
  public void test_rdar_8914293_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Lexer/rdar-8914293.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/Lexer/rdar-8914293.c
    RUN("%clang_cc1 -fsyntax-only -verify %s");
  }

  @Test
  public void test_rdr_6096838_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Lexer/rdr-6096838.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i386-unknown-unknown -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/Lexer/rdr-6096838.c
    RUN("%clang_cc1 -triple i386-unknown-unknown -fsyntax-only -verify %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-unknown-unknown -std=gnu89 -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/Lexer/rdr-6096838.c
    RUN("%clang_cc1 -triple x86_64-unknown-unknown -std=gnu89 -fsyntax-only -verify %s");
  }

  @Test
  public void test_rdr_6096838_2_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Lexer/rdr-6096838-2.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-unknown-unknown -pedantic -std=gnu89 -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/Lexer/rdr-6096838-2.c
    RUN("%clang_cc1 -triple x86_64-unknown-unknown -pedantic -std=gnu89 -fsyntax-only -verify %s");
  }

  @Test
  public void test_string_literal_encoding_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Lexer/string-literal-encoding.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x c++ -std=c++0x -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/Lexer/string-literal-encoding.c
    RUN("%clang_cc1 -x c++ -std=c++0x -fsyntax-only -verify %s");
  }

  @Test
  public void test_string_literal_errors_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Lexer/string-literal-errors.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only ${LLVM_SRC}/llvm/tools/clang/test/Lexer/string-literal-errors.cpp 2>&1 | ${LLVM_SRC}/build/bin/FileCheck -strict-whitespace ${LLVM_SRC}/llvm/tools/clang/test/Lexer/string-literal-errors.cpp
    RUN("not %clang_cc1 -fsyntax-only %s 2>&1")./*|*/
      I("FileCheck -strict-whitespace %s");
  }

  @Test
  public void test_string_concat_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Lexer/string_concat.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c++11 -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/Lexer/string_concat.cpp
    RUN("%clang_cc1 -std=c++11 -fsyntax-only -verify %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c11 -x c -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/Lexer/string_concat.cpp
    RUN("%clang_cc1 -std=c11 -x c -fsyntax-only -verify %s");
  }

  @Test
  public void test_token_concat_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Lexer/token-concat.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -E ${LLVM_SRC}/llvm/tools/clang/test/Lexer/token-concat.c | ${LLVM_SRC}/build/bin/FileCheck --strict-whitespace ${LLVM_SRC}/llvm/tools/clang/test/Lexer/token-concat.c
    RUN("%clang_cc1 -E %s")./*|*/
      I("FileCheck --strict-whitespace %s");
  }

  @Test
  public void test_token_concat_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Lexer/token-concat.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -E -std=c++11 -o - ${LLVM_SRC}/llvm/tools/clang/test/Lexer/token-concat.cpp | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Lexer/token-concat.cpp
    RUN("%clang_cc1 -E -std=c++11 -o - %s")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_unicode_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Lexer/unicode.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -x c -std=c11 ${LLVM_SRC}/llvm/tools/clang/test/Lexer/unicode.c
    RUN("%clang_cc1 -fsyntax-only -verify -x c -std=c11 %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -x c++ -std=c++11 ${LLVM_SRC}/llvm/tools/clang/test/Lexer/unicode.c
    RUN("%clang_cc1 -fsyntax-only -verify -x c++ -std=c++11 %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -E -DPP_ONLY=1 ${LLVM_SRC}/llvm/tools/clang/test/Lexer/unicode.c -o ${TEST_TEMP_DIR}/unicode.c.tmp
    RUN("%clang_cc1 -E -DPP_ONLY=1 %s -o %t");
    // ${LLVM_SRC}/build/bin/FileCheck --strict-whitespace '--input-file=${TEST_TEMP_DIR}/unicode.c.tmp' ${LLVM_SRC}/llvm/tools/clang/test/Lexer/unicode.c
    RUN("FileCheck --strict-whitespace --input-file=%t %s");
  }

  @Test
  public void test_unicode_strings_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Lexer/unicode-strings.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x c -std=c11 -Werror ${LLVM_SRC}/llvm/tools/clang/test/Lexer/unicode-strings.c
    RUN("%clang_cc1 -x c -std=c11 -Werror %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x c++ -std=c++11 -Werror ${LLVM_SRC}/llvm/tools/clang/test/Lexer/unicode-strings.c
    RUN("%clang_cc1 -x c++ -std=c++11 -Werror %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x c -std=c11 -Wc99-compat -verify ${LLVM_SRC}/llvm/tools/clang/test/Lexer/unicode-strings.c
    RUN("%clang_cc1 -x c -std=c11 -Wc99-compat -verify %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x c++ -std=c++11 -Wc++98-compat -verify ${LLVM_SRC}/llvm/tools/clang/test/Lexer/unicode-strings.c
    RUN("%clang_cc1 -x c++ -std=c++11 -Wc++98-compat -verify %s");
  }

  @Test
  public void test_unknown_char_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Lexer/unknown-char.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -E -verify ${LLVM_SRC}/llvm/tools/clang/test/Lexer/unknown-char.c
    RUN("%clang_cc1 -E -verify %s");
  }

  @Test
  public void test_utf_16_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Lexer/utf-16.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/Lexer/utf-16.c -fsyntax-only -verify
    RUN("%clang_cc1 %s -fsyntax-only -verify");
  }

  @Test
  public void test_utf8_char_literal_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Lexer/utf8-char-literal.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-apple-darwin -std=c++11 -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/Lexer/utf8-char-literal.cpp
    RUN("%clang_cc1 -triple x86_64-apple-darwin -std=c++11 -fsyntax-only -verify %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-apple-darwin -std=c11 -x c -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/Lexer/utf8-char-literal.cpp
    RUN("%clang_cc1 -triple x86_64-apple-darwin -std=c11 -x c -fsyntax-only -verify %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-apple-darwin -std=c++1z -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/Lexer/utf8-char-literal.cpp
    RUN("%clang_cc1 -triple x86_64-apple-darwin -std=c++1z -fsyntax-only -verify %s");
  }

  @Test
  public void test_utf8_invalid_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Lexer/utf8-invalid.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/Lexer/utf8-invalid.c
    RUN("%clang_cc1 -fsyntax-only -verify %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -E ${LLVM_SRC}/llvm/tools/clang/test/Lexer/utf8-invalid.c -o /dev/null
    RUN("%clang_cc1 -E %s -o /dev/null");
  }

  @Test
  public void test_warn_date_time_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Lexer/warn-date-time.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -Wdate-time -Wno-builtin-macro-redefined ${LLVM_SRC}/llvm/tools/clang/test/Lexer/warn-date-time.c -verify -E
    RUN("%clang_cc1 -Wdate-time -Wno-builtin-macro-redefined %s -verify -E");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -Wdate-time -Wno-builtin-macro-redefined ${LLVM_SRC}/llvm/tools/clang/test/Lexer/warn-date-time.c -DIS_SYSHEADER -verify -E
    RUN("%clang_cc1 -Wdate-time -Wno-builtin-macro-redefined %s -DIS_SYSHEADER -verify -E");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -Werror=date-time -Wno-builtin-macro-redefined ${LLVM_SRC}/llvm/tools/clang/test/Lexer/warn-date-time.c -DIS_SYSHEADER -E 2>&1 | grep 'error: expansion' | ${LLVM_SRC}/build/bin/count 3
    RUN("not %clang_cc1 -Werror=date-time -Wno-builtin-macro-redefined %s -DIS_SYSHEADER -E 2>&1")./*|*/
      I("grep 'error: expansion'")./*|*/
      I("count 3");
  }

  @Test
  public void test_warn_binary_literals_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Lexer/warn_binary_literals.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -std=c++11 -verify ${LLVM_SRC}/llvm/tools/clang/test/Lexer/warn_binary_literals.cpp -Wc++14-binary-literal
    RUN("%clang_cc1 -fsyntax-only -std=c++11 -verify %s -Wc++14-binary-literal");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -std=c++11 -verify ${LLVM_SRC}/llvm/tools/clang/test/Lexer/warn_binary_literals.cpp -Wc++14-extensions
    RUN("%clang_cc1 -fsyntax-only -std=c++11 -verify %s -Wc++14-extensions");
  }

  @Test
  public void test_wchar_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Lexer/wchar.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -fshort-wchar -verify ${LLVM_SRC}/llvm/tools/clang/test/Lexer/wchar.c
    RUN("%clang_cc1 -fsyntax-only -fshort-wchar -verify %s");
  }

  @Test
  public void test_wchar_signedness_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Lexer/wchar-signedness.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -dM -E ${LLVM_SRC}/llvm/tools/clang/test/Lexer/wchar-signedness.c -triple x86_64-none-linux-gnu | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Lexer/wchar-signedness.c --check-prefix=CHECK-X86
    RUN("%clang_cc1 -fsyntax-only -dM -E %s -triple x86_64-none-linux-gnu")./*|*/
      I("FileCheck %s --check-prefix=CHECK-X86");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -dM -E ${LLVM_SRC}/llvm/tools/clang/test/Lexer/wchar-signedness.c -triple armv7-none-eabi | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Lexer/wchar-signedness.c --check-prefix=CHECK-ARM
    RUN("%clang_cc1 -fsyntax-only -dM -E %s -triple armv7-none-eabi")./*|*/
      I("FileCheck %s --check-prefix=CHECK-ARM");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -dM -E ${LLVM_SRC}/llvm/tools/clang/test/Lexer/wchar-signedness.c -triple thumbv7-none-eabi | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Lexer/wchar-signedness.c --check-prefix=CHECK-ARM
    RUN("%clang_cc1 -fsyntax-only -dM -E %s -triple thumbv7-none-eabi")./*|*/
      I("FileCheck %s --check-prefix=CHECK-ARM");
  }

}
