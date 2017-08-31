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
package org.clang.lex.test;
import org.clang.tools.driver.test.DriverTestFileBase;
import org.junit.*;

/**
 * Collection of all test files from test/Preprocessor folder
 * @author Vladimir Voskresensky
 */
public class AllPreprocessorTest extends DriverTestFileBase {
  private static final String TEST_LOCATION = "${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/";

  public AllPreprocessorTest() {
    super(TEST_LOCATION, DriverTestFileBase.TestState.Successful);
  }

  public static void main(String[] args) {
    // Print tests which will be accepted per test case
    DriverTestFileBase.printAllTestFiles(false, TEST_LOCATION, (test)->true, 
            "${SPUTNIK}/modules/org.clang.lex/test/unit/src/org/clang/lex/test/AllPreprocessorTest.txt");
  }

  @Override
  protected boolean keepStacksForUnimplementedMethods() {
    return false;
  }
  
  @Test
  public void test_Weverything_pragma_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/Weverything_pragma.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -Weverything -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/Weverything_pragma.c
    RUN("%clang_cc1 -Weverything   -fsyntax-only -verify %s");
  }

  @Test
  public void test__Pragma_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/_Pragma.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/_Pragma.c -verify -Wall
    RUN("%clang_cc1 %s -verify -Wall");
  }

  @Test
  public void test__Pragma_dependency_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/_Pragma-dependency.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -E -verify ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/_Pragma-dependency.c
    RUN("%clang_cc1 -E -verify %s");
  }

  @Test
  public void test__Pragma_dependency2_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/_Pragma-dependency2.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -E ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/_Pragma-dependency2.c -verify
    RUN("%clang_cc1 -E %s -verify");
  }

  @Test
  public void test__Pragma_in_macro_arg_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/_Pragma-in-macro-arg.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/_Pragma-in-macro-arg.c -verify -Wconversion
    RUN("%clang_cc1 %s -verify -Wconversion");
  }

  @Test
  public void test__Pragma_location_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/_Pragma-location.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/_Pragma-location.c -fms-extensions -E | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/_Pragma-location.c
    RUN("%clang_cc1 %s -fms-extensions -E")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test__Pragma_physloc_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/_Pragma-physloc.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -E ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/_Pragma-physloc.c | ${LLVM_SRC}/build/bin/FileCheck --strict-whitespace ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/_Pragma-physloc.c
    RUN("%clang_cc1 -E %s")./*|*/
      I("FileCheck --strict-whitespace %s");
  }

  @Test
  public void test_aarch64_target_features_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/aarch64-target-features.c");
    // ${LLVM_SRC}/build/bin/clang -target aarch64-none-linux-gnu -x c -E -dM ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/aarch64-target-features.c -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/aarch64-target-features.c
    RUN("%clang -target aarch64-none-linux-gnu -x c -E -dM %s -o -")./*|*/
      I("FileCheck %s");
    // ${LLVM_SRC}/build/bin/clang -target arm64-none-linux-gnu -x c -E -dM ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/aarch64-target-features.c -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/aarch64-target-features.c
    RUN("%clang -target arm64-none-linux-gnu -x c -E -dM %s -o -")./*|*/
      I("FileCheck %s");
    // ${LLVM_SRC}/build/bin/clang -target aarch64_be-eabi -x c -E -dM ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/aarch64-target-features.c -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/aarch64-target-features.c -check-prefix CHECK-BIGENDIAN
    RUN("%clang -target aarch64_be-eabi -x c -E -dM %s -o -")./*|*/
      I("FileCheck %s -check-prefix CHECK-BIGENDIAN");
    // ${LLVM_SRC}/build/bin/clang -target aarch64-none-linux-gnu -march=armv8-a+crypto -x c -E -dM ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/aarch64-target-features.c -o - | ${LLVM_SRC}/build/bin/FileCheck --check-prefix=CHECK-CRYPTO ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/aarch64-target-features.c
    RUN("%clang -target aarch64-none-linux-gnu -march=armv8-a+crypto -x c -E -dM %s -o -")./*|*/
      I("FileCheck --check-prefix=CHECK-CRYPTO %s");
    // ${LLVM_SRC}/build/bin/clang -target arm64-none-linux-gnu -march=armv8-a+crypto -x c -E -dM ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/aarch64-target-features.c -o - | ${LLVM_SRC}/build/bin/FileCheck --check-prefix=CHECK-CRYPTO ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/aarch64-target-features.c
    RUN("%clang -target arm64-none-linux-gnu -march=armv8-a+crypto -x c -E -dM %s -o -")./*|*/
      I("FileCheck --check-prefix=CHECK-CRYPTO %s");
    // ${LLVM_SRC}/build/bin/clang -target aarch64-none-linux-gnu -mcrc -x c -E -dM ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/aarch64-target-features.c -o - | ${LLVM_SRC}/build/bin/FileCheck --check-prefix=CHECK-CRC32 ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/aarch64-target-features.c
    RUN("%clang -target aarch64-none-linux-gnu -mcrc -x c -E -dM %s -o -")./*|*/
      I("FileCheck --check-prefix=CHECK-CRC32 %s");
    // ${LLVM_SRC}/build/bin/clang -target arm64-none-linux-gnu -mcrc -x c -E -dM ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/aarch64-target-features.c -o - | ${LLVM_SRC}/build/bin/FileCheck --check-prefix=CHECK-CRC32 ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/aarch64-target-features.c
    RUN("%clang -target arm64-none-linux-gnu -mcrc -x c -E -dM %s -o -")./*|*/
      I("FileCheck --check-prefix=CHECK-CRC32 %s");
    // ${LLVM_SRC}/build/bin/clang -target aarch64-none-linux-gnu -march=armv8-a+crc -x c -E -dM ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/aarch64-target-features.c -o - | ${LLVM_SRC}/build/bin/FileCheck --check-prefix=CHECK-CRC32 ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/aarch64-target-features.c
    RUN("%clang -target aarch64-none-linux-gnu -march=armv8-a+crc -x c -E -dM %s -o -")./*|*/
      I("FileCheck --check-prefix=CHECK-CRC32 %s");
    // ${LLVM_SRC}/build/bin/clang -target arm64-none-linux-gnu -march=armv8-a+crc -x c -E -dM ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/aarch64-target-features.c -o - | ${LLVM_SRC}/build/bin/FileCheck --check-prefix=CHECK-CRC32 ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/aarch64-target-features.c
    RUN("%clang -target arm64-none-linux-gnu -march=armv8-a+crc -x c -E -dM %s -o -")./*|*/
      I("FileCheck --check-prefix=CHECK-CRC32 %s");
    // ${LLVM_SRC}/build/bin/clang -target aarch64-none-linux-gnu -fno-math-errno -fno-signed-zeros -fno-trapping-math -fassociative-math -freciprocal-math -x c -E -dM ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/aarch64-target-features.c -o - | ${LLVM_SRC}/build/bin/FileCheck --check-prefix=CHECK-FASTMATH ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/aarch64-target-features.c
    RUN("%clang -target aarch64-none-linux-gnu -fno-math-errno -fno-signed-zeros -fno-trapping-math -fassociative-math -freciprocal-math -x c -E -dM %s -o -")./*|*/
      I("FileCheck --check-prefix=CHECK-FASTMATH %s");
    // ${LLVM_SRC}/build/bin/clang -target aarch64-none-linux-gnu -ffast-math -x c -E -dM ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/aarch64-target-features.c -o - | ${LLVM_SRC}/build/bin/FileCheck --check-prefix=CHECK-FASTMATH ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/aarch64-target-features.c
    RUN("%clang -target aarch64-none-linux-gnu -ffast-math -x c -E -dM %s -o -")./*|*/
      I("FileCheck --check-prefix=CHECK-FASTMATH %s");
    // ${LLVM_SRC}/build/bin/clang -target arm64-none-linux-gnu -ffast-math -x c -E -dM ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/aarch64-target-features.c -o - | ${LLVM_SRC}/build/bin/FileCheck --check-prefix=CHECK-FASTMATH ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/aarch64-target-features.c
    RUN("%clang -target arm64-none-linux-gnu -ffast-math -x c -E -dM %s -o -")./*|*/
      I("FileCheck --check-prefix=CHECK-FASTMATH %s");
    // ${LLVM_SRC}/build/bin/clang -target aarch64-none-linux-gnu -fshort-wchar -x c -E -dM ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/aarch64-target-features.c -o - | ${LLVM_SRC}/build/bin/FileCheck --check-prefix=CHECK-SHORTWCHAR ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/aarch64-target-features.c
    RUN("%clang -target aarch64-none-linux-gnu -fshort-wchar -x c -E -dM %s -o -")./*|*/
      I("FileCheck --check-prefix=CHECK-SHORTWCHAR %s");
    // ${LLVM_SRC}/build/bin/clang -target arm64-none-linux-gnu -fshort-wchar -x c -E -dM ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/aarch64-target-features.c -o - | ${LLVM_SRC}/build/bin/FileCheck --check-prefix=CHECK-SHORTWCHAR ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/aarch64-target-features.c
    RUN("%clang -target arm64-none-linux-gnu -fshort-wchar -x c -E -dM %s -o -")./*|*/
      I("FileCheck --check-prefix=CHECK-SHORTWCHAR %s");
    // ${LLVM_SRC}/build/bin/clang -target aarch64-none-linux-gnu -fshort-enums -x c -E -dM ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/aarch64-target-features.c -o - | ${LLVM_SRC}/build/bin/FileCheck --check-prefix=CHECK-SHORTENUMS ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/aarch64-target-features.c
    RUN("%clang -target aarch64-none-linux-gnu -fshort-enums -x c -E -dM %s -o -")./*|*/
      I("FileCheck --check-prefix=CHECK-SHORTENUMS %s");
    // ${LLVM_SRC}/build/bin/clang -target arm64-none-linux-gnu -fshort-enums -x c -E -dM ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/aarch64-target-features.c -o - | ${LLVM_SRC}/build/bin/FileCheck --check-prefix=CHECK-SHORTENUMS ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/aarch64-target-features.c
    RUN("%clang -target arm64-none-linux-gnu -fshort-enums -x c -E -dM %s -o -")./*|*/
      I("FileCheck --check-prefix=CHECK-SHORTENUMS %s");
    // ${LLVM_SRC}/build/bin/clang -target aarch64-none-linux-gnu -march=armv8-a+simd -x c -E -dM ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/aarch64-target-features.c -o - | ${LLVM_SRC}/build/bin/FileCheck --check-prefix=CHECK-NEON ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/aarch64-target-features.c
    RUN("%clang -target aarch64-none-linux-gnu -march=armv8-a+simd -x c -E -dM %s -o -")./*|*/
      I("FileCheck --check-prefix=CHECK-NEON %s");
    // ${LLVM_SRC}/build/bin/clang -target arm64-none-linux-gnu -march=armv8-a+simd -x c -E -dM ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/aarch64-target-features.c -o - | ${LLVM_SRC}/build/bin/FileCheck --check-prefix=CHECK-NEON ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/aarch64-target-features.c
    RUN("%clang -target arm64-none-linux-gnu -march=armv8-a+simd -x c -E -dM %s -o -")./*|*/
      I("FileCheck --check-prefix=CHECK-NEON %s");
    // ${LLVM_SRC}/build/bin/clang -target aarch64-none-eabi -march=armv8.1-a -x c -E -dM ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/aarch64-target-features.c -o - | ${LLVM_SRC}/build/bin/FileCheck --check-prefix=CHECK-V81A ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/aarch64-target-features.c
    RUN("%clang -target aarch64-none-eabi -march=armv8.1-a -x c -E -dM %s -o -")./*|*/
      I("FileCheck --check-prefix=CHECK-V81A %s");
    // ${LLVM_SRC}/build/bin/clang -target aarch64 -march=arm64 -### -c ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/aarch64-target-features.c 2>&1 | ${LLVM_SRC}/build/bin/FileCheck -check-prefix=CHECK-ARCH-NOT-ACCEPT ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/aarch64-target-features.c
    RUN("%clang -target aarch64 -march=arm64 -### -c %s 2>&1")./*|*/
      I("FileCheck -check-prefix=CHECK-ARCH-NOT-ACCEPT %s");
    // ${LLVM_SRC}/build/bin/clang -target aarch64 -march=aarch64 -### -c ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/aarch64-target-features.c 2>&1 | ${LLVM_SRC}/build/bin/FileCheck -check-prefix=CHECK-ARCH-NOT-ACCEPT ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/aarch64-target-features.c
    RUN("%clang -target aarch64 -march=aarch64 -### -c %s 2>&1")./*|*/
      I("FileCheck -check-prefix=CHECK-ARCH-NOT-ACCEPT %s");
    // ${LLVM_SRC}/build/bin/clang -target aarch64 -### -c ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/aarch64-target-features.c 2>&1 | ${LLVM_SRC}/build/bin/FileCheck -check-prefix=CHECK-GENERIC ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/aarch64-target-features.c
    RUN("%clang -target aarch64 -### -c %s 2>&1")./*|*/
      I("FileCheck -check-prefix=CHECK-GENERIC %s");
    // ${LLVM_SRC}/build/bin/clang -target aarch64 -march=armv8-a -### -c ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/aarch64-target-features.c 2>&1 | ${LLVM_SRC}/build/bin/FileCheck -check-prefix=CHECK-GENERIC ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/aarch64-target-features.c
    RUN("%clang -target aarch64 -march=armv8-a -### -c %s 2>&1")./*|*/
      I("FileCheck -check-prefix=CHECK-GENERIC %s");
    // ${LLVM_SRC}/build/bin/clang -target aarch64 -mtune=cyclone -### -c ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/aarch64-target-features.c 2>&1 | ${LLVM_SRC}/build/bin/FileCheck -check-prefix=CHECK-MTUNE-CYCLONE ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/aarch64-target-features.c
    RUN("%clang -target aarch64 -mtune=cyclone -### -c %s 2>&1")./*|*/
      I("FileCheck -check-prefix=CHECK-MTUNE-CYCLONE %s");
    // ${LLVM_SRC}/build/bin/clang -target aarch64 -mtune=CYCLONE -### -c ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/aarch64-target-features.c 2>&1 | ${LLVM_SRC}/build/bin/FileCheck -check-prefix=CHECK-MTUNE-CYCLONE ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/aarch64-target-features.c
    RUN("%clang -target aarch64 -mtune=CYCLONE -### -c %s 2>&1")./*|*/
      I("FileCheck -check-prefix=CHECK-MTUNE-CYCLONE %s");
    // ${LLVM_SRC}/build/bin/clang -target aarch64 -mcpu=cyclone -### -c ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/aarch64-target-features.c 2>&1 | ${LLVM_SRC}/build/bin/FileCheck -check-prefix=CHECK-MCPU-CYCLONE ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/aarch64-target-features.c
    RUN("%clang -target aarch64 -mcpu=cyclone -### -c %s 2>&1")./*|*/
      I("FileCheck -check-prefix=CHECK-MCPU-CYCLONE %s");
    // ${LLVM_SRC}/build/bin/clang -target aarch64 -mcpu=cortex-a35 -### -c ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/aarch64-target-features.c 2>&1 | ${LLVM_SRC}/build/bin/FileCheck -check-prefix=CHECK-MCPU-A35 ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/aarch64-target-features.c
    RUN("%clang -target aarch64 -mcpu=cortex-a35 -### -c %s 2>&1")./*|*/
      I("FileCheck -check-prefix=CHECK-MCPU-A35 %s");
    // ${LLVM_SRC}/build/bin/clang -target aarch64 -mcpu=cortex-a53 -### -c ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/aarch64-target-features.c 2>&1 | ${LLVM_SRC}/build/bin/FileCheck -check-prefix=CHECK-MCPU-A53 ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/aarch64-target-features.c
    RUN("%clang -target aarch64 -mcpu=cortex-a53 -### -c %s 2>&1")./*|*/
      I("FileCheck -check-prefix=CHECK-MCPU-A53 %s");
    // ${LLVM_SRC}/build/bin/clang -target aarch64 -mcpu=cortex-a57 -### -c ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/aarch64-target-features.c 2>&1 | ${LLVM_SRC}/build/bin/FileCheck -check-prefix=CHECK-MCPU-A57 ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/aarch64-target-features.c
    RUN("%clang -target aarch64 -mcpu=cortex-a57 -### -c %s 2>&1")./*|*/
      I("FileCheck -check-prefix=CHECK-MCPU-A57 %s");
    // ${LLVM_SRC}/build/bin/clang -target aarch64 -mcpu=cortex-a72 -### -c ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/aarch64-target-features.c 2>&1 | ${LLVM_SRC}/build/bin/FileCheck -check-prefix=CHECK-MCPU-A72 ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/aarch64-target-features.c
    RUN("%clang -target aarch64 -mcpu=cortex-a72 -### -c %s 2>&1")./*|*/
      I("FileCheck -check-prefix=CHECK-MCPU-A72 %s");
    // ${LLVM_SRC}/build/bin/clang -target aarch64 -mcpu=cortex-a73 -### -c ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/aarch64-target-features.c 2>&1 | ${LLVM_SRC}/build/bin/FileCheck -check-prefix=CHECK-MCPU-CORTEX-A73 ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/aarch64-target-features.c
    RUN("%clang -target aarch64 -mcpu=cortex-a73 -### -c %s 2>&1")./*|*/
      I("FileCheck -check-prefix=CHECK-MCPU-CORTEX-A73 %s");
    // ${LLVM_SRC}/build/bin/clang -target aarch64 -mcpu=exynos-m1 -### -c ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/aarch64-target-features.c 2>&1 | ${LLVM_SRC}/build/bin/FileCheck -check-prefix=CHECK-MCPU-M1 ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/aarch64-target-features.c
    RUN("%clang -target aarch64 -mcpu=exynos-m1 -### -c %s 2>&1")./*|*/
      I("FileCheck -check-prefix=CHECK-MCPU-M1 %s");
    // ${LLVM_SRC}/build/bin/clang -target aarch64 -mcpu=kryo -### -c ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/aarch64-target-features.c 2>&1 | ${LLVM_SRC}/build/bin/FileCheck -check-prefix=CHECK-MCPU-KRYO ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/aarch64-target-features.c
    RUN("%clang -target aarch64 -mcpu=kryo -### -c %s 2>&1")./*|*/
      I("FileCheck -check-prefix=CHECK-MCPU-KRYO %s");
    // ${LLVM_SRC}/build/bin/clang -target aarch64 -mcpu=vulcan -### -c ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/aarch64-target-features.c 2>&1 | ${LLVM_SRC}/build/bin/FileCheck -check-prefix=CHECK-MCPU-VULCAN ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/aarch64-target-features.c
    RUN("%clang -target aarch64 -mcpu=vulcan -### -c %s 2>&1")./*|*/
      I("FileCheck -check-prefix=CHECK-MCPU-VULCAN %s");
    // ${LLVM_SRC}/build/bin/clang -target x86_64-apple-macosx -arch arm64 -### -c ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/aarch64-target-features.c 2>&1 | ${LLVM_SRC}/build/bin/FileCheck --check-prefix=CHECK-ARCH-ARM64 ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/aarch64-target-features.c
    RUN("%clang -target x86_64-apple-macosx -arch arm64 -### -c %s 2>&1")./*|*/
      I("FileCheck --check-prefix=CHECK-ARCH-ARM64 %s");
    // ${LLVM_SRC}/build/bin/clang -target aarch64 -march=armv8-a+fp+simd+crc+crypto -### -c ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/aarch64-target-features.c 2>&1 | ${LLVM_SRC}/build/bin/FileCheck -check-prefix=CHECK-MARCH-1 ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/aarch64-target-features.c
    RUN("%clang -target aarch64 -march=armv8-a+fp+simd+crc+crypto -### -c %s 2>&1")./*|*/
      I("FileCheck -check-prefix=CHECK-MARCH-1 %s");
    // ${LLVM_SRC}/build/bin/clang -target aarch64 -march=armv8-a+nofp+nosimd+nocrc+nocrypto+fp+simd+crc+crypto -### -c ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/aarch64-target-features.c 2>&1 | ${LLVM_SRC}/build/bin/FileCheck -check-prefix=CHECK-MARCH-1 ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/aarch64-target-features.c
    RUN("%clang -target aarch64 -march=armv8-a+nofp+nosimd+nocrc+nocrypto+fp+simd+crc+crypto -### -c %s 2>&1")./*|*/
      I("FileCheck -check-prefix=CHECK-MARCH-1 %s");
    // ${LLVM_SRC}/build/bin/clang -target aarch64 -march=armv8-a+nofp+nosimd+nocrc+nocrypto -### -c ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/aarch64-target-features.c 2>&1 | ${LLVM_SRC}/build/bin/FileCheck -check-prefix=CHECK-MARCH-2 ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/aarch64-target-features.c
    RUN("%clang -target aarch64 -march=armv8-a+nofp+nosimd+nocrc+nocrypto -### -c %s 2>&1")./*|*/
      I("FileCheck -check-prefix=CHECK-MARCH-2 %s");
    // ${LLVM_SRC}/build/bin/clang -target aarch64 -march=armv8-a+fp+simd+crc+crypto+nofp+nosimd+nocrc+nocrypto -### -c ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/aarch64-target-features.c 2>&1 | ${LLVM_SRC}/build/bin/FileCheck -check-prefix=CHECK-MARCH-2 ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/aarch64-target-features.c
    RUN("%clang -target aarch64 -march=armv8-a+fp+simd+crc+crypto+nofp+nosimd+nocrc+nocrypto -### -c %s 2>&1")./*|*/
      I("FileCheck -check-prefix=CHECK-MARCH-2 %s");
    // ${LLVM_SRC}/build/bin/clang -target aarch64 -march=armv8-a+nosimd -### -c ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/aarch64-target-features.c 2>&1 | ${LLVM_SRC}/build/bin/FileCheck -check-prefix=CHECK-MARCH-3 ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/aarch64-target-features.c
    RUN("%clang -target aarch64 -march=armv8-a+nosimd -### -c %s 2>&1")./*|*/
      I("FileCheck -check-prefix=CHECK-MARCH-3 %s");
    // ${LLVM_SRC}/build/bin/clang -target aarch64 -mcpu=cyclone+nocrypto -### -c ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/aarch64-target-features.c 2>&1 | ${LLVM_SRC}/build/bin/FileCheck -check-prefix=CHECK-MCPU-1 ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/aarch64-target-features.c
    RUN("%clang -target aarch64 -mcpu=cyclone+nocrypto -### -c %s 2>&1")./*|*/
      I("FileCheck -check-prefix=CHECK-MCPU-1 %s");
    // ${LLVM_SRC}/build/bin/clang -target aarch64 -mcpu=cyclone+crypto+nocrypto -### -c ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/aarch64-target-features.c 2>&1 | ${LLVM_SRC}/build/bin/FileCheck -check-prefix=CHECK-MCPU-1 ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/aarch64-target-features.c
    RUN("%clang -target aarch64 -mcpu=cyclone+crypto+nocrypto -### -c %s 2>&1")./*|*/
      I("FileCheck -check-prefix=CHECK-MCPU-1 %s");
    // ${LLVM_SRC}/build/bin/clang -target aarch64 -mcpu=generic+crc -### -c ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/aarch64-target-features.c 2>&1 | ${LLVM_SRC}/build/bin/FileCheck -check-prefix=CHECK-MCPU-2 ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/aarch64-target-features.c
    RUN("%clang -target aarch64 -mcpu=generic+crc -### -c %s 2>&1")./*|*/
      I("FileCheck -check-prefix=CHECK-MCPU-2 %s");
    // ${LLVM_SRC}/build/bin/clang -target aarch64 -mcpu=generic+nocrc+crc -### -c ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/aarch64-target-features.c 2>&1 | ${LLVM_SRC}/build/bin/FileCheck -check-prefix=CHECK-MCPU-2 ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/aarch64-target-features.c
    RUN("%clang -target aarch64 -mcpu=generic+nocrc+crc -### -c %s 2>&1")./*|*/
      I("FileCheck -check-prefix=CHECK-MCPU-2 %s");
    // ${LLVM_SRC}/build/bin/clang -target aarch64 -mcpu=cortex-a53+nosimd -### -c ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/aarch64-target-features.c 2>&1 | ${LLVM_SRC}/build/bin/FileCheck -check-prefix=CHECK-MCPU-3 ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/aarch64-target-features.c
    RUN("%clang -target aarch64 -mcpu=cortex-a53+nosimd -### -c %s 2>&1")./*|*/
      I("FileCheck -check-prefix=CHECK-MCPU-3 %s");
    // ${LLVM_SRC}/build/bin/clang -target aarch64 -mcpu=cyclone+NOCRYPTO -### -c ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/aarch64-target-features.c 2>&1 | ${LLVM_SRC}/build/bin/FileCheck -check-prefix=CHECK-MCPU-1 ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/aarch64-target-features.c
    RUN("%clang -target aarch64 -mcpu=cyclone+NOCRYPTO -### -c %s 2>&1")./*|*/
      I("FileCheck -check-prefix=CHECK-MCPU-1 %s");
    // ${LLVM_SRC}/build/bin/clang -target aarch64 -mcpu=cyclone+CRYPTO+nocrypto -### -c ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/aarch64-target-features.c 2>&1 | ${LLVM_SRC}/build/bin/FileCheck -check-prefix=CHECK-MCPU-1 ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/aarch64-target-features.c
    RUN("%clang -target aarch64 -mcpu=cyclone+CRYPTO+nocrypto -### -c %s 2>&1")./*|*/
      I("FileCheck -check-prefix=CHECK-MCPU-1 %s");
    // ${LLVM_SRC}/build/bin/clang -target aarch64 -mcpu=generic+Crc -### -c ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/aarch64-target-features.c 2>&1 | ${LLVM_SRC}/build/bin/FileCheck -check-prefix=CHECK-MCPU-2 ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/aarch64-target-features.c
    RUN("%clang -target aarch64 -mcpu=generic+Crc -### -c %s 2>&1")./*|*/
      I("FileCheck -check-prefix=CHECK-MCPU-2 %s");
    // ${LLVM_SRC}/build/bin/clang -target aarch64 -mcpu=GENERIC+nocrc+CRC -### -c ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/aarch64-target-features.c 2>&1 | ${LLVM_SRC}/build/bin/FileCheck -check-prefix=CHECK-MCPU-2 ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/aarch64-target-features.c
    RUN("%clang -target aarch64 -mcpu=GENERIC+nocrc+CRC -### -c %s 2>&1")./*|*/
      I("FileCheck -check-prefix=CHECK-MCPU-2 %s");
    // ${LLVM_SRC}/build/bin/clang -target aarch64 -mcpu=cortex-a53+noSIMD -### -c ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/aarch64-target-features.c 2>&1 | ${LLVM_SRC}/build/bin/FileCheck -check-prefix=CHECK-MCPU-3 ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/aarch64-target-features.c
    RUN("%clang -target aarch64 -mcpu=cortex-a53+noSIMD -### -c %s 2>&1")./*|*/
      I("FileCheck -check-prefix=CHECK-MCPU-3 %s");
    // ${LLVM_SRC}/build/bin/clang -target aarch64 -mcpu=cyclone+nocrc+nocrypto -march=armv8-a -### -c ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/aarch64-target-features.c 2>&1 | ${LLVM_SRC}/build/bin/FileCheck -check-prefix=CHECK-MCPU-MARCH ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/aarch64-target-features.c
    RUN("%clang -target aarch64 -mcpu=cyclone+nocrc+nocrypto -march=armv8-a -### -c %s 2>&1")./*|*/
      I("FileCheck -check-prefix=CHECK-MCPU-MARCH %s");
    // ${LLVM_SRC}/build/bin/clang -target aarch64 -march=armv8-a -mcpu=cyclone+nocrc+nocrypto -### -c ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/aarch64-target-features.c 2>&1 | ${LLVM_SRC}/build/bin/FileCheck -check-prefix=CHECK-MCPU-MARCH ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/aarch64-target-features.c
    RUN("%clang -target aarch64 -march=armv8-a -mcpu=cyclone+nocrc+nocrypto  -### -c %s 2>&1")./*|*/
      I("FileCheck -check-prefix=CHECK-MCPU-MARCH %s");
    // ${LLVM_SRC}/build/bin/clang -target aarch64 -mcpu=cortex-a53 -mtune=cyclone -### -c ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/aarch64-target-features.c 2>&1 | ${LLVM_SRC}/build/bin/FileCheck -check-prefix=CHECK-MCPU-MTUNE ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/aarch64-target-features.c
    RUN("%clang -target aarch64 -mcpu=cortex-a53 -mtune=cyclone -### -c %s 2>&1")./*|*/
      I("FileCheck -check-prefix=CHECK-MCPU-MTUNE %s");
    // ${LLVM_SRC}/build/bin/clang -target aarch64 -mtune=cyclone -mcpu=cortex-a53 -### -c ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/aarch64-target-features.c 2>&1 | ${LLVM_SRC}/build/bin/FileCheck -check-prefix=CHECK-MCPU-MTUNE ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/aarch64-target-features.c
    RUN("%clang -target aarch64 -mtune=cyclone -mcpu=cortex-a53  -### -c %s 2>&1")./*|*/
      I("FileCheck -check-prefix=CHECK-MCPU-MTUNE %s");
    // ${LLVM_SRC}/build/bin/clang -target aarch64 -mcpu=cortex-a53 -mtune=CYCLONE -### -c ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/aarch64-target-features.c 2>&1 | ${LLVM_SRC}/build/bin/FileCheck -check-prefix=CHECK-MCPU-MTUNE ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/aarch64-target-features.c
    RUN("%clang -target aarch64 -mcpu=cortex-a53 -mtune=CYCLONE -### -c %s 2>&1")./*|*/
      I("FileCheck -check-prefix=CHECK-MCPU-MTUNE %s");
    // ${LLVM_SRC}/build/bin/clang -target aarch64 -mtune=CyclonE -mcpu=cortex-a53 -### -c ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/aarch64-target-features.c 2>&1 | ${LLVM_SRC}/build/bin/FileCheck -check-prefix=CHECK-MCPU-MTUNE ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/aarch64-target-features.c
    RUN("%clang -target aarch64 -mtune=CyclonE -mcpu=cortex-a53  -### -c %s 2>&1")./*|*/
      I("FileCheck -check-prefix=CHECK-MCPU-MTUNE %s");
    // ${LLVM_SRC}/build/bin/clang -target aarch64 -mcpu=generic+neon -### -c ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/aarch64-target-features.c 2>&1 | ${LLVM_SRC}/build/bin/FileCheck -check-prefix=CHECK-ERROR-NEON ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/aarch64-target-features.c
    RUN("%clang -target aarch64 -mcpu=generic+neon -### -c %s 2>&1")./*|*/
      I("FileCheck -check-prefix=CHECK-ERROR-NEON %s");
    // ${LLVM_SRC}/build/bin/clang -target aarch64 -mcpu=generic+noneon -### -c ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/aarch64-target-features.c 2>&1 | ${LLVM_SRC}/build/bin/FileCheck -check-prefix=CHECK-ERROR-NEON ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/aarch64-target-features.c
    RUN("%clang -target aarch64 -mcpu=generic+noneon -### -c %s 2>&1")./*|*/
      I("FileCheck -check-prefix=CHECK-ERROR-NEON %s");
    // ${LLVM_SRC}/build/bin/clang -target aarch64 -march=armv8-a+neon -### -c ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/aarch64-target-features.c 2>&1 | ${LLVM_SRC}/build/bin/FileCheck -check-prefix=CHECK-ERROR-NEON ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/aarch64-target-features.c
    RUN("%clang -target aarch64 -march=armv8-a+neon -### -c %s 2>&1")./*|*/
      I("FileCheck -check-prefix=CHECK-ERROR-NEON %s");
    // ${LLVM_SRC}/build/bin/clang -target aarch64 -march=armv8-a+noneon -### -c ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/aarch64-target-features.c 2>&1 | ${LLVM_SRC}/build/bin/FileCheck -check-prefix=CHECK-ERROR-NEON ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/aarch64-target-features.c
    RUN("%clang -target aarch64 -march=armv8-a+noneon -### -c %s 2>&1")./*|*/
      I("FileCheck -check-prefix=CHECK-ERROR-NEON %s");
    // ${LLVM_SRC}/build/bin/clang -target aarch64 -march=armv8.1a+crypto -### -c ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/aarch64-target-features.c 2>&1 | ${LLVM_SRC}/build/bin/FileCheck -check-prefix=CHECK-V81A-FEATURE-1 ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/aarch64-target-features.c
    RUN("%clang -target aarch64 -march=armv8.1a+crypto -### -c %s 2>&1")./*|*/
      I("FileCheck -check-prefix=CHECK-V81A-FEATURE-1 %s");
    // ${LLVM_SRC}/build/bin/clang -target aarch64 -march=armv8.1a+nocrypto -### -c ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/aarch64-target-features.c 2>&1 | ${LLVM_SRC}/build/bin/FileCheck -check-prefix=CHECK-V81A-FEATURE-2 ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/aarch64-target-features.c
    RUN("%clang -target aarch64 -march=armv8.1a+nocrypto -### -c %s 2>&1")./*|*/
      I("FileCheck -check-prefix=CHECK-V81A-FEATURE-2 %s");
    // ${LLVM_SRC}/build/bin/clang -target aarch64 -march=armv8.1a+nosimd -### -c ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/aarch64-target-features.c 2>&1 | ${LLVM_SRC}/build/bin/FileCheck -check-prefix=CHECK-V81A-FEATURE-3 ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/aarch64-target-features.c
    RUN("%clang -target aarch64 -march=armv8.1a+nosimd -### -c %s 2>&1")./*|*/
      I("FileCheck -check-prefix=CHECK-V81A-FEATURE-3 %s");
    // ${LLVM_SRC}/build/bin/clang -target aarch64 -march=ARMV8.1A+CRYPTO -### -c ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/aarch64-target-features.c 2>&1 | ${LLVM_SRC}/build/bin/FileCheck -check-prefix=CHECK-V81A-FEATURE-1 ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/aarch64-target-features.c
    RUN("%clang -target aarch64 -march=ARMV8.1A+CRYPTO -### -c %s 2>&1")./*|*/
      I("FileCheck -check-prefix=CHECK-V81A-FEATURE-1 %s");
    // ${LLVM_SRC}/build/bin/clang -target aarch64 -march=Armv8.1a+NOcrypto -### -c ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/aarch64-target-features.c 2>&1 | ${LLVM_SRC}/build/bin/FileCheck -check-prefix=CHECK-V81A-FEATURE-2 ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/aarch64-target-features.c
    RUN("%clang -target aarch64 -march=Armv8.1a+NOcrypto -### -c %s 2>&1")./*|*/
      I("FileCheck -check-prefix=CHECK-V81A-FEATURE-2 %s");
    // ${LLVM_SRC}/build/bin/clang -target aarch64 -march=armv8.1a+noSIMD -### -c ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/aarch64-target-features.c 2>&1 | ${LLVM_SRC}/build/bin/FileCheck -check-prefix=CHECK-V81A-FEATURE-3 ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/aarch64-target-features.c
    RUN("%clang -target aarch64 -march=armv8.1a+noSIMD -### -c %s 2>&1")./*|*/
      I("FileCheck -check-prefix=CHECK-V81A-FEATURE-3 %s");
  }

  @Test
  public void test_annotate_in_macro_arg_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/annotate_in_macro_arg.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -verify ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/annotate_in_macro_arg.c
    RUN("%clang_cc1 -verify %s");
  }

  @Test
  public void test_arm_acle_6_4_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/arm-acle-6.4.c");
    // ${LLVM_SRC}/build/bin/clang -target arm-eabi -x c -E -dM ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/arm-acle-6.4.c -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/arm-acle-6.4.c
    RUN("%clang -target arm-eabi -x c -E -dM %s -o -")./*|*/
      I("FileCheck %s");
    // ${LLVM_SRC}/build/bin/clang -target thumb-eabi -x c -E -dM ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/arm-acle-6.4.c -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/arm-acle-6.4.c
    RUN("%clang -target thumb-eabi -x c -E -dM %s -o -")./*|*/
      I("FileCheck %s");
    // ${LLVM_SRC}/build/bin/clang -target armeb-eabi -x c -E -dM ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/arm-acle-6.4.c -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/arm-acle-6.4.c -check-prefix CHECK-BIGENDIAN
    RUN("%clang -target armeb-eabi -x c -E -dM %s -o -")./*|*/
      I("FileCheck %s -check-prefix CHECK-BIGENDIAN");
    // ${LLVM_SRC}/build/bin/clang -target thumbeb-eabi -x c -E -dM ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/arm-acle-6.4.c -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/arm-acle-6.4.c -check-prefix CHECK-BIGENDIAN
    RUN("%clang -target thumbeb-eabi -x c -E -dM %s -o -")./*|*/
      I("FileCheck %s -check-prefix CHECK-BIGENDIAN");
    // ${LLVM_SRC}/build/bin/clang -target armv7-none-linux-eabi -mno-unaligned-access -x c -E -dM ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/arm-acle-6.4.c -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/arm-acle-6.4.c -check-prefix CHECK-UNALIGNED
    RUN("%clang -target armv7-none-linux-eabi -mno-unaligned-access -x c -E -dM %s -o -")./*|*/
      I("FileCheck %s -check-prefix CHECK-UNALIGNED");
    // ${LLVM_SRC}/build/bin/clang -target arm-none-linux-eabi -march=armv4 -x c -E -dM ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/arm-acle-6.4.c -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/arm-acle-6.4.c -check-prefix CHECK-V4
    RUN("%clang -target arm-none-linux-eabi -march=armv4 -x c -E -dM %s -o -")./*|*/
      I("FileCheck %s -check-prefix CHECK-V4");
    // ${LLVM_SRC}/build/bin/clang -target arm-none-linux-eabi -march=armv4t -x c -E -dM ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/arm-acle-6.4.c -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/arm-acle-6.4.c -check-prefix CHECK-V4T
    RUN("%clang -target arm-none-linux-eabi -march=armv4t -x c -E -dM %s -o -")./*|*/
      I("FileCheck %s -check-prefix CHECK-V4T");
    // ${LLVM_SRC}/build/bin/clang -target arm-none-linux-eabi -march=armv5t -x c -E -dM ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/arm-acle-6.4.c -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/arm-acle-6.4.c -check-prefix CHECK-V5
    RUN("%clang -target arm-none-linux-eabi -march=armv5t -x c -E -dM %s -o -")./*|*/
      I("FileCheck %s -check-prefix CHECK-V5");
    // ${LLVM_SRC}/build/bin/clang -target arm-none-linux-eabi -march=armv5te -x c -E -dM ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/arm-acle-6.4.c -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/arm-acle-6.4.c -check-prefix CHECK-V5E
    RUN("%clang -target arm-none-linux-eabi -march=armv5te -x c -E -dM %s -o -")./*|*/
      I("FileCheck %s -check-prefix CHECK-V5E");
    // ${LLVM_SRC}/build/bin/clang -target armv6-none-netbsd-eabi -mcpu=arm1136jf-s -x c -E -dM ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/arm-acle-6.4.c -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/arm-acle-6.4.c -check-prefix CHECK-V6
    RUN("%clang -target armv6-none-netbsd-eabi -mcpu=arm1136jf-s -x c -E -dM %s -o -")./*|*/
      I("FileCheck %s -check-prefix CHECK-V6");
    // ${LLVM_SRC}/build/bin/clang -target arm-none-linux-eabi -march=armv6m -x c -E -dM ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/arm-acle-6.4.c -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/arm-acle-6.4.c -check-prefix CHECK-V6M
    RUN("%clang -target arm-none-linux-eabi -march=armv6m -x c -E -dM %s -o -")./*|*/
      I("FileCheck %s -check-prefix CHECK-V6M");
    // ${LLVM_SRC}/build/bin/clang -target arm-none-linux-eabi -march=armv6t2 -x c -E -dM ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/arm-acle-6.4.c -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/arm-acle-6.4.c -check-prefix CHECK-V6T2
    RUN("%clang -target arm-none-linux-eabi -march=armv6t2 -x c -E -dM %s -o -")./*|*/
      I("FileCheck %s -check-prefix CHECK-V6T2");
    // ${LLVM_SRC}/build/bin/clang -target arm-none-linux-eabi -march=armv6k -x c -E -dM ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/arm-acle-6.4.c -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/arm-acle-6.4.c -check-prefix CHECK-V6K
    RUN("%clang -target arm-none-linux-eabi -march=armv6k -x c -E -dM %s -o -")./*|*/
      I("FileCheck %s -check-prefix CHECK-V6K");
    // ${LLVM_SRC}/build/bin/clang -target arm-none-linux-eabi -march=armv7-a -x c -E -dM ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/arm-acle-6.4.c -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/arm-acle-6.4.c -check-prefix CHECK-V7A
    RUN("%clang -target arm-none-linux-eabi -march=armv7-a -x c -E -dM %s -o -")./*|*/
      I("FileCheck %s -check-prefix CHECK-V7A");
    // ${LLVM_SRC}/build/bin/clang -target arm-none-linux-eabi -mcpu=cortex-a7 -x c -E -dM ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/arm-acle-6.4.c -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/arm-acle-6.4.c -check-prefix CHECK-V7A-IDIV
    RUN("%clang -target arm-none-linux-eabi -mcpu=cortex-a7 -x c -E -dM %s -o -")./*|*/
      I("FileCheck %s -check-prefix CHECK-V7A-IDIV");
    // ${LLVM_SRC}/build/bin/clang -target arm-none-linux-eabi -mcpu=cortex-a12 -x c -E -dM ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/arm-acle-6.4.c -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/arm-acle-6.4.c -check-prefix CHECK-V7A-IDIV
    RUN("%clang -target arm-none-linux-eabi -mcpu=cortex-a12 -x c -E -dM %s -o -")./*|*/
      I("FileCheck %s -check-prefix CHECK-V7A-IDIV");
    // ${LLVM_SRC}/build/bin/clang -target arm-none-linux-eabi -mcpu=cortex-a15 -x c -E -dM ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/arm-acle-6.4.c -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/arm-acle-6.4.c -check-prefix CHECK-V7A-IDIV
    RUN("%clang -target arm-none-linux-eabi -mcpu=cortex-a15 -x c -E -dM %s -o -")./*|*/
      I("FileCheck %s -check-prefix CHECK-V7A-IDIV");
    // ${LLVM_SRC}/build/bin/clang -target arm-none-linux-eabi -mcpu=cortex-a17 -x c -E -dM ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/arm-acle-6.4.c -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/arm-acle-6.4.c -check-prefix CHECK-V7A-IDIV
    RUN("%clang -target arm-none-linux-eabi -mcpu=cortex-a17 -x c -E -dM %s -o -")./*|*/
      I("FileCheck %s -check-prefix CHECK-V7A-IDIV");
    // ${LLVM_SRC}/build/bin/clang -target arm-none-linux-eabi -mcpu=cortex-a5 -x c -E -dM ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/arm-acle-6.4.c -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/arm-acle-6.4.c -check-prefix CHECK-V7A-NO-IDIV
    RUN("%clang -target arm-none-linux-eabi -mcpu=cortex-a5 -x c -E -dM %s -o -")./*|*/
      I("FileCheck %s -check-prefix CHECK-V7A-NO-IDIV");
    // ${LLVM_SRC}/build/bin/clang -target arm-none-linux-eabi -mcpu=cortex-a8 -x c -E -dM ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/arm-acle-6.4.c -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/arm-acle-6.4.c -check-prefix CHECK-V7A-NO-IDIV
    RUN("%clang -target arm-none-linux-eabi -mcpu=cortex-a8 -x c -E -dM %s -o -")./*|*/
      I("FileCheck %s -check-prefix CHECK-V7A-NO-IDIV");
    // ${LLVM_SRC}/build/bin/clang -target arm-none-linux-eabi -mcpu=cortex-a9 -x c -E -dM ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/arm-acle-6.4.c -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/arm-acle-6.4.c -check-prefix CHECK-V7A-NO-IDIV
    RUN("%clang -target arm-none-linux-eabi -mcpu=cortex-a9 -x c -E -dM %s -o -")./*|*/
      I("FileCheck %s -check-prefix CHECK-V7A-NO-IDIV");
    // ${LLVM_SRC}/build/bin/clang -target arm-none-linux-eabi -march=armv7-r -x c -E -dM ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/arm-acle-6.4.c -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/arm-acle-6.4.c -check-prefix CHECK-V7R
    RUN("%clang -target arm-none-linux-eabi -march=armv7-r -x c -E -dM %s -o -")./*|*/
      I("FileCheck %s -check-prefix CHECK-V7R");
    // ${LLVM_SRC}/build/bin/clang -target arm-none-linux-eabi -mcpu=cortex-r4 -x c -E -dM ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/arm-acle-6.4.c -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/arm-acle-6.4.c -check-prefix CHECK-V7R-NO-IDIV
    RUN("%clang -target arm-none-linux-eabi -mcpu=cortex-r4 -x c -E -dM %s -o -")./*|*/
      I("FileCheck %s -check-prefix CHECK-V7R-NO-IDIV");
    // ${LLVM_SRC}/build/bin/clang -target arm-none-linux-eabi -mcpu=cortex-r5 -x c -E -dM ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/arm-acle-6.4.c -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/arm-acle-6.4.c -check-prefix CHECK-V7R-IDIV
    RUN("%clang -target arm-none-linux-eabi -mcpu=cortex-r5 -x c -E -dM %s -o -")./*|*/
      I("FileCheck %s -check-prefix CHECK-V7R-IDIV");
    // ${LLVM_SRC}/build/bin/clang -target arm-none-linux-eabi -mcpu=cortex-r7 -x c -E -dM ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/arm-acle-6.4.c -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/arm-acle-6.4.c -check-prefix CHECK-V7R-IDIV
    RUN("%clang -target arm-none-linux-eabi -mcpu=cortex-r7 -x c -E -dM %s -o -")./*|*/
      I("FileCheck %s -check-prefix CHECK-V7R-IDIV");
    // ${LLVM_SRC}/build/bin/clang -target arm-none-linux-eabi -mcpu=cortex-r8 -x c -E -dM ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/arm-acle-6.4.c -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/arm-acle-6.4.c -check-prefix CHECK-V7R-IDIV
    RUN("%clang -target arm-none-linux-eabi -mcpu=cortex-r8 -x c -E -dM %s -o -")./*|*/
      I("FileCheck %s -check-prefix CHECK-V7R-IDIV");
    // ${LLVM_SRC}/build/bin/clang -target arm-none-linux-eabi -march=armv7-m -x c -E -dM ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/arm-acle-6.4.c -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/arm-acle-6.4.c -check-prefix CHECK-V7M
    RUN("%clang -target arm-none-linux-eabi -march=armv7-m -x c -E -dM %s -o -")./*|*/
      I("FileCheck %s -check-prefix CHECK-V7M");
    // ${LLVM_SRC}/build/bin/clang -target arm-none-linux-eabi -march=armv7e-m -x c -E -dM ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/arm-acle-6.4.c -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/arm-acle-6.4.c -check-prefix CHECK-V7EM
    RUN("%clang -target arm-none-linux-eabi -march=armv7e-m -x c -E -dM %s -o -")./*|*/
      I("FileCheck %s -check-prefix CHECK-V7EM");
    // ${LLVM_SRC}/build/bin/clang -target arm-none-linux-eabi -march=armv8-a -x c -E -dM ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/arm-acle-6.4.c -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/arm-acle-6.4.c -check-prefix CHECK-V8A
    RUN("%clang -target arm-none-linux-eabi -march=armv8-a -x c -E -dM %s -o -")./*|*/
      I("FileCheck %s -check-prefix CHECK-V8A");
  }

  @Test
  public void test_arm_acle_6_5_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/arm-acle-6.5.c");
    // ${LLVM_SRC}/build/bin/clang -target arm-eabi -mfpu=none -x c -E -dM ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/arm-acle-6.5.c -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/arm-acle-6.5.c -check-prefix CHECK-NO-FP
    RUN("%clang -target arm-eabi -mfpu=none -x c -E -dM %s -o -")./*|*/
      I("FileCheck %s -check-prefix CHECK-NO-FP");
    // ${LLVM_SRC}/build/bin/clang -target armv4-eabi -x c -E -dM ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/arm-acle-6.5.c -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/arm-acle-6.5.c -check-prefix CHECK-NO-FP
    RUN("%clang -target armv4-eabi -x c -E -dM %s -o -")./*|*/
      I("FileCheck %s -check-prefix CHECK-NO-FP");
    // ${LLVM_SRC}/build/bin/clang -target armv5-eabi -x c -E -dM ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/arm-acle-6.5.c -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/arm-acle-6.5.c -check-prefix CHECK-NO-FP
    RUN("%clang -target armv5-eabi -x c -E -dM %s -o -")./*|*/
      I("FileCheck %s -check-prefix CHECK-NO-FP");
    // ${LLVM_SRC}/build/bin/clang -target armv6m-eabi -x c -E -dM ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/arm-acle-6.5.c -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/arm-acle-6.5.c -check-prefix CHECK-NO-FP
    RUN("%clang -target armv6m-eabi -x c -E -dM %s -o -")./*|*/
      I("FileCheck %s -check-prefix CHECK-NO-FP");
    // ${LLVM_SRC}/build/bin/clang -target armv7r-eabi -x c -E -dM ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/arm-acle-6.5.c -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/arm-acle-6.5.c -check-prefix CHECK-NO-FP
    RUN("%clang -target armv7r-eabi -x c -E -dM %s -o -")./*|*/
      I("FileCheck %s -check-prefix CHECK-NO-FP");
    // ${LLVM_SRC}/build/bin/clang -target armv7m-eabi -x c -E -dM ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/arm-acle-6.5.c -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/arm-acle-6.5.c -check-prefix CHECK-NO-FP
    RUN("%clang -target armv7m-eabi -x c -E -dM %s -o -")./*|*/
      I("FileCheck %s -check-prefix CHECK-NO-FP");
    // ${LLVM_SRC}/build/bin/clang -target arm-eabi -mfpu=vfpv3xd -x c -E -dM ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/arm-acle-6.5.c -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/arm-acle-6.5.c -check-prefix CHECK-SP-ONLY
    RUN("%clang -target arm-eabi -mfpu=vfpv3xd -x c -E -dM %s -o -")./*|*/
      I("FileCheck %s -check-prefix CHECK-SP-ONLY");
    // ${LLVM_SRC}/build/bin/clang -target arm-eabi -mfpu=vfpv3xd-fp16 -x c -E -dM ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/arm-acle-6.5.c -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/arm-acle-6.5.c -check-prefix CHECK-SP-HP
    RUN("%clang -target arm-eabi -mfpu=vfpv3xd-fp16 -x c -E -dM %s -o -")./*|*/
      I("FileCheck %s -check-prefix CHECK-SP-HP");
    // ${LLVM_SRC}/build/bin/clang -target arm-eabi -mfpu=fpv4-sp-d16 -x c -E -dM ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/arm-acle-6.5.c -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/arm-acle-6.5.c -check-prefix CHECK-SP-HP
    RUN("%clang -target arm-eabi -mfpu=fpv4-sp-d16 -x c -E -dM %s -o -")./*|*/
      I("FileCheck %s -check-prefix CHECK-SP-HP");
    // ${LLVM_SRC}/build/bin/clang -target arm-eabi -mfpu=fpv5-sp-d16 -x c -E -dM ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/arm-acle-6.5.c -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/arm-acle-6.5.c -check-prefix CHECK-SP-HP
    RUN("%clang -target arm-eabi -mfpu=fpv5-sp-d16 -x c -E -dM %s -o -")./*|*/
      I("FileCheck %s -check-prefix CHECK-SP-HP");
    // ${LLVM_SRC}/build/bin/clang -target arm-eabi -mfpu=vfp -x c -E -dM ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/arm-acle-6.5.c -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/arm-acle-6.5.c -check-prefix CHECK-SP-DP
    RUN("%clang -target arm-eabi -mfpu=vfp -x c -E -dM %s -o -")./*|*/
      I("FileCheck %s -check-prefix CHECK-SP-DP");
    // ${LLVM_SRC}/build/bin/clang -target arm-eabi -mfpu=vfpv2 -x c -E -dM ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/arm-acle-6.5.c -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/arm-acle-6.5.c -check-prefix CHECK-SP-DP
    RUN("%clang -target arm-eabi -mfpu=vfpv2 -x c -E -dM %s -o -")./*|*/
      I("FileCheck %s -check-prefix CHECK-SP-DP");
    // ${LLVM_SRC}/build/bin/clang -target arm-eabi -mfpu=vfpv3 -x c -E -dM ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/arm-acle-6.5.c -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/arm-acle-6.5.c -check-prefix CHECK-SP-DP
    RUN("%clang -target arm-eabi -mfpu=vfpv3 -x c -E -dM %s -o -")./*|*/
      I("FileCheck %s -check-prefix CHECK-SP-DP");
    // ${LLVM_SRC}/build/bin/clang -target arm-eabi -mfpu=vfp3-d16 -x c -E -dM ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/arm-acle-6.5.c -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/arm-acle-6.5.c -check-prefix CHECK-SP-DP
    RUN("%clang -target arm-eabi -mfpu=vfp3-d16 -x c -E -dM %s -o -")./*|*/
      I("FileCheck %s -check-prefix CHECK-SP-DP");
    // ${LLVM_SRC}/build/bin/clang -target arm-eabi -mfpu=neon -x c -E -dM ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/arm-acle-6.5.c -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/arm-acle-6.5.c -check-prefix CHECK-SP-DP
    RUN("%clang -target arm-eabi -mfpu=neon -x c -E -dM %s -o -")./*|*/
      I("FileCheck %s -check-prefix CHECK-SP-DP");
    // ${LLVM_SRC}/build/bin/clang -target armv6-eabi -x c -E -dM ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/arm-acle-6.5.c -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/arm-acle-6.5.c -check-prefix CHECK-SP-DP
    RUN("%clang -target armv6-eabi -x c -E -dM %s -o -")./*|*/
      I("FileCheck %s -check-prefix CHECK-SP-DP");
    // ${LLVM_SRC}/build/bin/clang -target armv7a-eabi -x c -E -dM ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/arm-acle-6.5.c -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/arm-acle-6.5.c -check-prefix CHECK-SP-DP
    RUN("%clang -target armv7a-eabi -x c -E -dM %s -o -")./*|*/
      I("FileCheck %s -check-prefix CHECK-SP-DP");
    // ${LLVM_SRC}/build/bin/clang -target arm-eabi -mfpu=vfpv3-fp16 -x c -E -dM ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/arm-acle-6.5.c -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/arm-acle-6.5.c -check-prefix CHECK-SP-DP-HP
    RUN("%clang -target arm-eabi -mfpu=vfpv3-fp16 -x c -E -dM %s -o -")./*|*/
      I("FileCheck %s -check-prefix CHECK-SP-DP-HP");
    // ${LLVM_SRC}/build/bin/clang -target arm-eabi -mfpu=vfpv3-d16-fp16 -x c -E -dM ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/arm-acle-6.5.c -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/arm-acle-6.5.c -check-prefix CHECK-SP-DP-HP
    RUN("%clang -target arm-eabi -mfpu=vfpv3-d16-fp16 -x c -E -dM %s -o -")./*|*/
      I("FileCheck %s -check-prefix CHECK-SP-DP-HP");
    // ${LLVM_SRC}/build/bin/clang -target arm-eabi -mfpu=vfpv4 -x c -E -dM ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/arm-acle-6.5.c -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/arm-acle-6.5.c -check-prefix CHECK-SP-DP-HP
    RUN("%clang -target arm-eabi -mfpu=vfpv4 -x c -E -dM %s -o -")./*|*/
      I("FileCheck %s -check-prefix CHECK-SP-DP-HP");
    // ${LLVM_SRC}/build/bin/clang -target arm-eabi -mfpu=vfpv4-d16 -x c -E -dM ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/arm-acle-6.5.c -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/arm-acle-6.5.c -check-prefix CHECK-SP-DP-HP
    RUN("%clang -target arm-eabi -mfpu=vfpv4-d16 -x c -E -dM %s -o -")./*|*/
      I("FileCheck %s -check-prefix CHECK-SP-DP-HP");
    // ${LLVM_SRC}/build/bin/clang -target arm-eabi -mfpu=fpv5-d16 -x c -E -dM ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/arm-acle-6.5.c -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/arm-acle-6.5.c -check-prefix CHECK-SP-DP-HP
    RUN("%clang -target arm-eabi -mfpu=fpv5-d16 -x c -E -dM %s -o -")./*|*/
      I("FileCheck %s -check-prefix CHECK-SP-DP-HP");
    // ${LLVM_SRC}/build/bin/clang -target arm-eabi -mfpu=fp-armv8 -x c -E -dM ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/arm-acle-6.5.c -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/arm-acle-6.5.c -check-prefix CHECK-SP-DP-HP
    RUN("%clang -target arm-eabi -mfpu=fp-armv8 -x c -E -dM %s -o -")./*|*/
      I("FileCheck %s -check-prefix CHECK-SP-DP-HP");
    // ${LLVM_SRC}/build/bin/clang -target arm-eabi -mfpu=neon-fp16 -x c -E -dM ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/arm-acle-6.5.c -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/arm-acle-6.5.c -check-prefix CHECK-SP-DP-HP
    RUN("%clang -target arm-eabi -mfpu=neon-fp16 -x c -E -dM %s -o -")./*|*/
      I("FileCheck %s -check-prefix CHECK-SP-DP-HP");
    // ${LLVM_SRC}/build/bin/clang -target arm-eabi -mfpu=neon-vfpv4 -x c -E -dM ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/arm-acle-6.5.c -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/arm-acle-6.5.c -check-prefix CHECK-SP-DP-HP
    RUN("%clang -target arm-eabi -mfpu=neon-vfpv4 -x c -E -dM %s -o -")./*|*/
      I("FileCheck %s -check-prefix CHECK-SP-DP-HP");
    // ${LLVM_SRC}/build/bin/clang -target arm-eabi -mfpu=neon-fp-armv8 -x c -E -dM ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/arm-acle-6.5.c -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/arm-acle-6.5.c -check-prefix CHECK-SP-DP-HP
    RUN("%clang -target arm-eabi -mfpu=neon-fp-armv8 -x c -E -dM %s -o -")./*|*/
      I("FileCheck %s -check-prefix CHECK-SP-DP-HP");
    // ${LLVM_SRC}/build/bin/clang -target arm-eabi -mfpu=crypto-neon-fp-armv8 -x c -E -dM ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/arm-acle-6.5.c -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/arm-acle-6.5.c -check-prefix CHECK-SP-DP-HP
    RUN("%clang -target arm-eabi -mfpu=crypto-neon-fp-armv8 -x c -E -dM %s -o -")./*|*/
      I("FileCheck %s -check-prefix CHECK-SP-DP-HP");
    // ${LLVM_SRC}/build/bin/clang -target armv8-eabi -x c -E -dM ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/arm-acle-6.5.c -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/arm-acle-6.5.c -check-prefix CHECK-SP-DP-HP
    RUN("%clang -target armv8-eabi -x c -E -dM %s -o -")./*|*/
      I("FileCheck %s -check-prefix CHECK-SP-DP-HP");
    // ${LLVM_SRC}/build/bin/clang -target armv4-eabi -x c -E -dM ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/arm-acle-6.5.c -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/arm-acle-6.5.c -check-prefix CHECK-NO-FMA
    RUN("%clang -target armv4-eabi -x c -E -dM %s -o -")./*|*/
      I("FileCheck %s -check-prefix CHECK-NO-FMA");
    // ${LLVM_SRC}/build/bin/clang -target armv5-eabi -x c -E -dM ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/arm-acle-6.5.c -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/arm-acle-6.5.c -check-prefix CHECK-NO-FMA
    RUN("%clang -target armv5-eabi -x c -E -dM %s -o -")./*|*/
      I("FileCheck %s -check-prefix CHECK-NO-FMA");
    // ${LLVM_SRC}/build/bin/clang -target armv6-eabi -x c -E -dM ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/arm-acle-6.5.c -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/arm-acle-6.5.c -check-prefix CHECK-NO-FMA
    RUN("%clang -target armv6-eabi -x c -E -dM %s -o -")./*|*/
      I("FileCheck %s -check-prefix CHECK-NO-FMA");
    // ${LLVM_SRC}/build/bin/clang -target armv6m-eabi -x c -E -dM ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/arm-acle-6.5.c -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/arm-acle-6.5.c -check-prefix CHECK-NO-FMA
    RUN("%clang -target armv6m-eabi -x c -E -dM %s -o -")./*|*/
      I("FileCheck %s -check-prefix CHECK-NO-FMA");
    // ${LLVM_SRC}/build/bin/clang -target armv7m-eabi -x c -E -dM ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/arm-acle-6.5.c -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/arm-acle-6.5.c -check-prefix CHECK-NO-FMA
    RUN("%clang -target armv7m-eabi -x c -E -dM %s -o -")./*|*/
      I("FileCheck %s -check-prefix CHECK-NO-FMA");
    // ${LLVM_SRC}/build/bin/clang -target armv7a-eabi -x c -E -dM ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/arm-acle-6.5.c -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/arm-acle-6.5.c -check-prefix CHECK-NO-FMA
    RUN("%clang -target armv7a-eabi -x c -E -dM %s -o -")./*|*/
      I("FileCheck %s -check-prefix CHECK-NO-FMA");
    // ${LLVM_SRC}/build/bin/clang -target armv7a-eabi -mfpu=vfpv4 -x c -E -dM ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/arm-acle-6.5.c -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/arm-acle-6.5.c -check-prefix CHECK-FMA
    RUN("%clang -target armv7a-eabi -mfpu=vfpv4 -x c -E -dM %s -o -")./*|*/
      I("FileCheck %s -check-prefix CHECK-FMA");
    // ${LLVM_SRC}/build/bin/clang -target armv7r-eabi -x c -E -dM ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/arm-acle-6.5.c -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/arm-acle-6.5.c -check-prefix CHECK-NO-FMA
    RUN("%clang -target armv7r-eabi -x c -E -dM %s -o -")./*|*/
      I("FileCheck %s -check-prefix CHECK-NO-FMA");
    // ${LLVM_SRC}/build/bin/clang -target armv7r-eabi -mfpu=vfpv4 -x c -E -dM ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/arm-acle-6.5.c -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/arm-acle-6.5.c -check-prefix CHECK-FMA
    RUN("%clang -target armv7r-eabi -mfpu=vfpv4 -x c -E -dM %s -o -")./*|*/
      I("FileCheck %s -check-prefix CHECK-FMA");
    // ${LLVM_SRC}/build/bin/clang -target armv7em-eabi -x c -E -dM ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/arm-acle-6.5.c -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/arm-acle-6.5.c -check-prefix CHECK-FMA
    RUN("%clang -target armv7em-eabi -x c -E -dM %s -o -")./*|*/
      I("FileCheck %s -check-prefix CHECK-FMA");
    // ${LLVM_SRC}/build/bin/clang -target armv8-eabi -x c -E -dM ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/arm-acle-6.5.c -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/arm-acle-6.5.c -check-prefix CHECK-NO-FMA
    RUN("%clang -target armv8-eabi -x c -E -dM %s -o -")./*|*/
      I("FileCheck %s -check-prefix CHECK-NO-FMA");
    // ${LLVM_SRC}/build/bin/clang -target armv8-eabi -mfpu=vfpv4 -x c -E -dM ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/arm-acle-6.5.c -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/arm-acle-6.5.c -check-prefix CHECK-FMA
    RUN("%clang -target armv8-eabi -mfpu=vfpv4 -x c -E -dM %s -o -")./*|*/
      I("FileCheck %s -check-prefix CHECK-FMA");
    // ${LLVM_SRC}/build/bin/clang -target armv4-eabi -mfpu=neon -x c -E -dM ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/arm-acle-6.5.c -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/arm-acle-6.5.c -check-prefix CHECK-NO-NEON
    RUN("%clang -target armv4-eabi -mfpu=neon -x c -E -dM %s -o -")./*|*/
      I("FileCheck %s -check-prefix CHECK-NO-NEON");
    // ${LLVM_SRC}/build/bin/clang -target armv5-eabi -mfpu=neon -x c -E -dM ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/arm-acle-6.5.c -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/arm-acle-6.5.c -check-prefix CHECK-NO-NEON
    RUN("%clang -target armv5-eabi -mfpu=neon -x c -E -dM %s -o -")./*|*/
      I("FileCheck %s -check-prefix CHECK-NO-NEON");
    // ${LLVM_SRC}/build/bin/clang -target armv6-eabi -mfpu=neon -x c -E -dM ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/arm-acle-6.5.c -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/arm-acle-6.5.c -check-prefix CHECK-NO-NEON
    RUN("%clang -target armv6-eabi -mfpu=neon -x c -E -dM %s -o -")./*|*/
      I("FileCheck %s -check-prefix CHECK-NO-NEON");
    // ${LLVM_SRC}/build/bin/clang -target armv7-eabi -mfpu=neon -x c -E -dM ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/arm-acle-6.5.c -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/arm-acle-6.5.c -check-prefix CHECK-NEON-SP
    RUN("%clang -target armv7-eabi -mfpu=neon -x c -E -dM %s -o -")./*|*/
      I("FileCheck %s -check-prefix CHECK-NEON-SP");
    // ${LLVM_SRC}/build/bin/clang -target armv7-eabi -mfpu=neon-fp16 -x c -E -dM ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/arm-acle-6.5.c -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/arm-acle-6.5.c -check-prefix CHECK-NEON-SP-HP
    RUN("%clang -target armv7-eabi -mfpu=neon-fp16 -x c -E -dM %s -o -")./*|*/
      I("FileCheck %s -check-prefix CHECK-NEON-SP-HP");
    // ${LLVM_SRC}/build/bin/clang -target armv7-eabi -mfpu=neon-vfpv4 -x c -E -dM ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/arm-acle-6.5.c -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/arm-acle-6.5.c -check-prefix CHECK-NEON-SP-HP
    RUN("%clang -target armv7-eabi -mfpu=neon-vfpv4 -x c -E -dM %s -o -")./*|*/
      I("FileCheck %s -check-prefix CHECK-NEON-SP-HP");
    // ${LLVM_SRC}/build/bin/clang -target armv7-eabi -mfpu=neon-fp-armv8 -x c -E -dM ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/arm-acle-6.5.c -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/arm-acle-6.5.c -check-prefix CHECK-NEON-SP-HP
    RUN("%clang -target armv7-eabi -mfpu=neon-fp-armv8 -x c -E -dM %s -o -")./*|*/
      I("FileCheck %s -check-prefix CHECK-NEON-SP-HP");
    // ${LLVM_SRC}/build/bin/clang -target armv7-eabi -mfpu=crypto-neon-fp-armv8 -x c -E -dM ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/arm-acle-6.5.c -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/arm-acle-6.5.c -check-prefix CHECK-NEON-SP-HP
    RUN("%clang -target armv7-eabi -mfpu=crypto-neon-fp-armv8 -x c -E -dM %s -o -")./*|*/
      I("FileCheck %s -check-prefix CHECK-NEON-SP-HP");
    // ${LLVM_SRC}/build/bin/clang -target armv4-eabi -x c -E -dM ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/arm-acle-6.5.c -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/arm-acle-6.5.c -check-prefix CHECK-NO-EXTENSIONS
    RUN("%clang -target armv4-eabi -x c -E -dM %s -o -")./*|*/
      I("FileCheck %s -check-prefix CHECK-NO-EXTENSIONS");
    // ${LLVM_SRC}/build/bin/clang -target armv5-eabi -x c -E -dM ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/arm-acle-6.5.c -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/arm-acle-6.5.c -check-prefix CHECK-NO-EXTENSIONS
    RUN("%clang -target armv5-eabi -x c -E -dM %s -o -")./*|*/
      I("FileCheck %s -check-prefix CHECK-NO-EXTENSIONS");
    // ${LLVM_SRC}/build/bin/clang -target armv6-eabi -x c -E -dM ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/arm-acle-6.5.c -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/arm-acle-6.5.c -check-prefix CHECK-NO-EXTENSIONS
    RUN("%clang -target armv6-eabi -x c -E -dM %s -o -")./*|*/
      I("FileCheck %s -check-prefix CHECK-NO-EXTENSIONS");
    // ${LLVM_SRC}/build/bin/clang -target armv7-eabi -x c -E -dM ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/arm-acle-6.5.c -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/arm-acle-6.5.c -check-prefix CHECK-NO-EXTENSIONS
    RUN("%clang -target armv7-eabi -x c -E -dM %s -o -")./*|*/
      I("FileCheck %s -check-prefix CHECK-NO-EXTENSIONS");
    // ${LLVM_SRC}/build/bin/clang -target armv8-eabi -x c -E -dM ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/arm-acle-6.5.c -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/arm-acle-6.5.c -check-prefix CHECK-EXTENSIONS
    RUN("%clang -target armv8-eabi -x c -E -dM %s -o -")./*|*/
      I("FileCheck %s -check-prefix CHECK-EXTENSIONS");
  }

  @Test
  public void test_arm_target_features_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/arm-target-features.c");
    // ${LLVM_SRC}/build/bin/clang -target armv8a-none-linux-gnu -x c -E -dM ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/arm-target-features.c -o - | ${LLVM_SRC}/build/bin/FileCheck -match-full-lines --check-prefix=CHECK-V8A ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/arm-target-features.c
    RUN("%clang -target armv8a-none-linux-gnu -x c -E -dM %s -o -")./*|*/
      I("FileCheck -match-full-lines --check-prefix=CHECK-V8A %s");
    // ${LLVM_SRC}/build/bin/clang -target armv7a-none-linux-gnu -x c -E -dM ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/arm-target-features.c -o - | ${LLVM_SRC}/build/bin/FileCheck -match-full-lines --check-prefix=CHECK-V7 ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/arm-target-features.c
    RUN("%clang -target armv7a-none-linux-gnu -x c -E -dM %s -o -")./*|*/
      I("FileCheck -match-full-lines --check-prefix=CHECK-V7 %s");
    // ${LLVM_SRC}/build/bin/clang -target x86_64-apple-macosx10.10 -arch armv7s -x c -E -dM ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/arm-target-features.c -o - | ${LLVM_SRC}/build/bin/FileCheck -match-full-lines --check-prefix=CHECK-V7S ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/arm-target-features.c
    RUN("%clang -target x86_64-apple-macosx10.10 -arch armv7s -x c -E -dM %s -o -")./*|*/
      I("FileCheck -match-full-lines --check-prefix=CHECK-V7S %s");
    // ${LLVM_SRC}/build/bin/clang -target armv8a -mfloat-abi=hard -x c -E -dM ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/arm-target-features.c | ${LLVM_SRC}/build/bin/FileCheck -match-full-lines --check-prefix=CHECK-V8-BAREHF ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/arm-target-features.c
    RUN("%clang -target armv8a -mfloat-abi=hard -x c -E -dM %s")./*|*/
      I("FileCheck -match-full-lines --check-prefix=CHECK-V8-BAREHF %s");
    // ${LLVM_SRC}/build/bin/clang -target armv8a -mfloat-abi=hard -mfpu=fp-armv8 -x c -E -dM ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/arm-target-features.c | ${LLVM_SRC}/build/bin/FileCheck -match-full-lines --check-prefix=CHECK-V8-BAREHF-FP ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/arm-target-features.c
    RUN("%clang -target armv8a -mfloat-abi=hard -mfpu=fp-armv8 -x c -E -dM %s")./*|*/
      I("FileCheck -match-full-lines --check-prefix=CHECK-V8-BAREHF-FP %s");
    // ${LLVM_SRC}/build/bin/clang -target armv8a -mfloat-abi=hard -mfpu=neon-fp-armv8 -x c -E -dM ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/arm-target-features.c | ${LLVM_SRC}/build/bin/FileCheck -match-full-lines --check-prefix=CHECK-V8-BAREHF-NEON-FP ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/arm-target-features.c
    RUN("%clang -target armv8a -mfloat-abi=hard -mfpu=neon-fp-armv8 -x c -E -dM %s")./*|*/
      I("FileCheck -match-full-lines --check-prefix=CHECK-V8-BAREHF-NEON-FP %s");
    // ${LLVM_SRC}/build/bin/clang -target armv8a -mfloat-abi=hard -mfpu=crypto-neon-fp-armv8 -x c -E -dM ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/arm-target-features.c | ${LLVM_SRC}/build/bin/FileCheck -match-full-lines --check-prefix=CHECK-V8-BAREHF-NEON-FP ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/arm-target-features.c
    RUN("%clang -target armv8a -mfloat-abi=hard -mfpu=crypto-neon-fp-armv8 -x c -E -dM %s")./*|*/
      I("FileCheck -match-full-lines --check-prefix=CHECK-V8-BAREHF-NEON-FP %s");
    // ${LLVM_SRC}/build/bin/clang -target armv8a -mnocrc -x c -E -dM ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/arm-target-features.c | ${LLVM_SRC}/build/bin/FileCheck -match-full-lines --check-prefix=CHECK-V8-NOCRC ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/arm-target-features.c
    RUN("%clang -target armv8a -mnocrc -x c -E -dM %s")./*|*/
      I("FileCheck -match-full-lines --check-prefix=CHECK-V8-NOCRC %s");
    // ${LLVM_SRC}/build/bin/clang -target armv8 -x c -E -dM ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/arm-target-features.c -o - | ${LLVM_SRC}/build/bin/FileCheck -match-full-lines --check-prefix=V8 ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/arm-target-features.c
    RUN("%clang -target armv8 -x c -E -dM %s -o -")./*|*/
      I("FileCheck -match-full-lines --check-prefix=V8 %s");
    // ${LLVM_SRC}/build/bin/clang -target armv8 -mthumb -x c -E -dM ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/arm-target-features.c -o - | ${LLVM_SRC}/build/bin/FileCheck -match-full-lines --check-prefix=V8 ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/arm-target-features.c
    RUN("%clang -target armv8 -mthumb -x c -E -dM %s -o -")./*|*/
      I("FileCheck -match-full-lines --check-prefix=V8 %s");
    // ${LLVM_SRC}/build/bin/clang -target armv8-eabi -x c -E -dM ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/arm-target-features.c -o - | ${LLVM_SRC}/build/bin/FileCheck -match-full-lines --check-prefix=V8 ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/arm-target-features.c
    RUN("%clang -target armv8-eabi -x c -E -dM %s -o -")./*|*/
      I("FileCheck -match-full-lines --check-prefix=V8 %s");
    // ${LLVM_SRC}/build/bin/clang -target armv8-eabi -mthumb -x c -E -dM ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/arm-target-features.c -o - | ${LLVM_SRC}/build/bin/FileCheck -match-full-lines --check-prefix=V8 ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/arm-target-features.c
    RUN("%clang -target armv8-eabi -mthumb -x c -E -dM %s -o -")./*|*/
      I("FileCheck -match-full-lines --check-prefix=V8 %s");
    // ${LLVM_SRC}/build/bin/clang -target armv8 -mhwdiv=none -x c -E -dM ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/arm-target-features.c -o - | ${LLVM_SRC}/build/bin/FileCheck -match-full-lines --check-prefix=NOHWDIV-V8 ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/arm-target-features.c
    RUN("%clang -target armv8 -mhwdiv=none -x c -E -dM %s -o -")./*|*/
      I("FileCheck -match-full-lines --check-prefix=NOHWDIV-V8 %s");
    // ${LLVM_SRC}/build/bin/clang -target armv8 -mthumb -mhwdiv=none -x c -E -dM ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/arm-target-features.c -o - | ${LLVM_SRC}/build/bin/FileCheck -match-full-lines --check-prefix=NOHWDIV-V8 ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/arm-target-features.c
    RUN("%clang -target armv8 -mthumb -mhwdiv=none -x c -E -dM %s -o -")./*|*/
      I("FileCheck -match-full-lines --check-prefix=NOHWDIV-V8 %s");
    // ${LLVM_SRC}/build/bin/clang -target armv8 -mhwdiv=thumb -x c -E -dM ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/arm-target-features.c -o - | ${LLVM_SRC}/build/bin/FileCheck -match-full-lines --check-prefix=NOHWDIV-V8 ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/arm-target-features.c
    RUN("%clang -target armv8 -mhwdiv=thumb -x c -E -dM %s -o -")./*|*/
      I("FileCheck -match-full-lines --check-prefix=NOHWDIV-V8 %s");
    // ${LLVM_SRC}/build/bin/clang -target armv8 -mthumb -mhwdiv=arm -x c -E -dM ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/arm-target-features.c -o - | ${LLVM_SRC}/build/bin/FileCheck -match-full-lines --check-prefix=NOHWDIV-V8 ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/arm-target-features.c
    RUN("%clang -target armv8 -mthumb -mhwdiv=arm -x c -E -dM %s -o -")./*|*/
      I("FileCheck -match-full-lines --check-prefix=NOHWDIV-V8 %s");
    // ${LLVM_SRC}/build/bin/clang -target armv8a -x c -E -dM ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/arm-target-features.c -o - | ${LLVM_SRC}/build/bin/FileCheck -match-full-lines --check-prefix=V8A ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/arm-target-features.c
    RUN("%clang -target armv8a -x c -E -dM %s -o -")./*|*/
      I("FileCheck -match-full-lines --check-prefix=V8A %s");
    // ${LLVM_SRC}/build/bin/clang -target armv8a -mthumb -x c -E -dM ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/arm-target-features.c -o - | ${LLVM_SRC}/build/bin/FileCheck -match-full-lines --check-prefix=V8A ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/arm-target-features.c
    RUN("%clang -target armv8a -mthumb -x c -E -dM %s -o -")./*|*/
      I("FileCheck -match-full-lines --check-prefix=V8A %s");
    // ${LLVM_SRC}/build/bin/clang -target armv8a-eabi -x c -E -dM ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/arm-target-features.c -o - | ${LLVM_SRC}/build/bin/FileCheck -match-full-lines --check-prefix=V8A ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/arm-target-features.c
    RUN("%clang -target armv8a-eabi -x c -E -dM %s -o -")./*|*/
      I("FileCheck -match-full-lines --check-prefix=V8A %s");
    // ${LLVM_SRC}/build/bin/clang -target armv8a-eabi -x c -E -dM ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/arm-target-features.c -o - | ${LLVM_SRC}/build/bin/FileCheck -match-full-lines --check-prefix=V8A ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/arm-target-features.c
    RUN("%clang -target armv8a-eabi -x c -E -dM %s -o -")./*|*/
      I("FileCheck -match-full-lines --check-prefix=V8A %s");
    // ${LLVM_SRC}/build/bin/clang -target armv8m.base-none-linux-gnu -x c -E -dM ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/arm-target-features.c -o - | ${LLVM_SRC}/build/bin/FileCheck -match-full-lines --check-prefix=V8M_BASELINE ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/arm-target-features.c
    RUN("%clang -target armv8m.base-none-linux-gnu -x c -E -dM %s -o -")./*|*/
      I("FileCheck -match-full-lines --check-prefix=V8M_BASELINE %s");
    // ${LLVM_SRC}/build/bin/clang -target armv8m.main-none-linux-gnu -x c -E -dM ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/arm-target-features.c -o - | ${LLVM_SRC}/build/bin/FileCheck -match-full-lines --check-prefix=V8M_MAINLINE ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/arm-target-features.c
    RUN("%clang -target armv8m.main-none-linux-gnu -x c -E -dM %s -o -")./*|*/
      I("FileCheck -match-full-lines --check-prefix=V8M_MAINLINE %s");
    // ${LLVM_SRC}/build/bin/clang -target arm-none-linux-gnu -march=armv8-m.main+dsp -x c -E -dM ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/arm-target-features.c -o - | ${LLVM_SRC}/build/bin/FileCheck -match-full-lines --check-prefix=V8M_MAINLINE_DSP ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/arm-target-features.c
    RUN("%clang -target arm-none-linux-gnu -march=armv8-m.main+dsp -x c -E -dM %s -o -")./*|*/
      I("FileCheck -match-full-lines --check-prefix=V8M_MAINLINE_DSP %s");
    // ${LLVM_SRC}/build/bin/clang -target arm-none-linux-gnu -x c -E -dM ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/arm-target-features.c -o - | ${LLVM_SRC}/build/bin/FileCheck -match-full-lines --check-prefix=CHECK-DEFS ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/arm-target-features.c
    RUN("%clang -target arm-none-linux-gnu -x c -E -dM %s -o -")./*|*/
      I("FileCheck -match-full-lines --check-prefix=CHECK-DEFS %s");
    // ${LLVM_SRC}/build/bin/clang -target arm-none-linux-gnu -fno-math-errno -fno-signed-zeros -fno-trapping-math -fassociative-math -freciprocal-math -x c -E -dM ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/arm-target-features.c -o - | ${LLVM_SRC}/build/bin/FileCheck -match-full-lines --check-prefix=CHECK-FASTMATH ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/arm-target-features.c
    RUN("%clang -target arm-none-linux-gnu -fno-math-errno -fno-signed-zeros -fno-trapping-math -fassociative-math -freciprocal-math -x c -E -dM %s -o -")./*|*/
      I("FileCheck -match-full-lines --check-prefix=CHECK-FASTMATH %s");
    // ${LLVM_SRC}/build/bin/clang -target arm-none-linux-gnu -ffast-math -x c -E -dM ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/arm-target-features.c -o - | ${LLVM_SRC}/build/bin/FileCheck -match-full-lines --check-prefix=CHECK-FASTMATH ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/arm-target-features.c
    RUN("%clang -target arm-none-linux-gnu -ffast-math -x c -E -dM %s -o -")./*|*/
      I("FileCheck -match-full-lines --check-prefix=CHECK-FASTMATH %s");
    // ${LLVM_SRC}/build/bin/clang -target arm-none-linux-gnu -fshort-wchar -x c -E -dM ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/arm-target-features.c -o - | ${LLVM_SRC}/build/bin/FileCheck -match-full-lines --check-prefix=CHECK-SHORTWCHAR ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/arm-target-features.c
    RUN("%clang -target arm-none-linux-gnu -fshort-wchar -x c -E -dM %s -o -")./*|*/
      I("FileCheck -match-full-lines --check-prefix=CHECK-SHORTWCHAR %s");
    // ${LLVM_SRC}/build/bin/clang -target arm-none-linux-gnu -fshort-enums -x c -E -dM ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/arm-target-features.c -o - | ${LLVM_SRC}/build/bin/FileCheck -match-full-lines --check-prefix=CHECK-SHORTENUMS ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/arm-target-features.c
    RUN("%clang -target arm-none-linux-gnu -fshort-enums -x c -E -dM %s -o -")./*|*/
      I("FileCheck -match-full-lines --check-prefix=CHECK-SHORTENUMS %s");
    // ${LLVM_SRC}/build/bin/clang -target armv7 -mcpu=cortex-a15 -x c -E -dM ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/arm-target-features.c -o - | ${LLVM_SRC}/build/bin/FileCheck -match-full-lines --check-prefix=HWDIV ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/arm-target-features.c
    RUN("%clang -target armv7 -mcpu=cortex-a15 -x c -E -dM %s -o -")./*|*/
      I("FileCheck -match-full-lines --check-prefix=HWDIV %s");
    // ${LLVM_SRC}/build/bin/clang -target armv7 -mthumb -mcpu=cortex-a15 -x c -E -dM ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/arm-target-features.c -o - | ${LLVM_SRC}/build/bin/FileCheck -match-full-lines --check-prefix=HWDIV ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/arm-target-features.c
    RUN("%clang -target armv7 -mthumb -mcpu=cortex-a15 -x c -E -dM %s -o -")./*|*/
      I("FileCheck -match-full-lines --check-prefix=HWDIV %s");
    // ${LLVM_SRC}/build/bin/clang -target armv7 -mcpu=cortex-a15 -mhwdiv=arm -x c -E -dM ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/arm-target-features.c -o - | ${LLVM_SRC}/build/bin/FileCheck -match-full-lines --check-prefix=HWDIV ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/arm-target-features.c
    RUN("%clang -target armv7 -mcpu=cortex-a15 -mhwdiv=arm -x c -E -dM %s -o -")./*|*/
      I("FileCheck -match-full-lines --check-prefix=HWDIV %s");
    // ${LLVM_SRC}/build/bin/clang -target armv7 -mthumb -mcpu=cortex-a15 -mhwdiv=thumb -x c -E -dM ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/arm-target-features.c -o - | ${LLVM_SRC}/build/bin/FileCheck -match-full-lines --check-prefix=HWDIV ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/arm-target-features.c
    RUN("%clang -target armv7 -mthumb -mcpu=cortex-a15 -mhwdiv=thumb -x c -E -dM %s -o -")./*|*/
      I("FileCheck -match-full-lines --check-prefix=HWDIV %s");
    // ${LLVM_SRC}/build/bin/clang -target arm -mcpu=cortex-a15 -mhwdiv=thumb -x c -E -dM ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/arm-target-features.c -o - | ${LLVM_SRC}/build/bin/FileCheck -match-full-lines --check-prefix=NOHWDIV ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/arm-target-features.c
    RUN("%clang -target arm -mcpu=cortex-a15 -mhwdiv=thumb -x c -E -dM %s -o -")./*|*/
      I("FileCheck -match-full-lines --check-prefix=NOHWDIV %s");
    // ${LLVM_SRC}/build/bin/clang -target arm -mthumb -mcpu=cortex-a15 -mhwdiv=arm -x c -E -dM ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/arm-target-features.c -o - | ${LLVM_SRC}/build/bin/FileCheck -match-full-lines --check-prefix=NOHWDIV ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/arm-target-features.c
    RUN("%clang -target arm -mthumb -mcpu=cortex-a15 -mhwdiv=arm -x c -E -dM %s -o -")./*|*/
      I("FileCheck -match-full-lines --check-prefix=NOHWDIV %s");
    // ${LLVM_SRC}/build/bin/clang -target arm -mcpu=cortex-a15 -mhwdiv=none -x c -E -dM ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/arm-target-features.c -o - | ${LLVM_SRC}/build/bin/FileCheck -match-full-lines --check-prefix=NOHWDIV ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/arm-target-features.c
    RUN("%clang -target arm -mcpu=cortex-a15 -mhwdiv=none -x c -E -dM %s -o -")./*|*/
      I("FileCheck -match-full-lines --check-prefix=NOHWDIV %s");
    // ${LLVM_SRC}/build/bin/clang -target arm -mthumb -mcpu=cortex-a15 -mhwdiv=none -x c -E -dM ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/arm-target-features.c -o - | ${LLVM_SRC}/build/bin/FileCheck -match-full-lines --check-prefix=NOHWDIV ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/arm-target-features.c
    RUN("%clang -target arm -mthumb -mcpu=cortex-a15 -mhwdiv=none -x c -E -dM %s -o -")./*|*/
      I("FileCheck -match-full-lines --check-prefix=NOHWDIV %s");
    // ${LLVM_SRC}/build/bin/clang -target armv7-none-linux-gnueabi -mcpu=cortex-a7 -x c -E -dM ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/arm-target-features.c -o - | ${LLVM_SRC}/build/bin/FileCheck -match-full-lines --check-prefix=DEFAULTFPU-A7 ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/arm-target-features.c
    RUN("%clang -target armv7-none-linux-gnueabi -mcpu=cortex-a7 -x c -E -dM %s -o -")./*|*/
      I("FileCheck -match-full-lines --check-prefix=DEFAULTFPU-A7 %s");
    // ${LLVM_SRC}/build/bin/clang -target armv7-none-linux-gnueabi -mthumb -mcpu=cortex-a7 -x c -E -dM ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/arm-target-features.c -o - | ${LLVM_SRC}/build/bin/FileCheck -match-full-lines --check-prefix=DEFAULTFPU-A7 ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/arm-target-features.c
    RUN("%clang -target armv7-none-linux-gnueabi -mthumb -mcpu=cortex-a7 -x c -E -dM %s -o -")./*|*/
      I("FileCheck -match-full-lines --check-prefix=DEFAULTFPU-A7 %s");
    // ${LLVM_SRC}/build/bin/clang -target armv7-none-linux-gnueabi -mcpu=cortex-a7 -mfpu=none -x c -E -dM ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/arm-target-features.c -o - | ${LLVM_SRC}/build/bin/FileCheck -match-full-lines --check-prefix=FPUNONE-A7 ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/arm-target-features.c
    RUN("%clang -target armv7-none-linux-gnueabi -mcpu=cortex-a7 -mfpu=none -x c -E -dM %s -o -")./*|*/
      I("FileCheck -match-full-lines --check-prefix=FPUNONE-A7 %s");
    // ${LLVM_SRC}/build/bin/clang -target armv7-none-linux-gnueabi -mthumb -mcpu=cortex-a7 -mfpu=none -x c -E -dM ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/arm-target-features.c -o - | ${LLVM_SRC}/build/bin/FileCheck -match-full-lines --check-prefix=FPUNONE-A7 ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/arm-target-features.c
    RUN("%clang -target armv7-none-linux-gnueabi -mthumb -mcpu=cortex-a7 -mfpu=none -x c -E -dM %s -o -")./*|*/
      I("FileCheck -match-full-lines --check-prefix=FPUNONE-A7 %s");
    // ${LLVM_SRC}/build/bin/clang -target armv7-none-linux-gnueabi -mcpu=cortex-a7 -mfpu=vfp4 -x c -E -dM ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/arm-target-features.c -o - | ${LLVM_SRC}/build/bin/FileCheck -match-full-lines --check-prefix=NONEON-A7 ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/arm-target-features.c
    RUN("%clang -target armv7-none-linux-gnueabi -mcpu=cortex-a7 -mfpu=vfp4 -x c -E -dM %s -o -")./*|*/
      I("FileCheck -match-full-lines --check-prefix=NONEON-A7 %s");
    // ${LLVM_SRC}/build/bin/clang -target armv7-none-linux-gnueabi -mthumb -mcpu=cortex-a7 -mfpu=vfp4 -x c -E -dM ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/arm-target-features.c -o - | ${LLVM_SRC}/build/bin/FileCheck -match-full-lines --check-prefix=NONEON-A7 ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/arm-target-features.c
    RUN("%clang -target armv7-none-linux-gnueabi -mthumb -mcpu=cortex-a7 -mfpu=vfp4 -x c -E -dM %s -o -")./*|*/
      I("FileCheck -match-full-lines --check-prefix=NONEON-A7 %s");
    // ${LLVM_SRC}/build/bin/clang -target armv7-none-linux-gnueabi -mcpu=cortex-a5 -x c -E -dM ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/arm-target-features.c -o - | ${LLVM_SRC}/build/bin/FileCheck -match-full-lines --check-prefix=DEFAULTFPU-A5 ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/arm-target-features.c
    RUN("%clang -target armv7-none-linux-gnueabi -mcpu=cortex-a5 -x c -E -dM %s -o -")./*|*/
      I("FileCheck -match-full-lines --check-prefix=DEFAULTFPU-A5 %s");
    // ${LLVM_SRC}/build/bin/clang -target armv7-none-linux-gnueabi -mthumb -mcpu=cortex-a5 -x c -E -dM ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/arm-target-features.c -o - | ${LLVM_SRC}/build/bin/FileCheck -match-full-lines --check-prefix=DEFAULTFPU-A5 ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/arm-target-features.c
    RUN("%clang -target armv7-none-linux-gnueabi -mthumb -mcpu=cortex-a5 -x c -E -dM %s -o -")./*|*/
      I("FileCheck -match-full-lines --check-prefix=DEFAULTFPU-A5 %s");
    // ${LLVM_SRC}/build/bin/clang -target armv7-none-linux-gnueabi -mcpu=cortex-a5 -mfpu=none -x c -E -dM ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/arm-target-features.c -o - | ${LLVM_SRC}/build/bin/FileCheck -match-full-lines --check-prefix=FPUNONE-A5 ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/arm-target-features.c
    RUN("%clang -target armv7-none-linux-gnueabi -mcpu=cortex-a5 -mfpu=none -x c -E -dM %s -o -")./*|*/
      I("FileCheck -match-full-lines --check-prefix=FPUNONE-A5 %s");
    // ${LLVM_SRC}/build/bin/clang -target armv7-none-linux-gnueabi -mthumb -mcpu=cortex-a5 -mfpu=none -x c -E -dM ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/arm-target-features.c -o - | ${LLVM_SRC}/build/bin/FileCheck -match-full-lines --check-prefix=FPUNONE-A5 ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/arm-target-features.c
    RUN("%clang -target armv7-none-linux-gnueabi -mthumb -mcpu=cortex-a5 -mfpu=none -x c -E -dM %s -o -")./*|*/
      I("FileCheck -match-full-lines --check-prefix=FPUNONE-A5 %s");
    // ${LLVM_SRC}/build/bin/clang -target armv7-none-linux-gnueabi -mcpu=cortex-a5 -mfpu=vfp4-d16 -x c -E -dM ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/arm-target-features.c -o - | ${LLVM_SRC}/build/bin/FileCheck -match-full-lines --check-prefix=NONEON-A5 ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/arm-target-features.c
    RUN("%clang -target armv7-none-linux-gnueabi -mcpu=cortex-a5 -mfpu=vfp4-d16 -x c -E -dM %s -o -")./*|*/
      I("FileCheck -match-full-lines --check-prefix=NONEON-A5 %s");
    // ${LLVM_SRC}/build/bin/clang -target armv7-none-linux-gnueabi -mthumb -mcpu=cortex-a5 -mfpu=vfp4-d16 -x c -E -dM ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/arm-target-features.c -o - | ${LLVM_SRC}/build/bin/FileCheck -match-full-lines --check-prefix=NONEON-A5 ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/arm-target-features.c
    RUN("%clang -target armv7-none-linux-gnueabi -mthumb -mcpu=cortex-a5 -mfpu=vfp4-d16 -x c -E -dM %s -o -")./*|*/
      I("FileCheck -match-full-lines --check-prefix=NONEON-A5 %s");
    // ${LLVM_SRC}/build/bin/clang -target armv4t -mcpu=ep9312 -x c -E -dM ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/arm-target-features.c -o - | ${LLVM_SRC}/build/bin/FileCheck -match-full-lines --check-prefix=A4T ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/arm-target-features.c
    RUN("%clang -target armv4t -mcpu=ep9312 -x c -E -dM %s -o -")./*|*/
      I("FileCheck -match-full-lines --check-prefix=A4T %s");
    // ${LLVM_SRC}/build/bin/clang -target armv5 -mcpu=arm10tdmi -x c -E -dM ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/arm-target-features.c -o - | ${LLVM_SRC}/build/bin/FileCheck -match-full-lines --check-prefix=A5T ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/arm-target-features.c
    RUN("%clang -target armv5 -mcpu=arm10tdmi -x c -E -dM %s -o -")./*|*/
      I("FileCheck -match-full-lines --check-prefix=A5T %s");
    // ${LLVM_SRC}/build/bin/clang -target armv7 -mcpu=cortex-a5 -x c -E -dM ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/arm-target-features.c -o - | ${LLVM_SRC}/build/bin/FileCheck -match-full-lines --check-prefix=A5 ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/arm-target-features.c
    RUN("%clang -target armv7 -mcpu=cortex-a5 -x c -E -dM %s -o -")./*|*/
      I("FileCheck -match-full-lines --check-prefix=A5 %s");
    // ${LLVM_SRC}/build/bin/clang -target armv7 -mthumb -mcpu=cortex-a5 -x c -E -dM ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/arm-target-features.c -o - | ${LLVM_SRC}/build/bin/FileCheck -match-full-lines --check-prefix=A5 ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/arm-target-features.c
    RUN("%clang -target armv7 -mthumb -mcpu=cortex-a5 -x c -E -dM %s -o -")./*|*/
      I("FileCheck -match-full-lines --check-prefix=A5 %s");
    // ${LLVM_SRC}/build/bin/clang -target armv7k -mcpu=cortex-a7 -x c -E -dM ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/arm-target-features.c -o - | ${LLVM_SRC}/build/bin/FileCheck -match-full-lines --check-prefix=A7 ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/arm-target-features.c
    RUN("%clang -target armv7k -mcpu=cortex-a7 -x c -E -dM %s -o -")./*|*/
      I("FileCheck -match-full-lines --check-prefix=A7 %s");
    // ${LLVM_SRC}/build/bin/clang -target armv7k -mthumb -mcpu=cortex-a7 -x c -E -dM ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/arm-target-features.c -o - | ${LLVM_SRC}/build/bin/FileCheck -match-full-lines --check-prefix=A7 ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/arm-target-features.c
    RUN("%clang -target armv7k -mthumb -mcpu=cortex-a7 -x c -E -dM %s -o -")./*|*/
      I("FileCheck -match-full-lines --check-prefix=A7 %s");
    // ${LLVM_SRC}/build/bin/clang -target x86_64-apple-darwin -arch armv7k -x c -E -dM ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/arm-target-features.c -o - | ${LLVM_SRC}/build/bin/FileCheck -match-full-lines --check-prefix=ARMV7K ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/arm-target-features.c
    RUN("%clang -target x86_64-apple-darwin -arch armv7k -x c -E -dM %s -o -")./*|*/
      I("FileCheck -match-full-lines --check-prefix=ARMV7K %s");
    // ${LLVM_SRC}/build/bin/clang -target armv7 -mcpu=cortex-a8 -x c -E -dM ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/arm-target-features.c -o - | ${LLVM_SRC}/build/bin/FileCheck -match-full-lines --check-prefix=A8 ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/arm-target-features.c
    RUN("%clang -target armv7 -mcpu=cortex-a8 -x c -E -dM %s -o -")./*|*/
      I("FileCheck -match-full-lines --check-prefix=A8 %s");
    // ${LLVM_SRC}/build/bin/clang -target armv7 -mthumb -mcpu=cortex-a8 -x c -E -dM ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/arm-target-features.c -o - | ${LLVM_SRC}/build/bin/FileCheck -match-full-lines --check-prefix=A8 ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/arm-target-features.c
    RUN("%clang -target armv7 -mthumb -mcpu=cortex-a8 -x c -E -dM %s -o -")./*|*/
      I("FileCheck -match-full-lines --check-prefix=A8 %s");
    // ${LLVM_SRC}/build/bin/clang -target armv7 -mcpu=cortex-a9 -x c -E -dM ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/arm-target-features.c -o - | ${LLVM_SRC}/build/bin/FileCheck -match-full-lines --check-prefix=A9 ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/arm-target-features.c
    RUN("%clang -target armv7 -mcpu=cortex-a9 -x c -E -dM %s -o -")./*|*/
      I("FileCheck -match-full-lines --check-prefix=A9 %s");
    // ${LLVM_SRC}/build/bin/clang -target armv7 -mthumb -mcpu=cortex-a9 -x c -E -dM ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/arm-target-features.c -o - | ${LLVM_SRC}/build/bin/FileCheck -match-full-lines --check-prefix=A9 ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/arm-target-features.c
    RUN("%clang -target armv7 -mthumb -mcpu=cortex-a9 -x c -E -dM %s -o -")./*|*/
      I("FileCheck -match-full-lines --check-prefix=A9 %s");
    // ${LLVM_SRC}/build/bin/clang -target armv7-none-linux-gnueabi -mcpu=cortex-a12 -x c -E -dM ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/arm-target-features.c -o - | ${LLVM_SRC}/build/bin/FileCheck -match-full-lines --check-prefix=DEFAULTFPU-A12 ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/arm-target-features.c
    RUN("%clang -target armv7-none-linux-gnueabi -mcpu=cortex-a12 -x c -E -dM %s -o -")./*|*/
      I("FileCheck -match-full-lines --check-prefix=DEFAULTFPU-A12 %s");
    // ${LLVM_SRC}/build/bin/clang -target armv7-none-linux-gnueabi -mthumb -mcpu=cortex-a12 -x c -E -dM ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/arm-target-features.c -o - | ${LLVM_SRC}/build/bin/FileCheck -match-full-lines --check-prefix=DEFAULTFPU-A12 ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/arm-target-features.c
    RUN("%clang -target armv7-none-linux-gnueabi -mthumb -mcpu=cortex-a12 -x c -E -dM %s -o -")./*|*/
      I("FileCheck -match-full-lines --check-prefix=DEFAULTFPU-A12 %s");
    // ${LLVM_SRC}/build/bin/clang -target armv7-none-linux-gnueabi -mcpu=cortex-a12 -mfpu=none -x c -E -dM ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/arm-target-features.c -o - | ${LLVM_SRC}/build/bin/FileCheck -match-full-lines --check-prefix=FPUNONE-A12 ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/arm-target-features.c
    RUN("%clang -target armv7-none-linux-gnueabi -mcpu=cortex-a12 -mfpu=none -x c -E -dM %s -o -")./*|*/
      I("FileCheck -match-full-lines --check-prefix=FPUNONE-A12 %s");
    // ${LLVM_SRC}/build/bin/clang -target armv7-none-linux-gnueabi -mthumb -mcpu=cortex-a12 -mfpu=none -x c -E -dM ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/arm-target-features.c -o - | ${LLVM_SRC}/build/bin/FileCheck -match-full-lines --check-prefix=FPUNONE-A12 ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/arm-target-features.c
    RUN("%clang -target armv7-none-linux-gnueabi -mthumb -mcpu=cortex-a12 -mfpu=none -x c -E -dM %s -o -")./*|*/
      I("FileCheck -match-full-lines --check-prefix=FPUNONE-A12 %s");
    // ${LLVM_SRC}/build/bin/clang -target armv7 -mcpu=cortex-a12 -x c -E -dM ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/arm-target-features.c -o - | ${LLVM_SRC}/build/bin/FileCheck -match-full-lines --check-prefix=A12 ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/arm-target-features.c
    RUN("%clang -target armv7 -mcpu=cortex-a12 -x c -E -dM %s -o -")./*|*/
      I("FileCheck -match-full-lines --check-prefix=A12 %s");
    // ${LLVM_SRC}/build/bin/clang -target armv7 -mthumb -mcpu=cortex-a12 -x c -E -dM ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/arm-target-features.c -o - | ${LLVM_SRC}/build/bin/FileCheck -match-full-lines --check-prefix=A12 ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/arm-target-features.c
    RUN("%clang -target armv7 -mthumb -mcpu=cortex-a12 -x c -E -dM %s -o -")./*|*/
      I("FileCheck -match-full-lines --check-prefix=A12 %s");
    // ${LLVM_SRC}/build/bin/clang -target armv7 -mcpu=cortex-a15 -x c -E -dM ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/arm-target-features.c -o - | ${LLVM_SRC}/build/bin/FileCheck -match-full-lines --check-prefix=A15 ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/arm-target-features.c
    RUN("%clang -target armv7 -mcpu=cortex-a15 -x c -E -dM %s -o -")./*|*/
      I("FileCheck -match-full-lines --check-prefix=A15 %s");
    // ${LLVM_SRC}/build/bin/clang -target armv7 -mthumb -mcpu=cortex-a15 -x c -E -dM ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/arm-target-features.c -o - | ${LLVM_SRC}/build/bin/FileCheck -match-full-lines --check-prefix=A15 ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/arm-target-features.c
    RUN("%clang -target armv7 -mthumb -mcpu=cortex-a15 -x c -E -dM %s -o -")./*|*/
      I("FileCheck -match-full-lines --check-prefix=A15 %s");
    // ${LLVM_SRC}/build/bin/clang -target armv7-none-linux-gnueabi -mcpu=cortex-a17 -x c -E -dM ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/arm-target-features.c -o - | ${LLVM_SRC}/build/bin/FileCheck -match-full-lines --check-prefix=DEFAULTFPU-A17 ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/arm-target-features.c
    RUN("%clang -target armv7-none-linux-gnueabi -mcpu=cortex-a17 -x c -E -dM %s -o -")./*|*/
      I("FileCheck -match-full-lines --check-prefix=DEFAULTFPU-A17 %s");
    // ${LLVM_SRC}/build/bin/clang -target armv7-none-linux-gnueabi -mthumb -mcpu=cortex-a17 -x c -E -dM ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/arm-target-features.c -o - | ${LLVM_SRC}/build/bin/FileCheck -match-full-lines --check-prefix=DEFAULTFPU-A17 ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/arm-target-features.c
    RUN("%clang -target armv7-none-linux-gnueabi -mthumb -mcpu=cortex-a17 -x c -E -dM %s -o -")./*|*/
      I("FileCheck -match-full-lines --check-prefix=DEFAULTFPU-A17 %s");
    // ${LLVM_SRC}/build/bin/clang -target armv7-none-linux-gnueabi -mcpu=cortex-a17 -mfpu=none -x c -E -dM ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/arm-target-features.c -o - | ${LLVM_SRC}/build/bin/FileCheck -match-full-lines --check-prefix=FPUNONE-A17 ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/arm-target-features.c
    RUN("%clang -target armv7-none-linux-gnueabi -mcpu=cortex-a17 -mfpu=none -x c -E -dM %s -o -")./*|*/
      I("FileCheck -match-full-lines --check-prefix=FPUNONE-A17 %s");
    // ${LLVM_SRC}/build/bin/clang -target armv7-none-linux-gnueabi -mthumb -mcpu=cortex-a17 -mfpu=none -x c -E -dM ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/arm-target-features.c -o - | ${LLVM_SRC}/build/bin/FileCheck -match-full-lines --check-prefix=FPUNONE-A17 ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/arm-target-features.c
    RUN("%clang -target armv7-none-linux-gnueabi -mthumb -mcpu=cortex-a17 -mfpu=none -x c -E -dM %s -o -")./*|*/
      I("FileCheck -match-full-lines --check-prefix=FPUNONE-A17 %s");
    // ${LLVM_SRC}/build/bin/clang -target armv7 -mcpu=cortex-a17 -x c -E -dM ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/arm-target-features.c -o - | ${LLVM_SRC}/build/bin/FileCheck -match-full-lines --check-prefix=A17 ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/arm-target-features.c
    RUN("%clang -target armv7 -mcpu=cortex-a17 -x c -E -dM %s -o -")./*|*/
      I("FileCheck -match-full-lines --check-prefix=A17 %s");
    // ${LLVM_SRC}/build/bin/clang -target armv7 -mthumb -mcpu=cortex-a17 -x c -E -dM ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/arm-target-features.c -o - | ${LLVM_SRC}/build/bin/FileCheck -match-full-lines --check-prefix=A17 ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/arm-target-features.c
    RUN("%clang -target armv7 -mthumb -mcpu=cortex-a17 -x c -E -dM %s -o -")./*|*/
      I("FileCheck -match-full-lines --check-prefix=A17 %s");
    // ${LLVM_SRC}/build/bin/clang -target armv7s -mcpu=swift -x c -E -dM ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/arm-target-features.c -o - | ${LLVM_SRC}/build/bin/FileCheck -match-full-lines --check-prefix=SWIFT ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/arm-target-features.c
    RUN("%clang -target armv7s -mcpu=swift -x c -E -dM %s -o -")./*|*/
      I("FileCheck -match-full-lines --check-prefix=SWIFT %s");
    // ${LLVM_SRC}/build/bin/clang -target armv7s -mthumb -mcpu=swift -x c -E -dM ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/arm-target-features.c -o - | ${LLVM_SRC}/build/bin/FileCheck -match-full-lines --check-prefix=SWIFT ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/arm-target-features.c
    RUN("%clang -target armv7s -mthumb -mcpu=swift -x c -E -dM %s -o -")./*|*/
      I("FileCheck -match-full-lines --check-prefix=SWIFT %s");
    // ${LLVM_SRC}/build/bin/clang -target armv8 -mcpu=cortex-a32 -x c -E -dM ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/arm-target-features.c -o - | ${LLVM_SRC}/build/bin/FileCheck -match-full-lines --check-prefix=ARMV8 ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/arm-target-features.c
    RUN("%clang -target armv8 -mcpu=cortex-a32 -x c -E -dM %s -o -")./*|*/
      I("FileCheck -match-full-lines --check-prefix=ARMV8 %s");
    // ${LLVM_SRC}/build/bin/clang -target armv8 -mthumb -mcpu=cortex-a32 -x c -E -dM ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/arm-target-features.c -o - | ${LLVM_SRC}/build/bin/FileCheck -match-full-lines --check-prefix=ARMV8 ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/arm-target-features.c
    RUN("%clang -target armv8 -mthumb -mcpu=cortex-a32 -x c -E -dM %s -o -")./*|*/
      I("FileCheck -match-full-lines --check-prefix=ARMV8 %s");
    // ${LLVM_SRC}/build/bin/clang -target armv8 -mcpu=cortex-a35 -x c -E -dM ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/arm-target-features.c -o - | ${LLVM_SRC}/build/bin/FileCheck -match-full-lines --check-prefix=ARMV8 ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/arm-target-features.c
    RUN("%clang -target armv8 -mcpu=cortex-a35 -x c -E -dM %s -o -")./*|*/
      I("FileCheck -match-full-lines --check-prefix=ARMV8 %s");
    // ${LLVM_SRC}/build/bin/clang -target armv8 -mthumb -mcpu=cortex-a35 -x c -E -dM ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/arm-target-features.c -o - | ${LLVM_SRC}/build/bin/FileCheck -match-full-lines --check-prefix=ARMV8 ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/arm-target-features.c
    RUN("%clang -target armv8 -mthumb -mcpu=cortex-a35 -x c -E -dM %s -o -")./*|*/
      I("FileCheck -match-full-lines --check-prefix=ARMV8 %s");
    // ${LLVM_SRC}/build/bin/clang -target armv8 -mcpu=cortex-a53 -x c -E -dM ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/arm-target-features.c -o - | ${LLVM_SRC}/build/bin/FileCheck -match-full-lines --check-prefix=ARMV8 ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/arm-target-features.c
    RUN("%clang -target armv8 -mcpu=cortex-a53 -x c -E -dM %s -o -")./*|*/
      I("FileCheck -match-full-lines --check-prefix=ARMV8 %s");
    // ${LLVM_SRC}/build/bin/clang -target armv8 -mthumb -mcpu=cortex-a53 -x c -E -dM ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/arm-target-features.c -o - | ${LLVM_SRC}/build/bin/FileCheck -match-full-lines --check-prefix=ARMV8 ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/arm-target-features.c
    RUN("%clang -target armv8 -mthumb -mcpu=cortex-a53 -x c -E -dM %s -o -")./*|*/
      I("FileCheck -match-full-lines --check-prefix=ARMV8 %s");
    // ${LLVM_SRC}/build/bin/clang -target armv8 -mcpu=cortex-a57 -x c -E -dM ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/arm-target-features.c -o - | ${LLVM_SRC}/build/bin/FileCheck -match-full-lines --check-prefix=ARMV8 ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/arm-target-features.c
    RUN("%clang -target armv8 -mcpu=cortex-a57 -x c -E -dM %s -o -")./*|*/
      I("FileCheck -match-full-lines --check-prefix=ARMV8 %s");
    // ${LLVM_SRC}/build/bin/clang -target armv8 -mthumb -mcpu=cortex-a57 -x c -E -dM ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/arm-target-features.c -o - | ${LLVM_SRC}/build/bin/FileCheck -match-full-lines --check-prefix=ARMV8 ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/arm-target-features.c
    RUN("%clang -target armv8 -mthumb -mcpu=cortex-a57 -x c -E -dM %s -o -")./*|*/
      I("FileCheck -match-full-lines --check-prefix=ARMV8 %s");
    // ${LLVM_SRC}/build/bin/clang -target armv8 -mcpu=cortex-a72 -x c -E -dM ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/arm-target-features.c -o - | ${LLVM_SRC}/build/bin/FileCheck -match-full-lines --check-prefix=ARMV8 ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/arm-target-features.c
    RUN("%clang -target armv8 -mcpu=cortex-a72 -x c -E -dM %s -o -")./*|*/
      I("FileCheck -match-full-lines --check-prefix=ARMV8 %s");
    // ${LLVM_SRC}/build/bin/clang -target armv8 -mthumb -mcpu=cortex-a72 -x c -E -dM ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/arm-target-features.c -o - | ${LLVM_SRC}/build/bin/FileCheck -match-full-lines --check-prefix=ARMV8 ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/arm-target-features.c
    RUN("%clang -target armv8 -mthumb -mcpu=cortex-a72 -x c -E -dM %s -o -")./*|*/
      I("FileCheck -match-full-lines --check-prefix=ARMV8 %s");
    // ${LLVM_SRC}/build/bin/clang -target armv8 -mcpu=cortex-a73 -x c -E -dM ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/arm-target-features.c -o - | ${LLVM_SRC}/build/bin/FileCheck -match-full-lines --check-prefix=ARMV8 ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/arm-target-features.c
    RUN("%clang -target armv8 -mcpu=cortex-a73 -x c -E -dM %s -o -")./*|*/
      I("FileCheck -match-full-lines --check-prefix=ARMV8 %s");
    // ${LLVM_SRC}/build/bin/clang -target armv8 -mthumb -mcpu=cortex-a73 -x c -E -dM ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/arm-target-features.c -o - | ${LLVM_SRC}/build/bin/FileCheck -match-full-lines --check-prefix=ARMV8 ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/arm-target-features.c
    RUN("%clang -target armv8 -mthumb -mcpu=cortex-a73 -x c -E -dM %s -o -")./*|*/
      I("FileCheck -match-full-lines --check-prefix=ARMV8 %s");
    // ${LLVM_SRC}/build/bin/clang -target armv7 -mcpu=cortex-r4 -x c -E -dM ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/arm-target-features.c -o - | ${LLVM_SRC}/build/bin/FileCheck -match-full-lines --check-prefix=R4-ARM ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/arm-target-features.c
    RUN("%clang -target armv7 -mcpu=cortex-r4 -x c -E -dM %s -o -")./*|*/
      I("FileCheck -match-full-lines --check-prefix=R4-ARM %s");
    // ${LLVM_SRC}/build/bin/clang -target armv7 -mthumb -mcpu=cortex-r4 -x c -E -dM ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/arm-target-features.c -o - | ${LLVM_SRC}/build/bin/FileCheck -match-full-lines --check-prefix=R4-THUMB ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/arm-target-features.c
    RUN("%clang -target armv7 -mthumb -mcpu=cortex-r4 -x c -E -dM %s -o -")./*|*/
      I("FileCheck -match-full-lines --check-prefix=R4-THUMB %s");
    // ${LLVM_SRC}/build/bin/clang -target armv7 -mcpu=cortex-r4f -x c -E -dM ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/arm-target-features.c -o - | ${LLVM_SRC}/build/bin/FileCheck -match-full-lines --check-prefix=R4F-ARM ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/arm-target-features.c
    RUN("%clang -target armv7 -mcpu=cortex-r4f -x c -E -dM %s -o -")./*|*/
      I("FileCheck -match-full-lines --check-prefix=R4F-ARM %s");
    // ${LLVM_SRC}/build/bin/clang -target armv7 -mthumb -mcpu=cortex-r4f -x c -E -dM ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/arm-target-features.c -o - | ${LLVM_SRC}/build/bin/FileCheck -match-full-lines --check-prefix=R4F-THUMB ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/arm-target-features.c
    RUN("%clang -target armv7 -mthumb -mcpu=cortex-r4f -x c -E -dM %s -o -")./*|*/
      I("FileCheck -match-full-lines --check-prefix=R4F-THUMB %s");
    // ${LLVM_SRC}/build/bin/clang -target armv7 -mcpu=cortex-r5 -x c -E -dM ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/arm-target-features.c -o - | ${LLVM_SRC}/build/bin/FileCheck -match-full-lines --check-prefix=R5 ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/arm-target-features.c
    RUN("%clang -target armv7 -mcpu=cortex-r5 -x c -E -dM %s -o -")./*|*/
      I("FileCheck -match-full-lines --check-prefix=R5 %s");
    // ${LLVM_SRC}/build/bin/clang -target armv7 -mthumb -mcpu=cortex-r5 -x c -E -dM ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/arm-target-features.c -o - | ${LLVM_SRC}/build/bin/FileCheck -match-full-lines --check-prefix=R5 ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/arm-target-features.c
    RUN("%clang -target armv7 -mthumb -mcpu=cortex-r5 -x c -E -dM %s -o -")./*|*/
      I("FileCheck -match-full-lines --check-prefix=R5 %s");
    // ${LLVM_SRC}/build/bin/clang -target armv7 -mcpu=cortex-r7 -x c -E -dM ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/arm-target-features.c -o - | ${LLVM_SRC}/build/bin/FileCheck -match-full-lines --check-prefix=R7-R8 ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/arm-target-features.c
    RUN("%clang -target armv7 -mcpu=cortex-r7 -x c -E -dM %s -o -")./*|*/
      I("FileCheck -match-full-lines --check-prefix=R7-R8 %s");
    // ${LLVM_SRC}/build/bin/clang -target armv7 -mthumb -mcpu=cortex-r7 -x c -E -dM ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/arm-target-features.c -o - | ${LLVM_SRC}/build/bin/FileCheck -match-full-lines --check-prefix=R7-R8 ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/arm-target-features.c
    RUN("%clang -target armv7 -mthumb -mcpu=cortex-r7 -x c -E -dM %s -o -")./*|*/
      I("FileCheck -match-full-lines --check-prefix=R7-R8 %s");
    // ${LLVM_SRC}/build/bin/clang -target armv7 -mcpu=cortex-r8 -x c -E -dM ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/arm-target-features.c -o - | ${LLVM_SRC}/build/bin/FileCheck -match-full-lines --check-prefix=R7-R8 ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/arm-target-features.c
    RUN("%clang -target armv7 -mcpu=cortex-r8 -x c -E -dM %s -o -")./*|*/
      I("FileCheck -match-full-lines --check-prefix=R7-R8 %s");
    // ${LLVM_SRC}/build/bin/clang -target armv7 -mthumb -mcpu=cortex-r8 -x c -E -dM ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/arm-target-features.c -o - | ${LLVM_SRC}/build/bin/FileCheck -match-full-lines --check-prefix=R7-R8 ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/arm-target-features.c
    RUN("%clang -target armv7 -mthumb -mcpu=cortex-r8 -x c -E -dM %s -o -")./*|*/
      I("FileCheck -match-full-lines --check-prefix=R7-R8 %s");
    // ${LLVM_SRC}/build/bin/clang -target armv7 -mthumb -mcpu=cortex-m0 -x c -E -dM ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/arm-target-features.c -o - | ${LLVM_SRC}/build/bin/FileCheck -match-full-lines --check-prefix=M0-THUMB ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/arm-target-features.c
    RUN("%clang -target armv7 -mthumb -mcpu=cortex-m0 -x c -E -dM %s -o -")./*|*/
      I("FileCheck -match-full-lines --check-prefix=M0-THUMB %s");
    // ${LLVM_SRC}/build/bin/clang -target armv7 -mthumb -mcpu=cortex-m0plus -x c -E -dM ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/arm-target-features.c -o - | ${LLVM_SRC}/build/bin/FileCheck -match-full-lines --check-prefix=M0-THUMB ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/arm-target-features.c
    RUN("%clang -target armv7 -mthumb -mcpu=cortex-m0plus -x c -E -dM %s -o -")./*|*/
      I("FileCheck -match-full-lines --check-prefix=M0-THUMB %s");
    // ${LLVM_SRC}/build/bin/clang -target armv7 -mthumb -mcpu=cortex-m1 -x c -E -dM ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/arm-target-features.c -o - | ${LLVM_SRC}/build/bin/FileCheck -match-full-lines --check-prefix=M0-THUMB ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/arm-target-features.c
    RUN("%clang -target armv7 -mthumb -mcpu=cortex-m1 -x c -E -dM %s -o -")./*|*/
      I("FileCheck -match-full-lines --check-prefix=M0-THUMB %s");
    // ${LLVM_SRC}/build/bin/clang -target armv7 -mthumb -mcpu=sc000 -x c -E -dM ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/arm-target-features.c -o - | ${LLVM_SRC}/build/bin/FileCheck -match-full-lines --check-prefix=M0-THUMB ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/arm-target-features.c
    RUN("%clang -target armv7 -mthumb -mcpu=sc000 -x c -E -dM %s -o -")./*|*/
      I("FileCheck -match-full-lines --check-prefix=M0-THUMB %s");
    // ${LLVM_SRC}/build/bin/clang -target armv7 -mthumb -mcpu=cortex-m3 -x c -E -dM ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/arm-target-features.c -o - | ${LLVM_SRC}/build/bin/FileCheck -match-full-lines --check-prefix=M3-THUMB ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/arm-target-features.c
    RUN("%clang -target armv7 -mthumb -mcpu=cortex-m3 -x c -E -dM %s -o -")./*|*/
      I("FileCheck -match-full-lines --check-prefix=M3-THUMB %s");
    // ${LLVM_SRC}/build/bin/clang -target armv7 -mthumb -mcpu=sc300 -x c -E -dM ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/arm-target-features.c -o - | ${LLVM_SRC}/build/bin/FileCheck -match-full-lines --check-prefix=M3-THUMB ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/arm-target-features.c
    RUN("%clang -target armv7 -mthumb -mcpu=sc300 -x c -E -dM %s -o -")./*|*/
      I("FileCheck -match-full-lines --check-prefix=M3-THUMB %s");
    // ${LLVM_SRC}/build/bin/clang -target armv7 -mthumb -mcpu=cortex-m4 -x c -E -dM ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/arm-target-features.c -o - | ${LLVM_SRC}/build/bin/FileCheck -match-full-lines --check-prefix=M4-THUMB ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/arm-target-features.c
    RUN("%clang -target armv7 -mthumb -mcpu=cortex-m4 -x c -E -dM %s -o -")./*|*/
      I("FileCheck -match-full-lines --check-prefix=M4-THUMB %s");
    // ${LLVM_SRC}/build/bin/clang -target armv7 -mthumb -mcpu=cortex-m7 -x c -E -dM ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/arm-target-features.c -o - | ${LLVM_SRC}/build/bin/FileCheck -match-full-lines --check-prefix=M7-THUMB ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/arm-target-features.c
    RUN("%clang -target armv7 -mthumb -mcpu=cortex-m7 -x c -E -dM %s -o -")./*|*/
      I("FileCheck -match-full-lines --check-prefix=M7-THUMB %s");
    // ${LLVM_SRC}/build/bin/clang -target armv7 -mcpu=krait -x c -E -dM ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/arm-target-features.c -o - | ${LLVM_SRC}/build/bin/FileCheck -match-full-lines --check-prefix=KRAIT ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/arm-target-features.c
    RUN("%clang -target armv7 -mcpu=krait -x c -E -dM %s -o -")./*|*/
      I("FileCheck -match-full-lines --check-prefix=KRAIT %s");
    // ${LLVM_SRC}/build/bin/clang -target armv7 -mthumb -mcpu=krait -x c -E -dM ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/arm-target-features.c -o - | ${LLVM_SRC}/build/bin/FileCheck -match-full-lines --check-prefix=KRAIT ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/arm-target-features.c
    RUN("%clang -target armv7 -mthumb -mcpu=krait -x c -E -dM %s -o -")./*|*/
      I("FileCheck -match-full-lines --check-prefix=KRAIT %s");
    // ${LLVM_SRC}/build/bin/clang -target armv8.1a-none-none-eabi -x c -E -dM ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/arm-target-features.c -o - | ${LLVM_SRC}/build/bin/FileCheck -match-full-lines --check-prefix=CHECK-V81A ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/arm-target-features.c
    RUN("%clang -target armv8.1a-none-none-eabi -x c -E -dM %s -o -")./*|*/
      I("FileCheck -match-full-lines --check-prefix=CHECK-V81A %s");
    // ${LLVM_SRC}/build/bin/clang -target armv8.2a-none-none-eabi -x c -E -dM ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/arm-target-features.c -o - | ${LLVM_SRC}/build/bin/FileCheck -match-full-lines --check-prefix=CHECK-V82A ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/arm-target-features.c
    RUN("%clang -target armv8.2a-none-none-eabi -x c -E -dM %s -o -")./*|*/
      I("FileCheck -match-full-lines --check-prefix=CHECK-V82A %s");
  }

  @Test
  public void test_assembler_with_cpp_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/assembler-with-cpp.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x assembler-with-cpp -E ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/assembler-with-cpp.c -o - | ${LLVM_SRC}/build/bin/FileCheck -strict-whitespace -check-prefix=CHECK-Identifiers-False ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/assembler-with-cpp.c
    RUN("%clang_cc1 -x assembler-with-cpp -E %s -o -")./*|*/
      I("FileCheck -strict-whitespace -check-prefix=CHECK-Identifiers-False %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x assembler-with-cpp -fdollars-in-identifiers -E ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/assembler-with-cpp.c -o - | ${LLVM_SRC}/build/bin/FileCheck -check-prefix=CHECK-Identifiers-True -strict-whitespace ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/assembler-with-cpp.c
    RUN("%clang_cc1 -x assembler-with-cpp -fdollars-in-identifiers -E %s -o -")./*|*/
      I("FileCheck -check-prefix=CHECK-Identifiers-True -strict-whitespace %s");
  }

  @Test
  public void test_bigoutput_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/bigoutput.c");
    // REQUIRES: console
    if (!CHECK_REQUIRES("console")) {
      return;
    }
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -E -x c ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/bigoutput.c > /dev/tty
    RUN("%clang_cc1 -E -x c %s > /dev/tty");
  }

  @Test
  public void test_builtin_line_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/builtin_line.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -E ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/builtin_line.c | ${LLVM_SRC}/build/bin/FileCheck --strict-whitespace ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/builtin_line.c
    RUN("%clang_cc1 -E %s")./*|*/
      I("FileCheck --strict-whitespace %s");
  }

  @Test
  public void test_c90_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/c90.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/c90.c -std=c89 -Eonly -verify -pedantic-errors
    RUN("%clang_cc1 %s -std=c89 -Eonly -verify -pedantic-errors");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/c90.c -std=c89 -E | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/c90.c
    RUN("%clang_cc1 %s -std=c89 -E")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_c99_6_10_3_3_p4_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/c99-6_10_3_3_p4.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -E ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/c99-6_10_3_3_p4.c | ${LLVM_SRC}/build/bin/FileCheck -strict-whitespace ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/c99-6_10_3_3_p4.c
    RUN("%clang_cc1 -E %s")./*|*/
      I("FileCheck -strict-whitespace %s");
  }

  @Test
  public void test_c99_6_10_3_4_p5_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/c99-6_10_3_4_p5.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -E ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/c99-6_10_3_4_p5.c | ${LLVM_SRC}/build/bin/FileCheck -strict-whitespace ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/c99-6_10_3_4_p5.c
    RUN("%clang_cc1 -E %s")./*|*/
      I("FileCheck -strict-whitespace %s");
  }

  @Test
  public void test_c99_6_10_3_4_p6_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/c99-6_10_3_4_p6.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -E ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/c99-6_10_3_4_p6.c | ${LLVM_SRC}/build/bin/FileCheck -strict-whitespace ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/c99-6_10_3_4_p6.c
    RUN("%clang_cc1 -E %s")./*|*/
      I("FileCheck -strict-whitespace %s");
  }

  @Test
  public void test_c99_6_10_3_4_p7_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/c99-6_10_3_4_p7.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -E ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/c99-6_10_3_4_p7.c | ${LLVM_SRC}/build/bin/FileCheck -strict-whitespace ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/c99-6_10_3_4_p7.c
    RUN("%clang_cc1 -E %s")./*|*/
      I("FileCheck -strict-whitespace %s");
  }

  @Test
  public void test_c99_6_10_3_4_p9_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/c99-6_10_3_4_p9.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -E ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/c99-6_10_3_4_p9.c | ${LLVM_SRC}/build/bin/FileCheck -strict-whitespace ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/c99-6_10_3_4_p9.c
    RUN("%clang_cc1 -E %s")./*|*/
      I("FileCheck -strict-whitespace %s");
  }

  @Test
  public void test_clang_headers_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/clang_headers.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -ffreestanding -E ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/clang_headers.c
    RUN("%clang_cc1 -ffreestanding -E %s");
  }

  @Test
  public void test_comment_save_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/comment_save.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -E -C ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/comment_save.c | ${LLVM_SRC}/build/bin/FileCheck -strict-whitespace ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/comment_save.c
    RUN("%clang_cc1 -E -C %s")./*|*/
      I("FileCheck -strict-whitespace %s");
  }

  @Test
  public void test_comment_save_if_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/comment_save_if.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/comment_save_if.c -E -CC -pedantic -verify
    RUN("%clang_cc1 %s -E -CC -pedantic -verify");
  }

  @Test
  public void test_comment_save_macro_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/comment_save_macro.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -E -C ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/comment_save_macro.c | ${LLVM_SRC}/build/bin/FileCheck -check-prefix=CHECK-C -strict-whitespace ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/comment_save_macro.c
    RUN("%clang_cc1 -E -C %s")./*|*/
      I("FileCheck -check-prefix=CHECK-C -strict-whitespace %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -E -CC ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/comment_save_macro.c | ${LLVM_SRC}/build/bin/FileCheck -check-prefix=CHECK-CC -strict-whitespace ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/comment_save_macro.c
    RUN("%clang_cc1 -E -CC %s")./*|*/
      I("FileCheck -check-prefix=CHECK-CC -strict-whitespace %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -E ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/comment_save_macro.c | ${LLVM_SRC}/build/bin/FileCheck -strict-whitespace ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/comment_save_macro.c
    RUN("%clang_cc1 -E %s")./*|*/
      I("FileCheck -strict-whitespace %s");
  }

  @Test
  public void test_cuda_approx_transcendentals_cu() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/cuda-approx-transcendentals.cu");
    // ${LLVM_SRC}/build/bin/clang --cuda-host-only -nocudainc -target i386-unknown-linux-gnu -x cuda -E -dM -o - /dev/null | ${LLVM_SRC}/build/bin/FileCheck --check-prefix HOST ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/cuda-approx-transcendentals.cu
    RUN("%clang --cuda-host-only -nocudainc -target i386-unknown-linux-gnu -x cuda -E -dM -o - /dev/null")./*|*/
      I("FileCheck --check-prefix HOST %s");
    // ${LLVM_SRC}/build/bin/clang --cuda-device-only -nocudainc -target i386-unknown-linux-gnu -x cuda -E -dM -o - /dev/null | ${LLVM_SRC}/build/bin/FileCheck --check-prefix DEVICE-NOFAST ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/cuda-approx-transcendentals.cu
    RUN("%clang --cuda-device-only -nocudainc -target i386-unknown-linux-gnu -x cuda -E -dM -o - /dev/null")./*|*/
      I("FileCheck --check-prefix DEVICE-NOFAST %s");
    // ${LLVM_SRC}/build/bin/clang -fcuda-approx-transcendentals --cuda-device-only -nocudainc -target i386-unknown-linux-gnu -x cuda -E -dM -o - /dev/null | ${LLVM_SRC}/build/bin/FileCheck --check-prefix DEVICE-FAST ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/cuda-approx-transcendentals.cu
    RUN("%clang -fcuda-approx-transcendentals --cuda-device-only -nocudainc -target i386-unknown-linux-gnu -x cuda -E -dM -o - /dev/null")./*|*/
      I("FileCheck --check-prefix DEVICE-FAST %s");
    // ${LLVM_SRC}/build/bin/clang -ffast-math --cuda-device-only -nocudainc -target i386-unknown-linux-gnu -x cuda -E -dM -o - /dev/null | ${LLVM_SRC}/build/bin/FileCheck --check-prefix DEVICE-FAST ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/cuda-approx-transcendentals.cu
    RUN("%clang -ffast-math --cuda-device-only -nocudainc -target i386-unknown-linux-gnu -x cuda -E -dM -o - /dev/null")./*|*/
      I("FileCheck --check-prefix DEVICE-FAST %s");
  }

  @Test
  public void test_cuda_preprocess_cu() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/cuda-preprocess.cu");
    // REQUIRES: clang-driver
    if (!CHECK_REQUIRES("clang-driver")) {
      return;
    }
    // REQUIRES: x86-registered-target
    if (!CHECK_REQUIRES("x86-registered-target")) {
      return;
    }
    // REQUIRES: nvptx-registered-target
    if (!CHECK_REQUIRES("nvptx-registered-target")) {
      return;
    }
    // ${LLVM_SRC}/build/bin/clang -E -target x86_64-linux-gnu --cuda-gpu-arch=sm_20 -nocudainc ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/cuda-preprocess.cu 2>&1 | ${LLVM_SRC}/build/bin/FileCheck -check-prefix NOARCH ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/cuda-preprocess.cu
    RUN("%clang -E -target x86_64-linux-gnu --cuda-gpu-arch=sm_20 -nocudainc %s 2>&1")./*|*/
      I("FileCheck -check-prefix NOARCH %s");
    // ${LLVM_SRC}/build/bin/clang -E -target x86_64-linux-gnu --cuda-gpu-arch=sm_20 --cuda-host-only -nocudainc ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/cuda-preprocess.cu 2>&1 | ${LLVM_SRC}/build/bin/FileCheck -check-prefix NOARCH ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/cuda-preprocess.cu
    RUN("%clang -E -target x86_64-linux-gnu --cuda-gpu-arch=sm_20 --cuda-host-only -nocudainc %s 2>&1")./*|*/
      I("FileCheck -check-prefix NOARCH %s");
    // ${LLVM_SRC}/build/bin/clang -E -target x86_64-linux-gnu --cuda-gpu-arch=sm_20 --cuda-device-only -nocudainc ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/cuda-preprocess.cu 2>&1 | ${LLVM_SRC}/build/bin/FileCheck -check-prefix SM20 ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/cuda-preprocess.cu
    RUN("%clang -E -target x86_64-linux-gnu --cuda-gpu-arch=sm_20 --cuda-device-only -nocudainc %s 2>&1")./*|*/
      I("FileCheck -check-prefix SM20 %s");
    // ${LLVM_SRC}/build/bin/clang -E -target x86_64-linux-gnu --cuda-gpu-arch=sm_30 --cuda-device-only -nocudainc ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/cuda-preprocess.cu 2>&1 | ${LLVM_SRC}/build/bin/FileCheck -check-prefix SM30 ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/cuda-preprocess.cu
    RUN("%clang -E -target x86_64-linux-gnu --cuda-gpu-arch=sm_30 --cuda-device-only -nocudainc %s 2>&1")./*|*/
      I("FileCheck -check-prefix SM30 %s");
    // ${LLVM_SRC}/build/bin/clang -E -target x86_64-linux-gnu --cuda-gpu-arch=sm_20 --cuda-gpu-arch=sm_30 --cuda-device-only -nocudainc ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/cuda-preprocess.cu 2>&1 | ${LLVM_SRC}/build/bin/FileCheck -check-prefix SM20 -check-prefix SM30 ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/cuda-preprocess.cu
    RUN("%clang -E -target x86_64-linux-gnu --cuda-gpu-arch=sm_20 --cuda-gpu-arch=sm_30 --cuda-device-only -nocudainc %s 2>&1")./*|*/
      I("FileCheck -check-prefix SM20 -check-prefix SM30 %s");
  }

  @Test // temporary disable for 3.9 - INCORRECT parsing/escaping of line with grep or non-espaced | in test file?
  public void test_cuda_types_cu() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/cuda-types.cu");
    // ${LLVM_SRC}/build/bin/clang --cuda-host-only -nocudainc -target i386-unknown-linux-gnu -x cuda -E -dM -o - /dev/null > ${TEST_TEMP_DIR}/i386-host-defines
    RUN("%clang --cuda-host-only -nocudainc -target i386-unknown-linux-gnu -x cuda -E -dM -o - /dev/null > %T/i386-host-defines");
    // ${LLVM_SRC}/build/bin/clang --cuda-device-only -nocudainc -target i386-unknown-linux-gnu -x cuda -E -dM -o - /dev/null > ${TEST_TEMP_DIR}/i386-device-defines
    RUN("%clang --cuda-device-only -nocudainc -target i386-unknown-linux-gnu -x cuda -E -dM -o - /dev/null > %T/i386-device-defines");
    // grep 'define __[^ ]*\(TYPE\|MAX\|SIZEOF\|WIDTH\)' ${TEST_TEMP_DIR}/i386-host-defines | grep -v '__LDBL\|_LONG_DOUBLE' > ${TEST_TEMP_DIR}/i386-host-defines-filtered
    RUN("grep 'define __[^ ]*\\(TYPE\\|MAX\\|SIZEOF\\|WIDTH\\)' %T/i386-host-defines")./*|*/
      I("grep -v '__LDBL\\|_LONG_DOUBLE' > %T/i386-host-defines-filtered");
    // grep 'define __[^ ]*\(TYPE\|MAX\|SIZEOF\|WIDTH\)' ${TEST_TEMP_DIR}/i386-device-defines | grep -v '__LDBL\|_LONG_DOUBLE' > ${TEST_TEMP_DIR}/i386-device-defines-filtered
    RUN("grep 'define __[^ ]*\\(TYPE\\|MAX\\|SIZEOF\\|WIDTH\\)' %T/i386-device-defines")./*|*/
      I("grep -v '__LDBL\\|_LONG_DOUBLE' > %T/i386-device-defines-filtered");
    // diff ${TEST_TEMP_DIR}/i386-host-defines-filtered ${TEST_TEMP_DIR}/i386-device-defines-filtered
    RUN("diff %T/i386-host-defines-filtered %T/i386-device-defines-filtered");
    // ${LLVM_SRC}/build/bin/clang --cuda-host-only -nocudainc -target x86_64-unknown-linux-gnu -x cuda -E -dM -o - /dev/null > ${TEST_TEMP_DIR}/x86_64-host-defines
    RUN("%clang --cuda-host-only -nocudainc -target x86_64-unknown-linux-gnu -x cuda -E -dM -o - /dev/null > %T/x86_64-host-defines");
    // ${LLVM_SRC}/build/bin/clang --cuda-device-only -nocudainc -target x86_64-unknown-linux-gnu -x cuda -E -dM -o - /dev/null > ${TEST_TEMP_DIR}/x86_64-device-defines
    RUN("%clang --cuda-device-only -nocudainc -target x86_64-unknown-linux-gnu -x cuda -E -dM -o - /dev/null > %T/x86_64-device-defines");
    // grep 'define __[^ ]*\(TYPE\|MAX\|SIZEOF\|WIDTH\)' ${TEST_TEMP_DIR}/x86_64-host-defines | grep -v '__LDBL\|_LONG_DOUBLE' > ${TEST_TEMP_DIR}/x86_64-host-defines-filtered
    RUN("grep 'define __[^ ]*\\(TYPE\\|MAX\\|SIZEOF\\|WIDTH\\)' %T/x86_64-host-defines")./*|*/
      I("grep -v '__LDBL\\|_LONG_DOUBLE' > %T/x86_64-host-defines-filtered");
    // grep 'define __[^ ]*\(TYPE\|MAX\|SIZEOF\|WIDTH\)' ${TEST_TEMP_DIR}/x86_64-device-defines | grep -v '__LDBL\|_LONG_DOUBLE' > ${TEST_TEMP_DIR}/x86_64-device-defines-filtered
    RUN("grep 'define __[^ ]*\\(TYPE\\|MAX\\|SIZEOF\\|WIDTH\\)' %T/x86_64-device-defines")./*|*/
      I("grep -v '__LDBL\\|_LONG_DOUBLE' > %T/x86_64-device-defines-filtered");
    // diff ${TEST_TEMP_DIR}/x86_64-host-defines-filtered ${TEST_TEMP_DIR}/x86_64-device-defines-filtered
    RUN("diff %T/x86_64-host-defines-filtered %T/x86_64-device-defines-filtered");
    // ${LLVM_SRC}/build/bin/clang --cuda-host-only -nocudainc -target powerpc64-unknown-linux-gnu -x cuda -E -dM -o - /dev/null > ${TEST_TEMP_DIR}/powerpc64-host-defines
    RUN("%clang --cuda-host-only -nocudainc -target powerpc64-unknown-linux-gnu -x cuda -E -dM -o - /dev/null > %T/powerpc64-host-defines");
    // ${LLVM_SRC}/build/bin/clang --cuda-device-only -nocudainc -target powerpc64-unknown-linux-gnu -x cuda -E -dM -o - /dev/null > ${TEST_TEMP_DIR}/powerpc64-device-defines
    RUN("%clang --cuda-device-only -nocudainc -target powerpc64-unknown-linux-gnu -x cuda -E -dM -o - /dev/null > %T/powerpc64-device-defines");
    // grep 'define __[^ ]*\(TYPE\|MAX\|SIZEOF\|WIDTH\)' ${TEST_TEMP_DIR}/powerpc64-host-defines | grep -v '__LDBL\|_LONG_DOUBLE' > ${TEST_TEMP_DIR}/powerpc64-host-defines-filtered
    RUN("grep 'define __[^ ]*\\(TYPE\\|MAX\\|SIZEOF\\|WIDTH\\)' %T/powerpc64-host-defines")./*|*/
      I("grep -v '__LDBL\\|_LONG_DOUBLE' > %T/powerpc64-host-defines-filtered");
    // grep 'define __[^ ]*\(TYPE\|MAX\|SIZEOF\|WIDTH\)' ${TEST_TEMP_DIR}/powerpc64-device-defines | grep -v '__LDBL\|_LONG_DOUBLE' > ${TEST_TEMP_DIR}/powerpc64-device-defines-filtered
    RUN("grep 'define __[^ ]*\\(TYPE\\|MAX\\|SIZEOF\\|WIDTH\\)' %T/powerpc64-device-defines")./*|*/
      I("grep -v '__LDBL\\|_LONG_DOUBLE' > %T/powerpc64-device-defines-filtered");
    // diff ${TEST_TEMP_DIR}/powerpc64-host-defines-filtered ${TEST_TEMP_DIR}/powerpc64-device-defines-filtered
    RUN("diff %T/powerpc64-host-defines-filtered %T/powerpc64-device-defines-filtered");
    // ${LLVM_SRC}/build/bin/clang --cuda-host-only -nocudainc -target nvptx-nvidia-cuda -x cuda -E -dM -o - /dev/null > ${TEST_TEMP_DIR}/nvptx-host-defines
    RUN("%clang --cuda-host-only -nocudainc -target nvptx-nvidia-cuda -x cuda -E -dM -o - /dev/null > %T/nvptx-host-defines");
    // ${LLVM_SRC}/build/bin/clang --cuda-device-only -nocudainc -target nvptx-nvidia-cuda -x cuda -E -dM -o - /dev/null > ${TEST_TEMP_DIR}/nvptx-device-defines
    RUN("%clang --cuda-device-only -nocudainc -target nvptx-nvidia-cuda -x cuda -E -dM -o - /dev/null > %T/nvptx-device-defines");
    // grep 'define __[^ ]*\(TYPE\|MAX\|SIZEOF\|WIDTH\)' ${TEST_TEMP_DIR}/nvptx-host-defines | grep -v '__LDBL\|_LONG_DOUBLE' > ${TEST_TEMP_DIR}/nvptx-host-defines-filtered
    RUN("grep 'define __[^ ]*\\(TYPE\\|MAX\\|SIZEOF\\|WIDTH\\)' %T/nvptx-host-defines")./*|*/
      I("grep -v '__LDBL\\|_LONG_DOUBLE' > %T/nvptx-host-defines-filtered");
    // grep 'define __[^ ]*\(TYPE\|MAX\|SIZEOF\|WIDTH\)' ${TEST_TEMP_DIR}/nvptx-device-defines | grep -v '__LDBL\|_LONG_DOUBLE' > ${TEST_TEMP_DIR}/nvptx-device-defines-filtered
    RUN("grep 'define __[^ ]*\\(TYPE\\|MAX\\|SIZEOF\\|WIDTH\\)' %T/nvptx-device-defines")./*|*/
      I("grep -v '__LDBL\\|_LONG_DOUBLE' > %T/nvptx-device-defines-filtered");
    // diff ${TEST_TEMP_DIR}/nvptx-host-defines-filtered ${TEST_TEMP_DIR}/nvptx-device-defines-filtered
    RUN("diff %T/nvptx-host-defines-filtered %T/nvptx-device-defines-filtered");
  }

  @Test
  public void test_cxx_and_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/cxx_and.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -DA -DB -E ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/cxx_and.cpp | grep 'int a = 37 == 37'
    RUN("%clang_cc1 -DA -DB -E %s")./*|*/
      I("grep 'int a = 37 == 37'");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -DA -E ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/cxx_and.cpp | grep 'int a = 927 == 927'
    RUN("%clang_cc1 -DA -E %s")./*|*/
      I("grep 'int a = 927 == 927'");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -DB -E ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/cxx_and.cpp | grep 'int a = 927 == 927'
    RUN("%clang_cc1 -DB -E %s")./*|*/
      I("grep 'int a = 927 == 927'");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -E ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/cxx_and.cpp | grep 'int a = 927 == 927'
    RUN("%clang_cc1 -E %s")./*|*/
      I("grep 'int a = 927 == 927'");
  }

  @Test
  public void test_cxx_bitand_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/cxx_bitand.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -DA=1 -DB=2 -E ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/cxx_bitand.cpp | grep 'int a = 927 == 927'
    RUN("%clang_cc1 -DA=1 -DB=2 -E %s")./*|*/
      I("grep 'int a = 927 == 927'");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -DA=1 -DB=1 -E ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/cxx_bitand.cpp | grep 'int a = 37 == 37'
    RUN("%clang_cc1 -DA=1 -DB=1 -E %s")./*|*/
      I("grep 'int a = 37 == 37'");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -E ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/cxx_bitand.cpp | grep 'int a = 927 == 927'
    RUN("%clang_cc1 -E %s")./*|*/
      I("grep 'int a = 927 == 927'");
  }

  @Test
  public void test_cxx_bitor_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/cxx_bitor.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -DA=1 -DB=1 -E ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/cxx_bitor.cpp | grep 'int a = 37 == 37'
    RUN("%clang_cc1 -DA=1 -DB=1 -E %s")./*|*/
      I("grep 'int a = 37 == 37'");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -DA=0 -DB=1 -E ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/cxx_bitor.cpp | grep 'int a = 37 == 37'
    RUN("%clang_cc1 -DA=0 -DB=1 -E %s")./*|*/
      I("grep 'int a = 37 == 37'");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -DA=1 -DB=0 -E ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/cxx_bitor.cpp | grep 'int a = 37 == 37'
    RUN("%clang_cc1 -DA=1 -DB=0 -E %s")./*|*/
      I("grep 'int a = 37 == 37'");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -DA=0 -DB=0 -E ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/cxx_bitor.cpp | grep 'int a = 927 == 927'
    RUN("%clang_cc1 -DA=0 -DB=0 -E %s")./*|*/
      I("grep 'int a = 927 == 927'");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -E ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/cxx_bitor.cpp | grep 'int a = 927 == 927'
    RUN("%clang_cc1 -E %s")./*|*/
      I("grep 'int a = 927 == 927'");
  }

  @Test
  public void test_cxx_compl_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/cxx_compl.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -DA=1 -E ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/cxx_compl.cpp | grep 'int a = 37 == 37'
    RUN("%clang_cc1 -DA=1 -E %s")./*|*/
      I("grep 'int a = 37 == 37'");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -DA=0 -E ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/cxx_compl.cpp | grep 'int a = 927 == 927'
    RUN("%clang_cc1 -DA=0 -E %s")./*|*/
      I("grep 'int a = 927 == 927'");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -E ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/cxx_compl.cpp | grep 'int a = 927 == 927'
    RUN("%clang_cc1 -E %s")./*|*/
      I("grep 'int a = 927 == 927'");
  }

  @Test
  public void test_cxx_not_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/cxx_not.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -DA=1 -E ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/cxx_not.cpp | grep 'int a = 927 == 927'
    RUN("%clang_cc1 -DA=1 -E %s")./*|*/
      I("grep 'int a = 927 == 927'");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -E ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/cxx_not.cpp | grep 'int a = 37 == 37'
    RUN("%clang_cc1 -E %s")./*|*/
      I("grep 'int a = 37 == 37'");
  }

  @Test
  public void test_cxx_not_eq_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/cxx_not_eq.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -DA=1 -DB=1 -E ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/cxx_not_eq.cpp | grep 'int a = 927 == 927'
    RUN("%clang_cc1 -DA=1 -DB=1 -E %s")./*|*/
      I("grep 'int a = 927 == 927'");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -E ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/cxx_not_eq.cpp | grep 'int a = 927 == 927'
    RUN("%clang_cc1 -E %s")./*|*/
      I("grep 'int a = 927 == 927'");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -DA=1 -DB=2 -E ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/cxx_not_eq.cpp | grep 'int a = 37 == 37'
    RUN("%clang_cc1 -DA=1 -DB=2 -E %s")./*|*/
      I("grep 'int a = 37 == 37'");
  }

  @Test
  public void test_cxx_oper_keyword_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/cxx_oper_keyword.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/cxx_oper_keyword.cpp -E -verify -DOPERATOR_NAMES
    RUN("%clang_cc1 %s -E -verify -DOPERATOR_NAMES");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/cxx_oper_keyword.cpp -E -verify -fno-operator-names
    RUN("%clang_cc1 %s -E -verify -fno-operator-names");
  }

  @Test
  public void test_cxx_oper_keyword_ms_compat_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/cxx_oper_keyword_ms_compat.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/cxx_oper_keyword_ms_compat.cpp -E -verify -fms-extensions
    RUN("%clang_cc1 %s -E -verify -fms-extensions");
  }

  @Test
  public void test_cxx_oper_spelling_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/cxx_oper_spelling.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -E ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/cxx_oper_spelling.cpp | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/cxx_oper_spelling.cpp
    RUN("%clang_cc1 -E %s")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_cxx_or_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/cxx_or.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -DA -DB -E ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/cxx_or.cpp | grep 'int a = 37 == 37'
    RUN("%clang_cc1 -DA -DB -E %s")./*|*/
      I("grep 'int a = 37 == 37'");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -DA -E ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/cxx_or.cpp | grep 'int a = 37 == 37'
    RUN("%clang_cc1 -DA -E %s")./*|*/
      I("grep 'int a = 37 == 37'");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -DB -E ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/cxx_or.cpp | grep 'int a = 37 == 37'
    RUN("%clang_cc1 -DB -E %s")./*|*/
      I("grep 'int a = 37 == 37'");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -E ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/cxx_or.cpp | grep 'int a = 927 == 927'
    RUN("%clang_cc1 -E %s")./*|*/
      I("grep 'int a = 927 == 927'");
  }

  @Test
  public void test_cxx_true_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/cxx_true.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -E ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/cxx_true.cpp -x c++ | ${LLVM_SRC}/build/bin/FileCheck -check-prefix CPP ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/cxx_true.cpp
    RUN("%clang_cc1 -E %s -x c++")./*|*/
      I("FileCheck -check-prefix CPP %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -E ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/cxx_true.cpp -x c | ${LLVM_SRC}/build/bin/FileCheck -check-prefix C ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/cxx_true.cpp
    RUN("%clang_cc1 -E %s -x c")./*|*/
      I("FileCheck -check-prefix C %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -E ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/cxx_true.cpp -x c++ -verify -Wundef
    RUN("%clang_cc1 -E %s -x c++ -verify -Wundef");
  }

  @Test
  public void test_cxx_xor_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/cxx_xor.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -DA=1 -DB=1 -E ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/cxx_xor.cpp | grep 'int a = 927 == 927'
    RUN("%clang_cc1 -DA=1 -DB=1 -E %s")./*|*/
      I("grep 'int a = 927 == 927'");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -DA=0 -DB=1 -E ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/cxx_xor.cpp | grep 'int a = 37 == 37'
    RUN("%clang_cc1 -DA=0 -DB=1 -E %s")./*|*/
      I("grep 'int a = 37 == 37'");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -DA=1 -DB=0 -E ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/cxx_xor.cpp | grep 'int a = 37 == 37'
    RUN("%clang_cc1 -DA=1 -DB=0 -E %s")./*|*/
      I("grep 'int a = 37 == 37'");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -DA=0 -DB=0 -E ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/cxx_xor.cpp | grep 'int a = 927 == 927'
    RUN("%clang_cc1 -DA=0 -DB=0 -E %s")./*|*/
      I("grep 'int a = 927 == 927'");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -E ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/cxx_xor.cpp | grep 'int a = 927 == 927'
    RUN("%clang_cc1 -E %s")./*|*/
      I("grep 'int a = 927 == 927'");
  }

  @Test
  public void test_dependencies_and_pp_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/dependencies-and-pp.c");
    // ${LLVM_SRC}/build/bin/clang -E -o ${TEST_TEMP_DIR}/dependencies-and-pp.c.tmp.1 ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/dependencies-and-pp.c
    RUN("%clang -E -o %t.1 %s");
    // ${LLVM_SRC}/build/bin/clang -E -MD -MF ${TEST_TEMP_DIR}/dependencies-and-pp.c.tmp.d -MT foo -o ${TEST_TEMP_DIR}/dependencies-and-pp.c.tmp.2 ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/dependencies-and-pp.c
    RUN("%clang -E -MD -MF %t.d -MT foo -o %t.2 %s");
    // diff ${TEST_TEMP_DIR}/dependencies-and-pp.c.tmp.1 ${TEST_TEMP_DIR}/dependencies-and-pp.c.tmp.2
    RUN("diff %t.1 %t.2");
    // ${LLVM_SRC}/build/bin/FileCheck -check-prefix=TEST1 ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/dependencies-and-pp.c < ${TEST_TEMP_DIR}/dependencies-and-pp.c.tmp.d
    RUN("FileCheck -check-prefix=TEST1 %s < %t.d");
    // ${LLVM_SRC}/build/bin/clang -E -MD -MF ${TEST_TEMP_DIR}/dependencies-and-pp.c.tmp.d -MQ foo -o ${TEST_TEMP_DIR}/dependencies-and-pp.c.tmp ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/dependencies-and-pp.c
    RUN("%clang -E -MD -MF %t.d -MQ foo -o %t %s");
    // ${LLVM_SRC}/build/bin/FileCheck -check-prefix=TEST2 ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/dependencies-and-pp.c < ${TEST_TEMP_DIR}/dependencies-and-pp.c.tmp.d
    RUN("FileCheck -check-prefix=TEST2 %s < %t.d");
    // ${LLVM_SRC}/build/bin/clang -E -MD -MF ${TEST_TEMP_DIR}/dependencies-and-pp.c.tmp.d -MQ '$fo\ooo ooo\ ooo\\ ooo#oo' -o ${TEST_TEMP_DIR}/dependencies-and-pp.c.tmp ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/dependencies-and-pp.c
    RUN("%clang -E -MD -MF %t.d -MQ '$fo\\ooo ooo\\ ooo\\\\ ooo#oo' -o %t %s");
    // ${LLVM_SRC}/build/bin/FileCheck -check-prefix=TEST3 ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/dependencies-and-pp.c < ${TEST_TEMP_DIR}/dependencies-and-pp.c.tmp.d
    RUN("FileCheck -check-prefix=TEST3 %s < %t.d");
    // ${LLVM_SRC}/build/bin/clang -E -MD -MF ${TEST_TEMP_DIR}/dependencies-and-pp.c.tmp.d -MT foo -MT bar -MT baz -o ${TEST_TEMP_DIR}/dependencies-and-pp.c.tmp ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/dependencies-and-pp.c
    RUN("%clang -E -MD -MF %t.d -MT foo -MT bar -MT baz -o %t %s");
    // diff ${TEST_TEMP_DIR}/dependencies-and-pp.c.tmp.1 ${TEST_TEMP_DIR}/dependencies-and-pp.c.tmp
    RUN("diff %t.1 %t");
    // ${LLVM_SRC}/build/bin/FileCheck -check-prefix=TEST4 ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/dependencies-and-pp.c < ${TEST_TEMP_DIR}/dependencies-and-pp.c.tmp.d
    RUN("FileCheck -check-prefix=TEST4 %s < %t.d");
    // ${LLVM_SRC}/build/bin/clang -E -MD -MF ${TEST_TEMP_DIR}/dependencies-and-pp.c.tmp.d -MT foo -MQ '$(bar)' -MT 'b az' -MQ 'qu ux' -MQ ' space' -o ${TEST_TEMP_DIR}/dependencies-and-pp.c.tmp ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/dependencies-and-pp.c
    RUN("%clang -E -MD -MF %t.d -MT foo -MQ '$(bar)' -MT 'b az' -MQ 'qu ux' -MQ ' space' -o %t %s");
    // ${LLVM_SRC}/build/bin/FileCheck -check-prefix=TEST5 ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/dependencies-and-pp.c < ${TEST_TEMP_DIR}/dependencies-and-pp.c.tmp.d
    RUN("FileCheck -check-prefix=TEST5 %s < %t.d");
  }

  @Test
  public void test_directive_invalid_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/directive-invalid.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -E -verify ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/directive-invalid.c
    RUN("%clang_cc1 -E -verify %s");
  }

  @Test
  public void test_disabled_cond_diags_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/disabled-cond-diags.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -E -verify ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/disabled-cond-diags.c
    RUN("%clang_cc1 -E -verify %s");
  }

  @Test
  public void test_disabled_cond_diags2_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/disabled-cond-diags2.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -Eonly -verify ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/disabled-cond-diags2.c
    RUN("%clang_cc1 -Eonly -verify %s");
  }

  @Test
  public void test_dump_macros_spacing_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/dump-macros-spacing.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -E -dD < ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/dump-macros-spacing.c | grep stdin | grep -v define
    RUN("%clang_cc1 -E -dD < %s")./*|*/
      I("grep stdin")./*|*/
      I("grep -v define");
  }

  @Test
  public void test_dump_macros_undef_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/dump-macros-undef.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -E -dD ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/dump-macros-undef.c | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/dump-macros-undef.c
    RUN("%clang_cc1 -E -dD %s")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_dump_options_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/dump-options.c");
    // ${LLVM_SRC}/build/bin/clang ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/dump-options.c -E -dD | grep __INTMAX_MAX__
    RUN("%clang %s -E -dD")./*|*/
      I("grep __INTMAX_MAX__");
    // ${LLVM_SRC}/build/bin/clang ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/dump-options.c -E -dM | grep __INTMAX_MAX__
    RUN("%clang %s -E -dM")./*|*/
      I("grep __INTMAX_MAX__");
  }

  @Test
  public void test_dump_macros_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/dump_macros.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -E -dM ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/dump_macros.c -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/dump_macros.c -strict-whitespace
    RUN("%clang_cc1 -E -dM %s -o -")./*|*/
      I("FileCheck %s -strict-whitespace");
  }

  @Test
  public void test_dumptokens_phyloc_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/dumptokens_phyloc.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -dump-tokens ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/dumptokens_phyloc.c 2>&1 | grep Spelling=.*dumptokens_phyloc.c:3:20
    RUN("%clang_cc1 -dump-tokens %s 2>&1")./*|*/
      I("grep \"Spelling=.*dumptokens_phyloc.c:3:20\"");
  }

  @Test
  public void test_elfiamcu_predefines_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/elfiamcu-predefines.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -E -dM -triple i586-intel-elfiamcu | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/elfiamcu-predefines.c
    RUN("%clang_cc1 -E -dM -triple i586-intel-elfiamcu")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_expr_comma_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/expr_comma.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -E ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/expr_comma.c -std=c89 -pedantic-errors
    RUN("not %clang_cc1 -E %s -std=c89 -pedantic-errors");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -E ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/expr_comma.c -std=c99 -pedantic-errors
    RUN("%clang_cc1 -E %s -std=c99 -pedantic-errors");
  }

  @Test
  public void test_expr_define_expansion_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/expr_define_expansion.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/expr_define_expansion.c -E -CC -verify
    RUN("%clang_cc1 %s -E -CC -verify");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/expr_define_expansion.c -E -CC -DPEDANTIC -pedantic -verify
    RUN("%clang_cc1 %s -E -CC -DPEDANTIC -pedantic -verify");
  }

  @Test
  public void test_expr_invalid_tok_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/expr_invalid_tok.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -E ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/expr_invalid_tok.c 2>&1 | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/expr_invalid_tok.c
    RUN("not %clang_cc1 -E %s 2>&1")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_expr_liveness_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/expr_liveness.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -E ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/expr_liveness.c -DNO_ERRORS -Werror -Wundef
    RUN("%clang_cc1 -E %s -DNO_ERRORS -Werror -Wundef");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -E ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/expr_liveness.c
    RUN("not %clang_cc1 -E %s");
  }

  @Test
  public void test_expr_multichar_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/expr_multichar.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc < ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/expr_multichar.c -E -verify -triple i686-pc-linux-gnu
    RUN("%clang_cc1 < %s -E -verify -triple i686-pc-linux-gnu");
  }

  @Test
  public void test_expr_usual_conversions_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/expr_usual_conversions.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/expr_usual_conversions.c -E -verify
    RUN("%clang_cc1 %s -E -verify");
  }

  @Test
  public void test_extension_warning_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/extension-warning.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -pedantic ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/extension-warning.c
    RUN("%clang_cc1 -fsyntax-only -verify -pedantic %s");
  }

  @Test
  public void test_feature_tests_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/feature_tests.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/feature_tests.c -triple=i686-apple-darwin9 -verify -DVERIFY
    RUN("%clang_cc1 %s -triple=i686-apple-darwin9 -verify -DVERIFY");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/feature_tests.c -E -triple=i686-apple-darwin9
    RUN("%clang_cc1 %s -E -triple=i686-apple-darwin9");
  }

  @Test
  public void test_first_line_indent_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/first-line-indent.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -E ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/first-line-indent.c | ${LLVM_SRC}/build/bin/FileCheck -strict-whitespace ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/first-line-indent.c
    RUN("%clang_cc1 -E %s")./*|*/
      I("FileCheck -strict-whitespace %s");
  }

  @Test
  public void test_function_macro_file_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/function_macro_file.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -E -P ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/function_macro_file.c | grep f
    RUN("%clang_cc1 -E -P %s")./*|*/
      I("grep f");
  }

  @Test
  public void test_has_attribute_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/has_attribute.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple arm-unknown-linux -verify -E ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/has_attribute.c -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/has_attribute.c
    RUN("%clang_cc1 -triple arm-unknown-linux -verify -E %s -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_has_attribute_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/has_attribute.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i386-unknown-unknown -fms-compatibility -std=c++11 -E ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/has_attribute.cpp -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/has_attribute.cpp
    RUN("%clang_cc1 -triple i386-unknown-unknown -fms-compatibility -std=c++11 -E %s -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_has_include_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/has_include.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -ffreestanding -Eonly -verify ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/has_include.c
    RUN("%clang_cc1 -ffreestanding -Eonly -verify %s");
  }

  @Test
  public void test_hash_line_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/hash_line.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -E ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/hash_line.c | ${LLVM_SRC}/build/bin/FileCheck --strict-whitespace ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/hash_line.c
    RUN("%clang_cc1 -E %s")./*|*/
      I("FileCheck --strict-whitespace %s");
  }

  @Test
  public void test_hash_space_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/hash_space.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/hash_space.c -E | grep ' #'
    RUN("%clang_cc1 %s -E")./*|*/
      I("grep \" #\"");
  }

  @Test
  public void test_header_lookup1_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/header_lookup1.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/header_lookup1.c -E | grep stddef.h.*3
    RUN("%clang_cc1 %s -E")./*|*/
      I("grep 'stddef.h.*3'");
  }

  @Test
  public void test_headermap_rel_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/headermap-rel.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -E ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/headermap-rel.c -o ${TEST_TEMP_DIR}/headermap-rel.c.tmp.i -I ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/Inputs/headermap-rel/foo.hmap -F ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/Inputs/headermap-rel
    RUN("%clang_cc1 -E %s -o %t.i -I %S/Inputs/headermap-rel/foo.hmap -F %S/Inputs/headermap-rel");
    // ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/headermap-rel.c -input-file ${TEST_TEMP_DIR}/headermap-rel.c.tmp.i
    RUN("FileCheck %s -input-file %t.i");
  }

  @Test
  public void test_headermap_rel2_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/headermap-rel2.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -v -fsyntax-only ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/headermap-rel2.c -iquote ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/Inputs/headermap-rel2/project-headers.hmap -isystem ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/Inputs/headermap-rel2/system/usr/include -I ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/Inputs/headermap-rel2 -H
    RUN("%clang_cc1 -v -fsyntax-only %s -iquote %S/Inputs/headermap-rel2/project-headers.hmap -isystem %S/Inputs/headermap-rel2/system/usr/include -I %S/Inputs/headermap-rel2 -H");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/headermap-rel2.c -iquote ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/Inputs/headermap-rel2/project-headers.hmap -isystem ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/Inputs/headermap-rel2/system/usr/include -I ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/Inputs/headermap-rel2 -H 2> ${TEST_TEMP_DIR}/headermap-rel2.c.tmp.out
    RUN("%clang_cc1 -fsyntax-only %s -iquote %S/Inputs/headermap-rel2/project-headers.hmap -isystem %S/Inputs/headermap-rel2/system/usr/include -I %S/Inputs/headermap-rel2 -H 2> %t.out");
    // ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/headermap-rel2.c -input-file ${TEST_TEMP_DIR}/headermap-rel2.c.tmp.out
    RUN("FileCheck %s -input-file %t.out");
  }

  @Test
  public void test_hexagon_predefines_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/hexagon-predefines.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -E -dM -triple hexagon-unknown-elf -target-cpu hexagonv5 ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/hexagon-predefines.c | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/hexagon-predefines.c -check-prefix CHECK-V5
    RUN("%clang_cc1 -E -dM -triple hexagon-unknown-elf -target-cpu hexagonv5 %s")./*|*/
      I("FileCheck %s -check-prefix CHECK-V5");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -E -dM -triple hexagon-unknown-elf -target-cpu hexagonv55 ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/hexagon-predefines.c | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/hexagon-predefines.c -check-prefix CHECK-V55
    RUN("%clang_cc1 -E -dM -triple hexagon-unknown-elf -target-cpu hexagonv55 %s")./*|*/
      I("FileCheck %s -check-prefix CHECK-V55");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -E -dM -triple hexagon-unknown-elf -target-cpu hexagonv60 ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/hexagon-predefines.c | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/hexagon-predefines.c -check-prefix CHECK-V60
    RUN("%clang_cc1 -E -dM -triple hexagon-unknown-elf -target-cpu hexagonv60 %s")./*|*/
      I("FileCheck %s -check-prefix CHECK-V60");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -E -dM -triple hexagon-unknown-elf -target-cpu hexagonv60 -target-feature +hvx ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/hexagon-predefines.c | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/hexagon-predefines.c -check-prefix CHECK-V60HVX
    RUN("%clang_cc1 -E -dM -triple hexagon-unknown-elf -target-cpu hexagonv60 -target-feature +hvx %s")./*|*/
      I("FileCheck %s -check-prefix CHECK-V60HVX");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -E -dM -triple hexagon-unknown-elf -target-cpu hexagonv60 -target-feature +hvx-double ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/hexagon-predefines.c | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/hexagon-predefines.c -check-prefix CHECK-V60HVXD
    RUN("%clang_cc1 -E -dM -triple hexagon-unknown-elf -target-cpu hexagonv60 -target-feature +hvx-double  %s")./*|*/
      I("FileCheck %s -check-prefix CHECK-V60HVXD");
  }

  @Test
  public void test_if_warning_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/if_warning.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/if_warning.c -Eonly -Werror=undef -verify
    RUN("%clang_cc1 %s -Eonly -Werror=undef -verify");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/if_warning.c -Eonly -Werror-undef -verify
    RUN("%clang_cc1 %s -Eonly -Werror-undef -verify");
  }

  @Test
  public void test_ifdef_recover_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/ifdef-recover.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -E -verify ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/ifdef-recover.c
    RUN("%clang_cc1 -E -verify %s");
  }

  @Test
  public void test_ignore_pragmas_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/ignore-pragmas.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -E ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/ignore-pragmas.c -Wall -verify
    RUN("%clang_cc1 -E %s -Wall -verify");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -Eonly ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/ignore-pragmas.c -Wall -verify
    RUN("%clang_cc1 -Eonly %s -Wall -verify");
    // ${LLVM_SRC}/build/bin/clang -M -Wall ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/ignore-pragmas.c -Xclang -verify
    RUN("%clang -M -Wall %s -Xclang -verify");
    // ${LLVM_SRC}/build/bin/clang -E -frewrite-includes ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/ignore-pragmas.c -Wall -Xclang -verify
    RUN("%clang -E -frewrite-includes %s -Wall -Xclang -verify");
    // ${LLVM_SRC}/build/bin/clang -E -dD -dM ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/ignore-pragmas.c -Wall -Xclang -verify
    RUN("%clang -E -dD -dM %s -Wall -Xclang -verify");
  }

  @Test
  public void test_import_self_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/import_self.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -E '-I${LLVM_SRC}/llvm/tools/clang/test/Preprocessor' ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/import_self.c | grep BODY_OF_FILE | wc -l | grep 1
    RUN("%clang_cc1 -E -I%S %s")./*|*/
      I("grep BODY_OF_FILE")./*|*/
      I("wc -l")./*|*/
      I("grep 1");
  }

  @Test
  public void test_include_directive1_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/include-directive1.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -E ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/include-directive1.c -fno-caret-diagnostics 2>&1 >/dev/null | grep 'file successfully included' | ${LLVM_SRC}/build/bin/count 3
    RUN("%clang_cc1 -E %s -fno-caret-diagnostics 2>&1 >/dev/null")./*|*/
      I("grep 'file successfully included'")./*|*/
      I("count 3");
  }

  @Test
  public void test_include_directive2_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/include-directive2.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -ffreestanding -Eonly -verify ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/include-directive2.c
    RUN("%clang_cc1 -ffreestanding -Eonly -verify %s");
  }

  @Test
  public void test_include_directive3_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/include-directive3.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -include ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/file_to_include.h -E ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/include-directive3.c -fno-caret-diagnostics 2>&1 >/dev/null | grep 'file successfully included' | ${LLVM_SRC}/build/bin/count 1
    RUN("%clang_cc1 -include %S/file_to_include.h -E %s -fno-caret-diagnostics 2>&1 >/dev/null")./*|*/
      I("grep 'file successfully included'")./*|*/
      I("count 1");
  }

  @Test
  public void test_include_macros_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/include-macros.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -E -Dtest=FOO -imacros ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/pr2086.h ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/include-macros.c | grep 'HERE: test'
    RUN("%clang_cc1 -E -Dtest=FOO -imacros %S/pr2086.h %s")./*|*/
      I("grep 'HERE: test'");
  }

  @Test
  public void test_include_pth_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/include-pth.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-pth ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/include-pth.c -o ${TEST_TEMP_DIR}/include-pth.c.tmp
    RUN("%clang_cc1 -emit-pth %s -o %t");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -include-pth ${TEST_TEMP_DIR}/include-pth.c.tmp ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/include-pth.c -E | grep file_to_include | ${LLVM_SRC}/build/bin/count 2
    RUN("%clang_cc1 -include-pth %t %s -E")./*|*/
      I("grep 'file_to_include'")./*|*/
      I("count 2");
  }

  @Test
  public void test_indent_macro_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/indent_macro.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -E ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/indent_macro.c | grep '^   zzap$'
    RUN("%clang_cc1 -E %s")./*|*/
      I("grep '^   zzap$'");
  }

  @Test
  public void test_init_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/init.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -E -dM -x assembler-with-cpp < /dev/null | ${LLVM_SRC}/build/bin/FileCheck -match-full-lines -check-prefix ASM ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/init.c
    RUN("%clang_cc1 -E -dM -x assembler-with-cpp < /dev/null")./*|*/
      I("FileCheck -match-full-lines -check-prefix ASM %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fblocks -E -dM < /dev/null | ${LLVM_SRC}/build/bin/FileCheck -match-full-lines -check-prefix BLOCKS ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/init.c
    RUN("%clang_cc1 -fblocks -E -dM < /dev/null")./*|*/
      I("FileCheck -match-full-lines -check-prefix BLOCKS %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x c++ -std=c++1z -E -dM < /dev/null | ${LLVM_SRC}/build/bin/FileCheck -match-full-lines -check-prefix CXX1Z ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/init.c
    RUN("%clang_cc1 -x c++ -std=c++1z -E -dM < /dev/null")./*|*/
      I("FileCheck -match-full-lines -check-prefix CXX1Z %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x c++ -std=c++1y -E -dM < /dev/null | ${LLVM_SRC}/build/bin/FileCheck -match-full-lines -check-prefix CXX1Y ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/init.c
    RUN("%clang_cc1 -x c++ -std=c++1y -E -dM < /dev/null")./*|*/
      I("FileCheck -match-full-lines -check-prefix CXX1Y %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x c++ -std=c++11 -E -dM < /dev/null | ${LLVM_SRC}/build/bin/FileCheck -match-full-lines -check-prefix CXX11 ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/init.c
    RUN("%clang_cc1 -x c++ -std=c++11 -E -dM < /dev/null")./*|*/
      I("FileCheck -match-full-lines -check-prefix CXX11 %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x c++ -std=c++98 -E -dM < /dev/null | ${LLVM_SRC}/build/bin/FileCheck -match-full-lines -check-prefix CXX98 ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/init.c
    RUN("%clang_cc1 -x c++ -std=c++98 -E -dM < /dev/null")./*|*/
      I("FileCheck -match-full-lines -check-prefix CXX98 %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fdeprecated-macro -E -dM < /dev/null | ${LLVM_SRC}/build/bin/FileCheck -match-full-lines -check-prefix DEPRECATED ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/init.c
    RUN("%clang_cc1 -fdeprecated-macro -E -dM < /dev/null")./*|*/
      I("FileCheck -match-full-lines -check-prefix DEPRECATED %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c99 -E -dM < /dev/null | ${LLVM_SRC}/build/bin/FileCheck -match-full-lines -check-prefix C99 ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/init.c
    RUN("%clang_cc1 -std=c99 -E -dM < /dev/null")./*|*/
      I("FileCheck -match-full-lines -check-prefix C99 %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c11 -E -dM < /dev/null | ${LLVM_SRC}/build/bin/FileCheck -match-full-lines -check-prefix C11 ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/init.c
    RUN("%clang_cc1 -std=c11 -E -dM < /dev/null")./*|*/
      I("FileCheck -match-full-lines -check-prefix C11 %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -E -dM < /dev/null | ${LLVM_SRC}/build/bin/FileCheck -match-full-lines -check-prefix COMMON ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/init.c
    RUN("%clang_cc1 -E -dM < /dev/null")./*|*/
      I("FileCheck -match-full-lines -check-prefix COMMON %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -E -dM -triple=x86_64-pc-win32 < /dev/null | ${LLVM_SRC}/build/bin/FileCheck -match-full-lines -check-prefix C-DEFAULT ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/init.c
    RUN("%clang_cc1 -E -dM -triple=x86_64-pc-win32 < /dev/null")./*|*/
      I("FileCheck -match-full-lines -check-prefix C-DEFAULT %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -E -dM -triple=x86_64-pc-linux-gnu < /dev/null | ${LLVM_SRC}/build/bin/FileCheck -match-full-lines -check-prefix C-DEFAULT ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/init.c
    RUN("%clang_cc1 -E -dM -triple=x86_64-pc-linux-gnu < /dev/null")./*|*/
      I("FileCheck -match-full-lines -check-prefix C-DEFAULT %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -E -dM -triple=x86_64-apple-darwin < /dev/null | ${LLVM_SRC}/build/bin/FileCheck -match-full-lines -check-prefix C-DEFAULT ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/init.c
    RUN("%clang_cc1 -E -dM -triple=x86_64-apple-darwin < /dev/null")./*|*/
      I("FileCheck -match-full-lines -check-prefix C-DEFAULT %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -E -dM -triple=armv7a-apple-darwin < /dev/null | ${LLVM_SRC}/build/bin/FileCheck -match-full-lines -check-prefix C-DEFAULT ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/init.c
    RUN("%clang_cc1 -E -dM -triple=armv7a-apple-darwin < /dev/null")./*|*/
      I("FileCheck -match-full-lines -check-prefix C-DEFAULT %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -ffreestanding -E -dM < /dev/null | ${LLVM_SRC}/build/bin/FileCheck -match-full-lines -check-prefix FREESTANDING ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/init.c
    RUN("%clang_cc1 -ffreestanding -E -dM < /dev/null")./*|*/
      I("FileCheck -match-full-lines -check-prefix FREESTANDING %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x c++ -std=gnu++1z -E -dM < /dev/null | ${LLVM_SRC}/build/bin/FileCheck -match-full-lines -check-prefix GXX1Z ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/init.c
    RUN("%clang_cc1 -x c++ -std=gnu++1z -E -dM < /dev/null")./*|*/
      I("FileCheck -match-full-lines -check-prefix GXX1Z %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x c++ -std=gnu++1y -E -dM < /dev/null | ${LLVM_SRC}/build/bin/FileCheck -match-full-lines -check-prefix GXX1Y ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/init.c
    RUN("%clang_cc1 -x c++ -std=gnu++1y -E -dM < /dev/null")./*|*/
      I("FileCheck -match-full-lines -check-prefix GXX1Y %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x c++ -std=gnu++11 -E -dM < /dev/null | ${LLVM_SRC}/build/bin/FileCheck -match-full-lines -check-prefix GXX11 ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/init.c
    RUN("%clang_cc1 -x c++ -std=gnu++11 -E -dM < /dev/null")./*|*/
      I("FileCheck -match-full-lines -check-prefix GXX11 %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x c++ -std=gnu++98 -E -dM < /dev/null | ${LLVM_SRC}/build/bin/FileCheck -match-full-lines -check-prefix GXX98 ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/init.c
    RUN("%clang_cc1 -x c++ -std=gnu++98 -E -dM < /dev/null")./*|*/
      I("FileCheck -match-full-lines -check-prefix GXX98 %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=iso9899:199409 -E -dM < /dev/null | ${LLVM_SRC}/build/bin/FileCheck -match-full-lines -check-prefix C94 ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/init.c
    RUN("%clang_cc1 -std=iso9899:199409 -E -dM < /dev/null")./*|*/
      I("FileCheck -match-full-lines -check-prefix C94 %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fms-extensions -triple i686-pc-win32 -E -dM < /dev/null | ${LLVM_SRC}/build/bin/FileCheck -match-full-lines -check-prefix MSEXT ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/init.c
    RUN("%clang_cc1 -fms-extensions -triple i686-pc-win32 -E -dM < /dev/null")./*|*/
      I("FileCheck -match-full-lines -check-prefix MSEXT %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x c++ -fms-extensions -triple i686-pc-win32 -E -dM < /dev/null | ${LLVM_SRC}/build/bin/FileCheck -match-full-lines -check-prefix MSEXT-CXX ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/init.c
    RUN("%clang_cc1 -x c++ -fms-extensions -triple i686-pc-win32 -E -dM < /dev/null")./*|*/
      I("FileCheck -match-full-lines -check-prefix MSEXT-CXX %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x c++ -fno-wchar -fms-extensions -triple i686-pc-win32 -E -dM < /dev/null | ${LLVM_SRC}/build/bin/FileCheck -match-full-lines -check-prefix MSEXT-CXX-NOWCHAR ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/init.c
    RUN("%clang_cc1 -x c++ -fno-wchar -fms-extensions -triple i686-pc-win32 -E -dM < /dev/null")./*|*/
      I("FileCheck -match-full-lines -check-prefix MSEXT-CXX-NOWCHAR %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x objective-c -E -dM < /dev/null | ${LLVM_SRC}/build/bin/FileCheck -match-full-lines -check-prefix OBJC ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/init.c
    RUN("%clang_cc1 -x objective-c -E -dM < /dev/null")./*|*/
      I("FileCheck -match-full-lines -check-prefix OBJC %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x objective-c -fobjc-gc -E -dM < /dev/null | ${LLVM_SRC}/build/bin/FileCheck -match-full-lines -check-prefix OBJCGC ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/init.c
    RUN("%clang_cc1 -x objective-c -fobjc-gc -E -dM < /dev/null")./*|*/
      I("FileCheck -match-full-lines -check-prefix OBJCGC %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x objective-c -fobjc-exceptions -E -dM < /dev/null | ${LLVM_SRC}/build/bin/FileCheck -match-full-lines -check-prefix NONFRAGILE ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/init.c
    RUN("%clang_cc1 -x objective-c -fobjc-exceptions -E -dM < /dev/null")./*|*/
      I("FileCheck -match-full-lines -check-prefix NONFRAGILE %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -E -dM < /dev/null | ${LLVM_SRC}/build/bin/FileCheck -match-full-lines -check-prefix O0 ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/init.c
    RUN("%clang_cc1 -E -dM < /dev/null")./*|*/
      I("FileCheck -match-full-lines -check-prefix O0 %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fno-inline -O3 -E -dM < /dev/null | ${LLVM_SRC}/build/bin/FileCheck -match-full-lines -check-prefix NO_INLINE ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/init.c
    RUN("%clang_cc1 -fno-inline -O3 -E -dM < /dev/null")./*|*/
      I("FileCheck -match-full-lines -check-prefix NO_INLINE %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -O1 -E -dM < /dev/null | ${LLVM_SRC}/build/bin/FileCheck -match-full-lines -check-prefix O1 ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/init.c
    RUN("%clang_cc1 -O1 -E -dM < /dev/null")./*|*/
      I("FileCheck -match-full-lines -check-prefix O1 %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -Os -E -dM < /dev/null | ${LLVM_SRC}/build/bin/FileCheck -match-full-lines -check-prefix Os ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/init.c
    RUN("%clang_cc1 -Os -E -dM < /dev/null")./*|*/
      I("FileCheck -match-full-lines -check-prefix Os %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -Oz -E -dM < /dev/null | ${LLVM_SRC}/build/bin/FileCheck -match-full-lines -check-prefix Oz ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/init.c
    RUN("%clang_cc1 -Oz -E -dM < /dev/null")./*|*/
      I("FileCheck -match-full-lines -check-prefix Oz %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fpascal-strings -E -dM < /dev/null | ${LLVM_SRC}/build/bin/FileCheck -match-full-lines -check-prefix PASCAL ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/init.c
    RUN("%clang_cc1 -fpascal-strings -E -dM < /dev/null")./*|*/
      I("FileCheck -match-full-lines -check-prefix PASCAL %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -E -dM < /dev/null | ${LLVM_SRC}/build/bin/FileCheck -match-full-lines -check-prefix SCHAR ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/init.c
    RUN("%clang_cc1 -E -dM < /dev/null")./*|*/
      I("FileCheck -match-full-lines -check-prefix SCHAR %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -E -dM -fshort-wchar < /dev/null | ${LLVM_SRC}/build/bin/FileCheck -match-full-lines -check-prefix SHORTWCHAR ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/init.c
    RUN("%clang_cc1 -E -dM -fshort-wchar < /dev/null")./*|*/
      I("FileCheck -match-full-lines -check-prefix SHORTWCHAR %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -E -dM -fno-short-wchar -triple=x86_64-w64-mingw32 < /dev/null | ${LLVM_SRC}/build/bin/FileCheck -match-full-lines -check-prefix SHORTWCHAR ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/init.c
    RUN("%clang_cc1 -E -dM -fno-short-wchar -triple=x86_64-w64-mingw32 < /dev/null")./*|*/
      I("FileCheck -match-full-lines -check-prefix SHORTWCHAR %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -E -dM -fno-short-wchar -triple=i686-unknown-unknown < /dev/null | ${LLVM_SRC}/build/bin/FileCheck -match-full-lines -check-prefix SHORTWCHAR2 ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/init.c
    RUN("%clang_cc1 -E -dM -fno-short-wchar -triple=i686-unknown-unknown < /dev/null")./*|*/
      I("FileCheck -match-full-lines -check-prefix SHORTWCHAR2 %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -E -dM -fno-short-wchar -triple=x86_64-unknown-unknown < /dev/null | ${LLVM_SRC}/build/bin/FileCheck -match-full-lines -check-prefix SHORTWCHAR2 ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/init.c
    RUN("%clang_cc1 -E -dM -fno-short-wchar -triple=x86_64-unknown-unknown < /dev/null")./*|*/
      I("FileCheck -match-full-lines -check-prefix SHORTWCHAR2 %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -E -dM -ffreestanding -triple=aarch64-none-none < /dev/null | ${LLVM_SRC}/build/bin/FileCheck -match-full-lines -check-prefix AARCH64 ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/init.c
    RUN("%clang_cc1 -E -dM -ffreestanding -triple=aarch64-none-none < /dev/null")./*|*/
      I("FileCheck -match-full-lines -check-prefix AARCH64 %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -E -dM -ffreestanding -triple=arm64-none-none < /dev/null | ${LLVM_SRC}/build/bin/FileCheck -match-full-lines -check-prefix AARCH64 ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/init.c
    RUN("%clang_cc1 -E -dM -ffreestanding -triple=arm64-none-none < /dev/null")./*|*/
      I("FileCheck -match-full-lines -check-prefix AARCH64 %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -E -dM -ffreestanding -triple=aarch64_be-none-none < /dev/null | ${LLVM_SRC}/build/bin/FileCheck -match-full-lines -check-prefix AARCH64-BE ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/init.c
    RUN("%clang_cc1 -E -dM -ffreestanding -triple=aarch64_be-none-none < /dev/null")./*|*/
      I("FileCheck -match-full-lines -check-prefix AARCH64-BE %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -E -dM -ffreestanding -triple=aarch64-netbsd < /dev/null | ${LLVM_SRC}/build/bin/FileCheck -match-full-lines -check-prefix AARCH64-NETBSD ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/init.c
    RUN("%clang_cc1 -E -dM -ffreestanding -triple=aarch64-netbsd < /dev/null")./*|*/
      I("FileCheck -match-full-lines -check-prefix AARCH64-NETBSD %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -E -dM -ffreestanding -triple=aarch64-freebsd11 < /dev/null | ${LLVM_SRC}/build/bin/FileCheck -match-full-lines -check-prefix AARCH64-FREEBSD ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/init.c
    RUN("%clang_cc1 -E -dM -ffreestanding -triple=aarch64-freebsd11 < /dev/null")./*|*/
      I("FileCheck -match-full-lines -check-prefix AARCH64-FREEBSD %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -E -dM -ffreestanding -triple=aarch64-apple-ios7.0 < /dev/null | ${LLVM_SRC}/build/bin/FileCheck -match-full-lines -check-prefix AARCH64-DARWIN ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/init.c
    RUN("%clang_cc1 -E -dM -ffreestanding -triple=aarch64-apple-ios7.0 < /dev/null")./*|*/
      I("FileCheck -match-full-lines -check-prefix AARCH64-DARWIN %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -E -dM -ffreestanding -triple=arm-none-none < /dev/null | ${LLVM_SRC}/build/bin/FileCheck -match-full-lines -check-prefix ARM ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/init.c
    RUN("%clang_cc1 -E -dM -ffreestanding -triple=arm-none-none < /dev/null")./*|*/
      I("FileCheck -match-full-lines -check-prefix ARM %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -E -dM -ffreestanding -triple=armeb-none-none < /dev/null | ${LLVM_SRC}/build/bin/FileCheck -match-full-lines -check-prefix ARM-BE ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/init.c
    RUN("%clang_cc1 -E -dM -ffreestanding -triple=armeb-none-none < /dev/null")./*|*/
      I("FileCheck -match-full-lines -check-prefix ARM-BE %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -E -dM -ffreestanding -triple=arm-none-linux-gnueabi -target-feature +soft-float -target-feature +soft-float-abi < /dev/null | ${LLVM_SRC}/build/bin/FileCheck -match-full-lines -check-prefix ARMEABISOFTFP ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/init.c
    RUN("%clang_cc1 -E -dM -ffreestanding -triple=arm-none-linux-gnueabi -target-feature +soft-float -target-feature +soft-float-abi < /dev/null")./*|*/
      I("FileCheck -match-full-lines -check-prefix ARMEABISOFTFP %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -E -dM -ffreestanding -triple=arm-none-linux-gnueabi < /dev/null | ${LLVM_SRC}/build/bin/FileCheck -match-full-lines -check-prefix ARMEABIHARDFP ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/init.c
    RUN("%clang_cc1 -E -dM -ffreestanding -triple=arm-none-linux-gnueabi < /dev/null")./*|*/
      I("FileCheck -match-full-lines -check-prefix ARMEABIHARDFP %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -E -dM -ffreestanding -triple=arm-netbsd-eabi < /dev/null | ${LLVM_SRC}/build/bin/FileCheck -match-full-lines -check-prefix ARM-NETBSD ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/init.c
    RUN("%clang_cc1 -E -dM -ffreestanding -triple=arm-netbsd-eabi < /dev/null")./*|*/
      I("FileCheck -match-full-lines -check-prefix ARM-NETBSD %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -E -dM -ffreestanding -triple=arm-none-eabi < /dev/null | ${LLVM_SRC}/build/bin/FileCheck -match-full-lines -check-prefix ARM-NONE-EABI ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/init.c
    RUN("%clang_cc1 -E -dM -ffreestanding -triple=arm-none-eabi < /dev/null")./*|*/
      I("FileCheck -match-full-lines -check-prefix ARM-NONE-EABI %s");
    // ${LLVM_SRC}/build/bin/clang -target x86_64-apple-darwin -arch armv7s -x c -E -dM ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/init.c -o - | ${LLVM_SRC}/build/bin/FileCheck -match-full-lines --check-prefix=ARM-MACHO-NO-EABI ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/init.c
    RUN("%clang -target x86_64-apple-darwin -arch armv7s -x c -E -dM %s -o -")./*|*/
      I("FileCheck -match-full-lines --check-prefix=ARM-MACHO-NO-EABI %s");
    // ${LLVM_SRC}/build/bin/clang -target x86_64-apple-darwin -arch armv6m -x c -E -dM ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/init.c -o - | ${LLVM_SRC}/build/bin/FileCheck -match-full-lines --check-prefix=ARM-MACHO-NO-EABI ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/init.c
    RUN("%clang -target x86_64-apple-darwin -arch armv6m -x c -E -dM %s -o -")./*|*/
      I("FileCheck -match-full-lines --check-prefix=ARM-MACHO-NO-EABI %s");
    // ${LLVM_SRC}/build/bin/clang -target x86_64-apple-darwin -arch armv7m -x c -E -dM ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/init.c -o - | ${LLVM_SRC}/build/bin/FileCheck -match-full-lines --check-prefix=ARM-MACHO-NO-EABI ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/init.c
    RUN("%clang -target x86_64-apple-darwin -arch armv7m -x c -E -dM %s -o -")./*|*/
      I("FileCheck -match-full-lines --check-prefix=ARM-MACHO-NO-EABI %s");
    // ${LLVM_SRC}/build/bin/clang -target x86_64-apple-darwin -arch armv7em -x c -E -dM ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/init.c -o - | ${LLVM_SRC}/build/bin/FileCheck -match-full-lines --check-prefix=ARM-MACHO-NO-EABI ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/init.c
    RUN("%clang -target x86_64-apple-darwin -arch armv7em -x c -E -dM %s -o -")./*|*/
      I("FileCheck -match-full-lines --check-prefix=ARM-MACHO-NO-EABI %s");
    // ${LLVM_SRC}/build/bin/clang -target x86_64-apple-darwin -arch armv7 -x c -E -dM ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/init.c -o - | ${LLVM_SRC}/build/bin/FileCheck -match-full-lines --check-prefix=ARM-MACHO-NO-EABI ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/init.c
    RUN("%clang -target x86_64-apple-darwin -arch armv7 -x c -E -dM %s -o -")./*|*/
      I("FileCheck -match-full-lines --check-prefix=ARM-MACHO-NO-EABI %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -E -dM -ffreestanding -triple=armv7-bitrig-gnueabihf < /dev/null | ${LLVM_SRC}/build/bin/FileCheck -match-full-lines -check-prefix ARM-BITRIG ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/init.c
    RUN("%clang_cc1 -E -dM -ffreestanding -triple=armv7-bitrig-gnueabihf < /dev/null")./*|*/
      I("FileCheck -match-full-lines -check-prefix ARM-BITRIG %s");
    // ${LLVM_SRC}/build/bin/clang -target arm -mhwdiv=arm -x c -E -dM ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/init.c -o - | ${LLVM_SRC}/build/bin/FileCheck -match-full-lines --check-prefix=ARMHWDIV-ARM ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/init.c
    RUN("%clang -target arm -mhwdiv=arm -x c -E -dM %s -o -")./*|*/
      I("FileCheck -match-full-lines --check-prefix=ARMHWDIV-ARM %s");
    // ${LLVM_SRC}/build/bin/clang -target arm -mthumb -mhwdiv=thumb -x c -E -dM ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/init.c -o - | ${LLVM_SRC}/build/bin/FileCheck -match-full-lines --check-prefix=THUMBHWDIV-THUMB ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/init.c
    RUN("%clang -target arm -mthumb -mhwdiv=thumb -x c -E -dM %s -o -")./*|*/
      I("FileCheck -match-full-lines --check-prefix=THUMBHWDIV-THUMB %s");
    // ${LLVM_SRC}/build/bin/clang -target arm -x c -E -dM ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/init.c -o - | ${LLVM_SRC}/build/bin/FileCheck -match-full-lines --check-prefix=ARM-FALSE ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/init.c
    RUN("%clang -target arm -x c -E -dM %s -o -")./*|*/
      I("FileCheck -match-full-lines --check-prefix=ARM-FALSE %s");
    // ${LLVM_SRC}/build/bin/clang -target arm -mthumb -x c -E -dM ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/init.c -o - | ${LLVM_SRC}/build/bin/FileCheck -match-full-lines --check-prefix=THUMB-FALSE ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/init.c
    RUN("%clang -target arm -mthumb -x c -E -dM %s -o -")./*|*/
      I("FileCheck -match-full-lines --check-prefix=THUMB-FALSE %s");
    // ${LLVM_SRC}/build/bin/clang -target arm -mhwdiv=thumb -x c -E -dM ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/init.c -o - | ${LLVM_SRC}/build/bin/FileCheck -match-full-lines --check-prefix=THUMBHWDIV-ARM-FALSE ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/init.c
    RUN("%clang -target arm -mhwdiv=thumb -x c -E -dM %s -o -")./*|*/
      I("FileCheck -match-full-lines --check-prefix=THUMBHWDIV-ARM-FALSE %s");
    // ${LLVM_SRC}/build/bin/clang -target arm -mthumb -mhwdiv=arm -x c -E -dM ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/init.c -o - | ${LLVM_SRC}/build/bin/FileCheck -match-full-lines --check-prefix=ARMHWDIV-THUMB-FALSE ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/init.c
    RUN("%clang -target arm -mthumb -mhwdiv=arm -x c -E -dM %s -o -")./*|*/
      I("FileCheck -match-full-lines --check-prefix=ARMHWDIV-THUMB-FALSE %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -E -dM -ffreestanding -triple=armv8-none-none < /dev/null | ${LLVM_SRC}/build/bin/FileCheck -match-full-lines -check-prefix ARMv8 ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/init.c
    RUN("%clang_cc1 -E -dM -ffreestanding -triple=armv8-none-none < /dev/null")./*|*/
      I("FileCheck -match-full-lines -check-prefix ARMv8 %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -E -dM -ffreestanding -triple=armebv8-none-none < /dev/null | ${LLVM_SRC}/build/bin/FileCheck -match-full-lines -check-prefix ARMebv8 ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/init.c
    RUN("%clang_cc1 -E -dM -ffreestanding -triple=armebv8-none-none < /dev/null")./*|*/
      I("FileCheck -match-full-lines -check-prefix ARMebv8 %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -E -dM -ffreestanding -triple=thumbv8 < /dev/null | ${LLVM_SRC}/build/bin/FileCheck -match-full-lines -check-prefix Thumbv8 ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/init.c
    RUN("%clang_cc1 -E -dM -ffreestanding -triple=thumbv8 < /dev/null")./*|*/
      I("FileCheck -match-full-lines -check-prefix Thumbv8 %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -E -dM -ffreestanding -triple=thumbebv8 < /dev/null | ${LLVM_SRC}/build/bin/FileCheck -match-full-lines -check-prefix Thumbebv8 ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/init.c
    RUN("%clang_cc1 -E -dM -ffreestanding -triple=thumbebv8 < /dev/null")./*|*/
      I("FileCheck -match-full-lines -check-prefix Thumbebv8 %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -E -dM -ffreestanding -triple=thumbv5 < /dev/null | ${LLVM_SRC}/build/bin/FileCheck -match-full-lines -check-prefix Thumbv5 ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/init.c
    RUN("%clang_cc1 -E -dM -ffreestanding -triple=thumbv5 < /dev/null")./*|*/
      I("FileCheck -match-full-lines -check-prefix Thumbv5 %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -E -dM -ffreestanding -triple=thumbv6t2 < /dev/null | ${LLVM_SRC}/build/bin/FileCheck -match-full-lines -check-prefix Thumbv6t2 ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/init.c
    RUN("%clang_cc1 -E -dM -ffreestanding -triple=thumbv6t2 < /dev/null")./*|*/
      I("FileCheck -match-full-lines -check-prefix Thumbv6t2 %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -E -dM -ffreestanding -triple=thumbv7 < /dev/null | ${LLVM_SRC}/build/bin/FileCheck -match-full-lines -check-prefix Thumbv7 ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/init.c
    RUN("%clang_cc1 -E -dM -ffreestanding -triple=thumbv7 < /dev/null")./*|*/
      I("FileCheck -match-full-lines -check-prefix Thumbv7 %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -E -dM -ffreestanding -triple=thumbebv7 < /dev/null | ${LLVM_SRC}/build/bin/FileCheck -match-full-lines -check-prefix Thumbebv7 ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/init.c
    RUN("%clang_cc1 -E -dM -ffreestanding -triple=thumbebv7 < /dev/null")./*|*/
      I("FileCheck -match-full-lines -check-prefix Thumbebv7 %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -E -dM -ffreestanding -triple=i386-none-none < /dev/null | ${LLVM_SRC}/build/bin/FileCheck -match-full-lines -check-prefix I386 ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/init.c
    RUN("%clang_cc1 -E -dM -ffreestanding -triple=i386-none-none < /dev/null")./*|*/
      I("FileCheck -match-full-lines -check-prefix I386 %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -E -dM -ffreestanding -triple=i386-pc-linux-gnu -target-cpu pentium4 < /dev/null | ${LLVM_SRC}/build/bin/FileCheck -match-full-lines -check-prefix I386-LINUX ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/init.c
    RUN("%clang_cc1 -E -dM -ffreestanding -triple=i386-pc-linux-gnu -target-cpu pentium4 < /dev/null")./*|*/
      I("FileCheck -match-full-lines -check-prefix I386-LINUX %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -E -dM -ffreestanding -triple=i386-netbsd < /dev/null | ${LLVM_SRC}/build/bin/FileCheck -match-full-lines -check-prefix I386-NETBSD ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/init.c
    RUN("%clang_cc1 -E -dM -ffreestanding -triple=i386-netbsd < /dev/null")./*|*/
      I("FileCheck -match-full-lines -check-prefix I386-NETBSD %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -E -dM -ffreestanding -triple=i386-netbsd -target-feature +sse2 < /dev/null | ${LLVM_SRC}/build/bin/FileCheck -match-full-lines -check-prefix I386-NETBSD-SSE ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/init.c
    RUN("%clang_cc1 -E -dM -ffreestanding -triple=i386-netbsd -target-feature +sse2 < /dev/null")./*|*/
      I("FileCheck -match-full-lines -check-prefix I386-NETBSD-SSE %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -E -dM -ffreestanding -triple=i386-netbsd6 < /dev/null | ${LLVM_SRC}/build/bin/FileCheck -match-full-lines -check-prefix I386-NETBSD6 ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/init.c
    RUN("%clang_cc1 -E -dM -ffreestanding -triple=i386-netbsd6  < /dev/null")./*|*/
      I("FileCheck -match-full-lines -check-prefix I386-NETBSD6 %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -E -dM -ffreestanding -triple=i386-netbsd6 -target-feature +sse2 < /dev/null | ${LLVM_SRC}/build/bin/FileCheck -match-full-lines -check-prefix I386-NETBSD6-SSE ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/init.c
    RUN("%clang_cc1 -E -dM -ffreestanding -triple=i386-netbsd6 -target-feature +sse2 < /dev/null")./*|*/
      I("FileCheck -match-full-lines -check-prefix I386-NETBSD6-SSE %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -E -dM -triple=i686-pc-mingw32 < /dev/null | ${LLVM_SRC}/build/bin/FileCheck -match-full-lines -check-prefix I386-DECLSPEC ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/init.c
    RUN("%clang_cc1 -E -dM -triple=i686-pc-mingw32 < /dev/null")./*|*/
      I("FileCheck -match-full-lines -check-prefix I386-DECLSPEC %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -E -dM -fms-extensions -triple=i686-pc-mingw32 < /dev/null | ${LLVM_SRC}/build/bin/FileCheck -match-full-lines -check-prefix I386-DECLSPEC ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/init.c
    RUN("%clang_cc1 -E -dM -fms-extensions -triple=i686-pc-mingw32 < /dev/null")./*|*/
      I("FileCheck -match-full-lines -check-prefix I386-DECLSPEC %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -E -dM -triple=i686-unknown-cygwin < /dev/null | ${LLVM_SRC}/build/bin/FileCheck -match-full-lines -check-prefix I386-DECLSPEC ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/init.c
    RUN("%clang_cc1 -E -dM -triple=i686-unknown-cygwin < /dev/null")./*|*/
      I("FileCheck -match-full-lines -check-prefix I386-DECLSPEC %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -E -dM -fms-extensions -triple=i686-unknown-cygwin < /dev/null | ${LLVM_SRC}/build/bin/FileCheck -match-full-lines -check-prefix I386-DECLSPEC ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/init.c
    RUN("%clang_cc1 -E -dM -fms-extensions -triple=i686-unknown-cygwin < /dev/null")./*|*/
      I("FileCheck -match-full-lines -check-prefix I386-DECLSPEC %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -E -dM -ffreestanding -triple=mips-none-none < /dev/null | ${LLVM_SRC}/build/bin/FileCheck -match-full-lines -check-prefix MIPS32BE ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/init.c
    RUN("%clang_cc1 -E -dM -ffreestanding -triple=mips-none-none < /dev/null")./*|*/
      I("FileCheck -match-full-lines -check-prefix MIPS32BE %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -E -dM -ffreestanding -triple=mipsel-none-none < /dev/null | ${LLVM_SRC}/build/bin/FileCheck -match-full-lines -check-prefix MIPS32EL ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/init.c
    RUN("%clang_cc1 -E -dM -ffreestanding -triple=mipsel-none-none < /dev/null")./*|*/
      I("FileCheck -match-full-lines -check-prefix MIPS32EL %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -E -dM -ffreestanding -triple=mips64-none-none -target-abi n32 < /dev/null | ${LLVM_SRC}/build/bin/FileCheck -match-full-lines -check-prefix MIPSN32BE ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/init.c
    RUN("%clang_cc1 -E -dM -ffreestanding -triple=mips64-none-none -target-abi n32 < /dev/null")./*|*/
      I("FileCheck -match-full-lines -check-prefix MIPSN32BE %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -E -dM -ffreestanding -triple=mips64el-none-none -target-abi n32 < /dev/null | ${LLVM_SRC}/build/bin/FileCheck -match-full-lines -check-prefix MIPSN32EL ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/init.c
    RUN("%clang_cc1 -E -dM -ffreestanding -triple=mips64el-none-none -target-abi n32 < /dev/null")./*|*/
      I("FileCheck -match-full-lines -check-prefix MIPSN32EL %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -E -dM -ffreestanding -triple=mips64-none-none < /dev/null | ${LLVM_SRC}/build/bin/FileCheck -match-full-lines -check-prefix MIPS64BE ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/init.c
    RUN("%clang_cc1 -E -dM -ffreestanding -triple=mips64-none-none < /dev/null")./*|*/
      I("FileCheck -match-full-lines -check-prefix MIPS64BE %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -E -dM -ffreestanding -triple=mips64el-none-none < /dev/null | ${LLVM_SRC}/build/bin/FileCheck -match-full-lines -check-prefix MIPS64EL ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/init.c
    RUN("%clang_cc1 -E -dM -ffreestanding -triple=mips64el-none-none < /dev/null")./*|*/
      I("FileCheck -match-full-lines -check-prefix MIPS64EL %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -E -dM -ffreestanding -triple=mips-none-none < /dev/null | ${LLVM_SRC}/build/bin/FileCheck -match-full-lines -check-prefix MIPS-ARCH-DEF32 ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/init.c
    RUN("%clang_cc1 -E -dM -ffreestanding -triple=mips-none-none < /dev/null")./*|*/
      I("FileCheck -match-full-lines -check-prefix MIPS-ARCH-DEF32 %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -E -dM -ffreestanding -triple=mips-none-nones -target-cpu mips32 < /dev/null | ${LLVM_SRC}/build/bin/FileCheck -match-full-lines -check-prefix MIPS-ARCH-32 ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/init.c
    RUN("%clang_cc1 -E -dM -ffreestanding -triple=mips-none-nones -target-cpu mips32 < /dev/null")./*|*/
      I("FileCheck -match-full-lines -check-prefix MIPS-ARCH-32 %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -E -dM -ffreestanding -triple=mips-none-none -target-cpu mips32r2 < /dev/null | ${LLVM_SRC}/build/bin/FileCheck -match-full-lines -check-prefix MIPS-ARCH-32R2 ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/init.c
    RUN("%clang_cc1 -E -dM -ffreestanding -triple=mips-none-none -target-cpu mips32r2 < /dev/null")./*|*/
      I("FileCheck -match-full-lines -check-prefix MIPS-ARCH-32R2 %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -E -dM -ffreestanding -triple=mips-none-none -target-cpu mips32r3 < /dev/null | ${LLVM_SRC}/build/bin/FileCheck -match-full-lines -check-prefix MIPS-ARCH-32R3 ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/init.c
    RUN("%clang_cc1 -E -dM -ffreestanding -triple=mips-none-none -target-cpu mips32r3 < /dev/null")./*|*/
      I("FileCheck -match-full-lines -check-prefix MIPS-ARCH-32R3 %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -E -dM -ffreestanding -triple=mips-none-none -target-cpu mips32r5 < /dev/null | ${LLVM_SRC}/build/bin/FileCheck -match-full-lines -check-prefix MIPS-ARCH-32R5 ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/init.c
    RUN("%clang_cc1 -E -dM -ffreestanding -triple=mips-none-none -target-cpu mips32r5 < /dev/null")./*|*/
      I("FileCheck -match-full-lines -check-prefix MIPS-ARCH-32R5 %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -E -dM -ffreestanding -triple=mips-none-none -target-cpu mips32r6 < /dev/null | ${LLVM_SRC}/build/bin/FileCheck -match-full-lines -check-prefix MIPS-ARCH-32R6 ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/init.c
    RUN("%clang_cc1 -E -dM -ffreestanding -triple=mips-none-none -target-cpu mips32r6 < /dev/null")./*|*/
      I("FileCheck -match-full-lines -check-prefix MIPS-ARCH-32R6 %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -E -dM -ffreestanding -triple=mips64-none-none < /dev/null | ${LLVM_SRC}/build/bin/FileCheck -match-full-lines -check-prefix MIPS-ARCH-DEF64 ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/init.c
    RUN("%clang_cc1 -E -dM -ffreestanding -triple=mips64-none-none < /dev/null")./*|*/
      I("FileCheck -match-full-lines -check-prefix MIPS-ARCH-DEF64 %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -E -dM -ffreestanding -triple=mips64-none-none -target-cpu mips64 < /dev/null | ${LLVM_SRC}/build/bin/FileCheck -match-full-lines -check-prefix MIPS-ARCH-64 ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/init.c
    RUN("%clang_cc1 -E -dM -ffreestanding -triple=mips64-none-none -target-cpu mips64 < /dev/null")./*|*/
      I("FileCheck -match-full-lines -check-prefix MIPS-ARCH-64 %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -E -dM -ffreestanding -triple=mips64-none-none -target-cpu mips64r2 < /dev/null | ${LLVM_SRC}/build/bin/FileCheck -match-full-lines -check-prefix MIPS-ARCH-64R2 ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/init.c
    RUN("%clang_cc1 -E -dM -ffreestanding -triple=mips64-none-none -target-cpu mips64r2 < /dev/null")./*|*/
      I("FileCheck -match-full-lines -check-prefix MIPS-ARCH-64R2 %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -E -dM -ffreestanding -triple=mips64-none-none -target-cpu mips64r3 < /dev/null | ${LLVM_SRC}/build/bin/FileCheck -match-full-lines -check-prefix MIPS-ARCH-64R3 ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/init.c
    RUN("%clang_cc1 -E -dM -ffreestanding -triple=mips64-none-none -target-cpu mips64r3 < /dev/null")./*|*/
      I("FileCheck -match-full-lines -check-prefix MIPS-ARCH-64R3 %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -E -dM -ffreestanding -triple=mips64-none-none -target-cpu mips64r5 < /dev/null | ${LLVM_SRC}/build/bin/FileCheck -match-full-lines -check-prefix MIPS-ARCH-64R5 ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/init.c
    RUN("%clang_cc1 -E -dM -ffreestanding -triple=mips64-none-none -target-cpu mips64r5 < /dev/null")./*|*/
      I("FileCheck -match-full-lines -check-prefix MIPS-ARCH-64R5 %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -E -dM -ffreestanding -triple=mips64-none-none -target-cpu mips64r6 < /dev/null | ${LLVM_SRC}/build/bin/FileCheck -match-full-lines -check-prefix MIPS-ARCH-64R6 ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/init.c
    RUN("%clang_cc1 -E -dM -ffreestanding -triple=mips64-none-none -target-cpu mips64r6 < /dev/null")./*|*/
      I("FileCheck -match-full-lines -check-prefix MIPS-ARCH-64R6 %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -E -dM -ffreestanding -triple=mips-none-none < /dev/null | ${LLVM_SRC}/build/bin/FileCheck -match-full-lines -check-prefix MIPS-FABI-HARD ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/init.c
    RUN("%clang_cc1 -E -dM -ffreestanding -triple=mips-none-none < /dev/null")./*|*/
      I("FileCheck -match-full-lines -check-prefix MIPS-FABI-HARD %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -target-feature +soft-float -E -dM -ffreestanding -triple=mips-none-none < /dev/null | ${LLVM_SRC}/build/bin/FileCheck -match-full-lines -check-prefix MIPS-FABI-SOFT ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/init.c
    RUN("%clang_cc1 -target-feature +soft-float -E -dM -ffreestanding -triple=mips-none-none < /dev/null")./*|*/
      I("FileCheck -match-full-lines -check-prefix MIPS-FABI-SOFT %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -target-feature +single-float -E -dM -ffreestanding -triple=mips-none-none < /dev/null | ${LLVM_SRC}/build/bin/FileCheck -match-full-lines -check-prefix MIPS-FABI-SINGLE ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/init.c
    RUN("%clang_cc1 -target-feature +single-float -E -dM -ffreestanding -triple=mips-none-none < /dev/null")./*|*/
      I("FileCheck -match-full-lines -check-prefix MIPS-FABI-SINGLE %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -target-feature +soft-float -target-feature +single-float -E -dM -ffreestanding -triple=mips-none-none < /dev/null | ${LLVM_SRC}/build/bin/FileCheck -match-full-lines -check-prefix MIPS-FABI-SINGLE-SOFT ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/init.c
    RUN("%clang_cc1 -target-feature +soft-float -target-feature +single-float -E -dM -ffreestanding -triple=mips-none-none < /dev/null")./*|*/
      I("FileCheck -match-full-lines -check-prefix MIPS-FABI-SINGLE-SOFT %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -target-feature +mips16 -E -dM -triple=mips-none-none < /dev/null | ${LLVM_SRC}/build/bin/FileCheck -match-full-lines -check-prefix MIPS16 ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/init.c
    RUN("%clang_cc1 -target-feature +mips16 -E -dM -triple=mips-none-none < /dev/null")./*|*/
      I("FileCheck -match-full-lines -check-prefix MIPS16 %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -target-feature -mips16 -E -dM -triple=mips-none-none < /dev/null | ${LLVM_SRC}/build/bin/FileCheck -match-full-lines -check-prefix NOMIPS16 ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/init.c
    RUN("%clang_cc1 -target-feature -mips16 -E -dM -triple=mips-none-none < /dev/null")./*|*/
      I("FileCheck -match-full-lines -check-prefix NOMIPS16 %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -target-feature +micromips -E -dM -triple=mips-none-none < /dev/null | ${LLVM_SRC}/build/bin/FileCheck -match-full-lines -check-prefix MICROMIPS ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/init.c
    RUN("%clang_cc1 -target-feature +micromips -E -dM -triple=mips-none-none < /dev/null")./*|*/
      I("FileCheck -match-full-lines -check-prefix MICROMIPS %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -target-feature -micromips -E -dM -triple=mips-none-none < /dev/null | ${LLVM_SRC}/build/bin/FileCheck -match-full-lines -check-prefix NOMICROMIPS ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/init.c
    RUN("%clang_cc1 -target-feature -micromips -E -dM -triple=mips-none-none < /dev/null")./*|*/
      I("FileCheck -match-full-lines -check-prefix NOMICROMIPS %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -target-feature +dsp -E -dM -triple=mips-none-none < /dev/null | ${LLVM_SRC}/build/bin/FileCheck -match-full-lines -check-prefix MIPS-DSP ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/init.c
    RUN("%clang_cc1 -target-feature +dsp -E -dM -triple=mips-none-none < /dev/null")./*|*/
      I("FileCheck -match-full-lines -check-prefix MIPS-DSP %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -target-feature +dspr2 -E -dM -triple=mips-none-none < /dev/null | ${LLVM_SRC}/build/bin/FileCheck -match-full-lines -check-prefix MIPS-DSPR2 ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/init.c
    RUN("%clang_cc1 -target-feature +dspr2 -E -dM -triple=mips-none-none < /dev/null")./*|*/
      I("FileCheck -match-full-lines -check-prefix MIPS-DSPR2 %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -target-feature +msa -E -dM -triple=mips-none-none < /dev/null | ${LLVM_SRC}/build/bin/FileCheck -match-full-lines -check-prefix MIPS-MSA ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/init.c
    RUN("%clang_cc1 -target-feature +msa -E -dM -triple=mips-none-none < /dev/null")./*|*/
      I("FileCheck -match-full-lines -check-prefix MIPS-MSA %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -target-cpu mips32r3 -target-feature +nan2008 -E -dM -triple=mips-none-none < /dev/null | ${LLVM_SRC}/build/bin/FileCheck -match-full-lines -check-prefix MIPS-NAN2008 ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/init.c
    RUN("%clang_cc1 -target-cpu mips32r3 -target-feature +nan2008 -E -dM -triple=mips-none-none < /dev/null")./*|*/
      I("FileCheck -match-full-lines -check-prefix MIPS-NAN2008 %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -target-cpu mips32r3 -target-feature -nan2008 -E -dM -triple=mips-none-none < /dev/null | ${LLVM_SRC}/build/bin/FileCheck -match-full-lines -check-prefix NOMIPS-NAN2008 ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/init.c
    RUN("%clang_cc1 -target-cpu mips32r3 -target-feature -nan2008 -E -dM -triple=mips-none-none < /dev/null")./*|*/
      I("FileCheck -match-full-lines -check-prefix NOMIPS-NAN2008 %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -target-feature -fp64 -E -dM -triple=mips-none-none < /dev/null | ${LLVM_SRC}/build/bin/FileCheck -match-full-lines -check-prefix MIPS32-MFP32 ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/init.c
    RUN("%clang_cc1 -target-feature -fp64 -E -dM -triple=mips-none-none < /dev/null")./*|*/
      I("FileCheck -match-full-lines -check-prefix MIPS32-MFP32 %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -target-feature +fp64 -E -dM -triple=mips-none-none < /dev/null | ${LLVM_SRC}/build/bin/FileCheck -match-full-lines -check-prefix MIPS32-MFP64 ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/init.c
    RUN("%clang_cc1 -target-feature +fp64 -E -dM -triple=mips-none-none < /dev/null")./*|*/
      I("FileCheck -match-full-lines -check-prefix MIPS32-MFP64 %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -target-feature +single-float -E -dM -triple=mips-none-none < /dev/null | ${LLVM_SRC}/build/bin/FileCheck -match-full-lines -check-prefix MIPS32-MFP32SF ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/init.c
    RUN("%clang_cc1 -target-feature +single-float -E -dM -triple=mips-none-none < /dev/null")./*|*/
      I("FileCheck -match-full-lines -check-prefix MIPS32-MFP32SF %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -target-feature +fp64 -E -dM -triple=mips64-none-none < /dev/null | ${LLVM_SRC}/build/bin/FileCheck -match-full-lines -check-prefix MIPS64-MFP64 ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/init.c
    RUN("%clang_cc1 -target-feature +fp64 -E -dM -triple=mips64-none-none < /dev/null")./*|*/
      I("FileCheck -match-full-lines -check-prefix MIPS64-MFP64 %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -target-feature -fp64 -target-feature +single-float -E -dM -triple=mips64-none-none < /dev/null | ${LLVM_SRC}/build/bin/FileCheck -match-full-lines -check-prefix MIPS64-NOMFP64 ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/init.c
    RUN("%clang_cc1 -target-feature -fp64 -target-feature +single-float -E -dM -triple=mips64-none-none < /dev/null")./*|*/
      I("FileCheck -match-full-lines -check-prefix MIPS64-NOMFP64 %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -target-cpu mips32r6 -E -dM -triple=mips-none-none < /dev/null | ${LLVM_SRC}/build/bin/FileCheck -match-full-lines -check-prefix MIPS-XXR6 ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/init.c
    RUN("%clang_cc1 -target-cpu mips32r6 -E -dM -triple=mips-none-none < /dev/null")./*|*/
      I("FileCheck -match-full-lines -check-prefix MIPS-XXR6 %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -target-cpu mips64r6 -E -dM -triple=mips64-none-none < /dev/null | ${LLVM_SRC}/build/bin/FileCheck -match-full-lines -check-prefix MIPS-XXR6 ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/init.c
    RUN("%clang_cc1 -target-cpu mips64r6 -E -dM -triple=mips64-none-none < /dev/null")./*|*/
      I("FileCheck -match-full-lines -check-prefix MIPS-XXR6 %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -E -dM -ffreestanding -triple=msp430-none-none < /dev/null | ${LLVM_SRC}/build/bin/FileCheck -match-full-lines -check-prefix MSP430 ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/init.c
    RUN("%clang_cc1 -E -dM -ffreestanding -triple=msp430-none-none < /dev/null")./*|*/
      I("FileCheck -match-full-lines -check-prefix MSP430 %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -E -dM -ffreestanding -triple=nvptx-none-none < /dev/null | ${LLVM_SRC}/build/bin/FileCheck -match-full-lines -check-prefix NVPTX32 ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/init.c
    RUN("%clang_cc1 -E -dM -ffreestanding -triple=nvptx-none-none < /dev/null")./*|*/
      I("FileCheck -match-full-lines -check-prefix NVPTX32 %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -E -dM -ffreestanding -triple=nvptx64-none-none < /dev/null | ${LLVM_SRC}/build/bin/FileCheck -match-full-lines -check-prefix NVPTX64 ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/init.c
    RUN("%clang_cc1 -E -dM -ffreestanding -triple=nvptx64-none-none < /dev/null")./*|*/
      I("FileCheck -match-full-lines -check-prefix NVPTX64 %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -E -dM -ffreestanding -triple=powerpc-none-none -target-cpu 603e < /dev/null | ${LLVM_SRC}/build/bin/FileCheck -match-full-lines -check-prefix PPC603E ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/init.c
    RUN("%clang_cc1 -E -dM -ffreestanding -triple=powerpc-none-none -target-cpu 603e < /dev/null")./*|*/
      I("FileCheck -match-full-lines -check-prefix PPC603E %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -E -dM -ffreestanding -triple=powerpc64-none-none -target-cpu pwr7 -fno-signed-char < /dev/null | ${LLVM_SRC}/build/bin/FileCheck -match-full-lines -check-prefix PPC64 ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/init.c
    RUN("%clang_cc1 -E -dM -ffreestanding -triple=powerpc64-none-none -target-cpu pwr7 -fno-signed-char < /dev/null")./*|*/
      I("FileCheck -match-full-lines -check-prefix PPC64 %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -E -dM -ffreestanding -triple=powerpc64le-none-none -target-cpu pwr7 -fno-signed-char < /dev/null | ${LLVM_SRC}/build/bin/FileCheck -match-full-lines -check-prefix PPC64LE ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/init.c
    RUN("%clang_cc1 -E -dM -ffreestanding -triple=powerpc64le-none-none -target-cpu pwr7 -fno-signed-char < /dev/null")./*|*/
      I("FileCheck -match-full-lines -check-prefix PPC64LE %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -E -dM -ffreestanding -triple=powerpc64-none-none -target-cpu a2q -fno-signed-char < /dev/null | ${LLVM_SRC}/build/bin/FileCheck -match-full-lines -check-prefix PPCA2Q ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/init.c
    RUN("%clang_cc1 -E -dM -ffreestanding -triple=powerpc64-none-none -target-cpu a2q -fno-signed-char < /dev/null")./*|*/
      I("FileCheck -match-full-lines -check-prefix PPCA2Q %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -E -dM -ffreestanding -triple=powerpc64-bgq-linux -fno-signed-char < /dev/null | ${LLVM_SRC}/build/bin/FileCheck -match-full-lines -check-prefix PPCBGQ ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/init.c
    RUN("%clang_cc1 -E -dM -ffreestanding -triple=powerpc64-bgq-linux -fno-signed-char < /dev/null")./*|*/
      I("FileCheck -match-full-lines -check-prefix PPCBGQ %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -E -dM -ffreestanding -triple=powerpc64-none-none -target-cpu 630 -fno-signed-char < /dev/null | ${LLVM_SRC}/build/bin/FileCheck -match-full-lines -check-prefix PPC630 ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/init.c
    RUN("%clang_cc1 -E -dM -ffreestanding -triple=powerpc64-none-none -target-cpu 630 -fno-signed-char < /dev/null")./*|*/
      I("FileCheck -match-full-lines -check-prefix PPC630 %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -E -dM -ffreestanding -triple=powerpc64-none-none -target-cpu pwr3 -fno-signed-char < /dev/null | ${LLVM_SRC}/build/bin/FileCheck -match-full-lines -check-prefix PPCPWR3 ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/init.c
    RUN("%clang_cc1 -E -dM -ffreestanding -triple=powerpc64-none-none -target-cpu pwr3 -fno-signed-char < /dev/null")./*|*/
      I("FileCheck -match-full-lines -check-prefix PPCPWR3 %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -E -dM -ffreestanding -triple=powerpc64-none-none -target-cpu power3 -fno-signed-char < /dev/null | ${LLVM_SRC}/build/bin/FileCheck -match-full-lines -check-prefix PPCPOWER3 ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/init.c
    RUN("%clang_cc1 -E -dM -ffreestanding -triple=powerpc64-none-none -target-cpu power3 -fno-signed-char < /dev/null")./*|*/
      I("FileCheck -match-full-lines -check-prefix PPCPOWER3 %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -E -dM -ffreestanding -triple=powerpc64-none-none -target-cpu pwr4 -fno-signed-char < /dev/null | ${LLVM_SRC}/build/bin/FileCheck -match-full-lines -check-prefix PPCPWR4 ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/init.c
    RUN("%clang_cc1 -E -dM -ffreestanding -triple=powerpc64-none-none -target-cpu pwr4 -fno-signed-char < /dev/null")./*|*/
      I("FileCheck -match-full-lines -check-prefix PPCPWR4 %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -E -dM -ffreestanding -triple=powerpc64-none-none -target-cpu power4 -fno-signed-char < /dev/null | ${LLVM_SRC}/build/bin/FileCheck -match-full-lines -check-prefix PPCPOWER4 ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/init.c
    RUN("%clang_cc1 -E -dM -ffreestanding -triple=powerpc64-none-none -target-cpu power4 -fno-signed-char < /dev/null")./*|*/
      I("FileCheck -match-full-lines -check-prefix PPCPOWER4 %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -E -dM -ffreestanding -triple=powerpc64-none-none -target-cpu pwr5 -fno-signed-char < /dev/null | ${LLVM_SRC}/build/bin/FileCheck -match-full-lines -check-prefix PPCPWR5 ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/init.c
    RUN("%clang_cc1 -E -dM -ffreestanding -triple=powerpc64-none-none -target-cpu pwr5 -fno-signed-char < /dev/null")./*|*/
      I("FileCheck -match-full-lines -check-prefix PPCPWR5 %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -E -dM -ffreestanding -triple=powerpc64-none-none -target-cpu power5 -fno-signed-char < /dev/null | ${LLVM_SRC}/build/bin/FileCheck -match-full-lines -check-prefix PPCPOWER5 ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/init.c
    RUN("%clang_cc1 -E -dM -ffreestanding -triple=powerpc64-none-none -target-cpu power5 -fno-signed-char < /dev/null")./*|*/
      I("FileCheck -match-full-lines -check-prefix PPCPOWER5 %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -E -dM -ffreestanding -triple=powerpc64-none-none -target-cpu pwr5x -fno-signed-char < /dev/null | ${LLVM_SRC}/build/bin/FileCheck -match-full-lines -check-prefix PPCPWR5X ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/init.c
    RUN("%clang_cc1 -E -dM -ffreestanding -triple=powerpc64-none-none -target-cpu pwr5x -fno-signed-char < /dev/null")./*|*/
      I("FileCheck -match-full-lines -check-prefix PPCPWR5X %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -E -dM -ffreestanding -triple=powerpc64-none-none -target-cpu power5x -fno-signed-char < /dev/null | ${LLVM_SRC}/build/bin/FileCheck -match-full-lines -check-prefix PPCPOWER5X ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/init.c
    RUN("%clang_cc1 -E -dM -ffreestanding -triple=powerpc64-none-none -target-cpu power5x -fno-signed-char < /dev/null")./*|*/
      I("FileCheck -match-full-lines -check-prefix PPCPOWER5X %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -E -dM -ffreestanding -triple=powerpc64-none-none -target-cpu pwr6 -fno-signed-char < /dev/null | ${LLVM_SRC}/build/bin/FileCheck -match-full-lines -check-prefix PPCPWR6 ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/init.c
    RUN("%clang_cc1 -E -dM -ffreestanding -triple=powerpc64-none-none -target-cpu pwr6 -fno-signed-char < /dev/null")./*|*/
      I("FileCheck -match-full-lines -check-prefix PPCPWR6 %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -E -dM -ffreestanding -triple=powerpc64-none-none -target-cpu power6 -fno-signed-char < /dev/null | ${LLVM_SRC}/build/bin/FileCheck -match-full-lines -check-prefix PPCPOWER6 ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/init.c
    RUN("%clang_cc1 -E -dM -ffreestanding -triple=powerpc64-none-none -target-cpu power6 -fno-signed-char < /dev/null")./*|*/
      I("FileCheck -match-full-lines -check-prefix PPCPOWER6 %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -E -dM -ffreestanding -triple=powerpc64-none-none -target-cpu pwr6x -fno-signed-char < /dev/null | ${LLVM_SRC}/build/bin/FileCheck -match-full-lines -check-prefix PPCPWR6X ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/init.c
    RUN("%clang_cc1 -E -dM -ffreestanding -triple=powerpc64-none-none -target-cpu pwr6x -fno-signed-char < /dev/null")./*|*/
      I("FileCheck -match-full-lines -check-prefix PPCPWR6X %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -E -dM -ffreestanding -triple=powerpc64-none-none -target-cpu power6x -fno-signed-char < /dev/null | ${LLVM_SRC}/build/bin/FileCheck -match-full-lines -check-prefix PPCPOWER6X ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/init.c
    RUN("%clang_cc1 -E -dM -ffreestanding -triple=powerpc64-none-none -target-cpu power6x -fno-signed-char < /dev/null")./*|*/
      I("FileCheck -match-full-lines -check-prefix PPCPOWER6X %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -E -dM -ffreestanding -triple=powerpc64-none-none -target-cpu pwr7 -fno-signed-char < /dev/null | ${LLVM_SRC}/build/bin/FileCheck -match-full-lines -check-prefix PPCPWR7 ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/init.c
    RUN("%clang_cc1 -E -dM -ffreestanding -triple=powerpc64-none-none -target-cpu pwr7 -fno-signed-char < /dev/null")./*|*/
      I("FileCheck -match-full-lines -check-prefix PPCPWR7 %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -E -dM -ffreestanding -triple=powerpc64-none-none -target-cpu power7 -fno-signed-char < /dev/null | ${LLVM_SRC}/build/bin/FileCheck -match-full-lines -check-prefix PPCPOWER7 ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/init.c
    RUN("%clang_cc1 -E -dM -ffreestanding -triple=powerpc64-none-none -target-cpu power7 -fno-signed-char < /dev/null")./*|*/
      I("FileCheck -match-full-lines -check-prefix PPCPOWER7 %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -E -dM -ffreestanding -triple=powerpc64-none-none -target-cpu pwr8 -fno-signed-char < /dev/null | ${LLVM_SRC}/build/bin/FileCheck -match-full-lines -check-prefix PPCPWR8 ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/init.c
    RUN("%clang_cc1 -E -dM -ffreestanding -triple=powerpc64-none-none -target-cpu pwr8 -fno-signed-char < /dev/null")./*|*/
      I("FileCheck -match-full-lines -check-prefix PPCPWR8 %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -E -dM -ffreestanding -triple=powerpc64-none-none -target-cpu power8 -fno-signed-char < /dev/null | ${LLVM_SRC}/build/bin/FileCheck -match-full-lines -check-prefix PPCPOWER8 ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/init.c
    RUN("%clang_cc1 -E -dM -ffreestanding -triple=powerpc64-none-none -target-cpu power8 -fno-signed-char < /dev/null")./*|*/
      I("FileCheck -match-full-lines -check-prefix PPCPOWER8 %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -E -dM -ffreestanding -triple=powerpc64-none-none -target-cpu pwr9 -fno-signed-char < /dev/null | ${LLVM_SRC}/build/bin/FileCheck -match-full-lines -check-prefix PPCPWR9 ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/init.c
    RUN("%clang_cc1 -E -dM -ffreestanding -triple=powerpc64-none-none -target-cpu pwr9 -fno-signed-char < /dev/null")./*|*/
      I("FileCheck -match-full-lines -check-prefix PPCPWR9 %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -E -dM -ffreestanding -triple=powerpc64-none-none -target-cpu power9 -fno-signed-char < /dev/null | ${LLVM_SRC}/build/bin/FileCheck -match-full-lines -check-prefix PPCPOWER9 ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/init.c
    RUN("%clang_cc1 -E -dM -ffreestanding -triple=powerpc64-none-none -target-cpu power9 -fno-signed-char < /dev/null")./*|*/
      I("FileCheck -match-full-lines -check-prefix PPCPOWER9 %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -E -dM -ffreestanding -triple=powerpc64-none-none -target-feature +float128 -target-cpu power8 -fno-signed-char < /dev/null | ${LLVM_SRC}/build/bin/FileCheck -check-prefix PPC-FLOAT128 ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/init.c
    RUN("%clang_cc1 -E -dM -ffreestanding -triple=powerpc64-none-none -target-feature +float128 -target-cpu power8 -fno-signed-char < /dev/null")./*|*/
      I("FileCheck -check-prefix PPC-FLOAT128 %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -E -dM -ffreestanding -triple=powerpc64-unknown-linux-gnu -fno-signed-char < /dev/null | ${LLVM_SRC}/build/bin/FileCheck -match-full-lines -check-prefix PPC64-LINUX ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/init.c
    RUN("%clang_cc1 -E -dM -ffreestanding -triple=powerpc64-unknown-linux-gnu -fno-signed-char < /dev/null")./*|*/
      I("FileCheck -match-full-lines -check-prefix PPC64-LINUX %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -E -dM -ffreestanding -triple=powerpc64-unknown-linux-gnu < /dev/null | ${LLVM_SRC}/build/bin/FileCheck -match-full-lines -check-prefix PPC64-ELFv1 ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/init.c
    RUN("%clang_cc1 -E -dM -ffreestanding -triple=powerpc64-unknown-linux-gnu < /dev/null")./*|*/
      I("FileCheck -match-full-lines -check-prefix PPC64-ELFv1 %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -E -dM -ffreestanding -triple=powerpc64-unknown-linux-gnu -target-abi elfv1 < /dev/null | ${LLVM_SRC}/build/bin/FileCheck -match-full-lines -check-prefix PPC64-ELFv1 ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/init.c
    RUN("%clang_cc1 -E -dM -ffreestanding -triple=powerpc64-unknown-linux-gnu -target-abi elfv1 < /dev/null")./*|*/
      I("FileCheck -match-full-lines -check-prefix PPC64-ELFv1 %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -E -dM -ffreestanding -triple=powerpc64-unknown-linux-gnu -target-abi elfv1-qpx < /dev/null | ${LLVM_SRC}/build/bin/FileCheck -match-full-lines -check-prefix PPC64-ELFv1 ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/init.c
    RUN("%clang_cc1 -E -dM -ffreestanding -triple=powerpc64-unknown-linux-gnu -target-abi elfv1-qpx < /dev/null")./*|*/
      I("FileCheck -match-full-lines -check-prefix PPC64-ELFv1 %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -E -dM -ffreestanding -triple=powerpc64-unknown-linux-gnu -target-abi elfv2 < /dev/null | ${LLVM_SRC}/build/bin/FileCheck -match-full-lines -check-prefix PPC64-ELFv2 ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/init.c
    RUN("%clang_cc1 -E -dM -ffreestanding -triple=powerpc64-unknown-linux-gnu -target-abi elfv2 < /dev/null")./*|*/
      I("FileCheck -match-full-lines -check-prefix PPC64-ELFv2 %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -E -dM -ffreestanding -triple=powerpc64le-unknown-linux-gnu < /dev/null | ${LLVM_SRC}/build/bin/FileCheck -match-full-lines -check-prefix PPC64-ELFv2 ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/init.c
    RUN("%clang_cc1 -E -dM -ffreestanding -triple=powerpc64le-unknown-linux-gnu < /dev/null")./*|*/
      I("FileCheck -match-full-lines -check-prefix PPC64-ELFv2 %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -E -dM -ffreestanding -triple=powerpc64le-unknown-linux-gnu -target-abi elfv1 < /dev/null | ${LLVM_SRC}/build/bin/FileCheck -match-full-lines -check-prefix PPC64-ELFv1 ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/init.c
    RUN("%clang_cc1 -E -dM -ffreestanding -triple=powerpc64le-unknown-linux-gnu -target-abi elfv1 < /dev/null")./*|*/
      I("FileCheck -match-full-lines -check-prefix PPC64-ELFv1 %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -E -dM -ffreestanding -triple=powerpc64le-unknown-linux-gnu -target-abi elfv2 < /dev/null | ${LLVM_SRC}/build/bin/FileCheck -match-full-lines -check-prefix PPC64-ELFv2 ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/init.c
    RUN("%clang_cc1 -E -dM -ffreestanding -triple=powerpc64le-unknown-linux-gnu -target-abi elfv2 < /dev/null")./*|*/
      I("FileCheck -match-full-lines -check-prefix PPC64-ELFv2 %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -E -dM -ffreestanding -triple=powerpc-none-none -fno-signed-char < /dev/null | ${LLVM_SRC}/build/bin/FileCheck -match-full-lines -check-prefix PPC ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/init.c
    RUN("%clang_cc1 -E -dM -ffreestanding -triple=powerpc-none-none -fno-signed-char < /dev/null")./*|*/
      I("FileCheck -match-full-lines -check-prefix PPC %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -E -dM -ffreestanding -triple=powerpc-unknown-linux-gnu -fno-signed-char < /dev/null | ${LLVM_SRC}/build/bin/FileCheck -match-full-lines -check-prefix PPC-LINUX ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/init.c
    RUN("%clang_cc1 -E -dM -ffreestanding -triple=powerpc-unknown-linux-gnu -fno-signed-char < /dev/null")./*|*/
      I("FileCheck -match-full-lines -check-prefix PPC-LINUX %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -E -dM -ffreestanding -triple=powerpc-apple-darwin8 < /dev/null | ${LLVM_SRC}/build/bin/FileCheck -match-full-lines -check-prefix PPC-DARWIN ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/init.c
    RUN("%clang_cc1 -E -dM -ffreestanding -triple=powerpc-apple-darwin8 < /dev/null")./*|*/
      I("FileCheck -match-full-lines -check-prefix PPC-DARWIN %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x cl -E -dM -ffreestanding -triple=amdgcn < /dev/null | ${LLVM_SRC}/build/bin/FileCheck -match-full-lines -check-prefix AMDGCN --check-prefix AMDGPU ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/init.c
    RUN("%clang_cc1 -x cl -E -dM -ffreestanding -triple=amdgcn < /dev/null")./*|*/
      I("FileCheck -match-full-lines -check-prefix AMDGCN --check-prefix AMDGPU %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x cl -E -dM -ffreestanding -triple=r600 -target-cpu caicos < /dev/null | ${LLVM_SRC}/build/bin/FileCheck -match-full-lines --check-prefix AMDGPU ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/init.c
    RUN("%clang_cc1 -x cl -E -dM -ffreestanding -triple=r600 -target-cpu caicos < /dev/null")./*|*/
      I("FileCheck -match-full-lines --check-prefix AMDGPU %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -E -dM -ffreestanding -triple=s390x-none-none -fno-signed-char < /dev/null | ${LLVM_SRC}/build/bin/FileCheck -match-full-lines -check-prefix S390X ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/init.c
    RUN("%clang_cc1 -E -dM -ffreestanding -triple=s390x-none-none -fno-signed-char < /dev/null")./*|*/
      I("FileCheck -match-full-lines -check-prefix S390X %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -E -dM -ffreestanding -triple=sparc-none-none < /dev/null | ${LLVM_SRC}/build/bin/FileCheck -match-full-lines -check-prefix SPARC -check-prefix SPARC-DEFAULT ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/init.c
    RUN("%clang_cc1 -E -dM -ffreestanding -triple=sparc-none-none < /dev/null")./*|*/
      I("FileCheck -match-full-lines -check-prefix SPARC -check-prefix SPARC-DEFAULT %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -E -dM -ffreestanding -triple=sparc-rtems-elf < /dev/null | ${LLVM_SRC}/build/bin/FileCheck -match-full-lines -check-prefix SPARC -check-prefix SPARC-DEFAULT ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/init.c
    RUN("%clang_cc1 -E -dM -ffreestanding -triple=sparc-rtems-elf < /dev/null")./*|*/
      I("FileCheck -match-full-lines -check-prefix SPARC -check-prefix SPARC-DEFAULT %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -E -dM -ffreestanding -triple=sparc-none-netbsd < /dev/null | ${LLVM_SRC}/build/bin/FileCheck -match-full-lines -check-prefix SPARC -check-prefix SPARC-NETOPENBSD ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/init.c
    RUN("%clang_cc1 -E -dM -ffreestanding -triple=sparc-none-netbsd < /dev/null")./*|*/
      I("FileCheck -match-full-lines -check-prefix SPARC -check-prefix SPARC-NETOPENBSD %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -E -dM -ffreestanding -triple=sparc-none-openbsd < /dev/null | ${LLVM_SRC}/build/bin/FileCheck -match-full-lines -check-prefix SPARC -check-prefix SPARC-NETOPENBSD ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/init.c
    RUN("%clang_cc1 -E -dM -ffreestanding -triple=sparc-none-openbsd < /dev/null")./*|*/
      I("FileCheck -match-full-lines -check-prefix SPARC -check-prefix SPARC-NETOPENBSD %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -E -dM -ffreestanding -triple=tce-none-none < /dev/null | ${LLVM_SRC}/build/bin/FileCheck -match-full-lines -check-prefix TCE ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/init.c
    RUN("%clang_cc1 -E -dM -ffreestanding -triple=tce-none-none < /dev/null")./*|*/
      I("FileCheck -match-full-lines -check-prefix TCE %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -E -dM -ffreestanding -triple=x86_64-none-none < /dev/null | ${LLVM_SRC}/build/bin/FileCheck -match-full-lines -check-prefix X86_64 ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/init.c
    RUN("%clang_cc1 -E -dM -ffreestanding -triple=x86_64-none-none < /dev/null")./*|*/
      I("FileCheck -match-full-lines -check-prefix X86_64 %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -E -dM -ffreestanding -triple=x86_64h-none-none < /dev/null | ${LLVM_SRC}/build/bin/FileCheck -match-full-lines -check-prefix X86_64H ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/init.c
    RUN("%clang_cc1 -E -dM -ffreestanding -triple=x86_64h-none-none < /dev/null")./*|*/
      I("FileCheck -match-full-lines -check-prefix X86_64H %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -E -dM -ffreestanding -triple=x86_64-none-none-gnux32 < /dev/null | ${LLVM_SRC}/build/bin/FileCheck -match-full-lines -check-prefix X32 ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/init.c
    RUN("%clang_cc1 -E -dM -ffreestanding -triple=x86_64-none-none-gnux32 < /dev/null")./*|*/
      I("FileCheck -match-full-lines -check-prefix X32 %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -E -dM -ffreestanding -triple=x86_64-unknown-cloudabi < /dev/null | ${LLVM_SRC}/build/bin/FileCheck -match-full-lines -check-prefix X86_64-CLOUDABI ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/init.c
    RUN("%clang_cc1 -E -dM -ffreestanding -triple=x86_64-unknown-cloudabi < /dev/null")./*|*/
      I("FileCheck -match-full-lines -check-prefix X86_64-CLOUDABI %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -E -dM -ffreestanding -triple=x86_64-pc-linux-gnu < /dev/null | ${LLVM_SRC}/build/bin/FileCheck -match-full-lines -check-prefix X86_64-LINUX ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/init.c
    RUN("%clang_cc1 -E -dM -ffreestanding -triple=x86_64-pc-linux-gnu < /dev/null")./*|*/
      I("FileCheck -match-full-lines -check-prefix X86_64-LINUX %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -E -dM -ffreestanding -triple=x86_64-unknown-freebsd9.1 < /dev/null | ${LLVM_SRC}/build/bin/FileCheck -match-full-lines -check-prefix X86_64-FREEBSD ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/init.c
    RUN("%clang_cc1 -E -dM -ffreestanding -triple=x86_64-unknown-freebsd9.1 < /dev/null")./*|*/
      I("FileCheck -match-full-lines -check-prefix X86_64-FREEBSD %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -E -dM -ffreestanding -triple=x86_64-netbsd < /dev/null | ${LLVM_SRC}/build/bin/FileCheck -match-full-lines -check-prefix X86_64-NETBSD ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/init.c
    RUN("%clang_cc1 -E -dM -ffreestanding -triple=x86_64-netbsd < /dev/null")./*|*/
      I("FileCheck -match-full-lines -check-prefix X86_64-NETBSD %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -E -dM -ffreestanding -triple=x86_64-scei-ps4 < /dev/null | ${LLVM_SRC}/build/bin/FileCheck -match-full-lines -check-prefix PS4 ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/init.c
    RUN("%clang_cc1 -E -dM -ffreestanding -triple=x86_64-scei-ps4 < /dev/null")./*|*/
      I("FileCheck -match-full-lines -check-prefix PS4 %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -E -dM -triple=x86_64-pc-mingw32 < /dev/null | ${LLVM_SRC}/build/bin/FileCheck -match-full-lines -check-prefix X86-64-DECLSPEC ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/init.c
    RUN("%clang_cc1 -E -dM -triple=x86_64-pc-mingw32 < /dev/null")./*|*/
      I("FileCheck -match-full-lines -check-prefix X86-64-DECLSPEC %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -E -dM -fms-extensions -triple=x86_64-unknown-mingw32 < /dev/null | ${LLVM_SRC}/build/bin/FileCheck -match-full-lines -check-prefix X86-64-DECLSPEC ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/init.c
    RUN("%clang_cc1 -E -dM -fms-extensions -triple=x86_64-unknown-mingw32 < /dev/null")./*|*/
      I("FileCheck -match-full-lines -check-prefix X86-64-DECLSPEC %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -E -dM -ffreestanding -triple=sparc64-none-none < /dev/null | ${LLVM_SRC}/build/bin/FileCheck -match-full-lines -check-prefix SPARCV9 ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/init.c
    RUN("%clang_cc1 -E -dM -ffreestanding -triple=sparc64-none-none < /dev/null")./*|*/
      I("FileCheck -match-full-lines -check-prefix SPARCV9 %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -E -dM -ffreestanding -triple=sparc64-none-openbsd < /dev/null | ${LLVM_SRC}/build/bin/FileCheck -match-full-lines -check-prefix SPARC64-OBSD ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/init.c
    RUN("%clang_cc1 -E -dM -ffreestanding -triple=sparc64-none-openbsd < /dev/null")./*|*/
      I("FileCheck -match-full-lines -check-prefix SPARC64-OBSD %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -E -dM -ffreestanding -triple=x86_64-pc-kfreebsd-gnu < /dev/null | ${LLVM_SRC}/build/bin/FileCheck -match-full-lines -check-prefix KFREEBSD-DEFINE ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/init.c
    RUN("%clang_cc1 -E -dM -ffreestanding -triple=x86_64-pc-kfreebsd-gnu < /dev/null")./*|*/
      I("FileCheck -match-full-lines -check-prefix KFREEBSD-DEFINE %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -E -dM -ffreestanding -triple=i686-pc-kfreebsd-gnu < /dev/null | ${LLVM_SRC}/build/bin/FileCheck -match-full-lines -check-prefix KFREEBSDI686-DEFINE ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/init.c
    RUN("%clang_cc1 -E -dM -ffreestanding -triple=i686-pc-kfreebsd-gnu < /dev/null")./*|*/
      I("FileCheck -match-full-lines -check-prefix KFREEBSDI686-DEFINE %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x c++ -triple i686-pc-linux-gnu -fobjc-runtime=gcc -E -dM < /dev/null | ${LLVM_SRC}/build/bin/FileCheck -match-full-lines -check-prefix GNUSOURCE ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/init.c
    RUN("%clang_cc1 -x c++ -triple i686-pc-linux-gnu -fobjc-runtime=gcc -E -dM < /dev/null")./*|*/
      I("FileCheck -match-full-lines -check-prefix GNUSOURCE %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x c++ -std=c++98 -fno-rtti -E -dM < /dev/null | ${LLVM_SRC}/build/bin/FileCheck -match-full-lines -check-prefix NORTTI ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/init.c
    RUN("%clang_cc1 -x c++ -std=c++98 -fno-rtti -E -dM < /dev/null")./*|*/
      I("FileCheck -match-full-lines -check-prefix NORTTI %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple arm-linux-androideabi -E -dM < /dev/null | ${LLVM_SRC}/build/bin/FileCheck -match-full-lines -check-prefix ANDROID ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/init.c
    RUN("%clang_cc1 -triple arm-linux-androideabi -E -dM < /dev/null")./*|*/
      I("FileCheck -match-full-lines -check-prefix ANDROID %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple lanai-unknown-unknown -E -dM < /dev/null | ${LLVM_SRC}/build/bin/FileCheck -match-full-lines -check-prefix LANAI ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/init.c
    RUN("%clang_cc1 -triple lanai-unknown-unknown -E -dM < /dev/null")./*|*/
      I("FileCheck -match-full-lines -check-prefix LANAI %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -E -dM -ffreestanding -triple=powerpc64-unknown-freebsd < /dev/null | ${LLVM_SRC}/build/bin/FileCheck -match-full-lines -check-prefix PPC64-FREEBSD ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/init.c
    RUN("%clang_cc1 -E -dM -ffreestanding -triple=powerpc64-unknown-freebsd < /dev/null")./*|*/
      I("FileCheck -match-full-lines -check-prefix PPC64-FREEBSD %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -E -dM -ffreestanding -triple=xcore-none-none < /dev/null | ${LLVM_SRC}/build/bin/FileCheck -match-full-lines -check-prefix XCORE ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/init.c
    RUN("%clang_cc1 -E -dM -ffreestanding -triple=xcore-none-none < /dev/null")./*|*/
      I("FileCheck -match-full-lines -check-prefix XCORE %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -E -dM -ffreestanding -triple=wasm32-unknown-unknown < /dev/null | ${LLVM_SRC}/build/bin/FileCheck -match-full-lines -check-prefix=WEBASSEMBLY32 ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/init.c
    RUN("%clang_cc1 -E -dM -ffreestanding -triple=wasm32-unknown-unknown < /dev/null")./*|*/
      I("FileCheck -match-full-lines -check-prefix=WEBASSEMBLY32 %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -E -dM -ffreestanding -triple=wasm64-unknown-unknown < /dev/null | ${LLVM_SRC}/build/bin/FileCheck -match-full-lines -check-prefix=WEBASSEMBLY64 ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/init.c
    RUN("%clang_cc1 -E -dM -ffreestanding -triple=wasm64-unknown-unknown < /dev/null")./*|*/
      I("FileCheck -match-full-lines -check-prefix=WEBASSEMBLY64 %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -E -dM -ffreestanding -triple i686-windows-cygnus < /dev/null | ${LLVM_SRC}/build/bin/FileCheck -match-full-lines -check-prefix CYGWIN-X32 ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/init.c
    RUN("%clang_cc1 -E -dM -ffreestanding -triple i686-windows-cygnus < /dev/null")./*|*/
      I("FileCheck -match-full-lines -check-prefix CYGWIN-X32 %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -E -dM -ffreestanding -triple x86_64-windows-cygnus < /dev/null | ${LLVM_SRC}/build/bin/FileCheck -match-full-lines -check-prefix CYGWIN-X64 ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/init.c
    RUN("%clang_cc1 -E -dM -ffreestanding -triple x86_64-windows-cygnus < /dev/null")./*|*/
      I("FileCheck -match-full-lines -check-prefix CYGWIN-X64 %s");
  }

  @Test
  public void test_init_v7k_compat_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/init-v7k-compat.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -E -dM -ffreestanding -triple=thumbv7k-apple-watchos2.0 < /dev/null | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/init-v7k-compat.c
    RUN("%clang_cc1 -E -dM -ffreestanding -triple=thumbv7k-apple-watchos2.0 < /dev/null")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_invalid___has_warning1_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/invalid-__has_warning1.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -verify ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/invalid-__has_warning1.c
    RUN("%clang_cc1 -verify %s");
  }

  @Test
  public void test_invalid___has_warning2_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/invalid-__has_warning2.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -verify ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/invalid-__has_warning2.c
    RUN("%clang_cc1 -verify %s");
  }

  @Test
  public void test_iwithprefix_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/iwithprefix.c");
    // rm -rf ${TEST_TEMP_DIR}/iwithprefix.c.tmp.tmps
    RUN("rm -rf %t.tmps");
    // mkdir -p ${TEST_TEMP_DIR}/iwithprefix.c.tmp.tmps/first ${TEST_TEMP_DIR}/iwithprefix.c.tmp.tmps/second
    RUN("mkdir -p %t.tmps/first %t.tmps/second");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-unknown-unknown -iprefix ${TEST_TEMP_DIR}/iwithprefix.c.tmp.tmps/ -iwithprefix second -isystem ${TEST_TEMP_DIR}/iwithprefix.c.tmp.tmps/first -v ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/iwithprefix.c 2> ${TEST_TEMP_DIR}/iwithprefix.c.tmp.out
    RUN("%clang_cc1 -triple x86_64-unknown-unknown -iprefix %t.tmps/ -iwithprefix second -isystem %t.tmps/first -v %s 2> %t.out");
    // ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/iwithprefix.c < ${TEST_TEMP_DIR}/iwithprefix.c.tmp.out
    RUN("FileCheck %s < %t.out");
  }

  @Test
  public void test_line_directive_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/line-directive.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c99 -fsyntax-only -verify -pedantic ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/line-directive.c
    RUN("%clang_cc1 -std=c99 -fsyntax-only -verify -pedantic %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -E ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/line-directive.c 2>&1 | grep 'blonk.c:92:2: error: ABC'
    RUN("not %clang_cc1 -E %s 2>&1")./*|*/
      I("grep 'blonk.c:92:2: error: ABC'");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -E ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/line-directive.c 2>&1 | grep 'blonk.c:93:2: error: DEF'
    RUN("not %clang_cc1 -E %s 2>&1")./*|*/
      I("grep 'blonk.c:93:2: error: DEF'");
  }

  @Test
  public void test_line_directive_output_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/line-directive-output.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -E ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/line-directive-output.c 2>&1 | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/line-directive-output.c -strict-whitespace
    RUN("%clang_cc1 -E %s 2>&1")./*|*/
      I("FileCheck %s -strict-whitespace");
  }

  @Test
  public void test_macho_embedded_predefines_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/macho-embedded-predefines.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -E -dM -triple thumbv7m-apple-unknown-macho -target-cpu cortex-m3 ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/macho-embedded-predefines.c | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/macho-embedded-predefines.c -check-prefix CHECK-7M
    RUN("%clang_cc1 -E -dM -triple thumbv7m-apple-unknown-macho -target-cpu cortex-m3 %s")./*|*/
      I("FileCheck %s -check-prefix CHECK-7M");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -E -dM -triple thumbv7em-apple-unknown-macho -target-cpu cortex-m4 ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/macho-embedded-predefines.c | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/macho-embedded-predefines.c -check-prefix CHECK-7EM
    RUN("%clang_cc1 -E -dM -triple thumbv7em-apple-unknown-macho -target-cpu cortex-m4 %s")./*|*/
      I("FileCheck %s -check-prefix CHECK-7EM");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -E -dM -triple thumbv6m-apple-unknown-macho -target-cpu cortex-m0 ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/macho-embedded-predefines.c | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/macho-embedded-predefines.c -check-prefix CHECK-6M
    RUN("%clang_cc1 -E -dM -triple thumbv6m-apple-unknown-macho -target-cpu cortex-m0 %s")./*|*/
      I("FileCheck %s -check-prefix CHECK-6M");
  }

  @Test
  public void test_macro_multiline_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/macro-multiline.c");
    // printf -- -DX=A\nTHIS_SHOULD_NOT_EXIST_IN_THE_OUTPUT | xargs -0 ${LLVM_SRC}/build/bin/clang -E ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/macro-multiline.c | ${LLVM_SRC}/build/bin/FileCheck -strict-whitespace ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/macro-multiline.c
    RUN("printf -- \"-DX=A\\nTHIS_SHOULD_NOT_EXIST_IN_THE_OUTPUT\"")./*|*/
      I("xargs -0 %clang -E %s")./*|*/
      I("FileCheck -strict-whitespace %s");
  }

  @Test
  public void test_macro_reserved_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/macro-reserved.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -pedantic -verify ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/macro-reserved.c
    RUN("%clang_cc1 -fsyntax-only -pedantic -verify %s");
  }

  @Test
  public void test_macro_reserved_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/macro-reserved.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -pedantic -std=c++98 ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/macro-reserved.cpp
    RUN("%clang_cc1 -fsyntax-only -verify -pedantic -std=c++98 %s");
  }

  @Test
  public void test_macro_reserved_cxx11_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/macro-reserved-cxx11.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -std=c++11 -pedantic -verify ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/macro-reserved-cxx11.cpp
    RUN("%clang_cc1 -fsyntax-only -std=c++11 -pedantic -verify %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -std=c++14 -pedantic -verify ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/macro-reserved-cxx11.cpp
    RUN("%clang_cc1 -fsyntax-only -std=c++14 -pedantic -verify %s");
  }

  @Test
  public void test_macro_reserved_ms_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/macro-reserved-ms.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -fms-extensions -verify ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/macro-reserved-ms.c
    RUN("%clang_cc1 -fsyntax-only -fms-extensions -verify %s");
  }

  @Test
  public void test_macro_arg_directive_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/macro_arg_directive.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/macro_arg_directive.c -fsyntax-only -verify
    RUN("%clang_cc1 %s -fsyntax-only -verify");
  }

  @Test
  public void test_macro_arg_empty_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/macro_arg_empty.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -E ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/macro_arg_empty.c | ${LLVM_SRC}/build/bin/FileCheck --strict-whitespace ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/macro_arg_empty.c
    RUN("%clang_cc1 -E %s")./*|*/
      I("FileCheck --strict-whitespace %s");
  }

  @Test
  public void test_macro_arg_keyword_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/macro_arg_keyword.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -E ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/macro_arg_keyword.c | grep xxx-xxx
    RUN("%clang_cc1 -E %s")./*|*/
      I("grep xxx-xxx");
  }

  @Test
  public void test_macro_arg_slocentry_merge_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/macro_arg_slocentry_merge.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/macro_arg_slocentry_merge.c 2>&1 | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/macro_arg_slocentry_merge.c
    RUN("not %clang_cc1 -fsyntax-only %s 2>&1")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_macro_backslash_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/macro_backslash.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -E ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/macro_backslash.c "-Dfoo='bar\'" | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/macro_backslash.c
    RUN("%clang_cc1 -E %s -Dfoo='bar\\'")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_macro_disable_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/macro_disable.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/macro_disable.c -E | ${LLVM_SRC}/build/bin/FileCheck -strict-whitespace ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/macro_disable.c
    RUN("%clang_cc1 %s -E")./*|*/
      I("FileCheck -strict-whitespace %s");
  }

  @Test
  public void test_macro_expand_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/macro_expand.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -E ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/macro_expand.c | ${LLVM_SRC}/build/bin/FileCheck --strict-whitespace ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/macro_expand.c
    RUN("%clang_cc1 -E %s")./*|*/
      I("FileCheck --strict-whitespace %s");
  }

  @Test
  public void test_macro_expand_empty_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/macro_expand_empty.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -E ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/macro_expand_empty.c | ${LLVM_SRC}/build/bin/FileCheck --strict-whitespace ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/macro_expand_empty.c
    RUN("%clang_cc1 -E %s")./*|*/
      I("FileCheck --strict-whitespace %s");
  }

  @Test
  public void test_macro_expandloc_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/macro_expandloc.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -E -verify ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/macro_expandloc.c
    RUN("%clang_cc1 -E -verify %s");
  }

  @Test
  public void test_macro_fn_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/macro_fn.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/macro_fn.c -Eonly -std=c89 -pedantic -verify
    RUN("%clang_cc1 %s -Eonly -std=c89 -pedantic -verify");
  }

  @Test
  public void test_macro_fn_comma_swallow_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/macro_fn_comma_swallow.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/macro_fn_comma_swallow.c -E | ${LLVM_SRC}/build/bin/FileCheck -strict-whitespace ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/macro_fn_comma_swallow.c
    RUN("%clang_cc1 %s -E")./*|*/
      I("FileCheck -strict-whitespace %s");
  }

  @Test
  public void test_macro_fn_comma_swallow2_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/macro_fn_comma_swallow2.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -E ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/macro_fn_comma_swallow2.c | ${LLVM_SRC}/build/bin/FileCheck -check-prefix=GCC -strict-whitespace ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/macro_fn_comma_swallow2.c
    RUN("%clang_cc1 -E %s")./*|*/
      I("FileCheck -check-prefix=GCC -strict-whitespace %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -E -std=c99 ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/macro_fn_comma_swallow2.c | ${LLVM_SRC}/build/bin/FileCheck -check-prefix=C99 -strict-whitespace ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/macro_fn_comma_swallow2.c
    RUN("%clang_cc1 -E -std=c99 %s")./*|*/
      I("FileCheck -check-prefix=C99 -strict-whitespace %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -E -std=c11 ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/macro_fn_comma_swallow2.c | ${LLVM_SRC}/build/bin/FileCheck -check-prefix=C99 -strict-whitespace ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/macro_fn_comma_swallow2.c
    RUN("%clang_cc1 -E -std=c11 %s")./*|*/
      I("FileCheck -check-prefix=C99 -strict-whitespace %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -E -x c++ ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/macro_fn_comma_swallow2.c | ${LLVM_SRC}/build/bin/FileCheck -check-prefix=GCC -strict-whitespace ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/macro_fn_comma_swallow2.c
    RUN("%clang_cc1 -E -x c++ %s")./*|*/
      I("FileCheck -check-prefix=GCC -strict-whitespace %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -E -std=gnu99 ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/macro_fn_comma_swallow2.c | ${LLVM_SRC}/build/bin/FileCheck -check-prefix=GCC -strict-whitespace ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/macro_fn_comma_swallow2.c
    RUN("%clang_cc1 -E -std=gnu99 %s")./*|*/
      I("FileCheck -check-prefix=GCC -strict-whitespace %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -E -fms-compatibility ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/macro_fn_comma_swallow2.c | ${LLVM_SRC}/build/bin/FileCheck -check-prefix=MS -strict-whitespace ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/macro_fn_comma_swallow2.c
    RUN("%clang_cc1 -E -fms-compatibility %s")./*|*/
      I("FileCheck -check-prefix=MS -strict-whitespace %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -E -DNAMED ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/macro_fn_comma_swallow2.c | ${LLVM_SRC}/build/bin/FileCheck -check-prefix=GCC -strict-whitespace ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/macro_fn_comma_swallow2.c
    RUN("%clang_cc1 -E -DNAMED %s")./*|*/
      I("FileCheck -check-prefix=GCC -strict-whitespace %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -E -std=c99 -DNAMED ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/macro_fn_comma_swallow2.c | ${LLVM_SRC}/build/bin/FileCheck -check-prefix=C99 -strict-whitespace ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/macro_fn_comma_swallow2.c
    RUN("%clang_cc1 -E -std=c99 -DNAMED %s")./*|*/
      I("FileCheck -check-prefix=C99 -strict-whitespace %s");
  }

  @Test
  public void test_macro_fn_disable_expand_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/macro_fn_disable_expand.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/macro_fn_disable_expand.c -E | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/macro_fn_disable_expand.c
    RUN("%clang_cc1 %s -E")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_macro_fn_lparen_scan_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/macro_fn_lparen_scan.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -E ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/macro_fn_lparen_scan.c | grep 'noexp: foo y'
    RUN("%clang_cc1 -E %s")./*|*/
      I("grep 'noexp: foo y'");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -E ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/macro_fn_lparen_scan.c | grep 'expand: abc'
    RUN("%clang_cc1 -E %s")./*|*/
      I("grep 'expand: abc'");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -E ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/macro_fn_lparen_scan.c | grep 'noexp2: foo nonexp'
    RUN("%clang_cc1 -E %s")./*|*/
      I("grep 'noexp2: foo nonexp'");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -E ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/macro_fn_lparen_scan.c | grep 'expand2: abc'
    RUN("%clang_cc1 -E %s")./*|*/
      I("grep 'expand2: abc'");
  }

  @Test
  public void test_macro_fn_lparen_scan2_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/macro_fn_lparen_scan2.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -E ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/macro_fn_lparen_scan2.c | grep 'FUNC (3 +1);'
    RUN("%clang_cc1 -E %s")./*|*/
      I("grep 'FUNC (3 +1);'");
  }

  @Test
  public void test_macro_fn_placemarker_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/macro_fn_placemarker.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/macro_fn_placemarker.c -E | grep 'foo(A, )'
    RUN("%clang_cc1 %s -E")./*|*/
      I("grep 'foo(A, )'");
  }

  @Test
  public void test_macro_fn_preexpand_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/macro_fn_preexpand.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/macro_fn_preexpand.c -E | grep 'pre: 1 1 X'
    RUN("%clang_cc1 %s -E")./*|*/
      I("grep 'pre: 1 1 X'");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/macro_fn_preexpand.c -E | grep 'nopre: 1A(X)'
    RUN("%clang_cc1 %s -E")./*|*/
      I("grep 'nopre: 1A(X)'");
  }

  @Test
  public void test_macro_fn_varargs_iso_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/macro_fn_varargs_iso.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -E ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/macro_fn_varargs_iso.c | grep 'foo{a, b, c, d, e}'
    RUN("%clang_cc1 -E %s")./*|*/
      I("grep 'foo{a, b, c, d, e}'");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -E ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/macro_fn_varargs_iso.c | grep 'foo2{d, C, B}'
    RUN("%clang_cc1 -E %s")./*|*/
      I("grep 'foo2{d, C, B}'");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -E ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/macro_fn_varargs_iso.c | grep 'foo2{d,e, C, B}'
    RUN("%clang_cc1 -E %s")./*|*/
      I("grep 'foo2{d,e, C, B}'");
  }

  @Test
  public void test_macro_fn_varargs_named_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/macro_fn_varargs_named.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -E ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/macro_fn_varargs_named.c | grep '^a: x$'
    RUN("%clang_cc1 -E %s")./*|*/
      I("grep '^a: x$'");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -E ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/macro_fn_varargs_named.c | grep '^b: x y, z,h$'
    RUN("%clang_cc1 -E %s")./*|*/
      I("grep '^b: x y, z,h$'");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -E ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/macro_fn_varargs_named.c | grep '^c: foo(x)$'
    RUN("%clang_cc1 -E %s")./*|*/
      I("grep '^c: foo(x)$'");
  }

  @Test
  public void test_macro_misc_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/macro_misc.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/macro_misc.c -Eonly -verify
    RUN("%clang_cc1 %s -Eonly -verify");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fms-extensions -DMS_EXT ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/macro_misc.c -Eonly -verify
    RUN("%clang_cc1 -fms-extensions -DMS_EXT %s -Eonly -verify");
  }

  @Test
  public void test_macro_not_define_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/macro_not_define.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -E ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/macro_not_define.c | grep '^ # define X 3$'
    RUN("%clang_cc1 -E %s")./*|*/
      I("grep '^ # define X 3$'");
  }

  @Test
  public void test_macro_paste_bad_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/macro_paste_bad.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -Eonly -verify -pedantic ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/macro_paste_bad.c
    RUN("%clang_cc1 -Eonly -verify -pedantic %s");
  }

  @Test
  public void test_macro_paste_bcpl_comment_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/macro_paste_bcpl_comment.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/macro_paste_bcpl_comment.c -Eonly 2>&1 | grep error
    RUN("not %clang_cc1 %s -Eonly 2>&1")./*|*/
      I("grep error");
  }

  @Test
  public void test_macro_paste_c_block_comment_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/macro_paste_c_block_comment.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/macro_paste_c_block_comment.c -Eonly -verify
    RUN("%clang_cc1 %s -Eonly -verify");
  }

  @Test
  public void test_macro_paste_commaext_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/macro_paste_commaext.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/macro_paste_commaext.c -E | grep 'V);'
    RUN("%clang_cc1 %s -E")./*|*/
      I("grep 'V);'");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/macro_paste_commaext.c -E | grep 'W, 1, 2);'
    RUN("%clang_cc1 %s -E")./*|*/
      I("grep 'W, 1, 2);'");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/macro_paste_commaext.c -E | grep 'X, 1, 2);'
    RUN("%clang_cc1 %s -E")./*|*/
      I("grep 'X, 1, 2);'");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/macro_paste_commaext.c -E | grep 'Y,);'
    RUN("%clang_cc1 %s -E")./*|*/
      I("grep 'Y,);'");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/macro_paste_commaext.c -E | grep 'Z,);'
    RUN("%clang_cc1 %s -E")./*|*/
      I("grep 'Z,);'");
  }

  @Test
  public void test_macro_paste_empty_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/macro_paste_empty.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -E ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/macro_paste_empty.c | ${LLVM_SRC}/build/bin/FileCheck --strict-whitespace ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/macro_paste_empty.c
    RUN("%clang_cc1 -E %s")./*|*/
      I("FileCheck --strict-whitespace %s");
  }

  @Test
  public void test_macro_paste_hard_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/macro_paste_hard.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -E ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/macro_paste_hard.c | grep '1: aaab 2'
    RUN("%clang_cc1 -E %s")./*|*/
      I("grep '1: aaab 2'");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -E ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/macro_paste_hard.c | grep '2: 2 baaa'
    RUN("%clang_cc1 -E %s")./*|*/
      I("grep '2: 2 baaa'");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -E ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/macro_paste_hard.c | grep '3: 2 xx'
    RUN("%clang_cc1 -E %s")./*|*/
      I("grep '3: 2 xx'");
  }

  @Test
  public void test_macro_paste_hashhash_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/macro_paste_hashhash.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -E ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/macro_paste_hashhash.c | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/macro_paste_hashhash.c
    RUN("%clang_cc1 -E %s")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_macro_paste_identifier_error_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/macro_paste_identifier_error.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fms-extensions -Wno-invalid-token-paste ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/macro_paste_identifier_error.c -verify
    RUN("%clang_cc1 -fms-extensions -Wno-invalid-token-paste %s -verify");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -E -fms-extensions -Wno-invalid-token-paste ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/macro_paste_identifier_error.c | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/macro_paste_identifier_error.c
    RUN("%clang_cc1 -E -fms-extensions -Wno-invalid-token-paste %s")./*|*/
      I("FileCheck %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -E -fms-extensions -Wno-invalid-token-paste -x assembler-with-cpp ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/macro_paste_identifier_error.c | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/macro_paste_identifier_error.c
    RUN("%clang_cc1 -E -fms-extensions -Wno-invalid-token-paste -x assembler-with-cpp %s")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_macro_paste_msextensions_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/macro_paste_msextensions.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -verify -fms-extensions -Wmicrosoft ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/macro_paste_msextensions.c
    RUN("%clang_cc1 -verify -fms-extensions -Wmicrosoft %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -P -E -fms-extensions ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/macro_paste_msextensions.c | ${LLVM_SRC}/build/bin/FileCheck -strict-whitespace ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/macro_paste_msextensions.c
    RUN("not %clang_cc1 -P -E -fms-extensions %s")./*|*/
      I("FileCheck -strict-whitespace %s");
  }

  @Test
  public void test_macro_paste_none_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/macro_paste_none.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -E ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/macro_paste_none.c | grep !!
    RUN("%clang_cc1 -E %s")./*|*/
      I("grep '!!'");
  }

  @Test
  public void test_macro_paste_simple_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/macro_paste_simple.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/macro_paste_simple.c -E | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/macro_paste_simple.c
    RUN("%clang_cc1 %s -E")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_macro_paste_spacing_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/macro_paste_spacing.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -E ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/macro_paste_spacing.c | ${LLVM_SRC}/build/bin/FileCheck --strict-whitespace ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/macro_paste_spacing.c
    RUN("%clang_cc1 -E %s")./*|*/
      I("FileCheck --strict-whitespace %s");
  }

  @Test
  public void test_macro_paste_spacing2_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/macro_paste_spacing2.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/macro_paste_spacing2.c -E | grep 'movl %eax'
    RUN("%clang_cc1 %s -E")./*|*/
      I("grep \"movl %eax\"");
  }

  @Test
  public void test_macro_redefined_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/macro_redefined.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/macro_redefined.c -Eonly -verify -Wno-all -Wmacro-redefined -DCLI_MACRO=1 -DWMACRO_REDEFINED
    RUN("%clang_cc1 %s -Eonly -verify -Wno-all -Wmacro-redefined -DCLI_MACRO=1 -DWMACRO_REDEFINED");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/macro_redefined.c -Eonly -verify -Wno-all -Wno-macro-redefined -DCLI_MACRO=1
    RUN("%clang_cc1 %s -Eonly -verify -Wno-all -Wno-macro-redefined -DCLI_MACRO=1");
  }

  @Test
  public void test_macro_rescan_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/macro_rescan.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -E ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/macro_rescan.c | ${LLVM_SRC}/build/bin/FileCheck --strict-whitespace ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/macro_rescan.c
    RUN("%clang_cc1 -E %s")./*|*/
      I("FileCheck --strict-whitespace %s");
  }

  @Test
  public void test_macro_rescan2_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/macro_rescan2.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/macro_rescan2.c -E | grep 'a: 2\*f(9)'
    RUN("%clang_cc1 %s -E")./*|*/
      I("grep 'a: 2\\*f(9)'");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/macro_rescan2.c -E | grep 'b: 2\*9\*g'
    RUN("%clang_cc1 %s -E")./*|*/
      I("grep 'b: 2\\*9\\*g'");
  }

  @Test
  public void test_macro_rescan_varargs_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/macro_rescan_varargs.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -E ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/macro_rescan_varargs.c | ${LLVM_SRC}/build/bin/FileCheck -strict-whitespace ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/macro_rescan_varargs.c
    RUN("%clang_cc1 -E %s")./*|*/
      I("FileCheck -strict-whitespace %s");
  }

  @Test
  public void test_macro_rparen_scan_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/macro_rparen_scan.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -E ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/macro_rparen_scan.c | grep '^3 ;$'
    RUN("%clang_cc1 -E %s")./*|*/
      I("grep '^3 ;$'");
  }

  @Test
  public void test_macro_rparen_scan2_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/macro_rparen_scan2.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -E ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/macro_rparen_scan2.c | ${LLVM_SRC}/build/bin/FileCheck -strict-whitespace ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/macro_rparen_scan2.c
    RUN("%clang_cc1 -E %s")./*|*/
      I("FileCheck -strict-whitespace %s");
  }

  @Test
  public void test_macro_space_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/macro_space.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -E ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/macro_space.c | ${LLVM_SRC}/build/bin/FileCheck --strict-whitespace ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/macro_space.c
    RUN("%clang_cc1 -E %s")./*|*/
      I("FileCheck --strict-whitespace %s");
  }

  @Test
  public void test_macro_undef_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/macro_undef.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -dM -undef -Dfoo=1 -E ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/macro_undef.c | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/macro_undef.c
    RUN("%clang_cc1 -dM -undef -Dfoo=1 -E %s")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_macro_variadic_cl() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/macro_variadic.cl");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -verify ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/macro_variadic.cl
    RUN("%clang_cc1 -verify %s");
  }

  @Test
  public void test_macro_with_initializer_list_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/macro_with_initializer_list.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c++11 -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/macro_with_initializer_list.cpp
    RUN("%clang_cc1 -std=c++11 -fsyntax-only -verify %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c++11 -fsyntax-only -fdiagnostics-parseable-fixits ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/macro_with_initializer_list.cpp 2>&1 | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/macro_with_initializer_list.cpp
    RUN("not %clang_cc1 -std=c++11 -fsyntax-only -fdiagnostics-parseable-fixits %s 2>&1")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_mi_opt_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/mi_opt.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/mi_opt.c
    RUN("not %clang_cc1 -fsyntax-only %s");
  }

  @Test
  public void test_mi_opt2_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/mi_opt2.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -E ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/mi_opt2.c | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/mi_opt2.c
    RUN("%clang_cc1 -E %s")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_microsoft_ext_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/microsoft-ext.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -E -fms-compatibility ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/microsoft-ext.c -o ${TEST_TEMP_DIR}/microsoft-ext.c.tmp
    RUN("%clang_cc1 -E -fms-compatibility %s -o %t");
    // ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/microsoft-ext.c < ${TEST_TEMP_DIR}/microsoft-ext.c.tmp
    RUN("FileCheck %s < %t");
  }

  @Test
  public void test_microsoft_header_search_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/microsoft-header-search.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc '-I${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/Inputs/microsoft-header-search' ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/microsoft-header-search.c -fms-compatibility -verify
    RUN("%clang_cc1 -I%S/Inputs/microsoft-header-search %s -fms-compatibility -verify");
  }

  @Test
  public void test_microsoft_import_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/microsoft-import.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -E -verify -fms-compatibility ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/microsoft-import.c
    RUN("%clang_cc1 -E -verify -fms-compatibility %s");
  }

  @Test
  public void test_missing_system_header_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/missing-system-header.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -verify -fsyntax-only ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/missing-system-header.c
    RUN("%clang_cc1 -verify -fsyntax-only %s");
  }

  @Test
  public void test_mmx_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/mmx.c");
    // ${LLVM_SRC}/build/bin/clang -march=i386 -m32 -E -dM ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/mmx.c -msse -o - 2>&1 -target i386-unknown-linux | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/mmx.c -check-prefix=SSE_AND_MMX
    RUN("%clang -march=i386 -m32 -E -dM %s -msse -o - 2>&1 -target i386-unknown-linux")./*|*/
      I("FileCheck %s -check-prefix=SSE_AND_MMX");
    // ${LLVM_SRC}/build/bin/clang -march=i386 -m32 -E -dM ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/mmx.c -msse -mno-mmx -o - 2>&1 -target i386-unknown-linux | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/mmx.c -check-prefix=SSE_NO_MMX
    RUN("%clang -march=i386 -m32 -E -dM %s -msse -mno-mmx -o - 2>&1 -target i386-unknown-linux")./*|*/
      I("FileCheck %s -check-prefix=SSE_NO_MMX");
    // ${LLVM_SRC}/build/bin/clang -march=i386 -m32 -E -dM ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/mmx.c -mno-mmx -msse -o - 2>&1 -target i386-unknown-linux | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/mmx.c -check-prefix=SSE_NO_MMX
    RUN("%clang -march=i386 -m32 -E -dM %s -mno-mmx -msse -o - 2>&1 -target i386-unknown-linux")./*|*/
      I("FileCheck %s -check-prefix=SSE_NO_MMX");
  }

  @Test
  public void test_non_fragile_feature_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/non_fragile_feature.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/non_fragile_feature.m
    RUN("%clang_cc1 %s");
  }

  @Test
  public void test_non_fragile_feature1_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/non_fragile_feature1.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i386-unknown-unknown -fobjc-runtime=gcc ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/non_fragile_feature1.m
    RUN("%clang_cc1 -triple i386-unknown-unknown -fobjc-runtime=gcc %s");
  }

  @Test
  public void test_objc_pp_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/objc-pp.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/objc-pp.m -fsyntax-only -verify -pedantic -ffreestanding
    RUN("%clang_cc1 %s -fsyntax-only -verify -pedantic -ffreestanding");
  }

  @Test
  public void test_openmp_macro_expansion_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/openmp-macro-expansion.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fopenmp -E -o - ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/openmp-macro-expansion.c 2>&1 | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/openmp-macro-expansion.c
    RUN("%clang_cc1 -fopenmp -E -o - %s 2>&1")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_optimize_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/optimize.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -Eonly ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/optimize.c -DOPT_O2 -O2 -verify
    RUN("%clang_cc1 -Eonly %s -DOPT_O2 -O2 -verify");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -Eonly ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/optimize.c -DOPT_O0 -verify
    RUN("%clang_cc1 -Eonly %s -DOPT_O0 -verify");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -Eonly ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/optimize.c -DOPT_OS -Os -verify
    RUN("%clang_cc1 -Eonly %s -DOPT_OS -Os -verify");
  }

  @Test
  public void test_output_paste_avoid_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/output_paste_avoid.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -E -std=c++11 ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/output_paste_avoid.cpp -o - | ${LLVM_SRC}/build/bin/FileCheck -strict-whitespace ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/output_paste_avoid.cpp
    RUN("%clang_cc1 -E -std=c++11 %s -o -")./*|*/
      I("FileCheck -strict-whitespace %s");
  }

  @Test
  public void test_overflow_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/overflow.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -Eonly ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/overflow.c -verify -triple i686-pc-linux-gnu
    RUN("%clang_cc1 -Eonly %s -verify -triple i686-pc-linux-gnu");
  }

  @Test
  public void test_pic_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/pic.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -dM -E -o - ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/pic.c | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/pic.c
    RUN("%clang_cc1 -dM -E -o - %s")./*|*/
      I("FileCheck %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -pic-level 1 -dM -E -o - ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/pic.c | ${LLVM_SRC}/build/bin/FileCheck --check-prefix=CHECK-PIC1 ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/pic.c
    RUN("%clang_cc1 -pic-level 1 -dM -E -o - %s")./*|*/
      I("FileCheck --check-prefix=CHECK-PIC1 %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -pic-level 2 -dM -E -o - ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/pic.c | ${LLVM_SRC}/build/bin/FileCheck --check-prefix=CHECK-PIC2 ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/pic.c
    RUN("%clang_cc1 -pic-level 2 -dM -E -o - %s")./*|*/
      I("FileCheck --check-prefix=CHECK-PIC2 %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -pic-level 1 -pic-is-pie -dM -E -o - ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/pic.c | ${LLVM_SRC}/build/bin/FileCheck --check-prefix=CHECK-PIE1 ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/pic.c
    RUN("%clang_cc1 -pic-level 1 -pic-is-pie -dM -E -o - %s")./*|*/
      I("FileCheck --check-prefix=CHECK-PIE1 %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -pic-level 2 -pic-is-pie -dM -E -o - ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/pic.c | ${LLVM_SRC}/build/bin/FileCheck --check-prefix=CHECK-PIE2 ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/pic.c
    RUN("%clang_cc1 -pic-level 2 -pic-is-pie -dM -E -o - %s")./*|*/
      I("FileCheck --check-prefix=CHECK-PIE2 %s");
  }

  @Test
  public void test_pp_modules_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/pp-modules.c");
    // rm -rf ${TEST_TEMP_DIR}/pp-modules.c.tmp
    RUN("rm -rf %t");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fmodules -fimplicit-module-maps '-fmodules-cache-path=${TEST_TEMP_DIR}/pp-modules.c.tmp' -x objective-c ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/pp-modules.c -F ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/../Modules/Inputs -E -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/pp-modules.c
    RUN("%clang_cc1 -fmodules -fimplicit-module-maps -fmodules-cache-path=%t -x objective-c %s -F %S/../Modules/Inputs -E -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_pp_record_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/pp-record.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -detailed-preprocessing-record ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/pp-record.c
    RUN("%clang_cc1 -fsyntax-only -detailed-preprocessing-record %s");
  }

  @Test
  public void test_pr13851_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/pr13851.c");
    // ${LLVM_SRC}/build/bin/clang -Werror -E -M -MF ${TEST_TEMP_DIR}/pr13851.c.tmp-M.d ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/pr13851.c
    RUN("%clang -Werror -E -M -MF %t-M.d %s");
    // ${LLVM_SRC}/build/bin/FileCheck '--input-file=${TEST_TEMP_DIR}/pr13851.c.tmp-M.d' ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/pr13851.c
    RUN("FileCheck --input-file=%t-M.d %s");
    // ${LLVM_SRC}/build/bin/clang -Werror -E -MM -MF ${TEST_TEMP_DIR}/pr13851.c.tmp-MM.d ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/pr13851.c
    RUN("%clang -Werror -E -MM -MF %t-MM.d %s");
    // ${LLVM_SRC}/build/bin/FileCheck '--input-file=${TEST_TEMP_DIR}/pr13851.c.tmp-MM.d' ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/pr13851.c
    RUN("FileCheck --input-file=%t-MM.d %s");
  }

  @Test
  public void test_pr19649_signed_wchar_t_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/pr19649-signed-wchar_t.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple powerpc64-unknown-linux-gnu -E -x c ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/pr19649-signed-wchar_t.c
    RUN("%clang_cc1 -triple powerpc64-unknown-linux-gnu -E -x c %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple powerpc64-unknown-linux-gnu -E -fno-signed-char -x c ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/pr19649-signed-wchar_t.c
    RUN("%clang_cc1 -triple powerpc64-unknown-linux-gnu -E -fno-signed-char -x c %s");
  }

  @Test
  public void test_pr19649_unsigned_wchar_t_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/pr19649-unsigned-wchar_t.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i386-pc-cygwin -E -x c ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/pr19649-unsigned-wchar_t.c
    RUN("%clang_cc1 -triple i386-pc-cygwin -E -x c %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple powerpc64-unknown-linux-gnu -E -fshort-wchar -x c ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/pr19649-unsigned-wchar_t.c
    RUN("%clang_cc1 -triple powerpc64-unknown-linux-gnu -E -fshort-wchar -x c %s");
  }

  @Test
  public void test_pr2086_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/pr2086.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -E ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/pr2086.c
    RUN("%clang_cc1 -E %s");
  }

  @Test
  public void test_pragma_captured_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/pragma-captured.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -E ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/pragma-captured.c | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/pragma-captured.c
    RUN("%clang_cc1 -E %s")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_pragma_pushpop_macro_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/pragma-pushpop-macro.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fms-extensions -E ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/pragma-pushpop-macro.c -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/pragma-pushpop-macro.c
    RUN("%clang_cc1 -fms-extensions -E %s -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_pragma_diagnostic_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/pragma_diagnostic.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -Wno-undef ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/pragma_diagnostic.c
    RUN("%clang_cc1 -fsyntax-only -verify -Wno-undef %s");
  }

  @Test
  public void test_pragma_diagnostic_output_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/pragma_diagnostic_output.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -E ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/pragma_diagnostic_output.c | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/pragma_diagnostic_output.c
    RUN("%clang_cc1 -E %s")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_pragma_diagnostic_sections_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/pragma_diagnostic_sections.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -Wall -Wunused-macros -Wunused-parameter -Wno-uninitialized -verify ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/pragma_diagnostic_sections.cpp
    RUN("%clang_cc1 -fsyntax-only -Wall -Wunused-macros -Wunused-parameter -Wno-uninitialized -verify %s");
  }

  @Test
  public void test_pragma_microsoft_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/pragma_microsoft.c");
    // REQUIRES: non-ps4-sdk
    if (!CHECK_REQUIRES("non-ps4-sdk")) {
      return;
    }
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/pragma_microsoft.c -fsyntax-only -verify -fms-extensions -Wunknown-pragmas
    RUN("%clang_cc1 %s -fsyntax-only -verify -fms-extensions -Wunknown-pragmas");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/pragma_microsoft.c -fms-extensions -E | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/pragma_microsoft.c
    RUN("not %clang_cc1 %s -fms-extensions -E")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_pragma_microsoft_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/pragma_microsoft.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/pragma_microsoft.cpp -fsyntax-only -std=c++11 -verify -fms-extensions
    RUN("%clang_cc1 %s -fsyntax-only -std=c++11 -verify -fms-extensions");
  }

  @Test
  public void test_pragma_poison_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/pragma_poison.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/pragma_poison.c -Eonly -verify
    RUN("%clang_cc1 %s -Eonly -verify");
  }

  @Test
  public void test_pragma_ps4_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/pragma_ps4.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/pragma_ps4.c -triple x86_64-scei-ps4 -fsyntax-only -verify -fms-extensions
    RUN("%clang_cc1 %s -triple x86_64-scei-ps4 -fsyntax-only -verify -fms-extensions");
  }

  @Test
  public void test_pragma_sysheader_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/pragma_sysheader.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -verify -pedantic ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/pragma_sysheader.c -fsyntax-only
    RUN("%clang_cc1 -verify -pedantic %s -fsyntax-only");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -E ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/pragma_sysheader.c | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/pragma_sysheader.c
    RUN("%clang_cc1 -E %s")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_pragma_unknown_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/pragma_unknown.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -Wunknown-pragmas -verify ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/pragma_unknown.c
    RUN("%clang_cc1 -fsyntax-only -Wunknown-pragmas -verify %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -E ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/pragma_unknown.c | ${LLVM_SRC}/build/bin/FileCheck --strict-whitespace ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/pragma_unknown.c
    RUN("%clang_cc1 -E %s")./*|*/
      I("FileCheck --strict-whitespace %s");
  }

  @Test
  public void test_predefined_arch_macros_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/predefined-arch-macros.c");
    // ${LLVM_SRC}/build/bin/clang -march=i386 -m32 -E -dM ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/predefined-arch-macros.c -o - 2>&1 -target i386-unknown-linux | ${LLVM_SRC}/build/bin/FileCheck -match-full-lines ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/predefined-arch-macros.c -check-prefix=CHECK_I386_M32
    RUN("%clang -march=i386 -m32 -E -dM %s -o - 2>&1 -target i386-unknown-linux")./*|*/
      I("FileCheck -match-full-lines %s -check-prefix=CHECK_I386_M32");
    // ${LLVM_SRC}/build/bin/clang -march=i386 -m64 -E -dM ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/predefined-arch-macros.c -o - 2>&1 -target i386-unknown-linux | ${LLVM_SRC}/build/bin/FileCheck -match-full-lines ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/predefined-arch-macros.c -check-prefix=CHECK_I386_M64
    RUN("not %clang -march=i386 -m64 -E -dM %s -o - 2>&1 -target i386-unknown-linux")./*|*/
      I("FileCheck -match-full-lines %s -check-prefix=CHECK_I386_M64");
    // ${LLVM_SRC}/build/bin/clang -march=i486 -m32 -E -dM ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/predefined-arch-macros.c -o - 2>&1 -target i386-unknown-linux | ${LLVM_SRC}/build/bin/FileCheck -match-full-lines ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/predefined-arch-macros.c -check-prefix=CHECK_I486_M32
    RUN("%clang -march=i486 -m32 -E -dM %s -o - 2>&1 -target i386-unknown-linux")./*|*/
      I("FileCheck -match-full-lines %s -check-prefix=CHECK_I486_M32");
    // ${LLVM_SRC}/build/bin/clang -march=i486 -m64 -E -dM ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/predefined-arch-macros.c -o - 2>&1 -target i386-unknown-linux | ${LLVM_SRC}/build/bin/FileCheck -match-full-lines ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/predefined-arch-macros.c -check-prefix=CHECK_I486_M64
    RUN("not %clang -march=i486 -m64 -E -dM %s -o - 2>&1 -target i386-unknown-linux")./*|*/
      I("FileCheck -match-full-lines %s -check-prefix=CHECK_I486_M64");
    // ${LLVM_SRC}/build/bin/clang -march=i586 -m32 -E -dM ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/predefined-arch-macros.c -o - 2>&1 -target i386-unknown-linux | ${LLVM_SRC}/build/bin/FileCheck -match-full-lines ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/predefined-arch-macros.c -check-prefix=CHECK_I586_M32
    RUN("%clang -march=i586 -m32 -E -dM %s -o - 2>&1 -target i386-unknown-linux")./*|*/
      I("FileCheck -match-full-lines %s -check-prefix=CHECK_I586_M32");
    // ${LLVM_SRC}/build/bin/clang -march=i586 -m64 -E -dM ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/predefined-arch-macros.c -o - 2>&1 -target i386-unknown-linux | ${LLVM_SRC}/build/bin/FileCheck -match-full-lines ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/predefined-arch-macros.c -check-prefix=CHECK_I586_M64
    RUN("not %clang -march=i586 -m64 -E -dM %s -o - 2>&1 -target i386-unknown-linux")./*|*/
      I("FileCheck -match-full-lines %s -check-prefix=CHECK_I586_M64");
    // ${LLVM_SRC}/build/bin/clang -march=pentium -m32 -E -dM ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/predefined-arch-macros.c -o - 2>&1 -target i386-unknown-linux | ${LLVM_SRC}/build/bin/FileCheck -match-full-lines ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/predefined-arch-macros.c -check-prefix=CHECK_PENTIUM_M32
    RUN("%clang -march=pentium -m32 -E -dM %s -o - 2>&1 -target i386-unknown-linux")./*|*/
      I("FileCheck -match-full-lines %s -check-prefix=CHECK_PENTIUM_M32");
    // ${LLVM_SRC}/build/bin/clang -march=pentium -m64 -E -dM ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/predefined-arch-macros.c -o - 2>&1 -target i386-unknown-linux | ${LLVM_SRC}/build/bin/FileCheck -match-full-lines ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/predefined-arch-macros.c -check-prefix=CHECK_PENTIUM_M64
    RUN("not %clang -march=pentium -m64 -E -dM %s -o - 2>&1 -target i386-unknown-linux")./*|*/
      I("FileCheck -match-full-lines %s -check-prefix=CHECK_PENTIUM_M64");
    // ${LLVM_SRC}/build/bin/clang -march=pentium-mmx -m32 -E -dM ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/predefined-arch-macros.c -o - 2>&1 -target i386-unknown-linux | ${LLVM_SRC}/build/bin/FileCheck -match-full-lines ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/predefined-arch-macros.c -check-prefix=CHECK_PENTIUM_MMX_M32
    RUN("%clang -march=pentium-mmx -m32 -E -dM %s -o - 2>&1 -target i386-unknown-linux")./*|*/
      I("FileCheck -match-full-lines %s -check-prefix=CHECK_PENTIUM_MMX_M32");
    // ${LLVM_SRC}/build/bin/clang -march=pentium-mmx -m64 -E -dM ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/predefined-arch-macros.c -o - 2>&1 -target i386-unknown-linux | ${LLVM_SRC}/build/bin/FileCheck -match-full-lines ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/predefined-arch-macros.c -check-prefix=CHECK_PENTIUM_MMX_M64
    RUN("not %clang -march=pentium-mmx -m64 -E -dM %s -o - 2>&1 -target i386-unknown-linux")./*|*/
      I("FileCheck -match-full-lines %s -check-prefix=CHECK_PENTIUM_MMX_M64");
    // ${LLVM_SRC}/build/bin/clang -march=winchip-c6 -m32 -E -dM ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/predefined-arch-macros.c -o - 2>&1 -target i386-unknown-linux | ${LLVM_SRC}/build/bin/FileCheck -match-full-lines ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/predefined-arch-macros.c -check-prefix=CHECK_WINCHIP_C6_M32
    RUN("%clang -march=winchip-c6 -m32 -E -dM %s -o - 2>&1 -target i386-unknown-linux")./*|*/
      I("FileCheck -match-full-lines %s -check-prefix=CHECK_WINCHIP_C6_M32");
    // ${LLVM_SRC}/build/bin/clang -march=winchip-c6 -m64 -E -dM ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/predefined-arch-macros.c -o - 2>&1 -target i386-unknown-linux | ${LLVM_SRC}/build/bin/FileCheck -match-full-lines ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/predefined-arch-macros.c -check-prefix=CHECK_WINCHIP_C6_M64
    RUN("not %clang -march=winchip-c6 -m64 -E -dM %s -o - 2>&1 -target i386-unknown-linux")./*|*/
      I("FileCheck -match-full-lines %s -check-prefix=CHECK_WINCHIP_C6_M64");
    // ${LLVM_SRC}/build/bin/clang -march=winchip2 -m32 -E -dM ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/predefined-arch-macros.c -o - 2>&1 -target i386-unknown-linux | ${LLVM_SRC}/build/bin/FileCheck -match-full-lines ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/predefined-arch-macros.c -check-prefix=CHECK_WINCHIP2_M32
    RUN("%clang -march=winchip2 -m32 -E -dM %s -o - 2>&1 -target i386-unknown-linux")./*|*/
      I("FileCheck -match-full-lines %s -check-prefix=CHECK_WINCHIP2_M32");
    // ${LLVM_SRC}/build/bin/clang -march=winchip2 -m64 -E -dM ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/predefined-arch-macros.c -o - 2>&1 -target i386-unknown-linux | ${LLVM_SRC}/build/bin/FileCheck -match-full-lines ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/predefined-arch-macros.c -check-prefix=CHECK_WINCHIP2_M64
    RUN("not %clang -march=winchip2 -m64 -E -dM %s -o - 2>&1 -target i386-unknown-linux")./*|*/
      I("FileCheck -match-full-lines %s -check-prefix=CHECK_WINCHIP2_M64");
    // ${LLVM_SRC}/build/bin/clang -march=c3 -m32 -E -dM ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/predefined-arch-macros.c -o - 2>&1 -target i386-unknown-linux | ${LLVM_SRC}/build/bin/FileCheck -match-full-lines ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/predefined-arch-macros.c -check-prefix=CHECK_C3_M32
    RUN("%clang -march=c3 -m32 -E -dM %s -o - 2>&1 -target i386-unknown-linux")./*|*/
      I("FileCheck -match-full-lines %s -check-prefix=CHECK_C3_M32");
    // ${LLVM_SRC}/build/bin/clang -march=c3 -m64 -E -dM ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/predefined-arch-macros.c -o - 2>&1 -target i386-unknown-linux | ${LLVM_SRC}/build/bin/FileCheck -match-full-lines ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/predefined-arch-macros.c -check-prefix=CHECK_C3_M64
    RUN("not %clang -march=c3 -m64 -E -dM %s -o - 2>&1 -target i386-unknown-linux")./*|*/
      I("FileCheck -match-full-lines %s -check-prefix=CHECK_C3_M64");
    // ${LLVM_SRC}/build/bin/clang -march=c3-2 -m32 -E -dM ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/predefined-arch-macros.c -o - 2>&1 -target i386-unknown-linux | ${LLVM_SRC}/build/bin/FileCheck -match-full-lines ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/predefined-arch-macros.c -check-prefix=CHECK_C3_2_M32
    RUN("%clang -march=c3-2 -m32 -E -dM %s -o - 2>&1 -target i386-unknown-linux")./*|*/
      I("FileCheck -match-full-lines %s -check-prefix=CHECK_C3_2_M32");
    // ${LLVM_SRC}/build/bin/clang -march=c3-2 -m64 -E -dM ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/predefined-arch-macros.c -o - 2>&1 -target i386-unknown-linux | ${LLVM_SRC}/build/bin/FileCheck -match-full-lines ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/predefined-arch-macros.c -check-prefix=CHECK_C3_2_M64
    RUN("not %clang -march=c3-2 -m64 -E -dM %s -o - 2>&1 -target i386-unknown-linux")./*|*/
      I("FileCheck -match-full-lines %s -check-prefix=CHECK_C3_2_M64");
    // ${LLVM_SRC}/build/bin/clang -march=i686 -m32 -E -dM ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/predefined-arch-macros.c -o - 2>&1 -target i386-unknown-linux | ${LLVM_SRC}/build/bin/FileCheck -match-full-lines ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/predefined-arch-macros.c -check-prefix=CHECK_I686_M32
    RUN("%clang -march=i686 -m32 -E -dM %s -o - 2>&1 -target i386-unknown-linux")./*|*/
      I("FileCheck -match-full-lines %s -check-prefix=CHECK_I686_M32");
    // ${LLVM_SRC}/build/bin/clang -march=i686 -m64 -E -dM ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/predefined-arch-macros.c -o - 2>&1 -target i386-unknown-linux | ${LLVM_SRC}/build/bin/FileCheck -match-full-lines ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/predefined-arch-macros.c -check-prefix=CHECK_I686_M64
    RUN("not %clang -march=i686 -m64 -E -dM %s -o - 2>&1 -target i386-unknown-linux")./*|*/
      I("FileCheck -match-full-lines %s -check-prefix=CHECK_I686_M64");
    // ${LLVM_SRC}/build/bin/clang -march=pentiumpro -m32 -E -dM ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/predefined-arch-macros.c -o - 2>&1 -target i386-unknown-linux | ${LLVM_SRC}/build/bin/FileCheck -match-full-lines ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/predefined-arch-macros.c -check-prefix=CHECK_PENTIUMPRO_M32
    RUN("%clang -march=pentiumpro -m32 -E -dM %s -o - 2>&1 -target i386-unknown-linux")./*|*/
      I("FileCheck -match-full-lines %s -check-prefix=CHECK_PENTIUMPRO_M32");
    // ${LLVM_SRC}/build/bin/clang -march=pentiumpro -m64 -E -dM ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/predefined-arch-macros.c -o - 2>&1 -target i386-unknown-linux | ${LLVM_SRC}/build/bin/FileCheck -match-full-lines ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/predefined-arch-macros.c -check-prefix=CHECK_PENTIUMPRO_M64
    RUN("not %clang -march=pentiumpro -m64 -E -dM %s -o - 2>&1 -target i386-unknown-linux")./*|*/
      I("FileCheck -match-full-lines %s -check-prefix=CHECK_PENTIUMPRO_M64");
    // ${LLVM_SRC}/build/bin/clang -march=pentium2 -m32 -E -dM ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/predefined-arch-macros.c -o - 2>&1 -target i386-unknown-linux | ${LLVM_SRC}/build/bin/FileCheck -match-full-lines ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/predefined-arch-macros.c -check-prefix=CHECK_PENTIUM2_M32
    RUN("%clang -march=pentium2 -m32 -E -dM %s -o - 2>&1 -target i386-unknown-linux")./*|*/
      I("FileCheck -match-full-lines %s -check-prefix=CHECK_PENTIUM2_M32");
    // ${LLVM_SRC}/build/bin/clang -march=pentium2 -m64 -E -dM ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/predefined-arch-macros.c -o - 2>&1 -target i386-unknown-linux | ${LLVM_SRC}/build/bin/FileCheck -match-full-lines ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/predefined-arch-macros.c -check-prefix=CHECK_PENTIUM2_M64
    RUN("not %clang -march=pentium2 -m64 -E -dM %s -o - 2>&1 -target i386-unknown-linux")./*|*/
      I("FileCheck -match-full-lines %s -check-prefix=CHECK_PENTIUM2_M64");
    // ${LLVM_SRC}/build/bin/clang -march=pentium3 -m32 -E -dM ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/predefined-arch-macros.c -o - 2>&1 -target i386-unknown-linux | ${LLVM_SRC}/build/bin/FileCheck -match-full-lines ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/predefined-arch-macros.c -check-prefix=CHECK_PENTIUM3_M32
    RUN("%clang -march=pentium3 -m32 -E -dM %s -o - 2>&1 -target i386-unknown-linux")./*|*/
      I("FileCheck -match-full-lines %s -check-prefix=CHECK_PENTIUM3_M32");
    // ${LLVM_SRC}/build/bin/clang -march=pentium3 -m64 -E -dM ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/predefined-arch-macros.c -o - 2>&1 -target i386-unknown-linux | ${LLVM_SRC}/build/bin/FileCheck -match-full-lines ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/predefined-arch-macros.c -check-prefix=CHECK_PENTIUM3_M64
    RUN("not %clang -march=pentium3 -m64 -E -dM %s -o - 2>&1 -target i386-unknown-linux")./*|*/
      I("FileCheck -match-full-lines %s -check-prefix=CHECK_PENTIUM3_M64");
    // ${LLVM_SRC}/build/bin/clang -march=pentium3m -m32 -E -dM ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/predefined-arch-macros.c -o - 2>&1 -target i386-unknown-linux | ${LLVM_SRC}/build/bin/FileCheck -match-full-lines ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/predefined-arch-macros.c -check-prefix=CHECK_PENTIUM3M_M32
    RUN("%clang -march=pentium3m -m32 -E -dM %s -o - 2>&1 -target i386-unknown-linux")./*|*/
      I("FileCheck -match-full-lines %s -check-prefix=CHECK_PENTIUM3M_M32");
    // ${LLVM_SRC}/build/bin/clang -march=pentium3m -m64 -E -dM ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/predefined-arch-macros.c -o - 2>&1 -target i386-unknown-linux | ${LLVM_SRC}/build/bin/FileCheck -match-full-lines ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/predefined-arch-macros.c -check-prefix=CHECK_PENTIUM3M_M64
    RUN("not %clang -march=pentium3m -m64 -E -dM %s -o - 2>&1 -target i386-unknown-linux")./*|*/
      I("FileCheck -match-full-lines %s -check-prefix=CHECK_PENTIUM3M_M64");
    // ${LLVM_SRC}/build/bin/clang -march=pentium-m -m32 -E -dM ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/predefined-arch-macros.c -o - 2>&1 -target i386-unknown-linux | ${LLVM_SRC}/build/bin/FileCheck -match-full-lines ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/predefined-arch-macros.c -check-prefix=CHECK_PENTIUM_M_M32
    RUN("%clang -march=pentium-m -m32 -E -dM %s -o - 2>&1 -target i386-unknown-linux")./*|*/
      I("FileCheck -match-full-lines %s -check-prefix=CHECK_PENTIUM_M_M32");
    // ${LLVM_SRC}/build/bin/clang -march=pentium-m -m64 -E -dM ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/predefined-arch-macros.c -o - 2>&1 -target i386-unknown-linux | ${LLVM_SRC}/build/bin/FileCheck -match-full-lines ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/predefined-arch-macros.c -check-prefix=CHECK_PENTIUM_M_M64
    RUN("not %clang -march=pentium-m -m64 -E -dM %s -o - 2>&1 -target i386-unknown-linux")./*|*/
      I("FileCheck -match-full-lines %s -check-prefix=CHECK_PENTIUM_M_M64");
    // ${LLVM_SRC}/build/bin/clang -march=pentium4 -m32 -E -dM ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/predefined-arch-macros.c -o - 2>&1 -target i386-unknown-linux | ${LLVM_SRC}/build/bin/FileCheck -match-full-lines ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/predefined-arch-macros.c -check-prefix=CHECK_PENTIUM4_M32
    RUN("%clang -march=pentium4 -m32 -E -dM %s -o - 2>&1 -target i386-unknown-linux")./*|*/
      I("FileCheck -match-full-lines %s -check-prefix=CHECK_PENTIUM4_M32");
    // ${LLVM_SRC}/build/bin/clang -march=pentium4 -m64 -E -dM ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/predefined-arch-macros.c -o - 2>&1 -target i386-unknown-linux | ${LLVM_SRC}/build/bin/FileCheck -match-full-lines ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/predefined-arch-macros.c -check-prefix=CHECK_PENTIUM4_M64
    RUN("not %clang -march=pentium4 -m64 -E -dM %s -o - 2>&1 -target i386-unknown-linux")./*|*/
      I("FileCheck -match-full-lines %s -check-prefix=CHECK_PENTIUM4_M64");
    // ${LLVM_SRC}/build/bin/clang -march=pentium4m -m32 -E -dM ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/predefined-arch-macros.c -o - 2>&1 -target i386-unknown-linux | ${LLVM_SRC}/build/bin/FileCheck -match-full-lines ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/predefined-arch-macros.c -check-prefix=CHECK_PENTIUM4M_M32
    RUN("%clang -march=pentium4m -m32 -E -dM %s -o - 2>&1 -target i386-unknown-linux")./*|*/
      I("FileCheck -match-full-lines %s -check-prefix=CHECK_PENTIUM4M_M32");
    // ${LLVM_SRC}/build/bin/clang -march=pentium4m -m64 -E -dM ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/predefined-arch-macros.c -o - 2>&1 -target i386-unknown-linux | ${LLVM_SRC}/build/bin/FileCheck -match-full-lines ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/predefined-arch-macros.c -check-prefix=CHECK_PENTIUM4M_M64
    RUN("not %clang -march=pentium4m -m64 -E -dM %s -o - 2>&1 -target i386-unknown-linux")./*|*/
      I("FileCheck -match-full-lines %s -check-prefix=CHECK_PENTIUM4M_M64");
    // ${LLVM_SRC}/build/bin/clang -march=prescott -m32 -E -dM ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/predefined-arch-macros.c -o - 2>&1 -target i386-unknown-linux | ${LLVM_SRC}/build/bin/FileCheck -match-full-lines ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/predefined-arch-macros.c -check-prefix=CHECK_PRESCOTT_M32
    RUN("%clang -march=prescott -m32 -E -dM %s -o - 2>&1 -target i386-unknown-linux")./*|*/
      I("FileCheck -match-full-lines %s -check-prefix=CHECK_PRESCOTT_M32");
    // ${LLVM_SRC}/build/bin/clang -march=prescott -m64 -E -dM ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/predefined-arch-macros.c -o - 2>&1 -target i386-unknown-linux | ${LLVM_SRC}/build/bin/FileCheck -match-full-lines ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/predefined-arch-macros.c -check-prefix=CHECK_PRESCOTT_M64
    RUN("not %clang -march=prescott -m64 -E -dM %s -o - 2>&1 -target i386-unknown-linux")./*|*/
      I("FileCheck -match-full-lines %s -check-prefix=CHECK_PRESCOTT_M64");
    // ${LLVM_SRC}/build/bin/clang -march=nocona -m32 -E -dM ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/predefined-arch-macros.c -o - 2>&1 -target i386-unknown-linux | ${LLVM_SRC}/build/bin/FileCheck -match-full-lines ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/predefined-arch-macros.c -check-prefix=CHECK_NOCONA_M32
    RUN("%clang -march=nocona -m32 -E -dM %s -o - 2>&1 -target i386-unknown-linux")./*|*/
      I("FileCheck -match-full-lines %s -check-prefix=CHECK_NOCONA_M32");
    // ${LLVM_SRC}/build/bin/clang -march=nocona -m64 -E -dM ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/predefined-arch-macros.c -o - 2>&1 -target i386-unknown-linux | ${LLVM_SRC}/build/bin/FileCheck -match-full-lines ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/predefined-arch-macros.c -check-prefix=CHECK_NOCONA_M64
    RUN("%clang -march=nocona -m64 -E -dM %s -o - 2>&1 -target i386-unknown-linux")./*|*/
      I("FileCheck -match-full-lines %s -check-prefix=CHECK_NOCONA_M64");
    // ${LLVM_SRC}/build/bin/clang -march=core2 -m32 -E -dM ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/predefined-arch-macros.c -o - 2>&1 -target i386-unknown-linux | ${LLVM_SRC}/build/bin/FileCheck -match-full-lines ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/predefined-arch-macros.c -check-prefix=CHECK_CORE2_M32
    RUN("%clang -march=core2 -m32 -E -dM %s -o - 2>&1 -target i386-unknown-linux")./*|*/
      I("FileCheck -match-full-lines %s -check-prefix=CHECK_CORE2_M32");
    // ${LLVM_SRC}/build/bin/clang -march=core2 -m64 -E -dM ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/predefined-arch-macros.c -o - 2>&1 -target i386-unknown-linux | ${LLVM_SRC}/build/bin/FileCheck -match-full-lines ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/predefined-arch-macros.c -check-prefix=CHECK_CORE2_M64
    RUN("%clang -march=core2 -m64 -E -dM %s -o - 2>&1 -target i386-unknown-linux")./*|*/
      I("FileCheck -match-full-lines %s -check-prefix=CHECK_CORE2_M64");
    // ${LLVM_SRC}/build/bin/clang -march=corei7 -m32 -E -dM ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/predefined-arch-macros.c -o - 2>&1 -target i386-unknown-linux | ${LLVM_SRC}/build/bin/FileCheck -match-full-lines ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/predefined-arch-macros.c -check-prefix=CHECK_COREI7_M32
    RUN("%clang -march=corei7 -m32 -E -dM %s -o - 2>&1 -target i386-unknown-linux")./*|*/
      I("FileCheck -match-full-lines %s -check-prefix=CHECK_COREI7_M32");
    // ${LLVM_SRC}/build/bin/clang -march=corei7 -m64 -E -dM ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/predefined-arch-macros.c -o - 2>&1 -target i386-unknown-linux | ${LLVM_SRC}/build/bin/FileCheck -match-full-lines ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/predefined-arch-macros.c -check-prefix=CHECK_COREI7_M64
    RUN("%clang -march=corei7 -m64 -E -dM %s -o - 2>&1 -target i386-unknown-linux")./*|*/
      I("FileCheck -match-full-lines %s -check-prefix=CHECK_COREI7_M64");
    // ${LLVM_SRC}/build/bin/clang -march=corei7-avx -m32 -E -dM ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/predefined-arch-macros.c -o - 2>&1 -target i386-unknown-linux | ${LLVM_SRC}/build/bin/FileCheck -match-full-lines ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/predefined-arch-macros.c -check-prefix=CHECK_COREI7_AVX_M32
    RUN("%clang -march=corei7-avx -m32 -E -dM %s -o - 2>&1 -target i386-unknown-linux")./*|*/
      I("FileCheck -match-full-lines %s -check-prefix=CHECK_COREI7_AVX_M32");
    // ${LLVM_SRC}/build/bin/clang -march=corei7-avx -m64 -E -dM ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/predefined-arch-macros.c -o - 2>&1 -target i386-unknown-linux | ${LLVM_SRC}/build/bin/FileCheck -match-full-lines ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/predefined-arch-macros.c -check-prefix=CHECK_COREI7_AVX_M64
    RUN("%clang -march=corei7-avx -m64 -E -dM %s -o - 2>&1 -target i386-unknown-linux")./*|*/
      I("FileCheck -match-full-lines %s -check-prefix=CHECK_COREI7_AVX_M64");
    // ${LLVM_SRC}/build/bin/clang -march=core-avx-i -m32 -E -dM ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/predefined-arch-macros.c -o - 2>&1 -target i386-unknown-linux | ${LLVM_SRC}/build/bin/FileCheck -match-full-lines ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/predefined-arch-macros.c -check-prefix=CHECK_CORE_AVX_I_M32
    RUN("%clang -march=core-avx-i -m32 -E -dM %s -o - 2>&1 -target i386-unknown-linux")./*|*/
      I("FileCheck -match-full-lines %s -check-prefix=CHECK_CORE_AVX_I_M32");
    // ${LLVM_SRC}/build/bin/clang -march=core-avx-i -m64 -E -dM ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/predefined-arch-macros.c -o - 2>&1 -target i386-unknown-linux | ${LLVM_SRC}/build/bin/FileCheck -match-full-lines ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/predefined-arch-macros.c -check-prefix=CHECK_CORE_AVX_I_M64
    RUN("%clang -march=core-avx-i -m64 -E -dM %s -o - 2>&1 -target i386-unknown-linux")./*|*/
      I("FileCheck -match-full-lines %s -check-prefix=CHECK_CORE_AVX_I_M64");
    // ${LLVM_SRC}/build/bin/clang -march=core-avx2 -m32 -E -dM ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/predefined-arch-macros.c -o - 2>&1 -target i386-unknown-linux | ${LLVM_SRC}/build/bin/FileCheck -match-full-lines ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/predefined-arch-macros.c -check-prefix=CHECK_CORE_AVX2_M32
    RUN("%clang -march=core-avx2 -m32 -E -dM %s -o - 2>&1 -target i386-unknown-linux")./*|*/
      I("FileCheck -match-full-lines %s -check-prefix=CHECK_CORE_AVX2_M32");
    // ${LLVM_SRC}/build/bin/clang -march=core-avx2 -m64 -E -dM ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/predefined-arch-macros.c -o - 2>&1 -target i386-unknown-linux | ${LLVM_SRC}/build/bin/FileCheck -match-full-lines ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/predefined-arch-macros.c -check-prefix=CHECK_CORE_AVX2_M64
    RUN("%clang -march=core-avx2 -m64 -E -dM %s -o - 2>&1 -target i386-unknown-linux")./*|*/
      I("FileCheck -match-full-lines %s -check-prefix=CHECK_CORE_AVX2_M64");
    // ${LLVM_SRC}/build/bin/clang -march=broadwell -m32 -E -dM ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/predefined-arch-macros.c -o - 2>&1 -target i386-unknown-linux | ${LLVM_SRC}/build/bin/FileCheck -match-full-lines ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/predefined-arch-macros.c -check-prefix=CHECK_BROADWELL_M32
    RUN("%clang -march=broadwell -m32 -E -dM %s -o - 2>&1 -target i386-unknown-linux")./*|*/
      I("FileCheck -match-full-lines %s -check-prefix=CHECK_BROADWELL_M32");
    // ${LLVM_SRC}/build/bin/clang -march=broadwell -m64 -E -dM ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/predefined-arch-macros.c -o - 2>&1 -target i386-unknown-linux | ${LLVM_SRC}/build/bin/FileCheck -match-full-lines ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/predefined-arch-macros.c -check-prefix=CHECK_BROADWELL_M64
    RUN("%clang -march=broadwell -m64 -E -dM %s -o - 2>&1 -target i386-unknown-linux")./*|*/
      I("FileCheck -match-full-lines %s -check-prefix=CHECK_BROADWELL_M64");
    // ${LLVM_SRC}/build/bin/clang -march=skylake -m32 -E -dM ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/predefined-arch-macros.c -o - 2>&1 -target i386-unknown-linux | ${LLVM_SRC}/build/bin/FileCheck -match-full-lines ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/predefined-arch-macros.c -check-prefix=CHECK_SKL_M32
    RUN("%clang -march=skylake -m32 -E -dM %s -o - 2>&1 -target i386-unknown-linux")./*|*/
      I("FileCheck -match-full-lines %s -check-prefix=CHECK_SKL_M32");
    // ${LLVM_SRC}/build/bin/clang -march=skylake -m64 -E -dM ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/predefined-arch-macros.c -o - 2>&1 -target i386-unknown-linux | ${LLVM_SRC}/build/bin/FileCheck -match-full-lines ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/predefined-arch-macros.c -check-prefix=CHECK_SKL_M64
    RUN("%clang -march=skylake -m64 -E -dM %s -o - 2>&1 -target i386-unknown-linux")./*|*/
      I("FileCheck -match-full-lines %s -check-prefix=CHECK_SKL_M64");
    // ${LLVM_SRC}/build/bin/clang -march=knl -m32 -E -dM ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/predefined-arch-macros.c -o - 2>&1 -target i386-unknown-linux | ${LLVM_SRC}/build/bin/FileCheck -match-full-lines ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/predefined-arch-macros.c -check-prefix=CHECK_KNL_M32
    RUN("%clang -march=knl -m32 -E -dM %s -o - 2>&1 -target i386-unknown-linux")./*|*/
      I("FileCheck -match-full-lines %s -check-prefix=CHECK_KNL_M32");
    // ${LLVM_SRC}/build/bin/clang -march=knl -m64 -E -dM ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/predefined-arch-macros.c -o - 2>&1 -target i386-unknown-linux | ${LLVM_SRC}/build/bin/FileCheck -match-full-lines ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/predefined-arch-macros.c -check-prefix=CHECK_KNL_M64
    RUN("%clang -march=knl -m64 -E -dM %s -o - 2>&1 -target i386-unknown-linux")./*|*/
      I("FileCheck -match-full-lines %s -check-prefix=CHECK_KNL_M64");
    // ${LLVM_SRC}/build/bin/clang -march=skylake-avx512 -m32 -E -dM ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/predefined-arch-macros.c -o - 2>&1 -target i386-unknown-linux | ${LLVM_SRC}/build/bin/FileCheck -match-full-lines ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/predefined-arch-macros.c -check-prefix=CHECK_SKX_M32
    RUN("%clang -march=skylake-avx512 -m32 -E -dM %s -o - 2>&1 -target i386-unknown-linux")./*|*/
      I("FileCheck -match-full-lines %s -check-prefix=CHECK_SKX_M32");
    // ${LLVM_SRC}/build/bin/clang -march=skylake-avx512 -m64 -E -dM ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/predefined-arch-macros.c -o - 2>&1 -target i386-unknown-linux | ${LLVM_SRC}/build/bin/FileCheck -match-full-lines ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/predefined-arch-macros.c -check-prefix=CHECK_SKX_M64
    RUN("%clang -march=skylake-avx512 -m64 -E -dM %s -o - 2>&1 -target i386-unknown-linux")./*|*/
      I("FileCheck -match-full-lines %s -check-prefix=CHECK_SKX_M64");
    // ${LLVM_SRC}/build/bin/clang -march=cannonlake -m32 -E -dM ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/predefined-arch-macros.c -o - 2>&1 -target i386-unknown-linux | ${LLVM_SRC}/build/bin/FileCheck -match-full-lines ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/predefined-arch-macros.c -check-prefix=CHECK_CNL_M32
    RUN("%clang -march=cannonlake -m32 -E -dM %s -o - 2>&1 -target i386-unknown-linux")./*|*/
      I("FileCheck -match-full-lines %s -check-prefix=CHECK_CNL_M32");
    // ${LLVM_SRC}/build/bin/clang -march=cannonlake -m64 -E -dM ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/predefined-arch-macros.c -o - 2>&1 -target i386-unknown-linux | ${LLVM_SRC}/build/bin/FileCheck -match-full-lines ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/predefined-arch-macros.c -check-prefix=CHECK_CNL_M64
    RUN("%clang -march=cannonlake -m64 -E -dM %s -o - 2>&1 -target i386-unknown-linux")./*|*/
      I("FileCheck -match-full-lines %s -check-prefix=CHECK_CNL_M64");
    // ${LLVM_SRC}/build/bin/clang -march=atom -m32 -E -dM ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/predefined-arch-macros.c -o - 2>&1 -target i386-unknown-linux | ${LLVM_SRC}/build/bin/FileCheck -match-full-lines ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/predefined-arch-macros.c -check-prefix=CHECK_ATOM_M32
    RUN("%clang -march=atom -m32 -E -dM %s -o - 2>&1 -target i386-unknown-linux")./*|*/
      I("FileCheck -match-full-lines %s -check-prefix=CHECK_ATOM_M32");
    // ${LLVM_SRC}/build/bin/clang -march=atom -m64 -E -dM ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/predefined-arch-macros.c -o - 2>&1 -target i386-unknown-linux | ${LLVM_SRC}/build/bin/FileCheck -match-full-lines ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/predefined-arch-macros.c -check-prefix=CHECK_ATOM_M64
    RUN("%clang -march=atom -m64 -E -dM %s -o - 2>&1 -target i386-unknown-linux")./*|*/
      I("FileCheck -match-full-lines %s -check-prefix=CHECK_ATOM_M64");
    // ${LLVM_SRC}/build/bin/clang -march=slm -m32 -E -dM ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/predefined-arch-macros.c -o - 2>&1 -target i386-unknown-linux | ${LLVM_SRC}/build/bin/FileCheck -match-full-lines ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/predefined-arch-macros.c -check-prefix=CHECK_SLM_M32
    RUN("%clang -march=slm -m32 -E -dM %s -o - 2>&1 -target i386-unknown-linux")./*|*/
      I("FileCheck -match-full-lines %s -check-prefix=CHECK_SLM_M32");
    // ${LLVM_SRC}/build/bin/clang -march=slm -m64 -E -dM ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/predefined-arch-macros.c -o - 2>&1 -target i386-unknown-linux | ${LLVM_SRC}/build/bin/FileCheck -match-full-lines ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/predefined-arch-macros.c -check-prefix=CHECK_SLM_M64
    RUN("%clang -march=slm -m64 -E -dM %s -o - 2>&1 -target i386-unknown-linux")./*|*/
      I("FileCheck -match-full-lines %s -check-prefix=CHECK_SLM_M64");
    // ${LLVM_SRC}/build/bin/clang -march=lakemont -m32 -E -dM ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/predefined-arch-macros.c -o - 2>&1 -target i386-unknown-linux | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/predefined-arch-macros.c -check-prefix=CHECK_LMT_M32
    RUN("%clang -march=lakemont -m32 -E -dM %s -o - 2>&1 -target i386-unknown-linux")./*|*/
      I("FileCheck %s -check-prefix=CHECK_LMT_M32");
    // ${LLVM_SRC}/build/bin/clang -march=lakemont -m64 -E -dM ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/predefined-arch-macros.c -o - 2>&1 -target i386-unknown-linux | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/predefined-arch-macros.c -check-prefix=CHECK_LMT_M64
    RUN("not %clang -march=lakemont -m64 -E -dM %s -o - 2>&1 -target i386-unknown-linux")./*|*/
      I("FileCheck %s -check-prefix=CHECK_LMT_M64");
    // ${LLVM_SRC}/build/bin/clang -march=geode -m32 -E -dM ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/predefined-arch-macros.c -o - 2>&1 -target i386-unknown-linux | ${LLVM_SRC}/build/bin/FileCheck -match-full-lines ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/predefined-arch-macros.c -check-prefix=CHECK_GEODE_M32
    RUN("%clang -march=geode -m32 -E -dM %s -o - 2>&1 -target i386-unknown-linux")./*|*/
      I("FileCheck -match-full-lines %s -check-prefix=CHECK_GEODE_M32");
    // ${LLVM_SRC}/build/bin/clang -march=geode -m64 -E -dM ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/predefined-arch-macros.c -o - 2>&1 -target i386-unknown-linux | ${LLVM_SRC}/build/bin/FileCheck -match-full-lines ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/predefined-arch-macros.c -check-prefix=CHECK_GEODE_M64
    RUN("not %clang -march=geode -m64 -E -dM %s -o - 2>&1 -target i386-unknown-linux")./*|*/
      I("FileCheck -match-full-lines %s -check-prefix=CHECK_GEODE_M64");
    // ${LLVM_SRC}/build/bin/clang -march=k6 -m32 -E -dM ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/predefined-arch-macros.c -o - 2>&1 -target i386-unknown-linux | ${LLVM_SRC}/build/bin/FileCheck -match-full-lines ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/predefined-arch-macros.c -check-prefix=CHECK_K6_M32
    RUN("%clang -march=k6 -m32 -E -dM %s -o - 2>&1 -target i386-unknown-linux")./*|*/
      I("FileCheck -match-full-lines %s -check-prefix=CHECK_K6_M32");
    // ${LLVM_SRC}/build/bin/clang -march=k6 -m64 -E -dM ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/predefined-arch-macros.c -o - 2>&1 -target i386-unknown-linux | ${LLVM_SRC}/build/bin/FileCheck -match-full-lines ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/predefined-arch-macros.c -check-prefix=CHECK_K6_M64
    RUN("not %clang -march=k6 -m64 -E -dM %s -o - 2>&1 -target i386-unknown-linux")./*|*/
      I("FileCheck -match-full-lines %s -check-prefix=CHECK_K6_M64");
    // ${LLVM_SRC}/build/bin/clang -march=k6-2 -m32 -E -dM ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/predefined-arch-macros.c -o - 2>&1 -target i386-unknown-linux | ${LLVM_SRC}/build/bin/FileCheck -match-full-lines ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/predefined-arch-macros.c -check-prefix=CHECK_K6_2_M32
    RUN("%clang -march=k6-2 -m32 -E -dM %s -o - 2>&1 -target i386-unknown-linux")./*|*/
      I("FileCheck -match-full-lines %s -check-prefix=CHECK_K6_2_M32");
    // ${LLVM_SRC}/build/bin/clang -march=k6-2 -m64 -E -dM ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/predefined-arch-macros.c -o - 2>&1 -target i386-unknown-linux | ${LLVM_SRC}/build/bin/FileCheck -match-full-lines ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/predefined-arch-macros.c -check-prefix=CHECK_K6_2_M64
    RUN("not %clang -march=k6-2 -m64 -E -dM %s -o - 2>&1 -target i386-unknown-linux")./*|*/
      I("FileCheck -match-full-lines %s -check-prefix=CHECK_K6_2_M64");
    // ${LLVM_SRC}/build/bin/clang -march=k6-3 -m32 -E -dM ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/predefined-arch-macros.c -o - 2>&1 -target i386-unknown-linux | ${LLVM_SRC}/build/bin/FileCheck -match-full-lines ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/predefined-arch-macros.c -check-prefix=CHECK_K6_3_M32
    RUN("%clang -march=k6-3 -m32 -E -dM %s -o - 2>&1 -target i386-unknown-linux")./*|*/
      I("FileCheck -match-full-lines %s -check-prefix=CHECK_K6_3_M32");
    // ${LLVM_SRC}/build/bin/clang -march=k6-3 -m64 -E -dM ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/predefined-arch-macros.c -o - 2>&1 -target i386-unknown-linux | ${LLVM_SRC}/build/bin/FileCheck -match-full-lines ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/predefined-arch-macros.c -check-prefix=CHECK_K6_3_M64
    RUN("not %clang -march=k6-3 -m64 -E -dM %s -o - 2>&1 -target i386-unknown-linux")./*|*/
      I("FileCheck -match-full-lines %s -check-prefix=CHECK_K6_3_M64");
    // ${LLVM_SRC}/build/bin/clang -march=athlon -m32 -E -dM ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/predefined-arch-macros.c -o - 2>&1 -target i386-unknown-linux | ${LLVM_SRC}/build/bin/FileCheck -match-full-lines ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/predefined-arch-macros.c -check-prefix=CHECK_ATHLON_M32
    RUN("%clang -march=athlon -m32 -E -dM %s -o - 2>&1 -target i386-unknown-linux")./*|*/
      I("FileCheck -match-full-lines %s -check-prefix=CHECK_ATHLON_M32");
    // ${LLVM_SRC}/build/bin/clang -march=athlon -m64 -E -dM ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/predefined-arch-macros.c -o - 2>&1 -target i386-unknown-linux | ${LLVM_SRC}/build/bin/FileCheck -match-full-lines ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/predefined-arch-macros.c -check-prefix=CHECK_ATHLON_M64
    RUN("not %clang -march=athlon -m64 -E -dM %s -o - 2>&1 -target i386-unknown-linux")./*|*/
      I("FileCheck -match-full-lines %s -check-prefix=CHECK_ATHLON_M64");
    // ${LLVM_SRC}/build/bin/clang -march=athlon-tbird -m32 -E -dM ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/predefined-arch-macros.c -o - 2>&1 -target i386-unknown-linux | ${LLVM_SRC}/build/bin/FileCheck -match-full-lines ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/predefined-arch-macros.c -check-prefix=CHECK_ATHLON_TBIRD_M32
    RUN("%clang -march=athlon-tbird -m32 -E -dM %s -o - 2>&1 -target i386-unknown-linux")./*|*/
      I("FileCheck -match-full-lines %s -check-prefix=CHECK_ATHLON_TBIRD_M32");
    // ${LLVM_SRC}/build/bin/clang -march=athlon-tbird -m64 -E -dM ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/predefined-arch-macros.c -o - 2>&1 -target i386-unknown-linux | ${LLVM_SRC}/build/bin/FileCheck -match-full-lines ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/predefined-arch-macros.c -check-prefix=CHECK_ATHLON_TBIRD_M64
    RUN("not %clang -march=athlon-tbird -m64 -E -dM %s -o - 2>&1 -target i386-unknown-linux")./*|*/
      I("FileCheck -match-full-lines %s -check-prefix=CHECK_ATHLON_TBIRD_M64");
    // ${LLVM_SRC}/build/bin/clang -march=athlon-4 -m32 -E -dM ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/predefined-arch-macros.c -o - 2>&1 -target i386-unknown-linux | ${LLVM_SRC}/build/bin/FileCheck -match-full-lines ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/predefined-arch-macros.c -check-prefix=CHECK_ATHLON_4_M32
    RUN("%clang -march=athlon-4 -m32 -E -dM %s -o - 2>&1 -target i386-unknown-linux")./*|*/
      I("FileCheck -match-full-lines %s -check-prefix=CHECK_ATHLON_4_M32");
    // ${LLVM_SRC}/build/bin/clang -march=athlon-4 -m64 -E -dM ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/predefined-arch-macros.c -o - 2>&1 -target i386-unknown-linux | ${LLVM_SRC}/build/bin/FileCheck -match-full-lines ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/predefined-arch-macros.c -check-prefix=CHECK_ATHLON_4_M64
    RUN("not %clang -march=athlon-4 -m64 -E -dM %s -o - 2>&1 -target i386-unknown-linux")./*|*/
      I("FileCheck -match-full-lines %s -check-prefix=CHECK_ATHLON_4_M64");
    // ${LLVM_SRC}/build/bin/clang -march=athlon-xp -m32 -E -dM ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/predefined-arch-macros.c -o - 2>&1 -target i386-unknown-linux | ${LLVM_SRC}/build/bin/FileCheck -match-full-lines ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/predefined-arch-macros.c -check-prefix=CHECK_ATHLON_XP_M32
    RUN("%clang -march=athlon-xp -m32 -E -dM %s -o - 2>&1 -target i386-unknown-linux")./*|*/
      I("FileCheck -match-full-lines %s -check-prefix=CHECK_ATHLON_XP_M32");
    // ${LLVM_SRC}/build/bin/clang -march=athlon-xp -m64 -E -dM ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/predefined-arch-macros.c -o - 2>&1 -target i386-unknown-linux | ${LLVM_SRC}/build/bin/FileCheck -match-full-lines ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/predefined-arch-macros.c -check-prefix=CHECK_ATHLON_XP_M64
    RUN("not %clang -march=athlon-xp -m64 -E -dM %s -o - 2>&1 -target i386-unknown-linux")./*|*/
      I("FileCheck -match-full-lines %s -check-prefix=CHECK_ATHLON_XP_M64");
    // ${LLVM_SRC}/build/bin/clang -march=athlon-mp -m32 -E -dM ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/predefined-arch-macros.c -o - 2>&1 -target i386-unknown-linux | ${LLVM_SRC}/build/bin/FileCheck -match-full-lines ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/predefined-arch-macros.c -check-prefix=CHECK_ATHLON_MP_M32
    RUN("%clang -march=athlon-mp -m32 -E -dM %s -o - 2>&1 -target i386-unknown-linux")./*|*/
      I("FileCheck -match-full-lines %s -check-prefix=CHECK_ATHLON_MP_M32");
    // ${LLVM_SRC}/build/bin/clang -march=athlon-mp -m64 -E -dM ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/predefined-arch-macros.c -o - 2>&1 -target i386-unknown-linux | ${LLVM_SRC}/build/bin/FileCheck -match-full-lines ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/predefined-arch-macros.c -check-prefix=CHECK_ATHLON_MP_M64
    RUN("not %clang -march=athlon-mp -m64 -E -dM %s -o - 2>&1 -target i386-unknown-linux")./*|*/
      I("FileCheck -match-full-lines %s -check-prefix=CHECK_ATHLON_MP_M64");
    // ${LLVM_SRC}/build/bin/clang -march=x86-64 -m32 -E -dM ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/predefined-arch-macros.c -o - 2>&1 -target i386-unknown-linux | ${LLVM_SRC}/build/bin/FileCheck -match-full-lines ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/predefined-arch-macros.c -check-prefix=CHECK_X86_64_M32
    RUN("%clang -march=x86-64 -m32 -E -dM %s -o - 2>&1 -target i386-unknown-linux")./*|*/
      I("FileCheck -match-full-lines %s -check-prefix=CHECK_X86_64_M32");
    // ${LLVM_SRC}/build/bin/clang -march=x86-64 -m64 -E -dM ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/predefined-arch-macros.c -o - 2>&1 -target i386-unknown-linux | ${LLVM_SRC}/build/bin/FileCheck -match-full-lines ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/predefined-arch-macros.c -check-prefix=CHECK_X86_64_M64
    RUN("%clang -march=x86-64 -m64 -E -dM %s -o - 2>&1 -target i386-unknown-linux")./*|*/
      I("FileCheck -match-full-lines %s -check-prefix=CHECK_X86_64_M64");
    // ${LLVM_SRC}/build/bin/clang -march=k8 -m32 -E -dM ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/predefined-arch-macros.c -o - 2>&1 -target i386-unknown-linux | ${LLVM_SRC}/build/bin/FileCheck -match-full-lines ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/predefined-arch-macros.c -check-prefix=CHECK_K8_M32
    RUN("%clang -march=k8 -m32 -E -dM %s -o - 2>&1 -target i386-unknown-linux")./*|*/
      I("FileCheck -match-full-lines %s -check-prefix=CHECK_K8_M32");
    // ${LLVM_SRC}/build/bin/clang -march=k8 -m64 -E -dM ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/predefined-arch-macros.c -o - 2>&1 -target i386-unknown-linux | ${LLVM_SRC}/build/bin/FileCheck -match-full-lines ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/predefined-arch-macros.c -check-prefix=CHECK_K8_M64
    RUN("%clang -march=k8 -m64 -E -dM %s -o - 2>&1 -target i386-unknown-linux")./*|*/
      I("FileCheck -match-full-lines %s -check-prefix=CHECK_K8_M64");
    // ${LLVM_SRC}/build/bin/clang -march=k8-sse3 -m32 -E -dM ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/predefined-arch-macros.c -o - 2>&1 -target i386-unknown-linux | ${LLVM_SRC}/build/bin/FileCheck -match-full-lines ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/predefined-arch-macros.c -check-prefix=CHECK_K8_SSE3_M32
    RUN("%clang -march=k8-sse3 -m32 -E -dM %s -o - 2>&1 -target i386-unknown-linux")./*|*/
      I("FileCheck -match-full-lines %s -check-prefix=CHECK_K8_SSE3_M32");
    // ${LLVM_SRC}/build/bin/clang -march=k8-sse3 -m64 -E -dM ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/predefined-arch-macros.c -o - 2>&1 -target i386-unknown-linux | ${LLVM_SRC}/build/bin/FileCheck -match-full-lines ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/predefined-arch-macros.c -check-prefix=CHECK_K8_SSE3_M64
    RUN("%clang -march=k8-sse3 -m64 -E -dM %s -o - 2>&1 -target i386-unknown-linux")./*|*/
      I("FileCheck -match-full-lines %s -check-prefix=CHECK_K8_SSE3_M64");
    // ${LLVM_SRC}/build/bin/clang -march=opteron -m32 -E -dM ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/predefined-arch-macros.c -o - 2>&1 -target i386-unknown-linux | ${LLVM_SRC}/build/bin/FileCheck -match-full-lines ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/predefined-arch-macros.c -check-prefix=CHECK_OPTERON_M32
    RUN("%clang -march=opteron -m32 -E -dM %s -o - 2>&1 -target i386-unknown-linux")./*|*/
      I("FileCheck -match-full-lines %s -check-prefix=CHECK_OPTERON_M32");
    // ${LLVM_SRC}/build/bin/clang -march=opteron -m64 -E -dM ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/predefined-arch-macros.c -o - 2>&1 -target i386-unknown-linux | ${LLVM_SRC}/build/bin/FileCheck -match-full-lines ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/predefined-arch-macros.c -check-prefix=CHECK_OPTERON_M64
    RUN("%clang -march=opteron -m64 -E -dM %s -o - 2>&1 -target i386-unknown-linux")./*|*/
      I("FileCheck -match-full-lines %s -check-prefix=CHECK_OPTERON_M64");
    // ${LLVM_SRC}/build/bin/clang -march=opteron-sse3 -m32 -E -dM ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/predefined-arch-macros.c -o - 2>&1 -target i386-unknown-linux | ${LLVM_SRC}/build/bin/FileCheck -match-full-lines ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/predefined-arch-macros.c -check-prefix=CHECK_OPTERON_SSE3_M32
    RUN("%clang -march=opteron-sse3 -m32 -E -dM %s -o - 2>&1 -target i386-unknown-linux")./*|*/
      I("FileCheck -match-full-lines %s -check-prefix=CHECK_OPTERON_SSE3_M32");
    // ${LLVM_SRC}/build/bin/clang -march=opteron-sse3 -m64 -E -dM ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/predefined-arch-macros.c -o - 2>&1 -target i386-unknown-linux | ${LLVM_SRC}/build/bin/FileCheck -match-full-lines ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/predefined-arch-macros.c -check-prefix=CHECK_OPTERON_SSE3_M64
    RUN("%clang -march=opteron-sse3 -m64 -E -dM %s -o - 2>&1 -target i386-unknown-linux")./*|*/
      I("FileCheck -match-full-lines %s -check-prefix=CHECK_OPTERON_SSE3_M64");
    // ${LLVM_SRC}/build/bin/clang -march=athlon64 -m32 -E -dM ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/predefined-arch-macros.c -o - 2>&1 -target i386-unknown-linux | ${LLVM_SRC}/build/bin/FileCheck -match-full-lines ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/predefined-arch-macros.c -check-prefix=CHECK_ATHLON64_M32
    RUN("%clang -march=athlon64 -m32 -E -dM %s -o - 2>&1 -target i386-unknown-linux")./*|*/
      I("FileCheck -match-full-lines %s -check-prefix=CHECK_ATHLON64_M32");
    // ${LLVM_SRC}/build/bin/clang -march=athlon64 -m64 -E -dM ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/predefined-arch-macros.c -o - 2>&1 -target i386-unknown-linux | ${LLVM_SRC}/build/bin/FileCheck -match-full-lines ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/predefined-arch-macros.c -check-prefix=CHECK_ATHLON64_M64
    RUN("%clang -march=athlon64 -m64 -E -dM %s -o - 2>&1 -target i386-unknown-linux")./*|*/
      I("FileCheck -match-full-lines %s -check-prefix=CHECK_ATHLON64_M64");
    // ${LLVM_SRC}/build/bin/clang -march=athlon64-sse3 -m32 -E -dM ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/predefined-arch-macros.c -o - 2>&1 -target i386-unknown-linux | ${LLVM_SRC}/build/bin/FileCheck -match-full-lines ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/predefined-arch-macros.c -check-prefix=CHECK_ATHLON64_SSE3_M32
    RUN("%clang -march=athlon64-sse3 -m32 -E -dM %s -o - 2>&1 -target i386-unknown-linux")./*|*/
      I("FileCheck -match-full-lines %s -check-prefix=CHECK_ATHLON64_SSE3_M32");
    // ${LLVM_SRC}/build/bin/clang -march=athlon64-sse3 -m64 -E -dM ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/predefined-arch-macros.c -o - 2>&1 -target i386-unknown-linux | ${LLVM_SRC}/build/bin/FileCheck -match-full-lines ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/predefined-arch-macros.c -check-prefix=CHECK_ATHLON64_SSE3_M64
    RUN("%clang -march=athlon64-sse3 -m64 -E -dM %s -o - 2>&1 -target i386-unknown-linux")./*|*/
      I("FileCheck -match-full-lines %s -check-prefix=CHECK_ATHLON64_SSE3_M64");
    // ${LLVM_SRC}/build/bin/clang -march=athlon-fx -m32 -E -dM ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/predefined-arch-macros.c -o - 2>&1 -target i386-unknown-linux | ${LLVM_SRC}/build/bin/FileCheck -match-full-lines ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/predefined-arch-macros.c -check-prefix=CHECK_ATHLON_FX_M32
    RUN("%clang -march=athlon-fx -m32 -E -dM %s -o - 2>&1 -target i386-unknown-linux")./*|*/
      I("FileCheck -match-full-lines %s -check-prefix=CHECK_ATHLON_FX_M32");
    // ${LLVM_SRC}/build/bin/clang -march=athlon-fx -m64 -E -dM ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/predefined-arch-macros.c -o - 2>&1 -target i386-unknown-linux | ${LLVM_SRC}/build/bin/FileCheck -match-full-lines ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/predefined-arch-macros.c -check-prefix=CHECK_ATHLON_FX_M64
    RUN("%clang -march=athlon-fx -m64 -E -dM %s -o - 2>&1 -target i386-unknown-linux")./*|*/
      I("FileCheck -match-full-lines %s -check-prefix=CHECK_ATHLON_FX_M64");
    // ${LLVM_SRC}/build/bin/clang -march=amdfam10 -m32 -E -dM ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/predefined-arch-macros.c -o - 2>&1 -target i386-unknown-linux | ${LLVM_SRC}/build/bin/FileCheck -match-full-lines ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/predefined-arch-macros.c -check-prefix=CHECK_AMDFAM10_M32
    RUN("%clang -march=amdfam10 -m32 -E -dM %s -o - 2>&1 -target i386-unknown-linux")./*|*/
      I("FileCheck -match-full-lines %s -check-prefix=CHECK_AMDFAM10_M32");
    // ${LLVM_SRC}/build/bin/clang -march=amdfam10 -m64 -E -dM ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/predefined-arch-macros.c -o - 2>&1 -target i386-unknown-linux | ${LLVM_SRC}/build/bin/FileCheck -match-full-lines ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/predefined-arch-macros.c -check-prefix=CHECK_AMDFAM10_M64
    RUN("%clang -march=amdfam10 -m64 -E -dM %s -o - 2>&1 -target i386-unknown-linux")./*|*/
      I("FileCheck -match-full-lines %s -check-prefix=CHECK_AMDFAM10_M64");
    // ${LLVM_SRC}/build/bin/clang -march=btver1 -m32 -E -dM ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/predefined-arch-macros.c -o - 2>&1 -target i386-unknown-linux | ${LLVM_SRC}/build/bin/FileCheck -match-full-lines ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/predefined-arch-macros.c -check-prefix=CHECK_BTVER1_M32
    RUN("%clang -march=btver1 -m32 -E -dM %s -o - 2>&1 -target i386-unknown-linux")./*|*/
      I("FileCheck -match-full-lines %s -check-prefix=CHECK_BTVER1_M32");
    // ${LLVM_SRC}/build/bin/clang -march=btver1 -m64 -E -dM ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/predefined-arch-macros.c -o - 2>&1 -target i386-unknown-linux | ${LLVM_SRC}/build/bin/FileCheck -match-full-lines ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/predefined-arch-macros.c -check-prefix=CHECK_BTVER1_M64
    RUN("%clang -march=btver1 -m64 -E -dM %s -o - 2>&1 -target i386-unknown-linux")./*|*/
      I("FileCheck -match-full-lines %s -check-prefix=CHECK_BTVER1_M64");
    // ${LLVM_SRC}/build/bin/clang -march=btver2 -m32 -E -dM ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/predefined-arch-macros.c -o - 2>&1 -target i386-unknown-linux | ${LLVM_SRC}/build/bin/FileCheck -match-full-lines ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/predefined-arch-macros.c -check-prefix=CHECK_BTVER2_M32
    RUN("%clang -march=btver2 -m32 -E -dM %s -o - 2>&1 -target i386-unknown-linux")./*|*/
      I("FileCheck -match-full-lines %s -check-prefix=CHECK_BTVER2_M32");
    // ${LLVM_SRC}/build/bin/clang -march=btver2 -m64 -E -dM ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/predefined-arch-macros.c -o - 2>&1 -target i386-unknown-linux | ${LLVM_SRC}/build/bin/FileCheck -match-full-lines ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/predefined-arch-macros.c -check-prefix=CHECK_BTVER2_M64
    RUN("%clang -march=btver2 -m64 -E -dM %s -o - 2>&1 -target i386-unknown-linux")./*|*/
      I("FileCheck -match-full-lines %s -check-prefix=CHECK_BTVER2_M64");
    // ${LLVM_SRC}/build/bin/clang -march=bdver1 -m32 -E -dM ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/predefined-arch-macros.c -o - 2>&1 -target i386-unknown-linux | ${LLVM_SRC}/build/bin/FileCheck -match-full-lines ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/predefined-arch-macros.c -check-prefix=CHECK_BDVER1_M32
    RUN("%clang -march=bdver1 -m32 -E -dM %s -o - 2>&1 -target i386-unknown-linux")./*|*/
      I("FileCheck -match-full-lines %s -check-prefix=CHECK_BDVER1_M32");
    // ${LLVM_SRC}/build/bin/clang -march=bdver1 -m64 -E -dM ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/predefined-arch-macros.c -o - 2>&1 -target i386-unknown-linux | ${LLVM_SRC}/build/bin/FileCheck -match-full-lines ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/predefined-arch-macros.c -check-prefix=CHECK_BDVER1_M64
    RUN("%clang -march=bdver1 -m64 -E -dM %s -o - 2>&1 -target i386-unknown-linux")./*|*/
      I("FileCheck -match-full-lines %s -check-prefix=CHECK_BDVER1_M64");
    // ${LLVM_SRC}/build/bin/clang -march=bdver2 -m32 -E -dM ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/predefined-arch-macros.c -o - 2>&1 -target i386-unknown-linux | ${LLVM_SRC}/build/bin/FileCheck -match-full-lines ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/predefined-arch-macros.c -check-prefix=CHECK_BDVER2_M32
    RUN("%clang -march=bdver2 -m32 -E -dM %s -o - 2>&1 -target i386-unknown-linux")./*|*/
      I("FileCheck -match-full-lines %s -check-prefix=CHECK_BDVER2_M32");
    // ${LLVM_SRC}/build/bin/clang -march=bdver2 -m64 -E -dM ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/predefined-arch-macros.c -o - 2>&1 -target i386-unknown-linux | ${LLVM_SRC}/build/bin/FileCheck -match-full-lines ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/predefined-arch-macros.c -check-prefix=CHECK_BDVER2_M64
    RUN("%clang -march=bdver2 -m64 -E -dM %s -o - 2>&1 -target i386-unknown-linux")./*|*/
      I("FileCheck -match-full-lines %s -check-prefix=CHECK_BDVER2_M64");
    // ${LLVM_SRC}/build/bin/clang -march=bdver3 -m32 -E -dM ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/predefined-arch-macros.c -o - 2>&1 -target i386-unknown-linux | ${LLVM_SRC}/build/bin/FileCheck -match-full-lines ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/predefined-arch-macros.c -check-prefix=CHECK_BDVER3_M32
    RUN("%clang -march=bdver3 -m32 -E -dM %s -o - 2>&1 -target i386-unknown-linux")./*|*/
      I("FileCheck -match-full-lines %s -check-prefix=CHECK_BDVER3_M32");
    // ${LLVM_SRC}/build/bin/clang -march=bdver3 -m64 -E -dM ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/predefined-arch-macros.c -o - 2>&1 -target i386-unknown-linux | ${LLVM_SRC}/build/bin/FileCheck -match-full-lines ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/predefined-arch-macros.c -check-prefix=CHECK_BDVER3_M64
    RUN("%clang -march=bdver3 -m64 -E -dM %s -o - 2>&1 -target i386-unknown-linux")./*|*/
      I("FileCheck -match-full-lines %s -check-prefix=CHECK_BDVER3_M64");
    // ${LLVM_SRC}/build/bin/clang -march=bdver4 -m32 -E -dM ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/predefined-arch-macros.c -o - 2>&1 -target i386-unknown-linux | ${LLVM_SRC}/build/bin/FileCheck -match-full-lines ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/predefined-arch-macros.c -check-prefix=CHECK_BDVER4_M32
    RUN("%clang -march=bdver4 -m32 -E -dM %s -o - 2>&1 -target i386-unknown-linux")./*|*/
      I("FileCheck -match-full-lines %s -check-prefix=CHECK_BDVER4_M32");
    // ${LLVM_SRC}/build/bin/clang -march=bdver4 -m64 -E -dM ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/predefined-arch-macros.c -o - 2>&1 -target i386-unknown-linux | ${LLVM_SRC}/build/bin/FileCheck -match-full-lines ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/predefined-arch-macros.c -check-prefix=CHECK_BDVER4_M64
    RUN("%clang -march=bdver4 -m64 -E -dM %s -o - 2>&1 -target i386-unknown-linux")./*|*/
      I("FileCheck -match-full-lines %s -check-prefix=CHECK_BDVER4_M64");
    // ${LLVM_SRC}/build/bin/clang -mvsx -E -dM ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/predefined-arch-macros.c -o - 2>&1 -target powerpc64-unknown-linux | ${LLVM_SRC}/build/bin/FileCheck -match-full-lines ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/predefined-arch-macros.c -check-prefix=CHECK_PPC_VSX_M64
    RUN("%clang -mvsx -E -dM %s -o - 2>&1 -target powerpc64-unknown-linux")./*|*/
      I("FileCheck -match-full-lines %s -check-prefix=CHECK_PPC_VSX_M64");
    // ${LLVM_SRC}/build/bin/clang -mpower8-vector -E -dM ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/predefined-arch-macros.c -o - 2>&1 -target powerpc64-unknown-linux | ${LLVM_SRC}/build/bin/FileCheck -match-full-lines ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/predefined-arch-macros.c -check-prefix=CHECK_PPC_POWER8_VECTOR_M64
    RUN("%clang -mpower8-vector -E -dM %s -o - 2>&1 -target powerpc64-unknown-linux")./*|*/
      I("FileCheck -match-full-lines %s -check-prefix=CHECK_PPC_POWER8_VECTOR_M64");
    // ${LLVM_SRC}/build/bin/clang -mcrypto -E -dM ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/predefined-arch-macros.c -o - 2>&1 -target powerpc64-unknown-linux | ${LLVM_SRC}/build/bin/FileCheck -match-full-lines ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/predefined-arch-macros.c -check-prefix=CHECK_PPC_CRYPTO_M64
    RUN("%clang -mcrypto -E -dM %s -o - 2>&1 -target powerpc64-unknown-linux")./*|*/
      I("FileCheck -match-full-lines %s -check-prefix=CHECK_PPC_CRYPTO_M64");
    // ${LLVM_SRC}/build/bin/clang -mcpu=ppc64 -E -dM ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/predefined-arch-macros.c -o - 2>&1 -target powerpc64-unknown-unknown | ${LLVM_SRC}/build/bin/FileCheck -match-full-lines ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/predefined-arch-macros.c -check-prefix=CHECK_PPC_GCC_ATOMICS
    RUN("%clang -mcpu=ppc64 -E -dM %s -o - 2>&1 -target powerpc64-unknown-unknown")./*|*/
      I("FileCheck -match-full-lines %s -check-prefix=CHECK_PPC_GCC_ATOMICS");
    // ${LLVM_SRC}/build/bin/clang -mcpu=pwr8 -E -dM ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/predefined-arch-macros.c -o - 2>&1 -target powerpc64-unknown-unknown | ${LLVM_SRC}/build/bin/FileCheck -match-full-lines ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/predefined-arch-macros.c -check-prefix=CHECK_PPC_GCC_ATOMICS
    RUN("%clang -mcpu=pwr8 -E -dM %s -o - 2>&1 -target powerpc64-unknown-unknown")./*|*/
      I("FileCheck -match-full-lines %s -check-prefix=CHECK_PPC_GCC_ATOMICS");
    // ${LLVM_SRC}/build/bin/clang -E -dM ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/predefined-arch-macros.c -o - 2>&1 -target powerpc64le-unknown-linux | ${LLVM_SRC}/build/bin/FileCheck -match-full-lines ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/predefined-arch-macros.c -check-prefix=CHECK_PPC_GCC_ATOMICS
    RUN("%clang -E -dM %s -o - 2>&1 -target powerpc64le-unknown-linux")./*|*/
      I("FileCheck -match-full-lines %s -check-prefix=CHECK_PPC_GCC_ATOMICS");
    // ${LLVM_SRC}/build/bin/clang -E -dM ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/predefined-arch-macros.c -o - 2>&1 -target sparc-unknown-linux | ${LLVM_SRC}/build/bin/FileCheck -match-full-lines ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/predefined-arch-macros.c -check-prefix=CHECK_SPARC
    RUN("%clang -E -dM %s -o - 2>&1 -target sparc-unknown-linux")./*|*/
      I("FileCheck -match-full-lines %s -check-prefix=CHECK_SPARC");
    // ${LLVM_SRC}/build/bin/clang -mcpu=v9 -E -dM ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/predefined-arch-macros.c -o - 2>&1 -target sparc-unknown-linux | ${LLVM_SRC}/build/bin/FileCheck -match-full-lines ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/predefined-arch-macros.c -check-prefix=CHECK_SPARC-V9
    RUN("%clang -mcpu=v9 -E -dM %s -o - 2>&1 -target sparc-unknown-linux")./*|*/
      I("FileCheck -match-full-lines %s -check-prefix=CHECK_SPARC-V9");
    // ${LLVM_SRC}/build/bin/clang -E -dM ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/predefined-arch-macros.c -o - 2>&1 -target sparcel-unknown-linux | ${LLVM_SRC}/build/bin/FileCheck -match-full-lines ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/predefined-arch-macros.c -check-prefix=CHECK_SPARCEL
    RUN("%clang -E -dM %s -o - 2>&1 -target sparcel-unknown-linux")./*|*/
      I("FileCheck -match-full-lines %s -check-prefix=CHECK_SPARCEL");
    // ${LLVM_SRC}/build/bin/clang -E -dM ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/predefined-arch-macros.c -o - -target sparcel-myriad -mcpu=myriad2 2>&1 | ${LLVM_SRC}/build/bin/FileCheck -match-full-lines ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/predefined-arch-macros.c -check-prefix=CHECK_MYRIAD2-1 -check-prefix=CHECK_SPARCEL
    RUN("%clang -E -dM %s -o - -target sparcel-myriad -mcpu=myriad2 2>&1")./*|*/
      I("FileCheck -match-full-lines %s -check-prefix=CHECK_MYRIAD2-1 -check-prefix=CHECK_SPARCEL");
    // ${LLVM_SRC}/build/bin/clang -E -dM ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/predefined-arch-macros.c -o - -target sparcel-myriad -mcpu=myriad2.1 2>&1 | ${LLVM_SRC}/build/bin/FileCheck -match-full-lines ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/predefined-arch-macros.c -check-prefix=CHECK_MYRIAD2-1 -check-prefix=CHECK_SPARCEL
    RUN("%clang -E -dM %s -o - -target sparcel-myriad -mcpu=myriad2.1 2>&1")./*|*/
      I("FileCheck -match-full-lines %s -check-prefix=CHECK_MYRIAD2-1 -check-prefix=CHECK_SPARCEL");
    // ${LLVM_SRC}/build/bin/clang -E -dM ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/predefined-arch-macros.c -o - -target sparcel-myriad -mcpu=myriad2.2 2>&1 | ${LLVM_SRC}/build/bin/FileCheck -match-full-lines ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/predefined-arch-macros.c -check-prefix=CHECK_MYRIAD2-2 -check-prefix=CHECK_SPARCEL
    RUN("%clang -E -dM %s -o - -target sparcel-myriad -mcpu=myriad2.2 2>&1")./*|*/
      I("FileCheck -match-full-lines %s -check-prefix=CHECK_MYRIAD2-2 -check-prefix=CHECK_SPARCEL");
    // ${LLVM_SRC}/build/bin/clang -E -dM ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/predefined-arch-macros.c -o - 2>&1 -target sparcv9-unknown-linux | ${LLVM_SRC}/build/bin/FileCheck -match-full-lines ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/predefined-arch-macros.c -check-prefix=CHECK_SPARCV9
    RUN("%clang -E -dM %s -o - 2>&1 -target sparcv9-unknown-linux")./*|*/
      I("FileCheck -match-full-lines %s -check-prefix=CHECK_SPARCV9");
    // ${LLVM_SRC}/build/bin/clang -march=z10 -E -dM ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/predefined-arch-macros.c -o - 2>&1 -target s390x-unknown-linux | ${LLVM_SRC}/build/bin/FileCheck -match-full-lines ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/predefined-arch-macros.c -check-prefix=CHECK_SYSTEMZ_Z10
    RUN("%clang -march=z10 -E -dM %s -o - 2>&1 -target s390x-unknown-linux")./*|*/
      I("FileCheck -match-full-lines %s -check-prefix=CHECK_SYSTEMZ_Z10");
    // ${LLVM_SRC}/build/bin/clang -march=zEC12 -E -dM ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/predefined-arch-macros.c -o - 2>&1 -target s390x-unknown-linux | ${LLVM_SRC}/build/bin/FileCheck -match-full-lines ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/predefined-arch-macros.c -check-prefix=CHECK_SYSTEMZ_ZEC12
    RUN("%clang -march=zEC12 -E -dM %s -o - 2>&1 -target s390x-unknown-linux")./*|*/
      I("FileCheck -match-full-lines %s -check-prefix=CHECK_SYSTEMZ_ZEC12");
    // ${LLVM_SRC}/build/bin/clang -mhtm -E -dM ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/predefined-arch-macros.c -o - 2>&1 -target s390x-unknown-linux | ${LLVM_SRC}/build/bin/FileCheck -match-full-lines ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/predefined-arch-macros.c -check-prefix=CHECK_SYSTEMZ_HTM
    RUN("%clang -mhtm -E -dM %s -o - 2>&1 -target s390x-unknown-linux")./*|*/
      I("FileCheck -match-full-lines %s -check-prefix=CHECK_SYSTEMZ_HTM");
    // ${LLVM_SRC}/build/bin/clang -fzvector -E -dM ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/predefined-arch-macros.c -o - 2>&1 -target s390x-unknown-linux | ${LLVM_SRC}/build/bin/FileCheck -match-full-lines ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/predefined-arch-macros.c -check-prefix=CHECK_SYSTEMZ_ZVECTOR
    RUN("%clang -fzvector -E -dM %s -o - 2>&1 -target s390x-unknown-linux")./*|*/
      I("FileCheck -match-full-lines %s -check-prefix=CHECK_SYSTEMZ_ZVECTOR");
    // ${LLVM_SRC}/build/bin/clang -mzvector -E -dM ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/predefined-arch-macros.c -o - 2>&1 -target s390x-unknown-linux | ${LLVM_SRC}/build/bin/FileCheck -match-full-lines ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/predefined-arch-macros.c -check-prefix=CHECK_SYSTEMZ_ZVECTOR
    RUN("%clang -mzvector -E -dM %s -o - 2>&1 -target s390x-unknown-linux")./*|*/
      I("FileCheck -match-full-lines %s -check-prefix=CHECK_SYSTEMZ_ZVECTOR");
    // ${LLVM_SRC}/build/bin/clang -march=amdgcn -E -dM ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/predefined-arch-macros.c -o - 2>&1 -target amdgcn-unknown-unknown | ${LLVM_SRC}/build/bin/FileCheck -match-full-lines ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/predefined-arch-macros.c -check-prefix=CHECK_AMDGCN
    RUN("%clang -march=amdgcn -E -dM %s -o - 2>&1 -target amdgcn-unknown-unknown")./*|*/
      I("FileCheck -match-full-lines %s -check-prefix=CHECK_AMDGCN");
    // ${LLVM_SRC}/build/bin/clang -march=amdgcn -E -dM ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/predefined-arch-macros.c -o - 2>&1 -target r600-unknown-unknown | ${LLVM_SRC}/build/bin/FileCheck -match-full-lines ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/predefined-arch-macros.c -check-prefix=CHECK_R600
    RUN("%clang -march=amdgcn -E -dM %s -o - 2>&1 -target r600-unknown-unknown")./*|*/
      I("FileCheck -match-full-lines %s -check-prefix=CHECK_R600");
  }

  @Test
  public void test_predefined_exceptions_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/predefined-exceptions.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x objective-c -fobjc-exceptions -fexceptions -E -dM ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/predefined-exceptions.m | ${LLVM_SRC}/build/bin/FileCheck -check-prefix=CHECK-OBJC-NOCXX ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/predefined-exceptions.m
    RUN("%clang_cc1 -x objective-c -fobjc-exceptions -fexceptions -E -dM %s")./*|*/
      I("FileCheck -check-prefix=CHECK-OBJC-NOCXX %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x objective-c++ -fobjc-exceptions -fexceptions -fcxx-exceptions -E -dM ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/predefined-exceptions.m | ${LLVM_SRC}/build/bin/FileCheck -check-prefix=CHECK-OBJC-CXX ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/predefined-exceptions.m
    RUN("%clang_cc1 -x objective-c++ -fobjc-exceptions -fexceptions -fcxx-exceptions -E -dM %s")./*|*/
      I("FileCheck -check-prefix=CHECK-OBJC-CXX %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x objective-c++ -fexceptions -fcxx-exceptions -E -dM ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/predefined-exceptions.m | ${LLVM_SRC}/build/bin/FileCheck -check-prefix=CHECK-NOOBJC-CXX ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/predefined-exceptions.m
    RUN("%clang_cc1 -x objective-c++ -fexceptions -fcxx-exceptions -E -dM %s")./*|*/
      I("FileCheck -check-prefix=CHECK-NOOBJC-CXX %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x objective-c -E -dM ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/predefined-exceptions.m | ${LLVM_SRC}/build/bin/FileCheck -check-prefix=CHECK-NOOBJC-NOCXX ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/predefined-exceptions.m
    RUN("%clang_cc1 -x objective-c -E -dM %s")./*|*/
      I("FileCheck -check-prefix=CHECK-NOOBJC-NOCXX %s");
  }

  @Test
  public void test_predefined_macros_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/predefined-macros.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/predefined-macros.c -x c++ -E -dM -triple i686-pc-win32 -fms-extensions -fms-compatibility -fms-compatibility-version=19.00 -std=c++1z -o - | ${LLVM_SRC}/build/bin/FileCheck -match-full-lines ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/predefined-macros.c --check-prefix=CHECK-MS
    RUN("%clang_cc1 %s -x c++ -E -dM -triple i686-pc-win32 -fms-extensions -fms-compatibility -fms-compatibility-version=19.00 -std=c++1z -o -")./*|*/
      I("FileCheck -match-full-lines %s --check-prefix=CHECK-MS");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/predefined-macros.c -x c++ -E -dM -triple x86_64-pc-win32 -fms-extensions -fms-compatibility -fms-compatibility-version=19.00 -std=c++14 -o - | ${LLVM_SRC}/build/bin/FileCheck -match-full-lines ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/predefined-macros.c --check-prefix=CHECK-MS64
    RUN("%clang_cc1 %s -x c++ -E -dM -triple x86_64-pc-win32 -fms-extensions -fms-compatibility -fms-compatibility-version=19.00 -std=c++14 -o -")./*|*/
      I("FileCheck -match-full-lines %s --check-prefix=CHECK-MS64");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/predefined-macros.c -E -dM -triple i686-pc-win32 -fms-compatibility -o - | ${LLVM_SRC}/build/bin/FileCheck -match-full-lines ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/predefined-macros.c --check-prefix=CHECK-MS-STDINT
    RUN("%clang_cc1 %s -E -dM -triple i686-pc-win32 -fms-compatibility -o -")./*|*/
      I("FileCheck -match-full-lines %s --check-prefix=CHECK-MS-STDINT");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/predefined-macros.c -E -dM -ffast-math -o - | ${LLVM_SRC}/build/bin/FileCheck -match-full-lines ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/predefined-macros.c --check-prefix=CHECK-FAST-MATH
    RUN("%clang_cc1 %s -E -dM -ffast-math -o -")./*|*/
      I("FileCheck -match-full-lines %s --check-prefix=CHECK-FAST-MATH");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/predefined-macros.c -E -dM -ffinite-math-only -o - | ${LLVM_SRC}/build/bin/FileCheck -match-full-lines ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/predefined-macros.c --check-prefix=CHECK-FINITE-MATH-ONLY
    RUN("%clang_cc1 %s -E -dM -ffinite-math-only -o -")./*|*/
      I("FileCheck -match-full-lines %s --check-prefix=CHECK-FINITE-MATH-ONLY");
    // ${LLVM_SRC}/build/bin/clang ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/predefined-macros.c -E -dM -fno-finite-math-only -o - | ${LLVM_SRC}/build/bin/FileCheck -match-full-lines ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/predefined-macros.c --check-prefix=CHECK-NO-FINITE-MATH-ONLY
    RUN("%clang %s -E -dM -fno-finite-math-only -o -")./*|*/
      I("FileCheck -match-full-lines %s --check-prefix=CHECK-NO-FINITE-MATH-ONLY");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/predefined-macros.c -E -dM -o - | ${LLVM_SRC}/build/bin/FileCheck -match-full-lines ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/predefined-macros.c --check-prefix=CHECK-FINITE-MATH-FLAG-UNDEFINED
    RUN("%clang_cc1 %s -E -dM -o -")./*|*/
      I("FileCheck -match-full-lines %s --check-prefix=CHECK-FINITE-MATH-FLAG-UNDEFINED");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/predefined-macros.c -E -dM -o - -triple i686 -target-cpu i386 | ${LLVM_SRC}/build/bin/FileCheck -match-full-lines ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/predefined-macros.c --check-prefix=CHECK-SYNC_CAS_I386
    RUN("%clang_cc1 %s -E -dM -o - -triple i686 -target-cpu i386")./*|*/
      I("FileCheck -match-full-lines %s --check-prefix=CHECK-SYNC_CAS_I386");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/predefined-macros.c -E -dM -o - -triple i686 -target-cpu i486 | ${LLVM_SRC}/build/bin/FileCheck -match-full-lines ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/predefined-macros.c --check-prefix=CHECK-SYNC_CAS_I486
    RUN("%clang_cc1 %s -E -dM -o - -triple i686 -target-cpu i486")./*|*/
      I("FileCheck -match-full-lines %s --check-prefix=CHECK-SYNC_CAS_I486");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/predefined-macros.c -E -dM -o - -triple i686 -target-cpu i586 | ${LLVM_SRC}/build/bin/FileCheck -match-full-lines ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/predefined-macros.c --check-prefix=CHECK-SYNC_CAS_I586
    RUN("%clang_cc1 %s -E -dM -o - -triple i686 -target-cpu i586")./*|*/
      I("FileCheck -match-full-lines %s --check-prefix=CHECK-SYNC_CAS_I586");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/predefined-macros.c -E -dM -o - -triple armv6 -target-cpu arm1136j-s | ${LLVM_SRC}/build/bin/FileCheck -match-full-lines ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/predefined-macros.c --check-prefix=CHECK-SYNC_CAS_ARM
    RUN("%clang_cc1 %s -E -dM -o - -triple armv6 -target-cpu arm1136j-s")./*|*/
      I("FileCheck -match-full-lines %s --check-prefix=CHECK-SYNC_CAS_ARM");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/predefined-macros.c -E -dM -o - -triple armv7 -target-cpu cortex-a8 | ${LLVM_SRC}/build/bin/FileCheck -match-full-lines ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/predefined-macros.c --check-prefix=CHECK-SYNC_CAS_ARMv7
    RUN("%clang_cc1 %s -E -dM -o - -triple armv7 -target-cpu cortex-a8")./*|*/
      I("FileCheck -match-full-lines %s --check-prefix=CHECK-SYNC_CAS_ARMv7");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/predefined-macros.c -E -dM -o - -triple armv6 -target-cpu cortex-m0 | ${LLVM_SRC}/build/bin/FileCheck -match-full-lines ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/predefined-macros.c --check-prefix=CHECK-SYNC_CAS_ARMv6
    RUN("%clang_cc1 %s -E -dM -o - -triple armv6 -target-cpu cortex-m0")./*|*/
      I("FileCheck -match-full-lines %s --check-prefix=CHECK-SYNC_CAS_ARMv6");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/predefined-macros.c -E -dM -o - -triple mips -target-cpu mips2 | ${LLVM_SRC}/build/bin/FileCheck -match-full-lines ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/predefined-macros.c --check-prefix=CHECK-SYNC_CAS_MIPS --check-prefix=CHECK-SYNC_CAS_MIPS32
    RUN("%clang_cc1 %s -E -dM -o - -triple mips -target-cpu mips2")./*|*/
      I("FileCheck -match-full-lines %s --check-prefix=CHECK-SYNC_CAS_MIPS --check-prefix=CHECK-SYNC_CAS_MIPS32");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/predefined-macros.c -E -dM -o - -triple mips64 -target-cpu mips3 | ${LLVM_SRC}/build/bin/FileCheck -match-full-lines ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/predefined-macros.c --check-prefix=CHECK-SYNC_CAS_MIPS --check-prefix=CHECK-SYNC_CAS_MIPS64
    RUN("%clang_cc1 %s -E -dM -o - -triple mips64 -target-cpu mips3")./*|*/
      I("FileCheck -match-full-lines %s --check-prefix=CHECK-SYNC_CAS_MIPS --check-prefix=CHECK-SYNC_CAS_MIPS64");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/predefined-macros.c -E -dM -o - -x cl | ${LLVM_SRC}/build/bin/FileCheck -match-full-lines ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/predefined-macros.c --check-prefix=CHECK-CL10
    RUN("%clang_cc1 %s -E -dM -o - -x cl")./*|*/
      I("FileCheck -match-full-lines %s --check-prefix=CHECK-CL10");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/predefined-macros.c -E -dM -o - -x cl -cl-std=CL1.1 | ${LLVM_SRC}/build/bin/FileCheck -match-full-lines ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/predefined-macros.c --check-prefix=CHECK-CL11
    RUN("%clang_cc1 %s -E -dM -o - -x cl -cl-std=CL1.1")./*|*/
      I("FileCheck -match-full-lines %s --check-prefix=CHECK-CL11");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/predefined-macros.c -E -dM -o - -x cl -cl-std=CL1.2 | ${LLVM_SRC}/build/bin/FileCheck -match-full-lines ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/predefined-macros.c --check-prefix=CHECK-CL12
    RUN("%clang_cc1 %s -E -dM -o - -x cl -cl-std=CL1.2")./*|*/
      I("FileCheck -match-full-lines %s --check-prefix=CHECK-CL12");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/predefined-macros.c -E -dM -o - -x cl -cl-std=CL2.0 | ${LLVM_SRC}/build/bin/FileCheck -match-full-lines ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/predefined-macros.c --check-prefix=CHECK-CL20
    RUN("%clang_cc1 %s -E -dM -o - -x cl -cl-std=CL2.0")./*|*/
      I("FileCheck -match-full-lines %s --check-prefix=CHECK-CL20");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/predefined-macros.c -E -dM -o - -x cl -cl-fast-relaxed-math | ${LLVM_SRC}/build/bin/FileCheck -match-full-lines ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/predefined-macros.c --check-prefix=CHECK-FRM
    RUN("%clang_cc1 %s -E -dM -o - -x cl -cl-fast-relaxed-math")./*|*/
      I("FileCheck -match-full-lines %s --check-prefix=CHECK-FRM");
  }

  @Test
  public void test_predefined_nullability_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/predefined-nullability.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/predefined-nullability.c -E -dM -triple i386-apple-darwin10 -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/predefined-nullability.c --check-prefix=CHECK-DARWIN
    RUN("%clang_cc1 %s -E -dM -triple i386-apple-darwin10 -o -")./*|*/
      I("FileCheck %s --check-prefix=CHECK-DARWIN");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/predefined-nullability.c -E -dM -triple x86_64-unknown-linux -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/predefined-nullability.c --check-prefix=CHECK-NONDARWIN
    RUN("%clang_cc1 %s -E -dM -triple x86_64-unknown-linux -o -")./*|*/
      I("FileCheck %s --check-prefix=CHECK-NONDARWIN");
  }

  @Test
  public void test_print_pragma_microsoft_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/print-pragma-microsoft.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/print-pragma-microsoft.c -fsyntax-only -fms-extensions -E -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/print-pragma-microsoft.c
    RUN("%clang_cc1 %s -fsyntax-only -fms-extensions -E -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_print_line_count_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/print_line_count.c");
    // ${LLVM_SRC}/build/bin/clang -E -C -P ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/print_line_count.c | ${LLVM_SRC}/build/bin/FileCheck --strict-whitespace ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/print_line_count.c
    RUN("%clang -E -C -P %s")./*|*/
      I("FileCheck --strict-whitespace %s");
  }

  @Test
  public void test_print_line_empty_file_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/print_line_empty_file.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -E ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/print_line_empty_file.c | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/print_line_empty_file.c
    RUN("%clang_cc1 -E %s")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_print_line_include_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/print_line_include.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -E -P ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/print_line_include.c | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/print_line_include.c
    RUN("%clang_cc1 -E -P %s")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_print_line_track_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/print_line_track.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -E ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/print_line_track.c | grep 'a 3'
    RUN("%clang_cc1 -E %s")./*|*/
      I("grep 'a 3'");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -E ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/print_line_track.c | grep 'b 16'
    RUN("%clang_cc1 -E %s")./*|*/
      I("grep 'b 16'");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -E -P ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/print_line_track.c | grep 'a 3'
    RUN("%clang_cc1 -E -P %s")./*|*/
      I("grep 'a 3'");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -E -P ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/print_line_track.c | grep 'b 16'
    RUN("%clang_cc1 -E -P %s")./*|*/
      I("grep 'b 16'");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -E ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/print_line_track.c | not grep '# 0 '
    RUN("%clang_cc1 -E %s")./*|*/
      I("not grep '# 0 '");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -E -P ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/print_line_track.c | ${LLVM_SRC}/build/bin/count 4
    RUN("%clang_cc1 -E -P %s")./*|*/
      I("count 4");
  }

  @Test
  public void test_pushable_diagnostics_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/pushable-diagnostics.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -pedantic ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/pushable-diagnostics.c
    RUN("%clang_cc1 -fsyntax-only -verify -pedantic %s");
  }

  @Test
  public void test_skipping_unclean_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/skipping_unclean.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -E ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/skipping_unclean.c | ${LLVM_SRC}/build/bin/FileCheck --strict-whitespace ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/skipping_unclean.c
    RUN("%clang_cc1 -E %s")./*|*/
      I("FileCheck --strict-whitespace %s");
  }

  @Test
  public void test_stdint_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/stdint.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -E -ffreestanding -triple=arm-none-none ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/stdint.c | ${LLVM_SRC}/build/bin/FileCheck -check-prefix ARM ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/stdint.c
    RUN("%clang_cc1 -E -ffreestanding -triple=arm-none-none %s")./*|*/
      I("FileCheck -check-prefix ARM %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -E -ffreestanding -triple=i386-none-none ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/stdint.c | ${LLVM_SRC}/build/bin/FileCheck -check-prefix I386 ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/stdint.c
    RUN("%clang_cc1 -E -ffreestanding -triple=i386-none-none %s")./*|*/
      I("FileCheck -check-prefix I386 %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -E -ffreestanding -triple=mips-none-none ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/stdint.c | ${LLVM_SRC}/build/bin/FileCheck -check-prefix MIPS ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/stdint.c
    RUN("%clang_cc1 -E -ffreestanding -triple=mips-none-none %s")./*|*/
      I("FileCheck -check-prefix MIPS %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -E -ffreestanding -triple=mips64-none-none ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/stdint.c | ${LLVM_SRC}/build/bin/FileCheck -check-prefix MIPS64 ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/stdint.c
    RUN("%clang_cc1 -E -ffreestanding -triple=mips64-none-none %s")./*|*/
      I("FileCheck -check-prefix MIPS64 %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -E -ffreestanding -triple=msp430-none-none ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/stdint.c | ${LLVM_SRC}/build/bin/FileCheck -check-prefix MSP430 ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/stdint.c
    RUN("%clang_cc1 -E -ffreestanding -triple=msp430-none-none %s")./*|*/
      I("FileCheck -check-prefix MSP430 %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -E -ffreestanding -triple=powerpc64-none-none ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/stdint.c | ${LLVM_SRC}/build/bin/FileCheck -check-prefix PPC64 ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/stdint.c
    RUN("%clang_cc1 -E -ffreestanding -triple=powerpc64-none-none %s")./*|*/
      I("FileCheck -check-prefix PPC64 %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -E -ffreestanding -triple=powerpc64-none-netbsd ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/stdint.c | ${LLVM_SRC}/build/bin/FileCheck -check-prefix PPC64-NETBSD ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/stdint.c
    RUN("%clang_cc1 -E -ffreestanding -triple=powerpc64-none-netbsd %s")./*|*/
      I("FileCheck -check-prefix PPC64-NETBSD %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -E -ffreestanding -triple=powerpc-none-none ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/stdint.c | ${LLVM_SRC}/build/bin/FileCheck -check-prefix PPC ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/stdint.c
    RUN("%clang_cc1 -E -ffreestanding -triple=powerpc-none-none %s")./*|*/
      I("FileCheck -check-prefix PPC %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -E -ffreestanding -triple=s390x-none-none ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/stdint.c | ${LLVM_SRC}/build/bin/FileCheck -check-prefix S390X ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/stdint.c
    RUN("%clang_cc1 -E -ffreestanding -triple=s390x-none-none %s")./*|*/
      I("FileCheck -check-prefix S390X %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -E -ffreestanding -triple=sparc-none-none ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/stdint.c | ${LLVM_SRC}/build/bin/FileCheck -check-prefix SPARC ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/stdint.c
    RUN("%clang_cc1 -E -ffreestanding -triple=sparc-none-none %s")./*|*/
      I("FileCheck -check-prefix SPARC %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -E -ffreestanding -triple=tce-none-none ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/stdint.c | ${LLVM_SRC}/build/bin/FileCheck -check-prefix TCE ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/stdint.c
    RUN("%clang_cc1 -E -ffreestanding -triple=tce-none-none %s")./*|*/
      I("FileCheck -check-prefix TCE %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -E -ffreestanding -triple=x86_64-none-none ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/stdint.c | ${LLVM_SRC}/build/bin/FileCheck -check-prefix X86_64 ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/stdint.c
    RUN("%clang_cc1 -E -ffreestanding -triple=x86_64-none-none %s")./*|*/
      I("FileCheck -check-prefix X86_64 %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -E -ffreestanding -triple=x86_64-pc-linux-gnu ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/stdint.c | ${LLVM_SRC}/build/bin/FileCheck -check-prefix X86_64_LINUX ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/stdint.c
    RUN("%clang_cc1 -E -ffreestanding -triple=x86_64-pc-linux-gnu %s")./*|*/
      I("FileCheck -check-prefix X86_64_LINUX %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -E -ffreestanding -triple=i386-mingw32 ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/stdint.c | ${LLVM_SRC}/build/bin/FileCheck -check-prefix I386_MINGW32 ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/stdint.c
    RUN("%clang_cc1 -E -ffreestanding -triple=i386-mingw32 %s")./*|*/
      I("FileCheck -check-prefix I386_MINGW32 %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -E -ffreestanding -triple=xcore-none-none ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/stdint.c | ${LLVM_SRC}/build/bin/FileCheck -check-prefix XCORE ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/stdint.c
    RUN("%clang_cc1 -E -ffreestanding -triple=xcore-none-none %s")./*|*/
      I("FileCheck -check-prefix XCORE %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -E -ffreestanding -U__UINTMAX_TYPE__ -U__INTMAX_TYPE__ -Dint=a -Duint=b -D_t=c -DINT=d -DUINT=e -D_MIN=f -D_MAX=g '-D_C(v)=h' -triple=i386-none-none ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/stdint.c | ${LLVM_SRC}/build/bin/FileCheck -check-prefix JOIN ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/stdint.c
    RUN("%clang_cc1 -E -ffreestanding -U__UINTMAX_TYPE__ -U__INTMAX_TYPE__ -Dint=a -Duint=b -D_t=c -DINT=d -DUINT=e -D_MIN=f -D_MAX=g '-D_C(v)=h' -triple=i386-none-none %s")./*|*/
      I("FileCheck -check-prefix JOIN %s");
  }

  @Test
  public void test_stringize_misc_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/stringize_misc.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -E ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/stringize_misc.c -DTEST1 | ${LLVM_SRC}/build/bin/FileCheck -strict-whitespace ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/stringize_misc.c
    RUN("%clang_cc1 -E %s -DTEST1")./*|*/
      I("FileCheck -strict-whitespace %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/stringize_misc.c -DTEST2
    RUN("%clang_cc1 -fsyntax-only -verify %s -DTEST2");
  }

  @Test
  public void test_stringize_space_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/stringize_space.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -E ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/stringize_space.c | ${LLVM_SRC}/build/bin/FileCheck --strict-whitespace ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/stringize_space.c
    RUN("%clang_cc1 -E %s")./*|*/
      I("FileCheck --strict-whitespace %s");
  }

  @Test
  public void test_sysroot_prefix_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/sysroot-prefix.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -v -isysroot /var/empty -I /var/empty/include -E ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/sysroot-prefix.c -o /dev/null 2>&1 | ${LLVM_SRC}/build/bin/FileCheck -check-prefix CHECK-ISYSROOT_NO_SYSROOT ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/sysroot-prefix.c
    RUN("%clang_cc1 -v -isysroot /var/empty -I /var/empty/include -E %s -o /dev/null 2>&1")./*|*/
      I("FileCheck -check-prefix CHECK-ISYSROOT_NO_SYSROOT %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -v -isysroot /var/empty -I =/var/empty/include -E ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/sysroot-prefix.c -o /dev/null 2>&1 | ${LLVM_SRC}/build/bin/FileCheck -check-prefix CHECK-ISYSROOT_SYSROOT_DEV_NULL ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/sysroot-prefix.c
    RUN("%clang_cc1 -v -isysroot /var/empty -I =/var/empty/include -E %s -o /dev/null 2>&1")./*|*/
      I("FileCheck -check-prefix CHECK-ISYSROOT_SYSROOT_DEV_NULL %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -v -I =/var/empty/include -E ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/sysroot-prefix.c -o /dev/null 2>&1 | ${LLVM_SRC}/build/bin/FileCheck -check-prefix CHECK-NO_ISYSROOT_SYSROOT_DEV_NULL ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/sysroot-prefix.c
    RUN("%clang_cc1 -v -I =/var/empty/include -E %s -o /dev/null 2>&1")./*|*/
      I("FileCheck -check-prefix CHECK-NO_ISYSROOT_SYSROOT_DEV_NULL %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -v -isysroot /var/empty -I =null -E ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/sysroot-prefix.c -o /dev/null 2>&1 | ${LLVM_SRC}/build/bin/FileCheck -check-prefix CHECK-ISYSROOT_SYSROOT_NULL ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/sysroot-prefix.c
    RUN("%clang_cc1 -v -isysroot /var/empty -I =null -E %s -o /dev/null 2>&1")./*|*/
      I("FileCheck -check-prefix CHECK-ISYSROOT_SYSROOT_NULL %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -v -isysroot /var/empty -isysroot /var/empty/root -I =null -E ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/sysroot-prefix.c -o /dev/null 2>&1 | ${LLVM_SRC}/build/bin/FileCheck -check-prefix CHECK-ISYSROOT_ISYSROOT_SYSROOT_NULL ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/sysroot-prefix.c
    RUN("%clang_cc1 -v -isysroot /var/empty -isysroot /var/empty/root -I =null -E %s -o /dev/null 2>&1")./*|*/
      I("FileCheck -check-prefix CHECK-ISYSROOT_ISYSROOT_SYSROOT_NULL %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -v -isysroot /var/empty/root -isysroot /var/empty -I =null -E ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/sysroot-prefix.c -o /dev/null 2>&1 | ${LLVM_SRC}/build/bin/FileCheck -check-prefix CHECK-ISYSROOT_ISYSROOT_SWAPPED_SYSROOT_NULL ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/sysroot-prefix.c
    RUN("%clang_cc1 -v -isysroot /var/empty/root -isysroot /var/empty -I =null -E %s -o /dev/null 2>&1")./*|*/
      I("FileCheck -check-prefix CHECK-ISYSROOT_ISYSROOT_SWAPPED_SYSROOT_NULL %s");
  }

  @Test
  public void test_traditional_cpp_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/traditional-cpp.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -traditional-cpp ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/traditional-cpp.c -E | ${LLVM_SRC}/build/bin/FileCheck -strict-whitespace ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/traditional-cpp.c
    RUN("%clang_cc1 -traditional-cpp %s -E")./*|*/
      I("FileCheck -strict-whitespace %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -traditional-cpp ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/traditional-cpp.c -E -C | ${LLVM_SRC}/build/bin/FileCheck -check-prefix=CHECK-COMMENTS ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/traditional-cpp.c
    RUN("%clang_cc1 -traditional-cpp %s -E -C")./*|*/
      I("FileCheck -check-prefix=CHECK-COMMENTS %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -traditional-cpp -x c++ ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/traditional-cpp.c -E | ${LLVM_SRC}/build/bin/FileCheck -check-prefix=CHECK-CXX ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/traditional-cpp.c
    RUN("%clang_cc1 -traditional-cpp -x c++ %s -E")./*|*/
      I("FileCheck -check-prefix=CHECK-CXX %s");
  }

  @Test
  public void test_ucn_allowed_chars_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/ucn-allowed-chars.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/ucn-allowed-chars.c -fsyntax-only -std=c99 -verify
    RUN("%clang_cc1 %s -fsyntax-only -std=c99 -verify");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/ucn-allowed-chars.c -fsyntax-only -std=c11 -Wc99-compat -verify
    RUN("%clang_cc1 %s -fsyntax-only -std=c11 -Wc99-compat -verify");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/ucn-allowed-chars.c -fsyntax-only -x c++ -std=c++03 -Wc++11-compat -verify
    RUN("%clang_cc1 %s -fsyntax-only -x c++ -std=c++03 -Wc++11-compat -verify");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/ucn-allowed-chars.c -fsyntax-only -x c++ -std=c++11 -Wc++98-compat -verify
    RUN("%clang_cc1 %s -fsyntax-only -x c++ -std=c++11 -Wc++98-compat -verify");
  }

  @Test
  public void test_ucn_pp_identifier_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/ucn-pp-identifier.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/ucn-pp-identifier.c -fsyntax-only -std=c99 -pedantic -verify -Wundef
    RUN("%clang_cc1 %s -fsyntax-only -std=c99 -pedantic -verify -Wundef");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/ucn-pp-identifier.c -fsyntax-only -x c++ -pedantic -verify -Wundef
    RUN("%clang_cc1 %s -fsyntax-only -x c++ -pedantic -verify -Wundef");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/ucn-pp-identifier.c -fsyntax-only -std=c99 -pedantic -Wundef 2>&1 | ${LLVM_SRC}/build/bin/FileCheck -strict-whitespace ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/ucn-pp-identifier.c
    RUN("not %clang_cc1 %s -fsyntax-only -std=c99 -pedantic -Wundef 2>&1")./*|*/
      I("FileCheck -strict-whitespace %s");
  }

  @Test
  public void test_undef_error_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/undef-error.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/undef-error.c -pedantic-errors -Wno-empty-translation-unit -verify
    RUN("%clang_cc1 %s -pedantic-errors -Wno-empty-translation-unit -verify");
  }

  @Test
  public void test_unterminated_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/unterminated.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -E -verify ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/unterminated.c
    RUN("%clang_cc1 -E -verify %s");
  }

  @Test
  public void test_user_defined_system_framework_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/user_defined_system_framework.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -F ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/Inputs -Wsign-conversion -verify ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/user_defined_system_framework.c
    RUN("%clang_cc1 -fsyntax-only -F %S/Inputs -Wsign-conversion -verify %s");
  }

  @Test
  public void test_utf8_allowed_chars_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/utf8-allowed-chars.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/utf8-allowed-chars.c -fsyntax-only -std=c99 -verify
    RUN("%clang_cc1 %s -fsyntax-only -std=c99 -verify");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/utf8-allowed-chars.c -fsyntax-only -std=c11 -Wc99-compat -verify
    RUN("%clang_cc1 %s -fsyntax-only -std=c11 -Wc99-compat -verify");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/utf8-allowed-chars.c -fsyntax-only -x c++ -std=c++03 -Wc++11-compat -verify
    RUN("%clang_cc1 %s -fsyntax-only -x c++ -std=c++03 -Wc++11-compat -verify");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/utf8-allowed-chars.c -fsyntax-only -x c++ -std=c++11 -Wc++98-compat -verify
    RUN("%clang_cc1 %s -fsyntax-only -x c++ -std=c++11 -Wc++98-compat -verify");
  }

  @Test
  public void test_warn_disabled_macro_expansion_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/warn-disabled-macro-expansion.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/warn-disabled-macro-expansion.c -E -Wdisabled-macro-expansion -verify
    RUN("%clang_cc1 %s -E -Wdisabled-macro-expansion -verify");
  }

  @Test
  public void test_warn_macro_unused_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/warn-macro-unused.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/warn-macro-unused.c -Wunused-macros -Dfoo -Dfoo -verify
    RUN("%clang_cc1 %s -Wunused-macros -Dfoo -Dfoo -verify");
  }

  @Test
  public void test_warning_tests_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/warning_tests.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/warning_tests.c -verify
    RUN("%clang_cc1 -fsyntax-only %s -verify");
  }

  @Test
  public void test_wasm_target_features_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/wasm-target-features.c");
    // ${LLVM_SRC}/build/bin/clang -E -dM ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/wasm-target-features.c -o - 2>&1 -target wasm32-unknown-unknown -msimd128 | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/wasm-target-features.c -check-prefix=SIMD128
    RUN("%clang -E -dM %s -o - 2>&1 -target wasm32-unknown-unknown -msimd128")./*|*/
      I("FileCheck %s -check-prefix=SIMD128");
    // ${LLVM_SRC}/build/bin/clang -E -dM ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/wasm-target-features.c -o - 2>&1 -target wasm64-unknown-unknown -msimd128 | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/wasm-target-features.c -check-prefix=SIMD128
    RUN("%clang -E -dM %s -o - 2>&1 -target wasm64-unknown-unknown -msimd128")./*|*/
      I("FileCheck %s -check-prefix=SIMD128");
    // ${LLVM_SRC}/build/bin/clang -E -dM ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/wasm-target-features.c -o - 2>&1 -target wasm32-unknown-unknown -mcpu=mvp | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/wasm-target-features.c -check-prefix=MVP
    RUN("%clang -E -dM %s -o - 2>&1 -target wasm32-unknown-unknown -mcpu=mvp")./*|*/
      I("FileCheck %s -check-prefix=MVP");
    // ${LLVM_SRC}/build/bin/clang -E -dM ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/wasm-target-features.c -o - 2>&1 -target wasm64-unknown-unknown -mcpu=mvp | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/wasm-target-features.c -check-prefix=MVP
    RUN("%clang -E -dM %s -o - 2>&1 -target wasm64-unknown-unknown -mcpu=mvp")./*|*/
      I("FileCheck %s -check-prefix=MVP");
    // ${LLVM_SRC}/build/bin/clang -E -dM ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/wasm-target-features.c -o - 2>&1 -target wasm32-unknown-unknown -mcpu=bleeding-edge | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/wasm-target-features.c -check-prefix=BLEEDING_EDGE
    RUN("%clang -E -dM %s -o - 2>&1 -target wasm32-unknown-unknown -mcpu=bleeding-edge")./*|*/
      I("FileCheck %s -check-prefix=BLEEDING_EDGE");
    // ${LLVM_SRC}/build/bin/clang -E -dM ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/wasm-target-features.c -o - 2>&1 -target wasm64-unknown-unknown -mcpu=bleeding-edge | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/wasm-target-features.c -check-prefix=BLEEDING_EDGE
    RUN("%clang -E -dM %s -o - 2>&1 -target wasm64-unknown-unknown -mcpu=bleeding-edge")./*|*/
      I("FileCheck %s -check-prefix=BLEEDING_EDGE");
    // ${LLVM_SRC}/build/bin/clang -E -dM ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/wasm-target-features.c -o - 2>&1 -target wasm32-unknown-unknown -mcpu=bleeding-edge -mno-simd128 | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/wasm-target-features.c -check-prefix=BLEEDING_EDGE_NO_SIMD128
    RUN("%clang -E -dM %s -o - 2>&1 -target wasm32-unknown-unknown -mcpu=bleeding-edge -mno-simd128")./*|*/
      I("FileCheck %s -check-prefix=BLEEDING_EDGE_NO_SIMD128");
    // ${LLVM_SRC}/build/bin/clang -E -dM ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/wasm-target-features.c -o - 2>&1 -target wasm64-unknown-unknown -mcpu=bleeding-edge -mno-simd128 | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/wasm-target-features.c -check-prefix=BLEEDING_EDGE_NO_SIMD128
    RUN("%clang -E -dM %s -o - 2>&1 -target wasm64-unknown-unknown -mcpu=bleeding-edge -mno-simd128")./*|*/
      I("FileCheck %s -check-prefix=BLEEDING_EDGE_NO_SIMD128");
  }

  @Test
  public void test_woa_defaults_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/woa-defaults.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -dM -triple armv7-windows -E ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/woa-defaults.c | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/woa-defaults.c
    RUN("%clang_cc1 -dM -triple armv7-windows -E %s")./*|*/
      I("FileCheck %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -dM -fno-signed-char -triple armv7-windows -E ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/woa-defaults.c | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/woa-defaults.c -check-prefix CHECK-UNSIGNED-CHAR
    RUN("%clang_cc1 -dM -fno-signed-char -triple armv7-windows -E %s")./*|*/
      I("FileCheck %s -check-prefix CHECK-UNSIGNED-CHAR");
  }

  @Test
  public void test_woa_wchar_t_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/woa-wchar_t.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -dM -triple armv7-windows -E ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/woa-wchar_t.c | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/woa-wchar_t.c
    RUN("%clang_cc1 -dM -triple armv7-windows -E %s")./*|*/
      I("FileCheck %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -dM -fno-signed-char -triple armv7-windows -E ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/woa-wchar_t.c | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/woa-wchar_t.c
    RUN("%clang_cc1 -dM -fno-signed-char -triple armv7-windows -E %s")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_x86_target_features_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/x86_target_features.c");
    // ${LLVM_SRC}/build/bin/clang -target i386-unknown-unknown -march=core2 -msse4 -x c -E -dM -o - ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/x86_target_features.c | ${LLVM_SRC}/build/bin/FileCheck -match-full-lines --check-prefix=SSE4 ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/x86_target_features.c
    RUN("%clang -target i386-unknown-unknown -march=core2 -msse4 -x c -E -dM -o - %s")./*|*/
      I("FileCheck -match-full-lines --check-prefix=SSE4 %s");
    // ${LLVM_SRC}/build/bin/clang -target i386-unknown-unknown -march=core2 -msse4.1 -mno-sse4 -x c -E -dM -o - ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/x86_target_features.c | ${LLVM_SRC}/build/bin/FileCheck -match-full-lines --check-prefix=NOSSE4 ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/x86_target_features.c
    RUN("%clang -target i386-unknown-unknown -march=core2 -msse4.1 -mno-sse4 -x c -E -dM -o - %s")./*|*/
      I("FileCheck -match-full-lines --check-prefix=NOSSE4 %s");
    // ${LLVM_SRC}/build/bin/clang -target i386-unknown-unknown -march=core2 -msse4 -mno-sse2 -x c -E -dM -o - ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/x86_target_features.c | ${LLVM_SRC}/build/bin/FileCheck -match-full-lines --check-prefix=SSE ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/x86_target_features.c
    RUN("%clang -target i386-unknown-unknown -march=core2 -msse4 -mno-sse2 -x c -E -dM -o - %s")./*|*/
      I("FileCheck -match-full-lines --check-prefix=SSE %s");
    // ${LLVM_SRC}/build/bin/clang -target i386-unknown-unknown -march=pentium-m -x c -E -dM -o - ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/x86_target_features.c | ${LLVM_SRC}/build/bin/FileCheck -match-full-lines --check-prefix=SSE2 ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/x86_target_features.c
    RUN("%clang -target i386-unknown-unknown -march=pentium-m -x c -E -dM -o - %s")./*|*/
      I("FileCheck -match-full-lines --check-prefix=SSE2 %s");
    // ${LLVM_SRC}/build/bin/clang -target i386-unknown-unknown -march=pentium-m -mno-sse -mavx -x c -E -dM -o - ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/x86_target_features.c | ${LLVM_SRC}/build/bin/FileCheck -match-full-lines --check-prefix=AVX ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/x86_target_features.c
    RUN("%clang -target i386-unknown-unknown -march=pentium-m -mno-sse -mavx -x c -E -dM -o - %s")./*|*/
      I("FileCheck -match-full-lines --check-prefix=AVX %s");
    // ${LLVM_SRC}/build/bin/clang -target i386-unknown-unknown -march=pentium-m -mxop -mno-avx -x c -E -dM -o - ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/x86_target_features.c | ${LLVM_SRC}/build/bin/FileCheck -match-full-lines --check-prefix=SSE4A ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/x86_target_features.c
    RUN("%clang -target i386-unknown-unknown -march=pentium-m -mxop -mno-avx -x c -E -dM -o - %s")./*|*/
      I("FileCheck -match-full-lines --check-prefix=SSE4A %s");
    // ${LLVM_SRC}/build/bin/clang -target i386-unknown-unknown -march=atom -mavx512f -x c -E -dM -o - ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/x86_target_features.c | ${LLVM_SRC}/build/bin/FileCheck -match-full-lines --check-prefix=AVX512F ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/x86_target_features.c
    RUN("%clang -target i386-unknown-unknown -march=atom -mavx512f -x c -E -dM -o - %s")./*|*/
      I("FileCheck -match-full-lines --check-prefix=AVX512F %s");
    // ${LLVM_SRC}/build/bin/clang -target i386-unknown-unknown -march=atom -mavx512cd -x c -E -dM -o - ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/x86_target_features.c | ${LLVM_SRC}/build/bin/FileCheck -match-full-lines --check-prefix=AVX512CD ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/x86_target_features.c
    RUN("%clang -target i386-unknown-unknown -march=atom -mavx512cd -x c -E -dM -o - %s")./*|*/
      I("FileCheck -match-full-lines --check-prefix=AVX512CD %s");
    // ${LLVM_SRC}/build/bin/clang -target i386-unknown-unknown -march=atom -mavx512er -x c -E -dM -o - ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/x86_target_features.c | ${LLVM_SRC}/build/bin/FileCheck -match-full-lines --check-prefix=AVX512ER ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/x86_target_features.c
    RUN("%clang -target i386-unknown-unknown -march=atom -mavx512er -x c -E -dM -o - %s")./*|*/
      I("FileCheck -match-full-lines --check-prefix=AVX512ER %s");
    // ${LLVM_SRC}/build/bin/clang -target i386-unknown-unknown -march=atom -mavx512pf -x c -E -dM -o - ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/x86_target_features.c | ${LLVM_SRC}/build/bin/FileCheck -match-full-lines --check-prefix=AVX512PF ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/x86_target_features.c
    RUN("%clang -target i386-unknown-unknown -march=atom -mavx512pf -x c -E -dM -o - %s")./*|*/
      I("FileCheck -match-full-lines --check-prefix=AVX512PF %s");
    // ${LLVM_SRC}/build/bin/clang -target i386-unknown-unknown -march=atom -mavx512dq -x c -E -dM -o - ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/x86_target_features.c | ${LLVM_SRC}/build/bin/FileCheck -match-full-lines --check-prefix=AVX512DQ ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/x86_target_features.c
    RUN("%clang -target i386-unknown-unknown -march=atom -mavx512dq -x c -E -dM -o - %s")./*|*/
      I("FileCheck -match-full-lines --check-prefix=AVX512DQ %s");
    // ${LLVM_SRC}/build/bin/clang -target i386-unknown-unknown -march=atom -mavx512bw -x c -E -dM -o - ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/x86_target_features.c | ${LLVM_SRC}/build/bin/FileCheck -match-full-lines --check-prefix=AVX512BW ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/x86_target_features.c
    RUN("%clang -target i386-unknown-unknown -march=atom -mavx512bw -x c -E -dM -o - %s")./*|*/
      I("FileCheck -match-full-lines --check-prefix=AVX512BW %s");
    // ${LLVM_SRC}/build/bin/clang -target i386-unknown-unknown -march=atom -mavx512vl -x c -E -dM -o - ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/x86_target_features.c | ${LLVM_SRC}/build/bin/FileCheck -match-full-lines --check-prefix=AVX512VL ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/x86_target_features.c
    RUN("%clang -target i386-unknown-unknown -march=atom -mavx512vl -x c -E -dM -o - %s")./*|*/
      I("FileCheck -match-full-lines --check-prefix=AVX512VL %s");
    // ${LLVM_SRC}/build/bin/clang -target i386-unknown-unknown -march=atom -mavx512pf -mno-avx512f -x c -E -dM -o - ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/x86_target_features.c | ${LLVM_SRC}/build/bin/FileCheck -match-full-lines --check-prefix=AVX512F2 ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/x86_target_features.c
    RUN("%clang -target i386-unknown-unknown -march=atom -mavx512pf -mno-avx512f -x c -E -dM -o - %s")./*|*/
      I("FileCheck -match-full-lines --check-prefix=AVX512F2 %s");
    // ${LLVM_SRC}/build/bin/clang -target i386-unknown-unknown -march=atom -mavx512ifma -x c -E -dM -o - ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/x86_target_features.c | ${LLVM_SRC}/build/bin/FileCheck -match-full-lines --check-prefix=AVX512IFMA ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/x86_target_features.c
    RUN("%clang -target i386-unknown-unknown -march=atom -mavx512ifma -x c -E -dM -o - %s")./*|*/
      I("FileCheck -match-full-lines --check-prefix=AVX512IFMA %s");
    // ${LLVM_SRC}/build/bin/clang -target i386-unknown-unknown -march=atom -mavx512vbmi -x c -E -dM -o - ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/x86_target_features.c | ${LLVM_SRC}/build/bin/FileCheck -match-full-lines --check-prefix=AVX512VBMI ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/x86_target_features.c
    RUN("%clang -target i386-unknown-unknown -march=atom -mavx512vbmi -x c -E -dM -o - %s")./*|*/
      I("FileCheck -match-full-lines --check-prefix=AVX512VBMI %s");
    // ${LLVM_SRC}/build/bin/clang -target i386-unknown-unknown -march=atom -msse4.2 -x c -E -dM -o - ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/x86_target_features.c | ${LLVM_SRC}/build/bin/FileCheck -match-full-lines --check-prefix=SSE42POPCNT ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/x86_target_features.c
    RUN("%clang -target i386-unknown-unknown -march=atom -msse4.2 -x c -E -dM -o - %s")./*|*/
      I("FileCheck -match-full-lines --check-prefix=SSE42POPCNT %s");
    // ${LLVM_SRC}/build/bin/clang -target i386-unknown-unknown -march=atom -mno-popcnt -msse4.2 -x c -E -dM -o - ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/x86_target_features.c | ${LLVM_SRC}/build/bin/FileCheck -match-full-lines --check-prefix=SSE42NOPOPCNT ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/x86_target_features.c
    RUN("%clang -target i386-unknown-unknown -march=atom -mno-popcnt -msse4.2 -x c -E -dM -o - %s")./*|*/
      I("FileCheck -match-full-lines --check-prefix=SSE42NOPOPCNT %s");
    // ${LLVM_SRC}/build/bin/clang -target i386-unknown-unknown -march=atom -mpopcnt -mno-sse4.2 -x c -E -dM -o - ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/x86_target_features.c | ${LLVM_SRC}/build/bin/FileCheck -match-full-lines --check-prefix=NOSSE42POPCNT ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/x86_target_features.c
    RUN("%clang -target i386-unknown-unknown -march=atom -mpopcnt -mno-sse4.2 -x c -E -dM -o - %s")./*|*/
      I("FileCheck -match-full-lines --check-prefix=NOSSE42POPCNT %s");
    // ${LLVM_SRC}/build/bin/clang -target i386-unknown-unknown -march=atom -msse -x c -E -dM -o - ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/x86_target_features.c | ${LLVM_SRC}/build/bin/FileCheck -match-full-lines --check-prefix=SSEMMX ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/x86_target_features.c
    RUN("%clang -target i386-unknown-unknown -march=atom -msse -x c -E -dM -o - %s")./*|*/
      I("FileCheck -match-full-lines --check-prefix=SSEMMX %s");
    // ${LLVM_SRC}/build/bin/clang -target i386-unknown-unknown -march=atom -msse -mno-sse -x c -E -dM -o - ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/x86_target_features.c | ${LLVM_SRC}/build/bin/FileCheck -match-full-lines --check-prefix=SSENOSSEMMX ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/x86_target_features.c
    RUN("%clang -target i386-unknown-unknown -march=atom -msse -mno-sse -x c -E -dM -o - %s")./*|*/
      I("FileCheck -match-full-lines --check-prefix=SSENOSSEMMX %s");
    // ${LLVM_SRC}/build/bin/clang -target i386-unknown-unknown -march=atom -msse -mno-mmx -x c -E -dM -o - ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/x86_target_features.c | ${LLVM_SRC}/build/bin/FileCheck -match-full-lines --check-prefix=SSENOMMX ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/x86_target_features.c
    RUN("%clang -target i386-unknown-unknown -march=atom -msse -mno-mmx -x c -E -dM -o - %s")./*|*/
      I("FileCheck -match-full-lines --check-prefix=SSENOMMX %s");
    // ${LLVM_SRC}/build/bin/clang -target i386-unknown-unknown -march=atom -mf16c -x c -E -dM -o - ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/x86_target_features.c | ${LLVM_SRC}/build/bin/FileCheck -match-full-lines --check-prefix=F16C ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/x86_target_features.c
    RUN("%clang -target i386-unknown-unknown -march=atom -mf16c -x c -E -dM -o - %s")./*|*/
      I("FileCheck -match-full-lines --check-prefix=F16C %s");
    // ${LLVM_SRC}/build/bin/clang -target i386-unknown-unknown -march=atom -mf16c -mno-avx -x c -E -dM -o - ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/x86_target_features.c | ${LLVM_SRC}/build/bin/FileCheck -match-full-lines --check-prefix=F16CNOAVX ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/x86_target_features.c
    RUN("%clang -target i386-unknown-unknown -march=atom -mf16c -mno-avx -x c -E -dM -o - %s")./*|*/
      I("FileCheck -match-full-lines --check-prefix=F16CNOAVX %s");
    // ${LLVM_SRC}/build/bin/clang -target i386-unknown-unknown -march=pentiumpro -mpclmul -x c -E -dM -o - ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/x86_target_features.c | ${LLVM_SRC}/build/bin/FileCheck -match-full-lines --check-prefix=PCLMUL ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/x86_target_features.c
    RUN("%clang -target i386-unknown-unknown -march=pentiumpro -mpclmul -x c -E -dM -o - %s")./*|*/
      I("FileCheck -match-full-lines --check-prefix=PCLMUL %s");
    // ${LLVM_SRC}/build/bin/clang -target i386-unknown-unknown -march=pentiumpro -mpclmul -mno-sse2 -x c -E -dM -o - ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/x86_target_features.c | ${LLVM_SRC}/build/bin/FileCheck -match-full-lines --check-prefix=PCLMULNOSSE2 ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/x86_target_features.c
    RUN("%clang -target i386-unknown-unknown -march=pentiumpro -mpclmul -mno-sse2 -x c -E -dM -o - %s")./*|*/
      I("FileCheck -match-full-lines --check-prefix=PCLMULNOSSE2 %s");
    // ${LLVM_SRC}/build/bin/clang -target i386-unknown-unknown -march=pentiumpro -maes -x c -E -dM -o - ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/x86_target_features.c | ${LLVM_SRC}/build/bin/FileCheck -match-full-lines --check-prefix=AES ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/x86_target_features.c
    RUN("%clang -target i386-unknown-unknown -march=pentiumpro -maes -x c -E -dM -o - %s")./*|*/
      I("FileCheck -match-full-lines --check-prefix=AES %s");
    // ${LLVM_SRC}/build/bin/clang -target i386-unknown-unknown -march=pentiumpro -maes -mno-sse2 -x c -E -dM -o - ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/x86_target_features.c | ${LLVM_SRC}/build/bin/FileCheck -match-full-lines --check-prefix=AESNOSSE2 ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/x86_target_features.c
    RUN("%clang -target i386-unknown-unknown -march=pentiumpro -maes -mno-sse2 -x c -E -dM -o - %s")./*|*/
      I("FileCheck -match-full-lines --check-prefix=AESNOSSE2 %s");
    // ${LLVM_SRC}/build/bin/clang -target i386-unknown-unknown -march=pentiumpro -msha -x c -E -dM -o - ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/x86_target_features.c | ${LLVM_SRC}/build/bin/FileCheck -match-full-lines --check-prefix=SHA ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/x86_target_features.c
    RUN("%clang -target i386-unknown-unknown -march=pentiumpro -msha -x c -E -dM -o - %s")./*|*/
      I("FileCheck -match-full-lines --check-prefix=SHA %s");
    // ${LLVM_SRC}/build/bin/clang -target i386-unknown-unknown -march=pentiumpro -msha -mno-sha -x c -E -dM -o - ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/x86_target_features.c | ${LLVM_SRC}/build/bin/FileCheck -match-full-lines --check-prefix=SHANOSHA ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/x86_target_features.c
    RUN("%clang -target i386-unknown-unknown -march=pentiumpro -msha -mno-sha -x c -E -dM -o - %s")./*|*/
      I("FileCheck -match-full-lines --check-prefix=SHANOSHA %s");
    // ${LLVM_SRC}/build/bin/clang -target i386-unknown-unknown -march=pentiumpro -msha -mno-sse2 -x c -E -dM -o - ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/x86_target_features.c | ${LLVM_SRC}/build/bin/FileCheck -match-full-lines --check-prefix=SHANOSSE2 ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/x86_target_features.c
    RUN("%clang -target i386-unknown-unknown -march=pentiumpro -msha -mno-sse2 -x c -E -dM -o - %s")./*|*/
      I("FileCheck -match-full-lines --check-prefix=SHANOSSE2 %s");
    // ${LLVM_SRC}/build/bin/clang -target i386-unknown-unknown -march=atom -mtbm -x c -E -dM -o - ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/x86_target_features.c | ${LLVM_SRC}/build/bin/FileCheck -match-full-lines --check-prefix=TBM ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/x86_target_features.c
    RUN("%clang -target i386-unknown-unknown -march=atom -mtbm -x c -E -dM -o - %s")./*|*/
      I("FileCheck -match-full-lines --check-prefix=TBM %s");
    // ${LLVM_SRC}/build/bin/clang -target i386-unknown-unknown -march=bdver2 -mno-tbm -x c -E -dM -o - ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/x86_target_features.c | ${LLVM_SRC}/build/bin/FileCheck -match-full-lines --check-prefix=NOTBM ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/x86_target_features.c
    RUN("%clang -target i386-unknown-unknown -march=bdver2 -mno-tbm -x c -E -dM -o - %s")./*|*/
      I("FileCheck -match-full-lines --check-prefix=NOTBM %s");
    // ${LLVM_SRC}/build/bin/clang -target i386-unknown-unknown -march=pentiumpro -mcx16 -x c -E -dM -o - ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/x86_target_features.c | ${LLVM_SRC}/build/bin/FileCheck -match-full-lines --check-prefix=MCX16 ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/x86_target_features.c
    RUN("%clang -target i386-unknown-unknown -march=pentiumpro -mcx16 -x c -E -dM -o - %s")./*|*/
      I("FileCheck -match-full-lines --check-prefix=MCX16 %s");
    // ${LLVM_SRC}/build/bin/clang -target i386-unknown-unknown -march=atom -mprfchw -x c -E -dM -o - ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/x86_target_features.c | ${LLVM_SRC}/build/bin/FileCheck -match-full-lines --check-prefix=PRFCHW ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/x86_target_features.c
    RUN("%clang -target i386-unknown-unknown -march=atom -mprfchw -x c -E -dM -o - %s")./*|*/
      I("FileCheck -match-full-lines --check-prefix=PRFCHW %s");
    // ${LLVM_SRC}/build/bin/clang -target i386-unknown-unknown -march=btver2 -mno-prfchw -x c -E -dM -o - ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/x86_target_features.c | ${LLVM_SRC}/build/bin/FileCheck -match-full-lines --check-prefix=NOPRFCHW ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/x86_target_features.c
    RUN("%clang -target i386-unknown-unknown -march=btver2 -mno-prfchw -x c -E -dM -o - %s")./*|*/
      I("FileCheck -match-full-lines --check-prefix=NOPRFCHW %s");
    // ${LLVM_SRC}/build/bin/clang -target i386-unknown-unknown -march=atom -m3dnow -x c -E -dM -o - ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/x86_target_features.c | ${LLVM_SRC}/build/bin/FileCheck -match-full-lines --check-prefix=3DNOWPRFCHW ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/x86_target_features.c
    RUN("%clang -target i386-unknown-unknown -march=atom -m3dnow -x c -E -dM -o - %s")./*|*/
      I("FileCheck -match-full-lines --check-prefix=3DNOWPRFCHW %s");
    // ${LLVM_SRC}/build/bin/clang -target i386-unknown-unknown -march=atom -mno-prfchw -m3dnow -x c -E -dM -o - ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/x86_target_features.c | ${LLVM_SRC}/build/bin/FileCheck -match-full-lines --check-prefix=3DNOWNOPRFCHW ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/x86_target_features.c
    RUN("%clang -target i386-unknown-unknown -march=atom -mno-prfchw -m3dnow -x c -E -dM -o - %s")./*|*/
      I("FileCheck -match-full-lines --check-prefix=3DNOWNOPRFCHW %s");
    // ${LLVM_SRC}/build/bin/clang -target i386-unknown-unknown -march=atom -mprfchw -mno-3dnow -x c -E -dM -o - ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/x86_target_features.c | ${LLVM_SRC}/build/bin/FileCheck -match-full-lines --check-prefix=NO3DNOWPRFCHW ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/x86_target_features.c
    RUN("%clang -target i386-unknown-unknown -march=atom -mprfchw -mno-3dnow -x c -E -dM -o - %s")./*|*/
      I("FileCheck -match-full-lines --check-prefix=NO3DNOWPRFCHW %s");
    // ${LLVM_SRC}/build/bin/clang -target i386-unknown-unknown -march=atom -madx -x c -E -dM -o - ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/x86_target_features.c | ${LLVM_SRC}/build/bin/FileCheck -match-full-lines --check-prefix=ADX ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/x86_target_features.c
    RUN("%clang -target i386-unknown-unknown -march=atom -madx -x c -E -dM -o - %s")./*|*/
      I("FileCheck -match-full-lines --check-prefix=ADX %s");
    // ${LLVM_SRC}/build/bin/clang -target i386-unknown-unknown -march=atom -mrdseed -x c -E -dM -o - ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/x86_target_features.c | ${LLVM_SRC}/build/bin/FileCheck -match-full-lines --check-prefix=RDSEED ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/x86_target_features.c
    RUN("%clang -target i386-unknown-unknown -march=atom -mrdseed -x c -E -dM -o - %s")./*|*/
      I("FileCheck -match-full-lines --check-prefix=RDSEED %s");
    // ${LLVM_SRC}/build/bin/clang -target i386-unknown-unknown -march=atom -mxsave -x c -E -dM -o - ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/x86_target_features.c | ${LLVM_SRC}/build/bin/FileCheck -match-full-lines --check-prefix=XSAVE ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/x86_target_features.c
    RUN("%clang -target i386-unknown-unknown -march=atom -mxsave -x c -E -dM -o - %s")./*|*/
      I("FileCheck -match-full-lines --check-prefix=XSAVE %s");
    // ${LLVM_SRC}/build/bin/clang -target i386-unknown-unknown -march=atom -mxsaveopt -x c -E -dM -o - ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/x86_target_features.c | ${LLVM_SRC}/build/bin/FileCheck -match-full-lines --check-prefix=XSAVEOPT ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/x86_target_features.c
    RUN("%clang -target i386-unknown-unknown -march=atom -mxsaveopt -x c -E -dM -o - %s")./*|*/
      I("FileCheck -match-full-lines --check-prefix=XSAVEOPT %s");
    // ${LLVM_SRC}/build/bin/clang -target i386-unknown-unknown -march=atom -mxsavec -x c -E -dM -o - ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/x86_target_features.c | ${LLVM_SRC}/build/bin/FileCheck -match-full-lines --check-prefix=XSAVEC ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/x86_target_features.c
    RUN("%clang -target i386-unknown-unknown -march=atom -mxsavec -x c -E -dM -o - %s")./*|*/
      I("FileCheck -match-full-lines --check-prefix=XSAVEC %s");
    // ${LLVM_SRC}/build/bin/clang -target i386-unknown-unknown -march=atom -mxsaves -x c -E -dM -o - ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/x86_target_features.c | ${LLVM_SRC}/build/bin/FileCheck -match-full-lines --check-prefix=XSAVES ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/x86_target_features.c
    RUN("%clang -target i386-unknown-unknown -march=atom -mxsaves -x c -E -dM -o - %s")./*|*/
      I("FileCheck -match-full-lines --check-prefix=XSAVES %s");
    // ${LLVM_SRC}/build/bin/clang -target i386-unknown-unknown -march=atom -mxsaveopt -mno-xsave -x c -E -dM -o - ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/x86_target_features.c | ${LLVM_SRC}/build/bin/FileCheck -match-full-lines --check-prefix=NOXSAVE ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/x86_target_features.c
    RUN("%clang -target i386-unknown-unknown -march=atom -mxsaveopt -mno-xsave -x c -E -dM -o - %s")./*|*/
      I("FileCheck -match-full-lines --check-prefix=NOXSAVE %s");
  }
  
}
