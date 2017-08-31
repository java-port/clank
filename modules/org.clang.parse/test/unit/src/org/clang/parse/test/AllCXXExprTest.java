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
 * Collection of all test files from test/CXX/expr folder
 * @author Vladimir Voskresensky
 */
public class AllCXXExprTest extends DriverTestFileBase {
  private static final String TEST_LOCATION = "${LLVM_SRC}/llvm/tools/clang/test/CXX/expr/";
  public AllCXXExprTest() {
    super(TEST_LOCATION, TestState.Successful);
  }
  
  public static void main(String[] args) {
    // Print tests which will be accepted per test case
    DriverTestFileBase.printAllTestFiles(true, 
            TEST_LOCATION, (test)->{ return true;/*test.getFileIndexInFolder()<120;*/ }, 
            "${SPUTNIK}/modules/org.clang.parse/test/unit/src/org/clang/parse/test/AllCXXExprTest.txt");
  }  

  @Override
  protected boolean keepStacksForUnimplementedMethods() {
    return false;
  }
  
  @Test
  public void test_expr_prim_lambda_blocks_mm() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CXX/expr/expr.prim/expr.prim.lambda/blocks.mm");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i686-pc-linux -std=c++11 -fblocks ${LLVM_SRC}/llvm/tools/clang/test/CXX/expr/expr.prim/expr.prim.lambda/blocks.mm -verify
    RUN("%clang_cc1 -triple i686-pc-linux -std=c++11 -fblocks %s -verify");
  }

  @Test
  public void test_expr_prim_lambda_blocks_irgen_mm() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CXX/expr/expr.prim/expr.prim.lambda/blocks-irgen.mm");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c++11 -fblocks -emit-llvm -o - -triple x86_64-apple-darwin11.3 ${LLVM_SRC}/llvm/tools/clang/test/CXX/expr/expr.prim/expr.prim.lambda/blocks-irgen.mm | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CXX/expr/expr.prim/expr.prim.lambda/blocks-irgen.mm
    RUN(TestState.SemanticErrors, "%clang_cc1 -std=c++11 -fblocks -emit-llvm -o - -triple x86_64-apple-darwin11.3 %s")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_expr_unary_noexcept_cg_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CXX/expr/expr.unary/expr.unary.noexcept/cg.cpp");
    // REQUIRES: x86-registered-target
    if (!CHECK_REQUIRES("x86-registered-target")) {
      return;
    }
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fcxx-exceptions -fexceptions -triple x86_64-apple-darwin10 -S -emit-llvm -std=c++11 -include ${LLVM_SRC}/llvm/tools/clang/test/CXX/expr/expr.unary/expr.unary.noexcept/ser.h ${LLVM_SRC}/llvm/tools/clang/test/CXX/expr/expr.unary/expr.unary.noexcept/cg.cpp -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CXX/expr/expr.unary/expr.unary.noexcept/cg.cpp
    RUN(TestState.SemanticErrors, "%clang_cc1 -fcxx-exceptions -fexceptions -triple x86_64-apple-darwin10 -S -emit-llvm -std=c++11 -include %S/ser.h %s -o -")./*|*/
      I("FileCheck %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fcxx-exceptions -fexceptions -triple x86_64-apple-darwin10 -emit-pch -o ${TEST_TEMP_DIR}/cg.cpp.tmp-ser.pch -std=c++11 -x c++ ${LLVM_SRC}/llvm/tools/clang/test/CXX/expr/expr.unary/expr.unary.noexcept/ser.h
    RUN(TestState.Failed, "%clang_cc1 -fcxx-exceptions -fexceptions -triple x86_64-apple-darwin10 -emit-pch -o %t-ser.pch -std=c++11 -x c++ %S/ser.h");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fcxx-exceptions -fexceptions -triple x86_64-apple-darwin10 -S -emit-llvm -std=c++11 -include-pch ${TEST_TEMP_DIR}/cg.cpp.tmp-ser.pch ${LLVM_SRC}/llvm/tools/clang/test/CXX/expr/expr.unary/expr.unary.noexcept/cg.cpp -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CXX/expr/expr.unary/expr.unary.noexcept/cg.cpp
    RUN(TestState.SemanticErrors, "%clang_cc1 -fcxx-exceptions -fexceptions -triple x86_64-apple-darwin10 -S -emit-llvm -std=c++11 -include-pch %t-ser.pch %s -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_expr_prim_lambda_default_arguments_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CXX/expr/expr.prim/expr.prim.lambda/default-arguments.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -std=c++11 ${LLVM_SRC}/llvm/tools/clang/test/CXX/expr/expr.prim/expr.prim.lambda/default-arguments.cpp -verify
    RUN("%clang_cc1 -fsyntax-only -std=c++11 %s -verify");
  }

  @Test
  public void test_expr_sizeof_p1_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CXX/expr/expr.unary/expr.sizeof/p1.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/CXX/expr/expr.unary/expr.sizeof/p1.cpp
    RUN("%clang_cc1 -fsyntax-only -verify %s");
  }

  @Test
  public void test_expr_const_cast_p1_0x_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CXX/expr/expr.post/expr.const.cast/p1-0x.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c++11 -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/CXX/expr/expr.post/expr.const.cast/p1-0x.cpp
    RUN("%clang_cc1 -std=c++11 -fsyntax-only -verify %s");
  }

  @Test
  public void test_expr_reinterpret_cast_p1_0x_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CXX/expr/expr.post/expr.reinterpret.cast/p1-0x.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c++11 -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/CXX/expr/expr.post/expr.reinterpret.cast/p1-0x.cpp
    RUN("%clang_cc1 -std=c++11 -fsyntax-only -verify %s");
  }

  @Test
  public void test_expr_type_conv_p1_0x_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CXX/expr/expr.post/expr.type.conv/p1-0x.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -std=c++11 ${LLVM_SRC}/llvm/tools/clang/test/CXX/expr/expr.post/expr.type.conv/p1-0x.cpp
    RUN("%clang_cc1 -fsyntax-only -verify -std=c++11 %s");
  }

  @Test
  public void test_expr_prim_lambda_p10_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CXX/expr/expr.prim/expr.prim.lambda/p10.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c++11 ${LLVM_SRC}/llvm/tools/clang/test/CXX/expr/expr.prim/expr.prim.lambda/p10.cpp -verify
    RUN("%clang_cc1 -std=c++11 %s -verify");
  }

  @Test
  public void test_expr_p10_0x_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CXX/expr/p10-0x.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm -triple x86_64-pc-linux-gnu ${LLVM_SRC}/llvm/tools/clang/test/CXX/expr/p10-0x.cpp -o - -std=c++11 | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CXX/expr/p10-0x.cpp
    RUN(TestState.SemanticErrors, "%clang_cc1 -emit-llvm -triple x86_64-pc-linux-gnu %s -o - -std=c++11")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_expr_prim_lambda_p11_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CXX/expr/expr.prim/expr.prim.lambda/p11.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c++11 ${LLVM_SRC}/llvm/tools/clang/test/CXX/expr/expr.prim/expr.prim.lambda/p11.cpp -verify
    RUN("%clang_cc1 -std=c++11 %s -verify");
  }

  @Test
  public void test_expr_prim_lambda_p11_1y_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CXX/expr/expr.prim/expr.prim.lambda/p11-1y.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c++1y ${LLVM_SRC}/llvm/tools/clang/test/CXX/expr/expr.prim/expr.prim.lambda/p11-1y.cpp -verify
    RUN("%clang_cc1 -std=c++1y %s -verify");
  }

  @Test
  public void test_expr_prim_lambda_p12_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CXX/expr/expr.prim/expr.prim.lambda/p12.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c++11 ${LLVM_SRC}/llvm/tools/clang/test/CXX/expr/expr.prim/expr.prim.lambda/p12.cpp -Wunused -verify
    RUN("%clang_cc1 -std=c++11 %s -Wunused -verify");
  }

  @Test
  public void test_expr_prim_general_p12_0x_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CXX/expr/expr.prim/expr.prim.general/p12-0x.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -std=c++11 ${LLVM_SRC}/llvm/tools/clang/test/CXX/expr/expr.prim/expr.prim.general/p12-0x.cpp
    RUN("%clang_cc1 -fsyntax-only -verify -std=c++11 %s");
  }

  @Test
  public void test_expr_prim_lambda_p13_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CXX/expr/expr.prim/expr.prim.lambda/p13.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c++11 ${LLVM_SRC}/llvm/tools/clang/test/CXX/expr/expr.prim/expr.prim.lambda/p13.cpp -Wunused -verify
    RUN("%clang_cc1 -std=c++11 %s -Wunused -verify");
  }

  @Test
  public void test_expr_prim_lambda_p14_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CXX/expr/expr.prim/expr.prim.lambda/p14.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -std=c++11 ${LLVM_SRC}/llvm/tools/clang/test/CXX/expr/expr.prim/expr.prim.lambda/p14.cpp -verify
    RUN("%clang_cc1 -fsyntax-only -std=c++11 %s -verify");
  }

  @Test
  public void test_expr_prim_lambda_p15_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CXX/expr/expr.prim/expr.prim.lambda/p15.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -std=c++11 ${LLVM_SRC}/llvm/tools/clang/test/CXX/expr/expr.prim/expr.prim.lambda/p15.cpp -verify
    RUN("%clang_cc1 -fsyntax-only -std=c++11 %s -verify");
  }

  @Test
  public void test_expr_prim_lambda_p15_star_this_capture_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CXX/expr/expr.prim/expr.prim.lambda/p15-star-this-capture.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -std=c++1z ${LLVM_SRC}/llvm/tools/clang/test/CXX/expr/expr.prim/expr.prim.lambda/p15-star-this-capture.cpp -verify
    RUN("%clang_cc1 -fsyntax-only -std=c++1z %s -verify");
  }

  @Test
  public void test_expr_prim_lambda_p16_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CXX/expr/expr.prim/expr.prim.lambda/p16.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c++11 ${LLVM_SRC}/llvm/tools/clang/test/CXX/expr/expr.prim/expr.prim.lambda/p16.cpp -Wunused -verify
    RUN("%clang_cc1 -std=c++11 %s -Wunused -verify");
  }

  @Test
  public void test_expr_new_p17_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CXX/expr/expr.unary/expr.new/p17.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/CXX/expr/expr.unary/expr.new/p17.cpp
    RUN("%clang_cc1 -fsyntax-only -verify %s");
  }

  @Test
  public void test_expr_new_p17_crash_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CXX/expr/expr.unary/expr.new/p17-crash.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm-only ${LLVM_SRC}/llvm/tools/clang/test/CXX/expr/expr.unary/expr.new/p17-crash.cpp
    RUN(TestState.SemanticErrors, "%clang_cc1 -emit-llvm-only %s");
  }

  @Test
  public void test_expr_prim_lambda_p18_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CXX/expr/expr.prim/expr.prim.lambda/p18.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c++11 ${LLVM_SRC}/llvm/tools/clang/test/CXX/expr/expr.prim/expr.prim.lambda/p18.cpp -Wunused -verify
    RUN("%clang_cc1 -std=c++11 %s -Wunused -verify");
  }

  @Test
  public void test_expr_prim_lambda_p19_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CXX/expr/expr.prim/expr.prim.lambda/p19.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c++11 ${LLVM_SRC}/llvm/tools/clang/test/CXX/expr/expr.prim/expr.prim.lambda/p19.cpp -Wunused -verify
    RUN("%clang_cc1 -std=c++11 %s -Wunused -verify");
  }

  @Test
  public void test_expr_new_p19_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CXX/expr/expr.unary/expr.new/p19.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -fexceptions ${LLVM_SRC}/llvm/tools/clang/test/CXX/expr/expr.unary/expr.new/p19.cpp
    RUN("%clang_cc1 -fsyntax-only -verify -fexceptions %s");
  }

  @Test
  public void test_expr_prim_lambda_p2_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CXX/expr/expr.prim/expr.prim.lambda/p2.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -std=c++11 -Wno-unused-value ${LLVM_SRC}/llvm/tools/clang/test/CXX/expr/expr.prim/expr.prim.lambda/p2.cpp -verify
    RUN("%clang_cc1 -fsyntax-only -std=c++11 -Wno-unused-value %s -verify");
  }

  @Test
  public void test_expr_const_p2_0x_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CXX/expr/expr.const/p2-0x.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -std=c++11 -pedantic -verify -fcxx-exceptions ${LLVM_SRC}/llvm/tools/clang/test/CXX/expr/expr.const/p2-0x.cpp -fconstexpr-depth 128 -triple i686-pc-linux-gnu
    RUN(TestState.Failed, "%clang_cc1 -fsyntax-only -std=c++11 -pedantic -verify -fcxx-exceptions %s -fconstexpr-depth 128 -triple i686-pc-linux-gnu");
  }

  @Test
  public void test_expr_new_p2_cxx0x_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CXX/expr/expr.unary/expr.new/p2-cxx0x.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/CXX/expr/expr.unary/expr.new/p2-cxx0x.cpp -std=c++11
    RUN("%clang_cc1 -fsyntax-only -verify %s -std=c++11");
  }

  @Test
  public void test_expr_prim_lambda_p2_generic_lambda_1y_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CXX/expr/expr.prim/expr.prim.lambda/p2-generic-lambda-1y.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/CXX/expr/expr.prim/expr.prim.lambda/p2-generic-lambda-1y.cpp -std=c++1y -DCXX1Y
    RUN("%clang_cc1 -fsyntax-only -verify %s -std=c++1y -DCXX1Y");
  }

  @Test
  public void test_expr_prim_lambda_p20_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CXX/expr/expr.prim/expr.prim.lambda/p20.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c++11 ${LLVM_SRC}/llvm/tools/clang/test/CXX/expr/expr.prim/expr.prim.lambda/p20.cpp -Wunused -verify
    RUN("%clang_cc1 -std=c++11 %s -Wunused -verify");
  }

  @Test
  public void test_expr_new_p20_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CXX/expr/expr.unary/expr.new/p20.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -fexceptions ${LLVM_SRC}/llvm/tools/clang/test/CXX/expr/expr.unary/expr.new/p20.cpp
    RUN("%clang_cc1 -fsyntax-only -verify -fexceptions %s");
  }

  @Test
  public void test_expr_new_p20_0x_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CXX/expr/expr.unary/expr.new/p20-0x.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -std=c++11 -fexceptions ${LLVM_SRC}/llvm/tools/clang/test/CXX/expr/expr.unary/expr.new/p20-0x.cpp
    RUN("%clang_cc1 -fsyntax-only -verify -std=c++11 -fexceptions %s");
  }

  @Test
  public void test_expr_prim_lambda_p21_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CXX/expr/expr.prim/expr.prim.lambda/p21.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -std=c++11 ${LLVM_SRC}/llvm/tools/clang/test/CXX/expr/expr.prim/expr.prim.lambda/p21.cpp -verify
    RUN("%clang_cc1 -fsyntax-only -std=c++11 %s -verify");
  }

  @Test
  public void test_expr_prim_lambda_p23_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CXX/expr/expr.prim/expr.prim.lambda/p23.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -std=c++11 ${LLVM_SRC}/llvm/tools/clang/test/CXX/expr/expr.prim/expr.prim.lambda/p23.cpp -verify -Wno-c++1y-extensions
    RUN("%clang_cc1 -fsyntax-only -std=c++11 %s -verify -Wno-c++1y-extensions");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -std=c++1y ${LLVM_SRC}/llvm/tools/clang/test/CXX/expr/expr.prim/expr.prim.lambda/p23.cpp -verify
    RUN("%clang_cc1 -fsyntax-only -std=c++1y %s -verify");
  }

  @Test
  public void test_expr_ref_p3_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CXX/expr/expr.post/expr.ref/p3.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -verify -fsyntax-only ${LLVM_SRC}/llvm/tools/clang/test/CXX/expr/expr.post/expr.ref/p3.cpp
    RUN("%clang_cc1 -verify -fsyntax-only %s");
  }

  @Test
  public void test_expr_prim_lambda_p3_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CXX/expr/expr.prim/expr.prim.lambda/p3.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -std=c++11 ${LLVM_SRC}/llvm/tools/clang/test/CXX/expr/expr.prim/expr.prim.lambda/p3.cpp -verify
    RUN("%clang_cc1 -fsyntax-only -std=c++11 %s -verify");
  }

  @Test
  public void test_expr_unary_op_p3_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CXX/expr/expr.unary/expr.unary.op/p3.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only ${LLVM_SRC}/llvm/tools/clang/test/CXX/expr/expr.unary/expr.unary.op/p3.cpp -verify
    RUN("%clang_cc1 -fsyntax-only %s -verify");
  }

  @Test
  public void test_expr_p3_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CXX/expr/p3.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/CXX/expr/p3.cpp
    RUN("%clang_cc1 -fsyntax-only -verify %s");
  }

  @Test
  public void test_expr_const_p3_0x_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CXX/expr/expr.const/p3-0x.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -std=c++11 -verify ${LLVM_SRC}/llvm/tools/clang/test/CXX/expr/expr.const/p3-0x.cpp
    RUN("%clang_cc1 -fsyntax-only -std=c++11 -verify %s");
  }

  @Test
  public void test_expr_dynamic_cast_p3_0x_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CXX/expr/expr.post/expr.dynamic.cast/p3-0x.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c++11 -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/CXX/expr/expr.post/expr.dynamic.cast/p3-0x.cpp
    RUN("%clang_cc1 -std=c++11 -fsyntax-only -verify %s");
  }

  @Test
  public void test_expr_static_cast_p3_0x_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CXX/expr/expr.post/expr.static.cast/p3-0x.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c++11 -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/CXX/expr/expr.post/expr.static.cast/p3-0x.cpp
    RUN("%clang_cc1 -std=c++11 -fsyntax-only -verify %s");
  }

  @Test
  public void test_expr_prim_general_p3_0x_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CXX/expr/expr.prim/expr.prim.general/p3-0x.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -std=c++11 ${LLVM_SRC}/llvm/tools/clang/test/CXX/expr/expr.prim/expr.prim.general/p3-0x.cpp -verify
    RUN("%clang_cc1 -fsyntax-only -std=c++11 %s -verify");
  }

  @Test
  public void test_expr_const_p3_0x_nowarn_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CXX/expr/expr.const/p3-0x-nowarn.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -std=c++11 -Wno-c++11-narrowing -verify ${LLVM_SRC}/llvm/tools/clang/test/CXX/expr/expr.const/p3-0x-nowarn.cpp
    RUN("%clang_cc1 -fsyntax-only -std=c++11 -Wno-c++11-narrowing -verify %s");
  }

  @Test
  public void test_expr_cast_p4_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CXX/expr/expr.cast/p4.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -ast-dump ${LLVM_SRC}/llvm/tools/clang/test/CXX/expr/expr.cast/p4.cpp | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CXX/expr/expr.cast/p4.cpp
    RUN("%clang_cc1 -ast-dump %s")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_expr_prim_lambda_p4_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CXX/expr/expr.prim/expr.prim.lambda/p4.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -std=c++11 ${LLVM_SRC}/llvm/tools/clang/test/CXX/expr/expr.prim/expr.prim.lambda/p4.cpp -verify
    RUN("%clang_cc1 -fsyntax-only -std=c++11 %s -verify");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -std=c++1y ${LLVM_SRC}/llvm/tools/clang/test/CXX/expr/expr.prim/expr.prim.lambda/p4.cpp -verify -DCPP1Y
    RUN("%clang_cc1 -fsyntax-only -std=c++1y %s -verify -DCPP1Y");
  }

  @Test
  public void test_expr_prim_lambda_p4_mm() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CXX/expr/expr.prim/expr.prim.lambda/p4.mm");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -std=c++11 ${LLVM_SRC}/llvm/tools/clang/test/CXX/expr/expr.prim/expr.prim.lambda/p4.mm -verify
    RUN("%clang_cc1 -fsyntax-only -std=c++11 %s -verify");
  }

  @Test
  public void test_expr_unary_op_p4_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CXX/expr/expr.unary/expr.unary.op/p4.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/CXX/expr/expr.unary/expr.unary.op/p4.cpp
    RUN("%clang_cc1 -fsyntax-only -verify %s");
  }

  @Test
  public void test_expr_cast_p4_0x_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CXX/expr/expr.cast/p4-0x.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c++11 -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/CXX/expr/expr.cast/p4-0x.cpp
    RUN("%clang_cc1 -std=c++11 -fsyntax-only -verify %s");
  }

  @Test
  public void test_expr_prim_general_p4_0x_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CXX/expr/expr.prim/expr.prim.general/p4-0x.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -std=c++11 ${LLVM_SRC}/llvm/tools/clang/test/CXX/expr/expr.prim/expr.prim.general/p4-0x.cpp
    RUN("%clang_cc1 -fsyntax-only -verify -std=c++11 %s");
  }

  @Test
  public void test_expr_prim_lambda_p4_1y_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CXX/expr/expr.prim/expr.prim.lambda/p4-1y.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -std=c++1y ${LLVM_SRC}/llvm/tools/clang/test/CXX/expr/expr.prim/expr.prim.lambda/p4-1y.cpp -verify
    RUN("%clang_cc1 -fsyntax-only -std=c++1y %s -verify");
  }

  @Test
  public void test_expr_mptr_oper_p5_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CXX/expr/expr.mptr.oper/p5.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/CXX/expr/expr.mptr.oper/p5.cpp
    RUN("%clang_cc1 -fsyntax-only -verify %s");
  }

  @Test
  public void test_expr_prim_lambda_p5_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CXX/expr/expr.prim/expr.prim.lambda/p5.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c++11 ${LLVM_SRC}/llvm/tools/clang/test/CXX/expr/expr.prim/expr.prim.lambda/p5.cpp -Winvalid-noreturn -verify
    RUN("%clang_cc1 -std=c++11 %s -Winvalid-noreturn -verify");
  }

  @Test
  public void test_expr_delete_p5_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CXX/expr/expr.unary/expr.delete/p5.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -verify ${LLVM_SRC}/llvm/tools/clang/test/CXX/expr/expr.unary/expr.delete/p5.cpp
    RUN("%clang_cc1 -verify %s");
  }

  @Test
  public void test_expr_const_p5_0x_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CXX/expr/expr.const/p5-0x.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i386-pc-solaris2.11 -fsyntax-only -std=c++11 -verify ${LLVM_SRC}/llvm/tools/clang/test/CXX/expr/expr.const/p5-0x.cpp
    RUN("%clang_cc1 -triple %itanium_abi_triple -fsyntax-only -std=c++11 -verify %s");
  }

  @Test
  public void test_expr_sizeof_p5_0x_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CXX/expr/expr.unary/expr.sizeof/p5-0x.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c++11 -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/CXX/expr/expr.unary/expr.sizeof/p5-0x.cpp
    RUN("%clang_cc1 -std=c++11 -fsyntax-only -verify %s");
  }

  @Test
  public void test_expr_prim_lambda_p5_generic_lambda_1y_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CXX/expr/expr.prim/expr.prim.lambda/p5-generic-lambda-1y.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/CXX/expr/expr.prim/expr.prim.lambda/p5-generic-lambda-1y.cpp -std=c++1y -DCXX1Y
    RUN("%clang_cc1 -fsyntax-only -verify %s -std=c++1y -DCXX1Y");
  }

  @Test
  public void test_expr_prim_lambda_p6_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CXX/expr/expr.prim/expr.prim.lambda/p6.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -std=c++11 ${LLVM_SRC}/llvm/tools/clang/test/CXX/expr/expr.prim/expr.prim.lambda/p6.cpp -verify
    RUN("%clang_cc1 -fsyntax-only -std=c++11 %s -verify");
  }

  @Test
  public void test_expr_unary_op_p6_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CXX/expr/expr.unary/expr.unary.op/p6.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/CXX/expr/expr.unary/expr.unary.op/p6.cpp
    RUN("%clang_cc1 -fsyntax-only -verify %s");
  }

  @Test
  public void test_expr_mptr_oper_p6_0x_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CXX/expr/expr.mptr.oper/p6-0x.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c++11 -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/CXX/expr/expr.mptr.oper/p6-0x.cpp
    RUN("%clang_cc1 -std=c++11 -fsyntax-only -verify %s");
  }

  @Test
  public void test_expr_prim_lambda_p7_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CXX/expr/expr.prim/expr.prim.lambda/p7.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -std=c++11 ${LLVM_SRC}/llvm/tools/clang/test/CXX/expr/expr.prim/expr.prim.lambda/p7.cpp -verify
    RUN("%clang_cc1 -fsyntax-only -std=c++11 %s -verify");
  }

  @Test
  public void test_expr_call_p7_0x_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CXX/expr/expr.post/expr.call/p7-0x.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -std=c++11 ${LLVM_SRC}/llvm/tools/clang/test/CXX/expr/expr.post/expr.call/p7-0x.cpp
    RUN(TestState.Failed, "%clang_cc1 -fsyntax-only -verify -std=c++11 %s");
  }

  @Test
  public void test_expr_prim_lambda_p8_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CXX/expr/expr.prim/expr.prim.lambda/p8.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c++11 ${LLVM_SRC}/llvm/tools/clang/test/CXX/expr/expr.prim/expr.prim.lambda/p8.cpp -verify -Wno-c++1y-extensions
    RUN("%clang_cc1 -std=c++11 %s -verify -Wno-c++1y-extensions");
  }

  @Test
  public void test_expr_p8_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CXX/expr/p8.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/CXX/expr/p8.cpp
    RUN("%clang_cc1 -fsyntax-only -verify %s");
  }

  @Test
  public void test_expr_prim_general_p8_0x_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CXX/expr/expr.prim/expr.prim.general/p8-0x.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -std=c++11 ${LLVM_SRC}/llvm/tools/clang/test/CXX/expr/expr.prim/expr.prim.general/p8-0x.cpp
    RUN("%clang_cc1 -fsyntax-only -verify -std=c++11 %s");
  }

  @Test
  public void test_expr_p9_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CXX/expr/p9.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/CXX/expr/p9.cpp
    RUN("%clang_cc1 -fsyntax-only -verify %s");
  }

  @Test
  public void test_expr_static_cast_p9_0x_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CXX/expr/expr.post/expr.static.cast/p9-0x.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c++11 -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/CXX/expr/expr.post/expr.static.cast/p9-0x.cpp
    RUN("%clang_cc1 -std=c++11 -fsyntax-only -verify %s");
  }

  @Test
  public void test_expr_ass_p9_cxx11_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CXX/expr/expr.ass/p9-cxx11.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -verify -std=c++11 ${LLVM_SRC}/llvm/tools/clang/test/CXX/expr/expr.ass/p9-cxx11.cpp
    RUN("%clang_cc1 -verify -std=c++11 %s");
  }

  @Test
  public void test_expr_unary_noexcept_sema_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CXX/expr/expr.unary/expr.unary.noexcept/sema.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fcxx-exceptions -fexceptions -fsyntax-only -verify -std=c++11 -fms-extensions -Wno-delete-incomplete -Wno-unused-value ${LLVM_SRC}/llvm/tools/clang/test/CXX/expr/expr.unary/expr.unary.noexcept/sema.cpp
    RUN("%clang_cc1 -fcxx-exceptions -fexceptions -fsyntax-only -verify -std=c++11 -fms-extensions -Wno-delete-incomplete -Wno-unused-value %s");
  }

  @Test
  public void test_expr_prim_lambda_templates_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CXX/expr/expr.prim/expr.prim.lambda/templates.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -std=c++11 -Winvalid-noreturn ${LLVM_SRC}/llvm/tools/clang/test/CXX/expr/expr.prim/expr.prim.lambda/templates.cpp -verify
    RUN("%clang_cc1 -fsyntax-only -std=c++11 -Winvalid-noreturn %s -verify");
  }
  
}
