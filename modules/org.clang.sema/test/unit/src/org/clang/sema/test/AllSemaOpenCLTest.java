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
 * Collection of all test files from test/SemaOpenCL folder
 * @author Vladimir Voskresensky
 */
public class AllSemaOpenCLTest extends DriverTestFileBase {
  private static final String TEST_LOCATION = "${LLVM_SRC}/llvm/tools/clang/test/SemaOpenCL/";
  public AllSemaOpenCLTest() {
    super(TEST_LOCATION, TestState.Successful);
  }
  
  public static void main(String[] args) {
    // Print tests which will be accepted per test case
    DriverTestFileBase.printAllTestFiles(false, TEST_LOCATION, (test)->true, 
            "${SPUTNIK}/modules/org.clang.sema/test/unit/src/org/clang/sema/test/AllSemaOpenCLTest.txt");
  }  
  
  @Override
  protected boolean keepStacksForUnimplementedMethods() {
    return false;
  }
  
  @Test
  public void test_access_qualifier_cl() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaOpenCL/access-qualifier.cl");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -verify -pedantic -fsyntax-only -cl-std=CL1.2 ${LLVM_SRC}/llvm/tools/clang/test/SemaOpenCL/access-qualifier.cl
    RUN(TestState.Failed, "%clang_cc1 -verify -pedantic -fsyntax-only -cl-std=CL1.2 %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -verify -pedantic -fsyntax-only -cl-std=CL2.0 ${LLVM_SRC}/llvm/tools/clang/test/SemaOpenCL/access-qualifier.cl
    RUN(TestState.Failed, "%clang_cc1 -verify -pedantic -fsyntax-only -cl-std=CL2.0 %s");
  }

  @Test
  public void test_address_spaces_cl() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaOpenCL/address-spaces.cl");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/SemaOpenCL/address-spaces.cl -verify -pedantic -fsyntax-only
    RUN("%clang_cc1 %s -verify -pedantic -fsyntax-only");
  }

  @Test
  public void test_address_spaces_conversions_cl2_0_cl() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaOpenCL/address-spaces-conversions-cl2.0.cl");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/SemaOpenCL/address-spaces-conversions-cl2.0.cl -ffake-address-space-map -verify -pedantic -fsyntax-only -DCONSTANT -cl-std=CL2.0
    RUN("%clang_cc1 %s -ffake-address-space-map -verify -pedantic -fsyntax-only -DCONSTANT -cl-std=CL2.0");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/SemaOpenCL/address-spaces-conversions-cl2.0.cl -ffake-address-space-map -verify -pedantic -fsyntax-only -DGLOBAL -cl-std=CL2.0
    RUN("%clang_cc1 %s -ffake-address-space-map -verify -pedantic -fsyntax-only -DGLOBAL -cl-std=CL2.0");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/SemaOpenCL/address-spaces-conversions-cl2.0.cl -ffake-address-space-map -verify -pedantic -fsyntax-only -DGENERIC -cl-std=CL2.0
    RUN("%clang_cc1 %s -ffake-address-space-map -verify -pedantic -fsyntax-only -DGENERIC -cl-std=CL2.0");
  }

  @Test
  public void test_amdgpu_num_register_attrs_cl() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaOpenCL/amdgpu-num-register-attrs.cl");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple r600-- -verify -fsyntax-only ${LLVM_SRC}/llvm/tools/clang/test/SemaOpenCL/amdgpu-num-register-attrs.cl
    RUN("%clang_cc1 -triple r600-- -verify -fsyntax-only %s");
  }

  @Test
  public void test_array_parameters_cl() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaOpenCL/array-parameters.cl");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/SemaOpenCL/array-parameters.cl -verify -pedantic -fsyntax-only
    RUN("%clang_cc1 %s -verify -pedantic -fsyntax-only");
  }

  @Test
  public void test_as_type_cl() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaOpenCL/as_type.cl");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/SemaOpenCL/as_type.cl -emit-llvm -triple spir-unknown-unknown -o - -verify -fsyntax-only
    RUN("%clang_cc1 %s -emit-llvm -triple spir-unknown-unknown -o - -verify -fsyntax-only");
  }

  @Test
  public void test_bool_vectors_cl() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaOpenCL/bool-vectors.cl");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/SemaOpenCL/bool-vectors.cl -verify -pedantic -fsyntax-only
    RUN("%clang_cc1 %s -verify -pedantic -fsyntax-only");
  }

  @Test
  public void test_builtin_cl() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaOpenCL/builtin.cl");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/SemaOpenCL/builtin.cl -verify -pedantic -fsyntax-only
    RUN("%clang_cc1 %s -verify -pedantic -fsyntax-only");
  }

  @Test
  public void test_cl20_device_side_enqueue_cl() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaOpenCL/cl20-device-side-enqueue.cl");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/SemaOpenCL/cl20-device-side-enqueue.cl -cl-std=CL2.0 -verify -pedantic -fsyntax-only
    RUN("%clang_cc1 %s -cl-std=CL2.0 -verify -pedantic -fsyntax-only");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/SemaOpenCL/cl20-device-side-enqueue.cl -cl-std=CL2.0 -verify -pedantic -fsyntax-only -Wconversion -DWCONV
    RUN("%clang_cc1 %s -cl-std=CL2.0 -verify -pedantic -fsyntax-only -Wconversion -DWCONV");
  }

  @Test
  public void test_clang_builtin_version_cl() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaOpenCL/clang-builtin-version.cl");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/SemaOpenCL/clang-builtin-version.cl -fblocks -verify -pedantic -fsyntax-only -ferror-limit 100
    RUN("%clang_cc1 %s -fblocks -verify -pedantic -fsyntax-only -ferror-limit 100");
  }

  @Test
  public void test_cond_cl() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaOpenCL/cond.cl");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/SemaOpenCL/cond.cl -verify -pedantic -fsyntax-only
    RUN("%clang_cc1 %s -verify -pedantic -fsyntax-only");
  }

  @Test
  public void test_endian_attr_cl() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaOpenCL/endian-attr.cl");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaOpenCL/endian-attr.cl
    RUN("%clang_cc1 -verify %s");
  }

  @Test
  public void test_event_t_cl() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaOpenCL/event_t.cl");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/SemaOpenCL/event_t.cl -verify -pedantic -fsyntax-only
    RUN("%clang_cc1 %s -verify -pedantic -fsyntax-only");
  }

  @Test
  public void test_event_t_overload_cl() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaOpenCL/event_t_overload.cl");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/SemaOpenCL/event_t_overload.cl -verify -pedantic -fsyntax-only
    RUN("%clang_cc1 %s -verify -pedantic -fsyntax-only");
  }

  @Test
  public void test_extension_version_cl() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaOpenCL/extension-version.cl");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x cl -cl-std=CL ${LLVM_SRC}/llvm/tools/clang/test/SemaOpenCL/extension-version.cl -verify -triple spir-unknown-unknown
    RUN("%clang_cc1 -x cl -cl-std=CL %s -verify -triple spir-unknown-unknown");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x cl -cl-std=CL1.1 ${LLVM_SRC}/llvm/tools/clang/test/SemaOpenCL/extension-version.cl -verify -triple spir-unknown-unknown
    RUN("%clang_cc1 -x cl -cl-std=CL1.1 %s -verify -triple spir-unknown-unknown");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x cl -cl-std=CL1.2 ${LLVM_SRC}/llvm/tools/clang/test/SemaOpenCL/extension-version.cl -verify -triple spir-unknown-unknown
    RUN("%clang_cc1 -x cl -cl-std=CL1.2 %s -verify -triple spir-unknown-unknown");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x cl -cl-std=CL2.0 ${LLVM_SRC}/llvm/tools/clang/test/SemaOpenCL/extension-version.cl -verify -triple spir-unknown-unknown
    RUN("%clang_cc1 -x cl -cl-std=CL2.0 %s -verify -triple spir-unknown-unknown");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x cl -cl-std=CL ${LLVM_SRC}/llvm/tools/clang/test/SemaOpenCL/extension-version.cl -verify -triple spir-unknown-unknown -Wpedantic-core-features -DTEST_CORE_FEATURES
    RUN("%clang_cc1 -x cl -cl-std=CL %s -verify -triple spir-unknown-unknown -Wpedantic-core-features -DTEST_CORE_FEATURES");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x cl -cl-std=CL1.1 ${LLVM_SRC}/llvm/tools/clang/test/SemaOpenCL/extension-version.cl -verify -triple spir-unknown-unknown -Wpedantic-core-features -DTEST_CORE_FEATURES
    RUN("%clang_cc1 -x cl -cl-std=CL1.1 %s -verify -triple spir-unknown-unknown -Wpedantic-core-features -DTEST_CORE_FEATURES");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x cl -cl-std=CL1.2 ${LLVM_SRC}/llvm/tools/clang/test/SemaOpenCL/extension-version.cl -verify -triple spir-unknown-unknown -Wpedantic-core-features -DTEST_CORE_FEATURES
    RUN("%clang_cc1 -x cl -cl-std=CL1.2 %s -verify -triple spir-unknown-unknown -Wpedantic-core-features -DTEST_CORE_FEATURES");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x cl -cl-std=CL2.0 ${LLVM_SRC}/llvm/tools/clang/test/SemaOpenCL/extension-version.cl -verify -triple spir-unknown-unknown -Wpedantic-core-features -DTEST_CORE_FEATURES
    RUN("%clang_cc1 -x cl -cl-std=CL2.0 %s -verify -triple spir-unknown-unknown -Wpedantic-core-features -DTEST_CORE_FEATURES");
  }

  @Test
  public void test_extensions_cl() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaOpenCL/extensions.cl");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/SemaOpenCL/extensions.cl -triple spir-unknown-unknown -verify -pedantic -fsyntax-only
    RUN("%clang_cc1 %s -triple spir-unknown-unknown -verify -pedantic -fsyntax-only");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/SemaOpenCL/extensions.cl -triple spir-unknown-unknown -verify -pedantic -fsyntax-only -cl-std=CL1.1
    RUN("%clang_cc1 %s -triple spir-unknown-unknown -verify -pedantic -fsyntax-only -cl-std=CL1.1");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/SemaOpenCL/extensions.cl -triple r600-unknown-unknown -target-cpu r600 -verify -pedantic -fsyntax-only -DNOFP64
    RUN("%clang_cc1 %s -triple r600-unknown-unknown -target-cpu r600 -verify -pedantic -fsyntax-only -DNOFP64");
  }

  @Test
  public void test_extern_cl() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaOpenCL/extern.cl");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x cl -cl-opt-disable -cl-std=CL1.2 -emit-llvm -ffake-address-space-map ${LLVM_SRC}/llvm/tools/clang/test/SemaOpenCL/extern.cl -o - -verify | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/SemaOpenCL/extern.cl
    RUN(TestState.Failed, "%clang_cc1 -x cl -cl-opt-disable -cl-std=CL1.2 -emit-llvm -ffake-address-space-map %s -o - -verify")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_func_ptr_cl() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaOpenCL/func_ptr.cl");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/SemaOpenCL/func_ptr.cl -verify -pedantic -fsyntax-only
    RUN("%clang_cc1 %s -verify -pedantic -fsyntax-only");
  }

  @Test
  public void test_half_cl() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaOpenCL/half.cl");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/SemaOpenCL/half.cl -verify -pedantic -fsyntax-only -Wno-unused-value -triple spir-unknown-unknown
    RUN("%clang_cc1 %s -verify -pedantic -fsyntax-only -Wno-unused-value -triple spir-unknown-unknown");
  }

  @Test
  public void test_images_cl() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaOpenCL/images.cl");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/SemaOpenCL/images.cl -verify -pedantic -fsyntax-only
    RUN(TestState.Failed, "%clang_cc1 %s -verify -pedantic -fsyntax-only");
  }

  @Test
  public void test_init_cl() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaOpenCL/init.cl");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/SemaOpenCL/init.cl -verify -pedantic -fsyntax-only
    RUN("%clang_cc1 %s -verify -pedantic -fsyntax-only");
  }

  @Test
  public void test_invalid_block_cl() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaOpenCL/invalid-block.cl");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -verify -fblocks -cl-std=CL2.0 ${LLVM_SRC}/llvm/tools/clang/test/SemaOpenCL/invalid-block.cl
    RUN("%clang_cc1 -verify -fblocks -cl-std=CL2.0 %s");
  }

  @Test
  public void test_invalid_constant_cl() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaOpenCL/invalid-constant.cl");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaOpenCL/invalid-constant.cl
    RUN("%clang_cc1 -verify %s");
  }

  @Test
  public void test_invalid_image_cl() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaOpenCL/invalid-image.cl");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaOpenCL/invalid-image.cl
    RUN("%clang_cc1 -verify %s");
  }

  @Test
  public void test_invalid_kernel_cl() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaOpenCL/invalid-kernel.cl");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaOpenCL/invalid-kernel.cl
    RUN("%clang_cc1 -verify %s");
  }

  @Test
  public void test_invalid_kernel_attrs_cl() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaOpenCL/invalid-kernel-attrs.cl");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaOpenCL/invalid-kernel-attrs.cl
    RUN(TestState.Failed, "%clang_cc1 -verify %s");
  }

  @Test
  public void test_invalid_kernel_parameters_cl() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaOpenCL/invalid-kernel-parameters.cl");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaOpenCL/invalid-kernel-parameters.cl -triple spir-unknown-unknown
    RUN("%clang_cc1 -fsyntax-only -verify %s -triple spir-unknown-unknown");
  }

  @Test
  public void test_invalid_logical_ops_1_1_cl() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaOpenCL/invalid-logical-ops-1.1.cl");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/SemaOpenCL/invalid-logical-ops-1.1.cl -verify -cl-std=CL1.1 -triple x86_64-unknown-linux-gnu
    RUN("%clang_cc1 %s -verify -cl-std=CL1.1 -triple x86_64-unknown-linux-gnu");
  }

  @Test
  public void test_invalid_logical_ops_1_2_cl() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaOpenCL/invalid-logical-ops-1.2.cl");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/SemaOpenCL/invalid-logical-ops-1.2.cl -verify -cl-std=CL1.2 -triple x86_64-unknown-linux-gnu
    RUN("%clang_cc1 %s -verify -cl-std=CL1.2 -triple x86_64-unknown-linux-gnu");
  }

  @Test
  public void test_invalid_pipe_builtin_cl2_0_cl() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaOpenCL/invalid-pipe-builtin-cl2.0.cl");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/SemaOpenCL/invalid-pipe-builtin-cl2.0.cl -verify -pedantic -fsyntax-only -cl-std=CL2.0
    RUN(TestState.Failed, "%clang_cc1 %s -verify -pedantic -fsyntax-only -cl-std=CL2.0");
  }

  @Test
  public void test_invalid_pipes_cl2_0_cl() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaOpenCL/invalid-pipes-cl2.0.cl");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/SemaOpenCL/invalid-pipes-cl2.0.cl -verify -pedantic -fsyntax-only -cl-std=CL2.0
    RUN("%clang_cc1 %s -verify -pedantic -fsyntax-only -cl-std=CL2.0");
  }

  @Test
  public void test_nosvm_cl() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaOpenCL/nosvm.cl");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaOpenCL/nosvm.cl
    RUN("%clang_cc1 -verify %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -verify -cl-std=CL2.0 -D CL20 ${LLVM_SRC}/llvm/tools/clang/test/SemaOpenCL/nosvm.cl
    RUN("%clang_cc1 -verify -cl-std=CL2.0 -D CL20 %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -verify -x c -D NOCL ${LLVM_SRC}/llvm/tools/clang/test/SemaOpenCL/nosvm.cl
    RUN("%clang_cc1 -verify -x c -D NOCL %s");
  }

  @Test
  public void test_null_literal_cl() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaOpenCL/null_literal.cl");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaOpenCL/null_literal.cl
    RUN("%clang_cc1 -verify %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -cl-std=CL2.0 -DCL20 -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaOpenCL/null_literal.cl
    RUN("%clang_cc1 -cl-std=CL2.0 -DCL20 -verify %s");
  }

  @Test
  public void test_pipes_1_2_negative_cl() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaOpenCL/pipes-1.2-negative.cl");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/SemaOpenCL/pipes-1.2-negative.cl -verify -pedantic -fsyntax-only -cl-std=CL1.2
    RUN("%clang_cc1 %s -verify -pedantic -fsyntax-only -cl-std=CL1.2");
  }

  @Test
  public void test_sampler_t_cl() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaOpenCL/sampler_t.cl");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/SemaOpenCL/sampler_t.cl -verify -pedantic -fsyntax-only
    RUN("%clang_cc1 %s -verify -pedantic -fsyntax-only");
  }

  @Test
  public void test_sampler_t_overload_cl() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaOpenCL/sampler_t_overload.cl");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/SemaOpenCL/sampler_t_overload.cl
    RUN(TestState.Failed, "%clang_cc1 %s");
  }

  @Test
  public void test_shifts_cl() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaOpenCL/shifts.cl");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/SemaOpenCL/shifts.cl -verify -pedantic -fsyntax-only
    RUN("%clang_cc1 %s -verify -pedantic -fsyntax-only");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/SemaOpenCL/shifts.cl -verify -pedantic -fsyntax-only
    RUN("%clang_cc1 %s -verify -pedantic -fsyntax-only");
  }

  @Test
  public void test_sizeof_cl() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaOpenCL/sizeof.cl");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/SemaOpenCL/sizeof.cl -verify -fsyntax-only
    RUN("%clang_cc1 %s -verify -fsyntax-only");
  }

  @Test
  public void test_storageclass_cl() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaOpenCL/storageclass.cl");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/SemaOpenCL/storageclass.cl -verify -pedantic -fsyntax-only -cl-std=CL1.2
    RUN("%clang_cc1 %s -verify -pedantic -fsyntax-only -cl-std=CL1.2");
  }

  @Test
  public void test_storageclass_cl20_cl() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaOpenCL/storageclass-cl20.cl");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/SemaOpenCL/storageclass-cl20.cl -verify -pedantic -fsyntax-only -cl-std=CL2.0
    RUN("%clang_cc1 %s -verify -pedantic -fsyntax-only -cl-std=CL2.0");
  }

  @Test
  public void test_str_literals_cl() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaOpenCL/str_literals.cl");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/SemaOpenCL/str_literals.cl -verify
    RUN("%clang_cc1 %s -verify");
  }

  @Test
  public void test_to_addr_builtin_cl() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaOpenCL/to_addr_builtin.cl");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -verify -fsyntax-only ${LLVM_SRC}/llvm/tools/clang/test/SemaOpenCL/to_addr_builtin.cl
    RUN("%clang_cc1 -verify -fsyntax-only %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -verify -fsyntax-only -cl-std=CL2.0 ${LLVM_SRC}/llvm/tools/clang/test/SemaOpenCL/to_addr_builtin.cl
    RUN("%clang_cc1 -verify -fsyntax-only -cl-std=CL2.0 %s");
  }

  @Test
  public void test_unroll_hint_cl() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaOpenCL/unroll-hint.cl");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -O0 -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaOpenCL/unroll-hint.cl
    RUN("%clang_cc1 -O0 -fsyntax-only -verify %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -O0 -cl-std=CL2.0 -fsyntax-only -verify -DCL20 ${LLVM_SRC}/llvm/tools/clang/test/SemaOpenCL/unroll-hint.cl
    RUN("%clang_cc1 -O0 -cl-std=CL2.0 -fsyntax-only -verify -DCL20 %s");
  }

  @Test
  public void test_unsupported_cl() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaOpenCL/unsupported.cl");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaOpenCL/unsupported.cl
    RUN("%clang_cc1 -verify %s");
  }

  @Test
  public void test_vec_compare_cl() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaOpenCL/vec_compare.cl");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/SemaOpenCL/vec_compare.cl -verify -pedantic -fsyntax-only
    RUN("%clang_cc1 %s -verify -pedantic -fsyntax-only");
  }

  @Test
  public void test_vec_step_cl() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaOpenCL/vec_step.cl");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -pedantic -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaOpenCL/vec_step.cl
    RUN("%clang_cc1 -fsyntax-only -pedantic -verify %s");
  }

  @Test
  public void test_vector_conv_invalid_cl() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaOpenCL/vector_conv_invalid.cl");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaOpenCL/vector_conv_invalid.cl
    RUN("%clang_cc1 -verify %s");
  }

  @Test
  public void test_vector_inc_dec_ops_cl() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaOpenCL/vector_inc_dec_ops.cl");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/SemaOpenCL/vector_inc_dec_ops.cl -verify -pedantic -fsyntax-only
    RUN("%clang_cc1 %s -verify -pedantic -fsyntax-only");
  }

  @Test
  public void test_vector_literals_const_cl() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaOpenCL/vector_literals_const.cl");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/SemaOpenCL/vector_literals_const.cl -verify -pedantic -fsyntax-only
    RUN("%clang_cc1 %s -verify -pedantic -fsyntax-only");
  }

  @Test
  public void test_vector_literals_invalid_cl() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaOpenCL/vector_literals_invalid.cl");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaOpenCL/vector_literals_invalid.cl
    RUN("%clang_cc1 -verify %s");
  }

  @Test
  public void test_warn_missing_prototypes_cl() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaOpenCL/warn-missing-prototypes.cl");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -Wmissing-prototypes ${LLVM_SRC}/llvm/tools/clang/test/SemaOpenCL/warn-missing-prototypes.cl
    RUN("%clang_cc1 -fsyntax-only -verify -Wmissing-prototypes %s");
  }
  
}
