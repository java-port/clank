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
 * Collection of all test files from test/Sema folder
 * @author Vladimir Voskresensky
 */
public class AllSemaSemaTest extends DriverTestFileBase {
  private static final String TEST_LOCATION = "${LLVM_SRC}/llvm/tools/clang/test/Sema/";
  public AllSemaSemaTest() {
    super(TEST_LOCATION, TestState.Successful);
  }
  
  public static void main(String[] args) {
    // Print tests which will be accepted per test case
    DriverTestFileBase.printAllTestFiles(false, TEST_LOCATION, (test)->true, 
            "${SPUTNIK}/modules/org.clang.sema/test/unit/src/org/clang/sema/test/AllSemaSemaTest.txt");
  }  
  
  @Override
  protected boolean keepStacksForUnimplementedMethods() {
    return false;
  }
  
  @Test
  public void test_128bitfloat_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Sema/128bitfloat.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -std=gnu++11 ${LLVM_SRC}/llvm/tools/clang/test/Sema/128bitfloat.cpp
    RUN("%clang_cc1 -fsyntax-only -verify -std=gnu++11 %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -std=c++11 ${LLVM_SRC}/llvm/tools/clang/test/Sema/128bitfloat.cpp
    RUN("%clang_cc1 -fsyntax-only -verify -std=c++11 %s");
  }

  @Test
  public void test_128bitint_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Sema/128bitint.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -triple x86_64-apple-darwin9 ${LLVM_SRC}/llvm/tools/clang/test/Sema/128bitint.c -DHAVE
    RUN("%clang_cc1 -fsyntax-only -verify -triple x86_64-apple-darwin9 %s -DHAVE");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -triple i686-linux-gnu ${LLVM_SRC}/llvm/tools/clang/test/Sema/128bitint.c -DHAVE_NOT
    RUN("%clang_cc1 -fsyntax-only -verify -triple i686-linux-gnu %s -DHAVE_NOT");
  }

  @Test
  public void test_2007_10_01_BuildArrayRef_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Sema/2007-10-01-BuildArrayRef.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/Sema/2007-10-01-BuildArrayRef.c
    RUN("%clang_cc1 -fsyntax-only -verify %s");
  }

  @Test
  public void test_2009_03_09_WeakDeclarations_1_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Sema/2009-03-09-WeakDeclarations-1.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -verify ${LLVM_SRC}/llvm/tools/clang/test/Sema/2009-03-09-WeakDeclarations-1.c -triple i686-apple-darwin
    RUN("%clang_cc1 -verify %s -triple i686-apple-darwin");
  }

  @Test
  public void test_2009_04_22_UnknownSize_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Sema/2009-04-22-UnknownSize.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/Sema/2009-04-22-UnknownSize.c
    RUN("not %clang_cc1 -fsyntax-only -verify %s");
  }

  @Test
  public void test_2009_07_17_VoidParameter_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Sema/2009-07-17-VoidParameter.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -verify -fsyntax-only ${LLVM_SRC}/llvm/tools/clang/test/Sema/2009-07-17-VoidParameter.c
    RUN("%clang_cc1 -verify -fsyntax-only %s");
  }

  @Test
  public void test_2010_05_31_palignr_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Sema/2010-05-31-palignr.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-apple-darwin -emit-llvm -o /dev/null ${LLVM_SRC}/llvm/tools/clang/test/Sema/2010-05-31-palignr.c
    RUN("not %clang_cc1 -triple x86_64-apple-darwin -emit-llvm -o /dev/null %s");
  }

  @Test
  public void test_MicrosoftCompatibility_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Sema/MicrosoftCompatibility.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/Sema/MicrosoftCompatibility.c -fsyntax-only -Wno-unused-value -Wmicrosoft -verify -fms-compatibility -triple i686-pc-win32
    RUN("%clang_cc1 %s -fsyntax-only -Wno-unused-value -Wmicrosoft -verify -fms-compatibility -triple i686-pc-win32");
  }

  @Test
  public void test_MicrosoftCompatibility_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Sema/MicrosoftCompatibility.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/Sema/MicrosoftCompatibility.cpp -fsyntax-only -Wno-unused-value -Wmicrosoft -verify -fms-compatibility
    RUN("%clang_cc1 %s -fsyntax-only -Wno-unused-value -Wmicrosoft -verify -fms-compatibility");
  }

  @Test
  public void test_MicrosoftCompatibility_x64_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Sema/MicrosoftCompatibility-x64.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/Sema/MicrosoftCompatibility-x64.c -Wmicrosoft -verify -fms-compatibility -triple x86_64-pc-win32
    RUN("%clang_cc1 %s -Wmicrosoft -verify -fms-compatibility -triple x86_64-pc-win32");
  }

  @Test
  public void test_MicrosoftCompatibility_x86_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Sema/MicrosoftCompatibility-x86.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/Sema/MicrosoftCompatibility-x86.c -fsyntax-only -Wno-unused-value -Wmicrosoft -verify -fms-compatibility -triple i386-pc-win32
    RUN("%clang_cc1 %s -fsyntax-only -Wno-unused-value -Wmicrosoft -verify -fms-compatibility -triple i386-pc-win32");
  }

  @Test
  public void test_MicrosoftExtensions_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Sema/MicrosoftExtensions.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i686-windows ${LLVM_SRC}/llvm/tools/clang/test/Sema/MicrosoftExtensions.c -fsyntax-only -Wno-unused-value -Wmicrosoft -verify -fms-extensions
    RUN(TestState.Failed, "%clang_cc1 -triple i686-windows %s -fsyntax-only -Wno-unused-value -Wmicrosoft -verify -fms-extensions");
  }

  @Test
  public void test_PR16678_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Sema/PR16678.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -DX32TYPE=ULONG -triple powerpc-unknown-linux-gnu -std=c89 -x c ${LLVM_SRC}/llvm/tools/clang/test/Sema/PR16678.c -verify
    RUN("%clang_cc1 -DX32TYPE=ULONG -triple powerpc-unknown-linux-gnu -std=c89 -x c %s -verify");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -DX32TYPE=ULONG -triple powerpc-unknown-linux-gnu -std=iso9899:199409 -x c ${LLVM_SRC}/llvm/tools/clang/test/Sema/PR16678.c -verify
    RUN("%clang_cc1 -DX32TYPE=ULONG -triple powerpc-unknown-linux-gnu -std=iso9899:199409 -x c %s -verify");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -DX32TYPE=ULONG -triple powerpc-unknown-linux-gnu -std=c++98 -x c++ ${LLVM_SRC}/llvm/tools/clang/test/Sema/PR16678.c -verify
    RUN("%clang_cc1 -DX32TYPE=ULONG -triple powerpc-unknown-linux-gnu -std=c++98 -x c++ %s -verify");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -DX32TYPE=LLONG -triple powerpc-unknown-linux-gnu -std=c99 -x c ${LLVM_SRC}/llvm/tools/clang/test/Sema/PR16678.c -verify
    RUN("%clang_cc1 -DX32TYPE=LLONG -triple powerpc-unknown-linux-gnu -std=c99 -x c %s -verify");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -DX32TYPE=LLONG -triple powerpc-unknown-linux-gnu -std=c11 -x c ${LLVM_SRC}/llvm/tools/clang/test/Sema/PR16678.c -verify
    RUN("%clang_cc1 -DX32TYPE=LLONG -triple powerpc-unknown-linux-gnu -std=c11 -x c %s -verify");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -DX32TYPE=LLONG -triple powerpc-unknown-linux-gnu -std=c++11 -x c++ ${LLVM_SRC}/llvm/tools/clang/test/Sema/PR16678.c -verify
    RUN("%clang_cc1 -DX32TYPE=LLONG -triple powerpc-unknown-linux-gnu -std=c++11 -x c++ %s -verify");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -DX32TYPE=LLONG -triple powerpc-unknown-linux-gnu -std=c++1y -x c++ ${LLVM_SRC}/llvm/tools/clang/test/Sema/PR16678.c -verify
    RUN("%clang_cc1 -DX32TYPE=LLONG -triple powerpc-unknown-linux-gnu -std=c++1y -x c++ %s -verify");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -DX32TYPE=LLONG -triple powerpc-unknown-linux-gnu -std=c++1z -x c++ ${LLVM_SRC}/llvm/tools/clang/test/Sema/PR16678.c -verify
    RUN("%clang_cc1 -DX32TYPE=LLONG -triple powerpc-unknown-linux-gnu -std=c++1z -x c++ %s -verify");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -DX64TYPE=ULONG -triple powerpc64-unknown-linux-gnu -std=c89 -x c ${LLVM_SRC}/llvm/tools/clang/test/Sema/PR16678.c -verify
    RUN("%clang_cc1 -DX64TYPE=ULONG -triple powerpc64-unknown-linux-gnu -std=c89 -x c %s -verify");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -DX64TYPE=ULONG -triple powerpc64-unknown-linux-gnu -std=iso9899:199409 -x c ${LLVM_SRC}/llvm/tools/clang/test/Sema/PR16678.c -verify
    RUN("%clang_cc1 -DX64TYPE=ULONG -triple powerpc64-unknown-linux-gnu -std=iso9899:199409 -x c %s -verify");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -DX64TYPE=ULONG -triple powerpc64-unknown-linux-gnu -std=c++98 -x c++ ${LLVM_SRC}/llvm/tools/clang/test/Sema/PR16678.c -verify
    RUN("%clang_cc1 -DX64TYPE=ULONG -triple powerpc64-unknown-linux-gnu -std=c++98 -x c++ %s -verify");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -DX64TYPE=ULLONG -triple powerpc64-unknown-linux-gnu -std=c99 -x c ${LLVM_SRC}/llvm/tools/clang/test/Sema/PR16678.c -verify
    RUN("%clang_cc1 -DX64TYPE=ULLONG -triple powerpc64-unknown-linux-gnu -std=c99 -x c %s -verify");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -DX64TYPE=ULLONG -triple powerpc64-unknown-linux-gnu -std=c11 -x c ${LLVM_SRC}/llvm/tools/clang/test/Sema/PR16678.c -verify
    RUN("%clang_cc1 -DX64TYPE=ULLONG -triple powerpc64-unknown-linux-gnu -std=c11 -x c %s -verify");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -DX64TYPE=ULLONG -triple powerpc64-unknown-linux-gnu -std=c++11 -x c++ ${LLVM_SRC}/llvm/tools/clang/test/Sema/PR16678.c -verify
    RUN("%clang_cc1 -DX64TYPE=ULLONG -triple powerpc64-unknown-linux-gnu -std=c++11 -x c++ %s -verify");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -DX64TYPE=ULLONG -triple powerpc64-unknown-linux-gnu -std=c++1y -x c++ ${LLVM_SRC}/llvm/tools/clang/test/Sema/PR16678.c -verify
    RUN("%clang_cc1 -DX64TYPE=ULLONG -triple powerpc64-unknown-linux-gnu -std=c++1y -x c++ %s -verify");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -DX64TYPE=ULLONG -triple powerpc64-unknown-linux-gnu -std=c++1z -x c++ ${LLVM_SRC}/llvm/tools/clang/test/Sema/PR16678.c -verify
    RUN("%clang_cc1 -DX64TYPE=ULLONG -triple powerpc64-unknown-linux-gnu -std=c++1z -x c++ %s -verify");
  }

  @Test
  public void test_PR2727_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Sema/PR2727.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -verify -fsyntax-only -std=c90 ${LLVM_SRC}/llvm/tools/clang/test/Sema/PR2727.c
    RUN("%clang_cc1 -verify -fsyntax-only -std=c90 %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -verify -fsyntax-only -std=c99 ${LLVM_SRC}/llvm/tools/clang/test/Sema/PR2727.c
    RUN("%clang_cc1 -verify -fsyntax-only -std=c99 %s");
  }

  @Test
  public void test_PR2728_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Sema/PR2728.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -verify -fsyntax-only -std=c90 ${LLVM_SRC}/llvm/tools/clang/test/Sema/PR2728.c
    RUN("%clang_cc1 -verify -fsyntax-only -std=c90 %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -verify -fsyntax-only -std=c99 ${LLVM_SRC}/llvm/tools/clang/test/Sema/PR2728.c
    RUN("%clang_cc1 -verify -fsyntax-only -std=c99 %s");
  }

  @Test
  public void test_PR2919_builtin_types_compat_strips_crv_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Sema/PR2919-builtin-types-compat-strips-crv.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only ${LLVM_SRC}/llvm/tools/clang/test/Sema/PR2919-builtin-types-compat-strips-crv.c
    RUN("%clang_cc1 -fsyntax-only %s");
  }

  @Test
  public void test_PR2923_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Sema/PR2923.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/Sema/PR2923.c
    RUN("%clang_cc1 -fsyntax-only -verify %s");
  }

  @Test
  public void test_PR2963_enum_constant_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Sema/PR2963-enum-constant.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/Sema/PR2963-enum-constant.c -verify -pedantic -fsyntax-only
    RUN("%clang_cc1 %s -verify -pedantic -fsyntax-only");
  }

  @Test
  public void test___try_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Sema/__try.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-windows -fborland-extensions -DBORLAND -fsyntax-only -verify -fblocks ${LLVM_SRC}/llvm/tools/clang/test/Sema/__try.c
    RUN("%clang_cc1 -triple x86_64-windows -fborland-extensions -DBORLAND -fsyntax-only -verify -fblocks %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-windows -fms-extensions -fsyntax-only -verify -fblocks ${LLVM_SRC}/llvm/tools/clang/test/Sema/__try.c
    RUN("%clang_cc1 -triple x86_64-windows -fms-extensions -fsyntax-only -verify -fblocks %s");
  }

  @Test
  public void test_aarch64_neon_ranges_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Sema/aarch64-neon-ranges.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple aarch64-linux-gnu -target-feature +neon -ffreestanding -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/Sema/aarch64-neon-ranges.c
    RUN("%clang_cc1 -triple aarch64-linux-gnu -target-feature +neon -ffreestanding -fsyntax-only -verify %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple arm64-linux-gnu -target-feature +neon -ffreestanding -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/Sema/aarch64-neon-ranges.c
    RUN("%clang_cc1 -triple arm64-linux-gnu -target-feature +neon -ffreestanding -fsyntax-only -verify %s");
  }

  @Test
  public void test_aarch64_neon_vector_types_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Sema/aarch64-neon-vector-types.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/Sema/aarch64-neon-vector-types.c -triple aarch64-none-linux-gnu -target-feature +neon -fsyntax-only -verify
    RUN("%clang_cc1 %s -triple aarch64-none-linux-gnu -target-feature +neon -fsyntax-only -verify");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/Sema/aarch64-neon-vector-types.c -triple aarch64-none-linux-gnu -target-feature +neon -DUSE_LONG -fsyntax-only -verify
    RUN("%clang_cc1 %s -triple aarch64-none-linux-gnu -target-feature +neon -DUSE_LONG -fsyntax-only -verify");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/Sema/aarch64-neon-vector-types.c -triple arm64-none-linux-gnu -target-feature +neon -fsyntax-only -verify
    RUN("%clang_cc1 %s -triple arm64-none-linux-gnu -target-feature +neon -fsyntax-only -verify");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/Sema/aarch64-neon-vector-types.c -triple arm64-none-linux-gnu -target-feature +neon -DUSE_LONG -fsyntax-only -verify
    RUN("%clang_cc1 %s -triple arm64-none-linux-gnu -target-feature +neon -DUSE_LONG -fsyntax-only -verify");
  }

  @Test
  public void test_aarch64_special_register_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Sema/aarch64-special-register.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -ffreestanding -fsyntax-only -verify -triple aarch64 ${LLVM_SRC}/llvm/tools/clang/test/Sema/aarch64-special-register.c
    RUN("%clang_cc1 -ffreestanding -fsyntax-only -verify -triple aarch64 %s");
  }

  @Test
  public void test_address_constant_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Sema/address-constant.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/Sema/address-constant.c
    RUN("%clang_cc1 -fsyntax-only -verify %s");
  }

  @Test
  public void test_address_spaces_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Sema/address_spaces.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/Sema/address_spaces.c -fsyntax-only -verify
    RUN("%clang_cc1 %s -fsyntax-only -verify");
  }

  @Test
  public void test_alias_redefinition_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Sema/alias-redefinition.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-pc-linux-gnu -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/Sema/alias-redefinition.c
    RUN("%clang_cc1 -triple x86_64-pc-linux-gnu -fsyntax-only -verify %s");
  }

  @Test
  public void test_align_arm_apcs_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Sema/align-arm-apcs.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple arm-unknown-unknown -target-abi apcs-gnu -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/Sema/align-arm-apcs.c
    RUN("%clang_cc1 -triple arm-unknown-unknown -target-abi apcs-gnu -fsyntax-only -verify %s");
  }

  @Test
  public void test_align_systemz_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Sema/align-systemz.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple s390x-linux-gnu -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/Sema/align-systemz.c
    RUN("%clang_cc1 -triple s390x-linux-gnu -fsyntax-only -verify %s");
  }

  @Test
  public void test_align_x86_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Sema/align-x86.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i386-apple-darwin9 -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/Sema/align-x86.c
    RUN("%clang_cc1 -triple i386-apple-darwin9 -fsyntax-only -verify %s");
  }

  @Test
  public void test_align_x86_64_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Sema/align-x86-64.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-pc-linux-gnu -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/Sema/align-x86-64.c
    RUN("%clang_cc1 -triple x86_64-pc-linux-gnu -fsyntax-only -verify %s");
  }

  @Test
  public void test_align_value_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Sema/align_value.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/Sema/align_value.c
    RUN("%clang_cc1 -fsyntax-only -verify %s");
  }

  @Test
  public void test_alignas_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Sema/alignas.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -std=c11 -Dalignof=__alignof ${LLVM_SRC}/llvm/tools/clang/test/Sema/alignas.c
    RUN("%clang_cc1 -fsyntax-only -verify -std=c11 -Dalignof=__alignof %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -std=c11 -Dalignof=_Alignof -DUSING_C11_SYNTAX ${LLVM_SRC}/llvm/tools/clang/test/Sema/alignas.c
    RUN("%clang_cc1 -fsyntax-only -verify -std=c11 -Dalignof=_Alignof -DUSING_C11_SYNTAX %s");
  }

  @Test
  public void test_altivec_init_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Sema/altivec-init.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/Sema/altivec-init.c -triple=powerpc-apple-darwin8 -faltivec -verify -pedantic -fsyntax-only
    RUN("%clang_cc1 %s -triple=powerpc-apple-darwin8 -faltivec -verify -pedantic -fsyntax-only");
  }

  @Test
  public void test_annotate_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Sema/annotate.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/Sema/annotate.c -fsyntax-only -verify
    RUN("%clang_cc1 %s -fsyntax-only -verify");
  }

  @Test
  public void test_anonymous_struct_union_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Sema/anonymous-struct-union.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/Sema/anonymous-struct-union.c
    RUN("%clang_cc1 -fsyntax-only -verify %s");
  }

  @Test
  public void test_anonymous_struct_union_c11_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Sema/anonymous-struct-union-c11.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -std=c99 -verify -Wc11-extensions ${LLVM_SRC}/llvm/tools/clang/test/Sema/anonymous-struct-union-c11.c
    RUN("%clang_cc1 -fsyntax-only -std=c99 -verify -Wc11-extensions %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -std=c11 -pedantic -Werror ${LLVM_SRC}/llvm/tools/clang/test/Sema/anonymous-struct-union-c11.c
    RUN("%clang_cc1 -fsyntax-only -std=c11 -pedantic -Werror %s");
  }

  @Test
  public void test_arg_duplicate_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Sema/arg-duplicate.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/Sema/arg-duplicate.c
    RUN("%clang_cc1 -fsyntax-only -verify %s");
  }

  @Test
  public void test_arg_scope_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Sema/arg-scope.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/Sema/arg-scope.c
    RUN("%clang_cc1 -fsyntax-only -verify %s");
  }

  @Test
  public void test_arg_scope_c99_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Sema/arg-scope-c99.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -std=c99 -verify ${LLVM_SRC}/llvm/tools/clang/test/Sema/arg-scope-c99.c
    RUN("%clang_cc1 -fsyntax-only -std=c99 -verify %s");
  }

  @Test
  public void test_arm_asm_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Sema/arm-asm.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/Sema/arm-asm.c -triple armv7-apple-darwin -verify -fsyntax-only
    RUN("%clang_cc1 %s -triple armv7-apple-darwin -verify -fsyntax-only");
  }

  @Test
  public void test_arm_darwin_aapcs_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Sema/arm-darwin-aapcs.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/Sema/arm-darwin-aapcs.cpp -triple thumbv7-apple-ios -target-abi aapcs -verify -fsyntax-only
    RUN("%clang_cc1 %s -triple thumbv7-apple-ios -target-abi aapcs -verify -fsyntax-only");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/Sema/arm-darwin-aapcs.cpp -triple thumbv7m-apple-macho -target-abi aapcs -verify -fsyntax-only
    RUN("%clang_cc1 %s -triple thumbv7m-apple-macho -target-abi aapcs -verify -fsyntax-only");
  }

  @Test
  public void test_arm_interrupt_attr_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Sema/arm-interrupt-attr.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/Sema/arm-interrupt-attr.c -triple arm-apple-darwin -verify -fsyntax-only
    RUN("%clang_cc1 %s -triple arm-apple-darwin -verify -fsyntax-only");
  }

  @Test
  public void test_arm_layout_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Sema/arm-layout.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple armv7-unknown-unknown -target-abi apcs-gnu ${LLVM_SRC}/llvm/tools/clang/test/Sema/arm-layout.c -verify
    RUN("%clang_cc1 -triple armv7-unknown-unknown -target-abi apcs-gnu %s -verify");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple armv7-unknown-unknown -target-abi aapcs ${LLVM_SRC}/llvm/tools/clang/test/Sema/arm-layout.c -verify
    RUN("%clang_cc1 -triple armv7-unknown-unknown -target-abi aapcs %s -verify");
  }

  @Test
  public void test_arm_microsoft_intrinsics_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Sema/arm-microsoft-intrinsics.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple armv7 -fms-extensions -fsyntax-only -ffreestanding -verify ${LLVM_SRC}/llvm/tools/clang/test/Sema/arm-microsoft-intrinsics.c
    RUN("%clang_cc1 -triple armv7 -fms-extensions -fsyntax-only -ffreestanding -verify %s");
  }

  @Test
  public void test_arm_neon_types_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Sema/arm-neon-types.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple thumbv7-apple-darwin10 -target-cpu cortex-a8 -fsyntax-only -Wvector-conversion -ffreestanding -verify ${LLVM_SRC}/llvm/tools/clang/test/Sema/arm-neon-types.c
    RUN("%clang_cc1 -triple thumbv7-apple-darwin10 -target-cpu cortex-a8 -fsyntax-only -Wvector-conversion -ffreestanding -verify %s");
  }

  @Test
  public void test_arm_no_fp16_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Sema/arm-no-fp16.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple thumbv7-none-eabi ${LLVM_SRC}/llvm/tools/clang/test/Sema/arm-no-fp16.c -target-feature +neon -target-feature -fp16 -fsyntax-only -verify
    RUN("%clang_cc1 -triple thumbv7-none-eabi %s -target-feature +neon -target-feature -fp16 -fsyntax-only -verify");
  }

  @Test
  public void test_arm_special_register_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Sema/arm-special-register.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -ffreestanding -fsyntax-only -verify -triple arm ${LLVM_SRC}/llvm/tools/clang/test/Sema/arm-special-register.c
    RUN("%clang_cc1 -ffreestanding -fsyntax-only -verify -triple arm %s");
  }

  @Test
  public void test_arm64_inline_asm_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Sema/arm64-inline-asm.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple arm64-apple-ios7.1 -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/Sema/arm64-inline-asm.c
    RUN("%clang_cc1 -triple arm64-apple-ios7.1 -fsyntax-only -verify %s");
  }

  @Test
  public void test_arm64_neon_args_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Sema/arm64-neon-args.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple arm64-apple-darwin -target-feature +neon -fsyntax-only -ffreestanding -verify ${LLVM_SRC}/llvm/tools/clang/test/Sema/arm64-neon-args.c
    RUN("%clang_cc1 -triple arm64-apple-darwin -target-feature +neon -fsyntax-only -ffreestanding -verify %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple aarch64_be-none-linux-gnu -target-feature +neon -fsyntax-only -ffreestanding -verify ${LLVM_SRC}/llvm/tools/clang/test/Sema/arm64-neon-args.c
    RUN("%clang_cc1 -triple aarch64_be-none-linux-gnu -target-feature +neon -fsyntax-only -ffreestanding -verify %s");
  }

  @Test
  public void test_arm64_neon_header_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Sema/arm64-neon-header.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple arm64-apple-darwin -target-feature +neon -Wvector-conversion -fsyntax-only -ffreestanding -verify ${LLVM_SRC}/llvm/tools/clang/test/Sema/arm64-neon-header.c
    RUN("%clang_cc1 -triple arm64-apple-darwin -target-feature +neon -Wvector-conversion -fsyntax-only -ffreestanding -verify %s");
  }

  @Test
  public void test_arm_acle_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Sema/arm_acle.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple armv8 -target-cpu cortex-a57 -fsyntax-only -ffreestanding -verify ${LLVM_SRC}/llvm/tools/clang/test/Sema/arm_acle.c
    RUN("%clang_cc1 -triple armv8 -target-cpu cortex-a57 -fsyntax-only -ffreestanding -verify %s");
  }

  @Test
  public void test_arm_vfma_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Sema/arm_vfma.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple thumbv7-none-eabi -target-feature +neon -target-feature +vfp4 -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/Sema/arm_vfma.c
    RUN("%clang_cc1 -triple thumbv7-none-eabi -target-feature +neon -target-feature +vfp4 -fsyntax-only -verify %s");
  }

  @Test
  public void test_array_bounds_ptr_arith_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Sema/array-bounds-ptr-arith.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -verify -Warray-bounds-pointer-arithmetic ${LLVM_SRC}/llvm/tools/clang/test/Sema/array-bounds-ptr-arith.c
    RUN("%clang_cc1 -verify -Warray-bounds-pointer-arithmetic %s");
  }

  @Test
  public void test_array_constraint_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Sema/array-constraint.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -pedantic ${LLVM_SRC}/llvm/tools/clang/test/Sema/array-constraint.c
    RUN("%clang_cc1 -fsyntax-only -verify -pedantic %s");
  }

  @Test
  public void test_array_declared_as_incorrect_type_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Sema/array-declared-as-incorrect-type.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -pedantic ${LLVM_SRC}/llvm/tools/clang/test/Sema/array-declared-as-incorrect-type.c
    RUN("%clang_cc1 -fsyntax-only -verify -pedantic %s");
  }

  @Test
  public void test_array_init_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Sema/array-init.c");
    // REQUIRES: LP64
    if (!CHECK_REQUIRES("LP64")) {
      return;
    }
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=gnu99 -fsyntax-only -pedantic -verify ${LLVM_SRC}/llvm/tools/clang/test/Sema/array-init.c
    RUN(TestState.Failed, "%clang_cc1 -std=gnu99 -fsyntax-only -pedantic -verify %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=gnu99 -fsyntax-only -Wgnu -Wc11-extensions -verify ${LLVM_SRC}/llvm/tools/clang/test/Sema/array-init.c
    RUN(TestState.Failed, "%clang_cc1 -std=gnu99 -fsyntax-only -Wgnu -Wc11-extensions -verify %s");
  }

  @Test
  public void test_array_size_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Sema/array-size.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i686-apple-darwin -verify ${LLVM_SRC}/llvm/tools/clang/test/Sema/array-size.c
    RUN("%clang_cc1 -triple i686-apple-darwin -verify %s");
  }

  @Test
  public void test_array_size_64_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Sema/array-size-64.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-apple-darwin -verify ${LLVM_SRC}/llvm/tools/clang/test/Sema/array-size-64.c
    RUN("%clang_cc1 -triple x86_64-apple-darwin -verify %s");
  }

  @Test
  public void test_asm_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Sema/asm.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/Sema/asm.c -Wno-private-extern -triple i386-pc-linux-gnu -verify -fsyntax-only
    RUN(TestState.Failed, "%clang_cc1 %s -Wno-private-extern -triple i386-pc-linux-gnu -verify -fsyntax-only");
  }

  @Test
  public void test_asm_label_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Sema/asm-label.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -verify ${LLVM_SRC}/llvm/tools/clang/test/Sema/asm-label.c
    RUN("%clang_cc1 -verify %s");
  }

  @Test
  public void test_assign_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Sema/assign.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/Sema/assign.c
    RUN("%clang_cc1 -fsyntax-only -verify %s");
  }

  @Test
  public void test_assign_null_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Sema/assign-null.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/Sema/assign-null.c
    RUN("%clang_cc1 -fsyntax-only -verify %s");
  }

  @Test
  public void test_ast_print_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Sema/ast-print.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/Sema/ast-print.c -ast-print | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Sema/ast-print.c
    RUN("%clang_cc1 %s -ast-print")./*|*/
      I("FileCheck %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/Sema/ast-print.c -ast-print | ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -
    RUN("%clang_cc1 %s -ast-print")./*|*/
      I("%clang_cc1 -fsyntax-only -");
  }

  @Test
  public void test_ast_print_x86_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Sema/ast-print-x86.c");
    // REQUIRES: x86-registered-target
    if (!CHECK_REQUIRES("x86-registered-target")) {
      return;
    }
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i686-elf ${LLVM_SRC}/llvm/tools/clang/test/Sema/ast-print-x86.c -ast-print | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Sema/ast-print-x86.c
    RUN("%clang_cc1 -triple i686-elf %s -ast-print")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_atomic_compare_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Sema/atomic-compare.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/Sema/atomic-compare.c -verify -fsyntax-only -Wno-logical-not-parentheses
    RUN("%clang_cc1 %s -verify -fsyntax-only -Wno-logical-not-parentheses");
  }

  @Test
  public void test_atomic_expr_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Sema/atomic-expr.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/Sema/atomic-expr.c -verify -fsyntax-only
    RUN("%clang_cc1 %s -verify -fsyntax-only");
  }

  @Test
  public void test_atomic_ops_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Sema/atomic-ops.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/Sema/atomic-ops.c -verify -ffreestanding -fsyntax-only -triple=i686-linux-gnu -std=c11
    RUN("%clang_cc1 %s -verify -ffreestanding -fsyntax-only -triple=i686-linux-gnu -std=c11");
  }

  @Test
  public void test_atomic_requires_library_error_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Sema/atomic-requires-library-error.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/Sema/atomic-requires-library-error.c -triple=i686-apple-darwin9 -verify
    RUN("%clang_cc1 %s -triple=i686-apple-darwin9 -verify");
  }

  @Test
  public void test_atomic_type_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Sema/atomic-type.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/Sema/atomic-type.c -verify -fsyntax-only
    RUN("%clang_cc1 %s -verify -fsyntax-only");
  }

  @Test
  public void test_attr_alias_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Sema/attr-alias.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-apple-darwin -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/Sema/attr-alias.c
    RUN("%clang_cc1 -triple x86_64-apple-darwin  -fsyntax-only -verify %s");
  }

  @Test
  public void test_attr_alias_elf_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Sema/attr-alias-elf.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-pc-linux -fsyntax-only -verify -emit-llvm-only ${LLVM_SRC}/llvm/tools/clang/test/Sema/attr-alias-elf.c
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-pc-linux  -fsyntax-only -verify -emit-llvm-only %s");
  }

  @Test
  public void test_attr_aligned_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Sema/attr-aligned.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i386-apple-darwin9 -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/Sema/attr-aligned.c
    RUN("%clang_cc1 -triple i386-apple-darwin9 -fsyntax-only -verify %s");
  }

  @Test
  public void test_attr_args_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Sema/attr-args.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -verify -Wunused -Wused-but-marked-unused -Wunused-parameter -fsyntax-only ${LLVM_SRC}/llvm/tools/clang/test/Sema/attr-args.c
    RUN("%clang_cc1 -verify -Wunused -Wused-but-marked-unused -Wunused-parameter -fsyntax-only %s");
  }

  @Test
  public void test_attr_availability_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Sema/attr-availability.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-apple-darwin9 -fsyntax-only -fblocks -verify ${LLVM_SRC}/llvm/tools/clang/test/Sema/attr-availability.c
    RUN("%clang_cc1 -triple x86_64-apple-darwin9 -fsyntax-only -fblocks -verify %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -D WARN_PARTIAL -Wpartial-availability -triple x86_64-apple-darwin9 -fsyntax-only -fblocks -verify ${LLVM_SRC}/llvm/tools/clang/test/Sema/attr-availability.c
    RUN("%clang_cc1 -D WARN_PARTIAL -Wpartial-availability -triple x86_64-apple-darwin9 -fsyntax-only -fblocks -verify %s");
  }

  @Test
  public void test_attr_availability_android_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Sema/attr-availability-android.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple arm-linux-androideabi16 -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/Sema/attr-availability-android.c
    RUN("%clang_cc1 \"-triple\" \"arm-linux-androideabi16\" -fsyntax-only -verify %s");
  }

  @Test
  public void test_attr_availability_app_extensions_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Sema/attr-availability-app-extensions.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-apple-macosx10.9.0 -fsyntax-only -fapplication-extension ${LLVM_SRC}/llvm/tools/clang/test/Sema/attr-availability-app-extensions.c -verify
    RUN("%clang_cc1 -triple x86_64-apple-macosx10.9.0 -fsyntax-only -fapplication-extension %s -verify");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple armv7-apple-ios9.0 -fsyntax-only -fapplication-extension ${LLVM_SRC}/llvm/tools/clang/test/Sema/attr-availability-app-extensions.c -verify
    RUN("%clang_cc1 -triple armv7-apple-ios9.0 -fsyntax-only -fapplication-extension %s -verify");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple arm64-apple-tvos3.0 -fsyntax-only -fapplication-extension -DTVOS=1 -verify ${LLVM_SRC}/llvm/tools/clang/test/Sema/attr-availability-app-extensions.c
    RUN("%clang_cc1 -triple arm64-apple-tvos3.0 -fsyntax-only -fapplication-extension -DTVOS=1 -verify %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple arm64-apple-tvos3.0 -fsyntax-only -fapplication-extension -verify ${LLVM_SRC}/llvm/tools/clang/test/Sema/attr-availability-app-extensions.c
    RUN("%clang_cc1 -triple arm64-apple-tvos3.0 -fsyntax-only -fapplication-extension -verify %s");
  }

  @Test
  public void test_attr_availability_ios_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Sema/attr-availability-ios.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-apple-ios3.0 -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/Sema/attr-availability-ios.c
    RUN("%clang_cc1 \"-triple\" \"x86_64-apple-ios3.0\" -fsyntax-only -verify %s");
  }

  @Test
  public void test_attr_availability_macosx_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Sema/attr-availability-macosx.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-apple-darwin9.0.0 -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/Sema/attr-availability-macosx.c
    RUN("%clang_cc1 \"-triple\" \"x86_64-apple-darwin9.0.0\" -fsyntax-only -verify %s");
  }

  @Test
  public void test_attr_availability_tvos_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Sema/attr-availability-tvos.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-apple-tvos3.0 -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/Sema/attr-availability-tvos.c
    RUN("%clang_cc1 \"-triple\" \"x86_64-apple-tvos3.0\" -fsyntax-only -verify %s");
  }

  @Test
  public void test_attr_availability_watchos_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Sema/attr-availability-watchos.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple arm64-apple-watchos3.0 -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/Sema/attr-availability-watchos.c
    RUN("%clang_cc1 \"-triple\" \"arm64-apple-watchos3.0\" -fsyntax-only -verify %s");
  }

  @Test
  public void test_attr_bounded_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Sema/attr-bounded.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only ${LLVM_SRC}/llvm/tools/clang/test/Sema/attr-bounded.c
    RUN("%clang_cc1 -fsyntax-only %s");
  }

  @Test
  public void test_attr_capabilities_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Sema/attr-capabilities.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -Wthread-safety -verify ${LLVM_SRC}/llvm/tools/clang/test/Sema/attr-capabilities.c
    RUN("%clang_cc1 -fsyntax-only -Wthread-safety -verify %s");
  }

  @Test
  public void test_attr_cleanup_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Sema/attr-cleanup.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/Sema/attr-cleanup.c -verify -fsyntax-only
    RUN("%clang_cc1 %s -verify -fsyntax-only");
  }

  @Test
  public void test_attr_coldhot_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Sema/attr-coldhot.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/Sema/attr-coldhot.c
    RUN("%clang_cc1 -fsyntax-only -verify %s");
  }

  @Test
  public void test_attr_decl_after_definition_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Sema/attr-decl-after-definition.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/Sema/attr-decl-after-definition.c
    RUN("%clang_cc1 -fsyntax-only -verify %s");
  }

  @Test
  public void test_attr_declspec_ignored_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Sema/attr-declspec-ignored.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/Sema/attr-declspec-ignored.c -verify -fsyntax-only
    RUN("%clang_cc1 %s -verify -fsyntax-only");
  }

  @Test
  public void test_attr_deprecated_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Sema/attr-deprecated.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/Sema/attr-deprecated.c -verify -fsyntax-only
    RUN("%clang_cc1 %s -verify -fsyntax-only");
  }

  @Test
  public void test_attr_deprecated_message_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Sema/attr-deprecated-message.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/Sema/attr-deprecated-message.c -verify -fsyntax-only
    RUN("%clang_cc1 %s -verify -fsyntax-only");
  }

  @Test
  public void test_attr_disable_tail_calls_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Sema/attr-disable-tail-calls.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/Sema/attr-disable-tail-calls.c
    RUN("%clang_cc1 -fsyntax-only -verify %s");
  }

  @Test
  public void test_attr_endian_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Sema/attr-endian.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/Sema/attr-endian.c -verify -fsyntax-only
    RUN("%clang_cc1 %s -verify -fsyntax-only");
  }

  @Test
  public void test_attr_flag_enum_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Sema/attr-flag-enum.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i386-pc-solaris2.11 -verify -fsyntax-only -std=c11 -Wassign-enum ${LLVM_SRC}/llvm/tools/clang/test/Sema/attr-flag-enum.c
    RUN("%clang_cc1 -triple %itanium_abi_triple -verify -fsyntax-only -std=c11 -Wassign-enum %s");
  }

  @Test
  public void test_attr_format_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Sema/attr-format.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/Sema/attr-format.c
    RUN("%clang_cc1 -fsyntax-only -verify %s");
  }

  @Test
  public void test_attr_format_arg_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Sema/attr-format_arg.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/Sema/attr-format_arg.c
    RUN("%clang_cc1 -fsyntax-only -verify %s");
  }

  @Test
  public void test_attr_ifunc_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Sema/attr-ifunc.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-windows -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/Sema/attr-ifunc.c
    RUN("%clang_cc1 -triple x86_64-windows -fsyntax-only -verify %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-linux -fsyntax-only -verify -emit-llvm-only -DCHECK_ALIASES ${LLVM_SRC}/llvm/tools/clang/test/Sema/attr-ifunc.c
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-linux -fsyntax-only -verify -emit-llvm-only -DCHECK_ALIASES %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-linux -fsyntax-only -verify -emit-llvm-only ${LLVM_SRC}/llvm/tools/clang/test/Sema/attr-ifunc.c
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-linux -fsyntax-only -verify -emit-llvm-only %s");
  }

  @Test
  public void test_attr_malloc_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Sema/attr-malloc.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -verify -fsyntax-only ${LLVM_SRC}/llvm/tools/clang/test/Sema/attr-malloc.c
    RUN("%clang_cc1 -verify -fsyntax-only %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm -o ${TEST_TEMP_DIR}/attr-malloc.c.tmp ${LLVM_SRC}/llvm/tools/clang/test/Sema/attr-malloc.c
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm -o %t %s");
    // grep 'define .*noalias .* @xalloc(' ${TEST_TEMP_DIR}/attr-malloc.c.tmp ${TEST_TEMP_DIR}/attr-malloc.c.tmp
    RUN(TestState.Failed, "grep 'define .*noalias .* @xalloc(' %t %t");
    // grep 'define .*noalias .* @xalloc2(' ${TEST_TEMP_DIR}/attr-malloc.c.tmp ${TEST_TEMP_DIR}/attr-malloc.c.tmp
    RUN(TestState.Failed, "grep 'define .*noalias .* @xalloc2(' %t %t");
  }

  @Test
  public void test_attr_minsize_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Sema/attr-minsize.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/Sema/attr-minsize.c
    RUN("%clang_cc1 -fsyntax-only -verify %s");
  }

  @Test
  public void test_attr_mode_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Sema/attr-mode.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i686-pc-linux-gnu -DTEST_32BIT_X86 -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/Sema/attr-mode.c
    RUN("%clang_cc1 -triple i686-pc-linux-gnu -DTEST_32BIT_X86 -fsyntax-only -verify %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-pc-linux-gnu -DTEST_64BIT_X86 -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/Sema/attr-mode.c
    RUN("%clang_cc1 -triple x86_64-pc-linux-gnu -DTEST_64BIT_X86 -fsyntax-only -verify %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple powerpc64-pc-linux-gnu -DTEST_64BIT_PPC64 -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/Sema/attr-mode.c
    RUN("%clang_cc1 -triple powerpc64-pc-linux-gnu -DTEST_64BIT_PPC64 -fsyntax-only -verify %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-pc-linux-gnux32 -DTEST_64BIT_X86 -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/Sema/attr-mode.c
    RUN("%clang_cc1 -triple x86_64-pc-linux-gnux32 -DTEST_64BIT_X86 -fsyntax-only -verify %s");
  }

  @Test
  public void test_attr_mode_enums_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Sema/attr-mode-enums.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/Sema/attr-mode-enums.c
    RUN("%clang_cc1 -fsyntax-only -verify %s");
  }

  @Test
  public void test_attr_mode_vector_types_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Sema/attr-mode-vector-types.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -triple x86_64-unknown-linux-gnu ${LLVM_SRC}/llvm/tools/clang/test/Sema/attr-mode-vector-types.c
    RUN("%clang_cc1 -fsyntax-only -verify -triple x86_64-unknown-linux-gnu %s");
  }

  @Test
  public void test_attr_msp430_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Sema/attr-msp430.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple msp430-unknown-unknown -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/Sema/attr-msp430.c
    RUN("%clang_cc1 -triple msp430-unknown-unknown -fsyntax-only -verify %s");
  }

  @Test
  public void test_attr_naked_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Sema/attr-naked.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/Sema/attr-naked.c -verify -fsyntax-only -triple i686-pc-linux
    RUN("%clang_cc1 %s -verify -fsyntax-only -triple i686-pc-linux");
  }

  @Test
  public void test_attr_naked_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Sema/attr-naked.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/Sema/attr-naked.cpp -verify -fsyntax-only -triple arm-none-linux
    RUN("%clang_cc1 %s -verify -fsyntax-only -triple arm-none-linux");
  }

  @Test
  public void test_attr_nodebug_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Sema/attr-nodebug.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/Sema/attr-nodebug.c -verify -fsyntax-only
    RUN("%clang_cc1 %s -verify -fsyntax-only");
  }

  @Test
  public void test_attr_noduplicate_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Sema/attr-noduplicate.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/Sema/attr-noduplicate.c -verify -fsyntax-only
    RUN("%clang_cc1 %s -verify -fsyntax-only");
  }

  @Test
  public void test_attr_noinline_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Sema/attr-noinline.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/Sema/attr-noinline.c -verify -fsyntax-only
    RUN("%clang_cc1 %s -verify -fsyntax-only");
  }

  @Test
  public void test_attr_nonnull_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Sema/attr-nonnull.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/Sema/attr-nonnull.c -verify -fsyntax-only
    RUN("%clang_cc1 %s -verify -fsyntax-only");
  }

  @Test
  public void test_attr_noreturn_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Sema/attr-noreturn.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -verify -fsyntax-only ${LLVM_SRC}/llvm/tools/clang/test/Sema/attr-noreturn.c
    RUN("%clang_cc1 -verify -fsyntax-only %s");
  }

  @Test
  public void test_attr_notail_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Sema/attr-notail.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/Sema/attr-notail.c
    RUN("%clang_cc1 -fsyntax-only -verify %s");
  }

  @Test
  public void test_attr_ownership_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Sema/attr-ownership.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/Sema/attr-ownership.c -verify
    RUN("%clang_cc1 %s -verify");
  }

  @Test
  public void test_attr_print_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Sema/attr-print.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/Sema/attr-print.c -ast-print -fms-extensions | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Sema/attr-print.c
    RUN("%clang_cc1 %s -ast-print -fms-extensions")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_attr_regparm_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Sema/attr-regparm.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i386-apple-darwin9 -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/Sema/attr-regparm.c
    RUN("%clang_cc1 -triple i386-apple-darwin9 -fsyntax-only -verify %s");
  }

  @Test
  public void test_attr_returns_twice_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Sema/attr-returns-twice.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/Sema/attr-returns-twice.c -verify -fsyntax-only
    RUN("%clang_cc1 %s -verify -fsyntax-only");
  }

  @Test
  public void test_attr_section_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Sema/attr-section.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -verify -fsyntax-only -triple x86_64-apple-darwin9 ${LLVM_SRC}/llvm/tools/clang/test/Sema/attr-section.c
    RUN("%clang_cc1 -verify -fsyntax-only -triple x86_64-apple-darwin9 %s");
  }

  @Test
  public void test_attr_self_alias_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Sema/attr-self-alias.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-pc-linux -fsyntax-only -verify -emit-llvm-only ${LLVM_SRC}/llvm/tools/clang/test/Sema/attr-self-alias.c
    RUN("%clang_cc1 -triple x86_64-pc-linux  -fsyntax-only -verify -emit-llvm-only %s");
  }

  @Test
  public void test_attr_sentinel_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Sema/attr-sentinel.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/Sema/attr-sentinel.c
    RUN("%clang_cc1  -fsyntax-only -verify %s");
  }

  @Test
  public void test_attr_swiftcall_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Sema/attr-swiftcall.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-apple-darwin10 -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/Sema/attr-swiftcall.c
    RUN("%clang_cc1 -triple x86_64-apple-darwin10 -fsyntax-only -verify %s");
  }

  @Test
  public void test_attr_target_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Sema/attr-target.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-linux-gnu -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/Sema/attr-target.c
    RUN("%clang_cc1 -triple x86_64-linux-gnu  -fsyntax-only -verify %s");
  }

  @Test
  public void test_attr_tls_model_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Sema/attr-tls_model.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-pc-linux-gnu -verify -fsyntax-only ${LLVM_SRC}/llvm/tools/clang/test/Sema/attr-tls_model.c
    RUN("%clang_cc1 -triple x86_64-pc-linux-gnu -verify -fsyntax-only %s");
  }

  @Test
  public void test_attr_unavailable_message_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Sema/attr-unavailable-message.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/Sema/attr-unavailable-message.c
    RUN("%clang_cc1 -fsyntax-only -verify %s");
  }

  @Test
  public void test_attr_unknown_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Sema/attr-unknown.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -Wattributes ${LLVM_SRC}/llvm/tools/clang/test/Sema/attr-unknown.c
    RUN("%clang_cc1 -fsyntax-only -verify -Wattributes %s");
  }

  @Test
  public void test_attr_unused_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Sema/attr-unused.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -verify -Wunused -Wused-but-marked-unused -Wunused-parameter -Wunused -fsyntax-only ${LLVM_SRC}/llvm/tools/clang/test/Sema/attr-unused.c
    RUN("%clang_cc1 -verify -Wunused -Wused-but-marked-unused -Wunused-parameter -Wunused -fsyntax-only %s");
  }

  @Test
  public void test_attr_used_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Sema/attr-used.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -verify -fsyntax-only -Wno-private-extern ${LLVM_SRC}/llvm/tools/clang/test/Sema/attr-used.c
    RUN("%clang_cc1 -verify -fsyntax-only -Wno-private-extern %s");
  }

  @Test
  public void test_attr_visibility_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Sema/attr-visibility.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-apple-darwin10 -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/Sema/attr-visibility.c
    RUN("%clang_cc1 -triple x86_64-apple-darwin10 -fsyntax-only -verify %s");
  }

  @Test
  public void test_attr_weak_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Sema/attr-weak.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -verify -fsyntax-only ${LLVM_SRC}/llvm/tools/clang/test/Sema/attr-weak.c
    RUN("%clang_cc1 -verify -fsyntax-only %s");
  }

  @Test
  public void test_attr_x86_interrupt_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Sema/attr-x86-interrupt.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-unknown-linux-gnu -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/Sema/attr-x86-interrupt.c
    RUN("%clang_cc1 -triple x86_64-unknown-linux-gnu  -fsyntax-only -verify %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i386-unknown-linux-gnu -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/Sema/attr-x86-interrupt.c
    RUN("%clang_cc1 -triple i386-unknown-linux-gnu  -fsyntax-only -verify %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-pc-win32 -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/Sema/attr-x86-interrupt.c
    RUN("%clang_cc1 -triple x86_64-pc-win32  -fsyntax-only -verify %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i386-pc-win32 -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/Sema/attr-x86-interrupt.c
    RUN("%clang_cc1 -triple i386-pc-win32  -fsyntax-only -verify %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-unknown-linux-gnux32 -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/Sema/attr-x86-interrupt.c
    RUN("%clang_cc1 -triple x86_64-unknown-linux-gnux32  -fsyntax-only -verify %s");
  }

  @Test
  public void test_auto_type_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Sema/auto-type.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/Sema/auto-type.c -fsyntax-only -verify -pedantic -std=c11
    RUN("%clang_cc1 %s -fsyntax-only -verify -pedantic -std=c11");
  }

  @Test
  public void test_big_endian_neon_initializers_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Sema/big-endian-neon-initializers.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/Sema/big-endian-neon-initializers.c -triple aarch64_be -target-feature +neon -verify -fsyntax-only -ffreestanding
    RUN("%clang_cc1 %s -triple aarch64_be -target-feature +neon -verify -fsyntax-only -ffreestanding");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/Sema/big-endian-neon-initializers.c -triple armebv7 -target-cpu cortex-a8 -verify -fsyntax-only -ffreestanding
    RUN("%clang_cc1 %s -triple armebv7 -target-cpu cortex-a8 -verify -fsyntax-only -ffreestanding");
  }

  @Test
  public void test_bitfield_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Sema/bitfield.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/Sema/bitfield.c -fsyntax-only -verify -std=c11 -Wno-unused-value
    RUN("%clang_cc1 %s -fsyntax-only -verify -std=c11 -Wno-unused-value");
  }

  @Test
  public void test_bitfield_layout_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Sema/bitfield-layout.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/Sema/bitfield-layout.c -fsyntax-only -verify -triple=i686-apple-darwin9
    RUN("%clang_cc1 %s -fsyntax-only -verify -triple=i686-apple-darwin9");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/Sema/bitfield-layout.c -fsyntax-only -verify -triple=arm-linux-gnueabihf
    RUN("%clang_cc1 %s -fsyntax-only -verify -triple=arm-linux-gnueabihf");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/Sema/bitfield-layout.c -fsyntax-only -verify -triple=aarch64-linux-gnu
    RUN("%clang_cc1 %s -fsyntax-only -verify -triple=aarch64-linux-gnu");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/Sema/bitfield-layout.c -fsyntax-only -verify -triple=x86_64-pc-linux-gnu
    RUN("%clang_cc1 %s -fsyntax-only -verify -triple=x86_64-pc-linux-gnu");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/Sema/bitfield-layout.c -fsyntax-only -verify -triple=x86_64-scei-ps4
    RUN("%clang_cc1 %s -fsyntax-only -verify -triple=x86_64-scei-ps4");
  }

  @Test
  public void test_bitfield_layout_1_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Sema/bitfield-layout_1.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/Sema/bitfield-layout_1.c -fsyntax-only -verify -triple=i686-apple-darwin9
    RUN("%clang_cc1 %s -fsyntax-only -verify -triple=i686-apple-darwin9");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/Sema/bitfield-layout_1.c -fsyntax-only -verify -triple=arm-linux-gnueabihf
    RUN("%clang_cc1 %s -fsyntax-only -verify -triple=arm-linux-gnueabihf");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/Sema/bitfield-layout_1.c -fsyntax-only -verify -triple=aarch64-linux-gnu
    RUN("%clang_cc1 %s -fsyntax-only -verify -triple=aarch64-linux-gnu");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/Sema/bitfield-layout_1.c -fsyntax-only -verify -triple=x86_64-pc-linux-gnu
    RUN("%clang_cc1 %s -fsyntax-only -verify -triple=x86_64-pc-linux-gnu");
  }

  @Test
  public void test_bitfield_promote_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Sema/bitfield-promote.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/Sema/bitfield-promote.c
    RUN("%clang_cc1 -fsyntax-only -verify %s");
  }

  @Test
  public void test_block_args_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Sema/block-args.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/Sema/block-args.c -fsyntax-only -verify -fblocks
    RUN("%clang_cc1 %s -fsyntax-only -verify -fblocks");
  }

  @Test
  public void test_block_call_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Sema/block-call.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/Sema/block-call.c -fblocks
    RUN("%clang_cc1 -fsyntax-only -verify %s -fblocks");
  }

  @Test
  public void test_block_explicit_noreturn_type_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Sema/block-explicit-noreturn-type.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/Sema/block-explicit-noreturn-type.c -fsyntax-only -verify -fblocks
    RUN("%clang_cc1 %s -fsyntax-only -verify -fblocks");
  }

  @Test
  public void test_block_labels_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Sema/block-labels.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/Sema/block-labels.c -verify -fblocks -fsyntax-only
    RUN("%clang_cc1 %s -verify -fblocks -fsyntax-only");
  }

  @Test
  public void test_block_literal_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Sema/block-literal.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only ${LLVM_SRC}/llvm/tools/clang/test/Sema/block-literal.c -verify -fblocks
    RUN("%clang_cc1 -fsyntax-only %s -verify -fblocks");
  }

  @Test
  public void test_block_misc_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Sema/block-misc.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/Sema/block-misc.c -fblocks
    RUN("%clang_cc1 -fsyntax-only -verify %s -fblocks");
  }

  @Test
  public void test_block_printf_attribute_1_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Sema/block-printf-attribute-1.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/Sema/block-printf-attribute-1.c -fsyntax-only -verify -fblocks
    RUN("%clang_cc1 %s -fsyntax-only -verify -fblocks");
  }

  @Test
  public void test_block_return_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Sema/block-return.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -Wno-int-to-pointer-cast -pedantic -fsyntax-only ${LLVM_SRC}/llvm/tools/clang/test/Sema/block-return.c -verify -fblocks
    RUN("%clang_cc1 -Wno-int-to-pointer-cast -pedantic -fsyntax-only %s -verify -fblocks");
  }

  @Test
  public void test_block_return_1_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Sema/block-return-1.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only ${LLVM_SRC}/llvm/tools/clang/test/Sema/block-return-1.c -verify -fblocks
    RUN("%clang_cc1 -fsyntax-only %s -verify -fblocks");
  }

  @Test
  public void test_block_return_2_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Sema/block-return-2.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only ${LLVM_SRC}/llvm/tools/clang/test/Sema/block-return-2.c -verify -fblocks
    RUN("%clang_cc1 -fsyntax-only %s -verify -fblocks");
  }

  @Test
  public void test_block_return_3_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Sema/block-return-3.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only ${LLVM_SRC}/llvm/tools/clang/test/Sema/block-return-3.c -verify -fblocks
    RUN("%clang_cc1 -fsyntax-only %s -verify -fblocks");
  }

  @Test
  public void test_block_sentinel_attribute_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Sema/block-sentinel-attribute.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fblocks -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/Sema/block-sentinel-attribute.c
    RUN("%clang_cc1 -fblocks -fsyntax-only -verify %s");
  }

  @Test
  public void test_block_storageclass_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Sema/block-storageclass.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/Sema/block-storageclass.c -fsyntax-only -verify -fblocks
    RUN("%clang_cc1 %s -fsyntax-only -verify -fblocks");
  }

  @Test
  public void test_bool_compare_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Sema/bool-compare.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/Sema/bool-compare.c -Wno-logical-not-parentheses
    RUN("%clang_cc1 -fsyntax-only -verify %s -Wno-logical-not-parentheses");
  }

  @Test
  public void test_builtin_assume_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Sema/builtin-assume.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i386-mingw32 -fms-extensions -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/Sema/builtin-assume.c
    RUN("%clang_cc1 -triple i386-mingw32 -fms-extensions -fsyntax-only -verify %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-unknown-unknown -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/Sema/builtin-assume.c
    RUN("%clang_cc1 -triple x86_64-unknown-unknown -fsyntax-only -verify %s");
  }

  @Test
  public void test_builtin_assume_aligned_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Sema/builtin-assume-aligned.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/Sema/builtin-assume-aligned.c
    RUN("%clang_cc1 -fsyntax-only -verify %s");
  }

  @Test
  public void test_builtin_classify_type_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Sema/builtin-classify-type.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/Sema/builtin-classify-type.c
    RUN("%clang_cc1 -fsyntax-only -verify %s");
  }

  @Test
  public void test_builtin_clear_cache_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Sema/builtin-clear_cache.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple armv7-none-linux-gnu -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/Sema/builtin-clear_cache.c
    RUN("%clang_cc1 -triple armv7-none-linux-gnu -fsyntax-only -verify %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple aarch64-none-linux-gnu -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/Sema/builtin-clear_cache.c
    RUN("%clang_cc1 -triple aarch64-none-linux-gnu -fsyntax-only -verify %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple arm64-none-linux-gnu -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/Sema/builtin-clear_cache.c
    RUN("%clang_cc1 -triple arm64-none-linux-gnu -fsyntax-only -verify %s");
  }

  @Test
  public void test_builtin_cpu_supports_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Sema/builtin-cpu-supports.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -triple x86_64-pc-linux-gnu -verify ${LLVM_SRC}/llvm/tools/clang/test/Sema/builtin-cpu-supports.c
    RUN("%clang_cc1 -fsyntax-only -triple x86_64-pc-linux-gnu -verify %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -triple powerpc64le-linux-gnu -verify ${LLVM_SRC}/llvm/tools/clang/test/Sema/builtin-cpu-supports.c
    RUN("%clang_cc1 -fsyntax-only -triple powerpc64le-linux-gnu -verify %s");
  }

  @Test
  public void test_builtin_longjmp_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Sema/builtin-longjmp.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i386-unknown-unknown -emit-llvm < ${LLVM_SRC}/llvm/tools/clang/test/Sema/builtin-longjmp.c| ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Sema/builtin-longjmp.c
    RUN(TestState.Failed, "%clang_cc1 -triple i386-unknown-unknown -emit-llvm < %s")./*|*/
      I("FileCheck %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-unknown-unknown -emit-llvm < ${LLVM_SRC}/llvm/tools/clang/test/Sema/builtin-longjmp.c| ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Sema/builtin-longjmp.c
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-unknown-unknown -emit-llvm < %s")./*|*/
      I("FileCheck %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-windows -emit-llvm < ${LLVM_SRC}/llvm/tools/clang/test/Sema/builtin-longjmp.c| ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Sema/builtin-longjmp.c
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-windows -emit-llvm < %s")./*|*/
      I("FileCheck %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple powerpc-unknown-unknown -emit-llvm < ${LLVM_SRC}/llvm/tools/clang/test/Sema/builtin-longjmp.c| ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Sema/builtin-longjmp.c
    RUN(TestState.Failed, "%clang_cc1 -triple powerpc-unknown-unknown -emit-llvm < %s")./*|*/
      I("FileCheck %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple powerpc64-unknown-unknown -emit-llvm < ${LLVM_SRC}/llvm/tools/clang/test/Sema/builtin-longjmp.c| ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Sema/builtin-longjmp.c
    RUN(TestState.Failed, "%clang_cc1 -triple powerpc64-unknown-unknown -emit-llvm < %s")./*|*/
      I("FileCheck %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple sparc-eabi-unknown -emit-llvm < ${LLVM_SRC}/llvm/tools/clang/test/Sema/builtin-longjmp.c | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Sema/builtin-longjmp.c
    RUN(TestState.Failed, "%clang_cc1 -triple sparc-eabi-unknown -emit-llvm < %s")./*|*/
      I("FileCheck %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple aarch64-unknown-unknown -emit-llvm-only -verify ${LLVM_SRC}/llvm/tools/clang/test/Sema/builtin-longjmp.c
    RUN(TestState.Failed, "%clang_cc1 -triple aarch64-unknown-unknown -emit-llvm-only -verify %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple mips-unknown-unknown -emit-llvm-only -verify ${LLVM_SRC}/llvm/tools/clang/test/Sema/builtin-longjmp.c
    RUN(TestState.Failed, "%clang_cc1 -triple mips-unknown-unknown -emit-llvm-only -verify %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple mips64-unknown-unknown -emit-llvm-only -verify ${LLVM_SRC}/llvm/tools/clang/test/Sema/builtin-longjmp.c
    RUN(TestState.Failed, "%clang_cc1 -triple mips64-unknown-unknown -emit-llvm-only -verify %s");
  }

  @Test
  public void test_builtin_object_size_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Sema/builtin-object-size.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/Sema/builtin-object-size.c
    RUN("%clang_cc1 -fsyntax-only -verify %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -triple x86_64-apple-darwin9 -verify ${LLVM_SRC}/llvm/tools/clang/test/Sema/builtin-object-size.c
    RUN("%clang_cc1 -fsyntax-only -triple x86_64-apple-darwin9 -verify %s");
  }

  @Test
  public void test_builtin_prefetch_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Sema/builtin-prefetch.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/Sema/builtin-prefetch.c
    RUN("%clang_cc1 -fsyntax-only -verify %s");
  }

  @Test
  public void test_builtin_stackaddress_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Sema/builtin-stackaddress.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/Sema/builtin-stackaddress.c
    RUN("%clang_cc1 -fsyntax-only -verify %s");
  }

  @Test
  public void test_builtin_unary_fp_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Sema/builtin-unary-fp.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/Sema/builtin-unary-fp.c -fsyntax-only -verify -pedantic
    RUN("%clang_cc1 %s -fsyntax-only -verify -pedantic");
  }

  @Test
  public void test_builtin_objc_msgSend_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Sema/builtin_objc_msgSend.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/Sema/builtin_objc_msgSend.c -fsyntax-only -verify
    RUN("%clang_cc1 %s -fsyntax-only -verify");
  }

  @Test
  public void test_builtins_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Sema/builtins.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/Sema/builtins.c -fsyntax-only -verify -pedantic -Wstrlcpy-strlcat-size -Wno-string-plus-int -triple=i686-apple-darwin9
    RUN("%clang_cc1 %s -fsyntax-only -verify -pedantic -Wstrlcpy-strlcat-size -Wno-string-plus-int -triple=i686-apple-darwin9");
  }

  @Test
  public void test_builtins_cl() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Sema/builtins.cl");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/Sema/builtins.cl -fsyntax-only -verify -pedantic
    RUN("%clang_cc1 %s -fsyntax-only -verify -pedantic");
  }

  @Test
  public void test_builtins_aarch64_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Sema/builtins-aarch64.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple aarch64-none-linux-gnu -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/Sema/builtins-aarch64.c
    RUN("%clang_cc1 -triple aarch64-none-linux-gnu -fsyntax-only -verify %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple aarch64-none-linux-gnu -DTEST1 -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/Sema/builtins-aarch64.c
    RUN("%clang_cc1 -triple aarch64-none-linux-gnu -DTEST1 -fsyntax-only -verify %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple arm64-none-linux-gnu -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/Sema/builtins-aarch64.c
    RUN("%clang_cc1 -triple arm64-none-linux-gnu -fsyntax-only -verify %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple arm64-none-linux-gnu -DTEST1 -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/Sema/builtins-aarch64.c
    RUN("%clang_cc1 -triple arm64-none-linux-gnu -DTEST1 -fsyntax-only -verify %s");
  }

  @Test
  public void test_builtins_arm_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Sema/builtins-arm.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple armv7 -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/Sema/builtins-arm.c
    RUN("%clang_cc1 -triple armv7 -fsyntax-only -verify %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple armv7 -target-abi apcs-gnu -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/Sema/builtins-arm.c
    RUN("%clang_cc1 -triple armv7 -target-abi apcs-gnu -fsyntax-only -verify %s");
  }

  @Test
  public void test_builtins_arm_exclusive_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Sema/builtins-arm-exclusive.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple armv7 -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/Sema/builtins-arm-exclusive.c
    RUN("%clang_cc1 -triple armv7 -fsyntax-only -verify %s");
  }

  @Test
  public void test_builtins_arm_strex_rettype_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Sema/builtins-arm-strex-rettype.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple thumbv7m-apple-darwin-eabi -ast-dump ${LLVM_SRC}/llvm/tools/clang/test/Sema/builtins-arm-strex-rettype.c | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Sema/builtins-arm-strex-rettype.c
    RUN("%clang_cc1 -triple thumbv7m-apple-darwin-eabi -ast-dump %s")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_builtins_arm64_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Sema/builtins-arm64.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple arm64-apple-ios -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/Sema/builtins-arm64.c
    RUN("%clang_cc1 -triple arm64-apple-ios -fsyntax-only -verify %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple arm64-apple-ios -DTEST1 -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/Sema/builtins-arm64.c
    RUN("%clang_cc1 -triple arm64-apple-ios -DTEST1 -fsyntax-only -verify %s");
  }

  @Test
  public void test_builtins_arm64_exclusive_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Sema/builtins-arm64-exclusive.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple arm64-apple-ios7.0 -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/Sema/builtins-arm64-exclusive.c
    RUN("%clang_cc1 -triple arm64-apple-ios7.0 -fsyntax-only -verify %s");
  }

  @Test
  public void test_builtins_decl_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Sema/builtins-decl.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/Sema/builtins-decl.c -fsyntax-only -verify -triple=i686-mingw32
    RUN("%clang_cc1 %s -fsyntax-only -verify -triple=i686-mingw32");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/Sema/builtins-decl.c -fsyntax-only -verify -triple=x86_64-mingw32
    RUN("%clang_cc1 %s -fsyntax-only -verify -triple=x86_64-mingw32");
  }

  @Test
  public void test_builtins_gnu_mode_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Sema/builtins-gnu-mode.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -std=c99 ${LLVM_SRC}/llvm/tools/clang/test/Sema/builtins-gnu-mode.c
    RUN("%clang_cc1 -fsyntax-only -verify -std=c99 %s");
  }

  @Test
  public void test_builtins_overflow_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Sema/builtins-overflow.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/Sema/builtins-overflow.c
    RUN("%clang_cc1 -fsyntax-only -verify %s");
  }

  @Test
  public void test_builtins_ppc_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Sema/builtins-ppc.c");
    // REQUIRES: powerpc-registered-target
    if (!CHECK_REQUIRES("powerpc-registered-target")) {
      return;
    }
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -faltivec -target-feature +htm -triple powerpc64-unknown-unknown -DTEST_HTM -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/Sema/builtins-ppc.c
    RUN(TestState.Failed, "%clang_cc1 -faltivec -target-feature +htm -triple powerpc64-unknown-unknown -DTEST_HTM -fsyntax-only -verify %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -faltivec -target-feature +crypto -triple powerpc64le-unknown-unknown -DTEST_CRYPTO -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/Sema/builtins-ppc.c
    RUN(TestState.Failed, "%clang_cc1 -faltivec -target-feature +crypto -triple powerpc64le-unknown-unknown -DTEST_CRYPTO -fsyntax-only -verify %s");
  }

  @Test
  public void test_builtins_x86_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Sema/builtins-x86.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple=x86_64-apple-darwin -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/Sema/builtins-x86.c
    RUN("%clang_cc1 -triple=x86_64-apple-darwin -fsyntax-only -verify %s");
  }

  @Test
  public void test_c11_typedef_redef_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Sema/c11-typedef-redef.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c11 ${LLVM_SRC}/llvm/tools/clang/test/Sema/c11-typedef-redef.c -verify
    RUN("%clang_cc1 -std=c11 %s -verify");
  }

  @Test
  public void test_c89_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Sema/c89.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/Sema/c89.c -std=c89 -pedantic -fsyntax-only -verify -Wimplicit-function-declaration
    RUN("%clang_cc1 %s -std=c89 -pedantic -fsyntax-only -verify -Wimplicit-function-declaration");
  }

  @Test
  public void test_call_with_static_chain_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Sema/call-with-static-chain.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -fblocks -verify ${LLVM_SRC}/llvm/tools/clang/test/Sema/call-with-static-chain.c
    RUN("%clang_cc1 -fsyntax-only -fblocks -verify %s");
  }

  @Test
  public void test_callingconv_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Sema/callingconv.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/Sema/callingconv.c -fsyntax-only -triple i386-unknown-unknown -verify
    RUN("%clang_cc1 %s -fsyntax-only -triple i386-unknown-unknown -verify");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/Sema/callingconv.c -fsyntax-only -triple i386-unknown-unknown -fms-compatibility -DWIN -verify
    RUN("%clang_cc1 %s -fsyntax-only -triple i386-unknown-unknown -fms-compatibility -DWIN -verify");
  }

  @Test
  public void test_callingconv_cast_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Sema/callingconv-cast.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fms-extensions -triple i686-pc-windows-msvc -Wcast-calling-convention -DMSVC -Wno-pointer-bool-conversion -verify -x c ${LLVM_SRC}/llvm/tools/clang/test/Sema/callingconv-cast.c
    RUN("%clang_cc1 -fms-extensions -triple i686-pc-windows-msvc -Wcast-calling-convention -DMSVC -Wno-pointer-bool-conversion -verify -x c %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fms-extensions -triple i686-pc-windows-msvc -Wcast-calling-convention -DMSVC -Wno-pointer-bool-conversion -verify -x c++ ${LLVM_SRC}/llvm/tools/clang/test/Sema/callingconv-cast.c
    RUN("%clang_cc1 -fms-extensions -triple i686-pc-windows-msvc -Wcast-calling-convention -DMSVC -Wno-pointer-bool-conversion -verify -x c++ %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fms-extensions -triple i686-pc-windows-msvc -Wcast-calling-convention -DMSVC -fdiagnostics-parseable-fixits ${LLVM_SRC}/llvm/tools/clang/test/Sema/callingconv-cast.c 2>&1 | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Sema/callingconv-cast.c --check-prefix=MSFIXIT
    RUN("%clang_cc1 -fms-extensions -triple i686-pc-windows-msvc -Wcast-calling-convention -DMSVC -fdiagnostics-parseable-fixits %s 2>&1")./*|*/
      I("FileCheck %s --check-prefix=MSFIXIT");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i686-pc-windows-gnu -Wcast-calling-convention -fdiagnostics-parseable-fixits ${LLVM_SRC}/llvm/tools/clang/test/Sema/callingconv-cast.c 2>&1 | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Sema/callingconv-cast.c --check-prefix=GNUFIXIT
    RUN("%clang_cc1 -triple i686-pc-windows-gnu -Wcast-calling-convention -fdiagnostics-parseable-fixits %s 2>&1")./*|*/
      I("FileCheck %s --check-prefix=GNUFIXIT");
  }

  @Test
  public void test_callingconv_iamcu_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Sema/callingconv-iamcu.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/Sema/callingconv-iamcu.c -fsyntax-only -triple i686-intel-elfiamcu -verify
    RUN("%clang_cc1 %s -fsyntax-only -triple i686-intel-elfiamcu -verify");
  }

  @Test
  public void test_callingconv_ms_abi_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Sema/callingconv-ms_abi.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -triple x86_64-pc-win32 ${LLVM_SRC}/llvm/tools/clang/test/Sema/callingconv-ms_abi.c
    RUN("%clang_cc1 -fsyntax-only -verify -triple x86_64-pc-win32 %s");
  }

  @Test
  public void test_callingconv_sysv_abi_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Sema/callingconv-sysv_abi.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -triple x86_64-pc-linux-gnu ${LLVM_SRC}/llvm/tools/clang/test/Sema/callingconv-sysv_abi.c
    RUN("%clang_cc1 -fsyntax-only -verify -triple x86_64-pc-linux-gnu %s");
  }

  @Test
  public void test_captured_statements_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Sema/captured-statements.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/Sema/captured-statements.c -fblocks
    RUN("%clang_cc1 -fsyntax-only -verify %s -fblocks");
  }

  @Test
  public void test_cast_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Sema/cast.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -triple x86_64-unknown-unknown ${LLVM_SRC}/llvm/tools/clang/test/Sema/cast.c -verify
    RUN("%clang_cc1 -fsyntax-only -triple x86_64-unknown-unknown %s -verify");
  }

  @Test
  public void test_cast_incomplete_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Sema/cast-incomplete.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only ${LLVM_SRC}/llvm/tools/clang/test/Sema/cast-incomplete.c -verify
    RUN("%clang_cc1 -fsyntax-only %s -verify");
  }

  @Test
  public void test_cast_to_union_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Sema/cast-to-union.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -pedantic ${LLVM_SRC}/llvm/tools/clang/test/Sema/cast-to-union.c
    RUN("%clang_cc1 -fsyntax-only -verify -pedantic %s");
  }

  @Test
  public void test_check_increment_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Sema/check-increment.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/Sema/check-increment.c
    RUN("%clang_cc1 -fsyntax-only -verify %s");
  }

  @Test
  public void test_compare_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Sema/compare.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-apple-darwin -fsyntax-only -pedantic -verify -Wsign-compare ${LLVM_SRC}/llvm/tools/clang/test/Sema/compare.c -Wno-unreachable-code
    RUN("%clang_cc1 -triple x86_64-apple-darwin -fsyntax-only -pedantic -verify -Wsign-compare %s -Wno-unreachable-code");
  }

  @Test
  public void test_complex_imag_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Sema/complex-imag.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -verify ${LLVM_SRC}/llvm/tools/clang/test/Sema/complex-imag.c
    RUN("%clang_cc1 -verify %s");
  }

  @Test
  public void test_complex_init_list_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Sema/complex-init-list.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/Sema/complex-init-list.c -verify -fsyntax-only -pedantic
    RUN("%clang_cc1 %s -verify -fsyntax-only -pedantic");
  }

  @Test
  public void test_complex_int_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Sema/complex-int.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/Sema/complex-int.c -verify -fsyntax-only
    RUN("%clang_cc1 %s -verify -fsyntax-only");
  }

  @Test
  public void test_complex_promotion_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Sema/complex-promotion.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/Sema/complex-promotion.c -verify -fsyntax-only
    RUN("%clang_cc1 %s -verify -fsyntax-only");
  }

  @Test
  public void test_compound_literal_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Sema/compound-literal.c");
    // REQUIRES: LP64
    if (!CHECK_REQUIRES("LP64")) {
      return;
    }
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -pedantic ${LLVM_SRC}/llvm/tools/clang/test/Sema/compound-literal.c
    RUN(TestState.Failed, "%clang_cc1 -fsyntax-only -verify -pedantic %s");
  }

  @Test
  public void test_conditional_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Sema/conditional.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/Sema/conditional.c -fsyntax-only -verify
    RUN("%clang_cc1 %s -fsyntax-only -verify");
  }

  @Test
  public void test_conditional_expr_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Sema/conditional-expr.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -pedantic -Wsign-conversion ${LLVM_SRC}/llvm/tools/clang/test/Sema/conditional-expr.c
    RUN("%clang_cc1 -fsyntax-only -verify -pedantic -Wsign-conversion %s");
  }

  @Test
  public void test_const_eval_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Sema/const-eval.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -triple i686-linux ${LLVM_SRC}/llvm/tools/clang/test/Sema/const-eval.c -Wno-tautological-pointer-compare
    RUN("%clang_cc1 -fsyntax-only -verify -triple i686-linux %s -Wno-tautological-pointer-compare");
  }

  @Test
  public void test_const_eval_64_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Sema/const-eval-64.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -triple x86_64-linux ${LLVM_SRC}/llvm/tools/clang/test/Sema/const-eval-64.c
    RUN("%clang_cc1 -fsyntax-only -verify -triple x86_64-linux %s");
  }

  @Test
  public void test_const_ptr_int_ptr_cast_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Sema/const-ptr-int-ptr-cast.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -ffreestanding ${LLVM_SRC}/llvm/tools/clang/test/Sema/const-ptr-int-ptr-cast.c
    RUN("%clang_cc1 -fsyntax-only -verify -ffreestanding %s");
  }

  @Test
  public void test_constant_builtins_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Sema/constant-builtins.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only ${LLVM_SRC}/llvm/tools/clang/test/Sema/constant-builtins.c -verify -pedantic
    RUN("%clang_cc1 -fsyntax-only %s -verify -pedantic");
  }

  @Test
  public void test_constant_builtins_2_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Sema/constant-builtins-2.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/Sema/constant-builtins-2.c
    RUN("%clang_cc1 -fsyntax-only -verify %s");
  }

  @Test
  public void test_constant_conversion_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Sema/constant-conversion.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -triple x86_64-apple-darwin ${LLVM_SRC}/llvm/tools/clang/test/Sema/constant-conversion.c
    RUN("%clang_cc1 -fsyntax-only -verify -triple x86_64-apple-darwin %s");
  }

  @Test
  public void test_constructor_attribute_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Sema/constructor-attribute.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/Sema/constructor-attribute.c
    RUN("%clang_cc1 -fsyntax-only -verify %s");
  }

  @Test
  public void test_conversion_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Sema/conversion.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -Wconversion -nostdsysteminc -nobuiltininc -isystem ${LLVM_SRC}/llvm/tools/clang/test/Sema/Inputs -triple x86_64-apple-darwin ${LLVM_SRC}/llvm/tools/clang/test/Sema/conversion.c -Wno-unreachable-code
    RUN("%clang_cc1 -fsyntax-only -verify -Wconversion -nostdsysteminc -nobuiltininc -isystem %S/Inputs -triple x86_64-apple-darwin %s -Wno-unreachable-code");
  }

  @Test
  public void test_conversion_64_32_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Sema/conversion-64-32.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -Wshorten-64-to-32 -triple x86_64-apple-darwin ${LLVM_SRC}/llvm/tools/clang/test/Sema/conversion-64-32.c
    RUN("%clang_cc1 -fsyntax-only -verify -Wshorten-64-to-32 -triple x86_64-apple-darwin %s");
  }

  @Test
  public void test_convertvector_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Sema/convertvector.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/Sema/convertvector.c
    RUN("%clang_cc1 -fsyntax-only -verify %s");
  }

  @Test
  public void test_crash_invalid_array_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Sema/crash-invalid-array.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple=x86_64-apple-darwin -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/Sema/crash-invalid-array.c
    RUN("%clang_cc1 -triple=x86_64-apple-darwin -fsyntax-only -verify %s");
  }

  @Test
  public void test_crash_invalid_builtin_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Sema/crash-invalid-builtin.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple=x86_64-apple-darwin -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/Sema/crash-invalid-builtin.c
    RUN("%clang_cc1 -triple=x86_64-apple-darwin -fsyntax-only -verify %s");
  }

  @Test
  public void test_darwin_align_cast_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Sema/darwin-align-cast.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/Sema/darwin-align-cast.c
    RUN("%clang_cc1 -fsyntax-only -verify %s");
  }

  @Test
  public void test_darwin_tls_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Sema/darwin-tls.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -triple x86_64-apple-macosx10.6 ${LLVM_SRC}/llvm/tools/clang/test/Sema/darwin-tls.c 2>&1 | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Sema/darwin-tls.c --check-prefix NO-TLS
    RUN("not %clang_cc1 -fsyntax-only -triple x86_64-apple-macosx10.6 %s 2>&1")./*|*/
      I("FileCheck %s --check-prefix NO-TLS");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -triple x86_64-apple-macosx10.7 ${LLVM_SRC}/llvm/tools/clang/test/Sema/darwin-tls.c 2>&1 | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Sema/darwin-tls.c --check-prefix TLS
    RUN("%clang_cc1 -fsyntax-only -triple x86_64-apple-macosx10.7 %s 2>&1")./*|*/
      I("FileCheck %s --check-prefix TLS");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -triple arm64-apple-ios7.1 ${LLVM_SRC}/llvm/tools/clang/test/Sema/darwin-tls.c 2>&1 | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Sema/darwin-tls.c --check-prefix NO-TLS
    RUN("not %clang_cc1 -fsyntax-only -triple arm64-apple-ios7.1 %s 2>&1")./*|*/
      I("FileCheck %s --check-prefix NO-TLS");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -triple arm64-apple-ios8.0 ${LLVM_SRC}/llvm/tools/clang/test/Sema/darwin-tls.c 2>&1 | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Sema/darwin-tls.c --check-prefix TLS
    RUN("%clang_cc1 -fsyntax-only -triple arm64-apple-ios8.0 %s 2>&1")./*|*/
      I("FileCheck %s --check-prefix TLS");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -triple thumbv7s-apple-ios8.3 ${LLVM_SRC}/llvm/tools/clang/test/Sema/darwin-tls.c 2>&1 | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Sema/darwin-tls.c --check-prefix NO-TLS
    RUN("not %clang_cc1 -fsyntax-only -triple thumbv7s-apple-ios8.3 %s 2>&1")./*|*/
      I("FileCheck %s --check-prefix NO-TLS");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -triple thumbv7s-apple-ios9.0 ${LLVM_SRC}/llvm/tools/clang/test/Sema/darwin-tls.c 2>&1 | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Sema/darwin-tls.c --check-prefix TLS
    RUN("%clang_cc1 -fsyntax-only -triple thumbv7s-apple-ios9.0 %s 2>&1")./*|*/
      I("FileCheck %s --check-prefix TLS");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -triple armv7-apple-ios9.0 ${LLVM_SRC}/llvm/tools/clang/test/Sema/darwin-tls.c 2>&1 | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Sema/darwin-tls.c --check-prefix TLS
    RUN("%clang_cc1 -fsyntax-only -triple armv7-apple-ios9.0 %s 2>&1")./*|*/
      I("FileCheck %s --check-prefix TLS");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -triple thumbv7k-apple-watchos1.0 ${LLVM_SRC}/llvm/tools/clang/test/Sema/darwin-tls.c 2>&1 | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Sema/darwin-tls.c --check-prefix NO-TLS
    RUN("not %clang_cc1 -fsyntax-only -triple thumbv7k-apple-watchos1.0 %s 2>&1")./*|*/
      I("FileCheck %s --check-prefix NO-TLS");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -triple thumbv7k-apple-watchos2.0 ${LLVM_SRC}/llvm/tools/clang/test/Sema/darwin-tls.c 2>&1 | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Sema/darwin-tls.c --check-prefix TLS
    RUN("%clang_cc1 -fsyntax-only -triple thumbv7k-apple-watchos2.0 %s 2>&1")./*|*/
      I("FileCheck %s --check-prefix TLS");
  }

  @Test
  public void test_decl_in_prototype_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Sema/decl-in-prototype.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/Sema/decl-in-prototype.c
    RUN("%clang_cc1 -fsyntax-only -verify %s");
  }

  @Test
  public void test_decl_invalid_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Sema/decl-invalid.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/Sema/decl-invalid.c -fsyntax-only -verify
    RUN("%clang_cc1 %s -fsyntax-only -verify");
  }

  @Test
  public void test_decl_microsoft_call_conv_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Sema/decl-microsoft-call-conv.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i686-pc-win32 -verify ${LLVM_SRC}/llvm/tools/clang/test/Sema/decl-microsoft-call-conv.c
    RUN("%clang_cc1 -triple i686-pc-win32 -verify %s");
  }

  @Test
  public void test_decl_type_merging_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Sema/decl-type-merging.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -std=c99 -verify -pedantic ${LLVM_SRC}/llvm/tools/clang/test/Sema/decl-type-merging.c
    RUN("%clang_cc1 -fsyntax-only -std=c99 -verify -pedantic %s");
  }

  @Test
  public void test_declspec_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Sema/declspec.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/Sema/declspec.c -verify -fsyntax-only
    RUN("%clang_cc1 %s -verify -fsyntax-only");
  }

  @Test
  public void test_default_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Sema/default.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/Sema/default.c
    RUN("%clang_cc1 -fsyntax-only -verify %s");
  }

  @Test
  public void test_default1_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Sema/default1.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/Sema/default1.c
    RUN("%clang_cc1 -fsyntax-only -verify %s");
  }

  @Test
  public void test_deref_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Sema/deref.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -std=c90 -pedantic ${LLVM_SRC}/llvm/tools/clang/test/Sema/deref.c
    RUN("%clang_cc1 -fsyntax-only -verify -std=c90 -pedantic %s");
  }

  @Test
  public void test_designated_initializers_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Sema/designated-initializers.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -triple x86_64-unknown-unknown ${LLVM_SRC}/llvm/tools/clang/test/Sema/designated-initializers.c
    RUN("%clang_cc1 -fsyntax-only -verify -triple x86_64-unknown-unknown %s");
  }

  @Test
  public void test_dllexport_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Sema/dllexport.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i686-win32 -fsyntax-only -fms-extensions -verify -std=c99 ${LLVM_SRC}/llvm/tools/clang/test/Sema/dllexport.c
    RUN("%clang_cc1 -triple i686-win32     -fsyntax-only -fms-extensions -verify -std=c99 %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-win32 -fsyntax-only -fms-extensions -verify -std=c11 ${LLVM_SRC}/llvm/tools/clang/test/Sema/dllexport.c
    RUN("%clang_cc1 -triple x86_64-win32   -fsyntax-only -fms-extensions -verify -std=c11 %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i686-mingw32 -fsyntax-only -fms-extensions -verify -std=c11 ${LLVM_SRC}/llvm/tools/clang/test/Sema/dllexport.c
    RUN("%clang_cc1 -triple i686-mingw32   -fsyntax-only -fms-extensions -verify -std=c11 %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-mingw32 -fsyntax-only -fms-extensions -verify -std=c99 ${LLVM_SRC}/llvm/tools/clang/test/Sema/dllexport.c
    RUN("%clang_cc1 -triple x86_64-mingw32 -fsyntax-only -fms-extensions -verify -std=c99 %s");
  }

  @Test
  public void test_dllimport_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Sema/dllimport.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i686-win32 -fsyntax-only -fms-extensions -verify -std=c99 -DMS ${LLVM_SRC}/llvm/tools/clang/test/Sema/dllimport.c
    RUN("%clang_cc1 -triple i686-win32     -fsyntax-only -fms-extensions -verify -std=c99 -DMS %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-win32 -fsyntax-only -fms-extensions -verify -std=c11 -DMS ${LLVM_SRC}/llvm/tools/clang/test/Sema/dllimport.c
    RUN("%clang_cc1 -triple x86_64-win32   -fsyntax-only -fms-extensions -verify -std=c11 -DMS %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i686-mingw32 -fsyntax-only -fms-extensions -verify -std=c11 -DGNU ${LLVM_SRC}/llvm/tools/clang/test/Sema/dllimport.c
    RUN("%clang_cc1 -triple i686-mingw32   -fsyntax-only -fms-extensions -verify -std=c11 -DGNU %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-mingw32 -fsyntax-only -fms-extensions -verify -std=c99 -DGNU ${LLVM_SRC}/llvm/tools/clang/test/Sema/dllimport.c
    RUN("%clang_cc1 -triple x86_64-mingw32 -fsyntax-only -fms-extensions -verify -std=c99 -DGNU %s");
  }

  @Test
  public void test_empty1_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Sema/empty1.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/Sema/empty1.c -triple i386-pc-solaris2.11 -fsyntax-only -verify -Wc++-compat
    RUN("%clang_cc1 %s -triple %itanium_abi_triple -fsyntax-only -verify -Wc++-compat");
  }

  @Test
  public void test_empty2_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Sema/empty2.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/Sema/empty2.c -fsyntax-only -verify -pedantic
    RUN("%clang_cc1 %s -fsyntax-only -verify -pedantic");
  }

  @Test
  public void test_enable_if_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Sema/enable_if.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/Sema/enable_if.c -verify
    RUN("%clang_cc1 %s -verify");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/Sema/enable_if.c -DCODEGEN -emit-llvm -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Sema/enable_if.c
    RUN(TestState.Failed, "%clang_cc1 %s -DCODEGEN -emit-llvm -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_enable_if_ext_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Sema/enable_if-ext.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only ${LLVM_SRC}/llvm/tools/clang/test/Sema/enable_if-ext.c -include ${LLVM_SRC}/llvm/tools/clang/test/Sema/enable_if-ext.c -verify
    RUN("%clang_cc1 -fsyntax-only %s -include %s -verify");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -Wpedantic -fsyntax-only ${LLVM_SRC}/llvm/tools/clang/test/Sema/enable_if-ext.c -include ${LLVM_SRC}/llvm/tools/clang/test/Sema/enable_if-ext.c -verify -DWARN_PEDANTIC
    RUN("%clang_cc1 -Wpedantic -fsyntax-only %s -include %s -verify -DWARN_PEDANTIC");
  }

  @Test
  public void test_enum_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Sema/enum.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i386-pc-solaris2.11 ${LLVM_SRC}/llvm/tools/clang/test/Sema/enum.c -fsyntax-only -verify -pedantic
    RUN("%clang_cc1 -triple %itanium_abi_triple %s -fsyntax-only -verify -pedantic");
  }

  @Test
  public void test_enum_increment_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Sema/enum-increment.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only ${LLVM_SRC}/llvm/tools/clang/test/Sema/enum-increment.c -verify
    RUN("%clang_cc1 -fsyntax-only %s -verify");
  }

  @Test
  public void test_enum_packed_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Sema/enum-packed.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/Sema/enum-packed.c
    RUN("%clang_cc1 -fsyntax-only -verify %s");
  }

  @Test
  public void test_expr_address_of_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Sema/expr-address-of.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/Sema/expr-address-of.c -verify -fsyntax-only
    RUN("%clang_cc1 %s -verify -fsyntax-only");
  }

  @Test
  public void test_expr_comma_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Sema/expr-comma.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/Sema/expr-comma.c -fsyntax-only -verify -std=c89 -Wno-sizeof-array-decay
    RUN("%clang_cc1 %s -fsyntax-only -verify -std=c89 -Wno-sizeof-array-decay");
  }

  @Test
  public void test_expr_comma_c99_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Sema/expr-comma-c99.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/Sema/expr-comma-c99.c -fsyntax-only -verify -std=c99 -Wno-sizeof-array-decay
    RUN("%clang_cc1 %s -fsyntax-only -verify -std=c99 -Wno-sizeof-array-decay");
  }

  @Test
  public void test_exprs_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Sema/exprs.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/Sema/exprs.c -verify -pedantic -fsyntax-only
    RUN("%clang_cc1 %s -verify -pedantic -fsyntax-only");
  }

  @Test
  public void test_ext_vector_casts_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Sema/ext_vector_casts.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-apple-macos10.7.0 -fsyntax-only -verify -fno-lax-vector-conversions -Wconversion ${LLVM_SRC}/llvm/tools/clang/test/Sema/ext_vector_casts.c
    RUN("%clang_cc1 -triple x86_64-apple-macos10.7.0 -fsyntax-only -verify -fno-lax-vector-conversions -Wconversion %s");
  }

  @Test
  public void test_ext_vector_comparisons_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Sema/ext_vector_comparisons.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -Wno-unreachable-code ${LLVM_SRC}/llvm/tools/clang/test/Sema/ext_vector_comparisons.c
    RUN("%clang_cc1 -fsyntax-only -verify -Wno-unreachable-code %s");
  }

  @Test
  public void test_ext_vector_components_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Sema/ext_vector_components.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/Sema/ext_vector_components.c
    RUN("%clang_cc1 -fsyntax-only -verify %s");
  }

  @Test
  public void test_ext_vector_conversions_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Sema/ext_vector_conversions.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-apple-macos10.7.0 -fsyntax-only -verify -Wconversion ${LLVM_SRC}/llvm/tools/clang/test/Sema/ext_vector_conversions.c
    RUN("%clang_cc1 -triple x86_64-apple-macos10.7.0 -fsyntax-only -verify -Wconversion %s");
  }

  @Test
  public void test_extern_redecl_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Sema/extern-redecl.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/Sema/extern-redecl.c
    RUN("%clang_cc1 -fsyntax-only -verify %s");
  }

  @Test
  public void test_flexible_array_init_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Sema/flexible-array-init.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -pedantic -verify ${LLVM_SRC}/llvm/tools/clang/test/Sema/flexible-array-init.c
    RUN("%clang_cc1 -fsyntax-only -pedantic -verify %s");
  }

  @Test
  public void test_float128_ld_incompatibility_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Sema/float128-ld-incompatibility.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -std=c++11 -triple powerpc64le-unknown-linux-gnu -target-cpu pwr8 -target-feature +float128 ${LLVM_SRC}/llvm/tools/clang/test/Sema/float128-ld-incompatibility.cpp
    RUN("%clang_cc1 -fsyntax-only -verify -std=c++11 -triple powerpc64le-unknown-linux-gnu -target-cpu pwr8 -target-feature +float128 %s");
  }

  @Test
  public void test_floating_point_compare_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Sema/floating-point-compare.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -Wfloat-equal -verify ${LLVM_SRC}/llvm/tools/clang/test/Sema/floating-point-compare.c
    RUN("%clang_cc1 -fsyntax-only -Wfloat-equal -verify %s");
  }

  @Test
  public void test_fn_ptr_as_fn_prototype_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Sema/fn-ptr-as-fn-prototype.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -ast-print ${LLVM_SRC}/llvm/tools/clang/test/Sema/fn-ptr-as-fn-prototype.c | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Sema/fn-ptr-as-fn-prototype.c
    RUN("%clang_cc1 -ast-print %s")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_for_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Sema/for.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/Sema/for.c
    RUN("%clang_cc1 -fsyntax-only -verify %s");
  }

  @Test
  public void test_format_string_percentm_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Sema/format-string-percentm.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/Sema/format-string-percentm.c -triple i686-pc-linux-gnu
    RUN("%clang_cc1 -fsyntax-only -verify %s -triple i686-pc-linux-gnu");
  }

  @Test
  public void test_format_strings_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Sema/format-strings.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -Wformat-nonliteral -isystem ${LLVM_SRC}/llvm/tools/clang/test/Sema/Inputs ${LLVM_SRC}/llvm/tools/clang/test/Sema/format-strings.c
    RUN("%clang_cc1 -fsyntax-only -verify -Wformat-nonliteral -isystem %S/Inputs %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -Wformat-nonliteral -isystem ${LLVM_SRC}/llvm/tools/clang/test/Sema/Inputs -fno-signed-char ${LLVM_SRC}/llvm/tools/clang/test/Sema/format-strings.c
    RUN("%clang_cc1 -fsyntax-only -verify -Wformat-nonliteral -isystem %S/Inputs -fno-signed-char %s");
  }

  @Test
  public void test_format_strings_c90_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Sema/format-strings-c90.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -triple i386-apple-darwin9 -Wformat-non-iso -std=c89 ${LLVM_SRC}/llvm/tools/clang/test/Sema/format-strings-c90.c
    RUN("%clang_cc1 -fsyntax-only -verify -triple i386-apple-darwin9 -Wformat-non-iso -std=c89 %s");
  }

  @Test
  public void test_format_strings_darwin_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Sema/format-strings-darwin.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -triple i386-apple-darwin9 -Wformat-non-iso -DALLOWED ${LLVM_SRC}/llvm/tools/clang/test/Sema/format-strings-darwin.c
    RUN("%clang_cc1 -fsyntax-only -verify -triple i386-apple-darwin9 -Wformat-non-iso -DALLOWED %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -triple thumbv6-apple-ios4.0 -Wformat-non-iso -DALLOWED ${LLVM_SRC}/llvm/tools/clang/test/Sema/format-strings-darwin.c
    RUN("%clang_cc1 -fsyntax-only -verify -triple thumbv6-apple-ios4.0 -Wformat-non-iso -DALLOWED %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -triple x86_64-mingw32 -Wformat-non-iso ${LLVM_SRC}/llvm/tools/clang/test/Sema/format-strings-darwin.c
    RUN("%clang_cc1 -fsyntax-only -verify -triple x86_64-mingw32 -Wformat-non-iso %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -triple i686-pc-win32 -Wformat-non-iso ${LLVM_SRC}/llvm/tools/clang/test/Sema/format-strings-darwin.c
    RUN("%clang_cc1 -fsyntax-only -verify -triple i686-pc-win32 -Wformat-non-iso %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -triple i686-linux-gnu -Wformat-non-iso ${LLVM_SRC}/llvm/tools/clang/test/Sema/format-strings-darwin.c
    RUN("%clang_cc1 -fsyntax-only -verify -triple i686-linux-gnu -Wformat-non-iso %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -triple x86_64-unknown-freebsd -Wformat-non-iso ${LLVM_SRC}/llvm/tools/clang/test/Sema/format-strings-darwin.c
    RUN("%clang_cc1 -fsyntax-only -verify -triple x86_64-unknown-freebsd -Wformat-non-iso %s");
  }

  @Test
  public void test_format_strings_enum_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Sema/format-strings-enum.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-apple-darwin10 -verify ${LLVM_SRC}/llvm/tools/clang/test/Sema/format-strings-enum.c
    RUN("%clang_cc1 -triple x86_64-apple-darwin10 -verify %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-apple-darwin10 -x c++ -verify ${LLVM_SRC}/llvm/tools/clang/test/Sema/format-strings-enum.c
    RUN("%clang_cc1 -triple x86_64-apple-darwin10 -x c++ -verify %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-apple-darwin10 -x c++ -std=c++11 -verify ${LLVM_SRC}/llvm/tools/clang/test/Sema/format-strings-enum.c
    RUN("%clang_cc1 -triple x86_64-apple-darwin10 -x c++ -std=c++11 -verify %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-apple-darwin10 -x objective-c -verify ${LLVM_SRC}/llvm/tools/clang/test/Sema/format-strings-enum.c
    RUN("%clang_cc1 -triple x86_64-apple-darwin10 -x objective-c -verify %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-apple-darwin10 -x objective-c++ -std=c++11 -verify ${LLVM_SRC}/llvm/tools/clang/test/Sema/format-strings-enum.c
    RUN("%clang_cc1 -triple x86_64-apple-darwin10 -x objective-c++ -std=c++11 -verify %s");
  }

  @Test
  public void test_format_strings_enum_fixed_type_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Sema/format-strings-enum-fixed-type.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i386-apple-darwin9 -x c++ -std=c++11 -verify ${LLVM_SRC}/llvm/tools/clang/test/Sema/format-strings-enum-fixed-type.cpp
    RUN("%clang_cc1 -triple i386-apple-darwin9 -x c++ -std=c++11 -verify %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i386-apple-darwin9 -x objective-c -verify ${LLVM_SRC}/llvm/tools/clang/test/Sema/format-strings-enum-fixed-type.cpp
    RUN("%clang_cc1 -triple i386-apple-darwin9 -x objective-c -verify %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i386-apple-darwin9 -x objective-c++ -verify ${LLVM_SRC}/llvm/tools/clang/test/Sema/format-strings-enum-fixed-type.cpp
    RUN("%clang_cc1 -triple i386-apple-darwin9 -x objective-c++ -verify %s");
  }

  @Test
  public void test_format_strings_fixit_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Sema/format-strings-fixit.c");
    // cp ${LLVM_SRC}/llvm/tools/clang/test/Sema/format-strings-fixit.c ${TEST_TEMP_DIR}/format-strings-fixit.c.tmp
    RUN("cp %s %t");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -pedantic -Wall -fixit ${TEST_TEMP_DIR}/format-strings-fixit.c.tmp
    RUN("%clang_cc1 -pedantic -Wall -fixit %t");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -pedantic -Wall -Werror ${TEST_TEMP_DIR}/format-strings-fixit.c.tmp
    RUN("%clang_cc1 -fsyntax-only -pedantic -Wall -Werror %t");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -E -o - ${TEST_TEMP_DIR}/format-strings-fixit.c.tmp | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Sema/format-strings-fixit.c
    RUN("%clang_cc1 -E -o - %t")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_format_strings_fixit_ssize_t_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Sema/format-strings-fixit-ssize_t.c");
    // cp ${LLVM_SRC}/llvm/tools/clang/test/Sema/format-strings-fixit-ssize_t.c ${TEST_TEMP_DIR}/format-strings-fixit-ssize_t.c.tmp
    RUN("cp %s %t");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-apple-darwin10 -pedantic -Wall -fixit ${TEST_TEMP_DIR}/format-strings-fixit-ssize_t.c.tmp
    RUN("%clang_cc1 -triple x86_64-apple-darwin10 -pedantic -Wall -fixit %t");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-apple-darwin10 -fsyntax-only -pedantic -Wall -Werror ${TEST_TEMP_DIR}/format-strings-fixit-ssize_t.c.tmp
    RUN("%clang_cc1 -triple x86_64-apple-darwin10 -fsyntax-only -pedantic -Wall -Werror %t");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-apple-darwin10 -E -o - ${TEST_TEMP_DIR}/format-strings-fixit-ssize_t.c.tmp | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Sema/format-strings-fixit-ssize_t.c
    RUN("%clang_cc1 -triple x86_64-apple-darwin10 -E -o - %t")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_format_strings_freebsd_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Sema/format-strings-freebsd.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -triple i386-unknown-freebsd ${LLVM_SRC}/llvm/tools/clang/test/Sema/format-strings-freebsd.c
    RUN("%clang_cc1 -fsyntax-only -verify -triple i386-unknown-freebsd %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -triple x86_64-unknown-freebsd ${LLVM_SRC}/llvm/tools/clang/test/Sema/format-strings-freebsd.c
    RUN("%clang_cc1 -fsyntax-only -verify -triple x86_64-unknown-freebsd %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -triple x86_64-scei-ps4 ${LLVM_SRC}/llvm/tools/clang/test/Sema/format-strings-freebsd.c
    RUN("%clang_cc1 -fsyntax-only -verify -triple x86_64-scei-ps4 %s");
  }

  @Test
  public void test_format_strings_gnu_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Sema/format-strings-gnu.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -triple i386-apple-darwin9 ${LLVM_SRC}/llvm/tools/clang/test/Sema/format-strings-gnu.c
    RUN("%clang_cc1 -fsyntax-only -verify -triple i386-apple-darwin9 %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -triple thumbv6-apple-ios4.0 ${LLVM_SRC}/llvm/tools/clang/test/Sema/format-strings-gnu.c
    RUN("%clang_cc1 -fsyntax-only -verify -triple thumbv6-apple-ios4.0 %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -triple x86_64-mingw32 -DMS ${LLVM_SRC}/llvm/tools/clang/test/Sema/format-strings-gnu.c
    RUN("%clang_cc1 -fsyntax-only -verify -triple x86_64-mingw32 -DMS %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -triple i686-pc-win32 -DMS ${LLVM_SRC}/llvm/tools/clang/test/Sema/format-strings-gnu.c
    RUN("%clang_cc1 -fsyntax-only -verify -triple i686-pc-win32 -DMS %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -triple i686-linux-gnu -DALLOWED ${LLVM_SRC}/llvm/tools/clang/test/Sema/format-strings-gnu.c
    RUN("%clang_cc1 -fsyntax-only -verify -triple i686-linux-gnu -DALLOWED %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -triple x86_64-unknown-freebsd -DALLOWED ${LLVM_SRC}/llvm/tools/clang/test/Sema/format-strings-gnu.c
    RUN("%clang_cc1 -fsyntax-only -verify -triple x86_64-unknown-freebsd -DALLOWED %s");
  }

  @Test
  public void test_format_strings_int_typedefs_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Sema/format-strings-int-typedefs.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i386-apple-darwin9 -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/Sema/format-strings-int-typedefs.c
    RUN("%clang_cc1 -triple i386-apple-darwin9 -fsyntax-only -verify %s");
  }

  @Test
  public void test_format_strings_ms_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Sema/format-strings-ms.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -fms-compatibility -triple=i386-pc-win32 ${LLVM_SRC}/llvm/tools/clang/test/Sema/format-strings-ms.c
    RUN("%clang_cc1 -fsyntax-only -verify -fms-compatibility -triple=i386-pc-win32 %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -fms-compatibility -triple=i386-pc-win32 -Wformat-non-iso -DNON_ISO_WARNING ${LLVM_SRC}/llvm/tools/clang/test/Sema/format-strings-ms.c
    RUN("%clang_cc1 -fsyntax-only -verify -fms-compatibility -triple=i386-pc-win32 -Wformat-non-iso -DNON_ISO_WARNING %s");
  }

  @Test
  public void test_format_strings_no_fixit_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Sema/format-strings-no-fixit.c");
    // cp ${LLVM_SRC}/llvm/tools/clang/test/Sema/format-strings-no-fixit.c ${TEST_TEMP_DIR}/format-strings-no-fixit.c.tmp
    RUN("cp %s %t");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -fixit ${TEST_TEMP_DIR}/format-strings-no-fixit.c.tmp
    RUN("%clang_cc1 -fsyntax-only -fixit %t");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -E -o - ${TEST_TEMP_DIR}/format-strings-no-fixit.c.tmp | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Sema/format-strings-no-fixit.c
    RUN("%clang_cc1 -E -o - %t")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_format_strings_non_iso_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Sema/format-strings-non-iso.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i686-linux-gnu -fsyntax-only -verify -std=c99 -Wformat-non-iso ${LLVM_SRC}/llvm/tools/clang/test/Sema/format-strings-non-iso.c
    RUN("%clang_cc1 -triple i686-linux-gnu -fsyntax-only -verify -std=c99 -Wformat-non-iso %s");
  }

  @Test
  public void test_format_strings_scanf_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Sema/format-strings-scanf.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -Wformat-nonliteral ${LLVM_SRC}/llvm/tools/clang/test/Sema/format-strings-scanf.c
    RUN("%clang_cc1 -fsyntax-only -verify -Wformat-nonliteral %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -Werror -Wformat=0 ${LLVM_SRC}/llvm/tools/clang/test/Sema/format-strings-scanf.c
    RUN("%clang_cc1 -fsyntax-only -Werror -Wformat=0 %s");
  }

  @Test
  public void test_format_strings_size_t_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Sema/format-strings-size_t.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-apple-darwin10 -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/Sema/format-strings-size_t.c
    RUN("%clang_cc1 -triple x86_64-apple-darwin10 -fsyntax-only -verify %s");
  }

  @Test
  public void test_fp16_sema_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Sema/fp16-sema.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/Sema/fp16-sema.c
    RUN("%clang_cc1 -fsyntax-only -verify %s");
  }

  @Test
  public void test_fpack_struct_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Sema/fpack-struct.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -DEXPECTED_STRUCT_SIZE=5 -fpack-struct=1 ${LLVM_SRC}/llvm/tools/clang/test/Sema/fpack-struct.c
    RUN("%clang_cc1 -DEXPECTED_STRUCT_SIZE=5 -fpack-struct=1 %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -DEXPECTED_STRUCT_SIZE=6 -fpack-struct=2 ${LLVM_SRC}/llvm/tools/clang/test/Sema/fpack-struct.c
    RUN("%clang_cc1 -DEXPECTED_STRUCT_SIZE=6 -fpack-struct=2 %s");
  }

  @Test
  public void test_freemain_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Sema/freemain.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i686-pc-openbsd -fsyntax-only -verify -ffreestanding ${LLVM_SRC}/llvm/tools/clang/test/Sema/freemain.c
    RUN("%clang_cc1 -triple i686-pc-openbsd -fsyntax-only -verify -ffreestanding %s");
  }

  @Test
  public void test_function_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Sema/function.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/Sema/function.c -fsyntax-only -verify -pedantic
    RUN("%clang_cc1 %s -fsyntax-only -verify -pedantic");
  }

  @Test
  public void test_function_ptr_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Sema/function-ptr.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/Sema/function-ptr.c -verify -pedantic
    RUN("%clang_cc1 %s -verify -pedantic");
  }

  @Test
  public void test_function_redecl_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Sema/function-redecl.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i386-pc-solaris2.11 -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/Sema/function-redecl.c
    RUN("%clang_cc1 -triple %itanium_abi_triple -fsyntax-only -verify %s");
  }

  @Test
  public void test_generic_selection_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Sema/generic-selection.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c1x -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/Sema/generic-selection.c
    RUN("%clang_cc1 -std=c1x -fsyntax-only -verify %s");
  }

  @Test
  public void test_gnu_attributes_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Sema/gnu-attributes.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/Sema/gnu-attributes.c
    RUN("%clang_cc1 -fsyntax-only -verify %s");
  }

  @Test
  public void test_gnu_flags_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Sema/gnu-flags.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/Sema/gnu-flags.c -DNONE -Wno-gnu
    RUN("%clang_cc1 -fsyntax-only -verify %s -DNONE -Wno-gnu");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/Sema/gnu-flags.c -DALL -Wgnu
    RUN("%clang_cc1 -fsyntax-only -verify %s -DALL -Wgnu");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/Sema/gnu-flags.c -DALL -Wno-gnu -Wgnu-alignof-expression -Wgnu-case-range -Wgnu-complex-integer -Wgnu-conditional-omitted-operand -Wgnu-empty-initializer -Wgnu-label-as-value -Wgnu-statement-expression -Wgnu-compound-literal-initializer -Wgnu-flexible-array-initializer -Wgnu-redeclared-enum -Wgnu-folding-constant -Wgnu-empty-struct -Wgnu-union-cast -Wgnu-variable-sized-type-not-at-end
    RUN("%clang_cc1 -fsyntax-only -verify %s -DALL -Wno-gnu -Wgnu-alignof-expression -Wgnu-case-range -Wgnu-complex-integer -Wgnu-conditional-omitted-operand -Wgnu-empty-initializer -Wgnu-label-as-value -Wgnu-statement-expression -Wgnu-compound-literal-initializer -Wgnu-flexible-array-initializer -Wgnu-redeclared-enum  -Wgnu-folding-constant -Wgnu-empty-struct -Wgnu-union-cast -Wgnu-variable-sized-type-not-at-end");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/Sema/gnu-flags.c -DNONE -Wgnu -Wno-gnu-alignof-expression -Wno-gnu-case-range -Wno-gnu-complex-integer -Wno-gnu-conditional-omitted-operand -Wno-gnu-empty-initializer -Wno-gnu-label-as-value -Wno-gnu-statement-expression -Wno-gnu-compound-literal-initializer -Wno-gnu-flexible-array-initializer -Wno-gnu-redeclared-enum -Wno-gnu-folding-constant -Wno-gnu-empty-struct -Wno-gnu-union-cast -Wno-gnu-variable-sized-type-not-at-end
    RUN("%clang_cc1 -fsyntax-only -verify %s -DNONE -Wgnu -Wno-gnu-alignof-expression -Wno-gnu-case-range -Wno-gnu-complex-integer -Wno-gnu-conditional-omitted-operand -Wno-gnu-empty-initializer -Wno-gnu-label-as-value -Wno-gnu-statement-expression -Wno-gnu-compound-literal-initializer -Wno-gnu-flexible-array-initializer -Wno-gnu-redeclared-enum -Wno-gnu-folding-constant -Wno-gnu-empty-struct -Wno-gnu-union-cast -Wno-gnu-variable-sized-type-not-at-end");
  }

  @Test
  public void test_gnu89_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Sema/gnu89.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/Sema/gnu89.c -std=gnu89 -pedantic -fsyntax-only -verify
    RUN("%clang_cc1 %s -std=gnu89 -pedantic -fsyntax-only -verify");
  }

  @Test
  public void test_heinous_extensions_off_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Sema/heinous-extensions-off.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/Sema/heinous-extensions-off.c -verify
    RUN("%clang_cc1 %s -verify");
  }

  @Test
  public void test_heinous_extensions_on_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Sema/heinous-extensions-on.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/Sema/heinous-extensions-on.c -verify -fheinous-gnu-extensions
    RUN("%clang_cc1 %s -verify -fheinous-gnu-extensions");
  }

  @Test
  public void test_i_c_e_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Sema/i-c-e.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/Sema/i-c-e.c -ffreestanding -Wno-int-to-pointer-cast -fsyntax-only -verify -pedantic -fpascal-strings -std=c99
    RUN("%clang_cc1 %s -ffreestanding -Wno-int-to-pointer-cast -fsyntax-only -verify -pedantic -fpascal-strings -std=c99");
  }

  @Test
  public void test_i386_linux_android_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Sema/i386-linux-android.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i386-linux-android -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/Sema/i386-linux-android.c
    RUN("%clang_cc1 -triple i386-linux-android -fsyntax-only -verify %s");
  }

  @Test
  public void test_illegal_types_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Sema/illegal-types.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -x c++ -std=c++98 ${LLVM_SRC}/llvm/tools/clang/test/Sema/illegal-types.c
    RUN("%clang_cc1 -fsyntax-only -verify -x c++ -std=c++98 %s");
  }

  @Test
  public void test_implicit_builtin_decl_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Sema/implicit-builtin-decl.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/Sema/implicit-builtin-decl.c
    RUN("%clang_cc1 -fsyntax-only -verify %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -ast-dump ${LLVM_SRC}/llvm/tools/clang/test/Sema/implicit-builtin-decl.c | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Sema/implicit-builtin-decl.c
    RUN("not %clang_cc1 -fsyntax-only -ast-dump %s")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_implicit_builtin_freestanding_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Sema/implicit-builtin-freestanding.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -ffreestanding ${LLVM_SRC}/llvm/tools/clang/test/Sema/implicit-builtin-freestanding.c
    RUN("%clang_cc1 -fsyntax-only -verify -ffreestanding %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -fno-builtin ${LLVM_SRC}/llvm/tools/clang/test/Sema/implicit-builtin-freestanding.c
    RUN("%clang_cc1 -fsyntax-only -verify -fno-builtin %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -fno-builtin-malloc ${LLVM_SRC}/llvm/tools/clang/test/Sema/implicit-builtin-freestanding.c
    RUN("%clang_cc1 -fsyntax-only -verify -fno-builtin-malloc %s");
  }

  @Test
  public void test_implicit_builtin_redecl_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Sema/implicit-builtin-redecl.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/Sema/implicit-builtin-redecl.c
    RUN("%clang_cc1 -fsyntax-only -verify %s");
  }

  @Test
  public void test_implicit_cast_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Sema/implicit-cast.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only ${LLVM_SRC}/llvm/tools/clang/test/Sema/implicit-cast.c
    RUN("%clang_cc1 -fsyntax-only %s");
  }

  @Test
  public void test_implicit_cast_dump_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Sema/implicit-cast-dump.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -ast-dump ${LLVM_SRC}/llvm/tools/clang/test/Sema/implicit-cast-dump.c | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Sema/implicit-cast-dump.c
    RUN("%clang_cc1 -ast-dump %s")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_implicit_decl_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Sema/implicit-decl.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/Sema/implicit-decl.c -verify -fsyntax-only -Werror
    RUN("%clang_cc1 %s -verify -fsyntax-only -Werror");
  }

  @Test
  public void test_implicit_def_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Sema/implicit-def.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only ${LLVM_SRC}/llvm/tools/clang/test/Sema/implicit-def.c -std=c89
    RUN("%clang_cc1 -fsyntax-only %s -std=c89");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only ${LLVM_SRC}/llvm/tools/clang/test/Sema/implicit-def.c -std=c99 -pedantic-errors
    RUN("not %clang_cc1 -fsyntax-only %s -std=c99 -pedantic-errors");
  }

  @Test
  public void test_implicit_int_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Sema/implicit-int.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only ${LLVM_SRC}/llvm/tools/clang/test/Sema/implicit-int.c -verify -pedantic
    RUN("%clang_cc1 -fsyntax-only %s -verify -pedantic");
  }

  @Test
  public void test_incompatible_sign_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Sema/incompatible-sign.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/Sema/incompatible-sign.c -verify -fsyntax-only
    RUN("%clang_cc1 %s -verify -fsyntax-only");
  }

  @Test
  public void test_incomplete_call_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Sema/incomplete-call.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/Sema/incomplete-call.c
    RUN("%clang_cc1 -fsyntax-only -verify %s");
  }

  @Test
  public void test_incomplete_decl_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Sema/incomplete-decl.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/Sema/incomplete-decl.c
    RUN("%clang_cc1 -fsyntax-only -verify %s");
  }

  @Test
  public void test_indirect_goto_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Sema/indirect-goto.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/Sema/indirect-goto.c
    RUN("%clang_cc1 -fsyntax-only -verify %s");
  }

  @Test
  public void test_init_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Sema/init.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/Sema/init.c -verify -fsyntax-only -ffreestanding
    RUN(TestState.Failed, "%clang_cc1 %s -verify -fsyntax-only -ffreestanding");
  }

  @Test
  public void test_init_struct_qualified_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Sema/init-struct-qualified.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify < ${LLVM_SRC}/llvm/tools/clang/test/Sema/init-struct-qualified.c
    RUN("%clang_cc1 -fsyntax-only -verify < %s");
  }

  @Test
  public void test_init_vector_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Sema/init-vector.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/Sema/init-vector.c
    RUN("%clang_cc1 -fsyntax-only -verify %s");
  }

  @Test
  public void test_initialize_noreturn_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Sema/initialize-noreturn.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/Sema/initialize-noreturn.c -fsyntax-only -verify
    RUN("%clang_cc1 %s -fsyntax-only -verify");
  }

  @Test
  public void test_inline_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Sema/inline.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i386-pc-solaris2.11 -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/Sema/inline.c
    RUN("%clang_cc1 -triple %itanium_abi_triple -fsyntax-only -verify %s");
  }

  @Test
  public void test_inline_asm_validate_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Sema/inline-asm-validate.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple arm64-apple-macosx10.8.0 -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/Sema/inline-asm-validate.c
    RUN("%clang_cc1 -triple arm64-apple-macosx10.8.0 -fsyntax-only -verify %s");
  }

  @Test
  public void test_inline_asm_validate_aarch64_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Sema/inline-asm-validate-aarch64.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple arm64-apple-darwin -fsyntax-only -fdiagnostics-parseable-fixits ${LLVM_SRC}/llvm/tools/clang/test/Sema/inline-asm-validate-aarch64.c 2>&1 | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Sema/inline-asm-validate-aarch64.c
    RUN("%clang_cc1 -triple arm64-apple-darwin -fsyntax-only -fdiagnostics-parseable-fixits %s 2>&1")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_inline_asm_validate_amdgpu_cl() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Sema/inline-asm-validate-amdgpu.cl");
    // REQUIRES: amdgpu-registered-target
    if (!CHECK_REQUIRES("amdgpu-registered-target")) {
      return;
    }
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x cl -triple amdgcn -fsyntax-only ${LLVM_SRC}/llvm/tools/clang/test/Sema/inline-asm-validate-amdgpu.cl
    RUN(TestState.Failed, "%clang_cc1 -x cl -triple amdgcn -fsyntax-only  %s");
  }

  @Test
  public void test_inline_asm_validate_tmpl_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Sema/inline-asm-validate-tmpl.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i686 -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/Sema/inline-asm-validate-tmpl.cpp
    RUN("%clang_cc1 -triple i686 -fsyntax-only -verify %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64 -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/Sema/inline-asm-validate-tmpl.cpp
    RUN("%clang_cc1 -triple x86_64 -fsyntax-only -verify %s");
  }

  @Test
  public void test_inline_asm_validate_x86_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Sema/inline-asm-validate-x86.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i686 -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/Sema/inline-asm-validate-x86.c
    RUN("%clang_cc1 -triple i686 -fsyntax-only -verify %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64 -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/Sema/inline-asm-validate-x86.c
    RUN("%clang_cc1 -triple x86_64 -fsyntax-only -verify %s");
  }

  @Test
  public void test_inline_redef_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Sema/inline-redef.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=gnu89 -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/Sema/inline-redef.c
    RUN("%clang_cc1 -std=gnu89 -fsyntax-only -verify %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/Sema/inline-redef.c
    RUN("%clang_cc1 -fsyntax-only -verify %s");
  }

  @Test
  public void test_int_arith_convert_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Sema/int-arith-convert.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple=i686-linux-gnu -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/Sema/int-arith-convert.c
    RUN("%clang_cc1 -triple=i686-linux-gnu -fsyntax-only -verify %s");
  }

  @Test
  public void test_integer_overflow_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Sema/integer-overflow.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/Sema/integer-overflow.c -verify -fsyntax-only -triple x86_64-pc-linux-gnu
    RUN("%clang_cc1 %s -verify -fsyntax-only -triple x86_64-pc-linux-gnu");
  }

  @Test
  public void test_internal_linkage_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Sema/internal_linkage.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/Sema/internal_linkage.c
    RUN("%clang_cc1 -fsyntax-only -verify %s");
  }

  @Test
  public void test_invalid_assignment_constant_address_space_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Sema/invalid-assignment-constant-address-space.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/Sema/invalid-assignment-constant-address-space.c -verify -pedantic -fsyntax-only
    RUN("%clang_cc1 %s -verify -pedantic -fsyntax-only");
  }

  @Test
  public void test_invalid_cast_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Sema/invalid-cast.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -verify -fsyntax-only ${LLVM_SRC}/llvm/tools/clang/test/Sema/invalid-cast.cpp
    RUN("%clang_cc1 -verify -fsyntax-only %s");
  }

  @Test
  public void test_invalid_decl_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Sema/invalid-decl.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/Sema/invalid-decl.c -fsyntax-only -verify
    RUN("%clang_cc1 %s -fsyntax-only -verify");
  }

  @Test
  public void test_invalid_init_diag_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Sema/invalid-init-diag.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/Sema/invalid-init-diag.c -verify -fsyntax-only
    RUN("%clang_cc1 %s -verify -fsyntax-only");
  }

  @Test
  public void test_invalid_struct_init_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Sema/invalid-struct-init.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/Sema/invalid-struct-init.c -verify -fsyntax-only
    RUN("%clang_cc1 %s -verify -fsyntax-only");
  }

  @Test
  public void test_knr_def_call_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Sema/knr-def-call.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -Wconversion -Wliteral-conversion -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/Sema/knr-def-call.c
    RUN("%clang_cc1 -Wconversion -Wliteral-conversion -fsyntax-only -verify %s");
  }

  @Test
  public void test_knr_variadic_def_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Sema/knr-variadic-def.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -pedantic ${LLVM_SRC}/llvm/tools/clang/test/Sema/knr-variadic-def.c
    RUN("%clang_cc1 -fsyntax-only -verify -pedantic %s");
  }

  @Test
  public void test_libbuiltins_ctype_powerpc64_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Sema/libbuiltins-ctype-powerpc64.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple powerpc64-unknown-linux-gnu -emit-llvm < ${LLVM_SRC}/llvm/tools/clang/test/Sema/libbuiltins-ctype-powerpc64.c | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Sema/libbuiltins-ctype-powerpc64.c
    RUN(TestState.Failed, "%clang_cc1 -triple powerpc64-unknown-linux-gnu -emit-llvm < %s")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_libbuiltins_ctype_x86_64_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Sema/libbuiltins-ctype-x86_64.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-unknown-linux-gnu -emit-llvm < ${LLVM_SRC}/llvm/tools/clang/test/Sema/libbuiltins-ctype-x86_64.c | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Sema/libbuiltins-ctype-x86_64.c
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-unknown-linux-gnu -emit-llvm < %s")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_loop_control_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Sema/loop-control.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/Sema/loop-control.c
    RUN("%clang_cc1 -fsyntax-only -verify %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -x c++ -Werror ${LLVM_SRC}/llvm/tools/clang/test/Sema/loop-control.c
    RUN("%clang_cc1 -fsyntax-only -x c++ -Werror %s");
  }

  @Test
  public void test_many_logical_ops_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Sema/many-logical-ops.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -Wconstant-conversion -verify ${LLVM_SRC}/llvm/tools/clang/test/Sema/many-logical-ops.c
    RUN(TestState.Failed, "%clang_cc1 -fsyntax-only -Wconstant-conversion -verify %s");
  }

  @Test
  public void test_many_parameters_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Sema/many-parameters.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -std=c99 ${LLVM_SRC}/llvm/tools/clang/test/Sema/many-parameters.c
    RUN("%clang_cc1 -fsyntax-only -std=c99 %s");
  }

  @Test
  public void test_member_reference_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Sema/member-reference.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/Sema/member-reference.c -verify -fsyntax-only
    RUN("%clang_cc1 %s -verify -fsyntax-only");
  }

  @Test
  public void test_memset_invalid_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Sema/memset-invalid.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only ${LLVM_SRC}/llvm/tools/clang/test/Sema/memset-invalid.c -verify
    RUN("%clang_cc1 -fsyntax-only %s -verify");
  }

  @Test
  public void test_memset_invalid_1_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Sema/memset-invalid-1.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only ${LLVM_SRC}/llvm/tools/clang/test/Sema/memset-invalid-1.c -verify
    RUN("%clang_cc1 -fsyntax-only %s -verify");
  }

  @Test
  public void test_merge_decls_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Sema/merge-decls.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/Sema/merge-decls.c -verify -fsyntax-only
    RUN("%clang_cc1 %s -verify -fsyntax-only");
  }

  @Test
  public void test_mips_interrupt_attr_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Sema/mips-interrupt-attr.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/Sema/mips-interrupt-attr.c -triple mips-img-elf -verify -fsyntax-only
    RUN("%clang_cc1 %s -triple mips-img-elf -verify -fsyntax-only");
  }

  @Test
  public void test_mips16_attr_allowed_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Sema/mips16_attr_allowed.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple mipsel-linux-gnu -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/Sema/mips16_attr_allowed.c
    RUN("%clang_cc1 -triple mipsel-linux-gnu -fsyntax-only -verify %s");
  }

  @Test
  public void test_mips16_attr_not_allowed_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Sema/mips16_attr_not_allowed.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-unknown-linux-gnu -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/Sema/mips16_attr_not_allowed.c
    RUN("%clang_cc1 -triple x86_64-unknown-linux-gnu -fsyntax-only -verify %s");
  }

  @Test
  public void test_missing_field_initializers_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Sema/missing-field-initializers.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -Wmissing-field-initializers ${LLVM_SRC}/llvm/tools/clang/test/Sema/missing-field-initializers.c
    RUN("%clang_cc1 -fsyntax-only -verify -Wmissing-field-initializers %s");
  }

  @Test
  public void test_mms_bitfields_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Sema/mms-bitfields.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -mms-bitfields -fsyntax-only -verify -triple x86_64-apple-darwin9 ${LLVM_SRC}/llvm/tools/clang/test/Sema/mms-bitfields.c
    RUN("%clang_cc1 -mms-bitfields -fsyntax-only -verify -triple x86_64-apple-darwin9 %s");
  }

  @Test
  public void test_mrtd_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Sema/mrtd.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -DMRTD -mrtd -triple i386-unknown-unknown -verify ${LLVM_SRC}/llvm/tools/clang/test/Sema/mrtd.c
    RUN("%clang_cc1 -DMRTD -mrtd -triple i386-unknown-unknown -verify %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i386-unknown-unknown -verify ${LLVM_SRC}/llvm/tools/clang/test/Sema/mrtd.c
    RUN("%clang_cc1 -triple i386-unknown-unknown -verify %s");
  }

  @Test
  public void test_ms_inline_asm_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Sema/ms-inline-asm.c");
    // REQUIRES: x86-registered-target
    if (!CHECK_REQUIRES("x86-registered-target")) {
      return;
    }
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/Sema/ms-inline-asm.c -triple x86_64-apple-darwin10 -fms-extensions -fasm-blocks -Wno-microsoft -Wunused-label -verify -fsyntax-only
    RUN(TestState.Failed, "%clang_cc1 %s -triple x86_64-apple-darwin10 -fms-extensions -fasm-blocks -Wno-microsoft -Wunused-label -verify -fsyntax-only");
  }

  @Test
  public void test_ms_inline_asm_invalid_arch_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Sema/ms-inline-asm-invalid-arch.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/Sema/ms-inline-asm-invalid-arch.c -triple powerpc64-unknown-linux-gnu -fasm-blocks -verify -fsyntax-only
    RUN("%clang_cc1 %s -triple powerpc64-unknown-linux-gnu -fasm-blocks -verify -fsyntax-only");
  }

  @Test
  public void test_ms_keyword_system_header_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Sema/ms-keyword-system-header.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fms-extensions -D MS -isystem ${LLVM_SRC}/llvm/tools/clang/test/Sema/Inputs ${LLVM_SRC}/llvm/tools/clang/test/Sema/ms-keyword-system-header.c -fsyntax-only -verify
    RUN("%clang_cc1 -fms-extensions -D MS -isystem %S/Inputs %s -fsyntax-only -verify");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fms-extensions -D MS -Wno-keyword-compat -I ${LLVM_SRC}/llvm/tools/clang/test/Sema/Inputs ${LLVM_SRC}/llvm/tools/clang/test/Sema/ms-keyword-system-header.c -fsyntax-only -verify
    RUN("%clang_cc1 -fms-extensions -D MS -Wno-keyword-compat -I %S/Inputs %s -fsyntax-only -verify");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fms-extensions -D MS -D NOT_SYSTEM -I ${LLVM_SRC}/llvm/tools/clang/test/Sema/Inputs ${LLVM_SRC}/llvm/tools/clang/test/Sema/ms-keyword-system-header.c -fsyntax-only -verify
    RUN("%clang_cc1 -fms-extensions -D MS -D NOT_SYSTEM -I %S/Inputs %s -fsyntax-only -verify");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -isystem ${LLVM_SRC}/llvm/tools/clang/test/Sema/Inputs ${LLVM_SRC}/llvm/tools/clang/test/Sema/ms-keyword-system-header.c -fsyntax-only -verify
    RUN("%clang_cc1 -isystem %S/Inputs %s -fsyntax-only -verify");
  }

  @Test
  public void test_ms_wchar_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Sema/ms-wchar.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -fms-extensions -triple i386-pc-win32 ${LLVM_SRC}/llvm/tools/clang/test/Sema/ms-wchar.c
    RUN("%clang_cc1 -fsyntax-only -verify -fms-extensions -triple i386-pc-win32 %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x c++ -fno-wchar -fsyntax-only -verify -fms-extensions -triple i386-pc-win32 ${LLVM_SRC}/llvm/tools/clang/test/Sema/ms-wchar.c
    RUN("%clang_cc1 -x c++ -fno-wchar -fsyntax-only -verify -fms-extensions -triple i386-pc-win32 %s");
  }

  @Test
  public void test_ms_abi_sysv_abi_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Sema/ms_abi-sysv_abi.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -triple x86_64-pc-linux-gnu ${LLVM_SRC}/llvm/tools/clang/test/Sema/ms_abi-sysv_abi.c
    RUN("%clang_cc1 -fsyntax-only -verify -triple x86_64-pc-linux-gnu %s");
  }

  @Test
  public void test_ms_bitfield_layout_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Sema/ms_bitfield_layout.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fno-rtti -emit-llvm-only -triple i686-pc-win32 -fms-extensions -fdump-record-layouts ${LLVM_SRC}/llvm/tools/clang/test/Sema/ms_bitfield_layout.c 2>/dev/null | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Sema/ms_bitfield_layout.c
    RUN("%clang_cc1 -fno-rtti -emit-llvm-only -triple i686-pc-win32 -fms-extensions -fdump-record-layouts %s 2>/dev/null")./*|*/
      I("FileCheck %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fno-rtti -emit-llvm-only -triple x86_64-pc-win32 -fms-extensions -fdump-record-layouts ${LLVM_SRC}/llvm/tools/clang/test/Sema/ms_bitfield_layout.c 2>/dev/null | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Sema/ms_bitfield_layout.c
    RUN("%clang_cc1 -fno-rtti -emit-llvm-only -triple x86_64-pc-win32 -fms-extensions -fdump-record-layouts %s 2>/dev/null")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_ms_class_layout_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Sema/ms_class_layout.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm-only -triple i686-pc-win32 -fdump-record-layouts ${LLVM_SRC}/llvm/tools/clang/test/Sema/ms_class_layout.cpp 2>/dev/null | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Sema/ms_class_layout.cpp
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm-only -triple i686-pc-win32 -fdump-record-layouts %s 2>/dev/null")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_ms_wide_predefined_expr_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Sema/ms_wide_predefined_expr.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/Sema/ms_wide_predefined_expr.cpp -fsyntax-only -Wno-unused-value -Wmicrosoft -verify -fms-extensions
    RUN("%clang_cc1 %s -fsyntax-only -Wno-unused-value -Wmicrosoft -verify -fms-extensions");
  }

  @Test
  public void test_negative_shift_wrapv_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Sema/negative-shift-wrapv.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -Wall -ffreestanding -fsyntax-only -fwrapv -verify ${LLVM_SRC}/llvm/tools/clang/test/Sema/negative-shift-wrapv.c
    RUN("%clang_cc1 -Wall -ffreestanding -fsyntax-only -fwrapv -verify %s");
  }

  @Test
  public void test_neon_vector_types_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Sema/neon-vector-types.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/Sema/neon-vector-types.c -triple armv7 -target-feature +neon -fsyntax-only -verify
    RUN("%clang_cc1 %s -triple armv7 -target-feature +neon -fsyntax-only -verify");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/Sema/neon-vector-types.c -triple armv8 -target-feature +neon -fsyntax-only -verify
    RUN("%clang_cc1 %s -triple armv8 -target-feature +neon -fsyntax-only -verify");
  }

  @Test
  public void test_neon_vector_types_support_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Sema/neon-vector-types-support.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/Sema/neon-vector-types-support.c -triple armv7 -fsyntax-only -verify
    RUN("%clang_cc1 %s -triple armv7 -fsyntax-only -verify");
  }

  @Test
  public void test_nested_redef_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Sema/nested-redef.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/Sema/nested-redef.c
    RUN("%clang_cc1 -fsyntax-only -verify %s");
  }

  @Test
  public void test_no_documentation_warn_tagdecl_specifier_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Sema/no-documentation-warn-tagdecl-specifier.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -Wdocumentation -verify ${LLVM_SRC}/llvm/tools/clang/test/Sema/no-documentation-warn-tagdecl-specifier.c
    RUN("%clang_cc1 -fsyntax-only -Wdocumentation -verify %s");
  }

  @Test
  public void test_no_format_y2k_turnsoff_format_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Sema/no-format-y2k-turnsoff-format.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -verify -fsyntax-only -Wformat -Wno-format-y2k ${LLVM_SRC}/llvm/tools/clang/test/Sema/no-format-y2k-turnsoff-format.c
    RUN("%clang_cc1 -verify -fsyntax-only -Wformat -Wno-format-y2k %s");
  }

  @Test
  public void test_non_null_warning_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Sema/non-null-warning.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -Wnonnull -Wnullability ${LLVM_SRC}/llvm/tools/clang/test/Sema/non-null-warning.c -verify
    RUN("%clang_cc1 -fsyntax-only -Wnonnull -Wnullability %s -verify");
  }

  @Test
  public void test_nonnull_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Sema/nonnull.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/Sema/nonnull.c
    RUN(TestState.Failed, "%clang_cc1 -fsyntax-only -verify %s");
  }

  @Test
  public void test_nowarn_documentation_property_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Sema/nowarn-documentation-property.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -fblocks -Wno-objc-root-class -Wdocumentation -verify ${LLVM_SRC}/llvm/tools/clang/test/Sema/nowarn-documentation-property.m
    RUN("%clang_cc1 -fsyntax-only -fblocks -Wno-objc-root-class -Wdocumentation -verify %s");
  }

  @Test
  public void test_nullability_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Sema/nullability.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -fblocks -Wnullable-to-nonnull-conversion -Wno-nullability-declspec ${LLVM_SRC}/llvm/tools/clang/test/Sema/nullability.c -verify
    RUN(TestState.Failed, "%clang_cc1 -fsyntax-only -fblocks -Wnullable-to-nonnull-conversion -Wno-nullability-declspec %s -verify");
  }

  @Test
  public void test_offsetof_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Sema/offsetof.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/Sema/offsetof.c
    RUN("%clang_cc1 -fsyntax-only -verify %s");
  }

  @Test
  public void test_offsetof_64_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Sema/offsetof-64.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/Sema/offsetof-64.c -triple x86_64-linux-gnu
    RUN("%clang_cc1 -fsyntax-only -verify %s -triple x86_64-linux-gnu");
  }

  @Test
  public void test_outof_range_constant_compare_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Sema/outof-range-constant-compare.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-apple-darwin -fsyntax-only -Wtautological-constant-out-of-range-compare -verify ${LLVM_SRC}/llvm/tools/clang/test/Sema/outof-range-constant-compare.c
    RUN("%clang_cc1 -triple x86_64-apple-darwin -fsyntax-only -Wtautological-constant-out-of-range-compare -verify %s");
  }

  @Test
  public void test_overloadable_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Sema/overloadable.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/Sema/overloadable.c -Wincompatible-pointer-types
    RUN("%clang_cc1 -fsyntax-only -verify %s -Wincompatible-pointer-types");
  }

  @Test
  public void test_overloadable_complex_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Sema/overloadable-complex.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/Sema/overloadable-complex.c
    RUN("%clang_cc1 -fsyntax-only -verify %s");
  }

  @Test
  public void test_overloaded_func_transparent_union_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Sema/overloaded-func-transparent-union.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/Sema/overloaded-func-transparent-union.c -fsyntax-only -verify
    RUN("%clang_cc1 %s -fsyntax-only -verify");
  }

  @Test
  public void test_parentheses_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Sema/parentheses.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -Wparentheses -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/Sema/parentheses.c
    RUN("%clang_cc1 -Wparentheses -fsyntax-only -verify %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -Wparentheses -fsyntax-only -fdiagnostics-parseable-fixits ${LLVM_SRC}/llvm/tools/clang/test/Sema/parentheses.c 2>&1 | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Sema/parentheses.c
    RUN("%clang_cc1 -Wparentheses -fsyntax-only -fdiagnostics-parseable-fixits %s 2>&1")./*|*/
      I("FileCheck %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -Wparentheses -Werror -fdiagnostics-show-option ${LLVM_SRC}/llvm/tools/clang/test/Sema/parentheses.c 2>&1 | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Sema/parentheses.c -check-prefix=CHECK-FLAG
    RUN("not %clang_cc1 -fsyntax-only -Wparentheses -Werror -fdiagnostics-show-option %s 2>&1")./*|*/
      I("FileCheck %s -check-prefix=CHECK-FLAG");
  }

  @Test
  public void test_parentheses_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Sema/parentheses.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -Wparentheses -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/Sema/parentheses.cpp
    RUN("%clang_cc1 -Wparentheses -fsyntax-only -verify %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -Wparentheses -fsyntax-only -fdiagnostics-parseable-fixits ${LLVM_SRC}/llvm/tools/clang/test/Sema/parentheses.cpp 2>&1 | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Sema/parentheses.cpp
    RUN("%clang_cc1 -Wparentheses -fsyntax-only -fdiagnostics-parseable-fixits %s 2>&1")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_pass_object_size_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Sema/pass-object-size.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/Sema/pass-object-size.c -triple x86_64-linux-gnu -Wincompatible-pointer-types
    RUN("%clang_cc1 -fsyntax-only -verify %s -triple x86_64-linux-gnu -Wincompatible-pointer-types");
  }

  @Test
  public void test_pid_t_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Sema/pid_t.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i586-pc-haiku -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/Sema/pid_t.c
    RUN("%clang_cc1 -triple i586-pc-haiku -fsyntax-only -verify %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i686-pc-linux -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/Sema/pid_t.c
    RUN("%clang_cc1 -triple i686-pc-linux -fsyntax-only -verify %s");
  }

  @Test
  public void test_pointer_addition_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Sema/pointer-addition.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/Sema/pointer-addition.c -fsyntax-only -verify -pedantic -std=c11
    RUN("%clang_cc1 %s -fsyntax-only -verify -pedantic -std=c11");
  }

  @Test
  public void test_pointer_conversion_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Sema/pointer-conversion.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/Sema/pointer-conversion.c
    RUN("%clang_cc1 -fsyntax-only -verify %s");
  }

  @Test
  public void test_pointer_subtract_compat_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Sema/pointer-subtract-compat.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/Sema/pointer-subtract-compat.c -fsyntax-only -verify -pedantic
    RUN("%clang_cc1 %s -fsyntax-only -verify -pedantic");
  }

  @Test
  public void test_ppc_bool_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Sema/ppc-bool.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple powerpc-apple-macosx10.4.0 -verify -fsyntax-only ${LLVM_SRC}/llvm/tools/clang/test/Sema/ppc-bool.c
    RUN("%clang_cc1 -triple powerpc-apple-macosx10.4.0 -verify -fsyntax-only %s");
  }

  @Test
  public void test_pr25786_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Sema/pr25786.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-unknown-linux-gnu -DTEST -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/Sema/pr25786.c
    RUN("%clang_cc1 -triple x86_64-unknown-linux-gnu -DTEST -fsyntax-only -verify %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i686-unknown-linux-gnu -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/Sema/pr25786.c
    RUN("%clang_cc1 -triple i686-unknown-linux-gnu -fsyntax-only -verify %s");
  }

  @Test
  public void test_pr9812_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Sema/pr9812.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/Sema/pr9812.c
    RUN("%clang_cc1 -fsyntax-only -verify %s");
  }

  @Test
  public void test_pragma_align_mac68k_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Sema/pragma-align-mac68k.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i386-apple-darwin9 -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/Sema/pragma-align-mac68k.c
    RUN("%clang_cc1 -triple i386-apple-darwin9 -fsyntax-only -verify %s");
  }

  @Test
  public void test_pragma_align_mac68k_unsupported_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Sema/pragma-align-mac68k-unsupported.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-apple-darwin10 -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/Sema/pragma-align-mac68k-unsupported.c
    RUN("%clang_cc1 -triple x86_64-apple-darwin10 -fsyntax-only -verify %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i386-pc-linux-gnu -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/Sema/pragma-align-mac68k-unsupported.c
    RUN("%clang_cc1 -triple i386-pc-linux-gnu -fsyntax-only -verify %s");
  }

  @Test
  public void test_pragma_align_packed_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Sema/pragma-align-packed.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i386-apple-darwin9 -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/Sema/pragma-align-packed.c
    RUN("%clang_cc1 -triple i386-apple-darwin9 -fsyntax-only -verify %s");
  }

  @Test
  public void test_pragma_arc_cf_code_audited_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Sema/pragma-arc-cf-code-audited.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/Sema/pragma-arc-cf-code-audited.c
    RUN("%clang_cc1 -fsyntax-only -verify %s");
  }

  @Test
  public void test_pragma_ms_struct_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Sema/pragma-ms_struct.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -fms-extensions -verify -triple x86_64-apple-darwin9 ${LLVM_SRC}/llvm/tools/clang/test/Sema/pragma-ms_struct.c
    RUN("%clang_cc1 -fsyntax-only -fms-extensions -verify -triple x86_64-apple-darwin9 %s");
  }

  @Test
  public void test_pragma_pack_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Sema/pragma-pack.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i686-apple-darwin9 -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/Sema/pragma-pack.c
    RUN("%clang_cc1 -triple i686-apple-darwin9 -fsyntax-only -verify %s");
  }

  @Test
  public void test_pragma_pack_2_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Sema/pragma-pack-2.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i686-apple-darwin9 ${LLVM_SRC}/llvm/tools/clang/test/Sema/pragma-pack-2.c -fsyntax-only -verify
    RUN("%clang_cc1 -triple i686-apple-darwin9 %s -fsyntax-only -verify");
  }

  @Test
  public void test_pragma_pack_3_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Sema/pragma-pack-3.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i686-apple-darwin9 ${LLVM_SRC}/llvm/tools/clang/test/Sema/pragma-pack-3.c -fsyntax-only -verify
    RUN("%clang_cc1 -triple i686-apple-darwin9 %s -fsyntax-only -verify");
  }

  @Test
  public void test_pragma_pack_4_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Sema/pragma-pack-4.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i686-apple-darwin9 ${LLVM_SRC}/llvm/tools/clang/test/Sema/pragma-pack-4.c -fsyntax-only -verify
    RUN("%clang_cc1 -triple i686-apple-darwin9 %s -fsyntax-only -verify");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-apple-darwin9 ${LLVM_SRC}/llvm/tools/clang/test/Sema/pragma-pack-4.c -fsyntax-only -verify
    RUN("%clang_cc1 -triple x86_64-apple-darwin9 %s -fsyntax-only -verify");
  }

  @Test
  public void test_pragma_pack_5_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Sema/pragma-pack-5.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-apple-darwin9 ${LLVM_SRC}/llvm/tools/clang/test/Sema/pragma-pack-5.c -fsyntax-only -verify -ffreestanding
    RUN("%clang_cc1 -triple x86_64-apple-darwin9 %s -fsyntax-only -verify -ffreestanding");
  }

  @Test
  public void test_pragma_pack_6_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Sema/pragma-pack-6.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i686-apple-darwin9 ${LLVM_SRC}/llvm/tools/clang/test/Sema/pragma-pack-6.c -fsyntax-only -verify
    RUN("%clang_cc1 -triple i686-apple-darwin9 %s -fsyntax-only -verify");
  }

  @Test
  public void test_pragma_pack_and_options_align_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Sema/pragma-pack-and-options-align.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i686-apple-darwin9 ${LLVM_SRC}/llvm/tools/clang/test/Sema/pragma-pack-and-options-align.c -fsyntax-only -verify
    RUN("%clang_cc1 -triple i686-apple-darwin9 %s -fsyntax-only -verify");
  }

  @Test
  public void test_pragma_pack_apple_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Sema/pragma-pack-apple.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only ${LLVM_SRC}/llvm/tools/clang/test/Sema/pragma-pack-apple.c 2>&1 | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Sema/pragma-pack-apple.c
    RUN("%clang_cc1 -fsyntax-only %s 2>&1")./*|*/
      I("FileCheck %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -fapple-pragma-pack ${LLVM_SRC}/llvm/tools/clang/test/Sema/pragma-pack-apple.c 2>&1 | ${LLVM_SRC}/build/bin/FileCheck -check-prefix=CHECK-APPLE ${LLVM_SRC}/llvm/tools/clang/test/Sema/pragma-pack-apple.c
    RUN("%clang_cc1 -fsyntax-only -fapple-pragma-pack %s 2>&1")./*|*/
      I("FileCheck -check-prefix=CHECK-APPLE %s");
  }

  @Test
  public void test_pragma_section_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Sema/pragma-section.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -fms-extensions ${LLVM_SRC}/llvm/tools/clang/test/Sema/pragma-section.c -triple x86_64-pc-win32
    RUN("%clang_cc1 -fsyntax-only -verify -fms-extensions %s -triple x86_64-pc-win32");
  }

  @Test
  public void test_pragma_section_invalid_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Sema/pragma-section-invalid.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -fms-extensions ${LLVM_SRC}/llvm/tools/clang/test/Sema/pragma-section-invalid.c -triple x86_64-apple-darwin
    RUN("%clang_cc1 -fsyntax-only -verify -fms-extensions %s -triple x86_64-apple-darwin");
  }

  @Test
  public void test_pragma_unused_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Sema/pragma-unused.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -Wunused-parameter -Wused-but-marked-unused -Wunused -verify ${LLVM_SRC}/llvm/tools/clang/test/Sema/pragma-unused.c
    RUN("%clang_cc1 -fsyntax-only -Wunused-parameter -Wused-but-marked-unused -Wunused -verify %s");
  }

  @Test
  public void test_pragma_weak_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Sema/pragma-weak.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-pc-linux-gnu -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/Sema/pragma-weak.c
    RUN("%clang_cc1 -triple x86_64-pc-linux-gnu -fsyntax-only -verify %s");
  }

  @Test
  public void test_predef_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Sema/predef.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/Sema/predef.c
    RUN("%clang_cc1 -fsyntax-only -verify %s");
  }

  @Test
  public void test_predefined_function_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Sema/predefined-function.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -pedantic ${LLVM_SRC}/llvm/tools/clang/test/Sema/predefined-function.c
    RUN("%clang_cc1 -fsyntax-only -verify -pedantic %s");
  }

  @Test
  public void test_preserve_call_conv_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Sema/preserve-call-conv.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/Sema/preserve-call-conv.c -fsyntax-only -triple x86_64-unknown-unknown -verify
    RUN("%clang_cc1 %s -fsyntax-only -triple x86_64-unknown-unknown -verify");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/Sema/preserve-call-conv.c -fsyntax-only -triple arm64-unknown-unknown -verify
    RUN("%clang_cc1 %s -fsyntax-only -triple arm64-unknown-unknown -verify");
  }

  @Test
  public void test_private_extern_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Sema/private-extern.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -verify -fsyntax-only -Wno-private-extern ${LLVM_SRC}/llvm/tools/clang/test/Sema/private-extern.c
    RUN("%clang_cc1 -verify -fsyntax-only -Wno-private-extern %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -verify -fsyntax-only -Wno-private-extern -fmodules ${LLVM_SRC}/llvm/tools/clang/test/Sema/private-extern.c
    RUN("%clang_cc1 -verify -fsyntax-only -Wno-private-extern -fmodules %s");
  }

  @Test
  public void test_rdr6094103_unordered_compare_promote_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Sema/rdr6094103-unordered-compare-promote.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -ast-dump ${LLVM_SRC}/llvm/tools/clang/test/Sema/rdr6094103-unordered-compare-promote.c 2>&1 | grep ImplicitCastExpr | ${LLVM_SRC}/build/bin/count 4
    RUN("%clang_cc1 -ast-dump %s 2>&1")./*|*/
      I("grep ImplicitCastExpr")./*|*/
      I("count 4");
  }

  @Test
  public void test_recover_goto_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Sema/recover-goto.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only ${LLVM_SRC}/llvm/tools/clang/test/Sema/recover-goto.c -verify
    RUN("%clang_cc1 -fsyntax-only %s -verify");
  }

  @Test
  public void test_redefine_extname_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Sema/redefine_extname.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple=x86_64-unknown-linux -Wpragmas -verify ${LLVM_SRC}/llvm/tools/clang/test/Sema/redefine_extname.c
    RUN("%clang_cc1 -triple=x86_64-unknown-linux -Wpragmas -verify %s");
  }

  @Test
  public void test_redefinition_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Sema/redefinition.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/Sema/redefinition.c -fsyntax-only -verify
    RUN("%clang_cc1 %s -fsyntax-only -verify");
  }

  @Test
  public void test_renderscript_rs() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Sema/renderscript.rs");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -x renderscript -D__RENDERSCRIPT__ ${LLVM_SRC}/llvm/tools/clang/test/Sema/renderscript.rs
    RUN("%clang_cc1 -fsyntax-only -verify -x renderscript -D__RENDERSCRIPT__ %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -x c ${LLVM_SRC}/llvm/tools/clang/test/Sema/renderscript.rs
    RUN("%clang_cc1 -fsyntax-only -verify -x c %s");
  }

  @Test
  public void test_return_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Sema/return.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-apple-darwin9 ${LLVM_SRC}/llvm/tools/clang/test/Sema/return.c -fsyntax-only -Wignored-qualifiers -Wno-error=return-type -verify -fblocks -Wno-unreachable-code -Wno-unused-value
    RUN("%clang_cc1 -triple x86_64-apple-darwin9 %s -fsyntax-only -Wignored-qualifiers -Wno-error=return-type -verify -fblocks -Wno-unreachable-code -Wno-unused-value");
  }

  @Test
  public void test_return_noreturn_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Sema/return-noreturn.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/Sema/return-noreturn.c -fsyntax-only -verify -fblocks -Wmissing-noreturn -Wno-unreachable-code
    RUN("%clang_cc1 %s -fsyntax-only -verify -fblocks -Wmissing-noreturn -Wno-unreachable-code");
  }

  @Test
  public void test_return_silent_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Sema/return-silent.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/Sema/return-silent.c -Wno-return-type -fsyntax-only -verify
    RUN("%clang_cc1 %s -Wno-return-type -fsyntax-only -verify");
  }

  @Test
  public void test_scope_check_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Sema/scope-check.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -fblocks -std=gnu99 ${LLVM_SRC}/llvm/tools/clang/test/Sema/scope-check.c -Wno-unreachable-code
    RUN("%clang_cc1 -fsyntax-only -verify -fblocks -std=gnu99 %s -Wno-unreachable-code");
  }

  @Test
  public void test_self_comparison_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Sema/self-comparison.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/Sema/self-comparison.c
    RUN("%clang_cc1 -fsyntax-only -verify %s");
  }

  @Test
  public void test_sentinel_attribute_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Sema/sentinel-attribute.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/Sema/sentinel-attribute.c
    RUN("%clang_cc1 -fsyntax-only -verify %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only ${LLVM_SRC}/llvm/tools/clang/test/Sema/sentinel-attribute.c -fdiagnostics-parseable-fixits 2>&1 | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Sema/sentinel-attribute.c --check-prefix=C
    RUN("not %clang_cc1 -fsyntax-only %s -fdiagnostics-parseable-fixits 2>&1")./*|*/
      I("FileCheck %s --check-prefix=C");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only ${LLVM_SRC}/llvm/tools/clang/test/Sema/sentinel-attribute.c -fdiagnostics-parseable-fixits -x c++ -std=c++11 2>&1 | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Sema/sentinel-attribute.c --check-prefix=CXX11
    RUN("not %clang_cc1 -fsyntax-only %s -fdiagnostics-parseable-fixits -x c++ -std=c++11 2>&1")./*|*/
      I("FileCheck %s --check-prefix=CXX11");
  }

  @Test
  public void test_shift_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Sema/shift.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -Wall -Wshift-sign-overflow -ffreestanding -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/Sema/shift.c
    RUN("%clang_cc1 -Wall -Wshift-sign-overflow -ffreestanding -fsyntax-only -verify %s");
  }

  @Test
  public void test_short_enums_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Sema/short-enums.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only ${LLVM_SRC}/llvm/tools/clang/test/Sema/short-enums.c -verify
    RUN("not %clang_cc1 -fsyntax-only %s -verify");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i386-pc-solaris2.11 -fshort-enums -fsyntax-only ${LLVM_SRC}/llvm/tools/clang/test/Sema/short-enums.c -verify
    RUN("%clang_cc1 -triple %itanium_abi_triple -fshort-enums -fsyntax-only %s -verify");
  }

  @Test
  public void test_sign_conversion_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Sema/sign-conversion.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -Wsign-conversion ${LLVM_SRC}/llvm/tools/clang/test/Sema/sign-conversion.c
    RUN("%clang_cc1 -fsyntax-only -verify -Wsign-conversion %s");
  }

  @Test
  public void test_sizeof_struct_non_zero_as_member_cl() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Sema/sizeof-struct-non-zero-as-member.cl");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -verify -fsyntax-only -triple amdgcn -target-cpu verde -S -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/Sema/sizeof-struct-non-zero-as-member.cl
    RUN(TestState.Failed, "%clang_cc1 -verify -fsyntax-only -triple amdgcn -target-cpu verde -S -emit-llvm -o - %s");
  }

  @Test
  public void test_statements_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Sema/statements.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/Sema/statements.c -fsyntax-only -verify -triple x86_64-pc-linux-gnu -Wno-unevaluated-expression
    RUN("%clang_cc1 %s -fsyntax-only -verify  -triple x86_64-pc-linux-gnu -Wno-unevaluated-expression");
  }

  @Test
  public void test_static_array_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Sema/static-array.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -fblocks -verify ${LLVM_SRC}/llvm/tools/clang/test/Sema/static-array.c
    RUN("%clang_cc1 -fsyntax-only -fblocks -verify %s");
  }

  @Test
  public void test_static_assert_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Sema/static-assert.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c11 -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/Sema/static-assert.c
    RUN("%clang_cc1 -std=c11 -fsyntax-only -verify %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -xc++ -std=c++11 -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/Sema/static-assert.c
    RUN("%clang_cc1 -xc++ -std=c++11 -fsyntax-only -verify %s");
  }

  @Test
  public void test_static_init_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Sema/static-init.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -Wno-bool-conversion ${LLVM_SRC}/llvm/tools/clang/test/Sema/static-init.c
    RUN("%clang_cc1 -fsyntax-only -verify -Wno-bool-conversion %s");
  }

  @Test
  public void test_stdcall_fastcall_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Sema/stdcall-fastcall.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -triple i686-apple-darwin10 ${LLVM_SRC}/llvm/tools/clang/test/Sema/stdcall-fastcall.c
    RUN("%clang_cc1 -fsyntax-only -verify -triple i686-apple-darwin10 %s");
  }

  @Test
  public void test_stdcall_fastcall_x64_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Sema/stdcall-fastcall-x64.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -triple x86_64-pc-linux-gnu ${LLVM_SRC}/llvm/tools/clang/test/Sema/stdcall-fastcall-x64.c
    RUN("%clang_cc1 -fsyntax-only -verify -triple x86_64-pc-linux-gnu %s");
  }

  @Test
  public void test_stmtexprs_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Sema/stmtexprs.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/Sema/stmtexprs.c -verify -pedantic -fsyntax-only -Wno-gnu-statement-expression
    RUN("%clang_cc1 %s -verify -pedantic -fsyntax-only -Wno-gnu-statement-expression");
  }

  @Test
  public void test_string_init_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Sema/string-init.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c11 -fsyntax-only -triple x86_64-pc-linux -verify ${LLVM_SRC}/llvm/tools/clang/test/Sema/string-init.c
    RUN("%clang_cc1 -std=c11 -fsyntax-only -triple x86_64-pc-linux -verify %s");
  }

  @Test
  public void test_string_plus_char_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Sema/string-plus-char.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/Sema/string-plus-char.c
    RUN("%clang_cc1 -fsyntax-only -verify %s");
  }

  @Test
  public void test_struct_cast_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Sema/struct-cast.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only ${LLVM_SRC}/llvm/tools/clang/test/Sema/struct-cast.c -verify
    RUN("%clang_cc1 -fsyntax-only %s -verify");
  }

  @Test
  public void test_struct_compat_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Sema/struct-compat.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/Sema/struct-compat.c -fsyntax-only -pedantic -verify
    RUN("%clang_cc1 %s -fsyntax-only -pedantic -verify");
  }

  @Test
  public void test_struct_decl_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Sema/struct-decl.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/Sema/struct-decl.c
    RUN("%clang_cc1 -fsyntax-only -verify %s");
  }

  @Test
  public void test_struct_packed_align_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Sema/struct-packed-align.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/Sema/struct-packed-align.c -fsyntax-only -verify
    RUN("%clang_cc1 %s -fsyntax-only -verify");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/Sema/struct-packed-align.c -fsyntax-only -triple=x86_64-windows-coff -verify
    RUN("%clang_cc1 %s -fsyntax-only -triple=x86_64-windows-coff -verify");
  }

  @Test
  public void test_surpress_deprecated_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Sema/surpress-deprecated.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -Wno-deprecated-declarations -verify ${LLVM_SRC}/llvm/tools/clang/test/Sema/surpress-deprecated.c
    RUN("%clang_cc1 -fsyntax-only -Wno-deprecated-declarations -verify %s");
  }

  @Test
  public void test_switch_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Sema/switch.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -Wswitch-enum -Wcovered-switch-default -triple x86_64-linux-gnu ${LLVM_SRC}/llvm/tools/clang/test/Sema/switch.c
    RUN("%clang_cc1 -fsyntax-only -verify -Wswitch-enum -Wcovered-switch-default -triple x86_64-linux-gnu %s");
  }

  @Test
  public void test_switch_1_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Sema/switch-1.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -triple x86_64-apple-darwin10 ${LLVM_SRC}/llvm/tools/clang/test/Sema/switch-1.c
    RUN("%clang_cc1 -fsyntax-only -verify -triple x86_64-apple-darwin10 %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x c++ -fsyntax-only -verify -triple x86_64-apple-darwin10 ${LLVM_SRC}/llvm/tools/clang/test/Sema/switch-1.c
    RUN("%clang_cc1 -x c++ -fsyntax-only -verify -triple x86_64-apple-darwin10 %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x c++ -fsyntax-only -verify -triple x86_64-apple-darwin10 -std=c++98 ${LLVM_SRC}/llvm/tools/clang/test/Sema/switch-1.c
    RUN("%clang_cc1 -x c++ -fsyntax-only -verify -triple x86_64-apple-darwin10 -std=c++98 %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x c++ -fsyntax-only -verify -triple x86_64-apple-darwin10 -std=c++11 ${LLVM_SRC}/llvm/tools/clang/test/Sema/switch-1.c
    RUN("%clang_cc1 -x c++ -fsyntax-only -verify -triple x86_64-apple-darwin10 -std=c++11 %s");
  }

  @Test
  public void test_template_specialization_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Sema/template-specialization.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -verify -fsyntax-only ${LLVM_SRC}/llvm/tools/clang/test/Sema/template-specialization.cpp
    RUN("%clang_cc1 -verify -fsyntax-only %s");
  }

  @Test
  public void test_tentative_decls_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Sema/tentative-decls.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/Sema/tentative-decls.c -fsyntax-only -Wprivate-extern -verify
    RUN("%clang_cc1 %s -fsyntax-only -Wprivate-extern -verify");
  }

  @Test
  public void test_text_diag_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Sema/text-diag.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only ${LLVM_SRC}/llvm/tools/clang/test/Sema/text-diag.c
    RUN("%clang_cc1 -fsyntax-only %s");
  }

  @Test
  public void test_thread_specifier_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Sema/thread-specifier.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i686-pc-linux-gnu -fsyntax-only -Wno-private-extern -verify -pedantic ${LLVM_SRC}/llvm/tools/clang/test/Sema/thread-specifier.c -DGNU
    RUN("%clang_cc1 -triple i686-pc-linux-gnu -fsyntax-only -Wno-private-extern -verify -pedantic %s -DGNU");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i686-pc-linux-gnu -fsyntax-only -Wno-private-extern -verify -pedantic -x c++ ${LLVM_SRC}/llvm/tools/clang/test/Sema/thread-specifier.c -DGNU -std=c++98
    RUN("%clang_cc1 -triple i686-pc-linux-gnu -fsyntax-only -Wno-private-extern -verify -pedantic -x c++ %s -DGNU -std=c++98");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i686-pc-linux-gnu -fsyntax-only -Wno-private-extern -verify -pedantic ${LLVM_SRC}/llvm/tools/clang/test/Sema/thread-specifier.c -DC11 -D__thread=_Thread_local
    RUN("%clang_cc1 -triple i686-pc-linux-gnu -fsyntax-only -Wno-private-extern -verify -pedantic %s -DC11 -D__thread=_Thread_local");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i686-pc-linux-gnu -fsyntax-only -Wno-private-extern -verify -pedantic -x c++ ${LLVM_SRC}/llvm/tools/clang/test/Sema/thread-specifier.c -DC11 -D__thread=_Thread_local -std=c++98
    RUN("%clang_cc1 -triple i686-pc-linux-gnu -fsyntax-only -Wno-private-extern -verify -pedantic -x c++ %s -DC11 -D__thread=_Thread_local -std=c++98");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i686-pc-linux-gnu -fsyntax-only -Wno-private-extern -verify -pedantic -x c++ ${LLVM_SRC}/llvm/tools/clang/test/Sema/thread-specifier.c -DCXX11 -D__thread=thread_local -std=c++11 -Wno-deprecated
    RUN("%clang_cc1 -triple i686-pc-linux-gnu -fsyntax-only -Wno-private-extern -verify -pedantic -x c++ %s -DCXX11 -D__thread=thread_local -std=c++11 -Wno-deprecated");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i686-pc-linux-gnu -fsyntax-only -Wno-private-extern -verify -pedantic -x c++ ${LLVM_SRC}/llvm/tools/clang/test/Sema/thread-specifier.c -DC11 -D__thread=_Thread_local -std=c++11 -Wno-deprecated
    RUN("%clang_cc1 -triple i686-pc-linux-gnu -fsyntax-only -Wno-private-extern -verify -pedantic -x c++ %s -DC11 -D__thread=_Thread_local -std=c++11 -Wno-deprecated");
  }

  @Test
  public void test_tls_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Sema/tls.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-pc-linux-gnu -fsyntax-only ${LLVM_SRC}/llvm/tools/clang/test/Sema/tls.c
    RUN("%clang_cc1 -triple x86_64-pc-linux-gnu -fsyntax-only %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i386-pc-linux-gnu -fsyntax-only ${LLVM_SRC}/llvm/tools/clang/test/Sema/tls.c
    RUN("%clang_cc1 -triple i386-pc-linux-gnu -fsyntax-only %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-apple-darwin10 -fsyntax-only ${LLVM_SRC}/llvm/tools/clang/test/Sema/tls.c
    RUN("not %clang_cc1 -triple x86_64-apple-darwin10 -fsyntax-only %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-apple-macos10.7.0 -fsyntax-only ${LLVM_SRC}/llvm/tools/clang/test/Sema/tls.c
    RUN("%clang_cc1 -triple x86_64-apple-macos10.7.0 -fsyntax-only %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-pc-win32 -fsyntax-only ${LLVM_SRC}/llvm/tools/clang/test/Sema/tls.c
    RUN("%clang_cc1 -triple x86_64-pc-win32 -fsyntax-only %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i386-pc-win32 -fsyntax-only ${LLVM_SRC}/llvm/tools/clang/test/Sema/tls.c
    RUN("%clang_cc1 -triple i386-pc-win32 -fsyntax-only %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-pc-openbsd -fsyntax-only ${LLVM_SRC}/llvm/tools/clang/test/Sema/tls.c
    RUN("not %clang_cc1 -triple x86_64-pc-openbsd -fsyntax-only %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i386-pc-openbsd -fsyntax-only ${LLVM_SRC}/llvm/tools/clang/test/Sema/tls.c
    RUN("not %clang_cc1 -triple i386-pc-openbsd -fsyntax-only %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i586-pc-haiku -fsyntax-only ${LLVM_SRC}/llvm/tools/clang/test/Sema/tls.c
    RUN("not %clang_cc1 -triple i586-pc-haiku -fsyntax-only %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-pc-bitrig -fsyntax-only ${LLVM_SRC}/llvm/tools/clang/test/Sema/tls.c
    RUN("%clang_cc1 -triple x86_64-pc-bitrig -fsyntax-only %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple armv6-unknown-bitrig -fsyntax-only ${LLVM_SRC}/llvm/tools/clang/test/Sema/tls.c
    RUN("%clang_cc1 -triple armv6-unknown-bitrig -fsyntax-only %s");
  }

  @Test
  public void test_tls_alignment_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Sema/tls_alignment.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-scei-ps4 -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/Sema/tls_alignment.cpp
    RUN("%clang_cc1 -triple x86_64-scei-ps4 -fsyntax-only -verify %s");
  }

  @Test
  public void test_transparent_union_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Sema/transparent-union.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/Sema/transparent-union.c
    RUN("%clang_cc1 -fsyntax-only -verify %s");
  }

  @Test
  public void test_transparent_union_pointer_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Sema/transparent-union-pointer.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/Sema/transparent-union-pointer.c -fsyntax-only -verify
    RUN("%clang_cc1 %s -fsyntax-only -verify");
  }

  @Test
  public void test_type_spec_struct_union_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Sema/type-spec-struct-union.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -pedantic -verify ${LLVM_SRC}/llvm/tools/clang/test/Sema/type-spec-struct-union.c
    RUN("%clang_cc1 -fsyntax-only -pedantic -verify %s");
  }

  @Test
  public void test_typecheck_binop_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Sema/typecheck-binop.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/Sema/typecheck-binop.c -fsyntax-only -pedantic -verify
    RUN("%clang_cc1 %s -fsyntax-only -pedantic -verify");
  }

  @Test
  public void test_typedef_prototype_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Sema/typedef-prototype.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/Sema/typedef-prototype.c
    RUN("%clang_cc1 -fsyntax-only -verify %s");
  }

  @Test
  public void test_typedef_redef_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Sema/typedef-redef.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/Sema/typedef-redef.c
    RUN("%clang_cc1 -fsyntax-only -verify %s");
  }

  @Test
  public void test_typedef_retain_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Sema/typedef-retain.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/Sema/typedef-retain.c -fno-lax-vector-conversions
    RUN("%clang_cc1 -fsyntax-only -verify %s -fno-lax-vector-conversions");
  }

  @Test
  public void test_typedef_variable_type_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Sema/typedef-variable-type.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/Sema/typedef-variable-type.c -verify -fsyntax-only -pedantic -Wno-typedef-redefinition -std=c99
    RUN("%clang_cc1 %s -verify -fsyntax-only -pedantic -Wno-typedef-redefinition -std=c99");
  }

  @Test
  public void test_typeof_use_deprecated_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Sema/typeof-use-deprecated.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/Sema/typeof-use-deprecated.c -verify -fsyntax-only
    RUN("%clang_cc1 %s -verify -fsyntax-only");
  }

  @Test
  public void test_types_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Sema/types.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/Sema/types.c -fblocks -pedantic -verify -triple=x86_64-apple-darwin9
    RUN("%clang_cc1 %s -fblocks -pedantic -verify -triple=x86_64-apple-darwin9");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/Sema/types.c -fblocks -pedantic -verify -triple=mips64-linux-gnu
    RUN("%clang_cc1 %s -fblocks -pedantic -verify -triple=mips64-linux-gnu");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/Sema/types.c -fblocks -pedantic -verify -triple=x86_64-unknown-linux
    RUN("%clang_cc1 %s -fblocks -pedantic -verify -triple=x86_64-unknown-linux");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/Sema/types.c -fblocks -pedantic -verify -triple=x86_64-unknown-linux-gnux32
    RUN("%clang_cc1 %s -fblocks -pedantic -verify -triple=x86_64-unknown-linux-gnux32");
  }

  @Test
  public void test_typo_correction_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Sema/typo-correction.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/Sema/typo-correction.c
    RUN( "%clang_cc1 -fsyntax-only -verify %s");
  }

  @Test
  public void test_ucn_cstring_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Sema/ucn-cstring.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/Sema/ucn-cstring.c -verify -fsyntax-only -pedantic
    RUN("%clang_cc1 %s -verify -fsyntax-only -pedantic");
  }

  @Test
  public void test_ucn_identifiers_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Sema/ucn-identifiers.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/Sema/ucn-identifiers.c -verify -fsyntax-only -pedantic
    RUN("%clang_cc1 %s -verify -fsyntax-only -pedantic");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/Sema/ucn-identifiers.c -verify -fsyntax-only -x c++ -pedantic
    RUN("%clang_cc1 %s -verify -fsyntax-only -x c++ -pedantic");
  }

  @Test
  public void test_uninit_det_order_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Sema/uninit-det-order.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -Wuninitialized -fsyntax-only ${LLVM_SRC}/llvm/tools/clang/test/Sema/uninit-det-order.c 2>&1 | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Sema/uninit-det-order.c
    RUN(TestState.Failed, "%clang_cc1 -Wuninitialized -fsyntax-only %s 2>&1")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_uninit_variables_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Sema/uninit-variables.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -Wuninitialized -Wconditional-uninitialized -fsyntax-only -fblocks ${LLVM_SRC}/llvm/tools/clang/test/Sema/uninit-variables.c -verify
    RUN(TestState.Failed, "%clang_cc1 -fsyntax-only -Wuninitialized -Wconditional-uninitialized -fsyntax-only -fblocks %s -verify");
  }

  @Test
  public void test_uninit_variables_vectors_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Sema/uninit-variables-vectors.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-apple-darwin10.0.0 -fsyntax-only -Wuninitialized -fsyntax-only ${LLVM_SRC}/llvm/tools/clang/test/Sema/uninit-variables-vectors.c -verify
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-apple-darwin10.0.0 -fsyntax-only -Wuninitialized -fsyntax-only %s -verify");
  }

  @Test
  public void test_unnamed_bitfield_init_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Sema/unnamed-bitfield-init.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/Sema/unnamed-bitfield-init.c
    RUN("%clang_cc1 -fsyntax-only -verify %s");
  }

  @Test
  public void test_unused_expr_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Sema/unused-expr.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/Sema/unused-expr.c -Wno-unreachable-code
    RUN("%clang_cc1 -fsyntax-only -verify %s -Wno-unreachable-code");
  }

  @Test
  public void test_unused_expr_system_header_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Sema/unused-expr-system-header.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -isystem ${LLVM_SRC}/llvm/tools/clang/test/Sema/Inputs -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/Sema/unused-expr-system-header.c
    RUN("%clang_cc1 -isystem %S/Inputs -fsyntax-only -verify %s");
  }

  @Test
  public void test_usual_float_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Sema/usual-float.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/Sema/usual-float.c -fsyntax-only
    RUN("%clang_cc1 %s -fsyntax-only");
  }

  @Test
  public void test_va_arg_x86_32_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Sema/va_arg_x86_32.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -triple=i686-pc-linux-gnu ${LLVM_SRC}/llvm/tools/clang/test/Sema/va_arg_x86_32.c
    RUN("%clang_cc1 -fsyntax-only -verify -triple=i686-pc-linux-gnu %s");
  }

  @Test
  public void test_va_arg_x86_64_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Sema/va_arg_x86_64.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -triple=x86_64-unknown-freebsd7.0 ${LLVM_SRC}/llvm/tools/clang/test/Sema/va_arg_x86_64.c
    RUN("%clang_cc1 -fsyntax-only -verify -triple=x86_64-unknown-freebsd7.0 %s");
  }

  @Test
  public void test_var_redecl_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Sema/var-redecl.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/Sema/var-redecl.c
    RUN("%clang_cc1 -fsyntax-only -verify %s");
  }

  @Test
  public void test_varargs_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Sema/varargs.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/Sema/varargs.c
    RUN("%clang_cc1 -fsyntax-only -verify %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/Sema/varargs.c -triple x86_64-apple-darwin9
    RUN("%clang_cc1 -fsyntax-only -verify %s -triple x86_64-apple-darwin9");
  }

  @Test
  public void test_varargs_win64_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Sema/varargs-win64.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/Sema/varargs-win64.c -triple x86_64-pc-win32
    RUN("%clang_cc1 -fsyntax-only -verify %s -triple x86_64-pc-win32");
  }

  @Test
  public void test_varargs_x86_32_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Sema/varargs-x86-32.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/Sema/varargs-x86-32.c -triple i386-apple-darwin9
    RUN("%clang_cc1 -fsyntax-only -verify %s -triple i386-apple-darwin9");
  }

  @Test
  public void test_varargs_x86_64_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Sema/varargs-x86-64.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/Sema/varargs-x86-64.c -triple x86_64-apple-darwin9
    RUN("%clang_cc1 -fsyntax-only -verify %s -triple x86_64-apple-darwin9");
  }

  @Test
  public void test_varargs_unreachable_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Sema/varargs_unreachable.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/Sema/varargs_unreachable.c -triple x86_64-apple-darwin9
    RUN("%clang_cc1 -fsyntax-only -verify %s -triple x86_64-apple-darwin9");
  }

  @Test
  public void test_variadic_block_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Sema/variadic-block.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/Sema/variadic-block.c -verify -fsyntax-only -fblocks
    RUN("%clang_cc1 %s -verify -fsyntax-only -fblocks");
  }

  @Test
  public void test_variadic_incomplete_arg_type_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Sema/variadic-incomplete-arg-type.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/Sema/variadic-incomplete-arg-type.c -fsyntax-only -verify
    RUN("%clang_cc1 %s -fsyntax-only -verify");
  }

  @Test
  public void test_variadic_promotion_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Sema/variadic-promotion.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -ast-dump ${LLVM_SRC}/llvm/tools/clang/test/Sema/variadic-promotion.c | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Sema/variadic-promotion.c
    RUN("%clang_cc1 -ast-dump %s")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_vector_assign_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Sema/vector-assign.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/Sema/vector-assign.c -verify -fsyntax-only -Wvector-conversion
    RUN("%clang_cc1 %s -verify -fsyntax-only -Wvector-conversion");
  }

  @Test
  public void test_vector_cast_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Sema/vector-cast.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only ${LLVM_SRC}/llvm/tools/clang/test/Sema/vector-cast.c -verify -Wvector-conversion
    RUN("%clang_cc1 -fsyntax-only %s -verify -Wvector-conversion");
  }

  @Test
  public void test_vector_init_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Sema/vector-init.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/Sema/vector-init.c -fsyntax-only -verify
    RUN("%clang_cc1 %s -fsyntax-only -verify");
  }

  @Test
  public void test_vector_ops_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Sema/vector-ops.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/Sema/vector-ops.c -verify -fsyntax-only -Wvector-conversion
    RUN("%clang_cc1 %s -verify -fsyntax-only -Wvector-conversion");
  }

  @Test
  public void test_vfprintf_invalid_redecl_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Sema/vfprintf-invalid-redecl.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/Sema/vfprintf-invalid-redecl.c -fsyntax-only -verify
    RUN("%clang_cc1 %s -fsyntax-only -verify");
  }

  @Test
  public void test_vfprintf_valid_redecl_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Sema/vfprintf-valid-redecl.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/Sema/vfprintf-valid-redecl.c -fsyntax-only -pedantic -verify
    RUN("%clang_cc1 %s -fsyntax-only -pedantic -verify");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/Sema/vfprintf-valid-redecl.c -fsyntax-only -pedantic -verify -DPREDECLARE
    RUN("%clang_cc1 %s -fsyntax-only -pedantic -verify -DPREDECLARE");
  }

  @Test
  public void test_vla_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Sema/vla.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/Sema/vla.c -verify -fsyntax-only -pedantic
    RUN("%clang_cc1 %s -verify -fsyntax-only -pedantic");
  }

  @Test
  public void test_vla_2_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Sema/vla-2.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/Sema/vla-2.c -verify -fsyntax-only -pedantic
    RUN("%clang_cc1 %s -verify -fsyntax-only -pedantic");
  }

  @Test
  public void test_void_arg_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Sema/void_arg.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only ${LLVM_SRC}/llvm/tools/clang/test/Sema/void_arg.c -verify
    RUN("%clang_cc1 -fsyntax-only %s -verify");
  }

  @Test
  public void test_warn_absolute_value_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Sema/warn-absolute-value.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i686-pc-linux-gnu -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/Sema/warn-absolute-value.c -Wabsolute-value -Wno-int-conversion
    RUN("%clang_cc1 -triple i686-pc-linux-gnu -fsyntax-only -verify %s -Wabsolute-value -Wno-int-conversion");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i686-pc-linux-gnu -fsyntax-only ${LLVM_SRC}/llvm/tools/clang/test/Sema/warn-absolute-value.c -Wabsolute-value -Wno-int-conversion -fdiagnostics-parseable-fixits 2>&1 | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Sema/warn-absolute-value.c
    RUN("%clang_cc1 -triple i686-pc-linux-gnu -fsyntax-only %s -Wabsolute-value -Wno-int-conversion -fdiagnostics-parseable-fixits 2>&1")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_warn_absolute_value_header_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Sema/warn-absolute-value-header.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i686-pc-linux-gnu -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/Sema/warn-absolute-value-header.c -Wabsolute-value
    RUN("%clang_cc1 -triple i686-pc-linux-gnu -fsyntax-only -verify %s -Wabsolute-value");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i686-pc-linux-gnu -fsyntax-only ${LLVM_SRC}/llvm/tools/clang/test/Sema/warn-absolute-value-header.c -Wabsolute-value -fdiagnostics-parseable-fixits 2>&1 | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Sema/warn-absolute-value-header.c
    RUN("%clang_cc1 -triple i686-pc-linux-gnu -fsyntax-only %s -Wabsolute-value -fdiagnostics-parseable-fixits 2>&1")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_warn_bad_function_cast_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Sema/warn-bad-function-cast.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/Sema/warn-bad-function-cast.c -fsyntax-only -Wno-unused-value -Wbad-function-cast -triple x86_64-unknown-unknown -verify
    RUN("%clang_cc1 %s -fsyntax-only -Wno-unused-value -Wbad-function-cast -triple x86_64-unknown-unknown -verify");
  }

  @Test
  public void test_warn_bitwise_compare_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Sema/warn-bitwise-compare.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -Wtautological-compare ${LLVM_SRC}/llvm/tools/clang/test/Sema/warn-bitwise-compare.c
    RUN("%clang_cc1 -fsyntax-only -verify -Wtautological-compare %s");
  }

  @Test
  public void test_warn_cast_align_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Sema/warn-cast-align.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-apple-darwin10 -fsyntax-only -Wcast-align -verify ${LLVM_SRC}/llvm/tools/clang/test/Sema/warn-cast-align.c
    RUN("%clang_cc1 -triple x86_64-apple-darwin10 -fsyntax-only -Wcast-align -verify %s");
  }

  @Test
  public void test_warn_cast_qual_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Sema/warn-cast-qual.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-unknown-unknown -fsyntax-only -Wcast-qual -verify ${LLVM_SRC}/llvm/tools/clang/test/Sema/warn-cast-qual.c
    RUN("%clang_cc1 -triple x86_64-unknown-unknown -fsyntax-only -Wcast-qual -verify %s");
  }

  @Test
  public void test_warn_char_subscripts_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Sema/warn-char-subscripts.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -Wchar-subscripts -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/Sema/warn-char-subscripts.c
    RUN("%clang_cc1 -Wchar-subscripts -fsyntax-only -verify %s");
  }

  @Test
  public void test_warn_documentation_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Sema/warn-documentation.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c++11 -fsyntax-only -Wdocumentation -Wdocumentation-pedantic -verify ${LLVM_SRC}/llvm/tools/clang/test/Sema/warn-documentation.cpp
    RUN("%clang_cc1 -std=c++11 -fsyntax-only -Wdocumentation -Wdocumentation-pedantic -verify %s");
    // c-index-test -test-load-source all '-comments-xml-schema=${LLVM_SRC}/llvm/tools/clang/test/Sema/../../bindings/xml/comment-xml-schema.rng' ${LLVM_SRC}/llvm/tools/clang/test/Sema/warn-documentation.cpp | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Sema/warn-documentation.cpp -check-prefix=WRONG
    RUN("c-index-test -test-load-source all -comments-xml-schema=%S/../../bindings/xml/comment-xml-schema.rng %s")./*|*/
      I("FileCheck %s -check-prefix=WRONG");
  }

  @Test
  public void test_warn_documentation_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Sema/warn-documentation.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -fblocks -Wno-objc-root-class -Wdocumentation -Wdocumentation-pedantic -verify ${LLVM_SRC}/llvm/tools/clang/test/Sema/warn-documentation.m
    RUN("%clang_cc1 -fsyntax-only -fblocks -Wno-objc-root-class -Wdocumentation -Wdocumentation-pedantic -verify %s");
  }

  @Test
  public void test_warn_documentation_almost_trailing_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Sema/warn-documentation-almost-trailing.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -Wdocumentation -verify ${LLVM_SRC}/llvm/tools/clang/test/Sema/warn-documentation-almost-trailing.c
    RUN("%clang_cc1 -fsyntax-only -Wdocumentation -verify %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -Wdocumentation -fdiagnostics-parseable-fixits ${LLVM_SRC}/llvm/tools/clang/test/Sema/warn-documentation-almost-trailing.c 2>&1 | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Sema/warn-documentation-almost-trailing.c
    RUN("%clang_cc1 -fsyntax-only -Wdocumentation -fdiagnostics-parseable-fixits %s 2>&1")./*|*/
      I("FileCheck %s");
    // cp ${LLVM_SRC}/llvm/tools/clang/test/Sema/warn-documentation-almost-trailing.c ${TEST_TEMP_DIR}/warn-documentation-almost-trailing.c.tmp
    RUN("cp %s %t");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -Wdocumentation -fixit ${TEST_TEMP_DIR}/warn-documentation-almost-trailing.c.tmp
    RUN("%clang_cc1 -fsyntax-only -Wdocumentation -fixit %t");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -Wdocumentation -Werror ${TEST_TEMP_DIR}/warn-documentation-almost-trailing.c.tmp
    RUN("%clang_cc1 -fsyntax-only -Wdocumentation -Werror %t");
  }

  @Test
  public void test_warn_documentation_crlf_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Sema/warn-documentation-crlf.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -Wdocumentation ${LLVM_SRC}/llvm/tools/clang/test/Sema/warn-documentation-crlf.c
    RUN("%clang_cc1 -fsyntax-only -Wdocumentation %s");
  }

  @Test
  public void test_warn_documentation_fixits_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Sema/warn-documentation-fixits.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -Wdocumentation -Wdocumentation-pedantic -fcomment-block-commands=foobar -verify ${LLVM_SRC}/llvm/tools/clang/test/Sema/warn-documentation-fixits.cpp
    RUN("%clang_cc1 -fsyntax-only -Wdocumentation -Wdocumentation-pedantic -fcomment-block-commands=foobar -verify %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -Wdocumentation -Wdocumentation-pedantic -fcomment-block-commands=foobar -fdiagnostics-parseable-fixits ${LLVM_SRC}/llvm/tools/clang/test/Sema/warn-documentation-fixits.cpp 2>&1 | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Sema/warn-documentation-fixits.cpp
    RUN("%clang_cc1 -fsyntax-only -Wdocumentation -Wdocumentation-pedantic -fcomment-block-commands=foobar -fdiagnostics-parseable-fixits %s 2>&1")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_warn_documentation_unknown_command_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Sema/warn-documentation-unknown-command.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c++11 -fsyntax-only -Wdocumentation-unknown-command -verify ${LLVM_SRC}/llvm/tools/clang/test/Sema/warn-documentation-unknown-command.cpp
    RUN("%clang_cc1 -std=c++11 -fsyntax-only -Wdocumentation-unknown-command -verify %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c++11 -fsyntax-only -Werror -Wno-documentation-unknown-command ${LLVM_SRC}/llvm/tools/clang/test/Sema/warn-documentation-unknown-command.cpp
    RUN("%clang_cc1 -std=c++11 -fsyntax-only -Werror -Wno-documentation-unknown-command %s");
  }

  @Test
  public void test_warn_double_promotion_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Sema/warn-double-promotion.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -verify -fsyntax-only ${LLVM_SRC}/llvm/tools/clang/test/Sema/warn-double-promotion.c -Wdouble-promotion
    RUN("%clang_cc1 -verify -fsyntax-only %s -Wdouble-promotion");
  }

  @Test
  public void test_warn_duplicate_enum_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Sema/warn-duplicate-enum.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/Sema/warn-duplicate-enum.c -fsyntax-only -verify -Wduplicate-enum
    RUN("%clang_cc1 %s -fsyntax-only -verify -Wduplicate-enum");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/Sema/warn-duplicate-enum.c -x c++ -fsyntax-only -verify -Wduplicate-enum
    RUN("%clang_cc1 %s -x c++ -fsyntax-only -verify -Wduplicate-enum");
  }

  @Test
  public void test_warn_extern_main_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Sema/warn-extern-main.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/Sema/warn-extern-main.c -DTEST1
    RUN("%clang_cc1 -fsyntax-only -verify %s -DTEST1");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/Sema/warn-extern-main.c -DTEST2
    RUN("%clang_cc1 -fsyntax-only -verify %s -DTEST2");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/Sema/warn-extern-main.c -DTEST3
    RUN("%clang_cc1 -fsyntax-only -verify %s -DTEST3");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/Sema/warn-extern-main.c -DTEST4
    RUN("%clang_cc1 -fsyntax-only -verify %s -DTEST4");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/Sema/warn-extern-main.c -DTEST5
    RUN("%clang_cc1 -fsyntax-only -verify %s -DTEST5");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/Sema/warn-extern-main.c -DTEST6
    RUN("%clang_cc1 -fsyntax-only -verify %s -DTEST6");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/Sema/warn-extern-main.c -DTEST7
    RUN("%clang_cc1 -fsyntax-only -verify %s -DTEST7");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/Sema/warn-extern-main.c -DTEST8
    RUN("%clang_cc1 -fsyntax-only -verify %s -DTEST8");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/Sema/warn-extern-main.c -DTEST9 -ffreestanding
    RUN("%clang_cc1 -fsyntax-only -verify %s -DTEST9 -ffreestanding");
  }

  @Test
  public void test_warn_freestanding_complex_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Sema/warn-freestanding-complex.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -ffreestanding -pedantic -verify ${LLVM_SRC}/llvm/tools/clang/test/Sema/warn-freestanding-complex.c
    RUN("%clang_cc1 -fsyntax-only -ffreestanding -pedantic -verify %s");
  }

  @Test
  public void test_warn_gnu_designators_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Sema/warn-gnu-designators.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -Wno-gnu-designator -verify ${LLVM_SRC}/llvm/tools/clang/test/Sema/warn-gnu-designators.c
    RUN("%clang_cc1 -Wno-gnu-designator -verify %s");
  }

  @Test
  public void test_warn_logical_not_compare_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Sema/warn-logical-not-compare.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -Wlogical-not-parentheses -verify ${LLVM_SRC}/llvm/tools/clang/test/Sema/warn-logical-not-compare.c
    RUN("%clang_cc1 -fsyntax-only -Wlogical-not-parentheses -verify %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -Wlogical-not-parentheses -fdiagnostics-parseable-fixits ${LLVM_SRC}/llvm/tools/clang/test/Sema/warn-logical-not-compare.c 2>&1 | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Sema/warn-logical-not-compare.c
    RUN("%clang_cc1 -fsyntax-only -Wlogical-not-parentheses -fdiagnostics-parseable-fixits %s 2>&1")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_warn_main_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Sema/warn-main.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/Sema/warn-main.c
    RUN("%clang_cc1 -fsyntax-only -verify %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -fdiagnostics-parseable-fixits ${LLVM_SRC}/llvm/tools/clang/test/Sema/warn-main.c 2>&1 | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Sema/warn-main.c
    RUN("not %clang_cc1 -fsyntax-only -fdiagnostics-parseable-fixits %s 2>&1")./*|*/
      I("FileCheck %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -fdiagnostics-parseable-fixits -x c++ ${LLVM_SRC}/llvm/tools/clang/test/Sema/warn-main.c 2>&1 | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Sema/warn-main.c
    RUN("not %clang_cc1 -fsyntax-only -fdiagnostics-parseable-fixits -x c++ %s 2>&1")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_warn_main_return_type_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Sema/warn-main-return-type.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/Sema/warn-main-return-type.c
    RUN("%clang_cc1 -fsyntax-only -verify %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -fdiagnostics-parseable-fixits ${LLVM_SRC}/llvm/tools/clang/test/Sema/warn-main-return-type.c 2>&1 | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Sema/warn-main-return-type.c
    RUN("not %clang_cc1 -fsyntax-only -fdiagnostics-parseable-fixits %s 2>&1")./*|*/
      I("FileCheck %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -fdiagnostics-parseable-fixits -x c++ ${LLVM_SRC}/llvm/tools/clang/test/Sema/warn-main-return-type.c 2>&1 | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Sema/warn-main-return-type.c
    RUN("not %clang_cc1 -fsyntax-only -fdiagnostics-parseable-fixits -x c++ %s 2>&1")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_warn_missing_braces_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Sema/warn-missing-braces.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -Wmissing-braces -verify ${LLVM_SRC}/llvm/tools/clang/test/Sema/warn-missing-braces.c
    RUN("%clang_cc1 -fsyntax-only -Wmissing-braces -verify %s");
  }

  @Test
  public void test_warn_missing_prototypes_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Sema/warn-missing-prototypes.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -Wdocumentation -Wmissing-prototypes -verify ${LLVM_SRC}/llvm/tools/clang/test/Sema/warn-missing-prototypes.c
    RUN("%clang_cc1 -fsyntax-only -Wdocumentation -Wmissing-prototypes -verify %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -Wdocumentation -Wmissing-prototypes -fdiagnostics-parseable-fixits ${LLVM_SRC}/llvm/tools/clang/test/Sema/warn-missing-prototypes.c 2>&1 | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Sema/warn-missing-prototypes.c
    RUN("%clang_cc1 -fsyntax-only -Wdocumentation -Wmissing-prototypes -fdiagnostics-parseable-fixits %s 2>&1")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_warn_missing_variable_declarations_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Sema/warn-missing-variable-declarations.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -Wmissing-variable-declarations -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/Sema/warn-missing-variable-declarations.c
    RUN("%clang_cc1 -Wmissing-variable-declarations -fsyntax-only -verify %s");
  }

  @Test
  public void test_warn_null_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Sema/warn-null.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/Sema/warn-null.c -verify
    RUN("%clang_cc1 %s -verify");
  }

  @Test
  public void test_warn_outof_range_assign_enum_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Sema/warn-outof-range-assign-enum.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -Wassign-enum ${LLVM_SRC}/llvm/tools/clang/test/Sema/warn-outof-range-assign-enum.c
    RUN("%clang_cc1 -fsyntax-only -verify -Wassign-enum %s");
  }

  @Test
  public void test_warn_overlap_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Sema/warn-overlap.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -Wtautological-overlap-compare ${LLVM_SRC}/llvm/tools/clang/test/Sema/warn-overlap.c
    RUN("%clang_cc1 -fsyntax-only -verify -Wtautological-overlap-compare %s");
  }

  @Test
  public void test_warn_self_assign_field_mm() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Sema/warn-self-assign-field.mm");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -Wno-objc-root-class -verify ${LLVM_SRC}/llvm/tools/clang/test/Sema/warn-self-assign-field.mm
    RUN("%clang_cc1 -fsyntax-only -Wno-objc-root-class -verify %s");
  }

  @Test
  public void test_warn_shadow_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Sema/warn-shadow.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -verify -fsyntax-only -fblocks -Wshadow ${LLVM_SRC}/llvm/tools/clang/test/Sema/warn-shadow.c
    RUN("%clang_cc1 -verify -fsyntax-only -fblocks -Wshadow %s");
  }

  @Test
  public void test_warn_shadow_intrinsics_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Sema/warn-shadow-intrinsics.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -ffreestanding -triple x86_64-apple-macosx10.8.0 -fsyntax-only ${LLVM_SRC}/llvm/tools/clang/test/Sema/warn-shadow-intrinsics.c
    RUN("%clang_cc1 -ffreestanding -triple x86_64-apple-macosx10.8.0 -fsyntax-only %s");
  }

  @Test
  public void test_warn_shift_negative_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Sema/warn-shift-negative.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -Wshift-count-negative -fblocks -verify ${LLVM_SRC}/llvm/tools/clang/test/Sema/warn-shift-negative.c
    RUN("%clang_cc1 -fsyntax-only -Wshift-count-negative -fblocks -verify %s");
  }

  @Test
  public void test_warn_sizeof_array_decay_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Sema/warn-sizeof-array-decay.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/Sema/warn-sizeof-array-decay.c
    RUN("%clang_cc1 -fsyntax-only -verify %s");
  }

  @Test
  public void test_warn_sizeof_arrayarg_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Sema/warn-sizeof-arrayarg.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/Sema/warn-sizeof-arrayarg.c
    RUN("%clang_cc1 -fsyntax-only -verify %s");
  }

  @Test
  public void test_warn_string_conversion_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Sema/warn-string-conversion.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -verify -fsyntax-only -Wstring-conversion ${LLVM_SRC}/llvm/tools/clang/test/Sema/warn-string-conversion.c
    RUN("%clang_cc1 -verify -fsyntax-only -Wstring-conversion %s");
  }

  @Test
  public void test_warn_strlcpycat_size_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Sema/warn-strlcpycat-size.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -Wstrlcpy-strlcat-size -verify -fsyntax-only ${LLVM_SRC}/llvm/tools/clang/test/Sema/warn-strlcpycat-size.c
    RUN("%clang_cc1 -Wstrlcpy-strlcat-size -verify -fsyntax-only %s");
  }

  @Test
  public void test_warn_strncat_size_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Sema/warn-strncat-size.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -Wstrncat-size -verify -fsyntax-only ${LLVM_SRC}/llvm/tools/clang/test/Sema/warn-strncat-size.c
    RUN("%clang_cc1 -Wstrncat-size -verify -fsyntax-only %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -DUSE_BUILTINS -Wstrncat-size -verify -fsyntax-only ${LLVM_SRC}/llvm/tools/clang/test/Sema/warn-strncat-size.c
    RUN("%clang_cc1 -DUSE_BUILTINS -Wstrncat-size -verify -fsyntax-only %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -Wstrncat-size -fixit -x c ${LLVM_SRC}/llvm/tools/clang/test/Sema/warn-strncat-size.c
    RUN("%clang_cc1 -fsyntax-only -Wstrncat-size -fixit -x c %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -DUSE_BUILTINS -fsyntax-only -Wstrncat-size -fixit -x c ${LLVM_SRC}/llvm/tools/clang/test/Sema/warn-strncat-size.c
    RUN("%clang_cc1 -DUSE_BUILTINS -fsyntax-only -Wstrncat-size -fixit -x c %s");
  }

  @Test
  public void test_warn_tautological_compare_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Sema/warn-tautological-compare.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-apple-darwin -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/Sema/warn-tautological-compare.c
    RUN("%clang_cc1 -triple x86_64-apple-darwin -fsyntax-only -verify  %s");
  }

  @Test
  public void test_warn_thread_safety_analysis_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Sema/warn-thread-safety-analysis.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -Wthread-safety -Wthread-safety-beta ${LLVM_SRC}/llvm/tools/clang/test/Sema/warn-thread-safety-analysis.c
    RUN("%clang_cc1 -fsyntax-only -verify -Wthread-safety -Wthread-safety-beta %s");
  }

  @Test
  public void test_warn_type_safety_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Sema/warn-type-safety.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c99 -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/Sema/warn-type-safety.c
    RUN("%clang_cc1 -std=c99 -fsyntax-only -verify %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x c++ -std=c++98 -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/Sema/warn-type-safety.c
    RUN("%clang_cc1 -x c++ -std=c++98 -fsyntax-only -verify %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c99 -fno-signed-char -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/Sema/warn-type-safety.c
    RUN("%clang_cc1 -std=c99 -fno-signed-char -fsyntax-only -verify %s");
  }

  @Test
  public void test_warn_type_safety_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Sema/warn-type-safety.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c++11 -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/Sema/warn-type-safety.cpp
    RUN("%clang_cc1 -std=c++11 -fsyntax-only -verify %s");
  }

  @Test
  public void test_warn_type_safety_mpi_hdf5_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Sema/warn-type-safety-mpi-hdf5.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c99 -DOPEN_MPI -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/Sema/warn-type-safety-mpi-hdf5.c
    RUN("%clang_cc1 -std=c99 -DOPEN_MPI -fsyntax-only -verify %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c99 -DMPICH -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/Sema/warn-type-safety-mpi-hdf5.c
    RUN("%clang_cc1 -std=c99 -DMPICH -fsyntax-only -verify %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x c++ -std=c++98 -DOPEN_MPI -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/Sema/warn-type-safety-mpi-hdf5.c
    RUN("%clang_cc1 -x c++ -std=c++98 -DOPEN_MPI -fsyntax-only -verify %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x c++ -std=c++98 -DMPICH -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/Sema/warn-type-safety-mpi-hdf5.c
    RUN("%clang_cc1 -x c++ -std=c++98 -DMPICH -fsyntax-only -verify %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c99 -DOPEN_MPI -fno-signed-char -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/Sema/warn-type-safety-mpi-hdf5.c
    RUN("%clang_cc1 -std=c99 -DOPEN_MPI -fno-signed-char -fsyntax-only -verify %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c99 -DMPICH -fno-signed-char -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/Sema/warn-type-safety-mpi-hdf5.c
    RUN("%clang_cc1 -std=c99 -DMPICH -fno-signed-char -fsyntax-only -verify %s");
  }

  @Test
  public void test_warn_unreachable_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Sema/warn-unreachable.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/Sema/warn-unreachable.c -fsyntax-only -verify -fblocks -Wunreachable-code-aggressive -Wno-unused-value -Wno-covered-switch-default -I ${LLVM_SRC}/llvm/tools/clang/test/Sema/Inputs
    RUN(TestState.Failed, "%clang_cc1 %s -fsyntax-only -verify -fblocks -Wunreachable-code-aggressive -Wno-unused-value -Wno-covered-switch-default -I %S/Inputs");
  }

  @Test
  public void test_warn_unsequenced_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Sema/warn-unsequenced.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -std=c11 -Wno-unused ${LLVM_SRC}/llvm/tools/clang/test/Sema/warn-unsequenced.c
    RUN("%clang_cc1 -fsyntax-only -verify -std=c11 -Wno-unused %s");
  }

  @Test
  public void test_warn_unused_function_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Sema/warn-unused-function.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -Wused-but-marked-unused -Wunused-function -Wunneeded-internal-declaration -verify ${LLVM_SRC}/llvm/tools/clang/test/Sema/warn-unused-function.c
    RUN("%clang_cc1 -fsyntax-only -Wused-but-marked-unused -Wunused-function -Wunneeded-internal-declaration -verify %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -Wunused ${LLVM_SRC}/llvm/tools/clang/test/Sema/warn-unused-function.c
    RUN("%clang_cc1 -fsyntax-only -verify -Wunused %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -Wall -Wno-infinite-recursion ${LLVM_SRC}/llvm/tools/clang/test/Sema/warn-unused-function.c
    RUN("%clang_cc1 -fsyntax-only -verify -Wall -Wno-infinite-recursion %s");
  }

  @Test
  public void test_warn_unused_label_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Sema/warn-unused-label.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -Wunused-label -verify ${LLVM_SRC}/llvm/tools/clang/test/Sema/warn-unused-label.c
    RUN("%clang_cc1 -fsyntax-only -Wunused-label -verify %s");
  }

  @Test
  public void test_warn_unused_parameters_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Sema/warn-unused-parameters.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fblocks -fsyntax-only -Wunused-parameter ${LLVM_SRC}/llvm/tools/clang/test/Sema/warn-unused-parameters.c 2>&1 | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Sema/warn-unused-parameters.c
    RUN("%clang_cc1 -fblocks -fsyntax-only -Wunused-parameter %s 2>&1")./*|*/
      I("FileCheck %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fblocks -fsyntax-only -Wunused ${LLVM_SRC}/llvm/tools/clang/test/Sema/warn-unused-parameters.c 2>&1 | ${LLVM_SRC}/build/bin/FileCheck -check-prefix=CHECK-unused ${LLVM_SRC}/llvm/tools/clang/test/Sema/warn-unused-parameters.c
    RUN("%clang_cc1 -fblocks -fsyntax-only -Wunused %s 2>&1")./*|*/
      I("FileCheck -check-prefix=CHECK-unused %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fblocks -fsyntax-only -Weverything ${LLVM_SRC}/llvm/tools/clang/test/Sema/warn-unused-parameters.c 2>&1 | ${LLVM_SRC}/build/bin/FileCheck -check-prefix=CHECK-everything ${LLVM_SRC}/llvm/tools/clang/test/Sema/warn-unused-parameters.c
    RUN("%clang_cc1 -fblocks -fsyntax-only -Weverything %s 2>&1")./*|*/
      I("FileCheck -check-prefix=CHECK-everything %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fblocks -fsyntax-only -Weverything -Werror ${LLVM_SRC}/llvm/tools/clang/test/Sema/warn-unused-parameters.c 2>&1 | ${LLVM_SRC}/build/bin/FileCheck -check-prefix=CHECK-everything-error ${LLVM_SRC}/llvm/tools/clang/test/Sema/warn-unused-parameters.c
    RUN("not %clang_cc1 -fblocks -fsyntax-only -Weverything -Werror %s 2>&1")./*|*/
      I("FileCheck -check-prefix=CHECK-everything-error %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fblocks -fsyntax-only -Weverything -Wno-unused ${LLVM_SRC}/llvm/tools/clang/test/Sema/warn-unused-parameters.c 2>&1 | ${LLVM_SRC}/build/bin/FileCheck -check-prefix=CHECK-everything-no-unused ${LLVM_SRC}/llvm/tools/clang/test/Sema/warn-unused-parameters.c
    RUN("%clang_cc1 -fblocks -fsyntax-only -Weverything -Wno-unused %s 2>&1")./*|*/
      I("FileCheck -check-prefix=CHECK-everything-no-unused %s");
  }

  @Test
  public void test_warn_unused_value_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Sema/warn-unused-value.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c11 -fsyntax-only -verify -Wunused-value -Wunused-label ${LLVM_SRC}/llvm/tools/clang/test/Sema/warn-unused-value.c
    RUN("%clang_cc1 -std=c11 -fsyntax-only -verify -Wunused-value -Wunused-label %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c11 -fsyntax-only -verify -Wunused ${LLVM_SRC}/llvm/tools/clang/test/Sema/warn-unused-value.c
    RUN("%clang_cc1 -std=c11 -fsyntax-only -verify -Wunused %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c11 -fsyntax-only -verify -Wall ${LLVM_SRC}/llvm/tools/clang/test/Sema/warn-unused-value.c
    RUN("%clang_cc1 -std=c11 -fsyntax-only -verify -Wall %s");
  }

  @Test
  public void test_warn_unused_variables_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Sema/warn-unused-variables.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -Wunused-variable -fblocks -verify ${LLVM_SRC}/llvm/tools/clang/test/Sema/warn-unused-variables.c
    RUN("%clang_cc1 -fsyntax-only -Wunused-variable -fblocks -verify %s");
  }

  @Test
  public void test_warn_unused_variables_werror_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Sema/warn-unused-variables-werror.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -Wunused-variable -Werror -verify ${LLVM_SRC}/llvm/tools/clang/test/Sema/warn-unused-variables-werror.c
    RUN("%clang_cc1 -fsyntax-only -Wunused-variable -Werror -verify %s");
  }

  @Test
  public void test_warn_variable_not_needed_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Sema/warn-variable-not-needed.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -Wall ${LLVM_SRC}/llvm/tools/clang/test/Sema/warn-variable-not-needed.c
    RUN("%clang_cc1 -fsyntax-only -verify -Wall %s");
  }

  @Test
  public void test_warn_vla_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Sema/warn-vla.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c99 -fsyntax-only -verify -Wvla ${LLVM_SRC}/llvm/tools/clang/test/Sema/warn-vla.c
    RUN("%clang_cc1 -std=c99 -fsyntax-only -verify -Wvla %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c89 -fsyntax-only -verify -Wvla ${LLVM_SRC}/llvm/tools/clang/test/Sema/warn-vla.c
    RUN("%clang_cc1 -std=c89 -fsyntax-only -verify -Wvla %s");
  }

  @Test
  public void test_warn_write_strings_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Sema/warn-write-strings.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -verify -fsyntax-only -fconst-strings ${LLVM_SRC}/llvm/tools/clang/test/Sema/warn-write-strings.c
    RUN("%clang_cc1 -verify -fsyntax-only -fconst-strings %s");
  }

  @Test
  public void test_wchar_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Sema/wchar.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/Sema/wchar.c -fsyntax-only -verify
    RUN(isSolaris() ? TestState.Failed/*clang fails on Solaris*/ : TestState.Successful, "%clang_cc1 %s -fsyntax-only -verify");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/Sema/wchar.c -fsyntax-only -fshort-wchar -verify -DSHORT_WCHAR
    RUN("%clang_cc1 %s -fsyntax-only -fshort-wchar -verify -DSHORT_WCHAR");
  }

  @Test
  public void test_weak_import_on_enum_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Sema/weak-import-on-enum.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -triple x86_64-apple-darwin ${LLVM_SRC}/llvm/tools/clang/test/Sema/weak-import-on-enum.c
    RUN("%clang_cc1  -fsyntax-only -verify -triple x86_64-apple-darwin %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i386-apple-darwin9 -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/Sema/weak-import-on-enum.c
    RUN("%clang_cc1 -triple i386-apple-darwin9 -fsyntax-only -verify %s");
  }

  @Test
  public void test_x86_attr_force_align_arg_pointer_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Sema/x86-attr-force-align-arg-pointer.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i386-apple-darwin10 -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/Sema/x86-attr-force-align-arg-pointer.c
    RUN("%clang_cc1 -triple i386-apple-darwin10 -fsyntax-only -verify %s");
  }

  @Test
  public void test_x86_builtin_palignr_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Sema/x86-builtin-palignr.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -ffreestanding -fsyntax-only -target-feature +ssse3 -target-feature +mmx -verify -triple x86_64-pc-linux-gnu ${LLVM_SRC}/llvm/tools/clang/test/Sema/x86-builtin-palignr.c
    RUN("%clang_cc1 -ffreestanding -fsyntax-only -target-feature +ssse3 -target-feature +mmx -verify -triple x86_64-pc-linux-gnu %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -ffreestanding -fsyntax-only -target-feature +ssse3 -target-feature +mmx -verify -triple i686-apple-darwin10 ${LLVM_SRC}/llvm/tools/clang/test/Sema/x86-builtin-palignr.c
    RUN("%clang_cc1 -ffreestanding -fsyntax-only -target-feature +ssse3 -target-feature +mmx -verify -triple i686-apple-darwin10 %s");
  }

  @Test
  public void test_x86_64_linux_android_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Sema/x86_64-linux-android.c");
    // REQUIRES: x86-registered-target
    if (!CHECK_REQUIRES("x86-registered-target")) {
      return;
    }
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-linux-android -emit-pch -o ${TEST_TEMP_DIR}/x86_64-linux-android.c.tmp ${LLVM_SRC}/llvm/tools/clang/test/Sema/x86_64-linux-android.c
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-linux-android -emit-pch -o %t %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x ast -ast-print ${TEST_TEMP_DIR}/x86_64-linux-android.c.tmp | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Sema/x86_64-linux-android.c
    RUN(TestState.Failed, "%clang_cc1 -x ast -ast-print %t")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_xray_always_instrument_attr_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Sema/xray-always-instrument-attr.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/Sema/xray-always-instrument-attr.c -verify -fsyntax-only -std=c11
    RUN("%clang_cc1 %s -verify -fsyntax-only -std=c11");
  }

  @Test
  public void test_xray_always_instrument_attr_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Sema/xray-always-instrument-attr.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/Sema/xray-always-instrument-attr.cpp -verify -fsyntax-only -std=c++11 -x c++
    RUN("%clang_cc1 %s -verify -fsyntax-only -std=c++11 -x c++");
  }

  @Test
  public void test_zvector_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Sema/zvector.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple s390x-linux-gnu -fzvector -fno-lax-vector-conversions -W -Wall -Wconversion -Werror -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/Sema/zvector.c
    RUN("%clang_cc1 -triple s390x-linux-gnu -fzvector -fno-lax-vector-conversions -W -Wall -Wconversion -Werror -fsyntax-only -verify %s");
  }
  
}
