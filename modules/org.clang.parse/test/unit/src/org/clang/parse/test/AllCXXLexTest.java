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
 * Collection of all test files from test/CXX/lex folder
 * @author Vladimir Voskresensky
 */
public class AllCXXLexTest extends DriverTestFileBase {
  private static final String TEST_LOCATION = "${LLVM_SRC}/llvm/tools/clang/test/CXX/lex";
  public AllCXXLexTest() {
    super(TEST_LOCATION, TestState.Successful);
  }
  
  public static void main(String[] args) {
    // Print tests which will be accepted per test case
    DriverTestFileBase.printAllTestFiles(true, 
            TEST_LOCATION, (test)->{ return true;/*test.getFileIndexInFolder()<120;*/ }, 
            "${SPUTNIK}/modules/org.clang.parse/test/unit/src/org/clang/parse/test/AllCXXLexTest.txt");
  }  

  @Override
  protected boolean keepStacksForUnimplementedMethods() {
    return false;
  }
  
  @Test
  public void test_lex_ccon_p1_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CXX/lex/lex.literal/lex.ccon/p1.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/CXX/lex/lex.literal/lex.ccon/p1.cpp
    RUN("%clang_cc1 -fsyntax-only -verify %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c++11 -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/CXX/lex/lex.literal/lex.ccon/p1.cpp
    RUN("%clang_cc1 -std=c++11 -fsyntax-only -verify %s");
  }

  @Test
  public void test_lex_ext_p1_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CXX/lex/lex.literal/lex.ext/p1.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -std=c++11 -verify ${LLVM_SRC}/llvm/tools/clang/test/CXX/lex/lex.literal/lex.ext/p1.cpp
    RUN("%clang_cc1 -fsyntax-only -std=c++11 -verify %s");
  }

  @Test
  public void test_lex_trigraph_p1_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CXX/lex/lex.trigraph/p1.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -ftrigraphs -Wtrigraphs -verify ${LLVM_SRC}/llvm/tools/clang/test/CXX/lex/lex.trigraph/p1.cpp
    RUN("%clang_cc1 -fsyntax-only -ftrigraphs -Wtrigraphs -verify %s");
  }

  @Test
  public void test_lex_ext_p10_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CXX/lex/lex.literal/lex.ext/p10.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c++11 -verify ${LLVM_SRC}/llvm/tools/clang/test/CXX/lex/lex.literal/lex.ext/p10.cpp
    RUN("%clang_cc1 -std=c++11 -verify %s");
  }

  @Test
  public void test_lex_ext_p11_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CXX/lex/lex.literal/lex.ext/p11.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -std=c++11 -verify ${LLVM_SRC}/llvm/tools/clang/test/CXX/lex/lex.literal/lex.ext/p11.cpp
    RUN("%clang_cc1 -fsyntax-only -std=c++11 -verify %s");
  }

  @Test
  public void test_lex_ext_p12_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CXX/lex/lex.literal/lex.ext/p12.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=gnu++11 -verify ${LLVM_SRC}/llvm/tools/clang/test/CXX/lex/lex.literal/lex.ext/p12.cpp
    RUN(TestState.Failed, "%clang_cc1 -std=gnu++11 -verify %s");
  }

  @Test
  public void test_lex_ext_p2_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CXX/lex/lex.literal/lex.ext/p2.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -std=c++11 -verify ${LLVM_SRC}/llvm/tools/clang/test/CXX/lex/lex.literal/lex.ext/p2.cpp
    RUN("%clang_cc1 -fsyntax-only -std=c++11 -verify %s");
  }

  @Test
  public void test_lex_trigraph_p2_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CXX/lex/lex.trigraph/p2.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -ftrigraphs -Wtrigraphs -verify ${LLVM_SRC}/llvm/tools/clang/test/CXX/lex/lex.trigraph/p2.cpp
    RUN("%clang_cc1 -fsyntax-only -ftrigraphs -Wtrigraphs -verify %s");
  }

  @Test
  public void test_lex_charset_p2_cxx11_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CXX/lex/lex.charset/p2-cxx11.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -verify -std=c++11 ${LLVM_SRC}/llvm/tools/clang/test/CXX/lex/lex.charset/p2-cxx11.cpp
    RUN("%clang_cc1 -verify -std=c++11 %s");
  }

  @Test
  public void test_lex_charset_p2_cxx98_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CXX/lex/lex.charset/p2-cxx98.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -verify -std=c++98 ${LLVM_SRC}/llvm/tools/clang/test/CXX/lex/lex.charset/p2-cxx98.cpp
    RUN("%clang_cc1 -verify -std=c++98 %s");
  }

  @Test
  public void test_lex_ext_p3_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CXX/lex/lex.literal/lex.ext/p3.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -std=c++11 -verify ${LLVM_SRC}/llvm/tools/clang/test/CXX/lex/lex.literal/lex.ext/p3.cpp
    RUN("%clang_cc1 -fsyntax-only -std=c++11 -verify %s");
  }

  @Test
  public void test_lex_trigraph_p3_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CXX/lex/lex.trigraph/p3.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -ftrigraphs -Wtrigraphs -verify ${LLVM_SRC}/llvm/tools/clang/test/CXX/lex/lex.trigraph/p3.cpp
    RUN("%clang_cc1 -fsyntax-only -ftrigraphs -Wtrigraphs -verify %s");
  }

  @Test
  public void test_lex_pptoken_p3_0x_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CXX/lex/lex.pptoken/p3-0x.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -std=c++11 -verify ${LLVM_SRC}/llvm/tools/clang/test/CXX/lex/lex.pptoken/p3-0x.cpp
    RUN("%clang_cc1 -fsyntax-only -std=c++11 -verify %s");
  }

  @Test
  public void test_lex_ext_p4_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CXX/lex/lex.literal/lex.ext/p4.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -std=c++11 -verify ${LLVM_SRC}/llvm/tools/clang/test/CXX/lex/lex.literal/lex.ext/p4.cpp
    RUN("%clang_cc1 -fsyntax-only -std=c++11 -verify %s");
  }

  @Test
  public void test_lex_string_p4_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CXX/lex/lex.literal/lex.string/p4.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -std=c++11 -verify ${LLVM_SRC}/llvm/tools/clang/test/CXX/lex/lex.literal/lex.string/p4.cpp
    RUN("%clang_cc1 -fsyntax-only -std=c++11 -verify %s");
  }

  @Test
  public void test_lex_ext_p5_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CXX/lex/lex.literal/lex.ext/p5.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -std=c++11 -verify ${LLVM_SRC}/llvm/tools/clang/test/CXX/lex/lex.literal/lex.ext/p5.cpp -triple=x86_64-linux-gnu
    RUN("%clang_cc1 -fsyntax-only -std=c++11 -verify %s -triple=x86_64-linux-gnu");
  }

  @Test
  public void test_lex_ext_p6_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CXX/lex/lex.literal/lex.ext/p6.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -std=c++11 -verify ${LLVM_SRC}/llvm/tools/clang/test/CXX/lex/lex.literal/lex.ext/p6.cpp
    RUN("%clang_cc1 -fsyntax-only -std=c++11 -verify %s");
  }

  @Test
  public void test_lex_ext_p7_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CXX/lex/lex.literal/lex.ext/p7.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -std=c++11 -verify ${LLVM_SRC}/llvm/tools/clang/test/CXX/lex/lex.literal/lex.ext/p7.cpp -triple=x86_64-linux-gnu
    RUN("%clang_cc1 -fsyntax-only -std=c++11 -verify %s -triple=x86_64-linux-gnu");
  }

  @Test
  public void test_lex_ext_p8_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CXX/lex/lex.literal/lex.ext/p8.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c++11 -verify ${LLVM_SRC}/llvm/tools/clang/test/CXX/lex/lex.literal/lex.ext/p8.cpp
    RUN("%clang_cc1 -std=c++11 -verify %s");
  }

  @Test
  public void test_lex_ext_p9_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CXX/lex/lex.literal/lex.ext/p9.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c++11 -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/CXX/lex/lex.literal/lex.ext/p9.cpp
    RUN("%clang_cc1 -std=c++11 -fsyntax-only -verify %s");
  }
  
}
