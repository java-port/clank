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
 * Collection of all test files from test/CXX/except folder
 * @author Vladimir Voskresensky
 */
public class AllCXXExceptTest extends DriverTestFileBase {
  private static final String TEST_LOCATION = "${LLVM_SRC}/llvm/tools/clang/test/CXX/except/";
  public AllCXXExceptTest() {
    super(TEST_LOCATION, TestState.Successful);
  }
  
  public static void main(String[] args) {
    // Print tests which will be accepted per test case
    DriverTestFileBase.printAllTestFiles(true, 
            TEST_LOCATION, (test)->{ return true;/*test.getFileIndexInFolder()<120;*/ }, 
            "${SPUTNIK}/modules/org.clang.parse/test/unit/src/org/clang/parse/test/AllCXXExceptTest.txt");
  }  

  @Override
  protected boolean keepStacksForUnimplementedMethods() {
    return false;
  }

  @Test
  public void test_except_spec_canonical_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CXX/except/except.spec/canonical.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -std=c++11 ${LLVM_SRC}/llvm/tools/clang/test/CXX/except/except.spec/canonical.cpp
    RUN("%clang_cc1 -fsyntax-only -verify -std=c++11 %s");
  }

  @Test
  public void test_except_spec_p1_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CXX/except/except.spec/p1.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c++11 -fexceptions -fcxx-exceptions -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/CXX/except/except.spec/p1.cpp
    RUN("%clang_cc1 -std=c++11 -fexceptions -fcxx-exceptions -fsyntax-only -verify %s");
  }

  @Test
  public void test_except_spec_p11_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CXX/except/except.spec/p11.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c++11 -fexceptions -fcxx-exceptions -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/CXX/except/except.spec/p11.cpp
    RUN("%clang_cc1 -std=c++11 -fexceptions -fcxx-exceptions -fsyntax-only -verify %s");
  }

  @Test
  public void test_except_spec_p14_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CXX/except/except.spec/p14.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fcxx-exceptions -fexceptions -verify -std=c++11 ${LLVM_SRC}/llvm/tools/clang/test/CXX/except/except.spec/p14.cpp
    RUN("%clang_cc1 -fcxx-exceptions -fexceptions -verify -std=c++11 %s");
  }

  @Test
  public void test_except_spec_p14_ir_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CXX/except/except.spec/p14-ir.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-apple-darwin10 -emit-llvm -fexceptions -o - ${LLVM_SRC}/llvm/tools/clang/test/CXX/except/except.spec/p14-ir.cpp | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CXX/except/except.spec/p14-ir.cpp
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-apple-darwin10 -emit-llvm -fexceptions -o - %s")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_except_spec_p15_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CXX/except/except.spec/p15.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c++11 -fexceptions -fcxx-exceptions -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/CXX/except/except.spec/p15.cpp
    RUN("%clang_cc1 -std=c++11 -fexceptions -fcxx-exceptions -fsyntax-only -verify %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -DUSE -std=c++11 -fexceptions -fcxx-exceptions -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/CXX/except/except.spec/p15.cpp
    RUN("%clang_cc1 -DUSE -std=c++11 -fexceptions -fcxx-exceptions -fsyntax-only -verify %s");
  }

  @Test
  public void test_except_handle_p16_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CXX/except/except.handle/p16.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fcxx-exceptions -fexceptions -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/CXX/except/except.handle/p16.cpp
    RUN("%clang_cc1 -fcxx-exceptions -fexceptions -fsyntax-only -verify %s");
  }

  @Test
  public void test_except_spec_p2_dynamic_types_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CXX/except/except.spec/p2-dynamic-types.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fexceptions -fcxx-exceptions -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/CXX/except/except.spec/p2-dynamic-types.cpp
    RUN("%clang_cc1 -fexceptions -fcxx-exceptions -fsyntax-only -verify %s");
  }

  @Test
  public void test_except_spec_p2_places_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CXX/except/except.spec/p2-places.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c++11 -fexceptions -fcxx-exceptions -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/CXX/except/except.spec/p2-places.cpp
    RUN("%clang_cc1 -std=c++11 -fexceptions -fcxx-exceptions -fsyntax-only -verify %s");
  }

  @Test
  public void test_except_spec_p3_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CXX/except/except.spec/p3.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c++11 -fexceptions -fcxx-exceptions -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/CXX/except/except.spec/p3.cpp
    RUN("%clang_cc1 -std=c++11 -fexceptions -fcxx-exceptions -fsyntax-only -verify %s");
  }

  @Test
  public void test_except_spec_p4_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CXX/except/except.spec/p4.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c++11 ${LLVM_SRC}/llvm/tools/clang/test/CXX/except/except.spec/p4.cpp -verify -fcxx-exceptions
    RUN("%clang_cc1 -std=c++11 %s -verify -fcxx-exceptions");
  }

  @Test
  public void test_except_spec_p5_delayed_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CXX/except/except.spec/p5-delayed.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c++11 -verify ${LLVM_SRC}/llvm/tools/clang/test/CXX/except/except.spec/p5-delayed.cpp -fexceptions -fcxx-exceptions
    RUN("%clang_cc1 -std=c++11 -verify %s -fexceptions -fcxx-exceptions");
  }

  @Test
  public void test_except_spec_p5_pointers_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CXX/except/except.spec/p5-pointers.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c++11 -fexceptions -fcxx-exceptions -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/CXX/except/except.spec/p5-pointers.cpp
    RUN("%clang_cc1 -std=c++11 -fexceptions -fcxx-exceptions -fsyntax-only -verify %s");
  }

  @Test
  public void test_except_spec_p5_virtual_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CXX/except/except.spec/p5-virtual.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c++11 -fexceptions -fcxx-exceptions -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/CXX/except/except.spec/p5-virtual.cpp
    RUN("%clang_cc1 -std=c++11 -fexceptions -fcxx-exceptions -fsyntax-only -verify %s");
  }

  @Test
  public void test_except_spec_p9_dynamic_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CXX/except/except.spec/p9-dynamic.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CXX/except/except.spec/p9-dynamic.cpp -triple=x86_64-apple-darwin10 -emit-llvm -o - -fcxx-exceptions -fexceptions | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CXX/except/except.spec/p9-dynamic.cpp
    RUN(TestState.Failed, "%clang_cc1 %s -triple=x86_64-apple-darwin10 -emit-llvm -o - -fcxx-exceptions -fexceptions")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_except_spec_p9_noexcept_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CXX/except/except.spec/p9-noexcept.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CXX/except/except.spec/p9-noexcept.cpp -std=c++11 -triple=x86_64-apple-darwin10 -emit-llvm -o - -fcxx-exceptions -fexceptions | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CXX/except/except.spec/p9-noexcept.cpp
    RUN(TestState.Failed, "%clang_cc1 %s -std=c++11 -triple=x86_64-apple-darwin10 -emit-llvm -o - -fcxx-exceptions -fexceptions")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_except_spec_template_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CXX/except/except.spec/template.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c++11 -fexceptions -fcxx-exceptions -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/CXX/except/except.spec/template.cpp
    RUN("%clang_cc1 -std=c++11 -fexceptions -fcxx-exceptions -fsyntax-only -verify %s");
  }
  
}
