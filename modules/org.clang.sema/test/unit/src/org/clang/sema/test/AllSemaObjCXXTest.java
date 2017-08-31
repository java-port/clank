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
 * Collection of all test files from test/SemaObjCXX folder
 * @author Vladimir Voskresensky
 */
public class AllSemaObjCXXTest extends DriverTestFileBase {
  private static final String TEST_LOCATION = "${LLVM_SRC}/llvm/tools/clang/test/SemaObjCXX/";
  public AllSemaObjCXXTest() {
    super(TEST_LOCATION, TestState.Successful);
  }
  
  public static void main(String[] args) {
    // Print tests which will be accepted per test case
    DriverTestFileBase.printAllTestFiles(false, TEST_LOCATION, (test)->true, 
            "${SPUTNIK}/modules/org.clang.sema/test/unit/src/org/clang/sema/test/AllSemaObjCXXTest.txt");
  }  
  
  @Override
  protected boolean keepStacksForUnimplementedMethods() {
    return false;
  }
  
  @Test
  public void test_NSString_type_mm() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjCXX/NSString-type.mm");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x objective-c++ -triple x86_64-apple-darwin10 -fblocks -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaObjCXX/NSString-type.mm
    RUN("%clang_cc1 -x objective-c++ -triple x86_64-apple-darwin10 -fblocks -fsyntax-only -verify %s");
  }

  @Test
  public void test_abstract_class_type_ivar_mm() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjCXX/abstract-class-type-ivar.mm");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -Wno-objc-root-class ${LLVM_SRC}/llvm/tools/clang/test/SemaObjCXX/abstract-class-type-ivar.mm
    RUN("%clang_cc1 -fsyntax-only -verify -Wno-objc-root-class %s");
  }

  @Test
  public void test_arc_0x_mm() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjCXX/arc-0x.mm");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c++11 -fsyntax-only -fobjc-arc -verify -fblocks -fobjc-exceptions ${LLVM_SRC}/llvm/tools/clang/test/SemaObjCXX/arc-0x.mm
    RUN("%clang_cc1 -std=c++11 -fsyntax-only -fobjc-arc -verify -fblocks -fobjc-exceptions %s");
  }

  @Test
  public void test_arc_bool_conversion_mm() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjCXX/arc-bool-conversion.mm");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -fobjc-arc -verify -fblocks -triple x86_64-apple-darwin10.0.0 ${LLVM_SRC}/llvm/tools/clang/test/SemaObjCXX/arc-bool-conversion.mm
    RUN("%clang_cc1 -fsyntax-only -fobjc-arc -verify -fblocks -triple x86_64-apple-darwin10.0.0 %s");
  }

  @Test
  public void test_arc_bridged_cast_mm() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjCXX/arc-bridged-cast.mm");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-apple-darwin11 -fsyntax-only -fobjc-arc -fblocks -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaObjCXX/arc-bridged-cast.mm
    RUN("%clang_cc1 -triple x86_64-apple-darwin11 -fsyntax-only -fobjc-arc -fblocks -verify %s");
  }

  @Test
  public void test_arc_libstdcxx_mm() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjCXX/arc-libstdcxx.mm");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -fobjc-arc -fobjc-arc-cxxlib=libstdc++ -fobjc-runtime-has-weak -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaObjCXX/arc-libstdcxx.mm
    RUN("%clang_cc1 -fsyntax-only -fobjc-arc -fobjc-arc-cxxlib=libstdc++ -fobjc-runtime-has-weak -verify %s");
  }

  @Test
  public void test_arc_memfunc_mm() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjCXX/arc-memfunc.mm");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -fobjc-arc -verify -fblocks ${LLVM_SRC}/llvm/tools/clang/test/SemaObjCXX/arc-memfunc.mm
    RUN("%clang_cc1 -fsyntax-only -fobjc-arc -verify -fblocks %s");
  }

  @Test
  public void test_arc_nsconsumed_errors_mm() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjCXX/arc-nsconsumed-errors.mm");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -fobjc-arc -verify -fblocks -triple x86_64-apple-darwin10.0.0 ${LLVM_SRC}/llvm/tools/clang/test/SemaObjCXX/arc-nsconsumed-errors.mm
    RUN("%clang_cc1 -fsyntax-only -fobjc-arc -verify -fblocks -triple x86_64-apple-darwin10.0.0 %s");
  }

  @Test
  public void test_arc_objc_lifetime_mm() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjCXX/arc-objc-lifetime.mm");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x objective-c++ -triple x86_64-apple-darwin11 -fsyntax-only -fobjc-arc -fblocks -Wexplicit-ownership-type -verify -Wno-objc-root-class ${LLVM_SRC}/llvm/tools/clang/test/SemaObjCXX/arc-objc-lifetime.mm
    RUN("%clang_cc1 -x objective-c++ -triple x86_64-apple-darwin11 -fsyntax-only -fobjc-arc -fblocks -Wexplicit-ownership-type -verify -Wno-objc-root-class %s");
  }

  @Test
  public void test_arc_overloading_mm() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjCXX/arc-overloading.mm");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fobjc-runtime-has-weak -fsyntax-only -fobjc-arc -verify -fblocks -Wno-objc-root-class ${LLVM_SRC}/llvm/tools/clang/test/SemaObjCXX/arc-overloading.mm
    RUN("%clang_cc1 -fobjc-runtime-has-weak -fsyntax-only -fobjc-arc -verify -fblocks -Wno-objc-root-class %s");
  }

  @Test
  public void test_arc_ppe_mm() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjCXX/arc-ppe.mm");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -fobjc-arc ${LLVM_SRC}/llvm/tools/clang/test/SemaObjCXX/arc-ppe.mm
    RUN("%clang_cc1 -fsyntax-only -verify -fobjc-arc %s");
  }

  @Test
  public void test_arc_system_header_mm() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjCXX/arc-system-header.mm");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fobjc-arc -isystem ${LLVM_SRC}/llvm/tools/clang/test/SemaObjCXX/Inputs ${LLVM_SRC}/llvm/tools/clang/test/SemaObjCXX/arc-system-header.mm -verify
    RUN("%clang_cc1 -fobjc-arc -isystem %S/Inputs %s -verify");
  }

  @Test
  public void test_arc_templates_mm() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjCXX/arc-templates.mm");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fobjc-runtime-has-weak -fsyntax-only -fobjc-arc -verify -fblocks -std=c++11 ${LLVM_SRC}/llvm/tools/clang/test/SemaObjCXX/arc-templates.mm
    RUN("%clang_cc1 -fobjc-runtime-has-weak -fsyntax-only -fobjc-arc -verify -fblocks -std=c++11 %s");
  }

  @Test
  public void test_arc_type_conversion_mm() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjCXX/arc-type-conversion.mm");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fobjc-runtime-has-weak -fsyntax-only -fobjc-arc -verify -fblocks ${LLVM_SRC}/llvm/tools/clang/test/SemaObjCXX/arc-type-conversion.mm
    RUN("%clang_cc1 -fobjc-runtime-has-weak -fsyntax-only -fobjc-arc -verify -fblocks %s");
  }

  @Test
  public void test_arc_type_traits_mm() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjCXX/arc-type-traits.mm");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -fobjc-arc -fobjc-runtime-has-weak -verify -std=c++11 ${LLVM_SRC}/llvm/tools/clang/test/SemaObjCXX/arc-type-traits.mm
    RUN("%clang_cc1 -fsyntax-only -fobjc-arc -fobjc-runtime-has-weak -verify -std=c++11 %s");
  }

  @Test
  public void test_arc_unavailable_for_weakref_mm() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjCXX/arc-unavailable-for-weakref.mm");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x objective-c++ -triple x86_64-apple-darwin11 -fobjc-runtime-has-weak -fsyntax-only -fobjc-arc -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaObjCXX/arc-unavailable-for-weakref.mm
    RUN("%clang_cc1 -x objective-c++ -triple x86_64-apple-darwin11 -fobjc-runtime-has-weak -fsyntax-only -fobjc-arc -verify %s");
  }

  @Test
  public void test_arc_unbridged_cast_mm() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjCXX/arc-unbridged-cast.mm");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-apple-darwin11 -fsyntax-only -fobjc-arc -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaObjCXX/arc-unbridged-cast.mm
    RUN("%clang_cc1 -triple x86_64-apple-darwin11 -fsyntax-only -fobjc-arc -verify %s");
  }

  @Test
  public void test_argument_dependent_lookup_mm() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjCXX/argument-dependent-lookup.mm");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaObjCXX/argument-dependent-lookup.mm
    RUN("%clang_cc1 -fsyntax-only -verify %s");
  }

  @Test
  public void test_base_type_as_written_mm() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjCXX/base-type-as-written.mm");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaObjCXX/base-type-as-written.mm
    RUN("%clang_cc1 -fsyntax-only -verify %s");
  }

  @Test
  public void test_block_cleanup_mm() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjCXX/block-cleanup.mm");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-apple-macosx10.11.0 -std=gnu++11 -o /dev/null -x objective-c++ -fblocks -ast-dump ${LLVM_SRC}/llvm/tools/clang/test/SemaObjCXX/block-cleanup.mm 2>&1 | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/SemaObjCXX/block-cleanup.mm
    RUN("%clang_cc1 -triple x86_64-apple-macosx10.11.0 -std=gnu++11 -o /dev/null -x objective-c++ -fblocks -ast-dump %s 2>&1")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_block_for_lambda_conversion_mm() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjCXX/block-for-lambda-conversion.mm");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -fblocks -verify -std=c++11 ${LLVM_SRC}/llvm/tools/clang/test/SemaObjCXX/block-for-lambda-conversion.mm
    RUN( "%clang_cc1 -fsyntax-only -fblocks -verify -std=c++11 %s");
  }

  @Test
  public void test_blocks_mm() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjCXX/blocks.mm");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -fblocks -Wno-objc-root-class ${LLVM_SRC}/llvm/tools/clang/test/SemaObjCXX/blocks.mm
    RUN("%clang_cc1 -fsyntax-only -verify -fblocks -Wno-objc-root-class %s");
  }

  @Test
  public void test_boxing_illegal_types_mm() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjCXX/boxing-illegal-types.mm");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -Wattributes ${LLVM_SRC}/llvm/tools/clang/test/SemaObjCXX/boxing-illegal-types.mm
    RUN("%clang_cc1 -fsyntax-only -verify -Wattributes %s");
  }

  @Test
  public void test_capturing_flexible_array_in_block_mm() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjCXX/capturing-flexible-array-in-block.mm");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -fblocks -verify -std=c++11 ${LLVM_SRC}/llvm/tools/clang/test/SemaObjCXX/capturing-flexible-array-in-block.mm
    RUN("%clang_cc1 -fsyntax-only -fblocks -verify -std=c++11 %s");
  }

  @Test
  public void test_category_lookup_mm() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjCXX/category-lookup.mm");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaObjCXX/category-lookup.mm
    RUN("%clang_cc1 -fsyntax-only -verify %s");
  }

  @Test
  public void test_composite_objc_pointertype_mm() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjCXX/composite-objc-pointertype.mm");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -Wno-objc-root-class ${LLVM_SRC}/llvm/tools/clang/test/SemaObjCXX/composite-objc-pointertype.mm
    RUN("%clang_cc1 -fsyntax-only -verify -Wno-objc-root-class %s");
  }

  @Test
  public void test_conditional_expr_mm() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjCXX/conditional-expr.mm");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaObjCXX/conditional-expr.mm
    RUN("%clang_cc1 -fsyntax-only -verify %s");
  }

  @Test
  public void test_const_cast_mm() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjCXX/const-cast.mm");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaObjCXX/const-cast.mm
    RUN("%clang_cc1 -fsyntax-only -verify %s");
  }

  @Test
  public void test_contextual_convert_to_id_mm() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjCXX/contextual-convert-to-id.mm");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c++11 -fsyntax-only ${LLVM_SRC}/llvm/tools/clang/test/SemaObjCXX/contextual-convert-to-id.mm -verify
    RUN("%clang_cc1 -std=c++11 -fsyntax-only %s -verify");
  }

  @Test
  public void test_conversion_ranking_mm() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjCXX/conversion-ranking.mm");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaObjCXX/conversion-ranking.mm
    RUN("%clang_cc1 -fsyntax-only -verify %s");
  }

  @Test
  public void test_conversion_to_objc_pointer_mm() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjCXX/conversion-to-objc-pointer.mm");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaObjCXX/conversion-to-objc-pointer.mm
    RUN("%clang_cc1 -fsyntax-only -verify %s");
  }

  @Test
  public void test_conversion_to_objc_pointer_2_mm() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjCXX/conversion-to-objc-pointer-2.mm");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaObjCXX/conversion-to-objc-pointer-2.mm
    RUN("%clang_cc1 -fsyntax-only -verify %s");
  }

  @Test
  public void test_crash_mm() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjCXX/crash.mm");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only ${LLVM_SRC}/llvm/tools/clang/test/SemaObjCXX/crash.mm -verify
    RUN("%clang_cc1 -fsyntax-only %s -verify");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -std=c++98 ${LLVM_SRC}/llvm/tools/clang/test/SemaObjCXX/crash.mm -verify
    RUN("%clang_cc1 -fsyntax-only -std=c++98 %s -verify");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -std=c++11 ${LLVM_SRC}/llvm/tools/clang/test/SemaObjCXX/crash.mm -verify
    RUN("%clang_cc1 -fsyntax-only -std=c++11 %s -verify");
  }

  @Test
  public void test_cstyle_block_pointer_cast_mm() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjCXX/cstyle-block-pointer-cast.mm");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -fblocks -Wno-objc-root-class ${LLVM_SRC}/llvm/tools/clang/test/SemaObjCXX/cstyle-block-pointer-cast.mm
    RUN("%clang_cc1 -fsyntax-only -verify -fblocks -Wno-objc-root-class %s");
  }

  @Test
  public void test_cstyle_cast_mm() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjCXX/cstyle-cast.mm");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaObjCXX/cstyle-cast.mm
    RUN("%clang_cc1 -fsyntax-only -verify %s");
  }

  @Test
  public void test_cxx1y_lambda_mm() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjCXX/cxx1y-lambda.mm");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c++1y -Wno-unused-value -fsyntax-only -verify -fobjc-arc ${LLVM_SRC}/llvm/tools/clang/test/SemaObjCXX/cxx1y-lambda.mm
    RUN("%clang_cc1 -std=c++1y -Wno-unused-value -fsyntax-only -verify -fobjc-arc %s");
  }

  @Test
  public void test_cxxoperator_selector_mm() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjCXX/cxxoperator-selector.mm");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -Wno-objc-root-class ${LLVM_SRC}/llvm/tools/clang/test/SemaObjCXX/cxxoperator-selector.mm
    RUN("%clang_cc1 -fsyntax-only -verify -Wno-objc-root-class %s");
  }

  @Test
  public void test_debugger_cast_result_to_id_mm() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjCXX/debugger-cast-result-to-id.mm");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c++11 -fdebugger-support -fdebugger-cast-result-to-id -funknown-anytype -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaObjCXX/debugger-cast-result-to-id.mm
    RUN("%clang_cc1 -std=c++11 -fdebugger-support -fdebugger-cast-result-to-id -funknown-anytype -fsyntax-only -verify %s");
  }

  @Test
  public void test_debugger_support_mm() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjCXX/debugger-support.mm");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fdebugger-support -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaObjCXX/debugger-support.mm
    RUN("%clang_cc1 -fdebugger-support -fsyntax-only -verify %s");
  }

  @Test
  public void test_decltype_mm() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjCXX/decltype.mm");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -std=c++11 ${LLVM_SRC}/llvm/tools/clang/test/SemaObjCXX/decltype.mm
    RUN("%clang_cc1 -fsyntax-only -verify -std=c++11 %s");
  }

  @Test
  public void test_deduction_mm() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjCXX/deduction.mm");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaObjCXX/deduction.mm
    RUN("%clang_cc1 -fsyntax-only -verify %s");
  }

  @Test
  public void test_delay_parsing_cfunctions_mm() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjCXX/delay-parsing-cfunctions.mm");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x objective-c++ -std=c++11 -fsyntax-only -Werror -verify -Wno-objc-root-class ${LLVM_SRC}/llvm/tools/clang/test/SemaObjCXX/delay-parsing-cfunctions.mm
    RUN("%clang_cc1 -x objective-c++ -std=c++11 -fsyntax-only -Werror -verify -Wno-objc-root-class %s");
  }

  @Test
  public void test_delay_parsing_cplusfuncs_mm() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjCXX/delay-parsing-cplusfuncs.mm");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x objective-c++ -fsyntax-only -Werror -verify -Wno-objc-root-class ${LLVM_SRC}/llvm/tools/clang/test/SemaObjCXX/delay-parsing-cplusfuncs.mm
    RUN("%clang_cc1 -x objective-c++ -fsyntax-only -Werror -verify -Wno-objc-root-class %s");
  }

  @Test
  public void test_delay_parsing_func_tryblock_mm() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjCXX/delay-parsing-func-tryblock.mm");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x objective-c++ -fcxx-exceptions -fsyntax-only -Werror -verify -Wno-objc-root-class ${LLVM_SRC}/llvm/tools/clang/test/SemaObjCXX/delay-parsing-func-tryblock.mm
    RUN("%clang_cc1 -x objective-c++ -fcxx-exceptions -fsyntax-only -Werror -verify -Wno-objc-root-class %s");
  }

  @Test
  public void test_dllexport_mm() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjCXX/dllexport.mm");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i686-windows -fdeclspec -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaObjCXX/dllexport.mm
    RUN("%clang_cc1 -triple i686-windows -fdeclspec -fsyntax-only -verify %s");
  }

  @Test
  public void test_dllimport_mm() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjCXX/dllimport.mm");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i686-windows -fdeclspec -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaObjCXX/dllimport.mm
    RUN("%clang_cc1 -triple i686-windows -fdeclspec -fsyntax-only -verify %s");
  }

  @Test
  public void test_exceptions_mm() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjCXX/exceptions.mm");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fcxx-exceptions -fexceptions -triple x86_64-apple-darwin11 -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaObjCXX/exceptions.mm
    RUN("%clang_cc1 -fcxx-exceptions -fexceptions  -triple x86_64-apple-darwin11 -fsyntax-only -verify %s");
  }

  @Test
  public void test_exceptions_fragile_mm() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjCXX/exceptions-fragile.mm");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fcxx-exceptions -fexceptions -fobjc-runtime=macosx-fragile-10.5 -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaObjCXX/exceptions-fragile.mm
    RUN("%clang_cc1 -fcxx-exceptions -fexceptions -fobjc-runtime=macosx-fragile-10.5 -fsyntax-only -verify %s");
  }

  @Test
  public void test_expr_objcxx_mm() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjCXX/expr-objcxx.mm");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/SemaObjCXX/expr-objcxx.mm -verify -pedantic -fsyntax-only
    RUN("%clang_cc1 %s -verify -pedantic -fsyntax-only");
  }

  @Test
  public void test_foreach_mm() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjCXX/foreach.mm");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -fblocks -verify -std=c++11 ${LLVM_SRC}/llvm/tools/clang/test/SemaObjCXX/foreach.mm
    RUN("%clang_cc1 -fsyntax-only -fblocks -verify -std=c++11 %s");
  }

  @Test
  public void test_foreach_block_mm() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjCXX/foreach-block.mm");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -fblocks ${LLVM_SRC}/llvm/tools/clang/test/SemaObjCXX/foreach-block.mm
    RUN("%clang_cc1 -fsyntax-only -verify -fblocks %s");
  }

  @Test
  public void test_format_strings_mm() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjCXX/format-strings.mm");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -Wformat-nonliteral -pedantic ${LLVM_SRC}/llvm/tools/clang/test/SemaObjCXX/format-strings.mm
    RUN("%clang_cc1 -fsyntax-only -verify -Wformat-nonliteral -pedantic %s");
  }

  @Test
  public void test_fragile_abi_object_assign_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjCXX/fragile-abi-object-assign.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x objective-c++ -triple x86_64-apple-darwin11 -fsyntax-only -fobjc-runtime=macosx-fragile-10.5 -verify -Wno-objc-root-class ${LLVM_SRC}/llvm/tools/clang/test/SemaObjCXX/fragile-abi-object-assign.m
    RUN("%clang_cc1 -x objective-c++ -triple x86_64-apple-darwin11 -fsyntax-only -fobjc-runtime=macosx-fragile-10.5 -verify -Wno-objc-root-class %s");
  }

  @Test
  public void test_function_pointer_void_star_mm() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjCXX/function-pointer-void-star.mm");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaObjCXX/function-pointer-void-star.mm
    RUN("%clang_cc1 -fsyntax-only -verify %s");
  }

  @Test
  public void test_gc_attributes_mm() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjCXX/gc-attributes.mm");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-apple-darwin10 -fobjc-gc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaObjCXX/gc-attributes.mm
    RUN("%clang_cc1 -triple x86_64-apple-darwin10 -fobjc-gc -fsyntax-only -verify %s");
  }

  @Test
  public void test_goto_mm() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjCXX/goto.mm");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -Wno-objc-root-class ${LLVM_SRC}/llvm/tools/clang/test/SemaObjCXX/goto.mm
    RUN("%clang_cc1 -fsyntax-only -verify -Wno-objc-root-class %s");
  }

  @Test
  public void test_instancetype_mm() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjCXX/instancetype.mm");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaObjCXX/instancetype.mm
    RUN("%clang_cc1 -fsyntax-only -verify %s");
  }

  @Test
  public void test_instantiate_expr_mm() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjCXX/instantiate-expr.mm");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaObjCXX/instantiate-expr.mm
    RUN("%clang_cc1 -fsyntax-only -verify %s");
  }

  @Test
  public void test_instantiate_message_mm() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjCXX/instantiate-message.mm");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaObjCXX/instantiate-message.mm
    RUN("%clang_cc1 -fsyntax-only -verify %s");
  }

  @Test
  public void test_instantiate_method_return_mm() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjCXX/instantiate-method-return.mm");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -Wno-objc-root-class ${LLVM_SRC}/llvm/tools/clang/test/SemaObjCXX/instantiate-method-return.mm
    RUN("%clang_cc1 -fsyntax-only -verify -Wno-objc-root-class %s");
  }

  @Test
  public void test_instantiate_property_access_mm() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjCXX/instantiate-property-access.mm");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaObjCXX/instantiate-property-access.mm
    RUN("%clang_cc1 -fsyntax-only -verify %s");
  }

  @Test
  public void test_instantiate_stmt_mm() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjCXX/instantiate-stmt.mm");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -fobjc-exceptions ${LLVM_SRC}/llvm/tools/clang/test/SemaObjCXX/instantiate-stmt.mm
    RUN("%clang_cc1 -fsyntax-only -verify -fobjc-exceptions %s");
  }

  @Test
  public void test_ivar_construct_mm() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjCXX/ivar-construct.mm");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -Wno-objc-root-class ${LLVM_SRC}/llvm/tools/clang/test/SemaObjCXX/ivar-construct.mm
    RUN("%clang_cc1 -fsyntax-only -verify -Wno-objc-root-class %s");
  }

  @Test
  public void test_ivar_lookup_mm() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjCXX/ivar-lookup.mm");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -Wno-objc-root-class ${LLVM_SRC}/llvm/tools/clang/test/SemaObjCXX/ivar-lookup.mm
    RUN("%clang_cc1 -fsyntax-only -verify -Wno-objc-root-class %s");
  }

  @Test
  public void test_ivar_reference_type_mm() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjCXX/ivar-reference-type.mm");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaObjCXX/ivar-reference-type.mm
    RUN("%clang_cc1 -fsyntax-only -verify %s");
  }

  @Test
  public void test_ivar_struct_mm() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjCXX/ivar-struct.mm");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaObjCXX/ivar-struct.mm
    RUN("%clang_cc1 -fsyntax-only -verify %s");
  }

  @Test
  public void test_linkage_spec_mm() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjCXX/linkage-spec.mm");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaObjCXX/linkage-spec.mm
    RUN("%clang_cc1 -fsyntax-only -verify %s");
  }

  @Test
  public void test_literals_mm() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjCXX/literals.mm");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -std=c++0x -fblocks ${LLVM_SRC}/llvm/tools/clang/test/SemaObjCXX/literals.mm
    RUN("%clang_cc1 -fsyntax-only -verify -std=c++0x -fblocks %s");
  }

  @Test
  public void test_message_mm() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjCXX/message.mm");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -fobjc-runtime=macosx-fragile-10.5 -verify -Wno-objc-root-class ${LLVM_SRC}/llvm/tools/clang/test/SemaObjCXX/message.mm
    RUN("%clang_cc1 -fsyntax-only -fobjc-runtime=macosx-fragile-10.5 -verify -Wno-objc-root-class %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -fobjc-runtime=macosx-fragile-10.5 -verify -Wno-objc-root-class -std=c++98 ${LLVM_SRC}/llvm/tools/clang/test/SemaObjCXX/message.mm
    RUN("%clang_cc1 -fsyntax-only -fobjc-runtime=macosx-fragile-10.5 -verify -Wno-objc-root-class -std=c++98 %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -fobjc-runtime=macosx-fragile-10.5 -verify -Wno-objc-root-class -std=c++11 ${LLVM_SRC}/llvm/tools/clang/test/SemaObjCXX/message.mm
    RUN("%clang_cc1 -fsyntax-only -fobjc-runtime=macosx-fragile-10.5 -verify -Wno-objc-root-class -std=c++11 %s");
  }

  @Test
  public void test_microsoft_abi_byval_mm() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjCXX/microsoft-abi-byval.mm");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -triple i386-pc-win32 -Wno-objc-root-class ${LLVM_SRC}/llvm/tools/clang/test/SemaObjCXX/microsoft-abi-byval.mm
    RUN("%clang_cc1 -fsyntax-only -verify -triple %ms_abi_triple -Wno-objc-root-class %s");
  }

  @Test
  public void test_missing_lhs_gun_extension_mm() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjCXX/missing-lhs-gun-extension.mm");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -std=c++11 ${LLVM_SRC}/llvm/tools/clang/test/SemaObjCXX/missing-lhs-gun-extension.mm
    RUN("%clang_cc1 -fsyntax-only -verify -std=c++11 %s");
  }

  @Test
  public void test_namespace_lookup_mm() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjCXX/namespace-lookup.mm");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaObjCXX/namespace-lookup.mm
    RUN("%clang_cc1 -fsyntax-only -verify %s");
  }

  @Test
  public void test_null_objc_pointer_mm() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjCXX/null_objc_pointer.mm");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -Wnull-arithmetic ${LLVM_SRC}/llvm/tools/clang/test/SemaObjCXX/null_objc_pointer.mm
    RUN("%clang_cc1 -fsyntax-only -verify -Wnull-arithmetic %s");
  }

  @Test
  public void test_nullability_consistency_mm() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjCXX/nullability-consistency.mm");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -fblocks -I ${LLVM_SRC}/llvm/tools/clang/test/SemaObjCXX/Inputs -isystem ${LLVM_SRC}/llvm/tools/clang/test/SemaObjCXX/Inputs/nullability-consistency-system ${LLVM_SRC}/llvm/tools/clang/test/SemaObjCXX/nullability-consistency.mm -verify
    RUN("%clang_cc1 -fsyntax-only -fblocks -I %S/Inputs -isystem %S/Inputs/nullability-consistency-system %s -verify");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -fblocks -I ${LLVM_SRC}/llvm/tools/clang/test/SemaObjCXX/Inputs -isystem ${LLVM_SRC}/llvm/tools/clang/test/SemaObjCXX/Inputs/nullability-consistency-system ${LLVM_SRC}/llvm/tools/clang/test/SemaObjCXX/nullability-consistency.mm -Wsystem-headers -DWARN_IN_SYSTEM_HEADERS -verify
    RUN("%clang_cc1 -fsyntax-only -fblocks -I %S/Inputs -isystem %S/Inputs/nullability-consistency-system %s -Wsystem-headers -DWARN_IN_SYSTEM_HEADERS -verify");
  }

  @Test
  public void test_nullability_pragmas_mm() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjCXX/nullability-pragmas.mm");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -fblocks -I ${LLVM_SRC}/llvm/tools/clang/test/SemaObjCXX/Inputs ${LLVM_SRC}/llvm/tools/clang/test/SemaObjCXX/nullability-pragmas.mm -verify
    RUN(TestState.Failed, "%clang_cc1 -fsyntax-only -fblocks -I %S/Inputs %s -verify");
  }

  @Test
  public void test_nullptr_mm() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjCXX/nullptr.mm");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c++11 -fblocks -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaObjCXX/nullptr.mm
    RUN("%clang_cc1 -std=c++11 -fblocks -fsyntax-only -verify %s");
  }

  @Test
  public void test_objc_boxed_expressions_nsvalue_mm() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjCXX/objc-boxed-expressions-nsvalue.mm");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -triple x86_64-apple-macosx10.9 -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaObjCXX/objc-boxed-expressions-nsvalue.mm
    RUN("%clang_cc1  -fsyntax-only -triple x86_64-apple-macosx10.9 -verify %s");
  }

  @Test
  public void test_objc_container_subscripting_mm() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjCXX/objc-container-subscripting.mm");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fblocks -triple x86_64-apple-darwin11 -fsyntax-only -std=c++11 -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaObjCXX/objc-container-subscripting.mm
    RUN(TestState.Failed, "%clang_cc1 -fblocks -triple x86_64-apple-darwin11 -fsyntax-only -std=c++11 -verify %s");
  }

  @Test
  public void test_objc_decls_inside_namespace_mm() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjCXX/objc-decls-inside-namespace.mm");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -Wno-objc-root-class ${LLVM_SRC}/llvm/tools/clang/test/SemaObjCXX/objc-decls-inside-namespace.mm
    RUN("%clang_cc1 -fsyntax-only -verify -Wno-objc-root-class %s");
  }

  @Test
  public void test_objc_extern_c_mm() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjCXX/objc-extern-c.mm");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaObjCXX/objc-extern-c.mm
    RUN("%clang_cc1 -fsyntax-only -verify %s");
  }

  @Test
  public void test_objc_pointer_conv_mm() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjCXX/objc-pointer-conv.mm");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -Wno-objc-root-class ${LLVM_SRC}/llvm/tools/clang/test/SemaObjCXX/objc-pointer-conv.mm
    RUN("%clang_cc1 -fsyntax-only -verify -Wno-objc-root-class %s");
  }

  @Test
  public void test_objc2_merge_gc_attribue_decl_mm() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjCXX/objc2-merge-gc-attribue-decl.mm");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i386-apple-darwin9 -fobjc-gc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaObjCXX/objc2-merge-gc-attribue-decl.mm
    RUN("%clang_cc1 -triple i386-apple-darwin9 -fobjc-gc -fsyntax-only -verify %s");
  }

  @Test
  public void test_objcbridge_attribute_mm() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjCXX/objcbridge-attribute.mm");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -x objective-c++ -fobjc-arc -verify -Wno-objc-root-class ${LLVM_SRC}/llvm/tools/clang/test/SemaObjCXX/objcbridge-attribute.mm
    RUN("%clang_cc1 -fsyntax-only -x objective-c++ -fobjc-arc -verify -Wno-objc-root-class %s");
  }

  @Test
  public void test_objcbridge_attribute_arc_mm() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjCXX/objcbridge-attribute-arc.mm");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -x objective-c++ -fobjc-arc -verify -Wno-objc-root-class ${LLVM_SRC}/llvm/tools/clang/test/SemaObjCXX/objcbridge-attribute-arc.mm
    RUN("%clang_cc1 -fsyntax-only -x objective-c++ -fobjc-arc -verify -Wno-objc-root-class %s");
  }

  @Test
  public void test_objcbridge_related_attribute_mm() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjCXX/objcbridge-related-attribute.mm");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -x objective-c++ -verify -Wno-objc-root-class ${LLVM_SRC}/llvm/tools/clang/test/SemaObjCXX/objcbridge-related-attribute.mm
    RUN("%clang_cc1 -fsyntax-only -x objective-c++ -verify -Wno-objc-root-class %s");
  }

  @Test
  public void test_objcbridge_static_cast_mm() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjCXX/objcbridge-static-cast.mm");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -x objective-c++ -fobjc-arc -verify -Wno-objc-root-class ${LLVM_SRC}/llvm/tools/clang/test/SemaObjCXX/objcbridge-static-cast.mm
    RUN("%clang_cc1 -fsyntax-only -x objective-c++ -fobjc-arc -verify -Wno-objc-root-class %s");
  }

  @Test
  public void test_old_style_cast_mm() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjCXX/old-style-cast.mm");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-apple-darwin11 -fsyntax-only -fobjc-arc -Wold-style-cast -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaObjCXX/old-style-cast.mm
    RUN("%clang_cc1 -triple x86_64-apple-darwin11 -fsyntax-only -fobjc-arc -Wold-style-cast -verify %s");
  }

  @Test
  public void test_overload_mm() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjCXX/overload.mm");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -Wno-objc-root-class ${LLVM_SRC}/llvm/tools/clang/test/SemaObjCXX/overload.mm
    RUN("%clang_cc1 -fsyntax-only -verify -Wno-objc-root-class %s");
  }

  @Test
  public void test_overload_gc_mm() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjCXX/overload-gc.mm");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -triple i386-apple-darwin9 -fobjc-gc -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaObjCXX/overload-gc.mm
    RUN("%clang_cc1 -fsyntax-only -triple i386-apple-darwin9 -fobjc-gc -verify %s");
  }

  @Test
  public void test_parameterized_classes_mm() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjCXX/parameterized_classes.mm");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c++11 ${LLVM_SRC}/llvm/tools/clang/test/SemaObjCXX/parameterized_classes.mm -verify
    RUN("%clang_cc1 -std=c++11 %s -verify");
  }

  @Test
  public void test_parameterized_classes_arc_mm() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjCXX/parameterized_classes_arc.mm");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fblocks -fobjc-arc -fobjc-runtime-has-weak ${LLVM_SRC}/llvm/tools/clang/test/SemaObjCXX/parameterized_classes_arc.mm -verify
    RUN("%clang_cc1 -fblocks -fobjc-arc -fobjc-runtime-has-weak %s -verify");
  }

  @Test
  public void test_parameterized_classes_subst_mm() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjCXX/parameterized_classes_subst.mm");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fblocks -fsyntax-only -std=c++11 ${LLVM_SRC}/llvm/tools/clang/test/SemaObjCXX/parameterized_classes_subst.mm -verify
    RUN(TestState.Failed, "%clang_cc1 -fblocks -fsyntax-only -std=c++11 %s -verify");
  }

  @Test
  public void test_parameters_mm() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjCXX/parameters.mm");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaObjCXX/parameters.mm
    RUN("%clang_cc1 -verify %s");
  }

  @Test
  public void test_pointer_to_objc_pointer_conv_mm() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjCXX/pointer-to-objc-pointer-conv.mm");
    // REQUIRES: LP64
    if (!CHECK_REQUIRES("LP64")) {
      return;
    }
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaObjCXX/pointer-to-objc-pointer-conv.mm
    RUN("%clang_cc1 -fsyntax-only -verify %s");
  }

  @Test
  public void test_propert_dot_error_mm() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjCXX/propert-dot-error.mm");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -Wno-objc-root-class ${LLVM_SRC}/llvm/tools/clang/test/SemaObjCXX/propert-dot-error.mm
    RUN("%clang_cc1 -fsyntax-only -verify -Wno-objc-root-class %s");
  }

  @Test
  public void test_properties_mm() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjCXX/properties.mm");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c++11 -fsyntax-only -verify -Wno-objc-root-class ${LLVM_SRC}/llvm/tools/clang/test/SemaObjCXX/properties.mm
    RUN("%clang_cc1 -std=c++11 -fsyntax-only -verify -Wno-objc-root-class %s");
  }

  @Test
  public void test_property_invalid_type_mm() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjCXX/property-invalid-type.mm");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -Wno-objc-root-class ${LLVM_SRC}/llvm/tools/clang/test/SemaObjCXX/property-invalid-type.mm
    RUN("%clang_cc1 -fsyntax-only -verify -Wno-objc-root-class %s");
  }

  @Test
  public void test_property_reference_mm() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjCXX/property-reference.mm");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x objective-c++ -triple x86_64-apple-darwin10 -fsyntax-only -verify -Wno-objc-root-class ${LLVM_SRC}/llvm/tools/clang/test/SemaObjCXX/property-reference.mm
    RUN("%clang_cc1 -x objective-c++ -triple x86_64-apple-darwin10 -fsyntax-only -verify -Wno-objc-root-class %s");
  }

  @Test
  public void test_property_synthesis_error_mm() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjCXX/property-synthesis-error.mm");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -Wno-objc-root-class ${LLVM_SRC}/llvm/tools/clang/test/SemaObjCXX/property-synthesis-error.mm
    RUN("%clang_cc1 -fsyntax-only -verify -Wno-objc-root-class %s");
  }

  @Test
  public void test_property_type_mismatch_mm() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjCXX/property-type-mismatch.mm");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaObjCXX/property-type-mismatch.mm
    RUN("%clang_cc1 -fsyntax-only -verify %s");
  }

  @Test
  public void test_protocol_lookup_mm() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjCXX/protocol-lookup.mm");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaObjCXX/protocol-lookup.mm
    RUN("%clang_cc1 -fsyntax-only -verify %s");
  }

  @Test
  public void test_pseudo_destructor_mm() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjCXX/pseudo-destructor.mm");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaObjCXX/pseudo-destructor.mm
    RUN("%clang_cc1 -fsyntax-only -verify %s");
  }

  @Test
  public void test_references_mm() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjCXX/references.mm");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -verify -o - ${LLVM_SRC}/llvm/tools/clang/test/SemaObjCXX/references.mm
    RUN("%clang_cc1 -verify -o - %s");
  }

  @Test
  public void test_reinterpret_cast_objc_pointertype_mm() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjCXX/reinterpret-cast-objc-pointertype.mm");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaObjCXX/reinterpret-cast-objc-pointertype.mm
    RUN("%clang_cc1 -fsyntax-only -verify %s");
  }

  @Test
  public void test_related_result_type_inference_mm() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjCXX/related-result-type-inference.mm");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaObjCXX/related-result-type-inference.mm
    RUN("%clang_cc1 -verify %s");
  }

  @Test
  public void test_reserved_keyword_methods_mm() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjCXX/reserved-keyword-methods.mm");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaObjCXX/reserved-keyword-methods.mm
    RUN("%clang_cc1 -fsyntax-only -verify %s");
  }

  @Test
  public void test_sel_address_mm() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjCXX/sel-address.mm");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaObjCXX/sel-address.mm
    RUN("%clang_cc1 -fsyntax-only -verify %s");
  }

  @Test
  public void test_standard_conversion_to_bool_mm() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjCXX/standard-conversion-to-bool.mm");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaObjCXX/standard-conversion-to-bool.mm
    RUN("%clang_cc1 -fsyntax-only -verify %s");
  }

  @Test
  public void test_static_cast_mm() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjCXX/static-cast.mm");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaObjCXX/static-cast.mm
    RUN("%clang_cc1 -fsyntax-only -verify %s");
  }

  @Test
  public void test_synchronized_mm() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjCXX/synchronized.mm");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -Wno-objc-root-class ${LLVM_SRC}/llvm/tools/clang/test/SemaObjCXX/synchronized.mm
    RUN("%clang_cc1 -fsyntax-only -verify -Wno-objc-root-class %s");
  }

  @Test
  public void test_typeloc_data_alignment_mm() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjCXX/typeloc-data-alignment.mm");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaObjCXX/typeloc-data-alignment.mm
    RUN("%clang_cc1 -fsyntax-only -verify %s");
  }

  @Test
  public void test_typo_correction_mm() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjCXX/typo-correction.mm");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/SemaObjCXX/typo-correction.mm -verify -fsyntax-only
    RUN("%clang_cc1 %s -verify -fsyntax-only");
  }

  @Test
  public void test_unknown_anytype_mm() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjCXX/unknown-anytype.mm");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fdebugger-support -funknown-anytype -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaObjCXX/unknown-anytype.mm
    RUN("%clang_cc1 -fdebugger-support -funknown-anytype -fsyntax-only -verify %s");
  }

  @Test
  public void test_vararg_non_pod_mm() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjCXX/vararg-non-pod.mm");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaObjCXX/vararg-non-pod.mm -Wno-error=non-pod-varargs
    RUN(TestState.Failed, "%clang_cc1 -fsyntax-only -verify %s -Wno-error=non-pod-varargs");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaObjCXX/vararg-non-pod.mm -Wno-error=non-pod-varargs -std=c++98
    RUN(TestState.Failed, "%clang_cc1 -fsyntax-only -verify %s -Wno-error=non-pod-varargs -std=c++98");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaObjCXX/vararg-non-pod.mm -Wno-error=non-pod-varargs -std=c++11
    RUN(TestState.Failed, "%clang_cc1 -fsyntax-only -verify %s -Wno-error=non-pod-varargs -std=c++11");
  }

  @Test
  public void test_vla_mm() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjCXX/vla.mm");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaObjCXX/vla.mm
    RUN("%clang_cc1 -fsyntax-only -verify %s");
  }

  @Test
  public void test_void_to_obj_mm() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjCXX/void_to_obj.mm");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -Wno-objc-root-class ${LLVM_SRC}/llvm/tools/clang/test/SemaObjCXX/void_to_obj.mm
    RUN("%clang_cc1 -fsyntax-only -verify -Wno-objc-root-class %s");
  }

  @Test
  public void test_warn_missing_super_mm() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjCXX/warn-missing-super.mm");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -std=c++11 ${LLVM_SRC}/llvm/tools/clang/test/SemaObjCXX/warn-missing-super.mm
    RUN("%clang_cc1 -fsyntax-only -verify -std=c++11 %s");
  }

  @Test
  public void test_warn_objc_literal_conversion_mm() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjCXX/warn-objc-literal-conversion.mm");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -Wobjc-literal-conversion ${LLVM_SRC}/llvm/tools/clang/test/SemaObjCXX/warn-objc-literal-conversion.mm
    RUN("%clang_cc1 -fsyntax-only -verify -Wobjc-literal-conversion %s");
  }

  @Test
  public void test_warn_strict_selector_match_mm() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaObjCXX/warn-strict-selector-match.mm");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -Wstrict-selector-match -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaObjCXX/warn-strict-selector-match.mm
    RUN("%clang_cc1  -Wstrict-selector-match -fsyntax-only -verify %s");
  }
  
}
