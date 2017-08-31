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
 * Collection of all test files from test/CXX/over folder
 * @author Vladimir Voskresensky
 */
public class AllCXXOverTest extends DriverTestFileBase {
  private static final String TEST_LOCATION = "${LLVM_SRC}/llvm/tools/clang/test/CXX/over/";
  public AllCXXOverTest() {
    super(TEST_LOCATION, TestState.Successful);
  }
  
  public static void main(String[] args) {
    // Print tests which will be accepted per test case
    DriverTestFileBase.printAllTestFiles(true, 
            TEST_LOCATION, (test)->{ return true;/*test.getFileIndexInFolder()<120;*/ }, 
            "${SPUTNIK}/modules/org.clang.parse/test/unit/src/org/clang/parse/test/AllCXXOverTest.txt");
  }  

  @Override
  protected boolean keepStacksForUnimplementedMethods() {
    return false;
  }
  
  @Test
  public void test_over_match_best_p1_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CXX/over/over.match/over.match.best/p1.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/CXX/over/over.match/over.match.best/p1.cpp
    RUN("%clang_cc1 -fsyntax-only -verify %s");
  }

  @Test
  public void test_over_match_copy_p1_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CXX/over/over.match/over.match.funcs/over.match.copy/p1.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c++11 -fsyntax-only ${LLVM_SRC}/llvm/tools/clang/test/CXX/over/over.match/over.match.funcs/over.match.copy/p1.cpp -verify
    RUN("%clang_cc1 -std=c++11 -fsyntax-only %s -verify");
  }

  @Test
  public void test_over_over_p1_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CXX/over/over.over/p1.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only ${LLVM_SRC}/llvm/tools/clang/test/CXX/over/over.over/p1.cpp
    RUN("%clang_cc1 -fsyntax-only %s");
  }

  @Test
  public void test_over_literal_p2_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CXX/over/over.oper/over.literal/p2.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c++11 ${LLVM_SRC}/llvm/tools/clang/test/CXX/over/over.oper/over.literal/p2.cpp -verify
    RUN("%clang_cc1 -std=c++11 %s -verify");
  }

  @Test
  public void test_over_over_p2_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CXX/over/over.over/p2.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/CXX/over/over.over/p2.cpp
    RUN("%clang_cc1 -fsyntax-only -verify %s");
  }

  @Test
  public void test_over_load_p2_0x_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CXX/over/over.load/p2-0x.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c++11 -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/CXX/over/over.load/p2-0x.cpp
    RUN("%clang_cc1 -std=c++11 -fsyntax-only -verify %s");
  }

  @Test
  public void test_over_over_p2_resolve_single_template_id_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CXX/over/over.over/p2-resolve-single-template-id.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -Wno-bool-conversion ${LLVM_SRC}/llvm/tools/clang/test/CXX/over/over.over/p2-resolve-single-template-id.cpp
    RUN("%clang_cc1 -fsyntax-only -verify -Wno-bool-conversion %s");
  }

  @Test
  public void test_over_built_p23_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CXX/over/over.built/p23.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -std=c++11 -verify ${LLVM_SRC}/llvm/tools/clang/test/CXX/over/over.built/p23.cpp
    RUN("%clang_cc1 -fsyntax-only -std=c++11 -verify %s");
  }

  @Test
  public void test_over_built_p25_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CXX/over/over.built/p25.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -std=c++11 ${LLVM_SRC}/llvm/tools/clang/test/CXX/over/over.built/p25.cpp
    RUN("%clang_cc1 -fsyntax-only -verify -std=c++11 %s");
  }

  @Test
  public void test_over_match_oper_p3_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CXX/over/over.match/over.match.funcs/over.match.oper/p3.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -std=c++11 ${LLVM_SRC}/llvm/tools/clang/test/CXX/over/over.match/over.match.funcs/over.match.oper/p3.cpp
    RUN("%clang_cc1 -fsyntax-only -verify -std=c++11 %s");
  }

  @Test
  public void test_over_literal_p3_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CXX/over/over.oper/over.literal/p3.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c++11 ${LLVM_SRC}/llvm/tools/clang/test/CXX/over/over.oper/over.literal/p3.cpp -verify
    RUN("%clang_cc1 -std=c++11 %s -verify");
  }

  @Test
  public void test_over_ics_user_p3_0x_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CXX/over/over.match/over.match.best/over.best.ics/over.ics.user/p3-0x.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -std=c++11 -verify ${LLVM_SRC}/llvm/tools/clang/test/CXX/over/over.match/over.match.best/over.best.ics/over.ics.user/p3-0x.cpp
    RUN("%clang_cc1 -fsyntax-only -std=c++11 -verify %s");
  }

  @Test
  public void test_over_ics_rank_p3_0x_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CXX/over/over.match/over.match.best/over.ics.rank/p3-0x.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c++11 -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/CXX/over/over.match/over.match.best/over.ics.rank/p3-0x.cpp
    RUN("%clang_cc1 -std=c++11 -fsyntax-only -verify %s");
  }

  @Test
  public void test_over_over_p4_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CXX/over/over.over/p4.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/CXX/over/over.over/p4.cpp
    RUN("%clang_cc1 -fsyntax-only -verify %s");
  }

  @Test
  public void test_over_match_funcs_p4_0x_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CXX/over/over.match/over.match.funcs/p4-0x.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c++11 -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/CXX/over/over.match/over.match.funcs/p4-0x.cpp
    RUN("%clang_cc1 -std=c++11 -fsyntax-only -verify %s");
  }

  @Test
  public void test_over_literal_p5_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CXX/over/over.oper/over.literal/p5.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c++11 ${LLVM_SRC}/llvm/tools/clang/test/CXX/over/over.oper/over.literal/p5.cpp -verify
    RUN("%clang_cc1 -std=c++11 %s -verify");
  }

  @Test
  public void test_over_ics_list_p6_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CXX/over/over.match/over.match.best/over.best.ics/over.ics.list/p6.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c++11 -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/CXX/over/over.match/over.match.best/over.best.ics/over.ics.list/p6.cpp
    RUN("%clang_cc1 -std=c++11 -fsyntax-only -verify %s");
  }

  @Test
  public void test_over_literal_p6_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CXX/over/over.oper/over.literal/p6.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c++11 ${LLVM_SRC}/llvm/tools/clang/test/CXX/over/over.oper/over.literal/p6.cpp -verify
    RUN("%clang_cc1 -std=c++11 %s -verify");
  }

  @Test
  public void test_over_literal_p7_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CXX/over/over.oper/over.literal/p7.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c++11 ${LLVM_SRC}/llvm/tools/clang/test/CXX/over/over.oper/over.literal/p7.cpp -verify
    RUN("%clang_cc1 -std=c++11 %s -verify");
  }

  @Test
  public void test_over_literal_p8_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CXX/over/over.oper/over.literal/p8.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c++11 ${LLVM_SRC}/llvm/tools/clang/test/CXX/over/over.oper/over.literal/p8.cpp -verify
    RUN("%clang_cc1 -std=c++11 %s -verify");
  }
  
}
