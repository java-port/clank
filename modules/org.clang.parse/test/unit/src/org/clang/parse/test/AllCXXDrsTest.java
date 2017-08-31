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
 * Collection of all test files from test/CXX/drs folder
 * @author Vladimir Voskresensky
 */
public class AllCXXDrsTest extends DriverTestFileBase {
  private static final String TEST_LOCATION = "${LLVM_SRC}/llvm/tools/clang/test/CXX/drs/";
  public AllCXXDrsTest() {
    super(TEST_LOCATION, TestState.Successful);
  }
  
  public static void main(String[] args) {
    // Print tests which will be accepted per test case
    DriverTestFileBase.printAllTestFiles(true, 
            TEST_LOCATION, (test)->{ return true;/*test.getFileIndexInFolder()<120;*/ }, 
            "${SPUTNIK}/modules/org.clang.parse/test/unit/src/org/clang/parse/test/AllCXXDrsTest.txt");
  }  

  @Override
  protected boolean keepStacksForUnimplementedMethods() {
    return false;
  }
  
  @Test
  public void test_drs_dr0xx_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CXX/drs/dr0xx.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c++98 ${LLVM_SRC}/llvm/tools/clang/test/CXX/drs/dr0xx.cpp -verify -fexceptions -fcxx-exceptions -pedantic-errors -Wno-bind-to-temporary-copy
    RUN("%clang_cc1 -std=c++98 %s -verify -fexceptions -fcxx-exceptions -pedantic-errors -Wno-bind-to-temporary-copy");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c++11 ${LLVM_SRC}/llvm/tools/clang/test/CXX/drs/dr0xx.cpp -verify -fexceptions -fcxx-exceptions -pedantic-errors -triple i386-pc-solaris2.11
    RUN("%clang_cc1 -std=c++11 %s -verify -fexceptions -fcxx-exceptions -pedantic-errors -triple %itanium_abi_triple");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c++14 ${LLVM_SRC}/llvm/tools/clang/test/CXX/drs/dr0xx.cpp -verify -fexceptions -fcxx-exceptions -pedantic-errors -triple i386-pc-solaris2.11
    RUN("%clang_cc1 -std=c++14 %s -verify -fexceptions -fcxx-exceptions -pedantic-errors -triple %itanium_abi_triple");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c++1z ${LLVM_SRC}/llvm/tools/clang/test/CXX/drs/dr0xx.cpp -verify -fexceptions -fcxx-exceptions -pedantic-errors -triple i386-pc-solaris2.11
    RUN("%clang_cc1 -std=c++1z %s -verify -fexceptions -fcxx-exceptions -pedantic-errors -triple %itanium_abi_triple");
  }

  @Test
  public void test_drs_dr10xx_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CXX/drs/dr10xx.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c++98 ${LLVM_SRC}/llvm/tools/clang/test/CXX/drs/dr10xx.cpp -verify -fexceptions -fcxx-exceptions -pedantic-errors
    RUN("%clang_cc1 -std=c++98 %s -verify -fexceptions -fcxx-exceptions -pedantic-errors");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c++11 ${LLVM_SRC}/llvm/tools/clang/test/CXX/drs/dr10xx.cpp -verify -fexceptions -fcxx-exceptions -pedantic-errors
    RUN("%clang_cc1 -std=c++11 %s -verify -fexceptions -fcxx-exceptions -pedantic-errors");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c++14 ${LLVM_SRC}/llvm/tools/clang/test/CXX/drs/dr10xx.cpp -verify -fexceptions -fcxx-exceptions -pedantic-errors
    RUN("%clang_cc1 -std=c++14 %s -verify -fexceptions -fcxx-exceptions -pedantic-errors");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c++1z ${LLVM_SRC}/llvm/tools/clang/test/CXX/drs/dr10xx.cpp -verify -fexceptions -fcxx-exceptions -pedantic-errors
    RUN("%clang_cc1 -std=c++1z %s -verify -fexceptions -fcxx-exceptions -pedantic-errors");
  }

  @Test
  public void test_drs_dr12xx_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CXX/drs/dr12xx.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c++98 ${LLVM_SRC}/llvm/tools/clang/test/CXX/drs/dr12xx.cpp -verify -fexceptions -fcxx-exceptions -pedantic-errors
    RUN("%clang_cc1 -std=c++98 %s -verify -fexceptions -fcxx-exceptions -pedantic-errors");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c++11 ${LLVM_SRC}/llvm/tools/clang/test/CXX/drs/dr12xx.cpp -verify -fexceptions -fcxx-exceptions -pedantic-errors
    RUN("%clang_cc1 -std=c++11 %s -verify -fexceptions -fcxx-exceptions -pedantic-errors");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c++14 ${LLVM_SRC}/llvm/tools/clang/test/CXX/drs/dr12xx.cpp -verify -fexceptions -fcxx-exceptions -pedantic-errors
    RUN("%clang_cc1 -std=c++14 %s -verify -fexceptions -fcxx-exceptions -pedantic-errors");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c++1z ${LLVM_SRC}/llvm/tools/clang/test/CXX/drs/dr12xx.cpp -verify -fexceptions -fcxx-exceptions -pedantic-errors
    RUN("%clang_cc1 -std=c++1z %s -verify -fexceptions -fcxx-exceptions -pedantic-errors");
  }

  @Test
  public void test_drs_dr13xx_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CXX/drs/dr13xx.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c++98 ${LLVM_SRC}/llvm/tools/clang/test/CXX/drs/dr13xx.cpp -verify -fexceptions -fcxx-exceptions -pedantic-errors
    RUN("%clang_cc1 -std=c++98 %s -verify -fexceptions -fcxx-exceptions -pedantic-errors");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c++11 ${LLVM_SRC}/llvm/tools/clang/test/CXX/drs/dr13xx.cpp -verify -fexceptions -fcxx-exceptions -pedantic-errors
    RUN("%clang_cc1 -std=c++11 %s -verify -fexceptions -fcxx-exceptions -pedantic-errors");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c++14 ${LLVM_SRC}/llvm/tools/clang/test/CXX/drs/dr13xx.cpp -verify -fexceptions -fcxx-exceptions -pedantic-errors
    RUN("%clang_cc1 -std=c++14 %s -verify -fexceptions -fcxx-exceptions -pedantic-errors");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c++1z ${LLVM_SRC}/llvm/tools/clang/test/CXX/drs/dr13xx.cpp -verify -fexceptions -fcxx-exceptions -pedantic-errors
    RUN("%clang_cc1 -std=c++1z %s -verify -fexceptions -fcxx-exceptions -pedantic-errors");
  }

  @Test
  public void test_drs_dr14xx_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CXX/drs/dr14xx.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c++98 ${LLVM_SRC}/llvm/tools/clang/test/CXX/drs/dr14xx.cpp -verify -fexceptions -fcxx-exceptions -pedantic-errors
    RUN("%clang_cc1 -std=c++98 %s -verify -fexceptions -fcxx-exceptions -pedantic-errors");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c++11 ${LLVM_SRC}/llvm/tools/clang/test/CXX/drs/dr14xx.cpp -verify -fexceptions -fcxx-exceptions -pedantic-errors
    RUN("%clang_cc1 -std=c++11 %s -verify -fexceptions -fcxx-exceptions -pedantic-errors");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c++14 ${LLVM_SRC}/llvm/tools/clang/test/CXX/drs/dr14xx.cpp -verify -fexceptions -fcxx-exceptions -pedantic-errors
    RUN("%clang_cc1 -std=c++14 %s -verify -fexceptions -fcxx-exceptions -pedantic-errors");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c++1z ${LLVM_SRC}/llvm/tools/clang/test/CXX/drs/dr14xx.cpp -verify -fexceptions -fcxx-exceptions -pedantic-errors
    RUN("%clang_cc1 -std=c++1z %s -verify -fexceptions -fcxx-exceptions -pedantic-errors");
  }

  @Test
  public void test_drs_dr15xx_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CXX/drs/dr15xx.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c++98 -triple x86_64-unknown-unknown ${LLVM_SRC}/llvm/tools/clang/test/CXX/drs/dr15xx.cpp -verify -fexceptions -fcxx-exceptions -pedantic-errors
    RUN("%clang_cc1 -std=c++98 -triple x86_64-unknown-unknown %s -verify -fexceptions -fcxx-exceptions -pedantic-errors");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c++11 -triple x86_64-unknown-unknown ${LLVM_SRC}/llvm/tools/clang/test/CXX/drs/dr15xx.cpp -verify -fexceptions -fcxx-exceptions -pedantic-errors
    RUN("%clang_cc1 -std=c++11 -triple x86_64-unknown-unknown %s -verify -fexceptions -fcxx-exceptions -pedantic-errors");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c++14 -triple x86_64-unknown-unknown ${LLVM_SRC}/llvm/tools/clang/test/CXX/drs/dr15xx.cpp -verify -fexceptions -fcxx-exceptions -pedantic-errors
    RUN("%clang_cc1 -std=c++14 -triple x86_64-unknown-unknown %s -verify -fexceptions -fcxx-exceptions -pedantic-errors");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c++1z -triple x86_64-unknown-unknown ${LLVM_SRC}/llvm/tools/clang/test/CXX/drs/dr15xx.cpp -verify -fexceptions -fcxx-exceptions -pedantic-errors
    RUN("%clang_cc1 -std=c++1z -triple x86_64-unknown-unknown %s -verify -fexceptions -fcxx-exceptions -pedantic-errors");
  }

  @Test
  public void test_drs_dr16xx_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CXX/drs/dr16xx.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c++98 -triple x86_64-unknown-unknown ${LLVM_SRC}/llvm/tools/clang/test/CXX/drs/dr16xx.cpp -verify -fexceptions -fcxx-exceptions -pedantic-errors
    RUN("%clang_cc1 -std=c++98 -triple x86_64-unknown-unknown %s -verify -fexceptions -fcxx-exceptions -pedantic-errors");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c++11 -triple x86_64-unknown-unknown ${LLVM_SRC}/llvm/tools/clang/test/CXX/drs/dr16xx.cpp -verify -fexceptions -fcxx-exceptions -pedantic-errors
    RUN("%clang_cc1 -std=c++11 -triple x86_64-unknown-unknown %s -verify -fexceptions -fcxx-exceptions -pedantic-errors");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c++14 -triple x86_64-unknown-unknown ${LLVM_SRC}/llvm/tools/clang/test/CXX/drs/dr16xx.cpp -verify -fexceptions -fcxx-exceptions -pedantic-errors
    RUN("%clang_cc1 -std=c++14 -triple x86_64-unknown-unknown %s -verify -fexceptions -fcxx-exceptions -pedantic-errors");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c++1z -triple x86_64-unknown-unknown ${LLVM_SRC}/llvm/tools/clang/test/CXX/drs/dr16xx.cpp -verify -fexceptions -fcxx-exceptions -pedantic-errors
    RUN("%clang_cc1 -std=c++1z -triple x86_64-unknown-unknown %s -verify -fexceptions -fcxx-exceptions -pedantic-errors");
  }

  @Test
  public void test_drs_dr1748_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CXX/drs/dr1748.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c++98 ${LLVM_SRC}/llvm/tools/clang/test/CXX/drs/dr1748.cpp -triple x86_64-linux-gnu -emit-llvm -o - -fexceptions -fcxx-exceptions -pedantic-errors | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CXX/drs/dr1748.cpp
    RUN(TestState.Failed, "%clang_cc1 -std=c++98 %s -triple x86_64-linux-gnu -emit-llvm -o - -fexceptions -fcxx-exceptions -pedantic-errors")./*|*/
      I("FileCheck %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c++11 ${LLVM_SRC}/llvm/tools/clang/test/CXX/drs/dr1748.cpp -triple x86_64-linux-gnu -emit-llvm -o - -fexceptions -fcxx-exceptions -pedantic-errors | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CXX/drs/dr1748.cpp
    RUN(TestState.Failed, "%clang_cc1 -std=c++11 %s -triple x86_64-linux-gnu -emit-llvm -o - -fexceptions -fcxx-exceptions -pedantic-errors")./*|*/
      I("FileCheck %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c++14 ${LLVM_SRC}/llvm/tools/clang/test/CXX/drs/dr1748.cpp -triple x86_64-linux-gnu -emit-llvm -o - -fexceptions -fcxx-exceptions -pedantic-errors | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CXX/drs/dr1748.cpp
    RUN(TestState.Failed, "%clang_cc1 -std=c++14 %s -triple x86_64-linux-gnu -emit-llvm -o - -fexceptions -fcxx-exceptions -pedantic-errors")./*|*/
      I("FileCheck %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c++1z ${LLVM_SRC}/llvm/tools/clang/test/CXX/drs/dr1748.cpp -triple x86_64-linux-gnu -emit-llvm -o - -fexceptions -fcxx-exceptions -pedantic-errors | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CXX/drs/dr1748.cpp
    RUN(TestState.Failed, "%clang_cc1 -std=c++1z %s -triple x86_64-linux-gnu -emit-llvm -o - -fexceptions -fcxx-exceptions -pedantic-errors")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_drs_dr17xx_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CXX/drs/dr17xx.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c++98 ${LLVM_SRC}/llvm/tools/clang/test/CXX/drs/dr17xx.cpp -verify -fexceptions -fcxx-exceptions -pedantic-errors
    RUN("%clang_cc1 -std=c++98 %s -verify -fexceptions -fcxx-exceptions -pedantic-errors");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c++11 ${LLVM_SRC}/llvm/tools/clang/test/CXX/drs/dr17xx.cpp -verify -fexceptions -fcxx-exceptions -pedantic-errors
    RUN("%clang_cc1 -std=c++11 %s -verify -fexceptions -fcxx-exceptions -pedantic-errors");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c++14 ${LLVM_SRC}/llvm/tools/clang/test/CXX/drs/dr17xx.cpp -verify -fexceptions -fcxx-exceptions -pedantic-errors
    RUN("%clang_cc1 -std=c++14 %s -verify -fexceptions -fcxx-exceptions -pedantic-errors");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c++1z ${LLVM_SRC}/llvm/tools/clang/test/CXX/drs/dr17xx.cpp -verify -fexceptions -fcxx-exceptions -pedantic-errors
    RUN("%clang_cc1 -std=c++1z %s -verify -fexceptions -fcxx-exceptions -pedantic-errors");
  }

  @Test
  public void test_drs_dr18xx_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CXX/drs/dr18xx.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c++98 -triple x86_64-unknown-unknown ${LLVM_SRC}/llvm/tools/clang/test/CXX/drs/dr18xx.cpp -verify -fexceptions -fcxx-exceptions -pedantic-errors
    RUN("%clang_cc1 -std=c++98 -triple x86_64-unknown-unknown %s -verify -fexceptions -fcxx-exceptions -pedantic-errors");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c++11 -triple x86_64-unknown-unknown ${LLVM_SRC}/llvm/tools/clang/test/CXX/drs/dr18xx.cpp -verify -fexceptions -fcxx-exceptions -pedantic-errors
    RUN("%clang_cc1 -std=c++11 -triple x86_64-unknown-unknown %s -verify -fexceptions -fcxx-exceptions -pedantic-errors");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c++14 -triple x86_64-unknown-unknown ${LLVM_SRC}/llvm/tools/clang/test/CXX/drs/dr18xx.cpp -verify -fexceptions -fcxx-exceptions -pedantic-errors
    RUN("%clang_cc1 -std=c++14 -triple x86_64-unknown-unknown %s -verify -fexceptions -fcxx-exceptions -pedantic-errors");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c++1z -triple x86_64-unknown-unknown ${LLVM_SRC}/llvm/tools/clang/test/CXX/drs/dr18xx.cpp -verify -fexceptions -fcxx-exceptions -pedantic-errors
    RUN("%clang_cc1 -std=c++1z -triple x86_64-unknown-unknown %s -verify -fexceptions -fcxx-exceptions -pedantic-errors");
  }

  @Test
  public void test_drs_dr19xx_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CXX/drs/dr19xx.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c++98 ${LLVM_SRC}/llvm/tools/clang/test/CXX/drs/dr19xx.cpp -verify -fexceptions -fcxx-exceptions -pedantic-errors
    RUN("%clang_cc1 -std=c++98 %s -verify -fexceptions -fcxx-exceptions -pedantic-errors");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c++11 ${LLVM_SRC}/llvm/tools/clang/test/CXX/drs/dr19xx.cpp -verify -fexceptions -fcxx-exceptions -pedantic-errors
    RUN("%clang_cc1 -std=c++11 %s -verify -fexceptions -fcxx-exceptions -pedantic-errors");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c++14 ${LLVM_SRC}/llvm/tools/clang/test/CXX/drs/dr19xx.cpp -verify -fexceptions -fcxx-exceptions -pedantic-errors
    RUN("%clang_cc1 -std=c++14 %s -verify -fexceptions -fcxx-exceptions -pedantic-errors");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c++1z ${LLVM_SRC}/llvm/tools/clang/test/CXX/drs/dr19xx.cpp -verify -fexceptions -fcxx-exceptions -pedantic-errors
    RUN("%clang_cc1 -std=c++1z %s -verify -fexceptions -fcxx-exceptions -pedantic-errors");
  }

  @Test
  public void test_drs_dr1xx_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CXX/drs/dr1xx.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c++98 -triple x86_64-unknown-unknown ${LLVM_SRC}/llvm/tools/clang/test/CXX/drs/dr1xx.cpp -verify -fexceptions -fcxx-exceptions -pedantic-errors
    RUN("%clang_cc1 -std=c++98 -triple x86_64-unknown-unknown %s -verify -fexceptions -fcxx-exceptions -pedantic-errors");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c++11 -triple x86_64-unknown-unknown ${LLVM_SRC}/llvm/tools/clang/test/CXX/drs/dr1xx.cpp -verify -fexceptions -fcxx-exceptions -pedantic-errors
    RUN("%clang_cc1 -std=c++11 -triple x86_64-unknown-unknown %s -verify -fexceptions -fcxx-exceptions -pedantic-errors");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c++14 -triple x86_64-unknown-unknown ${LLVM_SRC}/llvm/tools/clang/test/CXX/drs/dr1xx.cpp -verify -fexceptions -fcxx-exceptions -pedantic-errors
    RUN("%clang_cc1 -std=c++14 -triple x86_64-unknown-unknown %s -verify -fexceptions -fcxx-exceptions -pedantic-errors");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c++1z -triple x86_64-unknown-unknown ${LLVM_SRC}/llvm/tools/clang/test/CXX/drs/dr1xx.cpp -verify -fexceptions -fcxx-exceptions -pedantic-errors
    RUN("%clang_cc1 -std=c++1z -triple x86_64-unknown-unknown %s -verify -fexceptions -fcxx-exceptions -pedantic-errors");
  }

  @Test
  public void test_drs_dr2xx_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CXX/drs/dr2xx.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c++98 ${LLVM_SRC}/llvm/tools/clang/test/CXX/drs/dr2xx.cpp -verify -fexceptions -fcxx-exceptions -pedantic-errors
    RUN("%clang_cc1 -std=c++98 %s -verify -fexceptions -fcxx-exceptions -pedantic-errors");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c++11 ${LLVM_SRC}/llvm/tools/clang/test/CXX/drs/dr2xx.cpp -verify -fexceptions -fcxx-exceptions -pedantic-errors
    RUN("%clang_cc1 -std=c++11 %s -verify -fexceptions -fcxx-exceptions -pedantic-errors");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c++14 ${LLVM_SRC}/llvm/tools/clang/test/CXX/drs/dr2xx.cpp -verify -fexceptions -fcxx-exceptions -pedantic-errors
    RUN("%clang_cc1 -std=c++14 %s -verify -fexceptions -fcxx-exceptions -pedantic-errors");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c++1z ${LLVM_SRC}/llvm/tools/clang/test/CXX/drs/dr2xx.cpp -verify -fexceptions -fcxx-exceptions -pedantic-errors
    RUN("%clang_cc1 -std=c++1z %s -verify -fexceptions -fcxx-exceptions -pedantic-errors");
  }

  @Test
  public void test_drs_dr3xx_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CXX/drs/dr3xx.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i386-pc-solaris2.11 -std=c++98 ${LLVM_SRC}/llvm/tools/clang/test/CXX/drs/dr3xx.cpp -verify -fexceptions -fcxx-exceptions -pedantic-errors
    RUN("%clang_cc1 -triple %itanium_abi_triple -std=c++98 %s -verify -fexceptions -fcxx-exceptions -pedantic-errors");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i386-pc-solaris2.11 -std=c++11 ${LLVM_SRC}/llvm/tools/clang/test/CXX/drs/dr3xx.cpp -verify -fexceptions -fcxx-exceptions -pedantic-errors
    RUN("%clang_cc1 -triple %itanium_abi_triple -std=c++11 %s -verify -fexceptions -fcxx-exceptions -pedantic-errors");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i386-pc-solaris2.11 -std=c++14 ${LLVM_SRC}/llvm/tools/clang/test/CXX/drs/dr3xx.cpp -verify -fexceptions -fcxx-exceptions -pedantic-errors
    RUN("%clang_cc1 -triple %itanium_abi_triple -std=c++14 %s -verify -fexceptions -fcxx-exceptions -pedantic-errors");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i386-pc-solaris2.11 -std=c++1z ${LLVM_SRC}/llvm/tools/clang/test/CXX/drs/dr3xx.cpp -verify -fexceptions -fcxx-exceptions -pedantic-errors
    RUN("%clang_cc1 -triple %itanium_abi_triple -std=c++1z %s -verify -fexceptions -fcxx-exceptions -pedantic-errors");
  }

  @Test
  public void test_drs_dr412_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CXX/drs/dr412.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c++98 ${LLVM_SRC}/llvm/tools/clang/test/CXX/drs/dr412.cpp -verify -fexceptions -fcxx-exceptions -pedantic-errors '-DNOEXCEPT="throw()"' '-DBAD_ALLOC="throw(std::bad_alloc)"'
    RUN("%clang_cc1 -std=c++98 %s -verify -fexceptions -fcxx-exceptions -pedantic-errors -DNOEXCEPT=\"throw()\" -DBAD_ALLOC=\"throw(std::bad_alloc)\"");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c++11 ${LLVM_SRC}/llvm/tools/clang/test/CXX/drs/dr412.cpp -verify -fexceptions -fcxx-exceptions -pedantic-errors -DNOEXCEPT=noexcept -DBAD_ALLOC=
    RUN("%clang_cc1 -std=c++11 %s -verify -fexceptions -fcxx-exceptions -pedantic-errors -DNOEXCEPT=noexcept -DBAD_ALLOC=");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c++14 ${LLVM_SRC}/llvm/tools/clang/test/CXX/drs/dr412.cpp -verify -fexceptions -fcxx-exceptions -pedantic-errors -DNOEXCEPT=noexcept -DBAD_ALLOC=
    RUN("%clang_cc1 -std=c++14 %s -verify -fexceptions -fcxx-exceptions -pedantic-errors -DNOEXCEPT=noexcept -DBAD_ALLOC=");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c++1z ${LLVM_SRC}/llvm/tools/clang/test/CXX/drs/dr412.cpp -verify -fexceptions -fcxx-exceptions -pedantic-errors -DNOEXCEPT=noexcept -DBAD_ALLOC=
    RUN("%clang_cc1 -std=c++1z %s -verify -fexceptions -fcxx-exceptions -pedantic-errors -DNOEXCEPT=noexcept -DBAD_ALLOC=");
  }

  @Test
  public void test_drs_dr4xx_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CXX/drs/dr4xx.cpp");
    // env ASAN_OPTIONS=detect_stack_use_after_return=0 ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c++98 ${LLVM_SRC}/llvm/tools/clang/test/CXX/drs/dr4xx.cpp -verify -fexceptions -fcxx-exceptions -pedantic-errors
    RUN(TestState.Failed, "env ASAN_OPTIONS=detect_stack_use_after_return=0 %clang_cc1 -std=c++98 %s -verify -fexceptions -fcxx-exceptions -pedantic-errors");
    // env ASAN_OPTIONS=detect_stack_use_after_return=0 ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c++11 ${LLVM_SRC}/llvm/tools/clang/test/CXX/drs/dr4xx.cpp -verify -fexceptions -fcxx-exceptions -pedantic-errors
    RUN(TestState.Failed, "env ASAN_OPTIONS=detect_stack_use_after_return=0 %clang_cc1 -std=c++11 %s -verify -fexceptions -fcxx-exceptions -pedantic-errors");
    // env ASAN_OPTIONS=detect_stack_use_after_return=0 ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c++14 ${LLVM_SRC}/llvm/tools/clang/test/CXX/drs/dr4xx.cpp -verify -fexceptions -fcxx-exceptions -pedantic-errors
    RUN(TestState.Failed, "env ASAN_OPTIONS=detect_stack_use_after_return=0 %clang_cc1 -std=c++14 %s -verify -fexceptions -fcxx-exceptions -pedantic-errors");
    // env ASAN_OPTIONS=detect_stack_use_after_return=0 ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c++1z ${LLVM_SRC}/llvm/tools/clang/test/CXX/drs/dr4xx.cpp -verify -fexceptions -fcxx-exceptions -pedantic-errors
    RUN(TestState.Failed, "env ASAN_OPTIONS=detect_stack_use_after_return=0 %clang_cc1 -std=c++1z %s -verify -fexceptions -fcxx-exceptions -pedantic-errors");
  }

  @Test
  public void test_drs_dr5xx_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CXX/drs/dr5xx.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c++98 ${LLVM_SRC}/llvm/tools/clang/test/CXX/drs/dr5xx.cpp -verify -fexceptions -fcxx-exceptions -pedantic-errors
    RUN(TestState.Failed, "%clang_cc1 -std=c++98 %s -verify -fexceptions -fcxx-exceptions -pedantic-errors");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c++11 ${LLVM_SRC}/llvm/tools/clang/test/CXX/drs/dr5xx.cpp -verify -fexceptions -fcxx-exceptions -pedantic-errors
    RUN("%clang_cc1 -std=c++11 %s -verify -fexceptions -fcxx-exceptions -pedantic-errors");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c++14 ${LLVM_SRC}/llvm/tools/clang/test/CXX/drs/dr5xx.cpp -verify -fexceptions -fcxx-exceptions -pedantic-errors
    RUN("%clang_cc1 -std=c++14 %s -verify -fexceptions -fcxx-exceptions -pedantic-errors");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c++1z ${LLVM_SRC}/llvm/tools/clang/test/CXX/drs/dr5xx.cpp -verify -fexceptions -fcxx-exceptions -pedantic-errors
    RUN("%clang_cc1 -std=c++1z %s -verify -fexceptions -fcxx-exceptions -pedantic-errors");
  }

  @Test
  public void test_drs_dr6xx_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CXX/drs/dr6xx.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c++98 ${LLVM_SRC}/llvm/tools/clang/test/CXX/drs/dr6xx.cpp -verify -fexceptions -fcxx-exceptions -pedantic-errors
    RUN("%clang_cc1 -std=c++98 %s -verify -fexceptions -fcxx-exceptions -pedantic-errors");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c++11 ${LLVM_SRC}/llvm/tools/clang/test/CXX/drs/dr6xx.cpp -verify -fexceptions -fcxx-exceptions -pedantic-errors
    RUN("%clang_cc1 -std=c++11 %s -verify -fexceptions -fcxx-exceptions -pedantic-errors");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c++14 ${LLVM_SRC}/llvm/tools/clang/test/CXX/drs/dr6xx.cpp -verify -fexceptions -fcxx-exceptions -pedantic-errors
    RUN("%clang_cc1 -std=c++14 %s -verify -fexceptions -fcxx-exceptions -pedantic-errors");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c++1z ${LLVM_SRC}/llvm/tools/clang/test/CXX/drs/dr6xx.cpp -verify -fexceptions -fcxx-exceptions -pedantic-errors
    RUN("%clang_cc1 -std=c++1z %s -verify -fexceptions -fcxx-exceptions -pedantic-errors");
  }

  @Test
  public void test_drs_dr7xx_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CXX/drs/dr7xx.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c++98 ${LLVM_SRC}/llvm/tools/clang/test/CXX/drs/dr7xx.cpp -verify -fexceptions -fcxx-exceptions -pedantic-errors
    RUN("%clang_cc1 -std=c++98 %s -verify -fexceptions -fcxx-exceptions -pedantic-errors");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c++11 ${LLVM_SRC}/llvm/tools/clang/test/CXX/drs/dr7xx.cpp -verify -fexceptions -fcxx-exceptions -pedantic-errors
    RUN("%clang_cc1 -std=c++11 %s -verify -fexceptions -fcxx-exceptions -pedantic-errors");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c++14 ${LLVM_SRC}/llvm/tools/clang/test/CXX/drs/dr7xx.cpp -verify -fexceptions -fcxx-exceptions -pedantic-errors
    RUN("%clang_cc1 -std=c++14 %s -verify -fexceptions -fcxx-exceptions -pedantic-errors");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c++1z ${LLVM_SRC}/llvm/tools/clang/test/CXX/drs/dr7xx.cpp -verify -fexceptions -fcxx-exceptions -pedantic-errors
    RUN("%clang_cc1 -std=c++1z %s -verify -fexceptions -fcxx-exceptions -pedantic-errors");
  }

  @Test
  public void test_drs_dr9xx_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CXX/drs/dr9xx.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c++98 ${LLVM_SRC}/llvm/tools/clang/test/CXX/drs/dr9xx.cpp -verify -fexceptions -fcxx-exceptions -pedantic-errors
    RUN("%clang_cc1 -std=c++98 %s -verify -fexceptions -fcxx-exceptions -pedantic-errors");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c++11 ${LLVM_SRC}/llvm/tools/clang/test/CXX/drs/dr9xx.cpp -verify -fexceptions -fcxx-exceptions -pedantic-errors
    RUN("%clang_cc1 -std=c++11 %s -verify -fexceptions -fcxx-exceptions -pedantic-errors");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c++14 ${LLVM_SRC}/llvm/tools/clang/test/CXX/drs/dr9xx.cpp -verify -fexceptions -fcxx-exceptions -pedantic-errors
    RUN("%clang_cc1 -std=c++14 %s -verify -fexceptions -fcxx-exceptions -pedantic-errors");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c++1z ${LLVM_SRC}/llvm/tools/clang/test/CXX/drs/dr9xx.cpp -verify -fexceptions -fcxx-exceptions -pedantic-errors
    RUN("%clang_cc1 -std=c++1z %s -verify -fexceptions -fcxx-exceptions -pedantic-errors");
  }
  
}
