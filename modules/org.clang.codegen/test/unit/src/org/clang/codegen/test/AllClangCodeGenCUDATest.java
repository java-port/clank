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
 * Collection of all test files from test/CodeGenCUDA folder
 * @author Vladimir Voskresensky
 */
@Ignore
public class AllClangCodeGenCUDATest extends DriverTestFileBase {
  private static final String TEST_LOCATION = "${LLVM_SRC}/llvm/tools/clang/test/CodeGenCUDA/";
  public AllClangCodeGenCUDATest() {
    super(TEST_LOCATION, TestState.Successful);
  }
  
  public static void main(String[] args) {
    // Print tests which will be accepted per test case
    DriverTestFileBase.printAllTestFiles(false, TEST_LOCATION, (test)->{ return true;/*test.getFileIndexInFolder()<120;*/ }, 
            "${SPUTNIK}/modules/org.clang.codegen/test/unit/src/org/clang/codegen/test/AllClangCodeGenCUDATest.txt");
  }  

  @Override
  protected boolean keepStacksForUnimplementedMethods() {
    return false;
  }
  
  @Test
  public void test_address_spaces_cu() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCUDA/address-spaces.cu");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCUDA/address-spaces.cu -o - -fcuda-is-device -triple nvptx-unknown-unknown | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCUDA/address-spaces.cu
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm %s -o - -fcuda-is-device -triple nvptx-unknown-unknown")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_alias_cu() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCUDA/alias.cu");
    // REQUIRES: x86-registered-target
    if (!CHECK_REQUIRES("x86-registered-target")) {
      return;
    }
    // REQUIRES: nvptx-registered-target
    if (!CHECK_REQUIRES("nvptx-registered-target")) {
      return;
    }
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fcuda-is-device -triple nvptx-nvidia-cuda -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCUDA/alias.cu | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCUDA/alias.cu
    RUN(TestState.Failed, "%clang_cc1 -fcuda-is-device -triple nvptx-nvidia-cuda -emit-llvm -o - %s")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_convergent_cu() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCUDA/convergent.cu");
    // REQUIRES: x86-registered-target
    if (!CHECK_REQUIRES("x86-registered-target")) {
      return;
    }
    // REQUIRES: nvptx-registered-target
    if (!CHECK_REQUIRES("nvptx-registered-target")) {
      return;
    }
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fcuda-is-device -triple nvptx-nvidia-cuda -emit-llvm -disable-llvm-passes -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCUDA/convergent.cu | ${LLVM_SRC}/build/bin/FileCheck -check-prefix DEVICE ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCUDA/convergent.cu
    RUN(TestState.Failed, "%clang_cc1 -fcuda-is-device -triple nvptx-nvidia-cuda -emit-llvm -disable-llvm-passes -o - %s")./*|*/
      I("FileCheck -check-prefix DEVICE %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-unknown-linux-gnu -emit-llvm -disable-llvm-passes -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCUDA/convergent.cu | ${LLVM_SRC}/build/bin/FileCheck -check-prefix HOST ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCUDA/convergent.cu
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-unknown-linux-gnu -emit-llvm -disable-llvm-passes -o - %s")./*|*/
      I("FileCheck -check-prefix HOST %s");
  }

  @Test
  public void test_cuda_builtin_vars_cu() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCUDA/cuda-builtin-vars.cu");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple nvptx-nvidia-cuda -emit-llvm -fcuda-is-device -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCUDA/cuda-builtin-vars.cu | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCUDA/cuda-builtin-vars.cu
    RUN(TestState.Failed, "%clang_cc1 \"-triple\" \"nvptx-nvidia-cuda\" -emit-llvm -fcuda-is-device -o - %s")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_device_stub_cu() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCUDA/device-stub.cu");
    // echo 'GPU binary would be here' > ${TEST_TEMP_DIR}/device-stub.cu.tmp
    RUN(TestState.Failed, "echo \"GPU binary would be here\" > %t");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-linux-gnu -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCUDA/device-stub.cu -fcuda-include-gpubinary ${TEST_TEMP_DIR}/device-stub.cu.tmp -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCUDA/device-stub.cu
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-linux-gnu -emit-llvm %s -fcuda-include-gpubinary %t -o -")./*|*/
      I("FileCheck %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-linux-gnu -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCUDA/device-stub.cu -fcuda-include-gpubinary ${TEST_TEMP_DIR}/device-stub.cu.tmp -o - -DNOGLOBALS | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCUDA/device-stub.cu -check-prefix=NOGLOBALS
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-linux-gnu -emit-llvm %s -fcuda-include-gpubinary %t -o -  -DNOGLOBALS")./*|*/
      I("FileCheck %s -check-prefix=NOGLOBALS");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-linux-gnu -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCUDA/device-stub.cu -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCUDA/device-stub.cu -check-prefix=NOGPUBIN
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-linux-gnu -emit-llvm %s -o -")./*|*/
      I("FileCheck %s -check-prefix=NOGPUBIN");
  }

  @Test
  public void test_device_var_init_cu() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCUDA/device-var-init.cu");
    // REQUIRES: nvptx-registered-target
    if (!CHECK_REQUIRES("nvptx-registered-target")) {
      return;
    }
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple nvptx64-nvidia-cuda -fcuda-is-device -std=c++11 -fno-threadsafe-statics -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCUDA/device-var-init.cu | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCUDA/device-var-init.cu
    RUN(TestState.Failed, "%clang_cc1 -triple nvptx64-nvidia-cuda -fcuda-is-device -std=c++11 -fno-threadsafe-statics -emit-llvm -o - %s")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_device_vtable_cu() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCUDA/device-vtable.cu");
    // REQUIRES: x86-registered-target
    if (!CHECK_REQUIRES("x86-registered-target")) {
      return;
    }
    // REQUIRES: nvptx-registered-target
    if (!CHECK_REQUIRES("nvptx-registered-target")) {
      return;
    }
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-unknown-linux-gnu -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCUDA/device-vtable.cu | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCUDA/device-vtable.cu -check-prefix=CHECK-HOST -check-prefix=CHECK-BOTH
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-unknown-linux-gnu -emit-llvm -o - %s")./*|*/
      I("FileCheck %s -check-prefix=CHECK-HOST -check-prefix=CHECK-BOTH");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple nvptx64-nvidia-cuda -fcuda-is-device -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCUDA/device-vtable.cu | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCUDA/device-vtable.cu -check-prefix=CHECK-DEVICE -check-prefix=CHECK-BOTH
    RUN(TestState.Failed, "%clang_cc1 -triple nvptx64-nvidia-cuda -fcuda-is-device -emit-llvm -o - %s")./*|*/
      I("FileCheck %s -check-prefix=CHECK-DEVICE -check-prefix=CHECK-BOTH");
  }

  @Test
  public void test_filter_decl_cu() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCUDA/filter-decl.cu");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i386-pc-solaris2.11 -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCUDA/filter-decl.cu -o - | ${LLVM_SRC}/build/bin/FileCheck -check-prefix=CHECK-HOST ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCUDA/filter-decl.cu
    RUN(TestState.Failed, "%clang_cc1 -triple %itanium_abi_triple -emit-llvm %s -o -")./*|*/
      I("FileCheck -check-prefix=CHECK-HOST %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i386-pc-solaris2.11 -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCUDA/filter-decl.cu -o - -fcuda-is-device | ${LLVM_SRC}/build/bin/FileCheck -check-prefix=CHECK-DEVICE ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCUDA/filter-decl.cu
    RUN(TestState.Failed, "%clang_cc1 -triple %itanium_abi_triple -emit-llvm %s -o - -fcuda-is-device")./*|*/
      I("FileCheck -check-prefix=CHECK-DEVICE %s");
  }

  @Test
  public void test_flush_denormals_cu() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCUDA/flush-denormals.cu");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fcuda-is-device -triple nvptx-nvidia-cuda -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCUDA/flush-denormals.cu | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCUDA/flush-denormals.cu -check-prefix CHECK -check-prefix NOFTZ
    RUN(TestState.Failed, "%clang_cc1 -fcuda-is-device -triple nvptx-nvidia-cuda -emit-llvm -o - %s")./*|*/
      I("FileCheck %s -check-prefix CHECK -check-prefix NOFTZ");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fcuda-is-device -fcuda-flush-denormals-to-zero -triple nvptx-nvidia-cuda -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCUDA/flush-denormals.cu | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCUDA/flush-denormals.cu -check-prefix CHECK -check-prefix FTZ
    RUN(TestState.Failed, "%clang_cc1 -fcuda-is-device -fcuda-flush-denormals-to-zero -triple nvptx-nvidia-cuda -emit-llvm -o - %s")./*|*/
      I("FileCheck %s -check-prefix CHECK -check-prefix FTZ");
  }

  @Test
  public void test_fp_contract_cu() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCUDA/fp-contract.cu");
    // REQUIRES: x86-registered-target
    if (!CHECK_REQUIRES("x86-registered-target")) {
      return;
    }
    // REQUIRES: nvptx-registered-target
    if (!CHECK_REQUIRES("nvptx-registered-target")) {
      return;
    }
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fcuda-is-device -triple nvptx-nvidia-cuda -S -disable-llvm-passes -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCUDA/fp-contract.cu | ${LLVM_SRC}/build/bin/FileCheck -check-prefix ENABLED ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCUDA/fp-contract.cu
    RUN(TestState.Failed, "%clang_cc1 -fcuda-is-device -triple nvptx-nvidia-cuda -S -disable-llvm-passes -o - %s")./*|*/
      I("FileCheck -check-prefix ENABLED %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fcuda-is-device -triple nvptx-nvidia-cuda -S -ffp-contract=fast -disable-llvm-passes -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCUDA/fp-contract.cu | ${LLVM_SRC}/build/bin/FileCheck -check-prefix ENABLED ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCUDA/fp-contract.cu
    RUN(TestState.Failed, "%clang_cc1 -fcuda-is-device -triple nvptx-nvidia-cuda -S -ffp-contract=fast -disable-llvm-passes -o - %s")./*|*/
      I("FileCheck -check-prefix ENABLED %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fcuda-is-device -triple nvptx-nvidia-cuda -S -ffp-contract=on -disable-llvm-passes -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCUDA/fp-contract.cu | ${LLVM_SRC}/build/bin/FileCheck -check-prefix DISABLED ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCUDA/fp-contract.cu
    RUN(TestState.Failed, "%clang_cc1 -fcuda-is-device -triple nvptx-nvidia-cuda -S -ffp-contract=on -disable-llvm-passes -o - %s")./*|*/
      I("FileCheck -check-prefix DISABLED %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fcuda-is-device -triple nvptx-nvidia-cuda -S -ffp-contract=off -disable-llvm-passes -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCUDA/fp-contract.cu | ${LLVM_SRC}/build/bin/FileCheck -check-prefix DISABLED ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCUDA/fp-contract.cu
    RUN(TestState.Failed, "%clang_cc1 -fcuda-is-device -triple nvptx-nvidia-cuda -S -ffp-contract=off -disable-llvm-passes -o - %s")./*|*/
      I("FileCheck -check-prefix DISABLED %s");
  }

  @Test
  public void test_function_overload_cu() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCUDA/function-overload.cu");
    // REQUIRES: x86-registered-target
    if (!CHECK_REQUIRES("x86-registered-target")) {
      return;
    }
    // REQUIRES: nvptx-registered-target
    if (!CHECK_REQUIRES("nvptx-registered-target")) {
      return;
    }
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-unknown-linux-gnu -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCUDA/function-overload.cu | ${LLVM_SRC}/build/bin/FileCheck -check-prefix=CHECK-BOTH -check-prefix=CHECK-HOST ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCUDA/function-overload.cu
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-unknown-linux-gnu -emit-llvm -o - %s")./*|*/
      I("FileCheck -check-prefix=CHECK-BOTH -check-prefix=CHECK-HOST %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple nvptx64-nvidia-cuda -fcuda-is-device -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCUDA/function-overload.cu | ${LLVM_SRC}/build/bin/FileCheck -check-prefix=CHECK-BOTH -check-prefix=CHECK-DEVICE ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCUDA/function-overload.cu
    RUN(TestState.Failed, "%clang_cc1 -triple nvptx64-nvidia-cuda -fcuda-is-device -emit-llvm -o - %s")./*|*/
      I("FileCheck -check-prefix=CHECK-BOTH -check-prefix=CHECK-DEVICE %s");
  }

  @Test
  public void test_host_device_calls_host_cu() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCUDA/host-device-calls-host.cu");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCUDA/host-device-calls-host.cu -triple nvptx-unknown-unknown -fcuda-is-device -Wno-cuda-compat -emit-llvm -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCUDA/host-device-calls-host.cu
    RUN(TestState.Failed, "%clang_cc1 %s -triple nvptx-unknown-unknown -fcuda-is-device -Wno-cuda-compat -emit-llvm -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_kernel_call_cu() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCUDA/kernel-call.cu");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCUDA/kernel-call.cu -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCUDA/kernel-call.cu
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm %s -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_launch_bounds_cu() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCUDA/launch-bounds.cu");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCUDA/launch-bounds.cu -triple nvptx-unknown-unknown -fcuda-is-device -emit-llvm -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCUDA/launch-bounds.cu
    RUN(TestState.Failed, "%clang_cc1 %s -triple nvptx-unknown-unknown -fcuda-is-device -emit-llvm -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_link_device_bitcode_cu() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCUDA/link-device-bitcode.cu");
    // REQUIRES: nvptx-registered-target
    if (!CHECK_REQUIRES("nvptx-registered-target")) {
      return;
    }
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple nvptx-unknown-cuda -emit-llvm-bc -disable-llvm-passes -o ${TEST_TEMP_DIR}/link-device-bitcode.cu.tmp.bc ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCUDA/Inputs/device-code.ll
    RUN(TestState.Failed, "%clang_cc1 -triple nvptx-unknown-cuda -emit-llvm-bc -disable-llvm-passes -o %t.bc %S/Inputs/device-code.ll");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple nvptx-unknown-cuda -emit-llvm-bc -disable-llvm-passes -o ${TEST_TEMP_DIR}/link-device-bitcode.cu.tmp-2.bc ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCUDA/Inputs/device-code-2.ll
    RUN(TestState.Failed, "%clang_cc1 -triple nvptx-unknown-cuda -emit-llvm-bc -disable-llvm-passes -o %t-2.bc %S/Inputs/device-code-2.ll");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple nvptx-unknown-cuda -fcuda-is-device -mlink-cuda-bitcode ${TEST_TEMP_DIR}/link-device-bitcode.cu.tmp.bc -emit-llvm -disable-llvm-passes -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCUDA/link-device-bitcode.cu | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCUDA/link-device-bitcode.cu -check-prefix CHECK-IR
    RUN(TestState.Failed, "%clang_cc1 -triple nvptx-unknown-cuda -fcuda-is-device -mlink-cuda-bitcode %t.bc  -emit-llvm -disable-llvm-passes -o - %s")./*|*/
      I("FileCheck %s -check-prefix CHECK-IR");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple nvptx-unknown-cuda -fcuda-is-device -mlink-cuda-bitcode ${TEST_TEMP_DIR}/link-device-bitcode.cu.tmp.bc -mlink-cuda-bitcode ${TEST_TEMP_DIR}/link-device-bitcode.cu.tmp-2.bc -emit-llvm -disable-llvm-passes -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCUDA/link-device-bitcode.cu | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCUDA/link-device-bitcode.cu -check-prefix CHECK-IR -check-prefix CHECK-IR-2
    RUN(TestState.Failed, "%clang_cc1 -triple nvptx-unknown-cuda -fcuda-is-device -mlink-cuda-bitcode %t.bc -mlink-cuda-bitcode %t-2.bc -emit-llvm -disable-llvm-passes -o - %s")./*|*/
      I("FileCheck %s -check-prefix CHECK-IR -check-prefix CHECK-IR-2");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple nvptx-unknown-cuda -fcuda-is-device -mlink-bitcode-file ${TEST_TEMP_DIR}/link-device-bitcode.cu.tmp.bc -emit-llvm -disable-llvm-passes -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCUDA/link-device-bitcode.cu | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCUDA/link-device-bitcode.cu -check-prefix CHECK-IR-NLD
    RUN(TestState.Failed, "%clang_cc1 -triple nvptx-unknown-cuda -fcuda-is-device -mlink-bitcode-file %t.bc -emit-llvm -disable-llvm-passes -o - %s")./*|*/
      I("FileCheck %s -check-prefix CHECK-IR-NLD");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple nvptx-unknown-cuda -fcuda-is-device -mlink-cuda-bitcode ${TEST_TEMP_DIR}/link-device-bitcode.cu.tmp.bc -S -o /dev/null ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCUDA/link-device-bitcode.cu -backend-option -debug-pass=Structure 2>&1 | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCUDA/link-device-bitcode.cu -check-prefix CHECK-REFLECT
    RUN(TestState.Failed, "%clang_cc1 -triple nvptx-unknown-cuda -fcuda-is-device -mlink-cuda-bitcode %t.bc -S -o /dev/null %s -backend-option -debug-pass=Structure 2>&1")./*|*/
      I("FileCheck %s -check-prefix CHECK-REFLECT");
  }

  @Test
  public void test_llvm_used_cu() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCUDA/llvm-used.cu");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCUDA/llvm-used.cu -o - -fcuda-is-device -triple nvptx64-unknown-unknown | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCUDA/llvm-used.cu
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm %s -o - -fcuda-is-device -triple nvptx64-unknown-unknown")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_printf_cu() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCUDA/printf.cu");
    // REQUIRES: x86-registered-target
    if (!CHECK_REQUIRES("x86-registered-target")) {
      return;
    }
    // REQUIRES: nvptx-registered-target
    if (!CHECK_REQUIRES("nvptx-registered-target")) {
      return;
    }
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple nvptx64-nvidia-cuda -fcuda-is-device -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCUDA/printf.cu | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCUDA/printf.cu
    RUN(TestState.Failed, "%clang_cc1 -triple nvptx64-nvidia-cuda -fcuda-is-device -emit-llvm -o - %s")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_printf_aggregate_cu() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCUDA/printf-aggregate.cu");
    // REQUIRES: x86-registered-target
    if (!CHECK_REQUIRES("x86-registered-target")) {
      return;
    }
    // REQUIRES: nvptx-registered-target
    if (!CHECK_REQUIRES("nvptx-registered-target")) {
      return;
    }
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple nvptx64-nvidia-cuda -fcuda-is-device -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCUDA/printf-aggregate.cu 2>&1 | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCUDA/printf-aggregate.cu
    RUN(TestState.Failed, "not %clang_cc1 -triple nvptx64-nvidia-cuda -fcuda-is-device -emit-llvm -o - %s 2>&1")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_ptx_kernels_cu() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCUDA/ptx-kernels.cu");
    // REQUIRES: nvptx-registered-target
    if (!CHECK_REQUIRES("nvptx-registered-target")) {
      return;
    }
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCUDA/ptx-kernels.cu -triple nvptx-unknown-unknown -fcuda-is-device -emit-llvm -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCUDA/ptx-kernels.cu
    RUN(TestState.Failed, "%clang_cc1 %s -triple nvptx-unknown-unknown -fcuda-is-device -emit-llvm -o -")./*|*/
      I("FileCheck %s");
  }
  
}
