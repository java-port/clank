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
 * Collection of all test files from test/CodeGenOpenCL folder
 * @author Vladimir Voskresensky
 */
@Ignore
public class AllClangCodeGenOpenCLTest extends DriverTestFileBase {
  private static final String TEST_LOCATION = "${LLVM_SRC}/llvm/tools/clang/test/CodeGenOpenCL/";
  public AllClangCodeGenOpenCLTest() {
    super(TEST_LOCATION, TestState.Successful);
  }
  
  public static void main(String[] args) {
    // Print tests which will be accepted per test case
    DriverTestFileBase.printAllTestFiles(false, TEST_LOCATION, (test)->{ return true;/*test.getFileIndexInFolder()<120;*/ }, 
            "${SPUTNIK}/modules/org.clang.codegen/test/unit/src/org/clang/codegen/test/AllClangCodeGenOpenCLTest.txt");
  }  

  @Override
  protected boolean keepStacksForUnimplementedMethods() {
    return false;
  }
  
  @Test
  public void test_2011_04_15_vec_init_from_vec_cl() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenOpenCL/2011-04-15-vec-init-from-vec.cl");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGenOpenCL/2011-04-15-vec-init-from-vec.cl -emit-llvm -o ${TEST_TEMP_DIR}/2011-04-15-vec-init-from-vec.cl.tmp
    RUN(TestState.Failed, "%clang_cc1 %s -emit-llvm -o %t");
  }

  @Test
  public void test_addr_space_struct_arg_cl() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenOpenCL/addr-space-struct-arg.cl");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGenOpenCL/addr-space-struct-arg.cl -emit-llvm -o - -O0 -ffake-address-space-map -triple i686-pc-darwin | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenOpenCL/addr-space-struct-arg.cl
    RUN(TestState.Failed, "%clang_cc1 %s -emit-llvm -o - -O0 -ffake-address-space-map -triple i686-pc-darwin")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_address_space_constant_initializers_cl() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenOpenCL/address-space-constant-initializers.cl");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGenOpenCL/address-space-constant-initializers.cl -ffake-address-space-map -emit-llvm -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenOpenCL/address-space-constant-initializers.cl
    RUN(TestState.Failed, "%clang_cc1 %s -ffake-address-space-map -emit-llvm -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_address_spaces_cl() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenOpenCL/address-spaces.cl");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGenOpenCL/address-spaces.cl -O0 -ffake-address-space-map -emit-llvm -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenOpenCL/address-spaces.cl
    RUN(TestState.Failed, "%clang_cc1 %s -O0 -ffake-address-space-map -emit-llvm -o -")./*|*/
      I("FileCheck %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGenOpenCL/address-spaces.cl -O0 -DCL20 -cl-std=CL2.0 -ffake-address-space-map -emit-llvm -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenOpenCL/address-spaces.cl --check-prefix=CL20
    RUN(TestState.Failed, "%clang_cc1 %s -O0 -DCL20 -cl-std=CL2.0 -ffake-address-space-map -emit-llvm -o -")./*|*/
      I("FileCheck %s --check-prefix=CL20");
  }

  @Test
  public void test_address_spaces_conversions_cl() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenOpenCL/address-spaces-conversions.cl");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGenOpenCL/address-spaces-conversions.cl -triple x86_64-unknown-linux-gnu -O0 -ffake-address-space-map -cl-std=CL2.0 -emit-llvm -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenOpenCL/address-spaces-conversions.cl
    RUN(TestState.Failed, "%clang_cc1 %s -triple x86_64-unknown-linux-gnu -O0 -ffake-address-space-map -cl-std=CL2.0 -emit-llvm -o -")./*|*/
      I("FileCheck %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGenOpenCL/address-spaces-conversions.cl -triple x86_64-unknown-linux-gnu -O0 -cl-std=CL2.0 -emit-llvm -o - | ${LLVM_SRC}/build/bin/FileCheck --check-prefix=CHECK-NOFAKE ${LLVM_SRC}/llvm/tools/clang/test/CodeGenOpenCL/address-spaces-conversions.cl
    RUN(TestState.Failed, "%clang_cc1 %s -triple x86_64-unknown-linux-gnu -O0 -cl-std=CL2.0 -emit-llvm -o -")./*|*/
      I("FileCheck --check-prefix=CHECK-NOFAKE %s");
  }

  @Test
  public void test_address_spaces_mangling_cl() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenOpenCL/address-spaces-mangling.cl");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGenOpenCL/address-spaces-mangling.cl -ffake-address-space-map -faddress-space-map-mangling=yes -triple i386-pc-solaris2.11 -emit-llvm -o - | ${LLVM_SRC}/build/bin/FileCheck -check-prefix=ASMANG ${LLVM_SRC}/llvm/tools/clang/test/CodeGenOpenCL/address-spaces-mangling.cl
    RUN(TestState.Failed, "%clang_cc1 %s -ffake-address-space-map -faddress-space-map-mangling=yes -triple %itanium_abi_triple -emit-llvm -o -")./*|*/
      I("FileCheck -check-prefix=ASMANG %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGenOpenCL/address-spaces-mangling.cl -ffake-address-space-map -faddress-space-map-mangling=no -triple i386-pc-solaris2.11 -emit-llvm -o - | ${LLVM_SRC}/build/bin/FileCheck -check-prefix=NOASMANG ${LLVM_SRC}/llvm/tools/clang/test/CodeGenOpenCL/address-spaces-mangling.cl
    RUN(TestState.Failed, "%clang_cc1 %s -ffake-address-space-map -faddress-space-map-mangling=no -triple %itanium_abi_triple -emit-llvm -o -")./*|*/
      I("FileCheck -check-prefix=NOASMANG %s");
  }

  @Test
  public void test_amdgcn_flat_scratch_name_cl() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenOpenCL/amdgcn-flat-scratch-name.cl");
    // REQUIRES: amdgpu-registered-target
    if (!CHECK_REQUIRES("amdgpu-registered-target")) {
      return;
    }
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple amdgcn-unknown-unknown -S -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGenOpenCL/amdgcn-flat-scratch-name.cl | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenOpenCL/amdgcn-flat-scratch-name.cl
    RUN(TestState.Failed, "%clang_cc1 -triple amdgcn-unknown-unknown -S -emit-llvm -o - %s")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_amdgpu_call_kernel_cl() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenOpenCL/amdgpu-call-kernel.cl");
    // REQUIRES: amdgpu-registered-target
    if (!CHECK_REQUIRES("amdgpu-registered-target")) {
      return;
    }
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple amdgcn-unknown-unknown -S -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGenOpenCL/amdgpu-call-kernel.cl | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenOpenCL/amdgpu-call-kernel.cl
    RUN(TestState.Failed, "%clang_cc1 -triple amdgcn-unknown-unknown -S -emit-llvm -o - %s")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_amdgpu_calling_conv_cl() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenOpenCL/amdgpu-calling-conv.cl");
    // REQUIRES: amdgpu-registered-target
    if (!CHECK_REQUIRES("amdgpu-registered-target")) {
      return;
    }
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple amdgcn-unknown-unknown -S -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGenOpenCL/amdgpu-calling-conv.cl | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenOpenCL/amdgpu-calling-conv.cl
    RUN(TestState.Failed, "%clang_cc1 -triple amdgcn-unknown-unknown -S -emit-llvm -o - %s")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_amdgpu_num_gpr_attr_cl() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenOpenCL/amdgpu-num-gpr-attr.cl");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple amdgcn-- -target-cpu tahiti -O0 -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGenOpenCL/amdgpu-num-gpr-attr.cl | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenOpenCL/amdgpu-num-gpr-attr.cl
    RUN(TestState.Failed, "%clang_cc1 -triple amdgcn-- -target-cpu tahiti -O0 -emit-llvm -o - %s")./*|*/
      I("FileCheck %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-unknown-linux-gnu -O0 -emit-llvm -verify -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGenOpenCL/amdgpu-num-gpr-attr.cl | ${LLVM_SRC}/build/bin/FileCheck -check-prefix=X86 ${LLVM_SRC}/llvm/tools/clang/test/CodeGenOpenCL/amdgpu-num-gpr-attr.cl
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-unknown-linux-gnu -O0 -emit-llvm -verify -o - %s")./*|*/
      I("FileCheck -check-prefix=X86 %s");
  }

  @Test
  public void test_as_type_cl() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenOpenCL/as_type.cl");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGenOpenCL/as_type.cl -emit-llvm -triple spir-unknown-unknown -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenOpenCL/as_type.cl
    RUN(TestState.Failed, "%clang_cc1 %s -emit-llvm -triple spir-unknown-unknown -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_bool_cast_cl() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenOpenCL/bool_cast.cl");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGenOpenCL/bool_cast.cl -emit-llvm -o - -O0 | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenOpenCL/bool_cast.cl
    RUN(TestState.Failed, "%clang_cc1 %s -emit-llvm -o - -O0")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_builtins_amdgcn_cl() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenOpenCL/builtins-amdgcn.cl");
    // REQUIRES: amdgpu-registered-target
    if (!CHECK_REQUIRES("amdgpu-registered-target")) {
      return;
    }
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple amdgcn-unknown-unknown -S -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGenOpenCL/builtins-amdgcn.cl | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenOpenCL/builtins-amdgcn.cl
    RUN(TestState.Failed, "%clang_cc1 -triple amdgcn-unknown-unknown -S -emit-llvm -o - %s")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_builtins_amdgcn_error_cl() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenOpenCL/builtins-amdgcn-error.cl");
    // REQUIRES: amdgpu-registered-target
    if (!CHECK_REQUIRES("amdgpu-registered-target")) {
      return;
    }
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple amdgcn-unknown-amdhsa -target-cpu tahiti -verify -S -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGenOpenCL/builtins-amdgcn-error.cl
    RUN(TestState.Failed, "%clang_cc1 -triple amdgcn-unknown-amdhsa -target-cpu tahiti -verify -S -o - %s");
  }

  @Test
  public void test_builtins_amdgcn_vi_cl() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenOpenCL/builtins-amdgcn-vi.cl");
    // REQUIRES: amdgpu-registered-target
    if (!CHECK_REQUIRES("amdgpu-registered-target")) {
      return;
    }
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple amdgcn-unknown-unknown -target-cpu tonga -S -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGenOpenCL/builtins-amdgcn-vi.cl | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenOpenCL/builtins-amdgcn-vi.cl
    RUN(TestState.Failed, "%clang_cc1 -triple amdgcn-unknown-unknown -target-cpu tonga -S -emit-llvm -o - %s")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_builtins_generic_amdgcn_cl() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenOpenCL/builtins-generic-amdgcn.cl");
    // REQUIRES: amdgpu-registered-target
    if (!CHECK_REQUIRES("amdgpu-registered-target")) {
      return;
    }
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple amdgcn-unknown-unknown -S -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGenOpenCL/builtins-generic-amdgcn.cl | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenOpenCL/builtins-generic-amdgcn.cl
    RUN(TestState.Failed, "%clang_cc1 -triple amdgcn-unknown-unknown -S -emit-llvm -o - %s")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_builtins_r600_cl() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenOpenCL/builtins-r600.cl");
    // REQUIRES: amdgpu-registered-target
    if (!CHECK_REQUIRES("amdgpu-registered-target")) {
      return;
    }
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple r600-unknown-unknown -target-cpu cypress -S -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGenOpenCL/builtins-r600.cl | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenOpenCL/builtins-r600.cl
    RUN(TestState.Failed, "%clang_cc1 -triple r600-unknown-unknown -target-cpu cypress -S -emit-llvm -o - %s")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_cl_strict_aliasing_cl() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenOpenCL/cl-strict-aliasing.cl");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x cl -emit-llvm -cl-strict-aliasing < ${LLVM_SRC}/llvm/tools/clang/test/CodeGenOpenCL/cl-strict-aliasing.cl
    RUN(TestState.Failed, "%clang_cc1 -x cl -emit-llvm -cl-strict-aliasing < %s");
  }

  @Test
  public void test_cl20_device_side_enqueue_cl() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenOpenCL/cl20-device-side-enqueue.cl");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGenOpenCL/cl20-device-side-enqueue.cl -cl-std=CL2.0 -ffake-address-space-map -O0 -emit-llvm -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenOpenCL/cl20-device-side-enqueue.cl
    RUN(TestState.Failed, "%clang_cc1 %s -cl-std=CL2.0 -ffake-address-space-map -O0 -emit-llvm -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_const_str_array_decay_cl() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenOpenCL/const-str-array-decay.cl");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGenOpenCL/const-str-array-decay.cl -emit-llvm -o - -ffake-address-space-map | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenOpenCL/const-str-array-decay.cl
    RUN(TestState.Failed, "%clang_cc1 %s -emit-llvm -o - -ffake-address-space-map")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_constant_addr_space_globals_cl() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenOpenCL/constant-addr-space-globals.cl");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGenOpenCL/constant-addr-space-globals.cl -cl-opt-disable -ffake-address-space-map -emit-llvm -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenOpenCL/constant-addr-space-globals.cl
    RUN(TestState.Failed, "%clang_cc1 %s -cl-opt-disable -ffake-address-space-map -emit-llvm -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_denorms_are_zero_cl() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenOpenCL/denorms-are-zero.cl");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -S -cl-denorms-are-zero -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGenOpenCL/denorms-are-zero.cl 2>&1
    RUN(TestState.Failed, "%clang_cc1 -S -cl-denorms-are-zero -o - %s 2>&1");
  }

  @Test
  public void test_event_t_cl() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenOpenCL/event_t.cl");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGenOpenCL/event_t.cl -emit-llvm -o - -O0 | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenOpenCL/event_t.cl
    RUN(TestState.Failed, "%clang_cc1 %s -emit-llvm -o - -O0")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_ext_vector_shuffle_cl() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenOpenCL/ext-vector-shuffle.cl");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGenOpenCL/ext-vector-shuffle.cl -cl-opt-disable -emit-llvm -o - | not grep extractelement
    RUN(TestState.Failed, "%clang_cc1 %s -cl-opt-disable -emit-llvm -o -")./*|*/
      I("not grep 'extractelement'");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGenOpenCL/ext-vector-shuffle.cl -cl-opt-disable -emit-llvm -o - | not grep insertelement
    RUN(TestState.Failed, "%clang_cc1 %s -cl-opt-disable -emit-llvm -o -")./*|*/
      I("not grep 'insertelement'");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGenOpenCL/ext-vector-shuffle.cl -cl-opt-disable -emit-llvm -o - | grep shufflevector
    RUN(TestState.Failed, "%clang_cc1 %s -cl-opt-disable -emit-llvm -o -")./*|*/
      I("grep 'shufflevector'");
  }

  @Test
  public void test_fpmath_cl() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenOpenCL/fpmath.cl");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGenOpenCL/fpmath.cl -emit-llvm -o - -triple spir-unknown-unknown | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenOpenCL/fpmath.cl
    RUN(TestState.Failed, "%clang_cc1 %s -emit-llvm -o - -triple spir-unknown-unknown")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_half_cl() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenOpenCL/half.cl");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGenOpenCL/half.cl -emit-llvm -o - -triple spir-unknown-unknown | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenOpenCL/half.cl
    RUN(TestState.Failed, "%clang_cc1 %s -emit-llvm -o - -triple spir-unknown-unknown")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_images_cl() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenOpenCL/images.cl");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGenOpenCL/images.cl -triple x86_64-unknown-linux-gnu -O0 -emit-llvm -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenOpenCL/images.cl
    RUN(TestState.Failed, "%clang_cc1 %s -triple x86_64-unknown-linux-gnu -O0 -emit-llvm -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_kernel_arg_info_cl() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenOpenCL/kernel-arg-info.cl");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGenOpenCL/kernel-arg-info.cl -emit-llvm -o - -triple spir-unknown-unknown | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenOpenCL/kernel-arg-info.cl
    RUN(TestState.Failed, "%clang_cc1 %s -emit-llvm -o - -triple spir-unknown-unknown")./*|*/
      I("FileCheck %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGenOpenCL/kernel-arg-info.cl -emit-llvm -o - -triple spir-unknown-unknown -cl-kernel-arg-info | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenOpenCL/kernel-arg-info.cl -check-prefix ARGINFO
    RUN(TestState.Failed, "%clang_cc1 %s -emit-llvm -o - -triple spir-unknown-unknown -cl-kernel-arg-info")./*|*/
      I("FileCheck %s -check-prefix ARGINFO");
  }

  @Test
  public void test_kernel_attributes_cl() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenOpenCL/kernel-attributes.cl");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGenOpenCL/kernel-attributes.cl | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenOpenCL/kernel-attributes.cl
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm -o - %s")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_kernel_metadata_cl() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenOpenCL/kernel-metadata.cl");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGenOpenCL/kernel-metadata.cl -emit-llvm -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenOpenCL/kernel-metadata.cl
    RUN(TestState.Failed, "%clang_cc1 %s -emit-llvm -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_local_cl() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenOpenCL/local.cl");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGenOpenCL/local.cl -ffake-address-space-map -faddress-space-map-mangling=no -triple i386-pc-solaris2.11 -emit-llvm -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenOpenCL/local.cl
    RUN(TestState.Failed, "%clang_cc1 %s -ffake-address-space-map -faddress-space-map-mangling=no -triple %itanium_abi_triple -emit-llvm -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_local_initializer_undef_cl() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenOpenCL/local-initializer-undef.cl");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGenOpenCL/local-initializer-undef.cl -O0 -ffake-address-space-map -emit-llvm -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenOpenCL/local-initializer-undef.cl
    RUN(TestState.Failed, "%clang_cc1 %s -O0 -ffake-address-space-map -emit-llvm -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_logical_ops_cl() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenOpenCL/logical-ops.cl");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGenOpenCL/logical-ops.cl -emit-llvm -o - -cl-std=CL1.2 -O1 -triple x86_64-unknown-linux-gnu | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenOpenCL/logical-ops.cl
    RUN(TestState.Failed, "%clang_cc1 %s -emit-llvm -o - -cl-std=CL1.2 -O1 -triple x86_64-unknown-linux-gnu")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_memcpy_cl() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenOpenCL/memcpy.cl");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGenOpenCL/memcpy.cl -ffake-address-space-map -emit-llvm -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenOpenCL/memcpy.cl
    RUN(TestState.Failed, "%clang_cc1 %s -ffake-address-space-map -emit-llvm -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_no_signed_zeros_cl() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenOpenCL/no-signed-zeros.cl");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGenOpenCL/no-signed-zeros.cl -emit-llvm -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenOpenCL/no-signed-zeros.cl -check-prefix=NORMAL
    RUN(TestState.Failed, "%clang_cc1 %s -emit-llvm -o -")./*|*/
      I("FileCheck %s -check-prefix=NORMAL");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGenOpenCL/no-signed-zeros.cl -emit-llvm -cl-no-signed-zeros -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenOpenCL/no-signed-zeros.cl -check-prefix=NO-SIGNED-ZEROS
    RUN(TestState.Failed, "%clang_cc1 %s -emit-llvm -cl-no-signed-zeros -o -")./*|*/
      I("FileCheck %s -check-prefix=NO-SIGNED-ZEROS");
  }

  @Test
  public void test_opencl_types_cl() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenOpenCL/opencl_types.cl");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGenOpenCL/opencl_types.cl -emit-llvm -o - -O0 | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenOpenCL/opencl_types.cl
    RUN(TestState.Failed, "%clang_cc1 %s -emit-llvm -o - -O0")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_pipe_builtin_cl() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenOpenCL/pipe_builtin.cl");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm -O0 -cl-std=CL2.0 -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGenOpenCL/pipe_builtin.cl | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenOpenCL/pipe_builtin.cl
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm -O0 -cl-std=CL2.0 -o - %s")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_pipe_types_cl() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenOpenCL/pipe_types.cl");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-unknown-linux-gnu -emit-llvm -O0 -cl-std=CL2.0 -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGenOpenCL/pipe_types.cl | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenOpenCL/pipe_types.cl
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-unknown-linux-gnu -emit-llvm -O0 -cl-std=CL2.0 -o - %s")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_ptx_calls_cl() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenOpenCL/ptx-calls.cl");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGenOpenCL/ptx-calls.cl -triple nvptx-unknown-unknown -emit-llvm -O0 -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenOpenCL/ptx-calls.cl
    RUN(TestState.Failed, "%clang_cc1 %s -triple nvptx-unknown-unknown -emit-llvm -O0 -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_ptx_kernels_cl() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenOpenCL/ptx-kernels.cl");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGenOpenCL/ptx-kernels.cl -triple nvptx-unknown-unknown -emit-llvm -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenOpenCL/ptx-kernels.cl
    RUN(TestState.Failed, "%clang_cc1 %s -triple nvptx-unknown-unknown -emit-llvm -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_relaxed_fpmath_cl() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenOpenCL/relaxed-fpmath.cl");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGenOpenCL/relaxed-fpmath.cl -emit-llvm -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenOpenCL/relaxed-fpmath.cl -check-prefix=NORMAL
    RUN(TestState.Failed, "%clang_cc1 %s -emit-llvm -o -")./*|*/
      I("FileCheck %s -check-prefix=NORMAL");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGenOpenCL/relaxed-fpmath.cl -emit-llvm -cl-fast-relaxed-math -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenOpenCL/relaxed-fpmath.cl -check-prefix=FAST
    RUN(TestState.Failed, "%clang_cc1 %s -emit-llvm -cl-fast-relaxed-math -o -")./*|*/
      I("FileCheck %s -check-prefix=FAST");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGenOpenCL/relaxed-fpmath.cl -emit-llvm -cl-finite-math-only -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenOpenCL/relaxed-fpmath.cl -check-prefix=FINITE
    RUN(TestState.Failed, "%clang_cc1 %s -emit-llvm -cl-finite-math-only -o -")./*|*/
      I("FileCheck %s -check-prefix=FINITE");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGenOpenCL/relaxed-fpmath.cl -emit-llvm -cl-unsafe-math-optimizations -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenOpenCL/relaxed-fpmath.cl -check-prefix=UNSAFE
    RUN(TestState.Failed, "%clang_cc1 %s -emit-llvm -cl-unsafe-math-optimizations -o -")./*|*/
      I("FileCheck %s -check-prefix=UNSAFE");
  }

  @Test
  public void test_shifts_cl() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenOpenCL/shifts.cl");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x cl -O1 -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGenOpenCL/shifts.cl -o - -triple x86_64-linux-gnu | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenOpenCL/shifts.cl -check-prefix=OPT
    RUN(TestState.Failed, "%clang_cc1 -x cl -O1 -emit-llvm  %s -o - -triple x86_64-linux-gnu")./*|*/
      I("FileCheck %s -check-prefix=OPT");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x cl -O0 -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGenOpenCL/shifts.cl -o - -triple x86_64-linux-gnu | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenOpenCL/shifts.cl -check-prefix=NOOPT
    RUN(TestState.Failed, "%clang_cc1 -x cl -O0 -emit-llvm  %s -o - -triple x86_64-linux-gnu")./*|*/
      I("FileCheck %s -check-prefix=NOOPT");
  }

  @Test
  public void test_single_precision_constant_cl() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenOpenCL/single-precision-constant.cl");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGenOpenCL/single-precision-constant.cl -cl-single-precision-constant -emit-llvm -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenOpenCL/single-precision-constant.cl
    RUN(TestState.Failed, "%clang_cc1 %s -cl-single-precision-constant -emit-llvm -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_spir_calling_conv_cl() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenOpenCL/spir-calling-conv.cl");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGenOpenCL/spir-calling-conv.cl -triple spir-unknown-unknown -emit-llvm -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenOpenCL/spir-calling-conv.cl
    RUN(TestState.Failed, "%clang_cc1 %s -triple \"spir-unknown-unknown\" -emit-llvm -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_spir32_target_cl() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenOpenCL/spir32_target.cl");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGenOpenCL/spir32_target.cl -triple spir-unknown-unknown -emit-llvm -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenOpenCL/spir32_target.cl
    RUN(TestState.Failed, "%clang_cc1 %s -triple \"spir-unknown-unknown\" -emit-llvm -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_spir64_target_cl() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenOpenCL/spir64_target.cl");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGenOpenCL/spir64_target.cl -triple spir64-unknown-unknown -emit-llvm -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenOpenCL/spir64_target.cl
    RUN(TestState.Failed, "%clang_cc1 %s -triple \"spir64-unknown-unknown\" -emit-llvm -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_spir_version_cl() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenOpenCL/spir_version.cl");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGenOpenCL/spir_version.cl -triple spir-unknown-unknown -emit-llvm -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenOpenCL/spir_version.cl --check-prefix=CL10
    RUN(TestState.Failed, "%clang_cc1 %s -triple \"spir-unknown-unknown\" -emit-llvm -o -")./*|*/
      I("FileCheck %s --check-prefix=CL10");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGenOpenCL/spir_version.cl -triple spir-unknown-unknown -emit-llvm -o - -cl-std=CL1.2 | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenOpenCL/spir_version.cl --check-prefix=CL12
    RUN(TestState.Failed, "%clang_cc1 %s -triple \"spir-unknown-unknown\" -emit-llvm -o - -cl-std=CL1.2")./*|*/
      I("FileCheck %s --check-prefix=CL12");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGenOpenCL/spir_version.cl -triple spir-unknown-unknown -emit-llvm -o - -cl-std=CL2.0 | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenOpenCL/spir_version.cl --check-prefix=CL20
    RUN(TestState.Failed, "%clang_cc1 %s -triple \"spir-unknown-unknown\" -emit-llvm -o - -cl-std=CL2.0")./*|*/
      I("FileCheck %s --check-prefix=CL20");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGenOpenCL/spir_version.cl -triple spir64-unknown-unknown -emit-llvm -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenOpenCL/spir_version.cl --check-prefix=CL10
    RUN(TestState.Failed, "%clang_cc1 %s -triple \"spir64-unknown-unknown\" -emit-llvm -o -")./*|*/
      I("FileCheck %s --check-prefix=CL10");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGenOpenCL/spir_version.cl -triple spir64-unknown-unknown -emit-llvm -o - -cl-std=CL1.2 | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenOpenCL/spir_version.cl --check-prefix=CL12
    RUN(TestState.Failed, "%clang_cc1 %s -triple \"spir64-unknown-unknown\" -emit-llvm -o - -cl-std=CL1.2")./*|*/
      I("FileCheck %s --check-prefix=CL12");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGenOpenCL/spir_version.cl -triple spir64-unknown-unknown -emit-llvm -o - -cl-std=CL2.0 | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenOpenCL/spir_version.cl --check-prefix=CL20
    RUN(TestState.Failed, "%clang_cc1 %s -triple \"spir64-unknown-unknown\" -emit-llvm -o - -cl-std=CL2.0")./*|*/
      I("FileCheck %s --check-prefix=CL20");
  }

  @Test
  public void test_str_literals_cl() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenOpenCL/str_literals.cl");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGenOpenCL/str_literals.cl -cl-opt-disable -emit-llvm -o - -ffake-address-space-map | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenOpenCL/str_literals.cl
    RUN(TestState.Failed, "%clang_cc1 %s -cl-opt-disable -emit-llvm -o - -ffake-address-space-map")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_to_addr_builtin_cl() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenOpenCL/to_addr_builtin.cl");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple spir-unknown-unknown -emit-llvm -O0 -cl-std=CL2.0 -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGenOpenCL/to_addr_builtin.cl | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenOpenCL/to_addr_builtin.cl
    RUN(TestState.Failed, "%clang_cc1 -triple spir-unknown-unknown -emit-llvm -O0 -cl-std=CL2.0 -o - %s")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_unroll_hint_cl() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenOpenCL/unroll-hint.cl");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm -O0 -cl-std=CL2.0 -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGenOpenCL/unroll-hint.cl | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenOpenCL/unroll-hint.cl
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm -O0 -cl-std=CL2.0 -o - %s")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_vectorLoadStore_cl() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenOpenCL/vectorLoadStore.cl");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGenOpenCL/vectorLoadStore.cl -emit-llvm -O0 -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenOpenCL/vectorLoadStore.cl
    RUN(TestState.Failed, "%clang_cc1 %s -emit-llvm -O0 -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_vector_literals_nested_cl() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenOpenCL/vector_literals_nested.cl");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGenOpenCL/vector_literals_nested.cl -emit-llvm -O3 -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenOpenCL/vector_literals_nested.cl
    RUN(TestState.Failed, "%clang_cc1 %s -emit-llvm -O3 -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_vector_literals_valid_cl() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenOpenCL/vector_literals_valid.cl");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGenOpenCL/vector_literals_valid.cl -o ${TEST_TEMP_DIR}/vector_literals_valid.cl.tmp
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm %s -o %t");
  }

  @Test
  public void test_vector_logops_cl() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenOpenCL/vector_logops.cl");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -O3 ${LLVM_SRC}/llvm/tools/clang/test/CodeGenOpenCL/vector_logops.cl -emit-llvm -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenOpenCL/vector_logops.cl
    RUN(TestState.Failed, "%clang_cc1 -O3 %s -emit-llvm -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_vector_odd_cl() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenOpenCL/vector_odd.cl");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGenOpenCL/vector_odd.cl -O0 -emit-llvm -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenOpenCL/vector_odd.cl
    RUN(TestState.Failed, "%clang_cc1 %s -O0 -emit-llvm -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_vector_shufflevector_valid_cl() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenOpenCL/vector_shufflevector_valid.cl");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm -O0 ${LLVM_SRC}/llvm/tools/clang/test/CodeGenOpenCL/vector_shufflevector_valid.cl -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenOpenCL/vector_shufflevector_valid.cl
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm -O0 %s -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_vla_cl() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenOpenCL/vla.cl");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm -triple spir-unknown-unknown -O0 -cl-std=CL2.0 -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGenOpenCL/vla.cl | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenOpenCL/vla.cl
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm -triple \"spir-unknown-unknown\" -O0 -cl-std=CL2.0 -o - %s")./*|*/
      I("FileCheck %s");
  }
  
}
