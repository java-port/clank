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
 * Collection of all test files from test/FixIt folder
 * @author Vladimir Voskresensky
 */
public class AllFixItTest extends DriverTestFileBase {
  private static final String TEST_LOCATION = "${LLVM_SRC}/llvm/tools/clang/test/FixIt/";
  public AllFixItTest() {
    super(TEST_LOCATION, TestState.Successful);
  }
  
  public static void main(String[] args) {
    // Print tests which will be accepted per test case
    DriverTestFileBase.printAllTestFiles(false, TEST_LOCATION, (test)->true, 
            "${SPUTNIK}/modules/org.clang.sema/test/unit/src/org/clang/sema/test/AllFixItTest.txt");
  }  
  
  @Override
  protected boolean keepStacksForUnimplementedMethods() {
    return false;
  }

  @Test
  public void test_atomic_property_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/FixIt/atomic-property.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-apple-darwin10 -fdiagnostics-parseable-fixits -x objective-c -fobjc-arc ${LLVM_SRC}/llvm/tools/clang/test/FixIt/atomic-property.m 2>&1 | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/FixIt/atomic-property.m
    RUN("%clang_cc1 -triple x86_64-apple-darwin10  -fdiagnostics-parseable-fixits -x objective-c -fobjc-arc %s 2>&1")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_auto_fixit_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/FixIt/auto-fixit.m");
    // cp ${LLVM_SRC}/llvm/tools/clang/test/FixIt/auto-fixit.m ${TEST_TEMP_DIR}/auto-fixit.m.tmp
    RUN("cp %s %t");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x objective-c -fixit ${TEST_TEMP_DIR}/auto-fixit.m.tmp
    RUN("%clang_cc1 -x objective-c -fixit %t");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x objective-c -Werror ${TEST_TEMP_DIR}/auto-fixit.m.tmp
    RUN("%clang_cc1 -x objective-c -Werror %t");
  }

  @Test
  public void test_auto_isa_fixit_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/FixIt/auto-isa-fixit.m");
    // cp ${LLVM_SRC}/llvm/tools/clang/test/FixIt/auto-isa-fixit.m ${TEST_TEMP_DIR}/auto-isa-fixit.m.tmp
    RUN("cp %s %t");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x objective-c -fixit ${TEST_TEMP_DIR}/auto-isa-fixit.m.tmp
    RUN("%clang_cc1 -x objective-c -fixit %t");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x objective-c -Werror ${TEST_TEMP_DIR}/auto-isa-fixit.m.tmp
    RUN("%clang_cc1 -x objective-c -Werror %t");
  }

  @Test
  public void test_bridge_cast_in_arc_mm() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/FixIt/bridge-cast-in-arc.mm");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-apple-darwin10 -fdiagnostics-parseable-fixits -x objective-c++ -fobjc-arc ${LLVM_SRC}/llvm/tools/clang/test/FixIt/bridge-cast-in-arc.mm 2>&1 | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/FixIt/bridge-cast-in-arc.mm
    RUN("not %clang_cc1 -triple x86_64-apple-darwin10  -fdiagnostics-parseable-fixits -x objective-c++ -fobjc-arc %s 2>&1")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_bridge_in_non_arc_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/FixIt/bridge-in-non-arc.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-apple-darwin10 -fdiagnostics-parseable-fixits ${LLVM_SRC}/llvm/tools/clang/test/FixIt/bridge-in-non-arc.m 2>&1 | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/FixIt/bridge-in-non-arc.m
    RUN("%clang_cc1 -triple x86_64-apple-darwin10  -fdiagnostics-parseable-fixits %s 2>&1")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_dereference_addressof_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/FixIt/dereference-addressof.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/FixIt/dereference-addressof.c
    RUN("%clang_cc1 -fsyntax-only -verify %s");
    // cp ${LLVM_SRC}/llvm/tools/clang/test/FixIt/dereference-addressof.c ${TEST_TEMP_DIR}/dereference-addressof.c.tmp
    RUN("cp %s %t");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -fixit -x c ${TEST_TEMP_DIR}/dereference-addressof.c.tmp
    RUN("not %clang_cc1 -fsyntax-only -fixit -x c %t");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -pedantic -x c ${TEST_TEMP_DIR}/dereference-addressof.c.tmp
    RUN("%clang_cc1 -fsyntax-only -pedantic -x c %t");
  }

  @Test
  public void test_fixit_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/FixIt/fixit.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -pedantic -Wunused-label -verify -x c ${LLVM_SRC}/llvm/tools/clang/test/FixIt/fixit.c
    RUN("%clang_cc1 -pedantic -Wunused-label -verify -x c %s");
    // cp ${LLVM_SRC}/llvm/tools/clang/test/FixIt/fixit.c ${TEST_TEMP_DIR}/fixit.c.tmp
    RUN("cp %s %t");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -pedantic -Wunused-label -fixit -x c ${TEST_TEMP_DIR}/fixit.c.tmp
    RUN("not %clang_cc1 -pedantic -Wunused-label -fixit -x c %t");
    // grep -v CHECK ${TEST_TEMP_DIR}/fixit.c.tmp > ${TEST_TEMP_DIR}/fixit.c.tmp2
    RUN("grep -v CHECK %t > %t2");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -pedantic -Wunused-label -Werror -x c ${TEST_TEMP_DIR}/fixit.c.tmp
    RUN("%clang_cc1 -pedantic -Wunused-label -Werror -x c %t");
    // ${LLVM_SRC}/build/bin/FileCheck '-input-file=${TEST_TEMP_DIR}/fixit.c.tmp2' ${TEST_TEMP_DIR}/fixit.c.tmp
    RUN("FileCheck -input-file=%t2 %t");
  }

  @Test
  public void test_fixit_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/FixIt/fixit.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -pedantic -Wall -Wno-comment -verify -fcxx-exceptions -x c++ ${LLVM_SRC}/llvm/tools/clang/test/FixIt/fixit.cpp
    RUN(TestState.Failed, "%clang_cc1 -pedantic -Wall -Wno-comment -verify -fcxx-exceptions -x c++ %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -fdiagnostics-parseable-fixits -x c++ -std=c++11 ${LLVM_SRC}/llvm/tools/clang/test/FixIt/fixit.cpp 2>&1 | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/FixIt/fixit.cpp
    RUN(TestState.Failed, "not %clang_cc1 -fsyntax-only -fdiagnostics-parseable-fixits -x c++ -std=c++11 %s 2>&1")./*|*/
      I("FileCheck %s");
    // cp ${LLVM_SRC}/llvm/tools/clang/test/FixIt/fixit.cpp ${TEST_TEMP_DIR}/fixit.cpp.tmp
    RUN(TestState.Failed, "cp %s %t");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -pedantic -Wall -Wno-comment -fcxx-exceptions -fixit -x c++ ${TEST_TEMP_DIR}/fixit.cpp.tmp
    RUN(TestState.Failed, "not %clang_cc1 -pedantic -Wall -Wno-comment -fcxx-exceptions -fixit -x c++ %t");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -pedantic -Wall -Werror -Wno-comment -fcxx-exceptions -x c++ ${TEST_TEMP_DIR}/fixit.cpp.tmp
    RUN(TestState.Failed, "%clang_cc1 -fsyntax-only -pedantic -Wall -Werror -Wno-comment -fcxx-exceptions -x c++ %t");
  }

  @Test
  public void test_fixit_autoreleasepool_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/FixIt/fixit-autoreleasepool.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-apple-darwin10 -fdiagnostics-parseable-fixits -x objective-c ${LLVM_SRC}/llvm/tools/clang/test/FixIt/fixit-autoreleasepool.m 2>&1 | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/FixIt/fixit-autoreleasepool.m
    RUN("not %clang_cc1 -triple x86_64-apple-darwin10  -fdiagnostics-parseable-fixits -x objective-c %s 2>&1")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_fixit_c90_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/FixIt/fixit-c90.c");
    // cp ${LLVM_SRC}/llvm/tools/clang/test/FixIt/fixit-c90.c ${TEST_TEMP_DIR}/fixit-c90.c.tmp
    RUN("cp %s %t");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c90 -pedantic -fixit ${TEST_TEMP_DIR}/fixit-c90.c.tmp
    RUN("%clang_cc1 -std=c90 -pedantic -fixit %t");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -pedantic -x c -std=c90 -Werror ${TEST_TEMP_DIR}/fixit-c90.c.tmp
    RUN("%clang_cc1 -pedantic -x c -std=c90 -Werror %t");
  }

  @Test
  public void test_fixit_class_method_messaging_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/FixIt/fixit-class-method-messaging.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/FixIt/fixit-class-method-messaging.m
    RUN("%clang_cc1 -fsyntax-only -verify %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fdiagnostics-parseable-fixits ${LLVM_SRC}/llvm/tools/clang/test/FixIt/fixit-class-method-messaging.m 2>&1 | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/FixIt/fixit-class-method-messaging.m
    RUN("%clang_cc1 -fdiagnostics-parseable-fixits %s 2>&1")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_fixit_cxx0x_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/FixIt/fixit-cxx0x.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -verify -std=c++11 -Wno-anonymous-pack-parens ${LLVM_SRC}/llvm/tools/clang/test/FixIt/fixit-cxx0x.cpp
    RUN("%clang_cc1 -verify -std=c++11 -Wno-anonymous-pack-parens %s");
    // cp ${LLVM_SRC}/llvm/tools/clang/test/FixIt/fixit-cxx0x.cpp ${TEST_TEMP_DIR}/fixit-cxx0x.cpp.tmp
    RUN("cp %s %t");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x c++ -std=c++11 -fixit ${TEST_TEMP_DIR}/fixit-cxx0x.cpp.tmp
    RUN("not %clang_cc1 -x c++ -std=c++11 -fixit %t");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -Wall -pedantic -x c++ -std=c++11 ${TEST_TEMP_DIR}/fixit-cxx0x.cpp.tmp
    RUN("%clang_cc1 -Wall -pedantic -x c++ -std=c++11 %t");
  }

  @Test
  public void test_fixit_cxx11_attributes_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/FixIt/fixit-cxx11-attributes.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -verify -std=c++11 ${LLVM_SRC}/llvm/tools/clang/test/FixIt/fixit-cxx11-attributes.cpp
    RUN("%clang_cc1 -verify -std=c++11 %s");
    // cp ${LLVM_SRC}/llvm/tools/clang/test/FixIt/fixit-cxx11-attributes.cpp ${TEST_TEMP_DIR}/fixit-cxx11-attributes.cpp.tmp
    RUN("cp %s %t");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x c++ -std=c++11 -fixit ${TEST_TEMP_DIR}/fixit-cxx11-attributes.cpp.tmp
    RUN("not %clang_cc1 -x c++ -std=c++11 -fixit %t");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -Wall -pedantic -x c++ -std=c++11 ${TEST_TEMP_DIR}/fixit-cxx11-attributes.cpp.tmp
    RUN("%clang_cc1 -Wall -pedantic -x c++ -std=c++11 %t");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c++11 -fsyntax-only -fdiagnostics-parseable-fixits ${LLVM_SRC}/llvm/tools/clang/test/FixIt/fixit-cxx11-attributes.cpp 2>&1 | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/FixIt/fixit-cxx11-attributes.cpp
    RUN("not %clang_cc1 -std=c++11 -fsyntax-only -fdiagnostics-parseable-fixits %s 2>&1")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_fixit_cxx11_compat_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/FixIt/fixit-cxx11-compat.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -Wc++11-compat -verify -std=c++98 ${LLVM_SRC}/llvm/tools/clang/test/FixIt/fixit-cxx11-compat.cpp
    RUN("%clang_cc1 -Wc++11-compat -verify -std=c++98 %s");
    // cp ${LLVM_SRC}/llvm/tools/clang/test/FixIt/fixit-cxx11-compat.cpp ${TEST_TEMP_DIR}/fixit-cxx11-compat.cpp.tmp
    RUN("cp %s %t");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -Wc++11-compat -Werror -x c++ -std=c++98 -fixit ${TEST_TEMP_DIR}/fixit-cxx11-compat.cpp.tmp
    RUN("not %clang_cc1 -Wc++11-compat -Werror -x c++ -std=c++98 -fixit %t");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -Wall -pedantic-errors -Wc++11-compat -Werror -x c++ -std=c++98 ${TEST_TEMP_DIR}/fixit-cxx11-compat.cpp.tmp
    RUN("%clang_cc1 -Wall -pedantic-errors -Wc++11-compat -Werror -x c++ -std=c++98 %t");
  }

  @Test
  public void test_fixit_cxx1y_compat_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/FixIt/fixit-cxx1y-compat.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -verify -std=c++11 ${LLVM_SRC}/llvm/tools/clang/test/FixIt/fixit-cxx1y-compat.cpp
    RUN("%clang_cc1 -verify -std=c++11 %s");
    // cp ${LLVM_SRC}/llvm/tools/clang/test/FixIt/fixit-cxx1y-compat.cpp ${TEST_TEMP_DIR}/fixit-cxx1y-compat.cpp.tmp
    RUN("cp %s %t");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x c++ -std=c++11 -fixit ${TEST_TEMP_DIR}/fixit-cxx1y-compat.cpp.tmp
    RUN("%clang_cc1 -x c++ -std=c++11 -fixit %t");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -Wall -pedantic-errors -Werror -x c++ -std=c++11 ${TEST_TEMP_DIR}/fixit-cxx1y-compat.cpp.tmp
    RUN("%clang_cc1 -Wall -pedantic-errors -Werror -x c++ -std=c++11 %t");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -Wall -pedantic-errors -Werror -x c++ -std=c++1y ${TEST_TEMP_DIR}/fixit-cxx1y-compat.cpp.tmp
    RUN("%clang_cc1 -Wall -pedantic-errors -Werror -x c++ -std=c++1y %t");
  }

  @Test
  public void test_fixit_eof_space_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/FixIt/fixit-eof-space.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/FixIt/fixit-eof-space.c -fsyntax-only -fdiagnostics-parseable-fixits 2>&1 | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/FixIt/fixit-eof-space.c
    RUN("not %clang_cc1 %s -fsyntax-only -fdiagnostics-parseable-fixits 2>&1")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_fixit_errors_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/FixIt/fixit-errors.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -pedantic -verify ${LLVM_SRC}/llvm/tools/clang/test/FixIt/fixit-errors.c
    RUN("%clang_cc1 -fsyntax-only -pedantic -verify %s");
    // cp ${LLVM_SRC}/llvm/tools/clang/test/FixIt/fixit-errors.c ${TEST_TEMP_DIR}/fixit-errors.c.tmp
    RUN("cp %s %t");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -pedantic -fixit -x c ${TEST_TEMP_DIR}/fixit-errors.c.tmp
    RUN("not %clang_cc1 -pedantic -fixit -x c %t");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -pedantic -Werror -Wno-invalid-noreturn -x c ${TEST_TEMP_DIR}/fixit-errors.c.tmp
    RUN("%clang_cc1 -pedantic -Werror -Wno-invalid-noreturn -x c %t");
  }

  @Test
  public void test_fixit_errors_1_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/FixIt/fixit-errors-1.c");
    // cp ${LLVM_SRC}/llvm/tools/clang/test/FixIt/fixit-errors-1.c ${TEST_TEMP_DIR}/fixit-errors-1.c.tmp
    RUN("cp %s %t");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -pedantic -fixit ${TEST_TEMP_DIR}/fixit-errors-1.c.tmp
    RUN("%clang_cc1 -pedantic -fixit %t");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -pedantic -Werror -x c ${TEST_TEMP_DIR}/fixit-errors-1.c.tmp
    RUN("%clang_cc1 -pedantic -Werror -x c %t");
  }

  @Test
  public void test_fixit_function_call_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/FixIt/fixit-function-call.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fdiagnostics-parseable-fixits -x c++ ${LLVM_SRC}/llvm/tools/clang/test/FixIt/fixit-function-call.cpp 2> ${TEST_TEMP_DIR}/fixit-function-call.cpp.tmp
    RUN("not %clang_cc1 -fdiagnostics-parseable-fixits -x c++ %s 2> %t");
    // ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/FixIt/fixit-function-call.cpp < ${TEST_TEMP_DIR}/fixit-function-call.cpp.tmp
    RUN("FileCheck %s < %t");
  }

  @Test
  public void test_fixit_include_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/FixIt/fixit-include.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -Wall -pedantic -verify ${LLVM_SRC}/llvm/tools/clang/test/FixIt/fixit-include.c
    RUN("%clang_cc1 -fsyntax-only -Wall -pedantic -verify %s");
    // cp ${LLVM_SRC}/llvm/tools/clang/test/FixIt/fixit-include.c ${TEST_TEMP_DIR}/fixit-include.c.tmp
    RUN("cp %s %t");
    // cp ${LLVM_SRC}/llvm/tools/clang/test/FixIt/fixit-include.h ${TEST_TEMP_DIR}
    RUN("cp %S/fixit-include.h %T");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -fixit ${TEST_TEMP_DIR}/fixit-include.c.tmp
    RUN("not %clang_cc1 -fsyntax-only -fixit %t");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -Wall -pedantic ${TEST_TEMP_DIR}/fixit-include.c.tmp
    RUN("%clang_cc1 -Wall -pedantic %t");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -fdiagnostics-parseable-fixits ${LLVM_SRC}/llvm/tools/clang/test/FixIt/fixit-include.c 2>&1 | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/FixIt/fixit-include.c
    RUN("not %clang_cc1 -fsyntax-only -fdiagnostics-parseable-fixits %s 2>&1")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_fixit_interface_as_param_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/FixIt/fixit-interface-as-param.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-apple-darwin10 -fblocks -fdiagnostics-parseable-fixits -x objective-c ${LLVM_SRC}/llvm/tools/clang/test/FixIt/fixit-interface-as-param.m 2>&1 | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/FixIt/fixit-interface-as-param.m
    RUN("not %clang_cc1 -triple x86_64-apple-darwin10 -fblocks -fdiagnostics-parseable-fixits -x objective-c %s 2>&1")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_fixit_large_file_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/FixIt/fixit-large-file.cpp");
    // cp ${LLVM_SRC}/llvm/tools/clang/test/FixIt/fixit-large-file.cpp ${TEST_TEMP_DIR}/fixit-large-file.cpp.tmp.cpp
    RUN("cp %s %t.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fixit ${TEST_TEMP_DIR}/fixit-large-file.cpp.tmp.cpp 2>&1 | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/FixIt/fixit-large-file.cpp
    RUN("not %clang_cc1 -fixit %t.cpp 2>&1")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_fixit_missing_method_return_type_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/FixIt/fixit-missing-method-return-type.m");
    // cp ${LLVM_SRC}/llvm/tools/clang/test/FixIt/fixit-missing-method-return-type.m ${TEST_TEMP_DIR}/fixit-missing-method-return-type.m.tmp
    RUN("cp %s %t");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -Wmissing-method-return-type -fixit -x objective-c -Wno-objc-root-class ${TEST_TEMP_DIR}/fixit-missing-method-return-type.m.tmp
    RUN("%clang_cc1 -Wmissing-method-return-type -fixit -x objective-c -Wno-objc-root-class %t");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -pedantic -Wmissing-method-return-type -Werror -x objective-c -Wno-objc-root-class ${TEST_TEMP_DIR}/fixit-missing-method-return-type.m.tmp
    RUN("%clang_cc1 -fsyntax-only -pedantic -Wmissing-method-return-type -Werror -x objective-c -Wno-objc-root-class %t");
    // cp ${LLVM_SRC}/llvm/tools/clang/test/FixIt/fixit-missing-method-return-type.m ${TEST_TEMP_DIR}/fixit-missing-method-return-type.m.tmp
    RUN("cp %s %t");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -Wmissing-method-return-type -fixit -x objective-c++ -Wno-objc-root-class ${TEST_TEMP_DIR}/fixit-missing-method-return-type.m.tmp
    RUN("%clang_cc1 -Wmissing-method-return-type -fixit -x objective-c++ -Wno-objc-root-class %t");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -pedantic -Wmissing-method-return-type -Werror -x objective-c++ -Wno-objc-root-class ${TEST_TEMP_DIR}/fixit-missing-method-return-type.m.tmp
    RUN("%clang_cc1 -fsyntax-only -pedantic -Wmissing-method-return-type -Werror -x objective-c++ -Wno-objc-root-class %t");
  }

  @Test
  public void test_fixit_missing_self_in_block_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/FixIt/fixit-missing-self-in-block.m");
    // cp ${LLVM_SRC}/llvm/tools/clang/test/FixIt/fixit-missing-self-in-block.m ${TEST_TEMP_DIR}/fixit-missing-self-in-block.m.tmp
    RUN("cp %s %t");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x objective-c -fobjc-arc -fblocks -fixit ${TEST_TEMP_DIR}/fixit-missing-self-in-block.m.tmp
    RUN("%clang_cc1 -x objective-c -fobjc-arc -fblocks -fixit %t");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x objective-c -fobjc-arc -fblocks -Werror ${TEST_TEMP_DIR}/fixit-missing-self-in-block.m.tmp
    RUN("%clang_cc1 -x objective-c -fobjc-arc -fblocks -Werror %t");
  }

  @Test
  public void test_fixit_multiple_selector_warnings_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/FixIt/fixit-multiple-selector-warnings.m");
    // cp ${LLVM_SRC}/llvm/tools/clang/test/FixIt/fixit-multiple-selector-warnings.m ${TEST_TEMP_DIR}/fixit-multiple-selector-warnings.m.tmp
    RUN("cp %s %t");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x objective-c -Wselector-type-mismatch -fixit ${TEST_TEMP_DIR}/fixit-multiple-selector-warnings.m.tmp
    RUN("%clang_cc1 -x objective-c -Wselector-type-mismatch -fixit %t");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x objective-c -Wselector-type-mismatch -Werror ${TEST_TEMP_DIR}/fixit-multiple-selector-warnings.m.tmp
    RUN("%clang_cc1 -x objective-c -Wselector-type-mismatch -Werror %t");
  }

  @Test
  public void test_fixit_newline_style_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/FixIt/fixit-newline-style.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -pedantic -Wunused-label -x c ${LLVM_SRC}/llvm/tools/clang/test/FixIt/fixit-newline-style.c 2>&1 | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/FixIt/fixit-newline-style.c -strict-whitespace
    RUN("%clang_cc1 -pedantic -Wunused-label -x c %s 2>&1")./*|*/
      I("FileCheck %s -strict-whitespace");
  }

  @Test
  public void test_fixit_nsstring_compare_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/FixIt/fixit-nsstring-compare.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-apple-darwin10 -fdiagnostics-parseable-fixits -x objective-c ${LLVM_SRC}/llvm/tools/clang/test/FixIt/fixit-nsstring-compare.m 2>&1 | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/FixIt/fixit-nsstring-compare.m
    RUN("%clang_cc1 -triple x86_64-apple-darwin10  -fdiagnostics-parseable-fixits -x objective-c %s 2>&1")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_fixit_nullability_declspec_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/FixIt/fixit-nullability-declspec.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fblocks -Werror=nullability-declspec -x c++ -verify ${LLVM_SRC}/llvm/tools/clang/test/FixIt/fixit-nullability-declspec.cpp
    RUN("%clang_cc1 -fblocks -Werror=nullability-declspec -x c++ -verify %s");
    // cp ${LLVM_SRC}/llvm/tools/clang/test/FixIt/fixit-nullability-declspec.cpp ${TEST_TEMP_DIR}/fixit-nullability-declspec.cpp.tmp
    RUN("cp %s %t");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fixit -fblocks -Werror=nullability-declspec -x c++ ${TEST_TEMP_DIR}/fixit-nullability-declspec.cpp.tmp
    RUN("not %clang_cc1 -fixit -fblocks -Werror=nullability-declspec -x c++ %t");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fblocks -Werror=nullability-declspec -x c++ ${TEST_TEMP_DIR}/fixit-nullability-declspec.cpp.tmp
    RUN("%clang_cc1 -fblocks -Werror=nullability-declspec -x c++ %t");
  }

  @Test
  public void test_fixit_objc_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/FixIt/fixit-objc.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -pedantic -verify ${LLVM_SRC}/llvm/tools/clang/test/FixIt/fixit-objc.m
    RUN(TestState.Failed, "%clang_cc1 -pedantic -verify %s");
    // cp ${LLVM_SRC}/llvm/tools/clang/test/FixIt/fixit-objc.m ${TEST_TEMP_DIR}/fixit-objc.m.tmp
    RUN(TestState.Failed, "cp %s %t");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -pedantic -fixit -x objective-c ${TEST_TEMP_DIR}/fixit-objc.m.tmp
    RUN(TestState.Failed, "not %clang_cc1 -pedantic -fixit -x objective-c %t");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -pedantic -Werror -x objective-c ${TEST_TEMP_DIR}/fixit-objc.m.tmp
    RUN(TestState.Failed, "%clang_cc1 -pedantic -Werror -x objective-c %t");
  }

  @Test
  public void test_fixit_objc_arc_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/FixIt/fixit-objc-arc.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -pedantic -verify ${LLVM_SRC}/llvm/tools/clang/test/FixIt/fixit-objc-arc.m
    RUN(TestState.Failed, "%clang_cc1 -pedantic -verify %s");
    // cp ${LLVM_SRC}/llvm/tools/clang/test/FixIt/fixit-objc-arc.m ${TEST_TEMP_DIR}/fixit-objc-arc.m.tmp
    RUN(TestState.Failed, "cp %s %t");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -pedantic -fobjc-arc -fixit -x objective-c ${TEST_TEMP_DIR}/fixit-objc-arc.m.tmp
    RUN(TestState.Failed, "not %clang_cc1 -pedantic -fobjc-arc -fixit -x objective-c %t");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -pedantic -fobjc-arc -Werror -x objective-c ${TEST_TEMP_DIR}/fixit-objc-arc.m.tmp
    RUN(TestState.Failed, "%clang_cc1 -pedantic -fobjc-arc -Werror -x objective-c %t");
  }

  @Test
  public void test_fixit_objc_bridge_related_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/FixIt/fixit-objc-bridge-related.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-apple-darwin10 -fdiagnostics-parseable-fixits -x objective-c -fobjc-arc ${LLVM_SRC}/llvm/tools/clang/test/FixIt/fixit-objc-bridge-related.m 2>&1 | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/FixIt/fixit-objc-bridge-related.m
    RUN("not %clang_cc1 -triple x86_64-apple-darwin10  -fdiagnostics-parseable-fixits -x objective-c -fobjc-arc %s 2>&1")./*|*/
      I("FileCheck %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-apple-darwin10 -fdiagnostics-parseable-fixits -x objective-c++ -fobjc-arc ${LLVM_SRC}/llvm/tools/clang/test/FixIt/fixit-objc-bridge-related.m 2>&1 | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/FixIt/fixit-objc-bridge-related.m
    RUN("not %clang_cc1 -triple x86_64-apple-darwin10  -fdiagnostics-parseable-fixits -x objective-c++ -fobjc-arc %s 2>&1")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_fixit_objc_bridge_related_attr_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/FixIt/fixit-objc-bridge-related-attr.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-apple-darwin10 -fdiagnostics-parseable-fixits -x objective-c ${LLVM_SRC}/llvm/tools/clang/test/FixIt/fixit-objc-bridge-related-attr.m 2>&1 | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/FixIt/fixit-objc-bridge-related-attr.m
    RUN(TestState.Failed, "not %clang_cc1  -triple x86_64-apple-darwin10  -fdiagnostics-parseable-fixits -x objective-c %s 2>&1")./*|*/
      I("FileCheck %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-apple-darwin10 -fobjc-arc -fdiagnostics-parseable-fixits -x objective-c ${LLVM_SRC}/llvm/tools/clang/test/FixIt/fixit-objc-bridge-related-attr.m 2>&1 | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/FixIt/fixit-objc-bridge-related-attr.m
    RUN(TestState.Failed, "not %clang_cc1  -triple x86_64-apple-darwin10  -fobjc-arc -fdiagnostics-parseable-fixits -x objective-c %s 2>&1")./*|*/
      I("FileCheck %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-apple-darwin10 -fdiagnostics-parseable-fixits -x objective-c++ ${LLVM_SRC}/llvm/tools/clang/test/FixIt/fixit-objc-bridge-related-attr.m 2>&1 | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/FixIt/fixit-objc-bridge-related-attr.m
    RUN(TestState.Failed, "not %clang_cc1  -triple x86_64-apple-darwin10  -fdiagnostics-parseable-fixits -x objective-c++ %s 2>&1")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_fixit_objc_bridge_related_property_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/FixIt/fixit-objc-bridge-related-property.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-apple-darwin10 -fdiagnostics-parseable-fixits -x objective-c ${LLVM_SRC}/llvm/tools/clang/test/FixIt/fixit-objc-bridge-related-property.m 2>&1 | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/FixIt/fixit-objc-bridge-related-property.m
    RUN(TestState.Failed, "not %clang_cc1  -triple x86_64-apple-darwin10  -fdiagnostics-parseable-fixits -x objective-c %s 2>&1")./*|*/
      I("FileCheck %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-apple-darwin10 -fobjc-arc -fdiagnostics-parseable-fixits -x objective-c ${LLVM_SRC}/llvm/tools/clang/test/FixIt/fixit-objc-bridge-related-property.m 2>&1 | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/FixIt/fixit-objc-bridge-related-property.m
    RUN(TestState.Failed, "not %clang_cc1  -triple x86_64-apple-darwin10  -fobjc-arc -fdiagnostics-parseable-fixits -x objective-c %s 2>&1")./*|*/
      I("FileCheck %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-apple-darwin10 -fdiagnostics-parseable-fixits -x objective-c++ ${LLVM_SRC}/llvm/tools/clang/test/FixIt/fixit-objc-bridge-related-property.m 2>&1 | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/FixIt/fixit-objc-bridge-related-property.m
    RUN(TestState.Failed, "not %clang_cc1  -triple x86_64-apple-darwin10  -fdiagnostics-parseable-fixits -x objective-c++ %s 2>&1")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_fixit_objc_message_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/FixIt/fixit-objc-message.m");
    // cp ${LLVM_SRC}/llvm/tools/clang/test/FixIt/fixit-objc-message.m ${TEST_TEMP_DIR}/fixit-objc-message.m.tmp
    RUN("cp %s %t");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -pedantic -Wall -fixit -x objective-c ${TEST_TEMP_DIR}/fixit-objc-message.m.tmp
    RUN("not %clang_cc1 -pedantic -Wall -fixit -x objective-c %t");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -pedantic -Wall -Werror -x objective-c ${TEST_TEMP_DIR}/fixit-objc-message.m.tmp
    RUN("%clang_cc1 -fsyntax-only -pedantic -Wall -Werror -x objective-c %t");
    // cp ${LLVM_SRC}/llvm/tools/clang/test/FixIt/fixit-objc-message.m ${TEST_TEMP_DIR}/fixit-objc-message.m.tmp
    RUN("cp %s %t");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -pedantic -Wall -fixit -x objective-c++ ${TEST_TEMP_DIR}/fixit-objc-message.m.tmp
    RUN("not %clang_cc1 -pedantic -Wall -fixit -x objective-c++ %t");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -pedantic -Wall -Werror -x objective-c++ ${TEST_TEMP_DIR}/fixit-objc-message.m.tmp
    RUN("%clang_cc1 -fsyntax-only -pedantic -Wall -Werror -x objective-c++ %t");
  }

  @Test
  public void test_fixit_objc_message_comma_separator_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/FixIt/fixit-objc-message-comma-separator.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-apple-darwin10 -fdiagnostics-parseable-fixits -x objective-c ${LLVM_SRC}/llvm/tools/clang/test/FixIt/fixit-objc-message-comma-separator.m 2>&1 | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/FixIt/fixit-objc-message-comma-separator.m
    RUN("not %clang_cc1 -triple x86_64-apple-darwin10  -fdiagnostics-parseable-fixits -x objective-c %s 2>&1")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_fixit_pmem_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/FixIt/fixit-pmem.cpp");
    // cp ${LLVM_SRC}/llvm/tools/clang/test/FixIt/fixit-pmem.cpp ${TEST_TEMP_DIR}/fixit-pmem.cpp.tmp
    RUN(TestState.Failed, "cp %s %t");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -pedantic -fixit -x c++ ${TEST_TEMP_DIR}/fixit-pmem.cpp.tmp
    RUN(TestState.Failed, "%clang_cc1 -pedantic -fixit -x c++ %t");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -pedantic -Werror -x c++ ${TEST_TEMP_DIR}/fixit-pmem.cpp.tmp
    RUN(TestState.Failed, "%clang_cc1 -fsyntax-only -pedantic -Werror -x c++ %t");
  }

  @Test
  public void test_fixit_recompile_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/FixIt/fixit-recompile.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -Werror -pedantic ${LLVM_SRC}/llvm/tools/clang/test/FixIt/fixit-recompile.c -fixit-recompile -fixit-to-temporary -E -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/FixIt/fixit-recompile.c
    RUN("%clang_cc1 -Werror -pedantic %s -fixit-recompile -fixit-to-temporary -E -o -")./*|*/
      I("FileCheck %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -Werror -pedantic ${LLVM_SRC}/llvm/tools/clang/test/FixIt/fixit-recompile.c -fixit-recompile -fixit-to-temporary -fix-only-warnings
    RUN("not %clang_cc1 -Werror -pedantic %s -fixit-recompile -fixit-to-temporary -fix-only-warnings");
  }

  @Test
  public void test_fixit_recursive_block_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/FixIt/fixit-recursive-block.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-apple-darwin10 -Wuninitialized -fblocks -fdiagnostics-parseable-fixits ${LLVM_SRC}/llvm/tools/clang/test/FixIt/fixit-recursive-block.c 2>&1 | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/FixIt/fixit-recursive-block.c
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-apple-darwin10  -Wuninitialized -fblocks -fdiagnostics-parseable-fixits %s 2>&1")./*|*/
      I("FileCheck %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-apple-darwin10 -Wuninitialized -fblocks -verify ${LLVM_SRC}/llvm/tools/clang/test/FixIt/fixit-recursive-block.c
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-apple-darwin10  -Wuninitialized -fblocks -verify %s");
  }

  @Test
  public void test_fixit_static_object_decl_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/FixIt/fixit-static-object-decl.m");
    // cp ${LLVM_SRC}/llvm/tools/clang/test/FixIt/fixit-static-object-decl.m ${TEST_TEMP_DIR}/fixit-static-object-decl.m.tmp
    RUN("cp %s %t");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fixit -x objective-c ${TEST_TEMP_DIR}/fixit-static-object-decl.m.tmp
    RUN("not %clang_cc1 -fixit -x objective-c %t");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -Werror -x objective-c ${TEST_TEMP_DIR}/fixit-static-object-decl.m.tmp
    RUN("%clang_cc1 -fsyntax-only -Werror -x objective-c %t");
    // cp ${LLVM_SRC}/llvm/tools/clang/test/FixIt/fixit-static-object-decl.m ${TEST_TEMP_DIR}/fixit-static-object-decl.m.tmp
    RUN("cp %s %t");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fixit -x objective-c++ ${TEST_TEMP_DIR}/fixit-static-object-decl.m.tmp -std=c++11
    RUN("not %clang_cc1 -fixit -x objective-c++ %t -std=c++11");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -Werror -x objective-c++ ${TEST_TEMP_DIR}/fixit-static-object-decl.m.tmp -std=c++11
    RUN("%clang_cc1 -fsyntax-only -Werror -x objective-c++ %t  -std=c++11");
  }

  @Test
  public void test_fixit_suffix_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/FixIt/fixit-suffix.c");
    // cp ${LLVM_SRC}/llvm/tools/clang/test/FixIt/fixit-suffix.c ${TEST_TEMP_DIR}/fixit-suffix.c.tmp.extrasuffix
    RUN("cp %s %t.extrasuffix");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fixit=fixed -x c ${TEST_TEMP_DIR}/fixit-suffix.c.tmp.extrasuffix
    RUN("%clang_cc1 -fixit=fixed -x c %t.extrasuffix");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -Werror -pedantic -x c ${TEST_TEMP_DIR}/fixit-suffix.c.tmp.fixed.extrasuffix
    RUN("%clang_cc1 -Werror -pedantic -x c %t.fixed.extrasuffix");
  }

  @Test
  public void test_fixit_unicode_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/FixIt/fixit-unicode.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only ${LLVM_SRC}/llvm/tools/clang/test/FixIt/fixit-unicode.c 2>&1 | ${LLVM_SRC}/build/bin/FileCheck -strict-whitespace ${LLVM_SRC}/llvm/tools/clang/test/FixIt/fixit-unicode.c
    RUN(TestState.Failed, "not %clang_cc1 -fsyntax-only %s 2>&1")./*|*/
      I("FileCheck -strict-whitespace %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -fdiagnostics-parseable-fixits ${LLVM_SRC}/llvm/tools/clang/test/FixIt/fixit-unicode.c 2>&1 | ${LLVM_SRC}/build/bin/FileCheck -check-prefix=CHECK-MACHINE ${LLVM_SRC}/llvm/tools/clang/test/FixIt/fixit-unicode.c
    RUN(TestState.Failed, "not %clang_cc1 -fsyntax-only -fdiagnostics-parseable-fixits %s 2>&1")./*|*/
      I("FileCheck -check-prefix=CHECK-MACHINE %s");
  }

  @Test
  public void test_fixit_unicode_with_utf8_output_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/FixIt/fixit-unicode-with-utf8-output.c");
    // REQUIRES: utf8-capable-terminal
    if (!CHECK_REQUIRES("utf8-capable-terminal")) {
      return;
    }
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only ${LLVM_SRC}/llvm/tools/clang/test/FixIt/fixit-unicode.c 2>&1 | ${LLVM_SRC}/build/bin/FileCheck -strict-whitespace ${LLVM_SRC}/llvm/tools/clang/test/FixIt/fixit-unicode-with-utf8-output.c
    RUN("not %clang_cc1 -fsyntax-only %S/fixit-unicode.c 2>&1")./*|*/
      I("FileCheck -strict-whitespace %s");
  }

  @Test
  public void test_fixit_uninit_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/FixIt/fixit-uninit.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -Wuninitialized -verify ${LLVM_SRC}/llvm/tools/clang/test/FixIt/fixit-uninit.c
    RUN(TestState.Failed, "%clang_cc1 -fsyntax-only -Wuninitialized -verify %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -Wuninitialized -fdiagnostics-parseable-fixits ${LLVM_SRC}/llvm/tools/clang/test/FixIt/fixit-uninit.c 2>&1 | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/FixIt/fixit-uninit.c
    RUN(TestState.Failed, "%clang_cc1 -fsyntax-only -Wuninitialized -fdiagnostics-parseable-fixits %s 2>&1")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_fixit_unrecoverable_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/FixIt/fixit-unrecoverable.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/FixIt/fixit-unrecoverable.c
    RUN("%clang_cc1 -fsyntax-only -verify %s");
  }

  @Test
  public void test_fixit_unrecoverable_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/FixIt/fixit-unrecoverable.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/FixIt/fixit-unrecoverable.cpp
    RUN("%clang_cc1 -fsyntax-only -verify %s");
  }

  @Test
  public void test_fixit_vexing_parse_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/FixIt/fixit-vexing-parse.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -verify -x c++ -std=c++98 ${LLVM_SRC}/llvm/tools/clang/test/FixIt/fixit-vexing-parse.cpp
    RUN("%clang_cc1 -verify -x c++ -std=c++98 %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fdiagnostics-parseable-fixits -x c++ -std=c++98 ${LLVM_SRC}/llvm/tools/clang/test/FixIt/fixit-vexing-parse.cpp 2>&1 | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/FixIt/fixit-vexing-parse.cpp
    RUN("not %clang_cc1 -fdiagnostics-parseable-fixits -x c++ -std=c++98 %s 2>&1")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_fixit_vexing_parse_cxx0x_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/FixIt/fixit-vexing-parse-cxx0x.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -verify -x c++ -std=c++11 ${LLVM_SRC}/llvm/tools/clang/test/FixIt/fixit-vexing-parse-cxx0x.cpp
    RUN("%clang_cc1 -verify -x c++ -std=c++11 %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fdiagnostics-parseable-fixits -x c++ -std=c++11 ${LLVM_SRC}/llvm/tools/clang/test/FixIt/fixit-vexing-parse-cxx0x.cpp 2>&1 | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/FixIt/fixit-vexing-parse-cxx0x.cpp
    RUN("%clang_cc1 -fdiagnostics-parseable-fixits -x c++ -std=c++11 %s 2>&1")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_format_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/FixIt/format.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i386-pc-solaris2.11 -fsyntax-only -fblocks -verify ${LLVM_SRC}/llvm/tools/clang/test/FixIt/format.m
    RUN("%clang_cc1 -triple %itanium_abi_triple -fsyntax-only -fblocks -verify %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i386-pc-solaris2.11 -fdiagnostics-parseable-fixits -fblocks ${LLVM_SRC}/llvm/tools/clang/test/FixIt/format.m 2>&1 | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/FixIt/format.m
    RUN("%clang_cc1 -triple %itanium_abi_triple -fdiagnostics-parseable-fixits -fblocks %s 2>&1")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_format_mm() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/FixIt/format.mm");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -fblocks -verify ${LLVM_SRC}/llvm/tools/clang/test/FixIt/format.mm
    RUN("%clang_cc1 -fsyntax-only -fblocks -verify %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fdiagnostics-parseable-fixits -fblocks ${LLVM_SRC}/llvm/tools/clang/test/FixIt/format.mm 2>&1 | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/FixIt/format.mm
    RUN("%clang_cc1 -fdiagnostics-parseable-fixits -fblocks %s 2>&1")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_format_darwin_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/FixIt/format-darwin.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i386-apple-darwin9 -fsyntax-only -fblocks -Wformat-non-iso -verify ${LLVM_SRC}/llvm/tools/clang/test/FixIt/format-darwin.m
    RUN("%clang_cc1 -triple i386-apple-darwin9 -fsyntax-only -fblocks -Wformat-non-iso -verify %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-apple-darwin9 -fsyntax-only -fblocks -Wformat-non-iso -verify ${LLVM_SRC}/llvm/tools/clang/test/FixIt/format-darwin.m
    RUN("%clang_cc1 -triple x86_64-apple-darwin9 -fsyntax-only -fblocks -Wformat-non-iso -verify %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i386-apple-darwin9 -fdiagnostics-parseable-fixits -fblocks -Wformat-non-iso ${LLVM_SRC}/llvm/tools/clang/test/FixIt/format-darwin.m 2>&1 | ${LLVM_SRC}/build/bin/FileCheck -check-prefix=CHECK -check-prefix=CHECK-32 ${LLVM_SRC}/llvm/tools/clang/test/FixIt/format-darwin.m
    RUN("%clang_cc1 -triple i386-apple-darwin9 -fdiagnostics-parseable-fixits -fblocks -Wformat-non-iso %s 2>&1")./*|*/
      I("FileCheck -check-prefix=CHECK -check-prefix=CHECK-32 %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-apple-darwin9 -fdiagnostics-parseable-fixits -fblocks -Wformat-non-iso ${LLVM_SRC}/llvm/tools/clang/test/FixIt/format-darwin.m 2>&1 | ${LLVM_SRC}/build/bin/FileCheck -check-prefix=CHECK -check-prefix=CHECK-64 ${LLVM_SRC}/llvm/tools/clang/test/FixIt/format-darwin.m
    RUN("%clang_cc1 -triple x86_64-apple-darwin9 -fdiagnostics-parseable-fixits -fblocks -Wformat-non-iso %s 2>&1")./*|*/
      I("FileCheck -check-prefix=CHECK -check-prefix=CHECK-64 %s");
  }

  @Test
  public void test_format_no_fixit_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/FixIt/format-no-fixit.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/FixIt/format-no-fixit.m
    RUN("%clang_cc1 -fsyntax-only -verify %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fdiagnostics-parseable-fixits -fsyntax-only ${LLVM_SRC}/llvm/tools/clang/test/FixIt/format-no-fixit.m 2>&1 | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/FixIt/format-no-fixit.m
    RUN("%clang_cc1 -fdiagnostics-parseable-fixits -fsyntax-only %s 2>&1")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_messages_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/FixIt/messages.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -std=c++11 2>&1 ${LLVM_SRC}/llvm/tools/clang/test/FixIt/messages.cpp | ${LLVM_SRC}/build/bin/FileCheck -strict-whitespace ${LLVM_SRC}/llvm/tools/clang/test/FixIt/messages.cpp
    RUN("not %clang_cc1 -fsyntax-only -std=c++11 2>&1 %s")./*|*/
      I("FileCheck -strict-whitespace %s");
  }

  @Test
  public void test_multiarg_selector_fixit_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/FixIt/multiarg-selector-fixit.m");
    // cp ${LLVM_SRC}/llvm/tools/clang/test/FixIt/multiarg-selector-fixit.m ${TEST_TEMP_DIR}/multiarg-selector-fixit.m.tmp
    RUN("cp %s %t");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x objective-c -fixit ${TEST_TEMP_DIR}/multiarg-selector-fixit.m.tmp
    RUN("%clang_cc1 -x objective-c -fixit %t");
    // diff ${TEST_TEMP_DIR}/multiarg-selector-fixit.m.tmp ${LLVM_SRC}/llvm/tools/clang/test/FixIt/multiarg-selector-fixit.m
    RUN("diff %t %s");
  }

  @Test
  public void test_no_diagnostics_fixit_info_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/FixIt/no-diagnostics-fixit-info.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/FixIt/no-diagnostics-fixit-info.c 2>&1 | ${LLVM_SRC}/build/bin/FileCheck -check-prefix=WITH-FIXIT ${LLVM_SRC}/llvm/tools/clang/test/FixIt/no-diagnostics-fixit-info.c
    RUN("not %clang_cc1 %s 2>&1")./*|*/
      I("FileCheck -check-prefix=WITH-FIXIT %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fno-diagnostics-fixit-info ${LLVM_SRC}/llvm/tools/clang/test/FixIt/no-diagnostics-fixit-info.c 2>&1 | ${LLVM_SRC}/build/bin/FileCheck -check-prefix=WITHOUT-FIXIT ${LLVM_SRC}/llvm/tools/clang/test/FixIt/no-diagnostics-fixit-info.c
    RUN("not %clang_cc1 -fno-diagnostics-fixit-info %s 2>&1")./*|*/
      I("FileCheck -check-prefix=WITHOUT-FIXIT %s");
  }

  @Test
  public void test_no_fixit_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/FixIt/no-fixit.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fdiagnostics-parseable-fixits -x c++ -std=c++11 ${LLVM_SRC}/llvm/tools/clang/test/FixIt/no-fixit.cpp 2>&1 | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/FixIt/no-fixit.cpp
    RUN("not %clang_cc1 -fdiagnostics-parseable-fixits -x c++ -std=c++11 %s 2>&1")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_no_macro_fixit_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/FixIt/no-macro-fixit.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -pedantic -fixit -x c ${LLVM_SRC}/llvm/tools/clang/test/FixIt/no-macro-fixit.c
    RUN("%clang_cc1 -pedantic -fixit -x c %s");
  }

  @Test
  public void test_no_typo_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/FixIt/no-typo.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -fno-spell-checking -verify ${LLVM_SRC}/llvm/tools/clang/test/FixIt/no-typo.c
    RUN("%clang_cc1 -fsyntax-only -fno-spell-checking -verify %s");
  }

  @Test
  public void test_objc_literals_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/FixIt/objc-literals.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/FixIt/objc-literals.m
    RUN("%clang_cc1 -fsyntax-only -verify %s");
    // cp ${LLVM_SRC}/llvm/tools/clang/test/FixIt/objc-literals.m ${TEST_TEMP_DIR}/objc-literals.m.tmp
    RUN("cp %s %t");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -fixit -x objective-c ${TEST_TEMP_DIR}/objc-literals.m.tmp
    RUN("not %clang_cc1 -fsyntax-only -fixit -x objective-c %t");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -pedantic -Werror -x objective-c ${TEST_TEMP_DIR}/objc-literals.m.tmp
    RUN("%clang_cc1 -fsyntax-only -pedantic -Werror -x objective-c %t");
  }

  @Test
  public void test_property_access_fixit_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/FixIt/property-access-fixit.m");
    // cp ${LLVM_SRC}/llvm/tools/clang/test/FixIt/property-access-fixit.m ${TEST_TEMP_DIR}/property-access-fixit.m.tmp
    RUN("cp %s %t");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x objective-c -fixit ${TEST_TEMP_DIR}/property-access-fixit.m.tmp
    RUN("%clang_cc1 -x objective-c -fixit %t");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x objective-c -Werror ${TEST_TEMP_DIR}/property-access-fixit.m.tmp
    RUN("%clang_cc1 -x objective-c -Werror %t");
  }

  @Test
  public void test_selector_fixit_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/FixIt/selector-fixit.m");
    // cp ${LLVM_SRC}/llvm/tools/clang/test/FixIt/selector-fixit.m ${TEST_TEMP_DIR}/selector-fixit.m.tmp
    RUN("cp %s %t");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x objective-c -Wundeclared-selector -fixit ${TEST_TEMP_DIR}/selector-fixit.m.tmp
    RUN("%clang_cc1 -x objective-c -Wundeclared-selector -fixit %t");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x objective-c -Wundeclared-selector -Werror ${TEST_TEMP_DIR}/selector-fixit.m.tmp
    RUN("%clang_cc1 -x objective-c -Wundeclared-selector -Werror %t");
  }

  @Test
  public void test_typo_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/FixIt/typo.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/FixIt/typo.c
    RUN("%clang_cc1 -fsyntax-only -verify %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -fdiagnostics-parseable-fixits ${LLVM_SRC}/llvm/tools/clang/test/FixIt/typo.c 2>&1 | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/FixIt/typo.c
    RUN("not %clang_cc1 -fsyntax-only -fdiagnostics-parseable-fixits %s 2>&1")./*|*/
      I("FileCheck %s");
    // cp ${LLVM_SRC}/llvm/tools/clang/test/FixIt/typo.c ${TEST_TEMP_DIR}/typo.c.tmp
    RUN("cp %s %t");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -fixit -x c ${TEST_TEMP_DIR}/typo.c.tmp
    RUN("not %clang_cc1 -fsyntax-only -fixit -x c %t");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -pedantic -Werror -x c ${TEST_TEMP_DIR}/typo.c.tmp
    RUN("%clang_cc1 -fsyntax-only -pedantic -Werror -x c %t");
  }

  @Test
  public void test_typo_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/FixIt/typo.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/FixIt/typo.cpp
    RUN("%clang_cc1 -fsyntax-only -verify %s");
    // cp ${LLVM_SRC}/llvm/tools/clang/test/FixIt/typo.cpp ${TEST_TEMP_DIR}/typo.cpp.tmp
    RUN("cp %s %t");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -fixit -x c++ ${TEST_TEMP_DIR}/typo.cpp.tmp
    RUN("not %clang_cc1 -fsyntax-only -fixit -x c++ %t");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -pedantic -Werror -x c++ ${TEST_TEMP_DIR}/typo.cpp.tmp
    RUN("%clang_cc1 -fsyntax-only -pedantic -Werror -x c++ %t");
    // grep test_string ${TEST_TEMP_DIR}/typo.cpp.tmp
    RUN("grep test_string %t");
  }

  @Test
  public void test_typo_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/FixIt/typo.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -triple x86_64-apple-darwin10 -DNON_FIXITS -verify -Wno-objc-root-class ${LLVM_SRC}/llvm/tools/clang/test/FixIt/typo.m
    RUN("%clang_cc1 -fsyntax-only -triple x86_64-apple-darwin10 -DNON_FIXITS -verify -Wno-objc-root-class %s");
    // cp ${LLVM_SRC}/llvm/tools/clang/test/FixIt/typo.m ${TEST_TEMP_DIR}/typo.m.tmp
    RUN("cp %s %t");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x objective-c -fsyntax-only -triple x86_64-apple-darwin10 -fixit -Wno-objc-root-class ${TEST_TEMP_DIR}/typo.m.tmp
    RUN("not %clang_cc1 -x objective-c -fsyntax-only -triple x86_64-apple-darwin10 -fixit -Wno-objc-root-class %t");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x objective-c -fsyntax-only -triple x86_64-apple-darwin10 -pedantic -Werror -Wno-objc-root-class ${TEST_TEMP_DIR}/typo.m.tmp
    RUN("%clang_cc1 -x objective-c -fsyntax-only -triple x86_64-apple-darwin10 -pedantic -Werror -Wno-objc-root-class %t");
    // grep '@implementation Sub3' ${TEST_TEMP_DIR}/typo.m.tmp
    RUN("grep \"@implementation Sub3\" %t");
  }

  @Test
  public void test_typo_crash_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/FixIt/typo-crash.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/FixIt/typo-crash.cpp
    RUN("%clang_cc1 -fsyntax-only -verify %s");
  }

  @Test
  public void test_typo_crash_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/FixIt/typo-crash.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/FixIt/typo-crash.m
    RUN("%clang_cc1 -fsyntax-only -verify %s");
  }

  @Test
  public void test_typo_location_bugs_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/FixIt/typo-location-bugs.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/FixIt/typo-location-bugs.cpp
    RUN( "%clang_cc1 -fsyntax-only -verify %s");
    // cp ${LLVM_SRC}/llvm/tools/clang/test/FixIt/typo-location-bugs.cpp ${TEST_TEMP_DIR}/typo-location-bugs.cpp.tmp
    RUN( "cp %s %t");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -fixit -x c++ ${TEST_TEMP_DIR}/typo-location-bugs.cpp.tmp
    RUN( "not %clang_cc1 -fsyntax-only -fixit -x c++ %t");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -pedantic -Werror -x c++ ${TEST_TEMP_DIR}/typo-location-bugs.cpp.tmp
    RUN( "%clang_cc1 -fsyntax-only -pedantic -Werror -x c++ %t");
  }

  @Test
  public void test_typo_using_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/FixIt/typo-using.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/FixIt/typo-using.cpp
    RUN("%clang_cc1 -fsyntax-only -verify %s");
    // cp ${LLVM_SRC}/llvm/tools/clang/test/FixIt/typo-using.cpp ${TEST_TEMP_DIR}/typo-using.cpp.tmp
    RUN("cp %s %t");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -fixit -x c++ ${TEST_TEMP_DIR}/typo-using.cpp.tmp
    RUN("not %clang_cc1 -fsyntax-only -fixit -x c++ %t");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -pedantic -Werror -x c++ ${TEST_TEMP_DIR}/typo-using.cpp.tmp
    RUN("%clang_cc1 -fsyntax-only -pedantic -Werror -x c++ %t");
    // grep using_suggestion_tyname_ty_dropped_specifier ${TEST_TEMP_DIR}/typo-using.cpp.tmp
    RUN("grep using_suggestion_tyname_ty_dropped_specifier %t");
  }
  
}
