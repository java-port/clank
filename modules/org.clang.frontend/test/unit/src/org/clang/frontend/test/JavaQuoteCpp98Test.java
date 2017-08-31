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

package org.clang.frontend.test;

import org.clang.tools.driver.test.DriverTestFileBase;
import org.clank.support.NativeTrace;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author vv159170
 */
public class JavaQuoteCpp98Test extends DriverTestFileBase {

  private static final String TEST_LOCATION = "${SPUTNIK}/modules/org.clang.frontend/test/unit/data/org/clang/frontend/test/QuoteCpp98";
  private static final boolean checkAST = true;
  private static final boolean checkCFG = true;
  private static final boolean diffCFG = checkAST && checkCFG;

  public JavaQuoteCpp98Test() {
    super(TEST_LOCATION, TestState.Successful);
  }

  @BeforeClass
  public static void startUpClass() {
    // set to false to prevent collections stacks: it slows down significantly
    // When test fails comment line to investigate problem
    System.setProperty(NativeTrace.CHECK_STD_ACCESS_DESTROYED_PROP, "false");
  }  
  
  public static void main(String[] args) {
    // Print tests which will be accepted per test case
    DriverTestFileBase.printAllTestFiles(false, TEST_LOCATION, (test) -> true,
            "${SPUTNIK}/modules/org.clang.frontend/test/unit/src/org/clang/frontend/test/JavaQuoteCpp98Test.txt");
  }

  @Override
  protected boolean keepStacksForUnimplementedMethods() {
    return false;
  }

  @Test
  public void test_QuoteCpuCC98Test_cpp() throws Throwable {
    setTestFile("${SPUTNIK}/modules/org.clang.frontend/test/unit/data/org/clang/frontend/test/QuoteCpp98/QuoteCpuCC98Test.cpp");
    if (checkAST) {
      // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-unknown-linux-gnu -fsyntax-only '-std=c++98' -verify ${SPUTNIK}/modules/org.clang.frontend/test/unit/data/org/clang/frontend/test/QuoteCpp98/QuoteCpuCC98Test.cpp
      RUN("%clang_cc1 -triple x86_64-unknown-linux-gnu -fsyntax-only -std=c++98 -verify %s");
    }
    if (checkCFG) {
      // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-unknown-linux-gnu '-std=c++98' -analyze '-analyzer-checker=debug.DumpCFG' ${SPUTNIK}/modules/org.clang.frontend/test/unit/data/org/clang/frontend/test/QuoteCpp98/QuoteCpuCC98Test.cpp 2>&1 > ${TEST_TEMP_DIR}/QuoteCpuCC98Test.cpp.cfg
      RUN("%clang_cc1 -triple x86_64-unknown-linux-gnu -std=c++98 -analyze -analyzer-checker=debug.DumpCFG %s 2>&1 > %T/QuoteCpuCC98Test.cpp.cfg");
    }
    if (diffCFG) {
      // diff ${TEST_TEMP_DIR}/QuoteCpuCC98Test.cpp.cfg ${SPUTNIK}/modules/org.clang.frontend/test/unit/data/org/clang/frontend/test/QuoteCpp98/Input/QuoteCpuCC98Test.cpp.cfg > ${TEST_TEMP_DIR}/QuoteCpuCC98Test.cpp.cfg.diff
      RUN("diff %T/QuoteCpuCC98Test.cpp.cfg %S/Input/QuoteCpuCC98Test.cpp.cfg > %T/QuoteCpuCC98Test.cpp.cfg.diff");
    }
  }

  @Test
  public void test_QuoteCustomerCC98Test_cpp() throws Throwable {
    setTestFile("${SPUTNIK}/modules/org.clang.frontend/test/unit/data/org/clang/frontend/test/QuoteCpp98/QuoteCustomerCC98Test.cpp");
    if (checkAST) {
      // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-unknown-linux-gnu -fsyntax-only '-std=c++98' -verify ${SPUTNIK}/modules/org.clang.frontend/test/unit/data/org/clang/frontend/test/QuoteCpp98/QuoteCustomerCC98Test.cpp
      RUN("%clang_cc1 -triple x86_64-unknown-linux-gnu -fsyntax-only -std=c++98 -verify %s");
    }
    if (checkCFG) {
      // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-unknown-linux-gnu '-std=c++98' -analyze '-analyzer-checker=debug.DumpCFG' ${SPUTNIK}/modules/org.clang.frontend/test/unit/data/org/clang/frontend/test/QuoteCpp98/QuoteCustomerCC98Test.cpp 2>&1 > ${TEST_TEMP_DIR}/QuoteCustomerCC98Test.cpp.cfg
      RUN("%clang_cc1 -triple x86_64-unknown-linux-gnu -std=c++98 -analyze -analyzer-checker=debug.DumpCFG %s 2>&1 > %T/QuoteCustomerCC98Test.cpp.cfg");
    }
    if (diffCFG) {
      // diff ${TEST_TEMP_DIR}/QuoteCustomerCC98Test.cpp.cfg ${SPUTNIK}/modules/org.clang.frontend/test/unit/data/org/clang/frontend/test/QuoteCpp98/Input/QuoteCustomerCC98Test.cpp.cfg > ${TEST_TEMP_DIR}/QuoteCustomerCC98Test.cpp.cfg.diff
      RUN("diff %T/QuoteCustomerCC98Test.cpp.cfg %S/Input/QuoteCustomerCC98Test.cpp.cfg > %T/QuoteCustomerCC98Test.cpp.cfg.diff");
    }
  }

  @Test
  public void test_QuoteDiskCC98Test_cpp() throws Throwable {
    setTestFile("${SPUTNIK}/modules/org.clang.frontend/test/unit/data/org/clang/frontend/test/QuoteCpp98/QuoteDiskCC98Test.cpp");
    if (checkAST) {
      // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-unknown-linux-gnu -fsyntax-only '-std=c++98' -verify ${SPUTNIK}/modules/org.clang.frontend/test/unit/data/org/clang/frontend/test/QuoteCpp98/QuoteDiskCC98Test.cpp
      RUN("%clang_cc1 -triple x86_64-unknown-linux-gnu -fsyntax-only -std=c++98 -verify %s");
    }
    if (checkCFG) {
      // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-unknown-linux-gnu '-std=c++98' -analyze '-analyzer-checker=debug.DumpCFG' ${SPUTNIK}/modules/org.clang.frontend/test/unit/data/org/clang/frontend/test/QuoteCpp98/QuoteDiskCC98Test.cpp 2>&1 > ${TEST_TEMP_DIR}/QuoteDiskCC98Test.cpp.cfg
      RUN("%clang_cc1 -triple x86_64-unknown-linux-gnu -std=c++98 -analyze -analyzer-checker=debug.DumpCFG %s 2>&1 > %T/QuoteDiskCC98Test.cpp.cfg");
    }
    if (diffCFG) {
      // diff ${TEST_TEMP_DIR}/QuoteDiskCC98Test.cpp.cfg ${SPUTNIK}/modules/org.clang.frontend/test/unit/data/org/clang/frontend/test/QuoteCpp98/Input/QuoteDiskCC98Test.cpp.cfg > ${TEST_TEMP_DIR}/QuoteDiskCC98Test.cpp.cfg.diff
      RUN("diff %T/QuoteDiskCC98Test.cpp.cfg %S/Input/QuoteDiskCC98Test.cpp.cfg > %T/QuoteDiskCC98Test.cpp.cfg.diff");
    }
  }

  @Test
  public void test_QuoteMemoryCC98Test_cpp() throws Throwable {
    setTestFile("${SPUTNIK}/modules/org.clang.frontend/test/unit/data/org/clang/frontend/test/QuoteCpp98/QuoteMemoryCC98Test.cpp");
    if (checkAST) {
      // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-unknown-linux-gnu -fsyntax-only '-std=c++98' -verify ${SPUTNIK}/modules/org.clang.frontend/test/unit/data/org/clang/frontend/test/QuoteCpp98/QuoteMemoryCC98Test.cpp
      RUN("%clang_cc1 -triple x86_64-unknown-linux-gnu -fsyntax-only -std=c++98 -verify %s");
    }
    if (checkCFG) {
      // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-unknown-linux-gnu '-std=c++98' -analyze '-analyzer-checker=debug.DumpCFG' ${SPUTNIK}/modules/org.clang.frontend/test/unit/data/org/clang/frontend/test/QuoteCpp98/QuoteMemoryCC98Test.cpp 2>&1 > ${TEST_TEMP_DIR}/QuoteMemoryCC98Test.cpp.cfg
      RUN("%clang_cc1 -triple x86_64-unknown-linux-gnu -std=c++98 -analyze -analyzer-checker=debug.DumpCFG %s 2>&1 > %T/QuoteMemoryCC98Test.cpp.cfg");
    }
    if (diffCFG) {
      // diff ${TEST_TEMP_DIR}/QuoteMemoryCC98Test.cpp.cfg ${SPUTNIK}/modules/org.clang.frontend/test/unit/data/org/clang/frontend/test/QuoteCpp98/Input/QuoteMemoryCC98Test.cpp.cfg > ${TEST_TEMP_DIR}/QuoteMemoryCC98Test.cpp.cfg.diff
      RUN("diff %T/QuoteMemoryCC98Test.cpp.cfg %S/Input/QuoteMemoryCC98Test.cpp.cfg > %T/QuoteMemoryCC98Test.cpp.cfg.diff");
    }
  }

  @Test
  public void test_QuoteModuleCC98Test_cpp() throws Throwable {
    setTestFile("${SPUTNIK}/modules/org.clang.frontend/test/unit/data/org/clang/frontend/test/QuoteCpp98/QuoteModuleCC98Test.cpp");
    if (checkAST) {
      // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-unknown-linux-gnu -fsyntax-only '-std=c++98' -verify ${SPUTNIK}/modules/org.clang.frontend/test/unit/data/org/clang/frontend/test/QuoteCpp98/QuoteModuleCC98Test.cpp
      RUN("%clang_cc1 -triple x86_64-unknown-linux-gnu -fsyntax-only -std=c++98 -verify %s");
    }
    if (checkCFG) {
      // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-unknown-linux-gnu '-std=c++98' -analyze '-analyzer-checker=debug.DumpCFG' ${SPUTNIK}/modules/org.clang.frontend/test/unit/data/org/clang/frontend/test/QuoteCpp98/QuoteModuleCC98Test.cpp 2>&1 > ${TEST_TEMP_DIR}/QuoteModuleCC98Test.cpp.cfg
      RUN("%clang_cc1 -triple x86_64-unknown-linux-gnu -std=c++98 -analyze -analyzer-checker=debug.DumpCFG %s 2>&1 > %T/QuoteModuleCC98Test.cpp.cfg");
    }
    if (diffCFG) {
      // diff ${TEST_TEMP_DIR}/QuoteModuleCC98Test.cpp.cfg ${SPUTNIK}/modules/org.clang.frontend/test/unit/data/org/clang/frontend/test/QuoteCpp98/Input/QuoteModuleCC98Test.cpp.cfg > ${TEST_TEMP_DIR}/QuoteModuleCC98Test.cpp.cfg.diff
      RUN("diff %T/QuoteModuleCC98Test.cpp.cfg %S/Input/QuoteModuleCC98Test.cpp.cfg > %T/QuoteModuleCC98Test.cpp.cfg.diff");
    }
  }

  @Test
  public void test_QuoteQuoteCC98Test_cpp() throws Throwable {
    setTestFile("${SPUTNIK}/modules/org.clang.frontend/test/unit/data/org/clang/frontend/test/QuoteCpp98/QuoteQuoteCC98Test.cpp");
    if (checkAST) {
      // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-unknown-linux-gnu -fsyntax-only '-std=c++98' -verify ${SPUTNIK}/modules/org.clang.frontend/test/unit/data/org/clang/frontend/test/QuoteCpp98/QuoteQuoteCC98Test.cpp
      RUN("%clang_cc1 -triple x86_64-unknown-linux-gnu -fsyntax-only -std=c++98 -verify %s");
    }
    if (checkCFG) {
      // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-unknown-linux-gnu '-std=c++98' -analyze '-analyzer-checker=debug.DumpCFG' ${SPUTNIK}/modules/org.clang.frontend/test/unit/data/org/clang/frontend/test/QuoteCpp98/QuoteQuoteCC98Test.cpp 2>&1 > ${TEST_TEMP_DIR}/QuoteQuoteCC98Test.cpp.cfg
      RUN("%clang_cc1 -triple x86_64-unknown-linux-gnu -std=c++98 -analyze -analyzer-checker=debug.DumpCFG %s 2>&1 > %T/QuoteQuoteCC98Test.cpp.cfg");
    }
    if (diffCFG) {
      // diff ${TEST_TEMP_DIR}/QuoteQuoteCC98Test.cpp.cfg ${SPUTNIK}/modules/org.clang.frontend/test/unit/data/org/clang/frontend/test/QuoteCpp98/Input/QuoteQuoteCC98Test.cpp.cfg > ${TEST_TEMP_DIR}/QuoteQuoteCC98Test.cpp.cfg.diff
      RUN("diff %T/QuoteQuoteCC98Test.cpp.cfg %S/Input/QuoteQuoteCC98Test.cpp.cfg > %T/QuoteQuoteCC98Test.cpp.cfg.diff");
    }
  }

  @Test
  public void test_QuoteSystemCC98Test_cpp() throws Throwable {
    setTestFile("${SPUTNIK}/modules/org.clang.frontend/test/unit/data/org/clang/frontend/test/QuoteCpp98/QuoteSystemCC98Test.cpp");
    if (checkAST) {
      // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-unknown-linux-gnu -fsyntax-only '-std=c++98' -verify ${SPUTNIK}/modules/org.clang.frontend/test/unit/data/org/clang/frontend/test/QuoteCpp98/QuoteSystemCC98Test.cpp
      RUN("%clang_cc1 -triple x86_64-unknown-linux-gnu -fsyntax-only -std=c++98 -verify %s");
    }
    if (checkCFG) {
      // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-unknown-linux-gnu '-std=c++98' -analyze '-analyzer-checker=debug.DumpCFG' ${SPUTNIK}/modules/org.clang.frontend/test/unit/data/org/clang/frontend/test/QuoteCpp98/QuoteSystemCC98Test.cpp 2>&1 > ${TEST_TEMP_DIR}/QuoteSystemCC98Test.cpp.cfg
      RUN("%clang_cc1 -triple x86_64-unknown-linux-gnu -std=c++98 -analyze -analyzer-checker=debug.DumpCFG %s 2>&1 > %T/QuoteSystemCC98Test.cpp.cfg");
    }
    if (diffCFG) {
      // diff ${TEST_TEMP_DIR}/QuoteSystemCC98Test.cpp.cfg ${SPUTNIK}/modules/org.clang.frontend/test/unit/data/org/clang/frontend/test/QuoteCpp98/Input/QuoteSystemCC98Test.cpp.cfg > ${TEST_TEMP_DIR}/QuoteSystemCC98Test.cpp.cfg.diff
      RUN("diff %T/QuoteSystemCC98Test.cpp.cfg %S/Input/QuoteSystemCC98Test.cpp.cfg > %T/QuoteSystemCC98Test.cpp.cfg.diff");
    }
  }
}
