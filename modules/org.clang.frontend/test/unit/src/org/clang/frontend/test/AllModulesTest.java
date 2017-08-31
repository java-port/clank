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
import org.junit.*;

/**
 * Collection of all test files from test/Modules folder
 * @author Vladimir Voskresensky
 */
public class AllModulesTest extends DriverTestFileBase {
  private static final String TEST_LOCATION = "${LLVM_SRC}/llvm/tools/clang/test/Modules/";
  public AllModulesTest() {
    super(TEST_LOCATION, TestState.Successful);
  }
  
  public static void main(String[] args) {
    // Print tests which will be accepted per test case
    DriverTestFileBase.printAllTestFiles(false, 
            TEST_LOCATION, (test)->{ return true;/*test.getFileIndexInFolder()<120;*/ }, 
            "${SPUTNIK}/modules/org.clang.frontend/test/unit/src/org/clang/frontend/test/AllModulesTest.txt");
  }  

  @Override
  protected boolean keepStacksForUnimplementedMethods() {
    return false;
  }
  
  @Test
  public void test_DebugInfoSubmoduleImport_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Modules/DebugInfoSubmoduleImport.c");
    // rm -rf ${TEST_TEMP_DIR}/DebugInfoSubmoduleImport.c.tmp
    RUN(TestState.Failed, "rm -rf %t");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fmodules -fmodule-format=obj -debug-info-kind=limited -dwarf-ext-refs -fimplicit-module-maps -x c '-fmodules-cache-path=${TEST_TEMP_DIR}/DebugInfoSubmoduleImport.c.tmp' -I ${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs ${LLVM_SRC}/llvm/tools/clang/test/Modules/DebugInfoSubmoduleImport.c -emit-llvm -debugger-tuning=lldb -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Modules/DebugInfoSubmoduleImport.c
    RUN(TestState.Failed, "%clang_cc1 -fmodules -fmodule-format=obj -debug-info-kind=limited -dwarf-ext-refs -fimplicit-module-maps -x c -fmodules-cache-path=%t -I %S/Inputs %s -emit-llvm -debugger-tuning=lldb -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_DebugInfoSubmodules_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Modules/DebugInfoSubmodules.c");
    // REQUIRES: asserts
    if (!CHECK_REQUIRES("asserts")) {
      return;
    }
    // rm -rf ${TEST_TEMP_DIR}/DebugInfoSubmodules.c.tmp
    RUN(TestState.Failed, "rm -rf %t");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fmodules -fmodule-format=obj -debug-info-kind=limited -dwarf-ext-refs -fimplicit-module-maps -x c '-fmodules-cache-path=${TEST_TEMP_DIR}/DebugInfoSubmodules.c.tmp' -I ${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs ${LLVM_SRC}/llvm/tools/clang/test/Modules/DebugInfoSubmodules.c -mllvm -debug-only=pchcontainer -emit-llvm -o ${TEST_TEMP_DIR}/DebugInfoSubmodules.c.tmp.ll 2>&1 | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Modules/DebugInfoSubmodules.c
    RUN(TestState.Failed, "%clang_cc1 -fmodules -fmodule-format=obj -debug-info-kind=limited -dwarf-ext-refs -fimplicit-module-maps -x c -fmodules-cache-path=%t -I %S/Inputs %s -mllvm -debug-only=pchcontainer -emit-llvm -o %t.ll 2>&1")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_DebugInfoTransitiveImport_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Modules/DebugInfoTransitiveImport.m");
    // REQUIRES: asserts
    if (!CHECK_REQUIRES("asserts")) {
      return;
    }
    // rm -rf ${TEST_TEMP_DIR}/DebugInfoTransitiveImport.m.tmp
    RUN(TestState.Failed, "rm -rf %t");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fmodules -fmodule-format=obj -debug-info-kind=limited -dwarf-ext-refs -fimplicit-module-maps '-fmodules-cache-path=${TEST_TEMP_DIR}/DebugInfoTransitiveImport.m.tmp' -I ${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs ${LLVM_SRC}/llvm/tools/clang/test/Modules/DebugInfoTransitiveImport.m -mllvm -debug-only=pchcontainer -debugger-tuning=lldb 2>&1 | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Modules/DebugInfoTransitiveImport.m
    RUN(TestState.Failed, "%clang_cc1 -fmodules -fmodule-format=obj -debug-info-kind=limited -dwarf-ext-refs -fimplicit-module-maps -fmodules-cache-path=%t -I %S/Inputs %s -mllvm -debug-only=pchcontainer -debugger-tuning=lldb 2>&1")./*|*/
      I("FileCheck %s");
    // rm -rf ${TEST_TEMP_DIR}/DebugInfoTransitiveImport.m.tmp
    RUN(TestState.Failed, "rm -rf %t");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fmodules -fmodule-format=obj -debug-info-kind=limited -dwarf-ext-refs -fimplicit-module-maps '-fmodules-cache-path=${TEST_TEMP_DIR}/DebugInfoTransitiveImport.m.tmp' -I ${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs ${LLVM_SRC}/llvm/tools/clang/test/Modules/DebugInfoTransitiveImport.m -mllvm -debug-only=pchcontainer 2>&1 | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Modules/DebugInfoTransitiveImport.m --check-prefix=NOIMPORT
    RUN(TestState.Failed, "%clang_cc1 -fmodules -fmodule-format=obj -debug-info-kind=limited -dwarf-ext-refs -fimplicit-module-maps -fmodules-cache-path=%t -I %S/Inputs %s -mllvm -debug-only=pchcontainer 2>&1")./*|*/
      I("FileCheck %s --check-prefix=NOIMPORT");
  }

  @Test
  public void test_ExtDebugInfo_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Modules/ExtDebugInfo.cpp");
    // rm -rf ${TEST_TEMP_DIR}/ExtDebugInfo.cpp.tmp
    RUN(TestState.Failed, "rm -rf %t");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x objective-c++ -std=c++11 -debug-info-kind=standalone -dwarf-ext-refs -fmodules -fmodule-format=obj -fimplicit-module-maps -DMODULES -triple i386-pc-solaris2.11 '-fmodules-cache-path=${TEST_TEMP_DIR}/ExtDebugInfo.cpp.tmp' ${LLVM_SRC}/llvm/tools/clang/test/Modules/ExtDebugInfo.cpp -I ${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs -I ${TEST_TEMP_DIR}/ExtDebugInfo.cpp.tmp -emit-llvm -o ${TEST_TEMP_DIR}/ExtDebugInfo.cpp.tmp-mod.ll
    RUN(TestState.Failed, "%clang_cc1 -x objective-c++ -std=c++11 -debug-info-kind=standalone -dwarf-ext-refs -fmodules -fmodule-format=obj -fimplicit-module-maps -DMODULES -triple %itanium_abi_triple -fmodules-cache-path=%t %s -I %S/Inputs -I %t -emit-llvm -o %t-mod.ll");
    // cat ${TEST_TEMP_DIR}/ExtDebugInfo.cpp.tmp-mod.ll | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Modules/ExtDebugInfo.cpp
    RUN(TestState.Failed, "cat %t-mod.ll")./*|*/
      I("FileCheck %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x c++ -std=c++11 -fmodule-format=obj -emit-pch '-I${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs' -triple i386-pc-solaris2.11 -o ${TEST_TEMP_DIR}/ExtDebugInfo.cpp.tmp.pch ${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs/DebugCXX.h
    RUN(TestState.Failed, "%clang_cc1 -x c++ -std=c++11 -fmodule-format=obj -emit-pch -I%S/Inputs -triple %itanium_abi_triple -o %t.pch %S/Inputs/DebugCXX.h");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c++11 -debug-info-kind=standalone -dwarf-ext-refs -fmodule-format=obj -triple i386-pc-solaris2.11 -include-pch ${TEST_TEMP_DIR}/ExtDebugInfo.cpp.tmp.pch ${LLVM_SRC}/llvm/tools/clang/test/Modules/ExtDebugInfo.cpp -emit-llvm -o ${TEST_TEMP_DIR}/ExtDebugInfo.cpp.tmp-pch.ll ${LLVM_SRC}/llvm/tools/clang/test/Modules/ExtDebugInfo.cpp
    RUN(TestState.Failed, "%clang_cc1 -std=c++11 -debug-info-kind=standalone -dwarf-ext-refs -fmodule-format=obj -triple %itanium_abi_triple -include-pch %t.pch %s -emit-llvm -o %t-pch.ll %s");
    // cat ${TEST_TEMP_DIR}/ExtDebugInfo.cpp.tmp-pch.ll | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Modules/ExtDebugInfo.cpp
    RUN(TestState.Failed, "cat %t-pch.ll")./*|*/
      I("FileCheck %s");
    // cat ${TEST_TEMP_DIR}/ExtDebugInfo.cpp.tmp-pch.ll | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Modules/ExtDebugInfo.cpp --check-prefix=CHECK-PCH
    RUN(TestState.Failed, "cat %t-pch.ll")./*|*/
      I("FileCheck %s --check-prefix=CHECK-PCH");
  }

  @Test
  public void test_ExtDebugInfo_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Modules/ExtDebugInfo.m");
    // rm -rf ${TEST_TEMP_DIR}/ExtDebugInfo.m.tmp
    RUN(TestState.Failed, "rm -rf %t");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x objective-c -debug-info-kind=limited -dwarf-ext-refs -fmodules -fmodule-format=obj -fimplicit-module-maps -DMODULES '-fmodules-cache-path=${TEST_TEMP_DIR}/ExtDebugInfo.m.tmp' ${LLVM_SRC}/llvm/tools/clang/test/Modules/ExtDebugInfo.m -I ${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs -I ${TEST_TEMP_DIR}/ExtDebugInfo.m.tmp -emit-llvm -o ${TEST_TEMP_DIR}/ExtDebugInfo.m.tmp-mod.ll
    RUN(TestState.Failed, "%clang_cc1 -x objective-c -debug-info-kind=limited -dwarf-ext-refs -fmodules -fmodule-format=obj -fimplicit-module-maps -DMODULES -fmodules-cache-path=%t %s -I %S/Inputs -I %t -emit-llvm -o %t-mod.ll");
    // cat ${TEST_TEMP_DIR}/ExtDebugInfo.m.tmp-mod.ll | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Modules/ExtDebugInfo.m
    RUN(TestState.Failed, "cat %t-mod.ll")./*|*/
      I("FileCheck %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x objective-c -fmodule-format=obj -emit-pch '-I${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs' -o ${TEST_TEMP_DIR}/ExtDebugInfo.m.tmp.pch ${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs/DebugObjC.h
    RUN(TestState.Failed, "%clang_cc1 -x objective-c -fmodule-format=obj -emit-pch -I%S/Inputs -o %t.pch %S/Inputs/DebugObjC.h");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x objective-c -debug-info-kind=limited -dwarf-ext-refs -fmodule-format=obj -include-pch ${TEST_TEMP_DIR}/ExtDebugInfo.m.tmp.pch ${LLVM_SRC}/llvm/tools/clang/test/Modules/ExtDebugInfo.m -emit-llvm -o ${TEST_TEMP_DIR}/ExtDebugInfo.m.tmp-pch.ll ${LLVM_SRC}/llvm/tools/clang/test/Modules/ExtDebugInfo.m
    RUN(TestState.Failed, "%clang_cc1 -x objective-c -debug-info-kind=limited -dwarf-ext-refs -fmodule-format=obj -include-pch %t.pch %s -emit-llvm -o %t-pch.ll %s");
    // cat ${TEST_TEMP_DIR}/ExtDebugInfo.m.tmp-pch.ll | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Modules/ExtDebugInfo.m
    RUN(TestState.Failed, "cat %t-pch.ll")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_ModuleDebugInfo_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Modules/ModuleDebugInfo.cpp");
    // REQUIRES: asserts, shell
    if (!CHECK_REQUIRES("asserts, shell")) {
      return;
    }
    // rm -rf ${TEST_TEMP_DIR}/ModuleDebugInfo.cpp.tmp
    RUN(TestState.Failed, "rm -rf %t");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i386-pc-solaris2.11 -x objective-c++ -std=c++11 -debug-info-kind=limited -fmodules -fmodule-format=obj -fimplicit-module-maps -DMODULES '-fmodules-cache-path=${TEST_TEMP_DIR}/ModuleDebugInfo.cpp.tmp' ${LLVM_SRC}/llvm/tools/clang/test/Modules/ModuleDebugInfo.cpp -I ${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs -I ${TEST_TEMP_DIR}/ModuleDebugInfo.cpp.tmp -emit-llvm -o ${TEST_TEMP_DIR}/ModuleDebugInfo.cpp.tmp.ll -mllvm -debug-only=pchcontainer '&>${TEST_TEMP_DIR}/ModuleDebugInfo.cpp.tmp-mod.ll'
    RUN(TestState.Failed, "%clang_cc1 -triple %itanium_abi_triple -x objective-c++ -std=c++11 -debug-info-kind=limited -fmodules -fmodule-format=obj -fimplicit-module-maps -DMODULES -fmodules-cache-path=%t %s -I %S/Inputs -I %t -emit-llvm -o %t.ll -mllvm -debug-only=pchcontainer &>%t-mod.ll");
    // cat ${TEST_TEMP_DIR}/ModuleDebugInfo.cpp.tmp-mod.ll | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Modules/ModuleDebugInfo.cpp
    RUN(TestState.Failed, "cat %t-mod.ll")./*|*/
      I("FileCheck %s");
    // cat ${TEST_TEMP_DIR}/ModuleDebugInfo.cpp.tmp-mod.ll | ${LLVM_SRC}/build/bin/FileCheck --check-prefix=CHECK-NEG ${LLVM_SRC}/llvm/tools/clang/test/Modules/ModuleDebugInfo.cpp
    RUN(TestState.Failed, "cat %t-mod.ll")./*|*/
      I("FileCheck --check-prefix=CHECK-NEG %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i386-pc-solaris2.11 -x c++ -std=c++11 -emit-pch -fmodule-format=obj -I ${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs -o ${TEST_TEMP_DIR}/ModuleDebugInfo.cpp.tmp.pch ${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs/DebugCXX.h -mllvm -debug-only=pchcontainer '&>${TEST_TEMP_DIR}/ModuleDebugInfo.cpp.tmp-pch.ll'
    RUN(TestState.Failed, "%clang_cc1 -triple %itanium_abi_triple -x c++ -std=c++11 -emit-pch -fmodule-format=obj -I %S/Inputs -o %t.pch %S/Inputs/DebugCXX.h -mllvm -debug-only=pchcontainer &>%t-pch.ll");
    // cat ${TEST_TEMP_DIR}/ModuleDebugInfo.cpp.tmp-pch.ll | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Modules/ModuleDebugInfo.cpp
    RUN(TestState.Failed, "cat %t-pch.ll")./*|*/
      I("FileCheck %s");
    // cat ${TEST_TEMP_DIR}/ModuleDebugInfo.cpp.tmp-pch.ll | ${LLVM_SRC}/build/bin/FileCheck --check-prefix=CHECK-NEG ${LLVM_SRC}/llvm/tools/clang/test/Modules/ModuleDebugInfo.cpp
    RUN(TestState.Failed, "cat %t-pch.ll")./*|*/
      I("FileCheck --check-prefix=CHECK-NEG %s");
  }

  @Test
  public void test_ModuleDebugInfo_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Modules/ModuleDebugInfo.m");
    // REQUIRES: asserts, shell
    if (!CHECK_REQUIRES("asserts, shell")) {
      return;
    }
    // rm -rf ${TEST_TEMP_DIR}/ModuleDebugInfo.m.tmp
    RUN(TestState.Failed, "rm -rf %t");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x objective-c -fmodules -fmodule-format=obj -fimplicit-module-maps -DMODULES '-fmodules-cache-path=${TEST_TEMP_DIR}/ModuleDebugInfo.m.tmp' ${LLVM_SRC}/llvm/tools/clang/test/Modules/ModuleDebugInfo.m -I ${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs -I ${TEST_TEMP_DIR}/ModuleDebugInfo.m.tmp -emit-llvm -o ${TEST_TEMP_DIR}/ModuleDebugInfo.m.tmp.ll -mllvm -debug-only=pchcontainer '&>${TEST_TEMP_DIR}/ModuleDebugInfo.m.tmp-mod.ll'
    RUN(TestState.Failed, "%clang_cc1 -x objective-c -fmodules -fmodule-format=obj -fimplicit-module-maps -DMODULES -fmodules-cache-path=%t %s -I %S/Inputs -I %t -emit-llvm -o %t.ll -mllvm -debug-only=pchcontainer &>%t-mod.ll");
    // cat ${TEST_TEMP_DIR}/ModuleDebugInfo.m.tmp-mod.ll | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Modules/ModuleDebugInfo.m
    RUN(TestState.Failed, "cat %t-mod.ll")./*|*/
      I("FileCheck %s");
    // cat ${TEST_TEMP_DIR}/ModuleDebugInfo.m.tmp-mod.ll | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Modules/ModuleDebugInfo.m --check-prefix=CHECK2
    RUN(TestState.Failed, "cat %t-mod.ll")./*|*/
      I("FileCheck %s --check-prefix=CHECK2");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x objective-c -emit-pch -fmodule-format=obj -I ${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs -o ${TEST_TEMP_DIR}/ModuleDebugInfo.m.tmp.pch ${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs/DebugObjC.h -mllvm -debug-only=pchcontainer '&>${TEST_TEMP_DIR}/ModuleDebugInfo.m.tmp-pch.ll'
    RUN(TestState.Failed, "%clang_cc1 -x objective-c -emit-pch -fmodule-format=obj -I %S/Inputs -o %t.pch %S/Inputs/DebugObjC.h -mllvm -debug-only=pchcontainer &>%t-pch.ll");
    // cat ${TEST_TEMP_DIR}/ModuleDebugInfo.m.tmp-pch.ll | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Modules/ModuleDebugInfo.m
    RUN(TestState.Failed, "cat %t-pch.ll")./*|*/
      I("FileCheck %s");
    // cat ${TEST_TEMP_DIR}/ModuleDebugInfo.m.tmp-pch.ll | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Modules/ModuleDebugInfo.m --check-prefix=CHECK2
    RUN(TestState.Failed, "cat %t-pch.ll")./*|*/
      I("FileCheck %s --check-prefix=CHECK2");
  }

  @Test
  public void test_Rmodule_build_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Modules/Rmodule-build.m");
    // rm -rf ${TEST_TEMP_DIR}/Rmodule-build.m.tmp
    RUN("rm -rf %t");
    // mkdir ${TEST_TEMP_DIR}/Rmodule-build.m.tmp
    RUN("mkdir %t");
    // echo '// A' > ${TEST_TEMP_DIR}/Rmodule-build.m.tmp/A.h
    RUN("echo '// A' > %t/A.h");
    // echo '#include "C.h"' > ${TEST_TEMP_DIR}/Rmodule-build.m.tmp/B.h
    RUN("echo '#include \"C.h\"' > %t/B.h");
    // echo '// C' > ${TEST_TEMP_DIR}/Rmodule-build.m.tmp/C.h
    RUN("echo '// C' > %t/C.h");
    // echo 'module A { header "A.h" }' > ${TEST_TEMP_DIR}/Rmodule-build.m.tmp/module.modulemap
    RUN("echo 'module A { header \"A.h\" }' > %t/module.modulemap");
    // echo 'module B { header "B.h" }' >> ${TEST_TEMP_DIR}/Rmodule-build.m.tmp/module.modulemap
    RUN("echo 'module B { header \"B.h\" }' >> %t/module.modulemap");
    // echo 'module C { header "C.h" }' >> ${TEST_TEMP_DIR}/Rmodule-build.m.tmp/module.modulemap
    RUN("echo 'module C { header \"C.h\" }' >> %t/module.modulemap");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fmodules -fimplicit-module-maps '-fmodules-cache-path=${TEST_TEMP_DIR}/Rmodule-build.m.tmp' -fsyntax-only ${LLVM_SRC}/llvm/tools/clang/test/Modules/Rmodule-build.m -verify -I ${TEST_TEMP_DIR}/Rmodule-build.m.tmp -Rmodule-build
    RUN("%clang_cc1 -fmodules -fimplicit-module-maps -fmodules-cache-path=%t -fsyntax-only %s -verify -I %t -Rmodule-build");
    // echo ' ' >> ${TEST_TEMP_DIR}/Rmodule-build.m.tmp/C.h
    RUN("echo ' ' >> %t/C.h");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fmodules -fimplicit-module-maps '-fmodules-cache-path=${TEST_TEMP_DIR}/Rmodule-build.m.tmp' -fsyntax-only ${LLVM_SRC}/llvm/tools/clang/test/Modules/Rmodule-build.m -I ${TEST_TEMP_DIR}/Rmodule-build.m.tmp -Rmodule-build 2>&1 | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Modules/Rmodule-build.m
    RUN("%clang_cc1 -fmodules -fimplicit-module-maps -fmodules-cache-path=%t -fsyntax-only %s -I %t -Rmodule-build 2>&1")./*|*/
      I("FileCheck %s");
    // echo ' ' >> ${TEST_TEMP_DIR}/Rmodule-build.m.tmp/C.h
    RUN("echo ' ' >> %t/C.h");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fmodules -fimplicit-module-maps '-fmodules-cache-path=${TEST_TEMP_DIR}/Rmodule-build.m.tmp' -fsyntax-only ${LLVM_SRC}/llvm/tools/clang/test/Modules/Rmodule-build.m -I ${TEST_TEMP_DIR}/Rmodule-build.m.tmp -Reverything 2>&1 | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Modules/Rmodule-build.m
    RUN("%clang_cc1 -fmodules -fimplicit-module-maps -fmodules-cache-path=%t -fsyntax-only %s -I %t -Reverything 2>&1")./*|*/
      I("FileCheck %s");
    // echo ' ' >> ${TEST_TEMP_DIR}/Rmodule-build.m.tmp/B.h
    RUN("echo ' ' >> %t/B.h");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fmodules -fimplicit-module-maps '-fmodules-cache-path=${TEST_TEMP_DIR}/Rmodule-build.m.tmp' -fsyntax-only ${LLVM_SRC}/llvm/tools/clang/test/Modules/Rmodule-build.m -I ${TEST_TEMP_DIR}/Rmodule-build.m.tmp 2>&1 | ${LLVM_SRC}/build/bin/FileCheck -allow-empty -check-prefix=NO-REMARKS ${LLVM_SRC}/llvm/tools/clang/test/Modules/Rmodule-build.m
    RUN("%clang_cc1 -fmodules -fimplicit-module-maps -fmodules-cache-path=%t -fsyntax-only %s -I %t 2>&1")./*|*/
      I("FileCheck -allow-empty -check-prefix=NO-REMARKS %s");
    // echo ' ' >> ${TEST_TEMP_DIR}/Rmodule-build.m.tmp/B.h
    RUN("echo ' ' >> %t/B.h");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fmodules -fimplicit-module-maps '-fmodules-cache-path=${TEST_TEMP_DIR}/Rmodule-build.m.tmp' -fsyntax-only ${LLVM_SRC}/llvm/tools/clang/test/Modules/Rmodule-build.m -I ${TEST_TEMP_DIR}/Rmodule-build.m.tmp -Rmodule-build -Rno-everything 2>&1 | ${LLVM_SRC}/build/bin/FileCheck -allow-empty -check-prefix=NO-REMARKS ${LLVM_SRC}/llvm/tools/clang/test/Modules/Rmodule-build.m
    RUN("%clang_cc1 -fmodules -fimplicit-module-maps -fmodules-cache-path=%t -fsyntax-only %s -I %t -Rmodule-build -Rno-everything 2>&1")./*|*/
      I("FileCheck -allow-empty -check-prefix=NO-REMARKS %s");
  }

  @Test
  public void test_Werror_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Modules/Werror.m");
    // rm -rf ${TEST_TEMP_DIR}/Werror.m.tmp
    RUN("rm -rf %t");
    // rm -rf ${TEST_TEMP_DIR}/Werror.m.tmp-saved
    RUN("rm -rf %t-saved");
    // mkdir -p ${TEST_TEMP_DIR}/Werror.m.tmp-saved
    RUN("mkdir -p %t-saved");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fmodules -fimplicit-module-maps '-fmodules-cache-path=${TEST_TEMP_DIR}/Werror.m.tmp' -fdisable-module-hash -F ${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs -fsyntax-only ${LLVM_SRC}/llvm/tools/clang/test/Modules/Werror.m -verify -Wno-incomplete-umbrella -Werror=header-guard
    RUN("%clang_cc1 -fmodules -fimplicit-module-maps -fmodules-cache-path=%t -fdisable-module-hash -F %S/Inputs -fsyntax-only %s -verify -Wno-incomplete-umbrella -Werror=header-guard");
    // cp ${TEST_TEMP_DIR}/Werror.m.tmp/Module.pcm ${TEST_TEMP_DIR}/Werror.m.tmp-saved/Module.pcm
    RUN("cp %t/Module.pcm %t-saved/Module.pcm");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fmodules -fimplicit-module-maps '-fmodules-cache-path=${TEST_TEMP_DIR}/Werror.m.tmp' -fdisable-module-hash -F ${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs -fsyntax-only ${LLVM_SRC}/llvm/tools/clang/test/Modules/Werror.m -verify -Wno-incomplete-umbrella
    RUN("%clang_cc1 -fmodules -fimplicit-module-maps -fmodules-cache-path=%t -fdisable-module-hash -F %S/Inputs -fsyntax-only %s -verify -Wno-incomplete-umbrella");
    // diff ${TEST_TEMP_DIR}/Werror.m.tmp/Module.pcm ${TEST_TEMP_DIR}/Werror.m.tmp-saved/Module.pcm
    RUN("diff %t/Module.pcm %t-saved/Module.pcm");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fmodules -fimplicit-module-maps '-fmodules-cache-path=${TEST_TEMP_DIR}/Werror.m.tmp' -fdisable-module-hash -F ${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs -fsyntax-only ${LLVM_SRC}/llvm/tools/clang/test/Modules/Werror.m -verify -Wno-incomplete-umbrella -Werror -Wno-incomplete-umbrella
    RUN("%clang_cc1 -fmodules -fimplicit-module-maps -fmodules-cache-path=%t -fdisable-module-hash -F %S/Inputs -fsyntax-only %s -verify -Wno-incomplete-umbrella -Werror -Wno-incomplete-umbrella");
    // diff ${TEST_TEMP_DIR}/Werror.m.tmp/Module.pcm ${TEST_TEMP_DIR}/Werror.m.tmp-saved/Module.pcm
    RUN("not diff %t/Module.pcm %t-saved/Module.pcm");
    // cp ${TEST_TEMP_DIR}/Werror.m.tmp/Module.pcm ${TEST_TEMP_DIR}/Werror.m.tmp-saved/Module.pcm
    RUN("cp %t/Module.pcm %t-saved/Module.pcm");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fmodules -fimplicit-module-maps '-fmodules-cache-path=${TEST_TEMP_DIR}/Werror.m.tmp' -fdisable-module-hash -F ${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs -fsyntax-only ${LLVM_SRC}/llvm/tools/clang/test/Modules/Werror.m -verify -Wno-incomplete-umbrella -Werror=header-guard -Wno-incomplete-umbrella
    RUN("%clang_cc1 -fmodules -fimplicit-module-maps -fmodules-cache-path=%t -fdisable-module-hash -F %S/Inputs -fsyntax-only %s -verify -Wno-incomplete-umbrella -Werror=header-guard -Wno-incomplete-umbrella");
    // diff ${TEST_TEMP_DIR}/Werror.m.tmp/Module.pcm ${TEST_TEMP_DIR}/Werror.m.tmp-saved/Module.pcm
    RUN("diff %t/Module.pcm %t-saved/Module.pcm");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fmodules -fimplicit-module-maps '-fmodules-cache-path=${TEST_TEMP_DIR}/Werror.m.tmp' -fdisable-module-hash -F ${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs -fsyntax-only ${LLVM_SRC}/llvm/tools/clang/test/Modules/Werror.m -verify -Wno-incomplete-umbrella -Werror=unused
    RUN("%clang_cc1 -fmodules -fimplicit-module-maps -fmodules-cache-path=%t -fdisable-module-hash -F %S/Inputs -fsyntax-only %s -verify -Wno-incomplete-umbrella -Werror=unused");
    // diff ${TEST_TEMP_DIR}/Werror.m.tmp/Module.pcm ${TEST_TEMP_DIR}/Werror.m.tmp-saved/Module.pcm
    RUN("not diff %t/Module.pcm %t-saved/Module.pcm");
    // cp ${TEST_TEMP_DIR}/Werror.m.tmp/Module.pcm ${TEST_TEMP_DIR}/Werror.m.tmp-saved/Module.pcm
    RUN("cp %t/Module.pcm %t-saved/Module.pcm");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fmodules -fimplicit-module-maps '-fmodules-cache-path=${TEST_TEMP_DIR}/Werror.m.tmp' -fdisable-module-hash -F ${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs -fsyntax-only ${LLVM_SRC}/llvm/tools/clang/test/Modules/Werror.m -verify -Wno-incomplete-umbrella -Werror -Wno-incomplete-umbrella
    RUN("%clang_cc1 -fmodules -fimplicit-module-maps -fmodules-cache-path=%t -fdisable-module-hash -F %S/Inputs -fsyntax-only %s -verify -Wno-incomplete-umbrella -Werror -Wno-incomplete-umbrella");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fmodules -fimplicit-module-maps '-fmodules-cache-path=${TEST_TEMP_DIR}/Werror.m.tmp' -fdisable-module-hash -F ${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs -fsyntax-only ${LLVM_SRC}/llvm/tools/clang/test/Modules/Werror.m -verify -Wno-incomplete-umbrella -Wno-everything -Wall -Werror
    RUN("%clang_cc1 -fmodules -fimplicit-module-maps -fmodules-cache-path=%t -fdisable-module-hash -F %S/Inputs -fsyntax-only %s -verify -Wno-incomplete-umbrella -Wno-everything -Wall -Werror");
    // cp ${TEST_TEMP_DIR}/Werror.m.tmp/Module.pcm ${TEST_TEMP_DIR}/Werror.m.tmp-saved/Module.pcm
    RUN("cp %t/Module.pcm %t-saved/Module.pcm");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fmodules -fimplicit-module-maps '-fmodules-cache-path=${TEST_TEMP_DIR}/Werror.m.tmp' -fdisable-module-hash -F ${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs -fsyntax-only ${LLVM_SRC}/llvm/tools/clang/test/Modules/Werror.m -verify -Wno-incomplete-umbrella -Wall -Werror
    RUN("%clang_cc1 -fmodules -fimplicit-module-maps -fmodules-cache-path=%t -fdisable-module-hash -F %S/Inputs -fsyntax-only %s -verify -Wno-incomplete-umbrella -Wall -Werror");
    // diff ${TEST_TEMP_DIR}/Werror.m.tmp/Module.pcm ${TEST_TEMP_DIR}/Werror.m.tmp-saved/Module.pcm
    RUN("not diff %t/Module.pcm %t-saved/Module.pcm");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fmodules -fimplicit-module-maps '-fmodules-cache-path=${TEST_TEMP_DIR}/Werror.m.tmp' -fdisable-module-hash -F ${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs -fsyntax-only ${LLVM_SRC}/llvm/tools/clang/test/Modules/Werror.m -verify -Wno-incomplete-umbrella -Werror -pedantic
    RUN("%clang_cc1 -fmodules -fimplicit-module-maps -fmodules-cache-path=%t -fdisable-module-hash -F %S/Inputs -fsyntax-only %s -verify -Wno-incomplete-umbrella -Werror -pedantic");
    // diff ${TEST_TEMP_DIR}/Werror.m.tmp/Module.pcm ${TEST_TEMP_DIR}/Werror.m.tmp-saved/Module.pcm
    RUN("not diff %t/Module.pcm %t-saved/Module.pcm");
    // cp ${TEST_TEMP_DIR}/Werror.m.tmp/Module.pcm ${TEST_TEMP_DIR}/Werror.m.tmp-saved/Module.pcm
    RUN("cp %t/Module.pcm %t-saved/Module.pcm");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fmodules -fimplicit-module-maps '-fmodules-cache-path=${TEST_TEMP_DIR}/Werror.m.tmp' -fdisable-module-hash -F ${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs -fsyntax-only ${LLVM_SRC}/llvm/tools/clang/test/Modules/Werror.m -verify -Wno-incomplete-umbrella -pedantic-errors
    RUN("%clang_cc1 -fmodules -fimplicit-module-maps -fmodules-cache-path=%t -fdisable-module-hash -F %S/Inputs -fsyntax-only %s -verify -Wno-incomplete-umbrella -pedantic-errors");
    // diff ${TEST_TEMP_DIR}/Werror.m.tmp/Module.pcm ${TEST_TEMP_DIR}/Werror.m.tmp-saved/Module.pcm
    RUN("diff %t/Module.pcm %t-saved/Module.pcm");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fmodules -fimplicit-module-maps '-fmodules-cache-path=${TEST_TEMP_DIR}/Werror.m.tmp' -fdisable-module-hash -F ${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs -fsyntax-only ${LLVM_SRC}/llvm/tools/clang/test/Modules/Werror.m -verify -Wno-incomplete-umbrella -pedantic-errors -Wsystem-headers
    RUN("%clang_cc1 -fmodules -fimplicit-module-maps -fmodules-cache-path=%t -fdisable-module-hash -F %S/Inputs -fsyntax-only %s -verify -Wno-incomplete-umbrella -pedantic-errors -Wsystem-headers");
    // diff ${TEST_TEMP_DIR}/Werror.m.tmp/Module.pcm ${TEST_TEMP_DIR}/Werror.m.tmp-saved/Module.pcm
    RUN("diff %t/Module.pcm %t-saved/Module.pcm");
  }

  @Test
  public void test_Werror_Wsystem_headers_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Modules/Werror-Wsystem-headers.m");
    // rm -rf ${TEST_TEMP_DIR}/Werror-Wsystem-headers.m.tmp
    RUN("rm -rf %t");
    // rm -rf ${TEST_TEMP_DIR}/Werror-Wsystem-headers.m.tmp-saved
    RUN("rm -rf %t-saved");
    // mkdir ${TEST_TEMP_DIR}/Werror-Wsystem-headers.m.tmp-saved
    RUN("mkdir %t-saved");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fmodules -fimplicit-module-maps '-fmodules-cache-path=${TEST_TEMP_DIR}/Werror-Wsystem-headers.m.tmp' -fdisable-module-hash -isystem ${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs/System/usr/include -fsyntax-only ${LLVM_SRC}/llvm/tools/clang/test/Modules/Werror-Wsystem-headers.m -verify
    RUN("%clang_cc1 -fmodules -fimplicit-module-maps -fmodules-cache-path=%t -fdisable-module-hash -isystem %S/Inputs/System/usr/include -fsyntax-only %s -verify");
    // cp ${TEST_TEMP_DIR}/Werror-Wsystem-headers.m.tmp/cstd.pcm ${TEST_TEMP_DIR}/Werror-Wsystem-headers.m.tmp-saved/cstd.pcm
    RUN("cp %t/cstd.pcm %t-saved/cstd.pcm");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fmodules -fimplicit-module-maps '-fmodules-cache-path=${TEST_TEMP_DIR}/Werror-Wsystem-headers.m.tmp' -fdisable-module-hash -isystem ${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs/System/usr/include -fsyntax-only ${LLVM_SRC}/llvm/tools/clang/test/Modules/Werror-Wsystem-headers.m -verify -Werror
    RUN("%clang_cc1 -fmodules -fimplicit-module-maps -fmodules-cache-path=%t -fdisable-module-hash -isystem %S/Inputs/System/usr/include -fsyntax-only %s -verify -Werror");
    // diff ${TEST_TEMP_DIR}/Werror-Wsystem-headers.m.tmp/cstd.pcm ${TEST_TEMP_DIR}/Werror-Wsystem-headers.m.tmp-saved/cstd.pcm
    RUN("diff %t/cstd.pcm %t-saved/cstd.pcm");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fmodules -fimplicit-module-maps '-fmodules-cache-path=${TEST_TEMP_DIR}/Werror-Wsystem-headers.m.tmp' -fdisable-module-hash -isystem ${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs/System/usr/include -fsyntax-only ${LLVM_SRC}/llvm/tools/clang/test/Modules/Werror-Wsystem-headers.m -verify -Werror=unused -Wsystem-headers
    RUN("%clang_cc1 -fmodules -fimplicit-module-maps -fmodules-cache-path=%t -fdisable-module-hash -isystem %S/Inputs/System/usr/include -fsyntax-only %s -verify -Werror=unused -Wsystem-headers");
    // diff ${TEST_TEMP_DIR}/Werror-Wsystem-headers.m.tmp/cstd.pcm ${TEST_TEMP_DIR}/Werror-Wsystem-headers.m.tmp-saved/cstd.pcm
    RUN("not diff %t/cstd.pcm %t-saved/cstd.pcm");
  }

  @Test
  public void test_add_remove_private_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Modules/add-remove-private.m");
    // rm -rf ${TEST_TEMP_DIR}/add-remove-private.m.tmp
    RUN("rm -rf %t");
    // rm -rf ${TEST_TEMP_DIR}/add-remove-private.m.tmp.mcp
    RUN("rm -rf %t.mcp");
    // mkdir -p ${TEST_TEMP_DIR}/add-remove-private.m.tmp
    RUN("mkdir -p %t");
    // cp -r ${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs/AddRemovePrivate.framework ${TEST_TEMP_DIR}/add-remove-private.m.tmp/AddRemovePrivate.framework
    RUN("cp -r %S/Inputs/AddRemovePrivate.framework %t/AddRemovePrivate.framework");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fmodules -fimplicit-module-maps '-fmodules-cache-path=${TEST_TEMP_DIR}/add-remove-private.m.tmp.mcp' -fdisable-module-hash -F ${TEST_TEMP_DIR}/add-remove-private.m.tmp ${LLVM_SRC}/llvm/tools/clang/test/Modules/add-remove-private.m -verify -DP
    RUN("%clang_cc1 -fmodules -fimplicit-module-maps -fmodules-cache-path=%t.mcp -fdisable-module-hash -F %t %s -verify -DP");
    // cp ${TEST_TEMP_DIR}/add-remove-private.m.tmp.mcp/AddRemovePrivate.pcm ${TEST_TEMP_DIR}/add-remove-private.m.tmp/with.pcm
    RUN("cp %t.mcp/AddRemovePrivate.pcm %t/with.pcm");
    // rm ${TEST_TEMP_DIR}/add-remove-private.m.tmp/AddRemovePrivate.framework/Modules/module.private.modulemap
    RUN("rm %t/AddRemovePrivate.framework/Modules/module.private.modulemap");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fmodules -fimplicit-module-maps '-fmodules-cache-path=${TEST_TEMP_DIR}/add-remove-private.m.tmp.mcp' -fdisable-module-hash -F ${TEST_TEMP_DIR}/add-remove-private.m.tmp ${LLVM_SRC}/llvm/tools/clang/test/Modules/add-remove-private.m -verify
    RUN("%clang_cc1 -fmodules -fimplicit-module-maps -fmodules-cache-path=%t.mcp -fdisable-module-hash -F %t %s -verify");
    // diff ${TEST_TEMP_DIR}/add-remove-private.m.tmp.mcp/AddRemovePrivate.pcm ${TEST_TEMP_DIR}/add-remove-private.m.tmp/with.pcm
    RUN("not diff %t.mcp/AddRemovePrivate.pcm %t/with.pcm");
    // cp ${TEST_TEMP_DIR}/add-remove-private.m.tmp.mcp/AddRemovePrivate.pcm ${TEST_TEMP_DIR}/add-remove-private.m.tmp/without.pcm
    RUN("cp %t.mcp/AddRemovePrivate.pcm %t/without.pcm");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fmodules -fimplicit-module-maps '-fmodules-cache-path=${TEST_TEMP_DIR}/add-remove-private.m.tmp.mcp' -fdisable-module-hash -F ${TEST_TEMP_DIR}/add-remove-private.m.tmp ${LLVM_SRC}/llvm/tools/clang/test/Modules/add-remove-private.m -DP 2>&1 | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Modules/add-remove-private.m
    RUN("not %clang_cc1 -fmodules -fimplicit-module-maps -fmodules-cache-path=%t.mcp -fdisable-module-hash -F %t %s -DP 2>&1")./*|*/
      I("FileCheck %s");
    // cp ${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs/AddRemovePrivate.framework/Modules/module.private.modulemap ${TEST_TEMP_DIR}/add-remove-private.m.tmp/AddRemovePrivate.framework/Modules/module.private.modulemap
    RUN("cp %S/Inputs/AddRemovePrivate.framework/Modules/module.private.modulemap %t/AddRemovePrivate.framework/Modules/module.private.modulemap");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fmodules -fimplicit-module-maps '-fmodules-cache-path=${TEST_TEMP_DIR}/add-remove-private.m.tmp.mcp' -fdisable-module-hash -F ${TEST_TEMP_DIR}/add-remove-private.m.tmp ${LLVM_SRC}/llvm/tools/clang/test/Modules/add-remove-private.m -verify -DP
    RUN("%clang_cc1 -fmodules -fimplicit-module-maps -fmodules-cache-path=%t.mcp -fdisable-module-hash -F %t %s -verify -DP");
    // diff ${TEST_TEMP_DIR}/add-remove-private.m.tmp.mcp/AddRemovePrivate.pcm ${TEST_TEMP_DIR}/add-remove-private.m.tmp/without.pcm
    RUN("not diff %t.mcp/AddRemovePrivate.pcm %t/without.pcm");
  }

  @Test
  public void test_anon_namespace_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Modules/anon-namespace.cpp");
    // rm -rf ${TEST_TEMP_DIR}/anon-namespace.cpp.tmp
    RUN(TestState.Failed, "rm -rf %t");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fmodules -fimplicit-module-maps '-fmodules-cache-path=${TEST_TEMP_DIR}/anon-namespace.cpp.tmp' '-I${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs/anon-namespace' -verify ${LLVM_SRC}/llvm/tools/clang/test/Modules/anon-namespace.cpp
    RUN(TestState.Failed, "%clang_cc1 -fmodules -fimplicit-module-maps -fmodules-cache-path=%t -I%S/Inputs/anon-namespace -verify %s");
  }

  @Test
  public void test_attr_unavailable_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Modules/attr-unavailable.m");
    // rm -rf ${TEST_TEMP_DIR}/attr-unavailable.m.tmp
    RUN(TestState.Failed, "rm -rf %t");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fmodules -fimplicit-module-maps '-fmodules-cache-path=${TEST_TEMP_DIR}/attr-unavailable.m.tmp' -I ${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs/attr-unavailable ${LLVM_SRC}/llvm/tools/clang/test/Modules/attr-unavailable.m -fsyntax-only -verify
    RUN(TestState.Failed, "%clang_cc1 -fmodules -fimplicit-module-maps -fmodules-cache-path=%t -I %S/Inputs/attr-unavailable %s -fsyntax-only -verify");
  }

  @Test
  public void test_auto_import_unavailable_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Modules/auto-import-unavailable.cpp");
    // rm -rf ${TEST_TEMP_DIR}/auto-import-unavailable.cpp.tmp
    RUN("rm -rf %t");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x c++ -Rmodule-build -DMISSING_HEADER -fmodules -fimplicit-module-maps '-fmodules-cache-path=${TEST_TEMP_DIR}/auto-import-unavailable.cpp.tmp' -I ${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs/auto-import-unavailable ${LLVM_SRC}/llvm/tools/clang/test/Modules/auto-import-unavailable.cpp 2>&1 | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Modules/auto-import-unavailable.cpp --check-prefix=MISSING-HEADER
    RUN("not %clang_cc1 -x c++ -Rmodule-build -DMISSING_HEADER -fmodules -fimplicit-module-maps -fmodules-cache-path=%t -I %S/Inputs/auto-import-unavailable %s 2>&1")./*|*/
      I("FileCheck %s --check-prefix=MISSING-HEADER");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x c++ -Rmodule-build -DNONREQUIRED_MISSING_HEADER -fmodules -fimplicit-module-maps '-fmodules-cache-path=${TEST_TEMP_DIR}/auto-import-unavailable.cpp.tmp' -I ${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs/auto-import-unavailable ${LLVM_SRC}/llvm/tools/clang/test/Modules/auto-import-unavailable.cpp 2>&1 | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Modules/auto-import-unavailable.cpp --check-prefix=NONREQUIRED-MISSING-HEADER
    RUN("%clang_cc1 -x c++ -Rmodule-build -DNONREQUIRED_MISSING_HEADER -fmodules -fimplicit-module-maps -fmodules-cache-path=%t -I %S/Inputs/auto-import-unavailable %s 2>&1")./*|*/
      I("FileCheck %s --check-prefix=NONREQUIRED-MISSING-HEADER");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x c++ -Rmodule-build -DMISSING_REQUIREMENT -fmodules -fimplicit-module-maps '-fmodules-cache-path=${TEST_TEMP_DIR}/auto-import-unavailable.cpp.tmp' -I ${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs/auto-import-unavailable ${LLVM_SRC}/llvm/tools/clang/test/Modules/auto-import-unavailable.cpp 2>&1 | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Modules/auto-import-unavailable.cpp --check-prefix=MISSING-REQUIREMENT
    RUN("not %clang_cc1 -x c++ -Rmodule-build -DMISSING_REQUIREMENT -fmodules -fimplicit-module-maps -fmodules-cache-path=%t -I %S/Inputs/auto-import-unavailable %s 2>&1")./*|*/
      I("FileCheck %s --check-prefix=MISSING-REQUIREMENT");
  }

  @Test
  public void test_auto_module_import_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Modules/auto-module-import.m");
    // rm -rf ${TEST_TEMP_DIR}/auto-module-import.m.tmp
    RUN(TestState.Failed, "rm -rf %t");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -Wauto-import '-fmodules-cache-path=${TEST_TEMP_DIR}/auto-module-import.m.tmp' -fmodules -fimplicit-module-maps -F ${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs ${LLVM_SRC}/llvm/tools/clang/test/Modules/auto-module-import.m -verify -DERRORS
    RUN(TestState.Failed, "%clang_cc1 -Wauto-import -fmodules-cache-path=%t -fmodules -fimplicit-module-maps -F %S/Inputs %s -verify -DERRORS");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -Wauto-import '-fmodules-cache-path=${TEST_TEMP_DIR}/auto-module-import.m.tmp' -fmodules -fimplicit-module-maps -F ${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs ${LLVM_SRC}/llvm/tools/clang/test/Modules/auto-module-import.m -verify
    RUN(TestState.Failed, "%clang_cc1 -Wauto-import -fmodules-cache-path=%t -fmodules -fimplicit-module-maps -F %S/Inputs %s -verify");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -Wauto-import '-fmodules-cache-path=${TEST_TEMP_DIR}/auto-module-import.m.tmp' -fmodules -fimplicit-module-maps -F ${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs -xobjective-c++ ${LLVM_SRC}/llvm/tools/clang/test/Modules/auto-module-import.m -verify
    RUN(TestState.Failed, "%clang_cc1 -Wauto-import -fmodules-cache-path=%t -fmodules -fimplicit-module-maps -F %S/Inputs -xobjective-c++ %s -verify");
  }

  @Test
  public void test_autolink_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Modules/autolink.m");
    // rm -rf ${TEST_TEMP_DIR}/autolink.m.tmp
    RUN(TestState.Failed, "rm -rf %t");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-pch '-fmodules-cache-path=${TEST_TEMP_DIR}/autolink.m.tmp' -fmodules -fimplicit-module-maps -o ${TEST_TEMP_DIR}/autolink.m.tmp.pch -I ${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs -x objective-c-header ${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs/autolink-sub3.pch
    RUN(TestState.Failed, "%clang_cc1 -emit-pch -fmodules-cache-path=%t -fmodules -fimplicit-module-maps -o %t.pch -I %S/Inputs -x objective-c-header %S/Inputs/autolink-sub3.pch");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm -o - '-fmodules-cache-path=${TEST_TEMP_DIR}/autolink.m.tmp' -fmodules -fimplicit-module-maps -F ${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs -I ${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs -include-pch ${TEST_TEMP_DIR}/autolink.m.tmp.pch ${LLVM_SRC}/llvm/tools/clang/test/Modules/autolink.m | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Modules/autolink.m
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm -o - -fmodules-cache-path=%t -fmodules -fimplicit-module-maps -F %S/Inputs -I %S/Inputs -include-pch %t.pch %s")./*|*/
      I("FileCheck %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm -fno-autolink -o - '-fmodules-cache-path=${TEST_TEMP_DIR}/autolink.m.tmp' -fmodules -fimplicit-module-maps -F ${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs -I ${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs -include-pch ${TEST_TEMP_DIR}/autolink.m.tmp.pch ${LLVM_SRC}/llvm/tools/clang/test/Modules/autolink.m | ${LLVM_SRC}/build/bin/FileCheck --check-prefix=CHECK-AUTOLINK-DISABLED ${LLVM_SRC}/llvm/tools/clang/test/Modules/autolink.m
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm -fno-autolink -o - -fmodules-cache-path=%t -fmodules -fimplicit-module-maps -F %S/Inputs -I %S/Inputs -include-pch %t.pch %s")./*|*/
      I("FileCheck --check-prefix=CHECK-AUTOLINK-DISABLED %s");
  }

  @Test
  public void test_autolinkTBD_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Modules/autolinkTBD.m");
    // rm -rf ${TEST_TEMP_DIR}/autolinkTBD.m.tmp
    RUN(TestState.Failed, "rm -rf %t");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm -o - '-fmodules-cache-path=${TEST_TEMP_DIR}/autolinkTBD.m.tmp' -fmodules -fimplicit-module-maps -F ${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs ${LLVM_SRC}/llvm/tools/clang/test/Modules/autolinkTBD.m | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Modules/autolinkTBD.m
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm -o - -fmodules-cache-path=%t -fmodules -fimplicit-module-maps -F %S/Inputs %s")./*|*/
      I("FileCheck %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm -fno-autolink -o - '-fmodules-cache-path=${TEST_TEMP_DIR}/autolinkTBD.m.tmp' -fmodules -fimplicit-module-maps -F ${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs ${LLVM_SRC}/llvm/tools/clang/test/Modules/autolinkTBD.m | ${LLVM_SRC}/build/bin/FileCheck --check-prefix=CHECK-AUTOLINK-DISABLED ${LLVM_SRC}/llvm/tools/clang/test/Modules/autolinkTBD.m
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm -fno-autolink -o - -fmodules-cache-path=%t -fmodules -fimplicit-module-maps -F %S/Inputs %s")./*|*/
      I("FileCheck --check-prefix=CHECK-AUTOLINK-DISABLED %s");
  }

  @Test
  public void test_available_is_better_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Modules/available-is-better.cpp");
    // rm -rf ${TEST_TEMP_DIR}/available-is-better.cpp.tmp
    RUN("rm -rf %t");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x c++ -Rmodule-build -fmodules -fimplicit-module-maps '-fmodules-cache-path=${TEST_TEMP_DIR}/available-is-better.cpp.tmp' -I ${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs/available-is-better ${LLVM_SRC}/llvm/tools/clang/test/Modules/available-is-better.cpp 2>&1 | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Modules/available-is-better.cpp
    RUN("%clang_cc1 -x c++ -Rmodule-build -fmodules -fimplicit-module-maps -fmodules-cache-path=%t -I %S/Inputs/available-is-better %s 2>&1")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_build_fail_notes_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Modules/build-fail-notes.m");
    // rm -rf ${TEST_TEMP_DIR}/build-fail-notes.m.tmp
    RUN(TestState.Failed, "rm -rf %t");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc '-fmodules-cache-path=${TEST_TEMP_DIR}/build-fail-notes.m.tmp' -fmodules -fimplicit-module-maps -F ${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs '-DgetModuleVersion="epic fail"' ${LLVM_SRC}/llvm/tools/clang/test/Modules/build-fail-notes.m 2>&1 | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Modules/build-fail-notes.m
    RUN(TestState.Failed, "not %clang_cc1 -fmodules-cache-path=%t -fmodules -fimplicit-module-maps -F %S/Inputs -DgetModuleVersion=\"epic fail\" %s 2>&1")./*|*/
      I("FileCheck %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc '-fmodules-cache-path=${TEST_TEMP_DIR}/build-fail-notes.m.tmp' -fmodules -fimplicit-module-maps -F ${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs ${LLVM_SRC}/llvm/tools/clang/test/Modules/build-fail-notes.m -fdiagnostics-show-note-include-stack 2>&1 | ${LLVM_SRC}/build/bin/FileCheck -check-prefix=CHECK-REDEF ${LLVM_SRC}/llvm/tools/clang/test/Modules/build-fail-notes.m
    RUN(TestState.Failed, "not %clang_cc1 -fmodules-cache-path=%t -fmodules -fimplicit-module-maps -F %S/Inputs %s -fdiagnostics-show-note-include-stack 2>&1")./*|*/
      I("FileCheck -check-prefix=CHECK-REDEF %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -Wincomplete-umbrella '-fmodules-cache-path=${TEST_TEMP_DIR}/build-fail-notes.m.tmp' -fmodules -fimplicit-module-maps -F ${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs '-DgetModuleVersion="epic fail"' -serialize-diagnostic-file ${TEST_TEMP_DIR}/build-fail-notes.m.tmp/tmp.diag ${LLVM_SRC}/llvm/tools/clang/test/Modules/build-fail-notes.m 2>&1
    RUN(TestState.Failed, "not %clang_cc1 -Wincomplete-umbrella -fmodules-cache-path=%t -fmodules -fimplicit-module-maps -F %S/Inputs -DgetModuleVersion=\"epic fail\" -serialize-diagnostic-file %t/tmp.diag %s 2>&1");
    // c-index-test -read-diagnostics ${TEST_TEMP_DIR}/build-fail-notes.m.tmp/tmp.diag 2>&1 | ${LLVM_SRC}/build/bin/FileCheck -check-prefix=CHECK-SDIAG ${LLVM_SRC}/llvm/tools/clang/test/Modules/build-fail-notes.m
    RUN(TestState.Failed, "c-index-test -read-diagnostics %t/tmp.diag 2>&1")./*|*/
      I("FileCheck -check-prefix=CHECK-SDIAG %s");
  }

  @Test
  public void test_builtins_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Modules/builtins.m");
    // rm -rf ${TEST_TEMP_DIR}/builtins.m.tmp
    RUN(TestState.Failed, "rm -rf %t");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc '-fmodules-cache-path=${TEST_TEMP_DIR}/builtins.m.tmp' -fmodules -fimplicit-module-maps -I ${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs ${LLVM_SRC}/llvm/tools/clang/test/Modules/builtins.m -verify
    RUN(TestState.Failed, "%clang_cc1 -fmodules-cache-path=%t -fmodules -fimplicit-module-maps -I %S/Inputs %s -verify");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc '-fmodules-cache-path=${TEST_TEMP_DIR}/builtins.m.tmp' -fmodules -fimplicit-module-maps -I ${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs -x c ${LLVM_SRC}/llvm/tools/clang/test/Modules/builtins.m -verify
    RUN(TestState.Failed, "%clang_cc1 -fmodules-cache-path=%t -fmodules -fimplicit-module-maps -I %S/Inputs -x c %s -verify");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc '-fmodules-cache-path=${TEST_TEMP_DIR}/builtins.m.tmp' -fmodules -fimplicit-module-maps -I ${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs -x objective-c++ ${LLVM_SRC}/llvm/tools/clang/test/Modules/builtins.m -verify
    RUN(TestState.Failed, "%clang_cc1 -fmodules-cache-path=%t -fmodules -fimplicit-module-maps -I %S/Inputs -x objective-c++ %s -verify");
    // rm -rf ${TEST_TEMP_DIR}/builtins.m.tmp.pch.cache
    RUN(TestState.Failed, "rm -rf %t.pch.cache");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc '-fmodules-cache-path=${TEST_TEMP_DIR}/builtins.m.tmp.pch.cache' -fmodules -fimplicit-module-maps -I ${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs -emit-pch -o ${TEST_TEMP_DIR}/builtins.m.tmp.pch -x objective-c-header ${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs/use-builtin.h
    RUN(TestState.Failed, "%clang_cc1 -fmodules-cache-path=%t.pch.cache -fmodules -fimplicit-module-maps -I %S/Inputs -emit-pch -o %t.pch -x objective-c-header %S/Inputs/use-builtin.h");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc '-fmodules-cache-path=${TEST_TEMP_DIR}/builtins.m.tmp.pch.cache' -fmodules -fimplicit-module-maps -I ${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs ${LLVM_SRC}/llvm/tools/clang/test/Modules/builtins.m -include-pch ${TEST_TEMP_DIR}/builtins.m.tmp.pch ${LLVM_SRC}/llvm/tools/clang/test/Modules/builtins.m -verify
    RUN(TestState.Failed, "%clang_cc1 -fmodules-cache-path=%t.pch.cache -fmodules -fimplicit-module-maps -I %S/Inputs %s -include-pch %t.pch %s -verify");
  }

  @Test
  public void test_compiler_builtins_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Modules/compiler_builtins.m");
    // rm -rf ${TEST_TEMP_DIR}/compiler_builtins.m.tmp
    RUN("rm -rf %t");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -fmodules -fimplicit-module-maps '-fmodules-cache-path=${TEST_TEMP_DIR}/compiler_builtins.m.tmp' ${LLVM_SRC}/llvm/tools/clang/test/Modules/compiler_builtins.m '-I${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs/System/usr/include' -verify
    RUN("%clang_cc1 -fsyntax-only -fmodules -fimplicit-module-maps -fmodules-cache-path=%t %s -I%S/Inputs/System/usr/include -verify");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -std=c99 -fmodules -fimplicit-module-maps '-fmodules-cache-path=${TEST_TEMP_DIR}/compiler_builtins.m.tmp' ${LLVM_SRC}/llvm/tools/clang/test/Modules/compiler_builtins.m '-I${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs/System/usr/include' -verify
    RUN("%clang_cc1 -fsyntax-only -std=c99 -fmodules -fimplicit-module-maps -fmodules-cache-path=%t %s -I%S/Inputs/System/usr/include -verify");
  }

  @Test
  public void test_compiler_builtins_aarch64_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Modules/compiler_builtins_aarch64.m");
    // REQUIRES: aarch64-registered-target
    if (!CHECK_REQUIRES("aarch64-registered-target")) {
      return;
    }
    // rm -rf ${TEST_TEMP_DIR}/compiler_builtins_aarch64.m.tmp
    RUN(TestState.Failed, "rm -rf %t");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -triple aarch64-unknown-unknown -target-feature +neon -fmodules -fimplicit-module-maps '-fmodules-cache-path=${TEST_TEMP_DIR}/compiler_builtins_aarch64.m.tmp' -verify ${LLVM_SRC}/llvm/tools/clang/test/Modules/compiler_builtins_aarch64.m
    RUN(TestState.Failed, "%clang_cc1 -fsyntax-only -triple aarch64-unknown-unknown -target-feature +neon -fmodules -fimplicit-module-maps -fmodules-cache-path=%t -verify %s");
  }

  @Test
  public void test_compiler_builtins_arm_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Modules/compiler_builtins_arm.m");
    // REQUIRES: arm-registered-target
    if (!CHECK_REQUIRES("arm-registered-target")) {
      return;
    }
    // rm -rf ${TEST_TEMP_DIR}/compiler_builtins_arm.m.tmp
    RUN(TestState.Failed, "rm -rf %t");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -triple thumbv7-none-linux-gnueabihf -target-abi aapcs -target-cpu cortex-a8 -mfloat-abi hard -std=c99 -fmodules -fimplicit-module-maps '-fmodules-cache-path=${TEST_TEMP_DIR}/compiler_builtins_arm.m.tmp' -D__need_wint_t ${LLVM_SRC}/llvm/tools/clang/test/Modules/compiler_builtins_arm.m -verify
    RUN(TestState.Failed, "%clang_cc1 -fsyntax-only -triple thumbv7-none-linux-gnueabihf -target-abi aapcs -target-cpu cortex-a8 -mfloat-abi hard -std=c99 -fmodules -fimplicit-module-maps -fmodules-cache-path=%t -D__need_wint_t %s -verify");
  }

  @Test
  public void test_config_macros_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Modules/config_macros.m");
    // rm -rf ${TEST_TEMP_DIR}/config_macros.m.tmp
    RUN(TestState.Failed, "rm -rf %t");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fmodules -fimplicit-module-maps -x objective-c '-fmodules-cache-path=${TEST_TEMP_DIR}/config_macros.m.tmp' -DWANT_FOO=1 -emit-module -fmodule-name=config ${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs/module.map
    RUN(TestState.Failed, "%clang_cc1 -fmodules -fimplicit-module-maps -x objective-c -fmodules-cache-path=%t -DWANT_FOO=1 -emit-module -fmodule-name=config %S/Inputs/module.map");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fmodules -fimplicit-module-maps '-fmodules-cache-path=${TEST_TEMP_DIR}/config_macros.m.tmp' -I ${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs -DWANT_FOO=1 ${LLVM_SRC}/llvm/tools/clang/test/Modules/config_macros.m -verify
    RUN(TestState.Failed, "%clang_cc1 -fmodules -fimplicit-module-maps -fmodules-cache-path=%t -I %S/Inputs -DWANT_FOO=1 %s -verify");
  }

  @Test
  public void test_conflicts_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Modules/conflicts.m");
    // rm -rf ${TEST_TEMP_DIR}/conflicts.m.tmp
    RUN("rm -rf %t");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -Wauto-import '-fmodules-cache-path=${TEST_TEMP_DIR}/conflicts.m.tmp' -fmodules -fimplicit-module-maps -I ${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs/Conflicts ${LLVM_SRC}/llvm/tools/clang/test/Modules/conflicts.m -verify
    RUN("%clang_cc1 -Wauto-import -fmodules-cache-path=%t -fmodules -fimplicit-module-maps -I %S/Inputs/Conflicts %s -verify");
  }

  @Test
  public void test_crash_vfs_path_emptydir_entries_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Modules/crash-vfs-path-emptydir-entries.m");
    // REQUIRES: crash-recovery, shell
    if (!CHECK_REQUIRES("crash-recovery, shell")) {
      return;
    }
    // rm -rf ${TEST_TEMP_DIR}/crash-vfs-path-emptydir-entries.m.tmp
    RUN(TestState.Failed, "rm -rf %t");
    // mkdir -p ${TEST_TEMP_DIR}/crash-vfs-path-emptydir-entries.m.tmp/i ${TEST_TEMP_DIR}/crash-vfs-path-emptydir-entries.m.tmp/m ${TEST_TEMP_DIR}/crash-vfs-path-emptydir-entries.m.tmp ${TEST_TEMP_DIR}/crash-vfs-path-emptydir-entries.m.tmp/sysroot
    RUN(TestState.Failed, "mkdir -p %t/i %t/m %t %t/sysroot");
    // cp -a ${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs/crash-recovery/usr ${TEST_TEMP_DIR}/crash-vfs-path-emptydir-entries.m.tmp/i/
    RUN(TestState.Failed, "cp -a %S/Inputs/crash-recovery/usr %t/i/");
    // env FORCE_CLANG_DIAGNOSTICS_CRASH= 'TMPDIR=${TEST_TEMP_DIR}/crash-vfs-path-emptydir-entries.m.tmp' 'TEMP=${TEST_TEMP_DIR}/crash-vfs-path-emptydir-entries.m.tmp' 'TMP=${TEST_TEMP_DIR}/crash-vfs-path-emptydir-entries.m.tmp' ${LLVM_SRC}/build/bin/clang -fsyntax-only ${LLVM_SRC}/llvm/tools/clang/test/Modules/crash-vfs-path-emptydir-entries.m -I ${TEST_TEMP_DIR}/crash-vfs-path-emptydir-entries.m.tmp/i -isysroot ${TEST_TEMP_DIR}/crash-vfs-path-emptydir-entries.m.tmp/sysroot/ -fmodules '-fmodules-cache-path=${TEST_TEMP_DIR}/crash-vfs-path-emptydir-entries.m.tmp/m/' 2>&1 | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Modules/crash-vfs-path-emptydir-entries.m
    RUN(TestState.Failed, "not env FORCE_CLANG_DIAGNOSTICS_CRASH= TMPDIR=%t TEMP=%t TMP=%t %clang -fsyntax-only %s -I %/t/i -isysroot %/t/sysroot/ -fmodules -fmodules-cache-path=%t/m/ 2>&1")./*|*/
      I("FileCheck %s");
    // ${LLVM_SRC}/build/bin/FileCheck --check-prefix=CHECKSRC ${LLVM_SRC}/llvm/tools/clang/test/Modules/crash-vfs-path-emptydir-entries.m -input-file ${TEST_TEMP_DIR}/crash-vfs-path-emptydir-entries.m.tmp/crash-vfs-*.m
    RUN(TestState.Failed, "FileCheck --check-prefix=CHECKSRC %s -input-file %t/crash-vfs-*.m");
    // ${LLVM_SRC}/build/bin/FileCheck --check-prefix=CHECKSH ${LLVM_SRC}/llvm/tools/clang/test/Modules/crash-vfs-path-emptydir-entries.m -input-file ${TEST_TEMP_DIR}/crash-vfs-path-emptydir-entries.m.tmp/crash-vfs-*.sh
    RUN(TestState.Failed, "FileCheck --check-prefix=CHECKSH %s -input-file %t/crash-vfs-*.sh");
    // ${LLVM_SRC}/build/bin/FileCheck --check-prefix=CHECKYAML ${LLVM_SRC}/llvm/tools/clang/test/Modules/crash-vfs-path-emptydir-entries.m -input-file ${TEST_TEMP_DIR}/crash-vfs-path-emptydir-entries.m.tmp/crash-vfs-*.cache/vfs/vfs.yaml
    RUN(TestState.Failed, "FileCheck --check-prefix=CHECKYAML %s -input-file %t/crash-vfs-*.cache/vfs/vfs.yaml");
    // find ${TEST_TEMP_DIR}/crash-vfs-path-emptydir-entries.m.tmp/crash-vfs-*.cache/vfs | grep usr/include/stdio.h | ${LLVM_SRC}/build/bin/count 1
    RUN(TestState.Failed, "find %t/crash-vfs-*.cache/vfs")./*|*/
      I("grep \"usr/include/stdio.h\"")./*|*/
      I("count 1");
  }

  @Test
  public void test_crash_vfs_path_symlink_component_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Modules/crash-vfs-path-symlink-component.m");
    // REQUIRES: crash-recovery, shell
    if (!CHECK_REQUIRES("crash-recovery, shell")) {
      return;
    }
    // rm -rf ${TEST_TEMP_DIR}/crash-vfs-path-symlink-component.m.tmp
    RUN(TestState.Failed, "rm -rf %t");
    // mkdir -p ${TEST_TEMP_DIR}/crash-vfs-path-symlink-component.m.tmp/i ${TEST_TEMP_DIR}/crash-vfs-path-symlink-component.m.tmp/m ${TEST_TEMP_DIR}/crash-vfs-path-symlink-component.m.tmp ${TEST_TEMP_DIR}/crash-vfs-path-symlink-component.m.tmp/sysroot
    RUN(TestState.Failed, "mkdir -p %t/i %t/m %t %t/sysroot");
    // cp -a ${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs/crash-recovery/usr ${TEST_TEMP_DIR}/crash-vfs-path-symlink-component.m.tmp/i/
    RUN(TestState.Failed, "cp -a %S/Inputs/crash-recovery/usr %t/i/");
    // ln -s include/tcl-private ${TEST_TEMP_DIR}/crash-vfs-path-symlink-component.m.tmp/i/usr/x
    RUN(TestState.Failed, "ln -s include/tcl-private %t/i/usr/x");
    // env FORCE_CLANG_DIAGNOSTICS_CRASH= 'TMPDIR=${TEST_TEMP_DIR}/crash-vfs-path-symlink-component.m.tmp' 'TEMP=${TEST_TEMP_DIR}/crash-vfs-path-symlink-component.m.tmp' 'TMP=${TEST_TEMP_DIR}/crash-vfs-path-symlink-component.m.tmp' ${LLVM_SRC}/build/bin/clang -fsyntax-only ${LLVM_SRC}/llvm/tools/clang/test/Modules/crash-vfs-path-symlink-component.m -I ${TEST_TEMP_DIR}/crash-vfs-path-symlink-component.m.tmp/i -isysroot ${TEST_TEMP_DIR}/crash-vfs-path-symlink-component.m.tmp/sysroot/ -fmodules '-fmodules-cache-path=${TEST_TEMP_DIR}/crash-vfs-path-symlink-component.m.tmp/m/' 2>&1 | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Modules/crash-vfs-path-symlink-component.m
    RUN(TestState.Failed, "not env FORCE_CLANG_DIAGNOSTICS_CRASH= TMPDIR=%t TEMP=%t TMP=%t %clang -fsyntax-only %s -I %/t/i -isysroot %/t/sysroot/ -fmodules -fmodules-cache-path=%t/m/ 2>&1")./*|*/
      I("FileCheck %s");
    // ${LLVM_SRC}/build/bin/FileCheck --check-prefix=CHECKSRC ${LLVM_SRC}/llvm/tools/clang/test/Modules/crash-vfs-path-symlink-component.m -input-file ${TEST_TEMP_DIR}/crash-vfs-path-symlink-component.m.tmp/crash-vfs-*.m
    RUN(TestState.Failed, "FileCheck --check-prefix=CHECKSRC %s -input-file %t/crash-vfs-*.m");
    // ${LLVM_SRC}/build/bin/FileCheck --check-prefix=CHECKSH ${LLVM_SRC}/llvm/tools/clang/test/Modules/crash-vfs-path-symlink-component.m -input-file ${TEST_TEMP_DIR}/crash-vfs-path-symlink-component.m.tmp/crash-vfs-*.sh
    RUN(TestState.Failed, "FileCheck --check-prefix=CHECKSH %s -input-file %t/crash-vfs-*.sh");
    // ${LLVM_SRC}/build/bin/FileCheck --check-prefix=CHECKYAML ${LLVM_SRC}/llvm/tools/clang/test/Modules/crash-vfs-path-symlink-component.m -input-file ${TEST_TEMP_DIR}/crash-vfs-path-symlink-component.m.tmp/crash-vfs-*.cache/vfs/vfs.yaml
    RUN(TestState.Failed, "FileCheck --check-prefix=CHECKYAML %s -input-file %t/crash-vfs-*.cache/vfs/vfs.yaml");
    // find ${TEST_TEMP_DIR}/crash-vfs-path-symlink-component.m.tmp/crash-vfs-*.cache/vfs | grep usr/include/stdio.h | ${LLVM_SRC}/build/bin/count 1
    RUN(TestState.Failed, "find %t/crash-vfs-*.cache/vfs")./*|*/
      I("grep \"usr/include/stdio.h\"")./*|*/
      I("count 1");
    // rm -rf ${TEST_TEMP_DIR}/crash-vfs-path-symlink-component.m.tmp/i
    RUN(TestState.Failed, "rm -rf %/t/i");
    // unset FORCE_CLANG_DIAGNOSTICS_CRASH
    RUN(TestState.Failed, "unset FORCE_CLANG_DIAGNOSTICS_CRASH");
    // ${LLVM_SRC}/build/bin/clang -E ${LLVM_SRC}/llvm/tools/clang/test/Modules/crash-vfs-path-symlink-component.m -I ${TEST_TEMP_DIR}/crash-vfs-path-symlink-component.m.tmp/i -isysroot ${TEST_TEMP_DIR}/crash-vfs-path-symlink-component.m.tmp/sysroot/ -ivfsoverlay ${TEST_TEMP_DIR}/crash-vfs-path-symlink-component.m.tmp/crash-vfs-*.cache/vfs/vfs.yaml -fmodules '-fmodules-cache-path=${TEST_TEMP_DIR}/crash-vfs-path-symlink-component.m.tmp/m/' 2>&1 | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Modules/crash-vfs-path-symlink-component.m --check-prefix=CHECKOVERLAY
    RUN(TestState.Failed, "%clang -E %s -I %/t/i -isysroot %/t/sysroot/ -ivfsoverlay %t/crash-vfs-*.cache/vfs/vfs.yaml -fmodules -fmodules-cache-path=%t/m/ 2>&1")./*|*/
      I("FileCheck %s --check-prefix=CHECKOVERLAY");
  }

  @Test
  public void test_crash_vfs_path_symlink_topheader_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Modules/crash-vfs-path-symlink-topheader.m");
    // REQUIRES: crash-recovery, shell
    if (!CHECK_REQUIRES("crash-recovery, shell")) {
      return;
    }
    // rm -rf ${TEST_TEMP_DIR}/crash-vfs-path-symlink-topheader.m.tmp
    RUN(TestState.Failed, "rm -rf %t");
    // mkdir -p ${TEST_TEMP_DIR}/crash-vfs-path-symlink-topheader.m.tmp/i ${TEST_TEMP_DIR}/crash-vfs-path-symlink-topheader.m.tmp/m ${TEST_TEMP_DIR}/crash-vfs-path-symlink-topheader.m.tmp ${TEST_TEMP_DIR}/crash-vfs-path-symlink-topheader.m.tmp/sysroot
    RUN(TestState.Failed, "mkdir -p %t/i %t/m %t %t/sysroot");
    // cp -a ${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs/crash-recovery/usr ${TEST_TEMP_DIR}/crash-vfs-path-symlink-topheader.m.tmp/i/
    RUN(TestState.Failed, "cp -a %S/Inputs/crash-recovery/usr %t/i/");
    // rm -f ${TEST_TEMP_DIR}/crash-vfs-path-symlink-topheader.m.tmp/i/usr/include/pthread_impl.h
    RUN(TestState.Failed, "rm -f %t/i/usr/include/pthread_impl.h");
    // ln -s pthread/pthread_impl.h ${TEST_TEMP_DIR}/crash-vfs-path-symlink-topheader.m.tmp/i/usr/include/pthread_impl.h
    RUN(TestState.Failed, "ln -s pthread/pthread_impl.h %t/i/usr/include/pthread_impl.h");
    // env FORCE_CLANG_DIAGNOSTICS_CRASH= 'TMPDIR=${TEST_TEMP_DIR}/crash-vfs-path-symlink-topheader.m.tmp' 'TEMP=${TEST_TEMP_DIR}/crash-vfs-path-symlink-topheader.m.tmp' 'TMP=${TEST_TEMP_DIR}/crash-vfs-path-symlink-topheader.m.tmp' ${LLVM_SRC}/build/bin/clang -fsyntax-only ${LLVM_SRC}/llvm/tools/clang/test/Modules/crash-vfs-path-symlink-topheader.m -I ${TEST_TEMP_DIR}/crash-vfs-path-symlink-topheader.m.tmp/i -isysroot ${TEST_TEMP_DIR}/crash-vfs-path-symlink-topheader.m.tmp/sysroot/ -fmodules '-fmodules-cache-path=${TEST_TEMP_DIR}/crash-vfs-path-symlink-topheader.m.tmp/m/' 2>&1 | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Modules/crash-vfs-path-symlink-topheader.m
    RUN(TestState.Failed, "not env FORCE_CLANG_DIAGNOSTICS_CRASH= TMPDIR=%t TEMP=%t TMP=%t %clang -fsyntax-only %s -I %/t/i -isysroot %/t/sysroot/ -fmodules -fmodules-cache-path=%t/m/ 2>&1")./*|*/
      I("FileCheck %s");
    // ${LLVM_SRC}/build/bin/FileCheck --check-prefix=CHECKSRC ${LLVM_SRC}/llvm/tools/clang/test/Modules/crash-vfs-path-symlink-topheader.m -input-file ${TEST_TEMP_DIR}/crash-vfs-path-symlink-topheader.m.tmp/crash-vfs-*.m
    RUN(TestState.Failed, "FileCheck --check-prefix=CHECKSRC %s -input-file %t/crash-vfs-*.m");
    // ${LLVM_SRC}/build/bin/FileCheck --check-prefix=CHECKSH ${LLVM_SRC}/llvm/tools/clang/test/Modules/crash-vfs-path-symlink-topheader.m -input-file ${TEST_TEMP_DIR}/crash-vfs-path-symlink-topheader.m.tmp/crash-vfs-*.sh
    RUN(TestState.Failed, "FileCheck --check-prefix=CHECKSH %s -input-file %t/crash-vfs-*.sh");
    // ${LLVM_SRC}/build/bin/FileCheck --check-prefix=CHECKYAML ${LLVM_SRC}/llvm/tools/clang/test/Modules/crash-vfs-path-symlink-topheader.m -input-file ${TEST_TEMP_DIR}/crash-vfs-path-symlink-topheader.m.tmp/crash-vfs-*.cache/vfs/vfs.yaml
    RUN(TestState.Failed, "FileCheck --check-prefix=CHECKYAML %s -input-file %t/crash-vfs-*.cache/vfs/vfs.yaml");
    // find ${TEST_TEMP_DIR}/crash-vfs-path-symlink-topheader.m.tmp/crash-vfs-*.cache/vfs | grep usr/include/pthread_impl.h | ${LLVM_SRC}/build/bin/count 1
    RUN(TestState.Failed, "find %t/crash-vfs-*.cache/vfs")./*|*/
      I("grep \"usr/include/pthread_impl.h\"")./*|*/
      I("count 1");
  }

  @Test
  public void test_crash_vfs_path_traversal_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Modules/crash-vfs-path-traversal.m");
    // REQUIRES: crash-recovery, shell, non-ms-sdk, non-ps4-sdk
    if (!CHECK_REQUIRES("crash-recovery, shell, non-ms-sdk, non-ps4-sdk")) {
      return;
    }
    // rm -rf ${TEST_TEMP_DIR}/crash-vfs-path-traversal.m.tmp
    RUN(TestState.Failed, "rm -rf %t");
    // mkdir -p ${TEST_TEMP_DIR}/crash-vfs-path-traversal.m.tmp/i ${TEST_TEMP_DIR}/crash-vfs-path-traversal.m.tmp/m ${TEST_TEMP_DIR}/crash-vfs-path-traversal.m.tmp
    RUN(TestState.Failed, "mkdir -p %t/i %t/m %t");
    // env FORCE_CLANG_DIAGNOSTICS_CRASH= 'TMPDIR=${TEST_TEMP_DIR}/crash-vfs-path-traversal.m.tmp' 'TEMP=${TEST_TEMP_DIR}/crash-vfs-path-traversal.m.tmp' 'TMP=${TEST_TEMP_DIR}/crash-vfs-path-traversal.m.tmp' ${LLVM_SRC}/build/bin/clang -fsyntax-only ${LLVM_SRC}/llvm/tools/clang/test/Modules/crash-vfs-path-traversal.m -I ${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs/crash-recovery -isysroot ${TEST_TEMP_DIR}/crash-vfs-path-traversal.m.tmp/i/ -fmodules '-fmodules-cache-path=${TEST_TEMP_DIR}/crash-vfs-path-traversal.m.tmp/m/' 2>&1 | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Modules/crash-vfs-path-traversal.m
    RUN(TestState.Failed, "not env FORCE_CLANG_DIAGNOSTICS_CRASH= TMPDIR=%t TEMP=%t TMP=%t %clang -fsyntax-only %s -I %S/Inputs/crash-recovery -isysroot %/t/i/ -fmodules -fmodules-cache-path=%t/m/ 2>&1")./*|*/
      I("FileCheck %s");
    // ${LLVM_SRC}/build/bin/FileCheck --check-prefix=CHECKSRC ${LLVM_SRC}/llvm/tools/clang/test/Modules/crash-vfs-path-traversal.m -input-file ${TEST_TEMP_DIR}/crash-vfs-path-traversal.m.tmp/crash-vfs-*.m
    RUN(TestState.Failed, "FileCheck --check-prefix=CHECKSRC %s -input-file %t/crash-vfs-*.m");
    // ${LLVM_SRC}/build/bin/FileCheck --check-prefix=CHECKSH ${LLVM_SRC}/llvm/tools/clang/test/Modules/crash-vfs-path-traversal.m -input-file ${TEST_TEMP_DIR}/crash-vfs-path-traversal.m.tmp/crash-vfs-*.sh
    RUN(TestState.Failed, "FileCheck --check-prefix=CHECKSH %s -input-file %t/crash-vfs-*.sh");
    // ${LLVM_SRC}/build/bin/FileCheck --check-prefix=CHECKYAML ${LLVM_SRC}/llvm/tools/clang/test/Modules/crash-vfs-path-traversal.m -input-file ${TEST_TEMP_DIR}/crash-vfs-path-traversal.m.tmp/crash-vfs-*.cache/vfs/vfs.yaml
    RUN(TestState.Failed, "FileCheck --check-prefix=CHECKYAML %s -input-file %t/crash-vfs-*.cache/vfs/vfs.yaml");
    // find ${TEST_TEMP_DIR}/crash-vfs-path-traversal.m.tmp/crash-vfs-*.cache/vfs | grep Inputs/crash-recovery/usr/include/stdio.h | ${LLVM_SRC}/build/bin/count 1
    RUN(TestState.Failed, "find %t/crash-vfs-*.cache/vfs")./*|*/
      I("grep \"Inputs/crash-recovery/usr/include/stdio.h\"")./*|*/
      I("count 1");
    // sed -e s@usr/include@usr/include/../include@g ${TEST_TEMP_DIR}/crash-vfs-path-traversal.m.tmp/crash-vfs-*.cache/vfs/vfs.yaml > ${TEST_TEMP_DIR}/crash-vfs-path-traversal.m.tmp/vfs.yaml
    RUN(TestState.Failed, "sed -e \"s@usr/include@usr/include/../include@g\" %t/crash-vfs-*.cache/vfs/vfs.yaml > %t/vfs.yaml");
    // cp ${TEST_TEMP_DIR}/crash-vfs-path-traversal.m.tmp/vfs.yaml ${TEST_TEMP_DIR}/crash-vfs-path-traversal.m.tmp/crash-vfs-*.cache/vfs/vfs.yaml
    RUN(TestState.Failed, "cp %t/vfs.yaml %t/crash-vfs-*.cache/vfs/vfs.yaml");
    // unset FORCE_CLANG_DIAGNOSTICS_CRASH
    RUN(TestState.Failed, "unset FORCE_CLANG_DIAGNOSTICS_CRASH");
    // ${LLVM_SRC}/build/bin/clang -E ${LLVM_SRC}/llvm/tools/clang/test/Modules/crash-vfs-path-traversal.m -I ${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs/crash-recovery -isysroot ${TEST_TEMP_DIR}/crash-vfs-path-traversal.m.tmp/i/ -ivfsoverlay ${TEST_TEMP_DIR}/crash-vfs-path-traversal.m.tmp/crash-vfs-*.cache/vfs/vfs.yaml -fmodules '-fmodules-cache-path=${TEST_TEMP_DIR}/crash-vfs-path-traversal.m.tmp/m/' 2>&1 | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Modules/crash-vfs-path-traversal.m --check-prefix=CHECKOVERLAY
    RUN(TestState.Failed, "%clang -E %s -I %S/Inputs/crash-recovery -isysroot %/t/i/ -ivfsoverlay %t/crash-vfs-*.cache/vfs/vfs.yaml -fmodules -fmodules-cache-path=%t/m/ 2>&1")./*|*/
      I("FileCheck %s --check-prefix=CHECKOVERLAY");
  }

  @Test
  public void test_crash_vfs_relative_overlay_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Modules/crash-vfs-relative-overlay.m");
    // REQUIRES: crash-recovery, shell
    if (!CHECK_REQUIRES("crash-recovery, shell")) {
      return;
    }
    // rm -rf ${TEST_TEMP_DIR}/crash-vfs-relative-overlay.m.tmp
    RUN(TestState.Failed, "rm -rf %t");
    // mkdir -p ${TEST_TEMP_DIR}/crash-vfs-relative-overlay.m.tmp/i ${TEST_TEMP_DIR}/crash-vfs-relative-overlay.m.tmp/m ${TEST_TEMP_DIR}/crash-vfs-relative-overlay.m.tmp
    RUN(TestState.Failed, "mkdir -p %t/i %t/m %t");
    // env FORCE_CLANG_DIAGNOSTICS_CRASH= 'TMPDIR=${TEST_TEMP_DIR}/crash-vfs-relative-overlay.m.tmp' 'TEMP=${TEST_TEMP_DIR}/crash-vfs-relative-overlay.m.tmp' 'TMP=${TEST_TEMP_DIR}/crash-vfs-relative-overlay.m.tmp' ${LLVM_SRC}/build/bin/clang -fsyntax-only -nostdinc ${LLVM_SRC}/llvm/tools/clang/test/Modules/crash-vfs-relative-overlay.m -I ${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs/crash-recovery/usr/include -isysroot ${TEST_TEMP_DIR}/crash-vfs-relative-overlay.m.tmp/i/ -fmodules '-fmodules-cache-path=${TEST_TEMP_DIR}/crash-vfs-relative-overlay.m.tmp/m/' 2>&1 | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Modules/crash-vfs-relative-overlay.m
    RUN(TestState.Failed, "not env FORCE_CLANG_DIAGNOSTICS_CRASH= TMPDIR=%t TEMP=%t TMP=%t %clang -fsyntax-only -nostdinc %s -I %S/Inputs/crash-recovery/usr/include -isysroot %/t/i/ -fmodules -fmodules-cache-path=%t/m/ 2>&1")./*|*/
      I("FileCheck %s");
    // ${LLVM_SRC}/build/bin/FileCheck --check-prefix=CHECKSRC ${LLVM_SRC}/llvm/tools/clang/test/Modules/crash-vfs-relative-overlay.m -input-file ${TEST_TEMP_DIR}/crash-vfs-relative-overlay.m.tmp/crash-vfs-*.m
    RUN(TestState.Failed, "FileCheck --check-prefix=CHECKSRC %s -input-file %t/crash-vfs-*.m");
    // ${LLVM_SRC}/build/bin/FileCheck --check-prefix=CHECKSH ${LLVM_SRC}/llvm/tools/clang/test/Modules/crash-vfs-relative-overlay.m -input-file ${TEST_TEMP_DIR}/crash-vfs-relative-overlay.m.tmp/crash-vfs-*.sh
    RUN(TestState.Failed, "FileCheck --check-prefix=CHECKSH %s -input-file %t/crash-vfs-*.sh");
    // ${LLVM_SRC}/build/bin/FileCheck --check-prefix=CHECKYAML ${LLVM_SRC}/llvm/tools/clang/test/Modules/crash-vfs-relative-overlay.m -input-file ${TEST_TEMP_DIR}/crash-vfs-relative-overlay.m.tmp/crash-vfs-*.cache/vfs/vfs.yaml
    RUN(TestState.Failed, "FileCheck --check-prefix=CHECKYAML %s -input-file %t/crash-vfs-*.cache/vfs/vfs.yaml");
    // find ${TEST_TEMP_DIR}/crash-vfs-relative-overlay.m.tmp/crash-vfs-*.cache/vfs | grep Inputs/crash-recovery/usr/include/stdio.h | ${LLVM_SRC}/build/bin/count 1
    RUN(TestState.Failed, "find %t/crash-vfs-*.cache/vfs")./*|*/
      I("grep \"Inputs/crash-recovery/usr/include/stdio.h\"")./*|*/
      I("count 1");
    // unset FORCE_CLANG_DIAGNOSTICS_CRASH
    RUN(TestState.Failed, "unset FORCE_CLANG_DIAGNOSTICS_CRASH");
    // ${LLVM_SRC}/build/bin/clang -E ${LLVM_SRC}/llvm/tools/clang/test/Modules/crash-vfs-relative-overlay.m -I ${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs/crash-recovery/usr/include -isysroot ${TEST_TEMP_DIR}/crash-vfs-relative-overlay.m.tmp/i/ -ivfsoverlay ${TEST_TEMP_DIR}/crash-vfs-relative-overlay.m.tmp/crash-vfs-*.cache/vfs/vfs.yaml -fmodules '-fmodules-cache-path=${TEST_TEMP_DIR}/crash-vfs-relative-overlay.m.tmp/m/' 2>&1 | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Modules/crash-vfs-relative-overlay.m --check-prefix=CHECKOVERLAY
    RUN(TestState.Failed, "%clang -E %s -I %S/Inputs/crash-recovery/usr/include -isysroot %/t/i/ -ivfsoverlay %t/crash-vfs-*.cache/vfs/vfs.yaml -fmodules -fmodules-cache-path=%t/m/ 2>&1")./*|*/
      I("FileCheck %s --check-prefix=CHECKOVERLAY");
  }

  @Test
  public void test_crash_vfs_run_reproducer_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Modules/crash-vfs-run-reproducer.m");
    // REQUIRES: crash-recovery, shell, system-darwin
    if (!CHECK_REQUIRES("crash-recovery, shell, system-darwin")) {
      return;
    }
    // rm -rf ${TEST_TEMP_DIR}/crash-vfs-run-reproducer.m.tmp
    RUN(TestState.Failed, "rm -rf %t");
    // mkdir -p ${TEST_TEMP_DIR}/crash-vfs-run-reproducer.m.tmp/i ${TEST_TEMP_DIR}/crash-vfs-run-reproducer.m.tmp/m ${TEST_TEMP_DIR}/crash-vfs-run-reproducer.m.tmp
    RUN(TestState.Failed, "mkdir -p %t/i %t/m %t");
    // env FORCE_CLANG_DIAGNOSTICS_CRASH= 'TMPDIR=${TEST_TEMP_DIR}/crash-vfs-run-reproducer.m.tmp' 'TEMP=${TEST_TEMP_DIR}/crash-vfs-run-reproducer.m.tmp' 'TMP=${TEST_TEMP_DIR}/crash-vfs-run-reproducer.m.tmp' ${LLVM_SRC}/build/bin/clang -fsyntax-only -nostdinc ${LLVM_SRC}/llvm/tools/clang/test/Modules/crash-vfs-run-reproducer.m -I ${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs/crash-recovery/usr/include -isysroot ${TEST_TEMP_DIR}/crash-vfs-run-reproducer.m.tmp/i/ -fmodules '-fmodules-cache-path=${TEST_TEMP_DIR}/crash-vfs-run-reproducer.m.tmp/m/' 2>&1 | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Modules/crash-vfs-run-reproducer.m
    RUN(TestState.Failed, "not env FORCE_CLANG_DIAGNOSTICS_CRASH= TMPDIR=%t TEMP=%t TMP=%t %clang -fsyntax-only -nostdinc %s -I %S/Inputs/crash-recovery/usr/include -isysroot %/t/i/ -fmodules -fmodules-cache-path=%t/m/ 2>&1")./*|*/
      I("FileCheck %s");
    // ${LLVM_SRC}/build/bin/FileCheck --check-prefix=CHECKSRC ${LLVM_SRC}/llvm/tools/clang/test/Modules/crash-vfs-run-reproducer.m -input-file ${TEST_TEMP_DIR}/crash-vfs-run-reproducer.m.tmp/crash-vfs-*.m
    RUN(TestState.Failed, "FileCheck --check-prefix=CHECKSRC %s -input-file %t/crash-vfs-*.m");
    // ${LLVM_SRC}/build/bin/FileCheck --check-prefix=CHECKSH ${LLVM_SRC}/llvm/tools/clang/test/Modules/crash-vfs-run-reproducer.m -input-file ${TEST_TEMP_DIR}/crash-vfs-run-reproducer.m.tmp/crash-vfs-*.sh
    RUN(TestState.Failed, "FileCheck --check-prefix=CHECKSH %s -input-file %t/crash-vfs-*.sh");
    // ${LLVM_SRC}/build/bin/FileCheck --check-prefix=CHECKYAML ${LLVM_SRC}/llvm/tools/clang/test/Modules/crash-vfs-run-reproducer.m -input-file ${TEST_TEMP_DIR}/crash-vfs-run-reproducer.m.tmp/crash-vfs-*.cache/vfs/vfs.yaml
    RUN(TestState.Failed, "FileCheck --check-prefix=CHECKYAML %s -input-file %t/crash-vfs-*.cache/vfs/vfs.yaml");
    // find ${TEST_TEMP_DIR}/crash-vfs-run-reproducer.m.tmp/crash-vfs-*.cache/vfs | grep Inputs/crash-recovery/usr/include/stdio.h | ${LLVM_SRC}/build/bin/count 1
    RUN(TestState.Failed, "find %t/crash-vfs-*.cache/vfs")./*|*/
      I("grep \"Inputs/crash-recovery/usr/include/stdio.h\"")./*|*/
      I("count 1");
    // cd ${TEST_TEMP_DIR}/crash-vfs-run-reproducer.m.tmp
    RUN(TestState.Failed, "cd %t");
    // rm -rf crash-vfs-run-reproducer-*.cache/modules/*
    RUN(TestState.Failed, "rm -rf crash-vfs-run-reproducer-*.cache/modules/*");
    // chmod 755 crash-vfs-*.sh
    RUN(TestState.Failed, "chmod 755 crash-vfs-*.sh");
    // ./crash-vfs-*.sh
    RUN(TestState.Failed, "./crash-vfs-*.sh");
  }

  @Test
  public void test_crash_vfs_umbrella_frameworks_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Modules/crash-vfs-umbrella-frameworks.m");
    // REQUIRES: crash-recovery, shell
    if (!CHECK_REQUIRES("crash-recovery, shell")) {
      return;
    }
    // rm -rf ${TEST_TEMP_DIR}/crash-vfs-umbrella-frameworks.m.tmp
    RUN(TestState.Failed, "rm -rf %t");
    // mkdir -p ${TEST_TEMP_DIR}/crash-vfs-umbrella-frameworks.m.tmp/i ${TEST_TEMP_DIR}/crash-vfs-umbrella-frameworks.m.tmp/m ${TEST_TEMP_DIR}/crash-vfs-umbrella-frameworks.m.tmp
    RUN(TestState.Failed, "mkdir -p %t/i %t/m %t");
    // cp -a ${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs/crash-recovery/Frameworks ${TEST_TEMP_DIR}/crash-vfs-umbrella-frameworks.m.tmp/i/
    RUN(TestState.Failed, "cp -a %S/Inputs/crash-recovery/Frameworks %t/i/");
    // mkdir -p ${TEST_TEMP_DIR}/crash-vfs-umbrella-frameworks.m.tmp/i/Frameworks/A.framework/Frameworks
    RUN(TestState.Failed, "mkdir -p %t/i/Frameworks/A.framework/Frameworks");
    // ln -s ../../B.framework ${TEST_TEMP_DIR}/crash-vfs-umbrella-frameworks.m.tmp/i/Frameworks/A.framework/Frameworks/B.framework
    RUN(TestState.Failed, "ln -s ../../B.framework %t/i/Frameworks/A.framework/Frameworks/B.framework");
    // env FORCE_CLANG_DIAGNOSTICS_CRASH= 'TMPDIR=${TEST_TEMP_DIR}/crash-vfs-umbrella-frameworks.m.tmp' 'TEMP=${TEST_TEMP_DIR}/crash-vfs-umbrella-frameworks.m.tmp' 'TMP=${TEST_TEMP_DIR}/crash-vfs-umbrella-frameworks.m.tmp' ${LLVM_SRC}/build/bin/clang -nostdinc -fsyntax-only ${LLVM_SRC}/llvm/tools/clang/test/Modules/crash-vfs-umbrella-frameworks.m -F ${TEST_TEMP_DIR}/crash-vfs-umbrella-frameworks.m.tmp/i/Frameworks -fmodules '-fmodules-cache-path=${TEST_TEMP_DIR}/crash-vfs-umbrella-frameworks.m.tmp/m/' 2>&1 | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Modules/crash-vfs-umbrella-frameworks.m
    RUN(TestState.Failed, "not env FORCE_CLANG_DIAGNOSTICS_CRASH= TMPDIR=%t TEMP=%t TMP=%t %clang -nostdinc -fsyntax-only %s -F %/t/i/Frameworks -fmodules -fmodules-cache-path=%t/m/ 2>&1")./*|*/
      I("FileCheck %s");
    // ${LLVM_SRC}/build/bin/FileCheck --check-prefix=CHECKYAML ${LLVM_SRC}/llvm/tools/clang/test/Modules/crash-vfs-umbrella-frameworks.m -input-file ${TEST_TEMP_DIR}/crash-vfs-umbrella-frameworks.m.tmp/crash-vfs-*.cache/vfs/vfs.yaml
    RUN(TestState.Failed, "FileCheck --check-prefix=CHECKYAML %s -input-file %t/crash-vfs-*.cache/vfs/vfs.yaml");
    // find ${TEST_TEMP_DIR}/crash-vfs-umbrella-frameworks.m.tmp/crash-vfs-*.cache/vfs | grep B.framework/Headers/B.h | ${LLVM_SRC}/build/bin/count 1
    RUN(TestState.Failed, "find %t/crash-vfs-*.cache/vfs")./*|*/
      I("grep \"B.framework/Headers/B.h\"")./*|*/
      I("count 1");
    // cd ${TEST_TEMP_DIR}/crash-vfs-umbrella-frameworks.m.tmp
    RUN(TestState.Failed, "cd %t");
    // rm -rf i
    RUN(TestState.Failed, "rm -rf i");
    // rm -rf crash-vfs-umbrella-*.cache/modules/*
    RUN(TestState.Failed, "rm -rf crash-vfs-umbrella-*.cache/modules/*");
    // chmod 755 crash-vfs-*.sh
    RUN(TestState.Failed, "chmod 755 crash-vfs-*.sh");
    // ./crash-vfs-*.sh
    RUN(TestState.Failed, "./crash-vfs-*.sh");
  }

  @Test
  public void test_crashes_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Modules/crashes.m");
    // rm -rf ${TEST_TEMP_DIR}/crashes.m.tmp.mcp
    RUN("rm -rf %t.mcp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc '-fmodules-cache-path=${TEST_TEMP_DIR}/crashes.m.tmp.mcp' -fmodules -fimplicit-module-maps -F ${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs -fobjc-arc ${LLVM_SRC}/llvm/tools/clang/test/Modules/crashes.m -verify
    RUN("%clang_cc1 -fmodules-cache-path=%t.mcp -fmodules -fimplicit-module-maps -F %S/Inputs -fobjc-arc %s -verify");
  }

  @Test
  public void test_cstd_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Modules/cstd.m");
    // rm -rf ${TEST_TEMP_DIR}/cstd.m.tmp
    RUN("rm -rf %t");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -isystem ${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs/System/usr/include -ffreestanding -fmodules -fimplicit-module-maps '-fmodules-cache-path=${TEST_TEMP_DIR}/cstd.m.tmp' -D__need_wint_t -Werror=implicit-function-declaration ${LLVM_SRC}/llvm/tools/clang/test/Modules/cstd.m
    RUN("%clang_cc1 -fsyntax-only -isystem %S/Inputs/System/usr/include -ffreestanding -fmodules -fimplicit-module-maps -fmodules-cache-path=%t -D__need_wint_t -Werror=implicit-function-declaration %s");
  }

  @Test
  public void test_cxx_decls_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Modules/cxx-decls.cpp");
    // rm -rf ${TEST_TEMP_DIR}/cxx-decls.cpp.tmp
    RUN(TestState.Failed, "rm -rf %t");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x objective-c++ -fmodules -fimplicit-module-maps '-fmodules-cache-path=${TEST_TEMP_DIR}/cxx-decls.cpp.tmp' -I ${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs ${LLVM_SRC}/llvm/tools/clang/test/Modules/cxx-decls.cpp -verify -std=c++11
    RUN(TestState.Failed, "%clang_cc1 -x objective-c++ -fmodules -fimplicit-module-maps -fmodules-cache-path=%t -I %S/Inputs %s -verify -std=c++11");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x objective-c++ -fmodules -fimplicit-module-maps '-fmodules-cache-path=${TEST_TEMP_DIR}/cxx-decls.cpp.tmp' -I ${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs ${LLVM_SRC}/llvm/tools/clang/test/Modules/cxx-decls.cpp -ast-dump -ast-dump-filter merge -std=c++11 | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Modules/cxx-decls.cpp
    RUN(TestState.Failed, "%clang_cc1 -x objective-c++ -fmodules -fimplicit-module-maps -fmodules-cache-path=%t -I %S/Inputs %s -ast-dump -ast-dump-filter merge -std=c++11")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_cxx_dtor_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Modules/cxx-dtor.cpp");
    // rm -rf ${TEST_TEMP_DIR}/cxx-dtor.cpp.tmp
    RUN(TestState.Failed, "rm -rf %t");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fmodules -fimplicit-module-maps -x c++ -std=c++11 '-fmodules-cache-path=${TEST_TEMP_DIR}/cxx-dtor.cpp.tmp' -I ${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs/cxx-dtor -emit-llvm-only ${LLVM_SRC}/llvm/tools/clang/test/Modules/cxx-dtor.cpp
    RUN(TestState.Failed, "%clang_cc1 -fmodules -fimplicit-module-maps -x c++ -std=c++11 -fmodules-cache-path=%t -I %S/Inputs/cxx-dtor -emit-llvm-only %s");
  }

  @Test
  public void test_cxx_inline_namespace_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Modules/cxx-inline-namespace.cpp");
    // rm -rf ${TEST_TEMP_DIR}/cxx-inline-namespace.cpp.tmp
    RUN("rm -rf %t");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x objective-c++ -fmodules -fimplicit-module-maps '-fmodules-cache-path=${TEST_TEMP_DIR}/cxx-inline-namespace.cpp.tmp' -I ${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs ${LLVM_SRC}/llvm/tools/clang/test/Modules/cxx-inline-namespace.cpp -verify -std=c++11
    RUN("%clang_cc1 -x objective-c++ -fmodules -fimplicit-module-maps -fmodules-cache-path=%t -I %S/Inputs %s -verify -std=c++11");
  }

  @Test
  public void test_cxx_irgen_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Modules/cxx-irgen.cpp");
    // rm -rf ${TEST_TEMP_DIR}/cxx-irgen.cpp.tmp
    RUN(TestState.Failed, "rm -rf %t");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fmodules -fimplicit-module-maps -x objective-c++ -std=c++11 '-fmodules-cache-path=${TEST_TEMP_DIR}/cxx-irgen.cpp.tmp' -I ${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs -triple i386-pc-solaris2.11 -disable-llvm-optzns -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/Modules/cxx-irgen.cpp | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Modules/cxx-irgen.cpp
    RUN(TestState.Failed, "%clang_cc1 -fmodules -fimplicit-module-maps -x objective-c++ -std=c++11 -fmodules-cache-path=%t -I %S/Inputs -triple %itanium_abi_triple -disable-llvm-optzns -emit-llvm -o - %s")./*|*/
      I("FileCheck %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fmodules -fimplicit-module-maps -x objective-c++ -std=c++11 '-fmodules-cache-path=${TEST_TEMP_DIR}/cxx-irgen.cpp.tmp' -I ${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs -triple i386-pc-solaris2.11 -disable-llvm-optzns -emit-llvm -debug-info-kind=limited -o - ${LLVM_SRC}/llvm/tools/clang/test/Modules/cxx-irgen.cpp | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Modules/cxx-irgen.cpp
    RUN(TestState.Failed, "%clang_cc1 -fmodules -fimplicit-module-maps -x objective-c++ -std=c++11 -fmodules-cache-path=%t -I %S/Inputs -triple %itanium_abi_triple -disable-llvm-optzns -emit-llvm -debug-info-kind=limited -o - %s")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_cxx_linkage_cache_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Modules/cxx-linkage-cache.cpp");
    // rm -rf ${TEST_TEMP_DIR}/cxx-linkage-cache.cpp.tmp
    RUN("rm -rf %t");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x objective-c++ -fmodules -fimplicit-module-maps '-fmodules-cache-path=${TEST_TEMP_DIR}/cxx-linkage-cache.cpp.tmp' -I ${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs ${LLVM_SRC}/llvm/tools/clang/test/Modules/cxx-linkage-cache.cpp -verify -std=c++11
    RUN("%clang_cc1 -x objective-c++ -fmodules -fimplicit-module-maps -fmodules-cache-path=%t -I %S/Inputs %s -verify -std=c++11");
  }

  @Test
  public void test_cxx_lookup_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Modules/cxx-lookup.cpp");
    // rm -rf ${TEST_TEMP_DIR}/cxx-lookup.cpp.tmp
    RUN(TestState.Failed, "rm -rf %t");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fmodules -fimplicit-module-maps '-fmodules-cache-path=${TEST_TEMP_DIR}/cxx-lookup.cpp.tmp' ${LLVM_SRC}/llvm/tools/clang/test/Modules/cxx-lookup.cpp '-I${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs/cxx-lookup' -verify
    RUN(TestState.Failed, "%clang_cc1 -fmodules -fimplicit-module-maps -fmodules-cache-path=%t %s -I%S/Inputs/cxx-lookup -verify");
  }

  @Test
  public void test_cxx_many_overloads_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Modules/cxx-many-overloads.cpp");
    // rm -rf ${TEST_TEMP_DIR}/cxx-many-overloads.cpp.tmp
    RUN("rm -rf %t");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x objective-c++ -fmodules -fimplicit-module-maps '-fmodules-cache-path=${TEST_TEMP_DIR}/cxx-many-overloads.cpp.tmp' -I ${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs ${LLVM_SRC}/llvm/tools/clang/test/Modules/cxx-many-overloads.cpp -verify
    RUN("%clang_cc1 -x objective-c++ -fmodules -fimplicit-module-maps -fmodules-cache-path=%t -I %S/Inputs %s -verify");
  }

  @Test
  public void test_cxx_templates_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Modules/cxx-templates.cpp");
    // rm -rf ${TEST_TEMP_DIR}/cxx-templates.cpp.tmp
    RUN(TestState.Failed, "rm -rf %t");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x objective-c++ -fmodules -fimplicit-module-maps -fno-modules-error-recovery '-fmodules-cache-path=${TEST_TEMP_DIR}/cxx-templates.cpp.tmp' -I ${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs ${LLVM_SRC}/llvm/tools/clang/test/Modules/cxx-templates.cpp -std=c++14 -ast-dump-lookups 2>/dev/null | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Modules/cxx-templates.cpp --check-prefix=CHECK-GLOBAL
    RUN(TestState.Failed, "not %clang_cc1 -x objective-c++ -fmodules -fimplicit-module-maps -fno-modules-error-recovery -fmodules-cache-path=%t -I %S/Inputs %s -std=c++14 -ast-dump-lookups 2>/dev/null")./*|*/
      I("FileCheck %s --check-prefix=CHECK-GLOBAL");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x objective-c++ -fmodules -fimplicit-module-maps -fno-modules-error-recovery '-fmodules-cache-path=${TEST_TEMP_DIR}/cxx-templates.cpp.tmp' -I ${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs ${LLVM_SRC}/llvm/tools/clang/test/Modules/cxx-templates.cpp -std=c++14 -ast-dump-lookups -ast-dump-filter N 2>/dev/null | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Modules/cxx-templates.cpp --check-prefix=CHECK-NAMESPACE-N
    RUN(TestState.Failed, "not %clang_cc1 -x objective-c++ -fmodules -fimplicit-module-maps -fno-modules-error-recovery -fmodules-cache-path=%t -I %S/Inputs %s -std=c++14 -ast-dump-lookups -ast-dump-filter N 2>/dev/null")./*|*/
      I("FileCheck %s --check-prefix=CHECK-NAMESPACE-N");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x objective-c++ -fmodules -fimplicit-module-maps -fno-modules-error-recovery '-fmodules-cache-path=${TEST_TEMP_DIR}/cxx-templates.cpp.tmp' -I ${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs ${LLVM_SRC}/llvm/tools/clang/test/Modules/cxx-templates.cpp -std=c++14 -ast-dump -ast-dump-filter SomeTemplate 2>/dev/null | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Modules/cxx-templates.cpp --check-prefix=CHECK-DUMP
    RUN(TestState.Failed, "not %clang_cc1 -x objective-c++ -fmodules -fimplicit-module-maps -fno-modules-error-recovery -fmodules-cache-path=%t -I %S/Inputs %s -std=c++14 -ast-dump -ast-dump-filter SomeTemplate 2>/dev/null")./*|*/
      I("FileCheck %s --check-prefix=CHECK-DUMP");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x objective-c++ -fmodules -fimplicit-module-maps -fno-modules-error-recovery '-fmodules-cache-path=${TEST_TEMP_DIR}/cxx-templates.cpp.tmp' -I ${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs ${LLVM_SRC}/llvm/tools/clang/test/Modules/cxx-templates.cpp -verify -std=c++14
    RUN(TestState.Failed, "%clang_cc1 -x objective-c++ -fmodules -fimplicit-module-maps -fno-modules-error-recovery -fmodules-cache-path=%t -I %S/Inputs %s -verify -std=c++14");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x objective-c++ -fmodules -fimplicit-module-maps -fno-modules-error-recovery '-fmodules-cache-path=${TEST_TEMP_DIR}/cxx-templates.cpp.tmp' -I ${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs ${LLVM_SRC}/llvm/tools/clang/test/Modules/cxx-templates.cpp -verify -std=c++14 -DEARLY_IMPORT
    RUN(TestState.Failed, "%clang_cc1 -x objective-c++ -fmodules -fimplicit-module-maps -fno-modules-error-recovery -fmodules-cache-path=%t -I %S/Inputs %s -verify -std=c++14 -DEARLY_IMPORT");
  }

  @Test
  public void test_cycles_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Modules/cycles.c");
    // rm -rf ${TEST_TEMP_DIR}/cycles.c.tmp
    RUN("rm -rf %t");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fmodules -fimplicit-module-maps -x objective-c '-fmodules-cache-path=${TEST_TEMP_DIR}/cycles.c.tmp' -F ${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs ${LLVM_SRC}/llvm/tools/clang/test/Modules/cycles.c 2>&1 | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Modules/cycles.c
    RUN("not %clang_cc1 -fmodules -fimplicit-module-maps -x objective-c -fmodules-cache-path=%t -F %S/Inputs %s 2>&1")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_darwin_specific_modulemap_hacks_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Modules/darwin_specific_modulemap_hacks.m");
    // rm -rf ${TEST_TEMP_DIR}/darwin_specific_modulemap_hacks.m.tmp
    RUN("rm -rf %t");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fmodules '-fmodules-cache-path=${TEST_TEMP_DIR}/darwin_specific_modulemap_hacks.m.tmp' -fimplicit-module-maps -isystem ${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs/System/usr/include -triple x86_64-apple-darwin10 ${LLVM_SRC}/llvm/tools/clang/test/Modules/darwin_specific_modulemap_hacks.m -verify -fsyntax-only
    RUN("%clang_cc1 -fmodules -fmodules-cache-path=%t -fimplicit-module-maps -isystem %S/Inputs/System/usr/include -triple x86_64-apple-darwin10 %s -verify -fsyntax-only");
  }

  @Test
  public void test_debug_info_moduleimport_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Modules/debug-info-moduleimport.m");
    // rm -rf ${TEST_TEMP_DIR}/debug-info-moduleimport.m.tmp
    RUN(TestState.Failed, "rm -rf %t");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -debug-info-kind=limited -fmodules '-DGREETING="Hello World"' -UNDEBUG -fimplicit-module-maps '-fmodules-cache-path=${TEST_TEMP_DIR}/debug-info-moduleimport.m.tmp' ${LLVM_SRC}/llvm/tools/clang/test/Modules/debug-info-moduleimport.m -I ${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs -isysroot /tmp/.. -I ${TEST_TEMP_DIR}/debug-info-moduleimport.m.tmp -emit-llvm -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Modules/debug-info-moduleimport.m --check-prefix=NOIMPORT
    RUN(TestState.Failed, "%clang_cc1 -debug-info-kind=limited -fmodules -DGREETING=\"Hello World\" -UNDEBUG -fimplicit-module-maps -fmodules-cache-path=%t %s -I %S/Inputs -isysroot /tmp/.. -I %t -emit-llvm -o -")./*|*/
      I("FileCheck %s --check-prefix=NOIMPORT");
    // rm -rf ${TEST_TEMP_DIR}/debug-info-moduleimport.m.tmp
    RUN(TestState.Failed, "rm -rf %t");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -debug-info-kind=limited -fmodules '-DGREETING="Hello World"' -UNDEBUG -fimplicit-module-maps '-fmodules-cache-path=${TEST_TEMP_DIR}/debug-info-moduleimport.m.tmp' ${LLVM_SRC}/llvm/tools/clang/test/Modules/debug-info-moduleimport.m -I ${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs -isysroot /tmp/.. -I ${TEST_TEMP_DIR}/debug-info-moduleimport.m.tmp -emit-llvm -debugger-tuning=lldb -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Modules/debug-info-moduleimport.m
    RUN(TestState.Failed, "%clang_cc1 -debug-info-kind=limited -fmodules -DGREETING=\"Hello World\" -UNDEBUG -fimplicit-module-maps -fmodules-cache-path=%t %s -I %S/Inputs -isysroot /tmp/.. -I %t -emit-llvm -debugger-tuning=lldb -o -")./*|*/
      I("FileCheck %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -debug-info-kind=limited -fmodules -fimplicit-module-maps '-fmodules-cache-path=${TEST_TEMP_DIR}/debug-info-moduleimport.m.tmp' ${LLVM_SRC}/llvm/tools/clang/test/Modules/debug-info-moduleimport.m -I ${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs -isysroot /tmp/.. -I ${TEST_TEMP_DIR}/debug-info-moduleimport.m.tmp -emit-llvm -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Modules/debug-info-moduleimport.m --check-prefix=NO-SKEL-CHECK
    RUN(TestState.Failed, "%clang_cc1 -debug-info-kind=limited -fmodules -fimplicit-module-maps -fmodules-cache-path=%t %s -I %S/Inputs -isysroot /tmp/.. -I %t -emit-llvm -o -")./*|*/
      I("FileCheck %s --check-prefix=NO-SKEL-CHECK");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -debug-info-kind=limited -fmodules -fimplicit-module-maps '-fmodules-cache-path=${TEST_TEMP_DIR}/debug-info-moduleimport.m.tmp' -fmodule-format=obj -dwarf-ext-refs ${LLVM_SRC}/llvm/tools/clang/test/Modules/debug-info-moduleimport.m -I ${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs -isysroot /tmp/.. -I ${TEST_TEMP_DIR}/debug-info-moduleimport.m.tmp -emit-llvm -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Modules/debug-info-moduleimport.m --check-prefix=SKEL-CHECK
    RUN(TestState.Failed, "%clang_cc1 -debug-info-kind=limited -fmodules -fimplicit-module-maps -fmodules-cache-path=%t -fmodule-format=obj -dwarf-ext-refs %s -I %S/Inputs -isysroot /tmp/.. -I %t -emit-llvm -o -")./*|*/
      I("FileCheck %s --check-prefix=SKEL-CHECK");
  }

  @Test
  public void test_declare_use_S() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Modules/declare-use.S");
    // rm -rf ${TEST_TEMP_DIR}/declare-use.S.tmp
    RUN("rm -rf %t");
    // ${LLVM_SRC}/build/bin/clang -fmodule-maps '-fmodules-cache-path=${TEST_TEMP_DIR}/declare-use.S.tmp' -fmodules-decluse -fmodule-name=XS -I ${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs/declare-use -S ${LLVM_SRC}/llvm/tools/clang/test/Modules/declare-use.S -Xclang -verify
    RUN("%clang -fmodule-maps -fmodules-cache-path=%t -fmodules-decluse -fmodule-name=XS -I %S/Inputs/declare-use -S %s -Xclang -verify");
  }

  @Test
  public void test_declare_use_compatible_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Modules/declare-use-compatible.cpp");
    // rm -rf ${TEST_TEMP_DIR}/declare-use-compatible.cpp.tmp
    RUN("rm -rf %t");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x c++ -fmodules -fimplicit-module-maps -fmodule-name=XB -emit-module -I ${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs/declare-use ${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs/declare-use/module.map -o ${TEST_TEMP_DIR}/declare-use-compatible.cpp.tmp/b.pcm
    RUN("%clang_cc1 -x c++ -fmodules -fimplicit-module-maps -fmodule-name=XB -emit-module -I %S/Inputs/declare-use %S/Inputs/declare-use/module.map -o %t/b.pcm");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x c++ -fmodules -fimplicit-module-maps '-fmodules-cache-path=${TEST_TEMP_DIR}/declare-use-compatible.cpp.tmp' -fmodules-decluse '-fmodule-file=${TEST_TEMP_DIR}/declare-use-compatible.cpp.tmp/b.pcm' -fmodule-name=XE -I ${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs/declare-use ${LLVM_SRC}/llvm/tools/clang/test/Modules/declare-use-compatible.cpp
    RUN("%clang_cc1 -x c++ -fmodules -fimplicit-module-maps -fmodules-cache-path=%t -fmodules-decluse -fmodule-file=%t/b.pcm -fmodule-name=XE -I %S/Inputs/declare-use %s");
    // rm -rf ${TEST_TEMP_DIR}/declare-use-compatible.cpp.tmp
    RUN("rm -rf %t");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x c++ -fmodules -fimplicit-module-maps -fmodule-name=XB -emit-module -fmodules-decluse -I ${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs/declare-use ${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs/declare-use/module.map -o ${TEST_TEMP_DIR}/declare-use-compatible.cpp.tmp/b.pcm
    RUN("%clang_cc1 -x c++ -fmodules -fimplicit-module-maps -fmodule-name=XB -emit-module -fmodules-decluse -I %S/Inputs/declare-use %S/Inputs/declare-use/module.map -o %t/b.pcm");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x c++ -fmodules -fimplicit-module-maps '-fmodules-cache-path=${TEST_TEMP_DIR}/declare-use-compatible.cpp.tmp' '-fmodule-file=${TEST_TEMP_DIR}/declare-use-compatible.cpp.tmp/b.pcm' -fmodule-name=XE -I ${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs/declare-use ${LLVM_SRC}/llvm/tools/clang/test/Modules/declare-use-compatible.cpp
    RUN("%clang_cc1 -x c++ -fmodules -fimplicit-module-maps -fmodules-cache-path=%t -fmodule-file=%t/b.pcm -fmodule-name=XE -I %S/Inputs/declare-use %s");
    // rm -rf ${TEST_TEMP_DIR}/declare-use-compatible.cpp.tmp
    RUN("rm -rf %t");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x c++ -fmodules -fimplicit-module-maps -fmodule-name=XB -emit-module -I ${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs/declare-use ${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs/declare-use/module.map -o ${TEST_TEMP_DIR}/declare-use-compatible.cpp.tmp/b.pcm
    RUN("%clang_cc1 -x c++ -fmodules -fimplicit-module-maps -fmodule-name=XB -emit-module -I %S/Inputs/declare-use %S/Inputs/declare-use/module.map -o %t/b.pcm");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x c++ -fmodules -fimplicit-module-maps '-fmodules-cache-path=${TEST_TEMP_DIR}/declare-use-compatible.cpp.tmp' -fmodules-strict-decluse '-fmodule-file=${TEST_TEMP_DIR}/declare-use-compatible.cpp.tmp/b.pcm' -fmodule-name=XE -I ${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs/declare-use ${LLVM_SRC}/llvm/tools/clang/test/Modules/declare-use-compatible.cpp
    RUN("%clang_cc1 -x c++ -fmodules -fimplicit-module-maps -fmodules-cache-path=%t -fmodules-strict-decluse -fmodule-file=%t/b.pcm -fmodule-name=XE -I %S/Inputs/declare-use %s");
    // rm -rf ${TEST_TEMP_DIR}/declare-use-compatible.cpp.tmp
    RUN("rm -rf %t");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x c++ -fmodules -fimplicit-module-maps -fmodule-name=XB -emit-module -fmodules-strict-decluse -I ${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs/declare-use ${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs/declare-use/module.map -o ${TEST_TEMP_DIR}/declare-use-compatible.cpp.tmp/b.pcm
    RUN("%clang_cc1 -x c++ -fmodules -fimplicit-module-maps -fmodule-name=XB -emit-module -fmodules-strict-decluse -I %S/Inputs/declare-use %S/Inputs/declare-use/module.map -o %t/b.pcm");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x c++ -fmodules -fimplicit-module-maps '-fmodules-cache-path=${TEST_TEMP_DIR}/declare-use-compatible.cpp.tmp' '-fmodule-file=${TEST_TEMP_DIR}/declare-use-compatible.cpp.tmp/b.pcm' -fmodule-name=XE -I ${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs/declare-use ${LLVM_SRC}/llvm/tools/clang/test/Modules/declare-use-compatible.cpp
    RUN("%clang_cc1 -x c++ -fmodules -fimplicit-module-maps -fmodules-cache-path=%t -fmodule-file=%t/b.pcm -fmodule-name=XE -I %S/Inputs/declare-use %s");
  }

  @Test
  public void test_declare_use1_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Modules/declare-use1.cpp");
    // rm -rf ${TEST_TEMP_DIR}/declare-use1.cpp.tmp
    RUN("rm -rf %t");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fimplicit-module-maps '-fmodules-cache-path=${TEST_TEMP_DIR}/declare-use1.cpp.tmp' -fmodules-decluse -fmodule-name=XG -I ${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs/declare-use ${LLVM_SRC}/llvm/tools/clang/test/Modules/declare-use1.cpp -verify
    RUN("%clang_cc1 -fimplicit-module-maps -fmodules-cache-path=%t -fmodules-decluse -fmodule-name=XG -I %S/Inputs/declare-use %s -verify");
  }

  @Test
  public void test_declare_use2_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Modules/declare-use2.cpp");
    // rm -rf ${TEST_TEMP_DIR}/declare-use2.cpp.tmp
    RUN("rm -rf %t");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fimplicit-module-maps '-fmodules-cache-path=${TEST_TEMP_DIR}/declare-use2.cpp.tmp' -fmodules-decluse -fmodule-name=XH -I ${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs/declare-use ${LLVM_SRC}/llvm/tools/clang/test/Modules/declare-use2.cpp -verify
    RUN("%clang_cc1 -fimplicit-module-maps -fmodules-cache-path=%t -fmodules-decluse -fmodule-name=XH -I %S/Inputs/declare-use %s -verify");
  }

  @Test
  public void test_declare_use3_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Modules/declare-use3.cpp");
    // rm -rf ${TEST_TEMP_DIR}/declare-use3.cpp.tmp
    RUN("rm -rf %t");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -include g.h -include e.h -include f.h -include i.h -fimplicit-module-maps '-fmodules-cache-path=${TEST_TEMP_DIR}/declare-use3.cpp.tmp' -fmodules-decluse -fmodule-name=XG -I ${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs/declare-use ${LLVM_SRC}/llvm/tools/clang/test/Modules/declare-use3.cpp -verify
    RUN("%clang_cc1 -include \"g.h\" -include \"e.h\" -include \"f.h\" -include \"i.h\" -fimplicit-module-maps -fmodules-cache-path=%t -fmodules-decluse -fmodule-name=XG -I %S/Inputs/declare-use %s -verify");
  }

  @Test
  public void test_declare_use4_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Modules/declare-use4.cpp");
    // rm -rf ${TEST_TEMP_DIR}/declare-use4.cpp.tmp
    RUN("rm -rf %t");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fimplicit-module-maps '-fmodules-cache-path=${TEST_TEMP_DIR}/declare-use4.cpp.tmp' -fmodules-decluse -fmodule-name=XG -I ${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs/declare-use ${LLVM_SRC}/llvm/tools/clang/test/Modules/declare-use4.cpp -verify
    RUN("%clang_cc1 -fimplicit-module-maps -fmodules-cache-path=%t -fmodules-decluse -fmodule-name=XG -I %S/Inputs/declare-use %s -verify");
  }

  @Test
  public void test_declare_use5_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Modules/declare-use5.cpp");
    // rm -rf ${TEST_TEMP_DIR}/declare-use5.cpp.tmp
    RUN("rm -rf %t");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fimplicit-module-maps '-fmodules-cache-path=${TEST_TEMP_DIR}/declare-use5.cpp.tmp' -fmodules-decluse -fmodule-name=XN -I ${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs/declare-use ${LLVM_SRC}/llvm/tools/clang/test/Modules/declare-use5.cpp -verify
    RUN("%clang_cc1 -fimplicit-module-maps -fmodules-cache-path=%t -fmodules-decluse -fmodule-name=XN -I %S/Inputs/declare-use %s -verify");
  }

  @Test
  public void test_decldef_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Modules/decldef.m");
    // rm -rf ${TEST_TEMP_DIR}/decldef.m.tmp
    RUN(TestState.Failed, "rm -rf %t");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fmodules -fimplicit-module-maps -fobjc-arc -I ${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs '-fmodules-cache-path=${TEST_TEMP_DIR}/decldef.m.tmp' ${LLVM_SRC}/llvm/tools/clang/test/Modules/decldef.m -verify -DUSE_EARLY
    RUN(TestState.Failed, "%clang_cc1 -fmodules -fimplicit-module-maps -fobjc-arc -I %S/Inputs -fmodules-cache-path=%t %s -verify -DUSE_EARLY");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fmodules -fimplicit-module-maps -fobjc-arc -I ${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs '-fmodules-cache-path=${TEST_TEMP_DIR}/decldef.m.tmp' ${LLVM_SRC}/llvm/tools/clang/test/Modules/decldef.m -verify
    RUN(TestState.Failed, "%clang_cc1 -fmodules -fimplicit-module-maps -fobjc-arc -I %S/Inputs -fmodules-cache-path=%t %s -verify");
  }

  @Test
  public void test_decldef_mm() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Modules/decldef.mm");
    // rm -rf ${TEST_TEMP_DIR}/decldef.mm.tmp
    RUN(TestState.Failed, "rm -rf %t");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fmodules -fimplicit-module-maps -fobjc-arc -I ${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs '-fmodules-cache-path=${TEST_TEMP_DIR}/decldef.mm.tmp' ${LLVM_SRC}/llvm/tools/clang/test/Modules/decldef.mm -verify -DUSE_1 -DUSE_2 -DUSE_3 -DUSE_4
    RUN(TestState.Failed, "%clang_cc1 -fmodules -fimplicit-module-maps -fobjc-arc -I %S/Inputs -fmodules-cache-path=%t %s -verify -DUSE_1 -DUSE_2 -DUSE_3 -DUSE_4");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fmodules -fimplicit-module-maps -fobjc-arc -I ${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs '-fmodules-cache-path=${TEST_TEMP_DIR}/decldef.mm.tmp' ${LLVM_SRC}/llvm/tools/clang/test/Modules/decldef.mm -verify -DUSE_2 -DUSE_3 -DUSE_4
    RUN(TestState.Failed, "%clang_cc1 -fmodules -fimplicit-module-maps -fobjc-arc -I %S/Inputs -fmodules-cache-path=%t %s -verify -DUSE_2 -DUSE_3 -DUSE_4");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fmodules -fimplicit-module-maps -fobjc-arc -I ${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs '-fmodules-cache-path=${TEST_TEMP_DIR}/decldef.mm.tmp' ${LLVM_SRC}/llvm/tools/clang/test/Modules/decldef.mm -verify -DUSE_3 -DUSE_4
    RUN(TestState.Failed, "%clang_cc1 -fmodules -fimplicit-module-maps -fobjc-arc -I %S/Inputs -fmodules-cache-path=%t %s -verify -DUSE_3 -DUSE_4");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fmodules -fimplicit-module-maps -fobjc-arc -I ${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs '-fmodules-cache-path=${TEST_TEMP_DIR}/decldef.mm.tmp' ${LLVM_SRC}/llvm/tools/clang/test/Modules/decldef.mm -verify -DUSE_4
    RUN(TestState.Failed, "%clang_cc1 -fmodules -fimplicit-module-maps -fobjc-arc -I %S/Inputs -fmodules-cache-path=%t %s -verify -DUSE_4");
  }

  @Test
  public void test_deferred_lookup_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Modules/deferred-lookup.cpp");
    // rm -rf ${TEST_TEMP_DIR}/deferred-lookup.cpp.tmp
    RUN(TestState.Failed, "rm -rf %t");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fmodules -fimplicit-module-maps '-fmodules-cache-path=${TEST_TEMP_DIR}/deferred-lookup.cpp.tmp' '-I${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs/deferred-lookup' -verify ${LLVM_SRC}/llvm/tools/clang/test/Modules/deferred-lookup.cpp
    RUN(TestState.Failed, "%clang_cc1 -fmodules -fimplicit-module-maps -fmodules-cache-path=%t -I%S/Inputs/deferred-lookup -verify %s");
  }

  @Test
  public void test_dependency_dump_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Modules/dependency-dump.m");
    // rm -rf ${TEST_TEMP_DIR}/dependency-dump.m.tmp
    RUN(TestState.Failed, "rm -rf %t");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fmodules -fimplicit-module-maps '-fmodules-cache-path=${TEST_TEMP_DIR}/dependency-dump.m.tmp/cache' -module-dependency-dir ${TEST_TEMP_DIR}/dependency-dump.m.tmp/vfs -F ${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs -I ${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs -verify ${LLVM_SRC}/llvm/tools/clang/test/Modules/dependency-dump.m
    RUN(TestState.Failed, "%clang_cc1 -fmodules -fimplicit-module-maps -fmodules-cache-path=%t/cache -module-dependency-dir %t/vfs -F %S/Inputs -I %S/Inputs -verify %s");
    // ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Modules/dependency-dump.m -check-prefix=VFS -input-file ${TEST_TEMP_DIR}/dependency-dump.m.tmp/vfs/vfs.yaml
    RUN(TestState.Failed, "FileCheck %s -check-prefix=VFS -input-file %t/vfs/vfs.yaml");
  }

  @Test
  public void test_dependency_dump_dependent_module_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Modules/dependency-dump-dependent-module.m");
    // REQUIRES: shell
    if (!CHECK_REQUIRES("shell")) {
      return;
    }
    // rm -rf ${TEST_TEMP_DIR}/dependency-dump-dependent-module.m.tmp
    RUN(TestState.Failed, "rm -rf %t");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fmodules -fimplicit-module-maps '-fmodules-cache-path=${TEST_TEMP_DIR}/dependency-dump-dependent-module.m.tmp/cache' -module-dependency-dir ${TEST_TEMP_DIR}/dependency-dump-dependent-module.m.tmp/vfs -F ${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs -I ${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs -verify ${LLVM_SRC}/llvm/tools/clang/test/Modules/dependency-dump-dependent-module.m
    RUN(TestState.Failed, "%clang_cc1 -fmodules -fimplicit-module-maps -fmodules-cache-path=%t/cache -module-dependency-dir %t/vfs -F %S/Inputs -I %S/Inputs -verify %s");
    // ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Modules/dependency-dump-dependent-module.m -check-prefix=VFS < ${TEST_TEMP_DIR}/dependency-dump-dependent-module.m.tmp/vfs/vfs.yaml
    RUN(TestState.Failed, "FileCheck %s -check-prefix=VFS < %t/vfs/vfs.yaml");
  }

  @Test
  public void test_dependency_gen_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Modules/dependency-gen.m");
    // rm -rf ${TEST_TEMP_DIR}/dependency-gen.m.tmp-mcp
    RUN("rm -rf %t-mcp");
    // mkdir -p ${TEST_TEMP_DIR}/dependency-gen.m.tmp-mcp
    RUN("mkdir -p %t-mcp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x objective-c -isystem ${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs/System/usr/include -dependency-file ${TEST_TEMP_DIR}/dependency-gen.m.tmp.d.1 -MT ${LLVM_SRC}/llvm/tools/clang/test/Modules/dependency-gen.m.o -I ${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs -fsyntax-only -fmodules -fimplicit-module-maps '-fmodules-cache-path=${TEST_TEMP_DIR}/dependency-gen.m.tmp-mcp' ${LLVM_SRC}/llvm/tools/clang/test/Modules/dependency-gen.m
    RUN("%clang_cc1 -x objective-c -isystem %S/Inputs/System/usr/include -dependency-file %t.d.1 -MT %s.o -I %S/Inputs -fsyntax-only -fmodules -fimplicit-module-maps -fmodules-cache-path=%t-mcp %s");
    // ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Modules/dependency-gen.m < ${TEST_TEMP_DIR}/dependency-gen.m.tmp.d.1
    RUN("FileCheck %s < %t.d.1");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x objective-c -isystem ${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs/System/usr/include -dependency-file ${TEST_TEMP_DIR}/dependency-gen.m.tmp.d.2 -MT ${LLVM_SRC}/llvm/tools/clang/test/Modules/dependency-gen.m.o -I ${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs -sys-header-deps -fsyntax-only -fmodules -fimplicit-module-maps '-fmodules-cache-path=${TEST_TEMP_DIR}/dependency-gen.m.tmp-mcp' ${LLVM_SRC}/llvm/tools/clang/test/Modules/dependency-gen.m
    RUN("%clang_cc1 -x objective-c -isystem %S/Inputs/System/usr/include -dependency-file %t.d.2 -MT %s.o -I %S/Inputs -sys-header-deps -fsyntax-only -fmodules -fimplicit-module-maps -fmodules-cache-path=%t-mcp %s");
    // ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Modules/dependency-gen.m -check-prefix=CHECK-SYS < ${TEST_TEMP_DIR}/dependency-gen.m.tmp.d.2
    RUN("FileCheck %s -check-prefix=CHECK-SYS < %t.d.2");
  }

  @Test
  public void test_dependency_gen_modulemap() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Modules/dependency-gen.modulemap");
    // cd ${LLVM_SRC}/llvm/tools/clang/test/Modules
    RUN(TestState.Failed, "cd %S");
    // rm -rf ${TEST_TEMP_DIR}/dependency-gen.modulemap.tmp
    RUN(TestState.Failed, "rm -rf %t");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -I. -x c++ -fmodule-name=test -fmodules -emit-module -fno-validate-pch -fmodules-strict-decluse ${LLVM_SRC}/llvm/tools/clang/test/Modules/dependency-gen.modulemap -dependency-file - -MT implicit.pcm -o ${TEST_TEMP_DIR}/dependency-gen.modulemap.tmp/implicit.pcm '-fmodules-cache-path=${TEST_TEMP_DIR}/dependency-gen.modulemap.tmp' -fmodule-map-file-home-is-cwd '-fmodule-map-file=${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs/dependency-gen-base.modulemap' | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Modules/dependency-gen.modulemap --check-prefix=IMPLICIT
    RUN(TestState.Failed, "%clang_cc1 -I. -x c++ -fmodule-name=test -fmodules -emit-module -fno-validate-pch -fmodules-strict-decluse %s -dependency-file - -MT implicit.pcm -o %t/implicit.pcm -fmodules-cache-path=%t -fmodule-map-file-home-is-cwd -fmodule-map-file=%S/Inputs/dependency-gen-base.modulemap")./*|*/
      I("FileCheck %s --check-prefix=IMPLICIT");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -I. -x c++ -fmodule-name=test-base -fmodules -emit-module -fno-validate-pch -fmodules-strict-decluse Inputs/dependency-gen-base.modulemap -o ${TEST_TEMP_DIR}/dependency-gen.modulemap.tmp/base.pcm -fmodule-map-file-home-is-cwd '-fmodule-map-file=${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs/dependency-gen-base.modulemap'
    RUN(TestState.Failed, "%clang_cc1 -I. -x c++ -fmodule-name=test-base -fmodules -emit-module -fno-validate-pch -fmodules-strict-decluse Inputs/dependency-gen-base.modulemap -o %t/base.pcm -fmodule-map-file-home-is-cwd -fmodule-map-file=%S/Inputs/dependency-gen-base.modulemap");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -I. -x c++ -fmodule-name=test -fmodules -emit-module -fno-validate-pch -fmodules-strict-decluse '-fmodule-file=${TEST_TEMP_DIR}/dependency-gen.modulemap.tmp/base.pcm' ${LLVM_SRC}/llvm/tools/clang/test/Modules/dependency-gen.modulemap -dependency-file - -MT explicit.pcm -o ${TEST_TEMP_DIR}/dependency-gen.modulemap.tmp/explicit.pcm '-fmodules-cache-path=${TEST_TEMP_DIR}/dependency-gen.modulemap.tmp' -fmodule-map-file-home-is-cwd | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Modules/dependency-gen.modulemap --check-prefix=EXPLICIT
    RUN(TestState.Failed, "%clang_cc1 -I. -x c++ -fmodule-name=test -fmodules -emit-module -fno-validate-pch -fmodules-strict-decluse -fmodule-file=%t/base.pcm %s -dependency-file - -MT explicit.pcm -o %t/explicit.pcm -fmodules-cache-path=%t -fmodule-map-file-home-is-cwd")./*|*/
      I("FileCheck %s --check-prefix=EXPLICIT");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -I. -x c++ -fmodules -include Inputs/dependency-gen.h -x c++ /dev/null '-fmodule-file=${TEST_TEMP_DIR}/dependency-gen.modulemap.tmp/explicit.pcm' -MT main.o -fsyntax-only -dependency-file - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Modules/dependency-gen.modulemap --check-prefix=EXPLICIT-USE
    RUN(TestState.Failed, "%clang_cc1 -I. -x c++ -fmodules -include Inputs/dependency-gen.h -x c++ /dev/null -fmodule-file=%t/explicit.pcm -MT main.o -fsyntax-only -dependency-file -")./*|*/
      I("FileCheck %s --check-prefix=EXPLICIT-USE");
  }

  @Test
  public void test_dependency_gen_inferred_map_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Modules/dependency-gen-inferred-map.m");
    // REQUIRES: x86-registered-target
    if (!CHECK_REQUIRES("x86-registered-target")) {
      return;
    }
    // rm -rf ${TEST_TEMP_DIR}/dependency-gen-inferred-map.m.tmp-mcp
    RUN("rm -rf %t-mcp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -isysroot ${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs/System -triple x86_64-apple-darwin10 -dependency-file ${TEST_TEMP_DIR}/dependency-gen-inferred-map.m.tmp.d -MT ${LLVM_SRC}/llvm/tools/clang/test/Modules/dependency-gen-inferred-map.m.o -F ${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs -fsyntax-only -fmodules -fimplicit-module-maps '-fmodules-cache-path=${TEST_TEMP_DIR}/dependency-gen-inferred-map.m.tmp-mcp' ${LLVM_SRC}/llvm/tools/clang/test/Modules/dependency-gen-inferred-map.m
    RUN("%clang_cc1 -isysroot %S/Inputs/System -triple x86_64-apple-darwin10 -dependency-file %t.d -MT %s.o -F %S/Inputs -fsyntax-only -fmodules -fimplicit-module-maps -fmodules-cache-path=%t-mcp %s");
    // ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Modules/dependency-gen-inferred-map.m < ${TEST_TEMP_DIR}/dependency-gen-inferred-map.m.tmp.d
    RUN("FileCheck %s < %t.d");
  }

  @Test
  public void test_dependency_gen_pch_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Modules/dependency-gen-pch.m");
    // REQUIRES: x86-registered-target
    if (!CHECK_REQUIRES("x86-registered-target")) {
      return;
    }
    // rm -rf ${TEST_TEMP_DIR}/dependency-gen-pch.m.tmp-mcp
    RUN("rm -rf %t-mcp");
    // mkdir -p ${TEST_TEMP_DIR}/dependency-gen-pch.m.tmp-mcp
    RUN("mkdir -p %t-mcp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -isysroot ${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs/System -triple x86_64-apple-darwin10 -module-file-deps -dependency-file ${TEST_TEMP_DIR}/dependency-gen-pch.m.tmp.d -MT ${LLVM_SRC}/llvm/tools/clang/test/Modules/dependency-gen-pch.m.o -I ${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs -fmodules -fimplicit-module-maps -fdisable-module-hash '-fmodules-cache-path=${TEST_TEMP_DIR}/dependency-gen-pch.m.tmp-mcp' -emit-pch -o ${TEST_TEMP_DIR}/dependency-gen-pch.m.tmp.pch ${LLVM_SRC}/llvm/tools/clang/test/Modules/dependency-gen-pch.m
    RUN("%clang_cc1 -isysroot %S/Inputs/System -triple x86_64-apple-darwin10 -module-file-deps -dependency-file %t.d -MT %s.o -I %S/Inputs -fmodules -fimplicit-module-maps -fdisable-module-hash -fmodules-cache-path=%t-mcp -emit-pch -o %t.pch %s");
    // ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Modules/dependency-gen-pch.m < ${TEST_TEMP_DIR}/dependency-gen-pch.m.tmp.d
    RUN("FileCheck %s < %t.d");
  }

  @Test
  public void test_diag_pragma_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Modules/diag-pragma.c");
    // rm -rf ${TEST_TEMP_DIR}/diag-pragma.c.tmp
    RUN("rm -rf %t");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fmodules -fimplicit-module-maps -x objective-c -emit-module '-fmodules-cache-path=${TEST_TEMP_DIR}/diag-pragma.c.tmp' -fmodule-name=diag_pragma ${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs/module.map
    RUN("%clang_cc1 -fmodules -fimplicit-module-maps -x objective-c -emit-module -fmodules-cache-path=%t -fmodule-name=diag_pragma %S/Inputs/module.map");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fmodules -fimplicit-module-maps -x objective-c -verify '-fmodules-cache-path=${TEST_TEMP_DIR}/diag-pragma.c.tmp' -I ${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs ${LLVM_SRC}/llvm/tools/clang/test/Modules/diag-pragma.c
    RUN("%clang_cc1 -fmodules -fimplicit-module-maps -x objective-c -verify -fmodules-cache-path=%t -I %S/Inputs %s");
  }

  @Test
  public void test_diagnostics_modulemap() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Modules/diagnostics.modulemap");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fmodules '-fmodules-cache-path=${TEST_TEMP_DIR}/diagnostics.modulemap.tmp' '-fmodule-map-file=${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs/diagnostics-aux.modulemap' '-fmodule-map-file=${LLVM_SRC}/llvm/tools/clang/test/Modules/diagnostics.modulemap' -fsyntax-only -x c++ /dev/null 2>&1 | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Modules/diagnostics.modulemap
    RUN("not %clang_cc1 -fmodules -fmodules-cache-path=%t -fmodule-map-file=%S/Inputs/diagnostics-aux.modulemap -fmodule-map-file=%s -fsyntax-only -x c++ /dev/null 2>&1")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_diamond_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Modules/diamond.c");
    // rm -rf ${TEST_TEMP_DIR}/diamond.c.tmp
    RUN("rm -rf %t");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fmodules -fimplicit-module-maps -x objective-c -emit-module '-fmodules-cache-path=${TEST_TEMP_DIR}/diamond.c.tmp' -fmodule-name=diamond_top ${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs/module.map
    RUN("%clang_cc1 -fmodules -fimplicit-module-maps -x objective-c -emit-module -fmodules-cache-path=%t -fmodule-name=diamond_top %S/Inputs/module.map");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fmodules -fimplicit-module-maps -x objective-c -emit-module '-fmodules-cache-path=${TEST_TEMP_DIR}/diamond.c.tmp' -fmodule-name=diamond_left ${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs/module.map
    RUN("%clang_cc1 -fmodules -fimplicit-module-maps -x objective-c -emit-module -fmodules-cache-path=%t -fmodule-name=diamond_left %S/Inputs/module.map");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fmodules -fimplicit-module-maps -x objective-c -emit-module '-fmodules-cache-path=${TEST_TEMP_DIR}/diamond.c.tmp' -fmodule-name=diamond_right ${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs/module.map
    RUN("%clang_cc1 -fmodules -fimplicit-module-maps -x objective-c -emit-module -fmodules-cache-path=%t -fmodule-name=diamond_right %S/Inputs/module.map");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fmodules -fimplicit-module-maps -x objective-c -emit-module '-fmodules-cache-path=${TEST_TEMP_DIR}/diamond.c.tmp' -fmodule-name=diamond_bottom ${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs/module.map
    RUN("%clang_cc1 -fmodules -fimplicit-module-maps -x objective-c -emit-module -fmodules-cache-path=%t -fmodule-name=diamond_bottom %S/Inputs/module.map");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fmodules -fimplicit-module-maps -x objective-c '-fmodules-cache-path=${TEST_TEMP_DIR}/diamond.c.tmp' -I ${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs ${LLVM_SRC}/llvm/tools/clang/test/Modules/diamond.c -verify
    RUN("%clang_cc1 -fmodules -fimplicit-module-maps -x objective-c -fmodules-cache-path=%t -I %S/Inputs %s -verify");
  }

  @Test
  public void test_diamond_pch_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Modules/diamond-pch.c");
    // rm -rf ${TEST_TEMP_DIR}/diamond-pch.c.tmp
    RUN("rm -rf %t");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fmodules -fimplicit-module-maps -x objective-c -emit-module '-fmodules-cache-path=${TEST_TEMP_DIR}/diamond-pch.c.tmp' -fmodule-name=diamond_top ${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs/module.map
    RUN("%clang_cc1 -fmodules -fimplicit-module-maps -x objective-c -emit-module -fmodules-cache-path=%t -fmodule-name=diamond_top %S/Inputs/module.map");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fmodules -fimplicit-module-maps -x objective-c -emit-module '-fmodules-cache-path=${TEST_TEMP_DIR}/diamond-pch.c.tmp' -fmodule-name=diamond_left ${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs/module.map
    RUN("%clang_cc1 -fmodules -fimplicit-module-maps -x objective-c -emit-module -fmodules-cache-path=%t -fmodule-name=diamond_left %S/Inputs/module.map");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fmodules -fimplicit-module-maps -x objective-c -emit-module '-fmodules-cache-path=${TEST_TEMP_DIR}/diamond-pch.c.tmp' -fmodule-name=diamond_right ${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs/module.map
    RUN("%clang_cc1 -fmodules -fimplicit-module-maps -x objective-c -emit-module -fmodules-cache-path=%t -fmodule-name=diamond_right %S/Inputs/module.map");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fmodules -fimplicit-module-maps -x objective-c -emit-module '-fmodules-cache-path=${TEST_TEMP_DIR}/diamond-pch.c.tmp' -fmodule-name=diamond_bottom ${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs/module.map
    RUN("%clang_cc1 -fmodules -fimplicit-module-maps -x objective-c -emit-module -fmodules-cache-path=%t -fmodule-name=diamond_bottom %S/Inputs/module.map");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fmodules -fimplicit-module-maps -x objective-c -emit-pch '-fmodules-cache-path=${TEST_TEMP_DIR}/diamond-pch.c.tmp' -I ${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs -o ${TEST_TEMP_DIR}/diamond-pch.c.tmp.pch ${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs/diamond.h
    RUN("%clang_cc1 -fmodules -fimplicit-module-maps -x objective-c -emit-pch -fmodules-cache-path=%t -I %S/Inputs -o %t.pch %S/Inputs/diamond.h");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fmodules -fimplicit-module-maps -x objective-c '-fmodules-cache-path=${TEST_TEMP_DIR}/diamond-pch.c.tmp' -include-pch ${TEST_TEMP_DIR}/diamond-pch.c.tmp.pch ${LLVM_SRC}/llvm/tools/clang/test/Modules/diamond-pch.c -I ${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs -verify
    RUN("%clang_cc1 -fmodules -fimplicit-module-maps -x objective-c -fmodules-cache-path=%t -include-pch %t.pch %s -I %S/Inputs -verify");
  }

  @Test
  public void test_direct_module_import_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Modules/direct-module-import.m");
    // rm -rf ${TEST_TEMP_DIR}/direct-module-import.m.tmp
    RUN(TestState.Failed, "rm -rf %t");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc '-fmodules-cache-path=${TEST_TEMP_DIR}/direct-module-import.m.tmp' -fmodules -fimplicit-module-maps -F ${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs -include Module/Module.h ${LLVM_SRC}/llvm/tools/clang/test/Modules/direct-module-import.m -emit-llvm -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Modules/direct-module-import.m
    RUN(TestState.Failed, "%clang_cc1 -fmodules-cache-path=%t -fmodules -fimplicit-module-maps -F %S/Inputs -include Module/Module.h %s -emit-llvm -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_driver_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Modules/driver.c");
    // ${LLVM_SRC}/build/bin/clang -fmodules -fimplicit-module-maps ${LLVM_SRC}/llvm/tools/clang/test/Modules/driver.c -### 2>&1 | ${LLVM_SRC}/build/bin/FileCheck -check-prefix CHECK-NO_MODULE_CACHE ${LLVM_SRC}/llvm/tools/clang/test/Modules/driver.c
    RUN("%clang -fmodules -fimplicit-module-maps %s -### 2>&1")./*|*/
      I("FileCheck -check-prefix CHECK-NO_MODULE_CACHE %s");
    // ${LLVM_SRC}/build/bin/clang -fmodules -fimplicit-module-maps -fmodules-cache-path=blarg ${LLVM_SRC}/llvm/tools/clang/test/Modules/driver.c -### 2>&1 | ${LLVM_SRC}/build/bin/FileCheck -check-prefix CHECK-WITH_MODULE_CACHE ${LLVM_SRC}/llvm/tools/clang/test/Modules/driver.c
    RUN("%clang -fmodules -fimplicit-module-maps -fmodules-cache-path=blarg %s -### 2>&1")./*|*/
      I("FileCheck -check-prefix CHECK-WITH_MODULE_CACHE %s");
  }

  @Test
  public void test_elaborated_type_specifier_from_hidden_module_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Modules/elaborated-type-specifier-from-hidden-module.m");
    // rm -rf ${TEST_TEMP_DIR}/elaborated-type-specifier-from-hidden-module.m.tmp
    RUN("rm -rf %t");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fmodules -fimplicit-module-maps '-fmodules-cache-path=${TEST_TEMP_DIR}/elaborated-type-specifier-from-hidden-module.m.tmp' -I ${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs ${LLVM_SRC}/llvm/tools/clang/test/Modules/elaborated-type-specifier-from-hidden-module.m -verify
    RUN("%clang_cc1 -fmodules -fimplicit-module-maps -fmodules-cache-path=%t -I %S/Inputs %s -verify");
  }

  @Test
  public void test_embed_files_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Modules/embed-files.cpp");
    // rm -rf ${TEST_TEMP_DIR}/embed-files.cpp.tmp
    RUN(TestState.Failed, "rm -rf %t");
    // mkdir ${TEST_TEMP_DIR}/embed-files.cpp.tmp
    RUN(TestState.Failed, "mkdir %t");
    // echo 'module a { header "a.h" header "x.h" } module b { header "b.h" }' > ${TEST_TEMP_DIR}/embed-files.cpp.tmp/modulemap
    RUN(TestState.Failed, "echo 'module a { header \"a.h\" header \"x.h\" } module b { header \"b.h\" }' > %t/modulemap");
    // echo 'extern int t;' > ${TEST_TEMP_DIR}/embed-files.cpp.tmp/t.h
    RUN(TestState.Failed, "echo 'extern int t;' > %t/t.h");
    // echo '#include "t.h"' > ${TEST_TEMP_DIR}/embed-files.cpp.tmp/a.h
    RUN(TestState.Failed, "echo '#include \"t.h\"' > %t/a.h");
    // echo '#include "t.h"' > ${TEST_TEMP_DIR}/embed-files.cpp.tmp/b.h
    RUN(TestState.Failed, "echo '#include \"t.h\"' > %t/b.h");
    // echo '#include "t.h"' > ${TEST_TEMP_DIR}/embed-files.cpp.tmp/x.h
    RUN(TestState.Failed, "echo '#include \"t.h\"' > %t/x.h");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fmodules '-I${TEST_TEMP_DIR}/embed-files.cpp.tmp' '-fmodules-cache-path=${TEST_TEMP_DIR}/embed-files.cpp.tmp' '-fmodule-map-file=${TEST_TEMP_DIR}/embed-files.cpp.tmp/modulemap' -fmodules-embed-all-files ${LLVM_SRC}/llvm/tools/clang/test/Modules/embed-files.cpp -verify
    RUN(TestState.Failed, "%clang_cc1 -fmodules -I%t -fmodules-cache-path=%t -fmodule-map-file=%t/modulemap -fmodules-embed-all-files %s -verify");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fmodules '-I${TEST_TEMP_DIR}/embed-files.cpp.tmp' -fmodules-embed-all-files ${TEST_TEMP_DIR}/embed-files.cpp.tmp/modulemap -fmodule-name=a -x c++ -emit-module -o ${TEST_TEMP_DIR}/embed-files.cpp.tmp/a.pcm
    RUN(TestState.Failed, "%clang_cc1 -fmodules -I%t -fmodules-embed-all-files %t/modulemap -fmodule-name=a -x c++ -emit-module -o %t/a.pcm");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fmodules '-I${TEST_TEMP_DIR}/embed-files.cpp.tmp' -fmodules-embed-all-files ${TEST_TEMP_DIR}/embed-files.cpp.tmp/modulemap -fmodule-name=b -x c++ -emit-module -o ${TEST_TEMP_DIR}/embed-files.cpp.tmp/b.pcm
    RUN(TestState.Failed, "%clang_cc1 -fmodules -I%t -fmodules-embed-all-files %t/modulemap -fmodule-name=b -x c++ -emit-module -o %t/b.pcm");
    // rm ${TEST_TEMP_DIR}/embed-files.cpp.tmp/x.h
    RUN(TestState.Failed, "rm %t/x.h");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fmodules '-I${TEST_TEMP_DIR}/embed-files.cpp.tmp' '-fmodule-map-file=${TEST_TEMP_DIR}/embed-files.cpp.tmp/modulemap' '-fmodule-file=${TEST_TEMP_DIR}/embed-files.cpp.tmp/a.pcm' '-fmodule-file=${TEST_TEMP_DIR}/embed-files.cpp.tmp/b.pcm' ${LLVM_SRC}/llvm/tools/clang/test/Modules/embed-files.cpp -verify
    RUN(TestState.Failed, "%clang_cc1 -fmodules -I%t -fmodule-map-file=%t/modulemap -fmodule-file=%t/a.pcm -fmodule-file=%t/b.pcm %s -verify");
  }

  @Test
  public void test_embed_files_compressed_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Modules/embed-files-compressed.cpp");
    // REQUIRES: zlib
    if (!CHECK_REQUIRES("zlib")) {
      return;
    }
    // REQUIRES: shell
    if (!CHECK_REQUIRES("shell")) {
      return;
    }
    // rm -rf ${TEST_TEMP_DIR}/embed-files-compressed.cpp.tmp
    RUN("rm -rf %t");
    // mkdir ${TEST_TEMP_DIR}/embed-files-compressed.cpp.tmp
    RUN("mkdir %t");
    // echo ////////////////////////////////////////////////////////////////////// > ${TEST_TEMP_DIR}/embed-files-compressed.cpp.tmp/a.h
    RUN("echo '//////////////////////////////////////////////////////////////////////' > %t/a.h");
    // cat ${TEST_TEMP_DIR}/embed-files-compressed.cpp.tmp/a.h ${TEST_TEMP_DIR}/embed-files-compressed.cpp.tmp/a.h ${TEST_TEMP_DIR}/embed-files-compressed.cpp.tmp/a.h ${TEST_TEMP_DIR}/embed-files-compressed.cpp.tmp/a.h > ${TEST_TEMP_DIR}/embed-files-compressed.cpp.tmp/b.h
    RUN("cat %t/a.h %t/a.h %t/a.h %t/a.h > %t/b.h");
    // cat ${TEST_TEMP_DIR}/embed-files-compressed.cpp.tmp/b.h ${TEST_TEMP_DIR}/embed-files-compressed.cpp.tmp/b.h ${TEST_TEMP_DIR}/embed-files-compressed.cpp.tmp/b.h ${TEST_TEMP_DIR}/embed-files-compressed.cpp.tmp/b.h > ${TEST_TEMP_DIR}/embed-files-compressed.cpp.tmp/a.h
    RUN("cat %t/b.h %t/b.h %t/b.h %t/b.h > %t/a.h");
    // cat ${TEST_TEMP_DIR}/embed-files-compressed.cpp.tmp/a.h ${TEST_TEMP_DIR}/embed-files-compressed.cpp.tmp/a.h ${TEST_TEMP_DIR}/embed-files-compressed.cpp.tmp/a.h ${TEST_TEMP_DIR}/embed-files-compressed.cpp.tmp/a.h > ${TEST_TEMP_DIR}/embed-files-compressed.cpp.tmp/b.h
    RUN("cat %t/a.h %t/a.h %t/a.h %t/a.h > %t/b.h");
    // cat ${TEST_TEMP_DIR}/embed-files-compressed.cpp.tmp/b.h ${TEST_TEMP_DIR}/embed-files-compressed.cpp.tmp/b.h ${TEST_TEMP_DIR}/embed-files-compressed.cpp.tmp/b.h ${TEST_TEMP_DIR}/embed-files-compressed.cpp.tmp/b.h > ${TEST_TEMP_DIR}/embed-files-compressed.cpp.tmp/a.h
    RUN("cat %t/b.h %t/b.h %t/b.h %t/b.h > %t/a.h");
    // cat ${TEST_TEMP_DIR}/embed-files-compressed.cpp.tmp/a.h ${TEST_TEMP_DIR}/embed-files-compressed.cpp.tmp/a.h ${TEST_TEMP_DIR}/embed-files-compressed.cpp.tmp/a.h ${TEST_TEMP_DIR}/embed-files-compressed.cpp.tmp/a.h > ${TEST_TEMP_DIR}/embed-files-compressed.cpp.tmp/b.h
    RUN("cat %t/a.h %t/a.h %t/a.h %t/a.h > %t/b.h");
    // cat ${TEST_TEMP_DIR}/embed-files-compressed.cpp.tmp/b.h ${TEST_TEMP_DIR}/embed-files-compressed.cpp.tmp/b.h ${TEST_TEMP_DIR}/embed-files-compressed.cpp.tmp/b.h ${TEST_TEMP_DIR}/embed-files-compressed.cpp.tmp/b.h > ${TEST_TEMP_DIR}/embed-files-compressed.cpp.tmp/a.h
    RUN("cat %t/b.h %t/b.h %t/b.h %t/b.h > %t/a.h");
    // cat ${TEST_TEMP_DIR}/embed-files-compressed.cpp.tmp/a.h ${TEST_TEMP_DIR}/embed-files-compressed.cpp.tmp/a.h ${TEST_TEMP_DIR}/embed-files-compressed.cpp.tmp/a.h ${TEST_TEMP_DIR}/embed-files-compressed.cpp.tmp/a.h > ${TEST_TEMP_DIR}/embed-files-compressed.cpp.tmp/b.h
    RUN("cat %t/a.h %t/a.h %t/a.h %t/a.h > %t/b.h");
    // cat ${TEST_TEMP_DIR}/embed-files-compressed.cpp.tmp/b.h ${TEST_TEMP_DIR}/embed-files-compressed.cpp.tmp/b.h ${TEST_TEMP_DIR}/embed-files-compressed.cpp.tmp/b.h ${TEST_TEMP_DIR}/embed-files-compressed.cpp.tmp/b.h > ${TEST_TEMP_DIR}/embed-files-compressed.cpp.tmp/a.h
    RUN("cat %t/b.h %t/b.h %t/b.h %t/b.h > %t/a.h");
    // echo 'module a { header "a.h" }' > ${TEST_TEMP_DIR}/embed-files-compressed.cpp.tmp/modulemap
    RUN("echo 'module a { header \"a.h\" }' > %t/modulemap");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fmodules '-I${TEST_TEMP_DIR}/embed-files-compressed.cpp.tmp' '-fmodules-cache-path=${TEST_TEMP_DIR}/embed-files-compressed.cpp.tmp' -fmodule-name=a -emit-module ${TEST_TEMP_DIR}/embed-files-compressed.cpp.tmp/modulemap -fmodules-embed-all-files -o ${TEST_TEMP_DIR}/embed-files-compressed.cpp.tmp/a.pcm
    RUN("%clang_cc1 -fmodules -I%t -fmodules-cache-path=%t -fmodule-name=a -emit-module %t/modulemap -fmodules-embed-all-files -o %t/a.pcm");
    // wc -c ${TEST_TEMP_DIR}/embed-files-compressed.cpp.tmp/a.pcm | ${LLVM_SRC}/build/bin/FileCheck --check-prefix=CHECK-SIZE ${LLVM_SRC}/llvm/tools/clang/test/Modules/embed-files-compressed.cpp
    RUN("wc -c %t/a.pcm")./*|*/
      I("FileCheck --check-prefix=CHECK-SIZE %s");
  }

  @Test
  public void test_empty_modulemap() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Modules/empty.modulemap");
    // REQUIRES: shell
    if (!CHECK_REQUIRES("shell")) {
      return;
    }
    // rm -rf ${TEST_TEMP_DIR}/empty.modulemap.tmp
    RUN("rm -rf %t");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fmodules -x c++ '-fmodules-cache-path=${TEST_TEMP_DIR}/empty.modulemap.tmp' -fno-implicit-modules -emit-module -fmodule-name=empty -o ${TEST_TEMP_DIR}/empty.modulemap.tmp/base.pcm ${LLVM_SRC}/llvm/tools/clang/test/Modules/empty.modulemap
    RUN("%clang_cc1 -fmodules -x c++ -fmodules-cache-path=%t -fno-implicit-modules -emit-module -fmodule-name=empty -o %t/base.pcm %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fmodules -x c++ '-fmodules-cache-path=${TEST_TEMP_DIR}/empty.modulemap.tmp' -fno-implicit-modules -emit-module -fmodule-name=empty -o ${TEST_TEMP_DIR}/empty.modulemap.tmp/check.pcm ${LLVM_SRC}/llvm/tools/clang/test/Modules/empty.modulemap
    RUN("%clang_cc1 -fmodules -x c++ -fmodules-cache-path=%t -fno-implicit-modules -emit-module -fmodule-name=empty -o %t/check.pcm %s");
    // diff ${TEST_TEMP_DIR}/empty.modulemap.tmp/base.pcm ${TEST_TEMP_DIR}/empty.modulemap.tmp/check.pcm
    RUN("diff %t/base.pcm %t/check.pcm");
    // wc -c ${TEST_TEMP_DIR}/empty.modulemap.tmp/base.pcm | ${LLVM_SRC}/build/bin/FileCheck --check-prefix=CHECK-SIZE ${LLVM_SRC}/llvm/tools/clang/test/Modules/empty.modulemap
    RUN("wc -c %t/base.pcm")./*|*/
      I("FileCheck --check-prefix=CHECK-SIZE %s");
  }

  @Test
  public void test_epic_fail_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Modules/epic-fail.m");
    // rm -rf ${TEST_TEMP_DIR}/epic-fail.m.tmp
    RUN("rm -rf %t");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc '-fmodules-cache-path=${TEST_TEMP_DIR}/epic-fail.m.tmp' -fmodules -fimplicit-module-maps -F ${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs '-DgetModuleVersion="epic fail"' ${LLVM_SRC}/llvm/tools/clang/test/Modules/epic-fail.m 2>&1 | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Modules/epic-fail.m
    RUN("not %clang_cc1 -fmodules-cache-path=%t -fmodules -fimplicit-module-maps -F %S/Inputs -DgetModuleVersion=\"epic fail\" %s 2>&1")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_exclude_header_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Modules/exclude-header.c");
    // rm -rf ${TEST_TEMP_DIR}/exclude-header.c.tmp
    RUN(TestState.Failed, "rm -rf %t");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x objective-c -fmodules -fimplicit-module-maps '-fmodules-cache-path=${TEST_TEMP_DIR}/exclude-header.c.tmp' -I ${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs/exclude-header ${LLVM_SRC}/llvm/tools/clang/test/Modules/exclude-header.c -verify
    RUN(TestState.Failed, "%clang_cc1 -x objective-c -fmodules -fimplicit-module-maps -fmodules-cache-path=%t -I %S/Inputs/exclude-header %s -verify");
  }

  @Test
  public void test_explicit_build_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Modules/explicit-build.cpp");
    // rm -rf ${TEST_TEMP_DIR}/explicit-build.cpp.tmp
    RUN(TestState.Failed, "rm -rf %t");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x c++ -std=c++11 -fmodules -fimplicit-module-maps '-fmodules-cache-path=${TEST_TEMP_DIR}/explicit-build.cpp.tmp' -Rmodule-build -fno-modules-error-recovery -fmodule-name=a -emit-module ${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs/explicit-build/module.modulemap -o ${TEST_TEMP_DIR}/explicit-build.cpp.tmp/a.pcm 2>&1 | ${LLVM_SRC}/build/bin/FileCheck --check-prefix=CHECK-NO-IMPLICIT-BUILD ${LLVM_SRC}/llvm/tools/clang/test/Modules/explicit-build.cpp --allow-empty
    RUN(TestState.Failed, "%clang_cc1 -x c++ -std=c++11 -fmodules -fimplicit-module-maps -fmodules-cache-path=%t -Rmodule-build -fno-modules-error-recovery -fmodule-name=a -emit-module %S/Inputs/explicit-build/module.modulemap -o %t/a.pcm 2>&1")./*|*/
      I("FileCheck --check-prefix=CHECK-NO-IMPLICIT-BUILD %s --allow-empty");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x c++ -std=c++11 -fmodules -fimplicit-module-maps '-fmodules-cache-path=${TEST_TEMP_DIR}/explicit-build.cpp.tmp' -Rmodule-build -fno-modules-error-recovery '-fmodule-file=${TEST_TEMP_DIR}/explicit-build.cpp.tmp/a.pcm' -fmodule-name=b -emit-module ${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs/explicit-build/module.modulemap -o ${TEST_TEMP_DIR}/explicit-build.cpp.tmp/b.pcm 2>&1 | ${LLVM_SRC}/build/bin/FileCheck --check-prefix=CHECK-NO-IMPLICIT-BUILD ${LLVM_SRC}/llvm/tools/clang/test/Modules/explicit-build.cpp --allow-empty
    RUN(TestState.Failed, "%clang_cc1 -x c++ -std=c++11 -fmodules -fimplicit-module-maps -fmodules-cache-path=%t -Rmodule-build -fno-modules-error-recovery -fmodule-file=%t/a.pcm -fmodule-name=b -emit-module %S/Inputs/explicit-build/module.modulemap -o %t/b.pcm 2>&1")./*|*/
      I("FileCheck --check-prefix=CHECK-NO-IMPLICIT-BUILD %s --allow-empty");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x c++ -std=c++11 -fmodules -fimplicit-module-maps '-fmodules-cache-path=${TEST_TEMP_DIR}/explicit-build.cpp.tmp' -Rmodule-build -fno-modules-error-recovery '-fmodule-file=${TEST_TEMP_DIR}/explicit-build.cpp.tmp/b.pcm' -fmodule-name=c -emit-module ${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs/explicit-build/module.modulemap -o ${TEST_TEMP_DIR}/explicit-build.cpp.tmp/c.pcm 2>&1 | ${LLVM_SRC}/build/bin/FileCheck --check-prefix=CHECK-NO-IMPLICIT-BUILD ${LLVM_SRC}/llvm/tools/clang/test/Modules/explicit-build.cpp --allow-empty
    RUN(TestState.Failed, "%clang_cc1 -x c++ -std=c++11 -fmodules -fimplicit-module-maps -fmodules-cache-path=%t -Rmodule-build -fno-modules-error-recovery -fmodule-file=%t/b.pcm -fmodule-name=c -emit-module %S/Inputs/explicit-build/module.modulemap -o %t/c.pcm 2>&1")./*|*/
      I("FileCheck --check-prefix=CHECK-NO-IMPLICIT-BUILD %s --allow-empty");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x c++ -std=c++11 -fmodules -fimplicit-module-maps '-fmodules-cache-path=${TEST_TEMP_DIR}/explicit-build.cpp.tmp' -Rmodule-build -fno-modules-error-recovery -fmodule-name=b -emit-module ${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs/explicit-build/module.modulemap -o ${TEST_TEMP_DIR}/explicit-build.cpp.tmp/b-not-a.pcm 2>&1 | ${LLVM_SRC}/build/bin/FileCheck --check-prefix=CHECK-B-NO-A ${LLVM_SRC}/llvm/tools/clang/test/Modules/explicit-build.cpp
    RUN(TestState.Failed, "%clang_cc1 -x c++ -std=c++11 -fmodules -fimplicit-module-maps -fmodules-cache-path=%t -Rmodule-build -fno-modules-error-recovery -fmodule-name=b -emit-module %S/Inputs/explicit-build/module.modulemap -o %t/b-not-a.pcm 2>&1")./*|*/
      I("FileCheck --check-prefix=CHECK-B-NO-A %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x c++ -std=c++11 -fmodules -fimplicit-module-maps '-fmodules-cache-path=${TEST_TEMP_DIR}/explicit-build.cpp.tmp' -Rmodule-build -fno-modules-error-recovery '-I${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs/explicit-build' '-fmodule-file=${TEST_TEMP_DIR}/explicit-build.cpp.tmp/a.pcm' -verify ${LLVM_SRC}/llvm/tools/clang/test/Modules/explicit-build.cpp -DHAVE_A
    RUN(TestState.Failed, "%clang_cc1 -x c++ -std=c++11 -fmodules -fimplicit-module-maps -fmodules-cache-path=%t -Rmodule-build -fno-modules-error-recovery -I%S/Inputs/explicit-build -fmodule-file=%t/a.pcm -verify %s -DHAVE_A");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x c++ -std=c++11 -fmodules -fimplicit-module-maps '-fmodules-cache-path=${TEST_TEMP_DIR}/explicit-build.cpp.tmp' -Rmodule-build -fno-modules-error-recovery '-I${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs/explicit-build' '-fmodule-map-file=${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs/explicit-build/module.modulemap' '-fmodule-file=${TEST_TEMP_DIR}/explicit-build.cpp.tmp/a.pcm' -verify ${LLVM_SRC}/llvm/tools/clang/test/Modules/explicit-build.cpp -DHAVE_A
    RUN(TestState.Failed, "%clang_cc1 -x c++ -std=c++11 -fmodules -fimplicit-module-maps -fmodules-cache-path=%t -Rmodule-build -fno-modules-error-recovery -I%S/Inputs/explicit-build -fmodule-map-file=%S/Inputs/explicit-build/module.modulemap -fmodule-file=%t/a.pcm -verify %s -DHAVE_A");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x c++ -std=c++11 -fmodules -fimplicit-module-maps '-fmodules-cache-path=${TEST_TEMP_DIR}/explicit-build.cpp.tmp' -Rmodule-build -fno-modules-error-recovery '-I${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs/explicit-build' '-fmodule-file=${TEST_TEMP_DIR}/explicit-build.cpp.tmp/b.pcm' -verify ${LLVM_SRC}/llvm/tools/clang/test/Modules/explicit-build.cpp -DHAVE_A -DHAVE_B
    RUN(TestState.Failed, "%clang_cc1 -x c++ -std=c++11 -fmodules -fimplicit-module-maps -fmodules-cache-path=%t -Rmodule-build -fno-modules-error-recovery -I%S/Inputs/explicit-build -fmodule-file=%t/b.pcm -verify %s -DHAVE_A -DHAVE_B");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x c++ -std=c++11 -fmodules -fimplicit-module-maps '-fmodules-cache-path=${TEST_TEMP_DIR}/explicit-build.cpp.tmp' -Rmodule-build -fno-modules-error-recovery '-I${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs/explicit-build' '-fmodule-file=${TEST_TEMP_DIR}/explicit-build.cpp.tmp/a.pcm' '-fmodule-file=${TEST_TEMP_DIR}/explicit-build.cpp.tmp/b.pcm' -verify ${LLVM_SRC}/llvm/tools/clang/test/Modules/explicit-build.cpp -DHAVE_A -DHAVE_B
    RUN(TestState.Failed, "%clang_cc1 -x c++ -std=c++11 -fmodules -fimplicit-module-maps -fmodules-cache-path=%t -Rmodule-build -fno-modules-error-recovery -I%S/Inputs/explicit-build -fmodule-file=%t/a.pcm -fmodule-file=%t/b.pcm -verify %s -DHAVE_A -DHAVE_B");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x c++ -std=c++11 -fmodules -fimplicit-module-maps '-fmodules-cache-path=${TEST_TEMP_DIR}/explicit-build.cpp.tmp' -Rmodule-build -fno-modules-error-recovery '-I${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs/explicit-build' '-fmodule-file=${TEST_TEMP_DIR}/explicit-build.cpp.tmp/a.pcm' '-fmodule-file=${TEST_TEMP_DIR}/explicit-build.cpp.tmp/b.pcm' '-fmodule-file=${TEST_TEMP_DIR}/explicit-build.cpp.tmp/c.pcm' -verify ${LLVM_SRC}/llvm/tools/clang/test/Modules/explicit-build.cpp -DHAVE_A -DHAVE_B -DHAVE_C
    RUN(TestState.Failed, "%clang_cc1 -x c++ -std=c++11 -fmodules -fimplicit-module-maps -fmodules-cache-path=%t -Rmodule-build -fno-modules-error-recovery -I%S/Inputs/explicit-build -fmodule-file=%t/a.pcm -fmodule-file=%t/b.pcm -fmodule-file=%t/c.pcm -verify %s -DHAVE_A -DHAVE_B -DHAVE_C");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x c++ -std=c++11 -fmodules -fimplicit-module-maps '-fmodules-cache-path=${TEST_TEMP_DIR}/explicit-build.cpp.tmp' -Rmodule-build -fno-modules-error-recovery '-I${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs/explicit-build' '-fmodule-file=${TEST_TEMP_DIR}/explicit-build.cpp.tmp/a.pcm' '-fmodule-file=${TEST_TEMP_DIR}/explicit-build.cpp.tmp/c.pcm' -verify ${LLVM_SRC}/llvm/tools/clang/test/Modules/explicit-build.cpp -DHAVE_A -DHAVE_B -DHAVE_C
    RUN(TestState.Failed, "%clang_cc1 -x c++ -std=c++11 -fmodules -fimplicit-module-maps -fmodules-cache-path=%t -Rmodule-build -fno-modules-error-recovery -I%S/Inputs/explicit-build -fmodule-file=%t/a.pcm -fmodule-file=%t/c.pcm -verify %s -DHAVE_A -DHAVE_B -DHAVE_C");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x c++ -std=c++11 -fmodules -fimplicit-module-maps -fno-implicit-modules -Rmodule-build -fno-modules-error-recovery '-fmodule-file=${TEST_TEMP_DIR}/explicit-build.cpp.tmp/b.pcm' -fmodule-name=d -emit-module ${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs/explicit-build/module.modulemap -o ${TEST_TEMP_DIR}/explicit-build.cpp.tmp/d.pcm 2>&1 | ${LLVM_SRC}/build/bin/FileCheck --check-prefix=CHECK-NO-IMPLICIT-BUILD ${LLVM_SRC}/llvm/tools/clang/test/Modules/explicit-build.cpp --allow-empty
    RUN(TestState.Failed, "%clang_cc1 -x c++ -std=c++11 -fmodules -fimplicit-module-maps -fno-implicit-modules -Rmodule-build -fno-modules-error-recovery -fmodule-file=%t/b.pcm -fmodule-name=d -emit-module %S/Inputs/explicit-build/module.modulemap -o %t/d.pcm 2>&1")./*|*/
      I("FileCheck --check-prefix=CHECK-NO-IMPLICIT-BUILD %s --allow-empty");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x c++ -std=c++11 -fmodules -fimplicit-module-maps -fno-implicit-modules -Rmodule-build -fno-modules-error-recovery '-I${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs/explicit-build' '-fmodule-file=${TEST_TEMP_DIR}/explicit-build.cpp.tmp/d.pcm' -verify ${LLVM_SRC}/llvm/tools/clang/test/Modules/explicit-build.cpp -DHAVE_A -DHAVE_B
    RUN(TestState.Failed, "%clang_cc1 -x c++ -std=c++11 -fmodules -fimplicit-module-maps -fno-implicit-modules -Rmodule-build -fno-modules-error-recovery -I%S/Inputs/explicit-build -fmodule-file=%t/d.pcm -verify %s -DHAVE_A -DHAVE_B");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x c++ -std=c++11 -fmodules -fimplicit-module-maps '-fmodules-cache-path=${TEST_TEMP_DIR}/explicit-build.cpp.tmp' -Rmodule-build -fno-modules-error-recovery '-I${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs/explicit-build' '-fmodule-file=${TEST_TEMP_DIR}/explicit-build.cpp.tmp/b-not-a.pcm' -verify ${LLVM_SRC}/llvm/tools/clang/test/Modules/explicit-build.cpp -DHAVE_A -DHAVE_B
    RUN(TestState.Failed, "%clang_cc1 -x c++ -std=c++11 -fmodules -fimplicit-module-maps -fmodules-cache-path=%t -Rmodule-build -fno-modules-error-recovery -I%S/Inputs/explicit-build -fmodule-file=%t/b-not-a.pcm -verify %s -DHAVE_A -DHAVE_B");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x c++ -std=c++11 -fmodules -fimplicit-module-maps '-fmodules-cache-path=${TEST_TEMP_DIR}/explicit-build.cpp.tmp' -Rmodule-build -fno-modules-error-recovery '-fmodule-file=${TEST_TEMP_DIR}/explicit-build.cpp.tmp/a.pcm' '-fmodule-file=${TEST_TEMP_DIR}/explicit-build.cpp.tmp/b-not-a.pcm' ${LLVM_SRC}/llvm/tools/clang/test/Modules/explicit-build.cpp 2>&1 | ${LLVM_SRC}/build/bin/FileCheck --check-prefix=CHECK-MULTIPLE-AS ${LLVM_SRC}/llvm/tools/clang/test/Modules/explicit-build.cpp
    RUN(TestState.Failed, "not %clang_cc1 -x c++ -std=c++11 -fmodules -fimplicit-module-maps -fmodules-cache-path=%t -Rmodule-build -fno-modules-error-recovery -fmodule-file=%t/a.pcm -fmodule-file=%t/b-not-a.pcm %s 2>&1")./*|*/
      I("FileCheck --check-prefix=CHECK-MULTIPLE-AS %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x c++ -std=c++11 -fmodules -fimplicit-module-maps '-fmodules-cache-path=${TEST_TEMP_DIR}/explicit-build.cpp.tmp' -Rmodule-build -fno-modules-error-recovery '-fmodule-file=${TEST_TEMP_DIR}/explicit-build.cpp.tmp/a.pcm' '-fmodule-file=${TEST_TEMP_DIR}/explicit-build.cpp.tmp/b-not-a.pcm' '-fmodule-map-file=${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs/explicit-build/module.modulemap' ${LLVM_SRC}/llvm/tools/clang/test/Modules/explicit-build.cpp 2>&1 | ${LLVM_SRC}/build/bin/FileCheck --check-prefix=CHECK-MULTIPLE-AS ${LLVM_SRC}/llvm/tools/clang/test/Modules/explicit-build.cpp
    RUN(TestState.Failed, "not %clang_cc1 -x c++ -std=c++11 -fmodules -fimplicit-module-maps -fmodules-cache-path=%t -Rmodule-build -fno-modules-error-recovery -fmodule-file=%t/a.pcm -fmodule-file=%t/b-not-a.pcm -fmodule-map-file=%S/Inputs/explicit-build/module.modulemap %s 2>&1")./*|*/
      I("FileCheck --check-prefix=CHECK-MULTIPLE-AS %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x c++ -std=c++11 -fmodules -fimplicit-module-maps '-fmodules-cache-path=${TEST_TEMP_DIR}/explicit-build.cpp.tmp' -Rmodule-build -fno-modules-error-recovery -fmodule-name=a -emit-module ${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs/explicit-build/module.modulemap -o ${TEST_TEMP_DIR}/explicit-build.cpp.tmp/a-alt.pcm 2>&1 | ${LLVM_SRC}/build/bin/FileCheck --check-prefix=CHECK-NO-IMPLICIT-BUILD ${LLVM_SRC}/llvm/tools/clang/test/Modules/explicit-build.cpp --allow-empty
    RUN(TestState.Failed, "%clang_cc1 -x c++ -std=c++11 -fmodules -fimplicit-module-maps -fmodules-cache-path=%t -Rmodule-build -fno-modules-error-recovery -fmodule-name=a -emit-module %S/Inputs/explicit-build/module.modulemap -o %t/a-alt.pcm 2>&1")./*|*/
      I("FileCheck --check-prefix=CHECK-NO-IMPLICIT-BUILD %s --allow-empty");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x c++ -std=c++11 -fmodules -fimplicit-module-maps '-fmodules-cache-path=${TEST_TEMP_DIR}/explicit-build.cpp.tmp' -Rmodule-build -fno-modules-error-recovery '-fmodule-file=${TEST_TEMP_DIR}/explicit-build.cpp.tmp/a.pcm' '-fmodule-file=${TEST_TEMP_DIR}/explicit-build.cpp.tmp/a-alt.pcm' '-fmodule-map-file=${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs/explicit-build/module.modulemap' ${LLVM_SRC}/llvm/tools/clang/test/Modules/explicit-build.cpp 2>&1 | ${LLVM_SRC}/build/bin/FileCheck --check-prefix=CHECK-MULTIPLE-AS ${LLVM_SRC}/llvm/tools/clang/test/Modules/explicit-build.cpp
    RUN(TestState.Failed, "not %clang_cc1 -x c++ -std=c++11 -fmodules -fimplicit-module-maps -fmodules-cache-path=%t -Rmodule-build -fno-modules-error-recovery -fmodule-file=%t/a.pcm -fmodule-file=%t/a-alt.pcm -fmodule-map-file=%S/Inputs/explicit-build/module.modulemap %s 2>&1")./*|*/
      I("FileCheck --check-prefix=CHECK-MULTIPLE-AS %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x c++ -std=c++11 -fmodules -fimplicit-module-maps '-fmodules-cache-path=${TEST_TEMP_DIR}/explicit-build.cpp.tmp' -Rmodule-build -fno-modules-error-recovery '-fmodule-file=${TEST_TEMP_DIR}/explicit-build.cpp.tmp/a-alt.pcm' '-fmodule-file=${TEST_TEMP_DIR}/explicit-build.cpp.tmp/a.pcm' '-fmodule-map-file=${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs/explicit-build/module.modulemap' ${LLVM_SRC}/llvm/tools/clang/test/Modules/explicit-build.cpp 2>&1 | ${LLVM_SRC}/build/bin/FileCheck --check-prefix=CHECK-MULTIPLE-AS ${LLVM_SRC}/llvm/tools/clang/test/Modules/explicit-build.cpp
    RUN(TestState.Failed, "not %clang_cc1 -x c++ -std=c++11 -fmodules -fimplicit-module-maps -fmodules-cache-path=%t -Rmodule-build -fno-modules-error-recovery -fmodule-file=%t/a-alt.pcm -fmodule-file=%t/a.pcm -fmodule-map-file=%S/Inputs/explicit-build/module.modulemap %s 2>&1")./*|*/
      I("FileCheck --check-prefix=CHECK-MULTIPLE-AS %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x c++ -std=c++11 -fmodules -fimplicit-module-maps '-fmodules-cache-path=${TEST_TEMP_DIR}/explicit-build.cpp.tmp' -Rmodule-build -fno-modules-error-recovery -fmodule-name=a -emit-pch ${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs/explicit-build/a.h -o ${TEST_TEMP_DIR}/explicit-build.cpp.tmp/a.pch -DBUILDING_A_PCH 2>&1 | ${LLVM_SRC}/build/bin/FileCheck --check-prefix=CHECK-NO-IMPLICIT-BUILD ${LLVM_SRC}/llvm/tools/clang/test/Modules/explicit-build.cpp --allow-empty
    RUN(TestState.Failed, "%clang_cc1 -x c++ -std=c++11 -fmodules -fimplicit-module-maps -fmodules-cache-path=%t -Rmodule-build -fno-modules-error-recovery -fmodule-name=a -emit-pch %S/Inputs/explicit-build/a.h -o %t/a.pch -DBUILDING_A_PCH 2>&1")./*|*/
      I("FileCheck --check-prefix=CHECK-NO-IMPLICIT-BUILD %s --allow-empty");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x c++ -std=c++11 -fmodules -fimplicit-module-maps '-fmodules-cache-path=${TEST_TEMP_DIR}/explicit-build.cpp.tmp' -Rmodule-build -fno-modules-error-recovery '-fmodule-file=${TEST_TEMP_DIR}/explicit-build.cpp.tmp/a.pch' ${LLVM_SRC}/llvm/tools/clang/test/Modules/explicit-build.cpp 2>&1 | ${LLVM_SRC}/build/bin/FileCheck --check-prefix=CHECK-A-AS-PCH ${LLVM_SRC}/llvm/tools/clang/test/Modules/explicit-build.cpp
    RUN(TestState.Failed, "not %clang_cc1 -x c++ -std=c++11 -fmodules -fimplicit-module-maps -fmodules-cache-path=%t -Rmodule-build -fno-modules-error-recovery -fmodule-file=%t/a.pch %s 2>&1")./*|*/
      I("FileCheck --check-prefix=CHECK-A-AS-PCH %s");
    // touch ${TEST_TEMP_DIR}/explicit-build.cpp.tmp/not.pcm
    RUN(TestState.Failed, "touch %t/not.pcm");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x c++ -std=c++11 -fmodules -fimplicit-module-maps '-fmodules-cache-path=${TEST_TEMP_DIR}/explicit-build.cpp.tmp' -Rmodule-build -fno-modules-error-recovery '-fmodule-file=${TEST_TEMP_DIR}/explicit-build.cpp.tmp/not.pcm' ${LLVM_SRC}/llvm/tools/clang/test/Modules/explicit-build.cpp 2>&1 | ${LLVM_SRC}/build/bin/FileCheck --check-prefix=CHECK-BAD-FILE ${LLVM_SRC}/llvm/tools/clang/test/Modules/explicit-build.cpp
    RUN(TestState.Failed, "not %clang_cc1 -x c++ -std=c++11 -fmodules -fimplicit-module-maps -fmodules-cache-path=%t -Rmodule-build -fno-modules-error-recovery -fmodule-file=%t/not.pcm %s 2>&1")./*|*/
      I("FileCheck --check-prefix=CHECK-BAD-FILE %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x c++ -std=c++11 -fmodules -fimplicit-module-maps '-fmodules-cache-path=${TEST_TEMP_DIR}/explicit-build.cpp.tmp' -Rmodule-build -fno-modules-error-recovery '-fmodule-file=${TEST_TEMP_DIR}/explicit-build.cpp.tmp/nonexistent.pcm' ${LLVM_SRC}/llvm/tools/clang/test/Modules/explicit-build.cpp 2>&1 | ${LLVM_SRC}/build/bin/FileCheck --check-prefix=CHECK-NO-FILE ${LLVM_SRC}/llvm/tools/clang/test/Modules/explicit-build.cpp
    RUN(TestState.Failed, "not %clang_cc1 -x c++ -std=c++11 -fmodules -fimplicit-module-maps -fmodules-cache-path=%t -Rmodule-build -fno-modules-error-recovery -fmodule-file=%t/nonexistent.pcm %s 2>&1")./*|*/
      I("FileCheck --check-prefix=CHECK-NO-FILE %s");
    // mv ${TEST_TEMP_DIR}/explicit-build.cpp.tmp/a.pcm ${TEST_TEMP_DIR}/explicit-build.cpp.tmp/a-tmp.pcm
    RUN(TestState.Failed, "mv %t/a.pcm %t/a-tmp.pcm");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x c++ -std=c++11 -fmodules -fimplicit-module-maps '-fmodules-cache-path=${TEST_TEMP_DIR}/explicit-build.cpp.tmp' -Rmodule-build -fno-modules-error-recovery '-I${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs/explicit-build' '-fmodule-file=${TEST_TEMP_DIR}/explicit-build.cpp.tmp/c.pcm' ${LLVM_SRC}/llvm/tools/clang/test/Modules/explicit-build.cpp 2>&1 | ${LLVM_SRC}/build/bin/FileCheck --check-prefix=CHECK-NO-FILE-INDIRECT ${LLVM_SRC}/llvm/tools/clang/test/Modules/explicit-build.cpp
    RUN(TestState.Failed, "not %clang_cc1 -x c++ -std=c++11 -fmodules -fimplicit-module-maps -fmodules-cache-path=%t -Rmodule-build -fno-modules-error-recovery -I%S/Inputs/explicit-build -fmodule-file=%t/c.pcm %s 2>&1")./*|*/
      I("FileCheck --check-prefix=CHECK-NO-FILE-INDIRECT %s");
    // mv ${TEST_TEMP_DIR}/explicit-build.cpp.tmp/a-tmp.pcm ${TEST_TEMP_DIR}/explicit-build.cpp.tmp/a.pcm
    RUN(TestState.Failed, "mv %t/a-tmp.pcm %t/a.pcm");
    // touch ${TEST_TEMP_DIR}/explicit-build.cpp.tmp/b.pcm
    RUN(TestState.Failed, "touch %t/b.pcm");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x c++ -std=c++11 -fmodules -fimplicit-module-maps '-fmodules-cache-path=${TEST_TEMP_DIR}/explicit-build.cpp.tmp' -Rmodule-build -fno-modules-error-recovery '-I${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs/explicit-build' '-fmodule-file=${TEST_TEMP_DIR}/explicit-build.cpp.tmp/c.pcm' -verify ${LLVM_SRC}/llvm/tools/clang/test/Modules/explicit-build.cpp -DHAVE_A -DHAVE_B -DHAVE_C
    RUN(TestState.Failed, "%clang_cc1 -x c++ -std=c++11 -fmodules -fimplicit-module-maps -fmodules-cache-path=%t -Rmodule-build -fno-modules-error-recovery -I%S/Inputs/explicit-build -fmodule-file=%t/c.pcm -verify %s -DHAVE_A -DHAVE_B -DHAVE_C");
    // cp ${TEST_TEMP_DIR}/explicit-build.cpp.tmp/b-not-a.pcm ${TEST_TEMP_DIR}/explicit-build.cpp.tmp/b.pcm
    RUN(TestState.Failed, "cp %t/b-not-a.pcm %t/b.pcm");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x c++ -std=c++11 -fmodules -fimplicit-module-maps '-fmodules-cache-path=${TEST_TEMP_DIR}/explicit-build.cpp.tmp' -Rmodule-build -fno-modules-error-recovery '-I${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs/explicit-build' '-fmodule-file=${TEST_TEMP_DIR}/explicit-build.cpp.tmp/c.pcm' ${LLVM_SRC}/llvm/tools/clang/test/Modules/explicit-build.cpp -DHAVE_A -DHAVE_B -DHAVE_C 2>&1 | ${LLVM_SRC}/build/bin/FileCheck --check-prefix=CHECK-MISMATCHED-B ${LLVM_SRC}/llvm/tools/clang/test/Modules/explicit-build.cpp
    RUN(TestState.Failed, "not %clang_cc1 -x c++ -std=c++11 -fmodules -fimplicit-module-maps -fmodules-cache-path=%t -Rmodule-build -fno-modules-error-recovery -I%S/Inputs/explicit-build -fmodule-file=%t/c.pcm %s -DHAVE_A -DHAVE_B -DHAVE_C 2>&1")./*|*/
      I("FileCheck --check-prefix=CHECK-MISMATCHED-B %s");
  }

  @Test
  public void test_explicit_build_extra_files_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Modules/explicit-build-extra-files.cpp");
    // REQUIRES: shell
    if (!CHECK_REQUIRES("shell")) {
      return;
    }
    // rm -rf ${TEST_TEMP_DIR}/explicit-build-extra-files.cpp.tmp
    RUN(TestState.Failed, "rm -rf %t");
    // mkdir ${TEST_TEMP_DIR}/explicit-build-extra-files.cpp.tmp
    RUN(TestState.Failed, "mkdir %t");
    // cd ${TEST_TEMP_DIR}/explicit-build-extra-files.cpp.tmp
    RUN(TestState.Failed, "cd %t");
    // echo 'module X {}' > ${TEST_TEMP_DIR}/explicit-build-extra-files.cpp.tmp/x
    RUN(TestState.Failed, "echo 'module X {}' > %t/x");
    // echo 'module Y {}' > ${TEST_TEMP_DIR}/explicit-build-extra-files.cpp.tmp/y
    RUN(TestState.Failed, "echo 'module Y {}' > %t/y");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-module -fmodules -fmodule-name=X ${TEST_TEMP_DIR}/explicit-build-extra-files.cpp.tmp/x -x c++ -o ${TEST_TEMP_DIR}/explicit-build-extra-files.cpp.tmp/x.pcm
    RUN(TestState.Failed, "%clang_cc1 -emit-module -fmodules -fmodule-name=X %t/x -x c++ -o %t/x.pcm");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-module -fmodules -fmodule-name=Y ${TEST_TEMP_DIR}/explicit-build-extra-files.cpp.tmp/y -x c++ -o ${TEST_TEMP_DIR}/explicit-build-extra-files.cpp.tmp/y.pcm
    RUN(TestState.Failed, "%clang_cc1 -emit-module -fmodules -fmodule-name=Y %t/y -x c++ -o %t/y.pcm");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fmodules '-fmodule-file=${TEST_TEMP_DIR}/explicit-build-extra-files.cpp.tmp/x.pcm' '-fmodule-file=${TEST_TEMP_DIR}/explicit-build-extra-files.cpp.tmp/y.pcm' -x c++ /dev/null -fsyntax-only
    RUN(TestState.Failed, "%clang_cc1 -fmodules -fmodule-file=%t/x.pcm -fmodule-file=%t/y.pcm -x c++ /dev/null -fsyntax-only");
    // test -f ${TEST_TEMP_DIR}/explicit-build-extra-files.cpp.tmp/modules.timestamp
    RUN(TestState.Failed, "not test -f %t/modules.timestamp");
    // test -f ${TEST_TEMP_DIR}/explicit-build-extra-files.cpp.tmp/modules.idx
    RUN(TestState.Failed, "not test -f %t/modules.idx");
  }

  @Test
  public void test_explicit_build_flags_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Modules/explicit-build-flags.cpp");
    // rm -rf ${TEST_TEMP_DIR}/explicit-build-flags.cpp.tmp
    RUN(TestState.Failed, "rm -rf %t");
    // mkdir ${TEST_TEMP_DIR}/explicit-build-flags.cpp.tmp
    RUN(TestState.Failed, "mkdir %t");
    // echo 'module tmp { header "tmp.h" }' > ${TEST_TEMP_DIR}/explicit-build-flags.cpp.tmp/map
    RUN(TestState.Failed, "echo 'module tmp { header \"tmp.h\" }' > %t/map");
    // touch ${TEST_TEMP_DIR}/explicit-build-flags.cpp.tmp/tmp.h
    RUN(TestState.Failed, "touch %t/tmp.h");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fmodules -DFOO=1 -x c++ -fmodule-name=tmp ${TEST_TEMP_DIR}/explicit-build-flags.cpp.tmp/map -emit-module -o ${TEST_TEMP_DIR}/explicit-build-flags.cpp.tmp/tmp.pcm
    RUN(TestState.Failed, "%clang_cc1 -fmodules -DFOO=1 -x c++ -fmodule-name=tmp %t/map -emit-module -o %t/tmp.pcm");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fmodules -DFOO=1 -x c++ '-fmodule-map-file=${TEST_TEMP_DIR}/explicit-build-flags.cpp.tmp/map' '-fmodule-file=${TEST_TEMP_DIR}/explicit-build-flags.cpp.tmp/tmp.pcm' -verify '-I${TEST_TEMP_DIR}/explicit-build-flags.cpp.tmp' ${LLVM_SRC}/llvm/tools/clang/test/Modules/explicit-build-flags.cpp
    RUN(TestState.Failed, "%clang_cc1 -fmodules -DFOO=1 -x c++ -fmodule-map-file=%t/map -fmodule-file=%t/tmp.pcm -verify -I%t %s");
    // sleep 1
    RUN(TestState.Failed, "sleep 1");
    // touch ${TEST_TEMP_DIR}/explicit-build-flags.cpp.tmp/tmp.h
    RUN(TestState.Failed, "touch %t/tmp.h");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fmodules -DFOO=1 -x c++ '-fmodule-map-file=${TEST_TEMP_DIR}/explicit-build-flags.cpp.tmp/map' '-fmodule-file=${TEST_TEMP_DIR}/explicit-build-flags.cpp.tmp/tmp.pcm' -verify '-I${TEST_TEMP_DIR}/explicit-build-flags.cpp.tmp' ${LLVM_SRC}/llvm/tools/clang/test/Modules/explicit-build-flags.cpp
    RUN(TestState.Failed, "%clang_cc1 -fmodules -DFOO=1 -x c++ -fmodule-map-file=%t/map -fmodule-file=%t/tmp.pcm -verify -I%t %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fmodules -DFOO=2 -DBAR=1 -x c++ '-fmodule-map-file=${TEST_TEMP_DIR}/explicit-build-flags.cpp.tmp/map' '-fmodule-file=${TEST_TEMP_DIR}/explicit-build-flags.cpp.tmp/tmp.pcm' -verify '-I${TEST_TEMP_DIR}/explicit-build-flags.cpp.tmp' ${LLVM_SRC}/llvm/tools/clang/test/Modules/explicit-build-flags.cpp
    RUN(TestState.Failed, "%clang_cc1 -fmodules -DFOO=2 -DBAR=1 -x c++ -fmodule-map-file=%t/map -fmodule-file=%t/tmp.pcm -verify -I%t %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fmodules -DBAR=2 -x c++ '-fmodule-map-file=${TEST_TEMP_DIR}/explicit-build-flags.cpp.tmp/map' '-fmodule-file=${TEST_TEMP_DIR}/explicit-build-flags.cpp.tmp/tmp.pcm' -verify '-I${TEST_TEMP_DIR}/explicit-build-flags.cpp.tmp' ${LLVM_SRC}/llvm/tools/clang/test/Modules/explicit-build-flags.cpp
    RUN(TestState.Failed, "%clang_cc1 -fmodules -DBAR=2 -x c++ -fmodule-map-file=%t/map -fmodule-file=%t/tmp.pcm -verify -I%t %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fmodules -DBAR=2 -Wextra -x c++ '-fmodule-map-file=${TEST_TEMP_DIR}/explicit-build-flags.cpp.tmp/map' '-fmodule-file=${TEST_TEMP_DIR}/explicit-build-flags.cpp.tmp/tmp.pcm' -verify '-I${TEST_TEMP_DIR}/explicit-build-flags.cpp.tmp' ${LLVM_SRC}/llvm/tools/clang/test/Modules/explicit-build-flags.cpp
    RUN(TestState.Failed, "%clang_cc1 -fmodules -DBAR=2 -Wextra -x c++ -fmodule-map-file=%t/map -fmodule-file=%t/tmp.pcm -verify -I%t %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fmodules -DBAR=2 -I. -x c++ '-fmodule-map-file=${TEST_TEMP_DIR}/explicit-build-flags.cpp.tmp/map' '-fmodule-file=${TEST_TEMP_DIR}/explicit-build-flags.cpp.tmp/tmp.pcm' -verify '-I${TEST_TEMP_DIR}/explicit-build-flags.cpp.tmp' ${LLVM_SRC}/llvm/tools/clang/test/Modules/explicit-build-flags.cpp
    RUN(TestState.Failed, "%clang_cc1 -fmodules -DBAR=2 -I. -x c++ -fmodule-map-file=%t/map -fmodule-file=%t/tmp.pcm -verify -I%t %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fmodules -DBAR=2 -pic-level 2 -x c++ '-fmodule-map-file=${TEST_TEMP_DIR}/explicit-build-flags.cpp.tmp/map' '-fmodule-file=${TEST_TEMP_DIR}/explicit-build-flags.cpp.tmp/tmp.pcm' -verify '-I${TEST_TEMP_DIR}/explicit-build-flags.cpp.tmp' ${LLVM_SRC}/llvm/tools/clang/test/Modules/explicit-build-flags.cpp
    RUN(TestState.Failed, "%clang_cc1 -fmodules -DBAR=2 -pic-level 2 -x c++ -fmodule-map-file=%t/map -fmodule-file=%t/tmp.pcm -verify -I%t %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fmodules -DBAR=2 -pic-level 1 -pic-is-pie -x c++ '-fmodule-map-file=${TEST_TEMP_DIR}/explicit-build-flags.cpp.tmp/map' '-fmodule-file=${TEST_TEMP_DIR}/explicit-build-flags.cpp.tmp/tmp.pcm' -verify '-I${TEST_TEMP_DIR}/explicit-build-flags.cpp.tmp' ${LLVM_SRC}/llvm/tools/clang/test/Modules/explicit-build-flags.cpp
    RUN(TestState.Failed, "%clang_cc1 -fmodules -DBAR=2 -pic-level 1 -pic-is-pie -x c++ -fmodule-map-file=%t/map -fmodule-file=%t/tmp.pcm -verify -I%t %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fmodules -DBAR=2 -static-define -x c++ '-fmodule-map-file=${TEST_TEMP_DIR}/explicit-build-flags.cpp.tmp/map' '-fmodule-file=${TEST_TEMP_DIR}/explicit-build-flags.cpp.tmp/tmp.pcm' -verify '-I${TEST_TEMP_DIR}/explicit-build-flags.cpp.tmp' ${LLVM_SRC}/llvm/tools/clang/test/Modules/explicit-build-flags.cpp
    RUN(TestState.Failed, "%clang_cc1 -fmodules -DBAR=2 -static-define -x c++ -fmodule-map-file=%t/map -fmodule-file=%t/tmp.pcm -verify -I%t %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fmodules -DBAR=2 -fsanitize=address -x c++ '-fmodule-map-file=${TEST_TEMP_DIR}/explicit-build-flags.cpp.tmp/map' '-fmodule-file=${TEST_TEMP_DIR}/explicit-build-flags.cpp.tmp/tmp.pcm' -verify '-I${TEST_TEMP_DIR}/explicit-build-flags.cpp.tmp' ${LLVM_SRC}/llvm/tools/clang/test/Modules/explicit-build-flags.cpp
    RUN(TestState.Failed, "%clang_cc1 -fmodules -DBAR=2 -fsanitize=address -x c++ -fmodule-map-file=%t/map -fmodule-file=%t/tmp.pcm -verify -I%t %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fmodules -DFOO=1 -fsanitize=address -x c++ -fmodule-name=tmp ${TEST_TEMP_DIR}/explicit-build-flags.cpp.tmp/map -emit-module -o ${TEST_TEMP_DIR}/explicit-build-flags.cpp.tmp/tmp-san.pcm
    RUN(TestState.Failed, "%clang_cc1 -fmodules -DFOO=1 -fsanitize=address -x c++ -fmodule-name=tmp %t/map -emit-module -o %t/tmp-san.pcm");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fmodules -DBAR=2 -x c++ '-fmodule-map-file=${TEST_TEMP_DIR}/explicit-build-flags.cpp.tmp/map' '-fmodule-file=${TEST_TEMP_DIR}/explicit-build-flags.cpp.tmp/tmp-san.pcm' -verify '-I${TEST_TEMP_DIR}/explicit-build-flags.cpp.tmp' ${LLVM_SRC}/llvm/tools/clang/test/Modules/explicit-build-flags.cpp
    RUN(TestState.Failed, "%clang_cc1 -fmodules -DBAR=2 -x c++ -fmodule-map-file=%t/map -fmodule-file=%t/tmp-san.pcm -verify -I%t %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fmodules -DBAR=2 -fno-assume-sane-operator-new -x c++ '-fmodule-map-file=${TEST_TEMP_DIR}/explicit-build-flags.cpp.tmp/map' '-fmodule-file=${TEST_TEMP_DIR}/explicit-build-flags.cpp.tmp/tmp.pcm' -verify '-I${TEST_TEMP_DIR}/explicit-build-flags.cpp.tmp' ${LLVM_SRC}/llvm/tools/clang/test/Modules/explicit-build-flags.cpp
    RUN(TestState.Failed, "%clang_cc1 -fmodules -DBAR=2 -fno-assume-sane-operator-new -x c++ -fmodule-map-file=%t/map -fmodule-file=%t/tmp.pcm -verify -I%t %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fmodules -DBAR=2 -Os -x c++ '-fmodule-map-file=${TEST_TEMP_DIR}/explicit-build-flags.cpp.tmp/map' '-fmodule-file=${TEST_TEMP_DIR}/explicit-build-flags.cpp.tmp/tmp.pcm' -verify '-I${TEST_TEMP_DIR}/explicit-build-flags.cpp.tmp' ${LLVM_SRC}/llvm/tools/clang/test/Modules/explicit-build-flags.cpp
    RUN(TestState.Failed, "%clang_cc1 -fmodules -DBAR=2 -Os -x c++ -fmodule-map-file=%t/map -fmodule-file=%t/tmp.pcm -verify -I%t %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fmodules -DFOO=1 -O2 -x c++ -fmodule-name=tmp ${TEST_TEMP_DIR}/explicit-build-flags.cpp.tmp/map -emit-module -o ${TEST_TEMP_DIR}/explicit-build-flags.cpp.tmp/tmp-O2.pcm
    RUN(TestState.Failed, "%clang_cc1 -fmodules -DFOO=1 -O2 -x c++ -fmodule-name=tmp %t/map -emit-module -o %t/tmp-O2.pcm");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fmodules -DBAR=2 -O0 -x c++ '-fmodule-map-file=${TEST_TEMP_DIR}/explicit-build-flags.cpp.tmp/map' '-fmodule-file=${TEST_TEMP_DIR}/explicit-build-flags.cpp.tmp/tmp-O2.pcm' -verify '-I${TEST_TEMP_DIR}/explicit-build-flags.cpp.tmp' ${LLVM_SRC}/llvm/tools/clang/test/Modules/explicit-build-flags.cpp
    RUN(TestState.Failed, "%clang_cc1 -fmodules -DBAR=2 -O0 -x c++ -fmodule-map-file=%t/map -fmodule-file=%t/tmp-O2.pcm -verify -I%t %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fmodules -DBAR=2 -Os -x c++ '-fmodule-map-file=${TEST_TEMP_DIR}/explicit-build-flags.cpp.tmp/map' '-fmodule-file=${TEST_TEMP_DIR}/explicit-build-flags.cpp.tmp/tmp-O2.pcm' -verify '-I${TEST_TEMP_DIR}/explicit-build-flags.cpp.tmp' ${LLVM_SRC}/llvm/tools/clang/test/Modules/explicit-build-flags.cpp
    RUN(TestState.Failed, "%clang_cc1 -fmodules -DBAR=2 -Os -x c++ -fmodule-map-file=%t/map -fmodule-file=%t/tmp-O2.pcm -verify -I%t %s");
  }

  @Test
  public void test_explicit_build_missing_files_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Modules/explicit-build-missing-files.cpp");
    // REQUIRES: can-remove-opened-file
    if (!CHECK_REQUIRES("can-remove-opened-file")) {
      return;
    }
    // rm -rf ${TEST_TEMP_DIR}/explicit-build-missing-files.cpp.tmp
    RUN(TestState.Failed, "rm -rf %t");
    // mkdir ${TEST_TEMP_DIR}/explicit-build-missing-files.cpp.tmp
    RUN(TestState.Failed, "mkdir %t");
    // echo 'extern int a; template<typename T> int a2 = T::error;' > ${TEST_TEMP_DIR}/explicit-build-missing-files.cpp.tmp/a.h
    RUN(TestState.Failed, "echo 'extern int a; template<typename T> int a2 = T::error;' > %t/a.h");
    // echo 'extern int b;' > ${TEST_TEMP_DIR}/explicit-build-missing-files.cpp.tmp/b.h
    RUN(TestState.Failed, "echo 'extern int b;' > %t/b.h");
    // echo 'extern int c = 0;' > ${TEST_TEMP_DIR}/explicit-build-missing-files.cpp.tmp/c.h
    RUN(TestState.Failed, "echo 'extern int c = 0;' > %t/c.h");
    // echo 'module a { module aa { header "a.h" header "b.h" header "c.h" } }' > ${TEST_TEMP_DIR}/explicit-build-missing-files.cpp.tmp/modulemap
    RUN(TestState.Failed, "echo 'module a { module aa { header \"a.h\" header \"b.h\" header \"c.h\" } }' > %t/modulemap");
    // echo 'module other {}' > ${TEST_TEMP_DIR}/explicit-build-missing-files.cpp.tmp/other.modulemap
    RUN(TestState.Failed, "echo 'module other {}' > %t/other.modulemap");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fmodules -I ${TEST_TEMP_DIR}/explicit-build-missing-files.cpp.tmp -emit-module -fmodule-name=a -x c++ ${TEST_TEMP_DIR}/explicit-build-missing-files.cpp.tmp/modulemap -o ${TEST_TEMP_DIR}/explicit-build-missing-files.cpp.tmp/a.pcm '-fmodule-map-file=${TEST_TEMP_DIR}/explicit-build-missing-files.cpp.tmp/other.modulemap' '-fmodules-embed-file=${TEST_TEMP_DIR}/explicit-build-missing-files.cpp.tmp/modulemap' '-fmodules-embed-file=${TEST_TEMP_DIR}/explicit-build-missing-files.cpp.tmp/other.modulemap'
    RUN(TestState.Failed, "%clang_cc1 -fmodules -I %t -emit-module -fmodule-name=a -x c++ %t/modulemap -o %t/a.pcm -fmodule-map-file=%t/other.modulemap -fmodules-embed-file=%t/modulemap -fmodules-embed-file=%t/other.modulemap");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fmodules -I ${TEST_TEMP_DIR}/explicit-build-missing-files.cpp.tmp -emit-module -fmodule-name=a -x c++ ${TEST_TEMP_DIR}/explicit-build-missing-files.cpp.tmp/modulemap -o ${TEST_TEMP_DIR}/explicit-build-missing-files.cpp.tmp/b.pcm '-fmodule-map-file=${TEST_TEMP_DIR}/explicit-build-missing-files.cpp.tmp/other.modulemap' -fmodules-embed-all-files
    RUN(TestState.Failed, "%clang_cc1 -fmodules -I %t -emit-module -fmodule-name=a -x c++ %t/modulemap -o %t/b.pcm -fmodule-map-file=%t/other.modulemap -fmodules-embed-all-files");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fmodules -I ${TEST_TEMP_DIR}/explicit-build-missing-files.cpp.tmp '-fmodule-file=${TEST_TEMP_DIR}/explicit-build-missing-files.cpp.tmp/a.pcm' ${LLVM_SRC}/llvm/tools/clang/test/Modules/explicit-build-missing-files.cpp
    RUN(TestState.Failed, "%clang_cc1 -fmodules -I %t -fmodule-file=%t/a.pcm %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fmodules -I ${TEST_TEMP_DIR}/explicit-build-missing-files.cpp.tmp '-fmodule-file=${TEST_TEMP_DIR}/explicit-build-missing-files.cpp.tmp/a.pcm' ${LLVM_SRC}/llvm/tools/clang/test/Modules/explicit-build-missing-files.cpp -DERRORS 2>&1 | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Modules/explicit-build-missing-files.cpp
    RUN(TestState.Failed, "not %clang_cc1 -fmodules -I %t -fmodule-file=%t/a.pcm %s -DERRORS 2>&1")./*|*/
      I("FileCheck %s");
    // mv ${TEST_TEMP_DIR}/explicit-build-missing-files.cpp.tmp/modulemap ${TEST_TEMP_DIR}/explicit-build-missing-files.cpp.tmp/modulemap.moved
    RUN(TestState.Failed, "mv %t/modulemap %t/modulemap.moved");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fmodules -I ${TEST_TEMP_DIR}/explicit-build-missing-files.cpp.tmp '-fmodule-file=${TEST_TEMP_DIR}/explicit-build-missing-files.cpp.tmp/a.pcm' ${LLVM_SRC}/llvm/tools/clang/test/Modules/explicit-build-missing-files.cpp
    RUN(TestState.Failed, "%clang_cc1 -fmodules -I %t -fmodule-file=%t/a.pcm %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fmodules -I ${TEST_TEMP_DIR}/explicit-build-missing-files.cpp.tmp '-fmodule-file=${TEST_TEMP_DIR}/explicit-build-missing-files.cpp.tmp/a.pcm' ${LLVM_SRC}/llvm/tools/clang/test/Modules/explicit-build-missing-files.cpp -DERRORS 2>&1 | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Modules/explicit-build-missing-files.cpp
    RUN(TestState.Failed, "not %clang_cc1 -fmodules -I %t -fmodule-file=%t/a.pcm %s -DERRORS 2>&1")./*|*/
      I("FileCheck %s");
    // rm ${TEST_TEMP_DIR}/explicit-build-missing-files.cpp.tmp/other.modulemap
    RUN(TestState.Failed, "rm %t/other.modulemap");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fmodules -I ${TEST_TEMP_DIR}/explicit-build-missing-files.cpp.tmp '-fmodule-file=${TEST_TEMP_DIR}/explicit-build-missing-files.cpp.tmp/a.pcm' ${LLVM_SRC}/llvm/tools/clang/test/Modules/explicit-build-missing-files.cpp
    RUN(TestState.Failed, "%clang_cc1 -fmodules -I %t -fmodule-file=%t/a.pcm %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fmodules -I ${TEST_TEMP_DIR}/explicit-build-missing-files.cpp.tmp '-fmodule-file=${TEST_TEMP_DIR}/explicit-build-missing-files.cpp.tmp/a.pcm' ${LLVM_SRC}/llvm/tools/clang/test/Modules/explicit-build-missing-files.cpp -DERRORS 2>&1 | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Modules/explicit-build-missing-files.cpp
    RUN(TestState.Failed, "not %clang_cc1 -fmodules -I %t -fmodule-file=%t/a.pcm %s -DERRORS 2>&1")./*|*/
      I("FileCheck %s");
    // sleep 1
    RUN(TestState.Failed, "sleep 1");
    // touch ${TEST_TEMP_DIR}/explicit-build-missing-files.cpp.tmp/a.h
    RUN(TestState.Failed, "touch %t/a.h");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fmodules -I ${TEST_TEMP_DIR}/explicit-build-missing-files.cpp.tmp '-fmodule-file=${TEST_TEMP_DIR}/explicit-build-missing-files.cpp.tmp/a.pcm' ${LLVM_SRC}/llvm/tools/clang/test/Modules/explicit-build-missing-files.cpp
    RUN(TestState.Failed, "%clang_cc1 -fmodules -I %t -fmodule-file=%t/a.pcm %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fmodules -I ${TEST_TEMP_DIR}/explicit-build-missing-files.cpp.tmp '-fmodule-file=${TEST_TEMP_DIR}/explicit-build-missing-files.cpp.tmp/a.pcm' ${LLVM_SRC}/llvm/tools/clang/test/Modules/explicit-build-missing-files.cpp -DERRORS 2>&1 | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Modules/explicit-build-missing-files.cpp
    RUN(TestState.Failed, "not %clang_cc1 -fmodules -I %t -fmodule-file=%t/a.pcm %s -DERRORS 2>&1")./*|*/
      I("FileCheck %s");
    // rm ${TEST_TEMP_DIR}/explicit-build-missing-files.cpp.tmp/b.h
    RUN(TestState.Failed, "rm %t/b.h");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fmodules -I ${TEST_TEMP_DIR}/explicit-build-missing-files.cpp.tmp '-fmodule-file=${TEST_TEMP_DIR}/explicit-build-missing-files.cpp.tmp/a.pcm' ${LLVM_SRC}/llvm/tools/clang/test/Modules/explicit-build-missing-files.cpp
    RUN(TestState.Failed, "%clang_cc1 -fmodules -I %t -fmodule-file=%t/a.pcm %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fmodules -I ${TEST_TEMP_DIR}/explicit-build-missing-files.cpp.tmp '-fmodule-file=${TEST_TEMP_DIR}/explicit-build-missing-files.cpp.tmp/b.pcm' ${LLVM_SRC}/llvm/tools/clang/test/Modules/explicit-build-missing-files.cpp
    RUN(TestState.Failed, "%clang_cc1 -fmodules -I %t -fmodule-file=%t/b.pcm %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fmodules -I ${TEST_TEMP_DIR}/explicit-build-missing-files.cpp.tmp '-fmodule-file=${TEST_TEMP_DIR}/explicit-build-missing-files.cpp.tmp/a.pcm' ${LLVM_SRC}/llvm/tools/clang/test/Modules/explicit-build-missing-files.cpp -DERRORS 2>&1 | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Modules/explicit-build-missing-files.cpp --check-prefix=MISSING-B
    RUN(TestState.Failed, "not %clang_cc1 -fmodules -I %t -fmodule-file=%t/a.pcm %s -DERRORS 2>&1")./*|*/
      I("FileCheck %s --check-prefix=MISSING-B");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fmodules -I ${TEST_TEMP_DIR}/explicit-build-missing-files.cpp.tmp '-fmodule-file=${TEST_TEMP_DIR}/explicit-build-missing-files.cpp.tmp/a.pcm' '-fmodule-map-file=${TEST_TEMP_DIR}/explicit-build-missing-files.cpp.tmp/modulemap.moved' ${LLVM_SRC}/llvm/tools/clang/test/Modules/explicit-build-missing-files.cpp
    RUN(TestState.Failed, "%clang_cc1 -fmodules -I %t -fmodule-file=%t/a.pcm -fmodule-map-file=%t/modulemap.moved %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fmodules -I ${TEST_TEMP_DIR}/explicit-build-missing-files.cpp.tmp '-fmodule-file=${TEST_TEMP_DIR}/explicit-build-missing-files.cpp.tmp/a.pcm' '-fmodule-map-file=${TEST_TEMP_DIR}/explicit-build-missing-files.cpp.tmp/modulemap.moved' -std=c++1z ${LLVM_SRC}/llvm/tools/clang/test/Modules/explicit-build-missing-files.cpp
    RUN(TestState.Failed, "not %clang_cc1 -fmodules -I %t -fmodule-file=%t/a.pcm -fmodule-map-file=%t/modulemap.moved -std=c++1z %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fmodules -I ${TEST_TEMP_DIR}/explicit-build-missing-files.cpp.tmp '-fmodule-file=${TEST_TEMP_DIR}/explicit-build-missing-files.cpp.tmp/a.pcm' '-fmodule-map-file=${TEST_TEMP_DIR}/explicit-build-missing-files.cpp.tmp/modulemap.moved' -std=c++1z -Wno-module-file-config-mismatch ${LLVM_SRC}/llvm/tools/clang/test/Modules/explicit-build-missing-files.cpp -Db=a
    RUN(TestState.Failed, "%clang_cc1 -fmodules -I %t -fmodule-file=%t/a.pcm -fmodule-map-file=%t/modulemap.moved -std=c++1z -Wno-module-file-config-mismatch %s -Db=a");
    // rm ${TEST_TEMP_DIR}/explicit-build-missing-files.cpp.tmp/a.h
    RUN(TestState.Failed, "rm %t/a.h");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fmodules -I ${TEST_TEMP_DIR}/explicit-build-missing-files.cpp.tmp '-fmodule-file=${TEST_TEMP_DIR}/explicit-build-missing-files.cpp.tmp/a.pcm' ${LLVM_SRC}/llvm/tools/clang/test/Modules/explicit-build-missing-files.cpp -verify
    RUN(TestState.Failed, "%clang_cc1 -fmodules -I %t -fmodule-file=%t/a.pcm %s -verify");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fmodules -I ${TEST_TEMP_DIR}/explicit-build-missing-files.cpp.tmp '-fmodule-file=${TEST_TEMP_DIR}/explicit-build-missing-files.cpp.tmp/b.pcm' ${LLVM_SRC}/llvm/tools/clang/test/Modules/explicit-build-missing-files.cpp -verify
    RUN(TestState.Failed, "%clang_cc1 -fmodules -I %t -fmodule-file=%t/b.pcm %s -verify");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fmodules -I ${TEST_TEMP_DIR}/explicit-build-missing-files.cpp.tmp -emit-module -fmodule-name=a -x c++ /dev/null -o ${TEST_TEMP_DIR}/explicit-build-missing-files.cpp.tmp/c.pcm '-fmodules-embed-file=${TEST_TEMP_DIR}/explicit-build-missing-files.cpp.tmp/does-not-exist' 2>&1 | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Modules/explicit-build-missing-files.cpp --check-prefix=MISSING-EMBED
    RUN(TestState.Failed, "not %clang_cc1 -fmodules -I %t -emit-module -fmodule-name=a -x c++ /dev/null -o %t/c.pcm -fmodules-embed-file=%t/does-not-exist 2>&1")./*|*/
      I("FileCheck %s --check-prefix=MISSING-EMBED");
  }

  @Test
  public void test_explicit_build_overlap_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Modules/explicit-build-overlap.cpp");
    // rm -rf ${TEST_TEMP_DIR}/explicit-build-overlap.cpp.tmp
    RUN("rm -rf %t");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x c++ -fmodules ${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs/explicit-build-overlap/def.map -fmodule-name=a -emit-module -o ${TEST_TEMP_DIR}/explicit-build-overlap.cpp.tmp/a.pcm
    RUN("%clang_cc1 -x c++ -fmodules                   %S/Inputs/explicit-build-overlap/def.map -fmodule-name=a -emit-module -o %t/a.pcm");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x c++ -fmodules ${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs/explicit-build-overlap/def.map -fmodule-name=b -emit-module -o ${TEST_TEMP_DIR}/explicit-build-overlap.cpp.tmp/ba.pcm '-fmodule-file=${TEST_TEMP_DIR}/explicit-build-overlap.cpp.tmp/a.pcm'
    RUN("%clang_cc1 -x c++ -fmodules                   %S/Inputs/explicit-build-overlap/def.map -fmodule-name=b -emit-module -o %t/ba.pcm -fmodule-file=%t/a.pcm");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x c++ -fmodules '-fmodule-map-file=${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs/explicit-build-overlap/use.map' -fmodule-name=use '-fmodule-file=${TEST_TEMP_DIR}/explicit-build-overlap.cpp.tmp/ba.pcm' ${LLVM_SRC}/llvm/tools/clang/test/Modules/explicit-build-overlap.cpp -verify '-I${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs/explicit-build-overlap' -fmodules-decluse
    RUN("%clang_cc1 -x c++ -fmodules -fmodule-map-file=%S/Inputs/explicit-build-overlap/use.map -fmodule-name=use -fmodule-file=%t/ba.pcm %s -verify -I%S/Inputs/explicit-build-overlap -fmodules-decluse");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x c++ -fmodules ${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs/explicit-build-overlap/def.map -fmodule-name=b -emit-module -o ${TEST_TEMP_DIR}/explicit-build-overlap.cpp.tmp/b.pcm
    RUN("%clang_cc1 -x c++ -fmodules                   %S/Inputs/explicit-build-overlap/def.map -fmodule-name=b -emit-module -o %t/b.pcm");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x c++ -fmodules ${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs/explicit-build-overlap/def.map -fmodule-name=a -emit-module -o ${TEST_TEMP_DIR}/explicit-build-overlap.cpp.tmp/ab.pcm '-fmodule-file=${TEST_TEMP_DIR}/explicit-build-overlap.cpp.tmp/b.pcm'
    RUN("%clang_cc1 -x c++ -fmodules                   %S/Inputs/explicit-build-overlap/def.map -fmodule-name=a -emit-module -o %t/ab.pcm -fmodule-file=%t/b.pcm");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x c++ -fmodules '-fmodule-map-file=${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs/explicit-build-overlap/use.map' -fmodule-name=use '-fmodule-file=${TEST_TEMP_DIR}/explicit-build-overlap.cpp.tmp/ab.pcm' ${LLVM_SRC}/llvm/tools/clang/test/Modules/explicit-build-overlap.cpp -verify '-I${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs/explicit-build-overlap' -fmodules-decluse
    RUN("%clang_cc1 -x c++ -fmodules -fmodule-map-file=%S/Inputs/explicit-build-overlap/use.map -fmodule-name=use -fmodule-file=%t/ab.pcm %s -verify -I%S/Inputs/explicit-build-overlap -fmodules-decluse");
  }

  @Test
  public void test_explicit_build_prefer_self_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Modules/explicit-build-prefer-self.cpp");
    // rm -rf ${TEST_TEMP_DIR}/explicit-build-prefer-self.cpp.tmp
    RUN("rm -rf %t");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fmodules -fno-implicit-modules -emit-module -fmodule-name=a ${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs/explicit-build-prefer-self/map -o ${TEST_TEMP_DIR}/explicit-build-prefer-self.cpp.tmp/a.pcm
    RUN("%clang_cc1 -fmodules -fno-implicit-modules -emit-module -fmodule-name=a %S/Inputs/explicit-build-prefer-self/map -o %t/a.pcm");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fmodules -fno-implicit-modules -emit-module -fmodule-name=b ${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs/explicit-build-prefer-self/map -o ${TEST_TEMP_DIR}/explicit-build-prefer-self.cpp.tmp/b.pcm
    RUN("%clang_cc1 -fmodules -fno-implicit-modules -emit-module -fmodule-name=b %S/Inputs/explicit-build-prefer-self/map -o %t/b.pcm");
  }

  @Test
  public void test_explicit_build_relpath_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Modules/explicit-build-relpath.cpp");
    // rm -rf ${TEST_TEMP_DIR}/explicit-build-relpath.cpp.tmp
    RUN(TestState.Failed, "rm -rf %t");
    // mkdir ${TEST_TEMP_DIR}/explicit-build-relpath.cpp.tmp
    RUN(TestState.Failed, "mkdir %t");
    // cd ${TEST_TEMP_DIR}/explicit-build-relpath.cpp.tmp
    RUN(TestState.Failed, "cd %t");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x c++ -std=c++11 -fmodules -fimplicit-module-maps '-fmodules-cache-path=${TEST_TEMP_DIR}/explicit-build-relpath.cpp.tmp' -Rmodule-build -fno-modules-error-recovery -fmodule-name=a -emit-module ${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs/explicit-build/module.modulemap -o a.pcm
    RUN(TestState.Failed, "%clang_cc1 -x c++ -std=c++11 -fmodules -fimplicit-module-maps -fmodules-cache-path=%t -Rmodule-build -fno-modules-error-recovery -fmodule-name=a -emit-module %S/Inputs/explicit-build/module.modulemap -o a.pcm");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x c++ -std=c++11 -fmodules -fimplicit-module-maps '-fmodules-cache-path=${TEST_TEMP_DIR}/explicit-build-relpath.cpp.tmp' -Rmodule-build -fno-modules-error-recovery -fmodule-file=a.pcm -fmodule-name=b -emit-module ${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs/explicit-build/module.modulemap -o b-rel.pcm
    RUN(TestState.Failed, "%clang_cc1 -x c++ -std=c++11 -fmodules -fimplicit-module-maps -fmodules-cache-path=%t -Rmodule-build -fno-modules-error-recovery -fmodule-file=a.pcm -fmodule-name=b -emit-module %S/Inputs/explicit-build/module.modulemap -o b-rel.pcm");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x c++ -std=c++11 -fmodules -fimplicit-module-maps '-fmodules-cache-path=${TEST_TEMP_DIR}/explicit-build-relpath.cpp.tmp' -Rmodule-build -fno-modules-error-recovery '-fmodule-file=${TEST_TEMP_DIR}/explicit-build-relpath.cpp.tmp/a.pcm' -fmodule-name=b -emit-module ${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs/explicit-build/module.modulemap -o b-abs.pcm
    RUN(TestState.Failed, "%clang_cc1 -x c++ -std=c++11 -fmodules -fimplicit-module-maps -fmodules-cache-path=%t -Rmodule-build -fno-modules-error-recovery -fmodule-file=%t/a.pcm -fmodule-name=b -emit-module %S/Inputs/explicit-build/module.modulemap -o b-abs.pcm");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x c++ -std=c++11 -fmodules -fimplicit-module-maps '-fmodules-cache-path=${TEST_TEMP_DIR}/explicit-build-relpath.cpp.tmp' -Rmodule-build -fno-modules-error-recovery '-I${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs/explicit-build' '-fmodule-file=${TEST_TEMP_DIR}/explicit-build-relpath.cpp.tmp/a.pcm' -fmodule-file=a.pcm -verify ${LLVM_SRC}/llvm/tools/clang/test/Modules/explicit-build-relpath.cpp
    RUN(TestState.Failed, "%clang_cc1 -x c++ -std=c++11 -fmodules -fimplicit-module-maps -fmodules-cache-path=%t -Rmodule-build -fno-modules-error-recovery -I%S/Inputs/explicit-build -fmodule-file=%t/a.pcm -fmodule-file=a.pcm -verify %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x c++ -std=c++11 -fmodules -fimplicit-module-maps '-fmodules-cache-path=${TEST_TEMP_DIR}/explicit-build-relpath.cpp.tmp' -Rmodule-build -fno-modules-error-recovery '-I${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs/explicit-build' '-fmodule-file=${TEST_TEMP_DIR}/explicit-build-relpath.cpp.tmp/a.pcm' -fmodule-file=b-rel.pcm -verify ${LLVM_SRC}/llvm/tools/clang/test/Modules/explicit-build-relpath.cpp
    RUN(TestState.Failed, "%clang_cc1 -x c++ -std=c++11 -fmodules -fimplicit-module-maps -fmodules-cache-path=%t -Rmodule-build -fno-modules-error-recovery -I%S/Inputs/explicit-build -fmodule-file=%t/a.pcm -fmodule-file=b-rel.pcm -verify %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x c++ -std=c++11 -fmodules -fimplicit-module-maps '-fmodules-cache-path=${TEST_TEMP_DIR}/explicit-build-relpath.cpp.tmp' -Rmodule-build -fno-modules-error-recovery '-I${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs/explicit-build' -fmodule-file=a.pcm -fmodule-file=b-abs.pcm -verify ${LLVM_SRC}/llvm/tools/clang/test/Modules/explicit-build-relpath.cpp
    RUN(TestState.Failed, "%clang_cc1 -x c++ -std=c++11 -fmodules -fimplicit-module-maps -fmodules-cache-path=%t -Rmodule-build -fno-modules-error-recovery -I%S/Inputs/explicit-build -fmodule-file=a.pcm -fmodule-file=b-abs.pcm -verify %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x c++ -std=c++11 -fmodules -fimplicit-module-maps '-fmodules-cache-path=${TEST_TEMP_DIR}/explicit-build-relpath.cpp.tmp' -Rmodule-build -fno-modules-error-recovery '-I${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs/explicit-build' -fmodule-file=b-rel.pcm -fmodule-file=b-abs.pcm -verify ${LLVM_SRC}/llvm/tools/clang/test/Modules/explicit-build-relpath.cpp 2>&1 | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Modules/explicit-build-relpath.cpp
    RUN(TestState.Failed, "not %clang_cc1 -x c++ -std=c++11 -fmodules -fimplicit-module-maps -fmodules-cache-path=%t -Rmodule-build -fno-modules-error-recovery -I%S/Inputs/explicit-build -fmodule-file=b-rel.pcm -fmodule-file=b-abs.pcm -verify %s 2>&1")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_exponential_paths_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Modules/exponential-paths.cpp");
    // REQUIRES: shell
    if (!CHECK_REQUIRES("shell")) {
      return;
    }
    // rm -rf ${TEST_TEMP_DIR}/exponential-paths.cpp.tmp
    RUN(TestState.Failed, "rm -rf %t");
    // mkdir ${TEST_TEMP_DIR}/exponential-paths.cpp.tmp
    RUN(TestState.Failed, "mkdir %t");
    // echo 'module a0 { header "a0.h" export * }' > ${TEST_TEMP_DIR}/exponential-paths.cpp.tmp/module.modulemap
    RUN(TestState.Failed, "echo 'module a0 { header \"a0.h\" export * }' > %t/module.modulemap");
    // echo 'module b0 { header "b0.h" export * }' >> ${TEST_TEMP_DIR}/exponential-paths.cpp.tmp/module.modulemap
    RUN(TestState.Failed, "echo 'module b0 { header \"b0.h\" export * }' >> %t/module.modulemap");
    // echo 'module a1 { header "a1.h" export * }' >> ${TEST_TEMP_DIR}/exponential-paths.cpp.tmp/module.modulemap
    RUN(TestState.Failed, "echo 'module a1 { header \"a1.h\" export * }' >> %t/module.modulemap");
    // echo 'module b1 { header "b1.h" export * }' >> ${TEST_TEMP_DIR}/exponential-paths.cpp.tmp/module.modulemap
    RUN(TestState.Failed, "echo 'module b1 { header \"b1.h\" export * }' >> %t/module.modulemap");
    // echo 'module a2 { header "a2.h" export * }' >> ${TEST_TEMP_DIR}/exponential-paths.cpp.tmp/module.modulemap
    RUN(TestState.Failed, "echo 'module a2 { header \"a2.h\" export * }' >> %t/module.modulemap");
    // echo 'module b2 { header "b2.h" export * }' >> ${TEST_TEMP_DIR}/exponential-paths.cpp.tmp/module.modulemap
    RUN(TestState.Failed, "echo 'module b2 { header \"b2.h\" export * }' >> %t/module.modulemap");
    // echo 'module a3 { header "a3.h" export * }' >> ${TEST_TEMP_DIR}/exponential-paths.cpp.tmp/module.modulemap
    RUN(TestState.Failed, "echo 'module a3 { header \"a3.h\" export * }' >> %t/module.modulemap");
    // echo 'module b3 { header "b3.h" export * }' >> ${TEST_TEMP_DIR}/exponential-paths.cpp.tmp/module.modulemap
    RUN(TestState.Failed, "echo 'module b3 { header \"b3.h\" export * }' >> %t/module.modulemap");
    // echo 'module a4 { header "a4.h" export * }' >> ${TEST_TEMP_DIR}/exponential-paths.cpp.tmp/module.modulemap
    RUN(TestState.Failed, "echo 'module a4 { header \"a4.h\" export * }' >> %t/module.modulemap");
    // echo 'module b4 { header "b4.h" export * }' >> ${TEST_TEMP_DIR}/exponential-paths.cpp.tmp/module.modulemap
    RUN(TestState.Failed, "echo 'module b4 { header \"b4.h\" export * }' >> %t/module.modulemap");
    // echo 'module a5 { header "a5.h" export * }' >> ${TEST_TEMP_DIR}/exponential-paths.cpp.tmp/module.modulemap
    RUN(TestState.Failed, "echo 'module a5 { header \"a5.h\" export * }' >> %t/module.modulemap");
    // echo 'module b5 { header "b5.h" export * }' >> ${TEST_TEMP_DIR}/exponential-paths.cpp.tmp/module.modulemap
    RUN(TestState.Failed, "echo 'module b5 { header \"b5.h\" export * }' >> %t/module.modulemap");
    // echo 'module a6 { header "a6.h" export * }' >> ${TEST_TEMP_DIR}/exponential-paths.cpp.tmp/module.modulemap
    RUN(TestState.Failed, "echo 'module a6 { header \"a6.h\" export * }' >> %t/module.modulemap");
    // echo 'module b6 { header "b6.h" export * }' >> ${TEST_TEMP_DIR}/exponential-paths.cpp.tmp/module.modulemap
    RUN(TestState.Failed, "echo 'module b6 { header \"b6.h\" export * }' >> %t/module.modulemap");
    // echo 'module a7 { header "a7.h" export * }' >> ${TEST_TEMP_DIR}/exponential-paths.cpp.tmp/module.modulemap
    RUN(TestState.Failed, "echo 'module a7 { header \"a7.h\" export * }' >> %t/module.modulemap");
    // echo 'module b7 { header "b7.h" export * }' >> ${TEST_TEMP_DIR}/exponential-paths.cpp.tmp/module.modulemap
    RUN(TestState.Failed, "echo 'module b7 { header \"b7.h\" export * }' >> %t/module.modulemap");
    // echo 'module a8 { header "a8.h" export * }' >> ${TEST_TEMP_DIR}/exponential-paths.cpp.tmp/module.modulemap
    RUN(TestState.Failed, "echo 'module a8 { header \"a8.h\" export * }' >> %t/module.modulemap");
    // echo 'module b8 { header "b8.h" export * }' >> ${TEST_TEMP_DIR}/exponential-paths.cpp.tmp/module.modulemap
    RUN(TestState.Failed, "echo 'module b8 { header \"b8.h\" export * }' >> %t/module.modulemap");
    // echo 'module a9 { header "a9.h" export * }' >> ${TEST_TEMP_DIR}/exponential-paths.cpp.tmp/module.modulemap
    RUN(TestState.Failed, "echo 'module a9 { header \"a9.h\" export * }' >> %t/module.modulemap");
    // echo 'module b9 { header "b9.h" export * }' >> ${TEST_TEMP_DIR}/exponential-paths.cpp.tmp/module.modulemap
    RUN(TestState.Failed, "echo 'module b9 { header \"b9.h\" export * }' >> %t/module.modulemap");
    // echo 'module a10 { header "a10.h" export * }' >> ${TEST_TEMP_DIR}/exponential-paths.cpp.tmp/module.modulemap
    RUN(TestState.Failed, "echo 'module a10 { header \"a10.h\" export * }' >> %t/module.modulemap");
    // echo 'module b10 { header "b10.h" export * }' >> ${TEST_TEMP_DIR}/exponential-paths.cpp.tmp/module.modulemap
    RUN(TestState.Failed, "echo 'module b10 { header \"b10.h\" export * }' >> %t/module.modulemap");
    // echo 'module a11 { header "a11.h" export * }' >> ${TEST_TEMP_DIR}/exponential-paths.cpp.tmp/module.modulemap
    RUN(TestState.Failed, "echo 'module a11 { header \"a11.h\" export * }' >> %t/module.modulemap");
    // echo 'module b11 { header "b11.h" export * }' >> ${TEST_TEMP_DIR}/exponential-paths.cpp.tmp/module.modulemap
    RUN(TestState.Failed, "echo 'module b11 { header \"b11.h\" export * }' >> %t/module.modulemap");
    // echo 'module a12 { header "a12.h" export * }' >> ${TEST_TEMP_DIR}/exponential-paths.cpp.tmp/module.modulemap
    RUN(TestState.Failed, "echo 'module a12 { header \"a12.h\" export * }' >> %t/module.modulemap");
    // echo 'module b12 { header "b12.h" export * }' >> ${TEST_TEMP_DIR}/exponential-paths.cpp.tmp/module.modulemap
    RUN(TestState.Failed, "echo 'module b12 { header \"b12.h\" export * }' >> %t/module.modulemap");
    // echo 'module a13 { header "a13.h" export * }' >> ${TEST_TEMP_DIR}/exponential-paths.cpp.tmp/module.modulemap
    RUN(TestState.Failed, "echo 'module a13 { header \"a13.h\" export * }' >> %t/module.modulemap");
    // echo 'module b13 { header "b13.h" export * }' >> ${TEST_TEMP_DIR}/exponential-paths.cpp.tmp/module.modulemap
    RUN(TestState.Failed, "echo 'module b13 { header \"b13.h\" export * }' >> %t/module.modulemap");
    // echo 'module a14 { header "a14.h" export * }' >> ${TEST_TEMP_DIR}/exponential-paths.cpp.tmp/module.modulemap
    RUN(TestState.Failed, "echo 'module a14 { header \"a14.h\" export * }' >> %t/module.modulemap");
    // echo 'module b14 { header "b14.h" export * }' >> ${TEST_TEMP_DIR}/exponential-paths.cpp.tmp/module.modulemap
    RUN(TestState.Failed, "echo 'module b14 { header \"b14.h\" export * }' >> %t/module.modulemap");
    // echo 'module a15 { header "a15.h" export * }' >> ${TEST_TEMP_DIR}/exponential-paths.cpp.tmp/module.modulemap
    RUN(TestState.Failed, "echo 'module a15 { header \"a15.h\" export * }' >> %t/module.modulemap");
    // echo 'module b15 { header "b15.h" export * }' >> ${TEST_TEMP_DIR}/exponential-paths.cpp.tmp/module.modulemap
    RUN(TestState.Failed, "echo 'module b15 { header \"b15.h\" export * }' >> %t/module.modulemap");
    // echo 'module a16 { header "a16.h" export * }' >> ${TEST_TEMP_DIR}/exponential-paths.cpp.tmp/module.modulemap
    RUN(TestState.Failed, "echo 'module a16 { header \"a16.h\" export * }' >> %t/module.modulemap");
    // echo 'module b16 { header "b16.h" export * }' >> ${TEST_TEMP_DIR}/exponential-paths.cpp.tmp/module.modulemap
    RUN(TestState.Failed, "echo 'module b16 { header \"b16.h\" export * }' >> %t/module.modulemap");
    // echo 'module a17 { header "a17.h" export * }' >> ${TEST_TEMP_DIR}/exponential-paths.cpp.tmp/module.modulemap
    RUN(TestState.Failed, "echo 'module a17 { header \"a17.h\" export * }' >> %t/module.modulemap");
    // echo 'module b17 { header "b17.h" export * }' >> ${TEST_TEMP_DIR}/exponential-paths.cpp.tmp/module.modulemap
    RUN(TestState.Failed, "echo 'module b17 { header \"b17.h\" export * }' >> %t/module.modulemap");
    // echo 'module a18 { header "a18.h" export * }' >> ${TEST_TEMP_DIR}/exponential-paths.cpp.tmp/module.modulemap
    RUN(TestState.Failed, "echo 'module a18 { header \"a18.h\" export * }' >> %t/module.modulemap");
    // echo 'module b18 { header "b18.h" export * }' >> ${TEST_TEMP_DIR}/exponential-paths.cpp.tmp/module.modulemap
    RUN(TestState.Failed, "echo 'module b18 { header \"b18.h\" export * }' >> %t/module.modulemap");
    // echo 'module a19 { header "a19.h" export * }' >> ${TEST_TEMP_DIR}/exponential-paths.cpp.tmp/module.modulemap
    RUN(TestState.Failed, "echo 'module a19 { header \"a19.h\" export * }' >> %t/module.modulemap");
    // echo 'module b19 { header "b19.h" export * }' >> ${TEST_TEMP_DIR}/exponential-paths.cpp.tmp/module.modulemap
    RUN(TestState.Failed, "echo 'module b19 { header \"b19.h\" export * }' >> %t/module.modulemap");
    // echo 'module a20 { header "a20.h" export * }' >> ${TEST_TEMP_DIR}/exponential-paths.cpp.tmp/module.modulemap
    RUN(TestState.Failed, "echo 'module a20 { header \"a20.h\" export * }' >> %t/module.modulemap");
    // echo 'module b20 { header "b20.h" export * }' >> ${TEST_TEMP_DIR}/exponential-paths.cpp.tmp/module.modulemap
    RUN(TestState.Failed, "echo 'module b20 { header \"b20.h\" export * }' >> %t/module.modulemap");
    // echo 'template<int> struct X {}; extern X<0> x0;' > ${TEST_TEMP_DIR}/exponential-paths.cpp.tmp/x.h
    RUN(TestState.Failed, "echo 'template<int> struct X {}; extern X<0> x0;' > %t/x.h");
    // echo 'extern int n;' > ${TEST_TEMP_DIR}/exponential-paths.cpp.tmp/a0.h
    RUN(TestState.Failed, "echo 'extern int n;' > %t/a0.h");
    // cp ${TEST_TEMP_DIR}/exponential-paths.cpp.tmp/a0.h ${TEST_TEMP_DIR}/exponential-paths.cpp.tmp/b0.h
    RUN(TestState.Failed, "cp %t/a0.h %t/b0.h");
    // echo '#include "x.h"' > ${TEST_TEMP_DIR}/exponential-paths.cpp.tmp/a1.h
    RUN(TestState.Failed, "echo '#include \"x.h\"' > %t/a1.h");
    // echo '#include "a0.h"' >> ${TEST_TEMP_DIR}/exponential-paths.cpp.tmp/a1.h
    RUN(TestState.Failed, "echo '#include \"a0.h\"' >> %t/a1.h");
    // echo '#include "b0.h"' >> ${TEST_TEMP_DIR}/exponential-paths.cpp.tmp/a1.h
    RUN(TestState.Failed, "echo '#include \"b0.h\"' >> %t/a1.h");
    // cp ${TEST_TEMP_DIR}/exponential-paths.cpp.tmp/a1.h ${TEST_TEMP_DIR}/exponential-paths.cpp.tmp/b1.h
    RUN(TestState.Failed, "cp %t/a1.h %t/b1.h");
    // echo '#include "x.h"' > ${TEST_TEMP_DIR}/exponential-paths.cpp.tmp/a2.h
    RUN(TestState.Failed, "echo '#include \"x.h\"' > %t/a2.h");
    // echo '#include "a1.h"' >> ${TEST_TEMP_DIR}/exponential-paths.cpp.tmp/a2.h
    RUN(TestState.Failed, "echo '#include \"a1.h\"' >> %t/a2.h");
    // echo '#include "b1.h"' >> ${TEST_TEMP_DIR}/exponential-paths.cpp.tmp/a2.h
    RUN(TestState.Failed, "echo '#include \"b1.h\"' >> %t/a2.h");
    // cp ${TEST_TEMP_DIR}/exponential-paths.cpp.tmp/a2.h ${TEST_TEMP_DIR}/exponential-paths.cpp.tmp/b2.h
    RUN(TestState.Failed, "cp %t/a2.h %t/b2.h");
    // echo '#include "x.h"' > ${TEST_TEMP_DIR}/exponential-paths.cpp.tmp/a3.h
    RUN(TestState.Failed, "echo '#include \"x.h\"' > %t/a3.h");
    // echo '#include "a2.h"' >> ${TEST_TEMP_DIR}/exponential-paths.cpp.tmp/a3.h
    RUN(TestState.Failed, "echo '#include \"a2.h\"' >> %t/a3.h");
    // echo '#include "b2.h"' >> ${TEST_TEMP_DIR}/exponential-paths.cpp.tmp/a3.h
    RUN(TestState.Failed, "echo '#include \"b2.h\"' >> %t/a3.h");
    // cp ${TEST_TEMP_DIR}/exponential-paths.cpp.tmp/a3.h ${TEST_TEMP_DIR}/exponential-paths.cpp.tmp/b3.h
    RUN(TestState.Failed, "cp %t/a3.h %t/b3.h");
    // echo '#include "x.h"' > ${TEST_TEMP_DIR}/exponential-paths.cpp.tmp/a4.h
    RUN(TestState.Failed, "echo '#include \"x.h\"' > %t/a4.h");
    // echo '#include "a3.h"' >> ${TEST_TEMP_DIR}/exponential-paths.cpp.tmp/a4.h
    RUN(TestState.Failed, "echo '#include \"a3.h\"' >> %t/a4.h");
    // echo '#include "b3.h"' >> ${TEST_TEMP_DIR}/exponential-paths.cpp.tmp/a4.h
    RUN(TestState.Failed, "echo '#include \"b3.h\"' >> %t/a4.h");
    // cp ${TEST_TEMP_DIR}/exponential-paths.cpp.tmp/a4.h ${TEST_TEMP_DIR}/exponential-paths.cpp.tmp/b4.h
    RUN(TestState.Failed, "cp %t/a4.h %t/b4.h");
    // echo '#include "x.h"' > ${TEST_TEMP_DIR}/exponential-paths.cpp.tmp/a5.h
    RUN(TestState.Failed, "echo '#include \"x.h\"' > %t/a5.h");
    // echo '#include "a4.h"' >> ${TEST_TEMP_DIR}/exponential-paths.cpp.tmp/a5.h
    RUN(TestState.Failed, "echo '#include \"a4.h\"' >> %t/a5.h");
    // echo '#include "b4.h"' >> ${TEST_TEMP_DIR}/exponential-paths.cpp.tmp/a5.h
    RUN(TestState.Failed, "echo '#include \"b4.h\"' >> %t/a5.h");
    // cp ${TEST_TEMP_DIR}/exponential-paths.cpp.tmp/a5.h ${TEST_TEMP_DIR}/exponential-paths.cpp.tmp/b5.h
    RUN(TestState.Failed, "cp %t/a5.h %t/b5.h");
    // echo '#include "x.h"' > ${TEST_TEMP_DIR}/exponential-paths.cpp.tmp/a6.h
    RUN(TestState.Failed, "echo '#include \"x.h\"' > %t/a6.h");
    // echo '#include "a5.h"' >> ${TEST_TEMP_DIR}/exponential-paths.cpp.tmp/a6.h
    RUN(TestState.Failed, "echo '#include \"a5.h\"' >> %t/a6.h");
    // echo '#include "b5.h"' >> ${TEST_TEMP_DIR}/exponential-paths.cpp.tmp/a6.h
    RUN(TestState.Failed, "echo '#include \"b5.h\"' >> %t/a6.h");
    // cp ${TEST_TEMP_DIR}/exponential-paths.cpp.tmp/a6.h ${TEST_TEMP_DIR}/exponential-paths.cpp.tmp/b6.h
    RUN(TestState.Failed, "cp %t/a6.h %t/b6.h");
    // echo '#include "x.h"' > ${TEST_TEMP_DIR}/exponential-paths.cpp.tmp/a7.h
    RUN(TestState.Failed, "echo '#include \"x.h\"' > %t/a7.h");
    // echo '#include "a6.h"' >> ${TEST_TEMP_DIR}/exponential-paths.cpp.tmp/a7.h
    RUN(TestState.Failed, "echo '#include \"a6.h\"' >> %t/a7.h");
    // echo '#include "b6.h"' >> ${TEST_TEMP_DIR}/exponential-paths.cpp.tmp/a7.h
    RUN(TestState.Failed, "echo '#include \"b6.h\"' >> %t/a7.h");
    // cp ${TEST_TEMP_DIR}/exponential-paths.cpp.tmp/a7.h ${TEST_TEMP_DIR}/exponential-paths.cpp.tmp/b7.h
    RUN(TestState.Failed, "cp %t/a7.h %t/b7.h");
    // echo '#include "x.h"' > ${TEST_TEMP_DIR}/exponential-paths.cpp.tmp/a8.h
    RUN(TestState.Failed, "echo '#include \"x.h\"' > %t/a8.h");
    // echo '#include "a7.h"' >> ${TEST_TEMP_DIR}/exponential-paths.cpp.tmp/a8.h
    RUN(TestState.Failed, "echo '#include \"a7.h\"' >> %t/a8.h");
    // echo '#include "b7.h"' >> ${TEST_TEMP_DIR}/exponential-paths.cpp.tmp/a8.h
    RUN(TestState.Failed, "echo '#include \"b7.h\"' >> %t/a8.h");
    // cp ${TEST_TEMP_DIR}/exponential-paths.cpp.tmp/a8.h ${TEST_TEMP_DIR}/exponential-paths.cpp.tmp/b8.h
    RUN(TestState.Failed, "cp %t/a8.h %t/b8.h");
    // echo '#include "x.h"' > ${TEST_TEMP_DIR}/exponential-paths.cpp.tmp/a9.h
    RUN(TestState.Failed, "echo '#include \"x.h\"' > %t/a9.h");
    // echo '#include "a8.h"' >> ${TEST_TEMP_DIR}/exponential-paths.cpp.tmp/a9.h
    RUN(TestState.Failed, "echo '#include \"a8.h\"' >> %t/a9.h");
    // echo '#include "b8.h"' >> ${TEST_TEMP_DIR}/exponential-paths.cpp.tmp/a9.h
    RUN(TestState.Failed, "echo '#include \"b8.h\"' >> %t/a9.h");
    // cp ${TEST_TEMP_DIR}/exponential-paths.cpp.tmp/a9.h ${TEST_TEMP_DIR}/exponential-paths.cpp.tmp/b9.h
    RUN(TestState.Failed, "cp %t/a9.h %t/b9.h");
    // echo '#include "x.h"' > ${TEST_TEMP_DIR}/exponential-paths.cpp.tmp/a10.h
    RUN(TestState.Failed, "echo '#include \"x.h\"' > %t/a10.h");
    // echo '#include "a9.h"' >> ${TEST_TEMP_DIR}/exponential-paths.cpp.tmp/a10.h
    RUN(TestState.Failed, "echo '#include \"a9.h\"' >> %t/a10.h");
    // echo '#include "b9.h"' >> ${TEST_TEMP_DIR}/exponential-paths.cpp.tmp/a10.h
    RUN(TestState.Failed, "echo '#include \"b9.h\"' >> %t/a10.h");
    // cp ${TEST_TEMP_DIR}/exponential-paths.cpp.tmp/a10.h ${TEST_TEMP_DIR}/exponential-paths.cpp.tmp/b10.h
    RUN(TestState.Failed, "cp %t/a10.h %t/b10.h");
    // echo '#include "x.h"' > ${TEST_TEMP_DIR}/exponential-paths.cpp.tmp/a11.h
    RUN(TestState.Failed, "echo '#include \"x.h\"' > %t/a11.h");
    // echo '#include "a10.h"' >> ${TEST_TEMP_DIR}/exponential-paths.cpp.tmp/a11.h
    RUN(TestState.Failed, "echo '#include \"a10.h\"' >> %t/a11.h");
    // echo '#include "b10.h"' >> ${TEST_TEMP_DIR}/exponential-paths.cpp.tmp/a11.h
    RUN(TestState.Failed, "echo '#include \"b10.h\"' >> %t/a11.h");
    // cp ${TEST_TEMP_DIR}/exponential-paths.cpp.tmp/a11.h ${TEST_TEMP_DIR}/exponential-paths.cpp.tmp/b11.h
    RUN(TestState.Failed, "cp %t/a11.h %t/b11.h");
    // echo '#include "x.h"' > ${TEST_TEMP_DIR}/exponential-paths.cpp.tmp/a12.h
    RUN(TestState.Failed, "echo '#include \"x.h\"' > %t/a12.h");
    // echo '#include "a11.h"' >> ${TEST_TEMP_DIR}/exponential-paths.cpp.tmp/a12.h
    RUN(TestState.Failed, "echo '#include \"a11.h\"' >> %t/a12.h");
    // echo '#include "b11.h"' >> ${TEST_TEMP_DIR}/exponential-paths.cpp.tmp/a12.h
    RUN(TestState.Failed, "echo '#include \"b11.h\"' >> %t/a12.h");
    // cp ${TEST_TEMP_DIR}/exponential-paths.cpp.tmp/a12.h ${TEST_TEMP_DIR}/exponential-paths.cpp.tmp/b12.h
    RUN(TestState.Failed, "cp %t/a12.h %t/b12.h");
    // echo '#include "x.h"' > ${TEST_TEMP_DIR}/exponential-paths.cpp.tmp/a13.h
    RUN(TestState.Failed, "echo '#include \"x.h\"' > %t/a13.h");
    // echo '#include "a12.h"' >> ${TEST_TEMP_DIR}/exponential-paths.cpp.tmp/a13.h
    RUN(TestState.Failed, "echo '#include \"a12.h\"' >> %t/a13.h");
    // echo '#include "b12.h"' >> ${TEST_TEMP_DIR}/exponential-paths.cpp.tmp/a13.h
    RUN(TestState.Failed, "echo '#include \"b12.h\"' >> %t/a13.h");
    // cp ${TEST_TEMP_DIR}/exponential-paths.cpp.tmp/a13.h ${TEST_TEMP_DIR}/exponential-paths.cpp.tmp/b13.h
    RUN(TestState.Failed, "cp %t/a13.h %t/b13.h");
    // echo '#include "x.h"' > ${TEST_TEMP_DIR}/exponential-paths.cpp.tmp/a14.h
    RUN(TestState.Failed, "echo '#include \"x.h\"' > %t/a14.h");
    // echo '#include "a13.h"' >> ${TEST_TEMP_DIR}/exponential-paths.cpp.tmp/a14.h
    RUN(TestState.Failed, "echo '#include \"a13.h\"' >> %t/a14.h");
    // echo '#include "b13.h"' >> ${TEST_TEMP_DIR}/exponential-paths.cpp.tmp/a14.h
    RUN(TestState.Failed, "echo '#include \"b13.h\"' >> %t/a14.h");
    // cp ${TEST_TEMP_DIR}/exponential-paths.cpp.tmp/a14.h ${TEST_TEMP_DIR}/exponential-paths.cpp.tmp/b14.h
    RUN(TestState.Failed, "cp %t/a14.h %t/b14.h");
    // echo '#include "x.h"' > ${TEST_TEMP_DIR}/exponential-paths.cpp.tmp/a15.h
    RUN(TestState.Failed, "echo '#include \"x.h\"' > %t/a15.h");
    // echo '#include "a14.h"' >> ${TEST_TEMP_DIR}/exponential-paths.cpp.tmp/a15.h
    RUN(TestState.Failed, "echo '#include \"a14.h\"' >> %t/a15.h");
    // echo '#include "b14.h"' >> ${TEST_TEMP_DIR}/exponential-paths.cpp.tmp/a15.h
    RUN(TestState.Failed, "echo '#include \"b14.h\"' >> %t/a15.h");
    // cp ${TEST_TEMP_DIR}/exponential-paths.cpp.tmp/a15.h ${TEST_TEMP_DIR}/exponential-paths.cpp.tmp/b15.h
    RUN(TestState.Failed, "cp %t/a15.h %t/b15.h");
    // echo '#include "x.h"' > ${TEST_TEMP_DIR}/exponential-paths.cpp.tmp/a16.h
    RUN(TestState.Failed, "echo '#include \"x.h\"' > %t/a16.h");
    // echo '#include "a15.h"' >> ${TEST_TEMP_DIR}/exponential-paths.cpp.tmp/a16.h
    RUN(TestState.Failed, "echo '#include \"a15.h\"' >> %t/a16.h");
    // echo '#include "b15.h"' >> ${TEST_TEMP_DIR}/exponential-paths.cpp.tmp/a16.h
    RUN(TestState.Failed, "echo '#include \"b15.h\"' >> %t/a16.h");
    // cp ${TEST_TEMP_DIR}/exponential-paths.cpp.tmp/a16.h ${TEST_TEMP_DIR}/exponential-paths.cpp.tmp/b16.h
    RUN(TestState.Failed, "cp %t/a16.h %t/b16.h");
    // echo '#include "x.h"' > ${TEST_TEMP_DIR}/exponential-paths.cpp.tmp/a17.h
    RUN(TestState.Failed, "echo '#include \"x.h\"' > %t/a17.h");
    // echo '#include "a16.h"' >> ${TEST_TEMP_DIR}/exponential-paths.cpp.tmp/a17.h
    RUN(TestState.Failed, "echo '#include \"a16.h\"' >> %t/a17.h");
    // echo '#include "b16.h"' >> ${TEST_TEMP_DIR}/exponential-paths.cpp.tmp/a17.h
    RUN(TestState.Failed, "echo '#include \"b16.h\"' >> %t/a17.h");
    // cp ${TEST_TEMP_DIR}/exponential-paths.cpp.tmp/a17.h ${TEST_TEMP_DIR}/exponential-paths.cpp.tmp/b17.h
    RUN(TestState.Failed, "cp %t/a17.h %t/b17.h");
    // echo '#include "x.h"' > ${TEST_TEMP_DIR}/exponential-paths.cpp.tmp/a18.h
    RUN(TestState.Failed, "echo '#include \"x.h\"' > %t/a18.h");
    // echo '#include "a17.h"' >> ${TEST_TEMP_DIR}/exponential-paths.cpp.tmp/a18.h
    RUN(TestState.Failed, "echo '#include \"a17.h\"' >> %t/a18.h");
    // echo '#include "b17.h"' >> ${TEST_TEMP_DIR}/exponential-paths.cpp.tmp/a18.h
    RUN(TestState.Failed, "echo '#include \"b17.h\"' >> %t/a18.h");
    // cp ${TEST_TEMP_DIR}/exponential-paths.cpp.tmp/a18.h ${TEST_TEMP_DIR}/exponential-paths.cpp.tmp/b18.h
    RUN(TestState.Failed, "cp %t/a18.h %t/b18.h");
    // echo '#include "x.h"' > ${TEST_TEMP_DIR}/exponential-paths.cpp.tmp/a19.h
    RUN(TestState.Failed, "echo '#include \"x.h\"' > %t/a19.h");
    // echo '#include "a18.h"' >> ${TEST_TEMP_DIR}/exponential-paths.cpp.tmp/a19.h
    RUN(TestState.Failed, "echo '#include \"a18.h\"' >> %t/a19.h");
    // echo '#include "b18.h"' >> ${TEST_TEMP_DIR}/exponential-paths.cpp.tmp/a19.h
    RUN(TestState.Failed, "echo '#include \"b18.h\"' >> %t/a19.h");
    // cp ${TEST_TEMP_DIR}/exponential-paths.cpp.tmp/a19.h ${TEST_TEMP_DIR}/exponential-paths.cpp.tmp/b19.h
    RUN(TestState.Failed, "cp %t/a19.h %t/b19.h");
    // echo '#include "x.h"' > ${TEST_TEMP_DIR}/exponential-paths.cpp.tmp/a20.h
    RUN(TestState.Failed, "echo '#include \"x.h\"' > %t/a20.h");
    // echo '#include "a19.h"' >> ${TEST_TEMP_DIR}/exponential-paths.cpp.tmp/a20.h
    RUN(TestState.Failed, "echo '#include \"a19.h\"' >> %t/a20.h");
    // echo '#include "b19.h"' >> ${TEST_TEMP_DIR}/exponential-paths.cpp.tmp/a20.h
    RUN(TestState.Failed, "echo '#include \"b19.h\"' >> %t/a20.h");
    // cp ${TEST_TEMP_DIR}/exponential-paths.cpp.tmp/a20.h ${TEST_TEMP_DIR}/exponential-paths.cpp.tmp/b20.h
    RUN(TestState.Failed, "cp %t/a20.h %t/b20.h");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fmodules -fimplicit-module-maps '-fmodules-cache-path=${TEST_TEMP_DIR}/exponential-paths.cpp.tmp' '-I${TEST_TEMP_DIR}/exponential-paths.cpp.tmp' -fmodule-name=a0 -x c++ -emit-module ${TEST_TEMP_DIR}/exponential-paths.cpp.tmp/module.modulemap -o ${TEST_TEMP_DIR}/exponential-paths.cpp.tmp/a0.pcm
    RUN(TestState.Failed, "%clang_cc1 -fmodules -fimplicit-module-maps -fmodules-cache-path=%t -I%t -fmodule-name=a0 -x c++ -emit-module %t/module.modulemap -o %t/a0.pcm");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fmodules -fimplicit-module-maps '-fmodules-cache-path=${TEST_TEMP_DIR}/exponential-paths.cpp.tmp' '-I${TEST_TEMP_DIR}/exponential-paths.cpp.tmp' -fmodule-name=b0 -x c++ -emit-module ${TEST_TEMP_DIR}/exponential-paths.cpp.tmp/module.modulemap -o ${TEST_TEMP_DIR}/exponential-paths.cpp.tmp/b0.pcm
    RUN(TestState.Failed, "%clang_cc1 -fmodules -fimplicit-module-maps -fmodules-cache-path=%t -I%t -fmodule-name=b0 -x c++ -emit-module %t/module.modulemap -o %t/b0.pcm");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fmodules -fimplicit-module-maps '-fmodules-cache-path=${TEST_TEMP_DIR}/exponential-paths.cpp.tmp' '-I${TEST_TEMP_DIR}/exponential-paths.cpp.tmp' -fmodule-name=a1 -x c++ -emit-module ${TEST_TEMP_DIR}/exponential-paths.cpp.tmp/module.modulemap -o ${TEST_TEMP_DIR}/exponential-paths.cpp.tmp/a1.pcm '-fmodule-file=${TEST_TEMP_DIR}/exponential-paths.cpp.tmp/a0.pcm' '-fmodule-file=${TEST_TEMP_DIR}/exponential-paths.cpp.tmp/b0.pcm'
    RUN(TestState.Failed, "%clang_cc1 -fmodules -fimplicit-module-maps -fmodules-cache-path=%t -I%t -fmodule-name=a1 -x c++ -emit-module %t/module.modulemap -o %t/a1.pcm -fmodule-file=%t/a0.pcm -fmodule-file=%t/b0.pcm");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fmodules -fimplicit-module-maps '-fmodules-cache-path=${TEST_TEMP_DIR}/exponential-paths.cpp.tmp' '-I${TEST_TEMP_DIR}/exponential-paths.cpp.tmp' -fmodule-name=b1 -x c++ -emit-module ${TEST_TEMP_DIR}/exponential-paths.cpp.tmp/module.modulemap -o ${TEST_TEMP_DIR}/exponential-paths.cpp.tmp/b1.pcm '-fmodule-file=${TEST_TEMP_DIR}/exponential-paths.cpp.tmp/a0.pcm' '-fmodule-file=${TEST_TEMP_DIR}/exponential-paths.cpp.tmp/b0.pcm'
    RUN(TestState.Failed, "%clang_cc1 -fmodules -fimplicit-module-maps -fmodules-cache-path=%t -I%t -fmodule-name=b1 -x c++ -emit-module %t/module.modulemap -o %t/b1.pcm -fmodule-file=%t/a0.pcm -fmodule-file=%t/b0.pcm");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fmodules -fimplicit-module-maps '-fmodules-cache-path=${TEST_TEMP_DIR}/exponential-paths.cpp.tmp' '-I${TEST_TEMP_DIR}/exponential-paths.cpp.tmp' -fmodule-name=a2 -x c++ -emit-module ${TEST_TEMP_DIR}/exponential-paths.cpp.tmp/module.modulemap -o ${TEST_TEMP_DIR}/exponential-paths.cpp.tmp/a2.pcm '-fmodule-file=${TEST_TEMP_DIR}/exponential-paths.cpp.tmp/a1.pcm' '-fmodule-file=${TEST_TEMP_DIR}/exponential-paths.cpp.tmp/b1.pcm'
    RUN(TestState.Failed, "%clang_cc1 -fmodules -fimplicit-module-maps -fmodules-cache-path=%t -I%t -fmodule-name=a2 -x c++ -emit-module %t/module.modulemap -o %t/a2.pcm -fmodule-file=%t/a1.pcm -fmodule-file=%t/b1.pcm");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fmodules -fimplicit-module-maps '-fmodules-cache-path=${TEST_TEMP_DIR}/exponential-paths.cpp.tmp' '-I${TEST_TEMP_DIR}/exponential-paths.cpp.tmp' -fmodule-name=b2 -x c++ -emit-module ${TEST_TEMP_DIR}/exponential-paths.cpp.tmp/module.modulemap -o ${TEST_TEMP_DIR}/exponential-paths.cpp.tmp/b2.pcm '-fmodule-file=${TEST_TEMP_DIR}/exponential-paths.cpp.tmp/a1.pcm' '-fmodule-file=${TEST_TEMP_DIR}/exponential-paths.cpp.tmp/b1.pcm'
    RUN(TestState.Failed, "%clang_cc1 -fmodules -fimplicit-module-maps -fmodules-cache-path=%t -I%t -fmodule-name=b2 -x c++ -emit-module %t/module.modulemap -o %t/b2.pcm -fmodule-file=%t/a1.pcm -fmodule-file=%t/b1.pcm");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fmodules -fimplicit-module-maps '-fmodules-cache-path=${TEST_TEMP_DIR}/exponential-paths.cpp.tmp' '-I${TEST_TEMP_DIR}/exponential-paths.cpp.tmp' -fmodule-name=a3 -x c++ -emit-module ${TEST_TEMP_DIR}/exponential-paths.cpp.tmp/module.modulemap -o ${TEST_TEMP_DIR}/exponential-paths.cpp.tmp/a3.pcm '-fmodule-file=${TEST_TEMP_DIR}/exponential-paths.cpp.tmp/a2.pcm' '-fmodule-file=${TEST_TEMP_DIR}/exponential-paths.cpp.tmp/b2.pcm'
    RUN(TestState.Failed, "%clang_cc1 -fmodules -fimplicit-module-maps -fmodules-cache-path=%t -I%t -fmodule-name=a3 -x c++ -emit-module %t/module.modulemap -o %t/a3.pcm -fmodule-file=%t/a2.pcm -fmodule-file=%t/b2.pcm");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fmodules -fimplicit-module-maps '-fmodules-cache-path=${TEST_TEMP_DIR}/exponential-paths.cpp.tmp' '-I${TEST_TEMP_DIR}/exponential-paths.cpp.tmp' -fmodule-name=b3 -x c++ -emit-module ${TEST_TEMP_DIR}/exponential-paths.cpp.tmp/module.modulemap -o ${TEST_TEMP_DIR}/exponential-paths.cpp.tmp/b3.pcm '-fmodule-file=${TEST_TEMP_DIR}/exponential-paths.cpp.tmp/a2.pcm' '-fmodule-file=${TEST_TEMP_DIR}/exponential-paths.cpp.tmp/b2.pcm'
    RUN(TestState.Failed, "%clang_cc1 -fmodules -fimplicit-module-maps -fmodules-cache-path=%t -I%t -fmodule-name=b3 -x c++ -emit-module %t/module.modulemap -o %t/b3.pcm -fmodule-file=%t/a2.pcm -fmodule-file=%t/b2.pcm");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fmodules -fimplicit-module-maps '-fmodules-cache-path=${TEST_TEMP_DIR}/exponential-paths.cpp.tmp' '-I${TEST_TEMP_DIR}/exponential-paths.cpp.tmp' -fmodule-name=a4 -x c++ -emit-module ${TEST_TEMP_DIR}/exponential-paths.cpp.tmp/module.modulemap -o ${TEST_TEMP_DIR}/exponential-paths.cpp.tmp/a4.pcm '-fmodule-file=${TEST_TEMP_DIR}/exponential-paths.cpp.tmp/a3.pcm' '-fmodule-file=${TEST_TEMP_DIR}/exponential-paths.cpp.tmp/b3.pcm'
    RUN(TestState.Failed, "%clang_cc1 -fmodules -fimplicit-module-maps -fmodules-cache-path=%t -I%t -fmodule-name=a4 -x c++ -emit-module %t/module.modulemap -o %t/a4.pcm -fmodule-file=%t/a3.pcm -fmodule-file=%t/b3.pcm");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fmodules -fimplicit-module-maps '-fmodules-cache-path=${TEST_TEMP_DIR}/exponential-paths.cpp.tmp' '-I${TEST_TEMP_DIR}/exponential-paths.cpp.tmp' -fmodule-name=b4 -x c++ -emit-module ${TEST_TEMP_DIR}/exponential-paths.cpp.tmp/module.modulemap -o ${TEST_TEMP_DIR}/exponential-paths.cpp.tmp/b4.pcm '-fmodule-file=${TEST_TEMP_DIR}/exponential-paths.cpp.tmp/a3.pcm' '-fmodule-file=${TEST_TEMP_DIR}/exponential-paths.cpp.tmp/b3.pcm'
    RUN(TestState.Failed, "%clang_cc1 -fmodules -fimplicit-module-maps -fmodules-cache-path=%t -I%t -fmodule-name=b4 -x c++ -emit-module %t/module.modulemap -o %t/b4.pcm -fmodule-file=%t/a3.pcm -fmodule-file=%t/b3.pcm");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fmodules -fimplicit-module-maps '-fmodules-cache-path=${TEST_TEMP_DIR}/exponential-paths.cpp.tmp' '-I${TEST_TEMP_DIR}/exponential-paths.cpp.tmp' -fmodule-name=a5 -x c++ -emit-module ${TEST_TEMP_DIR}/exponential-paths.cpp.tmp/module.modulemap -o ${TEST_TEMP_DIR}/exponential-paths.cpp.tmp/a5.pcm '-fmodule-file=${TEST_TEMP_DIR}/exponential-paths.cpp.tmp/a4.pcm' '-fmodule-file=${TEST_TEMP_DIR}/exponential-paths.cpp.tmp/b4.pcm'
    RUN(TestState.Failed, "%clang_cc1 -fmodules -fimplicit-module-maps -fmodules-cache-path=%t -I%t -fmodule-name=a5 -x c++ -emit-module %t/module.modulemap -o %t/a5.pcm -fmodule-file=%t/a4.pcm -fmodule-file=%t/b4.pcm");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fmodules -fimplicit-module-maps '-fmodules-cache-path=${TEST_TEMP_DIR}/exponential-paths.cpp.tmp' '-I${TEST_TEMP_DIR}/exponential-paths.cpp.tmp' -fmodule-name=b5 -x c++ -emit-module ${TEST_TEMP_DIR}/exponential-paths.cpp.tmp/module.modulemap -o ${TEST_TEMP_DIR}/exponential-paths.cpp.tmp/b5.pcm '-fmodule-file=${TEST_TEMP_DIR}/exponential-paths.cpp.tmp/a4.pcm' '-fmodule-file=${TEST_TEMP_DIR}/exponential-paths.cpp.tmp/b4.pcm'
    RUN(TestState.Failed, "%clang_cc1 -fmodules -fimplicit-module-maps -fmodules-cache-path=%t -I%t -fmodule-name=b5 -x c++ -emit-module %t/module.modulemap -o %t/b5.pcm -fmodule-file=%t/a4.pcm -fmodule-file=%t/b4.pcm");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fmodules -fimplicit-module-maps '-fmodules-cache-path=${TEST_TEMP_DIR}/exponential-paths.cpp.tmp' '-I${TEST_TEMP_DIR}/exponential-paths.cpp.tmp' -fmodule-name=a6 -x c++ -emit-module ${TEST_TEMP_DIR}/exponential-paths.cpp.tmp/module.modulemap -o ${TEST_TEMP_DIR}/exponential-paths.cpp.tmp/a6.pcm '-fmodule-file=${TEST_TEMP_DIR}/exponential-paths.cpp.tmp/a5.pcm' '-fmodule-file=${TEST_TEMP_DIR}/exponential-paths.cpp.tmp/b5.pcm'
    RUN(TestState.Failed, "%clang_cc1 -fmodules -fimplicit-module-maps -fmodules-cache-path=%t -I%t -fmodule-name=a6 -x c++ -emit-module %t/module.modulemap -o %t/a6.pcm -fmodule-file=%t/a5.pcm -fmodule-file=%t/b5.pcm");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fmodules -fimplicit-module-maps '-fmodules-cache-path=${TEST_TEMP_DIR}/exponential-paths.cpp.tmp' '-I${TEST_TEMP_DIR}/exponential-paths.cpp.tmp' -fmodule-name=b6 -x c++ -emit-module ${TEST_TEMP_DIR}/exponential-paths.cpp.tmp/module.modulemap -o ${TEST_TEMP_DIR}/exponential-paths.cpp.tmp/b6.pcm '-fmodule-file=${TEST_TEMP_DIR}/exponential-paths.cpp.tmp/a5.pcm' '-fmodule-file=${TEST_TEMP_DIR}/exponential-paths.cpp.tmp/b5.pcm'
    RUN(TestState.Failed, "%clang_cc1 -fmodules -fimplicit-module-maps -fmodules-cache-path=%t -I%t -fmodule-name=b6 -x c++ -emit-module %t/module.modulemap -o %t/b6.pcm -fmodule-file=%t/a5.pcm -fmodule-file=%t/b5.pcm");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fmodules -fimplicit-module-maps '-fmodules-cache-path=${TEST_TEMP_DIR}/exponential-paths.cpp.tmp' '-I${TEST_TEMP_DIR}/exponential-paths.cpp.tmp' -fmodule-name=a7 -x c++ -emit-module ${TEST_TEMP_DIR}/exponential-paths.cpp.tmp/module.modulemap -o ${TEST_TEMP_DIR}/exponential-paths.cpp.tmp/a7.pcm '-fmodule-file=${TEST_TEMP_DIR}/exponential-paths.cpp.tmp/a6.pcm' '-fmodule-file=${TEST_TEMP_DIR}/exponential-paths.cpp.tmp/b6.pcm'
    RUN(TestState.Failed, "%clang_cc1 -fmodules -fimplicit-module-maps -fmodules-cache-path=%t -I%t -fmodule-name=a7 -x c++ -emit-module %t/module.modulemap -o %t/a7.pcm -fmodule-file=%t/a6.pcm -fmodule-file=%t/b6.pcm");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fmodules -fimplicit-module-maps '-fmodules-cache-path=${TEST_TEMP_DIR}/exponential-paths.cpp.tmp' '-I${TEST_TEMP_DIR}/exponential-paths.cpp.tmp' -fmodule-name=b7 -x c++ -emit-module ${TEST_TEMP_DIR}/exponential-paths.cpp.tmp/module.modulemap -o ${TEST_TEMP_DIR}/exponential-paths.cpp.tmp/b7.pcm '-fmodule-file=${TEST_TEMP_DIR}/exponential-paths.cpp.tmp/a6.pcm' '-fmodule-file=${TEST_TEMP_DIR}/exponential-paths.cpp.tmp/b6.pcm'
    RUN(TestState.Failed, "%clang_cc1 -fmodules -fimplicit-module-maps -fmodules-cache-path=%t -I%t -fmodule-name=b7 -x c++ -emit-module %t/module.modulemap -o %t/b7.pcm -fmodule-file=%t/a6.pcm -fmodule-file=%t/b6.pcm");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fmodules -fimplicit-module-maps '-fmodules-cache-path=${TEST_TEMP_DIR}/exponential-paths.cpp.tmp' '-I${TEST_TEMP_DIR}/exponential-paths.cpp.tmp' -fmodule-name=a8 -x c++ -emit-module ${TEST_TEMP_DIR}/exponential-paths.cpp.tmp/module.modulemap -o ${TEST_TEMP_DIR}/exponential-paths.cpp.tmp/a8.pcm '-fmodule-file=${TEST_TEMP_DIR}/exponential-paths.cpp.tmp/a7.pcm' '-fmodule-file=${TEST_TEMP_DIR}/exponential-paths.cpp.tmp/b7.pcm'
    RUN(TestState.Failed, "%clang_cc1 -fmodules -fimplicit-module-maps -fmodules-cache-path=%t -I%t -fmodule-name=a8 -x c++ -emit-module %t/module.modulemap -o %t/a8.pcm -fmodule-file=%t/a7.pcm -fmodule-file=%t/b7.pcm");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fmodules -fimplicit-module-maps '-fmodules-cache-path=${TEST_TEMP_DIR}/exponential-paths.cpp.tmp' '-I${TEST_TEMP_DIR}/exponential-paths.cpp.tmp' -fmodule-name=b8 -x c++ -emit-module ${TEST_TEMP_DIR}/exponential-paths.cpp.tmp/module.modulemap -o ${TEST_TEMP_DIR}/exponential-paths.cpp.tmp/b8.pcm '-fmodule-file=${TEST_TEMP_DIR}/exponential-paths.cpp.tmp/a7.pcm' '-fmodule-file=${TEST_TEMP_DIR}/exponential-paths.cpp.tmp/b7.pcm'
    RUN(TestState.Failed, "%clang_cc1 -fmodules -fimplicit-module-maps -fmodules-cache-path=%t -I%t -fmodule-name=b8 -x c++ -emit-module %t/module.modulemap -o %t/b8.pcm -fmodule-file=%t/a7.pcm -fmodule-file=%t/b7.pcm");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fmodules -fimplicit-module-maps '-fmodules-cache-path=${TEST_TEMP_DIR}/exponential-paths.cpp.tmp' '-I${TEST_TEMP_DIR}/exponential-paths.cpp.tmp' -fmodule-name=a9 -x c++ -emit-module ${TEST_TEMP_DIR}/exponential-paths.cpp.tmp/module.modulemap -o ${TEST_TEMP_DIR}/exponential-paths.cpp.tmp/a9.pcm '-fmodule-file=${TEST_TEMP_DIR}/exponential-paths.cpp.tmp/a8.pcm' '-fmodule-file=${TEST_TEMP_DIR}/exponential-paths.cpp.tmp/b8.pcm'
    RUN(TestState.Failed, "%clang_cc1 -fmodules -fimplicit-module-maps -fmodules-cache-path=%t -I%t -fmodule-name=a9 -x c++ -emit-module %t/module.modulemap -o %t/a9.pcm -fmodule-file=%t/a8.pcm -fmodule-file=%t/b8.pcm");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fmodules -fimplicit-module-maps '-fmodules-cache-path=${TEST_TEMP_DIR}/exponential-paths.cpp.tmp' '-I${TEST_TEMP_DIR}/exponential-paths.cpp.tmp' -fmodule-name=b9 -x c++ -emit-module ${TEST_TEMP_DIR}/exponential-paths.cpp.tmp/module.modulemap -o ${TEST_TEMP_DIR}/exponential-paths.cpp.tmp/b9.pcm '-fmodule-file=${TEST_TEMP_DIR}/exponential-paths.cpp.tmp/a8.pcm' '-fmodule-file=${TEST_TEMP_DIR}/exponential-paths.cpp.tmp/b8.pcm'
    RUN(TestState.Failed, "%clang_cc1 -fmodules -fimplicit-module-maps -fmodules-cache-path=%t -I%t -fmodule-name=b9 -x c++ -emit-module %t/module.modulemap -o %t/b9.pcm -fmodule-file=%t/a8.pcm -fmodule-file=%t/b8.pcm");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fmodules -fimplicit-module-maps '-fmodules-cache-path=${TEST_TEMP_DIR}/exponential-paths.cpp.tmp' '-I${TEST_TEMP_DIR}/exponential-paths.cpp.tmp' -fmodule-name=a10 -x c++ -emit-module ${TEST_TEMP_DIR}/exponential-paths.cpp.tmp/module.modulemap -o ${TEST_TEMP_DIR}/exponential-paths.cpp.tmp/a10.pcm '-fmodule-file=${TEST_TEMP_DIR}/exponential-paths.cpp.tmp/a9.pcm' '-fmodule-file=${TEST_TEMP_DIR}/exponential-paths.cpp.tmp/b9.pcm'
    RUN(TestState.Failed, "%clang_cc1 -fmodules -fimplicit-module-maps -fmodules-cache-path=%t -I%t -fmodule-name=a10 -x c++ -emit-module %t/module.modulemap -o %t/a10.pcm -fmodule-file=%t/a9.pcm -fmodule-file=%t/b9.pcm");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fmodules -fimplicit-module-maps '-fmodules-cache-path=${TEST_TEMP_DIR}/exponential-paths.cpp.tmp' '-I${TEST_TEMP_DIR}/exponential-paths.cpp.tmp' -fmodule-name=b10 -x c++ -emit-module ${TEST_TEMP_DIR}/exponential-paths.cpp.tmp/module.modulemap -o ${TEST_TEMP_DIR}/exponential-paths.cpp.tmp/b10.pcm '-fmodule-file=${TEST_TEMP_DIR}/exponential-paths.cpp.tmp/a9.pcm' '-fmodule-file=${TEST_TEMP_DIR}/exponential-paths.cpp.tmp/b9.pcm'
    RUN(TestState.Failed, "%clang_cc1 -fmodules -fimplicit-module-maps -fmodules-cache-path=%t -I%t -fmodule-name=b10 -x c++ -emit-module %t/module.modulemap -o %t/b10.pcm -fmodule-file=%t/a9.pcm -fmodule-file=%t/b9.pcm");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fmodules -fimplicit-module-maps '-fmodules-cache-path=${TEST_TEMP_DIR}/exponential-paths.cpp.tmp' '-I${TEST_TEMP_DIR}/exponential-paths.cpp.tmp' -fmodule-name=a11 -x c++ -emit-module ${TEST_TEMP_DIR}/exponential-paths.cpp.tmp/module.modulemap -o ${TEST_TEMP_DIR}/exponential-paths.cpp.tmp/a11.pcm '-fmodule-file=${TEST_TEMP_DIR}/exponential-paths.cpp.tmp/a10.pcm' '-fmodule-file=${TEST_TEMP_DIR}/exponential-paths.cpp.tmp/b10.pcm'
    RUN(TestState.Failed, "%clang_cc1 -fmodules -fimplicit-module-maps -fmodules-cache-path=%t -I%t -fmodule-name=a11 -x c++ -emit-module %t/module.modulemap -o %t/a11.pcm -fmodule-file=%t/a10.pcm -fmodule-file=%t/b10.pcm");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fmodules -fimplicit-module-maps '-fmodules-cache-path=${TEST_TEMP_DIR}/exponential-paths.cpp.tmp' '-I${TEST_TEMP_DIR}/exponential-paths.cpp.tmp' -fmodule-name=b11 -x c++ -emit-module ${TEST_TEMP_DIR}/exponential-paths.cpp.tmp/module.modulemap -o ${TEST_TEMP_DIR}/exponential-paths.cpp.tmp/b11.pcm '-fmodule-file=${TEST_TEMP_DIR}/exponential-paths.cpp.tmp/a10.pcm' '-fmodule-file=${TEST_TEMP_DIR}/exponential-paths.cpp.tmp/b10.pcm'
    RUN(TestState.Failed, "%clang_cc1 -fmodules -fimplicit-module-maps -fmodules-cache-path=%t -I%t -fmodule-name=b11 -x c++ -emit-module %t/module.modulemap -o %t/b11.pcm -fmodule-file=%t/a10.pcm -fmodule-file=%t/b10.pcm");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fmodules -fimplicit-module-maps '-fmodules-cache-path=${TEST_TEMP_DIR}/exponential-paths.cpp.tmp' '-I${TEST_TEMP_DIR}/exponential-paths.cpp.tmp' -fmodule-name=a12 -x c++ -emit-module ${TEST_TEMP_DIR}/exponential-paths.cpp.tmp/module.modulemap -o ${TEST_TEMP_DIR}/exponential-paths.cpp.tmp/a12.pcm '-fmodule-file=${TEST_TEMP_DIR}/exponential-paths.cpp.tmp/a11.pcm' '-fmodule-file=${TEST_TEMP_DIR}/exponential-paths.cpp.tmp/b11.pcm'
    RUN(TestState.Failed, "%clang_cc1 -fmodules -fimplicit-module-maps -fmodules-cache-path=%t -I%t -fmodule-name=a12 -x c++ -emit-module %t/module.modulemap -o %t/a12.pcm -fmodule-file=%t/a11.pcm -fmodule-file=%t/b11.pcm");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fmodules -fimplicit-module-maps '-fmodules-cache-path=${TEST_TEMP_DIR}/exponential-paths.cpp.tmp' '-I${TEST_TEMP_DIR}/exponential-paths.cpp.tmp' -fmodule-name=b12 -x c++ -emit-module ${TEST_TEMP_DIR}/exponential-paths.cpp.tmp/module.modulemap -o ${TEST_TEMP_DIR}/exponential-paths.cpp.tmp/b12.pcm '-fmodule-file=${TEST_TEMP_DIR}/exponential-paths.cpp.tmp/a11.pcm' '-fmodule-file=${TEST_TEMP_DIR}/exponential-paths.cpp.tmp/b11.pcm'
    RUN(TestState.Failed, "%clang_cc1 -fmodules -fimplicit-module-maps -fmodules-cache-path=%t -I%t -fmodule-name=b12 -x c++ -emit-module %t/module.modulemap -o %t/b12.pcm -fmodule-file=%t/a11.pcm -fmodule-file=%t/b11.pcm");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fmodules -fimplicit-module-maps '-fmodules-cache-path=${TEST_TEMP_DIR}/exponential-paths.cpp.tmp' '-I${TEST_TEMP_DIR}/exponential-paths.cpp.tmp' -fmodule-name=a13 -x c++ -emit-module ${TEST_TEMP_DIR}/exponential-paths.cpp.tmp/module.modulemap -o ${TEST_TEMP_DIR}/exponential-paths.cpp.tmp/a13.pcm '-fmodule-file=${TEST_TEMP_DIR}/exponential-paths.cpp.tmp/a12.pcm' '-fmodule-file=${TEST_TEMP_DIR}/exponential-paths.cpp.tmp/b12.pcm'
    RUN(TestState.Failed, "%clang_cc1 -fmodules -fimplicit-module-maps -fmodules-cache-path=%t -I%t -fmodule-name=a13 -x c++ -emit-module %t/module.modulemap -o %t/a13.pcm -fmodule-file=%t/a12.pcm -fmodule-file=%t/b12.pcm");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fmodules -fimplicit-module-maps '-fmodules-cache-path=${TEST_TEMP_DIR}/exponential-paths.cpp.tmp' '-I${TEST_TEMP_DIR}/exponential-paths.cpp.tmp' -fmodule-name=b13 -x c++ -emit-module ${TEST_TEMP_DIR}/exponential-paths.cpp.tmp/module.modulemap -o ${TEST_TEMP_DIR}/exponential-paths.cpp.tmp/b13.pcm '-fmodule-file=${TEST_TEMP_DIR}/exponential-paths.cpp.tmp/a12.pcm' '-fmodule-file=${TEST_TEMP_DIR}/exponential-paths.cpp.tmp/b12.pcm'
    RUN(TestState.Failed, "%clang_cc1 -fmodules -fimplicit-module-maps -fmodules-cache-path=%t -I%t -fmodule-name=b13 -x c++ -emit-module %t/module.modulemap -o %t/b13.pcm -fmodule-file=%t/a12.pcm -fmodule-file=%t/b12.pcm");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fmodules -fimplicit-module-maps '-fmodules-cache-path=${TEST_TEMP_DIR}/exponential-paths.cpp.tmp' '-I${TEST_TEMP_DIR}/exponential-paths.cpp.tmp' -fmodule-name=a14 -x c++ -emit-module ${TEST_TEMP_DIR}/exponential-paths.cpp.tmp/module.modulemap -o ${TEST_TEMP_DIR}/exponential-paths.cpp.tmp/a14.pcm '-fmodule-file=${TEST_TEMP_DIR}/exponential-paths.cpp.tmp/a13.pcm' '-fmodule-file=${TEST_TEMP_DIR}/exponential-paths.cpp.tmp/b13.pcm'
    RUN(TestState.Failed, "%clang_cc1 -fmodules -fimplicit-module-maps -fmodules-cache-path=%t -I%t -fmodule-name=a14 -x c++ -emit-module %t/module.modulemap -o %t/a14.pcm -fmodule-file=%t/a13.pcm -fmodule-file=%t/b13.pcm");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fmodules -fimplicit-module-maps '-fmodules-cache-path=${TEST_TEMP_DIR}/exponential-paths.cpp.tmp' '-I${TEST_TEMP_DIR}/exponential-paths.cpp.tmp' -fmodule-name=b14 -x c++ -emit-module ${TEST_TEMP_DIR}/exponential-paths.cpp.tmp/module.modulemap -o ${TEST_TEMP_DIR}/exponential-paths.cpp.tmp/b14.pcm '-fmodule-file=${TEST_TEMP_DIR}/exponential-paths.cpp.tmp/a13.pcm' '-fmodule-file=${TEST_TEMP_DIR}/exponential-paths.cpp.tmp/b13.pcm'
    RUN(TestState.Failed, "%clang_cc1 -fmodules -fimplicit-module-maps -fmodules-cache-path=%t -I%t -fmodule-name=b14 -x c++ -emit-module %t/module.modulemap -o %t/b14.pcm -fmodule-file=%t/a13.pcm -fmodule-file=%t/b13.pcm");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fmodules -fimplicit-module-maps '-fmodules-cache-path=${TEST_TEMP_DIR}/exponential-paths.cpp.tmp' '-I${TEST_TEMP_DIR}/exponential-paths.cpp.tmp' -fmodule-name=a15 -x c++ -emit-module ${TEST_TEMP_DIR}/exponential-paths.cpp.tmp/module.modulemap -o ${TEST_TEMP_DIR}/exponential-paths.cpp.tmp/a15.pcm '-fmodule-file=${TEST_TEMP_DIR}/exponential-paths.cpp.tmp/a14.pcm' '-fmodule-file=${TEST_TEMP_DIR}/exponential-paths.cpp.tmp/b14.pcm'
    RUN(TestState.Failed, "%clang_cc1 -fmodules -fimplicit-module-maps -fmodules-cache-path=%t -I%t -fmodule-name=a15 -x c++ -emit-module %t/module.modulemap -o %t/a15.pcm -fmodule-file=%t/a14.pcm -fmodule-file=%t/b14.pcm");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fmodules -fimplicit-module-maps '-fmodules-cache-path=${TEST_TEMP_DIR}/exponential-paths.cpp.tmp' '-I${TEST_TEMP_DIR}/exponential-paths.cpp.tmp' -fmodule-name=b15 -x c++ -emit-module ${TEST_TEMP_DIR}/exponential-paths.cpp.tmp/module.modulemap -o ${TEST_TEMP_DIR}/exponential-paths.cpp.tmp/b15.pcm '-fmodule-file=${TEST_TEMP_DIR}/exponential-paths.cpp.tmp/a14.pcm' '-fmodule-file=${TEST_TEMP_DIR}/exponential-paths.cpp.tmp/b14.pcm'
    RUN(TestState.Failed, "%clang_cc1 -fmodules -fimplicit-module-maps -fmodules-cache-path=%t -I%t -fmodule-name=b15 -x c++ -emit-module %t/module.modulemap -o %t/b15.pcm -fmodule-file=%t/a14.pcm -fmodule-file=%t/b14.pcm");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fmodules -fimplicit-module-maps '-fmodules-cache-path=${TEST_TEMP_DIR}/exponential-paths.cpp.tmp' '-I${TEST_TEMP_DIR}/exponential-paths.cpp.tmp' -fmodule-name=a16 -x c++ -emit-module ${TEST_TEMP_DIR}/exponential-paths.cpp.tmp/module.modulemap -o ${TEST_TEMP_DIR}/exponential-paths.cpp.tmp/a16.pcm '-fmodule-file=${TEST_TEMP_DIR}/exponential-paths.cpp.tmp/a15.pcm' '-fmodule-file=${TEST_TEMP_DIR}/exponential-paths.cpp.tmp/b15.pcm'
    RUN(TestState.Failed, "%clang_cc1 -fmodules -fimplicit-module-maps -fmodules-cache-path=%t -I%t -fmodule-name=a16 -x c++ -emit-module %t/module.modulemap -o %t/a16.pcm -fmodule-file=%t/a15.pcm -fmodule-file=%t/b15.pcm");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fmodules -fimplicit-module-maps '-fmodules-cache-path=${TEST_TEMP_DIR}/exponential-paths.cpp.tmp' '-I${TEST_TEMP_DIR}/exponential-paths.cpp.tmp' -fmodule-name=b16 -x c++ -emit-module ${TEST_TEMP_DIR}/exponential-paths.cpp.tmp/module.modulemap -o ${TEST_TEMP_DIR}/exponential-paths.cpp.tmp/b16.pcm '-fmodule-file=${TEST_TEMP_DIR}/exponential-paths.cpp.tmp/a15.pcm' '-fmodule-file=${TEST_TEMP_DIR}/exponential-paths.cpp.tmp/b15.pcm'
    RUN(TestState.Failed, "%clang_cc1 -fmodules -fimplicit-module-maps -fmodules-cache-path=%t -I%t -fmodule-name=b16 -x c++ -emit-module %t/module.modulemap -o %t/b16.pcm -fmodule-file=%t/a15.pcm -fmodule-file=%t/b15.pcm");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fmodules -fimplicit-module-maps '-fmodules-cache-path=${TEST_TEMP_DIR}/exponential-paths.cpp.tmp' '-I${TEST_TEMP_DIR}/exponential-paths.cpp.tmp' -fmodule-name=a17 -x c++ -emit-module ${TEST_TEMP_DIR}/exponential-paths.cpp.tmp/module.modulemap -o ${TEST_TEMP_DIR}/exponential-paths.cpp.tmp/a17.pcm '-fmodule-file=${TEST_TEMP_DIR}/exponential-paths.cpp.tmp/a16.pcm' '-fmodule-file=${TEST_TEMP_DIR}/exponential-paths.cpp.tmp/b16.pcm'
    RUN(TestState.Failed, "%clang_cc1 -fmodules -fimplicit-module-maps -fmodules-cache-path=%t -I%t -fmodule-name=a17 -x c++ -emit-module %t/module.modulemap -o %t/a17.pcm -fmodule-file=%t/a16.pcm -fmodule-file=%t/b16.pcm");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fmodules -fimplicit-module-maps '-fmodules-cache-path=${TEST_TEMP_DIR}/exponential-paths.cpp.tmp' '-I${TEST_TEMP_DIR}/exponential-paths.cpp.tmp' -fmodule-name=b17 -x c++ -emit-module ${TEST_TEMP_DIR}/exponential-paths.cpp.tmp/module.modulemap -o ${TEST_TEMP_DIR}/exponential-paths.cpp.tmp/b17.pcm '-fmodule-file=${TEST_TEMP_DIR}/exponential-paths.cpp.tmp/a16.pcm' '-fmodule-file=${TEST_TEMP_DIR}/exponential-paths.cpp.tmp/b16.pcm'
    RUN(TestState.Failed, "%clang_cc1 -fmodules -fimplicit-module-maps -fmodules-cache-path=%t -I%t -fmodule-name=b17 -x c++ -emit-module %t/module.modulemap -o %t/b17.pcm -fmodule-file=%t/a16.pcm -fmodule-file=%t/b16.pcm");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fmodules -fimplicit-module-maps '-fmodules-cache-path=${TEST_TEMP_DIR}/exponential-paths.cpp.tmp' '-I${TEST_TEMP_DIR}/exponential-paths.cpp.tmp' -fmodule-name=a18 -x c++ -emit-module ${TEST_TEMP_DIR}/exponential-paths.cpp.tmp/module.modulemap -o ${TEST_TEMP_DIR}/exponential-paths.cpp.tmp/a18.pcm '-fmodule-file=${TEST_TEMP_DIR}/exponential-paths.cpp.tmp/a17.pcm' '-fmodule-file=${TEST_TEMP_DIR}/exponential-paths.cpp.tmp/b17.pcm'
    RUN(TestState.Failed, "%clang_cc1 -fmodules -fimplicit-module-maps -fmodules-cache-path=%t -I%t -fmodule-name=a18 -x c++ -emit-module %t/module.modulemap -o %t/a18.pcm -fmodule-file=%t/a17.pcm -fmodule-file=%t/b17.pcm");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fmodules -fimplicit-module-maps '-fmodules-cache-path=${TEST_TEMP_DIR}/exponential-paths.cpp.tmp' '-I${TEST_TEMP_DIR}/exponential-paths.cpp.tmp' -fmodule-name=b18 -x c++ -emit-module ${TEST_TEMP_DIR}/exponential-paths.cpp.tmp/module.modulemap -o ${TEST_TEMP_DIR}/exponential-paths.cpp.tmp/b18.pcm '-fmodule-file=${TEST_TEMP_DIR}/exponential-paths.cpp.tmp/a17.pcm' '-fmodule-file=${TEST_TEMP_DIR}/exponential-paths.cpp.tmp/b17.pcm'
    RUN(TestState.Failed, "%clang_cc1 -fmodules -fimplicit-module-maps -fmodules-cache-path=%t -I%t -fmodule-name=b18 -x c++ -emit-module %t/module.modulemap -o %t/b18.pcm -fmodule-file=%t/a17.pcm -fmodule-file=%t/b17.pcm");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fmodules -fimplicit-module-maps '-fmodules-cache-path=${TEST_TEMP_DIR}/exponential-paths.cpp.tmp' '-I${TEST_TEMP_DIR}/exponential-paths.cpp.tmp' -fmodule-name=a19 -x c++ -emit-module ${TEST_TEMP_DIR}/exponential-paths.cpp.tmp/module.modulemap -o ${TEST_TEMP_DIR}/exponential-paths.cpp.tmp/a19.pcm '-fmodule-file=${TEST_TEMP_DIR}/exponential-paths.cpp.tmp/a18.pcm' '-fmodule-file=${TEST_TEMP_DIR}/exponential-paths.cpp.tmp/b18.pcm'
    RUN(TestState.Failed, "%clang_cc1 -fmodules -fimplicit-module-maps -fmodules-cache-path=%t -I%t -fmodule-name=a19 -x c++ -emit-module %t/module.modulemap -o %t/a19.pcm -fmodule-file=%t/a18.pcm -fmodule-file=%t/b18.pcm");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fmodules -fimplicit-module-maps '-fmodules-cache-path=${TEST_TEMP_DIR}/exponential-paths.cpp.tmp' '-I${TEST_TEMP_DIR}/exponential-paths.cpp.tmp' -fmodule-name=b19 -x c++ -emit-module ${TEST_TEMP_DIR}/exponential-paths.cpp.tmp/module.modulemap -o ${TEST_TEMP_DIR}/exponential-paths.cpp.tmp/b19.pcm '-fmodule-file=${TEST_TEMP_DIR}/exponential-paths.cpp.tmp/a18.pcm' '-fmodule-file=${TEST_TEMP_DIR}/exponential-paths.cpp.tmp/b18.pcm'
    RUN(TestState.Failed, "%clang_cc1 -fmodules -fimplicit-module-maps -fmodules-cache-path=%t -I%t -fmodule-name=b19 -x c++ -emit-module %t/module.modulemap -o %t/b19.pcm -fmodule-file=%t/a18.pcm -fmodule-file=%t/b18.pcm");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fmodules -fimplicit-module-maps '-fmodules-cache-path=${TEST_TEMP_DIR}/exponential-paths.cpp.tmp' '-I${TEST_TEMP_DIR}/exponential-paths.cpp.tmp' -fmodule-name=a20 -x c++ -emit-module ${TEST_TEMP_DIR}/exponential-paths.cpp.tmp/module.modulemap -o ${TEST_TEMP_DIR}/exponential-paths.cpp.tmp/a20.pcm '-fmodule-file=${TEST_TEMP_DIR}/exponential-paths.cpp.tmp/a19.pcm' '-fmodule-file=${TEST_TEMP_DIR}/exponential-paths.cpp.tmp/b19.pcm'
    RUN(TestState.Failed, "%clang_cc1 -fmodules -fimplicit-module-maps -fmodules-cache-path=%t -I%t -fmodule-name=a20 -x c++ -emit-module %t/module.modulemap -o %t/a20.pcm -fmodule-file=%t/a19.pcm -fmodule-file=%t/b19.pcm");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fmodules -fimplicit-module-maps '-fmodules-cache-path=${TEST_TEMP_DIR}/exponential-paths.cpp.tmp' '-I${TEST_TEMP_DIR}/exponential-paths.cpp.tmp' -fmodule-name=b20 -x c++ -emit-module ${TEST_TEMP_DIR}/exponential-paths.cpp.tmp/module.modulemap -o ${TEST_TEMP_DIR}/exponential-paths.cpp.tmp/b20.pcm '-fmodule-file=${TEST_TEMP_DIR}/exponential-paths.cpp.tmp/a19.pcm' '-fmodule-file=${TEST_TEMP_DIR}/exponential-paths.cpp.tmp/b19.pcm'
    RUN(TestState.Failed, "%clang_cc1 -fmodules -fimplicit-module-maps -fmodules-cache-path=%t -I%t -fmodule-name=b20 -x c++ -emit-module %t/module.modulemap -o %t/b20.pcm -fmodule-file=%t/a19.pcm -fmodule-file=%t/b19.pcm");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fmodules -fimplicit-module-maps '-fmodules-cache-path=${TEST_TEMP_DIR}/exponential-paths.cpp.tmp' '-I${TEST_TEMP_DIR}/exponential-paths.cpp.tmp' -fsyntax-only ${LLVM_SRC}/llvm/tools/clang/test/Modules/exponential-paths.cpp '-fmodule-file=${TEST_TEMP_DIR}/exponential-paths.cpp.tmp/a0.pcm' '-fmodule-file=${TEST_TEMP_DIR}/exponential-paths.cpp.tmp/b0.pcm' '-fmodule-file=${TEST_TEMP_DIR}/exponential-paths.cpp.tmp/a1.pcm' '-fmodule-file=${TEST_TEMP_DIR}/exponential-paths.cpp.tmp/b1.pcm' '-fmodule-file=${TEST_TEMP_DIR}/exponential-paths.cpp.tmp/a2.pcm' '-fmodule-file=${TEST_TEMP_DIR}/exponential-paths.cpp.tmp/b2.pcm' '-fmodule-file=${TEST_TEMP_DIR}/exponential-paths.cpp.tmp/a3.pcm' '-fmodule-file=${TEST_TEMP_DIR}/exponential-paths.cpp.tmp/b3.pcm' '-fmodule-file=${TEST_TEMP_DIR}/exponential-paths.cpp.tmp/a4.pcm' '-fmodule-file=${TEST_TEMP_DIR}/exponential-paths.cpp.tmp/b4.pcm' '-fmodule-file=${TEST_TEMP_DIR}/exponential-paths.cpp.tmp/a5.pcm' '-fmodule-file=${TEST_TEMP_DIR}/exponential-paths.cpp.tmp/b5.pcm' '-fmodule-file=${TEST_TEMP_DIR}/exponential-paths.cpp.tmp/a6.pcm' '-fmodule-file=${TEST_TEMP_DIR}/exponential-paths.cpp.tmp/b6.pcm' '-fmodule-file=${TEST_TEMP_DIR}/exponential-paths.cpp.tmp/a7.pcm' '-fmodule-file=${TEST_TEMP_DIR}/exponential-paths.cpp.tmp/b7.pcm' '-fmodule-file=${TEST_TEMP_DIR}/exponential-paths.cpp.tmp/a8.pcm' '-fmodule-file=${TEST_TEMP_DIR}/exponential-paths.cpp.tmp/b8.pcm' '-fmodule-file=${TEST_TEMP_DIR}/exponential-paths.cpp.tmp/a9.pcm' '-fmodule-file=${TEST_TEMP_DIR}/exponential-paths.cpp.tmp/b9.pcm' '-fmodule-file=${TEST_TEMP_DIR}/exponential-paths.cpp.tmp/a10.pcm' '-fmodule-file=${TEST_TEMP_DIR}/exponential-paths.cpp.tmp/b10.pcm' '-fmodule-file=${TEST_TEMP_DIR}/exponential-paths.cpp.tmp/a11.pcm' '-fmodule-file=${TEST_TEMP_DIR}/exponential-paths.cpp.tmp/b11.pcm' '-fmodule-file=${TEST_TEMP_DIR}/exponential-paths.cpp.tmp/a12.pcm' '-fmodule-file=${TEST_TEMP_DIR}/exponential-paths.cpp.tmp/b12.pcm' '-fmodule-file=${TEST_TEMP_DIR}/exponential-paths.cpp.tmp/a13.pcm' '-fmodule-file=${TEST_TEMP_DIR}/exponential-paths.cpp.tmp/b13.pcm' '-fmodule-file=${TEST_TEMP_DIR}/exponential-paths.cpp.tmp/a14.pcm' '-fmodule-file=${TEST_TEMP_DIR}/exponential-paths.cpp.tmp/b14.pcm' '-fmodule-file=${TEST_TEMP_DIR}/exponential-paths.cpp.tmp/a15.pcm' '-fmodule-file=${TEST_TEMP_DIR}/exponential-paths.cpp.tmp/b15.pcm' '-fmodule-file=${TEST_TEMP_DIR}/exponential-paths.cpp.tmp/a16.pcm' '-fmodule-file=${TEST_TEMP_DIR}/exponential-paths.cpp.tmp/b16.pcm' '-fmodule-file=${TEST_TEMP_DIR}/exponential-paths.cpp.tmp/a17.pcm' '-fmodule-file=${TEST_TEMP_DIR}/exponential-paths.cpp.tmp/b17.pcm' '-fmodule-file=${TEST_TEMP_DIR}/exponential-paths.cpp.tmp/a18.pcm' '-fmodule-file=${TEST_TEMP_DIR}/exponential-paths.cpp.tmp/b18.pcm' '-fmodule-file=${TEST_TEMP_DIR}/exponential-paths.cpp.tmp/a19.pcm' '-fmodule-file=${TEST_TEMP_DIR}/exponential-paths.cpp.tmp/b19.pcm' '-fmodule-file=${TEST_TEMP_DIR}/exponential-paths.cpp.tmp/a20.pcm' '-fmodule-file=${TEST_TEMP_DIR}/exponential-paths.cpp.tmp/b20.pcm'
    RUN(TestState.Failed, "%clang_cc1 -fmodules -fimplicit-module-maps -fmodules-cache-path=%t -I%t -fsyntax-only %s -fmodule-file=%t/a0.pcm -fmodule-file=%t/b0.pcm -fmodule-file=%t/a1.pcm -fmodule-file=%t/b1.pcm -fmodule-file=%t/a2.pcm -fmodule-file=%t/b2.pcm -fmodule-file=%t/a3.pcm -fmodule-file=%t/b3.pcm -fmodule-file=%t/a4.pcm -fmodule-file=%t/b4.pcm -fmodule-file=%t/a5.pcm -fmodule-file=%t/b5.pcm -fmodule-file=%t/a6.pcm -fmodule-file=%t/b6.pcm -fmodule-file=%t/a7.pcm -fmodule-file=%t/b7.pcm -fmodule-file=%t/a8.pcm -fmodule-file=%t/b8.pcm -fmodule-file=%t/a9.pcm -fmodule-file=%t/b9.pcm -fmodule-file=%t/a10.pcm -fmodule-file=%t/b10.pcm -fmodule-file=%t/a11.pcm -fmodule-file=%t/b11.pcm -fmodule-file=%t/a12.pcm -fmodule-file=%t/b12.pcm -fmodule-file=%t/a13.pcm -fmodule-file=%t/b13.pcm -fmodule-file=%t/a14.pcm -fmodule-file=%t/b14.pcm -fmodule-file=%t/a15.pcm -fmodule-file=%t/b15.pcm -fmodule-file=%t/a16.pcm -fmodule-file=%t/b16.pcm -fmodule-file=%t/a17.pcm -fmodule-file=%t/b17.pcm -fmodule-file=%t/a18.pcm -fmodule-file=%t/b18.pcm -fmodule-file=%t/a19.pcm -fmodule-file=%t/b19.pcm -fmodule-file=%t/a20.pcm -fmodule-file=%t/b20.pcm");
  }

  @Test
  public void test_extensions_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Modules/extensions.c");
    // rm -rf ${TEST_TEMP_DIR}/extensions.c.tmp
    RUN(TestState.Failed, "rm -rf %t");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fmodules -fimplicit-module-maps -fdisable-module-hash -ftest-module-file-extension=clang.testA:1:5:0:user_info_for_A -ftest-module-file-extension=clang.testB:2:3:0:user_info_for_B '-fmodules-cache-path=${TEST_TEMP_DIR}/extensions.c.tmp' -I ${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs ${LLVM_SRC}/llvm/tools/clang/test/Modules/extensions.c
    RUN(TestState.Failed, "%clang_cc1 -fmodules -fimplicit-module-maps -fdisable-module-hash -ftest-module-file-extension=clang.testA:1:5:0:user_info_for_A -ftest-module-file-extension=clang.testB:2:3:0:user_info_for_B -fmodules-cache-path=%t -I %S/Inputs %s");
    // llvm-bcanalyzer ${TEST_TEMP_DIR}/extensions.c.tmp/ExtensionTestA.pcm | ${LLVM_SRC}/build/bin/FileCheck -check-prefix=CHECK-BCANALYZER ${LLVM_SRC}/llvm/tools/clang/test/Modules/extensions.c
    RUN(TestState.Failed, "llvm-bcanalyzer %t/ExtensionTestA.pcm")./*|*/
      I("FileCheck -check-prefix=CHECK-BCANALYZER %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -module-file-info ${TEST_TEMP_DIR}/extensions.c.tmp/ExtensionTestA.pcm | ${LLVM_SRC}/build/bin/FileCheck -check-prefix=CHECK-INFO ${LLVM_SRC}/llvm/tools/clang/test/Modules/extensions.c
    RUN(TestState.Failed, "%clang_cc1 -module-file-info %t/ExtensionTestA.pcm")./*|*/
      I("FileCheck -check-prefix=CHECK-INFO %s");
    // rm -rf ${TEST_TEMP_DIR}/extensions.c.tmp
    RUN(TestState.Failed, "rm -rf %t");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fmodules -fimplicit-module-maps -ftest-module-file-extension=clang.testA:1:5:0:user_info_for_A -ftest-module-file-extension=clang.testB:2:3:0:user_info_for_B '-fmodules-cache-path=${TEST_TEMP_DIR}/extensions.c.tmp' -I ${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs ${LLVM_SRC}/llvm/tools/clang/test/Modules/extensions.c
    RUN(TestState.Failed, "%clang_cc1 -fmodules -fimplicit-module-maps -ftest-module-file-extension=clang.testA:1:5:0:user_info_for_A -ftest-module-file-extension=clang.testB:2:3:0:user_info_for_B -fmodules-cache-path=%t -I %S/Inputs %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fmodules -fimplicit-module-maps -ftest-module-file-extension=clang.testA:1:3:0:user_info_for_A -ftest-module-file-extension=clang.testB:3:2:0:user_info_for_B '-fmodules-cache-path=${TEST_TEMP_DIR}/extensions.c.tmp' -I ${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs ${LLVM_SRC}/llvm/tools/clang/test/Modules/extensions.c -verify
    RUN(TestState.Failed, "%clang_cc1 -fmodules -fimplicit-module-maps -ftest-module-file-extension=clang.testA:1:3:0:user_info_for_A -ftest-module-file-extension=clang.testB:3:2:0:user_info_for_B -fmodules-cache-path=%t -I %S/Inputs %s -verify");
    // rm -rf ${TEST_TEMP_DIR}/extensions.c.tmp
    RUN(TestState.Failed, "rm -rf %t");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fmodules -fimplicit-module-maps -ftest-module-file-extension=clang.testA:1:5:1:user_info_for_A -ftest-module-file-extension=clang.testB:2:3:1:user_info_for_B '-fmodules-cache-path=${TEST_TEMP_DIR}/extensions.c.tmp' -I ${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs ${LLVM_SRC}/llvm/tools/clang/test/Modules/extensions.c
    RUN(TestState.Failed, "%clang_cc1 -fmodules -fimplicit-module-maps -ftest-module-file-extension=clang.testA:1:5:1:user_info_for_A -ftest-module-file-extension=clang.testB:2:3:1:user_info_for_B -fmodules-cache-path=%t -I %S/Inputs %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fmodules -fimplicit-module-maps -ftest-module-file-extension=clang.testA:1:3:1:user_info_for_A -ftest-module-file-extension=clang.testB:3:2:1:user_info_for_B '-fmodules-cache-path=${TEST_TEMP_DIR}/extensions.c.tmp' -I ${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs ${LLVM_SRC}/llvm/tools/clang/test/Modules/extensions.c
    RUN(TestState.Failed, "%clang_cc1 -fmodules -fimplicit-module-maps -ftest-module-file-extension=clang.testA:1:3:1:user_info_for_A -ftest-module-file-extension=clang.testB:3:2:1:user_info_for_B -fmodules-cache-path=%t -I %S/Inputs %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fmodules -fimplicit-module-maps -ftest-module-file-extension=clang.testA:2:5:0:user_info_for_A -ftest-module-file-extension=clang.testB:7:3:0:user_info_for_B '-fmodules-cache-path=${TEST_TEMP_DIR}/extensions.c.tmp' -I ${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs ${LLVM_SRC}/llvm/tools/clang/test/Modules/extensions.c
    RUN(TestState.Failed, "%clang_cc1 -fmodules -fimplicit-module-maps -ftest-module-file-extension=clang.testA:2:5:0:user_info_for_A -ftest-module-file-extension=clang.testB:7:3:0:user_info_for_B -fmodules-cache-path=%t -I %S/Inputs %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fmodules -fimplicit-module-maps -fdisable-module-hash -ftest-module-file-extension=clang.testA:1:5:0:user_info_for_A -ftest-module-file-extension=clang.testB:2:3:0:user_info_for_B '-fmodules-cache-path=${TEST_TEMP_DIR}/extensions.c.tmp' -I ${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs ${LLVM_SRC}/llvm/tools/clang/test/Modules/extensions.c > ${TEST_TEMP_DIR}/extensions.c.tmp.log 2>&1
    RUN(TestState.Failed, "%clang_cc1 -fmodules -fimplicit-module-maps -fdisable-module-hash -ftest-module-file-extension=clang.testA:1:5:0:user_info_for_A -ftest-module-file-extension=clang.testB:2:3:0:user_info_for_B -fmodules-cache-path=%t -I %S/Inputs %s > %t.log 2>&1");
    // ${LLVM_SRC}/build/bin/FileCheck -check-prefix=CHECK-MESSAGE ${LLVM_SRC}/llvm/tools/clang/test/Modules/extensions.c < ${TEST_TEMP_DIR}/extensions.c.tmp.log
    RUN(TestState.Failed, "FileCheck -check-prefix=CHECK-MESSAGE %s < %t.log");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fmodules -fimplicit-module-maps -fdisable-module-hash -ftest-module-file-extension=clang.testA:1:5:0:user_info_for_A -ftest-module-file-extension=clang.testA:1:5:0:user_info_for_A '-fmodules-cache-path=${TEST_TEMP_DIR}/extensions.c.tmp' -I ${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs ${LLVM_SRC}/llvm/tools/clang/test/Modules/extensions.c > ${TEST_TEMP_DIR}/extensions.c.tmp.log 2>&1
    RUN(TestState.Failed, "%clang_cc1 -fmodules -fimplicit-module-maps -fdisable-module-hash -ftest-module-file-extension=clang.testA:1:5:0:user_info_for_A -ftest-module-file-extension=clang.testA:1:5:0:user_info_for_A -fmodules-cache-path=%t -I %S/Inputs %s > %t.log 2>&1");
    // ${LLVM_SRC}/build/bin/FileCheck -check-prefix=CHECK-DUPLICATE ${LLVM_SRC}/llvm/tools/clang/test/Modules/extensions.c < ${TEST_TEMP_DIR}/extensions.c.tmp.log
    RUN(TestState.Failed, "FileCheck -check-prefix=CHECK-DUPLICATE %s < %t.log");
  }

  @Test
  public void test_extern_c_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Modules/extern_c.cpp");
    // rm -rf ${TEST_TEMP_DIR}/extern_c.cpp.tmp
    RUN(TestState.Failed, "rm -rf %t");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fmodules -fimplicit-module-maps -verify '-fmodules-cache-path=${TEST_TEMP_DIR}/extern_c.cpp.tmp' -I ${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs ${LLVM_SRC}/llvm/tools/clang/test/Modules/extern_c.cpp
    RUN(TestState.Failed, "%clang_cc1 -fmodules -fimplicit-module-maps -verify -fmodules-cache-path=%t -I %S/Inputs %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fmodules -fimplicit-module-maps -verify '-fmodules-cache-path=${TEST_TEMP_DIR}/extern_c.cpp.tmp' -I ${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs ${LLVM_SRC}/llvm/tools/clang/test/Modules/extern_c.cpp -DEXTERN_C
    RUN(TestState.Failed, "%clang_cc1 -fmodules -fimplicit-module-maps -verify -fmodules-cache-path=%t -I %S/Inputs %s -DEXTERN_C");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fmodules -fimplicit-module-maps -verify '-fmodules-cache-path=${TEST_TEMP_DIR}/extern_c.cpp.tmp' -I ${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs ${LLVM_SRC}/llvm/tools/clang/test/Modules/extern_c.cpp -DEXTERN_CXX
    RUN(TestState.Failed, "%clang_cc1 -fmodules -fimplicit-module-maps -verify -fmodules-cache-path=%t -I %S/Inputs %s -DEXTERN_CXX");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fmodules -fimplicit-module-maps -verify '-fmodules-cache-path=${TEST_TEMP_DIR}/extern_c.cpp.tmp' -I ${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs ${LLVM_SRC}/llvm/tools/clang/test/Modules/extern_c.cpp -DEXTERN_C -DEXTERN_CXX
    RUN(TestState.Failed, "%clang_cc1 -fmodules -fimplicit-module-maps -verify -fmodules-cache-path=%t -I %S/Inputs %s -DEXTERN_C -DEXTERN_CXX");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fmodules -fimplicit-module-maps -verify '-fmodules-cache-path=${TEST_TEMP_DIR}/extern_c.cpp.tmp' -I ${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs ${LLVM_SRC}/llvm/tools/clang/test/Modules/extern_c.cpp -DEXTERN_C -DNAMESPACE
    RUN(TestState.Failed, "%clang_cc1 -fmodules -fimplicit-module-maps -verify -fmodules-cache-path=%t -I %S/Inputs %s -DEXTERN_C -DNAMESPACE");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fmodules -fimplicit-module-maps -verify '-fmodules-cache-path=${TEST_TEMP_DIR}/extern_c.cpp.tmp' -I ${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs ${LLVM_SRC}/llvm/tools/clang/test/Modules/extern_c.cpp -DCXX_HEADER
    RUN(TestState.Failed, "%clang_cc1 -fmodules -fimplicit-module-maps -verify -fmodules-cache-path=%t -I %S/Inputs %s -DCXX_HEADER");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fmodules -fimplicit-module-maps -verify '-fmodules-cache-path=${TEST_TEMP_DIR}/extern_c.cpp.tmp' -I ${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs ${LLVM_SRC}/llvm/tools/clang/test/Modules/extern_c.cpp -DCXX_HEADER -DEXTERN_C
    RUN(TestState.Failed, "%clang_cc1 -fmodules -fimplicit-module-maps -verify -fmodules-cache-path=%t -I %S/Inputs %s -DCXX_HEADER -DEXTERN_C");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fmodules -fimplicit-module-maps -verify '-fmodules-cache-path=${TEST_TEMP_DIR}/extern_c.cpp.tmp' -I ${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs ${LLVM_SRC}/llvm/tools/clang/test/Modules/extern_c.cpp -DCXX_HEADER -DEXTERN_CXX
    RUN(TestState.Failed, "%clang_cc1 -fmodules -fimplicit-module-maps -verify -fmodules-cache-path=%t -I %S/Inputs %s -DCXX_HEADER -DEXTERN_CXX");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fmodules -fimplicit-module-maps -verify '-fmodules-cache-path=${TEST_TEMP_DIR}/extern_c.cpp.tmp' -I ${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs ${LLVM_SRC}/llvm/tools/clang/test/Modules/extern_c.cpp -DCXX_HEADER -DEXTERN_C -DEXTERN_CXX
    RUN(TestState.Failed, "%clang_cc1 -fmodules -fimplicit-module-maps -verify -fmodules-cache-path=%t -I %S/Inputs %s -DCXX_HEADER -DEXTERN_C -DEXTERN_CXX");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fmodules -fimplicit-module-maps -verify '-fmodules-cache-path=${TEST_TEMP_DIR}/extern_c.cpp.tmp' -I ${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs ${LLVM_SRC}/llvm/tools/clang/test/Modules/extern_c.cpp -DCXX_HEADER -DEXTERN_C -DNAMESPACE
    RUN(TestState.Failed, "%clang_cc1 -fmodules -fimplicit-module-maps -verify -fmodules-cache-path=%t -I %S/Inputs %s -DCXX_HEADER -DEXTERN_C -DNAMESPACE");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fmodules -fimplicit-module-maps -verify '-fmodules-cache-path=${TEST_TEMP_DIR}/extern_c.cpp.tmp' -I ${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs ${LLVM_SRC}/llvm/tools/clang/test/Modules/extern_c.cpp -DCXX_HEADER -DEXTERN_C -DNO_EXTERN_C_ERROR -Wno-module-import-in-extern-c
    RUN(TestState.Failed, "%clang_cc1 -fmodules -fimplicit-module-maps -verify -fmodules-cache-path=%t -I %S/Inputs %s -DCXX_HEADER -DEXTERN_C -DNO_EXTERN_C_ERROR -Wno-module-import-in-extern-c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fmodules -fimplicit-module-maps -verify '-fmodules-cache-path=${TEST_TEMP_DIR}/extern_c.cpp.tmp' -I ${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs ${LLVM_SRC}/llvm/tools/clang/test/Modules/extern_c.cpp -DCXX_HEADER -DEXTERN_C -DNAMESPACE -DNO_EXTERN_C_ERROR -Wno-module-import-in-extern-c
    RUN(TestState.Failed, "%clang_cc1 -fmodules -fimplicit-module-maps -verify -fmodules-cache-path=%t -I %S/Inputs %s -DCXX_HEADER -DEXTERN_C -DNAMESPACE -DNO_EXTERN_C_ERROR -Wno-module-import-in-extern-c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fmodules -fimplicit-module-maps -verify '-fmodules-cache-path=${TEST_TEMP_DIR}/extern_c.cpp.tmp' -I ${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs -x c ${LLVM_SRC}/llvm/tools/clang/test/Modules/extern_c.cpp
    RUN(TestState.Failed, "%clang_cc1 -fmodules -fimplicit-module-maps -verify -fmodules-cache-path=%t -I %S/Inputs -x c %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fmodules -fimplicit-module-maps -verify '-fmodules-cache-path=${TEST_TEMP_DIR}/extern_c.cpp.tmp' -I ${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs/elsewhere -I ${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs ${LLVM_SRC}/llvm/tools/clang/test/Modules/extern_c.cpp -DEXTERN_C -DINDIRECT
    RUN(TestState.Failed, "%clang_cc1 -fmodules -fimplicit-module-maps -verify -fmodules-cache-path=%t -I %S/Inputs/elsewhere -I %S/Inputs %s -DEXTERN_C -DINDIRECT");
  }

  @Test
  public void test_extern_c_bad_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Modules/extern_c_bad.cpp");
    // rm -rf ${TEST_TEMP_DIR}/extern_c_bad.cpp.tmp
    RUN("rm -rf %t");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -verify -fmodules -fimplicit-module-maps -x c++ -emit-module '-fmodules-cache-path=${TEST_TEMP_DIR}/extern_c_bad.cpp.tmp' -fmodule-name=c_library_bad ${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs/module.map
    RUN("%clang_cc1 -verify -fmodules -fimplicit-module-maps -x c++ -emit-module -fmodules-cache-path=%t -fmodule-name=c_library_bad %S/Inputs/module.map");
  }

  @Test
  public void test_fatal_module_loader_error_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Modules/fatal-module-loader-error.m");
    // rm -rf ${TEST_TEMP_DIR}/fatal-module-loader-error.m.tmp
    RUN("rm -rf %t");
    // mkdir ${TEST_TEMP_DIR}/fatal-module-loader-error.m.tmp
    RUN("mkdir %t");
    // touch ${TEST_TEMP_DIR}/fatal-module-loader-error.m.tmp/Module.pcm
    RUN("touch %t/Module.pcm");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fmodules -fimplicit-module-maps '-fmodules-cache-path=${TEST_TEMP_DIR}/fatal-module-loader-error.m.tmp' ${LLVM_SRC}/llvm/tools/clang/test/Modules/fatal-module-loader-error.m -fdisable-module-hash -F ${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs -verify
    RUN("%clang_cc1 -fmodules -fimplicit-module-maps -fmodules-cache-path=%t %s -fdisable-module-hash -F %S/Inputs -verify");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fmodules -fimplicit-module-maps '-fmodules-cache-path=${TEST_TEMP_DIR}/fatal-module-loader-error.m.tmp' ${LLVM_SRC}/llvm/tools/clang/test/Modules/fatal-module-loader-error.m -fdisable-module-hash -F ${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs -DIMPLICIT -verify
    RUN("%clang_cc1 -fmodules -fimplicit-module-maps -fmodules-cache-path=%t %s -fdisable-module-hash -F %S/Inputs -DIMPLICIT -verify");
    // c-index-test -write-pch ${TEST_TEMP_DIR}/fatal-module-loader-error.m.tmp.pch -fmodules -fimplicit-module-maps '-fmodules-cache-path=${TEST_TEMP_DIR}/fatal-module-loader-error.m.tmp' ${LLVM_SRC}/llvm/tools/clang/test/Modules/fatal-module-loader-error.m -Xclang -fdisable-module-hash -F ${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs 2>&1 | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Modules/fatal-module-loader-error.m
    RUN("not c-index-test -write-pch %t.pch -fmodules -fimplicit-module-maps -fmodules-cache-path=%t %s -Xclang -fdisable-module-hash -F %S/Inputs 2>&1")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_filename_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Modules/filename.cpp");
    // cd ${LLVM_SRC}/llvm/tools/clang/test/Modules
    RUN(TestState.Failed, "cd %S");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -I. -fmodule-name=A '-fmodule-map-file=${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs/filename/module.map' ${LLVM_SRC}/llvm/tools/clang/test/Modules/filename.cpp -E | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Modules/filename.cpp
    RUN(TestState.Failed, "%clang_cc1 -I. -fmodule-name=A  -fmodule-map-file=%S/Inputs/filename/module.map %s -E")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_fmodules_validate_once_per_build_session_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Modules/fmodules-validate-once-per-build-session.c");
    // rm -rf ${TEST_TEMP_DIR}/fmodules-validate-once-per-build-session.c.tmp
    RUN("rm -rf %t");
    // mkdir -p ${TEST_TEMP_DIR}/fmodules-validate-once-per-build-session.c.tmp/Inputs
    RUN("mkdir -p %t/Inputs");
    // mkdir -p ${TEST_TEMP_DIR}/fmodules-validate-once-per-build-session.c.tmp/modules-to-compare
    RUN("mkdir -p %t/modules-to-compare");
    // echo 'void meow(void);' > ${TEST_TEMP_DIR}/fmodules-validate-once-per-build-session.c.tmp/Inputs/foo.h
    RUN("echo 'void meow(void);' > %t/Inputs/foo.h");
    // echo 'module Foo { header "foo.h" }' > ${TEST_TEMP_DIR}/fmodules-validate-once-per-build-session.c.tmp/Inputs/module.map
    RUN("echo 'module Foo { header \"foo.h\" }' > %t/Inputs/module.map");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -cc1 -fmodules -fimplicit-module-maps -fdisable-module-hash '-fmodules-cache-path=${TEST_TEMP_DIR}/fmodules-validate-once-per-build-session.c.tmp/modules-cache' -fsyntax-only -isystem ${TEST_TEMP_DIR}/fmodules-validate-once-per-build-session.c.tmp/Inputs -fbuild-session-timestamp=1390000000 -fmodules-validate-once-per-build-session ${LLVM_SRC}/llvm/tools/clang/test/Modules/fmodules-validate-once-per-build-session.c
    RUN("%clang_cc1 -cc1 -fmodules -fimplicit-module-maps -fdisable-module-hash -fmodules-cache-path=%t/modules-cache -fsyntax-only -isystem %t/Inputs -fbuild-session-timestamp=1390000000 -fmodules-validate-once-per-build-session %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -cc1 -fmodules -fimplicit-module-maps -fdisable-module-hash '-fmodules-cache-path=${TEST_TEMP_DIR}/fmodules-validate-once-per-build-session.c.tmp/modules-cache-user' -fsyntax-only -I ${TEST_TEMP_DIR}/fmodules-validate-once-per-build-session.c.tmp/Inputs -fbuild-session-timestamp=1390000000 -fmodules-validate-once-per-build-session ${LLVM_SRC}/llvm/tools/clang/test/Modules/fmodules-validate-once-per-build-session.c
    RUN("%clang_cc1 -cc1 -fmodules -fimplicit-module-maps -fdisable-module-hash -fmodules-cache-path=%t/modules-cache-user -fsyntax-only -I %t/Inputs -fbuild-session-timestamp=1390000000 -fmodules-validate-once-per-build-session %s");
    // ls -R ${TEST_TEMP_DIR}/fmodules-validate-once-per-build-session.c.tmp/modules-cache | grep Foo.pcm.timestamp
    RUN("ls -R %t/modules-cache")./*|*/
      I("grep Foo.pcm.timestamp");
    // ls -R ${TEST_TEMP_DIR}/fmodules-validate-once-per-build-session.c.tmp/modules-cache-user | grep Foo.pcm.timestamp
    RUN("ls -R %t/modules-cache-user")./*|*/
      I("grep Foo.pcm.timestamp");
    // cp ${TEST_TEMP_DIR}/fmodules-validate-once-per-build-session.c.tmp/modules-cache/Foo.pcm ${TEST_TEMP_DIR}/fmodules-validate-once-per-build-session.c.tmp/modules-to-compare/Foo-before.pcm
    RUN("cp %t/modules-cache/Foo.pcm %t/modules-to-compare/Foo-before.pcm");
    // cp ${TEST_TEMP_DIR}/fmodules-validate-once-per-build-session.c.tmp/modules-cache-user/Foo.pcm ${TEST_TEMP_DIR}/fmodules-validate-once-per-build-session.c.tmp/modules-to-compare/Foo-before-user.pcm
    RUN("cp %t/modules-cache-user/Foo.pcm %t/modules-to-compare/Foo-before-user.pcm");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -cc1 -fmodules -fimplicit-module-maps -fdisable-module-hash '-fmodules-cache-path=${TEST_TEMP_DIR}/fmodules-validate-once-per-build-session.c.tmp/modules-cache' -fsyntax-only -isystem ${TEST_TEMP_DIR}/fmodules-validate-once-per-build-session.c.tmp/Inputs -fbuild-session-timestamp=1390000000 -fmodules-validate-once-per-build-session ${LLVM_SRC}/llvm/tools/clang/test/Modules/fmodules-validate-once-per-build-session.c
    RUN("%clang_cc1 -cc1 -fmodules -fimplicit-module-maps -fdisable-module-hash -fmodules-cache-path=%t/modules-cache -fsyntax-only -isystem %t/Inputs -fbuild-session-timestamp=1390000000 -fmodules-validate-once-per-build-session %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -cc1 -fmodules -fimplicit-module-maps -fdisable-module-hash '-fmodules-cache-path=${TEST_TEMP_DIR}/fmodules-validate-once-per-build-session.c.tmp/modules-cache-user' -fsyntax-only -I ${TEST_TEMP_DIR}/fmodules-validate-once-per-build-session.c.tmp/Inputs -fbuild-session-timestamp=1390000000 -fmodules-validate-once-per-build-session ${LLVM_SRC}/llvm/tools/clang/test/Modules/fmodules-validate-once-per-build-session.c
    RUN("%clang_cc1 -cc1 -fmodules -fimplicit-module-maps -fdisable-module-hash -fmodules-cache-path=%t/modules-cache-user -fsyntax-only -I %t/Inputs -fbuild-session-timestamp=1390000000 -fmodules-validate-once-per-build-session %s");
    // ls -R ${TEST_TEMP_DIR}/fmodules-validate-once-per-build-session.c.tmp/modules-cache | grep Foo.pcm.timestamp
    RUN("ls -R %t/modules-cache")./*|*/
      I("grep Foo.pcm.timestamp");
    // ls -R ${TEST_TEMP_DIR}/fmodules-validate-once-per-build-session.c.tmp/modules-cache-user | grep Foo.pcm.timestamp
    RUN("ls -R %t/modules-cache-user")./*|*/
      I("grep Foo.pcm.timestamp");
    // cp ${TEST_TEMP_DIR}/fmodules-validate-once-per-build-session.c.tmp/modules-cache/Foo.pcm ${TEST_TEMP_DIR}/fmodules-validate-once-per-build-session.c.tmp/modules-to-compare/Foo-after.pcm
    RUN("cp %t/modules-cache/Foo.pcm %t/modules-to-compare/Foo-after.pcm");
    // cp ${TEST_TEMP_DIR}/fmodules-validate-once-per-build-session.c.tmp/modules-cache-user/Foo.pcm ${TEST_TEMP_DIR}/fmodules-validate-once-per-build-session.c.tmp/modules-to-compare/Foo-after-user.pcm
    RUN("cp %t/modules-cache-user/Foo.pcm %t/modules-to-compare/Foo-after-user.pcm");
    // diff ${TEST_TEMP_DIR}/fmodules-validate-once-per-build-session.c.tmp/modules-to-compare/Foo-before.pcm ${TEST_TEMP_DIR}/fmodules-validate-once-per-build-session.c.tmp/modules-to-compare/Foo-after.pcm
    RUN("diff %t/modules-to-compare/Foo-before.pcm %t/modules-to-compare/Foo-after.pcm");
    // diff ${TEST_TEMP_DIR}/fmodules-validate-once-per-build-session.c.tmp/modules-to-compare/Foo-before-user.pcm ${TEST_TEMP_DIR}/fmodules-validate-once-per-build-session.c.tmp/modules-to-compare/Foo-after-user.pcm
    RUN("diff %t/modules-to-compare/Foo-before-user.pcm %t/modules-to-compare/Foo-after-user.pcm");
    // echo 'void meow2(void);' > ${TEST_TEMP_DIR}/fmodules-validate-once-per-build-session.c.tmp/Inputs/foo.h
    RUN("echo 'void meow2(void);' > %t/Inputs/foo.h");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -cc1 -fmodules -fimplicit-module-maps -fdisable-module-hash '-fmodules-cache-path=${TEST_TEMP_DIR}/fmodules-validate-once-per-build-session.c.tmp/modules-cache' -fsyntax-only -isystem ${TEST_TEMP_DIR}/fmodules-validate-once-per-build-session.c.tmp/Inputs -fbuild-session-timestamp=1390000000 -fmodules-validate-once-per-build-session ${LLVM_SRC}/llvm/tools/clang/test/Modules/fmodules-validate-once-per-build-session.c
    RUN("%clang_cc1 -cc1 -fmodules -fimplicit-module-maps -fdisable-module-hash -fmodules-cache-path=%t/modules-cache -fsyntax-only -isystem %t/Inputs -fbuild-session-timestamp=1390000000 -fmodules-validate-once-per-build-session %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -cc1 -fmodules -fimplicit-module-maps -fdisable-module-hash '-fmodules-cache-path=${TEST_TEMP_DIR}/fmodules-validate-once-per-build-session.c.tmp/modules-cache-user' -fsyntax-only -I ${TEST_TEMP_DIR}/fmodules-validate-once-per-build-session.c.tmp/Inputs -fbuild-session-timestamp=1390000000 -fmodules-validate-once-per-build-session ${LLVM_SRC}/llvm/tools/clang/test/Modules/fmodules-validate-once-per-build-session.c
    RUN("%clang_cc1 -cc1 -fmodules -fimplicit-module-maps -fdisable-module-hash -fmodules-cache-path=%t/modules-cache-user -fsyntax-only -I %t/Inputs -fbuild-session-timestamp=1390000000 -fmodules-validate-once-per-build-session %s");
    // ls -R ${TEST_TEMP_DIR}/fmodules-validate-once-per-build-session.c.tmp/modules-cache | grep Foo.pcm.timestamp
    RUN("ls -R %t/modules-cache")./*|*/
      I("grep Foo.pcm.timestamp");
    // ls -R ${TEST_TEMP_DIR}/fmodules-validate-once-per-build-session.c.tmp/modules-cache-user | grep Foo.pcm.timestamp
    RUN("ls -R %t/modules-cache-user")./*|*/
      I("grep Foo.pcm.timestamp");
    // cp ${TEST_TEMP_DIR}/fmodules-validate-once-per-build-session.c.tmp/modules-cache/Foo.pcm ${TEST_TEMP_DIR}/fmodules-validate-once-per-build-session.c.tmp/modules-to-compare/Foo-after.pcm
    RUN("cp %t/modules-cache/Foo.pcm %t/modules-to-compare/Foo-after.pcm");
    // cp ${TEST_TEMP_DIR}/fmodules-validate-once-per-build-session.c.tmp/modules-cache-user/Foo.pcm ${TEST_TEMP_DIR}/fmodules-validate-once-per-build-session.c.tmp/modules-to-compare/Foo-after-user.pcm
    RUN("cp %t/modules-cache-user/Foo.pcm %t/modules-to-compare/Foo-after-user.pcm");
    // diff ${TEST_TEMP_DIR}/fmodules-validate-once-per-build-session.c.tmp/modules-to-compare/Foo-before.pcm ${TEST_TEMP_DIR}/fmodules-validate-once-per-build-session.c.tmp/modules-to-compare/Foo-after.pcm
    RUN("diff %t/modules-to-compare/Foo-before.pcm %t/modules-to-compare/Foo-after.pcm");
    // diff ${TEST_TEMP_DIR}/fmodules-validate-once-per-build-session.c.tmp/modules-to-compare/Foo-before-user.pcm ${TEST_TEMP_DIR}/fmodules-validate-once-per-build-session.c.tmp/modules-to-compare/Foo-after-user.pcm
    RUN("not diff %t/modules-to-compare/Foo-before-user.pcm %t/modules-to-compare/Foo-after-user.pcm");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -cc1 -fmodules -fimplicit-module-maps -fdisable-module-hash '-fmodules-cache-path=${TEST_TEMP_DIR}/fmodules-validate-once-per-build-session.c.tmp/modules-cache' -fsyntax-only -isystem ${TEST_TEMP_DIR}/fmodules-validate-once-per-build-session.c.tmp/Inputs -fbuild-session-timestamp=1893456000 -fmodules-validate-once-per-build-session ${LLVM_SRC}/llvm/tools/clang/test/Modules/fmodules-validate-once-per-build-session.c
    RUN("%clang_cc1 -cc1 -fmodules -fimplicit-module-maps -fdisable-module-hash -fmodules-cache-path=%t/modules-cache -fsyntax-only -isystem %t/Inputs -fbuild-session-timestamp=1893456000 -fmodules-validate-once-per-build-session %s");
    // ls -R ${TEST_TEMP_DIR}/fmodules-validate-once-per-build-session.c.tmp/modules-cache | grep Foo.pcm.timestamp
    RUN("ls -R %t/modules-cache")./*|*/
      I("grep Foo.pcm.timestamp");
    // cp ${TEST_TEMP_DIR}/fmodules-validate-once-per-build-session.c.tmp/modules-cache/Foo.pcm ${TEST_TEMP_DIR}/fmodules-validate-once-per-build-session.c.tmp/modules-to-compare/Foo-after.pcm
    RUN("cp %t/modules-cache/Foo.pcm %t/modules-to-compare/Foo-after.pcm");
    // diff ${TEST_TEMP_DIR}/fmodules-validate-once-per-build-session.c.tmp/modules-to-compare/Foo-before.pcm ${TEST_TEMP_DIR}/fmodules-validate-once-per-build-session.c.tmp/modules-to-compare/Foo-after.pcm
    RUN("not diff %t/modules-to-compare/Foo-before.pcm %t/modules-to-compare/Foo-after.pcm");
  }

  @Test
  public void test_framework_name_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Modules/framework-name.m");
    // REQUIRES: shell
    if (!CHECK_REQUIRES("shell")) {
      return;
    }
    // rm -rf ${TEST_TEMP_DIR}/framework-name.m.tmp.mcp ${TEST_TEMP_DIR}/framework-name.m.tmp
    RUN(TestState.Failed, "rm -rf %t.mcp %t");
    // mkdir -p ${TEST_TEMP_DIR}/framework-name.m.tmp
    RUN(TestState.Failed, "mkdir -p %t");
    // ln -s ${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs/NameInDir2.framework ${TEST_TEMP_DIR}/framework-name.m.tmp/NameInImport.framework
    RUN(TestState.Failed, "ln -s %S/Inputs/NameInDir2.framework %t/NameInImport.framework");
    // ln -s ${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs/NameInDirInferred.framework ${TEST_TEMP_DIR}/framework-name.m.tmp/NameInImportInferred.framework
    RUN(TestState.Failed, "ln -s %S/Inputs/NameInDirInferred.framework %t/NameInImportInferred.framework");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fmodules '-fmodules-cache-path=${TEST_TEMP_DIR}/framework-name.m.tmp.mcp' -fimplicit-module-maps -I ${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs -F ${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs -F ${TEST_TEMP_DIR}/framework-name.m.tmp -Wauto-import -verify ${LLVM_SRC}/llvm/tools/clang/test/Modules/framework-name.m
    RUN(TestState.Failed, "%clang_cc1 -fmodules -fmodules-cache-path=%t.mcp -fimplicit-module-maps -I %S/Inputs -F %S/Inputs -F %t -Wauto-import -verify %s");
    // echo '@import NameInModMap' | not ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fmodules -fimplicit-module-maps '-fmodules-cache-path=${TEST_TEMP_DIR}/framework-name.m.tmp.mcp' -F ${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs -F ${TEST_TEMP_DIR}/framework-name.m.tmp -Wauto-import -x objective-c - 2>&1 | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Modules/framework-name.m
    RUN(TestState.Failed, "echo '@import NameInModMap'")./*|*/
      I("not %clang_cc1 -fmodules -fimplicit-module-maps -fmodules-cache-path=%t.mcp -F %S/Inputs -F %t -Wauto-import -x objective-c - 2>&1")./*|*/
      I("FileCheck %s");
    // echo '@import NameInDir' | not ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fmodules -fimplicit-module-maps '-fmodules-cache-path=${TEST_TEMP_DIR}/framework-name.m.tmp.mcp' -F ${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs -F ${TEST_TEMP_DIR}/framework-name.m.tmp -Wauto-import -x objective-c - 2>&1 | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Modules/framework-name.m
    RUN(TestState.Failed, "echo '@import NameInDir'")./*|*/
      I("not %clang_cc1 -fmodules -fimplicit-module-maps -fmodules-cache-path=%t.mcp -F %S/Inputs -F %t -Wauto-import -x objective-c - 2>&1")./*|*/
      I("FileCheck %s");
    // echo '@import NameInImport' | not ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fmodules -fimplicit-module-maps '-fmodules-cache-path=${TEST_TEMP_DIR}/framework-name.m.tmp.mcp' -F ${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs -F ${TEST_TEMP_DIR}/framework-name.m.tmp -Wauto-import -x objective-c - 2>&1 | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Modules/framework-name.m
    RUN(TestState.Failed, "echo '@import NameInImport'")./*|*/
      I("not %clang_cc1 -fmodules -fimplicit-module-maps -fmodules-cache-path=%t.mcp -F %S/Inputs -F %t -Wauto-import -x objective-c - 2>&1")./*|*/
      I("FileCheck %s");
    // echo '@import NameInImportInferred' | not ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fmodules -fimplicit-module-maps '-fmodules-cache-path=${TEST_TEMP_DIR}/framework-name.m.tmp.mcp' -F ${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs -F ${TEST_TEMP_DIR}/framework-name.m.tmp -Wauto-import -x objective-c - 2>&1 | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Modules/framework-name.m
    RUN(TestState.Failed, "echo '@import NameInImportInferred'")./*|*/
      I("not %clang_cc1 -fmodules -fimplicit-module-maps -fmodules-cache-path=%t.mcp -F %S/Inputs -F %t -Wauto-import -x objective-c - 2>&1")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_getSourceDescriptor_crash_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Modules/getSourceDescriptor-crash.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -I ${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs/getSourceDescriptor-crash -S -emit-llvm -debug-info-kind=limited -debugger-tuning=lldb -fimplicit-module-maps ${LLVM_SRC}/llvm/tools/clang/test/Modules/getSourceDescriptor-crash.cpp -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Modules/getSourceDescriptor-crash.cpp
    RUN(TestState.Failed, "%clang_cc1 -I %S/Inputs/getSourceDescriptor-crash -S -emit-llvm -debug-info-kind=limited -debugger-tuning=lldb -fimplicit-module-maps %s -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_global_index_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Modules/global_index.m");
    // rm -rf ${TEST_TEMP_DIR}/global_index.m.tmp
    RUN(TestState.Failed, "rm -rf %t");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -Wauto-import '-fmodules-cache-path=${TEST_TEMP_DIR}/global_index.m.tmp' -fdisable-module-hash -fmodules -fimplicit-module-maps -fno-modules-global-index -F ${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs ${LLVM_SRC}/llvm/tools/clang/test/Modules/global_index.m -verify
    RUN(TestState.Failed, "%clang_cc1 -Wauto-import -fmodules-cache-path=%t -fdisable-module-hash -fmodules -fimplicit-module-maps -fno-modules-global-index -F %S/Inputs %s -verify");
    // ls ${TEST_TEMP_DIR}/global_index.m.tmp|not grep modules.idx
    RUN(TestState.Failed, "ls %t")./*|*/
      I("not grep modules.idx");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -Wauto-import '-fmodules-cache-path=${TEST_TEMP_DIR}/global_index.m.tmp' -fdisable-module-hash -fmodules -fimplicit-module-maps -F ${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs ${LLVM_SRC}/llvm/tools/clang/test/Modules/global_index.m -verify
    RUN(TestState.Failed, "%clang_cc1 -Wauto-import -fmodules-cache-path=%t -fdisable-module-hash -fmodules -fimplicit-module-maps -F %S/Inputs %s -verify");
    // ls ${TEST_TEMP_DIR}/global_index.m.tmp|grep modules.idx
    RUN(TestState.Failed, "ls %t")./*|*/
      I("grep modules.idx");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -Wauto-import '-fmodules-cache-path=${TEST_TEMP_DIR}/global_index.m.tmp' -fdisable-module-hash -fmodules -fimplicit-module-maps -F ${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs ${LLVM_SRC}/llvm/tools/clang/test/Modules/global_index.m -verify -print-stats 2>&1 | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Modules/global_index.m
    RUN(TestState.Failed, "%clang_cc1 -Wauto-import -fmodules-cache-path=%t -fdisable-module-hash -fmodules -fimplicit-module-maps -F %S/Inputs %s -verify -print-stats 2>&1")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_header_import_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Modules/header-import.m");
    // rm -rf ${TEST_TEMP_DIR}/header-import.m.tmp
    RUN("rm -rf %t");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fmodules -fimplicit-module-maps '-fmodules-cache-path=${TEST_TEMP_DIR}/header-import.m.tmp' -F ${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs -I ${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs -verify ${LLVM_SRC}/llvm/tools/clang/test/Modules/header-import.m
    RUN("%clang_cc1 -fmodules -fimplicit-module-maps -fmodules-cache-path=%t -F %S/Inputs -I %S/Inputs -verify %s");
  }

  @Test
  public void test_header_in_multiple_maps_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Modules/header-in-multiple-maps.cpp");
    // rm -rf ${TEST_TEMP_DIR}/header-in-multiple-maps.cpp.tmp
    RUN(TestState.Failed, "rm -rf %t");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fmodules '-fmodules-cache-path=${TEST_TEMP_DIR}/header-in-multiple-maps.cpp.tmp' '-I${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs/header-in-multiple-maps' '-fmodule-map-file=${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs/header-in-multiple-maps/map1' -verify ${LLVM_SRC}/llvm/tools/clang/test/Modules/header-in-multiple-maps.cpp
    RUN(TestState.Failed, "%clang_cc1 -fmodules -fmodules-cache-path=%t -I%S/Inputs/header-in-multiple-maps -fmodule-map-file=%S/Inputs/header-in-multiple-maps/map1 -verify %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fmodules '-fmodules-cache-path=${TEST_TEMP_DIR}/header-in-multiple-maps.cpp.tmp' '-I${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs/header-in-multiple-maps' '-fmodule-map-file=${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs/header-in-multiple-maps/map2' -verify ${LLVM_SRC}/llvm/tools/clang/test/Modules/header-in-multiple-maps.cpp
    RUN(TestState.Failed, "%clang_cc1 -fmodules -fmodules-cache-path=%t -I%S/Inputs/header-in-multiple-maps -fmodule-map-file=%S/Inputs/header-in-multiple-maps/map2 -verify %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fmodules '-fmodules-cache-path=${TEST_TEMP_DIR}/header-in-multiple-maps.cpp.tmp' '-I${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs/header-in-multiple-maps' '-fmodule-map-file=${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs/header-in-multiple-maps/map3' -verify ${LLVM_SRC}/llvm/tools/clang/test/Modules/header-in-multiple-maps.cpp
    RUN(TestState.Failed, "%clang_cc1 -fmodules -fmodules-cache-path=%t -I%S/Inputs/header-in-multiple-maps -fmodule-map-file=%S/Inputs/header-in-multiple-maps/map3 -verify %s");
  }

  @Test
  public void test_hidden_definition_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Modules/hidden-definition.cpp");
    // rm -rf ${TEST_TEMP_DIR}/hidden-definition.cpp.tmp
    RUN("rm -rf %t");
    // mkdir ${TEST_TEMP_DIR}/hidden-definition.cpp.tmp
    RUN("mkdir %t");
    // echo 'struct X {}; struct Y : X { friend int f(Y); };' > ${TEST_TEMP_DIR}/hidden-definition.cpp.tmp/a.h
    RUN("echo 'struct X {}; struct Y : X { friend int f(Y); };' > %t/a.h");
    // echo 'module a { header "a.h" }' > ${TEST_TEMP_DIR}/hidden-definition.cpp.tmp/map
    RUN("echo 'module a { header \"a.h\" }' > %t/map");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fmodules -x c++ -emit-module -fmodule-name=a ${TEST_TEMP_DIR}/hidden-definition.cpp.tmp/map -o ${TEST_TEMP_DIR}/hidden-definition.cpp.tmp/a.pcm
    RUN("%clang_cc1 -fmodules -x c++ -emit-module -fmodule-name=a %t/map -o %t/a.pcm");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fmodules -x c++ -verify '-fmodule-file=${TEST_TEMP_DIR}/hidden-definition.cpp.tmp/a.pcm' ${LLVM_SRC}/llvm/tools/clang/test/Modules/hidden-definition.cpp -fno-modules-error-recovery
    RUN("%clang_cc1 -fmodules -x c++ -verify -fmodule-file=%t/a.pcm %s -fno-modules-error-recovery");
  }

  @Test
  public void test_ignored_macros_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Modules/ignored_macros.m");
    // rm -rf ${TEST_TEMP_DIR}/ignored_macros.m.tmp.modules
    RUN(TestState.Failed, "rm -rf %t.modules");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc '-fmodules-cache-path=${TEST_TEMP_DIR}/ignored_macros.m.tmp.modules' -DIGNORED=1 -fmodules -fimplicit-module-maps -I ${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs -emit-pch -o ${TEST_TEMP_DIR}/ignored_macros.m.tmp.pch -x objective-c-header ${LLVM_SRC}/llvm/tools/clang/test/Modules/ignored_macros.m -verify
    RUN(TestState.Failed, "%clang_cc1 -fmodules-cache-path=%t.modules -DIGNORED=1 -fmodules -fimplicit-module-maps -I %S/Inputs -emit-pch -o %t.pch -x objective-c-header %s -verify");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc '-fmodules-cache-path=${TEST_TEMP_DIR}/ignored_macros.m.tmp.modules' -DIGNORED=1 -fmodules -fimplicit-module-maps -I ${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs -include-pch ${TEST_TEMP_DIR}/ignored_macros.m.tmp.pch ${LLVM_SRC}/llvm/tools/clang/test/Modules/ignored_macros.m -verify
    RUN(TestState.Failed, "%clang_cc1 -fmodules-cache-path=%t.modules -DIGNORED=1 -fmodules -fimplicit-module-maps -I %S/Inputs -include-pch %t.pch %s -verify");
    // rm -rf ${TEST_TEMP_DIR}/ignored_macros.m.tmp.modules
    RUN(TestState.Failed, "rm -rf %t.modules");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc '-fmodules-cache-path=${TEST_TEMP_DIR}/ignored_macros.m.tmp.modules' -fmodules -fimplicit-module-maps -I ${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs -emit-pch -o ${TEST_TEMP_DIR}/ignored_macros.m.tmp.pch -x objective-c-header ${LLVM_SRC}/llvm/tools/clang/test/Modules/ignored_macros.m -verify
    RUN(TestState.Failed, "%clang_cc1 -fmodules-cache-path=%t.modules -fmodules -fimplicit-module-maps -I %S/Inputs -emit-pch -o %t.pch -x objective-c-header %s -verify");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc '-fmodules-cache-path=${TEST_TEMP_DIR}/ignored_macros.m.tmp.modules' -DIGNORED=1 -fmodules -fimplicit-module-maps -I ${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs -include-pch ${TEST_TEMP_DIR}/ignored_macros.m.tmp.pch ${LLVM_SRC}/llvm/tools/clang/test/Modules/ignored_macros.m > ${TEST_TEMP_DIR}/ignored_macros.m.tmp.err 2>&1
    RUN(TestState.Failed, "not %clang_cc1 -fmodules-cache-path=%t.modules -DIGNORED=1 -fmodules -fimplicit-module-maps -I %S/Inputs -include-pch %t.pch %s > %t.err 2>&1");
    // ${LLVM_SRC}/build/bin/FileCheck -check-prefix=CHECK-CONFLICT ${LLVM_SRC}/llvm/tools/clang/test/Modules/ignored_macros.m < ${TEST_TEMP_DIR}/ignored_macros.m.tmp.err
    RUN(TestState.Failed, "FileCheck -check-prefix=CHECK-CONFLICT %s < %t.err");
    // rm -rf ${TEST_TEMP_DIR}/ignored_macros.m.tmp.modules
    RUN(TestState.Failed, "rm -rf %t.modules");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc '-fmodules-cache-path=${TEST_TEMP_DIR}/ignored_macros.m.tmp.modules' -fmodules -fimplicit-module-maps -I ${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs -emit-pch -o ${TEST_TEMP_DIR}/ignored_macros.m.tmp.pch -x objective-c-header ${LLVM_SRC}/llvm/tools/clang/test/Modules/ignored_macros.m -verify
    RUN(TestState.Failed, "%clang_cc1 -fmodules-cache-path=%t.modules -fmodules -fimplicit-module-maps -I %S/Inputs -emit-pch -o %t.pch -x objective-c-header %s -verify");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc '-fmodules-cache-path=${TEST_TEMP_DIR}/ignored_macros.m.tmp.modules' -DIGNORED=1 -fmodules -fimplicit-module-maps -I ${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs -include-pch ${TEST_TEMP_DIR}/ignored_macros.m.tmp.pch -fmodules-ignore-macro=IGNORED ${LLVM_SRC}/llvm/tools/clang/test/Modules/ignored_macros.m -verify
    RUN(TestState.Failed, "%clang_cc1 -fmodules-cache-path=%t.modules -DIGNORED=1 -fmodules -fimplicit-module-maps -I %S/Inputs -include-pch %t.pch -fmodules-ignore-macro=IGNORED %s -verify");
    // rm -rf ${TEST_TEMP_DIR}/ignored_macros.m.tmp.modules
    RUN(TestState.Failed, "rm -rf %t.modules");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc '-fmodules-cache-path=${TEST_TEMP_DIR}/ignored_macros.m.tmp.modules' -DIGNORED=1 -fmodules-ignore-macro=IGNORED -fmodules -fimplicit-module-maps -I ${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs -emit-pch -o ${TEST_TEMP_DIR}/ignored_macros.m.tmp.pch -x objective-c-header ${LLVM_SRC}/llvm/tools/clang/test/Modules/ignored_macros.m -verify
    RUN(TestState.Failed, "%clang_cc1 -fmodules-cache-path=%t.modules -DIGNORED=1 -fmodules-ignore-macro=IGNORED -fmodules -fimplicit-module-maps -I %S/Inputs -emit-pch -o %t.pch -x objective-c-header %s -verify");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc '-fmodules-cache-path=${TEST_TEMP_DIR}/ignored_macros.m.tmp.modules' -DIGNORED=1 -fmodules -fimplicit-module-maps -I ${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs -include-pch ${TEST_TEMP_DIR}/ignored_macros.m.tmp.pch -fmodules-ignore-macro=IGNORED -DNO_IGNORED_ANYWHERE -fmodules-ignore-macro=NO_IGNORED_ANYWHERE ${LLVM_SRC}/llvm/tools/clang/test/Modules/ignored_macros.m -verify
    RUN(TestState.Failed, "%clang_cc1 -fmodules-cache-path=%t.modules -DIGNORED=1 -fmodules -fimplicit-module-maps -I %S/Inputs -include-pch %t.pch -fmodules-ignore-macro=IGNORED -DNO_IGNORED_ANYWHERE -fmodules-ignore-macro=NO_IGNORED_ANYWHERE %s -verify");
    // rm -rf ${TEST_TEMP_DIR}/ignored_macros.m.tmp.modules
    RUN(TestState.Failed, "rm -rf %t.modules");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc '-fmodules-cache-path=${TEST_TEMP_DIR}/ignored_macros.m.tmp.modules' -DIGNORED=1 -fmodules-ignore-macro=IGNORED=1 -fmodules -fimplicit-module-maps -I ${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs -emit-pch -o ${TEST_TEMP_DIR}/ignored_macros.m.tmp.pch -x objective-c-header ${LLVM_SRC}/llvm/tools/clang/test/Modules/ignored_macros.m -verify
    RUN(TestState.Failed, "%clang_cc1 -fmodules-cache-path=%t.modules -DIGNORED=1 -fmodules-ignore-macro=IGNORED=1 -fmodules -fimplicit-module-maps -I %S/Inputs -emit-pch -o %t.pch -x objective-c-header %s -verify");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc '-fmodules-cache-path=${TEST_TEMP_DIR}/ignored_macros.m.tmp.modules' -DIGNORED=1 -fmodules -fimplicit-module-maps -I ${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs -include-pch ${TEST_TEMP_DIR}/ignored_macros.m.tmp.pch -fmodules-ignore-macro=IGNORED=1 -DNO_IGNORED_ANYWHERE -fmodules-ignore-macro=NO_IGNORED_ANYWHERE ${LLVM_SRC}/llvm/tools/clang/test/Modules/ignored_macros.m -verify
    RUN(TestState.Failed, "%clang_cc1 -fmodules-cache-path=%t.modules -DIGNORED=1 -fmodules -fimplicit-module-maps -I %S/Inputs -include-pch %t.pch -fmodules-ignore-macro=IGNORED=1 -DNO_IGNORED_ANYWHERE -fmodules-ignore-macro=NO_IGNORED_ANYWHERE %s -verify");
  }

  @Test
  public void test_implementation_of_module_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Modules/implementation-of-module.m");
    // rm -rf ${TEST_TEMP_DIR}/implementation-of-module.m.tmp
    RUN("rm -rf %t");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fmodules -fimplicit-module-maps '-fmodules-cache-path=${TEST_TEMP_DIR}/implementation-of-module.m.tmp' -w -Werror=auto-import ${LLVM_SRC}/llvm/tools/clang/test/Modules/implementation-of-module.m -I ${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs -fmodule-implementation-of category_right -fsyntax-only
    RUN("%clang_cc1 -fmodules -fimplicit-module-maps -fmodules-cache-path=%t -w -Werror=auto-import %s -I %S/Inputs -fmodule-implementation-of category_right -fsyntax-only");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fmodules -fimplicit-module-maps '-fmodules-cache-path=${TEST_TEMP_DIR}/implementation-of-module.m.tmp' -w -Werror=auto-import ${LLVM_SRC}/llvm/tools/clang/test/Modules/implementation-of-module.m -I ${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs -fmodule-implementation-of category_right -dM -E -o - 2>&1 | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Modules/implementation-of-module.m
    RUN("%clang_cc1 -fmodules -fimplicit-module-maps -fmodules-cache-path=%t -w -Werror=auto-import %s -I %S/Inputs -fmodule-implementation-of category_right -dM -E -o - 2>&1")./*|*/
      I("FileCheck %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fmodules -fimplicit-module-maps '-fmodules-cache-path=${TEST_TEMP_DIR}/implementation-of-module.m.tmp' -w -Werror=auto-import ${LLVM_SRC}/llvm/tools/clang/test/Modules/implementation-of-module.m -I ${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs -fmodule-implementation-of category_left -verify
    RUN("%clang_cc1 -fmodules -fimplicit-module-maps -fmodules-cache-path=%t -w -Werror=auto-import %s -I %S/Inputs -fmodule-implementation-of category_left -verify");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x objective-c-header -fmodules -fimplicit-module-maps '-fmodules-cache-path=${TEST_TEMP_DIR}/implementation-of-module.m.tmp' -w -Werror=auto-import ${LLVM_SRC}/llvm/tools/clang/test/Modules/implementation-of-module.m -I ${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs -fmodule-implementation-of category_right -emit-pch -o ${TEST_TEMP_DIR}/implementation-of-module.m.tmp.pch
    RUN("%clang_cc1 -x objective-c-header -fmodules -fimplicit-module-maps -fmodules-cache-path=%t -w -Werror=auto-import %s -I %S/Inputs -fmodule-implementation-of category_right -emit-pch -o %t.pch");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x objective-c-header -fmodules -fimplicit-module-maps '-fmodules-cache-path=${TEST_TEMP_DIR}/implementation-of-module.m.tmp' -w -Werror=auto-import ${LLVM_SRC}/llvm/tools/clang/test/Modules/implementation-of-module.m -I ${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs -DWITH_PREFIX -fmodules-ignore-macro=WITH_PREFIX -include-pch ${TEST_TEMP_DIR}/implementation-of-module.m.tmp.pch -fmodule-implementation-of category_right
    RUN("%clang_cc1 -x objective-c-header -fmodules -fimplicit-module-maps -fmodules-cache-path=%t -w -Werror=auto-import %s -I %S/Inputs -DWITH_PREFIX -fmodules-ignore-macro=WITH_PREFIX -include-pch %t.pch -fmodule-implementation-of category_right");
  }

  @Test
  public void test_implicit_build_config_out_of_date_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Modules/implicit-build-config-out-of-date.m");
    // rm -rf ${TEST_TEMP_DIR}/implicit-build-config-out-of-date.m.tmp
    RUN("rm -rf %t");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fmodules '-fmodules-cache-path=${TEST_TEMP_DIR}/implicit-build-config-out-of-date.m.tmp' -fimplicit-module-maps -I ${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs ${LLVM_SRC}/llvm/tools/clang/test/Modules/implicit-build-config-out-of-date.m -DA=0 -Rmodule-build -verify
    RUN("%clang_cc1 -fmodules -fmodules-cache-path=%t -fimplicit-module-maps -I %S/Inputs %s -DA=0 -Rmodule-build -verify");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fmodules '-fmodules-cache-path=${TEST_TEMP_DIR}/implicit-build-config-out-of-date.m.tmp' -fimplicit-module-maps -I ${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs ${LLVM_SRC}/llvm/tools/clang/test/Modules/implicit-build-config-out-of-date.m -DA=0 -Werror -Rmodule-build -verify
    RUN("%clang_cc1 -fmodules -fmodules-cache-path=%t -fimplicit-module-maps -I %S/Inputs %s -DA=0 -Werror -Rmodule-build -verify");
  }

  @Test
  public void test_import_decl_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Modules/import-decl.cpp");
    // rm -rf ${TEST_TEMP_DIR}/import-decl.cpp.tmp
    RUN("rm -rf %t");
    // ${LLVM_SRC}/build/bin/clang '-fmodules-cache-path=${TEST_TEMP_DIR}/import-decl.cpp.tmp' -fmodules -x objective-c -I ${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs -emit-ast -o ${TEST_TEMP_DIR}/import-decl.cpp.tmp.ast ${LLVM_SRC}/llvm/tools/clang/test/Modules/import-decl.cpp
    RUN("%clang -fmodules-cache-path=%t -fmodules -x objective-c -I %S/Inputs -emit-ast -o %t.ast %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -ast-print -x ast - < ${TEST_TEMP_DIR}/import-decl.cpp.tmp.ast | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Modules/import-decl.cpp
    RUN("%clang_cc1 -ast-print -x ast - < %t.ast")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_import_self_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Modules/import-self.m");
    // rm -rf ${TEST_TEMP_DIR}/import-self.m.tmp
    RUN("rm -rf %t");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fmodules -fimplicit-module-maps '-fmodules-cache-path=${TEST_TEMP_DIR}/import-self.m.tmp' -I ${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs/submodules ${LLVM_SRC}/llvm/tools/clang/test/Modules/import-self.m 2>&1 | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Modules/import-self.m
    RUN("not %clang_cc1 -fmodules -fimplicit-module-maps -fmodules-cache-path=%t -I %S/Inputs/submodules %s 2>&1")./*|*/
      I("FileCheck %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fmodules -fimplicit-module-maps '-fmodules-cache-path=${TEST_TEMP_DIR}/import-self.m.tmp' -I ${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs/submodules -fmodule-name=import_self ${LLVM_SRC}/llvm/tools/clang/test/Modules/import-self.m 2>&1 | ${LLVM_SRC}/build/bin/FileCheck -check-prefix=CHECK-fmodule-name ${LLVM_SRC}/llvm/tools/clang/test/Modules/import-self.m
    RUN("not %clang_cc1 -fmodules -fimplicit-module-maps -fmodules-cache-path=%t -I %S/Inputs/submodules -fmodule-name=import_self %s 2>&1")./*|*/
      I("FileCheck -check-prefix=CHECK-fmodule-name %s");
  }

  @Test
  public void test_include_own_headers_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Modules/include-own-headers.m");
    // rm -rf ${TEST_TEMP_DIR}/include-own-headers.m.tmp
    RUN("rm -rf %t");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fmodules -fmodule-name=Module -fimplicit-module-maps '-fmodules-cache-path=${TEST_TEMP_DIR}/include-own-headers.m.tmp' -Werror=non-modular-include-in-framework-module '-F${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs' '-I${LLVM_SRC}/llvm/tools/clang/test/Modules' -fsyntax-only ${LLVM_SRC}/llvm/tools/clang/test/Modules/include-own-headers.m
    RUN("%clang_cc1 -fmodules -fmodule-name=Module -fimplicit-module-maps -fmodules-cache-path=%t -Werror=non-modular-include-in-framework-module -F%S/Inputs -I%S -fsyntax-only %s");
  }

  @Test
  public void test_include_relative_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Modules/include-relative.c");
    // rm -rf ${TEST_TEMP_DIR}/include-relative.c.tmp
    RUN(TestState.Failed, "rm -rf %t");
    // mkdir ${TEST_TEMP_DIR}/include-relative.c.tmp
    RUN(TestState.Failed, "mkdir %t");
    // cp -r ${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs/include-relative ${TEST_TEMP_DIR}/include-relative.c.tmp/include-relative
    RUN(TestState.Failed, "cp -r %S/Inputs/include-relative %t/include-relative");
    // cd ${TEST_TEMP_DIR}/include-relative.c.tmp
    RUN(TestState.Failed, "cd %t");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fmodules -fimplicit-module-maps -x c -verify '-fmodules-cache-path=${TEST_TEMP_DIR}/include-relative.c.tmp' -I include-relative ${LLVM_SRC}/llvm/tools/clang/test/Modules/include-relative.c
    RUN(TestState.Failed, "%clang_cc1 -fmodules -fimplicit-module-maps -x c -verify -fmodules-cache-path=%t -I include-relative %s");
  }

  @Test
  public void test_include_next_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Modules/include_next.c");
    // rm -rf ${TEST_TEMP_DIR}/include_next.c.tmp
    RUN("rm -rf %t");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc '-I${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs/include_next/x' '-I${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs/include_next/y' -verify ${LLVM_SRC}/llvm/tools/clang/test/Modules/include_next.c
    RUN("%clang_cc1 -I%S/Inputs/include_next/x -I%S/Inputs/include_next/y -verify %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc '-I${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs/include_next/x' '-I${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs/include_next/y' -verify ${LLVM_SRC}/llvm/tools/clang/test/Modules/include_next.c -fmodules -fimplicit-module-maps '-fmodules-cache-path=${TEST_TEMP_DIR}/include_next.c.tmp'
    RUN("%clang_cc1 -I%S/Inputs/include_next/x -I%S/Inputs/include_next/y -verify %s -fmodules -fimplicit-module-maps -fmodules-cache-path=%t");
  }

  @Test
  public void test_incomplete_module_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Modules/incomplete-module.m");
    // rm -rf ${TEST_TEMP_DIR}/incomplete-module.m.tmp
    RUN("rm -rf %t");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc '-fmodules-cache-path=${TEST_TEMP_DIR}/incomplete-module.m.tmp' -Wincomplete-module -fmodules -fimplicit-module-maps -I ${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs ${LLVM_SRC}/llvm/tools/clang/test/Modules/incomplete-module.m 2>&1 | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Modules/incomplete-module.m
    RUN("%clang_cc1 -fmodules-cache-path=%t -Wincomplete-module -fmodules -fimplicit-module-maps -I %S/Inputs %s 2>&1")./*|*/
      I("FileCheck %s");
    // rm -rf ${TEST_TEMP_DIR}/incomplete-module.m.tmp
    RUN("rm -rf %t");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc '-fmodules-cache-path=${TEST_TEMP_DIR}/incomplete-module.m.tmp' -fmodules-strict-decluse -fmodules -fimplicit-module-maps -I ${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs ${LLVM_SRC}/llvm/tools/clang/test/Modules/incomplete-module.m 2>&1 | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Modules/incomplete-module.m -check-prefix=DECLUSE
    RUN("not %clang_cc1 -fmodules-cache-path=%t -fmodules-strict-decluse -fmodules -fimplicit-module-maps -I %S/Inputs %s 2>&1")./*|*/
      I("FileCheck %s -check-prefix=DECLUSE");
  }

  @Test
  public void test_inferred_attributes_mm() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Modules/inferred-attributes.mm");
    // rm -rf ${TEST_TEMP_DIR}/inferred-attributes.mm.tmp
    RUN("rm -rf %t");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fmodules -fimplicit-module-maps '-fmodules-cache-path=${TEST_TEMP_DIR}/inferred-attributes.mm.tmp' -F ${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs/inferred-attr -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/Modules/inferred-attributes.mm
    RUN("%clang_cc1 -fmodules -fimplicit-module-maps -fmodules-cache-path=%t -F %S/Inputs/inferred-attr -fsyntax-only -verify %s");
  }

  @Test
  public void test_inferred_framework_case_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Modules/inferred-framework-case.m");
    // REQUIRES: shell
    if (!CHECK_REQUIRES("shell")) {
      return;
    }
    // rm -rf ${TEST_TEMP_DIR}/inferred-framework-case.m.tmp
    RUN("rm -rf %t");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc '-fmodules-cache-path=${TEST_TEMP_DIR}/inferred-framework-case.m.tmp' -fmodules -fimplicit-module-maps -F ${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs ${LLVM_SRC}/llvm/tools/clang/test/Modules/inferred-framework-case.m -verify -DA
    RUN("%clang_cc1 -fmodules-cache-path=%t -fmodules -fimplicit-module-maps -F %S/Inputs %s -verify -DA");
  }

  @Test
  public void test_inferred_frameworks_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Modules/inferred-frameworks.m");
    // rm -rf ${TEST_TEMP_DIR}/inferred-frameworks.m.tmp
    RUN("rm -rf %t");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x objective-c -Wauto-import '-fmodules-cache-path=${TEST_TEMP_DIR}/inferred-frameworks.m.tmp' -fmodules -fimplicit-module-maps -F ${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs ${LLVM_SRC}/llvm/tools/clang/test/Modules/inferred-frameworks.m -verify
    RUN("%clang_cc1 -x objective-c -Wauto-import -fmodules-cache-path=%t -fmodules -fimplicit-module-maps -F %S/Inputs %s -verify");
  }

  @Test
  public void test_inferred_submodules_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Modules/inferred-submodules.m");
    // rm -rf ${TEST_TEMP_DIR}/inferred-submodules.m.tmp
    RUN("rm -rf %t");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x objective-c -Wauto-import '-fmodules-cache-path=${TEST_TEMP_DIR}/inferred-submodules.m.tmp' -fmodules -fimplicit-module-maps -F ${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs ${LLVM_SRC}/llvm/tools/clang/test/Modules/inferred-submodules.m -verify
    RUN("%clang_cc1 -x objective-c -Wauto-import -fmodules-cache-path=%t -fmodules -fimplicit-module-maps -F %S/Inputs %s -verify");
  }

  @Test
  public void test_initializer_list_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Modules/initializer_list.cpp");
    // rm -rf ${TEST_TEMP_DIR}/initializer_list.cpp.tmp
    RUN(TestState.Failed, "rm -rf %t");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x objective-c++ -fmodules '-fmodules-cache-path=${TEST_TEMP_DIR}/initializer_list.cpp.tmp' -I ${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs/initializer_list '-fmodule-map-file=${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs/initializer_list/direct.modulemap' ${LLVM_SRC}/llvm/tools/clang/test/Modules/initializer_list.cpp -verify -std=c++11
    RUN(TestState.Failed, "%clang_cc1 -x objective-c++ -fmodules -fmodules-cache-path=%t -I %S/Inputs/initializer_list -fmodule-map-file=%S/Inputs/initializer_list/direct.modulemap %s -verify -std=c++11");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x objective-c++ -fmodules '-fmodules-cache-path=${TEST_TEMP_DIR}/initializer_list.cpp.tmp' -I ${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs/initializer_list '-fmodule-map-file=${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs/initializer_list/indirect.modulemap' ${LLVM_SRC}/llvm/tools/clang/test/Modules/initializer_list.cpp -verify -std=c++11 -DINCLUDE_DIRECT
    RUN(TestState.Failed, "%clang_cc1 -x objective-c++ -fmodules -fmodules-cache-path=%t -I %S/Inputs/initializer_list -fmodule-map-file=%S/Inputs/initializer_list/indirect.modulemap %s -verify -std=c++11 -DINCLUDE_DIRECT");
  }

  @Test
  public void test_internal_constants_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Modules/internal-constants.cpp");
    // rm -rf ${TEST_TEMP_DIR}/internal-constants.cpp.tmp
    RUN(TestState.Failed, "rm -rf %t");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fmodules -fimplicit-module-maps '-fmodules-cache-path=${TEST_TEMP_DIR}/internal-constants.cpp.tmp' -fmodules-local-submodule-visibility '-I${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs/internal-constants' ${LLVM_SRC}/llvm/tools/clang/test/Modules/internal-constants.cpp -verify
    RUN(TestState.Failed, "%clang_cc1 -fmodules -fimplicit-module-maps -fmodules-cache-path=%t -fmodules-local-submodule-visibility -I%S/Inputs/internal-constants %s -verify");
  }

  @Test
  public void test_invalidate_identifiers_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Modules/invalidate-identifiers.c");
    // rm -rf ${TEST_TEMP_DIR}/invalidate-identifiers.c.tmp
    RUN(TestState.Failed, "rm -rf %t");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fmodules -fimplicit-module-maps '-fmodules-cache-path=${TEST_TEMP_DIR}/invalidate-identifiers.c.tmp' '-I${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs/invalidate-identifiers' -emit-llvm-only ${LLVM_SRC}/llvm/tools/clang/test/Modules/invalidate-identifiers.c
    RUN(TestState.Failed, "%clang_cc1 -fmodules -fimplicit-module-maps -fmodules-cache-path=%t -I%S/Inputs/invalidate-identifiers -emit-llvm-only %s");
  }

  @Test
  public void test_irgen_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Modules/irgen.c");
    // REQUIRES: x86-registered-target
    if (!CHECK_REQUIRES("x86-registered-target")) {
      return;
    }
    // rm -rf ${TEST_TEMP_DIR}/irgen.c.tmp
    RUN(TestState.Failed, "rm -rf %t");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fmodules -fimplicit-module-maps -x objective-c '-fmodules-cache-path=${TEST_TEMP_DIR}/irgen.c.tmp' -emit-module -fmodule-name=irgen -triple x86_64-apple-darwin10 ${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs/module.map
    RUN(TestState.Failed, "%clang_cc1 -fmodules -fimplicit-module-maps -x objective-c -fmodules-cache-path=%t -emit-module -fmodule-name=irgen -triple x86_64-apple-darwin10 %S/Inputs/module.map");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fmodules -fimplicit-module-maps -x objective-c '-fmodules-cache-path=${TEST_TEMP_DIR}/irgen.c.tmp' -I ${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs -triple x86_64-apple-darwin10 -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/Modules/irgen.c | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Modules/irgen.c
    RUN(TestState.Failed, "%clang_cc1 -fmodules -fimplicit-module-maps -x objective-c -fmodules-cache-path=%t -I %S/Inputs -triple x86_64-apple-darwin10 -emit-llvm -o - %s")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_libstdcxx_ambiguous_internal_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Modules/libstdcxx-ambiguous-internal.cpp");
    // rm -rf ${TEST_TEMP_DIR}/libstdcxx-ambiguous-internal.cpp.tmp
    RUN("rm -rf %t");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x c++ -std=c++11 -fmodules -emit-module -fmodule-name=std '-fmodules-cache-path=${TEST_TEMP_DIR}/libstdcxx-ambiguous-internal.cpp.tmp' ${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs/libstdcxx-ambiguous-internal/module.modulemap -Werror
    RUN("%clang_cc1 -x c++ -std=c++11 -fmodules -emit-module -fmodule-name=std -fmodules-cache-path=%t %S/Inputs/libstdcxx-ambiguous-internal/module.modulemap -Werror");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x c++ -std=c++11 -fmodules -emit-module -fmodule-name=std '-fmodules-cache-path=${TEST_TEMP_DIR}/libstdcxx-ambiguous-internal.cpp.tmp' ${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs/libstdcxx-ambiguous-internal/module.modulemap -fmodules-local-submodule-visibility -DAMBIGUOUS 2>&1| ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Modules/libstdcxx-ambiguous-internal.cpp
    RUN("%clang_cc1 -x c++ -std=c++11 -fmodules -emit-module -fmodule-name=std -fmodules-cache-path=%t %S/Inputs/libstdcxx-ambiguous-internal/module.modulemap -fmodules-local-submodule-visibility -DAMBIGUOUS 2>&1")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_linkage_merge_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Modules/linkage-merge.cpp");
    // rm -rf ${TEST_TEMP_DIR}/linkage-merge.cpp.tmp
    RUN("rm -rf %t");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -verify -fmodules -fimplicit-module-maps '-fmodules-cache-path=${TEST_TEMP_DIR}/linkage-merge.cpp.tmp' -I ${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs ${LLVM_SRC}/llvm/tools/clang/test/Modules/linkage-merge.cpp
    RUN("%clang_cc1 -verify -fmodules -fimplicit-module-maps -fmodules-cache-path=%t -I %S/Inputs %s");
  }

  @Test
  public void test_linkage_merge_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Modules/linkage-merge.m");
    // rm -rf ${TEST_TEMP_DIR}/linkage-merge.m.tmp
    RUN("rm -rf %t");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fmodules -fimplicit-module-maps -x objective-c '-fmodules-cache-path=${TEST_TEMP_DIR}/linkage-merge.m.tmp' -emit-module -fmodule-name=linkage_merge_left ${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs/module.map
    RUN("%clang_cc1 -fmodules -fimplicit-module-maps -x objective-c -fmodules-cache-path=%t -emit-module -fmodule-name=linkage_merge_left %S/Inputs/module.map");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fmodules -fimplicit-module-maps '-fmodules-cache-path=${TEST_TEMP_DIR}/linkage-merge.m.tmp' -I ${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs -w ${LLVM_SRC}/llvm/tools/clang/test/Modules/linkage-merge.m -verify
    RUN("%clang_cc1 -fmodules -fimplicit-module-maps -fmodules-cache-path=%t -I %S/Inputs -w %s -verify");
  }

  @Test
  public void test_load_after_failure_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Modules/load-after-failure.m");
    // rm -rf ${TEST_TEMP_DIR}/load-after-failure.m.tmp
    RUN("rm -rf %t");
    // mkdir -p ${TEST_TEMP_DIR}/load-after-failure.m.tmp
    RUN("mkdir -p %t");
    // echo '@import B;' > ${TEST_TEMP_DIR}/load-after-failure.m.tmp/A.h
    RUN("echo '@import B;' > %t/A.h");
    // echo '@import C;' > ${TEST_TEMP_DIR}/load-after-failure.m.tmp/B.h
    RUN("echo '@import C;' > %t/B.h");
    // echo '@import D;' >> ${TEST_TEMP_DIR}/load-after-failure.m.tmp/B.h
    RUN("echo '@import D;' >> %t/B.h");
    // echo '// C.h' > ${TEST_TEMP_DIR}/load-after-failure.m.tmp/C.h
    RUN("echo '// C.h' > %t/C.h");
    // echo '// D.h' > ${TEST_TEMP_DIR}/load-after-failure.m.tmp/D.h
    RUN("echo '// D.h' > %t/D.h");
    // echo 'module A { header "A.h" }' > ${TEST_TEMP_DIR}/load-after-failure.m.tmp/module.modulemap
    RUN("echo 'module A { header \"A.h\" }' > %t/module.modulemap");
    // echo 'module B { header "B.h" }' >> ${TEST_TEMP_DIR}/load-after-failure.m.tmp/module.modulemap
    RUN("echo 'module B { header \"B.h\" }' >> %t/module.modulemap");
    // echo 'module C { header "C.h" }' >> ${TEST_TEMP_DIR}/load-after-failure.m.tmp/module.modulemap
    RUN("echo 'module C { header \"C.h\" }' >> %t/module.modulemap");
    // echo 'module D { header "D.h" }' >> ${TEST_TEMP_DIR}/load-after-failure.m.tmp/module.modulemap
    RUN("echo 'module D { header \"D.h\" }' >> %t/module.modulemap");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fmodules -fimplicit-module-maps '-fmodules-cache-path=${TEST_TEMP_DIR}/load-after-failure.m.tmp' -I ${TEST_TEMP_DIR}/load-after-failure.m.tmp ${LLVM_SRC}/llvm/tools/clang/test/Modules/load-after-failure.m -verify
    RUN("%clang_cc1 -fmodules -fimplicit-module-maps -fmodules-cache-path=%t -I %t %s -verify");
    // echo ' ' >> ${TEST_TEMP_DIR}/load-after-failure.m.tmp/D.h
    RUN("echo \" \" >> %t/D.h");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fmodules -fimplicit-module-maps '-fmodules-cache-path=${TEST_TEMP_DIR}/load-after-failure.m.tmp' -I ${TEST_TEMP_DIR}/load-after-failure.m.tmp ${LLVM_SRC}/llvm/tools/clang/test/Modules/load-after-failure.m -verify
    RUN("%clang_cc1 -fmodules -fimplicit-module-maps -fmodules-cache-path=%t -I %t %s -verify");
  }

  @Test
  public void test_load_failure_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Modules/load_failure.c");
    // rm -rf ${TEST_TEMP_DIR}/load_failure.c.tmp
    RUN("rm -rf %t");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fmodules -fimplicit-module-maps -x objective-c++ '-fmodules-cache-path=${TEST_TEMP_DIR}/load_failure.c.tmp' -fdisable-module-hash -emit-module -fmodule-name=load_failure ${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs/module.map
    RUN("%clang_cc1 -fmodules -fimplicit-module-maps -x objective-c++ -fmodules-cache-path=%t -fdisable-module-hash -emit-module -fmodule-name=load_failure %S/Inputs/module.map");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fmodules -fimplicit-module-maps -x objective-c '-fmodules-cache-path=${TEST_TEMP_DIR}/load_failure.c.tmp' -I ${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs -fdisable-module-hash ${LLVM_SRC}/llvm/tools/clang/test/Modules/load_failure.c -DNONEXISTENT 2>&1 | ${LLVM_SRC}/build/bin/FileCheck -check-prefix=CHECK-NONEXISTENT ${LLVM_SRC}/llvm/tools/clang/test/Modules/load_failure.c
    RUN("not %clang_cc1 -fmodules -fimplicit-module-maps -x objective-c -fmodules-cache-path=%t -I %S/Inputs -fdisable-module-hash %s -DNONEXISTENT 2>&1")./*|*/
      I("FileCheck -check-prefix=CHECK-NONEXISTENT %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fmodules -fimplicit-module-maps -x objective-c '-fmodules-cache-path=${TEST_TEMP_DIR}/load_failure.c.tmp' -I ${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs -fdisable-module-hash ${LLVM_SRC}/llvm/tools/clang/test/Modules/load_failure.c -DFAILURE 2> ${TEST_TEMP_DIR}/load_failure.c.tmp.out
    RUN("not %clang_cc1 -fmodules -fimplicit-module-maps -x objective-c -fmodules-cache-path=%t -I %S/Inputs -fdisable-module-hash %s -DFAILURE 2> %t.out");
    // ${LLVM_SRC}/build/bin/FileCheck -check-prefix=CHECK-FAILURE ${LLVM_SRC}/llvm/tools/clang/test/Modules/load_failure.c < ${TEST_TEMP_DIR}/load_failure.c.tmp.out
    RUN("FileCheck -check-prefix=CHECK-FAILURE %s < %t.out");
  }

  @Test
  public void test_lookup_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Modules/lookup.cpp");
    // rm -rf ${TEST_TEMP_DIR}/lookup.cpp.tmp
    RUN("rm -rf %t");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fmodules -fimplicit-module-maps -x objective-c++ -emit-module '-fmodules-cache-path=${TEST_TEMP_DIR}/lookup.cpp.tmp' -fmodule-name=lookup_left_cxx ${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs/module.map -verify
    RUN("%clang_cc1 -fmodules -fimplicit-module-maps -x objective-c++ -emit-module -fmodules-cache-path=%t -fmodule-name=lookup_left_cxx %S/Inputs/module.map -verify");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fmodules -fimplicit-module-maps -x objective-c++ -emit-module '-fmodules-cache-path=${TEST_TEMP_DIR}/lookup.cpp.tmp' -fmodule-name=lookup_right_cxx ${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs/module.map -verify
    RUN("%clang_cc1 -fmodules -fimplicit-module-maps -x objective-c++ -emit-module -fmodules-cache-path=%t -fmodule-name=lookup_right_cxx %S/Inputs/module.map -verify");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fmodules -fimplicit-module-maps -x objective-c++ '-fmodules-cache-path=${TEST_TEMP_DIR}/lookup.cpp.tmp' -I ${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs ${LLVM_SRC}/llvm/tools/clang/test/Modules/lookup.cpp -verify
    RUN("%clang_cc1 -fmodules -fimplicit-module-maps -x objective-c++ -fmodules-cache-path=%t -I %S/Inputs %s -verify");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fmodules -fimplicit-module-maps -ast-print -x objective-c++ '-fmodules-cache-path=${TEST_TEMP_DIR}/lookup.cpp.tmp' -I ${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs ${LLVM_SRC}/llvm/tools/clang/test/Modules/lookup.cpp | ${LLVM_SRC}/build/bin/FileCheck -check-prefix=CHECK-PRINT ${LLVM_SRC}/llvm/tools/clang/test/Modules/lookup.cpp
    RUN("%clang_cc1 -fmodules -fimplicit-module-maps -ast-print -x objective-c++ -fmodules-cache-path=%t -I %S/Inputs %s")./*|*/
      I("FileCheck -check-prefix=CHECK-PRINT %s");
  }

  @Test
  public void test_lookup_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Modules/lookup.m");
    // rm -rf ${TEST_TEMP_DIR}/lookup.m.tmp
    RUN(TestState.Failed, "rm -rf %t");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fmodules -fimplicit-module-maps '-fmodules-cache-path=${TEST_TEMP_DIR}/lookup.m.tmp' -emit-module -x objective-c -fmodule-name=lookup_left_objc ${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs/module.map
    RUN(TestState.Failed, "%clang_cc1 -fmodules -fimplicit-module-maps -fmodules-cache-path=%t -emit-module -x objective-c -fmodule-name=lookup_left_objc %S/Inputs/module.map");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fmodules -fimplicit-module-maps '-fmodules-cache-path=${TEST_TEMP_DIR}/lookup.m.tmp' -emit-module -x objective-c -fmodule-name=lookup_right_objc ${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs/module.map
    RUN(TestState.Failed, "%clang_cc1 -fmodules -fimplicit-module-maps -fmodules-cache-path=%t -emit-module -x objective-c -fmodule-name=lookup_right_objc %S/Inputs/module.map");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fmodules -fimplicit-module-maps -x objective-c '-fmodules-cache-path=${TEST_TEMP_DIR}/lookup.m.tmp' -I ${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs -verify ${LLVM_SRC}/llvm/tools/clang/test/Modules/lookup.m
    RUN(TestState.Failed, "%clang_cc1 -fmodules -fimplicit-module-maps -x objective-c -fmodules-cache-path=%t -I %S/Inputs -verify %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fmodules -fimplicit-module-maps -ast-print -x objective-c '-fmodules-cache-path=${TEST_TEMP_DIR}/lookup.m.tmp' -I ${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs ${LLVM_SRC}/llvm/tools/clang/test/Modules/lookup.m | ${LLVM_SRC}/build/bin/FileCheck -check-prefix=CHECK-PRINT ${LLVM_SRC}/llvm/tools/clang/test/Modules/lookup.m
    RUN(TestState.Failed, "%clang_cc1 -fmodules -fimplicit-module-maps -ast-print -x objective-c -fmodules-cache-path=%t -I %S/Inputs %s")./*|*/
      I("FileCheck -check-prefix=CHECK-PRINT %s");
  }

  @Test
  public void test_macro_ambiguity_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Modules/macro-ambiguity.cpp");
    // rm -rf ${TEST_TEMP_DIR}/macro-ambiguity.cpp.tmp
    RUN(TestState.Failed, "rm -rf %t");
    // cd ${LLVM_SRC}/llvm/tools/clang/test/Modules
    RUN(TestState.Failed, "cd %S");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fmodules -x c++ '-fmodules-cache-path=${TEST_TEMP_DIR}/macro-ambiguity.cpp.tmp' -v -iquote Inputs/macro-ambiguity/a/quote -isystem Inputs/macro-ambiguity/a/system -fno-implicit-modules -fmodule-map-file-home-is-cwd -emit-module -fmodule-name=a -o ${TEST_TEMP_DIR}/macro-ambiguity.cpp.tmp/a.pcm Inputs/macro-ambiguity/module.modulemap
    RUN(TestState.Failed, "%clang_cc1 -fmodules -x c++ -fmodules-cache-path=%t -v -iquote Inputs/macro-ambiguity/a/quote -isystem Inputs/macro-ambiguity/a/system -fno-implicit-modules -fmodule-map-file-home-is-cwd -emit-module -fmodule-name=a -o %t/a.pcm Inputs/macro-ambiguity/module.modulemap");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fmodules -x c++ '-fmodules-cache-path=${TEST_TEMP_DIR}/macro-ambiguity.cpp.tmp' -v -iquote Inputs/macro-ambiguity/b/quote -isystem Inputs/macro-ambiguity/b/system -fno-implicit-modules -fmodule-map-file-home-is-cwd -emit-module -fmodule-name=b -o ${TEST_TEMP_DIR}/macro-ambiguity.cpp.tmp/b.pcm Inputs/macro-ambiguity/module.modulemap
    RUN(TestState.Failed, "%clang_cc1 -fmodules -x c++ -fmodules-cache-path=%t -v -iquote Inputs/macro-ambiguity/b/quote -isystem Inputs/macro-ambiguity/b/system -fno-implicit-modules -fmodule-map-file-home-is-cwd -emit-module -fmodule-name=b -o %t/b.pcm Inputs/macro-ambiguity/module.modulemap");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fmodules -x c++ '-fmodules-cache-path=${TEST_TEMP_DIR}/macro-ambiguity.cpp.tmp' -v -iquote Inputs/macro-ambiguity/c/quote -isystem Inputs/macro-ambiguity/c/system -fno-implicit-modules -fmodule-map-file-home-is-cwd -emit-module -fmodule-name=c -o ${TEST_TEMP_DIR}/macro-ambiguity.cpp.tmp/c.pcm Inputs/macro-ambiguity/module.modulemap
    RUN(TestState.Failed, "%clang_cc1 -fmodules -x c++ -fmodules-cache-path=%t -v -iquote Inputs/macro-ambiguity/c/quote -isystem Inputs/macro-ambiguity/c/system -fno-implicit-modules -fmodule-map-file-home-is-cwd -emit-module -fmodule-name=c -o %t/c.pcm Inputs/macro-ambiguity/module.modulemap");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fmodules -x c++ '-fmodules-cache-path=${TEST_TEMP_DIR}/macro-ambiguity.cpp.tmp' -v -iquote Inputs/macro-ambiguity/d/quote -isystem Inputs/macro-ambiguity/d/system -fno-implicit-modules -fmodule-map-file-home-is-cwd -emit-module -fmodule-name=d -o ${TEST_TEMP_DIR}/macro-ambiguity.cpp.tmp/d.pcm Inputs/macro-ambiguity/module.modulemap
    RUN(TestState.Failed, "%clang_cc1 -fmodules -x c++ -fmodules-cache-path=%t -v -iquote Inputs/macro-ambiguity/d/quote -isystem Inputs/macro-ambiguity/d/system -fno-implicit-modules -fmodule-map-file-home-is-cwd -emit-module -fmodule-name=d -o %t/d.pcm Inputs/macro-ambiguity/module.modulemap");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fmodules -x c++ '-fmodules-cache-path=${TEST_TEMP_DIR}/macro-ambiguity.cpp.tmp' -v -iquote Inputs/macro-ambiguity/a/quote -isystem Inputs/macro-ambiguity/a/system -iquote Inputs/macro-ambiguity/b/quote -isystem Inputs/macro-ambiguity/b/system -iquote Inputs/macro-ambiguity/c/quote -isystem Inputs/macro-ambiguity/c/system -iquote Inputs/macro-ambiguity/d/quote -isystem Inputs/macro-ambiguity/d/system -iquote Inputs/macro-ambiguity/e/quote -isystem Inputs/macro-ambiguity/e/system -fno-implicit-modules -fmodule-map-file-home-is-cwd -fmodule-map-file=Inputs/macro-ambiguity/module.modulemap '-fmodule-file=${TEST_TEMP_DIR}/macro-ambiguity.cpp.tmp/a.pcm' '-fmodule-file=${TEST_TEMP_DIR}/macro-ambiguity.cpp.tmp/b.pcm' '-fmodule-file=${TEST_TEMP_DIR}/macro-ambiguity.cpp.tmp/c.pcm' '-fmodule-file=${TEST_TEMP_DIR}/macro-ambiguity.cpp.tmp/d.pcm' -Wambiguous-macro -verify macro-ambiguity.cpp
    RUN(TestState.Failed, "%clang_cc1 -fmodules -x c++ -fmodules-cache-path=%t -v -iquote Inputs/macro-ambiguity/a/quote -isystem Inputs/macro-ambiguity/a/system -iquote Inputs/macro-ambiguity/b/quote -isystem Inputs/macro-ambiguity/b/system -iquote Inputs/macro-ambiguity/c/quote -isystem Inputs/macro-ambiguity/c/system -iquote Inputs/macro-ambiguity/d/quote -isystem Inputs/macro-ambiguity/d/system -iquote Inputs/macro-ambiguity/e/quote -isystem Inputs/macro-ambiguity/e/system -fno-implicit-modules -fmodule-map-file-home-is-cwd -fmodule-map-file=Inputs/macro-ambiguity/module.modulemap -fmodule-file=%t/a.pcm -fmodule-file=%t/b.pcm -fmodule-file=%t/c.pcm -fmodule-file=%t/d.pcm -Wambiguous-macro -verify macro-ambiguity.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fmodules -x c++ '-fmodules-cache-path=${TEST_TEMP_DIR}/macro-ambiguity.cpp.tmp' -v -fmodules-local-submodule-visibility -iquote Inputs/macro-ambiguity/a/quote -isystem Inputs/macro-ambiguity/a/system -iquote Inputs/macro-ambiguity/b/quote -isystem Inputs/macro-ambiguity/b/system -iquote Inputs/macro-ambiguity/c/quote -isystem Inputs/macro-ambiguity/c/system -iquote Inputs/macro-ambiguity/d/quote -isystem Inputs/macro-ambiguity/d/system -iquote Inputs/macro-ambiguity/e/quote -isystem Inputs/macro-ambiguity/e/system -fno-implicit-modules -fmodule-map-file-home-is-cwd -fmodule-map-file=Inputs/macro-ambiguity/module.modulemap '-fmodule-file=${TEST_TEMP_DIR}/macro-ambiguity.cpp.tmp/a.pcm' '-fmodule-file=${TEST_TEMP_DIR}/macro-ambiguity.cpp.tmp/b.pcm' '-fmodule-file=${TEST_TEMP_DIR}/macro-ambiguity.cpp.tmp/c.pcm' '-fmodule-file=${TEST_TEMP_DIR}/macro-ambiguity.cpp.tmp/d.pcm' -Wambiguous-macro -verify macro-ambiguity.cpp
    RUN(TestState.Failed, "%clang_cc1 -fmodules -x c++ -fmodules-cache-path=%t -v -fmodules-local-submodule-visibility -iquote Inputs/macro-ambiguity/a/quote -isystem Inputs/macro-ambiguity/a/system -iquote Inputs/macro-ambiguity/b/quote -isystem Inputs/macro-ambiguity/b/system -iquote Inputs/macro-ambiguity/c/quote -isystem Inputs/macro-ambiguity/c/system -iquote Inputs/macro-ambiguity/d/quote -isystem Inputs/macro-ambiguity/d/system -iquote Inputs/macro-ambiguity/e/quote -isystem Inputs/macro-ambiguity/e/system -fno-implicit-modules -fmodule-map-file-home-is-cwd -fmodule-map-file=Inputs/macro-ambiguity/module.modulemap -fmodule-file=%t/a.pcm -fmodule-file=%t/b.pcm -fmodule-file=%t/c.pcm -fmodule-file=%t/d.pcm -Wambiguous-macro -verify macro-ambiguity.cpp");
  }

  @Test
  public void test_macro_hiding_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Modules/macro-hiding.cpp");
    // rm -rf ${TEST_TEMP_DIR}/macro-hiding.cpp.tmp
    RUN("rm -rf %t");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fmodules -fimplicit-module-maps '-fmodules-cache-path=${TEST_TEMP_DIR}/macro-hiding.cpp.tmp' '-I${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs/macro-hiding' ${LLVM_SRC}/llvm/tools/clang/test/Modules/macro-hiding.cpp -DD1
    RUN("%clang_cc1 -fmodules -fimplicit-module-maps -fmodules-cache-path=%t -I%S/Inputs/macro-hiding %s -DD1");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fmodules -fimplicit-module-maps '-fmodules-cache-path=${TEST_TEMP_DIR}/macro-hiding.cpp.tmp' '-I${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs/macro-hiding' ${LLVM_SRC}/llvm/tools/clang/test/Modules/macro-hiding.cpp -DC1
    RUN("%clang_cc1 -fmodules -fimplicit-module-maps -fmodules-cache-path=%t -I%S/Inputs/macro-hiding %s -DC1");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fmodules -fimplicit-module-maps '-fmodules-cache-path=${TEST_TEMP_DIR}/macro-hiding.cpp.tmp' '-I${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs/macro-hiding' ${LLVM_SRC}/llvm/tools/clang/test/Modules/macro-hiding.cpp -DC1 -DD1
    RUN("%clang_cc1 -fmodules -fimplicit-module-maps -fmodules-cache-path=%t -I%S/Inputs/macro-hiding %s -DC1 -DD1");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fmodules -fimplicit-module-maps '-fmodules-cache-path=${TEST_TEMP_DIR}/macro-hiding.cpp.tmp' '-I${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs/macro-hiding' ${LLVM_SRC}/llvm/tools/clang/test/Modules/macro-hiding.cpp -DB2
    RUN("%clang_cc1 -fmodules -fimplicit-module-maps -fmodules-cache-path=%t -I%S/Inputs/macro-hiding %s -DB2");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fmodules -fimplicit-module-maps '-fmodules-cache-path=${TEST_TEMP_DIR}/macro-hiding.cpp.tmp' '-I${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs/macro-hiding' ${LLVM_SRC}/llvm/tools/clang/test/Modules/macro-hiding.cpp -DB2 -DD1
    RUN("%clang_cc1 -fmodules -fimplicit-module-maps -fmodules-cache-path=%t -I%S/Inputs/macro-hiding %s -DB2 -DD1");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fmodules -fimplicit-module-maps '-fmodules-cache-path=${TEST_TEMP_DIR}/macro-hiding.cpp.tmp' '-I${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs/macro-hiding' ${LLVM_SRC}/llvm/tools/clang/test/Modules/macro-hiding.cpp -DB2 -DC1
    RUN("%clang_cc1 -fmodules -fimplicit-module-maps -fmodules-cache-path=%t -I%S/Inputs/macro-hiding %s -DB2 -DC1");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fmodules -fimplicit-module-maps '-fmodules-cache-path=${TEST_TEMP_DIR}/macro-hiding.cpp.tmp' '-I${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs/macro-hiding' ${LLVM_SRC}/llvm/tools/clang/test/Modules/macro-hiding.cpp -DB2 -DC1 -DD1
    RUN("%clang_cc1 -fmodules -fimplicit-module-maps -fmodules-cache-path=%t -I%S/Inputs/macro-hiding %s -DB2 -DC1 -DD1");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fmodules -fimplicit-module-maps '-fmodules-cache-path=${TEST_TEMP_DIR}/macro-hiding.cpp.tmp' '-I${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs/macro-hiding' ${LLVM_SRC}/llvm/tools/clang/test/Modules/macro-hiding.cpp -DB1
    RUN("%clang_cc1 -fmodules -fimplicit-module-maps -fmodules-cache-path=%t -I%S/Inputs/macro-hiding %s -DB1");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fmodules -fimplicit-module-maps '-fmodules-cache-path=${TEST_TEMP_DIR}/macro-hiding.cpp.tmp' '-I${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs/macro-hiding' ${LLVM_SRC}/llvm/tools/clang/test/Modules/macro-hiding.cpp -DB1 -DD1
    RUN("%clang_cc1 -fmodules -fimplicit-module-maps -fmodules-cache-path=%t -I%S/Inputs/macro-hiding %s -DB1 -DD1");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fmodules -fimplicit-module-maps '-fmodules-cache-path=${TEST_TEMP_DIR}/macro-hiding.cpp.tmp' '-I${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs/macro-hiding' ${LLVM_SRC}/llvm/tools/clang/test/Modules/macro-hiding.cpp -DB1 -DC1
    RUN("%clang_cc1 -fmodules -fimplicit-module-maps -fmodules-cache-path=%t -I%S/Inputs/macro-hiding %s -DB1 -DC1");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fmodules -fimplicit-module-maps '-fmodules-cache-path=${TEST_TEMP_DIR}/macro-hiding.cpp.tmp' '-I${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs/macro-hiding' ${LLVM_SRC}/llvm/tools/clang/test/Modules/macro-hiding.cpp -DB1 -DC1 -DD1
    RUN("%clang_cc1 -fmodules -fimplicit-module-maps -fmodules-cache-path=%t -I%S/Inputs/macro-hiding %s -DB1 -DC1 -DD1");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fmodules -fimplicit-module-maps '-fmodules-cache-path=${TEST_TEMP_DIR}/macro-hiding.cpp.tmp' '-I${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs/macro-hiding' ${LLVM_SRC}/llvm/tools/clang/test/Modules/macro-hiding.cpp -DB1 -DB2
    RUN("%clang_cc1 -fmodules -fimplicit-module-maps -fmodules-cache-path=%t -I%S/Inputs/macro-hiding %s -DB1 -DB2");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fmodules -fimplicit-module-maps '-fmodules-cache-path=${TEST_TEMP_DIR}/macro-hiding.cpp.tmp' '-I${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs/macro-hiding' ${LLVM_SRC}/llvm/tools/clang/test/Modules/macro-hiding.cpp -DB1 -DB2 -DD1
    RUN("%clang_cc1 -fmodules -fimplicit-module-maps -fmodules-cache-path=%t -I%S/Inputs/macro-hiding %s -DB1 -DB2 -DD1");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fmodules -fimplicit-module-maps '-fmodules-cache-path=${TEST_TEMP_DIR}/macro-hiding.cpp.tmp' '-I${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs/macro-hiding' ${LLVM_SRC}/llvm/tools/clang/test/Modules/macro-hiding.cpp -DB1 -DB2 -DC1
    RUN("%clang_cc1 -fmodules -fimplicit-module-maps -fmodules-cache-path=%t -I%S/Inputs/macro-hiding %s -DB1 -DB2 -DC1");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fmodules -fimplicit-module-maps '-fmodules-cache-path=${TEST_TEMP_DIR}/macro-hiding.cpp.tmp' '-I${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs/macro-hiding' ${LLVM_SRC}/llvm/tools/clang/test/Modules/macro-hiding.cpp -DB1 -DB2 -DC1 -DD1
    RUN("%clang_cc1 -fmodules -fimplicit-module-maps -fmodules-cache-path=%t -I%S/Inputs/macro-hiding %s -DB1 -DB2 -DC1 -DD1");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fmodules -fimplicit-module-maps '-fmodules-cache-path=${TEST_TEMP_DIR}/macro-hiding.cpp.tmp' '-I${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs/macro-hiding' ${LLVM_SRC}/llvm/tools/clang/test/Modules/macro-hiding.cpp -DA2
    RUN("%clang_cc1 -fmodules -fimplicit-module-maps -fmodules-cache-path=%t -I%S/Inputs/macro-hiding %s -DA2");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fmodules -fimplicit-module-maps '-fmodules-cache-path=${TEST_TEMP_DIR}/macro-hiding.cpp.tmp' '-I${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs/macro-hiding' ${LLVM_SRC}/llvm/tools/clang/test/Modules/macro-hiding.cpp -DA2 -DD1
    RUN("%clang_cc1 -fmodules -fimplicit-module-maps -fmodules-cache-path=%t -I%S/Inputs/macro-hiding %s -DA2 -DD1");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fmodules -fimplicit-module-maps '-fmodules-cache-path=${TEST_TEMP_DIR}/macro-hiding.cpp.tmp' '-I${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs/macro-hiding' ${LLVM_SRC}/llvm/tools/clang/test/Modules/macro-hiding.cpp -DA2 -DC1
    RUN("%clang_cc1 -fmodules -fimplicit-module-maps -fmodules-cache-path=%t -I%S/Inputs/macro-hiding %s -DA2 -DC1");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fmodules -fimplicit-module-maps '-fmodules-cache-path=${TEST_TEMP_DIR}/macro-hiding.cpp.tmp' '-I${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs/macro-hiding' ${LLVM_SRC}/llvm/tools/clang/test/Modules/macro-hiding.cpp -DA2 -DC1 -DD1
    RUN("%clang_cc1 -fmodules -fimplicit-module-maps -fmodules-cache-path=%t -I%S/Inputs/macro-hiding %s -DA2 -DC1 -DD1");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fmodules -fimplicit-module-maps '-fmodules-cache-path=${TEST_TEMP_DIR}/macro-hiding.cpp.tmp' '-I${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs/macro-hiding' ${LLVM_SRC}/llvm/tools/clang/test/Modules/macro-hiding.cpp -DA2 -DB2
    RUN("%clang_cc1 -fmodules -fimplicit-module-maps -fmodules-cache-path=%t -I%S/Inputs/macro-hiding %s -DA2 -DB2");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fmodules -fimplicit-module-maps '-fmodules-cache-path=${TEST_TEMP_DIR}/macro-hiding.cpp.tmp' '-I${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs/macro-hiding' ${LLVM_SRC}/llvm/tools/clang/test/Modules/macro-hiding.cpp -DA2 -DB2 -DD1
    RUN("%clang_cc1 -fmodules -fimplicit-module-maps -fmodules-cache-path=%t -I%S/Inputs/macro-hiding %s -DA2 -DB2 -DD1");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fmodules -fimplicit-module-maps '-fmodules-cache-path=${TEST_TEMP_DIR}/macro-hiding.cpp.tmp' '-I${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs/macro-hiding' ${LLVM_SRC}/llvm/tools/clang/test/Modules/macro-hiding.cpp -DA2 -DB2 -DC1
    RUN("%clang_cc1 -fmodules -fimplicit-module-maps -fmodules-cache-path=%t -I%S/Inputs/macro-hiding %s -DA2 -DB2 -DC1");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fmodules -fimplicit-module-maps '-fmodules-cache-path=${TEST_TEMP_DIR}/macro-hiding.cpp.tmp' '-I${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs/macro-hiding' ${LLVM_SRC}/llvm/tools/clang/test/Modules/macro-hiding.cpp -DA2 -DB2 -DC1 -DD1
    RUN("%clang_cc1 -fmodules -fimplicit-module-maps -fmodules-cache-path=%t -I%S/Inputs/macro-hiding %s -DA2 -DB2 -DC1 -DD1");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fmodules -fimplicit-module-maps '-fmodules-cache-path=${TEST_TEMP_DIR}/macro-hiding.cpp.tmp' '-I${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs/macro-hiding' ${LLVM_SRC}/llvm/tools/clang/test/Modules/macro-hiding.cpp -DA2 -DB1
    RUN("%clang_cc1 -fmodules -fimplicit-module-maps -fmodules-cache-path=%t -I%S/Inputs/macro-hiding %s -DA2 -DB1");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fmodules -fimplicit-module-maps '-fmodules-cache-path=${TEST_TEMP_DIR}/macro-hiding.cpp.tmp' '-I${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs/macro-hiding' ${LLVM_SRC}/llvm/tools/clang/test/Modules/macro-hiding.cpp -DA2 -DB1 -DD1
    RUN("%clang_cc1 -fmodules -fimplicit-module-maps -fmodules-cache-path=%t -I%S/Inputs/macro-hiding %s -DA2 -DB1 -DD1");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fmodules -fimplicit-module-maps '-fmodules-cache-path=${TEST_TEMP_DIR}/macro-hiding.cpp.tmp' '-I${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs/macro-hiding' ${LLVM_SRC}/llvm/tools/clang/test/Modules/macro-hiding.cpp -DA2 -DB1 -DC1
    RUN("%clang_cc1 -fmodules -fimplicit-module-maps -fmodules-cache-path=%t -I%S/Inputs/macro-hiding %s -DA2 -DB1 -DC1");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fmodules -fimplicit-module-maps '-fmodules-cache-path=${TEST_TEMP_DIR}/macro-hiding.cpp.tmp' '-I${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs/macro-hiding' ${LLVM_SRC}/llvm/tools/clang/test/Modules/macro-hiding.cpp -DA2 -DB1 -DC1 -DD1
    RUN("%clang_cc1 -fmodules -fimplicit-module-maps -fmodules-cache-path=%t -I%S/Inputs/macro-hiding %s -DA2 -DB1 -DC1 -DD1");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fmodules -fimplicit-module-maps '-fmodules-cache-path=${TEST_TEMP_DIR}/macro-hiding.cpp.tmp' '-I${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs/macro-hiding' ${LLVM_SRC}/llvm/tools/clang/test/Modules/macro-hiding.cpp -DA2 -DB1 -DB2
    RUN("%clang_cc1 -fmodules -fimplicit-module-maps -fmodules-cache-path=%t -I%S/Inputs/macro-hiding %s -DA2 -DB1 -DB2");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fmodules -fimplicit-module-maps '-fmodules-cache-path=${TEST_TEMP_DIR}/macro-hiding.cpp.tmp' '-I${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs/macro-hiding' ${LLVM_SRC}/llvm/tools/clang/test/Modules/macro-hiding.cpp -DA2 -DB1 -DB2 -DD1
    RUN("%clang_cc1 -fmodules -fimplicit-module-maps -fmodules-cache-path=%t -I%S/Inputs/macro-hiding %s -DA2 -DB1 -DB2 -DD1");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fmodules -fimplicit-module-maps '-fmodules-cache-path=${TEST_TEMP_DIR}/macro-hiding.cpp.tmp' '-I${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs/macro-hiding' ${LLVM_SRC}/llvm/tools/clang/test/Modules/macro-hiding.cpp -DA2 -DB1 -DB2 -DC1
    RUN("%clang_cc1 -fmodules -fimplicit-module-maps -fmodules-cache-path=%t -I%S/Inputs/macro-hiding %s -DA2 -DB1 -DB2 -DC1");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fmodules -fimplicit-module-maps '-fmodules-cache-path=${TEST_TEMP_DIR}/macro-hiding.cpp.tmp' '-I${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs/macro-hiding' ${LLVM_SRC}/llvm/tools/clang/test/Modules/macro-hiding.cpp -DA2 -DB1 -DB2 -DC1 -DD1
    RUN("%clang_cc1 -fmodules -fimplicit-module-maps -fmodules-cache-path=%t -I%S/Inputs/macro-hiding %s -DA2 -DB1 -DB2 -DC1 -DD1");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fmodules -fimplicit-module-maps '-fmodules-cache-path=${TEST_TEMP_DIR}/macro-hiding.cpp.tmp' '-I${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs/macro-hiding' ${LLVM_SRC}/llvm/tools/clang/test/Modules/macro-hiding.cpp -DA1
    RUN("%clang_cc1 -fmodules -fimplicit-module-maps -fmodules-cache-path=%t -I%S/Inputs/macro-hiding %s -DA1");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fmodules -fimplicit-module-maps '-fmodules-cache-path=${TEST_TEMP_DIR}/macro-hiding.cpp.tmp' '-I${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs/macro-hiding' ${LLVM_SRC}/llvm/tools/clang/test/Modules/macro-hiding.cpp -DA1 -DD1
    RUN("%clang_cc1 -fmodules -fimplicit-module-maps -fmodules-cache-path=%t -I%S/Inputs/macro-hiding %s -DA1 -DD1");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fmodules -fimplicit-module-maps '-fmodules-cache-path=${TEST_TEMP_DIR}/macro-hiding.cpp.tmp' '-I${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs/macro-hiding' ${LLVM_SRC}/llvm/tools/clang/test/Modules/macro-hiding.cpp -DA1 -DC1
    RUN("%clang_cc1 -fmodules -fimplicit-module-maps -fmodules-cache-path=%t -I%S/Inputs/macro-hiding %s -DA1 -DC1");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fmodules -fimplicit-module-maps '-fmodules-cache-path=${TEST_TEMP_DIR}/macro-hiding.cpp.tmp' '-I${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs/macro-hiding' ${LLVM_SRC}/llvm/tools/clang/test/Modules/macro-hiding.cpp -DA1 -DC1 -DD1
    RUN("%clang_cc1 -fmodules -fimplicit-module-maps -fmodules-cache-path=%t -I%S/Inputs/macro-hiding %s -DA1 -DC1 -DD1");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fmodules -fimplicit-module-maps '-fmodules-cache-path=${TEST_TEMP_DIR}/macro-hiding.cpp.tmp' '-I${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs/macro-hiding' ${LLVM_SRC}/llvm/tools/clang/test/Modules/macro-hiding.cpp -DA1 -DB2
    RUN("%clang_cc1 -fmodules -fimplicit-module-maps -fmodules-cache-path=%t -I%S/Inputs/macro-hiding %s -DA1 -DB2");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fmodules -fimplicit-module-maps '-fmodules-cache-path=${TEST_TEMP_DIR}/macro-hiding.cpp.tmp' '-I${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs/macro-hiding' ${LLVM_SRC}/llvm/tools/clang/test/Modules/macro-hiding.cpp -DA1 -DB2 -DD1
    RUN("%clang_cc1 -fmodules -fimplicit-module-maps -fmodules-cache-path=%t -I%S/Inputs/macro-hiding %s -DA1 -DB2 -DD1");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fmodules -fimplicit-module-maps '-fmodules-cache-path=${TEST_TEMP_DIR}/macro-hiding.cpp.tmp' '-I${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs/macro-hiding' ${LLVM_SRC}/llvm/tools/clang/test/Modules/macro-hiding.cpp -DA1 -DB2 -DC1
    RUN("%clang_cc1 -fmodules -fimplicit-module-maps -fmodules-cache-path=%t -I%S/Inputs/macro-hiding %s -DA1 -DB2 -DC1");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fmodules -fimplicit-module-maps '-fmodules-cache-path=${TEST_TEMP_DIR}/macro-hiding.cpp.tmp' '-I${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs/macro-hiding' ${LLVM_SRC}/llvm/tools/clang/test/Modules/macro-hiding.cpp -DA1 -DB2 -DC1 -DD1
    RUN("%clang_cc1 -fmodules -fimplicit-module-maps -fmodules-cache-path=%t -I%S/Inputs/macro-hiding %s -DA1 -DB2 -DC1 -DD1");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fmodules -fimplicit-module-maps '-fmodules-cache-path=${TEST_TEMP_DIR}/macro-hiding.cpp.tmp' '-I${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs/macro-hiding' ${LLVM_SRC}/llvm/tools/clang/test/Modules/macro-hiding.cpp -DA1 -DB1
    RUN("%clang_cc1 -fmodules -fimplicit-module-maps -fmodules-cache-path=%t -I%S/Inputs/macro-hiding %s -DA1 -DB1");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fmodules -fimplicit-module-maps '-fmodules-cache-path=${TEST_TEMP_DIR}/macro-hiding.cpp.tmp' '-I${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs/macro-hiding' ${LLVM_SRC}/llvm/tools/clang/test/Modules/macro-hiding.cpp -DA1 -DB1 -DD1
    RUN("%clang_cc1 -fmodules -fimplicit-module-maps -fmodules-cache-path=%t -I%S/Inputs/macro-hiding %s -DA1 -DB1 -DD1");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fmodules -fimplicit-module-maps '-fmodules-cache-path=${TEST_TEMP_DIR}/macro-hiding.cpp.tmp' '-I${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs/macro-hiding' ${LLVM_SRC}/llvm/tools/clang/test/Modules/macro-hiding.cpp -DA1 -DB1 -DC1
    RUN("%clang_cc1 -fmodules -fimplicit-module-maps -fmodules-cache-path=%t -I%S/Inputs/macro-hiding %s -DA1 -DB1 -DC1");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fmodules -fimplicit-module-maps '-fmodules-cache-path=${TEST_TEMP_DIR}/macro-hiding.cpp.tmp' '-I${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs/macro-hiding' ${LLVM_SRC}/llvm/tools/clang/test/Modules/macro-hiding.cpp -DA1 -DB1 -DC1 -DD1
    RUN("%clang_cc1 -fmodules -fimplicit-module-maps -fmodules-cache-path=%t -I%S/Inputs/macro-hiding %s -DA1 -DB1 -DC1 -DD1");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fmodules -fimplicit-module-maps '-fmodules-cache-path=${TEST_TEMP_DIR}/macro-hiding.cpp.tmp' '-I${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs/macro-hiding' ${LLVM_SRC}/llvm/tools/clang/test/Modules/macro-hiding.cpp -DA1 -DB1 -DB2
    RUN("%clang_cc1 -fmodules -fimplicit-module-maps -fmodules-cache-path=%t -I%S/Inputs/macro-hiding %s -DA1 -DB1 -DB2");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fmodules -fimplicit-module-maps '-fmodules-cache-path=${TEST_TEMP_DIR}/macro-hiding.cpp.tmp' '-I${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs/macro-hiding' ${LLVM_SRC}/llvm/tools/clang/test/Modules/macro-hiding.cpp -DA1 -DB1 -DB2 -DD1
    RUN("%clang_cc1 -fmodules -fimplicit-module-maps -fmodules-cache-path=%t -I%S/Inputs/macro-hiding %s -DA1 -DB1 -DB2 -DD1");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fmodules -fimplicit-module-maps '-fmodules-cache-path=${TEST_TEMP_DIR}/macro-hiding.cpp.tmp' '-I${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs/macro-hiding' ${LLVM_SRC}/llvm/tools/clang/test/Modules/macro-hiding.cpp -DA1 -DB1 -DB2 -DC1
    RUN("%clang_cc1 -fmodules -fimplicit-module-maps -fmodules-cache-path=%t -I%S/Inputs/macro-hiding %s -DA1 -DB1 -DB2 -DC1");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fmodules -fimplicit-module-maps '-fmodules-cache-path=${TEST_TEMP_DIR}/macro-hiding.cpp.tmp' '-I${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs/macro-hiding' ${LLVM_SRC}/llvm/tools/clang/test/Modules/macro-hiding.cpp -DA1 -DB1 -DB2 -DC1 -DD1
    RUN("%clang_cc1 -fmodules -fimplicit-module-maps -fmodules-cache-path=%t -I%S/Inputs/macro-hiding %s -DA1 -DB1 -DB2 -DC1 -DD1");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fmodules -fimplicit-module-maps '-fmodules-cache-path=${TEST_TEMP_DIR}/macro-hiding.cpp.tmp' '-I${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs/macro-hiding' ${LLVM_SRC}/llvm/tools/clang/test/Modules/macro-hiding.cpp -DA1 -DA2
    RUN("%clang_cc1 -fmodules -fimplicit-module-maps -fmodules-cache-path=%t -I%S/Inputs/macro-hiding %s -DA1 -DA2");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fmodules -fimplicit-module-maps '-fmodules-cache-path=${TEST_TEMP_DIR}/macro-hiding.cpp.tmp' '-I${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs/macro-hiding' ${LLVM_SRC}/llvm/tools/clang/test/Modules/macro-hiding.cpp -DA1 -DA2 -DD1
    RUN("%clang_cc1 -fmodules -fimplicit-module-maps -fmodules-cache-path=%t -I%S/Inputs/macro-hiding %s -DA1 -DA2 -DD1");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fmodules -fimplicit-module-maps '-fmodules-cache-path=${TEST_TEMP_DIR}/macro-hiding.cpp.tmp' '-I${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs/macro-hiding' ${LLVM_SRC}/llvm/tools/clang/test/Modules/macro-hiding.cpp -DA1 -DA2 -DC1
    RUN("%clang_cc1 -fmodules -fimplicit-module-maps -fmodules-cache-path=%t -I%S/Inputs/macro-hiding %s -DA1 -DA2 -DC1");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fmodules -fimplicit-module-maps '-fmodules-cache-path=${TEST_TEMP_DIR}/macro-hiding.cpp.tmp' '-I${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs/macro-hiding' ${LLVM_SRC}/llvm/tools/clang/test/Modules/macro-hiding.cpp -DA1 -DA2 -DC1 -DD1
    RUN("%clang_cc1 -fmodules -fimplicit-module-maps -fmodules-cache-path=%t -I%S/Inputs/macro-hiding %s -DA1 -DA2 -DC1 -DD1");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fmodules -fimplicit-module-maps '-fmodules-cache-path=${TEST_TEMP_DIR}/macro-hiding.cpp.tmp' '-I${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs/macro-hiding' ${LLVM_SRC}/llvm/tools/clang/test/Modules/macro-hiding.cpp -DA1 -DA2 -DB2
    RUN("%clang_cc1 -fmodules -fimplicit-module-maps -fmodules-cache-path=%t -I%S/Inputs/macro-hiding %s -DA1 -DA2 -DB2");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fmodules -fimplicit-module-maps '-fmodules-cache-path=${TEST_TEMP_DIR}/macro-hiding.cpp.tmp' '-I${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs/macro-hiding' ${LLVM_SRC}/llvm/tools/clang/test/Modules/macro-hiding.cpp -DA1 -DA2 -DB2 -DD1
    RUN("%clang_cc1 -fmodules -fimplicit-module-maps -fmodules-cache-path=%t -I%S/Inputs/macro-hiding %s -DA1 -DA2 -DB2 -DD1");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fmodules -fimplicit-module-maps '-fmodules-cache-path=${TEST_TEMP_DIR}/macro-hiding.cpp.tmp' '-I${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs/macro-hiding' ${LLVM_SRC}/llvm/tools/clang/test/Modules/macro-hiding.cpp -DA1 -DA2 -DB2 -DC1
    RUN("%clang_cc1 -fmodules -fimplicit-module-maps -fmodules-cache-path=%t -I%S/Inputs/macro-hiding %s -DA1 -DA2 -DB2 -DC1");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fmodules -fimplicit-module-maps '-fmodules-cache-path=${TEST_TEMP_DIR}/macro-hiding.cpp.tmp' '-I${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs/macro-hiding' ${LLVM_SRC}/llvm/tools/clang/test/Modules/macro-hiding.cpp -DA1 -DA2 -DB2 -DC1 -DD1
    RUN("%clang_cc1 -fmodules -fimplicit-module-maps -fmodules-cache-path=%t -I%S/Inputs/macro-hiding %s -DA1 -DA2 -DB2 -DC1 -DD1");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fmodules -fimplicit-module-maps '-fmodules-cache-path=${TEST_TEMP_DIR}/macro-hiding.cpp.tmp' '-I${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs/macro-hiding' ${LLVM_SRC}/llvm/tools/clang/test/Modules/macro-hiding.cpp -DA1 -DA2 -DB1
    RUN("%clang_cc1 -fmodules -fimplicit-module-maps -fmodules-cache-path=%t -I%S/Inputs/macro-hiding %s -DA1 -DA2 -DB1");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fmodules -fimplicit-module-maps '-fmodules-cache-path=${TEST_TEMP_DIR}/macro-hiding.cpp.tmp' '-I${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs/macro-hiding' ${LLVM_SRC}/llvm/tools/clang/test/Modules/macro-hiding.cpp -DA1 -DA2 -DB1 -DD1
    RUN("%clang_cc1 -fmodules -fimplicit-module-maps -fmodules-cache-path=%t -I%S/Inputs/macro-hiding %s -DA1 -DA2 -DB1 -DD1");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fmodules -fimplicit-module-maps '-fmodules-cache-path=${TEST_TEMP_DIR}/macro-hiding.cpp.tmp' '-I${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs/macro-hiding' ${LLVM_SRC}/llvm/tools/clang/test/Modules/macro-hiding.cpp -DA1 -DA2 -DB1 -DC1
    RUN("%clang_cc1 -fmodules -fimplicit-module-maps -fmodules-cache-path=%t -I%S/Inputs/macro-hiding %s -DA1 -DA2 -DB1 -DC1");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fmodules -fimplicit-module-maps '-fmodules-cache-path=${TEST_TEMP_DIR}/macro-hiding.cpp.tmp' '-I${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs/macro-hiding' ${LLVM_SRC}/llvm/tools/clang/test/Modules/macro-hiding.cpp -DA1 -DA2 -DB1 -DC1 -DD1
    RUN("%clang_cc1 -fmodules -fimplicit-module-maps -fmodules-cache-path=%t -I%S/Inputs/macro-hiding %s -DA1 -DA2 -DB1 -DC1 -DD1");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fmodules -fimplicit-module-maps '-fmodules-cache-path=${TEST_TEMP_DIR}/macro-hiding.cpp.tmp' '-I${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs/macro-hiding' ${LLVM_SRC}/llvm/tools/clang/test/Modules/macro-hiding.cpp -DA1 -DA2 -DB1 -DB2
    RUN("%clang_cc1 -fmodules -fimplicit-module-maps -fmodules-cache-path=%t -I%S/Inputs/macro-hiding %s -DA1 -DA2 -DB1 -DB2");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fmodules -fimplicit-module-maps '-fmodules-cache-path=${TEST_TEMP_DIR}/macro-hiding.cpp.tmp' '-I${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs/macro-hiding' ${LLVM_SRC}/llvm/tools/clang/test/Modules/macro-hiding.cpp -DA1 -DA2 -DB1 -DB2 -DD1
    RUN("%clang_cc1 -fmodules -fimplicit-module-maps -fmodules-cache-path=%t -I%S/Inputs/macro-hiding %s -DA1 -DA2 -DB1 -DB2 -DD1");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fmodules -fimplicit-module-maps '-fmodules-cache-path=${TEST_TEMP_DIR}/macro-hiding.cpp.tmp' '-I${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs/macro-hiding' ${LLVM_SRC}/llvm/tools/clang/test/Modules/macro-hiding.cpp -DA1 -DA2 -DB1 -DB2 -DC1
    RUN("%clang_cc1 -fmodules -fimplicit-module-maps -fmodules-cache-path=%t -I%S/Inputs/macro-hiding %s -DA1 -DA2 -DB1 -DB2 -DC1");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fmodules -fimplicit-module-maps '-fmodules-cache-path=${TEST_TEMP_DIR}/macro-hiding.cpp.tmp' '-I${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs/macro-hiding' ${LLVM_SRC}/llvm/tools/clang/test/Modules/macro-hiding.cpp -DA1 -DA2 -DB1 -DB2 -DC1 -DD1
    RUN("%clang_cc1 -fmodules -fimplicit-module-maps -fmodules-cache-path=%t -I%S/Inputs/macro-hiding %s -DA1 -DA2 -DB1 -DB2 -DC1 -DD1");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fmodules -fimplicit-module-maps '-fmodules-cache-path=${TEST_TEMP_DIR}/macro-hiding.cpp.tmp' '-I${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs/macro-hiding' ${LLVM_SRC}/llvm/tools/clang/test/Modules/macro-hiding.cpp -DE1
    RUN("%clang_cc1 -fmodules -fimplicit-module-maps -fmodules-cache-path=%t -I%S/Inputs/macro-hiding %s -DE1");
  }

  @Test
  public void test_macro_masking_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Modules/macro-masking.cpp");
    // rm -rf ${TEST_TEMP_DIR}/macro-masking.cpp.tmp
    RUN("rm -rf %t");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -fmodules -fimplicit-module-maps ${LLVM_SRC}/llvm/tools/clang/test/Modules/macro-masking.cpp '-fmodules-cache-path=${TEST_TEMP_DIR}/macro-masking.cpp.tmp' -verify '-I${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs/macro-masking'
    RUN("%clang_cc1 -fsyntax-only -fmodules -fimplicit-module-maps %s -fmodules-cache-path=%t -verify -I%S/Inputs/macro-masking");
  }

  @Test
  public void test_macro_reexport_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Modules/macro-reexport.cpp");
    // rm -rf ${TEST_TEMP_DIR}/macro-reexport.cpp.tmp
    RUN(TestState.Failed, "rm -rf %t");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -DC1 '-I${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs/macro-reexport' ${LLVM_SRC}/llvm/tools/clang/test/Modules/macro-reexport.cpp '-fmodules-cache-path=${TEST_TEMP_DIR}/macro-reexport.cpp.tmp' -verify
    RUN(TestState.Failed, "%clang_cc1 -fsyntax-only -DC1 -I%S/Inputs/macro-reexport %s -fmodules-cache-path=%t -verify");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -DC1 '-I${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs/macro-reexport' -fmodules -fimplicit-module-maps ${LLVM_SRC}/llvm/tools/clang/test/Modules/macro-reexport.cpp '-fmodules-cache-path=${TEST_TEMP_DIR}/macro-reexport.cpp.tmp' -verify
    RUN(TestState.Failed, "%clang_cc1 -fsyntax-only -DC1 -I%S/Inputs/macro-reexport -fmodules -fimplicit-module-maps %s -fmodules-cache-path=%t -verify");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -DD1 '-I${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs/macro-reexport' ${LLVM_SRC}/llvm/tools/clang/test/Modules/macro-reexport.cpp '-fmodules-cache-path=${TEST_TEMP_DIR}/macro-reexport.cpp.tmp' -verify
    RUN(TestState.Failed, "%clang_cc1 -fsyntax-only -DD1 -I%S/Inputs/macro-reexport %s -fmodules-cache-path=%t -verify");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -DD1 '-I${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs/macro-reexport' -fmodules -fimplicit-module-maps ${LLVM_SRC}/llvm/tools/clang/test/Modules/macro-reexport.cpp '-fmodules-cache-path=${TEST_TEMP_DIR}/macro-reexport.cpp.tmp' -verify
    RUN(TestState.Failed, "%clang_cc1 -fsyntax-only -DD1 -I%S/Inputs/macro-reexport -fmodules -fimplicit-module-maps %s -fmodules-cache-path=%t -verify");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -DD2 '-I${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs/macro-reexport' ${LLVM_SRC}/llvm/tools/clang/test/Modules/macro-reexport.cpp '-fmodules-cache-path=${TEST_TEMP_DIR}/macro-reexport.cpp.tmp' -verify
    RUN(TestState.Failed, "%clang_cc1 -fsyntax-only -DD2 -I%S/Inputs/macro-reexport %s -fmodules-cache-path=%t -verify");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -DD2 '-I${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs/macro-reexport' -fmodules -fimplicit-module-maps ${LLVM_SRC}/llvm/tools/clang/test/Modules/macro-reexport.cpp '-fmodules-cache-path=${TEST_TEMP_DIR}/macro-reexport.cpp.tmp' -verify
    RUN(TestState.Failed, "%clang_cc1 -fsyntax-only -DD2 -I%S/Inputs/macro-reexport -fmodules -fimplicit-module-maps %s -fmodules-cache-path=%t -verify");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -DF1 '-I${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs/macro-reexport' ${LLVM_SRC}/llvm/tools/clang/test/Modules/macro-reexport.cpp '-fmodules-cache-path=${TEST_TEMP_DIR}/macro-reexport.cpp.tmp' -verify
    RUN(TestState.Failed, "%clang_cc1 -fsyntax-only -DF1 -I%S/Inputs/macro-reexport %s -fmodules-cache-path=%t -verify");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -DF1 '-I${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs/macro-reexport' -fmodules -fimplicit-module-maps ${LLVM_SRC}/llvm/tools/clang/test/Modules/macro-reexport.cpp '-fmodules-cache-path=${TEST_TEMP_DIR}/macro-reexport.cpp.tmp' -verify
    RUN(TestState.Failed, "%clang_cc1 -fsyntax-only -DF1 -I%S/Inputs/macro-reexport -fmodules -fimplicit-module-maps %s -fmodules-cache-path=%t -verify");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fmodules-local-submodule-visibility -fsyntax-only -DC1 '-I${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs/macro-reexport' ${LLVM_SRC}/llvm/tools/clang/test/Modules/macro-reexport.cpp '-fmodules-cache-path=${TEST_TEMP_DIR}/macro-reexport.cpp.tmp' -verify
    RUN(TestState.Failed, "%clang_cc1 -fmodules-local-submodule-visibility -fsyntax-only -DC1 -I%S/Inputs/macro-reexport %s -fmodules-cache-path=%t -verify");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fmodules-local-submodule-visibility -fsyntax-only -DC1 '-I${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs/macro-reexport' -fmodules -fimplicit-module-maps ${LLVM_SRC}/llvm/tools/clang/test/Modules/macro-reexport.cpp '-fmodules-cache-path=${TEST_TEMP_DIR}/macro-reexport.cpp.tmp' -verify
    RUN(TestState.Failed, "%clang_cc1 -fmodules-local-submodule-visibility -fsyntax-only -DC1 -I%S/Inputs/macro-reexport -fmodules -fimplicit-module-maps %s -fmodules-cache-path=%t -verify");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fmodules-local-submodule-visibility -fsyntax-only -DD1 '-I${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs/macro-reexport' ${LLVM_SRC}/llvm/tools/clang/test/Modules/macro-reexport.cpp '-fmodules-cache-path=${TEST_TEMP_DIR}/macro-reexport.cpp.tmp' -verify
    RUN(TestState.Failed, "%clang_cc1 -fmodules-local-submodule-visibility -fsyntax-only -DD1 -I%S/Inputs/macro-reexport %s -fmodules-cache-path=%t -verify");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fmodules-local-submodule-visibility -fsyntax-only -DD1 '-I${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs/macro-reexport' -fmodules -fimplicit-module-maps ${LLVM_SRC}/llvm/tools/clang/test/Modules/macro-reexport.cpp '-fmodules-cache-path=${TEST_TEMP_DIR}/macro-reexport.cpp.tmp' -verify
    RUN(TestState.Failed, "%clang_cc1 -fmodules-local-submodule-visibility -fsyntax-only -DD1 -I%S/Inputs/macro-reexport -fmodules -fimplicit-module-maps %s -fmodules-cache-path=%t -verify");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fmodules-local-submodule-visibility -fsyntax-only -DD2 '-I${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs/macro-reexport' ${LLVM_SRC}/llvm/tools/clang/test/Modules/macro-reexport.cpp '-fmodules-cache-path=${TEST_TEMP_DIR}/macro-reexport.cpp.tmp' -verify
    RUN(TestState.Failed, "%clang_cc1 -fmodules-local-submodule-visibility -fsyntax-only -DD2 -I%S/Inputs/macro-reexport %s -fmodules-cache-path=%t -verify");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fmodules-local-submodule-visibility -fsyntax-only -DD2 '-I${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs/macro-reexport' -fmodules -fimplicit-module-maps ${LLVM_SRC}/llvm/tools/clang/test/Modules/macro-reexport.cpp '-fmodules-cache-path=${TEST_TEMP_DIR}/macro-reexport.cpp.tmp' -verify
    RUN(TestState.Failed, "%clang_cc1 -fmodules-local-submodule-visibility -fsyntax-only -DD2 -I%S/Inputs/macro-reexport -fmodules -fimplicit-module-maps %s -fmodules-cache-path=%t -verify");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fmodules-local-submodule-visibility -fsyntax-only -DF1 '-I${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs/macro-reexport' ${LLVM_SRC}/llvm/tools/clang/test/Modules/macro-reexport.cpp '-fmodules-cache-path=${TEST_TEMP_DIR}/macro-reexport.cpp.tmp' -verify
    RUN(TestState.Failed, "%clang_cc1 -fmodules-local-submodule-visibility -fsyntax-only -DF1 -I%S/Inputs/macro-reexport %s -fmodules-cache-path=%t -verify");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fmodules-local-submodule-visibility -fsyntax-only -DF1 '-I${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs/macro-reexport' -fmodules -fimplicit-module-maps ${LLVM_SRC}/llvm/tools/clang/test/Modules/macro-reexport.cpp '-fmodules-cache-path=${TEST_TEMP_DIR}/macro-reexport.cpp.tmp' -verify
    RUN(TestState.Failed, "%clang_cc1 -fmodules-local-submodule-visibility -fsyntax-only -DF1 -I%S/Inputs/macro-reexport -fmodules -fimplicit-module-maps %s -fmodules-cache-path=%t -verify");
  }

  @Test
  public void test_macro_undef_through_pch_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Modules/macro-undef-through-pch.m");
    // rm -rf ${TEST_TEMP_DIR}/macro-undef-through-pch.m.tmp
    RUN("rm -rf %t");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x objective-c-header -fmodules -fimplicit-module-maps '-fmodules-cache-path=${TEST_TEMP_DIR}/macro-undef-through-pch.m.tmp' '-I${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs/macro-undef-through-pch' -emit-pch ${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs/macro-undef-through-pch/foo.h -o ${TEST_TEMP_DIR}/macro-undef-through-pch.m.tmp.pch
    RUN("%clang_cc1 -x objective-c-header -fmodules -fimplicit-module-maps -fmodules-cache-path=%t -I%S/Inputs/macro-undef-through-pch -emit-pch %S/Inputs/macro-undef-through-pch/foo.h -o %t.pch");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x objective-c -fmodules -fimplicit-module-maps '-fmodules-cache-path=${TEST_TEMP_DIR}/macro-undef-through-pch.m.tmp' '-I${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs/macro-undef-through-pch' -emit-pch -include-pch ${TEST_TEMP_DIR}/macro-undef-through-pch.m.tmp.pch ${LLVM_SRC}/llvm/tools/clang/test/Modules/macro-undef-through-pch.m
    RUN("%clang_cc1 -x objective-c -fmodules -fimplicit-module-maps -fmodules-cache-path=%t -I%S/Inputs/macro-undef-through-pch -emit-pch -include-pch %t.pch %s");
  }

  @Test
  public void test_macros_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Modules/macros.c");
    // rm -rf ${TEST_TEMP_DIR}/macros.c.tmp
    RUN(TestState.Failed, "rm -rf %t");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fmodules -fimplicit-module-maps -x objective-c -verify '-fmodules-cache-path=${TEST_TEMP_DIR}/macros.c.tmp' -I ${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs ${LLVM_SRC}/llvm/tools/clang/test/Modules/macros.c
    RUN(TestState.Failed, "%clang_cc1 -fmodules -fimplicit-module-maps -x objective-c -verify -fmodules-cache-path=%t -I %S/Inputs %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fmodules -fimplicit-module-maps -x objective-c -verify '-fmodules-cache-path=${TEST_TEMP_DIR}/macros.c.tmp' -I ${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs ${LLVM_SRC}/llvm/tools/clang/test/Modules/macros.c -DALT
    RUN(TestState.Failed, "%clang_cc1 -fmodules -fimplicit-module-maps -x objective-c -verify -fmodules-cache-path=%t -I %S/Inputs %s -DALT");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fmodules -fimplicit-module-maps -x objective-c -verify '-fmodules-cache-path=${TEST_TEMP_DIR}/macros.c.tmp' -I ${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs ${LLVM_SRC}/llvm/tools/clang/test/Modules/macros.c -detailed-preprocessing-record
    RUN(TestState.Failed, "%clang_cc1 -fmodules -fimplicit-module-maps -x objective-c -verify -fmodules-cache-path=%t -I %S/Inputs %s -detailed-preprocessing-record");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -E -fmodules -fimplicit-module-maps -x objective-c '-fmodules-cache-path=${TEST_TEMP_DIR}/macros.c.tmp' -I ${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs ${LLVM_SRC}/llvm/tools/clang/test/Modules/macros.c | ${LLVM_SRC}/build/bin/FileCheck -check-prefix CHECK-PREPROCESSED ${LLVM_SRC}/llvm/tools/clang/test/Modules/macros.c
    RUN(TestState.Failed, "not %clang_cc1 -E -fmodules -fimplicit-module-maps -x objective-c -fmodules-cache-path=%t -I %S/Inputs %s")./*|*/
      I("FileCheck -check-prefix CHECK-PREPROCESSED %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fmodules -fimplicit-module-maps -x objective-c++ -verify '-fmodules-cache-path=${TEST_TEMP_DIR}/macros.c.tmp' -I ${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs ${LLVM_SRC}/llvm/tools/clang/test/Modules/macros.c
    RUN(TestState.Failed, "%clang_cc1 -fmodules -fimplicit-module-maps -x objective-c++ -verify -fmodules-cache-path=%t -I %S/Inputs %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fmodules -fimplicit-module-maps -x objective-c++ -verify '-fmodules-cache-path=${TEST_TEMP_DIR}/macros.c.tmp' -I ${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs ${LLVM_SRC}/llvm/tools/clang/test/Modules/macros.c -DALT
    RUN(TestState.Failed, "%clang_cc1 -fmodules -fimplicit-module-maps -x objective-c++ -verify -fmodules-cache-path=%t -I %S/Inputs %s -DALT");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fmodules -fimplicit-module-maps -x objective-c++ -verify '-fmodules-cache-path=${TEST_TEMP_DIR}/macros.c.tmp' -I ${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs ${LLVM_SRC}/llvm/tools/clang/test/Modules/macros.c -detailed-preprocessing-record
    RUN(TestState.Failed, "%clang_cc1 -fmodules -fimplicit-module-maps -x objective-c++ -verify -fmodules-cache-path=%t -I %S/Inputs %s -detailed-preprocessing-record");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -E -fmodules -fimplicit-module-maps -x objective-c++ '-fmodules-cache-path=${TEST_TEMP_DIR}/macros.c.tmp' -I ${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs ${LLVM_SRC}/llvm/tools/clang/test/Modules/macros.c | ${LLVM_SRC}/build/bin/FileCheck -check-prefix CHECK-PREPROCESSED ${LLVM_SRC}/llvm/tools/clang/test/Modules/macros.c
    RUN(TestState.Failed, "not %clang_cc1 -E -fmodules -fimplicit-module-maps -x objective-c++ -fmodules-cache-path=%t -I %S/Inputs %s")./*|*/
      I("FileCheck -check-prefix CHECK-PREPROCESSED %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fmodules -fimplicit-module-maps -DLOCAL_VISIBILITY -fmodules-local-submodule-visibility -x objective-c++ -verify '-fmodules-cache-path=${TEST_TEMP_DIR}/macros.c.tmp' -I ${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs ${LLVM_SRC}/llvm/tools/clang/test/Modules/macros.c
    RUN(TestState.Failed, "%clang_cc1 -fmodules -fimplicit-module-maps -DLOCAL_VISIBILITY -fmodules-local-submodule-visibility -x objective-c++ -verify -fmodules-cache-path=%t -I %S/Inputs %s");
  }

  @Test
  public void test_macros2_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Modules/macros2.c");
    // rm -rf ${TEST_TEMP_DIR}/macros2.c.tmp
    RUN(TestState.Failed, "rm -rf %t");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fmodules -fimplicit-module-maps -x objective-c -verify '-fmodules-cache-path=${TEST_TEMP_DIR}/macros2.c.tmp' -I ${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs ${LLVM_SRC}/llvm/tools/clang/test/Modules/macros2.c
    RUN(TestState.Failed, "%clang_cc1 -fmodules -fimplicit-module-maps -x objective-c -verify -fmodules-cache-path=%t -I %S/Inputs %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fmodules -fimplicit-module-maps -fmodules-local-submodule-visibility -x objective-c++ -verify '-fmodules-cache-path=${TEST_TEMP_DIR}/macros2.c.tmp' -I ${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs ${LLVM_SRC}/llvm/tools/clang/test/Modules/macros2.c -DLOCAL_VISIBILITY
    RUN(TestState.Failed, "%clang_cc1 -fmodules -fimplicit-module-maps -fmodules-local-submodule-visibility -x objective-c++ -verify -fmodules-cache-path=%t -I %S/Inputs %s -DLOCAL_VISIBILITY");
  }

  @Test
  public void test_malformed_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Modules/malformed.cpp");
    // rm -rf ${TEST_TEMP_DIR}/malformed.cpp.tmp
    RUN(TestState.Failed, "rm -rf %t");
    // cd ${LLVM_SRC}/llvm/tools/clang/test/Modules
    RUN(TestState.Failed, "cd %S");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fmodules -fimplicit-module-maps '-fmodules-cache-path=${TEST_TEMP_DIR}/malformed.cpp.tmp' -I Inputs/malformed '-DHEADER="a1.h"' ${LLVM_SRC}/llvm/tools/clang/test/Modules/malformed.cpp 2>&1 | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Modules/malformed.cpp --check-prefix=CHECK-A
    RUN(TestState.Failed, "not %clang_cc1 -fmodules -fimplicit-module-maps -fmodules-cache-path=%t -I Inputs/malformed -DHEADER=\"a1.h\" %s 2>&1")./*|*/
      I("FileCheck %s --check-prefix=CHECK-A");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fmodules -fimplicit-module-maps '-fmodules-cache-path=${TEST_TEMP_DIR}/malformed.cpp.tmp' -I Inputs/malformed '-DHEADER="b1.h"' ${LLVM_SRC}/llvm/tools/clang/test/Modules/malformed.cpp 2>&1 | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Modules/malformed.cpp --check-prefix=CHECK-B
    RUN(TestState.Failed, "not %clang_cc1 -fmodules -fimplicit-module-maps -fmodules-cache-path=%t -I Inputs/malformed -DHEADER=\"b1.h\" %s 2>&1")./*|*/
      I("FileCheck %s --check-prefix=CHECK-B");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fmodules -fimplicit-module-maps '-fmodules-cache-path=${TEST_TEMP_DIR}/malformed.cpp.tmp' -I Inputs/malformed '-DHEADER="c.h"' malformed.cpp 2>&1 | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Modules/malformed.cpp --check-prefix=CHECK-C
    RUN(TestState.Failed, "not %clang_cc1 -fmodules -fimplicit-module-maps -fmodules-cache-path=%t -I Inputs/malformed -DHEADER=\"c.h\" malformed.cpp 2>&1")./*|*/
      I("FileCheck %s --check-prefix=CHECK-C");
  }

  @Test
  public void test_merge_anon_in_template_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Modules/merge-anon-in-template.cpp");
    // rm -rf ${TEST_TEMP_DIR}/merge-anon-in-template.cpp.tmp
    RUN(TestState.Failed, "rm -rf %t");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fmodules -fimplicit-module-maps '-fmodules-cache-path=${TEST_TEMP_DIR}/merge-anon-in-template.cpp.tmp' '-I${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs/merge-anon-in-template' -verify ${LLVM_SRC}/llvm/tools/clang/test/Modules/merge-anon-in-template.cpp
    RUN(TestState.Failed, "%clang_cc1 -fmodules -fimplicit-module-maps -fmodules-cache-path=%t -I%S/Inputs/merge-anon-in-template -verify %s");
  }

  @Test
  public void test_merge_class_definition_visibility_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Modules/merge-class-definition-visibility.cpp");
    // rm -rf ${TEST_TEMP_DIR}/merge-class-definition-visibility.cpp.tmp
    RUN("rm -rf %t");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fmodules '-fmodule-map-file=${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs/merge-class-definition-visibility/modmap' '-I${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs/merge-class-definition-visibility' '-fmodules-cache-path=${TEST_TEMP_DIR}/merge-class-definition-visibility.cpp.tmp' ${LLVM_SRC}/llvm/tools/clang/test/Modules/merge-class-definition-visibility.cpp -verify -fmodules-local-submodule-visibility
    RUN("%clang_cc1 -fmodules -fmodule-map-file=%S/Inputs/merge-class-definition-visibility/modmap -I%S/Inputs/merge-class-definition-visibility -fmodules-cache-path=%t %s -verify -fmodules-local-submodule-visibility");
  }

  @Test
  public void test_merge_decl_context_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Modules/merge-decl-context.cpp");
    // rm -rf ${TEST_TEMP_DIR}/merge-decl-context.cpp.tmp
    RUN(TestState.Failed, "rm -rf %t");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x c++ -std=c++11 -fmodules -fimplicit-module-maps -fmodule-name=b -o ${TEST_TEMP_DIR}/merge-decl-context.cpp.tmp/b.pcm -emit-module ${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs/merge-decl-context/merge-decl-context.modulemap '-I${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs' -I ${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs/merge-decl-context
    RUN(TestState.Failed, "%clang_cc1 -x c++ -std=c++11 -fmodules -fimplicit-module-maps -fmodule-name=b -o %t/b.pcm -emit-module %S/Inputs/merge-decl-context/merge-decl-context.modulemap -I%S/Inputs -I %S/Inputs/merge-decl-context");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x c++ -std=c++11 -fmodules -fimplicit-module-maps -fmodule-name=c -o ${TEST_TEMP_DIR}/merge-decl-context.cpp.tmp/c.pcm '-fmodule-file=${TEST_TEMP_DIR}/merge-decl-context.cpp.tmp/b.pcm' -fno-implicit-modules -emit-module ${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs/merge-decl-context/merge-decl-context.modulemap '-I${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs' -I ${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs/merge-decl-context
    RUN(TestState.Failed, "%clang_cc1 -x c++ -std=c++11 -fmodules -fimplicit-module-maps -fmodule-name=c -o %t/c.pcm -fmodule-file=%t/b.pcm -fno-implicit-modules -emit-module %S/Inputs/merge-decl-context/merge-decl-context.modulemap -I%S/Inputs -I %S/Inputs/merge-decl-context");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x c++ -std=c++11 -fmodules -fimplicit-module-maps -fmodule-name=d -o ${TEST_TEMP_DIR}/merge-decl-context.cpp.tmp/d.pcm '-fmodule-file=${TEST_TEMP_DIR}/merge-decl-context.cpp.tmp/b.pcm' -fno-implicit-modules -emit-module ${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs/merge-decl-context/merge-decl-context.modulemap '-I${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs' -I ${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs/merge-decl-context
    RUN(TestState.Failed, "%clang_cc1 -x c++ -std=c++11 -fmodules -fimplicit-module-maps -fmodule-name=d -o %t/d.pcm -fmodule-file=%t/b.pcm -fno-implicit-modules -emit-module %S/Inputs/merge-decl-context/merge-decl-context.modulemap -I%S/Inputs -I %S/Inputs/merge-decl-context");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x c++ -std=c++11 -fmodules -fimplicit-module-maps '-fmodule-file=${TEST_TEMP_DIR}/merge-decl-context.cpp.tmp/c.pcm' '-fmodule-file=${TEST_TEMP_DIR}/merge-decl-context.cpp.tmp/b.pcm' '-fmodule-file=${TEST_TEMP_DIR}/merge-decl-context.cpp.tmp/d.pcm' -fno-implicit-modules '-fmodule-map-file=${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs/merge-decl-context/merge-decl-context.modulemap' '-I${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs' -emit-llvm -o ${TEST_TEMP_DIR}/merge-decl-context.cpp.tmp/test.o ${LLVM_SRC}/llvm/tools/clang/test/Modules/merge-decl-context.cpp
    RUN(TestState.Failed, "%clang_cc1 -x c++ -std=c++11 -fmodules -fimplicit-module-maps -fmodule-file=%t/c.pcm -fmodule-file=%t/b.pcm -fmodule-file=%t/d.pcm -fno-implicit-modules -fmodule-map-file=%S/Inputs/merge-decl-context/merge-decl-context.modulemap -I%S/Inputs -emit-llvm -o %t/test.o %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x c++ -std=c++11 -fmodules '-fmodules-cache-path=${TEST_TEMP_DIR}/merge-decl-context.cpp.tmp' '-fmodule-map-file=${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs/merge-decl-context/merge-decl-context.modulemap' '-I${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs' -emit-llvm -o ${TEST_TEMP_DIR}/merge-decl-context.cpp.tmp/test.o -DNO_TEXTUAL_INCLUSION ${LLVM_SRC}/llvm/tools/clang/test/Modules/merge-decl-context.cpp
    RUN(TestState.Failed, "%clang_cc1 -x c++ -std=c++11 -fmodules -fmodules-cache-path=%t -fmodule-map-file=%S/Inputs/merge-decl-context/merge-decl-context.modulemap -I%S/Inputs -emit-llvm -o %t/test.o -DNO_TEXTUAL_INCLUSION %s");
  }

  @Test
  public void test_merge_decl_order_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Modules/merge-decl-order.cpp");
    // rm -rf ${TEST_TEMP_DIR}/merge-decl-order.cpp.tmp
    RUN(TestState.Failed, "rm -rf %t");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fmodules -fimplicit-module-maps '-fmodules-cache-path=${TEST_TEMP_DIR}/merge-decl-order.cpp.tmp' '-I${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs/merge-decl-order' -verify ${LLVM_SRC}/llvm/tools/clang/test/Modules/merge-decl-order.cpp
    RUN(TestState.Failed, "%clang_cc1 -fmodules -fimplicit-module-maps -fmodules-cache-path=%t -I%S/Inputs/merge-decl-order -verify %s");
  }

  @Test
  public void test_merge_dependent_friends_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Modules/merge-dependent-friends.cpp");
    // rm -rf ${TEST_TEMP_DIR}/merge-dependent-friends.cpp.tmp
    RUN(TestState.Failed, "rm -rf %t");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fmodules -fimplicit-module-maps '-fmodules-cache-path=${TEST_TEMP_DIR}/merge-dependent-friends.cpp.tmp' '-I${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs/merge-dependent-friends' -verify ${LLVM_SRC}/llvm/tools/clang/test/Modules/merge-dependent-friends.cpp
    RUN(TestState.Failed, "%clang_cc1 -fmodules -fimplicit-module-maps -fmodules-cache-path=%t -I%S/Inputs/merge-dependent-friends -verify %s");
  }

  @Test
  public void test_merge_enumerators_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Modules/merge-enumerators.cpp");
    // rm -rf ${TEST_TEMP_DIR}/merge-enumerators.cpp.tmp
    RUN(TestState.Failed, "rm -rf %t");
    // mkdir ${TEST_TEMP_DIR}/merge-enumerators.cpp.tmp
    RUN(TestState.Failed, "mkdir %t");
    // echo 'namespace N { enum E { A }; }' > ${TEST_TEMP_DIR}/merge-enumerators.cpp.tmp/a.h
    RUN(TestState.Failed, "echo 'namespace N { enum E { A }; }' > %t/a.h");
    // echo '#include "a.h"' > ${TEST_TEMP_DIR}/merge-enumerators.cpp.tmp/b.h
    RUN(TestState.Failed, "echo '#include \"a.h\"' > %t/b.h");
    // touch ${TEST_TEMP_DIR}/merge-enumerators.cpp.tmp/x.h
    RUN(TestState.Failed, "touch %t/x.h");
    // echo 'module B { module b { header "b.h" } module x { header "x.h" } }' > ${TEST_TEMP_DIR}/merge-enumerators.cpp.tmp/b.modulemap
    RUN(TestState.Failed, "echo 'module B { module b { header \"b.h\" } module x { header \"x.h\" } }' > %t/b.modulemap");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fmodules '-fmodules-cache-path=${TEST_TEMP_DIR}/merge-enumerators.cpp.tmp' -x c++ '-fmodule-map-file=${TEST_TEMP_DIR}/merge-enumerators.cpp.tmp/b.modulemap' ${LLVM_SRC}/llvm/tools/clang/test/Modules/merge-enumerators.cpp '-I${TEST_TEMP_DIR}/merge-enumerators.cpp.tmp' -verify -fmodules-local-submodule-visibility
    RUN(TestState.Failed, "%clang_cc1 -fmodules -fmodules-cache-path=%t -x c++ -fmodule-map-file=%t/b.modulemap %s -I%t -verify -fmodules-local-submodule-visibility");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fmodules '-fmodules-cache-path=${TEST_TEMP_DIR}/merge-enumerators.cpp.tmp' -x c++ '-fmodule-map-file=${TEST_TEMP_DIR}/merge-enumerators.cpp.tmp/b.modulemap' ${LLVM_SRC}/llvm/tools/clang/test/Modules/merge-enumerators.cpp '-I${TEST_TEMP_DIR}/merge-enumerators.cpp.tmp' -verify -fmodules-local-submodule-visibility -DMERGE_LATE
    RUN(TestState.Failed, "%clang_cc1 -fmodules -fmodules-cache-path=%t -x c++ -fmodule-map-file=%t/b.modulemap %s -I%t -verify -fmodules-local-submodule-visibility -DMERGE_LATE");
  }

  @Test
  public void test_merge_friends_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Modules/merge-friends.cpp");
    // rm -rf ${TEST_TEMP_DIR}/merge-friends.cpp.tmp
    RUN(TestState.Failed, "rm -rf %t");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fmodules -fimplicit-module-maps '-fmodules-cache-path=${TEST_TEMP_DIR}/merge-friends.cpp.tmp' '-I${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs/merge-friends' -verify ${LLVM_SRC}/llvm/tools/clang/test/Modules/merge-friends.cpp
    RUN(TestState.Failed, "%clang_cc1 -fmodules -fimplicit-module-maps -fmodules-cache-path=%t -I%S/Inputs/merge-friends -verify %s");
  }

  @Test
  public void test_merge_implicit_special_members_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Modules/merge-implicit-special-members.cpp");
    // rm -rf ${TEST_TEMP_DIR}/merge-implicit-special-members.cpp.tmp
    RUN(TestState.Failed, "rm -rf %t");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fmodules -fimplicit-module-maps '-fmodules-cache-path=${TEST_TEMP_DIR}/merge-implicit-special-members.cpp.tmp' '-I${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs/merge-implicit-special-members' -verify ${LLVM_SRC}/llvm/tools/clang/test/Modules/merge-implicit-special-members.cpp
    RUN(TestState.Failed, "%clang_cc1 -fmodules -fimplicit-module-maps -fmodules-cache-path=%t -I%S/Inputs/merge-implicit-special-members -verify %s");
  }

  @Test
  public void test_merge_name_for_linkage_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Modules/merge-name-for-linkage.cpp");
    // rm -rf ${TEST_TEMP_DIR}/merge-name-for-linkage.cpp.tmp
    RUN(TestState.Failed, "rm -rf %t");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fmodules -fimplicit-module-maps '-fmodules-cache-path=${TEST_TEMP_DIR}/merge-name-for-linkage.cpp.tmp' '-I${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs/merge-name-for-linkage' -verify ${LLVM_SRC}/llvm/tools/clang/test/Modules/merge-name-for-linkage.cpp
    RUN(TestState.Failed, "%clang_cc1 -fmodules -fimplicit-module-maps -fmodules-cache-path=%t -I%S/Inputs/merge-name-for-linkage -verify %s");
  }

  @Test
  public void test_merge_nested_templates_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Modules/merge-nested-templates.cpp");
    // rm -rf ${TEST_TEMP_DIR}/merge-nested-templates.cpp.tmp
    RUN(TestState.Failed, "rm -rf %t");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fmodules -fimplicit-module-maps '-fmodules-cache-path=${TEST_TEMP_DIR}/merge-nested-templates.cpp.tmp' '-I${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs/merge-nested-templates' -verify ${LLVM_SRC}/llvm/tools/clang/test/Modules/merge-nested-templates.cpp
    RUN(TestState.Failed, "%clang_cc1 -fmodules -fimplicit-module-maps -fmodules-cache-path=%t -I%S/Inputs/merge-nested-templates -verify %s");
  }

  @Test
  public void test_merge_target_features_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Modules/merge-target-features.cpp");
    // REQUIRES: x86-registered-target
    if (!CHECK_REQUIRES("x86-registered-target")) {
      return;
    }
    // rm -rf ${TEST_TEMP_DIR}/merge-target-features.cpp.tmp
    RUN(TestState.Failed, "rm -rf %t");
    // cd ${LLVM_SRC}/llvm/tools/clang/test/Modules
    RUN(TestState.Failed, "cd %S");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fmodules -x c++ '-fmodules-cache-path=${TEST_TEMP_DIR}/merge-target-features.cpp.tmp' -iquote Inputs/merge-target-features -fno-implicit-modules -fmodule-map-file-home-is-cwd -emit-module -fmodule-name=foo -o ${TEST_TEMP_DIR}/merge-target-features.cpp.tmp/foo.pcm -triple i386-unknown-unknown -target-cpu i386 -target-feature +sse2 Inputs/merge-target-features/module.modulemap
    RUN(TestState.Failed, "%clang_cc1 -fmodules -x c++ -fmodules-cache-path=%t -iquote Inputs/merge-target-features -fno-implicit-modules -fmodule-map-file-home-is-cwd -emit-module -fmodule-name=foo -o %t/foo.pcm -triple i386-unknown-unknown -target-cpu i386 -target-feature +sse2 Inputs/merge-target-features/module.modulemap");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fmodules -x c++ '-fmodules-cache-path=${TEST_TEMP_DIR}/merge-target-features.cpp.tmp' -iquote Inputs/merge-target-features -fno-implicit-modules -fmodule-map-file-home-is-cwd -fmodule-map-file=Inputs/merge-target-features/module.modulemap '-fmodule-file=${TEST_TEMP_DIR}/merge-target-features.cpp.tmp/foo.pcm' -triple i386-unknown-unknown -target-cpu i386 -fsyntax-only merge-target-features.cpp 2>&1 | ${LLVM_SRC}/build/bin/FileCheck --check-prefix=SUBSET ${LLVM_SRC}/llvm/tools/clang/test/Modules/merge-target-features.cpp
    RUN(TestState.Failed, "not %clang_cc1 -fmodules -x c++ -fmodules-cache-path=%t -iquote Inputs/merge-target-features -fno-implicit-modules -fmodule-map-file-home-is-cwd -fmodule-map-file=Inputs/merge-target-features/module.modulemap -fmodule-file=%t/foo.pcm -triple i386-unknown-unknown -target-cpu i386 -fsyntax-only merge-target-features.cpp 2>&1")./*|*/
      I("FileCheck --check-prefix=SUBSET %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fmodules -x c++ '-fmodules-cache-path=${TEST_TEMP_DIR}/merge-target-features.cpp.tmp' -iquote Inputs/merge-target-features -fno-implicit-modules -fmodule-map-file-home-is-cwd -fmodule-map-file=Inputs/merge-target-features/module.modulemap '-fmodule-file=${TEST_TEMP_DIR}/merge-target-features.cpp.tmp/foo.pcm' -triple i386-unknown-unknown -target-cpu i386 -target-feature +sse2 -fsyntax-only merge-target-features.cpp 2>&1 | ${LLVM_SRC}/build/bin/FileCheck --allow-empty --check-prefix=SAME ${LLVM_SRC}/llvm/tools/clang/test/Modules/merge-target-features.cpp
    RUN(TestState.Failed, "%clang_cc1 -fmodules -x c++ -fmodules-cache-path=%t -iquote Inputs/merge-target-features -fno-implicit-modules -fmodule-map-file-home-is-cwd -fmodule-map-file=Inputs/merge-target-features/module.modulemap -fmodule-file=%t/foo.pcm -triple i386-unknown-unknown -target-cpu i386 -target-feature +sse2 -fsyntax-only merge-target-features.cpp 2>&1")./*|*/
      I("FileCheck --allow-empty --check-prefix=SAME %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fmodules -x c++ '-fmodules-cache-path=${TEST_TEMP_DIR}/merge-target-features.cpp.tmp' -iquote Inputs/merge-target-features -fno-implicit-modules -fmodule-map-file-home-is-cwd -fmodule-map-file=Inputs/merge-target-features/module.modulemap '-fmodule-file=${TEST_TEMP_DIR}/merge-target-features.cpp.tmp/foo.pcm' -triple i386-unknown-unknown -target-cpu i386 -target-feature +sse2 -target-feature +sse3 -fsyntax-only merge-target-features.cpp 2>&1 | ${LLVM_SRC}/build/bin/FileCheck --allow-empty --check-prefix=SUPERSET ${LLVM_SRC}/llvm/tools/clang/test/Modules/merge-target-features.cpp
    RUN(TestState.Failed, "%clang_cc1 -fmodules -x c++ -fmodules-cache-path=%t -iquote Inputs/merge-target-features -fno-implicit-modules -fmodule-map-file-home-is-cwd -fmodule-map-file=Inputs/merge-target-features/module.modulemap -fmodule-file=%t/foo.pcm -triple i386-unknown-unknown -target-cpu i386 -target-feature +sse2 -target-feature +sse3 -fsyntax-only merge-target-features.cpp 2>&1")./*|*/
      I("FileCheck --allow-empty --check-prefix=SUPERSET %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fmodules -x c++ '-fmodules-cache-path=${TEST_TEMP_DIR}/merge-target-features.cpp.tmp' -iquote Inputs/merge-target-features -fno-implicit-modules -fmodule-map-file-home-is-cwd -fmodule-map-file=Inputs/merge-target-features/module.modulemap '-fmodule-file=${TEST_TEMP_DIR}/merge-target-features.cpp.tmp/foo.pcm' -triple i386-unknown-unknown -target-cpu i386 -target-feature +cx16 -fsyntax-only merge-target-features.cpp 2>&1 | ${LLVM_SRC}/build/bin/FileCheck --check-prefix=MISMATCH ${LLVM_SRC}/llvm/tools/clang/test/Modules/merge-target-features.cpp
    RUN(TestState.Failed, "not %clang_cc1 -fmodules -x c++ -fmodules-cache-path=%t -iquote Inputs/merge-target-features -fno-implicit-modules -fmodule-map-file-home-is-cwd -fmodule-map-file=Inputs/merge-target-features/module.modulemap -fmodule-file=%t/foo.pcm -triple i386-unknown-unknown -target-cpu i386 -target-feature +cx16 -fsyntax-only merge-target-features.cpp 2>&1")./*|*/
      I("FileCheck --check-prefix=MISMATCH %s");
  }

  @Test
  public void test_merge_template_friend_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Modules/merge-template-friend.cpp");
    // rm -rf ${TEST_TEMP_DIR}/merge-template-friend.cpp.tmp
    RUN(TestState.Failed, "rm -rf %t");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fmodules -fimplicit-module-maps -x c++ '-fmodules-cache-path=${TEST_TEMP_DIR}/merge-template-friend.cpp.tmp' -emit-module -fmodule-name=a -o ${TEST_TEMP_DIR}/merge-template-friend.cpp.tmp/a.pcm ${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs/merge-template-friend/module.modulemap
    RUN(TestState.Failed, "%clang_cc1 -fmodules -fimplicit-module-maps -x c++ -fmodules-cache-path=%t -emit-module -fmodule-name=a -o %t/a.pcm %S/Inputs/merge-template-friend/module.modulemap");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fmodules -fimplicit-module-maps -x c++ '-fmodules-cache-path=${TEST_TEMP_DIR}/merge-template-friend.cpp.tmp' -emit-module -fmodule-name=b -o ${TEST_TEMP_DIR}/merge-template-friend.cpp.tmp/b.pcm ${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs/merge-template-friend/module.modulemap
    RUN(TestState.Failed, "%clang_cc1 -fmodules -fimplicit-module-maps -x c++ -fmodules-cache-path=%t -emit-module -fmodule-name=b -o %t/b.pcm %S/Inputs/merge-template-friend/module.modulemap");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fmodules -fimplicit-module-maps -x c++ '-fmodules-cache-path=${TEST_TEMP_DIR}/merge-template-friend.cpp.tmp' '-I${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs/merge-template-friend' '-fmodule-file=${TEST_TEMP_DIR}/merge-template-friend.cpp.tmp/a.pcm' '-fmodule-file=${TEST_TEMP_DIR}/merge-template-friend.cpp.tmp/b.pcm' -verify ${LLVM_SRC}/llvm/tools/clang/test/Modules/merge-template-friend.cpp
    RUN(TestState.Failed, "%clang_cc1 -fmodules -fimplicit-module-maps -x c++ -fmodules-cache-path=%t -I%S/Inputs/merge-template-friend -fmodule-file=%t/a.pcm -fmodule-file=%t/b.pcm -verify %s");
  }

  @Test
  public void test_merge_template_members_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Modules/merge-template-members.cpp");
    // rm -rf ${TEST_TEMP_DIR}/merge-template-members.cpp.tmp
    RUN(TestState.Failed, "rm -rf %t");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fmodules -fimplicit-module-maps '-fmodules-cache-path=${TEST_TEMP_DIR}/merge-template-members.cpp.tmp' '-I${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs/merge-template-members' -verify -emit-llvm-only ${LLVM_SRC}/llvm/tools/clang/test/Modules/merge-template-members.cpp -DTEST=1
    RUN(TestState.Failed, "%clang_cc1 -fmodules -fimplicit-module-maps -fmodules-cache-path=%t -I%S/Inputs/merge-template-members -verify -emit-llvm-only %s -DTEST=1");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fmodules -fimplicit-module-maps '-fmodules-cache-path=${TEST_TEMP_DIR}/merge-template-members.cpp.tmp' '-I${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs/merge-template-members' -verify -emit-llvm-only ${LLVM_SRC}/llvm/tools/clang/test/Modules/merge-template-members.cpp -DTEST=2
    RUN(TestState.Failed, "%clang_cc1 -fmodules -fimplicit-module-maps -fmodules-cache-path=%t -I%S/Inputs/merge-template-members -verify -emit-llvm-only %s -DTEST=2");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fmodules -fimplicit-module-maps '-fmodules-cache-path=${TEST_TEMP_DIR}/merge-template-members.cpp.tmp' '-I${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs/merge-template-members' -verify -emit-llvm-only ${LLVM_SRC}/llvm/tools/clang/test/Modules/merge-template-members.cpp -DTEST=3
    RUN(TestState.Failed, "%clang_cc1 -fmodules -fimplicit-module-maps -fmodules-cache-path=%t -I%S/Inputs/merge-template-members -verify -emit-llvm-only %s -DTEST=3");
  }

  @Test
  public void test_merge_template_pattern_visibility_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Modules/merge-template-pattern-visibility.cpp");
    // rm -rf ${TEST_TEMP_DIR}/merge-template-pattern-visibility.cpp.tmp
    RUN("rm -rf %t");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fmodules '-fmodules-cache-path=${TEST_TEMP_DIR}/merge-template-pattern-visibility.cpp.tmp' -fno-modules-error-recovery -fmodule-name=X -emit-module ${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs/merge-template-pattern-visibility/module.modulemap -x c++ -fmodules-local-submodule-visibility
    RUN("%clang_cc1 -fmodules -fmodules-cache-path=%t -fno-modules-error-recovery -fmodule-name=X -emit-module %S/Inputs/merge-template-pattern-visibility/module.modulemap -x c++ -fmodules-local-submodule-visibility");
  }

  @Test
  public void test_merge_typedefs_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Modules/merge-typedefs.cpp");
    // rm -rf ${TEST_TEMP_DIR}/merge-typedefs.cpp.tmp
    RUN("rm -rf %t");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x c++ '-I${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs/merge-typedefs' -verify ${LLVM_SRC}/llvm/tools/clang/test/Modules/merge-typedefs.cpp
    RUN("%clang_cc1 -x c++ -I%S/Inputs/merge-typedefs -verify %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fmodules -fimplicit-module-maps '-fmodules-cache-path=${TEST_TEMP_DIR}/merge-typedefs.cpp.tmp' -x c++ '-I${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs/merge-typedefs' -verify ${LLVM_SRC}/llvm/tools/clang/test/Modules/merge-typedefs.cpp
    RUN("%clang_cc1 -fmodules -fimplicit-module-maps -fmodules-cache-path=%t -x c++ -I%S/Inputs/merge-typedefs -verify %s");
  }

  @Test
  public void test_merge_using_decls_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Modules/merge-using-decls.cpp");
    // rm -rf ${TEST_TEMP_DIR}/merge-using-decls.cpp.tmp
    RUN(TestState.Failed, "rm -rf %t");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fmodules -fimplicit-module-maps '-fmodules-cache-path=${TEST_TEMP_DIR}/merge-using-decls.cpp.tmp' -x c++ '-I${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs/merge-using-decls' -verify ${LLVM_SRC}/llvm/tools/clang/test/Modules/merge-using-decls.cpp -DORDER=1
    RUN(TestState.Failed, "%clang_cc1 -fmodules -fimplicit-module-maps -fmodules-cache-path=%t -x c++ -I%S/Inputs/merge-using-decls -verify %s -DORDER=1");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fmodules -fimplicit-module-maps '-fmodules-cache-path=${TEST_TEMP_DIR}/merge-using-decls.cpp.tmp' -x c++ '-I${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs/merge-using-decls' -verify ${LLVM_SRC}/llvm/tools/clang/test/Modules/merge-using-decls.cpp -DORDER=2
    RUN(TestState.Failed, "%clang_cc1 -fmodules -fimplicit-module-maps -fmodules-cache-path=%t -x c++ -I%S/Inputs/merge-using-decls -verify %s -DORDER=2");
  }

  @Test
  public void test_merge_vtable_codegen_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Modules/merge-vtable-codegen.cpp");
    // rm -rf ${TEST_TEMP_DIR}/merge-vtable-codegen.cpp.tmp
    RUN(TestState.Failed, "rm -rf %t");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x c++ -std=c++11 -fmodules -fimplicit-module-maps -fmodule-name=b -o ${TEST_TEMP_DIR}/merge-vtable-codegen.cpp.tmp/b.pcm -emit-module ${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs/merge-vtable-codegen/merge-vtable-codegen.modulemap -I ${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs/merge-vtable-codegen
    RUN(TestState.Failed, "%clang_cc1 -x c++ -std=c++11 -fmodules -fimplicit-module-maps -fmodule-name=b -o %t/b.pcm -emit-module %S/Inputs/merge-vtable-codegen/merge-vtable-codegen.modulemap -I %S/Inputs/merge-vtable-codegen");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x c++ -std=c++11 -fmodules -fimplicit-module-maps -fmodule-name=c -o ${TEST_TEMP_DIR}/merge-vtable-codegen.cpp.tmp/c.pcm -emit-module ${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs/merge-vtable-codegen/merge-vtable-codegen.modulemap -I ${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs/merge-vtable-codegen
    RUN(TestState.Failed, "%clang_cc1 -x c++ -std=c++11 -fmodules -fimplicit-module-maps -fmodule-name=c -o %t/c.pcm -emit-module %S/Inputs/merge-vtable-codegen/merge-vtable-codegen.modulemap -I %S/Inputs/merge-vtable-codegen");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x c++ -std=c++11 -fmodules -fimplicit-module-maps '-fmodule-file=${TEST_TEMP_DIR}/merge-vtable-codegen.cpp.tmp/b.pcm' '-fmodule-file=${TEST_TEMP_DIR}/merge-vtable-codegen.cpp.tmp/c.pcm' '-fmodule-map-file=${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs/merge-vtable-codegen/merge-vtable-codegen.modulemap' -emit-llvm -o ${TEST_TEMP_DIR}/merge-vtable-codegen.cpp.tmp/test.o ${LLVM_SRC}/llvm/tools/clang/test/Modules/merge-vtable-codegen.cpp
    RUN(TestState.Failed, "%clang_cc1 -x c++ -std=c++11 -fmodules -fimplicit-module-maps -fmodule-file=%t/b.pcm -fmodule-file=%t/c.pcm -fmodule-map-file=%S/Inputs/merge-vtable-codegen/merge-vtable-codegen.modulemap -emit-llvm -o %t/test.o %s");
  }

  @Test
  public void test_method_pool_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Modules/method_pool.m");
    // rm -rf ${TEST_TEMP_DIR}/method_pool.m.tmp
    RUN(TestState.Failed, "rm -rf %t");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc '-fmodules-cache-path=${TEST_TEMP_DIR}/method_pool.m.tmp' -fmodules -fimplicit-module-maps -I ${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs ${LLVM_SRC}/llvm/tools/clang/test/Modules/method_pool.m -verify
    RUN(TestState.Failed, "%clang_cc1 -fmodules-cache-path=%t -fmodules -fimplicit-module-maps -I %S/Inputs %s -verify");
  }

  @Test
  public void test_method_pool_write_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Modules/method_pool_write.m");
    // rm -rf ${TEST_TEMP_DIR}/method_pool_write.m.tmp
    RUN(TestState.Failed, "rm -rf %t");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc '-fmodules-cache-path=${TEST_TEMP_DIR}/method_pool_write.m.tmp' -fmodules -fimplicit-module-maps -fsyntax-only -I ${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs ${LLVM_SRC}/llvm/tools/clang/test/Modules/method_pool_write.m -verify
    RUN(TestState.Failed, "%clang_cc1 -fmodules-cache-path=%t -fmodules -fimplicit-module-maps -fsyntax-only -I %S/Inputs %s -verify");
  }

  @Test
  public void test_minimal_identifier_tables_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Modules/minimal-identifier-tables.cpp");
    // rm -rf ${TEST_TEMP_DIR}/minimal-identifier-tables.cpp.tmp
    RUN("rm -rf %t");
    // mkdir ${TEST_TEMP_DIR}/minimal-identifier-tables.cpp.tmp
    RUN("mkdir %t");
    // echo 'extern int some_long_variable_name;' > ${TEST_TEMP_DIR}/minimal-identifier-tables.cpp.tmp/x.h
    RUN("echo 'extern int some_long_variable_name;' > %t/x.h");
    // echo 'extern int some_long_variable_name;' > ${TEST_TEMP_DIR}/minimal-identifier-tables.cpp.tmp/y.h
    RUN("echo 'extern int some_long_variable_name;' > %t/y.h");
    // echo 'module X { header "x.h" } module Y { header "y.h" }' > ${TEST_TEMP_DIR}/minimal-identifier-tables.cpp.tmp/map
    RUN("echo 'module X { header \"x.h\" } module Y { header \"y.h\" }' > %t/map");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fmodules -x c++ -fmodule-name=X ${TEST_TEMP_DIR}/minimal-identifier-tables.cpp.tmp/map -emit-module -o ${TEST_TEMP_DIR}/minimal-identifier-tables.cpp.tmp/x.pcm
    RUN("%clang_cc1 -fmodules -x c++ -fmodule-name=X %t/map -emit-module -o %t/x.pcm");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fmodules -x c++ -fmodule-name=Y ${TEST_TEMP_DIR}/minimal-identifier-tables.cpp.tmp/map '-fmodule-file=${TEST_TEMP_DIR}/minimal-identifier-tables.cpp.tmp/x.pcm' -emit-module -o ${TEST_TEMP_DIR}/minimal-identifier-tables.cpp.tmp/y.pcm
    RUN("%clang_cc1 -fmodules -x c++ -fmodule-name=Y %t/map -fmodule-file=%t/x.pcm -emit-module -o %t/y.pcm");
    // cat ${TEST_TEMP_DIR}/minimal-identifier-tables.cpp.tmp/y.pcm | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Modules/minimal-identifier-tables.cpp
    RUN("cat %t/y.pcm")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_misplaced_1_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Modules/misplaced-1.cpp");
    // rm -rf ${TEST_TEMP_DIR}/misplaced-1.cpp.tmp
    RUN("rm -rf %t");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fmodules -fimplicit-module-maps '-fmodules-cache-path=${TEST_TEMP_DIR}/misplaced-1.cpp.tmp' -I ${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs ${LLVM_SRC}/llvm/tools/clang/test/Modules/misplaced-1.cpp -verify
    RUN("%clang_cc1 -fmodules -fimplicit-module-maps -fmodules-cache-path=%t -I %S/Inputs %s -verify");
  }

  @Test
  public void test_misplaced_2_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Modules/misplaced-2.cpp");
    // rm -rf ${TEST_TEMP_DIR}/misplaced-2.cpp.tmp
    RUN("rm -rf %t");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fmodules -fimplicit-module-maps '-fmodules-cache-path=${TEST_TEMP_DIR}/misplaced-2.cpp.tmp' -I ${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs ${LLVM_SRC}/llvm/tools/clang/test/Modules/misplaced-2.cpp -verify
    RUN("%clang_cc1 -fmodules -fimplicit-module-maps -fmodules-cache-path=%t -I %S/Inputs %s -verify");
  }

  @Test
  public void test_misplaced_3_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Modules/misplaced-3.cpp");
    // rm -rf ${TEST_TEMP_DIR}/misplaced-3.cpp.tmp
    RUN("rm -rf %t");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fmodules -fimplicit-module-maps '-fmodules-cache-path=${TEST_TEMP_DIR}/misplaced-3.cpp.tmp' -I ${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs ${LLVM_SRC}/llvm/tools/clang/test/Modules/misplaced-3.cpp -verify
    RUN("%clang_cc1 -fmodules -fimplicit-module-maps -fmodules-cache-path=%t -I %S/Inputs %s -verify");
  }

  @Test
  public void test_misplaced_4_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Modules/misplaced-4.cpp");
    // rm -rf ${TEST_TEMP_DIR}/misplaced-4.cpp.tmp
    RUN("rm -rf %t");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fmodules -emit-module -fmodule-name=Misplaced '-fmodules-cache-path=${TEST_TEMP_DIR}/misplaced-4.cpp.tmp' -x c++ -I ${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs ${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs/misplaced/misplaced.modulemap -verify
    RUN("%clang_cc1 -fmodules -emit-module -fmodule-name=Misplaced -fmodules-cache-path=%t -x c++ -I %S/Inputs %S/Inputs/misplaced/misplaced.modulemap -verify");
  }

  @Test
  public void test_misplaced_5_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Modules/misplaced-5.c");
    // rm -rf ${TEST_TEMP_DIR}/misplaced-5.c.tmp
    RUN("rm -rf %t");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fmodules -fimplicit-module-maps '-fmodules-cache-path=${TEST_TEMP_DIR}/misplaced-5.c.tmp' -I ${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs ${LLVM_SRC}/llvm/tools/clang/test/Modules/misplaced-5.c -verify
    RUN("%clang_cc1 -fmodules -fimplicit-module-maps -fmodules-cache-path=%t -I %S/Inputs %s -verify");
  }

  @Test
  public void test_missing_header_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Modules/missing-header.m");
    // rm -rf ${TEST_TEMP_DIR}/missing-header.m.tmp
    RUN("rm -rf %t");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x objective-c '-fmodules-cache-path=${TEST_TEMP_DIR}/missing-header.m.tmp' -fmodules -fimplicit-module-maps -I ${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs/submodules ${LLVM_SRC}/llvm/tools/clang/test/Modules/missing-header.m 2>&1 | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Modules/missing-header.m
    RUN("not %clang_cc1 -x objective-c -fmodules-cache-path=%t -fmodules -fimplicit-module-maps -I %S/Inputs/submodules %s 2>&1")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_missing_submodule_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Modules/missing-submodule.m");
    // rm -rf ${TEST_TEMP_DIR}/missing-submodule.m.tmp
    RUN("rm -rf %t");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fmodules -fimplicit-module-maps '-fmodules-cache-path=${TEST_TEMP_DIR}/missing-submodule.m.tmp' -F ${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs ${LLVM_SRC}/llvm/tools/clang/test/Modules/missing-submodule.m -verify
    RUN("%clang_cc1 -fmodules -fimplicit-module-maps -fmodules-cache-path=%t -F %S/Inputs %s -verify");
  }

  @Test
  public void test_modify_module_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Modules/modify-module.m");
    // REQUIRES: ansi-escape-sequences
    if (!CHECK_REQUIRES("ansi-escape-sequences")) {
      return;
    }
    // rm -rf ${TEST_TEMP_DIR}/modify-module.m.tmp
    RUN("rm -rf %t");
    // mkdir -p ${TEST_TEMP_DIR}/modify-module.m.tmp/include
    RUN("mkdir -p %t/include");
    // cp ${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs/Modified/A.h ${TEST_TEMP_DIR}/modify-module.m.tmp/include
    RUN("cp %S/Inputs/Modified/A.h %t/include");
    // cp ${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs/Modified/B.h ${TEST_TEMP_DIR}/modify-module.m.tmp/include
    RUN("cp %S/Inputs/Modified/B.h %t/include");
    // cp ${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs/Modified/module.map ${TEST_TEMP_DIR}/modify-module.m.tmp/include
    RUN("cp %S/Inputs/Modified/module.map %t/include");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fdisable-module-hash '-fmodules-cache-path=${TEST_TEMP_DIR}/modify-module.m.tmp/cache' -fmodules -fimplicit-module-maps -I ${TEST_TEMP_DIR}/modify-module.m.tmp/include ${LLVM_SRC}/llvm/tools/clang/test/Modules/modify-module.m -verify
    RUN("%clang_cc1 -fdisable-module-hash -fmodules-cache-path=%t/cache -fmodules -fimplicit-module-maps -I %t/include %s -verify");
    // echo >> ${TEST_TEMP_DIR}/modify-module.m.tmp/include/B.h
    RUN("echo '' >> %t/include/B.h");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fdisable-module-hash '-fmodules-cache-path=${TEST_TEMP_DIR}/modify-module.m.tmp/cache' -fmodules -fimplicit-module-maps -I ${TEST_TEMP_DIR}/modify-module.m.tmp/include ${LLVM_SRC}/llvm/tools/clang/test/Modules/modify-module.m -verify
    RUN("%clang_cc1 -fdisable-module-hash -fmodules-cache-path=%t/cache -fmodules -fimplicit-module-maps -I %t/include %s -verify");
    // echo 'int getA(); int getA2();' > ${TEST_TEMP_DIR}/modify-module.m.tmp/include/A.h
    RUN("echo 'int getA(); int getA2();' > %t/include/A.h");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fdisable-module-hash '-fmodules-cache-path=${TEST_TEMP_DIR}/modify-module.m.tmp/cache' -fmodules -fimplicit-module-maps -I ${TEST_TEMP_DIR}/modify-module.m.tmp/include ${LLVM_SRC}/llvm/tools/clang/test/Modules/modify-module.m -verify
    RUN("%clang_cc1 -fdisable-module-hash -fmodules-cache-path=%t/cache -fmodules -fimplicit-module-maps -I %t/include %s -verify");
    // rm ${TEST_TEMP_DIR}/modify-module.m.tmp/cache/ModA.pcm
    RUN("rm %t/cache/ModA.pcm");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fdisable-module-hash '-fmodules-cache-path=${TEST_TEMP_DIR}/modify-module.m.tmp/cache' -fmodules -fimplicit-module-maps -I ${TEST_TEMP_DIR}/modify-module.m.tmp/include ${LLVM_SRC}/llvm/tools/clang/test/Modules/modify-module.m -verify
    RUN("%clang_cc1 -fdisable-module-hash -fmodules-cache-path=%t/cache -fmodules -fimplicit-module-maps -I %t/include %s -verify");
    // touch ${TEST_TEMP_DIR}/modify-module.m.tmp/cache/ModA.pcm
    RUN("touch %t/cache/ModA.pcm");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fdisable-module-hash '-fmodules-cache-path=${TEST_TEMP_DIR}/modify-module.m.tmp/cache' -fmodules -fimplicit-module-maps -I ${TEST_TEMP_DIR}/modify-module.m.tmp/include ${LLVM_SRC}/llvm/tools/clang/test/Modules/modify-module.m -verify
    RUN("%clang_cc1 -fdisable-module-hash -fmodules-cache-path=%t/cache -fmodules -fimplicit-module-maps -I %t/include %s -verify");
  }

  @Test
  public void test_modular_maps_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Modules/modular_maps.cpp");
    // rm -rf ${TEST_TEMP_DIR}/modular_maps.cpp.tmp
    RUN(TestState.Failed, "rm -rf %t");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x objective-c++ '-fmodules-cache-path=${TEST_TEMP_DIR}/modular_maps.cpp.tmp' -fmodules '-fmodule-map-file=${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs/modular_maps/modulea.map' '-fmodule-map-file=${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs/modular_maps/modulec.map' -I ${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs/modular_maps ${LLVM_SRC}/llvm/tools/clang/test/Modules/modular_maps.cpp -verify
    RUN(TestState.Failed, "%clang_cc1 -x objective-c++ -fmodules-cache-path=%t -fmodules -fmodule-map-file=%S/Inputs/modular_maps/modulea.map -fmodule-map-file=%S/Inputs/modular_maps/modulec.map -I %S/Inputs/modular_maps %s -verify");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x objective-c++ '-fmodules-cache-path=${TEST_TEMP_DIR}/modular_maps.cpp.tmp' -fmodules '-fmodule-map-file=${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs/modular_maps/modulec.map' '-fmodule-map-file=${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs/modular_maps/modulea.map' -I ${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs/modular_maps ${LLVM_SRC}/llvm/tools/clang/test/Modules/modular_maps.cpp -verify
    RUN(TestState.Failed, "%clang_cc1 -x objective-c++ -fmodules-cache-path=%t -fmodules -fmodule-map-file=%S/Inputs/modular_maps/modulec.map -fmodule-map-file=%S/Inputs/modular_maps/modulea.map -I %S/Inputs/modular_maps %s -verify");
    // cd ${LLVM_SRC}/llvm/tools/clang/test/Modules
    RUN(TestState.Failed, "cd %S");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x objective-c++ '-fmodules-cache-path=${TEST_TEMP_DIR}/modular_maps.cpp.tmp' -fmodules -fmodule-map-file=Inputs/modular_maps/modulea.map -fmodule-map-file=Inputs/modular_maps/modulec.map -I Inputs/modular_maps ${LLVM_SRC}/llvm/tools/clang/test/Modules/modular_maps.cpp -verify
    RUN(TestState.Failed, "%clang_cc1 -x objective-c++ -fmodules-cache-path=%t -fmodules -fmodule-map-file=Inputs/modular_maps/modulea.map -fmodule-map-file=Inputs/modular_maps/modulec.map -I Inputs/modular_maps %s -verify");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x objective-c++ '-fmodules-cache-path=${TEST_TEMP_DIR}/modular_maps.cpp.tmp' -fmodules -fmodule-map-file=Inputs/modular_maps/modulec.map -fmodule-map-file=Inputs/modular_maps/modulea.map -I Inputs/modular_maps ${LLVM_SRC}/llvm/tools/clang/test/Modules/modular_maps.cpp -verify
    RUN(TestState.Failed, "%clang_cc1 -x objective-c++ -fmodules-cache-path=%t -fmodules -fmodule-map-file=Inputs/modular_maps/modulec.map -fmodule-map-file=Inputs/modular_maps/modulea.map -I Inputs/modular_maps %s -verify");
    // cd ${LLVM_SRC}/llvm/tools/clang/test/Modules
    RUN(TestState.Failed, "cd %S");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x objective-c++ '-fmodules-cache-path=${TEST_TEMP_DIR}/modular_maps.cpp.tmp' -fmodules -fmodule-map-file=Inputs/modular_maps/modulea-cwd.map -fmodule-map-file=Inputs/modular_maps/modulec-cwd.map -I Inputs/modular_maps ${LLVM_SRC}/llvm/tools/clang/test/Modules/modular_maps.cpp -verify -fmodule-map-file-home-is-cwd
    RUN(TestState.Failed, "%clang_cc1 -x objective-c++ -fmodules-cache-path=%t -fmodules -fmodule-map-file=Inputs/modular_maps/modulea-cwd.map -fmodule-map-file=Inputs/modular_maps/modulec-cwd.map -I Inputs/modular_maps %s -verify -fmodule-map-file-home-is-cwd");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x objective-c++ '-fmodules-cache-path=${TEST_TEMP_DIR}/modular_maps.cpp.tmp' -fmodules -fmodule-map-file=Inputs/modular_maps/modulec-cwd.map -fmodule-map-file=Inputs/modular_maps/modulea-cwd.map -I Inputs/modular_maps ${LLVM_SRC}/llvm/tools/clang/test/Modules/modular_maps.cpp -verify -fmodule-map-file-home-is-cwd
    RUN(TestState.Failed, "%clang_cc1 -x objective-c++ -fmodules-cache-path=%t -fmodules -fmodule-map-file=Inputs/modular_maps/modulec-cwd.map -fmodule-map-file=Inputs/modular_maps/modulea-cwd.map -I Inputs/modular_maps %s -verify -fmodule-map-file-home-is-cwd");
  }

  @Test
  public void test_module_feature_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Modules/module-feature.m");
    // rm -rf ${TEST_TEMP_DIR}/module-feature.m.tmp ${TEST_TEMP_DIR}/module-feature.m.tmp.nohash
    RUN(TestState.Failed, "rm -rf %t %t.nohash");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fmodules '-fmodules-cache-path=${TEST_TEMP_DIR}/module-feature.m.tmp' -fimplicit-module-maps -fmodule-feature f1 -fmodule-feature f2 -F ${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs ${LLVM_SRC}/llvm/tools/clang/test/Modules/module-feature.m -verify -Rmodule-build
    RUN(TestState.Failed, "%clang_cc1 -fmodules -fmodules-cache-path=%t -fimplicit-module-maps -fmodule-feature f1 -fmodule-feature f2 -F %S/Inputs %s -verify -Rmodule-build");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fmodules '-fmodules-cache-path=${TEST_TEMP_DIR}/module-feature.m.tmp' -fimplicit-module-maps -fmodule-feature f2 -F ${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs ${LLVM_SRC}/llvm/tools/clang/test/Modules/module-feature.m -verify -Rmodule-build
    RUN(TestState.Failed, "%clang_cc1 -fmodules -fmodules-cache-path=%t -fimplicit-module-maps -fmodule-feature f2 -F %S/Inputs %s -verify -Rmodule-build");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fmodules '-fmodules-cache-path=${TEST_TEMP_DIR}/module-feature.m.tmp' -fimplicit-module-maps -fmodule-feature f2 -fmodule-feature f1 -F ${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs ${LLVM_SRC}/llvm/tools/clang/test/Modules/module-feature.m -Rmodule-build 2>&1 | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Modules/module-feature.m -allow-empty -check-prefix=ALREADY_BUILT
    RUN(TestState.Failed, "%clang_cc1 -fmodules -fmodules-cache-path=%t -fimplicit-module-maps -fmodule-feature f2 -fmodule-feature f1 -F %S/Inputs %s -Rmodule-build 2>&1")./*|*/
      I("FileCheck %s -allow-empty -check-prefix=ALREADY_BUILT");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fmodules '-fmodules-cache-path=${TEST_TEMP_DIR}/module-feature.m.tmp.nohash' -fimplicit-module-maps -fdisable-module-hash -fmodule-feature f1 -fmodule-feature f2 -F ${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs ${LLVM_SRC}/llvm/tools/clang/test/Modules/module-feature.m -verify -Rmodule-build
    RUN(TestState.Failed, "%clang_cc1 -fmodules -fmodules-cache-path=%t.nohash -fimplicit-module-maps -fdisable-module-hash -fmodule-feature f1 -fmodule-feature f2 -F %S/Inputs %s -verify -Rmodule-build");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fmodules '-fmodules-cache-path=${TEST_TEMP_DIR}/module-feature.m.tmp.nohash' -fimplicit-module-maps -fdisable-module-hash -fmodule-feature f2 -F ${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs ${LLVM_SRC}/llvm/tools/clang/test/Modules/module-feature.m 2>&1 | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Modules/module-feature.m -check-prefix=DIFFERS
    RUN(TestState.Failed, "not %clang_cc1 -fmodules -fmodules-cache-path=%t.nohash -fimplicit-module-maps -fdisable-module-hash -fmodule-feature f2 -F %S/Inputs %s 2>&1")./*|*/
      I("FileCheck %s -check-prefix=DIFFERS");
  }

  @Test
  public void test_module_map_path_hash_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Modules/module-map-path-hash.cpp");
    // rm -rf ${TEST_TEMP_DIR}/module-map-path-hash.cpp.tmp
    RUN("rm -rf %t");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fmodules -fimplicit-module-maps -x c++ -Rmodule-build '-I${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs/module-map-path-hash' '-fmodules-cache-path=${TEST_TEMP_DIR}/module-map-path-hash.cpp.tmp' -fsyntax-only ${LLVM_SRC}/llvm/tools/clang/test/Modules/module-map-path-hash.cpp 2>&1 | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Modules/module-map-path-hash.cpp --check-prefix=BUILD
    RUN("%clang_cc1 -fmodules -fimplicit-module-maps -x c++ -Rmodule-build -I%S/Inputs/module-map-path-hash -fmodules-cache-path=%t -fsyntax-only %s 2>&1")./*|*/
      I("FileCheck %s --check-prefix=BUILD");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fmodules -fimplicit-module-maps -x c++ -Rmodule-build '-I${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs//module-map-path-hash' '-fmodules-cache-path=${TEST_TEMP_DIR}/module-map-path-hash.cpp.tmp' -fsyntax-only ${LLVM_SRC}/llvm/tools/clang/test/Modules/module-map-path-hash.cpp 2>&1 | ${LLVM_SRC}/build/bin/FileCheck -allow-empty ${LLVM_SRC}/llvm/tools/clang/test/Modules/module-map-path-hash.cpp --check-prefix=NOBUILD
    RUN("%clang_cc1 -fmodules -fimplicit-module-maps -x c++ -Rmodule-build -I%S/Inputs//module-map-path-hash -fmodules-cache-path=%t -fsyntax-only %s 2>&1")./*|*/
      I("FileCheck -allow-empty %s --check-prefix=NOBUILD");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fmodules -fimplicit-module-maps -x c++ -Rmodule-build '-I${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs/./module-map-path-hash' '-fmodules-cache-path=${TEST_TEMP_DIR}/module-map-path-hash.cpp.tmp' -fsyntax-only ${LLVM_SRC}/llvm/tools/clang/test/Modules/module-map-path-hash.cpp 2>&1 | ${LLVM_SRC}/build/bin/FileCheck -allow-empty ${LLVM_SRC}/llvm/tools/clang/test/Modules/module-map-path-hash.cpp --check-prefix=NOBUILD
    RUN("%clang_cc1 -fmodules -fimplicit-module-maps -x c++ -Rmodule-build -I%S/Inputs/./module-map-path-hash -fmodules-cache-path=%t -fsyntax-only %s 2>&1")./*|*/
      I("FileCheck -allow-empty %s --check-prefix=NOBUILD");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fmodules -fimplicit-module-maps -x c++ -Rmodule-build '-I${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs/../Inputs/module-map-path-hash' '-fmodules-cache-path=${TEST_TEMP_DIR}/module-map-path-hash.cpp.tmp' -fsyntax-only ${LLVM_SRC}/llvm/tools/clang/test/Modules/module-map-path-hash.cpp 2>&1 | ${LLVM_SRC}/build/bin/FileCheck -allow-empty ${LLVM_SRC}/llvm/tools/clang/test/Modules/module-map-path-hash.cpp --check-prefix=NOBUILD
    RUN("%clang_cc1 -fmodules -fimplicit-module-maps -x c++ -Rmodule-build -I%S/Inputs/../Inputs/module-map-path-hash -fmodules-cache-path=%t -fsyntax-only %s 2>&1")./*|*/
      I("FileCheck -allow-empty %s --check-prefix=NOBUILD");
  }

  @Test
  public void test_module_private_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Modules/module-private.cpp");
    // rm -rf ${TEST_TEMP_DIR}/module-private.cpp.tmp
    RUN("rm -rf %t");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fmodules -fimplicit-module-maps -x objective-c++ '-fmodules-cache-path=${TEST_TEMP_DIR}/module-private.cpp.tmp' -fmodule-name=module_private_left -emit-module ${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs/module.map
    RUN("%clang_cc1 -fmodules -fimplicit-module-maps -x objective-c++ -fmodules-cache-path=%t -fmodule-name=module_private_left -emit-module %S/Inputs/module.map");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fmodules -fimplicit-module-maps -x objective-c++ '-fmodules-cache-path=${TEST_TEMP_DIR}/module-private.cpp.tmp' -fmodule-name=module_private_right -emit-module ${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs/module.map
    RUN("%clang_cc1 -fmodules -fimplicit-module-maps -x objective-c++ -fmodules-cache-path=%t -fmodule-name=module_private_right -emit-module %S/Inputs/module.map");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fmodules -fimplicit-module-maps -x objective-c++ '-fmodules-cache-path=${TEST_TEMP_DIR}/module-private.cpp.tmp' -I ${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs ${LLVM_SRC}/llvm/tools/clang/test/Modules/module-private.cpp -verify
    RUN("%clang_cc1 -fmodules -fimplicit-module-maps -x objective-c++ -fmodules-cache-path=%t -I %S/Inputs %s -verify");
  }

  @Test
  public void test_module_file_info_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Modules/module_file_info.m");
    // rm -rf ${TEST_TEMP_DIR}/module_file_info.m.tmp
    RUN("rm -rf %t");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -w -Wunused -fmodules -fimplicit-module-maps -fdisable-module-hash '-fmodules-cache-path=${TEST_TEMP_DIR}/module_file_info.m.tmp' -F ${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs -DBLARG -DWIBBLE=WOBBLE -fmodule-feature myfeature ${LLVM_SRC}/llvm/tools/clang/test/Modules/module_file_info.m
    RUN("%clang_cc1 -w -Wunused -fmodules -fimplicit-module-maps -fdisable-module-hash -fmodules-cache-path=%t -F %S/Inputs -DBLARG -DWIBBLE=WOBBLE -fmodule-feature myfeature %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -module-file-info ${TEST_TEMP_DIR}/module_file_info.m.tmp/DependsOnModule.pcm | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Modules/module_file_info.m
    RUN("%clang_cc1 -module-file-info %t/DependsOnModule.pcm")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_modulemap_locations_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Modules/modulemap-locations.m");
    // rm -rf ${TEST_TEMP_DIR}/modulemap-locations.m.tmp
    RUN("rm -rf %t");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fmodules -fimplicit-module-maps '-fmodules-cache-path=${TEST_TEMP_DIR}/modulemap-locations.m.tmp' -I ${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs/ModuleMapLocations/Module_ModuleMap -I ${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs/ModuleMapLocations/Both -F ${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs/ModuleMapLocations -I ${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs/ModuleMapLocations -F ${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs -x objective-c -fsyntax-only ${LLVM_SRC}/llvm/tools/clang/test/Modules/modulemap-locations.m -verify
    RUN("%clang_cc1 -fmodules -fimplicit-module-maps -fmodules-cache-path=%t -I %S/Inputs/ModuleMapLocations/Module_ModuleMap -I %S/Inputs/ModuleMapLocations/Both -F %S/Inputs/ModuleMapLocations -I %S/Inputs/ModuleMapLocations -F %S/Inputs -x objective-c -fsyntax-only %s -verify");
  }

  @Test
  public void test_modules_with_same_name_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Modules/modules-with-same-name.m");
    // rm -rf ${TEST_TEMP_DIR}/modules-with-same-name.m.tmp
    RUN(TestState.Failed, "rm -rf %t");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fmodules -fimplicit-module-maps '-fmodules-cache-path=${TEST_TEMP_DIR}/modules-with-same-name.m.tmp' -fmodules-ignore-macro=EXPECTED_PATH -fmodules-ignore-macro=DIRECT -fsyntax-only ${LLVM_SRC}/llvm/tools/clang/test/Modules/modules-with-same-name.m -verify -I ${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs/modules-with-same-name/path1/A -DDIRECT -DEXPECTED_PATH=1
    RUN(TestState.Failed, "%clang_cc1 -fmodules -fimplicit-module-maps -fmodules-cache-path=%t -fmodules-ignore-macro=EXPECTED_PATH -fmodules-ignore-macro=DIRECT -fsyntax-only %s -verify -I %S/Inputs/modules-with-same-name/path1/A -DDIRECT -DEXPECTED_PATH=1");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fmodules -fimplicit-module-maps '-fmodules-cache-path=${TEST_TEMP_DIR}/modules-with-same-name.m.tmp' -fmodules-ignore-macro=EXPECTED_PATH -fmodules-ignore-macro=DIRECT -fsyntax-only ${LLVM_SRC}/llvm/tools/clang/test/Modules/modules-with-same-name.m -verify -I ${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs/modules-with-same-name/path2/A -DDIRECT -DEXPECTED_PATH=2
    RUN(TestState.Failed, "%clang_cc1 -fmodules -fimplicit-module-maps -fmodules-cache-path=%t -fmodules-ignore-macro=EXPECTED_PATH -fmodules-ignore-macro=DIRECT -fsyntax-only %s -verify -I %S/Inputs/modules-with-same-name/path2/A -DDIRECT -DEXPECTED_PATH=2");
    // find ${TEST_TEMP_DIR}/modules-with-same-name.m.tmp -name A-*.pc[m] | ${LLVM_SRC}/build/bin/count 2
    RUN(TestState.Failed, "find %t -name \"A-*.pc[m]\"")./*|*/
      I("count 2");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fmodules -fimplicit-module-maps '-fmodules-cache-path=${TEST_TEMP_DIR}/modules-with-same-name.m.tmp' -fmodules-ignore-macro=EXPECTED_PATH -fmodules-ignore-macro=DIRECT -fsyntax-only ${LLVM_SRC}/llvm/tools/clang/test/Modules/modules-with-same-name.m -verify -I ${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs/modules-with-same-name/DependsOnA -I ${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs/modules-with-same-name/path1/A -DEXPECTED_PATH=1
    RUN(TestState.Failed, "%clang_cc1 -fmodules -fimplicit-module-maps -fmodules-cache-path=%t -fmodules-ignore-macro=EXPECTED_PATH -fmodules-ignore-macro=DIRECT -fsyntax-only %s -verify -I %S/Inputs/modules-with-same-name/DependsOnA -I %S/Inputs/modules-with-same-name/path1/A -DEXPECTED_PATH=1");
    // find ${TEST_TEMP_DIR}/modules-with-same-name.m.tmp -name *.pc[m] | ${LLVM_SRC}/build/bin/count 3
    RUN(TestState.Failed, "find %t -name \"*.pc[m]\"")./*|*/
      I("count 3");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fmodules -fimplicit-module-maps '-fmodules-cache-path=${TEST_TEMP_DIR}/modules-with-same-name.m.tmp' -fmodules-ignore-macro=EXPECTED_PATH -fmodules-ignore-macro=DIRECT -fsyntax-only ${LLVM_SRC}/llvm/tools/clang/test/Modules/modules-with-same-name.m -verify -I ${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs/modules-with-same-name/DependsOnA -I ${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs/modules-with-same-name/path2/A -DEXPECTED_PATH=2
    RUN(TestState.Failed, "%clang_cc1 -fmodules -fimplicit-module-maps -fmodules-cache-path=%t -fmodules-ignore-macro=EXPECTED_PATH -fmodules-ignore-macro=DIRECT -fsyntax-only %s -verify -I %S/Inputs/modules-with-same-name/DependsOnA -I %S/Inputs/modules-with-same-name/path2/A -DEXPECTED_PATH=2");
    // find ${TEST_TEMP_DIR}/modules-with-same-name.m.tmp -name *.pc[m] | ${LLVM_SRC}/build/bin/count 3
    RUN(TestState.Failed, "find %t -name \"*.pc[m]\"")./*|*/
      I("count 3");
  }

  @Test
  public void test_multiple_include_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Modules/multiple-include.cpp");
    // rm -rf ${TEST_TEMP_DIR}/multiple-include.cpp.tmp
    RUN(TestState.Failed, "rm -rf %t");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fmodules '-I${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs/multiple-include' '-fmodules-cache-path=${TEST_TEMP_DIR}/multiple-include.cpp.tmp' -fimplicit-module-maps -verify ${LLVM_SRC}/llvm/tools/clang/test/Modules/multiple-include.cpp -fmodules-local-submodule-visibility
    RUN(TestState.Failed, "%clang_cc1 -fmodules -I%S/Inputs/multiple-include -fmodules-cache-path=%t -fimplicit-module-maps -verify %s -fmodules-local-submodule-visibility");
  }

  @Test
  public void test_namespaces_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Modules/namespaces.cpp");
    // rm -rf ${TEST_TEMP_DIR}/namespaces.cpp.tmp
    RUN(TestState.Failed, "rm -rf %t");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x objective-c++ -fmodules -fimplicit-module-maps '-fmodules-cache-path=${TEST_TEMP_DIR}/namespaces.cpp.tmp' -I ${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs ${LLVM_SRC}/llvm/tools/clang/test/Modules/namespaces.cpp -verify
    RUN(TestState.Failed, "%clang_cc1 -x objective-c++ -fmodules -fimplicit-module-maps -fmodules-cache-path=%t -I %S/Inputs %s -verify");
  }

  @Test
  public void test_no_implicit_builds_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Modules/no-implicit-builds.cpp");
    // rm -rf ${TEST_TEMP_DIR}/no-implicit-builds.cpp.tmp
    RUN("rm -rf %t");
    // ${LLVM_SRC}/build/bin/clang -x c++ -std=c++11 -fmodules -fno-implicit-modules /dev/null -### 2>&1 | ${LLVM_SRC}/build/bin/FileCheck --check-prefix=CHECK-NO-MODULE-CACHE ${LLVM_SRC}/llvm/tools/clang/test/Modules/no-implicit-builds.cpp
    RUN("%clang -x c++ -std=c++11 -fmodules -fno-implicit-modules /dev/null -### 2>&1")./*|*/
      I("FileCheck --check-prefix=CHECK-NO-MODULE-CACHE %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x c++ -std=c++11 -fmodules -fimplicit-module-maps '-fmodules-cache-path=${TEST_TEMP_DIR}/no-implicit-builds.cpp.tmp' '-fmodule-map-file=${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs/no-implicit-builds/b.modulemap' -fno-implicit-modules ${LLVM_SRC}/llvm/tools/clang/test/Modules/no-implicit-builds.cpp -verify
    RUN("%clang_cc1 -x c++ -std=c++11 -fmodules -fimplicit-module-maps -fmodules-cache-path=%t -fmodule-map-file=%S/Inputs/no-implicit-builds/b.modulemap -fno-implicit-modules %s -verify");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x c++ -std=c++11 -fmodules -fimplicit-module-maps '-fmodule-map-file=${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs/no-implicit-builds/b.modulemap' ${LLVM_SRC}/llvm/tools/clang/test/Modules/no-implicit-builds.cpp -verify
    RUN("%clang_cc1 -x c++ -std=c++11 -fmodules -fimplicit-module-maps -fmodule-map-file=%S/Inputs/no-implicit-builds/b.modulemap %s -verify");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x c++ -std=c++11 -fmodules -fimplicit-module-maps '-fmodules-cache-path=${TEST_TEMP_DIR}/no-implicit-builds.cpp.tmp' '-fmodule-map-file=${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs/no-implicit-builds/b.modulemap' ${LLVM_SRC}/llvm/tools/clang/test/Modules/no-implicit-builds.cpp -Rmodule-build 2>&1 | ${LLVM_SRC}/build/bin/FileCheck --check-prefix=CHECK-CACHE-BUILD ${LLVM_SRC}/llvm/tools/clang/test/Modules/no-implicit-builds.cpp
    RUN("%clang_cc1 -x c++ -std=c++11 -fmodules -fimplicit-module-maps -fmodules-cache-path=%t -fmodule-map-file=%S/Inputs/no-implicit-builds/b.modulemap %s -Rmodule-build 2>&1")./*|*/
      I("FileCheck --check-prefix=CHECK-CACHE-BUILD %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x c++ -std=c++11 -fmodules -fimplicit-module-maps '-fmodules-cache-path=${TEST_TEMP_DIR}/no-implicit-builds.cpp.tmp' '-fmodule-map-file=${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs/no-implicit-builds/b.modulemap' ${LLVM_SRC}/llvm/tools/clang/test/Modules/no-implicit-builds.cpp -Rmodule-build -fno-implicit-modules -verify
    RUN("%clang_cc1 -x c++ -std=c++11 -fmodules -fimplicit-module-maps -fmodules-cache-path=%t -fmodule-map-file=%S/Inputs/no-implicit-builds/b.modulemap %s -Rmodule-build -fno-implicit-modules -verify");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x c++ -std=c++11 -fmodules -fimplicit-module-maps -fmodule-name=b -o ${TEST_TEMP_DIR}/no-implicit-builds.cpp.tmp/b.pcm -emit-module ${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs/no-implicit-builds/b.modulemap -fno-implicit-modules
    RUN("%clang_cc1 -x c++ -std=c++11 -fmodules -fimplicit-module-maps -fmodule-name=b -o %t/b.pcm -emit-module %S/Inputs/no-implicit-builds/b.modulemap -fno-implicit-modules");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x c++ -std=c++11 -fmodules -fimplicit-module-maps '-fmodule-file=${TEST_TEMP_DIR}/no-implicit-builds.cpp.tmp/b.pcm' '-fmodule-map-file=${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs/no-implicit-builds/b.modulemap' -fno-implicit-modules ${LLVM_SRC}/llvm/tools/clang/test/Modules/no-implicit-builds.cpp
    RUN("%clang_cc1 -x c++ -std=c++11 -fmodules -fimplicit-module-maps -fmodule-file=%t/b.pcm -fmodule-map-file=%S/Inputs/no-implicit-builds/b.modulemap -fno-implicit-modules %s");
  }

  @Test
  public void test_no_implicit_maps_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Modules/no-implicit-maps.cpp");
    // rm -rf ${TEST_TEMP_DIR}/no-implicit-maps.cpp.tmp
    RUN("rm -rf %t");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x objective-c '-fmodules-cache-path=${TEST_TEMP_DIR}/no-implicit-maps.cpp.tmp' -fmodules -I ${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs/private ${LLVM_SRC}/llvm/tools/clang/test/Modules/no-implicit-maps.cpp -verify
    RUN("%clang_cc1 -x objective-c -fmodules-cache-path=%t -fmodules -I %S/Inputs/private %s -verify");
  }

  @Test
  public void test_no_linkage_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Modules/no-linkage.cpp");
    // rm -rf ${TEST_TEMP_DIR}/no-linkage.cpp.tmp
    RUN("rm -rf %t");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fmodules '-fmodules-cache-path=${TEST_TEMP_DIR}/no-linkage.cpp.tmp' -fmodules-local-submodule-visibility '-I${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs/no-linkage' '-fmodule-map-file=${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs/no-linkage/module.modulemap' ${LLVM_SRC}/llvm/tools/clang/test/Modules/no-linkage.cpp -verify
    RUN("%clang_cc1 -fmodules -fmodules-cache-path=%t -fmodules-local-submodule-visibility -I%S/Inputs/no-linkage -fmodule-map-file=%S/Inputs/no-linkage/module.modulemap %s -verify");
  }

  @Test
  public void test_no_stale_modtime_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Modules/no-stale-modtime.m");
    // rm -rf ${TEST_TEMP_DIR}/no-stale-modtime.m.tmp
    RUN("rm -rf %t");
    // mkdir -p ${TEST_TEMP_DIR}/no-stale-modtime.m.tmp
    RUN("mkdir -p %t");
    // echo '@import l; @import r;' > ${TEST_TEMP_DIR}/no-stale-modtime.m.tmp/b.h
    RUN("echo '@import l; @import r;' > %t/b.h");
    // echo '@import t; // fromt l' > ${TEST_TEMP_DIR}/no-stale-modtime.m.tmp/l.h
    RUN("echo '@import t; // fromt l' > %t/l.h");
    // echo '@import t; // fromt r' > ${TEST_TEMP_DIR}/no-stale-modtime.m.tmp/r.h
    RUN("echo '@import t; // fromt r' > %t/r.h");
    // echo '// top' > ${TEST_TEMP_DIR}/no-stale-modtime.m.tmp/t.h
    RUN("echo '// top' > %t/t.h");
    // echo 'module b { header "b.h" } module l { header "l.h" }' > ${TEST_TEMP_DIR}/no-stale-modtime.m.tmp/module.map
    RUN("echo 'module b { header \"b.h\" } module l { header \"l.h\" }' > %t/module.map");
    // echo 'module r { header "r.h" } module t { header "t.h" }' >> ${TEST_TEMP_DIR}/no-stale-modtime.m.tmp/module.map
    RUN("echo 'module r { header \"r.h\" } module t { header \"t.h\" }' >> %t/module.map");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fmodules -fimplicit-module-maps '-fmodules-cache-path=${TEST_TEMP_DIR}/no-stale-modtime.m.tmp' -fdisable-module-hash -I ${TEST_TEMP_DIR}/no-stale-modtime.m.tmp -fsyntax-only ${LLVM_SRC}/llvm/tools/clang/test/Modules/no-stale-modtime.m -Rmodule-build 2>&1 | ${LLVM_SRC}/build/bin/FileCheck -check-prefix=REBUILD-ALL ${LLVM_SRC}/llvm/tools/clang/test/Modules/no-stale-modtime.m
    RUN("%clang_cc1 -fmodules -fimplicit-module-maps -fmodules-cache-path=%t -fdisable-module-hash -I %t -fsyntax-only %s -Rmodule-build 2>&1")./*|*/
      I("FileCheck -check-prefix=REBUILD-ALL %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fmodules -fimplicit-module-maps '-fmodules-cache-path=${TEST_TEMP_DIR}/no-stale-modtime.m.tmp' -fdisable-module-hash -I ${TEST_TEMP_DIR}/no-stale-modtime.m.tmp -fsyntax-only ${LLVM_SRC}/llvm/tools/clang/test/Modules/no-stale-modtime.m -Rmodule-build -verify
    RUN("%clang_cc1 -fmodules -fimplicit-module-maps -fmodules-cache-path=%t -fdisable-module-hash -I %t -fsyntax-only %s -Rmodule-build -verify");
    // echo 'extern int a;' >> ${TEST_TEMP_DIR}/no-stale-modtime.m.tmp/t.h
    RUN("echo 'extern int a;' >> %t/t.h");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fmodules -fimplicit-module-maps '-fmodules-cache-path=${TEST_TEMP_DIR}/no-stale-modtime.m.tmp' -fdisable-module-hash -I ${TEST_TEMP_DIR}/no-stale-modtime.m.tmp -fsyntax-only ${LLVM_SRC}/llvm/tools/clang/test/Modules/no-stale-modtime.m -Rmodule-build 2>&1 | ${LLVM_SRC}/build/bin/FileCheck -check-prefix=REBUILD-ALL ${LLVM_SRC}/llvm/tools/clang/test/Modules/no-stale-modtime.m
    RUN("%clang_cc1 -fmodules -fimplicit-module-maps -fmodules-cache-path=%t -fdisable-module-hash -I %t -fsyntax-only %s -Rmodule-build 2>&1")./*|*/
      I("FileCheck -check-prefix=REBUILD-ALL %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fmodules -fimplicit-module-maps '-fmodules-cache-path=${TEST_TEMP_DIR}/no-stale-modtime.m.tmp' -fdisable-module-hash -I ${TEST_TEMP_DIR}/no-stale-modtime.m.tmp -fsyntax-only ${LLVM_SRC}/llvm/tools/clang/test/Modules/no-stale-modtime.m -Rmodule-build -verify
    RUN("%clang_cc1 -fmodules -fimplicit-module-maps -fmodules-cache-path=%t -fdisable-module-hash -I %t -fsyntax-only %s -Rmodule-build -verify");
  }

  @Test
  public void test_normal_module_map_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Modules/normal-module-map.cpp");
    // rm -rf ${TEST_TEMP_DIR}/normal-module-map.cpp.tmp
    RUN(TestState.Failed, "rm -rf %t");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x objective-c '-fmodules-cache-path=${TEST_TEMP_DIR}/normal-module-map.cpp.tmp' -fmodules -fimplicit-module-maps -I ${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs/normal-module-map ${LLVM_SRC}/llvm/tools/clang/test/Modules/normal-module-map.cpp -verify
    RUN(TestState.Failed, "%clang_cc1 -x objective-c -fmodules-cache-path=%t -fmodules -fimplicit-module-maps -I %S/Inputs/normal-module-map %s -verify");
  }

  @Test
  public void test_objc_categories_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Modules/objc-categories.m");
    // rm -rf ${TEST_TEMP_DIR}/objc-categories.m.tmp
    RUN(TestState.Failed, "rm -rf %t");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fmodules -fimplicit-module-maps '-fmodules-cache-path=${TEST_TEMP_DIR}/objc-categories.m.tmp' -x objective-c -fmodule-name=category_top -emit-module ${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs/module.map
    RUN(TestState.Failed, "%clang_cc1 -fmodules -fimplicit-module-maps -fmodules-cache-path=%t -x objective-c -fmodule-name=category_top -emit-module %S/Inputs/module.map");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fmodules -fimplicit-module-maps '-fmodules-cache-path=${TEST_TEMP_DIR}/objc-categories.m.tmp' -x objective-c -fmodule-name=category_left -emit-module ${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs/module.map
    RUN(TestState.Failed, "%clang_cc1 -fmodules -fimplicit-module-maps -fmodules-cache-path=%t -x objective-c -fmodule-name=category_left -emit-module %S/Inputs/module.map");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fmodules -fimplicit-module-maps '-fmodules-cache-path=${TEST_TEMP_DIR}/objc-categories.m.tmp' -x objective-c -fmodule-name=category_right -emit-module ${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs/module.map
    RUN(TestState.Failed, "%clang_cc1 -fmodules -fimplicit-module-maps -fmodules-cache-path=%t -x objective-c -fmodule-name=category_right -emit-module %S/Inputs/module.map");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fmodules -fimplicit-module-maps '-fmodules-cache-path=${TEST_TEMP_DIR}/objc-categories.m.tmp' -x objective-c -fmodule-name=category_bottom -emit-module ${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs/module.map
    RUN(TestState.Failed, "%clang_cc1 -fmodules -fimplicit-module-maps -fmodules-cache-path=%t -x objective-c -fmodule-name=category_bottom -emit-module %S/Inputs/module.map");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fmodules -fimplicit-module-maps '-fmodules-cache-path=${TEST_TEMP_DIR}/objc-categories.m.tmp' -x objective-c -fmodule-name=category_other -emit-module ${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs/module.map
    RUN(TestState.Failed, "%clang_cc1 -fmodules -fimplicit-module-maps -fmodules-cache-path=%t -x objective-c -fmodule-name=category_other -emit-module %S/Inputs/module.map");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fmodules -fimplicit-module-maps '-fmodules-cache-path=${TEST_TEMP_DIR}/objc-categories.m.tmp' -I ${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs ${LLVM_SRC}/llvm/tools/clang/test/Modules/objc-categories.m -verify
    RUN(TestState.Failed, "%clang_cc1 -fmodules -fimplicit-module-maps -fmodules-cache-path=%t -I %S/Inputs %s -verify");
  }

  @Test
  public void test_objc_redef_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Modules/objc_redef.m");
    // rm -rf ${TEST_TEMP_DIR}/objc_redef.m.tmp
    RUN("rm -rf %t");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fmodules -fimplicit-module-maps -x objective-c '-fmodules-cache-path=${TEST_TEMP_DIR}/objc_redef.m.tmp' -emit-module -fmodule-name=redeclarations_left ${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs/module.map
    RUN("%clang_cc1 -fmodules -fimplicit-module-maps -x objective-c -fmodules-cache-path=%t -emit-module -fmodule-name=redeclarations_left %S/Inputs/module.map");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fmodules -fimplicit-module-maps -x objective-c '-fmodules-cache-path=${TEST_TEMP_DIR}/objc_redef.m.tmp' -emit-module -fmodule-name=weird_objc ${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs/module.map
    RUN("%clang_cc1 -fmodules -fimplicit-module-maps -x objective-c -fmodules-cache-path=%t -emit-module -fmodule-name=weird_objc %S/Inputs/module.map");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fmodules -fimplicit-module-maps '-fmodules-cache-path=${TEST_TEMP_DIR}/objc_redef.m.tmp' -I ${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs ${LLVM_SRC}/llvm/tools/clang/test/Modules/objc_redef.m -verify
    RUN("%clang_cc1 -fmodules -fimplicit-module-maps -fmodules-cache-path=%t -I %S/Inputs %s -verify");
  }

  @Test
  public void test_odr_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Modules/odr.cpp");
    // rm -rf ${TEST_TEMP_DIR}/odr.cpp.tmp
    RUN(TestState.Failed, "rm -rf %t");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x objective-c++ -fmodules -fimplicit-module-maps '-fmodules-cache-path=${TEST_TEMP_DIR}/odr.cpp.tmp' -I ${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs/odr ${LLVM_SRC}/llvm/tools/clang/test/Modules/odr.cpp -verify -std=c++11
    RUN(TestState.Failed, "%clang_cc1 -x objective-c++ -fmodules -fimplicit-module-maps -fmodules-cache-path=%t -I %S/Inputs/odr %s -verify -std=c++11");
  }

  @Test
  public void test_on_demand_build_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Modules/on-demand-build.m");
    // rm -rf ${TEST_TEMP_DIR}/on-demand-build.m.tmp
    RUN(TestState.Failed, "rm -rf %t");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fmodules -fimplicit-module-maps -fno-objc-infer-related-result-type -Werror -Wno-error=incomplete-umbrella '-fmodules-cache-path=${TEST_TEMP_DIR}/on-demand-build.m.tmp' -F ${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs -I ${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs -verify ${LLVM_SRC}/llvm/tools/clang/test/Modules/on-demand-build.m
    RUN(TestState.Failed, "%clang_cc1 -fmodules -fimplicit-module-maps -fno-objc-infer-related-result-type -Werror -Wno-error=incomplete-umbrella -fmodules-cache-path=%t -F %S/Inputs -I %S/Inputs -verify %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fmodules -fimplicit-module-maps -fno-objc-infer-related-result-type -Werror -Wno-error=incomplete-umbrella -x objective-c++ '-fmodules-cache-path=${TEST_TEMP_DIR}/on-demand-build.m.tmp' -F ${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs -I ${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs -verify ${LLVM_SRC}/llvm/tools/clang/test/Modules/on-demand-build.m
    RUN(TestState.Failed, "%clang_cc1 -fmodules -fimplicit-module-maps -fno-objc-infer-related-result-type -Werror -Wno-error=incomplete-umbrella -x objective-c++ -fmodules-cache-path=%t -F %S/Inputs -I %S/Inputs -verify %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fmodules -fimplicit-module-maps -fno-objc-infer-related-result-type -Werror -Wno-error=incomplete-umbrella '-fmodules-cache-path=${TEST_TEMP_DIR}/on-demand-build.m.tmp' -F ${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs -I ${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs -verify ${LLVM_SRC}/llvm/tools/clang/test/Modules/on-demand-build.m
    RUN(TestState.Failed, "%clang_cc1 -fmodules -fimplicit-module-maps -fno-objc-infer-related-result-type -Werror -Wno-error=incomplete-umbrella -fmodules-cache-path=%t -F %S/Inputs -I %S/Inputs -verify %s");
  }

  @Test
  public void test_on_demand_macros_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Modules/on-demand-macros.m");
    // rm -rf ${TEST_TEMP_DIR}/on-demand-macros.m.tmp
    RUN(TestState.Failed, "rm -rf %t");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fmodules -fimplicit-module-maps '-fmodules-cache-path=${TEST_TEMP_DIR}/on-demand-macros.m.tmp' -F ${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs -DFOO_RETURNS_INT_PTR -verify ${LLVM_SRC}/llvm/tools/clang/test/Modules/on-demand-macros.m
    RUN(TestState.Failed, "%clang_cc1 -fmodules -fimplicit-module-maps -fmodules-cache-path=%t -F %S/Inputs -DFOO_RETURNS_INT_PTR -verify %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fmodules -fimplicit-module-maps '-fmodules-cache-path=${TEST_TEMP_DIR}/on-demand-macros.m.tmp' -F ${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs -verify ${LLVM_SRC}/llvm/tools/clang/test/Modules/on-demand-macros.m
    RUN(TestState.Failed, "%clang_cc1 -fmodules -fimplicit-module-maps -fmodules-cache-path=%t -F %S/Inputs -verify %s");
  }

  @Test
  public void test_parse_attributes_modulemap() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Modules/parse-attributes.modulemap");
    // rm -rf ${TEST_TEMP_DIR}/parse-attributes.modulemap.tmp.modules
    RUN("rm -rf %t.modules");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fmodules '-fmodules-cache-path=${TEST_TEMP_DIR}/parse-attributes.modulemap.tmp.modules' '-fmodule-map-file=${LLVM_SRC}/llvm/tools/clang/test/Modules/parse-attributes.modulemap' '-I${LLVM_SRC}/llvm/tools/clang/test/Modules' -include Inputs/empty.h -fsyntax-only -x c++ /dev/null 2>&1 | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Modules/parse-attributes.modulemap
    RUN("not %clang_cc1 -fmodules -fmodules-cache-path=%t.modules -fmodule-map-file=%s -I%S -include \"Inputs/empty.h\" -fsyntax-only -x c++ /dev/null 2>&1")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_pch_module_macro_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Modules/pch-module-macro.m");
    // rm -rf ${TEST_TEMP_DIR}/pch-module-macro.m.tmp
    RUN("rm -rf %t");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-pch '-fmodules-cache-path=${TEST_TEMP_DIR}/pch-module-macro.m.tmp' -fmodules -fimplicit-module-maps -o ${TEST_TEMP_DIR}/pch-module-macro.m.tmp.pch -I ${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs -x objective-c-header ${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs/pch-import-module-with-macro.pch
    RUN("%clang_cc1 -emit-pch -fmodules-cache-path=%t -fmodules -fimplicit-module-maps -o %t.pch -I %S/Inputs -x objective-c-header %S/Inputs/pch-import-module-with-macro.pch");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc '-fmodules-cache-path=${TEST_TEMP_DIR}/pch-module-macro.m.tmp' -fmodules -fimplicit-module-maps -fsyntax-only -I ${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs -include-pch ${TEST_TEMP_DIR}/pch-module-macro.m.tmp.pch ${LLVM_SRC}/llvm/tools/clang/test/Modules/pch-module-macro.m -verify
    RUN("%clang_cc1 -fmodules-cache-path=%t -fmodules -fimplicit-module-maps -fsyntax-only -I %S/Inputs -include-pch %t.pch %s -verify");
  }

  @Test
  public void test_pch_used_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Modules/pch-used.m");
    // rm -rf ${TEST_TEMP_DIR}/pch-used.m.tmp
    RUN(TestState.Failed, "rm -rf %t");
    // mkdir ${TEST_TEMP_DIR}/pch-used.m.tmp
    RUN(TestState.Failed, "mkdir %t");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x objective-c-header -emit-pch ${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs/pch-used.h -o ${TEST_TEMP_DIR}/pch-used.m.tmp/pch-used.h.pch -fmodules -fimplicit-module-maps '-fmodules-cache-path=${TEST_TEMP_DIR}/pch-used.m.tmp/cache' -O0 -isystem ${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs/System/usr/include
    RUN(TestState.Failed, "%clang_cc1 -x objective-c-header -emit-pch %S/Inputs/pch-used.h -o %t/pch-used.h.pch -fmodules -fimplicit-module-maps -fmodules-cache-path=%t/cache -O0 -isystem %S/Inputs/System/usr/include");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/Modules/pch-used.m -include-pch ${TEST_TEMP_DIR}/pch-used.m.tmp/pch-used.h.pch -fmodules -fimplicit-module-maps '-fmodules-cache-path=${TEST_TEMP_DIR}/pch-used.m.tmp/cache' -O0 -isystem ${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs/System/usr/include -emit-llvm -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Modules/pch-used.m
    RUN(TestState.Failed, "%clang_cc1 %s -include-pch %t/pch-used.h.pch -fmodules -fimplicit-module-maps -fmodules-cache-path=%t/cache -O0 -isystem %S/Inputs/System/usr/include -emit-llvm -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_pch_container_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Modules/pch_container.m");
    // REQUIRES: x86-registered-target
    if (!CHECK_REQUIRES("x86-registered-target")) {
      return;
    }
    // rm -rf ${TEST_TEMP_DIR}/pch_container.m.tmp-MachO ${TEST_TEMP_DIR}/pch_container.m.tmp-ELF ${TEST_TEMP_DIR}/pch_container.m.tmp-ELF_SPLIT ${TEST_TEMP_DIR}/pch_container.m.tmp-COFF ${TEST_TEMP_DIR}/pch_container.m.tmp-raw
    RUN(TestState.Failed, "rm -rf %t-MachO %t-ELF %t-ELF_SPLIT %t-COFF %t-raw");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple=x86_64-apple-darwin -fmodules -fmodule-format=obj -fimplicit-module-maps -fdisable-module-hash '-fmodules-cache-path=${TEST_TEMP_DIR}/pch_container.m.tmp-MachO' -F ${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs ${LLVM_SRC}/llvm/tools/clang/test/Modules/pch_container.m
    RUN(TestState.Failed, "%clang_cc1 -triple=x86_64-apple-darwin -fmodules -fmodule-format=obj -fimplicit-module-maps -fdisable-module-hash -fmodules-cache-path=%t-MachO -F %S/Inputs %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple=x86_64-linux-elf -fmodules -fmodule-format=obj -fimplicit-module-maps -fdisable-module-hash '-fmodules-cache-path=${TEST_TEMP_DIR}/pch_container.m.tmp-ELF' -F ${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs ${LLVM_SRC}/llvm/tools/clang/test/Modules/pch_container.m
    RUN(TestState.Failed, "%clang_cc1 -triple=x86_64-linux-elf -fmodules -fmodule-format=obj -fimplicit-module-maps -fdisable-module-hash -fmodules-cache-path=%t-ELF -F %S/Inputs %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple=x86_64-windows-coff -fmodules -fmodule-format=obj -fimplicit-module-maps -fdisable-module-hash '-fmodules-cache-path=${TEST_TEMP_DIR}/pch_container.m.tmp-COFF' -F ${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs ${LLVM_SRC}/llvm/tools/clang/test/Modules/pch_container.m
    RUN(TestState.Failed, "%clang_cc1 -triple=x86_64-windows-coff -fmodules -fmodule-format=obj -fimplicit-module-maps -fdisable-module-hash -fmodules-cache-path=%t-COFF -F %S/Inputs %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple=x86_64-apple-darwin -fmodules -fmodule-format=raw -fimplicit-module-maps -fdisable-module-hash '-fmodules-cache-path=${TEST_TEMP_DIR}/pch_container.m.tmp-raw' -F ${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs ${LLVM_SRC}/llvm/tools/clang/test/Modules/pch_container.m
    RUN(TestState.Failed, "%clang_cc1 -triple=x86_64-apple-darwin -fmodules -fmodule-format=raw -fimplicit-module-maps -fdisable-module-hash -fmodules-cache-path=%t-raw -F %S/Inputs %s");
    // llvm-objdump -section-headers ${TEST_TEMP_DIR}/pch_container.m.tmp-MachO/DependsOnModule.pcm ${TEST_TEMP_DIR}/pch_container.m.tmp-ELF/DependsOnModule.pcm ${TEST_TEMP_DIR}/pch_container.m.tmp-COFF/DependsOnModule.pcm | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Modules/pch_container.m
    RUN(TestState.Failed, "llvm-objdump -section-headers %t-MachO/DependsOnModule.pcm %t-ELF/DependsOnModule.pcm %t-COFF/DependsOnModule.pcm")./*|*/
      I("FileCheck %s");
    // llvm-objdump -section-headers ${TEST_TEMP_DIR}/pch_container.m.tmp-raw/DependsOnModule.pcm
    RUN(TestState.Failed, "not llvm-objdump -section-headers %t-raw/DependsOnModule.pcm");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -split-dwarf-file t-split.dwo -triple=x86_64-linux-elf -fmodules -fimplicit-module-maps -fdisable-module-hash '-fmodules-cache-path=${TEST_TEMP_DIR}/pch_container.m.tmp-ELF_SPLIT' -F ${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs ${LLVM_SRC}/llvm/tools/clang/test/Modules/pch_container.m -o ${TEST_TEMP_DIR}/pch_container.m.tmp-split.o
    RUN(TestState.Failed, "%clang_cc1 -split-dwarf-file t-split.dwo -triple=x86_64-linux-elf -fmodules -fimplicit-module-maps -fdisable-module-hash -fmodules-cache-path=%t-ELF_SPLIT -F %S/Inputs %s -o %t-split.o");
  }

  @Test
  public void test_pr19692_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Modules/pr19692.cpp");
    // rm -rf ${TEST_TEMP_DIR}/pr19692.cpp.tmp
    RUN("rm -rf %t");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc '-I${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs/pr19692' -verify ${LLVM_SRC}/llvm/tools/clang/test/Modules/pr19692.cpp
    RUN("%clang_cc1 -I%S/Inputs/pr19692 -verify %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fmodules -fimplicit-module-maps '-fmodules-cache-path=${TEST_TEMP_DIR}/pr19692.cpp.tmp' '-I${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs/pr19692' -verify ${LLVM_SRC}/llvm/tools/clang/test/Modules/pr19692.cpp
    RUN("%clang_cc1 -fmodules -fimplicit-module-maps -fmodules-cache-path=%t -I%S/Inputs/pr19692 -verify %s");
  }

  @Test
  public void test_pr20399_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Modules/pr20399.cpp");
    // rm -rf ${TEST_TEMP_DIR}/pr20399.cpp.tmp
    RUN("rm -rf %t");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fmodules -fimplicit-module-maps '-fmodules-cache-path=${TEST_TEMP_DIR}/pr20399.cpp.tmp' -fmodule-name=libGdml -emit-module -x c++ -std=c++11 ${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs/PR20399/module.modulemap
    RUN("%clang_cc1 -fmodules -fimplicit-module-maps -fmodules-cache-path=%t -fmodule-name=libGdml -emit-module -x c++ -std=c++11 %S/Inputs/PR20399/module.modulemap");
  }

  @Test
  public void test_pr20786_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Modules/pr20786.cpp");
    // rm -rf ${TEST_TEMP_DIR}/pr20786.cpp.tmp
    RUN(TestState.Failed, "rm -rf %t");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fmodules -fimplicit-module-maps '-fmodules-cache-path=${TEST_TEMP_DIR}/pr20786.cpp.tmp' -fmodule-name=TBranchProxy -emit-module -x c++ ${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs/PR20786/module.modulemap
    RUN(TestState.Failed, "%clang_cc1 -fmodules -fimplicit-module-maps -fmodules-cache-path=%t -fmodule-name=TBranchProxy -emit-module -x c++ %S/Inputs/PR20786/module.modulemap");
  }

  @Test
  public void test_pr21217_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Modules/pr21217.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fmodules -fmodule-map-file=does-not-exist.modulemap -verify ${LLVM_SRC}/llvm/tools/clang/test/Modules/pr21217.cpp 2>&1 | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Modules/pr21217.cpp
    RUN("not %clang_cc1 -fmodules -fmodule-map-file=does-not-exist.modulemap -verify %s 2>&1")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_pr21547_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Modules/pr21547.cpp");
    // rm -rf ${TEST_TEMP_DIR}/pr21547.cpp.tmp
    RUN(TestState.Failed, "rm -rf %t");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc '-I${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs/PR21547' -verify ${LLVM_SRC}/llvm/tools/clang/test/Modules/pr21547.cpp
    RUN(TestState.Failed, "%clang_cc1 -I%S/Inputs/PR21547 -verify %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fmodules -fimplicit-module-maps '-fmodules-cache-path=${TEST_TEMP_DIR}/pr21547.cpp.tmp' '-I${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs/PR21547' -verify ${LLVM_SRC}/llvm/tools/clang/test/Modules/pr21547.cpp
    RUN(TestState.Failed, "%clang_cc1 -fmodules -fimplicit-module-maps -fmodules-cache-path=%t -I%S/Inputs/PR21547 -verify %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fmodules -fimplicit-module-maps '-fmodules-cache-path=${TEST_TEMP_DIR}/pr21547.cpp.tmp' '-I${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs/PR21547' -emit-llvm-only ${LLVM_SRC}/llvm/tools/clang/test/Modules/pr21547.cpp
    RUN(TestState.Failed, "%clang_cc1 -fmodules -fimplicit-module-maps -fmodules-cache-path=%t -I%S/Inputs/PR21547 -emit-llvm-only %s");
  }

  @Test
  public void test_pr21687_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Modules/pr21687.cpp");
    // rm -rf ${TEST_TEMP_DIR}/pr21687.cpp.tmp
    RUN(TestState.Failed, "rm -rf %t");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fmodules -fimplicit-module-maps '-fmodules-cache-path=${TEST_TEMP_DIR}/pr21687.cpp.tmp' '-I${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs/PR21687' -emit-llvm-only ${LLVM_SRC}/llvm/tools/clang/test/Modules/pr21687.cpp
    RUN(TestState.Failed, "%clang_cc1 -fmodules -fimplicit-module-maps -fmodules-cache-path=%t -I%S/Inputs/PR21687 -emit-llvm-only %s");
  }

  @Test
  public void test_pr24954_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Modules/pr24954.cpp");
    // rm -rf ${TEST_TEMP_DIR}/pr24954.cpp.tmp
    RUN("rm -rf %t");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc '-I${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs/PR24954' -verify ${LLVM_SRC}/llvm/tools/clang/test/Modules/pr24954.cpp
    RUN("%clang_cc1 -I%S/Inputs/PR24954 -verify %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fmodules -fimplicit-module-maps '-fmodules-cache-path=${TEST_TEMP_DIR}/pr24954.cpp.tmp' '-I${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs/PR24954' -verify ${LLVM_SRC}/llvm/tools/clang/test/Modules/pr24954.cpp
    RUN("%clang_cc1 -fmodules -fimplicit-module-maps -fmodules-cache-path=%t -I%S/Inputs/PR24954 -verify %s");
  }

  @Test
  public void test_pr25501_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Modules/pr25501.cpp");
    // rm -rf ${TEST_TEMP_DIR}/pr25501.cpp.tmp
    RUN(TestState.Failed, "rm -rf %t");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c++11 -fmodules '-fmodule-map-file=${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs/PR25501/module.modulemap' '-fmodules-cache-path=${TEST_TEMP_DIR}/pr25501.cpp.tmp' '-I${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs/PR25501' -verify ${LLVM_SRC}/llvm/tools/clang/test/Modules/pr25501.cpp
    RUN(TestState.Failed, "%clang_cc1 -std=c++11 -fmodules -fmodule-map-file=%S/Inputs/PR25501/module.modulemap -fmodules-cache-path=%t -I%S/Inputs/PR25501 -verify %s");
  }

  @Test
  public void test_pr26014_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Modules/pr26014.cpp");
    // rm -rf ${TEST_TEMP_DIR}/pr26014.cpp.tmp
    RUN(TestState.Failed, "rm -rf %t");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc '-I${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs/PR26014' -verify ${LLVM_SRC}/llvm/tools/clang/test/Modules/pr26014.cpp
    RUN(TestState.Failed, "%clang_cc1 -I%S/Inputs/PR26014 -verify %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fmodules '-fmodule-map-file=${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs/PR26014/module.modulemap' '-fmodules-cache-path=${TEST_TEMP_DIR}/pr26014.cpp.tmp' '-I${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs/PR26014' -verify ${LLVM_SRC}/llvm/tools/clang/test/Modules/pr26014.cpp
    RUN(TestState.Failed, "%clang_cc1 -fmodules -fmodule-map-file=%S/Inputs/PR26014/module.modulemap -fmodules-cache-path=%t -I%S/Inputs/PR26014 -verify %s");
  }

  @Test
  public void test_pr26179_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Modules/pr26179.cpp");
    // rm -rf ${TEST_TEMP_DIR}/pr26179.cpp.tmp
    RUN(TestState.Failed, "rm -rf %t");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc '-I${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs/PR26179' -verify ${LLVM_SRC}/llvm/tools/clang/test/Modules/pr26179.cpp
    RUN(TestState.Failed, "%clang_cc1 -I%S/Inputs/PR26179 -verify %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fmodules '-fmodule-map-file=${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs/PR26179/module.modulemap' '-fmodules-cache-path=${TEST_TEMP_DIR}/pr26179.cpp.tmp' '-I${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs/PR26179' -verify ${LLVM_SRC}/llvm/tools/clang/test/Modules/pr26179.cpp
    RUN(TestState.Failed, "%clang_cc1 -fmodules -fmodule-map-file=%S/Inputs/PR26179/module.modulemap -fmodules-cache-path=%t -I%S/Inputs/PR26179 -verify %s");
  }

  @Test
  public void test_pr27041_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Modules/pr27041.cpp");
    // rm -rf ${TEST_TEMP_DIR}/pr27041.cpp.tmp
    RUN(TestState.Failed, "rm -rf %t");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c++11 '-I${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs/PR27041' -verify ${LLVM_SRC}/llvm/tools/clang/test/Modules/pr27041.cpp
    RUN(TestState.Failed, "%clang_cc1 -std=c++11 -I%S/Inputs/PR27041 -verify %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c++11 -fmodules '-fmodule-map-file=${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs/PR27041/module.modulemap' '-fmodules-cache-path=${TEST_TEMP_DIR}/pr27041.cpp.tmp' '-I${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs/PR27041' -verify ${LLVM_SRC}/llvm/tools/clang/test/Modules/pr27041.cpp
    RUN(TestState.Failed, "%clang_cc1 -std=c++11 -fmodules -fmodule-map-file=%S/Inputs/PR27041/module.modulemap -fmodules-cache-path=%t -I%S/Inputs/PR27041 -verify %s");
  }

  @Test
  public void test_pr27186_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Modules/pr27186.cpp");
    // rm -rf ${TEST_TEMP_DIR}/pr27186.cpp.tmp
    RUN("rm -rf %t");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c++11 '-I${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs/PR27186' '-I${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs/PR27186/subdir/' -verify ${LLVM_SRC}/llvm/tools/clang/test/Modules/pr27186.cpp
    RUN("%clang_cc1 -std=c++11 -I%S/Inputs/PR27186  -I%S/Inputs/PR27186/subdir/ -verify %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -nostdsysteminc -std=c++11 -fmodules '-fmodule-map-file=${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs/PR27186/module.modulemap' '-fmodules-cache-path=${TEST_TEMP_DIR}/pr27186.cpp.tmp' '-I${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs/PR27186/' -verify ${LLVM_SRC}/llvm/tools/clang/test/Modules/pr27186.cpp
    RUN("%clang_cc1  -nostdsysteminc -std=c++11 -fmodules  -fmodule-map-file=%S/Inputs/PR27186/module.modulemap -fmodules-cache-path=%t -I%S/Inputs/PR27186/ -verify %s");
  }

  @Test
  public void test_pr27401_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Modules/pr27401.cpp");
    // rm -rf ${TEST_TEMP_DIR}/pr27401.cpp.tmp
    RUN(TestState.Failed, "rm -rf %t");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c++11 '-I${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs/PR27401' -verify ${LLVM_SRC}/llvm/tools/clang/test/Modules/pr27401.cpp
    RUN(TestState.Failed, "%clang_cc1 -std=c++11 -I%S/Inputs/PR27401 -verify %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c++11 -fmodules '-fmodule-map-file=${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs/PR27401/module.modulemap' '-fmodules-cache-path=${TEST_TEMP_DIR}/pr27401.cpp.tmp' '-I${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs/PR27401' -verify ${LLVM_SRC}/llvm/tools/clang/test/Modules/pr27401.cpp
    RUN(TestState.Failed, "%clang_cc1 -std=c++11 -fmodules -fmodule-map-file=%S/Inputs/PR27401/module.modulemap -fmodules-cache-path=%t -I%S/Inputs/PR27401 -verify %s");
  }

  @Test
  public void test_pr27513_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Modules/pr27513.cpp");
    // rm -rf ${TEST_TEMP_DIR}/pr27513.cpp.tmp
    RUN(TestState.Failed, "rm -rf %t");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c++11 '-I${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs/PR27513' -verify ${LLVM_SRC}/llvm/tools/clang/test/Modules/pr27513.cpp
    RUN(TestState.Failed, "%clang_cc1 -std=c++11 -I%S/Inputs/PR27513 -verify %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c++11 -fmodules '-fmodule-map-file=${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs/PR27513/module.modulemap' '-fmodules-cache-path=${TEST_TEMP_DIR}/pr27513.cpp.tmp' '-I${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs/PR27513' -verify ${LLVM_SRC}/llvm/tools/clang/test/Modules/pr27513.cpp
    RUN(TestState.Failed, "%clang_cc1 -std=c++11 -fmodules -fmodule-map-file=%S/Inputs/PR27513/module.modulemap -fmodules-cache-path=%t -I%S/Inputs/PR27513 -verify %s");
  }

  @Test
  public void test_pr27739_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Modules/pr27739.cpp");
    // rm -rf ${TEST_TEMP_DIR}/pr27739.cpp.tmp
    RUN(TestState.Failed, "rm -rf %t");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c++11 -internal-externc-isystem ${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs/PR27739 -verify ${LLVM_SRC}/llvm/tools/clang/test/Modules/pr27739.cpp
    RUN(TestState.Failed, "%clang_cc1 -std=c++11 -internal-externc-isystem %S/Inputs/PR27739 -verify %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c++11 -fmodules '-fmodule-map-file=${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs/PR27739/module.modulemap' '-fmodules-cache-path=${TEST_TEMP_DIR}/pr27739.cpp.tmp' -internal-externc-isystem ${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs/PR27739/ -verify ${LLVM_SRC}/llvm/tools/clang/test/Modules/pr27739.cpp
    RUN(TestState.Failed, "%clang_cc1 -std=c++11 -fmodules -fmodule-map-file=%S/Inputs/PR27739/module.modulemap -fmodules-cache-path=%t -internal-externc-isystem %S/Inputs/PR27739/ -verify %s");
  }

  @Test
  public void test_pr27754_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Modules/pr27754.cpp");
    // rm -rf ${TEST_TEMP_DIR}/pr27754.cpp.tmp
    RUN(TestState.Failed, "rm -rf %t");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c++11 '-I${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs/PR27754' -verify ${LLVM_SRC}/llvm/tools/clang/test/Modules/pr27754.cpp
    RUN(TestState.Failed, "%clang_cc1 -std=c++11 -I%S/Inputs/PR27754 -verify %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c++11 -fmodules '-fmodule-map-file=${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs/PR27754/module.modulemap' '-fmodules-cache-path=${TEST_TEMP_DIR}/pr27754.cpp.tmp' '-I${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs/PR27754/' -verify ${LLVM_SRC}/llvm/tools/clang/test/Modules/pr27754.cpp
    RUN(TestState.Failed, "%clang_cc1 -std=c++11 -fmodules -fmodule-map-file=%S/Inputs/PR27754/module.modulemap -fmodules-cache-path=%t -I%S/Inputs/PR27754/ -verify %s");
  }

  @Test
  public void test_pr27890_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Modules/pr27890.cpp");
    // rm -rf ${TEST_TEMP_DIR}/pr27890.cpp.tmp
    RUN("rm -rf %t");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c++11 '-I${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs/PR27890' -verify ${LLVM_SRC}/llvm/tools/clang/test/Modules/pr27890.cpp
    RUN("%clang_cc1 -std=c++11 -I%S/Inputs/PR27890 -verify %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c++11 -fmodules '-fmodule-map-file=${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs/PR27890/module.modulemap' '-fmodules-cache-path=${TEST_TEMP_DIR}/pr27890.cpp.tmp' '-I${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs/PR27890' -verify ${LLVM_SRC}/llvm/tools/clang/test/Modules/pr27890.cpp
    RUN("%clang_cc1 -std=c++11 -fmodules -fmodule-map-file=%S/Inputs/PR27890/module.modulemap -fmodules-cache-path=%t -I%S/Inputs/PR27890 -verify %s");
  }

  @Test
  public void test_pr28332_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Modules/pr28332.cpp");
    // rm -rf ${TEST_TEMP_DIR}/pr28332.cpp.tmp
    RUN("rm -rf %t");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c++11 '-I${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs/PR28332' -verify ${LLVM_SRC}/llvm/tools/clang/test/Modules/pr28332.cpp
    RUN("%clang_cc1 -std=c++11 -I%S/Inputs/PR28332 -verify %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c++11 -fmodules '-fmodule-map-file=${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs/PR28332/module.modulemap' '-fmodules-cache-path=${TEST_TEMP_DIR}/pr28332.cpp.tmp' '-I${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs/PR28332' -verify ${LLVM_SRC}/llvm/tools/clang/test/Modules/pr28332.cpp
    RUN("%clang_cc1 -std=c++11 -fmodules -fmodule-map-file=%S/Inputs/PR28332/module.modulemap -fmodules-cache-path=%t -I%S/Inputs/PR28332 -verify %s");
  }

  @Test
  public void test_preprocess_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Modules/preprocess.cpp");
    // rm -rf ${TEST_TEMP_DIR}/preprocess.cpp.tmp
    RUN(TestState.Failed, "rm -rf %t");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fmodules -fimplicit-module-maps '-fmodules-cache-path=${TEST_TEMP_DIR}/preprocess.cpp.tmp' -I ${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs -x c++ -E ${LLVM_SRC}/llvm/tools/clang/test/Modules/preprocess.cpp | ${LLVM_SRC}/build/bin/FileCheck -strict-whitespace ${LLVM_SRC}/llvm/tools/clang/test/Modules/preprocess.cpp --check-prefix=CHECK --check-prefix=CXX --check-prefix=CXX-DASHE
    RUN(TestState.Failed, "%clang_cc1 -fmodules -fimplicit-module-maps -fmodules-cache-path=%t -I %S/Inputs -x c++ -E %s")./*|*/
      I("FileCheck -strict-whitespace %s --check-prefix=CHECK --check-prefix=CXX --check-prefix=CXX-DASHE");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fmodules -fimplicit-module-maps '-fmodules-cache-path=${TEST_TEMP_DIR}/preprocess.cpp.tmp' -I ${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs -x objective-c -E ${LLVM_SRC}/llvm/tools/clang/test/Modules/preprocess.cpp | ${LLVM_SRC}/build/bin/FileCheck -strict-whitespace ${LLVM_SRC}/llvm/tools/clang/test/Modules/preprocess.cpp --check-prefix=CHECK --check-prefix=OBJC
    RUN(TestState.Failed, "%clang_cc1 -fmodules -fimplicit-module-maps -fmodules-cache-path=%t -I %S/Inputs -x objective-c -E %s")./*|*/
      I("FileCheck -strict-whitespace %s --check-prefix=CHECK --check-prefix=OBJC");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fmodules -fimplicit-module-maps '-fmodules-cache-path=${TEST_TEMP_DIR}/preprocess.cpp.tmp' -I ${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs -x c++ -E -frewrite-includes ${LLVM_SRC}/llvm/tools/clang/test/Modules/preprocess.cpp | ${LLVM_SRC}/build/bin/FileCheck -strict-whitespace ${LLVM_SRC}/llvm/tools/clang/test/Modules/preprocess.cpp --check-prefix=CHECK --check-prefix=CXX
    RUN(TestState.Failed, "%clang_cc1 -fmodules -fimplicit-module-maps -fmodules-cache-path=%t -I %S/Inputs -x c++ -E -frewrite-includes %s")./*|*/
      I("FileCheck -strict-whitespace %s --check-prefix=CHECK --check-prefix=CXX");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fmodules -fimplicit-module-maps '-fmodules-cache-path=${TEST_TEMP_DIR}/preprocess.cpp.tmp' -I ${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs -x objective-c -E -frewrite-includes ${LLVM_SRC}/llvm/tools/clang/test/Modules/preprocess.cpp | ${LLVM_SRC}/build/bin/FileCheck -strict-whitespace ${LLVM_SRC}/llvm/tools/clang/test/Modules/preprocess.cpp --check-prefix=CHECK --check-prefix=OBJC
    RUN(TestState.Failed, "%clang_cc1 -fmodules -fimplicit-module-maps -fmodules-cache-path=%t -I %S/Inputs -x objective-c -E -frewrite-includes %s")./*|*/
      I("FileCheck -strict-whitespace %s --check-prefix=CHECK --check-prefix=OBJC");
  }

  @Test
  public void test_preprocess_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Modules/preprocess.m");
    // rm -rf ${TEST_TEMP_DIR}/preprocess.m.tmp
    RUN(TestState.Failed, "rm -rf %t");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fmodules -fimplicit-module-maps '-fmodules-cache-path=${TEST_TEMP_DIR}/preprocess.m.tmp' -I ${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs -I ${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs/preprocess -include ${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs/preprocess-prefix.h -E ${LLVM_SRC}/llvm/tools/clang/test/Modules/preprocess.m | ${LLVM_SRC}/build/bin/FileCheck -strict-whitespace ${LLVM_SRC}/llvm/tools/clang/test/Modules/preprocess.m
    RUN(TestState.Failed, "%clang_cc1 -fmodules -fimplicit-module-maps -fmodules-cache-path=%t -I %S/Inputs -I %S/Inputs/preprocess -include %S/Inputs/preprocess-prefix.h -E %s")./*|*/
      I("FileCheck -strict-whitespace %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fmodules -fimplicit-module-maps '-fmodules-cache-path=${TEST_TEMP_DIR}/preprocess.m.tmp' -I ${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs -I ${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs/preprocess -x objective-c-header -emit-pch ${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs/preprocess-prefix.h -o ${TEST_TEMP_DIR}/preprocess.m.tmp.pch
    RUN(TestState.Failed, "%clang_cc1 -fmodules -fimplicit-module-maps -fmodules-cache-path=%t -I %S/Inputs -I %S/Inputs/preprocess -x objective-c-header -emit-pch %S/Inputs/preprocess-prefix.h -o %t.pch");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fmodules -fimplicit-module-maps '-fmodules-cache-path=${TEST_TEMP_DIR}/preprocess.m.tmp' -I ${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs -I ${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs/preprocess -include-pch ${TEST_TEMP_DIR}/preprocess.m.tmp.pch -E ${LLVM_SRC}/llvm/tools/clang/test/Modules/preprocess.m | ${LLVM_SRC}/build/bin/FileCheck -strict-whitespace ${LLVM_SRC}/llvm/tools/clang/test/Modules/preprocess.m
    RUN(TestState.Failed, "%clang_cc1 -fmodules -fimplicit-module-maps -fmodules-cache-path=%t -I %S/Inputs -I %S/Inputs/preprocess -include-pch %t.pch -E %s")./*|*/
      I("FileCheck -strict-whitespace %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fmodules -fimplicit-module-maps '-fmodules-cache-path=${TEST_TEMP_DIR}/preprocess.m.tmp' -I ${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs -I ${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs/preprocess -x objective-c++ -include ${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs/preprocess-prefix.h -E ${LLVM_SRC}/llvm/tools/clang/test/Modules/preprocess.m | ${LLVM_SRC}/build/bin/FileCheck -strict-whitespace ${LLVM_SRC}/llvm/tools/clang/test/Modules/preprocess.m
    RUN(TestState.Failed, "%clang_cc1 -fmodules -fimplicit-module-maps -fmodules-cache-path=%t -I %S/Inputs -I %S/Inputs/preprocess -x objective-c++ -include %S/Inputs/preprocess-prefix.h -E %s")./*|*/
      I("FileCheck -strict-whitespace %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fmodules -fimplicit-module-maps '-fmodules-cache-path=${TEST_TEMP_DIR}/preprocess.m.tmp' -I ${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs -I ${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs/preprocess -x objective-c++-header -emit-pch ${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs/preprocess-prefix.h -o ${TEST_TEMP_DIR}/preprocess.m.tmp.pch
    RUN(TestState.Failed, "%clang_cc1 -fmodules -fimplicit-module-maps -fmodules-cache-path=%t -I %S/Inputs -I %S/Inputs/preprocess -x objective-c++-header -emit-pch %S/Inputs/preprocess-prefix.h -o %t.pch");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fmodules -fimplicit-module-maps '-fmodules-cache-path=${TEST_TEMP_DIR}/preprocess.m.tmp' -I ${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs -I ${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs/preprocess -x objective-c++ -include-pch ${TEST_TEMP_DIR}/preprocess.m.tmp.pch -E ${LLVM_SRC}/llvm/tools/clang/test/Modules/preprocess.m | ${LLVM_SRC}/build/bin/FileCheck -strict-whitespace ${LLVM_SRC}/llvm/tools/clang/test/Modules/preprocess.m
    RUN(TestState.Failed, "%clang_cc1 -fmodules -fimplicit-module-maps -fmodules-cache-path=%t -I %S/Inputs -I %S/Inputs/preprocess -x objective-c++ -include-pch %t.pch -E %s")./*|*/
      I("FileCheck -strict-whitespace %s");
  }

  @Test
  public void test_private_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Modules/private.cpp");
    // rm -rf ${TEST_TEMP_DIR}/private.cpp.tmp
    RUN("rm -rf %t");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x objective-c '-fmodules-cache-path=${TEST_TEMP_DIR}/private.cpp.tmp' -fmodules -fimplicit-module-maps -I ${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs/private ${LLVM_SRC}/llvm/tools/clang/test/Modules/private.cpp -verify
    RUN("%clang_cc1 -x objective-c -fmodules-cache-path=%t -fmodules -fimplicit-module-maps -I %S/Inputs/private %s -verify");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x objective-c '-fmodules-cache-path=${TEST_TEMP_DIR}/private.cpp.tmp' -fmodules -fimplicit-module-maps -I ${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs/private ${LLVM_SRC}/llvm/tools/clang/test/Modules/private.cpp -fsyntax-only -Wno-private-header
    RUN("%clang_cc1 -x objective-c -fmodules-cache-path=%t -fmodules -fimplicit-module-maps -I %S/Inputs/private %s -fsyntax-only -Wno-private-header");
  }

  @Test
  public void test_private_modulemap() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Modules/private.modulemap");
    // rm -rf ${TEST_TEMP_DIR}/private.modulemap.tmp
    RUN("rm -rf %t");
    // cd ${LLVM_SRC}/llvm/tools/clang/test/Modules
    RUN("cd %S");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fmodules -x c++ -std=c++11 '-fmodules-cache-path=${TEST_TEMP_DIR}/private.modulemap.tmp' '-I${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs/private3' -emit-module -fmodule-name=A -o ${TEST_TEMP_DIR}/private.modulemap.tmp/m.pcm ${LLVM_SRC}/llvm/tools/clang/test/Modules/private.modulemap
    RUN("%clang_cc1 -fmodules -x c++ -std=c++11 -fmodules-cache-path=%t -I%S/Inputs/private3 -emit-module -fmodule-name=A -o %t/m.pcm %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fmodules -x c++ -std=c++11 '-fmodules-cache-path=${TEST_TEMP_DIR}/private.modulemap.tmp' '-I${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs/private3' -emit-module -fmodule-name=B -o ${TEST_TEMP_DIR}/private.modulemap.tmp/m.pcm ${LLVM_SRC}/llvm/tools/clang/test/Modules/private.modulemap
    RUN("%clang_cc1 -fmodules -x c++ -std=c++11 -fmodules-cache-path=%t -I%S/Inputs/private3 -emit-module -fmodule-name=B -o %t/m.pcm %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fmodules -x c++ -std=c++11 '-fmodules-cache-path=${TEST_TEMP_DIR}/private.modulemap.tmp' '-I${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs/private3' -emit-module -fmodule-name=C -o ${TEST_TEMP_DIR}/private.modulemap.tmp/m.pcm ${LLVM_SRC}/llvm/tools/clang/test/Modules/private.modulemap
    RUN("%clang_cc1 -fmodules -x c++ -std=c++11 -fmodules-cache-path=%t -I%S/Inputs/private3 -emit-module -fmodule-name=C -o %t/m.pcm %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fmodules -x c++ -std=c++11 '-fmodules-cache-path=${TEST_TEMP_DIR}/private.modulemap.tmp' '-I${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs/private3' -emit-module -fmodule-name=D -o ${TEST_TEMP_DIR}/private.modulemap.tmp/m.pcm ${LLVM_SRC}/llvm/tools/clang/test/Modules/private.modulemap
    RUN("%clang_cc1 -fmodules -x c++ -std=c++11 -fmodules-cache-path=%t -I%S/Inputs/private3 -emit-module -fmodule-name=D -o %t/m.pcm %s");
  }

  @Test
  public void test_private1_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Modules/private1.cpp");
    // rm -rf ${TEST_TEMP_DIR}/private1.cpp.tmp
    RUN("rm -rf %t");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x objective-c '-fmodules-cache-path=${TEST_TEMP_DIR}/private1.cpp.tmp' -fmodules -fimplicit-module-maps -I ${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs/private0 -I ${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs/private1 -I ${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs/private2 ${LLVM_SRC}/llvm/tools/clang/test/Modules/private1.cpp -verify
    RUN("%clang_cc1 -x objective-c -fmodules-cache-path=%t -fmodules -fimplicit-module-maps -I %S/Inputs/private0 -I %S/Inputs/private1 -I %S/Inputs/private2 %s -verify");
  }

  @Test
  public void test_prune_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Modules/prune.m");
    // REQUIRES: shell
    if (!CHECK_REQUIRES("shell")) {
      return;
    }
    // rm -rf ${TEST_TEMP_DIR}/prune.m.tmp
    RUN(TestState.Failed, "rm -rf %t");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -DIMPORT_DEPENDS_ON_MODULE -fmodules-ignore-macro=DIMPORT_DEPENDS_ON_MODULE -fmodules -fimplicit-module-maps -F ${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs '-fmodules-cache-path=${TEST_TEMP_DIR}/prune.m.tmp' ${LLVM_SRC}/llvm/tools/clang/test/Modules/prune.m -verify
    RUN(TestState.Failed, "%clang_cc1 -DIMPORT_DEPENDS_ON_MODULE -fmodules-ignore-macro=DIMPORT_DEPENDS_ON_MODULE -fmodules -fimplicit-module-maps -F %S/Inputs -fmodules-cache-path=%t %s -verify");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -DIMPORT_DEPENDS_ON_MODULE -fmodules-ignore-macro=DIMPORT_DEPENDS_ON_MODULE -fmodules -fimplicit-module-maps -F ${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs '-fmodules-cache-path=${TEST_TEMP_DIR}/prune.m.tmp' ${LLVM_SRC}/llvm/tools/clang/test/Modules/prune.m -verify
    RUN(TestState.Failed, "%clang_cc1 -DIMPORT_DEPENDS_ON_MODULE -fmodules-ignore-macro=DIMPORT_DEPENDS_ON_MODULE -fmodules -fimplicit-module-maps -F %S/Inputs -fmodules-cache-path=%t %s -verify");
    // ls ${TEST_TEMP_DIR}/prune.m.tmp | grep modules.timestamp
    RUN(TestState.Failed, "ls %t")./*|*/
      I("grep modules.timestamp");
    // ls -R ${TEST_TEMP_DIR}/prune.m.tmp | grep ^Module.*pcm
    RUN(TestState.Failed, "ls -R %t")./*|*/
      I("grep ^Module.*pcm");
    // ls -R ${TEST_TEMP_DIR}/prune.m.tmp | grep DependsOnModule.*pcm
    RUN(TestState.Failed, "ls -R %t")./*|*/
      I("grep DependsOnModule.*pcm");
    // touch -m -a -t 201101010000 ${TEST_TEMP_DIR}/prune.m.tmp/modules.timestamp
    RUN(TestState.Failed, "touch -m -a -t 201101010000 %t/modules.timestamp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fmodules -fimplicit-module-maps -F ${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs '-fmodules-cache-path=${TEST_TEMP_DIR}/prune.m.tmp' -fmodules -fmodules-prune-interval=172800 -fmodules-prune-after=345600 ${LLVM_SRC}/llvm/tools/clang/test/Modules/prune.m -verify
    RUN(TestState.Failed, "%clang_cc1 -fmodules -fimplicit-module-maps -F %S/Inputs -fmodules-cache-path=%t -fmodules -fmodules-prune-interval=172800 -fmodules-prune-after=345600 %s -verify");
    // ls ${TEST_TEMP_DIR}/prune.m.tmp | grep modules.timestamp
    RUN(TestState.Failed, "ls %t")./*|*/
      I("grep modules.timestamp");
    // ls -R ${TEST_TEMP_DIR}/prune.m.tmp | grep ^Module.*pcm
    RUN(TestState.Failed, "ls -R %t")./*|*/
      I("grep ^Module.*pcm");
    // ls -R ${TEST_TEMP_DIR}/prune.m.tmp | grep DependsOnModule.*pcm
    RUN(TestState.Failed, "ls -R %t")./*|*/
      I("grep DependsOnModule.*pcm");
    // find ${TEST_TEMP_DIR}/prune.m.tmp -name DependsOnModule*.pcm | xargs touch -a -t 201101010000
    RUN(TestState.Failed, "find %t -name DependsOnModule*.pcm")./*|*/
      I("xargs touch -a -t 201101010000");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fmodules -fimplicit-module-maps -F ${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs '-fmodules-cache-path=${TEST_TEMP_DIR}/prune.m.tmp' -fmodules -fmodules-prune-interval=172800 -fmodules-prune-after=345600 ${LLVM_SRC}/llvm/tools/clang/test/Modules/prune.m -verify
    RUN(TestState.Failed, "%clang_cc1 -fmodules -fimplicit-module-maps -F %S/Inputs -fmodules-cache-path=%t -fmodules -fmodules-prune-interval=172800 -fmodules-prune-after=345600 %s -verify");
    // ls ${TEST_TEMP_DIR}/prune.m.tmp | grep modules.timestamp
    RUN(TestState.Failed, "ls %t")./*|*/
      I("grep modules.timestamp");
    // ls -R ${TEST_TEMP_DIR}/prune.m.tmp | grep ^Module.*pcm
    RUN(TestState.Failed, "ls -R %t")./*|*/
      I("grep ^Module.*pcm");
    // ls -R ${TEST_TEMP_DIR}/prune.m.tmp | grep DependsOnModule.*pcm
    RUN(TestState.Failed, "ls -R %t")./*|*/
      I("grep DependsOnModule.*pcm");
    // touch -m -a -t 201101010000 ${TEST_TEMP_DIR}/prune.m.tmp/modules.timestamp
    RUN(TestState.Failed, "touch -m -a -t 201101010000 %t/modules.timestamp");
    // find ${TEST_TEMP_DIR}/prune.m.tmp -name DependsOnModule*.pcm | xargs touch -a -t 201101010000
    RUN(TestState.Failed, "find %t -name DependsOnModule*.pcm")./*|*/
      I("xargs touch -a -t 201101010000");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fmodules -fimplicit-module-maps -F ${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs '-fmodules-cache-path=${TEST_TEMP_DIR}/prune.m.tmp' -fmodules -fmodules-prune-interval=172800 -fmodules-prune-after=345600 ${LLVM_SRC}/llvm/tools/clang/test/Modules/prune.m -verify
    RUN(TestState.Failed, "%clang_cc1 -fmodules -fimplicit-module-maps -F %S/Inputs -fmodules-cache-path=%t -fmodules -fmodules-prune-interval=172800 -fmodules-prune-after=345600 %s -verify");
    // ls ${TEST_TEMP_DIR}/prune.m.tmp | grep modules.timestamp
    RUN(TestState.Failed, "ls %t")./*|*/
      I("grep modules.timestamp");
    // ls -R ${TEST_TEMP_DIR}/prune.m.tmp | grep ^Module.*pcm
    RUN(TestState.Failed, "ls -R %t")./*|*/
      I("grep ^Module.*pcm");
    // ls -R ${TEST_TEMP_DIR}/prune.m.tmp | not grep DependsOnModule.*pcm
    RUN(TestState.Failed, "ls -R %t")./*|*/
      I("not grep DependsOnModule.*pcm");
  }

  @Test
  public void test_public_private_modulemap() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Modules/public-private.modulemap");
    // rm -rf ${TEST_TEMP_DIR}/public-private.modulemap.tmp.modules
    RUN("rm -rf %t.modules");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fmodules '-fmodules-cache-path=${TEST_TEMP_DIR}/public-private.modulemap.tmp.modules' '-fmodule-map-file=${LLVM_SRC}/llvm/tools/clang/test/Modules/public-private.modulemap' '-I${LLVM_SRC}/llvm/tools/clang/test/Modules' -include Inputs/empty.h /dev/null
    RUN("%clang_cc1 -fmodules -fmodules-cache-path=%t.modules -fmodule-map-file=%s -I%S -include \"Inputs/empty.h\" /dev/null");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fmodules '-fmodules-cache-path=${TEST_TEMP_DIR}/public-private.modulemap.tmp.modules' '-fmodule-map-file=${LLVM_SRC}/llvm/tools/clang/test/Modules/public-private.modulemap' '-I${LLVM_SRC}/llvm/tools/clang/test/Modules' -include Inputs/dummy.h /dev/null
    RUN("%clang_cc1 -fmodules -fmodules-cache-path=%t.modules -fmodule-map-file=%s -I%S -include \"Inputs/dummy.h\" /dev/null");
  }

  @Test
  public void test_rebuild_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Modules/rebuild.m");
    // rm -rf ${TEST_TEMP_DIR}/rebuild.m.tmp
    RUN(TestState.Failed, "rm -rf %t");
    // echo '@import Module;' | ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fmodules -fimplicit-module-maps '-fmodules-cache-path=${TEST_TEMP_DIR}/rebuild.m.tmp' -fdisable-module-hash -fsyntax-only -F ${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs -x objective-c -
    RUN(TestState.Failed, "echo '@import Module;'")./*|*/
      I("%clang_cc1 -fmodules -fimplicit-module-maps -fmodules-cache-path=%t -fdisable-module-hash -fsyntax-only -F %S/Inputs -x objective-c -");
    // touch -m -a -t 201101010000 ${TEST_TEMP_DIR}/rebuild.m.tmp/Module.pcm
    RUN(TestState.Failed, "touch -m -a -t 201101010000 %t/Module.pcm");
    // cp ${TEST_TEMP_DIR}/rebuild.m.tmp/Module.pcm ${TEST_TEMP_DIR}/rebuild.m.tmp/Module.pcm.saved
    RUN(TestState.Failed, "cp %t/Module.pcm %t/Module.pcm.saved");
    // wc -c ${TEST_TEMP_DIR}/rebuild.m.tmp/Module.pcm > ${TEST_TEMP_DIR}/rebuild.m.tmp/Module.size.saved
    RUN(TestState.Failed, "wc -c %t/Module.pcm > %t/Module.size.saved");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fmodules -fimplicit-module-maps '-fmodules-cache-path=${TEST_TEMP_DIR}/rebuild.m.tmp' -fdisable-module-hash -fsyntax-only -F ${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs ${LLVM_SRC}/llvm/tools/clang/test/Modules/rebuild.m
    RUN(TestState.Failed, "%clang_cc1 -fmodules -fimplicit-module-maps -fmodules-cache-path=%t -fdisable-module-hash -fsyntax-only -F %S/Inputs %s");
    // diff ${TEST_TEMP_DIR}/rebuild.m.tmp/Module.pcm ${TEST_TEMP_DIR}/rebuild.m.tmp/Module.pcm.saved
    RUN(TestState.Failed, "diff %t/Module.pcm %t/Module.pcm.saved");
    // cp ${TEST_TEMP_DIR}/rebuild.m.tmp/DependsOnModule.pcm ${TEST_TEMP_DIR}/rebuild.m.tmp/DependsOnModule.pcm.saved
    RUN(TestState.Failed, "cp %t/DependsOnModule.pcm %t/DependsOnModule.pcm.saved");
    // rm ${TEST_TEMP_DIR}/rebuild.m.tmp/Module.pcm
    RUN(TestState.Failed, "rm %t/Module.pcm");
    // echo '@import Module;' | ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fmodules -fimplicit-module-maps '-fmodules-cache-path=${TEST_TEMP_DIR}/rebuild.m.tmp' -fdisable-module-hash -fsyntax-only -F ${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs -x objective-c -
    RUN(TestState.Failed, "echo '@import Module;'")./*|*/
      I("%clang_cc1 -fmodules -fimplicit-module-maps -fmodules-cache-path=%t -fdisable-module-hash -fsyntax-only -F %S/Inputs -x objective-c -");
    // touch -m -a -t 201101010000 ${TEST_TEMP_DIR}/rebuild.m.tmp/Module.pcm
    RUN(TestState.Failed, "touch -m -a -t 201101010000 %t/Module.pcm");
    // wc -c ${TEST_TEMP_DIR}/rebuild.m.tmp/Module.pcm > ${TEST_TEMP_DIR}/rebuild.m.tmp/Module.size
    RUN(TestState.Failed, "wc -c %t/Module.pcm > %t/Module.size");
    // diff ${TEST_TEMP_DIR}/rebuild.m.tmp/Module.size ${TEST_TEMP_DIR}/rebuild.m.tmp/Module.size.saved
    RUN(TestState.Failed, "diff %t/Module.size %t/Module.size.saved");
    // cp ${TEST_TEMP_DIR}/rebuild.m.tmp/Module.pcm ${TEST_TEMP_DIR}/rebuild.m.tmp/Module.pcm.saved.2
    RUN(TestState.Failed, "cp %t/Module.pcm %t/Module.pcm.saved.2");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fmodules -fimplicit-module-maps '-fmodules-cache-path=${TEST_TEMP_DIR}/rebuild.m.tmp' -fdisable-module-hash -fsyntax-only -F ${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs ${LLVM_SRC}/llvm/tools/clang/test/Modules/rebuild.m
    RUN(TestState.Failed, "%clang_cc1 -fmodules -fimplicit-module-maps -fmodules-cache-path=%t -fdisable-module-hash -fsyntax-only -F %S/Inputs %s");
    // diff ${TEST_TEMP_DIR}/rebuild.m.tmp/Module.pcm ${TEST_TEMP_DIR}/rebuild.m.tmp/Module.pcm.saved.2
    RUN(TestState.Failed, "diff %t/Module.pcm %t/Module.pcm.saved.2");
    // diff ${TEST_TEMP_DIR}/rebuild.m.tmp/DependsOnModule.pcm ${TEST_TEMP_DIR}/rebuild.m.tmp/DependsOnModule.pcm.saved
    RUN(TestState.Failed, "not diff %t/DependsOnModule.pcm %t/DependsOnModule.pcm.saved");
    // rm ${TEST_TEMP_DIR}/rebuild.m.tmp/Module.pcm
    RUN(TestState.Failed, "rm %t/Module.pcm");
    // echo '@import Module;' | ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fmodules -fimplicit-module-maps '-fmodules-cache-path=${TEST_TEMP_DIR}/rebuild.m.tmp' -fdisable-module-hash -fsyntax-only -F ${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs -x objective-c -
    RUN(TestState.Failed, "echo '@import Module;'")./*|*/
      I("%clang_cc1 -fmodules -fimplicit-module-maps -fmodules-cache-path=%t -fdisable-module-hash -fsyntax-only -F %S/Inputs -x objective-c -");
    // touch -m -a -t 201101010000 ${TEST_TEMP_DIR}/rebuild.m.tmp/Module.pcm
    RUN(TestState.Failed, "touch -m -a -t 201101010000 %t/Module.pcm");
    // wc -c ${TEST_TEMP_DIR}/rebuild.m.tmp/Module.pcm > ${TEST_TEMP_DIR}/rebuild.m.tmp/Module.size
    RUN(TestState.Failed, "wc -c %t/Module.pcm > %t/Module.size");
    // diff ${TEST_TEMP_DIR}/rebuild.m.tmp/Module.size ${TEST_TEMP_DIR}/rebuild.m.tmp/Module.size.saved
    RUN(TestState.Failed, "diff %t/Module.size %t/Module.size.saved");
    // cp ${TEST_TEMP_DIR}/rebuild.m.tmp/Module.pcm ${TEST_TEMP_DIR}/rebuild.m.tmp/Module.pcm.saved.2
    RUN(TestState.Failed, "cp %t/Module.pcm %t/Module.pcm.saved.2");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fmodules -fimplicit-module-maps '-fmodules-cache-path=${TEST_TEMP_DIR}/rebuild.m.tmp' -fdisable-module-hash -fsyntax-only -F ${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs ${LLVM_SRC}/llvm/tools/clang/test/Modules/rebuild.m
    RUN(TestState.Failed, "%clang_cc1 -fmodules -fimplicit-module-maps -fmodules-cache-path=%t -fdisable-module-hash -fsyntax-only -F %S/Inputs %s");
    // diff ${TEST_TEMP_DIR}/rebuild.m.tmp/Module.pcm ${TEST_TEMP_DIR}/rebuild.m.tmp/Module.pcm.saved.2
    RUN(TestState.Failed, "diff %t/Module.pcm %t/Module.pcm.saved.2");
    // diff ${TEST_TEMP_DIR}/rebuild.m.tmp/DependsOnModule.pcm ${TEST_TEMP_DIR}/rebuild.m.tmp/DependsOnModule.pcm.saved
    RUN(TestState.Failed, "not diff %t/DependsOnModule.pcm %t/DependsOnModule.pcm.saved");
  }

  @Test
  public void test_recursive_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Modules/recursive.c");
    // rm -rf ${TEST_TEMP_DIR}/recursive.c.tmp
    RUN("rm -rf %t");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fmodules -fimplicit-module-maps -x objective-c '-fmodules-cache-path=${TEST_TEMP_DIR}/recursive.c.tmp' -I ${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs ${LLVM_SRC}/llvm/tools/clang/test/Modules/recursive.c 2>&1 | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Modules/recursive.c
    RUN("not %clang_cc1 -fmodules -fimplicit-module-maps -x objective-c -fmodules-cache-path=%t -I %S/Inputs %s 2>&1")./*|*/
      I("FileCheck %s");
    // rm -rf ${TEST_TEMP_DIR}/recursive.c.tmp
    RUN("rm -rf %t");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fmodules -fimplicit-module-maps -x objective-c '-fmodules-cache-path=${TEST_TEMP_DIR}/recursive.c.tmp' -emit-module -fmodule-name=recursive1 ${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs/module.map 2>&1 | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Modules/recursive.c
    RUN("not %clang_cc1 -fmodules -fimplicit-module-maps -x objective-c -fmodules-cache-path=%t -emit-module -fmodule-name=recursive1 %S/Inputs/module.map 2>&1")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_recursive_visibility_mm() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Modules/recursive_visibility.mm");
    // rm -rf ${TEST_TEMP_DIR}/recursive_visibility.mm.tmp
    RUN("rm -rf %t");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x objective-c++ -fmodules -fimplicit-module-maps '-fmodules-cache-path=${TEST_TEMP_DIR}/recursive_visibility.mm.tmp' -I ${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs ${LLVM_SRC}/llvm/tools/clang/test/Modules/recursive_visibility.mm -verify -std=c++11
    RUN("%clang_cc1 -x objective-c++ -fmodules -fimplicit-module-maps -fmodules-cache-path=%t -I %S/Inputs %s -verify -std=c++11");
  }

  @Test
  public void test_redecl_add_after_load_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Modules/redecl-add-after-load.cpp");
    // rm -rf ${TEST_TEMP_DIR}/redecl-add-after-load.cpp.tmp
    RUN(TestState.Failed, "rm -rf %t");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x objective-c++ -fmodules -fimplicit-module-maps -fno-modules-error-recovery '-fmodules-cache-path=${TEST_TEMP_DIR}/redecl-add-after-load.cpp.tmp' -I ${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs ${LLVM_SRC}/llvm/tools/clang/test/Modules/redecl-add-after-load.cpp -verify -std=c++11
    RUN(TestState.Failed, "%clang_cc1 -x objective-c++ -fmodules -fimplicit-module-maps -fno-modules-error-recovery -fmodules-cache-path=%t -I %S/Inputs %s -verify -std=c++11");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x objective-c++ -fmodules -fimplicit-module-maps -fno-modules-error-recovery '-fmodules-cache-path=${TEST_TEMP_DIR}/redecl-add-after-load.cpp.tmp' -I ${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs ${LLVM_SRC}/llvm/tools/clang/test/Modules/redecl-add-after-load.cpp -verify -std=c++11 -DIMPORT_DECLS
    RUN(TestState.Failed, "%clang_cc1 -x objective-c++ -fmodules -fimplicit-module-maps -fno-modules-error-recovery -fmodules-cache-path=%t -I %S/Inputs %s -verify -std=c++11 -DIMPORT_DECLS");
  }

  @Test
  public void test_redecl_found_building_chains_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Modules/redecl-found-building-chains.cpp");
    // rm -rf ${TEST_TEMP_DIR}/redecl-found-building-chains.cpp.tmp
    RUN(TestState.Failed, "rm -rf %t");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fmodules -fimplicit-module-maps '-fmodules-cache-path=${TEST_TEMP_DIR}/redecl-found-building-chains.cpp.tmp' '-I${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs/redecl-found-building-chains' -verify ${LLVM_SRC}/llvm/tools/clang/test/Modules/redecl-found-building-chains.cpp
    RUN(TestState.Failed, "%clang_cc1 -fmodules -fimplicit-module-maps -fmodules-cache-path=%t -I%S/Inputs/redecl-found-building-chains -verify %s");
  }

  @Test
  public void test_redecl_merge_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Modules/redecl-merge.m");
    // rm -rf ${TEST_TEMP_DIR}/redecl-merge.m.tmp
    RUN(TestState.Failed, "rm -rf %t");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fmodules -fimplicit-module-maps -Wreturn-type '-fmodules-cache-path=${TEST_TEMP_DIR}/redecl-merge.m.tmp' -I ${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs ${LLVM_SRC}/llvm/tools/clang/test/Modules/redecl-merge.m -verify -Wno-objc-root-class
    RUN(TestState.Failed, "%clang_cc1 -fmodules -fimplicit-module-maps -Wreturn-type -fmodules-cache-path=%t -I %S/Inputs %s -verify -Wno-objc-root-class");
  }

  @Test
  public void test_redecl_merge2_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Modules/redecl-merge2.m");
    // rm -rf ${TEST_TEMP_DIR}/redecl-merge2.m.tmp
    RUN(TestState.Failed, "rm -rf %t");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fmodules -fimplicit-module-maps '-fmodules-cache-path=${TEST_TEMP_DIR}/redecl-merge2.m.tmp' -I ${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs ${LLVM_SRC}/llvm/tools/clang/test/Modules/redecl-merge2.m -verify -Wno-objc-root-class
    RUN(TestState.Failed, "%clang_cc1 -fmodules -fimplicit-module-maps -fmodules-cache-path=%t -I %S/Inputs %s -verify -Wno-objc-root-class");
  }

  @Test
  public void test_redecl_namespaces_mm() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Modules/redecl-namespaces.mm");
    // rm -rf ${TEST_TEMP_DIR}/redecl-namespaces.mm.tmp
    RUN(TestState.Failed, "rm -rf %t");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fmodules -fimplicit-module-maps -x objective-c++ '-fmodules-cache-path=${TEST_TEMP_DIR}/redecl-namespaces.mm.tmp' -emit-module -fmodule-name=redecl_namespaces_left ${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs/module.map
    RUN(TestState.Failed, "%clang_cc1 -fmodules -fimplicit-module-maps -x objective-c++ -fmodules-cache-path=%t -emit-module -fmodule-name=redecl_namespaces_left %S/Inputs/module.map");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fmodules -fimplicit-module-maps -x objective-c++ '-fmodules-cache-path=${TEST_TEMP_DIR}/redecl-namespaces.mm.tmp' -emit-module -fmodule-name=redecl_namespaces_right ${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs/module.map
    RUN(TestState.Failed, "%clang_cc1 -fmodules -fimplicit-module-maps -x objective-c++ -fmodules-cache-path=%t -emit-module -fmodule-name=redecl_namespaces_right %S/Inputs/module.map");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fmodules -fimplicit-module-maps '-fmodules-cache-path=${TEST_TEMP_DIR}/redecl-namespaces.mm.tmp' -I ${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs -w ${LLVM_SRC}/llvm/tools/clang/test/Modules/redecl-namespaces.mm -verify
    RUN(TestState.Failed, "%clang_cc1 -fmodules -fimplicit-module-maps -fmodules-cache-path=%t -I %S/Inputs -w %s -verify");
  }

  @Test
  public void test_redecl_templates_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Modules/redecl-templates.cpp");
    // rm -rf ${TEST_TEMP_DIR}/redecl-templates.cpp.tmp
    RUN(TestState.Failed, "rm -rf %t");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x c++ -I ${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs/redecl-templates ${LLVM_SRC}/llvm/tools/clang/test/Modules/redecl-templates.cpp -verify -std=c++14
    RUN(TestState.Failed, "%clang_cc1 -x c++ -I %S/Inputs/redecl-templates %s -verify -std=c++14");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x c++ -fmodules -fimplicit-module-maps '-fmodules-cache-path=${TEST_TEMP_DIR}/redecl-templates.cpp.tmp' -I ${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs/redecl-templates ${LLVM_SRC}/llvm/tools/clang/test/Modules/redecl-templates.cpp -verify -std=c++14
    RUN(TestState.Failed, "%clang_cc1 -x c++ -fmodules -fimplicit-module-maps -fmodules-cache-path=%t -I %S/Inputs/redecl-templates %s -verify -std=c++14");
  }

  @Test
  public void test_redeclarations_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Modules/redeclarations.m");
    // rm -rf ${TEST_TEMP_DIR}/redeclarations.m.tmp
    RUN(TestState.Failed, "rm -rf %t");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fmodules -fimplicit-module-maps -x objective-c '-fmodules-cache-path=${TEST_TEMP_DIR}/redeclarations.m.tmp' -emit-module -fmodule-name=redeclarations_left ${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs/module.map
    RUN(TestState.Failed, "%clang_cc1 -fmodules -fimplicit-module-maps -x objective-c -fmodules-cache-path=%t -emit-module -fmodule-name=redeclarations_left %S/Inputs/module.map");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fmodules -fimplicit-module-maps -x objective-c '-fmodules-cache-path=${TEST_TEMP_DIR}/redeclarations.m.tmp' -emit-module -fmodule-name=redeclarations_right ${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs/module.map
    RUN(TestState.Failed, "%clang_cc1 -fmodules -fimplicit-module-maps -x objective-c -fmodules-cache-path=%t -emit-module -fmodule-name=redeclarations_right %S/Inputs/module.map");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fmodules -fimplicit-module-maps '-fmodules-cache-path=${TEST_TEMP_DIR}/redeclarations.m.tmp' -I ${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs ${LLVM_SRC}/llvm/tools/clang/test/Modules/redeclarations.m -verify
    RUN(TestState.Failed, "%clang_cc1 -fmodules -fimplicit-module-maps -fmodules-cache-path=%t -I %S/Inputs %s -verify");
  }

  @Test
  public void test_redecls_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Modules/redecls.m");
    // rm -rf ${TEST_TEMP_DIR}/redecls.m.tmp.mcp
    RUN(TestState.Failed, "rm -rf %t.mcp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fmodules -fimplicit-module-maps ${LLVM_SRC}/llvm/tools/clang/test/Modules/redecls.m -emit-pch -o ${TEST_TEMP_DIR}/redecls.m.tmp1.pch '-fmodules-cache-path=${TEST_TEMP_DIR}/redecls.m.tmp.mcp' -I ${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs/redecls
    RUN(TestState.Failed, "%clang_cc1 -fmodules -fimplicit-module-maps %s -emit-pch -o %t1.pch -fmodules-cache-path=%t.mcp -I %S/Inputs/redecls");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fmodules -fimplicit-module-maps ${LLVM_SRC}/llvm/tools/clang/test/Modules/redecls.m -emit-pch -o ${TEST_TEMP_DIR}/redecls.m.tmp2.pch -include-pch ${TEST_TEMP_DIR}/redecls.m.tmp1.pch '-fmodules-cache-path=${TEST_TEMP_DIR}/redecls.m.tmp.mcp' -I ${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs/redecls
    RUN(TestState.Failed, "%clang_cc1 -fmodules -fimplicit-module-maps %s -emit-pch -o %t2.pch -include-pch %t1.pch -fmodules-cache-path=%t.mcp -I %S/Inputs/redecls");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fmodules -fimplicit-module-maps ${LLVM_SRC}/llvm/tools/clang/test/Modules/redecls.m -fsyntax-only -include-pch ${TEST_TEMP_DIR}/redecls.m.tmp2.pch -I ${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs/redecls '-fmodules-cache-path=${TEST_TEMP_DIR}/redecls.m.tmp.mcp' -verify
    RUN(TestState.Failed, "%clang_cc1 -fmodules -fimplicit-module-maps %s -fsyntax-only -include-pch %t2.pch -I %S/Inputs/redecls -fmodules-cache-path=%t.mcp -verify");
  }

  @Test
  public void test_relative_dep_gen_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Modules/relative-dep-gen.cpp");
    // cd ${LLVM_SRC}/llvm/tools/clang/test/Modules
    RUN(TestState.Failed, "cd %S");
    // rm -rf ${TEST_TEMP_DIR}/relative-dep-gen.cpp.tmp
    RUN(TestState.Failed, "rm -rf %t");
    // mkdir ${TEST_TEMP_DIR}/relative-dep-gen.cpp.tmp
    RUN(TestState.Failed, "mkdir %t");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -cc1 -fno-implicit-modules -fmodule-name=relative-dep-gen -emit-module -x c++ Inputs/relative-dep-gen.modulemap -dependency-file ${TEST_TEMP_DIR}/relative-dep-gen.cpp.tmp/build.d -MT mod.pcm -o ${TEST_TEMP_DIR}/relative-dep-gen.cpp.tmp/mod.pcm
    RUN(TestState.Failed, "%clang_cc1 -cc1 -fno-implicit-modules -fmodule-name=relative-dep-gen -emit-module -x c++ Inputs/relative-dep-gen.modulemap -dependency-file %t/build.d -MT mod.pcm -o %t/mod.pcm");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -cc1 -fno-implicit-modules -fmodule-map-file=Inputs/relative-dep-gen.modulemap '-fmodule-file=${TEST_TEMP_DIR}/relative-dep-gen.cpp.tmp/mod.pcm' -dependency-file ${TEST_TEMP_DIR}/relative-dep-gen.cpp.tmp/use-explicit.d -MT use.o relative-dep-gen.cpp -fsyntax-only
    RUN(TestState.Failed, "%clang_cc1 -cc1 -fno-implicit-modules -fmodule-map-file=Inputs/relative-dep-gen.modulemap -fmodule-file=%t/mod.pcm -dependency-file %t/use-explicit.d -MT use.o relative-dep-gen.cpp -fsyntax-only");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -cc1 -fno-implicit-modules -fmodule-map-file=Inputs/relative-dep-gen.modulemap -dependency-file ${TEST_TEMP_DIR}/relative-dep-gen.cpp.tmp/use-implicit.d relative-dep-gen.cpp -MT use.o -fsyntax-only
    RUN(TestState.Failed, "%clang_cc1 -cc1 -fno-implicit-modules -fmodule-map-file=Inputs/relative-dep-gen.modulemap -dependency-file %t/use-implicit.d relative-dep-gen.cpp -MT use.o -fsyntax-only");
    // ${LLVM_SRC}/build/bin/FileCheck --check-prefix=CHECK-BUILD ${LLVM_SRC}/llvm/tools/clang/test/Modules/relative-dep-gen.cpp < ${TEST_TEMP_DIR}/relative-dep-gen.cpp.tmp/build.d
    RUN(TestState.Failed, "FileCheck --check-prefix=CHECK-BUILD %s < %t/build.d");
    // ${LLVM_SRC}/build/bin/FileCheck --check-prefix=CHECK-USE ${LLVM_SRC}/llvm/tools/clang/test/Modules/relative-dep-gen.cpp < ${TEST_TEMP_DIR}/relative-dep-gen.cpp.tmp/use-explicit.d
    RUN(TestState.Failed, "FileCheck --check-prefix=CHECK-USE %s < %t/use-explicit.d");
    // ${LLVM_SRC}/build/bin/FileCheck --check-prefix=CHECK-USE ${LLVM_SRC}/llvm/tools/clang/test/Modules/relative-dep-gen.cpp < ${TEST_TEMP_DIR}/relative-dep-gen.cpp.tmp/use-implicit.d
    RUN(TestState.Failed, "FileCheck --check-prefix=CHECK-USE %s < %t/use-implicit.d");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -cc1 -fno-implicit-modules -fmodule-name=relative-dep-gen -emit-module -x c++ Inputs/relative-dep-gen-cwd.modulemap -dependency-file ${TEST_TEMP_DIR}/relative-dep-gen.cpp.tmp/build-cwd.d -MT mod.pcm -o ${TEST_TEMP_DIR}/relative-dep-gen.cpp.tmp/mod-cwd.pcm -fmodule-map-file-home-is-cwd
    RUN(TestState.Failed, "%clang_cc1 -cc1 -fno-implicit-modules -fmodule-name=relative-dep-gen -emit-module -x c++ Inputs/relative-dep-gen-cwd.modulemap -dependency-file %t/build-cwd.d -MT mod.pcm -o %t/mod-cwd.pcm -fmodule-map-file-home-is-cwd");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -cc1 -fno-implicit-modules -fmodule-map-file=Inputs/relative-dep-gen-cwd.modulemap '-fmodule-file=${TEST_TEMP_DIR}/relative-dep-gen.cpp.tmp/mod-cwd.pcm' -dependency-file ${TEST_TEMP_DIR}/relative-dep-gen.cpp.tmp/use-explicit-cwd.d -MT use.o relative-dep-gen.cpp -fsyntax-only -fmodule-map-file-home-is-cwd
    RUN(TestState.Failed, "%clang_cc1 -cc1 -fno-implicit-modules -fmodule-map-file=Inputs/relative-dep-gen-cwd.modulemap -fmodule-file=%t/mod-cwd.pcm -dependency-file %t/use-explicit-cwd.d -MT use.o relative-dep-gen.cpp -fsyntax-only -fmodule-map-file-home-is-cwd");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -cc1 -fno-implicit-modules -fmodule-map-file=Inputs/relative-dep-gen-cwd.modulemap -dependency-file ${TEST_TEMP_DIR}/relative-dep-gen.cpp.tmp/use-implicit-cwd.d relative-dep-gen.cpp -MT use.o -fsyntax-only -fmodule-map-file-home-is-cwd
    RUN(TestState.Failed, "%clang_cc1 -cc1 -fno-implicit-modules -fmodule-map-file=Inputs/relative-dep-gen-cwd.modulemap -dependency-file %t/use-implicit-cwd.d relative-dep-gen.cpp -MT use.o -fsyntax-only -fmodule-map-file-home-is-cwd");
    // ${LLVM_SRC}/build/bin/FileCheck --check-prefix=CHECK-BUILD ${LLVM_SRC}/llvm/tools/clang/test/Modules/relative-dep-gen.cpp < ${TEST_TEMP_DIR}/relative-dep-gen.cpp.tmp/build-cwd.d
    RUN(TestState.Failed, "FileCheck --check-prefix=CHECK-BUILD %s < %t/build-cwd.d");
    // ${LLVM_SRC}/build/bin/FileCheck --check-prefix=CHECK-USE ${LLVM_SRC}/llvm/tools/clang/test/Modules/relative-dep-gen.cpp < ${TEST_TEMP_DIR}/relative-dep-gen.cpp.tmp/use-explicit-cwd.d
    RUN(TestState.Failed, "FileCheck --check-prefix=CHECK-USE %s < %t/use-explicit-cwd.d");
    // ${LLVM_SRC}/build/bin/FileCheck --check-prefix=CHECK-USE ${LLVM_SRC}/llvm/tools/clang/test/Modules/relative-dep-gen.cpp < ${TEST_TEMP_DIR}/relative-dep-gen.cpp.tmp/use-implicit-cwd.d
    RUN(TestState.Failed, "FileCheck --check-prefix=CHECK-USE %s < %t/use-implicit-cwd.d");
    // mkdir ${TEST_TEMP_DIR}/relative-dep-gen.cpp.tmp/Inputs
    RUN(TestState.Failed, "mkdir %t/Inputs");
    // cp ${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs/relative-dep-gen-1.h ${TEST_TEMP_DIR}/relative-dep-gen.cpp.tmp/Inputs
    RUN(TestState.Failed, "cp %S/Inputs/relative-dep-gen-1.h %t/Inputs");
    // cp ${LLVM_SRC}/llvm/tools/clang/test/Modules/relative-dep-gen.cpp ${TEST_TEMP_DIR}/relative-dep-gen.cpp.tmp
    RUN(TestState.Failed, "cp %s %t");
    // cd ${TEST_TEMP_DIR}/relative-dep-gen.cpp.tmp
    RUN(TestState.Failed, "cd %t");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -cc1 -fno-implicit-modules '-fmodule-file=${TEST_TEMP_DIR}/relative-dep-gen.cpp.tmp/mod-cwd.pcm' -dependency-file ${TEST_TEMP_DIR}/relative-dep-gen.cpp.tmp/use-explicit-no-map-cwd.d -MT use.o relative-dep-gen.cpp -fsyntax-only -fmodule-map-file-home-is-cwd
    RUN(TestState.Failed, "%clang_cc1 -cc1 -fno-implicit-modules -fmodule-file=%t/mod-cwd.pcm -dependency-file %t/use-explicit-no-map-cwd.d -MT use.o relative-dep-gen.cpp -fsyntax-only -fmodule-map-file-home-is-cwd");
    // cat ${TEST_TEMP_DIR}/relative-dep-gen.cpp.tmp/use-explicit-no-map-cwd.d
    RUN(TestState.Failed, "cat %t/use-explicit-no-map-cwd.d");
    // ${LLVM_SRC}/build/bin/FileCheck --check-prefix=CHECK-USE ${LLVM_SRC}/llvm/tools/clang/test/Modules/relative-dep-gen.cpp < ${TEST_TEMP_DIR}/relative-dep-gen.cpp.tmp/use-explicit-no-map-cwd.d
    RUN(TestState.Failed, "FileCheck --check-prefix=CHECK-USE %s < %t/use-explicit-no-map-cwd.d");
  }

  @Test
  public void test_renamed_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Modules/renamed.m");
    // rm -rf ${TEST_TEMP_DIR}/renamed.m.tmp
    RUN("rm -rf %t");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fmodules -fimplicit-module-maps -I ${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs/oldname '-fmodules-cache-path=${TEST_TEMP_DIR}/renamed.m.tmp' ${LLVM_SRC}/llvm/tools/clang/test/Modules/renamed.m -verify
    RUN("%clang_cc1 -fmodules -fimplicit-module-maps -I %S/Inputs/oldname -fmodules-cache-path=%t %s -verify");
  }

  @Test
  public void test_require_modular_includes_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Modules/require-modular-includes.m");
    // rm -rf ${TEST_TEMP_DIR}/require-modular-includes.m.tmp
    RUN("rm -rf %t");
    // echo '@import FromImportedModuleOK;' | ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -Wnon-modular-include-in-framework-module -fmodules -fimplicit-module-maps '-fmodules-cache-path=${TEST_TEMP_DIR}/require-modular-includes.m.tmp' -F ${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs/require-modular-includes -Werror -fsyntax-only -x objective-c -
    RUN("echo '@import FromImportedModuleOK;'")./*|*/
      I("%clang_cc1 -Wnon-modular-include-in-framework-module -fmodules -fimplicit-module-maps -fmodules-cache-path=%t -F %S/Inputs/require-modular-includes -Werror -fsyntax-only -x objective-c -");
    // echo '@import FromImportedModuleFail;' | ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -Wnon-modular-include-in-framework-module -fmodules -fimplicit-module-maps '-fmodules-cache-path=${TEST_TEMP_DIR}/require-modular-includes.m.tmp' -F ${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs/require-modular-includes -I ${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs/require-modular-includes -fsyntax-only -x objective-c - 2>&1 | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Modules/require-modular-includes.m
    RUN("echo '@import FromImportedModuleFail;'")./*|*/
      I("%clang_cc1 -Wnon-modular-include-in-framework-module -fmodules -fimplicit-module-maps -fmodules-cache-path=%t -F %S/Inputs/require-modular-includes -I %S/Inputs/require-modular-includes -fsyntax-only -x objective-c - 2>&1")./*|*/
      I("FileCheck %s");
    // echo '@import FromSubframework;' | ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -Wnon-modular-include-in-framework-module -fmodules -fimplicit-module-maps '-fmodules-cache-path=${TEST_TEMP_DIR}/require-modular-includes.m.tmp' -F ${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs/require-modular-includes -Werror -fsyntax-only -x objective-c -
    RUN("echo '@import FromSubframework;'")./*|*/
      I("%clang_cc1 -Wnon-modular-include-in-framework-module -fmodules -fimplicit-module-maps -fmodules-cache-path=%t -F %S/Inputs/require-modular-includes -Werror -fsyntax-only -x objective-c -");
    // echo '@import FromNonModularSubframework;' | ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -Wnon-modular-include-in-framework-module -fmodules -fimplicit-module-maps '-fmodules-cache-path=${TEST_TEMP_DIR}/require-modular-includes.m.tmp' -F ${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs/require-modular-includes -I ${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs/require-modular-includes -fsyntax-only -x objective-c - 2>&1 | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Modules/require-modular-includes.m
    RUN("echo '@import FromNonModularSubframework;'")./*|*/
      I("%clang_cc1 -Wnon-modular-include-in-framework-module -fmodules -fimplicit-module-maps -fmodules-cache-path=%t -F %S/Inputs/require-modular-includes -I %S/Inputs/require-modular-includes -fsyntax-only -x objective-c - 2>&1")./*|*/
      I("FileCheck %s");
    // echo '@import FromImportedSubModule;' | ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -Wnon-modular-include-in-framework-module -fmodules -fimplicit-module-maps '-fmodules-cache-path=${TEST_TEMP_DIR}/require-modular-includes.m.tmp' -F ${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs/require-modular-includes -I ${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs/require-modular-includes -fsyntax-only -x objective-c - 2>&1 | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Modules/require-modular-includes.m
    RUN("echo '@import FromImportedSubModule;'")./*|*/
      I("%clang_cc1 -Wnon-modular-include-in-framework-module -fmodules -fimplicit-module-maps -fmodules-cache-path=%t -F %S/Inputs/require-modular-includes -I %S/Inputs/require-modular-includes -fsyntax-only -x objective-c - 2>&1")./*|*/
      I("FileCheck %s");
    // echo '#include "NotInModule.h"' | ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -Wnon-modular-include-in-framework-module -fmodules -fimplicit-module-maps '-fmodules-cache-path=${TEST_TEMP_DIR}/require-modular-includes.m.tmp' -I ${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs/require-modular-includes -Werror -fmodule-name=A -fsyntax-only -x objective-c -
    RUN("echo '#include \"NotInModule.h\"'")./*|*/
      I("%clang_cc1 -Wnon-modular-include-in-framework-module -fmodules -fimplicit-module-maps -fmodules-cache-path=%t -I %S/Inputs/require-modular-includes -Werror -fmodule-name=A -fsyntax-only -x objective-c -");
    // echo '@import IncludeExcluded;' | ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -Wnon-modular-include-in-framework-module -fmodules -fimplicit-module-maps '-fmodules-cache-path=${TEST_TEMP_DIR}/require-modular-includes.m.tmp' -F ${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs/require-modular-includes -Werror -fsyntax-only -x objective-c -
    RUN("echo '@import IncludeExcluded;'")./*|*/
      I("%clang_cc1 -Wnon-modular-include-in-framework-module -fmodules -fimplicit-module-maps -fmodules-cache-path=%t -F %S/Inputs/require-modular-includes -Werror -fsyntax-only -x objective-c -");
    // echo '@import FromAnotherModule;' | ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -Wnon-modular-include-in-framework-module -fmodules -fimplicit-module-maps '-fmodules-cache-path=${TEST_TEMP_DIR}/require-modular-includes.m.tmp' -F ${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs/require-modular-includes -I ${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs/require-modular-includes -Werror -fsyntax-only -x objective-c -
    RUN("echo '@import FromAnotherModule;'")./*|*/
      I("%clang_cc1 -Wnon-modular-include-in-framework-module -fmodules -fimplicit-module-maps -fmodules-cache-path=%t -F %S/Inputs/require-modular-includes -I %S/Inputs/require-modular-includes -Werror -fsyntax-only -x objective-c -");
    // echo '@import ExcludedFromAnotherModule;' | ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -Wnon-modular-include-in-framework-module -fmodules -fimplicit-module-maps '-fmodules-cache-path=${TEST_TEMP_DIR}/require-modular-includes.m.tmp' -F ${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs/require-modular-includes -I ${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs/require-modular-includes -Werror -fsyntax-only -x objective-c -
    RUN("echo '@import ExcludedFromAnotherModule;'")./*|*/
      I("%clang_cc1 -Wnon-modular-include-in-framework-module -fmodules -fimplicit-module-maps -fmodules-cache-path=%t -F %S/Inputs/require-modular-includes -I %S/Inputs/require-modular-includes -Werror -fsyntax-only -x objective-c -");
    // echo '@import FromUmbrella;' | ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -Wnon-modular-include-in-framework-module -fmodules -fimplicit-module-maps '-fmodules-cache-path=${TEST_TEMP_DIR}/require-modular-includes.m.tmp' -F ${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs/require-modular-includes -I ${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs/require-modular-includes -Werror -fsyntax-only -x objective-c -
    RUN("echo '@import FromUmbrella;'")./*|*/
      I("%clang_cc1 -Wnon-modular-include-in-framework-module -fmodules -fimplicit-module-maps -fmodules-cache-path=%t -F %S/Inputs/require-modular-includes -I %S/Inputs/require-modular-includes -Werror -fsyntax-only -x objective-c -");
    // echo '@import A;' | ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -Wnon-modular-include-in-framework-module -fmodules -fimplicit-module-maps '-fmodules-cache-path=${TEST_TEMP_DIR}/require-modular-includes.m.tmp' -F ${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs/require-modular-includes -I ${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs/require-modular-includes -fsyntax-only -x objective-c - 2>&1 | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Modules/require-modular-includes.m
    RUN("echo '@import A;'")./*|*/
      I("%clang_cc1 -Wnon-modular-include-in-framework-module -fmodules -fimplicit-module-maps -fmodules-cache-path=%t -F %S/Inputs/require-modular-includes -I %S/Inputs/require-modular-includes -fsyntax-only -x objective-c - 2>&1")./*|*/
      I("FileCheck %s");
    // echo '@import NotFramework;' | ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -Wnon-modular-include-in-framework-module -fmodules -fimplicit-module-maps '-fmodules-cache-path=${TEST_TEMP_DIR}/require-modular-includes.m.tmp' -I ${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs/require-modular-includes -Werror -fsyntax-only -x objective-c -
    RUN("echo '@import NotFramework;'")./*|*/
      I("%clang_cc1 -Wnon-modular-include-in-framework-module -fmodules -fimplicit-module-maps -fmodules-cache-path=%t -I %S/Inputs/require-modular-includes -Werror -fsyntax-only -x objective-c -");
  }

  @Test
  public void test_requires_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Modules/requires.m");
    // rm -rf ${TEST_TEMP_DIR}/requires.m.tmp
    RUN("rm -rf %t");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -Wauto-import '-fmodules-cache-path=${TEST_TEMP_DIR}/requires.m.tmp' -fmodules -fimplicit-module-maps -F ${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs ${LLVM_SRC}/llvm/tools/clang/test/Modules/requires.m -verify -fmodule-feature custom_req1
    RUN("%clang_cc1 -Wauto-import -fmodules-cache-path=%t -fmodules -fimplicit-module-maps -F %S/Inputs %s -verify -fmodule-feature custom_req1");
  }

  @Test
  public void test_requires_mm() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Modules/requires.mm");
    // rm -rf ${TEST_TEMP_DIR}/requires.mm.tmp
    RUN("rm -rf %t");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -Wauto-import '-fmodules-cache-path=${TEST_TEMP_DIR}/requires.mm.tmp' -fmodules -fimplicit-module-maps -F ${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs ${LLVM_SRC}/llvm/tools/clang/test/Modules/requires.mm -verify
    RUN("%clang_cc1 -Wauto-import -fmodules-cache-path=%t -fmodules -fimplicit-module-maps -F %S/Inputs %s -verify");
  }

  @Test
  public void test_resolution_change_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Modules/resolution-change.m");
    // rm -rf ${TEST_TEMP_DIR}/resolution-change.m.tmp
    RUN("rm -rf %t");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fmodules -fimplicit-module-maps '-fmodules-cache-path=${TEST_TEMP_DIR}/resolution-change.m.tmp' -I ${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs/modules-with-same-name/DependsOnA -I ${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs/modules-with-same-name/path1/A -emit-pch -o ${TEST_TEMP_DIR}/resolution-change.m.tmp-A.pch ${LLVM_SRC}/llvm/tools/clang/test/Modules/resolution-change.m
    RUN("%clang_cc1 -fmodules -fimplicit-module-maps -fmodules-cache-path=%t -I %S/Inputs/modules-with-same-name/DependsOnA -I %S/Inputs/modules-with-same-name/path1/A -emit-pch -o %t-A.pch %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fmodules -fimplicit-module-maps '-fmodules-cache-path=${TEST_TEMP_DIR}/resolution-change.m.tmp' -I ${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs/modules-with-same-name/DependsOnA -I ${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs/modules-with-same-name/path1/A -include-pch ${TEST_TEMP_DIR}/resolution-change.m.tmp-A.pch ${LLVM_SRC}/llvm/tools/clang/test/Modules/resolution-change.m -fsyntax-only -Werror
    RUN("%clang_cc1 -fmodules -fimplicit-module-maps -fmodules-cache-path=%t -I %S/Inputs/modules-with-same-name/DependsOnA -I %S/Inputs/modules-with-same-name/path1/A -include-pch %t-A.pch %s -fsyntax-only -Werror");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fmodules -fimplicit-module-maps '-fmodules-cache-path=${TEST_TEMP_DIR}/resolution-change.m.tmp' -I ${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs/modules-with-same-name/DependsOnA -I ${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs/modules-with-same-name/path1/A -include-pch ${TEST_TEMP_DIR}/resolution-change.m.tmp-A.pch ${LLVM_SRC}/llvm/tools/clang/test/Modules/resolution-change.m -fsyntax-only -Werror -Wauto-import
    RUN("%clang_cc1 -fmodules -fimplicit-module-maps -fmodules-cache-path=%t -I %S/Inputs/modules-with-same-name/DependsOnA -I %S/Inputs/modules-with-same-name/path1/A -include-pch %t-A.pch %s -fsyntax-only -Werror -Wauto-import");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fmodules -fimplicit-module-maps '-fmodules-cache-path=${TEST_TEMP_DIR}/resolution-change.m.tmp' -include-pch ${TEST_TEMP_DIR}/resolution-change.m.tmp-A.pch ${LLVM_SRC}/llvm/tools/clang/test/Modules/resolution-change.m -fsyntax-only 2>&1 | ${LLVM_SRC}/build/bin/FileCheck -check-prefix=CHECK-NODOA ${LLVM_SRC}/llvm/tools/clang/test/Modules/resolution-change.m
    RUN("not %clang_cc1 -fmodules -fimplicit-module-maps -fmodules-cache-path=%t -include-pch %t-A.pch %s -fsyntax-only 2>&1")./*|*/
      I("FileCheck -check-prefix=CHECK-NODOA %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fmodules -fimplicit-module-maps '-fmodules-cache-path=${TEST_TEMP_DIR}/resolution-change.m.tmp' -I ${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs/modules-with-same-name/DependsOnA -include-pch ${TEST_TEMP_DIR}/resolution-change.m.tmp-A.pch ${LLVM_SRC}/llvm/tools/clang/test/Modules/resolution-change.m -fsyntax-only 2>&1 | ${LLVM_SRC}/build/bin/FileCheck -check-prefix=CHECK-NOA ${LLVM_SRC}/llvm/tools/clang/test/Modules/resolution-change.m
    RUN("not %clang_cc1 -fmodules -fimplicit-module-maps -fmodules-cache-path=%t -I %S/Inputs/modules-with-same-name/DependsOnA -include-pch %t-A.pch %s -fsyntax-only 2>&1")./*|*/
      I("FileCheck -check-prefix=CHECK-NOA %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fmodules -fimplicit-module-maps '-fmodules-cache-path=${TEST_TEMP_DIR}/resolution-change.m.tmp' -I ${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs/modules-with-same-name/DependsOnA -I ${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs/modules-with-same-name/path2/A -include-pch ${TEST_TEMP_DIR}/resolution-change.m.tmp-A.pch ${LLVM_SRC}/llvm/tools/clang/test/Modules/resolution-change.m -fsyntax-only 2>&1 | ${LLVM_SRC}/build/bin/FileCheck -check-prefix=CHECK-WRONGA ${LLVM_SRC}/llvm/tools/clang/test/Modules/resolution-change.m
    RUN("not %clang_cc1 -fmodules -fimplicit-module-maps -fmodules-cache-path=%t -I %S/Inputs/modules-with-same-name/DependsOnA -I %S/Inputs/modules-with-same-name/path2/A -include-pch %t-A.pch %s -fsyntax-only 2>&1")./*|*/
      I("FileCheck -check-prefix=CHECK-WRONGA %s");
  }

  @Test
  public void test_self_import_header_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Modules/self-import-header.m");
    // REQUIRES: x86-registered-target
    if (!CHECK_REQUIRES("x86-registered-target")) {
      return;
    }
    // rm -rf ${TEST_TEMP_DIR}/self-import-header.m.tmp
    RUN(TestState.Failed, "rm -rf %t");
    // ${LLVM_SRC}/build/bin/clang -fsyntax-only -isysroot ${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs/System/usr/include -fmodules '-fmodules-cache-path=${TEST_TEMP_DIR}/self-import-header.m.tmp' -target x86_64-darwin -F ${LLVM_SRC}/llvm/tools/clang/test/Modules -F ${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs/self-import-header -I ${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs/self-import-header ${LLVM_SRC}/llvm/tools/clang/test/Modules/self-import-header.m -D__need_wint_t -Werror=implicit-function-declaration
    RUN(TestState.Failed, "%clang -fsyntax-only -isysroot %S/Inputs/System/usr/include -fmodules -fmodules-cache-path=%t -target x86_64-darwin -F %S -F %S/Inputs/self-import-header -I %S/Inputs/self-import-header %s -D__need_wint_t -Werror=implicit-function-declaration");
  }

  @Test
  public void test_separate_map_tree_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Modules/separate_map_tree.cpp");
    // rm -rf ${TEST_TEMP_DIR}/separate_map_tree.cpp.tmp
    RUN(TestState.Failed, "rm -rf %t");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc '-fmodules-cache-path=${TEST_TEMP_DIR}/separate_map_tree.cpp.tmp' -fmodules -fmodules-decluse -fmodule-name=A '-fmodule-map-file=${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs/separate_map_tree/maps/modulea.map' -I ${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs/separate_map_tree/src ${LLVM_SRC}/llvm/tools/clang/test/Modules/separate_map_tree.cpp -verify
    RUN(TestState.Failed, "%clang_cc1 -fmodules-cache-path=%t -fmodules -fmodules-decluse -fmodule-name=A -fmodule-map-file=%S/Inputs/separate_map_tree/maps/modulea.map -I %S/Inputs/separate_map_tree/src %s -verify");
  }

  @Test
  public void test_serialized_diags_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Modules/serialized-diags.m");
    // rm -rf ${TEST_TEMP_DIR}/serialized-diags.m.tmp ${TEST_TEMP_DIR}/serialized-diags.m.tmp.diag ${TEST_TEMP_DIR}/serialized-diags.m.tmp.out
    RUN("rm -rf %t %t.diag %t.out");
    // ${LLVM_SRC}/build/bin/clang -fmodules '-fmodules-cache-path=${TEST_TEMP_DIR}/serialized-diags.m.tmp/ModuleCache' -I ${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs/ModuleDiags -fsyntax-only ${LLVM_SRC}/llvm/tools/clang/test/Modules/serialized-diags.m --serialize-diagnostics ${TEST_TEMP_DIR}/serialized-diags.m.tmp.diag > /dev/null 2>&1
    RUN("%clang -fmodules -fmodules-cache-path=%t/ModuleCache -I %S/Inputs/ModuleDiags -fsyntax-only %s --serialize-diagnostics %t.diag > /dev/null 2>&1");
    // c-index-test -read-diagnostics ${TEST_TEMP_DIR}/serialized-diags.m.tmp.diag > ${TEST_TEMP_DIR}/serialized-diags.m.tmp.out 2>&1
    RUN("c-index-test -read-diagnostics %t.diag > %t.out 2>&1");
    // ${LLVM_SRC}/build/bin/FileCheck '--input-file=${TEST_TEMP_DIR}/serialized-diags.m.tmp.out' ${LLVM_SRC}/llvm/tools/clang/test/Modules/serialized-diags.m
    RUN("FileCheck --input-file=%t.out %s");
    // rm -rf ${TEST_TEMP_DIR}/serialized-diags.m.tmp ${TEST_TEMP_DIR}/serialized-diags.m.tmp.diag_errors ${TEST_TEMP_DIR}/serialized-diags.m.tmp.out_errors
    RUN("rm -rf %t %t.diag_errors %t.out_errors");
    // ${LLVM_SRC}/build/bin/clang -fmodules '-fmodules-cache-path=${TEST_TEMP_DIR}/serialized-diags.m.tmp/ModuleCache' -I ${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs/ModuleDiags -fsyntax-only -DWITH_ERRORS ${LLVM_SRC}/llvm/tools/clang/test/Modules/serialized-diags.m --serialize-diagnostics ${TEST_TEMP_DIR}/serialized-diags.m.tmp.diag_errors > /dev/null 2>&1
    RUN("not %clang -fmodules -fmodules-cache-path=%t/ModuleCache -I %S/Inputs/ModuleDiags -fsyntax-only -DWITH_ERRORS %s --serialize-diagnostics %t.diag_errors > /dev/null 2>&1");
    // c-index-test -read-diagnostics ${TEST_TEMP_DIR}/serialized-diags.m.tmp.diag_errors > ${TEST_TEMP_DIR}/serialized-diags.m.tmp.out_errors 2>&1
    RUN("c-index-test -read-diagnostics %t.diag_errors > %t.out_errors 2>&1");
    // ${LLVM_SRC}/build/bin/FileCheck -check-prefix=CHECK-WITH-ERRORS '--input-file=${TEST_TEMP_DIR}/serialized-diags.m.tmp.out_errors' ${LLVM_SRC}/llvm/tools/clang/test/Modules/serialized-diags.m
    RUN("FileCheck -check-prefix=CHECK-WITH-ERRORS --input-file=%t.out_errors %s");
  }

  @Test
  public void test_signal_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Modules/signal.m");
    // REQUIRES: crash-recovery,shell
    if (!CHECK_REQUIRES("crash-recovery,shell")) {
      return;
    }
    // rm -rf ${TEST_TEMP_DIR}/signal.m.tmp
    RUN(TestState.Failed, "rm -rf %t");
    // --crash ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fmodules -fimplicit-module-maps '-fmodules-cache-path=${TEST_TEMP_DIR}/signal.m.tmp' '-I${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs' ${LLVM_SRC}/llvm/tools/clang/test/Modules/signal.m
    RUN(TestState.Failed, "not --crash %clang_cc1 -fmodules -fimplicit-module-maps -fmodules-cache-path=%t -I%S/Inputs %s");
    // find ${TEST_TEMP_DIR}/signal.m.tmp -name crash-*.pcm.lock | ${LLVM_SRC}/build/bin/count 1
    RUN(TestState.Failed, "find %t -name \"crash-*.pcm.lock\"")./*|*/
      I("count 1");
    // find ${TEST_TEMP_DIR}/signal.m.tmp -name crash-*.pcm.lock-* | ${LLVM_SRC}/build/bin/count 0
    RUN(TestState.Failed, "find %t -name \"crash-*.pcm.lock-*\"")./*|*/
      I("count 0");
  }

  @Test
  public void test_stddef_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Modules/stddef.c");
    // rm -rf ${TEST_TEMP_DIR}/stddef.c.tmp
    RUN("rm -rf %t");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fmodules -fimplicit-module-maps '-fmodules-cache-path=${TEST_TEMP_DIR}/stddef.c.tmp' '-I${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs/StdDef' ${LLVM_SRC}/llvm/tools/clang/test/Modules/stddef.c -verify -fno-modules-error-recovery
    RUN("%clang_cc1 -fmodules -fimplicit-module-maps -fmodules-cache-path=%t -I%S/Inputs/StdDef %s -verify -fno-modules-error-recovery");
  }

  @Test
  public void test_stddef_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Modules/stddef.m");
    // rm -rf ${TEST_TEMP_DIR}/stddef.m.tmp
    RUN("rm -rf %t");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fmodules -fimplicit-module-maps '-fmodules-cache-path=${TEST_TEMP_DIR}/stddef.m.tmp' -I ${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs/StdDef ${LLVM_SRC}/llvm/tools/clang/test/Modules/stddef.m -verify
    RUN("%clang_cc1 -fmodules -fimplicit-module-maps -fmodules-cache-path=%t -I %S/Inputs/StdDef %s -verify");
  }

  @Test
  public void test_stress1_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Modules/stress1.cpp");
    // rm -rf ${TEST_TEMP_DIR}/stress1.cpp.tmp
    RUN(TestState.Failed, "rm -rf %t");
    // cd ${LLVM_SRC}/llvm/tools/clang/test/Modules
    RUN(TestState.Failed, "cd %S");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fmodules -x c++ -std=c++11 -I Inputs/stress1 -fno-implicit-modules '-fmodules-cache-path=${TEST_TEMP_DIR}/stress1.cpp.tmp' -fmodule-map-file-home-is-cwd -emit-module -fmodule-name=m00 -o ${TEST_TEMP_DIR}/stress1.cpp.tmp/m00.pcm Inputs/stress1/module.modulemap
    RUN(TestState.Failed, "%clang_cc1 -fmodules -x c++ -std=c++11 -I Inputs/stress1 -fno-implicit-modules -fmodules-cache-path=%t -fmodule-map-file-home-is-cwd -emit-module -fmodule-name=m00 -o %t/m00.pcm Inputs/stress1/module.modulemap");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fmodules -x c++ -std=c++11 -I Inputs/stress1 -fno-implicit-modules '-fmodules-cache-path=${TEST_TEMP_DIR}/stress1.cpp.tmp' -fmodule-map-file-home-is-cwd -emit-module -fmodule-name=m00 -o ${TEST_TEMP_DIR}/stress1.cpp.tmp/m00_check.pcm Inputs/stress1/module.modulemap
    RUN(TestState.Failed, "%clang_cc1 -fmodules -x c++ -std=c++11 -I Inputs/stress1 -fno-implicit-modules -fmodules-cache-path=%t -fmodule-map-file-home-is-cwd -emit-module -fmodule-name=m00 -o %t/m00_check.pcm Inputs/stress1/module.modulemap");
    // diff ${TEST_TEMP_DIR}/stress1.cpp.tmp/m00.pcm ${TEST_TEMP_DIR}/stress1.cpp.tmp/m00_check.pcm
    RUN(TestState.Failed, "diff %t/m00.pcm %t/m00_check.pcm");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fmodules -x c++ -std=c++11 -fdelayed-template-parsing -I Inputs/stress1 -fno-implicit-modules '-fmodules-cache-path=${TEST_TEMP_DIR}/stress1.cpp.tmp' -fmodule-map-file-home-is-cwd -emit-module -fmodule-name=m01 -o ${TEST_TEMP_DIR}/stress1.cpp.tmp/m01.pcm Inputs/stress1/module.modulemap
    RUN(TestState.Failed, "%clang_cc1 -fmodules -x c++ -std=c++11 -fdelayed-template-parsing -I Inputs/stress1 -fno-implicit-modules -fmodules-cache-path=%t -fmodule-map-file-home-is-cwd -emit-module -fmodule-name=m01 -o %t/m01.pcm Inputs/stress1/module.modulemap");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fmodules -x c++ -std=c++11 -fdelayed-template-parsing -I Inputs/stress1 -fno-implicit-modules '-fmodules-cache-path=${TEST_TEMP_DIR}/stress1.cpp.tmp' -fmodule-map-file-home-is-cwd -emit-module -fmodule-name=m01 -o ${TEST_TEMP_DIR}/stress1.cpp.tmp/m01_check.pcm Inputs/stress1/module.modulemap
    RUN(TestState.Failed, "%clang_cc1 -fmodules -x c++ -std=c++11 -fdelayed-template-parsing -I Inputs/stress1 -fno-implicit-modules -fmodules-cache-path=%t -fmodule-map-file-home-is-cwd -emit-module -fmodule-name=m01 -o %t/m01_check.pcm Inputs/stress1/module.modulemap");
    // diff ${TEST_TEMP_DIR}/stress1.cpp.tmp/m01.pcm ${TEST_TEMP_DIR}/stress1.cpp.tmp/m01_check.pcm
    RUN(TestState.Failed, "diff %t/m01.pcm %t/m01_check.pcm");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fmodules -x c++ -std=c++11 -I Inputs/stress1 -fno-implicit-modules '-fmodules-cache-path=${TEST_TEMP_DIR}/stress1.cpp.tmp' -fmodule-map-file-home-is-cwd -emit-module -fmodule-name=m02 -o ${TEST_TEMP_DIR}/stress1.cpp.tmp/m02.pcm Inputs/stress1/module.modulemap
    RUN(TestState.Failed, "%clang_cc1 -fmodules -x c++ -std=c++11 -I Inputs/stress1 -fno-implicit-modules -fmodules-cache-path=%t -fmodule-map-file-home-is-cwd -emit-module -fmodule-name=m02 -o %t/m02.pcm Inputs/stress1/module.modulemap");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fmodules -x c++ -std=c++11 -I Inputs/stress1 -fno-implicit-modules '-fmodules-cache-path=${TEST_TEMP_DIR}/stress1.cpp.tmp' -fmodule-map-file-home-is-cwd -emit-module -fmodule-name=m03 -o ${TEST_TEMP_DIR}/stress1.cpp.tmp/m03.pcm Inputs/stress1/module.modulemap
    RUN(TestState.Failed, "%clang_cc1 -fmodules -x c++ -std=c++11 -I Inputs/stress1 -fno-implicit-modules -fmodules-cache-path=%t -fmodule-map-file-home-is-cwd -emit-module -fmodule-name=m03 -o %t/m03.pcm Inputs/stress1/module.modulemap");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fmodules -x c++ -std=c++11 -I Inputs/stress1 -fno-implicit-modules '-fmodules-cache-path=${TEST_TEMP_DIR}/stress1.cpp.tmp' -fmodule-map-file-home-is-cwd '-fmodule-file=${TEST_TEMP_DIR}/stress1.cpp.tmp/m00.pcm' '-fmodule-file=${TEST_TEMP_DIR}/stress1.cpp.tmp/m01.pcm' '-fmodule-file=${TEST_TEMP_DIR}/stress1.cpp.tmp/m02.pcm' '-fmodule-file=${TEST_TEMP_DIR}/stress1.cpp.tmp/m03.pcm' -emit-module -fmodule-name=merge00 -o ${TEST_TEMP_DIR}/stress1.cpp.tmp/merge00.pcm Inputs/stress1/module.modulemap
    RUN(TestState.Failed, "%clang_cc1 -fmodules -x c++ -std=c++11 -I Inputs/stress1 -fno-implicit-modules -fmodules-cache-path=%t -fmodule-map-file-home-is-cwd -fmodule-file=%t/m00.pcm -fmodule-file=%t/m01.pcm -fmodule-file=%t/m02.pcm -fmodule-file=%t/m03.pcm -emit-module -fmodule-name=merge00 -o %t/merge00.pcm Inputs/stress1/module.modulemap");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fmodules -x c++ -std=c++11 -I Inputs/stress1 -fno-implicit-modules '-fmodules-cache-path=${TEST_TEMP_DIR}/stress1.cpp.tmp' -fmodule-map-file-home-is-cwd '-fmodule-file=${TEST_TEMP_DIR}/stress1.cpp.tmp/m00.pcm' '-fmodule-file=${TEST_TEMP_DIR}/stress1.cpp.tmp/m01.pcm' '-fmodule-file=${TEST_TEMP_DIR}/stress1.cpp.tmp/m02.pcm' '-fmodule-file=${TEST_TEMP_DIR}/stress1.cpp.tmp/m03.pcm' -emit-module -fmodule-name=merge00 -o ${TEST_TEMP_DIR}/stress1.cpp.tmp/merge00_check.pcm Inputs/stress1/module.modulemap
    RUN(TestState.Failed, "%clang_cc1 -fmodules -x c++ -std=c++11 -I Inputs/stress1 -fno-implicit-modules -fmodules-cache-path=%t -fmodule-map-file-home-is-cwd -fmodule-file=%t/m00.pcm -fmodule-file=%t/m01.pcm -fmodule-file=%t/m02.pcm -fmodule-file=%t/m03.pcm -emit-module -fmodule-name=merge00 -o %t/merge00_check.pcm Inputs/stress1/module.modulemap");
    // diff ${TEST_TEMP_DIR}/stress1.cpp.tmp/merge00.pcm ${TEST_TEMP_DIR}/stress1.cpp.tmp/merge00_check.pcm
    RUN(TestState.Failed, "diff %t/merge00.pcm %t/merge00_check.pcm");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fmodules -x c++ -std=c++11 -I Inputs/stress1 -fno-implicit-modules '-fmodules-cache-path=${TEST_TEMP_DIR}/stress1.cpp.tmp' -fmodule-map-file-home-is-cwd -fmodule-map-file=Inputs/stress1/module.modulemap '-fmodule-file=${TEST_TEMP_DIR}/stress1.cpp.tmp/m00.pcm' '-fmodule-file=${TEST_TEMP_DIR}/stress1.cpp.tmp/m01.pcm' '-fmodule-file=${TEST_TEMP_DIR}/stress1.cpp.tmp/m02.pcm' '-fmodule-file=${TEST_TEMP_DIR}/stress1.cpp.tmp/m03.pcm' '-fmodule-file=${TEST_TEMP_DIR}/stress1.cpp.tmp/merge00.pcm' -verify stress1.cpp -S -emit-llvm -o ${TEST_TEMP_DIR}/stress1.cpp.tmp/stress1.ll
    RUN(TestState.Failed, "%clang_cc1 -fmodules -x c++ -std=c++11 -I Inputs/stress1 -fno-implicit-modules -fmodules-cache-path=%t -fmodule-map-file-home-is-cwd -fmodule-map-file=Inputs/stress1/module.modulemap -fmodule-file=%t/m00.pcm -fmodule-file=%t/m01.pcm -fmodule-file=%t/m02.pcm -fmodule-file=%t/m03.pcm -fmodule-file=%t/merge00.pcm -verify stress1.cpp -S -emit-llvm -o %t/stress1.ll");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fmodules -x c++ -std=c++11 -I Inputs/stress1 -fno-implicit-modules '-fmodules-cache-path=${TEST_TEMP_DIR}/stress1.cpp.tmp' -fmodule-map-file-home-is-cwd -fmodule-map-file=Inputs/stress1/module.modulemap '-fmodule-file=${TEST_TEMP_DIR}/stress1.cpp.tmp/m00.pcm' '-fmodule-file=${TEST_TEMP_DIR}/stress1.cpp.tmp/m01.pcm' '-fmodule-file=${TEST_TEMP_DIR}/stress1.cpp.tmp/m02.pcm' '-fmodule-file=${TEST_TEMP_DIR}/stress1.cpp.tmp/m03.pcm' '-fmodule-file=${TEST_TEMP_DIR}/stress1.cpp.tmp/merge00.pcm' -verify stress1.cpp -S -emit-llvm -o ${TEST_TEMP_DIR}/stress1.cpp.tmp/stress1_check.ll
    RUN(TestState.Failed, "%clang_cc1 -fmodules -x c++ -std=c++11 -I Inputs/stress1 -fno-implicit-modules -fmodules-cache-path=%t -fmodule-map-file-home-is-cwd -fmodule-map-file=Inputs/stress1/module.modulemap -fmodule-file=%t/m00.pcm -fmodule-file=%t/m01.pcm -fmodule-file=%t/m02.pcm -fmodule-file=%t/m03.pcm -fmodule-file=%t/merge00.pcm -verify stress1.cpp -S -emit-llvm -o %t/stress1_check.ll");
    // diff -u ${TEST_TEMP_DIR}/stress1.cpp.tmp/stress1.ll ${TEST_TEMP_DIR}/stress1.cpp.tmp/stress1_check.ll
    RUN(TestState.Failed, "diff -u %t/stress1.ll %t/stress1_check.ll");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fmodules -x c++ -std=c++11 -I Inputs/stress1 '-fmodules-cache-path=${TEST_TEMP_DIR}/stress1.cpp.tmp' -fmodule-map-file-home-is-cwd '-fmodule-file=${TEST_TEMP_DIR}/stress1.cpp.tmp/m00.pcm' '-fmodule-file=${TEST_TEMP_DIR}/stress1.cpp.tmp/m01.pcm' '-fmodule-file=${TEST_TEMP_DIR}/stress1.cpp.tmp/m02.pcm' '-fmodule-file=${TEST_TEMP_DIR}/stress1.cpp.tmp/m03.pcm' -emit-module -fmodule-name=merge00 -o /dev/null -DMERGE_NO_REEXPORT Inputs/stress1/module.modulemap
    RUN(TestState.Failed, "%clang_cc1 -fmodules -x c++ -std=c++11 -I Inputs/stress1 -fmodules-cache-path=%t -fmodule-map-file-home-is-cwd -fmodule-file=%t/m00.pcm -fmodule-file=%t/m01.pcm -fmodule-file=%t/m02.pcm -fmodule-file=%t/m03.pcm -emit-module -fmodule-name=merge00 -o /dev/null -DMERGE_NO_REEXPORT Inputs/stress1/module.modulemap");
  }

  @Test
  public void test_strict_decluse_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Modules/strict-decluse.cpp");
    // rm -rf ${TEST_TEMP_DIR}/strict-decluse.cpp.tmp
    RUN("rm -rf %t");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fimplicit-module-maps '-fmodules-cache-path=${TEST_TEMP_DIR}/strict-decluse.cpp.tmp' -fmodules-strict-decluse -fmodule-name=XG -I ${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs/declare-use ${LLVM_SRC}/llvm/tools/clang/test/Modules/strict-decluse.cpp -verify
    RUN("%clang_cc1 -fimplicit-module-maps -fmodules-cache-path=%t -fmodules-strict-decluse -fmodule-name=XG -I %S/Inputs/declare-use %s -verify");
  }

  @Test
  public void test_string_names_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Modules/string_names.cpp");
    // rm -rf ${TEST_TEMP_DIR}/string_names.cpp.tmp
    RUN("rm -rf %t");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc '-fmodules-cache-path=${TEST_TEMP_DIR}/string_names.cpp.tmp' -fmodules -fimplicit-module-maps -fmodules-decluse -I ${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs/string_names ${LLVM_SRC}/llvm/tools/clang/test/Modules/string_names.cpp '-fmodule-name="my/module-a"' -verify
    RUN("%clang_cc1 -fmodules-cache-path=%t -fmodules -fimplicit-module-maps -fmodules-decluse -I %S/Inputs/string_names %s -fmodule-name=\"my/module-a\" -verify");
  }

  @Test
  public void test_subframework_from_intermediate_path_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Modules/subframework-from-intermediate-path.m");
    // rm -rf ${TEST_TEMP_DIR}/subframework-from-intermediate-path.m.tmp
    RUN("rm -rf %t");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc '-fmodules-cache-path=${TEST_TEMP_DIR}/subframework-from-intermediate-path.m.tmp' -fmodules -fimplicit-module-maps -F ${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs -F ${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs/DependsOnModule.framework/Frameworks ${LLVM_SRC}/llvm/tools/clang/test/Modules/subframework-from-intermediate-path.m -verify
    RUN("%clang_cc1 -fmodules-cache-path=%t -fmodules -fimplicit-module-maps -F %S/Inputs -F %S/Inputs/DependsOnModule.framework/Frameworks %s -verify");
  }

  @Test
  public void test_subframeworks_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Modules/subframeworks.m");
    // rm -rf ${TEST_TEMP_DIR}/subframeworks.m.tmp
    RUN(TestState.Failed, "rm -rf %t");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -Wauto-import '-fmodules-cache-path=${TEST_TEMP_DIR}/subframeworks.m.tmp' -fmodules -fimplicit-module-maps -F ${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs -F ${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs/DependsOnModule.framework/Frameworks ${LLVM_SRC}/llvm/tools/clang/test/Modules/subframeworks.m -verify
    RUN(TestState.Failed, "%clang_cc1 -Wauto-import -fmodules-cache-path=%t -fmodules -fimplicit-module-maps -F %S/Inputs -F %S/Inputs/DependsOnModule.framework/Frameworks %s -verify");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x objective-c++ -Wauto-import '-fmodules-cache-path=${TEST_TEMP_DIR}/subframeworks.m.tmp' -fmodules -fimplicit-module-maps -F ${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs -F ${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs/DependsOnModule.framework/Frameworks ${LLVM_SRC}/llvm/tools/clang/test/Modules/subframeworks.m -verify
    RUN(TestState.Failed, "%clang_cc1 -x objective-c++ -Wauto-import -fmodules-cache-path=%t -fmodules -fimplicit-module-maps -F %S/Inputs -F %S/Inputs/DependsOnModule.framework/Frameworks %s -verify");
  }

  @Test
  public void test_submodule_visibility_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Modules/submodule-visibility.cpp");
    // rm -rf ${TEST_TEMP_DIR}/submodule-visibility.cpp.tmp
    RUN(TestState.Failed, "rm -rf %t");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fmodules -fimplicit-module-maps '-fmodules-cache-path=${TEST_TEMP_DIR}/submodule-visibility.cpp.tmp' '-I${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs/submodule-visibility' -verify ${LLVM_SRC}/llvm/tools/clang/test/Modules/submodule-visibility.cpp -DALLOW_NAME_LEAKAGE
    RUN(TestState.Failed, "%clang_cc1 -fmodules -fimplicit-module-maps -fmodules-cache-path=%t -I%S/Inputs/submodule-visibility -verify %s -DALLOW_NAME_LEAKAGE");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fmodules -fimplicit-module-maps -fmodules-local-submodule-visibility '-fmodules-cache-path=${TEST_TEMP_DIR}/submodule-visibility.cpp.tmp' '-I${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs/submodule-visibility' -verify ${LLVM_SRC}/llvm/tools/clang/test/Modules/submodule-visibility.cpp -DIMPORT
    RUN(TestState.Failed, "%clang_cc1 -fmodules -fimplicit-module-maps -fmodules-local-submodule-visibility -fmodules-cache-path=%t -I%S/Inputs/submodule-visibility -verify %s -DIMPORT");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fmodules -fimplicit-module-maps -fmodules-local-submodule-visibility '-fmodules-cache-path=${TEST_TEMP_DIR}/submodule-visibility.cpp.tmp' -fmodule-name=x '-I${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs/submodule-visibility' -verify ${LLVM_SRC}/llvm/tools/clang/test/Modules/submodule-visibility.cpp
    RUN(TestState.Failed, "%clang_cc1 -fmodules -fimplicit-module-maps -fmodules-local-submodule-visibility -fmodules-cache-path=%t -fmodule-name=x -I%S/Inputs/submodule-visibility -verify %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fimplicit-module-maps -fmodules-local-submodule-visibility '-fmodules-cache-path=${TEST_TEMP_DIR}/submodule-visibility.cpp.tmp' '-I${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs/submodule-visibility' -verify ${LLVM_SRC}/llvm/tools/clang/test/Modules/submodule-visibility.cpp
    RUN(TestState.Failed, "%clang_cc1 -fimplicit-module-maps -fmodules-local-submodule-visibility -fmodules-cache-path=%t -I%S/Inputs/submodule-visibility -verify %s");
  }

  @Test
  public void test_submodule_visibility_cycles_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Modules/submodule-visibility-cycles.cpp");
    // rm -rf ${TEST_TEMP_DIR}/submodule-visibility-cycles.cpp.tmp
    RUN(TestState.Failed, "rm -rf %t");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fmodules -fimplicit-module-maps -fno-modules-error-recovery -fmodules-local-submodule-visibility '-fmodules-cache-path=${TEST_TEMP_DIR}/submodule-visibility-cycles.cpp.tmp' '-I${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs/submodule-visibility' -verify ${LLVM_SRC}/llvm/tools/clang/test/Modules/submodule-visibility-cycles.cpp
    RUN(TestState.Failed, "%clang_cc1 -fmodules -fimplicit-module-maps -fno-modules-error-recovery -fmodules-local-submodule-visibility -fmodules-cache-path=%t -I%S/Inputs/submodule-visibility -verify %s");
  }

  @Test
  public void test_submodules_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Modules/submodules.cpp");
    // rm -rf ${TEST_TEMP_DIR}/submodules.cpp.tmp
    RUN(TestState.Failed, "rm -rf %t");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x objective-c++ '-fmodules-cache-path=${TEST_TEMP_DIR}/submodules.cpp.tmp' -fmodules -fimplicit-module-maps -I ${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs/submodules ${LLVM_SRC}/llvm/tools/clang/test/Modules/submodules.cpp -verify
    RUN(TestState.Failed, "%clang_cc1 -x objective-c++ -fmodules-cache-path=%t -fmodules -fimplicit-module-maps -I %S/Inputs/submodules %s -verify");
  }

  @Test
  public void test_submodules_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Modules/submodules.m");
    // rm -rf ${TEST_TEMP_DIR}/submodules.m.tmp
    RUN("rm -rf %t");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -Wauto-import '-fmodules-cache-path=${TEST_TEMP_DIR}/submodules.m.tmp' -fmodules -fimplicit-module-maps -F ${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs ${LLVM_SRC}/llvm/tools/clang/test/Modules/submodules.m -verify
    RUN("%clang_cc1 -Wauto-import -fmodules-cache-path=%t -fmodules -fimplicit-module-maps -F %S/Inputs %s -verify");
  }

  @Test
  public void test_submodules_merge_defs_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Modules/submodules-merge-defs.cpp");
    // rm -rf ${TEST_TEMP_DIR}/submodules-merge-defs.cpp.tmp
    RUN(TestState.Failed, "rm -rf %t");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x c++ -std=c++11 '-fmodules-cache-path=${TEST_TEMP_DIR}/submodules-merge-defs.cpp.tmp' -fmodules -fimplicit-module-maps -I ${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs/submodules-merge-defs ${LLVM_SRC}/llvm/tools/clang/test/Modules/submodules-merge-defs.cpp -verify -fno-modules-error-recovery -DTEXTUAL
    RUN(TestState.Failed, "%clang_cc1 -x c++ -std=c++11 -fmodules-cache-path=%t -fmodules -fimplicit-module-maps -I %S/Inputs/submodules-merge-defs %s -verify -fno-modules-error-recovery -DTEXTUAL");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x c++ -std=c++11 '-fmodules-cache-path=${TEST_TEMP_DIR}/submodules-merge-defs.cpp.tmp' -fmodules -fimplicit-module-maps -I ${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs/submodules-merge-defs ${LLVM_SRC}/llvm/tools/clang/test/Modules/submodules-merge-defs.cpp -verify -fno-modules-error-recovery
    RUN(TestState.Failed, "%clang_cc1 -x c++ -std=c++11 -fmodules-cache-path=%t -fmodules -fimplicit-module-maps -I %S/Inputs/submodules-merge-defs %s -verify -fno-modules-error-recovery");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x c++ -std=c++11 '-fmodules-cache-path=${TEST_TEMP_DIR}/submodules-merge-defs.cpp.tmp' -fmodules -fimplicit-module-maps -I ${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs/submodules-merge-defs ${LLVM_SRC}/llvm/tools/clang/test/Modules/submodules-merge-defs.cpp -verify -fno-modules-error-recovery -fmodules-local-submodule-visibility -DTEXTUAL
    RUN(TestState.Failed, "%clang_cc1 -x c++ -std=c++11 -fmodules-cache-path=%t -fmodules -fimplicit-module-maps -I %S/Inputs/submodules-merge-defs %s -verify -fno-modules-error-recovery -fmodules-local-submodule-visibility -DTEXTUAL");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x c++ -std=c++11 '-fmodules-cache-path=${TEST_TEMP_DIR}/submodules-merge-defs.cpp.tmp' -fmodules -fimplicit-module-maps -I ${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs/submodules-merge-defs ${LLVM_SRC}/llvm/tools/clang/test/Modules/submodules-merge-defs.cpp -verify -fno-modules-error-recovery -fmodules-local-submodule-visibility
    RUN(TestState.Failed, "%clang_cc1 -x c++ -std=c++11 -fmodules-cache-path=%t -fmodules -fimplicit-module-maps -I %S/Inputs/submodules-merge-defs %s -verify -fno-modules-error-recovery -fmodules-local-submodule-visibility");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x c++ -std=c++11 '-fmodules-cache-path=${TEST_TEMP_DIR}/submodules-merge-defs.cpp.tmp' -fimplicit-module-maps -I ${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs/submodules-merge-defs ${LLVM_SRC}/llvm/tools/clang/test/Modules/submodules-merge-defs.cpp -verify -fno-modules-error-recovery -fmodules-local-submodule-visibility -DTEXTUAL -DEARLY_INDIRECT_INCLUDE
    RUN(TestState.Failed, "%clang_cc1 -x c++ -std=c++11 -fmodules-cache-path=%t -fimplicit-module-maps -I %S/Inputs/submodules-merge-defs %s -verify -fno-modules-error-recovery -fmodules-local-submodule-visibility -DTEXTUAL -DEARLY_INDIRECT_INCLUDE");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x c++ -std=c++11 '-fmodules-cache-path=${TEST_TEMP_DIR}/submodules-merge-defs.cpp.tmp' -fmodules -fimplicit-module-maps -I ${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs/submodules-merge-defs ${LLVM_SRC}/llvm/tools/clang/test/Modules/submodules-merge-defs.cpp -verify -fno-modules-error-recovery -fmodules-local-submodule-visibility -fmodule-feature use_defs_twice -DIMPORT_USE_2
    RUN(TestState.Failed, "%clang_cc1 -x c++ -std=c++11 -fmodules-cache-path=%t -fmodules -fimplicit-module-maps -I %S/Inputs/submodules-merge-defs %s -verify -fno-modules-error-recovery -fmodules-local-submodule-visibility -fmodule-feature use_defs_twice -DIMPORT_USE_2");
  }

  @Test
  public void test_submodules_preprocess_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Modules/submodules-preprocess.cpp");
    // rm -rf ${TEST_TEMP_DIR}/submodules-preprocess.cpp.tmp
    RUN(TestState.Failed, "rm -rf %t");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fmodules -fimplicit-module-maps -x objective-c++ -Eonly '-fmodules-cache-path=${TEST_TEMP_DIR}/submodules-preprocess.cpp.tmp' -I ${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs/submodules ${LLVM_SRC}/llvm/tools/clang/test/Modules/submodules-preprocess.cpp -verify
    RUN(TestState.Failed, "%clang_cc1 -fmodules -fimplicit-module-maps -x objective-c++ -Eonly -fmodules-cache-path=%t -I %S/Inputs/submodules %s -verify");
  }

  @Test
  public void test_suggest_include_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Modules/suggest-include.cpp");
    // rm -rf ${TEST_TEMP_DIR}/suggest-include.cpp.tmp
    RUN("rm -rf %t");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fmodules '-fmodules-cache-path=${TEST_TEMP_DIR}/suggest-include.cpp.tmp' -fimplicit-module-maps '-I${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs/suggest-include' ${LLVM_SRC}/llvm/tools/clang/test/Modules/suggest-include.cpp -verify
    RUN("%clang_cc1 -fmodules -fmodules-cache-path=%t -fimplicit-module-maps -I%S/Inputs/suggest-include %s -verify");
  }

  @Test
  public void test_system_headers_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Modules/system_headers.m");
    // rm -rf ${TEST_TEMP_DIR}/system_headers.m.tmp
    RUN("rm -rf %t");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i386-pc-solaris2.11 -fmodules -fimplicit-module-maps '-fmodules-cache-path=${TEST_TEMP_DIR}/system_headers.m.tmp/cache' -isystem ${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs -pedantic -Werror ${LLVM_SRC}/llvm/tools/clang/test/Modules/system_headers.m -verify -std=c11
    RUN("%clang_cc1 -triple %itanium_abi_triple -fmodules -fimplicit-module-maps -fmodules-cache-path=%t/cache -isystem %S/Inputs -pedantic -Werror %s -verify -std=c11");
  }

  @Test
  public void test_system_version_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Modules/system_version.m");
    // rm -rf ${TEST_TEMP_DIR}/system_version.m.tmp
    RUN(TestState.Failed, "rm -rf %t");
    // mkdir -p ${TEST_TEMP_DIR}/system_version.m.tmp/usr/include
    RUN(TestState.Failed, "mkdir -p %t/usr/include");
    // cp ${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs/Modified/A.h ${TEST_TEMP_DIR}/system_version.m.tmp/usr/include
    RUN(TestState.Failed, "cp %S/Inputs/Modified/A.h %t/usr/include");
    // cp ${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs/Modified/B.h ${TEST_TEMP_DIR}/system_version.m.tmp/usr/include
    RUN(TestState.Failed, "cp %S/Inputs/Modified/B.h %t/usr/include");
    // cp ${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs/Modified/module.map ${TEST_TEMP_DIR}/system_version.m.tmp/usr/include
    RUN(TestState.Failed, "cp %S/Inputs/Modified/module.map %t/usr/include");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc '-fmodules-cache-path=${TEST_TEMP_DIR}/system_version.m.tmp/cache' -fmodules -fimplicit-module-maps -isysroot ${TEST_TEMP_DIR}/system_version.m.tmp -I ${TEST_TEMP_DIR}/system_version.m.tmp/usr/include ${LLVM_SRC}/llvm/tools/clang/test/Modules/system_version.m -verify
    RUN(TestState.Failed, "%clang_cc1 -fmodules-cache-path=%t/cache -fmodules -fimplicit-module-maps -isysroot %t -I %t/usr/include %s -verify");
    // ls -R ${TEST_TEMP_DIR}/system_version.m.tmp | grep -c ModA.*pcm | grep 1
    RUN(TestState.Failed, "ls -R %t")./*|*/
      I("grep -c \"ModA.*pcm\"")./*|*/
      I("grep 1");
    // mkdir -p ${TEST_TEMP_DIR}/system_version.m.tmp/System/Library/CoreServices
    RUN(TestState.Failed, "mkdir -p %t/System/Library/CoreServices");
    // echo hello > ${TEST_TEMP_DIR}/system_version.m.tmp/System/Library/CoreServices/SystemVersion.plist
    RUN(TestState.Failed, "echo \"hello\" > %t/System/Library/CoreServices/SystemVersion.plist");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc '-fmodules-cache-path=${TEST_TEMP_DIR}/system_version.m.tmp/cache' -fmodules -fimplicit-module-maps -isysroot ${TEST_TEMP_DIR}/system_version.m.tmp -I ${TEST_TEMP_DIR}/system_version.m.tmp/usr/include ${LLVM_SRC}/llvm/tools/clang/test/Modules/system_version.m -verify
    RUN(TestState.Failed, "%clang_cc1 -fmodules-cache-path=%t/cache -fmodules -fimplicit-module-maps -isysroot %t -I %t/usr/include %s -verify");
    // ls -R ${TEST_TEMP_DIR}/system_version.m.tmp | grep -c ModA.*pcm | grep 2
    RUN(TestState.Failed, "ls -R %t")./*|*/
      I("grep -c \"ModA.*pcm\"")./*|*/
      I("grep 2");
    // mkdir -p ${TEST_TEMP_DIR}/system_version.m.tmp/System/Library/CoreServices
    RUN(TestState.Failed, "mkdir -p %t/System/Library/CoreServices");
    // echo modules > ${TEST_TEMP_DIR}/system_version.m.tmp/System/Library/CoreServices/SystemVersion.plist
    RUN(TestState.Failed, "echo \"modules\" > %t/System/Library/CoreServices/SystemVersion.plist");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc '-fmodules-cache-path=${TEST_TEMP_DIR}/system_version.m.tmp/cache' -fmodules -fimplicit-module-maps -isysroot ${TEST_TEMP_DIR}/system_version.m.tmp -I ${TEST_TEMP_DIR}/system_version.m.tmp/usr/include ${LLVM_SRC}/llvm/tools/clang/test/Modules/system_version.m -verify
    RUN(TestState.Failed, "%clang_cc1 -fmodules-cache-path=%t/cache -fmodules -fimplicit-module-maps -isysroot %t -I %t/usr/include %s -verify");
    // ls -R ${TEST_TEMP_DIR}/system_version.m.tmp | grep -c ModA.*pcm | grep 3
    RUN(TestState.Failed, "ls -R %t")./*|*/
      I("grep -c \"ModA.*pcm\"")./*|*/
      I("grep 3");
  }

  @Test
  public void test_tag_injection_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Modules/tag-injection.c");
    // rm -rf ${TEST_TEMP_DIR}/tag-injection.c.tmp
    RUN("rm -rf %t");
    // mkdir ${TEST_TEMP_DIR}/tag-injection.c.tmp
    RUN("mkdir %t");
    // echo 'struct a;' > ${TEST_TEMP_DIR}/tag-injection.c.tmp/a.h
    RUN("echo 'struct a;' > %t/a.h");
    // echo 'struct b {}; void foo(struct b*);' > ${TEST_TEMP_DIR}/tag-injection.c.tmp/b.h
    RUN("echo 'struct b {}; void foo(struct b*);' > %t/b.h");
    // echo 'module X { module a { header "a.h" } module b { header "b.h" } }' > ${TEST_TEMP_DIR}/tag-injection.c.tmp/x.modulemap
    RUN("echo 'module X { module a { header \"a.h\" } module b { header \"b.h\" } }' > %t/x.modulemap");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fmodules '-fmodules-cache-path=${TEST_TEMP_DIR}/tag-injection.c.tmp' '-fmodule-map-file=${TEST_TEMP_DIR}/tag-injection.c.tmp/x.modulemap' ${LLVM_SRC}/llvm/tools/clang/test/Modules/tag-injection.c '-I${TEST_TEMP_DIR}/tag-injection.c.tmp' -verify
    RUN("%clang_cc1 -fmodules -fmodules-cache-path=%t -fmodule-map-file=%t/x.modulemap %s -I%t -verify");
  }

  @Test
  public void test_tag_injection_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Modules/tag-injection.cpp");
    // rm -rf ${TEST_TEMP_DIR}/tag-injection.cpp.tmp
    RUN(TestState.Failed, "rm -rf %t");
    // mkdir ${TEST_TEMP_DIR}/tag-injection.cpp.tmp
    RUN(TestState.Failed, "mkdir %t");
    // echo 'struct tm;' > ${TEST_TEMP_DIR}/tag-injection.cpp.tmp/a.h
    RUN(TestState.Failed, "echo 'struct tm;' > %t/a.h");
    // echo 'struct X {}; void foo(struct tm*);' > ${TEST_TEMP_DIR}/tag-injection.cpp.tmp/b.h
    RUN(TestState.Failed, "echo 'struct X {}; void foo(struct tm*);' > %t/b.h");
    // echo 'module X { module a { header "a.h" } module b { header "b.h" } }' > ${TEST_TEMP_DIR}/tag-injection.cpp.tmp/x.modulemap
    RUN(TestState.Failed, "echo 'module X { module a { header \"a.h\" } module b { header \"b.h\" } }' > %t/x.modulemap");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fmodules '-fmodules-cache-path=${TEST_TEMP_DIR}/tag-injection.cpp.tmp' -x c++ '-fmodule-map-file=${TEST_TEMP_DIR}/tag-injection.cpp.tmp/x.modulemap' ${LLVM_SRC}/llvm/tools/clang/test/Modules/tag-injection.cpp '-I${TEST_TEMP_DIR}/tag-injection.cpp.tmp' -verify -std=c++11
    RUN(TestState.Failed, "%clang_cc1 -fmodules -fmodules-cache-path=%t -x c++ -fmodule-map-file=%t/x.modulemap %s -I%t -verify -std=c++11");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fmodules '-fmodules-cache-path=${TEST_TEMP_DIR}/tag-injection.cpp.tmp' -x c++ '-fmodule-map-file=${TEST_TEMP_DIR}/tag-injection.cpp.tmp/x.modulemap' ${LLVM_SRC}/llvm/tools/clang/test/Modules/tag-injection.cpp '-I${TEST_TEMP_DIR}/tag-injection.cpp.tmp' -verify -fmodules-local-submodule-visibility -std=c++11
    RUN(TestState.Failed, "%clang_cc1 -fmodules -fmodules-cache-path=%t -x c++ -fmodule-map-file=%t/x.modulemap %s -I%t -verify -fmodules-local-submodule-visibility -std=c++11");
  }

  @Test
  public void test_target_features_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Modules/target-features.m");
    // REQUIRES: x86-registered-target
    if (!CHECK_REQUIRES("x86-registered-target")) {
      return;
    }
    // REQUIRES: arm-registered-target
    if (!CHECK_REQUIRES("arm-registered-target")) {
      return;
    }
    // REQUIRES: aarch64-registered-target
    if (!CHECK_REQUIRES("aarch64-registered-target")) {
      return;
    }
    // rm -rf ${TEST_TEMP_DIR}/target-features.m.tmp
    RUN(TestState.Failed, "rm -rf %t");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple aarch64-unknown-unknown -fmodules '-fmodules-cache-path=${TEST_TEMP_DIR}/target-features.m.tmp' -fimplicit-module-maps -I ${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs -fsyntax-only ${LLVM_SRC}/llvm/tools/clang/test/Modules/target-features.m -verify -DSANITY_CHECK
    RUN(TestState.Failed, "%clang_cc1 -triple aarch64-unknown-unknown -fmodules -fmodules-cache-path=%t -fimplicit-module-maps -I %S/Inputs -fsyntax-only %s -verify -DSANITY_CHECK");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple armv7-unknown-unknown -fmodules '-fmodules-cache-path=${TEST_TEMP_DIR}/target-features.m.tmp' -fimplicit-module-maps -I ${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs -fsyntax-only ${LLVM_SRC}/llvm/tools/clang/test/Modules/target-features.m 2> ${TEST_TEMP_DIR}/target-features.m.tmp.aarch32
    RUN(TestState.Failed, "not %clang_cc1 -triple armv7-unknown-unknown -fmodules -fmodules-cache-path=%t -fimplicit-module-maps -I %S/Inputs -fsyntax-only  %s 2> %t.aarch32");
    // ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Modules/target-features.m -check-prefix=AARCH32 < ${TEST_TEMP_DIR}/target-features.m.tmp.aarch32
    RUN(TestState.Failed, "FileCheck %s -check-prefix=AARCH32 < %t.aarch32");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple aarch64-unknown-unknown -fmodules '-fmodules-cache-path=${TEST_TEMP_DIR}/target-features.m.tmp' -fimplicit-module-maps -I ${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs -fsyntax-only ${LLVM_SRC}/llvm/tools/clang/test/Modules/target-features.m 2> ${TEST_TEMP_DIR}/target-features.m.tmp.aarch64
    RUN(TestState.Failed, "not %clang_cc1 -triple aarch64-unknown-unknown -fmodules -fmodules-cache-path=%t -fimplicit-module-maps -I %S/Inputs -fsyntax-only  %s 2> %t.aarch64");
    // ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Modules/target-features.m -check-prefix=AARCH64 < ${TEST_TEMP_DIR}/target-features.m.tmp.aarch64
    RUN(TestState.Failed, "FileCheck %s -check-prefix=AARCH64 < %t.aarch64");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i386-unknown-unknown -fmodules '-fmodules-cache-path=${TEST_TEMP_DIR}/target-features.m.tmp' -fimplicit-module-maps -I ${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs -fsyntax-only ${LLVM_SRC}/llvm/tools/clang/test/Modules/target-features.m 2> ${TEST_TEMP_DIR}/target-features.m.tmp.x86_32
    RUN(TestState.Failed, "not %clang_cc1 -triple i386-unknown-unknown -fmodules -fmodules-cache-path=%t -fimplicit-module-maps -I %S/Inputs -fsyntax-only  %s 2> %t.x86_32");
    // ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Modules/target-features.m -check-prefix=X86_32 < ${TEST_TEMP_DIR}/target-features.m.tmp.x86_32
    RUN(TestState.Failed, "FileCheck %s -check-prefix=X86_32 < %t.x86_32");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-unknown-unknown -fmodules '-fmodules-cache-path=${TEST_TEMP_DIR}/target-features.m.tmp' -fimplicit-module-maps -I ${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs -fsyntax-only ${LLVM_SRC}/llvm/tools/clang/test/Modules/target-features.m 2> ${TEST_TEMP_DIR}/target-features.m.tmp.x86_64
    RUN(TestState.Failed, "not %clang_cc1 -triple x86_64-unknown-unknown -fmodules -fmodules-cache-path=%t -fimplicit-module-maps -I %S/Inputs -fsyntax-only  %s 2> %t.x86_64");
    // ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Modules/target-features.m -check-prefix=X86_64 < ${TEST_TEMP_DIR}/target-features.m.tmp.x86_64
    RUN(TestState.Failed, "FileCheck %s -check-prefix=X86_64 < %t.x86_64");
  }

  @Test
  public void test_template_default_args_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Modules/template-default-args.cpp");
    // rm -rf ${TEST_TEMP_DIR}/template-default-args.cpp.tmp
    RUN(TestState.Failed, "rm -rf %t");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fmodules -fimplicit-module-maps -verify '-fmodules-cache-path=${TEST_TEMP_DIR}/template-default-args.cpp.tmp' -fno-modules-error-recovery -I ${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs/template-default-args -std=c++11 ${LLVM_SRC}/llvm/tools/clang/test/Modules/template-default-args.cpp -DBEGIN= -DEND=
    RUN(TestState.Failed, "%clang_cc1 -fmodules -fimplicit-module-maps -verify -fmodules-cache-path=%t -fno-modules-error-recovery -I %S/Inputs/template-default-args -std=c++11 %s -DBEGIN= -DEND=");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fmodules -fimplicit-module-maps -verify '-fmodules-cache-path=${TEST_TEMP_DIR}/template-default-args.cpp.tmp' -fno-modules-error-recovery -I ${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs/template-default-args -std=c++11 ${LLVM_SRC}/llvm/tools/clang/test/Modules/template-default-args.cpp '-DBEGIN="namespace N {"' '-DEND="}"'
    RUN(TestState.Failed, "%clang_cc1 -fmodules -fimplicit-module-maps -verify -fmodules-cache-path=%t -fno-modules-error-recovery -I %S/Inputs/template-default-args -std=c++11 %s -DBEGIN=\"namespace N {\" -DEND=\"}\"");
  }

  @Test
  public void test_template_specialization_visibility_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Modules/template-specialization-visibility.cpp");
    // rm -rf ${TEST_TEMP_DIR}/template-specialization-visibility.cpp.tmp
    RUN("rm -rf %t");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fmodules -fimplicit-module-maps -verify '-fmodules-cache-path=${TEST_TEMP_DIR}/template-specialization-visibility.cpp.tmp' -I ${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs/template-specialization-visibility -std=c++11 ${LLVM_SRC}/llvm/tools/clang/test/Modules/template-specialization-visibility.cpp
    RUN("%clang_cc1 -fmodules -fimplicit-module-maps -verify -fmodules-cache-path=%t -I %S/Inputs/template-specialization-visibility -std=c++11 %s");
  }

  @Test
  public void test_templates_mm() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Modules/templates.mm");
    // REQUIRES: x86-registered-target
    if (!CHECK_REQUIRES("x86-registered-target")) {
      return;
    }
    // rm -rf ${TEST_TEMP_DIR}/templates.mm.tmp
    RUN(TestState.Failed, "rm -rf %t");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-linux-gnu -std=c++11 -x objective-c++ -fmodules -fimplicit-module-maps '-fmodules-cache-path=${TEST_TEMP_DIR}/templates.mm.tmp' -I ${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs -verify ${LLVM_SRC}/llvm/tools/clang/test/Modules/templates.mm -Wno-objc-root-class
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-linux-gnu -std=c++11 -x objective-c++ -fmodules -fimplicit-module-maps -fmodules-cache-path=%t -I %S/Inputs -verify %s -Wno-objc-root-class");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-linux-gnu -std=c++11 -x objective-c++ -fmodules -fimplicit-module-maps '-fmodules-cache-path=${TEST_TEMP_DIR}/templates.mm.tmp' -I ${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/Modules/templates.mm -o - -Wno-objc-root-class | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Modules/templates.mm
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-linux-gnu -std=c++11 -x objective-c++ -fmodules -fimplicit-module-maps -fmodules-cache-path=%t -I %S/Inputs -emit-llvm %s -o - -Wno-objc-root-class")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_templates_2_mm() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Modules/templates-2.mm");
    // REQUIRES: x86-registered-target
    if (!CHECK_REQUIRES("x86-registered-target")) {
      return;
    }
    // rm -rf ${TEST_TEMP_DIR}/templates-2.mm.tmp
    RUN(TestState.Failed, "rm -rf %t");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-linux-gnu -std=c++11 -x objective-c++ -fmodules -fimplicit-module-maps '-fmodules-cache-path=${TEST_TEMP_DIR}/templates-2.mm.tmp' -I ${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs -verify ${LLVM_SRC}/llvm/tools/clang/test/Modules/templates-2.mm -Wno-objc-root-class
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-linux-gnu -std=c++11 -x objective-c++ -fmodules -fimplicit-module-maps -fmodules-cache-path=%t -I %S/Inputs -verify %s -Wno-objc-root-class");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-linux-gnu -std=c++11 -x objective-c++ -fmodules -fimplicit-module-maps '-fmodules-cache-path=${TEST_TEMP_DIR}/templates-2.mm.tmp' -I ${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/Modules/templates-2.mm -o - -Wno-objc-root-class | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Modules/templates-2.mm
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-linux-gnu -std=c++11 -x objective-c++ -fmodules -fimplicit-module-maps -fmodules-cache-path=%t -I %S/Inputs -emit-llvm %s -o - -Wno-objc-root-class")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_textual_headers_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Modules/textual-headers.cpp");
    // rm -rf ${TEST_TEMP_DIR}/textual-headers.cpp.tmp
    RUN("rm -rf %t");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fimplicit-module-maps '-fmodules-cache-path=${TEST_TEMP_DIR}/textual-headers.cpp.tmp' -fmodules-strict-decluse -fmodule-name=XG -I ${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs/declare-use ${LLVM_SRC}/llvm/tools/clang/test/Modules/textual-headers.cpp -verify
    RUN("%clang_cc1 -fimplicit-module-maps -fmodules-cache-path=%t -fmodules-strict-decluse -fmodule-name=XG -I %S/Inputs/declare-use %s -verify");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fmodules -fimplicit-module-maps '-fmodules-cache-path=${TEST_TEMP_DIR}/textual-headers.cpp.tmp' -fmodules-strict-decluse -fmodule-name=XG -I ${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs/declare-use ${LLVM_SRC}/llvm/tools/clang/test/Modules/textual-headers.cpp -verify -fno-modules-error-recovery
    RUN("%clang_cc1 -fmodules -fimplicit-module-maps -fmodules-cache-path=%t -fmodules-strict-decluse -fmodule-name=XG -I %S/Inputs/declare-use %s -verify -fno-modules-error-recovery");
  }

  @Test
  public void test_thread_safety_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Modules/thread-safety.cpp");
    // rm -rf ${TEST_TEMP_DIR}/thread-safety.cpp.tmp
    RUN(TestState.Failed, "rm -rf %t");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fmodules '-fmodules-cache-path=${TEST_TEMP_DIR}/thread-safety.cpp.tmp' -fimplicit-module-maps '-I${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs/thread-safety' -std=c++11 -Wthread-safety -verify ${LLVM_SRC}/llvm/tools/clang/test/Modules/thread-safety.cpp
    RUN(TestState.Failed, "%clang_cc1 -fmodules -fmodules-cache-path=%t -fimplicit-module-maps -I%S/Inputs/thread-safety -std=c++11 -Wthread-safety -verify %s");
  }

  @Test
  public void test_typedef_tag_not_visible_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Modules/typedef-tag-not-visible.m");
    // rm -rf ${TEST_TEMP_DIR}/typedef-tag-not-visible.m.tmp
    RUN("rm -rf %t");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fmodules -fimplicit-module-maps '-fmodules-cache-path=${TEST_TEMP_DIR}/typedef-tag-not-visible.m.tmp' -I ${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs ${LLVM_SRC}/llvm/tools/clang/test/Modules/typedef-tag-not-visible.m -verify
    RUN("%clang_cc1 -fmodules -fimplicit-module-maps -fmodules-cache-path=%t -I %S/Inputs %s -verify");
  }

  @Test
  public void test_typo_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Modules/typo.m");
    // rm -rf ${TEST_TEMP_DIR}/typo.m.tmp
    RUN(TestState.Failed, "rm -rf %t");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fmodules -fimplicit-module-maps '-fmodules-cache-path=${TEST_TEMP_DIR}/typo.m.tmp' -I ${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs -x objective-c-header ${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs/typo.h -emit-pch -o ${TEST_TEMP_DIR}/typo.m.tmp.pch
    RUN(TestState.Failed, "%clang_cc1 -fmodules -fimplicit-module-maps -fmodules-cache-path=%t -I %S/Inputs -x objective-c-header %S/Inputs/typo.h -emit-pch -o %t.pch");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fmodules -fimplicit-module-maps '-fmodules-cache-path=${TEST_TEMP_DIR}/typo.m.tmp' -I ${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs -include-pch ${TEST_TEMP_DIR}/typo.m.tmp.pch ${LLVM_SRC}/llvm/tools/clang/test/Modules/typo.m -verify
    RUN(TestState.Failed, "%clang_cc1 -fmodules -fimplicit-module-maps -fmodules-cache-path=%t -I %S/Inputs -include-pch %t.pch %s -verify");
  }

  @Test
  public void test_undefined_type_fixit1_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Modules/undefined-type-fixit1.cpp");
    // rm -rf ${TEST_TEMP_DIR}/undefined-type-fixit1.cpp.tmp
    RUN(TestState.Failed, "rm -rf %t");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc '-fmodules-cache-path=${TEST_TEMP_DIR}/undefined-type-fixit1.cpp.tmp' -fmodules -fimplicit-module-maps -fmodules-search-all -I ${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs/undefined-type-fixit ${LLVM_SRC}/llvm/tools/clang/test/Modules/undefined-type-fixit1.cpp -verify
    RUN(TestState.Failed, "%clang_cc1 -fmodules-cache-path=%t -fmodules -fimplicit-module-maps -fmodules-search-all -I %S/Inputs/undefined-type-fixit %s -verify");
  }

  @Test
  public void test_unnecessary_module_map_parsing_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Modules/unnecessary-module-map-parsing.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fmodules -fimplicit-module-maps -I ${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs/unnecessary-module-map-parsing -fsyntax-only ${LLVM_SRC}/llvm/tools/clang/test/Modules/unnecessary-module-map-parsing.c 2>&1 | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Modules/unnecessary-module-map-parsing.c
    RUN("not %clang_cc1 -fmodules -fimplicit-module-maps -I %S/Inputs/unnecessary-module-map-parsing -fsyntax-only %s 2>&1")./*|*/
      I("FileCheck %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -I ${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs/unnecessary-module-map-parsing -fsyntax-only ${LLVM_SRC}/llvm/tools/clang/test/Modules/unnecessary-module-map-parsing.c
    RUN("%clang_cc1 -I %S/Inputs/unnecessary-module-map-parsing -fsyntax-only %s");
  }

  @Test
  public void test_update_after_load_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Modules/update-after-load.cpp");
    // rm -rf ${TEST_TEMP_DIR}/update-after-load.cpp.tmp
    RUN("rm -rf %t");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fmodules -fimplicit-module-maps -I ${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs/update-after-load -verify '-fmodules-cache-path=${TEST_TEMP_DIR}/update-after-load.cpp.tmp' ${LLVM_SRC}/llvm/tools/clang/test/Modules/update-after-load.cpp
    RUN("%clang_cc1 -fmodules -fimplicit-module-maps -I %S/Inputs/update-after-load -verify -fmodules-cache-path=%t %s");
  }

  @Test
  public void test_update_exception_spec_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Modules/update-exception-spec.cpp");
    // rm -rf ${TEST_TEMP_DIR}/update-exception-spec.cpp.tmp
    RUN(TestState.Failed, "rm -rf %t");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fexceptions -fcxx-exceptions -fmodules -fimplicit-module-maps '-fmodules-cache-path=${TEST_TEMP_DIR}/update-exception-spec.cpp.tmp' '-I${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs/update-exception-spec' -emit-llvm-only ${LLVM_SRC}/llvm/tools/clang/test/Modules/update-exception-spec.cpp
    RUN(TestState.Failed, "%clang_cc1 -fexceptions -fcxx-exceptions -fmodules -fimplicit-module-maps -fmodules-cache-path=%t -I%S/Inputs/update-exception-spec -emit-llvm-only %s");
  }

  @Test
  public void test_use_after_free_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Modules/use-after-free.m");
    // rm -rf ${TEST_TEMP_DIR}/use-after-free.m.tmp
    RUN("rm -rf %t");
    // echo '@import UseAfterFreePublic;' | ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fmodules -fimplicit-module-maps '-fmodules-cache-path=${TEST_TEMP_DIR}/use-after-free.m.tmp' -isystem ${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs/UseAfterFree/ -fsyntax-only -x objective-c -
    RUN("echo '@import UseAfterFreePublic;'")./*|*/
      I("%clang_cc1 -fmodules -fimplicit-module-maps -fmodules-cache-path=%t -isystem %S/Inputs/UseAfterFree/ -fsyntax-only -x objective-c -");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fmodules -fimplicit-module-maps '-fmodules-cache-path=${TEST_TEMP_DIR}/use-after-free.m.tmp' -isystem ${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs/UseAfterFree/ -fsyntax-only -Wnon-modular-include-in-framework-module -Werror=non-modular-include-in-framework-module -x objective-c ${LLVM_SRC}/llvm/tools/clang/test/Modules/use-after-free.m -verify
    RUN("%clang_cc1 -fmodules -fimplicit-module-maps -fmodules-cache-path=%t -isystem %S/Inputs/UseAfterFree/ -fsyntax-only -Wnon-modular-include-in-framework-module -Werror=non-modular-include-in-framework-module -x objective-c %s -verify");
  }

  @Test
  public void test_using_decl_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Modules/using-decl.cpp");
    // rm -rf ${TEST_TEMP_DIR}/using-decl.cpp.tmp
    RUN(TestState.Failed, "rm -rf %t");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x objective-c++ -std=c++11 -fmodules -fimplicit-module-maps '-fmodules-cache-path=${TEST_TEMP_DIR}/using-decl.cpp.tmp' -I ${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs ${LLVM_SRC}/llvm/tools/clang/test/Modules/using-decl.cpp -verify -DEARLY_IMPORT
    RUN(TestState.Failed, "%clang_cc1 -x objective-c++ -std=c++11 -fmodules -fimplicit-module-maps -fmodules-cache-path=%t -I %S/Inputs %s -verify -DEARLY_IMPORT");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x objective-c++ -std=c++11 -fmodules -fimplicit-module-maps '-fmodules-cache-path=${TEST_TEMP_DIR}/using-decl.cpp.tmp' -I ${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs ${LLVM_SRC}/llvm/tools/clang/test/Modules/using-decl.cpp -verify -UEARLY_IMPORT
    RUN(TestState.Failed, "%clang_cc1 -x objective-c++ -std=c++11 -fmodules -fimplicit-module-maps -fmodules-cache-path=%t -I %S/Inputs %s -verify -UEARLY_IMPORT");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x objective-c++ -std=c++11 -fmodules -fimplicit-module-maps '-fmodules-cache-path=${TEST_TEMP_DIR}/using-decl.cpp.tmp' -I ${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs ${LLVM_SRC}/llvm/tools/clang/test/Modules/using-decl.cpp -verify -DEARLY_IMPORT -fmodules-local-submodule-visibility
    RUN(TestState.Failed, "%clang_cc1 -x objective-c++ -std=c++11 -fmodules -fimplicit-module-maps -fmodules-cache-path=%t -I %S/Inputs %s -verify -DEARLY_IMPORT -fmodules-local-submodule-visibility");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x objective-c++ -std=c++11 -fmodules -fimplicit-module-maps '-fmodules-cache-path=${TEST_TEMP_DIR}/using-decl.cpp.tmp' -I ${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs ${LLVM_SRC}/llvm/tools/clang/test/Modules/using-decl.cpp -verify -UEARLY_IMPORT -fmodules-local-submodule-visibility
    RUN(TestState.Failed, "%clang_cc1 -x objective-c++ -std=c++11 -fmodules -fimplicit-module-maps -fmodules-cache-path=%t -I %S/Inputs %s -verify -UEARLY_IMPORT -fmodules-local-submodule-visibility");
  }

  @Test
  public void test_using_decl_redecl_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Modules/using-decl-redecl.cpp");
    // rm -rf ${TEST_TEMP_DIR}/using-decl-redecl.cpp.tmp
    RUN(TestState.Failed, "rm -rf %t");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fmodules '-fmodules-cache-path=${TEST_TEMP_DIR}/using-decl-redecl.cpp.tmp' '-fmodule-map-file=${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs/using-decl-redecl/module.modulemap' '-I${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs/using-decl-redecl' -Wno-modules-ambiguous-internal-linkage -verify ${LLVM_SRC}/llvm/tools/clang/test/Modules/using-decl-redecl.cpp
    RUN(TestState.Failed, "%clang_cc1 -fmodules -fmodules-cache-path=%t -fmodule-map-file=%S/Inputs/using-decl-redecl/module.modulemap -I%S/Inputs/using-decl-redecl -Wno-modules-ambiguous-internal-linkage -verify %s");
  }

  @Test
  public void test_va_list_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Modules/va_list.cpp");
    // rm -rf ${TEST_TEMP_DIR}/va_list.cpp.tmp
    RUN(TestState.Failed, "rm -rf %t");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x objective-c++ '-fmodules-cache-path=${TEST_TEMP_DIR}/va_list.cpp.tmp' -fmodules -fimplicit-module-maps -I ${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs/va_list ${LLVM_SRC}/llvm/tools/clang/test/Modules/va_list.cpp -verify
    RUN(TestState.Failed, "%clang_cc1 -x objective-c++ -fmodules-cache-path=%t -fmodules -fimplicit-module-maps -I %S/Inputs/va_list %s -verify");
  }

  @Test
  public void test_va_list_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Modules/va_list.m");
    // REQUIRES: x86-registered-target
    if (!CHECK_REQUIRES("x86-registered-target")) {
      return;
    }
    // rm -rf ${TEST_TEMP_DIR}/va_list.m.tmp
    RUN("rm -rf %t");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-apple-macosx10 -fmodules -fimplicit-module-maps '-fmodules-cache-path=${TEST_TEMP_DIR}/va_list.m.tmp' -fmodules-ignore-macro=PREFIX -DPREFIX -I ${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs/va_list -x objective-c-header ${LLVM_SRC}/llvm/tools/clang/test/Modules/va_list.m -o ${TEST_TEMP_DIR}/va_list.m.tmp.pch -emit-pch
    RUN("%clang_cc1 -triple x86_64-apple-macosx10 -fmodules -fimplicit-module-maps -fmodules-cache-path=%t -fmodules-ignore-macro=PREFIX -DPREFIX -I %S/Inputs/va_list -x objective-c-header %s -o %t.pch -emit-pch");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-apple-macosx10 -fmodules -fimplicit-module-maps '-fmodules-cache-path=${TEST_TEMP_DIR}/va_list.m.tmp' -fmodules-ignore-macro=PREFIX -I ${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs/va_list -include-pch ${TEST_TEMP_DIR}/va_list.m.tmp.pch -x objective-c ${LLVM_SRC}/llvm/tools/clang/test/Modules/va_list.m -fsyntax-only
    RUN("%clang_cc1 -triple x86_64-apple-macosx10 -fmodules -fimplicit-module-maps -fmodules-cache-path=%t -fmodules-ignore-macro=PREFIX -I %S/Inputs/va_list -include-pch %t.pch -x objective-c %s -fsyntax-only");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-apple-macosx10 -fmodules -fimplicit-module-maps '-fmodules-cache-path=${TEST_TEMP_DIR}/va_list.m.tmp' -fmodules-ignore-macro=PREFIX -DPREFIX -I ${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs/va_list -x objective-c-header ${LLVM_SRC}/llvm/tools/clang/test/Modules/va_list.m -o ${TEST_TEMP_DIR}/va_list.m.tmp.pch -emit-pch
    RUN("%clang_cc1 -triple x86_64-apple-macosx10 -fmodules -fimplicit-module-maps -fmodules-cache-path=%t -fmodules-ignore-macro=PREFIX -DPREFIX -I %S/Inputs/va_list -x objective-c-header %s -o %t.pch -emit-pch");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-apple-macosx10 -fmodules -fimplicit-module-maps '-fmodules-cache-path=${TEST_TEMP_DIR}/va_list.m.tmp' -fmodules-ignore-macro=PREFIX -I ${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs/va_list -include-pch ${TEST_TEMP_DIR}/va_list.m.tmp.pch -x objective-c ${LLVM_SRC}/llvm/tools/clang/test/Modules/va_list.m -fsyntax-only
    RUN("%clang_cc1 -triple x86_64-apple-macosx10 -fmodules -fimplicit-module-maps -fmodules-cache-path=%t -fmodules-ignore-macro=PREFIX -I %S/Inputs/va_list -include-pch %t.pch -x objective-c %s -fsyntax-only");
  }

  @Test
  public void test_validate_system_headers_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Modules/validate-system-headers.m");
    // rm -rf ${TEST_TEMP_DIR}/validate-system-headers.m.tmp/ModuleCache
    RUN("rm -rf %t/ModuleCache");
    // mkdir -p ${TEST_TEMP_DIR}/validate-system-headers.m.tmp/Inputs/usr/include
    RUN("mkdir -p %t/Inputs/usr/include");
    // touch ${TEST_TEMP_DIR}/validate-system-headers.m.tmp/Inputs/usr/include/foo.h
    RUN("touch %t/Inputs/usr/include/foo.h");
    // echo 'module Foo [system] { header "foo.h" }' > ${TEST_TEMP_DIR}/validate-system-headers.m.tmp/Inputs/usr/include/module.map
    RUN("echo 'module Foo [system] { header \"foo.h\" }' > %t/Inputs/usr/include/module.map");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -isystem ${TEST_TEMP_DIR}/validate-system-headers.m.tmp/Inputs/usr/include -fmodules -fimplicit-module-maps '-fmodules-cache-path=${TEST_TEMP_DIR}/validate-system-headers.m.tmp/ModuleCache' -fdisable-module-hash -x objective-c-header -fsyntax-only ${LLVM_SRC}/llvm/tools/clang/test/Modules/validate-system-headers.m
    RUN("%clang_cc1 -isystem %t/Inputs/usr/include -fmodules -fimplicit-module-maps -fmodules-cache-path=%t/ModuleCache -fdisable-module-hash -x objective-c-header -fsyntax-only %s");
    // cp ${TEST_TEMP_DIR}/validate-system-headers.m.tmp/ModuleCache/Foo.pcm ${TEST_TEMP_DIR}/validate-system-headers.m.tmp/Foo.pcm.saved
    RUN("cp %t/ModuleCache/Foo.pcm %t/Foo.pcm.saved");
    // echo ' ' >> ${TEST_TEMP_DIR}/validate-system-headers.m.tmp/Inputs/usr/include/foo.h
    RUN("echo ' ' >> %t/Inputs/usr/include/foo.h");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -isystem ${TEST_TEMP_DIR}/validate-system-headers.m.tmp/Inputs/usr/include -fmodules -fimplicit-module-maps '-fmodules-cache-path=${TEST_TEMP_DIR}/validate-system-headers.m.tmp/ModuleCache' -fdisable-module-hash -x objective-c-header -fsyntax-only ${LLVM_SRC}/llvm/tools/clang/test/Modules/validate-system-headers.m
    RUN("%clang_cc1 -isystem %t/Inputs/usr/include -fmodules -fimplicit-module-maps -fmodules-cache-path=%t/ModuleCache -fdisable-module-hash -x objective-c-header -fsyntax-only %s");
    // diff ${TEST_TEMP_DIR}/validate-system-headers.m.tmp/ModuleCache/Foo.pcm ${TEST_TEMP_DIR}/validate-system-headers.m.tmp/Foo.pcm.saved
    RUN("diff %t/ModuleCache/Foo.pcm %t/Foo.pcm.saved");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -isystem ${TEST_TEMP_DIR}/validate-system-headers.m.tmp/Inputs/usr/include -fmodules -fimplicit-module-maps -fmodules-validate-system-headers '-fmodules-cache-path=${TEST_TEMP_DIR}/validate-system-headers.m.tmp/ModuleCache' -fdisable-module-hash -x objective-c-header -fsyntax-only ${LLVM_SRC}/llvm/tools/clang/test/Modules/validate-system-headers.m
    RUN("%clang_cc1 -isystem %t/Inputs/usr/include -fmodules -fimplicit-module-maps -fmodules-validate-system-headers -fmodules-cache-path=%t/ModuleCache -fdisable-module-hash -x objective-c-header -fsyntax-only %s");
    // diff ${TEST_TEMP_DIR}/validate-system-headers.m.tmp/ModuleCache/Foo.pcm ${TEST_TEMP_DIR}/validate-system-headers.m.tmp/Foo.pcm.saved
    RUN("not diff %t/ModuleCache/Foo.pcm %t/Foo.pcm.saved");
    // cp ${TEST_TEMP_DIR}/validate-system-headers.m.tmp/ModuleCache/Foo.pcm ${TEST_TEMP_DIR}/validate-system-headers.m.tmp/Foo.pcm.saved
    RUN("cp %t/ModuleCache/Foo.pcm %t/Foo.pcm.saved");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -isystem ${TEST_TEMP_DIR}/validate-system-headers.m.tmp/Inputs/usr/include -fmodules -fimplicit-module-maps '-fmodules-cache-path=${TEST_TEMP_DIR}/validate-system-headers.m.tmp/ModuleCache' -fdisable-module-hash -x objective-c-header -fsyntax-only ${LLVM_SRC}/llvm/tools/clang/test/Modules/validate-system-headers.m -fbuild-session-timestamp=1390000000 -fmodules-validate-once-per-build-session
    RUN("%clang_cc1 -isystem %t/Inputs/usr/include -fmodules -fimplicit-module-maps -fmodules-cache-path=%t/ModuleCache -fdisable-module-hash -x objective-c-header -fsyntax-only %s -fbuild-session-timestamp=1390000000 -fmodules-validate-once-per-build-session");
    // diff ${TEST_TEMP_DIR}/validate-system-headers.m.tmp/ModuleCache/Foo.pcm ${TEST_TEMP_DIR}/validate-system-headers.m.tmp/Foo.pcm.saved
    RUN("diff %t/ModuleCache/Foo.pcm %t/Foo.pcm.saved");
    // echo ' ' >> ${TEST_TEMP_DIR}/validate-system-headers.m.tmp/Inputs/usr/include/foo.h
    RUN("echo ' ' >> %t/Inputs/usr/include/foo.h");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -isystem ${TEST_TEMP_DIR}/validate-system-headers.m.tmp/Inputs/usr/include -fmodules -fimplicit-module-maps '-fmodules-cache-path=${TEST_TEMP_DIR}/validate-system-headers.m.tmp/ModuleCache' -fdisable-module-hash -x objective-c-header -fsyntax-only ${LLVM_SRC}/llvm/tools/clang/test/Modules/validate-system-headers.m -fbuild-session-timestamp=1390000000 -fmodules-validate-once-per-build-session
    RUN("%clang_cc1 -isystem %t/Inputs/usr/include -fmodules -fimplicit-module-maps -fmodules-cache-path=%t/ModuleCache -fdisable-module-hash -x objective-c-header -fsyntax-only %s -fbuild-session-timestamp=1390000000 -fmodules-validate-once-per-build-session");
    // diff ${TEST_TEMP_DIR}/validate-system-headers.m.tmp/ModuleCache/Foo.pcm ${TEST_TEMP_DIR}/validate-system-headers.m.tmp/Foo.pcm.saved
    RUN("diff %t/ModuleCache/Foo.pcm %t/Foo.pcm.saved");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -isystem ${TEST_TEMP_DIR}/validate-system-headers.m.tmp/Inputs/usr/include -fmodules -fimplicit-module-maps -fmodules-validate-system-headers '-fmodules-cache-path=${TEST_TEMP_DIR}/validate-system-headers.m.tmp/ModuleCache' -fdisable-module-hash -x objective-c-header -fsyntax-only ${LLVM_SRC}/llvm/tools/clang/test/Modules/validate-system-headers.m -fbuild-session-timestamp=1390000000 -fmodules-validate-once-per-build-session
    RUN("%clang_cc1 -isystem %t/Inputs/usr/include -fmodules -fimplicit-module-maps -fmodules-validate-system-headers -fmodules-cache-path=%t/ModuleCache -fdisable-module-hash -x objective-c-header -fsyntax-only %s -fbuild-session-timestamp=1390000000 -fmodules-validate-once-per-build-session");
    // diff ${TEST_TEMP_DIR}/validate-system-headers.m.tmp/ModuleCache/Foo.pcm ${TEST_TEMP_DIR}/validate-system-headers.m.tmp/Foo.pcm.saved
    RUN("not diff %t/ModuleCache/Foo.pcm %t/Foo.pcm.saved");
  }

  @Test
  public void test_warn_unused_local_typedef_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Modules/warn-unused-local-typedef.cpp");
    // rm -rf ${TEST_TEMP_DIR}/warn-unused-local-typedef.cpp.tmp
    RUN("rm -rf %t");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -Wunused-local-typedef -x objective-c++ -fmodules -fimplicit-module-maps '-fmodules-cache-path=${TEST_TEMP_DIR}/warn-unused-local-typedef.cpp.tmp' -I ${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs ${LLVM_SRC}/llvm/tools/clang/test/Modules/warn-unused-local-typedef.cpp -fsyntax-only 2>&1 | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Modules/warn-unused-local-typedef.cpp -check-prefix=CHECK_1
    RUN("%clang_cc1 -Wunused-local-typedef -x objective-c++ -fmodules -fimplicit-module-maps -fmodules-cache-path=%t -I %S/Inputs %s -fsyntax-only 2>&1")./*|*/
      I("FileCheck %s -check-prefix=CHECK_1");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -Wunused-local-typedef -x objective-c++ -fmodules -fimplicit-module-maps '-fmodules-cache-path=${TEST_TEMP_DIR}/warn-unused-local-typedef.cpp.tmp' -I ${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs ${LLVM_SRC}/llvm/tools/clang/test/Modules/warn-unused-local-typedef.cpp -fsyntax-only 2>&1 | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Modules/warn-unused-local-typedef.cpp -check-prefix=CHECK_2 --allow-empty
    RUN("%clang_cc1 -Wunused-local-typedef -x objective-c++ -fmodules -fimplicit-module-maps -fmodules-cache-path=%t -I %S/Inputs %s -fsyntax-only 2>&1")./*|*/
      I("FileCheck %s -check-prefix=CHECK_2 --allow-empty");
  }

  @Test
  public void test_wildcard_submodule_exports_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Modules/wildcard-submodule-exports.cpp");
    // rm -rf ${TEST_TEMP_DIR}/wildcard-submodule-exports.cpp.tmp
    RUN("rm -rf %t");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x objective-c++ '-fmodules-cache-path=${TEST_TEMP_DIR}/wildcard-submodule-exports.cpp.tmp' -fmodules -fimplicit-module-maps -I ${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs/wildcard-submodule-exports ${LLVM_SRC}/llvm/tools/clang/test/Modules/wildcard-submodule-exports.cpp -verify
    RUN("%clang_cc1 -x objective-c++ -fmodules-cache-path=%t -fmodules -fimplicit-module-maps -I %S/Inputs/wildcard-submodule-exports %s -verify");
  }

  @Test
  public void test_working_dir_flag_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Modules/working-dir-flag.m");
    // rm -rf ${TEST_TEMP_DIR}/working-dir-flag.m.tmp.mcp
    RUN("rm -rf %t.mcp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc '-fmodules-cache-path=${TEST_TEMP_DIR}/working-dir-flag.m.tmp.mcp' -fmodules -fimplicit-module-maps -F . '-working-directory=${LLVM_SRC}/llvm/tools/clang/test/Modules/Inputs/working-dir-test' ${LLVM_SRC}/llvm/tools/clang/test/Modules/working-dir-flag.m -verify
    RUN("%clang_cc1 -fmodules-cache-path=%t.mcp -fmodules -fimplicit-module-maps -F . -working-directory=%S/Inputs/working-dir-test %s -verify");
  }
  
}
