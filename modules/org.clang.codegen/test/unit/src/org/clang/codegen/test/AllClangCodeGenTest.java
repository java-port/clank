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
package org.clang.codegen.test;

import org.clang.tools.driver.test.DriverTestFileBase;
import org.junit.*;

/**
 * Collection of all test files from test/CodeGen folder
 * @author Vladimir Voskresensky
 */
@Ignore
public class AllClangCodeGenTest extends DriverTestFileBase {
  private static final String TEST_LOCATION = "${LLVM_SRC}/llvm/tools/clang/test/CodeGen/";
  public AllClangCodeGenTest() {
    super(TEST_LOCATION, TestState.Successful);
  }
  
  public static void main(String[] args) {
    // Print tests which will be accepted per test case
    DriverTestFileBase.printAllTestFiles(false, TEST_LOCATION, (test)->{ return true;/*test.getFileIndexInFolder()<120;*/ }, 
            "${SPUTNIK}/modules/org.clang.codegen/test/unit/src/org/clang/codegen/test/AllClangCodeGenTest.txt");
  }  

  @Override
  protected boolean keepStacksForUnimplementedMethods() {
    return false;
  }
  
  @Test
  public void test_2002_01_23_LoadQISIReloadFailure_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2002-01-23-LoadQISIReloadFailure.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2002-01-23-LoadQISIReloadFailure.c -o /dev/null
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm %s  -o /dev/null");
  }

  @Test
  public void test_2002_01_24_ComplexSpaceInType_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2002-01-24-ComplexSpaceInType.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2002-01-24-ComplexSpaceInType.c -o /dev/null
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm %s  -o /dev/null");
  }

  @Test
  public void test_2002_01_24_HandleCallInsnSEGV_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2002-01-24-HandleCallInsnSEGV.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2002-01-24-HandleCallInsnSEGV.c -o /dev/null
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm %s  -o /dev/null");
  }

  @Test
  public void test_2002_02_13_ConditionalInCall_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2002-02-13-ConditionalInCall.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2002-02-13-ConditionalInCall.c -o /dev/null
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm %s  -o /dev/null");
  }

  @Test
  public void test_2002_02_13_ReloadProblem_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2002-02-13-ReloadProblem.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2002-02-13-ReloadProblem.c -o /dev/null
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm %s  -o /dev/null");
  }

  @Test
  public void test_2002_02_13_TypeVarNameCollision_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2002-02-13-TypeVarNameCollision.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2002-02-13-TypeVarNameCollision.c -o /dev/null
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm %s  -o /dev/null");
  }

  @Test
  public void test_2002_02_13_UnnamedLocal_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2002-02-13-UnnamedLocal.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2002-02-13-UnnamedLocal.c -o /dev/null
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm %s  -o /dev/null");
  }

  @Test
  public void test_2002_02_14_EntryNodePreds_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2002-02-14-EntryNodePreds.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2002-02-14-EntryNodePreds.c -o /dev/null
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm %s  -o /dev/null");
  }

  @Test
  public void test_2002_02_16_RenamingTest_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2002-02-16-RenamingTest.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2002-02-16-RenamingTest.c -o /dev/null
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm %s  -o /dev/null");
  }

  @Test
  public void test_2002_02_17_ArgumentAddress_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2002-02-17-ArgumentAddress.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2002-02-17-ArgumentAddress.c -o /dev/null
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm %s  -o /dev/null");
  }

  @Test
  public void test_2002_02_18_64bitConstant_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2002-02-18-64bitConstant.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2002-02-18-64bitConstant.c -o /dev/null
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm %s  -o /dev/null");
  }

  @Test
  public void test_2002_02_18_StaticData_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2002-02-18-StaticData.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2002-02-18-StaticData.c -o /dev/null
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm %s  -o /dev/null");
  }

  @Test
  public void test_2002_03_11_LargeCharInString_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2002-03-11-LargeCharInString.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2002-03-11-LargeCharInString.c -o /dev/null
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm %s  -o /dev/null");
  }

  @Test
  public void test_2002_03_12_ArrayInitialization_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2002-03-12-ArrayInitialization.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2002-03-12-ArrayInitialization.c -o /dev/null
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm %s  -o /dev/null");
  }

  @Test
  public void test_2002_03_12_StructInitialize_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2002-03-12-StructInitialize.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2002-03-12-StructInitialize.c -o /dev/null
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm %s  -o /dev/null");
  }

  @Test
  public void test_2002_03_12_StructInitializer_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2002-03-12-StructInitializer.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2002-03-12-StructInitializer.c -o /dev/null
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm %s  -o /dev/null");
  }

  @Test
  public void test_2002_03_14_BrokenPHINode_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2002-03-14-BrokenPHINode.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2002-03-14-BrokenPHINode.c -o /dev/null
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm %s  -o /dev/null");
  }

  @Test
  public void test_2002_03_14_BrokenSSA_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2002-03-14-BrokenSSA.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2002-03-14-BrokenSSA.c -o /dev/null
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm %s  -o /dev/null");
  }

  @Test
  public void test_2002_03_14_QuotesInStrConst_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2002-03-14-QuotesInStrConst.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2002-03-14-QuotesInStrConst.c -o /dev/null
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm %s  -o /dev/null");
  }

  @Test
  public void test_2002_04_07_SwitchStmt_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2002-04-07-SwitchStmt.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2002-04-07-SwitchStmt.c -o /dev/null
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm %s  -o /dev/null");
  }

  @Test
  public void test_2002_04_08_LocalArray_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2002-04-08-LocalArray.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2002-04-08-LocalArray.c -o /dev/null
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm %s  -o /dev/null");
  }

  @Test
  public void test_2002_04_09_StructRetVal_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2002-04-09-StructRetVal.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2002-04-09-StructRetVal.c -o /dev/null
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm %s  -o /dev/null");
  }

  @Test
  public void test_2002_04_10_StructParameters_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2002-04-10-StructParameters.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2002-04-10-StructParameters.c -o /dev/null
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm %s  -o /dev/null");
  }

  @Test
  public void test_2002_05_23_StaticValues_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2002-05-23-StaticValues.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2002-05-23-StaticValues.c -o /dev/null
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm %s  -o /dev/null");
  }

  @Test
  public void test_2002_05_23_TypeNameCollision_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2002-05-23-TypeNameCollision.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2002-05-23-TypeNameCollision.c -o /dev/null
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm %s  -o /dev/null");
  }

  @Test
  public void test_2002_06_25_FWriteInterfaceFailure_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2002-06-25-FWriteInterfaceFailure.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2002-06-25-FWriteInterfaceFailure.c -o /dev/null
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm %s  -o /dev/null");
  }

  @Test
  public void test_2002_07_14_MiscListTests_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2002-07-14-MiscListTests.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2002-07-14-MiscListTests.c -o /dev/null
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm %s  -o /dev/null");
  }

  @Test
  public void test_2002_07_14_MiscTests_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2002-07-14-MiscTests.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -w -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2002-07-14-MiscTests.c -o /dev/null
    RUN(TestState.Failed, "%clang_cc1 -w -emit-llvm %s  -o /dev/null");
  }

  @Test
  public void test_2002_07_14_MiscTests2_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2002-07-14-MiscTests2.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2002-07-14-MiscTests2.c -o /dev/null
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm %s  -o /dev/null");
  }

  @Test
  public void test_2002_07_14_MiscTests3_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2002-07-14-MiscTests3.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -w -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2002-07-14-MiscTests3.c -o /dev/null
    RUN(TestState.Failed, "%clang_cc1 -w -emit-llvm %s  -o /dev/null");
  }

  @Test
  public void test_2002_07_16_HardStringInit_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2002-07-16-HardStringInit.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2002-07-16-HardStringInit.c -o /dev/null
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm %s  -o /dev/null");
  }

  @Test
  public void test_2002_07_17_StringConstant_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2002-07-17-StringConstant.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2002-07-17-StringConstant.c -o /dev/null
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm %s  -o /dev/null");
  }

  @Test
  public void test_2002_07_30_SubregSetAssertion_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2002-07-30-SubregSetAssertion.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2002-07-30-SubregSetAssertion.c -o /dev/null
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm %s  -o /dev/null");
  }

  @Test
  public void test_2002_07_30_UnionTest_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2002-07-30-UnionTest.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2002-07-30-UnionTest.c -o /dev/null
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm %s  -o /dev/null");
  }

  @Test
  public void test_2002_07_30_VarArgsCallFailure_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2002-07-30-VarArgsCallFailure.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2002-07-30-VarArgsCallFailure.c -o /dev/null
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm %s  -o /dev/null");
  }

  @Test
  public void test_2002_07_31_BadAssert_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2002-07-31-BadAssert.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2002-07-31-BadAssert.c -o /dev/null
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm %s  -o /dev/null");
  }

  @Test
  public void test_2002_07_31_SubregFailure_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2002-07-31-SubregFailure.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2002-07-31-SubregFailure.c -o /dev/null
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm %s  -o /dev/null");
  }

  @Test
  public void test_2002_08_02_UnionTest_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2002-08-02-UnionTest.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2002-08-02-UnionTest.c -o /dev/null
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm %s  -o /dev/null");
  }

  @Test
  public void test_2002_08_19_RecursiveLocals_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2002-08-19-RecursiveLocals.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2002-08-19-RecursiveLocals.c -o /dev/null
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm %s  -o /dev/null");
  }

  @Test
  public void test_2002_09_08_PointerShifts_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2002-09-08-PointerShifts.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2002-09-08-PointerShifts.c -o /dev/null
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm %s  -o /dev/null");
  }

  @Test
  public void test_2002_09_18_UnionProblem_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2002-09-18-UnionProblem.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2002-09-18-UnionProblem.c -o /dev/null
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm %s  -o /dev/null");
  }

  @Test
  public void test_2002_09_19_StarInLabel_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2002-09-19-StarInLabel.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2002-09-19-StarInLabel.c -o /dev/null
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm %s  -o /dev/null");
  }

  @Test
  public void test_2002_10_12_TooManyArguments_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2002-10-12-TooManyArguments.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2002-10-12-TooManyArguments.c -o /dev/null
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm %s  -o /dev/null");
  }

  @Test
  public void test_2002_12_15_GlobalBoolTest_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2002-12-15-GlobalBoolTest.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2002-12-15-GlobalBoolTest.c -o /dev/null
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm %s  -o /dev/null");
  }

  @Test
  public void test_2002_12_15_GlobalConstantTest_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2002-12-15-GlobalConstantTest.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2002-12-15-GlobalConstantTest.c -o /dev/null
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm %s  -o /dev/null");
  }

  @Test
  public void test_2002_12_15_GlobalRedefinition_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2002-12-15-GlobalRedefinition.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2002-12-15-GlobalRedefinition.c -o /dev/null
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm %s  -o /dev/null");
  }

  @Test
  public void test_2002_12_15_StructParameters_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2002-12-15-StructParameters.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2002-12-15-StructParameters.c -o /dev/null
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm %s  -o /dev/null");
  }

  @Test
  public void test_2003_01_30_UnionInit_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2003-01-30-UnionInit.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2003-01-30-UnionInit.c -o /dev/null
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm %s -o /dev/null");
  }

  @Test
  public void test_2003_03_03_DeferredType_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2003-03-03-DeferredType.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2003-03-03-DeferredType.c -o /dev/null
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm %s  -o /dev/null");
  }

  @Test
  public void test_2003_06_22_UnionCrash_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2003-06-22-UnionCrash.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2003-06-22-UnionCrash.c -o /dev/null
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm %s  -o /dev/null");
  }

  @Test
  public void test_2003_06_23_GCC_fold_infinite_recursion_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2003-06-23-GCC-fold-infinite-recursion.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2003-06-23-GCC-fold-infinite-recursion.c -o /dev/null
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm %s  -o /dev/null");
  }

  @Test
  public void test_2003_06_26_CFECrash_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2003-06-26-CFECrash.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2003-06-26-CFECrash.c -o /dev/null
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm %s  -o /dev/null");
  }

  @Test
  public void test_2003_06_29_MultipleFunctionDefinition_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2003-06-29-MultipleFunctionDefinition.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=gnu89 -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2003-06-29-MultipleFunctionDefinition.c -o /dev/null
    RUN(TestState.Failed, "%clang_cc1 -std=gnu89 -emit-llvm %s  -o /dev/null");
  }

  @Test
  public void test_2003_07_22_ArrayAccessTypeSafety_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2003-07-22-ArrayAccessTypeSafety.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2003-07-22-ArrayAccessTypeSafety.c -emit-llvm -o - | grep -v alloca | not grep bitcast
    RUN(TestState.Failed, "%clang_cc1  %s -emit-llvm -o -")./*|*/
      I("grep -v alloca")./*|*/
      I("not grep bitcast");
  }

  @Test
  public void test_2003_08_17_DeadCodeShortCircuit_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2003-08-17-DeadCodeShortCircuit.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x c ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2003-08-17-DeadCodeShortCircuit.c -emit-llvm -o /dev/null
    RUN(TestState.Failed, "%clang_cc1 -x c %s -emit-llvm -o /dev/null");
  }

  @Test
  public void test_2003_08_18_SigSetJmp_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2003-08-18-SigSetJmp.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-apple-darwin -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2003-08-18-SigSetJmp.c -o /dev/null
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-apple-darwin -emit-llvm %s  -o /dev/null");
  }

  @Test
  public void test_2003_08_18_StructAsValue_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2003-08-18-StructAsValue.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2003-08-18-StructAsValue.c -o /dev/null
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm %s  -o /dev/null");
  }

  @Test
  public void test_2003_08_20_BadBitfieldRef_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2003-08-20-BadBitfieldRef.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2003-08-20-BadBitfieldRef.c -o /dev/null
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm %s  -o /dev/null");
  }

  @Test
  public void test_2003_08_20_PrototypeMismatch_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2003-08-20-PrototypeMismatch.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2003-08-20-PrototypeMismatch.c -o /dev/null
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm %s  -o /dev/null");
  }

  @Test
  public void test_2003_08_20_vfork_bug_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2003-08-20-vfork-bug.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2003-08-20-vfork-bug.c -o /dev/null
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm %s  -o /dev/null");
  }

  @Test
  public void test_2003_08_21_BinOp_Type_Mismatch_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2003-08-21-BinOp-Type-Mismatch.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2003-08-21-BinOp-Type-Mismatch.c -o /dev/null
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm %s  -o /dev/null");
  }

  @Test
  public void test_2003_08_21_StmtExpr_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2003-08-21-StmtExpr.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2003-08-21-StmtExpr.c -o /dev/null
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm %s  -o /dev/null");
  }

  @Test
  public void test_2003_08_21_WideString_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2003-08-21-WideString.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2003-08-21-WideString.c -o /dev/null
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm %s  -o /dev/null");
  }

  @Test
  public void test_2003_08_23_LocalUnionTest_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2003-08-23-LocalUnionTest.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2003-08-23-LocalUnionTest.c -o /dev/null
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm %s  -o /dev/null");
  }

  @Test
  public void test_2003_08_29_BitFieldStruct_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2003-08-29-BitFieldStruct.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2003-08-29-BitFieldStruct.c -o /dev/null
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm %s  -o /dev/null");
  }

  @Test
  public void test_2003_08_29_HugeCharConst_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2003-08-29-HugeCharConst.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2003-08-29-HugeCharConst.c -o /dev/null
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm %s  -o /dev/null");
  }

  @Test
  public void test_2003_08_29_StructLayoutBug_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2003-08-29-StructLayoutBug.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2003-08-29-StructLayoutBug.c -o /dev/null
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm %s  -o /dev/null");
  }

  @Test
  public void test_2003_08_30_AggregateInitializer_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2003-08-30-AggregateInitializer.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2003-08-30-AggregateInitializer.c -o /dev/null
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm %s -o /dev/null");
  }

  @Test
  public void test_2003_08_30_LargeIntegerBitfieldMember_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2003-08-30-LargeIntegerBitfieldMember.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2003-08-30-LargeIntegerBitfieldMember.c -o /dev/null
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm %s  -o /dev/null");
  }

  @Test
  public void test_2003_09_18_BitfieldTests_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2003-09-18-BitfieldTests.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -w -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2003-09-18-BitfieldTests.c -o /dev/null
    RUN(TestState.Failed, "%clang_cc1 -w -emit-llvm %s  -o /dev/null");
  }

  @Test
  public void test_2003_09_30_StructLayout_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2003-09-30-StructLayout.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2003-09-30-StructLayout.c -o /dev/null
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm %s  -o /dev/null");
  }

  @Test
  public void test_2003_10_02_UnionLValueError_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2003-10-02-UnionLValueError.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2003-10-02-UnionLValueError.c -o /dev/null
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm %s  -o /dev/null");
  }

  @Test
  public void test_2003_10_06_NegateExprType_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2003-10-06-NegateExprType.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2003-10-06-NegateExprType.c -o /dev/null
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm %s  -o /dev/null");
  }

  @Test
  public void test_2003_10_09_UnionInitializerBug_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2003-10-09-UnionInitializerBug.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2003-10-09-UnionInitializerBug.c -o /dev/null
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm %s  -o /dev/null");
  }

  @Test
  public void test_2003_10_28_ident_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2003-10-28-ident.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2003-10-28-ident.c -o /dev/null
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm %s  -o /dev/null");
  }

  @Test
  public void test_2003_10_29_AsmRename_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2003-10-29-AsmRename.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2003-10-29-AsmRename.c -triple x86_64-apple-darwin -o /dev/null
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm %s -triple x86_64-apple-darwin -o /dev/null");
  }

  @Test
  public void test_2003_11_01_C99_CompoundLiteral_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2003-11-01-C99-CompoundLiteral.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2003-11-01-C99-CompoundLiteral.c -o /dev/null
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm %s  -o /dev/null");
  }

  @Test
  public void test_2003_11_01_EmptyStructCrash_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2003-11-01-EmptyStructCrash.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2003-11-01-EmptyStructCrash.c -o /dev/null
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm %s  -o /dev/null");
  }

  @Test
  public void test_2003_11_01_GlobalUnionInit_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2003-11-01-GlobalUnionInit.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2003-11-01-GlobalUnionInit.c -o /dev/null
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm %s  -o /dev/null");
  }

  @Test
  public void test_2003_11_03_AddrArrayElement_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2003-11-03-AddrArrayElement.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2003-11-03-AddrArrayElement.c -emit-llvm -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2003-11-03-AddrArrayElement.c
    RUN(TestState.Failed, "%clang_cc1 %s -emit-llvm -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_2003_11_04_EmptyStruct_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2003-11-04-EmptyStruct.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2003-11-04-EmptyStruct.c -o /dev/null
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm %s  -o /dev/null");
  }

  @Test
  public void test_2003_11_04_OutOfMemory_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2003-11-04-OutOfMemory.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2003-11-04-OutOfMemory.c -o /dev/null
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm %s  -o /dev/null");
  }

  @Test
  public void test_2003_11_08_PointerSubNotGetelementptr_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2003-11-08-PointerSubNotGetelementptr.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2003-11-08-PointerSubNotGetelementptr.c -emit-llvm -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2003-11-08-PointerSubNotGetelementptr.c
    RUN(TestState.Failed, "%clang_cc1 %s -emit-llvm -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_2003_11_12_VoidString_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2003-11-12-VoidString.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2003-11-12-VoidString.c -o /dev/null
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm %s  -o /dev/null");
  }

  @Test
  public void test_2003_11_13_TypeSafety_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2003-11-13-TypeSafety.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2003-11-13-TypeSafety.c -emit-llvm -o - | grep getelementptr
    RUN(TestState.Failed, "%clang_cc1  %s -emit-llvm -o -")./*|*/
      I("grep getelementptr");
  }

  @Test
  public void test_2003_11_16_StaticArrayInit_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2003-11-16-StaticArrayInit.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2003-11-16-StaticArrayInit.c -o /dev/null
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm %s  -o /dev/null");
  }

  @Test
  public void test_2003_11_18_CondExprLValue_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2003-11-18-CondExprLValue.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2003-11-18-CondExprLValue.c -o /dev/null
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm %s  -o /dev/null");
  }

  @Test
  public void test_2003_11_19_AddressOfRegister_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2003-11-19-AddressOfRegister.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2003-11-19-AddressOfRegister.c -emit-llvm -o /dev/null
    RUN(TestState.Failed, "%clang_cc1 %s -emit-llvm -o /dev/null");
  }

  @Test
  public void test_2003_11_19_BitFieldArray_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2003-11-19-BitFieldArray.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2003-11-19-BitFieldArray.c -o /dev/null
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm %s  -o /dev/null");
  }

  @Test
  public void test_2003_11_20_Bitfields_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2003-11-20-Bitfields.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2003-11-20-Bitfields.c -o /dev/null
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm %s  -o /dev/null");
  }

  @Test
  public void test_2003_11_20_ComplexDivision_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2003-11-20-ComplexDivision.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2003-11-20-ComplexDivision.c -o /dev/null
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm %s  -o /dev/null");
  }

  @Test
  public void test_2003_11_20_UnionBitfield_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2003-11-20-UnionBitfield.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2003-11-20-UnionBitfield.c -o /dev/null
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm %s  -o /dev/null");
  }

  @Test
  public void test_2003_11_26_PointerShift_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2003-11-26-PointerShift.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2003-11-26-PointerShift.c -o /dev/null
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm %s  -o /dev/null");
  }

  @Test
  public void test_2003_11_27_ConstructorCast_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2003-11-27-ConstructorCast.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2003-11-27-ConstructorCast.c -o /dev/null
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm %s  -o /dev/null");
  }

  @Test
  public void test_2003_11_27_UnionCtorInitialization_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2003-11-27-UnionCtorInitialization.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2003-11-27-UnionCtorInitialization.c -o /dev/null
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm %s  -o /dev/null");
  }

  @Test
  public void test_2003_12_14_ExternInlineSupport_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2003-12-14-ExternInlineSupport.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i386-pc-solaris2.11 -std=gnu89 ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2003-12-14-ExternInlineSupport.c -emit-llvm -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2003-12-14-ExternInlineSupport.c
    RUN(TestState.Failed, "%clang_cc1 -triple %itanium_abi_triple -std=gnu89 %s -emit-llvm -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_2004_01_01_UnknownInitSize_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2004-01-01-UnknownInitSize.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2004-01-01-UnknownInitSize.c -o /dev/null
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm %s -o /dev/null");
  }

  @Test
  public void test_2004_01_08_ExternInlineRedefine_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2004-01-08-ExternInlineRedefine.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=gnu89 -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2004-01-08-ExternInlineRedefine.c -o /dev/null
    RUN(TestState.Failed, "%clang_cc1 -std=gnu89 -emit-llvm %s  -o /dev/null");
  }

  @Test
  public void test_2004_02_12_LargeAggregateCopy_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2004-02-12-LargeAggregateCopy.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2004-02-12-LargeAggregateCopy.c -emit-llvm -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2004-02-12-LargeAggregateCopy.c
    RUN(TestState.Failed, "%clang_cc1  %s -emit-llvm -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_2004_02_13_BuiltinFrameReturnAddress_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2004-02-13-BuiltinFrameReturnAddress.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2004-02-13-BuiltinFrameReturnAddress.c -emit-llvm -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2004-02-13-BuiltinFrameReturnAddress.c
    RUN(TestState.Failed, "%clang_cc1  %s -emit-llvm -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_2004_02_13_IllegalVararg_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2004-02-13-IllegalVararg.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2004-02-13-IllegalVararg.c -w -emit-llvm -o -
    RUN(TestState.Failed, "%clang_cc1  %s -w -emit-llvm -o -");
  }

  @Test
  public void test_2004_02_13_Memset_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2004-02-13-Memset.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2004-02-13-Memset.c -emit-llvm -o - | grep llvm.memset | ${LLVM_SRC}/build/bin/count 3
    RUN(TestState.Failed, "%clang_cc1  %s -emit-llvm -o -")./*|*/
      I("grep llvm.memset")./*|*/
      I("count 3");
  }

  @Test
  public void test_2004_02_14_ZeroInitializer_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2004-02-14-ZeroInitializer.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2004-02-14-ZeroInitializer.c -emit-llvm -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2004-02-14-ZeroInitializer.c
    RUN(TestState.Failed, "%clang_cc1  %s -emit-llvm -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_2004_02_20_Builtins_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2004-02-20-Builtins.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2004-02-20-Builtins.c -emit-llvm -o - | not grep builtin
    RUN(TestState.Failed, "%clang_cc1  %s -emit-llvm -o -")./*|*/
      I("not grep builtin");
  }

  @Test
  public void test_2004_03_07_ComplexDivEquals_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2004-03-07-ComplexDivEquals.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2004-03-07-ComplexDivEquals.c -o /dev/null
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm %s  -o /dev/null");
  }

  @Test
  public void test_2004_03_07_ExternalConstant_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2004-03-07-ExternalConstant.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2004-03-07-ExternalConstant.c -emit-llvm -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2004-03-07-ExternalConstant.c
    RUN(TestState.Failed, "%clang_cc1  %s -emit-llvm -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_2004_03_09_LargeArrayInitializers_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2004-03-09-LargeArrayInitializers.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2004-03-09-LargeArrayInitializers.c -o /dev/null
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm %s  -o /dev/null");
  }

  @Test
  public void test_2004_03_15_SimpleIndirectGoto_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2004-03-15-SimpleIndirectGoto.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2004-03-15-SimpleIndirectGoto.c -o /dev/null
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm %s  -o /dev/null");
  }

  @Test
  public void test_2004_03_16_AsmRegisterCrash_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2004-03-16-AsmRegisterCrash.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple armv7-unknown-unknown ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2004-03-16-AsmRegisterCrash.c -o /dev/null
    RUN(TestState.Failed, "%clang_cc1 -triple armv7-unknown-unknown %s  -o /dev/null");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-unknown-unknown ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2004-03-16-AsmRegisterCrash.c -o /dev/null
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-unknown-unknown %s  -o /dev/null");
  }

  @Test
  public void test_2004_05_07_VarArrays_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2004-05-07-VarArrays.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2004-05-07-VarArrays.c -o /dev/null
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm %s  -o /dev/null");
  }

  @Test
  public void test_2004_05_21_IncompleteEnum_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2004-05-21-IncompleteEnum.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -w -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2004-05-21-IncompleteEnum.c -o /dev/null
    RUN(TestState.Failed, "%clang_cc1 -w -emit-llvm %s  -o /dev/null");
  }

  @Test
  public void test_2004_06_08_OpaqueStructArg_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2004-06-08-OpaqueStructArg.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2004-06-08-OpaqueStructArg.c -o /dev/null
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm %s  -o /dev/null");
  }

  @Test
  public void test_2004_06_17_UnorderedBuiltins_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2004-06-17-UnorderedBuiltins.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2004-06-17-UnorderedBuiltins.c -o /dev/null
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm %s  -o /dev/null");
  }

  @Test
  public void test_2004_06_17_UnorderedCompares_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2004-06-17-UnorderedCompares.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c99 ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2004-06-17-UnorderedCompares.c -emit-llvm -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2004-06-17-UnorderedCompares.c
    RUN(TestState.Failed, "%clang_cc1  -std=c99 %s -emit-llvm -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_2004_06_18_VariableLengthArrayOfStructures_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2004-06-18-VariableLengthArrayOfStructures.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2004-06-18-VariableLengthArrayOfStructures.c -o /dev/null
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm %s  -o /dev/null");
  }

  @Test
  public void test_2004_07_06_FunctionCast_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2004-07-06-FunctionCast.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2004-07-06-FunctionCast.c -o /dev/null
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm %s  -o /dev/null");
  }

  @Test
  public void test_2004_08_06_LargeStructTest_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2004-08-06-LargeStructTest.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2004-08-06-LargeStructTest.c -o /dev/null
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm %s  -o /dev/null");
  }

  @Test
  public void test_2004_11_25_UnnamedBitfieldPadding_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2004-11-25-UnnamedBitfieldPadding.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2004-11-25-UnnamedBitfieldPadding.c -o /dev/null
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm %s -o /dev/null");
  }

  @Test
  public void test_2004_11_27_StaticFunctionRedeclare_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2004-11-27-StaticFunctionRedeclare.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2004-11-27-StaticFunctionRedeclare.c -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2004-11-27-StaticFunctionRedeclare.c
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm %s -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_2005_01_02_ConstantInits_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2005-01-02-ConstantInits.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2005-01-02-ConstantInits.c -emit-llvm -o -
    RUN(TestState.Failed, "%clang_cc1 %s -emit-llvm -o -");
  }

  @Test
  public void test_2005_01_02_PointerDifference_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2005-01-02-PointerDifference.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2005-01-02-PointerDifference.c -emit-llvm -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2005-01-02-PointerDifference.c
    RUN(TestState.Failed, "%clang_cc1  %s -emit-llvm -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_2005_01_02_VAArgError_ICE_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2005-01-02-VAArgError-ICE.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2005-01-02-VAArgError-ICE.c -emit-llvm -o /dev/null
    RUN(TestState.Failed, "%clang_cc1 %s -emit-llvm -o /dev/null");
  }

  @Test
  public void test_2005_02_20_AggregateSAVEEXPR_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2005-02-20-AggregateSAVEEXPR.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2005-02-20-AggregateSAVEEXPR.c -o /dev/null -emit-llvm
    RUN(TestState.Failed, "%clang_cc1 %s -o /dev/null -emit-llvm");
  }

  @Test
  public void test_2005_02_27_MarkGlobalConstant_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2005-02-27-MarkGlobalConstant.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2005-02-27-MarkGlobalConstant.c -emit-llvm -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2005-02-27-MarkGlobalConstant.c
    RUN(TestState.Failed, "%clang_cc1  %s -emit-llvm -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_2005_03_05_OffsetOfHack_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2005-03-05-OffsetOfHack.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2005-03-05-OffsetOfHack.c -emit-llvm -o -
    RUN(TestState.Failed, "%clang_cc1 %s -emit-llvm -o -");
  }

  @Test
  public void test_2005_03_06_OffsetOfStructCrash_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2005-03-06-OffsetOfStructCrash.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2005-03-06-OffsetOfStructCrash.c -emit-llvm -o -
    RUN(TestState.Failed, "%clang_cc1 %s -emit-llvm -o -");
  }

  @Test
  public void test_2005_03_11_Prefetch_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2005-03-11-Prefetch.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2005-03-11-Prefetch.c -emit-llvm -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2005-03-11-Prefetch.c
    RUN(TestState.Failed, "%clang_cc1 %s -emit-llvm -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_2005_04_09_ComplexOps_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2005-04-09-ComplexOps.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2005-04-09-ComplexOps.c -emit-llvm -o -
    RUN(TestState.Failed, "%clang_cc1 %s -emit-llvm -o -");
  }

  @Test
  public void test_2005_05_10_GlobalUnionInit_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2005-05-10-GlobalUnionInit.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2005-05-10-GlobalUnionInit.c -emit-llvm -o -
    RUN(TestState.Failed, "%clang_cc1 %s -emit-llvm -o -");
  }

  @Test
  public void test_2005_06_15_ExpandGotoInternalProblem_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2005-06-15-ExpandGotoInternalProblem.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c99 ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2005-06-15-ExpandGotoInternalProblem.c -emit-llvm -o - | opt -O3 -disable-output
    RUN(TestState.Failed, "%clang_cc1 -std=c99 %s -emit-llvm -o -")./*|*/
      I("opt -O3 -disable-output");
  }

  @Test
  public void test_2005_07_20_SqrtNoErrno_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2005-07-20-SqrtNoErrno.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-apple-darwin ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2005-07-20-SqrtNoErrno.c -emit-llvm -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2005-07-20-SqrtNoErrno.c
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-apple-darwin %s -emit-llvm -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_2005_07_26_UnionInitCrash_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2005-07-26-UnionInitCrash.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2005-07-26-UnionInitCrash.c -emit-llvm -o -
    RUN(TestState.Failed, "%clang_cc1 %s -emit-llvm -o -");
  }

  @Test
  public void test_2005_07_28_IncorrectWeakGlobal_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2005-07-28-IncorrectWeakGlobal.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2005-07-28-IncorrectWeakGlobal.c -emit-llvm -o - | grep TheGlobal | not grep weak
    RUN(TestState.Failed, "%clang_cc1 %s -emit-llvm -o -")./*|*/
      I("grep TheGlobal")./*|*/
      I("not grep weak");
  }

  @Test
  public void test_2005_09_20_ComplexConstants_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2005-09-20-ComplexConstants.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2005-09-20-ComplexConstants.c -emit-llvm -o /dev/null
    RUN(TestState.Failed, "%clang_cc1 %s -emit-llvm  -o /dev/null");
  }

  @Test
  public void test_2005_09_24_AsmUserPrefix_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2005-09-24-AsmUserPrefix.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2005-09-24-AsmUserPrefix.c -emit-llvm -o - | opt -O3 | llc | not grep _foo2
    RUN(TestState.Failed, "%clang_cc1 %s -emit-llvm -o -")./*|*/
      I("opt -O3")./*|*/
      I("llc")./*|*/
      I("not grep _foo2");
  }

  @Test
  public void test_2005_09_24_BitFieldCrash_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2005-09-24-BitFieldCrash.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2005-09-24-BitFieldCrash.c -emit-llvm -o -
    RUN(TestState.Failed, "%clang_cc1 %s -emit-llvm -o -");
  }

  @Test
  public void test_2005_12_04_AttributeUsed_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2005-12-04-AttributeUsed.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2005-12-04-AttributeUsed.c -emit-llvm -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2005-12-04-AttributeUsed.c
    RUN(TestState.Failed, "%clang_cc1 %s -emit-llvm -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_2006_01_13_Includes_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2006-01-13-Includes.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2006-01-13-Includes.c -debug-info-kind=limited -emit-llvm -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2006-01-13-Includes.c
    RUN(TestState.Failed, "%clang_cc1 %s -debug-info-kind=limited -emit-llvm -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_2006_01_13_StackSave_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2006-01-13-StackSave.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2006-01-13-StackSave.c -emit-llvm -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2006-01-13-StackSave.c
    RUN(TestState.Failed, "%clang_cc1 %s -emit-llvm -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_2006_01_16_BitCountIntrinsicsUnsigned_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2006-01-16-BitCountIntrinsicsUnsigned.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2006-01-16-BitCountIntrinsicsUnsigned.c -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2006-01-16-BitCountIntrinsicsUnsigned.c
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm %s -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_2006_01_23_FileScopeAsm_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2006-01-23-FileScopeAsm.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2006-01-23-FileScopeAsm.c -emit-llvm -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2006-01-23-FileScopeAsm.c
    RUN(TestState.Failed, "%clang_cc1 %s -emit-llvm -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_2006_03_03_MissingInitializer_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2006-03-03-MissingInitializer.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2006-03-03-MissingInitializer.c -emit-llvm -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2006-03-03-MissingInitializer.c
    RUN(TestState.Failed, "%clang_cc1 %s -emit-llvm -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_2006_03_16_VectorCtor_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2006-03-16-VectorCtor.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2006-03-16-VectorCtor.c -emit-llvm -o -
    RUN(TestState.Failed, "%clang_cc1 %s -emit-llvm -o -");
  }

  @Test
  public void test_2006_03_17_KnRMismatch_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2006-03-17-KnRMismatch.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2006-03-17-KnRMismatch.c -emit-llvm -o -
    RUN(TestState.Failed, "%clang_cc1 %s -emit-llvm -o -");
  }

  @Test
  public void test_2006_05_19_SingleEltReturn_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2006-05-19-SingleEltReturn.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2006-05-19-SingleEltReturn.c -emit-llvm -o -
    RUN(TestState.Failed, "%clang_cc1 %s -emit-llvm -o -");
  }

  @Test
  public void test_2006_07_31_PR854_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2006-07-31-PR854.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i686-linux-gnu -w ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2006-07-31-PR854.c -emit-llvm -o -
    RUN(TestState.Failed, "%clang_cc1 -triple i686-linux-gnu -w %s -emit-llvm -o -");
  }

  @Test
  public void test_2006_09_11_BitfieldRefCrash_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2006-09-11-BitfieldRefCrash.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2006-09-11-BitfieldRefCrash.c -emit-llvm -o -
    RUN(TestState.Failed, "%clang_cc1 %s -emit-llvm -o -");
  }

  @Test
  public void test_2006_09_18_fwrite_cast_crash_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2006-09-18-fwrite-cast-crash.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2006-09-18-fwrite-cast-crash.c -emit-llvm -o /dev/null
    RUN(TestState.Failed, "%clang_cc1 %s -emit-llvm -o /dev/null");
  }

  @Test
  public void test_2006_09_21_IncompleteElementType_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2006-09-21-IncompleteElementType.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2006-09-21-IncompleteElementType.c -emit-llvm -o /dev/null
    RUN(TestState.Failed, "not %clang_cc1 %s -emit-llvm -o /dev/null");
  }

  @Test
  public void test_2006_09_25_DebugFilename_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2006-09-25-DebugFilename.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2006-09-25-DebugFilename.c -emit-llvm -o /dev/null
    RUN(TestState.Failed, "not %clang_cc1  %s -emit-llvm -o /dev/null");
  }

  @Test
  public void test_2006_09_28_SimpleAsm_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2006-09-28-SimpleAsm.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2006-09-28-SimpleAsm.c -emit-llvm -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2006-09-28-SimpleAsm.c
    RUN(TestState.Failed, "%clang_cc1 %s -emit-llvm -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_2006_10_30_ArrayCrash_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2006-10-30-ArrayCrash.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -O3 -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2006-10-30-ArrayCrash.c
    RUN(TestState.Failed, "%clang_cc1 -O3 -emit-llvm -o - %s");
  }

  @Test
  public void test_2006_12_14_ordered_expr_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2006-12-14-ordered_expr.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -O3 -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2006-12-14-ordered_expr.c -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2006-12-14-ordered_expr.c
    RUN(TestState.Failed, "%clang_cc1 -O3 -emit-llvm %s -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_2007_01_06_KNR_Proto_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2007-01-06-KNR-Proto.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2007-01-06-KNR-Proto.c
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm -o - %s");
  }

  @Test
  public void test_2007_01_20_VectorICE_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2007-01-20-VectorICE.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2007-01-20-VectorICE.c -emit-llvm -o -
    RUN(TestState.Failed, "%clang_cc1 %s -emit-llvm -o -");
  }

  @Test
  public void test_2007_01_24_InlineAsmCModifier_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2007-01-24-InlineAsmCModifier.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2007-01-24-InlineAsmCModifier.c -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2007-01-24-InlineAsmCModifier.c
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm %s -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_2007_02_04_AddrLValue_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2007-02-04-AddrLValue.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2007-02-04-AddrLValue.c -O3 -emit-llvm -o -
    RUN(TestState.Failed, "%clang_cc1 %s -O3 -emit-llvm -o -");
  }

  @Test
  public void test_2007_02_04_AddrLValue_2_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2007-02-04-AddrLValue-2.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2007-02-04-AddrLValue-2.c -O3 -emit-llvm -o -
    RUN(TestState.Failed, "%clang_cc1 %s -O3 -emit-llvm -o -");
  }

  @Test
  public void test_2007_02_04_EmptyStruct_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2007-02-04-EmptyStruct.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2007-02-04-EmptyStruct.c -O3 -emit-llvm -o -
    RUN(TestState.Failed, "%clang_cc1 %s -O3 -emit-llvm -o -");
  }

  @Test
  public void test_2007_02_07_AddrLabel_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2007-02-07-AddrLabel.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2007-02-07-AddrLabel.c -emit-llvm -o -
    RUN(TestState.Failed, "%clang_cc1 %s -emit-llvm -o -");
  }

  @Test
  public void test_2007_02_16_VoidPtrDiff_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2007-02-16-VoidPtrDiff.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2007-02-16-VoidPtrDiff.c -emit-llvm -o -
    RUN(TestState.Failed, "%clang_cc1 %s -emit-llvm -o -");
  }

  @Test
  public void test_2007_02_25_C_DotDotDot_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2007-02-25-C-DotDotDot.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-apple-darwin ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2007-02-25-C-DotDotDot.c -emit-llvm -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2007-02-25-C-DotDotDot.c
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-apple-darwin %s -emit-llvm -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_2007_03_01_VarSizeArrayIdx_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2007-03-01-VarSizeArrayIdx.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2007-03-01-VarSizeArrayIdx.c -O3 -emit-llvm -o - | grep mul
    RUN(TestState.Failed, "%clang_cc1 %s -O3 -emit-llvm -o -")./*|*/
      I("grep mul");
  }

  @Test
  public void test_2007_03_26_BitfieldAfterZeroWidth_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2007-03-26-BitfieldAfterZeroWidth.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2007-03-26-BitfieldAfterZeroWidth.c -emit-llvm -o -
    RUN(TestState.Failed, "%clang_cc1 %s -emit-llvm -o -");
  }

  @Test
  public void test_2007_03_26_ZeroWidthBitfield_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2007-03-26-ZeroWidthBitfield.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2007-03-26-ZeroWidthBitfield.c -emit-llvm -o -
    RUN(TestState.Failed, "%clang_cc1 %s -emit-llvm -o -");
  }

  @Test
  public void test_2007_03_27_VarLengthArray_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2007-03-27-VarLengthArray.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2007-03-27-VarLengthArray.c -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2007-03-27-VarLengthArray.c
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm %s -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_2007_04_05_PackedBitFields_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2007-04-05-PackedBitFields.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2007-04-05-PackedBitFields.c -emit-llvm -o -
    RUN(TestState.Failed, "%clang_cc1 %s -emit-llvm -o -");
  }

  @Test
  public void test_2007_04_05_PackedBitFields_2_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2007-04-05-PackedBitFields-2.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2007-04-05-PackedBitFields-2.c -emit-llvm -o -
    RUN(TestState.Failed, "%clang_cc1 %s -emit-llvm -o -");
  }

  @Test
  public void test_2007_04_05_PackedStruct_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2007-04-05-PackedStruct.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2007-04-05-PackedStruct.c -emit-llvm -o -
    RUN(TestState.Failed, "%clang_cc1 %s -emit-llvm -o -");
  }

  @Test
  public void test_2007_04_05_PadBeforeZeroLengthField_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2007-04-05-PadBeforeZeroLengthField.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2007-04-05-PadBeforeZeroLengthField.c -emit-llvm -o -
    RUN(TestState.Failed, "%clang_cc1 %s -emit-llvm -o -");
  }

  @Test
  public void test_2007_04_05_UnPackedStruct_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2007-04-05-UnPackedStruct.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2007-04-05-UnPackedStruct.c -emit-llvm -o -
    RUN(TestState.Failed, "%clang_cc1 %s -emit-llvm -o -");
  }

  @Test
  public void test_2007_04_11_InlineAsmStruct_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2007-04-11-InlineAsmStruct.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2007-04-11-InlineAsmStruct.c -emit-llvm -o -
    RUN(TestState.Failed, "%clang_cc1 %s -emit-llvm -o -");
  }

  @Test
  public void test_2007_04_11_InlineAsmUnion_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2007-04-11-InlineAsmUnion.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2007-04-11-InlineAsmUnion.c -emit-llvm -o -
    RUN(TestState.Failed, "%clang_cc1 %s -emit-llvm -o -");
  }

  @Test
  public void test_2007_04_11_PR1321_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2007-04-11-PR1321.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2007-04-11-PR1321.c -emit-llvm -o /dev/null
    RUN(TestState.Failed, "%clang_cc1 %s -emit-llvm -o /dev/null");
  }

  @Test
  public void test_2007_04_13_InlineAsmStruct2_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2007-04-13-InlineAsmStruct2.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2007-04-13-InlineAsmStruct2.c -emit-llvm -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2007-04-13-InlineAsmStruct2.c
    RUN(TestState.Failed, "%clang_cc1 %s -emit-llvm -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_2007_04_13_InlineAsmUnion2_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2007-04-13-InlineAsmUnion2.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2007-04-13-InlineAsmUnion2.c -emit-llvm -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2007-04-13-InlineAsmUnion2.c
    RUN(TestState.Failed, "%clang_cc1 %s -emit-llvm -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_2007_04_14_FNoBuiltin_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2007-04-14-FNoBuiltin.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2007-04-14-FNoBuiltin.c -O2 -fno-builtin -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2007-04-14-FNoBuiltin.c
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm %s -O2 -fno-builtin -o -")./*|*/
      I("FileCheck %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2007-04-14-FNoBuiltin.c -O2 -fno-builtin-printf -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2007-04-14-FNoBuiltin.c
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm %s -O2 -fno-builtin-printf -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_2007_04_17_ZeroSizeBitFields_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2007-04-17-ZeroSizeBitFields.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2007-04-17-ZeroSizeBitFields.c -emit-llvm -o /dev/null
    RUN(TestState.Failed, "%clang_cc1 %s -emit-llvm -o /dev/null");
  }

  @Test
  public void test_2007_04_24_VolatileStructCopy_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2007-04-24-VolatileStructCopy.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2007-04-24-VolatileStructCopy.c | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2007-04-24-VolatileStructCopy.c
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm -o - %s")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_2007_04_24_bit_not_expr_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2007-04-24-bit-not-expr.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2007-04-24-bit-not-expr.c -o /dev/null
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm %s  -o /dev/null");
  }

  @Test
  public void test_2007_04_24_str_const_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2007-04-24-str-const.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2007-04-24-str-const.c -o /dev/null
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm %s  -o /dev/null");
  }

  @Test
  public void test_2007_05_07_PaddingElements_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2007-05-07-PaddingElements.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2007-05-07-PaddingElements.c -emit-llvm -o - | grep struct.s | not grep '4 x i8] zeroinitializer'
    RUN(TestState.Failed, "%clang_cc1 %s -emit-llvm -o -")./*|*/
      I("grep struct.s")./*|*/
      I("not grep \"4 x i8] zeroinitializer\"");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2007-05-07-PaddingElements.c -emit-llvm -o - | not grep 'i32 0, i32 2'
    RUN(TestState.Failed, "%clang_cc1 %s -emit-llvm -o -")./*|*/
      I("not grep \"i32 0, i32 2\"");
  }

  @Test
  public void test_2007_05_08_PCH_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2007-05-08-PCH.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x c-header ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2007-05-08-PCH.c -o /dev/null
    RUN(TestState.Failed, "%clang_cc1 -x c-header %s -o /dev/null");
  }

  @Test
  public void test_2007_05_11_str_const_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2007-05-11-str-const.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm -debug-info-kind=limited ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2007-05-11-str-const.c -o /dev/null
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm -debug-info-kind=limited %s  -o /dev/null");
  }

  @Test
  public void test_2007_05_15_PaddingElement_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2007-05-15-PaddingElement.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -O2 ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2007-05-15-PaddingElement.c -emit-llvm -o - | grep 'ret i32 1'
    RUN(TestState.Failed, "%clang_cc1   -O2 %s -emit-llvm -o -")./*|*/
      I("grep \"ret i32 1\"");
  }

  @Test
  public void test_2007_05_16_EmptyStruct_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2007-05-16-EmptyStruct.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2007-05-16-EmptyStruct.c -emit-llvm -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2007-05-16-EmptyStruct.c
    RUN(TestState.Failed, "%clang_cc1   %s -emit-llvm -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_2007_05_29_UnionCopy_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2007-05-29-UnionCopy.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2007-05-29-UnionCopy.c | grep memcpy
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm -o - %s")./*|*/
      I("grep memcpy");
  }

  @Test
  public void test_2007_06_05_NoInlineAttribute_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2007-06-05-NoInlineAttribute.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -O2 -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2007-06-05-NoInlineAttribute.c -o - | grep call
    RUN(TestState.Failed, "%clang_cc1 -O2 -emit-llvm %s -o -")./*|*/
      I("grep call");
  }

  @Test
  public void test_2007_06_15_AnnotateAttribute_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2007-06-15-AnnotateAttribute.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2007-06-15-AnnotateAttribute.c -o - | grep llvm.global.annotations
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm %s -o -")./*|*/
      I("grep llvm.global.annotations");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2007-06-15-AnnotateAttribute.c -o - | grep llvm.var.annotation | ${LLVM_SRC}/build/bin/count 3
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm %s -o -")./*|*/
      I("grep llvm.var.annotation")./*|*/
      I("count 3");
  }

  @Test
  public void test_2007_06_18_SextAttrAggregate_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2007-06-18-SextAttrAggregate.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2007-06-18-SextAttrAggregate.c -o - -emit-llvm | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2007-06-18-SextAttrAggregate.c
    RUN(TestState.Failed, "%clang_cc1 %s -o - -emit-llvm")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_2007_07_29_RestrictPtrArg_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2007-07-29-RestrictPtrArg.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2007-07-29-RestrictPtrArg.c -o - | grep noalias
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm %s -o -")./*|*/
      I("grep noalias");
  }

  @Test
  public void test_2007_08_01_LoadStoreAlign_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2007-08-01-LoadStoreAlign.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2007-08-01-LoadStoreAlign.c | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2007-08-01-LoadStoreAlign.c
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm -o - %s")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_2007_08_21_ComplexCst_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2007-08-21-ComplexCst.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -O2 -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2007-08-21-ComplexCst.c -o /dev/null
    RUN(TestState.Failed, "%clang_cc1 -O2 -emit-llvm %s -o /dev/null");
  }

  @Test
  public void test_2007_08_22_CTTZ_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2007-08-22-CTTZ.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2007-08-22-CTTZ.c | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2007-08-22-CTTZ.c
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm -o - %s")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_2007_09_05_ConstCtor_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2007-09-05-ConstCtor.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -Os -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2007-09-05-ConstCtor.c -o /dev/null
    RUN(TestState.Failed, "%clang_cc1  -Os -emit-llvm %s -o /dev/null");
  }

  @Test
  public void test_2007_09_12_PragmaPack_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2007-09-12-PragmaPack.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2007-09-12-PragmaPack.c | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2007-09-12-PragmaPack.c
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm -o - %s")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_2007_09_14_NegatePointer_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2007-09-14-NegatePointer.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2007-09-14-NegatePointer.c -o -
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm %s -o -");
  }

  @Test
  public void test_2007_09_17_WeakRef_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2007-09-17-WeakRef.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -O1 -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2007-09-17-WeakRef.c -o - | grep icmp
    RUN(TestState.Failed, "%clang_cc1 -O1 -emit-llvm %s -o -")./*|*/
      I("grep icmp");
  }

  @Test
  public void test_2007_09_26_Alignment_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2007-09-26-Alignment.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2007-09-26-Alignment.c -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2007-09-26-Alignment.c
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm %s -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_2007_09_27_ComplexIntCompare_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2007-09-27-ComplexIntCompare.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2007-09-27-ComplexIntCompare.c -o -
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm %s -o -");
  }

  @Test
  public void test_2007_09_28_PackedUnionMember_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2007-09-28-PackedUnionMember.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2007-09-28-PackedUnionMember.c -emit-llvm -o -
    RUN(TestState.Failed, "%clang_cc1 %s -emit-llvm -o -");
  }

  @Test
  public void test_2007_10_02_VolatileArray_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2007-10-02-VolatileArray.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2007-10-02-VolatileArray.c -o - | grep volatile
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm %s -o -")./*|*/
      I("grep volatile");
  }

  @Test
  public void test_2007_10_15_VoidPtr_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2007-10-15-VoidPtr.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2007-10-15-VoidPtr.c -o /dev/null
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm %s -o /dev/null");
  }

  @Test
  public void test_2007_10_30_Volatile_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2007-10-30-Volatile.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2007-10-30-Volatile.c -o /dev/null -Wall -Werror
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm %s -o /dev/null -Wall -Werror");
  }

  @Test
  public void test_2007_11_07_AlignedMemcpy_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2007-11-07-AlignedMemcpy.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2007-11-07-AlignedMemcpy.c -o /dev/null
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm %s -o /dev/null");
  }

  @Test
  public void test_2007_11_07_CopyAggregateAlign_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2007-11-07-CopyAggregateAlign.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2007-11-07-CopyAggregateAlign.c -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2007-11-07-CopyAggregateAlign.c
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm %s -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_2007_11_07_ZeroAggregateAlign_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2007-11-07-ZeroAggregateAlign.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2007-11-07-ZeroAggregateAlign.c -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2007-11-07-ZeroAggregateAlign.c
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm %s -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_2007_11_28_GlobalInitializer_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2007-11-28-GlobalInitializer.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2007-11-28-GlobalInitializer.c -o -
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm %s -o -");
  }

  @Test
  public void test_2007_11_29_ArraySizeFromInitializer_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2007-11-29-ArraySizeFromInitializer.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2007-11-29-ArraySizeFromInitializer.c -o ${TEST_TEMP_DIR}/2007-11-29-ArraySizeFromInitializer.c.tmp
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm %s -o %t");
  }

  @Test
  public void test_2007_12_16_AsmNoUnwind_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2007-12-16-AsmNoUnwind.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2007-12-16-AsmNoUnwind.c -emit-llvm -o - | grep nounwind
    RUN(TestState.Failed, "%clang_cc1 %s -emit-llvm -o -")./*|*/
      I("grep nounwind");
  }

  @Test
  public void test_2008_01_04_WideBitfield_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2008-01-04-WideBitfield.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2008-01-04-WideBitfield.c
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm -o - %s");
  }

  @Test
  public void test_2008_01_07_UnusualIntSize_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2008-01-07-UnusualIntSize.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-unknown-unknown ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2008-01-07-UnusualIntSize.c -emit-llvm -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2008-01-07-UnusualIntSize.c
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-unknown-unknown %s -emit-llvm -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_2008_01_21_PackedBitFields_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2008-01-21-PackedBitFields.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2008-01-21-PackedBitFields.c -emit-llvm -o -
    RUN(TestState.Failed, "%clang_cc1 %s -emit-llvm -o -");
  }

  @Test
  public void test_2008_01_21_PackedStructField_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2008-01-21-PackedStructField.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2008-01-21-PackedStructField.c -emit-llvm -o -
    RUN(TestState.Failed, "%clang_cc1 %s -emit-llvm -o -");
  }

  @Test
  public void test_2008_01_24_StructAlignAndBitFields_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2008-01-24-StructAlignAndBitFields.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2008-01-24-StructAlignAndBitFields.c -emit-llvm -o -
    RUN(TestState.Failed, "%clang_cc1 %s -emit-llvm -o -");
  }

  @Test
  public void test_2008_01_25_ByValReadNone_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2008-01-25-ByValReadNone.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-unknown-unknown -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2008-01-25-ByValReadNone.c | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2008-01-25-ByValReadNone.c
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-unknown-unknown -emit-llvm -o - %s")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_2008_01_25_ZeroSizedAggregate_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2008-01-25-ZeroSizedAggregate.c");
    // REQUIRES: LP64
    if (!CHECK_REQUIRES("LP64")) {
      return;
    }
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2008-01-25-ZeroSizedAggregate.c -emit-llvm -o -
    RUN(TestState.Failed, "%clang_cc1 %s -emit-llvm -o -");
  }

  @Test
  public void test_2008_01_28_PragmaMark_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2008-01-28-PragmaMark.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -Werror -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2008-01-28-PragmaMark.c -o /dev/null
    RUN(TestState.Failed, "%clang_cc1 -Werror -emit-llvm %s -o /dev/null");
  }

  @Test
  public void test_2008_01_28_UnionSize_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2008-01-28-UnionSize.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2008-01-28-UnionSize.c -emit-llvm -o -
    RUN(TestState.Failed, "%clang_cc1 %s -emit-llvm -o -");
  }

  @Test
  public void test_2008_02_07_bitfield_bug_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2008-02-07-bitfield-bug.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2008-02-07-bitfield-bug.c -emit-llvm -o ${TEST_TEMP_DIR}/2008-02-07-bitfield-bug.c.tmp
    RUN(TestState.Failed, "%clang_cc1 %s -emit-llvm -o %t");
  }

  @Test
  public void test_2008_02_08_bitfield_bug_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2008-02-08-bitfield-bug.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2008-02-08-bitfield-bug.c -emit-llvm -o ${TEST_TEMP_DIR}/2008-02-08-bitfield-bug.c.tmp
    RUN(TestState.Failed, "%clang_cc1 %s -emit-llvm -o %t");
  }

  @Test
  public void test_2008_02_26_inline_asm_bug_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2008-02-26-inline-asm-bug.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm < ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2008-02-26-inline-asm-bug.c | grep '\$0,\$1'
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm < %s")./*|*/
      I("grep \"\\$0,\\$1\"");
  }

  @Test
  public void test_2008_03_03_CtorAttrType_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2008-03-03-CtorAttrType.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2008-03-03-CtorAttrType.c -emit-llvm -o - | grep llvm.global_ctors
    RUN(TestState.Failed, "%clang_cc1 %s -emit-llvm -o -")./*|*/
      I("grep llvm.global_ctors");
  }

  @Test
  public void test_2008_03_05_syncPtr_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2008-03-05-syncPtr.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-apple-darwin ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2008-03-05-syncPtr.c -emit-llvm -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2008-03-05-syncPtr.c
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-apple-darwin %s -emit-llvm -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_2008_03_24_BitField_And_Alloca_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2008-03-24-BitField-And-Alloca.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -O2 -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2008-03-24-BitField-And-Alloca.c -o - | not grep alloca
    RUN(TestState.Failed, "%clang_cc1 -O2 -emit-llvm %s -o -")./*|*/
      I("not grep alloca");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i686-pc-linux-gnu -O2 -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2008-03-24-BitField-And-Alloca.c -o - | not grep store
    RUN(TestState.Failed, "%clang_cc1 -triple i686-pc-linux-gnu -O2 -emit-llvm %s -o -")./*|*/
      I("not grep store");
  }

  @Test
  public void test_2008_03_26_PackedBitFields_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2008-03-26-PackedBitFields.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2008-03-26-PackedBitFields.c -emit-llvm -o -
    RUN(TestState.Failed, "%clang_cc1 %s -emit-llvm -o -");
  }

  @Test
  public void test_2008_04_08_NoExceptions_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2008-04-08-NoExceptions.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-apple-darwin -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2008-04-08-NoExceptions.c | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2008-04-08-NoExceptions.c
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-apple-darwin -emit-llvm -o - %s")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_2008_05_06_CFECrash_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2008-05-06-CFECrash.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm -O2 ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2008-05-06-CFECrash.c -o /dev/null
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm -O2 %s -o /dev/null");
  }

  @Test
  public void test_2008_05_12_TempUsedBeforeDef_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2008-05-12-TempUsedBeforeDef.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -w -emit-llvm -o /dev/null ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2008-05-12-TempUsedBeforeDef.c
    RUN(TestState.Failed, "%clang_cc1 -w -emit-llvm -o /dev/null %s");
  }

  @Test
  public void test_2008_05_19_AlwaysInline_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2008-05-19-AlwaysInline.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2008-05-19-AlwaysInline.c -emit-llvm -o - | not grep sabrina
    RUN(TestState.Failed, "%clang_cc1 %s -emit-llvm -o -")./*|*/
      I("not grep sabrina");
  }

  @Test
  public void test_2008_07_17_no_emit_on_error_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2008-07-17-no-emit-on-error.c");
    // rm -f ${TEST_TEMP_DIR}/2008-07-17-no-emit-on-error.c.tmp1.bc
    RUN(TestState.Failed, "rm -f %t1.bc");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -DPASS ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2008-07-17-no-emit-on-error.c -emit-llvm-bc -o ${TEST_TEMP_DIR}/2008-07-17-no-emit-on-error.c.tmp1.bc
    RUN(TestState.Failed, "%clang_cc1 -DPASS %s -emit-llvm-bc -o %t1.bc");
    // opt ${TEST_TEMP_DIR}/2008-07-17-no-emit-on-error.c.tmp1.bc -disable-output
    RUN(TestState.Failed, "opt %t1.bc -disable-output");
    // rm -f ${TEST_TEMP_DIR}/2008-07-17-no-emit-on-error.c.tmp1.bc
    RUN(TestState.Failed, "rm -f %t1.bc");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2008-07-17-no-emit-on-error.c -emit-llvm-bc -o ${TEST_TEMP_DIR}/2008-07-17-no-emit-on-error.c.tmp1.bc
    RUN(TestState.Failed, "not %clang_cc1 %s -emit-llvm-bc -o %t1.bc");
    // opt ${TEST_TEMP_DIR}/2008-07-17-no-emit-on-error.c.tmp1.bc -disable-output
    RUN(TestState.Failed, "not opt %t1.bc -disable-output");
  }

  @Test
  public void test_2008_07_21_mixed_var_fn_decl_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2008-07-21-mixed-var-fn-decl.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2008-07-21-mixed-var-fn-decl.c | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2008-07-21-mixed-var-fn-decl.c
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm -o - %s")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_2008_07_22_bitfield_init_after_zero_len_array_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2008-07-22-bitfield-init-after-zero-len-array.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple=i686-apple-darwin9 -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2008-07-22-bitfield-init-after-zero-len-array.c | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2008-07-22-bitfield-init-after-zero-len-array.c
    RUN(TestState.Failed, "%clang_cc1 -triple=i686-apple-darwin9 -emit-llvm -o - %s")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_2008_07_22_packed_bitfield_access_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2008-07-22-packed-bitfield-access.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2008-07-22-packed-bitfield-access.c -emit-llvm -o -
    RUN(TestState.Failed, "%clang_cc1 %s -emit-llvm -o -");
  }

  @Test
  public void test_2008_07_29_override_alias_decl_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2008-07-29-override-alias-decl.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-pc-linux-gnu -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2008-07-29-override-alias-decl.c | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2008-07-29-override-alias-decl.c
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-pc-linux-gnu -emit-llvm -o - %s")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_2008_07_30_implicit_initialization_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2008-07-30-implicit-initialization.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i386-unknown-unknown -O1 -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2008-07-30-implicit-initialization.c | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2008-07-30-implicit-initialization.c
    RUN(TestState.Failed, "%clang_cc1 -triple i386-unknown-unknown -O1 -emit-llvm -o - %s")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_2008_07_30_redef_of_bitcasted_decl_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2008-07-30-redef-of-bitcasted-decl.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2008-07-30-redef-of-bitcasted-decl.c
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm -o - %s");
  }

  @Test
  public void test_2008_07_31_asm_labels_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2008-07-31-asm-labels.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm -o ${TEST_TEMP_DIR}/2008-07-31-asm-labels.c.tmp ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2008-07-31-asm-labels.c
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm -o %t %s");
    // grep '@pipe()' ${TEST_TEMP_DIR}/2008-07-31-asm-labels.c.tmp
    RUN(TestState.Failed, "not grep \"@pipe()\" %t");
    // grep _thisIsNotAPipe ${TEST_TEMP_DIR}/2008-07-31-asm-labels.c.tmp | ${LLVM_SRC}/build/bin/count 3
    RUN(TestState.Failed, "grep '_thisIsNotAPipe' %t")./*|*/
      I("count 3");
    // grep g0 ${TEST_TEMP_DIR}/2008-07-31-asm-labels.c.tmp
    RUN(TestState.Failed, "not grep 'g0' %t");
    // grep _renamed ${TEST_TEMP_DIR}/2008-07-31-asm-labels.c.tmp | ${LLVM_SRC}/build/bin/count 2
    RUN(TestState.Failed, "grep '_renamed' %t")./*|*/
      I("count 2");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -DUSE_DEF -emit-llvm -o ${TEST_TEMP_DIR}/2008-07-31-asm-labels.c.tmp ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2008-07-31-asm-labels.c
    RUN(TestState.Failed, "%clang_cc1 -DUSE_DEF -emit-llvm -o %t %s");
    // grep '@pipe()' ${TEST_TEMP_DIR}/2008-07-31-asm-labels.c.tmp
    RUN(TestState.Failed, "not grep \"@pipe()\" %t");
    // grep _thisIsNotAPipe ${TEST_TEMP_DIR}/2008-07-31-asm-labels.c.tmp | ${LLVM_SRC}/build/bin/count 3
    RUN(TestState.Failed, "grep '_thisIsNotAPipe' %t")./*|*/
      I("count 3");
  }

  @Test
  public void test_2008_07_31_promotion_of_compound_pointer_arithmetic_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2008-07-31-promotion-of-compound-pointer-arithmetic.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i386-unknown-unknown -O1 -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2008-07-31-promotion-of-compound-pointer-arithmetic.c | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2008-07-31-promotion-of-compound-pointer-arithmetic.c
    RUN(TestState.Failed, "%clang_cc1 -triple i386-unknown-unknown -O1 -emit-llvm -o - %s")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_2008_08_04_void_pointer_arithmetic_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2008-08-04-void-pointer-arithmetic.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2008-08-04-void-pointer-arithmetic.c
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm -o - %s");
  }

  @Test
  public void test_2008_08_07_AlignPadding1_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2008-08-07-AlignPadding1.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2008-08-07-AlignPadding1.c -emit-llvm -triple x86_64-apple-darwin -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2008-08-07-AlignPadding1.c
    RUN(TestState.Failed, "%clang_cc1 %s -emit-llvm -triple x86_64-apple-darwin -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_2008_08_07_AlignPadding2_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2008-08-07-AlignPadding2.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2008-08-07-AlignPadding2.c -emit-llvm -o - | grep zeroinitializer | ${LLVM_SRC}/build/bin/count 1
    RUN(TestState.Failed, "%clang_cc1 %s -emit-llvm -o -")./*|*/
      I("grep zeroinitializer")./*|*/
      I("count 1");
  }

  @Test
  public void test_2008_08_07_GEPIntToPtr_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2008-08-07-GEPIntToPtr.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2008-08-07-GEPIntToPtr.c -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2008-08-07-GEPIntToPtr.c
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm %s -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_2008_08_19_cast_of_typedef_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2008-08-19-cast-of-typedef.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm -o ${TEST_TEMP_DIR}/2008-08-19-cast-of-typedef.c.tmp ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2008-08-19-cast-of-typedef.c
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm -o %t %s");
  }

  @Test
  public void test_2008_09_03_WeakAlias_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2008-09-03-WeakAlias.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm -O1 -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2008-09-03-WeakAlias.c | grep icmp
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm -O1 -o - %s")./*|*/
      I("grep icmp");
  }

  @Test
  public void test_2008_09_22_bad_switch_type_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2008-09-22-bad-switch-type.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm -o ${TEST_TEMP_DIR}/2008-09-22-bad-switch-type.c.tmp ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2008-09-22-bad-switch-type.c
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm -o %t %s");
  }

  @Test
  public void test_2008_10_13_FrontendCrash_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2008-10-13-FrontendCrash.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2008-10-13-FrontendCrash.c -emit-llvm -o -
    RUN(TestState.Failed, "%clang_cc1 %s -emit-llvm -o -");
  }

  @Test
  public void test_2008_10_30_ZeroPlacement_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2008-10-30-ZeroPlacement.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2008-10-30-ZeroPlacement.c -o -
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm %s -o -");
  }

  @Test
  public void test_2008_11_02_WeakAlias_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2008-11-02-WeakAlias.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple=i686-pc-linux-gnu -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2008-11-02-WeakAlias.c | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2008-11-02-WeakAlias.c
    RUN(TestState.Failed, "%clang_cc1 -triple=i686-pc-linux-gnu -emit-llvm -o - %s")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_2008_11_08_InstCombineSelect_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2008-11-08-InstCombineSelect.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2008-11-08-InstCombineSelect.c -emit-llvm -O2 -o -
    RUN(TestState.Failed, "%clang_cc1 %s -emit-llvm -O2 -o -");
  }

  @Test
  public void test_2008_12_23_AsmIntPointerTie_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2008-12-23-AsmIntPointerTie.c");
    // REQUIRES: LP64
    if (!CHECK_REQUIRES("LP64")) {
      return;
    }
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2008-12-23-AsmIntPointerTie.c -emit-llvm -O1 -o -
    RUN(TestState.Failed, "%clang_cc1 %s -emit-llvm -O1 -o -");
  }

  @Test
  public void test_2009_01_05_BlockInlining_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2009-01-05-BlockInlining.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2009-01-05-BlockInlining.c -triple x86_64-linux -emit-llvm -fblocks -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2009-01-05-BlockInlining.c
    RUN(TestState.Failed, "%clang_cc1 %s -triple x86_64-linux -emit-llvm -fblocks -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_2009_01_21_InvalidIterator_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2009-01-21-InvalidIterator.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2009-01-21-InvalidIterator.c -emit-llvm -debug-info-kind=limited -o /dev/null
    RUN(TestState.Failed, "%clang_cc1 %s -emit-llvm -debug-info-kind=limited -o /dev/null");
  }

  @Test
  public void test_2009_02_13_zerosize_union_field_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2009-02-13-zerosize-union-field.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2009-02-13-zerosize-union-field.c -triple i686-apple-darwin -emit-llvm -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2009-02-13-zerosize-union-field.c
    RUN(TestState.Failed, "%clang_cc1 %s -triple i686-apple-darwin -emit-llvm -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_2009_02_13_zerosize_union_field_ppc_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2009-02-13-zerosize-union-field-ppc.c");
    // REQUIRES: powerpc-registered-target
    if (!CHECK_REQUIRES("powerpc-registered-target")) {
      return;
    }
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2009-02-13-zerosize-union-field-ppc.c -triple powerpc-pc-linux -emit-llvm -o - | grep {i32 32} | ${LLVM_SRC}/build/bin/count 3
    RUN(TestState.Failed, "%clang_cc1 %s -triple powerpc-pc-linux -emit-llvm -o -")./*|*/
      I("grep {i32 32}")./*|*/
      I("count 3");
  }

  @Test
  public void test_2009_03_01_MallocNoAlias_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2009-03-01-MallocNoAlias.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2009-03-01-MallocNoAlias.c -emit-llvm -o - | grep noalias
    RUN(TestState.Failed, "%clang_cc1 %s -emit-llvm -o -")./*|*/
      I("grep noalias");
  }

  @Test
  public void test_2009_03_08_ZeroEltStructCrash_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2009-03-08-ZeroEltStructCrash.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2009-03-08-ZeroEltStructCrash.c -o -
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm %s -o -");
  }

  @Test
  public void test_2009_03_13_dbg_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2009-03-13-dbg.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2009-03-13-dbg.c -emit-llvm -debug-info-kind=limited -o /dev/null
    RUN(TestState.Failed, "%clang_cc1 %s -emit-llvm -debug-info-kind=limited -o /dev/null");
  }

  @Test
  public void test_2009_03_22_increment_bitfield_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2009-03-22-increment-bitfield.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm -O1 < ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2009-03-22-increment-bitfield.c | grep 'ret i32 0'
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm -O1 < %s")./*|*/
      I("grep \"ret i32 0\"");
  }

  @Test
  public void test_2009_04_23_dbg_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2009-04-23-dbg.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -S -debug-info-kind=limited -o ${TEST_TEMP_DIR}/2009-04-23-dbg.c.tmp ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2009-04-23-dbg.c
    RUN(TestState.Failed, "%clang_cc1 -S -debug-info-kind=limited -o %t %s");
  }

  @Test
  public void test_2009_04_28_UnionArrayCrash_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2009-04-28-UnionArrayCrash.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2009-04-28-UnionArrayCrash.c -o -
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm %s -o -");
  }

  @Test
  public void test_2009_05_04_EnumInreg_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2009-05-04-EnumInreg.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm -triple i686-apple-darwin -mregparm 3 ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2009-05-04-EnumInreg.c -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2009-05-04-EnumInreg.c
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm -triple i686-apple-darwin -mregparm 3 %s -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_2009_05_22_callingconv_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2009-05-22-callingconv.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2009-05-22-callingconv.c -emit-llvm -o - -triple i386-unknown-unknown | grep call | grep x86_stdcallcc
    RUN(TestState.Failed, "%clang_cc1 %s -emit-llvm -o - -triple i386-unknown-unknown")./*|*/
      I("grep call")./*|*/
      I("grep x86_stdcallcc");
  }

  @Test
  public void test_2009_05_28_const_typedef_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2009-05-28-const-typedef.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2009-05-28-const-typedef.c -o -
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm %s -o -");
  }

  @Test
  public void test_2009_06_01_addrofknr_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2009-06-01-addrofknr.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2009-06-01-addrofknr.c -o ${TEST_TEMP_DIR}/2009-06-01-addrofknr.c.tmp -emit-llvm -verify
    RUN(TestState.Failed, "%clang_cc1 %s -o %t -emit-llvm -verify");
  }

  @Test
  public void test_2009_06_14_HighlyAligned_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2009-06-14-HighlyAligned.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2009-06-14-HighlyAligned.c -emit-llvm -o /dev/null
    RUN(TestState.Failed, "%clang_cc1 %s -emit-llvm -o /dev/null");
  }

  @Test
  public void test_2009_06_14_anonymous_union_init_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2009-06-14-anonymous-union-init.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm < ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2009-06-14-anonymous-union-init.c | grep 'zeroinitializer, i16 16877'
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm < %s")./*|*/
      I("grep \"zeroinitializer, i16 16877\"");
  }

  @Test
  public void test_2009_06_18_StaticInitTailPadPack_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2009-06-18-StaticInitTailPadPack.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2009-06-18-StaticInitTailPadPack.c -emit-llvm -o -
    RUN(TestState.Failed, "%clang_cc1 %s -emit-llvm -o -");
  }

  @Test
  public void test_2009_07_14_VoidPtr_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2009-07-14-VoidPtr.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2009-07-14-VoidPtr.c -o -
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm %s -o -");
  }

  @Test
  public void test_2009_07_15_pad_wchar_t_array_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2009-07-15-pad-wchar_t-array.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2009-07-15-pad-wchar_t-array.c -o /dev/null
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm %s  -o /dev/null");
  }

  @Test
  public void test_2009_07_22_StructLayout_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2009-07-22-StructLayout.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2009-07-22-StructLayout.c -triple i686-pc-linux-gnu -emit-llvm -o /dev/null
    RUN(TestState.Failed, "%clang_cc1 %s -triple i686-pc-linux-gnu -emit-llvm -o /dev/null");
  }

  @Test
  public void test_2009_07_31_DbgDeclare_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2009-07-31-DbgDeclare.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -S -debug-info-kind=limited -o ${TEST_TEMP_DIR}/2009-07-31-DbgDeclare.c.tmp.s ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2009-07-31-DbgDeclare.c
    RUN(TestState.Failed, "%clang_cc1 -S -debug-info-kind=limited -o %t.s %s");
  }

  @Test
  public void test_2009_08_14_vararray_crash_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2009-08-14-vararray-crash.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm < ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2009-08-14-vararray-crash.c
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm < %s");
  }

  @Test
  public void test_2009_09_24_SqrtErrno_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2009-09-24-SqrtErrno.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-apple-darwin ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2009-09-24-SqrtErrno.c -emit-llvm -o - -fmath-errno | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2009-09-24-SqrtErrno.c
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-apple-darwin %s -emit-llvm -o - -fmath-errno")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_2009_10_20_GlobalDebug_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2009-10-20-GlobalDebug.c");
    // REQUIRES: x86-registered-target
    if (!CHECK_REQUIRES("x86-registered-target")) {
      return;
    }
    // ${LLVM_SRC}/build/bin/clang -target i386-apple-darwin10 -flto -S -g ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2009-10-20-GlobalDebug.c -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2009-10-20-GlobalDebug.c
    RUN(TestState.Failed, "%clang -target i386-apple-darwin10 -flto -S -g %s -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_2009_12_07_BitFieldAlignment_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2009-12-07-BitFieldAlignment.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i686-apple-darwin ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2009-12-07-BitFieldAlignment.c -emit-llvm -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2009-12-07-BitFieldAlignment.c
    RUN(TestState.Failed, "%clang_cc1 -triple i686-apple-darwin %s -emit-llvm -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_2010_01_13_MemBarrier_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2010-01-13-MemBarrier.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2010-01-13-MemBarrier.c -emit-llvm -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2010-01-13-MemBarrier.c
    RUN(TestState.Failed, "%clang_cc1 %s -emit-llvm -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_2010_01_14_FnType_DebugInfo_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2010-01-14-FnType-DebugInfo.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2010-01-14-FnType-DebugInfo.c -emit-llvm -debug-info-kind=limited -o /dev/null
    RUN(TestState.Failed, "%clang_cc1 %s -emit-llvm -debug-info-kind=limited -o /dev/null");
  }

  @Test
  public void test_2010_01_18_Inlined_Debug_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2010-01-18-Inlined-Debug.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -debug-info-kind=limited -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2010-01-18-Inlined-Debug.c -o /dev/null
    RUN(TestState.Failed, "%clang_cc1 -debug-info-kind=limited -emit-llvm %s -o /dev/null");
  }

  @Test
  public void test_2010_02_10_PointerName_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2010-02-10-PointerName.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2010-02-10-PointerName.c -emit-llvm -debug-info-kind=limited -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2010-02-10-PointerName.c
    RUN(TestState.Failed, "%clang_cc1 %s -emit-llvm -debug-info-kind=limited -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_2010_02_15_DbgStaticVar_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2010-02-15-DbgStaticVar.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -debug-info-kind=limited -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2010-02-15-DbgStaticVar.c -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2010-02-15-DbgStaticVar.c
    RUN(TestState.Failed, "%clang_cc1 -debug-info-kind=limited -emit-llvm %s -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_2010_02_16_DbgScopes_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2010-02-16-DbgScopes.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm -debug-info-kind=limited < ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2010-02-16-DbgScopes.c | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2010-02-16-DbgScopes.c
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm -debug-info-kind=limited < %s")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_2010_02_18_Dbg_VectorType_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2010-02-18-Dbg-VectorType.c");
    // ${LLVM_SRC}/build/bin/clang -emit-llvm -S -O0 -g ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2010-02-18-Dbg-VectorType.c -o - | grep DW_TAG_typedef | grep float4
    RUN(TestState.Failed, "%clang -emit-llvm -S -O0 -g %s -o -")./*|*/
      I("grep DW_TAG_typedef")./*|*/
      I("grep float4");
  }

  @Test
  public void test_2010_03_09_DbgInfo_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2010-03-09-DbgInfo.c");
    // ${LLVM_SRC}/build/bin/clang -emit-llvm -S -O0 -g ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2010-03-09-DbgInfo.c -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2010-03-09-DbgInfo.c
    RUN(TestState.Failed, "%clang -emit-llvm -S -O0 -g %s -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_2010_03_5_LexicalScope_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2010-03-5-LexicalScope.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm -debug-info-kind=limited ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2010-03-5-LexicalScope.c -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2010-03-5-LexicalScope.c
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm -debug-info-kind=limited %s -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_2010_05_26_AsmSideEffect_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2010-05-26-AsmSideEffect.c");
    // REQUIRES: arm-registered-target
    if (!CHECK_REQUIRES("arm-registered-target")) {
      return;
    }
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2010-05-26-AsmSideEffect.c -emit-llvm -triple arm-apple-darwin -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2010-05-26-AsmSideEffect.c
    RUN(TestState.Failed, "%clang_cc1 %s -emit-llvm -triple arm-apple-darwin -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_2010_06_11_SaveExpr_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2010-06-11-SaveExpr.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2010-06-11-SaveExpr.c -o -
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm %s -o -");
  }

  @Test
  public void test_2010_06_17_asmcrash_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2010-06-17-asmcrash.c");
    // REQUIRES: x86-registered-target
    if (!CHECK_REQUIRES("x86-registered-target")) {
      return;
    }
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-unknown-unknown -O1 -no-integrated-as -S -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2010-06-17-asmcrash.c | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2010-06-17-asmcrash.c
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-unknown-unknown -O1 -no-integrated-as -S -o - %s")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_2010_07_08_DeclDebugLineNo_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2010-07-08-DeclDebugLineNo.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm -debug-info-kind=limited ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2010-07-08-DeclDebugLineNo.c -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2010-07-08-DeclDebugLineNo.c
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm -debug-info-kind=limited %s -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_2010_07_14_overconservative_align_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2010-07-14-overconservative-align.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2010-07-14-overconservative-align.c -triple x86_64-apple-darwin -emit-llvm -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2010-07-14-overconservative-align.c
    RUN(TestState.Failed, "%clang_cc1 %s -triple x86_64-apple-darwin -emit-llvm -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_2010_07_14_ref_off_end_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2010-07-14-ref-off-end.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2010-07-14-ref-off-end.c -emit-llvm -triple i386-apple-darwin -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2010-07-14-ref-off-end.c
    RUN(TestState.Failed, "%clang_cc1 %s -emit-llvm -triple i386-apple-darwin -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_2010_08_10_DbgConstant_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2010-08-10-DbgConstant.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -S -emit-llvm -debug-info-kind=limited ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2010-08-10-DbgConstant.c -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2010-08-10-DbgConstant.c
    RUN(TestState.Failed, "%clang_cc1 -S -emit-llvm -debug-info-kind=limited  %s -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_2010_08_12_asm_aggr_arg_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2010-08-12-asm-aggr-arg.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2010-08-12-asm-aggr-arg.c -emit-llvm -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2010-08-12-asm-aggr-arg.c
    RUN(TestState.Failed, "%clang_cc1 %s -emit-llvm -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_2010_12_01_CommonGlobal_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2010-12-01-CommonGlobal.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2010-12-01-CommonGlobal.c -o /dev/null
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm %s  -o /dev/null");
  }

  @Test
  public void test_2011_02_21_DATA_common_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2011-02-21-DATA-common.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2011-02-21-DATA-common.c -o /dev/null
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm %s -o /dev/null");
  }

  @Test
  public void test_2011_03_02_UnionInitializer_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2011-03-02-UnionInitializer.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2011-03-02-UnionInitializer.c -o -
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm %s -o -");
  }

  @Test
  public void test_2011_03_08_ZeroFieldUnionInitializer_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2011-03-08-ZeroFieldUnionInitializer.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2011-03-08-ZeroFieldUnionInitializer.c -o /dev/null
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm %s -o /dev/null");
  }

  @Test
  public void test_2011_03_31_ArrayRefFolding_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2011-03-31-ArrayRefFolding.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm -o - -triple i386-apple-darwin ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2011-03-31-ArrayRefFolding.c | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/2011-03-31-ArrayRefFolding.c
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm -o - -triple i386-apple-darwin %s")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_24_bit_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/24-bit.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-linux-gnu -emit-llvm -O0 -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/24-bit.c | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/24-bit.c
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-linux-gnu -emit-llvm -O0 -o - %s")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_3dnow_builtins_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/3dnow-builtins.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/3dnow-builtins.c -triple=x86_64-unknown-unknown -target-feature +3dnowa -emit-llvm -o - -Werror | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/3dnow-builtins.c -check-prefix=GCC -check-prefix=CHECK
    RUN(TestState.Failed, "%clang_cc1 %s -triple=x86_64-unknown-unknown -target-feature +3dnowa -emit-llvm -o - -Werror")./*|*/
      I("FileCheck %s -check-prefix=GCC -check-prefix=CHECK");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/3dnow-builtins.c -triple=x86_64-scei-ps4 -target-feature +3dnowa -emit-llvm -o - -Werror | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/3dnow-builtins.c -check-prefix=PS4 -check-prefix=CHECK
    RUN(TestState.Failed, "%clang_cc1 %s -triple=x86_64-scei-ps4 -target-feature +3dnowa -emit-llvm -o - -Werror")./*|*/
      I("FileCheck %s -check-prefix=PS4 -check-prefix=CHECK");
  }

  @Test
  public void test_Atomics_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/Atomics.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-apple-darwin -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/Atomics.c -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/Atomics.c
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-apple-darwin -emit-llvm %s -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_BasicInstrs_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/BasicInstrs.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/BasicInstrs.c -o -
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm %s -o -");
  }

  @Test
  public void test_CFStrings_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/CFStrings.c");
    // REQUIRES: arm-registered-target,x86-registered-target
    if (!CHECK_REQUIRES("arm-registered-target,x86-registered-target")) {
      return;
    }
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple thumbv7-windows -S -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/CFStrings.c -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/CFStrings.c -check-prefix CHECK-COFF
    RUN(TestState.Failed, "%clang_cc1 -triple thumbv7-windows -S -emit-llvm %s -o -")./*|*/
      I("FileCheck %s -check-prefix CHECK-COFF");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i686-windows -S -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/CFStrings.c -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/CFStrings.c -check-prefix CHECK-COFF
    RUN(TestState.Failed, "%clang_cc1 -triple i686-windows -S -emit-llvm %s -o -")./*|*/
      I("FileCheck %s -check-prefix CHECK-COFF");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-windows -S -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/CFStrings.c -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/CFStrings.c -check-prefix CHECK-COFF
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-windows -S -emit-llvm %s -o -")./*|*/
      I("FileCheck %s -check-prefix CHECK-COFF");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple armv7-elf -S -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/CFStrings.c -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/CFStrings.c -check-prefix CHECK-ELF -check-prefix CHECK-ELF32
    RUN(TestState.Failed, "%clang_cc1 -triple armv7-elf -S -emit-llvm %s -o -")./*|*/
      I("FileCheck %s -check-prefix CHECK-ELF -check-prefix CHECK-ELF32");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i686-elf -S -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/CFStrings.c -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/CFStrings.c -check-prefix CHECK-ELF -check-prefix CHECK-ELF32
    RUN(TestState.Failed, "%clang_cc1 -triple i686-elf -S -emit-llvm %s -o -")./*|*/
      I("FileCheck %s -check-prefix CHECK-ELF -check-prefix CHECK-ELF32");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-elf -S -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/CFStrings.c -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/CFStrings.c -check-prefix CHECK-ELF -check-prefix CHECK-ELF64
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-elf -S -emit-llvm %s -o -")./*|*/
      I("FileCheck %s -check-prefix CHECK-ELF -check-prefix CHECK-ELF64");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple armv7-elf -S ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/CFStrings.c -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/CFStrings.c -check-prefix CHECK-ELF-DATA-SECTION
    RUN(TestState.Failed, "%clang_cc1 -triple armv7-elf -S %s -o -")./*|*/
      I("FileCheck %s -check-prefix CHECK-ELF-DATA-SECTION");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple armv7-macho -S -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/CFStrings.c -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/CFStrings.c -check-prefix CHECK-MACHO -check-prefix CHECK-MACHO32
    RUN(TestState.Failed, "%clang_cc1 -triple armv7-macho -S -emit-llvm %s -o -")./*|*/
      I("FileCheck %s -check-prefix CHECK-MACHO -check-prefix CHECK-MACHO32");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i386-apple-macosx -S -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/CFStrings.c -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/CFStrings.c -check-prefix CHECK-MACHO -check-prefix CHECK-MACHO32
    RUN(TestState.Failed, "%clang_cc1 -triple i386-apple-macosx -S -emit-llvm %s -o -")./*|*/
      I("FileCheck %s -check-prefix CHECK-MACHO -check-prefix CHECK-MACHO32");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-macho -S -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/CFStrings.c -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/CFStrings.c -check-prefix CHECK-MACHO -check-prefix CHECK-MACHO64
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-macho -S -emit-llvm %s -o -")./*|*/
      I("FileCheck %s -check-prefix CHECK-MACHO -check-prefix CHECK-MACHO64");
  }

  @Test
  public void test_Nontemporal_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/Nontemporal.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-apple-darwin -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/Nontemporal.cpp -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/Nontemporal.cpp
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-apple-darwin -emit-llvm %s -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_OpaqueStruct_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/OpaqueStruct.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/OpaqueStruct.c -emit-llvm -o ${TEST_TEMP_DIR}/OpaqueStruct.c.tmp
    RUN(TestState.Failed, "%clang_cc1 %s -emit-llvm -o %t");
  }

  @Test
  public void test_PR15826_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/PR15826.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -verify -emit-llvm-only ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/PR15826.c -o ${TEST_TEMP_DIR}/PR15826.c.tmp
    RUN(TestState.Failed, "%clang_cc1 -verify -emit-llvm-only %s -o %t");
  }

  @Test
  public void test_PR2001_bitfield_reload_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/PR2001-bitfield-reload.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i386-unknown-unknown -O3 -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/PR2001-bitfield-reload.c | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/PR2001-bitfield-reload.c
    RUN(TestState.Failed, "%clang_cc1 -triple i386-unknown-unknown -O3 -emit-llvm -o - %s")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_PR2413_void_address_cast_error_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/PR2413-void-address-cast-error.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/PR2413-void-address-cast-error.c -o -
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm %s -o -");
  }

  @Test
  public void test_PR2643_null_store_to_bitfield_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/PR2643-null-store-to-bitfield.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/PR2643-null-store-to-bitfield.c
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm -o - %s");
  }

  @Test
  public void test_PR2743_reference_missing_static_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/PR2743-reference-missing-static.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm -o ${TEST_TEMP_DIR}/PR2743-reference-missing-static.c.tmp ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/PR2743-reference-missing-static.c
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm -o %t %s");
  }

  @Test
  public void test_PR3130_cond_constant_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/PR3130-cond-constant.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/PR3130-cond-constant.c -o -
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm %s -o -");
  }

  @Test
  public void test_PR3589_freestanding_libcalls_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/PR3589-freestanding-libcalls.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i386-unknown-unknown -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/PR3589-freestanding-libcalls.c -o - | grep 'declare i32 @printf' | ${LLVM_SRC}/build/bin/count 1
    RUN(TestState.Failed, "%clang_cc1 -triple i386-unknown-unknown -emit-llvm %s -o -")./*|*/
      I("grep 'declare i32 @printf'")./*|*/
      I("count 1");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i386-unknown-unknown -O2 -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/PR3589-freestanding-libcalls.c -o - | grep 'declare i32 @puts' | ${LLVM_SRC}/build/bin/count 1
    RUN(TestState.Failed, "%clang_cc1 -triple i386-unknown-unknown -O2 -emit-llvm %s -o -")./*|*/
      I("grep 'declare i32 @puts'")./*|*/
      I("count 1");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i386-unknown-unknown -ffreestanding -O2 -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/PR3589-freestanding-libcalls.c -o - | not grep 'declare i32 @puts'
    RUN(TestState.Failed, "%clang_cc1 -triple i386-unknown-unknown -ffreestanding -O2 -emit-llvm %s -o -")./*|*/
      I("not grep 'declare i32 @puts'");
  }

  @Test
  public void test_PR3613_static_decl_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/PR3613-static-decl.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i386-unknown-unknown -emit-llvm -o ${TEST_TEMP_DIR}/PR3613-static-decl.c.tmp ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/PR3613-static-decl.c
    RUN(TestState.Failed, "%clang_cc1 -triple i386-unknown-unknown -emit-llvm -o %t %s");
    // grep '@g0 = internal global %.truct.s0 { i32 3 }' ${TEST_TEMP_DIR}/PR3613-static-decl.c.tmp | ${LLVM_SRC}/build/bin/count 1
    RUN(TestState.Failed, "grep '@g0 = internal global %.truct.s0 { i32 3 }' %t")./*|*/
      I("count 1");
  }

  @Test
  public void test_PR3709_int_to_pointer_sign_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/PR3709-int-to-pointer-sign.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/PR3709-int-to-pointer-sign.c -o - -O1 -triple=x86_64-gnu-linux | grep 'i64 -1'
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm %s -o - -O1 -triple=x86_64-gnu-linux")./*|*/
      I("grep \"i64 -1\"");
  }

  @Test
  public void test_PR4611_bitfield_layout_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/PR4611-bitfield-layout.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i386-unknown-unknown ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/PR4611-bitfield-layout.c -emit-llvm -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/PR4611-bitfield-layout.c
    RUN(TestState.Failed, "%clang_cc1 -triple i386-unknown-unknown %s -emit-llvm -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_PR5060_align_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/PR5060-align.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/PR5060-align.c -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/PR5060-align.c
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm %s -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_PR8880_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/PR8880.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -Wno-gcc-compat -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/PR8880.c | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/PR8880.c
    RUN(TestState.Failed, "%clang_cc1 -Wno-gcc-compat -emit-llvm -o - %s")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test__Bool_conversion_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/_Bool-conversion.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i386 -emit-llvm -O2 -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/_Bool-conversion.c | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/_Bool-conversion.c
    RUN(TestState.Failed, "%clang_cc1 -triple i386 -emit-llvm -O2 -o - %s")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_aarch64_arguments_hfa_v3_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/aarch64-arguments-hfa-v3.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple arm64-apple-ios -target-feature +neon -target-abi darwinpcs -fallow-half-arguments-and-returns -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/aarch64-arguments-hfa-v3.c | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/aarch64-arguments-hfa-v3.c
    RUN(TestState.Failed, "%clang_cc1 -triple arm64-apple-ios -target-feature +neon -target-abi darwinpcs -fallow-half-arguments-and-returns -emit-llvm -o - %s")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_aarch64_fix_cortex_a53_835769_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/aarch64-fix-cortex-a53-835769.c");
    // REQUIRES: aarch64-registered-target
    if (!CHECK_REQUIRES("aarch64-registered-target")) {
      return;
    }
    // ${LLVM_SRC}/build/bin/clang -O3 -target aarch64-linux-eabi ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/aarch64-fix-cortex-a53-835769.c -S -o- | ${LLVM_SRC}/build/bin/FileCheck --check-prefix=CHECK-NO --check-prefix=CHECK ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/aarch64-fix-cortex-a53-835769.c
    RUN(TestState.Failed, "%clang -O3 -target aarch64-linux-eabi %s -S -o-")./*|*/
      I("FileCheck --check-prefix=CHECK-NO --check-prefix=CHECK %s");
    // ${LLVM_SRC}/build/bin/clang -O3 -target aarch64-linux-eabi -mfix-cortex-a53-835769 ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/aarch64-fix-cortex-a53-835769.c -S -o- 2>&1 | ${LLVM_SRC}/build/bin/FileCheck --check-prefix=CHECK-YES --check-prefix=CHECK ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/aarch64-fix-cortex-a53-835769.c
    RUN(TestState.Failed, "%clang -O3 -target aarch64-linux-eabi -mfix-cortex-a53-835769 %s -S -o- 2>&1")./*|*/
      I("FileCheck --check-prefix=CHECK-YES --check-prefix=CHECK %s");
    // ${LLVM_SRC}/build/bin/clang -O3 -target aarch64-linux-eabi -mno-fix-cortex-a53-835769 ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/aarch64-fix-cortex-a53-835769.c -S -o- 2>&1 | ${LLVM_SRC}/build/bin/FileCheck --check-prefix=CHECK-NO --check-prefix=CHECK ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/aarch64-fix-cortex-a53-835769.c
    RUN(TestState.Failed, "%clang -O3 -target aarch64-linux-eabi -mno-fix-cortex-a53-835769 %s -S -o- 2>&1")./*|*/
      I("FileCheck --check-prefix=CHECK-NO --check-prefix=CHECK %s");
    // ${LLVM_SRC}/build/bin/clang -O3 -target aarch64-android-eabi ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/aarch64-fix-cortex-a53-835769.c -S -o- | ${LLVM_SRC}/build/bin/FileCheck --check-prefix=CHECK-YES --check-prefix=CHECK ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/aarch64-fix-cortex-a53-835769.c
    RUN(TestState.Failed, "%clang -O3 -target aarch64-android-eabi %s -S -o-")./*|*/
      I("FileCheck --check-prefix=CHECK-YES --check-prefix=CHECK %s");
    // ${LLVM_SRC}/build/bin/clang -O3 -target aarch64-android-eabi -mfix-cortex-a53-835769 ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/aarch64-fix-cortex-a53-835769.c -S -o- | ${LLVM_SRC}/build/bin/FileCheck --check-prefix=CHECK-YES --check-prefix=CHECK ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/aarch64-fix-cortex-a53-835769.c
    RUN(TestState.Failed, "%clang -O3 -target aarch64-android-eabi -mfix-cortex-a53-835769 %s -S -o-")./*|*/
      I("FileCheck --check-prefix=CHECK-YES --check-prefix=CHECK %s");
    // ${LLVM_SRC}/build/bin/clang -O3 -target aarch64-android-eabi -mno-fix-cortex-a53-835769 ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/aarch64-fix-cortex-a53-835769.c -S -o- | ${LLVM_SRC}/build/bin/FileCheck --check-prefix=CHECK-NO --check-prefix=CHECK ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/aarch64-fix-cortex-a53-835769.c
    RUN(TestState.Failed, "%clang -O3 -target aarch64-android-eabi -mno-fix-cortex-a53-835769 %s -S -o-")./*|*/
      I("FileCheck --check-prefix=CHECK-NO --check-prefix=CHECK %s");
  }

  @Test
  public void test_aarch64_inline_asm_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/aarch64-inline-asm.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple arm64-none-linux-gnu -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/aarch64-inline-asm.c | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/aarch64-inline-asm.c
    RUN(TestState.Failed, "%clang_cc1 -triple arm64-none-linux-gnu -emit-llvm -o - %s")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_aarch64_neon_2velem_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/aarch64-neon-2velem.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple arm64-none-linux-gnu -target-feature +neon -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/aarch64-neon-2velem.c | opt -S -mem2reg | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/aarch64-neon-2velem.c
    RUN(TestState.Failed, "%clang_cc1 -triple arm64-none-linux-gnu -target-feature +neon -emit-llvm -o - %s")./*|*/
      I("opt -S -mem2reg")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_aarch64_neon_3v_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/aarch64-neon-3v.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple arm64-none-linux-gnu -target-feature +neon -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/aarch64-neon-3v.c | opt -S -mem2reg | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/aarch64-neon-3v.c
    RUN(TestState.Failed, "%clang_cc1 -triple arm64-none-linux-gnu -target-feature +neon -emit-llvm -o - %s")./*|*/
      I("opt -S -mem2reg")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_aarch64_neon_across_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/aarch64-neon-across.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple arm64-none-linux-gnu -target-feature +neon -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/aarch64-neon-across.c | opt -S -mem2reg | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/aarch64-neon-across.c
    RUN(TestState.Failed, "%clang_cc1 -triple arm64-none-linux-gnu -target-feature +neon -emit-llvm -o - %s")./*|*/
      I("opt -S -mem2reg")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_aarch64_neon_extract_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/aarch64-neon-extract.c");
    // REQUIRES: aarch64-registered-target
    if (!CHECK_REQUIRES("aarch64-registered-target")) {
      return;
    }
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple arm64-none-linux-gnu -target-feature +neon -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/aarch64-neon-extract.c | opt -S -mem2reg | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/aarch64-neon-extract.c
    RUN(TestState.Failed, "%clang_cc1 -triple arm64-none-linux-gnu -target-feature +neon -emit-llvm -o - %s")./*|*/
      I("opt -S -mem2reg")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_aarch64_neon_fcvt_intrinsics_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/aarch64-neon-fcvt-intrinsics.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple arm64-none-linux-gnu -target-feature +neon -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/aarch64-neon-fcvt-intrinsics.c | opt -S -mem2reg | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/aarch64-neon-fcvt-intrinsics.c
    RUN(TestState.Failed, "%clang_cc1 -triple arm64-none-linux-gnu -target-feature +neon -emit-llvm -o - %s")./*|*/
      I("opt -S -mem2reg")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_aarch64_neon_fma_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/aarch64-neon-fma.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple arm64-none-linux-gnu -target-feature +neon -S -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/aarch64-neon-fma.c | opt -S -mem2reg | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/aarch64-neon-fma.c
    RUN(TestState.Failed, "%clang_cc1 -triple arm64-none-linux-gnu -target-feature +neon -S -emit-llvm -o - %s")./*|*/
      I("opt -S -mem2reg")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_aarch64_neon_intrinsics_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/aarch64-neon-intrinsics.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple arm64-none-linux-gnu -target-feature +neon -fallow-half-arguments-and-returns -ffp-contract=fast -S -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/aarch64-neon-intrinsics.c | opt -S -mem2reg | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/aarch64-neon-intrinsics.c
    RUN(TestState.Failed, "%clang_cc1 -triple arm64-none-linux-gnu -target-feature +neon -fallow-half-arguments-and-returns -ffp-contract=fast -S -emit-llvm -o - %s")./*|*/
      I("opt -S -mem2reg")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_aarch64_neon_ldst_one_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/aarch64-neon-ldst-one.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple arm64-none-linux-gnu -target-feature +neon -fallow-half-arguments-and-returns -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/aarch64-neon-ldst-one.c | opt -S -mem2reg | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/aarch64-neon-ldst-one.c
    RUN(TestState.Failed, "%clang_cc1 -triple arm64-none-linux-gnu -target-feature +neon -fallow-half-arguments-and-returns -emit-llvm -o - %s")./*|*/
      I("opt -S -mem2reg")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_aarch64_neon_misc_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/aarch64-neon-misc.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple arm64-none-linux-gnu -target-feature +neon -fallow-half-arguments-and-returns -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/aarch64-neon-misc.c | opt -S -mem2reg | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/aarch64-neon-misc.c
    RUN(TestState.Failed, "%clang_cc1 -triple arm64-none-linux-gnu -target-feature +neon -fallow-half-arguments-and-returns -emit-llvm -o - %s")./*|*/
      I("opt -S -mem2reg")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_aarch64_neon_perm_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/aarch64-neon-perm.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple arm64-none-linux-gnu -target-feature +neon -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/aarch64-neon-perm.c | opt -S -mem2reg | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/aarch64-neon-perm.c
    RUN(TestState.Failed, "%clang_cc1 -triple arm64-none-linux-gnu -target-feature +neon -emit-llvm -o - %s")./*|*/
      I("opt -S -mem2reg")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_aarch64_neon_scalar_copy_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/aarch64-neon-scalar-copy.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple arm64-none-linux-gnu -target-feature +neon -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/aarch64-neon-scalar-copy.c | opt -S -mem2reg | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/aarch64-neon-scalar-copy.c
    RUN(TestState.Failed, "%clang_cc1 -triple arm64-none-linux-gnu -target-feature +neon -emit-llvm -o - %s")./*|*/
      I("opt -S -mem2reg")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_aarch64_neon_scalar_x_indexed_elem_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/aarch64-neon-scalar-x-indexed-elem.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple arm64-none-linux-gnu -target-feature +neon -target-cpu cyclone -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/aarch64-neon-scalar-x-indexed-elem.c | opt -S -mem2reg | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/aarch64-neon-scalar-x-indexed-elem.c
    RUN(TestState.Failed, "%clang_cc1 -triple arm64-none-linux-gnu -target-feature +neon -target-cpu cyclone -emit-llvm -o - %s")./*|*/
      I("opt -S -mem2reg")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_aarch64_neon_shifts_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/aarch64-neon-shifts.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple arm64-none-linux-gnu -target-feature +neon -ffp-contract=fast -S -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/aarch64-neon-shifts.c | opt -S -mem2reg | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/aarch64-neon-shifts.c
    RUN(TestState.Failed, "%clang_cc1 -triple arm64-none-linux-gnu -target-feature +neon -ffp-contract=fast -S -emit-llvm -o - %s")./*|*/
      I("opt -S -mem2reg")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_aarch64_neon_tbl_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/aarch64-neon-tbl.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple arm64-none-linux-gnu -target-feature +neon -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/aarch64-neon-tbl.c | opt -S -mem2reg | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/aarch64-neon-tbl.c
    RUN(TestState.Failed, "%clang_cc1 -triple arm64-none-linux-gnu -target-feature +neon -emit-llvm -o - %s")./*|*/
      I("opt -S -mem2reg")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_aarch64_neon_vcombine_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/aarch64-neon-vcombine.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple arm64-none-linux-gnu -target-feature +neon -fallow-half-arguments-and-returns -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/aarch64-neon-vcombine.c | opt -S -mem2reg | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/aarch64-neon-vcombine.c
    RUN(TestState.Failed, "%clang_cc1 -triple arm64-none-linux-gnu -target-feature +neon -fallow-half-arguments-and-returns -emit-llvm -o - %s")./*|*/
      I("opt -S -mem2reg")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_aarch64_neon_vget_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/aarch64-neon-vget.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple arm64-apple-darwin -target-feature +neon -fallow-half-arguments-and-returns -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/aarch64-neon-vget.c | opt -S -mem2reg | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/aarch64-neon-vget.c
    RUN(TestState.Failed, "%clang_cc1 -triple arm64-apple-darwin -target-feature +neon -fallow-half-arguments-and-returns -emit-llvm -o - %s")./*|*/
      I("opt -S -mem2reg")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_aarch64_neon_vget_hilo_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/aarch64-neon-vget-hilo.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple arm64-none-linux-gnu -target-feature +neon -fallow-half-arguments-and-returns -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/aarch64-neon-vget-hilo.c | opt -S -mem2reg | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/aarch64-neon-vget-hilo.c
    RUN(TestState.Failed, "%clang_cc1 -triple arm64-none-linux-gnu -target-feature +neon -fallow-half-arguments-and-returns -emit-llvm -o - %s")./*|*/
      I("opt -S -mem2reg")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_aarch64_poly128_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/aarch64-poly128.c");
    // REQUIRES: aarch64-registered-target
    if (!CHECK_REQUIRES("aarch64-registered-target")) {
      return;
    }
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple arm64-none-linux-gnu -target-feature +neon -ffp-contract=fast -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/aarch64-poly128.c | opt -S -mem2reg | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/aarch64-poly128.c
    RUN(TestState.Failed, "%clang_cc1 -triple arm64-none-linux-gnu -target-feature +neon -ffp-contract=fast -emit-llvm -o - %s")./*|*/
      I("opt -S -mem2reg")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_aarch64_poly64_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/aarch64-poly64.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple arm64-none-linux-gnu -target-feature +neon -ffp-contract=fast -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/aarch64-poly64.c | opt -S -mem2reg | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/aarch64-poly64.c
    RUN(TestState.Failed, "%clang_cc1 -triple arm64-none-linux-gnu -target-feature +neon -ffp-contract=fast -emit-llvm -o - %s")./*|*/
      I("opt -S -mem2reg")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_aarch64_type_sizes_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/aarch64-type-sizes.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple aarch64_be-none-linux-gnu -emit-llvm -w -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/aarch64-type-sizes.c | ${LLVM_SRC}/build/bin/FileCheck --check-prefix=CHECK ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/aarch64-type-sizes.c
    RUN(TestState.Failed, "%clang_cc1 -triple aarch64_be-none-linux-gnu -emit-llvm -w -o - %s")./*|*/
      I("FileCheck --check-prefix=CHECK %s");
  }

  @Test
  public void test_aarch64_v8_1a_neon_intrinsics_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/aarch64-v8.1a-neon-intrinsics.c");
    // REQUIRES: aarch64-registered-target
    if (!CHECK_REQUIRES("aarch64-registered-target")) {
      return;
    }
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple aarch64-linux-gnu -target-feature +neon -target-feature +v8.1a -S -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/aarch64-v8.1a-neon-intrinsics.c | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/aarch64-v8.1a-neon-intrinsics.c
    RUN(TestState.Failed, "%clang_cc1 -triple aarch64-linux-gnu -target-feature +neon -target-feature +v8.1a -S -emit-llvm -o - %s")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_aarch64_varargs_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/aarch64-varargs.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple arm64-linux-gnu -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/aarch64-varargs.c | ${LLVM_SRC}/build/bin/FileCheck --check-prefix=CHECK --check-prefix=CHECK-LE ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/aarch64-varargs.c
    RUN(TestState.Failed, "%clang_cc1 -triple arm64-linux-gnu -emit-llvm -o - %s")./*|*/
      I("FileCheck --check-prefix=CHECK --check-prefix=CHECK-LE %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple aarch64_be-linux-gnu -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/aarch64-varargs.c | ${LLVM_SRC}/build/bin/FileCheck --check-prefix=CHECK --check-prefix=CHECK-BE ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/aarch64-varargs.c
    RUN(TestState.Failed, "%clang_cc1 -triple aarch64_be-linux-gnu -emit-llvm -o - %s")./*|*/
      I("FileCheck --check-prefix=CHECK --check-prefix=CHECK-BE %s");
  }

  @Test
  public void test_adc_builtins_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/adc-builtins.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-unknown-unknown -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/adc-builtins.c | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/adc-builtins.c
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-unknown-unknown -emit-llvm -o - %s")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_address_safety_attr_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/address-safety-attr.cpp");
    // REQUIRES: shell
    if (!CHECK_REQUIRES("shell")) {
      return;
    }
    // echo 'int DefinedInDifferentFile(int *a) { return *a; }' > ${TEST_TEMP_DIR}/address-safety-attr.cpp.tmp.extra-source.cpp
    RUN(TestState.Failed, "echo \"int DefinedInDifferentFile(int *a) { return *a; }\" > %t.extra-source.cpp");
    // echo 'struct S { S(){} ~S(){} };' >> ${TEST_TEMP_DIR}/address-safety-attr.cpp.tmp.extra-source.cpp
    RUN(TestState.Failed, "echo \"struct S { S(){} ~S(){} };\" >> %t.extra-source.cpp");
    // echo 'S glob_array[5];' >> ${TEST_TEMP_DIR}/address-safety-attr.cpp.tmp.extra-source.cpp
    RUN(TestState.Failed, "echo \"S glob_array[5];\" >> %t.extra-source.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c++11 -triple x86_64-apple-darwin -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/address-safety-attr.cpp -include ${TEST_TEMP_DIR}/address-safety-attr.cpp.tmp.extra-source.cpp | ${LLVM_SRC}/build/bin/FileCheck -check-prefix=WITHOUT ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/address-safety-attr.cpp
    RUN(TestState.Failed, "%clang_cc1 -std=c++11 -triple x86_64-apple-darwin -emit-llvm -o - %s -include %t.extra-source.cpp")./*|*/
      I("FileCheck -check-prefix=WITHOUT %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c++11 -triple x86_64-apple-darwin -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/address-safety-attr.cpp -include ${TEST_TEMP_DIR}/address-safety-attr.cpp.tmp.extra-source.cpp -fsanitize=address | ${LLVM_SRC}/build/bin/FileCheck -check-prefix=ASAN ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/address-safety-attr.cpp
    RUN(TestState.Failed, "%clang_cc1 -std=c++11 -triple x86_64-apple-darwin -emit-llvm -o - %s -include %t.extra-source.cpp -fsanitize=address")./*|*/
      I("FileCheck -check-prefix=ASAN %s");
    // echo fun:*BlacklistedFunction* > ${TEST_TEMP_DIR}/address-safety-attr.cpp.tmp.func.blacklist
    RUN(TestState.Failed, "echo \"fun:*BlacklistedFunction*\" > %t.func.blacklist");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c++11 -triple x86_64-apple-darwin -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/address-safety-attr.cpp -include ${TEST_TEMP_DIR}/address-safety-attr.cpp.tmp.extra-source.cpp -fsanitize=address '-fsanitize-blacklist=${TEST_TEMP_DIR}/address-safety-attr.cpp.tmp.func.blacklist' | ${LLVM_SRC}/build/bin/FileCheck -check-prefix=BLFUNC ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/address-safety-attr.cpp
    RUN(TestState.Failed, "%clang_cc1 -std=c++11 -triple x86_64-apple-darwin -emit-llvm -o - %s -include %t.extra-source.cpp -fsanitize=address -fsanitize-blacklist=%t.func.blacklist")./*|*/
      I("FileCheck -check-prefix=BLFUNC %s");
    // echo 'src:${LLVM_SRC}/llvm/tools/clang/test/CodeGen/address-safety-attr.cpp' > ${TEST_TEMP_DIR}/address-safety-attr.cpp.tmp.file.blacklist
    RUN(TestState.Failed, "echo \"src:%s\" > %t.file.blacklist");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c++11 -triple x86_64-apple-darwin -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/address-safety-attr.cpp -include ${TEST_TEMP_DIR}/address-safety-attr.cpp.tmp.extra-source.cpp -fsanitize=address '-fsanitize-blacklist=${TEST_TEMP_DIR}/address-safety-attr.cpp.tmp.file.blacklist' | ${LLVM_SRC}/build/bin/FileCheck -check-prefix=BLFILE ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/address-safety-attr.cpp
    RUN(TestState.Failed, "%clang_cc1 -std=c++11 -triple x86_64-apple-darwin -emit-llvm -o - %s -include %t.extra-source.cpp -fsanitize=address -fsanitize-blacklist=%t.file.blacklist")./*|*/
      I("FileCheck -check-prefix=BLFILE %s");
  }

  @Test
  public void test_address_sanitizer_and_array_cookie_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/address-sanitizer-and-array-cookie.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-gnu-linux -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/address-sanitizer-and-array-cookie.cpp | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/address-sanitizer-and-array-cookie.cpp -check-prefix=PLAIN
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-gnu-linux -emit-llvm -o - %s")./*|*/
      I("FileCheck %s -check-prefix=PLAIN");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-gnu-linux -emit-llvm -o - -fsanitize=address ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/address-sanitizer-and-array-cookie.cpp | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/address-sanitizer-and-array-cookie.cpp -check-prefix=ASAN
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-gnu-linux -emit-llvm -o - -fsanitize=address %s")./*|*/
      I("FileCheck %s -check-prefix=ASAN");
  }

  @Test
  public void test_address_space_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/address-space.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-apple-darwin -emit-llvm < ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/address-space.c | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/address-space.c
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-apple-darwin -emit-llvm < %s")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_address_space_cast_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/address-space-cast.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm < ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/address-space-cast.c
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm < %s");
  }

  @Test
  public void test_address_space_compound_literal_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/address-space-compound-literal.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm < ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/address-space-compound-literal.c | grep 'internal addrspace(1) global i32 1'
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm < %s")./*|*/
      I("grep \"internal addrspace(1) global i32 1\"");
  }

  @Test
  public void test_address_space_field1_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/address-space-field1.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm -triple x86_64-apple-darwin10 < ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/address-space-field1.c -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/address-space-field1.c
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm -triple x86_64-apple-darwin10 < %s -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_adx_builtins_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/adx-builtins.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-unknown-unknown -ffreestanding -target-feature +adx -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/adx-builtins.c | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/adx-builtins.c
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-unknown-unknown -ffreestanding -target-feature +adx -emit-llvm -o - %s")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_alias_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/alias.c");
    // REQUIRES: arm-registered-target
    if (!CHECK_REQUIRES("arm-registered-target")) {
      return;
    }
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i386-pc-linux-gnu -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/alias.c | ${LLVM_SRC}/build/bin/FileCheck -check-prefix=CHECKBASIC ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/alias.c
    RUN(TestState.Failed, "%clang_cc1 -triple i386-pc-linux-gnu -emit-llvm -o - %s")./*|*/
      I("FileCheck -check-prefix=CHECKBASIC %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple armv7a-eabi -mfloat-abi hard -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/alias.c | ${LLVM_SRC}/build/bin/FileCheck -check-prefix=CHECKCC ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/alias.c
    RUN(TestState.Failed, "%clang_cc1 -triple armv7a-eabi -mfloat-abi hard -emit-llvm -o - %s")./*|*/
      I("FileCheck -check-prefix=CHECKCC %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple armv7a-eabi -mfloat-abi hard -S -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/alias.c | ${LLVM_SRC}/build/bin/FileCheck -check-prefix=CHECKASM ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/alias.c
    RUN(TestState.Failed, "%clang_cc1 -triple armv7a-eabi -mfloat-abi hard -S -o - %s")./*|*/
      I("FileCheck -check-prefix=CHECKASM %s");
  }

  @Test
  public void test_align_global_large_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/align-global-large.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -S -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/align-global-large.c -o - -triple i686-pc-gnu | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/align-global-large.c
    RUN(TestState.Failed, "%clang -cc1 -S -emit-llvm %s -o - -triple i686-pc-gnu")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_align_local_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/align-local.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm < ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/align-local.c | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/align-local.c
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm < %s")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_align_param_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/align-param.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm -triple i386-apple-macosx10.7.2 < ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/align-param.c | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/align-param.c
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm -triple i386-apple-macosx10.7.2 < %s")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_align_systemz_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/align-systemz.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple s390x-linux-gnu -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/align-systemz.c -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/align-systemz.c
    RUN(TestState.Failed, "%clang_cc1 -triple s390x-linux-gnu -emit-llvm %s -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_align_wasm_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/align-wasm.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple wasm32-unknown-unknown -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/align-wasm.c -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/align-wasm.c
    RUN(TestState.Failed, "%clang_cc1 -triple wasm32-unknown-unknown -emit-llvm %s -o -")./*|*/
      I("FileCheck %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple wasm64-unknown-unknown -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/align-wasm.c -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/align-wasm.c
    RUN(TestState.Failed, "%clang_cc1 -triple wasm64-unknown-unknown -emit-llvm %s -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_align_x68_64_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/align-x68_64.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-unknown-linux-gnu -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/align-x68_64.c -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/align-x68_64.c
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-unknown-linux-gnu -emit-llvm %s -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_align_value_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/align_value.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-unknown-unknown -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/align_value.cpp | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/align_value.cpp
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-unknown-unknown -emit-llvm -o - %s")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_alignment_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/alignment.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i386-unknown-linux-gnu -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/alignment.c -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/alignment.c
    RUN(TestState.Failed, "%clang_cc1 -triple i386-unknown-linux-gnu -emit-llvm %s -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_alignof_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/alignof.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i386-unknown-unknown -O1 -emit-llvm -o ${TEST_TEMP_DIR}/alignof.c.tmp ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/alignof.c
    RUN(TestState.Failed, "%clang_cc1 -triple i386-unknown-unknown -O1 -emit-llvm -o %t %s");
    // grep 'ret i32 4' ${TEST_TEMP_DIR}/alignof.c.tmp
    RUN(TestState.Failed, "grep 'ret i32 4' %t");
  }

  @Test
  public void test_alloca_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/alloca.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/alloca.c -o /dev/null
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm %s  -o /dev/null");
  }

  @Test
  public void test_altivec_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/altivec.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -faltivec -triple powerpc-unknown-unknown -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/altivec.c -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/altivec.c
    RUN(TestState.Failed, "%clang_cc1 -faltivec -triple powerpc-unknown-unknown -emit-llvm %s -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_always__inline_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/always-inline.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/always-inline.c -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/always-inline.c
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm %s -o -")./*|*/
      I("FileCheck %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fno-inline -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/always-inline.c -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/always-inline.c
    RUN(TestState.Failed, "%clang_cc1 -fno-inline -emit-llvm %s -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_always_inline_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/always_inline.c");
    // ${LLVM_SRC}/build/bin/clang -emit-llvm -S -o ${TEST_TEMP_DIR}/always_inline.c.tmp ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/always_inline.c
    RUN(TestState.Failed, "%clang -emit-llvm -S -o %t %s");
    // grep @f0 ${TEST_TEMP_DIR}/always_inline.c.tmp
    RUN(TestState.Failed, "not grep '@f0' %t");
    // grep 'call ' ${TEST_TEMP_DIR}/always_inline.c.tmp
    RUN(TestState.Failed, "not grep 'call ' %t");
    // ${LLVM_SRC}/build/bin/clang -mllvm -disable-llvm-optzns -emit-llvm -S -o ${TEST_TEMP_DIR}/always_inline.c.tmp ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/always_inline.c
    RUN(TestState.Failed, "%clang -mllvm -disable-llvm-optzns -emit-llvm -S -o %t %s");
    // grep @f0 ${TEST_TEMP_DIR}/always_inline.c.tmp | ${LLVM_SRC}/build/bin/count 2
    RUN(TestState.Failed, "grep '@f0' %t")./*|*/
      I("count 2");
  }

  @Test
  public void test_annotations_builtin_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/annotations-builtin.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/annotations-builtin.c | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/annotations-builtin.c
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm -o - %s")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_annotations_field_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/annotations-field.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/annotations-field.c | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/annotations-field.c
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm -o - %s")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_annotations_global_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/annotations-global.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/annotations-global.c -emit-llvm -o ${TEST_TEMP_DIR}/annotations-global.c.tmp1
    RUN(TestState.Failed, "%clang_cc1 %s -emit-llvm -o %t1");
    // ${LLVM_SRC}/build/bin/FileCheck --check-prefix=FOO ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/annotations-global.c < ${TEST_TEMP_DIR}/annotations-global.c.tmp1
    RUN(TestState.Failed, "FileCheck --check-prefix=FOO %s < %t1");
    // ${LLVM_SRC}/build/bin/FileCheck --check-prefix=A ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/annotations-global.c < ${TEST_TEMP_DIR}/annotations-global.c.tmp1
    RUN(TestState.Failed, "FileCheck --check-prefix=A %s < %t1");
    // ${LLVM_SRC}/build/bin/FileCheck --check-prefix=BAR ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/annotations-global.c < ${TEST_TEMP_DIR}/annotations-global.c.tmp1
    RUN(TestState.Failed, "FileCheck --check-prefix=BAR %s < %t1");
    // ${LLVM_SRC}/build/bin/FileCheck --check-prefix=FOOS ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/annotations-global.c < ${TEST_TEMP_DIR}/annotations-global.c.tmp1
    RUN(TestState.Failed, "FileCheck --check-prefix=FOOS %s < %t1");
  }

  @Test
  public void test_annotations_loc_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/annotations-loc.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/annotations-loc.c | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/annotations-loc.c
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm -o - %s")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_annotations_var_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/annotations-var.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-apple-darwin10 -emit-llvm -o ${TEST_TEMP_DIR}/annotations-var.c.tmp1 ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/annotations-var.c
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-apple-darwin10 -emit-llvm -o %t1 %s");
    // ${LLVM_SRC}/build/bin/FileCheck --check-prefix=LOCAL ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/annotations-var.c < ${TEST_TEMP_DIR}/annotations-var.c.tmp1
    RUN(TestState.Failed, "FileCheck --check-prefix=LOCAL %s < %t1");
    // ${LLVM_SRC}/build/bin/FileCheck --check-prefix=UNDEF ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/annotations-var.c < ${TEST_TEMP_DIR}/annotations-var.c.tmp1
    RUN(TestState.Failed, "FileCheck --check-prefix=UNDEF %s < %t1");
    // ${LLVM_SRC}/build/bin/FileCheck --check-prefix=PARAM ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/annotations-var.c < ${TEST_TEMP_DIR}/annotations-var.c.tmp1
    RUN(TestState.Failed, "FileCheck --check-prefix=PARAM %s < %t1");
  }

  @Test
  public void test_arm_aapcs_vfp_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/arm-aapcs-vfp.c");
    // REQUIRES: arm-registered-target
    if (!CHECK_REQUIRES("arm-registered-target")) {
      return;
    }
    // REQUIRES: aarch64-registered-target
    if (!CHECK_REQUIRES("aarch64-registered-target")) {
      return;
    }
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple thumbv7-apple-darwin9 -target-abi aapcs -target-cpu cortex-a8 -mfloat-abi hard -ffreestanding -emit-llvm -w -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/arm-aapcs-vfp.c | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/arm-aapcs-vfp.c
    RUN(TestState.Failed, "%clang_cc1 -triple thumbv7-apple-darwin9 -target-abi aapcs -target-cpu cortex-a8 -mfloat-abi hard -ffreestanding -emit-llvm -w -o - %s")./*|*/
      I("FileCheck %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple armv7-unknown-nacl-gnueabi -target-cpu cortex-a8 -mfloat-abi hard -ffreestanding -emit-llvm -w -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/arm-aapcs-vfp.c | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/arm-aapcs-vfp.c
    RUN(TestState.Failed, "%clang_cc1 -triple armv7-unknown-nacl-gnueabi -target-cpu cortex-a8 -mfloat-abi hard -ffreestanding -emit-llvm -w -o - %s")./*|*/
      I("FileCheck %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple arm64-apple-darwin9 -target-feature +neon -ffreestanding -emit-llvm -w -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/arm-aapcs-vfp.c | ${LLVM_SRC}/build/bin/FileCheck -check-prefix=CHECK64 ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/arm-aapcs-vfp.c
    RUN(TestState.Failed, "%clang_cc1 -triple arm64-apple-darwin9 -target-feature +neon -ffreestanding -emit-llvm -w -o - %s")./*|*/
      I("FileCheck -check-prefix=CHECK64 %s");
  }

  @Test
  public void test_arm_aapcs_zerolength_bitfield_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/arm-aapcs-zerolength-bitfield.c");
    // REQUIRES: arm-registered-target
    if (!CHECK_REQUIRES("arm-registered-target")) {
      return;
    }
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -target-abi aapcs -triple armv7-apple-darwin10 ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/arm-aapcs-zerolength-bitfield.c -verify
    RUN(TestState.Failed, "%clang_cc1 -target-abi aapcs -triple armv7-apple-darwin10 %s -verify");
  }

  @Test
  public void test_arm_abi_vector_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/arm-abi-vector.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple armv7-apple-darwin -target-abi aapcs -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/arm-abi-vector.c | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/arm-abi-vector.c
    RUN(TestState.Failed, "%clang_cc1 -triple armv7-apple-darwin -target-abi aapcs -emit-llvm -o - %s")./*|*/
      I("FileCheck %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple armv7-apple-darwin -target-abi apcs-gnu -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/arm-abi-vector.c | ${LLVM_SRC}/build/bin/FileCheck -check-prefix=APCS-GNU ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/arm-abi-vector.c
    RUN(TestState.Failed, "%clang_cc1 -triple armv7-apple-darwin -target-abi apcs-gnu -emit-llvm -o - %s")./*|*/
      I("FileCheck -check-prefix=APCS-GNU %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple arm-linux-androideabi -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/arm-abi-vector.c | ${LLVM_SRC}/build/bin/FileCheck -check-prefix=ANDROID ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/arm-abi-vector.c
    RUN(TestState.Failed, "%clang_cc1 -triple arm-linux-androideabi -emit-llvm -o - %s")./*|*/
      I("FileCheck -check-prefix=ANDROID %s");
  }

  @Test
  public void test_arm_apcs_zerolength_bitfield_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/arm-apcs-zerolength-bitfield.c");
    // REQUIRES: arm-registered-target
    if (!CHECK_REQUIRES("arm-registered-target")) {
      return;
    }
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -target-abi apcs-gnu -triple armv7-apple-darwin10 ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/arm-apcs-zerolength-bitfield.c -verify
    RUN(TestState.Failed, "%clang_cc1 -target-abi apcs-gnu -triple armv7-apple-darwin10 %s -verify");
  }

  @Test
  public void test_arm_arguments_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/arm-arguments.c");
    // REQUIRES: arm-registered-target
    if (!CHECK_REQUIRES("arm-registered-target")) {
      return;
    }
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple armv7-apple-darwin9 -target-feature +neon -target-abi apcs-gnu -emit-llvm -w -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/arm-arguments.c | ${LLVM_SRC}/build/bin/FileCheck -check-prefix=APCS-GNU ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/arm-arguments.c
    RUN(TestState.Failed, "%clang_cc1 -triple armv7-apple-darwin9 -target-feature +neon -target-abi apcs-gnu -emit-llvm -w -o - %s")./*|*/
      I("FileCheck -check-prefix=APCS-GNU %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple armv7-apple-darwin9 -target-feature +neon -target-abi aapcs -emit-llvm -w -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/arm-arguments.c | ${LLVM_SRC}/build/bin/FileCheck -check-prefix=AAPCS ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/arm-arguments.c
    RUN(TestState.Failed, "%clang_cc1 -triple armv7-apple-darwin9 -target-feature +neon -target-abi aapcs -emit-llvm -w -o - %s")./*|*/
      I("FileCheck -check-prefix=AAPCS %s");
  }

  @Test
  public void test_arm_asm_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/arm-asm.c");
    // REQUIRES: arm-registered-target
    if (!CHECK_REQUIRES("arm-registered-target")) {
      return;
    }
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple thumb ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/arm-asm.c -emit-llvm -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/arm-asm.c
    RUN(TestState.Failed, "%clang_cc1 -triple thumb %s -emit-llvm -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_arm_asm_deprecated_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/arm-asm-deprecated.c");
    // REQUIRES: arm-registered-target
    if (!CHECK_REQUIRES("arm-registered-target")) {
      return;
    }
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple armv8 -target-feature +neon ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/arm-asm-deprecated.c -S -o /dev/null -verify -DWARN
    RUN(TestState.Failed, "%clang_cc1 -triple armv8 -target-feature +neon %s -S -o /dev/null -verify -DWARN");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple armv8 -target-feature +neon ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/arm-asm-deprecated.c -S -o /dev/null -Werror -verify
    RUN(TestState.Failed, "%clang_cc1 -triple armv8 -target-feature +neon %s -S -o /dev/null -Werror -verify");
  }

  @Test
  public void test_arm_asm_diag_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/arm-asm-diag.c");
    // REQUIRES: arm-registered-target
    if (!CHECK_REQUIRES("arm-registered-target")) {
      return;
    }
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple armv7 -target-feature +neon ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/arm-asm-diag.c -S -o /dev/null 2>&1 | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/arm-asm-diag.c
    RUN(TestState.Failed, "not %clang_cc1 -triple armv7 -target-feature +neon %s -S -o /dev/null 2>&1")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_arm_asm_variable_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/arm-asm-variable.c");
    // REQUIRES: arm-registered-target
    if (!CHECK_REQUIRES("arm-registered-target")) {
      return;
    }
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple armv7-apple-darwin9 -emit-llvm -w -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/arm-asm-variable.c | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/arm-asm-variable.c
    RUN(TestState.Failed, "%clang_cc1 -triple armv7-apple-darwin9 -emit-llvm -w -o - %s")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_arm_asm_warn_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/arm-asm-warn.c");
    // REQUIRES: arm-registered-target
    if (!CHECK_REQUIRES("arm-registered-target")) {
      return;
    }
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple armv7 -target-feature +neon ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/arm-asm-warn.c -emit-llvm -o /dev/null
    RUN(TestState.Failed, "%clang_cc1 -triple armv7 -target-feature +neon %s -emit-llvm -o /dev/null");
  }

  @Test
  public void test_arm_atomics_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/arm-atomics.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/arm-atomics.c -emit-llvm -o - -triple=thumbv7-none--eabi | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/arm-atomics.c
    RUN(TestState.Failed, "%clang_cc1 %s -emit-llvm -o - -triple=thumbv7-none--eabi")./*|*/
      I("FileCheck %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/arm-atomics.c -emit-llvm -o - -triple=armv6-none--eabi | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/arm-atomics.c
    RUN(TestState.Failed, "%clang_cc1 %s -emit-llvm -o - -triple=armv6-none--eabi")./*|*/
      I("FileCheck %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/arm-atomics.c -emit-llvm -o - -triple=armv7-unknown-openbsd | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/arm-atomics.c
    RUN(TestState.Failed, "%clang_cc1 %s -emit-llvm -o - -triple=armv7-unknown-openbsd")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_arm_atomics_m_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/arm-atomics-m.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/arm-atomics-m.c -emit-llvm -o - -triple=thumbv7m-none--eabi -target-cpu cortex-m3 | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/arm-atomics-m.c
    RUN(TestState.Failed, "%clang_cc1 %s -emit-llvm -o - -triple=thumbv7m-none--eabi -target-cpu cortex-m3")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_arm_atomics_m0_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/arm-atomics-m0.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/arm-atomics-m0.c -emit-llvm -o - -triple=thumbv6m-none--eabi -target-cpu cortex-m0 | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/arm-atomics-m0.c
    RUN(TestState.Failed, "%clang_cc1 %s -emit-llvm -o - -triple=thumbv6m-none--eabi -target-cpu cortex-m0")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_arm_be_result_return_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/arm-be-result-return.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple armebv7-arm-none-eabi -emit-llvm -w -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/arm-be-result-return.c | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/arm-be-result-return.c
    RUN(TestState.Failed, "%clang_cc1 -triple armebv7-arm-none-eabi -emit-llvm -w -o - %s")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_arm_bitfield_alignment_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/arm-bitfield-alignment.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple arm-none-eabi -ffreestanding -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/arm-bitfield-alignment.c | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/arm-bitfield-alignment.c
    RUN(TestState.Failed, "%clang_cc1 -triple arm-none-eabi -ffreestanding -emit-llvm -o - %s")./*|*/
      I("FileCheck %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple aarch64 -ffreestanding -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/arm-bitfield-alignment.c | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/arm-bitfield-alignment.c
    RUN(TestState.Failed, "%clang_cc1 -triple aarch64 -ffreestanding -emit-llvm -o - %s")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_arm_byval_align_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/arm-byval-align.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple=armv7-none-eabi < ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/arm-byval-align.c -S -emit-llvm | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/arm-byval-align.c
    RUN(TestState.Failed, "%clang_cc1 -triple=armv7-none-eabi < %s -S -emit-llvm")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_arm_cc_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/arm-cc.c");
    // REQUIRES: arm-registered-target
    if (!CHECK_REQUIRES("arm-registered-target")) {
      return;
    }
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple armv7-apple-darwin9 -target-abi apcs-gnu -emit-llvm -w -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/arm-cc.c | ${LLVM_SRC}/build/bin/FileCheck -check-prefix=DARWIN-APCS ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/arm-cc.c
    RUN(TestState.Failed, "%clang_cc1 -triple armv7-apple-darwin9 -target-abi apcs-gnu -emit-llvm -w -o - %s")./*|*/
      I("FileCheck -check-prefix=DARWIN-APCS %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple armv7-apple-darwin9 -target-abi aapcs -emit-llvm -w -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/arm-cc.c | ${LLVM_SRC}/build/bin/FileCheck -check-prefix=DARWIN-AAPCS ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/arm-cc.c
    RUN(TestState.Failed, "%clang_cc1 -triple armv7-apple-darwin9 -target-abi aapcs  -emit-llvm -w -o - %s")./*|*/
      I("FileCheck -check-prefix=DARWIN-AAPCS %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple arm-none-linux-gnueabi -target-abi apcs-gnu -emit-llvm -w -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/arm-cc.c | ${LLVM_SRC}/build/bin/FileCheck -check-prefix=LINUX-APCS ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/arm-cc.c
    RUN(TestState.Failed, "%clang_cc1 -triple arm-none-linux-gnueabi -target-abi apcs-gnu -emit-llvm -w -o - %s")./*|*/
      I("FileCheck -check-prefix=LINUX-APCS %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple arm-none-linux-gnueabi -target-abi aapcs -emit-llvm -w -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/arm-cc.c | ${LLVM_SRC}/build/bin/FileCheck -check-prefix=LINUX-AAPCS ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/arm-cc.c
    RUN(TestState.Failed, "%clang_cc1 -triple arm-none-linux-gnueabi -target-abi aapcs  -emit-llvm -w -o - %s")./*|*/
      I("FileCheck -check-prefix=LINUX-AAPCS %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple arm-none-linux-musleabi -target-abi apcs-gnu -emit-llvm -w -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/arm-cc.c | ${LLVM_SRC}/build/bin/FileCheck -check-prefix=LINUX-APCS ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/arm-cc.c
    RUN(TestState.Failed, "%clang_cc1 -triple arm-none-linux-musleabi -target-abi apcs-gnu -emit-llvm -w -o - %s")./*|*/
      I("FileCheck -check-prefix=LINUX-APCS %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple arm-none-linux-musleabi -target-abi aapcs -emit-llvm -w -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/arm-cc.c | ${LLVM_SRC}/build/bin/FileCheck -check-prefix=LINUX-AAPCS ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/arm-cc.c
    RUN(TestState.Failed, "%clang_cc1 -triple arm-none-linux-musleabi -target-abi aapcs  -emit-llvm -w -o - %s")./*|*/
      I("FileCheck -check-prefix=LINUX-AAPCS %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple armv7-none-eabihf -target-abi aapcs-vfp -emit-llvm -w -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/arm-cc.c | ${LLVM_SRC}/build/bin/FileCheck -check-prefix=BAREMETAL-AAPCS_VFP ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/arm-cc.c
    RUN(TestState.Failed, "%clang_cc1 -triple armv7-none-eabihf -target-abi aapcs-vfp -emit-llvm -w -o - %s")./*|*/
      I("FileCheck -check-prefix=BAREMETAL-AAPCS_VFP %s");
  }

  @Test
  public void test_arm_clear_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/arm-clear.c");
    // REQUIRES: arm-registered-target
    if (!CHECK_REQUIRES("arm-registered-target")) {
      return;
    }
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple armv7-apple-darwin9 -emit-llvm -w -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/arm-clear.c | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/arm-clear.c
    RUN(TestState.Failed, "%clang_cc1 -triple armv7-apple-darwin9 -emit-llvm -w -o - %s")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_arm_cortex_cpus_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/arm-cortex-cpus.c");
    // REQUIRES: arm-registered-target
    if (!CHECK_REQUIRES("arm-registered-target")) {
      return;
    }
    // ${LLVM_SRC}/build/bin/clang -target arm-linux-gnueabi -mcpu=cortex-m3 -S ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/arm-cortex-cpus.c -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/arm-cortex-cpus.c
    RUN(TestState.Failed, "%clang -target arm-linux-gnueabi -mcpu=cortex-m3 -S %s -o -")./*|*/
      I("FileCheck %s");
    // ${LLVM_SRC}/build/bin/clang -target arm-linux-gnueabi -mcpu=cortex-m4 -S ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/arm-cortex-cpus.c -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/arm-cortex-cpus.c
    RUN(TestState.Failed, "%clang -target arm-linux-gnueabi -mcpu=cortex-m4 -S %s -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_arm_crc32_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/arm-crc32.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple armv8-none-linux-gnueabi -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/arm-crc32.c | opt -S -mem2reg | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/arm-crc32.c
    RUN(TestState.Failed, "%clang_cc1 -triple armv8-none-linux-gnueabi -emit-llvm -o - %s")./*|*/
      I("opt -S -mem2reg")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_arm_eabi_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/arm-eabi.c");
    // REQUIRES: arm-registered-target
    if (!CHECK_REQUIRES("arm-registered-target")) {
      return;
    }
    // ${LLVM_SRC}/build/bin/clang -target arm-none-eabi -S -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/arm-eabi.c | ${LLVM_SRC}/build/bin/FileCheck -check-prefix=CHECK-EABI ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/arm-eabi.c
    RUN(TestState.Failed, "%clang -target arm-none-eabi -S -o - %s")./*|*/
      I("FileCheck -check-prefix=CHECK-EABI %s");
    // ${LLVM_SRC}/build/bin/clang -target arm-none-eabi -S -meabi gnu -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/arm-eabi.c | ${LLVM_SRC}/build/bin/FileCheck -check-prefix=CHECK-GNUEABI ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/arm-eabi.c
    RUN(TestState.Failed, "%clang -target arm-none-eabi -S -meabi gnu -o - %s")./*|*/
      I("FileCheck -check-prefix=CHECK-GNUEABI %s");
    // ${LLVM_SRC}/build/bin/clang -target arm-none-eabihf -S -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/arm-eabi.c | ${LLVM_SRC}/build/bin/FileCheck -check-prefix=CHECK-EABI ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/arm-eabi.c
    RUN(TestState.Failed, "%clang -target arm-none-eabihf -S -o - %s")./*|*/
      I("FileCheck -check-prefix=CHECK-EABI %s");
    // ${LLVM_SRC}/build/bin/clang -target arm-none-eabihf -S -meabi gnu -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/arm-eabi.c | ${LLVM_SRC}/build/bin/FileCheck -check-prefix=CHECK-GNUEABI ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/arm-eabi.c
    RUN(TestState.Failed, "%clang -target arm-none-eabihf -S -meabi gnu -o - %s")./*|*/
      I("FileCheck -check-prefix=CHECK-GNUEABI %s");
    // ${LLVM_SRC}/build/bin/clang -target arm-none-gnueabi -S -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/arm-eabi.c | ${LLVM_SRC}/build/bin/FileCheck -check-prefix=CHECK-GNUEABI ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/arm-eabi.c
    RUN(TestState.Failed, "%clang -target arm-none-gnueabi -S -o - %s")./*|*/
      I("FileCheck -check-prefix=CHECK-GNUEABI %s");
    // ${LLVM_SRC}/build/bin/clang -target arm-none-gnueabi -S -meabi 5 -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/arm-eabi.c | ${LLVM_SRC}/build/bin/FileCheck -check-prefix=CHECK-EABI ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/arm-eabi.c
    RUN(TestState.Failed, "%clang -target arm-none-gnueabi -S -meabi 5 -o - %s")./*|*/
      I("FileCheck -check-prefix=CHECK-EABI %s");
    // ${LLVM_SRC}/build/bin/clang -target arm-none-gnueabihf -S -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/arm-eabi.c | ${LLVM_SRC}/build/bin/FileCheck -check-prefix=CHECK-GNUEABI ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/arm-eabi.c
    RUN(TestState.Failed, "%clang -target arm-none-gnueabihf -S -o - %s")./*|*/
      I("FileCheck -check-prefix=CHECK-GNUEABI %s");
    // ${LLVM_SRC}/build/bin/clang -target arm-none-gnueabihf -S -meabi 5 -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/arm-eabi.c | ${LLVM_SRC}/build/bin/FileCheck -check-prefix=CHECK-EABI ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/arm-eabi.c
    RUN(TestState.Failed, "%clang -target arm-none-gnueabihf -S -meabi 5 -o - %s")./*|*/
      I("FileCheck -check-prefix=CHECK-EABI %s");
    // ${LLVM_SRC}/build/bin/clang -target arm-none-musleabi -S -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/arm-eabi.c | ${LLVM_SRC}/build/bin/FileCheck -check-prefix=CHECK-GNUEABI ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/arm-eabi.c
    RUN(TestState.Failed, "%clang -target arm-none-musleabi -S -o - %s")./*|*/
      I("FileCheck -check-prefix=CHECK-GNUEABI %s");
    // ${LLVM_SRC}/build/bin/clang -target arm-none-musleabi -S -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/arm-eabi.c -meabi 5 | ${LLVM_SRC}/build/bin/FileCheck -check-prefix=CHECK-EABI ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/arm-eabi.c
    RUN(TestState.Failed, "%clang -target arm-none-musleabi -S -o - %s -meabi 5")./*|*/
      I("FileCheck -check-prefix=CHECK-EABI %s");
    // ${LLVM_SRC}/build/bin/clang -target arm-none-musleabihf -S -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/arm-eabi.c | ${LLVM_SRC}/build/bin/FileCheck -check-prefix=CHECK-GNUEABI ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/arm-eabi.c
    RUN(TestState.Failed, "%clang -target arm-none-musleabihf -S -o - %s")./*|*/
      I("FileCheck -check-prefix=CHECK-GNUEABI %s");
    // ${LLVM_SRC}/build/bin/clang -target arm-none-musleabihf -S -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/arm-eabi.c -meabi 5 | ${LLVM_SRC}/build/bin/FileCheck -check-prefix=CHECK-EABI ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/arm-eabi.c
    RUN(TestState.Failed, "%clang -target arm-none-musleabihf -S -o - %s -meabi 5")./*|*/
      I("FileCheck -check-prefix=CHECK-EABI %s");
  }

  @Test
  public void test_arm_fp16_arguments_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/arm-fp16-arguments.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple armv7a--none-eabi -target-abi aapcs -mfloat-abi soft -fallow-half-arguments-and-returns -emit-llvm -o - -O1 ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/arm-fp16-arguments.c | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/arm-fp16-arguments.c --check-prefix=CHECK --check-prefix=SOFT
    RUN(TestState.Failed, "%clang_cc1 -triple armv7a--none-eabi -target-abi aapcs -mfloat-abi soft -fallow-half-arguments-and-returns -emit-llvm -o - -O1 %s")./*|*/
      I("FileCheck %s --check-prefix=CHECK --check-prefix=SOFT");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple armv7a--none-eabi -target-abi aapcs -mfloat-abi hard -fallow-half-arguments-and-returns -emit-llvm -o - -O1 ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/arm-fp16-arguments.c | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/arm-fp16-arguments.c --check-prefix=CHECK --check-prefix=HARD
    RUN(TestState.Failed, "%clang_cc1 -triple armv7a--none-eabi -target-abi aapcs -mfloat-abi hard -fallow-half-arguments-and-returns -emit-llvm -o - -O1 %s")./*|*/
      I("FileCheck %s --check-prefix=CHECK --check-prefix=HARD");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple armv7a--none-eabi -target-abi aapcs -mfloat-abi soft -fnative-half-arguments-and-returns -emit-llvm -o - -O1 ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/arm-fp16-arguments.c | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/arm-fp16-arguments.c --check-prefix=NATIVE
    RUN(TestState.Failed, "%clang_cc1 -triple armv7a--none-eabi -target-abi aapcs -mfloat-abi soft -fnative-half-arguments-and-returns -emit-llvm -o - -O1 %s")./*|*/
      I("FileCheck %s --check-prefix=NATIVE");
  }

  @Test
  public void test_arm_homogenous_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/arm-homogenous.c");
    // REQUIRES: arm-registered-target
    if (!CHECK_REQUIRES("arm-registered-target")) {
      return;
    }
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple armv7---eabi -target-abi aapcs -mfloat-abi hard -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/arm-homogenous.c -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/arm-homogenous.c
    RUN(TestState.Failed, "%clang_cc1 -triple armv7---eabi -target-abi aapcs -mfloat-abi hard -emit-llvm %s -o -")./*|*/
      I("FileCheck %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple arm64-apple-darwin9 -target-abi darwinpcs -ffreestanding -emit-llvm -w -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/arm-homogenous.c | ${LLVM_SRC}/build/bin/FileCheck -check-prefix=CHECK64 ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/arm-homogenous.c
    RUN(TestState.Failed, "%clang_cc1 -triple arm64-apple-darwin9 -target-abi darwinpcs -ffreestanding -emit-llvm -w -o - %s")./*|*/
      I("FileCheck -check-prefix=CHECK64 %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple arm64-linux-gnu -ffreestanding -emit-llvm -w -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/arm-homogenous.c | ${LLVM_SRC}/build/bin/FileCheck --check-prefix=CHECK64 ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/arm-homogenous.c
    RUN(TestState.Failed, "%clang_cc1 -triple arm64-linux-gnu -ffreestanding -emit-llvm -w -o - %s")./*|*/
      I("FileCheck --check-prefix=CHECK64 %s");
  }

  @Test
  public void test_arm_inline_asm_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/arm-inline-asm.c");
    // REQUIRES: arm-registered-target
    if (!CHECK_REQUIRES("arm-registered-target")) {
      return;
    }
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple armv7-apple-darwin9 -emit-llvm -w -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/arm-inline-asm.c | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/arm-inline-asm.c
    RUN(TestState.Failed, "%clang_cc1 -triple armv7-apple-darwin9 -emit-llvm -w -o - %s")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_arm_interrupt_attr_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/arm-interrupt-attr.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple thumb-apple-darwin -target-abi aapcs -target-cpu cortex-m3 -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/arm-interrupt-attr.c | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/arm-interrupt-attr.c
    RUN(TestState.Failed, "%clang_cc1 -triple thumb-apple-darwin -target-abi aapcs -target-cpu cortex-m3 -emit-llvm -o - %s")./*|*/
      I("FileCheck %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple arm-apple-darwin -target-abi apcs-gnu -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/arm-interrupt-attr.c | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/arm-interrupt-attr.c --check-prefix=CHECK-APCS
    RUN(TestState.Failed, "%clang_cc1 -triple arm-apple-darwin -target-abi apcs-gnu -emit-llvm -o - %s")./*|*/
      I("FileCheck %s --check-prefix=CHECK-APCS");
  }

  @Test
  public void test_arm_long_calls_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/arm-long-calls.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple thumbv7-apple-ios5 -target-feature +long-calls -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/arm-long-calls.c | ${LLVM_SRC}/build/bin/FileCheck -check-prefix=LONGCALL ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/arm-long-calls.c
    RUN(TestState.Failed, "%clang_cc1 -triple thumbv7-apple-ios5  -target-feature +long-calls -emit-llvm -o - %s")./*|*/
      I("FileCheck -check-prefix=LONGCALL %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple thumbv7-apple-ios5 -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/arm-long-calls.c | ${LLVM_SRC}/build/bin/FileCheck -check-prefix=NOLONGCALL ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/arm-long-calls.c
    RUN(TestState.Failed, "%clang_cc1 -triple thumbv7-apple-ios5 -emit-llvm -o - %s")./*|*/
      I("FileCheck -check-prefix=NOLONGCALL %s");
  }

  @Test
  public void test_arm_metadata_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/arm-metadata.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple armv7a-linux-gnueabi -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/arm-metadata.c | ${LLVM_SRC}/build/bin/FileCheck -check-prefix=DEFAULT ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/arm-metadata.c
    RUN(TestState.Failed, "%clang_cc1 -triple armv7a-linux-gnueabi -emit-llvm -o - %s")./*|*/
      I("FileCheck -check-prefix=DEFAULT %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple armv7a-linux-gnueabi -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/arm-metadata.c -fshort-enums | ${LLVM_SRC}/build/bin/FileCheck -check-prefix=SHORT-ENUM ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/arm-metadata.c
    RUN(TestState.Failed, "%clang_cc1 -triple armv7a-linux-gnueabi -emit-llvm -o - %s -fshort-enums")./*|*/
      I("FileCheck -check-prefix=SHORT-ENUM %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple armv7a-linux-gnueabi -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/arm-metadata.c -fshort-wchar | ${LLVM_SRC}/build/bin/FileCheck -check-prefix=SHORT-WCHAR ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/arm-metadata.c
    RUN(TestState.Failed, "%clang_cc1 -triple armv7a-linux-gnueabi -emit-llvm -o - %s -fshort-wchar")./*|*/
      I("FileCheck -check-prefix=SHORT-WCHAR %s");
  }

  @Test
  public void test_arm_microsoft_intrinsics_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/arm-microsoft-intrinsics.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple thumbv7-windows -fms-compatibility -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/arm-microsoft-intrinsics.c | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/arm-microsoft-intrinsics.c -check-prefix CHECK-MSVC
    RUN(TestState.Failed, "%clang_cc1 -triple thumbv7-windows -fms-compatibility -emit-llvm -o - %s")./*|*/
      I("FileCheck %s -check-prefix CHECK-MSVC");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple armv7-eabi -Werror -S -o /dev/null ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/arm-microsoft-intrinsics.c 2>&1 | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/arm-microsoft-intrinsics.c -check-prefix CHECK-EABI
    RUN(TestState.Failed, "not %clang_cc1 -triple armv7-eabi -Werror -S -o /dev/null %s 2>&1")./*|*/
      I("FileCheck %s -check-prefix CHECK-EABI");
  }

  @Test
  public void test_arm_neon_directed_rounding_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/arm-neon-directed-rounding.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple thumbv8-linux-gnueabihf -target-cpu cortex-a57 -ffreestanding -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/arm-neon-directed-rounding.c -o - | opt -S -mem2reg | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/arm-neon-directed-rounding.c
    RUN(TestState.Failed, "%clang_cc1 -triple thumbv8-linux-gnueabihf -target-cpu cortex-a57 -ffreestanding -emit-llvm %s -o -")./*|*/
      I("opt -S -mem2reg")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_arm_neon_fma_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/arm-neon-fma.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple thumbv7-none-linux-gnueabihf -target-abi aapcs -target-cpu cortex-a7 -mfloat-abi hard -ffreestanding -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/arm-neon-fma.c | opt -S -mem2reg | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/arm-neon-fma.c
    RUN(TestState.Failed, "%clang_cc1 -triple thumbv7-none-linux-gnueabihf -target-abi aapcs -target-cpu cortex-a7 -mfloat-abi hard -ffreestanding -emit-llvm -o - %s")./*|*/
      I("opt -S -mem2reg")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_arm_neon_misc_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/arm-neon-misc.c");
    // REQUIRES: arm-registered-target
    if (!CHECK_REQUIRES("arm-registered-target")) {
      return;
    }
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple thumbv7-apple-darwin -target-abi apcs-gnu -target-cpu cortex-a8 -mfloat-abi soft -target-feature +soft-float-abi -ffreestanding -emit-llvm -w -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/arm-neon-misc.c | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/arm-neon-misc.c
    RUN(TestState.Failed, "%clang_cc1 -triple thumbv7-apple-darwin -target-abi apcs-gnu -target-cpu cortex-a8 -mfloat-abi soft -target-feature +soft-float-abi -ffreestanding -emit-llvm -w -o - %s")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_arm_neon_numeric_maxmin_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/arm-neon-numeric-maxmin.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple thumbv8-linux-gnueabihf -target-cpu cortex-a57 -ffreestanding -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/arm-neon-numeric-maxmin.c -o - | opt -S -mem2reg | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/arm-neon-numeric-maxmin.c
    RUN(TestState.Failed, "%clang_cc1 -triple thumbv8-linux-gnueabihf -target-cpu cortex-a57 -ffreestanding -emit-llvm %s -o -")./*|*/
      I("opt -S -mem2reg")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_arm_neon_shifts_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/arm-neon-shifts.c");
    // REQUIRES: arm-registered-target
    if (!CHECK_REQUIRES("arm-registered-target")) {
      return;
    }
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple thumbv7-apple-darwin -target-cpu cortex-a8 -ffreestanding -emit-llvm -w -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/arm-neon-shifts.c | opt -S -mem2reg | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/arm-neon-shifts.c
    RUN(TestState.Failed, "%clang_cc1 -triple thumbv7-apple-darwin -target-cpu cortex-a8 -ffreestanding -emit-llvm -w -o - %s")./*|*/
      I("opt -S -mem2reg")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_arm_neon_vcvtX_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/arm-neon-vcvtX.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple thumbv8-linux-gnueabihf -target-cpu cortex-a57 -ffreestanding -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/arm-neon-vcvtX.c -o - | opt -S -mem2reg | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/arm-neon-vcvtX.c
    RUN(TestState.Failed, "%clang_cc1 -triple thumbv8-linux-gnueabihf -target-cpu cortex-a57 -ffreestanding -emit-llvm %s -o -")./*|*/
      I("opt -S -mem2reg")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_arm_neon_vget_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/arm-neon-vget.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple thumbv7-apple-darwin -target-abi apcs-gnu -target-cpu cortex-a8 -mfloat-abi soft -target-feature +soft-float-abi -ffreestanding -emit-llvm -w -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/arm-neon-vget.c | opt -S -mem2reg | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/arm-neon-vget.c
    RUN(TestState.Failed, "%clang_cc1 -triple thumbv7-apple-darwin -target-abi apcs-gnu -target-cpu cortex-a8 -mfloat-abi soft -target-feature +soft-float-abi -ffreestanding -emit-llvm -w -o - %s")./*|*/
      I("opt -S -mem2reg")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_arm_no_movt_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/arm-no-movt.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple thumbv7-apple-ios5 -target-feature +no-movt -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/arm-no-movt.c | ${LLVM_SRC}/build/bin/FileCheck -check-prefix=NO-MOVT ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/arm-no-movt.c
    RUN(TestState.Failed, "%clang_cc1 -triple thumbv7-apple-ios5  -target-feature +no-movt -emit-llvm -o - %s")./*|*/
      I("FileCheck -check-prefix=NO-MOVT %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple thumbv7-apple-ios5 -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/arm-no-movt.c | ${LLVM_SRC}/build/bin/FileCheck -check-prefix=MOVT ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/arm-no-movt.c
    RUN(TestState.Failed, "%clang_cc1 -triple thumbv7-apple-ios5 -emit-llvm -o - %s")./*|*/
      I("FileCheck -check-prefix=MOVT %s");
  }

  @Test
  public void test_arm_pcs_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/arm-pcs.c");
    // REQUIRES: arm-registered-target
    if (!CHECK_REQUIRES("arm-registered-target")) {
      return;
    }
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple arm-none-linux-gnueabi -emit-llvm -w -o - < ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/arm-pcs.c | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/arm-pcs.c
    RUN(TestState.Failed, "%clang_cc1 -triple arm-none-linux-gnueabi -emit-llvm -w -o - < %s")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_arm_swiftcall_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/arm-swiftcall.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple armv7-apple-darwin9 -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/arm-swiftcall.c | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/arm-swiftcall.c
    RUN(TestState.Failed, "%clang_cc1 -triple armv7-apple-darwin9 -emit-llvm -o - %s")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_arm_target_features_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/arm-target-features.c");
    // REQUIRES: arm-registered-target
    if (!CHECK_REQUIRES("arm-registered-target")) {
      return;
    }
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple thumbv7-linux-gnueabihf -target-cpu cortex-a8 -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/arm-target-features.c | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/arm-target-features.c --check-prefix=CHECK-VFP3
    RUN(TestState.Failed, "%clang_cc1 -triple thumbv7-linux-gnueabihf -target-cpu cortex-a8 -emit-llvm -o - %s")./*|*/
      I("FileCheck %s --check-prefix=CHECK-VFP3");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple thumbv7-linux-gnueabi -target-cpu cortex-a9 -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/arm-target-features.c | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/arm-target-features.c --check-prefix=CHECK-VFP3-FP16
    RUN(TestState.Failed, "%clang_cc1 -triple thumbv7-linux-gnueabi -target-cpu cortex-a9 -emit-llvm -o - %s")./*|*/
      I("FileCheck %s --check-prefix=CHECK-VFP3-FP16");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple thumbv7-linux-gnueabihf -target-cpu cortex-a5 -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/arm-target-features.c | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/arm-target-features.c --check-prefix=CHECK-VFP4
    RUN(TestState.Failed, "%clang_cc1 -triple thumbv7-linux-gnueabihf -target-cpu cortex-a5 -emit-llvm -o - %s")./*|*/
      I("FileCheck %s --check-prefix=CHECK-VFP4");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple thumbv7-linux-gnueabihf -target-cpu cortex-a7 -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/arm-target-features.c | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/arm-target-features.c --check-prefix=CHECK-VFP4-DIV
    RUN(TestState.Failed, "%clang_cc1 -triple thumbv7-linux-gnueabihf -target-cpu cortex-a7 -emit-llvm -o - %s")./*|*/
      I("FileCheck %s --check-prefix=CHECK-VFP4-DIV");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple thumbv7-linux-gnueabi -target-cpu cortex-a12 -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/arm-target-features.c | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/arm-target-features.c --check-prefix=CHECK-VFP4-DIV
    RUN(TestState.Failed, "%clang_cc1 -triple thumbv7-linux-gnueabi -target-cpu cortex-a12 -emit-llvm -o - %s")./*|*/
      I("FileCheck %s --check-prefix=CHECK-VFP4-DIV");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple armv7-linux-gnueabihf -target-cpu cortex-a15 -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/arm-target-features.c | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/arm-target-features.c --check-prefix=CHECK-VFP4-DIV
    RUN(TestState.Failed, "%clang_cc1 -triple armv7-linux-gnueabihf -target-cpu cortex-a15 -emit-llvm -o - %s")./*|*/
      I("FileCheck %s --check-prefix=CHECK-VFP4-DIV");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple armv7-linux-gnueabihf -target-cpu cortex-a17 -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/arm-target-features.c | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/arm-target-features.c --check-prefix=CHECK-VFP4-DIV
    RUN(TestState.Failed, "%clang_cc1 -triple armv7-linux-gnueabihf -target-cpu cortex-a17 -emit-llvm -o - %s")./*|*/
      I("FileCheck %s --check-prefix=CHECK-VFP4-DIV");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple thumbv7s-linux-gnueabi -target-cpu swift -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/arm-target-features.c | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/arm-target-features.c --check-prefix=CHECK-VFP4-DIV
    RUN(TestState.Failed, "%clang_cc1 -triple thumbv7s-linux-gnueabi -target-cpu swift -emit-llvm -o - %s")./*|*/
      I("FileCheck %s --check-prefix=CHECK-VFP4-DIV");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple thumbv7-linux-gnueabihf -target-cpu krait -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/arm-target-features.c | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/arm-target-features.c --check-prefix=CHECK-VFP4-DIV
    RUN(TestState.Failed, "%clang_cc1 -triple thumbv7-linux-gnueabihf -target-cpu krait -emit-llvm -o - %s")./*|*/
      I("FileCheck %s --check-prefix=CHECK-VFP4-DIV");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple thumbv7s-apple-ios7.0 -target-cpu cyclone -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/arm-target-features.c | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/arm-target-features.c --check-prefix=CHECK-BASIC-V8
    RUN(TestState.Failed, "%clang_cc1 -triple thumbv7s-apple-ios7.0 -target-cpu cyclone -emit-llvm -o - %s")./*|*/
      I("FileCheck %s --check-prefix=CHECK-BASIC-V8");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple thumbv8-linux-gnueabihf -target-cpu cortex-a32 -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/arm-target-features.c | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/arm-target-features.c --check-prefix=CHECK-BASIC-V8
    RUN(TestState.Failed, "%clang_cc1 -triple thumbv8-linux-gnueabihf -target-cpu cortex-a32 -emit-llvm -o - %s")./*|*/
      I("FileCheck %s --check-prefix=CHECK-BASIC-V8");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple thumbv8-linux-gnueabihf -target-cpu cortex-a35 -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/arm-target-features.c | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/arm-target-features.c --check-prefix=CHECK-BASIC-V8
    RUN(TestState.Failed, "%clang_cc1 -triple thumbv8-linux-gnueabihf -target-cpu cortex-a35 -emit-llvm -o - %s")./*|*/
      I("FileCheck %s --check-prefix=CHECK-BASIC-V8");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple armv8-linux-gnueabi -target-cpu cortex-a53 -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/arm-target-features.c | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/arm-target-features.c --check-prefix=CHECK-BASIC-V8
    RUN(TestState.Failed, "%clang_cc1 -triple armv8-linux-gnueabi -target-cpu cortex-a53 -emit-llvm -o - %s")./*|*/
      I("FileCheck %s --check-prefix=CHECK-BASIC-V8");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple thumbv8-linux-gnueabihf -target-cpu cortex-a57 -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/arm-target-features.c | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/arm-target-features.c --check-prefix=CHECK-BASIC-V8
    RUN(TestState.Failed, "%clang_cc1 -triple thumbv8-linux-gnueabihf -target-cpu cortex-a57 -emit-llvm -o - %s")./*|*/
      I("FileCheck %s --check-prefix=CHECK-BASIC-V8");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple thumbv8-linux-gnueabihf -target-cpu cortex-a72 -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/arm-target-features.c | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/arm-target-features.c --check-prefix=CHECK-BASIC-V8
    RUN(TestState.Failed, "%clang_cc1 -triple thumbv8-linux-gnueabihf -target-cpu cortex-a72 -emit-llvm -o - %s")./*|*/
      I("FileCheck %s --check-prefix=CHECK-BASIC-V8");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple thumbv8-linux-gnueabihf -target-cpu cortex-a73 -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/arm-target-features.c | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/arm-target-features.c --check-prefix=CHECK-BASIC-V8
    RUN(TestState.Failed, "%clang_cc1 -triple thumbv8-linux-gnueabihf -target-cpu cortex-a73 -emit-llvm -o - %s")./*|*/
      I("FileCheck %s --check-prefix=CHECK-BASIC-V8");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple thumbv8-linux-gnueabihf -target-cpu exynos-m1 -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/arm-target-features.c | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/arm-target-features.c --check-prefix=CHECK-BASIC-V8
    RUN(TestState.Failed, "%clang_cc1 -triple thumbv8-linux-gnueabihf -target-cpu exynos-m1 -emit-llvm -o - %s")./*|*/
      I("FileCheck %s --check-prefix=CHECK-BASIC-V8");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple thumbv7-linux-gnueabi -target-cpu cortex-r5 -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/arm-target-features.c | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/arm-target-features.c --check-prefix=CHECK-VFP3-D16-DIV
    RUN(TestState.Failed, "%clang_cc1 -triple thumbv7-linux-gnueabi -target-cpu cortex-r5 -emit-llvm -o - %s")./*|*/
      I("FileCheck %s --check-prefix=CHECK-VFP3-D16-DIV");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple armv7-linux-gnueabi -target-cpu cortex-r4f -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/arm-target-features.c | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/arm-target-features.c --check-prefix=CHECK-VFP3-D16-THUMB-DIV
    RUN(TestState.Failed, "%clang_cc1 -triple armv7-linux-gnueabi -target-cpu cortex-r4f -emit-llvm -o - %s")./*|*/
      I("FileCheck %s --check-prefix=CHECK-VFP3-D16-THUMB-DIV");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple thumbv7-linux-gnueabi -target-cpu cortex-r7 -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/arm-target-features.c | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/arm-target-features.c --check-prefix=CHECK-VFP3-D16-FP16-DIV
    RUN(TestState.Failed, "%clang_cc1 -triple thumbv7-linux-gnueabi -target-cpu cortex-r7 -emit-llvm -o - %s")./*|*/
      I("FileCheck %s --check-prefix=CHECK-VFP3-D16-FP16-DIV");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple thumbv7-linux-gnueabi -target-cpu cortex-r8 -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/arm-target-features.c | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/arm-target-features.c --check-prefix=CHECK-VFP3-D16-FP16-DIV
    RUN(TestState.Failed, "%clang_cc1 -triple thumbv7-linux-gnueabi -target-cpu cortex-r8 -emit-llvm -o - %s")./*|*/
      I("FileCheck %s --check-prefix=CHECK-VFP3-D16-FP16-DIV");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple thumbv7-linux-gnueabi -target-cpu cortex-m4 -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/arm-target-features.c | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/arm-target-features.c --check-prefix=CHECK-VFP4-D16-SP-THUMB-DIV
    RUN(TestState.Failed, "%clang_cc1 -triple thumbv7-linux-gnueabi -target-cpu cortex-m4 -emit-llvm -o - %s")./*|*/
      I("FileCheck %s --check-prefix=CHECK-VFP4-D16-SP-THUMB-DIV");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple thumbv7-linux-gnueabi -target-cpu cortex-m7 -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/arm-target-features.c | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/arm-target-features.c --check-prefix=CHECK-VFP5-D16-THUMB-DIV
    RUN(TestState.Failed, "%clang_cc1 -triple thumbv7-linux-gnueabi -target-cpu cortex-m7 -emit-llvm -o - %s")./*|*/
      I("FileCheck %s --check-prefix=CHECK-VFP5-D16-THUMB-DIV");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple armv7-linux-gnueabi -target-cpu cortex-r4 -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/arm-target-features.c | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/arm-target-features.c --check-prefix=CHECK-THUMB-DIV
    RUN(TestState.Failed, "%clang_cc1 -triple armv7-linux-gnueabi -target-cpu cortex-r4 -emit-llvm -o - %s")./*|*/
      I("FileCheck %s --check-prefix=CHECK-THUMB-DIV");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple thumbv7-linux-gnueabi -target-cpu cortex-m3 -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/arm-target-features.c | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/arm-target-features.c --check-prefix=CHECK-THUMB-DIV-M3
    RUN(TestState.Failed, "%clang_cc1 -triple thumbv7-linux-gnueabi -target-cpu cortex-m3 -emit-llvm -o - %s")./*|*/
      I("FileCheck %s --check-prefix=CHECK-THUMB-DIV-M3");
  }

  @Test
  public void test_arm_v8_1a_neon_intrinsics_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/arm-v8.1a-neon-intrinsics.c");
    // REQUIRES: arm-registered-target,aarch64-registered-target
    if (!CHECK_REQUIRES("arm-registered-target,aarch64-registered-target")) {
      return;
    }
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple armv8.1a-linux-gnu -target-feature +neon -S -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/arm-v8.1a-neon-intrinsics.c | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/arm-v8.1a-neon-intrinsics.c --check-prefix=CHECK --check-prefix=CHECK-ARM
    RUN(TestState.Failed, "%clang_cc1 -triple armv8.1a-linux-gnu -target-feature +neon -S -emit-llvm -o - %s")./*|*/
      I("FileCheck %s --check-prefix=CHECK --check-prefix=CHECK-ARM");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple aarch64-linux-gnu -target-feature +neon -target-feature +v8.1a -S -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/arm-v8.1a-neon-intrinsics.c | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/arm-v8.1a-neon-intrinsics.c --check-prefix=CHECK --check-prefix=CHECK-AARCH64
    RUN(TestState.Failed, "%clang_cc1 -triple aarch64-linux-gnu -target-feature +neon -target-feature +v8.1a -S -emit-llvm -o - %s")./*|*/
      I("FileCheck %s --check-prefix=CHECK --check-prefix=CHECK-AARCH64");
  }

  @Test
  public void test_arm_vaarg_align_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/arm-vaarg-align.c");
    // REQUIRES: arm-registered-target
    if (!CHECK_REQUIRES("arm-registered-target")) {
      return;
    }
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple arm -target-abi aapcs ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/arm-vaarg-align.c -emit-llvm -o - | ${LLVM_SRC}/build/bin/FileCheck -check-prefix=AAPCS ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/arm-vaarg-align.c
    RUN(TestState.Failed, "%clang_cc1 -triple arm -target-abi aapcs %s -emit-llvm -o -")./*|*/
      I("FileCheck -check-prefix=AAPCS %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple arm -target-abi apcs-gnu ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/arm-vaarg-align.c -emit-llvm -o - | ${LLVM_SRC}/build/bin/FileCheck -check-prefix=APCS-GNU ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/arm-vaarg-align.c
    RUN(TestState.Failed, "%clang_cc1 -triple arm -target-abi apcs-gnu %s -emit-llvm -o -")./*|*/
      I("FileCheck -check-prefix=APCS-GNU %s");
  }

  @Test
  public void test_arm_vector_align_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/arm-vector-align.c");
    // REQUIRES: arm-registered-target
    if (!CHECK_REQUIRES("arm-registered-target")) {
      return;
    }
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple thumbv7-apple-darwin -target-abi apcs-gnu -target-cpu cortex-a8 -mfloat-abi soft -target-feature +soft-float-abi -ffreestanding -emit-llvm -w -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/arm-vector-align.c | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/arm-vector-align.c
    RUN(TestState.Failed, "%clang_cc1 -triple thumbv7-apple-darwin -target-abi apcs-gnu -target-cpu cortex-a8 -mfloat-abi soft -target-feature +soft-float-abi -ffreestanding -emit-llvm -w -o - %s")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_arm_vector_arguments_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/arm-vector-arguments.c");
    // REQUIRES: arm-registered-target
    if (!CHECK_REQUIRES("arm-registered-target")) {
      return;
    }
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple thumbv7-apple-darwin9 -target-abi apcs-gnu -target-cpu cortex-a8 -mfloat-abi soft -target-feature +soft-float-abi -ffreestanding -emit-llvm -w -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/arm-vector-arguments.c | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/arm-vector-arguments.c
    RUN(TestState.Failed, "%clang_cc1 -triple thumbv7-apple-darwin9 -target-abi apcs-gnu -target-cpu cortex-a8 -mfloat-abi soft -target-feature +soft-float-abi -ffreestanding -emit-llvm -w -o - %s")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_arm_vfp_asm_constraint_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/arm-vfp-asm-constraint.c");
    // REQUIRES: arm-registered-target
    if (!CHECK_REQUIRES("arm-registered-target")) {
      return;
    }
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple armv7-unknown-unknown -mfpmath vfp -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/arm-vfp-asm-constraint.c | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/arm-vfp-asm-constraint.c
    RUN(TestState.Failed, "%clang_cc1 -triple armv7-unknown-unknown -mfpmath vfp -emit-llvm -o - %s")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_arm64_aapcs_arguments_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/arm64-aapcs-arguments.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple aarch64-linux-gnu -target-feature +neon -target-abi aapcs -ffreestanding -fallow-half-arguments-and-returns -emit-llvm -w -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/arm64-aapcs-arguments.c | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/arm64-aapcs-arguments.c
    RUN(TestState.Failed, "%clang_cc1 -triple aarch64-linux-gnu -target-feature +neon -target-abi aapcs -ffreestanding -fallow-half-arguments-and-returns -emit-llvm -w -o - %s")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_arm64_abi_vector_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/arm64-abi-vector.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple arm64-apple-ios7 -target-abi darwinpcs -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/arm64-abi-vector.c | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/arm64-abi-vector.c
    RUN(TestState.Failed, "%clang_cc1 -triple arm64-apple-ios7 -target-abi darwinpcs -emit-llvm -o - %s")./*|*/
      I("FileCheck %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple aarch64-linux-android -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/arm64-abi-vector.c | ${LLVM_SRC}/build/bin/FileCheck -check-prefix=ANDROID ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/arm64-abi-vector.c
    RUN(TestState.Failed, "%clang_cc1 -triple aarch64-linux-android -emit-llvm -o - %s")./*|*/
      I("FileCheck -check-prefix=ANDROID %s");
  }

  @Test
  public void test_arm64_arguments_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/arm64-arguments.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple arm64-apple-ios7 -target-feature +neon -target-abi darwinpcs -ffreestanding -emit-llvm -w -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/arm64-arguments.c | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/arm64-arguments.c
    RUN(TestState.Failed, "%clang_cc1 -triple arm64-apple-ios7 -target-feature +neon -target-abi darwinpcs -ffreestanding -emit-llvm -w -o - %s")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_arm64_be_bitfield_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/arm64-be-bitfield.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple aarch64_be-linux-gnu -ffreestanding -emit-llvm -O0 -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/arm64-be-bitfield.c | ${LLVM_SRC}/build/bin/FileCheck --check-prefix IR ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/arm64-be-bitfield.c
    RUN(TestState.Failed, "%clang_cc1 -triple aarch64_be-linux-gnu -ffreestanding -emit-llvm -O0 -o - %s")./*|*/
      I("FileCheck --check-prefix IR %s");
  }

  @Test
  public void test_arm64_be_hfa_vararg_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/arm64-be-hfa-vararg.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple aarch64_be-linux-gnu -ffreestanding -emit-llvm -O0 -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/arm64-be-hfa-vararg.c | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/arm64-be-hfa-vararg.c
    RUN(TestState.Failed, "%clang_cc1 -triple aarch64_be-linux-gnu -ffreestanding -emit-llvm -O0 -o - %s")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_arm64_crc32_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/arm64-crc32.c");
    // REQUIRES: aarch64-registered-target
    if (!CHECK_REQUIRES("aarch64-registered-target")) {
      return;
    }
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple arm64-none-linux-gnu -S -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/arm64-crc32.c | opt -S -mem2reg | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/arm64-crc32.c
    RUN(TestState.Failed, "%clang_cc1 -triple arm64-none-linux-gnu -S -emit-llvm -o - %s")./*|*/
      I("opt -S -mem2reg")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_arm64_lanes_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/arm64-lanes.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple arm64-apple-ios7 -target-feature +neon -ffreestanding -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/arm64-lanes.c | opt -S -mem2reg | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/arm64-lanes.c
    RUN(TestState.Failed, "%clang_cc1 -triple arm64-apple-ios7 -target-feature +neon -ffreestanding -emit-llvm -o - %s")./*|*/
      I("opt -S -mem2reg")./*|*/
      I("FileCheck %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple aarch64_be-linux-gnu -target-feature +neon -ffreestanding -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/arm64-lanes.c | opt -S -mem2reg | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/arm64-lanes.c --check-prefix CHECK-BE
    RUN(TestState.Failed, "%clang_cc1 -triple aarch64_be-linux-gnu -target-feature +neon -ffreestanding -emit-llvm -o - %s")./*|*/
      I("opt -S -mem2reg")./*|*/
      I("FileCheck %s --check-prefix CHECK-BE");
  }

  @Test
  public void test_arm64_vrnd_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/arm64-vrnd.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple arm64-apple-ios7 -target-feature +neon -ffreestanding -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/arm64-vrnd.c | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/arm64-vrnd.c
    RUN(TestState.Failed, "%clang_cc1 -triple arm64-apple-ios7 -target-feature +neon -ffreestanding -emit-llvm -o - %s")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_arm64_crypto_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/arm64_crypto.c");
    // REQUIRES: aarch64-registered-target
    if (!CHECK_REQUIRES("aarch64-registered-target")) {
      return;
    }
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple arm64-apple-ios7.0 -target-feature +neon -target-feature +crypto -ffreestanding -Os -S -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/arm64_crypto.c | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/arm64_crypto.c
    RUN(TestState.Failed, "%clang_cc1 -triple arm64-apple-ios7.0 -target-feature +neon -target-feature +crypto -ffreestanding -Os -S -o - %s")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_arm64_vcopy_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/arm64_vcopy.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple arm64-apple-ios7 -target-feature +neon -ffreestanding -S -o - -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/arm64_vcopy.c | opt -S -mem2reg | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/arm64_vcopy.c
    RUN(TestState.Failed, "%clang_cc1 -triple arm64-apple-ios7 -target-feature +neon -ffreestanding -S -o - -emit-llvm %s")./*|*/
      I("opt -S -mem2reg")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_arm64_vcreate_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/arm64_vcreate.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple arm64-apple-ios7 -target-feature +neon -ffreestanding -S -o - -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/arm64_vcreate.c | opt -S -mem2reg | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/arm64_vcreate.c
    RUN(TestState.Failed, "%clang_cc1 -triple arm64-apple-ios7 -target-feature +neon -ffreestanding -S -o - -emit-llvm %s")./*|*/
      I("opt -S -mem2reg")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_arm64_vdup_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/arm64_vdup.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple arm64-apple-ios7 -target-feature +neon -ffreestanding -S -o - -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/arm64_vdup.c | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/arm64_vdup.c
    RUN(TestState.Failed, "%clang_cc1 -triple arm64-apple-ios7 -target-feature +neon -ffreestanding -S -o - -emit-llvm %s")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_arm64_vdupq_n_f64_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/arm64_vdupq_n_f64.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple arm64-apple-ios7 -target-feature +neon -ffreestanding -fallow-half-arguments-and-returns -S -o - -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/arm64_vdupq_n_f64.c | opt -S -mem2reg | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/arm64_vdupq_n_f64.c
    RUN(TestState.Failed, "%clang_cc1 -triple arm64-apple-ios7 -target-feature +neon -ffreestanding -fallow-half-arguments-and-returns -S -o - -emit-llvm %s")./*|*/
      I("opt -S -mem2reg")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_arm_acle_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/arm_acle.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -ffreestanding -triple armv8-eabi -target-cpu cortex-a57 -O -S -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/arm_acle.c | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/arm_acle.c -check-prefix=ARM -check-prefix=AArch32
    RUN(TestState.Failed, "%clang_cc1 -ffreestanding -triple armv8-eabi -target-cpu cortex-a57 -O -S -emit-llvm -o - %s")./*|*/
      I("FileCheck %s -check-prefix=ARM -check-prefix=AArch32");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -ffreestanding -triple aarch64-eabi -target-cpu cortex-a57 -target-feature +neon -target-feature +crc -target-feature +crypto -O -S -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/arm_acle.c | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/arm_acle.c -check-prefix=ARM -check-prefix=AArch64
    RUN(TestState.Failed, "%clang_cc1 -ffreestanding -triple aarch64-eabi -target-cpu cortex-a57 -target-feature +neon -target-feature +crc -target-feature +crypto -O -S -emit-llvm -o - %s")./*|*/
      I("FileCheck %s -check-prefix=ARM -check-prefix=AArch64");
  }

  @Test
  public void test_arm_function_epilog_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/arm_function_epilog.cpp");
    // REQUIRES: arm-registered-target
    if (!CHECK_REQUIRES("arm-registered-target")) {
      return;
    }
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple armv7-none-linux-androideabi -target-abi aapcs-linux -mfloat-abi hard -x c++ -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/arm_function_epilog.cpp -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/arm_function_epilog.cpp
    RUN(TestState.Failed, "%clang_cc1 -triple armv7-none-linux-androideabi -target-abi aapcs-linux -mfloat-abi hard -x c++ -emit-llvm %s -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_arm_neon_intrinsics_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/arm_neon_intrinsics.c");
    // REQUIRES: long-tests
    if (!CHECK_REQUIRES("long-tests")) {
      return;
    }
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple thumbv7s-apple-darwin -target-abi apcs-gnu -target-cpu swift -fallow-half-arguments-and-returns -ffreestanding -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/arm_neon_intrinsics.c | opt -S -mem2reg | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/arm_neon_intrinsics.c
    RUN(TestState.Failed, "%clang_cc1 -triple thumbv7s-apple-darwin -target-abi apcs-gnu -target-cpu swift -fallow-half-arguments-and-returns -ffreestanding -emit-llvm -o - %s")./*|*/
      I("opt -S -mem2reg")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_armv7k_abi_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/armv7k-abi.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple thumbv7k-apple-watchos2.0 -target-abi aapcs16 -target-cpu cortex-a7 ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/armv7k-abi.c -o - -emit-llvm | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/armv7k-abi.c
    RUN(TestState.Failed, "%clang_cc1 -triple thumbv7k-apple-watchos2.0 -target-abi aapcs16 -target-cpu cortex-a7 %s -o - -emit-llvm")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_array_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/array.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/array.c -o ${TEST_TEMP_DIR}/array.c.tmp
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm %s -o %t");
  }

  @Test
  public void test_arrayderef_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/arrayderef.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/arrayderef.c -emit-llvm -O1 -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/arrayderef.c
    RUN(TestState.Failed, "%clang_cc1 %s -emit-llvm -O1 -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_asan_globals_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/asan-globals.cpp");
    // REQUIRES: shell
    if (!CHECK_REQUIRES("shell")) {
      return;
    }
    // echo 'int extra_global;' > ${TEST_TEMP_DIR}/asan-globals.cpp.tmp.extra-source.cpp
    RUN(TestState.Failed, "echo \"int extra_global;\" > %t.extra-source.cpp");
    // echo global:*blacklisted_global* > ${TEST_TEMP_DIR}/asan-globals.cpp.tmp.blacklist
    RUN(TestState.Failed, "echo \"global:*blacklisted_global*\" > %t.blacklist");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -include ${TEST_TEMP_DIR}/asan-globals.cpp.tmp.extra-source.cpp -fsanitize=address '-fsanitize-blacklist=${TEST_TEMP_DIR}/asan-globals.cpp.tmp.blacklist' -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/asan-globals.cpp | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/asan-globals.cpp
    RUN(TestState.Failed, "%clang_cc1 -include %t.extra-source.cpp -fsanitize=address -fsanitize-blacklist=%t.blacklist -emit-llvm -o - %s")./*|*/
      I("FileCheck %s");
    // echo 'src:${LLVM_SRC}/llvm/tools/clang/test/CodeGen/asan-globals.cpp' > ${TEST_TEMP_DIR}/asan-globals.cpp.tmp.blacklist-src
    RUN(TestState.Failed, "echo \"src:%s\" > %t.blacklist-src");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -include ${TEST_TEMP_DIR}/asan-globals.cpp.tmp.extra-source.cpp -fsanitize=address '-fsanitize-blacklist=${TEST_TEMP_DIR}/asan-globals.cpp.tmp.blacklist-src' -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/asan-globals.cpp | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/asan-globals.cpp --check-prefix=BLACKLIST-SRC
    RUN(TestState.Failed, "%clang_cc1 -include %t.extra-source.cpp -fsanitize=address -fsanitize-blacklist=%t.blacklist-src -emit-llvm -o - %s")./*|*/
      I("FileCheck %s --check-prefix=BLACKLIST-SRC");
  }

  @Test
  public void test_asm_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/asm.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i386-unknown-unknown -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/asm.c -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/asm.c
    RUN(TestState.Failed, "%clang_cc1 -triple i386-unknown-unknown -emit-llvm %s -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_asm_attrs_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/asm-attrs.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple armv7-apple-darwin -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/asm-attrs.c -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/asm-attrs.c
    RUN(TestState.Failed, "%clang_cc1 -triple armv7-apple-darwin -emit-llvm %s -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_asm_errors_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/asm-errors.c");
    // REQUIRES: x86-registered-target
    if (!CHECK_REQUIRES("x86-registered-target")) {
      return;
    }
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i386-apple-darwin10 -emit-obj ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/asm-errors.c -o /dev/null > ${TEST_TEMP_DIR}/asm-errors.c.tmp 2>&1
    RUN(TestState.Failed, "not %clang_cc1 -triple i386-apple-darwin10 -emit-obj %s -o /dev/null > %t 2>&1");
    // ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/asm-errors.c < ${TEST_TEMP_DIR}/asm-errors.c.tmp
    RUN(TestState.Failed, "FileCheck %s < %t");
    // ${LLVM_SRC}/build/bin/clang -target i386-apple-darwin10 -fembed-bitcode -c ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/asm-errors.c -o /dev/null 2>&1 | ${LLVM_SRC}/build/bin/FileCheck --check-prefix=CRASH-REPORT ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/asm-errors.c
    RUN(TestState.Failed, "not %clang -target i386-apple-darwin10 -fembed-bitcode -c %s -o /dev/null 2>&1")./*|*/
      I("FileCheck --check-prefix=CRASH-REPORT %s");
  }

  @Test
  public void test_asm_inout_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/asm-inout.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i386-unknown-unknown -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/asm-inout.c -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/asm-inout.c
    RUN(TestState.Failed, "%clang_cc1 -triple i386-unknown-unknown -emit-llvm %s -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_asm_label_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/asm-label.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple=i686-pc-linux-gnu -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/asm-label.c -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/asm-label.c --check-prefix=LINUX
    RUN(TestState.Failed, "%clang_cc1 -triple=i686-pc-linux-gnu -emit-llvm %s -o -")./*|*/
      I("FileCheck %s --check-prefix=LINUX");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple=i686-apple-darwin9 -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/asm-label.c -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/asm-label.c --check-prefix=DARWIN
    RUN(TestState.Failed, "%clang_cc1 -triple=i686-apple-darwin9 -emit-llvm %s -o -")./*|*/
      I("FileCheck %s --check-prefix=DARWIN");
  }

  @Test
  public void test_asm_reg_var_local_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/asm-reg-var-local.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/asm-reg-var-local.c -triple x86_64-apple-darwin -emit-llvm -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/asm-reg-var-local.c
    RUN(TestState.Failed, "%clang_cc1 %s -triple x86_64-apple-darwin -emit-llvm -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_asm_unicode_S() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/asm-unicode.S");
    // ${LLVM_SRC}/build/bin/clang -S ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/asm-unicode.S -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/asm-unicode.S
    RUN(TestState.Failed, "%clang -S %s -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_asm_variable_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/asm-variable.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-unknown-unknown -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/asm-variable.c -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/asm-variable.c
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-unknown-unknown -emit-llvm %s -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_asm_64_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/asm_64.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-unknown-unknown -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/asm_64.c -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/asm_64.c
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-unknown-unknown -emit-llvm %s -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_asm_arm_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/asm_arm.c");
    // REQUIRES: arm-registered-target
    if (!CHECK_REQUIRES("arm-registered-target")) {
      return;
    }
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple armv6-unknown-unknown -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/asm_arm.c | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/asm_arm.c
    RUN(TestState.Failed, "%clang_cc1 -triple armv6-unknown-unknown -emit-llvm -o - %s")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_asm_arm64_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/asm_arm64.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple arm64-apple-ios -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/asm_arm64.c | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/asm_arm64.c
    RUN(TestState.Failed, "%clang_cc1 -triple arm64-apple-ios -emit-llvm -o - %s")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_assign_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/assign.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64 -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/assign.c | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/assign.c
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64 -emit-llvm -o - %s")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_atomic_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/atomic.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/atomic.c -emit-llvm -o - -triple=i686-apple-darwin9 | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/atomic.c
    RUN(TestState.Failed, "%clang_cc1 %s -emit-llvm -o - -triple=i686-apple-darwin9")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_atomic_arm64_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/atomic-arm64.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/atomic-arm64.c -emit-llvm -o - -triple=arm64-apple-ios7 | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/atomic-arm64.c
    RUN(TestState.Failed, "%clang_cc1 %s -emit-llvm -o - -triple=arm64-apple-ios7")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_atomic_ops_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/atomic-ops.c");
    // REQUIRES: x86-registered-target
    if (!CHECK_REQUIRES("x86-registered-target")) {
      return;
    }
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/atomic-ops.c -emit-llvm -o - -ffreestanding -ffake-address-space-map -triple=i686-apple-darwin9 | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/atomic-ops.c
    RUN(TestState.Failed, "%clang_cc1 %s -emit-llvm -o - -ffreestanding -ffake-address-space-map -triple=i686-apple-darwin9")./*|*/
      I("FileCheck %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/atomic-ops.c -emit-pch -o ${TEST_TEMP_DIR}/atomic-ops.c.tmp -ffreestanding -ffake-address-space-map -triple=i686-apple-darwin9
    RUN(TestState.Failed, "%clang_cc1 %s -emit-pch -o %t -ffreestanding -ffake-address-space-map -triple=i686-apple-darwin9");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/atomic-ops.c -include-pch ${TEST_TEMP_DIR}/atomic-ops.c.tmp -ffreestanding -ffake-address-space-map -triple=i686-apple-darwin9 -emit-llvm -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/atomic-ops.c
    RUN(TestState.Failed, "%clang_cc1 %s -include-pch %t -ffreestanding -ffake-address-space-map -triple=i686-apple-darwin9 -emit-llvm -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_atomic_ops_libcall_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/atomic-ops-libcall.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc < ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/atomic-ops-libcall.c -triple armv5e-none-linux-gnueabi -emit-llvm -O1 | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/atomic-ops-libcall.c
    RUN(TestState.Failed, "%clang_cc1 < %s -triple armv5e-none-linux-gnueabi -emit-llvm -O1")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_atomic__ops_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/atomic_ops.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/atomic_ops.c -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/atomic_ops.c
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm %s -o -")./*|*/
      I("FileCheck %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple mips-linux-gnu -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/atomic_ops.c -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/atomic_ops.c
    RUN(TestState.Failed, "%clang_cc1 -triple mips-linux-gnu -emit-llvm %s -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_atomics_inlining_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/atomics-inlining.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple arm-linux-gnueabi -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/atomics-inlining.c -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/atomics-inlining.c -check-prefix=ARM
    RUN(TestState.Failed, "%clang_cc1 -triple arm-linux-gnueabi -emit-llvm %s -o -")./*|*/
      I("FileCheck %s -check-prefix=ARM");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple powerpc-linux-gnu -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/atomics-inlining.c -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/atomics-inlining.c -check-prefix=PPC32
    RUN(TestState.Failed, "%clang_cc1 -triple powerpc-linux-gnu -emit-llvm %s -o -")./*|*/
      I("FileCheck %s -check-prefix=PPC32");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple powerpc64-linux-gnu -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/atomics-inlining.c -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/atomics-inlining.c -check-prefix=PPC64
    RUN(TestState.Failed, "%clang_cc1 -triple powerpc64-linux-gnu -emit-llvm %s -o -")./*|*/
      I("FileCheck %s -check-prefix=PPC64");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple mipsel-linux-gnu -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/atomics-inlining.c -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/atomics-inlining.c -check-prefix=MIPS32
    RUN(TestState.Failed, "%clang_cc1 -triple mipsel-linux-gnu -emit-llvm %s -o -")./*|*/
      I("FileCheck %s -check-prefix=MIPS32");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple mips64el-linux-gnu -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/atomics-inlining.c -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/atomics-inlining.c -check-prefix=MIPS64
    RUN(TestState.Failed, "%clang_cc1 -triple mips64el-linux-gnu -emit-llvm %s -o -")./*|*/
      I("FileCheck %s -check-prefix=MIPS64");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple sparc-unknown-eabi -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/atomics-inlining.c -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/atomics-inlining.c -check-prefix=SPARC
    RUN(TestState.Failed, "%clang_cc1 -triple sparc-unknown-eabi -emit-llvm %s -o -")./*|*/
      I("FileCheck %s -check-prefix=SPARC");
  }

  @Test
  public void test_attr_availability_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/attr-availability.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fvisibility hidden -triple x86_64-apple-darwin8.0.0 -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/attr-availability.c | ${LLVM_SRC}/build/bin/FileCheck -check-prefix=CHECK-10_4 ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/attr-availability.c
    RUN(TestState.Failed, "%clang_cc1 -fvisibility hidden \"-triple\" \"x86_64-apple-darwin8.0.0\" -emit-llvm -o - %s")./*|*/
      I("FileCheck -check-prefix=CHECK-10_4 %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fvisibility hidden -triple x86_64-apple-darwin9.0.0 -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/attr-availability.c | ${LLVM_SRC}/build/bin/FileCheck -check-prefix=CHECK-10_5 ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/attr-availability.c
    RUN(TestState.Failed, "%clang_cc1 -fvisibility hidden \"-triple\" \"x86_64-apple-darwin9.0.0\" -emit-llvm -o - %s")./*|*/
      I("FileCheck -check-prefix=CHECK-10_5 %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fvisibility hidden -triple x86_64-apple-darwin10.0.0 -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/attr-availability.c | ${LLVM_SRC}/build/bin/FileCheck -check-prefix=CHECK-10_6 ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/attr-availability.c
    RUN(TestState.Failed, "%clang_cc1 -fvisibility hidden \"-triple\" \"x86_64-apple-darwin10.0.0\" -emit-llvm -o - %s")./*|*/
      I("FileCheck -check-prefix=CHECK-10_6 %s");
  }

  @Test
  public void test_attr_cleanup_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/attr-cleanup.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/attr-cleanup.c -o ${TEST_TEMP_DIR}/attr-cleanup.c.tmp
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm %s -o %t");
  }

  @Test
  public void test_attr_coldhot_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/attr-coldhot.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/attr-coldhot.c -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/attr-coldhot.c
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm %s -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_attr_disable_tail_calls_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/attr-disable-tail-calls.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-apple-macosx10.7.0 ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/attr-disable-tail-calls.c -emit-llvm -mdisable-tail-calls -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/attr-disable-tail-calls.c -check-prefix=DISABLE
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-apple-macosx10.7.0 %s -emit-llvm -mdisable-tail-calls -o -")./*|*/
      I("FileCheck %s -check-prefix=DISABLE");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-apple-macosx10.7.0 ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/attr-disable-tail-calls.c -emit-llvm -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/attr-disable-tail-calls.c -check-prefix=ENABLE
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-apple-macosx10.7.0 %s -emit-llvm -o -")./*|*/
      I("FileCheck %s -check-prefix=ENABLE");
  }

  @Test
  public void test_attr_func_def_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/attr-func-def.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-apple-macosx10.10.0 -emit-llvm -Oz -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/attr-func-def.c | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/attr-func-def.c
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-apple-macosx10.10.0 -emit-llvm -Oz -o - %s")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_attr_minsize_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/attr-minsize.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -Oz -disable-llvm-optzns -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/attr-minsize.cpp -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/attr-minsize.cpp -check-prefix=Oz
    RUN(TestState.Failed, "%clang_cc1 -Oz -disable-llvm-optzns -emit-llvm %s -o -")./*|*/
      I("FileCheck %s -check-prefix=Oz");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -disable-llvm-optzns -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/attr-minsize.cpp -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/attr-minsize.cpp -check-prefix=OTHER
    RUN(TestState.Failed, "%clang_cc1     -disable-llvm-optzns -emit-llvm %s -o -")./*|*/
      I("FileCheck %s -check-prefix=OTHER");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -O1 -disable-llvm-optzns -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/attr-minsize.cpp -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/attr-minsize.cpp -check-prefix=OTHER
    RUN(TestState.Failed, "%clang_cc1 -O1 -disable-llvm-optzns -emit-llvm %s -o -")./*|*/
      I("FileCheck %s -check-prefix=OTHER");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -O2 -disable-llvm-optzns -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/attr-minsize.cpp -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/attr-minsize.cpp -check-prefix=OTHER
    RUN(TestState.Failed, "%clang_cc1 -O2 -disable-llvm-optzns -emit-llvm %s -o -")./*|*/
      I("FileCheck %s -check-prefix=OTHER");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -O3 -disable-llvm-optzns -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/attr-minsize.cpp -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/attr-minsize.cpp -check-prefix=OTHER
    RUN(TestState.Failed, "%clang_cc1 -O3 -disable-llvm-optzns -emit-llvm %s -o -")./*|*/
      I("FileCheck %s -check-prefix=OTHER");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -Os -disable-llvm-optzns -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/attr-minsize.cpp -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/attr-minsize.cpp -check-prefix=OTHER
    RUN(TestState.Failed, "%clang_cc1 -Os -disable-llvm-optzns -emit-llvm %s -o -")./*|*/
      I("FileCheck %s -check-prefix=OTHER");
  }

  @Test
  public void test_attr_mode_enums_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/attr-mode-enums.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-unknown-unknown -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/attr-mode-enums.c -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/attr-mode-enums.c
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-unknown-unknown -emit-llvm %s -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_attr_mode_vector_types_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/attr-mode-vector-types.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-unknown-unknown ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/attr-mode-vector-types.c -emit-llvm -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/attr-mode-vector-types.c
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-unknown-unknown %s -emit-llvm -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_attr_naked_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/attr-naked.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-apple-macosx10.7.0 ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/attr-naked.c -emit-llvm -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/attr-naked.c
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-apple-macosx10.7.0 %s -emit-llvm -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_attr_no_tail_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/attr-no-tail.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-apple-macosx10.7.0 ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/attr-no-tail.c -emit-llvm -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/attr-no-tail.c
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-apple-macosx10.7.0 %s -emit-llvm -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_attr_nodebug_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/attr-nodebug.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -debug-info-kind=limited -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/attr-nodebug.c | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/attr-nodebug.c
    RUN(TestState.Failed, "%clang_cc1 -debug-info-kind=limited -emit-llvm -o - %s")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_attr_noinline_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/attr-noinline.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -debug-info-kind=limited -emit-llvm -o ${TEST_TEMP_DIR}/attr-noinline.c.tmp ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/attr-noinline.c
    RUN(TestState.Failed, "%clang_cc1 -debug-info-kind=limited -emit-llvm -o %t %s");
    // grep noinline ${TEST_TEMP_DIR}/attr-noinline.c.tmp
    RUN(TestState.Failed, "grep 'noinline' %t");
  }

  @Test
  public void test_attr_optnone_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/attr-optnone.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm < ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/attr-optnone.c > ${TEST_TEMP_DIR}/attr-optnone.c.tmp
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm < %s > %t");
    // ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/attr-optnone.c --check-prefix=PRESENT < ${TEST_TEMP_DIR}/attr-optnone.c.tmp
    RUN(TestState.Failed, "FileCheck %s --check-prefix=PRESENT < %t");
    // ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/attr-optnone.c --check-prefix=ABSENT < ${TEST_TEMP_DIR}/attr-optnone.c.tmp
    RUN(TestState.Failed, "FileCheck %s --check-prefix=ABSENT  < %t");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm -Os < ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/attr-optnone.c > ${TEST_TEMP_DIR}/attr-optnone.c.tmp
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm -Os < %s > %t");
    // ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/attr-optnone.c --check-prefix=PRESENT < ${TEST_TEMP_DIR}/attr-optnone.c.tmp
    RUN(TestState.Failed, "FileCheck %s --check-prefix=PRESENT < %t");
    // ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/attr-optnone.c --check-prefix=OPTSIZE < ${TEST_TEMP_DIR}/attr-optnone.c.tmp
    RUN(TestState.Failed, "FileCheck %s --check-prefix=OPTSIZE < %t");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm -Oz < ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/attr-optnone.c > ${TEST_TEMP_DIR}/attr-optnone.c.tmp
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm -Oz < %s > %t");
    // ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/attr-optnone.c --check-prefix=PRESENT < ${TEST_TEMP_DIR}/attr-optnone.c.tmp
    RUN(TestState.Failed, "FileCheck %s --check-prefix=PRESENT < %t");
    // ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/attr-optnone.c --check-prefix=MINSIZE < ${TEST_TEMP_DIR}/attr-optnone.c.tmp
    RUN(TestState.Failed, "FileCheck %s --check-prefix=MINSIZE < %t");
  }

  @Test
  public void test_attr_target_ppc_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/attr-target-ppc.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple powerpc64le-linux-gnu -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/attr-target-ppc.c -o -
    RUN(TestState.Failed, "not %clang_cc1 -triple powerpc64le-linux-gnu -emit-llvm %s -o -");
  }

  @Test
  public void test_attr_target_x86_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/attr-target-x86.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-linux-gnu -target-cpu x86-64 -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/attr-target-x86.c -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/attr-target-x86.c
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-linux-gnu -target-cpu x86-64 -emit-llvm %s -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_attr_target_x86_mmx_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/attr-target-x86-mmx.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i386-linux-gnu -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/attr-target-x86-mmx.c -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/attr-target-x86-mmx.c
    RUN(TestState.Failed, "%clang_cc1 -triple i386-linux-gnu -emit-llvm %s -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_attr_target_x87_softfp_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/attr-target-x87-softfp.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-linux-gnu -target-cpu x86-64 -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/attr-target-x87-softfp.c -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/attr-target-x87-softfp.c -check-prefix=CHECK -check-prefix=HARD
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-linux-gnu -target-cpu x86-64 -emit-llvm %s -o -")./*|*/
      I("FileCheck %s -check-prefix=CHECK -check-prefix=HARD");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -msoft-float -triple x86_64-linux-gnu -target-cpu x86-64 -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/attr-target-x87-softfp.c -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/attr-target-x87-softfp.c -check-prefix=CHECK -check-prefix=SOFT
    RUN(TestState.Failed, "%clang_cc1 -msoft-float -triple x86_64-linux-gnu -target-cpu x86-64 -emit-llvm %s -o -")./*|*/
      I("FileCheck %s -check-prefix=CHECK -check-prefix=SOFT");
  }

  @Test
  public void test_attr_used_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/attr-used.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm -o ${TEST_TEMP_DIR}/attr-used.c.tmp ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/attr-used.c
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm -o %t %s");
    // grep '@llvm.used = .*@a0' ${TEST_TEMP_DIR}/attr-used.c.tmp
    RUN(TestState.Failed, "grep '@llvm.used = .*@a0' %t");
    // grep '@llvm.used = .*@g0' ${TEST_TEMP_DIR}/attr-used.c.tmp
    RUN(TestState.Failed, "grep '@llvm.used = .*@g0' %t");
    // grep '@llvm.used = .*@f0' ${TEST_TEMP_DIR}/attr-used.c.tmp
    RUN(TestState.Failed, "grep '@llvm.used = .*@f0' %t");
    // grep '@llvm.used = .*@f1.l0' ${TEST_TEMP_DIR}/attr-used.c.tmp
    RUN(TestState.Failed, "grep '@llvm.used = .*@f1.l0' %t");
  }

  @Test
  public void test_attr_weak_import_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/attr-weak-import.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-darwin-apple -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/attr-weak-import.c | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/attr-weak-import.c
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-darwin-apple -emit-llvm -o - %s")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_attr_weakref_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/attr-weakref.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm -triple i386-linux-gnu -o ${TEST_TEMP_DIR}/attr-weakref.c.tmp ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/attr-weakref.c
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm -triple i386-linux-gnu -o %t %s");
    // ${LLVM_SRC}/build/bin/FileCheck '--input-file=${TEST_TEMP_DIR}/attr-weakref.c.tmp' ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/attr-weakref.c
    RUN(TestState.Failed, "FileCheck --input-file=%t %s");
  }

  @Test
  public void test_attr_weakref2_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/attr-weakref2.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm -triple i386-linux-gnu -o ${TEST_TEMP_DIR}/attr-weakref2.c.tmp ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/attr-weakref2.c
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm -triple i386-linux-gnu -o %t %s");
    // ${LLVM_SRC}/build/bin/FileCheck '--input-file=${TEST_TEMP_DIR}/attr-weakref2.c.tmp' ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/attr-weakref2.c
    RUN(TestState.Failed, "FileCheck --input-file=%t %s");
  }

  @Test
  public void test_attr_x86_interrupt_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/attr-x86-interrupt.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-unknown-linux-gnu ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/attr-x86-interrupt.c -emit-llvm -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/attr-x86-interrupt.c --check-prefix=X86_64_LINUX
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-unknown-linux-gnu %s -emit-llvm -o -")./*|*/
      I("FileCheck %s --check-prefix=X86_64_LINUX");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i386-unknown-linux-gnu ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/attr-x86-interrupt.c -emit-llvm -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/attr-x86-interrupt.c --check-prefix=X86_LINUX
    RUN(TestState.Failed, "%clang_cc1 -triple i386-unknown-linux-gnu %s -emit-llvm -o -")./*|*/
      I("FileCheck %s --check-prefix=X86_LINUX");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-pc-win32 ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/attr-x86-interrupt.c -emit-llvm -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/attr-x86-interrupt.c --check-prefix=X86_64_WIN
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-pc-win32 %s -emit-llvm -o -")./*|*/
      I("FileCheck %s --check-prefix=X86_64_WIN");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i386-pc-win32 ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/attr-x86-interrupt.c -emit-llvm -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/attr-x86-interrupt.c --check-prefix=X86_WIN
    RUN(TestState.Failed, "%clang_cc1 -triple i386-pc-win32 %s -emit-llvm -o -")./*|*/
      I("FileCheck %s --check-prefix=X86_WIN");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-unknown-linux-gnux32 ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/attr-x86-interrupt.c -emit-llvm -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/attr-x86-interrupt.c --check-prefix=X86_64_LINUX
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-unknown-linux-gnux32 %s -emit-llvm -o -")./*|*/
      I("FileCheck %s --check-prefix=X86_64_LINUX");
  }

  @Test
  public void test_attribute_section_data_common_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/attribute-section-data-common.c");
    // ${LLVM_SRC}/build/bin/clang -S ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/attribute-section-data-common.c -o /dev/null
    RUN(TestState.Failed, "%clang -S %s -o /dev/null");
  }

  @Test
  public void test_attribute_constructor_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/attribute_constructor.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/attribute_constructor.c -emit-llvm -o - | grep llvm.global_ctors
    RUN(TestState.Failed, "%clang_cc1 %s -emit-llvm -o -")./*|*/
      I("grep llvm.global_ctors");
  }

  @Test
  public void test_attributes_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/attributes.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm -triple i386-linux-gnu -o ${TEST_TEMP_DIR}/attributes.c.tmp ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/attributes.c
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm -triple i386-linux-gnu -o %t %s");
    // ${LLVM_SRC}/build/bin/FileCheck '--input-file=${TEST_TEMP_DIR}/attributes.c.tmp' ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/attributes.c
    RUN(TestState.Failed, "FileCheck --input-file=%t %s");
  }

  @Test
  public void test_available_externally_hidden_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/available-externally-hidden.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -O2 -fvisibility hidden -std=c++11 -emit-llvm -o - -triple x86_64-apple-darwin10 ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/available-externally-hidden.cpp | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/available-externally-hidden.cpp
    RUN(TestState.Failed, "%clang_cc1 -O2 -fvisibility hidden -std=c++11 -emit-llvm -o - -triple x86_64-apple-darwin10 %s")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_available_externally_suppress_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/available-externally-suppress.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm -o - -triple x86_64-apple-darwin10 ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/available-externally-suppress.c | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/available-externally-suppress.c
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm -o - -triple x86_64-apple-darwin10 %s")./*|*/
      I("FileCheck %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -O2 -fno-inline -emit-llvm -o - -triple x86_64-apple-darwin10 ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/available-externally-suppress.c | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/available-externally-suppress.c
    RUN(TestState.Failed, "%clang_cc1 -O2 -fno-inline -emit-llvm -o - -triple x86_64-apple-darwin10 %s")./*|*/
      I("FileCheck %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -flto -O2 -fno-inline -emit-llvm -o - -triple x86_64-apple-darwin10 ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/available-externally-suppress.c | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/available-externally-suppress.c -check-prefix=LTO
    RUN(TestState.Failed, "%clang_cc1 -flto -O2 -fno-inline -emit-llvm -o - -triple x86_64-apple-darwin10 %s")./*|*/
      I("FileCheck %s -check-prefix=LTO");
  }

  @Test
  public void test_avx_builtins_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/avx-builtins.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/avx-builtins.c -triple=x86_64-apple-darwin -target-feature +avx -emit-llvm -o - -Werror | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/avx-builtins.c
    RUN(TestState.Failed, "%clang_cc1 %s -triple=x86_64-apple-darwin -target-feature +avx -emit-llvm -o - -Werror")./*|*/
      I("FileCheck %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/avx-builtins.c -triple=x86_64-apple-darwin -target-feature +avx -fno-signed-char -emit-llvm -o - -Werror | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/avx-builtins.c
    RUN(TestState.Failed, "%clang_cc1 %s -triple=x86_64-apple-darwin -target-feature +avx -fno-signed-char -emit-llvm -o - -Werror")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_avx_cmp_builtins_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/avx-cmp-builtins.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/avx-cmp-builtins.c -O3 -triple=x86_64-apple-darwin -target-feature +avx -emit-llvm -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/avx-cmp-builtins.c
    RUN(TestState.Failed, "%clang_cc1 %s -O3 -triple=x86_64-apple-darwin -target-feature +avx -emit-llvm -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_avx_shuffle_builtins_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/avx-shuffle-builtins.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/avx-shuffle-builtins.c -O3 -triple=x86_64-apple-darwin -target-feature +avx -emit-llvm -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/avx-shuffle-builtins.c
    RUN(TestState.Failed, "%clang_cc1 %s -O3 -triple=x86_64-apple-darwin -target-feature +avx -emit-llvm -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_avx2_builtins_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/avx2-builtins.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/avx2-builtins.c -triple=x86_64-apple-darwin -target-feature +avx2 -emit-llvm -o - -Werror | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/avx2-builtins.c
    RUN(TestState.Failed, "%clang_cc1 %s -triple=x86_64-apple-darwin -target-feature +avx2 -emit-llvm -o - -Werror")./*|*/
      I("FileCheck %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/avx2-builtins.c -triple=x86_64-apple-darwin -target-feature +avx2 -fno-signed-char -emit-llvm -o - -Werror | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/avx2-builtins.c
    RUN(TestState.Failed, "%clang_cc1 %s -triple=x86_64-apple-darwin -target-feature +avx2 -fno-signed-char -emit-llvm -o - -Werror")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_avx512bw_builtins_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/avx512bw-builtins.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/avx512bw-builtins.c -triple=x86_64-apple-darwin -target-feature +avx512bw -emit-llvm -o - -Werror | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/avx512bw-builtins.c
    RUN(TestState.Failed, "%clang_cc1 %s -triple=x86_64-apple-darwin -target-feature +avx512bw -emit-llvm -o - -Werror")./*|*/
      I("FileCheck %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/avx512bw-builtins.c -triple=x86_64-apple-darwin -target-feature +avx512bw -fno-signed-char -emit-llvm -o - -Werror | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/avx512bw-builtins.c
    RUN(TestState.Failed, "%clang_cc1 %s -triple=x86_64-apple-darwin -target-feature +avx512bw -fno-signed-char -emit-llvm -o - -Werror")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_avx512cdintrin_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/avx512cdintrin.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/avx512cdintrin.c -triple=x86_64-apple-darwin -target-feature +avx512cd -emit-llvm -o - -Werror | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/avx512cdintrin.c
    RUN(TestState.Failed, "%clang_cc1 %s -triple=x86_64-apple-darwin -target-feature +avx512cd -emit-llvm -o - -Werror")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_avx512dq_builtins_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/avx512dq-builtins.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/avx512dq-builtins.c -triple=x86_64-apple-darwin -target-feature +avx512dq -emit-llvm -o - -Werror | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/avx512dq-builtins.c
    RUN(TestState.Failed, "%clang_cc1 %s -triple=x86_64-apple-darwin -target-feature +avx512dq -emit-llvm -o - -Werror")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_avx512er_builtins_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/avx512er-builtins.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/avx512er-builtins.c -triple=x86_64-apple-darwin -target-feature +avx512f -target-feature +avx512er -emit-llvm -o - -Werror | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/avx512er-builtins.c
    RUN(TestState.Failed, "%clang_cc1 %s -triple=x86_64-apple-darwin -target-feature +avx512f -target-feature +avx512er -emit-llvm -o - -Werror")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_avx512f_builtins_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/avx512f-builtins.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/avx512f-builtins.c -triple=x86_64-apple-darwin -target-feature +avx512f -emit-llvm -o - -Werror | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/avx512f-builtins.c
    RUN(TestState.Failed, "%clang_cc1 %s -triple=x86_64-apple-darwin -target-feature +avx512f -emit-llvm -o - -Werror")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_avx512ifma_builtins_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/avx512ifma-builtins.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/avx512ifma-builtins.c -triple=x86_64-apple-darwin -target-feature +avx512ifma -emit-llvm -o - -Werror | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/avx512ifma-builtins.c
    RUN(TestState.Failed, "%clang_cc1 %s -triple=x86_64-apple-darwin -target-feature +avx512ifma -emit-llvm -o - -Werror")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_avx512ifmavl_builtins_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/avx512ifmavl-builtins.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/avx512ifmavl-builtins.c -triple=x86_64-apple-darwin -target-feature +avx512ifma -target-feature +avx512vl -emit-llvm -o - -Werror | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/avx512ifmavl-builtins.c
    RUN(TestState.Failed, "%clang_cc1 %s -triple=x86_64-apple-darwin -target-feature +avx512ifma -target-feature +avx512vl -emit-llvm -o - -Werror")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_avx512pf_builtins_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/avx512pf-builtins.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/avx512pf-builtins.c -triple=x86_64-apple-darwin -target-feature +avx512pf -emit-llvm -o - -Werror | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/avx512pf-builtins.c
    RUN(TestState.Failed, "%clang_cc1 %s -triple=x86_64-apple-darwin -target-feature +avx512pf -emit-llvm -o - -Werror")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_avx512vbmi_builtins_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/avx512vbmi-builtins.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/avx512vbmi-builtins.c -triple=x86_64-apple-darwin -target-feature +avx512vbmi -emit-llvm -o - -Werror | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/avx512vbmi-builtins.c
    RUN(TestState.Failed, "%clang_cc1 %s -triple=x86_64-apple-darwin -target-feature +avx512vbmi -emit-llvm -o - -Werror")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_avx512vbmivl_builtin_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/avx512vbmivl-builtin.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/avx512vbmivl-builtin.c -triple=x86_64-apple-darwin -target-feature +avx512vbmi -target-feature +avx512vl -target-feature +avx512bw -emit-llvm -o - -Werror | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/avx512vbmivl-builtin.c
    RUN(TestState.Failed, "%clang_cc1 %s -triple=x86_64-apple-darwin -target-feature +avx512vbmi -target-feature +avx512vl -target-feature +avx512bw -emit-llvm -o - -Werror")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_avx512vl_builtins_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/avx512vl-builtins.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/avx512vl-builtins.c -triple=x86_64-apple-darwin -target-feature +avx512f -target-feature +avx512vl -emit-llvm -o - -Werror | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/avx512vl-builtins.c
    RUN(TestState.Failed, "%clang_cc1 %s -triple=x86_64-apple-darwin -target-feature +avx512f -target-feature +avx512vl -emit-llvm -o - -Werror")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_avx512vlbw_builtins_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/avx512vlbw-builtins.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/avx512vlbw-builtins.c -triple=x86_64-apple-darwin -target-feature +avx512bw -target-feature +avx512vl -emit-llvm -o - -Werror | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/avx512vlbw-builtins.c
    RUN(TestState.Failed, "%clang_cc1 %s -triple=x86_64-apple-darwin -target-feature +avx512bw -target-feature +avx512vl -emit-llvm -o - -Werror")./*|*/
      I("FileCheck %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/avx512vlbw-builtins.c -triple=x86_64-apple-darwin -target-feature +avx512bw -target-feature +avx512vl -fno-signed-char -emit-llvm -o - -Werror | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/avx512vlbw-builtins.c
    RUN(TestState.Failed, "%clang_cc1 %s -triple=x86_64-apple-darwin -target-feature +avx512bw -target-feature +avx512vl -fno-signed-char -emit-llvm -o - -Werror")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_avx512vlcd_builtins_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/avx512vlcd-builtins.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/avx512vlcd-builtins.c -triple=x86_64-apple-darwin -target-feature +avx512vl -target-feature +avx512cd -emit-llvm -o - -Werror | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/avx512vlcd-builtins.c
    RUN(TestState.Failed, "%clang_cc1 %s -triple=x86_64-apple-darwin -target-feature +avx512vl -target-feature +avx512cd -emit-llvm -o - -Werror")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_avx512vldq_builtins_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/avx512vldq-builtins.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/avx512vldq-builtins.c -triple=x86_64-apple-darwin -target-feature +avx512dq -target-feature +avx512vl -emit-llvm -o - -Werror | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/avx512vldq-builtins.c
    RUN(TestState.Failed, "%clang_cc1 %s -triple=x86_64-apple-darwin -target-feature +avx512dq -target-feature +avx512vl -emit-llvm -o - -Werror")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_big_atomic_ops_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/big-atomic-ops.c");
    // REQUIRES: x86-registered-target
    if (!CHECK_REQUIRES("x86-registered-target")) {
      return;
    }
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/big-atomic-ops.c -emit-llvm -o - -triple=x86_64-apple-macosx10.9.0 | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/big-atomic-ops.c
    RUN(TestState.Failed, "%clang_cc1 %s -emit-llvm -o - -triple=x86_64-apple-macosx10.9.0")./*|*/
      I("FileCheck %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/big-atomic-ops.c -emit-pch -o ${TEST_TEMP_DIR}/big-atomic-ops.c.tmp -triple=x86_64-apple-macosx10.9.0
    RUN(TestState.Failed, "%clang_cc1 %s -emit-pch -o %t -triple=x86_64-apple-macosx10.9.0");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/big-atomic-ops.c -include-pch ${TEST_TEMP_DIR}/big-atomic-ops.c.tmp -triple=x86_64-apple-macosx10.9.0 -emit-llvm -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/big-atomic-ops.c
    RUN(TestState.Failed, "%clang_cc1 %s -include-pch %t -triple=x86_64-apple-macosx10.9.0 -emit-llvm -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_bitfield_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/bitfield.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i386-unknown-unknown ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/bitfield.c -emit-llvm -o - -O3 -no-struct-path-tbaa | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/bitfield.c
    RUN(TestState.Failed, "%clang_cc1 -triple i386-unknown-unknown %s -emit-llvm -o - -O3 -no-struct-path-tbaa")./*|*/
      I("FileCheck %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i386-unknown-unknown ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/bitfield.c -emit-llvm -o - -O3 | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/bitfield.c --check-prefix=PATH
    RUN(TestState.Failed, "%clang_cc1 -triple i386-unknown-unknown %s -emit-llvm -o - -O3")./*|*/
      I("FileCheck %s --check-prefix=PATH");
  }

  @Test
  public void test_bitfield_2_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/bitfield-2.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm -triple x86_64 -O3 -o ${TEST_TEMP_DIR}/bitfield-2.c.tmp.opt.ll ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/bitfield-2.c -fdump-record-layouts > ${TEST_TEMP_DIR}/bitfield-2.c.tmp.dump.txt
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm -triple x86_64 -O3 -o %t.opt.ll %s -fdump-record-layouts > %t.dump.txt");
    // ${LLVM_SRC}/build/bin/FileCheck -check-prefix=CHECK-RECORD < ${TEST_TEMP_DIR}/bitfield-2.c.tmp.dump.txt ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/bitfield-2.c
    RUN(TestState.Failed, "FileCheck -check-prefix=CHECK-RECORD < %t.dump.txt %s");
    // ${LLVM_SRC}/build/bin/FileCheck -check-prefix=CHECK-OPT < ${TEST_TEMP_DIR}/bitfield-2.c.tmp.opt.ll ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/bitfield-2.c
    RUN(TestState.Failed, "FileCheck -check-prefix=CHECK-OPT < %t.opt.ll %s");
  }

  @Test
  public void test_bitfield_assign_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/bitfield-assign.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i386-unknown-unknown -emit-llvm -o ${TEST_TEMP_DIR}/bitfield-assign.c.tmp ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/bitfield-assign.c
    RUN(TestState.Failed, "%clang_cc1 -triple i386-unknown-unknown -emit-llvm -o %t %s");
    // grep 'load ' ${TEST_TEMP_DIR}/bitfield-assign.c.tmp | ${LLVM_SRC}/build/bin/count 5
    RUN(TestState.Failed, "grep 'load ' %t")./*|*/
      I("count 5");
    // grep @g0 ${TEST_TEMP_DIR}/bitfield-assign.c.tmp | ${LLVM_SRC}/build/bin/count 4
    RUN(TestState.Failed, "grep \"@g0\" %t")./*|*/
      I("count 4");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i386-unknown-unknown -O3 -emit-llvm -o ${TEST_TEMP_DIR}/bitfield-assign.c.tmp ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/bitfield-assign.c
    RUN(TestState.Failed, "%clang_cc1 -triple i386-unknown-unknown -O3 -emit-llvm -o %t %s");
    // grep 'load ' ${TEST_TEMP_DIR}/bitfield-assign.c.tmp
    RUN(TestState.Failed, "not grep 'load ' %t");
    // grep @g0 ${TEST_TEMP_DIR}/bitfield-assign.c.tmp
    RUN(TestState.Failed, "not grep \"@g0\" %t");
  }

  @Test
  public void test_bitfield_init_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/bitfield-init.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/bitfield-init.c -emit-llvm -o ${TEST_TEMP_DIR}/bitfield-init.c.tmp
    RUN(TestState.Failed, "%clang_cc1 %s -emit-llvm -o %t");
  }

  @Test
  public void test_bitfield_promote_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/bitfield-promote.c");
    // ${LLVM_SRC}/build/bin/clang -O3 -emit-llvm -S -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/bitfield-promote.c | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/bitfield-promote.c
    RUN(TestState.Failed, "%clang -O3 -emit-llvm -S -o - %s")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_bitscan_builtins_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/bitscan-builtins.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-unknown-unknown -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/bitscan-builtins.c | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/bitscan-builtins.c
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-unknown-unknown -emit-llvm -o - %s")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_block_3_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/block-3.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/block-3.c -emit-llvm -o - -fblocks -triple x86_64-apple-darwin10
    RUN(TestState.Failed, "%clang_cc1 %s -emit-llvm -o - -fblocks -triple x86_64-apple-darwin10");
  }

  @Test
  public void test_block_byref_aggr_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/block-byref-aggr.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/block-byref-aggr.c -emit-llvm -o - -fblocks -triple x86_64-apple-darwin10 | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/block-byref-aggr.c
    RUN(TestState.Failed, "%clang_cc1 %s -emit-llvm -o - -fblocks -triple x86_64-apple-darwin10")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_block_copy_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/block-copy.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/block-copy.c -emit-llvm -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/block-copy.c
    RUN(TestState.Failed, "%clang_cc1 %s -emit-llvm -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_block_with_perdefinedexpr_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/block-with-perdefinedexpr.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/block-with-perdefinedexpr.c -emit-llvm -o - -fblocks -triple x86_64-apple-darwin10 | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/block-with-perdefinedexpr.c
    RUN(TestState.Failed, "%clang_cc1 %s -emit-llvm -o - -fblocks -triple x86_64-apple-darwin10")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_blocks_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/blocks.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i386-unknown-unknown ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/blocks.c -emit-llvm -o - -fblocks | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/blocks.c
    RUN(TestState.Failed, "%clang_cc1 -triple i386-unknown-unknown %s -emit-llvm -o - -fblocks")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_blocks_1_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/blocks-1.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/blocks-1.c -emit-llvm -o ${TEST_TEMP_DIR}/blocks-1.c.tmp -fblocks
    RUN(TestState.Failed, "%clang_cc1 %s -emit-llvm -o %t -fblocks");
    // grep _Block_object_dispose ${TEST_TEMP_DIR}/blocks-1.c.tmp | ${LLVM_SRC}/build/bin/count 17
    RUN(TestState.Failed, "grep \"_Block_object_dispose\" %t")./*|*/
      I("count 17");
    // grep __copy_helper_block_ ${TEST_TEMP_DIR}/blocks-1.c.tmp | ${LLVM_SRC}/build/bin/count 14
    RUN(TestState.Failed, "grep \"__copy_helper_block_\" %t")./*|*/
      I("count 14");
    // grep __destroy_helper_block_ ${TEST_TEMP_DIR}/blocks-1.c.tmp | ${LLVM_SRC}/build/bin/count 14
    RUN(TestState.Failed, "grep \"__destroy_helper_block_\" %t")./*|*/
      I("count 14");
    // grep __Block_byref_object_copy_ ${TEST_TEMP_DIR}/blocks-1.c.tmp | ${LLVM_SRC}/build/bin/count 2
    RUN(TestState.Failed, "grep \"__Block_byref_object_copy_\" %t")./*|*/
      I("count 2");
    // grep __Block_byref_object_dispose_ ${TEST_TEMP_DIR}/blocks-1.c.tmp | ${LLVM_SRC}/build/bin/count 2
    RUN(TestState.Failed, "grep \"__Block_byref_object_dispose_\" %t")./*|*/
      I("count 2");
    // grep 'i32 135)' ${TEST_TEMP_DIR}/blocks-1.c.tmp | ${LLVM_SRC}/build/bin/count 2
    RUN(TestState.Failed, "grep \"i32 135)\" %t")./*|*/
      I("count 2");
    // grep _Block_object_assign ${TEST_TEMP_DIR}/blocks-1.c.tmp | ${LLVM_SRC}/build/bin/count 10
    RUN(TestState.Failed, "grep \"_Block_object_assign\" %t")./*|*/
      I("count 10");
  }

  @Test
  public void test_blocks_aligned_byref_variable_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/blocks-aligned-byref-variable.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm -o - -triple x86_64-apple-darwin10 -fblocks ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/blocks-aligned-byref-variable.c
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm -o - -triple x86_64-apple-darwin10 -fblocks %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm -o - -triple i386-apple-darwin10 -fblocks ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/blocks-aligned-byref-variable.c
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm -o - -triple i386-apple-darwin10 -fblocks %s");
  }

  @Test
  public void test_blocks_opencl_cl() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/blocks-opencl.cl");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -O0 ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/blocks-opencl.cl -ffake-address-space-map -emit-llvm -o - -fblocks -triple x86_64-unknown-unknown | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/blocks-opencl.cl
    RUN(TestState.Failed, "%clang_cc1 -O0 %s -ffake-address-space-map -emit-llvm -o - -fblocks -triple x86_64-unknown-unknown")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_blocks_seq_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/blocks-seq.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fblocks -triple x86_64-apple-darwin10 -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/blocks-seq.c | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/blocks-seq.c
    RUN(TestState.Failed, "%clang_cc1 -fblocks -triple x86_64-apple-darwin10 -emit-llvm -o - %s")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_blocks_windows_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/blocks-windows.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple thumbv7-windows -fblocks -fdeclspec -DBLOCKS_IN_BLOCKS_DECL -S -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/blocks-windows.c -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/blocks-windows.c -check-prefix CHECK-BLOCKS-IN-BLOCKS-DECL
    RUN(TestState.Failed, "%clang_cc1 -triple thumbv7-windows -fblocks -fdeclspec -DBLOCKS_IN_BLOCKS_DECL -S -emit-llvm %s -o -")./*|*/
      I("FileCheck %s -check-prefix CHECK-BLOCKS-IN-BLOCKS-DECL");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple thumbv7-windows -fblocks -fdeclspec -DBLOCKS_IN_BLOCKS_DEFN -S -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/blocks-windows.c -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/blocks-windows.c -check-prefix CHECK-BLOCKS-IN-BLOCKS-DEFN
    RUN(TestState.Failed, "%clang_cc1 -triple thumbv7-windows -fblocks -fdeclspec -DBLOCKS_IN_BLOCKS_DEFN -S -emit-llvm %s -o -")./*|*/
      I("FileCheck %s -check-prefix CHECK-BLOCKS-IN-BLOCKS-DEFN");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple thumbv7-windows -fblocks -fdeclspec -S -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/blocks-windows.c -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/blocks-windows.c -check-prefix CHECK-BLOCKS-NOT-IN-BLOCKS
    RUN(TestState.Failed, "%clang_cc1 -triple thumbv7-windows -fblocks -fdeclspec -S -emit-llvm %s -o -")./*|*/
      I("FileCheck %s -check-prefix CHECK-BLOCKS-NOT-IN-BLOCKS");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple thumbv7-windows -fblocks -fdeclspec -DBLOCKS_NOT_IN_BLOCKS_EXTERN -S -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/blocks-windows.c -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/blocks-windows.c -check-prefix CHECK-BLOCKS-NOT-IN-BLOCKS-EXTERN
    RUN(TestState.Failed, "%clang_cc1 -triple thumbv7-windows -fblocks -fdeclspec -DBLOCKS_NOT_IN_BLOCKS_EXTERN -S -emit-llvm %s -o -")./*|*/
      I("FileCheck %s -check-prefix CHECK-BLOCKS-NOT-IN-BLOCKS-EXTERN");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple thumbv7-windows -fblocks -fdeclspec -DBLCOKS_NOT_IN_BLOCKS_EXTERN_DLLIMPORT -S -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/blocks-windows.c -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/blocks-windows.c -check-prefix CHECK-BLOCKS-NOT-IN-BLOCKS-EXTERN-DLLIMPORT
    RUN(TestState.Failed, "%clang_cc1 -triple thumbv7-windows -fblocks -fdeclspec -DBLCOKS_NOT_IN_BLOCKS_EXTERN_DLLIMPORT -S -emit-llvm %s -o -")./*|*/
      I("FileCheck %s -check-prefix CHECK-BLOCKS-NOT-IN-BLOCKS-EXTERN-DLLIMPORT");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple thumbv7-windows -fblocks -fdeclspec -DBLCOKS_NOT_IN_BLOCKS_DLLIMPORT -S -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/blocks-windows.c -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/blocks-windows.c -check-prefix CHECK-BLOCKS-NOT-IN-BLOCKS-DLLIMPORT
    RUN(TestState.Failed, "%clang_cc1 -triple thumbv7-windows -fblocks -fdeclspec -DBLCOKS_NOT_IN_BLOCKS_DLLIMPORT -S -emit-llvm %s -o -")./*|*/
      I("FileCheck %s -check-prefix CHECK-BLOCKS-NOT-IN-BLOCKS-DLLIMPORT");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple thumbv7-windows -fblocks -fdeclspec -DBLOCKS_IN_BLOCKS_DECL -Os -S -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/blocks-windows.c -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/blocks-windows.c -check-prefix CHECK-BLOCKS-IN-BLOCKS-DECL
    RUN(TestState.Failed, "%clang_cc1 -triple thumbv7-windows -fblocks -fdeclspec -DBLOCKS_IN_BLOCKS_DECL -Os -S -emit-llvm %s -o -")./*|*/
      I("FileCheck %s -check-prefix CHECK-BLOCKS-IN-BLOCKS-DECL");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple thumbv7-windows -fblocks -fdeclspec -DBLOCKS_IN_BLOCKS_DEFN -Os -S -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/blocks-windows.c -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/blocks-windows.c -check-prefix CHECK-BLOCKS-IN-BLOCKS-DEFN
    RUN(TestState.Failed, "%clang_cc1 -triple thumbv7-windows -fblocks -fdeclspec -DBLOCKS_IN_BLOCKS_DEFN -Os -S -emit-llvm %s -o -")./*|*/
      I("FileCheck %s -check-prefix CHECK-BLOCKS-IN-BLOCKS-DEFN");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple thumbv7-windows -fblocks -fdeclspec -Os -S -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/blocks-windows.c -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/blocks-windows.c -check-prefix CHECK-BLOCKS-NOT-IN-BLOCKS
    RUN(TestState.Failed, "%clang_cc1 -triple thumbv7-windows -fblocks -fdeclspec -Os -S -emit-llvm %s -o -")./*|*/
      I("FileCheck %s -check-prefix CHECK-BLOCKS-NOT-IN-BLOCKS");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple thumbv7-windows -fblocks -fdeclspec -DBLOCKS_NOT_IN_BLOCKS_EXTERN -Os -S -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/blocks-windows.c -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/blocks-windows.c -check-prefix CHECK-BLOCKS-NOT-IN-BLOCKS-EXTERN
    RUN(TestState.Failed, "%clang_cc1 -triple thumbv7-windows -fblocks -fdeclspec -DBLOCKS_NOT_IN_BLOCKS_EXTERN -Os -S -emit-llvm %s -o -")./*|*/
      I("FileCheck %s -check-prefix CHECK-BLOCKS-NOT-IN-BLOCKS-EXTERN");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple thumbv7-windows -fblocks -fdeclspec -DBLCOKS_NOT_IN_BLOCKS_EXTERN_DLLIMPORT -Os -S -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/blocks-windows.c -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/blocks-windows.c -check-prefix CHECK-BLOCKS-NOT-IN-BLOCKS-EXTERN-DLLIMPORT
    RUN(TestState.Failed, "%clang_cc1 -triple thumbv7-windows -fblocks -fdeclspec -DBLCOKS_NOT_IN_BLOCKS_EXTERN_DLLIMPORT -Os -S -emit-llvm %s -o -")./*|*/
      I("FileCheck %s -check-prefix CHECK-BLOCKS-NOT-IN-BLOCKS-EXTERN-DLLIMPORT");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple thumbv7-windows -fblocks -fdeclspec -DBLCOKS_NOT_IN_BLOCKS_DLLIMPORT -Os -S -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/blocks-windows.c -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/blocks-windows.c -check-prefix CHECK-BLOCKS-NOT-IN-BLOCKS-DLLIMPORT
    RUN(TestState.Failed, "%clang_cc1 -triple thumbv7-windows -fblocks -fdeclspec -DBLCOKS_NOT_IN_BLOCKS_DLLIMPORT -Os -S -emit-llvm %s -o -")./*|*/
      I("FileCheck %s -check-prefix CHECK-BLOCKS-NOT-IN-BLOCKS-DLLIMPORT");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i686-windows -fblocks -fdeclspec -DBLOCKS_IN_BLOCKS_DECL -S -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/blocks-windows.c -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/blocks-windows.c -check-prefix CHECK-BLOCKS-IN-BLOCKS-DECL
    RUN(TestState.Failed, "%clang_cc1 -triple i686-windows -fblocks -fdeclspec -DBLOCKS_IN_BLOCKS_DECL -S -emit-llvm %s -o -")./*|*/
      I("FileCheck %s -check-prefix CHECK-BLOCKS-IN-BLOCKS-DECL");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i686-windows -fblocks -fdeclspec -DBLOCKS_IN_BLOCKS_DEFN -S -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/blocks-windows.c -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/blocks-windows.c -check-prefix CHECK-BLOCKS-IN-BLOCKS-DEFN
    RUN(TestState.Failed, "%clang_cc1 -triple i686-windows -fblocks -fdeclspec -DBLOCKS_IN_BLOCKS_DEFN -S -emit-llvm %s -o -")./*|*/
      I("FileCheck %s -check-prefix CHECK-BLOCKS-IN-BLOCKS-DEFN");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i686-windows -fblocks -fdeclspec -S -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/blocks-windows.c -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/blocks-windows.c -check-prefix CHECK-BLOCKS-NOT-IN-BLOCKS
    RUN(TestState.Failed, "%clang_cc1 -triple i686-windows -fblocks -fdeclspec -S -emit-llvm %s -o -")./*|*/
      I("FileCheck %s -check-prefix CHECK-BLOCKS-NOT-IN-BLOCKS");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i686-windows -fblocks -fdeclspec -DBLOCKS_NOT_IN_BLOCKS_EXTERN -S -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/blocks-windows.c -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/blocks-windows.c -check-prefix CHECK-BLOCKS-NOT-IN-BLOCKS-EXTERN
    RUN(TestState.Failed, "%clang_cc1 -triple i686-windows -fblocks -fdeclspec -DBLOCKS_NOT_IN_BLOCKS_EXTERN -S -emit-llvm %s -o -")./*|*/
      I("FileCheck %s -check-prefix CHECK-BLOCKS-NOT-IN-BLOCKS-EXTERN");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i686-windows -fblocks -fdeclspec -DBLCOKS_NOT_IN_BLOCKS_EXTERN_DLLIMPORT -S -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/blocks-windows.c -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/blocks-windows.c -check-prefix CHECK-BLOCKS-NOT-IN-BLOCKS-EXTERN-DLLIMPORT
    RUN(TestState.Failed, "%clang_cc1 -triple i686-windows -fblocks -fdeclspec -DBLCOKS_NOT_IN_BLOCKS_EXTERN_DLLIMPORT -S -emit-llvm %s -o -")./*|*/
      I("FileCheck %s -check-prefix CHECK-BLOCKS-NOT-IN-BLOCKS-EXTERN-DLLIMPORT");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i686-windows -fblocks -fdeclspec -DBLCOKS_NOT_IN_BLOCKS_DLLIMPORT -S -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/blocks-windows.c -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/blocks-windows.c -check-prefix CHECK-BLOCKS-NOT-IN-BLOCKS-DLLIMPORT
    RUN(TestState.Failed, "%clang_cc1 -triple i686-windows -fblocks -fdeclspec -DBLCOKS_NOT_IN_BLOCKS_DLLIMPORT -S -emit-llvm %s -o -")./*|*/
      I("FileCheck %s -check-prefix CHECK-BLOCKS-NOT-IN-BLOCKS-DLLIMPORT");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i686-windows -fblocks -fdeclspec -DBLOCKS_IN_BLOCKS_DECL -Os -S -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/blocks-windows.c -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/blocks-windows.c -check-prefix CHECK-BLOCKS-IN-BLOCKS-DECL
    RUN(TestState.Failed, "%clang_cc1 -triple i686-windows -fblocks -fdeclspec -DBLOCKS_IN_BLOCKS_DECL -Os -S -emit-llvm %s -o -")./*|*/
      I("FileCheck %s -check-prefix CHECK-BLOCKS-IN-BLOCKS-DECL");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i686-windows -fblocks -fdeclspec -DBLOCKS_IN_BLOCKS_DEFN -Os -S -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/blocks-windows.c -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/blocks-windows.c -check-prefix CHECK-BLOCKS-IN-BLOCKS-DEFN
    RUN(TestState.Failed, "%clang_cc1 -triple i686-windows -fblocks -fdeclspec -DBLOCKS_IN_BLOCKS_DEFN -Os -S -emit-llvm %s -o -")./*|*/
      I("FileCheck %s -check-prefix CHECK-BLOCKS-IN-BLOCKS-DEFN");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i686-windows -fblocks -fdeclspec -Os -S -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/blocks-windows.c -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/blocks-windows.c -check-prefix CHECK-BLOCKS-NOT-IN-BLOCKS
    RUN(TestState.Failed, "%clang_cc1 -triple i686-windows -fblocks -fdeclspec -Os -S -emit-llvm %s -o -")./*|*/
      I("FileCheck %s -check-prefix CHECK-BLOCKS-NOT-IN-BLOCKS");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i686-windows -fblocks -fdeclspec -DBLOCKS_NOT_IN_BLOCKS_EXTERN -Os -S -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/blocks-windows.c -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/blocks-windows.c -check-prefix CHECK-BLOCKS-NOT-IN-BLOCKS-EXTERN
    RUN(TestState.Failed, "%clang_cc1 -triple i686-windows -fblocks -fdeclspec -DBLOCKS_NOT_IN_BLOCKS_EXTERN -Os -S -emit-llvm %s -o -")./*|*/
      I("FileCheck %s -check-prefix CHECK-BLOCKS-NOT-IN-BLOCKS-EXTERN");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i686-windows -fblocks -fdeclspec -DBLCOKS_NOT_IN_BLOCKS_EXTERN_DLLIMPORT -Os -S -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/blocks-windows.c -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/blocks-windows.c -check-prefix CHECK-BLOCKS-NOT-IN-BLOCKS-EXTERN-DLLIMPORT
    RUN(TestState.Failed, "%clang_cc1 -triple i686-windows -fblocks -fdeclspec -DBLCOKS_NOT_IN_BLOCKS_EXTERN_DLLIMPORT -Os -S -emit-llvm %s -o -")./*|*/
      I("FileCheck %s -check-prefix CHECK-BLOCKS-NOT-IN-BLOCKS-EXTERN-DLLIMPORT");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i686-windows -fblocks -fdeclspec -DBLCOKS_NOT_IN_BLOCKS_DLLIMPORT -Os -S -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/blocks-windows.c -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/blocks-windows.c -check-prefix CHECK-BLOCKS-NOT-IN-BLOCKS-DLLIMPORT
    RUN(TestState.Failed, "%clang_cc1 -triple i686-windows -fblocks -fdeclspec -DBLCOKS_NOT_IN_BLOCKS_DLLIMPORT -Os -S -emit-llvm %s -o -")./*|*/
      I("FileCheck %s -check-prefix CHECK-BLOCKS-NOT-IN-BLOCKS-DLLIMPORT");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-windows -fblocks -fdeclspec -DBLOCKS_IN_BLOCKS_DECL -S -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/blocks-windows.c -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/blocks-windows.c -check-prefix CHECK-BLOCKS-IN-BLOCKS-DECL
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-windows -fblocks -fdeclspec -DBLOCKS_IN_BLOCKS_DECL -S -emit-llvm %s -o -")./*|*/
      I("FileCheck %s -check-prefix CHECK-BLOCKS-IN-BLOCKS-DECL");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-windows -fblocks -fdeclspec -DBLOCKS_IN_BLOCKS_DEFN -S -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/blocks-windows.c -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/blocks-windows.c -check-prefix CHECK-BLOCKS-IN-BLOCKS-DEFN
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-windows -fblocks -fdeclspec -DBLOCKS_IN_BLOCKS_DEFN -S -emit-llvm %s -o -")./*|*/
      I("FileCheck %s -check-prefix CHECK-BLOCKS-IN-BLOCKS-DEFN");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-windows -fblocks -fdeclspec -S -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/blocks-windows.c -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/blocks-windows.c -check-prefix CHECK-BLOCKS-NOT-IN-BLOCKS
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-windows -fblocks -fdeclspec -S -emit-llvm %s -o -")./*|*/
      I("FileCheck %s -check-prefix CHECK-BLOCKS-NOT-IN-BLOCKS");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-windows -fblocks -fdeclspec -DBLOCKS_NOT_IN_BLOCKS_EXTERN -S -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/blocks-windows.c -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/blocks-windows.c -check-prefix CHECK-BLOCKS-NOT-IN-BLOCKS-EXTERN
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-windows -fblocks -fdeclspec -DBLOCKS_NOT_IN_BLOCKS_EXTERN -S -emit-llvm %s -o -")./*|*/
      I("FileCheck %s -check-prefix CHECK-BLOCKS-NOT-IN-BLOCKS-EXTERN");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-windows -fblocks -fdeclspec -DBLCOKS_NOT_IN_BLOCKS_EXTERN_DLLIMPORT -S -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/blocks-windows.c -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/blocks-windows.c -check-prefix CHECK-BLOCKS-NOT-IN-BLOCKS-EXTERN-DLLIMPORT
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-windows -fblocks -fdeclspec -DBLCOKS_NOT_IN_BLOCKS_EXTERN_DLLIMPORT -S -emit-llvm %s -o -")./*|*/
      I("FileCheck %s -check-prefix CHECK-BLOCKS-NOT-IN-BLOCKS-EXTERN-DLLIMPORT");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-windows -fblocks -fdeclspec -DBLCOKS_NOT_IN_BLOCKS_DLLIMPORT -S -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/blocks-windows.c -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/blocks-windows.c -check-prefix CHECK-BLOCKS-NOT-IN-BLOCKS-DLLIMPORT
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-windows -fblocks -fdeclspec -DBLCOKS_NOT_IN_BLOCKS_DLLIMPORT -S -emit-llvm %s -o -")./*|*/
      I("FileCheck %s -check-prefix CHECK-BLOCKS-NOT-IN-BLOCKS-DLLIMPORT");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-windows -fblocks -fdeclspec -DBLOCKS_IN_BLOCKS_DECL -Os -S -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/blocks-windows.c -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/blocks-windows.c -check-prefix CHECK-BLOCKS-IN-BLOCKS-DECL
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-windows -fblocks -fdeclspec -DBLOCKS_IN_BLOCKS_DECL -Os -S -emit-llvm %s -o -")./*|*/
      I("FileCheck %s -check-prefix CHECK-BLOCKS-IN-BLOCKS-DECL");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-windows -fblocks -fdeclspec -DBLOCKS_IN_BLOCKS_DEFN -Os -S -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/blocks-windows.c -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/blocks-windows.c -check-prefix CHECK-BLOCKS-IN-BLOCKS-DEFN
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-windows -fblocks -fdeclspec -DBLOCKS_IN_BLOCKS_DEFN -Os -S -emit-llvm %s -o -")./*|*/
      I("FileCheck %s -check-prefix CHECK-BLOCKS-IN-BLOCKS-DEFN");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-windows -fblocks -fdeclspec -Os -S -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/blocks-windows.c -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/blocks-windows.c -check-prefix CHECK-BLOCKS-NOT-IN-BLOCKS
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-windows -fblocks -fdeclspec -Os -S -emit-llvm %s -o -")./*|*/
      I("FileCheck %s -check-prefix CHECK-BLOCKS-NOT-IN-BLOCKS");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-windows -fblocks -fdeclspec -DBLOCKS_NOT_IN_BLOCKS_EXTERN -Os -S -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/blocks-windows.c -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/blocks-windows.c -check-prefix CHECK-BLOCKS-NOT-IN-BLOCKS-EXTERN
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-windows -fblocks -fdeclspec -DBLOCKS_NOT_IN_BLOCKS_EXTERN -Os -S -emit-llvm %s -o -")./*|*/
      I("FileCheck %s -check-prefix CHECK-BLOCKS-NOT-IN-BLOCKS-EXTERN");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-windows -fblocks -fdeclspec -DBLCOKS_NOT_IN_BLOCKS_EXTERN_DLLIMPORT -Os -S -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/blocks-windows.c -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/blocks-windows.c -check-prefix CHECK-BLOCKS-NOT-IN-BLOCKS-EXTERN-DLLIMPORT
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-windows -fblocks -fdeclspec -DBLCOKS_NOT_IN_BLOCKS_EXTERN_DLLIMPORT -Os -S -emit-llvm %s -o -")./*|*/
      I("FileCheck %s -check-prefix CHECK-BLOCKS-NOT-IN-BLOCKS-EXTERN-DLLIMPORT");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-windows -fblocks -fdeclspec -DBLCOKS_NOT_IN_BLOCKS_DLLIMPORT -Os -S -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/blocks-windows.c -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/blocks-windows.c -check-prefix CHECK-BLOCKS-NOT-IN-BLOCKS-DLLIMPORT
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-windows -fblocks -fdeclspec -DBLCOKS_NOT_IN_BLOCKS_DLLIMPORT -Os -S -emit-llvm %s -o -")./*|*/
      I("FileCheck %s -check-prefix CHECK-BLOCKS-NOT-IN-BLOCKS-DLLIMPORT");
  }

  @Test
  public void test_blocksignature_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/blocksignature.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fblocks -triple x86_64-apple-darwin9 ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/blocksignature.c -emit-llvm -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/blocksignature.c -check-prefix=X64
    RUN(TestState.Failed, "%clang_cc1 -fblocks -triple x86_64-apple-darwin9 %s -emit-llvm -o -")./*|*/
      I("FileCheck %s -check-prefix=X64");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fblocks -triple i686-apple-darwin9 ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/blocksignature.c -emit-llvm -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/blocksignature.c -check-prefix=X32
    RUN(TestState.Failed, "%clang_cc1 -fblocks -triple i686-apple-darwin9 %s -emit-llvm -o -")./*|*/
      I("FileCheck %s -check-prefix=X32");
  }

  @Test
  public void test_blockstret_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/blockstret.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fblocks -triple x86_64-apple-darwin9 ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/blockstret.c -emit-llvm -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/blockstret.c -check-prefix=X64
    RUN(TestState.Failed, "%clang_cc1 -fblocks -triple x86_64-apple-darwin9 %s -emit-llvm -o -")./*|*/
      I("FileCheck %s -check-prefix=X64");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fblocks -triple i686-apple-darwin9 ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/blockstret.c -emit-llvm -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/blockstret.c -check-prefix=X32
    RUN(TestState.Failed, "%clang_cc1 -fblocks -triple i686-apple-darwin9 %s -emit-llvm -o -")./*|*/
      I("FileCheck %s -check-prefix=X32");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fblocks -triple arm64-apple-darwin ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/blockstret.c -emit-llvm -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/blockstret.c -check-prefix=ARM64
    RUN(TestState.Failed, "%clang_cc1 -fblocks -triple arm64-apple-darwin %s -emit-llvm -o -")./*|*/
      I("FileCheck %s -check-prefix=ARM64");
  }

  @Test
  public void test_blockwithlocalstatic_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/blockwithlocalstatic.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-apple-darwin10 -fblocks -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/blockwithlocalstatic.c | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/blockwithlocalstatic.c
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-apple-darwin10 -fblocks -emit-llvm -o - %s")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_bmi_builtins_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/bmi-builtins.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/bmi-builtins.c -triple=x86_64-apple-darwin -target-feature +bmi -emit-llvm -o - -Werror | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/bmi-builtins.c
    RUN(TestState.Failed, "%clang_cc1 %s -triple=x86_64-apple-darwin -target-feature +bmi -emit-llvm -o - -Werror")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_bmi2_builtins_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/bmi2-builtins.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/bmi2-builtins.c -triple=x86_64-apple-darwin -target-feature +bmi2 -emit-llvm -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/bmi2-builtins.c
    RUN(TestState.Failed, "%clang_cc1 %s -triple=x86_64-apple-darwin -target-feature +bmi2 -emit-llvm -o -")./*|*/
      I("FileCheck %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/bmi2-builtins.c -triple=i386-apple-darwin -target-feature +bmi2 -emit-llvm -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/bmi2-builtins.c --check-prefix=B32
    RUN(TestState.Failed, "%clang_cc1 %s -triple=i386-apple-darwin -target-feature +bmi2 -emit-llvm -o -")./*|*/
      I("FileCheck %s --check-prefix=B32");
  }

  @Test
  public void test_bool_bitfield_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/bool-bitfield.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/bool-bitfield.c -o ${TEST_TEMP_DIR}/bool-bitfield.c.tmp
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm %s -o %t");
  }

  @Test
  public void test_bool_convert_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/bool-convert.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i686-pc-linux -emit-llvm < ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/bool-convert.c | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/bool-convert.c
    RUN(TestState.Failed, "%clang_cc1 -triple i686-pc-linux -emit-llvm < %s")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_bool_init_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/bool-init.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-pc-linux -emit-llvm < ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/bool-init.c | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/bool-init.c
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-pc-linux -emit-llvm < %s")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_bool_test_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/bool_test.c");
    // REQUIRES: powerpc-registered-target
    if (!CHECK_REQUIRES("powerpc-registered-target")) {
      return;
    }
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple powerpc-apple-macosx10.4.0 -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/bool_test.c -O2 -disable-llvm-optzns | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/bool_test.c
    RUN(TestState.Failed, "%clang_cc1 -triple powerpc-apple-macosx10.4.0 -emit-llvm -o - %s -O2 -disable-llvm-optzns")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_boolassign_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/boolassign.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/boolassign.c -emit-llvm -o ${TEST_TEMP_DIR}/boolassign.c.tmp
    RUN(TestState.Failed, "%clang_cc1 %s -emit-llvm -o %t");
  }

  @Test
  public void test_bounds_checking_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/bounds-checking.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsanitize=local-bounds -emit-llvm -triple x86_64-apple-darwin10 ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/bounds-checking.c -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/bounds-checking.c
    RUN(TestState.Failed, "%clang_cc1 -fsanitize=local-bounds -emit-llvm -triple x86_64-apple-darwin10 %s -o -")./*|*/
      I("FileCheck %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsanitize=array-bounds -O -fsanitize-trap=array-bounds -emit-llvm -triple x86_64-apple-darwin10 -DNO_DYNAMIC ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/bounds-checking.c -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/bounds-checking.c
    RUN(TestState.Failed, "%clang_cc1 -fsanitize=array-bounds -O -fsanitize-trap=array-bounds -emit-llvm -triple x86_64-apple-darwin10 -DNO_DYNAMIC %s -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_branch_on_bool_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/branch-on-bool.c");
    // ${LLVM_SRC}/build/bin/clang ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/branch-on-bool.c -O0 -emit-llvm -S -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/branch-on-bool.c
    RUN(TestState.Failed, "%clang %s -O0 -emit-llvm -S -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_branch_target_layout_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/branch-target-layout.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/branch-target-layout.c -O3 -emit-llvm -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/branch-target-layout.c
    RUN(TestState.Failed, "%clang_cc1 %s -O3 -emit-llvm -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_builtin_assume_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/builtin-assume.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-unknown-unknown -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/builtin-assume.c | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/builtin-assume.c
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-unknown-unknown -emit-llvm -o - %s")./*|*/
      I("FileCheck %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i386-mingw32 -fms-extensions -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/builtin-assume.c | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/builtin-assume.c
    RUN(TestState.Failed, "%clang_cc1 -triple i386-mingw32 -fms-extensions -emit-llvm -o - %s")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_builtin_assume_aligned_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/builtin-assume-aligned.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-unknown-unknown -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/builtin-assume-aligned.c | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/builtin-assume-aligned.c
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-unknown-unknown -emit-llvm -o - %s")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_builtin_attributes_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/builtin-attributes.c");
    // REQUIRES: arm-registered-target
    if (!CHECK_REQUIRES("arm-registered-target")) {
      return;
    }
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple arm-unknown-linux-gnueabi -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/builtin-attributes.c | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/builtin-attributes.c
    RUN(TestState.Failed, "%clang_cc1 -triple arm-unknown-linux-gnueabi -emit-llvm -o - %s")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_builtin_clflushopt_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/builtin-clflushopt.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/builtin-clflushopt.c -triple=x86_64-apple-darwin -target-feature +clflushopt -emit-llvm -o - -Werror | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/builtin-clflushopt.c
    RUN(TestState.Failed, "%clang_cc1 %s -triple=x86_64-apple-darwin -target-feature +clflushopt  -emit-llvm -o - -Werror")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_builtin_count_zeros_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/builtin-count-zeros.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-unknown-unknown -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/builtin-count-zeros.c -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/builtin-count-zeros.c
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-unknown-unknown -emit-llvm %s -o -")./*|*/
      I("FileCheck %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple arm-unknown-unknown -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/builtin-count-zeros.c -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/builtin-count-zeros.c --check-prefix=CHECK-ARM
    RUN(TestState.Failed, "%clang_cc1 -triple arm-unknown-unknown -emit-llvm %s -o -")./*|*/
      I("FileCheck %s --check-prefix=CHECK-ARM");
  }

  @Test
  public void test_builtin_cpu_supports_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/builtin-cpu-supports.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-pc-linux-gnu -emit-llvm < ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/builtin-cpu-supports.c| ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/builtin-cpu-supports.c
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-pc-linux-gnu -emit-llvm < %s")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_builtin_expect_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/builtin-expect.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-unknown-unknown -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/builtin-expect.c -O1 -disable-llvm-optzns | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/builtin-expect.c --check-prefix=ALL --check-prefix=O1
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-unknown-unknown -emit-llvm -o - %s -O1 -disable-llvm-optzns")./*|*/
      I("FileCheck %s --check-prefix=ALL --check-prefix=O1");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-unknown-unknown -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/builtin-expect.c -O0 | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/builtin-expect.c --check-prefix=ALL --check-prefix=O0
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-unknown-unknown -emit-llvm -o - %s -O0")./*|*/
      I("FileCheck %s --check-prefix=ALL --check-prefix=O0");
  }

  @Test
  public void test_builtin_memfns_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/builtin-memfns.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i386-pc-linux-gnu -emit-llvm < ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/builtin-memfns.c| ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/builtin-memfns.c
    RUN(TestState.Failed, "%clang_cc1 -triple i386-pc-linux-gnu -emit-llvm < %s")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_builtin_ms_noop_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/builtin-ms-noop.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fms-extensions -triple x86_64-unknown-unknown -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/builtin-ms-noop.cpp -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/builtin-ms-noop.cpp
    RUN(TestState.Failed, "%clang_cc1 -fms-extensions -triple x86_64-unknown-unknown -emit-llvm %s -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_builtin_nan_legacy_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/builtin-nan-legacy.c");
    // ${LLVM_SRC}/build/bin/clang -target mipsel-unknown-linux -mnan=legacy -emit-llvm -S ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/builtin-nan-legacy.c -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/builtin-nan-legacy.c
    RUN(TestState.Failed, "%clang -target mipsel-unknown-linux -mnan=legacy -emit-llvm -S %s -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_builtin_nanf_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/builtin-nanf.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-apple-darwin9 -emit-llvm -o ${TEST_TEMP_DIR}/builtin-nanf.c.tmp ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/builtin-nanf.c
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-apple-darwin9 -emit-llvm -o %t %s");
    // grep 'float 0x7FF8000000000000, float 0x7FF8000000000000, float 0x7FF8000020000000, float 0x7FF8000000000000, float 0x7FF80001E0000000, float 0x7FF8001E00000000, float 0x7FF801E000000000, float 0x7FF81E0000000000, float 0x7FF9E00000000000, float 0x7FFFFFFFE0000000' ${TEST_TEMP_DIR}/builtin-nanf.c.tmp
    RUN(TestState.Failed, "grep 'float 0x7FF8000000000000, float 0x7FF8000000000000, float 0x7FF8000020000000, float 0x7FF8000000000000, float 0x7FF80001E0000000, float 0x7FF8001E00000000, float 0x7FF801E000000000, float 0x7FF81E0000000000, float 0x7FF9E00000000000, float 0x7FFFFFFFE0000000' %t");
  }

  @Test
  public void test_builtin_recursive_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/builtin-recursive.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-unknown-unknown -nostdsysteminc -nobuiltininc -isystem ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/Inputs -emit-llvm-only ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/builtin-recursive.cpp
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-unknown-unknown -nostdsysteminc -nobuiltininc -isystem %S/Inputs -emit-llvm-only %s");
  }

  @Test
  public void test_builtin_rename_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/builtin-rename.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/builtin-rename.c -emit-llvm -o - | grep declare.*printf | ${LLVM_SRC}/build/bin/count 1
    RUN(TestState.Failed, "%clang_cc1 %s -emit-llvm -o -")./*|*/
      I("grep 'declare.*printf'")./*|*/
      I("count 1");
  }

  @Test
  public void test_builtin_stackaddress_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/builtin-stackaddress.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm < ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/builtin-stackaddress.c | grep llvm.returnaddress
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm < %s")./*|*/
      I("grep \"llvm.returnaddress\"");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm < ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/builtin-stackaddress.c | grep llvm.frameaddress
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm < %s")./*|*/
      I("grep \"llvm.frameaddress\"");
  }

  @Test
  public void test_builtin_unpredictable_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/builtin-unpredictable.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-unknown-unknown -emit-llvm -disable-llvm-optzns -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/builtin-unpredictable.c -O1 | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/builtin-unpredictable.c
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-unknown-unknown -emit-llvm -disable-llvm-optzns -o - %s -O1")./*|*/
      I("FileCheck %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-unknown-unknown -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/builtin-unpredictable.c -O0 | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/builtin-unpredictable.c --check-prefix=CHECK_O0
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-unknown-unknown -emit-llvm -o - %s -O0")./*|*/
      I("FileCheck %s --check-prefix=CHECK_O0");
  }

  @Test
  public void test_builtin_unwind_init_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/builtin-unwind-init.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm < ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/builtin-unwind-init.c -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/builtin-unwind-init.c
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm < %s -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_builtins_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/builtins.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm -o ${TEST_TEMP_DIR}/builtins.c.tmp ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/builtins.c
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm -o %t %s");
    // grep __builtin ${TEST_TEMP_DIR}/builtins.c.tmp
    RUN(TestState.Failed, "not grep __builtin %t");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/builtins.c -emit-llvm -o - -triple x86_64-darwin-apple | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/builtins.c
    RUN(TestState.Failed, "%clang_cc1 %s -emit-llvm -o - -triple x86_64-darwin-apple")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_builtins_arm_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/builtins-arm.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -Wall -Werror -triple thumbv7-eabi -target-cpu cortex-a8 -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/builtins-arm.c | opt -S -mem2reg | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/builtins-arm.c
    RUN(TestState.Failed, "%clang_cc1 -Wall -Werror -triple thumbv7-eabi -target-cpu cortex-a8 -emit-llvm -o - %s")./*|*/
      I("opt -S -mem2reg")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_builtins_arm_exclusive_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/builtins-arm-exclusive.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -Wall -Werror -triple thumbv8-linux-gnueabi -fno-signed-char -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/builtins-arm-exclusive.c | opt -S -mem2reg | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/builtins-arm-exclusive.c
    RUN(TestState.Failed, "%clang_cc1 -Wall -Werror -triple thumbv8-linux-gnueabi -fno-signed-char -emit-llvm -o - %s")./*|*/
      I("opt -S -mem2reg")./*|*/
      I("FileCheck %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -Wall -Werror -triple arm64-apple-ios7.0 -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/builtins-arm-exclusive.c | opt -S -mem2reg | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/builtins-arm-exclusive.c --check-prefix=CHECK-ARM64
    RUN(TestState.Failed, "%clang_cc1 -Wall -Werror -triple arm64-apple-ios7.0 -emit-llvm -o - %s")./*|*/
      I("opt -S -mem2reg")./*|*/
      I("FileCheck %s --check-prefix=CHECK-ARM64");
  }

  @Test
  public void test_builtins_arm_microsoft_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/builtins-arm-microsoft.c");
    // REQUIRES: arm-registered-target
    if (!CHECK_REQUIRES("arm-registered-target")) {
      return;
    }
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple thumbv7-windows -fms-compatibility -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/builtins-arm-microsoft.c | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/builtins-arm-microsoft.c -check-prefix CHECK-MSVC
    RUN(TestState.Failed, "%clang_cc1 -triple thumbv7-windows -fms-compatibility -emit-llvm -o - %s")./*|*/
      I("FileCheck %s -check-prefix CHECK-MSVC");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple armv7-eabi -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/builtins-arm-microsoft.c -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/builtins-arm-microsoft.c -check-prefix CHECK-EABI
    RUN(TestState.Failed, "%clang_cc1 -triple armv7-eabi -emit-llvm %s -o -")./*|*/
      I("FileCheck %s -check-prefix CHECK-EABI");
  }

  @Test
  public void test_builtins_arm_msvc_compat_error_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/builtins-arm-msvc-compat-error.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple thumbv7-windows -fms-extensions -verify ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/builtins-arm-msvc-compat-error.c
    RUN(TestState.Failed, "%clang_cc1 -triple thumbv7-windows -fms-extensions -verify %s");
  }

  @Test
  public void test_builtins_arm_msvc_compat_only_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/builtins-arm-msvc-compat-only.c");
    // REQUIRES: arm-registered-target
    if (!CHECK_REQUIRES("arm-registered-target")) {
      return;
    }
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple thumbv7-windows -fms-extensions -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/builtins-arm-msvc-compat-only.c | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/builtins-arm-msvc-compat-only.c -check-prefix CHECK-MSVC
    RUN(TestState.Failed, "%clang_cc1 -triple thumbv7-windows -fms-extensions -emit-llvm -o - %s")./*|*/
      I("FileCheck %s -check-prefix CHECK-MSVC");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple armv7-eabi -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/builtins-arm-msvc-compat-only.c -o /dev/null 2>&1 | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/builtins-arm-msvc-compat-only.c -check-prefix CHECK-EABI
    RUN(TestState.Failed, "%clang_cc1 -triple armv7-eabi -emit-llvm %s -o /dev/null 2>&1")./*|*/
      I("FileCheck %s -check-prefix CHECK-EABI");
  }

  @Test
  public void test_builtins_arm64_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/builtins-arm64.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple arm64-unknown-linux -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/builtins-arm64.c | opt -S -mem2reg | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/builtins-arm64.c
    RUN(TestState.Failed, "%clang_cc1 -triple arm64-unknown-linux -emit-llvm -o - %s")./*|*/
      I("opt -S -mem2reg")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_builtins_hexagon_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/builtins-hexagon.c");
    // REQUIRES: hexagon-registered-target
    if (!CHECK_REQUIRES("hexagon-registered-target")) {
      return;
    }
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple hexagon-unknown-elf -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/builtins-hexagon.c -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/builtins-hexagon.c
    RUN(TestState.Failed, "%clang_cc1 -triple hexagon-unknown-elf -emit-llvm %s -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_builtins_mips_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/builtins-mips.c");
    // REQUIRES: mips-registered-target
    if (!CHECK_REQUIRES("mips-registered-target")) {
      return;
    }
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple mips-unknown-linux-gnu -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/builtins-mips.c -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/builtins-mips.c
    RUN(TestState.Failed, "%clang_cc1 -triple mips-unknown-linux-gnu -emit-llvm %s -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_builtins_mips_args_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/builtins-mips-args.c");
    // REQUIRES: mips-registered-target
    if (!CHECK_REQUIRES("mips-registered-target")) {
      return;
    }
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple mips-unknown-linux-gnu -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/builtins-mips-args.c
    RUN(TestState.Failed, "%clang_cc1 -triple mips-unknown-linux-gnu -fsyntax-only -verify %s");
  }

  @Test
  public void test_builtins_mips_msa_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/builtins-mips-msa.c");
    // REQUIRES: mips-registered-target
    if (!CHECK_REQUIRES("mips-registered-target")) {
      return;
    }
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple mips-unknown-linux-gnu -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/builtins-mips-msa.c -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/builtins-mips-msa.c
    RUN(TestState.Failed, "%clang_cc1 -triple mips-unknown-linux-gnu -emit-llvm %s -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_builtins_ms_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/builtins-ms.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/builtins-ms.c -emit-llvm -o - -fms-extensions -triple i686-pc-win32 | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/builtins-ms.c
    RUN(TestState.Failed, "%clang_cc1 %s -emit-llvm -o - -fms-extensions -triple i686-pc-win32")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_builtins_multiprecision_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/builtins-multiprecision.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i686-unknown-unknown -emit-llvm -x c ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/builtins-multiprecision.c -o - -O3 | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/builtins-multiprecision.c
    RUN(TestState.Failed, "%clang_cc1 -triple \"i686-unknown-unknown\"   -emit-llvm -x c %s -o - -O3")./*|*/
      I("FileCheck %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-unknown-unknown -emit-llvm -x c ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/builtins-multiprecision.c -o - -O3 | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/builtins-multiprecision.c
    RUN(TestState.Failed, "%clang_cc1 -triple \"x86_64-unknown-unknown\" -emit-llvm -x c %s -o - -O3")./*|*/
      I("FileCheck %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-mingw32 -emit-llvm -x c ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/builtins-multiprecision.c -o - -O3 | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/builtins-multiprecision.c
    RUN(TestState.Failed, "%clang_cc1 -triple \"x86_64-mingw32\"         -emit-llvm -x c %s -o - -O3")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_builtins_nvptx_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/builtins-nvptx.c");
    // REQUIRES: nvptx-registered-target
    if (!CHECK_REQUIRES("nvptx-registered-target")) {
      return;
    }
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple nvptx-unknown-unknown -fcuda-is-device -S -emit-llvm -o - -x cuda ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/builtins-nvptx.c | ${LLVM_SRC}/build/bin/FileCheck -check-prefix=CHECK -check-prefix=LP32 ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/builtins-nvptx.c
    RUN(TestState.Failed, "%clang_cc1 -triple nvptx-unknown-unknown -fcuda-is-device -S -emit-llvm -o - -x cuda %s")./*|*/
      I("FileCheck -check-prefix=CHECK -check-prefix=LP32 %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple nvptx64-unknown-unknown -fcuda-is-device -S -emit-llvm -o - -x cuda ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/builtins-nvptx.c | ${LLVM_SRC}/build/bin/FileCheck -check-prefix=CHECK -check-prefix=LP64 ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/builtins-nvptx.c
    RUN(TestState.Failed, "%clang_cc1 -triple nvptx64-unknown-unknown -fcuda-is-device -S -emit-llvm -o - -x cuda %s")./*|*/
      I("FileCheck -check-prefix=CHECK -check-prefix=LP64 %s");
  }

  @Test
  public void test_builtins_overflow_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/builtins-overflow.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i686-unknown-unknown -emit-llvm -x c ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/builtins-overflow.c -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/builtins-overflow.c
    RUN(TestState.Failed, "%clang_cc1 -triple \"i686-unknown-unknown\"   -emit-llvm -x c %s -o -")./*|*/
      I("FileCheck %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-unknown-unknown -emit-llvm -x c ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/builtins-overflow.c -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/builtins-overflow.c
    RUN(TestState.Failed, "%clang_cc1 -triple \"x86_64-unknown-unknown\" -emit-llvm -x c %s -o -")./*|*/
      I("FileCheck %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-mingw32 -emit-llvm -x c ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/builtins-overflow.c -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/builtins-overflow.c
    RUN(TestState.Failed, "%clang_cc1 -triple \"x86_64-mingw32\"         -emit-llvm -x c %s -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_builtins_ppc_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/builtins-ppc.c");
    // REQUIRES: powerpc-registered-target
    if (!CHECK_REQUIRES("powerpc-registered-target")) {
      return;
    }
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple powerpc-unknown-unknown -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/builtins-ppc.c -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/builtins-ppc.c
    RUN(TestState.Failed, "%clang_cc1 -triple powerpc-unknown-unknown -emit-llvm %s -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_builtins_ppc_altivec_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/builtins-ppc-altivec.c");
    // REQUIRES: powerpc-registered-target
    if (!CHECK_REQUIRES("powerpc-registered-target")) {
      return;
    }
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -faltivec -triple powerpc-unknown-unknown -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/builtins-ppc-altivec.c -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/builtins-ppc-altivec.c
    RUN(TestState.Failed, "%clang_cc1 -faltivec -triple powerpc-unknown-unknown -emit-llvm %s -o -")./*|*/
      I("FileCheck %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -faltivec -triple powerpc64-unknown-unknown -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/builtins-ppc-altivec.c -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/builtins-ppc-altivec.c
    RUN(TestState.Failed, "%clang_cc1 -faltivec -triple powerpc64-unknown-unknown -emit-llvm %s -o -")./*|*/
      I("FileCheck %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -faltivec -triple powerpc64le-unknown-unknown -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/builtins-ppc-altivec.c -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/builtins-ppc-altivec.c -check-prefix=CHECK-LE
    RUN(TestState.Failed, "%clang_cc1 -faltivec -triple powerpc64le-unknown-unknown -emit-llvm %s -o -")./*|*/
      I("FileCheck %s -check-prefix=CHECK-LE");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple powerpc64le-unknown-unknown -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/builtins-ppc-altivec.c -ferror-limit 0 -DNO_ALTIVEC -o - 2>&1 | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/builtins-ppc-altivec.c -check-prefix=CHECK-NOALTIVEC
    RUN(TestState.Failed, "not %clang_cc1 -triple powerpc64le-unknown-unknown -emit-llvm %s -ferror-limit 0 -DNO_ALTIVEC -o - 2>&1")./*|*/
      I("FileCheck %s -check-prefix=CHECK-NOALTIVEC");
  }

  @Test
  public void test_builtins_ppc_crypto_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/builtins-ppc-crypto.c");
    // REQUIRES: powerpc-registered-target
    if (!CHECK_REQUIRES("powerpc-registered-target")) {
      return;
    }
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -faltivec -triple powerpc64le-unknown-unknown -target-feature +crypto -target-feature +power8-vector -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/builtins-ppc-crypto.c -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/builtins-ppc-crypto.c
    RUN(TestState.Failed, "%clang_cc1 -faltivec -triple powerpc64le-unknown-unknown -target-feature +crypto -target-feature +power8-vector -emit-llvm %s -o -")./*|*/
      I("FileCheck %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -faltivec -triple powerpc64-unknown-unknown -target-feature +crypto -target-feature +power8-vector -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/builtins-ppc-crypto.c -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/builtins-ppc-crypto.c
    RUN(TestState.Failed, "%clang_cc1 -faltivec -triple powerpc64-unknown-unknown -target-feature +crypto -target-feature +power8-vector -emit-llvm %s -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_builtins_ppc_crypto_disabled_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/builtins-ppc-crypto-disabled.c");
    // REQUIRES: powerpc-registered-target
    if (!CHECK_REQUIRES("powerpc-registered-target")) {
      return;
    }
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -faltivec -triple powerpc64le-unknown-unknown -target-cpu pwr8 -target-feature -crypto -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/builtins-ppc-crypto-disabled.c -o - 2>&1 | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/builtins-ppc-crypto-disabled.c
    RUN(TestState.Failed, "not %clang_cc1 -faltivec -triple powerpc64le-unknown-unknown -target-cpu pwr8 -target-feature -crypto -emit-llvm %s -o - 2>&1")./*|*/
      I("FileCheck %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -faltivec -triple powerpc64-unknown-unknown -target-cpu pwr8 -target-feature -crypto -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/builtins-ppc-crypto-disabled.c -o - 2>&1 | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/builtins-ppc-crypto-disabled.c
    RUN(TestState.Failed, "not %clang_cc1 -faltivec -triple powerpc64-unknown-unknown -target-cpu pwr8 -target-feature -crypto -emit-llvm %s -o - 2>&1")./*|*/
      I("FileCheck %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -faltivec -triple powerpc64-unknown-unknown -target-cpu pwr8 -target-feature -power8-vector -target-feature -crypto -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/builtins-ppc-crypto-disabled.c -o - 2>&1 | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/builtins-ppc-crypto-disabled.c -check-prefix=CHECK-P8V
    RUN(TestState.Failed, "not %clang_cc1 -faltivec -triple powerpc64-unknown-unknown -target-cpu pwr8 -target-feature -power8-vector -target-feature -crypto -emit-llvm %s -o - 2>&1")./*|*/
      I("FileCheck %s -check-prefix=CHECK-P8V");
  }

  @Test
  public void test_builtins_ppc_htm_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/builtins-ppc-htm.c");
    // REQUIRES: powerpc-registered-target
    if (!CHECK_REQUIRES("powerpc-registered-target")) {
      return;
    }
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -faltivec -target-feature +htm -triple powerpc64-unknown-unknown -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/builtins-ppc-htm.c -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/builtins-ppc-htm.c
    RUN(TestState.Failed, "%clang_cc1 -faltivec -target-feature +htm -triple powerpc64-unknown-unknown -emit-llvm %s -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_builtins_ppc_p7_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/builtins-ppc-p7.c");
    // REQUIRES: powerpc-registered-target
    if (!CHECK_REQUIRES("powerpc-registered-target")) {
      return;
    }
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple powerpc64-unknown-unknown -target-cpu pwr7 -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/builtins-ppc-p7.c -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/builtins-ppc-p7.c
    RUN(TestState.Failed, "%clang_cc1 -triple powerpc64-unknown-unknown -target-cpu pwr7 -emit-llvm %s -o -")./*|*/
      I("FileCheck %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple powerpc64le-unknown-unknown -target-cpu pwr8 -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/builtins-ppc-p7.c -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/builtins-ppc-p7.c
    RUN(TestState.Failed, "%clang_cc1 -triple powerpc64le-unknown-unknown -target-cpu pwr8 -emit-llvm %s -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_builtins_ppc_p7_disabled_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/builtins-ppc-p7-disabled.c");
    // REQUIRES: powerpc-registered-target
    if (!CHECK_REQUIRES("powerpc-registered-target")) {
      return;
    }
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple powerpc64-unknown-unknown -target-cpu pwr6 -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/builtins-ppc-p7-disabled.c -o - 2>&1 | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/builtins-ppc-p7-disabled.c
    RUN(TestState.Failed, "not %clang_cc1 -triple powerpc64-unknown-unknown -target-cpu pwr6 -emit-llvm %s -o - 2>&1")./*|*/
      I("FileCheck %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple powerpc-unknown-unknown -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/builtins-ppc-p7-disabled.c -o - 2>&1 -target-cpu pwr7 | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/builtins-ppc-p7-disabled.c -check-prefix=CHECK-32
    RUN(TestState.Failed, "not %clang_cc1 -triple powerpc-unknown-unknown -emit-llvm %s -o - 2>&1 -target-cpu pwr7")./*|*/
      I("FileCheck %s -check-prefix=CHECK-32");
  }

  @Test
  public void test_builtins_ppc_p8vector_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/builtins-ppc-p8vector.c");
    // REQUIRES: powerpc-registered-target
    if (!CHECK_REQUIRES("powerpc-registered-target")) {
      return;
    }
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -faltivec -target-feature +power8-vector -triple powerpc64-unknown-unknown -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/builtins-ppc-p8vector.c -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/builtins-ppc-p8vector.c
    RUN(TestState.Failed, "%clang_cc1 -faltivec -target-feature +power8-vector -triple powerpc64-unknown-unknown -emit-llvm %s -o -")./*|*/
      I("FileCheck %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -faltivec -target-feature +power8-vector -triple powerpc64le-unknown-unknown -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/builtins-ppc-p8vector.c -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/builtins-ppc-p8vector.c -check-prefix=CHECK-LE
    RUN(TestState.Failed, "%clang_cc1 -faltivec -target-feature +power8-vector -triple powerpc64le-unknown-unknown -emit-llvm %s -o -")./*|*/
      I("FileCheck %s -check-prefix=CHECK-LE");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -faltivec -target-feature +vsx -triple powerpc64-unknown-unknown -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/builtins-ppc-p8vector.c -o - 2>&1 | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/builtins-ppc-p8vector.c -check-prefix=CHECK-PPC
    RUN(TestState.Failed, "not %clang_cc1 -faltivec -target-feature +vsx -triple powerpc64-unknown-unknown -emit-llvm %s -o - 2>&1")./*|*/
      I("FileCheck %s -check-prefix=CHECK-PPC");
  }

  @Test
  public void test_builtins_ppc_quadword_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/builtins-ppc-quadword.c");
    // REQUIRES: powerpc-registered-target
    if (!CHECK_REQUIRES("powerpc-registered-target")) {
      return;
    }
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -faltivec -target-feature +power8-vector -triple powerpc64-unknown-unknown -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/builtins-ppc-quadword.c -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/builtins-ppc-quadword.c
    RUN(TestState.Failed, "%clang_cc1 -faltivec -target-feature +power8-vector -triple powerpc64-unknown-unknown -emit-llvm %s -o -")./*|*/
      I("FileCheck %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -faltivec -target-feature +power8-vector -triple powerpc64le-unknown-unknown -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/builtins-ppc-quadword.c -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/builtins-ppc-quadword.c -check-prefix=CHECK-LE
    RUN(TestState.Failed, "%clang_cc1 -faltivec -target-feature +power8-vector -triple powerpc64le-unknown-unknown -emit-llvm %s -o -")./*|*/
      I("FileCheck %s -check-prefix=CHECK-LE");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -faltivec -triple powerpc-unknown-unknown -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/builtins-ppc-quadword.c -o - 2>&1 | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/builtins-ppc-quadword.c -check-prefix=CHECK-PPC
    RUN(TestState.Failed, "not %clang_cc1 -faltivec -triple powerpc-unknown-unknown -emit-llvm %s -o - 2>&1")./*|*/
      I("FileCheck %s -check-prefix=CHECK-PPC");
  }

  @Test
  public void test_builtins_ppc_vsx_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/builtins-ppc-vsx.c");
    // REQUIRES: powerpc-registered-target
    if (!CHECK_REQUIRES("powerpc-registered-target")) {
      return;
    }
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -faltivec -target-feature +vsx -triple powerpc64-unknown-unknown -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/builtins-ppc-vsx.c -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/builtins-ppc-vsx.c
    RUN(TestState.Failed, "%clang_cc1 -faltivec -target-feature +vsx -triple powerpc64-unknown-unknown -emit-llvm %s -o -")./*|*/
      I("FileCheck %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -faltivec -target-feature +vsx -triple powerpc64le-unknown-unknown -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/builtins-ppc-vsx.c -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/builtins-ppc-vsx.c -check-prefix=CHECK-LE
    RUN(TestState.Failed, "%clang_cc1 -faltivec -target-feature +vsx -triple powerpc64le-unknown-unknown -emit-llvm %s -o -")./*|*/
      I("FileCheck %s -check-prefix=CHECK-LE");
  }

  @Test
  public void test_builtins_sparc_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/builtins-sparc.c");
    // REQUIRES: sparc-registered-target
    if (!CHECK_REQUIRES("sparc-registered-target")) {
      return;
    }
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple sparc-unknown-unknown -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/builtins-sparc.c -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/builtins-sparc.c
    RUN(TestState.Failed, "%clang_cc1 -triple sparc-unknown-unknown -emit-llvm %s -o -")./*|*/
      I("FileCheck %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple sparc64-unknown-unknown -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/builtins-sparc.c -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/builtins-sparc.c
    RUN(TestState.Failed, "%clang_cc1 -triple sparc64-unknown-unknown -emit-llvm %s -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_builtins_systemz_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/builtins-systemz.c");
    // REQUIRES: systemz-registered-target
    if (!CHECK_REQUIRES("systemz-registered-target")) {
      return;
    }
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -target-cpu zEC12 -triple s390x-ibm-linux -Wall -Wno-unused -Werror -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/builtins-systemz.c -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/builtins-systemz.c
    RUN(TestState.Failed, "%clang_cc1 -target-cpu zEC12 -triple s390x-ibm-linux -Wall -Wno-unused -Werror -emit-llvm %s -o -")./*|*/
      I("FileCheck %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -target-cpu zEC12 -triple s390x-ibm-linux -Wall -Wno-unused -Werror -emit-llvm -x c++ ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/builtins-systemz.c -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/builtins-systemz.c
    RUN(TestState.Failed, "%clang_cc1 -target-cpu zEC12 -triple s390x-ibm-linux -Wall -Wno-unused -Werror -emit-llvm -x c++ %s -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_builtins_systemz_error_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/builtins-systemz-error.c");
    // REQUIRES: systemz-registered-target
    if (!CHECK_REQUIRES("systemz-registered-target")) {
      return;
    }
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -target-cpu zEC12 -triple s390x-unknown-unknown -Wall -Wno-unused -Werror -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/builtins-systemz-error.c
    RUN(TestState.Failed, "%clang_cc1 -target-cpu zEC12 -triple s390x-unknown-unknown -Wall -Wno-unused -Werror -fsyntax-only -verify %s");
  }

  @Test
  public void test_builtins_systemz_error2_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/builtins-systemz-error2.c");
    // REQUIRES: systemz-registered-target
    if (!CHECK_REQUIRES("systemz-registered-target")) {
      return;
    }
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple s390x-ibm-linux -S -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/builtins-systemz-error2.c -verify -o -
    RUN(TestState.Failed, "%clang_cc1 -triple s390x-ibm-linux -S -emit-llvm %s -verify -o -");
  }

  @Test
  public void test_builtins_systemz_vector_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/builtins-systemz-vector.c");
    // REQUIRES: systemz-registered-target
    if (!CHECK_REQUIRES("systemz-registered-target")) {
      return;
    }
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -target-cpu z13 -triple s390x-ibm-linux -fno-lax-vector-conversions -Wall -Wno-unused -Werror -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/builtins-systemz-vector.c -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/builtins-systemz-vector.c
    RUN(TestState.Failed, "%clang_cc1 -target-cpu z13 -triple s390x-ibm-linux -fno-lax-vector-conversions -Wall -Wno-unused -Werror -emit-llvm %s -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_builtins_systemz_vector_error_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/builtins-systemz-vector-error.c");
    // REQUIRES: systemz-registered-target
    if (!CHECK_REQUIRES("systemz-registered-target")) {
      return;
    }
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -target-cpu z13 -triple s390x-unknown-unknown -Wall -Wno-unused -Werror -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/builtins-systemz-vector-error.c
    RUN(TestState.Failed, "%clang_cc1 -target-cpu z13 -triple s390x-unknown-unknown -Wall -Wno-unused -Werror -fsyntax-only -verify %s");
  }

  @Test
  public void test_builtins_systemz_zvector_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/builtins-systemz-zvector.c");
    // REQUIRES: systemz-registered-target
    if (!CHECK_REQUIRES("systemz-registered-target")) {
      return;
    }
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -target-cpu z13 -triple s390x-linux-gnu -O -fzvector -fno-lax-vector-conversions -Wall -Wno-unused -Werror -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/builtins-systemz-zvector.c -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/builtins-systemz-zvector.c
    RUN(TestState.Failed, "%clang_cc1 -target-cpu z13 -triple s390x-linux-gnu -O -fzvector -fno-lax-vector-conversions -Wall -Wno-unused -Werror -emit-llvm %s -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_builtins_systemz_zvector_error_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/builtins-systemz-zvector-error.c");
    // REQUIRES: systemz-registered-target
    if (!CHECK_REQUIRES("systemz-registered-target")) {
      return;
    }
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -target-cpu z13 -triple s390x-linux-gnu -fzvector -fno-lax-vector-conversions -Wall -Wno-unused -Werror -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/builtins-systemz-zvector-error.c
    RUN(TestState.Failed, "%clang_cc1 -target-cpu z13 -triple s390x-linux-gnu -fzvector -fno-lax-vector-conversions -Wall -Wno-unused -Werror -fsyntax-only -verify %s");
  }

  @Test
  public void test_builtins_wasm_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/builtins-wasm.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple wasm32-unknown-unknown -O3 -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/builtins-wasm.c | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/builtins-wasm.c -check-prefix=WEBASSEMBLY32
    RUN(TestState.Failed, "%clang_cc1 -triple wasm32-unknown-unknown -O3 -emit-llvm -o - %s")./*|*/
      I("FileCheck %s -check-prefix=WEBASSEMBLY32");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple wasm64-unknown-unknown -O3 -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/builtins-wasm.c | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/builtins-wasm.c -check-prefix=WEBASSEMBLY64
    RUN(TestState.Failed, "%clang_cc1 -triple wasm64-unknown-unknown -O3 -emit-llvm -o - %s")./*|*/
      I("FileCheck %s -check-prefix=WEBASSEMBLY64");
  }

  @Test
  public void test_builtins_x86_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/builtins-x86.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -DUSE_64 -triple x86_64-unknown-unknown -target-feature +fxsr -target-feature +avx -target-feature +xsaveopt -target-feature +xsaves -target-feature +xsavec -target-feature +mwaitx -emit-llvm -o ${TEST_TEMP_DIR}/builtins-x86.c.tmp ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/builtins-x86.c
    RUN(TestState.Failed, "%clang_cc1 -DUSE_64 -triple x86_64-unknown-unknown -target-feature +fxsr -target-feature +avx -target-feature +xsaveopt -target-feature +xsaves -target-feature +xsavec -target-feature +mwaitx -emit-llvm -o %t %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -DUSE_ALL -triple x86_64-unknown-unknown -target-feature +fxsr -target-feature +avx -target-feature +xsaveopt -target-feature +xsaves -target-feature +xsavec -target-feature +mwaitx -fsyntax-only -o ${TEST_TEMP_DIR}/builtins-x86.c.tmp ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/builtins-x86.c
    RUN(TestState.Failed, "%clang_cc1 -DUSE_ALL -triple x86_64-unknown-unknown -target-feature +fxsr -target-feature +avx -target-feature +xsaveopt -target-feature +xsaves -target-feature +xsavec -target-feature +mwaitx -fsyntax-only -o %t %s");
  }

  @Test
  public void test_builtinshufflevector_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/builtinshufflevector.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm < ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/builtinshufflevector.c | grep shufflevector | ${LLVM_SRC}/build/bin/count 1
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm < %s")./*|*/
      I("grep 'shufflevector'")./*|*/
      I("count 1");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm -ftrapv < ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/builtinshufflevector.c | grep shufflevector | ${LLVM_SRC}/build/bin/count 1
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm -ftrapv < %s")./*|*/
      I("grep 'shufflevector'")./*|*/
      I("count 1");
  }

  @Test
  public void test_builtinshufflevector2_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/builtinshufflevector2.c");
    // ${LLVM_SRC}/build/bin/clang -emit-llvm -S -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/builtinshufflevector2.c | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/builtinshufflevector2.c
    RUN(TestState.Failed, "%clang -emit-llvm -S -o - %s")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_byval_memcpy_elim_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/byval-memcpy-elim.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm -triple x86_64-apple-darwin10 < ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/byval-memcpy-elim.c | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/byval-memcpy-elim.c
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm -triple x86_64-apple-darwin10 < %s")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_c_strings_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/c-strings.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i386-pc-solaris2.11 -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/c-strings.c | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/c-strings.c --check-prefix=CHECK --check-prefix=ITANIUM
    RUN(TestState.Failed, "%clang_cc1 -triple %itanium_abi_triple -emit-llvm -o - %s")./*|*/
      I("FileCheck %s --check-prefix=CHECK --check-prefix=ITANIUM");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i386-pc-win32 -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/c-strings.c | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/c-strings.c --check-prefix=CHECK --check-prefix=MSABI
    RUN(TestState.Failed, "%clang_cc1 -triple %ms_abi_triple -emit-llvm -o - %s")./*|*/
      I("FileCheck %s --check-prefix=CHECK --check-prefix=MSABI");
  }

  @Test
  public void test_c_unicode_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/c-unicode.c");
    // REQUIRES: x86-registered-target
    if (!CHECK_REQUIRES("x86-registered-target")) {
      return;
    }
    // ${LLVM_SRC}/build/bin/clang --target=x86_64--linug-gnu -S ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/c-unicode.c -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/c-unicode.c -check-prefix=ALLOWED
    RUN(TestState.Failed, "%clang --target=x86_64--linug-gnu -S %s -o -")./*|*/
      I("FileCheck %s -check-prefix=ALLOWED");
    // ${LLVM_SRC}/build/bin/clang --target=x86_64--linux-gnu -std=c89 -S ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/c-unicode.c -o - 2>&1 | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/c-unicode.c -check-prefix=DENIED
    RUN(TestState.Failed, "not %clang --target=x86_64--linux-gnu -std=c89 -S %s -o - 2>&1")./*|*/
      I("FileCheck %s -check-prefix=DENIED");
  }

  @Test
  public void test_c11atomics_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/c11atomics.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/c11atomics.c -emit-llvm -o - -triple=armv5-unknown-freebsd -std=c11 | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/c11atomics.c
    RUN(TestState.Failed, "%clang_cc1 %s -emit-llvm -o - -triple=armv5-unknown-freebsd -std=c11")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_c11atomics_ios_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/c11atomics-ios.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/c11atomics-ios.c -emit-llvm -o - -triple=armv7-apple-ios -std=c11 | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/c11atomics-ios.c
    RUN(TestState.Failed, "%clang_cc1 %s -emit-llvm -o - -triple=armv7-apple-ios -std=c11")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_call_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/call.c");
    // ${LLVM_SRC}/build/bin/clang ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/call.c -O0 -emit-llvm -S -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/call.c
    RUN(TestState.Failed, "%clang %s -O0 -emit-llvm -S -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_capture_complex_expr_in_block_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/capture-complex-expr-in-block.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/capture-complex-expr-in-block.c -emit-llvm -o - -fblocks -triple x86_64-apple-darwin10 | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/capture-complex-expr-in-block.c
    RUN(TestState.Failed, "%clang_cc1 %s -emit-llvm -o - -fblocks -triple x86_64-apple-darwin10")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_captured_statements_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/captured-statements.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i386-pc-solaris2.11 -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/captured-statements.c -o ${TEST_TEMP_DIR}/captured-statements.c.tmp
    RUN(TestState.Failed, "%clang_cc1 -triple %itanium_abi_triple -emit-llvm %s -o %t");
    // ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/captured-statements.c '-input-file=${TEST_TEMP_DIR}/captured-statements.c.tmp' -check-prefix=CHECK-GLOBALS
    RUN(TestState.Failed, "FileCheck %s -input-file=%t -check-prefix=CHECK-GLOBALS");
    // ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/captured-statements.c '-input-file=${TEST_TEMP_DIR}/captured-statements.c.tmp' -check-prefix=CHECK-1
    RUN(TestState.Failed, "FileCheck %s -input-file=%t -check-prefix=CHECK-1");
    // ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/captured-statements.c '-input-file=${TEST_TEMP_DIR}/captured-statements.c.tmp' -check-prefix=CHECK-2
    RUN(TestState.Failed, "FileCheck %s -input-file=%t -check-prefix=CHECK-2");
    // ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/captured-statements.c '-input-file=${TEST_TEMP_DIR}/captured-statements.c.tmp' -check-prefix=CHECK-3
    RUN(TestState.Failed, "FileCheck %s -input-file=%t -check-prefix=CHECK-3");
  }

  @Test
  public void test_captured_statements_nested_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/captured-statements-nested.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fblocks -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/captured-statements-nested.c -o ${TEST_TEMP_DIR}/captured-statements-nested.c.tmp
    RUN(TestState.Failed, "%clang_cc1 -fblocks -emit-llvm %s -o %t");
    // ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/captured-statements-nested.c '-input-file=${TEST_TEMP_DIR}/captured-statements-nested.c.tmp' -check-prefix=CHECK1
    RUN(TestState.Failed, "FileCheck %s -input-file=%t -check-prefix=CHECK1");
    // ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/captured-statements-nested.c '-input-file=${TEST_TEMP_DIR}/captured-statements-nested.c.tmp' -check-prefix=CHECK2
    RUN(TestState.Failed, "FileCheck %s -input-file=%t -check-prefix=CHECK2");
  }

  @Test
  public void test_cast_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/cast.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/cast.c -emit-llvm -o ${TEST_TEMP_DIR}/cast.c.tmp
    RUN(TestState.Failed, "%clang_cc1 %s -emit-llvm -o %t");
  }

  @Test
  public void test_cast_emit_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/cast-emit.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/cast-emit.c -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/cast-emit.c
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm %s -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_catch_undef_behavior_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/catch-undef-behavior.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsanitize=alignment,null,object-size,shift-base,shift-exponent,return,signed-integer-overflow,vla-bound,float-cast-overflow,integer-divide-by-zero,bool,returns-nonnull-attribute,nonnull-attribute -fsanitize-recover=alignment,null,object-size,shift-base,shift-exponent,signed-integer-overflow,vla-bound,float-cast-overflow,integer-divide-by-zero,bool,returns-nonnull-attribute,nonnull-attribute -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/catch-undef-behavior.c -o - -triple x86_64-linux-gnu | opt -instnamer -S | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/catch-undef-behavior.c --check-prefix=CHECK-COMMON --check-prefix=CHECK-UBSAN
    RUN(TestState.Failed, "%clang_cc1 -fsanitize=alignment,null,object-size,shift-base,shift-exponent,return,signed-integer-overflow,vla-bound,float-cast-overflow,integer-divide-by-zero,bool,returns-nonnull-attribute,nonnull-attribute -fsanitize-recover=alignment,null,object-size,shift-base,shift-exponent,signed-integer-overflow,vla-bound,float-cast-overflow,integer-divide-by-zero,bool,returns-nonnull-attribute,nonnull-attribute -emit-llvm %s -o - -triple x86_64-linux-gnu")./*|*/
      I("opt -instnamer -S")./*|*/
      I("FileCheck %s --check-prefix=CHECK-COMMON --check-prefix=CHECK-UBSAN");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsanitize-trap=alignment,null,object-size,shift-base,shift-exponent,return,signed-integer-overflow,vla-bound,float-cast-overflow,integer-divide-by-zero,bool,returns-nonnull-attribute,nonnull-attribute -fsanitize-recover=alignment,null,object-size,shift-base,shift-exponent,signed-integer-overflow,vla-bound,float-cast-overflow,integer-divide-by-zero,bool,returns-nonnull-attribute,nonnull-attribute -fsanitize=alignment,null,object-size,shift-base,shift-exponent,return,signed-integer-overflow,vla-bound,float-cast-overflow,integer-divide-by-zero,bool,returns-nonnull-attribute,nonnull-attribute -fsanitize-recover=alignment,null,object-size,shift-base,shift-exponent,signed-integer-overflow,vla-bound,float-cast-overflow,integer-divide-by-zero,bool,returns-nonnull-attribute,nonnull-attribute -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/catch-undef-behavior.c -o - -triple x86_64-linux-gnu | opt -instnamer -S | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/catch-undef-behavior.c --check-prefix=CHECK-COMMON --check-prefix=CHECK-TRAP
    RUN(TestState.Failed, "%clang_cc1 -fsanitize-trap=alignment,null,object-size,shift-base,shift-exponent,return,signed-integer-overflow,vla-bound,float-cast-overflow,integer-divide-by-zero,bool,returns-nonnull-attribute,nonnull-attribute -fsanitize-recover=alignment,null,object-size,shift-base,shift-exponent,signed-integer-overflow,vla-bound,float-cast-overflow,integer-divide-by-zero,bool,returns-nonnull-attribute,nonnull-attribute -fsanitize=alignment,null,object-size,shift-base,shift-exponent,return,signed-integer-overflow,vla-bound,float-cast-overflow,integer-divide-by-zero,bool,returns-nonnull-attribute,nonnull-attribute -fsanitize-recover=alignment,null,object-size,shift-base,shift-exponent,signed-integer-overflow,vla-bound,float-cast-overflow,integer-divide-by-zero,bool,returns-nonnull-attribute,nonnull-attribute -emit-llvm %s -o - -triple x86_64-linux-gnu")./*|*/
      I("opt -instnamer -S")./*|*/
      I("FileCheck %s --check-prefix=CHECK-COMMON --check-prefix=CHECK-TRAP");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsanitize=null -fsanitize-recover=null -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/catch-undef-behavior.c -o - -triple x86_64-linux-gnu | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/catch-undef-behavior.c --check-prefix=CHECK-NULL
    RUN(TestState.Failed, "%clang_cc1 -fsanitize=null -fsanitize-recover=null -emit-llvm %s -o - -triple x86_64-linux-gnu")./*|*/
      I("FileCheck %s --check-prefix=CHECK-NULL");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsanitize=signed-integer-overflow -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/catch-undef-behavior.c -o - -triple x86_64-linux-gnu | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/catch-undef-behavior.c --check-prefix=CHECK-OVERFLOW
    RUN(TestState.Failed, "%clang_cc1 -fsanitize=signed-integer-overflow -emit-llvm %s -o - -triple x86_64-linux-gnu")./*|*/
      I("FileCheck %s --check-prefix=CHECK-OVERFLOW");
  }

  @Test
  public void test_cfi_check_fail_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/cfi-check-fail.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-unknown-linux -O0 -fsanitize-cfi-cross-dso -fsanitize=cfi-icall,cfi-nvcall,cfi-vcall,cfi-unrelated-cast,cfi-derived-cast -fsanitize-trap=cfi-icall,cfi-nvcall -fsanitize-recover=cfi-vcall,cfi-unrelated-cast -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/cfi-check-fail.c | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/cfi-check-fail.c
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-unknown-linux -O0 -fsanitize-cfi-cross-dso -fsanitize=cfi-icall,cfi-nvcall,cfi-vcall,cfi-unrelated-cast,cfi-derived-cast -fsanitize-trap=cfi-icall,cfi-nvcall -fsanitize-recover=cfi-vcall,cfi-unrelated-cast -emit-llvm -o - %s")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_cfi_check_fail2_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/cfi-check-fail2.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-unknown-linux -O0 -fsanitize-cfi-cross-dso -fsanitize=cfi-vcall -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/cfi-check-fail2.c | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/cfi-check-fail2.c
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-unknown-linux -O0 -fsanitize-cfi-cross-dso -fsanitize=cfi-vcall -emit-llvm -o - %s")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_cfi_icall_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/cfi-icall.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-unknown-linux -fsanitize=cfi-icall -fsanitize-trap=cfi-icall -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/cfi-icall.c | ${LLVM_SRC}/build/bin/FileCheck --check-prefix=CHECK --check-prefix=ITANIUM ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/cfi-icall.c
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-unknown-linux -fsanitize=cfi-icall -fsanitize-trap=cfi-icall -emit-llvm -o - %s")./*|*/
      I("FileCheck --check-prefix=CHECK --check-prefix=ITANIUM %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-pc-windows-msvc -fsanitize=cfi-icall -fsanitize-trap=cfi-icall -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/cfi-icall.c | ${LLVM_SRC}/build/bin/FileCheck --check-prefix=CHECK --check-prefix=MS ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/cfi-icall.c
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-pc-windows-msvc -fsanitize=cfi-icall -fsanitize-trap=cfi-icall -emit-llvm -o - %s")./*|*/
      I("FileCheck --check-prefix=CHECK --check-prefix=MS %s");
  }

  @Test
  public void test_cfi_icall_cross_dso_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/cfi-icall-cross-dso.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-unknown-linux -O1 -fsanitize=cfi-icall -fsanitize-cfi-cross-dso -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/cfi-icall-cross-dso.c | ${LLVM_SRC}/build/bin/FileCheck --check-prefix=CHECK --check-prefix=CHECK-DIAG --check-prefix=ITANIUM --check-prefix=ITANIUM-DIAG ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/cfi-icall-cross-dso.c
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-unknown-linux -O1 -fsanitize=cfi-icall -fsanitize-cfi-cross-dso -emit-llvm -o - %s")./*|*/
      I("FileCheck --check-prefix=CHECK --check-prefix=CHECK-DIAG --check-prefix=ITANIUM --check-prefix=ITANIUM-DIAG %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-unknown-linux -O1 -fsanitize=cfi-icall -fsanitize-cfi-cross-dso -fsanitize-trap=cfi-icall -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/cfi-icall-cross-dso.c | ${LLVM_SRC}/build/bin/FileCheck --check-prefix=CHECK --check-prefix=ITANIUM --check-prefix=ITANIUM-TRAP ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/cfi-icall-cross-dso.c
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-unknown-linux -O1 -fsanitize=cfi-icall -fsanitize-cfi-cross-dso -fsanitize-trap=cfi-icall -emit-llvm -o - %s")./*|*/
      I("FileCheck --check-prefix=CHECK --check-prefix=ITANIUM --check-prefix=ITANIUM-TRAP %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-pc-windows-msvc -O1 -fsanitize=cfi-icall -fsanitize-cfi-cross-dso -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/cfi-icall-cross-dso.c | ${LLVM_SRC}/build/bin/FileCheck --check-prefix=CHECK --check-prefix=CHECK-DIAG --check-prefix=MS --check-prefix=MS-DIAG ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/cfi-icall-cross-dso.c
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-pc-windows-msvc -O1 -fsanitize=cfi-icall -fsanitize-cfi-cross-dso -emit-llvm -o - %s")./*|*/
      I("FileCheck --check-prefix=CHECK --check-prefix=CHECK-DIAG --check-prefix=MS --check-prefix=MS-DIAG %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-pc-windows-msvc -O1 -fsanitize=cfi-icall -fsanitize-cfi-cross-dso -fsanitize-trap=cfi-icall -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/cfi-icall-cross-dso.c | ${LLVM_SRC}/build/bin/FileCheck --check-prefix=CHECK --check-prefix=MS --check-prefix=MS-TRAP ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/cfi-icall-cross-dso.c
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-pc-windows-msvc -O1 -fsanitize=cfi-icall -fsanitize-cfi-cross-dso -fsanitize-trap=cfi-icall -emit-llvm -o - %s")./*|*/
      I("FileCheck --check-prefix=CHECK --check-prefix=MS --check-prefix=MS-TRAP %s");
  }

  @Test
  public void test_cfstring_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/cfstring.c");
    // REQUIRES: x86-registered-target
    if (!CHECK_REQUIRES("x86-registered-target")) {
      return;
    }
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-macho -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/cfstring.c -o ${TEST_TEMP_DIR}/cfstring.c.tmp
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-macho -emit-llvm %s -o %t");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-macho -fwritable-strings -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/cfstring.c -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/cfstring.c
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-macho -fwritable-strings -emit-llvm %s -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_cfstring_windows_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/cfstring-windows.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple thumbv7-windows -fdeclspec -DCF_BUILDING_CF -DDECL -S -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/cfstring-windows.c -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/cfstring-windows.c -check-prefix CHECK-CF-IN-CF-DECL
    RUN(TestState.Failed, "%clang_cc1 -triple thumbv7-windows -fdeclspec -DCF_BUILDING_CF -DDECL -S -emit-llvm %s -o -")./*|*/
      I("FileCheck %s -check-prefix CHECK-CF-IN-CF-DECL");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple thumbv7-windows -fdeclspec -DCF_BUILDING_CF -DDEFN -S -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/cfstring-windows.c -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/cfstring-windows.c -check-prefix CHECK-CF-IN-CF-DEFN
    RUN(TestState.Failed, "%clang_cc1 -triple thumbv7-windows -fdeclspec -DCF_BUILDING_CF -DDEFN -S -emit-llvm %s -o -")./*|*/
      I("FileCheck %s -check-prefix CHECK-CF-IN-CF-DEFN");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple thumbv7-windows -fdeclspec -S -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/cfstring-windows.c -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/cfstring-windows.c -check-prefix CHECK-CF
    RUN(TestState.Failed, "%clang_cc1 -triple thumbv7-windows -fdeclspec -S -emit-llvm %s -o -")./*|*/
      I("FileCheck %s -check-prefix CHECK-CF");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple thumbv7-windows -fdeclspec -DEXTERN -S -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/cfstring-windows.c -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/cfstring-windows.c -check-prefix CHECK-CF-EXTERN
    RUN(TestState.Failed, "%clang_cc1 -triple thumbv7-windows -fdeclspec -DEXTERN -S -emit-llvm %s -o -")./*|*/
      I("FileCheck %s -check-prefix CHECK-CF-EXTERN");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple thumbv7-windows -fdeclspec -DEXTERN_DLLIMPORT -S -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/cfstring-windows.c -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/cfstring-windows.c -check-prefix CHECK-CF-EXTERN-DLLIMPORT
    RUN(TestState.Failed, "%clang_cc1 -triple thumbv7-windows -fdeclspec -DEXTERN_DLLIMPORT -S -emit-llvm %s -o -")./*|*/
      I("FileCheck %s -check-prefix CHECK-CF-EXTERN-DLLIMPORT");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple thumbv7-windows -fdeclspec -DDLLIMPORT -S -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/cfstring-windows.c -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/cfstring-windows.c -check-prefix CHECK-CF-DLLIMPORT
    RUN(TestState.Failed, "%clang_cc1 -triple thumbv7-windows -fdeclspec -DDLLIMPORT -S -emit-llvm %s -o -")./*|*/
      I("FileCheck %s -check-prefix CHECK-CF-DLLIMPORT");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -Os -triple thumbv7-windows -fdeclspec -DCF_BUILDING_CF -DDECL -S -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/cfstring-windows.c -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/cfstring-windows.c -check-prefix CHECK-CF-IN-CF-DECL
    RUN(TestState.Failed, "%clang_cc1 -Os -triple thumbv7-windows -fdeclspec -DCF_BUILDING_CF -DDECL -S -emit-llvm %s -o -")./*|*/
      I("FileCheck %s -check-prefix CHECK-CF-IN-CF-DECL");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -Os -triple thumbv7-windows -fdeclspec -DCF_BUILDING_CF -DDEFN -S -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/cfstring-windows.c -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/cfstring-windows.c -check-prefix CHECK-CF-IN-CF-DEFN
    RUN(TestState.Failed, "%clang_cc1 -Os -triple thumbv7-windows -fdeclspec -DCF_BUILDING_CF -DDEFN -S -emit-llvm %s -o -")./*|*/
      I("FileCheck %s -check-prefix CHECK-CF-IN-CF-DEFN");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -Os -triple thumbv7-windows -fdeclspec -S -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/cfstring-windows.c -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/cfstring-windows.c -check-prefix CHECK-CF
    RUN(TestState.Failed, "%clang_cc1 -Os -triple thumbv7-windows -fdeclspec -S -emit-llvm %s -o -")./*|*/
      I("FileCheck %s -check-prefix CHECK-CF");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -Os -triple thumbv7-windows -fdeclspec -DEXTERN -S -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/cfstring-windows.c -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/cfstring-windows.c -check-prefix CHECK-CF-EXTERN
    RUN(TestState.Failed, "%clang_cc1 -Os -triple thumbv7-windows -fdeclspec -DEXTERN -S -emit-llvm %s -o -")./*|*/
      I("FileCheck %s -check-prefix CHECK-CF-EXTERN");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -Os -triple thumbv7-windows -fdeclspec -DEXTERN_DLLIMPORT -S -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/cfstring-windows.c -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/cfstring-windows.c -check-prefix CHECK-CF-EXTERN-DLLIMPORT
    RUN(TestState.Failed, "%clang_cc1 -Os -triple thumbv7-windows -fdeclspec -DEXTERN_DLLIMPORT -S -emit-llvm %s -o -")./*|*/
      I("FileCheck %s -check-prefix CHECK-CF-EXTERN-DLLIMPORT");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -Os -triple thumbv7-windows -fdeclspec -DDLLIMPORT -S -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/cfstring-windows.c -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/cfstring-windows.c -check-prefix CHECK-CF-DLLIMPORT
    RUN(TestState.Failed, "%clang_cc1 -Os -triple thumbv7-windows -fdeclspec -DDLLIMPORT -S -emit-llvm %s -o -")./*|*/
      I("FileCheck %s -check-prefix CHECK-CF-DLLIMPORT");
  }

  @Test
  public void test_cfstring2_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/cfstring2.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/cfstring2.c -o ${TEST_TEMP_DIR}/cfstring2.c.tmp
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm %s -o %t");
  }

  @Test
  public void test_char_literal_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/char-literal.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i386-unknown-unknown -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/char-literal.c -o - | ${LLVM_SRC}/build/bin/FileCheck -check-prefix=CHECK-C ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/char-literal.c
    RUN(TestState.Failed, "%clang_cc1 -triple i386-unknown-unknown -emit-llvm %s -o -")./*|*/
      I("FileCheck -check-prefix=CHECK-C %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x c++ -triple i386-unknown-unknown -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/char-literal.c -o - | ${LLVM_SRC}/build/bin/FileCheck -check-prefix=CHECK-C ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/char-literal.c
    RUN(TestState.Failed, "%clang_cc1 -x c++ -triple i386-unknown-unknown -emit-llvm %s -o -")./*|*/
      I("FileCheck -check-prefix=CHECK-C %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x c++ -std=c++11 -triple i386-unknown-unknown -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/char-literal.c -o - | ${LLVM_SRC}/build/bin/FileCheck -check-prefix=CHECK-CPP0X ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/char-literal.c
    RUN(TestState.Failed, "%clang_cc1 -x c++ -std=c++11 -triple i386-unknown-unknown -emit-llvm %s -o -")./*|*/
      I("FileCheck -check-prefix=CHECK-CPP0X %s");
  }

  @Test
  public void test_cleanup_destslot_simple_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/cleanup-destslot-simple.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -O1 -triple x86_64-none-linux-gnu -emit-llvm -debug-info-kind=line-tables-only ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/cleanup-destslot-simple.c -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/cleanup-destslot-simple.c --check-prefix=CHECK --check-prefix=LIFETIME
    RUN(TestState.Failed, "%clang_cc1 -O1 -triple x86_64-none-linux-gnu -emit-llvm -debug-info-kind=line-tables-only %s -o -")./*|*/
      I("FileCheck %s --check-prefix=CHECK --check-prefix=LIFETIME");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -O0 -triple x86_64-none-linux-gnu -emit-llvm -debug-info-kind=line-tables-only ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/cleanup-destslot-simple.c -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/cleanup-destslot-simple.c
    RUN(TestState.Failed, "%clang_cc1 -O0 -triple x86_64-none-linux-gnu -emit-llvm -debug-info-kind=line-tables-only %s -o -")./*|*/
      I("FileCheck %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -O1 -triple x86_64-none-linux-gnu -emit-llvm -debug-info-kind=line-tables-only ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/cleanup-destslot-simple.c -o - -fsanitize=memory | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/cleanup-destslot-simple.c
    RUN(TestState.Failed, "%clang_cc1 -O1 -triple x86_64-none-linux-gnu -emit-llvm -debug-info-kind=line-tables-only %s -o - -fsanitize=memory")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_cleanup_stack_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/cleanup-stack.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i386-unknown-unknown -O3 -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/cleanup-stack.c -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/cleanup-stack.c
    RUN(TestState.Failed, "%clang_cc1 -triple i386-unknown-unknown -O3 -emit-llvm %s -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_clear_cache_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/clear_cache.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/clear_cache.c -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/clear_cache.c
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm %s -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_code_coverage_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/code-coverage.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm -disable-red-zone -femit-coverage-data ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/code-coverage.c -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/code-coverage.c
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm -disable-red-zone -femit-coverage-data %s -o -")./*|*/
      I("FileCheck %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm -disable-red-zone -femit-coverage-data -coverage-no-function-names-in-data ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/code-coverage.c -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/code-coverage.c --check-prefix WITHOUTNAMES
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm -disable-red-zone -femit-coverage-data -coverage-no-function-names-in-data %s -o -")./*|*/
      I("FileCheck %s --check-prefix WITHOUTNAMES");
  }

  @Test
  public void test_complex_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/complex.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm-only ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/complex.c
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm-only %s");
  }

  @Test
  public void test_complex_builtints_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/complex-builtints.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/complex-builtints.c -O1 -emit-llvm -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/complex-builtints.c
    RUN(TestState.Failed, "%clang_cc1 %s -O1 -emit-llvm -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_complex_convert_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/complex-convert.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/complex-convert.c | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/complex-convert.c
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm -o - %s")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_complex_indirect_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/complex-indirect.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/complex-indirect.c -o ${TEST_TEMP_DIR}/complex-indirect.c.tmp -triple=x86_64-apple-darwin10
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm %s -o %t -triple=x86_64-apple-darwin10");
    // ${LLVM_SRC}/build/bin/FileCheck < ${TEST_TEMP_DIR}/complex-indirect.c.tmp ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/complex-indirect.c
    RUN(TestState.Failed, "FileCheck < %t %s");
  }

  @Test
  public void test_complex_init_list_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/complex-init-list.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/complex-init-list.c -o - -triple=x86_64-apple-darwin10 | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/complex-init-list.c
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm %s -o - -triple=x86_64-apple-darwin10")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_complex_math_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/complex-math.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/complex-math.c -O1 -emit-llvm -triple x86_64-unknown-unknown -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/complex-math.c --check-prefix=X86
    RUN(TestState.Failed, "%clang_cc1 %s -O1 -emit-llvm -triple x86_64-unknown-unknown -o -")./*|*/
      I("FileCheck %s --check-prefix=X86");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/complex-math.c -O1 -emit-llvm -triple x86_64-pc-win64 -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/complex-math.c --check-prefix=X86
    RUN(TestState.Failed, "%clang_cc1 %s -O1 -emit-llvm -triple x86_64-pc-win64 -o -")./*|*/
      I("FileCheck %s --check-prefix=X86");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/complex-math.c -O1 -emit-llvm -triple i686-unknown-unknown -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/complex-math.c --check-prefix=X86
    RUN(TestState.Failed, "%clang_cc1 %s -O1 -emit-llvm -triple i686-unknown-unknown -o -")./*|*/
      I("FileCheck %s --check-prefix=X86");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/complex-math.c -O1 -emit-llvm -triple powerpc-unknown-unknown -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/complex-math.c --check-prefix=PPC
    RUN(TestState.Failed, "%clang_cc1 %s -O1 -emit-llvm -triple powerpc-unknown-unknown -o -")./*|*/
      I("FileCheck %s --check-prefix=PPC");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/complex-math.c -O1 -emit-llvm -triple armv7-none-linux-gnueabihf -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/complex-math.c --check-prefix=ARM
    RUN(TestState.Failed, "%clang_cc1 %s -O1 -emit-llvm -triple armv7-none-linux-gnueabihf -o -")./*|*/
      I("FileCheck %s --check-prefix=ARM");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/complex-math.c -O1 -emit-llvm -triple thumbv7k-apple-watchos2.0 -o - -target-abi aapcs16 | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/complex-math.c --check-prefix=ARM7K
    RUN(TestState.Failed, "%clang_cc1 %s -O1 -emit-llvm -triple thumbv7k-apple-watchos2.0 -o - -target-abi aapcs16")./*|*/
      I("FileCheck %s --check-prefix=ARM7K");
  }

  @Test
  public void test_compound_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/compound.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc < ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/compound.c -emit-llvm
    RUN(TestState.Failed, "%clang_cc1 < %s -emit-llvm");
  }

  @Test
  public void test_compound_assign_overflow_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/compound-assign-overflow.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -ffreestanding -triple x86_64-apple-darwin10 -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/compound-assign-overflow.c -fsanitize=signed-integer-overflow,unsigned-integer-overflow -fsanitize-recover=signed-integer-overflow,unsigned-integer-overflow | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/compound-assign-overflow.c
    RUN(TestState.Failed, "%clang_cc1 -ffreestanding -triple x86_64-apple-darwin10 -emit-llvm -o - %s  -fsanitize=signed-integer-overflow,unsigned-integer-overflow -fsanitize-recover=signed-integer-overflow,unsigned-integer-overflow")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_compound_literal_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/compound-literal.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-apple-darwin -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/compound-literal.c -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/compound-literal.c
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-apple-darwin -emit-llvm %s -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_compound_type_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/compound-type.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc < ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/compound-type.c -emit-llvm -triple i686-pc-linux-gnu > ${TEST_TEMP_DIR}/compound-type.c.tmp
    RUN(TestState.Failed, "%clang_cc1 < %s -emit-llvm -triple i686-pc-linux-gnu > %t");
    // grep 'div i32' ${TEST_TEMP_DIR}/compound-type.c.tmp
    RUN(TestState.Failed, "grep \"div i32\" %t");
    // grep 'shl i32' ${TEST_TEMP_DIR}/compound-type.c.tmp
    RUN(TestState.Failed, "grep \"shl i32\" %t");
  }

  @Test
  public void test_conditional_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/conditional.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/conditional.c -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/conditional.c
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm %s -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_conditional_gnu_ext_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/conditional-gnu-ext.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/conditional-gnu-ext.c -o ${TEST_TEMP_DIR}/conditional-gnu-ext.c.tmp
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm %s -o %t");
  }

  @Test
  public void test_const_arithmetic_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/const-arithmetic.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-unknown-unknown -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/const-arithmetic.c | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/const-arithmetic.c
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-unknown-unknown -emit-llvm -o - %s")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_const_init_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/const-init.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i386-pc-linux-gnu -ffreestanding -verify -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/const-init.c | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/const-init.c
    RUN(TestState.Failed, "%clang_cc1 -triple i386-pc-linux-gnu -ffreestanding -verify -emit-llvm -o - %s")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_const_label_addr_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/const-label-addr.c");
    // REQUIRES: asserts
    if (!CHECK_REQUIRES("asserts")) {
      return;
    }
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/const-label-addr.c -emit-llvm -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/const-label-addr.c
    RUN(TestState.Failed, "%clang_cc1 %s -emit-llvm -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_const_unordered_compare_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/const-unordered-compare.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/const-unordered-compare.c | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/const-unordered-compare.c
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm -o - %s")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_constant_comparison_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/constant-comparison.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/constant-comparison.c -o - 2>&1 | not grep warning
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm %s -o - 2>&1")./*|*/
      I("not grep warning");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/constant-comparison.c -o - | grep @b | ${LLVM_SRC}/build/bin/count 1
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm %s -o -")./*|*/
      I("grep @b")./*|*/
      I("count 1");
  }

  @Test
  public void test_constructor_attribute_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/constructor-attribute.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm -o ${TEST_TEMP_DIR}/constructor-attribute.c.tmp ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/constructor-attribute.c
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm -o %t %s");
    // grep -e global_ctors.*@A ${TEST_TEMP_DIR}/constructor-attribute.c.tmp
    RUN(TestState.Failed, "grep -e \"global_ctors.*@A\" %t");
    // grep -e global_dtors.*@B ${TEST_TEMP_DIR}/constructor-attribute.c.tmp
    RUN(TestState.Failed, "grep -e \"global_dtors.*@B\" %t");
    // grep -e global_ctors.*@C ${TEST_TEMP_DIR}/constructor-attribute.c.tmp
    RUN(TestState.Failed, "grep -e \"global_ctors.*@C\" %t");
    // grep -e global_dtors.*@D ${TEST_TEMP_DIR}/constructor-attribute.c.tmp
    RUN(TestState.Failed, "grep -e \"global_dtors.*@D\" %t");
  }

  @Test
  public void test_convertvector_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/convertvector.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-apple-darwin9 -target-cpu corei7-avx -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/convertvector.c -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/convertvector.c
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-apple-darwin9 -target-cpu corei7-avx -emit-llvm %s -o -")./*|*/
      I("FileCheck %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-apple-darwin9 -target-cpu corei7-avx -emit-llvm -x c++ ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/convertvector.c -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/convertvector.c
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-apple-darwin9 -target-cpu corei7-avx -emit-llvm -x c++ %s -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_count_builtins_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/count-builtins.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/count-builtins.c -emit-llvm -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/count-builtins.c
    RUN(TestState.Failed, "%clang_cc1 %s -emit-llvm -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_cxx_condition_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/cxx-condition.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/cxx-condition.cpp -o ${TEST_TEMP_DIR}/cxx-condition.cpp.tmp
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm %s -o %t");
  }

  @Test
  public void test_cxx_default_arg_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/cxx-default-arg.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i386-pc-solaris2.11 -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/cxx-default-arg.cpp -o ${TEST_TEMP_DIR}/cxx-default-arg.cpp.tmp
    RUN(TestState.Failed, "%clang_cc1 -triple %itanium_abi_triple -emit-llvm %s -o %t");
  }

  @Test
  public void test_cxx_value_init_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/cxx-value-init.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/cxx-value-init.cpp -o ${TEST_TEMP_DIR}/cxx-value-init.cpp.tmp
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm %s -o %t");
  }

  @Test
  public void test_darwin_string_literals_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/darwin-string-literals.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i386-apple-darwin9 -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/darwin-string-literals.c -o - | ${LLVM_SRC}/build/bin/FileCheck -check-prefix CHECK-LSB ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/darwin-string-literals.c
    RUN(TestState.Failed, "%clang_cc1 -triple i386-apple-darwin9 -emit-llvm %s -o -")./*|*/
      I("FileCheck -check-prefix CHECK-LSB %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple powerpc-apple-darwin9 -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/darwin-string-literals.c -o - | ${LLVM_SRC}/build/bin/FileCheck -check-prefix CHECK-MSB ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/darwin-string-literals.c
    RUN(TestState.Failed, "%clang_cc1 -triple powerpc-apple-darwin9 -emit-llvm %s -o -")./*|*/
      I("FileCheck -check-prefix CHECK-MSB %s");
  }

  @Test
  public void test_darwin_thread_specifier_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/darwin-thread-specifier.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-apple-macosx10.7.0 -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/darwin-thread-specifier.c | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/darwin-thread-specifier.c
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-apple-macosx10.7.0 -emit-llvm -o - %s")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_debug_info_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/debug-info.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-unk-unk -o - -emit-llvm -debug-info-kind=limited ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/debug-info.c | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/debug-info.c
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-unk-unk -o - -emit-llvm -debug-info-kind=limited %s")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_debug_info_257_args_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/debug-info-257-args.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x c++ -debug-info-kind=limited -emit-llvm -triple x86_64-linux-gnu -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/debug-info-257-args.c | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/debug-info-257-args.c
    RUN(TestState.Failed, "%clang_cc1 -x c++ -debug-info-kind=limited -emit-llvm -triple x86_64-linux-gnu -o - %s")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_debug_info_args_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/debug-info-args.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-unk-unk -o - -emit-llvm -debug-info-kind=limited ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/debug-info-args.c | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/debug-info-args.c
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-unk-unk -o - -emit-llvm -debug-info-kind=limited %s")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_debug_info_block_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/debug-info-block.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fblocks -debug-info-kind=limited -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/debug-info-block.c | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/debug-info-block.c
    RUN(TestState.Failed, "%clang_cc1 -fblocks -debug-info-kind=limited -emit-llvm -o - %s")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_debug_info_block_decl_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/debug-info-block-decl.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-apple-darwin10 -debug-info-kind=limited -fblocks -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/debug-info-block-decl.c | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/debug-info-block-decl.c
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-apple-darwin10 -debug-info-kind=limited -fblocks -emit-llvm -o - %s")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_debug_info_block_out_return_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/debug-info-block-out-return.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-apple-darwin10 -debug-info-kind=limited -fblocks -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/debug-info-block-out-return.c | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/debug-info-block-out-return.c
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-apple-darwin10 -debug-info-kind=limited -fblocks -emit-llvm -o - %s")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_debug_info_compilation_dir_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/debug-info-compilation-dir.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fdebug-compilation-dir /nonsense -emit-llvm -debug-info-kind=limited ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/debug-info-compilation-dir.c -o - | ${LLVM_SRC}/build/bin/FileCheck -check-prefix=CHECK-NONSENSE ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/debug-info-compilation-dir.c
    RUN(TestState.Failed, "%clang_cc1 -fdebug-compilation-dir /nonsense -emit-llvm -debug-info-kind=limited %s -o -")./*|*/
      I("FileCheck -check-prefix=CHECK-NONSENSE %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm -debug-info-kind=limited ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/debug-info-compilation-dir.c -o - | ${LLVM_SRC}/build/bin/FileCheck -check-prefix=CHECK-DIR ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/debug-info-compilation-dir.c
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm -debug-info-kind=limited %s -o -")./*|*/
      I("FileCheck -check-prefix=CHECK-DIR %s");
  }

  @Test
  public void test_debug_info_crash_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/debug-info-crash.c");
    // REQUIRES: x86-registered-target
    if (!CHECK_REQUIRES("x86-registered-target")) {
      return;
    }
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i386-apple-darwin10 -fblocks -debug-info-kind=limited -S ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/debug-info-crash.c -o -
    RUN(TestState.Failed, "%clang_cc1 -triple i386-apple-darwin10 -fblocks -debug-info-kind=limited -S %s -o -");
  }

  @Test
  public void test_debug_info_enum_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/debug-info-enum.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm -debug-info-kind=limited ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/debug-info-enum.c -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/debug-info-enum.c
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm -debug-info-kind=limited %s -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_debug_info_file_change_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/debug-info-file-change.c");
    // ${LLVM_SRC}/build/bin/clang -emit-llvm -S -g ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/debug-info-file-change.c -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/debug-info-file-change.c
    RUN(TestState.Failed, "%clang -emit-llvm -S -g %s -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_debug_info_gline_tables_only_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/debug-info-gline-tables-only.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/debug-info-gline-tables-only.c -debug-info-kind=line-tables-only -S -emit-llvm -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/debug-info-gline-tables-only.c
    RUN(TestState.Failed, "%clang_cc1 %s -debug-info-kind=line-tables-only -S -emit-llvm -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_debug_info_gline_tables_only2_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/debug-info-gline-tables-only2.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/debug-info-gline-tables-only2.c -debug-info-kind=line-tables-only -S -emit-llvm -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/debug-info-gline-tables-only2.c
    RUN(TestState.Failed, "%clang_cc1 %s -debug-info-kind=line-tables-only -S -emit-llvm -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_debug_info_imported_entity_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/debug-info-imported-entity.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-unk-unk -o - -emit-llvm -debug-info-kind=limited ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/debug-info-imported-entity.cpp | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/debug-info-imported-entity.cpp
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-unk-unk -o - -emit-llvm -debug-info-kind=limited %s")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_debug_info_limited_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/debug-info-limited.c");
    // ${LLVM_SRC}/build/bin/clang -flimit-debug-info -emit-llvm -g -S ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/debug-info-limited.c -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/debug-info-limited.c
    RUN(TestState.Failed, "%clang -flimit-debug-info -emit-llvm -g -S %s -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_debug_info_line_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/debug-info-line.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -w -debug-info-kind=line-tables-only -fexceptions -fcxx-exceptions -S -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/debug-info-line.c -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/debug-info-line.c
    RUN(TestState.Failed, "%clang_cc1 -w -debug-info-kind=line-tables-only -fexceptions -fcxx-exceptions -S -emit-llvm %s -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_debug_info_line2_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/debug-info-line2.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-darwin-apple -debug-info-kind=limited -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/debug-info-line2.c | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/debug-info-line2.c
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-darwin-apple -debug-info-kind=limited -emit-llvm -o - %s")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_debug_info_line3_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/debug-info-line3.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -debug-info-kind=limited -S -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/debug-info-line3.c -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/debug-info-line3.c
    RUN(TestState.Failed, "%clang_cc1 -debug-info-kind=limited -S -emit-llvm %s -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_debug_info_line4_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/debug-info-line4.c");
    // ${LLVM_SRC}/build/bin/clang ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/debug-info-line4.c -g -gcolumn-info -S -emit-llvm -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/debug-info-line4.c
    RUN(TestState.Failed, "%clang %s -g -gcolumn-info -S -emit-llvm -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_debug_info_member_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/debug-info-member.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm -debug-info-kind=limited < ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/debug-info-member.c | grep DW_TAG_member
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm -debug-info-kind=limited < %s")./*|*/
      I("grep DW_TAG_member");
  }

  @Test
  public void test_debug_info_packed_struct_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/debug-info-packed-struct.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x c -debug-info-kind=limited -emit-llvm -triple x86_64-apple-darwin -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/debug-info-packed-struct.c | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/debug-info-packed-struct.c
    RUN(TestState.Failed, "%clang_cc1 -x c -debug-info-kind=limited -emit-llvm -triple x86_64-apple-darwin -o - %s")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_debug_info_renderscript_tag_rs() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/debug-info-renderscript-tag.rs");
    // ${LLVM_SRC}/build/bin/clang -emit-llvm -S -g ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/debug-info-renderscript-tag.rs -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/debug-info-renderscript-tag.rs
    RUN(TestState.Failed, "%clang -emit-llvm -S -g %s -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_debug_info_same_line_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/debug-info-same-line.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-apple-darwin -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/debug-info-same-line.c -debug-info-kind=limited -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/debug-info-same-line.c
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-apple-darwin -emit-llvm %s -debug-info-kind=limited -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_debug_info_scope_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/debug-info-scope.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -dwarf-version=4 -debug-info-kind=limited -disable-llvm-passes -emit-llvm < ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/debug-info-scope.c | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/debug-info-scope.c
    RUN(TestState.Failed, "%clang_cc1 -dwarf-version=4 -debug-info-kind=limited -disable-llvm-passes -emit-llvm < %s")./*|*/
      I("FileCheck %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -dwarf-version=4 -debug-info-kind=line-tables-only -disable-llvm-passes -emit-llvm < ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/debug-info-scope.c | ${LLVM_SRC}/build/bin/FileCheck --check-prefix=GMLT ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/debug-info-scope.c
    RUN(TestState.Failed, "%clang_cc1 -dwarf-version=4 -debug-info-kind=line-tables-only -disable-llvm-passes -emit-llvm < %s")./*|*/
      I("FileCheck --check-prefix=GMLT %s");
  }

  @Test
  public void test_debug_info_scope_file_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/debug-info-scope-file.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -debug-info-kind=limited -emit-llvm < ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/debug-info-scope-file.c | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/debug-info-scope-file.c
    RUN(TestState.Failed, "%clang_cc1 -debug-info-kind=limited -emit-llvm < %s")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_debug_info_static_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/debug-info-static.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -debug-info-kind=limited -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/debug-info-static.c | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/debug-info-static.c
    RUN(TestState.Failed, "%clang_cc1  -debug-info-kind=limited -emit-llvm -o - %s")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_debug_info_typedef_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/debug-info-typedef.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm -debug-info-kind=limited '-I${LLVM_SRC}/llvm/tools/clang/test/CodeGen' ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/debug-info-typedef.c -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/debug-info-typedef.c
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm -debug-info-kind=limited -I%p %s -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_debug_info_vector_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/debug-info-vector.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm -debug-info-kind=limited ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/debug-info-vector.c -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/debug-info-vector.c
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm -debug-info-kind=limited %s -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_debug_info_version_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/debug-info-version.c");
    // ${LLVM_SRC}/build/bin/clang -g -S -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/debug-info-version.c | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/debug-info-version.c
    RUN(TestState.Failed, "%clang -g -S -emit-llvm -o - %s")./*|*/
      I("FileCheck %s");
    // ${LLVM_SRC}/build/bin/clang -S -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/debug-info-version.c | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/debug-info-version.c --check-prefix=NO_DEBUG
    RUN(TestState.Failed, "%clang -S -emit-llvm -o - %s")./*|*/
      I("FileCheck %s --check-prefix=NO_DEBUG");
  }

  @Test
  public void test_debug_info_vla_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/debug-info-vla.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm -debug-info-kind=limited -triple x86_64-apple-darwin ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/debug-info-vla.c -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/debug-info-vla.c
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm -debug-info-kind=limited -triple x86_64-apple-darwin %s -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_debug_line_1_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/debug-line-1.c");
    // REQUIRES: asserts
    if (!CHECK_REQUIRES("asserts")) {
      return;
    }
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-apple-darwin -o - -emit-llvm -debug-info-kind=limited ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/debug-line-1.c | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/debug-line-1.c
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-apple-darwin -o - -emit-llvm -debug-info-kind=limited %s")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_debug_prefix_map_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/debug-prefix-map.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -debug-info-kind=standalone '-fdebug-prefix-map=${LLVM_SRC}/llvm/tools/clang/test/CodeGen=/var/empty' ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/debug-prefix-map.c -emit-llvm -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/debug-prefix-map.c -check-prefix CHECK-NO-MAIN-FILE-NAME
    RUN(TestState.Failed, "%clang_cc1 -debug-info-kind=standalone -fdebug-prefix-map=%p=/var/empty %s -emit-llvm -o -")./*|*/
      I("FileCheck %s -check-prefix CHECK-NO-MAIN-FILE-NAME");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -debug-info-kind=standalone '-fdebug-prefix-map=${LLVM_SRC}/llvm/tools/clang/test/CodeGen=/var=empty' ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/debug-prefix-map.c -emit-llvm -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/debug-prefix-map.c -check-prefix CHECK-EVIL
    RUN(TestState.Failed, "%clang_cc1 -debug-info-kind=standalone -fdebug-prefix-map=%p=/var=empty %s -emit-llvm -o -")./*|*/
      I("FileCheck %s -check-prefix CHECK-EVIL");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -debug-info-kind=standalone '-fdebug-prefix-map=${LLVM_SRC}/llvm/tools/clang/test/CodeGen=/var/empty' ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/debug-prefix-map.c -emit-llvm -o - -main-file-name debug-prefix-map.c | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/debug-prefix-map.c
    RUN(TestState.Failed, "%clang_cc1 -debug-info-kind=standalone -fdebug-prefix-map=%p=/var/empty %s -emit-llvm -o - -main-file-name debug-prefix-map.c")./*|*/
      I("FileCheck %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -debug-info-kind=standalone '-fdebug-prefix-map=${LLVM_SRC}/llvm/tools/clang/test/CodeGen=/var/empty' ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/debug-prefix-map.c -emit-llvm -o - -fdebug-compilation-dir ${LLVM_SRC}/llvm/tools/clang/test/CodeGen | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/debug-prefix-map.c -check-prefix CHECK-COMPILATION-DIR
    RUN(TestState.Failed, "%clang_cc1 -debug-info-kind=standalone -fdebug-prefix-map=%p=/var/empty %s -emit-llvm -o - -fdebug-compilation-dir %p")./*|*/
      I("FileCheck %s -check-prefix CHECK-COMPILATION-DIR");
  }

  @Test
  public void test_decl_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/decl.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -w -emit-llvm < ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/decl.c | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/decl.c
    RUN(TestState.Failed, "%clang_cc1 -w -emit-llvm < %s")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_decl_in_prototype_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/decl-in-prototype.c");
    // ${LLVM_SRC}/build/bin/clang -target i386-unknown-unknown -emit-llvm -S -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/decl-in-prototype.c | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/decl-in-prototype.c
    RUN(TestState.Failed, "%clang -target i386-unknown-unknown -emit-llvm -S -o - %s")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_dependent_lib_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/dependent-lib.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/dependent-lib.c --dependent-lib=msvcrt -triple thumbv7-windows -emit-llvm -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/dependent-lib.c
    RUN(TestState.Failed, "%clang_cc1 %s --dependent-lib=msvcrt -triple thumbv7-windows -emit-llvm -o -")./*|*/
      I("FileCheck %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/dependent-lib.c --dependent-lib=msvcrt -triple i686-pc-win32 -emit-llvm -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/dependent-lib.c
    RUN(TestState.Failed, "%clang_cc1 %s --dependent-lib=msvcrt -triple i686-pc-win32 -emit-llvm -o -")./*|*/
      I("FileCheck %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/dependent-lib.c --dependent-lib=msvcrt -triple x86_64-pc-win32 -emit-llvm -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/dependent-lib.c
    RUN(TestState.Failed, "%clang_cc1 %s --dependent-lib=msvcrt -triple x86_64-pc-win32 -emit-llvm -o -")./*|*/
      I("FileCheck %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/dependent-lib.c --dependent-lib=msvcrt -triple i686-pc-linux -emit-llvm -o - | ${LLVM_SRC}/build/bin/FileCheck -check-prefix LINUX ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/dependent-lib.c
    RUN(TestState.Failed, "%clang_cc1 %s --dependent-lib=msvcrt -triple i686-pc-linux -emit-llvm -o -")./*|*/
      I("FileCheck -check-prefix LINUX %s");
  }

  @Test
  public void test_designated_initializers_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/designated-initializers.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i386-unknown-unknown ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/designated-initializers.c -emit-llvm -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/designated-initializers.c
    RUN(TestState.Failed, "%clang_cc1 -triple i386-unknown-unknown %s -emit-llvm -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_disable_tail_calls_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/disable-tail-calls.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-apple-macosx10.9.0 -emit-llvm -O1 -mdisable-tail-calls -o - < ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/disable-tail-calls.c | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/disable-tail-calls.c
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-apple-macosx10.9.0 -emit-llvm -O1 -mdisable-tail-calls -o - < %s")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_dllexport_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/dllexport.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i686-windows-msvc -fms-extensions -emit-llvm -std=c11 -O0 -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/dllexport.c | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/dllexport.c
    RUN(TestState.Failed, "%clang_cc1 -triple i686-windows-msvc   -fms-extensions -emit-llvm -std=c11 -O0 -o - %s")./*|*/
      I("FileCheck %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-windows-msvc -fms-extensions -emit-llvm -std=c11 -O0 -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/dllexport.c | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/dllexport.c
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-windows-msvc -fms-extensions -emit-llvm -std=c11 -O0 -o - %s")./*|*/
      I("FileCheck %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i686-windows-gnu -fms-extensions -emit-llvm -std=c11 -O0 -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/dllexport.c | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/dllexport.c
    RUN(TestState.Failed, "%clang_cc1 -triple i686-windows-gnu    -fms-extensions -emit-llvm -std=c11 -O0 -o - %s")./*|*/
      I("FileCheck %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-windows-gnu -fms-extensions -emit-llvm -std=c11 -O0 -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/dllexport.c | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/dllexport.c
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-windows-gnu  -fms-extensions -emit-llvm -std=c11 -O0 -o - %s")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_dllimport_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/dllimport.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i686-windows-msvc -fms-extensions -emit-llvm -std=c11 -O0 -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/dllimport.c | ${LLVM_SRC}/build/bin/FileCheck --check-prefix=CHECK --check-prefix=MS ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/dllimport.c
    RUN(TestState.Failed, "%clang_cc1 -triple i686-windows-msvc   -fms-extensions -emit-llvm -std=c11 -O0 -o - %s")./*|*/
      I("FileCheck --check-prefix=CHECK --check-prefix=MS %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-windows-msvc -fms-extensions -emit-llvm -std=c11 -O0 -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/dllimport.c | ${LLVM_SRC}/build/bin/FileCheck --check-prefix=CHECK --check-prefix=MS ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/dllimport.c
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-windows-msvc -fms-extensions -emit-llvm -std=c11 -O0 -o - %s")./*|*/
      I("FileCheck --check-prefix=CHECK --check-prefix=MS %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i686-windows-gnu -fms-extensions -emit-llvm -std=c11 -O0 -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/dllimport.c | ${LLVM_SRC}/build/bin/FileCheck --check-prefix=CHECK --check-prefix=GNU ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/dllimport.c
    RUN(TestState.Failed, "%clang_cc1 -triple i686-windows-gnu    -fms-extensions -emit-llvm -std=c11 -O0 -o - %s")./*|*/
      I("FileCheck --check-prefix=CHECK --check-prefix=GNU %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-windows-gnu -fms-extensions -emit-llvm -std=c11 -O0 -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/dllimport.c | ${LLVM_SRC}/build/bin/FileCheck --check-prefix=CHECK --check-prefix=GNU ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/dllimport.c
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-windows-gnu  -fms-extensions -emit-llvm -std=c11 -O0 -o - %s")./*|*/
      I("FileCheck --check-prefix=CHECK --check-prefix=GNU %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i686-windows-msvc -fms-extensions -emit-llvm -std=c11 -O1 -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/dllimport.c | ${LLVM_SRC}/build/bin/FileCheck --check-prefix=O1 --check-prefix=MO1 ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/dllimport.c
    RUN(TestState.Failed, "%clang_cc1 -triple i686-windows-msvc   -fms-extensions -emit-llvm -std=c11 -O1 -o - %s")./*|*/
      I("FileCheck --check-prefix=O1 --check-prefix=MO1 %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i686-windows-gnu -fms-extensions -emit-llvm -std=c11 -O1 -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/dllimport.c | ${LLVM_SRC}/build/bin/FileCheck --check-prefix=O1 --check-prefix=GO1 ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/dllimport.c
    RUN(TestState.Failed, "%clang_cc1 -triple i686-windows-gnu    -fms-extensions -emit-llvm -std=c11 -O1 -o - %s")./*|*/
      I("FileCheck --check-prefix=O1 --check-prefix=GO1 %s");
  }

  @Test
  public void test_dostmt_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/dostmt.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/dostmt.c -emit-llvm -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/dostmt.c
    RUN(TestState.Failed, "%clang_cc1 %s -emit-llvm -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_dwarf_version_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/dwarf-version.c");
    // ${LLVM_SRC}/build/bin/clang -target x86_64-linux-gnu -gdwarf-2 -S -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/dwarf-version.c | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/dwarf-version.c --check-prefix=VER2
    RUN(TestState.Failed, "%clang -target x86_64-linux-gnu -gdwarf-2 -S -emit-llvm -o - %s")./*|*/
      I("FileCheck %s --check-prefix=VER2");
    // ${LLVM_SRC}/build/bin/clang -target x86_64-linux-gnu -gdwarf-3 -S -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/dwarf-version.c | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/dwarf-version.c --check-prefix=VER3
    RUN(TestState.Failed, "%clang -target x86_64-linux-gnu -gdwarf-3 -S -emit-llvm -o - %s")./*|*/
      I("FileCheck %s --check-prefix=VER3");
    // ${LLVM_SRC}/build/bin/clang -target x86_64-linux-gnu -gdwarf-4 -S -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/dwarf-version.c | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/dwarf-version.c --check-prefix=VER4
    RUN(TestState.Failed, "%clang -target x86_64-linux-gnu -gdwarf-4 -S -emit-llvm -o - %s")./*|*/
      I("FileCheck %s --check-prefix=VER4");
    // ${LLVM_SRC}/build/bin/clang -target x86_64-linux-gnu -gdwarf-5 -S -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/dwarf-version.c | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/dwarf-version.c --check-prefix=VER5
    RUN(TestState.Failed, "%clang -target x86_64-linux-gnu -gdwarf-5 -S -emit-llvm -o - %s")./*|*/
      I("FileCheck %s --check-prefix=VER5");
    // ${LLVM_SRC}/build/bin/clang -target x86_64-linux-gnu -g -S -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/dwarf-version.c | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/dwarf-version.c --check-prefix=VER4
    RUN(TestState.Failed, "%clang -target x86_64-linux-gnu -g -S -emit-llvm -o - %s")./*|*/
      I("FileCheck %s --check-prefix=VER4");
    // ${LLVM_SRC}/build/bin/clang -target x86_64-linux-gnu -gdwarf -S -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/dwarf-version.c | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/dwarf-version.c --check-prefix=VER4
    RUN(TestState.Failed, "%clang -target x86_64-linux-gnu -gdwarf -S -emit-llvm -o - %s")./*|*/
      I("FileCheck %s --check-prefix=VER4");
    // ${LLVM_SRC}/build/bin/clang -target x86_64-apple-darwin -g -S -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/dwarf-version.c | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/dwarf-version.c --check-prefix=VER2
    RUN(TestState.Failed, "%clang -target x86_64-apple-darwin -g -S -emit-llvm -o - %s")./*|*/
      I("FileCheck %s --check-prefix=VER2");
    // ${LLVM_SRC}/build/bin/clang -target powerpc-unknown-openbsd -g -S -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/dwarf-version.c | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/dwarf-version.c --check-prefix=VER2
    RUN(TestState.Failed, "%clang -target powerpc-unknown-openbsd -g -S -emit-llvm -o - %s")./*|*/
      I("FileCheck %s --check-prefix=VER2");
    // ${LLVM_SRC}/build/bin/clang -target powerpc-unknown-freebsd -g -S -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/dwarf-version.c | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/dwarf-version.c --check-prefix=VER2
    RUN(TestState.Failed, "%clang -target powerpc-unknown-freebsd -g -S -emit-llvm -o - %s")./*|*/
      I("FileCheck %s --check-prefix=VER2");
    // ${LLVM_SRC}/build/bin/clang -target i386-pc-solaris -g -S -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/dwarf-version.c | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/dwarf-version.c --check-prefix=VER2
    RUN(TestState.Failed, "%clang -target i386-pc-solaris -g -S -emit-llvm -o - %s")./*|*/
      I("FileCheck %s --check-prefix=VER2");
    // ${LLVM_SRC}/build/bin/clang -target i686-pc-windows-msvc -gcodeview -S -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/dwarf-version.c | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/dwarf-version.c --check-prefix=NODWARF --check-prefix=CODEVIEW
    RUN(TestState.Failed, "%clang -target i686-pc-windows-msvc -gcodeview -S -emit-llvm -o - %s")./*|*/
      I("FileCheck %s --check-prefix=NODWARF --check-prefix=CODEVIEW");
    // ${LLVM_SRC}/build/bin/clang -target i686-pc-windows-msvc -gdwarf -gcodeview -S -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/dwarf-version.c | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/dwarf-version.c --check-prefix=VER4 --check-prefix=CODEVIEW
    RUN(TestState.Failed, "%clang -target i686-pc-windows-msvc -gdwarf -gcodeview -S -emit-llvm -o - %s")./*|*/
      I("FileCheck %s --check-prefix=VER4 --check-prefix=CODEVIEW");
  }

  @Test
  public void test_emit_all_decls_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/emit-all-decls.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm -o ${TEST_TEMP_DIR}/emit-all-decls.c.tmp ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/emit-all-decls.c
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm -o %t %s");
    // grep @foo ${TEST_TEMP_DIR}/emit-all-decls.c.tmp
    RUN(TestState.Failed, "not grep \"@foo\" %t");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -femit-all-decls -emit-llvm -o ${TEST_TEMP_DIR}/emit-all-decls.c.tmp ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/emit-all-decls.c
    RUN(TestState.Failed, "%clang_cc1 -femit-all-decls -emit-llvm -o %t %s");
    // grep @foo ${TEST_TEMP_DIR}/emit-all-decls.c.tmp
    RUN(TestState.Failed, "grep \"@foo\" %t");
  }

  @Test
  public void test_empty_union_init_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/empty-union-init.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm < ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/empty-union-init.c -o -
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm < %s -o -");
  }

  @Test
  public void test_enable_if_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/enable_if.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/enable_if.c -o - -triple=x86_64-pc-linux-gnu | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/enable_if.c
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm %s -o - -triple=x86_64-pc-linux-gnu")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_enum_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/enum.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i386-unknown-unknown ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/enum.c -O3 -emit-llvm -o - | ${LLVM_SRC}/build/bin/FileCheck -check-prefix=CHECK-C ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/enum.c
    RUN(TestState.Failed, "%clang_cc1 -triple i386-unknown-unknown %s -O3 -emit-llvm -o -")./*|*/
      I("FileCheck -check-prefix=CHECK-C %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i386-unknown-unknown -x c++ ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/enum.c -O3 -emit-llvm -o - | ${LLVM_SRC}/build/bin/FileCheck -check-prefix=CHECK-CXX ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/enum.c
    RUN(TestState.Failed, "%clang_cc1 -triple i386-unknown-unknown -x c++ %s -O3 -emit-llvm -o -")./*|*/
      I("FileCheck -check-prefix=CHECK-CXX %s");
  }

  @Test
  public void test_enum2_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/enum2.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i386-unknown-unknown ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/enum2.c -debug-info-kind=limited -emit-llvm -o /dev/null
    RUN(TestState.Failed, "%clang_cc1 -triple i386-unknown-unknown %s -debug-info-kind=limited -emit-llvm -o /dev/null");
  }

  @Test
  public void test_exact_div_expr_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/exact-div-expr.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/exact-div-expr.c -o - -O1 | grep ashr
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm %s -o - -O1")./*|*/
      I("grep ashr");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/exact-div-expr.c -o - -O1 | not grep sdiv
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm %s -o - -O1")./*|*/
      I("not grep sdiv");
  }

  @Test
  public void test_exceptions_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/exceptions.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-apple-darwin10 -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/exceptions.c -fexceptions -fblocks | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/exceptions.c
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-apple-darwin10 -emit-llvm -o - %s -fexceptions -fblocks")./*|*/
      I("FileCheck %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple armv7-apple-unknown -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/exceptions.c -fexceptions -fsjlj-exceptions -fblocks | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/exceptions.c -check-prefix=CHECK-ARM
    RUN(TestState.Failed, "%clang_cc1 -triple armv7-apple-unknown -emit-llvm -o - %s -fexceptions -fsjlj-exceptions -fblocks")./*|*/
      I("FileCheck %s -check-prefix=CHECK-ARM");
  }

  @Test
  public void test_exceptions_seh_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/exceptions-seh.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/exceptions-seh.c -triple x86_64-pc-win32 -fms-extensions -emit-llvm -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/exceptions-seh.c --check-prefix=CHECK --check-prefix=X64
    RUN(TestState.Failed, "%clang_cc1 %s -triple x86_64-pc-win32 -fms-extensions -emit-llvm -o -")./*|*/
      I("FileCheck %s --check-prefix=CHECK --check-prefix=X64");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/exceptions-seh.c -triple i686-pc-win32 -fms-extensions -emit-llvm -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/exceptions-seh.c --check-prefix=CHECK --check-prefix=X86
    RUN(TestState.Failed, "%clang_cc1 %s -triple i686-pc-win32 -fms-extensions -emit-llvm -o -")./*|*/
      I("FileCheck %s --check-prefix=CHECK --check-prefix=X86");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/exceptions-seh.c -triple i686-pc-windows-gnu -fms-extensions -emit-llvm -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/exceptions-seh.c --check-prefix=X86-GNU
    RUN(TestState.Failed, "%clang_cc1 %s -triple i686-pc-windows-gnu -fms-extensions -emit-llvm -o -")./*|*/
      I("FileCheck %s --check-prefix=X86-GNU");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/exceptions-seh.c -triple x86_64-pc-windows-gnu -fms-extensions -emit-llvm -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/exceptions-seh.c --check-prefix=X64-GNU
    RUN(TestState.Failed, "%clang_cc1 %s -triple x86_64-pc-windows-gnu -fms-extensions -emit-llvm -o -")./*|*/
      I("FileCheck %s --check-prefix=X64-GNU");
  }

  @Test
  public void test_exceptions_seh_finally_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/exceptions-seh-finally.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/exceptions-seh-finally.c -triple x86_64-pc-win32 -fms-extensions -emit-llvm -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/exceptions-seh-finally.c
    RUN(TestState.Failed, "%clang_cc1 %s -triple x86_64-pc-win32 -fms-extensions -emit-llvm -o -")./*|*/
      I("FileCheck %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/exceptions-seh-finally.c -triple i686-pc-win32 -fms-extensions -emit-llvm -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/exceptions-seh-finally.c
    RUN(TestState.Failed, "%clang_cc1 %s -triple i686-pc-win32 -fms-extensions -emit-llvm -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_exceptions_seh_leave_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/exceptions-seh-leave.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/exceptions-seh-leave.c -triple x86_64-pc-win32 -fms-extensions -emit-llvm -o - | opt -instnamer -S | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/exceptions-seh-leave.c
    RUN(TestState.Failed, "%clang_cc1 %s -triple x86_64-pc-win32 -fms-extensions -emit-llvm -o -")./*|*/
      I("opt -instnamer -S")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_exprs_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/exprs.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-unknown-unknown ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/exprs.c -emit-llvm -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/exprs.c
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-unknown-unknown %s -emit-llvm -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_ext_vector_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/ext-vector.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/ext-vector.c -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/ext-vector.c
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm %s -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_ext_vector_indexing_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/ext-vector-indexing.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-unknown-unknown -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/ext-vector-indexing.c -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/ext-vector-indexing.c
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-unknown-unknown -emit-llvm %s -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_ext_vector_member_alignment_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/ext-vector-member-alignment.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/ext-vector-member-alignment.c | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/ext-vector-member-alignment.c
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm -o - %s")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_extern_block_var_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/extern-block-var.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/extern-block-var.c -emit-llvm -o ${TEST_TEMP_DIR}/extern-block-var.c.tmp
    RUN(TestState.Failed, "%clang_cc1 %s -emit-llvm -o %t");
  }

  @Test
  public void test_extern_inline_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/extern-inline.c");
    // ${LLVM_SRC}/build/bin/clang -target i386-unknown-unknown -S -emit-llvm -std=gnu89 -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/extern-inline.c | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/extern-inline.c
    RUN(TestState.Failed, "%clang -target i386-unknown-unknown -S -emit-llvm -std=gnu89 -o - %s")./*|*/
      I("FileCheck %s");
    // ${LLVM_SRC}/build/bin/clang -target i386-unknown-unknown -S -emit-llvm -fgnu89-inline -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/extern-inline.c | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/extern-inline.c
    RUN(TestState.Failed, "%clang -target i386-unknown-unknown -S -emit-llvm -fgnu89-inline -o - %s")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_extern_weak_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/extern-weak.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -O3 -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/extern-weak.c | grep extern_weak
    RUN(TestState.Failed, "%clang_cc1 -O3 -emit-llvm -o - %s")./*|*/
      I("grep extern_weak");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -O3 -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/extern-weak.c | llc
    RUN(TestState.Failed, "%clang_cc1 -O3 -emit-llvm -o - %s")./*|*/
      I("llc");
  }

  @Test
  public void test_f16c_builtins_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/f16c-builtins.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/f16c-builtins.c -triple=x86_64-apple-darwin -target-feature +f16c -emit-llvm -o - -Werror | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/f16c-builtins.c
    RUN(TestState.Failed, "%clang_cc1 %s -triple=x86_64-apple-darwin -target-feature +f16c -emit-llvm -o - -Werror")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_fast_math_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/fast-math.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -ffast-math -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/fast-math.c | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/fast-math.c
    RUN(TestState.Failed, "%clang_cc1 -ffast-math -emit-llvm -o - %s")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_ffp_contract_option_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/ffp-contract-option.c");
    // REQUIRES: powerpc-registered-target
    if (!CHECK_REQUIRES("powerpc-registered-target")) {
      return;
    }
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -O3 -ffp-contract=fast -triple=powerpc-apple-darwin10 -S -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/ffp-contract-option.c | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/ffp-contract-option.c
    RUN(TestState.Failed, "%clang_cc1 -O3 -ffp-contract=fast -triple=powerpc-apple-darwin10 -S -o - %s")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_finite_math_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/finite-math.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -ffinite-math-only -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/finite-math.c | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/finite-math.c -check-prefix=CHECK -check-prefix=FINITE
    RUN(TestState.Failed, "%clang_cc1 -ffinite-math-only -emit-llvm -o - %s")./*|*/
      I("FileCheck %s -check-prefix=CHECK -check-prefix=FINITE");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fno-signed-zeros -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/finite-math.c | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/finite-math.c -check-prefix=CHECK -check-prefix=NSZ
    RUN(TestState.Failed, "%clang_cc1 -fno-signed-zeros -emit-llvm -o - %s")./*|*/
      I("FileCheck %s -check-prefix=CHECK  -check-prefix=NSZ");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -freciprocal-math -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/finite-math.c | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/finite-math.c -check-prefix=CHECK -check-prefix=RECIP
    RUN(TestState.Failed, "%clang_cc1 -freciprocal-math -emit-llvm -o - %s")./*|*/
      I("FileCheck %s -check-prefix=CHECK  -check-prefix=RECIP");
  }

  @Test
  public void test_fixup_depth_overflow_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/fixup-depth-overflow.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -O1 -disable-llvm-optzns -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/fixup-depth-overflow.c | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/fixup-depth-overflow.c
    RUN(TestState.Failed, "%clang_cc1 -O1 -disable-llvm-optzns -emit-llvm -o - %s")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_flatten_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/flatten.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple=x86_64-linux-gnu ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/flatten.c -emit-llvm -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/flatten.c
    RUN(TestState.Failed, "%clang_cc1 -triple=x86_64-linux-gnu %s -emit-llvm -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_flexible_array_init_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/flexible-array-init.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i386-unknown-unknown -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/flexible-array-init.c | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/flexible-array-init.c
    RUN(TestState.Failed, "%clang_cc1 -triple i386-unknown-unknown -emit-llvm -o - %s")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_fma_builtins_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/fma-builtins.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/fma-builtins.c -triple=x86_64-apple-darwin -target-feature +fma -emit-llvm -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/fma-builtins.c
    RUN(TestState.Failed, "%clang_cc1 %s -triple=x86_64-apple-darwin -target-feature +fma -emit-llvm -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_fma4_builtins_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/fma4-builtins.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/fma4-builtins.c -triple=x86_64-apple-darwin -target-feature +fma4 -emit-llvm -o - -Werror | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/fma4-builtins.c
    RUN(TestState.Failed, "%clang_cc1 %s -triple=x86_64-apple-darwin -target-feature +fma4 -emit-llvm -o - -Werror")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_fold_const_declref_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/fold-const-declref.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -verify -emit-llvm-only ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/fold-const-declref.c
    RUN(TestState.Failed, "%clang_cc1 -verify -emit-llvm-only %s");
  }

  @Test
  public void test_forceinline_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/forceinline.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i686-win32 -emit-llvm -fms-extensions < ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/forceinline.c | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/forceinline.c
    RUN(TestState.Failed, "%clang_cc1 -triple i686-win32 -emit-llvm -fms-extensions < %s")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_fp_contract_pragma_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/fp-contract-pragma.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -O3 -triple i386-pc-solaris2.11 -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/fp-contract-pragma.cpp | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/fp-contract-pragma.cpp
    RUN(TestState.Failed, "%clang_cc1 -O3 -triple %itanium_abi_triple -emit-llvm -o - %s")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_fp128_complex_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/fp128_complex.c");
    // ${LLVM_SRC}/build/bin/clang -target aarch64-linux-gnuabi ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/fp128_complex.c -S -emit-llvm -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/fp128_complex.c
    RUN(TestState.Failed, "%clang -target aarch64-linux-gnuabi %s -S -emit-llvm -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_fp16_ops_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/fp16-ops.c");
    // REQUIRES: arm-registered-target
    if (!CHECK_REQUIRES("arm-registered-target")) {
      return;
    }
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm -o - -triple arm-none-linux-gnueabi ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/fp16-ops.c | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/fp16-ops.c --check-prefix=NOHALF --check-prefix=CHECK
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm -o - -triple arm-none-linux-gnueabi %s")./*|*/
      I("FileCheck %s --check-prefix=NOHALF --check-prefix=CHECK");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm -o - -triple aarch64-none-linux-gnueabi ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/fp16-ops.c | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/fp16-ops.c --check-prefix=NOHALF --check-prefix=CHECK
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm -o - -triple aarch64-none-linux-gnueabi %s")./*|*/
      I("FileCheck %s --check-prefix=NOHALF --check-prefix=CHECK");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm -o - -triple arm-none-linux-gnueabi -fallow-half-arguments-and-returns ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/fp16-ops.c | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/fp16-ops.c --check-prefix=HALF --check-prefix=CHECK
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm -o - -triple arm-none-linux-gnueabi -fallow-half-arguments-and-returns %s")./*|*/
      I("FileCheck %s --check-prefix=HALF --check-prefix=CHECK");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm -o - -triple aarch64-none-linux-gnueabi -fallow-half-arguments-and-returns ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/fp16-ops.c | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/fp16-ops.c --check-prefix=HALF --check-prefix=CHECK
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm -o - -triple aarch64-none-linux-gnueabi -fallow-half-arguments-and-returns %s")./*|*/
      I("FileCheck %s --check-prefix=HALF --check-prefix=CHECK");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm -o - -triple arm-none-linux-gnueabi -fnative-half-type ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/fp16-ops.c | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/fp16-ops.c --check-prefix=NATIVE-HALF
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm -o - -triple arm-none-linux-gnueabi -fnative-half-type %s")./*|*/
      I("FileCheck %s --check-prefix=NATIVE-HALF");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm -o - -triple aarch64-none-linux-gnueabi -fnative-half-type ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/fp16-ops.c | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/fp16-ops.c --check-prefix=NATIVE-HALF
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm -o - -triple aarch64-none-linux-gnueabi -fnative-half-type %s")./*|*/
      I("FileCheck %s --check-prefix=NATIVE-HALF");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm -o - -x renderscript ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/fp16-ops.c | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/fp16-ops.c --check-prefix=NATIVE-HALF
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm -o - -x renderscript %s")./*|*/
      I("FileCheck %s --check-prefix=NATIVE-HALF");
  }

  @Test
  public void test_fsgsbase_builtins_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/fsgsbase-builtins.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/fsgsbase-builtins.c -triple=x86_64-apple-darwin -target-feature +fsgsbase -emit-llvm -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/fsgsbase-builtins.c
    RUN(TestState.Failed, "%clang_cc1 %s -triple=x86_64-apple-darwin -target-feature +fsgsbase -emit-llvm -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_func_aligned_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/func-aligned.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-apple-darwin ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/func-aligned.c -emit-llvm -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/func-aligned.c
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-apple-darwin %s -emit-llvm -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_func_decl_cleanup_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/func-decl-cleanup.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/func-decl-cleanup.c -emit-llvm -o -
    RUN(TestState.Failed, "%clang_cc1 %s -emit-llvm -o -");
  }

  @Test
  public void test_func_in_block_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/func-in-block.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-apple-darwin10 -fblocks -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/func-in-block.c | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/func-in-block.c
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-apple-darwin10 -fblocks -emit-llvm -o - %s")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_func_ptr_cast_decl_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/func-ptr-cast-decl.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm-only ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/func-ptr-cast-decl.c -verify
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm-only %s -verify");
  }

  @Test
  public void test_func_return_member_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/func-return-member.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-apple-darwin -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/func-return-member.c | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/func-return-member.c
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-apple-darwin -emit-llvm -o - %s")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_funccall_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/funccall.c");
    // echo foo
    RUN(TestState.Failed, "echo foo");
  }

  @Test
  public void test_function_attributes_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/function-attributes.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i386-unknown-unknown -emit-llvm -disable-llvm-optzns -Os -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/function-attributes.c | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/function-attributes.c
    RUN(TestState.Failed, "%clang_cc1 -triple i386-unknown-unknown -emit-llvm -disable-llvm-optzns -Os -o - %s")./*|*/
      I("FileCheck %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i386-unknown-unknown -emit-llvm -disable-llvm-optzns -Os -std=c99 -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/function-attributes.c | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/function-attributes.c
    RUN(TestState.Failed, "%clang_cc1 -triple i386-unknown-unknown -emit-llvm -disable-llvm-optzns -Os -std=c99 -o - %s")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_function_sections_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/function-sections.c");
    // REQUIRES: x86-registered-target
    if (!CHECK_REQUIRES("x86-registered-target")) {
      return;
    }
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-pc-linux-gnu -S -o - < ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/function-sections.c | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/function-sections.c --check-prefix=PLAIN
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-pc-linux-gnu -S -o - < %s")./*|*/
      I("FileCheck %s --check-prefix=PLAIN");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-pc-linux-gnu -S -ffunction-sections -fno-function-sections -o - < ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/function-sections.c | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/function-sections.c --check-prefix=PLAIN
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-pc-linux-gnu -S -ffunction-sections -fno-function-sections -o - < %s")./*|*/
      I("FileCheck %s --check-prefix=PLAIN");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-pc-linux-gnu -S -ffunction-sections -o - < ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/function-sections.c | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/function-sections.c --check-prefix=FUNC_SECT
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-pc-linux-gnu -S -ffunction-sections -o - < %s")./*|*/
      I("FileCheck %s --check-prefix=FUNC_SECT");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-pc-linux-gnu -S -fno-function-sections -ffunction-sections -o - < ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/function-sections.c | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/function-sections.c --check-prefix=FUNC_SECT
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-pc-linux-gnu -S -fno-function-sections -ffunction-sections -o - < %s")./*|*/
      I("FileCheck %s --check-prefix=FUNC_SECT");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-pc-linux-gnu -S -fdata-sections -o - < ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/function-sections.c | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/function-sections.c --check-prefix=DATA_SECT
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-pc-linux-gnu -S -fdata-sections -o - < %s")./*|*/
      I("FileCheck %s --check-prefix=DATA_SECT");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-pc-linux-gnu -S -fno-data-sections -fdata-sections -o - < ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/function-sections.c | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/function-sections.c --check-prefix=DATA_SECT
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-pc-linux-gnu -S -fno-data-sections -fdata-sections -o - < %s")./*|*/
      I("FileCheck %s --check-prefix=DATA_SECT");
  }

  @Test
  public void test_function_target_features_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/function-target-features.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-unknown-unknown -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/function-target-features.c -target-feature +avx | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/function-target-features.c -check-prefix=AVX-FEATURE
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-unknown-unknown -emit-llvm -o - %s -target-feature +avx")./*|*/
      I("FileCheck %s -check-prefix=AVX-FEATURE");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-unknown-unknown -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/function-target-features.c -target-feature +avx | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/function-target-features.c -check-prefix=AVX-NO-CPU
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-unknown-unknown -emit-llvm -o - %s -target-feature +avx")./*|*/
      I("FileCheck %s -check-prefix=AVX-NO-CPU");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-unknown-unknown -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/function-target-features.c -target-feature +avx512f -target-feature +avx512er | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/function-target-features.c -check-prefix=TWO-AVX
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-unknown-unknown -emit-llvm -o - %s -target-feature +avx512f -target-feature +avx512er")./*|*/
      I("FileCheck %s -check-prefix=TWO-AVX");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-unknown-unknown -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/function-target-features.c -target-cpu corei7 | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/function-target-features.c -check-prefix=CORE-CPU
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-unknown-unknown -emit-llvm -o - %s -target-cpu corei7")./*|*/
      I("FileCheck %s -check-prefix=CORE-CPU");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-unknown-unknown -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/function-target-features.c -target-cpu corei7 -target-feature +avx | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/function-target-features.c -check-prefix=CORE-CPU-AND-FEATURES
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-unknown-unknown -emit-llvm -o - %s -target-cpu corei7 -target-feature +avx")./*|*/
      I("FileCheck %s -check-prefix=CORE-CPU-AND-FEATURES");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-unknown-unknown -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/function-target-features.c -target-cpu x86-64 | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/function-target-features.c -check-prefix=X86-64-CPU
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-unknown-unknown -emit-llvm -o - %s -target-cpu x86-64")./*|*/
      I("FileCheck %s -check-prefix=X86-64-CPU");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-unknown-unknown -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/function-target-features.c -target-cpu corei7-avx -target-feature -avx | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/function-target-features.c -check-prefix=AVX-MINUS-FEATURE
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-unknown-unknown -emit-llvm -o - %s -target-cpu corei7-avx -target-feature -avx")./*|*/
      I("FileCheck %s -check-prefix=AVX-MINUS-FEATURE");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple sparc-unknown-unknown -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/function-target-features.c -target-feature +soft-float | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/function-target-features.c -check-prefix=SOFT-FLOAT
    RUN(TestState.Failed, "%clang_cc1 -triple sparc-unknown-unknown -emit-llvm -o - %s -target-feature +soft-float")./*|*/
      I("FileCheck %s -check-prefix=SOFT-FLOAT");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple arm-unknown-unknown -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/function-target-features.c -target-feature +soft-float | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/function-target-features.c -check-prefix=SOFT-FLOAT
    RUN(TestState.Failed, "%clang_cc1 -triple arm-unknown-unknown -emit-llvm -o - %s -target-feature +soft-float")./*|*/
      I("FileCheck %s -check-prefix=SOFT-FLOAT");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple mips-unknown-unknown -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/function-target-features.c -target-feature +soft-float | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/function-target-features.c -check-prefix=SOFT-FLOAT
    RUN(TestState.Failed, "%clang_cc1 -triple mips-unknown-unknown -emit-llvm -o - %s -target-feature +soft-float")./*|*/
      I("FileCheck %s -check-prefix=SOFT-FLOAT");
  }

  @Test
  public void test_functions_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/functions.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/functions.c -triple i386-unknown-unknown -emit-llvm -o - -verify | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/functions.c
    RUN(TestState.Failed, "%clang_cc1 %s -triple i386-unknown-unknown -emit-llvm -o - -verify")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_funique_sections_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/funique-sections.c");
    // REQUIRES: x86-registered-target
    if (!CHECK_REQUIRES("x86-registered-target")) {
      return;
    }
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-pc-linux -S -ffunction-sections -fdata-sections -fno-unique-section-names -o - < ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/funique-sections.c | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/funique-sections.c
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-pc-linux -S -ffunction-sections -fdata-sections -fno-unique-section-names  -o - < %s")./*|*/
      I("FileCheck %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-pc-linux -S -ffunction-sections -fdata-sections -o - < ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/funique-sections.c | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/funique-sections.c --check-prefix=UNIQUE
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-pc-linux -S -ffunction-sections -fdata-sections -o - < %s")./*|*/
      I("FileCheck %s --check-prefix=UNIQUE");
  }

  @Test
  public void test_global_blocks_lines_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/global-blocks-lines.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fblocks -debug-info-kind=limited -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/global-blocks-lines.c -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/global-blocks-lines.c
    RUN(TestState.Failed, "%clang_cc1 -fblocks -debug-info-kind=limited -emit-llvm %s -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_global_decls_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/global-decls.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i386-pc-linux-gnu -emit-llvm -o ${TEST_TEMP_DIR}/global-decls.c.tmp ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/global-decls.c
    RUN(TestState.Failed, "%clang_cc1 -triple i386-pc-linux-gnu -emit-llvm -o %t %s");
    // grep '@g0_ext = extern_weak global i32' ${TEST_TEMP_DIR}/global-decls.c.tmp
    RUN(TestState.Failed, "grep '@g0_ext = extern_weak global i32' %t");
    // grep 'declare extern_weak i32 @g1_ext()' ${TEST_TEMP_DIR}/global-decls.c.tmp
    RUN(TestState.Failed, "grep 'declare extern_weak i32 @g1_ext()' %t");
    // grep '@g0_common = weak global i32' ${TEST_TEMP_DIR}/global-decls.c.tmp
    RUN(TestState.Failed, "grep '@g0_common = weak global i32' %t");
    // grep '@g0_def = weak global i32' ${TEST_TEMP_DIR}/global-decls.c.tmp
    RUN(TestState.Failed, "grep '@g0_def = weak global i32' %t");
    // grep 'define weak i32 @g1_def()' ${TEST_TEMP_DIR}/global-decls.c.tmp
    RUN(TestState.Failed, "grep 'define weak i32 @g1_def()' %t");
  }

  @Test
  public void test_global_init_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/global-init.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm -o - -triple i386-linux-gnu ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/global-init.c | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/global-init.c
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm -o - -triple i386-linux-gnu %s")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_global_with_initialiser_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/global-with-initialiser.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/global-with-initialiser.c -o ${TEST_TEMP_DIR}/global-with-initialiser.c.tmp
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm %s -o %t");
  }

  @Test
  public void test_globalinit_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/globalinit.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/globalinit.c -o ${TEST_TEMP_DIR}/globalinit.c.tmp
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm %s -o %t");
  }

  @Test
  public void test_hexagon_inline_asm_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/hexagon-inline-asm.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple hexagon-unknown-elf -target-feature +hvx -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/hexagon-inline-asm.c | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/hexagon-inline-asm.c
    RUN(TestState.Failed, "%clang_cc1 -triple hexagon-unknown-elf -target-feature +hvx -emit-llvm -o - %s")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_hidden_alias_to_internal_function_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/hidden-alias-to-internal-function.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-unknown-linux-gnu -emit-llvm -o - -x c ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/hidden-alias-to-internal-function.c | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/hidden-alias-to-internal-function.c
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-unknown-linux-gnu -emit-llvm -o - -x c %s")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_hidden_visibility_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/hidden-visibility.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/hidden-visibility.c -emit-llvm -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/hidden-visibility.c
    RUN(TestState.Failed, "%clang_cc1 %s -emit-llvm -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_iamcu_abi_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/iamcu-abi.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i386-pc-elfiamcu -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/iamcu-abi.c | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/iamcu-abi.c
    RUN(TestState.Failed, "%clang_cc1 -triple i386-pc-elfiamcu -emit-llvm -o - %s")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_ifunc_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/ifunc.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i386-unknown-linux-gnu -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/ifunc.c | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/ifunc.c
    RUN(TestState.Failed, "%clang_cc1 -triple i386-unknown-linux-gnu -emit-llvm -o - %s")./*|*/
      I("FileCheck %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i386-unknown-linux-gnu -O2 -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/ifunc.c | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/ifunc.c
    RUN(TestState.Failed, "%clang_cc1 -triple i386-unknown-linux-gnu -O2 -emit-llvm -o - %s")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_imaginary_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/imaginary.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -verify -emit-llvm-only ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/imaginary.c
    RUN(TestState.Failed, "%clang_cc1 -verify -emit-llvm-only %s");
  }

  @Test
  public void test_implicit_arg_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/implicit-arg.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/implicit-arg.c -emit-llvm -o -
    RUN(TestState.Failed, "%clang_cc1 %s -emit-llvm     -o -");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/implicit-arg.c -emit-llvm -O1 -o -
    RUN(TestState.Failed, "%clang_cc1 %s -emit-llvm -O1 -o -");
  }

  @Test
  public void test_incomplete_function_type_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/incomplete-function-type.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-apple-darwin -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/incomplete-function-type.c | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/incomplete-function-type.c
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-apple-darwin -emit-llvm -o - %s")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_incomplete_function_type_2_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/incomplete-function-type-2.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-apple-darwin -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/incomplete-function-type-2.c | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/incomplete-function-type-2.c
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-apple-darwin -emit-llvm -o - %s")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_indirect_goto_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/indirect-goto.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-unknown-unknown -O3 -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/indirect-goto.c | grep 'ret i32 2520'
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-unknown-unknown -O3 -emit-llvm -o - %s")./*|*/
      I("grep \"ret i32 2520\"");
  }

  @Test
  public void test_init_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/init.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i386-unknown-unknown -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/init.c -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/init.c
    RUN(TestState.Failed, "%clang_cc1 -triple i386-unknown-unknown -emit-llvm %s -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_init_with_member_expr_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/init-with-member-expr.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc < ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/init-with-member-expr.c -emit-llvm
    RUN(TestState.Failed, "%clang_cc1 < %s -emit-llvm");
  }

  @Test
  public void test_inline_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/inline.c");
    // echo 'GNU89 tests:'
    RUN(TestState.Failed, "echo \"GNU89 tests:\"");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/inline.c -triple i386-unknown-unknown -O1 -disable-llvm-optzns -emit-llvm -o - -std=gnu89 | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/inline.c --check-prefix=CHECK1
    RUN(TestState.Failed, "%clang_cc1 %s -triple i386-unknown-unknown -O1 -disable-llvm-optzns -emit-llvm -o - -std=gnu89")./*|*/
      I("FileCheck %s --check-prefix=CHECK1");
    // echo 'C99 tests:'
    RUN(TestState.Failed, "echo \"C99 tests:\"");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/inline.c -triple i386-unknown-unknown -O1 -disable-llvm-optzns -emit-llvm -o - -std=gnu99 | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/inline.c --check-prefix=CHECK2
    RUN(TestState.Failed, "%clang_cc1 %s -triple i386-unknown-unknown -O1 -disable-llvm-optzns -emit-llvm -o - -std=gnu99")./*|*/
      I("FileCheck %s --check-prefix=CHECK2");
    // echo 'C++ tests:'
    RUN(TestState.Failed, "echo \"C++ tests:\"");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x c++ ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/inline.c -triple i386-unknown-unknown -O1 -disable-llvm-optzns -emit-llvm -o - -std=c++98 | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/inline.c --check-prefix=CHECK3
    RUN(TestState.Failed, "%clang_cc1 -x c++ %s -triple i386-unknown-unknown -O1 -disable-llvm-optzns -emit-llvm -o - -std=c++98")./*|*/
      I("FileCheck %s --check-prefix=CHECK3");
    // echo 'MS C Mode tests:'
    RUN(TestState.Failed, "echo \"MS C Mode tests:\"");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/inline.c -triple i386-pc-win32 -O1 -disable-llvm-optzns -emit-llvm -o - -std=c99 | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/inline.c --check-prefix=CHECK4
    RUN(TestState.Failed, "%clang_cc1 %s -triple i386-pc-win32 -O1 -disable-llvm-optzns -emit-llvm -o - -std=c99")./*|*/
      I("FileCheck %s --check-prefix=CHECK4");
  }

  @Test
  public void test_inline_asm_immediate_ubsan_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/inline-asm-immediate-ubsan.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-unknown-unknown -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/inline-asm-immediate-ubsan.c -fsanitize=signed-integer-overflow | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/inline-asm-immediate-ubsan.c
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-unknown-unknown -emit-llvm -o - %s -fsanitize=signed-integer-overflow")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_inline_asm_matching_constraint_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/inline-asm-matching-constraint.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/inline-asm-matching-constraint.c -o - -triple powerpc64le-linux-gnu | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/inline-asm-matching-constraint.c
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm %s -o - -triple powerpc64le-linux-gnu")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_inline_asm_mixed_style_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/inline-asm-mixed-style.c");
    // REQUIRES: x86-registered-target
    if (!CHECK_REQUIRES("x86-registered-target")) {
      return;
    }
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i386-unknown-unknown -fasm-blocks -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/inline-asm-mixed-style.c -DCHECK_ASM_GOTO
    RUN(TestState.Failed, "%clang_cc1 -triple i386-unknown-unknown -fasm-blocks -fsyntax-only -verify %s -DCHECK_ASM_GOTO");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i386-unknown-unknown -fasm-blocks -O0 -emit-llvm -S ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/inline-asm-mixed-style.c -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/inline-asm-mixed-style.c
    RUN(TestState.Failed, "%clang_cc1 -triple i386-unknown-unknown -fasm-blocks -O0 -emit-llvm -S %s -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_inline_asm_mrv_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/inline-asm-mrv.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/inline-asm-mrv.c -o - -O | not grep alloca
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm %s -o - -O")./*|*/
      I("not grep alloca");
  }

  @Test
  public void test_inline_optim_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/inline-optim.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i686-pc-win32 -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/inline-optim.c -o - | ${LLVM_SRC}/build/bin/FileCheck -check-prefix=NOINLINE ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/inline-optim.c
    RUN(TestState.Failed, "%clang_cc1 -triple i686-pc-win32 -emit-llvm %s -o -")./*|*/
      I("FileCheck -check-prefix=NOINLINE %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i686-pc-win32 -O3 -fno-inline-functions -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/inline-optim.c -o - | ${LLVM_SRC}/build/bin/FileCheck -check-prefix=NOINLINE ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/inline-optim.c
    RUN(TestState.Failed, "%clang_cc1 -triple i686-pc-win32 -O3 -fno-inline-functions -emit-llvm %s -o -")./*|*/
      I("FileCheck -check-prefix=NOINLINE %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i686-pc-win32 -finline-hint-functions -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/inline-optim.c -o - | ${LLVM_SRC}/build/bin/FileCheck -check-prefix=HINT ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/inline-optim.c
    RUN(TestState.Failed, "%clang_cc1 -triple i686-pc-win32 -finline-hint-functions -emit-llvm %s -o -")./*|*/
      I("FileCheck -check-prefix=HINT %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i686-pc-win32 -finline-functions -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/inline-optim.c -o - | ${LLVM_SRC}/build/bin/FileCheck -check-prefix=INLINE ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/inline-optim.c
    RUN(TestState.Failed, "%clang_cc1 -triple i686-pc-win32 -finline-functions -emit-llvm %s -o -")./*|*/
      I("FileCheck -check-prefix=INLINE %s");
  }

  @Test
  public void test_inline2_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/inline2.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -O1 -std=gnu89 -triple i386-apple-darwin9 -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/inline2.c -o - | ${LLVM_SRC}/build/bin/FileCheck -check-prefix CHECK-GNU89 ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/inline2.c
    RUN(TestState.Failed, "%clang_cc1 -O1 -std=gnu89 -triple i386-apple-darwin9 -emit-llvm %s -o -")./*|*/
      I("FileCheck -check-prefix CHECK-GNU89 %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -O1 -std=c99 -triple i386-apple-darwin9 -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/inline2.c -o - | ${LLVM_SRC}/build/bin/FileCheck -check-prefix CHECK-C99 ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/inline2.c
    RUN(TestState.Failed, "%clang_cc1 -O1 -std=c99 -triple i386-apple-darwin9 -emit-llvm %s -o -")./*|*/
      I("FileCheck -check-prefix CHECK-C99 %s");
  }

  @Test
  public void test_instrument_functions_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/instrument-functions.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -S -debug-info-kind=standalone -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/instrument-functions.c -finstrument-functions | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/instrument-functions.c
    RUN(TestState.Failed, "%clang_cc1 -S -debug-info-kind=standalone -emit-llvm -o - %s -finstrument-functions")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_int_to_pointer_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/int-to-pointer.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/int-to-pointer.c -o ${TEST_TEMP_DIR}/int-to-pointer.c.tmp
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm %s -o %t");
  }

  @Test
  public void test_integer_overflow_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/integer-overflow.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-apple-darwin ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/integer-overflow.c -emit-llvm -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/integer-overflow.c --check-prefix=DEFAULT
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-apple-darwin %s -emit-llvm -o -")./*|*/
      I("FileCheck %s --check-prefix=DEFAULT");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-apple-darwin ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/integer-overflow.c -emit-llvm -o - -fwrapv | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/integer-overflow.c --check-prefix=WRAPV
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-apple-darwin %s -emit-llvm -o - -fwrapv")./*|*/
      I("FileCheck %s --check-prefix=WRAPV");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-apple-darwin ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/integer-overflow.c -emit-llvm -o - -ftrapv | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/integer-overflow.c --check-prefix=TRAPV
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-apple-darwin %s -emit-llvm -o - -ftrapv")./*|*/
      I("FileCheck %s --check-prefix=TRAPV");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-apple-darwin ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/integer-overflow.c -emit-llvm -o - -fsanitize=signed-integer-overflow | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/integer-overflow.c --check-prefix=CATCH_UB
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-apple-darwin %s -emit-llvm -o - -fsanitize=signed-integer-overflow")./*|*/
      I("FileCheck %s --check-prefix=CATCH_UB");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-apple-darwin ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/integer-overflow.c -emit-llvm -o - -ftrapv -ftrapv-handler foo | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/integer-overflow.c --check-prefix=TRAPV_HANDLER
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-apple-darwin %s -emit-llvm -o - -ftrapv -ftrapv-handler foo")./*|*/
      I("FileCheck %s --check-prefix=TRAPV_HANDLER");
  }

  @Test
  public void test_intel_ocl_bicc_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/intel_ocl_bicc.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i386-unknown-unknown -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/intel_ocl_bicc.c | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/intel_ocl_bicc.c
    RUN(TestState.Failed, "%clang_cc1 -triple i386-unknown-unknown -emit-llvm -o - %s")./*|*/
      I("FileCheck %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-unknown-unknown -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/intel_ocl_bicc.c | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/intel_ocl_bicc.c
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-unknown-unknown -emit-llvm -o - %s")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_invalid_global_asm_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/invalid_global_asm.c");
    // REQUIRES: arm-registered-target
    if (!CHECK_REQUIRES("arm-registered-target")) {
      return;
    }
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-obj -triple armv6-unknown-unknown -o ${TEST_TEMP_DIR}/invalid_global_asm.c.tmp ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/invalid_global_asm.c 2>&1 | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/invalid_global_asm.c
    RUN(TestState.Failed, "not %clang_cc1 -emit-obj -triple armv6-unknown-unknown -o %t %s 2>&1")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_kr_func_promote_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/kr-func-promote.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i386-unknown-unknown ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/kr-func-promote.c -emit-llvm -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/kr-func-promote.c
    RUN(TestState.Failed, "%clang_cc1 -triple i386-unknown-unknown %s -emit-llvm -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_kr_style_block_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/kr-style-block.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/kr-style-block.c -o ${TEST_TEMP_DIR}/kr-style-block.c.tmp -fblocks
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm %s -o %t -fblocks");
  }

  @Test
  public void test_lanai_arguments_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/lanai-arguments.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple lanai-unknown-unknown ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/lanai-arguments.c -emit-llvm -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/lanai-arguments.c
    RUN(TestState.Failed, "%clang_cc1 -triple lanai-unknown-unknown %s -emit-llvm -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_lanai_regparm_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/lanai-regparm.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple lanai-unknown-unknown -mregparm 4 ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/lanai-regparm.c -emit-llvm -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/lanai-regparm.c
    RUN(TestState.Failed, "%clang_cc1 -triple lanai-unknown-unknown -mregparm 4 %s -emit-llvm -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_le32_arguments_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/le32-arguments.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple le32-unknown-nacl ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/le32-arguments.c -emit-llvm -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/le32-arguments.c
    RUN(TestState.Failed, "%clang_cc1 -triple le32-unknown-nacl %s -emit-llvm -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_le32_libcall_pow_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/le32-libcall-pow.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fno-math-builtin -fmath-errno -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/le32-libcall-pow.c -triple le32-unknown-nacl | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/le32-libcall-pow.c
    RUN(TestState.Failed, "%clang_cc1 -fno-math-builtin -fmath-errno -emit-llvm -o - %s -triple le32-unknown-nacl")./*|*/
      I("FileCheck %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fno-math-builtin -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/le32-libcall-pow.c -triple le32-unknown-nacl | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/le32-libcall-pow.c
    RUN(TestState.Failed, "%clang_cc1 -fno-math-builtin -emit-llvm -o - %s -triple le32-unknown-nacl")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_le32_regparm_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/le32-regparm.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple le32-unknown-nacl ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/le32-regparm.c -fsyntax-only -verify
    RUN(TestState.Failed, "%clang_cc1 -triple le32-unknown-nacl %s -fsyntax-only -verify");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple aarch64 ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/le32-regparm.c -fsyntax-only -verify
    RUN(TestState.Failed, "%clang_cc1 -triple aarch64 %s -fsyntax-only -verify");
  }

  @Test
  public void test_le32_vaarg_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/le32-vaarg.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple le32-unknown-nacl -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/le32-vaarg.c | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/le32-vaarg.c
    RUN(TestState.Failed, "%clang_cc1 -triple le32-unknown-nacl -emit-llvm -o - %s")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_libcall_declarations_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/libcall-declarations.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-apple-darwin12 -S -o - -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/libcall-declarations.c | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/libcall-declarations.c -check-prefix=CHECK-NOERRNO
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-apple-darwin12 -S -o - -emit-llvm %s")./*|*/
      I("FileCheck %s -check-prefix=CHECK-NOERRNO");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-linux-gnu -S -o - -emit-llvm -fmath-errno ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/libcall-declarations.c | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/libcall-declarations.c -check-prefix=CHECK-ERRNO
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-linux-gnu -S -o - -emit-llvm -fmath-errno %s")./*|*/
      I("FileCheck %s -check-prefix=CHECK-ERRNO");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-apple-darwin12 -S -o - -emit-llvm -x c++ ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/libcall-declarations.c | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/libcall-declarations.c -check-prefix=CHECK-NOERRNO
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-apple-darwin12 -S -o - -emit-llvm -x c++ %s")./*|*/
      I("FileCheck %s -check-prefix=CHECK-NOERRNO");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-linux-gnu -S -o - -emit-llvm -x c++ -fmath-errno ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/libcall-declarations.c | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/libcall-declarations.c -check-prefix=CHECK-ERRNO
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-linux-gnu -S -o - -emit-llvm -x c++ -fmath-errno %s")./*|*/
      I("FileCheck %s -check-prefix=CHECK-ERRNO");
  }

  @Test
  public void test_libcalls_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/libcalls.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fmath-errno -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/libcalls.c -triple i386-unknown-unknown | ${LLVM_SRC}/build/bin/FileCheck -check-prefix CHECK-YES ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/libcalls.c
    RUN(TestState.Failed, "%clang_cc1 -fmath-errno -emit-llvm -o - %s -triple i386-unknown-unknown")./*|*/
      I("FileCheck -check-prefix CHECK-YES %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/libcalls.c -triple i386-unknown-unknown | ${LLVM_SRC}/build/bin/FileCheck -check-prefix CHECK-NO ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/libcalls.c
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm -o - %s -triple i386-unknown-unknown")./*|*/
      I("FileCheck -check-prefix CHECK-NO %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -menable-unsafe-fp-math -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/libcalls.c -triple i386-unknown-unknown | ${LLVM_SRC}/build/bin/FileCheck -check-prefix CHECK-FAST ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/libcalls.c
    RUN(TestState.Failed, "%clang_cc1 -menable-unsafe-fp-math -emit-llvm -o - %s -triple i386-unknown-unknown")./*|*/
      I("FileCheck -check-prefix CHECK-FAST %s");
  }

  @Test
  public void test_libcalls_complex_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/libcalls-complex.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fno-builtin -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/libcalls-complex.c -triple i386-unknown-unknown | ${LLVM_SRC}/build/bin/FileCheck -check-prefix CHECK-YES ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/libcalls-complex.c
    RUN(TestState.Failed, "%clang_cc1 -fno-builtin -emit-llvm -o - %s -triple i386-unknown-unknown")./*|*/
      I("FileCheck -check-prefix CHECK-YES %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fno-builtin-crealf -fno-builtin-creal -fno-builtin-creall -fno-builtin-cimagf -fno-builtin-cimag -fno-builtin-cimagl -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/libcalls-complex.c -triple i386-unknown-unknown | ${LLVM_SRC}/build/bin/FileCheck -check-prefix CHECK-YES ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/libcalls-complex.c
    RUN(TestState.Failed, "%clang_cc1 -fno-builtin-crealf -fno-builtin-creal -fno-builtin-creall -fno-builtin-cimagf  -fno-builtin-cimag -fno-builtin-cimagl -emit-llvm -o - %s -triple i386-unknown-unknown")./*|*/
      I("FileCheck -check-prefix CHECK-YES %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/libcalls-complex.c -triple i386-unknown-unknown | ${LLVM_SRC}/build/bin/FileCheck -check-prefix CHECK-NO ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/libcalls-complex.c
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm -o - %s -triple i386-unknown-unknown")./*|*/
      I("FileCheck -check-prefix CHECK-NO %s");
  }

  @Test
  public void test_libcalls_d_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/libcalls-d.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/libcalls-d.c -emit-llvm -fno-math-errno -o - | grep {call.*exp2\\.f64}
    RUN(TestState.Failed, "%clang_cc1 %s -emit-llvm -fno-math-errno -o -")./*|*/
      I("grep {call.*exp2\\\\.f64}");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/libcalls-d.c -emit-llvm -fmath-errno -o - | grep {call.*exp2}
    RUN(TestState.Failed, "%clang_cc1 %s -emit-llvm -fmath-errno -o -")./*|*/
      I("grep {call.*exp2}");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/libcalls-d.c -emit-llvm -O1 -o - | grep {call.*ldexp}
    RUN(TestState.Failed, "%clang_cc1 %s -emit-llvm -O1 -o -")./*|*/
      I("grep {call.*ldexp}");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/libcalls-d.c -emit-llvm -O3 -fno-builtin -o - | grep {call.*exp2}
    RUN(TestState.Failed, "%clang_cc1 %s -emit-llvm -O3 -fno-builtin -o -")./*|*/
      I("grep {call.*exp2}");
  }

  @Test
  public void test_libcalls_fno_builtin_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/libcalls-fno-builtin.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -S -O3 -fno-builtin -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/libcalls-fno-builtin.c | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/libcalls-fno-builtin.c
    RUN(TestState.Failed, "%clang_cc1 -S -O3 -fno-builtin -o - %s")./*|*/
      I("FileCheck %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -S -O3 -fno-builtin-ceil -fno-builtin-copysign -fno-builtin-cos -fno-builtin-fabs -fno-builtin-floor -fno-builtin-strcat -fno-builtin-strncat -fno-builtin-strchr -fno-builtin-strrchr -fno-builtin-strcmp -fno-builtin-strncmp -fno-builtin-strcpy -fno-builtin-stpcpy -fno-builtin-strncpy -fno-builtin-strlen -fno-builtin-strpbrk -fno-builtin-strspn -fno-builtin-strtod -fno-builtin-strtof -fno-builtin-strtold -fno-builtin-strtol -fno-builtin-strtoll -fno-builtin-strtoul -fno-builtin-strtoull -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/libcalls-fno-builtin.c | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/libcalls-fno-builtin.c
    RUN(TestState.Failed, "%clang_cc1 -S -O3 -fno-builtin-ceil -fno-builtin-copysign -fno-builtin-cos -fno-builtin-fabs -fno-builtin-floor -fno-builtin-strcat -fno-builtin-strncat -fno-builtin-strchr -fno-builtin-strrchr -fno-builtin-strcmp -fno-builtin-strncmp -fno-builtin-strcpy -fno-builtin-stpcpy -fno-builtin-strncpy -fno-builtin-strlen -fno-builtin-strpbrk -fno-builtin-strspn -fno-builtin-strtod -fno-builtin-strtof -fno-builtin-strtold -fno-builtin-strtol -fno-builtin-strtoll -fno-builtin-strtoul -fno-builtin-strtoull -o - %s")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_libcalls_ld_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/libcalls-ld.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/libcalls-ld.c -emit-llvm -fno-math-errno -o - | grep {call.*exp2\\..*f}
    RUN(TestState.Failed, "%clang_cc1 %s -emit-llvm -fno-math-errno -o -")./*|*/
      I("grep {call.*exp2\\\\..*f}");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/libcalls-ld.c -emit-llvm -fmath-errno -o - | grep {call.*exp2l}
    RUN(TestState.Failed, "%clang_cc1 %s -emit-llvm -fmath-errno -o -")./*|*/
      I("grep {call.*exp2l}");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/libcalls-ld.c -emit-llvm -O1 -o - | grep {call.*ldexp}
    RUN(TestState.Failed, "%clang_cc1 %s -emit-llvm -O1 -o -")./*|*/
      I("grep {call.*ldexp}");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/libcalls-ld.c -emit-llvm -O3 -fno-builtin -o - | grep {call.*exp2l}
    RUN(TestState.Failed, "%clang_cc1 %s -emit-llvm -O3 -fno-builtin -o -")./*|*/
      I("grep {call.*exp2l}");
  }

  @Test
  public void test_lifetime_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/lifetime.c");
    // ${LLVM_SRC}/build/bin/clang -S -emit-llvm -o - -O0 ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/lifetime.c | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/lifetime.c -check-prefix=O0
    RUN(TestState.Failed, "%clang -S -emit-llvm -o - -O0 %s")./*|*/
      I("FileCheck %s -check-prefix=O0");
    // ${LLVM_SRC}/build/bin/clang -S -emit-llvm -o - -O1 ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/lifetime.c | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/lifetime.c -check-prefix=O1
    RUN(TestState.Failed, "%clang -S -emit-llvm -o - -O1 %s")./*|*/
      I("FileCheck %s -check-prefix=O1");
    // ${LLVM_SRC}/build/bin/clang -S -emit-llvm -o - -O2 ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/lifetime.c | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/lifetime.c -check-prefix=O2
    RUN(TestState.Failed, "%clang -S -emit-llvm -o - -O2 %s")./*|*/
      I("FileCheck %s -check-prefix=O2");
    // ${LLVM_SRC}/build/bin/clang -S -emit-llvm -o - -O3 ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/lifetime.c | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/lifetime.c -check-prefix=O3
    RUN(TestState.Failed, "%clang -S -emit-llvm -o - -O3 %s")./*|*/
      I("FileCheck %s -check-prefix=O3");
  }

  @Test
  public void test_lifetime_asan_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/lifetime-asan.c");
    // ${LLVM_SRC}/build/bin/clang -target x86_64-linux-gnu -S -emit-llvm -o - -O0 ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/lifetime-asan.c | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/lifetime-asan.c -check-prefix=CHECK-O0
    RUN(TestState.Failed, "%clang -target x86_64-linux-gnu -S -emit-llvm -o - -O0 %s")./*|*/
      I("FileCheck %s -check-prefix=CHECK-O0");
    // ${LLVM_SRC}/build/bin/clang -target x86_64-linux-gnu -S -emit-llvm -o - -O0 -fsanitize=address -fsanitize-address-use-after-scope ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/lifetime-asan.c | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/lifetime-asan.c -check-prefix=CHECK-ASAN-USE-AFTER-SCOPE
    RUN(TestState.Failed, "%clang -target x86_64-linux-gnu -S -emit-llvm -o - -O0 -fsanitize=address -fsanitize-address-use-after-scope %s")./*|*/
      I("FileCheck %s -check-prefix=CHECK-ASAN-USE-AFTER-SCOPE");
  }

  @Test
  public void test_lifetime_debuginfo_1_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/lifetime-debuginfo-1.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -O1 -triple x86_64-none-linux-gnu -emit-llvm -debug-info-kind=line-tables-only ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/lifetime-debuginfo-1.c -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/lifetime-debuginfo-1.c
    RUN(TestState.Failed, "%clang_cc1 -O1 -triple x86_64-none-linux-gnu -emit-llvm -debug-info-kind=line-tables-only %s -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_lifetime_debuginfo_2_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/lifetime-debuginfo-2.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -O1 -triple x86_64-none-linux-gnu -emit-llvm -debug-info-kind=line-tables-only ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/lifetime-debuginfo-2.c -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/lifetime-debuginfo-2.c
    RUN(TestState.Failed, "%clang_cc1 -O1 -triple x86_64-none-linux-gnu -emit-llvm -debug-info-kind=line-tables-only %s -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_lifetime2_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/lifetime2.c");
    // ${LLVM_SRC}/build/bin/clang -S -emit-llvm -o - -O2 ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/lifetime2.c | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/lifetime2.c -check-prefix=O2
    RUN(TestState.Failed, "%clang -S -emit-llvm -o - -O2 %s")./*|*/
      I("FileCheck %s -check-prefix=O2");
    // ${LLVM_SRC}/build/bin/clang -S -emit-llvm -o - -O0 ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/lifetime2.c | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/lifetime2.c -check-prefix=O0
    RUN(TestState.Failed, "%clang -S -emit-llvm -o - -O0 %s")./*|*/
      I("FileCheck %s -check-prefix=O0");
  }

  @Test
  public void test_lineno_dbginfo_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/lineno-dbginfo.c");
    // echo '#include <stddef.h>' > ${TEST_TEMP_DIR}/lineno-dbginfo.c.tmp.h
    RUN(TestState.Failed, "echo \"#include <stddef.h>\" > %t.h");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -S -debug-info-kind=limited -include ${TEST_TEMP_DIR}/lineno-dbginfo.c.tmp.h ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/lineno-dbginfo.c -emit-llvm -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/lineno-dbginfo.c
    RUN(TestState.Failed, "%clang_cc1 -S -debug-info-kind=limited -include %t.h %s -emit-llvm -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_linetable_endscope_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/linetable-endscope.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm -debug-info-kind=limited -triple x86_64-apple-darwin10 ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/linetable-endscope.c -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/linetable-endscope.c
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm -debug-info-kind=limited -triple x86_64-apple-darwin10 %s -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_link_bitcode_file_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/link-bitcode-file.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i386-pc-linux-gnu -DBITCODE -emit-llvm-bc -o ${TEST_TEMP_DIR}/link-bitcode-file.c.tmp.bc ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/link-bitcode-file.c
    RUN(TestState.Failed, "%clang_cc1 -triple i386-pc-linux-gnu -DBITCODE -emit-llvm-bc -o %t.bc %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i386-pc-linux-gnu -DBITCODE2 -emit-llvm-bc -o ${TEST_TEMP_DIR}/link-bitcode-file.c.tmp-2.bc ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/link-bitcode-file.c
    RUN(TestState.Failed, "%clang_cc1 -triple i386-pc-linux-gnu -DBITCODE2 -emit-llvm-bc -o %t-2.bc %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i386-pc-linux-gnu -mlink-bitcode-file ${TEST_TEMP_DIR}/link-bitcode-file.c.tmp.bc -O3 -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/link-bitcode-file.c | ${LLVM_SRC}/build/bin/FileCheck -check-prefix=CHECK-NO-BC ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/link-bitcode-file.c
    RUN(TestState.Failed, "%clang_cc1 -triple i386-pc-linux-gnu -mlink-bitcode-file %t.bc -O3 -emit-llvm -o - %s")./*|*/
      I("FileCheck -check-prefix=CHECK-NO-BC %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i386-pc-linux-gnu -O3 -emit-llvm -o - -mlink-bitcode-file ${TEST_TEMP_DIR}/link-bitcode-file.c.tmp.bc -mlink-bitcode-file ${TEST_TEMP_DIR}/link-bitcode-file.c.tmp-2.bc ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/link-bitcode-file.c | ${LLVM_SRC}/build/bin/FileCheck -check-prefix=CHECK-NO-BC -check-prefix=CHECK-NO-BC2 ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/link-bitcode-file.c
    RUN(TestState.Failed, "%clang_cc1 -triple i386-pc-linux-gnu -O3 -emit-llvm -o - -mlink-bitcode-file %t.bc -mlink-bitcode-file %t-2.bc %s")./*|*/
      I("FileCheck -check-prefix=CHECK-NO-BC -check-prefix=CHECK-NO-BC2 %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i386-pc-linux-gnu -DBITCODE -O3 -emit-llvm -o - -mlink-bitcode-file ${TEST_TEMP_DIR}/link-bitcode-file.c.tmp.bc ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/link-bitcode-file.c 2>&1 | ${LLVM_SRC}/build/bin/FileCheck -check-prefix=CHECK-BC ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/link-bitcode-file.c
    RUN(TestState.Failed, "not %clang_cc1 -triple i386-pc-linux-gnu -DBITCODE -O3 -emit-llvm -o - -mlink-bitcode-file %t.bc %s 2>&1")./*|*/
      I("FileCheck -check-prefix=CHECK-BC %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i386-pc-linux-gnu -mlink-bitcode-file no-such-file.bc -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/link-bitcode-file.c 2>&1 | ${LLVM_SRC}/build/bin/FileCheck -check-prefix=CHECK-NO-FILE ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/link-bitcode-file.c
    RUN(TestState.Failed, "not %clang_cc1 -triple i386-pc-linux-gnu -mlink-bitcode-file no-such-file.bc -emit-llvm -o - %s 2>&1")./*|*/
      I("FileCheck -check-prefix=CHECK-NO-FILE %s");
  }

  @Test
  public void test_linkage_redecl_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/linkage-redecl.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/linkage-redecl.c -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/linkage-redecl.c
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm %s -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_linker_option_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/linker-option.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/linker-option.c --linker-option=/include:foo -triple i686-pc-win32 -emit-llvm -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/linker-option.c
    RUN(TestState.Failed, "%clang_cc1 %s --linker-option=/include:foo -triple i686-pc-win32 -emit-llvm -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_linux_arm_atomic_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/linux-arm-atomic.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/linux-arm-atomic.c -emit-llvm -o - -triple=armv7-unknown-linux | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/linux-arm-atomic.c
    RUN(TestState.Failed, "%clang_cc1 %s -emit-llvm -o - -triple=armv7-unknown-linux")./*|*/
      I("FileCheck %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/linux-arm-atomic.c -emit-llvm -o - -triple=armv6-unknown-linux | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/linux-arm-atomic.c
    RUN(TestState.Failed, "%clang_cc1 %s -emit-llvm -o - -triple=armv6-unknown-linux")./*|*/
      I("FileCheck %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/linux-arm-atomic.c -emit-llvm -o - -triple=thumbv7-unknown-linux | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/linux-arm-atomic.c
    RUN(TestState.Failed, "%clang_cc1 %s -emit-llvm -o - -triple=thumbv7-unknown-linux")./*|*/
      I("FileCheck %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/linux-arm-atomic.c -emit-llvm -o - -triple=armv6-unknown-freebsd | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/linux-arm-atomic.c
    RUN(TestState.Failed, "%clang_cc1 %s -emit-llvm -o - -triple=armv6-unknown-freebsd")./*|*/
      I("FileCheck %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/linux-arm-atomic.c -emit-llvm -o - -triple=armv6-unknown-bitrig | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/linux-arm-atomic.c
    RUN(TestState.Failed, "%clang_cc1 %s -emit-llvm -o - -triple=armv6-unknown-bitrig")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_long_double_x86_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/long-double-x86.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/long-double-x86.c -emit-llvm -o - -triple=i686-apple-darwin9 | grep x86_fp80
    RUN(TestState.Failed, "%clang_cc1 %s -emit-llvm -o - -triple=i686-apple-darwin9")./*|*/
      I("grep x86_fp80");
  }

  @Test
  public void test_long_double_fp128_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/long_double_fp128.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-linux-android -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/long_double_fp128.cpp | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/long_double_fp128.cpp --check-prefix=A64
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-linux-android -emit-llvm -o - %s")./*|*/
      I("FileCheck %s --check-prefix=A64");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-linux-gnu -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/long_double_fp128.cpp | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/long_double_fp128.cpp --check-prefix=G64
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-linux-gnu -emit-llvm -o - %s")./*|*/
      I("FileCheck %s --check-prefix=G64");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple powerpc64-linux-gnu -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/long_double_fp128.cpp | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/long_double_fp128.cpp --check-prefix=P64
    RUN(TestState.Failed, "%clang_cc1 -triple powerpc64-linux-gnu -emit-llvm -o - %s")./*|*/
      I("FileCheck %s --check-prefix=P64");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i686-linux-android -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/long_double_fp128.cpp | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/long_double_fp128.cpp --check-prefix=A32
    RUN(TestState.Failed, "%clang_cc1 -triple i686-linux-android -emit-llvm -o - %s")./*|*/
      I("FileCheck %s --check-prefix=A32");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i686-linux-gnu -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/long_double_fp128.cpp | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/long_double_fp128.cpp --check-prefix=G32
    RUN(TestState.Failed, "%clang_cc1 -triple i686-linux-gnu -emit-llvm -o - %s")./*|*/
      I("FileCheck %s --check-prefix=G32");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple powerpc-linux-gnu -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/long_double_fp128.cpp | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/long_double_fp128.cpp --check-prefix=P32
    RUN(TestState.Failed, "%clang_cc1 -triple powerpc-linux-gnu -emit-llvm -o - %s")./*|*/
      I("FileCheck %s --check-prefix=P32");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-nacl -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/long_double_fp128.cpp | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/long_double_fp128.cpp --check-prefix=N64
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-nacl -emit-llvm -o - %s")./*|*/
      I("FileCheck %s --check-prefix=N64");
  }

  @Test
  public void test_lzcnt_builtins_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/lzcnt-builtins.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/lzcnt-builtins.c -triple=x86_64-apple-darwin -target-feature +lzcnt -emit-llvm -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/lzcnt-builtins.c
    RUN(TestState.Failed, "%clang_cc1 %s -triple=x86_64-apple-darwin -target-feature +lzcnt -emit-llvm -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_malign_double_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/malign-double.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -malign-double -triple i386-unknown-linux -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/malign-double.cpp -o - | ${LLVM_SRC}/build/bin/FileCheck --check-prefix=CHECK-ON --check-prefix=CHECK ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/malign-double.cpp
    RUN(TestState.Failed, "%clang_cc1 -malign-double -triple i386-unknown-linux -emit-llvm %s -o -")./*|*/
      I("FileCheck --check-prefix=CHECK-ON --check-prefix=CHECK %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i386-unknown-linux -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/malign-double.cpp -o - | ${LLVM_SRC}/build/bin/FileCheck --check-prefix=CHECK-OFF --check-prefix=CHECK ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/malign-double.cpp
    RUN(TestState.Failed, "%clang_cc1 -triple i386-unknown-linux -emit-llvm %s -o -")./*|*/
      I("FileCheck --check-prefix=CHECK-OFF --check-prefix=CHECK %s");
  }

  @Test
  public void test_malign_double_x86_nacl_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/malign-double-x86-nacl.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/malign-double-x86-nacl.c -emit-llvm -o - -triple=i686-unknown-nacl | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/malign-double-x86-nacl.c
    RUN(TestState.Failed, "%clang_cc1 %s -emit-llvm -o - -triple=i686-unknown-nacl")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_mandel_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/mandel.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/mandel.c -o ${TEST_TEMP_DIR}/mandel.c.tmp
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm %s -o %t");
  }

  @Test
  public void test_mangle_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/mangle.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i386-pc-linux-gnu -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/mangle.c | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/mangle.c
    RUN(TestState.Failed, "%clang_cc1 -triple i386-pc-linux-gnu -emit-llvm -o - %s")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_mangle_blocks_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/mangle-blocks.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i386-apple-ios -fblocks -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/mangle-blocks.c | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/mangle-blocks.c
    RUN(TestState.Failed, "%clang_cc1 -triple i386-apple-ios -fblocks -emit-llvm -o - %s")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_mangle_ms_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/mangle-ms.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/mangle-ms.c -o - -triple=x86_64-pc-win32 | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/mangle-ms.c
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm %s -o - -triple=x86_64-pc-win32")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_mangle_windows_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/mangle-windows.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/mangle-windows.c -o - -triple=i386-pc-win32 | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/mangle-windows.c
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm %s -o - -triple=i386-pc-win32")./*|*/
      I("FileCheck %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/mangle-windows.c -o - -triple=i386-mingw32 | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/mangle-windows.c
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm %s -o - -triple=i386-mingw32")./*|*/
      I("FileCheck %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/mangle-windows.c -o - -triple=i386-pc-windows-msvc-elf | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/mangle-windows.c --check-prefix=ELF32
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm %s -o - -triple=i386-pc-windows-msvc-elf")./*|*/
      I("FileCheck %s --check-prefix=ELF32");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/mangle-windows.c -o - -triple=x86_64-pc-win32 | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/mangle-windows.c --check-prefix=X64
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm %s -o - -triple=x86_64-pc-win32")./*|*/
      I("FileCheck %s --check-prefix=X64");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/mangle-windows.c -o - -triple=x86_64-mingw32 | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/mangle-windows.c --check-prefix=X64
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm %s -o - -triple=x86_64-mingw32")./*|*/
      I("FileCheck %s --check-prefix=X64");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/mangle-windows.c -o - -triple=x86_64-pc-windows-msvc-elf | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/mangle-windows.c --check-prefix=ELF64
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm %s -o - -triple=x86_64-pc-windows-msvc-elf")./*|*/
      I("FileCheck %s --check-prefix=ELF64");
  }

  @Test
  public void test_mangle_windows_rtd_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/mangle-windows-rtd.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm -mrtd ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/mangle-windows-rtd.c -o - -triple=i386-mingw32 | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/mangle-windows-rtd.c
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm -mrtd %s -o - -triple=i386-mingw32")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_may_alias_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/may-alias.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -Werror -triple i386-unknown-unknown -emit-llvm -O1 -no-struct-path-tbaa -disable-llvm-optzns -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/may-alias.c | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/may-alias.c
    RUN(TestState.Failed, "%clang_cc1 -Werror -triple i386-unknown-unknown -emit-llvm -O1 -no-struct-path-tbaa -disable-llvm-optzns -o - %s")./*|*/
      I("FileCheck %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -Werror -triple i386-unknown-unknown -emit-llvm -O1 -disable-llvm-optzns -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/may-alias.c | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/may-alias.c -check-prefix=PATH
    RUN(TestState.Failed, "%clang_cc1 -Werror -triple i386-unknown-unknown -emit-llvm -O1 -disable-llvm-optzns -o - %s")./*|*/
      I("FileCheck %s -check-prefix=PATH");
  }

  @Test
  public void test_mbackchain_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/mbackchain.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -mbackchain -triple s390x-linux -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/mbackchain.c | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/mbackchain.c
    RUN(TestState.Failed, "%clang_cc1 -mbackchain -triple s390x-linux -emit-llvm -o - %s")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_mbackchain_2_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/mbackchain-2.c");
    // ${LLVM_SRC}/build/bin/clang -mbackchain --target=s390x-linux -S -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/mbackchain-2.c | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/mbackchain-2.c
    RUN(TestState.Failed, "%clang -mbackchain --target=s390x-linux -S -emit-llvm -o - %s")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_mbackchain_3_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/mbackchain-3.c");
    // ${LLVM_SRC}/build/bin/clang -mno-backchain --target=s390x-linux -S -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/mbackchain-3.c | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/mbackchain-3.c
    RUN(TestState.Failed, "%clang -mno-backchain --target=s390x-linux -S -emit-llvm -o - %s")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_mcount_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/mcount.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -pg -triple i386-unknown-unknown -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/mcount.c | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/mcount.c
    RUN(TestState.Failed, "%clang_cc1 -pg -triple i386-unknown-unknown -emit-llvm -o - %s")./*|*/
      I("FileCheck %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -pg -triple powerpc-unknown-gnu-linux -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/mcount.c | ${LLVM_SRC}/build/bin/FileCheck -check-prefix=CHECK-PREFIXED ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/mcount.c
    RUN(TestState.Failed, "%clang_cc1 -pg -triple powerpc-unknown-gnu-linux -emit-llvm -o - %s")./*|*/
      I("FileCheck -check-prefix=CHECK-PREFIXED %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -pg -triple powerpc64-unknown-gnu-linux -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/mcount.c | ${LLVM_SRC}/build/bin/FileCheck -check-prefix=CHECK-PREFIXED ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/mcount.c
    RUN(TestState.Failed, "%clang_cc1 -pg -triple powerpc64-unknown-gnu-linux -emit-llvm -o - %s")./*|*/
      I("FileCheck -check-prefix=CHECK-PREFIXED %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -pg -triple powerpc64le-unknown-gnu-linux -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/mcount.c | ${LLVM_SRC}/build/bin/FileCheck -check-prefix=CHECK-PREFIXED ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/mcount.c
    RUN(TestState.Failed, "%clang_cc1 -pg -triple powerpc64le-unknown-gnu-linux -emit-llvm -o - %s")./*|*/
      I("FileCheck -check-prefix=CHECK-PREFIXED %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -pg -triple i386-netbsd -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/mcount.c | ${LLVM_SRC}/build/bin/FileCheck -check-prefix=CHECK-PREFIXED ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/mcount.c
    RUN(TestState.Failed, "%clang_cc1 -pg -triple i386-netbsd -emit-llvm -o - %s")./*|*/
      I("FileCheck -check-prefix=CHECK-PREFIXED %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -pg -triple x86_64-netbsd -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/mcount.c | ${LLVM_SRC}/build/bin/FileCheck -check-prefix=CHECK-PREFIXED ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/mcount.c
    RUN(TestState.Failed, "%clang_cc1 -pg -triple x86_64-netbsd -emit-llvm -o - %s")./*|*/
      I("FileCheck -check-prefix=CHECK-PREFIXED %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -pg -triple arm-netbsd-eabi -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/mcount.c | ${LLVM_SRC}/build/bin/FileCheck -check-prefix=CHECK-PREFIXED ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/mcount.c
    RUN(TestState.Failed, "%clang_cc1 -pg -triple arm-netbsd-eabi -emit-llvm -o - %s")./*|*/
      I("FileCheck -check-prefix=CHECK-PREFIXED %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -pg -triple aarch64-netbsd -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/mcount.c | ${LLVM_SRC}/build/bin/FileCheck -check-prefix=CHECK-PREFIXED ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/mcount.c
    RUN(TestState.Failed, "%clang_cc1 -pg -triple aarch64-netbsd -emit-llvm -o - %s")./*|*/
      I("FileCheck -check-prefix=CHECK-PREFIXED %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -pg -triple mips-netbsd -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/mcount.c | ${LLVM_SRC}/build/bin/FileCheck -check-prefix=CHECK-PREFIXED ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/mcount.c
    RUN(TestState.Failed, "%clang_cc1 -pg -triple mips-netbsd -emit-llvm -o - %s")./*|*/
      I("FileCheck -check-prefix=CHECK-PREFIXED %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -pg -triple powerpc-netbsd -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/mcount.c | ${LLVM_SRC}/build/bin/FileCheck -check-prefix=CHECK-PREFIXED ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/mcount.c
    RUN(TestState.Failed, "%clang_cc1 -pg -triple powerpc-netbsd -emit-llvm -o - %s")./*|*/
      I("FileCheck -check-prefix=CHECK-PREFIXED %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -pg -triple powerpc64-netbsd -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/mcount.c | ${LLVM_SRC}/build/bin/FileCheck -check-prefix=CHECK-PREFIXED ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/mcount.c
    RUN(TestState.Failed, "%clang_cc1 -pg -triple powerpc64-netbsd -emit-llvm -o - %s")./*|*/
      I("FileCheck -check-prefix=CHECK-PREFIXED %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -pg -triple powerpc64le-netbsd -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/mcount.c | ${LLVM_SRC}/build/bin/FileCheck -check-prefix=CHECK-PREFIXED ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/mcount.c
    RUN(TestState.Failed, "%clang_cc1 -pg -triple powerpc64le-netbsd -emit-llvm -o - %s")./*|*/
      I("FileCheck -check-prefix=CHECK-PREFIXED %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -pg -triple sparc-netbsd -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/mcount.c | ${LLVM_SRC}/build/bin/FileCheck -check-prefix=CHECK-PREFIXED ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/mcount.c
    RUN(TestState.Failed, "%clang_cc1 -pg -triple sparc-netbsd -emit-llvm -o - %s")./*|*/
      I("FileCheck -check-prefix=CHECK-PREFIXED %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -pg -triple sparc64-netbsd -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/mcount.c | ${LLVM_SRC}/build/bin/FileCheck -check-prefix=CHECK-PREFIXED ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/mcount.c
    RUN(TestState.Failed, "%clang_cc1 -pg -triple sparc64-netbsd -emit-llvm -o - %s")./*|*/
      I("FileCheck -check-prefix=CHECK-PREFIXED %s");
  }

  @Test
  public void test_mcu_struct_return_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/mcu-struct-return.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i386-pc-elfiamcu -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/mcu-struct-return.c -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/mcu-struct-return.c
    RUN(TestState.Failed, "%clang_cc1 -triple i386-pc-elfiamcu -emit-llvm %s -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_merge_attrs_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/merge-attrs.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/merge-attrs.c -emit-llvm -o ${TEST_TEMP_DIR}/merge-attrs.c.tmp
    RUN(TestState.Failed, "%clang_cc1 %s -emit-llvm -o %t");
  }

  @Test
  public void test_merge_statics_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/merge-statics.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc < ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/merge-statics.c -emit-llvm | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/merge-statics.c
    RUN(TestState.Failed, "%clang_cc1 < %s -emit-llvm")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_microsoft_call_conv_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/microsoft-call-conv.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i386-pc-linux -emit-llvm < ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/microsoft-call-conv.c | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/microsoft-call-conv.c
    RUN(TestState.Failed, "%clang_cc1 -triple i386-pc-linux -emit-llvm < %s")./*|*/
      I("FileCheck %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i386-pc-linux -emit-llvm -mrtd < ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/microsoft-call-conv.c | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/microsoft-call-conv.c
    RUN(TestState.Failed, "%clang_cc1 -triple i386-pc-linux -emit-llvm -mrtd < %s")./*|*/
      I("FileCheck %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i386-pc-linux -emit-llvm -fms-compatibility < ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/microsoft-call-conv.c
    RUN(TestState.Failed, "%clang_cc1 -triple i386-pc-linux -emit-llvm -fms-compatibility < %s");
  }

  @Test
  public void test_microsoft_call_conv_x64_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/microsoft-call-conv-x64.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-pc-win32 -emit-llvm < ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/microsoft-call-conv-x64.c | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/microsoft-call-conv-x64.c
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-pc-win32 -emit-llvm < %s")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_mingw_long_double_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/mingw-long-double.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i686-windows-gnu -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/mingw-long-double.c | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/mingw-long-double.c --check-prefix=GNU32
    RUN(TestState.Failed, "%clang_cc1 -triple i686-windows-gnu -emit-llvm -o - %s")./*|*/
      I("FileCheck %s --check-prefix=GNU32");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-windows-gnu -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/mingw-long-double.c | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/mingw-long-double.c --check-prefix=GNU64
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-windows-gnu -emit-llvm -o - %s")./*|*/
      I("FileCheck %s --check-prefix=GNU64");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-windows-msvc -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/mingw-long-double.c | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/mingw-long-double.c --check-prefix=MSC64
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-windows-msvc -emit-llvm -o - %s")./*|*/
      I("FileCheck %s --check-prefix=MSC64");
  }

  @Test
  public void test_mips_byval_arg_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/mips-byval-arg.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple mipsel-unknown-linux -O3 -S -o - -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/mips-byval-arg.c | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/mips-byval-arg.c -check-prefix=O32
    RUN(TestState.Failed, "%clang_cc1 -triple mipsel-unknown-linux -O3 -S -o - -emit-llvm %s")./*|*/
      I("FileCheck %s -check-prefix=O32");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple mips64el-unknown-linux -O3 -S -target-abi n64 -o - -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/mips-byval-arg.c | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/mips-byval-arg.c -check-prefix=N64
    RUN(TestState.Failed, "%clang_cc1 -triple mips64el-unknown-linux -O3 -S -target-abi n64 -o - -emit-llvm %s")./*|*/
      I("FileCheck %s -check-prefix=N64");
  }

  @Test
  public void test_mips_clobber_reg_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/mips-clobber-reg.c");
    // ${LLVM_SRC}/build/bin/clang -target mipsel-unknown-linux -S -o - -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/mips-clobber-reg.c
    RUN(TestState.Failed, "%clang -target mipsel-unknown-linux -S -o - -emit-llvm %s");
  }

  @Test
  public void test_mips_constraint_regs_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/mips-constraint-regs.c");
    // ${LLVM_SRC}/build/bin/clang -target mipsel-unknown-linux -S -o - -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/mips-constraint-regs.c | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/mips-constraint-regs.c
    RUN(TestState.Failed, "%clang -target mipsel-unknown-linux -S -o - -emit-llvm %s")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_mips_constraints_mem_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/mips-constraints-mem.c");
    // ${LLVM_SRC}/build/bin/clang -target mipsel-unknown-linux -S -o - -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/mips-constraints-mem.c | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/mips-constraints-mem.c
    RUN(TestState.Failed, "%clang -target mipsel-unknown-linux -S -o - -emit-llvm %s")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_mips_count_builtins_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/mips-count-builtins.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/mips-count-builtins.c -triple mips-unknown-linux-gnu -emit-llvm -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/mips-count-builtins.c
    RUN(TestState.Failed, "%clang_cc1 %s -triple mips-unknown-linux-gnu -emit-llvm -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_mips_inline_asm_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/mips-inline-asm.c");
    // REQUIRES: mips-registered-target
    if (!CHECK_REQUIRES("mips-registered-target")) {
      return;
    }
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple mips-linux-gnu -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/mips-inline-asm.c | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/mips-inline-asm.c
    RUN(TestState.Failed, "%clang_cc1 -triple mips-linux-gnu -emit-llvm -o - %s")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_mips_inline_asm_abi_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/mips-inline-asm-abi.c");
    // REQUIRES: mips-registered-target
    if (!CHECK_REQUIRES("mips-registered-target")) {
      return;
    }
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple mips-linux-gnu -emit-obj -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/mips-inline-asm-abi.c | llvm-readobj -h - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/mips-inline-asm-abi.c
    RUN(TestState.Failed, "%clang_cc1 -triple mips-linux-gnu -emit-obj -o - %s")./*|*/
      I("llvm-readobj -h -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_mips_inline_asm_modifiers_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/mips-inline-asm-modifiers.c");
    // ${LLVM_SRC}/build/bin/clang -target mipsel-unknown-linux -S -o - -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/mips-inline-asm-modifiers.c | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/mips-inline-asm-modifiers.c
    RUN(TestState.Failed, "%clang -target mipsel-unknown-linux -S -o - -emit-llvm %s")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_mips_interrupt_attr_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/mips-interrupt-attr.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple mipsel-unknown-linux -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/mips-interrupt-attr.c | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/mips-interrupt-attr.c
    RUN(TestState.Failed, "%clang_cc1 -triple mipsel-unknown-linux -emit-llvm -o - %s")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_mips_transparent_union_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/mips-transparent-union.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple mips64-linux-gnu -S -o - -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/mips-transparent-union.c | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/mips-transparent-union.c
    RUN(TestState.Failed, "%clang_cc1 -triple mips64-linux-gnu -S -o - -emit-llvm %s")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_mips_type_sizes_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/mips-type-sizes.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple mips-none-linux-gnu -emit-llvm -w -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/mips-type-sizes.c | ${LLVM_SRC}/build/bin/FileCheck --check-prefix=ALL --check-prefix=O32 ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/mips-type-sizes.c
    RUN(TestState.Failed, "%clang_cc1 -triple mips-none-linux-gnu -emit-llvm -w -o - %s")./*|*/
      I("FileCheck --check-prefix=ALL --check-prefix=O32 %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple mips64-none-linux-gnu -emit-llvm -w -target-abi n32 -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/mips-type-sizes.c | ${LLVM_SRC}/build/bin/FileCheck --check-prefix=ALL --check-prefix=N32 ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/mips-type-sizes.c
    RUN(TestState.Failed, "%clang_cc1 -triple mips64-none-linux-gnu -emit-llvm -w -target-abi n32 -o - %s")./*|*/
      I("FileCheck --check-prefix=ALL --check-prefix=N32 %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple mips64-none-linux-gnu -emit-llvm -w -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/mips-type-sizes.c | ${LLVM_SRC}/build/bin/FileCheck --check-prefix=ALL --check-prefix=N64 ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/mips-type-sizes.c
    RUN(TestState.Failed, "%clang_cc1 -triple mips64-none-linux-gnu -emit-llvm -w -o - %s")./*|*/
      I("FileCheck --check-prefix=ALL --check-prefix=N64 %s");
  }

  @Test
  public void test_mips_type_sizes_int128_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/mips-type-sizes-int128.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple mips-none-linux-gnu -emit-llvm -w -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/mips-type-sizes-int128.c 2> ${TEST_TEMP_DIR}/mips-type-sizes-int128.c.tmp1
    RUN(TestState.Failed, "not %clang_cc1 -triple mips-none-linux-gnu -emit-llvm -w -o - %s 2> %t1");
    // ${LLVM_SRC}/build/bin/FileCheck --check-prefix=O32 ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/mips-type-sizes-int128.c < ${TEST_TEMP_DIR}/mips-type-sizes-int128.c.tmp1
    RUN(TestState.Failed, "FileCheck --check-prefix=O32 %s < %t1");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple mips64-none-linux-gnu -emit-llvm -w -target-abi n32 -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/mips-type-sizes-int128.c | ${LLVM_SRC}/build/bin/FileCheck --check-prefix=NEW ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/mips-type-sizes-int128.c
    RUN(TestState.Failed, "%clang_cc1 -triple mips64-none-linux-gnu -emit-llvm -w -target-abi n32 -o - %s")./*|*/
      I("FileCheck --check-prefix=NEW %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple mips64-none-linux-gnu -emit-llvm -w -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/mips-type-sizes-int128.c | ${LLVM_SRC}/build/bin/FileCheck --check-prefix=NEW ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/mips-type-sizes-int128.c
    RUN(TestState.Failed, "%clang_cc1 -triple mips64-none-linux-gnu -emit-llvm -w -o - %s")./*|*/
      I("FileCheck --check-prefix=NEW %s");
  }

  @Test
  public void test_mips_unsigned_ext_var_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/mips-unsigned-ext-var.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple mips64-unknown-linux -O2 -target-abi n64 -S -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/mips-unsigned-ext-var.c -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/mips-unsigned-ext-var.c -check-prefix=N64
    RUN(TestState.Failed, "%clang_cc1 -triple mips64-unknown-linux -O2 -target-abi n64 -S -emit-llvm %s -o -")./*|*/
      I("FileCheck %s -check-prefix=N64");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple mips64-unknown-linux -O2 -target-abi n32 -S -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/mips-unsigned-ext-var.c -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/mips-unsigned-ext-var.c -check-prefix=N32
    RUN(TestState.Failed, "%clang_cc1 -triple mips64-unknown-linux -O2 -target-abi n32 -S -emit-llvm %s -o -")./*|*/
      I("FileCheck %s -check-prefix=N32");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple mips-unknown-linux -O2 -target-abi o32 -S -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/mips-unsigned-ext-var.c -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/mips-unsigned-ext-var.c -check-prefix=O32
    RUN(TestState.Failed, "%clang_cc1 -triple mips-unknown-linux -O2 -target-abi o32 -S -emit-llvm %s -o -")./*|*/
      I("FileCheck %s -check-prefix=O32");
  }

  @Test
  public void test_mips_unsigned_extend_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/mips-unsigned-extend.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple mips64-unknown-linux -O0 -target-abi n64 -S -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/mips-unsigned-extend.c -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/mips-unsigned-extend.c -check-prefix=N64
    RUN(TestState.Failed, "%clang_cc1 -triple mips64-unknown-linux -O0 -target-abi n64 -S -emit-llvm %s -o -")./*|*/
      I("FileCheck %s -check-prefix=N64");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple mips64-unknown-linux -O0 -target-abi n32 -S -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/mips-unsigned-extend.c -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/mips-unsigned-extend.c -check-prefix=N32
    RUN(TestState.Failed, "%clang_cc1 -triple mips64-unknown-linux -O0 -target-abi n32 -S -emit-llvm %s -o -")./*|*/
      I("FileCheck %s -check-prefix=N32");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple mips-unknown-linux -O0 -target-abi o32 -S -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/mips-unsigned-extend.c -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/mips-unsigned-extend.c -check-prefix=O32
    RUN(TestState.Failed, "%clang_cc1 -triple mips-unknown-linux -O0 -target-abi o32 -S -emit-llvm %s -o -")./*|*/
      I("FileCheck %s -check-prefix=O32");
  }

  @Test
  public void test_mips_unsupported_nan_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/mips-unsupported-nan.c");
    // ${LLVM_SRC}/build/bin/clang -target mipsel-unknown-linux -mnan=2008 -march=mips2 -emit-llvm -S ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/mips-unsupported-nan.c -o - '2>${TEST_TEMP_DIR}/mips-unsupported-nan.c.tmp' | ${LLVM_SRC}/build/bin/FileCheck -check-prefix=CHECK-NANLEGACY ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/mips-unsupported-nan.c
    RUN(TestState.Failed, "%clang -target mipsel-unknown-linux -mnan=2008 -march=mips2 -emit-llvm -S %s -o - 2>%t")./*|*/
      I("FileCheck -check-prefix=CHECK-NANLEGACY %s");
    // ${LLVM_SRC}/build/bin/FileCheck -check-prefix=CHECK-MIPS2 ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/mips-unsupported-nan.c < ${TEST_TEMP_DIR}/mips-unsupported-nan.c.tmp
    RUN(TestState.Failed, "FileCheck -check-prefix=CHECK-MIPS2 %s < %t");
    // ${LLVM_SRC}/build/bin/clang -target mips64el-unknown-linux -mnan=2008 -march=mips3 -emit-llvm -S ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/mips-unsupported-nan.c -o - '2>${TEST_TEMP_DIR}/mips-unsupported-nan.c.tmp' | ${LLVM_SRC}/build/bin/FileCheck -check-prefix=CHECK-NANLEGACY ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/mips-unsupported-nan.c
    RUN(TestState.Failed, "%clang -target mips64el-unknown-linux -mnan=2008 -march=mips3 -emit-llvm -S %s -o - 2>%t")./*|*/
      I("FileCheck -check-prefix=CHECK-NANLEGACY %s");
    // ${LLVM_SRC}/build/bin/FileCheck -check-prefix=CHECK-MIPS3 ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/mips-unsupported-nan.c < ${TEST_TEMP_DIR}/mips-unsupported-nan.c.tmp
    RUN(TestState.Failed, "FileCheck -check-prefix=CHECK-MIPS3 %s < %t");
    // ${LLVM_SRC}/build/bin/clang -target mips64el-unknown-linux -mnan=2008 -march=mips4 -emit-llvm -S ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/mips-unsupported-nan.c -o - '2>${TEST_TEMP_DIR}/mips-unsupported-nan.c.tmp' | ${LLVM_SRC}/build/bin/FileCheck -check-prefix=CHECK-NANLEGACY ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/mips-unsupported-nan.c
    RUN(TestState.Failed, "%clang -target mips64el-unknown-linux -mnan=2008 -march=mips4 -emit-llvm -S %s -o - 2>%t")./*|*/
      I("FileCheck -check-prefix=CHECK-NANLEGACY %s");
    // ${LLVM_SRC}/build/bin/FileCheck -check-prefix=CHECK-MIPS4 ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/mips-unsupported-nan.c < ${TEST_TEMP_DIR}/mips-unsupported-nan.c.tmp
    RUN(TestState.Failed, "FileCheck -check-prefix=CHECK-MIPS4 %s < %t");
    // ${LLVM_SRC}/build/bin/clang -target mipsel-unknown-linux -mnan=2008 -march=mips32 -emit-llvm -S ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/mips-unsupported-nan.c -o - '2>${TEST_TEMP_DIR}/mips-unsupported-nan.c.tmp' | ${LLVM_SRC}/build/bin/FileCheck -check-prefix=CHECK-NANLEGACY ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/mips-unsupported-nan.c
    RUN(TestState.Failed, "%clang -target mipsel-unknown-linux -mnan=2008 -march=mips32 -emit-llvm -S %s -o - 2>%t")./*|*/
      I("FileCheck -check-prefix=CHECK-NANLEGACY %s");
    // ${LLVM_SRC}/build/bin/FileCheck -check-prefix=CHECK-MIPS32 ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/mips-unsupported-nan.c < ${TEST_TEMP_DIR}/mips-unsupported-nan.c.tmp
    RUN(TestState.Failed, "FileCheck -check-prefix=CHECK-MIPS32 %s < %t");
    // ${LLVM_SRC}/build/bin/clang -target mipsel-unknown-linux -mnan=2008 -march=mips32r2 -emit-llvm -S ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/mips-unsupported-nan.c -o - '2>${TEST_TEMP_DIR}/mips-unsupported-nan.c.tmp' | ${LLVM_SRC}/build/bin/FileCheck -check-prefix=CHECK-NAN2008 ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/mips-unsupported-nan.c
    RUN(TestState.Failed, "%clang -target mipsel-unknown-linux -mnan=2008 -march=mips32r2 -emit-llvm -S %s -o - 2>%t")./*|*/
      I("FileCheck -check-prefix=CHECK-NAN2008 %s");
    // ${LLVM_SRC}/build/bin/FileCheck -allow-empty -check-prefix=NO-WARNINGS ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/mips-unsupported-nan.c < ${TEST_TEMP_DIR}/mips-unsupported-nan.c.tmp
    RUN(TestState.Failed, "FileCheck -allow-empty -check-prefix=NO-WARNINGS %s < %t");
    // ${LLVM_SRC}/build/bin/clang -target mipsel-unknown-linux -mnan=2008 -march=mips32r3 -emit-llvm -S ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/mips-unsupported-nan.c -o - '2>${TEST_TEMP_DIR}/mips-unsupported-nan.c.tmp' | ${LLVM_SRC}/build/bin/FileCheck -check-prefix=CHECK-NAN2008 ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/mips-unsupported-nan.c
    RUN(TestState.Failed, "%clang -target mipsel-unknown-linux -mnan=2008 -march=mips32r3 -emit-llvm -S %s -o - 2>%t")./*|*/
      I("FileCheck -check-prefix=CHECK-NAN2008 %s");
    // ${LLVM_SRC}/build/bin/FileCheck -allow-empty -check-prefix=NO-WARNINGS ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/mips-unsupported-nan.c < ${TEST_TEMP_DIR}/mips-unsupported-nan.c.tmp
    RUN(TestState.Failed, "FileCheck -allow-empty -check-prefix=NO-WARNINGS %s < %t");
    // ${LLVM_SRC}/build/bin/clang -target mipsel-unknown-linux -mnan=legacy -march=mips32r6 -emit-llvm -S ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/mips-unsupported-nan.c -o - '2>${TEST_TEMP_DIR}/mips-unsupported-nan.c.tmp' | ${LLVM_SRC}/build/bin/FileCheck -check-prefix=CHECK-NAN2008 ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/mips-unsupported-nan.c
    RUN(TestState.Failed, "%clang -target mipsel-unknown-linux -mnan=legacy -march=mips32r6 -emit-llvm -S %s -o - 2>%t")./*|*/
      I("FileCheck -check-prefix=CHECK-NAN2008 %s");
    // ${LLVM_SRC}/build/bin/FileCheck -check-prefix=CHECK-MIPS32R6 ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/mips-unsupported-nan.c < ${TEST_TEMP_DIR}/mips-unsupported-nan.c.tmp
    RUN(TestState.Failed, "FileCheck -check-prefix=CHECK-MIPS32R6 %s < %t");
    // ${LLVM_SRC}/build/bin/clang -target mips64el-unknown-linux -mnan=2008 -march=mips64 -emit-llvm -S ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/mips-unsupported-nan.c -o - '2>${TEST_TEMP_DIR}/mips-unsupported-nan.c.tmp' | ${LLVM_SRC}/build/bin/FileCheck -check-prefix=CHECK-NANLEGACY ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/mips-unsupported-nan.c
    RUN(TestState.Failed, "%clang -target mips64el-unknown-linux -mnan=2008 -march=mips64 -emit-llvm -S %s -o - 2>%t")./*|*/
      I("FileCheck -check-prefix=CHECK-NANLEGACY %s");
    // ${LLVM_SRC}/build/bin/FileCheck -check-prefix=CHECK-MIPS64 ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/mips-unsupported-nan.c < ${TEST_TEMP_DIR}/mips-unsupported-nan.c.tmp
    RUN(TestState.Failed, "FileCheck -check-prefix=CHECK-MIPS64 %s < %t");
    // ${LLVM_SRC}/build/bin/clang -target mips64el-unknown-linux -mnan=2008 -march=mips64r2 -emit-llvm -S ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/mips-unsupported-nan.c -o - '2>${TEST_TEMP_DIR}/mips-unsupported-nan.c.tmp' | ${LLVM_SRC}/build/bin/FileCheck -check-prefix=CHECK-NAN2008 ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/mips-unsupported-nan.c
    RUN(TestState.Failed, "%clang -target mips64el-unknown-linux -mnan=2008 -march=mips64r2 -emit-llvm -S %s -o - 2>%t")./*|*/
      I("FileCheck -check-prefix=CHECK-NAN2008 %s");
    // ${LLVM_SRC}/build/bin/FileCheck -allow-empty -check-prefix=NO-WARNINGS ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/mips-unsupported-nan.c < ${TEST_TEMP_DIR}/mips-unsupported-nan.c.tmp
    RUN(TestState.Failed, "FileCheck -allow-empty -check-prefix=NO-WARNINGS %s < %t");
    // ${LLVM_SRC}/build/bin/clang -target mips64el-unknown-linux -mnan=legacy -march=mips64r6 -emit-llvm -S ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/mips-unsupported-nan.c -o - '2>${TEST_TEMP_DIR}/mips-unsupported-nan.c.tmp' | ${LLVM_SRC}/build/bin/FileCheck -check-prefix=CHECK-NAN2008 ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/mips-unsupported-nan.c
    RUN(TestState.Failed, "%clang -target mips64el-unknown-linux -mnan=legacy -march=mips64r6 -emit-llvm -S %s -o - 2>%t")./*|*/
      I("FileCheck -check-prefix=CHECK-NAN2008 %s");
    // ${LLVM_SRC}/build/bin/FileCheck -check-prefix=CHECK-MIPS64R6 ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/mips-unsupported-nan.c < ${TEST_TEMP_DIR}/mips-unsupported-nan.c.tmp
    RUN(TestState.Failed, "FileCheck -check-prefix=CHECK-MIPS64R6 %s < %t");
  }

  @Test
  public void test_mips_varargs_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/mips-varargs.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple mips-unknown-linux -o - -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/mips-varargs.c | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/mips-varargs.c -check-prefix=ALL -check-prefix=O32
    RUN(TestState.Failed, "%clang_cc1 -triple mips-unknown-linux -o - -emit-llvm %s")./*|*/
      I("FileCheck %s -check-prefix=ALL -check-prefix=O32");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple mipsel-unknown-linux -o - -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/mips-varargs.c | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/mips-varargs.c -check-prefix=ALL -check-prefix=O32
    RUN(TestState.Failed, "%clang_cc1 -triple mipsel-unknown-linux -o - -emit-llvm %s")./*|*/
      I("FileCheck %s -check-prefix=ALL -check-prefix=O32");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple mips64-unknown-linux -o - -emit-llvm -target-abi n32 ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/mips-varargs.c | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/mips-varargs.c -check-prefix=ALL -check-prefix=N32 -check-prefix=NEW
    RUN(TestState.Failed, "%clang_cc1 -triple mips64-unknown-linux -o - -emit-llvm  -target-abi n32 %s")./*|*/
      I("FileCheck %s -check-prefix=ALL -check-prefix=N32 -check-prefix=NEW");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple mips64-unknown-linux -o - -emit-llvm -target-abi n32 ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/mips-varargs.c | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/mips-varargs.c -check-prefix=ALL -check-prefix=N32 -check-prefix=NEW
    RUN(TestState.Failed, "%clang_cc1 -triple mips64-unknown-linux -o - -emit-llvm  -target-abi n32 %s")./*|*/
      I("FileCheck %s -check-prefix=ALL -check-prefix=N32 -check-prefix=NEW");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple mips64-unknown-linux -o - -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/mips-varargs.c | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/mips-varargs.c -check-prefix=ALL -check-prefix=N64 -check-prefix=NEW
    RUN(TestState.Failed, "%clang_cc1 -triple mips64-unknown-linux -o - -emit-llvm %s")./*|*/
      I("FileCheck %s -check-prefix=ALL -check-prefix=N64 -check-prefix=NEW");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple mips64el-unknown-linux -o - -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/mips-varargs.c | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/mips-varargs.c -check-prefix=ALL -check-prefix=N64 -check-prefix=NEW
    RUN(TestState.Failed, "%clang_cc1 -triple mips64el-unknown-linux -o - -emit-llvm %s")./*|*/
      I("FileCheck %s -check-prefix=ALL -check-prefix=N64 -check-prefix=NEW");
  }

  @Test
  public void test_mips_vector_arg_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/mips-vector-arg.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple mipsel-unknown-linux -O3 -S -o - -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/mips-vector-arg.c | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/mips-vector-arg.c -check-prefix=O32
    RUN(TestState.Failed, "%clang_cc1 -triple mipsel-unknown-linux -O3 -S -o - -emit-llvm %s")./*|*/
      I("FileCheck %s -check-prefix=O32");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple mips64el-unknown-linux -O3 -S -target-abi n64 -o - -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/mips-vector-arg.c | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/mips-vector-arg.c -check-prefix=N64
    RUN(TestState.Failed, "%clang_cc1 -triple mips64el-unknown-linux -O3 -S -target-abi n64 -o - -emit-llvm %s")./*|*/
      I("FileCheck %s -check-prefix=N64");
  }

  @Test
  public void test_mips_vector_return_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/mips-vector-return.c");
    // ${LLVM_SRC}/build/bin/clang -target mipsel-unknown-linux -O3 -S -o - -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/mips-vector-return.c | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/mips-vector-return.c -check-prefix=O32
    RUN(TestState.Failed, "%clang -target mipsel-unknown-linux -O3 -S -o - -emit-llvm %s")./*|*/
      I("FileCheck %s -check-prefix=O32");
    // ${LLVM_SRC}/build/bin/clang -target mips64el-unknown-linux -O3 -S -mabi=n64 -o - -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/mips-vector-return.c | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/mips-vector-return.c -check-prefix=N64
    RUN(TestState.Failed, "%clang -target mips64el-unknown-linux -O3 -S -mabi=n64 -o - -emit-llvm %s")./*|*/
      I("FileCheck %s -check-prefix=N64");
  }

  @Test
  public void test_mips_zero_sized_struct_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/mips-zero-sized-struct.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple mips-unknown-linux-gnu -S -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/mips-zero-sized-struct.c | ${LLVM_SRC}/build/bin/FileCheck -check-prefix=O32 ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/mips-zero-sized-struct.c
    RUN(TestState.Failed, "%clang_cc1 -triple mips-unknown-linux-gnu -S -emit-llvm -o - %s")./*|*/
      I("FileCheck -check-prefix=O32 %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple mipsel-unknown-linux-gnu -S -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/mips-zero-sized-struct.c | ${LLVM_SRC}/build/bin/FileCheck -check-prefix=O32 ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/mips-zero-sized-struct.c
    RUN(TestState.Failed, "%clang_cc1 -triple mipsel-unknown-linux-gnu -S -emit-llvm -o - %s")./*|*/
      I("FileCheck -check-prefix=O32 %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple mips64-unknown-linux-gnu -S -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/mips-zero-sized-struct.c -target-abi n32 | ${LLVM_SRC}/build/bin/FileCheck -check-prefix=N32 ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/mips-zero-sized-struct.c
    RUN(TestState.Failed, "%clang_cc1 -triple mips64-unknown-linux-gnu -S -emit-llvm -o - %s  -target-abi n32")./*|*/
      I("FileCheck -check-prefix=N32 %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple mips64el-unknown-linux-gnu -S -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/mips-zero-sized-struct.c -target-abi n32 | ${LLVM_SRC}/build/bin/FileCheck -check-prefix=N32 ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/mips-zero-sized-struct.c
    RUN(TestState.Failed, "%clang_cc1 -triple mips64el-unknown-linux-gnu -S -emit-llvm -o - %s  -target-abi n32")./*|*/
      I("FileCheck -check-prefix=N32 %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple mips64-unknown-linux-gnu -S -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/mips-zero-sized-struct.c | ${LLVM_SRC}/build/bin/FileCheck -check-prefix=N64 ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/mips-zero-sized-struct.c
    RUN(TestState.Failed, "%clang_cc1 -triple mips64-unknown-linux-gnu -S -emit-llvm -o - %s")./*|*/
      I("FileCheck -check-prefix=N64 %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple mips64el-unknown-linux-gnu -S -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/mips-zero-sized-struct.c | ${LLVM_SRC}/build/bin/FileCheck -check-prefix=N64 ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/mips-zero-sized-struct.c
    RUN(TestState.Failed, "%clang_cc1 -triple mips64el-unknown-linux-gnu -S -emit-llvm -o - %s")./*|*/
      I("FileCheck -check-prefix=N64 %s");
  }

  @Test
  public void test_mips16_attr_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/mips16-attr.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple mipsel-linux-gnu -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/mips16-attr.c | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/mips16-attr.c
    RUN(TestState.Failed, "%clang_cc1 -triple mipsel-linux-gnu -emit-llvm  -o  - %s")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_mips64_class_return_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/mips64-class-return.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple mips64el-unknown-linux -O3 -S -target-abi n64 -o - -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/mips64-class-return.cpp | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/mips64-class-return.cpp
    RUN(TestState.Failed, "%clang_cc1 -triple mips64el-unknown-linux -O3 -S -target-abi n64 -o - -emit-llvm %s")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_mips64_f128_literal_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/mips64-f128-literal.c");
    // ${LLVM_SRC}/build/bin/clang -target mips64el-unknown-linux -O3 -S -mabi=n64 -o - -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/mips64-f128-literal.c | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/mips64-f128-literal.c
    RUN(TestState.Failed, "%clang -target mips64el-unknown-linux -O3 -S -mabi=n64 -o - -emit-llvm %s")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_mips64_nontrivial_return_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/mips64-nontrivial-return.cpp");
    // ${LLVM_SRC}/build/bin/clang -target mips64el-unknown-linux -O3 -S -mabi=n64 -o - -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/mips64-nontrivial-return.cpp | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/mips64-nontrivial-return.cpp
    RUN(TestState.Failed, "%clang -target mips64el-unknown-linux -O3 -S -mabi=n64 -o - -emit-llvm %s")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_mips64_padding_arg_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/mips64-padding-arg.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple mipsel-unknown-linux -O3 -S -o - -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/mips64-padding-arg.c | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/mips64-padding-arg.c -check-prefix=O32
    RUN(TestState.Failed, "%clang_cc1 -triple mipsel-unknown-linux -O3 -S -o - -emit-llvm %s")./*|*/
      I("FileCheck %s -check-prefix=O32");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple mips64el-unknown-linux -O3 -S -target-abi n64 -o - -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/mips64-padding-arg.c | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/mips64-padding-arg.c -check-prefix=N64
    RUN(TestState.Failed, "%clang_cc1 -triple mips64el-unknown-linux -O3 -S -target-abi n64 -o - -emit-llvm %s")./*|*/
      I("FileCheck %s -check-prefix=N64");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple mipsel-unknown-linux -target-feature +fp64 -O3 -S -o - -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/mips64-padding-arg.c | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/mips64-padding-arg.c -check-prefix=O32
    RUN(TestState.Failed, "%clang_cc1 -triple mipsel-unknown-linux -target-feature \"+fp64\" -O3 -S -o - -emit-llvm %s")./*|*/
      I("FileCheck %s -check-prefix=O32");
  }

  @Test
  public void test_misaligned_param_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/misaligned-param.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/misaligned-param.c -triple i386-apple-darwin -emit-llvm -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/misaligned-param.c
    RUN(TestState.Failed, "%clang_cc1 %s -triple i386-apple-darwin -emit-llvm -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_mms_bitfields_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/mms-bitfields.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i386-apple-darwin10 -mms-bitfields -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/mms-bitfields.c -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/mms-bitfields.c
    RUN(TestState.Failed, "%clang_cc1 -triple i386-apple-darwin10 -mms-bitfields -emit-llvm %s -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_mmx_builtins_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/mmx-builtins.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/mmx-builtins.c -triple=x86_64-apple-darwin -target-feature +ssse3 -emit-llvm -o - -Werror | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/mmx-builtins.c
    RUN(TestState.Failed, "%clang_cc1 %s -triple=x86_64-apple-darwin -target-feature +ssse3 -emit-llvm -o - -Werror")./*|*/
      I("FileCheck %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/mmx-builtins.c -triple=x86_64-apple-darwin -target-feature +ssse3 -fno-signed-char -emit-llvm -o - -Werror | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/mmx-builtins.c
    RUN(TestState.Failed, "%clang_cc1 %s -triple=x86_64-apple-darwin -target-feature +ssse3 -fno-signed-char -emit-llvm -o - -Werror")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_mmx_inline_asm_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/mmx-inline-asm.c");
    // ${LLVM_SRC}/build/bin/clang -mmmx -target i386-unknown-unknown -emit-llvm -S ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/mmx-inline-asm.c -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/mmx-inline-asm.c
    RUN(TestState.Failed, "%clang -mmmx -target i386-unknown-unknown -emit-llvm -S %s -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_mmx_inline_asm_error_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/mmx-inline-asm-error.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -verify -triple x86_64-unknown-unknown -emit-llvm-only ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/mmx-inline-asm-error.c
    RUN(TestState.Failed, "%clang_cc1 -verify -triple x86_64-unknown-unknown -emit-llvm-only %s");
  }

  @Test
  public void test_mmx_shift_with_immediate_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/mmx-shift-with-immediate.c");
    // ${LLVM_SRC}/build/bin/clang -mmmx -target i386-unknown-unknown -emit-llvm -S ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/mmx-shift-with-immediate.c -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/mmx-shift-with-immediate.c
    RUN(TestState.Failed, "%clang -mmmx -target i386-unknown-unknown -emit-llvm -S %s -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_mozilla_ms_inline_asm_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/mozilla-ms-inline-asm.c");
    // REQUIRES: x86-registered-target
    if (!CHECK_REQUIRES("x86-registered-target")) {
      return;
    }
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/mozilla-ms-inline-asm.c -triple i386-apple-darwin10 -fasm-blocks -emit-llvm -o - | opt -strip -S | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/mozilla-ms-inline-asm.c
    RUN(TestState.Failed, "%clang_cc1 %s -triple i386-apple-darwin10 -fasm-blocks -emit-llvm -o -")./*|*/
      I("opt -strip -S")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_mrtd_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/mrtd.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -mrtd -triple i386-unknown-unknown -std=c89 -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/mrtd.c 2>&1 | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/mrtd.c
    RUN(TestState.Failed, "%clang_cc1 -mrtd -triple i386-unknown-unknown -std=c89 -emit-llvm -o - %s 2>&1")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_ms_align_tentative_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/ms-align-tentative.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i386-pc-win32 -emit-llvm -fms-compatibility -o - < ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/ms-align-tentative.c | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/ms-align-tentative.c
    RUN(TestState.Failed, "%clang_cc1 -triple i386-pc-win32 -emit-llvm -fms-compatibility -o - < %s")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_ms_anonymous_struct_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/ms-anonymous-struct.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fms-extensions -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/ms-anonymous-struct.c | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/ms-anonymous-struct.c
    RUN(TestState.Failed, "%clang_cc1 -fms-extensions -emit-llvm -o - %s")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_ms_declspecs_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/ms-declspecs.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i386-pc-win32 ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/ms-declspecs.c -emit-llvm -fms-compatibility -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/ms-declspecs.c
    RUN(TestState.Failed, "%clang_cc1 -triple i386-pc-win32 %s -emit-llvm -fms-compatibility -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_ms_declspecs_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/ms-declspecs.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i386-pc-win32 ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/ms-declspecs.cpp -emit-llvm -fms-compatibility -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/ms-declspecs.cpp
    RUN(TestState.Failed, "%clang_cc1 -triple i386-pc-win32 %s -emit-llvm -fms-compatibility -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_ms_inline_asm_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/ms-inline-asm.c");
    // REQUIRES: x86-registered-target
    if (!CHECK_REQUIRES("x86-registered-target")) {
      return;
    }
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/ms-inline-asm.c -triple i386-apple-darwin10 -fasm-blocks -emit-llvm -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/ms-inline-asm.c
    RUN(TestState.Failed, "%clang_cc1 %s -triple i386-apple-darwin10 -fasm-blocks -emit-llvm -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_ms_inline_asm_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/ms-inline-asm.cpp");
    // REQUIRES: x86-registered-target
    if (!CHECK_REQUIRES("x86-registered-target")) {
      return;
    }
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x c++ ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/ms-inline-asm.cpp -triple i386-apple-darwin10 -fasm-blocks -emit-llvm -o - -std=c++11 | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/ms-inline-asm.cpp
    RUN(TestState.Failed, "%clang_cc1 -x c++ %s -triple i386-apple-darwin10 -fasm-blocks -emit-llvm -o - -std=c++11")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_ms_inline_asm_64_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/ms-inline-asm-64.c");
    // REQUIRES: x86-registered-target
    if (!CHECK_REQUIRES("x86-registered-target")) {
      return;
    }
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/ms-inline-asm-64.c -triple x86_64-apple-darwin10 -fasm-blocks -emit-llvm -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/ms-inline-asm-64.c
    RUN(TestState.Failed, "%clang_cc1 %s -triple x86_64-apple-darwin10 -fasm-blocks -emit-llvm -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_ms_inline_asm_align_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/ms-inline-asm-align.c");
    // REQUIRES: x86-registered-target
    if (!CHECK_REQUIRES("x86-registered-target")) {
      return;
    }
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/ms-inline-asm-align.c -triple i386-apple-darwin10 -fasm-blocks -emit-llvm -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/ms-inline-asm-align.c --check-prefix=DARWIN
    RUN(TestState.Failed, "%clang_cc1 %s -triple i386-apple-darwin10 -fasm-blocks -emit-llvm -o -")./*|*/
      I("FileCheck %s --check-prefix=DARWIN");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/ms-inline-asm-align.c -triple i686-pc-win32 -fasm-blocks -emit-llvm -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/ms-inline-asm-align.c --check-prefix=WINDOWS
    RUN(TestState.Failed, "%clang_cc1 %s -triple i686-pc-win32 -fasm-blocks -emit-llvm -o -")./*|*/
      I("FileCheck %s --check-prefix=WINDOWS");
  }

  @Test
  public void test_ms_inline_asm_avx512_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/ms-inline-asm-avx512.c");
    // REQUIRES: x86-registered-target
    if (!CHECK_REQUIRES("x86-registered-target")) {
      return;
    }
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/ms-inline-asm-avx512.c -triple x86_64-pc-windows-msvc -target-cpu knl -fasm-blocks -emit-llvm -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/ms-inline-asm-avx512.c
    RUN(TestState.Failed, "%clang_cc1 %s -triple x86_64-pc-windows-msvc -target-cpu knl -fasm-blocks -emit-llvm -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_ms_inline_asm_errors_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/ms-inline-asm-errors.cpp");
    // REQUIRES: x86-registered-target
    if (!CHECK_REQUIRES("x86-registered-target")) {
      return;
    }
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x c++ ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/ms-inline-asm-errors.cpp -triple i386-apple-darwin10 -std=c++11 -fasm-blocks -verify
    RUN(TestState.Failed, "%clang_cc1 -x c++ %s -triple i386-apple-darwin10 -std=c++11 -fasm-blocks -verify");
  }

  @Test
  public void test_ms_inline_asm_functions_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/ms-inline-asm-functions.c");
    // REQUIRES: x86-registered-target
    if (!CHECK_REQUIRES("x86-registered-target")) {
      return;
    }
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/ms-inline-asm-functions.c -triple i386-pc-windows-msvc -fms-extensions -S -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/ms-inline-asm-functions.c
    RUN(TestState.Failed, "%clang_cc1 %s -triple i386-pc-windows-msvc -fms-extensions -S -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_ms_intrinsics_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/ms-intrinsics.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -ffreestanding -fms-extensions -fms-compatibility -fms-compatibility-version=17.00 -triple i686--windows -Oz -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/ms-intrinsics.c -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/ms-intrinsics.c -check-prefix CHECK -check-prefix CHECK-I386
    RUN(TestState.Failed, "%clang_cc1 -ffreestanding -fms-extensions -fms-compatibility -fms-compatibility-version=17.00 -triple i686--windows -Oz -emit-llvm %s -o -")./*|*/
      I("FileCheck %s -check-prefix CHECK -check-prefix CHECK-I386");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -ffreestanding -fms-extensions -fms-compatibility -fms-compatibility-version=17.00 -triple thumbv7--windows -Oz -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/ms-intrinsics.c -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/ms-intrinsics.c
    RUN(TestState.Failed, "%clang_cc1 -ffreestanding -fms-extensions -fms-compatibility -fms-compatibility-version=17.00 -triple thumbv7--windows -Oz -emit-llvm %s -o -")./*|*/
      I("FileCheck %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -ffreestanding -fms-extensions -fms-compatibility -fms-compatibility-version=17.00 -triple x86_64--windows -Oz -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/ms-intrinsics.c -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/ms-intrinsics.c --check-prefix=CHECK --check-prefix=CHECK-X64
    RUN(TestState.Failed, "%clang_cc1 -ffreestanding -fms-extensions -fms-compatibility -fms-compatibility-version=17.00 -triple x86_64--windows -Oz -emit-llvm %s -o -")./*|*/
      I("FileCheck %s --check-prefix=CHECK --check-prefix=CHECK-X64");
  }

  @Test
  public void test_ms_mm_align_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/ms-mm-align.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -ffreestanding -fms-extensions -fms-compatibility -fms-compatibility-version=17.00 -target-feature +sse -triple i686--windows -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/ms-mm-align.c -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/ms-mm-align.c -check-prefix CHECK
    RUN(TestState.Failed, "%clang_cc1 -ffreestanding -fms-extensions -fms-compatibility -fms-compatibility-version=17.00 -target-feature +sse -triple i686--windows -emit-llvm %s -o -")./*|*/
      I("FileCheck %s -check-prefix CHECK");
  }

  @Test
  public void test_ms_setjmp_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/ms-setjmp.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fms-extensions -DDECLARE_SETJMP -triple i686-windows-msvc -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/ms-setjmp.c -o - | ${LLVM_SRC}/build/bin/FileCheck --check-prefix=I386 ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/ms-setjmp.c
    RUN(TestState.Failed, "%clang_cc1 -fms-extensions -DDECLARE_SETJMP -triple i686-windows-msvc   -emit-llvm %s -o -")./*|*/
      I("FileCheck --check-prefix=I386 %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fms-extensions -DDECLARE_SETJMP -triple x86_64-windows-msvc -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/ms-setjmp.c -o - | ${LLVM_SRC}/build/bin/FileCheck --check-prefix=X64 ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/ms-setjmp.c
    RUN(TestState.Failed, "%clang_cc1 -fms-extensions -DDECLARE_SETJMP -triple x86_64-windows-msvc -emit-llvm %s -o -")./*|*/
      I("FileCheck --check-prefix=X64 %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fms-extensions -triple i686-windows-msvc -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/ms-setjmp.c -o - | ${LLVM_SRC}/build/bin/FileCheck --check-prefix=I386 ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/ms-setjmp.c
    RUN(TestState.Failed, "%clang_cc1 -fms-extensions -triple i686-windows-msvc   -emit-llvm %s -o -")./*|*/
      I("FileCheck --check-prefix=I386 %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fms-extensions -triple x86_64-windows-msvc -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/ms-setjmp.c -o - | ${LLVM_SRC}/build/bin/FileCheck --check-prefix=X64 ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/ms-setjmp.c
    RUN(TestState.Failed, "%clang_cc1 -fms-extensions -triple x86_64-windows-msvc -emit-llvm %s -o -")./*|*/
      I("FileCheck --check-prefix=X64 %s");
  }

  @Test
  public void test_ms_volatile_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/ms-volatile.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i386-pc-win32 -fms-extensions -emit-llvm -fms-volatile -o - < ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/ms-volatile.c | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/ms-volatile.c
    RUN(TestState.Failed, "%clang_cc1 -triple i386-pc-win32 -fms-extensions -emit-llvm -fms-volatile -o - < %s")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_ms_abi_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/ms_abi.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-unknown-freebsd10.0 -emit-llvm < ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/ms_abi.c | ${LLVM_SRC}/build/bin/FileCheck -check-prefix=FREEBSD ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/ms_abi.c
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-unknown-freebsd10.0 -emit-llvm < %s")./*|*/
      I("FileCheck -check-prefix=FREEBSD %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-pc-win32 -emit-llvm < ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/ms_abi.c | ${LLVM_SRC}/build/bin/FileCheck -check-prefix=WIN64 ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/ms_abi.c
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-pc-win32 -emit-llvm < %s")./*|*/
      I("FileCheck -check-prefix=WIN64 %s");
  }

  @Test
  public void test_ms_struct_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/ms_struct.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i386-apple-darwin10 -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/ms_struct.c -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/ms_struct.c
    RUN(TestState.Failed, "%clang_cc1 -triple i386-apple-darwin10 -emit-llvm %s -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_ms_struct_bitfield_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/ms_struct-bitfield.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm -o - -triple x86_64-apple-darwin9 ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/ms_struct-bitfield.c | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/ms_struct-bitfield.c
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm -o - -triple x86_64-apple-darwin9 %s")./*|*/
      I("FileCheck %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm -o - -triple thumbv7-apple-ios -target-abi apcs-gnu ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/ms_struct-bitfield.c | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/ms_struct-bitfield.c -check-prefix=CHECK-ARM
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm -o - -triple thumbv7-apple-ios -target-abi apcs-gnu %s")./*|*/
      I("FileCheck %s -check-prefix=CHECK-ARM");
  }

  @Test
  public void test_ms_struct_bitfield_1_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/ms_struct-bitfield-1.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm-only -triple x86_64-apple-darwin9 ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/ms_struct-bitfield-1.c
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm-only  -triple x86_64-apple-darwin9 %s");
  }

  @Test
  public void test_ms_struct_bitfield_2_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/ms_struct-bitfield-2.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm-only -triple x86_64-apple-darwin9 ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/ms_struct-bitfield-2.c
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm-only  -triple x86_64-apple-darwin9 %s");
  }

  @Test
  public void test_ms_struct_bitfield_3_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/ms_struct-bitfield-3.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm-only -triple i386-apple-darwin9 ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/ms_struct-bitfield-3.c
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm-only  -triple i386-apple-darwin9 %s");
  }

  @Test
  public void test_ms_struct_bitfield_init_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/ms_struct-bitfield-init.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm-only -triple x86_64-apple-darwin9 ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/ms_struct-bitfield-init.c
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm-only  -triple x86_64-apple-darwin9 %s");
  }

  @Test
  public void test_ms_struct_pack_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/ms_struct-pack.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm-only -triple i386-apple-darwin9 -fdump-record-layouts ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/ms_struct-pack.c | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/ms_struct-pack.c
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm-only  -triple i386-apple-darwin9 -fdump-record-layouts %s")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_ms_this_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/ms_this.cpp");
    // REQUIRES: x86-registered-target
    if (!CHECK_REQUIRES("x86-registered-target")) {
      return;
    }
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-pc-win32 -fasm-blocks -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/ms_this.cpp -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/ms_this.cpp
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-pc-win32 -fasm-blocks -emit-llvm %s -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_mult_alt_generic_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/mult-alt-generic.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i686 ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/mult-alt-generic.c -emit-llvm -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/mult-alt-generic.c
    RUN(TestState.Failed, "%clang_cc1 -triple i686 %s -emit-llvm -o -")./*|*/
      I("FileCheck %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64 ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/mult-alt-generic.c -emit-llvm -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/mult-alt-generic.c
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64 %s -emit-llvm -o -")./*|*/
      I("FileCheck %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple arm ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/mult-alt-generic.c -emit-llvm -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/mult-alt-generic.c
    RUN(TestState.Failed, "%clang_cc1 -triple arm %s -emit-llvm -o -")./*|*/
      I("FileCheck %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple mips ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/mult-alt-generic.c -emit-llvm -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/mult-alt-generic.c
    RUN(TestState.Failed, "%clang_cc1 -triple mips %s -emit-llvm -o -")./*|*/
      I("FileCheck %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple mipsel ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/mult-alt-generic.c -emit-llvm -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/mult-alt-generic.c
    RUN(TestState.Failed, "%clang_cc1 -triple mipsel %s -emit-llvm -o -")./*|*/
      I("FileCheck %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple powerpc ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/mult-alt-generic.c -emit-llvm -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/mult-alt-generic.c
    RUN(TestState.Failed, "%clang_cc1 -triple powerpc %s -emit-llvm -o -")./*|*/
      I("FileCheck %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple powerpc64 ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/mult-alt-generic.c -emit-llvm -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/mult-alt-generic.c
    RUN(TestState.Failed, "%clang_cc1 -triple powerpc64 %s -emit-llvm -o -")./*|*/
      I("FileCheck %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple s390x ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/mult-alt-generic.c -emit-llvm -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/mult-alt-generic.c
    RUN(TestState.Failed, "%clang_cc1 -triple s390x %s -emit-llvm -o -")./*|*/
      I("FileCheck %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple sparc ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/mult-alt-generic.c -emit-llvm -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/mult-alt-generic.c
    RUN(TestState.Failed, "%clang_cc1 -triple sparc %s -emit-llvm -o -")./*|*/
      I("FileCheck %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple sparcv9 ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/mult-alt-generic.c -emit-llvm -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/mult-alt-generic.c
    RUN(TestState.Failed, "%clang_cc1 -triple sparcv9 %s -emit-llvm -o -")./*|*/
      I("FileCheck %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple thumb ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/mult-alt-generic.c -emit-llvm -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/mult-alt-generic.c
    RUN(TestState.Failed, "%clang_cc1 -triple thumb %s -emit-llvm -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_mult_alt_x86_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/mult-alt-x86.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i686 -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/mult-alt-x86.c -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/mult-alt-x86.c
    RUN(TestState.Failed, "%clang_cc1 -triple i686 -emit-llvm %s -o -")./*|*/
      I("FileCheck %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64 -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/mult-alt-x86.c -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/mult-alt-x86.c
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64 -emit-llvm %s -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_named_reg_global_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/named_reg_global.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-linux-gnu -S -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/named_reg_global.c -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/named_reg_global.c --check-prefix=CHECK --check-prefix=CHECK-X86-64
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-linux-gnu -S -emit-llvm %s -o -")./*|*/
      I("FileCheck %s --check-prefix=CHECK --check-prefix=CHECK-X86-64");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple arm64-linux-gnu -S -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/named_reg_global.c -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/named_reg_global.c --check-prefix=CHECK --check-prefix=CHECK-ARM
    RUN(TestState.Failed, "%clang_cc1 -triple arm64-linux-gnu -S -emit-llvm %s -o -")./*|*/
      I("FileCheck %s --check-prefix=CHECK --check-prefix=CHECK-ARM");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple armv7-linux-gnu -S -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/named_reg_global.c -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/named_reg_global.c --check-prefix=CHECK --check-prefix=CHECK-ARM
    RUN(TestState.Failed, "%clang_cc1 -triple armv7-linux-gnu -S -emit-llvm %s -o -")./*|*/
      I("FileCheck %s --check-prefix=CHECK --check-prefix=CHECK-ARM");
  }

  @Test
  public void test_neon_crypto_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/neon-crypto.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple arm-none-linux-gnueabi -target-feature +neon -target-feature +crypto -target-cpu cortex-a57 -emit-llvm -O1 -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/neon-crypto.c | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/neon-crypto.c
    RUN(TestState.Failed, "%clang_cc1 -triple arm-none-linux-gnueabi -target-feature +neon -target-feature +crypto -target-cpu cortex-a57 -emit-llvm -O1 -o - %s")./*|*/
      I("FileCheck %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple arm64-none-linux-gnu -target-feature +neon -target-feature +crypto -emit-llvm -O1 -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/neon-crypto.c | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/neon-crypto.c
    RUN(TestState.Failed, "%clang_cc1 -triple arm64-none-linux-gnu -target-feature +neon -target-feature +crypto -emit-llvm -O1 -o - %s")./*|*/
      I("FileCheck %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple arm64-none-linux-gnu -target-feature +neon -S -O3 -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/neon-crypto.c 2>&1 | ${LLVM_SRC}/build/bin/FileCheck --check-prefix=CHECK-NO-CRYPTO ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/neon-crypto.c
    RUN(TestState.Failed, "not %clang_cc1 -triple arm64-none-linux-gnu -target-feature +neon -S -O3 -o - %s 2>&1")./*|*/
      I("FileCheck --check-prefix=CHECK-NO-CRYPTO %s");
  }

  @Test
  public void test_neon_immediate_ubsan_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/neon-immediate-ubsan.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple armv7s-linux-gnu -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/neon-immediate-ubsan.c -target-feature +neon -target-cpu cortex-a8 -fsanitize=signed-integer-overflow | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/neon-immediate-ubsan.c --check-prefix=CHECK --check-prefix=ARMV7
    RUN(TestState.Failed, "%clang_cc1 -triple armv7s-linux-gnu -emit-llvm -o - %s -target-feature +neon -target-cpu cortex-a8 -fsanitize=signed-integer-overflow")./*|*/
      I("FileCheck %s --check-prefix=CHECK --check-prefix=ARMV7");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple aarch64-unknown-unknown -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/neon-immediate-ubsan.c -target-feature +neon -target-cpu cortex-a53 -fsanitize=signed-integer-overflow | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/neon-immediate-ubsan.c --check-prefix=CHECK --check-prefix=AARCH64
    RUN(TestState.Failed, "%clang_cc1 -triple aarch64-unknown-unknown -emit-llvm -o - %s -target-feature +neon -target-cpu cortex-a53 -fsanitize=signed-integer-overflow")./*|*/
      I("FileCheck %s --check-prefix=CHECK --check-prefix=AARCH64");
  }

  @Test
  public void test_no_common_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/no-common.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/no-common.c -emit-llvm -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/no-common.c -check-prefix=CHECK-DEFAULT
    RUN(TestState.Failed, "%clang_cc1 %s -emit-llvm -o -")./*|*/
      I("FileCheck %s -check-prefix=CHECK-DEFAULT");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/no-common.c -fno-common -emit-llvm -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/no-common.c -check-prefix=CHECK-NOCOMMON
    RUN(TestState.Failed, "%clang_cc1 %s -fno-common -emit-llvm -o -")./*|*/
      I("FileCheck %s -check-prefix=CHECK-NOCOMMON");
  }

  @Test
  public void test_no_opt_volatile_memcpy_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/no-opt-volatile-memcpy.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple=x86_64-apple-darwin -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/no-opt-volatile-memcpy.c | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/no-opt-volatile-memcpy.c
    RUN(TestState.Failed, "%clang_cc1 -triple=x86_64-apple-darwin  -emit-llvm -o - %s")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_nobuiltin_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/nobuiltin.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fno-builtin -O1 -S -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/nobuiltin.c | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/nobuiltin.c
    RUN(TestState.Failed, "%clang_cc1 -fno-builtin -O1 -S -o - %s")./*|*/
      I("FileCheck %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fno-builtin-memset -O1 -S -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/nobuiltin.c | ${LLVM_SRC}/build/bin/FileCheck -check-prefix=MEMSET ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/nobuiltin.c
    RUN(TestState.Failed, "%clang_cc1 -fno-builtin-memset -O1 -S -o - %s")./*|*/
      I("FileCheck -check-prefix=MEMSET %s");
  }

  @Test
  public void test_noduplicate_cxx11_test_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/noduplicate-cxx11-test.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple=i686-pc-unknown -std=c++11 ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/noduplicate-cxx11-test.cpp -emit-llvm -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/noduplicate-cxx11-test.cpp
    RUN(TestState.Failed, "%clang_cc1 -triple=i686-pc-unknown -std=c++11 %s  -emit-llvm -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_noinline_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/noinline.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -O3 -fno-inline -fno-inline-functions -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/noinline.c -o - | ${LLVM_SRC}/build/bin/FileCheck -check-prefix=NOINLINE ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/noinline.c
    RUN(TestState.Failed, "%clang_cc1 -O3 -fno-inline -fno-inline-functions -emit-llvm %s -o -")./*|*/
      I("FileCheck -check-prefix=NOINLINE %s");
  }

  @Test
  public void test_nomathbuiltin_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/nomathbuiltin.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fno-math-builtin -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/nomathbuiltin.c | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/nomathbuiltin.c
    RUN(TestState.Failed, "%clang_cc1 -fno-math-builtin -emit-llvm -o - %s")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_nonnull_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/nonnull.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-apple-darwin -emit-llvm < ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/nonnull.c | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/nonnull.c
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-apple-darwin -emit-llvm < %s")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_nousejumptable_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/nousejumptable.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -S -fno-jump-tables ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/nousejumptable.c -emit-llvm -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/nousejumptable.c
    RUN(TestState.Failed, "%clang_cc1 -S -fno-jump-tables %s -emit-llvm -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_nvptx_abi_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/nvptx-abi.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple nvptx-unknown-unknown -S -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/nvptx-abi.c -emit-llvm | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/nvptx-abi.c
    RUN(TestState.Failed, "%clang_cc1 -triple nvptx-unknown-unknown -S -o - %s -emit-llvm")./*|*/
      I("FileCheck %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple nvptx64-unknown-unknown -S -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/nvptx-abi.c -emit-llvm | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/nvptx-abi.c
    RUN(TestState.Failed, "%clang_cc1 -triple nvptx64-unknown-unknown -S -o - %s -emit-llvm")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_nvptx_cc_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/nvptx-cc.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple nvptx-unknown-unknown -O3 -S -o ${TEST_TEMP_DIR}/nvptx-cc.c.tmp ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/nvptx-cc.c -emit-llvm
    RUN(TestState.Failed, "%clang_cc1 -triple nvptx-unknown-unknown -O3 -S -o %t %s -emit-llvm");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple nvptx64-unknown-unknown -O3 -S -o ${TEST_TEMP_DIR}/nvptx-cc.c.tmp ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/nvptx-cc.c -emit-llvm
    RUN(TestState.Failed, "%clang_cc1 -triple nvptx64-unknown-unknown -O3 -S -o %t %s -emit-llvm");
  }

  @Test
  public void test_nvptx_cpus_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/nvptx-cpus.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple nvptx-unknown-unknown -target-cpu sm_20 -O3 -S -o ${TEST_TEMP_DIR}/nvptx-cpus.c.tmp ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/nvptx-cpus.c -emit-llvm
    RUN(TestState.Failed, "%clang_cc1 -triple nvptx-unknown-unknown -target-cpu sm_20 -O3 -S -o %t %s -emit-llvm");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple nvptx-unknown-unknown -target-cpu sm_21 -O3 -S -o ${TEST_TEMP_DIR}/nvptx-cpus.c.tmp ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/nvptx-cpus.c -emit-llvm
    RUN(TestState.Failed, "%clang_cc1 -triple nvptx-unknown-unknown -target-cpu sm_21 -O3 -S -o %t %s -emit-llvm");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple nvptx-unknown-unknown -target-cpu sm_30 -O3 -S -o ${TEST_TEMP_DIR}/nvptx-cpus.c.tmp ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/nvptx-cpus.c -emit-llvm
    RUN(TestState.Failed, "%clang_cc1 -triple nvptx-unknown-unknown -target-cpu sm_30 -O3 -S -o %t %s -emit-llvm");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple nvptx-unknown-unknown -target-cpu sm_35 -O3 -S -o ${TEST_TEMP_DIR}/nvptx-cpus.c.tmp ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/nvptx-cpus.c -emit-llvm
    RUN(TestState.Failed, "%clang_cc1 -triple nvptx-unknown-unknown -target-cpu sm_35 -O3 -S -o %t %s -emit-llvm");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple nvptx-unknown-unknown -target-cpu sm_37 -O3 -S -o ${TEST_TEMP_DIR}/nvptx-cpus.c.tmp ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/nvptx-cpus.c -emit-llvm
    RUN(TestState.Failed, "%clang_cc1 -triple nvptx-unknown-unknown -target-cpu sm_37 -O3 -S -o %t %s -emit-llvm");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple nvptx-unknown-unknown -target-cpu sm_50 -O3 -S -o ${TEST_TEMP_DIR}/nvptx-cpus.c.tmp ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/nvptx-cpus.c -emit-llvm
    RUN(TestState.Failed, "%clang_cc1 -triple nvptx-unknown-unknown -target-cpu sm_50 -O3 -S -o %t %s -emit-llvm");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple nvptx-unknown-unknown -target-cpu sm_52 -O3 -S -o ${TEST_TEMP_DIR}/nvptx-cpus.c.tmp ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/nvptx-cpus.c -emit-llvm
    RUN(TestState.Failed, "%clang_cc1 -triple nvptx-unknown-unknown -target-cpu sm_52 -O3 -S -o %t %s -emit-llvm");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple nvptx-unknown-unknown -target-cpu sm_53 -O3 -S -o ${TEST_TEMP_DIR}/nvptx-cpus.c.tmp ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/nvptx-cpus.c -emit-llvm
    RUN(TestState.Failed, "%clang_cc1 -triple nvptx-unknown-unknown -target-cpu sm_53 -O3 -S -o %t %s -emit-llvm");
  }

  @Test
  public void test_nvptx_inlineasm_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/nvptx-inlineasm.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple nvptx-unknown-unknown -O3 -S -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/nvptx-inlineasm.c -emit-llvm | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/nvptx-inlineasm.c
    RUN(TestState.Failed, "%clang_cc1 -triple nvptx-unknown-unknown -O3 -S -o - %s -emit-llvm")./*|*/
      I("FileCheck %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple nvptx64-unknown-unknown -O3 -S -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/nvptx-inlineasm.c -emit-llvm | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/nvptx-inlineasm.c
    RUN(TestState.Failed, "%clang_cc1 -triple nvptx64-unknown-unknown -O3 -S -o - %s -emit-llvm")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_nvptx_inlineasm_ptx_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/nvptx-inlineasm-ptx.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple nvptx-unknown-unknown -O3 -S -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/nvptx-inlineasm-ptx.c -emit-llvm | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/nvptx-inlineasm-ptx.c
    RUN(TestState.Failed, "%clang_cc1 -triple nvptx-unknown-unknown -O3 -S -o - %s -emit-llvm")./*|*/
      I("FileCheck %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple nvptx64-unknown-unknown -O3 -S -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/nvptx-inlineasm-ptx.c -emit-llvm | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/nvptx-inlineasm-ptx.c
    RUN(TestState.Failed, "%clang_cc1 -triple nvptx64-unknown-unknown -O3 -S -o - %s -emit-llvm")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_object_size_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/object-size.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-apple-darwin -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/object-size.c -o - 2>&1 | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/object-size.c
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-apple-darwin -emit-llvm %s -o - 2>&1")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_object_size_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/object-size.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-apple-darwin -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/object-size.cpp | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/object-size.cpp
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-apple-darwin -emit-llvm -o - %s")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_offsetof_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/offsetof.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/offsetof.c -emit-llvm -o ${TEST_TEMP_DIR}/offsetof.c.tmp
    RUN(TestState.Failed, "%clang_cc1 %s -emit-llvm -o %t");
  }

  @Test
  public void test_opaque_pointer_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/opaque-pointer.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/opaque-pointer.c -emit-llvm -o -
    RUN(TestState.Failed, "%clang_cc1 %s -emit-llvm -o -");
  }

  @Test
  public void test_openmp_default_simd_align_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/openmp_default_simd_align.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-unknown-unknown -O1 -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/openmp_default_simd_align.c | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/openmp_default_simd_align.c
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-unknown-unknown -O1 -emit-llvm -o - %s")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_overloadable_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/overloadable.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i386-pc-solaris2.11 -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/overloadable.c -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/overloadable.c
    RUN(TestState.Failed, "%clang_cc1 -triple %itanium_abi_triple -emit-llvm %s -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_override_layout_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/override-layout.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -w -fdump-record-layouts-simple ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/override-layout.c > ${TEST_TEMP_DIR}/override-layout.c.tmp.layouts
    RUN(TestState.Failed, "%clang_cc1 -w -fdump-record-layouts-simple %s > %t.layouts");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -w -DPACKED= -DALIGNED16= -fdump-record-layouts-simple '-foverride-record-layout=${TEST_TEMP_DIR}/override-layout.c.tmp.layouts' ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/override-layout.c > ${TEST_TEMP_DIR}/override-layout.c.tmp.after
    RUN(TestState.Failed, "%clang_cc1 -w -DPACKED= -DALIGNED16= -fdump-record-layouts-simple -foverride-record-layout=%t.layouts %s > %t.after");
    // diff ${TEST_TEMP_DIR}/override-layout.c.tmp.layouts ${TEST_TEMP_DIR}/override-layout.c.tmp.after
    RUN(TestState.Failed, "diff %t.layouts %t.after");
    // ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/override-layout.c < ${TEST_TEMP_DIR}/override-layout.c.tmp.after
    RUN(TestState.Failed, "FileCheck %s < %t.after");
  }

  @Test
  public void test_packed_arrays_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/packed-arrays.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-unk-unk -emit-llvm -Os -o ${TEST_TEMP_DIR}/packed-arrays.c.tmp ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/packed-arrays.c
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-unk-unk -emit-llvm -Os -o %t %s");
    // ${LLVM_SRC}/build/bin/FileCheck < ${TEST_TEMP_DIR}/packed-arrays.c.tmp ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/packed-arrays.c
    RUN(TestState.Failed, "FileCheck < %t %s");
  }

  @Test
  public void test_packed_nest_unpacked_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/packed-nest-unpacked.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/packed-nest-unpacked.c -triple x86_64-apple-macosx10.7.2 -emit-llvm -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/packed-nest-unpacked.c
    RUN(TestState.Failed, "%clang_cc1 %s -triple x86_64-apple-macosx10.7.2 -emit-llvm -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_packed_structure_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/packed-structure.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64 -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/packed-structure.c | opt -S -strip -o ${TEST_TEMP_DIR}/packed-structure.c.tmp
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64 -emit-llvm -o - %s")./*|*/
      I("opt -S -strip -o %t");
    // ${LLVM_SRC}/build/bin/FileCheck --check-prefix=CHECK-GLOBAL < ${TEST_TEMP_DIR}/packed-structure.c.tmp ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/packed-structure.c
    RUN(TestState.Failed, "FileCheck --check-prefix=CHECK-GLOBAL < %t %s");
    // ${LLVM_SRC}/build/bin/FileCheck --check-prefix=CHECK-FUNCTIONS < ${TEST_TEMP_DIR}/packed-structure.c.tmp ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/packed-structure.c
    RUN(TestState.Failed, "FileCheck --check-prefix=CHECK-FUNCTIONS < %t %s");
  }

  @Test
  public void test_packed_union_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/packed-union.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-apple-darwin10 -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/packed-union.c -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/packed-union.c
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-apple-darwin10 -emit-llvm %s -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_palignr_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/palignr.c");
    // REQUIRES: x86-registered-target
    if (!CHECK_REQUIRES("x86-registered-target")) {
      return;
    }
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/palignr.c -triple=i686-apple-darwin -target-feature +ssse3 -O1 -S -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/palignr.c
    RUN(TestState.Failed, "%clang_cc1 %s -triple=i686-apple-darwin -target-feature +ssse3 -O1 -S -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_parameter_passing_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/parameter-passing.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/parameter-passing.c -triple i386-unknown-unknown -O3 -emit-llvm -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/parameter-passing.c
    RUN(TestState.Failed, "%clang_cc1 %s -triple i386-unknown-unknown -O3 -emit-llvm -o -")./*|*/
      I("FileCheck %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/parameter-passing.c -triple x86_64-unknown-unknown -O3 -emit-llvm -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/parameter-passing.c
    RUN(TestState.Failed, "%clang_cc1 %s -triple x86_64-unknown-unknown -O3 -emit-llvm -o -")./*|*/
      I("FileCheck %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/parameter-passing.c -triple powerpc-unknown-unknown -O3 -emit-llvm -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/parameter-passing.c
    RUN(TestState.Failed, "%clang_cc1 %s -triple powerpc-unknown-unknown -O3 -emit-llvm -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_partial_reinitialization1_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/partial-reinitialization1.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-unknown-unknown ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/partial-reinitialization1.c -emit-llvm -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/partial-reinitialization1.c
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-unknown-unknown %s -emit-llvm -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_partial_reinitialization2_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/partial-reinitialization2.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/partial-reinitialization2.c -triple x86_64-unknown-unknown -emit-llvm -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/partial-reinitialization2.c
    RUN(TestState.Failed, "%clang_cc1 %s -triple x86_64-unknown-unknown -emit-llvm -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_pascal_string_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/pascal-string.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/pascal-string.c -fpascal-strings | grep 05Hello
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm -o - %s -fpascal-strings")./*|*/
      I("grep \"05Hello\"");
  }

  @Test
  public void test_pascal_wchar_string_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/pascal-wchar-string.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/pascal-wchar-string.c -fpascal-strings -fshort-wchar | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/pascal-wchar-string.c
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm -o -  %s -fpascal-strings -fshort-wchar")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_pass_object_size_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/pass-object-size.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-apple-darwin -emit-llvm -O0 ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/pass-object-size.c -o - 2>&1 | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/pass-object-size.c
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-apple-darwin -emit-llvm -O0 %s -o - 2>&1")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_pclmul_builtins_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/pclmul-builtins.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/pclmul-builtins.c -triple=x86_64-apple-darwin -target-feature +pclmul -emit-llvm -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/pclmul-builtins.c
    RUN(TestState.Failed, "%clang_cc1 %s -triple=x86_64-apple-darwin -target-feature +pclmul -emit-llvm -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_pgo_instrumentation_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/pgo-instrumentation.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -O2 -fprofile-instrument=llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/pgo-instrumentation.c -mllvm -debug-pass=Structure -emit-llvm -o - 2>&1 | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/pgo-instrumentation.c -check-prefix=CHECK-PGOGENPASS-INVOKED-INSTR-GEN
    RUN(TestState.Failed, "%clang_cc1 -O2 -fprofile-instrument=llvm %s -mllvm -debug-pass=Structure -emit-llvm -o - 2>&1")./*|*/
      I("FileCheck %s -check-prefix=CHECK-PGOGENPASS-INVOKED-INSTR-GEN");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -O2 -fprofile-instrument=clang ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/pgo-instrumentation.c -mllvm -debug-pass=Structure -emit-llvm -o - 2>&1 | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/pgo-instrumentation.c -check-prefix=CHECK-PGOGENPASS-INVOKED-INSTR-GEN-CLANG
    RUN(TestState.Failed, "%clang_cc1 -O2 -fprofile-instrument=clang %s -mllvm -debug-pass=Structure -emit-llvm -o - 2>&1")./*|*/
      I("FileCheck %s -check-prefix=CHECK-PGOGENPASS-INVOKED-INSTR-GEN-CLANG");
    // llvm-profdata merge -o ${TEST_TEMP_DIR}/pgo-instrumentation.c.tmp.profdata ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/Inputs/pgotestir.profraw
    RUN(TestState.Failed, "llvm-profdata merge -o %t.profdata %S/Inputs/pgotestir.profraw");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -O2 '-fprofile-instrument-use-path=${TEST_TEMP_DIR}/pgo-instrumentation.c.tmp.profdata' ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/pgo-instrumentation.c -mllvm -debug-pass=Structure -emit-llvm -o - 2>&1 | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/pgo-instrumentation.c -check-prefix=CHECK-PGOUSEPASS-INVOKED-INSTR-USE
    RUN(TestState.Failed, "%clang_cc1 -O2 -fprofile-instrument-use-path=%t.profdata %s -mllvm -debug-pass=Structure -emit-llvm -o - 2>&1")./*|*/
      I("FileCheck %s -check-prefix=CHECK-PGOUSEPASS-INVOKED-INSTR-USE");
    // llvm-profdata merge -o ${TEST_TEMP_DIR}/pgo-instrumentation.c.tmp.profdata ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/Inputs/pgotestclang.profraw
    RUN(TestState.Failed, "llvm-profdata merge -o %t.profdata %S/Inputs/pgotestclang.profraw");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -O2 '-fprofile-instrument-use-path=${TEST_TEMP_DIR}/pgo-instrumentation.c.tmp.profdata' ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/pgo-instrumentation.c -mllvm -debug-pass=Structure -emit-llvm -o - 2>&1 | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/pgo-instrumentation.c -check-prefix=CHECK-PGOUSEPASS-INVOKED-USE-CLANG
    RUN(TestState.Failed, "%clang_cc1 -O2 -fprofile-instrument-use-path=%t.profdata %s -mllvm -debug-pass=Structure -emit-llvm -o - 2>&1")./*|*/
      I("FileCheck %s -check-prefix=CHECK-PGOUSEPASS-INVOKED-USE-CLANG");
  }

  @Test
  public void test_pgo_sample_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/pgo-sample.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -O2 '-fprofile-sample-use=${LLVM_SRC}/llvm/tools/clang/test/CodeGen/Inputs/pgo-sample.prof' ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/pgo-sample.c -mllvm -debug-pass=Structure -emit-llvm -o - 2>&1 | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/pgo-sample.c
    RUN(TestState.Failed, "%clang_cc1 -O2 -fprofile-sample-use=%S/Inputs/pgo-sample.prof %s -mllvm -debug-pass=Structure -emit-llvm -o - 2>&1")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_pgo_sample_preparation_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/pgo-sample-preparation.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -O2 '-fprofile-sample-use=${LLVM_SRC}/llvm/tools/clang/test/CodeGen/Inputs/pgo-sample.prof' ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/pgo-sample-preparation.c -emit-llvm -o - 2>&1 | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/pgo-sample-preparation.c
    RUN(TestState.Failed, "%clang_cc1 -O2 -fprofile-sample-use=%S/Inputs/pgo-sample.prof %s -emit-llvm -o - 2>&1")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_piclevels_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/piclevels.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm -pic-level 2 ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/piclevels.c -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/piclevels.c -check-prefix=CHECK-BIGPIC
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm -pic-level 2 %s -o -")./*|*/
      I("FileCheck %s -check-prefix=CHECK-BIGPIC");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm -pic-level 1 ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/piclevels.c -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/piclevels.c -check-prefix=CHECK-SMALLPIC
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm -pic-level 1 %s -o -")./*|*/
      I("FileCheck %s -check-prefix=CHECK-SMALLPIC");
  }

  @Test
  public void test_pku_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/pku.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/pku.c -triple=x86_64-apple-darwin -target-feature +pku -emit-llvm -o - -Werror | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/pku.c
    RUN(TestState.Failed, "%clang_cc1 %s -triple=x86_64-apple-darwin -target-feature +pku -emit-llvm -o - -Werror")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_pointer_arithmetic_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/pointer-arithmetic.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -S ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/pointer-arithmetic.c -o -
    RUN(TestState.Failed, "%clang_cc1 -S %s -o -");
  }

  @Test
  public void test_pointer_cmp_type_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/pointer-cmp-type.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/pointer-cmp-type.c -o - | grep 'icmp ult'
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm %s -o -")./*|*/
      I("grep \"icmp ult\"");
  }

  @Test
  public void test_pointer_signext_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/pointer-signext.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-pc-win32 -emit-llvm -O2 -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/pointer-signext.c | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/pointer-signext.c
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-pc-win32 -emit-llvm -O2 -o - %s")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_pointer_to_int_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/pointer-to-int.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/pointer-to-int.c -o -
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm %s -o -");
  }

  @Test
  public void test_popcnt_builtins_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/popcnt-builtins.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/popcnt-builtins.c -triple=x86_64-apple-darwin -target-feature +popcnt -emit-llvm -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/popcnt-builtins.c
    RUN(TestState.Failed, "%clang_cc1 %s -triple=x86_64-apple-darwin -target-feature +popcnt -emit-llvm -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_powerpc_types_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/powerpc_types.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple powerpc-unknown-freebsd -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/powerpc_types.c| ${LLVM_SRC}/build/bin/FileCheck -check-prefix=SVR4-CHECK ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/powerpc_types.c
    RUN(TestState.Failed, "%clang_cc1 -triple powerpc-unknown-freebsd -emit-llvm -o - %s")./*|*/
      I("FileCheck -check-prefix=SVR4-CHECK %s");
  }

  @Test
  public void test_ppc_sfvarargs_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/ppc-sfvarargs.c");
    // ${LLVM_SRC}/build/bin/clang -O0 --target=powerpc-unknown-linux-gnu -EB -msoft-float -S -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/ppc-sfvarargs.c -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/ppc-sfvarargs.c
    RUN(TestState.Failed, "%clang -O0 --target=powerpc-unknown-linux-gnu -EB -msoft-float -S -emit-llvm %s -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_ppc_signbit_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/ppc-signbit.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/ppc-signbit.c -emit-llvm -o - -triple powerpc64-linux-gnu | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/ppc-signbit.c
    RUN(TestState.Failed, "%clang_cc1 %s -emit-llvm -o - -triple powerpc64-linux-gnu")./*|*/
      I("FileCheck %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/ppc-signbit.c -emit-llvm -o - -triple powerpc64le-linux-gnu | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/ppc-signbit.c
    RUN(TestState.Failed, "%clang_cc1 %s -emit-llvm -o - -triple powerpc64le-linux-gnu")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_ppc_varargs_struct_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/ppc-varargs-struct.c");
    // REQUIRES: powerpc-registered-target
    if (!CHECK_REQUIRES("powerpc-registered-target")) {
      return;
    }
    // REQUIRES: asserts
    if (!CHECK_REQUIRES("asserts")) {
      return;
    }
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple powerpc64-unknown-linux-gnu -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/ppc-varargs-struct.c | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/ppc-varargs-struct.c
    RUN(TestState.Failed, "%clang_cc1 -triple powerpc64-unknown-linux-gnu -emit-llvm -o - %s")./*|*/
      I("FileCheck %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple powerpc-unknown-linux-gnu -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/ppc-varargs-struct.c | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/ppc-varargs-struct.c --check-prefix=CHECK-PPC
    RUN(TestState.Failed, "%clang_cc1 -triple powerpc-unknown-linux-gnu -emit-llvm -o - %s")./*|*/
      I("FileCheck %s --check-prefix=CHECK-PPC");
  }

  @Test
  public void test_ppc64_align_long_double_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/ppc64-align-long-double.c");
    // REQUIRES: powerpc-registered-target
    if (!CHECK_REQUIRES("powerpc-registered-target")) {
      return;
    }
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple powerpc64-unknown-linux-gnu -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/ppc64-align-long-double.c | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/ppc64-align-long-double.c
    RUN(TestState.Failed, "%clang_cc1 -triple powerpc64-unknown-linux-gnu -emit-llvm -o - %s")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_ppc64_align_struct_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/ppc64-align-struct.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -faltivec -triple powerpc64-unknown-linux-gnu -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/ppc64-align-struct.c | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/ppc64-align-struct.c
    RUN(TestState.Failed, "%clang_cc1 -faltivec -triple powerpc64-unknown-linux-gnu -emit-llvm -o - %s")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_ppc64_complex_parms_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/ppc64-complex-parms.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple powerpc64-unknown-linux-gnu -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/ppc64-complex-parms.c | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/ppc64-complex-parms.c
    RUN(TestState.Failed, "%clang_cc1 -triple powerpc64-unknown-linux-gnu -emit-llvm -o - %s")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_ppc64_complex_return_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/ppc64-complex-return.c");
    // REQUIRES: powerpc-registered-target
    if (!CHECK_REQUIRES("powerpc-registered-target")) {
      return;
    }
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple powerpc64-unknown-linux-gnu -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/ppc64-complex-return.c | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/ppc64-complex-return.c
    RUN(TestState.Failed, "%clang_cc1 -triple powerpc64-unknown-linux-gnu -emit-llvm -o - %s")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_ppc64_elf_abi_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/ppc64-elf-abi.c");
    // REQUIRES: powerpc-registered-target
    if (!CHECK_REQUIRES("powerpc-registered-target")) {
      return;
    }
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple powerpc64-unknown-linux-gnu -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/ppc64-elf-abi.c | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/ppc64-elf-abi.c --check-prefix=CHECK-ELFv1
    RUN(TestState.Failed, "%clang_cc1 -triple powerpc64-unknown-linux-gnu -emit-llvm -o - %s")./*|*/
      I("FileCheck %s --check-prefix=CHECK-ELFv1");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple powerpc64-unknown-linux-gnu -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/ppc64-elf-abi.c -target-abi elfv1 | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/ppc64-elf-abi.c --check-prefix=CHECK-ELFv1
    RUN(TestState.Failed, "%clang_cc1 -triple powerpc64-unknown-linux-gnu -emit-llvm -o - %s -target-abi elfv1")./*|*/
      I("FileCheck %s --check-prefix=CHECK-ELFv1");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple powerpc64-unknown-linux-gnu -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/ppc64-elf-abi.c -target-abi elfv1-qpx | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/ppc64-elf-abi.c --check-prefix=CHECK-ELFv1
    RUN(TestState.Failed, "%clang_cc1 -triple powerpc64-unknown-linux-gnu -emit-llvm -o - %s -target-abi elfv1-qpx")./*|*/
      I("FileCheck %s --check-prefix=CHECK-ELFv1");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple powerpc64-unknown-linux-gnu -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/ppc64-elf-abi.c -target-abi elfv2 | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/ppc64-elf-abi.c --check-prefix=CHECK-ELFv2
    RUN(TestState.Failed, "%clang_cc1 -triple powerpc64-unknown-linux-gnu -emit-llvm -o - %s -target-abi elfv2")./*|*/
      I("FileCheck %s --check-prefix=CHECK-ELFv2");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple powerpc64le-unknown-linux-gnu -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/ppc64-elf-abi.c | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/ppc64-elf-abi.c --check-prefix=CHECK-ELFv2
    RUN(TestState.Failed, "%clang_cc1 -triple powerpc64le-unknown-linux-gnu -emit-llvm -o - %s")./*|*/
      I("FileCheck %s --check-prefix=CHECK-ELFv2");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple powerpc64le-unknown-linux-gnu -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/ppc64-elf-abi.c -target-abi elfv1 | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/ppc64-elf-abi.c --check-prefix=CHECK-ELFv1
    RUN(TestState.Failed, "%clang_cc1 -triple powerpc64le-unknown-linux-gnu -emit-llvm -o - %s -target-abi elfv1")./*|*/
      I("FileCheck %s --check-prefix=CHECK-ELFv1");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple powerpc64le-unknown-linux-gnu -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/ppc64-elf-abi.c -target-abi elfv2 | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/ppc64-elf-abi.c --check-prefix=CHECK-ELFv2
    RUN(TestState.Failed, "%clang_cc1 -triple powerpc64le-unknown-linux-gnu -emit-llvm -o - %s -target-abi elfv2")./*|*/
      I("FileCheck %s --check-prefix=CHECK-ELFv2");
  }

  @Test
  public void test_ppc64_extend_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/ppc64-extend.c");
    // REQUIRES: powerpc-registered-target
    if (!CHECK_REQUIRES("powerpc-registered-target")) {
      return;
    }
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple powerpc64-unknown-linux-gnu -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/ppc64-extend.c | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/ppc64-extend.c
    RUN(TestState.Failed, "%clang_cc1 -triple powerpc64-unknown-linux-gnu -emit-llvm -o - %s")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_ppc64_inline_asm_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/ppc64-inline-asm.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple powerpc64-unknown-linux-gnu -O2 -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/ppc64-inline-asm.c | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/ppc64-inline-asm.c
    RUN(TestState.Failed, "%clang_cc1 -triple powerpc64-unknown-linux-gnu -O2 -emit-llvm -o - %s")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_ppc64_qpx_vector_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/ppc64-qpx-vector.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple powerpc64-unknown-linux-gnu -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/ppc64-qpx-vector.c | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/ppc64-qpx-vector.c -check-prefix=ALL -check-prefix=NORMAL
    RUN(TestState.Failed, "%clang_cc1 -triple powerpc64-unknown-linux-gnu -emit-llvm -o - %s")./*|*/
      I("FileCheck %s -check-prefix=ALL -check-prefix=NORMAL");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple powerpc64-unknown-linux-gnu -emit-llvm -o - -target-abi elfv1-qpx ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/ppc64-qpx-vector.c | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/ppc64-qpx-vector.c -check-prefix=ALL -check-prefix=QPX
    RUN(TestState.Failed, "%clang_cc1 -triple powerpc64-unknown-linux-gnu -emit-llvm -o - -target-abi elfv1-qpx %s")./*|*/
      I("FileCheck %s -check-prefix=ALL -check-prefix=QPX");
  }

  @Test
  public void test_ppc64_struct_onefloat_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/ppc64-struct-onefloat.c");
    // REQUIRES: powerpc-registered-target
    if (!CHECK_REQUIRES("powerpc-registered-target")) {
      return;
    }
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple powerpc64-unknown-linux-gnu -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/ppc64-struct-onefloat.c | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/ppc64-struct-onefloat.c
    RUN(TestState.Failed, "%clang_cc1 -triple powerpc64-unknown-linux-gnu -emit-llvm -o - %s")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_ppc64_struct_onevect_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/ppc64-struct-onevect.c");
    // REQUIRES: powerpc-registered-target
    if (!CHECK_REQUIRES("powerpc-registered-target")) {
      return;
    }
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -O2 -triple powerpc64-unknown-linux-gnu -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/ppc64-struct-onevect.c | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/ppc64-struct-onevect.c
    RUN(TestState.Failed, "%clang_cc1 -O2 -triple powerpc64-unknown-linux-gnu -emit-llvm -o - %s")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_ppc64_varargs_complex_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/ppc64-varargs-complex.c");
    // REQUIRES: powerpc-registered-target
    if (!CHECK_REQUIRES("powerpc-registered-target")) {
      return;
    }
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple powerpc64-unknown-linux-gnu -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/ppc64-varargs-complex.c | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/ppc64-varargs-complex.c
    RUN(TestState.Failed, "%clang_cc1 -triple powerpc64-unknown-linux-gnu -emit-llvm -o - %s")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_ppc64_vector_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/ppc64-vector.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -faltivec -triple powerpc64-unknown-linux-gnu -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/ppc64-vector.c | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/ppc64-vector.c
    RUN(TestState.Failed, "%clang_cc1 -faltivec -triple powerpc64-unknown-linux-gnu -emit-llvm -o - %s")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_ppc64le_aggregates_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/ppc64le-aggregates.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -faltivec -triple powerpc64le-unknown-linux-gnu -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/ppc64le-aggregates.c | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/ppc64le-aggregates.c
    RUN(TestState.Failed, "%clang_cc1 -faltivec -triple powerpc64le-unknown-linux-gnu -emit-llvm -o - %s")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_ppc64le_varargs_complex_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/ppc64le-varargs-complex.c");
    // REQUIRES: powerpc-registered-target
    if (!CHECK_REQUIRES("powerpc-registered-target")) {
      return;
    }
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple powerpc64le-unknown-linux-gnu -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/ppc64le-varargs-complex.c | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/ppc64le-varargs-complex.c
    RUN(TestState.Failed, "%clang_cc1 -triple powerpc64le-unknown-linux-gnu -emit-llvm -o - %s")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_pr12251_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/pr12251.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-apple-darwin ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/pr12251.c -emit-llvm -O1 -relaxed-aliasing -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/pr12251.c
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-apple-darwin %s -emit-llvm -O1 -relaxed-aliasing -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_pr13168_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/pr13168.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/pr13168.c -o -
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm %s -o -");
  }

  @Test
  public void test_pr18235_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/pr18235.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple le32-unknown-nacl ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/pr18235.c -S -o - 2>&1 | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/pr18235.c
    RUN(TestState.Failed, "not %clang_cc1 -triple le32-unknown-nacl %s -S -o - 2>&1")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_pr19841_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/pr19841.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/pr19841.cpp -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/pr19841.cpp
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm %s -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_pr2394_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/pr2394.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/pr2394.c -triple i386-apple-darwin10 -emit-llvm -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/pr2394.c
    RUN(TestState.Failed, "%clang_cc1 %s -triple i386-apple-darwin10 -emit-llvm -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_pr25786_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/pr25786.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-unknown-linux-gnu -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/pr25786.c | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/pr25786.c
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-unknown-linux-gnu -emit-llvm -o - %s")./*|*/
      I("FileCheck %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i686-unknown-linux-gnu -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/pr25786.c | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/pr25786.c --check-prefix=CHECK-OK
    RUN(TestState.Failed, "%clang_cc1 -triple i686-unknown-linux-gnu -emit-llvm -o - %s")./*|*/
      I("FileCheck %s --check-prefix=CHECK-OK");
  }

  @Test
  public void test_pr27892_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/pr27892.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-linux-gnu -fms-extensions ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/pr27892.c -emit-llvm -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/pr27892.c
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-linux-gnu -fms-extensions %s -emit-llvm -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_pr3518_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/pr3518.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/pr3518.c -emit-llvm -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/pr3518.c
    RUN(TestState.Failed, "%clang_cc1 %s -emit-llvm -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_pr4349_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/pr4349.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/pr4349.c -emit-llvm -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/pr4349.c
    RUN(TestState.Failed, "%clang_cc1 %s -emit-llvm -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_pr5406_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/pr5406.c");
    // REQUIRES: arm-registered-target
    if (!CHECK_REQUIRES("arm-registered-target")) {
      return;
    }
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/pr5406.c -emit-llvm -triple arm-apple-darwin -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/pr5406.c
    RUN(TestState.Failed, "%clang_cc1 %s -emit-llvm -triple arm-apple-darwin -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_pr9614_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/pr9614.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-pc-linux -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/pr9614.c -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/pr9614.c
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-pc-linux -emit-llvm %s -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_pragma_comment_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/pragma-comment.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/pragma-comment.c -triple i686-pc-win32 -fms-extensions -emit-llvm -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/pragma-comment.c
    RUN(TestState.Failed, "%clang_cc1 %s -triple i686-pc-win32 -fms-extensions -emit-llvm -o -")./*|*/
      I("FileCheck %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/pragma-comment.c -triple thumbv7-windows -fms-extensions -emit-llvm -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/pragma-comment.c
    RUN(TestState.Failed, "%clang_cc1 %s -triple thumbv7-windows -fms-extensions -emit-llvm -o -")./*|*/
      I("FileCheck %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/pragma-comment.c -triple x86_64-pc-win32 -fms-extensions -emit-llvm -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/pragma-comment.c
    RUN(TestState.Failed, "%clang_cc1 %s -triple x86_64-pc-win32 -fms-extensions -emit-llvm -o -")./*|*/
      I("FileCheck %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/pragma-comment.c -triple thumbv7-linux-gnueabihf -fms-extensions -emit-llvm -o - | ${LLVM_SRC}/build/bin/FileCheck -check-prefix LINUX ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/pragma-comment.c
    RUN(TestState.Failed, "%clang_cc1 %s -triple thumbv7-linux-gnueabihf -fms-extensions -emit-llvm -o -")./*|*/
      I("FileCheck -check-prefix LINUX %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/pragma-comment.c -triple i686-pc-linux -fms-extensions -emit-llvm -o - | ${LLVM_SRC}/build/bin/FileCheck -check-prefix LINUX ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/pragma-comment.c
    RUN(TestState.Failed, "%clang_cc1 %s -triple i686-pc-linux -fms-extensions -emit-llvm -o -")./*|*/
      I("FileCheck -check-prefix LINUX %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/pragma-comment.c -triple x86_64-scei-ps4 -fms-extensions -emit-llvm -o - | ${LLVM_SRC}/build/bin/FileCheck -check-prefix PS4 ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/pragma-comment.c
    RUN(TestState.Failed, "%clang_cc1 %s -triple x86_64-scei-ps4 -fms-extensions -emit-llvm -o -")./*|*/
      I("FileCheck -check-prefix PS4 %s");
  }

  @Test
  public void test_pragma_detect_mismatch_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/pragma-detect_mismatch.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/pragma-detect_mismatch.c -triple i686-pc-win32 -fms-extensions -emit-llvm -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/pragma-detect_mismatch.c
    RUN(TestState.Failed, "%clang_cc1 %s -triple i686-pc-win32 -fms-extensions -emit-llvm -o -")./*|*/
      I("FileCheck %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/pragma-detect_mismatch.c -triple thumbv7-windows -fms-extensions -emit-llvm -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/pragma-detect_mismatch.c
    RUN(TestState.Failed, "%clang_cc1 %s -triple thumbv7-windows -fms-extensions -emit-llvm -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_pragma_pack_1_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/pragma-pack-1.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-apple-macosx10.7.0 -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/pragma-pack-1.c | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/pragma-pack-1.c
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-apple-macosx10.7.0 -emit-llvm -o - %s")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_pragma_pack_2_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/pragma-pack-2.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i386-apple-darwin9 ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/pragma-pack-2.c -emit-llvm -o - | ${LLVM_SRC}/build/bin/FileCheck -check-prefix CHECK-X32 ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/pragma-pack-2.c
    RUN(TestState.Failed, "%clang_cc1 -triple i386-apple-darwin9 %s -emit-llvm -o -")./*|*/
      I("FileCheck -check-prefix CHECK-X32 %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-apple-darwin9 ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/pragma-pack-2.c -emit-llvm -o - | ${LLVM_SRC}/build/bin/FileCheck -check-prefix CHECK-X64 ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/pragma-pack-2.c
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-apple-darwin9 %s -emit-llvm -o -")./*|*/
      I("FileCheck -check-prefix CHECK-X64 %s");
  }

  @Test
  public void test_pragma_pack_3_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/pragma-pack-3.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i386-apple-darwin9 ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/pragma-pack-3.c -emit-llvm -o - | ${LLVM_SRC}/build/bin/FileCheck -check-prefix CHECK-X32 ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/pragma-pack-3.c
    RUN(TestState.Failed, "%clang_cc1 -triple i386-apple-darwin9 %s -emit-llvm -o -")./*|*/
      I("FileCheck -check-prefix CHECK-X32 %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-apple-darwin9 ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/pragma-pack-3.c -emit-llvm -o - | ${LLVM_SRC}/build/bin/FileCheck -check-prefix CHECK-X64 ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/pragma-pack-3.c
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-apple-darwin9 %s -emit-llvm -o -")./*|*/
      I("FileCheck -check-prefix CHECK-X64 %s");
  }

  @Test
  public void test_pragma_visibility_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/pragma-visibility.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-apple-darwin -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/pragma-visibility.c | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/pragma-visibility.c
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-apple-darwin -emit-llvm -o - %s")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_pragma_weak_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/pragma-weak.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-pc-linux-gnu -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/pragma-weak.c -o - -verify | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/pragma-weak.c
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-pc-linux-gnu -emit-llvm %s -o - -verify")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_predefined_expr_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/predefined-expr.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/predefined-expr.c -triple i386-pc-solaris2.11 -emit-llvm -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/predefined-expr.c
    RUN(TestState.Failed, "%clang_cc1 %s -triple %itanium_abi_triple -emit-llvm -o -")./*|*/
      I("FileCheck %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fms-extensions ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/predefined-expr.c -triple i386-pc-solaris2.11 -emit-llvm -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/predefined-expr.c
    RUN(TestState.Failed, "%clang_cc1 -fms-extensions %s -triple %itanium_abi_triple -emit-llvm -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_prefetchw_builtins_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/prefetchw-builtins.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-unknown-unknown -target-feature +prfchw -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/prefetchw-builtins.c | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/prefetchw-builtins.c
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-unknown-unknown -target-feature +prfchw -emit-llvm -o - %s")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_preserve_call_conv_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/preserve-call-conv.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-unknown-unknown -emit-llvm < ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/preserve-call-conv.c | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/preserve-call-conv.c
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-unknown-unknown -emit-llvm < %s")./*|*/
      I("FileCheck %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple arm64-unknown-unknown -emit-llvm < ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/preserve-call-conv.c | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/preserve-call-conv.c
    RUN(TestState.Failed, "%clang_cc1 -triple arm64-unknown-unknown -emit-llvm < %s")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_private_extern_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/private-extern.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/private-extern.c | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/private-extern.c
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm -o - %s")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_private_extern_redef_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/private-extern-redef.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-darwin-apple -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/private-extern-redef.c | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/private-extern-redef.c
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-darwin-apple -emit-llvm -o - %s")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_rd_builtins_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/rd-builtins.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-unknown-unknown -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/rd-builtins.c | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/rd-builtins.c
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-unknown-unknown -emit-llvm -o - %s")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_rdrand_builtins_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/rdrand-builtins.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-unknown-unknown -target-feature +rdrnd -target-feature +rdseed -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/rdrand-builtins.c | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/rdrand-builtins.c
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-unknown-unknown -target-feature +rdrnd -target-feature +rdseed -emit-llvm -o - %s")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_redef_ext_inline_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/redef-ext-inline.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/redef-ext-inline.c -o - -std=gnu89
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm %s -o - -std=gnu89");
  }

  @Test
  public void test_redefine_extname_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/redefine_extname.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple=i386-pc-solaris2.11 -w -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/redefine_extname.c -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/redefine_extname.c
    RUN(TestState.Failed, "%clang_cc1 -triple=i386-pc-solaris2.11 -w -emit-llvm %s -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_regparm_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/regparm.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i386-unknown-unknown ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/regparm.c -emit-llvm -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/regparm.c
    RUN(TestState.Failed, "%clang_cc1 -triple i386-unknown-unknown %s -emit-llvm -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_regparm_flag_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/regparm-flag.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i386-unknown-unknown -mregparm 4 ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/regparm-flag.c -emit-llvm -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/regparm-flag.c
    RUN(TestState.Failed, "%clang_cc1 -triple i386-unknown-unknown -mregparm 4 %s -emit-llvm -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_regparm_struct_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/regparm-struct.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i386-unknown-unknown ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/regparm-struct.c -emit-llvm -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/regparm-struct.c
    RUN(TestState.Failed, "%clang_cc1 -triple i386-unknown-unknown %s -emit-llvm -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_relax_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/relax.c");
    // REQUIRES: x86-registered-target
    if (!CHECK_REQUIRES("x86-registered-target")) {
      return;
    }
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-pc-linux-gnu -emit-obj --mrelax-relocations ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/relax.c -mrelocation-model pic -o ${TEST_TEMP_DIR}/relax.c.tmp
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-pc-linux-gnu -emit-obj --mrelax-relocations %s -mrelocation-model pic -o %t");
    // llvm-readobj -r ${TEST_TEMP_DIR}/relax.c.tmp | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/relax.c
    RUN(TestState.Failed, "llvm-readobj -r %t")./*|*/
      I("FileCheck  %s");
  }

  @Test
  public void test_renderscript_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/renderscript.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/renderscript.c -triple=renderscript32-none-linux-gnueabi -emit-llvm -o - -Werror | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/renderscript.c -check-prefix=CHECK-RS32
    RUN(TestState.Failed, "%clang_cc1 %s -triple=renderscript32-none-linux-gnueabi -emit-llvm -o - -Werror")./*|*/
      I("FileCheck %s -check-prefix=CHECK-RS32");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/renderscript.c -triple=renderscript64-none-linux-android -emit-llvm -o - -Werror | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/renderscript.c -check-prefix=CHECK-RS64
    RUN(TestState.Failed, "%clang_cc1 %s -triple=renderscript64-none-linux-android -emit-llvm -o - -Werror")./*|*/
      I("FileCheck %s -check-prefix=CHECK-RS64");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/renderscript.c -triple=armv7-none-linux-gnueabi -emit-llvm -o - -Werror | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/renderscript.c -check-prefix=CHECK-ARM
    RUN(TestState.Failed, "%clang_cc1 %s -triple=armv7-none-linux-gnueabi -emit-llvm -o - -Werror")./*|*/
      I("FileCheck %s -check-prefix=CHECK-ARM");
  }

  @Test
  public void test_restrict_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/restrict.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-darwin-apple -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/restrict.c -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/restrict.c
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-darwin-apple -emit-llvm %s -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_rtm_builtins_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/rtm-builtins.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/rtm-builtins.c -triple=x86_64-apple-darwin -target-feature +rtm -emit-llvm -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/rtm-builtins.c
    RUN(TestState.Failed, "%clang_cc1 %s -triple=x86_64-apple-darwin -target-feature +rtm -emit-llvm -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_safestack_attr_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/safestack-attr.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-linux-unknown -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/safestack-attr.cpp -fsanitize=safe-stack | ${LLVM_SRC}/build/bin/FileCheck -check-prefix=SP ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/safestack-attr.cpp
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-linux-unknown -emit-llvm -o - %s -fsanitize=safe-stack")./*|*/
      I("FileCheck -check-prefix=SP %s");
  }

  @Test
  public void test_sanitize_address_field_padding_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/sanitize-address-field-padding.cpp");
    // echo type:SomeNamespace::BlacklistedByName=field-padding > ${TEST_TEMP_DIR}/sanitize-address-field-padding.cpp.tmp.type.blacklist
    RUN(TestState.Failed, "echo 'type:SomeNamespace::BlacklistedByName=field-padding' > %t.type.blacklist");
    // echo src:*sanitize-address-field-padding.cpp=field-padding > ${TEST_TEMP_DIR}/sanitize-address-field-padding.cpp.tmp.file.blacklist
    RUN(TestState.Failed, "echo 'src:*sanitize-address-field-padding.cpp=field-padding' > %t.file.blacklist");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-unknown-unknown -fsanitize=address -fsanitize-address-field-padding=1 '-fsanitize-blacklist=${TEST_TEMP_DIR}/sanitize-address-field-padding.cpp.tmp.type.blacklist' -Rsanitize-address -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/sanitize-address-field-padding.cpp 2>&1 | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/sanitize-address-field-padding.cpp
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-unknown-unknown -fsanitize=address -fsanitize-address-field-padding=1 -fsanitize-blacklist=%t.type.blacklist -Rsanitize-address -emit-llvm -o - %s 2>&1")./*|*/
      I("FileCheck %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-unknown-unknown -fsanitize=address -fsanitize-address-field-padding=1 '-fsanitize-blacklist=${TEST_TEMP_DIR}/sanitize-address-field-padding.cpp.tmp.type.blacklist' -Rsanitize-address -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/sanitize-address-field-padding.cpp -O1 -mconstructor-aliases 2>&1 | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/sanitize-address-field-padding.cpp --check-prefix=WITH_CTOR_ALIASES
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-unknown-unknown -fsanitize=address -fsanitize-address-field-padding=1 -fsanitize-blacklist=%t.type.blacklist -Rsanitize-address -emit-llvm -o - %s -O1 -mconstructor-aliases 2>&1")./*|*/
      I("FileCheck %s --check-prefix=WITH_CTOR_ALIASES");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-unknown-unknown -fsanitize=address -fsanitize-address-field-padding=1 '-fsanitize-blacklist=${TEST_TEMP_DIR}/sanitize-address-field-padding.cpp.tmp.file.blacklist' -Rsanitize-address -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/sanitize-address-field-padding.cpp 2>&1 | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/sanitize-address-field-padding.cpp --check-prefix=FILE_BLACKLIST
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-unknown-unknown -fsanitize=address -fsanitize-address-field-padding=1 -fsanitize-blacklist=%t.file.blacklist -Rsanitize-address -emit-llvm -o - %s 2>&1")./*|*/
      I("FileCheck %s --check-prefix=FILE_BLACKLIST");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsanitize=address -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/sanitize-address-field-padding.cpp 2>&1 | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/sanitize-address-field-padding.cpp --check-prefix=NO_PADDING
    RUN(TestState.Failed, "%clang_cc1 -fsanitize=address -emit-llvm -o - %s 2>&1")./*|*/
      I("FileCheck %s --check-prefix=NO_PADDING");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsanitize=address -emit-llvm -disable-llvm-passes -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/sanitize-address-field-padding.cpp | ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsanitize=address -emit-llvm -o - -x ir | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/sanitize-address-field-padding.cpp --check-prefix=NO_PADDING
    RUN(TestState.Failed, "%clang_cc1 -fsanitize=address -emit-llvm -disable-llvm-passes -o - %s")./*|*/
      I("%clang_cc1 -fsanitize=address -emit-llvm -o - -x ir")./*|*/
      I("FileCheck %s --check-prefix=NO_PADDING");
  }

  @Test
  public void test_sanitize_blocks_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/sanitize-blocks.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsanitize-trap=returns-nonnull-attribute -fsanitize=returns-nonnull-attribute -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/sanitize-blocks.c -o - -triple x86_64-apple-darwin10 -fblocks | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/sanitize-blocks.c
    RUN(TestState.Failed, "%clang_cc1 -fsanitize-trap=returns-nonnull-attribute -fsanitize=returns-nonnull-attribute -emit-llvm %s -o - -triple x86_64-apple-darwin10 -fblocks")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_sanitize_init_order_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/sanitize-init-order.cpp");
    // REQUIRES: shell
    if (!CHECK_REQUIRES("shell")) {
      return;
    }
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsanitize=address -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/sanitize-init-order.cpp | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/sanitize-init-order.cpp
    RUN(TestState.Failed, "%clang_cc1 -fsanitize=address -emit-llvm -o - %s")./*|*/
      I("FileCheck %s");
    // echo 'src:${LLVM_SRC}/llvm/tools/clang/test/CodeGen/sanitize-init-order.cpp=init' > ${TEST_TEMP_DIR}/sanitize-init-order.cpp.tmp-file.blacklist
    RUN(TestState.Failed, "echo \"src:%s=init\" > %t-file.blacklist");
    // echo type:PODWithCtorAndDtor=init > ${TEST_TEMP_DIR}/sanitize-init-order.cpp.tmp-type.blacklist
    RUN(TestState.Failed, "echo \"type:PODWithCtorAndDtor=init\" > %t-type.blacklist");
    // echo type:NS::PODWithCtor=init >> ${TEST_TEMP_DIR}/sanitize-init-order.cpp.tmp-type.blacklist
    RUN(TestState.Failed, "echo \"type:NS::PODWithCtor=init\" >> %t-type.blacklist");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsanitize=address '-fsanitize-blacklist=${TEST_TEMP_DIR}/sanitize-init-order.cpp.tmp-file.blacklist' -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/sanitize-init-order.cpp | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/sanitize-init-order.cpp --check-prefix=BLACKLIST
    RUN(TestState.Failed, "%clang_cc1 -fsanitize=address -fsanitize-blacklist=%t-file.blacklist -emit-llvm -o - %s")./*|*/
      I("FileCheck %s --check-prefix=BLACKLIST");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsanitize=address '-fsanitize-blacklist=${TEST_TEMP_DIR}/sanitize-init-order.cpp.tmp-type.blacklist' -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/sanitize-init-order.cpp | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/sanitize-init-order.cpp --check-prefix=BLACKLIST
    RUN(TestState.Failed, "%clang_cc1 -fsanitize=address -fsanitize-blacklist=%t-type.blacklist -emit-llvm -o - %s")./*|*/
      I("FileCheck %s --check-prefix=BLACKLIST");
  }

  @Test
  public void test_sanitize_recover_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/sanitize-recover.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-apple-darwin10 -fsanitize=unsigned-integer-overflow -fsanitize-recover=unsigned-integer-overflow ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/sanitize-recover.c -emit-llvm -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/sanitize-recover.c --check-prefix=RECOVER
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-apple-darwin10 -fsanitize=unsigned-integer-overflow -fsanitize-recover=unsigned-integer-overflow %s -emit-llvm -o -")./*|*/
      I("FileCheck %s --check-prefix=RECOVER");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-apple-darwin10 -fsanitize=unsigned-integer-overflow ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/sanitize-recover.c -emit-llvm -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/sanitize-recover.c --check-prefix=ABORT
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-apple-darwin10 -fsanitize=unsigned-integer-overflow %s -emit-llvm -o -")./*|*/
      I("FileCheck %s --check-prefix=ABORT");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-apple-darwin10 -fsanitize=null,object-size,alignment -fsanitize-recover=object-size ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/sanitize-recover.c -emit-llvm -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/sanitize-recover.c --check-prefix=PARTIAL
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-apple-darwin10 -fsanitize=null,object-size,alignment -fsanitize-recover=object-size %s -emit-llvm -o -")./*|*/
      I("FileCheck %s --check-prefix=PARTIAL");
  }

  @Test
  public void test_sanitize_thread_attr_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/sanitize-thread-attr.cpp");
    // REQUIRES: shell
    if (!CHECK_REQUIRES("shell")) {
      return;
    }
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-apple-darwin -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/sanitize-thread-attr.cpp | ${LLVM_SRC}/build/bin/FileCheck -check-prefix=WITHOUT ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/sanitize-thread-attr.cpp
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-apple-darwin -emit-llvm -o - %s")./*|*/
      I("FileCheck -check-prefix=WITHOUT %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-apple-darwin -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/sanitize-thread-attr.cpp -fsanitize=thread | ${LLVM_SRC}/build/bin/FileCheck -check-prefix=TSAN ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/sanitize-thread-attr.cpp
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-apple-darwin -emit-llvm -o - %s -fsanitize=thread")./*|*/
      I("FileCheck -check-prefix=TSAN %s");
    // echo 'src:${LLVM_SRC}/llvm/tools/clang/test/CodeGen/sanitize-thread-attr.cpp' > ${TEST_TEMP_DIR}/sanitize-thread-attr.cpp.tmp
    RUN(TestState.Failed, "echo \"src:%s\" > %t");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-apple-darwin -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/sanitize-thread-attr.cpp -fsanitize=thread '-fsanitize-blacklist=${TEST_TEMP_DIR}/sanitize-thread-attr.cpp.tmp' | ${LLVM_SRC}/build/bin/FileCheck -check-prefix=BL ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/sanitize-thread-attr.cpp
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-apple-darwin -emit-llvm -o - %s -fsanitize=thread -fsanitize-blacklist=%t")./*|*/
      I("FileCheck -check-prefix=BL %s");
  }

  @Test
  public void test_sanitize_trap_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/sanitize-trap.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-pc-linux-gnu -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/sanitize-trap.c -fsanitize=signed-integer-overflow,integer-divide-by-zero -fsanitize-trap=integer-divide-by-zero | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/sanitize-trap.c
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-pc-linux-gnu -emit-llvm -o - %s -fsanitize=signed-integer-overflow,integer-divide-by-zero -fsanitize-trap=integer-divide-by-zero")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_sha_builtins_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/sha-builtins.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/sha-builtins.c -triple=x86_64-unknown-unknown -target-feature +sha -emit-llvm -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/sha-builtins.c
    RUN(TestState.Failed, "%clang_cc1 %s -triple=x86_64-unknown-unknown -target-feature +sha -emit-llvm -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_shared_string_literals_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/shared-string-literals.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/shared-string-literals.c -o ${TEST_TEMP_DIR}/shared-string-literals.c.tmp
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm %s -o %t");
  }

  @Test
  public void test_sizeof_vla_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/sizeof-vla.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-unknown-unknown -emit-llvm -o ${TEST_TEMP_DIR}/sizeof-vla.c.tmp ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/sizeof-vla.c
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-unknown-unknown -emit-llvm -o %t %s");
  }

  @Test
  public void test_sparc_arguments_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/sparc-arguments.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple sparc-unknown-unknown -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/sparc-arguments.c | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/sparc-arguments.c
    RUN(TestState.Failed, "%clang_cc1 -triple sparc-unknown-unknown -emit-llvm -o - %s")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_sparc_vaarg_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/sparc-vaarg.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple sparc -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/sparc-vaarg.c | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/sparc-vaarg.c
    RUN(TestState.Failed, "%clang_cc1 -triple sparc -emit-llvm -o - %s")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_sparcv8_abi_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/sparcv8-abi.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple sparc-unknown-unknown -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/sparcv8-abi.c -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/sparcv8-abi.c
    RUN(TestState.Failed, "%clang_cc1 -triple sparc-unknown-unknown -emit-llvm %s -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_sparcv9_abi_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/sparcv9-abi.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple sparcv9-unknown-unknown -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/sparcv9-abi.c -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/sparcv9-abi.c
    RUN(TestState.Failed, "%clang_cc1 -triple sparcv9-unknown-unknown -emit-llvm %s -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_sparcv9_dwarf_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/sparcv9-dwarf.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple sparcv9-unknown-unknown -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/sparcv9-dwarf.c -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/sparcv9-dwarf.c
    RUN(TestState.Failed, "%clang_cc1 -triple sparcv9-unknown-unknown -emit-llvm %s -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_split_debug_filename_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/split-debug-filename.c");
    // ${LLVM_SRC}/build/bin/clang -target x86_64-linux-gnu -gsplit-dwarf -S -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/split-debug-filename.c | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/split-debug-filename.c
    RUN(TestState.Failed, "%clang -target x86_64-linux-gnu -gsplit-dwarf -S -emit-llvm -o - %s")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_split_stacks_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/split-stacks.c");
    // ${LLVM_SRC}/build/bin/clang -target x86_64-linux-gnu -fsplit-stack -S ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/split-stacks.c -emit-llvm -o - | ${LLVM_SRC}/build/bin/FileCheck -check-prefix=CHECK-SEGSTK ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/split-stacks.c
    RUN(TestState.Failed, "%clang -target x86_64-linux-gnu -fsplit-stack -S %s -emit-llvm -o -")./*|*/
      I("FileCheck -check-prefix=CHECK-SEGSTK %s");
    // ${LLVM_SRC}/build/bin/clang -target x86_64-linux-gnu -S ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/split-stacks.c -emit-llvm -o - | ${LLVM_SRC}/build/bin/FileCheck -check-prefix=CHECK-NOSEGSTK ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/split-stacks.c
    RUN(TestState.Failed, "%clang -target x86_64-linux-gnu -S %s -emit-llvm -o -")./*|*/
      I("FileCheck -check-prefix=CHECK-NOSEGSTK %s");
  }

  @Test
  public void test_sret_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/sret.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/sret.c -emit-llvm -o - | grep sret | grep -v sret.c | ${LLVM_SRC}/build/bin/count 4
    RUN(TestState.Failed, "%clang_cc1 %s -emit-llvm -o -")./*|*/
      I("grep sret")./*|*/
      I("grep -v 'sret.c'")./*|*/
      I("count 4");
  }

  @Test
  public void test_sret2_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/sret2.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/sret2.c -emit-llvm -o - | grep sret | grep -v sret2.c | ${LLVM_SRC}/build/bin/count 1
    RUN(TestState.Failed, "%clang_cc1 %s -emit-llvm -o -")./*|*/
      I("grep sret")./*|*/
      I("grep -v 'sret2.c'")./*|*/
      I("count 1");
  }

  @Test
  public void test_sse_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/sse.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -O3 -triple x86_64-apple-macosx10.8.0 -target-feature +sse4.1 -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/sse.c -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/sse.c
    RUN(TestState.Failed, "%clang_cc1 -O3 -triple x86_64-apple-macosx10.8.0 -target-feature +sse4.1 -emit-llvm %s -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_sse_builtins_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/sse-builtins.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/sse-builtins.c -triple=x86_64-apple-darwin -target-feature +sse -emit-llvm -o - -Werror | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/sse-builtins.c
    RUN(TestState.Failed, "%clang_cc1 %s -triple=x86_64-apple-darwin -target-feature +sse -emit-llvm -o - -Werror")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_sse_builtins_dbg_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/sse-builtins-dbg.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -ffreestanding -triple x86_64-apple-macosx10.8.0 -target-feature +sse4.1 -debug-info-kind=limited -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/sse-builtins-dbg.c -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/sse-builtins-dbg.c
    RUN(TestState.Failed, "%clang_cc1 -ffreestanding -triple x86_64-apple-macosx10.8.0 -target-feature +sse4.1 -debug-info-kind=limited -emit-llvm %s -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_sse2_builtins_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/sse2-builtins.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/sse2-builtins.c -triple=x86_64-apple-darwin -target-feature +sse2 -emit-llvm -o - -Werror | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/sse2-builtins.c
    RUN(TestState.Failed, "%clang_cc1 %s -triple=x86_64-apple-darwin -target-feature +sse2 -emit-llvm -o - -Werror")./*|*/
      I("FileCheck %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/sse2-builtins.c -triple=x86_64-apple-darwin -target-feature +sse2 -fno-signed-char -emit-llvm -o - -Werror | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/sse2-builtins.c
    RUN(TestState.Failed, "%clang_cc1 %s -triple=x86_64-apple-darwin -target-feature +sse2 -fno-signed-char -emit-llvm -o - -Werror")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_sse3_builtins_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/sse3-builtins.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/sse3-builtins.c -triple=x86_64-apple-darwin -target-feature +sse3 -emit-llvm -o - -Werror | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/sse3-builtins.c
    RUN(TestState.Failed, "%clang_cc1 %s -triple=x86_64-apple-darwin -target-feature +sse3 -emit-llvm -o - -Werror")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_sse41_builtins_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/sse41-builtins.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/sse41-builtins.c -triple=x86_64-apple-darwin -target-feature +sse4.1 -emit-llvm -o - -Werror | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/sse41-builtins.c
    RUN(TestState.Failed, "%clang_cc1 %s -triple=x86_64-apple-darwin -target-feature +sse4.1 -emit-llvm -o - -Werror")./*|*/
      I("FileCheck %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/sse41-builtins.c -triple=x86_64-apple-darwin -target-feature +sse4.1 -fno-signed-char -emit-llvm -o - -Werror | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/sse41-builtins.c
    RUN(TestState.Failed, "%clang_cc1 %s -triple=x86_64-apple-darwin -target-feature +sse4.1 -fno-signed-char -emit-llvm -o - -Werror")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_sse42_builtins_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/sse42-builtins.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/sse42-builtins.c -triple=x86_64-apple-darwin -target-feature +sse4.2 -emit-llvm -o - -Werror | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/sse42-builtins.c
    RUN(TestState.Failed, "%clang_cc1 %s -triple=x86_64-apple-darwin -target-feature +sse4.2 -emit-llvm -o - -Werror")./*|*/
      I("FileCheck %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/sse42-builtins.c -triple=x86_64-apple-darwin -target-feature +sse4.2 -fno-signed-char -emit-llvm -o - -Werror | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/sse42-builtins.c
    RUN(TestState.Failed, "%clang_cc1 %s -triple=x86_64-apple-darwin -target-feature +sse4.2 -fno-signed-char -emit-llvm -o - -Werror")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_sse4a_builtins_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/sse4a-builtins.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/sse4a-builtins.c -triple=x86_64-apple-darwin -target-feature +sse4a -emit-llvm -o - -Werror | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/sse4a-builtins.c
    RUN(TestState.Failed, "%clang_cc1 %s -triple=x86_64-apple-darwin -target-feature +sse4a -emit-llvm -o - -Werror")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_ssse3_builtins_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/ssse3-builtins.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/ssse3-builtins.c -triple=x86_64-apple-darwin -target-feature +ssse3 -emit-llvm -o - -Werror | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/ssse3-builtins.c
    RUN(TestState.Failed, "%clang_cc1 %s -triple=x86_64-apple-darwin -target-feature +ssse3 -emit-llvm -o - -Werror")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_stack_protector_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/stack-protector.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/stack-protector.c -stack-protector 0 | ${LLVM_SRC}/build/bin/FileCheck -check-prefix=DEF -check-prefix=NOSSP ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/stack-protector.c
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm -o - %s -stack-protector 0")./*|*/
      I("FileCheck -check-prefix=DEF -check-prefix=NOSSP %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/stack-protector.c -stack-protector 1 | ${LLVM_SRC}/build/bin/FileCheck -check-prefix=DEF -check-prefix=SSP ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/stack-protector.c
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm -o - %s -stack-protector 1")./*|*/
      I("FileCheck -check-prefix=DEF -check-prefix=SSP %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/stack-protector.c -stack-protector 2 | ${LLVM_SRC}/build/bin/FileCheck -check-prefix=DEF -check-prefix=SSPSTRONG ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/stack-protector.c
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm -o - %s -stack-protector 2")./*|*/
      I("FileCheck -check-prefix=DEF -check-prefix=SSPSTRONG %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/stack-protector.c -stack-protector 3 | ${LLVM_SRC}/build/bin/FileCheck -check-prefix=DEF -check-prefix=SSPREQ ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/stack-protector.c
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm -o - %s -stack-protector 3")./*|*/
      I("FileCheck -check-prefix=DEF -check-prefix=SSPREQ %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/stack-protector.c -fsanitize=safe-stack | ${LLVM_SRC}/build/bin/FileCheck -check-prefix=DEF -check-prefix=SAFESTACK-NOSSP ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/stack-protector.c
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm -o - %s -fsanitize=safe-stack")./*|*/
      I("FileCheck -check-prefix=DEF -check-prefix=SAFESTACK-NOSSP %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/stack-protector.c -fsanitize=safe-stack -stack-protector 0 | ${LLVM_SRC}/build/bin/FileCheck -check-prefix=DEF -check-prefix=SAFESTACK-NOSSP ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/stack-protector.c
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm -o - %s -fsanitize=safe-stack -stack-protector 0")./*|*/
      I("FileCheck -check-prefix=DEF -check-prefix=SAFESTACK-NOSSP %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/stack-protector.c -fsanitize=safe-stack -stack-protector 1 | ${LLVM_SRC}/build/bin/FileCheck -check-prefix=DEF -check-prefix=SAFESTACK-SSP ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/stack-protector.c
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm -o - %s -fsanitize=safe-stack -stack-protector 1")./*|*/
      I("FileCheck -check-prefix=DEF -check-prefix=SAFESTACK-SSP %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/stack-protector.c -fsanitize=safe-stack -stack-protector 2 | ${LLVM_SRC}/build/bin/FileCheck -check-prefix=DEF -check-prefix=SAFESTACK-SSPSTRONG ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/stack-protector.c
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm -o - %s -fsanitize=safe-stack -stack-protector 2")./*|*/
      I("FileCheck -check-prefix=DEF -check-prefix=SAFESTACK-SSPSTRONG %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/stack-protector.c -fsanitize=safe-stack -stack-protector 3 | ${LLVM_SRC}/build/bin/FileCheck -check-prefix=DEF -check-prefix=SAFESTACK-SSPREQ ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/stack-protector.c
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm -o - %s -fsanitize=safe-stack -stack-protector 3")./*|*/
      I("FileCheck -check-prefix=DEF -check-prefix=SAFESTACK-SSPREQ %s");
  }

  @Test
  public void test_stackrealign_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/stackrealign.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/stackrealign.c -emit-llvm -o - -mstackrealign | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/stackrealign.c -check-prefix=REALIGN
    RUN(TestState.Failed, "%clang_cc1 %s -emit-llvm -o - -mstackrealign")./*|*/
      I("FileCheck %s -check-prefix=REALIGN");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/stackrealign.c -emit-llvm -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/stackrealign.c -check-prefix=NO-REALIGN
    RUN(TestState.Failed, "%clang_cc1 %s -emit-llvm -o -")./*|*/
      I("FileCheck %s -check-prefix=NO-REALIGN");
  }

  @Test
  public void test_statements_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/statements.c");
    // REQUIRES: LP64
    if (!CHECK_REQUIRES("LP64")) {
      return;
    }
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -Wno-error=return-type ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/statements.c -emit-llvm-only
    RUN(TestState.Failed, "%clang_cc1 -Wno-error=return-type %s -emit-llvm-only");
  }

  @Test
  public void test_static_forward_decl_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/static-forward-decl.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/static-forward-decl.c -emit-llvm -o - -triple=i686-apple-darwin9 | grep 'global i32 10'
    RUN(TestState.Failed, "%clang_cc1 %s -emit-llvm -o - -triple=i686-apple-darwin9")./*|*/
      I("grep \"global i32 10\"");
  }

  @Test
  public void test_static_forward_decl_fun_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/static-forward-decl-fun.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/static-forward-decl-fun.c -emit-llvm -o ${TEST_TEMP_DIR}/static-forward-decl-fun.c.tmp
    RUN(TestState.Failed, "%clang_cc1 %s -emit-llvm -o %t");
  }

  @Test
  public void test_static_local_union_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/static-local-union.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm < ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/static-local-union.c
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm < %s");
  }

  @Test
  public void test_static_order_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/static-order.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/static-order.c | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/static-order.c
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm -o - %s")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_staticinit_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/staticinit.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i386-pc-linux-gnu -emit-llvm -o ${TEST_TEMP_DIR}/staticinit.c.tmp ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/staticinit.c
    RUN(TestState.Failed, "%clang_cc1 -triple i386-pc-linux-gnu -emit-llvm -o %t %s");
    // grep 'g.b = internal global i8. getelementptr' ${TEST_TEMP_DIR}/staticinit.c.tmp
    RUN(TestState.Failed, "grep \"g.b = internal global i8. getelementptr\" %t");
    // grep 'f1.l0 = internal global i32 ptrtoint (i32 ()\* @f1 to i32)' ${TEST_TEMP_DIR}/staticinit.c.tmp
    RUN(TestState.Failed, "grep \"f1.l0 = internal global i32 ptrtoint (i32 ()\\* @f1 to i32)\" %t");
  }

  @Test
  public void test_stdcall_fastcall_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/stdcall-fastcall.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i386-unknown-unknown -emit-llvm < ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/stdcall-fastcall.c | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/stdcall-fastcall.c
    RUN(TestState.Failed, "%clang_cc1 -triple i386-unknown-unknown -emit-llvm < %s")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_string_literal_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/string-literal.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i386-unknown-unknown -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/string-literal.c -o - | ${LLVM_SRC}/build/bin/FileCheck -check-prefix=CHECK-C ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/string-literal.c
    RUN(TestState.Failed, "%clang_cc1 -triple i386-unknown-unknown -emit-llvm %s -o -")./*|*/
      I("FileCheck -check-prefix=CHECK-C %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x c++ -triple i386-unknown-unknown -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/string-literal.c -o - | ${LLVM_SRC}/build/bin/FileCheck -check-prefix=CHECK-C ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/string-literal.c
    RUN(TestState.Failed, "%clang_cc1 -x c++ -triple i386-unknown-unknown -emit-llvm %s -o -")./*|*/
      I("FileCheck -check-prefix=CHECK-C %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x c++ -std=c++11 -triple i386-unknown-unknown -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/string-literal.c -o - | ${LLVM_SRC}/build/bin/FileCheck -check-prefix=CHECK-CXX11 ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/string-literal.c
    RUN(TestState.Failed, "%clang_cc1 -x c++ -std=c++11 -triple i386-unknown-unknown -emit-llvm %s -o -")./*|*/
      I("FileCheck -check-prefix=CHECK-CXX11 %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x c -std=c11 -triple i386-unknown-unknown -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/string-literal.c -o - | ${LLVM_SRC}/build/bin/FileCheck -check-prefix=CHECK-C11 ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/string-literal.c
    RUN(TestState.Failed, "%clang_cc1 -x c -std=c11 -triple i386-unknown-unknown -emit-llvm %s -o -")./*|*/
      I("FileCheck -check-prefix=CHECK-C11 %s");
  }

  @Test
  public void test_string_literal_short_wstring_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/string-literal-short-wstring.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x c++ -triple i386-pc-solaris2.11 -emit-llvm -fshort-wchar ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/string-literal-short-wstring.c -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/string-literal-short-wstring.c --check-prefix=CHECK --check-prefix=ITANIUM
    RUN(TestState.Failed, "%clang_cc1 -x c++ -triple %itanium_abi_triple -emit-llvm -fshort-wchar %s -o -")./*|*/
      I("FileCheck %s --check-prefix=CHECK --check-prefix=ITANIUM");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x c++ -triple i386-pc-win32 -emit-llvm -fshort-wchar ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/string-literal-short-wstring.c -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/string-literal-short-wstring.c --check-prefix=CHECK --check-prefix=MSABI
    RUN(TestState.Failed, "%clang_cc1 -x c++ -triple %ms_abi_triple -emit-llvm -fshort-wchar %s -o -")./*|*/
      I("FileCheck %s --check-prefix=CHECK --check-prefix=MSABI");
  }

  @Test
  public void test_string_literal_unicode_conversion_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/string-literal-unicode-conversion.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i386-unknown-unknown -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/string-literal-unicode-conversion.c -o - | ${LLVM_SRC}/build/bin/FileCheck -check-prefix=CHECK-C ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/string-literal-unicode-conversion.c
    RUN(TestState.Failed, "%clang_cc1 -triple i386-unknown-unknown -emit-llvm %s -o -")./*|*/
      I("FileCheck -check-prefix=CHECK-C %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x c++ -std=c++0x -triple i386-unknown-unknown -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/string-literal-unicode-conversion.c -o - | ${LLVM_SRC}/build/bin/FileCheck -check-prefix=CHECK-CPP0X ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/string-literal-unicode-conversion.c
    RUN(TestState.Failed, "%clang_cc1 -x c++ -std=c++0x -triple i386-unknown-unknown -emit-llvm %s -o -")./*|*/
      I("FileCheck -check-prefix=CHECK-CPP0X %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x c++ -std=c++0x -fshort-wchar -triple i386-unknown-unknown -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/string-literal-unicode-conversion.c -o - | ${LLVM_SRC}/build/bin/FileCheck -check-prefix=CHECK-SHORTWCHAR ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/string-literal-unicode-conversion.c
    RUN(TestState.Failed, "%clang_cc1 -x c++ -std=c++0x -fshort-wchar -triple i386-unknown-unknown -emit-llvm %s -o -")./*|*/
      I("FileCheck -check-prefix=CHECK-SHORTWCHAR %s");
  }

  @Test
  public void test_struct_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/struct.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i386-unknown-unknown ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/struct.c -emit-llvm -o -
    RUN(TestState.Failed, "%clang_cc1 -triple i386-unknown-unknown %s -emit-llvm -o -");
  }

  @Test
  public void test_struct_comma_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/struct-comma.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/struct-comma.c -emit-llvm -o -
    RUN(TestState.Failed, "%clang_cc1 %s -emit-llvm -o -");
  }

  @Test
  public void test_struct_copy_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/struct-copy.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/struct-copy.c -o - | grep call.*llvm.memcpy
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm %s -o -")./*|*/
      I("grep 'call.*llvm.memcpy'");
  }

  @Test
  public void test_struct_init_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/struct-init.c");
    // REQUIRES: arm-registered-target
    if (!CHECK_REQUIRES("arm-registered-target")) {
      return;
    }
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -S -triple armv7-apple-darwin -target-feature +neon ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/struct-init.c -emit-llvm -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/struct-init.c
    RUN(TestState.Failed, "%clang_cc1 -S -triple armv7-apple-darwin -target-feature +neon %s -emit-llvm -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_struct_matching_constraint_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/struct-matching-constraint.c");
    // REQUIRES: arm-registered-target
    if (!CHECK_REQUIRES("arm-registered-target")) {
      return;
    }
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -S -emit-llvm -triple armv7a-apple-darwin -target-feature +neon ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/struct-matching-constraint.c -o /dev/null
    RUN(TestState.Failed, "%clang_cc1 -S -emit-llvm -triple armv7a-apple-darwin -target-feature +neon %s -o /dev/null");
  }

  @Test
  public void test_struct_passing_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/struct-passing.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i386-unknown-unknown -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/struct-passing.c -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/struct-passing.c
    RUN(TestState.Failed, "%clang_cc1 -triple i386-unknown-unknown -emit-llvm %s -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_struct_union_BE_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/struct-union-BE.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple mips-linux-gnu -S -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/struct-union-BE.c -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/struct-union-BE.c -check-prefix=MIPS
    RUN(TestState.Failed, "%clang_cc1 -triple mips-linux-gnu  -S -emit-llvm %s -o -")./*|*/
      I("FileCheck %s -check-prefix=MIPS");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple mips64-linux-gnu -S -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/struct-union-BE.c -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/struct-union-BE.c -check-prefix=MIPS64
    RUN(TestState.Failed, "%clang_cc1 -triple mips64-linux-gnu  -S -emit-llvm %s -o -")./*|*/
      I("FileCheck %s -check-prefix=MIPS64");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple armebv7-linux-gnueabihf -S -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/struct-union-BE.c -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/struct-union-BE.c -check-prefix=ARM
    RUN(TestState.Failed, "%clang_cc1 -triple armebv7-linux-gnueabihf -S -emit-llvm %s -o -")./*|*/
      I("FileCheck %s -check-prefix=ARM");
  }

  @Test
  public void test_struct_x86_darwin_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/struct-x86-darwin.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/struct-x86-darwin.c -emit-llvm -triple=i686-apple-darwin9 -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/struct-x86-darwin.c
    RUN(TestState.Failed, "%clang_cc1 %s -emit-llvm -triple=i686-apple-darwin9 -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_switch_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/switch.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i386-unknown-unknown -O3 ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/switch.c -emit-llvm -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/switch.c
    RUN(TestState.Failed, "%clang_cc1 -triple i386-unknown-unknown -O3 %s -emit-llvm -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_switch_dce_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/switch-dce.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i386-unknown-unknown ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/switch-dce.c -emit-llvm -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/switch-dce.c
    RUN(TestState.Failed, "%clang_cc1 -triple i386-unknown-unknown %s -emit-llvm -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_systemz_abi_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/systemz-abi.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple s390x-linux-gnu -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/systemz-abi.c | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/systemz-abi.c
    RUN(TestState.Failed, "%clang_cc1 -triple s390x-linux-gnu -emit-llvm -o - %s")./*|*/
      I("FileCheck %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple s390x-linux-gnu -target-feature +vector -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/systemz-abi.c | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/systemz-abi.c
    RUN(TestState.Failed, "%clang_cc1 -triple s390x-linux-gnu -target-feature +vector -emit-llvm -o - %s")./*|*/
      I("FileCheck %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple s390x-linux-gnu -target-cpu z13 -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/systemz-abi.c | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/systemz-abi.c
    RUN(TestState.Failed, "%clang_cc1 -triple s390x-linux-gnu -target-cpu z13 -emit-llvm -o - %s")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_systemz_abi_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/systemz-abi.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple s390x-linux-gnu -emit-llvm -x c++ -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/systemz-abi.cpp | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/systemz-abi.cpp
    RUN(TestState.Failed, "%clang_cc1 -triple s390x-linux-gnu -emit-llvm -x c++ -o - %s")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_systemz_abi_vector_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/systemz-abi-vector.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple s390x-linux-gnu -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/systemz-abi-vector.c | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/systemz-abi-vector.c
    RUN(TestState.Failed, "%clang_cc1 -triple s390x-linux-gnu -emit-llvm -o - %s")./*|*/
      I("FileCheck %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple s390x-linux-gnu -target-feature +vector -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/systemz-abi-vector.c | ${LLVM_SRC}/build/bin/FileCheck --check-prefix=CHECK-VECTOR ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/systemz-abi-vector.c
    RUN(TestState.Failed, "%clang_cc1 -triple s390x-linux-gnu -target-feature +vector -emit-llvm -o - %s")./*|*/
      I("FileCheck --check-prefix=CHECK-VECTOR %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple s390x-linux-gnu -target-cpu z13 -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/systemz-abi-vector.c | ${LLVM_SRC}/build/bin/FileCheck --check-prefix=CHECK-VECTOR ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/systemz-abi-vector.c
    RUN(TestState.Failed, "%clang_cc1 -triple s390x-linux-gnu -target-cpu z13 -emit-llvm -o - %s")./*|*/
      I("FileCheck --check-prefix=CHECK-VECTOR %s");
  }

  @Test
  public void test_systemz_inline_asm_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/systemz-inline-asm.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple s390x-linux-gnu -O2 -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/systemz-inline-asm.c | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/systemz-inline-asm.c
    RUN(TestState.Failed, "%clang_cc1 -triple s390x-linux-gnu -O2 -emit-llvm -o - %s")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_target_builtin_error_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/target-builtin-error.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/target-builtin-error.c -triple=x86_64-linux-gnu -S -verify -o -
    RUN(TestState.Failed, "%clang_cc1 %s -triple=x86_64-linux-gnu -S -verify -o -");
  }

  @Test
  public void test_target_builtin_error_2_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/target-builtin-error-2.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/target-builtin-error-2.c -triple=x86_64-linux-gnu -S -verify -o -
    RUN(TestState.Failed, "%clang_cc1 %s -triple=x86_64-linux-gnu -S -verify -o -");
  }

  @Test
  public void test_target_builtin_error_3_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/target-builtin-error-3.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/target-builtin-error-3.c -triple=x86_64-apple-darwin -S -verify -o - -target-feature +avx
    RUN(TestState.Failed, "%clang_cc1 %s -triple=x86_64-apple-darwin -S -verify -o - -target-feature +avx");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/target-builtin-error-3.c -triple=x86_64-apple-darwin -emit-obj -target-feature +avx 2> ${TEST_TEMP_DIR}/target-builtin-error-3.c.tmp.err
    RUN(TestState.Failed, "not %clang_cc1 %s -triple=x86_64-apple-darwin -emit-obj -target-feature +avx 2> %t.err");
    // ${LLVM_SRC}/build/bin/FileCheck < ${TEST_TEMP_DIR}/target-builtin-error-3.c.tmp.err ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/target-builtin-error-3.c
    RUN(TestState.Failed, "FileCheck < %t.err %s");
  }

  @Test
  public void test_target_builtin_noerror_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/target-builtin-noerror.c");
    // REQUIRES: x86-registered-target
    if (!CHECK_REQUIRES("x86-registered-target")) {
      return;
    }
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/target-builtin-noerror.c -triple=x86_64-linux-gnu -S -o -
    RUN(TestState.Failed, "%clang_cc1 %s -triple=x86_64-linux-gnu -S -o -");
  }

  @Test
  public void test_target_data_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/target-data.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i686-unknown-unknown -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/target-data.c | ${LLVM_SRC}/build/bin/FileCheck --check-prefix=I686-UNKNOWN ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/target-data.c
    RUN(TestState.Failed, "%clang_cc1 -triple i686-unknown-unknown -emit-llvm -o - %s")./*|*/
      I("FileCheck --check-prefix=I686-UNKNOWN %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i686-apple-darwin9 -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/target-data.c | ${LLVM_SRC}/build/bin/FileCheck --check-prefix=I686-DARWIN ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/target-data.c
    RUN(TestState.Failed, "%clang_cc1 -triple i686-apple-darwin9 -emit-llvm -o - %s")./*|*/
      I("FileCheck --check-prefix=I686-DARWIN %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i686-unknown-win32 -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/target-data.c | ${LLVM_SRC}/build/bin/FileCheck --check-prefix=I686-WIN32 ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/target-data.c
    RUN(TestState.Failed, "%clang_cc1 -triple i686-unknown-win32 -emit-llvm -o - %s")./*|*/
      I("FileCheck --check-prefix=I686-WIN32 %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i686-unknown-cygwin -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/target-data.c | ${LLVM_SRC}/build/bin/FileCheck --check-prefix=I686-CYGWIN ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/target-data.c
    RUN(TestState.Failed, "%clang_cc1 -triple i686-unknown-cygwin -emit-llvm -o - %s")./*|*/
      I("FileCheck --check-prefix=I686-CYGWIN %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-unknown-unknown -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/target-data.c | ${LLVM_SRC}/build/bin/FileCheck --check-prefix=X86_64 ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/target-data.c
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-unknown-unknown -emit-llvm -o - %s")./*|*/
      I("FileCheck --check-prefix=X86_64 %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple xcore-unknown-unknown -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/target-data.c | ${LLVM_SRC}/build/bin/FileCheck --check-prefix=XCORE ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/target-data.c
    RUN(TestState.Failed, "%clang_cc1 -triple xcore-unknown-unknown -emit-llvm -o - %s")./*|*/
      I("FileCheck --check-prefix=XCORE %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple sparc-sun-solaris -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/target-data.c | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/target-data.c --check-prefix=SPARC-V8
    RUN(TestState.Failed, "%clang_cc1 -triple sparc-sun-solaris -emit-llvm -o - %s")./*|*/
      I("FileCheck %s --check-prefix=SPARC-V8");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple sparcv9-sun-solaris -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/target-data.c | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/target-data.c --check-prefix=SPARC-V9
    RUN(TestState.Failed, "%clang_cc1 -triple sparcv9-sun-solaris -emit-llvm -o - %s")./*|*/
      I("FileCheck %s --check-prefix=SPARC-V9");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple mipsel-linux-gnu -o - -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/target-data.c | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/target-data.c -check-prefix=MIPS-32EL
    RUN(TestState.Failed, "%clang_cc1 -triple mipsel-linux-gnu -o - -emit-llvm %s")./*|*/
      I("FileCheck %s -check-prefix=MIPS-32EL");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple mips-linux-gnu -o - -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/target-data.c | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/target-data.c -check-prefix=MIPS-32EB
    RUN(TestState.Failed, "%clang_cc1 -triple mips-linux-gnu -o - -emit-llvm %s")./*|*/
      I("FileCheck %s -check-prefix=MIPS-32EB");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple mips64el-linux-gnu -o - -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/target-data.c | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/target-data.c -check-prefix=MIPS-64EL
    RUN(TestState.Failed, "%clang_cc1 -triple mips64el-linux-gnu -o - -emit-llvm %s")./*|*/
      I("FileCheck %s -check-prefix=MIPS-64EL");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple mips64el-linux-gnu -o - -emit-llvm -target-abi n32 ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/target-data.c | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/target-data.c -check-prefix=MIPS-64EL-N32
    RUN(TestState.Failed, "%clang_cc1 -triple mips64el-linux-gnu -o - -emit-llvm -target-abi n32 %s")./*|*/
      I("FileCheck %s -check-prefix=MIPS-64EL-N32");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple mips64-linux-gnu -o - -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/target-data.c | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/target-data.c -check-prefix=MIPS-64EB
    RUN(TestState.Failed, "%clang_cc1 -triple mips64-linux-gnu -o - -emit-llvm %s")./*|*/
      I("FileCheck %s -check-prefix=MIPS-64EB");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple mips64-linux-gnu -o - -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/target-data.c -target-abi n32 | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/target-data.c -check-prefix=MIPS-64EB-N32
    RUN(TestState.Failed, "%clang_cc1 -triple mips64-linux-gnu -o - -emit-llvm %s -target-abi n32")./*|*/
      I("FileCheck %s -check-prefix=MIPS-64EB-N32");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple powerpc64-lv2 -o - -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/target-data.c | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/target-data.c -check-prefix=PS3
    RUN(TestState.Failed, "%clang_cc1 -triple powerpc64-lv2 -o - -emit-llvm %s")./*|*/
      I("FileCheck %s -check-prefix=PS3");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i686-nacl -o - -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/target-data.c | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/target-data.c -check-prefix=I686-NACL
    RUN(TestState.Failed, "%clang_cc1 -triple i686-nacl -o - -emit-llvm %s")./*|*/
      I("FileCheck %s -check-prefix=I686-NACL");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-nacl -o - -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/target-data.c | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/target-data.c -check-prefix=X86_64-NACL
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-nacl -o - -emit-llvm %s")./*|*/
      I("FileCheck %s -check-prefix=X86_64-NACL");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple arm-nacl -o - -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/target-data.c | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/target-data.c -check-prefix=ARM-NACL
    RUN(TestState.Failed, "%clang_cc1 -triple arm-nacl -o - -emit-llvm %s")./*|*/
      I("FileCheck %s -check-prefix=ARM-NACL");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple mipsel-nacl -o - -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/target-data.c | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/target-data.c -check-prefix=MIPS-NACL
    RUN(TestState.Failed, "%clang_cc1 -triple mipsel-nacl -o - -emit-llvm %s")./*|*/
      I("FileCheck %s -check-prefix=MIPS-NACL");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple le32-nacl -o - -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/target-data.c | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/target-data.c -check-prefix=LE32-NACL
    RUN(TestState.Failed, "%clang_cc1 -triple le32-nacl -o - -emit-llvm %s")./*|*/
      I("FileCheck %s -check-prefix=LE32-NACL");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple wasm32-unknown-unknown -o - -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/target-data.c | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/target-data.c -check-prefix=WEBASSEMBLY32
    RUN(TestState.Failed, "%clang_cc1 -triple wasm32-unknown-unknown -o - -emit-llvm %s")./*|*/
      I("FileCheck %s -check-prefix=WEBASSEMBLY32");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple wasm64-unknown-unknown -o - -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/target-data.c | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/target-data.c -check-prefix=WEBASSEMBLY64
    RUN(TestState.Failed, "%clang_cc1 -triple wasm64-unknown-unknown -o - -emit-llvm %s")./*|*/
      I("FileCheck %s -check-prefix=WEBASSEMBLY64");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple lanai-unknown-unknown -o - -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/target-data.c | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/target-data.c -check-prefix=LANAI
    RUN(TestState.Failed, "%clang_cc1 -triple lanai-unknown-unknown -o - -emit-llvm %s")./*|*/
      I("FileCheck %s -check-prefix=LANAI");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple powerpc-unknown -o - -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/target-data.c | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/target-data.c -check-prefix=PPC
    RUN(TestState.Failed, "%clang_cc1 -triple powerpc-unknown -o - -emit-llvm %s")./*|*/
      I("FileCheck %s -check-prefix=PPC");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple powerpc64-freebsd -o - -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/target-data.c | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/target-data.c -check-prefix=PPC64-FREEBSD
    RUN(TestState.Failed, "%clang_cc1 -triple powerpc64-freebsd -o - -emit-llvm %s")./*|*/
      I("FileCheck %s -check-prefix=PPC64-FREEBSD");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple powerpc64-linux -o - -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/target-data.c | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/target-data.c -check-prefix=PPC64-LINUX
    RUN(TestState.Failed, "%clang_cc1 -triple powerpc64-linux -o - -emit-llvm %s")./*|*/
      I("FileCheck %s -check-prefix=PPC64-LINUX");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple powerpc64le-linux -o - -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/target-data.c | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/target-data.c -check-prefix=PPC64LE-LINUX
    RUN(TestState.Failed, "%clang_cc1 -triple powerpc64le-linux -o - -emit-llvm %s")./*|*/
      I("FileCheck %s -check-prefix=PPC64LE-LINUX");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple powerpc-darwin -o - -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/target-data.c | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/target-data.c -check-prefix=PPC32-DARWIN
    RUN(TestState.Failed, "%clang_cc1 -triple powerpc-darwin -o - -emit-llvm %s")./*|*/
      I("FileCheck %s -check-prefix=PPC32-DARWIN");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple powerpc64-darwin -o - -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/target-data.c | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/target-data.c -check-prefix=PPC64-DARWIN
    RUN(TestState.Failed, "%clang_cc1 -triple powerpc64-darwin -o - -emit-llvm %s")./*|*/
      I("FileCheck %s -check-prefix=PPC64-DARWIN");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple nvptx-unknown -o - -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/target-data.c | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/target-data.c -check-prefix=NVPTX
    RUN(TestState.Failed, "%clang_cc1 -triple nvptx-unknown -o - -emit-llvm %s")./*|*/
      I("FileCheck %s -check-prefix=NVPTX");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple nvptx64-unknown -o - -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/target-data.c | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/target-data.c -check-prefix=NVPTX64
    RUN(TestState.Failed, "%clang_cc1 -triple nvptx64-unknown -o - -emit-llvm %s")./*|*/
      I("FileCheck %s -check-prefix=NVPTX64");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple r600-unknown -o - -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/target-data.c | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/target-data.c -check-prefix=R600
    RUN(TestState.Failed, "%clang_cc1 -triple r600-unknown -o - -emit-llvm %s")./*|*/
      I("FileCheck %s -check-prefix=R600");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple r600-unknown -target-cpu cayman -o - -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/target-data.c | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/target-data.c -check-prefix=R600D
    RUN(TestState.Failed, "%clang_cc1 -triple r600-unknown -target-cpu cayman -o - -emit-llvm %s")./*|*/
      I("FileCheck %s -check-prefix=R600D");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple amdgcn-unknown -target-cpu hawaii -o - -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/target-data.c | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/target-data.c -check-prefix=R600SI
    RUN(TestState.Failed, "%clang_cc1 -triple amdgcn-unknown -target-cpu hawaii -o - -emit-llvm %s")./*|*/
      I("FileCheck %s -check-prefix=R600SI");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple amdgcn-unknown -o - -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/target-data.c | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/target-data.c -check-prefix=R600SIDefault
    RUN(TestState.Failed, "%clang_cc1 -triple amdgcn-unknown -o - -emit-llvm %s")./*|*/
      I("FileCheck %s -check-prefix=R600SIDefault");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple arm64-unknown -o - -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/target-data.c | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/target-data.c -check-prefix=AARCH64
    RUN(TestState.Failed, "%clang_cc1 -triple arm64-unknown -o - -emit-llvm %s")./*|*/
      I("FileCheck %s -check-prefix=AARCH64");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple thumb-unknown-gnueabi -o - -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/target-data.c | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/target-data.c -check-prefix=THUMB
    RUN(TestState.Failed, "%clang_cc1 -triple thumb-unknown-gnueabi -o - -emit-llvm %s")./*|*/
      I("FileCheck %s -check-prefix=THUMB");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple arm-unknown-gnueabi -o - -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/target-data.c | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/target-data.c -check-prefix=ARM
    RUN(TestState.Failed, "%clang_cc1 -triple arm-unknown-gnueabi -o - -emit-llvm %s")./*|*/
      I("FileCheck %s -check-prefix=ARM");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple thumb-unknown -o - -emit-llvm -target-abi apcs-gnu ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/target-data.c | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/target-data.c -check-prefix=THUMB-GNU
    RUN(TestState.Failed, "%clang_cc1 -triple thumb-unknown -o - -emit-llvm -target-abi apcs-gnu %s")./*|*/
      I("FileCheck %s -check-prefix=THUMB-GNU");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple arm-unknown -o - -emit-llvm -target-abi apcs-gnu ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/target-data.c | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/target-data.c -check-prefix=ARM-GNU
    RUN(TestState.Failed, "%clang_cc1 -triple arm-unknown -o - -emit-llvm -target-abi apcs-gnu %s")./*|*/
      I("FileCheck %s -check-prefix=ARM-GNU");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple hexagon-unknown -o - -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/target-data.c | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/target-data.c -check-prefix=HEXAGON
    RUN(TestState.Failed, "%clang_cc1 -triple hexagon-unknown -o - -emit-llvm %s")./*|*/
      I("FileCheck %s -check-prefix=HEXAGON");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple s390x-unknown -o - -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/target-data.c | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/target-data.c -check-prefix=SYSTEMZ
    RUN(TestState.Failed, "%clang_cc1 -triple s390x-unknown -o - -emit-llvm %s")./*|*/
      I("FileCheck %s -check-prefix=SYSTEMZ");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple s390x-unknown -target-cpu z13 -o - -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/target-data.c | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/target-data.c -check-prefix=SYSTEMZ-VECTOR
    RUN(TestState.Failed, "%clang_cc1 -triple s390x-unknown -target-cpu z13 -o - -emit-llvm %s")./*|*/
      I("FileCheck %s -check-prefix=SYSTEMZ-VECTOR");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple msp430-unknown -o - -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/target-data.c | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/target-data.c -check-prefix=MSP430
    RUN(TestState.Failed, "%clang_cc1 -triple msp430-unknown -o - -emit-llvm %s")./*|*/
      I("FileCheck %s -check-prefix=MSP430");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple tce-unknown -o - -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/target-data.c | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/target-data.c -check-prefix=TCE
    RUN(TestState.Failed, "%clang_cc1 -triple tce-unknown -o - -emit-llvm %s")./*|*/
      I("FileCheck %s -check-prefix=TCE");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple spir-unknown -o - -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/target-data.c | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/target-data.c -check-prefix=SPIR
    RUN(TestState.Failed, "%clang_cc1 -triple spir-unknown -o - -emit-llvm %s")./*|*/
      I("FileCheck %s -check-prefix=SPIR");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple spir64-unknown -o - -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/target-data.c | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/target-data.c -check-prefix=SPIR64
    RUN(TestState.Failed, "%clang_cc1 -triple spir64-unknown -o - -emit-llvm %s")./*|*/
      I("FileCheck %s -check-prefix=SPIR64");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple bpfel -o - -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/target-data.c | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/target-data.c -check-prefix=BPFEL
    RUN(TestState.Failed, "%clang_cc1 -triple bpfel -o - -emit-llvm %s")./*|*/
      I("FileCheck %s -check-prefix=BPFEL");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple bpfeb -o - -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/target-data.c | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/target-data.c -check-prefix=BPFEB
    RUN(TestState.Failed, "%clang_cc1 -triple bpfeb -o - -emit-llvm %s")./*|*/
      I("FileCheck %s -check-prefix=BPFEB");
  }

  @Test
  public void test_target_features_error_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/target-features-error.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/target-features-error.c -triple=x86_64-linux-gnu -S -verify -o -
    RUN(TestState.Failed, "%clang_cc1 %s -triple=x86_64-linux-gnu -S -verify -o -");
  }

  @Test
  public void test_target_features_error_2_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/target-features-error-2.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/target-features-error-2.c -triple=x86_64-linux-gnu -S -verify -o - -D NEED_SSE42
    RUN(TestState.Failed, "%clang_cc1 %s -triple=x86_64-linux-gnu -S -verify -o - -D NEED_SSE42");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/target-features-error-2.c -triple=x86_64-linux-gnu -S -verify -o - -D NEED_AVX_1
    RUN(TestState.Failed, "%clang_cc1 %s -triple=x86_64-linux-gnu -S -verify -o - -D NEED_AVX_1");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/target-features-error-2.c -triple=x86_64-linux-gnu -S -verify -o - -D NEED_AVX_2
    RUN(TestState.Failed, "%clang_cc1 %s -triple=x86_64-linux-gnu -S -verify -o - -D NEED_AVX_2");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/target-features-error-2.c -triple=x86_64-linux-gnu -S -verify -o - -D NEED_AVX_3
    RUN(TestState.Failed, "%clang_cc1 %s -triple=x86_64-linux-gnu -S -verify -o - -D NEED_AVX_3");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/target-features-error-2.c -triple=x86_64-linux-gnu -S -verify -o - -D NEED_AVX_4
    RUN(TestState.Failed, "%clang_cc1 %s -triple=x86_64-linux-gnu -S -verify -o - -D NEED_AVX_4");
  }

  @Test
  public void test_target_features_no_error_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/target-features-no-error.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/target-features-no-error.c -triple=x86_64-linux-gnu -emit-llvm -o - -target-feature -sse2
    RUN(TestState.Failed, "%clang_cc1 %s -triple=x86_64-linux-gnu -emit-llvm -o - -target-feature -sse2");
  }

  @Test
  public void test_tbaa_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/tbaa.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-apple-darwin -O1 -no-struct-path-tbaa -disable-llvm-optzns ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/tbaa.cpp -emit-llvm -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/tbaa.cpp
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-apple-darwin -O1 -no-struct-path-tbaa -disable-llvm-optzns %s -emit-llvm -o -")./*|*/
      I("FileCheck %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-apple-darwin -O1 -disable-llvm-optzns ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/tbaa.cpp -emit-llvm -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/tbaa.cpp -check-prefix=PATH
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-apple-darwin -O1 -disable-llvm-optzns %s -emit-llvm -o -")./*|*/
      I("FileCheck %s -check-prefix=PATH");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-apple-darwin -O0 -disable-llvm-optzns ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/tbaa.cpp -emit-llvm -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/tbaa.cpp -check-prefix=NO-TBAA
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-apple-darwin -O0 -disable-llvm-optzns %s -emit-llvm -o -")./*|*/
      I("FileCheck %s -check-prefix=NO-TBAA");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-apple-darwin -O1 -relaxed-aliasing -disable-llvm-optzns ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/tbaa.cpp -emit-llvm -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/tbaa.cpp -check-prefix=NO-TBAA
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-apple-darwin -O1 -relaxed-aliasing -disable-llvm-optzns %s -emit-llvm -o -")./*|*/
      I("FileCheck %s -check-prefix=NO-TBAA");
  }

  @Test
  public void test_tbaa_class_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/tbaa-class.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-apple-darwin -O1 -no-struct-path-tbaa -disable-llvm-optzns ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/tbaa-class.cpp -emit-llvm -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/tbaa-class.cpp
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-apple-darwin -O1 -no-struct-path-tbaa -disable-llvm-optzns %s -emit-llvm -o -")./*|*/
      I("FileCheck %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-apple-darwin -O1 -disable-llvm-optzns ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/tbaa-class.cpp -emit-llvm -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/tbaa-class.cpp -check-prefix=PATH
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-apple-darwin -O1 -disable-llvm-optzns %s -emit-llvm -o -")./*|*/
      I("FileCheck %s -check-prefix=PATH");
  }

  @Test
  public void test_tbaa_for_vptr_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/tbaa-for-vptr.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i386-pc-solaris2.11 -emit-llvm -o - -fsanitize=thread ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/tbaa-for-vptr.cpp | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/tbaa-for-vptr.cpp
    RUN(TestState.Failed, "%clang_cc1 -triple %itanium_abi_triple -emit-llvm -o - -fsanitize=thread %s")./*|*/
      I("FileCheck %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i386-pc-solaris2.11 -emit-llvm -o - -O1 ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/tbaa-for-vptr.cpp | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/tbaa-for-vptr.cpp
    RUN(TestState.Failed, "%clang_cc1 -triple %itanium_abi_triple -emit-llvm -o - -O1 %s")./*|*/
      I("FileCheck %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i386-pc-solaris2.11 -emit-llvm -o - -O1 -relaxed-aliasing -fsanitize=thread ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/tbaa-for-vptr.cpp | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/tbaa-for-vptr.cpp
    RUN(TestState.Failed, "%clang_cc1 -triple %itanium_abi_triple -emit-llvm -o - -O1  -relaxed-aliasing -fsanitize=thread %s")./*|*/
      I("FileCheck %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i386-pc-solaris2.11 -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/tbaa-for-vptr.cpp | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/tbaa-for-vptr.cpp --check-prefix=NOTBAA
    RUN(TestState.Failed, "%clang_cc1 -triple %itanium_abi_triple -emit-llvm -o - %s")./*|*/
      I("FileCheck %s --check-prefix=NOTBAA");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i386-pc-solaris2.11 -emit-llvm -o - -O2 -relaxed-aliasing ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/tbaa-for-vptr.cpp | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/tbaa-for-vptr.cpp --check-prefix=NOTBAA
    RUN(TestState.Failed, "%clang_cc1 -triple %itanium_abi_triple -emit-llvm -o - -O2  -relaxed-aliasing %s")./*|*/
      I("FileCheck %s --check-prefix=NOTBAA");
  }

  @Test
  public void test_tbaa_ms_abi_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/tbaa-ms-abi.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i686-pc-win32 -disable-llvm-optzns -emit-llvm -o - -O1 ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/tbaa-ms-abi.cpp | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/tbaa-ms-abi.cpp
    RUN(TestState.Failed, "%clang_cc1 -triple i686-pc-win32 -disable-llvm-optzns -emit-llvm -o - -O1 %s")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_tbaa_struct_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/tbaa-struct.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-apple-darwin -emit-llvm -o - -O1 ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/tbaa-struct.cpp | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/tbaa-struct.cpp
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-apple-darwin -emit-llvm -o - -O1 %s")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_tbaa_thread_sanitizer_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/tbaa-thread-sanitizer.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-apple-darwin -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/tbaa-thread-sanitizer.cpp -fsanitize=thread -relaxed-aliasing -O1 | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/tbaa-thread-sanitizer.cpp
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-apple-darwin -emit-llvm -o - %s -fsanitize=thread -relaxed-aliasing -O1")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_tbm_builtins_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/tbm-builtins.c");
    // REQUIRES: x86-registered-target
    if (!CHECK_REQUIRES("x86-registered-target")) {
      return;
    }
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/tbm-builtins.c -O3 -triple=x86_64-unknown-unknown -target-feature +tbm -emit-llvm -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/tbm-builtins.c
    RUN(TestState.Failed, "%clang_cc1 %s -O3 -triple=x86_64-unknown-unknown -target-feature +tbm -emit-llvm -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_temporary_lifetime_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/temporary-lifetime.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/temporary-lifetime.cpp -std=c++11 -O1 -DWITH_DTOR -triple x86_64 -emit-llvm -o - | ${LLVM_SRC}/build/bin/FileCheck -check-prefix=CHECK-DTOR ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/temporary-lifetime.cpp
    RUN(TestState.Failed, "%clang_cc1 %s -std=c++11 -O1 -DWITH_DTOR -triple x86_64 -emit-llvm -o -")./*|*/
      I("FileCheck -check-prefix=CHECK-DTOR %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/temporary-lifetime.cpp -std=c++11 -O1 -triple x86_64 -emit-llvm -o - | ${LLVM_SRC}/build/bin/FileCheck -check-prefix=CHECK-NO-DTOR ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/temporary-lifetime.cpp
    RUN(TestState.Failed, "%clang_cc1 %s -std=c++11 -O1 -triple x86_64 -emit-llvm -o -")./*|*/
      I("FileCheck -check-prefix=CHECK-NO-DTOR %s");
  }

  @Test
  public void test_temporary_lifetime_exceptions_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/temporary-lifetime-exceptions.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/temporary-lifetime-exceptions.cpp -fexceptions -fcxx-exceptions -std=c++11 -O1 -triple x86_64 -emit-llvm -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/temporary-lifetime-exceptions.cpp
    RUN(TestState.Failed, "%clang_cc1 %s -fexceptions -fcxx-exceptions -std=c++11 -O1 -triple x86_64 -emit-llvm -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_tentative_decls_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/tentative-decls.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm -o ${TEST_TEMP_DIR}/tentative-decls.c.tmp ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/tentative-decls.c
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm -o %t %s");
    // grep '@r = common global \[1 x .*\] zeroinitializer' ${TEST_TEMP_DIR}/tentative-decls.c.tmp
    RUN(TestState.Failed, "grep '@r = common global \\[1 x .*\\] zeroinitializer' %t");
    // grep '@x = common global .struct.s0 zeroinitializer' ${TEST_TEMP_DIR}/tentative-decls.c.tmp
    RUN(TestState.Failed, "grep '@x = common global .struct.s0 zeroinitializer' %t");
    // grep '@y = common global .struct.s0 zeroinitializer' ${TEST_TEMP_DIR}/tentative-decls.c.tmp
    RUN(TestState.Failed, "grep '@y = common global .struct.s0 zeroinitializer' %t");
    // grep '@b = common global \[1 x .*\] zeroinitializer' ${TEST_TEMP_DIR}/tentative-decls.c.tmp
    RUN(TestState.Failed, "grep '@b = common global \\[1 x .*\\] zeroinitializer' %t");
    // grep '@c = common global \[4 x .*\] zeroinitializer' ${TEST_TEMP_DIR}/tentative-decls.c.tmp
    RUN(TestState.Failed, "grep '@c = common global \\[4 x .*\\] zeroinitializer' %t");
    // grep '@c5 = internal global \[1 x .*\] zeroinitializer' ${TEST_TEMP_DIR}/tentative-decls.c.tmp
    RUN(TestState.Failed, "grep '@c5 = internal global \\[1 x .*\\] zeroinitializer' %t");
  }

  @Test
  public void test_thread_specifier_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/thread-specifier.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i686-pc-linux-gnu -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/thread-specifier.c | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/thread-specifier.c
    RUN(TestState.Failed, "%clang_cc1 -triple i686-pc-linux-gnu -emit-llvm -o - %s")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_tls_model_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/tls-model.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/tls-model.c -triple x86_64-pc-linux-gnu -emit-llvm -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/tls-model.c -check-prefix=CHECK-GD
    RUN(TestState.Failed, "%clang_cc1 %s -triple x86_64-pc-linux-gnu -emit-llvm -o -")./*|*/
      I("FileCheck %s -check-prefix=CHECK-GD");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/tls-model.c -triple x86_64-pc-linux-gnu -ftls-model=global-dynamic -emit-llvm -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/tls-model.c -check-prefix=CHECK-GD
    RUN(TestState.Failed, "%clang_cc1 %s -triple x86_64-pc-linux-gnu -ftls-model=global-dynamic -emit-llvm -o -")./*|*/
      I("FileCheck %s -check-prefix=CHECK-GD");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/tls-model.c -triple x86_64-pc-linux-gnu -ftls-model=local-dynamic -emit-llvm -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/tls-model.c -check-prefix=CHECK-LD
    RUN(TestState.Failed, "%clang_cc1 %s -triple x86_64-pc-linux-gnu -ftls-model=local-dynamic -emit-llvm -o -")./*|*/
      I("FileCheck %s -check-prefix=CHECK-LD");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/tls-model.c -triple x86_64-pc-linux-gnu -ftls-model=initial-exec -emit-llvm -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/tls-model.c -check-prefix=CHECK-IE
    RUN(TestState.Failed, "%clang_cc1 %s -triple x86_64-pc-linux-gnu -ftls-model=initial-exec -emit-llvm -o -")./*|*/
      I("FileCheck %s -check-prefix=CHECK-IE");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/tls-model.c -triple x86_64-pc-linux-gnu -ftls-model=local-exec -emit-llvm -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/tls-model.c -check-prefix=CHECK-LE
    RUN(TestState.Failed, "%clang_cc1 %s -triple x86_64-pc-linux-gnu -ftls-model=local-exec -emit-llvm -o -")./*|*/
      I("FileCheck %s -check-prefix=CHECK-LE");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/tls-model.c -triple x86_64-pc-linux-gnu -femulated-tls -emit-llvm -o - 2>&1 | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/tls-model.c -check-prefix=CHECK-GD
    RUN(TestState.Failed, "%clang_cc1 %s -triple x86_64-pc-linux-gnu -femulated-tls -emit-llvm -o - 2>&1")./*|*/
      I("FileCheck %s -check-prefix=CHECK-GD");
  }

  @Test
  public void test_transparent_union_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/transparent-union.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -Werror -triple x86_64-linux -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/transparent-union.c | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/transparent-union.c
    RUN(TestState.Failed, "%clang_cc1 -Werror -triple x86_64-linux -emit-llvm -o - %s")./*|*/
      I("FileCheck %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -Werror -triple i386-linux -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/transparent-union.c | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/transparent-union.c
    RUN(TestState.Failed, "%clang_cc1 -Werror -triple i386-linux -emit-llvm -o - %s")./*|*/
      I("FileCheck %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -Werror -triple armv7-linux -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/transparent-union.c | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/transparent-union.c --check-prefix=ARM
    RUN(TestState.Failed, "%clang_cc1 -Werror -triple armv7-linux -emit-llvm -o - %s")./*|*/
      I("FileCheck %s --check-prefix=ARM");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -Werror -triple powerpc64le-linux -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/transparent-union.c | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/transparent-union.c
    RUN(TestState.Failed, "%clang_cc1 -Werror -triple powerpc64le-linux -emit-llvm -o - %s")./*|*/
      I("FileCheck %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -Werror -triple aarch64-linux -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/transparent-union.c | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/transparent-union.c
    RUN(TestState.Failed, "%clang_cc1 -Werror -triple aarch64-linux -emit-llvm -o - %s")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_trapv_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/trapv.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-apple-darwin10 -ftrapv ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/trapv.c -emit-llvm -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/trapv.c
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-apple-darwin10 -ftrapv %s -emit-llvm -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_typedef_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/typedef.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/typedef.c -o -
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm %s -o -");
  }

  @Test
  public void test_typedef_func_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/typedef-func.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm < ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/typedef-func.c
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm < %s");
  }

  @Test
  public void test_types_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/types.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm '<${LLVM_SRC}/llvm/tools/clang/test/CodeGen/types.c'
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm <%s");
  }

  @Test
  public void test_ubsan_blacklist_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/ubsan-blacklist.c");
    // REQUIRES: shell
    if (!CHECK_REQUIRES("shell")) {
      return;
    }
    // echo fun:hash > ${TEST_TEMP_DIR}/ubsan-blacklist.c.tmp-func.blacklist
    RUN(TestState.Failed, "echo \"fun:hash\" > %t-func.blacklist");
    // echo 'src:${LLVM_SRC}/llvm/tools/clang/test/CodeGen/ubsan-blacklist.c' > ${TEST_TEMP_DIR}/ubsan-blacklist.c.tmp-file.blacklist
    RUN(TestState.Failed, "echo \"src:%s\" > %t-file.blacklist");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsanitize=unsigned-integer-overflow -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/ubsan-blacklist.c -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/ubsan-blacklist.c --check-prefix=DEFAULT
    RUN(TestState.Failed, "%clang_cc1 -fsanitize=unsigned-integer-overflow -emit-llvm %s -o -")./*|*/
      I("FileCheck %s --check-prefix=DEFAULT");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsanitize=unsigned-integer-overflow '-fsanitize-blacklist=${TEST_TEMP_DIR}/ubsan-blacklist.c.tmp-func.blacklist' -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/ubsan-blacklist.c -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/ubsan-blacklist.c --check-prefix=FUNC
    RUN(TestState.Failed, "%clang_cc1 -fsanitize=unsigned-integer-overflow -fsanitize-blacklist=%t-func.blacklist -emit-llvm %s -o -")./*|*/
      I("FileCheck %s --check-prefix=FUNC");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsanitize=unsigned-integer-overflow '-fsanitize-blacklist=${TEST_TEMP_DIR}/ubsan-blacklist.c.tmp-file.blacklist' -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/ubsan-blacklist.c -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/ubsan-blacklist.c --check-prefix=FILE
    RUN(TestState.Failed, "%clang_cc1 -fsanitize=unsigned-integer-overflow -fsanitize-blacklist=%t-file.blacklist -emit-llvm %s -o -")./*|*/
      I("FileCheck %s --check-prefix=FILE");
  }

  @Test
  public void test_ubsan_conditional_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/ubsan-conditional.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/ubsan-conditional.c -emit-llvm -fsanitize=float-divide-by-zero -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/ubsan-conditional.c
    RUN(TestState.Failed, "%clang_cc1 %s -emit-llvm -fsanitize=float-divide-by-zero -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_ubsan_strip_path_components_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/ubsan-strip-path-components.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/ubsan-strip-path-components.cpp -triple=x86_64-linux-gnu -emit-llvm -fsanitize=unreachable -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/ubsan-strip-path-components.cpp -check-prefix=REGULAR -check-prefix=CHECK
    RUN(TestState.Failed, "%clang_cc1 %s -triple=x86_64-linux-gnu -emit-llvm -fsanitize=unreachable -o -")./*|*/
      I("FileCheck %s -check-prefix=REGULAR -check-prefix=CHECK");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/ubsan-strip-path-components.cpp -triple=x86_64-linux-gnu -emit-llvm -fsanitize=unreachable -o - -fsanitize-undefined-strip-path-components=0 | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/ubsan-strip-path-components.cpp -check-prefix=REGULAR -check-prefix=CHECK
    RUN(TestState.Failed, "%clang_cc1 %s -triple=x86_64-linux-gnu -emit-llvm -fsanitize=unreachable -o - -fsanitize-undefined-strip-path-components=0")./*|*/
      I("FileCheck %s -check-prefix=REGULAR -check-prefix=CHECK");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/ubsan-strip-path-components.cpp -triple=x86_64-linux-gnu -emit-llvm -fsanitize=unreachable -o - -fsanitize-undefined-strip-path-components=2 | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/ubsan-strip-path-components.cpp -check-prefix=REMOVE-FIRST-TWO -check-prefix=CHECK
    RUN(TestState.Failed, "%clang_cc1 %s -triple=x86_64-linux-gnu -emit-llvm -fsanitize=unreachable -o - -fsanitize-undefined-strip-path-components=2")./*|*/
      I("FileCheck %s -check-prefix=REMOVE-FIRST-TWO -check-prefix=CHECK");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/ubsan-strip-path-components.cpp -triple=x86_64-linux-gnu -emit-llvm -fsanitize=unreachable -o - -fsanitize-undefined-strip-path-components=-99999 | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/ubsan-strip-path-components.cpp -check-prefix=REGULAR
    RUN(TestState.Failed, "%clang_cc1 %s -triple=x86_64-linux-gnu -emit-llvm -fsanitize=unreachable -o - -fsanitize-undefined-strip-path-components=-99999")./*|*/
      I("FileCheck %s -check-prefix=REGULAR");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/ubsan-strip-path-components.cpp -triple=x86_64-linux-gnu -emit-llvm -fsanitize=unreachable -o - -fsanitize-undefined-strip-path-components=99999 | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/ubsan-strip-path-components.cpp -check-prefix=LAST-ONLY
    RUN(TestState.Failed, "%clang_cc1 %s -triple=x86_64-linux-gnu -emit-llvm -fsanitize=unreachable -o - -fsanitize-undefined-strip-path-components=99999")./*|*/
      I("FileCheck %s -check-prefix=LAST-ONLY");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/ubsan-strip-path-components.cpp -triple=x86_64-linux-gnu -emit-llvm -fsanitize=unreachable -o - -fsanitize-undefined-strip-path-components=-2 | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/ubsan-strip-path-components.cpp -check-prefix=LAST-TWO
    RUN(TestState.Failed, "%clang_cc1 %s -triple=x86_64-linux-gnu -emit-llvm -fsanitize=unreachable -o - -fsanitize-undefined-strip-path-components=-2")./*|*/
      I("FileCheck %s -check-prefix=LAST-TWO");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/ubsan-strip-path-components.cpp -triple=x86_64-linux-gnu -emit-llvm -fsanitize=unreachable -o - -fsanitize-undefined-strip-path-components=-1 | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/ubsan-strip-path-components.cpp -check-prefix=LAST-ONLY
    RUN(TestState.Failed, "%clang_cc1 %s -triple=x86_64-linux-gnu -emit-llvm -fsanitize=unreachable -o - -fsanitize-undefined-strip-path-components=-1")./*|*/
      I("FileCheck %s -check-prefix=LAST-ONLY");
  }

  @Test
  public void test_ubsan_type_blacklist_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/ubsan-type-blacklist.cpp");
    // echo type:_ZTI3Foo > ${TEST_TEMP_DIR}/ubsan-type-blacklist.cpp.tmp-type.blacklist
    RUN(TestState.Failed, "echo \"type:_ZTI3Foo\" > %t-type.blacklist");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-linux-gnu -fsanitize=vptr -fsanitize-recover=vptr -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/ubsan-type-blacklist.cpp -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/ubsan-type-blacklist.cpp --check-prefix=DEFAULT
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-linux-gnu -fsanitize=vptr -fsanitize-recover=vptr -emit-llvm %s -o -")./*|*/
      I("FileCheck %s --check-prefix=DEFAULT");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-linux-gnu -fsanitize=vptr -fsanitize-recover=vptr '-fsanitize-blacklist=${TEST_TEMP_DIR}/ubsan-type-blacklist.cpp.tmp-type.blacklist' -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/ubsan-type-blacklist.cpp -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/ubsan-type-blacklist.cpp --check-prefix=TYPE
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-linux-gnu -fsanitize=vptr -fsanitize-recover=vptr -fsanitize-blacklist=%t-type.blacklist -emit-llvm %s -o -")./*|*/
      I("FileCheck %s --check-prefix=TYPE");
  }

  @Test
  public void test_ucn_identifiers_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/ucn-identifiers.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/ucn-identifiers.c -emit-llvm -o /dev/null
    RUN(TestState.Failed, "%clang_cc1 %s -emit-llvm -o /dev/null");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/ucn-identifiers.c -emit-llvm -o /dev/null -x c++
    RUN(TestState.Failed, "%clang_cc1 %s -emit-llvm -o /dev/null -x c++");
  }

  @Test
  public void test_uint128_t_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/uint128_t.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/uint128_t.c -emit-llvm -o - -triple=x86_64-apple-darwin9
    RUN(TestState.Failed, "%clang_cc1 %s -emit-llvm -o - -triple=x86_64-apple-darwin9");
  }

  @Test
  public void test_unaligned_memcpy_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/unaligned-memcpy.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/unaligned-memcpy.c -emit-llvm -o -
    RUN(TestState.Failed, "%clang_cc1 %s -emit-llvm -o -");
  }

  @Test
  public void test_union_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/union.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/union.c -emit-llvm -o -
    RUN(TestState.Failed, "%clang_cc1 %s -emit-llvm -o -");
  }

  @Test
  public void test_union_align_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/union-align.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/union-align.c -o - | grep load | grep '4 x float' | not grep 'align 4'
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm %s -o -")./*|*/
      I("grep load")./*|*/
      I("grep \"4 x float\"")./*|*/
      I("not grep \"align 4\"");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/union-align.c -o - | grep load | grep '4 x float' | grep 'align 16'
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm %s -o -")./*|*/
      I("grep load")./*|*/
      I("grep \"4 x float\"")./*|*/
      I("grep \"align 16\"");
  }

  @Test
  public void test_union_init_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/union-init.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm < ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/union-init.c -o -
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm < %s -o -");
  }

  @Test
  public void test_union_init2_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/union-init2.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/union-init2.c -o - -triple i686-pc-linux-gnu | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/union-init2.c
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm %s -o - -triple i686-pc-linux-gnu")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_unreachable_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/unreachable.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/unreachable.c | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/unreachable.c
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm -o - %s")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_unsigned_overflow_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/unsigned-overflow.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-apple-darwin10 -fsanitize=unsigned-integer-overflow ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/unsigned-overflow.c -emit-llvm -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/unsigned-overflow.c
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-apple-darwin10 -fsanitize=unsigned-integer-overflow %s -emit-llvm -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_unsigned_promotion_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/unsigned-promotion.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-apple-darwin10 -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/unsigned-promotion.c -fsanitize=signed-integer-overflow | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/unsigned-promotion.c --check-prefix=CHECKS
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-apple-darwin10 -emit-llvm -o - %s -fsanitize=signed-integer-overflow")./*|*/
      I("FileCheck %s --check-prefix=CHECKS");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-apple-darwin10 -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/unsigned-promotion.c -fsanitize=unsigned-integer-overflow | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/unsigned-promotion.c --check-prefix=CHECKU
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-apple-darwin10 -emit-llvm -o - %s -fsanitize=unsigned-integer-overflow")./*|*/
      I("FileCheck %s --check-prefix=CHECKU");
  }

  @Test
  public void test_unsigned_trapv_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/unsigned-trapv.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-apple-darwin ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/unsigned-trapv.c -emit-llvm -o - -fsanitize=unsigned-integer-overflow | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/unsigned-trapv.c --check-prefix=UNSIGNED
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-apple-darwin %s -emit-llvm -o - -fsanitize=unsigned-integer-overflow")./*|*/
      I("FileCheck %s --check-prefix=UNSIGNED");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-apple-darwin ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/unsigned-trapv.c -emit-llvm -o - -ftrapv | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/unsigned-trapv.c --check-prefix=TRAPV
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-apple-darwin %s -emit-llvm -o - -ftrapv")./*|*/
      I("FileCheck %s --check-prefix=TRAPV");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-apple-darwin ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/unsigned-trapv.c -emit-llvm -o - -fsanitize=unsigned-integer-overflow -ftrapv | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/unsigned-trapv.c --check-prefix=BOTH
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-apple-darwin %s -emit-llvm -o - -fsanitize=unsigned-integer-overflow -ftrapv")./*|*/
      I("FileCheck %s --check-prefix=BOTH");
  }

  @Test
  public void test_unwind_attr_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/unwind-attr.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i386-unknown-unknown -fexceptions -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/unwind-attr.c | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/unwind-attr.c
    RUN(TestState.Failed, "%clang_cc1 -triple i386-unknown-unknown -fexceptions -emit-llvm -o - %s")./*|*/
      I("FileCheck %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i386-unknown-unknown -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/unwind-attr.c | ${LLVM_SRC}/build/bin/FileCheck -check-prefix CHECK-NOEXC ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/unwind-attr.c
    RUN(TestState.Failed, "%clang_cc1 -triple i386-unknown-unknown -emit-llvm -o - %s")./*|*/
      I("FileCheck -check-prefix CHECK-NOEXC %s");
  }

  @Test
  public void test_utf16_cfstrings_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/utf16-cfstrings.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-apple-darwin -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/utf16-cfstrings.c -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/utf16-cfstrings.c
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-apple-darwin -emit-llvm %s -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_varargs_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/varargs.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i386-unknown-unknown -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/varargs.c | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/varargs.c
    RUN(TestState.Failed, "%clang_cc1 -triple i386-unknown-unknown -emit-llvm -o - %s")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_variable_array_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/variable-array.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm < ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/variable-array.c | grep puts | ${LLVM_SRC}/build/bin/count 4
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm < %s")./*|*/
      I("grep puts")./*|*/
      I("count 4");
  }

  @Test
  public void test_variadic_gpfp_x86_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/variadic-gpfp-x86.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-unknown-linux-gnu -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/variadic-gpfp-x86.c -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/variadic-gpfp-x86.c
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-unknown-linux-gnu -emit-llvm %s -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_variadic_null_win64_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/variadic-null-win64.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/variadic-null-win64.c -emit-llvm -o - -triple x86_64-windows-msvc | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/variadic-null-win64.c --check-prefix=WINDOWS
    RUN(TestState.Failed, "%clang_cc1 %s -emit-llvm -o - -triple x86_64-windows-msvc")./*|*/
      I("FileCheck %s --check-prefix=WINDOWS");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/variadic-null-win64.c -emit-llvm -o - -triple x86_64-linux | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/variadic-null-win64.c --check-prefix=LINUX
    RUN(TestState.Failed, "%clang_cc1 %s -emit-llvm -o - -triple x86_64-linux")./*|*/
      I("FileCheck %s --check-prefix=LINUX");
  }

  @Test
  public void test_vector_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/vector.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i386-apple-darwin9 -O1 -target-cpu core2 -debug-info-kind=limited -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/vector.c -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/vector.c
    RUN(TestState.Failed, "%clang_cc1 -triple i386-apple-darwin9 -O1 -target-cpu core2 -debug-info-kind=limited -emit-llvm %s -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_vector_alignment_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/vector-alignment.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -w -triple x86_64-apple-darwin10 -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/vector-alignment.c | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/vector-alignment.c --check-prefix=ALL --check-prefix=SSE
    RUN(TestState.Failed, "%clang_cc1 -w -triple x86_64-apple-darwin10 -emit-llvm -o - %s")./*|*/
      I("FileCheck %s --check-prefix=ALL --check-prefix=SSE");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -w -triple i386-apple-darwin10 -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/vector-alignment.c | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/vector-alignment.c --check-prefix=ALL --check-prefix=SSE
    RUN(TestState.Failed, "%clang_cc1 -w -triple   i386-apple-darwin10 -emit-llvm -o - %s")./*|*/
      I("FileCheck %s --check-prefix=ALL --check-prefix=SSE");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -w -triple x86_64-apple-darwin10 -target-feature +avx -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/vector-alignment.c | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/vector-alignment.c --check-prefix=ALL --check-prefix=AVX
    RUN(TestState.Failed, "%clang_cc1 -w -triple x86_64-apple-darwin10 -target-feature +avx -emit-llvm -o - %s")./*|*/
      I("FileCheck %s --check-prefix=ALL --check-prefix=AVX");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -w -triple i386-apple-darwin10 -target-feature +avx -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/vector-alignment.c | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/vector-alignment.c --check-prefix=ALL --check-prefix=AVX
    RUN(TestState.Failed, "%clang_cc1 -w -triple   i386-apple-darwin10 -target-feature +avx -emit-llvm -o - %s")./*|*/
      I("FileCheck %s --check-prefix=ALL --check-prefix=AVX");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -w -triple x86_64-apple-darwin10 -target-feature +avx512f -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/vector-alignment.c | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/vector-alignment.c --check-prefix=ALL --check-prefix=AVX512
    RUN(TestState.Failed, "%clang_cc1 -w -triple x86_64-apple-darwin10 -target-feature +avx512f -emit-llvm -o - %s")./*|*/
      I("FileCheck %s --check-prefix=ALL --check-prefix=AVX512");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -w -triple i386-apple-darwin10 -target-feature +avx512f -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/vector-alignment.c | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/vector-alignment.c --check-prefix=ALL --check-prefix=AVX512
    RUN(TestState.Failed, "%clang_cc1 -w -triple   i386-apple-darwin10 -target-feature +avx512f -emit-llvm -o - %s")./*|*/
      I("FileCheck %s --check-prefix=ALL --check-prefix=AVX512");
  }

  @Test
  public void test_vectorcall_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/vectorcall.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/vectorcall.c -o - -triple=i386-pc-win32 | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/vectorcall.c
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm %s -o - -triple=i386-pc-win32")./*|*/
      I("FileCheck %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/vectorcall.c -o - -triple=x86_64-pc-win32 | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/vectorcall.c --check-prefix=X64
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm %s -o - -triple=x86_64-pc-win32")./*|*/
      I("FileCheck %s --check-prefix=X64");
  }

  @Test
  public void test_vfprintf_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/vfprintf.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm-only ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/vfprintf.c
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm-only %s");
  }

  @Test
  public void test_visibility_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/visibility.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/visibility.c -triple i386-unknown-unknown -fvisibility default -emit-llvm -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/visibility.c -check-prefix=CHECK-DEFAULT
    RUN(TestState.Failed, "%clang_cc1 %s -triple i386-unknown-unknown -fvisibility default -emit-llvm -o -")./*|*/
      I("FileCheck %s -check-prefix=CHECK-DEFAULT");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/visibility.c -triple i386-unknown-unknown -fvisibility protected -emit-llvm -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/visibility.c -check-prefix=CHECK-PROTECTED
    RUN(TestState.Failed, "%clang_cc1 %s -triple i386-unknown-unknown -fvisibility protected -emit-llvm -o -")./*|*/
      I("FileCheck %s -check-prefix=CHECK-PROTECTED");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/visibility.c -triple i386-unknown-unknown -fvisibility hidden -emit-llvm -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/visibility.c -check-prefix=CHECK-HIDDEN
    RUN(TestState.Failed, "%clang_cc1 %s -triple i386-unknown-unknown -fvisibility hidden -emit-llvm -o -")./*|*/
      I("FileCheck %s -check-prefix=CHECK-HIDDEN");
  }

  @Test
  public void test_vla_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/vla.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i386-unknown-unknown ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/vla.c -emit-llvm -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/vla.c
    RUN(TestState.Failed, "%clang_cc1 -triple i386-unknown-unknown %s -emit-llvm -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_vla_2_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/vla-2.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=gnu99 ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/vla-2.c -emit-llvm -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/vla-2.c
    RUN(TestState.Failed, "%clang_cc1 -std=gnu99 %s -emit-llvm -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_vla_3_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/vla-3.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=gnu99 ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/vla-3.c -emit-llvm -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/vla-3.c
    RUN(TestState.Failed, "%clang_cc1 -std=gnu99 %s -emit-llvm -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_vla_4_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/vla-4.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i386-unknown-unknown ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/vla-4.c -emit-llvm -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/vla-4.c
    RUN(TestState.Failed, "%clang_cc1 -triple i386-unknown-unknown %s -emit-llvm -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_vld_dup_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/vld_dup.c");
    // REQUIRES: arm-registered-target
    if (!CHECK_REQUIRES("arm-registered-target")) {
      return;
    }
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple armv7a-linux-gnueabi -target-cpu cortex-a8 -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/vld_dup.c | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/vld_dup.c
    RUN(TestState.Failed, "%clang_cc1 -triple armv7a-linux-gnueabi -target-cpu cortex-a8 -emit-llvm -o - %s")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_vlt_to_pointer_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/vlt_to_pointer.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/vlt_to_pointer.c -emit-llvm -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/vlt_to_pointer.c
    RUN(TestState.Failed, "%clang_cc1 %s -emit-llvm -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_volatile_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/volatile.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple=i386-pc-solaris2.11 -emit-llvm < ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/volatile.c | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/volatile.c -check-prefix CHECK -check-prefix CHECK-IT
    RUN(TestState.Failed, "%clang_cc1 -triple=%itanium_abi_triple -emit-llvm < %s")./*|*/
      I("FileCheck %s -check-prefix CHECK -check-prefix CHECK-IT");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple=i386-pc-win32 -emit-llvm < ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/volatile.c | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/volatile.c -check-prefix CHECK -check-prefix CHECK-MS
    RUN(TestState.Failed, "%clang_cc1 -triple=%ms_abi_triple -emit-llvm < %s")./*|*/
      I("FileCheck %s -check-prefix CHECK -check-prefix CHECK-MS");
  }

  @Test
  public void test_volatile_1_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/volatile-1.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -Wno-return-type -Wno-unused-value -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/volatile-1.c -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/volatile-1.c
    RUN(TestState.Failed, "%clang_cc1 -Wno-return-type -Wno-unused-value -emit-llvm %s -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_volatile_2_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/volatile-2.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-apple-darwin10 -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/volatile-2.c | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/volatile-2.c
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-apple-darwin10 -emit-llvm -o - %s")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_volatile_complex_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/volatile-complex.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-unknown-unknown -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/volatile-complex.c -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/volatile-complex.c
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-unknown-unknown -emit-llvm %s -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_wasm_arguments_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/wasm-arguments.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple wasm32-unknown-unknown ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/wasm-arguments.c -emit-llvm -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/wasm-arguments.c -check-prefix=WEBASSEMBLY32
    RUN(TestState.Failed, "%clang_cc1 -triple wasm32-unknown-unknown %s -emit-llvm -o -")./*|*/
      I("FileCheck %s -check-prefix=WEBASSEMBLY32");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple wasm64-unknown-unknown ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/wasm-arguments.c -emit-llvm -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/wasm-arguments.c -check-prefix=WEBASSEMBLY64
    RUN(TestState.Failed, "%clang_cc1 -triple wasm64-unknown-unknown %s -emit-llvm -o -")./*|*/
      I("FileCheck %s -check-prefix=WEBASSEMBLY64");
  }

  @Test
  public void test_wasm_regparm_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/wasm-regparm.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple wasm32-unknown-unknown ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/wasm-regparm.c -fsyntax-only -verify
    RUN(TestState.Failed, "%clang_cc1 -triple wasm32-unknown-unknown %s -fsyntax-only -verify");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple wasm64-unknown-unknown ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/wasm-regparm.c -fsyntax-only -verify
    RUN(TestState.Failed, "%clang_cc1 -triple wasm64-unknown-unknown %s -fsyntax-only -verify");
  }

  @Test
  public void test_wasm_varargs_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/wasm-varargs.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple wasm32-unknown-unknown -o - -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/wasm-varargs.c | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/wasm-varargs.c
    RUN(TestState.Failed, "%clang_cc1 -triple wasm32-unknown-unknown -o - -emit-llvm %s")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_wchar_const_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/wchar-const.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/wchar-const.c -o - -triple i386-pc-win32 | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/wchar-const.c --check-prefix=CHECK-WIN
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm %s -o - -triple i386-pc-win32")./*|*/
      I("FileCheck %s --check-prefix=CHECK-WIN");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/wchar-const.c -o - -triple x86_64-apple-darwin | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/wchar-const.c --check-prefix=CHECK-DAR
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm %s -o - -triple x86_64-apple-darwin")./*|*/
      I("FileCheck %s --check-prefix=CHECK-DAR");
  }

  @Test
  public void test_weak_global_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/weak-global.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm < ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/weak-global.c | grep common
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm < %s")./*|*/
      I("grep common");
  }

  @Test
  public void test_weak_incomplete_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/weak-incomplete.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm < ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/weak-incomplete.c | grep extern_weak | ${LLVM_SRC}/build/bin/count 1
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm < %s")./*|*/
      I("grep 'extern_weak'")./*|*/
      I("count 1");
  }

  @Test
  public void test_weak_constant_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/weak_constant.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -w -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/weak_constant.c -O1 -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/weak_constant.c
    RUN(TestState.Failed, "%clang_cc1 -w -emit-llvm %s -O1 -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_whilestmt_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/whilestmt.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/whilestmt.c -emit-llvm -o -
    RUN(TestState.Failed, "%clang_cc1 %s -emit-llvm -o -");
  }

  @Test
  public void test_windows_itanium_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/windows-itanium.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i686-windows-itanium -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/windows-itanium.c -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/windows-itanium.c -check-prefix CHECK-C -check-prefix CHECK
    RUN(TestState.Failed, "%clang_cc1 -triple i686-windows-itanium -emit-llvm %s -o -")./*|*/
      I("FileCheck %s -check-prefix CHECK-C -check-prefix CHECK");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i686-windows-itanium -emit-llvm -x c++ ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/windows-itanium.c -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/windows-itanium.c -check-prefix CHECK-CXX -check-prefix CHECK
    RUN(TestState.Failed, "%clang_cc1 -triple i686-windows-itanium -emit-llvm -x c++ %s -o -")./*|*/
      I("FileCheck %s -check-prefix CHECK-CXX -check-prefix CHECK");
  }

  @Test
  public void test_windows_on_arm_dllimport_dllexport_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/windows-on-arm-dllimport-dllexport.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -Werror -triple thumbv7-windows-itanium -mfloat-abi hard -fms-extensions -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/windows-on-arm-dllimport-dllexport.c -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/windows-on-arm-dllimport-dllexport.c
    RUN(TestState.Failed, "%clang_cc1 -Werror -triple thumbv7-windows-itanium -mfloat-abi hard -fms-extensions -emit-llvm %s -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_windows_on_arm_stack_probe_size_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/windows-on-arm-stack-probe-size.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple thumbv7-windows-itanium -mstack-probe-size=8096 -fms-extensions -O2 -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/windows-on-arm-stack-probe-size.c -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/windows-on-arm-stack-probe-size.c -check-prefix CHECK-8096
    RUN(TestState.Failed, "%clang_cc1 -triple thumbv7-windows-itanium -mstack-probe-size=8096 -fms-extensions -O2 -emit-llvm %s -o -")./*|*/
      I("FileCheck %s -check-prefix CHECK-8096");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple thumbv7-windows-itanium -mstack-probe-size=4096 -fms-extensions -O2 -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/windows-on-arm-stack-probe-size.c -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/windows-on-arm-stack-probe-size.c -check-prefix CHECK-4096
    RUN(TestState.Failed, "%clang_cc1 -triple thumbv7-windows-itanium -mstack-probe-size=4096 -fms-extensions -O2 -emit-llvm %s -o -")./*|*/
      I("FileCheck %s -check-prefix CHECK-4096");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple thumbv7-windows-itanium -fms-extensions -O2 -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/windows-on-arm-stack-probe-size.c -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/windows-on-arm-stack-probe-size.c -check-prefix CHECK
    RUN(TestState.Failed, "%clang_cc1 -triple thumbv7-windows-itanium -fms-extensions -O2 -emit-llvm %s -o -")./*|*/
      I("FileCheck %s -check-prefix CHECK");
  }

  @Test
  public void test_windows_on_arm_tls_support_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/windows-on-arm-tls-support.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple thumbv7--windows -fms-extensions -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/windows-on-arm-tls-support.c
    RUN(TestState.Failed, "%clang_cc1 -triple thumbv7--windows -fms-extensions -fsyntax-only -verify %s");
  }

  @Test
  public void test_windows_struct_abi_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/windows-struct-abi.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i686-windows-itanium -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/windows-struct-abi.c | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/windows-struct-abi.c
    RUN(TestState.Failed, "%clang_cc1 -triple i686-windows-itanium -emit-llvm -o - %s")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_wrapv_lshr_sanitize_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/wrapv-lshr-sanitize.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsanitize=shift-base -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/wrapv-lshr-sanitize.c -o - -triple x86_64-linux-gnu -fwrapv | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/wrapv-lshr-sanitize.c
    RUN(TestState.Failed, "%clang_cc1 -fsanitize=shift-base -emit-llvm %s -o - -triple x86_64-linux-gnu -fwrapv")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_writable_strings_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/writable-strings.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm -o - -fwritable-strings ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/writable-strings.c
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm -o - -fwritable-strings %s");
  }

  @Test
  public void test_x86_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/x86.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/x86.c -triple=i686-pc-linux-gnu -emit-llvm -o - > ${TEST_TEMP_DIR}/x86.c.tmp1
    RUN(TestState.Failed, "%clang_cc1 %s -triple=i686-pc-linux-gnu -emit-llvm -o - > %t1");
    // grep ax ${TEST_TEMP_DIR}/x86.c.tmp1
    RUN(TestState.Failed, "grep \"ax\" %t1");
    // grep bx ${TEST_TEMP_DIR}/x86.c.tmp1
    RUN(TestState.Failed, "grep \"bx\" %t1");
    // grep cx ${TEST_TEMP_DIR}/x86.c.tmp1
    RUN(TestState.Failed, "grep \"cx\" %t1");
    // grep dx ${TEST_TEMP_DIR}/x86.c.tmp1
    RUN(TestState.Failed, "grep \"dx\" %t1");
    // grep di ${TEST_TEMP_DIR}/x86.c.tmp1
    RUN(TestState.Failed, "grep \"di\" %t1");
    // grep si ${TEST_TEMP_DIR}/x86.c.tmp1
    RUN(TestState.Failed, "grep \"si\" %t1");
    // grep st ${TEST_TEMP_DIR}/x86.c.tmp1
    RUN(TestState.Failed, "grep \"st\" %t1");
    // grep 'st(1)' ${TEST_TEMP_DIR}/x86.c.tmp1
    RUN(TestState.Failed, "grep \"st(1)\" %t1");
  }

  @Test
  public void test_x86_64_inline_asm_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/x86-64-inline-asm.c");
    // REQUIRES: x86-registered-target
    if (!CHECK_REQUIRES("x86-registered-target")) {
      return;
    }
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64 ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/x86-64-inline-asm.c -S -o /dev/null -DWARN -verify
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64 %s -S -o /dev/null -DWARN -verify");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64 ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/x86-64-inline-asm.c -S -o /dev/null -Werror -verify
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64 %s -S -o /dev/null -Werror -verify");
  }

  @Test
  public void test_x86_atomic_long_double_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/x86-atomic-long_double.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-linux-gnu -target-cpu core2 ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/x86-atomic-long_double.c -S -emit-llvm -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/x86-atomic-long_double.c
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-linux-gnu -target-cpu core2 %s -S -emit-llvm -o -")./*|*/
      I("FileCheck %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i686-linux-gnu -target-cpu core2 ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/x86-atomic-long_double.c -S -emit-llvm -o - | ${LLVM_SRC}/build/bin/FileCheck -check-prefix=CHECK32 ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/x86-atomic-long_double.c
    RUN(TestState.Failed, "%clang_cc1 -triple i686-linux-gnu -target-cpu core2 %s -S -emit-llvm -o -")./*|*/
      I("FileCheck -check-prefix=CHECK32 %s");
  }

  @Test
  public void test_x86_soft_float_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/x86-soft-float.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i386-unknown-unknown -mregparm 3 -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/x86-soft-float.c -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/x86-soft-float.c -check-prefix=HARD
    RUN(TestState.Failed, "%clang_cc1 -triple i386-unknown-unknown -mregparm 3 -emit-llvm %s -o -")./*|*/
      I("FileCheck %s -check-prefix=HARD");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i386-unknown-unknown -mregparm 3 -mfloat-abi soft -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/x86-soft-float.c -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/x86-soft-float.c -check-prefix=SOFT
    RUN(TestState.Failed, "%clang_cc1 -triple i386-unknown-unknown -mregparm 3 -mfloat-abi soft -emit-llvm %s -o -")./*|*/
      I("FileCheck %s -check-prefix=SOFT");
  }

  @Test
  public void test_x86_32_arguments_darwin_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/x86_32-arguments-darwin.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -w -fblocks -triple i386-apple-darwin9 -target-cpu yonah -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/x86_32-arguments-darwin.c | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/x86_32-arguments-darwin.c
    RUN(TestState.Failed, "%clang_cc1 -w -fblocks -triple i386-apple-darwin9 -target-cpu yonah -emit-llvm -o - %s")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_x86_32_arguments_iamcu_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/x86_32-arguments-iamcu.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -w -triple i386-pc-elfiamcu -mfloat-abi soft -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/x86_32-arguments-iamcu.c | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/x86_32-arguments-iamcu.c
    RUN(TestState.Failed, "%clang_cc1 -w -triple i386-pc-elfiamcu -mfloat-abi soft -emit-llvm -o - %s")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_x86_32_arguments_linux_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/x86_32-arguments-linux.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -w -fblocks -triple i386-pc-linux-gnu -target-cpu pentium4 -emit-llvm -o ${TEST_TEMP_DIR}/x86_32-arguments-linux.c.tmp ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/x86_32-arguments-linux.c
    RUN(TestState.Failed, "%clang_cc1 -w -fblocks -triple i386-pc-linux-gnu -target-cpu pentium4 -emit-llvm -o %t %s");
    // ${LLVM_SRC}/build/bin/FileCheck < ${TEST_TEMP_DIR}/x86_32-arguments-linux.c.tmp ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/x86_32-arguments-linux.c
    RUN(TestState.Failed, "FileCheck < %t %s");
  }

  @Test
  public void test_x86_32_arguments_nommx_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/x86_32-arguments-nommx.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -target-feature -mmx -target-feature +sse2 -triple i686-pc-linux-gnu -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/x86_32-arguments-nommx.c | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/x86_32-arguments-nommx.c
    RUN(TestState.Failed, "%clang_cc1 -target-feature -mmx -target-feature +sse2 -triple i686-pc-linux-gnu -emit-llvm -o - %s")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_x86_32_arguments_realign_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/x86_32-arguments-realign.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -w -fblocks -triple i386-apple-darwin9 -emit-llvm -o ${TEST_TEMP_DIR}/x86_32-arguments-realign.c.tmp ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/x86_32-arguments-realign.c
    RUN(TestState.Failed, "%clang_cc1 -w -fblocks -triple i386-apple-darwin9 -emit-llvm -o %t %s");
    // ${LLVM_SRC}/build/bin/FileCheck < ${TEST_TEMP_DIR}/x86_32-arguments-realign.c.tmp ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/x86_32-arguments-realign.c
    RUN(TestState.Failed, "FileCheck < %t %s");
  }

  @Test
  public void test_x86_32_arguments_win32_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/x86_32-arguments-win32.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -w -triple i386-pc-win32 -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/x86_32-arguments-win32.c | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/x86_32-arguments-win32.c
    RUN(TestState.Failed, "%clang_cc1 -w -triple i386-pc-win32 -emit-llvm -o - %s")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_x86_32_fpcc_struct_return_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/x86_32-fpcc-struct-return.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i386-apple-darwin9 -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/x86_32-fpcc-struct-return.c | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/x86_32-fpcc-struct-return.c --check-prefix=CHECK-REG
    RUN(TestState.Failed, "%clang_cc1 -triple i386-apple-darwin9 -emit-llvm -o - %s")./*|*/
      I("FileCheck %s --check-prefix=CHECK-REG");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i386-apple-darwin9 -fpcc-struct-return -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/x86_32-fpcc-struct-return.c | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/x86_32-fpcc-struct-return.c --check-prefix=CHECK-PCC
    RUN(TestState.Failed, "%clang_cc1 -triple i386-apple-darwin9 -fpcc-struct-return -emit-llvm -o - %s")./*|*/
      I("FileCheck %s --check-prefix=CHECK-PCC");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i386-apple-darwin9 -freg-struct-return -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/x86_32-fpcc-struct-return.c | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/x86_32-fpcc-struct-return.c --check-prefix=CHECK-REG
    RUN(TestState.Failed, "%clang_cc1 -triple i386-apple-darwin9 -freg-struct-return -emit-llvm -o - %s")./*|*/
      I("FileCheck %s --check-prefix=CHECK-REG");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i386-pc-linux-gnu -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/x86_32-fpcc-struct-return.c | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/x86_32-fpcc-struct-return.c --check-prefix=CHECK-PCC
    RUN(TestState.Failed, "%clang_cc1 -triple i386-pc-linux-gnu -emit-llvm -o - %s")./*|*/
      I("FileCheck %s --check-prefix=CHECK-PCC");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i386-pc-linux-gnu -fpcc-struct-return -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/x86_32-fpcc-struct-return.c | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/x86_32-fpcc-struct-return.c --check-prefix=CHECK-PCC
    RUN(TestState.Failed, "%clang_cc1 -triple i386-pc-linux-gnu -fpcc-struct-return -emit-llvm -o - %s")./*|*/
      I("FileCheck %s --check-prefix=CHECK-PCC");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i386-pc-linux-gnu -freg-struct-return -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/x86_32-fpcc-struct-return.c | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/x86_32-fpcc-struct-return.c --check-prefix=CHECK-REG
    RUN(TestState.Failed, "%clang_cc1 -triple i386-pc-linux-gnu -freg-struct-return -emit-llvm -o - %s")./*|*/
      I("FileCheck %s --check-prefix=CHECK-REG");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i386-pc-win32 -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/x86_32-fpcc-struct-return.c | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/x86_32-fpcc-struct-return.c --check-prefix=CHECK-REG
    RUN(TestState.Failed, "%clang_cc1 -triple i386-pc-win32 -emit-llvm -o - %s")./*|*/
      I("FileCheck %s --check-prefix=CHECK-REG");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i386-pc-win32 -fpcc-struct-return -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/x86_32-fpcc-struct-return.c | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/x86_32-fpcc-struct-return.c --check-prefix=CHECK-PCC
    RUN(TestState.Failed, "%clang_cc1 -triple i386-pc-win32 -fpcc-struct-return -emit-llvm -o - %s")./*|*/
      I("FileCheck %s --check-prefix=CHECK-PCC");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i386-pc-win32 -freg-struct-return -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/x86_32-fpcc-struct-return.c | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/x86_32-fpcc-struct-return.c --check-prefix=CHECK-REG
    RUN(TestState.Failed, "%clang_cc1 -triple i386-pc-win32 -freg-struct-return -emit-llvm -o - %s")./*|*/
      I("FileCheck %s --check-prefix=CHECK-REG");
  }

  @Test
  public void test_x86_32_inline_asm_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/x86_32-inline-asm.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i386-apple-darwin9 -verify ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/x86_32-inline-asm.c
    RUN(TestState.Failed, "%clang_cc1 -triple i386-apple-darwin9 -verify %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i386-apple-darwin9 -target-feature +avx -verify ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/x86_32-inline-asm.c
    RUN(TestState.Failed, "%clang_cc1 -triple i386-apple-darwin9 -target-feature +avx -verify %s");
  }

  @Test
  public void test_x86_32_xsave_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/x86_32-xsave.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/x86_32-xsave.c -DTEST_XSAVE -O0 -triple=i686-unknown-unknown -target-feature +xsave -emit-llvm -o - -Werror | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/x86_32-xsave.c --check-prefix=XSAVE
    RUN(TestState.Failed, "%clang_cc1 %s -DTEST_XSAVE -O0 -triple=i686-unknown-unknown -target-feature +xsave -emit-llvm -o - -Werror")./*|*/
      I("FileCheck %s --check-prefix=XSAVE");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/x86_32-xsave.c -DTEST_XSAVE -O0 -triple=i686-unknown-unknown -target-feature +xsave -fno-signed-char -emit-llvm -o - -Werror | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/x86_32-xsave.c --check-prefix=XSAVE
    RUN(TestState.Failed, "%clang_cc1 %s -DTEST_XSAVE -O0 -triple=i686-unknown-unknown -target-feature +xsave -fno-signed-char -emit-llvm -o - -Werror")./*|*/
      I("FileCheck %s --check-prefix=XSAVE");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/x86_32-xsave.c -DTEST_XSAVEOPT -O0 -triple=i686-unknown-unknown -target-feature +xsave -target-feature +xsaveopt -emit-llvm -o - -Werror | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/x86_32-xsave.c --check-prefix=XSAVEOPT
    RUN(TestState.Failed, "%clang_cc1 %s -DTEST_XSAVEOPT -O0 -triple=i686-unknown-unknown -target-feature +xsave -target-feature +xsaveopt -emit-llvm -o - -Werror")./*|*/
      I("FileCheck %s --check-prefix=XSAVEOPT");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/x86_32-xsave.c -DTEST_XSAVEOPT -O0 -triple=i686-unknown-unknown -target-feature +xsave -target-feature +xsaveopt -fno-signed-char -emit-llvm -o - -Werror | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/x86_32-xsave.c --check-prefix=XSAVEOPT
    RUN(TestState.Failed, "%clang_cc1 %s -DTEST_XSAVEOPT -O0 -triple=i686-unknown-unknown -target-feature +xsave -target-feature +xsaveopt -fno-signed-char -emit-llvm -o - -Werror")./*|*/
      I("FileCheck %s --check-prefix=XSAVEOPT");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/x86_32-xsave.c -DTEST_XSAVEC -O0 -triple=i686-unknown-unknown -target-feature +xsave -target-feature +xsavec -emit-llvm -o - -Werror | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/x86_32-xsave.c --check-prefix=XSAVEC
    RUN(TestState.Failed, "%clang_cc1 %s -DTEST_XSAVEC -O0 -triple=i686-unknown-unknown -target-feature +xsave -target-feature +xsavec -emit-llvm -o - -Werror")./*|*/
      I("FileCheck %s --check-prefix=XSAVEC");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/x86_32-xsave.c -DTEST_XSAVEC -O0 -triple=i686-unknown-unknown -target-feature +xsave -target-feature +xsavec -fno-signed-char -emit-llvm -o - -Werror | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/x86_32-xsave.c --check-prefix=XSAVEC
    RUN(TestState.Failed, "%clang_cc1 %s -DTEST_XSAVEC -O0 -triple=i686-unknown-unknown -target-feature +xsave -target-feature +xsavec -fno-signed-char -emit-llvm -o - -Werror")./*|*/
      I("FileCheck %s --check-prefix=XSAVEC");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/x86_32-xsave.c -DTEST_XSAVES -O0 -triple=i686-unknown-unknown -target-feature +xsave -target-feature +xsaves -emit-llvm -o - -Werror | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/x86_32-xsave.c --check-prefix=XSAVES
    RUN(TestState.Failed, "%clang_cc1 %s -DTEST_XSAVES -O0 -triple=i686-unknown-unknown -target-feature +xsave -target-feature +xsaves -emit-llvm -o - -Werror")./*|*/
      I("FileCheck %s --check-prefix=XSAVES");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/x86_32-xsave.c -DTEST_XSAVES -O0 -triple=i686-unknown-unknown -target-feature +xsave -target-feature +xsaves -fno-signed-char -emit-llvm -o - -Werror | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/x86_32-xsave.c --check-prefix=XSAVES
    RUN(TestState.Failed, "%clang_cc1 %s -DTEST_XSAVES -O0 -triple=i686-unknown-unknown -target-feature +xsave -target-feature +xsaves -fno-signed-char -emit-llvm -o - -Werror")./*|*/
      I("FileCheck %s --check-prefix=XSAVES");
  }

  @Test
  public void test_x86_64_arguments_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/x86_64-arguments.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-unknown-unknown -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/x86_64-arguments.c | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/x86_64-arguments.c -check-prefix=CHECK -check-prefix=SSE -check-prefix=NO-AVX512
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-unknown-unknown -emit-llvm -o - %s")./*|*/
      I("FileCheck %s -check-prefix=CHECK -check-prefix=SSE -check-prefix=NO-AVX512");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-unknown-unknown -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/x86_64-arguments.c -target-feature +avx | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/x86_64-arguments.c -check-prefix=CHECK -check-prefix=AVX -check-prefix=NO-AVX512
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-unknown-unknown -emit-llvm -o - %s -target-feature +avx")./*|*/
      I("FileCheck %s -check-prefix=CHECK -check-prefix=AVX -check-prefix=NO-AVX512");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-unknown-unknown -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/x86_64-arguments.c -target-feature +avx512f | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/x86_64-arguments.c -check-prefix=CHECK -check-prefix=AVX -check-prefix=AVX512
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-unknown-unknown -emit-llvm -o - %s -target-feature +avx512f")./*|*/
      I("FileCheck %s -check-prefix=CHECK -check-prefix=AVX -check-prefix=AVX512");
  }

  @Test
  public void test_x86_64_arguments_darwin_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/x86_64-arguments-darwin.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-apple-darwin -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/x86_64-arguments-darwin.c| ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/x86_64-arguments-darwin.c
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-apple-darwin -emit-llvm -o - %s")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_x86_64_arguments_nacl_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/x86_64-arguments-nacl.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-unknown-nacl -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/x86_64-arguments-nacl.c| ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/x86_64-arguments-nacl.c
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-unknown-nacl -emit-llvm -o - %s")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_x86_64_arguments_win32_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/x86_64-arguments-win32.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -w -triple x86_64-pc-win32 -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/x86_64-arguments-win32.c | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/x86_64-arguments-win32.c
    RUN(TestState.Failed, "%clang_cc1 -w -triple x86_64-pc-win32 -emit-llvm -o - %s")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_x86_64_atomic_128_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/x86_64-atomic-128.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-linux-gnu -target-cpu core2 ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/x86_64-atomic-128.c -S -emit-llvm -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/x86_64-atomic-128.c
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-linux-gnu -target-cpu core2 %s -S -emit-llvm -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_x86_64_longdouble_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/x86_64-longdouble.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-linux-android -emit-llvm -O -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/x86_64-longdouble.c | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/x86_64-longdouble.c --check-prefix=ANDROID --check-prefix=CHECK
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-linux-android -emit-llvm -O -o - %s")./*|*/
      I("FileCheck %s --check-prefix=ANDROID --check-prefix=CHECK");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-linux-gnu -emit-llvm -O -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/x86_64-longdouble.c | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/x86_64-longdouble.c --check-prefix=GNU --check-prefix=CHECK
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-linux-gnu -emit-llvm -O -o - %s")./*|*/
      I("FileCheck %s --check-prefix=GNU --check-prefix=CHECK");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64 -emit-llvm -O -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/x86_64-longdouble.c | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/x86_64-longdouble.c --check-prefix=GNU --check-prefix=CHECK
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64 -emit-llvm -O -o - %s")./*|*/
      I("FileCheck %s --check-prefix=GNU --check-prefix=CHECK");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-nacl -emit-llvm -O -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/x86_64-longdouble.c | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/x86_64-longdouble.c --check-prefix=NACL --check-prefix=CHECK
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-nacl -emit-llvm -O -o - %s")./*|*/
      I("FileCheck %s --check-prefix=NACL --check-prefix=CHECK");
  }

  @Test
  public void test_x86_64_profiling_keep_fp_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/x86_64-profiling-keep-fp.c");
    // REQUIRES: x86-registered-target
    if (!CHECK_REQUIRES("x86-registered-target")) {
      return;
    }
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-unknown-unknown -O3 -pg -S -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/x86_64-profiling-keep-fp.c | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/x86_64-profiling-keep-fp.c
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-unknown-unknown -O3 -pg -S -o - %s")./*|*/
      I("FileCheck %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-unknown-unknown -O3 -momit-leaf-frame-pointer -pg -S -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/x86_64-profiling-keep-fp.c | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/x86_64-profiling-keep-fp.c
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-unknown-unknown -O3 -momit-leaf-frame-pointer -pg -S -o - %s")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_x86_64_xsave_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/x86_64-xsave.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/x86_64-xsave.c -DTEST_XSAVE -O0 -triple=x86_64-unknown-unknown -target-feature +xsave -emit-llvm -o - -Werror | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/x86_64-xsave.c --check-prefix=XSAVE
    RUN(TestState.Failed, "%clang_cc1 %s -DTEST_XSAVE -O0 -triple=x86_64-unknown-unknown -target-feature +xsave -emit-llvm -o - -Werror")./*|*/
      I("FileCheck %s --check-prefix=XSAVE");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/x86_64-xsave.c -DTEST_XSAVE -O0 -triple=x86_64-unknown-unknown -target-feature +xsave -fno-signed-char -emit-llvm -o - -Werror | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/x86_64-xsave.c --check-prefix=XSAVE
    RUN(TestState.Failed, "%clang_cc1 %s -DTEST_XSAVE -O0 -triple=x86_64-unknown-unknown -target-feature +xsave -fno-signed-char -emit-llvm -o - -Werror")./*|*/
      I("FileCheck %s --check-prefix=XSAVE");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/x86_64-xsave.c -DTEST_XSAVEOPT -O0 -triple=x86_64-unknown-unknown -target-feature +xsave -target-feature +xsaveopt -emit-llvm -o - -Werror | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/x86_64-xsave.c --check-prefix=XSAVEOPT
    RUN(TestState.Failed, "%clang_cc1 %s -DTEST_XSAVEOPT -O0 -triple=x86_64-unknown-unknown -target-feature +xsave -target-feature +xsaveopt -emit-llvm -o - -Werror")./*|*/
      I("FileCheck %s --check-prefix=XSAVEOPT");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/x86_64-xsave.c -DTEST_XSAVEOPT -O0 -triple=x86_64-unknown-unknown -target-feature +xsave -target-feature +xsaveopt -fno-signed-char -emit-llvm -o - -Werror | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/x86_64-xsave.c --check-prefix=XSAVEOPT
    RUN(TestState.Failed, "%clang_cc1 %s -DTEST_XSAVEOPT -O0 -triple=x86_64-unknown-unknown -target-feature +xsave -target-feature +xsaveopt -fno-signed-char -emit-llvm -o - -Werror")./*|*/
      I("FileCheck %s --check-prefix=XSAVEOPT");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/x86_64-xsave.c -DTEST_XSAVEC -O0 -triple=x86_64-unknown-unknown -target-feature +xsave -target-feature +xsavec -emit-llvm -o - -Werror | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/x86_64-xsave.c --check-prefix=XSAVEC
    RUN(TestState.Failed, "%clang_cc1 %s -DTEST_XSAVEC -O0 -triple=x86_64-unknown-unknown -target-feature +xsave -target-feature +xsavec -emit-llvm -o - -Werror")./*|*/
      I("FileCheck %s --check-prefix=XSAVEC");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/x86_64-xsave.c -DTEST_XSAVEC -O0 -triple=x86_64-unknown-unknown -target-feature +xsave -target-feature +xsavec -fno-signed-char -emit-llvm -o - -Werror | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/x86_64-xsave.c --check-prefix=XSAVEC
    RUN(TestState.Failed, "%clang_cc1 %s -DTEST_XSAVEC -O0 -triple=x86_64-unknown-unknown -target-feature +xsave -target-feature +xsavec -fno-signed-char -emit-llvm -o - -Werror")./*|*/
      I("FileCheck %s --check-prefix=XSAVEC");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/x86_64-xsave.c -DTEST_XSAVES -O0 -triple=x86_64-unknown-unknown -target-feature +xsave -target-feature +xsaves -emit-llvm -o - -Werror | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/x86_64-xsave.c --check-prefix=XSAVES
    RUN(TestState.Failed, "%clang_cc1 %s -DTEST_XSAVES -O0 -triple=x86_64-unknown-unknown -target-feature +xsave -target-feature +xsaves -emit-llvm -o - -Werror")./*|*/
      I("FileCheck %s --check-prefix=XSAVES");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/x86_64-xsave.c -DTEST_XSAVES -O0 -triple=x86_64-unknown-unknown -target-feature +xsave -target-feature +xsaves -fno-signed-char -emit-llvm -o - -Werror | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/x86_64-xsave.c --check-prefix=XSAVES
    RUN(TestState.Failed, "%clang_cc1 %s -DTEST_XSAVES -O0 -triple=x86_64-unknown-unknown -target-feature +xsave -target-feature +xsaves -fno-signed-char -emit-llvm -o - -Werror")./*|*/
      I("FileCheck %s --check-prefix=XSAVES");
  }

  @Test
  public void test_xcore_abi_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/xcore-abi.c");
    // REQUIRES: xcore-registered-target
    if (!CHECK_REQUIRES("xcore-registered-target")) {
      return;
    }
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple xcore -verify ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/xcore-abi.c
    RUN(TestState.Failed, "%clang_cc1 -triple xcore -verify %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple xcore-unknown-unknown -fno-signed-char -fno-common -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/xcore-abi.c | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/xcore-abi.c
    RUN(TestState.Failed, "%clang_cc1 -triple xcore-unknown-unknown -fno-signed-char -fno-common -emit-llvm -o - %s")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_xcore_abi_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/xcore-abi.cpp");
    // REQUIRES: xcore-registered-target
    if (!CHECK_REQUIRES("xcore-registered-target")) {
      return;
    }
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple xcore-unknown-unknown -fno-signed-char -fno-common -emit-llvm -o - -x c++ ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/xcore-abi.cpp | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/xcore-abi.cpp
    RUN(TestState.Failed, "%clang_cc1 -triple xcore-unknown-unknown -fno-signed-char -fno-common -emit-llvm -o - -x c++ %s")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_xcore_stringtype_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/xcore-stringtype.c");
    // REQUIRES: xcore-registered-target
    if (!CHECK_REQUIRES("xcore-registered-target")) {
      return;
    }
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple xcore-unknown-unknown -fno-signed-char -fno-common -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/xcore-stringtype.c | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/xcore-stringtype.c
    RUN(TestState.Failed, "%clang_cc1 -triple xcore-unknown-unknown -fno-signed-char -fno-common -emit-llvm -o - %s")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_xop_builtins_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/xop-builtins.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/xop-builtins.c -triple=x86_64-apple-darwin -target-feature +xop -emit-llvm -o - -Werror | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/xop-builtins.c
    RUN(TestState.Failed, "%clang_cc1 %s -triple=x86_64-apple-darwin -target-feature +xop -emit-llvm -o - -Werror")./*|*/
      I("FileCheck %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/xop-builtins.c -triple=x86_64-apple-darwin -target-feature +xop -fno-signed-char -emit-llvm -o - -Werror | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/xop-builtins.c
    RUN(TestState.Failed, "%clang_cc1 %s -triple=x86_64-apple-darwin -target-feature +xop -fno-signed-char -emit-llvm -o - -Werror")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_xray_attributes_supported_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/xray-attributes-supported.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/xray-attributes-supported.cpp -fxray-instrument -std=c++11 -x c++ -emit-llvm -o - -triple x86_64-unknown-linux-gnu | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/xray-attributes-supported.cpp
    RUN(TestState.Failed, "%clang_cc1 %s -fxray-instrument -std=c++11 -x c++ -emit-llvm -o - -triple x86_64-unknown-linux-gnu")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_zvector_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGen/zvector.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple s390x-linux-gnu -target-cpu z13 -fzvector -O -emit-llvm -o - -W -Wall -Werror ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/zvector.c | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGen/zvector.c
    RUN(TestState.Failed, "%clang_cc1 -triple s390x-linux-gnu -target-cpu z13 -fzvector -O -emit-llvm -o - -W -Wall -Werror %s")./*|*/
      I("FileCheck %s");
  }
  
}
