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
 * Collection of all test files from test/CodeGenObjC folder
 * @author Vladimir Voskresensky
 */
@Ignore
public class AllClangCodeGenObjCTest extends DriverTestFileBase {
  private static final String TEST_LOCATION = "${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/";
  public AllClangCodeGenObjCTest() {
    super(TEST_LOCATION, TestState.Successful);
  }
  
  public static void main(String[] args) {
    // Print tests which will be accepted per test case
    DriverTestFileBase.printAllTestFiles(false, TEST_LOCATION, (test)->{ return true;/*test.getFileIndexInFolder()<120;*/ }, 
            "${SPUTNIK}/modules/org.clang.codegen/test/unit/src/org/clang/codegen/test/AllClangCodeGenObjCTest.txt");
  }  

  @Override
  protected boolean keepStacksForUnimplementedMethods() {
    return false;
  }
  
  @Test
  public void test_2007_04_03_ObjcEH_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/2007-04-03-ObjcEH.m");
    // ${LLVM_SRC}/build/bin/clang -fexceptions -S -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/2007-04-03-ObjcEH.m -o -
    RUN(TestState.Failed, "%clang -fexceptions -S -emit-llvm %s -o -");
  }

  @Test
  public void test_2007_05_02_Strong_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/2007-05-02-Strong.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -S ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/2007-05-02-Strong.m -fobjc-gc -o /dev/null
    RUN(TestState.Failed, "%clang_cc1 -S %s -fobjc-gc -o /dev/null");
  }

  @Test
  public void test_2007_10_18_ProDescriptor_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/2007-10-18-ProDescriptor.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/2007-10-18-ProDescriptor.m -o /dev/null
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm %s -o /dev/null");
  }

  @Test
  public void test_2007_10_23_GC_WriteBarrier_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/2007-10-23-GC-WriteBarrier.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/2007-10-23-GC-WriteBarrier.m -o /dev/null -fobjc-gc
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm %s -o /dev/null -fobjc-gc");
  }

  @Test
  public void test_2008_08_25_incompatible_cond_expr_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/2008-08-25-incompatible-cond-expr.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm -o ${TEST_TEMP_DIR}/2008-08-25-incompatible-cond-expr.m.tmp ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/2008-08-25-incompatible-cond-expr.m
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm -o %t %s");
  }

  @Test
  public void test_2008_10_23_invalid_icmp_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/2008-10-23-invalid-icmp.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm -o ${TEST_TEMP_DIR}/2008-10-23-invalid-icmp.m.tmp ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/2008-10-23-invalid-icmp.m
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm -o %t %s");
  }

  @Test
  public void test_2008_10_3_EhValue_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/2008-10-3-EhValue.m");
    // ${LLVM_SRC}/build/bin/clang -fexceptions -fobjc-exceptions -S -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/2008-10-3-EhValue.m -o /dev/null
    RUN(TestState.Failed, "%clang -fexceptions -fobjc-exceptions -S -emit-llvm  %s -o /dev/null");
  }

  @Test
  public void test_2008_11_12_Metadata_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/2008-11-12-Metadata.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm -triple x86_64-apple-darwin -fobjc-runtime=macosx-fragile-10.5 ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/2008-11-12-Metadata.m -o /dev/null
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm -triple x86_64-apple-darwin -fobjc-runtime=macosx-fragile-10.5 %s -o /dev/null");
  }

  @Test
  public void test_2008_11_24_ConstCFStrings_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/2008-11-24-ConstCFStrings.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm -triple x86_64-apple-darwin -fobjc-runtime=macosx-fragile-10.5 ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/2008-11-24-ConstCFStrings.m -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/2008-11-24-ConstCFStrings.m
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm -triple x86_64-apple-darwin -fobjc-runtime=macosx-fragile-10.5 %s -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_2008_11_25_Blocks_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/2008-11-25-Blocks.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fblocks -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/2008-11-25-Blocks.m -o /dev/null
    RUN(TestState.Failed, "%clang_cc1 -fblocks -emit-llvm %s -o /dev/null");
  }

  @Test
  public void test_2009_01_21_invalid_debug_info_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/2009-01-21-invalid-debug-info.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -S -debug-info-kind=limited -o ${TEST_TEMP_DIR}/2009-01-21-invalid-debug-info.m.tmp.s ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/2009-01-21-invalid-debug-info.m
    RUN(TestState.Failed, "%clang_cc1 -S -debug-info-kind=limited -o %t.s %s");
  }

  @Test
  public void test_2009_01_26_WriteBarrier_2_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/2009-01-26-WriteBarrier-2.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fblocks -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/2009-01-26-WriteBarrier-2.m -fobjc-gc -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/2009-01-26-WriteBarrier-2.m
    RUN(TestState.Failed, "%clang_cc1 -fblocks -emit-llvm %s -fobjc-gc -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_2009_02_05_VolatileProp_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/2009-02-05-VolatileProp.m");
    // ${LLVM_SRC}/build/bin/clang -fexceptions -S -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/2009-02-05-VolatileProp.m -o /dev/null -pedantic-errors
    RUN(TestState.Failed, "%clang -fexceptions -S -emit-llvm %s -o /dev/null -pedantic-errors");
  }

  @Test
  public void test_2009_08_05_utf16_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/2009-08-05-utf16.m");
    // REQUIRES: x86-registered-target
    if (!CHECK_REQUIRES("x86-registered-target")) {
      return;
    }
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-macho -emit-llvm -w -x objective-c ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/2009-08-05-utf16.m -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/2009-08-05-utf16.m
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-macho -emit-llvm -w -x objective-c %s -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_2010_02_01_utf16_with_null_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/2010-02-01-utf16-with-null.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i686-apple-darwin -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/2010-02-01-utf16-with-null.m -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/2010-02-01-utf16-with-null.m
    RUN(TestState.Failed, "%clang_cc1 -triple i686-apple-darwin -emit-llvm %s -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_2010_02_09_DbgSelf_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/2010-02-09-DbgSelf.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x objective-c -emit-llvm -debug-info-kind=limited < ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/2010-02-09-DbgSelf.m | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/2010-02-09-DbgSelf.m
    RUN(TestState.Failed, "%clang_cc1 -x objective-c -emit-llvm -debug-info-kind=limited < %s")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_2010_02_15_Dbg_MethodStart_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/2010-02-15-Dbg-MethodStart.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x objective-c -emit-llvm -debug-info-kind=limited < ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/2010-02-15-Dbg-MethodStart.m | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/2010-02-15-Dbg-MethodStart.m
    RUN(TestState.Failed, "%clang_cc1 -x objective-c -emit-llvm -debug-info-kind=limited < %s")./*|*/
      I("FileCheck \"%s\"");
  }

  @Test
  public void test_2010_02_23_DbgInheritance_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/2010-02-23-DbgInheritance.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/2010-02-23-DbgInheritance.m -debug-info-kind=limited -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/2010-02-23-DbgInheritance.m
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm %s -debug-info-kind=limited -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_2010_03_17_StructRef_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/2010-03-17-StructRef.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/2010-03-17-StructRef.m -emit-llvm -triple x86_64-apple-darwin -fobjc-runtime=macosx-fragile-10.5 -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/2010-03-17-StructRef.m
    RUN(TestState.Failed, "%clang_cc1 %s -emit-llvm -triple x86_64-apple-darwin -fobjc-runtime=macosx-fragile-10.5 -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_2011_03_08_IVarLookup_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/2011-03-08-IVarLookup.m");
    // ${LLVM_SRC}/build/bin/clang -S -emit-llvm -m64 -fobjc-abi-version=2 ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/2011-03-08-IVarLookup.m -o /dev/null
    RUN(TestState.Failed, "%clang -S -emit-llvm -m64 -fobjc-abi-version=2 %s -o /dev/null");
  }

  @Test
  public void test_arc_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/arc.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-apple-darwin10 -emit-llvm -fblocks -fobjc-arc -fobjc-runtime-has-weak -O2 -disable-llvm-optzns -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/arc.m | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/arc.m
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-apple-darwin10 -emit-llvm -fblocks -fobjc-arc -fobjc-runtime-has-weak -O2 -disable-llvm-optzns -o - %s")./*|*/
      I("FileCheck %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-apple-darwin10 -emit-llvm -fblocks -fobjc-arc -fobjc-runtime-has-weak -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/arc.m | ${LLVM_SRC}/build/bin/FileCheck -check-prefix=CHECK-GLOBALS ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/arc.m
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-apple-darwin10 -emit-llvm -fblocks -fobjc-arc -fobjc-runtime-has-weak -o - %s")./*|*/
      I("FileCheck -check-prefix=CHECK-GLOBALS %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fobjc-runtime=macosx-10.6.0 -triple x86_64-apple-darwin10 -emit-llvm -fblocks -fobjc-arc -fobjc-runtime-has-weak -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/arc.m | ${LLVM_SRC}/build/bin/FileCheck -check-prefix=ARC-ALIEN ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/arc.m
    RUN(TestState.Failed, "%clang_cc1 -fobjc-runtime=macosx-10.6.0 -triple x86_64-apple-darwin10 -emit-llvm -fblocks -fobjc-arc -fobjc-runtime-has-weak -o - %s")./*|*/
      I("FileCheck -check-prefix=ARC-ALIEN %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fobjc-runtime=macosx-10.7.0 -triple x86_64-apple-darwin11 -emit-llvm -fblocks -fobjc-arc -fobjc-runtime-has-weak -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/arc.m | ${LLVM_SRC}/build/bin/FileCheck -check-prefix=ARC-NATIVE ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/arc.m
    RUN(TestState.Failed, "%clang_cc1 -fobjc-runtime=macosx-10.7.0 -triple x86_64-apple-darwin11 -emit-llvm -fblocks -fobjc-arc -fobjc-runtime-has-weak -o - %s")./*|*/
      I("FileCheck -check-prefix=ARC-NATIVE %s");
  }

  @Test
  public void test_arc_arm_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/arc-arm.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple armv7-apple-darwin10 -emit-llvm -fblocks -fobjc-arc -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/arc-arm.m | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/arc-arm.m
    RUN(TestState.Failed, "%clang_cc1 -triple armv7-apple-darwin10 -emit-llvm -fblocks -fobjc-arc -o - %s")./*|*/
      I("FileCheck %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple arm64-apple-ios -emit-llvm -fblocks -fobjc-arc -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/arc-arm.m | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/arc-arm.m
    RUN(TestState.Failed, "%clang_cc1 -triple arm64-apple-ios -emit-llvm -fblocks -fobjc-arc -o - %s")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_arc_block_copy_escape_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/arc-block-copy-escape.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fobjc-arc -fblocks -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/arc-block-copy-escape.m -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/arc-block-copy-escape.m
    RUN(TestState.Failed, "%clang_cc1 -fobjc-arc -fblocks -emit-llvm %s -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_arc_blocks_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/arc-blocks.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-apple-darwin10 -emit-llvm -fblocks -fobjc-arc -fobjc-runtime-has-weak -O2 -disable-llvm-optzns -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/arc-blocks.m | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/arc-blocks.m
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-apple-darwin10 -emit-llvm -fblocks -fobjc-arc -fobjc-runtime-has-weak -O2 -disable-llvm-optzns -o - %s")./*|*/
      I("FileCheck %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-apple-darwin10 -emit-llvm -fblocks -fobjc-arc -fobjc-runtime-has-weak -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/arc-blocks.m | ${LLVM_SRC}/build/bin/FileCheck -check-prefix=CHECK-UNOPT ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/arc-blocks.m
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-apple-darwin10 -emit-llvm -fblocks -fobjc-arc -fobjc-runtime-has-weak -o - %s")./*|*/
      I("FileCheck -check-prefix=CHECK-UNOPT %s");
  }

  @Test
  public void test_arc_bridged_cast_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/arc-bridged-cast.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-apple-darwin10 -emit-llvm -fblocks -fobjc-arc -O2 -disable-llvm-optzns -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/arc-bridged-cast.m | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/arc-bridged-cast.m
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-apple-darwin10 -emit-llvm -fblocks -fobjc-arc -O2 -disable-llvm-optzns -o - %s")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_arc_captured_32bit_block_var_layout_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/arc-captured-32bit-block-var-layout.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fblocks -fobjc-arc -fobjc-runtime-has-weak -triple i386-apple-darwin -print-ivar-layout -emit-llvm -o /dev/null ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/arc-captured-32bit-block-var-layout.m > ${TEST_TEMP_DIR}/arc-captured-32bit-block-var-layout.m.tmp-32.layout
    RUN(TestState.Failed, "%clang_cc1 -fblocks -fobjc-arc -fobjc-runtime-has-weak -triple i386-apple-darwin -print-ivar-layout -emit-llvm -o /dev/null %s > %t-32.layout");
    // ${LLVM_SRC}/build/bin/FileCheck '--input-file=${TEST_TEMP_DIR}/arc-captured-32bit-block-var-layout.m.tmp-32.layout' ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/arc-captured-32bit-block-var-layout.m
    RUN(TestState.Failed, "FileCheck --input-file=%t-32.layout %s");
  }

  @Test
  public void test_arc_captured_32bit_block_var_layout_2_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/arc-captured-32bit-block-var-layout-2.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fblocks -fobjc-arc -fobjc-runtime-has-weak -triple i386-apple-darwin -print-ivar-layout -emit-llvm -o /dev/null ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/arc-captured-32bit-block-var-layout-2.m > ${TEST_TEMP_DIR}/arc-captured-32bit-block-var-layout-2.m.tmp-32.layout
    RUN(TestState.Failed, "%clang_cc1 -fblocks -fobjc-arc -fobjc-runtime-has-weak -triple i386-apple-darwin -print-ivar-layout -emit-llvm -o /dev/null %s > %t-32.layout");
    // ${LLVM_SRC}/build/bin/FileCheck '--input-file=${TEST_TEMP_DIR}/arc-captured-32bit-block-var-layout-2.m.tmp-32.layout' ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/arc-captured-32bit-block-var-layout-2.m
    RUN(TestState.Failed, "FileCheck --input-file=%t-32.layout %s");
  }

  @Test
  public void test_arc_captured_block_var_inlined_layout_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/arc-captured-block-var-inlined-layout.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fblocks -fobjc-arc -fobjc-runtime-has-weak -triple x86_64-apple-darwin -print-ivar-layout -emit-llvm -o /dev/null ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/arc-captured-block-var-inlined-layout.m > ${TEST_TEMP_DIR}/arc-captured-block-var-inlined-layout.m.tmp-64.layout
    RUN(TestState.Failed, "%clang_cc1 -fblocks -fobjc-arc -fobjc-runtime-has-weak -triple x86_64-apple-darwin -print-ivar-layout -emit-llvm -o /dev/null %s > %t-64.layout");
    // ${LLVM_SRC}/build/bin/FileCheck -check-prefix=CHECK -check-prefix=CHECK-64 '--input-file=${TEST_TEMP_DIR}/arc-captured-block-var-inlined-layout.m.tmp-64.layout' ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/arc-captured-block-var-inlined-layout.m
    RUN(TestState.Failed, "FileCheck -check-prefix=CHECK -check-prefix=CHECK-64 --input-file=%t-64.layout %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fblocks -fobjc-arc -fobjc-runtime-has-weak -triple i386-apple-darwin -print-ivar-layout -emit-llvm -o /dev/null ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/arc-captured-block-var-inlined-layout.m > ${TEST_TEMP_DIR}/arc-captured-block-var-inlined-layout.m.tmp-32.layout
    RUN(TestState.Failed, "%clang_cc1 -fblocks -fobjc-arc -fobjc-runtime-has-weak -triple i386-apple-darwin -print-ivar-layout -emit-llvm -o /dev/null  %s > %t-32.layout");
    // ${LLVM_SRC}/build/bin/FileCheck -check-prefix=CHECK -check-prefix=CHECK-32 '--input-file=${TEST_TEMP_DIR}/arc-captured-block-var-inlined-layout.m.tmp-32.layout' ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/arc-captured-block-var-inlined-layout.m
    RUN(TestState.Failed, "FileCheck -check-prefix=CHECK -check-prefix=CHECK-32 --input-file=%t-32.layout %s");
  }

  @Test
  public void test_arc_captured_block_var_layout_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/arc-captured-block-var-layout.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fblocks -fobjc-arc -fobjc-runtime-has-weak -triple x86_64-apple-darwin -print-ivar-layout -emit-llvm -o /dev/null ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/arc-captured-block-var-layout.m > ${TEST_TEMP_DIR}/arc-captured-block-var-layout.m.tmp-64.layout
    RUN(TestState.Failed, "%clang_cc1 -fblocks -fobjc-arc -fobjc-runtime-has-weak -triple x86_64-apple-darwin -print-ivar-layout -emit-llvm -o /dev/null %s > %t-64.layout");
    // ${LLVM_SRC}/build/bin/FileCheck -check-prefix CHECK-LP64 '--input-file=${TEST_TEMP_DIR}/arc-captured-block-var-layout.m.tmp-64.layout' ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/arc-captured-block-var-layout.m
    RUN(TestState.Failed, "FileCheck -check-prefix CHECK-LP64 --input-file=%t-64.layout %s");
  }

  @Test
  public void test_arc_compound_stmt_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/arc-compound-stmt.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-apple-darwin10 -emit-llvm -fobjc-arc -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/arc-compound-stmt.m
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-apple-darwin10 -emit-llvm -fobjc-arc -o - %s");
  }

  @Test
  public void test_arc_cond_stmt_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/arc-cond-stmt.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-apple-darwin10 -emit-llvm -fobjc-arc -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/arc-cond-stmt.m
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-apple-darwin10 -emit-llvm -fobjc-arc -o - %s");
  }

  @Test
  public void test_arc_exceptions_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/arc-exceptions.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-apple-darwin10 -emit-llvm -fobjc-arc -fexceptions -fobjc-exceptions -fobjc-runtime-has-weak -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/arc-exceptions.m | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/arc-exceptions.m
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-apple-darwin10 -emit-llvm -fobjc-arc -fexceptions -fobjc-exceptions -fobjc-runtime-has-weak -o - %s")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_arc_foreach_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/arc-foreach.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fblocks -fobjc-arc -fobjc-runtime-has-weak -triple x86_64-apple-darwin -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/arc-foreach.m -o ${TEST_TEMP_DIR}/arc-foreach.m.tmp-64.s
    RUN(TestState.Failed, "%clang_cc1 -fblocks -fobjc-arc -fobjc-runtime-has-weak -triple x86_64-apple-darwin -emit-llvm %s -o %t-64.s");
    // ${LLVM_SRC}/build/bin/FileCheck -check-prefix CHECK-LP64 '--input-file=${TEST_TEMP_DIR}/arc-foreach.m.tmp-64.s' ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/arc-foreach.m
    RUN(TestState.Failed, "FileCheck -check-prefix CHECK-LP64 --input-file=%t-64.s %s");
  }

  @Test
  public void test_arc_i386_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/arc-i386.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i386-apple-darwin10 -emit-llvm -fblocks -fobjc-arc -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/arc-i386.m | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/arc-i386.m
    RUN(TestState.Failed, "%clang_cc1 -triple i386-apple-darwin10 -emit-llvm -fblocks -fobjc-arc -o - %s")./*|*/
      I("FileCheck %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i386-apple-iossimulator6.0 -emit-llvm -fblocks -fobjc-arc -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/arc-i386.m | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/arc-i386.m
    RUN(TestState.Failed, "%clang_cc1 -triple i386-apple-iossimulator6.0 -emit-llvm -fblocks -fobjc-arc -o - %s")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_arc_ivar_layout_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/arc-ivar-layout.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fobjc-arc -fobjc-runtime-has-weak -triple x86_64-apple-darwin -print-ivar-layout -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/arc-ivar-layout.m -o ${TEST_TEMP_DIR}/arc-ivar-layout.m.tmp-64.s | ${LLVM_SRC}/build/bin/FileCheck -check-prefix CHECK-LP64 ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/arc-ivar-layout.m
    RUN(TestState.Failed, "%clang_cc1 -fobjc-arc -fobjc-runtime-has-weak -triple x86_64-apple-darwin -print-ivar-layout -emit-llvm %s -o %t-64.s")./*|*/
      I("FileCheck -check-prefix CHECK-LP64 %s");
  }

  @Test
  public void test_arc_linetable_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/arc-linetable.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm -fblocks -fobjc-arc -debug-info-kind=standalone -dwarf-version=4 -disable-llvm-passes -triple x86_64-apple-darwin10 ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/arc-linetable.m -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/arc-linetable.m
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm -fblocks -fobjc-arc -debug-info-kind=standalone -dwarf-version=4 -disable-llvm-passes -triple x86_64-apple-darwin10 %s -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_arc_linetable_autorelease_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/arc-linetable-autorelease.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm -fobjc-arc -debug-info-kind=limited -triple x86_64-apple-darwin10 ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/arc-linetable-autorelease.m -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/arc-linetable-autorelease.m
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm -fobjc-arc -debug-info-kind=limited -triple x86_64-apple-darwin10 %s -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_arc_literals_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/arc-literals.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -I ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/Inputs -triple x86_64-apple-darwin10 -emit-llvm -fblocks -fobjc-arc -fobjc-runtime-has-weak -O2 -disable-llvm-optzns -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/arc-literals.m | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/arc-literals.m
    RUN(TestState.Failed, "%clang_cc1 -I %S/Inputs -triple x86_64-apple-darwin10 -emit-llvm -fblocks -fobjc-arc -fobjc-runtime-has-weak -O2 -disable-llvm-optzns -o - %s")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_arc_loadweakretained_release_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/arc-loadweakretained-release.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-apple-darwin10 -emit-llvm -fblocks -fobjc-arc -fobjc-runtime-has-weak -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/arc-loadweakretained-release.m | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/arc-loadweakretained-release.m
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-apple-darwin10 -emit-llvm -fblocks -fobjc-arc -fobjc-runtime-has-weak -o - %s")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_arc_no_arc_exceptions_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/arc-no-arc-exceptions.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-apple-darwin10 -emit-llvm -fobjc-arc -fblocks -fexceptions -fobjc-exceptions -O2 -disable-llvm-optzns -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/arc-no-arc-exceptions.m | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/arc-no-arc-exceptions.m
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-apple-darwin10 -emit-llvm -fobjc-arc -fblocks -fexceptions -fobjc-exceptions -O2 -disable-llvm-optzns -o - %s")./*|*/
      I("FileCheck %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-apple-darwin10 -emit-llvm -fobjc-arc -fblocks -fexceptions -fobjc-exceptions -disable-llvm-optzns -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/arc-no-arc-exceptions.m | ${LLVM_SRC}/build/bin/FileCheck -check-prefix=NO-METADATA ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/arc-no-arc-exceptions.m
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-apple-darwin10 -emit-llvm -fobjc-arc -fblocks -fexceptions -fobjc-exceptions -disable-llvm-optzns -o - %s")./*|*/
      I("FileCheck -check-prefix=NO-METADATA %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-apple-darwin10 -emit-llvm -fobjc-arc -fblocks -fexceptions -fobjc-exceptions -O2 -disable-llvm-optzns -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/arc-no-arc-exceptions.m -fobjc-arc-exceptions | ${LLVM_SRC}/build/bin/FileCheck -check-prefix=NO-METADATA ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/arc-no-arc-exceptions.m
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-apple-darwin10 -emit-llvm -fobjc-arc -fblocks -fexceptions -fobjc-exceptions -O2 -disable-llvm-optzns -o - %s -fobjc-arc-exceptions")./*|*/
      I("FileCheck -check-prefix=NO-METADATA %s");
  }

  @Test
  public void test_arc_no_runtime_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/arc-no-runtime.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-apple-darwin10 -fobjc-arc -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/arc-no-runtime.m -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/arc-no-runtime.m
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-apple-darwin10 -fobjc-arc -emit-llvm %s -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_arc_precise_lifetime_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/arc-precise-lifetime.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-apple-darwin10 -emit-llvm -fblocks -fobjc-arc -fobjc-runtime-has-weak -O2 -disable-llvm-optzns -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/arc-precise-lifetime.m | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/arc-precise-lifetime.m
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-apple-darwin10 -emit-llvm -fblocks -fobjc-arc -fobjc-runtime-has-weak -O2 -disable-llvm-optzns -o - %s")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_arc_property_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/arc-property.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-apple-darwin10 -fobjc-arc -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/arc-property.m -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/arc-property.m
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-apple-darwin10 -fobjc-arc -emit-llvm %s -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_arc_related_result_type_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/arc-related-result-type.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-apple-darwin10 -emit-llvm -fblocks -fobjc-arc -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/arc-related-result-type.m | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/arc-related-result-type.m
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-apple-darwin10 -emit-llvm -fblocks -fobjc-arc -o - %s")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_arc_ternary_op_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/arc-ternary-op.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-apple-darwin10 -emit-llvm -fblocks -fobjc-arc -fobjc-runtime-has-weak -O2 -disable-llvm-optzns -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/arc-ternary-op.m | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/arc-ternary-op.m
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-apple-darwin10 -emit-llvm -fblocks -fobjc-arc -fobjc-runtime-has-weak -O2 -disable-llvm-optzns -o - %s")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_arc_unbridged_cast_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/arc-unbridged-cast.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-apple-darwin11 -emit-llvm -fobjc-arc -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/arc-unbridged-cast.m | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/arc-unbridged-cast.m
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-apple-darwin11 -emit-llvm  -fobjc-arc -o - %s")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_arc_unopt_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/arc-unopt.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-apple-darwin10 -emit-llvm -fobjc-runtime-has-weak -fblocks -fobjc-arc -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/arc-unopt.m | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/arc-unopt.m
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-apple-darwin10 -emit-llvm -fobjc-runtime-has-weak -fblocks -fobjc-arc -o - %s")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_arc_unoptimized_byref_var_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/arc-unoptimized-byref-var.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-apple-darwin10 -emit-llvm -fblocks -fobjc-arc -fobjc-runtime-has-weak -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/arc-unoptimized-byref-var.m | ${LLVM_SRC}/build/bin/FileCheck -check-prefix=CHECK-UNOPT ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/arc-unoptimized-byref-var.m
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-apple-darwin10 -emit-llvm -fblocks -fobjc-arc -fobjc-runtime-has-weak -o - %s")./*|*/
      I("FileCheck -check-prefix=CHECK-UNOPT %s");
  }

  @Test
  public void test_arc_unsafeclaim_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/arc-unsafeclaim.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-apple-darwin11 -fobjc-runtime=macosx-10.11 -fobjc-arc -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/arc-unsafeclaim.m | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/arc-unsafeclaim.m -check-prefix=CHECK -check-prefix=CHECK-UNOPTIMIZED
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-apple-darwin11 -fobjc-runtime=macosx-10.11 -fobjc-arc -emit-llvm -o - %s")./*|*/
      I("FileCheck %s -check-prefix=CHECK -check-prefix=CHECK-UNOPTIMIZED");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple arm64-apple-ios9 -fobjc-runtime=ios-9.0 -fobjc-arc -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/arc-unsafeclaim.m | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/arc-unsafeclaim.m -check-prefix=CHECK -check-prefix=CHECK-UNOPTIMIZED -check-prefix=CHECK-MARKED
    RUN(TestState.Failed, "%clang_cc1 -triple arm64-apple-ios9 -fobjc-runtime=ios-9.0 -fobjc-arc -emit-llvm -o - %s")./*|*/
      I("FileCheck %s -check-prefix=CHECK -check-prefix=CHECK-UNOPTIMIZED -check-prefix=CHECK-MARKED");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple arm64-apple-ios9 -fobjc-runtime=ios-9.0 -fobjc-arc -O -disable-llvm-optzns -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/arc-unsafeclaim.m | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/arc-unsafeclaim.m -check-prefix=CHECK -check-prefix=CHECK-OPTIMIZED
    RUN(TestState.Failed, "%clang_cc1 -triple arm64-apple-ios9 -fobjc-runtime=ios-9.0 -fobjc-arc -O -disable-llvm-optzns -emit-llvm -o - %s")./*|*/
      I("FileCheck %s -check-prefix=CHECK -check-prefix=CHECK-OPTIMIZED");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple armv7-apple-ios9 -fobjc-runtime=ios-9.0 -fobjc-arc -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/arc-unsafeclaim.m | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/arc-unsafeclaim.m -check-prefix=CHECK -check-prefix=CHECK-UNOPTIMIZED -check-prefix=CHECK-MARKED
    RUN(TestState.Failed, "%clang_cc1 -triple armv7-apple-ios9 -fobjc-runtime=ios-9.0 -fobjc-arc -emit-llvm -o - %s")./*|*/
      I("FileCheck %s -check-prefix=CHECK -check-prefix=CHECK-UNOPTIMIZED -check-prefix=CHECK-MARKED");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple armv7-apple-ios9 -fobjc-runtime=ios-9.0 -fobjc-arc -O -disable-llvm-optzns -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/arc-unsafeclaim.m | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/arc-unsafeclaim.m -check-prefix=CHECK -check-prefix=CHECK-OPTIMIZED
    RUN(TestState.Failed, "%clang_cc1 -triple armv7-apple-ios9 -fobjc-runtime=ios-9.0 -fobjc-arc -O -disable-llvm-optzns -emit-llvm -o - %s")./*|*/
      I("FileCheck %s -check-prefix=CHECK -check-prefix=CHECK-OPTIMIZED");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-apple-darwin10 -fobjc-runtime=macosx-10.10 -fobjc-arc -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/arc-unsafeclaim.m | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/arc-unsafeclaim.m -check-prefix=DISABLED
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-apple-darwin10 -fobjc-runtime=macosx-10.10 -fobjc-arc -emit-llvm -o - %s")./*|*/
      I("FileCheck %s -check-prefix=DISABLED");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple arm64-apple-ios8 -fobjc-runtime=ios-8 -fobjc-arc -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/arc-unsafeclaim.m | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/arc-unsafeclaim.m -check-prefix=DISABLED -check-prefix=DISABLED-MARKED
    RUN(TestState.Failed, "%clang_cc1 -triple arm64-apple-ios8 -fobjc-runtime=ios-8 -fobjc-arc -emit-llvm -o - %s")./*|*/
      I("FileCheck %s -check-prefix=DISABLED -check-prefix=DISABLED-MARKED");
  }

  @Test
  public void test_arc_weak_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/arc-weak.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-apple-darwin10 -emit-llvm -fblocks -fobjc-arc -fobjc-runtime-has-weak -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/arc-weak.m | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/arc-weak.m
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-apple-darwin10 -emit-llvm -fblocks -fobjc-arc -fobjc-runtime-has-weak -o - %s")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_arc_weak_property_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/arc-weak-property.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-apple-darwin10 -emit-llvm -fobjc-runtime-has-weak -fblocks -fobjc-arc -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/arc-weak-property.m | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/arc-weak-property.m
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-apple-darwin10 -emit-llvm -fobjc-runtime-has-weak -fblocks -fobjc-arc -o - %s")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_arc_with_atthrow_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/arc-with-atthrow.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-apple-darwin10 -emit-llvm -fobjc-arc -fobjc-exceptions -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/arc-with-atthrow.m | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/arc-with-atthrow.m
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-apple-darwin10 -emit-llvm -fobjc-arc -fobjc-exceptions -o - %s")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_arm_atomic_scalar_setter_getter_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/arm-atomic-scalar-setter-getter.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple armv7-apple-darwin10 -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/arm-atomic-scalar-setter-getter.m | ${LLVM_SRC}/build/bin/FileCheck -check-prefix=CHECK-ARM ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/arm-atomic-scalar-setter-getter.m
    RUN(TestState.Failed, "%clang_cc1 -triple armv7-apple-darwin10 -emit-llvm -o - %s")./*|*/
      I("FileCheck -check-prefix=CHECK-ARM %s");
  }

  @Test
  public void test_arm64_int32_ivar_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/arm64-int32-ivar.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple arm64-apple-ios -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/arm64-int32-ivar.m | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/arm64-int32-ivar.m
    RUN(TestState.Failed, "%clang_cc1 -triple arm64-apple-ios -emit-llvm  -o - %s")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_assign_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/assign.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64 -fobjc-runtime=macosx-fragile-10.5 -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/assign.m | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/assign.m
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64 -fobjc-runtime=macosx-fragile-10.5 -emit-llvm -o - %s")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_atomic_aggregate_property_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/atomic-aggregate-property.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-apple-darwin10 -fobjc-gc -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/atomic-aggregate-property.m | ${LLVM_SRC}/build/bin/FileCheck -check-prefix CHECK-LP64 ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/atomic-aggregate-property.m
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-apple-darwin10  -fobjc-gc -emit-llvm -o - %s")./*|*/
      I("FileCheck -check-prefix CHECK-LP64 %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x objective-c++ -triple x86_64-apple-darwin10 -fobjc-gc -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/atomic-aggregate-property.m | ${LLVM_SRC}/build/bin/FileCheck -check-prefix CHECK-LP64 ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/atomic-aggregate-property.m
    RUN(TestState.Failed, "%clang_cc1 -x objective-c++ -triple x86_64-apple-darwin10  -fobjc-gc -emit-llvm -o - %s")./*|*/
      I("FileCheck -check-prefix CHECK-LP64 %s");
  }

  @Test
  public void test_attr_availability_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/attr-availability.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fvisibility hidden -triple x86_64-apple-darwin8.0.0 -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/attr-availability.m | ${LLVM_SRC}/build/bin/FileCheck -check-prefix=CHECK-10_4 ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/attr-availability.m
    RUN(TestState.Failed, "%clang_cc1 -fvisibility hidden \"-triple\" \"x86_64-apple-darwin8.0.0\" -emit-llvm -o - %s")./*|*/
      I("FileCheck -check-prefix=CHECK-10_4 %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fvisibility hidden -triple x86_64-apple-darwin9.0.0 -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/attr-availability.m | ${LLVM_SRC}/build/bin/FileCheck -check-prefix=CHECK-10_5 ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/attr-availability.m
    RUN(TestState.Failed, "%clang_cc1 -fvisibility hidden \"-triple\" \"x86_64-apple-darwin9.0.0\" -emit-llvm -o - %s")./*|*/
      I("FileCheck -check-prefix=CHECK-10_5 %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fvisibility hidden -triple x86_64-apple-darwin10.0.0 -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/attr-availability.m | ${LLVM_SRC}/build/bin/FileCheck -check-prefix=CHECK-10_6 ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/attr-availability.m
    RUN(TestState.Failed, "%clang_cc1 -fvisibility hidden \"-triple\" \"x86_64-apple-darwin10.0.0\" -emit-llvm -o - %s")./*|*/
      I("FileCheck -check-prefix=CHECK-10_6 %s");
  }

  @Test
  public void test_attr_callconv_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/attr-callconv.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i386-unknown-unknown -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/attr-callconv.m | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/attr-callconv.m
    RUN(TestState.Failed, "%clang_cc1 -triple i386-unknown-unknown -emit-llvm -o - %s")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_attr_exception_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/attr-exception.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-apple-darwin10 -emit-llvm -fexceptions -fobjc-exceptions -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/attr-exception.m | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/attr-exception.m
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-apple-darwin10 -emit-llvm -fexceptions -fobjc-exceptions -o - %s")./*|*/
      I("FileCheck %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-apple-darwin10 -emit-llvm -fexceptions -fobjc-exceptions -fvisibility hidden -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/attr-exception.m | ${LLVM_SRC}/build/bin/FileCheck -check-prefix=CHECK-HIDDEN ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/attr-exception.m
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-apple-darwin10 -emit-llvm -fexceptions -fobjc-exceptions -fvisibility hidden -o - %s")./*|*/
      I("FileCheck -check-prefix=CHECK-HIDDEN %s");
  }

  @Test
  public void test_attr_minsize_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/attr-minsize.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/attr-minsize.m | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/attr-minsize.m
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm -o - %s")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_attr_noreturn_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/attr-noreturn.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-apple-darwin10 -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/attr-noreturn.m | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/attr-noreturn.m -check-prefix=CHECK -check-prefix=CHECK-MRC
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-apple-darwin10 -emit-llvm -o - %s")./*|*/
      I("FileCheck %s -check-prefix=CHECK -check-prefix=CHECK-MRC");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-apple-darwin10 -emit-llvm -fobjc-arc -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/attr-noreturn.m | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/attr-noreturn.m -check-prefix=CHECK -check-prefix=CHECK-ARC
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-apple-darwin10 -emit-llvm -fobjc-arc -o - %s")./*|*/
      I("FileCheck %s -check-prefix=CHECK -check-prefix=CHECK-ARC");
  }

  @Test
  public void test_attr_objc_runtime_visible_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/attr-objc-runtime-visible.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-apple-darwin -fobjc-runtime=macosx-10.9.0 -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/attr-objc-runtime-visible.m -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/attr-objc-runtime-visible.m
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-apple-darwin -fobjc-runtime=macosx-10.9.0 -emit-llvm %s -o -")./*|*/
      I("FileCheck %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i386-apple-darwin -fobjc-runtime=macosx-fragile-10.9.0 -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/attr-objc-runtime-visible.m -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/attr-objc-runtime-visible.m
    RUN(TestState.Failed, "%clang_cc1 -triple i386-apple-darwin -fobjc-runtime=macosx-fragile-10.9.0 -emit-llvm %s -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_attr_strong_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/attr-strong.c");
    // ${LLVM_SRC}/build/bin/clang -emit-llvm -S -o ${TEST_TEMP_DIR}/attr-strong.c.tmp ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/attr-strong.c
    RUN(TestState.Failed, "%clang -emit-llvm -S -o %t %s");
  }

  @Test
  public void test_auto_property_synthesize_protocol_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/auto-property-synthesize-protocol.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-apple-darwin -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/auto-property-synthesize-protocol.m -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/auto-property-synthesize-protocol.m
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-apple-darwin -emit-llvm  %s -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_autorelease_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/autorelease.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-apple-darwin10 -emit-llvm -fobjc-arc -fobjc-runtime=macosx-10.7 -fexceptions -fobjc-exceptions -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/autorelease.m | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/autorelease.m
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-apple-darwin10 -emit-llvm -fobjc-arc -fobjc-runtime=macosx-10.7 -fexceptions -fobjc-exceptions -o - %s")./*|*/
      I("FileCheck %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-apple-darwin11 -emit-llvm -fobjc-runtime=macosx-10.7 -fexceptions -fobjc-exceptions -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/autorelease.m | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/autorelease.m
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-apple-darwin11 -emit-llvm -fobjc-runtime=macosx-10.7 -fexceptions -fobjc-exceptions -o - %s")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_bitfield_1_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/bitfield-1.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-apple-darwin9 -fobjc-runtime=macosx-fragile-10.5 -emit-llvm -o ${TEST_TEMP_DIR}/bitfield-1.m.tmp ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/bitfield-1.m
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-apple-darwin9 -fobjc-runtime=macosx-fragile-10.5 -emit-llvm -o %t %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i386-apple-darwin9 -fobjc-runtime=macosx-fragile-10.5 -emit-llvm -o ${TEST_TEMP_DIR}/bitfield-1.m.tmp ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/bitfield-1.m
    RUN(TestState.Failed, "%clang_cc1 -triple i386-apple-darwin9 -fobjc-runtime=macosx-fragile-10.5 -emit-llvm -o %t %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i386-pc-linux-gnu -fobjc-runtime=macosx-fragile-10.5 -emit-llvm -o ${TEST_TEMP_DIR}/bitfield-1.m.tmp ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/bitfield-1.m
    RUN(TestState.Failed, "%clang_cc1 -triple i386-pc-linux-gnu -fobjc-runtime=macosx-fragile-10.5 -emit-llvm -o %t %s");
  }

  @Test
  public void test_bitfield_access_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/bitfield-access.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i386-apple-darwin10 -fobjc-runtime=macosx-fragile-10.5 -emit-llvm -o ${TEST_TEMP_DIR}/bitfield-access.m.tmp1 ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/bitfield-access.m
    RUN(TestState.Failed, "%clang_cc1 -triple i386-apple-darwin10 -fobjc-runtime=macosx-fragile-10.5 -emit-llvm -o %t1 %s");
    // ${LLVM_SRC}/build/bin/FileCheck -check-prefix=CHECK-I386 < ${TEST_TEMP_DIR}/bitfield-access.m.tmp1 ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/bitfield-access.m
    RUN(TestState.Failed, "FileCheck -check-prefix=CHECK-I386 < %t1 %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple armv6-apple-darwin10 -fobjc-runtime=macosx-fragile-10.5 -target-abi apcs-gnu -emit-llvm -o ${TEST_TEMP_DIR}/bitfield-access.m.tmp2 ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/bitfield-access.m
    RUN(TestState.Failed, "%clang_cc1 -triple armv6-apple-darwin10 -fobjc-runtime=macosx-fragile-10.5 -target-abi apcs-gnu -emit-llvm -o %t2 %s");
    // ${LLVM_SRC}/build/bin/FileCheck -check-prefix=CHECK-ARM < ${TEST_TEMP_DIR}/bitfield-access.m.tmp2 ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/bitfield-access.m
    RUN(TestState.Failed, "FileCheck -check-prefix=CHECK-ARM < %t2 %s");
  }

  @Test
  public void test_bitfield_gnu_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/bitfield-gnu.m");
    // ${LLVM_SRC}/build/bin/clang -S -emit-llvm -fobjc-runtime=gcc -o ${TEST_TEMP_DIR}/bitfield-gnu.m.tmp ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/bitfield-gnu.m
    RUN(TestState.Failed, "%clang -S -emit-llvm -fobjc-runtime=gcc -o %t %s");
  }

  @Test
  public void test_bitfield_ivar_metadata_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/bitfield-ivar-metadata.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm -o ${TEST_TEMP_DIR}/bitfield-ivar-metadata.m.tmp ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/bitfield-ivar-metadata.m
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm -o %t %s");
  }

  @Test
  public void test_bitfield_ivar_offsets_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/bitfield-ivar-offsets.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-apple-darwin10 -emit-llvm -o ${TEST_TEMP_DIR}/bitfield-ivar-offsets.m.tmp ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/bitfield-ivar-offsets.m
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-apple-darwin10 -emit-llvm -o %t %s");
    // grep -F '@"OBJC_IVAR_$_I0._b0" = global i64 0, section "__DATA, __objc_ivar", align 8' ${TEST_TEMP_DIR}/bitfield-ivar-offsets.m.tmp
    RUN(TestState.Failed, "grep -F '@\"OBJC_IVAR_$_I0._b0\" = global i64 0, section \"__DATA, __objc_ivar\", align 8' %t");
    // grep -F '@"OBJC_IVAR_$_I0._b1" = global i64 0, section "__DATA, __objc_ivar", align 8' ${TEST_TEMP_DIR}/bitfield-ivar-offsets.m.tmp
    RUN(TestState.Failed, "grep -F '@\"OBJC_IVAR_$_I0._b1\" = global i64 0, section \"__DATA, __objc_ivar\", align 8' %t");
    // grep -F '@"OBJC_IVAR_$_I0._b2" = global i64 1, section "__DATA, __objc_ivar", align 8' ${TEST_TEMP_DIR}/bitfield-ivar-offsets.m.tmp
    RUN(TestState.Failed, "grep -F '@\"OBJC_IVAR_$_I0._b2\" = global i64 1, section \"__DATA, __objc_ivar\", align 8' %t");
    // grep -F '@"OBJC_IVAR_$_I0._x" = global i64 2, section "__DATA, __objc_ivar", align 8' ${TEST_TEMP_DIR}/bitfield-ivar-offsets.m.tmp
    RUN(TestState.Failed, "grep -F '@\"OBJC_IVAR_$_I0._x\" = global i64 2, section \"__DATA, __objc_ivar\", align 8' %t");
    // grep -F '@"OBJC_IVAR_$_I0._b3" = global i64 4, section "__DATA, __objc_ivar", align 8' ${TEST_TEMP_DIR}/bitfield-ivar-offsets.m.tmp
    RUN(TestState.Failed, "grep -F '@\"OBJC_IVAR_$_I0._b3\" = global i64 4, section \"__DATA, __objc_ivar\", align 8' %t");
    // grep -F '@"OBJC_IVAR_$_I0._y" = global i64 6, section "__DATA, __objc_ivar", align 8' ${TEST_TEMP_DIR}/bitfield-ivar-offsets.m.tmp
    RUN(TestState.Failed, "grep -F '@\"OBJC_IVAR_$_I0._y\" = global i64 6, section \"__DATA, __objc_ivar\", align 8' %t");
    // grep -F '@"OBJC_IVAR_$_I0._b4" = global i64 7, section "__DATA, __objc_ivar", align 8' ${TEST_TEMP_DIR}/bitfield-ivar-offsets.m.tmp
    RUN(TestState.Failed, "grep -F '@\"OBJC_IVAR_$_I0._b4\" = global i64 7, section \"__DATA, __objc_ivar\", align 8' %t");
    // grep -F '@"OBJC_IVAR_$_I0." = global' ${TEST_TEMP_DIR}/bitfield-ivar-offsets.m.tmp
    RUN(TestState.Failed, "not grep -F '@\"OBJC_IVAR_$_I0.\" = global' %t");
  }

  @Test
  public void test_bitfield_encoding_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/bitfield_encoding.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i386-unknown-unknown -fobjc-runtime=macosx-fragile-10.5 -emit-llvm -o ${TEST_TEMP_DIR}/bitfield_encoding.m.tmp ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/bitfield_encoding.m
    RUN(TestState.Failed, "%clang_cc1 -triple i386-unknown-unknown -fobjc-runtime=macosx-fragile-10.5 -emit-llvm -o %t %s");
    // grep ib1b14 ${TEST_TEMP_DIR}/bitfield_encoding.m.tmp | ${LLVM_SRC}/build/bin/count 1
    RUN(TestState.Failed, "grep \"ib1b14\" %t")./*|*/
      I("count 1");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i386-unknown-unknown -fobjc-runtime=macosx-fragile-10.5 -fobjc-runtime=gcc -emit-llvm -o ${TEST_TEMP_DIR}/bitfield_encoding.m.tmp ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/bitfield_encoding.m
    RUN(TestState.Failed, "%clang_cc1 -triple i386-unknown-unknown -fobjc-runtime=macosx-fragile-10.5 -fobjc-runtime=gcc -emit-llvm -o %t %s");
    // grep ib32i1b33i14 ${TEST_TEMP_DIR}/bitfield_encoding.m.tmp | ${LLVM_SRC}/build/bin/count 1
    RUN(TestState.Failed, "grep \"ib32i1b33i14\" %t")./*|*/
      I("count 1");
  }

  @Test
  public void test_block_6_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/block-6.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/block-6.m -emit-llvm -o - -fblocks -triple x86_64-apple-darwin10 -fobjc-runtime=macosx-fragile-10.5 | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/block-6.m
    RUN(TestState.Failed, "%clang_cc1 %s -emit-llvm -o - -fblocks -triple x86_64-apple-darwin10 -fobjc-runtime=macosx-fragile-10.5")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_block_byref_debuginfo_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/block-byref-debuginfo.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fblocks -fobjc-arc -fobjc-runtime-has-weak -debug-info-kind=limited -triple x86_64-apple-darwin -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/block-byref-debuginfo.m -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/block-byref-debuginfo.m
    RUN(TestState.Failed, "%clang_cc1 -fblocks -fobjc-arc -fobjc-runtime-has-weak -debug-info-kind=limited -triple x86_64-apple-darwin -emit-llvm %s -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_block_byref_variable_layout_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/block-byref-variable-layout.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fblocks -fobjc-arc -fobjc-runtime-has-weak -triple x86_64-apple-darwin -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/block-byref-variable-layout.m -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/block-byref-variable-layout.m
    RUN(TestState.Failed, "%clang_cc1 -fblocks -fobjc-arc -fobjc-runtime-has-weak -triple x86_64-apple-darwin -emit-llvm %s -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_block_over_align_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/block-over-align.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fblocks -triple x86_64-apple-darwin -emit-llvm -o /dev/null ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/block-over-align.m
    RUN(TestState.Failed, "%clang_cc1 -fblocks -triple x86_64-apple-darwin -emit-llvm -o /dev/null %s");
  }

  @Test
  public void test_block_var_layout_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/block-var-layout.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fblocks -fobjc-gc -triple x86_64-apple-darwin -fobjc-runtime=macosx-fragile-10.5 -print-ivar-layout -emit-llvm -o /dev/null ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/block-var-layout.m > ${TEST_TEMP_DIR}/block-var-layout.m.tmp-64.layout
    RUN(TestState.Failed, "%clang_cc1 -fblocks -fobjc-gc -triple x86_64-apple-darwin -fobjc-runtime=macosx-fragile-10.5 -print-ivar-layout -emit-llvm -o /dev/null %s > %t-64.layout");
    // ${LLVM_SRC}/build/bin/FileCheck -check-prefix CHECK-LP64 '--input-file=${TEST_TEMP_DIR}/block-var-layout.m.tmp-64.layout' ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/block-var-layout.m
    RUN(TestState.Failed, "FileCheck -check-prefix CHECK-LP64 --input-file=%t-64.layout %s");
  }

  @Test
  public void test_blocks_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/blocks.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i386-apple-darwin9 -fobjc-runtime=macosx-fragile-10.5 -emit-llvm -fblocks -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/blocks.m | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/blocks.m
    RUN(TestState.Failed, "%clang_cc1 -triple i386-apple-darwin9 -fobjc-runtime=macosx-fragile-10.5 -emit-llvm -fblocks -o - %s")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_blocks_1_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/blocks-1.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/blocks-1.m -emit-llvm -o ${TEST_TEMP_DIR}/blocks-1.m.tmp -fobjc-gc -fblocks -triple i386-apple-darwin10 -fobjc-runtime=macosx-fragile-10.5
    RUN(TestState.Failed, "%clang_cc1 %s -emit-llvm -o %t -fobjc-gc -fblocks -triple i386-apple-darwin10 -fobjc-runtime=macosx-fragile-10.5");
    // grep _Block_object_dispose ${TEST_TEMP_DIR}/blocks-1.m.tmp | ${LLVM_SRC}/build/bin/count 6
    RUN(TestState.Failed, "grep \"_Block_object_dispose\" %t")./*|*/
      I("count 6");
    // grep __copy_helper_block_ ${TEST_TEMP_DIR}/blocks-1.m.tmp | ${LLVM_SRC}/build/bin/count 4
    RUN(TestState.Failed, "grep \"__copy_helper_block_\" %t")./*|*/
      I("count 4");
    // grep __destroy_helper_block_ ${TEST_TEMP_DIR}/blocks-1.m.tmp | ${LLVM_SRC}/build/bin/count 4
    RUN(TestState.Failed, "grep \"__destroy_helper_block_\" %t")./*|*/
      I("count 4");
    // grep __Block_byref_object_copy_ ${TEST_TEMP_DIR}/blocks-1.m.tmp | ${LLVM_SRC}/build/bin/count 2
    RUN(TestState.Failed, "grep \"__Block_byref_object_copy_\" %t")./*|*/
      I("count 2");
    // grep __Block_byref_object_dispose_ ${TEST_TEMP_DIR}/blocks-1.m.tmp | ${LLVM_SRC}/build/bin/count 2
    RUN(TestState.Failed, "grep \"__Block_byref_object_dispose_\" %t")./*|*/
      I("count 2");
    // grep 'i32 135)' ${TEST_TEMP_DIR}/blocks-1.m.tmp
    RUN(TestState.Failed, "not grep \"i32 135)\" %t");
    // grep _Block_object_assign ${TEST_TEMP_DIR}/blocks-1.m.tmp | ${LLVM_SRC}/build/bin/count 4
    RUN(TestState.Failed, "grep \"_Block_object_assign\" %t")./*|*/
      I("count 4");
    // grep objc_read_weak ${TEST_TEMP_DIR}/blocks-1.m.tmp | ${LLVM_SRC}/build/bin/count 2
    RUN(TestState.Failed, "grep \"objc_read_weak\" %t")./*|*/
      I("count 2");
    // grep objc_assign_weak ${TEST_TEMP_DIR}/blocks-1.m.tmp | ${LLVM_SRC}/build/bin/count 3
    RUN(TestState.Failed, "grep \"objc_assign_weak\" %t")./*|*/
      I("count 3");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x objective-c++ ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/blocks-1.m -emit-llvm -o ${TEST_TEMP_DIR}/blocks-1.m.tmp -fobjc-gc -fblocks -triple i386-apple-darwin10 -fobjc-runtime=macosx-fragile-10.5
    RUN(TestState.Failed, "%clang_cc1 -x objective-c++ %s -emit-llvm -o %t -fobjc-gc -fblocks -triple i386-apple-darwin10 -fobjc-runtime=macosx-fragile-10.5");
    // grep _Block_object_dispose ${TEST_TEMP_DIR}/blocks-1.m.tmp | ${LLVM_SRC}/build/bin/count 6
    RUN(TestState.Failed, "grep \"_Block_object_dispose\" %t")./*|*/
      I("count 6");
    // grep __copy_helper_block_ ${TEST_TEMP_DIR}/blocks-1.m.tmp | ${LLVM_SRC}/build/bin/count 4
    RUN(TestState.Failed, "grep \"__copy_helper_block_\" %t")./*|*/
      I("count 4");
    // grep __destroy_helper_block_ ${TEST_TEMP_DIR}/blocks-1.m.tmp | ${LLVM_SRC}/build/bin/count 4
    RUN(TestState.Failed, "grep \"__destroy_helper_block_\" %t")./*|*/
      I("count 4");
    // grep __Block_byref_object_copy_ ${TEST_TEMP_DIR}/blocks-1.m.tmp | ${LLVM_SRC}/build/bin/count 2
    RUN(TestState.Failed, "grep \"__Block_byref_object_copy_\" %t")./*|*/
      I("count 2");
    // grep __Block_byref_object_dispose_ ${TEST_TEMP_DIR}/blocks-1.m.tmp | ${LLVM_SRC}/build/bin/count 2
    RUN(TestState.Failed, "grep \"__Block_byref_object_dispose_\" %t")./*|*/
      I("count 2");
    // grep 'i32 135)' ${TEST_TEMP_DIR}/blocks-1.m.tmp
    RUN(TestState.Failed, "not grep \"i32 135)\" %t");
    // grep _Block_object_assign ${TEST_TEMP_DIR}/blocks-1.m.tmp | ${LLVM_SRC}/build/bin/count 4
    RUN(TestState.Failed, "grep \"_Block_object_assign\" %t")./*|*/
      I("count 4");
    // grep objc_read_weak ${TEST_TEMP_DIR}/blocks-1.m.tmp | ${LLVM_SRC}/build/bin/count 2
    RUN(TestState.Failed, "grep \"objc_read_weak\" %t")./*|*/
      I("count 2");
    // grep objc_assign_weak ${TEST_TEMP_DIR}/blocks-1.m.tmp | ${LLVM_SRC}/build/bin/count 3
    RUN(TestState.Failed, "grep \"objc_assign_weak\" %t")./*|*/
      I("count 3");
  }

  @Test
  public void test_blocks_2_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/blocks-2.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/blocks-2.m -emit-llvm -o - -fobjc-gc -fblocks -fexceptions -triple i386-apple-darwin10 -fobjc-runtime=macosx-fragile-10.5 | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/blocks-2.m
    RUN(TestState.Failed, "%clang_cc1 %s -emit-llvm -o - -fobjc-gc -fblocks -fexceptions -triple i386-apple-darwin10 -fobjc-runtime=macosx-fragile-10.5")./*|*/
      I("FileCheck %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/blocks-2.m -emit-llvm -o - -fobjc-gc -fblocks -fexceptions -triple i386-apple-darwin10 -fobjc-runtime=macosx-fragile-10.5 -x objective-c++ | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/blocks-2.m
    RUN(TestState.Failed, "%clang_cc1 %s -emit-llvm -o - -fobjc-gc -fblocks -fexceptions -triple i386-apple-darwin10 -fobjc-runtime=macosx-fragile-10.5 -x objective-c++")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_blocks_3_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/blocks-3.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-apple-darwin9 -fobjc-runtime=macosx-fragile-10.5 -emit-llvm -fblocks -o ${TEST_TEMP_DIR}/blocks-3.m.tmp ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/blocks-3.m
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-apple-darwin9 -fobjc-runtime=macosx-fragile-10.5 -emit-llvm -fblocks -o %t %s");
    // grep object_assign ${TEST_TEMP_DIR}/blocks-3.m.tmp | ${LLVM_SRC}/build/bin/count 11
    RUN(TestState.Failed, "grep 'object_assign' %t")./*|*/
      I("count 11");
    // grep object_dispose ${TEST_TEMP_DIR}/blocks-3.m.tmp | ${LLVM_SRC}/build/bin/count 29
    RUN(TestState.Failed, "grep 'object_dispose' %t")./*|*/
      I("count 29");
  }

  @Test
  public void test_blocks_4_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/blocks-4.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i386-apple-darwin9 -fobjc-runtime=macosx-fragile-10.5 -emit-llvm -fobjc-exceptions -fblocks -o ${TEST_TEMP_DIR}/blocks-4.m.tmp ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/blocks-4.m
    RUN(TestState.Failed, "%clang_cc1 -triple i386-apple-darwin9 -fobjc-runtime=macosx-fragile-10.5 -emit-llvm -fobjc-exceptions -fblocks -o %t %s");
  }

  @Test
  public void test_blocks_5_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/blocks-5.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-apple-darwin9 -fobjc-runtime=macosx-fragile-10.5 -emit-llvm -fblocks -o ${TEST_TEMP_DIR}/blocks-5.m.tmp ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/blocks-5.m
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-apple-darwin9 -fobjc-runtime=macosx-fragile-10.5 -emit-llvm -fblocks -o %t %s");
  }

  @Test
  public void test_blocks_ivar_debug_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/blocks-ivar-debug.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -debug-info-kind=limited ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/blocks-ivar-debug.m -fblocks -S -o ${TEST_TEMP_DIR}/blocks-ivar-debug.m.tmp
    RUN(TestState.Failed, "%clang_cc1 -debug-info-kind=limited %s -fblocks -S -o %t");
  }

  @Test
  public void test_boxing_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/boxing.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-apple-darwin10 -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/boxing.m | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/boxing.m
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-apple-darwin10 -emit-llvm -o - %s")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_builtin_memfns_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/builtin-memfns.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-apple-macosx10.8.0 -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/builtin-memfns.m | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/builtin-memfns.m
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-apple-macosx10.8.0 -emit-llvm -o - %s")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_builtins_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/builtins.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-apple-darwin10 -fobjc-runtime=macosx-fragile-10.5 -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/builtins.m | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/builtins.m
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-apple-darwin10 -fobjc-runtime=macosx-fragile-10.5 -emit-llvm -o - %s")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_catch_lexical_block_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/catch-lexical-block.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -debug-info-kind=limited -fobjc-exceptions -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/catch-lexical-block.m -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/catch-lexical-block.m
    RUN(TestState.Failed, "%clang_cc1 -debug-info-kind=limited -fobjc-exceptions -emit-llvm %s -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_category_class_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/category-class.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i386-apple-darwin9 -fobjc-runtime=macosx-fragile-10.5 -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/category-class.m | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/category-class.m
    RUN(TestState.Failed, "%clang_cc1 -triple i386-apple-darwin9 -fobjc-runtime=macosx-fragile-10.5  -emit-llvm -o - %s")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_category_super_class_meth_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/category-super-class-meth.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/category-super-class-meth.m -emit-llvm -triple x86_64-apple-darwin -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/category-super-class-meth.m
    RUN(TestState.Failed, "%clang_cc1 %s -emit-llvm -triple x86_64-apple-darwin -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_class_getter_dotsyntax_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/class-getter-dotsyntax.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm -o ${TEST_TEMP_DIR}/class-getter-dotsyntax.m.tmp ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/class-getter-dotsyntax.m
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm -o %t %s");
  }

  @Test
  public void test_class_type_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/class-type.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-unknown-unknown -fobjc-runtime=macosx-fragile-10.5 -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/class-type.m
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-unknown-unknown -fobjc-runtime=macosx-fragile-10.5 -emit-llvm -o - %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i386-apple-darwin9 -fobjc-runtime=macosx-fragile-10.5 -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/class-type.m
    RUN(TestState.Failed, "%clang_cc1 -triple i386-apple-darwin9 -fobjc-runtime=macosx-fragile-10.5 -emit-llvm -o - %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-apple-darwin9 -fobjc-runtime=macosx-fragile-10.5 -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/class-type.m
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-apple-darwin9 -fobjc-runtime=macosx-fragile-10.5 -emit-llvm -o - %s");
  }

  @Test
  public void test_compatibility_alias_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/compatibility-alias.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm -o ${TEST_TEMP_DIR}/compatibility-alias.m.tmp ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/compatibility-alias.m
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm -o %t %s");
  }

  @Test
  public void test_complex_double_abi_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/complex-double-abi.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm -triple i386-apple-macosx10.7.2 ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/complex-double-abi.m -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/complex-double-abi.m
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm -triple i386-apple-macosx10.7.2 %s -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_complex_property_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/complex-property.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-apple-darwin10 -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/complex-property.m | ${LLVM_SRC}/build/bin/FileCheck -check-prefix CHECK-LP64 ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/complex-property.m
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-apple-darwin10  -emit-llvm -o - %s")./*|*/
      I("FileCheck -check-prefix CHECK-LP64 %s");
  }

  @Test
  public void test_compound_literal_property_access_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/compound-literal-property-access.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/compound-literal-property-access.m -emit-llvm -triple x86_64-apple-darwin -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/compound-literal-property-access.m
    RUN(TestState.Failed, "%clang_cc1 %s -emit-llvm -triple x86_64-apple-darwin -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_constant_string_class_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/constant-string-class.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i386-apple-darwin9 -fobjc-runtime=macosx-fragile-10.5 -fno-constant-cfstrings -fconstant-string-class Foo -emit-llvm -o ${TEST_TEMP_DIR}/constant-string-class.m.tmp ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/constant-string-class.m
    RUN(TestState.Failed, "%clang_cc1 -triple i386-apple-darwin9 -fobjc-runtime=macosx-fragile-10.5 -fno-constant-cfstrings -fconstant-string-class Foo -emit-llvm -o %t %s");
    // ${LLVM_SRC}/build/bin/FileCheck --check-prefix CHECK-FRAGILE < ${TEST_TEMP_DIR}/constant-string-class.m.tmp ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/constant-string-class.m
    RUN(TestState.Failed, "FileCheck --check-prefix CHECK-FRAGILE < %t %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-apple-darwin10 -fno-constant-cfstrings -fconstant-string-class Foo -emit-llvm -o ${TEST_TEMP_DIR}/constant-string-class.m.tmp ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/constant-string-class.m
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-apple-darwin10 -fno-constant-cfstrings -fconstant-string-class Foo -emit-llvm -o %t %s");
    // ${LLVM_SRC}/build/bin/FileCheck --check-prefix CHECK-NONFRAGILE < ${TEST_TEMP_DIR}/constant-string-class.m.tmp ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/constant-string-class.m
    RUN(TestState.Failed, "FileCheck --check-prefix CHECK-NONFRAGILE < %t %s");
  }

  @Test
  public void test_constant_string_class_1_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/constant-string-class-1.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-apple-darwin10 -fno-constant-cfstrings -fconstant-string-class OFConstantString -emit-llvm -o ${TEST_TEMP_DIR}/constant-string-class-1.m.tmp ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/constant-string-class-1.m
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-apple-darwin10 -fno-constant-cfstrings -fconstant-string-class OFConstantString  -emit-llvm -o %t %s");
  }

  @Test
  public void test_constant_strings_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/constant-strings.m");
    // REQUIRES: x86-registered-target
    if (!CHECK_REQUIRES("x86-registered-target")) {
      return;
    }
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-macho -emit-llvm -o ${TEST_TEMP_DIR}/constant-strings.m.tmp ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/constant-strings.m
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-macho -emit-llvm -o %t %s");
    // ${LLVM_SRC}/build/bin/FileCheck --check-prefix=CHECK-NEXT < ${TEST_TEMP_DIR}/constant-strings.m.tmp ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/constant-strings.m
    RUN(TestState.Failed, "FileCheck --check-prefix=CHECK-NEXT < %t %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-macho -fobjc-runtime=gcc -emit-llvm -o ${TEST_TEMP_DIR}/constant-strings.m.tmp ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/constant-strings.m
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-macho -fobjc-runtime=gcc -emit-llvm -o %t %s");
    // ${LLVM_SRC}/build/bin/FileCheck --check-prefix=CHECK-GNU < ${TEST_TEMP_DIR}/constant-strings.m.tmp ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/constant-strings.m
    RUN(TestState.Failed, "FileCheck --check-prefix=CHECK-GNU < %t %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-macho -fobjc-runtime=gcc -fconstant-string-class NSConstantString -emit-llvm -o ${TEST_TEMP_DIR}/constant-strings.m.tmp ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/constant-strings.m
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-macho -fobjc-runtime=gcc -fconstant-string-class NSConstantString -emit-llvm -o %t %s");
    // ${LLVM_SRC}/build/bin/FileCheck --check-prefix=CHECK-GNU-WITH-CLASS < ${TEST_TEMP_DIR}/constant-strings.m.tmp ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/constant-strings.m
    RUN(TestState.Failed, "FileCheck --check-prefix=CHECK-GNU-WITH-CLASS < %t %s");
  }

  @Test
  public void test_continuation_class_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/continuation-class.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm -o ${TEST_TEMP_DIR}/continuation-class.m.tmp ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/continuation-class.m
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm -o %t %s");
  }

  @Test
  public void test_deadcode_strip_used_var_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/deadcode_strip_used_var.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/deadcode_strip_used_var.m -emit-llvm -o ${TEST_TEMP_DIR}/deadcode_strip_used_var.m.tmp -triple i386-apple-darwin10 -fobjc-runtime=macosx-fragile-10.5
    RUN(TestState.Failed, "%clang_cc1 %s -emit-llvm -o %t -triple i386-apple-darwin10 -fobjc-runtime=macosx-fragile-10.5");
    // grep llvm.used ${TEST_TEMP_DIR}/deadcode_strip_used_var.m.tmp | ${LLVM_SRC}/build/bin/count 1
    RUN(TestState.Failed, "grep \"llvm.used\" %t")./*|*/
      I("count 1");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/deadcode_strip_used_var.m -emit-llvm -o ${TEST_TEMP_DIR}/deadcode_strip_used_var.m.tmp -triple x86_64-apple-darwin10 -fobjc-runtime=macosx-fragile-10.5
    RUN(TestState.Failed, "%clang_cc1 %s -emit-llvm -o %t -triple x86_64-apple-darwin10 -fobjc-runtime=macosx-fragile-10.5");
    // grep llvm.used ${TEST_TEMP_DIR}/deadcode_strip_used_var.m.tmp | ${LLVM_SRC}/build/bin/count 1
    RUN(TestState.Failed, "grep \"llvm.used\" %t")./*|*/
      I("count 1");
  }

  @Test
  public void test_debug_info_block_captured_self_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/debug-info-block-captured-self.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fblocks -debug-info-kind=limited -emit-llvm -triple x86_64-apple-darwin -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/debug-info-block-captured-self.m | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/debug-info-block-captured-self.m
    RUN(TestState.Failed, "%clang_cc1 -fblocks -debug-info-kind=limited -emit-llvm -triple x86_64-apple-darwin -o - %s")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_debug_info_block_helper_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/debug-info-block-helper.m");
    // REQUIRES: x86-registered-target
    if (!CHECK_REQUIRES("x86-registered-target")) {
      return;
    }
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm -fblocks -debug-info-kind=limited -triple x86_64-apple-darwin10 -fobjc-runtime=macosx-fragile-10.5 ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/debug-info-block-helper.m -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/debug-info-block-helper.m
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm -fblocks -debug-info-kind=limited -triple x86_64-apple-darwin10 -fobjc-runtime=macosx-fragile-10.5 %s -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_debug_info_block_line_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/debug-info-block-line.m");
    // REQUIRES: x86-registered-target
    if (!CHECK_REQUIRES("x86-registered-target")) {
      return;
    }
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm -fblocks -fobjc-arc -debug-info-kind=limited -triple x86_64-apple-darwin10 ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/debug-info-block-line.m -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/debug-info-block-line.m
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm -fblocks -fobjc-arc -debug-info-kind=limited -triple x86_64-apple-darwin10 %s -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_debug_info_block_type_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/debug-info-block-type.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm -fblocks -debug-info-kind=limited -triple x86_64-apple-darwin14 -x objective-c < ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/debug-info-block-type.m -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/debug-info-block-type.m
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm -fblocks -debug-info-kind=limited  -triple x86_64-apple-darwin14 -x objective-c < %s -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_debug_info_blocks_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/debug-info-blocks.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm -fblocks -debug-info-kind=limited -triple x86_64-apple-darwin10 -fobjc-dispatch-method=mixed -x objective-c < ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/debug-info-blocks.m -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/debug-info-blocks.m
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm -fblocks -debug-info-kind=limited  -triple x86_64-apple-darwin10 -fobjc-dispatch-method=mixed -x objective-c < %s -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_debug_info_class_extension_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/debug-info-class-extension.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i386-pc-solaris2.11 -masm-verbose -S -debug-info-kind=limited ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/debug-info-class-extension.m -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/debug-info-class-extension.m
    RUN(TestState.Failed, "%clang_cc1 -triple %itanium_abi_triple -masm-verbose -S -debug-info-kind=limited %s -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_debug_info_class_extension2_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/debug-info-class-extension2.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i386-pc-solaris2.11 -masm-verbose -S -debug-info-kind=limited ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/debug-info-class-extension2.m -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/debug-info-class-extension2.m
    RUN(TestState.Failed, "%clang_cc1 -triple %itanium_abi_triple -masm-verbose -S -debug-info-kind=limited %s -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_debug_info_class_extension3_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/debug-info-class-extension3.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -masm-verbose -S -debug-info-kind=limited ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/debug-info-class-extension3.m -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/debug-info-class-extension3.m
    RUN(TestState.Failed, "%clang_cc1 -masm-verbose -S -debug-info-kind=limited %s -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_debug_info_crash_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/debug-info-crash.m");
    // REQUIRES: x86-registered-target
    if (!CHECK_REQUIRES("x86-registered-target")) {
      return;
    }
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i386-apple-darwin10 -fobjc-runtime=macosx-fragile-10.5 -fblocks -debug-info-kind=limited -S ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/debug-info-crash.m -o -
    RUN(TestState.Failed, "%clang_cc1 -triple i386-apple-darwin10 -fobjc-runtime=macosx-fragile-10.5 -fblocks -debug-info-kind=limited -S %s -o -");
  }

  @Test
  public void test_debug_info_crash_2_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/debug-info-crash-2.m");
    // REQUIRES: x86-registered-target
    if (!CHECK_REQUIRES("x86-registered-target")) {
      return;
    }
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-apple-darwin11 -debug-info-kind=limited -S ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/debug-info-crash-2.m -o -
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-apple-darwin11 -debug-info-kind=limited -S %s -o -");
  }

  @Test
  public void test_debug_info_default_synth_ivar_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/debug-info-default-synth-ivar.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-apple-darwin10 -emit-llvm -debug-info-kind=limited ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/debug-info-default-synth-ivar.m -o ${TEST_TEMP_DIR}/debug-info-default-synth-ivar.m.tmp
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-apple-darwin10 -emit-llvm -debug-info-kind=limited %s -o %t");
    // grep DW_TAG_member ${TEST_TEMP_DIR}/debug-info-default-synth-ivar.m.tmp | ${LLVM_SRC}/build/bin/count 5
    RUN(TestState.Failed, "grep DW_TAG_member %t")./*|*/
      I("count 5");
  }

  @Test
  public void test_debug_info_fwddecl_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/debug-info-fwddecl.m");
    // ${LLVM_SRC}/build/bin/clang -fverbose-asm -g -S -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/debug-info-fwddecl.m -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/debug-info-fwddecl.m
    RUN(TestState.Failed, "%clang -fverbose-asm -g -S -emit-llvm %s -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_debug_info_getter_name_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/debug-info-getter-name.m");
    // REQUIRES: x86-registered-target
    if (!CHECK_REQUIRES("x86-registered-target")) {
      return;
    }
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm -triple x86_64-apple-darwin10 -fexceptions -fobjc-exceptions -debug-info-kind=limited ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/debug-info-getter-name.m -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/debug-info-getter-name.m
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm -triple x86_64-apple-darwin10 -fexceptions -fobjc-exceptions -debug-info-kind=limited %s -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_debug_info_id_with_protocol_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/debug-info-id-with-protocol.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-apple-darwin10 -emit-llvm -debug-info-kind=limited ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/debug-info-id-with-protocol.m -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/debug-info-id-with-protocol.m
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-apple-darwin10 -emit-llvm -debug-info-kind=limited %s -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_debug_info_impl_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/debug-info-impl.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-apple-darwin10 -debug-info-kind=limited -S -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/debug-info-impl.m -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/debug-info-impl.m
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-apple-darwin10 -debug-info-kind=limited -S -emit-llvm %s -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_debug_info_instancetype_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/debug-info-instancetype.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm -debug-info-kind=limited -triple x86_64-apple-darwin10 ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/debug-info-instancetype.m -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/debug-info-instancetype.m
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm -debug-info-kind=limited -triple x86_64-apple-darwin10 %s -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_debug_info_ivars_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/debug-info-ivars.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-apple-darwin10 -emit-llvm -debug-info-kind=limited ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/debug-info-ivars.m -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/debug-info-ivars.m
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-apple-darwin10 -emit-llvm -debug-info-kind=limited %s -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_debug_info_ivars_extension_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/debug-info-ivars-extension.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-apple-darwin10 -emit-llvm -debug-info-kind=limited ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/debug-info-ivars-extension.m -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/debug-info-ivars-extension.m
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-apple-darwin10 -emit-llvm -debug-info-kind=limited %s -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_debug_info_ivars_indirect_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/debug-info-ivars-indirect.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-apple-darwin10 -emit-llvm -debug-info-kind=limited ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/debug-info-ivars-indirect.m -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/debug-info-ivars-indirect.m
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-apple-darwin10 -emit-llvm -debug-info-kind=limited %s -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_debug_info_ivars_private_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/debug-info-ivars-private.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-apple-darwin10 -emit-llvm -debug-info-kind=limited ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/debug-info-ivars-private.m -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/debug-info-ivars-private.m
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-apple-darwin10 -emit-llvm -debug-info-kind=limited %s -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_debug_info_lifetime_crash_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/debug-info-lifetime-crash.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple arm-apple-ios -emit-llvm -debug-info-kind=limited -fblocks -fobjc-runtime=ios-7.0.0 -fobjc-arc ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/debug-info-lifetime-crash.m -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/debug-info-lifetime-crash.m
    RUN(TestState.Failed, "%clang_cc1 -triple arm-apple-ios -emit-llvm -debug-info-kind=limited -fblocks -fobjc-runtime=ios-7.0.0 -fobjc-arc %s -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_debug_info_linkagename_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/debug-info-linkagename.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -debug-info-kind=limited -S -o ${TEST_TEMP_DIR}/debug-info-linkagename.m.tmp ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/debug-info-linkagename.m
    RUN(TestState.Failed, "%clang_cc1  -debug-info-kind=limited -S -o %t %s");
    // grep '001-[F bar' ${TEST_TEMP_DIR}/debug-info-linkagename.m.tmp
    RUN(TestState.Failed, "not grep \"001-[F bar\" %t");
  }

  @Test
  public void test_debug_info_nested_blocks_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/debug-info-nested-blocks.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm -dwarf-version=2 -debug-info-kind=limited -fblocks -o - -x objective-c ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/debug-info-nested-blocks.m| ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/debug-info-nested-blocks.m
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm -dwarf-version=2 -debug-info-kind=limited -fblocks -o - -x objective-c %s")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_debug_info_nodebug_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/debug-info-nodebug.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple arm-apple-ios -emit-llvm -debug-info-kind=limited -fblocks ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/debug-info-nodebug.m -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/debug-info-nodebug.m
    RUN(TestState.Failed, "%clang_cc1 -triple arm-apple-ios -emit-llvm -debug-info-kind=limited -fblocks  %s -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_debug_info_property_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/debug-info-property.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i386-pc-solaris2.11 -masm-verbose -S -debug-info-kind=limited ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/debug-info-property.m -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/debug-info-property.m
    RUN(TestState.Failed, "%clang_cc1 -triple %itanium_abi_triple -masm-verbose -S -debug-info-kind=limited %s -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_debug_info_property_accessors_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/debug-info-property-accessors.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm -x objective-c -debug-info-kind=limited -triple x86_64-apple-macosx10.8.0 ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/debug-info-property-accessors.m -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/debug-info-property-accessors.m
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm -x objective-c -debug-info-kind=limited -triple x86_64-apple-macosx10.8.0 %s -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_debug_info_property_class_extension_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/debug-info-property-class-extension.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -S -emit-llvm -debug-info-kind=limited ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/debug-info-property-class-extension.m -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/debug-info-property-class-extension.m
    RUN(TestState.Failed, "%clang_cc1 -S -emit-llvm -debug-info-kind=limited %s -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_debug_info_property2_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/debug-info-property2.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i386-pc-solaris2.11 -masm-verbose -S -debug-info-kind=limited ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/debug-info-property2.m -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/debug-info-property2.m
    RUN(TestState.Failed, "%clang_cc1 -triple %itanium_abi_triple -masm-verbose -S -debug-info-kind=limited %s -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_debug_info_property3_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/debug-info-property3.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -S -emit-llvm -debug-info-kind=limited ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/debug-info-property3.m -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/debug-info-property3.m
    RUN(TestState.Failed, "%clang_cc1 -S -emit-llvm -debug-info-kind=limited %s -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_debug_info_property4_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/debug-info-property4.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i386-pc-solaris2.11 -masm-verbose -S -debug-info-kind=limited ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/debug-info-property4.m -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/debug-info-property4.m
    RUN(TestState.Failed, "%clang_cc1 -triple %itanium_abi_triple -masm-verbose -S -debug-info-kind=limited %s -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_debug_info_property5_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/debug-info-property5.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i386-pc-solaris2.11 -masm-verbose -S -debug-info-kind=limited ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/debug-info-property5.m -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/debug-info-property5.m
    RUN(TestState.Failed, "%clang_cc1 -triple %itanium_abi_triple -masm-verbose -S -debug-info-kind=limited %s -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_debug_info_pubtypes_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/debug-info-pubtypes.m");
    // REQUIRES: x86-registered-target
    if (!CHECK_REQUIRES("x86-registered-target")) {
      return;
    }
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-apple-darwin10 -debug-info-kind=limited -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/debug-info-pubtypes.m -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/debug-info-pubtypes.m
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-apple-darwin10 -debug-info-kind=limited -emit-llvm %s -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_debug_info_selector_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/debug-info-selector.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm -debug-info-kind=limited ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/debug-info-selector.m -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/debug-info-selector.m
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm  -debug-info-kind=limited %s -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_debug_info_self_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/debug-info-self.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm -triple i386-pc-solaris2.11 -debug-info-kind=limited ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/debug-info-self.m -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/debug-info-self.m
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm -triple %itanium_abi_triple -debug-info-kind=limited %s -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_debug_info_static_var_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/debug-info-static-var.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -debug-info-kind=limited -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/debug-info-static-var.m | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/debug-info-static-var.m
    RUN(TestState.Failed, "%clang_cc1 -debug-info-kind=limited -emit-llvm -o - %s")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_debug_info_synthesis_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/debug-info-synthesis.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm -debug-info-kind=limited -w -triple x86_64-apple-darwin10 ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/debug-info-synthesis.m -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/debug-info-synthesis.m
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm -debug-info-kind=limited -w -triple x86_64-apple-darwin10 %s -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_debug_info_variadic_method_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/debug-info-variadic-method.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -o - -emit-llvm -debug-info-kind=limited ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/debug-info-variadic-method.m | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/debug-info-variadic-method.m
    RUN(TestState.Failed, "%clang_cc1 -o - -emit-llvm -debug-info-kind=limited %s")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_debug_property_synth_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/debug-property-synth.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i386-pc-solaris2.11 -emit-llvm -debug-info-kind=limited ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/debug-property-synth.m -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/debug-property-synth.m
    RUN(TestState.Failed, "%clang_cc1 -triple %itanium_abi_triple -emit-llvm -debug-info-kind=limited %s -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_debuginfo_properties_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/debuginfo-properties.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -debug-info-kind=limited -emit-llvm -triple x86_64-apple-darwin -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/debuginfo-properties.m | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/debuginfo-properties.m
    RUN(TestState.Failed, "%clang_cc1 -debug-info-kind=limited -emit-llvm -triple x86_64-apple-darwin -o - %s")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_default_property_synthesis_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/default-property-synthesis.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-apple-darwin10 -emit-llvm -o ${TEST_TEMP_DIR}/default-property-synthesis.m.tmp ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/default-property-synthesis.m
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-apple-darwin10 -emit-llvm -o %t %s");
  }

  @Test
  public void test_designated_initializers_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/designated-initializers.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i386-unknown-unknown ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/designated-initializers.m -emit-llvm -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/designated-initializers.m
    RUN(TestState.Failed, "%clang_cc1 -triple i386-unknown-unknown %s -emit-llvm -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_dllstorage_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/dllstorage.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i686-windows-itanium -fms-extensions -fobjc-runtime=macosx -fdeclspec -fobjc-exceptions -S -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/dllstorage.m | ${LLVM_SRC}/build/bin/FileCheck -check-prefix CHECK-IR ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/dllstorage.m
    RUN(TestState.Failed, "%clang_cc1 -triple i686-windows-itanium -fms-extensions -fobjc-runtime=macosx -fdeclspec -fobjc-exceptions -S -emit-llvm -o - %s")./*|*/
      I("FileCheck -check-prefix CHECK-IR %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i686-windows-itanium -fms-extensions -fobjc-runtime=objfw -fdeclspec -fobjc-exceptions -S -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/dllstorage.m | ${LLVM_SRC}/build/bin/FileCheck -check-prefix CHECK-FW ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/dllstorage.m
    RUN(TestState.Failed, "%clang_cc1 -triple i686-windows-itanium -fms-extensions -fobjc-runtime=objfw -fdeclspec -fobjc-exceptions -S -emit-llvm -o - %s")./*|*/
      I("FileCheck -check-prefix CHECK-FW %s");
  }

  @Test
  public void test_dot_syntax_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/dot-syntax.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm -o ${TEST_TEMP_DIR}/dot-syntax.m.tmp ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/dot-syntax.m
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm -o %t %s");
  }

  @Test
  public void test_dot_syntax_1_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/dot-syntax-1.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm -o ${TEST_TEMP_DIR}/dot-syntax-1.m.tmp ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/dot-syntax-1.m
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm -o %t %s");
  }

  @Test
  public void test_dot_syntax_2_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/dot-syntax-2.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm -o ${TEST_TEMP_DIR}/dot-syntax-2.m.tmp ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/dot-syntax-2.m
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm -o %t %s");
  }

  @Test
  public void test_encode_cstyle_method_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/encode-cstyle-method.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-apple-darwin10 -fobjc-runtime=macosx-fragile-10.5 -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/encode-cstyle-method.m | ${LLVM_SRC}/build/bin/FileCheck -check-prefix CHECK-LP64 ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/encode-cstyle-method.m
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-apple-darwin10 -fobjc-runtime=macosx-fragile-10.5  -emit-llvm -o - %s")./*|*/
      I("FileCheck -check-prefix CHECK-LP64 %s");
  }

  @Test
  public void test_encode_test_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/encode-test.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i686-apple-darwin9 -fobjc-runtime=macosx-fragile-10.5 -emit-llvm -o ${TEST_TEMP_DIR}/encode-test.m.tmp ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/encode-test.m
    RUN(TestState.Failed, "%clang_cc1 -triple i686-apple-darwin9 -fobjc-runtime=macosx-fragile-10.5 -emit-llvm -o %t %s");
    // ${LLVM_SRC}/build/bin/FileCheck < ${TEST_TEMP_DIR}/encode-test.m.tmp ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/encode-test.m
    RUN(TestState.Failed, "FileCheck < %t %s");
  }

  @Test
  public void test_encode_test_2_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/encode-test-2.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple=i686-apple-darwin9 -emit-llvm -o ${TEST_TEMP_DIR}/encode-test-2.m.tmp ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/encode-test-2.m
    RUN(TestState.Failed, "%clang_cc1 -triple=i686-apple-darwin9 -emit-llvm -o %t %s");
    // grep -e @\\\22<X>\\\22 ${TEST_TEMP_DIR}/encode-test-2.m.tmp
    RUN(TestState.Failed, "grep -e \"@\\\\\\22<X>\\\\\\22\" %t");
    // grep -e @\\\22<X><Y>\\\22 ${TEST_TEMP_DIR}/encode-test-2.m.tmp
    RUN(TestState.Failed, "grep -e \"@\\\\\\22<X><Y>\\\\\\22\" %t");
    // grep -e @\\\22<X><Y><Z>\\\22 ${TEST_TEMP_DIR}/encode-test-2.m.tmp
    RUN(TestState.Failed, "grep -e \"@\\\\\\22<X><Y><Z>\\\\\\22\" %t");
    // grep -e @\\\22Foo<X><Y><Z>\\\22 ${TEST_TEMP_DIR}/encode-test-2.m.tmp
    RUN(TestState.Failed, "grep -e \"@\\\\\\22Foo<X><Y><Z>\\\\\\22\" %t");
    // grep -e {Intf=@@@@#} ${TEST_TEMP_DIR}/encode-test-2.m.tmp
    RUN(TestState.Failed, "grep -e \"{Intf=@@@@#}\" %t");
  }

  @Test
  public void test_encode_test_3_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/encode-test-3.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple=i686-apple-darwin9 -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/encode-test-3.m | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/encode-test-3.m
    RUN(TestState.Failed, "%clang_cc1 -triple=i686-apple-darwin9 -emit-llvm -o - %s")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_encode_test_4_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/encode-test-4.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/encode-test-4.m -O2 | grep 'ret i32 1'
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm -o - %s -O2")./*|*/
      I("grep \"ret i32 1\"");
  }

  @Test
  public void test_encode_test_5_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/encode-test-5.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x objective-c -triple=x86_64-apple-darwin9 -emit-llvm -o - < ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/encode-test-5.m | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/encode-test-5.m
    RUN(TestState.Failed, "%clang_cc1 -x objective-c -triple=x86_64-apple-darwin9 -emit-llvm -o - < %s")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_encode_test_6_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/encode-test-6.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-apple-darwin -emit-llvm -o ${TEST_TEMP_DIR}/encode-test-6.m.tmp ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/encode-test-6.m
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-apple-darwin -emit-llvm -o %t %s");
    // ${LLVM_SRC}/build/bin/FileCheck < ${TEST_TEMP_DIR}/encode-test-6.m.tmp ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/encode-test-6.m
    RUN(TestState.Failed, "FileCheck < %t %s");
  }

  @Test
  public void test_exceptions_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/exceptions.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-apple-darwin10 -fobjc-runtime=macosx-fragile-10.5 -emit-llvm -fobjc-exceptions -O2 -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/exceptions.m | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/exceptions.m
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-apple-darwin10 -fobjc-runtime=macosx-fragile-10.5 -emit-llvm -fobjc-exceptions -O2 -o - %s")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_exceptions_asm_attribute_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/exceptions-asm-attribute.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-apple-darwin10 -emit-llvm -fexceptions -fobjc-exceptions -o ${TEST_TEMP_DIR}/exceptions-asm-attribute.m.tmp ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/exceptions-asm-attribute.m
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-apple-darwin10 -emit-llvm -fexceptions -fobjc-exceptions -o %t %s");
    // ${LLVM_SRC}/build/bin/FileCheck -check-prefix=CHECK-X86_64 < ${TEST_TEMP_DIR}/exceptions-asm-attribute.m.tmp ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/exceptions-asm-attribute.m
    RUN(TestState.Failed, "FileCheck -check-prefix=CHECK-X86_64 < %t %s");
    // ${LLVM_SRC}/build/bin/FileCheck -check-prefix=CHECK-EHTYPE < ${TEST_TEMP_DIR}/exceptions-asm-attribute.m.tmp ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/exceptions-asm-attribute.m
    RUN(TestState.Failed, "FileCheck -check-prefix=CHECK-EHTYPE < %t %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-apple-darwin10 -fobjc-exceptions -fvisibility hidden -emit-llvm -o ${TEST_TEMP_DIR}/exceptions-asm-attribute.m.tmp ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/exceptions-asm-attribute.m
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-apple-darwin10 -fobjc-exceptions -fvisibility hidden -emit-llvm -o %t %s");
    // ${LLVM_SRC}/build/bin/FileCheck -check-prefix=CHECK-X86_64-HIDDEN < ${TEST_TEMP_DIR}/exceptions-asm-attribute.m.tmp ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/exceptions-asm-attribute.m
    RUN(TestState.Failed, "FileCheck -check-prefix=CHECK-X86_64-HIDDEN < %t %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple armv6-apple-darwin10 -target-abi apcs-gnu -fobjc-exceptions -emit-llvm -o ${TEST_TEMP_DIR}/exceptions-asm-attribute.m.tmp ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/exceptions-asm-attribute.m
    RUN(TestState.Failed, "%clang_cc1 -triple armv6-apple-darwin10 -target-abi apcs-gnu -fobjc-exceptions -emit-llvm -o %t %s");
    // ${LLVM_SRC}/build/bin/FileCheck -check-prefix=CHECK-ARMV6 < ${TEST_TEMP_DIR}/exceptions-asm-attribute.m.tmp ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/exceptions-asm-attribute.m
    RUN(TestState.Failed, "FileCheck -check-prefix=CHECK-ARMV6 < %t %s");
  }

  @Test
  public void test_exceptions_nonfragile_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/exceptions-nonfragile.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-apple-darwin10 -emit-llvm -fexceptions -fobjc-exceptions -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/exceptions-nonfragile.m | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/exceptions-nonfragile.m
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-apple-darwin10 -emit-llvm -fexceptions -fobjc-exceptions -o - %s")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_extended_block_signature_encode_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/extended-block-signature-encode.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fblocks -triple x86_64-apple-darwin -fencode-extended-block-signature -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/extended-block-signature-encode.m -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/extended-block-signature-encode.m
    RUN(TestState.Failed, "%clang_cc1 -fblocks -triple x86_64-apple-darwin -fencode-extended-block-signature -emit-llvm %s -o -")./*|*/
      I("FileCheck %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fblocks -triple x86_64-apple-darwin -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/extended-block-signature-encode.m -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/extended-block-signature-encode.m -check-prefix=CHECK-BRIEF
    RUN(TestState.Failed, "%clang_cc1 -fblocks -triple x86_64-apple-darwin -emit-llvm %s -o -")./*|*/
      I("FileCheck %s -check-prefix=CHECK-BRIEF");
  }

  @Test
  public void test_externally_initialized_selectors_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/externally-initialized-selectors.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fobjc-runtime=macosx-fragile-10.5 -o - -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/externally-initialized-selectors.m | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/externally-initialized-selectors.m
    RUN(TestState.Failed, "%clang_cc1 -fobjc-runtime=macosx-fragile-10.5 -o - -emit-llvm %s")./*|*/
      I("FileCheck %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -o - -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/externally-initialized-selectors.m | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/externally-initialized-selectors.m
    RUN(TestState.Failed, "%clang_cc1 -o - -emit-llvm %s")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_for_in_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/for-in.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/for-in.m -o ${TEST_TEMP_DIR}/for-in.m.tmp
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm %s -o %t");
  }

  @Test
  public void test_forward_class_impl_metadata_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/forward-class-impl-metadata.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm -o ${TEST_TEMP_DIR}/forward-class-impl-metadata.m.tmp ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/forward-class-impl-metadata.m
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm -o %t %s");
  }

  @Test
  public void test_forward_decl_param_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/forward-decl-param.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/forward-decl-param.m -emit-llvm -o -
    RUN(TestState.Failed, "%clang_cc1 %s -emit-llvm -o -");
  }

  @Test
  public void test_forward_protocol_metadata_symbols_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/forward-protocol-metadata-symbols.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm -x objective-c ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/forward-protocol-metadata-symbols.m -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/forward-protocol-metadata-symbols.m
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm -x objective-c %s -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_fp2ret_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/fp2ret.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i386-apple-darwin9 -fobjc-runtime=macosx-fragile-10.5 -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/fp2ret.m | ${LLVM_SRC}/build/bin/FileCheck --check-prefix=CHECK-X86_32 ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/fp2ret.m
    RUN(TestState.Failed, "%clang_cc1 -triple i386-apple-darwin9 -fobjc-runtime=macosx-fragile-10.5 -emit-llvm -o - %s")./*|*/
      I("FileCheck --check-prefix=CHECK-X86_32 %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-apple-darwin10 -fobjc-runtime=macosx-fragile-10.5 -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/fp2ret.m | ${LLVM_SRC}/build/bin/FileCheck --check-prefix=CHECK-X86_64 ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/fp2ret.m
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-apple-darwin10 -fobjc-runtime=macosx-fragile-10.5 -emit-llvm -o - %s")./*|*/
      I("FileCheck --check-prefix=CHECK-X86_64 %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple armv7-apple-darwin10 -fobjc-runtime=macosx-fragile-10.5 -emit-llvm -target-abi apcs-gnu -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/fp2ret.m | ${LLVM_SRC}/build/bin/FileCheck --check-prefix=CHECK-ARMV7 ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/fp2ret.m
    RUN(TestState.Failed, "%clang_cc1 -triple armv7-apple-darwin10 -fobjc-runtime=macosx-fragile-10.5 -emit-llvm -target-abi apcs-gnu -o - %s")./*|*/
      I("FileCheck --check-prefix=CHECK-ARMV7 %s");
  }

  @Test
  public void test_fpret_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/fpret.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i386-apple-darwin9 -fobjc-runtime=macosx-fragile-10.5 -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/fpret.m | ${LLVM_SRC}/build/bin/FileCheck --check-prefix=CHECK-X86_32 ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/fpret.m
    RUN(TestState.Failed, "%clang_cc1 -triple i386-apple-darwin9 -fobjc-runtime=macosx-fragile-10.5 -emit-llvm -o - %s")./*|*/
      I("FileCheck --check-prefix=CHECK-X86_32 %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-apple-darwin10 -fobjc-runtime=macosx-fragile-10.5 -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/fpret.m | ${LLVM_SRC}/build/bin/FileCheck --check-prefix=CHECK-X86_64 ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/fpret.m
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-apple-darwin10 -fobjc-runtime=macosx-fragile-10.5 -emit-llvm -o - %s")./*|*/
      I("FileCheck --check-prefix=CHECK-X86_64 %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple armv7-apple-darwin10 -fobjc-runtime=macosx-fragile-10.5 -emit-llvm -target-abi apcs-gnu -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/fpret.m | ${LLVM_SRC}/build/bin/FileCheck --check-prefix=CHECK-ARMV7 ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/fpret.m
    RUN(TestState.Failed, "%clang_cc1 -triple armv7-apple-darwin10 -fobjc-runtime=macosx-fragile-10.5 -emit-llvm -target-abi apcs-gnu -o - %s")./*|*/
      I("FileCheck --check-prefix=CHECK-ARMV7 %s");
  }

  @Test
  public void test_fragile_arc_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/fragile-arc.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i386-apple-darwin10 -emit-llvm -fblocks -fobjc-arc -fobjc-exceptions -fobjc-runtime=macosx-fragile-10.10 -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/fragile-arc.m | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/fragile-arc.m
    RUN(TestState.Failed, "%clang_cc1 -triple i386-apple-darwin10 -emit-llvm -fblocks -fobjc-arc -fobjc-exceptions -fobjc-runtime=macosx-fragile-10.10 -o - %s")./*|*/
      I("FileCheck %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i386-apple-darwin10 -emit-llvm -fblocks -fobjc-arc -fobjc-exceptions -fobjc-runtime=macosx-fragile-10.10 -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/fragile-arc.m | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/fragile-arc.m -check-prefix=GLOBALS
    RUN(TestState.Failed, "%clang_cc1 -triple i386-apple-darwin10 -emit-llvm -fblocks -fobjc-arc -fobjc-exceptions -fobjc-runtime=macosx-fragile-10.10 -o - %s")./*|*/
      I("FileCheck %s -check-prefix=GLOBALS");
  }

  @Test
  public void test_function_decay_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/function-decay.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/function-decay.m -emit-llvm -o -
    RUN(TestState.Failed, "%clang_cc1 %s -emit-llvm -o -");
  }

  @Test
  public void test_gc_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/gc.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-apple-darwin10 -fobjc-gc -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/gc.m | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/gc.m
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-apple-darwin10 -fobjc-gc -emit-llvm -o - %s")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_gc_weak_attribute_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/gc-weak-attribute.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-apple-darwin10 -fobjc-gc -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/gc-weak-attribute.m | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/gc-weak-attribute.m
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-apple-darwin10 -fobjc-gc -emit-llvm -o - %s")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_getter_property_mismatch_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/getter-property-mismatch.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/getter-property-mismatch.m -emit-llvm -triple x86_64-apple-darwin -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/getter-property-mismatch.m
    RUN(TestState.Failed, "%clang_cc1 %s -emit-llvm -triple x86_64-apple-darwin -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_getter_property_type_mismatch_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/getter-property-type-mismatch.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-apple-darwin10 -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/getter-property-type-mismatch.m | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/getter-property-type-mismatch.m
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-apple-darwin10  -emit-llvm -o - %s")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_gnu_exceptions_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/gnu-exceptions.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-pc-linux-gnu -emit-llvm -fexceptions -fobjc-exceptions -fobjc-runtime=gcc -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/gnu-exceptions.m | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/gnu-exceptions.m
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-pc-linux-gnu -emit-llvm -fexceptions -fobjc-exceptions -fobjc-runtime=gcc -o - %s")./*|*/
      I("FileCheck %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-unknown-freebsd -emit-llvm -fexceptions -fobjc-exceptions -fobjc-runtime=gnustep-1.7 -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/gnu-exceptions.m | ${LLVM_SRC}/build/bin/FileCheck -check-prefix=NEW-ABI ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/gnu-exceptions.m
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-unknown-freebsd -emit-llvm -fexceptions -fobjc-exceptions -fobjc-runtime=gnustep-1.7 -o - %s")./*|*/
      I("FileCheck -check-prefix=NEW-ABI %s");
  }

  @Test
  public void test_hidden_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/hidden.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm -o ${TEST_TEMP_DIR}/hidden.m.tmp ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/hidden.m
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm -o %t %s");
  }

  @Test
  public void test_hidden_visibility_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/hidden-visibility.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i386-apple-macosx -fvisibility hidden -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/hidden-visibility.m | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/hidden-visibility.m
    RUN(TestState.Failed, "%clang_cc1 -triple i386-apple-macosx -fvisibility hidden -emit-llvm -o - %s")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_id_isa_codegen_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/id-isa-codegen.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-apple-darwin10 -fobjc-runtime=macosx-fragile-10.5 -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/id-isa-codegen.m | ${LLVM_SRC}/build/bin/FileCheck -check-prefix CHECK-LP64 ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/id-isa-codegen.m
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-apple-darwin10 -fobjc-runtime=macosx-fragile-10.5  -emit-llvm -o - %s")./*|*/
      I("FileCheck -check-prefix CHECK-LP64 %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i386-apple-darwin9 -fobjc-runtime=macosx-fragile-10.5 -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/id-isa-codegen.m | ${LLVM_SRC}/build/bin/FileCheck -check-prefix CHECK-LP32 ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/id-isa-codegen.m
    RUN(TestState.Failed, "%clang_cc1 -triple i386-apple-darwin9 -fobjc-runtime=macosx-fragile-10.5  -emit-llvm -o - %s")./*|*/
      I("FileCheck -check-prefix CHECK-LP32 %s");
  }

  @Test
  public void test_illegal_UTF8_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/illegal-UTF8.m");
    // ${LLVM_SRC}/build/bin/clang ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/illegal-UTF8.m -S -m64 -o -
    RUN(TestState.Failed, "%clang %s -S -m64 -o -");
  }

  @Test
  public void test_image_info_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/image-info.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i386-apple-darwin9 -fobjc-runtime=macosx-fragile-10.5 -emit-llvm -o ${TEST_TEMP_DIR}/image-info.m.tmp ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/image-info.m
    RUN(TestState.Failed, "%clang_cc1 -triple i386-apple-darwin9 -fobjc-runtime=macosx-fragile-10.5 -emit-llvm -o %t %s");
    // ${LLVM_SRC}/build/bin/FileCheck --check-prefix CHECK-FRAGILE < ${TEST_TEMP_DIR}/image-info.m.tmp ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/image-info.m
    RUN(TestState.Failed, "FileCheck --check-prefix CHECK-FRAGILE < %t %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-apple-darwin10 -emit-llvm -o ${TEST_TEMP_DIR}/image-info.m.tmp ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/image-info.m
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-apple-darwin10 -emit-llvm -o %t %s");
    // ${LLVM_SRC}/build/bin/FileCheck --check-prefix CHECK-NONFRAGILE < ${TEST_TEMP_DIR}/image-info.m.tmp ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/image-info.m
    RUN(TestState.Failed, "FileCheck --check-prefix CHECK-NONFRAGILE < %t %s");
  }

  @Test
  public void test_implicit_objc_msgSend_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/implicit-objc_msgSend.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-apple-darwin9 -fobjc-runtime=macosx-fragile-10.5 -emit-llvm -o ${TEST_TEMP_DIR}/implicit-objc_msgSend.m.tmp ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/implicit-objc_msgSend.m
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-apple-darwin9 -fobjc-runtime=macosx-fragile-10.5 -emit-llvm -o %t %s");
    // grep -F 'declare i8* @objc_msgSend(i8*, i8*, ...)' ${TEST_TEMP_DIR}/implicit-objc_msgSend.m.tmp
    RUN(TestState.Failed, "grep -F 'declare i8* @objc_msgSend(i8*, i8*, ...)' %t");
  }

  @Test
  public void test_implicit_property_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/implicit-property.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm -triple=i686-apple-darwin8 -o ${TEST_TEMP_DIR}/implicit-property.m.tmp ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/implicit-property.m
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm -triple=i686-apple-darwin8 -o %t %s");
  }

  @Test
  public void test_instance_method_metadata_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/instance-method-metadata.m");
    // REQUIRES: x86-registered-target
    if (!CHECK_REQUIRES("x86-registered-target")) {
      return;
    }
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-apple-darwin10 -S -o ${TEST_TEMP_DIR}/instance-method-metadata.m.tmp ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/instance-method-metadata.m
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-apple-darwin10 -S -o %t %s");
    // ${LLVM_SRC}/build/bin/FileCheck < ${TEST_TEMP_DIR}/instance-method-metadata.m.tmp ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/instance-method-metadata.m
    RUN(TestState.Failed, "FileCheck < %t %s");
  }

  @Test
  public void test_interface_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/interface.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i386-apple-darwin9 -fobjc-runtime=macosx-fragile-10.5 -O3 -emit-llvm -o ${TEST_TEMP_DIR}/interface.m.tmp ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/interface.m
    RUN(TestState.Failed, "%clang_cc1 -triple i386-apple-darwin9 -fobjc-runtime=macosx-fragile-10.5 -O3 -emit-llvm -o %t %s");
    // grep 'ret i32 385' ${TEST_TEMP_DIR}/interface.m.tmp
    RUN(TestState.Failed, "grep 'ret i32 385' %t");
  }

  @Test
  public void test_interface_layout_64_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/interface-layout-64.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-apple-darwin10 -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/interface-layout-64.m | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/interface-layout-64.m
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-apple-darwin10 -emit-llvm -o - %s")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_ivar_base_as_invariant_load_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/ivar-base-as-invariant-load.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm -triple x86_64-apple-darwin -x objective-c ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/ivar-base-as-invariant-load.m -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/ivar-base-as-invariant-load.m
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm  -triple x86_64-apple-darwin -x objective-c %s -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_ivar_invariant_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/ivar-invariant.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-apple-darwin -fblocks -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/ivar-invariant.m | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/ivar-invariant.m
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-apple-darwin -fblocks -emit-llvm -o - %s")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_ivar_layout_64_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/ivar-layout-64.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-apple-darwin10 -fobjc-gc -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/ivar-layout-64.m | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/ivar-layout-64.m
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-apple-darwin10 -fobjc-gc -emit-llvm -o - %s")./*|*/
      I("FileCheck %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x objective-c++ -triple x86_64-apple-darwin10 -fobjc-gc -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/ivar-layout-64.m | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/ivar-layout-64.m
    RUN(TestState.Failed, "%clang_cc1 -x objective-c++ -triple x86_64-apple-darwin10 -fobjc-gc -emit-llvm -o - %s")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_ivar_layout_64_bitfields_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/ivar-layout-64-bitfields.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-apple-darwin9 -fobjc-runtime=macosx-fragile-10.5 -fobjc-gc -emit-llvm -o ${TEST_TEMP_DIR}/ivar-layout-64-bitfields.m.tmp ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/ivar-layout-64-bitfields.m
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-apple-darwin9 -fobjc-runtime=macosx-fragile-10.5 -fobjc-gc -emit-llvm -o %t %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x objective-c++ -triple x86_64-apple-darwin9 -fobjc-runtime=macosx-fragile-10.5 -fobjc-gc -emit-llvm -o ${TEST_TEMP_DIR}/ivar-layout-64-bitfields.m.tmp ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/ivar-layout-64-bitfields.m
    RUN(TestState.Failed, "%clang_cc1 -x objective-c++ -triple x86_64-apple-darwin9 -fobjc-runtime=macosx-fragile-10.5 -fobjc-gc -emit-llvm -o %t %s");
  }

  @Test
  public void test_ivar_layout_array0_struct_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/ivar-layout-array0-struct.m");
    // REQUIRES: x86-registered-target
    if (!CHECK_REQUIRES("x86-registered-target")) {
      return;
    }
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fobjc-gc -triple x86_64-apple-darwin -fobjc-runtime=macosx-fragile-10.5 -S ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/ivar-layout-array0-struct.m -o ${TEST_TEMP_DIR}/ivar-layout-array0-struct.m.tmp-64.s
    RUN(TestState.Failed, "%clang_cc1 -fobjc-gc -triple x86_64-apple-darwin -fobjc-runtime=macosx-fragile-10.5 -S %s -o %t-64.s");
    // ${LLVM_SRC}/build/bin/FileCheck -check-prefix CHECK-LP64 '--input-file=${TEST_TEMP_DIR}/ivar-layout-array0-struct.m.tmp-64.s' ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/ivar-layout-array0-struct.m
    RUN(TestState.Failed, "FileCheck -check-prefix CHECK-LP64 --input-file=%t-64.s %s");
  }

  @Test
  public void test_ivar_layout_no_optimize_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/ivar-layout-no-optimize.m");
    // REQUIRES: x86-registered-target
    if (!CHECK_REQUIRES("x86-registered-target")) {
      return;
    }
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fobjc-gc -triple x86_64-apple-darwin -fobjc-runtime=macosx-fragile-10.5 -S ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/ivar-layout-no-optimize.m -o ${TEST_TEMP_DIR}/ivar-layout-no-optimize.m.tmp-64.s
    RUN(TestState.Failed, "%clang_cc1 -fobjc-gc -triple x86_64-apple-darwin -fobjc-runtime=macosx-fragile-10.5 -S %s -o %t-64.s");
    // ${LLVM_SRC}/build/bin/FileCheck -check-prefix CHECK-LP64 '--input-file=${TEST_TEMP_DIR}/ivar-layout-no-optimize.m.tmp-64.s' ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/ivar-layout-no-optimize.m
    RUN(TestState.Failed, "FileCheck -check-prefix CHECK-LP64 --input-file=%t-64.s %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x objective-c++ -fobjc-gc -triple x86_64-apple-darwin -fobjc-runtime=macosx-fragile-10.5 -S ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/ivar-layout-no-optimize.m -o ${TEST_TEMP_DIR}/ivar-layout-no-optimize.m.tmp-64.s
    RUN(TestState.Failed, "%clang_cc1 -x objective-c++ -fobjc-gc -triple x86_64-apple-darwin -fobjc-runtime=macosx-fragile-10.5 -S %s -o %t-64.s");
    // ${LLVM_SRC}/build/bin/FileCheck -check-prefix CHECK-LP64 '--input-file=${TEST_TEMP_DIR}/ivar-layout-no-optimize.m.tmp-64.s' ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/ivar-layout-no-optimize.m
    RUN(TestState.Failed, "FileCheck -check-prefix CHECK-LP64 --input-file=%t-64.s %s");
  }

  @Test
  public void test_ivar_layout_nonfragile_abi2_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/ivar-layout-nonfragile-abi2.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-apple-darwin10 -emit-llvm -o ${TEST_TEMP_DIR}/ivar-layout-nonfragile-abi2.m.tmp ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/ivar-layout-nonfragile-abi2.m
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-apple-darwin10 -emit-llvm -o %t %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x objective-c++ -triple x86_64-apple-darwin10 -emit-llvm -o ${TEST_TEMP_DIR}/ivar-layout-nonfragile-abi2.m.tmp ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/ivar-layout-nonfragile-abi2.m
    RUN(TestState.Failed, "%clang_cc1 -x objective-c++ -triple x86_64-apple-darwin10 -emit-llvm -o %t %s");
  }

  @Test
  public void test_ivars_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/ivars.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-apple-darwin9 -fobjc-runtime=macosx-fragile-10.5 -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/ivars.m
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-apple-darwin9 -fobjc-runtime=macosx-fragile-10.5 -emit-llvm -o - %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i386-apple-darwin9 -fobjc-runtime=macosx-fragile-10.5 -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/ivars.m
    RUN(TestState.Failed, "%clang_cc1 -triple i386-apple-darwin9 -fobjc-runtime=macosx-fragile-10.5 -emit-llvm -o - %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fobjc-gc -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/ivars.m
    RUN(TestState.Failed, "%clang_cc1 -fobjc-gc -emit-llvm -o - %s");
  }

  @Test
  public void test_layout_bitfield_crash_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/layout-bitfield-crash.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-apple-darwin11 -fobjc-gc -emit-llvm -debug-info-kind=limited -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/layout-bitfield-crash.m
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-apple-darwin11 -fobjc-gc -emit-llvm -debug-info-kind=limited -o - %s");
  }

  @Test
  public void test_link_errors_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/link-errors.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i386-apple-darwin9 -fobjc-runtime=macosx-fragile-10.5 -emit-llvm -o ${TEST_TEMP_DIR}/link-errors.m.tmp ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/link-errors.m
    RUN(TestState.Failed, "%clang_cc1 -triple i386-apple-darwin9 -fobjc-runtime=macosx-fragile-10.5 -emit-llvm -o %t %s");
    // grep '.lazy_reference .objc_class_name_A' ${TEST_TEMP_DIR}/link-errors.m.tmp | ${LLVM_SRC}/build/bin/count 1
    RUN(TestState.Failed, "grep '.lazy_reference .objc_class_name_A' %t")./*|*/
      I("count 1");
    // grep '.lazy_reference .objc_class_name_Unknown' ${TEST_TEMP_DIR}/link-errors.m.tmp | ${LLVM_SRC}/build/bin/count 1
    RUN(TestState.Failed, "grep '.lazy_reference .objc_class_name_Unknown' %t")./*|*/
      I("count 1");
    // grep '.lazy_reference .objc_class_name_Protocol' ${TEST_TEMP_DIR}/link-errors.m.tmp | ${LLVM_SRC}/build/bin/count 1
    RUN(TestState.Failed, "grep '.lazy_reference .objc_class_name_Protocol' %t")./*|*/
      I("count 1");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i386-apple-darwin9 -fobjc-runtime=macosx-fragile-10.5 -DWITH_IMPL -emit-llvm -o ${TEST_TEMP_DIR}/link-errors.m.tmp ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/link-errors.m
    RUN(TestState.Failed, "%clang_cc1 -triple i386-apple-darwin9 -fobjc-runtime=macosx-fragile-10.5 -DWITH_IMPL -emit-llvm -o %t %s");
    // grep '.lazy_reference .objc_class_name_Root' ${TEST_TEMP_DIR}/link-errors.m.tmp | ${LLVM_SRC}/build/bin/count 1
    RUN(TestState.Failed, "grep '.lazy_reference .objc_class_name_Root' %t")./*|*/
      I("count 1");
  }

  @Test
  public void test_local_static_block_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/local-static-block.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fblocks -triple x86_64-apple-darwin -fobjc-runtime=macosx-fragile-10.5 -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/local-static-block.m -o ${TEST_TEMP_DIR}/local-static-block.m.tmp-64.ll
    RUN(TestState.Failed, "%clang_cc1 -fblocks -triple x86_64-apple-darwin -fobjc-runtime=macosx-fragile-10.5 -emit-llvm %s -o %t-64.ll");
    // ${LLVM_SRC}/build/bin/FileCheck -check-prefix CHECK-LP64 '--input-file=${TEST_TEMP_DIR}/local-static-block.m.tmp-64.ll' ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/local-static-block.m
    RUN(TestState.Failed, "FileCheck -check-prefix CHECK-LP64 --input-file=%t-64.ll %s");
  }

  @Test
  public void test_mangle_blocks_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/mangle-blocks.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i386-apple-ios -fblocks -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/mangle-blocks.m -Wno-objc-root-class | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/mangle-blocks.m
    RUN(TestState.Failed, "%clang_cc1 -triple i386-apple-ios -fblocks -emit-llvm -o - %s -Wno-objc-root-class")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_message_arrays_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/message-arrays.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm -o ${TEST_TEMP_DIR}/message-arrays.m.tmp ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/message-arrays.m
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm -o %t %s");
  }

  @Test
  public void test_messages_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/messages.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fobjc-runtime=macosx-fragile-10.5 -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/messages.m | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/messages.m -check-prefix=CHECK-MAC
    RUN(TestState.Failed, "%clang_cc1 -fobjc-runtime=macosx-fragile-10.5 -emit-llvm -o - %s")./*|*/
      I("FileCheck %s -check-prefix=CHECK-MAC");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/messages.m | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/messages.m -check-prefix=CHECK-MAC-NF
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm -o - %s")./*|*/
      I("FileCheck %s -check-prefix=CHECK-MAC-NF");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fobjc-runtime=gcc -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/messages.m | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/messages.m -check-prefix=CHECK-GNU
    RUN(TestState.Failed, "%clang_cc1 -fobjc-runtime=gcc -emit-llvm -o - %s")./*|*/
      I("FileCheck %s -check-prefix=CHECK-GNU");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fobjc-runtime=gnustep -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/messages.m | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/messages.m -check-prefix CHECK-GNU-NF
    RUN(TestState.Failed, "%clang_cc1 -fobjc-runtime=gnustep -emit-llvm -o - %s")./*|*/
      I("FileCheck %s -check-prefix CHECK-GNU-NF");
  }

  @Test
  public void test_messages_2_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/messages-2.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-apple-darwin10 -fobjc-runtime=macosx-fragile-10.5 -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/messages-2.m | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/messages-2.m
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-apple-darwin10 -fobjc-runtime=macosx-fragile-10.5 -emit-llvm -o - %s")./*|*/
      I("FileCheck %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-apple-darwin10 -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/messages-2.m | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/messages-2.m -check-prefix=CHECK-NF
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-apple-darwin10 -emit-llvm -o - %s")./*|*/
      I("FileCheck %s -check-prefix=CHECK-NF");
  }

  @Test
  public void test_metadata_class_properties_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/metadata-class-properties.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-apple-macosx10.11 -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/metadata-class-properties.m | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/metadata-class-properties.m
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-apple-macosx10.11  -emit-llvm -o - %s")./*|*/
      I("FileCheck %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-apple-macosx10.10 -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/metadata-class-properties.m | ${LLVM_SRC}/build/bin/FileCheck -check-prefix=CHECK-NULL ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/metadata-class-properties.m
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-apple-macosx10.10  -emit-llvm -o - %s")./*|*/
      I("FileCheck -check-prefix=CHECK-NULL %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-apple-macosx10.11 -emit-llvm -o - -fobjc-runtime=macosx-fragile-10.5 ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/metadata-class-properties.m | ${LLVM_SRC}/build/bin/FileCheck -check-prefix=CHECK-FRAGILE ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/metadata-class-properties.m
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-apple-macosx10.11  -emit-llvm -o - -fobjc-runtime=macosx-fragile-10.5 %s")./*|*/
      I("FileCheck -check-prefix=CHECK-FRAGILE %s");
  }

  @Test
  public void test_metadata_symbols_32_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/metadata-symbols-32.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i386-apple-darwin9 -fobjc-runtime=macosx-fragile-10.5 -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/metadata-symbols-32.m | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/metadata-symbols-32.m
    RUN(TestState.Failed, "%clang_cc1 -triple i386-apple-darwin9 -fobjc-runtime=macosx-fragile-10.5 -emit-llvm -o - %s")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_metadata_symbols_64_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/metadata-symbols-64.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-apple-darwin10 -fobjc-dispatch-method=mixed -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/metadata-symbols-64.m | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/metadata-symbols-64.m
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-apple-darwin10 -fobjc-dispatch-method=mixed -emit-llvm -o - %s")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_metadata_symbols_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/metadata_symbols.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-apple-darwin10 -emit-llvm -fexceptions -fobjc-exceptions -o ${TEST_TEMP_DIR}/metadata_symbols.m.tmp ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/metadata_symbols.m
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-apple-darwin10 -emit-llvm -fexceptions -fobjc-exceptions -o %t %s");
    // ${LLVM_SRC}/build/bin/FileCheck -check-prefix=CHECK-X86_64 < ${TEST_TEMP_DIR}/metadata_symbols.m.tmp ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/metadata_symbols.m
    RUN(TestState.Failed, "FileCheck -check-prefix=CHECK-X86_64 < %t %s");
    // ${LLVM_SRC}/build/bin/FileCheck -check-prefix=CHECK-EHTYPE < ${TEST_TEMP_DIR}/metadata_symbols.m.tmp ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/metadata_symbols.m
    RUN(TestState.Failed, "FileCheck -check-prefix=CHECK-EHTYPE < %t %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-apple-darwin10 -fobjc-exceptions -fvisibility hidden -emit-llvm -o ${TEST_TEMP_DIR}/metadata_symbols.m.tmp ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/metadata_symbols.m
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-apple-darwin10 -fobjc-exceptions -fvisibility hidden -emit-llvm -o %t %s");
    // ${LLVM_SRC}/build/bin/FileCheck -check-prefix=CHECK-X86_64-HIDDEN < ${TEST_TEMP_DIR}/metadata_symbols.m.tmp ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/metadata_symbols.m
    RUN(TestState.Failed, "FileCheck -check-prefix=CHECK-X86_64-HIDDEN < %t %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple armv6-apple-darwin10 -target-abi apcs-gnu -fobjc-exceptions -emit-llvm -o ${TEST_TEMP_DIR}/metadata_symbols.m.tmp ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/metadata_symbols.m
    RUN(TestState.Failed, "%clang_cc1 -triple armv6-apple-darwin10 -target-abi apcs-gnu -fobjc-exceptions -emit-llvm -o %t %s");
    // ${LLVM_SRC}/build/bin/FileCheck -check-prefix=CHECK-ARMV6 < ${TEST_TEMP_DIR}/metadata_symbols.m.tmp ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/metadata_symbols.m
    RUN(TestState.Failed, "FileCheck -check-prefix=CHECK-ARMV6 < %t %s");
  }

  @Test
  public void test_misc_atomic_property_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/misc-atomic-property.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-apple-darwin10 -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/misc-atomic-property.m | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/misc-atomic-property.m
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-apple-darwin10  -emit-llvm -o - %s")./*|*/
      I("FileCheck %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i386-apple-darwin9 -fobjc-runtime=macosx-fragile-10.5 -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/misc-atomic-property.m | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/misc-atomic-property.m
    RUN(TestState.Failed, "%clang_cc1 -triple i386-apple-darwin9 -fobjc-runtime=macosx-fragile-10.5  -emit-llvm -o - %s")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_mrc_weak_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/mrc-weak.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-apple-darwin10 -fobjc-runtime=macosx-10.10 -emit-llvm -fblocks -fobjc-weak -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/mrc-weak.m | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/mrc-weak.m -check-prefix=CHECK -check-prefix=CHECK-MODERN
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-apple-darwin10 -fobjc-runtime=macosx-10.10 -emit-llvm -fblocks -fobjc-weak -o - %s")./*|*/
      I("FileCheck %s -check-prefix=CHECK -check-prefix=CHECK-MODERN");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i386-apple-darwin10 -fobjc-runtime=macosx-fragile-10.10 -emit-llvm -fblocks -fobjc-weak -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/mrc-weak.m | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/mrc-weak.m -check-prefix=CHECK -check-prefix=CHECK-FRAGILE
    RUN(TestState.Failed, "%clang_cc1 -triple i386-apple-darwin10 -fobjc-runtime=macosx-fragile-10.10 -emit-llvm -fblocks -fobjc-weak -o - %s")./*|*/
      I("FileCheck %s -check-prefix=CHECK -check-prefix=CHECK-FRAGILE");
  }

  @Test
  public void test_mrr_autorelease_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/mrr-autorelease.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-apple-darwin10 -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/mrr-autorelease.m | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/mrr-autorelease.m
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-apple-darwin10 -emit-llvm -o - %s")./*|*/
      I("FileCheck %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i386-apple-darwin10 -fobjc-runtime=macosx-fragile-10.5 -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/mrr-autorelease.m | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/mrr-autorelease.m
    RUN(TestState.Failed, "%clang_cc1 -triple i386-apple-darwin10 -fobjc-runtime=macosx-fragile-10.5 -emit-llvm -o - %s")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_mrr_captured_block_var_inlined_layout_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/mrr-captured-block-var-inlined-layout.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fblocks -fobjc-runtime-has-weak -fobjc-arc -triple x86_64-apple-darwin -print-ivar-layout -emit-llvm -o /dev/null ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/mrr-captured-block-var-inlined-layout.m > ${TEST_TEMP_DIR}/mrr-captured-block-var-inlined-layout.m.tmp-64.layout
    RUN(TestState.Failed, "%clang_cc1 -fblocks -fobjc-runtime-has-weak -fobjc-arc -triple x86_64-apple-darwin -print-ivar-layout -emit-llvm -o /dev/null %s > %t-64.layout");
    // ${LLVM_SRC}/build/bin/FileCheck -check-prefix=CHECK -check-prefix=CHECK-64 '--input-file=${TEST_TEMP_DIR}/mrr-captured-block-var-inlined-layout.m.tmp-64.layout' ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/mrr-captured-block-var-inlined-layout.m
    RUN(TestState.Failed, "FileCheck -check-prefix=CHECK -check-prefix=CHECK-64 --input-file=%t-64.layout %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fblocks -fobjc-runtime-has-weak -fobjc-arc -triple i386-apple-darwin -print-ivar-layout -emit-llvm -o /dev/null ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/mrr-captured-block-var-inlined-layout.m > ${TEST_TEMP_DIR}/mrr-captured-block-var-inlined-layout.m.tmp-32.layout
    RUN(TestState.Failed, "%clang_cc1 -fblocks -fobjc-runtime-has-weak -fobjc-arc -triple i386-apple-darwin -print-ivar-layout -emit-llvm -o /dev/null %s > %t-32.layout");
    // ${LLVM_SRC}/build/bin/FileCheck -check-prefix=CHECK -check-prefix=CHECK-32 '--input-file=${TEST_TEMP_DIR}/mrr-captured-block-var-inlined-layout.m.tmp-32.layout' ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/mrr-captured-block-var-inlined-layout.m
    RUN(TestState.Failed, "FileCheck -check-prefix=CHECK -check-prefix=CHECK-32 --input-file=%t-32.layout %s");
  }

  @Test
  public void test_nested_rethrow_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/nested-rethrow.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i386-apple-darwin9 -fobjc-runtime=macosx-fragile-10.5 -emit-llvm -fobjc-exceptions ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/nested-rethrow.m -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/nested-rethrow.m
    RUN(TestState.Failed, "%clang_cc1 -triple i386-apple-darwin9 -fobjc-runtime=macosx-fragile-10.5 -emit-llvm -fobjc-exceptions %s -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_newproperty_nested_synthesis_1_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/newproperty-nested-synthesis-1.m");
    // REQUIRES: LP64
    if (!CHECK_REQUIRES("LP64")) {
      return;
    }
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm -o ${TEST_TEMP_DIR}/newproperty-nested-synthesis-1.m.tmp ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/newproperty-nested-synthesis-1.m
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm -o %t %s");
  }

  @Test
  public void test_next_objc_dispatch_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/next-objc-dispatch.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-apple-darwin9 -fobjc-runtime=macosx-fragile-10.5 -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/next-objc-dispatch.m -fobjc-dispatch-method=legacy | ${LLVM_SRC}/build/bin/FileCheck -check-prefix CHECK-FRAGILE_LEGACY ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/next-objc-dispatch.m
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-apple-darwin9 -fobjc-runtime=macosx-fragile-10.5 -emit-llvm -o - %s -fobjc-dispatch-method=legacy")./*|*/
      I("FileCheck -check-prefix CHECK-FRAGILE_LEGACY %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-apple-darwin9 -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/next-objc-dispatch.m -fobjc-dispatch-method=legacy | ${LLVM_SRC}/build/bin/FileCheck -check-prefix CHECK-NONFRAGILE_LEGACY ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/next-objc-dispatch.m
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-apple-darwin9 -emit-llvm -o - %s -fobjc-dispatch-method=legacy")./*|*/
      I("FileCheck -check-prefix CHECK-NONFRAGILE_LEGACY %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-apple-darwin9 -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/next-objc-dispatch.m -fobjc-dispatch-method=non-legacy | ${LLVM_SRC}/build/bin/FileCheck -check-prefix CHECK-NONFRAGILE_NONLEGACY ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/next-objc-dispatch.m
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-apple-darwin9 -emit-llvm -o - %s -fobjc-dispatch-method=non-legacy")./*|*/
      I("FileCheck -check-prefix CHECK-NONFRAGILE_NONLEGACY %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-apple-darwin9 -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/next-objc-dispatch.m -fobjc-dispatch-method=mixed | ${LLVM_SRC}/build/bin/FileCheck -check-prefix CHECK-NONFRAGILE_MIXED ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/next-objc-dispatch.m
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-apple-darwin9 -emit-llvm -o - %s -fobjc-dispatch-method=mixed")./*|*/
      I("FileCheck -check-prefix CHECK-NONFRAGILE_MIXED %s");
  }

  @Test
  public void test_no_category_class_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/no-category-class.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-unknown-unknown -fobjc-runtime=macosx-fragile-10.5 -emit-llvm -o ${TEST_TEMP_DIR}/no-category-class.m.tmp ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/no-category-class.m
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-unknown-unknown -fobjc-runtime=macosx-fragile-10.5 -emit-llvm -o %t %s");
  }

  @Test
  public void test_no_sanitize_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/no-sanitize.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/no-sanitize.m -emit-llvm -fsanitize=address -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/no-sanitize.m
    RUN(TestState.Failed, "%clang_cc1 %s -emit-llvm -fsanitize=address -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_no_vararg_messaging_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/no-vararg-messaging.m");
    // REQUIRES: x86-registered-target
    if (!CHECK_REQUIRES("x86-registered-target")) {
      return;
    }
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-apple-darwin10 -S -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/no-vararg-messaging.m | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/no-vararg-messaging.m
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-apple-darwin10  -S -o - %s")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_non_lazy_classes_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/non-lazy-classes.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-apple-darwin10 -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/non-lazy-classes.m | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/non-lazy-classes.m
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-apple-darwin10 -emit-llvm -o - %s")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_nonlazy_msgSend_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/nonlazy-msgSend.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-apple-darwin9 -fobjc-runtime=macosx-fragile-10.5 -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/nonlazy-msgSend.m -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/nonlazy-msgSend.m
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-apple-darwin9 -fobjc-runtime=macosx-fragile-10.5 -emit-llvm %s -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_ns_constant_strings_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/ns-constant-strings.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i386-apple-darwin9 -fobjc-runtime=macosx-fragile-10.5 -fno-constant-cfstrings -emit-llvm -o ${TEST_TEMP_DIR}/ns-constant-strings.m.tmp ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/ns-constant-strings.m
    RUN(TestState.Failed, "%clang_cc1 -triple i386-apple-darwin9 -fobjc-runtime=macosx-fragile-10.5 -fno-constant-cfstrings -emit-llvm -o %t %s");
    // ${LLVM_SRC}/build/bin/FileCheck --check-prefix CHECK-FRAGILE < ${TEST_TEMP_DIR}/ns-constant-strings.m.tmp ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/ns-constant-strings.m
    RUN(TestState.Failed, "FileCheck --check-prefix CHECK-FRAGILE < %t %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-apple-darwin10 -fno-constant-cfstrings -emit-llvm -o ${TEST_TEMP_DIR}/ns-constant-strings.m.tmp ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/ns-constant-strings.m
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-apple-darwin10 -fno-constant-cfstrings -emit-llvm -o %t %s");
    // ${LLVM_SRC}/build/bin/FileCheck --check-prefix CHECK-NONFRAGILE < ${TEST_TEMP_DIR}/ns-constant-strings.m.tmp ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/ns-constant-strings.m
    RUN(TestState.Failed, "FileCheck --check-prefix CHECK-NONFRAGILE < %t %s");
  }

  @Test
  public void test_ns_consume_null_check_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/ns_consume_null_check.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-apple-darwin10 -emit-llvm -fobjc-arc -fobjc-dispatch-method=mixed -fobjc-runtime-has-weak -fexceptions -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/ns_consume_null_check.m | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/ns_consume_null_check.m
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-apple-darwin10 -emit-llvm -fobjc-arc -fobjc-dispatch-method=mixed -fobjc-runtime-has-weak -fexceptions -o - %s")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_nsvalue_objc_boxable_ios_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/nsvalue-objc-boxable-ios.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -I ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/Inputs -triple armv7-apple-ios8.0.0 -emit-llvm -O2 -disable-llvm-optzns -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/nsvalue-objc-boxable-ios.m | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/nsvalue-objc-boxable-ios.m
    RUN(TestState.Failed, "%clang_cc1 -I %S/Inputs -triple armv7-apple-ios8.0.0 -emit-llvm -O2 -disable-llvm-optzns -o - %s")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_nsvalue_objc_boxable_ios_arc_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/nsvalue-objc-boxable-ios-arc.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -I ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/Inputs -triple armv7-apple-ios8.0.0 -emit-llvm -fobjc-arc -O2 -disable-llvm-optzns -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/nsvalue-objc-boxable-ios-arc.m | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/nsvalue-objc-boxable-ios-arc.m
    RUN(TestState.Failed, "%clang_cc1 -I %S/Inputs -triple armv7-apple-ios8.0.0 -emit-llvm -fobjc-arc -O2 -disable-llvm-optzns -o - %s")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_nsvalue_objc_boxable_mac_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/nsvalue-objc-boxable-mac.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -I ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/Inputs -triple x86_64-apple-macosx -emit-llvm -O2 -disable-llvm-optzns -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/nsvalue-objc-boxable-mac.m | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/nsvalue-objc-boxable-mac.m
    RUN(TestState.Failed, "%clang_cc1 -I %S/Inputs -triple x86_64-apple-macosx -emit-llvm -O2 -disable-llvm-optzns -o - %s")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_nsvalue_objc_boxable_mac_arc_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/nsvalue-objc-boxable-mac-arc.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -I ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/Inputs -triple x86_64-apple-macosx -emit-llvm -fobjc-arc -O2 -disable-llvm-optzns -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/nsvalue-objc-boxable-mac-arc.m | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/nsvalue-objc-boxable-mac-arc.m
    RUN(TestState.Failed, "%clang_cc1 -I %S/Inputs -triple x86_64-apple-macosx -emit-llvm -fobjc-arc -O2 -disable-llvm-optzns -o - %s")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_null_objc_empty_vtable_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/null-objc-empty-vtable.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-apple-macosx10.9 -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/null-objc-empty-vtable.m | ${LLVM_SRC}/build/bin/FileCheck -check-prefix CHECK-OSX ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/null-objc-empty-vtable.m
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-apple-macosx10.9 -emit-llvm -o - %s")./*|*/
      I("FileCheck -check-prefix CHECK-OSX %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple thumbv7-apple-ios3.0.0 -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/null-objc-empty-vtable.m | ${LLVM_SRC}/build/bin/FileCheck -check-prefix CHECK-IOS ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/null-objc-empty-vtable.m
    RUN(TestState.Failed, "%clang_cc1 -triple thumbv7-apple-ios3.0.0  -emit-llvm -o - %s")./*|*/
      I("FileCheck -check-prefix CHECK-IOS %s");
  }

  @Test
  public void test_objc_align_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/objc-align.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i386-apple-darwin9 -fobjc-runtime=macosx-fragile-10.5 -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/objc-align.m | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/objc-align.m
    RUN(TestState.Failed, "%clang_cc1 -triple i386-apple-darwin9 -fobjc-runtime=macosx-fragile-10.5 -emit-llvm -o - %s")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_objc_arc_container_subscripting_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/objc-arc-container-subscripting.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fobjc-arc -emit-llvm -triple x86_64-apple-darwin -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/objc-arc-container-subscripting.m | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/objc-arc-container-subscripting.m
    RUN(TestState.Failed, "%clang_cc1 -fobjc-arc -emit-llvm -triple x86_64-apple-darwin -o - %s")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_objc_asm_attribute_neg_test_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/objc-asm-attribute-neg-test.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -Wno-objc-root-class ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/objc-asm-attribute-neg-test.m
    RUN(TestState.Failed, "%clang_cc1  -fsyntax-only -verify -Wno-objc-root-class %s");
  }

  @Test
  public void test_objc_asm_attribute_test_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/objc-asm-attribute-test.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm -triple x86_64-apple-darwin ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/objc-asm-attribute-test.m -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/objc-asm-attribute-test.m
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm -triple x86_64-apple-darwin %s -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_objc_assign_ivar_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/objc-assign-ivar.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-apple-darwin10 -fobjc-runtime=macosx-fragile-10.5 -fobjc-gc -emit-llvm -o ${TEST_TEMP_DIR}/objc-assign-ivar.m.tmp ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/objc-assign-ivar.m
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-apple-darwin10 -fobjc-runtime=macosx-fragile-10.5 -fobjc-gc -emit-llvm -o %t %s");
    // grep -F @objc_assign_ivar ${TEST_TEMP_DIR}/objc-assign-ivar.m.tmp | ${LLVM_SRC}/build/bin/count 14
    RUN(TestState.Failed, "grep -F '@objc_assign_ivar' %t")./*|*/
      I("count 14");
  }

  @Test
  public void test_objc_container_subscripting_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/objc-container-subscripting.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm -triple x86_64-apple-darwin ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/objc-container-subscripting.m -o /dev/null
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm -triple x86_64-apple-darwin %s -o /dev/null");
  }

  @Test
  public void test_objc_container_subscripting_1_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/objc-container-subscripting-1.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm -triple x86_64-apple-darwin -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/objc-container-subscripting-1.m | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/objc-container-subscripting-1.m
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm -triple x86_64-apple-darwin -o - %s")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_objc_dictionary_literal_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/objc-dictionary-literal.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x objective-c -triple x86_64-apple-darwin10 -fblocks -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/objc-dictionary-literal.m -o /dev/null
    RUN(TestState.Failed, "%clang_cc1 -x objective-c -triple x86_64-apple-darwin10 -fblocks -emit-llvm %s -o /dev/null");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x objective-c++ -triple x86_64-apple-darwin10 -fblocks -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/objc-dictionary-literal.m -o /dev/null
    RUN(TestState.Failed, "%clang_cc1 -x objective-c++ -triple x86_64-apple-darwin10 -fblocks -emit-llvm %s -o /dev/null");
  }

  @Test
  public void test_objc_fixed_enum_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/objc-fixed-enum.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -debug-info-kind=limited -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/objc-fixed-enum.m | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/objc-fixed-enum.m
    RUN(TestState.Failed, "%clang_cc1 -debug-info-kind=limited -emit-llvm -o - %s")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_objc_gc_aggr_assign_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/objc-gc-aggr-assign.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-apple-darwin10 -fobjc-runtime=macosx-fragile-10.5 -fobjc-gc -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/objc-gc-aggr-assign.m | ${LLVM_SRC}/build/bin/FileCheck -check-prefix CHECK-C ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/objc-gc-aggr-assign.m
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-apple-darwin10 -fobjc-runtime=macosx-fragile-10.5 -fobjc-gc -emit-llvm -o - %s")./*|*/
      I("FileCheck -check-prefix CHECK-C %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x objective-c++ -triple x86_64-apple-darwin10 -fobjc-runtime=macosx-fragile-10.5 -fobjc-gc -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/objc-gc-aggr-assign.m | ${LLVM_SRC}/build/bin/FileCheck -check-prefix CHECK-CP ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/objc-gc-aggr-assign.m
    RUN(TestState.Failed, "%clang_cc1 -x objective-c++ -triple x86_64-apple-darwin10 -fobjc-runtime=macosx-fragile-10.5 -fobjc-gc -emit-llvm -o - %s")./*|*/
      I("FileCheck -check-prefix CHECK-CP %s");
  }

  @Test
  public void test_objc_literal_debugger_test_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/objc-literal-debugger-test.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-apple-darwin10 -fdebugger-objc-literal -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/objc-literal-debugger-test.m | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/objc-literal-debugger-test.m
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-apple-darwin10 -fdebugger-objc-literal -emit-llvm -o - %s")./*|*/
      I("FileCheck %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-apple-darwin10 -fdebugger-objc-literal -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/objc-literal-debugger-test.m -DINCLUDE_INTERFACES=1 | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/objc-literal-debugger-test.m
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-apple-darwin10 -fdebugger-objc-literal -emit-llvm -o - %s -DINCLUDE_INTERFACES=1")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_objc_literal_tests_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/objc-literal-tests.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x objective-c -triple x86_64-apple-darwin10 -fblocks -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/objc-literal-tests.m -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/objc-literal-tests.m
    RUN(TestState.Failed, "%clang_cc1 -x objective-c -triple x86_64-apple-darwin10 -fblocks -emit-llvm %s -o -")./*|*/
      I("FileCheck %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x objective-c++ -triple x86_64-apple-darwin10 -fblocks -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/objc-literal-tests.m -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/objc-literal-tests.m
    RUN(TestState.Failed, "%clang_cc1 -x objective-c++ -triple x86_64-apple-darwin10 -fblocks -emit-llvm %s -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_objc_read_weak_byref_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/objc-read-weak-byref.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fblocks -fobjc-gc -triple x86_64-apple-darwin -fobjc-runtime=macosx-fragile-10.5 -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/objc-read-weak-byref.m -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/objc-read-weak-byref.m
    RUN(TestState.Failed, "%clang_cc1 -fblocks -fobjc-gc -triple x86_64-apple-darwin -fobjc-runtime=macosx-fragile-10.5 -emit-llvm %s -o -")./*|*/
      I("FileCheck %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fblocks -fobjc-gc -triple i386-apple-darwin -fobjc-runtime=macosx-fragile-10.5 -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/objc-read-weak-byref.m -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/objc-read-weak-byref.m
    RUN(TestState.Failed, "%clang_cc1 -fblocks -fobjc-gc -triple i386-apple-darwin -fobjc-runtime=macosx-fragile-10.5 -emit-llvm %s -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_objc2_assign_global_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/objc2-assign-global.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-apple-darwin10 -fobjc-runtime=macosx-fragile-10.5 -fobjc-gc -emit-llvm -o ${TEST_TEMP_DIR}/objc2-assign-global.m.tmp ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/objc2-assign-global.m
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-apple-darwin10 -fobjc-runtime=macosx-fragile-10.5 -fobjc-gc -emit-llvm -o %t %s");
    // grep -F @objc_assign_global ${TEST_TEMP_DIR}/objc2-assign-global.m.tmp | ${LLVM_SRC}/build/bin/count 26
    RUN(TestState.Failed, "grep -F '@objc_assign_global' %t")./*|*/
      I("count 26");
  }

  @Test
  public void test_objc2_ivar_assign_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/objc2-ivar-assign.m");
    // REQUIRES: LP64
    if (!CHECK_REQUIRES("LP64")) {
      return;
    }
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fobjc-gc -emit-llvm -o ${TEST_TEMP_DIR}/objc2-ivar-assign.m.tmp ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/objc2-ivar-assign.m
    RUN(TestState.Failed, "%clang_cc1 -fobjc-gc -emit-llvm -o %t %s");
    // grep objc_assign_ivar ${TEST_TEMP_DIR}/objc2-ivar-assign.m.tmp | ${LLVM_SRC}/build/bin/count 6
    RUN(TestState.Failed, "grep objc_assign_ivar %t")./*|*/
      I("count 6");
  }

  @Test
  public void test_objc2_legacy_dispatch_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/objc2-legacy-dispatch.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fobjc-dispatch-method=mixed -triple i386-apple-darwin10 -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/objc2-legacy-dispatch.m | ${LLVM_SRC}/build/bin/FileCheck -check-prefix=CHECK_NEW_DISPATCH ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/objc2-legacy-dispatch.m
    RUN(TestState.Failed, "%clang_cc1 -fobjc-dispatch-method=mixed -triple i386-apple-darwin10 -emit-llvm -o - %s")./*|*/
      I("FileCheck -check-prefix=CHECK_NEW_DISPATCH %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fobjc-dispatch-method=legacy -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/objc2-legacy-dispatch.m | ${LLVM_SRC}/build/bin/FileCheck -check-prefix=CHECK_OLD_DISPATCH ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/objc2-legacy-dispatch.m
    RUN(TestState.Failed, "%clang_cc1 -fobjc-dispatch-method=legacy -emit-llvm -o - %s")./*|*/
      I("FileCheck -check-prefix=CHECK_OLD_DISPATCH %s");
  }

  @Test
  public void test_objc2_new_gc_api_strongcast_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/objc2-new-gc-api-strongcast.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-apple-darwin10 -fobjc-runtime=macosx-fragile-10.5 -fblocks -fobjc-gc -emit-llvm -o ${TEST_TEMP_DIR}/objc2-new-gc-api-strongcast.m.tmp ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/objc2-new-gc-api-strongcast.m
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-apple-darwin10 -fobjc-runtime=macosx-fragile-10.5 -fblocks -fobjc-gc -emit-llvm -o %t %s");
    // grep -F @objc_assign_strongCast ${TEST_TEMP_DIR}/objc2-new-gc-api-strongcast.m.tmp | ${LLVM_SRC}/build/bin/count 4
    RUN(TestState.Failed, "grep -F '@objc_assign_strongCast' %t")./*|*/
      I("count 4");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x objective-c++ -triple x86_64-apple-darwin10 -fobjc-runtime=macosx-fragile-10.5 -fblocks -fobjc-gc -emit-llvm -o ${TEST_TEMP_DIR}/objc2-new-gc-api-strongcast.m.tmp ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/objc2-new-gc-api-strongcast.m
    RUN(TestState.Failed, "%clang_cc1 -x objective-c++ -triple x86_64-apple-darwin10 -fobjc-runtime=macosx-fragile-10.5 -fblocks -fobjc-gc -emit-llvm -o %t %s");
    // grep -F @objc_assign_strongCast ${TEST_TEMP_DIR}/objc2-new-gc-api-strongcast.m.tmp | ${LLVM_SRC}/build/bin/count 4
    RUN(TestState.Failed, "grep -F '@objc_assign_strongCast' %t")./*|*/
      I("count 4");
  }

  @Test
  public void test_objc2_no_strong_cast_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/objc2-no-strong-cast.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm -o ${TEST_TEMP_DIR}/objc2-no-strong-cast.m.tmp ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/objc2-no-strong-cast.m
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm -o %t %s");
  }

  @Test
  public void test_objc2_no_write_barrier_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/objc2-no-write-barrier.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-apple-darwin9 -fobjc-runtime=macosx-fragile-10.5 -fobjc-gc -emit-llvm -o ${TEST_TEMP_DIR}/objc2-no-write-barrier.m.tmp ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/objc2-no-write-barrier.m
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-apple-darwin9 -fobjc-runtime=macosx-fragile-10.5 -fobjc-gc -emit-llvm -o %t %s");
    // grep objc_assign ${TEST_TEMP_DIR}/objc2-no-write-barrier.m.tmp
    RUN(TestState.Failed, "not grep 'objc_assign' %t");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x objective-c++ -triple x86_64-apple-darwin9 -fobjc-runtime=macosx-fragile-10.5 -fobjc-gc -emit-llvm -o ${TEST_TEMP_DIR}/objc2-no-write-barrier.m.tmp ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/objc2-no-write-barrier.m
    RUN(TestState.Failed, "%clang_cc1 -x objective-c++ -triple x86_64-apple-darwin9 -fobjc-runtime=macosx-fragile-10.5 -fobjc-gc -emit-llvm -o %t %s");
    // grep objc_assign ${TEST_TEMP_DIR}/objc2-no-write-barrier.m.tmp
    RUN(TestState.Failed, "not grep 'objc_assign' %t");
  }

  @Test
  public void test_objc2_nonfragile_abi_impl_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/objc2-nonfragile-abi-impl.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-apple-darwin10 -emit-llvm -o ${TEST_TEMP_DIR}/objc2-nonfragile-abi-impl.m.tmp ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/objc2-nonfragile-abi-impl.m
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-apple-darwin10 -emit-llvm -o %t %s");
  }

  @Test
  public void test_objc2_property_encode_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/objc2-property-encode.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple=i686-apple-darwin9 -emit-llvm -o ${TEST_TEMP_DIR}/objc2-property-encode.m.tmp ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/objc2-property-encode.m
    RUN(TestState.Failed, "%clang_cc1 -triple=i686-apple-darwin9 -emit-llvm -o %t %s");
    // grep -e T@\\\\22NSString\\\\22 ${TEST_TEMP_DIR}/objc2-property-encode.m.tmp
    RUN(TestState.Failed, "grep -e \"T@\\\\\\\\22NSString\\\\\\\\22\" %t");
  }

  @Test
  public void test_objc2_protocol_enc_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/objc2-protocol-enc.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple=i686-apple-darwin9 -emit-llvm -o ${TEST_TEMP_DIR}/objc2-protocol-enc.m.tmp ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/objc2-protocol-enc.m
    RUN(TestState.Failed, "%clang_cc1 -triple=i686-apple-darwin9 -emit-llvm -o %t %s");
    // grep -e T@\\\22<X>\\\22 ${TEST_TEMP_DIR}/objc2-protocol-enc.m.tmp
    RUN(TestState.Failed, "grep -e \"T@\\\\\\22<X>\\\\\\22\" %t");
    // grep -e T@\\\22<X><Y>\\\22 ${TEST_TEMP_DIR}/objc2-protocol-enc.m.tmp
    RUN(TestState.Failed, "grep -e \"T@\\\\\\22<X><Y>\\\\\\22\" %t");
    // grep -e T@\\\22<X><Y><Z>\\\22 ${TEST_TEMP_DIR}/objc2-protocol-enc.m.tmp
    RUN(TestState.Failed, "grep -e \"T@\\\\\\22<X><Y><Z>\\\\\\22\" %t");
    // grep -e T@\\\22Foo<X><Y><Z>\\\22 ${TEST_TEMP_DIR}/objc2-protocol-enc.m.tmp
    RUN(TestState.Failed, "grep -e \"T@\\\\\\22Foo<X><Y><Z>\\\\\\22\" %t");
  }

  @Test
  public void test_objc2_protocol_metadata_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/objc2-protocol-metadata.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-apple-macosx10.10 -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/objc2-protocol-metadata.m | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/objc2-protocol-metadata.m
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-apple-macosx10.10 -emit-llvm -o - %s")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_objc2_retain_codegen_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/objc2-retain-codegen.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-unknown-unknown -fobjc-runtime=macosx-fragile-10.5 -fobjc-gc-only -emit-llvm -o ${TEST_TEMP_DIR}/objc2-retain-codegen.m.tmp ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/objc2-retain-codegen.m
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-unknown-unknown -fobjc-runtime=macosx-fragile-10.5 -fobjc-gc-only -emit-llvm -o %t %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x objective-c++ -triple x86_64-unknown-unknown -fobjc-runtime=macosx-fragile-10.5 -fobjc-gc-only -emit-llvm -o ${TEST_TEMP_DIR}/objc2-retain-codegen.m.tmp ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/objc2-retain-codegen.m
    RUN(TestState.Failed, "%clang_cc1 -x objective-c++ -triple x86_64-unknown-unknown -fobjc-runtime=macosx-fragile-10.5 -fobjc-gc-only -emit-llvm -o %t %s");
  }

  @Test
  public void test_objc2_strong_cast_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/objc2-strong-cast.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fobjc-gc -emit-llvm -o ${TEST_TEMP_DIR}/objc2-strong-cast.m.tmp ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/objc2-strong-cast.m
    RUN(TestState.Failed, "%clang_cc1 -fobjc-gc -emit-llvm -o %t %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x objective-c++ -fobjc-gc -emit-llvm -o ${TEST_TEMP_DIR}/objc2-strong-cast.m.tmp ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/objc2-strong-cast.m
    RUN(TestState.Failed, "%clang_cc1 -x objective-c++ -fobjc-gc -emit-llvm -o %t %s");
  }

  @Test
  public void test_objc2_strong_cast_1_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/objc2-strong-cast-1.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-unknown-unknown -fobjc-runtime=macosx-fragile-10.5 -fobjc-gc -emit-llvm -o ${TEST_TEMP_DIR}/objc2-strong-cast-1.m.tmp ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/objc2-strong-cast-1.m
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-unknown-unknown -fobjc-runtime=macosx-fragile-10.5 -fobjc-gc -emit-llvm -o %t %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x objective-c++ -triple x86_64-unknown-unknown -fobjc-runtime=macosx-fragile-10.5 -fobjc-gc -emit-llvm -o ${TEST_TEMP_DIR}/objc2-strong-cast-1.m.tmp ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/objc2-strong-cast-1.m
    RUN(TestState.Failed, "%clang_cc1 -x objective-c++ -triple x86_64-unknown-unknown -fobjc-runtime=macosx-fragile-10.5 -fobjc-gc -emit-llvm -o %t %s");
  }

  @Test
  public void test_objc2_strong_cast_block_import_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/objc2-strong-cast-block-import.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-apple-darwin10 -fobjc-gc-only -fblocks -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/objc2-strong-cast-block-import.m | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/objc2-strong-cast-block-import.m
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-apple-darwin10 -fobjc-gc-only -fblocks  -emit-llvm -o - %s")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_objc2_weak_assign_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/objc2-weak-assign.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-apple-darwin9 -fobjc-runtime=macosx-fragile-10.5 -fobjc-gc -emit-llvm -o ${TEST_TEMP_DIR}/objc2-weak-assign.m.tmp ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/objc2-weak-assign.m
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-apple-darwin9 -fobjc-runtime=macosx-fragile-10.5 -fobjc-gc -emit-llvm -o %t %s");
    // grep -e objc_assign_weak ${TEST_TEMP_DIR}/objc2-weak-assign.m.tmp | grep -e call | ${LLVM_SRC}/build/bin/count 6
    RUN(TestState.Failed, "grep -e \"objc_assign_weak\" %t")./*|*/
      I("grep -e \"call\"")./*|*/
      I("count 6");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x objective-c++ -triple x86_64-apple-darwin9 -fobjc-runtime=macosx-fragile-10.5 -fobjc-gc -emit-llvm -o ${TEST_TEMP_DIR}/objc2-weak-assign.m.tmp ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/objc2-weak-assign.m
    RUN(TestState.Failed, "%clang_cc1 -x objective-c++ -triple x86_64-apple-darwin9 -fobjc-runtime=macosx-fragile-10.5 -fobjc-gc -emit-llvm -o %t %s");
    // grep -e objc_assign_weak ${TEST_TEMP_DIR}/objc2-weak-assign.m.tmp | grep -e call | ${LLVM_SRC}/build/bin/count 6
    RUN(TestState.Failed, "grep -e \"objc_assign_weak\" %t")./*|*/
      I("grep -e \"call\"")./*|*/
      I("count 6");
  }

  @Test
  public void test_objc2_weak_block_call_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/objc2-weak-block-call.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fblocks -fobjc-gc -triple x86_64-apple-darwin -fobjc-runtime=macosx-fragile-10.5 -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/objc2-weak-block-call.m -o - | ${LLVM_SRC}/build/bin/FileCheck -check-prefix CHECK-LP64 ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/objc2-weak-block-call.m
    RUN(TestState.Failed, "%clang_cc1 -fblocks -fobjc-gc -triple x86_64-apple-darwin -fobjc-runtime=macosx-fragile-10.5 -emit-llvm %s -o -")./*|*/
      I("FileCheck -check-prefix CHECK-LP64 %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fblocks -fobjc-gc -triple i386-apple-darwin -fobjc-runtime=macosx-fragile-10.5 -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/objc2-weak-block-call.m -o - | ${LLVM_SRC}/build/bin/FileCheck -check-prefix CHECK-LP32 ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/objc2-weak-block-call.m
    RUN(TestState.Failed, "%clang_cc1 -fblocks -fobjc-gc -triple i386-apple-darwin -fobjc-runtime=macosx-fragile-10.5 -emit-llvm %s -o -")./*|*/
      I("FileCheck -check-prefix CHECK-LP32 %s");
  }

  @Test
  public void test_objc2_weak_compare_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/objc2-weak-compare.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i386-apple-darwin9 -fobjc-runtime=macosx-fragile-10.5 -fobjc-gc -emit-llvm -o ${TEST_TEMP_DIR}/objc2-weak-compare.m.tmp ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/objc2-weak-compare.m
    RUN(TestState.Failed, "%clang_cc1 -triple i386-apple-darwin9 -fobjc-runtime=macosx-fragile-10.5 -fobjc-gc -emit-llvm -o %t %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x objective-c++ -triple i386-apple-darwin9 -fobjc-runtime=macosx-fragile-10.5 -fobjc-gc -emit-llvm -o ${TEST_TEMP_DIR}/objc2-weak-compare.m.tmp ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/objc2-weak-compare.m
    RUN(TestState.Failed, "%clang_cc1 -x objective-c++ -triple i386-apple-darwin9 -fobjc-runtime=macosx-fragile-10.5 -fobjc-gc -emit-llvm -o %t %s");
  }

  @Test
  public void test_objc2_weak_import_attribute_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/objc2-weak-import-attribute.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-apple-darwin10 -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/objc2-weak-import-attribute.m | ${LLVM_SRC}/build/bin/FileCheck -check-prefix=CHECK-X86-64 ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/objc2-weak-import-attribute.m
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-apple-darwin10 -emit-llvm -o - %s")./*|*/
      I("FileCheck -check-prefix=CHECK-X86-64 %s");
  }

  @Test
  public void test_objc2_weak_ivar_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/objc2-weak-ivar.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-apple-darwin9 -fobjc-runtime=macosx-fragile-10.5 -fobjc-gc -emit-llvm -o ${TEST_TEMP_DIR}/objc2-weak-ivar.m.tmp ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/objc2-weak-ivar.m
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-apple-darwin9 -fobjc-runtime=macosx-fragile-10.5 -fobjc-gc -emit-llvm -o %t %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x objective-c++ -triple x86_64-apple-darwin9 -fobjc-runtime=macosx-fragile-10.5 -fobjc-gc -emit-llvm -o ${TEST_TEMP_DIR}/objc2-weak-ivar.m.tmp ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/objc2-weak-ivar.m
    RUN(TestState.Failed, "%clang_cc1 -x objective-c++ -triple x86_64-apple-darwin9 -fobjc-runtime=macosx-fragile-10.5 -fobjc-gc -emit-llvm -o %t %s");
  }

  @Test
  public void test_objc2_weak_ivar_debug_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/objc2-weak-ivar-debug.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-apple-darwin9 -fobjc-runtime=macosx-fragile-10.5 -fobjc-gc -debug-info-kind=limited -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/objc2-weak-ivar-debug.m
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-apple-darwin9 -fobjc-runtime=macosx-fragile-10.5 -fobjc-gc -debug-info-kind=limited -emit-llvm -o - %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i386-apple-darwin9 -fobjc-runtime=macosx-fragile-10.5 -fobjc-gc -debug-info-kind=limited -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/objc2-weak-ivar-debug.m
    RUN(TestState.Failed, "%clang_cc1 -triple i386-apple-darwin9 -fobjc-runtime=macosx-fragile-10.5 -fobjc-gc -debug-info-kind=limited -emit-llvm -o - %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x objective-c++ -triple x86_64-apple-darwin9 -fobjc-runtime=macosx-fragile-10.5 -fobjc-gc -debug-info-kind=limited -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/objc2-weak-ivar-debug.m
    RUN(TestState.Failed, "%clang_cc1 -x objective-c++ -triple x86_64-apple-darwin9 -fobjc-runtime=macosx-fragile-10.5 -fobjc-gc -debug-info-kind=limited -emit-llvm -o - %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x objective-c++ -triple i386-apple-darwin9 -fobjc-runtime=macosx-fragile-10.5 -fobjc-gc -debug-info-kind=limited -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/objc2-weak-ivar-debug.m
    RUN(TestState.Failed, "%clang_cc1 -x objective-c++ -triple i386-apple-darwin9 -fobjc-runtime=macosx-fragile-10.5 -fobjc-gc -debug-info-kind=limited -emit-llvm -o - %s");
  }

  @Test
  public void test_objc2_write_barrier_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/objc2-write-barrier.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-apple-darwin10 -fobjc-runtime=macosx-fragile-10.5 -fobjc-gc -emit-llvm -o ${TEST_TEMP_DIR}/objc2-write-barrier.m.tmp ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/objc2-write-barrier.m
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-apple-darwin10 -fobjc-runtime=macosx-fragile-10.5 -fobjc-gc -emit-llvm -o %t %s");
    // grep -F @objc_assign_global ${TEST_TEMP_DIR}/objc2-write-barrier.m.tmp | ${LLVM_SRC}/build/bin/count 21
    RUN(TestState.Failed, "grep -F '@objc_assign_global' %t")./*|*/
      I("count 21");
    // grep -F @objc_assign_ivar ${TEST_TEMP_DIR}/objc2-write-barrier.m.tmp | ${LLVM_SRC}/build/bin/count 11
    RUN(TestState.Failed, "grep -F '@objc_assign_ivar' %t")./*|*/
      I("count 11");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x objective-c++ -triple x86_64-apple-darwin10 -fobjc-runtime=macosx-fragile-10.5 -fobjc-gc -emit-llvm -o ${TEST_TEMP_DIR}/objc2-write-barrier.m.tmp ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/objc2-write-barrier.m
    RUN(TestState.Failed, "%clang_cc1 -x objective-c++ -triple x86_64-apple-darwin10 -fobjc-runtime=macosx-fragile-10.5 -fobjc-gc -emit-llvm -o %t %s");
    // grep -F @objc_assign_global ${TEST_TEMP_DIR}/objc2-write-barrier.m.tmp | ${LLVM_SRC}/build/bin/count 21
    RUN(TestState.Failed, "grep -F '@objc_assign_global' %t")./*|*/
      I("count 21");
    // grep -F @objc_assign_ivar ${TEST_TEMP_DIR}/objc2-write-barrier.m.tmp | ${LLVM_SRC}/build/bin/count 11
    RUN(TestState.Failed, "grep -F '@objc_assign_ivar' %t")./*|*/
      I("count 11");
  }

  @Test
  public void test_objc2_write_barrier_2_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/objc2-write-barrier-2.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-apple-darwin10 -fobjc-runtime=macosx-fragile-10.5 -fobjc-gc -emit-llvm -o ${TEST_TEMP_DIR}/objc2-write-barrier-2.m.tmp ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/objc2-write-barrier-2.m
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-apple-darwin10 -fobjc-runtime=macosx-fragile-10.5 -fobjc-gc -emit-llvm -o %t %s");
    // grep -F @objc_assign_global ${TEST_TEMP_DIR}/objc2-write-barrier-2.m.tmp | ${LLVM_SRC}/build/bin/count 7
    RUN(TestState.Failed, "grep -F '@objc_assign_global' %t")./*|*/
      I("count 7");
    // grep -F @objc_assign_ivar ${TEST_TEMP_DIR}/objc2-write-barrier-2.m.tmp | ${LLVM_SRC}/build/bin/count 5
    RUN(TestState.Failed, "grep -F '@objc_assign_ivar' %t")./*|*/
      I("count 5");
    // grep -F @objc_assign_strongCast ${TEST_TEMP_DIR}/objc2-write-barrier-2.m.tmp | ${LLVM_SRC}/build/bin/count 8
    RUN(TestState.Failed, "grep -F '@objc_assign_strongCast' %t")./*|*/
      I("count 8");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x objective-c++ -triple x86_64-apple-darwin10 -fobjc-runtime=macosx-fragile-10.5 -fobjc-gc -emit-llvm -o ${TEST_TEMP_DIR}/objc2-write-barrier-2.m.tmp ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/objc2-write-barrier-2.m
    RUN(TestState.Failed, "%clang_cc1 -x objective-c++ -triple x86_64-apple-darwin10 -fobjc-runtime=macosx-fragile-10.5 -fobjc-gc -emit-llvm -o %t %s");
    // grep -F @objc_assign_global ${TEST_TEMP_DIR}/objc2-write-barrier-2.m.tmp | ${LLVM_SRC}/build/bin/count 7
    RUN(TestState.Failed, "grep -F '@objc_assign_global' %t")./*|*/
      I("count 7");
    // grep -F @objc_assign_ivar ${TEST_TEMP_DIR}/objc2-write-barrier-2.m.tmp | ${LLVM_SRC}/build/bin/count 5
    RUN(TestState.Failed, "grep -F '@objc_assign_ivar' %t")./*|*/
      I("count 5");
    // grep -F @objc_assign_strongCast ${TEST_TEMP_DIR}/objc2-write-barrier-2.m.tmp | ${LLVM_SRC}/build/bin/count 8
    RUN(TestState.Failed, "grep -F '@objc_assign_strongCast' %t")./*|*/
      I("count 8");
  }

  @Test
  public void test_objc2_write_barrier_3_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/objc2-write-barrier-3.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-apple-darwin10 -fblocks -fobjc-gc -emit-llvm -o ${TEST_TEMP_DIR}/objc2-write-barrier-3.m.tmp ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/objc2-write-barrier-3.m
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-apple-darwin10 -fblocks -fobjc-gc -emit-llvm -o %t %s");
    // grep objc_assign_ivar ${TEST_TEMP_DIR}/objc2-write-barrier-3.m.tmp | ${LLVM_SRC}/build/bin/count 3
    RUN(TestState.Failed, "grep objc_assign_ivar %t")./*|*/
      I("count 3");
    // grep objc_assign_strongCast ${TEST_TEMP_DIR}/objc2-write-barrier-3.m.tmp | ${LLVM_SRC}/build/bin/count 6
    RUN(TestState.Failed, "grep objc_assign_strongCast %t")./*|*/
      I("count 6");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x objective-c++ -triple x86_64-apple-darwin10 -fblocks -fobjc-gc -emit-llvm -o ${TEST_TEMP_DIR}/objc2-write-barrier-3.m.tmp ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/objc2-write-barrier-3.m
    RUN(TestState.Failed, "%clang_cc1 -x objective-c++ -triple x86_64-apple-darwin10 -fblocks -fobjc-gc -emit-llvm -o %t %s");
    // grep objc_assign_ivar ${TEST_TEMP_DIR}/objc2-write-barrier-3.m.tmp | ${LLVM_SRC}/build/bin/count 3
    RUN(TestState.Failed, "grep objc_assign_ivar %t")./*|*/
      I("count 3");
    // grep objc_assign_strongCast ${TEST_TEMP_DIR}/objc2-write-barrier-3.m.tmp | ${LLVM_SRC}/build/bin/count 6
    RUN(TestState.Failed, "grep objc_assign_strongCast %t")./*|*/
      I("count 6");
  }

  @Test
  public void test_objc2_write_barrier_4_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/objc2-write-barrier-4.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-apple-darwin10 -fobjc-runtime=macosx-fragile-10.5 -fobjc-gc -emit-llvm -o ${TEST_TEMP_DIR}/objc2-write-barrier-4.m.tmp ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/objc2-write-barrier-4.m
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-apple-darwin10 -fobjc-runtime=macosx-fragile-10.5 -fobjc-gc -emit-llvm -o %t %s");
    // grep objc_assign_global ${TEST_TEMP_DIR}/objc2-write-barrier-4.m.tmp | ${LLVM_SRC}/build/bin/count 3
    RUN(TestState.Failed, "grep objc_assign_global %t")./*|*/
      I("count 3");
    // grep objc_assign_strongCast ${TEST_TEMP_DIR}/objc2-write-barrier-4.m.tmp | ${LLVM_SRC}/build/bin/count 2
    RUN(TestState.Failed, "grep objc_assign_strongCast %t")./*|*/
      I("count 2");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x objective-c++ -triple x86_64-apple-darwin10 -fobjc-runtime=macosx-fragile-10.5 -fobjc-gc -emit-llvm -o ${TEST_TEMP_DIR}/objc2-write-barrier-4.m.tmp ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/objc2-write-barrier-4.m
    RUN(TestState.Failed, "%clang_cc1 -x objective-c++ -triple x86_64-apple-darwin10 -fobjc-runtime=macosx-fragile-10.5 -fobjc-gc -emit-llvm -o %t %s");
    // grep objc_assign_global ${TEST_TEMP_DIR}/objc2-write-barrier-4.m.tmp | ${LLVM_SRC}/build/bin/count 3
    RUN(TestState.Failed, "grep objc_assign_global %t")./*|*/
      I("count 3");
    // grep objc_assign_strongCast ${TEST_TEMP_DIR}/objc2-write-barrier-4.m.tmp | ${LLVM_SRC}/build/bin/count 2
    RUN(TestState.Failed, "grep objc_assign_strongCast %t")./*|*/
      I("count 2");
  }

  @Test
  public void test_objc2_write_barrier_5_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/objc2-write-barrier-5.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-apple-darwin10 -fobjc-runtime=macosx-fragile-10.5 -fobjc-gc -emit-llvm -o ${TEST_TEMP_DIR}/objc2-write-barrier-5.m.tmp ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/objc2-write-barrier-5.m
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-apple-darwin10 -fobjc-runtime=macosx-fragile-10.5 -fobjc-gc -emit-llvm -o %t %s");
    // grep objc_assign_ivar ${TEST_TEMP_DIR}/objc2-write-barrier-5.m.tmp
    RUN(TestState.Failed, "not grep objc_assign_ivar %t");
    // grep objc_assign_strongCast ${TEST_TEMP_DIR}/objc2-write-barrier-5.m.tmp | ${LLVM_SRC}/build/bin/count 8
    RUN(TestState.Failed, "grep objc_assign_strongCast %t")./*|*/
      I("count 8");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x objective-c++ -triple x86_64-apple-darwin10 -fobjc-runtime=macosx-fragile-10.5 -fobjc-gc -emit-llvm -o ${TEST_TEMP_DIR}/objc2-write-barrier-5.m.tmp ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/objc2-write-barrier-5.m
    RUN(TestState.Failed, "%clang_cc1 -x objective-c++ -triple x86_64-apple-darwin10 -fobjc-runtime=macosx-fragile-10.5 -fobjc-gc -emit-llvm -o %t %s");
    // grep objc_assign_ivar ${TEST_TEMP_DIR}/objc2-write-barrier-5.m.tmp
    RUN(TestState.Failed, "not grep objc_assign_ivar %t");
    // grep objc_assign_strongCast ${TEST_TEMP_DIR}/objc2-write-barrier-5.m.tmp | ${LLVM_SRC}/build/bin/count 8
    RUN(TestState.Failed, "grep objc_assign_strongCast %t")./*|*/
      I("count 8");
  }

  @Test
  public void test_object_incr_decr_1_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/object-incr-decr-1.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i386-apple-darwin9 -fobjc-runtime=macosx-fragile-10.5 -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/object-incr-decr-1.m -o ${TEST_TEMP_DIR}/object-incr-decr-1.m.tmp
    RUN(TestState.Failed, "%clang_cc1 -triple i386-apple-darwin9 -fobjc-runtime=macosx-fragile-10.5 -emit-llvm %s -o %t");
  }

  @Test
  public void test_objfw_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/objfw.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-pc-linux-gnu -fobjc-runtime=objfw -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/objfw.m | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/objfw.m
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-pc-linux-gnu -fobjc-runtime=objfw -emit-llvm -o - %s")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_optimize_ivar_offset_load_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/optimize-ivar-offset-load.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-apple-darwin10 -O0 -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/optimize-ivar-offset-load.m -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/optimize-ivar-offset-load.m
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-apple-darwin10  -O0 -emit-llvm %s -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_optimized_setter_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/optimized-setter.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/optimized-setter.m -emit-llvm -fobjc-runtime=macosx-10.8 -triple x86_64-apple-macosx10.8.0 -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/optimized-setter.m
    RUN(TestState.Failed, "%clang_cc1 %s -emit-llvm -fobjc-runtime=macosx-10.8 -triple x86_64-apple-macosx10.8.0 -o -")./*|*/
      I("FileCheck %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/optimized-setter.m -emit-llvm -fobjc-runtime=ios-6.0.0 -triple x86_64-apple-ios6.0.0 -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/optimized-setter.m
    RUN(TestState.Failed, "%clang_cc1 %s -emit-llvm -fobjc-runtime=ios-6.0.0  -triple x86_64-apple-ios6.0.0 -o -")./*|*/
      I("FileCheck %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/optimized-setter.m -emit-llvm -fobjc-runtime=gnustep-1.7 -triple x86_64-unknown-freebsd -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/optimized-setter.m
    RUN(TestState.Failed, "%clang_cc1 %s -emit-llvm -fobjc-runtime=gnustep-1.7 -triple x86_64-unknown-freebsd -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_optimized_setter_ios_device_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/optimized-setter-ios-device.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/optimized-setter-ios-device.m -emit-llvm -fobjc-runtime=ios-6.0.0 -triple thumbv7-apple-ios6.0.0 -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/optimized-setter-ios-device.m
    RUN(TestState.Failed, "%clang_cc1 %s -emit-llvm -fobjc-runtime=ios-6.0.0 -triple thumbv7-apple-ios6.0.0 -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_overloadable_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/overloadable.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i386-pc-solaris2.11 -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/overloadable.m -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/overloadable.m
    RUN(TestState.Failed, "%clang_cc1 -triple %itanium_abi_triple -emit-llvm %s -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_parameterized_classes_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/parameterized_classes.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-apple-darwin10 -fblocks -fobjc-arc -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/parameterized_classes.m | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/parameterized_classes.m
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-apple-darwin10 -fblocks -fobjc-arc -emit-llvm -o - %s")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_predefined_expr_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/predefined-expr.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i386-apple-darwin9 -fobjc-runtime=macosx-fragile-10.5 ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/predefined-expr.m -emit-llvm -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/predefined-expr.m
    RUN(TestState.Failed, "%clang_cc1 -triple i386-apple-darwin9 -fobjc-runtime=macosx-fragile-10.5 %s -emit-llvm -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_private_extern_selector_reference_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/private-extern-selector-reference.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-apple-ios6.0.0 -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/private-extern-selector-reference.m | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/private-extern-selector-reference.m
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-apple-ios6.0.0 -emit-llvm -o - %s")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_prop_metadata_gnu_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/prop-metadata-gnu.m");
    // ${LLVM_SRC}/build/bin/clang -S -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/prop-metadata-gnu.m -o - -x objective-c -fobjc-runtime=gcc | ${LLVM_SRC}/build/bin/FileCheck --check-prefix=GCC ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/prop-metadata-gnu.m
    RUN(TestState.Failed, "%clang -S -emit-llvm %s -o - -x objective-c -fobjc-runtime=gcc")./*|*/
      I("FileCheck --check-prefix=GCC %s");
    // ${LLVM_SRC}/build/bin/clang -S -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/prop-metadata-gnu.m -o - -x objective-c -fobjc-runtime=gnustep-1.5 | ${LLVM_SRC}/build/bin/FileCheck --check-prefix=GCC ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/prop-metadata-gnu.m
    RUN(TestState.Failed, "%clang -S -emit-llvm %s -o - -x objective-c -fobjc-runtime=gnustep-1.5")./*|*/
      I("FileCheck --check-prefix=GCC %s");
    // ${LLVM_SRC}/build/bin/clang -S -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/prop-metadata-gnu.m -o - -x objective-c -fobjc-runtime=gnustep-1.6 | ${LLVM_SRC}/build/bin/FileCheck --check-prefix=GNUSTEP ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/prop-metadata-gnu.m
    RUN(TestState.Failed, "%clang -S -emit-llvm %s -o - -x objective-c -fobjc-runtime=gnustep-1.6")./*|*/
      I("FileCheck --check-prefix=GNUSTEP %s");
  }

  @Test
  public void test_property_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/property.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i386-unknown-unknown -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/property.m | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/property.m
    RUN(TestState.Failed, "%clang_cc1 -triple i386-unknown-unknown -emit-llvm -o - %s")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_property_aggregate_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/property-aggregate.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-apple-darwin -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/property-aggregate.m -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/property-aggregate.m
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-apple-darwin -emit-llvm %s -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_property_agrr_getter_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/property-agrr-getter.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm-only ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/property-agrr-getter.m
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm-only %s");
  }

  @Test
  public void test_property_array_type_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/property-array-type.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-apple-darwin10 -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/property-array-type.m | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/property-array-type.m
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-apple-darwin10  -emit-llvm -o - %s")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_property_atomic_bool_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/property-atomic-bool.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-apple-macosx10 -emit-llvm -x objective-c ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/property-atomic-bool.m -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/property-atomic-bool.m
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-apple-macosx10 -emit-llvm -x objective-c %s -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_property_category_impl_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/property-category-impl.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-apple-darwin10 -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/property-category-impl.m | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/property-category-impl.m
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-apple-darwin10  -emit-llvm -o - %s")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_property_complex_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/property-complex.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i386-apple-darwin9 -fobjc-runtime=macosx-fragile-10.5 -emit-llvm -o ${TEST_TEMP_DIR}/property-complex.m.tmp ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/property-complex.m
    RUN(TestState.Failed, "%clang_cc1 -triple i386-apple-darwin9 -fobjc-runtime=macosx-fragile-10.5 -emit-llvm -o %t %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-apple-darwin9 -fobjc-runtime=macosx-fragile-10.5 -emit-llvm -o ${TEST_TEMP_DIR}/property-complex.m.tmp ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/property-complex.m
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-apple-darwin9 -fobjc-runtime=macosx-fragile-10.5 -emit-llvm -o %t %s");
  }

  @Test
  public void test_property_dbg_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/property-dbg.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i386-pc-solaris2.11 -S -debug-info-kind=limited -masm-verbose -x objective-c < ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/property-dbg.m | grep DW_AT_name
    RUN(TestState.Failed, "%clang_cc1 -triple %itanium_abi_triple -S -debug-info-kind=limited -masm-verbose -x objective-c < %s")./*|*/
      I("grep DW_AT_name");
  }

  @Test
  public void test_property_getter_dot_syntax_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/property-getter-dot-syntax.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm -o ${TEST_TEMP_DIR}/property-getter-dot-syntax.m.tmp ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/property-getter-dot-syntax.m
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm -o %t %s");
  }

  @Test
  public void test_property_incr_decr_1_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/property-incr-decr-1.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm -o ${TEST_TEMP_DIR}/property-incr-decr-1.m.tmp ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/property-incr-decr-1.m
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm -o %t %s");
  }

  @Test
  public void test_property_list_in_class_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/property-list-in-class.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-apple-darwin10 -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/property-list-in-class.m -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/property-list-in-class.m
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-apple-darwin10 -emit-llvm %s -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_property_list_in_extension_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/property-list-in-extension.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-apple-darwin10 -fobjc-weak -fobjc-runtime-has-weak -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/property-list-in-extension.m -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/property-list-in-extension.m
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-apple-darwin10 -fobjc-weak -fobjc-runtime-has-weak -emit-llvm %s -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_property_ref_cast_to_void_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/property-ref-cast-to-void.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-apple-darwin9 -fobjc-runtime=macosx-fragile-10.5 -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/property-ref-cast-to-void.m | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/property-ref-cast-to-void.m
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-apple-darwin9 -fobjc-runtime=macosx-fragile-10.5 -emit-llvm -o - %s")./*|*/
      I("FileCheck %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x objective-c++ -triple x86_64-apple-darwin9 -fobjc-runtime=macosx-fragile-10.5 -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/property-ref-cast-to-void.m | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/property-ref-cast-to-void.m
    RUN(TestState.Failed, "%clang_cc1 -x objective-c++ -triple x86_64-apple-darwin9 -fobjc-runtime=macosx-fragile-10.5 -emit-llvm -o - %s")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_property_section_attribute_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/property-section-attribute.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-apple-darwin10 -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/property-section-attribute.m | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/property-section-attribute.m
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-apple-darwin10 -emit-llvm -o - %s")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_property_setter_attr_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/property-setter-attr.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm -triple=i686-apple-darwin8 -o ${TEST_TEMP_DIR}/property-setter-attr.m.tmp ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/property-setter-attr.m
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm -triple=i686-apple-darwin8 -o %t %s");
    // grep -e SiSetOtherThings: ${TEST_TEMP_DIR}/property-setter-attr.m.tmp
    RUN(TestState.Failed, "grep -e \"SiSetOtherThings:\" %t");
  }

  @Test
  public void test_property_type_mismatch_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/property-type-mismatch.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-apple-darwin10 -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/property-type-mismatch.m | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/property-type-mismatch.m
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-apple-darwin10  -emit-llvm -o - %s")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_protocol_in_extended_class_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/protocol-in-extended-class.m");
    // REQUIRES: x86-registered-target
    if (!CHECK_REQUIRES("x86-registered-target")) {
      return;
    }
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-apple-darwin10 -S ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/protocol-in-extended-class.m -o ${TEST_TEMP_DIR}/protocol-in-extended-class.m.tmp-64.s
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-apple-darwin10 -S %s -o %t-64.s");
    // ${LLVM_SRC}/build/bin/FileCheck -check-prefix CHECK-LP64 '--input-file=${TEST_TEMP_DIR}/protocol-in-extended-class.m.tmp-64.s' ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/protocol-in-extended-class.m
    RUN(TestState.Failed, "FileCheck -check-prefix CHECK-LP64 --input-file=%t-64.s %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i386-apple-darwin -fobjc-runtime=macosx-fragile-10.5 -S ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/protocol-in-extended-class.m -o ${TEST_TEMP_DIR}/protocol-in-extended-class.m.tmp-32.s
    RUN(TestState.Failed, "%clang_cc1 -triple i386-apple-darwin -fobjc-runtime=macosx-fragile-10.5 -S %s -o %t-32.s");
    // ${LLVM_SRC}/build/bin/FileCheck -check-prefix CHECK-LP32 '--input-file=${TEST_TEMP_DIR}/protocol-in-extended-class.m.tmp-32.s' ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/protocol-in-extended-class.m
    RUN(TestState.Failed, "FileCheck -check-prefix CHECK-LP32 --input-file=%t-32.s %s");
  }

  @Test
  public void test_protocol_property_synth_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/protocol-property-synth.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm -o ${TEST_TEMP_DIR}/protocol-property-synth.m.tmp ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/protocol-property-synth.m
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm -o %t %s");
  }

  @Test
  public void test_protocols_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/protocols.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm-only ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/protocols.m
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm-only %s");
  }

  @Test
  public void test_protocols_lazy_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/protocols-lazy.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm -triple i686-apple-darwin8 -fobjc-runtime=macosx-fragile-10.5 -o ${TEST_TEMP_DIR}/protocols-lazy.m.tmp ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/protocols-lazy.m
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm -triple i686-apple-darwin8 -fobjc-runtime=macosx-fragile-10.5 -o %t %s");
    // grep OBJC_PROTOCOL_P0 ${TEST_TEMP_DIR}/protocols-lazy.m.tmp
    RUN(TestState.Failed, "not grep OBJC_PROTOCOL_P0 %t");
    // grep OBJC_PROTOCOL_P1 ${TEST_TEMP_DIR}/protocols-lazy.m.tmp
    RUN(TestState.Failed, "not grep OBJC_PROTOCOL_P1 %t");
    // grep OBJC_PROTOCOL_P2 ${TEST_TEMP_DIR}/protocols-lazy.m.tmp | ${LLVM_SRC}/build/bin/count 3
    RUN(TestState.Failed, "grep OBJC_PROTOCOL_P2 %t")./*|*/
      I("count 3");
    // grep OBJC_PROTOCOL_INSTANCE_METHODS_P2 ${TEST_TEMP_DIR}/protocols-lazy.m.tmp | ${LLVM_SRC}/build/bin/count 3
    RUN(TestState.Failed, "grep OBJC_PROTOCOL_INSTANCE_METHODS_P2 %t")./*|*/
      I("count 3");
    // grep OBJC_PROTOCOL_P3 ${TEST_TEMP_DIR}/protocols-lazy.m.tmp | ${LLVM_SRC}/build/bin/count 3
    RUN(TestState.Failed, "grep OBJC_PROTOCOL_P3 %t")./*|*/
      I("count 3");
    // grep OBJC_PROTOCOL_INSTANCE_METHODS_P3 ${TEST_TEMP_DIR}/protocols-lazy.m.tmp
    RUN(TestState.Failed, "not grep OBJC_PROTOCOL_INSTANCE_METHODS_P3 %t");
    // grep OBJC_PROTOCOL_P4 ${TEST_TEMP_DIR}/protocols-lazy.m.tmp | ${LLVM_SRC}/build/bin/count 3
    RUN(TestState.Failed, "grep OBJC_PROTOCOL_P4 %t")./*|*/
      I("count 3");
    // grep OBJC_PROTOCOL_INSTANCE_METHODS_P4 ${TEST_TEMP_DIR}/protocols-lazy.m.tmp | ${LLVM_SRC}/build/bin/count 3
    RUN(TestState.Failed, "grep OBJC_PROTOCOL_INSTANCE_METHODS_P4 %t")./*|*/
      I("count 3");
    // grep OBJC_PROTOCOL_P5 ${TEST_TEMP_DIR}/protocols-lazy.m.tmp | ${LLVM_SRC}/build/bin/count 3
    RUN(TestState.Failed, "grep OBJC_PROTOCOL_P5 %t")./*|*/
      I("count 3");
    // grep OBJC_PROTOCOL_INSTANCE_METHODS_P5 ${TEST_TEMP_DIR}/protocols-lazy.m.tmp | ${LLVM_SRC}/build/bin/count 3
    RUN(TestState.Failed, "grep OBJC_PROTOCOL_INSTANCE_METHODS_P5 %t")./*|*/
      I("count 3");
    // grep OBJC_PROTOCOL_P6 ${TEST_TEMP_DIR}/protocols-lazy.m.tmp | ${LLVM_SRC}/build/bin/count 4
    RUN(TestState.Failed, "grep OBJC_PROTOCOL_P6 %t")./*|*/
      I("count 4");
    // grep OBJC_PROTOCOL_INSTANCE_METHODS_P6 ${TEST_TEMP_DIR}/protocols-lazy.m.tmp | ${LLVM_SRC}/build/bin/count 3
    RUN(TestState.Failed, "grep OBJC_PROTOCOL_INSTANCE_METHODS_P6 %t")./*|*/
      I("count 3");
  }

  @Test
  public void test_rdr_6732143_dangling_block_reference_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/rdr-6732143-dangling-block-reference.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-apple-darwin9 -fobjc-runtime=macosx-fragile-10.5 -emit-llvm -fobjc-exceptions ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/rdr-6732143-dangling-block-reference.m -o -
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-apple-darwin9 -fobjc-runtime=macosx-fragile-10.5 -emit-llvm -fobjc-exceptions %s -o -");
  }

  @Test
  public void test_related_result_type_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/related-result-type.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/related-result-type.m | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/related-result-type.m
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm -o - %s")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_reorder_synthesized_ivars_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/reorder-synthesized-ivars.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-apple-darwin10 -emit-llvm -x objective-c ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/reorder-synthesized-ivars.m -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/reorder-synthesized-ivars.m
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-apple-darwin10 -emit-llvm -x objective-c %s -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_return_objc_object_mm() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/return-objc-object.mm");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64 -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/return-objc-object.mm | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/return-objc-object.mm
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64 -emit-llvm -o - %s")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_runtime_fns_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/runtime-fns.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm -o ${TEST_TEMP_DIR}/runtime-fns.m.tmp ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/runtime-fns.m
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm -o %t %s");
    // grep -e '^de.*objc_msgSend[0-9]*(' ${TEST_TEMP_DIR}/runtime-fns.m.tmp | ${LLVM_SRC}/build/bin/count 1
    RUN(TestState.Failed, "grep -e \"^de.*objc_msgSend[0-9]*(\" %t")./*|*/
      I("count 1");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -DWITHDEF -emit-llvm -o ${TEST_TEMP_DIR}/runtime-fns.m.tmp ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/runtime-fns.m
    RUN(TestState.Failed, "%clang_cc1 -DWITHDEF -emit-llvm -o %t %s");
    // grep -e '^de.*objc_msgSend[0-9]*(' ${TEST_TEMP_DIR}/runtime-fns.m.tmp | ${LLVM_SRC}/build/bin/count 1
    RUN(TestState.Failed, "grep -e \"^de.*objc_msgSend[0-9]*(\" %t")./*|*/
      I("count 1");
  }

  @Test
  public void test_sel_as_builtin_type_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/sel-as-builtin-type.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm -o ${TEST_TEMP_DIR}/sel-as-builtin-type.m.tmp ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/sel-as-builtin-type.m
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm -o %t %s");
  }

  @Test
  public void test_selector_ref_invariance_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/selector-ref-invariance.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-apple-darwin11 -emit-llvm -fblocks -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/selector-ref-invariance.m | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/selector-ref-invariance.m
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-apple-darwin11 -emit-llvm -fblocks -o - %s")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_simplify_exceptions_mm() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/simplify-exceptions.mm");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-apple-darwin10 -emit-llvm -fexceptions -fobjc-exceptions -o ${TEST_TEMP_DIR}/simplify-exceptions.mm.tmp ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/simplify-exceptions.mm
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-apple-darwin10 -emit-llvm -fexceptions -fobjc-exceptions -o %t %s");
    // ${LLVM_SRC}/build/bin/FileCheck < ${TEST_TEMP_DIR}/simplify-exceptions.mm.tmp ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/simplify-exceptions.mm
    RUN(TestState.Failed, "FileCheck < %t %s");
  }

  @Test
  public void test_stand_alone_implementation_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/stand-alone-implementation.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-apple-darwin10 -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/stand-alone-implementation.m | ${LLVM_SRC}/build/bin/FileCheck -check-prefix=CHECK-X86-64 ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/stand-alone-implementation.m
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-apple-darwin10 -emit-llvm -o - %s")./*|*/
      I("FileCheck -check-prefix=CHECK-X86-64 %s");
  }

  @Test
  public void test_stret_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/stret.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fblocks -triple x86_64-apple-darwin9 ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/stret.m -emit-llvm -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/stret.m -check-prefix=X86
    RUN(TestState.Failed, "%clang_cc1 -fblocks -triple x86_64-apple-darwin9 %s -emit-llvm -o -")./*|*/
      I("FileCheck %s -check-prefix=X86");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fblocks -triple arm-apple-darwin ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/stret.m -emit-llvm -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/stret.m -check-prefix=ARM
    RUN(TestState.Failed, "%clang_cc1 -fblocks -triple arm-apple-darwin %s -emit-llvm -o -")./*|*/
      I("FileCheck %s -check-prefix=ARM");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fblocks -triple arm64-apple-darwin ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/stret.m -emit-llvm -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/stret.m -check-prefix=ARM64
    RUN(TestState.Failed, "%clang_cc1 -fblocks -triple arm64-apple-darwin %s -emit-llvm -o -")./*|*/
      I("FileCheck %s -check-prefix=ARM64");
  }

  @Test
  public void test_stret_1_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/stret-1.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fblocks -triple arm64-apple-darwin ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/stret-1.m -emit-llvm -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/stret-1.m
    RUN(TestState.Failed, "%clang_cc1 -fblocks -triple arm64-apple-darwin %s -emit-llvm -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_stret_lookup_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/stret_lookup.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -DSTRET -triple x86_64-pc-linux-gnu -fobjc-runtime=objfw -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/stret_lookup.m | ${LLVM_SRC}/build/bin/FileCheck -check-prefix=HASSTRET ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/stret_lookup.m
    RUN(TestState.Failed, "%clang_cc1 -DSTRET -triple x86_64-pc-linux-gnu -fobjc-runtime=objfw -emit-llvm -o - %s")./*|*/
      I("FileCheck -check-prefix=HASSTRET %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-pc-linux-gnu -fobjc-runtime=gcc -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/stret_lookup.m | ${LLVM_SRC}/build/bin/FileCheck -check-prefix=NOSTRET ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/stret_lookup.m
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-pc-linux-gnu -fobjc-runtime=gcc -emit-llvm -o - %s")./*|*/
      I("FileCheck -check-prefix=NOSTRET %s");
  }

  @Test
  public void test_super_classmethod_category_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/super-classmethod-category.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm -o ${TEST_TEMP_DIR}/super-classmethod-category.m.tmp ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/super-classmethod-category.m
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm -o %t %s");
  }

  @Test
  public void test_super_dotsyntax_property_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/super-dotsyntax-property.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm -o ${TEST_TEMP_DIR}/super-dotsyntax-property.m.tmp ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/super-dotsyntax-property.m
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm -o %t %s");
  }

  @Test
  public void test_super_dotsyntax_struct_property_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/super-dotsyntax-struct-property.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-apple-darwin10 -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/super-dotsyntax-struct-property.m -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/super-dotsyntax-struct-property.m
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-apple-darwin10  -emit-llvm %s -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_super_message_fragileabi_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/super-message-fragileabi.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i386-apple-darwin9 -fobjc-runtime=macosx-fragile-10.5 -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/super-message-fragileabi.m -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/super-message-fragileabi.m
    RUN(TestState.Failed, "%clang_cc1 -triple i386-apple-darwin9 -fobjc-runtime=macosx-fragile-10.5 -emit-llvm %s -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_synchronized_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/synchronized.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm -triple i686-apple-darwin9 -fobjc-runtime=macosx-fragile-10.5 -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/synchronized.m -O2 | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/synchronized.m
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm -triple i686-apple-darwin9 -fobjc-runtime=macosx-fragile-10.5 -o - %s -O2")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_synthesize_ivar_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/synthesize_ivar.m");
    // REQUIRES: LP64
    if (!CHECK_REQUIRES("LP64")) {
      return;
    }
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm -o ${TEST_TEMP_DIR}/synthesize_ivar.m.tmp ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/synthesize_ivar.m
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm -o %t %s");
  }

  @Test
  public void test_synthesize_ivar_cont_class_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/synthesize_ivar-cont-class.m");
    // REQUIRES: LP64
    if (!CHECK_REQUIRES("LP64")) {
      return;
    }
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/synthesize_ivar-cont-class.m | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/synthesize_ivar-cont-class.m
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm -o - %s")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_tentative_cfconstantstring_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/tentative-cfconstantstring.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-apple-darwin10 -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/tentative-cfconstantstring.m | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/tentative-cfconstantstring.m
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-apple-darwin10 -emit-llvm -o - %s")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_terminate_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/terminate.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-apple-darwin -fobjc-runtime=macosx-fragile-10.8 -emit-llvm -fexceptions -fobjc-exceptions -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/terminate.m | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/terminate.m -check-prefix=CHECK-WITH
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-apple-darwin -fobjc-runtime=macosx-fragile-10.8 -emit-llvm -fexceptions -fobjc-exceptions -o - %s")./*|*/
      I("FileCheck %s -check-prefix=CHECK-WITH");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-apple-darwin -fobjc-runtime=macosx-fragile-10.7 -emit-llvm -fexceptions -fobjc-exceptions -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/terminate.m | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/terminate.m -check-prefix=CHECK-WITHOUT
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-apple-darwin -fobjc-runtime=macosx-fragile-10.7 -emit-llvm -fexceptions -fobjc-exceptions -o - %s")./*|*/
      I("FileCheck %s -check-prefix=CHECK-WITHOUT");
  }

  @Test
  public void test_try_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/try.m");
    // REQUIRES: x86-registered-target
    if (!CHECK_REQUIRES("x86-registered-target")) {
      return;
    }
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/try.m -fobjc-exceptions -S -o - -triple=i686-apple-darwin9
    RUN(TestState.Failed, "%clang_cc1 %s -fobjc-exceptions -S -o - -triple=i686-apple-darwin9");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/try.m -fobjc-exceptions -S -o - -triple=x86_64-apple-darwin9
    RUN(TestState.Failed, "%clang_cc1 %s -fobjc-exceptions -S -o - -triple=x86_64-apple-darwin9");
  }

  @Test
  public void test_undefined_protocol_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/undefined-protocol.m");
    // REQUIRES: LP64
    if (!CHECK_REQUIRES("LP64")) {
      return;
    }
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm-only -fobjc-runtime=gcc ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/undefined-protocol.m
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm-only -fobjc-runtime=gcc %s");
  }

  @Test
  public void test_undefined_protocol2_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/undefined-protocol2.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-apple-macosx -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/undefined-protocol2.m -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/undefined-protocol2.m
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-apple-macosx -emit-llvm %s -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_unname_bf_metadata_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/unname-bf-metadata.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm -o ${TEST_TEMP_DIR}/unname-bf-metadata.m.tmp ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/unname-bf-metadata.m
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm -o %t %s");
  }

  @Test
  public void test_unoptimized_setter_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/unoptimized-setter.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/unoptimized-setter.m -emit-llvm -fobjc-runtime=macosx-10.6.0 -triple x86_64-apple-macosx10.6.0 -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/unoptimized-setter.m
    RUN(TestState.Failed, "%clang_cc1 %s -emit-llvm -fobjc-runtime=macosx-10.6.0 -triple x86_64-apple-macosx10.6.0 -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_variadic_sends_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/variadic-sends.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i386-unknown-unknown -fobjc-runtime=macosx-fragile-10.5 -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/variadic-sends.m | ${LLVM_SRC}/build/bin/FileCheck -check-prefix=CHECK-X86-32 ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/variadic-sends.m
    RUN(TestState.Failed, "%clang_cc1 -triple i386-unknown-unknown -fobjc-runtime=macosx-fragile-10.5 -emit-llvm -o - %s")./*|*/
      I("FileCheck -check-prefix=CHECK-X86-32 %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-unknown-unknown -fobjc-runtime=macosx-fragile-10.5 -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/variadic-sends.m | ${LLVM_SRC}/build/bin/FileCheck -check-prefix=CHECK-X86-64 ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/variadic-sends.m
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-unknown-unknown -fobjc-runtime=macosx-fragile-10.5 -emit-llvm -o - %s")./*|*/
      I("FileCheck -check-prefix=CHECK-X86-64 %s");
  }

  @Test
  public void test_weak_metaclass_visibility_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/weak-metaclass-visibility.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-apple-darwin10 -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/weak-metaclass-visibility.m | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/weak-metaclass-visibility.m
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-apple-darwin10 -emit-llvm -o - %s")./*|*/
      I("FileCheck %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple armv7-apple-darwin10 -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/weak-metaclass-visibility.m | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/weak-metaclass-visibility.m
    RUN(TestState.Failed, "%clang_cc1 -triple armv7-apple-darwin10 -emit-llvm  -o - %s")./*|*/
      I("FileCheck %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple arm64-apple-ios -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/weak-metaclass-visibility.m | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/weak-metaclass-visibility.m
    RUN(TestState.Failed, "%clang_cc1 -triple arm64-apple-ios -emit-llvm -o - %s")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_x86_64_struct_return_gc_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/x86_64-struct-return-gc.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-apple-darwin10 -fobjc-runtime=macosx-fragile-10.5 -fobjc-gc -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/x86_64-struct-return-gc.m | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjC/x86_64-struct-return-gc.m
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-apple-darwin10 -fobjc-runtime=macosx-fragile-10.5 -fobjc-gc -emit-llvm -o - %s")./*|*/
      I("FileCheck %s");
  }
  
}
