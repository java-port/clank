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
 * Collection of all test files from test/SemaCXX folder
 * @author Vladimir Voskresensky
 */
public class AllSemaCXXTest extends DriverTestFileBase {
  private static final String TEST_LOCATION = "${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/";
  public AllSemaCXXTest() {
    super(TEST_LOCATION, TestState.Successful);
  }
  
  public static void main(String[] args) {
    // Print tests which will be accepted per test case
    DriverTestFileBase.printAllTestFiles(false, TEST_LOCATION, (test)->true, 
            "${SPUTNIK}/modules/org.clang.sema/test/unit/src/org/clang/sema/test/AllSemaCXXTest.txt");
  }  
  
  @Override
  protected boolean keepStacksForUnimplementedMethods() {
    return false;
  }
  
  @Test
  public void test_2008_01_11_BadWarning_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/2008-01-11-BadWarning.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -Wall ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/2008-01-11-BadWarning.cpp
    RUN("%clang_cc1 -fsyntax-only -verify -Wall %s");
  }

  @Test
  public void test_MicrosoftCompatibility_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/MicrosoftCompatibility.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/MicrosoftCompatibility.cpp -triple i686-pc-win32 -fsyntax-only -std=c++11 -Wmicrosoft -verify -fms-compatibility -fexceptions -fcxx-exceptions -fms-compatibility-version=19.00
    RUN("%clang_cc1 %s -triple i686-pc-win32 -fsyntax-only -std=c++11 -Wmicrosoft -verify -fms-compatibility -fexceptions -fcxx-exceptions -fms-compatibility-version=19.00");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/MicrosoftCompatibility.cpp -triple i686-pc-win32 -fsyntax-only -std=c++11 -Wmicrosoft -verify -fms-compatibility -fexceptions -fcxx-exceptions -fms-compatibility-version=18.00
    RUN("%clang_cc1 %s -triple i686-pc-win32 -fsyntax-only -std=c++11 -Wmicrosoft -verify -fms-compatibility -fexceptions -fcxx-exceptions -fms-compatibility-version=18.00");
  }

  @Test
  public void test_MicrosoftCompatibility_cxx98_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/MicrosoftCompatibility-cxx98.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/MicrosoftCompatibility-cxx98.cpp -triple i686-pc-win32 -fsyntax-only -std=c++98 -Wmicrosoft -verify -fms-compatibility -fexceptions -fcxx-exceptions
    RUN("%clang_cc1 %s -triple i686-pc-win32 -fsyntax-only -std=c++98 -Wmicrosoft -verify -fms-compatibility -fexceptions -fcxx-exceptions");
  }

  @Test
  public void test_MicrosoftCompatibilityNoExceptions_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/MicrosoftCompatibilityNoExceptions.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/MicrosoftCompatibilityNoExceptions.cpp -fsyntax-only -verify -fms-compatibility
    RUN("%clang_cc1 %s -fsyntax-only -verify -fms-compatibility");
  }

  @Test
  public void test_MicrosoftExtensions_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/MicrosoftExtensions.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/MicrosoftExtensions.cpp -triple i686-pc-win32 -fsyntax-only -Wmicrosoft -Wc++11-extensions -Wno-long-long -verify -fms-extensions -fexceptions -fcxx-exceptions -DTEST1
    RUN("%clang_cc1 %s -triple i686-pc-win32 -fsyntax-only -Wmicrosoft -Wc++11-extensions -Wno-long-long -verify -fms-extensions -fexceptions -fcxx-exceptions -DTEST1");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/MicrosoftExtensions.cpp -triple i686-pc-win32 -fsyntax-only -Wmicrosoft -Wc++11-extensions -Wno-long-long -verify -fexceptions -fcxx-exceptions -DTEST2
    RUN("%clang_cc1 %s -triple i686-pc-win32 -fsyntax-only -Wmicrosoft -Wc++11-extensions -Wno-long-long -verify -fexceptions -fcxx-exceptions -DTEST2");
  }

  @Test
  public void test_MicrosoftSuper_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/MicrosoftSuper.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/MicrosoftSuper.cpp -fsyntax-only -fms-extensions -std=c++11 -verify
    RUN("%clang_cc1 %s -fsyntax-only -fms-extensions -std=c++11 -verify");
  }

  @Test
  public void test_PR10177_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/PR10177.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -std=c++11 -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/PR10177.cpp
    RUN("%clang_cc1 -fsyntax-only -std=c++11 -verify %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -std=c++1y -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/PR10177.cpp -DCXX1Y
    RUN("%clang_cc1 -fsyntax-only -std=c++1y -verify %s -DCXX1Y");
  }

  @Test
  public void test_PR10243_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/PR10243.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -std=c++11 ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/PR10243.cpp
    RUN("%clang_cc1 -fsyntax-only -verify -std=c++11 %s");
  }

  @Test
  public void test_PR10447_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/PR10447.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/PR10447.cpp
    RUN("%clang_cc1 -verify %s");
  }

  @Test
  public void test_PR10458_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/PR10458.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/PR10458.cpp -std=c++98
    RUN("%clang_cc1 -fsyntax-only -verify %s -std=c++98");
  }

  @Test
  public void test_PR11358_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/PR11358.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/PR11358.cpp -verify
    RUN("%clang_cc1 %s -verify");
  }

  @Test
  public void test_PR12481_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/PR12481.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x c++ -fsyntax-only ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/PR12481.cpp
    RUN("%clang_cc1 -x c++ -fsyntax-only %s");
  }

  @Test
  public void test_PR12778_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/PR12778.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/PR12778.cpp
    RUN("%clang_cc1 -fsyntax-only -verify %s");
  }

  @Test
  public void test_PR16677_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/PR16677.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -std=c++11 -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/PR16677.cpp
    RUN("%clang_cc1 -fsyntax-only -std=c++11 -verify %s");
  }

  @Test
  public void test_PR19955_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/PR19955.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i686-win32 -verify -std=c++11 ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/PR19955.cpp
    RUN("%clang_cc1 -triple i686-win32 -verify -std=c++11 %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i686-mingw32 -verify -std=c++11 ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/PR19955.cpp
    RUN("%clang_cc1 -triple i686-mingw32 -verify -std=c++11 %s");
  }

  @Test
  public void test_PR20110_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/PR20110.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/PR20110.cpp
    RUN("%clang_cc1 -fsyntax-only -verify %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -std=c++11 ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/PR20110.cpp
    RUN("%clang_cc1 -fsyntax-only -verify -std=c++11 %s");
  }

  @Test
  public void test_PR20334_std_initializer_list_diagnosis_assertion_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/PR20334-std_initializer_list_diagnosis_assertion.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c++11 -verify -emit-llvm-only ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/PR20334-std_initializer_list_diagnosis_assertion.cpp
    RUN(TestState.SemanticErrors, "%clang_cc1 -std=c++11 -verify -emit-llvm-only %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c++98 -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/PR20334-std_initializer_list_diagnosis_assertion.cpp -DCPP98
    RUN(TestState.Failed, "%clang_cc1 -std=c++98 -fsyntax-only -verify %s -DCPP98");
  }

  @Test
  public void test_PR20705_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/PR20705.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -std=c++11 -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/PR20705.cpp
    RUN("%clang_cc1 -fsyntax-only -std=c++11 -verify %s");
  }

  @Test
  public void test_PR21679_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/PR21679.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/PR21679.cpp
    RUN("%clang_cc1 -fsyntax-only -verify %s");
  }

  @Test
  public void test_PR23334_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/PR23334.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c++11 -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/PR23334.cpp -Wno-unused
    RUN("%clang_cc1 -std=c++11 -verify %s -Wno-unused");
  }

  @Test
  public void test_PR5086_ambig_resolution_enum_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/PR5086-ambig-resolution-enum.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/PR5086-ambig-resolution-enum.cpp -std=c++11
    RUN("%clang_cc1 -fsyntax-only -verify %s -std=c++11");
  }

  @Test
  public void test_PR6562_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/PR6562.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/PR6562.cpp
    RUN("%clang_cc1 -fsyntax-only -verify %s");
  }

  @Test
  public void test_PR6618_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/PR6618.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/PR6618.cpp
    RUN("%clang_cc1 -fsyntax-only -verify %s");
  }

  @Test
  public void test_PR7410_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/PR7410.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/PR7410.cpp
    RUN("%clang_cc1 -fsyntax-only -verify %s");
  }

  @Test
  public void test_PR7944_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/PR7944.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/PR7944.cpp
    RUN("%clang_cc1 -fsyntax-only -verify %s");
  }

  @Test
  public void test_PR8012_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/PR8012.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/PR8012.cpp -std=c++11
    RUN("%clang_cc1 -fsyntax-only -verify %s -std=c++11");
  }

  @Test
  public void test_PR8385_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/PR8385.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/PR8385.cpp
    RUN("not %clang_cc1 -fsyntax-only %s");
  }

  @Test
  public void test_PR8755_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/PR8755.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/PR8755.cpp
    RUN("%clang_cc1 -fsyntax-only -verify %s");
  }

  @Test
  public void test_PR8884_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/PR8884.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/PR8884.cpp
    RUN("%clang_cc1 -fsyntax-only  %s");
  }

  @Test
  public void test_PR9459_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/PR9459.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/PR9459.cpp
    RUN("%clang_cc1 -fsyntax-only -verify %s");
  }

  @Test
  public void test_PR9460_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/PR9460.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/PR9460.cpp
    RUN("%clang_cc1 -fsyntax-only -verify %s");
  }

  @Test
  public void test_PR9461_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/PR9461.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/PR9461.cpp
    RUN("%clang_cc1 -fsyntax-only -verify %s");
  }

  @Test
  public void test_PR9572_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/PR9572.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/PR9572.cpp
    RUN("%clang_cc1 -fsyntax-only -verify %s");
  }

  @Test
  public void test_PR9884_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/PR9884.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/PR9884.cpp
    RUN("%clang_cc1 -fsyntax-only -verify %s");
  }

  @Test
  public void test_PR9902_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/PR9902.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -std=c++11 ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/PR9902.cpp
    RUN("%clang_cc1 -fsyntax-only -verify -std=c++11 %s");
  }

  @Test
  public void test_PR9908_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/PR9908.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -std=c++11 ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/PR9908.cpp
    RUN("%clang_cc1 -fsyntax-only -verify -std=c++11 %s");
  }

  @Test
  public void test___null_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/__null.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-unknown-unknown ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/__null.cpp -Wno-null-conversion -fsyntax-only -verify
    RUN("%clang_cc1 -triple x86_64-unknown-unknown %s -Wno-null-conversion -fsyntax-only -verify");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i686-unknown-unknown ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/__null.cpp -Wno-null-conversion -fsyntax-only -verify
    RUN("%clang_cc1 -triple i686-unknown-unknown %s -Wno-null-conversion -fsyntax-only -verify");
  }

  @Test
  public void test___try_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/__try.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-windows -fsyntax-only -verify -fborland-extensions -fcxx-exceptions ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/__try.cpp
    RUN("%clang_cc1 -triple x86_64-windows -fsyntax-only -verify -fborland-extensions -fcxx-exceptions %s");
  }

  @Test
  public void test_abstract_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/abstract.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/abstract.cpp -std=c++11 -Wabstract-vbase-init
    RUN("%clang_cc1 -fsyntax-only -verify %s -std=c++11 -Wabstract-vbase-init");
  }

  @Test
  public void test_access_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/access.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c++11 -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/access.cpp
    RUN("%clang_cc1 -std=c++11 -fsyntax-only -verify %s");
  }

  @Test
  public void test_access_base_class_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/access-base-class.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/access-base-class.cpp
    RUN("%clang_cc1 -fsyntax-only -verify %s");
  }

  @Test
  public void test_access_control_check_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/access-control-check.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/access-control-check.cpp
    RUN("%clang_cc1 -fsyntax-only -verify %s");
  }

  @Test
  public void test_access_member_pointer_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/access-member-pointer.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/access-member-pointer.cpp
    RUN("%clang_cc1 -fsyntax-only -verify %s");
  }

  @Test
  public void test_accessible_base_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/accessible-base.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/accessible-base.cpp
    RUN("%clang_cc1 -fsyntax-only -verify %s");
  }

  @Test
  public void test_addr_of_overloaded_function_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/addr-of-overloaded-function.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/addr-of-overloaded-function.cpp
    RUN("%clang_cc1 -fsyntax-only -verify %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -std=c++98 ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/addr-of-overloaded-function.cpp
    RUN("%clang_cc1 -fsyntax-only -verify -std=c++98 %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -std=c++11 ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/addr-of-overloaded-function.cpp
    RUN("%clang_cc1 -fsyntax-only -verify -std=c++11 %s");
  }

  @Test
  public void test_addr_of_overloaded_function_casting_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/addr-of-overloaded-function-casting.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/addr-of-overloaded-function-casting.cpp
    RUN("%clang_cc1 -fsyntax-only -verify %s");
  }

  @Test
  public void test_address_of_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/address-of.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/address-of.cpp
    RUN("%clang_cc1 -fsyntax-only -verify %s");
  }

  @Test
  public void test_address_of_temporary_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/address-of-temporary.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -Wno-error=address-of-temporary -verify -std=gnu++11 ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/address-of-temporary.cpp
    RUN("%clang_cc1 -fsyntax-only -Wno-error=address-of-temporary -verify -std=gnu++11 %s");
  }

  @Test
  public void test_address_space_conversion_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/address-space-conversion.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/address-space-conversion.cpp
    RUN("%clang_cc1 -fsyntax-only -verify %s");
  }

  @Test
  public void test_address_space_initialize_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/address-space-initialize.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/address-space-initialize.cpp
    RUN("%clang_cc1 -fsyntax-only -verify %s");
  }

  @Test
  public void test_address_space_newdelete_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/address-space-newdelete.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/address-space-newdelete.cpp
    RUN("%clang_cc1 -fsyntax-only -verify %s");
  }

  @Test
  public void test_address_space_references_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/address-space-references.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/address-space-references.cpp
    RUN("%clang_cc1 -fsyntax-only -verify %s");
  }

  @Test
  public void test_aggregate_initialization_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/aggregate-initialization.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -std=c++11 ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/aggregate-initialization.cpp
    RUN("%clang_cc1 -fsyntax-only -verify -std=c++11 %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -std=c++14 ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/aggregate-initialization.cpp
    RUN("%clang_cc1 -fsyntax-only -verify -std=c++14 %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -std=c++1z ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/aggregate-initialization.cpp
    RUN("%clang_cc1 -fsyntax-only -verify -std=c++1z %s");
  }

  @Test
  public void test_alias_template_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/alias-template.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -verify -std=c++11 ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/alias-template.cpp
    RUN("%clang_cc1 -verify -std=c++11 %s");
  }

  @Test
  public void test_align_value_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/align_value.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/align_value.cpp
    RUN("%clang_cc1 -fsyntax-only -verify %s");
  }

  @Test
  public void test_alignment_of_derived_class_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/alignment-of-derived-class.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/alignment-of-derived-class.cpp -std=c++11
    RUN("%clang_cc1 -fsyntax-only -verify %s -std=c++11");
  }

  @Test
  public void test_alignof_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/alignof.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c++11 -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/alignof.cpp
    RUN("%clang_cc1 -std=c++11 -fsyntax-only -verify %s");
  }

  @Test
  public void test_alignof_sizeof_reference_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/alignof-sizeof-reference.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c++11 -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/alignof-sizeof-reference.cpp
    RUN("%clang_cc1 -std=c++11 -fsyntax-only -verify %s");
  }

  @Test
  public void test_altivec_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/altivec.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -faltivec -fno-lax-vector-conversions -triple powerpc-unknown-unknown -fcxx-exceptions -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/altivec.cpp
    RUN("%clang_cc1 -faltivec -fno-lax-vector-conversions -triple powerpc-unknown-unknown -fcxx-exceptions -verify %s");
  }

  @Test
  public void test_ambig_user_defined_conversions_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/ambig-user-defined-conversions.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/ambig-user-defined-conversions.cpp
    RUN("%clang_cc1 -fsyntax-only -verify %s");
  }

  @Test
  public void test_ambiguous_builtin_unary_operator_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/ambiguous-builtin-unary-operator.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/ambiguous-builtin-unary-operator.cpp -std=c++11
    RUN("%clang_cc1 -fsyntax-only -verify %s -std=c++11");
  }

  @Test
  public void test_ambiguous_conversion_show_overload_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/ambiguous-conversion-show-overload.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -fshow-overloads=best -fno-caret-diagnostics ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/ambiguous-conversion-show-overload.cpp 2>&1 | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/ambiguous-conversion-show-overload.cpp
    RUN("not %clang_cc1 -fsyntax-only -fshow-overloads=best -fno-caret-diagnostics %s 2>&1")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_anonymous_struct_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/anonymous-struct.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/anonymous-struct.cpp
    RUN("%clang_cc1 -fsyntax-only -verify %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -std=c++98 ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/anonymous-struct.cpp
    RUN("%clang_cc1 -fsyntax-only -verify -std=c++98 %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -std=c++11 ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/anonymous-struct.cpp
    RUN("%clang_cc1 -fsyntax-only -verify -std=c++11 %s");
  }

  @Test
  public void test_anonymous_union_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/anonymous-union.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -pedantic ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/anonymous-union.cpp
    RUN("%clang_cc1 -fsyntax-only -verify -pedantic %s");
  }

  @Test
  public void test_anonymous_union_cxx11_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/anonymous-union-cxx11.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c++11 -fsyntax-only -verify -pedantic ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/anonymous-union-cxx11.cpp
    RUN("%clang_cc1 -std=c++11 -fsyntax-only -verify -pedantic %s");
  }

  @Test
  public void test_array_bound_merge_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/array-bound-merge.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/array-bound-merge.cpp
    RUN("%clang_cc1 -fsyntax-only -verify %s");
  }

  @Test
  public void test_array_bounds_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/array-bounds.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/array-bounds.cpp
    RUN("%clang_cc1 -verify %s");
  }

  @Test
  public void test_array_bounds_ptr_arith_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/array-bounds-ptr-arith.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -verify -Wno-string-plus-int -Warray-bounds-pointer-arithmetic ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/array-bounds-ptr-arith.cpp
    RUN("%clang_cc1 -verify -Wno-string-plus-int -Warray-bounds-pointer-arithmetic %s");
  }

  @Test
  public void test_array_bounds_system_header_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/array-bounds-system-header.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -isystem ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/Inputs -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/array-bounds-system-header.cpp
    RUN("%clang_cc1 -isystem %S/Inputs -verify %s");
  }

  @Test
  public void test_arrow_operator_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/arrow-operator.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/arrow-operator.cpp
    RUN("%clang_cc1 -fsyntax-only -verify %s");
  }

  @Test
  public void test_ast_print_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/ast-print.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i386-pc-win32 -ast-print ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/ast-print.cpp -std=gnu++11 | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/ast-print.cpp
    RUN("%clang_cc1 -triple %ms_abi_triple -ast-print %s -std=gnu++11")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_atomic_ops_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/atomic-ops.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/atomic-ops.cpp -verify -fsyntax-only -triple=i686-linux-gnu -std=c++11
    RUN("%clang_cc1 %s -verify -fsyntax-only -triple=i686-linux-gnu -std=c++11");
  }

  @Test
  public void test_atomic_type_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/atomic-type.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -verify -pedantic ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/atomic-type.cpp -std=c++98
    RUN("%clang_cc1 -verify -pedantic %s -std=c++98");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -verify -pedantic ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/atomic-type.cpp -std=c++11
    RUN("%clang_cc1 -verify -pedantic %s -std=c++11");
  }

  @Test
  public void test_attr_abi_tag_syntax_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/attr-abi-tag-syntax.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c++11 -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/attr-abi-tag-syntax.cpp
    RUN("%clang_cc1 -std=c++11 -fsyntax-only -verify %s");
  }

  @Test
  public void test_attr_after_definition_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/attr-after-definition.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/attr-after-definition.cpp
    RUN("%clang_cc1 -fsyntax-only -verify %s");
  }

  @Test
  public void test_attr_aligned_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/attr-aligned.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c++11 -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/attr-aligned.cpp
    RUN("%clang_cc1 -std=c++11 -fsyntax-only -verify %s");
  }

  @Test
  public void test_attr_cleanup_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/attr-cleanup.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/attr-cleanup.cpp -verify -fsyntax-only -Wno-gcc-compat
    RUN("%clang_cc1 %s -verify -fsyntax-only -Wno-gcc-compat");
  }

  @Test
  public void test_attr_cleanup_gcc_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/attr-cleanup-gcc.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/attr-cleanup-gcc.cpp -verify -fsyntax-only -Wgcc-compat
    RUN("%clang_cc1 %s -verify -fsyntax-only -Wgcc-compat");
  }

  @Test
  public void test_attr_common_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/attr-common.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/attr-common.cpp
    RUN("%clang_cc1 -fsyntax-only -verify %s");
  }

  @Test
  public void test_attr_cxx0x_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/attr-cxx0x.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -fcxx-exceptions -verify -pedantic -std=c++11 ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/attr-cxx0x.cpp
    RUN("%clang_cc1 -fsyntax-only -fcxx-exceptions -verify -pedantic -std=c++11 %s");
  }

  @Test
  public void test_attr_cxx0x_fixit_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/attr-cxx0x-fixit.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -std=c++11 ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/attr-cxx0x-fixit.cpp
    RUN("%clang_cc1 -fsyntax-only -verify -std=c++11 %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -fdiagnostics-parseable-fixits -std=c++11 ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/attr-cxx0x-fixit.cpp 2>&1 | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/attr-cxx0x-fixit.cpp
    RUN("not %clang_cc1 -fsyntax-only -fdiagnostics-parseable-fixits -std=c++11 %s 2>&1")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_attr_declspec_ignored_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/attr-declspec-ignored.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/attr-declspec-ignored.cpp -verify -fsyntax-only
    RUN("%clang_cc1 %s -verify -fsyntax-only");
  }

  @Test
  public void test_attr_deprecated_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/attr-deprecated.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/attr-deprecated.cpp -verify -fexceptions
    RUN("%clang_cc1 %s -verify -fexceptions");
  }

  @Test
  public void test_attr_deprecated_replacement_error_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/attr-deprecated-replacement-error.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-apple-darwin9 -verify -fsyntax-only -std=c++11 -fms-extensions ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/attr-deprecated-replacement-error.cpp
    RUN("%clang_cc1 -triple x86_64-apple-darwin9 -verify -fsyntax-only -std=c++11 -fms-extensions %s");
  }

  @Test
  public void test_attr_deprecated_replacement_fixit_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/attr-deprecated-replacement-fixit.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-apple-darwin9 -verify -fsyntax-only ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/attr-deprecated-replacement-fixit.cpp
    RUN("%clang_cc1 -triple x86_64-apple-darwin9 -verify -fsyntax-only %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-apple-darwin9 -fdiagnostics-parseable-fixits ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/attr-deprecated-replacement-fixit.cpp 2>&1 | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/attr-deprecated-replacement-fixit.cpp
    RUN("%clang_cc1 -triple x86_64-apple-darwin9 -fdiagnostics-parseable-fixits %s 2>&1")./*|*/
      I("FileCheck %s");
    // cp ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/attr-deprecated-replacement-fixit.cpp ${TEST_TEMP_DIR}/attr-deprecated-replacement-fixit.cpp.tmp
    RUN("cp %s %t");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-apple-darwin9 -fixit ${TEST_TEMP_DIR}/attr-deprecated-replacement-fixit.cpp.tmp
    RUN("%clang_cc1 -triple x86_64-apple-darwin9 -fixit %t");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-apple-darwin9 -Werror ${TEST_TEMP_DIR}/attr-deprecated-replacement-fixit.cpp.tmp
    RUN("%clang_cc1 -triple x86_64-apple-darwin9 -Werror %t");
  }

  @Test
  public void test_attr_disable_tail_calls_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/attr-disable-tail-calls.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c++11 -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/attr-disable-tail-calls.cpp
    RUN("%clang_cc1 -std=c++11 -fsyntax-only -verify %s");
  }

  @Test
  public void test_attr_flag_enum_reject_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/attr-flag-enum-reject.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -verify -fsyntax-only -x c++ -Wassign-enum ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/attr-flag-enum-reject.cpp
    RUN("%clang_cc1 -verify -fsyntax-only -x c++ -Wassign-enum %s");
  }

  @Test
  public void test_attr_flatten_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/attr-flatten.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c++11 -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/attr-flatten.cpp
    RUN("%clang_cc1 -std=c++11 -fsyntax-only -verify %s");
  }

  @Test
  public void test_attr_format_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/attr-format.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -Wformat-nonliteral -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/attr-format.cpp
    RUN("%clang_cc1 -fsyntax-only -Wformat-nonliteral -verify %s");
  }

  @Test
  public void test_attr_gnu_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/attr-gnu.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=gnu++11 -fsyntax-only -fms-compatibility -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/attr-gnu.cpp
    RUN("%clang_cc1 -std=gnu++11 -fsyntax-only -fms-compatibility -verify %s");
  }

  @Test
  public void test_attr_lto_visibility_public_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/attr-lto-visibility-public.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c++11 -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/attr-lto-visibility-public.cpp
    RUN("%clang_cc1 -std=c++11 -fsyntax-only -verify %s");
  }

  @Test
  public void test_attr_mode_tmpl_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/attr-mode-tmpl.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/attr-mode-tmpl.cpp
    RUN("%clang_cc1 -fsyntax-only -verify %s");
  }

  @Test
  public void test_attr_no_sanitize_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/attr-no-sanitize.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c++11 -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/attr-no-sanitize.cpp
    RUN("%clang_cc1 -std=c++11 -fsyntax-only -verify %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c++11 -ast-dump ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/attr-no-sanitize.cpp | ${LLVM_SRC}/build/bin/FileCheck --check-prefix=DUMP ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/attr-no-sanitize.cpp
    RUN("not %clang_cc1 -std=c++11 -ast-dump %s")./*|*/
      I("FileCheck --check-prefix=DUMP %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c++11 -ast-print ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/attr-no-sanitize.cpp | ${LLVM_SRC}/build/bin/FileCheck --check-prefix=PRINT ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/attr-no-sanitize.cpp
    RUN("not %clang_cc1 -std=c++11 -ast-print %s")./*|*/
      I("FileCheck --check-prefix=PRINT %s");
  }

  @Test
  public void test_attr_no_sanitize_address_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/attr-no-sanitize-address.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/attr-no-sanitize-address.cpp
    RUN("%clang_cc1 -fsyntax-only -verify  %s");
  }

  @Test
  public void test_attr_no_sanitize_memory_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/attr-no-sanitize-memory.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/attr-no-sanitize-memory.cpp
    RUN("%clang_cc1 -fsyntax-only -verify  %s");
  }

  @Test
  public void test_attr_no_sanitize_thread_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/attr-no-sanitize-thread.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/attr-no-sanitize-thread.cpp
    RUN("%clang_cc1 -fsyntax-only -verify  %s");
  }

  @Test
  public void test_attr_no_split_stack_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/attr-no-split-stack.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c++11 -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/attr-no-split-stack.cpp
    RUN("%clang_cc1 -std=c++11 -fsyntax-only -verify %s");
  }

  @Test
  public void test_attr_nodebug_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/attr-nodebug.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/attr-nodebug.cpp -std=c++11 -verify -fsyntax-only
    RUN("%clang_cc1 %s -std=c++11 -verify -fsyntax-only");
  }

  @Test
  public void test_attr_nonnull_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/attr-nonnull.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/attr-nonnull.cpp
    RUN("%clang_cc1 -fsyntax-only -verify %s");
  }

  @Test
  public void test_attr_noreturn_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/attr-noreturn.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/attr-noreturn.cpp
    RUN("%clang_cc1 -fsyntax-only -verify %s");
  }

  @Test
  public void test_attr_notail_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/attr-notail.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c++11 -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/attr-notail.cpp
    RUN("%clang_cc1 -std=c++11 -fsyntax-only -verify %s");
  }

  @Test
  public void test_attr_optnone_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/attr-optnone.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c++11 -fms-compatibility -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/attr-optnone.cpp
    RUN("%clang_cc1 -std=c++11 -fms-compatibility -fsyntax-only -verify %s");
  }

  @Test
  public void test_attr_print_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/attr-print.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/attr-print.cpp -ast-print -fms-extensions | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/attr-print.cpp
    RUN("%clang_cc1 %s -ast-print -fms-extensions")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_attr_regparm_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/attr-regparm.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -triple x86_64-pc-linux-gnu ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/attr-regparm.cpp
    RUN("%clang_cc1 -fsyntax-only -verify -triple x86_64-pc-linux-gnu %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -triple i686-apple-darwin10 ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/attr-regparm.cpp
    RUN("%clang_cc1 -fsyntax-only -verify -triple i686-apple-darwin10 %s");
  }

  @Test
  public void test_attr_selectany_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/attr-selectany.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fms-compatibility -fms-extensions -fsyntax-only -verify -std=c++11 ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/attr-selectany.cpp
    RUN("%clang_cc1 -fms-compatibility -fms-extensions -fsyntax-only -verify -std=c++11 %s");
  }

  @Test
  public void test_attr_sentinel_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/attr-sentinel.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/attr-sentinel.cpp
    RUN("%clang_cc1 -fsyntax-only -verify %s");
  }

  @Test
  public void test_attr_swiftcall_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/attr-swiftcall.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-apple-darwin10 -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/attr-swiftcall.cpp
    RUN("%clang_cc1 -triple x86_64-apple-darwin10 -fsyntax-only -verify %s");
  }

  @Test
  public void test_attr_unavailable_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/attr-unavailable.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/attr-unavailable.cpp
    RUN("%clang_cc1 -fsyntax-only -verify %s");
  }

  @Test
  public void test_attr_unused_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/attr-unused.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -verify -Wunused -Wused-but-marked-unused -fsyntax-only ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/attr-unused.cpp
    RUN("%clang_cc1 -verify -Wunused -Wused-but-marked-unused -fsyntax-only %s");
  }

  @Test
  public void test_attr_used_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/attr-used.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/attr-used.cpp
    RUN("%clang_cc1 -fsyntax-only -verify %s");
  }

  @Test
  public void test_attr_visibility_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/attr-visibility.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/attr-visibility.cpp
    RUN("%clang_cc1 -fsyntax-only -verify %s");
  }

  @Test
  public void test_attr_weak_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/attr-weak.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-pc-linux-gnu -fsyntax-only -verify -std=c++11 ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/attr-weak.cpp
    RUN("%clang_cc1 -triple x86_64-pc-linux-gnu -fsyntax-only -verify -std=c++11 %s");
  }

  @Test
  public void test_attr_weakref_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/attr-weakref.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-pc-linux-gnu -fsyntax-only -verify -std=c++11 ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/attr-weakref.cpp
    RUN("%clang_cc1 -triple x86_64-pc-linux-gnu -fsyntax-only -verify -std=c++11 %s");
  }

  @Test
  public void test_attr_x86_interrupt_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/attr-x86-interrupt.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-unknown-linux-gnu -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/attr-x86-interrupt.cpp
    RUN("%clang_cc1 -triple x86_64-unknown-linux-gnu  -fsyntax-only -verify %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i386-unknown-linux-gnu -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/attr-x86-interrupt.cpp
    RUN("%clang_cc1 -triple i386-unknown-linux-gnu  -fsyntax-only -verify %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-pc-win32 -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/attr-x86-interrupt.cpp
    RUN("%clang_cc1 -triple x86_64-pc-win32  -fsyntax-only -verify %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i386-pc-win32 -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/attr-x86-interrupt.cpp
    RUN("%clang_cc1 -triple i386-pc-win32  -fsyntax-only -verify %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-unknown-linux-gnux32 -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/attr-x86-interrupt.cpp
    RUN("%clang_cc1 -triple x86_64-unknown-linux-gnux32  -fsyntax-only -verify %s");
  }

  @Test
  public void test_attributed_auto_deduction_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/attributed-auto-deduction.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple armv7 -std=c++14 -x c++ ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/attributed-auto-deduction.cpp -fsyntax-only
    RUN("%clang_cc1 -triple armv7 -std=c++14 -x c++ %s -fsyntax-only");
  }

  @Test
  public void test_auto_cxx0x_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/auto-cxx0x.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/auto-cxx0x.cpp -std=c++11
    RUN("%clang_cc1 -fsyntax-only -verify %s -std=c++11");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/auto-cxx0x.cpp -std=c++1y
    RUN("%clang_cc1 -fsyntax-only -verify %s -std=c++1y");
  }

  @Test
  public void test_auto_cxx98_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/auto-cxx98.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/auto-cxx98.cpp -std=c++98 -Wc++11-compat
    RUN("%clang_cc1 -fsyntax-only -verify %s -std=c++98 -Wc++11-compat");
  }

  @Test
  public void test_auto_pragma_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/auto-pragma.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/auto-pragma.cpp -std=c++11 -ast-dump -ast-dump-filter AutoVar | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/auto-pragma.cpp
    RUN("%clang_cc1 -fsyntax-only %s -std=c++11 -ast-dump -ast-dump-filter AutoVar")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_auto_subst_failure_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/auto-subst-failure.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/auto-subst-failure.cpp -std=c++11
    RUN("%clang_cc1 -fsyntax-only -verify %s -std=c++11");
  }

  @Test
  public void test_auto_type_from_cxx_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/auto-type-from-cxx.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c++14 -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/auto-type-from-cxx.cpp
    RUN("%clang_cc1 -std=c++14 -fsyntax-only -verify %s");
  }

  @Test
  public void test_bitfield_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/bitfield.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/bitfield.cpp -verify
    RUN("%clang_cc1 %s -verify");
  }

  @Test
  public void test_bitfield_layout_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/bitfield-layout.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/bitfield-layout.cpp -fsyntax-only -verify -triple=x86_64-apple-darwin10
    RUN("%clang_cc1 %s -fsyntax-only -verify -triple=x86_64-apple-darwin10");
  }

  @Test
  public void test_block_call_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/block-call.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x c++ -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/block-call.cpp -fblocks
    RUN("%clang_cc1 -x c++ -fsyntax-only -verify %s -fblocks");
  }

  @Test
  public void test_blocks_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/blocks.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c++11 -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/blocks.cpp -fblocks
    RUN("%clang_cc1 -std=c++11 -fsyntax-only -verify %s -fblocks");
  }

  @Test
  public void test_blocks_1_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/blocks-1.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/blocks-1.cpp -fblocks -std=c++1y
    RUN("%clang_cc1 -fsyntax-only -verify %s -fblocks -std=c++1y");
  }

  @Test
  public void test_bool_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/bool.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -Wno-constant-conversion ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/bool.cpp
    RUN("%clang_cc1 -fsyntax-only -verify -Wno-constant-conversion %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -Wno-constant-conversion -Wno-deprecated -Wdeprecated-increment-bool ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/bool.cpp
    RUN("%clang_cc1 -fsyntax-only -verify -Wno-constant-conversion -Wno-deprecated -Wdeprecated-increment-bool %s");
  }

  @Test
  public void test_bool_compare_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/bool-compare.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/bool-compare.cpp
    RUN("%clang_cc1 -fsyntax-only -verify %s");
  }

  @Test
  public void test_borland_extensions_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/borland-extensions.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/borland-extensions.cpp -fsyntax-only -fborland-extensions -triple x86_64-linux-gnu -verify
    RUN("%clang_cc1 %s -fsyntax-only -fborland-extensions -triple x86_64-linux-gnu -verify");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/borland-extensions.cpp -fsyntax-only -fborland-extensions -triple i686-linux-gnu -Werror
    RUN("%clang_cc1 %s -fsyntax-only -fborland-extensions -triple i686-linux-gnu -Werror");
  }

  @Test
  public void test_builtin_assume_aligned_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/builtin-assume-aligned.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -std=c++11 -triple x86_64-linux-gnu ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/builtin-assume-aligned.cpp
    RUN(TestState.Failed, "%clang_cc1 -fsyntax-only -verify -std=c++11 -triple x86_64-linux-gnu %s");
  }

  @Test
  public void test_builtin_assume_aligned_tmpl_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/builtin-assume-aligned-tmpl.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/builtin-assume-aligned-tmpl.cpp
    RUN("%clang_cc1 -fsyntax-only -verify %s");
  }

  @Test
  public void test_builtin_classify_type_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/builtin-classify-type.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/builtin-classify-type.cpp
    RUN("%clang_cc1 -fsyntax-only -verify %s");
  }

  @Test
  public void test_builtin_exception_spec_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/builtin-exception-spec.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -isystem ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/Inputs -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/builtin-exception-spec.cpp
    RUN("%clang_cc1 -isystem %S/Inputs -fsyntax-only -verify %s");
  }

  @Test
  public void test_builtin_object_size_cxx14_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/builtin-object-size-cxx14.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -std=c++14 ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/builtin-object-size-cxx14.cpp
    RUN("%clang_cc1 -fsyntax-only -verify -std=c++14 %s");
  }

  @Test
  public void test_builtin_ptrtomember_ambig_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/builtin-ptrtomember-ambig.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/builtin-ptrtomember-ambig.cpp -std=c++11
    RUN("%clang_cc1 -fsyntax-only -verify %s -std=c++11");
  }

  @Test
  public void test_builtin_ptrtomember_overload_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/builtin-ptrtomember-overload.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/builtin-ptrtomember-overload.cpp -std=c++11
    RUN("%clang_cc1 -fsyntax-only -verify %s -std=c++11");
  }

  @Test
  public void test_builtin_ptrtomember_overload_1_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/builtin-ptrtomember-overload-1.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/builtin-ptrtomember-overload-1.cpp -std=c++11
    RUN("%clang_cc1 -fsyntax-only -verify %s -std=c++11");
  }

  @Test
  public void test_builtin_objc_msgSend_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/builtin_objc_msgSend.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/builtin_objc_msgSend.cpp -fsyntax-only -verify
    RUN("%clang_cc1 %s -fsyntax-only -verify");
  }

  @Test
  public void test_builtins_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/builtins.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/builtins.cpp -fsyntax-only -verify -std=c++11
    RUN("%clang_cc1 %s -fsyntax-only -verify -std=c++11");
  }

  @Test
  public void test_builtins_arm_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/builtins-arm.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple armv7 -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/builtins-arm.cpp
    RUN("%clang_cc1 -triple armv7 -fsyntax-only -verify %s");
  }

  @Test
  public void test_builtins_va_arg_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/builtins-va_arg.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/builtins-va_arg.cpp -ffreestanding
    RUN("%clang_cc1 %s -ffreestanding");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/builtins-va_arg.cpp -ffreestanding -triple i686-unknown-linux
    RUN("%clang_cc1 %s -ffreestanding -triple i686-unknown-linux");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/builtins-va_arg.cpp -ffreestanding -triple x86_64-unknown-linux
    RUN("%clang_cc1 %s -ffreestanding -triple x86_64-unknown-linux");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/builtins-va_arg.cpp -ffreestanding -triple mips-unknown-linux
    RUN("%clang_cc1 %s -ffreestanding -triple mips-unknown-linux");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/builtins-va_arg.cpp -ffreestanding -triple mipsel-unknown-linux
    RUN("%clang_cc1 %s -ffreestanding -triple mipsel-unknown-linux");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/builtins-va_arg.cpp -ffreestanding -triple armv7-unknown-linux-gnueabi
    RUN("%clang_cc1 %s -ffreestanding -triple armv7-unknown-linux-gnueabi");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/builtins-va_arg.cpp -ffreestanding -triple thumbv7-unknown-linux-gnueabi
    RUN("%clang_cc1 %s -ffreestanding -triple thumbv7-unknown-linux-gnueabi");
  }

  @Test
  public void test_c99_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/c99.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -pedantic -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/c99.cpp
    RUN("%clang_cc1 -fsyntax-only -pedantic -verify %s");
  }

  @Test
  public void test_c99_variable_length_array_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/c99-variable-length-array.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -Wvla-extension ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/c99-variable-length-array.cpp
    RUN("%clang_cc1 -fsyntax-only -verify -Wvla-extension %s");
  }

  @Test
  public void test_c99_variable_length_array_cxx11_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/c99-variable-length-array-cxx11.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -std=c++11 -Wvla-extension ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/c99-variable-length-array-cxx11.cpp
    RUN("%clang_cc1 -fsyntax-only -verify -std=c++11 -Wvla-extension %s");
  }

  @Test
  public void test_call_with_static_chain_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/call-with-static-chain.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/call-with-static-chain.cpp
    RUN("%clang_cc1 -fsyntax-only -verify %s");
  }

  @Test
  public void test_calling_conv_compat_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/calling-conv-compat.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -std=c++11 -fms-extensions -verify -triple i686-pc-win32 ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/calling-conv-compat.cpp
    RUN("%clang_cc1 -fsyntax-only -std=c++11 -fms-extensions -verify -triple i686-pc-win32 %s");
  }

  @Test
  public void test_captured_statements_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/captured-statements.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -std=c++11 ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/captured-statements.cpp -fblocks
    RUN("%clang_cc1 -fsyntax-only -verify -std=c++11 %s -fblocks");
  }

  @Test
  public void test_cast_conversion_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/cast-conversion.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -triple x86_64-unknown-unknown -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/cast-conversion.cpp -std=c++11
    RUN("%clang_cc1 -fsyntax-only -triple x86_64-unknown-unknown -verify %s -std=c++11");
  }

  @Test
  public void test_cast_explicit_ctor_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/cast-explicit-ctor.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/cast-explicit-ctor.cpp
    RUN("%clang_cc1 -fsyntax-only -verify %s");
  }

  @Test
  public void test_cast_lvalue_to_rvalue_reference_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/cast-lvalue-to-rvalue-reference.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/cast-lvalue-to-rvalue-reference.cpp -std=c++11
    RUN("%clang_cc1 -fsyntax-only -verify %s -std=c++11");
  }

  @Test
  public void test_cdtor_fn_try_block_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/cdtor-fn-try-block.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -fcxx-exceptions -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/cdtor-fn-try-block.cpp -std=c++14
    RUN("%clang_cc1 -fsyntax-only -fcxx-exceptions -verify %s -std=c++14");
  }

  @Test
  public void test_class_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/class.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -Wc++11-compat ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/class.cpp
    RUN("%clang_cc1 -fsyntax-only -verify -Wc++11-compat %s");
  }

  @Test
  public void test_class_base_member_init_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/class-base-member-init.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -std=c++11 -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/class-base-member-init.cpp
    RUN("%clang_cc1 -fsyntax-only -std=c++11 -verify %s");
  }

  @Test
  public void test_class_layout_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/class-layout.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-unknown-unknown ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/class-layout.cpp -fsyntax-only -verify -std=c++98 -Wno-inaccessible-base
    RUN("%clang_cc1 -triple x86_64-unknown-unknown %s -fsyntax-only -verify -std=c++98 -Wno-inaccessible-base");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-unknown-unknown ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/class-layout.cpp -fsyntax-only -verify -std=c++11 -Wno-inaccessible-base
    RUN("%clang_cc1 -triple x86_64-unknown-unknown %s -fsyntax-only -verify -std=c++11 -Wno-inaccessible-base");
  }

  @Test
  public void test_class_names_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/class-names.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/class-names.cpp
    RUN("%clang_cc1 -fsyntax-only -verify %s");
  }

  @Test
  public void test_comma_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/comma.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/comma.cpp
    RUN("%clang_cc1 -fsyntax-only -verify %s");
  }

  @Test
  public void test_compare_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/compare.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-apple-darwin -fsyntax-only -pedantic -verify -Wsign-compare -std=c++11 ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/compare.cpp
    RUN("%clang_cc1 -triple x86_64-apple-darwin -fsyntax-only -pedantic -verify -Wsign-compare -std=c++11 %s");
  }

  @Test
  public void test_complex_folding_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/complex-folding.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/complex-folding.cpp -std=c++1z -fsyntax-only -verify
    RUN("%clang_cc1 %s -std=c++1z -fsyntax-only -verify");
  }

  @Test
  public void test_complex_init_list_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/complex-init-list.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/complex-init-list.cpp -verify -fsyntax-only -pedantic
    RUN("%clang_cc1 %s -verify -fsyntax-only -pedantic");
  }

  @Test
  public void test_complex_overload_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/complex-overload.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/complex-overload.cpp
    RUN("%clang_cc1 -fsyntax-only -verify %s");
  }

  @Test
  public void test_composite_pointer_type_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/composite-pointer-type.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/composite-pointer-type.cpp
    RUN("%clang_cc1 -fsyntax-only -verify %s");
  }

  @Test
  public void test_compound_literal_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/compound-literal.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -std=c++03 -verify -ast-dump ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/compound-literal.cpp > ${TEST_TEMP_DIR}/compound-literal.cpp.tmp-03
    RUN("%clang_cc1 -fsyntax-only -std=c++03 -verify -ast-dump %s > %t-03");
    // ${LLVM_SRC}/build/bin/FileCheck '--input-file=${TEST_TEMP_DIR}/compound-literal.cpp.tmp-03' ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/compound-literal.cpp
    RUN("FileCheck --input-file=%t-03 %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -std=c++11 -verify -ast-dump ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/compound-literal.cpp > ${TEST_TEMP_DIR}/compound-literal.cpp.tmp-11
    RUN("%clang_cc1 -fsyntax-only -std=c++11 -verify -ast-dump %s > %t-11");
    // ${LLVM_SRC}/build/bin/FileCheck '--input-file=${TEST_TEMP_DIR}/compound-literal.cpp.tmp-11' ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/compound-literal.cpp
    RUN("FileCheck --input-file=%t-11 %s");
    // ${LLVM_SRC}/build/bin/FileCheck '--input-file=${TEST_TEMP_DIR}/compound-literal.cpp.tmp-11' ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/compound-literal.cpp --check-prefix=CHECK-CXX11
    RUN("FileCheck --input-file=%t-11 %s --check-prefix=CHECK-CXX11");
  }

  @Test
  public void test_condition_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/condition.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -std=c++11 ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/condition.cpp
    RUN("%clang_cc1 -fsyntax-only -verify -std=c++11 %s");
  }

  @Test
  public void test_conditional_expr_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/conditional-expr.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fcxx-exceptions -fexceptions -fsyntax-only -verify -std=c++11 -Wsign-conversion ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/conditional-expr.cpp
    RUN("%clang_cc1 -fcxx-exceptions -fexceptions -fsyntax-only -verify -std=c++11 -Wsign-conversion %s");
  }

  @Test
  public void test_const_cast_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/const-cast.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/const-cast.cpp
    RUN("%clang_cc1 -fsyntax-only -verify %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -std=c++98 ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/const-cast.cpp
    RUN("%clang_cc1 -fsyntax-only -verify -std=c++98 %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -std=c++11 ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/const-cast.cpp
    RUN("%clang_cc1 -fsyntax-only -verify -std=c++11 %s");
  }

  @Test
  public void test_constant_expression_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/constant-expression.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -std=c++98 -pedantic ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/constant-expression.cpp
    RUN("%clang_cc1 -fsyntax-only -verify -std=c++98 -pedantic %s");
  }

  @Test
  public void test_constant_expression_cxx11_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/constant-expression-cxx11.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i686-linux -Wno-string-plus-int -Wno-pointer-arith -Wno-zero-length-array -fsyntax-only -fcxx-exceptions -verify -std=c++11 -pedantic ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/constant-expression-cxx11.cpp -Wno-comment -Wno-tautological-pointer-compare -Wno-bool-conversion
    RUN(TestState.Failed, "%clang_cc1 -triple i686-linux -Wno-string-plus-int -Wno-pointer-arith -Wno-zero-length-array -fsyntax-only -fcxx-exceptions -verify -std=c++11 -pedantic %s -Wno-comment -Wno-tautological-pointer-compare -Wno-bool-conversion");
  }

  @Test
  public void test_constant_expression_cxx1y_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/constant-expression-cxx1y.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c++1y -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/constant-expression-cxx1y.cpp -fcxx-exceptions -triple=x86_64-linux-gnu
    RUN(TestState.Failed, "%clang_cc1 -std=c++1y -verify %s -fcxx-exceptions -triple=x86_64-linux-gnu");
  }

  @Test
  public void test_constant_expression_cxx1z_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/constant-expression-cxx1z.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c++1z -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/constant-expression-cxx1z.cpp -fcxx-exceptions -triple=x86_64-linux-gnu
    RUN("%clang_cc1 -std=c++1z -verify %s -fcxx-exceptions -triple=x86_64-linux-gnu");
  }

  @Test
  public void test_constexpr_ackermann_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/constexpr-ackermann.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c++11 -fsyntax-only ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/constexpr-ackermann.cpp
    /*JAVA: THIS CAN FAIL WITH STACKOVERFLOW */RUN("%clang_cc1 -std=c++11 -fsyntax-only %s");
    // to see StackOverflowError: 
    // - enable exception-breakpoint
    // - set line breakpoin in method EvaluateStmt on line "return EvalStmtResult.ESR_Failed;"
  }

  @Test
  public void test_constexpr_backtrace_limit_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/constexpr-backtrace-limit.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c++11 -fsyntax-only ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/constexpr-backtrace-limit.cpp -fconstexpr-backtrace-limit 0 -fconstexpr-depth 4 -fno-caret-diagnostics 2>&1 | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/constexpr-backtrace-limit.cpp -check-prefix=TEST1
    RUN("not %clang_cc1 -std=c++11 -fsyntax-only %s -fconstexpr-backtrace-limit 0 -fconstexpr-depth 4 -fno-caret-diagnostics 2>&1")./*|*/
      I("FileCheck %s -check-prefix=TEST1");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c++11 -fsyntax-only ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/constexpr-backtrace-limit.cpp -fconstexpr-backtrace-limit 2 -fconstexpr-depth 4 -fno-caret-diagnostics 2>&1 | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/constexpr-backtrace-limit.cpp -check-prefix=TEST2
    RUN("not %clang_cc1 -std=c++11 -fsyntax-only %s -fconstexpr-backtrace-limit 2 -fconstexpr-depth 4 -fno-caret-diagnostics 2>&1")./*|*/
      I("FileCheck %s -check-prefix=TEST2");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c++11 -fsyntax-only ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/constexpr-backtrace-limit.cpp -fconstexpr-backtrace-limit 2 -fconstexpr-depth 8 -fno-caret-diagnostics 2>&1 | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/constexpr-backtrace-limit.cpp -check-prefix=TEST3
    RUN("not %clang_cc1 -std=c++11 -fsyntax-only %s -fconstexpr-backtrace-limit 2 -fconstexpr-depth 8 -fno-caret-diagnostics 2>&1")./*|*/
      I("FileCheck %s -check-prefix=TEST3");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c++11 -fsyntax-only ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/constexpr-backtrace-limit.cpp -fconstexpr-backtrace-limit 8 -fconstexpr-depth 8 -fno-caret-diagnostics 2>&1 | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/constexpr-backtrace-limit.cpp -check-prefix=TEST4
    RUN("not %clang_cc1 -std=c++11 -fsyntax-only %s -fconstexpr-backtrace-limit 8 -fconstexpr-depth 8 -fno-caret-diagnostics 2>&1")./*|*/
      I("FileCheck %s -check-prefix=TEST4");
  }

  @Test
  public void test_constexpr_depth_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/constexpr-depth.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c++11 -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/constexpr-depth.cpp -DMAX=128 -fconstexpr-depth 128
    RUN("%clang_cc1 -std=c++11 -fsyntax-only -verify %s -DMAX=128 -fconstexpr-depth 128");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c++11 -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/constexpr-depth.cpp -DMAX=2 -fconstexpr-depth 2
    RUN("%clang_cc1 -std=c++11 -fsyntax-only -verify %s -DMAX=2 -fconstexpr-depth 2");
    // ${LLVM_SRC}/build/bin/clang -std=c++11 -fsyntax-only -Xclang -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/constexpr-depth.cpp -DMAX=10 -fconstexpr-depth=10
    RUN("%clang -std=c++11 -fsyntax-only -Xclang -verify %s -DMAX=10 -fconstexpr-depth=10");
  }

  @Test
  public void test_constexpr_duffs_device_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/constexpr-duffs-device.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c++1y -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/constexpr-duffs-device.cpp
    RUN("%clang_cc1 -std=c++1y -verify %s");
  }

  @Test
  public void test_constexpr_factorial_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/constexpr-factorial.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c++11 -fsyntax-only ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/constexpr-factorial.cpp
    RUN("%clang_cc1 -std=c++11 -fsyntax-only %s");
  }

  @Test
  public void test_constexpr_many_arguments_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/constexpr-many-arguments.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c++11 -fsyntax-only ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/constexpr-many-arguments.cpp
    RUN("%clang_cc1 -std=c++11 -fsyntax-only %s");
  }

  @Test
  public void test_constexpr_nqueens_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/constexpr-nqueens.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c++11 -fsyntax-only ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/constexpr-nqueens.cpp
    RUN("%clang_cc1 -std=c++11 -fsyntax-only %s");
  }

  @Test
  public void test_constexpr_printing_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/constexpr-printing.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/constexpr-printing.cpp -std=c++11 -fsyntax-only -verify -triple x86_64-linux-gnu
    RUN(TestState.Failed, "%clang_cc1 %s -std=c++11 -fsyntax-only -verify -triple x86_64-linux-gnu");
  }

  @Test
  public void test_constexpr_steps_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/constexpr-steps.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c++1y -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/constexpr-steps.cpp -DMAX=1234 -fconstexpr-steps 1234
    RUN("%clang_cc1 -std=c++1y -fsyntax-only -verify %s -DMAX=1234 -fconstexpr-steps 1234");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c++1y -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/constexpr-steps.cpp -DMAX=10 -fconstexpr-steps 10
    RUN("%clang_cc1 -std=c++1y -fsyntax-only -verify %s -DMAX=10 -fconstexpr-steps 10");
    // ${LLVM_SRC}/build/bin/clang -std=c++1y -fsyntax-only -Xclang -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/constexpr-steps.cpp -DMAX=12345 -fconstexpr-steps=12345
    RUN("%clang -std=c++1y -fsyntax-only -Xclang -verify %s -DMAX=12345 -fconstexpr-steps=12345");
  }

  @Test
  public void test_constexpr_strlen_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/constexpr-strlen.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/constexpr-strlen.cpp -std=c++11 -fsyntax-only -verify -pedantic
    RUN("%clang_cc1 %s -std=c++11 -fsyntax-only -verify -pedantic");
  }

  @Test
  public void test_constexpr_turing_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/constexpr-turing.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -verify -std=c++11 ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/constexpr-turing.cpp
    RUN("%clang_cc1 -verify -std=c++11 %s");
  }

  @Test
  public void test_constexpr_value_init_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/constexpr-value-init.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/constexpr-value-init.cpp -Wno-uninitialized -std=c++11 -fsyntax-only -verify
    RUN("%clang_cc1 %s -Wno-uninitialized -std=c++11 -fsyntax-only -verify");
  }

  @Test
  public void test_constructor_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/constructor.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/constructor.cpp
    RUN("%clang_cc1 -fsyntax-only -verify %s");
  }

  @Test
  public void test_constructor_initializer_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/constructor-initializer.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -Wreorder -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/constructor-initializer.cpp
    RUN("%clang_cc1 -Wreorder -fsyntax-only -verify %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -Wreorder -fsyntax-only -verify -std=c++98 ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/constructor-initializer.cpp
    RUN("%clang_cc1 -Wreorder -fsyntax-only -verify -std=c++98 %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -Wreorder -fsyntax-only -verify -std=c++11 ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/constructor-initializer.cpp
    RUN("%clang_cc1 -Wreorder -fsyntax-only -verify -std=c++11 %s");
  }

  @Test
  public void test_constructor_recovery_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/constructor-recovery.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/constructor-recovery.cpp
    RUN("%clang_cc1 -fsyntax-only -verify %s");
  }

  @Test
  public void test_conversion_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/conversion.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-apple-darwin -fsyntax-only -Wconversion -std=c++11 -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/conversion.cpp
    RUN("%clang_cc1 -triple x86_64-apple-darwin -fsyntax-only -Wconversion -std=c++11 -verify %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-apple-darwin -fsyntax-only -Wconversion -std=c++11 ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/conversion.cpp 2>&1 | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/conversion.cpp
    RUN("%clang_cc1 -triple x86_64-apple-darwin -fsyntax-only -Wconversion -std=c++11 %s 2>&1")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_conversion_delete_expr_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/conversion-delete-expr.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -std=c++11 ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/conversion-delete-expr.cpp
    RUN("%clang_cc1 -fsyntax-only -verify -std=c++11 %s");
  }

  @Test
  public void test_conversion_function_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/conversion-function.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i386-pc-solaris2.11 -fsyntax-only -Wbind-to-temporary-copy -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/conversion-function.cpp
    RUN(TestState.Failed, "%clang_cc1 -triple %itanium_abi_triple -fsyntax-only -Wbind-to-temporary-copy -verify %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i386-pc-solaris2.11 -fsyntax-only -Wbind-to-temporary-copy -verify -std=c++98 ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/conversion-function.cpp
    RUN(TestState.Failed, "%clang_cc1 -triple %itanium_abi_triple -fsyntax-only -Wbind-to-temporary-copy -verify -std=c++98 %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i386-pc-solaris2.11 -fsyntax-only -Wbind-to-temporary-copy -verify -std=c++11 ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/conversion-function.cpp
    RUN(TestState.Failed, "%clang_cc1 -triple %itanium_abi_triple -fsyntax-only -Wbind-to-temporary-copy -verify -std=c++11 %s");
  }

  @Test
  public void test_conversion_incomplete_type_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/conversion-incomplete-type.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/conversion-incomplete-type.cpp
    RUN("%clang_cc1 -fsyntax-only -verify %s");
  }

  @Test
  public void test_convert_to_bool_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/convert-to-bool.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/convert-to-bool.cpp
    RUN("%clang_cc1 -fsyntax-only -verify %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -std=c++98 ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/convert-to-bool.cpp
    RUN("%clang_cc1 -fsyntax-only -verify -std=c++98 %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -std=c++11 ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/convert-to-bool.cpp
    RUN("%clang_cc1 -fsyntax-only -verify -std=c++11 %s");
  }

  @Test
  public void test_converting_constructor_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/converting-constructor.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/converting-constructor.cpp
    RUN("%clang_cc1 -fsyntax-only -verify %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -std=c++98 ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/converting-constructor.cpp
    RUN("%clang_cc1 -fsyntax-only -verify -std=c++98 %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -std=c++11 ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/converting-constructor.cpp
    RUN("%clang_cc1 -fsyntax-only -verify -std=c++11 %s");
  }

  @Test
  public void test_copy_assignment_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/copy-assignment.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/copy-assignment.cpp
    RUN("%clang_cc1 -fsyntax-only -verify %s");
  }

  @Test
  public void test_copy_constructor_error_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/copy-constructor-error.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/copy-constructor-error.cpp
    RUN("%clang_cc1 -fsyntax-only -verify %s");
  }

  @Test
  public void test_copy_initialization_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/copy-initialization.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/copy-initialization.cpp
    RUN("%clang_cc1 -fsyntax-only -verify %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -std=c++98 ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/copy-initialization.cpp
    RUN("%clang_cc1 -fsyntax-only -verify -std=c++98 %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -std=c++11 ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/copy-initialization.cpp
    RUN("%clang_cc1 -fsyntax-only -verify -std=c++11 %s");
  }

  @Test
  public void test_coroutines_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/coroutines.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c++14 -fcoroutines -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/coroutines.cpp
    RUN("%clang_cc1 -std=c++14 -fcoroutines -verify %s");
  }

  @Test
  public void test_crash_lambda_12645424_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/crash-lambda-12645424.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -std=c++11 ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/crash-lambda-12645424.cpp -verify
    RUN("%clang_cc1 -fsyntax-only -std=c++11 %s -verify");
  }

  @Test
  public void test_crashes_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/crashes.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/crashes.cpp
    RUN("%clang_cc1 -fsyntax-only -verify %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -std=c++98 ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/crashes.cpp
    RUN("%clang_cc1 -fsyntax-only -verify -std=c++98 %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -std=c++11 ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/crashes.cpp
    RUN("%clang_cc1 -fsyntax-only -verify -std=c++11 %s");
  }

  @Test
  public void test_cstyle_cast_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/cstyle-cast.cpp");
    // REQUIRES: LP64
    if (!CHECK_REQUIRES("LP64")) {
      return;
    }
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/cstyle-cast.cpp
    RUN("%clang_cc1 -fsyntax-only -verify %s");
  }

  @Test
  public void test_cv_unqual_rvalues_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/cv-unqual-rvalues.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/cv-unqual-rvalues.cpp
    RUN("%clang_cc1 -fsyntax-only -verify %s");
  }

  @Test
  public void test_cxx_altivec_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/cxx-altivec.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple=powerpc-apple-darwin8 -faltivec -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/cxx-altivec.cpp
    RUN("%clang_cc1 -triple=powerpc-apple-darwin8 -faltivec -fsyntax-only -verify %s");
  }

  @Test
  public void test_cxx_deprecated_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/cxx-deprecated.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -std=c++1z ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/cxx-deprecated.cpp
    RUN("%clang_cc1 -fsyntax-only -verify -std=c++1z %s");
  }

  @Test
  public void test_cxx_member_pointer_op_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/cxx-member-pointer-op.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -pedantic -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/cxx-member-pointer-op.cpp
    RUN("%clang_cc1 -fsyntax-only -pedantic -verify %s");
  }

  @Test
  public void test_cxx0x_class_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/cxx0x-class.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -Wno-uninitialized -fsyntax-only -verify -std=c++11 -Wno-error=static-float-init ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/cxx0x-class.cpp
    RUN("%clang_cc1 -Wno-uninitialized -fsyntax-only -verify -std=c++11 -Wno-error=static-float-init %s");
  }

  @Test
  public void test_cxx0x_compat_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/cxx0x-compat.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -std=c++98 -Wc++11-compat -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/cxx0x-compat.cpp
    RUN("%clang_cc1 -fsyntax-only -std=c++98 -Wc++11-compat -verify %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -std=c++1z -Wc++11-compat -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/cxx0x-compat.cpp
    RUN("%clang_cc1 -fsyntax-only -std=c++1z -Wc++11-compat -verify %s");
  }

  @Test
  public void test_cxx0x_constexpr_const_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/cxx0x-constexpr-const.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c++11 -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/cxx0x-constexpr-const.cpp
    RUN("%clang_cc1 -std=c++11 -fsyntax-only -verify %s");
  }

  @Test
  public void test_cxx0x_cursory_default_delete_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/cxx0x-cursory-default-delete.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c++11 -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/cxx0x-cursory-default-delete.cpp
    RUN("%clang_cc1 -std=c++11 -fsyntax-only -verify %s");
  }

  @Test
  public void test_cxx0x_defaulted_functions_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/cxx0x-defaulted-functions.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c++11 -fsyntax-only -verify -fcxx-exceptions ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/cxx0x-defaulted-functions.cpp
    RUN("%clang_cc1 -std=c++11 -fsyntax-only -verify -fcxx-exceptions %s");
  }

  @Test
  public void test_cxx0x_delegating_ctors_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/cxx0x-delegating-ctors.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -std=c++11 -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/cxx0x-delegating-ctors.cpp
    RUN("%clang_cc1 -fsyntax-only -std=c++11 -verify %s");
  }

  @Test
  public void test_cxx0x_deleted_default_ctor_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/cxx0x-deleted-default-ctor.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c++11 -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/cxx0x-deleted-default-ctor.cpp
    RUN("%clang_cc1 -std=c++11 -fsyntax-only -verify %s");
  }

  @Test
  public void test_cxx0x_initializer_aggregates_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/cxx0x-initializer-aggregates.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c++0x -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/cxx0x-initializer-aggregates.cpp
    RUN("%clang_cc1 -std=c++0x -fsyntax-only -verify %s");
  }

  @Test
  public void test_cxx0x_initializer_constructor_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/cxx0x-initializer-constructor.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c++0x -fsyntax-only -fexceptions -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/cxx0x-initializer-constructor.cpp
    RUN("%clang_cc1 -std=c++0x -fsyntax-only -fexceptions -verify %s");
  }

  @Test
  public void test_cxx0x_initializer_references_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/cxx0x-initializer-references.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c++11 -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/cxx0x-initializer-references.cpp
    RUN("%clang_cc1 -std=c++11 -fsyntax-only -verify %s");
  }

  @Test
  public void test_cxx0x_initializer_scalars_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/cxx0x-initializer-scalars.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c++11 -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/cxx0x-initializer-scalars.cpp -pedantic-errors
    RUN("%clang_cc1 -std=c++11 -fsyntax-only -verify %s -pedantic-errors");
  }

  @Test
  public void test_cxx0x_initializer_stdinitializerlist_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/cxx0x-initializer-stdinitializerlist.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c++11 -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/cxx0x-initializer-stdinitializerlist.cpp
    RUN("%clang_cc1 -std=c++11 -fsyntax-only -verify %s");
  }

  @Test
  public void test_cxx0x_noexcept_expression_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/cxx0x-noexcept-expression.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -std=c++11 ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/cxx0x-noexcept-expression.cpp
    RUN("%clang_cc1 -fsyntax-only -verify -std=c++11 %s");
  }

  @Test
  public void test_cxx0x_nontrivial_union_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/cxx0x-nontrivial-union.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c++11 -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/cxx0x-nontrivial-union.cpp
    RUN("%clang_cc1 -std=c++11 -fsyntax-only -verify %s");
  }

  @Test
  public void test_cxx0x_return_init_list_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/cxx0x-return-init-list.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -std=c++98 ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/cxx0x-return-init-list.cpp
    RUN("%clang_cc1 -fsyntax-only -verify -std=c++98 %s");
  }

  @Test
  public void test_cxx0x_type_convert_construct_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/cxx0x-type-convert-construct.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=gnu++11 -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/cxx0x-type-convert-construct.cpp
    RUN("%clang_cc1 -std=gnu++11 -fsyntax-only -verify %s");
  }

  @Test
  public void test_cxx11_ast_print_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/cxx11-ast-print.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c++11 -ast-print ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/cxx11-ast-print.cpp | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/cxx11-ast-print.cpp
    RUN("%clang_cc1 -std=c++11 -ast-print %s")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_cxx11_attr_print_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/cxx11-attr-print.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c++11 -ast-print -fms-extensions ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/cxx11-attr-print.cpp | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/cxx11-attr-print.cpp
    RUN("%clang_cc1 -std=c++11 -ast-print -fms-extensions %s")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_cxx11_call_to_deleted_constructor_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/cxx11-call-to-deleted-constructor.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c++11 -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/cxx11-call-to-deleted-constructor.cpp
    RUN("%clang_cc1 -std=c++11 -fsyntax-only -verify %s");
  }

  @Test
  public void test_cxx11_crashes_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/cxx11-crashes.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c++11 -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/cxx11-crashes.cpp
    RUN("%clang_cc1 -std=c++11 -verify %s");
  }

  @Test
  public void test_cxx11_gnu_attrs_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/cxx11-gnu-attrs.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-unknown-unknown -std=c++11 -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/cxx11-gnu-attrs.cpp
    RUN("%clang_cc1 -triple x86_64-unknown-unknown -std=c++11 -verify %s");
  }

  @Test
  public void test_cxx11_inheriting_ctors_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/cxx11-inheriting-ctors.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c++11 ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/cxx11-inheriting-ctors.cpp -verify
    RUN("%clang_cc1 -std=c++11 %s -verify");
  }

  @Test
  public void test_cxx11_thread_local_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/cxx11-thread-local.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c++11 -triple=x86_64-linux-gnu -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/cxx11-thread-local.cpp
    RUN("%clang_cc1 -std=c++11 -triple=x86_64-linux-gnu -verify %s");
  }

  @Test
  public void test_cxx11_thread_local_print_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/cxx11-thread-local-print.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c++11 -triple=x86_64-linux-gnu -ast-print ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/cxx11-thread-local-print.cpp | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/cxx11-thread-local-print.cpp
    RUN("%clang_cc1 -std=c++11 -triple=x86_64-linux-gnu -ast-print %s")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_cxx11_thread_unsupported_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/cxx11-thread-unsupported.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c++11 -triple=x86_64-apple-macosx10.6 -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/cxx11-thread-unsupported.cpp
    RUN("%clang_cc1 -std=c++11 -triple=x86_64-apple-macosx10.6 -verify %s");
  }

  @Test
  public void test_cxx11_unused_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/cxx11-unused.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c++11 -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/cxx11-unused.cpp -Wunused-parameter
    RUN("%clang_cc1 -std=c++11 -verify %s -Wunused-parameter");
  }

  @Test
  public void test_cxx11_user_defined_literals_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/cxx11-user-defined-literals.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c++11 -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/cxx11-user-defined-literals.cpp -fms-extensions -triple x86_64-apple-darwin9.0.0
    RUN("%clang_cc1 -std=c++11 -verify %s -fms-extensions -triple x86_64-apple-darwin9.0.0");
  }

  @Test
  public void test_cxx11_user_defined_literals_unused_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/cxx11-user-defined-literals-unused.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c++11 -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/cxx11-user-defined-literals-unused.cpp -Wunused
    RUN("%clang_cc1 -std=c++11 -verify %s -Wunused");
  }

  @Test
  public void test_cxx1y_constexpr_not_const_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/cxx1y-constexpr-not-const.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c++11 ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/cxx1y-constexpr-not-const.cpp -verify
    RUN("%clang_cc1 -std=c++11 %s -verify");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c++1y ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/cxx1y-constexpr-not-const.cpp -verify -DCXX1Y
    RUN("%clang_cc1 -std=c++1y %s -verify -DCXX1Y");
  }

  @Test
  public void test_cxx1y_contextual_conversion_tweaks_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/cxx1y-contextual-conversion-tweaks.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c++11 -verify -fsyntax-only ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/cxx1y-contextual-conversion-tweaks.cpp
    RUN("%clang_cc1 -std=c++11 -verify -fsyntax-only %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c++1y ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/cxx1y-contextual-conversion-tweaks.cpp -verify -DCXX1Y
    RUN("%clang_cc1 -std=c++1y %s -verify -DCXX1Y");
  }

  @Test
  public void test_cxx1y_deduced_return_type_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/cxx1y-deduced-return-type.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c++1y -verify -fsyntax-only ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/cxx1y-deduced-return-type.cpp
    RUN("%clang_cc1 -std=c++1y -verify -fsyntax-only %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c++1y -verify -fsyntax-only ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/cxx1y-deduced-return-type.cpp -fdelayed-template-parsing -DDELAYED_TEMPLATE_PARSING
    RUN("%clang_cc1 -std=c++1y -verify -fsyntax-only %s -fdelayed-template-parsing -DDELAYED_TEMPLATE_PARSING");
  }

  @Test
  public void test_cxx1y_generic_lambdas_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/cxx1y-generic-lambdas.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c++1y -verify -fsyntax-only -fblocks -emit-llvm-only ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/cxx1y-generic-lambdas.cpp
    RUN(TestState.SemanticErrors, "%clang_cc1 -std=c++1y -verify -fsyntax-only -fblocks -emit-llvm-only %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c++1y -verify -fsyntax-only -fblocks -fdelayed-template-parsing ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/cxx1y-generic-lambdas.cpp -DDELAYED_TEMPLATE_PARSING
    RUN(TestState.Failed, "%clang_cc1 -std=c++1y -verify -fsyntax-only -fblocks -fdelayed-template-parsing %s -DDELAYED_TEMPLATE_PARSING");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c++1y -verify -fsyntax-only -fblocks -fms-extensions ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/cxx1y-generic-lambdas.cpp -DMS_EXTENSIONS
    RUN(TestState.Failed, "%clang_cc1 -std=c++1y -verify -fsyntax-only -fblocks -fms-extensions %s -DMS_EXTENSIONS");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c++1y -verify -fsyntax-only -fblocks -fdelayed-template-parsing -fms-extensions ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/cxx1y-generic-lambdas.cpp -DMS_EXTENSIONS -DDELAYED_TEMPLATE_PARSING
    RUN(TestState.Failed, "%clang_cc1 -std=c++1y -verify -fsyntax-only -fblocks -fdelayed-template-parsing -fms-extensions %s -DMS_EXTENSIONS -DDELAYED_TEMPLATE_PARSING");
  }

  @Test
  public void test_cxx1y_generic_lambdas_capturing_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/cxx1y-generic-lambdas-capturing.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c++1y -verify -fsyntax-only -fblocks -emit-llvm-only ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/cxx1y-generic-lambdas-capturing.cpp
    RUN(TestState.SemanticErrors, "%clang_cc1 -std=c++1y -verify -fsyntax-only -fblocks -emit-llvm-only %s");
  }

  @Test
  public void test_cxx1y_generic_lambdas_variadics_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/cxx1y-generic-lambdas-variadics.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c++1y -verify -fsyntax-only -fblocks ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/cxx1y-generic-lambdas-variadics.cpp
    RUN("%clang_cc1 -std=c++1y -verify -fsyntax-only -fblocks %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c++1y -verify -fsyntax-only -fblocks -fdelayed-template-parsing ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/cxx1y-generic-lambdas-variadics.cpp -DDELAYED_TEMPLATE_PARSING
    RUN("%clang_cc1 -std=c++1y -verify -fsyntax-only -fblocks -fdelayed-template-parsing %s -DDELAYED_TEMPLATE_PARSING");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c++1y -verify -fsyntax-only -fblocks -fms-extensions ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/cxx1y-generic-lambdas-variadics.cpp -DMS_EXTENSIONS
    RUN("%clang_cc1 -std=c++1y -verify -fsyntax-only -fblocks -fms-extensions %s -DMS_EXTENSIONS");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c++1y -verify -fsyntax-only -fblocks -fdelayed-template-parsing -fms-extensions ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/cxx1y-generic-lambdas-variadics.cpp -DMS_EXTENSIONS -DDELAYED_TEMPLATE_PARSING
    RUN("%clang_cc1 -std=c++1y -verify -fsyntax-only -fblocks -fdelayed-template-parsing -fms-extensions %s -DMS_EXTENSIONS -DDELAYED_TEMPLATE_PARSING");
  }

  @Test
  public void test_cxx1y_init_captures_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/cxx1y-init-captures.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c++1y ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/cxx1y-init-captures.cpp -verify -emit-llvm-only
    RUN("%clang_cc1 -std=c++1y %s -verify -emit-llvm-only");
  }

  @Test
  public void test_cxx1y_initializer_aggregates_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/cxx1y-initializer-aggregates.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c++1y ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/cxx1y-initializer-aggregates.cpp -verify
    RUN("%clang_cc1 -std=c++1y %s -verify");
  }

  @Test
  public void test_cxx1y_sized_deallocation_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/cxx1y-sized-deallocation.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c++1y -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/cxx1y-sized-deallocation.cpp -fsized-deallocation -fexceptions -fcxx-exceptions
    RUN("%clang_cc1 -std=c++1y -verify %s -fsized-deallocation -fexceptions -fcxx-exceptions");
  }

  @Test
  public void test_cxx1y_user_defined_literals_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/cxx1y-user-defined-literals.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c++1y ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/cxx1y-user-defined-literals.cpp -include ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/cxx1y-user-defined-literals.cpp -verify
    RUN("%clang_cc1 -std=c++1y %s -include %s -verify");
  }

  @Test
  public void test_cxx1y_variable_templates_in_class_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/cxx1y-variable-templates_in_class.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c++98 -verify -fsyntax-only ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/cxx1y-variable-templates_in_class.cpp -Wno-c++11-extensions -Wno-c++1y-extensions -DPRECXX11
    RUN("%clang_cc1 -std=c++98 -verify -fsyntax-only %s -Wno-c++11-extensions -Wno-c++1y-extensions -DPRECXX11");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c++11 -verify -fsyntax-only -Wno-c++1y-extensions ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/cxx1y-variable-templates_in_class.cpp
    RUN("%clang_cc1 -std=c++11 -verify -fsyntax-only -Wno-c++1y-extensions %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c++1y -verify -fsyntax-only ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/cxx1y-variable-templates_in_class.cpp -DCPP1Y
    RUN("%clang_cc1 -std=c++1y -verify -fsyntax-only %s -DCPP1Y");
  }

  @Test
  public void test_cxx1y_variable_templates_top_level_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/cxx1y-variable-templates_top_level.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c++98 -verify -fsyntax-only -Wno-c++11-extensions -Wno-c++1y-extensions ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/cxx1y-variable-templates_top_level.cpp -DPRECXX11
    RUN("%clang_cc1 -std=c++98 -verify -fsyntax-only -Wno-c++11-extensions -Wno-c++1y-extensions %s -DPRECXX11");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c++11 -verify -fsyntax-only -Wno-c++1y-extensions ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/cxx1y-variable-templates_top_level.cpp
    RUN("%clang_cc1 -std=c++11 -verify -fsyntax-only -Wno-c++1y-extensions %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c++1y -verify -fsyntax-only ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/cxx1y-variable-templates_top_level.cpp
    RUN("%clang_cc1 -std=c++1y -verify -fsyntax-only %s");
  }

  @Test
  public void test_cxx1z_init_statement_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/cxx1z-init-statement.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c++1z -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/cxx1z-init-statement.cpp
    RUN("%clang_cc1 -std=c++1z -verify %s");
  }

  @Test
  public void test_cxx1z_init_statement_warn_unused_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/cxx1z-init-statement-warn-unused.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c++1z -verify -Wuninitialized ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/cxx1z-init-statement-warn-unused.cpp
    RUN(TestState.Failed, "%clang_cc1 -std=c++1z -verify -Wuninitialized %s");
  }

  @Test
  public void test_cxx1z_lambda_star_this_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/cxx1z-lambda-star-this.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c++1z -verify -fsyntax-only -fblocks -emit-llvm-only ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/cxx1z-lambda-star-this.cpp
    RUN("%clang_cc1 -std=c++1z -verify -fsyntax-only -fblocks -emit-llvm-only %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c++1z -verify -fsyntax-only -fblocks -fdelayed-template-parsing ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/cxx1z-lambda-star-this.cpp -DDELAYED_TEMPLATE_PARSING
    RUN("%clang_cc1 -std=c++1z -verify -fsyntax-only -fblocks -fdelayed-template-parsing %s -DDELAYED_TEMPLATE_PARSING");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c++1z -verify -fsyntax-only -fblocks -fms-extensions ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/cxx1z-lambda-star-this.cpp -DMS_EXTENSIONS
    RUN("%clang_cc1 -std=c++1z -verify -fsyntax-only -fblocks -fms-extensions %s -DMS_EXTENSIONS");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c++1z -verify -fsyntax-only -fblocks -fdelayed-template-parsing -fms-extensions ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/cxx1z-lambda-star-this.cpp -DMS_EXTENSIONS -DDELAYED_TEMPLATE_PARSING
    RUN("%clang_cc1 -std=c++1z -verify -fsyntax-only -fblocks -fdelayed-template-parsing -fms-extensions %s -DMS_EXTENSIONS -DDELAYED_TEMPLATE_PARSING");
  }

  @Test
  public void test_cxx98_compat_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/cxx98-compat.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -std=c++11 -Wc++98-compat -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/cxx98-compat.cpp
    RUN("%clang_cc1 -fsyntax-only -std=c++11 -Wc++98-compat -verify %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -std=c++14 -Wc++98-compat -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/cxx98-compat.cpp -DCXX14COMPAT
    RUN("%clang_cc1 -fsyntax-only -std=c++14 -Wc++98-compat -verify %s -DCXX14COMPAT");
  }

  @Test
  public void test_cxx98_compat_flags_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/cxx98-compat-flags.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -std=c++11 -Wc++98-compat-pedantic -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/cxx98-compat-flags.cpp
    RUN("%clang_cc1 -fsyntax-only -std=c++11 -Wc++98-compat-pedantic -verify %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -std=c++11 -Wc++98-compat-pedantic -Wno-bind-to-temporary-copy -Wno-unnamed-type-template-args -Wno-local-type-template-args -Werror ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/cxx98-compat-flags.cpp
    RUN("%clang_cc1 -fsyntax-only -std=c++11 -Wc++98-compat-pedantic -Wno-bind-to-temporary-copy -Wno-unnamed-type-template-args -Wno-local-type-template-args -Werror %s");
  }

  @Test
  public void test_cxx98_compat_pedantic_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/cxx98-compat-pedantic.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -std=c++1y -DCXX1Y -Wc++98-compat-pedantic -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/cxx98-compat-pedantic.cpp -DCXX1Y2
    RUN("%clang_cc1 -fsyntax-only -std=c++1y -DCXX1Y -Wc++98-compat-pedantic -verify %s -DCXX1Y2");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -std=c++1y -DCXX1Y -Wc++98-compat -Werror ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/cxx98-compat-pedantic.cpp -DCXX1Y2
    RUN("%clang_cc1 -fsyntax-only -std=c++1y -DCXX1Y -Wc++98-compat -Werror %s -DCXX1Y2");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -std=c++11 -Wc++98-compat-pedantic -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/cxx98-compat-pedantic.cpp
    RUN("%clang_cc1 -fsyntax-only -std=c++11 -Wc++98-compat-pedantic -verify %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -std=c++11 -Wc++98-compat -Werror ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/cxx98-compat-pedantic.cpp
    RUN("%clang_cc1 -fsyntax-only -std=c++11 -Wc++98-compat -Werror %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -std=c++98 -Werror ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/cxx98-compat-pedantic.cpp -DCXX98
    RUN("%clang_cc1 -fsyntax-only -std=c++98 -Werror %s -DCXX98");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -std=c++1y -Wc++98-compat-pedantic -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/cxx98-compat-pedantic.cpp -Wno-c++98-c++11-compat-pedantic -DCXX1Y2
    RUN("%clang_cc1 -fsyntax-only -std=c++1y -Wc++98-compat-pedantic -verify %s -Wno-c++98-c++11-compat-pedantic -DCXX1Y2");
  }

  @Test
  public void test_dcl_ambig_res_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/dcl_ambig_res.cpp");
    // REQUIRES: LP64
    if (!CHECK_REQUIRES("LP64")) {
      return;
    }
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -pedantic -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/dcl_ambig_res.cpp
    RUN("%clang_cc1 -fsyntax-only -pedantic -verify %s");
  }

  @Test
  public void test_dcl_init_aggr_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/dcl_init_aggr.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -pedantic -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/dcl_init_aggr.cpp
    RUN("%clang_cc1 -fsyntax-only -pedantic -verify %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -pedantic -verify -std=c++98 ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/dcl_init_aggr.cpp
    RUN("%clang_cc1 -fsyntax-only -pedantic -verify -std=c++98 %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -pedantic -verify -std=c++11 ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/dcl_init_aggr.cpp
    RUN("%clang_cc1 -fsyntax-only -pedantic -verify -std=c++11 %s");
  }

  @Test
  public void test_decl_expr_ambiguity_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/decl-expr-ambiguity.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -Wno-int-to-pointer-cast -fsyntax-only -verify -pedantic-errors ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/decl-expr-ambiguity.cpp
    RUN("%clang_cc1 -Wno-int-to-pointer-cast -fsyntax-only -verify -pedantic-errors %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -Wno-int-to-pointer-cast -fsyntax-only -verify -pedantic-errors -std=gnu++98 ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/decl-expr-ambiguity.cpp
    RUN("%clang_cc1 -Wno-int-to-pointer-cast -fsyntax-only -verify -pedantic-errors -std=gnu++98 %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -Wno-int-to-pointer-cast -fsyntax-only -verify -pedantic-errors -std=gnu++11 ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/decl-expr-ambiguity.cpp
    RUN("%clang_cc1 -Wno-int-to-pointer-cast -fsyntax-only -verify -pedantic-errors -std=gnu++11 %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -Wno-int-to-pointer-cast -fsyntax-only -verify -pedantic-errors -x objective-c++ ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/decl-expr-ambiguity.cpp
    RUN("%clang_cc1 -Wno-int-to-pointer-cast -fsyntax-only -verify -pedantic-errors -x objective-c++ %s");
  }

  @Test
  public void test_decl_init_ref_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/decl-init-ref.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -std=c++11 ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/decl-init-ref.cpp -Wno-uninitialized
    RUN("%clang_cc1 -fsyntax-only -verify -std=c++11 %s -Wno-uninitialized");
  }

  @Test
  public void test_decl_microsoft_call_conv_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/decl-microsoft-call-conv.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c++14 -triple i686-pc-win32 -fms-extensions -DMSABI -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/decl-microsoft-call-conv.cpp
    RUN("%clang_cc1 -std=c++14 -triple i686-pc-win32 -fms-extensions -DMSABI -verify %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c++14 -triple i686-pc-mingw32 -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/decl-microsoft-call-conv.cpp
    RUN("%clang_cc1 -std=c++14 -triple i686-pc-mingw32 -verify %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c++14 -triple i686-pc-mingw32 -fms-extensions -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/decl-microsoft-call-conv.cpp
    RUN("%clang_cc1 -std=c++14 -triple i686-pc-mingw32 -fms-extensions -verify %s");
  }

  @Test
  public void test_declspec_thread_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/declspec-thread.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i686-pc-win32 -std=c++11 -fms-extensions -fms-compatibility-version=18.00 -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/declspec-thread.cpp
    RUN("%clang_cc1 -triple i686-pc-win32 -std=c++11 -fms-extensions -fms-compatibility-version=18.00 -verify %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i686-pc-win32 -std=c++11 -fms-extensions -fms-compatibility-version=19.00 -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/declspec-thread.cpp
    RUN("%clang_cc1 -triple i686-pc-win32 -std=c++11 -fms-extensions -fms-compatibility-version=19.00 -verify %s");
  }

  @Test
  public void test_decltype_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/decltype.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c++11 -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/decltype.cpp
    RUN("%clang_cc1 -std=c++11 -fsyntax-only -verify %s");
  }

  @Test
  public void test_decltype_98_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/decltype-98.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c++98 -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/decltype-98.cpp
    RUN("%clang_cc1 -std=c++98 -fsyntax-only -verify %s");
  }

  @Test
  public void test_decltype_crash_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/decltype-crash.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -Wc++11-compat -std=c++98 ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/decltype-crash.cpp
    RUN("%clang_cc1 -fsyntax-only -verify -Wc++11-compat -std=c++98 %s");
  }

  @Test
  public void test_decltype_overloaded_functions_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/decltype-overloaded-functions.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/decltype-overloaded-functions.cpp -std=c++11
    RUN("%clang_cc1 -fsyntax-only -verify %s -std=c++11");
  }

  @Test
  public void test_decltype_pr4444_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/decltype-pr4444.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/decltype-pr4444.cpp -std=c++11
    RUN("%clang_cc1 -fsyntax-only -verify %s -std=c++11");
  }

  @Test
  public void test_decltype_pr4448_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/decltype-pr4448.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/decltype-pr4448.cpp -std=c++11
    RUN("%clang_cc1 -fsyntax-only -verify %s -std=c++11");
  }

  @Test
  public void test_decltype_this_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/decltype-this.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -std=c++11 ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/decltype-this.cpp
    RUN("%clang_cc1 -fsyntax-only -verify -std=c++11 %s");
  }

  @Test
  public void test_default_argument_temporaries_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/default-argument-temporaries.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/default-argument-temporaries.cpp
    RUN("%clang_cc1 -fsyntax-only -verify %s");
  }

  @Test
  public void test_default_assignment_operator_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/default-assignment-operator.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/default-assignment-operator.cpp
    RUN("%clang_cc1 -fsyntax-only -verify %s");
  }

  @Test
  public void test_default_constructor_initializers_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/default-constructor-initializers.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/default-constructor-initializers.cpp
    RUN("%clang_cc1 -fsyntax-only -verify %s");
  }

  @Test
  public void test_default1_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/default1.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/default1.cpp
    RUN("%clang_cc1 -fsyntax-only -verify %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -std=c++98 ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/default1.cpp
    RUN("%clang_cc1 -fsyntax-only -verify -std=c++98 %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -std=c++11 ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/default1.cpp
    RUN("%clang_cc1 -fsyntax-only -verify -std=c++11 %s");
  }

  @Test
  public void test_default2_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/default2.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/default2.cpp
    RUN("%clang_cc1 -fsyntax-only -verify %s");
  }

  @Test
  public void test_defaulted_ctor_loop_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/defaulted-ctor-loop.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -std=c++11 ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/defaulted-ctor-loop.cpp
    RUN("%clang_cc1 -fsyntax-only -verify -std=c++11 %s");
  }

  @Test
  public void test_defaulted_private_dtor_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/defaulted-private-dtor.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -verify -std=c++11 ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/defaulted-private-dtor.cpp -fcxx-exceptions
    RUN("%clang_cc1 -verify -std=c++11 %s -fcxx-exceptions");
  }

  @Test
  public void test_delete_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/delete.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -include ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/delete-mismatch.h -fdiagnostics-parseable-fixits -std=c++11 ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/delete.cpp 2>&1 | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/delete.cpp
    RUN(TestState.Failed, "%clang_cc1 -fsyntax-only -include %S/delete-mismatch.h -fdiagnostics-parseable-fixits -std=c++11 %s 2>&1")./*|*/
      I("FileCheck %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x c++-header -std=c++11 -emit-pch -o ${TEST_TEMP_DIR}/delete.cpp.tmp ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/delete-mismatch.h
    RUN(TestState.Failed, "%clang_cc1 -x c++-header -std=c++11 -emit-pch -o %t %S/delete-mismatch.h");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c++11 -include-pch ${TEST_TEMP_DIR}/delete.cpp.tmp -DWITH_PCH -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/delete.cpp -ast-dump
    RUN(TestState.Failed, "%clang_cc1 -std=c++11 -include-pch %t -DWITH_PCH -fsyntax-only -verify %s -ast-dump");
  }

  @Test
  public void test_delete_and_function_templates_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/delete-and-function-templates.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c++11 -verify -fsyntax-only -emit-llvm-only ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/delete-and-function-templates.cpp
    RUN("%clang_cc1 -std=c++11 -verify -fsyntax-only  -emit-llvm-only %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c++11 -verify -fsyntax-only -fdelayed-template-parsing ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/delete-and-function-templates.cpp
    RUN("%clang_cc1 -std=c++11 -verify -fsyntax-only  -fdelayed-template-parsing %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c++11 -verify -fsyntax-only -fms-extensions ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/delete-and-function-templates.cpp
    RUN("%clang_cc1 -std=c++11 -verify -fsyntax-only  -fms-extensions %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c++11 -verify -fsyntax-only -fdelayed-template-parsing -fms-extensions ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/delete-and-function-templates.cpp
    RUN("%clang_cc1 -std=c++11 -verify -fsyntax-only  -fdelayed-template-parsing -fms-extensions %s");
  }

  @Test
  public void test_deleted_function_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/deleted-function.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -std=c++11 -fcxx-exceptions ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/deleted-function.cpp
    RUN("%clang_cc1 -fsyntax-only -verify -std=c++11 -fcxx-exceptions %s");
  }

  @Test
  public void test_deleted_function_access_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/deleted-function-access.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -std=c++11 -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/deleted-function-access.cpp
    RUN("%clang_cc1 -fsyntax-only -std=c++11 -verify %s");
  }

  @Test
  public void test_deleted_operator_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/deleted-operator.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -std=c++11 ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/deleted-operator.cpp
    RUN("%clang_cc1 -fsyntax-only -verify -std=c++11 %s");
  }

  @Test
  public void test_dependent_auto_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/dependent-auto.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/dependent-auto.cpp -std=c++11
    RUN("%clang_cc1 -fsyntax-only -verify %s -std=c++11");
  }

  @Test
  public void test_dependent_noexcept_unevaluated_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/dependent-noexcept-unevaluated.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -std=c++11 ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/dependent-noexcept-unevaluated.cpp
    RUN("%clang_cc1 -fsyntax-only -std=c++11 %s");
  }

  @Test
  public void test_dependent_types_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/dependent-types.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -pedantic -verify -std=c++11 ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/dependent-types.cpp
    RUN("%clang_cc1 -fsyntax-only -pedantic -verify -std=c++11 %s");
  }

  @Test
  public void test_deprecated_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/deprecated.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c++98 ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/deprecated.cpp -Wdeprecated -verify -triple x86_64-linux-gnu
    RUN("%clang_cc1 -std=c++98 %s -Wdeprecated -verify -triple x86_64-linux-gnu");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c++11 ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/deprecated.cpp -Wdeprecated -verify -triple x86_64-linux-gnu
    RUN("%clang_cc1 -std=c++11 %s -Wdeprecated -verify -triple x86_64-linux-gnu");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c++1y ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/deprecated.cpp -Wdeprecated -verify -triple x86_64-linux-gnu
    RUN("%clang_cc1 -std=c++1y %s -Wdeprecated -verify -triple x86_64-linux-gnu");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c++1z ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/deprecated.cpp -Wdeprecated -verify -triple x86_64-linux-gnu
    RUN("%clang_cc1 -std=c++1z %s -Wdeprecated -verify -triple x86_64-linux-gnu");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c++1y ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/deprecated.cpp -Wdeprecated -verify -triple x86_64-linux-gnu -Wno-deprecated-register -DNO_DEPRECATED_FLAGS
    RUN("%clang_cc1 -std=c++1y %s -Wdeprecated -verify -triple x86_64-linux-gnu -Wno-deprecated-register -DNO_DEPRECATED_FLAGS");
  }

  @Test
  public void test_derived_to_base_ambig_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/derived-to-base-ambig.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/derived-to-base-ambig.cpp
    RUN("%clang_cc1 -fsyntax-only -verify %s");
  }

  @Test
  public void test_destructor_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/destructor.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c++11 -triple i386-pc-solaris2.11 -fsyntax-only -Wnon-virtual-dtor -Wdelete-non-virtual-dtor -fcxx-exceptions -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/destructor.cpp
    RUN("%clang_cc1 -std=c++11 -triple %itanium_abi_triple -fsyntax-only -Wnon-virtual-dtor -Wdelete-non-virtual-dtor -fcxx-exceptions -verify %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c++11 -triple i386-pc-win32 -DMSABI -fsyntax-only -Wnon-virtual-dtor -Wdelete-non-virtual-dtor -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/destructor.cpp
    RUN("%clang_cc1 -std=c++11 -triple %ms_abi_triple -DMSABI -fsyntax-only -Wnon-virtual-dtor -Wdelete-non-virtual-dtor -verify %s");
  }

  @Test
  public void test_devirtualize_vtable_marking_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/devirtualize-vtable-marking.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -verify -std=c++11 ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/devirtualize-vtable-marking.cpp
    RUN("%clang_cc1 -verify -std=c++11 %s");
  }

  @Test
  public void test_diagnostic_order_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/diagnostic-order.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c++11 ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/diagnostic-order.cpp -fsyntax-only 2>&1 | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/diagnostic-order.cpp
    RUN("not %clang_cc1 -std=c++11 %s -fsyntax-only 2>&1")./*|*/
      I("FileCheck %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c++11 ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/diagnostic-order.cpp -fsyntax-only -DWARN 2>&1 | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/diagnostic-order.cpp --check-prefix=CHECK-WARN
    RUN("%clang_cc1 -std=c++11 %s -fsyntax-only -DWARN 2>&1")./*|*/
      I("FileCheck %s --check-prefix=CHECK-WARN");
  }

  @Test
  public void test_direct_initializer_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/direct-initializer.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/direct-initializer.cpp
    RUN("%clang_cc1 -fsyntax-only -verify %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -std=c++98 ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/direct-initializer.cpp
    RUN("%clang_cc1 -fsyntax-only -verify -std=c++98 %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -std=c++11 ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/direct-initializer.cpp
    RUN("%clang_cc1 -fsyntax-only -verify -std=c++11 %s");
  }

  @Test
  public void test_discrim_union_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/discrim-union.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c++11 ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/discrim-union.cpp -fsyntax-only -fcxx-exceptions
    RUN("%clang_cc1 -std=c++11 %s -fsyntax-only -fcxx-exceptions");
  }

  @Test
  public void test_dllexport_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/dllexport.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i686-win32 -fsyntax-only -fms-extensions -verify -std=c++11 -Wunsupported-dll-base-class-template -DMS ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/dllexport.cpp
    RUN("%clang_cc1 -triple i686-win32     -fsyntax-only -fms-extensions -verify -std=c++11 -Wunsupported-dll-base-class-template -DMS %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-win32 -fsyntax-only -fms-extensions -verify -std=c++1y -Wunsupported-dll-base-class-template -DMS ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/dllexport.cpp
    RUN("%clang_cc1 -triple x86_64-win32   -fsyntax-only -fms-extensions -verify -std=c++1y -Wunsupported-dll-base-class-template -DMS %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i686-mingw32 -fsyntax-only -fms-extensions -verify -std=c++1y -Wunsupported-dll-base-class-template ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/dllexport.cpp
    RUN("%clang_cc1 -triple i686-mingw32   -fsyntax-only -fms-extensions -verify -std=c++1y -Wunsupported-dll-base-class-template %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-mingw32 -fsyntax-only -fms-extensions -verify -std=c++11 -Wunsupported-dll-base-class-template ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/dllexport.cpp
    RUN("%clang_cc1 -triple x86_64-mingw32 -fsyntax-only -fms-extensions -verify -std=c++11 -Wunsupported-dll-base-class-template %s");
  }

  @Test
  public void test_dllexport_pr22591_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/dllexport-pr22591.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i686-windows-gnu -fms-extensions -verify -std=c++03 ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/dllexport-pr22591.cpp
    RUN("%clang_cc1 -triple i686-windows-gnu  -fms-extensions -verify -std=c++03 %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i686-windows-gnu -fms-extensions -verify -std=c++11 ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/dllexport-pr22591.cpp
    RUN("%clang_cc1 -triple i686-windows-gnu  -fms-extensions -verify -std=c++11 %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i686-windows-msvc -fms-extensions -verify -std=c++03 -DERROR ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/dllexport-pr22591.cpp
    RUN("%clang_cc1 -triple i686-windows-msvc -fms-extensions -verify -std=c++03 -DERROR %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i686-windows-msvc -fms-extensions -verify -std=c++11 ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/dllexport-pr22591.cpp
    RUN("%clang_cc1 -triple i686-windows-msvc -fms-extensions -verify -std=c++11 %s");
  }

  @Test
  public void test_dllimport_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/dllimport.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i686-win32 -fsyntax-only -fms-extensions -verify -std=c++11 -Wunsupported-dll-base-class-template -DMS ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/dllimport.cpp
    RUN("%clang_cc1 -triple i686-win32     -fsyntax-only -fms-extensions -verify -std=c++11 -Wunsupported-dll-base-class-template -DMS %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-win32 -fsyntax-only -fms-extensions -verify -std=c++1y -Wunsupported-dll-base-class-template -DMS ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/dllimport.cpp
    RUN("%clang_cc1 -triple x86_64-win32   -fsyntax-only -fms-extensions -verify -std=c++1y -Wunsupported-dll-base-class-template -DMS %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i686-mingw32 -fsyntax-only -fms-extensions -verify -std=c++1y -Wunsupported-dll-base-class-template -DGNU ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/dllimport.cpp
    RUN("%clang_cc1 -triple i686-mingw32   -fsyntax-only -fms-extensions -verify -std=c++1y -Wunsupported-dll-base-class-template -DGNU %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-mingw32 -fsyntax-only -fms-extensions -verify -std=c++11 -Wunsupported-dll-base-class-template -DGNU ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/dllimport.cpp
    RUN("%clang_cc1 -triple x86_64-mingw32 -fsyntax-only -fms-extensions -verify -std=c++11 -Wunsupported-dll-base-class-template -DGNU %s");
  }

  @Test
  public void test_do_while_scope_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/do-while-scope.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/do-while-scope.cpp
    RUN("%clang_cc1 -fsyntax-only -verify %s");
  }

  @Test
  public void test_dr1301_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/dr1301.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c++11 -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/dr1301.cpp
    RUN("%clang_cc1 -std=c++11 -verify %s");
  }

  @Test
  public void test_dynamic_cast_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/dynamic-cast.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/dynamic-cast.cpp
    RUN("%clang_cc1 -fsyntax-only -verify %s");
  }

  @Test
  public void test_elaborated_type_specifier_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/elaborated-type-specifier.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/elaborated-type-specifier.cpp
    RUN("%clang_cc1 -fsyntax-only -verify %s");
  }

  @Test
  public void test_empty_class_layout_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/empty-class-layout.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-unknown-unknown ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/empty-class-layout.cpp -fsyntax-only -verify -Wno-inaccessible-base
    RUN("%clang_cc1 -triple x86_64-unknown-unknown %s -fsyntax-only -verify -Wno-inaccessible-base");
  }

  @Test
  public void test_enable_if_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/enable_if.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c++11 -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/enable_if.cpp
    RUN("%clang_cc1 -std=c++11 -verify %s");
  }

  @Test
  public void test_enum_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/enum.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -pedantic -std=c++98 -verify -triple x86_64-apple-darwin ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/enum.cpp
    RUN("%clang_cc1 -fsyntax-only -pedantic -std=c++98 -verify -triple x86_64-apple-darwin %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -pedantic -std=c++11 -verify -triple x86_64-apple-darwin ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/enum.cpp
    RUN("%clang_cc1 -fsyntax-only -pedantic -std=c++11 -verify -triple x86_64-apple-darwin %s");
  }

  @Test
  public void test_enum_bitfield_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/enum-bitfield.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -pedantic -std=c++11 -verify -triple x86_64-apple-darwin ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/enum-bitfield.cpp
    RUN("%clang_cc1 -fsyntax-only -pedantic -std=c++11 -verify -triple x86_64-apple-darwin %s");
  }

  @Test
  public void test_enum_increment_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/enum-increment.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/enum-increment.cpp -verify
    RUN("%clang_cc1 -fsyntax-only %s -verify");
  }

  @Test
  public void test_enum_scoped_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/enum-scoped.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -pedantic -std=c++11 -verify -triple x86_64-apple-darwin ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/enum-scoped.cpp
    RUN("%clang_cc1 -fsyntax-only -pedantic -std=c++11 -verify -triple x86_64-apple-darwin %s");
  }

  @Test
  public void test_enum_unscoped_nonexistent_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/enum-unscoped-nonexistent.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c++11 -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/enum-unscoped-nonexistent.cpp
    RUN("%clang_cc1 -std=c++11 -verify %s");
  }

  @Test
  public void test_err_init_conversion_failed_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/err_init_conversion_failed.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/err_init_conversion_failed.cpp
    RUN("%clang_cc1 -fsyntax-only -verify %s");
  }

  @Test
  public void test_err_reference_bind_drops_quals_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/err_reference_bind_drops_quals.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/err_reference_bind_drops_quals.cpp
    RUN("%clang_cc1 -fsyntax-only -verify %s");
  }

  @Test
  public void test_err_typecheck_assign_const_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/err_typecheck_assign_const.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -std=c++11 -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/err_typecheck_assign_const.cpp
    RUN("%clang_cc1 -fsyntax-only -std=c++11 -verify %s");
  }

  @Test
  public void test_err_typecheck_assign_const_filecheck_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/err_typecheck_assign_const_filecheck.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -std=c++11 ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/err_typecheck_assign_const_filecheck.cpp 2>&1 | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/err_typecheck_assign_const_filecheck.cpp
    RUN("not %clang_cc1 -fsyntax-only -std=c++11 %s 2>&1")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_eval_sizeof_dependent_type_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/eval-sizeof-dependent-type.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-unknown-linux-gnu -fsyntax-only -std=c++11 -x c++ ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/eval-sizeof-dependent-type.cpp
    RUN("%clang_cc1 -triple x86_64-unknown-linux-gnu -fsyntax-only -std=c++11 -x c++ %s");
  }

  @Test
  public void test_exception_spec_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/exception-spec.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -fcxx-exceptions -std=c++11 ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/exception-spec.cpp
    RUN("%clang_cc1 -fsyntax-only -verify -fcxx-exceptions -std=c++11 %s");
  }

  @Test
  public void test_exception_spec_no_exceptions_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/exception-spec-no-exceptions.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -fexceptions -fobjc-exceptions ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/exception-spec-no-exceptions.cpp
    RUN("%clang_cc1 -fsyntax-only -verify -fexceptions -fobjc-exceptions %s");
  }

  @Test
  public void test_exceptions_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/exceptions.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fcxx-exceptions -fexceptions -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/exceptions.cpp
    RUN("%clang_cc1 -fcxx-exceptions -fexceptions -fsyntax-only -verify %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fcxx-exceptions -fexceptions -fsyntax-only -verify -std=c++98 ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/exceptions.cpp
    RUN("%clang_cc1 -fcxx-exceptions -fexceptions -fsyntax-only -verify -std=c++98 %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fcxx-exceptions -fexceptions -fsyntax-only -verify -std=c++11 ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/exceptions.cpp
    RUN("%clang_cc1 -fcxx-exceptions -fexceptions -fsyntax-only -verify -std=c++11 %s");
  }

  @Test
  public void test_exceptions_seh_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/exceptions-seh.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c++03 -fblocks -triple x86_64-windows-msvc -fms-extensions -fsyntax-only -fexceptions -fcxx-exceptions -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/exceptions-seh.cpp
    RUN("%clang_cc1 -std=c++03 -fblocks -triple x86_64-windows-msvc -fms-extensions -fsyntax-only -fexceptions -fcxx-exceptions -verify %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c++11 -fblocks -triple x86_64-windows-msvc -fms-extensions -fsyntax-only -fexceptions -fcxx-exceptions -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/exceptions-seh.cpp
    RUN("%clang_cc1 -std=c++11 -fblocks -triple x86_64-windows-msvc -fms-extensions -fsyntax-only -fexceptions -fcxx-exceptions -verify %s");
  }

  @Test
  public void test_explicit_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/explicit.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -std=c++11 ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/explicit.cpp
    RUN("%clang_cc1 -fsyntax-only -verify -std=c++11 %s");
  }

  @Test
  public void test_expression_traits_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/expression-traits.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -fcxx-exceptions ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/expression-traits.cpp
    RUN("%clang_cc1 -fsyntax-only -verify -fcxx-exceptions %s");
  }

  @Test
  public void test_expressions_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/expressions.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -Wno-constant-conversion ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/expressions.cpp
    RUN("%clang_cc1 -fsyntax-only -verify -Wno-constant-conversion %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -Wno-constant-conversion -std=c++98 ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/expressions.cpp
    RUN("%clang_cc1 -fsyntax-only -verify -Wno-constant-conversion -std=c++98 %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -Wno-constant-conversion -std=c++11 ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/expressions.cpp
    RUN("%clang_cc1 -fsyntax-only -verify -Wno-constant-conversion -std=c++11 %s");
  }

  @Test
  public void test_extern_c_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/extern-c.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/extern-c.cpp
    RUN("%clang_cc1 -fsyntax-only -verify %s");
  }

  @Test
  public void test_flexible_array_test_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/flexible-array-test.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/flexible-array-test.cpp
    RUN("%clang_cc1 -fsyntax-only -verify %s");
  }

  @Test
  public void test_fntype_decl_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/fntype-decl.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/fntype-decl.cpp
    RUN("%clang_cc1 -fsyntax-only -verify %s");
  }

  @Test
  public void test_for_range_dereference_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/for-range-dereference.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c++11 -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/for-range-dereference.cpp
    RUN("%clang_cc1 -std=c++11 -fsyntax-only -verify %s");
  }

  @Test
  public void test_for_range_examples_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/for-range-examples.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/for-range-examples.cpp -std=c++11
    RUN("%clang_cc1 -fsyntax-only -verify %s -std=c++11");
  }

  @Test
  public void test_for_range_no_std_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/for-range-no-std.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/for-range-no-std.cpp -std=c++11
    RUN("%clang_cc1 -fsyntax-only -verify %s -std=c++11");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/for-range-no-std.cpp -std=c++98 -Wno-c++11-extensions
    RUN("%clang_cc1 -fsyntax-only -verify %s -std=c++98 -Wno-c++11-extensions");
  }

  @Test
  public void test_for_range_unused_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/for-range-unused.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/for-range-unused.cpp -std=c++11 -Wunused
    RUN("%clang_cc1 -fsyntax-only -verify %s -std=c++11 -Wunused");
  }

  @Test
  public void test_format_strings_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/format-strings.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -Wformat-nonliteral -Wformat-non-iso -fblocks ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/format-strings.cpp
    RUN("%clang_cc1 -fsyntax-only -verify -Wformat-nonliteral -Wformat-non-iso -fblocks %s");
  }

  @Test
  public void test_format_strings_0x_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/format-strings-0x.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -pedantic -std=c++11 ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/format-strings-0x.cpp
    RUN("%clang_cc1 -fsyntax-only -verify -pedantic -std=c++11 %s");
  }

  @Test
  public void test_format_strings_0x_nopedantic_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/format-strings-0x-nopedantic.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -Wformat -std=c++11 ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/format-strings-0x-nopedantic.cpp
    RUN("%clang_cc1 -fsyntax-only -verify -Wformat -std=c++11 %s");
  }

  @Test
  public void test_friend_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/friend.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/friend.cpp -std=c++14
    RUN("%clang_cc1 -fsyntax-only -verify %s -std=c++14");
  }

  @Test
  public void test_friend_class_nodecl_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/friend-class-nodecl.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -ast-print ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/friend-class-nodecl.cpp -o ${TEST_TEMP_DIR}/friend-class-nodecl.cpp.tmp
    RUN("%clang_cc1 -ast-print %s -o %t");
    // grep '^ *class B' ${TEST_TEMP_DIR}/friend-class-nodecl.cpp.tmp
    RUN("not grep '^ *class B' %t");
  }

  @Test
  public void test_friend_out_of_line_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/friend-out-of-line.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/friend-out-of-line.cpp
    RUN("%clang_cc1 -fsyntax-only -verify %s");
  }

  @Test
  public void test_funcdname_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/funcdname.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c++1y -triple i386-pc-win32 -fms-compatibility -fms-extensions -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/funcdname.cpp
    RUN("%clang_cc1 -std=c++1y -triple i386-pc-win32 -fms-compatibility -fms-extensions -fsyntax-only -verify %s");
  }

  @Test
  public void test_function_extern_c_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/function-extern-c.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -Wreturn-type -fsyntax-only -std=c++11 -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/function-extern-c.cpp
    RUN("%clang_cc1 -Wreturn-type -fsyntax-only -std=c++11 -verify %s");
  }

  @Test
  public void test_function_overload_typo_crash_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/function-overload-typo-crash.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/function-overload-typo-crash.cpp
    RUN("%clang_cc1 -fsyntax-only -verify %s");
  }

  @Test
  public void test_function_overloaded_redecl_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/function-overloaded-redecl.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/function-overloaded-redecl.cpp
    RUN("%clang_cc1 -fsyntax-only -verify %s");
  }

  @Test
  public void test_function_pointer_arguments_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/function-pointer-arguments.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/function-pointer-arguments.cpp
    RUN("%clang_cc1 -fsyntax-only -verify %s");
  }

  @Test
  public void test_function_redecl_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/function-redecl.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/function-redecl.cpp
    RUN("%clang_cc1 -fsyntax-only -verify %s");
  }

  @Test
  public void test_function_type_qual_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/function-type-qual.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/function-type-qual.cpp
    RUN("%clang_cc1 -fsyntax-only -verify %s");
  }

  @Test
  public void test_functional_cast_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/functional-cast.cpp");
    // REQUIRES: LP64
    if (!CHECK_REQUIRES("LP64")) {
      return;
    }
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c++11 -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/functional-cast.cpp
    RUN("%clang_cc1 -std=c++11 -fsyntax-only -verify %s");
  }

  @Test
  public void test_generalized_deprecated_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/generalized-deprecated.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c++11 -verify -fsyntax-only -fms-extensions -Wno-deprecated -Wc++14-extensions ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/generalized-deprecated.cpp
    RUN("%clang_cc1 -std=c++11 -verify -fsyntax-only -fms-extensions -Wno-deprecated -Wc++14-extensions %s");
  }

  @Test
  public void test_generic_selection_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/generic-selection.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c++11 -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/generic-selection.cpp
    RUN("%clang_cc1 -std=c++11 -fsyntax-only -verify %s");
  }

  @Test
  public void test_gnu_case_ranges_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/gnu-case-ranges.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -verify -Wno-covered-switch-default ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/gnu-case-ranges.cpp
    RUN("%clang_cc1 -verify -Wno-covered-switch-default %s");
  }

  @Test
  public void test_gnu_flags_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/gnu-flags.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/gnu-flags.cpp -DNONE -Wno-gnu
    RUN("%clang_cc1 -fsyntax-only -verify %s -DNONE -Wno-gnu");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -std=c++98 ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/gnu-flags.cpp -DNONE -Wno-gnu
    RUN("%clang_cc1 -fsyntax-only -verify -std=c++98 %s -DNONE -Wno-gnu");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -std=c++11 ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/gnu-flags.cpp -DNONE -Wno-gnu
    RUN("%clang_cc1 -fsyntax-only -verify -std=c++11 %s -DNONE -Wno-gnu");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/gnu-flags.cpp -DALL -Wgnu
    RUN("%clang_cc1 -fsyntax-only -verify %s -DALL -Wgnu");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -std=c++98 ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/gnu-flags.cpp -DALL -Wgnu
    RUN("%clang_cc1 -fsyntax-only -verify -std=c++98 %s -DALL -Wgnu");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -std=c++11 ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/gnu-flags.cpp -DALL -Wgnu
    RUN("%clang_cc1 -fsyntax-only -verify -std=c++11 %s -DALL -Wgnu");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/gnu-flags.cpp -DALL -Wno-gnu -Wgnu-anonymous-struct -Wredeclared-class-member -Wgnu-flexible-array-union-member -Wgnu-folding-constant -Wgnu-empty-struct
    RUN("%clang_cc1 -fsyntax-only -verify %s -DALL -Wno-gnu -Wgnu-anonymous-struct -Wredeclared-class-member -Wgnu-flexible-array-union-member -Wgnu-folding-constant -Wgnu-empty-struct");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -std=c++98 ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/gnu-flags.cpp -DALL -Wno-gnu -Wgnu-anonymous-struct -Wredeclared-class-member -Wgnu-flexible-array-union-member -Wgnu-folding-constant -Wgnu-empty-struct
    RUN("%clang_cc1 -fsyntax-only -verify -std=c++98 %s -DALL -Wno-gnu -Wgnu-anonymous-struct -Wredeclared-class-member -Wgnu-flexible-array-union-member -Wgnu-folding-constant -Wgnu-empty-struct");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -std=c++11 ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/gnu-flags.cpp -DALL -Wno-gnu -Wgnu-anonymous-struct -Wredeclared-class-member -Wgnu-flexible-array-union-member -Wgnu-folding-constant -Wgnu-empty-struct
    RUN("%clang_cc1 -fsyntax-only -verify -std=c++11 %s -DALL -Wno-gnu -Wgnu-anonymous-struct -Wredeclared-class-member -Wgnu-flexible-array-union-member -Wgnu-folding-constant -Wgnu-empty-struct");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/gnu-flags.cpp -DNONE -Wgnu -Wno-gnu-anonymous-struct -Wno-redeclared-class-member -Wno-gnu-flexible-array-union-member -Wno-gnu-folding-constant -Wno-gnu-empty-struct
    RUN("%clang_cc1 -fsyntax-only -verify %s -DNONE -Wgnu -Wno-gnu-anonymous-struct -Wno-redeclared-class-member -Wno-gnu-flexible-array-union-member -Wno-gnu-folding-constant -Wno-gnu-empty-struct");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -std=c++98 ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/gnu-flags.cpp -DNONE -Wgnu -Wno-gnu-anonymous-struct -Wno-redeclared-class-member -Wno-gnu-flexible-array-union-member -Wno-gnu-folding-constant -Wno-gnu-empty-struct
    RUN("%clang_cc1 -fsyntax-only -verify -std=c++98 %s -DNONE -Wgnu -Wno-gnu-anonymous-struct -Wno-redeclared-class-member -Wno-gnu-flexible-array-union-member -Wno-gnu-folding-constant -Wno-gnu-empty-struct");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -std=c++11 ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/gnu-flags.cpp -DNONE -Wgnu -Wno-gnu-anonymous-struct -Wno-redeclared-class-member -Wno-gnu-flexible-array-union-member -Wno-gnu-folding-constant -Wno-gnu-empty-struct
    RUN("%clang_cc1 -fsyntax-only -verify -std=c++11 %s -DNONE -Wgnu -Wno-gnu-anonymous-struct -Wno-redeclared-class-member -Wno-gnu-flexible-array-union-member -Wno-gnu-folding-constant -Wno-gnu-empty-struct");
  }

  @Test
  public void test_goto_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/goto.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -Wall -fblocks ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/goto.cpp
    RUN("%clang_cc1 -fsyntax-only -verify -Wall -fblocks %s");
  }

  @Test
  public void test_goto2_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/goto2.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/goto2.cpp
    RUN("%clang_cc1 -fsyntax-only -verify %s");
  }

  @Test
  public void test_i_c_e_cxx_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/i-c-e-cxx.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -pedantic ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/i-c-e-cxx.cpp
    RUN("%clang_cc1 -fsyntax-only -verify -pedantic %s");
  }

  @Test
  public void test_illegal_member_initialization_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/illegal-member-initialization.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/illegal-member-initialization.cpp
    RUN("%clang_cc1 -fsyntax-only -verify %s");
  }

  @Test
  public void test_implicit_exception_spec_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/implicit-exception-spec.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -fcxx-exceptions -verify -std=c++11 -Wall -Wno-unused-local-typedefs ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/implicit-exception-spec.cpp
    RUN("%clang_cc1 -fsyntax-only -fcxx-exceptions -verify -std=c++11 -Wall -Wno-unused-local-typedefs %s");
  }

  @Test
  public void test_implicit_int_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/implicit-int.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/implicit-int.cpp
    RUN("%clang_cc1 -fsyntax-only -verify %s");
  }

  @Test
  public void test_implicit_member_functions_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/implicit-member-functions.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -std=c++11 ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/implicit-member-functions.cpp
    RUN("%clang_cc1 -fsyntax-only -verify -std=c++11 %s");
  }

  @Test
  public void test_implicit_virtual_member_functions_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/implicit-virtual-member-functions.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -triple i386-pc-solaris2.11 -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/implicit-virtual-member-functions.cpp
    RUN("%clang_cc1 -fsyntax-only -triple %itanium_abi_triple -verify %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -triple i386-pc-win32 -DMSABI -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/implicit-virtual-member-functions.cpp
    RUN("%clang_cc1 -fsyntax-only -triple %ms_abi_triple -DMSABI -verify %s");
  }

  @Test
  public void test_incomplete_call_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/incomplete-call.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/incomplete-call.cpp
    RUN("%clang_cc1 -fsyntax-only -verify %s");
  }

  @Test
  public void test_increment_decrement_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/increment-decrement.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/increment-decrement.cpp
    RUN("%clang_cc1 -fsyntax-only -verify %s");
  }

  @Test
  public void test_indirect_goto_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/indirect-goto.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/indirect-goto.cpp
    RUN("%clang_cc1 -fsyntax-only -verify %s");
  }

  @Test
  public void test_inherit_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/inherit.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/inherit.cpp
    RUN("%clang_cc1 -fsyntax-only -verify %s");
  }

  @Test
  public void test_init_priority_attr_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/init-priority-attr.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/init-priority-attr.cpp
    RUN("%clang_cc1 -fsyntax-only -verify %s");
  }

  @Test
  public void test_inline_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/inline.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/inline.cpp
    RUN("%clang_cc1 -fsyntax-only -verify %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -std=c++14 ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/inline.cpp
    RUN("%clang_cc1 -fsyntax-only -verify -std=c++14 %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -std=c++1z ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/inline.cpp -Wc++98-c++11-c++14-compat
    RUN("%clang_cc1 -fsyntax-only -verify -std=c++1z %s -Wc++98-c++11-c++14-compat");
  }

  @Test
  public void test_instantiate_blocks_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/instantiate-blocks.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fblocks -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/instantiate-blocks.cpp
    RUN("%clang_cc1 -fblocks -fsyntax-only -verify %s");
  }

  @Test
  public void test_integer_overflow_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/integer-overflow.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/integer-overflow.cpp -verify -fsyntax-only -std=gnu++98 -triple x86_64-pc-linux-gnu
    RUN("%clang_cc1 %s -verify -fsyntax-only -std=gnu++98 -triple x86_64-pc-linux-gnu");
  }

  @Test
  public void test_internal_linkage_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/internal_linkage.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c++11 -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/internal_linkage.cpp
    RUN("%clang_cc1 -std=c++11 -fsyntax-only -verify %s");
  }

  @Test
  public void test_invalid_instantiated_field_decl_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/invalid-instantiated-field-decl.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/invalid-instantiated-field-decl.cpp
    RUN("%clang_cc1 -fsyntax-only -verify %s");
  }

  @Test
  public void test_invalid_member_expr_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/invalid-member-expr.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/invalid-member-expr.cpp
    RUN("%clang_cc1 -fsyntax-only -verify %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -std=c++98 ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/invalid-member-expr.cpp
    RUN("%clang_cc1 -fsyntax-only -verify -std=c++98 %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -std=c++11 ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/invalid-member-expr.cpp
    RUN("%clang_cc1 -fsyntax-only -verify -std=c++11 %s");
  }

  @Test
  public void test_invalid_template_specifier_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/invalid-template-specifier.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/invalid-template-specifier.cpp -verify -fsyntax-only
    RUN("%clang_cc1 %s -verify -fsyntax-only");
  }

  @Test
  public void test_issue547_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/issue547.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c++11 -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/issue547.cpp
    RUN("%clang_cc1 -std=c++11 -fsyntax-only -verify %s");
  }

  @Test
  public void test_lambda_expressions_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/lambda-expressions.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c++14 -Wno-unused-value -fsyntax-only -verify -fblocks ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/lambda-expressions.cpp
    RUN("%clang_cc1 -std=c++14 -Wno-unused-value -fsyntax-only -verify -fblocks %s");
  }

  @Test
  public void test_libstdcxx_atomic_ns_hack_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/libstdcxx_atomic_ns_hack.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -std=c++11 -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/libstdcxx_atomic_ns_hack.cpp
    RUN("%clang_cc1 -fsyntax-only -std=c++11 -verify %s");
  }

  @Test
  public void test_libstdcxx_common_type_hack_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/libstdcxx_common_type_hack.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/libstdcxx_common_type_hack.cpp -std=c++11 -verify
    RUN("%clang_cc1 -fsyntax-only %s -std=c++11 -verify");
  }

  @Test
  public void test_libstdcxx_explicit_init_list_hack_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/libstdcxx_explicit_init_list_hack.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c++11 -fsyntax-only -verify -Wsystem-headers ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/libstdcxx_explicit_init_list_hack.cpp
    RUN("%clang_cc1 -std=c++11 -fsyntax-only -verify -Wsystem-headers %s");
  }

  @Test
  public void test_libstdcxx_is_pod_hack_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/libstdcxx_is_pod_hack.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/libstdcxx_is_pod_hack.cpp
    RUN("%clang_cc1 -fsyntax-only -verify %s");
  }

  @Test
  public void test_libstdcxx_map_base_hack_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/libstdcxx_map_base_hack.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/libstdcxx_map_base_hack.cpp
    RUN("%clang_cc1 -fsyntax-only %s");
  }

  @Test
  public void test_libstdcxx_pair_swap_hack_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/libstdcxx_pair_swap_hack.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/libstdcxx_pair_swap_hack.cpp -std=c++11 -verify -fexceptions -fcxx-exceptions -DCLASS=array
    RUN("%clang_cc1 -fsyntax-only %s -std=c++11 -verify -fexceptions -fcxx-exceptions -DCLASS=array");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/libstdcxx_pair_swap_hack.cpp -std=c++11 -verify -fexceptions -fcxx-exceptions -DCLASS=pair
    RUN("%clang_cc1 -fsyntax-only %s -std=c++11 -verify -fexceptions -fcxx-exceptions -DCLASS=pair");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/libstdcxx_pair_swap_hack.cpp -std=c++11 -verify -fexceptions -fcxx-exceptions -DCLASS=priority_queue
    RUN("%clang_cc1 -fsyntax-only %s -std=c++11 -verify -fexceptions -fcxx-exceptions -DCLASS=priority_queue");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/libstdcxx_pair_swap_hack.cpp -std=c++11 -verify -fexceptions -fcxx-exceptions -DCLASS=stack
    RUN("%clang_cc1 -fsyntax-only %s -std=c++11 -verify -fexceptions -fcxx-exceptions -DCLASS=stack");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/libstdcxx_pair_swap_hack.cpp -std=c++11 -verify -fexceptions -fcxx-exceptions -DCLASS=queue
    RUN("%clang_cc1 -fsyntax-only %s -std=c++11 -verify -fexceptions -fcxx-exceptions -DCLASS=queue");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/libstdcxx_pair_swap_hack.cpp -std=c++11 -verify -fexceptions -fcxx-exceptions -DCLASS=array -DMSVC
    RUN("%clang_cc1 -fsyntax-only %s -std=c++11 -verify -fexceptions -fcxx-exceptions -DCLASS=array -DMSVC");
  }

  @Test
  public void test_libstdcxx_pointer_return_false_hack_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/libstdcxx_pointer_return_false_hack.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/libstdcxx_pointer_return_false_hack.cpp -std=c++11 -verify
    RUN("%clang_cc1 -fsyntax-only %s -std=c++11 -verify");
  }

  @Test
  public void test_linkage_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/linkage.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -Werror -triple x86_64-apple-darwin10 -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/linkage.cpp -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/linkage.cpp
    RUN(TestState.SemanticErrors, "%clang_cc1 -Werror -triple x86_64-apple-darwin10 -emit-llvm %s -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_linkage_invalid_decl_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/linkage-invalid-decl.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/linkage-invalid-decl.cpp
    RUN("%clang_cc1 -fsyntax-only -verify %s");
  }

  @Test
  public void test_linkage_spec_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/linkage-spec.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/linkage-spec.cpp
    RUN("%clang_cc1 -fsyntax-only -verify %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -Wretained-language-linkage -DW_RETAINED_LANGUAGE_LINKAGE ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/linkage-spec.cpp
    RUN("%clang_cc1 -fsyntax-only -verify -Wretained-language-linkage -DW_RETAINED_LANGUAGE_LINKAGE  %s");
  }

  @Test
  public void test_linkage2_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/linkage2.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -std=gnu++11 ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/linkage2.cpp
    RUN("%clang_cc1 -fsyntax-only -verify -std=gnu++11 %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -Wno-c++11-extensions -Wno-local-type-template-args ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/linkage2.cpp
    RUN("%clang_cc1 -fsyntax-only -verify -Wno-c++11-extensions -Wno-local-type-template-args %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -Wno-c++11-extensions -Wno-local-type-template-args -fmodules ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/linkage2.cpp
    RUN("%clang_cc1 -fsyntax-only -verify -Wno-c++11-extensions -Wno-local-type-template-args -fmodules %s");
  }

  @Test
  public void test_literal_operators_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/literal-operators.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -std=c++14 ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/literal-operators.cpp
    RUN("%clang_cc1 -fsyntax-only -verify -std=c++14 %s");
  }

  @Test
  public void test_literal_type_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/literal-type.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -std=c++11 ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/literal-type.cpp
    RUN("%clang_cc1 -fsyntax-only -verify -std=c++11 %s");
  }

  @Test
  public void test_local_classes_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/local-classes.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/local-classes.cpp
    RUN("%clang_cc1 -fsyntax-only -verify %s");
  }

  @Test
  public void test_long_virtual_inheritance_chain_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/long-virtual-inheritance-chain.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/long-virtual-inheritance-chain.cpp
    RUN("%clang_cc1 -fsyntax-only %s");
  }

  @Test
  public void test_lookup_member_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/lookup-member.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/lookup-member.cpp
    RUN("%clang_cc1 -fsyntax-only -verify %s");
  }

  @Test
  public void test_make_integer_seq_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/make_integer_seq.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -std=c++11 ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/make_integer_seq.cpp
    RUN("%clang_cc1 -fsyntax-only -verify -std=c++11 %s");
  }

  @Test
  public void test_many_template_parameter_lists_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/many-template-parameter-lists.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/many-template-parameter-lists.cpp
    RUN("%clang_cc1 -fsyntax-only -verify %s");
  }

  @Test
  public void test_member_class_11_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/member-class-11.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c++11 -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/member-class-11.cpp
    RUN("%clang_cc1 -std=c++11 -fsyntax-only -verify %s");
  }

  @Test
  public void test_member_expr_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/member-expr.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/member-expr.cpp
    RUN("%clang_cc1 -fsyntax-only -verify %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -std=c++98 ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/member-expr.cpp
    RUN("%clang_cc1 -fsyntax-only -verify -std=c++98 %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -std=c++11 ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/member-expr.cpp
    RUN("%clang_cc1 -fsyntax-only -verify -std=c++11 %s");
  }

  @Test
  public void test_member_expr_anonymous_union_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/member-expr-anonymous-union.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/member-expr-anonymous-union.cpp -fsyntax-only -verify
    RUN("%clang_cc1 %s -fsyntax-only -verify");
  }

  @Test
  public void test_member_expr_static_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/member-expr-static.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/member-expr-static.cpp
    RUN("%clang_cc1 -fsyntax-only -verify %s");
  }

  @Test
  public void test_member_init_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/member-init.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -fcxx-exceptions -verify -std=c++11 -Wall ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/member-init.cpp
    RUN("%clang_cc1 -fsyntax-only -fcxx-exceptions -verify -std=c++11 -Wall %s");
  }

  @Test
  public void test_member_location_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/member-location.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/member-location.cpp
    RUN("%clang_cc1 -fsyntax-only -verify %s");
  }

  @Test
  public void test_member_name_lookup_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/member-name-lookup.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/member-name-lookup.cpp
    RUN("%clang_cc1 -fsyntax-only -verify %s");
  }

  @Test
  public void test_member_operator_expr_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/member-operator-expr.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/member-operator-expr.cpp
    RUN("%clang_cc1 -fsyntax-only -verify %s");
  }

  @Test
  public void test_member_pointer_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/member-pointer.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/member-pointer.cpp
    RUN(TestState.Failed, "%clang_cc1 -fsyntax-only -verify %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -std=c++98 ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/member-pointer.cpp
    RUN(TestState.Failed, "%clang_cc1 -fsyntax-only -verify -std=c++98 %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -std=c++11 ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/member-pointer.cpp
    RUN(TestState.Failed, "%clang_cc1 -fsyntax-only -verify -std=c++11 %s");
  }

  @Test
  public void test_member_pointer_ms_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/member-pointer-ms.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c++11 -fms-compatibility -fsyntax-only -triple=i386-pc-win32 -verify -DVMB ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/member-pointer-ms.cpp
    RUN("%clang_cc1 -std=c++11 -fms-compatibility -fsyntax-only -triple=i386-pc-win32 -verify -DVMB %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c++11 -fms-compatibility -fsyntax-only -triple=x86_64-pc-win32 -verify -DVMB ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/member-pointer-ms.cpp
    RUN("%clang_cc1 -std=c++11 -fms-compatibility -fsyntax-only -triple=x86_64-pc-win32 -verify -DVMB %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c++11 -fms-compatibility -fsyntax-only -triple=x86_64-pc-win32 -verify -DVMV -fms-memptr-rep=virtual ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/member-pointer-ms.cpp
    RUN("%clang_cc1 -std=c++11 -fms-compatibility -fsyntax-only -triple=x86_64-pc-win32 -verify -DVMV -fms-memptr-rep=virtual %s");
  }

  @Test
  public void test_member_pointer_size_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/member-pointer-size.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-unknown-unknown ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/member-pointer-size.cpp -fsyntax-only -verify
    RUN("%clang_cc1 -triple x86_64-unknown-unknown %s -fsyntax-only -verify");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i686-unknown-unknown ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/member-pointer-size.cpp -fsyntax-only -verify
    RUN("%clang_cc1 -triple i686-unknown-unknown %s -fsyntax-only -verify");
  }

  @Test
  public void test_member_pointers_2_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/member-pointers-2.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm-only ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/member-pointers-2.cpp
    RUN(TestState.SemanticErrors, "%clang_cc1 -emit-llvm-only %s");
  }

  @Test
  public void test_microsoft_cxx0x_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/microsoft-cxx0x.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/microsoft-cxx0x.cpp -triple i686-pc-win32 -fsyntax-only -Wc++11-narrowing -Wmicrosoft -verify -fms-extensions -std=c++11
    RUN("%clang_cc1 %s -triple i686-pc-win32 -fsyntax-only -Wc++11-narrowing -Wmicrosoft -verify -fms-extensions -std=c++11");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/microsoft-cxx0x.cpp -triple i686-pc-win32 -fsyntax-only -Wc++11-narrowing -Wmicrosoft -verify -fms-extensions -std=c++11 -fms-compatibility -DMS_COMPAT
    RUN("%clang_cc1 %s -triple i686-pc-win32 -fsyntax-only -Wc++11-narrowing -Wmicrosoft -verify -fms-extensions -std=c++11 -fms-compatibility -DMS_COMPAT");
  }

  @Test
  public void test_microsoft_dtor_lookup_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/microsoft-dtor-lookup.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fexceptions -fcxx-exceptions -std=c++11 -triple i386-pc-solaris2.11 -fsyntax-only ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/microsoft-dtor-lookup.cpp
    RUN("%clang_cc1 -fexceptions -fcxx-exceptions -std=c++11 -triple %itanium_abi_triple -fsyntax-only %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fexceptions -fcxx-exceptions -std=c++11 -triple i386-pc-win32 -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/microsoft-dtor-lookup.cpp
    RUN("%clang_cc1 -fexceptions -fcxx-exceptions -std=c++11 -triple %ms_abi_triple -verify %s");
  }

  @Test
  public void test_microsoft_dtor_lookup_cxx11_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/microsoft-dtor-lookup-cxx11.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i686-pc-win32 -std=c++11 -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/microsoft-dtor-lookup-cxx11.cpp
    RUN("%clang_cc1 -triple i686-pc-win32 -std=c++11 -verify %s");
  }

  @Test
  public void test_microsoft_new_delete_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/microsoft-new-delete.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fms-compatibility -fsyntax-only -verify -std=c++11 ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/microsoft-new-delete.cpp
    RUN("%clang_cc1 -fms-compatibility -fsyntax-only -verify -std=c++11 %s");
  }

  @Test
  public void test_microsoft_super_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/microsoft-super.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fms-extensions -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/microsoft-super.cpp
    RUN("%clang_cc1 -fms-extensions -verify %s");
  }

  @Test
  public void test_microsoft_varargs_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/microsoft-varargs.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple thumbv7-windows -fms-compatibility -fsyntax-only ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/microsoft-varargs.cpp -verify
    RUN("%clang_cc1 -triple thumbv7-windows -fms-compatibility -fsyntax-only %s -verify");
  }

  @Test
  public void test_microsoft_varargs_diagnostics_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/microsoft-varargs-diagnostics.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple thumbv7-windows -fms-compatibility -fsyntax-only ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/microsoft-varargs-diagnostics.cpp -verify
    RUN("%clang_cc1 -triple thumbv7-windows -fms-compatibility -fsyntax-only %s -verify");
  }

  @Test
  public void test_missing_header_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/missing-header.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/missing-header.cpp
    RUN("%clang_cc1 -fsyntax-only -verify %s");
  }

  @Test
  public void test_missing_members_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/missing-members.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/missing-members.cpp
    RUN("%clang_cc1 -fsyntax-only -verify %s");
  }

  @Test
  public void test_missing_namespace_qualifier_typo_corrections_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/missing-namespace-qualifier-typo-corrections.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -Wno-c++11-extensions ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/missing-namespace-qualifier-typo-corrections.cpp
    RUN("%clang_cc1 -fsyntax-only -verify -Wno-c++11-extensions %s");
  }

  @Test
  public void test_ms_const_member_expr_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/ms-const-member-expr.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/ms-const-member-expr.cpp -std=c++11 -fms-compatibility -fsyntax-only -verify
    RUN("%clang_cc1 %s -std=c++11 -fms-compatibility -fsyntax-only -verify");
  }

  @Test
  public void test_ms_empty_bases_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/ms-empty_bases.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i386-pc-win32 ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/ms-empty_bases.cpp -fsyntax-only -verify -fms-extensions -Wno-microsoft -std=c++11
    RUN("%clang_cc1 -triple i386-pc-win32 %s -fsyntax-only -verify -fms-extensions -Wno-microsoft -std=c++11");
  }

  @Test
  public void test_ms_exception_spec_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/ms-exception-spec.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/ms-exception-spec.cpp -fsyntax-only -verify -fms-extensions -fexceptions -fcxx-exceptions
    RUN("%clang_cc1 %s -fsyntax-only -verify -fms-extensions -fexceptions -fcxx-exceptions");
  }

  @Test
  public void test_ms_friend_lookup_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/ms-friend-lookup.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/ms-friend-lookup.cpp -triple i686-pc-win32 -std=c++11 -Wmicrosoft -fms-compatibility -verify
    RUN("%clang_cc1 %s -triple i686-pc-win32 -std=c++11 -Wmicrosoft -fms-compatibility -verify");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/ms-friend-lookup.cpp -triple i686-pc-win32 -std=c++11 -Wmicrosoft -fms-compatibility -fdiagnostics-parseable-fixits 2>&1 | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/ms-friend-lookup.cpp
    RUN("not %clang_cc1 %s -triple i686-pc-win32 -std=c++11 -Wmicrosoft -fms-compatibility -fdiagnostics-parseable-fixits 2>&1")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_ms_inline_asm_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/ms-inline-asm.cpp");
    // REQUIRES: x86-registered-target
    if (!CHECK_REQUIRES("x86-registered-target")) {
      return;
    }
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/ms-inline-asm.cpp -triple i386-apple-darwin10 -fasm-blocks -verify
    RUN(TestState.Failed, "%clang_cc1 %s -triple i386-apple-darwin10 -fasm-blocks -verify");
  }

  @Test
  public void test_ms_interface_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/ms-interface.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/ms-interface.cpp -fsyntax-only -verify -fms-extensions -Wno-microsoft -std=c++11
    RUN("%clang_cc1 %s -fsyntax-only -verify -fms-extensions -Wno-microsoft -std=c++11");
  }

  @Test
  public void test_ms_layout_version_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/ms-layout_version.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i386-pc-win32 ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/ms-layout_version.cpp -fsyntax-only -verify -fms-extensions -Wno-microsoft -std=c++11
    RUN("%clang_cc1 -triple i386-pc-win32 %s -fsyntax-only -verify -fms-extensions -Wno-microsoft -std=c++11");
  }

  @Test
  public void test_ms_novtable_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/ms-novtable.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i386-pc-win32 ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/ms-novtable.cpp -fsyntax-only -verify -fms-extensions -Wno-microsoft -std=c++11
    RUN("%clang_cc1 -triple i386-pc-win32 %s -fsyntax-only -verify -fms-extensions -Wno-microsoft -std=c++11");
  }

  @Test
  public void test_ms_overload_entry_point_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/ms-overload-entry-point.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -fms-extensions -triple i386-pc-win32 ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/ms-overload-entry-point.cpp
    RUN("%clang_cc1 -fsyntax-only -verify -fms-extensions -triple i386-pc-win32 %s");
  }

  @Test
  public void test_ms_property_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/ms-property.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -ast-print -verify -triple=x86_64-pc-win32 -fms-compatibility ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/ms-property.cpp -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/ms-property.cpp
    RUN("%clang_cc1 -ast-print -verify -triple=x86_64-pc-win32 -fms-compatibility %s -o -")./*|*/
      I("FileCheck %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple=x86_64-pc-win32 -fms-compatibility -emit-pch -o ${TEST_TEMP_DIR}/ms-property.cpp.tmp ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/ms-property.cpp
    RUN("%clang_cc1 -triple=x86_64-pc-win32 -fms-compatibility -emit-pch -o %t %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple=x86_64-pc-win32 -fms-compatibility -include-pch ${TEST_TEMP_DIR}/ms-property.cpp.tmp -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/ms-property.cpp -ast-print -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/ms-property.cpp
    RUN("%clang_cc1 -triple=x86_64-pc-win32 -fms-compatibility -include-pch %t -verify %s -ast-print -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_ms_property_error_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/ms-property-error.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -verify -fms-compatibility ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/ms-property-error.cpp -fsyntax-only -o -
    RUN("%clang_cc1 -verify -fms-compatibility %s -fsyntax-only -o -");
  }

  @Test
  public void test_ms_unsupported_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/ms-unsupported.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-pc-windows-gnu ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/ms-unsupported.cpp -fsyntax-only -verify -fms-extensions -Wno-microsoft -std=c++11
    RUN("%clang_cc1 -triple x86_64-pc-windows-gnu %s -fsyntax-only -verify -fms-extensions -Wno-microsoft -std=c++11");
  }

  @Test
  public void test_ms_wchar_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/ms-wchar.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -fms-extensions -triple i386-pc-win32 ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/ms-wchar.cpp
    RUN("%clang_cc1 -fsyntax-only -verify -fms-extensions -triple i386-pc-win32 %s");
  }

  @Test
  public void test_ms_integer_suffix_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/ms_integer_suffix.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c++11 -fsyntax-only -fms-extensions -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/ms_integer_suffix.cpp
    RUN("%clang_cc1 -std=c++11 -fsyntax-only -fms-extensions -verify %s");
  }

  @Test
  public void test_ms_mutable_reference_member_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/ms_mutable_reference_member.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/ms_mutable_reference_member.cpp -fsyntax-only -verify -fms-compatibility
    RUN("%clang_cc1 %s -fsyntax-only -verify -fms-compatibility");
  }

  @Test
  public void test_ms_struct_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/ms_struct.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -Wno-error=incompatible-ms-struct -verify -triple i686-apple-darwin9 -std=c++11 ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/ms_struct.cpp
    RUN("%clang_cc1 -fsyntax-only -Wno-error=incompatible-ms-struct -verify -triple i686-apple-darwin9 -std=c++11 %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -Wno-error=incompatible-ms-struct -verify -triple armv7-apple-darwin9 -std=c++11 ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/ms_struct.cpp
    RUN("%clang_cc1 -fsyntax-only -Wno-error=incompatible-ms-struct -verify -triple armv7-apple-darwin9 -std=c++11 %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -DTEST_FOR_ERROR -verify -triple armv7-apple-darwin9 -std=c++11 ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/ms_struct.cpp
    RUN("%clang_cc1 -fsyntax-only -DTEST_FOR_ERROR -verify -triple armv7-apple-darwin9 -std=c++11 %s");
  }

  @Test
  public void test_ms_wide_bitfield_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/ms_wide_bitfield.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fno-rtti -emit-llvm-only -triple i686-pc-win32 -fdump-record-layouts -fsyntax-only -mms-bitfields -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/ms_wide_bitfield.cpp 2>&1
    RUN("%clang_cc1 -fno-rtti -emit-llvm-only -triple i686-pc-win32 -fdump-record-layouts -fsyntax-only -mms-bitfields -verify %s 2>&1");
  }

  @Test
  public void test_namespace_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/namespace.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/namespace.cpp
    RUN("%clang_cc1 -fsyntax-only -verify %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -std=c++98 ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/namespace.cpp
    RUN("%clang_cc1 -fsyntax-only -verify -std=c++98 %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -std=c++11 ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/namespace.cpp
    RUN("%clang_cc1 -fsyntax-only -verify -std=c++11 %s");
  }

  @Test
  public void test_namespace_alias_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/namespace-alias.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/namespace-alias.cpp
    RUN("%clang_cc1 -fsyntax-only -verify %s");
  }

  @Test
  public void test_neon_vector_types_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/neon-vector-types.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -triple thumbv7-apple-ios3.0.0 -target-feature +neon ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/neon-vector-types.cpp
    RUN("%clang_cc1 -fsyntax-only -verify \"-triple\" \"thumbv7-apple-ios3.0.0\" -target-feature +neon %s");
  }

  @Test
  public void test_nested_name_spec_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/nested-name-spec.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -std=c++98 -verify -fblocks ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/nested-name-spec.cpp
    RUN( "%clang_cc1 -fsyntax-only -std=c++98 -verify -fblocks %s");
  }

  @Test
  public void test_nested_name_spec_locations_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/nested-name-spec-locations.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/nested-name-spec-locations.cpp
    RUN("%clang_cc1 -fsyntax-only -verify %s");
  }

  @Test
  public void test_new_array_size_conv_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/new-array-size-conv.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -pedantic -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/new-array-size-conv.cpp
    RUN("%clang_cc1 -fsyntax-only -pedantic -verify %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -pedantic -verify -std=c++98 ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/new-array-size-conv.cpp
    RUN("%clang_cc1 -fsyntax-only -pedantic -verify -std=c++98 %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -pedantic -verify -std=c++11 ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/new-array-size-conv.cpp
    RUN("%clang_cc1 -fsyntax-only -pedantic -verify -std=c++11 %s");
  }

  @Test
  public void test_new_delete_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/new-delete.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/new-delete.cpp -triple=i686-pc-linux-gnu -Wno-new-returns-null
    RUN("%clang_cc1 -fsyntax-only -verify %s -triple=i686-pc-linux-gnu -Wno-new-returns-null");
  }

  @Test
  public void test_new_delete_0x_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/new-delete-0x.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/new-delete-0x.cpp -triple=i686-pc-linux-gnu -std=c++11
    RUN("%clang_cc1 -fsyntax-only -verify %s -triple=i686-pc-linux-gnu -std=c++11");
  }

  @Test
  public void test_new_delete_cxx0x_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/new-delete-cxx0x.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/new-delete-cxx0x.cpp -std=c++11 -triple=i686-pc-linux-gnu
    RUN("%clang_cc1 -fsyntax-only -verify %s -std=c++11 -triple=i686-pc-linux-gnu");
  }

  @Test
  public void test_new_delete_predefined_decl_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/new-delete-predefined-decl.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -DTEMPLATE_OVERLOAD -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/new-delete-predefined-decl.cpp
    RUN("%clang_cc1 -DTEMPLATE_OVERLOAD -fsyntax-only -verify %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/new-delete-predefined-decl.cpp
    RUN("%clang_cc1 -fsyntax-only -verify %s");
  }

  @Test
  public void test_new_delete_predefined_decl_2_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/new-delete-predefined-decl-2.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/new-delete-predefined-decl-2.cpp
    RUN("%clang_cc1 -fsyntax-only -verify %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -DQUALIFIED -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/new-delete-predefined-decl-2.cpp
    RUN("%clang_cc1 -DQUALIFIED -fsyntax-only -verify %s");
  }

  @Test
  public void test_new_null_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/new-null.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/new-null.cpp -std=c++98
    RUN("%clang_cc1 -fsyntax-only -verify %s -std=c++98");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/new-null.cpp -std=c++11
    RUN("%clang_cc1 -fsyntax-only -verify %s -std=c++11");
  }

  @Test
  public void test_no_exceptions_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/no-exceptions.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/no-exceptions.cpp
    RUN("%clang_cc1 -fsyntax-only -verify %s");
  }

  @Test
  public void test_no_implicit_builtin_decls_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/no-implicit-builtin-decls.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/no-implicit-builtin-decls.cpp
    RUN("%clang_cc1 -fsyntax-only -verify %s");
  }

  @Test
  public void test_no_rtti_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/no-rtti.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -fno-rtti ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/no-rtti.cpp
    RUN("%clang_cc1 -fsyntax-only -verify -fno-rtti %s");
  }

  @Test
  public void test_no_warn_composite_pointer_type_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/no-warn-composite-pointer-type.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -Wno-compare-distinct-pointer-types -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/no-warn-composite-pointer-type.cpp
    RUN("%clang_cc1 -fsyntax-only -Wno-compare-distinct-pointer-types -verify %s");
  }

  @Test
  public void test_no_warn_unused_const_variables_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/no-warn-unused-const-variables.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -Wunused-variable -Wno-unused-const-variable -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/no-warn-unused-const-variables.cpp
    RUN("%clang_cc1 -fsyntax-only -Wunused-variable -Wno-unused-const-variable -verify %s");
  }

  @Test
  public void test_no_wchar_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/no-wchar.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i386-pc-win32 -fsyntax-only -fno-wchar -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/no-wchar.cpp
    RUN("%clang_cc1 -triple i386-pc-win32 -fsyntax-only -fno-wchar -verify %s");
  }

  @Test
  public void test_non_empty_class_size_zero_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/non-empty-class-size-zero.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-apple-darwin10 -fsyntax-only ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/non-empty-class-size-zero.cpp
    RUN("%clang_cc1 -triple x86_64-apple-darwin10 -fsyntax-only %s");
  }

  @Test
  public void test_nonnull_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/nonnull.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/nonnull.cpp
    RUN("%clang_cc1 -fsyntax-only -verify %s");
  }

  @Test
  public void test_ns_returns_retained_block_return_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/ns_returns_retained_block_return.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fblocks -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/ns_returns_retained_block_return.cpp
    RUN("%clang_cc1 -fblocks -fsyntax-only -verify %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fblocks -fobjc-arc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/ns_returns_retained_block_return.cpp
    RUN("%clang_cc1 -fblocks -fobjc-arc -fsyntax-only -verify %s");
  }

  @Test
  public void test_null_in_arithmetic_ops_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/null_in_arithmetic_ops.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-unknown-unknown -fsyntax-only -fblocks -Wnull-arithmetic -verify -Wno-string-plus-int -Wno-tautological-pointer-compare ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/null_in_arithmetic_ops.cpp
    RUN("%clang_cc1 -triple x86_64-unknown-unknown -fsyntax-only -fblocks -Wnull-arithmetic -verify -Wno-string-plus-int -Wno-tautological-pointer-compare %s");
  }

  @Test
  public void test_nullability_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/nullability.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c++11 -fsyntax-only -Wno-nullability-declspec ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/nullability.cpp -verify -Wnullable-to-nonnull-conversion
    RUN("%clang_cc1 -std=c++11 -fsyntax-only -Wno-nullability-declspec %s -verify -Wnullable-to-nonnull-conversion");
  }

  @Test
  public void test_nullability_declspec_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/nullability-declspec.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fblocks -Werror=nullability-declspec -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/nullability-declspec.cpp
    RUN("%clang_cc1 -fblocks -Werror=nullability-declspec -verify %s");
  }

  @Test
  public void test_nullptr_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/nullptr.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fcxx-exceptions -fexceptions -fsyntax-only -verify -std=c++11 -ffreestanding -Wno-null-conversion ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/nullptr.cpp
    RUN("%clang_cc1 -fcxx-exceptions -fexceptions -fsyntax-only -verify -std=c++11 -ffreestanding -Wno-null-conversion %s");
  }

  @Test
  public void test_nullptr_98_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/nullptr-98.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c++98 -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/nullptr-98.cpp
    RUN("%clang_cc1 -std=c++98 -fsyntax-only -verify %s");
  }

  @Test
  public void test_nullptr_in_arithmetic_ops_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/nullptr_in_arithmetic_ops.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -Wno-tautological-pointer-compare -fblocks -std=c++11 -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/nullptr_in_arithmetic_ops.cpp
    RUN("%clang_cc1 -fsyntax-only -Wno-tautological-pointer-compare -fblocks -std=c++11 -verify %s");
  }

  @Test
  public void test_offsetof_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/offsetof.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-apple-darwin10.0.0 -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/offsetof.cpp -Winvalid-offsetof -std=c++98
    RUN("%clang_cc1 -triple x86_64-apple-darwin10.0.0 -fsyntax-only -verify %s -Winvalid-offsetof -std=c++98");
  }

  @Test
  public void test_offsetof_0x_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/offsetof-0x.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-apple-darwin10.0.0 -fsyntax-only -std=c++11 -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/offsetof-0x.cpp -Winvalid-offsetof
    RUN("%clang_cc1 -triple x86_64-apple-darwin10.0.0 -fsyntax-only -std=c++11 -verify %s -Winvalid-offsetof");
  }

  @Test
  public void test_old_style_cast_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/old-style-cast.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-apple-darwin -fsyntax-only -verify -Wold-style-cast ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/old-style-cast.cpp
    RUN("%clang_cc1 -triple x86_64-apple-darwin -fsyntax-only -verify -Wold-style-cast %s");
  }

  @Test
  public void test_openmp_default_simd_align_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/openmp_default_simd_align.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c++11 -fsyntax-only -triple x86_64-unknown-unknown -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/openmp_default_simd_align.cpp
    RUN("%clang_cc1 -std=c++11 -fsyntax-only -triple x86_64-unknown-unknown -verify %s");
  }

  @Test
  public void test_operator_arrow_depth_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/operator-arrow-depth.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/operator-arrow-depth.cpp -DMAX=128 -foperator-arrow-depth 128
    RUN("%clang_cc1 -fsyntax-only -verify %s -DMAX=128 -foperator-arrow-depth 128");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/operator-arrow-depth.cpp -DMAX=2 -foperator-arrow-depth 2
    RUN("%clang_cc1 -fsyntax-only -verify %s -DMAX=2 -foperator-arrow-depth 2");
    // ${LLVM_SRC}/build/bin/clang -fsyntax-only -Xclang -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/operator-arrow-depth.cpp -DMAX=10 -foperator-arrow-depth=10
    RUN("%clang -fsyntax-only -Xclang -verify %s -DMAX=10 -foperator-arrow-depth=10");
  }

  @Test
  public void test_operator_arrow_temporary_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/operator-arrow-temporary.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/operator-arrow-temporary.cpp
    RUN("%clang_cc1 -fsyntax-only -verify %s");
  }

  @Test
  public void test_out_of_line_def_mismatch_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/out-of-line-def-mismatch.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -std=c++98 -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/out-of-line-def-mismatch.cpp
    RUN("%clang_cc1 -fsyntax-only -std=c++98 -verify %s");
  }

  @Test
  public void test_overload_0x_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/overload-0x.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -std=c++11 -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/overload-0x.cpp
    RUN("%clang_cc1 -fsyntax-only -std=c++11 -verify %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/overload-0x.cpp
    RUN("%clang_cc1 -fsyntax-only -verify %s");
  }

  @Test
  public void test_overload_call_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/overload-call.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i386-pc-solaris2.11 -pedantic -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/overload-call.cpp
    RUN("%clang_cc1 -triple %itanium_abi_triple -pedantic -verify %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i386-pc-solaris2.11 -pedantic -verify -std=c++98 ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/overload-call.cpp
    RUN("%clang_cc1 -triple %itanium_abi_triple -pedantic -verify -std=c++98 %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i386-pc-solaris2.11 -pedantic -verify -std=c++11 ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/overload-call.cpp
    RUN("%clang_cc1 -triple %itanium_abi_triple -pedantic -verify -std=c++11 %s");
  }

  @Test
  public void test_overload_call_copycon_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/overload-call-copycon.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/overload-call-copycon.cpp -Wnon-pod-varargs
    RUN("%clang_cc1 -fsyntax-only -verify %s -Wnon-pod-varargs");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -std=c++98 ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/overload-call-copycon.cpp -Wnon-pod-varargs
    RUN("%clang_cc1 -fsyntax-only -verify -std=c++98 %s -Wnon-pod-varargs");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -std=c++11 ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/overload-call-copycon.cpp -Wnon-pod-varargs
    RUN("%clang_cc1 -fsyntax-only -verify -std=c++11 %s -Wnon-pod-varargs");
  }

  @Test
  public void test_overload_decl_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/overload-decl.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/overload-decl.cpp
    RUN("%clang_cc1 -fsyntax-only -verify %s");
  }

  @Test
  public void test_overload_member_call_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/overload-member-call.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/overload-member-call.cpp
    RUN("%clang_cc1 -fsyntax-only -verify %s");
  }

  @Test
  public void test_overload_value_dep_arg_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/overload-value-dep-arg.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/overload-value-dep-arg.cpp
    RUN("%clang_cc1 -fsyntax-only -verify %s");
  }

  @Test
  public void test_overloaded_builtin_operators_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/overloaded-builtin-operators.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -fshow-overloads=best -verify -triple x86_64-linux-gnu ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/overloaded-builtin-operators.cpp
    RUN("%clang_cc1 -fsyntax-only -fshow-overloads=best -verify -triple x86_64-linux-gnu %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -fshow-overloads=best -verify -triple x86_64-linux-gnu -std=c++98 ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/overloaded-builtin-operators.cpp
    RUN("%clang_cc1 -fsyntax-only -fshow-overloads=best -verify -triple x86_64-linux-gnu -std=c++98 %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -fshow-overloads=best -verify -triple x86_64-linux-gnu -std=c++11 ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/overloaded-builtin-operators.cpp
    RUN("%clang_cc1 -fsyntax-only -fshow-overloads=best -verify -triple x86_64-linux-gnu -std=c++11 %s");
  }

  @Test
  public void test_overloaded_builtin_operators_0x_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/overloaded-builtin-operators-0x.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -fshow-overloads=best -std=c++11 -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/overloaded-builtin-operators-0x.cpp
    RUN("%clang_cc1 -fsyntax-only -fshow-overloads=best -std=c++11 -verify %s");
  }

  @Test
  public void test_overloaded_name_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/overloaded-name.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/overloaded-name.cpp
    RUN("%clang_cc1 -fsyntax-only -verify %s");
  }

  @Test
  public void test_overloaded_operator_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/overloaded-operator.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -std=c++11 ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/overloaded-operator.cpp
    RUN("%clang_cc1 -fsyntax-only -verify -std=c++11 %s");
  }

  @Test
  public void test_overloaded_operator_decl_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/overloaded-operator-decl.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/overloaded-operator-decl.cpp
    RUN("%clang_cc1 -fsyntax-only -verify %s");
  }

  @Test
  public void test_override_in_system_header_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/override-in-system-header.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c++11 -isystem ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/Inputs ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/override-in-system-header.cpp -verify
    RUN("%clang_cc1 -std=c++11 -isystem %S/Inputs %s -verify");
  }

  @Test
  public void test_parentheses_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/parentheses.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/parentheses.cpp
    RUN("%clang_cc1 -verify %s");
  }

  @Test
  public void test_pascal_strings_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/pascal-strings.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/pascal-strings.cpp -fpascal-strings
    RUN("%clang_cc1 -fsyntax-only -verify %s -fpascal-strings");
  }

  @Test
  public void test_pass_object_size_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/pass-object-size.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/pass-object-size.cpp -std=c++11
    RUN("%clang_cc1 -fsyntax-only -verify %s -std=c++11");
  }

  @Test
  public void test_pr13353_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/pr13353.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/pr13353.cpp
    RUN("%clang_cc1 -fsyntax-only  %s");
  }

  @Test
  public void test_pr13394_crash_on_invalid_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/pr13394-crash-on-invalid.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -std=c++11 ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/pr13394-crash-on-invalid.cpp
    RUN("%clang_cc1 -fsyntax-only -verify -std=c++11 %s");
  }

  @Test
  public void test_pr18284_crash_on_invalid_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/pr18284-crash-on-invalid.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/pr18284-crash-on-invalid.cpp
    RUN("%clang_cc1 -fsyntax-only -verify %s");
  }

  @Test
  public void test_pr25181_crash_on_invalid_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/pr25181-crash-on-invalid.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -std=c++11 ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/pr25181-crash-on-invalid.cpp
    RUN("%clang_cc1 -fsyntax-only -verify -std=c++11 %s");
  }

  @Test
  public void test_pr27047_default_init_expr_name_conflict_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/pr27047-default-init-expr-name-conflict.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -std=c++11 ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/pr27047-default-init-expr-name-conflict.cpp
    RUN("%clang_cc1 -fsyntax-only -std=c++11 %s");
  }

  @Test
  public void test_pr9812_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/pr9812.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/pr9812.cpp
    RUN("%clang_cc1 -fsyntax-only -verify %s");
  }

  @Test
  public void test_pragma_init_seg_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/pragma-init_seg.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -fms-extensions ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/pragma-init_seg.cpp -triple x86_64-pc-win32
    RUN("%clang_cc1 -fsyntax-only -verify -fms-extensions %s -triple x86_64-pc-win32");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -fms-extensions -std=c++98 ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/pragma-init_seg.cpp -triple x86_64-pc-win32
    RUN("%clang_cc1 -fsyntax-only -verify -fms-extensions -std=c++98 %s -triple x86_64-pc-win32");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -fms-extensions -std=c++11 ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/pragma-init_seg.cpp -triple x86_64-pc-win32
    RUN("%clang_cc1 -fsyntax-only -verify -fms-extensions -std=c++11 %s -triple x86_64-pc-win32");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -fms-extensions ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/pragma-init_seg.cpp -triple i386-apple-darwin13.3.0
    RUN("%clang_cc1 -fsyntax-only -verify -fms-extensions %s -triple i386-apple-darwin13.3.0");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -fms-extensions -std=c++98 ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/pragma-init_seg.cpp -triple i386-apple-darwin13.3.0
    RUN("%clang_cc1 -fsyntax-only -verify -fms-extensions -std=c++98 %s -triple i386-apple-darwin13.3.0");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -fms-extensions -std=c++11 ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/pragma-init_seg.cpp -triple i386-apple-darwin13.3.0
    RUN("%clang_cc1 -fsyntax-only -verify -fms-extensions -std=c++11 %s -triple i386-apple-darwin13.3.0");
  }

  @Test
  public void test_pragma_optimize_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/pragma-optimize.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -I ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/Inputs -x c++ -std=c++11 -triple x86_64-unknown-linux -emit-llvm -O2 < ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/pragma-optimize.cpp | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/pragma-optimize.cpp
    RUN(TestState.SemanticErrors, "%clang_cc1 -I %S/Inputs -x c++ -std=c++11 -triple x86_64-unknown-linux -emit-llvm -O2 < %s")./*|*/
      I("FileCheck %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -I ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/Inputs -x c++ -std=c++11 -triple x86_64-unknown-linux -emit-llvm -Os < ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/pragma-optimize.cpp | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/pragma-optimize.cpp
    RUN(TestState.SemanticErrors, "%clang_cc1 -I %S/Inputs -x c++ -std=c++11 -triple x86_64-unknown-linux -emit-llvm -Os < %s")./*|*/
      I("FileCheck %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -I ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/Inputs -x c++ -std=c++11 -triple x86_64-unknown-linux -emit-llvm -Oz < ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/pragma-optimize.cpp | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/pragma-optimize.cpp
    RUN(TestState.SemanticErrors, "%clang_cc1 -I %S/Inputs -x c++ -std=c++11 -triple x86_64-unknown-linux -emit-llvm -Oz < %s")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_pragma_pack_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/pragma-pack.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i686-apple-darwin9 -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/pragma-pack.cpp
    RUN("%clang_cc1 -triple i686-apple-darwin9 -fsyntax-only -verify %s");
  }

  @Test
  public void test_pragma_unused_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/pragma-unused.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -Wunused-parameter -Wunused -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/pragma-unused.cpp
    RUN("%clang_cc1 -fsyntax-only -Wunused-parameter -Wunused -verify %s");
  }

  @Test
  public void test_pragma_visibility_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/pragma-visibility.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/pragma-visibility.cpp
    RUN("%clang_cc1 -fsyntax-only -verify %s");
  }

  @Test
  public void test_pragma_vtordisp_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/pragma-vtordisp.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c++11 -fms-extensions -fms-compatibility -fsyntax-only -triple=i386-pc-win32 -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/pragma-vtordisp.cpp
    RUN("%clang_cc1 -std=c++11 -fms-extensions -fms-compatibility -fsyntax-only -triple=i386-pc-win32 -verify %s");
  }

  @Test
  public void test_pragma_weak_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/pragma-weak.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/pragma-weak.cpp
    RUN("%clang_cc1 %s");
  }

  @Test
  public void test_predefined_expr_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/predefined-expr.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x c++ -std=c++1y -fblocks -fsyntax-only -triple i386-pc-solaris2.11 -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/predefined-expr.cpp
    RUN("%clang_cc1 -x c++ -std=c++1y -fblocks -fsyntax-only -triple %itanium_abi_triple -verify %s");
  }

  @Test
  public void test_prefetch_enum_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/prefetch-enum.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/prefetch-enum.cpp -verify
    RUN("%clang_cc1 -fsyntax-only %s -verify");
  }

  @Test
  public void test_primary_base_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/primary-base.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i386-pc-solaris2.11 -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/primary-base.cpp
    RUN("%clang_cc1 -triple %itanium_abi_triple -fsyntax-only -verify %s");
  }

  @Test
  public void test_printf_block_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/printf-block.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -fblocks -Wformat -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/printf-block.cpp -Wno-error=non-pod-varargs
    RUN("%clang_cc1 -fsyntax-only -fblocks -Wformat -verify %s -Wno-error=non-pod-varargs");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -fblocks -Wformat -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/printf-block.cpp -Wno-error=non-pod-varargs -std=c++98
    RUN("%clang_cc1 -fsyntax-only -fblocks -Wformat -verify %s -Wno-error=non-pod-varargs -std=c++98");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -fblocks -Wformat -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/printf-block.cpp -Wno-error=non-pod-varargs -std=c++11
    RUN("%clang_cc1 -fsyntax-only -fblocks -Wformat -verify %s -Wno-error=non-pod-varargs -std=c++11");
  }

  @Test
  public void test_printf_cstr_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/printf-cstr.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -Wformat -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/printf-cstr.cpp -Wno-error=non-pod-varargs
    RUN(TestState.Failed, "%clang_cc1 -fsyntax-only -Wformat -verify %s -Wno-error=non-pod-varargs");
  }

  @Test
  public void test_pseudo_destructors_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/pseudo-destructors.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -std=c++11 ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/pseudo-destructors.cpp
    RUN("%clang_cc1 -fsyntax-only -verify -std=c++11 %s");
  }

  @Test
  public void test_ptrtomember_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/ptrtomember.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/ptrtomember.cpp -std=c++11
    RUN("%clang_cc1 -fsyntax-only -verify %s -std=c++11");
  }

  @Test
  public void test_ptrtomember_overload_resolution_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/ptrtomember-overload-resolution.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/ptrtomember-overload-resolution.cpp -std=c++11
    RUN("%clang_cc1 -fsyntax-only -verify %s -std=c++11");
  }

  @Test
  public void test_qual_id_test_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/qual-id-test.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/qual-id-test.cpp
    RUN("%clang_cc1 -fsyntax-only -verify %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -std=c++98 ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/qual-id-test.cpp
    RUN("%clang_cc1 -fsyntax-only -verify -std=c++98 %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -std=c++11 ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/qual-id-test.cpp
    RUN("%clang_cc1 -fsyntax-only -verify -std=c++11 %s");
  }

  @Test
  public void test_qualification_conversion_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/qualification-conversion.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -pedantic -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/qualification-conversion.cpp
    RUN("%clang_cc1 -fsyntax-only -pedantic -verify %s");
  }

  @Test
  public void test_qualified_id_lookup_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/qualified-id-lookup.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/qualified-id-lookup.cpp
    RUN("%clang_cc1 -fsyntax-only -verify %s");
  }

  @Test
  public void test_qualified_member_enum_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/qualified-member-enum.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/qualified-member-enum.cpp
    RUN("%clang_cc1 -fsyntax-only -verify %s");
  }

  @Test
  public void test_qualified_names_diag_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/qualified-names-diag.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/qualified-names-diag.cpp
    RUN("%clang_cc1 -fsyntax-only -verify %s");
  }

  @Test
  public void test_redeclared_alias_template_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/redeclared-alias-template.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -std=c++11 ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/redeclared-alias-template.cpp
    RUN("%clang_cc1 -fsyntax-only -verify -std=c++11 %s");
  }

  @Test
  public void test_redeclared_auto_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/redeclared-auto.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/redeclared-auto.cpp -std=c++11
    RUN("%clang_cc1 -fsyntax-only -verify %s -std=c++11");
  }

  @Test
  public void test_redefine_extname_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/redefine_extname.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple=x86_64-unknown-linux -Wpragmas -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/redefine_extname.cpp
    RUN("%clang_cc1 -triple=x86_64-unknown-linux -Wpragmas -verify %s");
  }

  @Test
  public void test_ref_init_ambiguous_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/ref-init-ambiguous.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/ref-init-ambiguous.cpp -std=c++11
    RUN("%clang_cc1 -fsyntax-only -verify %s -std=c++11");
  }

  @Test
  public void test_references_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/references.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/references.cpp
    RUN("%clang_cc1 -fsyntax-only -verify %s");
  }

  @Test
  public void test_reinterpret_cast_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/reinterpret-cast.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -ffreestanding -Wundefined-reinterpret-cast -Wno-unused-volatile-lvalue ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/reinterpret-cast.cpp
    RUN("%clang_cc1 -fsyntax-only -verify -ffreestanding -Wundefined-reinterpret-cast -Wno-unused-volatile-lvalue %s");
  }

  @Test
  public void test_reinterpret_fn_obj_pedantic_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/reinterpret-fn-obj-pedantic.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -std=c++98 -pedantic ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/reinterpret-fn-obj-pedantic.cpp
    RUN("%clang_cc1 -fsyntax-only -verify -std=c++98 -pedantic %s");
  }

  @Test
  public void test_return_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/return.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/return.cpp -std=c++11 -fcxx-exceptions -fexceptions -fsyntax-only -Wignored-qualifiers -verify
    RUN( "%clang_cc1 %s -std=c++11 -fcxx-exceptions -fexceptions -fsyntax-only -Wignored-qualifiers -verify");
  }

  @Test
  public void test_return_noreturn_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/return-noreturn.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/return-noreturn.cpp -fsyntax-only -fcxx-exceptions -verify -Wreturn-type -Wmissing-noreturn -Wno-unreachable-code -Wno-covered-switch-default
    RUN("%clang_cc1 %s -fsyntax-only -fcxx-exceptions -verify -Wreturn-type -Wmissing-noreturn -Wno-unreachable-code -Wno-covered-switch-default");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/return-noreturn.cpp -fsyntax-only -fcxx-exceptions -std=c++11 -verify -Wreturn-type -Wmissing-noreturn -Wno-unreachable-code -Wno-covered-switch-default
    RUN("%clang_cc1 %s -fsyntax-only -fcxx-exceptions -std=c++11 -verify -Wreturn-type -Wmissing-noreturn -Wno-unreachable-code -Wno-covered-switch-default");
  }

  @Test
  public void test_return_stack_addr_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/return-stack-addr.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -std=c++11 ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/return-stack-addr.cpp
    RUN("%clang_cc1 -fsyntax-only -verify -std=c++11 %s");
  }

  @Test
  public void test_return_stack_addr_2_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/return-stack-addr-2.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c++11 -fsyntax-only -verify -std=c++11 ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/return-stack-addr-2.cpp
    RUN("%clang_cc1 -std=c++11 -fsyntax-only -verify -std=c++11 %s");
  }

  @Test
  public void test_runtimediag_ppe_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/runtimediag-ppe.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -Wno-unused-value ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/runtimediag-ppe.cpp
    RUN("%clang_cc1 -fsyntax-only -verify -Wno-unused-value %s");
  }

  @Test
  public void test_rval_references_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/rval-references.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fcxx-exceptions -fexceptions -fsyntax-only -verify -std=c++11 ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/rval-references.cpp
    RUN("%clang_cc1 -fcxx-exceptions -fexceptions -fsyntax-only -verify -std=c++11 %s");
  }

  @Test
  public void test_rval_references_examples_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/rval-references-examples.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c++11 -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/rval-references-examples.cpp
    RUN("%clang_cc1 -std=c++11 -fsyntax-only -verify %s");
  }

  @Test
  public void test_scope_check_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/scope-check.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-windows -fsyntax-only -verify -fblocks -fcxx-exceptions -fms-extensions ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/scope-check.cpp -Wno-unreachable-code
    RUN("%clang_cc1 -triple x86_64-windows -fsyntax-only -verify -fblocks -fcxx-exceptions -fms-extensions %s -Wno-unreachable-code");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-windows -fsyntax-only -verify -fblocks -fcxx-exceptions -fms-extensions -std=gnu++11 ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/scope-check.cpp -Wno-unreachable-code
    RUN("%clang_cc1 -triple x86_64-windows -fsyntax-only -verify -fblocks -fcxx-exceptions -fms-extensions -std=gnu++11 %s -Wno-unreachable-code");
  }

  @Test
  public void test_self_comparison_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/self-comparison.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/self-comparison.cpp
    RUN("%clang_cc1 -fsyntax-only -verify %s");
  }

  @Test
  public void test_shift_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/shift.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -Wall -Wshift-sign-overflow -ffreestanding -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/shift.cpp
    RUN("%clang_cc1 -Wall -Wshift-sign-overflow -ffreestanding -fsyntax-only -verify %s");
  }

  @Test
  public void test_short_enums_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/short-enums.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fshort-enums -fsyntax-only ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/short-enums.cpp
    RUN("%clang_cc1 -fshort-enums -fsyntax-only %s");
  }

  @Test
  public void test_short_wchar_sign_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/short-wchar-sign.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i386-mingw32 -fsyntax-only -pedantic -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/short-wchar-sign.cpp
    RUN("%clang_cc1 -triple i386-mingw32 -fsyntax-only -pedantic -verify %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fshort-wchar -fsyntax-only -pedantic -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/short-wchar-sign.cpp
    RUN("%clang_cc1 -fshort-wchar -fsyntax-only -pedantic -verify %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-apple-darwin10 -fsyntax-only -pedantic -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/short-wchar-sign.cpp
    RUN("%clang_cc1 -triple x86_64-apple-darwin10 -fsyntax-only -pedantic -verify %s");
  }

  @Test
  public void test_sourceranges_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/sourceranges.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i686-mingw32 -ast-dump ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/sourceranges.cpp | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/sourceranges.cpp
    RUN("%clang_cc1 -triple i686-mingw32 -ast-dump %s")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_statements_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/statements.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/statements.cpp -fsyntax-only -pedantic -verify
    RUN("%clang_cc1 %s -fsyntax-only -pedantic -verify");
  }

  @Test
  public void test_static_array_member_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/static-array-member.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/static-array-member.cpp
    RUN("%clang_cc1 -fsyntax-only %s");
  }

  @Test
  public void test_static_assert_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/static-assert.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/static-assert.cpp -std=c++11 -triple=x86_64-linux-gnu
    RUN(TestState.Failed, "%clang_cc1 -fsyntax-only -verify %s -std=c++11 -triple=x86_64-linux-gnu");
  }

  @Test
  public void test_static_cast_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/static-cast.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/static-cast.cpp
    RUN("%clang_cc1 -fsyntax-only -verify %s");
  }

  @Test
  public void test_static_cast_complete_type_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/static-cast-complete-type.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/static-cast-complete-type.cpp
    RUN("%clang_cc1 -fsyntax-only -verify %s");
  }

  @Test
  public void test_static_data_member_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/static-data-member.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -w ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/static-data-member.cpp
    RUN("%clang_cc1 -fsyntax-only -verify -w %s");
  }

  @Test
  public void test_static_initializers_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/static-initializers.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/static-initializers.cpp
    RUN("%clang_cc1 -fsyntax-only -verify %s");
  }

  @Test
  public void test_storage_class_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/storage-class.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/storage-class.cpp
    RUN("%clang_cc1 -fsyntax-only -verify %s");
  }

  @Test
  public void test_string_init_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/string-init.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c++11 -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/string-init.cpp
    RUN("%clang_cc1 -std=c++11 -fsyntax-only -verify %s");
  }

  @Test
  public void test_string_plus_char_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/string-plus-char.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -std=c++11 -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/string-plus-char.cpp
    RUN("%clang_cc1 -fsyntax-only -std=c++11 -verify %s");
  }

  @Test
  public void test_string_plus_int_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/string-plus-int.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -Wno-array-bounds ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/string-plus-int.cpp -fpascal-strings
    RUN("%clang_cc1 -fsyntax-only -verify -Wno-array-bounds %s -fpascal-strings");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fdiagnostics-parseable-fixits -x c++ ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/string-plus-int.cpp 2>&1 -Wno-array-bounds -fpascal-strings | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/string-plus-int.cpp
    RUN("%clang_cc1 -fdiagnostics-parseable-fixits -x c++ %s 2>&1 -Wno-array-bounds -fpascal-strings")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_struct_class_redecl_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/struct-class-redecl.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -Wmismatched-tags -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/struct-class-redecl.cpp
    RUN("%clang_cc1 -fsyntax-only -Wmismatched-tags -verify %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -Wmismatched-tags ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/struct-class-redecl.cpp 2>&1 | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/struct-class-redecl.cpp
    RUN("not %clang_cc1 -fsyntax-only -Wmismatched-tags %s 2>&1")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_switch_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/switch.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -std=c++11 ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/switch.cpp
    RUN("%clang_cc1 -fsyntax-only -verify -std=c++11 %s");
  }

  @Test
  public void test_switch_0x_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/switch-0x.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -std=c++11 ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/switch-0x.cpp
    RUN("%clang_cc1 -fsyntax-only -verify -std=c++11 %s");
  }

  @Test
  public void test_switch_implicit_fallthrough_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/switch-implicit-fallthrough.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -std=c++11 -Wimplicit-fallthrough ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/switch-implicit-fallthrough.cpp
    RUN("%clang_cc1 -fsyntax-only -verify -std=c++11 -Wimplicit-fallthrough %s");
  }

  @Test
  public void test_switch_implicit_fallthrough_blocks_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/switch-implicit-fallthrough-blocks.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -fblocks -std=c++11 -Wimplicit-fallthrough ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/switch-implicit-fallthrough-blocks.cpp
    RUN("%clang_cc1 -fsyntax-only -verify -fblocks -std=c++11 -Wimplicit-fallthrough %s");
  }

  @Test
  public void test_switch_implicit_fallthrough_cxx98_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/switch-implicit-fallthrough-cxx98.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -std=c++98 -Wimplicit-fallthrough ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/switch-implicit-fallthrough-cxx98.cpp
    RUN(TestState.Failed, "%clang_cc1 -fsyntax-only -verify -std=c++98 -Wimplicit-fallthrough %s");
  }

  @Test
  public void test_switch_implicit_fallthrough_macro_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/switch-implicit-fallthrough-macro.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -std=c++11 -Wimplicit-fallthrough -DCLANG_PREFIX -DCOMMAND_LINE_FALLTHROUGH=[[clang::fallthrough]] -DUNCHOSEN=[[fallthrough]] ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/switch-implicit-fallthrough-macro.cpp
    RUN("%clang_cc1 -fsyntax-only -verify -std=c++11 -Wimplicit-fallthrough -DCLANG_PREFIX -DCOMMAND_LINE_FALLTHROUGH=[[clang::fallthrough]] -DUNCHOSEN=[[fallthrough]] %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -std=c++11 -Wimplicit-fallthrough -DCOMMAND_LINE_FALLTHROUGH=[[fallthrough]] ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/switch-implicit-fallthrough-macro.cpp
    RUN("%clang_cc1 -fsyntax-only -verify -std=c++11 -Wimplicit-fallthrough -DCOMMAND_LINE_FALLTHROUGH=[[fallthrough]] %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -std=c++1z -Wimplicit-fallthrough -DCLANG_PREFIX -DCOMMAND_LINE_FALLTHROUGH=[[clang::fallthrough]] ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/switch-implicit-fallthrough-macro.cpp
    RUN("%clang_cc1 -fsyntax-only -verify -std=c++1z -Wimplicit-fallthrough -DCLANG_PREFIX -DCOMMAND_LINE_FALLTHROUGH=[[clang::fallthrough]] %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -std=c++1z -Wimplicit-fallthrough -DCOMMAND_LINE_FALLTHROUGH=[[clang::fallthrough]] ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/switch-implicit-fallthrough-macro.cpp
    RUN("%clang_cc1 -fsyntax-only -verify -std=c++1z -Wimplicit-fallthrough -DCOMMAND_LINE_FALLTHROUGH=[[clang::fallthrough]] %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -std=c++1z -Wimplicit-fallthrough -DCOMMAND_LINE_FALLTHROUGH=[[fallthrough]] -DUNCHOSEN=[[clang::fallthrough]] ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/switch-implicit-fallthrough-macro.cpp
    RUN("%clang_cc1 -fsyntax-only -verify -std=c++1z -Wimplicit-fallthrough -DCOMMAND_LINE_FALLTHROUGH=[[fallthrough]] -DUNCHOSEN=[[clang::fallthrough]] %s");
  }

  @Test
  public void test_switch_implicit_fallthrough_off_by_default_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/switch-implicit-fallthrough-off-by-default.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -std=c++11 -DUNREACHABLE=1 ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/switch-implicit-fallthrough-off-by-default.cpp
    RUN("%clang_cc1 -fsyntax-only -verify -std=c++11 -DUNREACHABLE=1 %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -std=c++11 -DUNREACHABLE=0 -Wimplicit-fallthrough ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/switch-implicit-fallthrough-off-by-default.cpp
    RUN("%clang_cc1 -fsyntax-only -verify -std=c++11 -DUNREACHABLE=0 -Wimplicit-fallthrough %s");
  }

  @Test
  public void test_switch_implicit_fallthrough_per_method_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/switch-implicit-fallthrough-per-method.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -std=c++11 -Wimplicit-fallthrough-per-function ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/switch-implicit-fallthrough-per-method.cpp
    RUN("%clang_cc1 -fsyntax-only -verify -std=c++11 -Wimplicit-fallthrough-per-function %s");
  }

  @Test
  public void test_tag_ambig_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/tag-ambig.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/tag-ambig.cpp
    RUN("%clang_cc1 -fsyntax-only -verify %s");
  }

  @Test
  public void test_template_implicit_vars_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/template-implicit-vars.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/template-implicit-vars.cpp -std=c++11 -ast-dump | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/template-implicit-vars.cpp
    RUN("%clang_cc1 -fsyntax-only %s -std=c++11 -ast-dump")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_templated_friend_decl_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/templated-friend-decl.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/templated-friend-decl.cpp
    RUN("%clang_cc1 %s");
  }

  @Test
  public void test_this_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/this.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/this.cpp
    RUN("%clang_cc1 -fsyntax-only -verify %s");
  }

  @Test
  public void test_thread_safety_reference_handling_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/thread-safety-reference-handling.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -Wthread-safety-analysis -std=c++11 ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/thread-safety-reference-handling.cpp
    RUN("%clang_cc1 -fsyntax-only -verify -Wthread-safety-analysis -std=c++11 %s");
  }

  @Test
  public void test_trailing_return_0x_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/trailing-return-0x.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -std=c++11 ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/trailing-return-0x.cpp
    RUN("%clang_cc1 -fsyntax-only -verify -std=c++11 %s");
  }

  @Test
  public void test_trivial_constructor_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/trivial-constructor.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/trivial-constructor.cpp -std=c++11
    RUN("%clang_cc1 -fsyntax-only -verify %s -std=c++11");
  }

  @Test
  public void test_trivial_destructor_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/trivial-destructor.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/trivial-destructor.cpp -std=c++11
    RUN("%clang_cc1 -fsyntax-only -verify %s -std=c++11");
  }

  @Test
  public void test_type_convert_construct_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/type-convert-construct.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/type-convert-construct.cpp
    RUN("%clang_cc1 -fsyntax-only -verify %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -std=gnu++98 ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/type-convert-construct.cpp
    RUN("%clang_cc1 -fsyntax-only -verify -std=gnu++98 %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -std=gnu++11 ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/type-convert-construct.cpp
    RUN("%clang_cc1 -fsyntax-only -verify -std=gnu++11 %s");
  }

  @Test
  public void test_type_definition_in_specifier_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/type-definition-in-specifier.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/type-definition-in-specifier.cpp
    RUN("%clang_cc1 -fsyntax-only -verify %s");
  }

  @Test
  public void test_type_dependent_exprs_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/type-dependent-exprs.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/type-dependent-exprs.cpp
    RUN("%clang_cc1 -fsyntax-only -verify %s");
  }

  @Test
  public void test_type_formatting_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/type-formatting.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/type-formatting.cpp
    RUN("%clang_cc1 -fsyntax-only -verify %s");
  }

  @Test
  public void test_type_traits_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/type-traits.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-apple-darwin10 -fsyntax-only -verify -std=gnu++11 -fms-extensions -Wno-microsoft ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/type-traits.cpp
    RUN("%clang_cc1 -triple x86_64-apple-darwin10 -fsyntax-only -verify -std=gnu++11 -fms-extensions -Wno-microsoft %s");
  }

  @Test
  public void test_type_traits_incomplete_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/type-traits-incomplete.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/type-traits-incomplete.cpp
    RUN("%clang_cc1 -fsyntax-only -verify %s");
  }

  @Test
  public void test_type_pack_element_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/type_pack_element.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -std=c++11 ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/type_pack_element.cpp
    RUN("%clang_cc1 -fsyntax-only -verify -std=c++11 %s");
  }

  @Test
  public void test_typedef_redecl_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/typedef-redecl.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/typedef-redecl.cpp
    RUN("%clang_cc1 -fsyntax-only -verify %s");
  }

  @Test
  public void test_typeid_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/typeid.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/typeid.cpp
    RUN("%clang_cc1 -fsyntax-only -verify %s");
  }

  @Test
  public void test_typeid_ref_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/typeid-ref.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i386-pc-solaris2.11 -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/typeid-ref.cpp | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/typeid-ref.cpp
    RUN(TestState.Failed, "%clang_cc1 -triple %itanium_abi_triple -emit-llvm -o - %s")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_types_compatible_p_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/types_compatible_p.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -x c++ ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/types_compatible_p.cpp
    RUN("%clang_cc1 -fsyntax-only -verify -x c++ %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -x c ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/types_compatible_p.cpp
    RUN("%clang_cc1 -fsyntax-only -x c %s");
  }

  @Test
  public void test_typo_correction_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/typo-correction.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fspell-checking-limit 0 -verify -Wno-c++11-extensions ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/typo-correction.cpp
    RUN(TestState.Failed, "%clang_cc1 -fspell-checking-limit 0 -verify -Wno-c++11-extensions %s");
  }

  @Test
  public void test_typo_correction_blocks_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/typo-correction-blocks.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i386-apple-macosx -fblocks -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/typo-correction-blocks.c
    RUN("%clang_cc1 -triple i386-apple-macosx -fblocks -fsyntax-only -verify %s");
  }

  @Test
  public void test_typo_correction_crash_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/typo-correction-crash.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -std=c++14 -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/typo-correction-crash.cpp
    RUN( "%clang_cc1 -fsyntax-only -std=c++14 -verify %s");
  }

  @Test
  public void test_typo_correction_cxx11_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/typo-correction-cxx11.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c++11 -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/typo-correction-cxx11.cpp
    RUN( "%clang_cc1 -std=c++11 -fsyntax-only -verify %s");
  }

  @Test
  public void test_typo_correction_delayed_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/typo-correction-delayed.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -Wno-c++11-extensions ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/typo-correction-delayed.cpp
    RUN( "%clang_cc1 -fsyntax-only -verify -Wno-c++11-extensions %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -std=c++98 -Wno-c++11-extensions ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/typo-correction-delayed.cpp
    RUN( "%clang_cc1 -fsyntax-only -verify -std=c++98 -Wno-c++11-extensions %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -std=c++11 ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/typo-correction-delayed.cpp
    RUN( "%clang_cc1 -fsyntax-only -verify -std=c++11 %s");
  }

  @Test
  public void test_unaddressable_functions_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/unaddressable-functions.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/unaddressable-functions.cpp -std=c++14
    RUN("%clang_cc1 -fsyntax-only -verify %s -std=c++14");
  }

  @Test
  public void test_unary_real_imag_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/unary-real-imag.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/unary-real-imag.cpp
    RUN("%clang_cc1 -fsyntax-only -verify %s");
  }

  @Test
  public void test_undefined_inline_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/undefined-inline.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -triple i686-pc-win32 -verify -std=c++11 ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/undefined-inline.cpp
    RUN("%clang_cc1 -fsyntax-only -triple i686-pc-win32 -verify -std=c++11 %s");
  }

  @Test
  public void test_undefined_internal_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/undefined-internal.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -Wbind-to-temporary-copy ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/undefined-internal.cpp
    RUN(TestState.Failed, "%clang_cc1 -fsyntax-only -verify -Wbind-to-temporary-copy %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -Wbind-to-temporary-copy -std=c++98 ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/undefined-internal.cpp
    RUN(TestState.Failed, "%clang_cc1 -fsyntax-only -verify -Wbind-to-temporary-copy -std=c++98 %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -Wbind-to-temporary-copy -std=c++11 ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/undefined-internal.cpp
    RUN(TestState.Failed, "%clang_cc1 -fsyntax-only -verify -Wbind-to-temporary-copy -std=c++11 %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm-only ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/undefined-internal.cpp
    RUN(TestState.SemanticErrors, "%clang_cc1 -emit-llvm-only %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm-only -std=c++98 ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/undefined-internal.cpp
    RUN(TestState.SemanticErrors, "%clang_cc1 -emit-llvm-only -std=c++98 %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm-only -std=c++11 ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/undefined-internal.cpp
    RUN(TestState.SemanticErrors, "%clang_cc1 -emit-llvm-only -std=c++11 %s");
  }

  @Test
  public void test_underlying_type_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/underlying_type.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i386-pc-solaris2.11 -ffreestanding -fsyntax-only -verify -std=c++11 ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/underlying_type.cpp
    RUN("%clang_cc1 -triple %itanium_abi_triple -ffreestanding -fsyntax-only -verify -std=c++11 %s");
  }

  @Test
  public void test_uninit_variables_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/uninit-variables.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -Wuninitialized -fsyntax-only -fcxx-exceptions ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/uninit-variables.cpp -verify -std=c++1y
    RUN(TestState.Failed, "%clang_cc1 -fsyntax-only -Wuninitialized -fsyntax-only -fcxx-exceptions %s -verify -std=c++1y");
  }

  @Test
  public void test_uninit_variables_conditional_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/uninit-variables-conditional.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -Wconditional-uninitialized -fsyntax-only ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/uninit-variables-conditional.cpp -verify
    RUN(TestState.Failed, "%clang_cc1 -fsyntax-only -Wconditional-uninitialized -fsyntax-only %s -verify");
  }

  @Test
  public void test_uninitialized_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/uninitialized.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -Wall -Wuninitialized -Wno-unused-value -std=c++11 -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/uninitialized.cpp
    RUN(TestState.Failed, "%clang_cc1 -fsyntax-only -Wall -Wuninitialized -Wno-unused-value -std=c++11 -verify %s");
  }

  @Test
  public void test_unknown_anytype_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/unknown-anytype.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -funknown-anytype -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/unknown-anytype.cpp
    RUN("%clang_cc1 -funknown-anytype -fsyntax-only -verify %s");
  }

  @Test
  public void test_unknown_anytype_blocks_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/unknown-anytype-blocks.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -funknown-anytype -fblocks -fsyntax-only -verify -std=c++11 ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/unknown-anytype-blocks.cpp
    RUN("%clang_cc1 -funknown-anytype -fblocks -fsyntax-only -verify -std=c++11 %s");
  }

  @Test
  public void test_unknown_type_name_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/unknown-type-name.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/unknown-type-name.cpp
    RUN("%clang_cc1 -fsyntax-only -verify %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -std=c++98 ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/unknown-type-name.cpp
    RUN("%clang_cc1 -fsyntax-only -verify -std=c++98 %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -std=c++11 ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/unknown-type-name.cpp
    RUN("%clang_cc1 -fsyntax-only -verify -std=c++11 %s");
  }

  @Test
  public void test_unreachable_catch_clauses_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/unreachable-catch-clauses.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fcxx-exceptions -fexceptions -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/unreachable-catch-clauses.cpp
    RUN("%clang_cc1 -fcxx-exceptions -fexceptions -fsyntax-only -verify %s");
  }

  @Test
  public void test_unreachable_code_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/unreachable-code.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fcxx-exceptions -fexceptions -fsyntax-only -Wunreachable-code-aggressive -fblocks -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/unreachable-code.cpp
    RUN("%clang_cc1 -fcxx-exceptions -fexceptions -fsyntax-only -Wunreachable-code-aggressive -fblocks -verify %s");
  }

  @Test
  public void test_unused_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/unused.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/unused.cpp
    RUN("%clang_cc1 -fsyntax-only -verify %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -std=c++98 ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/unused.cpp
    RUN("%clang_cc1 -fsyntax-only -verify -std=c++98 %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -std=c++11 ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/unused.cpp
    RUN("%clang_cc1 -fsyntax-only -verify -std=c++11 %s");
  }

  @Test
  public void test_unused_functions_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/unused-functions.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c++11 -fsyntax-only -Wunused -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/unused-functions.cpp
    RUN("%clang_cc1 -std=c++11 -fsyntax-only -Wunused -verify %s");
  }

  @Test
  public void test_unused_with_error_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/unused-with-error.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -Wunused -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/unused-with-error.cpp
    RUN("%clang_cc1 -fsyntax-only -Wunused -verify %s");
  }

  @Test
  public void test_user_defined_conversions_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/user-defined-conversions.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/user-defined-conversions.cpp
    RUN("%clang_cc1 -fsyntax-only -verify %s");
  }

  @Test
  public void test_using_decl_1_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/using-decl-1.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -std=c++98 ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/using-decl-1.cpp
    RUN("%clang_cc1 -fsyntax-only -verify -std=c++98 %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -std=c++11 ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/using-decl-1.cpp
    RUN("%clang_cc1 -fsyntax-only -verify -std=c++11 %s");
  }

  @Test
  public void test_using_decl_pr4441_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/using-decl-pr4441.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/using-decl-pr4441.cpp
    RUN("%clang_cc1 -fsyntax-only -verify %s");
  }

  @Test
  public void test_using_decl_pr4450_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/using-decl-pr4450.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/using-decl-pr4450.cpp
    RUN("%clang_cc1 -fsyntax-only -verify %s");
  }

  @Test
  public void test_using_decl_templates_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/using-decl-templates.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -std=c++11 -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/using-decl-templates.cpp
    RUN("%clang_cc1 -fsyntax-only -std=c++11 -verify %s");
  }

  @Test
  public void test_using_directive_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/using-directive.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/using-directive.cpp
    RUN("%clang_cc1 -fsyntax-only -verify %s");
  }

  @Test
  public void test_value_dependent_exprs_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/value-dependent-exprs.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/value-dependent-exprs.cpp
    RUN("%clang_cc1 -verify %s");
  }

  @Test
  public void test_value_initialization_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/value-initialization.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/value-initialization.cpp -std=c++11
    RUN("%clang_cc1 -fsyntax-only -verify %s -std=c++11");
  }

  @Test
  public void test_vararg_class_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/vararg-class.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -verify -Wclass-varargs -std=c++98 ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/vararg-class.cpp
    RUN(TestState.Failed, "%clang_cc1 -verify -Wclass-varargs -std=c++98 %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -verify -Wclass-varargs -std=c++11 ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/vararg-class.cpp
    RUN(TestState.Failed, "%clang_cc1 -verify -Wclass-varargs -std=c++11 %s");
  }

  @Test
  public void test_vararg_default_arg_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/vararg-default-arg.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/vararg-default-arg.cpp -verify -fsyntax-only
    RUN("%clang_cc1 %s -verify -fsyntax-only");
  }

  @Test
  public void test_vararg_non_pod_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/vararg-non-pod.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -fblocks ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/vararg-non-pod.cpp -Wno-error=non-pod-varargs
    RUN(TestState.Failed, "%clang_cc1 -fsyntax-only -verify -fblocks %s -Wno-error=non-pod-varargs");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -fblocks -std=c++98 ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/vararg-non-pod.cpp -Wno-error=non-pod-varargs
    RUN(TestState.Failed, "%clang_cc1 -fsyntax-only -verify -fblocks -std=c++98 %s -Wno-error=non-pod-varargs");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -fblocks -std=c++11 ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/vararg-non-pod.cpp -Wno-error=non-pod-varargs
    RUN(TestState.Failed, "%clang_cc1 -fsyntax-only -verify -fblocks -std=c++11 %s -Wno-error=non-pod-varargs");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -fblocks ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/vararg-non-pod.cpp -Wno-error=non-pod-varargs -fms-compatibility
    RUN(TestState.Failed, "%clang_cc1 -fsyntax-only -verify -fblocks %s -Wno-error=non-pod-varargs -fms-compatibility");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -fblocks -std=c++98 ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/vararg-non-pod.cpp -Wno-error=non-pod-varargs -fms-compatibility
    RUN(TestState.Failed, "%clang_cc1 -fsyntax-only -verify -fblocks -std=c++98 %s -Wno-error=non-pod-varargs -fms-compatibility");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -fblocks -std=c++11 ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/vararg-non-pod.cpp -Wno-error=non-pod-varargs -fms-compatibility
    RUN(TestState.Failed, "%clang_cc1 -fsyntax-only -verify -fblocks -std=c++11 %s -Wno-error=non-pod-varargs -fms-compatibility");
  }

  @Test
  public void test_varargs_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/varargs.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -std=c++03 -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/varargs.cpp
    RUN("%clang_cc1 -fsyntax-only -std=c++03 -verify %s");
  }

  @Test
  public void test_vartemplate_lambda_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/vartemplate-lambda.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c++14 -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/vartemplate-lambda.cpp
    RUN("%clang_cc1 -std=c++14 -fsyntax-only -verify %s");
  }

  @Test
  public void test_vector_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/vector.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-apple-darwin10 -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/vector.cpp
    RUN("%clang_cc1 -triple x86_64-apple-darwin10 -fsyntax-only -verify %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-apple-darwin10 -fsyntax-only -verify -std=c++98 ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/vector.cpp
    RUN("%clang_cc1 -triple x86_64-apple-darwin10 -fsyntax-only -verify -std=c++98 %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-apple-darwin10 -fsyntax-only -verify -std=c++11 ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/vector.cpp
    RUN("%clang_cc1 -triple x86_64-apple-darwin10 -fsyntax-only -verify -std=c++11 %s");
  }

  @Test
  public void test_vector_casts_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/vector-casts.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c++11 -triple x86_64-unknown-unknown -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/vector-casts.cpp
    RUN("%clang_cc1 -std=c++11 -triple x86_64-unknown-unknown -fsyntax-only -verify %s");
  }

  @Test
  public void test_vector_no_lax_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/vector-no-lax.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-apple-darwin10 -fsyntax-only -fno-lax-vector-conversions -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/vector-no-lax.cpp
    RUN("%clang_cc1 -triple x86_64-apple-darwin10 -fsyntax-only -fno-lax-vector-conversions -verify %s");
  }

  @Test
  public void test_virtual_base_used_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/virtual-base-used.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -triple i386-pc-solaris2.11 -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/virtual-base-used.cpp
    RUN("%clang_cc1 -fsyntax-only -triple %itanium_abi_triple -verify %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -triple i386-pc-win32 -DMSABI -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/virtual-base-used.cpp
    RUN("%clang_cc1 -fsyntax-only -triple %ms_abi_triple -DMSABI -verify %s");
  }

  @Test
  public void test_virtual_function_in_union_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/virtual-function-in-union.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/virtual-function-in-union.cpp
    RUN("%clang_cc1 -fsyntax-only -verify %s");
  }

  @Test
  public void test_virtual_member_functions_key_function_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/virtual-member-functions-key-function.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/virtual-member-functions-key-function.cpp
    RUN("%clang_cc1 -fsyntax-only -verify %s");
  }

  @Test
  public void test_virtual_override_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/virtual-override.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -triple i386-pc-solaris2.11 -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/virtual-override.cpp -std=c++11
    RUN("%clang_cc1 -fsyntax-only -triple %itanium_abi_triple -verify %s -std=c++11");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -triple i386-pc-win32 -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/virtual-override.cpp -std=c++11
    RUN("%clang_cc1 -fsyntax-only -triple %ms_abi_triple -verify %s -std=c++11");
  }

  @Test
  public void test_virtual_override_x64_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/virtual-override-x64.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple=x86_64-pc-unknown -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/virtual-override-x64.cpp
    RUN("%clang_cc1 -triple=x86_64-pc-unknown -fsyntax-only -verify %s");
  }

  @Test
  public void test_virtual_override_x86_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/virtual-override-x86.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple=i686-pc-win32 -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/virtual-override-x86.cpp -std=c++11
    RUN("%clang_cc1 -triple=i686-pc-win32 -fsyntax-only -verify %s -std=c++11");
  }

  @Test
  public void test_virtuals_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/virtuals.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -fcxx-exceptions -verify -std=c++11 ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/virtuals.cpp
    RUN("%clang_cc1 -fsyntax-only -fcxx-exceptions -verify -std=c++11 %s");
  }

  @Test
  public void test_visibility_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/visibility.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/visibility.cpp
    RUN("%clang_cc1 -fsyntax-only %s");
  }

  @Test
  public void test_vla_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/vla.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/vla.cpp
    RUN("%clang_cc1 -verify %s");
  }

  @Test
  public void test_vla_consruct_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/vla-consruct.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-unknown-linux-gnu -fcxx-exceptions -fexceptions -O0 -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/vla-consruct.cpp
    RUN("%clang_cc1 -triple x86_64-unknown-linux-gnu -fcxx-exceptions -fexceptions -O0 -verify %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-unknown-linux-gnu -fcxx-exceptions -fexceptions -pedantic-errors -DPE -O0 -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/vla-consruct.cpp
    RUN("%clang_cc1 -triple x86_64-unknown-linux-gnu -fcxx-exceptions -fexceptions -pedantic-errors -DPE -O0 -verify %s");
  }

  @Test
  public void test_vtable_instantiation_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/vtable-instantiation.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/vtable-instantiation.cpp
    RUN("%clang_cc1 -fsyntax-only -verify %s");
  }

  @Test
  public void test_vtordisp_mode_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/vtordisp-mode.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i686-pc-win32 -std=c++11 -vtordisp-mode=0 -DVTORDISP_MODE=0 ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/vtordisp-mode.cpp -verify
    RUN("%clang_cc1 -triple i686-pc-win32 -std=c++11 -vtordisp-mode=0 -DVTORDISP_MODE=0 %s -verify");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i686-pc-win32 -std=c++11 -vtordisp-mode=1 -DVTORDISP_MODE=1 ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/vtordisp-mode.cpp -verify
    RUN("%clang_cc1 -triple i686-pc-win32 -std=c++11 -vtordisp-mode=1 -DVTORDISP_MODE=1 %s -verify");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i686-pc-win32 -std=c++11 -vtordisp-mode=2 -DVTORDISP_MODE=2 ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/vtordisp-mode.cpp -verify
    RUN("%clang_cc1 -triple i686-pc-win32 -std=c++11 -vtordisp-mode=2 -DVTORDISP_MODE=2 %s -verify");
  }

  @Test
  public void test_warn_absolute_value_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/warn-absolute-value.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i686-pc-linux-gnu -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/warn-absolute-value.cpp -Wabsolute-value -std=c++11
    RUN("%clang_cc1 -triple i686-pc-linux-gnu -fsyntax-only -verify %s -Wabsolute-value -std=c++11");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i686-pc-linux-gnu -fsyntax-only ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/warn-absolute-value.cpp -Wabsolute-value -fdiagnostics-parseable-fixits -std=c++11 2>&1 | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/warn-absolute-value.cpp
    RUN("%clang_cc1 -triple i686-pc-linux-gnu -fsyntax-only %s -Wabsolute-value -fdiagnostics-parseable-fixits -std=c++11 2>&1")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_warn_absolute_value_header_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/warn-absolute-value-header.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i686-pc-linux-gnu -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/warn-absolute-value-header.cpp -Wabsolute-value
    RUN("%clang_cc1 -triple i686-pc-linux-gnu -fsyntax-only -verify %s -Wabsolute-value");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i686-pc-linux-gnu -fsyntax-only ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/warn-absolute-value-header.cpp -Wabsolute-value -fdiagnostics-parseable-fixits 2>&1 | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/warn-absolute-value-header.cpp
    RUN("%clang_cc1 -triple i686-pc-linux-gnu -fsyntax-only %s -Wabsolute-value -fdiagnostics-parseable-fixits 2>&1")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_warn_address_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/warn-address.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -Wno-bool-conversion -Wno-string-compare -Wno-tautological-compare -Waddress ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/warn-address.cpp
    RUN("%clang_cc1 -fsyntax-only -verify -Wno-bool-conversion -Wno-string-compare -Wno-tautological-compare -Waddress %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/warn-address.cpp
    RUN("%clang_cc1 -fsyntax-only -verify %s");
  }

  @Test
  public void test_warn_assignment_condition_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/warn-assignment-condition.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -Wparentheses -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/warn-assignment-condition.cpp
    RUN("%clang_cc1 -fsyntax-only -Wparentheses -verify %s");
  }

  @Test
  public void test_warn_bad_memaccess_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/warn-bad-memaccess.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -Wdynamic-class-memaccess -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/warn-bad-memaccess.cpp
    RUN("%clang_cc1 -fsyntax-only -Wdynamic-class-memaccess -verify %s");
  }

  @Test
  public void test_warn_bool_conversion_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/warn-bool-conversion.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/warn-bool-conversion.cpp
    RUN("%clang_cc1 -fsyntax-only -verify %s");
  }

  @Test
  public void test_warn_cxx11_extensions_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/warn-c++11-extensions.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -std=c++98 -Wc++11-extensions -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/warn-c++11-extensions.cpp
    RUN("%clang_cc1 -fsyntax-only -std=c++98 -Wc++11-extensions -verify %s");
  }

  @Test
  public void test_warn_cast_align_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/warn-cast-align.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-apple-darwin10 -fsyntax-only -Wcast-align -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/warn-cast-align.cpp
    RUN("%clang_cc1 -triple x86_64-apple-darwin10 -fsyntax-only -Wcast-align -verify %s");
  }

  @Test
  public void test_warn_char_subscripts_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/warn-char-subscripts.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -Wchar-subscripts -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/warn-char-subscripts.cpp
    RUN("%clang_cc1 -Wchar-subscripts -fsyntax-only -verify %s");
  }

  @Test
  public void test_warn_comma_operator_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/warn-comma-operator.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -Wcomma -std=c++11 -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/warn-comma-operator.cpp
    RUN("%clang_cc1 -fsyntax-only -Wcomma -std=c++11 -verify %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -Wcomma -std=c++11 -fdiagnostics-parseable-fixits ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/warn-comma-operator.cpp 2>&1 | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/warn-comma-operator.cpp
    RUN("%clang_cc1 -fsyntax-only -Wcomma -std=c++11 -fdiagnostics-parseable-fixits %s 2>&1")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_warn_consumed_analysis_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/warn-consumed-analysis.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -Wconsumed -fcxx-exceptions -std=c++11 ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/warn-consumed-analysis.cpp
    RUN(TestState.Failed, "%clang_cc1 -fsyntax-only -verify -Wconsumed -fcxx-exceptions -std=c++11 %s");
  }

  @Test
  public void test_warn_consumed_parsing_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/warn-consumed-parsing.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -Wconsumed -std=c++11 ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/warn-consumed-parsing.cpp
    RUN("%clang_cc1 -fsyntax-only -verify -Wconsumed -std=c++11 %s");
  }

  @Test
  public void test_warn_dangling_field_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/warn-dangling-field.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -Wdangling-field -verify -std=c++11 ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/warn-dangling-field.cpp
    RUN("%clang_cc1 -fsyntax-only -Wdangling-field -verify -std=c++11 %s");
  }

  @Test
  public void test_warn_deprecated_header_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/warn-deprecated-header.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -fdeprecated-macro -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/warn-deprecated-header.cpp
    RUN("%clang_cc1 -fsyntax-only -fdeprecated-macro -verify %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -Werror ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/warn-deprecated-header.cpp
    RUN("%clang_cc1 -fsyntax-only -Werror %s");
  }

  @Test
  public void test_warn_div_or_rem_by_zero_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/warn-div-or-rem-by-zero.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/warn-div-or-rem-by-zero.cpp
    RUN("%clang_cc1 -verify %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c++11 -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/warn-div-or-rem-by-zero.cpp
    RUN("%clang_cc1 -std=c++11 -verify %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c++1y -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/warn-div-or-rem-by-zero.cpp
    RUN("%clang_cc1 -std=c++1y -verify %s");
  }

  @Test
  public void test_warn_empty_body_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/warn-empty-body.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c++11 -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/warn-empty-body.cpp
    RUN("%clang_cc1 -std=c++11 -fsyntax-only -verify %s");
  }

  @Test
  public void test_warn_enum_compare_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/warn-enum-compare.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/warn-enum-compare.cpp -fsyntax-only -verify
    RUN("%clang_cc1 %s -fsyntax-only -verify");
  }

  @Test
  public void test_warn_everthing_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/warn-everthing.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -Weverything -fsyntax-only ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/warn-everthing.cpp -verify
    RUN("%clang_cc1 -Weverything -fsyntax-only %s -verify");
  }

  @Test
  public void test_warn_exit_time_destructors_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/warn-exit-time-destructors.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c++11 -fsyntax-only -Wexit-time-destructors ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/warn-exit-time-destructors.cpp -verify
    RUN("%clang_cc1 -std=c++11 -fsyntax-only -Wexit-time-destructors %s -verify");
  }

  @Test
  public void test_warn_float_conversion_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/warn-float-conversion.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -verify -fsyntax-only -triple x86_64-pc-linux-gnu ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/warn-float-conversion.cpp -Wno-literal-conversion -Wfloat-conversion -DFLOAT_CONVERSION -DZERO -DBOOL -DCONSTANT_BOOL -DOVERFLOW
    RUN("%clang_cc1 -verify -fsyntax-only -triple x86_64-pc-linux-gnu %s -Wno-literal-conversion -Wfloat-conversion -DFLOAT_CONVERSION -DZERO -DBOOL -DCONSTANT_BOOL -DOVERFLOW");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -verify -fsyntax-only -triple x86_64-pc-linux-gnu ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/warn-float-conversion.cpp -Wno-conversion -Wfloat-overflow-conversion -DOVERFLOW
    RUN("%clang_cc1 -verify -fsyntax-only -triple x86_64-pc-linux-gnu %s -Wno-conversion -Wfloat-overflow-conversion -DOVERFLOW");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -verify -fsyntax-only -triple x86_64-pc-linux-gnu ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/warn-float-conversion.cpp -Wno-conversion -Wfloat-zero-conversion -DZERO
    RUN("%clang_cc1 -verify -fsyntax-only -triple x86_64-pc-linux-gnu %s -Wno-conversion -Wfloat-zero-conversion -DZERO");
  }

  @Test
  public void test_warn_func_not_needed_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/warn-func-not-needed.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -Wall ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/warn-func-not-needed.cpp
    RUN("%clang_cc1 -fsyntax-only -verify -Wall %s");
  }

  @Test
  public void test_warn_global_constructors_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/warn-global-constructors.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c++11 -fsyntax-only -Wglobal-constructors ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/warn-global-constructors.cpp -verify
    RUN("%clang_cc1 -std=c++11 -fsyntax-only -Wglobal-constructors %s -verify");
  }

  @Test
  public void test_warn_implicit_conversion_floating_point_to_bool_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/warn-implicit-conversion-floating-point-to-bool.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -verify -fsyntax-only ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/warn-implicit-conversion-floating-point-to-bool.cpp
    RUN("%clang_cc1 -verify -fsyntax-only %s");
  }

  @Test
  public void test_warn_infinite_recursion_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/warn-infinite-recursion.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/warn-infinite-recursion.cpp -fsyntax-only -verify -Winfinite-recursion
    RUN("%clang_cc1 %s -fsyntax-only -verify -Winfinite-recursion");
  }

  @Test
  public void test_warn_large_by_value_copy_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/warn-large-by-value-copy.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -verify -fsyntax-only -Wlarge-by-value-copy=100 ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/warn-large-by-value-copy.cpp
    RUN("%clang_cc1 -verify -fsyntax-only -Wlarge-by-value-copy=100 %s");
  }

  @Test
  public void test_warn_literal_conversion_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/warn-literal-conversion.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -Wliteral-conversion -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/warn-literal-conversion.cpp
    RUN("%clang_cc1 -fsyntax-only -Wliteral-conversion -verify %s");
  }

  @Test
  public void test_warn_logical_not_compare_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/warn-logical-not-compare.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -Wlogical-not-parentheses -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/warn-logical-not-compare.cpp
    RUN("%clang_cc1 -fsyntax-only -Wlogical-not-parentheses -verify %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -Wlogical-not-parentheses -fdiagnostics-parseable-fixits ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/warn-logical-not-compare.cpp 2>&1 | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/warn-logical-not-compare.cpp
    RUN("%clang_cc1 -fsyntax-only -Wlogical-not-parentheses -fdiagnostics-parseable-fixits %s 2>&1")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_warn_loop_analysis_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/warn-loop-analysis.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -Wloop-analysis -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/warn-loop-analysis.cpp
    RUN("%clang_cc1 -fsyntax-only -Wloop-analysis -verify %s");
  }

  @Test
  public void test_warn_member_not_needed_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/warn-member-not-needed.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -Wunneeded-member-function ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/warn-member-not-needed.cpp
    RUN("%clang_cc1 -fsyntax-only -verify -Wunneeded-member-function %s");
  }

  @Test
  public void test_warn_memset_bad_sizeof_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/warn-memset-bad-sizeof.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -Wno-sizeof-array-argument ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/warn-memset-bad-sizeof.cpp
    RUN("%clang_cc1 -fsyntax-only -verify -Wno-sizeof-array-argument %s");
  }

  @Test
  public void test_warn_memsize_comparison_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/warn-memsize-comparison.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/warn-memsize-comparison.cpp
    RUN("%clang_cc1 -fsyntax-only -verify %s");
  }

  @Test
  public void test_warn_missing_noreturn_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/warn-missing-noreturn.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/warn-missing-noreturn.cpp -Wmissing-noreturn -Wreturn-type
    RUN("%clang_cc1 -fsyntax-only -verify %s -Wmissing-noreturn -Wreturn-type");
  }

  @Test
  public void test_warn_missing_prototypes_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/warn-missing-prototypes.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -Wmissing-prototypes -std=c++11 ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/warn-missing-prototypes.cpp
    RUN("%clang_cc1 -fsyntax-only -verify -Wmissing-prototypes -std=c++11 %s");
  }

  @Test
  public void test_warn_missing_variable_declarations_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/warn-missing-variable-declarations.cpp");
    // ${LLVM_SRC}/build/bin/clang -Wmissing-variable-declarations -fsyntax-only -Xclang -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/warn-missing-variable-declarations.cpp
    RUN("%clang -Wmissing-variable-declarations -fsyntax-only -Xclang -verify %s");
  }

  @Test
  public void test_warn_new_overaligned_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/warn-new-overaligned.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple=x86_64-pc-linux-gnu -Wover-aligned -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/warn-new-overaligned.cpp
    RUN("%clang_cc1 -triple=x86_64-pc-linux-gnu -Wover-aligned -verify %s");
  }

  @Test
  public void test_warn_new_overaligned_2_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/warn-new-overaligned-2.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple=x86_64-pc-linux-gnu -Wover-aligned -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/warn-new-overaligned-2.cpp
    RUN("%clang_cc1 -triple=x86_64-pc-linux-gnu -Wover-aligned -verify %s");
  }

  @Test
  public void test_warn_new_overaligned_3_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/warn-new-overaligned-3.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple=x86_64-pc-linux-gnu -Wover-aligned ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/warn-new-overaligned-3.cpp -isystem ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/Inputs -verify
    RUN("%clang_cc1 -triple=x86_64-pc-linux-gnu -Wover-aligned %s -isystem %S/Inputs -verify");
  }

  @Test
  public void test_warn_overloaded_virtual_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/warn-overloaded-virtual.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -Woverloaded-virtual -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/warn-overloaded-virtual.cpp
    RUN("%clang_cc1 -fsyntax-only -Woverloaded-virtual -verify %s");
  }

  @Test
  public void test_warn_pessmizing_move_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/warn-pessmizing-move.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -Wpessimizing-move -std=c++11 -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/warn-pessmizing-move.cpp
    RUN("%clang_cc1 -fsyntax-only -Wpessimizing-move -std=c++11 -verify %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -Wpessimizing-move -std=c++11 -fdiagnostics-parseable-fixits ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/warn-pessmizing-move.cpp 2>&1 | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/warn-pessmizing-move.cpp
    RUN("%clang_cc1 -fsyntax-only -Wpessimizing-move -std=c++11 -fdiagnostics-parseable-fixits %s 2>&1")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_warn_pure_virtual_call_from_ctor_dtor_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/warn-pure-virtual-call-from-ctor-dtor.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/warn-pure-virtual-call-from-ctor-dtor.cpp -fsyntax-only -verify
    RUN("%clang_cc1 %s -fsyntax-only -verify");
  }

  @Test
  public void test_warn_pure_virtual_kext_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/warn-pure-virtual-kext.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/warn-pure-virtual-kext.cpp -fapple-kext -fsyntax-only -verify
    RUN("%clang_cc1 %s -fapple-kext -fsyntax-only -verify");
  }

  @Test
  public void test_warn_range_loop_analysis_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/warn-range-loop-analysis.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -std=c++11 -Wloop-analysis -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/warn-range-loop-analysis.cpp
    RUN("%clang_cc1 -fsyntax-only -std=c++11 -Wloop-analysis -verify %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -std=c++11 -Wrange-loop-analysis -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/warn-range-loop-analysis.cpp
    RUN("%clang_cc1 -fsyntax-only -std=c++11 -Wrange-loop-analysis -verify %s");
  }

  @Test
  public void test_warn_redundant_move_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/warn-redundant-move.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -Wredundant-move -std=c++11 -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/warn-redundant-move.cpp
    RUN("%clang_cc1 -fsyntax-only -Wredundant-move -std=c++11 -verify %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -Wredundant-move -std=c++11 -fdiagnostics-parseable-fixits ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/warn-redundant-move.cpp 2>&1 | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/warn-redundant-move.cpp
    RUN("%clang_cc1 -fsyntax-only -Wredundant-move -std=c++11 -fdiagnostics-parseable-fixits %s 2>&1")./*|*/
      I("FileCheck %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -std=c++11 ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/warn-redundant-move.cpp -ast-dump | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/warn-redundant-move.cpp --check-prefix=CHECK-AST
    RUN("%clang_cc1 -fsyntax-only -std=c++11 %s -ast-dump")./*|*/
      I("FileCheck %s --check-prefix=CHECK-AST");
  }

  @Test
  public void test_warn_reinterpret_base_class_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/warn-reinterpret-base-class.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c++11 -fsyntax-only -triple i386-pc-solaris2.11 -verify -Wreinterpret-base-class -Wno-unused-volatile-lvalue ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/warn-reinterpret-base-class.cpp
    RUN("%clang_cc1 -std=c++11 -fsyntax-only -triple %itanium_abi_triple -verify -Wreinterpret-base-class -Wno-unused-volatile-lvalue %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c++11 -fsyntax-only -triple i386-pc-win32 -DMSABI -verify -Wreinterpret-base-class -Wno-unused-volatile-lvalue ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/warn-reinterpret-base-class.cpp
    RUN("%clang_cc1 -std=c++11 -fsyntax-only -triple %ms_abi_triple -DMSABI -verify -Wreinterpret-base-class -Wno-unused-volatile-lvalue %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c++11 -fsyntax-only -triple i386-pc-solaris2.11 -fdiagnostics-parseable-fixits -Wreinterpret-base-class -Wno-unused-volatile-lvalue ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/warn-reinterpret-base-class.cpp 2>&1 | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/warn-reinterpret-base-class.cpp
    RUN("not %clang_cc1 -std=c++11 -fsyntax-only -triple %itanium_abi_triple -fdiagnostics-parseable-fixits -Wreinterpret-base-class -Wno-unused-volatile-lvalue %s 2>&1")./*|*/
      I("FileCheck %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c++11 -fsyntax-only -triple i386-pc-win32 -fdiagnostics-parseable-fixits -Wreinterpret-base-class -Wno-unused-volatile-lvalue ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/warn-reinterpret-base-class.cpp 2>&1 | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/warn-reinterpret-base-class.cpp
    RUN("not %clang_cc1 -std=c++11 -fsyntax-only -triple %ms_abi_triple -fdiagnostics-parseable-fixits -Wreinterpret-base-class -Wno-unused-volatile-lvalue %s 2>&1")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_warn_reorder_ctor_initialization_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/warn-reorder-ctor-initialization.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -Wreorder -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/warn-reorder-ctor-initialization.cpp
    RUN("%clang_cc1  -fsyntax-only -Wreorder -verify %s");
  }

  @Test
  public void test_warn_self_assign_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/warn-self-assign.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -Wself-assign -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/warn-self-assign.cpp
    RUN("%clang_cc1 -fsyntax-only -Wself-assign -verify %s");
  }

  @Test
  public void test_warn_self_comparisons_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/warn-self-comparisons.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/warn-self-comparisons.cpp
    RUN("%clang_cc1 -fsyntax-only -verify %s");
  }

  @Test
  public void test_warn_self_move_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/warn-self-move.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -Wself-move -std=c++11 -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/warn-self-move.cpp
    RUN("%clang_cc1 -fsyntax-only -Wself-move -std=c++11 -verify %s");
  }

  @Test
  public void test_warn_shadow_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/warn-shadow.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -verify -fsyntax-only -Wshadow-all ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/warn-shadow.cpp
    RUN("%clang_cc1 -verify -fsyntax-only -Wshadow-all %s");
  }

  @Test
  public void test_warn_sign_conversion_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/warn-sign-conversion.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i386-pc-solaris2.11 -verify -fsyntax-only -Wsign-conversion ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/warn-sign-conversion.cpp
    RUN("%clang_cc1 -triple %itanium_abi_triple -verify -fsyntax-only -Wsign-conversion %s");
  }

  @Test
  public void test_warn_static_const_float_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/warn-static-const-float.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/warn-static-const-float.cpp -std=c++98 -DEXT
    RUN("%clang_cc1 -verify %s -std=c++98 -DEXT");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/warn-static-const-float.cpp -std=c++98 -Wno-gnu -DNONE
    RUN("%clang_cc1 -verify %s -std=c++98 -Wno-gnu -DNONE");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/warn-static-const-float.cpp -std=c++98 -Wno-static-float-init -DNONE
    RUN("%clang_cc1 -verify %s -std=c++98 -Wno-static-float-init -DNONE");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/warn-static-const-float.cpp -std=c++98 -Wno-gnu-static-float-init -DNONE
    RUN("%clang_cc1 -verify %s -std=c++98 -Wno-gnu-static-float-init -DNONE");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/warn-static-const-float.cpp -std=c++11 -DERR
    RUN("%clang_cc1 -verify %s -std=c++11 -DERR");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/warn-static-const-float.cpp -std=c++11 -Wno-gnu -DERR
    RUN("%clang_cc1 -verify %s -std=c++11 -Wno-gnu -DERR");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/warn-static-const-float.cpp -std=c++11 -Wno-static-float-init -DNONE
    RUN("%clang_cc1 -verify %s -std=c++11 -Wno-static-float-init -DNONE");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/warn-static-const-float.cpp -std=c++11 -Wno-gnu-static-float-init -DERR
    RUN("%clang_cc1 -verify %s -std=c++11 -Wno-gnu-static-float-init -DERR");
  }

  @Test
  public void test_warn_static_function_inheader_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/warn-static-function-inheader.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -Wall ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/warn-static-function-inheader.cpp
    RUN("%clang_cc1 -fsyntax-only -verify -Wall %s");
  }

  @Test
  public void test_warn_string_conversion_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/warn-string-conversion.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -Wstring-conversion -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/warn-string-conversion.cpp
    RUN("%clang_cc1 -fsyntax-only -Wstring-conversion -verify %s");
  }

  @Test
  public void test_warn_sysheader_macro_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/warn-sysheader-macro.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -verify -fsyntax-only -Wshadow -Wold-style-cast ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/warn-sysheader-macro.cpp
    RUN("%clang_cc1 -verify -fsyntax-only -Wshadow -Wold-style-cast %s");
  }

  @Test
  public void test_warn_tautological_compare_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/warn-tautological-compare.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-apple-darwin -fsyntax-only -verify -std=c++11 ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/warn-tautological-compare.cpp
    RUN("%clang_cc1 -triple x86_64-apple-darwin -fsyntax-only -verify -std=c++11 %s");
  }

  @Test
  public void test_warn_tautological_undefined_compare_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/warn-tautological-undefined-compare.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/warn-tautological-undefined-compare.cpp
    RUN("%clang_cc1 -fsyntax-only -verify %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -Wtautological-undefined-compare ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/warn-tautological-undefined-compare.cpp
    RUN("%clang_cc1 -fsyntax-only -verify -Wtautological-undefined-compare %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -Wno-tautological-compare -Wtautological-undefined-compare ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/warn-tautological-undefined-compare.cpp
    RUN("%clang_cc1 -fsyntax-only -verify -Wno-tautological-compare -Wtautological-undefined-compare %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -Wtautological-compare ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/warn-tautological-undefined-compare.cpp
    RUN("%clang_cc1 -fsyntax-only -verify -Wtautological-compare %s");
  }

  @Test
  public void test_warn_thread_safety_analysis_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/warn-thread-safety-analysis.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -std=c++11 -Wthread-safety -Wthread-safety-beta -Wno-thread-safety-negative -fcxx-exceptions ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/warn-thread-safety-analysis.cpp
    RUN(TestState.Failed, "%clang_cc1 -fsyntax-only -verify -std=c++11 -Wthread-safety -Wthread-safety-beta -Wno-thread-safety-negative -fcxx-exceptions %s");
  }

  @Test
  public void test_warn_thread_safety_negative_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/warn-thread-safety-negative.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -std=c++11 -Wthread-safety -Wthread-safety-beta -Wthread-safety-negative -fcxx-exceptions ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/warn-thread-safety-negative.cpp
    RUN("%clang_cc1 -fsyntax-only -verify -std=c++11 -Wthread-safety -Wthread-safety-beta -Wthread-safety-negative -fcxx-exceptions %s");
  }

  @Test
  public void test_warn_thread_safety_parsing_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/warn-thread-safety-parsing.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -Wthread-safety ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/warn-thread-safety-parsing.cpp
    RUN("%clang_cc1 -fsyntax-only -verify -Wthread-safety %s");
  }

  @Test
  public void test_warn_thread_safety_verbose_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/warn-thread-safety-verbose.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -std=c++11 -Wthread-safety -Wthread-safety-beta -Wthread-safety-verbose -Wno-thread-safety-negative -fcxx-exceptions ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/warn-thread-safety-verbose.cpp
    RUN("%clang_cc1 -fsyntax-only -verify -std=c++11 -Wthread-safety -Wthread-safety-beta -Wthread-safety-verbose -Wno-thread-safety-negative -fcxx-exceptions %s");
  }

  @Test
  public void test_warn_undefined_bool_conversion_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/warn-undefined-bool-conversion.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/warn-undefined-bool-conversion.cpp
    RUN("%clang_cc1 -fsyntax-only -verify %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -Wundefined-bool-conversion ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/warn-undefined-bool-conversion.cpp
    RUN("%clang_cc1 -fsyntax-only -verify -Wundefined-bool-conversion %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -Wno-bool-conversion -Wundefined-bool-conversion ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/warn-undefined-bool-conversion.cpp
    RUN("%clang_cc1 -fsyntax-only -verify -Wno-bool-conversion -Wundefined-bool-conversion %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -Wbool-conversion ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/warn-undefined-bool-conversion.cpp
    RUN("%clang_cc1 -fsyntax-only -verify -Wbool-conversion %s");
  }

  @Test
  public void test_warn_unreachable_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/warn-unreachable.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/warn-unreachable.cpp -fcxx-exceptions -fexceptions -fsyntax-only -verify -fblocks -std=c++11 -Wunreachable-code-aggressive -Wno-unused-value -Wno-tautological-compare
    RUN("%clang_cc1 %s -fcxx-exceptions -fexceptions -fsyntax-only -verify -fblocks -std=c++11 -Wunreachable-code-aggressive -Wno-unused-value -Wno-tautological-compare");
  }

  @Test
  public void test_warn_unsequenced_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/warn-unsequenced.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -std=c++11 -Wno-unused ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/warn-unsequenced.cpp
    RUN("%clang_cc1 -fsyntax-only -verify -std=c++11 -Wno-unused %s");
  }

  @Test
  public void test_warn_unused_attribute_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/warn-unused-attribute.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -Wunused-variable -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/warn-unused-attribute.cpp
    RUN("%clang_cc1 -fsyntax-only -Wunused-variable -verify %s");
  }

  @Test
  public void test_warn_unused_comparison_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/warn-unused-comparison.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -fcxx-exceptions -verify -Wno-unused -Wunused-comparison ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/warn-unused-comparison.cpp
    RUN("%clang_cc1 -fsyntax-only -fcxx-exceptions -verify -Wno-unused -Wunused-comparison %s");
  }

  @Test
  public void test_warn_unused_filescoped_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/warn-unused-filescoped.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -Wunused -Wunused-member-function -Wno-unused-local-typedefs -Wno-c++11-extensions -std=c++98 ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/warn-unused-filescoped.cpp
    RUN("%clang_cc1 -fsyntax-only -verify -Wunused -Wunused-member-function -Wno-unused-local-typedefs -Wno-c++11-extensions -std=c++98 %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -Wunused -Wunused-member-function -Wno-unused-local-typedefs -std=c++11 ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/warn-unused-filescoped.cpp
    RUN("%clang_cc1 -fsyntax-only -verify -Wunused -Wunused-member-function -Wno-unused-local-typedefs -std=c++11 %s");
  }

  @Test
  public void test_warn_unused_label_error_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/warn-unused-label-error.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -Wunused-variable -Wunused-label -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/warn-unused-label-error.cpp
    RUN("%clang_cc1 -fsyntax-only -Wunused-variable -Wunused-label -verify %s");
  }

  @Test
  public void test_warn_unused_local_typedef_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/warn-unused-local-typedef.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -Wunused-local-typedef -verify -std=c++1y ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/warn-unused-local-typedef.cpp
    RUN("%clang_cc1 -fsyntax-only -Wunused-local-typedef -verify -std=c++1y %s");
  }

  @Test
  public void test_warn_unused_local_typedef_serialize_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/warn-unused-local-typedef-serialize.cpp");
    // ${LLVM_SRC}/build/bin/clang -x c++-header -c -Wunused-local-typedef ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/warn-unused-local-typedef-serialize.cpp -o ${TEST_TEMP_DIR}/warn-unused-local-typedef-serialize.cpp.tmp.gch -Werror
    RUN(TestState.Failed, "%clang -x c++-header -c -Wunused-local-typedef %s -o %t.gch -Werror");
    // ${LLVM_SRC}/build/bin/clang -DBE_THE_SOURCE -c -Wunused-local-typedef -include ${TEST_TEMP_DIR}/warn-unused-local-typedef-serialize.cpp.tmp ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/warn-unused-local-typedef-serialize.cpp -o /dev/null 2>&1 | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/warn-unused-local-typedef-serialize.cpp
    RUN(TestState.Failed, "%clang -DBE_THE_SOURCE -c -Wunused-local-typedef -include %t %s -o /dev/null 2>&1")./*|*/
      I("FileCheck %s");
    // ${LLVM_SRC}/build/bin/clang -DBE_THE_SOURCE -c -Wunused-local-typedef -include ${TEST_TEMP_DIR}/warn-unused-local-typedef-serialize.cpp.tmp ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/warn-unused-local-typedef-serialize.cpp -o /dev/null 2>&1 | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/warn-unused-local-typedef-serialize.cpp
    RUN(TestState.Failed, "%clang -DBE_THE_SOURCE -c -Wunused-local-typedef -include %t %s -o /dev/null 2>&1")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_warn_unused_local_typedef_x86asm_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/warn-unused-local-typedef-x86asm.cpp");
    // REQUIRES: x86-registered-target
    if (!CHECK_REQUIRES("x86-registered-target")) {
      return;
    }
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-unknown-unknown -fsyntax-only -std=c++11 -Wunused-local-typedef -verify -fasm-blocks ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/warn-unused-local-typedef-x86asm.cpp
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-unknown-unknown -fsyntax-only -std=c++11 -Wunused-local-typedef -verify -fasm-blocks %s");
  }

  @Test
  public void test_warn_unused_parameters_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/warn-unused-parameters.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -Wunused-parameter -verify -std=c++11 ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/warn-unused-parameters.cpp
    RUN("%clang_cc1 -fsyntax-only -Wunused-parameter -verify -std=c++11 %s");
  }

  @Test
  public void test_warn_unused_private_field_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/warn-unused-private-field.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -Wunused-private-field -Wused-but-marked-unused -Wno-uninitialized -verify -std=c++11 ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/warn-unused-private-field.cpp
    RUN("%clang_cc1 -fsyntax-only -Wunused-private-field -Wused-but-marked-unused -Wno-uninitialized -verify -std=c++11 %s");
  }

  @Test
  public void test_warn_unused_private_field_delayed_template_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/warn-unused-private-field-delayed-template.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -fdelayed-template-parsing -Wunused-private-field -Wused-but-marked-unused -Wno-uninitialized -verify -std=c++11 ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/warn-unused-private-field-delayed-template.cpp
    RUN("%clang_cc1 -fsyntax-only -fdelayed-template-parsing -Wunused-private-field -Wused-but-marked-unused -Wno-uninitialized -verify -std=c++11 %s");
  }

  @Test
  public void test_warn_unused_result_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/warn-unused-result.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -std=c++11 ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/warn-unused-result.cpp
    RUN("%clang_cc1 -fsyntax-only -verify -std=c++11 %s");
  }

  @Test
  public void test_warn_unused_value_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/warn-unused-value.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -Wunused-value ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/warn-unused-value.cpp
    RUN("%clang_cc1 -fsyntax-only -verify -Wunused-value %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -Wunused-value -std=c++98 ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/warn-unused-value.cpp
    RUN("%clang_cc1 -fsyntax-only -verify -Wunused-value -std=c++98 %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -Wunused-value -std=c++11 ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/warn-unused-value.cpp
    RUN("%clang_cc1 -fsyntax-only -verify -Wunused-value -std=c++11 %s");
  }

  @Test
  public void test_warn_unused_value_cxx11_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/warn-unused-value-cxx11.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c++11 -fsyntax-only -verify -Wunused-value ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/warn-unused-value-cxx11.cpp
    RUN("%clang_cc1 -std=c++11 -fsyntax-only -verify -Wunused-value %s");
  }

  @Test
  public void test_warn_unused_variables_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/warn-unused-variables.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -Wunused-variable -Wunused-label -Wno-c++1y-extensions -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/warn-unused-variables.cpp
    RUN("%clang_cc1 -fsyntax-only -Wunused-variable -Wunused-label -Wno-c++1y-extensions -verify %s");
  }

  @Test
  public void test_warn_unused_variables_error_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/warn-unused-variables-error.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -Wunused-variable -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/warn-unused-variables-error.cpp
    RUN("%clang_cc1 -fsyntax-only -Wunused-variable -verify %s");
  }

  @Test
  public void test_warn_using_namespace_in_header_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/warn-using-namespace-in-header.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -Wheader-hygiene -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/warn-using-namespace-in-header.cpp
    RUN("%clang_cc1 -fsyntax-only -Wheader-hygiene -verify %s");
  }

  @Test
  public void test_warn_variable_not_needed_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/warn-variable-not-needed.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -Wall ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/warn-variable-not-needed.cpp
    RUN("%clang_cc1 -fsyntax-only -verify -Wall %s");
  }

  @Test
  public void test_warn_vla_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/warn-vla.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -Wvla ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/warn-vla.cpp
    RUN("%clang_cc1 -fsyntax-only -verify -Wvla %s");
  }

  @Test
  public void test_warn_weak_vtables_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/warn-weak-vtables.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/warn-weak-vtables.cpp -fsyntax-only -verify -triple i386-pc-solaris2.11 -Wweak-vtables -Wweak-template-vtables
    RUN("%clang_cc1 %s -fsyntax-only -verify -triple %itanium_abi_triple -Wweak-vtables -Wweak-template-vtables");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/warn-weak-vtables.cpp -fsyntax-only -triple i386-pc-win32 -Werror -Wno-weak-vtables -Wno-weak-template-vtables
    RUN("%clang_cc1 %s -fsyntax-only -triple %ms_abi_triple -Werror -Wno-weak-vtables -Wno-weak-template-vtables");
  }

  @Test
  public void test_wchar_t_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/wchar_t.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -pedantic -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/wchar_t.cpp
    RUN("%clang_cc1 -fsyntax-only -pedantic -verify %s");
  }

  @Test
  public void test_windows_arm_valist_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/windows-arm-valist.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple thumbv7--windows-msvc -std=c++11 -verify -fsyntax-only ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/windows-arm-valist.cpp
    RUN("%clang_cc1 -triple thumbv7--windows-msvc -std=c++11 -verify -fsyntax-only %s");
  }

  @Test
  public void test_writable_strings_deprecated_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/writable-strings-deprecated.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/writable-strings-deprecated.cpp -DWARNING
    RUN("%clang_cc1 -fsyntax-only -verify %s -DWARNING");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -std=c++98 -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/writable-strings-deprecated.cpp -DWARNING
    RUN("%clang_cc1 -fsyntax-only -std=c++98 -verify %s -DWARNING");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -std=c++98 -Wno-deprecated-writable-strings -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/writable-strings-deprecated.cpp
    RUN("%clang_cc1 -fsyntax-only -std=c++98 -Wno-deprecated-writable-strings -verify %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -std=c++98 -Wno-deprecated -Wdeprecated-increment-bool -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/writable-strings-deprecated.cpp
    RUN("%clang_cc1 -fsyntax-only -std=c++98 -Wno-deprecated -Wdeprecated-increment-bool -verify %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -std=c++98 -fwritable-strings -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/writable-strings-deprecated.cpp
    RUN("%clang_cc1 -fsyntax-only -std=c++98 -fwritable-strings -verify %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -std=c++98 -Wno-write-strings -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/writable-strings-deprecated.cpp
    RUN("%clang_cc1 -fsyntax-only -std=c++98 -Wno-write-strings -verify %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -std=c++98 -Werror=c++11-compat -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/writable-strings-deprecated.cpp -DERROR
    RUN("%clang_cc1 -fsyntax-only -std=c++98 -Werror=c++11-compat -verify %s -DERROR");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -std=c++98 -Werror=deprecated -Wno-error=deprecated-increment-bool -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/writable-strings-deprecated.cpp -DERROR
    RUN("%clang_cc1 -fsyntax-only -std=c++98 -Werror=deprecated -Wno-error=deprecated-increment-bool -verify %s -DERROR");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -std=c++11 -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/writable-strings-deprecated.cpp -DWARNING
    RUN("%clang_cc1 -fsyntax-only -std=c++11 -verify %s -DWARNING");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -std=c++11 -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/writable-strings-deprecated.cpp -Wno-deprecated -Wdeprecated-increment-bool -DWARNING
    RUN("%clang_cc1 -fsyntax-only -std=c++11 -verify %s -Wno-deprecated -Wdeprecated-increment-bool -DWARNING");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -std=c++11 -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/writable-strings-deprecated.cpp -pedantic-errors -DERROR
    RUN("%clang_cc1 -fsyntax-only -std=c++11 -verify %s -pedantic-errors -DERROR");
  }

  @Test
  public void test_zero_length_arrays_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/zero-length-arrays.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaCXX/zero-length-arrays.cpp
    RUN("%clang_cc1 -fsyntax-only -verify %s");
  }
  
}
