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
package org.clang.serialization.test;

import org.clang.tools.driver.test.DriverTestFileBase;
import org.junit.*;

/**
 * Collection of all test files from test/PCH folder
 * @author Vladimir Voskresensky
 */
public class AllPCHTest extends DriverTestFileBase {
  private static final String TEST_LOCATION = "${LLVM_SRC}/llvm/tools/clang/test/PCH/";
  public AllPCHTest() {
    super(TEST_LOCATION, TestState.Successful);
  }
  
  public static void main(String[] args) {
    // Print tests which will be accepted per test case
    DriverTestFileBase.printAllTestFiles(false, 
            TEST_LOCATION, (test)->{ return true;/*test.getFileIndexInFolder()<120;*/ }, 
            "${SPUTNIK}/modules/org.clang.serialization/test/unit/src/org/clang/serialization/test/AllPCHTest.txt");
  }  

  @Override
  protected boolean keepStacksForUnimplementedMethods() {
    return false;
  }

  @Test
  public void test___va_list_tag_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/PCH/__va_list_tag.c");
    // REQUIRES: x86-registered-target
    if (!CHECK_REQUIRES("x86-registered-target")) {
      return;
    }
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc '-triple=x86_64-unknown-freebsd7.0' -include ${LLVM_SRC}/llvm/tools/clang/test/PCH/Inputs/__va_list_tag.h ${LLVM_SRC}/llvm/tools/clang/test/PCH/__va_list_tag.c -emit-llvm -o -
    RUN(TestState.Failed, "%clang_cc1 -triple=x86_64-unknown-freebsd7.0 -include %S/Inputs/__va_list_tag.h %s -emit-llvm -o -");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc '-triple=x86_64-unknown-freebsd7.0' -emit-pch -x c-header -o ${TEST_TEMP_DIR}/__va_list_tag.c.tmp ${LLVM_SRC}/llvm/tools/clang/test/PCH/Inputs/__va_list_tag.h
    RUN(TestState.Failed, "%clang_cc1 -triple=x86_64-unknown-freebsd7.0 -emit-pch -x c-header -o %t %S/Inputs/__va_list_tag.h");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc '-triple=x86_64-unknown-freebsd7.0' -include-pch ${TEST_TEMP_DIR}/__va_list_tag.c.tmp ${LLVM_SRC}/llvm/tools/clang/test/PCH/__va_list_tag.c -verify
    RUN(TestState.Failed, "%clang_cc1 -triple=x86_64-unknown-freebsd7.0 -include-pch %t %s -verify");
  }

  @Test
  public void test___va_list_tag_typedef_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/PCH/__va_list_tag-typedef.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-pch -x c-header -o ${TEST_TEMP_DIR}/__va_list_tag-typedef.c.tmp ${LLVM_SRC}/llvm/tools/clang/test/PCH/Inputs/__va_list_tag-typedef.h
    RUN("%clang_cc1 -emit-pch -x c-header -o %t %S/Inputs/__va_list_tag-typedef.h");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -include-pch ${TEST_TEMP_DIR}/__va_list_tag-typedef.c.tmp ${LLVM_SRC}/llvm/tools/clang/test/PCH/__va_list_tag-typedef.c
    RUN("%clang_cc1 -fsyntax-only -include-pch %t %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-pch -x c++-header -o ${TEST_TEMP_DIR}/__va_list_tag-typedef.c.tmp ${LLVM_SRC}/llvm/tools/clang/test/PCH/Inputs/__va_list_tag-typedef.h
    RUN("%clang_cc1 -emit-pch -x c++-header -o %t %S/Inputs/__va_list_tag-typedef.h");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x c++ -fsyntax-only -include-pch ${TEST_TEMP_DIR}/__va_list_tag-typedef.c.tmp ${LLVM_SRC}/llvm/tools/clang/test/PCH/__va_list_tag-typedef.c
    RUN("%clang_cc1 -x c++ -fsyntax-only -include-pch %t %s");
  }

  @Test
  public void test_arc_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/PCH/arc.m");
    // REQUIRES: x86-registered-target
    if (!CHECK_REQUIRES("x86-registered-target")) {
      return;
    }
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fblocks -triple x86_64-apple-darwin11 -fobjc-arc -include ${LLVM_SRC}/llvm/tools/clang/test/PCH/Inputs/arc.h -fsyntax-only -emit-llvm-only ${LLVM_SRC}/llvm/tools/clang/test/PCH/arc.m
    RUN(TestState.Failed, "%clang_cc1 -fblocks -triple x86_64-apple-darwin11 -fobjc-arc -include %S/Inputs/arc.h -fsyntax-only -emit-llvm-only %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-pch -fblocks -triple x86_64-apple-darwin11 -fobjc-arc -x objective-c-header -o ${TEST_TEMP_DIR}/arc.m.tmp ${LLVM_SRC}/llvm/tools/clang/test/PCH/Inputs/arc.h
    RUN(TestState.Failed, "%clang_cc1 -emit-pch -fblocks -triple x86_64-apple-darwin11 -fobjc-arc -x objective-c-header -o %t %S/Inputs/arc.h");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fblocks -triple x86_64-apple-darwin11 -fobjc-arc -include-pch ${TEST_TEMP_DIR}/arc.m.tmp -fsyntax-only -emit-llvm-only ${LLVM_SRC}/llvm/tools/clang/test/PCH/arc.m
    RUN(TestState.Failed, "%clang_cc1 -fblocks -triple x86_64-apple-darwin11 -fobjc-arc -include-pch %t -fsyntax-only -emit-llvm-only %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fblocks -triple x86_64-apple-darwin11 -include-pch ${TEST_TEMP_DIR}/arc.m.tmp -fsyntax-only -emit-llvm-only ${LLVM_SRC}/llvm/tools/clang/test/PCH/arc.m 2>&1 | ${LLVM_SRC}/build/bin/FileCheck '-check-prefix=CHECK-ERR1' ${LLVM_SRC}/llvm/tools/clang/test/PCH/arc.m
    RUN(TestState.Failed, "not %clang_cc1 -fblocks -triple x86_64-apple-darwin11 -include-pch %t -fsyntax-only -emit-llvm-only %s 2>&1")./*|*/
      I("FileCheck -check-prefix=CHECK-ERR1 %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-pch -fblocks -triple x86_64-apple-darwin11 -x objective-c-header -o ${TEST_TEMP_DIR}/arc.m.tmp ${LLVM_SRC}/llvm/tools/clang/test/PCH/Inputs/arc.h
    RUN(TestState.Failed, "%clang_cc1 -emit-pch -fblocks -triple x86_64-apple-darwin11 -x objective-c-header -o %t %S/Inputs/arc.h");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fblocks -triple x86_64-apple-darwin11 -fobjc-arc -include-pch ${TEST_TEMP_DIR}/arc.m.tmp -fsyntax-only -emit-llvm-only ${LLVM_SRC}/llvm/tools/clang/test/PCH/arc.m 2>&1 | ${LLVM_SRC}/build/bin/FileCheck '-check-prefix=CHECK-ERR2' ${LLVM_SRC}/llvm/tools/clang/test/PCH/arc.m
    RUN(TestState.Failed, "not %clang_cc1 -fblocks -triple x86_64-apple-darwin11 -fobjc-arc -include-pch %t -fsyntax-only -emit-llvm-only %s 2>&1")./*|*/
      I("FileCheck -check-prefix=CHECK-ERR2 %s");
  }

  @Test
  public void test_asm_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/PCH/asm.c");
    // REQUIRES: x86-registered-target
    if (!CHECK_REQUIRES("x86-registered-target")) {
      return;
    }
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i386-unknown-unknown -include ${LLVM_SRC}/llvm/tools/clang/test/PCH/asm.h -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/PCH/asm.c
    RUN(TestState.Failed, "%clang_cc1 -triple i386-unknown-unknown -include %S/asm.h -fsyntax-only -verify %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i386-unknown-unknown -emit-pch -o ${TEST_TEMP_DIR}/asm.c.tmp ${LLVM_SRC}/llvm/tools/clang/test/PCH/asm.h
    RUN(TestState.Failed, "%clang_cc1 -triple i386-unknown-unknown -emit-pch -o %t %S/asm.h");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i386-unknown-unknown -include-pch ${TEST_TEMP_DIR}/asm.c.tmp -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/PCH/asm.c
    RUN(TestState.Failed, "%clang_cc1 -triple i386-unknown-unknown -include-pch %t -fsyntax-only -verify %s");
  }

  @Test
  public void test_attrs_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/PCH/attrs.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -include ${LLVM_SRC}/llvm/tools/clang/test/PCH/attrs.c -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/PCH/attrs.c
    RUN("%clang_cc1 -include %s -fsyntax-only -verify %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-pch -o ${TEST_TEMP_DIR}/attrs.c.tmp ${LLVM_SRC}/llvm/tools/clang/test/PCH/attrs.c
    RUN("%clang_cc1 -emit-pch -o %t %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -include-pch ${TEST_TEMP_DIR}/attrs.c.tmp -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/PCH/attrs.c
    RUN("%clang_cc1 -include-pch %t -fsyntax-only -verify %s");
  }

  @Test
  public void test_attrs_PR8406_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/PCH/attrs-PR8406.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -include ${LLVM_SRC}/llvm/tools/clang/test/PCH/attrs-PR8406.c -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/PCH/attrs-PR8406.c | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/PCH/attrs-PR8406.c
    RUN("%clang_cc1 -include %s -emit-llvm -o - %s")./*|*/
      I("FileCheck %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-pch -o ${TEST_TEMP_DIR}/attrs-PR8406.c.tmp ${LLVM_SRC}/llvm/tools/clang/test/PCH/attrs-PR8406.c
    RUN("%clang_cc1 -emit-pch -o %t %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -include-pch ${TEST_TEMP_DIR}/attrs-PR8406.c.tmp -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/PCH/attrs-PR8406.c | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/PCH/attrs-PR8406.c
    RUN("%clang_cc1 -include-pch %t -emit-llvm -o - %s")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_badpch_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/PCH/badpch.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -include-pch ${LLVM_SRC}/llvm/tools/clang/test/PCH/Inputs/badpch-empty.h.gch ${LLVM_SRC}/llvm/tools/clang/test/PCH/badpch.c 2>&1 | ${LLVM_SRC}/build/bin/FileCheck '-check-prefix=CHECK-EMPTY' ${LLVM_SRC}/llvm/tools/clang/test/PCH/badpch.c
    RUN("not %clang_cc1 -fsyntax-only -include-pch %S/Inputs/badpch-empty.h.gch %s 2>&1")./*|*/
      I("FileCheck -check-prefix=CHECK-EMPTY %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -include-pch ${LLVM_SRC}/llvm/tools/clang/test/PCH/Inputs/badpch-dir.h.gch ${LLVM_SRC}/llvm/tools/clang/test/PCH/badpch.c 2>&1 | ${LLVM_SRC}/build/bin/FileCheck '-check-prefix=CHECK-DIR' ${LLVM_SRC}/llvm/tools/clang/test/PCH/badpch.c
    RUN("not %clang_cc1 -fsyntax-only -include-pch %S/Inputs/badpch-dir.h.gch %s 2>&1")./*|*/
      I("FileCheck -check-prefix=CHECK-DIR %s");
  }

  @Test
  public void test_blocks_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/PCH/blocks.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fblocks -include ${LLVM_SRC}/llvm/tools/clang/test/PCH/blocks.h -fsyntax-only -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/PCH/blocks.c
    RUN(TestState.Failed, "%clang_cc1 -fblocks -include %S/blocks.h -fsyntax-only -emit-llvm -o - %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-pch -fblocks -o ${TEST_TEMP_DIR}/blocks.c.tmp ${LLVM_SRC}/llvm/tools/clang/test/PCH/blocks.h
    RUN(TestState.Failed, "%clang_cc1 -emit-pch -fblocks -o %t %S/blocks.h");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fblocks -include-pch ${TEST_TEMP_DIR}/blocks.c.tmp -fsyntax-only -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/PCH/blocks.c
    RUN(TestState.Failed, "%clang_cc1 -fblocks -include-pch %t -fsyntax-only -emit-llvm -o - %s");
  }

  @Test
  public void test_builtins_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/PCH/builtins.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -include ${LLVM_SRC}/llvm/tools/clang/test/PCH/builtins.h -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/PCH/builtins.c
    RUN("%clang_cc1 -include %S/builtins.h -fsyntax-only -verify %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-pch -o ${TEST_TEMP_DIR}/builtins.c.tmp ${LLVM_SRC}/llvm/tools/clang/test/PCH/builtins.h
    RUN("%clang_cc1 -emit-pch -o %t %S/builtins.h");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -include-pch ${TEST_TEMP_DIR}/builtins.c.tmp -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/PCH/builtins.c
    RUN("%clang_cc1 -include-pch %t -fsyntax-only -verify %s");
  }

  @Test
  public void test_captured_stmt_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/PCH/captured-stmt.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x c++-header -emit-pch ${LLVM_SRC}/llvm/tools/clang/test/PCH/captured-stmt.cpp -o ${TEST_TEMP_DIR}/captured-stmt.cpp.tmp
    RUN("%clang_cc1 -x c++-header -emit-pch %s -o %t");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -include-pch ${TEST_TEMP_DIR}/captured-stmt.cpp.tmp -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/PCH/captured-stmt.cpp
    RUN("%clang_cc1 -include-pch %t -fsyntax-only -verify %s");
  }

  @Test
  public void test_case_insensitive_include_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/PCH/case-insensitive-include.c");
    // REQUIRES: case-insensitive-filesystem
    if (!CHECK_REQUIRES("case-insensitive-filesystem")) {
      return;
    }
    // cp ${LLVM_SRC}/llvm/tools/clang/test/PCH/Inputs/case-insensitive-include.h ${TEST_TEMP_DIR}
    RUN(TestState.Failed, "cp %S/Inputs/case-insensitive-include.h %T");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -Wno-nonportable-include-path -fsyntax-only ${LLVM_SRC}/llvm/tools/clang/test/PCH/case-insensitive-include.c -include ${LLVM_SRC}/llvm/tools/clang/test/PCH/case-insensitive-include.c -I ${TEST_TEMP_DIR} -verify
    RUN(TestState.Failed, "%clang_cc1 -Wno-nonportable-include-path -fsyntax-only %s -include %s -I %T -verify");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-pch -o ${TEST_TEMP_DIR}/case-insensitive-include.c.tmp.pch ${LLVM_SRC}/llvm/tools/clang/test/PCH/case-insensitive-include.c -I ${TEST_TEMP_DIR}
    RUN(TestState.Failed, "%clang_cc1 -emit-pch -o %t.pch %s -I %T");
    // cp ${TEST_TEMP_DIR}/case-insensitive-include.h ${TEST_TEMP_DIR}/case-insensitive-include.c.tmp.copy
    RUN(TestState.Failed, "cp %T/case-insensitive-include.h %t.copy");
    // touch -r ${TEST_TEMP_DIR}/case-insensitive-include.h ${TEST_TEMP_DIR}/case-insensitive-include.c.tmp.copy
    RUN(TestState.Failed, "touch -r %T/case-insensitive-include.h %t.copy");
    // mv ${TEST_TEMP_DIR}/case-insensitive-include.c.tmp.copy ${TEST_TEMP_DIR}/case-insensitive-include.h
    RUN(TestState.Failed, "mv %t.copy %T/case-insensitive-include.h");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only ${LLVM_SRC}/llvm/tools/clang/test/PCH/case-insensitive-include.c -include-pch ${TEST_TEMP_DIR}/case-insensitive-include.c.tmp.pch -I ${TEST_TEMP_DIR} -verify
    RUN(TestState.Failed, "%clang_cc1 -fsyntax-only %s -include-pch %t.pch -I %T -verify");
  }

  @Test
  public void test_chain_categories_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/PCH/chain-categories.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -include ${LLVM_SRC}/llvm/tools/clang/test/PCH/chain-categories.m -include ${LLVM_SRC}/llvm/tools/clang/test/PCH/chain-categories.m ${LLVM_SRC}/llvm/tools/clang/test/PCH/chain-categories.m
    RUN("%clang_cc1 -fsyntax-only -verify -include %s -include %s %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/PCH/chain-categories.m -chain-include ${LLVM_SRC}/llvm/tools/clang/test/PCH/chain-categories.m -chain-include ${LLVM_SRC}/llvm/tools/clang/test/PCH/chain-categories.m
    RUN(TestState.Failed, "%clang_cc1 -fsyntax-only -verify %s -chain-include %s -chain-include %s");
  }

  @Test
  public void test_chain_categories2_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/PCH/chain-categories2.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -Wno-objc-root-class -include ${LLVM_SRC}/llvm/tools/clang/test/PCH/chain-categories2.m -include ${LLVM_SRC}/llvm/tools/clang/test/PCH/chain-categories2.m ${LLVM_SRC}/llvm/tools/clang/test/PCH/chain-categories2.m
    RUN("%clang_cc1 -fsyntax-only -verify -Wno-objc-root-class -include %s -include %s %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -Wno-objc-root-class ${LLVM_SRC}/llvm/tools/clang/test/PCH/chain-categories2.m -chain-include ${LLVM_SRC}/llvm/tools/clang/test/PCH/chain-categories2.m -chain-include ${LLVM_SRC}/llvm/tools/clang/test/PCH/chain-categories2.m
    RUN(TestState.Failed, "%clang_cc1 -fsyntax-only -verify -Wno-objc-root-class %s -chain-include %s -chain-include %s");
  }

  @Test
  public void test_chain_class_extension_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/PCH/chain-class-extension.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -triple x86_64-apple-darwin10 -fobjc-arc ${LLVM_SRC}/llvm/tools/clang/test/PCH/chain-class-extension.m -include ${LLVM_SRC}/llvm/tools/clang/test/PCH/chain-class-extension.m -include ${LLVM_SRC}/llvm/tools/clang/test/PCH/chain-class-extension.m
    RUN("%clang_cc1 -fsyntax-only -verify -triple x86_64-apple-darwin10 -fobjc-arc %s -include %s -include %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -triple x86_64-apple-darwin10 -fobjc-arc ${LLVM_SRC}/llvm/tools/clang/test/PCH/chain-class-extension.m -chain-include ${LLVM_SRC}/llvm/tools/clang/test/PCH/chain-class-extension.m -chain-include ${LLVM_SRC}/llvm/tools/clang/test/PCH/chain-class-extension.m
    RUN(TestState.Failed, "%clang_cc1 -fsyntax-only -verify -triple x86_64-apple-darwin10 -fobjc-arc %s -chain-include %s -chain-include %s");
  }

  @Test
  public void test_chain_conversion_lookup_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/PCH/chain-conversion-lookup.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/PCH/chain-conversion-lookup.cpp -emit-llvm -o - -chain-include ${LLVM_SRC}/llvm/tools/clang/test/PCH/chain-conversion-lookup.cpp -chain-include ${LLVM_SRC}/llvm/tools/clang/test/PCH/chain-conversion-lookup.cpp
    RUN(TestState.Failed, "%clang_cc1 %s -emit-llvm -o - -chain-include %s -chain-include %s");
  }

  @Test
  public void test_chain_cxx_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/PCH/chain-cxx.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -include ${LLVM_SRC}/llvm/tools/clang/test/PCH/chain-cxx.cpp -include ${LLVM_SRC}/llvm/tools/clang/test/PCH/chain-cxx.cpp ${LLVM_SRC}/llvm/tools/clang/test/PCH/chain-cxx.cpp
    RUN("%clang_cc1 -fsyntax-only -verify -include %s -include %s %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/PCH/chain-cxx.cpp -chain-include ${LLVM_SRC}/llvm/tools/clang/test/PCH/chain-cxx.cpp -chain-include ${LLVM_SRC}/llvm/tools/clang/test/PCH/chain-cxx.cpp
    RUN("%clang_cc1 -fsyntax-only -verify %s -chain-include %s -chain-include %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -fmodules ${LLVM_SRC}/llvm/tools/clang/test/PCH/chain-cxx.cpp -chain-include ${LLVM_SRC}/llvm/tools/clang/test/PCH/chain-cxx.cpp -chain-include ${LLVM_SRC}/llvm/tools/clang/test/PCH/chain-cxx.cpp
    RUN("%clang_cc1 -fsyntax-only -verify -fmodules %s -chain-include %s -chain-include %s");
  }

  @Test
  public void test_chain_decls_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/PCH/chain-decls.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -include ${LLVM_SRC}/llvm/tools/clang/test/PCH/Inputs/chain-decls1.h -include ${LLVM_SRC}/llvm/tools/clang/test/PCH/Inputs/chain-decls2.h -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/PCH/chain-decls.c
    RUN("%clang_cc1 -include %S/Inputs/chain-decls1.h -include %S/Inputs/chain-decls2.h -fsyntax-only -verify %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-pch -o ${TEST_TEMP_DIR}/chain-decls.c.tmp1 ${LLVM_SRC}/llvm/tools/clang/test/PCH/Inputs/chain-decls1.h
    RUN("%clang_cc1 -emit-pch -o %t1 %S/Inputs/chain-decls1.h");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-pch -o ${TEST_TEMP_DIR}/chain-decls.c.tmp2 ${LLVM_SRC}/llvm/tools/clang/test/PCH/Inputs/chain-decls2.h -include-pch ${TEST_TEMP_DIR}/chain-decls.c.tmp1
    RUN("%clang_cc1 -emit-pch -o %t2 %S/Inputs/chain-decls2.h -include-pch %t1");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -include-pch ${TEST_TEMP_DIR}/chain-decls.c.tmp2 -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/PCH/chain-decls.c
    RUN("%clang_cc1 -include-pch %t2 -fsyntax-only -verify %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -ast-print -include-pch ${TEST_TEMP_DIR}/chain-decls.c.tmp2 ${LLVM_SRC}/llvm/tools/clang/test/PCH/chain-decls.c | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/PCH/chain-decls.c
    RUN("%clang_cc1 -ast-print -include-pch %t2 %s")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_chain_default_argument_instantiation_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/PCH/chain-default-argument-instantiation.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify '-std=c++11' -include ${LLVM_SRC}/llvm/tools/clang/test/PCH/chain-default-argument-instantiation.cpp -include ${LLVM_SRC}/llvm/tools/clang/test/PCH/chain-default-argument-instantiation.cpp ${LLVM_SRC}/llvm/tools/clang/test/PCH/chain-default-argument-instantiation.cpp
    RUN("%clang_cc1 -fsyntax-only -verify -std=c++11 -include %s -include %s %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify '-std=c++11' ${LLVM_SRC}/llvm/tools/clang/test/PCH/chain-default-argument-instantiation.cpp -chain-include ${LLVM_SRC}/llvm/tools/clang/test/PCH/chain-default-argument-instantiation.cpp -chain-include ${LLVM_SRC}/llvm/tools/clang/test/PCH/chain-default-argument-instantiation.cpp
    RUN("%clang_cc1 -fsyntax-only -verify -std=c++11 %s -chain-include %s -chain-include %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify '-std=c++11' -fmodules ${LLVM_SRC}/llvm/tools/clang/test/PCH/chain-default-argument-instantiation.cpp -chain-include ${LLVM_SRC}/llvm/tools/clang/test/PCH/chain-default-argument-instantiation.cpp -chain-include ${LLVM_SRC}/llvm/tools/clang/test/PCH/chain-default-argument-instantiation.cpp
    RUN("%clang_cc1 -fsyntax-only -verify -std=c++11 -fmodules %s -chain-include %s -chain-include %s");
  }

  @Test
  public void test_chain_empty_initial_namespace_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/PCH/chain-empty-initial-namespace.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -include ${LLVM_SRC}/llvm/tools/clang/test/PCH/chain-empty-initial-namespace.cpp -include ${LLVM_SRC}/llvm/tools/clang/test/PCH/chain-empty-initial-namespace.cpp -fsyntax-only ${LLVM_SRC}/llvm/tools/clang/test/PCH/chain-empty-initial-namespace.cpp
    RUN("%clang_cc1 -include %s -include %s -fsyntax-only %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -chain-include ${LLVM_SRC}/llvm/tools/clang/test/PCH/chain-empty-initial-namespace.cpp -chain-include ${LLVM_SRC}/llvm/tools/clang/test/PCH/chain-empty-initial-namespace.cpp -fsyntax-only ${LLVM_SRC}/llvm/tools/clang/test/PCH/chain-empty-initial-namespace.cpp
    RUN("%clang_cc1 -chain-include %s -chain-include %s -fsyntax-only %s");
  }

  @Test
  public void test_chain_ext_vector_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/PCH/chain-ext_vector.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -include ${LLVM_SRC}/llvm/tools/clang/test/PCH/Inputs/chain-ext_vector1.h -include ${LLVM_SRC}/llvm/tools/clang/test/PCH/Inputs/chain-ext_vector2.h -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/PCH/chain-ext_vector.c
    RUN("%clang_cc1 -include %S/Inputs/chain-ext_vector1.h -include %S/Inputs/chain-ext_vector2.h -fsyntax-only -verify %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-pch -o ${TEST_TEMP_DIR}/chain-ext_vector.c.tmp1 ${LLVM_SRC}/llvm/tools/clang/test/PCH/Inputs/chain-ext_vector1.h
    RUN("%clang_cc1 -emit-pch -o %t1 %S/Inputs/chain-ext_vector1.h");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-pch -o ${TEST_TEMP_DIR}/chain-ext_vector.c.tmp2 ${LLVM_SRC}/llvm/tools/clang/test/PCH/Inputs/chain-ext_vector2.h -include-pch ${TEST_TEMP_DIR}/chain-ext_vector.c.tmp1
    RUN("%clang_cc1 -emit-pch -o %t2 %S/Inputs/chain-ext_vector2.h -include-pch %t1");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -include-pch ${TEST_TEMP_DIR}/chain-ext_vector.c.tmp2 -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/PCH/chain-ext_vector.c
    RUN("%clang_cc1 -include-pch %t2 -fsyntax-only -verify %s");
  }

  @Test
  public void test_chain_external_defs_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/PCH/chain-external-defs.c");
    // REQUIRES: x86-registered-target
    if (!CHECK_REQUIRES("x86-registered-target")) {
      return;
    }
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-apple-darwin9 -emit-pch -o ${TEST_TEMP_DIR}/chain-external-defs.c.tmp1.pch ${LLVM_SRC}/llvm/tools/clang/test/PCH/Inputs/chain-external-defs1.h
    RUN("%clang_cc1 -triple x86_64-apple-darwin9 -emit-pch -o %t1.pch %S/Inputs/chain-external-defs1.h");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-apple-darwin9 -emit-pch -o ${TEST_TEMP_DIR}/chain-external-defs.c.tmp2.pch ${LLVM_SRC}/llvm/tools/clang/test/PCH/Inputs/chain-external-defs2.h -include-pch ${TEST_TEMP_DIR}/chain-external-defs.c.tmp1.pch
    RUN("%clang_cc1 -triple x86_64-apple-darwin9 -emit-pch -o %t2.pch %S/Inputs/chain-external-defs2.h -include-pch %t1.pch");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-apple-darwin9 -include-pch ${TEST_TEMP_DIR}/chain-external-defs.c.tmp2.pch -emit-llvm -o ${TEST_TEMP_DIR}/chain-external-defs.c.tmp ${LLVM_SRC}/llvm/tools/clang/test/PCH/chain-external-defs.c
    RUN("%clang_cc1 -triple x86_64-apple-darwin9 -include-pch %t2.pch -emit-llvm -o %t %s");
    // echo FINI >> ${TEST_TEMP_DIR}/chain-external-defs.c.tmp
    RUN("echo FINI >> %t");
    // ${LLVM_SRC}/build/bin/FileCheck "-input-file=${TEST_TEMP_DIR}/chain-external-defs.c.tmp" '-check-prefix=Z' ${LLVM_SRC}/llvm/tools/clang/test/PCH/chain-external-defs.c
    RUN("FileCheck -input-file=%t -check-prefix=Z %s");
    // ${LLVM_SRC}/build/bin/FileCheck "-input-file=${TEST_TEMP_DIR}/chain-external-defs.c.tmp" '-check-prefix=XA' ${LLVM_SRC}/llvm/tools/clang/test/PCH/chain-external-defs.c
    RUN("FileCheck -input-file=%t -check-prefix=XA %s");
    // ${LLVM_SRC}/build/bin/FileCheck "-input-file=${TEST_TEMP_DIR}/chain-external-defs.c.tmp" '-check-prefix=YA' ${LLVM_SRC}/llvm/tools/clang/test/PCH/chain-external-defs.c
    RUN("FileCheck -input-file=%t -check-prefix=YA %s");
    // ${LLVM_SRC}/build/bin/FileCheck "-input-file=${TEST_TEMP_DIR}/chain-external-defs.c.tmp" '-check-prefix=XB' ${LLVM_SRC}/llvm/tools/clang/test/PCH/chain-external-defs.c
    RUN("FileCheck -input-file=%t -check-prefix=XB %s");
    // ${LLVM_SRC}/build/bin/FileCheck "-input-file=${TEST_TEMP_DIR}/chain-external-defs.c.tmp" '-check-prefix=YB' ${LLVM_SRC}/llvm/tools/clang/test/PCH/chain-external-defs.c
    RUN("FileCheck -input-file=%t -check-prefix=YB %s");
    // ${LLVM_SRC}/build/bin/FileCheck "-input-file=${TEST_TEMP_DIR}/chain-external-defs.c.tmp" '-check-prefix=AA' ${LLVM_SRC}/llvm/tools/clang/test/PCH/chain-external-defs.c
    RUN("FileCheck -input-file=%t -check-prefix=AA %s");
    // ${LLVM_SRC}/build/bin/FileCheck "-input-file=${TEST_TEMP_DIR}/chain-external-defs.c.tmp" '-check-prefix=AB' ${LLVM_SRC}/llvm/tools/clang/test/PCH/chain-external-defs.c
    RUN("FileCheck -input-file=%t -check-prefix=AB %s");
    // ${LLVM_SRC}/build/bin/FileCheck "-input-file=${TEST_TEMP_DIR}/chain-external-defs.c.tmp" '-check-prefix=AC' ${LLVM_SRC}/llvm/tools/clang/test/PCH/chain-external-defs.c
    RUN("FileCheck -input-file=%t -check-prefix=AC %s");
    // ${LLVM_SRC}/build/bin/FileCheck "-input-file=${TEST_TEMP_DIR}/chain-external-defs.c.tmp" '-check-prefix=S' ${LLVM_SRC}/llvm/tools/clang/test/PCH/chain-external-defs.c
    RUN("FileCheck -input-file=%t -check-prefix=S %s");
  }

  @Test
  public void test_chain_friend_instantiation_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/PCH/chain-friend-instantiation.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/PCH/chain-friend-instantiation.cpp -ast-print -o - -chain-include ${LLVM_SRC}/llvm/tools/clang/test/PCH/chain-friend-instantiation.cpp -chain-include ${LLVM_SRC}/llvm/tools/clang/test/PCH/chain-friend-instantiation.cpp
    RUN("%clang_cc1 %s -ast-print -o - -chain-include %s -chain-include %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/PCH/chain-friend-instantiation.cpp -ast-print -o - -fmodules -chain-include ${LLVM_SRC}/llvm/tools/clang/test/PCH/chain-friend-instantiation.cpp -chain-include ${LLVM_SRC}/llvm/tools/clang/test/PCH/chain-friend-instantiation.cpp
    RUN("%clang_cc1 %s -ast-print -o - -fmodules -chain-include %s -chain-include %s");
  }

  @Test
  public void test_chain_implicit_definition_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/PCH/chain-implicit-definition.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm-only -include ${LLVM_SRC}/llvm/tools/clang/test/PCH/chain-implicit-definition.cpp -include ${LLVM_SRC}/llvm/tools/clang/test/PCH/chain-implicit-definition.cpp ${LLVM_SRC}/llvm/tools/clang/test/PCH/chain-implicit-definition.cpp
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm-only -include %s -include %s %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm-only -chain-include ${LLVM_SRC}/llvm/tools/clang/test/PCH/chain-implicit-definition.cpp -chain-include ${LLVM_SRC}/llvm/tools/clang/test/PCH/chain-implicit-definition.cpp ${LLVM_SRC}/llvm/tools/clang/test/PCH/chain-implicit-definition.cpp
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm-only -chain-include %s -chain-include %s %s");
  }

  @Test
  public void test_chain_invalid_code_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/PCH/chain-invalid-code.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only ${LLVM_SRC}/llvm/tools/clang/test/PCH/chain-invalid-code.cpp -chain-include ${LLVM_SRC}/llvm/tools/clang/test/PCH/chain-invalid-code.cpp -Wuninitialized -Wunused -verify
    RUN("%clang_cc1 -fsyntax-only %s -chain-include %s -Wuninitialized -Wunused -verify");
  }

  @Test
  public void test_chain_late_anonymous_namespace_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/PCH/chain-late-anonymous-namespace.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -include ${LLVM_SRC}/llvm/tools/clang/test/PCH/chain-late-anonymous-namespace.cpp -include ${LLVM_SRC}/llvm/tools/clang/test/PCH/chain-late-anonymous-namespace.cpp -fsyntax-only ${LLVM_SRC}/llvm/tools/clang/test/PCH/chain-late-anonymous-namespace.cpp
    RUN("%clang_cc1 -include %s -include %s -fsyntax-only %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -chain-include ${LLVM_SRC}/llvm/tools/clang/test/PCH/chain-late-anonymous-namespace.cpp -chain-include ${LLVM_SRC}/llvm/tools/clang/test/PCH/chain-late-anonymous-namespace.cpp -fsyntax-only ${LLVM_SRC}/llvm/tools/clang/test/PCH/chain-late-anonymous-namespace.cpp
    RUN("%clang_cc1 -chain-include %s -chain-include %s -fsyntax-only %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -chain-include ${LLVM_SRC}/llvm/tools/clang/test/PCH/chain-late-anonymous-namespace.cpp -chain-include ${LLVM_SRC}/llvm/tools/clang/test/PCH/chain-late-anonymous-namespace.cpp -fsyntax-only -fmodules ${LLVM_SRC}/llvm/tools/clang/test/PCH/chain-late-anonymous-namespace.cpp
    RUN("%clang_cc1 -chain-include %s -chain-include %s -fsyntax-only -fmodules %s");
  }

  @Test
  public void test_chain_macro_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/PCH/chain-macro.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-pch -o ${TEST_TEMP_DIR}/chain-macro.c.tmp1 -detailed-preprocessing-record ${LLVM_SRC}/llvm/tools/clang/test/PCH/Inputs/chain-macro1.h
    RUN("%clang_cc1 -emit-pch -o %t1 -detailed-preprocessing-record %S/Inputs/chain-macro1.h");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-pch -o ${TEST_TEMP_DIR}/chain-macro.c.tmp2 -detailed-preprocessing-record ${LLVM_SRC}/llvm/tools/clang/test/PCH/Inputs/chain-macro2.h -include-pch ${TEST_TEMP_DIR}/chain-macro.c.tmp1
    RUN("%clang_cc1 -emit-pch -o %t2 -detailed-preprocessing-record %S/Inputs/chain-macro2.h -include-pch %t1");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -include-pch ${TEST_TEMP_DIR}/chain-macro.c.tmp2 ${LLVM_SRC}/llvm/tools/clang/test/PCH/chain-macro.c
    RUN("%clang_cc1 -fsyntax-only -verify -include-pch %t2 %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -ast-print -include-pch ${TEST_TEMP_DIR}/chain-macro.c.tmp2 ${LLVM_SRC}/llvm/tools/clang/test/PCH/chain-macro.c | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/PCH/chain-macro.c
    RUN("%clang_cc1 -ast-print -include-pch %t2 %s")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_chain_macro_override_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/PCH/chain-macro-override.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -include ${LLVM_SRC}/llvm/tools/clang/test/PCH/Inputs/chain-macro-override1.h -include ${LLVM_SRC}/llvm/tools/clang/test/PCH/Inputs/chain-macro-override2.h -fsyntax-only -verify -detailed-preprocessing-record ${LLVM_SRC}/llvm/tools/clang/test/PCH/chain-macro-override.c
    RUN("%clang_cc1 -include %S/Inputs/chain-macro-override1.h -include %S/Inputs/chain-macro-override2.h -fsyntax-only -verify -detailed-preprocessing-record %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-pch -o ${TEST_TEMP_DIR}/chain-macro-override.c.tmp1 ${LLVM_SRC}/llvm/tools/clang/test/PCH/Inputs/chain-macro-override1.h -detailed-preprocessing-record
    RUN("%clang_cc1 -emit-pch -o %t1 %S/Inputs/chain-macro-override1.h -detailed-preprocessing-record");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-pch -o ${TEST_TEMP_DIR}/chain-macro-override.c.tmp2 ${LLVM_SRC}/llvm/tools/clang/test/PCH/Inputs/chain-macro-override2.h -include-pch ${TEST_TEMP_DIR}/chain-macro-override.c.tmp1 -detailed-preprocessing-record
    RUN("%clang_cc1 -emit-pch -o %t2 %S/Inputs/chain-macro-override2.h -include-pch %t1 -detailed-preprocessing-record");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -include-pch ${TEST_TEMP_DIR}/chain-macro-override.c.tmp2 -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/PCH/chain-macro-override.c
    RUN("%clang_cc1 -include-pch %t2 -fsyntax-only -verify %s");
  }

  @Test
  public void test_chain_openmp_threadprivate_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/PCH/chain-openmp-threadprivate.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fopenmp -fnoopenmp-use-tls -emit-llvm -include ${LLVM_SRC}/llvm/tools/clang/test/PCH/chain-openmp-threadprivate.cpp -include ${LLVM_SRC}/llvm/tools/clang/test/PCH/chain-openmp-threadprivate.cpp ${LLVM_SRC}/llvm/tools/clang/test/PCH/chain-openmp-threadprivate.cpp -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/PCH/chain-openmp-threadprivate.cpp
    RUN(TestState.Failed, "%clang_cc1 -fopenmp -fnoopenmp-use-tls -emit-llvm -include %s -include %s %s -o -")./*|*/
      I("FileCheck %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fopenmp -fnoopenmp-use-tls -emit-llvm -chain-include ${LLVM_SRC}/llvm/tools/clang/test/PCH/chain-openmp-threadprivate.cpp -chain-include ${LLVM_SRC}/llvm/tools/clang/test/PCH/chain-openmp-threadprivate.cpp ${LLVM_SRC}/llvm/tools/clang/test/PCH/chain-openmp-threadprivate.cpp -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/PCH/chain-openmp-threadprivate.cpp
    RUN(TestState.Failed, "%clang_cc1 -fopenmp -fnoopenmp-use-tls -emit-llvm -chain-include %s -chain-include %s %s -o -")./*|*/
      I("FileCheck %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fopenmp -emit-llvm -include ${LLVM_SRC}/llvm/tools/clang/test/PCH/chain-openmp-threadprivate.cpp -include ${LLVM_SRC}/llvm/tools/clang/test/PCH/chain-openmp-threadprivate.cpp ${LLVM_SRC}/llvm/tools/clang/test/PCH/chain-openmp-threadprivate.cpp -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/PCH/chain-openmp-threadprivate.cpp '-check-prefix=CHECK-TLS-1'
    RUN(TestState.Failed, "%clang_cc1 -fopenmp -emit-llvm -include %s -include %s %s -o -")./*|*/
      I("FileCheck %s -check-prefix=CHECK-TLS-1");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fopenmp -emit-llvm -include ${LLVM_SRC}/llvm/tools/clang/test/PCH/chain-openmp-threadprivate.cpp -include ${LLVM_SRC}/llvm/tools/clang/test/PCH/chain-openmp-threadprivate.cpp ${LLVM_SRC}/llvm/tools/clang/test/PCH/chain-openmp-threadprivate.cpp -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/PCH/chain-openmp-threadprivate.cpp '-check-prefix=CHECK-TLS-2'
    RUN(TestState.Failed, "%clang_cc1 -fopenmp -emit-llvm -include %s -include %s %s -o -")./*|*/
      I("FileCheck %s -check-prefix=CHECK-TLS-2");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fopenmp -emit-llvm -chain-include ${LLVM_SRC}/llvm/tools/clang/test/PCH/chain-openmp-threadprivate.cpp -chain-include ${LLVM_SRC}/llvm/tools/clang/test/PCH/chain-openmp-threadprivate.cpp ${LLVM_SRC}/llvm/tools/clang/test/PCH/chain-openmp-threadprivate.cpp -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/PCH/chain-openmp-threadprivate.cpp '-check-prefix=CHECK-TLS-1'
    RUN(TestState.Failed, "%clang_cc1 -fopenmp -emit-llvm -chain-include %s -chain-include %s %s -o -")./*|*/
      I("FileCheck %s -check-prefix=CHECK-TLS-1");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fopenmp -emit-llvm -chain-include ${LLVM_SRC}/llvm/tools/clang/test/PCH/chain-openmp-threadprivate.cpp -chain-include ${LLVM_SRC}/llvm/tools/clang/test/PCH/chain-openmp-threadprivate.cpp ${LLVM_SRC}/llvm/tools/clang/test/PCH/chain-openmp-threadprivate.cpp -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/PCH/chain-openmp-threadprivate.cpp '-check-prefix=CHECK-TLS-2'
    RUN(TestState.Failed, "%clang_cc1 -fopenmp -emit-llvm -chain-include %s -chain-include %s %s -o -")./*|*/
      I("FileCheck %s -check-prefix=CHECK-TLS-2");
  }

  @Test
  public void test_chain_pending_instantiations_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/PCH/chain-pending-instantiations.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/PCH/chain-pending-instantiations.cpp -emit-llvm -triple i686-pc-linux -o - -chain-include ${LLVM_SRC}/llvm/tools/clang/test/PCH/chain-pending-instantiations.cpp -chain-include ${LLVM_SRC}/llvm/tools/clang/test/PCH/chain-pending-instantiations.cpp | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/PCH/chain-pending-instantiations.cpp
    RUN(TestState.Failed, "%clang_cc1 %s -emit-llvm -triple i686-pc-linux -o - -chain-include %s -chain-include %s")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_chain_predecl_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/PCH/chain-predecl.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-pch -o ${TEST_TEMP_DIR}/chain-predecl.m.tmp1 ${LLVM_SRC}/llvm/tools/clang/test/PCH/chain-predecl.h -x objective-c
    RUN("%clang_cc1 -emit-pch -o %t1 %S/chain-predecl.h -x objective-c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-pch -o ${TEST_TEMP_DIR}/chain-predecl.m.tmp2 ${LLVM_SRC}/llvm/tools/clang/test/PCH/chain-predecl.m -x objective-c -include-pch ${TEST_TEMP_DIR}/chain-predecl.m.tmp1
    RUN("%clang_cc1 -emit-pch -o %t2 %s -x objective-c -include-pch %t1");
  }

  @Test
  public void test_chain_remap_types_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/PCH/chain-remap-types.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-pch -x objective-c-header -o ${TEST_TEMP_DIR}/chain-remap-types.m.tmp1 ${LLVM_SRC}/llvm/tools/clang/test/PCH/Inputs/chain-remap-types1.h
    RUN("%clang_cc1 -emit-pch -x objective-c-header -o %t1 %S/Inputs/chain-remap-types1.h");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-pch -x objective-c-header -o ${TEST_TEMP_DIR}/chain-remap-types.m.tmp2 ${LLVM_SRC}/llvm/tools/clang/test/PCH/Inputs/chain-remap-types2.h -include-pch ${TEST_TEMP_DIR}/chain-remap-types.m.tmp1
    RUN("%clang_cc1 -emit-pch -x objective-c-header -o %t2 %S/Inputs/chain-remap-types2.h -include-pch %t1");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -include-pch ${TEST_TEMP_DIR}/chain-remap-types.m.tmp2 -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/PCH/chain-remap-types.m
    RUN("%clang_cc1 -include-pch %t2 -fsyntax-only -verify %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -ast-print -include-pch ${TEST_TEMP_DIR}/chain-remap-types.m.tmp2 ${LLVM_SRC}/llvm/tools/clang/test/PCH/chain-remap-types.m | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/PCH/chain-remap-types.m
    RUN("%clang_cc1 -ast-print -include-pch %t2 %s")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_chain_selectors_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/PCH/chain-selectors.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -Wno-objc-root-class ${LLVM_SRC}/llvm/tools/clang/test/PCH/chain-selectors.m -Wselector -include ${LLVM_SRC}/llvm/tools/clang/test/PCH/Inputs/chain-selectors1.h -include ${LLVM_SRC}/llvm/tools/clang/test/PCH/Inputs/chain-selectors2.h
    RUN("%clang_cc1 -fsyntax-only -verify -Wno-objc-root-class %s -Wselector -include %S/Inputs/chain-selectors1.h -include %S/Inputs/chain-selectors2.h");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x objective-c -Wno-objc-root-class -emit-pch -o ${TEST_TEMP_DIR}/chain-selectors.m.tmp1 ${LLVM_SRC}/llvm/tools/clang/test/PCH/Inputs/chain-selectors1.h
    RUN(TestState.Failed, "%clang_cc1 -x objective-c -Wno-objc-root-class -emit-pch -o %t1 %S/Inputs/chain-selectors1.h");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x objective-c -Wno-objc-root-class -emit-pch -o ${TEST_TEMP_DIR}/chain-selectors.m.tmp2 ${LLVM_SRC}/llvm/tools/clang/test/PCH/Inputs/chain-selectors2.h -include-pch ${TEST_TEMP_DIR}/chain-selectors.m.tmp1
    RUN(TestState.Failed, "%clang_cc1 -x objective-c -Wno-objc-root-class -emit-pch -o %t2 %S/Inputs/chain-selectors2.h -include-pch %t1");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -Wno-objc-root-class ${LLVM_SRC}/llvm/tools/clang/test/PCH/chain-selectors.m -Wselector -include-pch ${TEST_TEMP_DIR}/chain-selectors.m.tmp2
    RUN(TestState.Failed, "%clang_cc1 -fsyntax-only -verify -Wno-objc-root-class %s -Wselector -include-pch %t2");
  }

  @Test
  public void test_chain_staticvar_instantiation_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/PCH/chain-staticvar-instantiation.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -include ${LLVM_SRC}/llvm/tools/clang/test/PCH/chain-staticvar-instantiation.cpp -include ${LLVM_SRC}/llvm/tools/clang/test/PCH/chain-staticvar-instantiation.cpp ${LLVM_SRC}/llvm/tools/clang/test/PCH/chain-staticvar-instantiation.cpp
    RUN("%clang_cc1 -fsyntax-only -verify -include %s -include %s %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/PCH/chain-staticvar-instantiation.cpp -chain-include ${LLVM_SRC}/llvm/tools/clang/test/PCH/chain-staticvar-instantiation.cpp -chain-include ${LLVM_SRC}/llvm/tools/clang/test/PCH/chain-staticvar-instantiation.cpp
    RUN("%clang_cc1 -fsyntax-only -verify %s -chain-include %s -chain-include %s");
  }

  @Test
  public void test_chain_trivial_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/PCH/chain-trivial.c");
    // REQUIRES: x86-registered-target
    if (!CHECK_REQUIRES("x86-registered-target")) {
      return;
    }
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-unknown-unknown -emit-pch -o ${TEST_TEMP_DIR}/chain-trivial.c.tmp1 ${LLVM_SRC}/llvm/tools/clang/test/PCH/Inputs/chain-trivial1.h
    RUN("%clang_cc1 -triple x86_64-unknown-unknown -emit-pch -o %t1 %S/Inputs/chain-trivial1.h");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-unknown-unknown -emit-pch -o ${TEST_TEMP_DIR}/chain-trivial.c.tmp2 -include-pch ${TEST_TEMP_DIR}/chain-trivial.c.tmp1 ${LLVM_SRC}/llvm/tools/clang/test/PCH/Inputs/chain-trivial2.h
    RUN("%clang_cc1 -triple x86_64-unknown-unknown -emit-pch -o %t2 -include-pch %t1 %S/Inputs/chain-trivial2.h");
  }

  @Test
  public void test_chain_typo_corrections_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/PCH/chain-typo-corrections.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -verify -chain-include ${LLVM_SRC}/llvm/tools/clang/test/PCH/chain-typo-corrections.cpp ${LLVM_SRC}/llvm/tools/clang/test/PCH/chain-typo-corrections.cpp
    RUN("%clang_cc1 -verify -chain-include %s %s");
  }

  @Test
  public void test_changed_files_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/PCH/changed-files.c");
    // false
    RUN(TestState.Failed, "false");
    // echo '#define m0 ""' > ${TEST_TEMP_DIR}/changed-files.c.tmp.h
    RUN(TestState.Failed, "echo '#define m0 \"\"' > %t.h");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-pch -o ${TEST_TEMP_DIR}/changed-files.c.tmp.h.pch ${TEST_TEMP_DIR}/changed-files.c.tmp.h
    RUN(TestState.Failed, "%clang_cc1 -emit-pch -o %t.h.pch %t.h");
    // echo > ${TEST_TEMP_DIR}/changed-files.c.tmp.h
    RUN(TestState.Failed, "echo '' > %t.h");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -include-pch ${TEST_TEMP_DIR}/changed-files.c.tmp.h.pch ${LLVM_SRC}/llvm/tools/clang/test/PCH/changed-files.c 2> ${TEST_TEMP_DIR}/changed-files.c.tmp.stderr
    RUN(TestState.Failed, "not %clang_cc1 -include-pch %t.h.pch %s 2> %t.stderr");
    // grep modified ${TEST_TEMP_DIR}/changed-files.c.tmp.stderr
    RUN(TestState.Failed, "grep \"modified\" %t.stderr");
    // echo '#define m0 000' > ${TEST_TEMP_DIR}/changed-files.c.tmp.h
    RUN(TestState.Failed, "echo '#define m0 000' > %t.h");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-pch -o ${TEST_TEMP_DIR}/changed-files.c.tmp.h.pch ${TEST_TEMP_DIR}/changed-files.c.tmp.h
    RUN(TestState.Failed, "%clang_cc1 -emit-pch -o %t.h.pch %t.h");
    // echo > ${TEST_TEMP_DIR}/changed-files.c.tmp.h
    RUN(TestState.Failed, "echo '' > %t.h");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -include-pch ${TEST_TEMP_DIR}/changed-files.c.tmp.h.pch ${LLVM_SRC}/llvm/tools/clang/test/PCH/changed-files.c 2> ${TEST_TEMP_DIR}/changed-files.c.tmp.stderr
    RUN(TestState.Failed, "not %clang_cc1 -include-pch %t.h.pch %s 2> %t.stderr");
    // grep modified ${TEST_TEMP_DIR}/changed-files.c.tmp.stderr
    RUN(TestState.Failed, "grep \"modified\" %t.stderr");
    // echo '#define m0 000' > ${TEST_TEMP_DIR}/changed-files.c.tmp.h
    RUN(TestState.Failed, "echo '#define m0 000' > %t.h");
    // echo "#define m1 'abcd'" >> ${TEST_TEMP_DIR}/changed-files.c.tmp.h
    RUN(TestState.Failed, "echo \"#define m1 'abcd'\" >> %t.h");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-pch -o ${TEST_TEMP_DIR}/changed-files.c.tmp.h.pch ${TEST_TEMP_DIR}/changed-files.c.tmp.h
    RUN(TestState.Failed, "%clang_cc1 -emit-pch -o %t.h.pch %t.h");
    // echo > ${TEST_TEMP_DIR}/changed-files.c.tmp.h
    RUN(TestState.Failed, "echo '' > %t.h");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -include-pch ${TEST_TEMP_DIR}/changed-files.c.tmp.h.pch ${LLVM_SRC}/llvm/tools/clang/test/PCH/changed-files.c 2> ${TEST_TEMP_DIR}/changed-files.c.tmp.stderr
    RUN(TestState.Failed, "not %clang_cc1 -include-pch %t.h.pch %s 2> %t.stderr");
    // grep modified ${TEST_TEMP_DIR}/changed-files.c.tmp.stderr
    RUN(TestState.Failed, "grep \"modified\" %t.stderr");
  }

  @Test
  public void test_check_deserializations_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/PCH/check-deserializations.cpp");
    // REQUIRES: x86-registered-target
    if (!CHECK_REQUIRES("x86-registered-target")) {
      return;
    }
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-linux-gnu '-std=c++11' -emit-pch -o ${TEST_TEMP_DIR}/check-deserializations.cpp.tmp.1 ${LLVM_SRC}/llvm/tools/clang/test/PCH/check-deserializations.cpp
    RUN( "%clang_cc1 -triple x86_64-linux-gnu -std=c++11 -emit-pch -o %t.1 %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-linux-gnu -error-on-deserialized-decl S1_keyfunc -error-on-deserialized-decl S3 -error-on-deserialized-decl DND '-std=c++11' -include-pch ${TEST_TEMP_DIR}/check-deserializations.cpp.tmp.1 -emit-pch -o ${TEST_TEMP_DIR}/check-deserializations.cpp.tmp.2 ${LLVM_SRC}/llvm/tools/clang/test/PCH/check-deserializations.cpp
    RUN( "%clang_cc1 -triple x86_64-linux-gnu -error-on-deserialized-decl S1_keyfunc -error-on-deserialized-decl S3 -error-on-deserialized-decl DND -std=c++11 -include-pch %t.1 -emit-pch -o %t.2 %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-linux-gnu -error-on-deserialized-decl S1_method -error-on-deserialized-decl S3 -error-on-deserialized-decl DND '-std=c++11' -include-pch ${TEST_TEMP_DIR}/check-deserializations.cpp.tmp.2 -emit-llvm-only ${LLVM_SRC}/llvm/tools/clang/test/PCH/check-deserializations.cpp
    RUN( "%clang_cc1 -triple x86_64-linux-gnu -error-on-deserialized-decl S1_method -error-on-deserialized-decl S3 -error-on-deserialized-decl DND -std=c++11 -include-pch %t.2 -emit-llvm-only %s");
  }

  @Test
  public void test_cmdline_include_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/PCH/cmdline-include.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -include ${LLVM_SRC}/llvm/tools/clang/test/PCH/cmdline-include1.h -x c-header ${LLVM_SRC}/llvm/tools/clang/test/PCH/cmdline-include2.h -emit-pch -o ${TEST_TEMP_DIR}/cmdline-include.c.tmp
    RUN("%clang_cc1 -include %S/cmdline-include1.h -x c-header %S/cmdline-include2.h -emit-pch -o %t");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/PCH/cmdline-include.c -include-pch ${TEST_TEMP_DIR}/cmdline-include.c.tmp -fsyntax-only -verify
    RUN("%clang_cc1 %s -include-pch %t -fsyntax-only -verify");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x c-header ${LLVM_SRC}/llvm/tools/clang/test/PCH/cmdline-include1.h -emit-pch -o ${TEST_TEMP_DIR}/cmdline-include.c.tmp
    RUN("%clang_cc1 -x c-header %S/cmdline-include1.h -emit-pch -o %t");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/PCH/cmdline-include.c -include-pch ${TEST_TEMP_DIR}/cmdline-include.c.tmp -include ${LLVM_SRC}/llvm/tools/clang/test/PCH/cmdline-include2.h -fsyntax-only -verify
    RUN("%clang_cc1 %s -include-pch %t -include %S/cmdline-include2.h -fsyntax-only -verify");
  }

  @Test
  public void test_crash_12631281_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/PCH/crash-12631281.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc '-std=c++11' ${LLVM_SRC}/llvm/tools/clang/test/PCH/crash-12631281.cpp -emit-pch -o ${TEST_TEMP_DIR}/crash-12631281.cpp.tmp.pch
    RUN("%clang_cc1 -std=c++11 %s -emit-pch -o %t.pch");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only '-std=c++11' ${LLVM_SRC}/llvm/tools/clang/test/PCH/crash-12631281.cpp -include-pch ${TEST_TEMP_DIR}/crash-12631281.cpp.tmp.pch -verify
    RUN("%clang_cc1 -fsyntax-only -std=c++11 %s -include-pch %t.pch -verify");
  }

  @Test
  public void test_cuda_kernel_call_cu() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/PCH/cuda-kernel-call.cu");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-pch -o ${TEST_TEMP_DIR}/cuda-kernel-call.cu.tmp ${LLVM_SRC}/llvm/tools/clang/test/PCH/cuda-kernel-call.cu
    RUN("%clang_cc1 -emit-pch -o %t %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -include-pch ${TEST_TEMP_DIR}/cuda-kernel-call.cu.tmp -fsyntax-only ${LLVM_SRC}/llvm/tools/clang/test/PCH/cuda-kernel-call.cu
    RUN("%clang_cc1 -include-pch %t -fsyntax-only %s");
  }

  @Test
  public void test_cxx_alias_decl_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/PCH/cxx-alias-decl.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x c++ '-std=c++11' -include ${LLVM_SRC}/llvm/tools/clang/test/PCH/cxx-alias-decl.h -fsyntax-only -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/PCH/cxx-alias-decl.cpp
    RUN("%clang_cc1 -x c++ -std=c++11 -include %S/cxx-alias-decl.h -fsyntax-only -emit-llvm -o - %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x c++ '-std=c++11' -emit-pch -o ${TEST_TEMP_DIR}/cxx-alias-decl.cpp.tmp ${LLVM_SRC}/llvm/tools/clang/test/PCH/cxx-alias-decl.h
    RUN("%clang_cc1 -x c++ -std=c++11 -emit-pch -o %t %S/cxx-alias-decl.h");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x c++ '-std=c++11' -include-pch ${TEST_TEMP_DIR}/cxx-alias-decl.cpp.tmp -fsyntax-only -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/PCH/cxx-alias-decl.cpp
    RUN("%clang_cc1 -x c++ -std=c++11 -include-pch %t -fsyntax-only -emit-llvm -o - %s");
  }

  @Test
  public void test_cxx_chain_function_template_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/PCH/cxx-chain-function-template.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -chain-include ${LLVM_SRC}/llvm/tools/clang/test/PCH/cxx-chain-function-template.cpp -chain-include ${LLVM_SRC}/llvm/tools/clang/test/PCH/cxx-chain-function-template.cpp -fsyntax-only ${LLVM_SRC}/llvm/tools/clang/test/PCH/cxx-chain-function-template.cpp
    RUN(TestState.Failed, "%clang_cc1 -chain-include %s -chain-include %s -fsyntax-only %s");
  }

  @Test
  public void test_cxx_char_literal_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/PCH/cxx-char-literal.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-pch '-std=c++1z' -o ${TEST_TEMP_DIR}/cxx-char-literal.cpp.tmp ${LLVM_SRC}/llvm/tools/clang/test/PCH/cxx-char-literal.cpp
    RUN("%clang_cc1 -emit-pch -std=c++1z -o %t %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc '-std=c++1z' -x ast -ast-print ${TEST_TEMP_DIR}/cxx-char-literal.cpp.tmp | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/PCH/cxx-char-literal.cpp
    RUN("%clang_cc1 -std=c++1z -x ast -ast-print %t")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_cxx_constexpr_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/PCH/cxx-constexpr.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -pedantic-errors '-std=c++98' -emit-pch ${LLVM_SRC}/llvm/tools/clang/test/PCH/cxx-constexpr.cpp -o ${TEST_TEMP_DIR}/cxx-constexpr.cpp.tmp
    RUN("%clang_cc1 -pedantic-errors -std=c++98 -emit-pch %s -o %t");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -pedantic-errors '-std=c++98' -include-pch ${TEST_TEMP_DIR}/cxx-constexpr.cpp.tmp -verify ${LLVM_SRC}/llvm/tools/clang/test/PCH/cxx-constexpr.cpp
    RUN("%clang_cc1 -pedantic-errors -std=c++98 -include-pch %t -verify %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -pedantic-errors '-std=c++11' -emit-pch ${LLVM_SRC}/llvm/tools/clang/test/PCH/cxx-constexpr.cpp -o ${TEST_TEMP_DIR}/cxx-constexpr.cpp.tmp-cxx11
    RUN("%clang_cc1 -pedantic-errors -std=c++11 -emit-pch %s -o %t-cxx11");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -pedantic-errors '-std=c++11' -include-pch ${TEST_TEMP_DIR}/cxx-constexpr.cpp.tmp-cxx11 -verify ${LLVM_SRC}/llvm/tools/clang/test/PCH/cxx-constexpr.cpp
    RUN("%clang_cc1 -pedantic-errors -std=c++11 -include-pch %t-cxx11 -verify %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -pedantic-errors '-std=c++98' -emit-pch ${LLVM_SRC}/llvm/tools/clang/test/PCH/cxx-constexpr.cpp -o ${TEST_TEMP_DIR}/cxx-constexpr.cpp.tmp -fmodules
    RUN("%clang_cc1 -pedantic-errors -std=c++98 -emit-pch %s -o %t -fmodules");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -pedantic-errors '-std=c++98' -include-pch ${TEST_TEMP_DIR}/cxx-constexpr.cpp.tmp -verify ${LLVM_SRC}/llvm/tools/clang/test/PCH/cxx-constexpr.cpp -fmodules
    RUN("%clang_cc1 -pedantic-errors -std=c++98 -include-pch %t -verify %s -fmodules");
  }

  @Test
  public void test_cxx__exprs_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/PCH/cxx-exprs.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -include ${LLVM_SRC}/llvm/tools/clang/test/PCH/cxx-exprs.cpp -verify '-std=c++11' ${LLVM_SRC}/llvm/tools/clang/test/PCH/cxx-exprs.cpp
    RUN("%clang_cc1 -include %s -verify -std=c++11 %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc '-std=c++11' -emit-pch -o ${TEST_TEMP_DIR}/cxx-exprs.cpp.tmp ${LLVM_SRC}/llvm/tools/clang/test/PCH/cxx-exprs.cpp
    RUN("%clang_cc1 -std=c++11 -emit-pch -o %t %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -include-pch ${TEST_TEMP_DIR}/cxx-exprs.cpp.tmp -verify '-std=c++11' ${LLVM_SRC}/llvm/tools/clang/test/PCH/cxx-exprs.cpp
    RUN("%clang_cc1 -include-pch %t -verify -std=c++11 %s");
  }

  @Test
  public void test_cxx_for_range_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/PCH/cxx-for-range.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x c++ '-std=c++11' -include ${LLVM_SRC}/llvm/tools/clang/test/PCH/cxx-for-range.h -fsyntax-only -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/PCH/cxx-for-range.cpp
    RUN(TestState.Failed, "%clang_cc1 -x c++ -std=c++11 -include %S/cxx-for-range.h -fsyntax-only -emit-llvm -o - %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x c++ '-std=c++11' -emit-pch -o ${TEST_TEMP_DIR}/cxx-for-range.cpp.tmp ${LLVM_SRC}/llvm/tools/clang/test/PCH/cxx-for-range.h
    RUN(TestState.Failed, "%clang_cc1 -x c++ -std=c++11 -emit-pch -o %t %S/cxx-for-range.h");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x c++ '-std=c++11' -include-pch ${TEST_TEMP_DIR}/cxx-for-range.cpp.tmp -fsyntax-only -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/PCH/cxx-for-range.cpp
    RUN(TestState.Failed, "%clang_cc1 -x c++ -std=c++11 -include-pch %t -fsyntax-only -emit-llvm -o - %s");
  }

  @Test
  public void test_cxx_friends_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/PCH/cxx-friends.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -include ${LLVM_SRC}/llvm/tools/clang/test/PCH/cxx-friends.h -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/PCH/cxx-friends.cpp
    RUN("%clang_cc1 -include %S/cxx-friends.h -fsyntax-only -verify %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x c++-header -emit-pch -o ${TEST_TEMP_DIR}/cxx-friends.cpp.tmp ${LLVM_SRC}/llvm/tools/clang/test/PCH/cxx-friends.h
    RUN(TestState.Failed, "%clang_cc1 -x c++-header -emit-pch -o %t %S/cxx-friends.h");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -include-pch ${TEST_TEMP_DIR}/cxx-friends.cpp.tmp -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/PCH/cxx-friends.cpp -error-on-deserialized-decl doNotDeserialize
    RUN(TestState.Failed, "%clang_cc1 -include-pch %t -fsyntax-only -verify %s -error-on-deserialized-decl doNotDeserialize");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x c++-header -emit-pch -o ${TEST_TEMP_DIR}/cxx-friends.cpp.tmp ${LLVM_SRC}/llvm/tools/clang/test/PCH/cxx-friends.h -fmodules
    RUN(TestState.Failed, "%clang_cc1 -x c++-header -emit-pch -o %t %S/cxx-friends.h -fmodules");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -include-pch ${TEST_TEMP_DIR}/cxx-friends.cpp.tmp -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/PCH/cxx-friends.cpp -error-on-deserialized-decl doNotDeserialize -fmodules
    RUN(TestState.Failed, "%clang_cc1 -include-pch %t -fsyntax-only -verify %s -error-on-deserialized-decl doNotDeserialize -fmodules");
  }

  @Test
  public void test_cxx_functions_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/PCH/cxx-functions.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -include ${LLVM_SRC}/llvm/tools/clang/test/PCH/cxx-functions.h -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/PCH/cxx-functions.cpp
    RUN("%clang_cc1 -include %S/cxx-functions.h -fsyntax-only -verify %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x c++-header -emit-pch -o ${TEST_TEMP_DIR}/cxx-functions.cpp.tmp ${LLVM_SRC}/llvm/tools/clang/test/PCH/cxx-functions.h
    RUN("%clang_cc1 -x c++-header -emit-pch -o %t %S/cxx-functions.h");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -include-pch ${TEST_TEMP_DIR}/cxx-functions.cpp.tmp -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/PCH/cxx-functions.cpp
    RUN("%clang_cc1 -include-pch %t -fsyntax-only -verify %s");
  }

  @Test
  public void test_cxx_implicit_moves_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/PCH/cxx-implicit-moves.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc '-std=c++11' -x c++-header -emit-pch -o ${TEST_TEMP_DIR}/cxx-implicit-moves.cpp.tmp ${LLVM_SRC}/llvm/tools/clang/test/PCH/cxx-implicit-moves.cpp
    RUN("%clang_cc1 -std=c++11 -x c++-header -emit-pch -o %t %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc '-std=c++11' -include-pch ${TEST_TEMP_DIR}/cxx-implicit-moves.cpp.tmp -verify ${LLVM_SRC}/llvm/tools/clang/test/PCH/cxx-implicit-moves.cpp
    RUN("%clang_cc1 -std=c++11 -include-pch %t -verify %s");
  }

  @Test
  public void test_cxx_key_functions_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/PCH/cxx-key-functions.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x c++ -include ${LLVM_SRC}/llvm/tools/clang/test/PCH/cxx-key-functions.cpp -emit-llvm-only ${LLVM_SRC}/llvm/tools/clang/test/PCH/cxx-key-functions.cpp
    RUN(TestState.Failed, "%clang_cc1 -x c++ -include %s -emit-llvm-only %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x c++ -emit-pch ${LLVM_SRC}/llvm/tools/clang/test/PCH/cxx-key-functions.cpp -o ${TEST_TEMP_DIR}/cxx-key-functions.cpp.tmp
    RUN(TestState.Failed, "%clang_cc1 -x c++ -emit-pch %s -o %t");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -include-pch ${TEST_TEMP_DIR}/cxx-key-functions.cpp.tmp -emit-llvm-only ${LLVM_SRC}/llvm/tools/clang/test/PCH/cxx-key-functions.cpp
    RUN(TestState.Failed, "%clang_cc1 -include-pch %t -emit-llvm-only %s");
  }

  @Test
  public void test_cxx_mangling_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/PCH/cxx-mangling.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc '-std=c++11' -triple i386-pc-solaris2.11 -fcxx-exceptions -fexceptions -include ${LLVM_SRC}/llvm/tools/clang/test/PCH/cxx-mangling.cpp ${LLVM_SRC}/llvm/tools/clang/test/PCH/cxx-mangling.cpp -emit-llvm -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/PCH/cxx-mangling.cpp
    RUN(TestState.Failed, "%clang_cc1 -std=c++11 -triple %itanium_abi_triple -fcxx-exceptions -fexceptions -include %s %s -emit-llvm -o -")./*|*/
      I("FileCheck %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc '-std=c++11' -triple i386-pc-solaris2.11 -fcxx-exceptions -fexceptions -x c++-header ${LLVM_SRC}/llvm/tools/clang/test/PCH/cxx-mangling.cpp -emit-pch -o ${TEST_TEMP_DIR}/cxx-mangling.cpp.tmp
    RUN(TestState.Failed, "%clang_cc1 -std=c++11 -triple %itanium_abi_triple -fcxx-exceptions -fexceptions -x c++-header %s -emit-pch -o %t");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc '-std=c++11' -triple i386-pc-solaris2.11 -fcxx-exceptions -fexceptions -include-pch ${TEST_TEMP_DIR}/cxx-mangling.cpp.tmp ${LLVM_SRC}/llvm/tools/clang/test/PCH/cxx-mangling.cpp -emit-llvm -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/PCH/cxx-mangling.cpp
    RUN(TestState.Failed, "%clang_cc1 -std=c++11 -triple %itanium_abi_triple -fcxx-exceptions -fexceptions -include-pch %t %s -emit-llvm -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_cxx_member_init_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/PCH/cxx-member-init.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x c++ '-std=c++11' -DHEADER -DSOURCE -fsyntax-only -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/PCH/cxx-member-init.cpp
    RUN(TestState.Failed, "%clang_cc1 -x c++ -std=c++11 -DHEADER -DSOURCE -fsyntax-only -emit-llvm -o - %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x c++ '-std=c++11' -DHEADER -emit-pch -o ${TEST_TEMP_DIR}/cxx-member-init.cpp.tmp ${LLVM_SRC}/llvm/tools/clang/test/PCH/cxx-member-init.cpp
    RUN(TestState.Failed, "%clang_cc1 -x c++ -std=c++11 -DHEADER -emit-pch -o %t %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x c++ '-std=c++11' -DHEADER -include-pch ${TEST_TEMP_DIR}/cxx-member-init.cpp.tmp -fsyntax-only -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/PCH/cxx-member-init.cpp
    RUN(TestState.Failed, "%clang_cc1 -x c++ -std=c++11 -DHEADER -include-pch %t -fsyntax-only -emit-llvm -o - %s");
  }

  @Test
  public void test_cxx_method_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/PCH/cxx-method.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x c++ -include ${LLVM_SRC}/llvm/tools/clang/test/PCH/Inputs/cxx-method.h -verify ${LLVM_SRC}/llvm/tools/clang/test/PCH/cxx-method.cpp
    RUN("%clang_cc1 -x c++ -include %S/Inputs/cxx-method.h -verify %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x c++ -emit-pch ${LLVM_SRC}/llvm/tools/clang/test/PCH/Inputs/cxx-method.h -o ${TEST_TEMP_DIR}/cxx-method.cpp.tmp
    RUN("%clang_cc1 -x c++ -emit-pch %S/Inputs/cxx-method.h -o %t");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -include-pch ${TEST_TEMP_DIR}/cxx-method.cpp.tmp -verify ${LLVM_SRC}/llvm/tools/clang/test/PCH/cxx-method.cpp
    RUN("%clang_cc1 -include-pch %t -verify %s");
  }

  @Test
  public void test_cxx_ms_function_specialization_class_scope_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/PCH/cxx-ms-function-specialization-class-scope.cpp");
    // REQUIRES: x86-registered-target
    if (!CHECK_REQUIRES("x86-registered-target")) {
      return;
    }
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fms-extensions -triple i386-unknown-unknown -x c++-header -emit-pch -o ${TEST_TEMP_DIR}/cxx-ms-function-specialization-class-scope.cpp.tmp ${LLVM_SRC}/llvm/tools/clang/test/PCH/cxx-ms-function-specialization-class-scope.h
    RUN("%clang_cc1 -fms-extensions -triple i386-unknown-unknown  -x c++-header -emit-pch -o %t %S/cxx-ms-function-specialization-class-scope.h");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fms-extensions -triple i386-unknown-unknown -include-pch ${TEST_TEMP_DIR}/cxx-ms-function-specialization-class-scope.cpp.tmp -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/PCH/cxx-ms-function-specialization-class-scope.cpp
    RUN("%clang_cc1 -fms-extensions -triple i386-unknown-unknown -include-pch %t -fsyntax-only -verify %s");
  }

  @Test
  public void test_cxx_namespaces_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/PCH/cxx-namespaces.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -include ${LLVM_SRC}/llvm/tools/clang/test/PCH/cxx-namespaces.h -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/PCH/cxx-namespaces.cpp
    RUN("%clang_cc1 -include %S/cxx-namespaces.h -fsyntax-only -verify %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x c++-header -emit-pch -o ${TEST_TEMP_DIR}/cxx-namespaces.cpp.tmp ${LLVM_SRC}/llvm/tools/clang/test/PCH/cxx-namespaces.h
    RUN("%clang_cc1 -x c++-header -emit-pch -o %t %S/cxx-namespaces.h");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -include-pch ${TEST_TEMP_DIR}/cxx-namespaces.cpp.tmp -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/PCH/cxx-namespaces.cpp
    RUN("%clang_cc1 -include-pch %t -fsyntax-only -verify %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -include-pch ${TEST_TEMP_DIR}/cxx-namespaces.cpp.tmp -fsyntax-only -ast-dump-lookups -ast-dump-filter N ${LLVM_SRC}/llvm/tools/clang/test/PCH/cxx-namespaces.cpp | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/PCH/cxx-namespaces.cpp
    RUN("%clang_cc1 -include-pch %t -fsyntax-only -ast-dump-lookups -ast-dump-filter N %s")./*|*/
      I("FileCheck %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fmodules -x c++-header -emit-pch -o ${TEST_TEMP_DIR}/cxx-namespaces.cpp.tmp ${LLVM_SRC}/llvm/tools/clang/test/PCH/cxx-namespaces.h
    RUN("%clang_cc1 -fmodules -x c++-header -emit-pch -o %t %S/cxx-namespaces.h");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fmodules -include-pch ${TEST_TEMP_DIR}/cxx-namespaces.cpp.tmp -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/PCH/cxx-namespaces.cpp
    RUN("%clang_cc1 -fmodules -include-pch %t -fsyntax-only -verify %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fmodules -include-pch ${TEST_TEMP_DIR}/cxx-namespaces.cpp.tmp -fsyntax-only -ast-dump-lookups -ast-dump-filter N ${LLVM_SRC}/llvm/tools/clang/test/PCH/cxx-namespaces.cpp | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/PCH/cxx-namespaces.cpp
    RUN("%clang_cc1 -fmodules -include-pch %t -fsyntax-only -ast-dump-lookups -ast-dump-filter N %s")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_cxx_offsetof_base_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/PCH/cxx-offsetof-base.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x c++-header -emit-pch -o ${TEST_TEMP_DIR}/cxx-offsetof-base.cpp.tmp ${LLVM_SRC}/llvm/tools/clang/test/PCH/cxx-offsetof-base.h
    RUN("%clang_cc1 -x c++-header -emit-pch -o %t %S/cxx-offsetof-base.h");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -include-pch ${TEST_TEMP_DIR}/cxx-offsetof-base.cpp.tmp -fsyntax-only ${LLVM_SRC}/llvm/tools/clang/test/PCH/cxx-offsetof-base.cpp
    RUN("%clang_cc1 -include-pch %t -fsyntax-only %s");
  }

  @Test
  public void test_cxx_reference_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/PCH/cxx-reference.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x c++ -triple i386-pc-solaris2.11 '-std=c++11' -include ${LLVM_SRC}/llvm/tools/clang/test/PCH/cxx-reference.h -fsyntax-only -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/PCH/cxx-reference.cpp
    RUN("%clang_cc1 -x c++ -triple %itanium_abi_triple -std=c++11 -include %S/cxx-reference.h -fsyntax-only -emit-llvm -o - %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x c++ -triple i386-pc-solaris2.11 '-std=c++11' -emit-pch -o ${TEST_TEMP_DIR}/cxx-reference.cpp.tmp ${LLVM_SRC}/llvm/tools/clang/test/PCH/cxx-reference.h
    RUN("%clang_cc1 -x c++ -triple %itanium_abi_triple -std=c++11 -emit-pch -o %t %S/cxx-reference.h");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x c++ -triple i386-pc-solaris2.11 '-std=c++11' -include-pch ${TEST_TEMP_DIR}/cxx-reference.cpp.tmp -fsyntax-only -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/PCH/cxx-reference.cpp
    RUN("%clang_cc1 -x c++ -triple %itanium_abi_triple -std=c++11 -include-pch %t -fsyntax-only -emit-llvm -o - %s");
  }

  @Test
  public void test_cxx_required_decls_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/PCH/cxx-required-decls.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -include ${LLVM_SRC}/llvm/tools/clang/test/PCH/cxx-required-decls.h ${LLVM_SRC}/llvm/tools/clang/test/PCH/cxx-required-decls.cpp -triple i386-pc-solaris2.11 -emit-llvm -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/PCH/cxx-required-decls.cpp
    RUN(TestState.Failed, "%clang_cc1 -include %S/cxx-required-decls.h %s -triple %itanium_abi_triple -emit-llvm -o -")./*|*/
      I("FileCheck %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x c++-header -triple i386-pc-solaris2.11 -emit-pch -o ${TEST_TEMP_DIR}/cxx-required-decls.cpp.tmp ${LLVM_SRC}/llvm/tools/clang/test/PCH/cxx-required-decls.h
    RUN(TestState.Failed, "%clang_cc1 -x c++-header -triple %itanium_abi_triple -emit-pch -o %t %S/cxx-required-decls.h");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -include-pch ${TEST_TEMP_DIR}/cxx-required-decls.cpp.tmp ${LLVM_SRC}/llvm/tools/clang/test/PCH/cxx-required-decls.cpp -triple i386-pc-solaris2.11 -emit-llvm -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/PCH/cxx-required-decls.cpp
    RUN(TestState.Failed, "%clang_cc1 -include-pch %t %s -triple %itanium_abi_triple -emit-llvm -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_cxx_static_assert_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/PCH/cxx-static_assert.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -include ${LLVM_SRC}/llvm/tools/clang/test/PCH/cxx-static_assert.cpp -verify '-std=c++11' ${LLVM_SRC}/llvm/tools/clang/test/PCH/cxx-static_assert.cpp
    RUN("%clang_cc1 -include %s -verify -std=c++11 %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc '-std=c++11' -emit-pch -o ${TEST_TEMP_DIR}/cxx-static_assert.cpp.tmp ${LLVM_SRC}/llvm/tools/clang/test/PCH/cxx-static_assert.cpp
    RUN("%clang_cc1 -std=c++11 -emit-pch -o %t %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -include-pch ${TEST_TEMP_DIR}/cxx-static_assert.cpp.tmp -verify '-std=c++11' ${LLVM_SRC}/llvm/tools/clang/test/PCH/cxx-static_assert.cpp
    RUN("%clang_cc1 -include-pch %t -verify -std=c++11 %s");
  }

  @Test
  public void test_cxx_templates_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/PCH/cxx-templates.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc '-std=c++11' -triple i386-pc-solaris2.11 -fcxx-exceptions -fexceptions -include ${LLVM_SRC}/llvm/tools/clang/test/PCH/cxx-templates.h -verify ${LLVM_SRC}/llvm/tools/clang/test/PCH/cxx-templates.cpp -ast-dump -o -
    RUN(TestState.Failed, "%clang_cc1 -std=c++11 -triple %itanium_abi_triple -fcxx-exceptions -fexceptions -include %S/cxx-templates.h -verify %s -ast-dump -o -");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc '-std=c++11' -triple i386-pc-solaris2.11 -fcxx-exceptions -fexceptions -include ${LLVM_SRC}/llvm/tools/clang/test/PCH/cxx-templates.h ${LLVM_SRC}/llvm/tools/clang/test/PCH/cxx-templates.cpp -emit-llvm -o - -DNO_ERRORS | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/PCH/cxx-templates.cpp
    RUN(TestState.Failed, "%clang_cc1 -std=c++11 -triple %itanium_abi_triple -fcxx-exceptions -fexceptions -include %S/cxx-templates.h %s -emit-llvm -o - -DNO_ERRORS")./*|*/
      I("FileCheck %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc '-std=c++11' -triple i386-pc-solaris2.11 -fcxx-exceptions -fexceptions -x c++-header -emit-pch -o ${TEST_TEMP_DIR}/cxx-templates.cpp.tmp ${LLVM_SRC}/llvm/tools/clang/test/PCH/cxx-templates.h
    RUN(TestState.Failed, "%clang_cc1 -std=c++11 -triple %itanium_abi_triple -fcxx-exceptions -fexceptions -x c++-header -emit-pch -o %t %S/cxx-templates.h");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc '-std=c++11' -triple i386-pc-solaris2.11 -fcxx-exceptions -fexceptions -include-pch ${TEST_TEMP_DIR}/cxx-templates.cpp.tmp -verify ${LLVM_SRC}/llvm/tools/clang/test/PCH/cxx-templates.cpp -ast-dump -o -
    RUN(TestState.Failed, "%clang_cc1 -std=c++11 -triple %itanium_abi_triple -fcxx-exceptions -fexceptions -include-pch %t -verify %s -ast-dump  -o -");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc '-std=c++11' -triple i386-pc-solaris2.11 -fcxx-exceptions -fexceptions -include-pch ${TEST_TEMP_DIR}/cxx-templates.cpp.tmp ${LLVM_SRC}/llvm/tools/clang/test/PCH/cxx-templates.cpp -emit-llvm -o - -error-on-deserialized-decl doNotDeserialize -DNO_ERRORS | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/PCH/cxx-templates.cpp
    RUN(TestState.Failed, "%clang_cc1 -std=c++11 -triple %itanium_abi_triple -fcxx-exceptions -fexceptions -include-pch %t %s -emit-llvm -o - -error-on-deserialized-decl doNotDeserialize -DNO_ERRORS")./*|*/
      I("FileCheck %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc '-std=c++11' -triple i386-pc-solaris2.11 -fcxx-exceptions -fexceptions -fmodules -x c++-header -emit-pch -o ${TEST_TEMP_DIR}/cxx-templates.cpp.tmp ${LLVM_SRC}/llvm/tools/clang/test/PCH/cxx-templates.h
    RUN(TestState.Failed, "%clang_cc1 -std=c++11 -triple %itanium_abi_triple -fcxx-exceptions -fexceptions -fmodules -x c++-header -emit-pch -o %t %S/cxx-templates.h");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc '-std=c++11' -triple i386-pc-solaris2.11 -fcxx-exceptions -fexceptions -fmodules -include-pch ${TEST_TEMP_DIR}/cxx-templates.cpp.tmp -verify ${LLVM_SRC}/llvm/tools/clang/test/PCH/cxx-templates.cpp -ast-dump -o -
    RUN(TestState.Failed, "%clang_cc1 -std=c++11 -triple %itanium_abi_triple -fcxx-exceptions -fexceptions -fmodules -include-pch %t -verify %s -ast-dump  -o -");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc '-std=c++11' -triple i386-pc-solaris2.11 -fcxx-exceptions -fexceptions -fmodules -include-pch ${TEST_TEMP_DIR}/cxx-templates.cpp.tmp ${LLVM_SRC}/llvm/tools/clang/test/PCH/cxx-templates.cpp -emit-llvm -o - -error-on-deserialized-decl doNotDeserialize -DNO_ERRORS '-fmodules-ignore-macro=NO_ERRORS' | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/PCH/cxx-templates.cpp
    RUN(TestState.Failed, "%clang_cc1 -std=c++11 -triple %itanium_abi_triple -fcxx-exceptions -fexceptions -fmodules -include-pch %t %s -emit-llvm -o - -error-on-deserialized-decl doNotDeserialize -DNO_ERRORS -fmodules-ignore-macro=NO_ERRORS")./*|*/
      I("FileCheck %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc '-std=c++11' -triple i386-pc-solaris2.11 -fcxx-exceptions -fdelayed-template-parsing -fexceptions -x c++-header -emit-pch -o ${TEST_TEMP_DIR}/cxx-templates.cpp.tmp ${LLVM_SRC}/llvm/tools/clang/test/PCH/cxx-templates.h
    RUN(TestState.Failed, "%clang_cc1 -std=c++11 -triple %itanium_abi_triple -fcxx-exceptions -fdelayed-template-parsing -fexceptions -x c++-header -emit-pch -o %t %S/cxx-templates.h");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc '-std=c++11' -triple i386-pc-solaris2.11 -fcxx-exceptions -fdelayed-template-parsing -fexceptions -include-pch ${TEST_TEMP_DIR}/cxx-templates.cpp.tmp -verify ${LLVM_SRC}/llvm/tools/clang/test/PCH/cxx-templates.cpp -ast-dump -o -
    RUN(TestState.Failed, "%clang_cc1 -std=c++11 -triple %itanium_abi_triple -fcxx-exceptions -fdelayed-template-parsing -fexceptions -include-pch %t -verify %s -ast-dump  -o -");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc '-std=c++11' -triple i386-pc-solaris2.11 -fcxx-exceptions -fdelayed-template-parsing -fexceptions -include-pch ${TEST_TEMP_DIR}/cxx-templates.cpp.tmp ${LLVM_SRC}/llvm/tools/clang/test/PCH/cxx-templates.cpp -emit-llvm -o - -DNO_ERRORS | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/PCH/cxx-templates.cpp
    RUN(TestState.Failed, "%clang_cc1 -std=c++11 -triple %itanium_abi_triple -fcxx-exceptions -fdelayed-template-parsing -fexceptions -include-pch %t %s -emit-llvm -o - -DNO_ERRORS")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_cxx_trailing_return_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/PCH/cxx-trailing-return.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -pedantic-errors '-std=c++11' -emit-pch ${LLVM_SRC}/llvm/tools/clang/test/PCH/cxx-trailing-return.cpp -o ${TEST_TEMP_DIR}/cxx-trailing-return.cpp.tmp-cxx11
    RUN("%clang_cc1 -pedantic-errors -std=c++11 -emit-pch %s -o %t-cxx11");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -pedantic-errors '-std=c++11' -include-pch ${TEST_TEMP_DIR}/cxx-trailing-return.cpp.tmp-cxx11 -verify ${LLVM_SRC}/llvm/tools/clang/test/PCH/cxx-trailing-return.cpp
    RUN("%clang_cc1 -pedantic-errors -std=c++11 -include-pch %t-cxx11 -verify %s");
  }

  @Test
  public void test_cxx_traits_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/PCH/cxx-traits.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fms-extensions -include ${LLVM_SRC}/llvm/tools/clang/test/PCH/cxx-traits.h '-std=c++11' -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/PCH/cxx-traits.cpp
    RUN("%clang_cc1 -fms-extensions -include %S/cxx-traits.h -std=c++11 -fsyntax-only -verify %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fms-extensions -x c++-header '-std=c++11' -emit-pch -o ${TEST_TEMP_DIR}/cxx-traits.cpp.tmp ${LLVM_SRC}/llvm/tools/clang/test/PCH/cxx-traits.h
    RUN("%clang_cc1 -fms-extensions -x c++-header -std=c++11 -emit-pch -o %t %S/cxx-traits.h");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fms-extensions '-std=c++11' -include-pch ${TEST_TEMP_DIR}/cxx-traits.cpp.tmp -DPCH -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/PCH/cxx-traits.cpp
    RUN("%clang_cc1 -fms-extensions -std=c++11 -include-pch %t -DPCH -fsyntax-only -verify %s");
  }

  @Test
  public void test_cxx_typeid_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/PCH/cxx-typeid.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -include ${LLVM_SRC}/llvm/tools/clang/test/PCH/cxx-typeid.h -fsyntax-only '-stdlib=libstdc++' -verify ${LLVM_SRC}/llvm/tools/clang/test/PCH/cxx-typeid.cpp
    RUN("%clang_cc1 -include %S/cxx-typeid.h -fsyntax-only -stdlib=libstdc++ -verify %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x c++-header -emit-pch '-stdlib=libstdc++' -o ${TEST_TEMP_DIR}/cxx-typeid.cpp.tmp.pch ${LLVM_SRC}/llvm/tools/clang/test/PCH/cxx-typeid.h
    RUN("%clang_cc1 -x c++-header -emit-pch -stdlib=libstdc++ -o %t.pch %S/cxx-typeid.h");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -include-pch ${TEST_TEMP_DIR}/cxx-typeid.cpp.tmp.pch -fsyntax-only '-stdlib=libstdc++' -verify ${LLVM_SRC}/llvm/tools/clang/test/PCH/cxx-typeid.cpp
    RUN("%clang_cc1 -include-pch %t.pch -fsyntax-only -stdlib=libstdc++ -verify %s");
  }

  @Test
  public void test_cxx_using_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/PCH/cxx-using.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -include ${LLVM_SRC}/llvm/tools/clang/test/PCH/cxx-using.h -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/PCH/cxx-using.cpp
    RUN("%clang_cc1 -include %S/cxx-using.h -fsyntax-only -verify %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x c++-header -emit-pch -o ${TEST_TEMP_DIR}/cxx-using.cpp.tmp ${LLVM_SRC}/llvm/tools/clang/test/PCH/cxx-using.h
    RUN("%clang_cc1 -x c++-header -emit-pch -o %t %S/cxx-using.h");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -include-pch ${TEST_TEMP_DIR}/cxx-using.cpp.tmp -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/PCH/cxx-using.cpp
    RUN("%clang_cc1 -include-pch %t -fsyntax-only -verify %s");
  }

  @Test
  public void test_cxx_variadic_templates_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/PCH/cxx-variadic-templates.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc '-std=c++11' -include ${LLVM_SRC}/llvm/tools/clang/test/PCH/cxx-variadic-templates.h -verify ${LLVM_SRC}/llvm/tools/clang/test/PCH/cxx-variadic-templates.cpp -ast-dump -o -
    RUN("%clang_cc1 -std=c++11 -include %S/cxx-variadic-templates.h -verify %s -ast-dump -o -");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc '-std=c++11' -include ${LLVM_SRC}/llvm/tools/clang/test/PCH/cxx-variadic-templates.h ${LLVM_SRC}/llvm/tools/clang/test/PCH/cxx-variadic-templates.cpp -emit-llvm -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/PCH/cxx-variadic-templates.cpp
    RUN(TestState.Failed, "%clang_cc1 -std=c++11 -include %S/cxx-variadic-templates.h %s -emit-llvm -o -")./*|*/
      I("FileCheck %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc '-std=c++11' -x c++-header -emit-pch -o ${TEST_TEMP_DIR}/cxx-variadic-templates.cpp.tmp ${LLVM_SRC}/llvm/tools/clang/test/PCH/cxx-variadic-templates.h
    RUN(TestState.Failed, "%clang_cc1 -std=c++11 -x c++-header -emit-pch -o %t %S/cxx-variadic-templates.h");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc '-std=c++11' -include-pch ${TEST_TEMP_DIR}/cxx-variadic-templates.cpp.tmp -verify ${LLVM_SRC}/llvm/tools/clang/test/PCH/cxx-variadic-templates.cpp -ast-dump -o -
    RUN(TestState.Failed, "%clang_cc1 -std=c++11 -include-pch %t -verify %s -ast-dump  -o -");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc '-std=c++11' -include-pch ${TEST_TEMP_DIR}/cxx-variadic-templates.cpp.tmp ${LLVM_SRC}/llvm/tools/clang/test/PCH/cxx-variadic-templates.cpp -emit-llvm -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/PCH/cxx-variadic-templates.cpp
    RUN(TestState.Failed, "%clang_cc1 -std=c++11 -include-pch %t %s -emit-llvm -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_cxx_variadic_templates_with_default_params_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/PCH/cxx-variadic-templates-with-default-params.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc '-std=c++11' -include ${LLVM_SRC}/llvm/tools/clang/test/PCH/cxx-variadic-templates-with-default-params.cpp -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/PCH/cxx-variadic-templates-with-default-params.cpp
    RUN("%clang_cc1 -std=c++11 -include %s -fsyntax-only -verify %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc '-std=c++11' -x c++-header -emit-pch -o ${TEST_TEMP_DIR}/cxx-variadic-templates-with-default-params.cpp.tmp ${LLVM_SRC}/llvm/tools/clang/test/PCH/cxx-variadic-templates-with-default-params.cpp
    RUN("%clang_cc1 -std=c++11 -x c++-header -emit-pch -o %t %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc '-std=c++11' -include-pch ${TEST_TEMP_DIR}/cxx-variadic-templates-with-default-params.cpp.tmp -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/PCH/cxx-variadic-templates-with-default-params.cpp
    RUN("%clang_cc1 -std=c++11 -include-pch %t -fsyntax-only -verify %s");
  }

  @Test
  public void test_cxx0x_default_delete_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/PCH/cxx0x-default-delete.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc '-std=c++11' -fsyntax-only -verify -include ${LLVM_SRC}/llvm/tools/clang/test/PCH/cxx0x-default-delete.cpp ${LLVM_SRC}/llvm/tools/clang/test/PCH/cxx0x-default-delete.cpp
    RUN("%clang_cc1 -std=c++11 -fsyntax-only -verify -include %s %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x c++-header '-std=c++11' -emit-pch -o ${TEST_TEMP_DIR}/cxx0x-default-delete.cpp.tmp ${LLVM_SRC}/llvm/tools/clang/test/PCH/cxx0x-default-delete.cpp
    RUN("%clang_cc1 -x c++-header -std=c++11 -emit-pch -o %t %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc '-std=c++11' -fsyntax-only -verify -include-pch ${TEST_TEMP_DIR}/cxx0x-default-delete.cpp.tmp ${LLVM_SRC}/llvm/tools/clang/test/PCH/cxx0x-default-delete.cpp
    RUN("%clang_cc1 -std=c++11 -fsyntax-only -verify -include-pch %t %s");
  }

  @Test
  public void test_cxx0x_delegating_ctors_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/PCH/cxx0x-delegating-ctors.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -include ${LLVM_SRC}/llvm/tools/clang/test/PCH/cxx0x-delegating-ctors.cpp '-std=c++11' -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/PCH/cxx0x-delegating-ctors.cpp
    RUN("%clang_cc1 -include %s -std=c++11 -fsyntax-only -verify %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x c++-header '-std=c++11' -emit-pch -o ${TEST_TEMP_DIR}/cxx0x-delegating-ctors.cpp.tmp ${LLVM_SRC}/llvm/tools/clang/test/PCH/cxx0x-delegating-ctors.cpp
    RUN("%clang_cc1 -x c++-header -std=c++11 -emit-pch -o %t %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc '-std=c++11' -include-pch ${TEST_TEMP_DIR}/cxx0x-delegating-ctors.cpp.tmp -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/PCH/cxx0x-delegating-ctors.cpp
    RUN("%clang_cc1 -std=c++11 -include-pch %t -fsyntax-only -verify %s");
  }

  @Test
  public void test_cxx11_constexpr_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/PCH/cxx11-constexpr.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -pedantic-errors '-std=c++11' -emit-pch ${LLVM_SRC}/llvm/tools/clang/test/PCH/cxx11-constexpr.cpp -o ${TEST_TEMP_DIR}/cxx11-constexpr.cpp.tmp
    RUN("%clang_cc1 -pedantic-errors -std=c++11 -emit-pch %s -o %t");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -pedantic-errors '-std=c++11' -include-pch ${TEST_TEMP_DIR}/cxx11-constexpr.cpp.tmp -verify ${LLVM_SRC}/llvm/tools/clang/test/PCH/cxx11-constexpr.cpp
    RUN("%clang_cc1 -pedantic-errors -std=c++11 -include-pch %t -verify %s");
  }

  @Test
  public void test_cxx11_enum_template_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/PCH/cxx11-enum-template.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -pedantic-errors '-std=c++11' -emit-pch ${LLVM_SRC}/llvm/tools/clang/test/PCH/cxx11-enum-template.cpp -o ${TEST_TEMP_DIR}/cxx11-enum-template.cpp.tmp
    RUN("%clang_cc1 -pedantic-errors -std=c++11 -emit-pch %s -o %t");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -pedantic-errors '-std=c++11' -include-pch ${TEST_TEMP_DIR}/cxx11-enum-template.cpp.tmp -verify ${LLVM_SRC}/llvm/tools/clang/test/PCH/cxx11-enum-template.cpp
    RUN("%clang_cc1 -pedantic-errors -std=c++11 -include-pch %t -verify %s");
  }

  @Test
  public void test_cxx11_exception_spec_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/PCH/cxx11-exception-spec.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -pedantic-errors '-std=c++11' -emit-pch ${LLVM_SRC}/llvm/tools/clang/test/PCH/cxx11-exception-spec.cpp -o ${TEST_TEMP_DIR}/cxx11-exception-spec.cpp.tmp.1
    RUN(TestState.Failed, "%clang_cc1 -pedantic-errors -std=c++11 -emit-pch %s -o %t.1");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -pedantic-errors '-std=c++11' -include-pch ${TEST_TEMP_DIR}/cxx11-exception-spec.cpp.tmp.1 -emit-pch ${LLVM_SRC}/llvm/tools/clang/test/PCH/cxx11-exception-spec.cpp -o ${TEST_TEMP_DIR}/cxx11-exception-spec.cpp.tmp.2
    RUN(TestState.Failed, "%clang_cc1 -pedantic-errors -std=c++11 -include-pch %t.1 -emit-pch %s -o %t.2");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -pedantic-errors '-std=c++11' -include-pch ${TEST_TEMP_DIR}/cxx11-exception-spec.cpp.tmp.2 -verify ${LLVM_SRC}/llvm/tools/clang/test/PCH/cxx11-exception-spec.cpp
    RUN(TestState.Failed, "%clang_cc1 -pedantic-errors -std=c++11 -include-pch %t.2 -verify %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -pedantic-errors '-std=c++11' -include-pch ${TEST_TEMP_DIR}/cxx11-exception-spec.cpp.tmp.2 -emit-llvm-only ${LLVM_SRC}/llvm/tools/clang/test/PCH/cxx11-exception-spec.cpp
    RUN(TestState.Failed, "%clang_cc1 -pedantic-errors -std=c++11 -include-pch %t.2 -emit-llvm-only %s");
  }

  @Test
  public void test_cxx11_inheriting_ctors_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/PCH/cxx11-inheriting-ctors.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc '-std=c++11' -include ${LLVM_SRC}/llvm/tools/clang/test/PCH/cxx11-inheriting-ctors.cpp -include ${LLVM_SRC}/llvm/tools/clang/test/PCH/cxx11-inheriting-ctors.cpp -verify ${LLVM_SRC}/llvm/tools/clang/test/PCH/cxx11-inheriting-ctors.cpp
    RUN("%clang_cc1 -std=c++11 -include %s -include %s -verify %s");
  }

  @Test
  public void test_cxx11_lambdas_mm() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/PCH/cxx11-lambdas.mm");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -pedantic-errors -fblocks '-std=c++1y' -emit-pch ${LLVM_SRC}/llvm/tools/clang/test/PCH/cxx11-lambdas.mm -o ${TEST_TEMP_DIR}/cxx11-lambdas.mm.tmp-cxx11
    RUN("%clang_cc1 -pedantic-errors -fblocks -std=c++1y -emit-pch %s -o %t-cxx11");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -ast-print -pedantic-errors -fblocks '-std=c++1y' -include-pch ${TEST_TEMP_DIR}/cxx11-lambdas.mm.tmp-cxx11 ${LLVM_SRC}/llvm/tools/clang/test/PCH/cxx11-lambdas.mm | ${LLVM_SRC}/build/bin/FileCheck '-check-prefix=CHECK-PRINT' ${LLVM_SRC}/llvm/tools/clang/test/PCH/cxx11-lambdas.mm
    RUN("%clang_cc1 -ast-print -pedantic-errors -fblocks -std=c++1y -include-pch %t-cxx11  %s")./*|*/
      I("FileCheck -check-prefix=CHECK-PRINT %s");
  }

  @Test
  public void test_cxx11_statement_attributes_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/PCH/cxx11-statement-attributes.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -include ${LLVM_SRC}/llvm/tools/clang/test/PCH/Inputs/cxx11-statement-attributes.h '-std=c++11' -Wimplicit-fallthrough -fsyntax-only ${LLVM_SRC}/llvm/tools/clang/test/PCH/cxx11-statement-attributes.cpp -o - -verify
    RUN("%clang_cc1 -include %S/Inputs/cxx11-statement-attributes.h -std=c++11 -Wimplicit-fallthrough -fsyntax-only %s -o - -verify");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -include ${LLVM_SRC}/llvm/tools/clang/test/PCH/Inputs/cxx11-statement-attributes.h '-std=c++1z' -Wimplicit-fallthrough -fsyntax-only ${LLVM_SRC}/llvm/tools/clang/test/PCH/cxx11-statement-attributes.cpp -o - -verify
    RUN("%clang_cc1 -include %S/Inputs/cxx11-statement-attributes.h -std=c++1z -Wimplicit-fallthrough -fsyntax-only %s -o - -verify");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x c++-header -emit-pch '-std=c++11' -o ${TEST_TEMP_DIR}/cxx11-statement-attributes.cpp.tmp ${LLVM_SRC}/llvm/tools/clang/test/PCH/Inputs/cxx11-statement-attributes.h
    RUN("%clang_cc1 -x c++-header -emit-pch -std=c++11 -o %t %S/Inputs/cxx11-statement-attributes.h");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -include-pch ${TEST_TEMP_DIR}/cxx11-statement-attributes.cpp.tmp '-std=c++11' -Wimplicit-fallthrough -fsyntax-only ${LLVM_SRC}/llvm/tools/clang/test/PCH/cxx11-statement-attributes.cpp -o - -verify
    RUN("%clang_cc1 -include-pch %t -std=c++11 -Wimplicit-fallthrough -fsyntax-only %s -o - -verify");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x c++-header -emit-pch '-std=c++1z' -o ${TEST_TEMP_DIR}/cxx11-statement-attributes.cpp.tmp ${LLVM_SRC}/llvm/tools/clang/test/PCH/Inputs/cxx11-statement-attributes.h
    RUN("%clang_cc1 -x c++-header -emit-pch -std=c++1z -o %t %S/Inputs/cxx11-statement-attributes.h");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -include-pch ${TEST_TEMP_DIR}/cxx11-statement-attributes.cpp.tmp '-std=c++1z' -Wimplicit-fallthrough -fsyntax-only ${LLVM_SRC}/llvm/tools/clang/test/PCH/cxx11-statement-attributes.cpp -o - -verify
    RUN("%clang_cc1 -include-pch %t -std=c++1z -Wimplicit-fallthrough -fsyntax-only %s -o - -verify");
  }

  @Test
  public void test_cxx11_user_defined_literals_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/PCH/cxx11-user-defined-literals.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -pedantic-errors '-std=c++11' -emit-pch ${LLVM_SRC}/llvm/tools/clang/test/PCH/cxx11-user-defined-literals.cpp -o ${TEST_TEMP_DIR}/cxx11-user-defined-literals.cpp.tmp
    RUN("%clang_cc1 -pedantic-errors -std=c++11 -emit-pch %s -o %t");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -pedantic-errors '-std=c++11' -include-pch ${TEST_TEMP_DIR}/cxx11-user-defined-literals.cpp.tmp -verify ${LLVM_SRC}/llvm/tools/clang/test/PCH/cxx11-user-defined-literals.cpp
    RUN("%clang_cc1 -pedantic-errors -std=c++11 -include-pch %t -verify %s");
  }

  @Test
  public void test_cxx1y_decltype_auto_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/PCH/cxx1y-decltype-auto.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -pedantic '-std=c++1y' -emit-pch ${LLVM_SRC}/llvm/tools/clang/test/PCH/cxx1y-decltype-auto.cpp -o ${TEST_TEMP_DIR}/cxx1y-decltype-auto.cpp.tmp
    RUN("%clang_cc1 -pedantic -std=c++1y -emit-pch %s -o %t");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -pedantic '-std=c++1y' -include-pch ${TEST_TEMP_DIR}/cxx1y-decltype-auto.cpp.tmp -verify ${LLVM_SRC}/llvm/tools/clang/test/PCH/cxx1y-decltype-auto.cpp
    RUN("%clang_cc1 -pedantic -std=c++1y -include-pch %t -verify %s");
  }

  @Test
  public void test_cxx1y_deduced_return_type_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/PCH/cxx1y-deduced-return-type.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -pedantic '-std=c++1y' -include ${LLVM_SRC}/llvm/tools/clang/test/PCH/cxx1y-deduced-return-type.cpp -include ${LLVM_SRC}/llvm/tools/clang/test/PCH/cxx1y-deduced-return-type.cpp -verify ${LLVM_SRC}/llvm/tools/clang/test/PCH/cxx1y-deduced-return-type.cpp
    RUN("%clang_cc1 -pedantic -std=c++1y -include %s -include %s -verify %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -pedantic '-std=c++1y' -emit-pch ${LLVM_SRC}/llvm/tools/clang/test/PCH/cxx1y-deduced-return-type.cpp -o ${TEST_TEMP_DIR}/cxx1y-deduced-return-type.cpp.tmp.a
    RUN("%clang_cc1 -pedantic -std=c++1y -emit-pch %s -o %t.a");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -pedantic '-std=c++1y' -include-pch ${TEST_TEMP_DIR}/cxx1y-deduced-return-type.cpp.tmp.a -emit-pch ${LLVM_SRC}/llvm/tools/clang/test/PCH/cxx1y-deduced-return-type.cpp -o ${TEST_TEMP_DIR}/cxx1y-deduced-return-type.cpp.tmp.b
    RUN("%clang_cc1 -pedantic -std=c++1y -include-pch %t.a -emit-pch %s -o %t.b");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -pedantic '-std=c++1y' -include-pch ${TEST_TEMP_DIR}/cxx1y-deduced-return-type.cpp.tmp.b -verify ${LLVM_SRC}/llvm/tools/clang/test/PCH/cxx1y-deduced-return-type.cpp
    RUN("%clang_cc1 -pedantic -std=c++1y -include-pch %t.b -verify %s");
  }

  @Test
  public void test_cxx1y_default_initializer_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/PCH/cxx1y-default-initializer.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -pedantic '-std=c++1y' ${LLVM_SRC}/llvm/tools/clang/test/PCH/cxx1y-default-initializer.cpp -o ${TEST_TEMP_DIR}/cxx1y-default-initializer.cpp.tmp
    RUN("%clang_cc1 -pedantic -std=c++1y %s -o %t");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -pedantic '-std=c++1y' -emit-pch ${LLVM_SRC}/llvm/tools/clang/test/PCH/cxx1y-default-initializer.cpp -o ${TEST_TEMP_DIR}/cxx1y-default-initializer.cpp.tmp
    RUN("%clang_cc1 -pedantic -std=c++1y -emit-pch %s -o %t");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -pedantic '-std=c++1y' -include-pch ${TEST_TEMP_DIR}/cxx1y-default-initializer.cpp.tmp -verify ${LLVM_SRC}/llvm/tools/clang/test/PCH/cxx1y-default-initializer.cpp
    RUN("%clang_cc1 -pedantic -std=c++1y -include-pch %t -verify %s");
  }

  @Test
  public void test_cxx1y_init_captures_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/PCH/cxx1y-init-captures.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -pedantic '-std=c++1y' -include ${LLVM_SRC}/llvm/tools/clang/test/PCH/cxx1y-init-captures.cpp -verify ${LLVM_SRC}/llvm/tools/clang/test/PCH/cxx1y-init-captures.cpp
    RUN("%clang_cc1 -pedantic -std=c++1y -include %s -verify %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -pedantic '-std=c++1y' -emit-pch ${LLVM_SRC}/llvm/tools/clang/test/PCH/cxx1y-init-captures.cpp -o ${TEST_TEMP_DIR}/cxx1y-init-captures.cpp.tmp
    RUN("%clang_cc1 -pedantic -std=c++1y -emit-pch %s -o %t");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -pedantic '-std=c++1y' -include-pch ${TEST_TEMP_DIR}/cxx1y-init-captures.cpp.tmp -verify ${LLVM_SRC}/llvm/tools/clang/test/PCH/cxx1y-init-captures.cpp
    RUN("%clang_cc1 -pedantic -std=c++1y -include-pch %t -verify %s");
  }

  @Test
  public void test_cxx1y_lambdas_mm() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/PCH/cxx1y-lambdas.mm");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -pedantic-errors -fblocks '-std=c++1y' -emit-pch ${LLVM_SRC}/llvm/tools/clang/test/PCH/cxx1y-lambdas.mm -o ${TEST_TEMP_DIR}/cxx1y-lambdas.mm.tmp-cxx1y
    RUN("%clang_cc1 -pedantic-errors -fblocks -std=c++1y -emit-pch %s -o %t-cxx1y");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -ast-print -pedantic-errors -fblocks '-std=c++1y' -include-pch ${TEST_TEMP_DIR}/cxx1y-lambdas.mm.tmp-cxx1y ${LLVM_SRC}/llvm/tools/clang/test/PCH/cxx1y-lambdas.mm | ${LLVM_SRC}/build/bin/FileCheck '-check-prefix=CHECK-PRINT' ${LLVM_SRC}/llvm/tools/clang/test/PCH/cxx1y-lambdas.mm
    RUN("%clang_cc1 -ast-print -pedantic-errors -fblocks -std=c++1y -include-pch %t-cxx1y  %s")./*|*/
      I("FileCheck -check-prefix=CHECK-PRINT %s");
  }

  @Test
  public void test_cxx1y_variable_templates_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/PCH/cxx1y-variable-templates.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -pedantic '-std=c++1y' -include ${LLVM_SRC}/llvm/tools/clang/test/PCH/cxx1y-variable-templates.cpp -include ${LLVM_SRC}/llvm/tools/clang/test/PCH/cxx1y-variable-templates.cpp -verify ${LLVM_SRC}/llvm/tools/clang/test/PCH/cxx1y-variable-templates.cpp -DNONPCH
    RUN("%clang_cc1 -pedantic -std=c++1y -include %s -include %s -verify %s -DNONPCH");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -pedantic '-std=c++1y' -include ${LLVM_SRC}/llvm/tools/clang/test/PCH/cxx1y-variable-templates.cpp -include ${LLVM_SRC}/llvm/tools/clang/test/PCH/cxx1y-variable-templates.cpp -verify ${LLVM_SRC}/llvm/tools/clang/test/PCH/cxx1y-variable-templates.cpp -DNONPCH -DERROR
    RUN("%clang_cc1 -pedantic -std=c++1y -include %s -include %s -verify %s -DNONPCH -DERROR");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -pedantic '-std=c++1y' -emit-pch ${LLVM_SRC}/llvm/tools/clang/test/PCH/cxx1y-variable-templates.cpp -o ${TEST_TEMP_DIR}/cxx1y-variable-templates.cpp.tmp.a -DHEADER1
    RUN("%clang_cc1 -pedantic -std=c++1y -emit-pch %s -o %t.a -DHEADER1");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -pedantic '-std=c++1y' -include-pch ${TEST_TEMP_DIR}/cxx1y-variable-templates.cpp.tmp.a -emit-pch ${LLVM_SRC}/llvm/tools/clang/test/PCH/cxx1y-variable-templates.cpp -o ${TEST_TEMP_DIR}/cxx1y-variable-templates.cpp.tmp.b -DHEADER2
    RUN("%clang_cc1 -pedantic -std=c++1y -include-pch %t.a -emit-pch %s -o %t.b -DHEADER2");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -pedantic '-std=c++1y' -include-pch ${TEST_TEMP_DIR}/cxx1y-variable-templates.cpp.tmp.b -verify ${LLVM_SRC}/llvm/tools/clang/test/PCH/cxx1y-variable-templates.cpp -DHEADERUSE
    RUN("%clang_cc1 -pedantic -std=c++1y -include-pch %t.b -verify %s -DHEADERUSE");
  }

  @Test
  public void test_cxx1z_init_statement_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/PCH/cxx1z-init-statement.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc '-std=c++1z' -include ${LLVM_SRC}/llvm/tools/clang/test/PCH/cxx1z-init-statement.h -fsyntax-only -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/PCH/cxx1z-init-statement.cpp
    RUN( "%clang_cc1 -std=c++1z -include %S/cxx1z-init-statement.h -fsyntax-only -emit-llvm -o - %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x c++ '-std=c++1z' -emit-pch -o ${TEST_TEMP_DIR}/cxx1z-init-statement.cpp.tmp ${LLVM_SRC}/llvm/tools/clang/test/PCH/cxx1z-init-statement.h
    RUN( "%clang_cc1 -x c++ -std=c++1z -emit-pch -o %t %S/cxx1z-init-statement.h");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc '-std=c++1z' -include-pch ${TEST_TEMP_DIR}/cxx1z-init-statement.cpp.tmp -fsyntax-only -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/PCH/cxx1z-init-statement.cpp
    RUN( "%clang_cc1 -std=c++1z -include-pch %t -fsyntax-only -emit-llvm -o - %s");
  }

  @Test
  public void test_cxx_exprs_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/PCH/cxx_exprs.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fcxx-exceptions -fexceptions -include ${LLVM_SRC}/llvm/tools/clang/test/PCH/cxx_exprs.h '-std=c++11' -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/PCH/cxx_exprs.cpp -ast-dump
    RUN("%clang_cc1 -fcxx-exceptions -fexceptions -include %S/cxx_exprs.h -std=c++11 -fsyntax-only -verify %s -ast-dump");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fcxx-exceptions -fexceptions -x c++-header '-std=c++11' -emit-pch -o ${TEST_TEMP_DIR}/cxx_exprs.cpp.tmp ${LLVM_SRC}/llvm/tools/clang/test/PCH/cxx_exprs.h
    RUN(TestState.Failed, "%clang_cc1 -fcxx-exceptions -fexceptions -x c++-header -std=c++11 -emit-pch -o %t %S/cxx_exprs.h");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fcxx-exceptions -fexceptions '-std=c++11' -include-pch ${TEST_TEMP_DIR}/cxx_exprs.cpp.tmp -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/PCH/cxx_exprs.cpp -ast-dump
    RUN(TestState.Failed, "%clang_cc1 -fcxx-exceptions -fexceptions -std=c++11 -include-pch %t -fsyntax-only -verify %s -ast-dump");
  }

  @Test
  public void test_datetime_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/PCH/datetime.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x c-header ${LLVM_SRC}/llvm/tools/clang/test/PCH/datetime.c -emit-pch -o ${TEST_TEMP_DIR}/datetime.c.tmp 2>&1 | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/PCH/datetime.c
    RUN("%clang_cc1 -x c-header %s -emit-pch -o %t 2>&1")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_debug_info_limited_struct_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/PCH/debug-info-limited-struct.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-pch -o ${TEST_TEMP_DIR}/debug-info-limited-struct.c.tmp ${LLVM_SRC}/llvm/tools/clang/test/PCH/debug-info-limited-struct.h
    RUN(TestState.Failed, "%clang_cc1 -emit-pch -o %t %S/debug-info-limited-struct.h");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -include-pch ${TEST_TEMP_DIR}/debug-info-limited-struct.c.tmp -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/PCH/debug-info-limited-struct.c '-debug-info-kind=limited' -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/PCH/debug-info-limited-struct.c
    RUN(TestState.Failed, "%clang_cc1 -include-pch %t -emit-llvm %s -debug-info-kind=limited -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_debug_info_pch_path_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/PCH/debug-info-pch-path.c");
    // REQUIRES: shell
    if (!CHECK_REQUIRES("shell")) {
      return;
    }
    // rm -rf ${TEST_TEMP_DIR}/debug-info-pch-path.c.tmp
    RUN(TestState.Failed, "rm -rf %t");
    // mkdir ${TEST_TEMP_DIR}/debug-info-pch-path.c.tmp
    RUN(TestState.Failed, "mkdir %t");
    // cd ${TEST_TEMP_DIR}/debug-info-pch-path.c.tmp
    RUN(TestState.Failed, "cd %t");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc '-fmodule-format=obj' -emit-pch -triple i386-pc-solaris2.11 -o prefix.pch ${LLVM_SRC}/llvm/tools/clang/test/PCH/debug-info-limited-struct.h
    RUN(TestState.Failed, "%clang_cc1 -fmodule-format=obj -emit-pch -triple %itanium_abi_triple -o prefix.pch %S/debug-info-limited-struct.h");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc '-debug-info-kind=standalone' -dwarf-ext-refs '-fmodule-format=obj' -triple i386-pc-solaris2.11 -include-pch prefix.pch ${LLVM_SRC}/llvm/tools/clang/test/PCH/debug-info-pch-path.c -emit-llvm -o ${TEST_TEMP_DIR}/debug-info-pch-path.c.tmp.nodir.ll ${LLVM_SRC}/llvm/tools/clang/test/PCH/debug-info-pch-path.c
    RUN(TestState.Failed, "%clang_cc1 -debug-info-kind=standalone -dwarf-ext-refs -fmodule-format=obj -triple %itanium_abi_triple -include-pch prefix.pch %s -emit-llvm -o %t.nodir.ll %s");
    // cat ${TEST_TEMP_DIR}/debug-info-pch-path.c.tmp.nodir.ll | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/PCH/debug-info-pch-path.c '--check-prefix=CHECK-REL-NODIR'
    RUN(TestState.Failed, "cat %t.nodir.ll")./*|*/
      I("FileCheck %s --check-prefix=CHECK-REL-NODIR");
    // mkdir pchdir
    RUN(TestState.Failed, "mkdir pchdir");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc '-fmodule-format=obj' -emit-pch -triple i386-pc-solaris2.11 -o pchdir/prefix.pch ${LLVM_SRC}/llvm/tools/clang/test/PCH/debug-info-limited-struct.h
    RUN(TestState.Failed, "%clang_cc1 -fmodule-format=obj -emit-pch -triple %itanium_abi_triple -o pchdir/prefix.pch %S/debug-info-limited-struct.h");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc '-debug-info-kind=standalone' -dwarf-ext-refs '-fmodule-format=obj' -triple i386-pc-solaris2.11 -include-pch pchdir/prefix.pch ${LLVM_SRC}/llvm/tools/clang/test/PCH/debug-info-pch-path.c -emit-llvm -o ${TEST_TEMP_DIR}/debug-info-pch-path.c.tmp.rel.ll ${LLVM_SRC}/llvm/tools/clang/test/PCH/debug-info-pch-path.c
    RUN(TestState.Failed, "%clang_cc1 -debug-info-kind=standalone -dwarf-ext-refs -fmodule-format=obj -triple %itanium_abi_triple -include-pch pchdir/prefix.pch %s -emit-llvm -o %t.rel.ll %s");
    // cat ${TEST_TEMP_DIR}/debug-info-pch-path.c.tmp.rel.ll | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/PCH/debug-info-pch-path.c '--check-prefix=CHECK-REL'
    RUN(TestState.Failed, "cat %t.rel.ll")./*|*/
      I("FileCheck %s --check-prefix=CHECK-REL");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc '-fmodule-format=obj' -emit-pch -triple i386-pc-solaris2.11 -o ${TEST_TEMP_DIR}/debug-info-pch-path.c.tmp/prefix.pch ${LLVM_SRC}/llvm/tools/clang/test/PCH/debug-info-limited-struct.h
    RUN(TestState.Failed, "%clang_cc1 -fmodule-format=obj -emit-pch -triple %itanium_abi_triple -o %t/prefix.pch %S/debug-info-limited-struct.h");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc '-debug-info-kind=standalone' -dwarf-ext-refs '-fmodule-format=obj' -triple i386-pc-solaris2.11 -include-pch ${TEST_TEMP_DIR}/debug-info-pch-path.c.tmp/prefix.pch ${LLVM_SRC}/llvm/tools/clang/test/PCH/debug-info-pch-path.c -emit-llvm -o ${TEST_TEMP_DIR}/debug-info-pch-path.c.tmp.abs.ll ${LLVM_SRC}/llvm/tools/clang/test/PCH/debug-info-pch-path.c
    RUN(TestState.Failed, "%clang_cc1 -debug-info-kind=standalone -dwarf-ext-refs -fmodule-format=obj -triple %itanium_abi_triple -include-pch %t/prefix.pch %s -emit-llvm -o %t.abs.ll %s");
    // cat ${TEST_TEMP_DIR}/debug-info-pch-path.c.tmp.abs.ll | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/PCH/debug-info-pch-path.c '--check-prefix=CHECK-ABS'
    RUN(TestState.Failed, "cat %t.abs.ll")./*|*/
      I("FileCheck %s --check-prefix=CHECK-ABS");
  }

  @Test
  public void test_designated_init_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/PCH/designated-init.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/PCH/designated-init.c -include ${LLVM_SRC}/llvm/tools/clang/test/PCH/designated-init.c.h -emit-llvm -o ${TEST_TEMP_DIR}/designated-init.c.tmp.withoutpch.ll
    RUN(TestState.Failed, "%clang_cc1 %s -include %s.h -emit-llvm -o %t.withoutpch.ll");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/PCH/designated-init.c.h -emit-pch -o ${TEST_TEMP_DIR}/designated-init.c.tmp.pch
    RUN(TestState.Failed, "%clang_cc1 %s.h -emit-pch -o %t.pch");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/PCH/designated-init.c -include-pch ${TEST_TEMP_DIR}/designated-init.c.tmp.pch -emit-llvm -o ${TEST_TEMP_DIR}/designated-init.c.tmp.withpch.ll
    RUN(TestState.Failed, "%clang_cc1 %s -include-pch %t.pch -emit-llvm -o %t.withpch.ll");
    // diff ${TEST_TEMP_DIR}/designated-init.c.tmp.withoutpch.ll ${TEST_TEMP_DIR}/designated-init.c.tmp.withpch.ll
    RUN(TestState.Failed, "diff %t.withoutpch.ll %t.withpch.ll");
  }

  @Test
  public void test_different_diagnostic_level_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/PCH/different-diagnostic-level.c");
    // ${LLVM_SRC}/build/bin/clang -x c-header ${LLVM_SRC}/llvm/tools/clang/test/PCH/different-diagnostic-level.c -Weverything -o ${TEST_TEMP_DIR}/different-diagnostic-level.c.tmp.h.pch
    RUN("%clang -x c-header %s -Weverything -o %t.h.pch");
    // ${LLVM_SRC}/build/bin/clang -x c ${LLVM_SRC}/llvm/tools/clang/test/PCH/different-diagnostic-level.c -w -include ${TEST_TEMP_DIR}/different-diagnostic-level.c.tmp.h -fsyntax-only -Xclang -verify
    RUN("%clang -x c %s -w -include %t.h -fsyntax-only -Xclang -verify");
  }

  @Test
  public void test_different_linker_version_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/PCH/different-linker-version.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -target-linker-version 100 -emit-pch ${LLVM_SRC}/llvm/tools/clang/test/PCH/different-linker-version.c -o ${TEST_TEMP_DIR}/different-linker-version.c.tmp.h.pch
    RUN("%clang_cc1 -target-linker-version 100 -emit-pch %s -o %t.h.pch");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -target-linker-version 200 ${LLVM_SRC}/llvm/tools/clang/test/PCH/different-linker-version.c -include-pch ${TEST_TEMP_DIR}/different-linker-version.c.tmp.h.pch -fsyntax-only -verify
    RUN("%clang_cc1 -target-linker-version 200 %s -include-pch %t.h.pch -fsyntax-only -verify");
  }

  @Test
  public void test_emit_pth_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/PCH/emit-pth.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i386-unknown-unknown -emit-pth -o ${TEST_TEMP_DIR}/emit-pth.c.tmp1 ${LLVM_SRC}/llvm/tools/clang/test/PCH/emit-pth.c
    RUN("%clang_cc1 -triple i386-unknown-unknown -emit-pth -o %t1 %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i386-unknown-unknown -emit-pth -o - ${LLVM_SRC}/llvm/tools/clang/test/PCH/emit-pth.c > ${TEST_TEMP_DIR}/emit-pth.c.tmp2
    RUN("%clang_cc1 -triple i386-unknown-unknown -emit-pth -o - %s > %t2");
    // cmp ${TEST_TEMP_DIR}/emit-pth.c.tmp1 ${TEST_TEMP_DIR}/emit-pth.c.tmp2
    RUN("cmp %t1 %t2");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i386-unknown-unknown -emit-pth -o - ${LLVM_SRC}/llvm/tools/clang/test/PCH/emit-pth.c | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/PCH/emit-pth.c
    RUN("%clang_cc1 -triple i386-unknown-unknown -emit-pth -o - %s")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_empty_with_headers_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/PCH/empty-with-headers.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only '-std=c99' -pedantic-errors ${LLVM_SRC}/llvm/tools/clang/test/PCH/empty-with-headers.c
    RUN("%clang_cc1 -fsyntax-only -std=c99 -pedantic-errors %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only '-std=c99' -emit-pch -o ${TEST_TEMP_DIR}/empty-with-headers.c.tmp ${LLVM_SRC}/llvm/tools/clang/test/PCH/empty-with-headers.c
    RUN("%clang_cc1 -fsyntax-only -std=c99 -emit-pch -o %t %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only '-std=c99' -pedantic-errors -include-pch ${TEST_TEMP_DIR}/empty-with-headers.c.tmp ${LLVM_SRC}/llvm/tools/clang/test/PCH/empty-with-headers.c
    RUN("%clang_cc1 -fsyntax-only -std=c99 -pedantic-errors -include-pch %t %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only '-std=c99' -pedantic-errors -DINCLUDED ${LLVM_SRC}/llvm/tools/clang/test/PCH/empty-with-headers.c -verify
    RUN("%clang_cc1 -fsyntax-only -std=c99 -pedantic-errors -DINCLUDED %s -verify");
  }

  @Test
  public void test_enum_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/PCH/enum.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -include ${LLVM_SRC}/llvm/tools/clang/test/PCH/enum.h -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/PCH/enum.c
    RUN("%clang_cc1 -include %S/enum.h -fsyntax-only -verify %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-pch -o ${TEST_TEMP_DIR}/enum.c.tmp ${LLVM_SRC}/llvm/tools/clang/test/PCH/enum.h
    RUN("%clang_cc1 -emit-pch -o %t %S/enum.h");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -include-pch ${TEST_TEMP_DIR}/enum.c.tmp -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/PCH/enum.c
    RUN("%clang_cc1 -include-pch %t -fsyntax-only -verify %s");
  }

  @Test
  public void test_exprs_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/PCH/exprs.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fblocks -include ${LLVM_SRC}/llvm/tools/clang/test/PCH/exprs.h -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/PCH/exprs.c
    RUN("%clang_cc1 -fblocks -include %S/exprs.h -fsyntax-only -verify %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-pch -fblocks -o ${TEST_TEMP_DIR}/exprs.c.tmp ${LLVM_SRC}/llvm/tools/clang/test/PCH/exprs.h
    RUN(TestState.Failed, "%clang_cc1 -emit-pch -fblocks -o %t %S/exprs.h");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fblocks -include-pch ${TEST_TEMP_DIR}/exprs.c.tmp -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/PCH/exprs.c -DWITH_PCH
    RUN(TestState.Failed, "%clang_cc1 -fblocks -include-pch %t -fsyntax-only -verify %s -DWITH_PCH");
  }

  @Test
  public void test_ext_vector_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/PCH/ext_vector.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -include ${LLVM_SRC}/llvm/tools/clang/test/PCH/ext_vector.h -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/PCH/ext_vector.c
    RUN("%clang_cc1 -include %S/ext_vector.h -fsyntax-only -verify %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-pch -o ${TEST_TEMP_DIR}/ext_vector.c.tmp ${LLVM_SRC}/llvm/tools/clang/test/PCH/ext_vector.h
    RUN("%clang_cc1 -emit-pch -o %t %S/ext_vector.h");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -include-pch ${TEST_TEMP_DIR}/ext_vector.c.tmp -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/PCH/ext_vector.c
    RUN("%clang_cc1 -include-pch %t -fsyntax-only -verify %s");
  }

  @Test
  public void test_external_defs_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/PCH/external-defs.c");
    // REQUIRES: x86-registered-target
    if (!CHECK_REQUIRES("x86-registered-target")) {
      return;
    }
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-apple-darwin9 -emit-pch -o ${TEST_TEMP_DIR}/external-defs.c.tmp.pch ${LLVM_SRC}/llvm/tools/clang/test/PCH/external-defs.h
    RUN("%clang_cc1 -triple x86_64-apple-darwin9 -emit-pch -o %t.pch %S/external-defs.h");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-apple-darwin9 -include-pch ${TEST_TEMP_DIR}/external-defs.c.tmp.pch -emit-llvm -o ${TEST_TEMP_DIR}/external-defs.c.tmp ${LLVM_SRC}/llvm/tools/clang/test/PCH/external-defs.c
    RUN("%clang_cc1 -triple x86_64-apple-darwin9 -include-pch %t.pch -emit-llvm -o %t %s");
    // grep '@x = common global i32 0' ${TEST_TEMP_DIR}/external-defs.c.tmp | ${LLVM_SRC}/build/bin/count 1
    RUN("grep \"@x = common global i32 0\" %t")./*|*/
      I("count 1");
    // grep @z ${TEST_TEMP_DIR}/external-defs.c.tmp
    RUN("not grep \"@z\" %t");
    // grep '@x2 = global i32 19' ${TEST_TEMP_DIR}/external-defs.c.tmp | ${LLVM_SRC}/build/bin/count 1
    RUN("grep \"@x2 = global i32 19\" %t")./*|*/
      I("count 1");
    // grep '@incomplete_array = common global .*1 x i32' ${TEST_TEMP_DIR}/external-defs.c.tmp | ${LLVM_SRC}/build/bin/count 1
    RUN("grep \"@incomplete_array = common global .*1 x i32\" %t")./*|*/
      I("count 1");
    // grep '@incomplete_array2 = common global .*17 x i32' ${TEST_TEMP_DIR}/external-defs.c.tmp | ${LLVM_SRC}/build/bin/count 1
    RUN("grep \"@incomplete_array2 = common global .*17 x i32\" %t")./*|*/
      I("count 1");
    // grep '@incomplete_array3 = common global .*1 x i32' ${TEST_TEMP_DIR}/external-defs.c.tmp | ${LLVM_SRC}/build/bin/count 1
    RUN("grep \"@incomplete_array3 = common global .*1 x i32\" %t")./*|*/
      I("count 1");
  }

  @Test
  public void test_field_designator_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/PCH/field-designator.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/PCH/field-designator.c -include ${LLVM_SRC}/llvm/tools/clang/test/PCH/field-designator.c
    RUN("%clang_cc1 %s -include %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/PCH/field-designator.c -emit-pch -o ${TEST_TEMP_DIR}/field-designator.c.tmp.pch
    RUN("%clang_cc1 %s -emit-pch -o %t.pch");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/PCH/field-designator.c -include-pch ${TEST_TEMP_DIR}/field-designator.c.tmp.pch
    RUN("%clang_cc1 %s -include-pch %t.pch");
  }

  @Test
  public void test_floating_literal_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/PCH/floating-literal.c");
    // REQUIRES: mips-registered-target
    if (!CHECK_REQUIRES("mips-registered-target")) {
      return;
    }
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple mips64-none-linux-gnu -emit-pch -o ${TEST_TEMP_DIR}/floating-literal.c.tmp ${LLVM_SRC}/llvm/tools/clang/test/PCH/floating-literal.c
    RUN(TestState.Failed, "%clang_cc1 -triple mips64-none-linux-gnu -emit-pch -o %t %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x ast -ast-print ${TEST_TEMP_DIR}/floating-literal.c.tmp | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/PCH/floating-literal.c
    RUN(TestState.Failed, "%clang_cc1 -x ast -ast-print %t")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_format_strings_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/PCH/format-strings.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -D 'FOOBAR="\"\""' ${LLVM_SRC}/llvm/tools/clang/test/PCH/format-strings.c -emit-pch -o ${TEST_TEMP_DIR}/format-strings.c.tmp.pch
    RUN("%clang_cc1 -D FOOBAR=\"\\\"\\\"\" %s -emit-pch -o %t.pch");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -D 'FOOBAR="\"\""' ${LLVM_SRC}/llvm/tools/clang/test/PCH/format-strings.c -include-pch ${TEST_TEMP_DIR}/format-strings.c.tmp.pch
    RUN("%clang_cc1 -D FOOBAR=\"\\\"\\\"\" %s -include-pch %t.pch");
  }

  @Test
  public void test_friend_template_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/PCH/friend-template.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -include ${LLVM_SRC}/llvm/tools/clang/test/PCH/friend-template.cpp -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/PCH/friend-template.cpp
    RUN("%clang_cc1 -include %s -fsyntax-only -verify %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-pch -o ${TEST_TEMP_DIR}/friend-template.cpp.tmp ${LLVM_SRC}/llvm/tools/clang/test/PCH/friend-template.cpp
    RUN("%clang_cc1 -emit-pch -o %t %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -include-pch ${TEST_TEMP_DIR}/friend-template.cpp.tmp -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/PCH/friend-template.cpp
    RUN("%clang_cc1 -include-pch %t -fsyntax-only -verify %s");
  }

  @Test
  public void test_functions_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/PCH/functions.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -include ${LLVM_SRC}/llvm/tools/clang/test/PCH/functions.h -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/PCH/functions.c
    RUN("%clang_cc1 -include %S/functions.h -fsyntax-only -verify %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-pch -o ${TEST_TEMP_DIR}/functions.c.tmp ${LLVM_SRC}/llvm/tools/clang/test/PCH/functions.h
    RUN("%clang_cc1 -emit-pch -o %t %S/functions.h");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -include-pch ${TEST_TEMP_DIR}/functions.c.tmp -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/PCH/functions.c
    RUN("%clang_cc1 -include-pch %t -fsyntax-only -verify %s");
  }

  @Test
  public void test_fuzzy_pch_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/PCH/fuzzy-pch.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-pch -DFOO -o ${TEST_TEMP_DIR}/fuzzy-pch.c.tmp ${LLVM_SRC}/llvm/tools/clang/test/PCH/variables.h
    RUN("%clang_cc1 -emit-pch -DFOO -o %t %S/variables.h");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc '-DBAR=int' -include-pch ${TEST_TEMP_DIR}/fuzzy-pch.c.tmp -fsyntax-only -pedantic ${LLVM_SRC}/llvm/tools/clang/test/PCH/fuzzy-pch.c
    RUN("%clang_cc1 -DBAR=int -include-pch %t -fsyntax-only -pedantic %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -DFOO '-DBAR=int' -include-pch ${TEST_TEMP_DIR}/fuzzy-pch.c.tmp ${LLVM_SRC}/llvm/tools/clang/test/PCH/fuzzy-pch.c
    RUN("%clang_cc1 -DFOO -DBAR=int -include-pch %t %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc '-DFOO=blah' '-DBAR=int' -include-pch ${TEST_TEMP_DIR}/fuzzy-pch.c.tmp ${LLVM_SRC}/llvm/tools/clang/test/PCH/fuzzy-pch.c 2> ${TEST_TEMP_DIR}/fuzzy-pch.c.tmp.err
    RUN("not %clang_cc1 -DFOO=blah -DBAR=int -include-pch %t %s 2> %t.err");
    // ${LLVM_SRC}/build/bin/FileCheck '-check-prefix=CHECK-FOO' ${LLVM_SRC}/llvm/tools/clang/test/PCH/fuzzy-pch.c < ${TEST_TEMP_DIR}/fuzzy-pch.c.tmp.err
    RUN("FileCheck -check-prefix=CHECK-FOO %s < %t.err");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -UFOO -include-pch ${TEST_TEMP_DIR}/fuzzy-pch.c.tmp ${LLVM_SRC}/llvm/tools/clang/test/PCH/fuzzy-pch.c 2> ${TEST_TEMP_DIR}/fuzzy-pch.c.tmp.err
    RUN("not %clang_cc1 -UFOO -include-pch %t %s 2> %t.err");
    // ${LLVM_SRC}/build/bin/FileCheck '-check-prefix=CHECK-NOFOO' ${LLVM_SRC}/llvm/tools/clang/test/PCH/fuzzy-pch.c < ${TEST_TEMP_DIR}/fuzzy-pch.c.tmp.err
    RUN("FileCheck -check-prefix=CHECK-NOFOO %s < %t.err");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -DFOO -undef -include-pch ${TEST_TEMP_DIR}/fuzzy-pch.c.tmp ${LLVM_SRC}/llvm/tools/clang/test/PCH/fuzzy-pch.c 2> ${TEST_TEMP_DIR}/fuzzy-pch.c.tmp.err
    RUN("not %clang_cc1 -DFOO -undef -include-pch %t %s 2> %t.err");
    // ${LLVM_SRC}/build/bin/FileCheck '-check-prefix=CHECK-UNDEF' ${LLVM_SRC}/llvm/tools/clang/test/PCH/fuzzy-pch.c < ${TEST_TEMP_DIR}/fuzzy-pch.c.tmp.err
    RUN("FileCheck -check-prefix=CHECK-UNDEF %s < %t.err");
  }

  @Test
  public void test_headermap_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/PCH/headermap.m");
    // touch ${TEST_TEMP_DIR}/headermap.m.tmp.hmap
    RUN("touch %t.hmap");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x objective-c -emit-pch -o ${TEST_TEMP_DIR}/headermap.m.tmp.h.pch ${LLVM_SRC}/llvm/tools/clang/test/PCH/headermap.h
    RUN("%clang_cc1 -x objective-c -emit-pch -o %t.h.pch %S/headermap.h");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -include-pch ${TEST_TEMP_DIR}/headermap.m.tmp.h.pch ${LLVM_SRC}/llvm/tools/clang/test/PCH/headermap.m
    RUN("%clang_cc1 -include-pch %t.h.pch %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x objective-c -emit-pch -o ${TEST_TEMP_DIR}/headermap.m.tmp.h.pch ${LLVM_SRC}/llvm/tools/clang/test/PCH/headermap.h
    RUN("%clang_cc1 -x objective-c -emit-pch -o %t.h.pch %S/headermap.h");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -include-pch ${TEST_TEMP_DIR}/headermap.m.tmp.h.pch "-I${TEST_TEMP_DIR}/headermap.m.tmp.hmap" ${LLVM_SRC}/llvm/tools/clang/test/PCH/headermap.m
    RUN("%clang_cc1 -include-pch %t.h.pch -I%t.hmap %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x objective-c "-I${TEST_TEMP_DIR}/headermap.m.tmp.hmap" -emit-pch -o ${TEST_TEMP_DIR}/headermap.m.tmp.h.pch ${LLVM_SRC}/llvm/tools/clang/test/PCH/headermap.h
    RUN("%clang_cc1 -x objective-c -I%t.hmap -emit-pch -o %t.h.pch %S/headermap.h");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -include-pch ${TEST_TEMP_DIR}/headermap.m.tmp.h.pch ${LLVM_SRC}/llvm/tools/clang/test/PCH/headermap.m
    RUN("%clang_cc1 -include-pch %t.h.pch %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x objective-c "-I${TEST_TEMP_DIR}/headermap.m.tmp.hmap" -emit-pch -o ${TEST_TEMP_DIR}/headermap.m.tmp.h.pch ${LLVM_SRC}/llvm/tools/clang/test/PCH/headermap.h
    RUN("%clang_cc1 -x objective-c -I%t.hmap -emit-pch -o %t.h.pch %S/headermap.h");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -include-pch ${TEST_TEMP_DIR}/headermap.m.tmp.h.pch "-I${TEST_TEMP_DIR}/headermap.m.tmp.hmap" ${LLVM_SRC}/llvm/tools/clang/test/PCH/headermap.m
    RUN("%clang_cc1 -include-pch %t.h.pch -I%t.hmap %s");
  }

  @Test
  public void test_headersearch_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/PCH/headersearch.cpp");
    // rm -rf ${TEST_TEMP_DIR}/headersearch.cpp.tmp_orig ${TEST_TEMP_DIR}/headersearch.cpp.tmp_moved
    RUN(TestState.Failed, "rm -rf %t_orig %t_moved");
    // mkdir -p ${TEST_TEMP_DIR}/headersearch.cpp.tmp_orig/sub ${TEST_TEMP_DIR}/headersearch.cpp.tmp_orig/sub2
    RUN(TestState.Failed, "mkdir -p %t_orig/sub %t_orig/sub2");
    // echo 'struct orig_sub{char c; int i; };' > ${TEST_TEMP_DIR}/headersearch.cpp.tmp_orig/sub/orig_sub.h
    RUN(TestState.Failed, "echo 'struct orig_sub{char c; int i; };' > %t_orig/sub/orig_sub.h");
    // echo 'void orig_sub2_1();' > ${TEST_TEMP_DIR}/headersearch.cpp.tmp_orig/sub2/orig_sub2_1.h
    RUN(TestState.Failed, "echo 'void orig_sub2_1();' > %t_orig/sub2/orig_sub2_1.h");
    // echo '#include "orig_sub2_1.h"' > ${TEST_TEMP_DIR}/headersearch.cpp.tmp_orig/sub2/orig_sub2.h
    RUN(TestState.Failed, "echo '#include \"orig_sub2_1.h\"' > %t_orig/sub2/orig_sub2.h");
    // echo 'template <typename T> void tf() { orig_sub2_1(); T::foo(); }' >> ${TEST_TEMP_DIR}/headersearch.cpp.tmp_orig/sub2/orig_sub2.h
    RUN(TestState.Failed, "echo 'template <typename T> void tf() { orig_sub2_1(); T::foo(); }' >> %t_orig/sub2/orig_sub2.h");
    // echo 'void foo() {}' > ${TEST_TEMP_DIR}/headersearch.cpp.tmp_orig/tmp2.h
    RUN(TestState.Failed, "echo 'void foo() {}' > %t_orig/tmp2.h");
    // echo '#include "tmp2.h"' > ${TEST_TEMP_DIR}/headersearch.cpp.tmp_orig/all.h
    RUN(TestState.Failed, "echo '#include \"tmp2.h\"' > %t_orig/all.h");
    // echo '#include "sub/orig_sub.h"' >> ${TEST_TEMP_DIR}/headersearch.cpp.tmp_orig/all.h
    RUN(TestState.Failed, "echo '#include \"sub/orig_sub.h\"' >> %t_orig/all.h");
    // echo '#include "orig_sub2.h"' >> ${TEST_TEMP_DIR}/headersearch.cpp.tmp_orig/all.h
    RUN(TestState.Failed, "echo '#include \"orig_sub2.h\"' >> %t_orig/all.h");
    // echo 'int all();' >> ${TEST_TEMP_DIR}/headersearch.cpp.tmp_orig/all.h
    RUN(TestState.Failed, "echo 'int all();' >> %t_orig/all.h");
    // cd ${TEST_TEMP_DIR}/headersearch.cpp.tmp_orig && ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i386-pc-solaris2.11 -x c++ -emit-pch -o all.h.pch -Isub2 all.h
    RUN(TestState.Failed, "cd %t_orig");
    RUN(TestState.Failed, "%clang_cc1 -triple %itanium_abi_triple -x c++ -emit-pch -o all.h.pch -Isub2 all.h");
    // cp -R ${TEST_TEMP_DIR}/headersearch.cpp.tmp_orig ${TEST_TEMP_DIR}/headersearch.cpp.tmp_moved
    RUN(TestState.Failed, "cp -R %t_orig %t_moved");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i386-pc-solaris2.11 -include-pch all.h.pch "-I${TEST_TEMP_DIR}/headersearch.cpp.tmp_moved" "-I${TEST_TEMP_DIR}/headersearch.cpp.tmp_moved/sub2" -Wpadded -emit-llvm-only ${LLVM_SRC}/llvm/tools/clang/test/PCH/headersearch.cpp 2> ${TEST_TEMP_DIR}/headersearch.cpp.tmp.stderr
    RUN(TestState.Failed, "%clang_cc1 -triple %itanium_abi_triple -include-pch all.h.pch -I%t_moved -I%t_moved/sub2 -Wpadded -emit-llvm-only %s 2> %t.stderr");
    // grep 'struct orig_sub' ${TEST_TEMP_DIR}/headersearch.cpp.tmp.stderr
    RUN(TestState.Failed, "grep 'struct orig_sub' %t.stderr");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i386-pc-solaris2.11 -DREDECL -include-pch all.h.pch "-I${TEST_TEMP_DIR}/headersearch.cpp.tmp_moved" "-I${TEST_TEMP_DIR}/headersearch.cpp.tmp_moved/sub2" -emit-llvm-only ${LLVM_SRC}/llvm/tools/clang/test/PCH/headersearch.cpp 2> ${TEST_TEMP_DIR}/headersearch.cpp.tmp.stderr
    RUN(TestState.Failed, "not %clang_cc1 -triple %itanium_abi_triple -DREDECL -include-pch all.h.pch -I%t_moved -I%t_moved/sub2 -emit-llvm-only %s 2> %t.stderr");
    // grep 'void foo' ${TEST_TEMP_DIR}/headersearch.cpp.tmp.stderr
    RUN(TestState.Failed, "grep 'void foo' %t.stderr");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i386-pc-solaris2.11 -DINSTANTIATION -include-pch all.h.pch "-I${TEST_TEMP_DIR}/headersearch.cpp.tmp_moved" "-I${TEST_TEMP_DIR}/headersearch.cpp.tmp_moved/sub2" -emit-llvm-only ${LLVM_SRC}/llvm/tools/clang/test/PCH/headersearch.cpp 2> ${TEST_TEMP_DIR}/headersearch.cpp.tmp.stderr
    RUN(TestState.Failed, "not %clang_cc1 -triple %itanium_abi_triple -DINSTANTIATION -include-pch all.h.pch -I%t_moved -I%t_moved/sub2 -emit-llvm-only %s 2> %t.stderr");
    // grep orig_sub2_1 ${TEST_TEMP_DIR}/headersearch.cpp.tmp.stderr
    RUN(TestState.Failed, "grep 'orig_sub2_1' %t.stderr");
  }

  @Test
  public void test_implicitly_deleted_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/PCH/implicitly-deleted.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc '-std=c++11' -x c++-header ${LLVM_SRC}/llvm/tools/clang/test/PCH/implicitly-deleted.cpp -emit-pch -o ${TEST_TEMP_DIR}/implicitly-deleted.cpp.tmp.pch
    RUN("%clang_cc1 -std=c++11 -x c++-header %s -emit-pch -o %t.pch");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc '-std=c++11' -x c++ /dev/null -include-pch ${TEST_TEMP_DIR}/implicitly-deleted.cpp.tmp.pch
    RUN("%clang_cc1 -std=c++11 -x c++ /dev/null -include-pch %t.pch");
  }

  @Test
  public void test_include_timestamp_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/PCH/include-timestamp.cpp");
    // cp ${LLVM_SRC}/llvm/tools/clang/test/PCH/Inputs/pragma-once2-pch.h ${TEST_TEMP_DIR}
    RUN(TestState.Failed, "cp %S/Inputs/pragma-once2-pch.h %T");
    // cp ${LLVM_SRC}/llvm/tools/clang/test/PCH/Inputs/pragma-once2.h ${TEST_TEMP_DIR}
    RUN(TestState.Failed, "cp %S/Inputs/pragma-once2.h %T");
    // cp ${LLVM_SRC}/llvm/tools/clang/test/PCH/include-timestamp.cpp ${TEST_TEMP_DIR}/include-timestamp.cpp.tmp1.cpp
    RUN(TestState.Failed, "cp %s %t1.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x c++-header -emit-pch -o ${TEST_TEMP_DIR}/include-timestamp.cpp.tmp ${TEST_TEMP_DIR}/pragma-once2-pch.h
    RUN(TestState.Failed, "%clang_cc1 -x c++-header -emit-pch -o %t %T/pragma-once2-pch.h");
    // touch -m -a -t 201008011501 ${TEST_TEMP_DIR}/pragma-once2.h
    RUN(TestState.Failed, "touch -m -a -t 201008011501 %T/pragma-once2.h");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -include-pch ${TEST_TEMP_DIR}/include-timestamp.cpp.tmp ${TEST_TEMP_DIR}/include-timestamp.cpp.tmp1.cpp 2>&1 | ${LLVM_SRC}/build/bin/FileCheck '-check-prefix=CHECK-TIMESTAMP' ${LLVM_SRC}/llvm/tools/clang/test/PCH/include-timestamp.cpp
    RUN(TestState.Failed, "not %clang_cc1 -include-pch %t %t1.cpp 2>&1")./*|*/
      I("FileCheck -check-prefix=CHECK-TIMESTAMP %s");
    // llvm-bcanalyzer -dump ${TEST_TEMP_DIR}/include-timestamp.cpp.tmp | ${LLVM_SRC}/build/bin/FileCheck '-check-prefix=CHECK-BITCODE-TIMESTAMP-ON' ${LLVM_SRC}/llvm/tools/clang/test/PCH/include-timestamp.cpp
    RUN(TestState.Failed, "llvm-bcanalyzer -dump %t")./*|*/
      I("FileCheck -check-prefix=CHECK-BITCODE-TIMESTAMP-ON %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x c++-header -emit-pch -o ${TEST_TEMP_DIR}/include-timestamp.cpp.tmp ${TEST_TEMP_DIR}/pragma-once2-pch.h -fno-pch-timestamp
    RUN(TestState.Failed, "%clang_cc1 -x c++-header -emit-pch -o %t %T/pragma-once2-pch.h -fno-pch-timestamp");
    // touch -m -a -t 201008011502 ${TEST_TEMP_DIR}/pragma-once2.h
    RUN(TestState.Failed, "touch -m -a -t 201008011502 %T/pragma-once2.h");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -include-pch ${TEST_TEMP_DIR}/include-timestamp.cpp.tmp ${TEST_TEMP_DIR}/include-timestamp.cpp.tmp1.cpp 2>&1
    RUN(TestState.Failed, "%clang_cc1 -include-pch %t %t1.cpp 2>&1");
    // llvm-bcanalyzer -dump ${TEST_TEMP_DIR}/include-timestamp.cpp.tmp | ${LLVM_SRC}/build/bin/FileCheck '-check-prefix=CHECK-BITCODE-TIMESTAMP-OFF' ${LLVM_SRC}/llvm/tools/clang/test/PCH/include-timestamp.cpp
    RUN(TestState.Failed, "llvm-bcanalyzer -dump %t")./*|*/
      I("FileCheck -check-prefix=CHECK-BITCODE-TIMESTAMP-OFF %s");
  }

  @Test
  public void test_irgen_rdar13114142_mm() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/PCH/irgen-rdar13114142.mm");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/PCH/irgen-rdar13114142.mm -triple i386-pc-solaris2.11 -emit-pch -o ${TEST_TEMP_DIR}/irgen-rdar13114142.mm.tmp.pch
    RUN(TestState.Failed, "%clang_cc1 %s -triple %itanium_abi_triple -emit-pch -o %t.pch");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/PCH/irgen-rdar13114142.mm -triple i386-pc-solaris2.11 -emit-llvm -include-pch ${TEST_TEMP_DIR}/irgen-rdar13114142.mm.tmp.pch -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/PCH/irgen-rdar13114142.mm
    RUN(TestState.Failed, "%clang_cc1 %s -triple %itanium_abi_triple -emit-llvm -include-pch %t.pch -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_line_directive_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/PCH/line-directive.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -include ${LLVM_SRC}/llvm/tools/clang/test/PCH/line-directive.h -fsyntax-only ${LLVM_SRC}/llvm/tools/clang/test/PCH/line-directive.c 2>&1|grep '25:5'
    RUN("not %clang_cc1 -include %S/line-directive.h -fsyntax-only %s 2>&1")./*|*/
      I("grep \"25:5\"");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-pch -o ${TEST_TEMP_DIR}/line-directive.c.tmp ${LLVM_SRC}/llvm/tools/clang/test/PCH/line-directive.h
    RUN("%clang_cc1 -emit-pch -o %t %S/line-directive.h");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -include-pch ${TEST_TEMP_DIR}/line-directive.c.tmp -fsyntax-only ${LLVM_SRC}/llvm/tools/clang/test/PCH/line-directive.c 2>&1|grep '25:5'
    RUN("not %clang_cc1 -include-pch %t -fsyntax-only %s 2>&1")./*|*/
      I("grep \"25:5\"");
  }

  @Test
  public void test_local_static_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/PCH/local_static.cpp");
    // REQUIRES: x86-registered-target
    if (!CHECK_REQUIRES("x86-registered-target")) {
      return;
    }
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-apple-macosx10.9.0 -include ${LLVM_SRC}/llvm/tools/clang/test/PCH/local_static.h -fsyntax-only ${LLVM_SRC}/llvm/tools/clang/test/PCH/local_static.cpp -emit-llvm -o ${TEST_TEMP_DIR}/local_static.cpp.tmp.no_pch.ll ${LLVM_SRC}/llvm/tools/clang/test/PCH/local_static.cpp
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-apple-macosx10.9.0 -include %S/local_static.h -fsyntax-only %s -emit-llvm -o %t.no_pch.ll %s");
    // ${LLVM_SRC}/build/bin/FileCheck --input-file ${TEST_TEMP_DIR}/local_static.cpp.tmp.no_pch.ll ${LLVM_SRC}/llvm/tools/clang/test/PCH/local_static.cpp
    RUN(TestState.Failed, "FileCheck --input-file %t.no_pch.ll %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-apple-macosx10.9.0 -x c++-header -emit-pch -o ${TEST_TEMP_DIR}/local_static.cpp.tmp.pch ${LLVM_SRC}/llvm/tools/clang/test/PCH/local_static.h
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-apple-macosx10.9.0 -x c++-header -emit-pch -o %t.pch %S/local_static.h");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-apple-macosx10.9.0 -include-pch ${TEST_TEMP_DIR}/local_static.cpp.tmp.pch -emit-llvm -o ${TEST_TEMP_DIR}/local_static.cpp.tmp.pch.ll ${LLVM_SRC}/llvm/tools/clang/test/PCH/local_static.cpp
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-apple-macosx10.9.0 -include-pch %t.pch -emit-llvm -o %t.pch.ll %s");
    // ${LLVM_SRC}/build/bin/FileCheck --input-file ${TEST_TEMP_DIR}/local_static.cpp.tmp.pch.ll ${LLVM_SRC}/llvm/tools/clang/test/PCH/local_static.cpp
    RUN(TestState.Failed, "FileCheck --input-file %t.pch.ll %s");
  }

  @Test
  public void test_macro_redef_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/PCH/macro-redef.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/PCH/macro-redef.c -emit-pch -o ${TEST_TEMP_DIR}/macro-redef.c.tmp1.pch -verify
    RUN(TestState.Failed, "%clang_cc1 %s -emit-pch -o %t1.pch -verify");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/PCH/macro-redef.c -emit-pch -o ${TEST_TEMP_DIR}/macro-redef.c.tmp2.pch -include-pch ${TEST_TEMP_DIR}/macro-redef.c.tmp1.pch -verify
    RUN(TestState.Failed, "%clang_cc1 %s -emit-pch -o %t2.pch -include-pch %t1.pch -verify");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only ${LLVM_SRC}/llvm/tools/clang/test/PCH/macro-redef.c -include-pch ${TEST_TEMP_DIR}/macro-redef.c.tmp2.pch -verify
    RUN(TestState.Failed, "%clang_cc1 -fsyntax-only %s -include-pch %t2.pch -verify");
  }

  @Test
  public void test_macro_undef_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/PCH/macro-undef.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-pch -o ${TEST_TEMP_DIR}/macro-undef.cpp.tmp ${LLVM_SRC}/llvm/tools/clang/test/PCH/macro-undef.cpp
    RUN(TestState.Failed, "%clang_cc1 -emit-pch -o %t %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -include-pch ${TEST_TEMP_DIR}/macro-undef.cpp.tmp ${LLVM_SRC}/llvm/tools/clang/test/PCH/macro-undef.cpp -Wuninitialized -verify
    RUN(TestState.Failed, "%clang_cc1 -fsyntax-only -include-pch %t %s -Wuninitialized -verify");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -include-pch ${TEST_TEMP_DIR}/macro-undef.cpp.tmp ${LLVM_SRC}/llvm/tools/clang/test/PCH/macro-undef.cpp -Wuninitialized -fdiagnostics-parseable-fixits 2>&1 | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/PCH/macro-undef.cpp
    RUN(TestState.Failed, "%clang_cc1 -fsyntax-only -include-pch %t %s -Wuninitialized -fdiagnostics-parseable-fixits 2>&1")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_make_integer_seq_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/PCH/make-integer-seq.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc '-std=c++14' -x c++-header ${LLVM_SRC}/llvm/tools/clang/test/PCH/make-integer-seq.cpp -emit-pch -o ${TEST_TEMP_DIR}/make-integer-seq.cpp.tmp.pch
    RUN("%clang_cc1 -std=c++14 -x c++-header %s -emit-pch -o %t.pch");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc '-std=c++14' -x c++ /dev/null -include-pch ${TEST_TEMP_DIR}/make-integer-seq.cpp.tmp.pch
    RUN("%clang_cc1 -std=c++14 -x c++ /dev/null -include-pch %t.pch");
  }

  @Test
  public void test_method_redecls_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/PCH/method-redecls.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x objective-c ${LLVM_SRC}/llvm/tools/clang/test/PCH/method-redecls.m -emit-pch -o ${TEST_TEMP_DIR}/method-redecls.m.tmp
    RUN("%clang_cc1 -x objective-c %s -emit-pch -o %t");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x objective-c ${LLVM_SRC}/llvm/tools/clang/test/PCH/method-redecls.m -emit-pch -o ${TEST_TEMP_DIR}/method-redecls.m.tmp -D IMPL
    RUN("%clang_cc1 -x objective-c %s -emit-pch -o %t -D IMPL");
  }

  @Test
  public void test_method_pool_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/PCH/method_pool.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -include ${LLVM_SRC}/llvm/tools/clang/test/PCH/method_pool.h -fsyntax-only -verify -Wno-objc-root-class ${LLVM_SRC}/llvm/tools/clang/test/PCH/method_pool.m
    RUN("%clang_cc1 -include %S/method_pool.h -fsyntax-only -verify -Wno-objc-root-class %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x objective-c -Wno-objc-root-class -emit-pch -o ${TEST_TEMP_DIR}/method_pool.m.tmp ${LLVM_SRC}/llvm/tools/clang/test/PCH/method_pool.h
    RUN(TestState.Failed, "%clang_cc1 -x objective-c -Wno-objc-root-class -emit-pch -o %t %S/method_pool.h");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -include-pch ${TEST_TEMP_DIR}/method_pool.m.tmp -fsyntax-only -verify -Wno-objc-root-class ${LLVM_SRC}/llvm/tools/clang/test/PCH/method_pool.m
    RUN(TestState.Failed, "%clang_cc1 -include-pch %t -fsyntax-only -verify -Wno-objc-root-class %s");
  }

  @Test
  public void test_missing_file_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/PCH/missing-file.cpp");
    // REQUIRES: can-remove-opened-file
    if (!CHECK_REQUIRES("can-remove-opened-file")) {
      return;
    }
    // echo 'struct S{char c; int i; }; void foo() {}' > ${TEST_TEMP_DIR}/missing-file.cpp.tmp.h
    RUN("echo 'struct S{char c; int i; }; void foo() {}' > %t.h");
    // echo 'template <typename T> void tf() { T::foo(); }' >> ${TEST_TEMP_DIR}/missing-file.cpp.tmp.h
    RUN("echo 'template <typename T> void tf() { T::foo(); }' >> %t.h");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x c++ -emit-pch -o ${TEST_TEMP_DIR}/missing-file.cpp.tmp.h.pch ${TEST_TEMP_DIR}/missing-file.cpp.tmp.h
    RUN("%clang_cc1 -x c++ -emit-pch -o %t.h.pch %t.h");
    // rm ${TEST_TEMP_DIR}/missing-file.cpp.tmp.h
    RUN("rm %t.h");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -include-pch ${TEST_TEMP_DIR}/missing-file.cpp.tmp.h.pch -emit-obj -o ${TEST_TEMP_DIR}/missing-file.cpp.tmp.o ${LLVM_SRC}/llvm/tools/clang/test/PCH/missing-file.cpp 2> ${TEST_TEMP_DIR}/missing-file.cpp.tmp.stderr
    RUN("not %clang_cc1 -include-pch %t.h.pch -emit-obj -o %t.o %s 2> %t.stderr");
    // grep 'could not find file' ${TEST_TEMP_DIR}/missing-file.cpp.tmp.stderr
    RUN("grep 'could not find file' %t.stderr");
  }

  @Test
  public void test_modified_header_crash_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/PCH/modified-header-crash.c");
    // REQUIRES: ansi-escape-sequences
    if (!CHECK_REQUIRES("ansi-escape-sequences")) {
      return;
    }
    // cp ${LLVM_SRC}/llvm/tools/clang/test/PCH/modified-header-crash.h ${TEST_TEMP_DIR}/modified-header-crash.c.tmp.h
    RUN("cp %S/modified-header-crash.h %t.h");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -DCAKE -x c-header ${TEST_TEMP_DIR}/modified-header-crash.c.tmp.h -emit-pch -o ${TEST_TEMP_DIR}/modified-header-crash.c.tmp
    RUN("%clang_cc1 -DCAKE -x c-header %t.h -emit-pch -o %t");
    // echo 'int foobar;' >> ${TEST_TEMP_DIR}/modified-header-crash.c.tmp.h
    RUN("echo 'int foobar;' >> %t.h");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/PCH/modified-header-crash.c -include-pch ${TEST_TEMP_DIR}/modified-header-crash.c.tmp -fsyntax-only
    RUN("not %clang_cc1 %s -include-pch %t -fsyntax-only");
  }

  @Test
  public void test_modified_header_error_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/PCH/modified-header-error.c");
    // REQUIRES: shell
    if (!CHECK_REQUIRES("shell")) {
      return;
    }
    // mkdir -p ${TEST_TEMP_DIR}/modified-header-error.c.tmp.dir
    RUN("mkdir -p %t.dir");
    // echo '#include "header2.h"' > ${TEST_TEMP_DIR}/modified-header-error.c.tmp.dir/header1.h
    RUN("echo '#include \"header2.h\"' > %t.dir/header1.h");
    // echo > ${TEST_TEMP_DIR}/modified-header-error.c.tmp.dir/header2.h
    RUN("echo > %t.dir/header2.h");
    // cp ${LLVM_SRC}/llvm/tools/clang/test/PCH/modified-header-error.c ${TEST_TEMP_DIR}/modified-header-error.c.tmp.dir/t.c
    RUN("cp %s %t.dir/t.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x c-header ${TEST_TEMP_DIR}/modified-header-error.c.tmp.dir/header1.h -emit-pch -o ${TEST_TEMP_DIR}/modified-header-error.c.tmp.pch
    RUN("%clang_cc1 -x c-header %t.dir/header1.h -emit-pch -o %t.pch");
    // echo >> ${TEST_TEMP_DIR}/modified-header-error.c.tmp.dir/header2.h
    RUN("echo >> %t.dir/header2.h");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${TEST_TEMP_DIR}/modified-header-error.c.tmp.dir/t.c -include-pch ${TEST_TEMP_DIR}/modified-header-error.c.tmp.pch -fsyntax-only 2>&1 | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/PCH/modified-header-error.c
    RUN("not %clang_cc1 %t.dir/t.c -include-pch %t.pch -fsyntax-only 2>&1")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_modified_module_dependency_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/PCH/modified-module-dependency.m");
    // rm -rf ${TEST_TEMP_DIR}/modified-module-dependency.m.tmp-dir
    RUN("rm -rf %t-dir");
    // mkdir -p ${TEST_TEMP_DIR}/modified-module-dependency.m.tmp-dir
    RUN("mkdir -p %t-dir");
    // echo '@import test;' > ${TEST_TEMP_DIR}/modified-module-dependency.m.tmp-dir/prefix.h
    RUN("echo '@import test;' > %t-dir/prefix.h");
    // echo 'void foo(void);' > ${TEST_TEMP_DIR}/modified-module-dependency.m.tmp-dir/test.h
    RUN("echo 'void foo(void);' > %t-dir/test.h");
    // cp ${LLVM_SRC}/llvm/tools/clang/test/PCH/modified-module-dependency.module.map ${TEST_TEMP_DIR}/modified-module-dependency.m.tmp-dir/module.map
    RUN("cp %S/modified-module-dependency.module.map %t-dir/module.map");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x objective-c -I ${TEST_TEMP_DIR}/modified-module-dependency.m.tmp-dir -fmodules -fimplicit-module-maps "-fmodules-cache-path=${TEST_TEMP_DIR}/modified-module-dependency.m.tmp-dir/cache" -fdisable-module-hash -emit-pch ${TEST_TEMP_DIR}/modified-module-dependency.m.tmp-dir/prefix.h -o ${TEST_TEMP_DIR}/modified-module-dependency.m.tmp-dir/prefix.pch
    RUN("%clang_cc1 -x objective-c -I %t-dir -fmodules -fimplicit-module-maps -fmodules-cache-path=%t-dir/cache -fdisable-module-hash -emit-pch %t-dir/prefix.h -o %t-dir/prefix.pch");
    // echo ' ' >> ${TEST_TEMP_DIR}/modified-module-dependency.m.tmp-dir/test.h
    RUN("echo ' ' >> %t-dir/test.h");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x objective-c -I ${TEST_TEMP_DIR}/modified-module-dependency.m.tmp-dir -include-pch ${TEST_TEMP_DIR}/modified-module-dependency.m.tmp-dir/prefix.pch -fmodules -fimplicit-module-maps "-fmodules-cache-path=${TEST_TEMP_DIR}/modified-module-dependency.m.tmp-dir/cache" -fdisable-module-hash -fsyntax-only ${LLVM_SRC}/llvm/tools/clang/test/PCH/modified-module-dependency.m 2> ${TEST_TEMP_DIR}/modified-module-dependency.m.tmp-dir/log
    RUN("not %clang_cc1 -x objective-c -I %t-dir -include-pch %t-dir/prefix.pch -fmodules -fimplicit-module-maps -fmodules-cache-path=%t-dir/cache -fdisable-module-hash -fsyntax-only %s 2> %t-dir/log");
    // ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/PCH/modified-module-dependency.m < ${TEST_TEMP_DIR}/modified-module-dependency.m.tmp-dir/log
    RUN("FileCheck %s < %t-dir/log");
  }

  @Test
  public void test_module_hash_difference_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/PCH/module-hash-difference.m");
    // rm -rf ${TEST_TEMP_DIR}/module-hash-difference.m.tmp.mcp
    RUN("rm -rf %t.mcp");
    // rm -rf ${TEST_TEMP_DIR}/module-hash-difference.m.tmp.err
    RUN("rm -rf %t.err");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-pch -o ${TEST_TEMP_DIR}/module-hash-difference.m.tmp.pch ${LLVM_SRC}/llvm/tools/clang/test/PCH/module-hash-difference.m -I ${LLVM_SRC}/llvm/tools/clang/test/PCH/Inputs/modules -fmodules -fimplicit-module-maps "-fmodules-cache-path=${TEST_TEMP_DIR}/module-hash-difference.m.tmp.mcp"
    RUN("%clang_cc1 -emit-pch -o %t.pch %s -I %S/Inputs/modules -fmodules -fimplicit-module-maps -fmodules-cache-path=%t.mcp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -include-pch ${TEST_TEMP_DIR}/module-hash-difference.m.tmp.pch ${LLVM_SRC}/llvm/tools/clang/test/PCH/module-hash-difference.m -I ${LLVM_SRC}/llvm/tools/clang/test/PCH/Inputs/modules -fmodules -fimplicit-module-maps "-fmodules-cache-path=${TEST_TEMP_DIR}/module-hash-difference.m.tmp.mcp" -fdisable-module-hash 2> ${TEST_TEMP_DIR}/module-hash-difference.m.tmp.err
    RUN("not %clang_cc1 -fsyntax-only -include-pch %t.pch %s -I %S/Inputs/modules -fmodules -fimplicit-module-maps -fmodules-cache-path=%t.mcp -fdisable-module-hash 2> %t.err");
    // ${LLVM_SRC}/build/bin/FileCheck "-input-file=${TEST_TEMP_DIR}/module-hash-difference.m.tmp.err" ${LLVM_SRC}/llvm/tools/clang/test/PCH/module-hash-difference.m
    RUN("FileCheck -input-file=%t.err %s");
  }

  @Test
  public void test_ms_if_exists_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/PCH/ms-if-exists.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x c++ -fms-extensions -fsyntax-only -emit-pch -o ${TEST_TEMP_DIR}/ms-if-exists.cpp.tmp ${LLVM_SRC}/llvm/tools/clang/test/PCH/ms-if-exists.cpp
    RUN("%clang_cc1 -x c++ -fms-extensions -fsyntax-only -emit-pch -o %t %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x c++ -fms-extensions -fsyntax-only -include-pch ${TEST_TEMP_DIR}/ms-if-exists.cpp.tmp ${LLVM_SRC}/llvm/tools/clang/test/PCH/ms-if-exists.cpp -verify
    RUN("%clang_cc1 -x c++ -fms-extensions -fsyntax-only -include-pch %t %s -verify");
  }

  @Test
  public void test_multiple_include_pch_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/PCH/multiple-include-pch.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-pch -o ${TEST_TEMP_DIR}/multiple-include-pch.c.tmp1.pch ${LLVM_SRC}/llvm/tools/clang/test/PCH/multiple-include-pch.c
    RUN("%clang_cc1 -emit-pch -o %t1.pch %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-pch -o ${TEST_TEMP_DIR}/multiple-include-pch.c.tmp2.pch ${LLVM_SRC}/llvm/tools/clang/test/PCH/multiple-include-pch.c
    RUN("%clang_cc1 -emit-pch -o %t2.pch %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/PCH/multiple-include-pch.c -include-pch ${TEST_TEMP_DIR}/multiple-include-pch.c.tmp1.pch -include-pch ${TEST_TEMP_DIR}/multiple-include-pch.c.tmp2.pch -verify
    RUN("%clang_cc1 %s -include-pch %t1.pch -include-pch %t2.pch -verify");
  }

  @Test
  public void test_multiple_decls_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/PCH/multiple_decls.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -include ${LLVM_SRC}/llvm/tools/clang/test/PCH/multiple_decls.h -fsyntax-only -ast-print -o - ${LLVM_SRC}/llvm/tools/clang/test/PCH/multiple_decls.c
    RUN("%clang_cc1 -include %S/multiple_decls.h -fsyntax-only -ast-print -o - %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-pch -o ${TEST_TEMP_DIR}/multiple_decls.c.tmp ${LLVM_SRC}/llvm/tools/clang/test/PCH/multiple_decls.h
    RUN("%clang_cc1 -emit-pch -o %t %S/multiple_decls.h");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -include-pch ${TEST_TEMP_DIR}/multiple_decls.c.tmp -fsyntax-only -ast-print -o - ${LLVM_SRC}/llvm/tools/clang/test/PCH/multiple_decls.c
    RUN("%clang_cc1 -include-pch %t -fsyntax-only -ast-print -o - %s");
  }

  @Test
  public void test_namespaces_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/PCH/namespaces.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x c++ -include ${LLVM_SRC}/llvm/tools/clang/test/PCH/Inputs/namespaces.h -fsyntax-only ${LLVM_SRC}/llvm/tools/clang/test/PCH/namespaces.cpp
    RUN("%clang_cc1 -x c++ -include %S/Inputs/namespaces.h -fsyntax-only %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x c++ -emit-pch -o ${TEST_TEMP_DIR}/namespaces.cpp.tmp ${LLVM_SRC}/llvm/tools/clang/test/PCH/Inputs/namespaces.h
    RUN("%clang_cc1 -x c++ -emit-pch -o %t %S/Inputs/namespaces.h");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x c++ -include-pch ${TEST_TEMP_DIR}/namespaces.cpp.tmp -fsyntax-only ${LLVM_SRC}/llvm/tools/clang/test/PCH/namespaces.cpp
    RUN("%clang_cc1 -x c++ -include-pch %t -fsyntax-only %s");
  }

  @Test
  public void test_nonvisible_external_defs_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/PCH/nonvisible-external-defs.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -include ${LLVM_SRC}/llvm/tools/clang/test/PCH/nonvisible-external-defs.h -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/PCH/nonvisible-external-defs.c
    RUN("%clang_cc1 -include %S/nonvisible-external-defs.h -fsyntax-only -verify %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-pch -o ${TEST_TEMP_DIR}/nonvisible-external-defs.c.tmp ${LLVM_SRC}/llvm/tools/clang/test/PCH/nonvisible-external-defs.h
    RUN("%clang_cc1 -emit-pch -o %t %S/nonvisible-external-defs.h");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -include-pch ${TEST_TEMP_DIR}/nonvisible-external-defs.c.tmp -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/PCH/nonvisible-external-defs.c
    RUN("%clang_cc1 -include-pch %t -fsyntax-only -verify %s");
  }

  @Test
  public void test_objc_boxable_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/PCH/objc_boxable.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x objective-c ${LLVM_SRC}/llvm/tools/clang/test/PCH/objc_boxable_record.h -emit-pch -o ${TEST_TEMP_DIR}/objc_boxable.m.tmp1
    RUN("%clang_cc1 -x objective-c %S/objc_boxable_record.h -emit-pch -o %t1");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x objective-c ${LLVM_SRC}/llvm/tools/clang/test/PCH/objc_boxable_record_attr.h -include-pch ${TEST_TEMP_DIR}/objc_boxable.m.tmp1 -emit-pch -o ${TEST_TEMP_DIR}/objc_boxable.m.tmp2
    RUN("%clang_cc1 -x objective-c %S/objc_boxable_record_attr.h -include-pch %t1 -emit-pch -o %t2");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/PCH/objc_boxable.m -include-pch ${TEST_TEMP_DIR}/objc_boxable.m.tmp2 -fsyntax-only -verify
    RUN("%clang_cc1 %s -include-pch %t2 -fsyntax-only -verify");
  }

  @Test
  public void test_objc_container_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/PCH/objc_container.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -include ${LLVM_SRC}/llvm/tools/clang/test/PCH/objc_container.h -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/PCH/objc_container.m
    RUN("%clang_cc1 -include %S/objc_container.h -fsyntax-only -verify %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x objective-c -emit-pch -o ${TEST_TEMP_DIR}/objc_container.m.tmp ${LLVM_SRC}/llvm/tools/clang/test/PCH/objc_container.h
    RUN(TestState.Failed, "%clang_cc1 -x objective-c -emit-pch -o %t %S/objc_container.h");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -include-pch ${TEST_TEMP_DIR}/objc_container.m.tmp -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/PCH/objc_container.m
    RUN(TestState.Failed, "%clang_cc1 -include-pch %t -fsyntax-only -verify %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -include-pch ${TEST_TEMP_DIR}/objc_container.m.tmp -ast-print ${LLVM_SRC}/llvm/tools/clang/test/PCH/objc_container.m | ${LLVM_SRC}/build/bin/FileCheck '-check-prefix=CHECK-PRINT' ${LLVM_SRC}/llvm/tools/clang/test/PCH/objc_container.m
    RUN(TestState.Failed, "%clang_cc1 -include-pch %t -ast-print %s")./*|*/
      I("FileCheck -check-prefix=CHECK-PRINT %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -include-pch ${TEST_TEMP_DIR}/objc_container.m.tmp -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/PCH/objc_container.m | ${LLVM_SRC}/build/bin/FileCheck '-check-prefix=CHECK-IR' ${LLVM_SRC}/llvm/tools/clang/test/PCH/objc_container.m
    RUN(TestState.Failed, "%clang_cc1 -include-pch %t -emit-llvm -o - %s")./*|*/
      I("FileCheck -check-prefix=CHECK-IR %s");
  }

  @Test
  public void test_objc_exprs_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/PCH/objc_exprs.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fblocks -include ${LLVM_SRC}/llvm/tools/clang/test/PCH/objc_exprs.h -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/PCH/objc_exprs.m
    RUN("%clang_cc1 -fblocks -include %S/objc_exprs.h -fsyntax-only -verify %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x objective-c-header -emit-pch -fblocks -o ${TEST_TEMP_DIR}/objc_exprs.m.tmp ${LLVM_SRC}/llvm/tools/clang/test/PCH/objc_exprs.h
    RUN("%clang_cc1 -x objective-c-header -emit-pch -fblocks -o %t %S/objc_exprs.h");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fblocks -include-pch ${TEST_TEMP_DIR}/objc_exprs.m.tmp -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/PCH/objc_exprs.m
    RUN("%clang_cc1 -fblocks -include-pch %t -fsyntax-only -verify %s");
  }

  @Test
  public void test_objc_import_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/PCH/objc_import.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -include ${LLVM_SRC}/llvm/tools/clang/test/PCH/objc_import.h -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/PCH/objc_import.m
    RUN("%clang_cc1 -include %S/objc_import.h -fsyntax-only -verify %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x objective-c -emit-pch -o ${TEST_TEMP_DIR}/objc_import.m.tmp ${LLVM_SRC}/llvm/tools/clang/test/PCH/objc_import.h
    RUN(TestState.Failed, "%clang_cc1 -x objective-c -emit-pch -o %t %S/objc_import.h");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -include-pch ${TEST_TEMP_DIR}/objc_import.m.tmp -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/PCH/objc_import.m
    RUN(TestState.Failed, "%clang_cc1 -include-pch %t -fsyntax-only -verify %s");
  }

  @Test
  public void test_objc_kindof_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/PCH/objc_kindof.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-pch ${LLVM_SRC}/llvm/tools/clang/test/PCH/objc_kindof.m -o ${TEST_TEMP_DIR}/objc_kindof.m.tmp
    RUN("%clang_cc1 -emit-pch %s -o %t");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -include-pch ${TEST_TEMP_DIR}/objc_kindof.m.tmp -verify ${LLVM_SRC}/llvm/tools/clang/test/PCH/objc_kindof.m
    RUN("%clang_cc1 -include-pch %t -verify %s");
  }

  @Test
  public void test_objc_literals_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/PCH/objc_literals.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-pch -o ${TEST_TEMP_DIR}/objc_literals.m.tmp ${LLVM_SRC}/llvm/tools/clang/test/PCH/objc_literals.m
    RUN(TestState.Failed, "%clang_cc1 -emit-pch -o %t %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -include-pch ${TEST_TEMP_DIR}/objc_literals.m.tmp -verify ${LLVM_SRC}/llvm/tools/clang/test/PCH/objc_literals.m
    RUN(TestState.Failed, "%clang_cc1 -include-pch %t -verify %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -include-pch ${TEST_TEMP_DIR}/objc_literals.m.tmp -ast-print ${LLVM_SRC}/llvm/tools/clang/test/PCH/objc_literals.m | ${LLVM_SRC}/build/bin/FileCheck '-check-prefix=CHECK-PRINT' ${LLVM_SRC}/llvm/tools/clang/test/PCH/objc_literals.m
    RUN(TestState.Failed, "%clang_cc1 -include-pch %t -ast-print %s")./*|*/
      I("FileCheck -check-prefix=CHECK-PRINT %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -include-pch ${TEST_TEMP_DIR}/objc_literals.m.tmp -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/PCH/objc_literals.m | ${LLVM_SRC}/build/bin/FileCheck '-check-prefix=CHECK-IR' ${LLVM_SRC}/llvm/tools/clang/test/PCH/objc_literals.m
    RUN(TestState.Failed, "%clang_cc1 -include-pch %t -emit-llvm -o - %s")./*|*/
      I("FileCheck -check-prefix=CHECK-IR %s");
  }

  @Test
  public void test_objc_literals_mm() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/PCH/objc_literals.mm");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i386-pc-solaris2.11 -emit-pch -x objective-c++ '-std=c++0x' -o ${TEST_TEMP_DIR}/objc_literals.mm.tmp ${LLVM_SRC}/llvm/tools/clang/test/PCH/objc_literals.mm
    RUN(TestState.Failed, "%clang_cc1 -triple %itanium_abi_triple -emit-pch -x objective-c++ -std=c++0x -o %t %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i386-pc-solaris2.11 -include-pch ${TEST_TEMP_DIR}/objc_literals.mm.tmp -x objective-c++ '-std=c++0x' -verify ${LLVM_SRC}/llvm/tools/clang/test/PCH/objc_literals.mm
    RUN(TestState.Failed, "%clang_cc1 -triple %itanium_abi_triple -include-pch %t -x objective-c++ -std=c++0x -verify %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i386-pc-solaris2.11 -include-pch ${TEST_TEMP_DIR}/objc_literals.mm.tmp -x objective-c++ '-std=c++0x' -ast-print ${LLVM_SRC}/llvm/tools/clang/test/PCH/objc_literals.mm | ${LLVM_SRC}/build/bin/FileCheck '-check-prefix=CHECK-PRINT' ${LLVM_SRC}/llvm/tools/clang/test/PCH/objc_literals.mm
    RUN(TestState.Failed, "%clang_cc1 -triple %itanium_abi_triple -include-pch %t -x objective-c++ -std=c++0x -ast-print %s")./*|*/
      I("FileCheck -check-prefix=CHECK-PRINT %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i386-pc-solaris2.11 -include-pch ${TEST_TEMP_DIR}/objc_literals.mm.tmp -x objective-c++ '-std=c++0x' -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/PCH/objc_literals.mm | ${LLVM_SRC}/build/bin/FileCheck '-check-prefix=CHECK-IR' ${LLVM_SRC}/llvm/tools/clang/test/PCH/objc_literals.mm
    RUN(TestState.Failed, "%clang_cc1 -triple %itanium_abi_triple -include-pch %t -x objective-c++ -std=c++0x -emit-llvm -o - %s")./*|*/
      I("FileCheck -check-prefix=CHECK-IR %s");
  }

  @Test
  public void test_objc_methods_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/PCH/objc_methods.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -include ${LLVM_SRC}/llvm/tools/clang/test/PCH/objc_methods.h -fsyntax-only -Wno-objc-root-class -verify ${LLVM_SRC}/llvm/tools/clang/test/PCH/objc_methods.m
    RUN("%clang_cc1 -include %S/objc_methods.h -fsyntax-only -Wno-objc-root-class -verify %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x objective-c -emit-pch -o ${TEST_TEMP_DIR}/objc_methods.m.tmp ${LLVM_SRC}/llvm/tools/clang/test/PCH/objc_methods.h
    RUN(TestState.Failed, "%clang_cc1 -x objective-c -emit-pch -o %t %S/objc_methods.h");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -include-pch ${TEST_TEMP_DIR}/objc_methods.m.tmp -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/PCH/objc_methods.m
    RUN(TestState.Failed, "%clang_cc1 -include-pch %t -fsyntax-only -verify %s");
  }

  @Test
  public void test_objc_parameterized_classes_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/PCH/objc_parameterized_classes.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-pch ${LLVM_SRC}/llvm/tools/clang/test/PCH/objc_parameterized_classes.m -o ${TEST_TEMP_DIR}/objc_parameterized_classes.m.tmp
    RUN("%clang_cc1 -emit-pch %s -o %t");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -include-pch ${TEST_TEMP_DIR}/objc_parameterized_classes.m.tmp -verify ${LLVM_SRC}/llvm/tools/clang/test/PCH/objc_parameterized_classes.m
    RUN("%clang_cc1 -include-pch %t -verify %s");
  }

  @Test
  public void test_objc_property_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/PCH/objc_property.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -include ${LLVM_SRC}/llvm/tools/clang/test/PCH/objc_property.h -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/PCH/objc_property.m
    RUN("%clang_cc1 -include %S/objc_property.h -fsyntax-only -verify %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x objective-c -emit-pch -o ${TEST_TEMP_DIR}/objc_property.m.tmp ${LLVM_SRC}/llvm/tools/clang/test/PCH/objc_property.h
    RUN(TestState.Failed, "%clang_cc1 -x objective-c -emit-pch -o %t %S/objc_property.h");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -include-pch ${TEST_TEMP_DIR}/objc_property.m.tmp -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/PCH/objc_property.m
    RUN(TestState.Failed, "%clang_cc1 -include-pch %t -fsyntax-only -verify %s");
  }

  @Test
  public void test_objc_stmts_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/PCH/objc_stmts.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -include ${LLVM_SRC}/llvm/tools/clang/test/PCH/objc_stmts.h -emit-llvm -fobjc-exceptions -o - ${LLVM_SRC}/llvm/tools/clang/test/PCH/objc_stmts.m
    RUN(TestState.Failed, "%clang_cc1 -include %S/objc_stmts.h -emit-llvm -fobjc-exceptions -o - %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -include ${LLVM_SRC}/llvm/tools/clang/test/PCH/objc_stmts.h -ast-print -fobjc-exceptions -o - ${LLVM_SRC}/llvm/tools/clang/test/PCH/objc_stmts.m | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/PCH/objc_stmts.m
    RUN(TestState.Failed, "%clang_cc1 -include %S/objc_stmts.h -ast-print -fobjc-exceptions -o - %s")./*|*/
      I("FileCheck %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x objective-c -emit-pch -fobjc-exceptions -o ${TEST_TEMP_DIR}/objc_stmts.m.tmp ${LLVM_SRC}/llvm/tools/clang/test/PCH/objc_stmts.h
    RUN(TestState.Failed, "%clang_cc1 -x objective-c -emit-pch -fobjc-exceptions -o %t %S/objc_stmts.h");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -include-pch ${TEST_TEMP_DIR}/objc_stmts.m.tmp -emit-llvm -fobjc-exceptions -o - ${LLVM_SRC}/llvm/tools/clang/test/PCH/objc_stmts.m
    RUN(TestState.Failed, "%clang_cc1 -include-pch %t -emit-llvm -fobjc-exceptions -o - %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -include-pch ${TEST_TEMP_DIR}/objc_stmts.m.tmp -ast-print -fobjc-exceptions -o - ${LLVM_SRC}/llvm/tools/clang/test/PCH/objc_stmts.m | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/PCH/objc_stmts.m
    RUN(TestState.Failed, "%clang_cc1 -include-pch %t -ast-print -fobjc-exceptions -o - %s")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_objcxx_ivar_class_mm() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/PCH/objcxx-ivar-class.mm");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -include ${LLVM_SRC}/llvm/tools/clang/test/PCH/objcxx-ivar-class.h -triple i386-pc-solaris2.11 ${LLVM_SRC}/llvm/tools/clang/test/PCH/objcxx-ivar-class.mm -emit-llvm -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/PCH/objcxx-ivar-class.mm
    RUN(TestState.Failed, "%clang_cc1 -include %S/objcxx-ivar-class.h -triple %itanium_abi_triple %s -emit-llvm -o -")./*|*/
      I("FileCheck %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x objective-c++-header -triple i386-pc-solaris2.11 -emit-pch -o ${TEST_TEMP_DIR}/objcxx-ivar-class.mm.tmp ${LLVM_SRC}/llvm/tools/clang/test/PCH/objcxx-ivar-class.h
    RUN(TestState.Failed, "%clang_cc1 -x objective-c++-header -triple %itanium_abi_triple -emit-pch -o %t %S/objcxx-ivar-class.h");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -include-pch ${TEST_TEMP_DIR}/objcxx-ivar-class.mm.tmp -triple i386-pc-solaris2.11 ${LLVM_SRC}/llvm/tools/clang/test/PCH/objcxx-ivar-class.mm -emit-llvm -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/PCH/objcxx-ivar-class.mm
    RUN(TestState.Failed, "%clang_cc1 -include-pch %t -triple %itanium_abi_triple %s -emit-llvm -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_ocl_types_cl() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/PCH/ocl_types.cl");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -include ${LLVM_SRC}/llvm/tools/clang/test/PCH/ocl_types.h -fsyntax-only ${LLVM_SRC}/llvm/tools/clang/test/PCH/ocl_types.cl '-cl-std=CL2.0' '-D__OPENCL_VERSION__=200'
    RUN("%clang_cc1 -include %S/ocl_types.h -fsyntax-only %s -cl-std=CL2.0 -D__OPENCL_VERSION__=200");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x cl -emit-pch -o ${TEST_TEMP_DIR}/ocl_types.cl.tmp ${LLVM_SRC}/llvm/tools/clang/test/PCH/ocl_types.h '-cl-std=CL2.0' '-D__OPENCL_VERSION__=200'
    RUN("%clang_cc1 -x cl -emit-pch -o %t %S/ocl_types.h -cl-std=CL2.0 -D__OPENCL_VERSION__=200");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -include-pch ${TEST_TEMP_DIR}/ocl_types.cl.tmp -fsyntax-only ${LLVM_SRC}/llvm/tools/clang/test/PCH/ocl_types.cl -ast-print '-cl-std=CL2.0' '-D__OPENCL_VERSION__=200'
    RUN("%clang_cc1 -include-pch %t -fsyntax-only %s -ast-print -cl-std=CL2.0 -D__OPENCL_VERSION__=200");
  }

  @Test
  public void test_opencl_extensions_cl() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/PCH/opencl-extensions.cl");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-pch -o ${TEST_TEMP_DIR}/opencl-extensions.cl.tmp ${LLVM_SRC}/llvm/tools/clang/test/PCH/opencl-extensions.cl -triple spir-unknown-unknown
    RUN("%clang_cc1 -emit-pch -o %t %s -triple spir-unknown-unknown");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -include-pch ${TEST_TEMP_DIR}/opencl-extensions.cl.tmp -fsyntax-only ${LLVM_SRC}/llvm/tools/clang/test/PCH/opencl-extensions.cl -triple spir-unknown-unknown
    RUN("%clang_cc1 -include-pch %t -fsyntax-only %s  -triple spir-unknown-unknown");
  }

  @Test
  public void test_pch_dir_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/PCH/pch-dir.c");
    // rm -rf ${TEST_TEMP_DIR}/pch-dir.c.tmp.h.gch
    RUN(TestState.Failed, "rm -rf %t.h.gch");
    // mkdir -p ${TEST_TEMP_DIR}/pch-dir.c.tmp.h.gch
    RUN(TestState.Failed, "mkdir -p %t.h.gch");
    // ${LLVM_SRC}/build/bin/clang -x c-header ${LLVM_SRC}/llvm/tools/clang/test/PCH/pch-dir.h '-DFOO=foo' -o ${TEST_TEMP_DIR}/pch-dir.c.tmp.h.gch/c.gch
    RUN(TestState.Failed, "%clang -x c-header %S/pch-dir.h -DFOO=foo -o %t.h.gch/c.gch");
    // ${LLVM_SRC}/build/bin/clang -x c-header ${LLVM_SRC}/llvm/tools/clang/test/PCH/pch-dir.h '-DFOO=bar' -o ${TEST_TEMP_DIR}/pch-dir.c.tmp.h.gch/cbar.gch
    RUN(TestState.Failed, "%clang -x c-header %S/pch-dir.h -DFOO=bar -o %t.h.gch/cbar.gch");
    // ${LLVM_SRC}/build/bin/clang -x c++-header '-std=c++98' ${LLVM_SRC}/llvm/tools/clang/test/PCH/pch-dir.h -o ${TEST_TEMP_DIR}/pch-dir.c.tmp.h.gch/cpp.gch
    RUN(TestState.Failed, "%clang -x c++-header -std=c++98 %S/pch-dir.h -o %t.h.gch/cpp.gch");
    // ${LLVM_SRC}/build/bin/clang -include ${TEST_TEMP_DIR}/pch-dir.c.tmp.h '-DFOO=foo' -fsyntax-only ${LLVM_SRC}/llvm/tools/clang/test/PCH/pch-dir.c -Xclang -print-stats 2> ${TEST_TEMP_DIR}/pch-dir.c.tmp.clog
    RUN(TestState.Failed, "%clang -include %t.h -DFOO=foo -fsyntax-only %s -Xclang -print-stats 2> %t.clog");
    // ${LLVM_SRC}/build/bin/FileCheck '-check-prefix=CHECK-C' ${LLVM_SRC}/llvm/tools/clang/test/PCH/pch-dir.c < ${TEST_TEMP_DIR}/pch-dir.c.tmp.clog
    RUN(TestState.Failed, "FileCheck -check-prefix=CHECK-C %s < %t.clog");
    // ${LLVM_SRC}/build/bin/clang -include ${TEST_TEMP_DIR}/pch-dir.c.tmp.h '-DFOO=bar' '-DBAR=bar' -fsyntax-only ${LLVM_SRC}/llvm/tools/clang/test/PCH/pch-dir.c -Xclang -ast-print > ${TEST_TEMP_DIR}/pch-dir.c.tmp.cbarlog
    RUN(TestState.Failed, "%clang -include %t.h -DFOO=bar -DBAR=bar -fsyntax-only %s -Xclang -ast-print > %t.cbarlog");
    // ${LLVM_SRC}/build/bin/FileCheck '-check-prefix=CHECK-CBAR' ${LLVM_SRC}/llvm/tools/clang/test/PCH/pch-dir.c < ${TEST_TEMP_DIR}/pch-dir.c.tmp.cbarlog
    RUN(TestState.Failed, "FileCheck -check-prefix=CHECK-CBAR %s < %t.cbarlog");
    // ${LLVM_SRC}/build/bin/clang -x c++ -include ${TEST_TEMP_DIR}/pch-dir.c.tmp.h '-std=c++98' -fsyntax-only ${LLVM_SRC}/llvm/tools/clang/test/PCH/pch-dir.c -Xclang -print-stats 2> ${TEST_TEMP_DIR}/pch-dir.c.tmp.cpplog
    RUN(TestState.Failed, "%clang -x c++ -include %t.h -std=c++98 -fsyntax-only %s -Xclang -print-stats 2> %t.cpplog");
    // ${LLVM_SRC}/build/bin/FileCheck '-check-prefix=CHECK-CPP' ${LLVM_SRC}/llvm/tools/clang/test/PCH/pch-dir.c < ${TEST_TEMP_DIR}/pch-dir.c.tmp.cpplog
    RUN(TestState.Failed, "FileCheck -check-prefix=CHECK-CPP %s < %t.cpplog");
    // ${LLVM_SRC}/build/bin/clang -x c++ '-std=c++11' -include ${TEST_TEMP_DIR}/pch-dir.c.tmp.h -fsyntax-only ${LLVM_SRC}/llvm/tools/clang/test/PCH/pch-dir.c 2> ${TEST_TEMP_DIR}/pch-dir.c.tmp.cpp11log
    RUN(TestState.Failed, "not %clang -x c++ -std=c++11 -include %t.h -fsyntax-only %s 2> %t.cpp11log");
    // ${LLVM_SRC}/build/bin/FileCheck '-check-prefix=CHECK-NO-SUITABLE' ${LLVM_SRC}/llvm/tools/clang/test/PCH/pch-dir.c < ${TEST_TEMP_DIR}/pch-dir.c.tmp.cpp11log
    RUN(TestState.Failed, "FileCheck -check-prefix=CHECK-NO-SUITABLE %s < %t.cpp11log");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -include-pch ${TEST_TEMP_DIR}/pch-dir.c.tmp.h.gch '-DFOO=baz' -fsyntax-only ${LLVM_SRC}/llvm/tools/clang/test/PCH/pch-dir.c -print-stats 2> ${TEST_TEMP_DIR}/pch-dir.c.tmp.missinglog
    RUN(TestState.Failed, "not %clang_cc1 -include-pch %t.h.gch -DFOO=baz -fsyntax-only %s -print-stats 2> %t.missinglog");
    // ${LLVM_SRC}/build/bin/FileCheck '-check-prefix=CHECK-NO-SUITABLE' ${LLVM_SRC}/llvm/tools/clang/test/PCH/pch-dir.c < ${TEST_TEMP_DIR}/pch-dir.c.tmp.missinglog
    RUN(TestState.Failed, "FileCheck -check-prefix=CHECK-NO-SUITABLE %s < %t.missinglog");
  }

  @Test
  public void test_pch__VA_ARGS___c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/PCH/pch__VA_ARGS__.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-pch -o ${TEST_TEMP_DIR}/pch__VA_ARGS__.c.tmp ${LLVM_SRC}/llvm/tools/clang/test/PCH/pch__VA_ARGS__.h
    RUN("%clang_cc1 -emit-pch -o %t %S/pch__VA_ARGS__.h");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -include-pch ${TEST_TEMP_DIR}/pch__VA_ARGS__.c.tmp -fsyntax-only -Weverything ${LLVM_SRC}/llvm/tools/clang/test/PCH/pch__VA_ARGS__.c 2>&1 | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/PCH/pch__VA_ARGS__.c
    RUN("%clang_cc1 -include-pch %t -fsyntax-only -Weverything %s 2>&1")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_pchpch_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/PCH/pchpch.c");
    // REQUIRES: x86-registered-target
    if (!CHECK_REQUIRES("x86-registered-target")) {
      return;
    }
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i386-unknown-unknown -emit-pch -o ${TEST_TEMP_DIR}/pchpch.c.tmp1 ${LLVM_SRC}/llvm/tools/clang/test/PCH/pchpch1.h
    RUN("%clang_cc1 -triple i386-unknown-unknown -emit-pch -o %t1 %S/pchpch1.h");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i386-unknown-unknown -emit-pch -o ${TEST_TEMP_DIR}/pchpch.c.tmp2 ${LLVM_SRC}/llvm/tools/clang/test/PCH/pchpch2.h -include-pch ${TEST_TEMP_DIR}/pchpch.c.tmp1
    RUN("%clang_cc1 -triple i386-unknown-unknown -emit-pch -o %t2 %S/pchpch2.h -include-pch %t1");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i386-unknown-unknown -fsyntax-only ${LLVM_SRC}/llvm/tools/clang/test/PCH/pchpch.c -include-pch ${TEST_TEMP_DIR}/pchpch.c.tmp2
    RUN("%clang_cc1 -triple i386-unknown-unknown -fsyntax-only %s -include-pch %t2");
  }

  @Test
  public void test_pending_ids_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/PCH/pending-ids.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -include ${LLVM_SRC}/llvm/tools/clang/test/PCH/pending-ids.m ${LLVM_SRC}/llvm/tools/clang/test/PCH/pending-ids.m
    RUN("%clang_cc1 -fsyntax-only -verify -include %s %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/PCH/pending-ids.m -emit-pch -o ${TEST_TEMP_DIR}/pending-ids.m.tmp
    RUN(TestState.Failed, "%clang_cc1 %s -emit-pch -o %t");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm-only -verify ${LLVM_SRC}/llvm/tools/clang/test/PCH/pending-ids.m -include-pch ${TEST_TEMP_DIR}/pending-ids.m.tmp '-debug-info-kind=limited'
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm-only -verify %s -include-pch %t -debug-info-kind=limited");
  }

  @Test
  public void test_pr18806_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/PCH/pr18806.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc '-std=c++11' -emit-pch -o ${TEST_TEMP_DIR}/pr18806.cpp.tmp ${LLVM_SRC}/llvm/tools/clang/test/PCH/pr18806.cpp
    RUN("%clang_cc1 -std=c++11 -emit-pch -o %t %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc '-std=c++11' -include-pch ${TEST_TEMP_DIR}/pr18806.cpp.tmp -verify ${LLVM_SRC}/llvm/tools/clang/test/PCH/pr18806.cpp
    RUN("%clang_cc1 -std=c++11 -include-pch %t -verify %s");
  }

  @Test
  public void test_pr27445_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/PCH/pr27445.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-windows-msvc -fms-extensions -x c++ ${LLVM_SRC}/llvm/tools/clang/test/PCH/Inputs/pr27445.h -emit-pch -o ${TEST_TEMP_DIR}/pr27445.cpp.tmp.pch
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-windows-msvc -fms-extensions -x c++ %S/Inputs/pr27445.h -emit-pch -o %t.pch");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-windows-msvc -fms-extensions ${LLVM_SRC}/llvm/tools/clang/test/PCH/pr27445.cpp -include-pch ${TEST_TEMP_DIR}/pr27445.cpp.tmp.pch -emit-llvm -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/PCH/pr27445.cpp
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-windows-msvc -fms-extensions %s -include-pch %t.pch -emit-llvm -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_pr4489_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/PCH/pr4489.c");
    // ${LLVM_SRC}/build/bin/clang -x c-header -o ${TEST_TEMP_DIR}/pr4489.c.tmp.pch ${LLVM_SRC}/llvm/tools/clang/test/PCH/pr4489.c
    RUN(TestState.Failed, "%clang -x c-header -o %t.pch %s");
    // echo > ${TEST_TEMP_DIR}/pr4489.c.tmp.empty.c
    RUN(TestState.Failed, "echo > %t.empty.c");
    // ${LLVM_SRC}/build/bin/clang -include ${TEST_TEMP_DIR}/pr4489.c.tmp -x c ${TEST_TEMP_DIR}/pr4489.c.tmp.empty.c -emit-llvm -S -o -
    RUN(TestState.Failed, "%clang -include %t -x c %t.empty.c -emit-llvm -S -o -");
  }

  @Test
  public void test_pragma_comment_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/PCH/pragma-comment.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/PCH/pragma-comment.c -Wunknown-pragmas -Werror -triple thumbv7-windows -fms-extensions -emit-llvm -include ${LLVM_SRC}/llvm/tools/clang/test/PCH/pragma-comment.c -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/PCH/pragma-comment.c
    RUN("%clang_cc1 %s -Wunknown-pragmas -Werror -triple thumbv7-windows -fms-extensions -emit-llvm -include %s -o -")./*|*/
      I("FileCheck %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/PCH/pragma-comment.c -Wunknown-pragmas -Werror -triple x86_64-pc-win32 -fms-extensions -emit-llvm -include ${LLVM_SRC}/llvm/tools/clang/test/PCH/pragma-comment.c -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/PCH/pragma-comment.c
    RUN("%clang_cc1 %s -Wunknown-pragmas -Werror -triple x86_64-pc-win32 -fms-extensions -emit-llvm -include %s -o -")./*|*/
      I("FileCheck %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/PCH/pragma-comment.c -Wunknown-pragmas -Werror -triple thumbv7-windows -fms-extensions -emit-pch -o ${TEST_TEMP_DIR}/pragma-comment.c.tmp
    RUN("%clang_cc1 %s -Wunknown-pragmas -Werror -triple thumbv7-windows -fms-extensions -emit-pch -o %t");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/PCH/pragma-comment.c -Wunknown-pragmas -Werror -triple thumbv7-windows -fms-extensions -emit-llvm -include-pch ${TEST_TEMP_DIR}/pragma-comment.c.tmp -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/PCH/pragma-comment.c
    RUN("%clang_cc1 %s -Wunknown-pragmas -Werror -triple thumbv7-windows -fms-extensions -emit-llvm -include-pch %t -o -")./*|*/
      I("FileCheck %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/PCH/pragma-comment.c -Wunknown-pragmas -Werror -triple x86_64-pc-win32 -fms-extensions -emit-pch -o ${TEST_TEMP_DIR}/pragma-comment.c.tmp
    RUN("%clang_cc1 %s -Wunknown-pragmas -Werror -triple x86_64-pc-win32 -fms-extensions -emit-pch -o %t");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/PCH/pragma-comment.c -Wunknown-pragmas -Werror -triple x86_64-pc-win32 -fms-extensions -emit-llvm -include-pch ${TEST_TEMP_DIR}/pragma-comment.c.tmp -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/PCH/pragma-comment.c
    RUN("%clang_cc1 %s -Wunknown-pragmas -Werror -triple x86_64-pc-win32 -fms-extensions -emit-llvm -include-pch %t -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_pragma_detect_mismatch_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/PCH/pragma-detect_mismatch.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/PCH/pragma-detect_mismatch.c -Wunknown-pragmas -Werror -triple thumbv7-windows -fms-extensions -emit-llvm -include ${LLVM_SRC}/llvm/tools/clang/test/PCH/pragma-detect_mismatch.c -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/PCH/pragma-detect_mismatch.c
    RUN("%clang_cc1 %s -Wunknown-pragmas -Werror -triple thumbv7-windows -fms-extensions -emit-llvm -include %s -o -")./*|*/
      I("FileCheck %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/PCH/pragma-detect_mismatch.c -Wunknown-pragmas -Werror -triple x86_64-pc-win32 -fms-extensions -emit-llvm -include ${LLVM_SRC}/llvm/tools/clang/test/PCH/pragma-detect_mismatch.c -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/PCH/pragma-detect_mismatch.c
    RUN("%clang_cc1 %s -Wunknown-pragmas -Werror -triple x86_64-pc-win32 -fms-extensions -emit-llvm -include %s -o -")./*|*/
      I("FileCheck %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/PCH/pragma-detect_mismatch.c -Wunknown-pragmas -Werror -triple thumbv7-windows -fms-extensions -emit-pch -o ${TEST_TEMP_DIR}/pragma-detect_mismatch.c.tmp
    RUN("%clang_cc1 %s -Wunknown-pragmas -Werror -triple thumbv7-windows -fms-extensions -emit-pch -o %t");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/PCH/pragma-detect_mismatch.c -Wunknown-pragmas -Werror -triple thumbv7-windows -fms-extensions -emit-llvm -include-pch ${TEST_TEMP_DIR}/pragma-detect_mismatch.c.tmp -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/PCH/pragma-detect_mismatch.c
    RUN("%clang_cc1 %s -Wunknown-pragmas -Werror -triple thumbv7-windows -fms-extensions -emit-llvm -include-pch %t -o -")./*|*/
      I("FileCheck %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/PCH/pragma-detect_mismatch.c -Wunknown-pragmas -Werror -triple x86_64-pc-win32 -fms-extensions -emit-pch -o ${TEST_TEMP_DIR}/pragma-detect_mismatch.c.tmp
    RUN("%clang_cc1 %s -Wunknown-pragmas -Werror -triple x86_64-pc-win32 -fms-extensions -emit-pch -o %t");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/PCH/pragma-detect_mismatch.c -Wunknown-pragmas -Werror -triple x86_64-pc-win32 -fms-extensions -emit-llvm -include-pch ${TEST_TEMP_DIR}/pragma-detect_mismatch.c.tmp -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/PCH/pragma-detect_mismatch.c
    RUN("%clang_cc1 %s -Wunknown-pragmas -Werror -triple x86_64-pc-win32 -fms-extensions -emit-llvm -include-pch %t -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_pragma_diag_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/PCH/pragma-diag.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/PCH/pragma-diag.c -include ${LLVM_SRC}/llvm/tools/clang/test/PCH/pragma-diag.c -verify -fsyntax-only
    RUN("%clang_cc1 %s -include %s -verify -fsyntax-only");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/PCH/pragma-diag.c -emit-pch -o ${TEST_TEMP_DIR}/pragma-diag.c.tmp
    RUN("%clang_cc1 %s -emit-pch -o %t");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/PCH/pragma-diag.c -include-pch ${TEST_TEMP_DIR}/pragma-diag.c.tmp -verify -fsyntax-only
    RUN("%clang_cc1 %s -include-pch %t -verify -fsyntax-only");
  }

  @Test
  public void test_pragma_diag_section_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/PCH/pragma-diag-section.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/PCH/pragma-diag-section.cpp -include ${LLVM_SRC}/llvm/tools/clang/test/PCH/pragma-diag-section.cpp -verify -fsyntax-only -Wuninitialized
    RUN(TestState.Failed, "%clang_cc1 %s -include %s -verify -fsyntax-only -Wuninitialized");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/PCH/pragma-diag-section.cpp -emit-pch -o ${TEST_TEMP_DIR}/pragma-diag-section.cpp.tmp
    RUN(TestState.Failed, "%clang_cc1 %s -emit-pch -o %t");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/PCH/pragma-diag-section.cpp -include-pch ${TEST_TEMP_DIR}/pragma-diag-section.cpp.tmp -verify -fsyntax-only -Wuninitialized
    RUN(TestState.Failed, "%clang_cc1 %s -include-pch %t -verify -fsyntax-only -Wuninitialized");
  }

  @Test
  public void test_pragma_loop_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/PCH/pragma-loop.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-pch -o ${TEST_TEMP_DIR}/pragma-loop.cpp.tmp.a ${LLVM_SRC}/llvm/tools/clang/test/PCH/pragma-loop.cpp
    RUN("%clang_cc1 -emit-pch -o %t.a %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -include-pch ${TEST_TEMP_DIR}/pragma-loop.cpp.tmp.a ${LLVM_SRC}/llvm/tools/clang/test/PCH/pragma-loop.cpp -ast-print -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/PCH/pragma-loop.cpp
    RUN("%clang_cc1 -include-pch %t.a %s -ast-print -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_pragma_ms_struct_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/PCH/pragma-ms_struct.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/PCH/pragma-ms_struct.cpp -Wunknown-pragmas -Werror -triple i386-apple-darwin9 -fsyntax-only -include ${LLVM_SRC}/llvm/tools/clang/test/PCH/pragma-ms_struct.cpp -verify '-std=c++11'
    RUN("%clang_cc1 %s -Wunknown-pragmas -Werror -triple i386-apple-darwin9 -fsyntax-only -include %s -verify -std=c++11");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/PCH/pragma-ms_struct.cpp -Wunknown-pragmas -Werror -triple i386-apple-darwin9 -emit-pch -o ${TEST_TEMP_DIR}/pragma-ms_struct.cpp.tmp '-std=c++11'
    RUN("%clang_cc1 %s -Wunknown-pragmas -Werror -triple i386-apple-darwin9 -emit-pch -o %t -std=c++11");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/PCH/pragma-ms_struct.cpp -Wunknown-pragmas -Werror -triple i386-apple-darwin9 -fsyntax-only -include-pch ${TEST_TEMP_DIR}/pragma-ms_struct.cpp.tmp -verify '-std=c++11'
    RUN("%clang_cc1 %s -Wunknown-pragmas -Werror -triple i386-apple-darwin9 -fsyntax-only -include-pch %t -verify -std=c++11");
  }

  @Test
  public void test_pragma_once_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/PCH/pragma-once.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -include ${LLVM_SRC}/llvm/tools/clang/test/PCH/Inputs/pragma-once.h -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/PCH/pragma-once.c
    RUN("%clang_cc1 -include %S/Inputs/pragma-once.h -fsyntax-only -verify %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-pch -o ${TEST_TEMP_DIR}/pragma-once.c.tmp ${LLVM_SRC}/llvm/tools/clang/test/PCH/Inputs/pragma-once.h
    RUN("%clang_cc1 -emit-pch -o %t %S/Inputs/pragma-once.h");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -include-pch ${TEST_TEMP_DIR}/pragma-once.c.tmp -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/PCH/pragma-once.c
    RUN("%clang_cc1 -include-pch %t -fsyntax-only -verify %s");
  }

  @Test
  public void test_pragma_optimize_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/PCH/pragma-optimize.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/PCH/pragma-optimize.c -include ${LLVM_SRC}/llvm/tools/clang/test/PCH/pragma-optimize.c -verify -fsyntax-only
    RUN("%clang_cc1 %s -include %s -verify -fsyntax-only");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/PCH/pragma-optimize.c -emit-pch -o ${TEST_TEMP_DIR}/pragma-optimize.c.tmp
    RUN( "%clang_cc1 %s -emit-pch -o %t");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/PCH/pragma-optimize.c -emit-llvm -include-pch ${TEST_TEMP_DIR}/pragma-optimize.c.tmp -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/PCH/pragma-optimize.c
    RUN( "%clang_cc1 %s -emit-llvm -include-pch %t -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_pragma_pointers_to_members_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/PCH/pragma-pointers_to_members.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/PCH/pragma-pointers_to_members.cpp -Wunknown-pragmas -Werror -triple i386-pc-win32 -fms-extensions -fsyntax-only -include ${LLVM_SRC}/llvm/tools/clang/test/PCH/pragma-pointers_to_members.cpp -verify '-std=c++11'
    RUN("%clang_cc1 %s -Wunknown-pragmas -Werror -triple i386-pc-win32 -fms-extensions -fsyntax-only -include %s -verify -std=c++11");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/PCH/pragma-pointers_to_members.cpp -Wunknown-pragmas -Werror -triple i386-pc-win32 -fms-extensions -emit-pch -o ${TEST_TEMP_DIR}/pragma-pointers_to_members.cpp.tmp '-std=c++11'
    RUN("%clang_cc1 %s -Wunknown-pragmas -Werror -triple i386-pc-win32  -fms-extensions -emit-pch -o %t -std=c++11");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/PCH/pragma-pointers_to_members.cpp -Wunknown-pragmas -Werror -triple i386-pc-win32 -fms-extensions -fsyntax-only -include-pch ${TEST_TEMP_DIR}/pragma-pointers_to_members.cpp.tmp -verify '-std=c++11'
    RUN("%clang_cc1 %s -Wunknown-pragmas -Werror -triple i386-pc-win32  -fms-extensions -fsyntax-only -include-pch %t -verify -std=c++11");
  }

  @Test
  public void test_pragma_weak_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/PCH/pragma-weak.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -include ${LLVM_SRC}/llvm/tools/clang/test/PCH/pragma-weak.h ${LLVM_SRC}/llvm/tools/clang/test/PCH/pragma-weak.c -verify -emit-llvm -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/PCH/pragma-weak.c
    RUN("not %clang_cc1 -include %S/pragma-weak.h %s -verify -emit-llvm -o -")./*|*/
      I("FileCheck %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x c-header -emit-pch -o ${TEST_TEMP_DIR}/pragma-weak.c.tmp ${LLVM_SRC}/llvm/tools/clang/test/PCH/pragma-weak.h
    RUN("%clang_cc1 -x c-header -emit-pch -o %t %S/pragma-weak.h");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -include-pch ${TEST_TEMP_DIR}/pragma-weak.c.tmp ${LLVM_SRC}/llvm/tools/clang/test/PCH/pragma-weak.c -verify -emit-llvm -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/PCH/pragma-weak.c
    RUN("not %clang_cc1 -include-pch %t %s -verify -emit-llvm -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_preamble_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/PCH/preamble.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-pch -o ${TEST_TEMP_DIR}/preamble.c.tmp ${LLVM_SRC}/llvm/tools/clang/test/PCH/Inputs/preamble.h '-DFOO=f'
    RUN(TestState.Failed, "%clang_cc1 -emit-pch -o %t %S/Inputs/preamble.h -DFOO=f");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -include-pch ${TEST_TEMP_DIR}/preamble.c.tmp '-preamble-bytes=317,1' '-DFOO=f' -verify ${LLVM_SRC}/llvm/tools/clang/test/PCH/preamble.c -emit-llvm -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/PCH/preamble.c
    RUN(TestState.Failed, "not %clang_cc1 -include-pch %t -preamble-bytes=317,1 -DFOO=f -verify %s -emit-llvm -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_pth_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/PCH/pth.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i386-unknown-unknown -emit-pth -o ${TEST_TEMP_DIR}/pth.c.tmp ${LLVM_SRC}/llvm/tools/clang/test/PCH/pth.h
    RUN("%clang_cc1 -triple i386-unknown-unknown -emit-pth -o %t %S/pth.h");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i386-unknown-unknown -include-pth ${TEST_TEMP_DIR}/pth.c.tmp -fsyntax-only ${LLVM_SRC}/llvm/tools/clang/test/PCH/pth.c 2>&1 | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/PCH/pth.c
    RUN("not %clang_cc1 -triple i386-unknown-unknown -include-pth %t -fsyntax-only %s 2>&1")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_rdar10830559_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/PCH/rdar10830559.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -emit-llvm-only ${LLVM_SRC}/llvm/tools/clang/test/PCH/rdar10830559.cpp
    RUN("%clang_cc1 -fsyntax-only -emit-llvm-only %s");
    // touch ${TEST_TEMP_DIR}/rdar10830559.cpp.tmp.empty.cpp
    RUN("touch %t.empty.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-pch -o ${TEST_TEMP_DIR}/rdar10830559.cpp.tmp ${LLVM_SRC}/llvm/tools/clang/test/PCH/rdar10830559.cpp
    RUN("%clang_cc1 -emit-pch -o %t %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -include-pch ${TEST_TEMP_DIR}/rdar10830559.cpp.tmp -emit-llvm-only ${TEST_TEMP_DIR}/rdar10830559.cpp.tmp.empty.cpp
    RUN("%clang_cc1 -include-pch %t -emit-llvm-only %t.empty.cpp");
  }

  @Test
  public void test_rdar8852495_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/PCH/rdar8852495.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/PCH/rdar8852495.c -include ${LLVM_SRC}/llvm/tools/clang/test/PCH/rdar8852495.c -verify -fsyntax-only -Wno-sign-compare -Wtautological-compare
    RUN("%clang_cc1 %s -include %s -verify -fsyntax-only -Wno-sign-compare -Wtautological-compare");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/PCH/rdar8852495.c -emit-pch -o ${TEST_TEMP_DIR}/rdar8852495.c.tmp -Wsign-compare -Wtautological-compare
    RUN("%clang_cc1 %s -emit-pch -o %t -Wsign-compare -Wtautological-compare");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/PCH/rdar8852495.c -include-pch ${TEST_TEMP_DIR}/rdar8852495.c.tmp -verify -fsyntax-only -Wno-sign-compare -Wtautological-compare
    RUN("%clang_cc1 %s -include-pch %t -verify -fsyntax-only -Wno-sign-compare -Wtautological-compare");
  }

  @Test
  public void test_reinclude_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/PCH/reinclude.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/PCH/reinclude.cpp -include ${LLVM_SRC}/llvm/tools/clang/test/PCH/reinclude1.h -include ${LLVM_SRC}/llvm/tools/clang/test/PCH/reinclude2.h -fsyntax-only -verify
    RUN("%clang_cc1 %s -include %S/reinclude1.h -include %S/reinclude2.h -fsyntax-only -verify");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x c++-header ${LLVM_SRC}/llvm/tools/clang/test/PCH/reinclude1.h -emit-pch -o ${TEST_TEMP_DIR}/reinclude.cpp.tmp1
    RUN("%clang_cc1 -x c++-header %S/reinclude1.h -emit-pch -o %t1");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x c++-header ${LLVM_SRC}/llvm/tools/clang/test/PCH/reinclude2.h -include-pch ${TEST_TEMP_DIR}/reinclude.cpp.tmp1 -emit-pch -o ${TEST_TEMP_DIR}/reinclude.cpp.tmp2
    RUN("%clang_cc1 -x c++-header %S/reinclude2.h -include-pch %t1 -emit-pch -o %t2");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/PCH/reinclude.cpp -include-pch ${TEST_TEMP_DIR}/reinclude.cpp.tmp2 -fsyntax-only -verify
    RUN("%clang_cc1 %s -include-pch %t2 -fsyntax-only -verify");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x c++-header ${LLVM_SRC}/llvm/tools/clang/test/PCH/reinclude2.h -include-pch ${TEST_TEMP_DIR}/reinclude.cpp.tmp1 -emit-pch -o ${TEST_TEMP_DIR}/reinclude.cpp.tmp2
    RUN("%clang_cc1 -x c++-header %S/reinclude2.h -include-pch %t1 -emit-pch -o %t2");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/PCH/reinclude.cpp -include-pch ${TEST_TEMP_DIR}/reinclude.cpp.tmp2 -fsyntax-only -verify
    RUN("%clang_cc1 %s -include-pch %t2 -fsyntax-only -verify");
  }

  @Test
  public void test_reloc_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/PCH/reloc.c");
    // REQUIRES: x86-registered-target
    if (!CHECK_REQUIRES("x86-registered-target")) {
      return;
    }
    // ${LLVM_SRC}/build/bin/clang -target x86_64-apple-darwin10 --relocatable-pch -o ${TEST_TEMP_DIR}/reloc.c.tmp -isysroot ${LLVM_SRC}/llvm/tools/clang/test/PCH/Inputs/libroot ${LLVM_SRC}/llvm/tools/clang/test/PCH/Inputs/libroot/usr/include/reloc.h
    RUN("%clang -target x86_64-apple-darwin10 --relocatable-pch -o %t -isysroot %S/Inputs/libroot %S/Inputs/libroot/usr/include/reloc.h");
    // ${LLVM_SRC}/build/bin/clang -target x86_64-apple-darwin10 -fsyntax-only -include-pch ${TEST_TEMP_DIR}/reloc.c.tmp -isysroot ${LLVM_SRC}/llvm/tools/clang/test/PCH/Inputs/libroot ${LLVM_SRC}/llvm/tools/clang/test/PCH/reloc.c -Xclang -verify
    RUN("%clang -target x86_64-apple-darwin10 -fsyntax-only -include-pch %t -isysroot %S/Inputs/libroot %s -Xclang -verify");
    // ${LLVM_SRC}/build/bin/clang -target x86_64-apple-darwin10 -include-pch ${TEST_TEMP_DIR}/reloc.c.tmp ${LLVM_SRC}/llvm/tools/clang/test/PCH/reloc.c
    RUN("not %clang -target x86_64-apple-darwin10 -include-pch %t %s");
  }

  @Test
  public void test_remap_file_from_pch_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/PCH/remap-file-from-pch.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x c++-header ${LLVM_SRC}/llvm/tools/clang/test/PCH/remap-file-from-pch.cpp.h -emit-pch -o ${TEST_TEMP_DIR}/remap-file-from-pch.cpp.tmp.pch
    RUN("%clang_cc1 -x c++-header %s.h -emit-pch -o %t.pch");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/PCH/remap-file-from-pch.cpp -include-pch ${TEST_TEMP_DIR}/remap-file-from-pch.cpp.tmp.pch -remap-file ${LLVM_SRC}/llvm/tools/clang/test/PCH/remap-file-from-pch.cpp.h;${LLVM_SRC}/llvm/tools/clang/test/PCH/remap-file-from-pch.cpp.remap.h -fsyntax-only 2>&1 | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/PCH/remap-file-from-pch.cpp
    RUN("not %clang_cc1 %s -include-pch %t.pch -remap-file \"%s.h;%s.remap.h\" -fsyntax-only 2>&1")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_replaced_decl_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/PCH/replaced-decl.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/PCH/replaced-decl.m -include ${LLVM_SRC}/llvm/tools/clang/test/PCH/replaced-decl.m -include ${LLVM_SRC}/llvm/tools/clang/test/PCH/replaced-decl.m
    RUN("%clang_cc1 -fsyntax-only -verify %s -include %s -include %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/PCH/replaced-decl.m -chain-include ${LLVM_SRC}/llvm/tools/clang/test/PCH/replaced-decl.m -chain-include ${LLVM_SRC}/llvm/tools/clang/test/PCH/replaced-decl.m
    RUN("%clang_cc1 -fsyntax-only -verify %s -chain-include %s -chain-include %s");
  }

  @Test
  public void test_selector_warning_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/PCH/selector-warning.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x objective-c -emit-pch -o ${TEST_TEMP_DIR}/selector-warning.m.tmp.h.pch ${LLVM_SRC}/llvm/tools/clang/test/PCH/selector-warning.h
    RUN("%clang_cc1 -x objective-c -emit-pch -o %t.h.pch %S/selector-warning.h");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -include-pch ${TEST_TEMP_DIR}/selector-warning.m.tmp.h.pch ${LLVM_SRC}/llvm/tools/clang/test/PCH/selector-warning.m
    RUN("%clang_cc1 -include-pch %t.h.pch %s");
  }

  @Test
  public void test_single_token_macro_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/PCH/single-token-macro.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/PCH/single-token-macro.c -include ${LLVM_SRC}/llvm/tools/clang/test/PCH/single-token-macro.c -verify -fsyntax-only
    RUN("%clang_cc1 %s -include %s -verify -fsyntax-only");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/PCH/single-token-macro.c -emit-pch -o ${TEST_TEMP_DIR}/single-token-macro.c.tmp
    RUN("%clang_cc1 %s -emit-pch -o %t");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/PCH/single-token-macro.c -include-pch ${TEST_TEMP_DIR}/single-token-macro.c.tmp -verify -fsyntax-only
    RUN("%clang_cc1 %s -include-pch %t -verify -fsyntax-only");
  }

  @Test
  public void test_source_manager_stack_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/PCH/source-manager-stack.c");
    // echo 'int x;' > ${TEST_TEMP_DIR}/source-manager-stack.c.tmp.prefix.h
    RUN(TestState.Failed, "echo 'int x;' > %t.prefix.h");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -fdiagnostics-show-note-include-stack -include ${TEST_TEMP_DIR}/source-manager-stack.c.tmp.prefix.h ${LLVM_SRC}/llvm/tools/clang/test/PCH/source-manager-stack.c 2> ${TEST_TEMP_DIR}/source-manager-stack.c.tmp.diags.no_pch.txt
    RUN(TestState.Failed, "not %clang_cc1 -fsyntax-only -fdiagnostics-show-note-include-stack -include %t.prefix.h %s 2> %t.diags.no_pch.txt");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-pch -o ${TEST_TEMP_DIR}/source-manager-stack.c.tmp.prefix.pch ${TEST_TEMP_DIR}/source-manager-stack.c.tmp.prefix.h
    RUN(TestState.Failed, "%clang_cc1 -emit-pch -o %t.prefix.pch %t.prefix.h");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -fdiagnostics-show-note-include-stack -include-pch ${TEST_TEMP_DIR}/source-manager-stack.c.tmp.prefix.pch ${LLVM_SRC}/llvm/tools/clang/test/PCH/source-manager-stack.c 2> ${TEST_TEMP_DIR}/source-manager-stack.c.tmp.diags.pch.txt
    RUN(TestState.Failed, "not %clang_cc1 -fsyntax-only -fdiagnostics-show-note-include-stack -include-pch %t.prefix.pch %s 2> %t.diags.pch.txt");
    // diff ${TEST_TEMP_DIR}/source-manager-stack.c.tmp.diags.no_pch.txt ${TEST_TEMP_DIR}/source-manager-stack.c.tmp.diags.pch.txt
    RUN(TestState.Failed, "diff %t.diags.no_pch.txt %t.diags.pch.txt");
  }

  @Test
  public void test_stmt_attrs_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/PCH/stmt-attrs.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc '-std=c++11' -emit-pch -o ${TEST_TEMP_DIR}/stmt-attrs.cpp.tmp.a ${LLVM_SRC}/llvm/tools/clang/test/PCH/stmt-attrs.cpp
    RUN("%clang_cc1 -std=c++11 -emit-pch -o %t.a %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc '-std=c++11' -include-pch ${TEST_TEMP_DIR}/stmt-attrs.cpp.tmp.a ${LLVM_SRC}/llvm/tools/clang/test/PCH/stmt-attrs.cpp -ast-print -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/PCH/stmt-attrs.cpp
    RUN("%clang_cc1 -std=c++11 -include-pch %t.a %s -ast-print -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_stmts_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/PCH/stmts.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -include ${LLVM_SRC}/llvm/tools/clang/test/PCH/stmts.h -fsyntax-only -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/PCH/stmts.c
    RUN(TestState.Failed, "%clang_cc1 -include %S/stmts.h -fsyntax-only -emit-llvm -o - %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-pch -o ${TEST_TEMP_DIR}/stmts.c.tmp ${LLVM_SRC}/llvm/tools/clang/test/PCH/stmts.h
    RUN(TestState.Failed, "%clang_cc1 -emit-pch -o %t %S/stmts.h");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -include-pch ${TEST_TEMP_DIR}/stmts.c.tmp -fsyntax-only -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/PCH/stmts.c
    RUN(TestState.Failed, "%clang_cc1 -include-pch %t -fsyntax-only -emit-llvm -o - %s");
  }

  @Test
  public void test_struct_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/PCH/struct.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -include ${LLVM_SRC}/llvm/tools/clang/test/PCH/struct.h -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/PCH/struct.c
    RUN("%clang_cc1 -include %S/struct.h -fsyntax-only -verify %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-pch -o ${TEST_TEMP_DIR}/struct.c.tmp ${LLVM_SRC}/llvm/tools/clang/test/PCH/struct.h
    RUN("%clang_cc1 -emit-pch -o %t %S/struct.h");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -include-pch ${TEST_TEMP_DIR}/struct.c.tmp -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/PCH/struct.c
    RUN("%clang_cc1 -include-pch %t -fsyntax-only -verify %s");
  }

  @Test
  public void test_subscripting_literals_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/PCH/subscripting-literals.m");
    // REQUIRES: x86-registered-target
    if (!CHECK_REQUIRES("x86-registered-target")) {
      return;
    }
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-apple-darwin -emit-llvm -o ${TEST_TEMP_DIR}/subscripting-literals.m.tmp.nopch.ll ${LLVM_SRC}/llvm/tools/clang/test/PCH/subscripting-literals.m
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-apple-darwin -emit-llvm -o %t.nopch.ll %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-apple-darwin -emit-pch -o ${TEST_TEMP_DIR}/subscripting-literals.m.tmp.pch ${LLVM_SRC}/llvm/tools/clang/test/PCH/subscripting-literals.m
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-apple-darwin -emit-pch -o %t.pch %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-apple-darwin -emit-llvm -o ${TEST_TEMP_DIR}/subscripting-literals.m.tmp.pch.ll ${LLVM_SRC}/llvm/tools/clang/test/PCH/subscripting-literals.m -include-pch ${TEST_TEMP_DIR}/subscripting-literals.m.tmp.pch
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-apple-darwin -emit-llvm -o %t.pch.ll %s -include-pch %t.pch");
    // diff ${TEST_TEMP_DIR}/subscripting-literals.m.tmp.nopch.ll ${TEST_TEMP_DIR}/subscripting-literals.m.tmp.pch.ll
    RUN(TestState.Failed, "diff %t.nopch.ll %t.pch.ll");
  }

  @Test
  public void test_target_options_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/PCH/target-options.c");
    // REQUIRES: x86-registered-target
    if (!CHECK_REQUIRES("x86-registered-target")) {
      return;
    }
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc '-triple=x86_64-apple-darwin9' -emit-pch -o ${TEST_TEMP_DIR}/target-options.c.tmp.pch ${LLVM_SRC}/llvm/tools/clang/test/PCH/target-options.h
    RUN("%clang_cc1 -triple=x86_64-apple-darwin9 -emit-pch -o %t.pch %S/target-options.h");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc '-triple=x86_64-unknown-freebsd7.0' -include-pch ${TEST_TEMP_DIR}/target-options.c.tmp.pch ${LLVM_SRC}/llvm/tools/clang/test/PCH/target-options.c -emit-llvm -o - > ${TEST_TEMP_DIR}/target-options.c.tmp.err 2>&1
    RUN("not %clang_cc1 -triple=x86_64-unknown-freebsd7.0 -include-pch %t.pch %s -emit-llvm -o - > %t.err 2>&1");
    // ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/PCH/target-options.c < ${TEST_TEMP_DIR}/target-options.c.tmp.err
    RUN("FileCheck %s < %t.err");
  }

  @Test
  public void test_tentative_defs_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/PCH/tentative-defs.c");
    // REQUIRES: x86-registered-target
    if (!CHECK_REQUIRES("x86-registered-target")) {
      return;
    }
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-apple-darwin9 -emit-pch -o ${TEST_TEMP_DIR}/tentative-defs.c.tmp.pch ${LLVM_SRC}/llvm/tools/clang/test/PCH/tentative-defs.h
    RUN("%clang_cc1 -triple x86_64-apple-darwin9 -emit-pch -o %t.pch %S/tentative-defs.h");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-apple-darwin9 -include-pch ${TEST_TEMP_DIR}/tentative-defs.c.tmp.pch -verify -emit-llvm -o ${TEST_TEMP_DIR}/tentative-defs.c.tmp ${LLVM_SRC}/llvm/tools/clang/test/PCH/tentative-defs.c
    RUN("%clang_cc1 -triple x86_64-apple-darwin9 -include-pch %t.pch -verify -emit-llvm -o %t %s");
    // grep '@variable = common global i32 0' ${TEST_TEMP_DIR}/tentative-defs.c.tmp | ${LLVM_SRC}/build/bin/count 1
    RUN("grep \"@variable = common global i32 0\" %t")./*|*/
      I("count 1");
    // grep '@incomplete_array = common global .*1 x i32' ${TEST_TEMP_DIR}/tentative-defs.c.tmp | ${LLVM_SRC}/build/bin/count 1
    RUN("grep \"@incomplete_array = common global .*1 x i32\" %t")./*|*/
      I("count 1");
  }

  @Test
  public void test_thread_local_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/PCH/thread-local.cpp");
    // REQUIRES: x86-registered-target
    if (!CHECK_REQUIRES("x86-registered-target")) {
      return;
    }
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -pedantic-errors '-std=c++11' -triple x86_64-linux-gnu -emit-pch ${LLVM_SRC}/llvm/tools/clang/test/PCH/thread-local.cpp -o ${TEST_TEMP_DIR}/thread-local.cpp.tmp
    RUN("%clang_cc1 -pedantic-errors -std=c++11 -triple x86_64-linux-gnu -emit-pch %s -o %t");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -pedantic-errors '-std=c++11' -triple x86_64-linux-gnu -include-pch ${TEST_TEMP_DIR}/thread-local.cpp.tmp -verify ${LLVM_SRC}/llvm/tools/clang/test/PCH/thread-local.cpp
    RUN("%clang_cc1 -pedantic-errors -std=c++11 -triple x86_64-linux-gnu -include-pch %t -verify %s");
  }

  @Test
  public void test_thread_safety_attrs_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/PCH/thread-safety-attrs.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -include ${LLVM_SRC}/llvm/tools/clang/test/PCH/thread-safety-attrs.cpp -fsyntax-only -verify -Wthread-safety '-std=c++11' ${LLVM_SRC}/llvm/tools/clang/test/PCH/thread-safety-attrs.cpp
    RUN("%clang_cc1 -include %s -fsyntax-only -verify -Wthread-safety -std=c++11 %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-pch -o ${TEST_TEMP_DIR}/thread-safety-attrs.cpp.tmp ${LLVM_SRC}/llvm/tools/clang/test/PCH/thread-safety-attrs.cpp '-std=c++11'
    RUN("%clang_cc1 -emit-pch -o %t %s -std=c++11");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -include-pch ${TEST_TEMP_DIR}/thread-safety-attrs.cpp.tmp -fsyntax-only -verify -Wthread-safety '-std=c++11' ${LLVM_SRC}/llvm/tools/clang/test/PCH/thread-safety-attrs.cpp
    RUN("%clang_cc1 -include-pch %t -fsyntax-only -verify -Wthread-safety -std=c++11 %s");
  }

  @Test
  public void test_type_pack_element_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/PCH/type_pack_element.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc '-std=c++14' -x c++-header ${LLVM_SRC}/llvm/tools/clang/test/PCH/type_pack_element.cpp -emit-pch -o ${TEST_TEMP_DIR}/type_pack_element.cpp.tmp.pch
    RUN("%clang_cc1 -std=c++14 -x c++-header %s -emit-pch -o %t.pch");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc '-std=c++14' -x c++ /dev/null -include-pch ${TEST_TEMP_DIR}/type_pack_element.cpp.tmp.pch
    RUN("%clang_cc1 -std=c++14 -x c++ /dev/null -include-pch %t.pch");
  }

  @Test
  public void test_types_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/PCH/types.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fblocks -include ${LLVM_SRC}/llvm/tools/clang/test/PCH/types.h -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/PCH/types.c
    RUN("%clang_cc1 -fblocks -include %S/types.h -fsyntax-only -verify %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-pch -fblocks -o ${TEST_TEMP_DIR}/types.c.tmp ${LLVM_SRC}/llvm/tools/clang/test/PCH/types.h
    RUN("%clang_cc1 -emit-pch -fblocks -o %t %S/types.h");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fblocks -include-pch ${TEST_TEMP_DIR}/types.c.tmp -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/PCH/types.c -ast-print
    RUN("%clang_cc1 -fblocks -include-pch %t -fsyntax-only -verify %s -ast-print");
  }

  @Test
  public void test_typo_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/PCH/typo.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -include ${LLVM_SRC}/llvm/tools/clang/test/PCH/Inputs/typo.hpp -verify ${LLVM_SRC}/llvm/tools/clang/test/PCH/typo.cpp
    RUN("%clang_cc1 -include %S/Inputs/typo.hpp -verify %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x c++-header -emit-pch -o ${TEST_TEMP_DIR}/typo.cpp.tmp ${LLVM_SRC}/llvm/tools/clang/test/PCH/Inputs/typo.hpp
    RUN("%clang_cc1 -x c++-header -emit-pch -o %t %S/Inputs/typo.hpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -include-pch ${TEST_TEMP_DIR}/typo.cpp.tmp -verify ${LLVM_SRC}/llvm/tools/clang/test/PCH/typo.cpp
    RUN("%clang_cc1 -include-pch %t -verify %s");
  }

  @Test
  public void test_typo_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/PCH/typo.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x objective-c-header -emit-pch -o ${TEST_TEMP_DIR}/typo.m.tmp ${LLVM_SRC}/llvm/tools/clang/test/PCH/Inputs/typo.h
    RUN(TestState.Failed, "%clang_cc1 -x objective-c-header -emit-pch -o %t %S/Inputs/typo.h");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -include-pch ${TEST_TEMP_DIR}/typo.m.tmp -verify ${LLVM_SRC}/llvm/tools/clang/test/PCH/typo.m
    RUN(TestState.Failed, "%clang_cc1 -include-pch %t -verify %s");
  }

  @Test
  public void test_typo2_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/PCH/typo2.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-pch ${LLVM_SRC}/llvm/tools/clang/test/PCH/typo2.cpp -o ${TEST_TEMP_DIR}/typo2.cpp.tmp.pch
    RUN("%clang_cc1 -emit-pch %s -o %t.pch");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -include-pch ${TEST_TEMP_DIR}/typo2.cpp.tmp.pch ${LLVM_SRC}/llvm/tools/clang/test/PCH/typo2.cpp -verify
    RUN("%clang_cc1 -include-pch %t.pch %s -verify");
  }

  @Test
  public void test_undefined_internal_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/PCH/undefined-internal.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-pch ${LLVM_SRC}/llvm/tools/clang/test/PCH/undefined-internal.c -o ${TEST_TEMP_DIR}/undefined-internal.c.tmp
    RUN("%clang_cc1 -emit-pch %s -o %t");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -include-pch ${TEST_TEMP_DIR}/undefined-internal.c.tmp ${LLVM_SRC}/llvm/tools/clang/test/PCH/undefined-internal.c -verify
    RUN("%clang_cc1 -include-pch %t %s -verify");
  }

  @Test
  public void test_uuidof_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/PCH/uuidof.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fms-extensions -x c++-header -emit-pch -o ${TEST_TEMP_DIR}/uuidof.cpp.tmp ${LLVM_SRC}/llvm/tools/clang/test/PCH/uuidof.cpp
    RUN( "%clang_cc1 -fms-extensions -x c++-header -emit-pch -o %t %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fms-extensions -include-pch ${TEST_TEMP_DIR}/uuidof.cpp.tmp -fsyntax-only ${LLVM_SRC}/llvm/tools/clang/test/PCH/uuidof.cpp -emit-llvm -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/PCH/uuidof.cpp
    RUN( "%clang_cc1 -fms-extensions -include-pch %t -fsyntax-only %s -emit-llvm -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_va_arg_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/PCH/va_arg.c");
    // REQUIRES: x86-registered-target
    if (!CHECK_REQUIRES("x86-registered-target")) {
      return;
    }
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc '-triple=x86_64-unknown-freebsd7.0' -include ${LLVM_SRC}/llvm/tools/clang/test/PCH/va_arg.h ${LLVM_SRC}/llvm/tools/clang/test/PCH/va_arg.c -emit-llvm -o -
    RUN(TestState.Failed, "%clang_cc1 -triple=x86_64-unknown-freebsd7.0 -include %S/va_arg.h %s -emit-llvm -o -");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc '-triple=x86_64-unknown-freebsd7.0' -emit-pch -o ${TEST_TEMP_DIR}/va_arg.c.tmp ${LLVM_SRC}/llvm/tools/clang/test/PCH/va_arg.h
    RUN(TestState.Failed, "%clang_cc1 -triple=x86_64-unknown-freebsd7.0 -emit-pch -o %t %S/va_arg.h");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc '-triple=x86_64-unknown-freebsd7.0' -include-pch ${TEST_TEMP_DIR}/va_arg.c.tmp ${LLVM_SRC}/llvm/tools/clang/test/PCH/va_arg.c -emit-llvm -o -
    RUN(TestState.Failed, "%clang_cc1 -triple=x86_64-unknown-freebsd7.0 -include-pch %t %s -emit-llvm -o -");
  }

  @Test
  public void test_va_arg_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/PCH/va_arg.cpp");
    // REQUIRES: x86-registered-target
    if (!CHECK_REQUIRES("x86-registered-target")) {
      return;
    }
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc '-triple=x86_64-unknown-freebsd7.0' -include ${LLVM_SRC}/llvm/tools/clang/test/PCH/Inputs/va_arg.h ${LLVM_SRC}/llvm/tools/clang/test/PCH/va_arg.cpp -emit-llvm -o -
    RUN(TestState.Failed, "%clang_cc1 -triple=x86_64-unknown-freebsd7.0 -include %S/Inputs/va_arg.h %s -emit-llvm -o -");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc '-triple=x86_64-unknown-freebsd7.0' -emit-pch -x c++-header -o ${TEST_TEMP_DIR}/va_arg.cpp.tmp ${LLVM_SRC}/llvm/tools/clang/test/PCH/Inputs/va_arg.h
    RUN(TestState.Failed, "%clang_cc1 -triple=x86_64-unknown-freebsd7.0 -emit-pch -x c++-header -o %t %S/Inputs/va_arg.h");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc '-triple=x86_64-unknown-freebsd7.0' -include-pch ${TEST_TEMP_DIR}/va_arg.cpp.tmp ${LLVM_SRC}/llvm/tools/clang/test/PCH/va_arg.cpp -emit-llvm -o -
    RUN(TestState.Failed, "%clang_cc1 -triple=x86_64-unknown-freebsd7.0 -include-pch %t %s -emit-llvm -o -");
  }

  @Test
  public void test_variables_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/PCH/variables.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -include ${LLVM_SRC}/llvm/tools/clang/test/PCH/variables.c -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/PCH/variables.c
    RUN("%clang_cc1 -include %s -fsyntax-only -verify %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-pch -o ${TEST_TEMP_DIR}/variables.c.tmp ${LLVM_SRC}/llvm/tools/clang/test/PCH/variables.c
    RUN("%clang_cc1 -emit-pch -o %t %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -include-pch ${TEST_TEMP_DIR}/variables.c.tmp -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/PCH/variables.c
    RUN("%clang_cc1 -include-pch %t -fsyntax-only -verify %s");
  }

  @Test
  public void test_variables_h() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/PCH/variables.h");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-pch -o variables.h.pch variables.h
    RUN(TestState.Failed, "%clang_cc1 -emit-pch -o variables.h.pch variables.h");
  }

  @Test
  public void test_verify_pch_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/PCH/verify_pch.m");
    // rm -rf ${TEST_TEMP_DIR}/verify_pch.m.tmp
    RUN("rm -rf %t");
    // mkdir -p ${TEST_TEMP_DIR}/verify_pch.m.tmp/usr/include
    RUN("mkdir -p %t/usr/include");
    // echo '// empty' > ${TEST_TEMP_DIR}/verify_pch.m.tmp/usr/include/sys_header.h
    RUN("echo '// empty' > %t/usr/include/sys_header.h");
    // cp ${LLVM_SRC}/llvm/tools/clang/test/PCH/verify_pch.m ${TEST_TEMP_DIR}/verify_pch.m.tmp.h
    RUN("cp %s %t.h");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -isystem ${TEST_TEMP_DIR}/verify_pch.m.tmp/usr/include -x objective-c-header -emit-pch -o ${TEST_TEMP_DIR}/verify_pch.m.tmp.pch ${TEST_TEMP_DIR}/verify_pch.m.tmp.h
    RUN("%clang_cc1 -isystem %t/usr/include -x objective-c-header -emit-pch -o %t.pch %t.h");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -isystem ${TEST_TEMP_DIR}/verify_pch.m.tmp/usr/include -verify-pch ${TEST_TEMP_DIR}/verify_pch.m.tmp.pch
    RUN("%clang_cc1 -isystem %t/usr/include -verify-pch %t.pch");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -isystem ${TEST_TEMP_DIR}/verify_pch.m.tmp/usr/include -x objective-c -fno-builtin -verify-pch ${TEST_TEMP_DIR}/verify_pch.m.tmp.pch
    RUN("%clang_cc1 -isystem %t/usr/include -x objective-c -fno-builtin -verify-pch %t.pch");
    // echo ' ' >> ${TEST_TEMP_DIR}/verify_pch.m.tmp.h
    RUN("echo ' ' >> %t.h");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -isystem ${TEST_TEMP_DIR}/verify_pch.m.tmp/usr/include -verify-pch ${TEST_TEMP_DIR}/verify_pch.m.tmp.pch 2> ${TEST_TEMP_DIR}/verify_pch.m.tmp.log.2
    RUN("not %clang_cc1 -isystem %t/usr/include -verify-pch %t.pch 2> %t.log.2");
    // ${LLVM_SRC}/build/bin/FileCheck '-check-prefix=CHECK-STALE-DEP' ${LLVM_SRC}/llvm/tools/clang/test/PCH/verify_pch.m < ${TEST_TEMP_DIR}/verify_pch.m.tmp.log.2
    RUN("FileCheck -check-prefix=CHECK-STALE-DEP %s < %t.log.2");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -isystem ${TEST_TEMP_DIR}/verify_pch.m.tmp/usr/include -x objective-c-header -emit-pch -o ${TEST_TEMP_DIR}/verify_pch.m.tmp.pch ${TEST_TEMP_DIR}/verify_pch.m.tmp.h
    RUN("%clang_cc1 -isystem %t/usr/include -x objective-c-header -emit-pch -o %t.pch %t.h");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -isystem ${TEST_TEMP_DIR}/verify_pch.m.tmp/usr/include -verify-pch ${TEST_TEMP_DIR}/verify_pch.m.tmp.pch
    RUN("%clang_cc1 -isystem %t/usr/include -verify-pch %t.pch");
    // echo ' ' >> ${TEST_TEMP_DIR}/verify_pch.m.tmp/usr/include/sys_header.h
    RUN("echo ' ' >> %t/usr/include/sys_header.h");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -isystem ${TEST_TEMP_DIR}/verify_pch.m.tmp/usr/include -verify-pch ${TEST_TEMP_DIR}/verify_pch.m.tmp.pch 2> ${TEST_TEMP_DIR}/verify_pch.m.tmp.log.3
    RUN("not %clang_cc1 -isystem %t/usr/include -verify-pch %t.pch 2> %t.log.3");
    // ${LLVM_SRC}/build/bin/FileCheck '-check-prefix=CHECK-STALE-SYS-H' ${LLVM_SRC}/llvm/tools/clang/test/PCH/verify_pch.m < ${TEST_TEMP_DIR}/verify_pch.m.tmp.log.3
    RUN("FileCheck -check-prefix=CHECK-STALE-SYS-H %s < %t.log.3");
  }

  @Test
  public void test_working_directory_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/PCH/working-directory.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -working-directory ${LLVM_SRC}/llvm/tools/clang/test/PCH -I. -include working-directory.h ${LLVM_SRC}/llvm/tools/clang/test/PCH/working-directory.cpp -Wunused
    RUN("%clang_cc1 -working-directory %S -I. -include working-directory.h %s -Wunused");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -working-directory ${LLVM_SRC}/llvm/tools/clang/test/PCH -x c++-header -emit-pch -o ${TEST_TEMP_DIR}/working-directory.cpp.tmp.pch -I. working-directory.h
    RUN("%clang_cc1 -working-directory %S -x c++-header -emit-pch -o %t.pch -I. working-directory.h");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -include-pch ${TEST_TEMP_DIR}/working-directory.cpp.tmp.pch -fsyntax-only ${LLVM_SRC}/llvm/tools/clang/test/PCH/working-directory.cpp -Wunused
    RUN("%clang_cc1 -include-pch %t.pch -fsyntax-only %s -Wunused");
  }
  
}
