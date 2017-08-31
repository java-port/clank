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
 * Collection of all test files from test/SemaObjC folder
 * @author Vladimir Voskresensky
 */
public class AllSemaObjCTest extends DriverTestFileBase {
  private static final String TEST_LOCATION = "${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/";
  public AllSemaObjCTest() {
    super(TEST_LOCATION, TestState.Successful);
  }
  
  public static void main(String[] args) {
    // Print tests which will be accepted per test case
    DriverTestFileBase.printAllTestFiles(false, TEST_LOCATION, (test)->true, 
            "${SPUTNIK}/modules/org.clang.sema/test/unit/src/org/clang/sema/test/AllSemaObjCTest.txt");
  }  
  
  @Override
  protected boolean keepStacksForUnimplementedMethods() {
    return false;
  }
  
  @Test
  public void test_ClassPropertyNotObject_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/ClassPropertyNotObject.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -Wno-objc-root-class ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/ClassPropertyNotObject.m
    RUN("%clang_cc1  -fsyntax-only -verify -Wno-objc-root-class %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x objective-c++ -fsyntax-only -verify -Wno-objc-root-class ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/ClassPropertyNotObject.m
    RUN("%clang_cc1 -x objective-c++ -fsyntax-only -verify -Wno-objc-root-class %s");
  }

  @Test
  public void test_ContClassPropertyLookup_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/ContClassPropertyLookup.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -Wno-objc-root-class ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/ContClassPropertyLookup.m
    RUN("%clang_cc1  -fsyntax-only -verify -Wno-objc-root-class %s");
  }

  @Test
  public void test_DoubleMethod_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/DoubleMethod.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -Wduplicate-method-match -fsyntax-only -verify -Wno-objc-root-class ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/DoubleMethod.m
    RUN("%clang_cc1 -Wduplicate-method-match -fsyntax-only -verify -Wno-objc-root-class %s");
  }

  @Test
  public void test_NSString_type_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/NSString-type.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-apple-darwin10 -fblocks -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/NSString-type.m
    RUN("%clang_cc1  -triple x86_64-apple-darwin10 -fblocks -fsyntax-only -verify %s");
  }

  @Test
  public void test_access_property_getter_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/access-property-getter.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/access-property-getter.m
    RUN("%clang_cc1 -verify %s");
  }

  @Test
  public void test_alias_test_1_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/alias-test-1.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/alias-test-1.m
    RUN("%clang_cc1 -fsyntax-only -verify %s");
  }

  @Test
  public void test_alias_test_2_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/alias-test-2.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -Wno-objc-root-class ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/alias-test-2.m
    RUN("%clang_cc1 -fsyntax-only -verify -Wno-objc-root-class %s");
  }

  @Test
  public void test_arc_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/arc.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-apple-darwin11 -fobjc-runtime-has-weak -fsyntax-only -fobjc-arc -fblocks -verify -Wno-objc-root-class ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/arc.m
    RUN("%clang_cc1 -triple x86_64-apple-darwin11 -fobjc-runtime-has-weak -fsyntax-only -fobjc-arc -fblocks -verify -Wno-objc-root-class %s");
  }

  @Test
  public void test_arc_bridged_cast_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/arc-bridged-cast.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-apple-darwin11 -fsyntax-only -fobjc-arc -fblocks -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/arc-bridged-cast.m
    RUN("%clang_cc1 -triple x86_64-apple-darwin11 -fsyntax-only -fobjc-arc -fblocks -verify %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-apple-darwin11 -fsyntax-only -fobjc-arc -fblocks -fdiagnostics-parseable-fixits ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/arc-bridged-cast.m 2>&1 | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/arc-bridged-cast.m
    RUN("not %clang_cc1 -triple x86_64-apple-darwin11 -fsyntax-only -fobjc-arc -fblocks -fdiagnostics-parseable-fixits %s 2>&1")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_arc_cf_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/arc-cf.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -fobjc-arc -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/arc-cf.m
    RUN("%clang_cc1 -fsyntax-only -fobjc-arc -verify %s");
  }

  @Test
  public void test_arc_decls_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/arc-decls.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -fblocks -fobjc-arc -verify -Wno-objc-root-class ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/arc-decls.m
    RUN("%clang_cc1 -fsyntax-only -fblocks -fobjc-arc -verify -Wno-objc-root-class %s");
  }

  @Test
  public void test_arc_dict_bridged_cast_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/arc-dict-bridged-cast.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-apple-darwin11 -fsyntax-only -fobjc-arc -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/arc-dict-bridged-cast.m
    RUN("%clang_cc1 -triple x86_64-apple-darwin11 -fsyntax-only -fobjc-arc -verify %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-apple-darwin11 -fsyntax-only -fobjc-arc -fdiagnostics-parseable-fixits ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/arc-dict-bridged-cast.m 2>&1 | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/arc-dict-bridged-cast.m
    RUN("not %clang_cc1 -triple x86_64-apple-darwin11 -fsyntax-only -fobjc-arc -fdiagnostics-parseable-fixits %s 2>&1")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_arc_invalid_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/arc-invalid.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -fobjc-arc -fblocks -Wno-objc-root-class -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/arc-invalid.m
    RUN("%clang_cc1 -fsyntax-only -fobjc-arc -fblocks -Wno-objc-root-class -verify %s");
  }

  @Test
  public void test_arc_jump_block_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/arc-jump-block.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-apple-darwin11 -fsyntax-only -fobjc-arc -fblocks -verify -Wno-objc-root-class ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/arc-jump-block.m
    RUN("%clang_cc1 -triple x86_64-apple-darwin11 -fsyntax-only -fobjc-arc -fblocks -verify -Wno-objc-root-class %s");
  }

  @Test
  public void test_arc_no_runtime_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/arc-no-runtime.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fobjc-arc -verify -Wno-objc-root-class ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/arc-no-runtime.m
    RUN("%clang_cc1 -fobjc-arc -verify -Wno-objc-root-class %s");
  }

  @Test
  public void test_arc_non_pod_memaccess_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/arc-non-pod-memaccess.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -fobjc-arc -fobjc-runtime-has-weak -verify -fblocks -triple x86_64-apple-darwin10.0.0 ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/arc-non-pod-memaccess.m
    RUN("%clang_cc1 -fsyntax-only -fobjc-arc -fobjc-runtime-has-weak -verify -fblocks -triple x86_64-apple-darwin10.0.0 %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x objective-c++ -fsyntax-only -fobjc-arc -fobjc-runtime-has-weak -verify -fblocks -triple x86_64-apple-darwin10.0.0 ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/arc-non-pod-memaccess.m
    RUN("%clang_cc1 -x objective-c++ -fsyntax-only -fobjc-arc -fobjc-runtime-has-weak -verify -fblocks -triple x86_64-apple-darwin10.0.0 %s");
  }

  @Test
  public void test_arc_nsconsumed_errors_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/arc-nsconsumed-errors.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -fobjc-arc -verify -fblocks -triple x86_64-apple-darwin10.0.0 ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/arc-nsconsumed-errors.m
    RUN("%clang_cc1 -fsyntax-only -fobjc-arc -verify -fblocks -triple x86_64-apple-darwin10.0.0 %s");
  }

  @Test
  public void test_arc_objc_lifetime_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/arc-objc-lifetime.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-apple-darwin11 -fsyntax-only -fobjc-arc -fblocks -fobjc-runtime-has-weak -Wexplicit-ownership-type -verify -Wno-objc-root-class ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/arc-objc-lifetime.m
    RUN("%clang_cc1 -triple x86_64-apple-darwin11 -fsyntax-only -fobjc-arc -fblocks -fobjc-runtime-has-weak -Wexplicit-ownership-type  -verify -Wno-objc-root-class %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x objective-c++ -triple x86_64-apple-darwin11 -fsyntax-only -fobjc-arc -fblocks -fobjc-runtime-has-weak -Wexplicit-ownership-type -verify -Wno-objc-root-class ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/arc-objc-lifetime.m
    RUN("%clang_cc1 -x objective-c++ -triple x86_64-apple-darwin11 -fsyntax-only -fobjc-arc -fblocks -fobjc-runtime-has-weak -Wexplicit-ownership-type -verify -Wno-objc-root-class %s");
  }

  @Test
  public void test_arc_objc_lifetime_conflict_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/arc-objc-lifetime-conflict.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-apple-darwin11 -fobjc-arc -fobjc-runtime-has-weak ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/arc-objc-lifetime-conflict.m -emit-llvm -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/arc-objc-lifetime-conflict.m
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-apple-darwin11 -fobjc-arc -fobjc-runtime-has-weak %s -emit-llvm -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_arc_objcbridge_related_attribute_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/arc-objcbridge-related-attribute.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -x objective-c -fobjc-arc -verify -Wno-objc-root-class ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/arc-objcbridge-related-attribute.m
    RUN(TestState.Failed, "%clang_cc1 -fsyntax-only -x objective-c -fobjc-arc -verify -Wno-objc-root-class %s");
  }

  @Test
  public void test_arc_peformselector_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/arc-peformselector.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-apple-darwin11 -fsyntax-only -fobjc-arc -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/arc-peformselector.m
    RUN("%clang_cc1 -triple x86_64-apple-darwin11 -fsyntax-only -fobjc-arc -verify %s");
  }

  @Test
  public void test_arc_property_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/arc-property.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-apple-darwin11 -fobjc-runtime-has-weak -fsyntax-only -fobjc-arc -fblocks -fobjc-exceptions -verify -Wno-objc-root-class ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/arc-property.m
    RUN("%clang_cc1 -triple x86_64-apple-darwin11 -fobjc-runtime-has-weak -fsyntax-only -fobjc-arc -fblocks -fobjc-exceptions -verify -Wno-objc-root-class %s");
  }

  @Test
  public void test_arc_property_decl_attrs_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/arc-property-decl-attrs.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-apple-darwin11 -fobjc-runtime-has-weak -fsyntax-only -fobjc-arc -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/arc-property-decl-attrs.m
    RUN("%clang_cc1 -triple x86_64-apple-darwin11 -fobjc-runtime-has-weak -fsyntax-only -fobjc-arc -verify %s");
  }

  @Test
  public void test_arc_property_lifetime_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/arc-property-lifetime.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-apple-darwin11 -fobjc-runtime-has-weak -fsyntax-only -fobjc-arc -verify -Wno-objc-root-class ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/arc-property-lifetime.m
    RUN("%clang_cc1 -triple x86_64-apple-darwin11 -fobjc-runtime-has-weak -fsyntax-only -fobjc-arc -verify -Wno-objc-root-class %s");
  }

  @Test
  public void test_arc_readonly_property_ivar_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/arc-readonly-property-ivar.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-apple-darwin11 -fobjc-runtime-has-weak -fobjc-arc -fsyntax-only -verify -Wno-objc-root-class ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/arc-readonly-property-ivar.m
    RUN("%clang_cc1  -triple x86_64-apple-darwin11 -fobjc-runtime-has-weak -fobjc-arc -fsyntax-only -verify -Wno-objc-root-class %s");
  }

  @Test
  public void test_arc_readonly_property_ivar_1_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/arc-readonly-property-ivar-1.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-apple-darwin11 -fobjc-runtime-has-weak -fobjc-arc -fsyntax-only -verify -Wno-objc-root-class ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/arc-readonly-property-ivar-1.m
    RUN("%clang_cc1   -triple x86_64-apple-darwin11 -fobjc-runtime-has-weak -fobjc-arc -fsyntax-only -verify -Wno-objc-root-class %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x objective-c++ -triple x86_64-apple-darwin11 -fobjc-runtime-has-weak -fobjc-arc -fsyntax-only -verify -Wno-objc-root-class ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/arc-readonly-property-ivar-1.m
    RUN("%clang_cc1  -x objective-c++  -triple x86_64-apple-darwin11 -fobjc-runtime-has-weak -fobjc-arc -fsyntax-only -verify -Wno-objc-root-class %s");
  }

  @Test
  public void test_arc_repeated_weak_mm() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/arc-repeated-weak.mm");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -fobjc-runtime-has-weak -fobjc-arc -fblocks -Wno-objc-root-class -std=c++11 -Warc-repeated-use-of-weak -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/arc-repeated-weak.mm
    RUN(TestState.Failed, "%clang_cc1 -fsyntax-only -fobjc-runtime-has-weak -fobjc-arc -fblocks -Wno-objc-root-class -std=c++11 -Warc-repeated-use-of-weak -verify %s");
  }

  @Test
  public void test_arc_setter_property_match_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/arc-setter-property-match.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-apple-darwin11 -fsyntax-only -fobjc-arc -fblocks -verify -Wno-objc-root-class ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/arc-setter-property-match.m
    RUN("%clang_cc1 -triple x86_64-apple-darwin11 -fsyntax-only -fobjc-arc -fblocks -verify -Wno-objc-root-class %s");
  }

  @Test
  public void test_arc_system_header_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/arc-system-header.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fobjc-arc -isystem ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/Inputs ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/arc-system-header.m -DNO_USE
    RUN("%clang_cc1 -fobjc-arc -isystem %S/Inputs %s -DNO_USE");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fobjc-arc -isystem ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/Inputs ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/arc-system-header.m -verify
    RUN("%clang_cc1 -fobjc-arc -isystem %S/Inputs %s -verify");
  }

  @Test
  public void test_arc_type_conversion_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/arc-type-conversion.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -fobjc-arc -fobjc-runtime-has-weak -verify -fblocks ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/arc-type-conversion.m
    RUN(TestState.Failed, "%clang_cc1 -fsyntax-only -fobjc-arc -fobjc-runtime-has-weak -verify -fblocks %s");
  }

  @Test
  public void test_arc_unavailable_for_weakref_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/arc-unavailable-for-weakref.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-apple-darwin11 -fobjc-runtime-has-weak -fsyntax-only -fobjc-arc -verify -Wno-objc-root-class ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/arc-unavailable-for-weakref.m
    RUN("%clang_cc1 -triple x86_64-apple-darwin11 -fobjc-runtime-has-weak -fsyntax-only -fobjc-arc -verify -Wno-objc-root-class %s");
  }

  @Test
  public void test_arc_unavailable_system_function_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/arc-unavailable-system-function.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -triple x86_64-apple-darwin11 -fobjc-arc -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/arc-unavailable-system-function.m
    RUN("%clang_cc1 -fsyntax-only -triple x86_64-apple-darwin11 -fobjc-arc -verify %s");
  }

  @Test
  public void test_arc_unsafe_assigns_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/arc-unsafe-assigns.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-apple-darwin11 -fsyntax-only -fobjc-arc -verify -Wno-objc-root-class ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/arc-unsafe-assigns.m
    RUN("%clang_cc1 -triple x86_64-apple-darwin11 -fsyntax-only -fobjc-arc -verify -Wno-objc-root-class %s");
  }

  @Test
  public void test_arc_unsafe_unretained_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/arc-unsafe_unretained.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-apple-darwin10 -fsyntax-only -verify -fblocks ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/arc-unsafe_unretained.m
    RUN("%clang_cc1 -triple x86_64-apple-darwin10 -fsyntax-only -verify -fblocks %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -fblocks -fobjc-arc ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/arc-unsafe_unretained.m
    RUN("%clang_cc1 -fsyntax-only -verify -fblocks -fobjc-arc %s");
  }

  @Test
  public void test_argument_checking_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/argument-checking.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -pedantic ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/argument-checking.m
    RUN("%clang_cc1 -fsyntax-only -verify -pedantic %s");
  }

  @Test
  public void test_assign_rvalue_message_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/assign-rvalue-message.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-apple-darwin10 -fsyntax-only -verify -Wno-objc-root-class ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/assign-rvalue-message.m
    RUN("%clang_cc1 -triple x86_64-apple-darwin10 -fsyntax-only -verify -Wno-objc-root-class %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x objective-c++ -triple x86_64-apple-darwin10 -fsyntax-only -verify -Wno-objc-root-class ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/assign-rvalue-message.m
    RUN("%clang_cc1 -x objective-c++ -triple x86_64-apple-darwin10 -fsyntax-only -verify -Wno-objc-root-class %s");
  }

  @Test
  public void test_at_defs_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/at-defs.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i386-unknown-unknown -fobjc-runtime=macosx-fragile-10.5 ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/at-defs.m -fsyntax-only
    RUN("%clang_cc1 -triple i386-unknown-unknown -fobjc-runtime=macosx-fragile-10.5 %s -fsyntax-only");
  }

  @Test
  public void test_atomoic_property_synnthesis_rules_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/atomoic-property-synnthesis-rules.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -Wno-objc-root-class ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/atomoic-property-synnthesis-rules.m
    RUN("%clang_cc1 -fsyntax-only -verify -Wno-objc-root-class %s");
  }

  @Test
  public void test_attr_availability_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/attr-availability.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-apple-darwin9.0.0 -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/attr-availability.m
    RUN("%clang_cc1 -triple x86_64-apple-darwin9.0.0 -fsyntax-only -verify %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -D WARN_PARTIAL -Wpartial-availability -triple x86_64-apple-darwin9.0.0 -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/attr-availability.m
    RUN("%clang_cc1 -D WARN_PARTIAL -Wpartial-availability -triple x86_64-apple-darwin9.0.0 -fsyntax-only -verify %s");
  }

  @Test
  public void test_attr_availability_1_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/attr-availability-1.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-apple-darwin9.0.0 -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/attr-availability-1.m
    RUN("%clang_cc1 -triple x86_64-apple-darwin9.0.0 -fsyntax-only -verify %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x objective-c++ -std=c++11 -triple x86_64-apple-darwin9.0.0 -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/attr-availability-1.m
    RUN("%clang_cc1 -x objective-c++ -std=c++11 -triple x86_64-apple-darwin9.0.0 -fsyntax-only -verify %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x objective-c++ -std=c++03 -triple x86_64-apple-darwin9.0.0 -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/attr-availability-1.m
    RUN("%clang_cc1 -x objective-c++ -std=c++03 -triple x86_64-apple-darwin9.0.0 -fsyntax-only -verify %s");
  }

  @Test
  public void test_attr_cf_returns_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/attr-cf_returns.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -verify -fsyntax-only -fobjc-arc -fblocks ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/attr-cf_returns.m
    RUN("%clang_cc1 -verify -fsyntax-only -fobjc-arc -fblocks %s");
  }

  @Test
  public void test_attr_cleanup_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/attr-cleanup.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/attr-cleanup.m -verify -fsyntax-only
    RUN("%clang_cc1 %s -verify -fsyntax-only");
  }

  @Test
  public void test_attr_deprecated_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/attr-deprecated.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -triple x86_64-apple-darwin10.4 -verify -Wno-objc-root-class ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/attr-deprecated.m
    RUN("%clang_cc1 -fsyntax-only -triple x86_64-apple-darwin10.4 -verify -Wno-objc-root-class %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x objective-c++ -fsyntax-only -triple x86_64-apple-darwin10.4 -verify -Wno-objc-root-class ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/attr-deprecated.m
    RUN("%clang_cc1 -x objective-c++ -fsyntax-only -triple x86_64-apple-darwin10.4 -verify -Wno-objc-root-class %s");
  }

  @Test
  public void test_attr_deprecated_pch_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/attr-deprecated-pch.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -DBOTH -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/attr-deprecated-pch.m
    RUN("%clang_cc1 -fsyntax-only -DBOTH -verify %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x objective-c-header ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/attr-deprecated-pch.m -emit-pch -o ${TEST_TEMP_DIR}/attr-deprecated-pch.m.tmp
    RUN(TestState.Failed, "%clang_cc1 -x objective-c-header %s -emit-pch -o %t");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -DUSES -include-pch ${TEST_TEMP_DIR}/attr-deprecated-pch.m.tmp -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/attr-deprecated-pch.m
    RUN(TestState.Failed, "%clang_cc1 -DUSES -include-pch %t -fsyntax-only -verify %s");
  }

  @Test
  public void test_attr_designated_init_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/attr-designated-init.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -Wno-incomplete-implementation -verify -fblocks ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/attr-designated-init.m
    RUN(TestState.Failed, "%clang_cc1 -fsyntax-only -Wno-incomplete-implementation -verify -fblocks %s");
  }

  @Test
  public void test_attr_malloc_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/attr-malloc.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -verify -fsyntax-only -fblocks ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/attr-malloc.m
    RUN("%clang_cc1 -verify -fsyntax-only -fblocks %s");
  }

  @Test
  public void test_attr_nodebug_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/attr-nodebug.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/attr-nodebug.m
    RUN("%clang_cc1 -fsyntax-only -verify %s");
  }

  @Test
  public void test_attr_objc_exception_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/attr-objc-exception.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/attr-objc-exception.m -fsyntax-only -verify
    RUN("%clang_cc1 %s -fsyntax-only -verify");
  }

  @Test
  public void test_attr_objc_gc_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/attr-objc-gc.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-apple-darwin10 -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/attr-objc-gc.m
    RUN("%clang_cc1 -triple x86_64-apple-darwin10 -fsyntax-only -verify %s");
  }

  @Test
  public void test_attr_objc_runtime_visible_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/attr-objc-runtime-visible.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -verify -fsyntax-only ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/attr-objc-runtime-visible.m
    RUN("%clang_cc1 -verify -fsyntax-only  %s");
  }

  @Test
  public void test_attr_print_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/attr-print.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/attr-print.m -fobjc-arc -ast-print | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/attr-print.m
    RUN("%clang_cc1 %s -fobjc-arc -ast-print")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_attr_root_class_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/attr-root-class.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -Wattributes -Wobjc-root-class ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/attr-root-class.m
    RUN("%clang_cc1 -fsyntax-only -verify -Wattributes -Wobjc-root-class %s");
  }

  @Test
  public void test_autoreleasepool_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/autoreleasepool.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -Wno-objc-root-class ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/autoreleasepool.m
    RUN("%clang_cc1 -fsyntax-only -verify -Wno-objc-root-class %s");
  }

  @Test
  public void test_bad_property_synthesis_crash_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/bad-property-synthesis-crash.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -Wno-objc-root-class ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/bad-property-synthesis-crash.m
    RUN("%clang_cc1 -fsyntax-only -verify -Wno-objc-root-class %s");
  }

  @Test
  public void test_bad_receiver_1_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/bad-receiver-1.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/bad-receiver-1.m
    RUN("%clang_cc1 -fsyntax-only -verify %s");
  }

  @Test
  public void test_block_as_object_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/block-as-object.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/block-as-object.m -fsyntax-only -verify -fblocks
    RUN("%clang_cc1 %s -fsyntax-only -verify -fblocks");
  }

  @Test
  public void test_block_attr_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/block-attr.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-apple-darwin10 -fsyntax-only -verify -fblocks -fobjc-gc-only ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/block-attr.m
    RUN("%clang_cc1 -triple x86_64-apple-darwin10 -fsyntax-only -verify -fblocks -fobjc-gc-only %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x objective-c++ -triple x86_64-apple-darwin10 -fsyntax-only -verify -fblocks -fobjc-gc-only ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/block-attr.m
    RUN("%clang_cc1 -x objective-c++ -triple x86_64-apple-darwin10 -fsyntax-only -verify -fblocks -fobjc-gc-only %s");
  }

  @Test
  public void test_block_explicit_return_type_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/block-explicit-return-type.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/block-explicit-return-type.m -verify -fblocks
    RUN("%clang_cc1 -fsyntax-only %s -verify -fblocks");
  }

  @Test
  public void test_block_id_as_block_argtype_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/block-id-as-block-argtype.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/block-id-as-block-argtype.m -fsyntax-only -verify -fblocks
    RUN("%clang_cc1 %s -fsyntax-only -verify -fblocks");
  }

  @Test
  public void test_block_ivar_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/block-ivar.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/block-ivar.m -fblocks
    RUN("%clang_cc1 -fsyntax-only -verify %s -fblocks");
  }

  @Test
  public void test_block_omitted_return_type_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/block-omitted-return-type.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/block-omitted-return-type.m -fblocks -verify -fsyntax-only
    RUN("%clang_cc1 %s -fblocks -verify -fsyntax-only");
  }

  @Test
  public void test_block_on_method_param_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/block-on-method-param.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-apple-darwin10 -fsyntax-only -verify -fblocks -Wno-objc-root-class ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/block-on-method-param.m
    RUN("%clang_cc1 -triple x86_64-apple-darwin10 -fsyntax-only -verify -fblocks -Wno-objc-root-class %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x objective-c++ -triple x86_64-apple-darwin10 -fsyntax-only -verify -fblocks -Wno-objc-root-class ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/block-on-method-param.m
    RUN("%clang_cc1 -x objective-c++ -triple x86_64-apple-darwin10 -fsyntax-only -verify -fblocks -Wno-objc-root-class %s");
  }

  @Test
  public void test_block_return_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/block-return.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-apple-darwin10 -fsyntax-only -verify -fblocks -fobjc-gc-only ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/block-return.m
    RUN("%clang_cc1 -triple x86_64-apple-darwin10 -fsyntax-only -verify -fblocks -fobjc-gc-only %s");
  }

  @Test
  public void test_block_type_safety_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/block-type-safety.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -fblocks -Wno-objc-root-class ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/block-type-safety.m
    RUN("%clang_cc1 -fsyntax-only -verify -fblocks -Wno-objc-root-class %s");
  }

  @Test
  public void test_blocks_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/blocks.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i386-pc-solaris2.11 -fsyntax-only -verify -fblocks ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/blocks.m
    RUN("%clang_cc1 -triple %itanium_abi_triple -fsyntax-only -verify -fblocks %s");
  }

  @Test
  public void test_bool_type_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/bool-type.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple thumbv7s-apple-ios8.0 -ast-dump ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/bool-type.m 2>&1 | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/bool-type.m --check-prefix CHECK-CHAR
    RUN("%clang_cc1 -triple thumbv7s-apple-ios8.0 -ast-dump \"%s\" 2>&1")./*|*/
      I("FileCheck %s --check-prefix CHECK-CHAR");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple thumbv7k-apple-watchos2.0 -ast-dump ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/bool-type.m 2>&1 | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/bool-type.m --check-prefix CHECK-BOOL
    RUN("%clang_cc1 -triple thumbv7k-apple-watchos2.0 -ast-dump \"%s\" 2>&1")./*|*/
      I("FileCheck %s --check-prefix CHECK-BOOL");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i386-apple-watchos2.0 -ast-dump ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/bool-type.m 2>&1 | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/bool-type.m --check-prefix CHECK-BOOL
    RUN("%clang_cc1 -triple i386-apple-watchos2.0 -ast-dump \"%s\" 2>&1")./*|*/
      I("FileCheck %s --check-prefix CHECK-BOOL");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple arm64-apple-ios8.0 -ast-dump ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/bool-type.m 2>&1 | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/bool-type.m --check-prefix CHECK-BOOL
    RUN("%clang_cc1 -triple arm64-apple-ios8.0 -ast-dump \"%s\" 2>&1")./*|*/
      I("FileCheck %s --check-prefix CHECK-BOOL");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-apple-ios8.0 -ast-dump ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/bool-type.m 2>&1 | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/bool-type.m --check-prefix CHECK-BOOL
    RUN("%clang_cc1 -triple x86_64-apple-ios8.0 -ast-dump \"%s\" 2>&1")./*|*/
      I("FileCheck %s --check-prefix CHECK-BOOL");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i386-apple-macosx10.10 -ast-dump ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/bool-type.m 2>&1 | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/bool-type.m --check-prefix CHECK-CHAR
    RUN("%clang_cc1 -triple i386-apple-macosx10.10 -ast-dump \"%s\" 2>&1")./*|*/
      I("FileCheck %s --check-prefix CHECK-CHAR");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-apple-macosx10.10 -ast-dump ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/bool-type.m 2>&1 | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/bool-type.m --check-prefix CHECK-CHAR
    RUN("%clang_cc1 -triple x86_64-apple-macosx10.10 -ast-dump \"%s\" 2>&1")./*|*/
      I("FileCheck %s --check-prefix CHECK-CHAR");
  }

  @Test
  public void test_boxing_illegal_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/boxing-illegal.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -Wattributes ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/boxing-illegal.m
    RUN("%clang_cc1 -fsyntax-only -verify -Wattributes %s");
  }

  @Test
  public void test_builtin_objc_assign_ivar_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/builtin_objc_assign_ivar.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x objective-c ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/builtin_objc_assign_ivar.m -fsyntax-only -verify
    RUN("%clang_cc1 -x objective-c %s -fsyntax-only -verify");
  }

  @Test
  public void test_builtin_objc_lib_functions_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/builtin_objc_lib_functions.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x objective-c ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/builtin_objc_lib_functions.m -fsyntax-only -verify
    RUN("%clang_cc1 -x objective-c %s -fsyntax-only -verify");
  }

  @Test
  public void test_builtin_objc_msgSend_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/builtin_objc_msgSend.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/builtin_objc_msgSend.m -fsyntax-only -verify
    RUN("%clang_cc1 %s -fsyntax-only -verify");
  }

  @Test
  public void test_builtin_objc_nslog_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/builtin_objc_nslog.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x objective-c ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/builtin_objc_nslog.m -fsyntax-only -verify
    RUN("%clang_cc1 -x objective-c %s -fsyntax-only -verify");
  }

  @Test
  public void test_call_super_2_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/call-super-2.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/call-super-2.m
    RUN("%clang_cc1 -fsyntax-only -verify %s");
  }

  @Test
  public void test_catch_stmt_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/catch-stmt.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -verify -fobjc-exceptions ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/catch-stmt.m
    RUN("%clang_cc1 -verify -fobjc-exceptions %s");
  }

  @Test
  public void test_category_1_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/category-1.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -Wno-objc-root-class ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/category-1.m
    RUN("%clang_cc1 -fsyntax-only -verify -Wno-objc-root-class %s");
  }

  @Test
  public void test_category_method_lookup_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/category-method-lookup.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -Wno-objc-root-class ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/category-method-lookup.m
    RUN("%clang_cc1 -fsyntax-only -verify -Wno-objc-root-class %s");
  }

  @Test
  public void test_category_method_lookup_2_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/category-method-lookup-2.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/category-method-lookup-2.m
    RUN("%clang_cc1 -fsyntax-only -verify %s");
  }

  @Test
  public void test_check_dup_decl_methods_1_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/check-dup-decl-methods-1.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -Wduplicate-method-match -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/check-dup-decl-methods-1.m
    RUN("%clang_cc1 -Wduplicate-method-match -fsyntax-only -verify %s");
  }

  @Test
  public void test_check_dup_objc_decls_1_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/check-dup-objc-decls-1.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -Wno-objc-root-class ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/check-dup-objc-decls-1.m
    RUN("%clang_cc1 -fsyntax-only -verify -Wno-objc-root-class %s");
  }

  @Test
  public void test_check_objcbridge_related_attribute_lookup_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/check-objcbridge-related-attribute-lookup.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -x objective-c -verify -Wno-objc-root-class ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/check-objcbridge-related-attribute-lookup.m
    RUN("%clang_cc1 -fsyntax-only -x objective-c -verify -Wno-objc-root-class %s");
  }

  @Test
  public void test_circular_container_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/circular-container.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-apple-darwin11 -fsyntax-only -fobjc-arc -verify -Wno-objc-root-class ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/circular-container.m
    RUN("%clang_cc1 -triple x86_64-apple-darwin11 -fsyntax-only -fobjc-arc -verify -Wno-objc-root-class %s");
  }

  @Test
  public void test_class_bitfield_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/class-bitfield.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/class-bitfield.m -fobjc-runtime=macosx-fragile-10.5 -fsyntax-only -verify
    RUN("%clang_cc1 %s -fobjc-runtime=macosx-fragile-10.5 -fsyntax-only -verify");
  }

  @Test
  public void test_class_conforming_protocol_1_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/class-conforming-protocol-1.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -Wduplicate-method-match -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/class-conforming-protocol-1.m
    RUN("%clang_cc1 -Wduplicate-method-match -fsyntax-only -verify %s");
  }

  @Test
  public void test_class_conforming_protocol_2_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/class-conforming-protocol-2.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -Wmethod-signatures -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/class-conforming-protocol-2.m
    RUN("%clang_cc1 -Wmethod-signatures -fsyntax-only -verify %s");
  }

  @Test
  public void test_class_def_test_1_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/class-def-test-1.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -Wno-objc-root-class ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/class-def-test-1.m
    RUN("%clang_cc1 -fsyntax-only -verify -Wno-objc-root-class %s");
  }

  @Test
  public void test_class_extension_after_implementation_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/class-extension-after-implementation.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -Wno-objc-root-class ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/class-extension-after-implementation.m
    RUN("%clang_cc1 -fsyntax-only -verify -Wno-objc-root-class %s");
  }

  @Test
  public void test_class_extension_dup_methods_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/class-extension-dup-methods.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/class-extension-dup-methods.m
    RUN("%clang_cc1 -fsyntax-only -verify %s");
  }

  @Test
  public void test_class_getter_using_dotsyntax_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/class-getter-using-dotsyntax.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -Wno-objc-root-class ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/class-getter-using-dotsyntax.m
    RUN("%clang_cc1 -fsyntax-only -verify -Wno-objc-root-class %s");
  }

  @Test
  public void test_class_impl_1_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/class-impl-1.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -Wno-objc-root-class ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/class-impl-1.m
    RUN("%clang_cc1 -fsyntax-only -verify -Wno-objc-root-class %s");
  }

  @Test
  public void test_class_message_protocol_lookup_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/class-message-protocol-lookup.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -Wno-objc-root-class ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/class-message-protocol-lookup.m
    RUN("%clang_cc1  -fsyntax-only -verify -Wno-objc-root-class %s");
  }

  @Test
  public void test_class_method_lookup_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/class-method-lookup.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/class-method-lookup.m
    RUN("%clang_cc1 -fsyntax-only -verify %s");
  }

  @Test
  public void test_class_method_self_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/class-method-self.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -verify -Wno-objc-root-class ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/class-method-self.m
    RUN("%clang_cc1 -verify -Wno-objc-root-class %s");
  }

  @Test
  public void test_class_property_access_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/class-property-access.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/class-property-access.m
    RUN("%clang_cc1 -fsyntax-only -verify %s");
  }

  @Test
  public void test_class_proto_1_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/class-proto-1.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/class-proto-1.m
    RUN("%clang_cc1 -fsyntax-only -verify %s");
  }

  @Test
  public void test_class_protocol_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/class-protocol.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/class-protocol.m
    RUN("%clang_cc1  -fsyntax-only -verify %s");
  }

  @Test
  public void test_class_protocol_method_match_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/class-protocol-method-match.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -Woverriding-method-mismatch -fsyntax-only -verify -Wno-objc-root-class ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/class-protocol-method-match.m
    RUN("%clang_cc1  -Woverriding-method-mismatch -fsyntax-only -verify -Wno-objc-root-class %s");
  }

  @Test
  public void test_class_unavail_warning_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/class-unavail-warning.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -triple x86_64-apple-darwin10 -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/class-unavail-warning.m
    RUN("%clang_cc1  -fsyntax-only  -triple x86_64-apple-darwin10 -verify %s");
  }

  @Test
  public void test_cocoa_api_usage_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/cocoa-api-usage.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-apple-darwin10 -fobjc-arc ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/cocoa-api-usage.m -fsyntax-only -Wobjc-cocoa-api -verify
    RUN("%clang_cc1 -triple x86_64-apple-darwin10 -fobjc-arc %s -fsyntax-only -Wobjc-cocoa-api -verify");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-apple-darwin10 -fobjc-arc -x objective-c ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/cocoa-api-usage.m.fixed -fsyntax-only
    RUN("%clang_cc1 -triple x86_64-apple-darwin10 -fobjc-arc -x objective-c %s.fixed -fsyntax-only");
    // cp ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/cocoa-api-usage.m ${TEST_TEMP_DIR}/cocoa-api-usage.m.tmp.m
    RUN("cp %s %t.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-apple-darwin10 -fobjc-arc ${TEST_TEMP_DIR}/cocoa-api-usage.m.tmp.m -fixit -Wobjc-cocoa-api
    RUN("%clang_cc1 -triple x86_64-apple-darwin10 -fobjc-arc %t.m -fixit -Wobjc-cocoa-api");
    // diff ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/cocoa-api-usage.m.fixed ${TEST_TEMP_DIR}/cocoa-api-usage.m.tmp.m
    RUN("diff %s.fixed %t.m");
  }

  @Test
  public void test_cocoa_api_usage_m_fixed() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/cocoa-api-usage.m.fixed");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-apple-darwin10 -fobjc-arc ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/cocoa-api-usage.m.fixed -fsyntax-only -Wobjc-cocoa-api -verify
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-apple-darwin10 -fobjc-arc %s -fsyntax-only -Wobjc-cocoa-api -verify");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-apple-darwin10 -fobjc-arc -x objective-c ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/cocoa-api-usage.m.fixed.fixed -fsyntax-only
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-apple-darwin10 -fobjc-arc -x objective-c %s.fixed -fsyntax-only");
    // cp ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/cocoa-api-usage.m.fixed ${TEST_TEMP_DIR}/cocoa-api-usage.m.fixed.tmp.m
    RUN(TestState.Failed, "cp %s %t.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-apple-darwin10 -fobjc-arc ${TEST_TEMP_DIR}/cocoa-api-usage.m.fixed.tmp.m -fixit -Wobjc-cocoa-api
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-apple-darwin10 -fobjc-arc %t.m -fixit -Wobjc-cocoa-api");
    // diff ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/cocoa-api-usage.m.fixed.fixed ${TEST_TEMP_DIR}/cocoa-api-usage.m.fixed.tmp.m
    RUN(TestState.Failed, "diff %s.fixed %t.m");
  }

  @Test
  public void test_compare_qualified_class_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/compare-qualified-class.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/compare-qualified-class.m
    RUN("%clang_cc1 -fsyntax-only -verify %s");
  }

  @Test
  public void test_compare_qualified_id_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/compare-qualified-id.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/compare-qualified-id.m
    RUN("%clang_cc1 -fsyntax-only -verify %s");
  }

  @Test
  public void test_compatible_protocol_qualified_types_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/compatible-protocol-qualified-types.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -pedantic -fsyntax-only -verify -Wno-objc-root-class ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/compatible-protocol-qualified-types.m
    RUN("%clang_cc1 -pedantic -fsyntax-only -verify -Wno-objc-root-class %s");
  }

  @Test
  public void test_compound_init_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/compound-init.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/compound-init.m
    RUN("%clang_cc1 -fsyntax-only -verify %s");
  }

  @Test
  public void test_comptypes_1_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/comptypes-1.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -pedantic ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/comptypes-1.m
    RUN("%clang_cc1 -fsyntax-only -verify -pedantic %s");
  }

  @Test
  public void test_comptypes_10_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/comptypes-10.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -Wno-objc-root-class ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/comptypes-10.m
    RUN("%clang_cc1 -fsyntax-only -verify -Wno-objc-root-class %s");
  }

  @Test
  public void test_comptypes_2_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/comptypes-2.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/comptypes-2.m
    RUN("%clang_cc1 -fsyntax-only -verify %s");
  }

  @Test
  public void test_comptypes_3_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/comptypes-3.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/comptypes-3.m
    RUN("%clang_cc1 -fsyntax-only -verify %s");
  }

  @Test
  public void test_comptypes_4_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/comptypes-4.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/comptypes-4.m
    RUN("%clang_cc1 -fsyntax-only -verify %s");
  }

  @Test
  public void test_comptypes_5_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/comptypes-5.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -pedantic -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/comptypes-5.m
    RUN("%clang_cc1 -fsyntax-only -pedantic -verify %s");
  }

  @Test
  public void test_comptypes_6_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/comptypes-6.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -pedantic ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/comptypes-6.m
    RUN("%clang_cc1 -fsyntax-only -verify -pedantic %s");
  }

  @Test
  public void test_comptypes_7_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/comptypes-7.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -pedantic ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/comptypes-7.m
    RUN("%clang_cc1 -fsyntax-only -verify -pedantic %s");
  }

  @Test
  public void test_comptypes_8_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/comptypes-8.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/comptypes-8.m
    RUN("%clang_cc1 -fsyntax-only -verify %s");
  }

  @Test
  public void test_comptypes_9_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/comptypes-9.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/comptypes-9.m
    RUN("%clang_cc1 -fsyntax-only %s");
  }

  @Test
  public void test_comptypes_a_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/comptypes-a.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -Wmethod-signatures -verify -pedantic -Wno-objc-root-class ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/comptypes-a.m
    RUN("%clang_cc1 -fsyntax-only -Wmethod-signatures -verify -pedantic -Wno-objc-root-class %s");
  }

  @Test
  public void test_comptypes_legal_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/comptypes-legal.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -pedantic ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/comptypes-legal.m
    RUN("%clang_cc1 -fsyntax-only -verify -pedantic %s");
  }

  @Test
  public void test_conditional_expr_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/conditional-expr.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -pedantic -Wno-objc-root-class ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/conditional-expr.m
    RUN("%clang_cc1 -fsyntax-only -verify -pedantic -Wno-objc-root-class %s");
  }

  @Test
  public void test_conditional_expr_2_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/conditional-expr-2.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/conditional-expr-2.m
    RUN("%clang_cc1 -fsyntax-only -verify %s");
  }

  @Test
  public void test_conditional_expr_3_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/conditional-expr-3.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/conditional-expr-3.m
    RUN("%clang_cc1 -fsyntax-only -verify %s");
  }

  @Test
  public void test_conditional_expr_4_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/conditional-expr-4.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/conditional-expr-4.m
    RUN("%clang_cc1 -fsyntax-only -verify %s");
  }

  @Test
  public void test_conditional_expr_5_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/conditional-expr-5.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -Wno-objc-root-class ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/conditional-expr-5.m
    RUN("%clang_cc1 -fsyntax-only -verify -Wno-objc-root-class %s");
  }

  @Test
  public void test_conditional_expr_6_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/conditional-expr-6.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/conditional-expr-6.m
    RUN("%clang_cc1 -fsyntax-only -verify %s");
  }

  @Test
  public void test_conditional_expr_7_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/conditional-expr-7.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/conditional-expr-7.m
    RUN("%clang_cc1 -fsyntax-only -verify %s");
  }

  @Test
  public void test_conditional_expr_8_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/conditional-expr-8.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/conditional-expr-8.m
    RUN("%clang_cc1 -fsyntax-only -verify %s");
  }

  @Test
  public void test_conflict_atomic_property_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/conflict-atomic-property.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/conflict-atomic-property.m
    RUN("%clang_cc1  -fsyntax-only -verify %s");
  }

  @Test
  public void test_conflict_nonfragile_abi2_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/conflict-nonfragile-abi2.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -verify -fsyntax-only -Wno-objc-root-class ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/conflict-nonfragile-abi2.m
    RUN("%clang_cc1 -verify -fsyntax-only -Wno-objc-root-class %s");
  }

  @Test
  public void test_conflicting_ivar_test_1_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/conflicting-ivar-test-1.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fobjc-runtime=macosx-fragile-10.5 -fsyntax-only -verify -Wno-objc-root-class ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/conflicting-ivar-test-1.m
    RUN("%clang_cc1 -fobjc-runtime=macosx-fragile-10.5 -fsyntax-only -verify -Wno-objc-root-class %s");
  }

  @Test
  public void test_continuation_class_err_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/continuation-class-err.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -Wno-objc-root-class ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/continuation-class-err.m
    RUN("%clang_cc1 -fsyntax-only -verify -Wno-objc-root-class %s");
  }

  @Test
  public void test_continuation_class_property_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/continuation-class-property.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/continuation-class-property.m
    RUN("%clang_cc1  -fsyntax-only -verify %s");
  }

  @Test
  public void test_conversion_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/conversion.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -Wconversion -fsyntax-only ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/conversion.m -verify
    RUN("%clang_cc1 -Wconversion -fsyntax-only %s -verify");
  }

  @Test
  public void test_crash_label_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/crash-label.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/crash-label.m
    RUN("%clang_cc1  -fsyntax-only -verify %s");
  }

  @Test
  public void test_crash_on_objc_bool_literal_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/crash-on-objc-bool-literal.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/crash-on-objc-bool-literal.m
    RUN("%clang_cc1  -fsyntax-only -verify %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x objective-c++ -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/crash-on-objc-bool-literal.m
    RUN("%clang_cc1 -x objective-c++ -fsyntax-only -verify %s");
  }

  @Test
  public void test_custom_atomic_property_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/custom-atomic-property.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -Wcustom-atomic-properties -verify -Wno-objc-root-class ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/custom-atomic-property.m
    RUN("%clang_cc1  -fsyntax-only -Wcustom-atomic-properties -verify -Wno-objc-root-class %s");
  }

  @Test
  public void test_dealloc_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/dealloc.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-apple-darwin11 -fsyntax-only -fobjc-arc -fblocks -Wdealloc-in-category -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/dealloc.m
    RUN("%clang_cc1 -triple x86_64-apple-darwin11 -fsyntax-only -fobjc-arc -fblocks -Wdealloc-in-category -verify %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-apple-darwin11 -fsyntax-only -fobjc-arc -fblocks -Wdealloc-in-category -fdiagnostics-parseable-fixits ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/dealloc.m 2>&1 | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/dealloc.m
    RUN("not %clang_cc1 -triple x86_64-apple-darwin11 -fsyntax-only -fobjc-arc -fblocks -Wdealloc-in-category -fdiagnostics-parseable-fixits %s 2>&1")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_debugger_cast_result_to_id_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/debugger-cast-result-to-id.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -funknown-anytype -fsyntax-only -fdebugger-support -fdebugger-cast-result-to-id -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/debugger-cast-result-to-id.m
    RUN("%clang_cc1 -funknown-anytype -fsyntax-only -fdebugger-support -fdebugger-cast-result-to-id -verify %s");
  }

  @Test
  public void test_debugger_support_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/debugger-support.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-apple-darwin10 -fdebugger-support ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/debugger-support.m -emit-llvm -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/debugger-support.m
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-apple-darwin10 -fdebugger-support %s -emit-llvm -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_default_synthesize_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/default-synthesize.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -Wno-objc-root-class ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/default-synthesize.m
    RUN("%clang_cc1 -fsyntax-only -verify -Wno-objc-root-class %s");
  }

  @Test
  public void test_default_synthesize_1_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/default-synthesize-1.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -Wobjc-missing-property-synthesis -verify -Wno-objc-root-class ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/default-synthesize-1.m
    RUN("%clang_cc1 -fsyntax-only -Wobjc-missing-property-synthesis -verify -Wno-objc-root-class %s");
  }

  @Test
  public void test_default_synthesize_2_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/default-synthesize-2.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x objective-c -fsyntax-only -verify -Wno-objc-root-class ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/default-synthesize-2.m
    RUN("%clang_cc1 -x objective-c -fsyntax-only -verify -Wno-objc-root-class %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x objective-c++ -fsyntax-only -verify -Wno-objc-root-class ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/default-synthesize-2.m
    RUN("%clang_cc1 -x objective-c++ -fsyntax-only -verify -Wno-objc-root-class %s");
  }

  @Test
  public void test_default_synthesize_3_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/default-synthesize-3.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x objective-c -fsyntax-only -verify -Wno-objc-root-class ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/default-synthesize-3.m
    RUN(TestState.Failed, "%clang_cc1 -x objective-c -fsyntax-only -verify -Wno-objc-root-class %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x objective-c++ -fsyntax-only -verify -Wno-objc-root-class ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/default-synthesize-3.m
    RUN(TestState.Failed, "%clang_cc1 -x objective-c++ -fsyntax-only -verify -Wno-objc-root-class %s");
  }

  @Test
  public void test_delay_parsing_cfunctions_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/delay-parsing-cfunctions.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -Werror -verify -Wno-objc-root-class ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/delay-parsing-cfunctions.m
    RUN("%clang_cc1  -fsyntax-only -Werror -verify -Wno-objc-root-class %s");
  }

  @Test
  public void test_deprecate_function_containers_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/deprecate_function_containers.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -fblocks -verify -Wno-objc-root-class ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/deprecate_function_containers.m
    RUN("%clang_cc1  -fsyntax-only -fblocks -verify -Wno-objc-root-class %s");
  }

  @Test
  public void test_deprecated_objc_introspection_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/deprecated-objc-introspection.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple=x86_64-apple-darwin -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/deprecated-objc-introspection.m
    RUN("%clang_cc1 -triple=x86_64-apple-darwin -fsyntax-only -verify %s");
  }

  @Test
  public void test_deref_interface_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/deref-interface.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -verify -fsyntax-only -Wno-objc-root-class ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/deref-interface.m
    RUN("%clang_cc1 -verify -fsyntax-only -Wno-objc-root-class %s");
  }

  @Test
  public void test_direct_synthesized_ivar_access_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/direct-synthesized-ivar-access.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -Wno-objc-root-class ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/direct-synthesized-ivar-access.m
    RUN("%clang_cc1 -fsyntax-only -verify -Wno-objc-root-class %s");
  }

  @Test
  public void test_dist_object_modifiers_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/dist-object-modifiers.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -Wno-objc-root-class ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/dist-object-modifiers.m
    RUN("%clang_cc1  -fsyntax-only -verify -Wno-objc-root-class %s");
  }

  @Test
  public void test_dllexport_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/dllexport.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i686-windows -fdeclspec -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/dllexport.m
    RUN("%clang_cc1 -triple i686-windows -fdeclspec -fsyntax-only -verify %s");
  }

  @Test
  public void test_dllimport_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/dllimport.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i686-windows -fdeclspec -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/dllimport.m
    RUN("%clang_cc1 -triple i686-windows -fdeclspec -fsyntax-only -verify %s");
  }

  @Test
  public void test_duplicate_ivar_check_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/duplicate-ivar-check.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/duplicate-ivar-check.m
    RUN("%clang_cc1 -fsyntax-only -verify %s");
  }

  @Test
  public void test_duplicate_ivar_in_class_extension_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/duplicate-ivar-in-class-extension.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/duplicate-ivar-in-class-extension.m
    RUN("%clang_cc1 -fsyntax-only -verify %s");
  }

  @Test
  public void test_duplicate_property_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/duplicate-property.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/duplicate-property.m
    RUN("%clang_cc1 -fsyntax-only -verify %s");
  }

  @Test
  public void test_duplicate_property_class_extension_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/duplicate-property-class-extension.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/duplicate-property-class-extension.m
    RUN("%clang_cc1  -fsyntax-only -verify %s");
  }

  @Test
  public void test_encode_typeof_test_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/encode-typeof-test.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -Wno-objc-root-class ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/encode-typeof-test.m
    RUN(TestState.Failed, "%clang_cc1  -fsyntax-only -verify -Wno-objc-root-class %s");
  }

  @Test
  public void test_enhanced_proto_2_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/enhanced-proto-2.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -verify -Wno-objc-root-class ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/enhanced-proto-2.m
    RUN("%clang_cc1 -verify -Wno-objc-root-class %s");
  }

  @Test
  public void test_enum_fixed_type_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/enum-fixed-type.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -pedantic -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/enum-fixed-type.m
    RUN("%clang_cc1 -fsyntax-only -pedantic -verify %s");
  }

  @Test
  public void test_err_ivar_access_in_class_method_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/err-ivar-access-in-class-method.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x objective-c -fsyntax-only -verify -Wno-objc-root-class ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/err-ivar-access-in-class-method.m
    RUN("%clang_cc1 -x objective-c -fsyntax-only -verify -Wno-objc-root-class %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x objective-c++ -fsyntax-only -verify -Wno-objc-root-class ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/err-ivar-access-in-class-method.m
    RUN("%clang_cc1 -x objective-c++ -fsyntax-only -verify -Wno-objc-root-class %s");
  }

  @Test
  public void test_error_implicit_property_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/error-implicit-property.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -Wno-objc-root-class -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/error-implicit-property.m
    RUN("%clang_cc1 -Wno-objc-root-class -verify %s");
  }

  @Test
  public void test_error_missing_getter_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/error-missing-getter.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/error-missing-getter.m
    RUN("%clang_cc1  -fsyntax-only -verify %s");
  }

  @Test
  public void test_error_outof_scope_property_use_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/error-outof-scope-property-use.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -Wno-objc-root-class ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/error-outof-scope-property-use.m
    RUN("%clang_cc1  -fsyntax-only -verify -Wno-objc-root-class %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x objective-c++ -fsyntax-only -verify -Wno-objc-root-class ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/error-outof-scope-property-use.m
    RUN("%clang_cc1 -x objective-c++ -fsyntax-only -verify -Wno-objc-root-class %s");
  }

  @Test
  public void test_error_property_gc_attr_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/error-property-gc-attr.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i386-apple-darwin9 -fobjc-gc -fsyntax-only -verify -Wno-objc-root-class ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/error-property-gc-attr.m
    RUN("%clang_cc1 -triple i386-apple-darwin9 -fobjc-gc -fsyntax-only -verify -Wno-objc-root-class %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x objective-c++ -triple i386-apple-darwin9 -fobjc-gc -fsyntax-only -verify -Wno-objc-root-class ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/error-property-gc-attr.m
    RUN("%clang_cc1 -x objective-c++ -triple i386-apple-darwin9 -fobjc-gc -fsyntax-only -verify -Wno-objc-root-class %s");
  }

  @Test
  public void test_exprs_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/exprs.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/exprs.m -fsyntax-only -fblocks -verify -Wno-unreachable-code
    RUN("%clang_cc1 %s -fsyntax-only -fblocks -verify -Wno-unreachable-code");
  }

  @Test
  public void test_foreach_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/foreach.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -Wall -fsyntax-only -verify -std=c89 -pedantic ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/foreach.m
    RUN("%clang_cc1 -Wall -fsyntax-only -verify -std=c89 -pedantic %s");
  }

  @Test
  public void test_format_arg_attribute_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/format-arg-attribute.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -verify -fsyntax-only ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/format-arg-attribute.m
    RUN("%clang_cc1 -verify -fsyntax-only %s");
  }

  @Test
  public void test_format_cstrings_warning_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/format-cstrings-warning.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -Wcstring-format-directive -verify -fsyntax-only ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/format-cstrings-warning.m
    RUN("%clang_cc1 -Wcstring-format-directive -verify -fsyntax-only %s");
  }

  @Test
  public void test_format_ostrace_warning_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/format-ostrace-warning.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -Wcstring-format-directive -verify -fsyntax-only ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/format-ostrace-warning.m
    RUN("%clang_cc1 -Wcstring-format-directive -verify -fsyntax-only %s");
  }

  @Test
  public void test_format_strings_objc_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/format-strings-objc.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-apple-darwin -Wformat-nonliteral -fsyntax-only -fblocks -verify -Wno-objc-root-class ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/format-strings-objc.m
    RUN("%clang_cc1 -triple x86_64-apple-darwin -Wformat-nonliteral -fsyntax-only -fblocks -verify -Wno-objc-root-class %s");
  }

  @Test
  public void test_format_strings_utf8_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/format-strings-utf8.m");
    // REQUIRES: system-darwin
    if (!CHECK_REQUIRES("system-darwin")) {
      return;
    }
    // rm -f ${TEST_TEMP_DIR}/format-strings-utf8.m.tmp.log
    RUN(TestState.Failed, "rm -f %t.log");
    // env RC_DEBUG_OPTIONS=1 CC_LOG_DIAGNOSTICS=1 'CC_LOG_DIAGNOSTICS_FILE=${TEST_TEMP_DIR}/format-strings-utf8.m.tmp.log' ${LLVM_SRC}/build/bin/clang -target x86_64-apple-darwin -fsyntax-only ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/format-strings-utf8.m
    RUN(TestState.Failed, "env RC_DEBUG_OPTIONS=1 CC_LOG_DIAGNOSTICS=1 CC_LOG_DIAGNOSTICS_FILE=%t.log %clang -target x86_64-apple-darwin -fsyntax-only %s");
    // ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/format-strings-utf8.m < ${TEST_TEMP_DIR}/format-strings-utf8.m.tmp.log
    RUN(TestState.Failed, "FileCheck %s < %t.log");
  }

  @Test
  public void test_forward_class_1_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/forward-class-1.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -Wno-objc-root-class ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/forward-class-1.m
    RUN("%clang_cc1 -fsyntax-only -verify -Wno-objc-root-class %s");
  }

  @Test
  public void test_forward_class_receiver_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/forward-class-receiver.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/forward-class-receiver.m
    RUN("%clang_cc1  -fsyntax-only -verify %s");
  }

  @Test
  public void test_forward_class_redeclare_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/forward-class-redeclare.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/forward-class-redeclare.m
    RUN("%clang_cc1 -fsyntax-only -verify %s");
  }

  @Test
  public void test_forward_protocol_incomplete_impl_warn_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/forward-protocol-incomplete-impl-warn.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/forward-protocol-incomplete-impl-warn.m
    RUN("%clang_cc1 -fsyntax-only -verify %s");
  }

  @Test
  public void test_gc_attributes_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/gc-attributes.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-apple-darwin10 -fobjc-gc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/gc-attributes.m
    RUN("%clang_cc1 -triple x86_64-apple-darwin10 -fobjc-gc -fsyntax-only -verify %s");
  }

  @Test
  public void test_gcc_cast_ext_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/gcc-cast-ext.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -verify -fms-extensions -Wno-objc-root-class ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/gcc-cast-ext.m
    RUN("%clang_cc1 -verify -fms-extensions -Wno-objc-root-class %s");
  }

  @Test
  public void test_generic_selection_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/generic-selection.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/generic-selection.m
    RUN("%clang_cc1 -fsyntax-only -verify %s");
  }

  @Test
  public void test_getter_setter_defined_in_category_of_parent_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/getter-setter-defined-in-category-of-parent.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -Wno-objc-root-class ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/getter-setter-defined-in-category-of-parent.m
    RUN("%clang_cc1 -fsyntax-only -verify -Wno-objc-root-class %s");
  }

  @Test
  public void test_ibaction_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/ibaction.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -verify -Wno-objc-root-class ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/ibaction.m
    RUN("%clang_cc1 -verify -Wno-objc-root-class %s");
  }

  @Test
  public void test_iboutlet_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/iboutlet.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -fobjc-arc -Wno-objc-root-class -Warc-repeated-use-of-weak -fobjc-runtime-has-weak -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/iboutlet.m
    RUN(TestState.Failed, "%clang_cc1 -fsyntax-only -fobjc-arc -Wno-objc-root-class -Warc-repeated-use-of-weak -fobjc-runtime-has-weak -verify %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x objective-c++ -fsyntax-only -fobjc-arc -Wno-objc-root-class -Warc-repeated-use-of-weak -fobjc-runtime-has-weak -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/iboutlet.m
    RUN(TestState.Failed, "%clang_cc1 -x objective-c++ -fsyntax-only -fobjc-arc -Wno-objc-root-class -Warc-repeated-use-of-weak -fobjc-runtime-has-weak -verify %s");
  }

  @Test
  public void test_iboutletcollection_attr_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/iboutletcollection-attr.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/iboutletcollection-attr.m
    RUN("%clang_cc1 -fsyntax-only -verify %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x objective-c++ -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/iboutletcollection-attr.m
    RUN("%clang_cc1 -x objective-c++ -fsyntax-only -verify %s");
  }

  @Test
  public void test_id_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/id.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/id.m
    RUN("%clang_cc1 -fsyntax-only -verify %s");
  }

  @Test
  public void test_id_builtin_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/id_builtin.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/id_builtin.m -fsyntax-only -verify
    RUN("%clang_cc1 %s -fsyntax-only -verify");
  }

  @Test
  public void test_idiomatic_parentheses_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/idiomatic-parentheses.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -Wparentheses -Wno-objc-root-class ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/idiomatic-parentheses.m
    RUN("%clang_cc1 -fsyntax-only -verify -Wparentheses -Wno-objc-root-class %s");
  }

  @Test
  public void test_ignore_qualifier_on_qualified_id_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/ignore-qualifier-on-qualified-id.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/ignore-qualifier-on-qualified-id.m
    RUN("%clang_cc1 -fsyntax-only -verify %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x objective-c++ -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/ignore-qualifier-on-qualified-id.m
    RUN("%clang_cc1 -x objective-c++ -fsyntax-only -verify %s");
  }

  @Test
  public void test_ignore_weakimport_method_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/ignore-weakimport-method.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/ignore-weakimport-method.m
    RUN("%clang_cc1  -fsyntax-only -verify %s");
  }

  @Test
  public void test_illegal_nonarc_bridged_cast_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/illegal-nonarc-bridged-cast.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-apple-darwin11 -fsyntax-only -fblocks -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/illegal-nonarc-bridged-cast.m
    RUN("%clang_cc1 -triple x86_64-apple-darwin11 -fsyntax-only -fblocks -verify %s");
  }

  @Test
  public void test_incompatible_protocol_qualified_types_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/incompatible-protocol-qualified-types.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -pedantic -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/incompatible-protocol-qualified-types.m
    RUN("%clang_cc1 -pedantic -fsyntax-only -verify %s");
  }

  @Test
  public void test_incomplete_implementation_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/incomplete-implementation.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-apple-darwin9 -fsyntax-only -verify -Wno-objc-root-class ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/incomplete-implementation.m
    RUN("%clang_cc1 -triple x86_64-apple-darwin9 -fsyntax-only -verify -Wno-objc-root-class %s");
  }

  @Test
  public void test_inst_method_lookup_in_root_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/inst-method-lookup-in-root.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/inst-method-lookup-in-root.m
    RUN("%clang_cc1  -fsyntax-only -verify %s");
  }

  @Test
  public void test_instancetype_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/instancetype.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/instancetype.m
    RUN("%clang_cc1 -fsyntax-only -verify %s");
  }

  @Test
  public void test_interface_1_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/interface-1.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i386-apple-darwin9 -fobjc-runtime=macosx-fragile-10.5 ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/interface-1.m -fsyntax-only -verify
    RUN("%clang_cc1 -triple i386-apple-darwin9 -fobjc-runtime=macosx-fragile-10.5 %s -fsyntax-only -verify");
  }

  @Test
  public void test_interface_layout_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/interface-layout.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/interface-layout.m -fsyntax-only -verify -triple i386-apple-darwin9 -fobjc-runtime=macosx-fragile-10.5
    RUN("%clang_cc1 %s -fsyntax-only -verify  -triple i386-apple-darwin9 -fobjc-runtime=macosx-fragile-10.5");
  }

  @Test
  public void test_interface_layout_2_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/interface-layout-2.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/interface-layout-2.m -fsyntax-only -verify
    RUN("%clang_cc1 %s -fsyntax-only -verify");
  }

  @Test
  public void test_interface_scope_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/interface-scope.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/interface-scope.m
    RUN("%clang_cc1 -fsyntax-only -verify %s");
  }

  @Test
  public void test_interface_scope_2_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/interface-scope-2.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -triple i686-apple-darwin9 -Wno-objc-root-class ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/interface-scope-2.m
    RUN("%clang_cc1 -fsyntax-only -verify -triple i686-apple-darwin9 -Wno-objc-root-class %s");
  }

  @Test
  public void test_interface_tu_variable_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/interface-tu-variable.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/interface-tu-variable.m
    RUN("%clang_cc1 -fsyntax-only -verify %s");
  }

  @Test
  public void test_invalid_code_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/invalid-code.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -fobjc-exceptions -Wno-objc-root-class ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/invalid-code.m
    RUN("%clang_cc1 -fsyntax-only -verify -fobjc-exceptions -Wno-objc-root-class %s");
  }

  @Test
  public void test_invalid_objc_decls_1_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/invalid-objc-decls-1.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/invalid-objc-decls-1.m
    RUN("%clang_cc1 -fsyntax-only -verify %s");
  }

  @Test
  public void test_invalid_receiver_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/invalid-receiver.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/invalid-receiver.m
    RUN("%clang_cc1 -fsyntax-only -verify %s");
  }

  @Test
  public void test_invalid_typename_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/invalid-typename.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/invalid-typename.m
    RUN("%clang_cc1 -fsyntax-only -verify %s");
  }

  @Test
  public void test_ivar_access_package_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/ivar-access-package.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/ivar-access-package.m
    RUN("%clang_cc1 -fsyntax-only -verify %s");
  }

  @Test
  public void test_ivar_access_tests_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/ivar-access-tests.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -Wno-objc-root-class ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/ivar-access-tests.m
    RUN("%clang_cc1 -fsyntax-only -verify -Wno-objc-root-class %s");
  }

  @Test
  public void test_ivar_in_class_extension_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/ivar-in-class-extension.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -Wno-objc-root-class ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/ivar-in-class-extension.m
    RUN("%clang_cc1 -fsyntax-only -verify -Wno-objc-root-class %s");
  }

  @Test
  public void test_ivar_in_class_extension_error_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/ivar-in-class-extension-error.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fobjc-runtime=macosx-fragile-10.5 -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/ivar-in-class-extension-error.m
    RUN("%clang_cc1 -fobjc-runtime=macosx-fragile-10.5 -fsyntax-only -verify %s");
  }

  @Test
  public void test_ivar_in_implementations_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/ivar-in-implementations.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -Wno-objc-root-class ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/ivar-in-implementations.m
    RUN("%clang_cc1 -fsyntax-only -verify -Wno-objc-root-class %s");
  }

  @Test
  public void test_ivar_lookup_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/ivar-lookup.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -Wno-objc-root-class ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/ivar-lookup.m
    RUN("%clang_cc1 -fsyntax-only -verify -Wno-objc-root-class %s");
  }

  @Test
  public void test_ivar_lookup_resolution_builtin_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/ivar-lookup-resolution-builtin.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -Wno-objc-root-class ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/ivar-lookup-resolution-builtin.m
    RUN("%clang_cc1  -fsyntax-only -verify -Wno-objc-root-class %s");
  }

  @Test
  public void test_ivar_ref_misuse_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/ivar-ref-misuse.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -Wno-objc-root-class ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/ivar-ref-misuse.m
    RUN("%clang_cc1 -fsyntax-only -verify -Wno-objc-root-class %s");
  }

  @Test
  public void test_ivar_sem_check_1_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/ivar-sem-check-1.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/ivar-sem-check-1.m
    RUN("%clang_cc1 -fsyntax-only -verify %s");
  }

  @Test
  public void test_ivar_sem_check_2_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/ivar-sem-check-2.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/ivar-sem-check-2.m
    RUN("%clang_cc1  -fsyntax-only -verify %s");
  }

  @Test
  public void test_kindof_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/kindof.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fblocks -fsyntax-only ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/kindof.m -verify -Wmethod-signatures
    RUN(TestState.Failed, "%clang_cc1 -fblocks -fsyntax-only %s -verify -Wmethod-signatures");
  }

  @Test
  public void test_legacy_implementation_1_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/legacy-implementation-1.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -Wno-objc-root-class ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/legacy-implementation-1.m
    RUN("%clang_cc1 -fsyntax-only -verify -Wno-objc-root-class %s");
  }

  @Test
  public void test_message_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/message.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -Wno-objc-root-class ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/message.m
    RUN("%clang_cc1 -fsyntax-only -verify -Wno-objc-root-class %s");
  }

  @Test
  public void test_method_arg_qualifier_warning_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/method-arg-qualifier-warning.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/method-arg-qualifier-warning.m
    RUN("%clang_cc1  -fsyntax-only -verify %s");
  }

  @Test
  public void test_method_attributes_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/method-attributes.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i386-unknown-unknown -verify -fsyntax-only -Wno-objc-root-class ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/method-attributes.m
    RUN("%clang_cc1 -triple i386-unknown-unknown -verify -fsyntax-only -Wno-objc-root-class %s");
  }

  @Test
  public void test_method_bad_param_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/method-bad-param.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -Wno-objc-root-class ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/method-bad-param.m
    RUN("%clang_cc1 -fsyntax-only -verify -Wno-objc-root-class %s");
  }

  @Test
  public void test_method_conflict_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/method-conflict.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -Wmethod-signatures -fsyntax-only -verify -Wno-objc-root-class ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/method-conflict.m
    RUN("%clang_cc1 -Wmethod-signatures -fsyntax-only -verify -Wno-objc-root-class %s");
  }

  @Test
  public void test_method_conflict_1_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/method-conflict-1.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -Wno-objc-root-class ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/method-conflict-1.m
    RUN("%clang_cc1 -fsyntax-only -verify -Wno-objc-root-class %s");
  }

  @Test
  public void test_method_conflict_2_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/method-conflict-2.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -Wmethod-signatures -fsyntax-only -verify -Wno-objc-root-class ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/method-conflict-2.m
    RUN("%clang_cc1 -Wmethod-signatures -fsyntax-only -verify -Wno-objc-root-class %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x objective-c++ -Wmethod-signatures -fsyntax-only -verify -Wno-objc-root-class ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/method-conflict-2.m
    RUN("%clang_cc1 -x objective-c++ -Wmethod-signatures -fsyntax-only -verify -Wno-objc-root-class %s");
  }

  @Test
  public void test_method_def_1_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/method-def-1.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -Wmethod-signatures -fsyntax-only -verify -Wno-objc-root-class ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/method-def-1.m
    RUN("%clang_cc1 -Wmethod-signatures -fsyntax-only -verify -Wno-objc-root-class %s");
  }

  @Test
  public void test_method_def_2_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/method-def-2.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -ast-print ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/method-def-2.m
    RUN("%clang_cc1 -ast-print %s");
  }

  @Test
  public void test_method_encoding_2_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/method-encoding-2.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/method-encoding-2.m
    RUN("%clang_cc1 %s");
  }

  @Test
  public void test_method_in_class_extension_impl_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/method-in-class-extension-impl.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/method-in-class-extension-impl.m
    RUN("%clang_cc1  -fsyntax-only -verify %s");
  }

  @Test
  public void test_method_lookup_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/method-lookup.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -Wno-objc-root-class ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/method-lookup.m
    RUN("%clang_cc1 -fsyntax-only -verify -Wno-objc-root-class %s");
  }

  @Test
  public void test_method_lookup_2_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/method-lookup-2.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/method-lookup-2.m
    RUN("%clang_cc1 -fsyntax-only -verify %s");
  }

  @Test
  public void test_method_lookup_3_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/method-lookup-3.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/method-lookup-3.m
    RUN("%clang_cc1 -fsyntax-only -verify %s");
  }

  @Test
  public void test_method_lookup_4_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/method-lookup-4.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/method-lookup-4.m
    RUN("%clang_cc1 -fsyntax-only -verify %s");
  }

  @Test
  public void test_method_lookup_5_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/method-lookup-5.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/method-lookup-5.m
    RUN("%clang_cc1 -fsyntax-only -verify %s");
  }

  @Test
  public void test_method_no_context_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/method-no-context.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/method-no-context.m
    RUN("%clang_cc1 -fsyntax-only -verify %s");
  }

  @Test
  public void test_method_not_defined_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/method-not-defined.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/method-not-defined.m
    RUN("%clang_cc1 -fsyntax-only -verify %s");
  }

  @Test
  public void test_method_prototype_scope_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/method-prototype-scope.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -Wduplicate-method-arg -verify -Wno-objc-root-class ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/method-prototype-scope.m
    RUN("%clang_cc1  -fsyntax-only -Wduplicate-method-arg -verify -Wno-objc-root-class %s");
  }

  @Test
  public void test_method_sentinel_attr_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/method-sentinel-attr.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/method-sentinel-attr.m
    RUN("%clang_cc1  -fsyntax-only -verify %s");
  }

  @Test
  public void test_method_typecheck_1_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/method-typecheck-1.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -Wno-objc-root-class ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/method-typecheck-1.m
    RUN("%clang_cc1 -fsyntax-only -verify -Wno-objc-root-class %s");
  }

  @Test
  public void test_method_typecheck_2_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/method-typecheck-2.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/method-typecheck-2.m
    RUN("%clang_cc1 -fsyntax-only -verify %s");
  }

  @Test
  public void test_method_typecheck_3_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/method-typecheck-3.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -Wmethod-signatures -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/method-typecheck-3.m
    RUN("%clang_cc1 -Wmethod-signatures -fsyntax-only -verify %s");
  }

  @Test
  public void test_method_undef_category_warn_1_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/method-undef-category-warn-1.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/method-undef-category-warn-1.m
    RUN("%clang_cc1 -fsyntax-only -verify %s");
  }

  @Test
  public void test_method_undef_extension_warn_1_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/method-undef-extension-warn-1.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -Wno-objc-root-class ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/method-undef-extension-warn-1.m
    RUN("%clang_cc1 -fsyntax-only -verify -Wno-objc-root-class %s");
  }

  @Test
  public void test_method_undefined_warn_1_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/method-undefined-warn-1.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -Wno-objc-root-class ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/method-undefined-warn-1.m
    RUN("%clang_cc1 -fsyntax-only -verify -Wno-objc-root-class %s");
  }

  @Test
  public void test_method_unused_attribute_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/method-unused-attribute.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -Wunused-parameter -verify -Wno-objc-root-class ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/method-unused-attribute.m
    RUN("%clang_cc1  -fsyntax-only -Wunused-parameter -verify -Wno-objc-root-class %s");
  }

  @Test
  public void test_method_warn_unused_attribute_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/method-warn-unused-attribute.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -Wunused-value -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/method-warn-unused-attribute.m
    RUN("%clang_cc1  -fsyntax-only -Wunused-value -verify %s");
  }

  @Test
  public void test_mismatched_undefined_method_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/mismatched-undefined-method.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -Wno-deprecated-declarations -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/mismatched-undefined-method.m
    RUN("%clang_cc1  -fsyntax-only -Wno-deprecated-declarations -verify %s");
  }

  @Test
  public void test_missing_atend_metadata_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/missing-atend-metadata.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i386-apple-darwin9 -fsyntax-only -verify -Wno-objc-root-class ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/missing-atend-metadata.m
    RUN("%clang_cc1 -triple i386-apple-darwin9 -fsyntax-only -verify -Wno-objc-root-class %s");
  }

  @Test
  public void test_missing_method_context_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/missing-method-context.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/missing-method-context.m -verify -fsyntax-only
    RUN("%clang_cc1 %s -verify -fsyntax-only");
  }

  @Test
  public void test_missing_method_return_type_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/missing-method-return-type.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -Wmissing-method-return-type -fsyntax-only -verify -Wno-objc-root-class ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/missing-method-return-type.m
    RUN("%clang_cc1 -Wmissing-method-return-type -fsyntax-only -verify -Wno-objc-root-class %s");
  }

  @Test
  public void test_mrc_no_weak_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/mrc-no-weak.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fobjc-runtime=macosx-10.8 -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/mrc-no-weak.m
    RUN("%clang_cc1 -fobjc-runtime=macosx-10.8 -fsyntax-only -verify %s");
  }

  @Test
  public void test_mrc_weak_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/mrc-weak.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fobjc-runtime-has-weak -fobjc-weak -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/mrc-weak.m
    RUN("%clang_cc1 -fobjc-runtime-has-weak -fobjc-weak -fsyntax-only -verify %s");
  }

  @Test
  public void test_multiple_method_names_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/multiple-method-names.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -Wobjc-multiple-method-names -x objective-c ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/multiple-method-names.m -verify
    RUN("%clang_cc1 -Wobjc-multiple-method-names -x objective-c %s -verify");
  }

  @Test
  public void test_multiple_property_deprecated_decl_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/multiple-property-deprecated-decl.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -triple x86_64-apple-macosx10.11 -verify -Wno-objc-root-class ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/multiple-property-deprecated-decl.m
    RUN("%clang_cc1  -fsyntax-only -triple x86_64-apple-macosx10.11 -verify -Wno-objc-root-class %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x objective-c++ -fsyntax-only -triple x86_64-apple-macosx10.11 -verify -Wno-objc-root-class ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/multiple-property-deprecated-decl.m
    RUN("%clang_cc1 -x objective-c++ -fsyntax-only -triple x86_64-apple-macosx10.11 -verify -Wno-objc-root-class %s");
  }

  @Test
  public void test_narrow_property_type_in_cont_class_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/narrow-property-type-in-cont-class.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x objective-c -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/narrow-property-type-in-cont-class.m
    RUN("%clang_cc1 -x objective-c -fsyntax-only -verify %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x objective-c++ -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/narrow-property-type-in-cont-class.m
    RUN("%clang_cc1 -x objective-c++ -fsyntax-only -verify %s");
  }

  @Test
  public void test_nested_typedef_decl_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/nested-typedef-decl.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x objective-c -fsyntax-only -verify -Wno-objc-root-class ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/nested-typedef-decl.m
    RUN("%clang_cc1 -x objective-c -fsyntax-only -verify -Wno-objc-root-class %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x objective-c++ -fsyntax-only -verify -Wno-objc-root-class ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/nested-typedef-decl.m
    RUN("%clang_cc1 -x objective-c++ -fsyntax-only -verify -Wno-objc-root-class %s");
  }

  @Test
  public void test_newproperty_class_method_1_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/newproperty-class-method-1.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -verify -fsyntax-only -Wno-objc-root-class ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/newproperty-class-method-1.m
    RUN("%clang_cc1 -verify -fsyntax-only -Wno-objc-root-class %s");
  }

  @Test
  public void test_no_gc_weak_test_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/no-gc-weak-test.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i386-apple-darwin9 -fsyntax-only -verify -Wno-objc-root-class ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/no-gc-weak-test.m
    RUN("%clang_cc1 -triple i386-apple-darwin9 -fsyntax-only -verify -Wno-objc-root-class %s");
  }

  @Test
  public void test_no_ivar_access_control_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/no-ivar-access-control.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -fdebugger-support -verify -Wno-objc-root-class ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/no-ivar-access-control.m
    RUN("%clang_cc1 -fsyntax-only -fdebugger-support -verify -Wno-objc-root-class %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x objective-c++ -fdebugger-support -fsyntax-only -verify -Wno-objc-root-class ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/no-ivar-access-control.m
    RUN("%clang_cc1 -x objective-c++ -fdebugger-support -fsyntax-only -verify -Wno-objc-root-class %s");
  }

  @Test
  public void test_no_ivar_in_interface_block_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/no-ivar-in-interface-block.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -Wno-objc-root-class -Wobjc-interface-ivars ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/no-ivar-in-interface-block.m
    RUN("%clang_cc1  -fsyntax-only -verify -Wno-objc-root-class -Wobjc-interface-ivars %s");
  }

  @Test
  public void test_no_objc_exceptions_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/no-objc-exceptions.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/no-objc-exceptions.m
    RUN("%clang_cc1 -fsyntax-only -verify %s");
  }

  @Test
  public void test_no_protocol_option_tests_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/no-protocol-option-tests.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -Wno-protocol -verify -Wno-objc-root-class ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/no-protocol-option-tests.m
    RUN("%clang_cc1 -fsyntax-only -Wno-protocol -verify -Wno-objc-root-class %s");
  }

  @Test
  public void test_no_warn_qual_mismatch_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/no-warn-qual-mismatch.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -Wno-objc-root-class ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/no-warn-qual-mismatch.m
    RUN("%clang_cc1  -fsyntax-only -verify -Wno-objc-root-class %s");
  }

  @Test
  public void test_no_warn_synth_protocol_meth_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/no-warn-synth-protocol-meth.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -Wno-objc-root-class ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/no-warn-synth-protocol-meth.m
    RUN("%clang_cc1  -fsyntax-only -verify -Wno-objc-root-class %s");
  }

  @Test
  public void test_no_warn_unimpl_method_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/no-warn-unimpl-method.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-apple-darwin10 -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/no-warn-unimpl-method.m
    RUN("%clang_cc1 -triple x86_64-apple-darwin10 -fsyntax-only -verify %s");
  }

  @Test
  public void test_no_warning_unavail_unimp_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/no-warning-unavail-unimp.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-apple-darwin9 -fsyntax-only -verify -Wno-objc-root-class ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/no-warning-unavail-unimp.m
    RUN("%clang_cc1 -triple x86_64-apple-darwin9 -fsyntax-only -verify -Wno-objc-root-class %s");
  }

  @Test
  public void test_nonnull_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/nonnull.m");
    // REQUIRES: LP64
    if (!CHECK_REQUIRES("LP64")) {
      return;
    }
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fblocks -fsyntax-only -verify -Wno-objc-root-class ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/nonnull.m
    RUN(TestState.Failed, "%clang_cc1 -fblocks -fsyntax-only -verify -Wno-objc-root-class %s");
  }

  @Test
  public void test_nowarn_superclass_method_mismatch_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/nowarn-superclass-method-mismatch.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -fobjc-arc -fobjc-runtime-has-weak -Wsuper-class-method-mismatch -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/nowarn-superclass-method-mismatch.m
    RUN("%clang_cc1  -fsyntax-only -fobjc-arc -fobjc-runtime-has-weak -Wsuper-class-method-mismatch -verify %s");
  }

  @Test
  public void test_ns_returns_retained_block_return_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/ns_returns_retained_block_return.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fblocks -fsyntax-only -verify -Wno-objc-root-class ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/ns_returns_retained_block_return.m
    RUN("%clang_cc1  -fblocks -fsyntax-only -verify -Wno-objc-root-class %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x objective-c++ -fblocks -fsyntax-only -verify -Wno-objc-root-class ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/ns_returns_retained_block_return.m
    RUN("%clang_cc1 -x objective-c++ -fblocks -fsyntax-only -verify -Wno-objc-root-class %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fblocks -fobjc-arc -fsyntax-only -verify -Wno-objc-root-class ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/ns_returns_retained_block_return.m
    RUN("%clang_cc1  -fblocks -fobjc-arc -fsyntax-only -verify -Wno-objc-root-class %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x objective-c++ -fblocks -fobjc-arc -fsyntax-only -verify -Wno-objc-root-class ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/ns_returns_retained_block_return.m
    RUN("%clang_cc1 -x objective-c++ -fblocks -fobjc-arc -fsyntax-only -verify -Wno-objc-root-class %s");
  }

  @Test
  public void test_nsobject_attribute_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/nsobject-attribute.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -Wno-objc-root-class ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/nsobject-attribute.m
    RUN("%clang_cc1 -fsyntax-only -verify -Wno-objc-root-class %s");
  }

  @Test
  public void test_nsobject_attribute_1_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/nsobject-attribute-1.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fblocks -fsyntax-only -verify -Wno-objc-root-class ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/nsobject-attribute-1.m
    RUN("%clang_cc1 -fblocks -fsyntax-only -verify -Wno-objc-root-class %s");
  }

  @Test
  public void test_nullability_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/nullability.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -fblocks -Woverriding-method-mismatch -Wno-nullability-declspec ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/nullability.m -verify
    RUN("%clang_cc1 -fsyntax-only -fblocks -Woverriding-method-mismatch -Wno-nullability-declspec %s -verify");
  }

  @Test
  public void test_nullability_arc_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/nullability-arc.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fobjc-arc -fsyntax-only -Woverriding-method-mismatch ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/nullability-arc.m -verify
    RUN("%clang_cc1 -fobjc-arc -fsyntax-only -Woverriding-method-mismatch %s -verify");
  }

  @Test
  public void test_nullable_weak_property_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/nullable-weak-property.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fobjc-arc -fobjc-runtime-has-weak -Wnullable-to-nonnull-conversion ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/nullable-weak-property.m -verify
    RUN("%clang_cc1 -fobjc-arc -fobjc-runtime-has-weak -Wnullable-to-nonnull-conversion %s -verify");
  }

  @Test
  public void test_objc_array_literal_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/objc-array-literal.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/objc-array-literal.m
    RUN("%clang_cc1  -fsyntax-only -verify %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -triple i386-apple-macosx10.9.0 -fobjc-runtime=macosx-fragile-10.9.0 -fobjc-subscripting-legacy-runtime -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/objc-array-literal.m
    RUN("%clang_cc1  -fsyntax-only -triple i386-apple-macosx10.9.0 -fobjc-runtime=macosx-fragile-10.9.0 -fobjc-subscripting-legacy-runtime -verify %s");
  }

  @Test
  public void test_objc_asm_attribute_neg_test_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/objc-asm-attribute-neg-test.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -Wno-objc-root-class ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/objc-asm-attribute-neg-test.m
    RUN("%clang_cc1  -fsyntax-only -verify -Wno-objc-root-class %s");
  }

  @Test
  public void test_objc_boxed_expressions_nsvalue_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/objc-boxed-expressions-nsvalue.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -triple x86_64-apple-macosx10.9 -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/objc-boxed-expressions-nsvalue.m
    RUN("%clang_cc1  -fsyntax-only -triple x86_64-apple-macosx10.9 -verify %s");
  }

  @Test
  public void test_objc_buffered_methods_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/objc-buffered-methods.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -Wno-objc-root-class ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/objc-buffered-methods.m
    RUN("%clang_cc1 -fsyntax-only -verify -Wno-objc-root-class %s");
  }

  @Test
  public void test_objc_cf_audited_warning_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/objc-cf-audited-warning.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fobjc-arc -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/objc-cf-audited-warning.m
    RUN("%clang_cc1  -fobjc-arc -verify %s");
  }

  @Test
  public void test_objc_class_property_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/objc-class-property.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/objc-class-property.m
    RUN("%clang_cc1 -fsyntax-only -verify %s");
  }

  @Test
  public void test_objc_container_subscripting_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/objc-container-subscripting.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/objc-container-subscripting.m
    RUN("%clang_cc1  -fsyntax-only -verify %s");
  }

  @Test
  public void test_objc_container_subscripting_1_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/objc-container-subscripting-1.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/objc-container-subscripting-1.m
    RUN("%clang_cc1  -fsyntax-only -verify %s");
  }

  @Test
  public void test_objc_container_subscripting_2_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/objc-container-subscripting-2.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/objc-container-subscripting-2.m
    RUN("%clang_cc1  -fsyntax-only -verify %s");
  }

  @Test
  public void test_objc_container_subscripting_3_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/objc-container-subscripting-3.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/objc-container-subscripting-3.m
    RUN("%clang_cc1  -fsyntax-only -verify %s");
  }

  @Test
  public void test_objc_container_subscripting_attr_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/objc-container-subscripting-attr.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -Wno-objc-root-class ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/objc-container-subscripting-attr.m
    RUN(TestState.Failed, "%clang_cc1  -fsyntax-only -verify -Wno-objc-root-class %s");
  }

  @Test
  public void test_objc_cstyle_args_in_methods_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/objc-cstyle-args-in-methods.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -Wno-deprecated-declarations -verify -Wno-objc-root-class ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/objc-cstyle-args-in-methods.m
    RUN("%clang_cc1  -fsyntax-only -Wno-deprecated-declarations -verify -Wno-objc-root-class %s");
  }

  @Test
  public void test_objc_dictionary_literal_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/objc-dictionary-literal.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/objc-dictionary-literal.m
    RUN("%clang_cc1  -fsyntax-only -verify %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -triple i386-apple-macosx10.9.0 -fobjc-runtime=macosx-fragile-10.9.0 -fobjc-subscripting-legacy-runtime -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/objc-dictionary-literal.m
    RUN("%clang_cc1  -fsyntax-only -triple i386-apple-macosx10.9.0 -fobjc-runtime=macosx-fragile-10.9.0 -fobjc-subscripting-legacy-runtime -verify %s");
  }

  @Test
  public void test_objc_independent_class_attribute_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/objc-independent-class-attribute.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -Wno-objc-root-class ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/objc-independent-class-attribute.m
    RUN("%clang_cc1 -fsyntax-only -verify -Wno-objc-root-class %s");
  }

  @Test
  public void test_objc_literal_comparison_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/objc-literal-comparison.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -Wno-everything -Wobjc-literal-compare '-Dnil=((id)0)' -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/objc-literal-comparison.m
    RUN("%clang_cc1 -fsyntax-only -Wno-everything -Wobjc-literal-compare \"-Dnil=((id)0)\" -verify %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -Wno-everything -Wobjc-literal-compare '-Dnil=(id)0' -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/objc-literal-comparison.m
    RUN("%clang_cc1 -fsyntax-only -Wno-everything -Wobjc-literal-compare \"-Dnil=(id)0\" -verify %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -Wno-everything -Wobjc-literal-compare -Dnil=0 -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/objc-literal-comparison.m
    RUN("%clang_cc1 -fsyntax-only -Wno-everything -Wobjc-literal-compare \"-Dnil=0\" -verify %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -Wno-everything -Wobjc-literal-compare -fobjc-arc '-Dnil=((id)0)' -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/objc-literal-comparison.m
    RUN("%clang_cc1 -fsyntax-only -Wno-everything -Wobjc-literal-compare -fobjc-arc \"-Dnil=((id)0)\" -verify %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -Wno-everything -Wobjc-literal-compare -fobjc-arc '-Dnil=(id)0' -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/objc-literal-comparison.m
    RUN("%clang_cc1 -fsyntax-only -Wno-everything -Wobjc-literal-compare -fobjc-arc \"-Dnil=(id)0\" -verify %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -Wno-everything -Wobjc-literal-compare -fobjc-arc -Dnil=0 -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/objc-literal-comparison.m
    RUN("%clang_cc1 -fsyntax-only -Wno-everything -Wobjc-literal-compare -fobjc-arc \"-Dnil=0\" -verify %s");
  }

  @Test
  public void test_objc_literal_nsnumber_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/objc-literal-nsnumber.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -fblocks -triple x86_64-apple-darwin10 -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/objc-literal-nsnumber.m
    RUN("%clang_cc1  -fsyntax-only -fblocks -triple x86_64-apple-darwin10 -verify %s");
  }

  @Test
  public void test_objc_literal_sig_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/objc-literal-sig.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/objc-literal-sig.m
    RUN("%clang_cc1 -fsyntax-only -verify %s");
  }

  @Test
  public void test_objc_mixed_bridge_attribute_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/objc-mixed-bridge-attribute.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -Wno-objc-root-class ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/objc-mixed-bridge-attribute.m
    RUN("%clang_cc1 -fsyntax-only -verify -Wno-objc-root-class %s");
  }

  @Test
  public void test_objc_qualified_property_lookup_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/objc-qualified-property-lookup.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -Wno-objc-root-class ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/objc-qualified-property-lookup.m
    RUN("%clang_cc1  -fsyntax-only -verify -Wno-objc-root-class %s");
  }

  @Test
  public void test_objc_string_constant_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/objc-string-constant.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -Wsemicolon-before-method-body ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/objc-string-constant.m -verify -fsyntax-only
    RUN("%clang_cc1 -Wsemicolon-before-method-body %s -verify -fsyntax-only");
  }

  @Test
  public void test_objc2_merge_gc_attribue_decl_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/objc2-merge-gc-attribue-decl.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i386-apple-darwin9 -fobjc-gc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/objc2-merge-gc-attribue-decl.m
    RUN("%clang_cc1 -triple i386-apple-darwin9 -fobjc-gc -fsyntax-only -verify %s");
  }

  @Test
  public void test_objc2_warn_weak_decl_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/objc2-warn-weak-decl.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i386-apple-darwin9 -fsyntax-only -fobjc-gc -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/objc2-warn-weak-decl.m
    RUN("%clang_cc1 -triple i386-apple-darwin9 -fsyntax-only -fobjc-gc -verify %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x objective-c++ -triple i386-apple-darwin9 -fsyntax-only -fobjc-gc -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/objc2-warn-weak-decl.m
    RUN("%clang_cc1 -x objective-c++ -triple i386-apple-darwin9 -fsyntax-only -fobjc-gc -verify %s");
  }

  @Test
  public void test_objcbridge_attribute_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/objcbridge-attribute.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -Wno-objc-root-class ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/objcbridge-attribute.m
    RUN("%clang_cc1 -fsyntax-only -verify -Wno-objc-root-class %s");
  }

  @Test
  public void test_objcbridge_attribute_arc_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/objcbridge-attribute-arc.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -x objective-c -fobjc-arc -verify -Wno-objc-root-class ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/objcbridge-attribute-arc.m
    RUN("%clang_cc1 -fsyntax-only -x objective-c -fobjc-arc -verify -Wno-objc-root-class %s");
  }

  @Test
  public void test_objcbridge_related_attribute_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/objcbridge-related-attribute.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -x objective-c -verify -Wno-objc-root-class ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/objcbridge-related-attribute.m
    RUN(TestState.Failed, "%clang_cc1 -fsyntax-only -x objective-c -verify -Wno-objc-root-class %s");
  }

  @Test
  public void test_objcbridgemutable_attribute_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/objcbridgemutable-attribute.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -Wno-objc-root-class ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/objcbridgemutable-attribute.m
    RUN("%clang_cc1 -fsyntax-only -verify -Wno-objc-root-class %s");
  }

  @Test
  public void test_opaque_is_access_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/opaque-is-access.m");
    // ${LLVM_SRC}/build/bin/clang -target x86_64-apple-darwin -arch arm64 -mios-version-min=7 -fsyntax-only ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/opaque-is-access.m -Xclang -verify
    RUN("%clang -target x86_64-apple-darwin -arch arm64 -mios-version-min=7 -fsyntax-only %s -Xclang -verify");
    // ${LLVM_SRC}/build/bin/clang -target x86_64-apple-darwin -arch x86_64 -mios-simulator-version-min=7 -fsyntax-only ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/opaque-is-access.m -Xclang -verify
    RUN("%clang -target x86_64-apple-darwin -arch x86_64 -mios-simulator-version-min=7 -fsyntax-only %s -Xclang -verify");
  }

  @Test
  public void test_opaque_is_access_warn_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/opaque-is-access-warn.m");
    // ${LLVM_SRC}/build/bin/clang -target x86_64-apple-darwin -arch arm64 -mios-version-min=7 -fsyntax-only -Wdeprecated-objc-isa-usage ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/opaque-is-access-warn.m -Xclang -verify
    RUN("%clang -target x86_64-apple-darwin -arch arm64 -mios-version-min=7 -fsyntax-only -Wdeprecated-objc-isa-usage %s -Xclang -verify");
    // ${LLVM_SRC}/build/bin/clang -target x86_64-apple-darwin -arch arm64 -mios-version-min=7 -fsyntax-only ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/opaque-is-access-warn.m -Xclang -verify
    RUN("%clang -target x86_64-apple-darwin -arch arm64 -mios-version-min=7 -fsyntax-only %s -Xclang -verify");
    // ${LLVM_SRC}/build/bin/clang -target x86_64-apple-darwin -mios-simulator-version-min=7 -fsyntax-only -Wdeprecated-objc-isa-usage ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/opaque-is-access-warn.m -Xclang -verify
    RUN("%clang -target x86_64-apple-darwin -mios-simulator-version-min=7 -fsyntax-only -Wdeprecated-objc-isa-usage %s -Xclang -verify");
    // ${LLVM_SRC}/build/bin/clang -target x86_64-apple-darwin -arch armv7k -mwatchos-version-min=2 -fsyntax-only -Wdeprecated-objc-isa-usage ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/opaque-is-access-warn.m -Xclang -verify
    RUN("%clang -target x86_64-apple-darwin -arch armv7k -mwatchos-version-min=2 -fsyntax-only -Wdeprecated-objc-isa-usage %s -Xclang -verify");
    // ${LLVM_SRC}/build/bin/clang -target x86_64-apple-darwin -arch x86_64 -fsyntax-only -Wdeprecated-objc-isa-usage ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/opaque-is-access-warn.m -Xclang -verify
    RUN("%clang -target x86_64-apple-darwin -arch x86_64 -fsyntax-only -Wdeprecated-objc-isa-usage %s -Xclang -verify");
  }

  @Test
  public void test_override_nullability_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/override-nullability.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fobjc-arc -fobjc-runtime-has-weak -Wnonnull ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/override-nullability.m -verify
    RUN("%clang_cc1 -fobjc-arc -fobjc-runtime-has-weak -Wnonnull %s -verify");
  }

  @Test
  public void test_overriding_property_in_class_extension_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/overriding-property-in-class-extension.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -Weverything ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/overriding-property-in-class-extension.m
    RUN("%clang_cc1  -fsyntax-only -verify -Weverything %s");
  }

  @Test
  public void test_ovl_check_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/ovl-check.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-apple-darwin11 -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/ovl-check.m -fobjc-arc
    RUN("%clang_cc1 -triple x86_64-apple-darwin11 -fsyntax-only -verify %s -fobjc-arc");
  }

  @Test
  public void test_parameterized_classes_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/parameterized_classes.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fblocks ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/parameterized_classes.m -verify
    RUN("%clang_cc1 -fblocks %s -verify");
  }

  @Test
  public void test_parameterized_classes_arc_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/parameterized_classes_arc.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fblocks -fobjc-arc -fobjc-runtime-has-weak ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/parameterized_classes_arc.m -verify
    RUN("%clang_cc1 -fblocks -fobjc-arc -fobjc-runtime-has-weak %s -verify");
  }

  @Test
  public void test_parameterized_classes_collection_literal_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/parameterized_classes_collection_literal.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/parameterized_classes_collection_literal.m
    RUN("%clang_cc1  -fsyntax-only -verify %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x objective-c++ -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/parameterized_classes_collection_literal.m
    RUN("%clang_cc1 -x objective-c++  -fsyntax-only -verify %s");
  }

  @Test
  public void test_parameterized_classes_subst_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/parameterized_classes_subst.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fblocks -fsyntax-only -Wnullable-to-nonnull-conversion ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/parameterized_classes_subst.m -verify
    RUN(TestState.Failed, "%clang_cc1 -fblocks -fsyntax-only -Wnullable-to-nonnull-conversion %s -verify");
  }

  @Test
  public void test_pedantic_dynamic_test_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/pedantic-dynamic-test.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -pedantic -Wno-objc-root-class ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/pedantic-dynamic-test.m
    RUN("%clang_cc1 -fsyntax-only -verify -pedantic -Wno-objc-root-class %s");
  }

  @Test
  public void test_pragma_pack_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/pragma-pack.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i686-apple-darwin9 -fsyntax-only -verify -Wno-objc-root-class ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/pragma-pack.m
    RUN("%clang_cc1 -triple i686-apple-darwin9 -fsyntax-only -verify -Wno-objc-root-class %s");
  }

  @Test
  public void test_property_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/property.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i386-apple-darwin9 -fobjc-runtime=macosx-fragile-10.5 -fsyntax-only -verify -Wno-objc-root-class ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/property.m
    RUN("%clang_cc1 -triple i386-apple-darwin9 -fobjc-runtime=macosx-fragile-10.5 -fsyntax-only -verify -Wno-objc-root-class %s");
  }

  @Test
  public void test_property_10_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/property-10.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/property-10.m -fblocks
    RUN("%clang_cc1 -fsyntax-only -verify %s  -fblocks");
  }

  @Test
  public void test_property_11_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/property-11.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/property-11.m
    RUN("%clang_cc1 -fsyntax-only -verify %s");
  }

  @Test
  public void test_property_12_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/property-12.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -Wno-objc-root-class -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/property-12.m
    RUN("%clang_cc1 -fsyntax-only -Wno-objc-root-class -verify %s");
  }

  @Test
  public void test_property_13_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/property-13.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/property-13.m -Wno-unreachable-code
    RUN("%clang_cc1 -fsyntax-only -verify %s -Wno-unreachable-code");
  }

  @Test
  public void test_property_2_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/property-2.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -Wno-objc-root-class ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/property-2.m
    RUN("%clang_cc1 -fsyntax-only -verify -Wno-objc-root-class %s");
  }

  @Test
  public void test_property_3_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/property-3.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/property-3.m
    RUN("%clang_cc1 -verify %s");
  }

  @Test
  public void test_property_4_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/property-4.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/property-4.m
    RUN("%clang_cc1 -verify %s");
  }

  @Test
  public void test_property_5_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/property-5.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/property-5.m
    RUN("%clang_cc1 -verify %s");
  }

  @Test
  public void test_property_6_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/property-6.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -fobjc-exceptions ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/property-6.m
    RUN("%clang_cc1 -fsyntax-only -verify -fobjc-exceptions %s");
  }

  @Test
  public void test_property_7_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/property-7.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/property-7.m
    RUN("%clang_cc1 -fsyntax-only -verify %s");
  }

  @Test
  public void test_property_8_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/property-8.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/property-8.m
    RUN("%clang_cc1 -fsyntax-only -verify %s");
  }

  @Test
  public void test_property_9_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/property-9.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -Wno-objc-root-class ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/property-9.m
    RUN("%clang_cc1 -fsyntax-only -verify -Wno-objc-root-class %s");
  }

  @Test
  public void test_property_9_impl_method_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/property-9-impl-method.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/property-9-impl-method.m -fsyntax-only -verify
    RUN("%clang_cc1 %s -fsyntax-only -verify");
  }

  @Test
  public void test_property_ambiguous_synthesis_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/property-ambiguous-synthesis.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -Wno-objc-root-class ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/property-ambiguous-synthesis.m
    RUN("%clang_cc1  -fsyntax-only -verify -Wno-objc-root-class %s");
  }

  @Test
  public void test_property_and_class_extension_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/property-and-class-extension.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/property-and-class-extension.m
    RUN("%clang_cc1 -fsyntax-only -verify %s");
  }

  @Test
  public void test_property_and_ivar_use_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/property-and-ivar-use.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -Wno-objc-root-class ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/property-and-ivar-use.m
    RUN("%clang_cc1 -fsyntax-only -verify -Wno-objc-root-class %s");
  }

  @Test
  public void test_property_atomic_bool_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/property-atomic-bool.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-apple-macosx10.10 -ast-dump ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/property-atomic-bool.m | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/property-atomic-bool.m
    RUN("%clang_cc1 -triple x86_64-apple-macosx10.10 -ast-dump \"%s\"")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_property_atomic_redecl_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/property-atomic-redecl.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i386-apple-darwin9 -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/property-atomic-redecl.m
    RUN("%clang_cc1 -triple i386-apple-darwin9 -fsyntax-only -verify %s");
  }

  @Test
  public void test_property_category_1_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/property-category-1.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -disable-objc-default-synthesize-properties -Wno-objc-root-class ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/property-category-1.m
    RUN("%clang_cc1 -fsyntax-only -verify -disable-objc-default-synthesize-properties -Wno-objc-root-class %s");
  }

  @Test
  public void test_property_category_2_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/property-category-2.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/property-category-2.m
    RUN("%clang_cc1 -fsyntax-only -verify %s");
  }

  @Test
  public void test_property_category_3_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/property-category-3.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -Wno-objc-root-class ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/property-category-3.m
    RUN("%clang_cc1 -fsyntax-only -verify -Wno-objc-root-class %s");
  }

  @Test
  public void test_property_category_4_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/property-category-4.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -Wno-objc-root-class ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/property-category-4.m
    RUN("%clang_cc1 -fsyntax-only -verify -Wno-objc-root-class %s");
  }

  @Test
  public void test_property_category_impl_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/property-category-impl.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -Wno-objc-root-class ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/property-category-impl.m
    RUN("%clang_cc1 -fsyntax-only -verify -Wno-objc-root-class %s");
  }

  @Test
  public void test_property_choose_expr_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/property-choose-expr.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -Wno-objc-root-class ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/property-choose-expr.m
    RUN("%clang_cc1 -fsyntax-only -verify -Wno-objc-root-class %s");
  }

  @Test
  public void test_property_deprecated_warning_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/property-deprecated-warning.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -triple thumbv6-apple-ios3.0 -verify -Wno-objc-root-class ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/property-deprecated-warning.m
    RUN("%clang_cc1  -fsyntax-only -triple thumbv6-apple-ios3.0 -verify -Wno-objc-root-class %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -D WARN_PARTIAL -Wpartial-availability -fsyntax-only -triple thumbv6-apple-ios3.0 -verify -Wno-objc-root-class ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/property-deprecated-warning.m
    RUN("%clang_cc1 -D WARN_PARTIAL -Wpartial-availability -fsyntax-only -triple thumbv6-apple-ios3.0 -verify -Wno-objc-root-class %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x objective-c++ -fsyntax-only -triple thumbv6-apple-ios3.0 -verify -Wno-objc-root-class ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/property-deprecated-warning.m
    RUN("%clang_cc1 -x objective-c++ -fsyntax-only -triple thumbv6-apple-ios3.0 -verify -Wno-objc-root-class %s");
  }

  @Test
  public void test_property_dot_receiver_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/property-dot-receiver.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -Wno-objc-root-class ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/property-dot-receiver.m
    RUN("%clang_cc1 -fsyntax-only -verify -Wno-objc-root-class %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x objective-c++ -fsyntax-only -verify -Wno-objc-root-class ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/property-dot-receiver.m
    RUN("%clang_cc1 -x objective-c++ -fsyntax-only -verify -Wno-objc-root-class %s");
  }

  @Test
  public void test_property_error_readonly_assign_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/property-error-readonly-assign.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/property-error-readonly-assign.m
    RUN("%clang_cc1 -fsyntax-only -verify %s");
  }

  @Test
  public void test_property_expression_error_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/property-expression-error.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -Wno-objc-root-class ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/property-expression-error.m
    RUN("%clang_cc1  -fsyntax-only -verify -Wno-objc-root-class %s");
  }

  @Test
  public void test_property_impl_misuse_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/property-impl-misuse.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -Wno-objc-root-class ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/property-impl-misuse.m
    RUN("%clang_cc1 -fsyntax-only -verify -Wno-objc-root-class %s");
  }

  @Test
  public void test_property_in_class_extension_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/property-in-class-extension.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -Wno-objc-root-class ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/property-in-class-extension.m
    RUN("%clang_cc1  -fsyntax-only -verify -Wno-objc-root-class %s");
  }

  @Test
  public void test_property_in_class_extension_1_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/property-in-class-extension-1.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -triple x86_64-apple-darwin11 -fobjc-runtime-has-weak -fobjc-weak -verify -Weverything ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/property-in-class-extension-1.m
    RUN("%clang_cc1  -fsyntax-only -triple x86_64-apple-darwin11 -fobjc-runtime-has-weak -fobjc-weak -verify -Weverything %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x objective-c++ -triple x86_64-apple-darwin11 -fobjc-runtime-has-weak -fobjc-weak -fsyntax-only -verify -Weverything ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/property-in-class-extension-1.m
    RUN("%clang_cc1 -x objective-c++ -triple x86_64-apple-darwin11 -fobjc-runtime-has-weak -fobjc-weak -fsyntax-only -verify -Weverything %s");
  }

  @Test
  public void test_property_inherited_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/property-inherited.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/property-inherited.m -fsyntax-only -verify
    RUN("%clang_cc1 %s -fsyntax-only -verify");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x objective-c++ ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/property-inherited.m -fsyntax-only -verify
    RUN("%clang_cc1 -x objective-c++ %s -fsyntax-only -verify");
  }

  @Test
  public void test_property_ivar_mismatch_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/property-ivar-mismatch.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -Wno-objc-root-class ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/property-ivar-mismatch.m
    RUN("%clang_cc1 -fsyntax-only -verify -Wno-objc-root-class %s");
  }

  @Test
  public void test_property_lookup_in_id_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/property-lookup-in-id.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -Wno-objc-root-class ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/property-lookup-in-id.m
    RUN("%clang_cc1  -fsyntax-only -verify -Wno-objc-root-class %s");
  }

  @Test
  public void test_property_method_lookup_impl_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/property-method-lookup-impl.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -Wno-objc-root-class ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/property-method-lookup-impl.m
    RUN("%clang_cc1  -fsyntax-only -verify -Wno-objc-root-class %s");
  }

  @Test
  public void test_property_missing_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/property-missing.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/property-missing.m
    RUN("%clang_cc1 -fsyntax-only -verify %s");
  }

  @Test
  public void test_property_nonfragile_abi_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/property-nonfragile-abi.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/property-nonfragile-abi.m
    RUN("%clang_cc1 -fsyntax-only -verify %s");
  }

  @Test
  public void test_property_noninherited_availability_attr_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/property-noninherited-availability-attr.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-apple-macosx10.8.0 -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/property-noninherited-availability-attr.m
    RUN("%clang_cc1 -triple x86_64-apple-macosx10.8.0 -fsyntax-only -verify %s");
  }

  @Test
  public void test_property_noprotocol_warning_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/property-noprotocol-warning.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/property-noprotocol-warning.m
    RUN("%clang_cc1 -fsyntax-only -verify %s");
  }

  @Test
  public void test_property_not_lvalue_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/property-not-lvalue.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -Wno-objc-root-class ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/property-not-lvalue.m
    RUN("%clang_cc1 -fsyntax-only -verify -Wno-objc-root-class %s");
  }

  @Test
  public void test_property_ns_returns_not_retained_attr_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/property-ns-returns-not-retained-attr.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-apple-darwin11 -fsyntax-only -verify -Wno-objc-root-class ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/property-ns-returns-not-retained-attr.m
    RUN("%clang_cc1 -triple x86_64-apple-darwin11 -fsyntax-only -verify -Wno-objc-root-class %s");
  }

  @Test
  public void test_property_ownership_attr_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/property-ownership-attr.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/property-ownership-attr.m
    RUN("%clang_cc1 -fsyntax-only -verify %s");
  }

  @Test
  public void test_property_redundant_decl_accessor_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/property-redundant-decl-accessor.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -Werror -verify -Wno-objc-root-class ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/property-redundant-decl-accessor.m
    RUN("%clang_cc1 -fsyntax-only -Werror -verify -Wno-objc-root-class %s");
  }

  @Test
  public void test_property_typecheck_1_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/property-typecheck-1.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -Wno-objc-root-class ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/property-typecheck-1.m
    RUN(TestState.Failed, "%clang_cc1 -fsyntax-only -verify -Wno-objc-root-class %s");
  }

  @Test
  public void test_property_user_setter_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/property-user-setter.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -Wno-objc-root-class ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/property-user-setter.m
    RUN("%clang_cc1 -fsyntax-only -verify -Wno-objc-root-class %s");
  }

  @Test
  public void test_property_weak_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/property-weak.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i386-apple-darwin9 -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/property-weak.m
    RUN("%clang_cc1 -triple i386-apple-darwin9 -fsyntax-only -verify %s");
  }

  @Test
  public void test_props_on_prots_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/props-on-prots.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/props-on-prots.m
    RUN("%clang_cc1 -fsyntax-only -verify %s");
  }

  @Test
  public void test_protocol_archane_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/protocol-archane.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -Wno-objc-root-class ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/protocol-archane.m
    RUN("%clang_cc1 -fsyntax-only -verify -Wno-objc-root-class %s");
  }

  @Test
  public void test_protocol_attribute_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/protocol-attribute.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/protocol-attribute.m
    RUN("%clang_cc1 -fsyntax-only -verify %s");
  }

  @Test
  public void test_protocol_expr_1_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/protocol-expr-1.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/protocol-expr-1.m
    RUN("%clang_cc1 -fsyntax-only -verify %s");
  }

  @Test
  public void test_protocol_expr_neg_1_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/protocol-expr-neg-1.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/protocol-expr-neg-1.m
    RUN("%clang_cc1 -fsyntax-only -verify %s");
  }

  @Test
  public void test_protocol_id_test_1_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/protocol-id-test-1.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -verify -Wno-objc-root-class ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/protocol-id-test-1.m
    RUN("%clang_cc1 -verify -Wno-objc-root-class %s");
  }

  @Test
  public void test_protocol_id_test_2_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/protocol-id-test-2.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -verify -Wno-objc-root-class ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/protocol-id-test-2.m
    RUN("%clang_cc1 -verify -Wno-objc-root-class %s");
  }

  @Test
  public void test_protocol_id_test_3_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/protocol-id-test-3.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -pedantic -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/protocol-id-test-3.m
    RUN("%clang_cc1 -pedantic -fsyntax-only -verify %s");
  }

  @Test
  public void test_protocol_implementation_inherited_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/protocol-implementation-inherited.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/protocol-implementation-inherited.m
    RUN("%clang_cc1 -fsyntax-only -verify %s");
  }

  @Test
  public void test_protocol_implementing_class_methods_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/protocol-implementing-class-methods.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/protocol-implementing-class-methods.m
    RUN(TestState.Failed, "%clang_cc1  -fsyntax-only -verify %s");
  }

  @Test
  public void test_protocol_lookup_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/protocol-lookup.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/protocol-lookup.m
    RUN("%clang_cc1 -fsyntax-only -verify %s");
  }

  @Test
  public void test_protocol_lookup_2_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/protocol-lookup-2.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/protocol-lookup-2.m
    RUN("%clang_cc1 -fsyntax-only -verify %s");
  }

  @Test
  public void test_protocol_qualified_class_unsupported_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/protocol-qualified-class-unsupported.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/protocol-qualified-class-unsupported.m
    RUN("%clang_cc1 -fsyntax-only -verify %s");
  }

  @Test
  public void test_protocol_typecheck_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/protocol-typecheck.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/protocol-typecheck.m
    RUN("%clang_cc1 -fsyntax-only -verify %s");
  }

  @Test
  public void test_protocol_warn_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/protocol-warn.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/protocol-warn.m
    RUN("%clang_cc1 -fsyntax-only -verify %s");
  }

  @Test
  public void test_protocols_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/protocols.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -Wno-deprecated-declarations -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/protocols.m
    RUN("%clang_cc1 -fsyntax-only -Wno-deprecated-declarations -verify %s");
  }

  @Test
  public void test_protocols_suppress_conformance_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/protocols-suppress-conformance.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-apple-darwin11 -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/protocols-suppress-conformance.m -Wno-objc-root-class
    RUN("%clang_cc1  -triple x86_64-apple-darwin11 -fsyntax-only -verify %s -Wno-objc-root-class");
  }

  @Test
  public void test_provisional_ivar_lookup_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/provisional-ivar-lookup.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -Wno-objc-root-class ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/provisional-ivar-lookup.m
    RUN("%clang_cc1  -fsyntax-only -verify -Wno-objc-root-class %s");
  }

  @Test
  public void test_qualified_protocol_method_conflicts_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/qualified-protocol-method-conflicts.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -Woverriding-method-mismatch -fsyntax-only -verify -Wno-objc-root-class ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/qualified-protocol-method-conflicts.m
    RUN("%clang_cc1  -Woverriding-method-mismatch -fsyntax-only -verify -Wno-objc-root-class %s");
  }

  @Test
  public void test_rdar6248119_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/rdar6248119.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/rdar6248119.m -verify -fobjc-exceptions
    RUN("%clang_cc1 -fsyntax-only %s -verify -fobjc-exceptions");
  }

  @Test
  public void test_rdr_6211479_array_property_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/rdr-6211479-array-property.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/rdr-6211479-array-property.m
    RUN("%clang_cc1 -fsyntax-only -verify %s");
  }

  @Test
  public void test_receiver_forward_class_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/receiver-forward-class.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -Wreceiver-forward-class -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/receiver-forward-class.m
    RUN("%clang_cc1 -fsyntax-only -Wreceiver-forward-class -verify %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x objective-c++ -fsyntax-only -Wreceiver-forward-class -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/receiver-forward-class.m
    RUN("%clang_cc1 -x objective-c++ -fsyntax-only  -Wreceiver-forward-class -verify %s");
  }

  @Test
  public void test_related_result_type_inference_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/related-result-type-inference.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -verify -Wno-deprecated-declarations -Wno-objc-root-class ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/related-result-type-inference.m
    RUN("%clang_cc1 -verify -Wno-deprecated-declarations -Wno-objc-root-class %s");
  }

  @Test
  public void test_resolve_method_in_global_pool_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/resolve-method-in-global-pool.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-apple-darwin10 -fsyntax-only -verify -fblocks -Wno-objc-root-class ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/resolve-method-in-global-pool.m
    RUN("%clang_cc1 -triple x86_64-apple-darwin10 -fsyntax-only -verify -fblocks -Wno-objc-root-class %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x objective-c++ -triple x86_64-apple-darwin10 -fsyntax-only -verify -fblocks -Wno-objc-root-class ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/resolve-method-in-global-pool.m
    RUN("%clang_cc1 -x objective-c++ -triple x86_64-apple-darwin10 -fsyntax-only -verify -fblocks -Wno-objc-root-class %s");
  }

  @Test
  public void test_restrict_id_type_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/restrict-id-type.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=gnu99 -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/restrict-id-type.m
    RUN("%clang_cc1  -std=gnu99 -fsyntax-only -verify %s");
  }

  @Test
  public void test_return_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/return.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -Wmissing-noreturn -fobjc-exceptions -Wno-objc-root-class ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/return.m
    RUN("%clang_cc1 -fsyntax-only -verify -Wmissing-noreturn -fobjc-exceptions -Wno-objc-root-class %s");
  }

  @Test
  public void test_scope_check_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/scope-check.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -fobjc-exceptions -Wno-objc-root-class ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/scope-check.m
    RUN("%clang_cc1 -fsyntax-only -verify -fobjc-exceptions -Wno-objc-root-class %s");
  }

  @Test
  public void test_selector_1_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/selector-1.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -Wselector-type-mismatch -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/selector-1.m
    RUN("%clang_cc1  -Wselector-type-mismatch -verify %s");
  }

  @Test
  public void test_selector_2_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/selector-2.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -Wselector -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/selector-2.m
    RUN("%clang_cc1  -fsyntax-only -Wselector -verify %s");
  }

  @Test
  public void test_selector_3_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/selector-3.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -Wselector -verify -Wno-objc-root-class ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/selector-3.m
    RUN("%clang_cc1  -fsyntax-only -Wselector -verify -Wno-objc-root-class %s");
  }

  @Test
  public void test_selector_4_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/selector-4.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -Wselector -x objective-c ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/selector-4.m -include ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/selector-4.m -verify
    RUN("%clang_cc1 -Wselector -x objective-c %s -include %s -verify");
  }

  @Test
  public void test_selector_error_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/selector-error.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -Wno-objc-root-class ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/selector-error.m
    RUN("%clang_cc1  -fsyntax-only -verify -Wno-objc-root-class %s");
  }

  @Test
  public void test_selector_overload_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/selector-overload.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/selector-overload.m -fsyntax-only
    RUN("%clang_cc1 %s -fsyntax-only");
  }

  @Test
  public void test_self_assign_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/self-assign.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -Wno-objc-root-class ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/self-assign.m
    RUN("%clang_cc1 -fsyntax-only -verify -Wno-objc-root-class %s");
  }

  @Test
  public void test_self_comparison_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/self-comparison.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -Wno-objc-root-class ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/self-comparison.m
    RUN("%clang_cc1 -fsyntax-only -verify -Wno-objc-root-class %s");
  }

  @Test
  public void test_self_declared_in_block_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/self-declared-in-block.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -triple x86_64-apple-darwin10 -fblocks -verify -Wno-objc-root-class ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/self-declared-in-block.m
    RUN("%clang_cc1 -fsyntax-only -triple x86_64-apple-darwin10  -fblocks -verify -Wno-objc-root-class %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x objective-c++ -fsyntax-only -triple x86_64-apple-darwin10 -fblocks -verify -Wno-objc-root-class ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/self-declared-in-block.m
    RUN("%clang_cc1 -x objective-c++ -fsyntax-only -triple x86_64-apple-darwin10  -fblocks -verify -Wno-objc-root-class %s");
  }

  @Test
  public void test_self_in_function_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/self-in-function.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -fblocks -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/self-in-function.m
    RUN("%clang_cc1  -fsyntax-only -fblocks -verify %s");
  }

  @Test
  public void test_setter_dotsyntax_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/setter-dotsyntax.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/setter-dotsyntax.m
    RUN("%clang_cc1 -fsyntax-only -verify %s");
  }

  @Test
  public void test_severe_syntax_error_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/severe-syntax-error.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -Wno-objc-root-class ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/severe-syntax-error.m
    RUN("%clang_cc1 -fsyntax-only -verify -Wno-objc-root-class %s");
  }

  @Test
  public void test_sign_conversion_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/sign-conversion.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -Wsign-conversion ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/sign-conversion.m
    RUN("%clang_cc1 -fsyntax-only -verify -Wsign-conversion %s");
  }

  @Test
  public void test_sizeof_interface_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/sizeof-interface.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -verify -fsyntax-only -Wno-objc-root-class ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/sizeof-interface.m
    RUN("%clang_cc1 -verify -fsyntax-only -Wno-objc-root-class %s");
  }

  @Test
  public void test_special_dep_unavail_warning_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/special-dep-unavail-warning.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/special-dep-unavail-warning.m
    RUN("%clang_cc1  -fsyntax-only -verify %s");
  }

  @Test
  public void test_stand_alone_implementation_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/stand-alone-implementation.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -Wno-objc-root-class ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/stand-alone-implementation.m
    RUN("%clang_cc1 -fsyntax-only -verify -Wno-objc-root-class %s");
  }

  @Test
  public void test_static_ivar_ref_1_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/static-ivar-ref-1.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i386-unknown-unknown -ast-print ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/static-ivar-ref-1.m 2>&1 | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/static-ivar-ref-1.m
    RUN("%clang_cc1 -triple i386-unknown-unknown -ast-print %s 2>&1")./*|*/
      I("FileCheck  %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-apple-darwin10 -ast-print ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/static-ivar-ref-1.m 2>&1 | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/static-ivar-ref-1.m
    RUN("%clang_cc1 -triple x86_64-apple-darwin10  -ast-print %s  2>&1")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_stmts_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/stmts.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/stmts.m -verify -fsyntax-only -fobjc-exceptions
    RUN("%clang_cc1 %s -verify -fsyntax-only -fobjc-exceptions");
  }

  @Test
  public void test_string_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/string.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/string.m -verify -fsyntax-only
    RUN("%clang_cc1 %s -verify -fsyntax-only");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/string.m -verify -fsyntax-only -DDECLAREIT
    RUN("%clang_cc1 %s -verify -fsyntax-only -DDECLAREIT");
  }

  @Test
  public void test_super_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/super.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -fblocks ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/super.m
    RUN("%clang_cc1 -fsyntax-only -verify -fblocks %s");
  }

  @Test
  public void test_super_cat_prot_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/super-cat-prot.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/super-cat-prot.m
    RUN("%clang_cc1 -fsyntax-only -verify %s");
  }

  @Test
  public void test_super_class_protocol_conformance_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/super-class-protocol-conformance.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -disable-objc-default-synthesize-properties ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/super-class-protocol-conformance.m
    RUN("%clang_cc1 -fsyntax-only -verify -disable-objc-default-synthesize-properties %s");
  }

  @Test
  public void test_super_dealloc_attribute_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/super-dealloc-attribute.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -Wno-objc-root-class ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/super-dealloc-attribute.m
    RUN("%clang_cc1  -fsyntax-only -verify -Wno-objc-root-class %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x objective-c++ -fsyntax-only -verify -Wno-objc-root-class ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/super-dealloc-attribute.m
    RUN("%clang_cc1 -x objective-c++ -fsyntax-only -verify -Wno-objc-root-class %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -fobjc-arc -verify -Wno-objc-root-class ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/super-dealloc-attribute.m
    RUN("%clang_cc1  -fsyntax-only -fobjc-arc -verify -Wno-objc-root-class %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x objective-c++ -fobjc-arc -fsyntax-only -verify -Wno-objc-root-class ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/super-dealloc-attribute.m
    RUN("%clang_cc1 -x objective-c++ -fobjc-arc -fsyntax-only -verify -Wno-objc-root-class %s");
  }

  @Test
  public void test_super_property_message_expr_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/super-property-message-expr.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/super-property-message-expr.m
    RUN("%clang_cc1  -fsyntax-only -verify %s");
  }

  @Test
  public void test_super_property_notation_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/super-property-notation.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/super-property-notation.m
    RUN(TestState.Failed, "%clang_cc1 -fsyntax-only -verify %s");
  }

  @Test
  public void test_synchronized_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/synchronized.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -Wno-objc-root-class ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/synchronized.m
    RUN("%clang_cc1 -fsyntax-only -verify -Wno-objc-root-class %s");
  }

  @Test
  public void test_synth_provisional_ivars_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/synth-provisional-ivars.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -Wno-objc-root-class ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/synth-provisional-ivars.m
    RUN("%clang_cc1 -fsyntax-only -verify -Wno-objc-root-class %s");
  }

  @Test
  public void test_synth_provisional_ivars_1_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/synth-provisional-ivars-1.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -Wno-objc-root-class ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/synth-provisional-ivars-1.m
    RUN("%clang_cc1 -fsyntax-only -verify -Wno-objc-root-class %s");
  }

  @Test
  public void test_synthesize_setter_contclass_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/synthesize-setter-contclass.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -Wno-objc-root-class ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/synthesize-setter-contclass.m
    RUN("%clang_cc1  -fsyntax-only -verify -Wno-objc-root-class %s");
  }

  @Test
  public void test_synthesized_ivar_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/synthesized-ivar.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -Wno-objc-root-class ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/synthesized-ivar.m
    RUN("%clang_cc1 -fsyntax-only -verify -Wno-objc-root-class %s");
  }

  @Test
  public void test_tentative_property_decl_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/tentative-property-decl.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -Weverything -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/tentative-property-decl.m
    RUN("%clang_cc1 -fsyntax-only -Weverything -verify %s");
  }

  @Test
  public void test_transparent_union_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/transparent-union.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -Wno-objc-root-class ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/transparent-union.m
    RUN("%clang_cc1  -fsyntax-only -verify -Wno-objc-root-class %s");
  }

  @Test
  public void test_try_catch_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/try-catch.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -fobjc-exceptions ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/try-catch.m
    RUN("%clang_cc1 -fsyntax-only -verify -fobjc-exceptions %s");
  }

  @Test
  public void test_typedef_class_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/typedef-class.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/typedef-class.m
    RUN("%clang_cc1 -fsyntax-only -verify %s");
  }

  @Test
  public void test_typo_correction_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/typo-correction.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/typo-correction.m -verify -fsyntax-only
    RUN("%clang_cc1 %s -verify -fsyntax-only");
  }

  @Test
  public void test_typo_correction_arc_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/typo-correction-arc.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i386-apple-macosx10.10 -fobjc-arc -fsyntax-only -Wno-objc-root-class ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/typo-correction-arc.m -verify
    RUN("%clang_cc1 -triple i386-apple-macosx10.10 -fobjc-arc -fsyntax-only -Wno-objc-root-class %s -verify");
  }

  @Test
  public void test_ucn_objc_string_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/ucn-objc-string.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/ucn-objc-string.m -verify -fsyntax-only
    RUN("%clang_cc1 %s -verify -fsyntax-only");
  }

  @Test
  public void test_undeclared_selector_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/undeclared-selector.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -Wundeclared-selector -verify -Wno-objc-root-class ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/undeclared-selector.m
    RUN("%clang_cc1  -fsyntax-only -Wundeclared-selector -verify -Wno-objc-root-class %s");
  }

  @Test
  public void test_undef_arg_super_method_call_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/undef-arg-super-method-call.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/undef-arg-super-method-call.m
    RUN( "%clang_cc1 -fsyntax-only -verify %s");
  }

  @Test
  public void test_undef_class_messagin_error_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/undef-class-messagin-error.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/undef-class-messagin-error.m
    RUN("%clang_cc1 -fsyntax-only -verify %s");
  }

  @Test
  public void test_undef_protocol_methods_1_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/undef-protocol-methods-1.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -Wno-objc-root-class ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/undef-protocol-methods-1.m
    RUN("%clang_cc1 -fsyntax-only -verify -Wno-objc-root-class %s");
  }

  @Test
  public void test_undef_superclass_1_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/undef-superclass-1.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -Wno-objc-root-class ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/undef-superclass-1.m
    RUN("%clang_cc1 -fsyntax-only -verify -Wno-objc-root-class %s");
  }

  @Test
  public void test_undefined_protocol_type_1_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/undefined-protocol-type-1.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/undefined-protocol-type-1.m
    RUN("%clang_cc1 -fsyntax-only -verify %s");
  }

  @Test
  public void test_unimplemented_protocol_prop_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/unimplemented-protocol-prop.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -Wno-objc-root-class -disable-objc-default-synthesize-properties ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/unimplemented-protocol-prop.m
    RUN("%clang_cc1  -fsyntax-only -verify -Wno-objc-root-class -disable-objc-default-synthesize-properties %s");
  }

  @Test
  public void test_uninit_variables_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/uninit-variables.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -Wuninitialized -fsyntax-only -fblocks ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/uninit-variables.m -verify
    RUN(TestState.Failed, "%clang_cc1 -fsyntax-only -Wuninitialized -fsyntax-only -fblocks %s -verify");
  }

  @Test
  public void test_unknown_anytype_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/unknown-anytype.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -funknown-anytype -fsyntax-only -fdebugger-support -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/unknown-anytype.m
    RUN("%clang_cc1 -funknown-anytype -fsyntax-only -fdebugger-support -verify %s");
  }

  @Test
  public void test_unqualified_to_qualified_class_warn_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/unqualified-to-qualified-class-warn.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/unqualified-to-qualified-class-warn.m
    RUN("%clang_cc1  -fsyntax-only -verify %s");
  }

  @Test
  public void test_unused_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/unused.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -verify -Wused-but-marked-unused -Wno-objc-protocol-method-implementation -Wunused -Wunused-parameter -fsyntax-only -Wno-objc-root-class ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/unused.m
    RUN("%clang_cc1 -verify -Wused-but-marked-unused -Wno-objc-protocol-method-implementation -Wunused -Wunused-parameter -fsyntax-only -Wno-objc-root-class %s");
  }

  @Test
  public void test_unused_backing_ivar_warning_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/unused-backing-ivar-warning.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -Wunused-property-ivar -verify -Wno-objc-root-class ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/unused-backing-ivar-warning.m
    RUN("%clang_cc1  -fsyntax-only -Wunused-property-ivar -verify -Wno-objc-root-class %s");
  }

  @Test
  public void test_va_method_1_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/va-method-1.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/va-method-1.m
    RUN("%clang_cc1 -fsyntax-only -verify %s");
  }

  @Test
  public void test_warn_assign_property_nscopying_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/warn-assign-property-nscopying.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fobjc-gc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/warn-assign-property-nscopying.m
    RUN("%clang_cc1  -fobjc-gc -fsyntax-only -verify %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x objective-c++ -fobjc-gc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/warn-assign-property-nscopying.m
    RUN("%clang_cc1  -x objective-c++ -fobjc-gc -fsyntax-only -verify %s");
  }

  @Test
  public void test_warn_cast_of_sel_expr_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/warn-cast-of-sel-expr.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -Wno-unused-value ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/warn-cast-of-sel-expr.m
    RUN("%clang_cc1  -fsyntax-only -verify -Wno-unused-value %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x objective-c++ -fsyntax-only -verify -Wcast-of-sel-type -Wno-unused-value ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/warn-cast-of-sel-expr.m
    RUN("%clang_cc1 -x objective-c++ -fsyntax-only -verify -Wcast-of-sel-type -Wno-unused-value %s");
  }

  @Test
  public void test_warn_category_method_deprecated_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/warn-category-method-deprecated.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -Wno-objc-root-class -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/warn-category-method-deprecated.m
    RUN("%clang_cc1 -fsyntax-only -Wno-objc-root-class -verify %s");
  }

  @Test
  public void test_warn_deprecated_implementations_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/warn-deprecated-implementations.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -Wdeprecated-implementations -verify -Wno-objc-root-class ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/warn-deprecated-implementations.m
    RUN("%clang_cc1 -fsyntax-only -Wdeprecated-implementations -verify -Wno-objc-root-class %s");
  }

  @Test
  public void test_warn_direct_ivar_access_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/warn-direct-ivar-access.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -fobjc-arc -fobjc-runtime-has-weak -Wdirect-ivar-access -verify -Wno-objc-root-class ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/warn-direct-ivar-access.m
    RUN("%clang_cc1  -fsyntax-only -fobjc-arc -fobjc-runtime-has-weak  -Wdirect-ivar-access -verify -Wno-objc-root-class %s");
  }

  @Test
  public void test_warn_explicit_call_initialize_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/warn-explicit-call-initialize.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -triple x86_64-apple-darwin10 -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/warn-explicit-call-initialize.m
    RUN("%clang_cc1  -fsyntax-only  -triple x86_64-apple-darwin10 -verify %s");
  }

  @Test
  public void test_warn_forward_class_attr_deprecated_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/warn-forward-class-attr-deprecated.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -Wno-objc-root-class ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/warn-forward-class-attr-deprecated.m
    RUN("%clang_cc1 -fsyntax-only -verify -Wno-objc-root-class %s");
  }

  @Test
  public void test_warn_implicit_atomic_property_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/warn-implicit-atomic-property.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -Wimplicit-atomic-properties -verify -Wno-objc-root-class ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/warn-implicit-atomic-property.m
    RUN("%clang_cc1 -fsyntax-only -Wimplicit-atomic-properties -verify -Wno-objc-root-class %s");
  }

  @Test
  public void test_warn_implicit_self_in_block_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/warn-implicit-self-in-block.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x objective-c -fobjc-arc -fblocks -Wimplicit-retain-self -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/warn-implicit-self-in-block.m
    RUN("%clang_cc1 -x objective-c -fobjc-arc -fblocks -Wimplicit-retain-self -verify %s");
  }

  @Test
  public void test_warn_incompatible_builtin_types_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/warn-incompatible-builtin-types.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/warn-incompatible-builtin-types.m
    RUN("%clang_cc1 -fsyntax-only -verify %s");
  }

  @Test
  public void test_warn_loop_analysis_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/warn-loop-analysis.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -Wloop-analysis -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/warn-loop-analysis.m
    RUN("%clang_cc1 -fsyntax-only -Wloop-analysis -verify %s");
  }

  @Test
  public void test_warn_missing_super_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/warn-missing-super.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/warn-missing-super.m 2>&1 | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/warn-missing-super.m
    RUN("%clang_cc1 -fsyntax-only %s 2>&1")./*|*/
      I("FileCheck %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -fobjc-gc ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/warn-missing-super.m 2>&1 | ${LLVM_SRC}/build/bin/FileCheck --check-prefix=CHECK-GC ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/warn-missing-super.m
    RUN("%clang_cc1 -fsyntax-only -fobjc-gc %s 2>&1")./*|*/
      I("FileCheck --check-prefix=CHECK-GC %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -fobjc-gc-only ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/warn-missing-super.m 2>&1 | ${LLVM_SRC}/build/bin/FileCheck --check-prefix=CHECK-GC-ONLY ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/warn-missing-super.m
    RUN("%clang_cc1 -fsyntax-only -fobjc-gc-only %s 2>&1")./*|*/
      I("FileCheck --check-prefix=CHECK-GC-ONLY %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -triple x86_64-apple-darwin10 -fobjc-arc ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/warn-missing-super.m 2>&1 | ${LLVM_SRC}/build/bin/FileCheck --check-prefix=CHECK-ARC ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/warn-missing-super.m
    RUN("not %clang_cc1 -fsyntax-only -triple x86_64-apple-darwin10 -fobjc-arc %s 2>&1")./*|*/
      I("FileCheck --check-prefix=CHECK-ARC %s");
  }

  @Test
  public void test_warn_protocol_method_deprecated_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/warn-protocol-method-deprecated.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -Wno-objc-root-class -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/warn-protocol-method-deprecated.m
    RUN("%clang_cc1 -fsyntax-only -Wno-objc-root-class -verify %s");
  }

  @Test
  public void test_warn_retain_block_property_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/warn-retain-block-property.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -fblocks -fobjc-arc -Wno-objc-root-class ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/warn-retain-block-property.m 2>&1 | ${LLVM_SRC}/build/bin/FileCheck --check-prefix=CHECK-ARC ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/warn-retain-block-property.m
    RUN("not %clang_cc1 -fsyntax-only -fblocks -fobjc-arc -Wno-objc-root-class %s 2>&1")./*|*/
      I("FileCheck --check-prefix=CHECK-ARC %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -fblocks -Wno-objc-root-class ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/warn-retain-block-property.m 2>&1 | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/warn-retain-block-property.m
    RUN("not %clang_cc1 -fsyntax-only -fblocks -Wno-objc-root-class %s 2>&1")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_warn_retain_cycle_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/warn-retain-cycle.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -fobjc-runtime-has-weak -fobjc-arc -fblocks -verify -Wno-objc-root-class -Wno-implicit-retain-self ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/warn-retain-cycle.m
    RUN("%clang_cc1 -fsyntax-only -fobjc-runtime-has-weak -fobjc-arc -fblocks -verify -Wno-objc-root-class -Wno-implicit-retain-self %s");
  }

  @Test
  public void test_warn_selector_selection_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/warn-selector-selection.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/warn-selector-selection.m
    RUN("%clang_cc1 -fsyntax-only -verify %s");
  }

  @Test
  public void test_warn_strict_selector_match_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/warn-strict-selector-match.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -Wstrict-selector-match -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/warn-strict-selector-match.m
    RUN("%clang_cc1  -Wstrict-selector-match -fsyntax-only -verify %s");
  }

  @Test
  public void test_warn_superclass_method_mismatch_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/warn-superclass-method-mismatch.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -Wsuper-class-method-mismatch -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/warn-superclass-method-mismatch.m
    RUN("%clang_cc1  -fsyntax-only -Wsuper-class-method-mismatch -verify %s");
  }

  @Test
  public void test_warn_thread_safety_analysis_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/warn-thread-safety-analysis.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -Wthread-safety -Wthread-safety-beta -Wno-objc-root-class ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/warn-thread-safety-analysis.m
    RUN("%clang_cc1 -fsyntax-only -verify -Wthread-safety -Wthread-safety-beta -Wno-objc-root-class %s");
  }

  @Test
  public void test_warn_unreachable_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/warn-unreachable.m");
    // ${LLVM_SRC}/build/bin/clang ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/warn-unreachable.m -fsyntax-only -Xclang -verify -fblocks -Wunreachable-code-aggressive -Wno-unused-value -Wno-covered-switch-default
    RUN("%clang %s -fsyntax-only -Xclang -verify -fblocks -Wunreachable-code-aggressive -Wno-unused-value -Wno-covered-switch-default");
  }

  @Test
  public void test_warn_unused_exception_param_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/warn-unused-exception-param.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -fobjc-exceptions -Wunused-exception-parameter ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/warn-unused-exception-param.m
    RUN("%clang_cc1 -fsyntax-only -verify -fobjc-exceptions -Wunused-exception-parameter %s");
  }

  @Test
  public void test_warn_weak_field_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/warn-weak-field.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i386-apple-darwin9 -fsyntax-only -fobjc-gc -verify -Wno-objc-root-class ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/warn-weak-field.m
    RUN("%clang_cc1 -triple i386-apple-darwin9 -fsyntax-only -fobjc-gc -verify -Wno-objc-root-class %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x objective-c++ -triple i386-apple-darwin9 -fsyntax-only -fobjc-gc -verify -Wno-objc-root-class ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/warn-weak-field.m
    RUN("%clang_cc1 -x objective-c++ -triple i386-apple-darwin9 -fsyntax-only -fobjc-gc -verify -Wno-objc-root-class %s");
  }

  @Test
  public void test_warn_write_strings_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/warn-write-strings.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -verify -fsyntax-only -fconst-strings ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/warn-write-strings.m
    RUN("%clang_cc1 -verify -fsyntax-only -fconst-strings %s");
  }

  @Test
  public void test_warning_missing_selector_name_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/warning-missing-selector-name.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -Wno-objc-root-class ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/warning-missing-selector-name.m
    RUN("%clang_cc1  -fsyntax-only -verify -Wno-objc-root-class %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x objective-c++ -fsyntax-only -verify -Wno-objc-root-class -Wmissing-selector-name ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/warning-missing-selector-name.m
    RUN("%clang_cc1 -x objective-c++ -fsyntax-only -verify -Wno-objc-root-class -Wmissing-selector-name %s");
  }

  @Test
  public void test_weak_attr_ivar_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/weak-attr-ivar.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/weak-attr-ivar.m
    RUN("%clang_cc1 -fsyntax-only -verify %s");
  }

  @Test
  public void test_weak_property_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/weak-property.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -fobjc-runtime-has-weak -fobjc-arc -verify -Wno-objc-root-class ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/weak-property.m
    RUN("%clang_cc1  -fsyntax-only -fobjc-runtime-has-weak -fobjc-arc -verify -Wno-objc-root-class %s");
  }

  @Test
  public void test_writable_property_in_superclass_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/writable-property-in-superclass.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaObjC/writable-property-in-superclass.m
    RUN("%clang_cc1  -fsyntax-only -verify %s");
  }
  
}
